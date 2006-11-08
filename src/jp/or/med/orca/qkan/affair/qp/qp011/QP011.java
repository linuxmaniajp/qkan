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
 * �J����: �c���@����
 * �쐬��: 2006/08/19  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �K��Ō�×{��̎����ꗗ (011)
 * �v���O���� �K��Ō�×{��̎����ꗗ (QP011)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp011;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qp.qp012.QP012;

/**
 * �K��Ō�×{��̎����ꗗ(QP011)
 */
public class QP011 extends QP011Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP011() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    public boolean canBack(VRMap parameters) throws Exception {
        // �J�ڃp�����^�Ɉȉ���ݒ肷��B
        // KEY : TARGET_DATE, VALUE : �����N��(billDate)
        VRBindPathParser.set("TARGET_DATE", parameters, getBillDate());
        // KEY : PATIENT_ID, VALUE : ���p��ID(patientID)
        VRBindPathParser.set("PATIENT_ID", parameters, ACCastUtilities
                .toInteger(getPatientID()));
        // �O��ʑJ�ڂ�������B
        return true;
    }

    /**
     * �������������s�Ȃ��܂��B
     * 
     * @param affair �Ɩ����
     * @throws Exception ������O
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        // ���������s���B
        // ���E�B���h�E�^�C�g���E�Ɩ��{�^���o�[�̐ݒ�
        // �Ɩ��̃E�B���h�E�^�C�g���E�{�^���o�[�Ƀ^�C�g����ݒ肷��B
        setAffairTitle("QP011", getButtons());
        // ���p�b�V�u�L�[(BILL_PASSIVE_CHECK_KEY)���`����B
        // �e�[�u���FCLAIM_PATIENT_MEDICAL
        // �L�[�FCLAIM_PATIENT_MEDICAL_ID
        // �t�H�[�}�b�g�F�Ȃ�
        // �N���C�A���g�^�C���t�B�[���h�FLAST_TIME
        // �T�[�o�[�^�C���t�B�[���h�FLAST_TIME
        setBILL_PASSIVE_CHECK_KEY(new ACPassiveKey("CLAIM_PATIENT_MEDICAL",
                new String[] { "CLAIM_PATIENT_MEDICAL_ID" }, "LAST_TIME",
                "LAST_TIME"));
        // ���e�[�u�����f�����`����B
        ACTableModelAdapter model = new ACTableModelAdapter();
        model.setColumns(new String[] { "BILL_PRINTED", "BILL_SPAN_START",
                "BILL_SPAN_END", "BILL_PRINT_DATE", "BILL_FULL_TOTAL",
                "MEDICAL_INSURER_NO", "BILL_INSURE_TYPE", });
        setBillTableModel(model);
        getBills().setModel(getBillTableModel());
        // ���ݒ���̏�����
        // �����p�ҏ��̐ݒ�
        // �J�ڃp�����^����L�[�uPATIENT_ID�v�ŗ��p��ID�𔲂��o���A�����ϐ�(patientID)�ɑޔ�����B
        setPatientID(ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID",
                affair.getParameters()), 0));
        // �����ϐ�(patientID)���g�p���ė��p�ҏ�����������B
        VRList patients = QkanCommon.getPatientInfo(getDBManager(),
                getPatientID());
        if (patients.isEmpty()) {
            // �������ʂ�0���̏ꍇ
            // �s���ȃp�����^�������͍폜���ꂽ���Ƃ݂Ȃ��A���b�Z�[�W��\������B�����b�Z�[�WID = NOT_FOUND
            QkanMessageList.getInstance().NOT_FOUND("���p��");
            // �O��ʂɖ߂菈���𒆒f����B
            ACFrame.getInstance().back();
            return;
        }

        // �ݒ�W�J�p�̓����ϐ����R�[�hinfo���`�E��������B
        VRMap info = new VRHashMap();
        VRMap patient = (VRMap) patients.getData();
        // ���R�[�hinfo�ɃL�[�uPATIENT_CODE�v�Ō������ʂ̗��p�҃R�[�h��ݒ肷��B
        VRBindPathParser.set("PATIENT_CODE", info, VRBindPathParser.get(
                "PATIENT_CODE", patient));
        // ���R�[�hinfo�ɃL�[�uPATIENT_NAME�v�Ō������ʂ̗��p�Ҏ�����ݒ肷��B
        VRBindPathParser.set("PATIENT_NAME", info, QkanCommon.toFullName(
                VRBindPathParser.get("PATIENT_FAMILY_NAME", patient),
                VRBindPathParser.get("PATIENT_FIRST_NAME", patient)));
        // ���Ώ۔N���̐ݒ�
        Object obj = VRBindPathParser
                .get("TARGET_DATE", affair.getParameters());
        if (obj instanceof Date) {
            // �J�ڃp�����^�Ƃ��đΏ۔N���uTARGET_DATE�v���n����Ă���ꍇ
            // �����N��(billDate)�ɁA�J�ڃp�����^�̒l�uTARGET_DATE�v��ݒ肷��B
            setBillDate((Date) obj);
        } else {
            // �J�ڃp�����^�Ƃ��đΏ۔N�����n����Ă��Ȃ��ꍇ
            // �V�X�e������A�u�V�X�e�����t�v���擾����B
            // �����N��(billDate)�ɁA�擾�����V�X�e�����t��ݒ肷��B
            setBillDate(QkanSystemInformation.getInstance().getSystemDate());
        }
        // ���R�[�hinfo�ɃL�[�uTARGET_DATE�v�Ő����N��(billDate)��ݒ肷��B
        VRBindPathParser.set("TARGET_DATE", info, getBillDate());
        // ���R�[�hinfo�ɃL�[�uBILL_DATE�v�Ő����N��(billDate)��ݒ肷��B
        VRBindPathParser.set("BILL_DATE", info, getBillDate());
        // �����N��(billDate)�̖������擾���A���R�[�hinfo�ɃL�[�uBILL_SPAN_END_DAY�v�Őݒ肷��B
        int lastDate = ACDateUtilities.getDayOfMonth(ACDateUtilities
                .toLastDayOfMonth(getBillDate()));
        VRBindPathParser.set("BILL_SPAN_END_DAY", info, ACCastUtilities
                .toInteger(lastDate));
        // �����͉\�Ȑ������̐ݒ�
        // �����̓��ɂ��ɉ����Ĉȉ���4��ނ̐��K�\�����\�z���A�������ԊJ�n��(billSpanStartDay)��
        // �������ԏI����(billSpanEndDay)�̓��͋�������Ƃ��Đݒ肷��B
        VRCharType charType;
        switch (lastDate) {
        case 28:
            // ������28�̏ꍇ�F^([1-9]|(1[0-9])|(2[0-8]))$
            charType = new VRCharType("LAST_DAY", "^([1-9]|(1[0-9])|(2[0-8]))$");
            break;
        case 29:
            // ������29�̏ꍇ�F^([1-9]|([1-2][0-9]))$
            charType = new VRCharType("LAST_DAY", "^([1-9]|([1-2][0-9]))$");
            break;
        case 30:
            // ������30�̏ꍇ�F^(([1-9])|([1-2][0-9])|(30))$
            charType = new VRCharType("LAST_DAY",
                    "^(([1-9])|([1-2][0-9])|(30))$");
            break;
        default:
            // ������31�̏ꍇ�F^(([1-9])|([1-2][0-9])|(3[0-1]))$
            charType = new VRCharType("LAST_DAY",
                    "^(([1-9])|([1-2][0-9])|(3[0-1]))$");
            break;
        }
        getBillSpanStartDay().setCharType(charType);
        getBillSpanEndDay().setCharType(charType);
        // ���R�[�hinfo���N���C�A���g�̈�(contents)�ɐݒ�E�W�J����B
        getContents().setSource(info);
        getContents().bindSource();

        // ���Č����̓W�J
        // �J�ڃp�����^�ɃL�[�uREPRODUCTION_PARAM�v���܂܂�A�����̒l�����R�[�h�̏ꍇ
        Object reproductionParam = VRBindPathParser.get("REPRODUCTION_PARAM",
                affair.getParameters());
        if (reproductionParam instanceof VRMap) {
            // �J�ڃp�����^�̃L�[�uREPRODUCTION_MODE�v���n����Ă���ꍇ�A���̒l�ŏ����𕪊򂷂�B
            switch (ACCastUtilities.toInt(VRBindPathParser.get(
                    "REPRODUCTION_MODE", affair.getParameters()), 0)) {
            case QkanConstants.PROCESS_MODE_UPDATE:
                // �l���X�V���[�h�̒萔�̏ꍇ
                // �J�ڃp�����^�̃L�[�uREPRODUCTION_PARAM�v�̒l���쐬����(createConditions)�Ɋ��蓖�āE�W�J����B
                getCreateConditions().setSource((VRMap) reproductionParam);
                getCreateConditions().bindSource();
                // �J�ڃp�����^�̃L�[�uREPRODUCTION_PARAM�v�̒l����������(findConditions)�Ɋ��蓖�āE�W�J����B
                getFindConditions().setSource((VRMap) reproductionParam);
                getFindConditions().bindSource();
                break;
            case QkanConstants.PROCESS_MODE_INSERT:
                // �l���o�^���[�h�̒萔�̏ꍇ
                // �J�ڃp�����^�̃L�[�uREPRODUCTION_PARAM�v�̒l���쐬����(createConditions)�Ɋ��蓖�āE�W�J����B
                getCreateConditions().setSource((VRMap) reproductionParam);
                getCreateConditions().bindSource();
                if (!VRBindPathParser.has("CLAIM_PATIENT_MEDICAL_ID", affair
                        .getParameters())) {
                    // �J�ڃp�����^�Ƃ��ė̎���ID���n����Ă��Ȃ��ꍇ
                    // �J�ڃp�����^�̃L�[�uREPRODUCTION_PARAM�v�̒l����������(findConditions)�Ɋ��蓖�āE�W�J����B
                    getFindConditions().setSource((VRMap) reproductionParam);
                    getFindConditions().bindSource();
                    //�J�ڃp�����^�ɃL�[�uCLAIM_PATIENT_MEDICAL_ID�v�őJ�ڃp�����^�̃L�[�uREPRODUCTION_PARAM�v�̒l����
                    //�L�[�uCLAIM_PATIENT_MEDICAL_ID�v�Ŏ擾�����l��ݒ肷��B
                    VRBindPathParser.set("CLAIM_PATIENT_MEDICAL_ID", affair
                            .getParameters(), VRBindPathParser.get(
                            "CLAIM_PATIENT_MEDICAL_ID",
                            (VRMap) reproductionParam));
                }
                break;
            }
            // �J�ڃp�����^����L�[�uREPRODUCTION_MODE�v�ƁuREPRODUCTION_PARAM�v���폜����B
            affair.getParameters().remove("REPRODUCTION_MODE");
            affair.getParameters().remove("REPRODUCTION_PARAM");
        }

        // �������s���B
        doFind();

        // �J�ڃp�����^�Ƃ��ė̎���ID���n����Ă���ꍇ
        // �̎���ID�ɊY������̎�����I������B
        int backID = ACBindUtilities.getMatchIndexFromValue(getBillData(),
                "CLAIM_PATIENT_MEDICAL_ID", VRBindPathParser.get(
                        "CLAIM_PATIENT_MEDICAL_ID", affair.getParameters()));
        if (backID >= 0) {
            getBills().setSelectedModelRow(backID);
            getBills().scrollSelectedToVisible();
        }
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void findActionPerformed(ActionEvent e) throws Exception {
        // �������s���B
        doFind();

    }

    /**
     * �u�ڍ׉�ʂɑJ�ځv�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void detailActionPerformed(ActionEvent e) throws Exception {
        // ���I�����ꂽ�̎����̏��ŁA����ʂɑJ��
        // ����ʂɑJ�ڂ���B
        doNext();

    }

    /**
     * �u�V�K�쐬�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // �V�K�ɗ̎������쐬����B
        // �����̓`�F�b�N
        if (ACTextUtilities.isNullText(getBillSpanStartDay())) {
            // �������ԊJ�n��(billSpanStartDay)�������͂̏ꍇ
            // ���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("��������");
            // �������ԊJ�n��(billSpanStartDay)�Ƀt�H�[�J�X�����Ă�B
            getBillSpanStartDay().requestFocus();
            // �����𒆒f����B
            return;
        }
        if (ACTextUtilities.isNullText(getBillSpanEndDay())) {
            // �������ԏI����(billSpanEndDay)�������͂̏ꍇ
            // ���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("��������");
            // �������ԏI����(billSpanEndDay)�Ƀt�H�[�J�X�����Ă�B
            getBillSpanEndDay().requestFocus();
            // �����𒆒f����B
            return;
        }

        // �������Ԃ̍\�z
        // �����J�n�N����������킷�����ϐ�billBegin���`�E��������B
        // �����N��(billDate)�Ɛ������ԊJ�n��(billSpanStartDay)���琿���J�n�N����(billBegin)��ݒ肷��B
        Date billBegin = ACDateUtilities.setDayOfMonth((Date) getBillDate()
                .clone(), ACCastUtilities.toInt(
                getBillSpanStartDay().getText(), 1));
        // �����I���N����������킷�����ϐ�billEnd���`�E��������B
        // �����N��(billDate)�Ɛ������ԏI����(billSpanEndDay)���琿���I���N����(billEnd)��ݒ肷��B
        Date billEnd = ACDateUtilities.setDayOfMonth((Date) getBillDate()
                .clone(), ACCastUtilities.toInt(getBillSpanEndDay().getText(),
                1));
        if (ACDateUtilities.compareOnDay(billBegin, billEnd) > 0) {
            // �������ԊJ�n��(billSpanStartDay)�����������ԏI����(billSpanEndDay)���傫���ꍇ
            // ���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_GREATER_DATE_RELATION
            QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION(
                    "�������Ԃ�", "�J�n", "�I��");
            // �������ԊJ�n��(billSpanStartDay)�Ƀt�H�[�J�X�����Ă�B
            getBillSpanStartDay().requestFocus();
            // �����𒆒f����B
            return;
        }
        if (getCopyCreate().isSelected() && (!getBills().isSelected())) {
            // ������(copyCreate)�Ƀ`�F�b�N���t���Ă��āA���̎����ꗗ���I������Ă��Ȃ��ꍇ
            // ���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_SELECT
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
                    "�ߋ��ɍ쐬�����̎����𕡐�����ꍇ��" + ACConstants.LINE_SEPARATOR
                            + "�������̗̎���");
            // ������(copyCreate)�Ƀt�H�[�J�X�����Ă�B
            getCopyCreate().requestFocus();
            // �����𒆒f����B
            return;
        }

        // �������ԂɗL���ȕی����̎擾
        // �ȉ��̃p�����^�������ɐ������ԂɗL���ȕی������擾����B
        // �E���p��ID(patientID)
        // �E�����J�n�N����(billBegin)
        // �E�����I���N����(billEnd)
        VRList insures = QkanCommon.getMedicalInsureInfo(getDBManager(),
                getPatientID(), billBegin, billEnd);
        if (insures.isEmpty()) {
            // �L���ȕی���񂪑��݂��Ȃ��ꍇ
            // ���b�Z�[�W��\������B�����b�Z�[�WID = QP011_ERROR_OF_INVALID_INSURE_SPAN
            if (QkanMessageList.getInstance()
                    .QP011_WARNING_OF_INVALID_INSURE_SPAN() != ACMessageBox.RESULT_OK) {
                // OK�ȊO�����������ꍇ
                // �����𒆒f����B
                return;
            }
        }else if (insures.size() > 1) {
            // 2�̕ی������܂����鐿�����Ԃ��ݒ肳��Ă���ꍇ
            // ���b�Z�[�W��\������B�����b�Z�[�WID = QP011_ERROR_OF_MULTIPLE_INSURE_SPAN
            QkanMessageList.getInstance().QP011_ERROR_OF_MULTIPLE_INSURE_SPAN();
            // �����𒆒f����B
            return;
        }

        // ���Č����̑ޔ�
        // �����W�p�Ƀ��R�[�h info�𐶐�����B
        VRMap info = new VRHashMap();
        // �쐬����(createConditions)�Ƀ��R�[�hinfo�����蓖�āE���W����B
        getCreateConditions().setSource(info);
        getCreateConditions().applySource();
        // ���R�[�hinfo�Ɍ����ݒ�(findedParam)��ǉ�����B
        info.putAll(getFindedParam());
        // ���Ɩ��ւ̑J�ڃp�����^�ɃL�[�uREPRODUCTION_MODE�v�œo�^���[�h�̒萔��ǉ�����B
        ACFrame.getInstance().addNowAffairParameter("REPRODUCTION_MODE",
                ACCastUtilities.toInteger(QkanConstants.PROCESS_MODE_INSERT));
        // ���Ɩ��ւ̑J�ڃp�����^�ɃL�[�uREPRODUCTION_PARAM�v�Ń��R�[�hinfo��ǉ�����B
        ACFrame.getInstance().addNowAffairParameter("REPRODUCTION_PARAM", info);

        // ���J�ڃp�����^�̐ݒ�
        // ����ʂւ̓n��p�����[�^�i�[�p�Ƀ��R�[�h param�𐶐�����B
        VRMap param = new VRHashMap();
        if (getCopyCreate().isSelected()) {
            // ������(copyCreate)�Ƀ`�F�b�N���t���Ă���ꍇ
            // param�ɑI�������̎����̏���ǉ�����B
            VRMap row=(VRMap) getBills().getSelectedModelRowValue();
            param.putAll(row);
            //���R�[�hinfo�ɃL�[�uCLAIM_PATIENT_MEDICAL_ID�v�őI�������̎����̃L�[�uCLAIM_PATIENT_MEDICAL_ID�v�̒l��ݒ肷��B
            VRBindPathParser.set("CLAIM_PATIENT_MEDICAL_ID", info, VRBindPathParser.get("CLAIM_PATIENT_MEDICAL_ID", row));
        }
        // param�ɉ��L�p�����[�^��ݒ肷��B
        // KEY : PATIENT_ID, VALUE : ���p��ID(patientID)
        VRBindPathParser.set("PATIENT_ID", param, ACCastUtilities
                .toInteger(getPatientID()));
        // KEY : BILL_SPAN_START, VALUE : �����J�n�N����(billBegin)
        VRBindPathParser.set("BILL_SPAN_START", param, billBegin);
        // KEY : BILL_SPAN_END, VALUE : �����I���N����(billEnd)
        VRBindPathParser.set("BILL_SPAN_END", param, billEnd);
        // ���L�p�����[�^�ɂċƖ����𐶐�����B
        // className : QP012.class.getName(), parameters : param
        // ���J�ڃp�����^���g�p���Ď���ʂɑJ��
        ACFrame.getInstance().next(
                new ACAffairInfo(QP012.class.getName(), param));

    }

    /**
     * �u�폜�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void deleteActionPerformed(ActionEvent e) throws Exception {
        // �I�������̎������폜����B
        // �����̓`�F�b�N
        if (!getBills().isSelected()) {
            // �̎����ꗗ���I������Ă��Ȃ��ꍇ
            // ���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_SELECT
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
                    "�폜����̎���");
            // �����𒆒f����B
            return;
        }
        // �폜�m�F�̃��b�Z�[�W��\������B
        if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() != ACMessageBox.RESULT_OK) {
            // OK�ȊO���I�����ꂽ�ꍇ
            // �����𒆒f����B
            return;
        }
        try {
            getDBManager().beginTransaction();
            // �p�b�V�u�^�X�N��o�^����B
            getPassiveChecker().clearPassiveTask();
            getPassiveChecker().addPassiveDeleteTask(
                    getBILL_PASSIVE_CHECK_KEY(),
                    getBills().getSelectedModelRow());
            // �p�b�V�u�`�F�b�N���s���B
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                // �p�b�V�u�G���[�����������ꍇ
                // �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // �����𒆒f����B
                return;
            }
            // �p�b�V�u�G���[���������Ȃ������ꍇ
            // �I�������̎������폜����B
            getDBManager().executeUpdate(
                    getSQL_DELETE_BILL((VRMap) getBills()
                            .getSelectedModelRowValue()));
            getDBManager().commitTransaction();
        } catch (SQLException ex) {
            // SQL�����s���ɃG���[�����������ꍇ
            // ���������[���o�b�N����B
            getDBManager().rollbackTransaction();
            // ��O�G���[�𓊂������𒆒f����B
            throw ex;
        }
        // �����Ɏg�p�����Ώ۔N��(findTargetDate)�ŗ̎����ꗗ���Ď擾����B
        int selectRow = getBills().getSelectedRow();
        if (getFindTargetDate() != null) {
            String oldText = getTargetDate().getText();
            getTargetDate().setDate(getFindTargetDate());
            doFind();
            getTargetDate().setText(oldText);
        }
        // �폜�����̎����̈��̗̎�����I������B
        getBills().setSelectedSortedRowOnAfterDelete(selectRow);
    }

    /**
     * �u��ʐ���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void billsSelectionChanged(ListSelectionEvent e) throws Exception {
        // ����ʂ̐���
        if (!getBills().isSelected()) {
            // �ꗗ���I������Ă��Ȃ��ꍇ
            // �Ɩ��{�^���̏�Ԃ�INVALID_DETAIL�ɕύX����B
            setState_INVALID_DETAIL();
        } else {
            // �ꗗ���I������Ă���ꍇ
            // �Ɩ��{�^���̏�Ԃ�VALID_DETAIL�ɕύX����B
            setState_VALID_DETAIL();
        }
    }

    /**
     * �u��ʑJ�ڏ����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void billsMouseClicked(MouseEvent e) throws Exception {
        // ���I�����ꂽ�̎����̏��ŁA����ʂɑJ��
        // ����ʂɑJ�ڂ���B
        doNext();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QP011.class.getName(), param));
    }

    // �����֐�

    /**
     * �u�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doFind() throws Exception {
        // ��DB���痘�p�҈ꗗ���擾�A��ʂɐݒ�
        // �����̓`�F�b�N
        // ��ʂ́u�Ώ۔N��(targetDate)�v�ɒl�����͂���Ă��邩�ǂ����`�F�b�N����B
        if (ACTextUtilities.isNullText(getTargetDate().getText())) {
            // ���͂���Ă��Ȃ��ꍇ
            // ���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("�Ώ۔N��");
            // �Ώ۔N��(targetDate)�Ƀt�H�[�J�X�����Ă�B
            getTargetDate().requestFocus();
            // �����𒆒f����B
            return;
        }
        // ��ʂ́u�Ώ۔N��(targetDate)�v�ɗL���Ȓl�����͂���Ă��邩�ǂ����`�F�b�N����B
        if (!getTargetDate().isValidDate()) {
            // �L���Ȓl�����͂���Ă��Ȃ��ꍇ
            // ���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_WRONG_DATE
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�Ώ۔N����");
            //�Ώ۔N��(targetDate)�Ƀt�H�[�J�X�����Ă�B
            getTargetDate().requestFocus();
            // �����𒆒f����B
            return;
        }
        
        // ����������
        // SQL���擾�֐��ɓn�����R�[�h sqlParam�𐶐�����B
        VRMap sqlParam = new VRHashMap();
        Date date = getTargetDate().getDate();
        // ���p��ID(patientID)��sqlParam�� KEY : PATIENT_ID �� VALUE �Ƃ��Đݒ肷��B
        VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities
                .toInteger(getPatientID()));
        // ���O�C�����ƎҔԍ���sqlParam�� KEY : PROVIDER__ID �� VALUE �Ƃ��Đݒ肷��B
        VRBindPathParser.set("PROVIDER_ID", sqlParam, QkanSystemInformation
                .getInstance().getLoginProviderID());
        // �Ώ۔N��(targetDate)�̏�����sqlParam�� KEY : BILL_SPAN_START �� VALUE �Ƃ��Đݒ肷��B
        VRBindPathParser.set("BILL_SPAN_START", sqlParam, ACDateUtilities
                .toFirstDayOfMonth(date));
        // �Ώ۔N��(targetDate)�̖�����sqlParam�� KEY : BILL_SPAN_END �� VALUE �Ƃ��Đݒ肷��B
        VRBindPathParser.set("BILL_SPAN_END", sqlParam, ACDateUtilities
                .toLastDayOfMonth(date));
        // ��DB����f�[�^���擾
        // �̎��������p��SQL���𔭍s���A���ʂ�billData�Ɋi�[����B
        setBillData(getDBManager().executeQuery(getSQL_SELECT_BILL(sqlParam)));

        // ���Č����̑ޔ�
        // ���o�����̈�(findCondition)�Ɍ����ݒ�(findedParam)�����蓖�āE���W����B
        getFindConditions().setSource(getFindedParam());
        getFindConditions().applySource();

        // �������̑Ώ۔N����ޔ�����B
        setFindTargetDate(date);
        // �������ʂ��p�b�V�u�f�[�^�Ƃ��đޔ�����B
        getPassiveChecker().reservedPassive(getBILL_PASSIVE_CHECK_KEY(),
                getBillData());
        // ���擾�����f�[�^����ʂɓW�J
        getBillTableModel().setAdaptee(getBillData());
        // ��ʂ́u���p�҈ꗗ(patients)�v��1�s�ڂ�I������B
        getBills().setSelectedSortedFirstRow();
        if (getBillData().isEmpty()) {
            // billData�̌�����0���̏ꍇ
            // �Ɩ��{�^���̏�Ԃ�INVALID_DETAIL�ɕύX����B
            setState_INVALID_DETAIL();
        }
        // ���������ʂ̗̎��z���v�����ׂč��Z���A�����̎��z���v�����߂�B
        long total = 0;
        Iterator it = getBillData().iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            total += ACCastUtilities.toInt(VRBindPathParser.get(
                    "BILL_FULL_TOTAL", row), 0);
        }
        // �X�e�[�^�X�o�[�Ɂu���Ώ۔N�����̗̎��z���v�́������̎��z���v���~�ł��B�v�Ɛݒ肷��B
        setStatusText(ACConstants.FORMAT_FULL_ERA_YM.format(date) + " �̗̎��z���v�� "
                + NumberFormat.getIntegerInstance().format(total) + "�~�ł��B");
    }

    /**
     * �u��ʑJ�ڏ����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doNext() throws Exception {
        // ���I�����ꂽ�̎����̏��ŁA����ʂɑJ��
        // �����̓`�F�b�N
        // ��ʂ́u�̎����ꗗ(bills)�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
        if (!getBills().isSelected()) {
            // �I������Ă��Ȃ��ꍇ
            // �����𒆒f����B
            return;
        }

        // ���Č����̑ޔ�
        // �����W�p�Ƀ��R�[�h info�𐶐�����B
        VRMap info = new VRHashMap();
        // �쐬����(createConditions)�Ƀ��R�[�hinfo�����蓖�āE���W����B
        getCreateConditions().setSource(info);
        getCreateConditions().applySource();
        // ���R�[�hinfo�Ɍ����ݒ�(findedParam)��ǉ�����B
        info.putAll(getFindedParam());
        // ���Ɩ��ւ̑J�ڃp�����^�ɃL�[�uREPRODUCTION_MODE�v�ōX�V���[�h�̒萔��ǉ�����B
        ACFrame.getInstance().addNowAffairParameter("REPRODUCTION_MODE",
                ACCastUtilities.toInteger(QkanConstants.PROCESS_MODE_UPDATE));
        // ���Ɩ��ւ̑J�ڃp�����^�ɃL�[�uREPRODUCTION_PARAM�v�Ń��R�[�hinfo��ǉ�����B
        ACFrame.getInstance().addNowAffairParameter("REPRODUCTION_PARAM", info);

        // ���J�ڃp�����^�̐ݒ�
        // ����ʂւ̑J�ڃp�����^�i�[�p�Ƀ��R�[�h param�𐶐�����B
        VRMap param = new VRHashMap();
        // param�ɑI�������̎����̏���ǉ�����B
        param.putAll((VRMap) getBills().getSelectedModelRowValue());
        // ���L�p�����[�^�ɂċƖ����𐶐�����B
        // className : QP012.class.getName(), parameters : param
        // ���J�ڃp�����^���g�p���Ď���ʂɑJ��
        ACFrame.getInstance().next(
                new ACAffairInfo(QP012.class.getName(), param));

    }

}
