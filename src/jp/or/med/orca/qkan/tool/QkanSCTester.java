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

	// サービス名称
	private static final String SERVICE_NAME = "SERVICE_NAME";
	// サービス種類・詳細
	private static final String SYSTEM_SERVICE_KIND_DETAIL = "SYSTEM_SERVICE_KIND_DETAIL";
	// サービス用途
	private static final String SERVICE_USE_TYPE = "SERVICE_USE_TYPE";
	// 利用者ID
	private static final String PATIENT_ID = "PATIENT_ID";
	// 事業所ID
	private static final String PROVIDER_ID = "PROVIDER_ID";
	// サービス提供日
	private static final String SERVICE_DATE = "SERVICE_DATE";
	// 要介護度　1-非該当(自立) 2-経過的要介護 3-要支援1 4-要支援2 5-要介護1 6-要介護2 7-要介護3 8-要介護4
	// 9-要介護５
	private static final String YOKAIGODO = "1";
	// 特別地域加算　1-特別地域でない 2-特別地域である
	private static final String TOKUCHI_KASAN = "2";
	// 開始時刻
	private static final String BEGIN_TIME = "3";
	// 終了時刻
	private static final String END_TIME = "4";
	// 30日超　1-30日超でない 2-30日超である
	// private static final String OVER_30DAYS = "5";
	// 送迎加算　1-送迎なし 2-送迎片道 3-送迎往復
	// private static final String SOUGEI_KASAN = "6";
	// 特定入所者　1-特定入所者でない 2-特定入所者である
	private static final String TOKUTEI_NYUSHOSHA = "7";
	// 旧措置入所者区分　1-旧措置入所者でない 2-旧措置入所者である
	 private static final String KYUSOCHI = "8";
	// 単独加算フラグ　1-基本単位も含む 2-単独加算のみ
	private static final String TANDOKU_KASAN = "9";
	// サービスパターンのソート順
	private static final String SERVICE_PATTERN_SORT = "10";
	// サービスパターン変更後名称
	private static final String SERVICE_PATTERN_NAME = "11";
	// 中山間地域等でのサービス提供加算 1-なし 2-あり
	// private static final String CHUSANKAN_SERVICE_KASAN = "12";
	// 中山間地域等における小規模事業所であるか 1-中山間地域でない　2-中山間地域である
	private static final String CHUSANKAN_JIGYOSHO_KASAN = "13";
	// サービス法改正区分 20090401-平成21年4月法改正以後
	private static final String AFTER_20090401 = "14";
	// 本票印字区分　1-本票に印字しない 2-本票に印字する
	private static final String HONPYO_INJI = "15";
	
	// 処遇改善
	private static final String IMPROVE_THE_TREATMENT = "17";
	
	// 週単位以外のサービスの期間　※M_CODE.CODE_ID=25のデータを格納する。
	private static final String SHUTANI_IGAI = "101";

	// パネルから取得できないバインドパスの集合（比較対象外とする）
	// ※開始時刻、終了時刻はパネルから取得できるがサービスコード生成に関与しないため比較対象外とする
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
		    
		    // サービス選択
