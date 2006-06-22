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
 * �쐬��: 2006/01/23  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[�����V�l�ی��{�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����V�l�ی��{�� (QS001022)
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
 * �T�[�r�X�p�^�[�����V�l�ی��{��(QS001022)
 */
public class QS001022 extends QS001022Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001022() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoHealthCareOfTheAgedDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getKaigoHealthCareOfTheAgedDivisionRadio().getSelectedIndex()) {
        case 1:
            // �u���ی��{�݁v�̏ꍇ
            // �u�a���敪�i���V�l�ی��{�݁j�v��L���ɂ��A�u�a���敪�i���j�b�g�^���V�l�ی��{�݁j�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            break;
        case 2:
            // �u���j�b�g�^���ی��{�݁v�̏ꍇ
            // �u�a���敪�i���V�l�ی��{�݁j�v�𖳌��ɂ��A�u�a���敪�i���j�b�g�^���V�l�ی��{�݁j�v��L���ɂ���B
            setState_UNIT_FORM();
            break;
        }

    }


    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001022.class.getName(), param));
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
        // �擾�����l���AcomboItemMap�� KEY : 1520120 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1520120", QkanCommon.getArrayFromMasterCode(191,
                "1520120"));
        // ���R���{�A�C�e���̐ݒ�
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();
        // ���I�����ڂ̏����ݒ�
        // ���n�r���@�\�������Z kaigoHealthCareOfTheAgedRehabilitationRadio
        getKaigoHealthCareOfTheAgedRehabilitationRadio().setSelectedIndex(1);
        // �F�m�ǐ�哏���Z kaigoHealthCareOfTheAgedDementiaRadio

        getKaigoHealthCareOfTheAgedDementiaRadio().setSelectedIndex(1);
        // �O�������Z kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio

        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio()
                .setSelectedIndex(1);
        // �������Z kaigoHealthCareOfTheAgedDefaultRadio

        getKaigoHealthCareOfTheAgedDefaultRadio().setSelectedIndex(1);
        // �ً}�����ÊǗ����Z kaigoHealthCareOfTheAgedEmergencyRadio

        getKaigoHealthCareOfTheAgedEmergencyRadio().setSelectedIndex(1);
        // �h�{�Ǘ��̐����Z kaigoHealthCareOfTheAgedNutritionManageRadio

        getKaigoHealthCareOfTheAgedNutritionManageRadio().setSelectedIndex(1);
        // �h�{�}�l�W�����g���Z kaigoHealthCareOfTheAgedNutritionRadio

        getKaigoHealthCareOfTheAgedNutritionRadio().setSelectedIndex(1);
        // �o���ڍs���Z kaigoHealthCareOfTheAgedOralSwitchRadio

        getKaigoHealthCareOfTheAgedOralSwitchRadio().setSelectedIndex(1);
        // �×{�H���Z kaigoHealthCareOfTheAgedRecuperateDinnerRadio

        getKaigoHealthCareOfTheAgedRecuperateDinnerRadio().setSelectedIndex(1);

        // �H����(kaigoHealthCareOfTheAgedDinnerOffer)�́u�Ȃ��v��I������B
        getKaigoHealthCareOfTheAgedDinnerOffer().setSelectedIndex(0);

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
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            Object obj;
            // �{�݋敪
            obj = VRBindPathParser.get("1520101", provider);
            if (obj != null) {
                getKaigoHealthCareOfTheAgedDivisionRadio().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // ��ԋΖ������
            obj = VRBindPathParser.get("1520102", provider);
            if (obj != null) {
                getKaigoHealthCareOfTheAgedNightShiftSubtractionRadio()
                        .setSelectedIndex(ACCastUtilities.toInt(obj));
            }
            // �l�����Z
            obj = VRBindPathParser.get("1520109", provider);
            if (obj != null) {
                getKaigoHealthCareOfTheAgedStaffSubtraction().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // ���n�r���@�\����
            obj = VRBindPathParser.get("1520103", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_REHABILITATION();
                } else {
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_REHABILITATION();
                }
            }
            // �F�m�ǐ��a��
            obj = VRBindPathParser.get("1520104", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_SPECIAL();
                } else {
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_SPECIAL();
                }
            }
            // �h�{�Ǘ�
            obj = VRBindPathParser.get("1520105", provider);
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
            // �h�{�}�l�W�����g
            obj = VRBindPathParser.get("1520106", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_MANAGE();
                } else {
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_MANAGE();
                }
            }
            // �o���ڍs
            obj = VRBindPathParser.get("1520107", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_NUTRITION();
                } else {
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_NUTRITION();
                }
            }
            // �×{�H
            obj = VRBindPathParser.get("1520108", provider);
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
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {

        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if (!getKaigoHealthCareOfTheAgedDivisionRadio().isSelected()) {
            // �{�݋敪�R���{(kaigoHealthCareOfTheAgedDivisionRadio)�����I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }

        if ((getKaigoHealthCareOfTheAgedHospitalRoomRadio().isEnabled() && (!getKaigoHealthCareOfTheAgedHospitalRoomRadio()
                .isSelected()))
                || (getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio()
                        .isEnabled() && (!getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio()
                        .isSelected()))) {
            // �a���敪�i���ی��{�݁j(kaigoHealthCareOfTheAgedHospitalRoomRadio)���L���ł����I���̏ꍇ
            // �������͕a���敪�i���j�b�g�^�j(kaigoHealthCareOfTheAgedUnitHospitalRoomRadio)���L���ł����I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if (getKaigoHealthCareOfTheAgedDinnerOffer().isEnabled()
                && ACTextUtilities
                        .isNullText(getKaigoHealthCareOfTheAgedDinnerOffer()
                                .getText())) {
            // �H����p(kaigoHealthCareOfTheAgedDinnerOffer)���L���ł��󗓂̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        // ���ԋp�p�̃��R�[�h(data)�𐶐�
        VRMap data = new VRHashMap();
        // ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
        getThis().setSource(data);
        // ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
        getThis().applySource();
        // ���ԋp�p���R�[�h����s�v�ȃL�[������
        if (!getKaigoHealthCareOfTheAgedDinnerOffer().isEnabled()){
            // �H����p(kaigoHealthCareOfTheAgedDinnerOffer)�������̏ꍇ
            // �ԋp�p���R�[�h����A�H����p(kaigoHealthCareOfTheAgedDinnerOffer)��bindPath����������B
            data.remove(getKaigoHealthCareOfTheAgedDinnerOffer()
                    .getBindPath());
        }
        // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
        return data;
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
     * �u�H���񋟑I���v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoHealthCareOfTheAgedDinnerOfferActionPerformed(ActionEvent e) throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getKaigoHealthCareOfTheAgedDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            setState_NOT_USE_MEAT();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            setState_USE_MEAT();
                // �H����p(kaigoHealthCareOfTheAgedDinnerCost)��ݒ肷��B
                getKaigoHealthCareOfTheAgedDinnerCost().setText(
                        getMeatCost(getKaigoHealthCareOfTheAgedDinnerOffer()
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
                        .get("1520110", getSelectedProvider()),0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520111", getSelectedProvider()),0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520112", getSelectedProvider()),0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520113", getSelectedProvider()),0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520111", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520112",
                                getSelectedProvider()),0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520112", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520113",
                                getSelectedProvider()),0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520113", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520114",
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
