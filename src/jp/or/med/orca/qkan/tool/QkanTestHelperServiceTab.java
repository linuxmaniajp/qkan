package jp.or.med.orca.qkan.tool;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceUnitGetter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindable;
import jp.nichicom.vr.component.VRRadioButtonGroup;
import jp.nichicom.vr.component.VRTextField;
import jp.nichicom.vr.container.VRLabelContainer;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.qo.qo004.QO004;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001Design;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001Service;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServiceKindList;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class QkanTestHelperServiceTab extends JPanel {
    private static final long serialVersionUID = 1L;

    private static final QkanTestHelperServiceTab INSTANCE = new QkanTestHelperServiceTab();

    private static File inputFile;
    private static final JFileChooser fileChooser = new JFileChooser(new File(
            "."));

    private QkanTestHelperServiceTab() {
        super();
        initComponents();
    }

    public static QkanTestHelperServiceTab getInstance() {
        return INSTANCE;
    }

    private void initComponents() {

        final JButton clearServicePanelButton = new JButton("�p�l��������");
        clearServicePanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component panel = getServicePanel();
                if (panel != null) {
                    QkanCommon.selectFirstRadioItem(panel);
                }
            }
        });
        add(clearServicePanelButton);

        final JButton strongfySelectedRadioButton = new JButton("�I�����W�I����");
        strongfySelectedRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component panel = getServicePanel();
                if (panel != null) {
                    strongfySelectedRadioRecur(panel);
                }
            }
        });
        add(strongfySelectedRadioButton);

        final JButton fileChooseButton = new JButton("�t�@�C���I��");
        fileChooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        });
        add(fileChooseButton);

        final JTextField targetDateTextField = new JTextField(
                Integer.toString(QkanConstants.SERVICE_LOW_VERSION_H2704));
        add(targetDateTextField);

        final JButton testServiceCodePanelButton = new JButton("�p�l���e�X�g");
        testServiceCodePanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputFile == null) {
                    ACMessageBox.show("�e�X�g�f�[�^�t�@�C�����ǂݍ��܂�Ă��܂���B");
                    return;
                }

                PrintStream ps = null;
                String msg = "";

                try {
                    // set output stream
                    System.setOut(System.out);
                    // ps = new PrintStream(new
                    // FileOutputStream("test.log"));
                    // System.setOut(ps);

                    QkanSCTester.Builder builder = new QkanSCTester.Builder();
                    msg = builder
                            .dbm(QkanTestHelper.getDBManager())
                            .servicePanel((QS001Service) getServicePanel())
                            .providerCombo(getProviderComboBox())
                            .serviceList(getServiceList())
                            .targetDate(
                                    VRDateParser.parse(targetDateTextField
                                            .getText()))
                            .serviceKindDetail(getServiceKindDetailCode())
                            .inputDataFile(inputFile).build().execute();
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                    msg = ex.getMessage();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    msg = ex.getMessage();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    msg = ex.getMessage();
                } finally {
                    System.setOut(System.out);

                    try {
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (Exception ex) {

                    }

                    ACMessageBox.show("�e�X�g���I�����܂����B\n" + msg);
                }
            }
        });
        add(testServiceCodePanelButton);

        final JTextArea codeTextAreaPrev = new JTextArea(3, 15);
        final JTextPane codeTextArea = new JTextPane();
        codeTextArea.setSize(3, 15);
        codeTextArea.setFont(new Font("�l�r �S�V�b�N", Font.PLAIN, 11));