//		    if (input.containsKey("SYSTEM_SERVICE_KIND_DETAIL")) {
//		        VRMap service = (VRMap)serviceList.getSelectedValue();
//		        if (!service.get("SYSTEM_SERVICE_KIND_DETAIL").equals(input.get("SYSTEM_SERVICE_KIND_DETAIL"))){
//		            
//		            for (int i = 0; i < serviceList.getItemCount(); i++) {
//		                service = (VRMap)serviceList.getItemAt(i);
//		                if (service.get("SYSTEM_SERVICE_KIND_DETAIL").toString().equals(input.get("SYSTEM_SERVICE_KIND_DETAIL"))){
//		                    serviceList.setSelectedIndex(i);
//		                    return "サービスを選択しなおしたので再実行";
//		                }
//		            }
//		        }
//		    }
		    
		    
		    // 事業所選択
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

		// データをパネルへ与える
		// ※開始時刻、終了時刻は一律初期値をセット
		VRBindPathParser.set(BEGIN_TIME, input, new Date());
		VRBindPathParser.set(END_TIME, input, new Date());
		servicePanel.setSource(input);
		servicePanel.bindSource();

		// パネルからデータを取り出す
 		VRMap data = getValidData();
		if (data == null) {
			throw new FailureException("パネルからデータを取得できませんでした。");
		}

		// 取り出したデータと入力データが一致するか確認する
		// 比較対象外のキーを除外する
		if (!isMatchMap(minimized(input), minimized(data))) {
			throw new FailureException("入力データと取得データに差があります。");
		}

		// サービスコードを生成し目的のコードが生成されるか確認する
		
		
		
		ArrayList<VRMap> serviceCodeList = ug.getServiceCode(createServiceDetail(input, data), dbm);
		
        if (serviceCodeList.size() == 0 ) {
            throw new FailureException("サービスコードが生成されませんでした。");
        }
		
 		if (!isCorrectCode(input, serviceCodeList)) {
            StringBuilder msg = new StringBuilder("目的のサービスコードが生成されませんでした。\n");
            for (VRMap codeData : serviceCodeList) {
                msg.append(codeData.toString() + "\n");
            }
            
            throw new FailureException(msg.toString());
		}
 		
        if (serviceCodeList.size() > 2 ) {
            StringBuilder msg = new StringBuilder("サービスコードが3件以上生成されました。\n");
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
		
		// テストデータより、パネルから取得したデータの方が大きい場合は不正
		if (keysTestData.size() < keysPanelData.size()) {
		    throw new FailureException("入力データと取得データに差があります。(データサイズ不一致)：\n"+ "想定値：" + testData.toString() + "\n結果：" + panelData.toString());
		}

		if (!keysTestData.containsAll(keysPanelData)) {
		    throw new FailureException("入力データと取得データに差があります。(キー項目不一致)：\n"+ "想定値：" + testData.toString() + "\n結果：" + panelData.toString());
		}

		for (String key : keysPanelData) {
			Object objA = testData.get(key);
			Object objB = panelData.get(key);

			if (objA instanceof Integer && objB instanceof Integer) {
				int valA = (Integer) objA;
				int valB = (Integer) objB;
				if (valA != valB) {
				    throw new FailureException("入力データと取得データに差があります。(キー:" + key + "　想定値：" + valA + "　結果：" + valB + ")");
				}
			} else if (objA instanceof String && objB instanceof String) {
				String valA = (String) objA;
				String valB = (String) objB;
				if (!valA.equals(valB)) {
				    throw new FailureException("入力データと取得データに差があります。(キー:" + key + "　想定値：" + valA + "　結果：" + valB + ")");
				}
			} else if (objA instanceof Date && objB instanceof Date) {
				Date valA = (Date) objA;
				Date valB = (Date) objB;
				if (valA.getTime() != valB.getTime()) {
				    throw new FailureException("入力データと取得データに差があります。(キー:" + key + "　想定値：" + valA + "　結果：" + valB + ")");
				}
			} else if (objA != objB) {
			    throw new FailureException("入力データと取得データに差があります。(キー:" + key + "　想定値：" + objA + "　結果：" + objB + ")");
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
			// ファイルが存在しない
			System.out.println("ファイルが存在しません。");
		} catch (Exception e) {
			System.out.println("エラーが起きました。");
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
	
	
	
	// 単独起動で一括実行
	public static void main(String[] args) {
	    
	    PrintWriter pw = null;
	    
	    
        try {
            
            pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Develop\\ruby\\testresult.txt")));
            
            pw.println("==========" + VRDateParser.format(new Date(), "yyyy-MM-dd hh:mm:dd") + "：テスト開始==========");
            
            ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
            ACDBManager dbm = ((ACDBManagerCreatable) ACFrame.getInstance().getFrameEventProcesser()).createDBManager();
            
            File dir = new File("C:\\Develop\\ruby\\all");
            //File dir = new File("C:\\Develop\\ruby\\single");
            Date targetDate = VRDateParser.parse(String.valueOf(QkanConstants.SERVICE_LOW_VERSION_H2404));
            
            
            for (File f :dir.listFiles() ){
                
                pw.println("==========" + VRDateParser.format(new Date(), "yyyy-MM-dd hh:mm:dd") + ":" + f.getName() + "のテスト開始==========");
                
                List<VRMap> datas =  parseTestDataFile(f);
                
                String serviceKindDetail = datas.get(0).get("SYSTEM_SERVICE_KIND_DETAIL").toString();
                
                Qkan10011_ServiceUnitGetter ug = Qkan10011_ServiceCodeManager.getInstance().getService(
                        serviceKindDetail, targetDate);
                ug.setSysYmd(targetDate);
                
                for (VRMap data : datas) {
                    ArrayList<VRMap> serviceCodeList = ug.getServiceCode(data, dbm);
                    
                    if (serviceCodeList.size() == 0 ) {
                        pw.println("未生成：target(" + data.get("SERVICE_NAME") + ")");
                        continue;
                    }
                    
                    if (!isCorrectCode(data, serviceCodeList)) {
                        
                        StringBuilder msg = new StringBuilder("ターゲットロスト：target(" + data.get("SERVICE_NAME") + ")：result(");
                        for (VRMap codeData : serviceCodeList) {
                            msg.append(codeData.get("SERVICE_NAME") + ",");
                        }
                        msg.append(")");
                        pw.println(msg.toString());
                        continue;
                    }
                    
                }
                
                pw.println("==========" + VRDateParser.format(new Date(), "yyyy-MM-dd hh:mm:dd") + ":" + f.getName() + "のテスト終了==========");
                
            }
            pw.println("==========" + VRDateParser.format(new Date(), "yyyy-MM-dd hh:mm:dd") + "：テスト終了==========");
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            
            if (pw != null) {
                pw.close();
            }
            
        }
	}

}
