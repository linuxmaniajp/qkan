package jp.or.med.orca.qkan.tool;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACDBManagerCreatable;
import jp.nichicom.ac.core.ACDialogChaine;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceUnitGetter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACMessageBoxDialog;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001Service;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServiceKindList;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServicePanel;

public class QkanSCTester {
	public static class Builder {
		public String serviceKindDetail;
		public Date targetDate;
		public QS001Service servicePanel;
		public ACDBManager dbm;
		public Collection<VRMap> inputDataList;
		public File inputDataFile;
		public ACComboBox providerCombo;
		public QS001ServiceKindList serviceList;

		public Builder serviceKindDetail(String serviceKindDetail) {
			this.serviceKindDetail = serviceKindDetail;
			return this;
		}

		public Builder targetDate(Date targetDate) {
			this.targetDate = targetDate;
			return this;
		}

		public Builder servicePanel(QS001Service servicePanel) {
			this.servicePanel = servicePanel;
			return this;
		}

		public Builder dbm(ACDBManager dbm) {
			this.dbm = dbm;
			return this;
		}

		public Builder inputDataList(Collection<VRMap> inputDataList) {
			this.inputDataList = inputDataList;
			return this;
		}

		public Builder inputDataFile(File inputDataFile) {
			this.inputDataFile = inputDataFile;
			return this;
		}
		
		public Builder providerCombo(ACComboBox providerCombo) {
		    this.providerCombo = providerCombo;
		    return this;
		    
		}
		
	      public Builder serviceList(QS001ServiceKindList serviceList) {
	            this.serviceList = serviceList;
	            return this;
	            
	        }

		public QkanSCTester build() {
			if (serviceKindDetail == null) {
				throw new NullPointerException(
						"serviceKindDetail must not be null");
			}

			if (targetDate == null) {
				throw new NullPointerException("targetDate must not be null");
			}

			if (servicePanel == null) {
				throw new NullPointerException("servicePanel must not be null");
			}

			if (dbm == null) {
				throw new NullPointerException("dbm must not be null");
			}

			if (inputDataList == null) {
				if (inputDataFile == null) {
					throw new IllegalArgumentException("no input data passed");
				}

				inputDataList = parseTestDataFile(inputDataFile);
			}
			
			
			if (providerCombo == null) {
			    throw new NullPointerException("provider combobox must not be null");
			}
			
	         if (serviceList == null) {
	                throw new NullPointerException("serviceList combobox must not be null");
	         }

			return new QkanSCTester(this);
		}
	}

	private static class MessageBoxCloser extends Thread {
		private boolean running = true;

