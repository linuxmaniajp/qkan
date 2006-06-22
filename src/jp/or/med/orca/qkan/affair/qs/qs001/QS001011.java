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
 * �J����: ���}�@�M�u
 * �쐬��: 2006/01/18  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[���Z������������� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z������������� (QS001011)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���Z�������������(QS001011)
 */
public class QS001011 extends QS001011Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001011() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayLifeTimeContenaFacilityDivisionActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getShortStayLifeTimeContenaFacilityDivision()
                .getSelectedIndex()) {
        case 1:
        case 2:
            // �u�P�ƌ^�v�������́u���݌^�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v��L���ɂ��A�u�a���敪(���j�b�g�^)�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            break;
        case 3:
        case 4:
            // �u�P�ƌ^���j�b�g�^�v�������́u���݌^���j�b�g�^�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v�𖳌��ɂ��A�u�a���敪(���j�b�g�^)�v��L���ɂ���B
            setState_UNIT_FORM();
        }

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001011.class.getName(), param));
    }

    // �����֐�

    /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // ����ʓW�J���̏����ݒ�
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���H����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1210111 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1210111", QkanCommon.getArrayFromMasterCode(191,
                "1210111"));
        // ���R���{�A�C�e���̐ݒ�
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();
        // ���I�����ڂ̏����ݒ�
        // �a���敪�i�ʏ�j(shortStayLifeHospitalRoomDivisionRadio)�́u�]���^���v��I������B
        getShortStayLifeHospitalRoomDivisionRadio().setSelectedIndex(1);
        // �a���敪�i���j�b�g�j(shortStayLifeUnitHospitalRoomDivisionRadio)�́u���j�b�g�^���v��I������B
        getShortStayLifeUnitHospitalRoomDivisionRadio().setSelectedIndex(1);

//        �@�\�P���̐����Z(shortStayLifeAdditionFunctionTrainingRadio)�́u�Ȃ��v��I������B
        getShortStayLifeAdditionFunctionTrainingRadio().setSelectedIndex(1);
//        �h�{�Ǘ��̐����Z(shortStayLifeDieticianManageRadio)�́u�Ȃ��v��I������B
        getShortStayLifeDieticianManageRadio().setSelectedIndex(1);
