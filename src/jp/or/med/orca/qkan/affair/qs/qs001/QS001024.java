
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
 * �v���Z�X �T�[�r�X�p�^�[�����×{�^��Î{�݁i�f�Ï��j (001)
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�f�Ï��j (QS001024)
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
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�f�Ï��j(QS001024) 
 */
public class QS001024 extends QS001024Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001024(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void medicalFacilityClinicInstitutionDivisionRadioActionPerformed(ActionEvent e) throws Exception{
    // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
    // �@�u�{�݋敪�v�̒l���`�F�b�N����B
      switch(getMedicalFacilityClinicInstitutionDivisionRadio().getSelectedIndex()){
      case 1:
    // �@�@�u�P�ƌ^�v�������́u���݌^�v�̏ꍇ
    // �@�@�@�u�a���敪(�ʏ�)�v��L���ɂ��A�u�a���敪(���j�b�g�^)�v�𖳌��ɂ���B
    setState_CONVENTIONAL_FORM();
    break;
      case 2:
    // �@�@�u�P�ƌ^���j�b�g�^�v�������́u���݌^���j�b�g�^�v�̏ꍇ
    // �@�@�@�u�a���敪(�ʏ�)�v�𖳌��ɂ��A�u�a���敪(���j�b�g�^)�v��L���ɂ���B
    setState_UNIT_FORM();
    break;
      }

  }

  /**
   * �u����f�Ô�̐ݒ�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void medicalFacilityClinicConsultationFeeActionPerformed(ActionEvent e) throws Exception{
      // ������f�Ô�̕ҏW
      // ����f�Ô�ҏW���(QS001028)�𐶐�����B
      // ����f�Ô�{�^���̃f�[�^�������ɐ�����������f�Ô�ҏW���(QS001028)��shoModal�����s����B
      if (new QS001028().showModal(SYSTEM_SERVICE_KIND_DETAIL,
              getMedicalFacilityClinicConsultationFee()
                      .getDataModel())) {
          // ����f�Ô��ύX�����ꍇ
          if (getMedicalFacilityClinicConsultationFee()
                  .getDataModel().isEmpty()) {
              // ����f�Ô�{�^���̃f�[�^����̏ꍇ
              // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
              getMedicalFacilityClinicConsultationFeeLabel()
                      .setText("�ݒ�Ȃ�");
          } else {
              // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
              // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
              getMedicalFacilityClinicConsultationFeeLabel()
                      .setText("�ݒ肠��");
          }
      }

  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001024.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
    // ����ʓW�J���̏����ݒ�
      //QS001028(����f�Ô�)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A����f�Ô�{�^���ɐݒ肷��B
      getMedicalFacilityClinicConsultationFee()
              .setBindPathes(QS001028.getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
    // ���R���{�A�C�e���̐ݒ�
    // �@������
    // �@�@�R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
    VRMap comboItemMap = new VRHashMap();

    // �@���H����
    // �@�@�R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
    // �@�@�擾�����l���AcomboItemMap�� KEY : 1530257 �� VALUE �Ƃ��Đݒ肷��B
    comboItemMap.setData("1530257", QkanCommon.getArrayFromMasterCode(191, "1530257"));
    // �@���R���{�A�C�e���̐ݒ�
    // �@�@���g(this)��comboItemMap�ɐݒ肷��B
    getThis().setModelSource(comboItemMap);
    // �@�@�R���{�A�C�e����W�J����B
    getThis().bindModelSource();
    // ���I�����ڂ̏����ݒ�
//  �O�����Z(medicalFacilityClinicStayRadio)�́u�Ȃ��v��I������B
    getMedicalFacilityClinicStayRadio().setSelectedIndex(1);
//    �������Z(medicalFacilityClinicStandardRadio)�́u�Ȃ��v��I������B
    getMedicalFacilityClinicStandardRadio().setSelectedIndex(1);
//    ���Ȏ�f(medicalFacilityClinicMedicalExaminationRadio)�́u�Ȃ��v��I������B
    getMedicalFacilityClinicMedicalExaminationRadio().setSelectedIndex(1);
//    �h�{�Ǘ��̐����Z(medicalFacilityClinicNutritionManageRadio)�́u�Ȃ��v��I������B
    getMedicalFacilityClinicNutritionManageRadio().setSelectedIndex(1);
//    �h�{�}�l�W�����g���Z(medicalFacilityClinicNutritionRadio)�́u�Ȃ��v��I������B
    getMedicalFacilityClinicNutritionRadio().setSelectedIndex(1);
//    �o���ڍs���Z(medicalFacilityClinicOralSwitchRadio)�́u�Ȃ��v��I������B
    getMedicalFacilityClinicOralSwitchRadio().setSelectedIndex(1);
//    �×{�H���Z(medicalFacilityClinicRecuperateDinnerRadio)�́u�Ȃ��v��I������B
    getMedicalFacilityClinicRecuperateDinnerRadio().setSelectedIndex(1);
    // �H����(medicalFacilityClinicDinnerOffer)�́u�Ȃ��v��I������B
    getMedicalFacilityClinicDinnerOffer().setSelectedIndex(0);
    //�l�����Z�R���{(medicalFacilityClinicSubstractionRadio)�́u�Ȃ��v��I������B
    getMedicalFacilityClinicSubstractionRadio().setSelectedIndex(0);

  }

  /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        // �I�����Ă��鎖�Ə����(selectedProvider)��ޔ�����B
        setSelectedProvider(provider);
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            Object obj;
            // �{�݋敪
            obj = VRBindPathParser.get("1530201", provider);
            if (obj != null) {
                getMedicalFacilityClinicInstitutionDivisionRadio()
                        .setSelectedIndex(ACCastUtilities.toInt(obj));
            }
            // �l���z�u�敪
            obj = VRBindPathParser.get("1530201", provider);
            if (obj != null) {
                getMedicalFacilityClinicDivision().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // �×{���
            obj = VRBindPathParser.get("1530203", provider);
            if (obj != null) {
                getMedicalFacilityClinicEnvironmentalRadio().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // �l�����Z
            obj = VRBindPathParser.get("1530208", provider);
            if (obj != null) {
                getMedicalFacilityClinicSubstractionRadio().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // �h�{�Ǘ�
            obj = VRBindPathParser.get("1530204", provider);
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
            obj = VRBindPathParser.get("1530205", provider);
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
            obj = VRBindPathParser.get("1530206", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_NUTRITION();
                } else {
                    // �@�@�u�Ȃ��v�̏ꍇ
                    // �@�@�@�����ɂ���B
                    setState_INVALID_NUTRITION();
                }
            }
            // �@�×{�H
            obj = VRBindPathParser.get("1530207", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �@�@�u����v�̏ꍇ
                    // �@�@�@�L���ɂ���B
                    setState_VALID_MEDICAL_EXPENSES();
                } else {
                    // �@�@�u�Ȃ��v�̏ꍇ
                    // �@�@�@�����ɂ���B
                    setState_INVALID_MEDICAL_EXPENSES();
                }
            }
        }

    }

  /**
   * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public VRMap getValidData() throws Exception{
    // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
      if (!getMedicalFacilityClinicInstitutionDivisionRadio().isSelected()) {
          // �{�݋敪�R���{(medicalFacilityClinicInstitutionDivisionRadio)�����I���̏ꍇ
          // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
          // null��Ԃ��B
          return null;
      }

      if ((getMedicalFacilityClinicHospitalRoomRadio().isEnabled() && (!getMedicalFacilityClinicHospitalRoomRadio()
              .isSelected()))
              || (getMedicalFacilityClinicUnitHospitalRoomRadio()
                      .isEnabled() && (!getMedicalFacilityClinicUnitHospitalRoomRadio()
                      .isSelected()))) {
          // �a���敪�i�a�@�j(medicalFacilityClinicHospitalRoomRadio)���L���ł����I���̏ꍇ
          // �������͕a���敪�i���j�b�g�^�j(medicalFacilityClinicUnitHospitalRoomRadio)���L���ł����I���̏ꍇ
          // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
          // null��Ԃ��B
          return null;
      }
      if (getMedicalFacilityClinicDinnerCost().isEnabled()
              && ACTextUtilities
                      .isNullText(getMedicalFacilityClinicDinnerCost()
                              .getText())) {
          // �H����p(medicalFacilityClinicDinnerCost)���L���ł��󗓂̏ꍇ
          // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
          // null��Ԃ��B
          return null;
      }
    // ���ԋp�p�̃��R�[�h(data)�𐶐�
    VRMap data = new VRHashMap();
    // �@���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
    getThis().setSource(data);
    // �@���g(this)��applySource���Ăяo���ăf�[�^�����W����B
    getThis().applySource();
    // ���ԋp�p���R�[�h����s�v�ȃL�[������
    if (!getMedicalFacilityClinicDinnerCost().isEnabled()){
        // �H����p(medicalFacilityClinicDinnerCost)�������̏ꍇ
        // �ԋp�p���R�[�h����A�H����p(medicalFacilityClinicDinnerCost)��bindPath����������B
        data.remove(getMedicalFacilityClinicDinnerCost()
                .getBindPath());
    }
    // �@���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
return data;
  }

  /**
   * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public boolean isUseProvider() throws Exception{
    // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
    // �@true��Ԃ��B
return true;
  }

  /**
   * �u�H���񋟑I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
protected void medicalFacilityClinicDinnerOfferActionPerformed(ActionEvent e) throws Exception {
    // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
    if (getMedicalFacilityClinicDinnerOffer().getSelectedIndex() < 1) {
        // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
        // �H��𖳌��ɂ���B
        setState_NOT_USE_MEAT();
    } else {
        // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
        // �H���L���ɂ���B
        setState_USE_MEAT();
            // �H����p(medicalFacilityClinicDinnerCost)��ݒ肷��B
            getMedicalFacilityClinicDinnerCost().setText(
                    getMeatCost(getMedicalFacilityClinicDinnerOffer()
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
                    .get("1530209", getSelectedProvider()),0));
        case 2:
            // �H���������u���̂݁v�̏ꍇ
            // �u���v�̐H���Ԃ��B
            return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                    .get("1530210", getSelectedProvider()),0));
        case 3:
            // �H���������u���̂݁v�̏ꍇ
            // �u���v�̐H���Ԃ��B
            return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                    .get("1530211", getSelectedProvider()),0));
        case 4:
            // �H���������u��̂݁v�̏ꍇ
            // �u��v�̐H���Ԃ��B
            return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                    .get("1530212", getSelectedProvider()),0));
        case 5:
            // �H���������u�����v�̏ꍇ
            // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
            return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                    .get("1530210", getSelectedProvider()))
                    + ACCastUtilities.toInt(VRBindPathParser.get("1530211",
                            getSelectedProvider()),0));
        case 6:
            // �H���������u����v�̏ꍇ
            // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
            return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                    .get("1530211", getSelectedProvider()))
                    + ACCastUtilities.toInt(VRBindPathParser.get("1530212",
                            getSelectedProvider()),0));
        case 7:
            // �H���������u�钩�v�̏ꍇ
            // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
            return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                    .get("1530212", getSelectedProvider()))
                    + ACCastUtilities.toInt(VRBindPathParser.get("1530210",
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