		public void stopRunning() {
			running = false;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				if (running) {
					Robot robot = new Robot();
					robot.waitForIdle();
					Object dlg = ACDialogChaine.getInstance().getLastItem(
							ACMessageBoxDialog.class);
					if (dlg instanceof ACMessageBoxDialog) {
						((ACMessageBoxDialog) dlg).getOKButton().requestFocus();
						robot.keyPress(KeyEvent.VK_SPACE);
						robot.keyRelease(KeyEvent.VK_SPACE);
						robot.waitForIdle();
					}
				}
			} catch (InterruptedException ex) {

			} catch (AWTException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static class Report {
		public static enum ReportType {
			SUCCESS, WARNING, FAILURE, ERROR 
		}

		private ReportType reportType;
		private VRMap input;
		private String message;

		public Report(ReportType reportType, VRMap input, String message) {
			this.reportType = reportType;
			this.input = input;
			this.message = message;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();

			sb.append("[");
			sb.append(input.get(SERVICE_NAME));
			sb.append("]");

			sb.append(" (");
			sb.append(reportType);
			sb.append(": ");
			sb.append(message);
			sb.append(")\n");

			sb.append(input.toString());

			return sb.toString();
		}
	}

	private static class FailureException extends Exception {
		private static final long serialVersionUID = 1L;

		public FailureException(String message) {
			super(message);
		}
	}
	
   private static class WarningException extends Exception {
        private static final long serialVersionUID = 1L;

        public WarningException(String message) {
            super(message);
        }
    }

	// �T�[�r�X����
	private static final String SERVICE_NAME = "SERVICE_NAME";
	// �T�[�r�X��ށE�ڍ�
	private static final String SYSTEM_SERVICE_KIND_DETAIL = "SYSTEM_SERVICE_KIND_DETAIL";
	// �T�[�r�X�p�r
	private static final String SERVICE_USE_TYPE = "SERVICE_USE_TYPE";
	// ���p��ID
	private static final String PATIENT_ID = "PATIENT_ID";
	// ���Ə�ID
	private static final String PROVIDER_ID = "PROVIDER_ID";
	// �T�[�r�X�񋟓�
	private static final String SERVICE_DATE = "SERVICE_DATE";
	// �v���x�@1-��Y��(����) 2-�o�ߓI�v��� 3-�v�x��1 4-�v�x��2 5-�v���1 6-�v���2 7-�v���3 8-�v���4
	// 9-�v���T
	private static final String YOKAIGODO = "1";
	// ���ʒn����Z�@1-���ʒn��łȂ� 2-���ʒn��ł���
	private static final String TOKUCHI_KASAN = "2";
	// �J�n����
	private static final String BEGIN_TIME = "3";
	// �I������
	private static final String END_TIME = "4";
	// 30�����@1-30�����łȂ� 2-30�����ł���
	// private static final String OVER_30DAYS = "5";
	// ���}���Z�@1-���}�Ȃ� 2-���}�Г� 3-���}����
	// private static final String SOUGEI_KASAN = "6";
	// ��������ҁ@1-��������҂łȂ� 2-��������҂ł���
	private static final String TOKUTEI_NYUSHOSHA = "7";
	// ���[�u�����ҋ敪�@1-���[�u�����҂łȂ� 2-���[�u�����҂ł���
	 private static final String KYUSOCHI = "8";
	// �P�Ɖ��Z�t���O�@1-��{�P�ʂ��܂� 2-�P�Ɖ��Z�̂�
	private static final String TANDOKU_KASAN = "9";
	// �T�[�r�X�p�^�[���̃\�[�g��
	private static final String SERVICE_PATTERN_SORT = "10";
	// �T�[�r�X�p�^�[���ύX�㖼��
	private static final String SERVICE_PATTERN_NAME = "11";
	// ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z 1-�Ȃ� 2-����
	// private static final String CHUSANKAN_SERVICE_KASAN = "12";
	// ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə��ł��邩 1-���R�Ԓn��łȂ��@2-���R�Ԓn��ł���
	private static final String CHUSANKAN_JIGYOSHO_KASAN = "13";
	// �T�[�r�X�@�����敪 20090401-����21�N4���@�����Ȍ�
	private static final String AFTER_20090401 = "14";
	// �{�[�󎚋敪�@1-�{�[�Ɉ󎚂��Ȃ� 2-�{�[�Ɉ󎚂���
	private static final String HONPYO_INJI = "15";
	
	// �������P
	private static final String IMPROVE_THE_TREATMENT = "17";
	
	// �T�P�ʈȊO�̃T�[�r�X�̊��ԁ@��M_CODE.CODE_ID=25�̃f�[�^���i�[����B
	private static final String SHUTANI_IGAI = "101";

	// �p�l������擾�ł��Ȃ��o�C���h�p�X�̏W���i��r�ΏۊO�Ƃ���j
	// ���J�n�����A�I�������̓p�l������擾�ł��邪�T�[�r�X�R�[�h�����Ɋ֗^���Ȃ����ߔ�r�ΏۊO�Ƃ���
	private static final Set<String> excludeKeys = new HashSet<String>();
	{
		excludeKeys.addAll(Arrays.asList(SERVICE_NAME,
				SYSTEM_SERVICE_KIND_DETAIL, SERVICE_USE_TYPE, PATIENT_ID,
				PROVIDER_ID, SERVICE_DATE, YOKAIGODO, TOKUCHI_KASAN,
				BEGIN_TIME, END_TIME, TOKUTEI_NYUSHOSHA, TANDOKU_KASAN,
				SERVICE_PATTERN_SORT, SERVICE_PATTERN_NAME,
				CHUSANKAN_JIGYOSHO_KASAN, AFTER_20090401, HONPYO_INJI,
				IMPROVE_THE_TREATMENT,SHUTANI_IGAI,KYUSOCHI));
	}

	private String serviceKindDetail;
	private Date targetDate;
	private QS001ServicePanel servicePanel;
	private QS001Service service;
	private ACDBManager dbm;
	private Collection<VRMap> inputDataList;
	private Qkan10011_ServiceUnitGetter ug;
	private ACComboBox providerCombo;

	private QkanSCTester(Builder builder) {
		servicePanel = (QS001ServicePanel) builder.servicePanel;
		service = builder.servicePanel;
		dbm = builder.dbm;
		serviceKindDetail = builder.serviceKindDetail;
		targetDate = builder.targetDate;
		inputDataList = builder.inputDataList;
		providerCombo = builder.providerCombo;
	}

	public String execute() throws Exception {
		ug = Qkan10011_ServiceCodeManager.getInstance().getService(
				serviceKindDetail, targetDate);
		ug.setSysYmd(targetDate);

		int success = 0, failure = 0, error = 0, warning = 0;
		List<Report> reports = new ArrayList<Report>();

		for (VRMap input : inputDataList) {
		    
		    // �T�[�r�X�I��
//		    if (input.containsKey("SYSTEM_SERVICE_KIND_DETAIL")) {
//		        VRMap service = (VRMap)serviceList.getSelectedValue();
//		        if (!service.get("SYSTEM_SERVICE_KIND_DETAIL").equals(input.get("SYSTEM_SERVICE_KIND_DETAIL"))){
//		            
//		            for (int i = 0; i < serviceList.getItemCount(); i++) {
//		                service = (VRMap)serviceList.getItemAt(i);
//		                if (service.get("SYSTEM_SERVICE_KIND_DETAIL").toString().equals(input.get("SYSTEM_SERVICE_KIND_DETAIL"))){
//		                    serviceList.setSelectedIndex(i);
//		                    return "�T�[�r�X��I�����Ȃ������̂ōĎ��s";
//		                }
//		            }
//		        }
//		    }
		    
		    
		    // ���Ə��I��
		    if (input.containsKey("PROVIDER_ID")) {
		        VRMap provider = (VRMap)providerCombo.getSelectedItem();
		        if (!provider.get("PROVIDER_ID").equals(input.get("PROVIDER_ID"))){
		            
		            for (int i = 0; i < providerCombo.getModel().getSize(); i++ ){
		                provider = (VRMap)providerCombo.getModel().getElementAt(i);
		                if (provider.get("PROVIDER_ID").equals(input.get("PROVIDER_ID"))){
  		                    providerCombo.setSelectedItem(provider);
		                    break;
		                }
		            }
		        }
		    }
		    
			try {
 				check(input);
				success++;
			} catch (FailureException ex) {
				reports.add(new Report(Report.ReportType.FAILURE, input, ex
						.getMessage()));
				failure++;
				
			} catch (WarningException ex) {
                reports.add(new Report(Report.ReportType.WARNING, input, ex
                        .getMessage()));
                warning++;
			} catch (Exception ex) {
				reports.add(new Report(Report.ReportType.ERROR, input, ex
						.getMessage()));
				error++;
			}
		}

		for (Report report : reports) {
			System.out.println(report);
			System.out.println();
		}
		
        System.out.println("-----------------------------");
        System.out.printf("Total: %d, Success: %d, Warning %d, Failure: %d, Error: %d\n",
                inputDataList.size(), success, warning, failure, error);
        System.out.println("-----------------------------");
        System.out.println();
        
        String ret = String.format("Total: %d, Success: %d, Warning %d, Failure: %d, Error: %d\n",
                inputDataList.size(), success, warning, failure, error);
        
        
        if (inputDataList.size() == (success + warning)) {
            ret += "\n<<< ALL CLEAR >>>";
        }

        return ret;
		
		
	}


	private void check(VRMap input) throws Exception {

		// �f�[�^���p�l���֗^����
		// ���J�n�����A�I�������͈ꗥ�����l���Z�b�g
		VRBindPathParser.set(BEGIN_TIME, input, new Date());
		VRBindPathParser.set(END_TIME, input, new Date());
		servicePanel.setSource(input);
		servicePanel.bindSource();

		// �p�l������f�[�^�����o��
 		VRMap data = getValidData();
		if (data == null) {
			throw new FailureException("�p�l������f�[�^���擾�ł��܂���ł����B");
		}

		// ���o�����f�[�^�Ɠ��̓f�[�^����v���邩�m�F����
		// ��r�ΏۊO�̃L�[�����O����
		if (!isMatchMap(minimized(input), minimized(data))) {
			throw new FailureException("���̓f�[�^�Ǝ擾�f�[�^�ɍ�������܂��B");
		}

		// �T�[�r�X�R�[�h�𐶐����ړI�̃R�[�h����������邩�m�F����
		
		
		
		ArrayList<VRMap> serviceCodeList = ug.getServiceCode(createServiceDetail(input, data), dbm);
		
        if (serviceCodeList.size() == 0 ) {
            throw new FailureException("�T�[�r�X�R�[�h����������܂���ł����B");
        }
		
 		if (!isCorrectCode(input, serviceCodeList)) {
            StringBuilder msg = new StringBuilder("�ړI�̃T�[�r�X�R�[�h����������܂���ł����B\n");
            for (VRMap codeData : serviceCodeList) {
                msg.append(codeData.toString() + "\n");
            }
            
            throw new FailureException(msg.toString());
		}
 		
        if (serviceCodeList.size() > 2 ) {
            StringBuilder msg = new StringBuilder("�T�[�r�X�R�[�h��3���ȏ㐶������܂����B\n");
            for (VRMap codeData : serviceCodeList) {
                msg.append(codeData.toString() + "\n");
            }
            
            throw new WarningException(msg.toString());
        }
 		
	}

	private static VRMap minimized(Map<String, Object> src) throws Exception {
		VRMap minimizedMap = new VRHashMap();
		for (String key : src.keySet()) {
			if (!excludeKeys.contains(key)) {
				VRBindPathParser.set(key, minimizedMap, src.get(key));
			}
		}
		return minimizedMap;
	}
	
	private static VRMap createServiceDetail(Map<String, Object> input, Map<String, Object> data) throws Exception {
        VRMap serviceDetail = new VRHashMap();
        
        for (String key : data.keySet()) {
            VRBindPathParser.set(key, serviceDetail, data.get(key));
        }
        
        for (String key : input.keySet()) {
            if (excludeKeys.contains(key)) {
                VRBindPathParser.set(key, serviceDetail, input.get(key));
            }
        }
        return serviceDetail;
	}

	private static boolean isMatchMap(Map<String, Object> testData, Map<String, Object> panelData) throws Exception {
		Set<String> keysTestData = testData.keySet();
		Set<String> keysPanelData = panelData.keySet();
		
		// �e�X�g�f�[�^���A�p�l������擾�����f�[�^�̕����傫���ꍇ�͕s��
		if (keysTestData.size() < keysPanelData.size()) {
		    throw new FailureException("���̓f�[�^�Ǝ擾�f�[�^�ɍ�������܂��B(�f�[�^�T�C�Y�s��v)�F\n"+ "�z��l�F" + testData.toString() + "\n���ʁF" + panelData.toString());
		}

		if (!keysTestData.containsAll(keysPanelData)) {
		    throw new FailureException("���̓f�[�^�Ǝ擾�f�[�^�ɍ�������܂��B(�L�[���ڕs��v)�F\n"+ "�z��l�F" + testData.toString() + "\n���ʁF" + panelData.toString());
		}

		for (String key : keysPanelData) {
			Object objA = testData.get(key);
			Object objB = panelData.get(key);

			if (objA instanceof Integer && objB instanceof Integer) {
				int valA = (Integer) objA;
				int valB = (Integer) objB;
				if (valA != valB) {
				    throw new FailureException("���̓f�[�^�Ǝ擾�f�[�^�ɍ�������܂��B(�L�[:" + key + "�@�z��l�F" + valA + "�@���ʁF" + valB + ")");
				}
			} else if (objA instanceof String && objB instanceof String) {
				String valA = (String) objA;
				String valB = (String) objB;
				if (!valA.equals(valB)) {
				    throw new FailureException("���̓f�[�^�Ǝ擾�f�[�^�ɍ�������܂��B(�L�[:" + key + "�@�z��l�F" + valA + "�@���ʁF" + valB + ")");
				}
			} else if (objA instanceof Date && objB instanceof Date) {
				Date valA = (Date) objA;
				Date valB = (Date) objB;
				if (valA.getTime() != valB.getTime()) {
				    throw new FailureException("���̓f�[�^�Ǝ擾�f�[�^�ɍ�������܂��B(�L�[:" + key + "�@�z��l�F" + valA + "�@���ʁF" + valB + ")");
				}
			} else if (objA != objB) {
			    throw new FailureException("���̓f�[�^�Ǝ擾�f�[�^�ɍ�������܂��B(�L�[:" + key + "�@�z��l�F" + objA + "�@���ʁF" + objB + ")");
			}
		}

		return true;
	}

	private static boolean isCorrectCode(VRMap input, ArrayList<VRMap> codeList) {
		String targetCodeName = (String) input.get(SERVICE_NAME);

		for (VRMap codeData : codeList) {
			if (targetCodeName.equals(codeData.get(SERVICE_NAME)))
				return true;
		}

		return false;
	}

	private VRMap getValidData() throws Exception {
		MessageBoxCloser th = new MessageBoxCloser();
		th.start();

		VRMap data = service.getValidData();

		if (th.isAlive()) {
			th.stopRunning();
		} else {
			return null;
		}

		return data;
	}

	private static List<VRMap> parseTestDataFile(File file) {

		List<VRMap> dataList = new ArrayList<VRMap>();
		BufferedReader reader = null;

		try {

			Date defaultDate = VRDateParser.parse(Integer
					.toString(QkanConstants.SERVICE_LOW_VERSION_H2404));

			reader = new BufferedReader(new FileReader(file));
			String line;
			String[] tempData;

			VRMap temp = new VRHashMap();
			while ((line = reader.readLine()) != null) {

				if ("".equals(line) || line == null) {

					dataList.add(temp);
					temp = new VRHashMap();

				} else {

					// 0: bindpath, 1: detailname, 2: datatype, 3: value
					tempData = line.split("\",\"");
					String systemBindPath = tempData[0].substring(1);
					String dataType = tempData[2];
					String value = tempData[3].substring(0,
							tempData[3].length() - 1);

					if ("1".equals(dataType)) {
						VRBindPathParser.set(systemBindPath, temp, new Integer(
								Integer.parseInt(value)));
					} else if ("2".equals(dataType)) {
						VRBindPathParser.set(systemBindPath, temp, value);
					} else if ("3".equals(dataType)) {
						VRBindPathParser.set(systemBindPath, temp, defaultDate);
					}

				}

			}

		} catch (FileNotFoundException e) {
			// �t�@�C�������݂��Ȃ�
			System.out.println("�t�@�C�������݂��܂���B");
		} catch (Exception e) {
			System.out.println("�G���[���N���܂����B");
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {

			}
		}

		return dataList;
	}
	
	
	
	// �P�ƋN���ňꊇ���s
	public static void main(String[] args) {
	    
	    PrintWriter pw = null;
	    
	    
        try {
            
            pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Develop\\ruby\\testresult.txt")));
            
            pw.println("==========" + VRDateParser.format(new Date(), "yyyy-MM-dd hh:mm:dd") + "�F�e�X�g�J�n==========");
            
            ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
            ACDBManager dbm = ((ACDBManagerCreatable) ACFrame.getInstance().getFrameEventProcesser()).createDBManager();
            
            File dir = new File("C:\\Develop\\ruby\\all");
            //File dir = new File("C:\\Develop\\ruby\\single");
            Date targetDate = VRDateParser.parse(String.valueOf(QkanConstants.SERVICE_LOW_VERSION_H2404));
            
            
            for (File f :dir.listFiles() ){
                
                pw.println("==========" + VRDateParser.format(new Date(), "yyyy-MM-dd hh:mm:dd") + ":" + f.getName() + "�̃e�X�g�J�n==========");
                
                List<VRMap> datas =  parseTestDataFile(f);
                
                String serviceKindDetail = datas.get(0).get("SYSTEM_SERVICE_KIND_DETAIL").toString();
                
                Qkan10011_ServiceUnitGetter ug = Qkan10011_ServiceCodeManager.getInstance().getService(
                        serviceKindDetail, targetDate);
                ug.setSysYmd(targetDate);
                
                for (VRMap data : datas) {
                    ArrayList<VRMap> serviceCodeList = ug.getServiceCode(data, dbm);
                    
                    if (serviceCodeList.size() == 0 ) {
                        pw.println("�������Ftarget(" + data.get("SERVICE_NAME") + ")");
                        continue;
                    }
                    
                    if (!isCorrectCode(data, serviceCodeList)) {
                        
                        StringBuilder msg = new StringBuilder("�^�[�Q�b�g���X�g�Ftarget(" + data.get("SERVICE_NAME") + ")�Fresult(");
                        for (VRMap codeData : serviceCodeList) {
                            msg.append(codeData.get("SERVICE_NAME") + ",");
                        }
                        msg.append(")");
                        pw.println(msg.toString());
                        continue;
                    }
                    
                }
                
                pw.println("==========" + VRDateParser.format(new Date(), "yyyy-MM-dd hh:mm:dd") + ":" + f.getName() + "�̃e�X�g�I��==========");
                
            }
            pw.println("==========" + VRDateParser.format(new Date(), "yyyy-MM-dd hh:mm:dd") + "�F�e�X�g�I��==========");
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            
            if (pw != null) {
                pw.close();
            }
            
        }
	}

}
