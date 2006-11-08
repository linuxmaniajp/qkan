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
 * �쐬��: 2006/08/12  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X ���p�҈ꗗ(�K��Ō�×{��̎���) (010)
 * �v���O���� ���p�҈ꗗ(�K��Ō�×{��̎���) (QP010)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp010;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Map;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qp.qp011.QP011;
import jp.or.med.orca.qkan.text.QkanInsurerIDToInsurerNameFormat;

/**
 * ���p�҈ꗗ(�K��Ō�×{��̎���)(QP010)
 */
public class QP010 extends QP010Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP010() {
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
        // ���������s���B
        // ���E�B���h�E�^�C�g���E�Ɩ��{�^���o�[�̐ݒ�
        // �Ɩ��̃E�B���h�E�^�C�g���E�{�^���o�[�Ƀ^�C�g����ݒ肷��B
        setAffairTitle("QP010", getButtons());

        // �����O�C�����Ə������擾���A��ʏ�̒��߂ɂ͂ߍ��ށB
        VRList loginProviderInfo = QkanCommon.getProviderInfo(getDBManager(),
                QkanSystemInformation.getInstance().getLoginProviderID());
        if ((loginProviderInfo == null) || (loginProviderInfo.isEmpty())) {
            QkanMessageList.getInstance().QP001_ERROR_OF_NO_LOGIN_PROVIDER();
            ACFrame.getInstance().back();
            return;
        } else {
            Map map = (Map) loginProviderInfo.getData();
            getLoginProviderInfo()
                    .setText(
                            "�u"
                                    + map.get("PROVIDER_NAME")
                                    + "�v�Ɋւ���̎����쐬�������s�Ȃ��܂��B���̎��Ə���ΏۂƂ���ꍇ�́A���O�A�E�g���s�����Ə���I�����Ȃ����Ă��������B");
        }

        // ���e�[�u�����f�����`����B
        ACTableModelAdapter model = new ACTableModelAdapter();

        model.setColumns(new String[] { "INSURER_ID", "INSURER_NAME",
                "PATIENT_CODE", "MEDICAL_INSURE_ID",
                "PATIENT_FAMILY_NAME+'�@'+PATIENT_FIRST_NAME",
                "PATIENT_FAMILY_KANA+'�@'+PATIENT_FIRST_KANA", "PATIENT_SEX",
                "PATIENT_BIRTHDAY", "JOTAI_CODE", "INSURE_TYPE", });

        setPatientTableModel(model);

        // �A�_�v�^���e�[�u���̃��f���Ƃ��Đݒ肷��B
        getPatients().setModel(getPatientTableModel());

        // ����Ìn�̕ی��҈ꗗ���擾
        setInsurers(QkanCommon.getInsurerInfoMedicalOnly(getDBManager()));
        getInsurerName().setModel(getInsurers());

        // �ی��Җ��J�����ɕی��Җ��t�H�[�}�b�g��ݒ�
        getPatientInsurerNameColumn().setFormat(
                new QkanInsurerIDToInsurerNameFormat(getInsurers()));

        // ���u���їL�����ʁv�Ƀ`�F�b�N������B
        getOnlyExistsResult().setSelected(true);

        // ���Ώ۔N���̐ݒ�
        Date targetDate = ACCastUtilities.toDate(VRBindPathParser.get(
                "TARGET_DATE", affair.getParameters()), null);
        if (targetDate != null) {
            // �J�ڃp�����^�Ƃ��đΏ۔N�����n����Ă���ꍇ
            // ��ʂ́u�Ώ۔N��(targetDate)�v�ɁAtargetDate�̒l��ݒ肷��B
            getFindCondition().setSource(affair.getParameters());
            getFindCondition().bindSource();
            // getTargetDate().setDate(targetDate);
        } else {
            // �J�ڃp�����^�Ƃ��đΏ۔N�����n����Ă��Ȃ��ꍇ
            // �V�X�e������A�u�V�X�e�����t�v���擾����B
            // ��ʂ́u�Ώ۔N��(targetDate)�v�ɁA�擾�����V�X�e�����t��ݒ肷��B
            getTargetDate().setDate(
                    QkanSystemInformation.getInstance().getSystemDate());
        }

        // ���Č����̓W�J
        // �J�ڃp�����^�ɃL�[�uREPRODUCTION_PARAM�v���܂܂�A�����̒l�����R�[�h�̏ꍇ
        Object reproductionParam = VRBindPathParser.get("REPRODUCTION_PARAM",
                affair.getParameters());
        if (reproductionParam instanceof VRMap) {
            // �J�ڃp�����^�̃L�[�uREPRODUCTION_PARAM�v�̒l����������(findCondition)�Ɋ��蓖�āE�W�J����B
            getFindCondition().setSource((VRMap) reproductionParam);
            getFindCondition().bindSource();
            // �J�ڃp�����^����L�[�uREPRODUCTION_PARAM�v���폜����B
            affair.getParameters().remove("REPRODUCTION_PARAM");
        }

        // �������s���B
        doFind();

        //�J�ڃp�����^�Ƃ��ė��p��ID���n����Ă���ꍇ
        //���p��ID�ɊY�����闘�p�҂�I������B
        int backID=ACBindUtilities.getMatchIndexFromValue(getPatientData(), "PATIENT_ID",VRBindPathParser.get(
                "PATIENT_ID", affair.getParameters()));
        if(backID>=0){
            getPatients().setSelectedModelRow(backID);
            getPatients().scrollSelectedToVisible();
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
        // ���I�����ꂽ���p�҂̏��ŁA����ʂɑJ��
        // ����ʂɑJ�ڂ���B
        doNext();

    }

    /**
     * �u��ʐ���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void patientsSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ����ʂ̐���
        if (!getPatients().isSelected()) {
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
    protected void patientsMouseClicked(MouseEvent e) throws Exception {
        // ���I�����ꂽ���p�҂̏��ŁA����ʂɑJ��
        // ����ʂɑJ�ڂ���B
        doNext();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        QkanSystemInformation.getInstance().setLoginProviderID("2000000000");
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QP010.class.getName(), param));
    }

    // �����֐�

    /**
     * �u�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doFind() throws Exception {

        // �����̓`�F�b�N
        // ��ʂ́u�Ώ۔N��(targetDate)�v�ɒl�����͂���Ă��邩�ǂ����`�F�b�N����B
        if (ACTextUtilities.isNullText(getTargetDate().getText())) {
            // ���͂���Ă��Ȃ��ꍇ
            // ���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT
            QkanMessageList.getInstance()
                    .ERROR_OF_NEED_CHECK_FOR_INPUT("�Ώ۔N��");
            //�Ώ۔N��(targetDate)�Ƀt�H�[�J�X�����Ă�B
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
        
        //�X�v���b�V����\������B
        ACSplashable splash = ACFrame.getInstance().getFrameEventProcesser()
                .createSplash("��������");

        // ��DB���痘�p�҈ꗗ���擾�A��ʂɐݒ�
        // ����������
        // SQL���擾�֐��ɓn�����R�[�h sqlParam�𐶐�����B
        VRMap sqlParam = new VRHashMap();

        // �Ώ۔N����sqlParam�� KEY : TARGET_DATE �� VALUE �Ƃ��Đݒ肷��B
        VRBindPathParser
                .set("TARGET_DATE", sqlParam, getTargetDate().getDate());
        VRBindPathParser.set("TARGET_DATE_START_DAY", sqlParam, ACDateUtilities
                .toFirstDayOfMonth(getTargetDate().getDate()));
        VRBindPathParser.set("TARGET_DATE_END_DAY", sqlParam, ACDateUtilities
                .toLastDayOfMonth(getTargetDate().getDate()));
        VRBindPathParser.set("LOGIN_PROVIDER_ID", sqlParam,
                QkanSystemInformation.getInstance().getLoginProviderID());

        // �����p�҃R�[�h�̎擾
        // ��ʂ́u���p�҃R�[�h(patientCode)�v��Text���擾���A�����p�ɕҏW����B
        if (!ACTextUtilities.isNullText(getPatientCode())) {
            // �擾���������񂪑��݂���ꍇ(�����񒷂�0���傫���ꍇ)
            // �擾�����������sqlParam�� KEY : PATIENT_CODE �� VALUE �Ƃ��Đݒ肷��B
            VRBindPathParser.set("PATIENT_CODE", sqlParam, getPatientCode()
                    .getText());
        }
        // ���ӂ肪�Ȃ̎擾
        // ��ʂ́u�ӂ肪��(patientKana)�v��Text���擾���A�����p�ɕҏW����B
        if (!ACTextUtilities.isNullText(getPatientKana())) {
            // �擾���������񂪑��݂���ꍇ(�����񒷂�0���傫���ꍇ)
            // �擾�����������sqlParam�� KEY : PATIENT_KANA �� VALUE �Ƃ��Đݒ肷��B
            VRBindPathParser.set("PATIENT_KANA", sqlParam, getPatientKana()
                    .getText());
        }

        // ���u���т̂��闘�p�҂�����\���v�t���O�̎擾
        // ��ʂ́u���т̂��闘�p�҂�����\��(onlyExistsResult)�v�̑I����Ԃ��擾����B
        if (getOnlyExistsResult().isSelected()) {
            // �I������Ă���ꍇ
            // sqlParam�� KEY : ONLY_EXISTS_RESULT, VALUE : null ��ݒ肷��B
            VRBindPathParser.set("ONLY_EXISTS_RESULT", sqlParam, null);
        }
        // ���I���̏ꍇ
        // �������Ȃ�(sqlParam�ɂ͉����ݒ肵�Ȃ�)�B

        // ��DB����f�[�^���擾
        // �����p��SQL���𔭍s���A���ʂ�patientData�Ɋi�[����B
        setPatientData( getDBManager().executeQuery(
                getSQL_SELECT_PATIENT(sqlParam)));

        if (!ACTextUtilities.isNullText(getInsurerID())) {
            // �ی��Ҕԍ��ōi�荞�ޏꍇ
            String val = getInsurerID().getText();
            for (int i = getPatientData().size() - 1; i >= 0; i--) {
                // �ی��Ҕԍ��������v���Ȃ��������ʂ͏��O����B
                if (!ACCastUtilities.toString(
                        VRBindPathParser.get("INSURER_ID",
                                (VRMap) getPatientData().get(i))).endsWith(val)) {
                    getPatientData().remove(i);
                }
            }
        }
        if (!ACTextUtilities.isNullText(getPatientInsuredID())) {
            // �L���E�ԍ��ōi�荞�ޏꍇ
            String val = getPatientInsuredID().getText();
            for (int i = getPatientData().size() - 1; i >= 0; i--) {
                // �L���E�ԍ�����v���Ȃ��������ʂ͏��O����B
                if (!val.equals(ACCastUtilities.toString(VRBindPathParser.get(
                        "MEDICAL_INSURE_ID", (VRMap) getPatientData().get(i))))) {
                    getPatientData().remove(i);
                }
            }
        }

        // ���Č����̑ޔ�
        // ���o�����̈�(findCondition)�Ɍ����ݒ�(findedParam)�����蓖�āE���W����B
        getFindCondition().setSource(getFindedParam());
        getFindCondition().applySource();

        // �������̑Ώ۔N����ޔ�����B
        setFindTargetDate(getTargetDate().getDate());
        
        // ���擾�����f�[�^����ʂɓW�J
        getPatientTableModel().setAdaptee(getPatientData());

        // ��ʂ́u���p�҈ꗗ(patients)�v��1�s�ڂ�I������B
        getPatients().setSelectedSortedFirstRow();

        // patientData�̌������`�F�b�N����B
        if (getPatientData().isEmpty()) {
            // patientData�̌�����0���̏ꍇ
            // �Ɩ��{�^���̏�Ԃ�INVALID_DETAIL�ɕύX����B
            setState_INVALID_DETAIL();
        }

        //�X�e�[�^�X�o�[�ɒ��o������\������B���u�����v+" �����o����܂����B"
        setStatusText(getPatientData().size() + " �����o����܂����B");

        //�X�v���b�V���������B
        if(splash!=null){
            splash.close();
            splash = null;
            ACFrame.getInstance().repaint();
        }
    }

    /**
     * �u��ʑJ�ڏ����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doNext() throws Exception {
        // ���I�����ꂽ���p�҂̏��ŁA����ʂɑJ��
        // �����̓`�F�b�N
        // ��ʂ́u���p�҈ꗗ(patients)�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
        if (!getPatients().isSelected()) {
            // �I������Ă��Ȃ��ꍇ
            // �����𒆒f����B
            return;
        }

        // ���Č����̑ޔ�
        // ���Ɩ��ւ̑J�ڃp�����^�ɃL�[�uREPRODUCTION_PARAM�v�Ō����ݒ�(findedParam)��ǉ�����B
        ACFrame.getInstance().addNowAffairParameter("REPRODUCTION_PARAM", getFindedParam());
        
        
        // ���J�ڃp�����^�̐ݒ�
        // ����ʑJ�ڂ̂��߂̃p�����^ ACAffairInfo affair ���`����B
        // ����ʂւ̑J�ڃp�����^�i�[�p�Ƀ��R�[�h param�𐶐�����B
        VRMap param = new VRHashMap();
        // param�ɑI���������p�҂̏���ǉ�����B
        param.putAll((VRMap) getPatients().getSelectedModelRowValue());
        // param�ɉ��L�p�����[�^��ݒ肷��B
        // KEY : TARGET_DATE, VALUE : (�������_�̐����N��)
        VRBindPathParser.set("TARGET_DATE", param, getFindTargetDate());
        // ���L�p�����[�^�ɂ�affair�𐶐�����B
        // className : QP011.class.getName(), parameters : param
        // ���J�ڃp�����^���g�p���Ď���ʂɑJ��
        ACFrame.getInstance().next(
                new ACAffairInfo(QP011.class.getName(), param));
    }

    /**
     * �u�ی��Ҕԍ��ƕی��Җ��̘A���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void insurerNameActionPerformed(ActionEvent e) throws Exception {
        // �I�������ی��҂̕ی��Ҕԍ���ی��Ҕԍ��e�L�X�g�ɐݒ肷��B
        if (getInsurerName().getSelectedModelItem() instanceof VRMap) {
            Object val = VRBindPathParser.get("INSURER_ID",
                    (VRMap) getInsurerName().getSelectedModelItem());
            if (val != null) {
                getInsurerID().setText(ACCastUtilities.toString(val));
            }
        } else {
            getInsurerID().setText("");
        }
    }

}
