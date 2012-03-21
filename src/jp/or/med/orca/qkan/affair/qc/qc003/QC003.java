/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKANCHO�iJMA care benefit management software�j
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKANCHO (JMA care benefit management software)".
 *
 * This program is distributed in the hope that it will be useful
 * for further advancement in medical care, according to JMA Open
 * Source License, but WITHOUT ANY WARRANTY.
 * Everyone is granted permission to use, copy, modify and
 * redistribute this program, but only under the conditions described
 * in the JMA Open Source License. You should have received a copy of
 * this license along with this program. If not, stop using this
 * program and contact JMA, 2-28-16 Honkomagome, Bunkyo-ku, Tokyo,
 * 113-8621, Japan.
 *****************************************************************
 * �A�v��: QKANCHO
 * �J����: ����@��F
 * �쐬��: 2006/01/19  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �V�l�K��Ō�E�K��Ō���񋟏� (003)
 * �v���O���� �V�l�K��Ō�E�K��Ō�̏��񋟏� (QC003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc003;

import java.awt.event.ActionEvent;
import java.text.Format;
import java.util.Date;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �V�l�K��Ō�E�K��Ō�̏��񋟏�(QC003)
 */
@SuppressWarnings("serial")
public class QC003 extends QC003Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QC003() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * �������������s�Ȃ��܂��B
     * 
     * @param affair �Ɩ����
     * @throws Exception ������O
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        // �n��p�����[�^�[��ޔ�����B
        VRMap parameters = affair.getParameters();
        // this.patientId = PATIENT_ID(���p��ID)
        setPatientId(ACCastUtilities.toInt(parameters.getData("PATIENT_ID")));
        // this.targetDate = TARGET_DATE(�Ώ۔N���j
        setTargetDate((Date) parameters.getData("TARGET_DATE"));
        // �p�b�V�u�`�F�b�N�̃L�[���`����B
        // �e�[�u��:HOMONKANGO_JOHO_TEIKYOSHO
        // �L�[:PATIENT_ID, TARGET_DATE
        // �t�H�[�}�b�g:null,���t
        // �N���C�A���g�^�C���t�B�[���h:LAST_TIME
        // �T�[�o�^�C���t�B�[���h:LAST_TIME
        setPASSIVE_CHECK_JOHO_TEIKYOSHO(new ACPassiveKey(
                "HOMONKANGO_JOHO_TEIKYOSHO", new String[] { "PATIENT_ID",
                        "TARGET_DATE" }, new Format[] { null,
                        new ACSQLSafeDateFormat("yyyy/M/d") }, "LAST_TIME",
                "LAST_TIME"));

        setAffairTitle("QC003", getButtons());
        // �擾�����f�[�^�́u�E�C���h�E�^�C�g���iWINDOW_TITLE�j�v���E�C���h�E�ɐݒ肷��B
        // �擾�����f�[�^�́u�Ɩ��^�C�g���iAFFAIR_TITLE�j�v���Ɩ��{�^���o�[�ɐݒ肷��B

        // �v���x�̏����l�̐ݒ�
        getPatientYokaigodo().setSelectedIndex(1);
        
        // ��ʂ̏�����Ԃ�ݒ肷��B
        setState_INSERT_STATE();

        // �����߂蔻�ʃt���O�̒l�̏����ݒ�
        setForciblyBackCheckFlag(false);

        // �K��Ō�̏��񋟏����iHOMONKANGO_JOHO_TEIKYOSHO�j���擾����B
        doFindPassive();

    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // �����߂肩�`�F�b�N����B
        if (getForciblyBackCheckFlag()) {

            return true;
        }

        // ���݂̗��p�҂�I����Ԃɂ��邽�߃p�����[�^�[�𑗂�
        parameters.setData("PATIENT_ID", new Integer(getPatientId()));

        // �ύX�`�F�b�N�i�X�i�b�v�V���b�g�j
        if (!getSnapshot().isModified()) {
            // �ύX����Ă��Ȃ��ꍇ
            // �n���p�����[�^���쐬����B��KEY�FNEXT_AFFAIR VALUE�FQC003
            return true;
        }

        // �u���p�҈ꗗ�iQU001�j�v��ʂɖ߂�B�����p�҈ꗗ�Ŏ��ʂ��邽�߃p�����[�^�[�Ƃ��Ď���ʂ̉��ID��n���B
        // �X�V����Ă���ꍇ

        int msgID = 0;
        // PROCESS_MODE�̊m�F���s���B
        if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
            msgID = QkanMessageList.getInstance()
                    .WARNING_OF_INSERT_ON_MODIFIED();
        } else {
            msgID = QkanMessageList.getInstance()
                    .WARNING_OF_UPDATE_ON_MODIFIED();
        }
        // PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_INSERT�i4�j�v�������ꍇ�i�o�^���[�h�j
        // �o�^�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_INSERT_ON_MODIFIED
        switch (msgID) {
        // �u�o�^���Ė߂�v������
        case ACMessageBox.RESULT_YES:
            // ���̓`�F�b�N���s���B
            if (!doCheck()) {
                return false;
            }

            // ���̓G���[���Ȃ��ꍇ
            // �ۑ��������s���B
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                if (!doInsert()) {
                    return false;
                }
            } else {
                if (!doUpdate()) {
                    return false;
                }
            }

            // �ۑ�����������I�������ꍇ
            // �n���p�����[�^���쐬����B��KEY�FNEXT_AFFAIR VALUE�FQC003
            return true;

        // �u���p�҈ꗗ�iQU001�j�v��ʂɖ߂�B�����p�҈ꗗ�Ŏ��ʂ��邽�߃p�����[�^�[�Ƃ��Ď���ʂ̉��ID��n���B
        // �u�j�����Ė߂�v������
        case ACMessageBox.RESULT_NO:

            return true;

        default:

            return false;

        }
    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // �I������
        // �ύX�`�F�b�N�i�X�i�b�v�V���b�g�j
        if (!getSnapshot().isModified()) {
            // �Ō�ɕۑ�����Ă���A���ڂ��ύX����Ă��Ȃ��ꍇ
            // ���t�Ǘ��䒠�V�X�e�����I������B
            return true;
            
        }

        // �Ō�̕ۑ�����Ă���A���ڂ��ύX����Ă���ꍇ
        // ���m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_UPDATE_ON_MODIFIED
        int msgID = QkanMessageList.getInstance()
                .WARNING_OF_CLOSE_ON_MODIFIED();

        if (msgID == ACMessageBox.RESULT_YES) {
            // �u�͂��v������
            // ���ǒ��V�X�e�����I������B
            return true;
            
        } else {
            // �u�������v������
            // �����𔲂���B
            return false;
            
        }

    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�Ǎ��ݏ����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void openActionPerformed(ActionEvent e) throws Exception {

        // �O���ȑO�̃f�[�^�̒��ōŐV�̂��̂�Ǎ��ޏ���
        // �Ǎ��݊m�F���b�Z�[�W��\������B���b�Z�[�WID = QC001_WARNING_ON_READ_OF_MOST_NEW_DATA
        int msgID = QkanMessageList.getInstance()
                .QC001_WARNING_ON_READ_OF_MOST_NEW_DATA();
        // �uOK�v�{�^��������
        if (msgID == ACMessageBox.RESULT_OK) {
            // �O���ȑO�̖K��Ō�̏��񋟏����̃f�[�^�̒��ōŐV�̏����擾����B
            // SQL���擾�̂���HashMap�Fparam�𐶐����A���L��KEY/VALUE��ݒ肷��B
            VRMap param = new VRHashMap();
            // KEY�FPATIENT_ID VALUE�Fthis.patientId
            // KEY�FTARGET_DATE VALUE�FtargetDate
            param.setData("PATIENT_ID", new Integer(getPatientId()));
            param.setData("TARGET_DATE", (Date) getTargetDate());

            // �K��Ō�̏��񋟏����擾�̂��߂�SQL�����擾����B
            // �擾����SQL�������s����B
            VRList lastInfoList = getDBManager().executeQuery(
                    getSQL_GET_LAST_HOMONKANGO_JOHO_TEIKYOSHO(param));

            if (!lastInfoList.isEmpty()) {
                // ���R�[�h���擾�ł����ꍇ
                // �擾�����z���johoTeikyoshoMap�Ɋi�[����B
                VRMap lastInfoMap = (VRMap) lastInfoList.getData(0);
                // �擾�������R�[�h�̒����牺�L��KEY���폜����B
                // KEY�FJOHO_TEIKYO_SAKI
                // KEY�FHOMON_KAISU_DAY
                // KEY�FHOMON_KAISU_COUNT
                lastInfoMap.removeData("JOHO_TEIKYO_SAKI");
                lastInfoMap.removeData("HOMON_KAISU_DAY");
                lastInfoMap.removeData("HOMON_KAISU_COUNT");
                lastInfoMap.removeData("CREATE_DATE");
                
                // [ID:0000574][Masahiko Higuchi] 2010/01 add begin 2009�N�x�Ή� 
                // �v���x�̔F��`�F�b�N
                VRList patientNinteiHistory = QkanCommon
                        .getPatientInsureInfoOnEndOfMonth(getDBManager(),
                                getTargetDate(), getPatientId());
                if(patientNinteiHistory != null && patientNinteiHistory.size() >= 1){
                    // �����̖��̏����擾����
                    VRMap history = (VRMap)patientNinteiHistory.getData(0);
                    lastInfoMap.setData("JOTAI_CODE",history.getData("JOTAI_CODE"));
                } else {
                    // �������擾�ł��Ȃ��̂ŁA�����ɐݒ�
                    lastInfoMap.setData("JOTAI_CODE",new Integer(1));
                }
                // [ID:0000574][Masahiko Higuchi] 2010/01 add end

                // johoTeikyoshoMao���u�N���C�A���g�̈�icontents�j�v�ɃZ�b�g����B
                getContents().setSource(lastInfoMap);

                // contents�Ƀf�[�^��W�J����B
                getContents().bindSource();

            } else {
                // �擾������0���̏ꍇ
                // �ߋ���񂪑��݂��Ȃ��������Ƃ�ʒm���郁�b�Z�[�W��\������B�����b�Z�[�WID =
                // QC001_NOTICE_HAS_NO_LAST_DATA
                QkanMessageList.getInstance().QC001_NOTICE_HAS_NO_LAST_DATA();
                // �f�[�^�̏㏑�͍s��Ȃ��B
                return;

            }
        }
    }

    /**
     * �u�o�^�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // �K��Ō�̏��񋟏�����o�^���鏈��
        // ���̓`�F�b�N���s���B
        // ���̓G���[���Ȃ��ꍇ
        if (!doCheck()) {
            return;
        }

        // �K��Ō�̏��񋟏�����ۑ����鏈��
        // PROCESS_MODE�̊m�F���s���B
        if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
            // PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_INSERT(4)�v�������ꍇ�i�o�^���[�h�j
            // �o�^�������s��
            if (!doInsert()) {
                // �G���[�����������ꍇ�͏����𔲂���
                return;
            }
        } else {
            // �������������Ă���ꍇ
            ACMessageBox.show("INSERT�{�^���@�������[�h������");

        }

        // �o�^�������b�Z�[�W��\������B�����b�Z�[�WID = INSERT_SUCCESSED
        QkanMessageList.getInstance().INSERT_SUCCESSED();

        // ��ʏ�Ԃ�ύX����B
        setState_UPDATE_STATE();

        // �p�b�V�u�`�F�b�N����o�^����B
        doFindPassive();

    }

    /**
     * �u�X�V�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {
        // �K��Ō�̏��񋟏������X�V����
        // ���̓`�F�b�N���s���B
        // ���̓G���[���Ȃ��ꍇ
        if (!doCheck()) {
            // �����𔲂���
            return;
        }

        // �K��Ō�̏��񋟏�����ۑ����鏈��
        // PROCESS_MODE�̊m�F���s���B
        if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
            // PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_UPDATE(3)�v�������ꍇ�i�X�V���[�h�j
            // �X�V�������s��
            if (!doUpdate()) {
                // �G���[�����������ꍇ�͏����𔲂���
                return;
            }

        } else {
            // �������[�h���������Ă���ꍇ
            ACMessageBox.show("UPDATE�{�^���@�������[�h������");
        }

        // �X�V�������b�Z�[�W��\������B�����b�Z�[�WID = UPDATE_SUCCESSED
        QkanMessageList.getInstance().UPDATE_SUCCESSED();

        // �p�b�V�u�`�F�b�N����o�^����B
        doFindPassive();

    }

    /**
     * �u��������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void printActionPerformed(ActionEvent e) throws Exception {
        // �K��Ō���񋟏���������鏈��
        // ���̓`�F�b�N���s���B
        if (!doCheck()) {
            return;
        }

        // ���̓G���[���Ȃ��ꍇ
        // �ȉ��̈�����n���A����m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_PRINT
        // �ύX���������ꍇ
        int msgID = 0;

        if (getSnapshot().isModified()) {

            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // �o�^�p���b�Z�[�W���쐬����
                msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("�o�^",
                        "�K��Ō�v�揑");
            } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // �X�V�p���b�Z�[�WID���쐬����
                msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("�X�V",
                        "�K��Ō�v�揑");
            }

        }

        // �OK�v������
        if (msgID == ACMessageBox.RESULT_OK) {
            // �ۑ��������s���B���ۑ������Ɏ��s�����ꍇ�͏����𒆒f����B
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // ���炩�̃G���[���������ꍇ�����𒆒f����B
                if (!doInsert()) {
                    return;
                }

            } else {
                // ���炩�̃G���[���������ꍇ�����𒆒f����B
                if (!doUpdate()) {
                    return;
                }
            }

        } else {
            // �L�����Z�����I�΂ꂽ�ꍇ�����𒆒f����B
            return;

        }

        VRMap printParam = new VRHashMap();
        // ��ʏ�̏���printParam�Ɋi�[����B
        getContents().setSource(printParam);
        getContents().applySource();
        // �K��Ō�̏��񋟏����쐬����B
        // dojPrint(QC00301, printParam);

        // �K��Ō�̏��񋟏����o�͂���B
        // ����Ǘ��N���X�𐶐�
        ACChotarouXMLWriter writer = new ACChotarouXMLWriter();

        // ����J�n��錾
        writer.beginPrintEdit();

        // printParam.setData()
        QC003P01 qc003p01 = new QC003P01();

        // �������B
        if (qc003p01.doPrint(writer, printParam)) {

            // �������ꂽ�ꍇ
            writer.endPrintEdit();
            // PDF�t�@�C���𐶐����ĊJ��
            ACChotarouXMLUtilities.openPDF(writer);

        } else {
            // ��������Ȃ������ꍇ
            return;
        }

        doFindPassive();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();

        param.setData("PATIENT_ID", new Integer(38));
        param.setData("TARGET_DATE", new Date(106, 0, 1));
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QC003.class.getName(), param));
    }

    // �����֐�

    /**
     * �u�p�b�V�u�`�F�b�N���o�^�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doFindPassive() throws Exception {

        // ��ʓW�J�p�̃f�[�^���i�[����B
        VRMap copyPatientMap = new VRHashMap();

        VRList patientList = (VRList) QkanCommon.getPatientInfo(getDBManager(),
                getPatientId());

        // ���p�ҏ�񂪎擾�o�������`�F�b�N����
        if (patientList.size() > 0) {
            // �擾�����f�[�^�[���i�[����
            copyPatientMap.putAll((VRMap) patientList.getData(0));

        } else {
            int msgID = QkanMessageList.getInstance()
                    .ERROR_OF_PASSIVE_CHECK_ON_FIND();

            // �G���[�����������߂蔻��
            setForciblyBackCheckFlag(true);
            ACFrame.getInstance().back();
            return;
        }

        // ���p�җv�������擾����B
        VRList yokaigodoList = QkanCommon.getPatientInsureInfoOnEndOfMonth(
                getDBManager(), getTargetDate(), getPatientId());

        if (!(yokaigodoList == null || yokaigodoList.size() == 0)) {
            copyPatientMap.putAll((VRMap) yokaigodoList.getData(0));
        }

        
        // ���R�[�h���擾�ł����ꍇ
        Date systemDate = QkanSystemInformation.getInstance().getSystemDate();

        copyPatientMap.setData("CREATE_DATE", systemDate);
        // patientMap�ɗ��p�Ҋ�{�����i�[����B
        // patientName�ɗ��p�҂̃t���l�[�����i�[����B
        // toFullName(PATIENT_FAMILY_NAME, PATIENT_FIRST_NAME);
        copyPatientMap.setData("PATIENT_FULL_NAME",
                QkanCommon.toFullName(
                copyPatientMap.getData("PATIENT_FAMILY_NAME"), copyPatientMap
                        .getData("PATIENT_FIRST_NAME")));

        copyPatientMap.setData("JOHO_TEIKYO_SAKI", "");
        // patientMap�ɁA���L��KEY/VALUE��ݒ肷��
        // KEY�FPATIENT_AGE VALUE�FpatientAge
        // KEY�FPATIENT_NAME VALUE�FpatientName

        // ���O�C�����Ə��ԍ����擾���A�ȉ���KEY��loginProviderMap�iVRMap�j�Ɋi�[����B
        // KEY�FPROVIDER_ID
        VRMap loginProviderMap = new VRHashMap();
        loginProviderMap.setData("PROVIDER_ID", QkanSystemInformation
                .getInstance().getLoginProviderID());

        // �����Ə��̃T�[�r�X�ڍ׏����擾
        VRList johoList = new VRArrayList();

        johoList = getJohoteikyoshoInfo();

        // ���R�[�h���擾�ł����ꍇ
        if (!johoList.isEmpty()) {
            // �擾�����z���johoTeikyoshoList�Ɋi�[����B
            // johoTeikyoshoList�̍ŏ��̃��R�[�h��johoTeikyoshoMap�Ɋi�[����B
            copyPatientMap.putAll((VRMap) johoList.getData(0));
        }

        if (johoList.size() > 0) {
            // PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_UPDATE(3)�v�ɐݒ肷��B�i�X�V���[�h�j
            setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
            // ��ʏ�Ԃ�ύX����B
            setState_UPDATE_STATE();
        } else {
            // ���R�[�h���擾�ł��Ȃ������ꍇ
            // PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_INSERT(4)�v�ɐݒ肷��B�i�o�^���[�h�j
            setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
            // ��ʏ�Ԃ�ύX����B
            setState_INSERT_STATE();
        }

        // �擾����������ʂɐݒ肷��
        getContents().setSource(copyPatientMap);
        // ��ʂɓW�J����B
        getContents().bindSource();
        // �p�b�V�u�^�X�N���N���A����B
        getPassiveChecker().clearPassiveTask();
        // �p�b�V�u�L�[��o�^����B
        getPassiveChecker().reservedPassive(getPASSIVE_CHECK_JOHO_TEIKYOSHO(),
                copyPatientMap);
        // �X�i�b�v�V���b�g�̎B�e�Ώۂ��w�肷��B
        getSnapshot().setRootContainer(getContents());
        // �X�i�b�v�V���b�g���B�e����B
        getSnapshot().snapshot();
    }

    /**
     * �u�o�^�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean doInsert() throws Exception {
        // �K��Ō���񋟏�����o�^���鏈��
        VRMap applyMap = new VRHashMap();

        // ��ʏ�̃f�[�^���擾����B
        getContents().setSource(applyMap);
        getContents().applySource();

        // KEY�FPATIENT_ID VALUE�FpatientId
        // KEY�FTARGET_DATE VALUE�FtargetDate
        applyMap.setData("PATIENT_ID", new Integer(getPatientId()));
        applyMap.setData("TARGET_DATE", (Date) getTargetDate());

        // �g�����U�N�V�������J�n����
        try {
            getDBManager().beginTransaction();
            // �p�b�V�u�^�X�N���N���A����B
            getPassiveChecker().clearPassiveTask();
            // �p�b�V�u�^�X�N��o�^����B
            getPassiveChecker().addPassiveInsertTask(
                    getPASSIVE_CHECK_JOHO_TEIKYOSHO(), applyMap);
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                //�e�[�u�����b�N�����̂��߃��[���o�b�N
                getDBManager().rollbackTransaction();
                // �p�b�V�u�G���[������ꍇ
                // �p�b�V�u�G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // �����𒆒f����B(�ُ�I��)
                return false;
            }
            // �p�b�V�u�G���[���Ȃ��ꍇ
            // �K��Ō�̏��񋟏����o�^�p�́ASQL�����擾����B
            // �擾����SQL�������s����B
            getDBManager()
                    .executeUpdate(getSQL_INSERT_JOHO_TEIKYOSHO(applyMap));

            // SQL�����s�����ŁA�G���[���Ȃ��ꍇ
            // �������R�~�b�g����B
            getDBManager().commitTransaction();
            // PROCESS_MODE���A���ʒ萔�́uPROCESS_MODE_UPDATE(3)�v�ɐݒ肷��B�i�X�V���[�h�j
            setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
            // ��ʏ�Ԃ�ύX����B
            setState_UPDATE_STATE();
            // �X�i�b�v�V���b�g���B�e����B
            getSnapshot().snapshot();

            return true;

        } catch (Exception sqlEx) {
            // SQL�����s�����ŃG���[������ꍇ
            sqlEx.printStackTrace();
            // ���������[���o�b�N����B
            getDBManager().rollbackTransaction();
            // ��O�G���[�𓊂���
            throw sqlEx;
        }
    }

    /**
     * �u�X�V�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean doUpdate() throws Exception {
        VRMap applyMap = new VRHashMap();
        // ��ʂ̏����擾����
        getContents().setSource(applyMap);
        getContents().applySource();

        // KEY�FPATIENT_ID VALUE�FpatientId
        // KEY�FTARGET_DATE VALUE�FtargetDate
        applyMap.setData("PATIENT_ID", new Integer(getPatientId()));
        applyMap.setData("TARGET_DATE", (Date) getTargetDate());

        // �K��Ō���񋟏������X�V���鏈��
        try {
            // �g�����U�N�V�������J�n����
            getDBManager().beginTransaction();
            // �p�b�V�u�^�X�N���N���A����B
            getPassiveChecker().clearPassiveTask();
            // �p�b�V�u�^�X�N��o�^����B
            getPassiveChecker().addPassiveUpdateTask(
                    getPASSIVE_CHECK_JOHO_TEIKYOSHO());
            // �p�b�V�u�`�F�b�N���s���B
            // �p�b�V�u�G���[���Ȃ��ꍇ

            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                //�e�[�u�����b�N�����̂��߃��[���o�b�N
                getDBManager().rollbackTransaction();
                // �p�b�V�u�G���[������ꍇ
                // �p�b�V�u�G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // �����𒆒f����B(�ُ�I��)
                return false;
            }

            // �K��Ō�̏��񋟏����X�V�pSQL�����擾����B
            // �擾����SQL�������s����B
            getDBManager()
                    .executeUpdate(getSQL_UPDATE_JOHO_TEIKYOSHO(applyMap));

            // SQL�����s�����ŁA�G���[���Ȃ��ꍇ
            // �������R�~�b�g����B
            getDBManager().commitTransaction();

            // �X�i�b�v�V���b�g���B�e����B
            getSnapshot().snapshot();

            return true;

        } catch (Exception sqlEx) {
            // SQL�����s�����ŁA�G���[������ꍇ
            sqlEx.printStackTrace();
            // ���������[���o�b�N����B
            getDBManager().rollbackTransaction();
            // ��O�G���[�𓊂���
            // �����𔲂���B
            throw sqlEx;

        }

    }

    /**
     * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean doCheck() throws Exception {
        // ���̓`�F�b�N���s������
        // ���L�̃e�L�X�g�t�B�[���h�ɐ������l�����͂���Ă��邩�`�F�b�N����B
        // �E���{���iresultDay�j�����͂���Ă��邩�`�F�b�N����B
        if (ACTextUtilities.isNullText(getResultDay().getText())) {
            // ���͂���Ă��Ȃ������ꍇ
            // �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("���{��");

            getResultDay().requestFocus();
            // �����𔲂���B�i�����𒆒f����j
            return false;
        }

        // �E���{���iresultDay�j�̒l���`�F�b�N����B
        // �l���s���������ꍇ
        if (!getResultDay().isValidDate()) {
            // �ȉ��̈�����n���A�G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_WRONG_DATE ���� = ���{��
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("���{��");
            // �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
            getResultDay().requestFocus();
            return false;
            // �����𒆒f����B
        }
        return true;

    }

    /**
     * �u�n���p�����[�^�[�쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void setParameter() throws Exception {
        // affairMap�ɁA���L��KEY/VALUE��ݒ肷��B
        // KEY�FNEXT_AFFAIR VALUE�FQC003

    }

    /**
     * �K��Ō�̏��񋟏����擾�Ɋւ��鏈�����s���܂��B
     * 
     * @throws Exception
     */
    public VRList getJohoteikyoshoInfo() throws Exception {

        VRMap param = new VRHashMap();
        // �K��Ō�̏��񋟏������擾���鏈��
        // SQL���擾�̂���HashMap�Fparam�𐶐����A���L��KEY/VALUE��ݒ肷��B
        param = new VRHashMap();
        // KEY�FPATIENT_ID VALUE�Fthis.patientId
        param.setData("PATIENT_ID", new Integer(getPatientId()));
        // KEY�FTARGET_DATE VALUE�FtaragetDate
        param.setData("TARGET_DATE", (Date) getTargetDate());
        // �K��Ō�̏��񋟏����擾�̂��߂�SQL�����擾����B
        // �擾����SQL�������s����B
        VRList johoList = getDBManager().executeQuery(
                getSQL_GET_HOMONKANGO_JOHO_TEIKYOSHO(param));

        return johoList;
    }

}