//        �×{�H���Z(shortStayLifeMedicalExpensesRadio)�́u�Ȃ��v��I������B
        getShortStayLifeMedicalExpensesRadio().setSelectedIndex(1);

        // �H����(shortStayLifeDinnerOffer)�́u�Ȃ��v��I������B
        getShortStayLifeDinnerOffer().setSelectedIndex(0);

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        //�I�����Ă��鎖�Ə����(selectedProvider)��ޔ�����B
        setSelectedProvider(provider);
        if (provider != null) {
            Object obj;
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // �{�݋敪
            obj = VRBindPathParser.get("1210101", provider);
            if (obj != null) {
                getShortStayLifeTimeContenaFacilityDivision().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // ��ԋΖ������
            obj = VRBindPathParser.get("1210102", provider);
            if (obj != null) {
                getNightWorkConditionRadio().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // �l�����Z
            obj = VRBindPathParser.get("1210107", provider);
            if (obj != null) {
                getShortStayLifeSubtraction().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // ���}
            obj = VRBindPathParser.get("1210104", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // ���}�敪(shortStayLifeMeetingAndSendingOff)��3�Ԗڂ̃{�^����I���ɂ���B
                    getShortStayLifeMeetingAndSendingOff().setSelectedIndex(3);
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // ���}�敪(shortStayLifeMeetingAndSendingOff)��1�Ԗڂ̃{�^����I���ɂ���B
                    getShortStayLifeMeetingAndSendingOff().setSelectedIndex(1);
                    break;
                }
            }
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // �@�\�P���ɑ΂���̐����Z
            obj = VRBindPathParser.get("1210103", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_FUNCTION_TRAINING();
                } else {
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_FUNCTION_TRAINING();
                }
            }

            // �h�{�Ǘ��̐�
            obj = VRBindPathParser.get("1210105", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_DIETICIAN_MANAGE();
                } else {
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_DIETICIAN_MANAGE();
                }
            }
            // �×{�H
            obj = VRBindPathParser.get("1210106", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_MEDICAL_EXPENSES();
                } else {
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_MEDICAL_EXPENSES();
                }
            }
        }

    }

    /**
     * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean isUseProvider() throws Exception {
        // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
        // true��Ԃ��B
        return true;
    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if (getShortStayLifeHospitalRoomDivisionRadio().isEnabled()
                && (!getShortStayLifeHospitalRoomDivisionRadio().isSelected())) {
            // �a���敪�i�ʏ�j(shortStayLifeHospitalRoomDivisionRadio)���L�������I���ȏꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if (getShortStayLifeUnitHospitalRoomDivisionRadio().isEnabled()
                && (!getShortStayLifeUnitHospitalRoomDivisionRadio()
                        .isSelected())) {
            // �a���敪�i���j�b�g�j(shortStayLifeUnitHospitalRoomDivisionRadio)���L�������I���ȏꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if (getShortStayLifeDinnerOffer().getSelectedIndex() > 0) {
            // �H���񋟁ishortStayLifeDinnerOffer)���u�Ȃ��v�ȊO��I�����Ă���ꍇ
            if (ACTextUtilities.isNullText(getShortStayLifeDinnerCost().getText())) {
                // �H����p(shortStayLifeDinnerCost)���󗓂̏ꍇ
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }

        // ���ԋp�p�̃��R�[�h(data)�𐶐�
        VRMap data = new VRHashMap();
        // ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
        getThis().setSource(data);
        // ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
        getThis().applySource();
        // ���ԋp�p���R�[�h����s�v�ȃL�[������
        if (!getShortStayLifeHospitalRoomDivisionRadio().isEnabled()) {
            // �a���敪�i�ʏ�j(shortStayLifeHospitalRoomDivisionRadio)�������̏ꍇ
            // �ԋp�p���R�[�h����A�a���敪�i�ʏ�j(shortStayLifeHospitalRoomDivisionRadio)��bindPath����������B
            data.remove(getShortStayLifeHospitalRoomDivisionRadio()
                    .getBindPath());
        }
        if (!getShortStayLifeUnitHospitalRoomDivisionRadio().isEnabled()) {
            // �a���敪�i���j�b�g�j(shortStayLifeUnitHospitalRoomDivisionRadio)�������̏ꍇ
            // �ԋp�p���R�[�h����A�a���敪�i���j�b�g�j(shortStayLifeUnitHospitalRoomDivisionRadio)��bindPath����������B
            data.remove(getShortStayLifeUnitHospitalRoomDivisionRadio()
                    .getBindPath());
        }
        if (!getShortStayLifeAdditionFunctionTrainingRadio().isEnabled()) {
            // �@�\�P���̐����Z(shortStayLifeAdditionFunctionTrainingRadio)�������̏ꍇ
            // �ԋp�p���R�[�h����A�@�\�P���̐����Z(shortStayLifeAdditionFunctionTrainingRadio)��bindPath����������B
            data.remove(getShortStayLifeAdditionFunctionTrainingRadio()
                    .getBindPath());
        }
        if (!getShortStayLifeMeetingAndSendingOff().isEnabled()) {
            // ���}�敪(shortStayLifeMeetingAndSendingOff)�������̏ꍇ
            // �ԋp�p���R�[�h����A���}�敪(shortStayLifeMeetingAndSendingOff)��bindPath����������B
            data.remove(getShortStayLifeMeetingAndSendingOff().getBindPath());
        }
        if (!getShortStayLifeDieticianManageRadio().isEnabled()) {
            // �h�{�Ǘ��̐����Z(shortStayLifeDieticianManageRadio)�������̏ꍇ
            // �ԋp�p���R�[�h����A�h�{�Ǘ��̐����Z(shortStayLifeDieticianManageRadio)��bindPath����������B
            data.remove(getShortStayLifeDieticianManageRadio().getBindPath());
        }

        if (!getShortStayLifeMedicalExpensesRadio().isEnabled()) {
            // �×{�H���Z(shortStayLifeMedicalExpensesRadio)�������̏ꍇ
            // �ԋp�p���R�[�h����A�×{�H���Z(shortStayLifeMedicalExpensesRadio)��bindPath����������B
            data.remove(getShortStayLifeMedicalExpensesRadio().getBindPath());
        }
        if (!getShortStayLifeMedicalExpensesRadio().isEnabled()){
            // �H����p(shortStayLifeDinnerCost)�������̏ꍇ
            // �ԋp�p���R�[�h����A�H����p(shortStayLifeDinnerCost)��bindPath����������B
            data.remove(getShortStayLifeDinnerCost().getBindPath());
        }

        // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
        return data;
    }

    /**
     * �u�H���񋟑I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayLifeDinnerOfferActionPerformed(ActionEvent e)
            throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getShortStayLifeDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            setState_NOT_USE_MEAT();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            setState_USE_MEAT();
                // �H����p(shortStayLifeDinnerCost)��ݒ肷��B
                getShortStayLifeDinnerCost().setText(
                        getMeatCost(getShortStayLifeDinnerOffer()
                                .getSelectedIndex()));
        }

    }

    /**
     * �u�H����p���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param meatType int
     * @throws Exception ������O
     * @return String
     */
    public String getMeatCost(int meatType) throws Exception {
        // ���H�����������ƂɑI�����Ə��ɂ�����H����p��Ԃ��B
        if (getSelectedProvider() != null) {
            // ���Ə���I�����Ă���ꍇ
            switch (meatType) {
            case 1:
                // �H���������u������v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��A�u��v�̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1210108", getSelectedProvider()),0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1210109", getSelectedProvider()),0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1210110", getSelectedProvider()),0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1210111", getSelectedProvider()),0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1210109", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1210110",
                                getSelectedProvider()),0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1210110", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1210111",
                                getSelectedProvider()),0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1210111", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1210109",
                                getSelectedProvider()),0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
    }
    /**
     * �J�n�������͗p�̃R���{��Ԃ��܂��B
     * 
     * @return �J�n�������͗p�̃R���{
     */
    public ACComboBox getBeginTimeCombo() {
        // ���J�n�������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ���null��Ԃ��B
        return null;
    }

    /**
     * �I���������͗p�̃R���{��Ԃ��܂��B
     * 
     * @return �I���������͗p�̃R���{
     */
    public ACComboBox getEndTimeCombo() {
        // ���I���������͗p�̃R���{��Ԃ��B
        //    �֐��̕Ԃ�l�Ƃ���null��Ԃ��B
        return null;
    }


}
