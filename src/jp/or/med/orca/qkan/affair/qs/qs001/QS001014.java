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
 * �쐬��: 2006/01/18  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[���Z�������×{���i�f�Ï��×{�j (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i�f�Ï��×{�j (QS001015)
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
 * �T�[�r�X�p�^�[���Z�������×{���i�f�Ï��×{�j(QS001015)
 */
public class QS001014 extends QS001014Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001014() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayClinicRecuperationInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getShortStayClinicRecuperationInstitutionDivisionRadio()
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
        ACFrame.debugStart(new ACAffairInfo(QS001014.class.getName(), param));
    }

    // �����֐�

    /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // ����ʓW�J���̏����ݒ�
        //QS001028(����f�Ô�)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A����f�Ô�{�^���ɐݒ肷��B
        getShortStayClinicRecuperationSpecificConsultationFee()
                .setBindPathes(QS001028.getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���H����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1230249 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1230249", QkanCommon.getArrayFromMasterCode(191,
                "1230249"));
        // ���R���{�A�C�e���̐ݒ�
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();
        // ���I�����ڂ̏����ݒ�
        //�a���i�f�Ï��j(shortStayClinicRecuperationHospitalRoomRadio)�́u�]���^���v��I������B
        getShortStayClinicRecuperationHospitalRoomRadio().setSelectedIndex(1);
        //�a���i���j�b�g�^�j(shortStayClinicRecuperationUnitHospitalRoomRadio)�́u���j�b�g�^���v��I������B
        getShortStayClinicRecuperationUnitHospitalRoomRadio().setSelectedIndex(1);
        // �h�{�Ǘ��̐����Z(shortStayClinicRecuperationDieticianManageRadio)�́u�Ȃ��v��I������B
        getShortStayClinicRecuperationDieticianManageRadio()
                .setSelectedIndex(1);
        // �×{�H���Z(shortStayClinicRecuperationMedicalExpensesRadio)�́u�Ȃ��v��I������B
        getShortStayClinicRecuperationMedicalExpensesRadio()
                .setSelectedIndex(1);

        // �H����(shortStayClinicRecuperationDinnerOffer)�́u�Ȃ��v��I������B
        getShortStayClinicRecuperationDinnerOffer().setSelectedIndex(0);

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
            obj = VRBindPathParser.get("1230201", provider);
            if (obj != null) {
                getShortStayClinicRecuperationInstitutionDivisionRadio()
                        .setSelectedIndex(ACCastUtilities.toInt(obj));
            }
            // �l���z�u
            obj = VRBindPathParser.get("1230202", provider);
            if (obj != null) {
                getShortStayClinicRecuperationDivision().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // �×{���
            obj = VRBindPathParser.get("1230203", provider);
            if (obj != null) {
                getShortStayClinicRecuperationSubtractionType()
                        .setSelectedIndex(ACCastUtilities.toInt(obj));
            }
            // �l�����Z
            obj = VRBindPathParser.get("1230207", provider);
            if (obj != null) {
                getShortStayClinicRecuperationStaffReduceRadio()
                        .setSelectedIndex(ACCastUtilities.toInt(obj));
            }
            // ���}
            obj = VRBindPathParser.get("1230204", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // ���}�敪(shortStayClinicRecuperationMeetingAndSendingOff)��3�Ԗڂ̃{�^����I���ɂ���B
                    getShortStayClinicRecuperationMeetingAndSendingOff().setSelectedIndex(3);
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // ���}�敪(shortStayClinicRecuperationMeetingAndSendingOff)��1�Ԗڂ̃{�^����I���ɂ���B
                    getShortStayClinicRecuperationMeetingAndSendingOff().setSelectedIndex(1);
                    break;
                }
            }
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // �h�{�Ǘ��̐�
            obj = VRBindPathParser.get("1230205", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_DIETICIAN_MANAGE();
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_DIETICIAN_MANAGE();
                    break;
                }
            }
            // �×{�H
            obj = VRBindPathParser.get("1230206", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_MEDICAL_EXPENSES();
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_MEDICAL_EXPENSES();
                    break;
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
 
        
        if (getShortStayClinicRecuperationDinnerOffer().getSelectedIndex() > 0) {
            // �H���񋟁ishortStayClinicRecuperationDinnerOffer)���u�Ȃ��v�ȊO��I�����Ă���ꍇ
            if (ACTextUtilities.isNullText(getShortStayClinicRecuperationDinnerCost().getText())) {
                // �H����p(shortStayClinicRecuperationDinnerCost)���󗓂̏ꍇ
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
        if (!getShortStayClinicRecuperationMeetingAndSendingOff().isEnabled()) {
            // ���}�敪(shortStayClinicRecuperationMeetingAndSendingOff)�������̏ꍇ
            // �ԋp�p���R�[�h����A���}�敪(shortStayClinicRecuperationMeetingAndSendingOff)��bindPath����������B
            data.remove(getShortStayClinicRecuperationMeetingAndSendingOff()
                    .getBindPath());
        }
        if (!getShortStayClinicRecuperationDieticianManageRadio().isEnabled()) {
            // �h�{�Ǘ��̐����Z(shortStayClinicRecuperationDieticianManageRadio)�������̏ꍇ
            // �ԋp�p���R�[�h����A�h�{�Ǘ��̐����Z(shortStayClinicRecuperationDieticianManageRadio)��bindPath����������B
            data.remove(getShortStayClinicRecuperationDieticianManageRadio()
                    .getBindPath());
        }
        if (!getShortStayClinicRecuperationMedicalExpensesRadio().isEnabled()) {
            // �×{�H���Z(shortStayClinicRecuperationMedicalExpensesRadio)�������̏ꍇ
            // �×{�H���Z(shortStayClinicRecuperationMedicalExpensesRadio)��bindPath����������B
            data.remove(getShortStayClinicRecuperationMedicalExpensesRadio()
                    .getBindPath());
        }
        if (!getShortStayClinicRecuperationDinnerCost().isEnabled()){
            // �H����p(shortStayClinicRecuperationDinnerCost)�������̏ꍇ
            // �ԋp�p���R�[�h����A�H����p(shortStayClinicRecuperationDinnerCost)��bindPath����������B
            data.remove(getShortStayClinicRecuperationDinnerCost().getBindPath());
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
    protected void shortStayClinicRecuperationDinnerOfferActionPerformed(ActionEvent e) throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getShortStayClinicRecuperationDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            setState_NOT_USE_MEAT();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            setState_USE_MEAT();
                // �H����p(shortStayClinicRecuperationDinnerCost)��ݒ肷��B
                getShortStayClinicRecuperationDinnerCost().setText(
                        getMeatCost(getShortStayClinicRecuperationDinnerOffer()
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
                        .get("1230208", getSelectedProvider()),0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230209", getSelectedProvider()),0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230210", getSelectedProvider()),0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230211", getSelectedProvider()),0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230209", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230210",
                                getSelectedProvider()),0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230210", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230211",
                                getSelectedProvider()),0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230211", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230209",
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

    /**
     * �u����f�Ô�ҏW�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayClinicRecuperationSpecificConsultationFeeActionPerformed(ActionEvent e) throws Exception {
        // ������f�Ô�̕ҏW
        // ����f�Ô�ҏW���(QS001028)�𐶐�����B
        // ����f�Ô�{�^���̃f�[�^�������ɐ�����������f�Ô�ҏW���(QS001028)��shoModal�����s����B
        if (new QS001028().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getShortStayClinicRecuperationSpecificConsultationFee()
                        .getDataModel())) {
            // ����f�Ô��ύX�����ꍇ
            if (getShortStayClinicRecuperationSpecificConsultationFee()
                    .getDataModel().isEmpty()) {
                // ����f�Ô�{�^���̃f�[�^����̏ꍇ
                // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
                getShortStayClinicRecuperationSpecificConsultationFeeOutline()
                        .setText("�ݒ�Ȃ�");
            } else {
                // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
                // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
                getShortStayClinicRecuperationSpecificConsultationFeeOutline()
                        .setText("�ݒ肠��");
            }
        }
    }

}
