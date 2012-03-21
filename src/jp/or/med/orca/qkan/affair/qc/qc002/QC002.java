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
 * �J����: �� ����
 * �쐬��: 2006/01/14  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �񍐏������� (002)
 * �v���O���� �񍐏������� (QC002)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc002;

import java.awt.event.ActionEvent;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRDateFormat;
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
 * �񍐏�������(QC002)
 */
@SuppressWarnings("serial")
public class QC002 extends QC002Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QC002() {
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
        // �n��f�[�^�̎擾/�O��ʁu���p�҈ꗗ�v����n���ꂽ�p�����[�^��ޔ�����B
        VRMap parameters = affair.getParameters();
        // this.patientID = PATIENT_ID(���p��ID)
        if (VRBindPathParser.has("PATIENT_ID", parameters)) {
            setPatientID(Integer.parseInt(String.valueOf(VRBindPathParser.get(
                    "PATIENT_ID", parameters))));
        }
        // this.targetDateSource = TARGET_DATE(�Ώ۔N��)
        if (VRBindPathParser.has("TARGET_DATE", parameters)) {
            setTargetDateSource((Date) VRBindPathParser.get("TARGET_DATE",
                    parameters));
        }
        // �u�K��Ō�񍐏�TABLE(HOMONKANGO_RESULT)�v�̃p�b�V�u�`�F�b�N�̃L�[���`����B
        // �e�[�u��:HOMONKANGO_RESULT
        // �L�[:PATIENT_ID, TARGET_DATE
        // �t�H�[�}�b�g:���l,�N����
        // �N���C�A���g�^�C���t�B�[���h:LAST_TIME
        // �T�[�o�^�C���t�B�[���h:LAST_TIME
        setPASSIVE_CHECK_KEY_RESULT(new ACPassiveKey("HOMONKANGO_RESULT",
                new String[] { "PATIENT_ID", "TARGET_DATE" }, new Format[] {
                        null, new ACSQLSafeDateFormat("yyyy/M/d") },
                "LAST_TIME", "LAST_TIME"));
        // �u�K��Ō�v�揑�E�K���TABLE(HOMONKANGO_RESULT_CALENDAR)�v(������)�̃p�b�V�u�`�F�b�N�̃L�[���`����B
        // �e�[�u��:HOMONKANGO_RESULT_CALENDAR
        // �L�[:PATIENT_ID, NOTE_ID
        // �t�H�[�}�b�g:���l,�N����
        // �N���C�A���g�^�C���t�B�[���h:LAST_TIME
        // �T�[�o�^�C���t�B�[���h:LAST_TIME
        setPASSIVE_CHECK_KEY_CALENDAR_LEFT(new ACPassiveKey(
                "HOMONKANGO_RESULT_CALENDAR", new String[] { "PATIENT_ID",
                        "VISIT_DATE" }, new Format[] { null,
                        new ACSQLSafeDateFormat("yyyy/M/d") }, "LAST_TIME",
                "LAST_TIME"));
        // �u�K��Ō�v�揑�E�K���TABLE(HOMONKANGO_RESULT_CALENDAR)�v(������)�̃p�b�V�u�`�F�b�N�̃L�[���`����B
        // �e�[�u��:HOMONKANGO_RESULT_CALENDAR
        // �L�[:PATIENT_ID, NOTE_ID
        // �t�H�[�}�b�g:���l,�N����
        // �N���C�A���g�^�C���t�B�[���h:LAST_TIME
        // �T�[�o�^�C���t�B�[���h:LAST_TIME
        setPASSIVE_CHECK_KEY_CALENDAR_RIGHT(new ACPassiveKey(
                "HOMONKANGO_RESULT_CALENDAR", new String[] { "PATIENT_ID",
                        "VISIT_DATE" }, new Format[] { null,
                        new ACSQLSafeDateFormat("yyyy/M/d") }, "LAST_TIME",
                "LAST_TIME"));
        // �\������Ώ۔N�����쐬���鏈��
        Date from = getTargetDateSource();
        // �t�H�[�}�b�g���`����
        VRDateFormat fr = new VRDateFormat("ggge�NM��");

        // �t�H�[�}�b�g��K�p�����f�[�^��ϐ��Ɋi�[����
        String createDate = fr.format(from);

        getTargetDate().setText(createDate);

        // ��ʂ̏��������s���B
        doInitialize();

        // �X�i�b�v�V���b�g�̎B�e�Ώۂ��w�肷��B
        getSnapshot().setRootContainer(getContents());

