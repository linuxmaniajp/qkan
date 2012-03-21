
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
 * �쐬��: 2008/04/14  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� ���ʗ×{���� (QS001200)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * ���ʗ×{����(QS001200) 
 */
@SuppressWarnings("serial")
public class QS001S02_201204 extends QS001S02_201204Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001S02_201204(){
  }

  // �R���|�[�l���g�C�x���g
  /**
   * �u�ݒ�v�C�x���g�ł��B
   * 
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void applyActionPerformed(ActionEvent e) throws Exception {
      // ����ʂ̏�Ԃ��Ăяo�����ɕԂ�
      // values�ɉ�ʂ̒l���i�[����B
      getSpecificConsultationFeePattern().setSource(getValues());
      getValues().clear();
      getSpecificConsultationFeePattern().applySource();

      // �������ȃR���{�̒l���폜����B
      // ���꒮�o�Ö@�R���{(languageTherapy1Combo)�������Ȃ�΁A���꒮�o�Ö@�R���{(languageTherapy1Combo)��bindPath���폜����B
      if (!getLanguageTherapy1Combo().isEnabled()) {
          getValues().remove(getLanguageTherapy1Combo().getBindPath());
      }
      // ���꒮�o�R���{(language1Combo)�������Ȃ�΁A���꒮�o�iI�j�R���{(language1Combo)��bindPath���폜����B
      if (!getLanguage1Combo().isEnabled()) {
          getValues().remove(getLanguage1Combo().getBindPath());
      }

      // �����I���ȃ`�F�b�N�̒l���폜����B
      // �����΍�w���Ǘ�(infectionGuidanceManagement)�����I���Ȃ�΁A�����΍�w���Ǘ�(infectionGuidanceManagement)��bindPath���폜����B
      if (!getInfectionGuidanceManagement().isSelected()) {
          getValues().remove(getInfectionGuidanceManagement().getBindPath());
      }
      // ��጑΍�w���Ǘ�(bedGuidanceManagement)�����I���Ȃ�΁A��጑΍�w���Ǘ�(bedGuidanceManagement)��bindPath���폜����B
      if (!getBedGuidanceManagement().isSelected()) {
          getValues().remove(getBedGuidanceManagement().getBindPath());
      }
      // �������@�f�ÊǗ�(beginningGuidanceManagement)�����I���Ȃ�΁A�������@�f�ÊǗ�(beginningGuidanceManagement)��bindPath���폜����B
      if (!getBeginningGuidanceManagement().isSelected()) {
          getValues().remove(getBeginningGuidanceManagement().getBindPath());
      }
      // �d�x�×{�Ǘ�(heavyRecuperateGuidanceManagement)�����I���Ȃ�΁A�d�x�×{�Ǘ�(heavyRecuperateGuidanceManagement)��bindPath���폜����B
      if (!getHeavyRecuperateGuidanceManagement().isSelected()) {
          getValues().remove(
                  getHeavyRecuperateGuidanceManagement().getBindPath());
      }
      // ����{�݊Ǘ�(particularInstitutionManagment)�����I���Ȃ�΁A����{�݊Ǘ�(particularInstitutionManagment)��bindPath���폜����B
      if (!getParticularInstitutionManagment().isSelected()) {
          getValues().remove(
                  getParticularInstitutionManagment().getBindPath());
      }
      // ����{�݊Ǘ������Z(particularInstitutionManagmentPrivateRoom)�����I���Ȃ�΁A����{�݊Ǘ������Z(particularInstitutionManagmentPrivateRoom)��bindPath���폜����B
      if (!getParticularInstitutionManagmentPrivateRoom().isSelected()) {
          getValues().remove(
                  getParticularInstitutionManagmentPrivateRoom()
                          .getBindPath());
      }
      // ����{�݊Ǘ�2�l�������Z(particularInstitutionManagmentPrivateRoom2)�����I���Ȃ�΁A����{�݊Ǘ�2�l�������Z(particularInstitutionManagmentPrivateRoom2)��bindPath���폜����B
      if (!getParticularInstitutionManagmentPrivateRoom2().isSelected()) {
          getValues().remove(
                  getParticularInstitutionManagmentPrivateRoom2()
                          .getBindPath());
      }
      // �d�ǔ畆��ᇊǗ��w��(heavySkinManegement)�����I���Ȃ�΁A�d�ǔ畆��ᇊǗ��w��(heavySkinManegement)��bindPath���폜����B
      if (!getHeavySkinManegement().isSelected()) {
          getValues().remove(getHeavySkinManegement().getBindPath());
      }
      // ��܊Ǘ��w��(medicineManegementLeading)�����I���Ȃ�΁A��܊Ǘ��w��(medicineManegementLeading)��bindPath���폜����B
      if (!getMedicineManegementLeading().isSelected()) {
          getValues().remove(getMedicineManegementLeading().getBindPath());
      }
      // ���ʖ�܊Ǘ��w�����Z(specialMedicineManagementLeading)�����I���Ȃ�΁A���ʖ�܊Ǘ��w�����Z(specialMedicineManagementLeading)��bindPath���폜����B
      if (!getSpecialMedicineManagementLeading().isSelected()) {
          getValues().remove(
                  getSpecialMedicineManagementLeading().getBindPath());
      }
      // ��w����(medicalScienceInfo)�����I���Ȃ�΁A��w���񋟁i�h�j(medicalScienceInfo)��bindPath���폜����B
      if (!getMedicalScienceInfo().isSelected()) {
          getValues().remove(getMedicalScienceInfo().getBindPath());
      }
      // �ېH�@�\�Ö@(dinner)�����I���Ȃ�΁A�ېH�@�\�Ö@(dinner)��bindPath���폜����B
      if (!getDinner().isSelected()) {
          getValues().remove(getDinner().getBindPath());
      }
      // ���_�ȍ�ƗÖ@(mindTherapy)�����I���Ȃ�΁A���_�ȍ�ƗÖ@(mindTherapy)��bindPath���폜����B
      if (!getMindTherapy().isSelected()) {
          getValues().remove(getMindTherapy().getBindPath());
      }
      // �F�m�Ǔ������_�Ö@(cognitive)�����I���Ȃ�΁A�F�m�ǘV�l���@���_�Ö@(cognitive)��bindPath���폜����B
      if (!getCognitive().isSelected()) {
          getValues().remove(getCognitive().getBindPath());
      }
      // ���n�r���񋟎w�����Z�����I���Ȃ�΍폜
      if(!getRehabilitationManegement().isSelected()){
          getValues().remove(getRehabilitationManegement().getBindPath());
      }
      // ���n�r���̐��������Z�R���{(rehabilitationSystemCombo)�������Ȃ�΁A���n�r���̐��������Z�R���{(rehabilitationSystemCombo)��bindPath���폜����B
      if (!getRehabilitationSystemCombo().isEnabled()) {
          getValues().remove(getRehabilitationSystemCombo().getBindPath());
      }

      // ���ݒ�ς݂Ƃ��ĕ���B

      // �ݒ�{�^�������������t���O��true�ɂ���B
      setApplied(true);
      // ��ʂ����B
      dispose();
  }

  /**
   * �u���꒮�o�Ö@�̗L����ԕύX�v�C�x���g�ł��B
   * 
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void languageTherapy1ActionPerformed(ActionEvent e)
          throws Exception {
      // �����꒮�o�Ö@�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
      if (getLanguageTherapy1().isSelected()) {
          // ���꒮�o�Ö@�`�F�b�N(languageTherapy1)���I������Ă���ꍇ
          // ���꒮�o�Ö@�R���{(languageTherapy1Combo)��L���ɂ���B
          setState_VALID_LANGUAGE_THERAPY1();
          // ���꒮�o�Ö@�R���{(languageTherapy1Combo)��1�ڂ̍��ڂ�I������B
          getLanguageTherapy1Combo().setSelectedIndex(0);
      } else {
          // ���꒮�o�Ö@�`�F�b�N(languageTherapy1)���I������Ă��Ȃ��ꍇ
          // ���꒮�o�Ö@�R���{(languageTherapy1Combo)�𖳌��ɂ���B
          setState_INVALID_LANGUAGE_THERAPY1();
          // ���꒮�o�Ö@�R���{(languageTherapy1Combo)�𖢑I����Ԃɂ���B
          getLanguageTherapy1Combo().clearSelection();
      }

  }

  /**
   * �u���꒮�o�̗L����ԕύX�v�C�x���g�ł��B
   * 
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void language1ActionPerformed(ActionEvent e) throws Exception {
      // �����꒮�o�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
      if (getLanguage1().isSelected()) {
          // ���꒮�o�`�F�b�N(language1)���I������Ă���ꍇ
          // ���꒮�o�R���{(language1Combo)��L���ɂ���B
          setState_VALID_LANGUAGE1();
          // ���꒮�o�R���{(language1Combo)��1�ڂ̍��ڂ�I������B
          getLanguage1Combo().setSelectedIndex(0);
      } else {
          // ���꒮�o�`�F�b�N(language1)���I������Ă��Ȃ��ꍇ
          // ���꒮�o�R���{(language1Combo)�𖳌��ɂ���B
          setState_INVALID_LANGUAGE1();
          // ���꒮�o�R���{(language1Combo)�𖢑I����Ԃɂ���B
          getLanguage1Combo().clearSelection();
      }

  }

  /**
   * �u���n�r���̐��������Z�̗L����ԕύX�v�C�x���g�ł��B
   * 
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void rehabilitationSystemActionPerformed(ActionEvent e)
          throws Exception {
      // �����n�r���̐��������Z�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
      if (getRehabilitationSystem().isSelected()) {
          // ���n�r���̐��������Z�`�F�b�N(rehabilitationSystem)���I������Ă���ꍇ
          // ���n�r���̐��������Z�R���{(rehabilitationSystemCombo)��L���ɂ���B
    	  setState_VALID_RIHABIRI_SYSTEM();
          // ���n�r���̐��������Z�R���{(rehabilitationSystemCombo)��1�ڂ̍��ڂ�I������B
    	  getRehabilitationSystemCombo().setSelectedIndex(0);
      } else {
          // ���n�r���̐��������Z�`�F�b�N(rehabilitationSystem)���I������Ă��Ȃ��ꍇ
          // ���n�r���̐��������Z�R���{(rehabilitationSystemCombo)�𖳌��ɂ���B
    	  setState_INVALID_RIHABIRI_SYSTEM();
          // ���n�r���̐��������Z�R���{(rehabilitationSystemCombo)�𖢑I����Ԃɂ���B
    	  getRehabilitationSystemCombo().clearSelection();
      }

  }
 
  public static void main(String[] args) {
      // �f�t�H���g�f�o�b�O�N��
      ACFrame.getInstance().setFrameEventProcesser(
              new QkanFrameEventProcesser());
      QkanCommon.debugInitialize();
      VRMap param = new VRHashMap();
      // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
      ACFrame.debugStart(new ACAffairInfo(QS001S02_201204.class.getName(), param));
  }

  // �����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * 
   * @param systemServiceKindDetail int
   * @param param VRMap
   * @throws Exception ������O
   * @return boolean
   */
  public boolean showModal(int systemServiceKindDetail, VRMap param)
          throws Exception {
      // ����ʂ̏�����

      setAffairTitle("QS001S02");
      
      // ���R���{�A�C�e���̐ݒ�
      // ������
      // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
      VRMap comboItemMap = new VRHashMap();

      // ���H����
      // �R�[�h�}�X�^�f�[�^���CODE_ID�F109�i���w�Ö@(I)�j���擾����B
      // �擾�����l���AcomboItemMap�� KEY : 109 �� VALUE �Ƃ��Đݒ肷��B
      VRList codes = QkanCommon.getArrayFromMasterCode(109, "3010115");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010147");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010148");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010141");
      
      comboItemMap.setData("109", codes);
      // ���R���{�A�C�e���̐ݒ�
      // ���g(specificConsultationFeePattern)��comboItemMap�ɐݒ肷��B
      getSpecificConsultationFeePattern().setModelSource(comboItemMap);
      // �R���{�A�C�e����W�J����B
      getSpecificConsultationFeePattern().bindModelSource();

      // ���T�[�r�X�̎�ނɉ����ĕ\�����ڂ𐧌�����B
      switch (systemServiceKindDetail) {
      case 12211:// �Z�������×{���(�V��)
          setState_HEALTH_FACILITIES_WARD();
          // ���������f�ÊǗ��𖳌���Ԃɂ���
          setState_INVALID_BEGINNIGN_GUIDANCE();
          // ���n�r���e�[�V�����w���Ǘ��𖳌���Ԃɂ���B
          setState_INVALID_REHABILITATION_MANEGEMENT();
          break;
          
      case 12511:// ���\�h�Z�������×{���i�V���j
          setState_HEALTH_FACILITIES_WARD();
          // ���������f�ÊǗ��𖳌���Ԃɂ���
          setState_INVALID_BEGINNIGN_GUIDANCE();
          // ���n�r���e�[�V�����w���Ǘ��𖳌���Ԃɂ���B
          setState_INVALID_REHABILITATION_MANEGEMENT();
          // �d�x�×{�Ǘ��𖳌���Ԃɂ���B
          setState_INVALID_HEAVY_RECUPERATE();
          break;
          
      case 15211:// �V�l�ی��{��
          // �V�l�ی��{�݊֘A�̓��ʗ×{���Ԃɐݒ肷��
          setState_HEALTH_FACILITIES_WARD();
          break;
      }

      // �������œn���ꂽ����f�Ô������ʂɓW�J����B
      // ����param ������ϐ�values�ɐݒ肷��B
      setValues(param);
      // values�̒l����ʂɓW�J����B
      getSpecificConsultationFeePattern().setSource(getValues());
      getSpecificConsultationFeePattern().bindSource();

      // ���R���{�̑I����Ԃ���`�F�b�N�̑I����ԂƃR���{�̗L��������߂�B

      // ���꒮�o�Ö@�R���{(languageTherapy1Combo)���I������Ă���΁A���꒮�o�Ö@�`�F�b�N(languageTherapy1)��I������B
      getLanguageTherapy1().setSelected(
              getLanguageTherapy1Combo().isSelected());
      if(getLanguageTherapy1().isSelected()){
          setState_VALID_LANGUAGE_THERAPY1();
      }
      // ���꒮�o�R���{(language1Combo)���I������Ă���΁A���꒮�o�`�F�b�N(language1)��I������B
      getLanguage1().setSelected(getLanguage1Combo().isSelected());
      if(getLanguage1().isSelected()){
          setState_VALID_LANGUAGE1();
      }
      // ���n�r���̐��������Z�R���{(rehabilitationSystemCombo)���I������Ă���΁A���n�r���̐��������Z�`�F�b�N(rehabilitationSystem)��I������B
      getRehabilitationSystem().setSelected(
    		  getRehabilitationSystemCombo().isSelected());
      if(getRehabilitationSystem().isSelected()){
    	  setState_VALID_RIHABIRI_SYSTEM();
      }
      // ��ʂ�\������B
      setVisible(true);
      
      return getApplied();
  }

  public static String[] getTargetBindPathes(int systemServiceKindDetail)
          throws Exception {
      switch (systemServiceKindDetail) {
      // ����systemServiceKindDetail�̒l���ȉ��̒Z�������×{���T�[�r�X�̏ꍇ
      case 12211:// �Z�������×{���(�V��)
          // ���n�r���e�[�V�����w���Ǘ��͑ΏۊO
          return new String[] { "3010101", "3010102", "3010104", "3010105",
                  "3010106", "3010107", "3010108", "3010110", "3010111",
                  "3010136", "3010137", "3010138", "3010141","3010145",
                  "3010147", "3010148", "3010149" };
      case 12511:// ���\�h�Z�������×{���i�V���j
          // ���n�r���e�[�V�����w���Ǘ��͑ΏۊO
          // �d�x�×{�Ǘ��͑ΏۊO
          return new String[] { "3010101", "3010102", "3010105", "3010106",
                    "3010107", "3010108", "3010110", "3010111", "3010136",
                    "3010137", "3010138", "3010141", "3010145", "3010147",
                    "3010148", "3010149" };
      case 15211:// �V�l�ی��{��
          return new String[] { "3010101", "3010102", "3010104", "3010105",
                    "3010106", "3010107", "3010108", "3010110", "3010111",
                    "3010136", "3010137", "3010138", "3010141", "3010144",
                    "3010145", "3010146", "3010147", "3010148", "3010149" };
      default:
          return new String[] { "3010101", "3010102", "3010104", "3010105",
              "3010106", "3010107", "3010108", "3010110", "3010111",
              "3010136", "3010137", "3010138", "3010141", "3010145",
              "3010146", "3010147", "3010148", "3010149" };
      }
  }
}
