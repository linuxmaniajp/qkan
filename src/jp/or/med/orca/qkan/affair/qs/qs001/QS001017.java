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
 * �v���Z�X �T�[�r�X�p�^�[������×{�Ǘ��w�� (001)
 * �v���O���� �T�[�r�X�p�^�[������×{�Ǘ��w�� (QS001018)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[������×{�Ǘ��w��(QS001018)
 */
public class QS001017 extends QS001017Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001017() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�E�탉�W�I�N���b�N�C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void recuperationManagementGuidanceOccupationalCategoryActionPerformed(
            ActionEvent e) throws Exception {
        // ���E�탉�W�I�ύX���A��ʂ̏�Ԃ�ύX
        switch (getRecuperationManagementGuidanceOccupationalCategory()
                .getSelectedIndex()) {
        case 1:
            // ��t�I����
            // ��t�I�����p�̏�Ԃ�ݒ肷��B
            setState_DOCTOR();
            break;
        case 2:
            // ���Ȉ�t�I����
            // ���Ȉ�t�I�����p�̏�Ԃ�ݒ肷��B
            setState_DENTAL();
            break;
        case 3:
            // ��܎t�i��Ë@�ցj�I����
            // ��܎t�i��Ë@�ցj�I�����p�̏�Ԃ�ݒ肷��B
            setState_CHEMIST_HOSPITAL();
            break;
        case 4:
            // ��܎t�i��ǁj�I����
            // ��܎t�i��ǁj�I�����p�̏�Ԃ�ݒ肷��B
            setState_CHEMIST_PHARMACY();
            break;
        case 5:
            // �h�{�m�I����
            // �h�{�m�I�����p�̏�Ԃ�ݒ肷��B
            setState_DIETICIAN();
            break;
        case 6:
            // ���ȉq���m���I����
            // ���ȉq���m���I�����p�̏�Ԃ�ݒ肷��B
            setState_DENTAL_HYGIENIST();
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
        ACFrame.debugStart(new ACAffairInfo(QS001017.class.getName(), param));
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
        // ���J�n����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ���R���{�A�C�e���̐ݒ�
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();

        // ���I�����ڂ̏����ݒ�
        // �ݑ��f(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio)�́u�Ȃ��v��I������B
        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio()
                .setSelectedIndex(1);
        // ���ʖ��(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio)�́u�Ȃ��v��I������B
        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio()
                .setSelectedIndex(1);
        // ��(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio)�́u1��ځv��I������B
        getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio()
                .setSelectedIndex(1);

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�

    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if (!getRecuperationManagementGuidanceOccupationalCategory()
                .isSelected()) {
            // �E�탉�W�I�O���[�v(recuperationManagementGuidanceOccupationalCategory)�����I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if (ACTextUtilities
                .isNullText(getRecuperationManagementGuidanceBeginTime()
                        .getText())
                || ACTextUtilities
                        .isNullText(getRecuperationManagementGuidanceEndTime()
                                .getText())
                || (!getRecuperationManagementGuidanceBeginTime().isValidDate())
                || (!getRecuperationManagementGuidanceEndTime().isValidDate())) {
            // �J�n�����R���{(recuperationManagementGuidanceBeginTime)�ƏI�������R���{(recuperationManagementGuidanceEndTime)�̂����ꂩ���󗓂������͕s���̏ꍇ
            // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
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
        if (!getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio()
                .isEnabled()) {
            // �ݑ��f(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio)�������̏ꍇ
            // �ԋp�p���R�[�h����A�ݑ��f(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio)��bindPath����������B
            data
                    .remove(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio()
                            .getBindPath());
        }
        if (!getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio()
                .isEnabled()) {
            // ���ʖ��(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio)�������̏ꍇ
            // �ԋp�p���R�[�h����A���ʖ��(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio)��bindPath����������B
            data
                    .remove(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio()
                            .getBindPath());
        }
        if (!getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio()
                .isEnabled()) {
            // ��(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio)�������̏ꍇ
            // �ԋp�p���R�[�h����A��(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio)��bindPath����������B
            data
                    .remove(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio()
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
     * �J�n�������͗p�̃R���{��Ԃ��܂��B
     * @return �J�n�������͗p�̃R���{
     */
   public ACComboBox getBeginTimeCombo() {
       // ���J�n�������͗p�̃R���{��Ԃ��B
       // �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return getRecuperationManagementGuidanceBeginTime();
    }
   
   

   /**
    * �I���������͗p�̃R���{��Ԃ��܂��B
    * @return �I���������͗p�̃R���{
    */
    public ACComboBox getEndTimeCombo() {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getRecuperationManagementGuidanceEndTime();
    }

}
