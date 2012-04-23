package jp.or.med.orca.qkan.tool;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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

        final JButton clearServicePanelButton = new JButton("パネル初期化");
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

        final JButton strongfySelectedRadioButton = new JButton("選択ラジオ強調");
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

        final JButton fileChooseButton = new JButton("ファイル選択");
        fileChooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        });
        add(fileChooseButton);

        final JTextField targetDateTextField = new JTextField(
                Integer.toString(QkanConstants.SERVICE_LOW_VERSION_H2404));
        add(targetDateTextField);

        final JButton testServiceCodePanelButton = new JButton("パネルテスト");
        testServiceCodePanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputFile == null) {
                    ACMessageBox.show("テストデータファイルが読み込まれていません。");
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

                    ACMessageBox.show("テストが終了しました。\n" + msg);
                }
            }
        });
        add(testServiceCodePanelButton);

        final JTextArea codeTextArea = new JTextArea(3, 10);

        final JButton createCodeButton = new JButton("コード生成");
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
                    for (VRMap row : serviceCodeList) {
                        sb.append(row.get("SERVICE_CODE_KIND"));
                        sb.append("-");
                        sb.append(row.get("SERVICE_CODE_ITEM"));
                        sb.append(":(");
                        sb.append(row.get("SERVICE_UNIT"));
                        sb.append(")\n");
                        sb.append(row.get("SERVICE_NAME"));
                        sb.append("\n");
                    }

                    codeTextArea.setText(sb.toString());
                } catch (Exception ex) {
                    codeTextArea.setText(ex.getMessage());
                }
            }
        });
        add(createCodeButton);

        add(codeTextArea);

        final JButton providerServiceButton = new JButton("事業所サービス設定");

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
                                // TODO 自動生成された catch ブロック
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
                    text.setText("管理者");
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
        String[] patientName = qs001.getPatientName().getText().split("　");

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
        sql.append(" AND (PATIENT_NINTEI_HISTORY.INSURE_VALID_START <= '"
                + targetDateStr + "')");
        sql.append(" AND (PATIENT_NINTEI_HISTORY.INSURE_VALID_END >= '"
                + targetDateStr + "')");

        VRMap ret = (VRMap) dbm.executeQuery(sql.toString()).get(0);

        // 要介護度
        VRBindPathParser.set("1", params, ret.get("JOTAI_CODE"));

        // 特定入所者
        VRBindPathParser.set("7", params, ret.get("TOKUTEI_NYUSHO_FLAG"));

        // 旧措置入所者
        if (!params.containsKey("8")) {
            VRBindPathParser.set("8", params, ret.get("KYUSOCHI_FLAG"));
        }

        VRMap providerInfo = (VRMap) qs001.getServiceOfferEntrepreneur()
                .getSelectedItem();

        // 特別地域加算
        VRBindPathParser
                .set("2", params, providerInfo.get("SPECIAL_AREA_FLAG"));

        // 中山間地域
        String chu = "1";
        if ((ACCastUtilities.toInt(providerInfo.get("2"), 0) == 2)
                && (ACCastUtilities.toInt(providerInfo.get("3"), 0) == 2)) {
            chu = "2";
        }
        VRBindPathParser.set("13", params, chu);

        // 介護職員処遇改善加算
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
                    // 「なし」以外の場合
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