//        final JScrollPane scroll = new JScrollPane(editor);


        final JButton createCodeButton = new JButton("�R�[�h����");
        createCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Date targetDate = VRDateParser.parse(targetDateTextField
                            .getText());

                    VRMap data = ((QS001Service) getServicePanel())
                            .getValidData();

                    setParams(data, QkanTestHelper.getDBManager(), targetDate);

                    Qkan10011_ServiceUnitGetter ug = Qkan10011_ServiceCodeManager
                            .getInstance().getService(
                                    getServiceKindDetailCode(), targetDate);
                    ug.setSysYmd(targetDate);

                    ArrayList<VRMap> serviceCodeList = ug.getServiceCode(data,
                            QkanTestHelper.getDBManager());

                    StringBuilder sb = new StringBuilder();
                    boolean kihonExistsFlg = false;
                    for (VRMap row : serviceCodeList) {
                    	String sysServiceCodeItem = String.valueOf(row.get("SYSTEM_SERVICE_CODE_ITEM"));
                    	String serviceMainFlg = String.valueOf(row.get("SERVICE_MAIN_FLAG"));
                    	String serviceAddFlg = String.valueOf(row.get("SERVICE_ADD_FLAG"));
                    	String shoguWariai = String.valueOf(row.get("SERVICE_STAFF_UNIT"));
                    	
                    	String serviceAddName = "";
                    	if ("1".equals(serviceAddFlg)) {
                    		serviceAddName = "(�P��)";
                    	} else if ("2".equals(serviceAddFlg)) {
                    		serviceAddName = "(�P�ʉ��Z)";
                    	} else if ("3".equals(serviceAddFlg)) {
                    		serviceAddName = "(�����Z)";
                    	} else if ("4".equals(serviceAddFlg)) {
                    		serviceAddName = "(�P�ʌ��Z)";
                    	} else if ("5".equals(serviceAddFlg)) {
                    		serviceAddName = "(�����Z)";
                    	} else if ("6".equals(serviceAddFlg)) {
                    		serviceAddName = "(�����Z-�n���-)";
                    	} else if ("7".equals(serviceAddFlg)) {
                    		serviceAddName = "(�����Z-�n���-)";
                    	} else if ("8".equals(serviceAddFlg)) {
                    		serviceAddName = "(�������P)" + shoguWariai;
                    	} else if ("9".equals(serviceAddFlg)) {
                    		serviceAddName = "(�~)";
                    	}
                    	String totalGroupingType = String.valueOf(row.get("TOTAL_GROUPING_TYPE"));
                    	String totalGroupingName = "";
                    	if ("1".equals(totalGroupingType)) {
                    		totalGroupingName = "(��)";
                    	} else if ("2".equals(totalGroupingType)) {
                    		totalGroupingName = "(��)";
                    	} else if ("3".equals(totalGroupingType)) {
                    		totalGroupingName = "(��)";
                    	}
                    	
                    	String svName = "";
                    	if ("1".equals(serviceMainFlg)) {
                    		kihonExistsFlg = true;
                    		svName = "����{";
                    	} else {
                    		svName = "�����Z";
                    		if ("4".equals(serviceAddFlg)) {
                    			svName = "�����Z";
                    		}
                    		if ("6".equals(serviceAddFlg)) {
                    			svName = "�����Z";
                    		}
                    		if ("8".equals(serviceAddFlg)) {
                    			svName = "������";
                    		}
                    	}
                    	
                    	String disp = serviceAddName + totalGroupingName;
                    	
                    	sb.append("\n ------ " + svName + " --------- " + disp + " - \n");
                        sb.append(row.get("SERVICE_CODE_KIND"));
                        sb.append("-");
                        sb.append(row.get("SERVICE_CODE_ITEM"));
                        sb.append(":(");
                        sb.append(row.get("SERVICE_UNIT"));
                        sb.append(")\n");
                        sb.append(row.get("SERVICE_NAME"));
                        //sb.append("\n");
                    }
                    if (!kihonExistsFlg) {
                    	sb.append("\n ------------------------------------ \n");
                    	sb.append("������{�T�[�r�X���擾�ł��܂���ł���");
                    	sb.append("\n ------------------------------------ \n");
                    }

                    codeTextArea.setText("");
                    
                    String cur = sb.toString();
                    String pre = codeTextAreaPrev.getText();
                    
                    //�O�ƌ�납��O��ƈႤ�����ʒu�����߂�
                    int unmatchSt = getUnmatchIndex(pre, cur, true);
                    int unmatchEd = getUnmatchIndex(pre, cur, false);
                    
                    if (unmatchSt > unmatchEd) {
                    	unmatchSt = unmatchEd + 1;
                    }
                    
                    if (unmatchSt > 0) {
                    	append(cur.substring(0, unmatchSt), Color.BLACK);
                    }
                    
                    if (unmatchSt >= 0 && unmatchEd < cur.length()) {
                    	append(cur.substring(unmatchSt, unmatchEd + 1), Color.RED);
                    }

                    if ((unmatchEd >= 0) && (unmatchEd + 1 < cur.length())) {
                    	append(cur.substring(unmatchEd + 1), Color.BLUE);
                    }
                    
                    if (unmatchSt == -1 && unmatchEd == -1) {
                    	//���S��v
                    	append(cur, Color.BLACK);
                    } else if (unmatchSt == -1 && unmatchEd >= 0) {
                    	//�O�������v
                    	append(cur, Color.BLUE);
                    } else if (unmatchSt >= 0 && unmatchEd == -1) {
                    	//��������v
                    	append(cur, Color.BLUE);
                    } 
                    
                    codeTextAreaPrev.setText(cur);
                    
                } catch (Exception ex) {
                	codeTextArea.setText(ex.getMessage());
                }
                
                
            }
        	/**
        	 * JTextPane�ɐF�t���������ǉ�����B
        	 *
        	 * @param	 str	�ǉ����镶����
        	 * @param fg	������̐F
        	 */
            private void append(String str, Color fg) {
        		SimpleAttributeSet attr = new SimpleAttributeSet();
        	//	attr.addAttribute(StyleConstants.Foreground, fg);
        		StyleConstants.setForeground(attr, fg);

        		Document doc = codeTextArea.getDocument();
        		if (doc != null) {
        			try {
        				doc.insertString(doc.getLength(), str, attr);
        			} catch (BadLocationException e) {
        			}
        		}
        	}
        	
            //�Q�̕�������r���A�قȂ镶���ʒu�����߂�
            //isPrefix true:�O������T���Afalse:�������T��
        	private int getUnmatchIndex(String str1, String str2, boolean isPrefix) {
        		int result = -1;
        		if(str1 == null || str2 == null) {
        			return result;
        		}
        		char[] array1 = str1.toCharArray();
        		char[] array2 = str2.toCharArray();
        		
        		
        		if (isPrefix) {
            		for (int i = 0; i < array2.length; i++) {
            			if ((i >= array1.length) || (i >= array2.length) || (array1[i] != array2[i])) {
            				result = i;
            				break;
            			}
            		}
        		} else {
            		for (int i = 1; i <= array2.length; i++) {
            			int array1Idx = array1.length - i;
            			int array2Idx = array2.length - i;
            			if ((array1Idx < 0) || (array2Idx < 0) || (array1[array1Idx] != array2[array2Idx])) {
            				result = array2Idx;
            				break;
            			}
            		}
        		}
        		return result;
        	}
        });
        add(createCodeButton);