        // DB����f�[�^���擾����B
        doFind();

    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }

        parameters.setData("PATIENT_ID", new Integer(getPatientID()));

        // �����߂�ł��邩����
        if (getForciblyBackCheckFlag()) {
            return true;
        }

        // ���X�i�b�v�V���b�g�`�F�b�N
        // �X�i�b�v�V���b�g�̍X�V�`�F�b�N���s���B
        if (!getSnapshot().isModified()) {
            // �X�V����Ă��Ȃ��ꍇ
            // �O��ʂɖ߂�B
            return true;
        }

        // �X�V����Ă���ꍇ
        // �������p������B
        // ���ۑ��m�F
        // ���\�����b�Z�[�W�̌���
        // �\�����b�Z�[�WID�i�[�p�̐��l�^�ϐ� msgID ���`����B
        int msgID = 0;
        // processMode�̒l���`�F�b�N����B
        if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
            // PROCESS_MODE_INSERT(�o�^)�̏ꍇ
            // msgID�ɁAWARNING_OF_INSERT_ON_MODIFIED��ݒ肷��B
            msgID = QkanMessageList.getInstance()
                    .WARNING_OF_INSERT_ON_MODIFIED();
        } else {
            // PROCESS_MODE_UPDATE(�X�V)�̏ꍇ
            // msgID�ɁAWARNING_OF_UPDATE_ON_MODIFIED��ݒ肷��B
            msgID = QkanMessageList.getInstance()
                    .WARNING_OF_UPDATE_ON_MODIFIED();
        }

        // ���m�F���b�Z�[�W�̕\��
        // �ۑ��m�F�̃��b�Z�[�W��\������B�����b�Z�[�WID��msgID�̒l
        // showMsg(msgID);
        switch (msgID) {
        case ACMessageBox.RESULT_YES:
            // �u�X�V���Ė߂�v�I����
            // �������p������B
            break;

        case ACMessageBox.RESULT_NO:
            // �u�j�����Ė߂�v�I����
            // �O��ʂɖ߂�B
            return true;

        case ACMessageBox.RESULT_CANCEL:
            // �u�L�����Z���v�I����
            // �����𒆒f����B
            return false;
        }

        // �����̓`�F�b�N
        // ���̓`�F�b�N���s���B
        if (!checkValidInput()) {
            // �G���[������ꍇ
            // �����𒆒f����B
            return false;
        }
        // �G���[���Ȃ��ꍇ
        // �������p������B

        // ���ۑ�����
        // �ۑ��������s���B
        // �������[�h�𔻕ʂ���
        if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
            // �o�^���[�h�������ꍇ
            if (!doInsert()) {
                // ���炩�̃G���[�����������ꍇ
                return false;
            }
        } else {
            // �X�V���[�h�������ꍇ
            if (!doUpdate()) {
                // ���炩�̃G���[�����������ꍇ
                return false;
            }
        }

        // �ۑ�����������I�������ꍇ
        // �O��ʂɖ߂�B
        return true;
        // �ۑ��������ُ�I�������ꍇ
        // �����𒆒f����B

    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // ���X�i�b�v�V���b�g�`�F�b�N
        // �X�i�b�v�V���b�g�̍X�V�`�F�b�N���s���B
        if (!getSnapshot().isModified()) {
            // �X�V����Ă��Ȃ��ꍇ
            // �V�X�e�����I������B
            return true;
        }
        // �X�V����Ă���ꍇ
        // �������p������B
        // ���I���m�F
        // �I���m�F�̃��b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_CLOSE_ON_MODIFIED
        int msgID = QkanMessageList.getInstance()
                .WARNING_OF_CLOSE_ON_MODIFIED();

        if (msgID == ACMessageBox.RESULT_OK) {
            // �uOK�v�I����
            // �V�X�e�����I������B
            return true;
        } else {
            // �u�L�����Z���v�I����
            // �����𒆒f����B
            return false;
        }

    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u��������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void printActionPerformed(ActionEvent e) throws Exception {
        // ���������

        // �쐬�N�����̓��̓`�F�b�N���s��
        if (!checkValidInput()) {
            // �����s��Ȃ�
            return;
        }

        // �ύX���ʃt���O true : �ύX�L�� false : �ύX����
        boolean changeFlag = false;

        // ��ʏ�ԂɕύX�����邩�`�F�b�N����
        if (getSnapshot().isModified()) {
            changeFlag = true;
        }

        if (changeFlag) {
            // ���b�Z�[�W�i�[�p
            int msgID = 0;

            // �ύX���������ꍇ
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // �o�^�p���b�Z�[�W���쐬����
                msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("�o�^",
                        "�K��Ō�v�揑");
            } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // �X�V�p���b�Z�[�WID���쐬����
                msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("�X�V",
                        "�K��Ō�v�揑");
            }

            // �ۑ��m�F
            if (msgID == ACMessageBox.RESULT_OK) {

                // OK������
                if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                    // �o�^�������s�� ���炩�̃G���[�����������ꍇ�͒��f
                    if (!doInsert()) {
                        return;
                    }
                } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                    // �X�V�������s�� ���炩�̃G���[�����������ꍇ�͒��f
                    if (!doUpdate()) {
                        return;
                    }
                }

                // �ۑ����Ȃ��ꍇ
            } else {

                // �����s��Ȃ�
                return;
            }

        } else {

            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // �o�^�������s�� ���炩�̃G���[�����������ꍇ�͒��f
                if (!doInsert()) {
                    return;
                }
            } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // �X�V�������s�� ���炩�̃G���[�����������ꍇ�͒��f
                if (!doUpdate()) {
                    return;
                }
            }
        }

        // ����N���X�ւ̓n��p�����[�^(���R�[�h) printParam�𐶐�����B
        VRMap printParam = new VRHashMap();
        // ��{�����i�[����
        VRMap houkokusyoInfo = new VRHashMap();
        // �J�����_�[�����i�[����
        VRMap calendarMap = new VRHashMap();

        // printParam�ɁA��ʂ��璊�o���������i�[����B
        getContents().setSource(houkokusyoInfo);
        getContents().applySource();

        // �J�����_�[�����擾���i�[����
        getCalendars().setSource(calendarMap);
        getCalendars().applySource();

        // print�N���X�Ŏg�p����f�[�^���i�[����B
        houkokusyoInfo.setData("PRINT_CALENDAR_LEFT_MONTH",
                getTargetDateSource());
        houkokusyoInfo.setData("PRINT_CALENDAR_RIGHT_MONTH", ACDateUtilities
                .addMonth(getTargetDateSource(), 1));
        calendarMap.removeData("CALENDAR_LEFT_YEAR");
        calendarMap.removeData("CALENDAR_LEFT_MONTH");
        calendarMap.removeData("CALENDAR_RIGHT_YEAR");
        calendarMap.removeData("CALENDAR_RIGHT_MONTH");

        // printParam�Ɋi�[����
        printParam.setData("HOUKOKUSYO_INFO", houkokusyoInfo);
        printParam.setData("CALENDAR", calendarMap);

        // �������B
        // doPrint(QC00201, printParam);
        ACChotarouXMLWriter writer = new ACChotarouXMLWriter();

        // ����J�n��錾
        writer.beginPrintEdit();

        // ����N���X����
        QC002P01 qc002p01 = new QC002P01();

        // �������B
        if (qc002p01.doPrint(writer, printParam)) {

            // �������ꂽ�ꍇ
            // ����I����錾
            writer.endPrintEdit();

            // PDF�t�@�C���𐶐����ĊJ��
            ACChotarouXMLUtilities.openPDF(writer);

        } else {
            // ��������Ȃ������ꍇ
        }

        doFind();

    }

    /**
     * �u���߂̖K��Ō�񍐏����̓Ǎ��v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void openActionPerformed(ActionEvent e) throws Exception {
        // ���������s�m�F
        // �������s�̊m�F�̂��߁A���b�Z�[�W��\������B�����b�Z�[�WID =
        // QC001_WARNING_ON_READ_OF_MOST_NEW_DATA
        int msgID = QkanMessageList.getInstance()
                .QC001_WARNING_ON_READ_OF_MOST_NEW_DATA();

        // �OK�v�I����
        // �������p������B
        if (msgID == ACMessageBox.RESULT_CANCEL) {
            // �u�L�����Z���v�I����
            // �����𒆒f����B
            return;
        }
        // ���ߋ��̒��߂̏����擾
        VRMap sqlParam = new VRHashMap();
        // SQL���擾�֐��ւ̓n��p�����[�^(���R�[�h) sqlParam�ɉ��L�p�����[�^��ݒ肷��B
        // KEY : PATIENT_ID, VALUE : patientID (�ޔ������n��p�����[�^)
        sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
        // KEY : TARGET_DATE, VALUE : targetDateSource (�ޔ������n��p�����[�^)
        sqlParam.setData("TARGET_DATE", getTargetDateSource());

        // �ߋ��̖K��Ō�񍐏����̂����A�ŐV�̏����擾���邽�߂�SQL�����擾����B
        // �擾����SQL���𔭍s����B
        VRList lastHoukokusyo = getDBManager().executeQuery(
                getSQL_GET_LAST_RESULT(sqlParam));
        VRMap lastHoukokusyoMap = new VRHashMap();

        if (lastHoukokusyo.size() > 0) {
            // �擾������0����葽���ꍇ
            // �擾���R�[�h�W����1���ڂ̃��R�[�h��ޔ�����B
            VRMap map = (VRMap) lastHoukokusyo.getData(0);

            lastHoukokusyoMap.putAll(map);

            Date leftDate = (Date) map.getData("TARGET_DATE");
            Date rightDate = ACDateUtilities.addMonth(leftDate, 1);
            // ��ʓW�J�p�̃f�[�^���쐬����B
            lastHoukokusyoMap.putAll(createBindData(leftDate, "LEFT"));
            lastHoukokusyoMap.putAll(createBindData(rightDate, "RIGHT"));

            // [ID:0000574][Masahiko Higuchi] 2010/01 add begin 2009�N�x�Ή� 
            // �v���x�̔F��`�F�b�N 
            VRList patientNinteiHistory = QkanCommon
                    .getPatientInsureInfoOnEndOfMonth(getDBManager(),
                            getTargetDateSource(), getPatientID());
            if(patientNinteiHistory != null && patientNinteiHistory.size() >= 1){
                // �����̖��̏����擾����
                VRMap history = (VRMap)patientNinteiHistory.getData(0);
                lastHoukokusyoMap.setData("JOTAI_CODE",history.getData("JOTAI_CODE"));
            } else {
                // �������擾�ł��Ȃ��̂ŁA�����ɐݒ�
                lastHoukokusyoMap.setData("JOTAI_CODE",new Integer(1));
            }
            // [ID:0000574][Masahiko Higuchi] 2010/01 add end
            
            // �J�����_�[���̏����l��ݒ肷��
            initializeCalendar();
            // ��ʂɑO������W�J����
            getContents().setSource(lastHoukokusyoMap);
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

    /**
     * �u�o�^�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // ���f�[�^��DB�ɓo�^
        // �����̓`�F�b�N
        // ���̓`�F�b�N���s���B
        if (!checkValidInput()) {
            // �G���[������ꍇ
            // �����𒆒f����B
            return;
        }

        // �G���[���Ȃ��ꍇ
        // �������p������B
        // ���o�^����
        // �o�^�������s���B
        if (!doInsert()) {
            return;
        }

        // ���������ʒm���b�Z�[�W��\������B�����b�Z�[�WID = UPDATE_SUCCESSED
        QkanMessageList.getInstance().INSERT_SUCCESSED();

        // ��ʂ̏��������s���B
        doInitialize();

        // �����������s���B
        doFind();

    }

    /**
     * �u�X�V�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {
        // ���f�[�^��DB�ɍX�V
        // �����̓`�F�b�N
        // ���̓`�F�b�N���s���B
        if (!checkValidInput()) {
            // �G���[������ꍇ
            // �����𒆒f����B
            return;
        }

        // �G���[���Ȃ��ꍇ
        // �������p������B
        // ���X�V����
        // �X�V�������s���B
        if (!doUpdate()) {
            return;
        }

        // ���������ʒm���b�Z�[�W��\������B�����b�Z�[�WID = UPDATE_SUCCESSED
        QkanMessageList.getInstance().UPDATE_SUCCESSED();

        // ��ʂ̏��������s���B
        doInitialize();

        // �����������s���B
        doFind();

    }

    /**
     * �u�I�����Ə��̊Ǘ��Ҏ����̐ݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void providerNameActionPerformed(ActionEvent e) throws Exception {
        // �R���{�ɓ��͂���Ă��鎖�Ə�������A���̎��Ə��́u�Ǘ��Ҏ���(ADMINISTRATOR_NAME)�v(������)���擾����B
        Object a = getProviderName().getSelectedItem();

        if (getProviderName().getSelectedIndex() >= 0) {
            // getAdministratorName((�R���{�̑I���A�C�e���̃��R�[�h));
            // ��ʂ́u�Ǘ��Ҏ���(administratorName)�v�ɁA�擾�����������ݒ肷��B

            String adName = "";

            // �Ǘ��Ҏ������擾����
            adName = String.valueOf(getAdministratorName((VRMap) getProviderName()
                    .getSelectedModelItem()));

            // �e�L�X�g�G���A�ɃZ�b�g
            getAdministratorName().setText(adName);

        }
    }

    /**
     * �u�K������i���j��W�J���鏈���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void resultReadButtonLeftActionPerformed(ActionEvent e)
            throws Exception {
        // �K������i���j��W�J���鏈��

        VRDateFormat vf = new VRDateFormat("ggge�NM��");

        String message = String.valueOf(vf.format(getTargetDateSource()) + "�x");

        int msgID = QkanMessageList.getInstance().QC002_WARNING_OF_RESULT(
                message);

        if (msgID == ACMessageBox.RESULT_YES) {
            // �����ϐ� leftMap �𐶐�����B
            VRMap leftMap = new VRHashMap();

            // leftMap�Ɏ��т��擾����
            leftMap = getVisitDataFromService(getTargetDateSource(), "LEFT");

            // ���т��Ǎ��߂Ȃ������ꍇ
            if (leftMap.isEmpty()) {
                QkanMessageList.getInstance().QC002_ERROR_OF_RESULT();
                return;
            }

            // �J�����_�[������������
            initializeCalendar(true, false);
            // calendarRightDayContainer �� applyMap ���Z�b�g����B
            getCalendarLeftDayContainer().setSource(leftMap);
            // ��ʂɓW�J����B
            getCalendarLeftDayContainer().bindSource();
        }

    }

    /**
     * �u�K������i�E�j��W�J���鏈���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void resultReadButtonRightActionPerformed(ActionEvent e)
            throws Exception {
        // �K������i�E�j��W�J���鏈��
        VRDateFormat vf = new VRDateFormat("ggge�NM��");

        String message = String.valueOf(vf.format(ACDateUtilities.addMonth(
                getTargetDateSource(), 1))
                + "�x");

        int msgID = QkanMessageList.getInstance().QC002_WARNING_OF_RESULT(
                message);

        if (msgID == ACMessageBox.RESULT_YES) {

            // �����ϐ� rightMap �𐶐�����
            VRMap rightMap = new VRHashMap();

            // rightMap�Ɏ��т��擾����B
            rightMap = getVisitDataFromService(ACDateUtilities.addMonth(
                    getTargetDateSource(), 1), "RIGHT");

            // ���т��Ǎ��߂Ȃ������ꍇ
            if (rightMap.isEmpty()) {
                QkanMessageList.getInstance().QC002_ERROR_OF_RESULT();
                return;
            }

            // �J�����_�[������������
            initializeCalendar(false, true);

            // �擾����Map��applyMap�Ƀ}�[�W����B
            // calendarLeftDayContainer �� applyMap ���Z�b�g����B
            getCalendarRightDayContainer().setSource(rightMap);
            // ��ʂɓW�J����B
            getCalendarRightDayContainer().bindSource();

        }

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QC002.class.getName(), param));
    }

    // �����֐�

    /**
     * �u�E�B���h�E�^�C�g���̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doInitialize() throws Exception {
        // ���E�B���h�E�^�C�g���̐ݒ�
        // �Ɩ���񃌃R�[�h���擾����B
        // �E�B���h�E�^�C�g���ɁA�擾���R�[�h��KEY : WINDOW_TITLE��VALUE��ݒ肷��B
        // �Ɩ��{�^���o�[�̃e�L�X�g�ɁA�擾���R�[�h��KEY : AFFAIR_TITLE��VALUE��ݒ肷��B
        setAffairTitle("QC002", String.valueOf(0), getButtons());

        // �v���x�̏����l�̐ݒ�
        getYokaigodo().setSelectedIndex(1);
        
        // ���R���{�̃A�C�e���̏����ݒ�
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRList comboItemMap = new VRArrayList();

        // ���w��K��Ō�X�e�[�V������(providerName)
        // �T�[�r�X�񋟎��Ə��擾�֐��ɓn���p�����[�^(���R�[�h�W��) services�𐶐�����B
        ArrayList services = new ArrayList();
        // services�Ɉȉ��̐��l�^�̒l��ݒ肷��B
        // 11301(�K��Ō�E���)
        services.add("11311");

        // �K��Ō��񋟂��鎖�Ə����擾����B
        comboItemMap = QkanCommon.getProviderInfo(getDBManager(), services);

        // �擾�������R�[�h�W�����A�u�w��K��Ō�X�e�[�V������(providerName)�v�ɐݒ肷��B
        getProviderName().setModel(comboItemMap);

        setInitValue();

        // ���\��/��\���̐ݒ�
        // ���K����J�����_�[(��)�̍ŏI���\���ݒ�
        int calendarLeftMaxDay = ACDateUtilities
                .getLastDayOfMonth(getTargetDateSource());

        // targetDateSource�̍ŏI�����擾���A�J�����_�[(��)�̓��t�R���{�̕\���ݒ���s���B(����0���Ȃ�)
        switch (calendarLeftMaxDay) {
        // 28���̏ꍇ
        case 28:
            // 28���p�̓��t�R���{�̕\���ݒ���s���B
            setState_CALENDAR_LEFT_FEBRUARY();
            break;

        // 29���̏ꍇ
        case 29:
            // 29���p�̓��t�R���{�̕\���ݒ���s���B
            setState_CALENDAR_LEFT_BISSEXTILE();
            break;

        // 30���̏ꍇ
        case 30:
            // 30���p�̓��t�R���{�̕\���ݒ���s���B
            setState_CALENDAR_LEFT_EVEN_MONTH();
            break;

        // 31���̏ꍇ
        case 31:

            // 31���p�̓��t�R���{�̕\���ݒ���s���B
            setState_CALENDAR_LEFT_ODD_MONTH();
            break;

        default:
            break;
        }

        // ���K����J�����_�[(�E)�̍ŏI���\���ݒ�
        // targetDateSource + 1 (����)�̍ŏI�����擾���A�J�����_�[(�E)�̓��t�R���{�̕\���ݒ���s���B
        int calendarRightMaxDay = ACDateUtilities
                .getLastDayOfMonth(ACDateUtilities.addMonth(
                        getTargetDateSource(), 1));

        switch (calendarRightMaxDay) {
        // 28���̏ꍇ
        case 28:
            // 28���p�̓��t�R���{�̕\���ݒ���s���B
            setState_CALENDAR_RIGHT_FEBRUARY();
            break;

        // 29���̏ꍇ
        case 29:
            // 29���p�̓��t�R���{�̕\���ݒ���s���B
            setState_CALENDAR_RIGHT_BISSEXTILE();
            break;

        // 30���̏ꍇ
        case 30:
            // 30���p�̓��t�R���{�̕\���ݒ���s���B
            setState_CALENDAR_RIGHT_EVEN_MONTH();
            break;

        // 31���̏ꍇ
        case 31:
            // 31���p�̓��t�R���{�̕\���ݒ���s���B
            setState_CALENDAR_RIGHT_ODD_MONTH();
            break;

        }

        // ��������Ԃ̐ݒ�
        // ��ʂ̏�����Ԃ�ݒ肷��B
        setState_INIT_STATE();
    }

    /**
     * �u�K��Ō�񍐏����̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doFind() throws Exception {
        // ���K��Ō�񍐏����̐ݒ�
        // SQL���擾�֐��ւ̓n��p�����[�^(���R�[�h) sqlParam�ɁA���L�̒l��ݒ肷��B
        VRMap findMap = new VRHashMap();
        VRMap sqlParam = new VRHashMap();

        // KEY : PATIENT_ID, VALUE : patientID (�ޔ������n��p�����[�^)
        // KEY : TARGET_DATE, VALUE : targetDateSource (�ޔ������n��p�����[�^)
        VRBindPathParser.set("PATIENT_ID", sqlParam,
                new Integer(getPatientID()));
        VRBindPathParser.set("TARGET_DATE", sqlParam,
                (Date) getTargetDateSource());

        // �����p�ҏ���DB����擾
        // �Ώۗ��p��(���p�҈ꗗ�őI�����ꂽ���p��)�̊�{�����擾����B
        VRList patientInfo = QkanCommon.getPatientInfo(getDBManager(),
                getPatientID());
        if (patientInfo.size() <= 0) {
            // �擾�ł��Ȃ������ꍇ
            // �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_FIND
            int msgID = QkanMessageList.getInstance()
                    .ERROR_OF_PASSIVE_CHECK_ON_FIND();
            // �uQU001 ���p�҈ꗗ�v��ʂɖ߂�B(�����𔲂���)
            // �����߂�ł��邩���ʂ���
            setForciblyBackCheckFlag(true);
            ACFrame.getInstance().back();
            return;
        }

        findMap.putAll((VRMap) patientInfo.getData(0));


        // ���N��̎擾
        // �V�X�e������A�V�X�e�����t���擾����B
        Date sysDate = QkanSystemInformation.getInstance().getSystemDate();
        // ���p�Ґ��N�����A�y�уV�X�e�����t����N����Z�o����B
        // calcAge((�擾�������R�[�h��PATIENT_BIRTHDAY), (�V�X�e�����t));
        // findMap�ɉ��L�̒l��ݒ肷��B

        // �����p�Ҏ����̎擾
        // ���p�҂̐��E����A�����A���p�҂̃t���l�[�����擾����B
        // toFullName((findMap��KEY:PATIENT_FAMILY_NAME��VALUE),
        // (findMap��KEY:PATIENT_FIRST_NAME��VALUE));
        VRBindPathParser.set("PATIENT_NAME", findMap, QkanCommon.toFullName(
                VRBindPathParser.get("PATIENT_FAMILY_NAME", findMap),
                VRBindPathParser.get("PATIENT_FIRST_NAME", findMap)));
        
        VRList patientYokaigodo = QkanCommon.getPatientInsureInfoOnEndOfMonth(
                getDBManager(), getTargetDateSource(), getPatientID());

        if (!(patientYokaigodo == null || patientYokaigodo.size() == 0)) {
            // �擾�ł����ꍇ
            // �擾�������R�[�h��findMap�ɐݒ肷��B
            findMap.putAll((VRMap) patientYokaigodo.getData(0));
        }

        // �K��Ō�񍐏����擾�p��SQL�����擾����B
        // �擾����SQL���𔭍s����B
        VRList houkokusyoData = getDBManager().executeQuery(
                getSQL_GET_RESULT(sqlParam));

        // �J�����_�[�i���j���t
        Date leftDate = getTargetDateSource();
        // �J�����_�[�i�E�j���t
        Date rightDate = ACDateUtilities.addMonth(getTargetDateSource(), 1);

        if (houkokusyoData.size() <= 0) {
            // �擾������0���̏ꍇ
            // processMode��PROCESS_MODE_INSERT��ݒ肷��B(�o�^���[�h)
            setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
            // �o�^�{�^����\������B
            setState_PROCESS_MODE_INSERT();
            // resultData�ɁAcontents�p�l������cretateSource�������R�[�h��ݒ肷��B
            VRMap map = new VRHashMap();
            getContents().setSource(map);
            getContents().createSource();
            setResultData(map);
        } else {
            findMap.putAll((VRMap) houkokusyoData.getData(0));
            // �擾������0����葽���ꍇ
            // processMode��PROCESS_MODE_UPDATE��ݒ肷��B(�X�V���[�h)
            setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
            // �X�V�{�^����\������B
            setState_PROCESS_MODE_UPDATE();
            // resultData�ɁA�擾�������R�[�h�W����1���ڂ̃��R�[�h�̒l��ǉ�����B
            setResultData((VRMap) houkokusyoData.getData(0));
            // �p�b�V�u�L�[��o�^����B
            // reservedPassive(PASSIVE_CHECK_KEY_PLAN, (�擾�������R�[�h�W��));
            getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY_RESULT(),
                    findMap);
        }

        // findMap�ɉ��L�̒l��ݒ肷��B
        // KEY : PATIENT_NAME, VALUE : (�擾�������p�҃t���l�[��)
        // �J�����_�[������ʂɓW�J����
        findCalendar();
        // �����l��ݒ�
        initializeCalendar();

        VRList calendarLeftList = new VRArrayList();
        VRList calendarRightList = new VRArrayList();

        // ���K������̎擾
        // if(getProcessMode()==QkanConstants.PROCESS_MODE_UPDATE){
        // processMode�̒l���`�F�b�N����B
        // PROCESS_MODE_UPDATE(�X�V)�̏ꍇ
        // ���K����J�����_�[(��)���̎擾
        // �K����J�����_�[(��)�����擾���AcalendarLeftData�Ɋi�[����B
        calendarLeftList = getVisitDataFromResult(leftDate);

        /*
         * 
         */
        int leftMode = checkMode(calendarLeftList);

        // �ϐ�calendarLeftCount�ɁA�K����i���j�̌������i�[����B
        setCalendarLeftCount(calendarLeftList.size());

        // 0���̏ꍇ
        if (leftMode == QkanConstants.PROCESS_MODE_INSERT) {
            // �T�[�r�X���я�񂩂�K��������擾���AcalendarLeftData�Ɋi�[����B
            findMap.putAll(getVisitDataFromService(leftDate, "LEFT"));

        } else {
            // 0����葽���ꍇ
            // ��ʓW�J�p�̃f�[�^�Ƃ��ăJ�����_�[�i���j��ǉ�����B
            VRMap map = new VRHashMap();
            map = createBindData(leftDate, "LEFT");
            findMap.putAll(map);

        }
        // ���K����J�����_�[(�E)���̎擾
        // �K����J�����_�[(�E)�����擾���AcalendarRightData�Ɋi�[����B
        calendarRightList = getVisitDataFromResult(rightDate);

        /*
         * 
         */
        int rightMode = checkMode(calendarRightList);

        // �ϐ�calendarRightCount�ɁAcalendarRightData�̌������i�[����B
        setCalendarRightCount(calendarRightList.size());

        // 0���̏ꍇ
        if (rightMode == QkanConstants.PROCESS_MODE_INSERT) {
            // �T�[�r�X���я�񂩂�K��������擾���AcalendarRightData�Ɋi�[����B
            findMap.putAll(getVisitDataFromService(rightDate, "RIGHT"));

        } else {
            // 0����葽���ꍇ
            // ��ʓW�J�p�̃f�[�^�Ƃ��ăJ�����_�[�i�E�j��ǉ�����B
            findMap.putAll(createBindData(rightDate, "RIGHT"));

        }

        // findMap�ɉ��L�̒l��ݒ肷��B
        // KEY : CALENDAR_LEFT_YEAR, VALUE : targetDateSource�̘a��̔N
        findMap.setData("CALENDAR_LEFT_YEAR", new Integer(ACDateUtilities
                .getEraYear(leftDate)));
        // KEY : CALENDAR_LEFT_MONTH, VALUE : targetDateSource�̌�
        findMap.setData("CALENDAR_LEFT_MONTH", new Integer(ACDateUtilities
                .getMonth(leftDate)));
        // KEY : CALENDAR_RIGHT_YEAR, VALUE : targetDateSource + 1���� (����1��)
        // �̘a��̔N
        findMap.setData("CALENDAR_RIGHT_YEAR", new Integer(ACDateUtilities
                .getEraYear(rightDate)));
        // KEY : CALENDAR_RIGHT_MONTH, VALUE : targetDateSource + 1���� (����1��) �̌�
        findMap.setData("CALENDAR_RIGHT_MONTH", new Integer(ACDateUtilities
                .getMonth(rightDate)));

        // contents�p�l����dataSource�Ƃ��āAresultData��ݒ肷��B
        getContents().setSource(findMap);
        // resultData����ʂɓW�J����B
        getContents().bindSource();
        // �X�i�b�v�V���b�g���B�e����B
        getSnapshot().snapshot();

    }

    /**
     * �u�����l�̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void setInitValue() throws Exception {
        // ���S����t��(�厡�㎁��)�̎擾
        VRMap initMap = new VRHashMap();
        
        initMap.setData("DOCTOR_NAME", "");

        // ���쐬�N���̐ݒ�
        // �V�X�e������A�u�V�X�e�����t�v���擾����B
        initMap.setData("CREATE_DATE", QkanSystemInformation.getInstance()
                .getSystemDate());

        // resultData�ɉ��L�̒l��ݒ肷��B
        // KEY : CREATE_DATE, VALUE : (�擾�����V�X�e�����t)
        // ���K��Ō�񋟎��Ə��R���{�̏����I���A�C�e���̐ݒ�
        // ���O�C�����Ə��ԍ����擾����B
        String loginProvider = QkanSystemInformation.getInstance()
                .getLoginProviderID();

        // �K��Ō�񋟎��Ə��R���{�̒��ɁA���O�C�����Ə��ԍ��Ɠ����ID�̎��Ə������݂��邩�ǂ����`�F�b�N����B
        for (int i = 0; getProviderName().getModel().getSize() > i; i++) {

            VRMap map = (VRMap) getProviderName().getModelItem(i);

            // ���O�C�����Ə��Ɠ���̎��Ə������݂����ꍇ
            if (loginProvider.equals(map.getData("PROVIDER_ID"))) {
                // ���݂���ꍇ
                // planData�ɉ��L�̒l��ݒ肷��B
                // KEY : PROVIDER_NAME
                getProviderName().setSelectedIndex(i);

            }

            // ���݂��Ȃ��ꍇ
            // planData�ɉ��L�̒l��ݒ肷��B
            // KEY : PROVIDER_NAME

        }

        getContents().setSource(initMap);
        getContents().bindSource();
        // ���Ǘ��Ҏ����̐ݒ�
        // �R���{�ɓ��͂���Ă��鎖�Ə�������A���̎��Ə��́u�Ǘ��Ҏ���(ADMINISTRATOR_NAME)�v���擾����B
        // getAdministratorName((�R���{�̑I���A�C�e���̃��R�[�h));

        // resultData�ɉ��L�̒l��ݒ肷��B
        // KEY : ADMINISTRATOR_NAME, VALUE : (�擾�����Ǘ��Ҏ���)
        setResultData(initMap);
    }

    /**
     * �u�o�^�ς݂̖K������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRList getVisitDataFromResult(Date visitDate) throws Exception {
        // �������� : visitDate(���t�^) : �Ώ۔N��
        // SQL���擾�֐��ւ̓n��p�����[�^(���R�[�h) sqlParam�𐶐����A���L�̒l��ݒ肷��B
        VRMap sqlParam = new VRHashMap();

        // KEY : PATIENT_ID, VALUE : patientID (�ޔ������n��p�����[�^)
        sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));

        // KEY : DATE_START, VALUE : visitDate
        sqlParam.setData("DATE_START", ACDateUtilities
                .toFirstDayOfMonth(visitDate));

        // KEY : DATE_END, VALUE : (visitDate + 1����) (visitDate�̗���1��)
        sqlParam.setData("DATE_END", ACDateUtilities
                .toLastDayOfMonth(visitDate));

        // �K����擾�pSQL�����擾����B
        // �擾����SQL���𔭍s����B
        VRList list = getDBManager()
                .executeQuery(getSQL_GET_CALENDAR(sqlParam));

        // �擾�������R�[�h�W�����A�֐��̖߂�l�Ƃ��ĕԂ��B
        return list;
    }

    /**
     * �u�T�[�r�X���т���K������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getVisitDataFromService(Date targetDate, String type)
            throws Exception {
        // ���T�[�r�X���т���K������擾

        // sql���擾�p�Ƀ��R�[�h sqlParam �𐶐����A���L�̒l��ݒ肷��B
        VRMap sqlParam = new VRHashMap();

        // KEY : PATIENT_ID, VALUE : patientID (�ޔ������n��p�����[�^)
        sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));

        // ���T�[�r�X���т̎擾
        // �T�[�r�X�J�����_�[���i�[�p�� serviceResultMap�𐶐�����B
        VRMap serviceResultMap = new VRHashMap();
        // �T�[�r�X���я��i�[�p�̃��R�[�h�W�� serviceList�𐶐�����B
        VRList serviceList = new VRArrayList();
        // �����ϐ� sqlParam�𐶐�����B
        // KEY�FTARGET_DATE_START VALUE�FtargetDate �̌���
        sqlParam.setData("TARGET_DATE_START", ACDateUtilities
                .toFirstDayOfMonth(targetDate));
        // KEY�FTARGET_DATE_START VALUE�FtargetDate �̌���
        sqlParam.setData("TARGET_DATE_END", ACDateUtilities
                .toLastDayOfMonth(targetDate));
        
        sqlParam.setData("PROVIDER_ID", QkanSystemInformation
                .getInstance().getLoginProviderID());
        // �T�[�r�X���т��擾����SQL�����擾����
        // �擾����SQL���𔭍s���AserviceList�Ɋi�[����B
        serviceList = getDBManager().executeQuery(
                getSQL_GET_SERVICE_RESULT_DATA(sqlParam));
        // ���T�[�r�X���т̖K������ւ̕ϊ�
        // monthInfo �𐶐�����B
        String monthInfo = type;

        VRMap map = new VRHashMap();

        for (int i = 0; i < serviceList.size(); i++) {
            // VISIT_VALUE�̒l���擾�� �ȉ���KEY�Ŋi�[����B
            map = (VRMap) serviceList.getData(i);
            // KEY�FCALENDAR_ + monthInfo + _DAY +
            // �擾�����{�t�B�[���h�̒l�iVISIT_DATE_OF_DAY�i2���j�j
            serviceResultMap.setData("CALENDAR_" + monthInfo + "_DAY"
                    + map.getData("VISIT_DATE_OF_DAY"), new Integer(String
                    .valueOf(map.getData("VISIT_VALUE"))));
            // VISIT_DATE�̒l�����L��KEY�Ŋi�[����B
            // KEY�FVISIT_DATE
            serviceResultMap.setData("VISIT_DATE", map.getData("SERVICE_DATE"));
            // ���p�Ҕԍ������L��KEY�Ŋi�[����B
            serviceResultMap.setData("PATIENT_ID", new Integer(getPatientID()));
            // KEY:PATIENT_ID
            // ���������[�v�����ꍇ��������
        }

        return serviceResultMap;

    }

    /**
     * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean doInsert() throws Exception {
        // ���񍐏����̎擾
        // resultData�ɁA��ʂ̕񍐏������i�[����B
        VRMap resultData = new VRHashMap();
        VRMap saveMap = new VRHashMap();

        try {
            // ��ʏ�̏����擾
            getContents().setSource(resultData);
            getContents().applySource();

            // �o�^�p�̃f�[�^���擾
            saveMap = createSaveData();

            // resultData�ɉ��L�̒l��ǉ�����B
            // KEY : PATIENT_ID, VALUE : patientID (�ޔ������n��p�����[�^)
            resultData.setData("PATIENT_ID", new Integer(getPatientID()));
            // KEY : TARGET_DATE, VALUE : targetDateSource (�ޔ������n��p�����[�^)
            resultData.setData("TARGET_DATE", getTargetDateSource());

            // ���p�b�V�u�`�F�b�N�̏���
            // �p�b�V�u�^�X�N���N���A����B
            getPassiveChecker().clearPassiveTask();

            // ���K��Ō�񍐏��̃p�b�V�u�^�X�N�̓o�^
            // �K��Ō�񍐏����̃p�b�V�u�L�[��o�^����B
            getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY_RESULT(),
                    resultData);

            // �K��Ō�񍐏����ǉ��p�̃p�b�V�u�^�X�N��o�^����B
            getPassiveChecker().addPassiveInsertTask(
                    getPASSIVE_CHECK_KEY_RESULT(), resultData);

            VRList leftList = (VRList) saveMap.getData("CALENDAR_LEFT");

            VRList rightList = (VRList) saveMap.getData("CALENDAR_RIGHT");

            // �g�����U�N�V�������J�n����
            getDBManager().beginTransaction();
            // ���p�b�V�u�`�F�b�N
            // �p�b�V�u�`�F�b�N�����s����B
            // �p�b�V�u�G���[������ꍇ
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                //�e�[�u�����b�N�����̂��߃��[���o�b�N
                getDBManager().rollbackTransaction();
                // �p�b�V�u�G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // �����𒆒f����B(�ُ�I��)
                return false;
            }

            // �p�b�V�u�G���[���Ȃ��ꍇ
            // �������p������B
            // ���K��Ō�񍐏��̓o�^
            // processMode�̒l���`�F�b�N����B
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // �K��Ō�񍐏����o�^�p��SQL�����擾����B
                // �擾����SQL���𔭍s����B
                getDBManager().executeUpdate(getSQL_INSERT_RESULT(resultData));
                // �J�����_�[����ۑ����鏈��
                doSaveCalendar(leftList, rightList);

            } else {
                //�e�[�u�����b�N�����̂��߃��[���o�b�N
                getDBManager().rollbackTransaction();
                return false;
            }
            // ��L��A��SQL���s�����ŃG���[���Ȃ������ꍇ
            // �������R�~�b�g����B
            getDBManager().commitTransaction();
            // �������I������i����I���j
            return true;

        } catch (Exception sqlEx) {
            // �������I������B(����I��)
            sqlEx.printStackTrace();

            // SQL���s�����ŃG���[���������ꍇ
            // ���������[���o�b�N����B
            getDBManager().rollbackTransaction();

            // �����𒆒f����B(�ُ�I��)
            throw sqlEx;
        }

    }

    /**
     * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean doUpdate() throws Exception {
        // ���񍐏����̎擾
        VRMap resultData = new VRHashMap();

        try {
            // �Ώی��̓��t
            Date leftDate = getTargetDateSource();
            // �Ώی��{1��
            Date rightDate = ACDateUtilities.addMonth(getTargetDateSource(), 1);
            // resultData�ɁA��ʂ̕񍐏������i�[����B
            getContents().setSource(resultData);
            getContents().applySource();

            // resultData�ɉ��L�̒l��ǉ�����B
            // KEY : PATIENT_ID, VALUE : patientID (�ޔ������n��p�����[�^)
            resultData.setData("PATIENT_ID", new Integer(getPatientID()));
            // KEY : TARGET_DATE, VALUE : targetDateSource (�ޔ������n��p�����[�^)
            resultData.setData("TARGET_DATE", leftDate);

            // ���K������̎擾
            VRMap saveMap = new VRHashMap();
            saveMap = createSaveData();

            // �J�����_�[���i���j���擾
            VRList leftList = (VRList) saveMap.getData("CALENDAR_LEFT");
            // �J�����_�[���i�E�j���擾
            VRList rightList = (VRList) saveMap.getData("CALENDAR_RIGHT");

            // ���p�b�V�u�`�F�b�N�̏���
            // �p�b�V�u�^�X�N���N���A����B
            getPassiveChecker().clearPassiveTask();
            // ���K��Ō�񍐏��̃p�b�V�u�^�X�N�̓o�^
            if (getProcessMode() != QkanConstants.PROCESS_MODE_UPDATE) {
                //�e�[�u�����b�N�����̂��߃��[���o�b�N
                getDBManager().rollbackTransaction();
                
                return false;
            }
            // processMode�̒l���`�F�b�N����B
            // �K��Ō�񍐏����X�V�p�̃p�b�V�u�^�X�N��o�^����B
            getPassiveChecker().addPassiveUpdateTask(
                    getPASSIVE_CHECK_KEY_RESULT());

            // �g�����U�N�V�������J�n����
            getDBManager().beginTransaction();
            // ���p�b�V�u�`�F�b�N
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                //�e�[�u�����b�N�����̂��߃��[���o�b�N
                getDBManager().rollbackTransaction();
                // �p�b�V�u�`�F�b�N�����s����B
                // �p�b�V�u�G���[������ꍇ
                // �p�b�V�u�G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // �����𒆒f����B(�ُ�I��)
                return false;
            }

            // �p�b�V�u�G���[���Ȃ��ꍇ
            // �������p������B
            // ���K��Ō�񍐏��̓o�^
            // �K��Ō�񍐏����X�V�p��SQL�����擾����B
            // �擾����SQL���𔭍s����B
            getDBManager().executeUpdate(getSQL_UPDATE_RESULT(resultData));
            // ���K��Ō�񍐏��E�K���(�J�����_�[(��))���̓o�^

            doSaveCalendar(leftList, rightList);

            // ��L��A��SQL���s�����ŃG���[���Ȃ������ꍇ
            // �������R�~�b�g����B
            getDBManager().commitTransaction();
            // �������I������i����I���j
            return true;

        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
            // �������I������B(����I��)
            // SQL���s�����ŃG���[���������ꍇ
            // ���������[���o�b�N����B
            getDBManager().rollbackTransaction();
            // �����𒆒f����B(�ُ�I��)
            throw sqlEx;
        }
    }

    /**
     * �u���Ə��̊Ǘ��Ҏ����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public String getAdministratorName(VRMap rec) throws Exception {
        // �������`�F�b�N
        // �����œn���ꂽ���R�[�h���`�F�b�N����B
        if (rec == null) {
            // null�̏ꍇ
            // �󔒂�Ԃ��B(�����I��)
            return "";
        }
        // null�ȊO�̏ꍇ
        // �������p������B
        // ����������PROVIDER_ID�𒊏o
        // �����œn���ꂽ���R�[�h����AKEY : PROVIDER_ID��VALUE���擾����B
        if (!VRBindPathParser.has("PROVIDER_ID", rec)) {
            // �擾�ł��Ȃ������ꍇ
            // �󔒂�Ԃ��B(�����I��)
            return "";
        }
        // �擾�ł����ꍇ
        // �������p������B
        // �����Ə��̃T�[�r�X�ڍ׏����擾
        // ���Ə��̃T�[�r�X�ڍ׏����擾����B
        StringBuilder sb = new StringBuilder();
        sb.append(" SYSTEM_SERVICE_KIND_DETAIL IN (11311)");
        sb.append(" AND PROVIDER_ID = ");
        sb.append(String.valueOf("'"+ VRBindPathParser.get("PROVIDER_ID",rec) + "'"));
        
        VRList list = QkanCommon.getProviderServiceDetailCustom(
                getDBManager(),sb.toString());

        if (list.size() <= 0) {
            // �擾������0���̏ꍇ
            // �󔒂�Ԃ��B(�����I��)
            return "";
        }
        // �擾������0����葽���ꍇ
        // �������p������B
        // ���Ǘ��Ҏ����̒��o
        VRMap record = (VRMap) list.getData(0);
        // �擾�������R�[�h�W���́A�ŏ��̃��R�[�h�� KEY : 1130103��VALUE���擾����B
        String admnisutatorName = ACCastUtilities.toString(record
                .getData("1130103"));
        // �擾�����l��߂�l�Ƃ��ĕԂ��B(�����I��)
        return admnisutatorName;
    }

    /**
     * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean checkValidInput() throws Exception {
        // �����̓`�F�b�N
        // ���쐬�N�����E�����̓`�F�b�N
        if (ACTextUtilities.isNullText(getCreateDate().getText())) {
            // ��ʂ́u�쐬�N����(createDate)�v�̒l���`�F�b�N����B
            // ���͂���Ă���ꍇ
            // �������p������B
            // �����͂̏ꍇ
            // �G���[���b�Z�[�W��\������B��ID = ERROR_OF_NEED_CHECK_FOR_INPUT
            QkanMessageList.getInstance()
                    .ERROR_OF_NEED_CHECK_FOR_INPUT("�쐬�N����");
            // createDate�Ƀt�H�[�J�X�𓖂Ă�B
            getCreateDate().requestFocus();
            // �߂�l�Ƃ���false��Ԃ��A�����𒆒f����B
            return false;
        }
        // ���쐬�N�����E�s���`�F�b�N
        // ��ʂ́u�쐬�N����(createDate)�v�̒l���`�F�b�N����B
        // ����l�̏ꍇ
        // �������p������B
        if (!getCreateDate().isValidDate()) {
            // �ُ�l�̏ꍇ
            // �G���[���b�Z�[�W��\������B��ID = ERROR_OF_WRONG_DATE
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�쐬�N������");
            // createDate�Ƀt�H�[�J�X�𓖂Ă�B
            getCreateDate().requestFocus();
            // �߂�l�Ƃ���false��Ԃ��A�����𒆒f����B
            return false;
        }
        // ������I��
        // ��L�G���[�`�F�b�N���p�X�����ꍇ�A�߂�l�Ƃ���true��Ԃ��B
        return true;
    }

    /**
     * �u�K����̃R���{�f�[�^���쐬���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap createCalendarData(Date targetDate, String type)
            throws Exception {
        // �K����̃R���{�f�[�^(���j���쐬���鏈��
        // �����ϐ� calendarList �𐶐�����B
        VRList calendarList = new VRArrayList();
        // �����ϐ� calendarBindMap �𐶐�����
        VRMap calendarBindDataMap = new VRHashMap();
        // �����ϐ� codeMastarList �𐶐�����
        VRList codeMasterList = new VRArrayList();
        // �����ϐ� calendarLeftDate �𐶐����A�Ώی��̌����̒l��ݒ肷��B
        Date calendarStartData = targetDate;

        // �R�[�h�}�X�^����K���ʂ�\���L�������擾���邽�߂�SQL�����擾����B
        codeMasterList = QkanCommon.getArrayFromMasterCode(199, "VISIT_VALUE");
        // codeMasterList�ɃR�[�h�}�X�^�[����K���ʂ�\���L�����擾���i�[����B

        // �Ώی��̓����擾����
        int lastDay = ACDateUtilities.getLastDayOfMonth(calendarStartData);

        VRMap calendarData = new VRHashMap();

        // �����̐��������[�v����
        for (int i = 1; i <= lastDay; i++) {
            // �R�[�h�}�X�^�[����擾�������������[�v����
            for (int j = 0; j < codeMasterList.size(); j++) {
                VRMap map = (VRMap) codeMasterList.getData(j);
                // 1���ڂ̂ݏ����l�𐶐�
                if (j == 0) {
                    calendarData.setData("CALENDAR_DATA_STRING", String
                            .valueOf(i));
                    calendarData.setData("CALENDAR_" + type + "_DAY" + i,
                            new Integer(String.valueOf(map
                                    .getData("CONTENT_KEY"))));
                    calendarList.add(calendarData);
                    // ������
                    calendarData = new VRHashMap();
                }
                // ���������l�����L��KEY��calendarLeftData�Ɋi�[����B
                // KEY�FCALENDAR_DATA_STRING
                String str = String.valueOf(map.getData("CONTENT"));
                calendarData.setData("CALENDAR_DATA_STRING", i + str);

                int contentKeyNo = Integer.parseInt(String.valueOf(map
                        .getData("CONTENT_KEY")));

                // //calendarLeftData ��
                // �R�[�h�}�X�^���擾����CONTENT_KEY��VALUE�����L��KEY�Ŋi�[����B
                calendarData.setData("CALENDAR_" + type + "_DAY" + i,
                        new Integer(contentKeyNo + 1));

                // KEY�FVISIT_VALUE_LEFT + ���݂̌���
                // calendarDataList��calendaLeftrData��ǉ�����B
                calendarList.add(calendarData);

                // calendarLeftData ��V�K�ɐ�������B�i�����������j
                calendarData = new VRHashMap();
            }
            // �L���̐������쐬�����ꍇ
            // calendarBindMap �� calendarDataList�����L��KEY/VALUE�Őݒ肷��B
            calendarBindDataMap.setData("CALENDAR_" + type + i, calendarList);

            // KEY�FCALENDEAR_LEFT_DAY_ + ���݂̌���
            // calendarDataList��V�K��������B�i�������j
            calendarList = new VRArrayList();

            // calendarLeftDate�̓��t��+1������B
            calendarStartData = ACDateUtilities
                    .addDay(getTargetDateSource(), 1);
            // �l���{�P����B
        }
        // �߂�l�Ƃ���calendarBindMap��Ԃ��B
        return calendarBindDataMap;
    }

    /**
     * 
     */
    public void findCalendar() throws Exception {

        // TODO �����������ꂽ���\�b�h�E�X�^�u
        // �J�����_�[���i�E�j���擾����B
        VRMap mapRight = createCalendarData(ACDateUtilities.addMonth(
                getTargetDateSource(), 1), "RIGHT");

        // �J�����_�[���i���j���擾����B
        VRMap mapLeft = createCalendarData(getTargetDateSource(), "LEFT");

        VRMap calendarMap = new VRHashMap();

        // �擾����Map���}�[�W���ĉ�ʂɓW�J����B
        calendarMap.putAll(mapLeft);
        calendarMap.putAll(mapRight);
        // ��ʂɓW�J����B
        getCalendars().setModelSource(calendarMap);
        getCalendars().bindModelSource();

    }

    /**
     * 
     */
    public VRMap createBindData(Date targetDate, String type) throws Exception {
        // TODO �����������ꂽ���\�b�h�E�X�^�u

        // �����ϐ� sqlParam �𐶐��� �ȉ���KEY/VALUE�Ŋi�[����B
        VRMap sqlParam = new VRHashMap();
        // KEY�FPATIENT_ID VALUE�F���p��ID
        sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
        // KEY�FVISIT_DATE_START VALUE�F�n��p�����[�^�[���t�̌���
        sqlParam.setData("VISIT_DATE_START", ACDateUtilities
                .toFirstDayOfMonth(targetDate));
        // KEY�FVISIT_DATE_END VALUE�F�n��p�����[�^�[���t�̌���
        sqlParam.setData("VISIT_DATE_END", ACDateUtilities
                .toLastDayOfMonth(targetDate));
        // ��ʓW�J�p�̃f�[�^���擾���邽�߂�SQL�����擾����B
        // �擾����SQL���𔭍s����B
        VRList list = getDBManager().executeQuery(
                getSQL_GET_CALENDAR_CUSTOM(sqlParam));
        // �Ԃ��Ă������ʂ�����ϐ��Ɋi�[����B
        // �����ϐ� bindData �𐶐�����B
        VRMap bindData = new VRHashMap();

        // �A���Ă������R�[�h�������ȉ��̏������J��Ԃ��B
        for (int i = 0; i < list.size(); i++) {
            VRMap map = (VRMap) list.getData(i);
            // bindData�ɉ��LKEY/VALUE���i�[����B
            bindData.setData("CALENDAR_" + type + "_DAY"
                    + map.getData("VISIT_DATE_OF_DAY"), new Integer(String
                    .valueOf(map.getData("VISIT_VALUE"))));
            // KEY�FCALENDAR_ +type + DAY + KEY�FVISIT_DATE_OF_DAY��VALUE
            // VALUE�FVISIT_VALUE��VALUE

        }
        // ���������������ꍇ�߂�l�Ƃ���bindData��Ԃ��B
        return bindData;
    }

    /**
     * 
     */
    public VRMap createSaveData() throws Exception {
        // �J�����_�[���i�[�p
        VRMap calendarMap = new VRHashMap();
        getCalendars().setSource(calendarMap);
        getCalendars().applySource();

        VRMap saveData = new VRHashMap();
        // �J�����_�[�i���j���i�[�p
        VRList saveLeftList = new VRArrayList();
        // �J�����_�[�i�E�j���i�[�p
        VRList saveRightList = new VRArrayList();
        // �߂�l���i�[����ϐ�
        VRMap saveMap = new VRHashMap();

        // �J�����_�[�i���j�����̓��t���擾
        Date leftDate = ACDateUtilities
                .toFirstDayOfMonth(getTargetDateSource());
        // �J�����_�[�i�E�j�����̓��t���擾
        Date rightDate = ACDateUtilities.addMonth(leftDate, 1);

        Iterator it = calendarMap.entrySet().iterator();
        // �L�[�����擾
        Map.Entry key = null;
        // KEY��String�^�Ŋi�[
        String strKey = "";

        // ��ʂ���擾�����R���{�f�[�^�����[�v
        while (it.hasNext()) {
            key = (Map.Entry) it.next();
            // KEY��String�^�Ŋi�[
            strKey = String.valueOf(key.getKey());
            // KEY�̕����񂩂�R���{�ł��邩�𔻒f
            if (strKey.indexOf("CALENDAR_LEFT_DAY") == 0
                    || strKey.indexOf("CALENDAR_RIGHT_DAY") == 0) {
                // �R���{�̒l���󔒂������͏����l�ȊO�������ꍇ
                if (key.getValue() != "" && key.getValue() != null) {
                    // �J�����_�[�̎�ނ𔻕ʂ��ē��t�f�[�^���쐬

                    if (strKey.indexOf("CALENDAR_LEFT") == 0) {
                        // ���t��ݒ肷��
                        saveData.setData("VISIT_DATE", ACDateUtilities
                                .setDayOfMonth(leftDate, Integer
                                        .parseInt(strKey.substring(17, strKey
                                                .length()))));
                        // �l���擾���i�[
                        saveData.setData("VISIT_VALUE", new Integer(String
                                .valueOf(key.getValue())));
                        // ���p��ID��ݒ肷��
                        saveData.setData("PATIENT_ID", new Integer(
                                getPatientID()));
                        // �߂�l�Ƃ��Ďg��List�Ɋi�[
                        saveLeftList.add(saveData);
                    } else {
                        saveData.setData("VISIT_DATE", ACDateUtilities
                                .setDayOfMonth(rightDate, Integer
                                        .parseInt(strKey.substring(18, strKey
                                                .length()))));
                        // �l���擾���i�[
                        saveData.setData("VISIT_VALUE", new Integer(String
                                .valueOf(key.getValue())));
                        // ���p��ID��ݒ肷��
                        saveData.setData("PATIENT_ID", new Integer(
                                getPatientID()));
                        // �߂�l�Ƃ��Ďg��List�Ɋi�[
                        saveRightList.add(saveData);
                    }
                    // ������
                    saveData = new VRHashMap();
                }
            }

        }
        saveMap.setData("CALENDAR_LEFT", saveLeftList);
        saveMap.setData("CALENDAR_RIGHT", saveRightList);
        // �o�^�p�f�[�^��Ԃ�
        return saveMap;
    }

    /**
     * 
     */
    public void doSaveCalendar(VRList leftList, VRList rightList)
            throws Exception {

        // �Ώی�
        Date targetDateLeft = getTargetDateSource();
        // �Ώی��{�P��
        Date targetDateRight = ACDateUtilities.addMonth(targetDateLeft, 1);

        VRMap sqlParam = new VRHashMap();

        // ���K��Ō�񍐏��E�K���(�J�����_�[(��))���̓o�^
        // calendarLeftCount�̒l���`�F�b�N����B
        if (getCalendarLeftCount() != 0) {
            // 0���̏ꍇ
            // DELETE�����͍s��Ȃ��B(���������A���ցB)
            // 0����葽���ꍇ
            // sqlParam�ɉ��L�̒l��ݒ肷��B
            // KEY : PATIENT_ID, VALUE : patientID (�ޔ������n��p�����[�^)
            sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
            // KEY : DATE_START, VALUE : targetDateSource
            sqlParam.setData("DATE_START", ACDateUtilities
                    .toFirstDayOfMonth(targetDateLeft));
            // KEY : DATE_END, VALUE : (targetDateSource + 1����)
            // (targetDateSource�̗���1��)
            sqlParam.setData("DATE_END", ACDateUtilities
                    .toLastDayOfMonth(targetDateLeft));

            // �K��Ō�񍐏��E�K������폜�p��SQL�����擾����B
            // �擾����SQL���𔭍s����B
            getDBManager().executeUpdate(getSQL_DELETE_CALENDAR(sqlParam));
        }

        // KEY : PATIENT_ID, VALUE : patientID
        sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
        // calendarLeftData�̌��������[�v����B
        for (int i = 0; i < leftList.size(); i++) {
            // sqlParam�ɉ��L�̒l��ݒ肷��B
            VRMap saveData = (VRMap) leftList.getData(i);
            // �����l�ł��邩���f����
            if (saveData.getData("VISIT_VALUE") != "") {
                // KEY : VISIT_DATE, VALUE : (calendarLeftData��n�Ԗڂ̃��R�[�h�� KEY :
                // VISIT_DATE��VALUE)
                sqlParam.setData("VISIT_DATE", saveData.getData("VISIT_DATE"));
                // KEY : VISIT_VALUE, VALUE : (calendarLeftData��n�Ԗڂ̃��R�[�h�� KEY :
                // VISIT_VALUE��VALUE)
                sqlParam
                        .setData("VISIT_VALUE", saveData.getData("VISIT_VALUE"));
                // �K��Ō�񍐏��E�K������ǉ��p��SQL�����擾����B
                // �擾����SQL���𔭍s����B
                getDBManager().executeUpdate(getSQL_INSERT_CALENDAR(sqlParam));
            }
        }

        // ���K��Ō�񍐏��E�K���(�J�����_�[(�E))���̓o�^
        // calendarRightCount�̒l���`�F�b�N����B
        if (getCalendarRightCount() != 0) {
            // 0���̏ꍇ
            // DELETE�����͍s��Ȃ��B(���������A���ցB)
            // 0����葽���ꍇ
            // sqlParam�ɉ��L�̒l��ݒ肷��B
            // KEY : PATIENT_ID, VALUE : patientID (�ޔ������n��p�����[�^)
            sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
            sqlParam.setData("DATE_START", ACDateUtilities
                    .toFirstDayOfMonth(targetDateRight));
            // KEY : DATE_END, VALUE : (targetDateSource + 1����)
            // (targetDateSource�̗���1��)
            sqlParam.setData("DATE_END", ACDateUtilities
                    .toLastDayOfMonth(targetDateRight));
            // �K��Ō�񍐏��E�K������폜�p��SQL�����擾����B
            // �擾����SQL���𔭍s����B
            getDBManager().executeUpdate(getSQL_DELETE_CALENDAR(sqlParam));
        }
        // KEY : PATIENT_ID, VALUE : patientID
        sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));

        // calendarRightData�̌��������[�v����B
        for (int i = 0; i < rightList.size(); i++) {
            // sqlParam�ɉ��L�̒l��ݒ肷��B
            VRMap saveData = (VRMap) rightList.getData(i);
            // �����l�ł��邩���f����
            if (saveData.getData("VISIT_VALUE") != new Integer(1)) {
                // KEY : VISIT_DATE, VALUE : (calendarRightData��n�Ԗڂ̃��R�[�h�� KEY :
                // VISIT_DATE��VALUE)
                sqlParam.setData("VISIT_DATE", saveData.getData("VISIT_DATE"));
                // KEY : VISIT_VALUE, VALUE : (calendarRightData��n�Ԗڂ̃��R�[�h�� KEY :
                // VISIT_VALUE��VALUE)
                sqlParam
                        .setData("VISIT_VALUE", saveData.getData("VISIT_VALUE"));
                // �K��Ō�񍐏��E�K������ǉ��p��SQL�����擾����B
                // �擾����SQL���𔭍s����B
                getDBManager().executeUpdate(getSQL_INSERT_CALENDAR(sqlParam));
            }
        }

    }

    /**
     * 
     */
    public void initializeCalendar(boolean isLeft, boolean isRight)
            throws Exception {
        // �������Ɏg���l���i�[����ϐ�
        VRMap bindData = new VRHashMap();
        // �Ώی��̖���
        int leftDayOfMonth = ACDateUtilities
                .getLastDayOfMonth(getTargetDateSource());
        // �Ώی��{�P���̖���
        int rightDayOfMonth = ACDateUtilities.getLastDayOfMonth(ACDateUtilities
                .addMonth(getTargetDateSource(), 1));
        if (isLeft) {
            // �J�����_�[�i���j�̏����l�𐶐�����
            for (int i = 0; i <= leftDayOfMonth; i++) {
                bindData.setData("CALENDAR_LEFT_DAY" + i, new Integer(1));
            }
        }

        // �J�����_�[�i�E�j�̏����l�𐶐�����
        if (isRight) {
            for (int j = 0; j <= rightDayOfMonth; j++) {
                bindData.setData("CALENDAR_RIGHT_DAY" + j, new Integer(1));
            }
            // TODO
            // ���������f�[�^����ʂɓW�J����B
        }
        getCalendars().setSource(bindData);
        getCalendars().bindSource();
    }

    /**
     * @throws Exception
     */
    public void initializeCalendar() throws Exception {
        // �������Ɏg���l���i�[����ϐ�
        VRMap bindData = new VRHashMap();
        // �Ώی��̖���
        int leftDayOfMonth = ACDateUtilities
                .getLastDayOfMonth(getTargetDateSource());
        // �Ώی��{�P���̖���
        int rightDayOfMonth = ACDateUtilities.getLastDayOfMonth(ACDateUtilities
                .addMonth(getTargetDateSource(), 1));
        // �J�����_�[�i���j�̏����l�𐶐�����
        for (int i = 0; i <= leftDayOfMonth; i++) {
            bindData.setData("CALENDAR_LEFT_DAY" + i, new Integer(1));
        }

        // �J�����_�[�i�E�j�̏����l�𐶐�����
        for (int j = 0; j <= rightDayOfMonth; j++) {
            bindData.setData("CALENDAR_RIGHT_DAY" + j, new Integer(1));
        }
        // TODO
        // ���������f�[�^����ʂɓW�J����B
        getCalendars().setSource(bindData);
        getCalendars().bindSource();

    }

    /**
     * @param list
     * @return mode �������[�h
     * @throws Exception
     */
    public int checkMode(VRList list) throws Exception {

        // �������擾�ł��Ȃ������ꍇ
        if (list.size() <= 0) {
            // �V�K���[�h�Ƃ��ĕԂ�
            return QkanConstants.PROCESS_MODE_INSERT;
        }

        // �J�����_�[�f�[�^���S�ď����l�ł��邩�`�F�b�N����
        for (int i = 0; i < list.size(); i++) {
            VRMap map = (VRMap) list.getData(i);

            if (!new Integer(1).equals(map.getData("VISIT_VALUE"))) {
                // �����l�ȊO�Ȃ̂ōX�V���[�h�Ƃ��ĕԂ�
                return QkanConstants.PROCESS_MODE_UPDATE;

            } else if (map.getData("VISIT_VALUE") == null) {
                // null�̏ꍇ�͉������Ȃ�

            }

        }

        // �l���S��1�������ꍇ�͍X�V���[�h�Ƃ��ď�������B
        return QkanConstants.PROCESS_MODE_UPDATE;

    }

}
