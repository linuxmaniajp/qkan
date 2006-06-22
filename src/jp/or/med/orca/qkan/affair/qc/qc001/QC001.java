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
 * �쐬��: 2005/12/10  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �v�揑������ (001)
 * �v���O���� �v�揑������ (QC001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc001;

import java.awt.event.ActionEvent;
import java.text.Format;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.component.table.VRSortableTableModelar;
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
 * �v�揑������(QC001)
 */
public class QC001 extends QC001Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QC001() {
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
        // ����ʓW�J���C�x���g

        // �n��f�[�^�̎擾/�O��ʁu���p�҈ꗗ�v����n���ꂽ�p�����[�^��ޔ�����B
        VRMap parameters = affair.getParameters();
        // this.patientID = PATIENT_ID(���p��ID)
        // String patientID = (String)parameters.getData("PATIENT_ID");
        if (VRBindPathParser.has("PATIENT_ID", parameters)) {
            // ���p��ID�L��
            // int�^�Ɍ^�ϊ������p��ID��ޔ�
            setPatientID(Integer.parseInt(String.valueOf(VRBindPathParser.get(
                    "PATIENT_ID", parameters))));
        }
        // this.targetDateSource = TARGET_DATE(�Ώ۔N��)
        if (VRBindPathParser.has("TARGET_DATE", parameters)) {
            // �Ώ۔N���L��
            // ���t�^�Ɍ^�ϊ����ޔ�
            setTargetDateSource((Date) VRBindPathParser.get("TARGET_DATE",
                    parameters));

        }

        setPASSIVE_CHECK_KEY_PLAN(new ACPassiveKey("HOMONKANGO_PLAN",
                new String[] { "PATIENT_ID", "TARGET_DATE" }, new Format[] {
                       null , new ACSQLSafeDateFormat("yyyy/M/d") },
                "LAST_TIME", "LAST_TIME"));

        // ��ʂ̏�Ԃ̏��������s���B
        setState_INIT_STATE();

        getPlanNotesColumn1().setFormat(new VRDateFormat("ggge�NMM��dd��"));

        // DB����f�[�^���擾����B
        doFind();

        // �Z����1�s�ڂ�I����Ԃɂ���
        if (getPlanNoteData().size() > 0) {
            getPlanNotes().setSelectedModelRow(
                    ((VRSortableTableModelar) getPlanNotes().getModel())
                            .getReverseTranslateIndex(0));

        }

    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }

        // �����߂蔻�ʏ������ǂ������ʂ���
        if (getForciblyBackCheckFlag()) {

            // �߂�p�n��p�����[�^�ɁA���L�̒l��ݒ肷��B

            // �O��ʂɖ߂�B
            return true;
        }

        parameters.setData("PATIENT_ID", new Integer(getPatientID()));

        // ���X�i�b�v�V���b�g�`�F�b�N
        // �X�i�b�v�V���b�g�̍X�V�`�F�b�N���s���B
        if (!getPlanNoteChangeFlag() && !getSnapshot().isModified()) {
            // �X�V����Ă��Ȃ��ꍇ
            // �O��ʂɖ߂�B
            // TODO ACAffairInfo affair = new
            // ACAffairInfo(QU001.class.getName());
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
        switch (msgID) {
        case ACMessageBox.RESULT_YES:
            // �u�X�V���Ė߂�v�I����
            // �������p������B
            break;
        case ACMessageBox.RESULT_NO:

            // �u�j�����Ė߂�v�I����
            // �߂�p�n��p�����[�^�ɁA���L�̒l��ݒ肷��B
            // KEY : NEXT_AFFAIR
            // �O��ʂɖ߂�B
            return true;

        case ACMessageBox.RESULT_CANCEL:
            // �u�L�����Z���v�I����
            // �����𒆒f����B
            return false;
            
        default:
            return true;
                

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
        boolean saveState = false;

        if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
            saveState = doInsert();
        } else {
            saveState = doUpdate();
        }

        if (!saveState) {
            // �ۑ��������ُ�I�������ꍇ
            // �����𒆒f����B
            return false;
            // �ۑ�����������I�������ꍇ
        } else {
            // �߂�p�n��p�����[�^�ɁA���L�̒l��ݒ肷��B
            // KEY : NEXT_AFFAIR
            // �O��ʂɖ߂�B
            // �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
            return true;
        }
    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }

        // ���X�i�b�v�V���b�g�`�F�b�N
        // �X�i�b�v�V���b�g�̍X�V�`�F�b�N���s���B
        // �X�V����Ă��Ȃ��ꍇ
        // �V�X�e�����I������B

        // �X�V����Ă���ꍇ

        // �������p������B
        // ���I���m�F
        if (!getPlanNoteChangeFlag() && !getSnapshot().isModified()) {
            return true;

        } else {

            int msgID = QkanMessageList.getInstance()
                    .WARNING_OF_CLOSE_ON_MODIFIED();
            // �I���m�F�̃��b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_CLOSE_ON_MODIFIED
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
        // �I����������Ȃ��true��Ԃ��B
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

        // �e�[�u���ɕύX�����邩�`�F�b�N����
        if (getPlanNoteChangeFlag()) {
            // �ύX���������ꍇ
            changeFlag = true;
        }

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

        // planData�ɁA��ʂ��璊�o���������i�[����B
        VRMap planData = getPlanData();
        getContents().setSource(planData);
        getContents().applySource();

        // ����N���X�ւ̓n��p�����[�^(���R�[�h) printParam�𐶐�����B
        VRMap printParam = null;
        printParam = new VRHashMap();

        // printParam�ɁAplanData�̒l���R�s�[����B
        printParam = planData;

        // printParam�ɁA���L�p�����[�^��ݒ肷��B
        // KEY : PLAN_NOTE
        printParam.setData("PLAN_NOTE", getPlanNoteData());

        // ����Ǘ��N���X�𐶐�
        ACChotarouXMLWriter writer = new ACChotarouXMLWriter();

        // ����J�n��錾
        writer.beginPrintEdit();
        // printParam.setData()
        QC001P01 qc001p01 = new QC001P01();

        // �������B
        if (qc001p01.doPrint(writer, printParam)) {

            // �������ꂽ�ꍇ
            // ����I����錾
            writer.endPrintEdit();

            // PDF�t�@�C���𐶐����ĊJ��
            ACChotarouXMLUtilities.openPDF(writer);

        } else {
            // ��������Ȃ������ꍇ
        }

    }

    /**
     * �u���߂̖K��Ō�v�揑���̓Ǎ��v�C�x���g�ł��B
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
        switch (msgID) {
        case ACMessageBox.RESULT_OK:
            // �uOK�v�I����
            // �������p������B
            break;
        case ACMessageBox.RESULT_CANCEL:
            // �u�L�����Z���v�I����
            return;
        // �����𒆒f����B
        }
        // ���ߋ��̒��߂̏����擾
        // SQL���擾�֐��ւ̓n��p�����[�^(���R�[�h) sqlParam�ɉ��L�p�����[�^��ݒ肷��B
        VRMap sqlParam = null;
        sqlParam = new VRHashMap();
        // KEY : PATIENT_ID
        sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
        // KEY : TARGET_DATE
        sqlParam.setData("TARGET_DATE", (Date) getTargetDateSource());
        // �ߋ��̒��߂̏����擾���邽�߂�SQL�����擾����B
        // �擾����SQL���𔭍s����B
        VRList lastPlanData = getDBManager().executeQuery(
                getSQL_GET_LAST_PLAN(sqlParam));
        // �擾������0����葽���ꍇ
        if (lastPlanData.size() > 0) {

            // �擾���R�[�h�W����1���ڂ̃��R�[�h��ޔ�����B
            VRMap lastPlanDataMap = (VRMap) lastPlanData.getData(0);

            // contetns�p�l����source�Ƃ��āA�ޔ��������R�[�h��ݒ肷��B
            getContents().setSource(lastPlanDataMap);

            // bindSource�����s���A�ޔ��������R�[�h�̒l��contents�p�l���ɓW�J����B
            getContents().bindSource();

        } else {
            // �擾������0���̏ꍇ
            // �ߋ���񂪑��݂��Ȃ��������Ƃ�ʒm���郁�b�Z�[�W��\������B
            QkanMessageList.getInstance().QC001_NOTICE_HAS_NO_LAST_DATA();
            // �f�[�^�̏㏑�͍s��Ȃ��B
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

        // ���ݑI������Ă�s�����i�[����ϐ�
        int n = 0;
        // ���ݑI������Ă���s���擾
        if (getPlanNotes().isSelected()) {
            n = getPlanNotes().getSelectedModelRow();
        }

        // �G���[���Ȃ��ꍇ
        // �������p������B
        // ���ۑ�����
        // �ۑ��������s���B
        if (doInsert()) {
            // �o�^�������b�Z�[�W��\������
            QkanMessageList.getInstance().INSERT_SUCCESSED();
        }

        // �I������Ă����s�Ƀt�H�[�J�X�𓖂Ă�B
        getPlanNotes().setSelectedModelRow(n);

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

        // ���ݑI������Ă�s�����i�[����ϐ�
        int n = 0;
        // ���ݑI������Ă���s���擾
        if (getPlanNotes().isSelected()) {
            n = getPlanNotes().getSelectedModelRow();
        }

        // �G���[���Ȃ��ꍇ
        // �������p������B
        // ���ۑ�����
        // �ۑ��������s���B
        if (doUpdate()) {
            // �X�V�������b�Z�[�W��\������B
            QkanMessageList.getInstance().UPDATE_SUCCESSED();
        }

        // �I������Ă����s�Ƀt�H�[�J�X�𓖂Ă�B
        getPlanNotes().setSelectedModelRow(n);

    }

    /**
     * �u�I�����Ə��̊Ǘ��Ҏ����̐ݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void providerNameActionPerformed(ActionEvent e) throws Exception {
        // �R���{�ɓ��͂���Ă��鎖�Ə�������A���̎��Ə��́u�Ǘ��Ҏ���(ADMINISTRATOR_NAME)�v(������)���擾����B
        // getAdministratorName((�R���{�̑I���A�C�e���̃��R�[�h));       

        if (getProviderName().getSelectedIndex() >= 0) {
            // ��ʂ́u�Ǘ��Ҏ���(administratorName)�v�ɁA�擾�����������ݒ肷��B

            String adName = "";

            adName = (String) getAdministratorName((VRMap) getProviderName()
                    .getSelectedModelItem());

            getAdministratorName().setText(adName);

        }

    }

    /**
     * �u���_�E������̒ǉ��v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void planNoteEditButtonAddActionPerformed(ActionEvent e)
            throws Exception {
        // �����̓`�F�b�N
        // ���̓`�F�b�N���s���B
        if (!checkNoteValue()) {
            // ���̓G���[���������ꍇ
            // �����𒆒f����B
            return;
        }
        // ���̓G���[���Ȃ������ꍇ
        // �������p������B
        // ���e�[�u���ւ̍s�̒ǉ�
        // ��ʂ́u���_�E������ꗗ(planNotes)�v�ɁA���͓��e(planNoteEditDate,
        // planNoteEditComment)��ǉ�����B

        VRMap tableSource = null;
        // �e�[�u���p�̃\�[�X�擾�p�̃n�b�V���}�b�v��������
        tableSource = new VRHashMap();
        // applySource����p�l�����w��
        getTabsNotes().setSource(tableSource);
        // ��ʏ�̏����擾
        getTabsNotes().applySource();

        // �w�肵���t�H�[�}�b�g�ŕϊ��������t���i�[����
        tableSource.setData("NOTE_DATE", (Date) tableSource
                .getData("NOTE_DATE"));

        getPlanNoteData().add(tableSource);

        // �ǉ������R�[�h�̍s�Ƀt�H�[�J�X�𓖂Ă�
        getPlanNotes().setSelectedSortedRow(getPlanNoteData().size() - 1);

        // �e�[�u���t���O��ύX�L��ɂ���
        setPlanNoteChangeFlag(true);

        // �o�^������0���ȏ�̏ꍇ�͕ҏW�A�폜�����\�ɂ���
        if (getPlanNoteData().size() >= 0) {
            setState_NOTE_SELECTED();
        }

    }

    /**
     * �u���_�E������̍X�V�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void planNoteEditButtonEditActionPerformed(ActionEvent e)
            throws Exception {
        // �����̓`�F�b�N
        // ���̓`�F�b�N���s���B
        if (!checkNoteValue()) {
            // ���̓G���[���������ꍇ
            // �����𒆒f����B
            return;
        }
        if (getPlanNotes().isSelected()) {
            // ���̓G���[���Ȃ������ꍇ
            // �������p������B
            // ���e�[�u���̍s�̍X�V
            // ��ʂ́u���_�E������ꗗ(planNotes)�v��̑I���s���A���͓��e(planNoteEditDate,
            // planNoteEditComment)�ōX�V����B
            VRHashMap planNoteSource = new VRHashMap();
            // �����擾����n�b�V���}�b�v��������B
            getTabsNotes().setSource(planNoteSource);
            getTabsNotes().applySource();

            planNoteSource.setData("NOTE_DATE", (Date) VRBindPathParser.get(
                    "NOTE_DATE", planNoteSource));
            // �e�[�u���̌��f�[�^���Q�Ɛݒ肷��B
            VRList pND = (VRList) getPlanNoteData();
            // �e�[�u���̑I���s�̃f�[�^�Ɠ��̓f�[�^�̍����ւ����s��
            pND.setData(getPlanNotes().getSelectedModelRow(), planNoteSource);

            getTabsNotes().revalidate();
            getTabsNotes().repaint();

            // �e�[�u���t���O��ύX�L��ɂ���
            setPlanNoteChangeFlag(true);
        }

    }

    /**
     * �u���_�E������̍폜�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void planNoteEditButtonDeleteActionPerformed(ActionEvent e)
            throws Exception {
        // ���e�[�u���̍s�̍폜
        // ��ʂ́u���_�E������ꗗ(planNotes)�v�ォ��A�I���s�̃f�[�^���폜����B
        // �I���s���폜�i�e�[�u���ɔ��f�j
        // �I������Ă��邩�`�F�b�N����B
        if (getPlanNotes().isSelected()) {

            // �I������Ă����ꍇ�폜����B
            // �I������Ă���s�̃f�[�^�ƑΉ���������f�[�^�ԍ���Ԃ�
            int sel = getPlanNotes().getSelectedModelRow();

            // �I���s�̃f�[�^���폜����
            getPlanNoteData().removeData(sel);

            // �폜��̗��z�ƂȂ��ԍ���ݒ肷��B
            getPlanNotes().setSelectedSortedRowOnAfterDelete(sel);

            // �e�[�u���t���O��ύX�L��ɂ���
            setPlanNoteChangeFlag(true);

            // �����e�[�u���̍s����0�s�ɂȂ����ꍇ�A�ҏW�A�폜�{�^���������s�\�ɂ���B
            if (getPlanNoteData().size() <= 0) {
                // ��ʏ�Ԃ�ύX����
                setState_NOTE_UNSELECTED();
                // �N���A����
                getPlanNoteEditDate().setText("");
                getPlanNoteEditComment().setText("");

            }
        }
    }

    /**
     * �u���_�E������̃N���A�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void planNoteEditButtonClearActionPerformed(ActionEvent e)
            throws Exception {
        // �����_�E������̓��͗����N���A����B
        // ���t�e�L�X�g�iplanNoteEditDate�j�� ""��ݒ肷��B
        getPlanNoteEditDate().setText("");
        // ���_�E������R�����g�iplanNoteEditComment�j��""��ݒ肷��B
        getPlanNoteEditComment().setText("");

    }

    /**
     * �u�Z���I���C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void planNotesSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ���_�E������̃Z���I���̃C�x���g
        // �I���s�̃��R�[�h���擾����B
        if (getPlanNotes().isSelected()) {

            // ���ݑI�𒆂̃��R�[�h���擾����
            VRMap selectMap = (VRMap) getPlanNoteData().getData(
                    getPlanNotes().getSelectedModelRow());

            // �擾�������R�[�h���Z�b�g����
            getPlanNoteEditDates().setSource(selectMap);

            // ���R�[�h���� PLAN_DATE �� PLAN_COMMENT ���e�L�X�g�ɕ\������B
            // �Z�b�g�������R�[�h��W�J����
            getPlanNoteEditDates().bindSource();

        } else {
            // �N���A����
            getPlanNoteEditDate().setText("");
            getPlanNoteEditComment().setText("");
        }

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        try {
            VRHashMap param = new VRHashMap();
            param.setData("PATIENT_ID", "1");
            // param.setData("TARGET_DATE", new Date(105, 12, 5));

            Date result = ACDateUtilities.createDate(2006, 1, 18);
            param.setData("TARGET_DATE", (Date) result);

            System.out.println(VRBindPathParser.get("TARGET_DATE", param));

            ACFrame.setVRLookAndFeel();
            ACFrame.getInstance().setFrameEventProcesser(
                    new QkanFrameEventProcesser());
            QkanCommon.debugInitialize();
            // ACFrame.debugStart(new
            // ACAffairInfo(QC001.class.getName(),param));
            ACAffairInfo affair = new ACAffairInfo(QC001.class.getName(), param);
            // ACFrame.getInstance().next(affair);
            ACFrame.debugStart(affair);
            // ACFrame.getInstance().next(affair);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // �����֐�

    /**
     * �u�E�B���h�E�^�C�g���̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {

        // ���E�B���h�E�^�C�g���E�Ɩ��{�^���o�[�̐ݒ�
        setAffairTitle("QC001", "0", getButtons());

        // �\������Ώ۔N�����쐬���鏈��
        Date from = getTargetDateSource();
        // �N���i�a��j���擾����
        int eraYear = ACDateUtilities.getEraYear(from);
        // ����(�������́j���擾
        String result = ACDateUtilities.getEraFull(from);
        // �����擾
        int month = ACDateUtilities.getMonth(from);

        getTargetDate().setText(
                String.valueOf(result + eraYear + "�N" + month + "��"));

        // �v���x�̏����l�̐ݒ�
        getYokaigodo().setSelectedIndex(1);
        
        // ���R���{�̃A�C�e���̏����ݒ�
        // ���w��K��Ō�X�e�[�V������(providerName)
        // �T�[�r�X�񋟎��Ə��擾�֐��ɓn���p�����[�^(���R�[�h�W��) services�𐶐�����B
        VRArrayList services = new VRArrayList();
        // services�Ɉȉ��̐��l�^�̒l��ݒ肷��B
        // 11311
        // 20101
        services.add(new Integer(11311));
        services.add(new Integer(20101));

        // �K��Ō��񋟂��鎖�Ə����擾����B
        VRList stationList = new VRArrayList();
        stationList = QkanCommon.getProviderInfo(getDBManager(), services);

        // �擾�������R�[�h�W�����u�w��K��Ō�X�e�[�V�������v�R���{�ɐݒ肷��B
        getProviderName().setModel(stationList);

        // ���_�E������e�[�u���̕ύX�m�F�t���O�����ݒ���s��
        setPlanNoteChangeFlag(false);

        // �����߂�Ń`�F�b�N�t���O�̏����ݒ���s���B
        setForciblyBackCheckFlag(false);

    }

    /**
     * �u�K��Ō�v�揑���̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doFind() throws Exception {
        // ��DB����K��Ō�v�揑�����擾
        // SQL���擾�֐��ւ̓n��p�����[�^(���R�[�h) sqlParam�ɉ��L�p�����[�^��ݒ肷��B
        VRHashMap sqlParam = new VRHashMap();
        VRMap planDataMap = null;

        // �����ݒ���s��
        initialize();

        // ������
        planDataMap = new VRHashMap();

        // �Q�Ɛ挈��
        planDataMap = getPlanData();

        // KEY : PATIENT_ID
        // KEY : TARGET_DATE
        sqlParam.setData("PATIENT_ID", String.valueOf(getPatientID()));
        sqlParam.setData("TARGET_DATE", (Date) getTargetDateSource());

        // �����p�ҏ���DB����擾
        // �Ώۗ��p��(���p�҈ꗗ�őI�����ꂽ���p��)�̊�{�����擾����B
        VRList patientInfoList = QkanCommon.getPatientInfo(getDBManager(),
                getPatientID());
        // �擾�ł��Ȃ������ꍇ

        if (patientInfoList.size() < 1) {
            // �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_FIND
            int msgID = QkanMessageList.getInstance()
                    .ERROR_OF_PASSIVE_CHECK_ON_FIND();
            // �uQU001 ���p�҈ꗗ�v��ʂɖ߂�B(�����𔲂���)
            // �G���[�����������߂蔻��
            setForciblyBackCheckFlag(true);
            ACFrame.getInstance().back();
            return;                  
        } else {
            // �擾�ł����ꍇ
            // �������p������B
            // �擾�������R�[�h��planData�ɐݒ肷��B
            planDataMap.putAll((VRMap) patientInfoList.getData(0));

        }

        // �v���x���擾
        VRList patientYokaigo = QkanCommon.getPatientInsureInfoOnEndOfMonth(
                getDBManager(), getTargetDateSource(), getPatientID());

        //
//        if (patientYokaigo.size() < 1) {
//            // �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_FIND
//            int msgID = QkanMessageList.getInstance()
//                    .ERROR_OF_NO_NINTEI_HISTORY();
//            // �uQU001 ���p�҈ꗗ�v��ʂɖ߂�B(�����𔲂���)
//
//            // �G���[�����������߂蔻��
//            setForciblyBackCheckFlag(true);
//            ACFrame.getInstance().back();
//            return;
//        } 
        
        if (!(patientYokaigo == null || patientYokaigo.size() == 0)) {
			// �擾�ł����ꍇ
			// �擾�������R�[�h��planData�ɐݒ肷��B
			planDataMap.putAll((VRMap) patientYokaigo.getData(0));

		}

        // ���N��̎擾
        // �V�X�e������A�V�X�e�����t���擾����B
        QkanSystemInformation.getInstance().getSystemDate();

        // ���p�Ґ��N�����A�y�уV�X�e�����t����N����Z�o����B
        // calcAge((�擾�������R�[�h��PATIENT_BIRTHDAY), (�V�X�e�����t));
        // planData�ɉ��L�̒l��ݒ肷��B
        // KEY : PATIENT_AGE
        if (VRBindPathParser.get("PATIENT_BIRTHDAY", getPlanData()) != null) {
            int ageInt = QkanCommon.calcAge((Date) VRBindPathParser.get(
                    "PATIENT_BIRTHDAY", getPlanData()));
            planDataMap.setData("PATIENT_AGE", new Integer(ageInt));
        }

        // �����p�Ҏ����̎擾
        // ���p�҂̐��E����A�����A���p�҂̃t���l�[�����擾����B
        // toFullName((planData��KEY:PATIENT_FAMILY_NAME��VALUE),
        // (planData��KEY:PATIENT_FIRST_NAME��VALUE));
        // planData�ɉ��L�̒l��ݒ肷��B
        // KEY : PATIENT_NAME
        planDataMap.setData("PATIENT_NAME", QkanCommon.toFullName(
                VRBindPathParser.get("PATIENT_FAMILY_NAME", getPlanData()),
                VRBindPathParser.get("PATIENT_FIRST_NAME", getPlanData())));

        // �K��Ō�v�揑���擾�p��SQL�����擾����B
        // �擾����SQL���𔭍s����B
        VRList planList = getDBManager()
                .executeQuery(getSQL_GET_PLAN(sqlParam));

        // �擾������0���̏ꍇ
        if (planList.size() <= 0) {
            // processMode��PROCESS_MODE_INSERT��ݒ肷��B(�o�^���[�h)
            setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
            // �o�^�{�^����\������B
            setState_PROCESS_MODE_INSERT();
            // planData��contents�p�l���ɐݒ肵�AcreateSource�����s����B
            VRMap clearMap = (VRMap) getContents().createSource();
            // planData�ɁA�����l��ݒ肷��B
            planDataMap.setData(clearMap);

            setInitValue();
        } else {

            // �擾������0����葽���ꍇ
            // processMode��PROCESS_MODE_UPDATE��ݒ肷��B(�X�V���[�h)
            setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

            // �X�V�{�^����\������B
            setState_PROCESS_MODE_UPDATE();

            // planData�ɁA�擾�������R�[�h�W����1���ڂ̃��R�[�h�̒l��ǉ�����B
            planDataMap.putAll((VRMap) planList.getData(0));

            // �p�b�V�u�L�[��o�^����B
            getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY_PLAN(),
                    planList);
        }

        // contents�p�l����source�Ƃ��āAplanData��ݒ肷��B
        getContents().setSource(getPlanData());
        // bindSource�����s���AplanData�̒l��contents�p�l���ɓW�J����B
        getContents().bindSource();
        // ���K��Ō�v�揑�E���_�E��������̎擾�A�ݒ�
        // SQL���擾�֐��ւ̓n��p�����[�^(���R�[�h) sqlParam�ɉ��L�p�����[�^��ݒ肷��B
        // KEY : PATIENT_ID VALUE : patientID (�ޔ������n��p�����[�^)
        // KEY : NOTE_DATE VALUE : targetDateSource + 1���� (�Ώ۔N���̗���1����ݒ�)
        sqlParam.clear();
        sqlParam.setData("PATIENT_ID", String.valueOf(getPatientID()));
        // �Ώ۔N���{�P����ݒ�
        Date result = ACDateUtilities.addMonth(getTargetDateSource(), 1);
        sqlParam.setData("NOTE_DATE", result);
        // �K��Ō�v�揑�E���_�E��������擾�p��SQL�����擾����B

        // �擾����SQL���𔭍s���A���ʂ�planNoteData�Ɋi�[����B

        // getPlanNoteData().setData(getDBManager().executeQuery(getSQL_GET_PLAN_NOTE(sqlParam)));
        VRList nd = getDBManager().executeQuery(getSQL_GET_PLAN_NOTE(sqlParam));

        if (nd.size() > 0) {
            getPlanNoteData().clearData();
            getPlanNoteData().addAll((VRList) nd);
        }
        // �擾������0����葽���ꍇ
        // �e�[�u�����f�����쐬���ݒ肷��B
        ACTableModelAdapter planTableModel = new ACTableModelAdapter();

        planTableModel.setColumns(new String[] { "NOTE_DATE", "NOTE_COMMENT" });

        if (getPlanNoteData().getDataSize() > 0) {

            // ��ʂ́u���_�E������ꗗ(planNotes)�v�ɁA�擾�������R�[�h�W����ݒ肷��B
            // getPlanNotes().setModel()
            // 0 : NOTE_DATE
            // 1 : NOTE_COMMENT
            getPlanNotes().setModel(planTableModel);
            // �e�[�u����\��
            planTableModel.setAdaptee(getPlanNoteData());

            // �p�b�V�u�L�[��o�^����B
            // reservedPassive(PASSIVE_CHECK_KEY_PLAN_NOTE, (�擾�������R�[�h�W��));

            // getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY_PLAN_NOTE(),getPlanNoteData());

        } else {
            // 0���̏ꍇ
            // ��ʂ́u���_�E������ꗗ(planNotes)�v�́A��w�b�_�̐ݒ�̂ݍs���B
            getPlanNotes().setModel(planTableModel);
            planTableModel.setAdaptee(getPlanNoteData());
            // �p�b�V�u�L�[��o�^����B
            // getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY_PLAN_NOTE(),getPlanNoteData());

        }

        // �ϐ�noteCount�ɁA�擾������ޔ�����B
        setNoteCount(getPlanNoteData().size());

        // ��������Ԃ̐ݒ�
        // ��ʂ̏�����Ԃ�ݒ肷��B
        setState_INIT_STATE();
        // ���݂̓o�^�������`�F�b�N����
        if (getNoteMaxCount() == 0) {
            // ���_�E�����􂪂P���o�^����Ă��Ȃ��ꍇ
            setState_NOTE_UNSELECTED();
        } else {
            // �P�ł��o�^����Ă����ꍇ
            setState_NOTE_SELECTED();
        }

        // �X�i�b�v�V���b�g�̎B�e�Ώۂ��w�肷��B
        getSnapshot().setRootContainer(getContents());

        // ���X�i�b�v�V���b�g�̎B�e
        // �X�i�b�v�V���b�g�B�e���O�Ώۊi�[�p�̃��R�[�h�W��excludedInstance�𐶐�����B
        VRList excludedInstance = null;
        excludedInstance = new VRArrayList();

        // excludedInstance�ɉ��L�̃C���X�^���X��ǉ�����B
        // �EplanNoteEditDates
        excludedInstance.add(getPlanNoteEdits());

        // �B�e�Ώۂ��珜�O����C���X�^���X��ݒ肷��B
        getSnapshot().setExclusions(excludedInstance);
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
        // SQL���擾�֐��ւ̓n��p�����[�^(���R�[�h) sqlParam�𐶐�����B
        VRMap sqlParam = null;
        sqlParam = new VRHashMap();

        // sqlParam�ɉ��L�̒l��ݒ肷��B
        // KEY :PATIENT_ID
        sqlParam.setData("PATIENT_ID", String.valueOf(getPatientID()));

        // �u�K��Ō�X�e�[�V��������TABLE(PATIENT_STATION_HISTORY)�v�̏��擾�p��SQL�����擾����B
        // �擾����SQL���𔭍s����B
        VRList patientStationHistory = getDBManager().executeQuery(
                getSQL_GET_PATIENT_STATION_HISTORY(sqlParam));

        // �擾������0����葽���ꍇ
        // HashMap���ꎞ�I�Ɋi�[����Map
        VRMap homonData = null;

        // ������
        homonData = new VRHashMap();

        // �Q�Ɛݒ�
        VRMap setMap = getPlanData();

        if (patientStationHistory.size() > 0) {
            // �擾�������R�[�h�W���̍ŏ��̃��R�[�h��ޔ�����B
            VRMap ps = (VRMap) patientStationHistory.getData(0);

            // planData�ɉ��L�̒l��ݒ肷��B
            // KEY : DOCTOR_NAME
            // DOCTOR_NAME�����݂��Ă��邩�`�F�b�N����B
            if (VRBindPathParser.has("DOCTOR_NAME", ps)) {
                homonData.setData("DOCTOR_NAME", VRBindPathParser.get(
                        "DOCTOR_NAME", ps));
                setMap.putAll(homonData);
            } else {
                System.out.println("�f�[�^���Ȃ��ł�");
            }

        } else {
            // �擾������0���̏ꍇ
            // planData�ɉ��L�̒l��ݒ肷��B
            // KEY : DOCTOR_NAME
            homonData.setData("DOCTOR_NAME", "");

            setMap.putAll(homonData);
        }
        // ���쐬�N���̐ݒ�
        // �V�X�e������A�u�V�X�e�����t�v���擾����B
        Date systemDate = QkanSystemInformation.getInstance().getSystemDate();

        // planData�ɉ��L�̒l��ݒ肷��B
        // KEY : CREATE_DATE
        homonData.setData("CREATE_DATE", systemDate);
        setMap.putAll(homonData);

        // ���K��Ō�񋟎��Ə��R���{�̏����I���A�C�e���̐ݒ�
        // ���O�C�����Ə��ԍ����擾����B
        String loginProvider = QkanSystemInformation.getInstance()
                .getLoginProviderID();

        // VRMap stationMap = null;
        VRMap stationMap = new VRHashMap();

        // �����l��ݒ肷��B
        setMap.setData("PROVIDER_NAME", "");

        // �K��Ō�񋟎��Ə��R���{�̒��ɁA���O�C�����Ə��ԍ��Ɠ����ID�̎��Ə������݂��邩�ǂ����`�F�b�N����B
        for (int i = 0; getProviderName().getModel().getSize() > i; i++) {

            stationMap = (VRMap) getProviderName().getModelItem(i);

            // ���O�C�����Ə��Ɠ���̎��Ə������݂����ꍇ
            if (loginProvider.equals(stationMap.getData("PROVIDER_ID"))) {
                // ���݂���ꍇ
                // planData�ɉ��L�̒l��ݒ肷��B
                // KEY : PROVIDER_NAME
                getProviderName().setSelectedIndex(i);

                // ���݂��Ȃ��ꍇ
                // planData�ɉ��L�̒l��ݒ肷��B
                // KEY : PROVIDER_NAME

            }
        }
        // ���Ǘ��Ҏ����̐ݒ�
        // �R���{�ɓ��͂���Ă��鎖�Ə�������A���̎��Ə��́u�Ǘ��Ҏ���(ADMINISTRATOR_NAME)�v���擾����B
        // getAdministratorName((�R���{�̑I���A�C�e���̃��R�[�h));

        // planData�ɉ��L�̒l��ݒ肷��B
        // KEY : ADMINISTRATOR_NAME
        // ���Ə����͑I���C�x���g�Őݒ肷�邽�ߏ���
        setMap.remove("PROVIDER_NAME");

        // ��ʏ�ɏ����l�Ƃ��ēW�J����
        getContents().setSource(setMap);
        getContents().bindSource();

    }

    /**
     * �u���̓`�F�b�N(���_�E������)�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean checkNoteValue() throws Exception {
        // �����̓`�F�b�N
        // ���u���_�E������v���t���ڂ̃`�F�b�N
        // ��ʂ́u���_�E������E���t(planNoteEditDate)�v�̒l���`�F�b�N����B
        if (ACTextUtilities.isNullText(getPlanNoteEditDate().getText())) {
            // �����͂̏ꍇ
            // �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT
            // �����𒆒f����B(���̓G���[)
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
                    "���_�E������̓��t");

            // �t�H�[�J�X�𓖂Ă�
            getPlanNoteEditDate().requestFocus();

            // �����𒆒f����B(���̓G���[)
            return false;
        }

        // ������_�E������E���t��̒l���s���łȂ����`�F�b�N����B
        if (!getPlanNoteEditDate().isValidDate()) {
            // �����𒆒f����B(�s���ȓ��t)
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("���_�E�������");

            // �t�H�[�J�X�𓖂Ă�
            getPlanNoteEditDate().requestFocus();

            // �����𒆒f����B(���̓G���[)
            return false;
        }
        
        // ���u���_�E������v�R�����g���ڂ̃`�F�b�N
        // ��ʂ́u���_�E������E�R�����g(planNoteEditComment)�v�̒l���`�F�b�N����B
        if (ACTextUtilities.isNullText(getPlanNoteEditComment().getText())) {
            // �����͂̏ꍇ
            // �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
                    "���_�E������̓��e");

            // �t�H�[�J�X�𓖂Ă�
            getPlanNoteEditComment().requestFocus();

            // �����𒆒f����B(���̓G���[)
            return false;
        }

        // ��L�`�F�b�N�œ��̓G���[���������Ȃ������ꍇ�A�u������́v�Ƃ���B
        return true;
    }

    /**
     * �u�o�^�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean doInsert() throws Exception {
        // ���p�b�V�u�`�F�b�N�̂��߂̏���
        // planData�ɁA��ʂ��璊�o���������i�[����B
        VRMap planDataMap = null;
        planDataMap = new VRHashMap();
        planDataMap = getPlanData();

        // DB�}�l�[�W���[��`
        ACDBManager dbm = getDBManager();

        try {
            // �g�����U�N�V�����J�n
            dbm.beginTransaction();

            getContents().setSource(planDataMap);
            getContents().applySource();
            // planData�ɉ��L�̒l��ǉ�����B
            // KEY : PATIENT_ID
            // KEY : TARGET_DATE
            planDataMap.setData("PATIENT_ID", new Integer(getPatientID()));
            planDataMap.setData("TARGET_DATE", (Date) getTargetDateSource());

            // �p�b�V�u�^�X�N���N���A����B
            getPassiveChecker().clearPassiveTask();

            // ���K��Ō�v�揑���̃p�b�V�u�^�X�N��o�^
            // �K��Ō�v�揑���̃p�b�V�u�L�[��o�^����B
            // �K��Ō�v�揑���ǉ��p�̃p�b�V�u�^�X�N��o�^����B
            getPassiveChecker().addPassiveInsertTask(
                    getPASSIVE_CHECK_KEY_PLAN(), planDataMap);

            // ���K��Ō�v�揑�E���_�E������̃p�b�V�u�^�X�N��o�^
            // �K��Ō�v�揑�E���_�E�����􃌃R�[�h�̌������擾����B
            if (getNoteMaxCount() != getNoteCount()) {
                //�e�[�u�����b�N�����̂��߃��[���o�b�N
                dbm.rollbackTransaction();
                // �擾����������noteCount�̒l�Ƃ��r���A���݂ƃ��R�[�h�擾���̌����̈Ⴂ���`�F�b�N����B
                // �������قȂ�ꍇ
                // �p�b�V�u�G���[���b�Z�[�W��\������B
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();

                // �����𒆒f����B(�ُ�I��)
                return false;

            }
            // �����������ꍇ
            // �������p������B

            // ���p�b�V�u�`�F�b�N
            // �p�b�V�u�`�F�b�N�����s����B
            if (!getPassiveChecker().passiveCheck(dbm)) {
                //�e�[�u�����b�N�����̂��߃��[���o�b�N
                dbm.rollbackTransaction();
                // �p�b�V�u�G���[������ꍇ
                // �p�b�V�u�G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // �����𒆒f����B(�ُ�I��)
                return false;
            }

            // �p�b�V�u�G���[���Ȃ��ꍇ
            // �������p������B
            // ���K��Ō�v�揑�̓o�^
            // �K��Ō�v�揑���o�^�p��SQL�����擾����B
            // �擾����SQL���𔭍s����B
            dbm.executeUpdate(getSQL_INSERT_PLAN(planDataMap));

            // ���_�����􂪖����͂������ꍇ
            // ���K��Ō�v�揑�E���_�E��������̓o�^
            // noteCount�̒l���`�F�b�N����B
            // 0���̏ꍇ
            // DELETE�����͍s��Ȃ��B(���������A���ցB)
            if (getNoteMaxCount() > 0) {
                // 0����葽���ꍇ
                // �K��Ō�v�揑�E���_�E��������폜�p��SQL�����擾����B
                // �擾����SQL���𔭍s����B
                dbm.executeUpdate(getSQL_DELETE_PLAN_NOTE(planDataMap));
            }
            // planNoteData�̍ŏ��̃��R�[�h��planNoteDataMap�Ɋi�[����B
            VRMap planNoteDataMap = null;
            // ����������
            planNoteDataMap = new VRHashMap();

            if (getPlanNoteData().size() > 0) {
                // �������o�^����

                for (int i = 0; i < getPlanNoteData().size(); i++) {
                    planNoteDataMap = (VRMap) getPlanNoteData().getData(i);
                    planNoteDataMap.setData("PATIENT_ID", new Integer(
                            getPatientID()));
                    planNoteDataMap.setData("NOTE_ID", new Integer(i));

                    // �K��Ō�v�揑�E���_�E��������o�^�p��SQL�����擾����B
                    // �擾����SQL���𔭍s����B
                    dbm.executeUpdate(getSQL_INSERT_PLAN_NOTE(planNoteDataMap));
                }
            }

            // ���R�~�b�g/���[���o�b�N

            // ��L��A��SQL���s�����ŃG���[���Ȃ������ꍇ
            // �������R�~�b�g����B
            dbm.commitTransaction();
            // �X�V���[�h�ɕύX����
            setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

            // �����������s���B
            doFind();

            return true;
        } catch (Exception sqlEx) {
            // TODO: handle exception
            // �������I������B(����I��)
            // SQL���s�����ŃG���[���������ꍇ
            // ���������[��S�o�b�N����B
            sqlEx.printStackTrace();

            dbm.rollbackTransaction();

            // �����𒆒f����B(�ُ�I��)
            throw sqlEx;
        }

    }

    /**
     * �u�X�V�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean doUpdate() throws Exception {

        // ���p�b�V�u�`�F�b�N�̂��߂̏���
        VRMap planData = getPlanData();
        // planData�ɁA��ʂ��璊�o���������i�[����B
        getContents().setSource(planData);
        getContents().applySource();
        VRMap sqlParam = null;
        sqlParam = new VRHashMap();

        ACDBManager dbm = getDBManager();

        try {
            // �g�����U�N�V�����J�n
            dbm.beginTransaction();

            // planData�ɉ��L�̒l��ǉ�����B
            // KEY : PATIENT_ID
            // KEY : TARGET_DATE
            // SQL�擾�֐��ւ̓n���p�����[�^(���R�[�h) sqlParam�𐶐�����B
            sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
            sqlParam.setData("TARGET_DATE", (Date) getTargetDateSource());
            sqlParam.setData("NOTE_DATE", (Date) getTargetDateSource());

            // �p�b�V�u�^�X�N���N���A����B
            getPassiveChecker().clearPassiveTask();

            // ���K��Ō�v�揑���̃p�b�V�u�^�X�N��o�^
            // processMode�̒l���`�F�b�N����B
            // �K��Ō�v�揑���X�V�p�̃p�b�V�u�^�X�N��o�^����B
            getPassiveChecker().addPassiveUpdateTask(
                    getPASSIVE_CHECK_KEY_PLAN());

            // �擾����������noteMaxCount�̒l�Ƃ��r���A���݂ƃ��R�[�h�擾���̌����̈Ⴂ���`�F�b�N����B
            if (getNoteCount() != getNoteMaxCount()) {
                //�e�[�u�����b�N�����̂��߃��[���o�b�N
                getDBManager().rollbackTransaction();
                // �������قȂ�ꍇ
                // �p�b�V�u�G���[���b�Z�[�W��\������B
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // �����𒆒f����B(�ُ�I��)
                return false;
            }
            // �����������ꍇ
            // �������p������B

            // noteMaxCount�̒l���`�F�b�N����B

            // ���p�b�V�u�`�F�b�N
            // �p�b�V�u�`�F�b�N�����s����B
            if (!getPassiveChecker().passiveCheck(dbm)) {
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
            // �������p������B
            // ���K��Ō�v�揑�̓o�^
            // �K��Ō�v�揑���X�V�p��SQL�����擾����B
            // �擾����SQL���𔭍s����B
            dbm.executeUpdate(getSQL_UPDATE_PLAN(getPlanData()));
            // ���K��Ō�v�揑�E���_�E��������̓o�^
            // oteCount�̒l���`�F�b�N����B
            // 0���̏ꍇ
            // DELETE�����͍s��Ȃ��B(���������A���ցB)
            if (getNoteMaxCount() > 0) {
                // 0����葽���ꍇ
                // �K��Ō�v�揑�E���_�E��������폜�p��SQL�����擾����B
                // �擾����SQL���𔭍s����B
                dbm.executeUpdate(getSQL_DELETE_PLAN_NOTE(sqlParam));
            }
            VRMap planNoteDataMap = null;
            planNoteDataMap = new VRHashMap();
            if (getPlanNoteData().size() > 0) {
                for (int i = 0; i < getPlanNoteData().size(); i++) {
                    // planNoteData�̍ŏ��̃��R�[�h��planNoteDataMap�Ɋi�[����B
                    planNoteDataMap = (VRMap) getPlanNoteData().getData(i);
                    planNoteDataMap.setData("PATIENT_ID", new Integer(
                            getPatientID()));
                    planNoteDataMap.setData("NOTE_ID", new Integer(i));
                    // �K��Ō�v�揑�E���_�E��������o�^�p��SQL�����擾����B
                    // �擾����SQL���𔭍s����B
                    dbm.executeUpdate(getSQL_INSERT_PLAN_NOTE(planNoteDataMap));
                }
            }

            // ���R�~�b�g/���[���o�b�N
            // ��L��A��SQL���s�����ŃG���[���Ȃ������ꍇ
            // �������R�~�b�g����B
            dbm.commitTransaction();

            // �����������s���B
            doFind();

            return true;

            // �������I������B(����I��)
            // SQL���s�����ŃG���[���������ꍇ
        } catch (Exception e) {
            // TODO: handle exception

            e.printStackTrace();
            // ���������[���o�b�N����B
            dbm.rollbackTransaction();
            // �����𒆒f����B(�ُ�I��)
            throw e;

        }
    }

    /**
     * �u���_�E��������̌����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getNoteMaxCount() throws Exception {
        // �����_�E��������̌����擾
        // SQL�擾�֐��ւ̓n���p�����[�^(���R�[�h) sqlParam�𐶐�����B
        VRMap sqlParam = null;

        // sqlParam�ɉ��L�p�����[�^��ݒ肷��B
        sqlParam = new VRHashMap();
        // KEY : PATIENT_ID
        // KEY : NOTE_DATE
        sqlParam.setData("PATIENT_ID", String.valueOf(getPatientID()));
        Date result = ACDateUtilities.addMonth(getTargetDateSource(), 1);
        sqlParam.setData("NOTE_DATE", result);

        // �K��Ō�v�揑�E���_�E�����􃌃R�[�h�̌����擾�p��SQL�����擾����B
        // �擾����SQL���𔭍s����B
        VRList planNoteDataList = getDBManager().executeQuery(
                getSQL_GET_NOTE_COUNT(sqlParam));

        // �擾�������R�[�h�W���̂����A�ŏ��̃��R�[�h��KEY : NOTE_COUNT��VALUE���擾����B(���l�^)
        int planNoteData = Integer.parseInt(String.valueOf(VRBindPathParser
                .get("NOTE_COUNT", (VRMap) planNoteDataList.getData(0))));

        // �擾�������l���A�֐��̕ϐ��Ƃ��ĕԂ��B
        return planNoteData;

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
        } else {
            // null�ȊO�̏ꍇ
            // �������p������B
            // ��PROVIDER_ID�̒��o
            // �����œn���ꂽ���R�[�h����AKEY : PROVIDER_ID��VALUE���擾����B
            // �擾�ł����ꍇ
            // �������p������B
            if (!VRBindPathParser.has("PROVIDER_ID", rec)) {
                // �擾�ł��Ȃ������ꍇ
                // �󔒂�Ԃ��B(�����I��)
                return "";
            }
            // �����Ə��̃T�[�r�X���̎擾
            // ���Ə��̃T�[�r�X�ڍ׏����擾����B
            StringBuffer sb = new StringBuffer();
            sb.append(" SYSTEM_SERVICE_KIND_DETAIL IN (11311,20101)");
            sb.append(" AND PROVIDER_ID = ");
            sb.append(String.valueOf("'"+ VRBindPathParser.get("PROVIDER_ID",rec) + "'"));
            
            VRList providerServiceList = QkanCommon.getProviderServiceDetailCustom(
                    getDBManager(),sb.toString());
            // getProviderServiceDetail((�擾�������Ə�ID));
            if (providerServiceList.size() <= 0) {
                // �擾������0���̏ꍇ
                // �󔒂�Ԃ��B(�����I��)
                return "";

            } else {
                // �擾������0����葽���ꍇ
                // �������p������B
                // ���Ǘ��Ҏ����̒��o
                // �擾�������R�[�h�W���́A�ŏ��̃��R�[�h�� KEY : 1130103��VALUE���擾����B
                VRMap administratorMap = (VRMap) providerServiceList.getData(0);

                if (VRBindPathParser.get("1130103", administratorMap) == null) {
                    return "";
                } else {
                    // �擾�����l��߂�l�Ƃ��ĕԂ��B(�����I��)
                    return String.valueOf(VRBindPathParser.get("1130103",
                            administratorMap));
                }
            }
        }
    }

    /**
     * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean checkValidInput() throws Exception {
        // �����̓`�F�b�N
        // ���쐬�N�����E�����̓`�F�b�N
        // ��ʂ́u�쐬�N����(createDate)�v�̒l���`�F�b�N����B
        if (ACTextUtilities.isNullText(getCreateDate().getText())) {
            // ���͂���Ă���ꍇ
            // �������p������B
            // �����͂̏ꍇ
            // �G���[���b�Z�[�W��\������B
            QkanMessageList.getInstance()
                    .ERROR_OF_NEED_CHECK_FOR_INPUT("�쐬�N����");

            // QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(sqlParam);
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
            // �G���[���b�Z�[�W��\������B
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

}