//        add(codeTextAreaPrev);
		add(codeTextArea);
		
		

        final JButton providerServiceButton = new JButton("���Ə��T�[�r�X�ݒ�");

        providerServiceButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Component c = getProvider();
                if (c != null) {
                    int tableRow = ((QO004) c).getServiceKindTable()
                            .getRowCount();

                    for (int i = 0; i < tableRow; i++) {
                        ((QO004) c).getServiceKindTable().setSelectedSortedRow(
                                i);
                        if (!((QO004) c).getOfferCheck().isSelected()) {
                            try {
                                ((QO004) c).getOfferCheck().setSelected(true);
                                setProviderValue(((QO004) c)
                                        .getProviderDetailServiceDetails());
                                ((QO004) c).reflect();
                            } catch (Exception e1) {
                                // TODO �����������ꂽ catch �u���b�N
                                e1.printStackTrace();
                            }
                        }
                    }
                }

            }
        });

        add(providerServiceButton);
    }

    private static void setProviderValue(Component target) {
        if (target instanceof VRRadioButtonGroup) {
            String bindPath = ((VRBindable) target).getBindPath();
            if (bindPath != null) {
                VRRadioButtonGroup radioGroup = (VRRadioButtonGroup) target;
                if (bindPath == "4") {
                    radioGroup.setSelectedIndex(2);
                }
            }
        } else if (target instanceof ACTextField) {
            String bindPath = ((VRBindable) target).getBindPath();
            if (bindPath != null) {
                if (bindPath == "1130103") {
                    VRTextField text = (VRTextField) target;
                    text.setText("�Ǘ���");
                }
            }

        } else if (target instanceof Container) {
            int end = ((Container) target).getComponentCount();
            for (int i = 0; i < end; i++) {
                setProviderValue(((Container) target).getComponent(i));
            }
        }
    }

    private static Component getProvider() {
        ACAffairable nowPanel = QkanTestHelper.getNowPanel();

        if (nowPanel instanceof QO004) {
            return (QO004) nowPanel;
        }

        return null;
    }

    private static Component getServicePanel() {
        ACAffairable nowPanel = QkanTestHelper.getNowPanel();

        if (nowPanel instanceof QS001Design) {
            Component c = ((QS001Design) nowPanel).getServiceContentSettings()
                    .getComponent(0);
            if (c != null && c instanceof QS001Service) {
                return c;
            }
        }

        return null;
    }

    private static String getServiceKindDetailCode() {
        ACAffairable nowPanel = QkanTestHelper.getNowPanel();

        if (nowPanel instanceof QS001Design) {
            QS001Design qs001 = (QS001Design) nowPanel;
            Object kindItem = qs001.getServiceKindList().getSelectedValue();
            if (kindItem instanceof VRMap) {
                return ((VRMap) kindItem).get("SYSTEM_SERVICE_KIND_DETAIL")
                        .toString();
            }
        }

        return null;
    }

    private static void setParams(VRMap params, ACDBManager dbm, Date targetDate)
            throws Exception {

        ACAffairable nowPanel = QkanTestHelper.getNowPanel();

        if (!(nowPanel instanceof QS001Design)) {
            return;
        }

        QS001Design qs001 = (QS001Design) nowPanel;

        String targetDateStr = VRDateParser.format(targetDate, "yyyy/MM/dd");

        String patientId = qs001.getPatientInsuredID().getText();
        String[] patientName = qs001.getPatientName().getText().split("�@");

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT");
        sql.append(" PATIENT_NINTEI_HISTORY.JOTAI_CODE,");
        sql.append(" PATIENT_SHISETSU_HISTORY.TOKUTEI_NYUSHO_FLAG,");
        sql.append(" PATIENT_SHISETSU_HISTORY.KYUSOCHI_FLAG");
        sql.append(" FROM");
        sql.append(" PATIENT_NINTEI_HISTORY");
        sql.append(" LEFT OUTER JOIN");
        sql.append(" PATIENT");
        sql.append(" ON");
        sql.append(" (PATIENT.PATIENT_ID = PATIENT_NINTEI_HISTORY.PATIENT_ID)");
        sql.append(" AND (PATIENT.PATIENT_FAMILY_NAME = '" + patientName[0]
                + "')");
        sql.append(" AND (PATIENT.PATIENT_FIRST_NAME = '" + patientName[1]
                + "')");
        sql.append(" LEFT OUTER JOIN");
        sql.append(" PATIENT_SHISETSU_HISTORY");
        sql.append(" ON");
        sql.append(" (PATIENT.PATIENT_ID = PATIENT_SHISETSU_HISTORY.PATIENT_ID)");
        sql.append(" WHERE");
        sql.append(" (PATIENT_NINTEI_HISTORY.INSURED_ID = '" + patientId + "')");
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//        sql.append(" AND (PATIENT_NINTEI_HISTORY.INSURE_VALID_START <= '"
//                + targetDateStr + "')");
//        sql.append(" AND (PATIENT_NINTEI_HISTORY.INSURE_VALID_END >= '"
//                + targetDateStr + "')");
        sql.append(" AND (PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START <= '"
                + targetDateStr + "')");
        sql.append(" AND (PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_END >= '"
                + targetDateStr + "')");
        sql.append(" ORDER BY PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START DESC");
// 2014/12/17 [Yoichiro Kamei] mod - end
        
        VRList list = dbm.executeQuery(sql.toString());
        
        if (list.isEmpty()) {
        	throw new RuntimeException("�v���x�̎擾�Ɏ��s.");
        }
        VRMap ret = (VRMap) list.get(0);

        // �v���x
        VRBindPathParser.set("1", params, ret.get("JOTAI_CODE"));

        // ���������
        VRBindPathParser.set("7", params, ret.get("TOKUTEI_NYUSHO_FLAG"));

        // ���[�u������
        if (!params.containsKey("8")) {
            VRBindPathParser.set("8", params, ret.get("KYUSOCHI_FLAG"));
        }

        VRMap providerInfo = (VRMap) qs001.getServiceOfferEntrepreneur()
                .getSelectedItem();

        // ���ʒn����Z
        VRBindPathParser
                .set("2", params, providerInfo.get("SPECIAL_AREA_FLAG"));

        // ���R�Ԓn��
        String chu = "1";
        if ((ACCastUtilities.toInt(providerInfo.get("2"), 0) == 2)
                && (ACCastUtilities.toInt(providerInfo.get("3"), 0) == 2)) {
            chu = "2";
        }
        VRBindPathParser.set("13", params, chu);

        // ���E���������P���Z
        VRBindPathParser.set(Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN,
                params, providerInfo.get("4"));

        VRBindPathParser.set("PROVIDER_ID", params,
                providerInfo.get("PROVIDER_ID"));

    }

    private static ACComboBox getProviderComboBox() {

        ACAffairable nowPanel = QkanTestHelper.getNowPanel();

        if (!(nowPanel instanceof QS001Design)) {
            return null;
        }

        QS001Design qs001 = (QS001Design) nowPanel;
        return qs001.getServiceOfferEntrepreneur();

    }

    private static QS001ServiceKindList getServiceList() {

        ACAffairable nowPanel = QkanTestHelper.getNowPanel();

        if (!(nowPanel instanceof QS001Design)) {
            return null;
        }

        QS001Design qs001 = (QS001Design) nowPanel;
        return qs001.getServiceKindList();

    }

    private static void strongfySelectedRadioRecur(Component target) {
        if (target instanceof VRRadioButtonGroup) {
            String bindPath = ((VRBindable) target).getBindPath();
            if (bindPath != null) {
                VRRadioButtonGroup radioGroup = (VRRadioButtonGroup) target;
                int index = radioGroup.getSelectedIndex();
                VRLabelContainer labelContainer = (VRLabelContainer) radioGroup
                        .getParent();
                if (index > 1) {
                    // �u�Ȃ��v�ȊO�̏ꍇ
                    labelContainer.setForeground(Color.RED);
                } else {
                    labelContainer.setForeground(Color.BLACK);
                }
            }
        } else if (target instanceof Container) {
            int end = ((Container) target).getComponentCount();
            for (int i = 0; i < end; i++) {
                strongfySelectedRadioRecur(((Container) target).getComponent(i));
            }
        }
    }

    private void chooseFile() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            inputFile = fileChooser.getSelectedFile();
        }
    }
    
    


}
