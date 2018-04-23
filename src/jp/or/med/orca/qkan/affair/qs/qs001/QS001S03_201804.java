
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
 * �J����: 
 * �쐬��: 
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� ���ʐf�Ô��� (QS001S03_201804)
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
 * ���ʐf�Ô���(QS001S03_201804) 
 */
@SuppressWarnings("serial")
public class QS001S03_201804 extends QS001S03_201804Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001S03_201804(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�ݒ�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void applyActionPerformed(ActionEvent e) throws Exception{
      // ����ʂ̏�Ԃ��Ăяo�����ɕԂ�
      // values�ɉ�ʂ̒l���i�[����B
      getSpecificConsultationFeePattern().setSource(getValues());
      getValues().clear();
      getSpecificConsultationFeePattern().applySource();

      // �������ȃR���{�̒l���폜����B
      // ���w�Ö@�i�h�j�R���{(scienceTherapy1Combo)�������Ȃ�΁A���w�Ö@�i�h�j�R���{(scienceTherapy1Combo)��bindPath���폜����B
      if (!getScienceTherapy1Combo().isEnabled()) {
          getValues().remove(getScienceTherapy1Combo().getBindPath());
      }
      // ���w�Ö@�i�h�h�j�R���{(scienceTherapy2Combo)�������Ȃ�΁A���w�Ö@�i�h�h�j�R���{(scienceTherapy2Combo)��bindPath���폜����B
      if (!getScienceTherapy2Combo().isEnabled()) {
          getValues().remove(getScienceTherapy2Combo().getBindPath());
      }
      // ���w�i�h�j�R���{(science1Combo)�������Ȃ�΁A���w�i�h�j�R���{(science1Combo)��bindPath���폜����B
      if (!getScience1Combo().isEnabled()) {
          getValues().remove(getScience1Combo().getBindPath());
      }
      // ���w�i�h�h�j�R���{(science2Combo)�������Ȃ�΁A���w�i�h�h�j�R���{(science2Combo)��bindPath���폜����B
      if (!getScience2Combo().isEnabled()) {
          getValues().remove(getScience2Combo().getBindPath());
      }
      // ��ƗÖ@�R���{(workTherapy1Combo)�������Ȃ�΁A��ƗÖ@�R���{(workTherapy1Combo)��bindPath���폜����B
      if (!getWorkTherapy1Combo().isEnabled()) {
          getValues().remove(getWorkTherapy1Combo().getBindPath());
      }
      // ��ƃR���{(work1Combo)�������Ȃ�΁A��ƁiI�j�R���{(work1Combo)��bindPath���폜����B
      if (!getWork1Combo().isEnabled()) {
          getValues().remove(getWork1Combo().getBindPath());
      }
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
      // ��w���񋟁i�h�j(medicalScienceInfo1)�����I���Ȃ�΁A��w���񋟁i�h�j(medicalScienceInfo1)��bindPath���폜����B
      if (!getMedicalScienceInfo1().isSelected()) {
          getValues().remove(getMedicalScienceInfo1().getBindPath());
      }
      // ��w���񋟁i�h�h�j(medicalScienceInfo2)�����I���Ȃ�΁A��w���񋟁i�h�h�j(medicalScienceInfo2)��bindPath���폜����B
      if (!getMedicalScienceInfo2().isSelected()) {
          getValues().remove(getMedicalScienceInfo2().getBindPath());
      }
      // ���n�r���v����Z(rehabilitationPlan)�����I���Ȃ�΁A���n�r���v����Z(rehabilitationPlan)��bindPath���폜����B
      if (!getRehabilitationPlan().isSelected()) {
          getValues().remove(getRehabilitationPlan().getBindPath());
      }
      // ���퓮��P���w�����Z(normalAction)�����I���Ȃ�΁A���퓮��P���w�����Z(normalAction)��bindPath���폜����B
      if (!getNormalAction().isSelected()) {
          getValues().remove(getNormalAction().getBindPath());
      }
      // ���n�r���v����Z(rehabilitationPlan2)�����I���Ȃ�΁A���n�r���v����Z(rehabilitationPlan2)��bindPath���폜����B
      if (!getRehabilitationPlan2().isSelected()) {
          getValues().remove(getRehabilitationPlan2().getBindPath());
      }
      // ���퓮��P���w�����Z(normalActionTraning)�����I���Ȃ�΁A���퓮��P���w�����Z(normalActionTraning)��bindPath���폜����B
      if (!getNormalActionTraning().isSelected()) {
          getValues().remove(getNormalActionTraning().getBindPath());
      }
      // �ېH�@�\�Ö@(dinner)�����I���Ȃ�΁A�ېH�@�\�Ö@(dinner)��bindPath���폜����B
      if (!getDinner().isSelected()) {
          getValues().remove(getDinner().getBindPath());
      }
      // ���_�ȍ�ƗÖ@(mindTherapy)�����I���Ȃ�΁A���_�ȍ�ƗÖ@(mindTherapy)��bindPath���폜����B
      if (!getMindTherapy().isSelected()) {
          getValues().remove(getMindTherapy().getBindPath());
      }
      // �F�m�ǘV�l���@���_�Ö@(cognitive)�����I���Ȃ�΁A�F�m�ǘV�l���@���_�Ö@(cognitive)��bindPath���폜����B
      if (!getCognitive().isSelected()) {
          getValues().remove(getCognitive().getBindPath());
      }
/**      //���n�r���̐��������Z(rehabilitationSystem)�����I���Ȃ�΁A���n�r���̐��������Z(rehabilitationSystem)��bindPath���폜����B
      if (!getRehabilitationSystem().isSelected()) {
          getValues().remove(getRehabilitationSystem().getBindPath());
      }
      //���n�r���̐��������Z(rehabilitationSystem2)�����I���Ȃ�΁A���n�r���̐��������Z(rehabilitationSystem2)��bindPath���폜����B
      if (!getRehabilitationSystem2().isSelected()) {
          getValues().remove(getRehabilitationSystem2().getBindPath());
      }
      //���n�r���̐��������Z(rehabilitationSystem3)�����I���Ȃ�΁A���n�r���̐��������Z(rehabilitationSystem3)��bindPath���폜����B
      if (!getRehabilitationSystem3().isSelected()) {
          getValues().remove(getRehabilitationSystem3().getBindPath());
      }
*/
      //�Z���W�����n�r�����Z(concentratedRehabilitation)�����I���Ȃ�΁A�Z���W�����n�r�����Z(concentratedRehabilitation)��bindPath���폜����B
      if (!getConcentratedRehabilitation().isSelected()) {
          getValues().remove(getConcentratedRehabilitation().getBindPath());
      }
      // [CCCX: 04176][Shinobu Hitaka] 2017/07/14 edit begin
//      // �W�c�R�~���j�P�[�V�����Ö@
//      if(!getGroupCommunication().isSelected()) {
//          getValues().remove(getGroupCommunication().getBindPath());
//      }
      // �W�c�R�~���j�P�[�V�����Ö@�R���{(groupCommunicationCombo)�������Ȃ�΁A�W�c�R�~���j�P�[�V�����Ö@�R���{(groupCommunicationCombo)��bindPath���폜����B
      if (!getGroupCommunicationCombo().isSelected()) {
          getValues().remove(getGroupCommunicationCombo().getBindPath());
      }
      // [CCCX: 04176][Shinobu Hitaka] 2017/07/14 edit end
      
      // �F�m�ǒZ���W�����n�r�����Z
      if(!getDementiaShortRehabilitation().isSelected()) {
          getValues().remove(getDementiaShortRehabilitation().getBindPath());
      }
      
      // ���n�r���̐��������Z�R���{(rehabilitationSystem1Combo)�������Ȃ�΁A���n�r���̐��������Z�R���{(rehabilitationSystem1Combo)��bindPath���폜����B
      if (!getRehabilitationSystem1Combo().isSelected()) {
          getValues().remove(getRehabilitationSystem1Combo().getBindPath());
      }
      // ���n�r���̐��������Z�R���{(rehabilitationSystem2Combo)�������Ȃ�΁A���n�r���̐��������Z�R���{(rehabilitationSystem2Combo)��bindPath���폜����B
      if (!getRehabilitationSystem2Combo().isSelected()) {
          getValues().remove(getRehabilitationSystem2Combo().getBindPath());
      }
      // ���n�r���̐��������Z�R���{(rehabilitationSystem3Combo)�������Ȃ�΁A���n�r���̐��������Z�R���{(rehabilitationSystem3Combo)��bindPath���폜����B
      if (!getRehabilitationSystem3Combo().isSelected()) {
          getValues().remove(getRehabilitationSystem3Combo().getBindPath());
      }

      // ���ݒ�ς݂Ƃ��ĕ���B

      // �ݒ�{�^�������������t���O��true�ɂ���B
      setApplied(true);
      // ��ʂ����B
      dispose();
  }

  /**
   * �u���w�Ö@�i�h�j�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void scienceTherapy1ActionPerformed(ActionEvent e) throws Exception{
      // �����w�Ö@�i�h�j�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
      if (getScienceTherapy1().isSelected()) {
          // ���w�Ö@�i�h�j�`�F�b�N(scienceTherapy1)���I������Ă���ꍇ
          // ���w�Ö@�i�h�j�R���{(scienceTherapy1Combo)��L���ɂ���B
          setState_VALID_SCIENCE_THERAPY1();
          // ���w�Ö@�i�h�j�R���{(scienceTherapy1Combo)��1�ڂ̍��ڂ�I������B
          getScienceTherapy1Combo().setSelectedIndex(0);
      } else {
          // ���w�Ö@�i�h�j�`�F�b�N(scienceTherapy1)���I������Ă��Ȃ��ꍇ
          // ���w�Ö@�i�h�j�R���{(scienceTherapy1Combo)�𖳌��ɂ���B
          setState_INVALID_SCIENCE_THERAPY1();
          // ���w�Ö@�i�h�j�R���{(scienceTherapy1Combo)�𖢑I����Ԃɂ���B
          getScienceTherapy1Combo().clearSelection();
      }
  }

  /**
   * �u���w�Ö@�i�h�h�j�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void scienceTherapy2ActionPerformed(ActionEvent e) throws Exception{
      // �����w�Ö@�i�h�h�j�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
      if (getScienceTherapy2().isSelected()) {
          // ���w�Ö@�i�h�h�j�`�F�b�N(scienceTherapy2)���I������Ă���ꍇ
          // ���w�Ö@�i�h�h�j�R���{(scienceTherapy2Combo)��L���ɂ���B
          setState_VALID_SCIENCE_THERAPY2();
          // ���w�Ö@�i�h�h�j�R���{(scienceTherapy2Combo)��1�ڂ̍��ڂ�I������B
          getScienceTherapy2Combo().setSelectedIndex(0);
      } else {
          // ���w�Ö@�i�h�h�j�`�F�b�N(scienceTherapy2)���I������Ă��Ȃ��ꍇ
          // ���w�Ö@�i�h�h�j�R���{(scienceTherapy2Combo)�𖳌��ɂ���B
          setState_INVALID_SCIENCE_THERAPY2();
          // ���w�Ö@�i�h�h�j�R���{(scienceTherapy2Combo)�𖢑I����Ԃɂ���B
          getScienceTherapy2Combo().clearSelection();
      }

  }

  /**
   * �u���w�i�h�j�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void science1ActionPerformed(ActionEvent e) throws Exception{
      // �����w�i�h�j�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
      if (getScience1().isSelected()) {
          // ���w�i�h�j�`�F�b�N(science1)���I������Ă���ꍇ
          // ���w�i�h�j�R���{(science1Combo)��L���ɂ���B
          setState_VALID_SCIENCE1();
          // ���w�i�h�j�R���{(science1Combo)��1�ڂ̍��ڂ�I������B
          getScience1Combo().setSelectedIndex(0);
      } else {
          // ���w�i�h�j�`�F�b�N(science1)���I������Ă��Ȃ��ꍇ
          // ���w�i�h�j�R���{(science1Combo)�𖳌��ɂ���B
          setState_INVALID_SCIENCE1();
          // ���w�i�h�j�R���{(science1Combo)�𖢑I����Ԃɂ���B
          getScience1Combo().clearSelection();
      }
  }

  /**
   * �u���w�i�h�h�j�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void science2ActionPerformed(ActionEvent e) throws Exception{
      // �����w�i�h�h�j�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
      if (getScience2().isSelected()) {
          // ���w�i�h�h�j�`�F�b�N(science2)���I������Ă���ꍇ
          // ���w�i�h�h�j�R���{(science2Combo)��L���ɂ���B
          setState_VALID_SCIENCE2();
          // ���w�i�h�h�j�R���{(science2Combo)��1�ڂ̍��ڂ�I������B
          getScience2Combo().setSelectedIndex(0);
      } else {
          // ���w�i�h�h�j�`�F�b�N(science2)���I������Ă��Ȃ��ꍇ
          // ���w�i�h�h�j�R���{(science2Combo)�𖳌��ɂ���B
          setState_INVALID_SCIENCE2();
          // ���w�i�h�h�j�R���{(science2Combo)�𖢑I����Ԃɂ���B
          getScience2Combo().clearSelection();
      }

  }

  /**
   * �u��ƗÖ@I�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void workTherapy1ActionPerformed(ActionEvent e) throws Exception{
      // ����ƗÖ@�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
      if (getWorkTherapy1().isSelected()) {
          // ��ƗÖ@�`�F�b�N(workTherapy1)���I������Ă���ꍇ
          // ��ƗÖ@�R���{(workTherapy1Combo)��L���ɂ���B
          setState_VALID_WORK_THERAPY1();
          // ��ƗÖ@�R���{(workTherapy1Combo)��1�ڂ̍��ڂ�I������B
          getWorkTherapy1Combo().setSelectedIndex(0);
      } else {
          // ��ƗÖ@�`�F�b�N(workTherapy1)���I������Ă��Ȃ��ꍇ
          // ��ƗÖ@�R���{(workTherapy1Combo)�𖳌��ɂ���B
          setState_INVALID_WORK_THERAPY1();
          // ��ƗÖ@�R���{(workTherapy1Combo)�𖢑I����Ԃɂ���B
          getWorkTherapy1Combo().clearSelection();
      }
  }

  /**
   * �u���(I)�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void work1ActionPerformed(ActionEvent e) throws Exception{
      // ����Ƃ̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
      if (getWork1().isSelected()) {
          // ��ƃ`�F�b�N(work1)���I������Ă���ꍇ
          // ��ƃR���{(work1Combo)��L���ɂ���B
          setState_VALID_WORK1();
          // ��ƃR���{(work1Combo)��1�ڂ̍��ڂ�I������B
          getWork1Combo().setSelectedIndex(0);
      } else {
          // ��ƃ`�F�b�N(work1)���I������Ă��Ȃ��ꍇ
          // ��ƃR���{(work1Combo)�𖳌��ɂ���B
          setState_INVALID_WORK1();
          // ��ƃR���{(work1Combo)�𖢑I����Ԃɂ���B
          getWork1Combo().clearSelection();
      }

  }

  /**
   * �u���꒮�o�Ö@�h�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void languageTherapy1ActionPerformed(ActionEvent e) throws Exception{
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
   * �u���꒮�o(I)�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void language1ActionPerformed(ActionEvent e) throws Exception{
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
   * �u���n�r�������̐����Z�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void rehabilitationSystem1ActionPerformed(ActionEvent e) throws Exception{
      // �����n�r�������̐����Z�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
      if (getRehabilitationSystem1().isSelected()) {
          // ���n�r�������̐����Z�`�F�b�N(rehabilitationSystem1)���I������Ă���ꍇ
          // ���n�r�������̐����Z�R���{(rehabilitationSystem1Combo)��L���ɂ���B
          setState_VALID_RIHABIRI_SYSTEM1();
          // ���n�r�������̐����Z�R���{(rehabilitationSystem1Combo)��1�ڂ̍��ڂ�I������B
          getRehabilitationSystem1Combo().setSelectedIndex(0);
      } else {
          // ���n�r�������̐����Z�`�F�b�N(rehabilitationSystem1)���I������Ă��Ȃ��ꍇ
          // ���n�r�������̐����Z�R���{(rehabilitationSystem1Combo)�𖳌��ɂ���B
          setState_INVALID_RIHABIRI_SYSTEM1();
          // ���n�r�������̐����Z�R���{(rehabilitationSystem1Combo)�𖢑I����Ԃɂ���B
          getRehabilitationSystem1Combo().clearSelection();
      }
  }
  
  /**
   * �u���n�r�������̐����Z�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void rehabilitationSystem2ActionPerformed(ActionEvent e) throws Exception{
      // �����n�r�������̐����Z�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
      if (getRehabilitationSystem2().isSelected()) {
          // ���n�r�������̐����Z�`�F�b�N(rehabilitationSystem1)���I������Ă���ꍇ
          // ���n�r�������̐����Z�R���{(rehabilitationSystem1Combo)��L���ɂ���B
          setState_VALID_RIHABIRI_SYSTEM2();
          // ���n�r�������̐����Z�R���{(rehabilitationSystem1Combo)��1�ڂ̍��ڂ�I������B
          getRehabilitationSystem2Combo().setSelectedIndex(0);
      } else {
          // ���n�r�������̐����Z�`�F�b�N(rehabilitationSystem1)���I������Ă��Ȃ��ꍇ
          // ���n�r�������̐����Z�R���{(rehabilitationSystem1Combo)�𖳌��ɂ���B
          setState_INVALID_RIHABIRI_SYSTEM2();
          // ���n�r�������̐����Z�R���{(rehabilitationSystem1Combo)�𖢑I����Ԃɂ���B
          getRehabilitationSystem2Combo().clearSelection();
      }
  }
  
  /**
   * �u���n�r�������̐����Z�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void rehabilitationSystem3ActionPerformed(ActionEvent e) throws Exception{
      // �����n�r�������̐����Z�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
      if (getRehabilitationSystem3().isSelected()) {
          // ���n�r�������̐����Z�`�F�b�N(rehabilitationSystem1)���I������Ă���ꍇ
          // ���n�r�������̐����Z�R���{(rehabilitationSystem1Combo)��L���ɂ���B
          setState_VALID_RIHABIRI_SYSTEM3();
          // ���n�r�������̐����Z�R���{(rehabilitationSystem1Combo)��1�ڂ̍��ڂ�I������B
          getRehabilitationSystem3Combo().setSelectedIndex(0);
      } else {
          // ���n�r�������̐����Z�`�F�b�N(rehabilitationSystem1)���I������Ă��Ȃ��ꍇ
          // ���n�r�������̐����Z�R���{(rehabilitationSystem1Combo)�𖳌��ɂ���B
          setState_INVALID_RIHABIRI_SYSTEM3();
          // ���n�r�������̐����Z�R���{(rehabilitationSystem1Combo)�𖢑I����Ԃɂ���B
          getRehabilitationSystem3Combo().clearSelection();
      }
  }
  
  /**
   * �u�W�c�R�~���j�P�[�V�����Ö@�̗L����ԕύX�v�C�x���g�ł��B
   * [CCCX: 04176][Shinobu Hitaka] 2017/07/14 add
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void groupCommunicationActionPerformed(ActionEvent e) throws Exception{
      // ���W�c�R�~���j�P�[�V�����Ö@�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
      if (getGroupCommunication().isSelected()) {
          // �W�c�R�~���j�P�[�V�����Ö@�`�F�b�N(getGroupCommunication)���I������Ă���ꍇ
          // �W�c�R�~���j�P�[�V�����Ö@�R���{(getGroupCommunicationCombo)��L���ɂ���B
          setState_VALID_GROUP();
          // �W�c�R�~���j�P�[�V�����Ö@�R���{(getGroupCommunicationCombo)��1�ڂ̍��ڂ�I������B
          getGroupCommunicationCombo().setSelectedIndex(0);
      } else {
          // �W�c�R�~���j�P�[�V�����Ö@�`�F�b�N(getGroupCommunication)���I������Ă��Ȃ��ꍇ
          // �W�c�R�~���j�P�[�V�����Ö@�R���{(getGroupCommunicationCombo)�𖳌��ɂ���B
          setState_INVALID_GROUP();
          // �W�c�R�~���j�P�[�V�����Ö@�R���{(getGroupCommunicationCombo)�𖢑I����Ԃɂ���B
          getGroupCommunicationCombo().clearSelection();
      }
  }
  
  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001S01_201204.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public boolean showModal(int systemServiceKindDetail, VRMap param) throws Exception{
      // ����ʂ̏�����

      setAffairTitle("QS001S03");
      
      // ���R���{�A�C�e���̐ݒ�
      // ������
      // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
      VRMap comboItemMap = new VRHashMap();

      // ���񋟉�
      // �R�[�h�}�X�^�f�[�^���CODE_ID�F109�i���w�Ö@(I)�j���擾����B
      // �擾�����l���AcomboItemMap�� KEY : 109 �� VALUE �Ƃ��Đݒ肷��B
      VRList codes = QkanCommon.getArrayFromMasterCode(109, "3010116");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010117");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010120");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010121");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010126");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010128");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010133");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010135");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010139");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010140");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010141");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010150"); // [CCCX: 04176][Shinobu Hitaka] 2017/07/14 add
      comboItemMap.setData("109", codes);
      // ���R���{�A�C�e���̐ݒ�
      getSpecificConsultationFeePattern().setModelSource(comboItemMap);
      // �R���{�A�C�e����W�J����B
      getSpecificConsultationFeePattern().bindModelSource();

      // ���T�[�r�X�̎�ނɉ����ĕ\�����ڂ𐧌�����B

      switch (systemServiceKindDetail) {
      // ����systemServiceKindDetail�̒l���ȉ��̒Z�������×{���T�[�r�X�̏ꍇ
      // �E204211�F�Z�������×{���(����É@)
      case 204211:
      // �E204311�F���\�h�Z�������×{���(����É@)
      case 204311:
          // �u�������@�f�ÊǗ��E�����v��Ԃɂ���B
          setState_INVALID_BEGINNIGN_GUIDANCE();
          break;
      }

      // �d�x�×{�Ǘ��̍폜
      switch (systemServiceKindDetail) {
      // ����systemServiceKindDetail�̒l���ȉ��̉���É@�T�[�r�X�̏ꍇ
      case 15511:
          // �E15511�F����É@
          //�u�d�x�×{�Ǘ���\���v��Ԃɂ���B
          setState_NOT_DISPLAY_HEAVY_RECUPERATE_GUIDANCE();
          
      }


      // ���ʐf�Ô�ڂ̕\������
      switch (systemServiceKindDetail) {
      // ����systemServiceKindDetail�̒l���ȉ��̒Z�������×{���T�[�r�X�̏ꍇ
      // �E204211�F�Z�������×{���(����É@)
      case 204211:
          // �Z���W�����n�r�����Z -- ��\��
          setState_NOT_DISPLAY_SHORT_RIHA_NO_52();
          // �F�m�ǒZ���W�����n�r�����Z -- ��\��
          setState_NOT_DISPLAY_NINCHI_SHORT_RIHA_NO_55();
          break;

      case 204311: //���\�h�Z�������×{���(����É@)
          // �d�x�×{�Ǘ� -- ��\��
          setState_NOT_DISPLAY_HEAVY_RECUPERATE_GUIDANCE();
          // �Z���W�����n�r�����Z -- ��\��
          setState_NOT_DISPLAY_SHORT_RIHA_NO_52();
          // �F�m�ǒZ���W�����n�r�����Z -- ��\��
          setState_NOT_DISPLAY_NINCHI_SHORT_RIHA_NO_55();
          break;

      case 15511:
          // �E15511�F����É@
          // ���w�Ö@���퓮��P���w�����Z -- ��\��
          setState_NOT_DISPLAY_RIGAKU_ACTION_NO_22();
          // ���w�Ö@���n�r���v����Z -- ��\��
          setState_NOT_DISPLAY_RIGAKU_PLAN_NO_20();
          // ��ƗÖ@���퓮��P���w�����Z -- ��\��
          setState_NOT_DISPLAY_SAGYO_ACTION_NO_29();
          // ��ƗÖ@���n�r���v����Z -- ��\��
          setState_NOT_DISPLAY_SAGYO_PLAN_NO_27();
          break;

      }
      
      // �������œn���ꂽ���ʐf�Ô������ʂɓW�J����B
      // ����param ������ϐ�values�ɐݒ肷��B
      setValues(param);
      // values�̒l����ʂɓW�J����B
      getSpecificConsultationFeePattern().setSource(getValues());
      getSpecificConsultationFeePattern().bindSource();

      // ���R���{�̑I����Ԃ���`�F�b�N�̑I����ԂƃR���{�̗L��������߂�B


      // ���w�Ö@�i�h�j�R���{(scienceTherapy1Combo)���I������Ă���΁A���w�Ö@�i�h�j�`�F�b�N(scienceTherapy1)��I������B
      getScienceTherapy1()
              .setSelected(getScienceTherapy1Combo().isSelected());
      if(getScienceTherapy1().isSelected()){
          setState_VALID_SCIENCE_THERAPY1();
      }
      // ���w�Ö@�i�h�h�j�R���{(scienceTherapy2Combo)���I������Ă���΁A���w�Ö@�i�h�h�j�`�F�b�N(scienceTherapy2)��I������B
      getScienceTherapy2()
              .setSelected(getScienceTherapy2Combo().isSelected());
      if(getScienceTherapy2().isSelected()){
          setState_VALID_SCIENCE_THERAPY2();
      }
      // ���w�i�h�j�R���{(science1Combo)���I������Ă���΁A���w�i�h�j�`�F�b�N(science1)��I������B
      getScience1().setSelected(getScience1Combo().isSelected());
      if(getScience1().isSelected()){
          setState_VALID_SCIENCE1();
      }
      // ���w�i�h�h�j�R���{(science2Combo)���I������Ă���΁A���w�i�h�h�j�`�F�b�N(science2)��I������B
      getScience2().setSelected(getScience2Combo().isSelected());
      if(getScience2().isSelected()){
          setState_VALID_SCIENCE2();
      }
      // ��ƗÖ@�R���{(workTherapy1Combo)���I������Ă���΁A��ƗÖ@�`�F�b�N(workTherapy1)��I������B
      getWorkTherapy1().setSelected(getWorkTherapy1Combo().isSelected());
      if(getWorkTherapy1().isSelected()){
          setState_VALID_WORK_THERAPY1();
      }
      // ��ƃR���{(work1Combo)���I������Ă���΁A��ƃ`�F�b�N(work1)��I������B
      getWork1().setSelected(getWork1Combo().isSelected());
      if(getWork1().isSelected()){
          setState_VALID_WORK1();
      }
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
      
      

      // ���n�r�������̐����Z�R���{(rehabilitationsystem1Combo)���I������Ă���΁A���n�r�������̐����Z�`�F�b�N(rehabilitationsystem1)��I������B
      getRehabilitationSystem1()
              .setSelected(getRehabilitationSystem1Combo().isSelected());
      if(getRehabilitationSystem1().isSelected()){
          setState_VALID_RIHABIRI_SYSTEM1();
      }
      // ���n�r�������̐����Z�R���{(rehabilitationsystem2Combo)���I������Ă���΁A���n�r�������̐����Z�`�F�b�N(rehabilitationsystem2)��I������B
      getRehabilitationSystem2()
              .setSelected(getRehabilitationSystem2Combo().isSelected());
      if(getRehabilitationSystem2().isSelected()){
          setState_VALID_RIHABIRI_SYSTEM2();
      }
      // ���n�r�������̐����Z�R���{(rehabilitationsystem3Combo)���I������Ă���΁A���n�r�������̐����Z�`�F�b�N(rehabilitationsystem3)��I������B
      getRehabilitationSystem3()
              .setSelected(getRehabilitationSystem3Combo().isSelected());
      if(getRehabilitationSystem3().isSelected()){
          setState_VALID_RIHABIRI_SYSTEM3();
      }
      // [CCCX: 04176][Shinobu Hitaka] 2017/07/14 add begin
      // �W�c�R�~���j�P�[�V�����Ö@�R���{(getGroupCommunicationCombo)���I������Ă���΁A�W�c�R�~���j�P�[�V�����Ö@�`�F�b�N(getGroupCommunication)��I������B
      getGroupCommunication()
              .setSelected(getGroupCommunicationCombo().isSelected());
      if(getGroupCommunication().isSelected()){
          setState_VALID_GROUP();
      }
      // [CCCX: 04176][Shinobu Hitaka] 2017/07/14 add end


      setSize(800, 625);
      // ��ʂ�\������B
      setVisible(true);
      
      return getApplied();
  }

  /**
   * �u�Ώۃo�C���h�p�X�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public static String[] getTargetBindPathes(int systemServiceKindDetail) throws Exception{
    // ���T�[�r�X���ƂɑΏۂƂ���o�C���h�p�X���擾
      switch (systemServiceKindDetail) {
      // ����systemServiceKindDetail�̒l���ȉ��̒Z�������×{���T�[�r�X�̏ꍇ
      case 204211:// �Z�������×{���i����É@�j
          return new String[] { "3010101", "3010102", "3010104", "3010105",
                    "3010106", "3010107", "3010108", "3010110", "3010111",
                    "3010112", "3010113", "3010116", "3010117", "3010120",
                    "3010121", "3010124", "3010123", "3010126", "3010128",
                    "3010131", "3010130", "3010133", "3010135", "3010136",
                    "3010137", "3010138", "3010139", "3010140", "3010141",
                    "3010150" };
      case 204311: // ���\�h�Z�������×{���(����É@)
          return new String[] { "3010101", "3010102", "3010105", "3010106",
                    "3010107", "3010108", "3010110", "3010111", "3010112",
                    "3010113", "3010116", "3010117", "3010120", "3010121",
                    "3010124", "3010123", "3010126", "3010128", "3010131",
                    "3010130", "3010133", "3010135", "3010136", "3010137",
                    "3010138", "3010139", "3010140", "3010141", "3010150" };
      case 15511:
          // ����É@
          return new String[] { "3010101", "3010102", "3010103", "3010105",
                    "3010106", "3010107", "3010108", "3010110", "3010111",
                    "3010112", "3010113", "3010116", "3010117", "3010120",
                    "3010121", "3010126", "3010128", "3010133", "3010135",
                    "3010136", "3010137", "3010138", "3010139", "3010140",
                    "3010141", "3010143", "3010150", "3010151" };      
      default:
          return new String[] { "3010101", "3010102", "3010103", "3010104",
                    "3010105", "3010106", "3010107", "3010108", "3010110",
                    "3010111", "3010112", "3010113", "3010116", "3010117",
                    "3010120", "3010121", "3010123", "3010124", "3010126",
                    "3010128", "3010130", "3010131", "3010133", "3010135",
                    "3010136", "3010137", "3010138", "3010139", "3010140",
                    "3010141", "3010143", "3010150" , "3010151" };
      }
  }

}
