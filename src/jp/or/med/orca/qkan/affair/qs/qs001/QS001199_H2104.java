
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
 * �쐬��: 2009/03/03  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� ����f�Ô��� (QS001199_H2104)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * ����f�Ô���(QS001199_H2104) 
 */
public class QS001199_H2104 extends QS001199_H2104Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001199_H2104(){
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
      //���n�r���̐��������Z(rehabilitationSystem)�����I���Ȃ�΁A���n�r���̐��������Z(rehabilitationSystem)��bindPath���폜����B
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
      //�Z���W�����n�r�����Z(concentratedRehabilitation)�����I���Ȃ�΁A�Z���W�����n�r�����Z(concentratedRehabilitation)��bindPath���폜����B
      if (!getConcentratedRehabilitation().isSelected()) {
          getValues().remove(getConcentratedRehabilitation().getBindPath());
      }
      // �W�c�R�~���j�P�[�V�����Ö@
      if(!getGroupCommunication().isSelected()) {
          getValues().remove(getGroupCommunication().getBindPath());
      }
      
      // �F�m�ǒZ���W�����n�r�����Z
      if(!getDementiaShortRehabilitation().isSelected()) {
          getValues().remove(getDementiaShortRehabilitation().getBindPath());
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

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001199_H2104.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public boolean showModal(int systemServiceKindDetail, VRMap param) throws Exception{
      // ����ʂ̏�����

      setAffairTitle("QS001028");
      
      // ���R���{�A�C�e���̐ݒ�
      // ������
      // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
      VRMap comboItemMap = new VRHashMap();

      // ���H����
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
      comboItemMap.setData("109", codes);
      // ���R���{�A�C�e���̐ݒ�
      getSpecificConsultationFeePattern().setModelSource(comboItemMap);
      // �R���{�A�C�e����W�J����B
      getSpecificConsultationFeePattern().bindModelSource();

      // ���T�[�r�X�̎�ނɉ����ĕ\�����ڂ𐧌�����B

      switch (systemServiceKindDetail) {
      // ����systemServiceKindDetail�̒l���ȉ��̒Z�������×{���T�[�r�X�̏ꍇ
      // �E12201�F�Z�������×{���(�V��)
      case 12201:
      case 12211:
      // �E12301�F�Z�������×{���(�×{�a����L����a�@)
      case 12301:
      case 12311:
      // �E12302�F�Z�������×{���(�×{�a����L����f�Ï�)
      case 12302:
      case 12312:
      // �E12303�F�Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@)
      case 12303:
      case 12313:
      // �E12304�F�Z�������×{���(��K���f�Ï�)
      case 12304:
      case 12314:
      case 12511: //���\�h�Z�������×{���i�V���j
      case 12611: //���\�h�Z�������×{���i�a�@�j
      case 12612: //���\�h�Z�������×{���i�f�Ï��j
      case 12613: //���\�h�Z�������×{���i�F�m�ǎ����^�j
          // �u�������@�f�ÊǗ��E�����v��Ԃɂ���B
          setState_INVALID_BEGINNIGN_GUIDANCE();
          break;
      }
      
      switch(systemServiceKindDetail) {
      // �E12301�F�Z�������×{���(�×{�a����L����a�@)
      case 12301:
      case 12311:
      // �E12302�F�Z�������×{���(�×{�a����L����f�Ï�)
      case 12302:
      case 12312:
      case 12611: // ���\�h�Z�������×{���i�a�@�j
      case 12612: // ���\�h�Z�������×{���i�f�Ï��j
      case 15311: // ���×{�^��Î{��(�×{�a����L����a�@)
      case 15312: // ���×{�^��Î{��(�×{�a����L����f�Ï�)
          setState_DISPLAY_DEMENTIA_SHORT_REHA();
          setState_DISPLAY_GROUP();
          break;
      default:
          setState_NOT_DISPLAY_DEMENTIA_SHORT_REHA();
          setState_NOT_DISPLAY_GROUP();
          break;
      }
      boolean sizeDown = false;
      // [ID:0000499][Masahiko Higuchi] 2009/04/30 add begin �y����f�Ô�z����21�N4���ȍ~�̔F�m�ǒZ���W�����n�̕\��
      boolean sizeDownMedicalNinchi = false;
      // [ID:0000499][Masahiko Higuchi] 2009/04/30 add end
      switch (systemServiceKindDetail) {
      // ����systemServiceKindDetail�̒l���ȉ��̘V�l���F�m�ǎ����×{�a���T�[�r�X�̏ꍇ
      case 12303:
      case 12313:
      // �E12303�F�Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@)
      case 15303:
      case 15313:
          // �E15303�F���×{�^��Î{��(�V�l���F�m�ǎ����×{�a����L����a�@)
      case 12613: //���\�h�Z�������×{���i�F�m�ǎ����^�j
          // [ID:0000499][Masahiko Higuchi] 2009/04/30 replace begin �y����f�Ô�z����21�N4���ȍ~�̔F�m�ǒZ���W�����n�̕\��
          // ���×{�^��Î{�݁i�F�m�ǎ����^�j�ʐ���
          switch(systemServiceKindDetail){
          case 15303:
          case 15313:
              setState_DISPLAY_MEDICAL_OLD_COGNITIVE_STATE();
              // ��p�̉�ʐ���t���O��L���ɂ���
              sizeDownMedicalNinchi = true;
              break;
          default:
              // �u�V�l���F�m�ǎ����×{�a���v��Ԃɂ���B
              setState_OLD_COGNITIVE_WARD();
              sizeDown = true;
          }
          // [ID:0000499][Masahiko Higuchi] 2009/04/30 replace end
          break;
      }

      // [ID:0000495][Tozo TANAKA] 2009/04/28 add begin �y����f�Ô�z����21�N4���ȍ~�̏d�x�×{�Ǘ��̍폜
      // [ID:0000499][Masahiko Higuchi] 2009/04/30 add begin �y����f�Ô�z����21�N4���ȍ~�̔F�m�ǒZ���W�����n�̕\��
      switch (systemServiceKindDetail) {
      // ����systemServiceKindDetail�̒l���ȉ��̉��×{�^��Î{�݃T�[�r�X�̏ꍇ
      case 15311:
            // �E15311�F���×{�^��Î{��(�×{�a����L����a�@)
      case 15312:
            // �E15312�F���×{�^��Î{��(�×{�a����L����f�Ï�)
      case 15303:
      case 15313:
            // �E15313�F���×{�^��Î{��(�V�l���F�m�ǎ����×{�a����L����a�@);
          //�u�d�x�×{�Ǘ���\���v��Ԃɂ���B
          setState_NOT_DISPLAY_HEAVY_RECUPERATE_GUIDANCE();
          // �F�m�ǒZ���W�����n�̕\��
          setState_DISPLAY_DEMENTIA_SHORT_REHA();
      }
      // [ID:0000495][Tozo TANAKA] 2009/04/28 add end �y����f�Ô�z����21�N4���ȍ~�̏d�x�×{�Ǘ��̍폜
      // [ID:0000499][Masahiko Higuchi] 2009/04/30 add end
      
      // �������œn���ꂽ����f�Ô������ʂɓW�J����B
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
      
      if(sizeDown){
          setSize(600, 280);
      }else{
          setSize(800, 605);
      }

      // [ID:0000499][Masahiko Higuchi] 2009/04/30 add begin �y����f�Ô�z����21�N4���ȍ~�̔F�m�ǒZ���W�����n�̕\��
      // ���×{�^��Î{�݁i�F�m�ǎ����^�j�̏ꍇ
      if(sizeDownMedicalNinchi) {
          setSize(600, 385);
      }
      // [ID:0000499][Masahiko Higuchi] 2009/04/30 add end

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
      case 12201:// �Z�������×{���(�V��)
      case 12211:
      case 12301:// �Z�������×{���i�a�@�×{�j
      case 12311:
      case 12302:// �Z�������×{���i�f�Ï��×{�j
      case 12312:
      case 12304:// �Z�������×{���(��K���f�Ï�)
      case 12314:
      case 12511: //���\�h�Z�������×{���i�V���j
      case 12611: //���\�h�Z�������×{���i�a�@�j
      case 12612: //���\�h�Z�������×{���i�f�Ï��j
          return new String[] { "3010101", "3010102", "3010104", "3010105",
                    "3010106", "3010107", "3010108", "3010110", "3010111",
                    "3010112", "3010113", "3010116", "3010117", "3010120",
                    "3010121", "3010123", "3010124", "3010126", "3010128",
                    "3010130", "3010131", "3010133", "3010135", "3010136",
                    "3010137", "3010138", "3010139", "3010140", "3010141",
                    "3010143", "3010150" , "3010151" };
      // ����systemServiceKindDetail�̒l���ȉ��̒Z�������×{��삩�V�l���F�m�ǎ����×{�a���T�[�r�X�̏ꍇ
      case 12303:// �Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@)
      case 12313:
      case 12613: //���\�h�Z�������×{���i�F�m�ǎ����^�j
          return new String[] { "3010101", "3010102", "3010104", "3010137",
                  "3010138", };
      // ����systemServiceKindDetail�̒l���ȉ��̘V�l���F�m�ǎ����×{�a���T�[�r�X�̏ꍇ
      case 15303:// ���×{�^��Î{��(�V�l���F�m�ǎ����×{�a����L����a�@)
      case 15313:
          // [ID:0000495][Tozo TANAKA] 2009/04/28 replace begin �y����f�Ô�z����21�N4���ȍ~�̏d�x�×{�Ǘ��̍폜
          // [ID:0000499][Masahiko Higuchi] 2009/04/30 replace begin �y����f�Ô�z����21�N4���ȍ~�̔F�m�ǒZ���W�����n�̕\��
//          return new String[] { "3010101", "3010102", "3010103", "3010104",
//                  "3010137", "3010138", };
          return new String[] { "3010101", "3010102", "3010103", 
                  "3010137", "3010138", "3010151" };
          // [ID:0000499][Masahiko Higuchi] 2009/04/30 replace end
      case 15311:
          //���×{�^��Î{��(�×{�a����L����a�@)
      case 15312:
          //���×{�^��Î{��(�×{�a����L����f�Ï�)
          return new String[] { "3010101", "3010102", "3010103", 
                  "3010105", "3010106", "3010107", "3010108", "3010110",
                  "3010111", "3010112", "3010113", "3010116", "3010117",
                  "3010120", "3010121", "3010123", "3010124", "3010126",
                  "3010128", "3010130", "3010131", "3010133", "3010135",
                  "3010136", "3010137", "3010138", "3010139", "3010140",
                  "3010141", "3010143", "3010150" , "3010151" };
          // [ID:0000495][Tozo TANAKA] 2009/04/28 replace end �y����f�Ô�z����21�N4���ȍ~�̏d�x�×{�Ǘ��̍폜
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
