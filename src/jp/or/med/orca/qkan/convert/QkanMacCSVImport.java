package jp.or.med.orca.qkan.convert;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.File;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextArea;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairContainer;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACDefaultFrameEventProcesser;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.filechooser.ACFileChooser;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.bridge.sql.BridgeFirebirdDBManager;
import jp.nichicom.vr.io.VRCSVFile;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;

public class QkanMacCSVImport extends ACAffairContainer implements ACAffairable {

    private ACPanel contents = null;
    private ACLabel message = null;
    private ACPanel buttons = null;
    private ACButton execute = null;
    private ACButton exit = null;
    private ACPanel settings = null;
    private ACTextField sourceDirectory = null;
    private ACButton sourceBrowse = null;
    private ACGroupBox sourceDirectorys = null;

    public QkanMacCSVImport() throws HeadlessException {
        super();
        initialize();
    }

    /**
     * This method initializes buttons
     * 
     * @return javax.swing.JPanel
     */
    private ACPanel getButtons() {
        if (buttons == null) {
            buttons = new ACPanel();
            buttons.add(getExit(), VRLayout.EAST);
            buttons.add(getExecute(), VRLayout.EAST);
        }
        return buttons;
    }

    /**
     * This method initializes execute
     * 
     * @return javax.swing.JButton
     */
    private ACButton getExecute() {
        if (execute == null) {
            execute = new ACButton();
            execute.setText("���s(E)");
            execute.setMnemonic('E');
            execute.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    executeImport();
                }
            });
        }
        return execute;
    }

    /**
     * �f�[�^�ڍs�����s���܂��B
     */
    protected void executeImport() {
        // �f�[�^�ڍs�����s�\���`�F�b�N���܂��B
        File dir = new File(getSourceDirectory().getText());
        if ((dir == null) || (!dir.isDirectory())) {
            ACMessageBox.showExclamation("�u�ڍs��CSV�t�@�C���̏ꏊ�v���s���ł��B"
                    + ACConstants.LINE_SEPARATOR + "�u�ڍs��CSV�t�@�C���̏ꏊ�v���w�肵�Ă��������B");
            getSourceDirectory().requestFocus();
            return;
        }
        boolean repeated = false;
        File[] files = dir.listFiles();
        patietFile = null;
        ninteiFile = null;
        staffFile = null;
        insurerFile = null;
        providerFile = null;
        kyotakuRyoyoFile = null;
        homonKangoPlanFile = null;
        homonKangoResultFile = null;
        int end = files.length;
        for (int i = 0; i < end; i++) {
            File f = files[i];
            String name = f.getName();
            if (name == null) {
                name = "";
            } else {
                name = name.toUpperCase();
            }
            if ((name != null) && name.startsWith("SJS")) {
                if (name.endsWith("PATIENT.CSV")) {
                    // ���p�ҏ��FPATIENT
                    if (patietFile != null) {
                        repeated = true;
                    } else {
                        patietFile = f;
                    }
                } else if (name.endsWith("NINTEI.CSV")) {
                    // ���p�җv�����FNINTEI
                    if (ninteiFile != null) {
                        repeated = true;
                    } else {
                        ninteiFile = f;
                    }
                } else if (name.endsWith("STAFF.CSV")) {
                    // �S���ҏ��FSTAFF
                    if (staffFile != null) {
                        repeated = true;
                    } else {
                        staffFile = f;
                    }
                } else if (name.endsWith("INSURER.CSV")) {
                    // �ی��ҏ��FINSURER
                    if (insurerFile != null) {
                        repeated = true;
                    } else {
                        insurerFile = f;
                    }
                } else if (name.endsWith("PROVIDER.CSV")) {
                    // ���Ə����FPROVIDER
                    if (providerFile != null) {
                        repeated = true;
                    } else {
                        providerFile = f;
                    }
                } else if (name.endsWith("RYOYO.CSV")) {
                    // ����×{�Ǘ��w�����FKYOTAKU_RYOYO
                    if (kyotakuRyoyoFile != null) {
                        repeated = true;
                    } else {
                        kyotakuRyoyoFile = f;
                    }
                } else if (name.endsWith("PLAN.CSV")) {
                    // �K��Ō�v�揑�FHOMONKANGO_PLAN
                    if (homonKangoPlanFile != null) {
                        repeated = true;
                    } else {
                        homonKangoPlanFile = f;
                    }
                } else if (name.endsWith("RESULT.CSV")) {
                    // �K��Ō�񍐏��FHOMONKANGO_RESULT
                    if (homonKangoResultFile != null) {
                        repeated = true;
                    } else {
                        homonKangoResultFile = f;
                    }
                }
            }
        }
        if (repeated) {
            ACMessageBox.showExclamation("2�g�ȏ�̈ڍs���f�[�^�����݂��܂��B"
                    + ACConstants.LINE_SEPARATOR
                    + "�u�ڍs��CSV�t�@�C���̏ꏊ�v�̃t�@�C�����������񂷂ׂč폜���A�ēx�ڍs���f�[�^���o�͂��Ă��������B");
            return;
        }

        // �ڍs����f�[�^���ꗗ��
        boolean fileExists = false;
        StringBuffer sb = new StringBuffer();
        if (patietFile != null) {
            sb.append("�@�E���p�ҏ��");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }
        if (ninteiFile != null) {
            sb.append("�@�E���p�җv�����");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }
        if (staffFile != null) {
            sb.append("�@�E�S���ҏ��");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }
        if (insurerFile != null) {
            sb.append("�@�E�ی��ҏ��");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }
        if (providerFile != null) {
            sb.append("�@�E���Ə����");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }
        if (kyotakuRyoyoFile != null) {
            sb.append("�@�E����×{�Ǘ��w����");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }
        if (homonKangoPlanFile != null) {
            sb.append("�@�E�K��Ō�v�揑");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }
        if (homonKangoResultFile != null) {
            sb.append("�@�E�K��Ō�񍐏�");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }

        if (!fileExists) {
            ACMessageBox.showExclamation("�ڍs����CSV�t�@�C�������݂��܂���B"
                    + ACConstants.LINE_SEPARATOR
                    + "�u�ڍs��CSV�t�@�C���̏ꏊ�v�̃t�@�C�����������񂷂ׂč폜���A�ēx�ڍs���f�[�^���o�͂��Ă��������B");
            return;
        }

        dbm = null;
        try {
            dbm = new BridgeFirebirdDBManager();
            if (!dbm.canConnect()) {
                throw new Exception("�f�[�^�x�[�X�֐ڑ��ł��܂���B");
            }
        } catch (Exception ex) {
            VRLogger.info(ex.getStackTrace());
            ACMessageBox.showExclamation("�f�[�^�x�[�X�֐ڑ��ł��܂���B"
                    + ACConstants.LINE_SEPARATOR
                    + "���ǒ��{�̂��N�����A�f�[�^�x�[�X�̐ݒ���s���Ă��������B");
            return;
        }

        if (ACMessageBox
                .showOkCancel("�ȉ��̃f�[�^�ڍs���J�n���܂��B��낵���ł����H"
                        + ACConstants.LINE_SEPARATOR
                        + ACConstants.LINE_SEPARATOR + sb.toString()
                        + ACConstants.LINE_SEPARATOR
                        + "�y�����Ӂ��z�ڍs��̃f�[�^�͂��ׂď�������܂��B"
                        + ACConstants.LINE_SEPARATOR
                        + "�@�@�@�@�@�@�K�����O�Ƀo�b�N�A�b�v������Ă��������B"
                        + ACConstants.LINE_SEPARATOR
                        + "�@�@�@�@�@�@���ڍs��(���o�[�W����)�̃f�[�^�ɉe���͂���܂���B",
                        ACMessageBox.FOCUS_CANCEL) != ACMessageBox.RESULT_OK) {
            return;
        }

        errorCount = 0;

        getExecute().setEnabled(false);
        new Thread(new Runnable() {
            public void run() {
                try {
                    setProgressTitle("�@�f�[�^�ڍs��..");
                    setProgress("[�����f�[�^�̍폜]");
                    VRCSVFile f = new VRCSVFile("dummy", VRCSVFile.SJIS);
                    // �K��Ō�񍐏�
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM HOMONKANGO_RESULT");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM HOMONKANGO_RESULT_CALENDAR");
                    // �K��Ō�v�揑
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM HOMONKANGO_PLAN");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM HOMONKANGO_PLAN_NOTE");
                    // �ی���
                    errorCount += executeUpdate(dbm, "DELETE FROM INSURER");
                    errorCount += executeUpdate(dbm, "DELETE FROM PATIENT_KOHI");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM INSURER_LIMIT_RATE");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM INSURER_LIMIT_RATE_DETAIL");
                    // ����×{�Ǘ��w����
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM KYOTAKU_RYOYO");
                    // ���p�ҏ��
                    errorCount += executeUpdate(dbm, "DELETE FROM PATIENT");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PATIENT_CHANGES_HISTORY");
                    errorCount += executeUpdate(dbm, "DELETE FROM PATIENT_KOHI");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PATIENT_KOHI_SERVICE");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PATIENT_MEDICAL_HISTORY");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PATIENT_SHISETSU_HISTORY");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PATIENT_STATION_HISTORY");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PATIENT_NINTEI_HISTORY");
                    // �K��Ō���񋟏�
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM HOMONKANGO_JOHO_TEIKYOSHO");
                    // �K��Ō�L�^��
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM HOMONKANGO_KIROKUSHO");
                    // ���Ə�
                    errorCount += executeUpdate(dbm, "DELETE FROM PROVIDER");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PROVIDER_MENU");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PROVIDER_SERVICE");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PROVIDER_SERVICE_DETAIL_DATE");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PROVIDER_SERVICE_DETAIL_INTEGER");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PROVIDER_SERVICE_DETAIL_TEXT");
                    // �S����
                    errorCount += executeUpdate(dbm, "DELETE FROM STAFF");
                    // �T�[�r�X
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM SERVICE_PASSIVE_CHECK");
                    try {
                        dbm.beginTransaction();
                        QkanCommon.updateServiceDetailCustom(dbm,
                                new VRArrayList(), null, "");
                        dbm.commitTransaction();
                    } catch (Exception ex) {
                        VRLogger.info(ex);
                        try {
                            dbm.rollbackTransaction();
                        } catch (Exception ex2) {
                            VRLogger.info(ex2);
                        }
                        errorCount++;
                    }
                    // ����
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM CLAIM_PATIENT_DETAIL");
                    try {
                        dbm.beginTransaction();
                        QkanCommon.updateClaimDetailCustom(dbm,
                                new VRArrayList(), null, "");
                        dbm.commitTransaction();
                    } catch (Exception ex) {
                        VRLogger.info(ex);
                        try {
                            dbm.rollbackTransaction();
                        } catch (Exception ex2) {
                            VRLogger.info(ex2);
                        }
                        errorCount++;
                    }
                    // ���Ə����
                    List providers = new ArrayList();
                    if (providerFile != null) {
                        f.setPath(providerFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importProvider(dbm, f, providers));
                    }

                    // �ی��ҏ��
                    if (insurerFile != null) {
                        f.setPath(insurerFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importInsurer(dbm, f));
                    }

                    // ���p�ҏ��
                    if (patietFile != null) {
                        f.setPath(patietFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importPatient(dbm, f));
                    }

                    // ���p�ҔF�藚��
                    if (ninteiFile != null) {
                        f.setPath(ninteiFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importPatientNinteiHistory(dbm, f, providers));
                    }

                    // �X�^�b�t���
                    if (staffFile != null) {
                        f.setPath(staffFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importStaff(dbm, f));
                    }

                    // ����×{�Ǘ��w����
                    if (kyotakuRyoyoFile != null) {
                        f.setPath(kyotakuRyoyoFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importKyotakuRyoyo(dbm, f));
                    }
                    // �K��Ō�v�揑
                    if (homonKangoPlanFile != null) {
                        f.setPath(homonKangoPlanFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importHomonPlan(dbm, f));
                    }
                    // �K��Ō�񍐏�
                    if (homonKangoResultFile != null) {
                        f.setPath(homonKangoResultFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importHomonResult(dbm, f));
                    }

                    if (errorCount > 0) {
                        ACMessageBox.show("�f�[�^�ڍs���������܂����B"
                                + ACConstants.LINE_SEPARATOR + " " + errorCount
                                + " ���̈ڍs�Ɏ��s���Ă��܂��B" + ACConstants.LINE_SEPARATOR
                                + "�ڍׂ�logs�t�H���_�z���̃��O�t�@�C�����Q�Ƃ��Ă��������B");
                    } else {
                        ACMessageBox.show("�f�[�^�ڍs���������܂����B");
                    }
                } catch (Throwable ex) {
                    ACFrame.getInstance().showExceptionMessage(ex);
                }
                setProgressTitle("�@��ver����o�͂���CSV�t�@�C���̕ۑ�����w�肵�A���s�{�^�����������Ă��������B");
                setProgress("");
                getExecute().setEnabled(true);
            };
        }).start();
    }

    /**
     * �K��Ō�񍐏����ڍs���܂��B
     * 
     * @param dbm DB�}�l�[�W��
     * @param f CSV�t�@�C��
     * @return �G���[����
     */
    protected int importHomonResult(ACDBManager dbm, VRCSVFile f) {
        setProgressTitle("�@�K��Ō�񍐏��̈ڍs��..");
        int error = 0;
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO HOMONKANGO_RESULT(");
        sb.append(" PATIENT_ID");
        sb.append(",TARGET_DATE");
        sb.append(",JOTAI_CODE");
        sb.append(",DOCTOR_NAME");
        sb.append(",CREATE_DATE");
        sb.append(",PROVIDER_NAME");
        sb.append(",ADMINISTRATOR_NAME");
        sb.append(",BYOJO_STATE");
        sb.append(",KANGO_REHA_NAIYO");
        sb.append(",RYOYO_KAIGO_STATE");
        sb.append(",REPORT_COMMENT");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String header = sb.toString();
        sb = new StringBuffer();
        sb.append("INSERT INTO HOMONKANGO_RESULT_CALENDAR(");
        sb.append(" PATIENT_ID");
        sb.append(",VISIT_DATE");
        sb.append(",VISIT_VALUE");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String noteHeader = sb.toString();
        // ��L�[�ł��闘�p��ID+�쐬���̏d�����`�F�b�N�B
        List pureList = filterRecord(f);
        int end = pureList.size();
        setProgressTitle("�@�K��Ō�񍐏��̈ڍs��..[" + end + "����/");
        for (int i = 0; i < end; i++) {
            List list = (List) pureList.get(i);
            try {
                setProgress(i + "����] ���s=" + error + "��");
                if (list.size() > 10) {
                    sb = new StringBuffer(header);
                    // ���p�Ҕԍ� ����
                    String patientID = INTEGER_FORMAT.format(list.get(0));
                    sb.append(patientID);
                    // �Ώ۔N�� ���t
                    String targetDate = DATE_FORMAT.format(list.get(1));
                    if ("NULL".equals(targetDate)) {
                        continue;
                    }
                    sb.append(",");
                    sb.append(targetDate);
                    // �v���x ����
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(2)));
                    // �厡�㖼 ������
                    sb.append(",");
                    sb.append(cutLength(list, 3, 32));
                    // �쐬�N���� ���t
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(4)));
                    // �X�e�[�V������ ������
                    sb.append(",");
                    sb.append(cutLength(list, 5, 64));
                    // �Ǘ��Ҏ��� ������
                    sb.append(",");
                    sb.append(cutLength(list, 6, 22));
                    // �a��̌o�� ������
                    sb.append(",");
                    sb.append(cutLength(list, 7, 294));
                    // �Ō�E���n�r���e�[�V�����̓��e ������
                    sb.append(",");
                    sb.append(cutLength(list, 8, 378));
                    // �ƒ�ł̗×{�E���̏� ������
                    sb.append(",");
                    sb.append(cutLength(list, 9, 336));
                    // ���L���ׂ����� ������
                    sb.append(",");
                    sb.append(cutLength(list, 10, 240));
                    // �ŏI�X�V�� LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());

                    int limit = list.size();
                    for (int j = 11; j < limit; j++) {
                        String[] arrays = ACCastUtilities.toString(list.get(j))
                                .split("=", 2);

                        sb = new StringBuffer(noteHeader);
                        // ���p�Ҕԍ�
                        sb.append(patientID);
                        // �K���
                        sb.append(",");
                        sb.append(DATE_FORMAT.format(arrays[0]));
                        // �l
                        sb.append(",");
                        if (arrays.length > 1) {
                            sb.append(INTEGER_FORMAT.format(arrays[1]));
                        } else {
                            sb.append("0");
                        }
                        // �ŏI�X�V��
                        sb.append(",CURRENT_TIMESTAMP)");
                        error += executeUpdate(dbm, sb.toString());
                    }
                } else {
                    throw new Exception("�s���ȃt�B�[���h��");
                }
            } catch (Exception ex) {
                VRLogger.info("�s����CSV���R�[�h �K��Ō�񍐏�(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }
        return error;
    }

    /**
     * ��1�E��2�t�B�[���h����L�[�Ƃ��āA�d�����Ȃ������X�g��Ԃ��܂��B
     * <p>
     * �d�������ꍇ�A�Ō�Ɍ����������R�[�h���D�悳��܂��B
     * </p>
     * 
     * @param f �t�@�C��
     * @return ���o����
     */
    protected List filterRecord(VRCSVFile f) {
        // ��L�[�ł��闘�p��ID+�쐬���̏d�����`�F�b�N�B
        // �d������ꍇ�A�Ō�̃f�[�^��
        int end = f.getRowCount();
        TreeMap repeatCache = new TreeMap();
        for (int i = 0; i < end; i++) {
            List list = f.getRow(i);
            if (list.size() > 2) {
                String repeatKey = INTEGER_FORMAT.format(list.get(0)) + "/"
                        + DATE_FORMAT.format(list.get(1));
                repeatCache.put(repeatKey, list);
            }
        }
        return new ArrayList(repeatCache.values());
    }

    /**
     * �K��Ō�v�揑���ڍs���܂��B
     * 
     * @param dbm DB�}�l�[�W��
     * @param f CSV�t�@�C��
     * @return �G���[����
     */
    protected int importHomonPlan(ACDBManager dbm, VRCSVFile f) {
        setProgressTitle("�@�K��Ō�v�揑�̈ڍs��..");
        int error = 0;
        Map noteHash = new HashMap();
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO HOMONKANGO_PLAN(");
        sb.append(" PATIENT_ID");
        sb.append(",TARGET_DATE");
        sb.append(",JOTAI_CODE");
        sb.append(",DOCTOR_NAME");
        sb.append(",CREATE_DATE");
        sb.append(",PROVIDER_NAME");
        sb.append(",ADMINISTRATOR_NAME");
        sb.append(",PLAN_PURPOSE");
        sb.append(",PLAN_COMMENT");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String header = sb.toString();
        // ��L�[�ł��闘�p��ID+�쐬���̏d�����`�F�b�N�B
        List pureList = filterRecord(f);
        int end = pureList.size();
        setProgressTitle("�@�K��Ō�v�揑�̈ڍs��..[" + end + "����/");
        for (int i = 0; i < end; i++) {
            List list = (List) pureList.get(i);
            try {
                setProgress(i + "����] ���s=" + error + "��");
                if (list.size() > 8) {
                    sb = new StringBuffer(header);
                    // ���p�Ҕԍ� ����
                    String patientID = INTEGER_FORMAT.format(list.get(0));
                    sb.append(patientID);
                    // �Ώ۔N�� ���t
                    String targetDate = DATE_FORMAT.format(list.get(1));
                    if ("NULL".equals(targetDate)) {
                        continue;
                    }
                    sb.append(",");
                    sb.append(targetDate);
                    // �v���x ����
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(2)));
                    // �厡�㖼 ������
                    sb.append(",");
                    sb.append(cutLength(list, 3, 32));
                    // �쐬�N���� ���t
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(4)));
                    // �X�e�[�V������ ������
                    sb.append(",");
                    sb.append(cutLength(list, 5, 64));
                    // �Ǘ��Ҏ��� ������
                    sb.append(",");
                    sb.append(cutLength(list, 6, 22));
                    // �Ō�E���n�r���e�[�V�����̖ڕW ������
                    sb.append(",");
                    sb.append(cutLength(list, 7, 572));
                    // ���l ������
                    sb.append(",");
                    sb.append(cutLength(list, 8, 172));
                    // �ŏI�X�V�� LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());

                    noteHash.put(patientID, list);
                } else {
                    throw new Exception("�s���ȃt�B�[���h��");
                }
            } catch (Exception ex) {
                VRLogger.info("�s����CSV���R�[�h �K��Ō�v�揑(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }

        sb = new StringBuffer();
        sb.append("INSERT INTO HOMONKANGO_PLAN_NOTE(");
        sb.append(" PATIENT_ID");
        sb.append(",NOTE_ID");
        sb.append(",NOTE_DATE");
        sb.append(",NOTE_COMMENT");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String noteHeader = sb.toString();
        Iterator it = noteHash.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry ent = (Map.Entry) it.next();
            List list = (List) ent.getValue();
            String patientID = ACCastUtilities.toString(ent.getKey(), "");
            try {

                int index = 1;
                int limit = list.size();
                for (int j = 9; j < limit; j++) {
                    String[] arrays = ACCastUtilities.toString(list.get(j))
                            .split("=", 2);

                    sb = new StringBuffer(noteHeader);
                    // ���p�Ҕԍ�
                    sb.append(patientID);
                    // �}��
                    sb.append(",");
                    sb.append(index);
                    // ���_�E������E���t
                    String targetDate = DATE_FORMAT.format(arrays[0]);
                    if ("NULL".equals(targetDate)) {
                        continue;
                    }
                    sb.append(",");
                    sb.append(targetDate);

                    // ���_�E������E���e
                    sb.append(",");
                    if (arrays.length > 1) {
                        sb.append(cutLength(STRING_FORMAT.format(arrays[1]),
                                3000));
                    } else {
                        sb.append("''");
                    }
                    // �ŏI�X�V��
                    sb.append(",CURRENT_TIMESTAMP)");
                    int err = executeUpdate(dbm, sb.toString());
                    if (err != 0) {
                        error += err;
                    } else {
                        index++;
                    }
                }
            } catch (Exception ex) {
                VRLogger.info("�s����CSV���R�[�h �K��Ō�v�揑(���p��ID=" + patientID + ") = "
                        + list.toString());
                error++;
            }
        }

        return error;
    }

    /**
     * ����×{�Ǘ��w���������ڍs���܂��B
     * 
     * @param dbm DB�}�l�[�W��
     * @param f CSV�t�@�C��
     * @return �G���[����
     */
    protected int importKyotakuRyoyo(ACDBManager dbm, VRCSVFile f) {
        setProgressTitle("�@����×{�Ǘ��w�����̈ڍs��..");
        // setProgress("[�����f�[�^�̍폜]");
        int error = 0;
        // error += executeUpdate(dbm, "DELETE FROM KYOTAKU_RYOYO");
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO KYOTAKU_RYOYO(");
        sb.append(" PATIENT_ID");
        sb.append(",TARGET_DATE");
        sb.append(",JOTAI_CODE");
        sb.append(",SHOGAI_JIRITSUDO");
        sb.append(",NINCHISHO_JIRITSUDO");
        sb.append(",PATIENT_ADDRESS");
        sb.append(",PATIENT_TEL_FIRST");
        sb.append(",PATIENT_TEL_SECOND");
        sb.append(",PATIENT_TEL_THIRD");
        sb.append(",CREATE_DATE_ZAITAKU");
        sb.append(",VISIT_THIS_MONTH_NO1");
        sb.append(",VISIT_THIS_MONTH_NO2");
        sb.append(",VISIT_THIS_MONTH_NO3");
        sb.append(",VISIT_THIS_MONTH_NO4");
        sb.append(",VISIT_THIS_MONTH_NO5");
        sb.append(",VISIT_THIS_MONTH_NO6");
        sb.append(",VISIT_NEXT_MONTH_NO1");
        sb.append(",VISIT_NEXT_MONTH_NO2");
        sb.append(",VISIT_NEXT_MONTH_NO3");
        sb.append(",VISIT_NEXT_MONTH_NO4");
        sb.append(",VISIT_NEXT_MONTH_NO5");
        sb.append(",VISIT_NEXT_MONTH_NO6");
        sb.append(",ADVICE_MONTH");
        sb.append(",ADVICE");
        sb.append(",MEDICAL_FACILITY_NAME");
        sb.append(",DOCTOR_NAME");
        sb.append(",MEDICAL_FACILITY_ADDRESS");
        sb.append(",MEDICAL_FACILITY_TEL_FIRST");
        sb.append(",MEDICAL_FACILITY_TEL_SECOND");
        sb.append(",MEDICAL_FACILITY_TEL_THIRD");
        sb.append(",SENMONIN");
        sb.append(",PROVIDER_NAME");
        sb.append(",CREATE_DATE_KYOTAKU");
        sb.append(",CONDITION");
        sb.append(",CONDITION_PASSAGE");
        sb.append(",NOTE_OF_KAIGO_SERVICE");
        sb.append(",NOTE_OF_DAILY_LIFE");
        sb.append(",REMARKS");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String header = sb.toString();
        // ��L�[�ł��闘�p��ID+�쐬���̏d�����`�F�b�N�B
        List pureList = filterRecord(f);
        int end = pureList.size();
        setProgressTitle("�@����×{�Ǘ��w�����̈ڍs��..[" + end + "����/");
        for (int i = 0; i < end; i++) {
            List list = (List) pureList.get(i);
            try {
                setProgress(i + "����] ���s=" + error + "��");
                if (list.size() > 27) {
                    sb = new StringBuffer(header);
                    // ���p��ID
                    sb.append(INTEGER_FORMAT.format(list.get(0)));
                    // �Ώ۔N��
                    String targetDate = DATE_FORMAT.format(list.get(1));
                    if ("NULL".equals(targetDate)) {
                        continue;
                    }
                    sb.append(",");
                    sb.append(targetDate);
                    // �v����ԋ敪�R�[�h
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(2)));

                    // ��Q����ғ��퐶�������x SHOGAI_JIRITSUDO INTEGER
                    String shogaiJiritsu = "0";
                    switch (ACCastUtilities.toInt(list.get(5), 0)) {
                    case 1: // ����
                        shogaiJiritsu = "1";
                        break;
                    case 2:// J1
                    case 3:// J2
                        shogaiJiritsu = "2";
                        break;
                    case 4:// A1
                    case 5:// A2
                        shogaiJiritsu = "3";
                        break;
                    case 6:// B1
                    case 7:// B2
                        shogaiJiritsu = "4";
                        break;
                    case 8:// C1
                    case 9:// C2
                        shogaiJiritsu = "5";
                        break;
                    }
                    sb.append(",");
                    sb.append(shogaiJiritsu);
                    // �F�m�Ǎ���ғ��퐶�������x NINCHISHO_JIRITSUDO INTEGER
                    String ninchiJiritsu = "0";
                    switch (ACCastUtilities.toInt(list.get(6), 0)) {
                    case 1: // ����
                        ninchiJiritsu = "1";
                        break;
                    case 2:// I
                        ninchiJiritsu = "2";
                        break;
                    case 3:// IIa
                    case 4:// IIb
                        ninchiJiritsu = "3";
                        break;
                    case 5:// IIIa
                    case 6:// IIIb
                        ninchiJiritsu = "4";
                        break;
                    case 7:// IV
                        ninchiJiritsu = "5";
                        break;
                    case 8:// M
                        ninchiJiritsu = "6";
                        break;
                    }
                    sb.append(",");
                    sb.append(ninchiJiritsu);
                    // ���p�ҏZ�� PATIENT_ADDRESS VARCHAR 200
                    sb.append(",''");
                    // ���p�ҘA���� PATIENT_TEL_FIRST VARCHAR 6
                    sb.append(",''");
                    // ���p�ҘA���� PATIENT_TEL_SECOND VARCHAR 4
                    sb.append(",''");
                    // ���p�ҘA���� PATIENT_TEL_THIRD VARCHAR 4
                    sb.append(",''");
                    // �ݑ�×{�����̃|�C���g�̍쐬�N�� CREATE_DATE_ZAITAKU DATE sb.append(",");
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(7)));
                    // �����̖K���(1��)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(8)));
                    // �����̖K���(2��)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(9)));
                    // �����̖K���(3��)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(10)));
                    // �����̖K���(4��)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(11)));
                    // �����̖K���(5��)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(12)));
                    // �����̖K���(6��)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(13)));
                    // �����̖K��\��(1��)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(14)));
                    // �����̖K��\��(2��)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(15)));
                    // �����̖K��\��(3��)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(16)));
                    // �����̖K��\��(4��)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(17)));
                    // �����̖K��\��(5��)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(18)));
                    // �����̖K��\��(6��)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(19)));
                    // ( )���̃A�h�o�C�X
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(20)));
                    // �A�h�o�C�X
                    sb.append(",");
                    sb.append(cutLength(list, 21, 912));
                    // ��Ë@�֖�
                    sb.append(",");
                    sb.append(cutLength(list, 22, 64));
                    // �S����t��
                    sb.append(",");
                    sb.append(cutLength(list, 23, 32));
                    // �Z�� MEDICAL_FACILITY_ADDRESS VARCHAR 150
                    sb.append(",''");
                    // ��Ë@�֘A����1 MEDICAL_FACILITY_TEL_FIRST VARCHAR 6
                    sb.append(",''");
                    // ��Ë@�֘A����2 MEDICAL_FACILITY_TEL_SECOND VARCHAR 4
                    sb.append(",''");
                    // ��Ë@�֘A����3 MEDICAL_FACILITY_TEL_THIRD VARCHAR 4
                    sb.append(",''");
                    // ���x������
                    sb.append(",");
                    sb.append(STRING_FORMAT.format(list.get(25)));
                    // ���Ə���
                    sb.append(",");
                    sb.append(STRING_FORMAT.format(list.get(26)));
                    // ����×{�Ǘ��w�����̍쐬���t
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(27)));
                    // �a�� CONDITION VARCHAR 250
                    sb.append(",''");
                    // �a��o�ߓ� CONDITION_PASSAGE VARCHAR 250
                    sb.append(",''");
                    // ���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@�� NOTE_OF_KAIGO_SERVICE VARCHAR 250
                    sb.append(",''");
                    // ���p�҂̓��퐶����̗��ӓ_ NOTE_OF_DAILY_LIFE VARCHAR 250
                    sb.append(",''");
                    // ���l REMARKS VARCHAR 250
                    sb.append(",''");
                    // �ŏI�X�V�� LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());
                } else {
                    throw new Exception("�s���ȃt�B�[���h��");
                }
            } catch (Exception ex) {
                VRLogger.info("�s����CSV���R�[�h ����×{�Ǘ��w����(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }
        return error;
    }

    /**
     * ���Ə������ڍs���܂��B
     * 
     * @param dbm DB�}�l�[�W��
     * @param f CSV�t�@�C��
     * @return �G���[����
     */
    protected int importProvider(ACDBManager dbm, VRCSVFile f, List providers) {
        setProgressTitle("�@���Ə����̈ڍs��..");
        int error = 0;
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO PROVIDER(");
        sb.append(" PROVIDER_ID");
        sb.append(",PROVIDER_TYPE");
        sb.append(",MEDICAL_FLAG");
        sb.append(",PROVIDER_NAME");
        sb.append(",PROVIDER_ZIP_FIRST");
        sb.append(",PROVIDER_ZIP_SECOND");
        sb.append(",PROVIDER_ADDRESS");
        sb.append(",PROVIDER_TEL_FIRST");
        sb.append(",PROVIDER_TEL_SECOND");
        sb.append(",PROVIDER_TEL_THIRD");
        sb.append(",PROVIDER_FAX_FIRST");
        sb.append(",PROVIDER_FAX_SECOND");
        sb.append(",PROVIDER_FAX_THIRD");
        sb.append(",PROVIDER_JIJIGYOUSHO_TYPE");
        sb.append(",PROVIDER_JIGYOU_TYPE");
        sb.append(",PROVIDER_AREA_TYPE");
        sb.append(",SPECIAL_AREA_FLAG");
        sb.append(",PROVIDER_OWNER_NAME");
        sb.append(",BANK_NAME");
        sb.append(",BANK_BRANCH_NAME");
        sb.append(",ACCOUNT_NUMBER");
        sb.append(",ACCOUNT_TYPE");
        sb.append(",ACCOUNT_HOLDER");
        sb.append(",DELETE_FLAG");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String header = sb.toString();
        int end = f.getRowCount();
        setProgressTitle("�@���Ə����̈ڍs��..[" + end + "����/");
        for (int i = 0; i < end; i++) {
            List list = f.getRow(i);
            try {
                setProgress(i + "����] ���s=" + error + "��");
                if (list.size() > 15) {
                    sb = new StringBuffer(header);
                    // ���Ə��ԍ� PROVIDER_ID
                    String providerID = STRING_FORMAT.format(list.get(0));
                    providers.add(providerID);
                    if ("NULL".equals(providerID)) {
                        continue;
                    }
                    sb.append(cutLength(providerID, 10));
                    // ���Ə���� PROVIDER_TYPE INTEGER
                    sb.append(",0");
                    // ��Ë@�փt���O MEDICAL_FLAG INTEGER
                    sb.append(",2");
                    // ���Ə���PROVIDER_NAME
                    sb.append(",");
                    sb.append(cutLength(list, 1, 64));
                    // �X�֔ԍ��i�O�jPROVIDER_ZIP_FIRST
                    sb.append(",");
                    sb.append(cutLength(list, 2, 3));
                    // �X�֔ԍ��i��jPROVIDER_ZIP_SECOND
                    sb.append(",");
                    sb.append(cutLength(list, 3, 4));
                    // ���ݒnPROVIDER_ADDRESS
                    sb.append(",");
                    sb.append(cutLength(list, 4, 70));
                    // �d�b�ԍ��i�O�jPROVIDER_TEL_FIRST
                    sb.append(",");
                    sb.append(cutLength(list, 5, 6));
                    // �d�b�ԍ��i���jPROVIDER_TEL_SECOND
                    sb.append(",");
                    sb.append(cutLength(list, 6, 4));
                    // �d�b�ԍ��i��jPROVIDER_TEL_THIRD
                    sb.append(",");
                    sb.append(cutLength(list, 7, 4));
                    // FAX�ԍ��i�O�jPROVIDER_FAX_FIRST
                    sb.append(",");
                    sb.append(cutLength(list, 8, 6));
                    // FAX�ԍ��i���jPROVIDER_FAX_SECOND
                    sb.append(",");
                    sb.append(cutLength(list, 9, 4));
                    // FAX�ԍ��i��jPROVIDER_FAX_THIRD
                    sb.append(",");
                    sb.append(cutLength(list, 10, 4));
                    // �����Ə��敪PROVIDER_JIJIGYOUSHO_TYPE
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(11)));
                    // ���Ƌ敪PROVIDER_JIGYOU_TYPE
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(12)));
                    // �n��敪PROVIDER_AREA_TYPE
                    String area = INTEGER_FORMAT.format(list.get(13));
                    if (!("1".equals(area) || "2".equals(area)
                            || "3".equals(area) || "4".equals(area) || "5"
                            .equals(area))) {
                        // ���ʋ�A���b�n�A�b�n�A���n�A���̑� �ȊO�͂��̑��Ƃ���B
                        area = "5";
                    }
                    sb.append(",");
                    sb.append(area);
                    // ���ʒn��SPECIAL_AREA_FLAG
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(14)));
                    // �J�ݎҎ���PROVIDER_OWNER_NAME
                    sb.append(",");
                    sb.append(cutLength(list, 15, 16));
                    // �U������Z�@�֖� BANK_NAME VARCHAR
                    sb.append(",''");
                    // �U������Z�@�֎x�X�� BANK_BRANCH_NAME VARCHAR
                    sb.append(",''");
                    // �U��������ԍ� ACCOUNT_NUMBER VARCHAR
                    sb.append(",''");
                    // �U���������� ACCOUNT_TYPE INTEGER
                    sb.append(",0");
                    // �U���於�`�l ACCOUNT_HOLDER VARCHAR
                    sb.append(",''");
                    // �폜�t���O
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(16)));

                    // �ŏI�X�V�� LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());
                } else {
                    throw new Exception("�s���ȃt�B�[���h��");
                }
            } catch (Exception ex) {
                VRLogger.info("�s����CSV���R�[�h ���Ə����(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }
        return error;
    }

    /**
     * ���p�җv�������ڍs���܂��B
     * 
     * @param dbm DB�}�l�[�W��
     * @param f CSV�t�@�C��
     * @return �G���[����
     */
    protected int importPatientNinteiHistory(ACDBManager dbm, VRCSVFile f, List providers) {
        setProgressTitle("�@���p�җv�����̈ڍs��..");
        // setProgress("[�����f�[�^�̍폜]");
        int error = 0;
        // error += executeUpdate(dbm, "DELETE FROM PATIENT_NINTEI_HISTORY");

        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO PATIENT_NINTEI_HISTORY(");
        sb.append(" PATIENT_ID");
        sb.append(",NINTEI_HISTORY_ID");
        sb.append(",INSURER_ID");
        sb.append(",INSURED_ID");
        sb.append(",INSURE_RATE");
        sb.append(",PLANNER");
        sb.append(",PROVIDER_ID");
        sb.append(",SHUBETSU_CODE");
        sb.append(",CHANGE_CODE");
        sb.append(",JOTAI_CODE");
        sb.append(",SHINSEI_DATE");
        sb.append(",NINTEI_DATE");
        sb.append(",INSURE_VALID_START");
        sb.append(",INSURE_VALID_END");
        sb.append(",STOP_DATE");
        sb.append(",STOP_REASON");
        sb.append(",REPORTED_DATE");
        sb.append(",LIMIT_RATE");
        sb.append(",EXTERNAL_USE_LIMIT");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String header = sb.toString();
        final Date VALID_BEGIN_DATE = ACDateUtilities.createDate(2006, 4, 1);
        int end = f.getRowCount();
        setProgressTitle("�@���p�җv�����̈ڍs��..[" + end + "����/");
        for (int i = 0; i < end; i++) {
            List list = f.getRow(i);
            try {
                setProgress(i + "����] ���s=" + error + "��");
                if (list.size() > 17) {
                    sb = new StringBuffer(header);

                    // ���p��ID PATIENT_ID
                    sb.append(INTEGER_FORMAT.format(list.get(0)));
                    // �F�藚��ԍ� NINTEI_HISTORY_ID
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(1)));
                    // �ی��Ҕԍ� INSURER_ID
                    sb.append(",");
                    sb.append(cutLength(list, 2, 6));
                    // ��ی��Ҕԍ� INSURED_ID
                    sb.append(",");
                    sb.append(cutLength(list, 3, 10));
                    // ���ی����t�� INSURE_RATE
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(4)));
                    // ����T�[�r�X�v��쐬�� PLANNER
                    if("2".equals(INTEGER_FORMAT.format(list.get(4)))){
                        //��ی��҂̏ꍇ
                        sb.append(",2");
                    }else{
                        //����ȊO�͕R�t���s�\
                        sb.append(",0");
                    }
                    // ����T�[�r�X�쐬���Ə��ԍ� PROVIDER_ID
                    sb.append(",NULL");
                    // �\����ʃR�[�h SHUBETSU_CODE
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(7)));
                    // �\�����R�[�h CHANGE_CODE
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(8)));
                    // �v����ԋ敪�R�[�h JOTAI_CODE
                    Integer jotaiCode = ACCastUtilities.toInteger(list.get(9),
                            0);
                    if (jotaiCode.intValue() <= 0) {
                        // VRLogger.info("�s����CSV���R�[�h[�s���ȗv���x] ���p�җv�����(" + (i +
                        // 1)
                        // + ") = " + list.toString());
                        // error++;
                        continue;
                    }
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(jotaiCode));
                    // �\���� SHINSEI_DATE
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(10)));
                    // �F��� NINTEI_DATE
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(11)));
                    // �L�����ԊJ�n INSURE_VALID_START
                    sb.append(",");
                    String validStartText = DATE_FORMAT.format(list.get(12));
                    if ("NULL".equals(validStartText)) {
                        validStartText = "0001-01-01";
                    }
                    sb.append(validStartText);
                    // �L�����ԏI�� INSURE_VALID_END
                    Date validEnd = ACCastUtilities.toDate(list.get(13), null);
                    String validEndText = DATE_FORMAT.format(validEnd);
                    if ("NULL".equals(validEndText)) {
                        validEndText = "9999-12-31";
                    }
                    sb.append(",");
                    sb.append(validEndText);
                    // ���f�N���� STOP_DATE
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(14)));
                    // ���f���R STOP_REASON
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(15)));
                    // ����T�[�r�X�v��쐬�˗��͏o�� REPORTED_DATE
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(16)));
                    // �x�����x�z LIMIT_RATE
                    sb.append(",");
                    String cost = "0";
                    switch (jotaiCode.intValue()) {
                    case 11:// 11-�o�ߓI�v���i�v�x���j
                        cost = "6150";
                        break;
                    case 12:// 12-�v�x���P
                        cost = "4970";
                        break;
                    case 13:// 13-�v�x���Q
                        cost = "10400";
                        break;
                    case 21:// 21-�v���1
                        cost = "16580";
                        break;
                    case 22:// 22-�v���Q
                        cost = "19480";
                        break;
                    case 23:// 23-�v���R
                        cost = "26750";
                        break;
                    case 24:// 24-�v���4
                        cost = "30600";
                        break;
                    case 25:// 25-�v���5
                        cost = "35830";
                        break;
                    }
                    sb.append(cost);
                    // �O�����p�^���t����P�ʐ� EXTERNAL_USE_LIMIT
                    sb.append(",");
                    cost = "0";
                    if (validEnd != null) {
                        if (ACDateUtilities.compareOnDay(VALID_BEGIN_DATE,
                                validEnd) <= 0) {
                            switch (jotaiCode.intValue()) {
                            case 11:// 11-�o�ߓI�v���i�v�x���j
                                cost = "6505";
                                break;
                            case 12:// 12-�v�x���P
                                cost = "4970";
                                break;
                            case 13:// 13-�v�x���Q
                                cost = "10400";
                                break;
                            case 21:// 21-�v���1
                                cost = "16689";
                                break;
                            case 22:// 22-�v���Q
                                cost = "18726";
                                break;
                            case 23:// 23-�v���R
                                cost = "20763";
                                break;
                            case 24:// 24-�v���4
                                cost = "22800";
                                break;
                            case 25:// 25-�v���5
                                cost = "24867";
                                break;
                            }
                        }
                    }
                    sb.append(cost);

                    // �ŏI�X�V�� LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());

                } else {
                    throw new Exception("�s���ȃt�B�[���h��");
                }
            } catch (Exception ex) {
                VRLogger.info("�s����CSV���R�[�h ���p�җv�����(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }
        return error;
    }

    protected ACDBManager dbm = null;
    protected File patietFile = null;
    protected File ninteiFile = null;
    protected File staffFile = null;
    protected File insurerFile = null;
    protected File providerFile = null;
    protected File provServiceFile = null;
    protected File kyotakuRyoyoFile = null;
    protected File homonKangoPlanFile = null;
    protected File homonKangoResultFile = null;
    protected int errorCount = 0;

    /**
     * �G���[���������Z���܂��B
     * 
     * @param add ���Z��
     */
    public void addErrorCount(int add) {
        errorCount += add;
    }

    /**
     * �ی��ҏ����ڍs���܂��B
     * 
     * @param dbm DB�}�l�[�W��
     * @param f CSV�t�@�C��
     * @return �G���[����
     */
    protected int importInsurer(ACDBManager dbm, VRCSVFile f) {
        setProgressTitle("�@�ی��ҏ��̈ڍs��..");
        // setProgress("[�����f�[�^�̍폜]");
        int error = 0;
        // error += executeUpdate(dbm, "DELETE FROM INSURER");
        // error += executeUpdate(dbm, "DELETE FROM PATIENT_KOHI");
        // error += executeUpdate(dbm, "DELETE FROM INSURER_LIMIT_RATE");
        // error += executeUpdate(dbm, "DELETE FROM INSURER_LIMIT_RATE_DETAIL");
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO INSURER(");
        sb.append(" INSURER_ID");
        sb.append(",INSURER_NAME");
        sb.append(",INSURER_ZIP_FIRST");
        sb.append(",INSURER_ZIP_SECOND");
        sb.append(",INSURER_ADDRESS");
        sb.append(",INSURER_TEL_FIRST");
        sb.append(",INSURER_TEL_SECOND");
        sb.append(",INSURER_TEL_THIRD");
        sb.append(",DELETE_FLAG");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");

        String header = sb.toString();
        int end = f.getRowCount();
        setProgressTitle("�@�ی��ҏ��̈ڍs��..[" + end + "����/");
        for (int i = 0; i < end; i++) {
            List list = f.getRow(i);
            try {
                setProgress(i + "����] ���s=" + error + "��");
                if (list.size() > 8) {
                    sb = new StringBuffer(header);
                    // �ی��Ҕԍ�
                    sb.append(cutLength(list, 0, 6));
                    // �ی��Җ�
                    sb.append(",");
                    sb.append(cutLength(list, 1, 32));
                    // �X�֔ԍ��i�O�j
                    sb.append(",");
                    sb.append(cutLength(list, 2, 3));
                    // �X�֔ԍ��i��j
                    sb.append(",");
                    sb.append(cutLength(list, 3, 4));
                    // ���ݒn
                    sb.append(",");
                    sb.append(cutLength(list, 4, 64));
                    // �d�b�ԍ��i�O�j
                    sb.append(",");
                    sb.append(cutLength(list, 5, 6));
                    // �d�b�ԍ��i���j
                    sb.append(",");
                    sb.append(cutLength(list, 6, 4));
                    // �d�b�ԍ��i��j
                    sb.append(",");
                    sb.append(cutLength(list, 7, 4));
                    // �폜�t���O
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(8)));

                    // �ŏI�X�V�� LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());
                } else {
                    throw new Exception("�s���ȃt�B�[���h��");
                }
            } catch (Exception ex) {
                VRLogger.info("�s����CSV���R�[�h �ی��ҏ��(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }
        return error;
    }

    /**
     * �X�^�b�t�����ڍs���܂��B
     * 
     * @param dbm DB�}�l�[�W��
     * @param f CSV�t�@�C��
     * @return �G���[����
     */
    protected int importStaff(ACDBManager dbm, VRCSVFile f) {
        setProgressTitle("�@�S���ҏ��̈ڍs��..");
        // setProgress("[�����f�[�^�̍폜]");
        int error = 0;
        // error += executeUpdate(dbm, "DELETE FROM STAFF");
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO STAFF(");
        sb.append(" PROVIDER_ID");
        sb.append(",STAFF_ID");
        sb.append(",CARE_MANAGER_NO");
        sb.append(",STAFF_FAMILY_NAME");
        sb.append(",STAFF_FIRST_NAME");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String header = sb.toString();
        int end = f.getRowCount();
        setProgressTitle("�@�S���ҏ��̈ڍs��..[" + end + "����/");
        for (int i = 0; i < end; i++) {
            List list = f.getRow(i);
            try {
                setProgress(i + "����] ���s=" + error + "��");
                if (list.size() > 3) {
                    sb = new StringBuffer(header);
                    // ���Ə��ԍ�
                    sb.append(cutLength(list, 0, 10));
                    // �X�^�b�tID
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(1)));
                    // ���x�������ԍ�
                    sb.append(",''");
                    // �S���Җ�(��)
                    sb.append(",");
                    sb.append(cutLength(list, 2, 16));
                    // �S���Җ�(��)
                    sb.append(",");
                    sb.append(cutLength(list, 3, 16));

                    // �ŏI�X�V�� LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());
                } else {
                    throw new Exception("�s���ȃt�B�[���h��");
                }
            } catch (Exception ex) {
                VRLogger.info("�s����CSV���R�[�h �S���ҏ��(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }
        return error;
    }

    /**
     * �w�蕶�����Ő؂�l�߂܂��B
     * 
     * @param src ���ؕ���
     * @param max �ő啶����
     * @return �؂�l�ߌ���
     */
    protected String cutLength(List list, int index, int max) {
        // ''�̕�������␳
        return cutLength(STRING_FORMAT.format(list.get(index)), max);
    }

    /**
     * �w�蕶�����Ő؂�l�߂܂��B
     * 
     * @param src ���ؕ���
     * @param max �ő啶����
     * @return �؂�l�ߌ���
     */
    protected String cutLength(String src, int max) {
        // ''�̕�������␳
        max += 2;
        if (src.length() <= max) {
            return src;
        }
        return src.substring(0, max - 1) + "'";
    }

    private String progressTitle = "";

    protected void setProgressTitle(String progressTitle) {
        this.progressTitle = progressTitle;
    }

    protected String getProgressTitle() {
        return progressTitle;
    }

    protected void setProgress(String progress) {
        getMessage().setText(getProgressTitle() + progress);
    }

    /**
     * ���p�ҏ����ڍs���܂��B
     * 
     * @param dbm DB�}�l�[�W��
     * @param f CSV�t�@�C��
     * @return �G���[����
     */
    protected int importPatient(ACDBManager dbm, VRCSVFile f) {
        setProgressTitle("�@���p�ҏ��̈ڍs��..");
        int error = 0;
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO PATIENT(");
        sb.append(" PATIENT_ID");
        sb.append(",PATIENT_CODE");
        sb.append(",PATIENT_FAMILY_NAME");
        sb.append(",PATIENT_FIRST_NAME");
        sb.append(",PATIENT_FAMILY_KANA");
        sb.append(",PATIENT_FIRST_KANA");
        sb.append(",PATIENT_SEX");
        sb.append(",PATIENT_BIRTHDAY");
        sb.append(",PATIENT_TEL_FIRST");
        sb.append(",PATIENT_TEL_SECOND");
        sb.append(",PATIENT_TEL_THIRD");
        sb.append(",PATIENT_ZIP_FIRST");
        sb.append(",PATIENT_ZIP_SECOND");
        sb.append(",PATIENT_ADDRESS");
        sb.append(",SHOW_FLAG");
        sb.append(",BELONG_TYPE");
        sb.append(",AREA_TYPE");
        sb.append(",DELETE_FLAG");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String header = sb.toString();
        int end = f.getRowCount();
        setProgressTitle("�@���p�ҏ��̈ڍs��..[" + end + "����/");
        for (int i = 0; i < end; i++) {
            List list = f.getRow(i);
            try {
                setProgress(i + "����] ���s=" + error + "��");
                if (list.size() > 15) {
                    sb = new StringBuffer(header);
                    // ���p��ID
                    sb.append(INTEGER_FORMAT.format(list.get(0)));
                    // ���p�҃R�[�h
                    sb.append(",");
                    sb.append(cutLength(list, 1, 16));
                    // ����(��)
                    sb.append(",");
                    sb.append(cutLength(list, 2, 16));
                    // ����(��)
                    sb.append(",");
                    sb.append(cutLength(list, 3, 16));
                    // �ӂ肪��(��)
                    sb.append(",");
                    sb.append(cutLength(list, 4, 16));
                    // �ӂ肪��(��)
                    sb.append(",");
                    sb.append(cutLength(list, 5, 16));
                    // ����
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(6)));
                    // ���N����
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(7)));
                    // �d�b�ԍ��i�O�j
                    sb.append(",");
                    sb.append(cutLength(list, 8, 6));
                    // �d�b�ԍ��i���j
                    sb.append(",");
                    sb.append(cutLength(list, 9, 4));
                    // �d�b�ԍ��i��j
                    sb.append(",");
                    sb.append(cutLength(list, 10, 4));
                    // �X�֔ԍ��i�O�j
                    sb.append(",");
                    sb.append(cutLength(list, 11, 3));
                    // �X�֔ԍ��i��j
                    sb.append(",");
                    sb.append(cutLength(list, 12, 4));
                    // �Z��
                    sb.append(",");
                    sb.append(cutLength(list, 13, 64));
                    // �ꗗ�\���t���O
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(14)));
                    // �����敪
                    sb.append(",0");
                    // �n��敪
                    sb.append(",0");
                    // �폜�t���O
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(15)));

                    // �ŏI�X�V�� LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());
                } else {
                    throw new Exception("�s���ȃt�B�[���h��");
                }
            } catch (Exception ex) {
                VRLogger.info("�s����CSV���R�[�h ���p��(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }
        return error;
    }

    protected ACSQLSafeStringFormat STRING_FORMAT = new ACSQLSafeStringFormat() {
        public StringBuffer format(Object obj, StringBuffer toAppendTo,
                FieldPosition pos) {
            if (("NULL".equals(obj))) {
                obj = null;
            }
            return super.format(obj, toAppendTo, pos);

        }
    };

    protected ACSQLSafeIntegerFormat INTEGER_FORMAT = new ACSQLSafeIntegerFormat() {
        public StringBuffer format(Object obj, StringBuffer toAppendTo,
                FieldPosition pos) {
            if (("NULL".equals(obj))) {
                obj = null;
            }
            return super.format(obj, toAppendTo, pos);

        }
    };

    protected ACSQLSafeDateFormat DATE_FORMAT = new ACSQLSafeDateFormat(
            "yyyy-MM-dd") {
        public StringBuffer format(Object obj, StringBuffer toAppendTo,
                FieldPosition pos) {
            if (!(obj instanceof Date)) {
                obj = ACCastUtilities.toDate(obj, null);
            } else if (("NULL".equals(obj))) {
                obj = null;
            }
            return super.format(obj, toAppendTo, pos);
        }
    };

    /**
     * �X�VSQL���𔭍s���܂��B
     * 
     * @param dbm DB�}�l�[�W��
     * @param sql SQL��
     */
    protected int executeUpdate(ACDBManager dbm, String sql) {
        try {
            dbm.beginTransaction();
            dbm.executeUpdate(sql);
            dbm.commitTransaction();
        } catch (Exception ex) {
            VRLogger.info(ex);
            try {
                dbm.rollbackTransaction();
            } catch (Exception ex2) {
                VRLogger.info(ex2);
            }
            return 1;
        }
        return 0;
    }

    /**
     * This method initializes exit
     * 
     * @return javax.swing.JButton
     */
    private ACButton getExit() {
        if (exit == null) {
            exit = new ACButton();
            exit.setText("�I��(X)");
            exit.setMnemonic('X');
            exit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (ACMessageBox.showOkCancel("�I�����܂��B��낵���ł����H",
                            ACMessageBox.FOCUS_CANCEL) == ACMessageBox.RESULT_OK) {
                        System.exit(0);
                    }
                }
            });
        }
        return exit;
    }

    /**
     * This method initializes contents
     * 
     * @return javax.swing.JPanel
     */
    private ACPanel getContents() {
        if (settings == null) {
            settings = new ACPanel();
            settings.add(getDests(), VRLayout.NORTH);
            settings.add(getSourceDirectorys(), VRLayout.NORTH);
            settings.add(getInfomations(), VRLayout.CLIENT);
        }
        return settings;
    }

    /**
     * This method initializes contents
     * 
     * @return javax.swing.JPanel
     */
    private ACGroupBox getDests() {
        if (dests == null) {
            dests = new ACGroupBox();
            dests.setText("�f�[�^�ڍs��");
            dests.add(getDest(), VRLayout.CLIENT);
        }
        return dests;
    }

    /**
     * This method initializes contents
     * 
     * @return javax.swing.JPanel
     */
    private ACLabel getDest() {
        if (dest == null) {
            dest = new ACLabel();
            dest.setText("IP�F unknown" + ACConstants.LINE_SEPARATOR
                    + "�f�[�^�x�[�X�̏ꏊ�F unknown");
        }
        return dest;
    }

    private ACGroupBox dests;
    private ACLabel dest;
    private ACGroupBox infomations;
    private ACTextArea infomation;

    /**
     * This method initializes contents
     * 
     * @return javax.swing.JPanel
     */
    private ACGroupBox getInfomations() {
        if (infomations == null) {
            infomations = new ACGroupBox();
            infomations.setText("�f�[�^�ڍs�Ɋւ��邲����");
            infomations.add(getInfomation(), VRLayout.CLIENT);
        }
        return infomations;
    }

    /**
     * This method initializes contents
     * 
     * @return javax.swing.JPanel
     */
    private ACTextArea getInfomation() {
        if (infomation == null) {
            infomation = new ACTextArea();
            infomation.setRows(10);
            infomation.setLineWrap(true);
            infomation.setEditable(false);
            infomation
                    .setText("�y�f�[�^�ڍs�̑O�Ɂz"
                            + ACConstants.LINE_SEPARATOR
                            + "�@�����ǒ��{�̂��N�����Ă���ꍇ�A�K���I�������Ă���f�[�^�ڍs���s���Ă��������B"
                            + ACConstants.LINE_SEPARATOR
                            + "�@���f�[�^�ڍs���ύX����ꍇ�A���ǒ��{�̂��N�����ăf�[�^�x�[�X�̐ݒ��ύX���Ă��������B"
                            + ACConstants.LINE_SEPARATOR
                            + ACConstants.LINE_SEPARATOR
                            + "�y�ڍs�ł��Ȃ��f�[�^�ɂ��āz"
                            + ACConstants.LINE_SEPARATOR
                            + "�@���ی��Ҕԍ����ی��Ҕԍ��݂̂ŗv���x���ݒ肳��Ă��Ȃ��v���F�藚���͈ڍs����܂���B"
                            + ACConstants.LINE_SEPARATOR
                            + "�@�����Ə��ԍ���o�^���Ă��Ȃ����Ə����͈ڍs����܂���B"
                            + ACConstants.LINE_SEPARATOR
                            + "�@�����Ə��̒񋟃T�[�r�X���͈ڍs����܂���B"
                            + ACConstants.LINE_SEPARATOR
                            + "�@���K��Ō�񍐏��A�K��Ō�v�揑�A����×{�Ǘ��w�����̂����A�쐬������͂��Ă��Ȃ��f�[�^�͈ڍs����܂���B"
                            + ACConstants.LINE_SEPARATOR
                            + "�@������18�N4���̖@�����ŕύX���ꂽ�����ɂ��Ă͈ڍs����܂���B"
                            + ACConstants.LINE_SEPARATOR
                            + ACConstants.LINE_SEPARATOR
                            + "�y�ڍs�Ɏ��s�����ꍇ�z"
                            + ACConstants.LINE_SEPARATOR
                            + "�@���u�f�[�^�x�[�X�֐ڑ��ł��܂���B�v�Ƃ����G���[���\�����ꂽ�ꍇ�́A���ǒ��{�̂��N�����A�f�[�^��o�^�ł��邩�m�F���Ă��������B"

                    );

        }
        return infomation;
    }

    /**
     * This method initializes directory
     * 
     * @return javax.swing.JTextField
     */
    private ACTextField getSourceDirectory() {
        if (sourceDirectory == null) {
            sourceDirectory = new ACTextField();
            sourceDirectory.setColumns(30);
        }
        return sourceDirectory;
    }

    /**
     * This method initializes browse
     * 
     * @return javax.swing.JButton
     */
    private ACButton getSourceBrowse() {
        if (sourceBrowse == null) {
            sourceBrowse = new ACButton();
            sourceBrowse.setText("�Q��(B)..");
            sourceBrowse.setMnemonic('B');
            sourceBrowse.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    ACFileChooser chooser = new ACFileChooser();
                    File f = chooser.showDirectorySelectDaialog();
                    if (f != null) {
                        getSourceDirectory().setText(f.getAbsolutePath());
                    }
                }
            });
        }
        return sourceBrowse;
    }

    /**
     * This method initializes directorys
     * 
     * @return jp.nichicom.ac.container.ACLabelContainer
     */
    private ACGroupBox getSourceDirectorys() {
        if (sourceDirectorys == null) {
            sourceDirectorys = new ACGroupBox();
            sourceDirectorys.setAutoWrap(false);
            sourceDirectorys.setText("�ڍs��CSV�t�@�C���̏ꏊ");
            sourceDirectorys.add(getSourceDirectory(), null);
            sourceDirectorys.add(getSourceBrowse(), null);
        }
        return sourceDirectorys;
    }

    /**
     * ���܂��B
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            ACFrame.setVRLookAndFeel();
            ACFrameEventProcesser processer = new ACDefaultFrameEventProcesser() {
                protected String getExceptionMessage() {
                    return "�����𑱍s�ł��܂���B";
                }

                protected String getPropertyXMLPath() {
                    return "properity.xml";
                }

                public Dimension getDefaultWindowSize() {
                    return new Dimension(600, 500);
                }

                public Dimension getMinimumWindowSize() {
                    return new Dimension(600, 460);
                }

                public String getFrameIconPath() {
                    return "jp/or/med/orca/qkan/images/icon/flameicon.gif";
                }
            };
            ACFrame.getInstance().setFrameEventProcesser(processer);
            ACFrame.getInstance().next(
                    new ACAffairInfo(QkanMacCSVImport.class.getName()));
            ACFrame.getInstance().setVisible(true);
        } catch (Exception ex) {
            VRLogger.info(ex);
        }

    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.add(getJContentPane(), VRLayout.CLIENT);
        this.setTitle("���t�Ǘ��^����V�����x���\�t�gVer4.5�@Macintosh�p�f�[�^�ڍs�c�[��");
    }

    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private ACPanel getJContentPane() {
        if (contents == null) {
            contents = new ACPanel();
            contents.add(getMessage(), VRLayout.NORTH);
            contents.add(getButtons(), VRLayout.SOUTH);
            contents.add(getContents(), VRLayout.CLIENT);
        }
        return contents;
    }

    /**
     * This method initializes directorys
     * 
     * @return jp.nichicom.ac.component.ACLabel
     */
    private ACLabel getMessage() {
        if (message == null) {
            message = new ACLabel();
            message.setText("�@��ver����o�͂���CSV�t�@�C���̕ۑ�����w�肵�A���s�{�^�����������Ă��������B");
        }
        return message;
    }

    public void initAffair(ACAffairInfo affair) throws Exception {

        String ip = "unknown";
        String path = "unknown";
        boolean hasError = true;
        try {
            if (ACFrame.getInstance().hasProperty("DBConfig/Server")) {
                ip = ACFrame.getInstance().getProperty("DBConfig/Server");
                if (ACFrame.getInstance().hasProperty("DBConfig/Path")) {
                    path = ACFrame.getInstance().getProperty("DBConfig/Path");
                    hasError = false;
                }
            }
        } catch (Exception ex) {

        }
        StringBuffer sb = new StringBuffer();
        sb.append("IP�F ");
        sb.append(ip);
        sb.append(ACConstants.LINE_SEPARATOR);
        sb.append("�f�[�^�x�[�X�̏ꏊ�F ");
        sb.append(path);
        if (hasError) {
            sb.append(ACConstants.LINE_SEPARATOR);
            sb.append("���ڍs��̃f�[�^�x�[�X�ݒ���擾�ł��܂���B���ǒ��{�̂��N�����A�ݒ肵�Ă��������B");
            getExecute().setEnabled(false);
            getDest().setForeground(Color.red);
        }
        getDest().setText(sb.toString());
    }

    public boolean canBack(VRMap parameters) throws Exception {
        return false;
    }

    public Component getFirstFocusComponent() {
        return getSourceDirectory();
    }

}
