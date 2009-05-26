
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
 * �쐬��: 2009/04/30  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X ����f�Ô��� (001)
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
/**
 * ����f�Ô��ʏ�Ԓ�`(QS001199_H2104) 
 */
public class QS001199_H2104State extends QS001199_H2104Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001199_H2104State(){
  }

  /**
   * �u�V�l���F�m�ǎ����×{�a���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_OLD_COGNITIVE_WARD() throws Exception {

        if(getParticularInstitutionManagment().getParent()!=null){
          getParticularInstitutionManagment().getParent().remove(getParticularInstitutionManagment());
        }

        if(getParticularInstitutionManagmentPrivateRoom().getParent()!=null){
          getParticularInstitutionManagmentPrivateRoom().getParent().remove(getParticularInstitutionManagmentPrivateRoom());
        }

        if(getParticularInstitutionManagmentPrivateRoom2().getParent()!=null){
          getParticularInstitutionManagmentPrivateRoom2().getParent().remove(getParticularInstitutionManagmentPrivateRoom2());
        }

        if(getHeavySkinManegement().getParent()!=null){
          getHeavySkinManegement().getParent().remove(getHeavySkinManegement());
        }

        if(getMedicineManegementLeading().getParent()!=null){
          getMedicineManegementLeading().getParent().remove(getMedicineManegementLeading());
        }

        if(getSpecialMedicineManagementLeading().getParent()!=null){
          getSpecialMedicineManagementLeading().getParent().remove(getSpecialMedicineManagementLeading());
        }

        if(getMedicalScienceInfo1().getParent()!=null){
          getMedicalScienceInfo1().getParent().remove(getMedicalScienceInfo1());
        }

        if(getMedicalScienceInfo2().getParent()!=null){
          getMedicalScienceInfo2().getParent().remove(getMedicalScienceInfo2());
        }

        if(getScienceTherapy().getParent()!=null){
          getScienceTherapy().getParent().remove(getScienceTherapy());
        }

        if(getWorkTherapyFrame().getParent()!=null){
          getWorkTherapyFrame().getParent().remove(getWorkTherapyFrame());
        }

        if(getEtcFrame().getParent()!=null){
          getEtcFrame().getParent().remove(getEtcFrame());
        }

  }

  /**
   * �u�������@�f�ÊǗ��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_BEGINNIGN_GUIDANCE() throws Exception {

        if(getBeginningGuidanceManagement().getParent()!=null){
          getBeginningGuidanceManagement().getParent().remove(getBeginningGuidanceManagement());
        }

  }

  /**
   * �u���w�Ö@�i�h�j�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SCIENCE_THERAPY1() throws Exception {

        getScienceTherapy1Combo().setEnabled(false);

  }

  /**
   * �u���w�Ö@�i�h�j�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SCIENCE_THERAPY1() throws Exception {

        getScienceTherapy1Combo().setEnabled(true);

  }

  /**
   * �u���w�Ö@�i�h�h�j�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SCIENCE_THERAPY2() throws Exception {

        getScienceTherapy2Combo().setEnabled(false);

  }

  /**
   * �u���w�Ö@�i�h�h�j�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SCIENCE_THERAPY2() throws Exception {

        getScienceTherapy2Combo().setEnabled(true);

  }

  /**
   * �u���w�i�h�j�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SCIENCE1() throws Exception {

        getScience1Combo().setEnabled(false);

  }

  /**
   * �u���w�i�h�j�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SCIENCE1() throws Exception {

        getScience1Combo().setEnabled(true);

  }

  /**
   * �u���w�i�h�h�j�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SCIENCE2() throws Exception {

        getScience2Combo().setEnabled(false);

  }

  /**
   * �u���w�i�h�h�j�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SCIENCE2() throws Exception {

        getScience2Combo().setEnabled(true);

  }

  /**
   * �u��ƗÖ@I�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_WORK_THERAPY1() throws Exception {

        getWorkTherapy1Combo().setEnabled(false);

  }

  /**
   * �u��ƗÖ@I�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_WORK_THERAPY1() throws Exception {

        getWorkTherapy1Combo().setEnabled(true);

  }

  /**
   * �u���I�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_WORK1() throws Exception {

        getWork1Combo().setEnabled(false);

  }

  /**
   * �u���I�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_WORK1() throws Exception {

        getWork1Combo().setEnabled(true);

  }

  /**
   * �u���꒮�o�Ö@�h�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_LANGUAGE_THERAPY1() throws Exception {

        getLanguageTherapy1Combo().setEnabled(false);

  }

  /**
   * �u���꒮�o�Ö@�h�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_LANGUAGE_THERAPY1() throws Exception {

        getLanguageTherapy1Combo().setEnabled(true);

  }

  /**
   * �u���꒮�o(I)�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_LANGUAGE1() throws Exception {

        getLanguage1Combo().setEnabled(false);

  }

  /**
   * �u���꒮�o(I)�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_LANGUAGE1() throws Exception {

        getLanguage1Combo().setEnabled(true);

  }

  /**
   * �u�W�c�R�~���j�P�[�V�����E��\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_DISPLAY_GROUP() throws Exception {

        getGroupCommunication().setVisible(false);

  }

  /**
   * �u�W�c�R�~���j�P�[�V�����E�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DISPLAY_GROUP() throws Exception {

        getGroupCommunication().setVisible(true);

  }

  /**
   * �u�F�m�ǒZ���W�����n�r�����Z�E��\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_DISPLAY_DEMENTIA_SHORT_REHA() throws Exception {

        getDementiaShortRehabilitation().setVisible(false);

  }

  /**
   * �u�F�m�ǒZ���W�����n�r�����Z�E�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DISPLAY_DEMENTIA_SHORT_REHA() throws Exception {

        getDementiaShortRehabilitation().setVisible(true);

  }

  /**
   * �u�d�x�×{�Ǘ��E��\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_DISPLAY_HEAVY_RECUPERATE_GUIDANCE() throws Exception {

        getHeavyRecuperateGuidanceManagement().setVisible(false);

  }

  /**
   * �u�d�x�×{�Ǘ��E�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DISPLAY_HEAVY_RECUPERATE_GUIDANCE() throws Exception {

        getHeavyRecuperateGuidanceManagement().setVisible(true);

  }

  /**
   * �u���×{�^��Î{�݁i�F�m�ǁj�E�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DISPLAY_MEDICAL_OLD_COGNITIVE_STATE() throws Exception {

        if(getParticularInstitutionManagment().getParent()!=null){
          getParticularInstitutionManagment().getParent().remove(getParticularInstitutionManagment());
        }

        if(getParticularInstitutionManagmentPrivateRoom().getParent()!=null){
          getParticularInstitutionManagmentPrivateRoom().getParent().remove(getParticularInstitutionManagmentPrivateRoom());
        }

        if(getParticularInstitutionManagmentPrivateRoom2().getParent()!=null){
          getParticularInstitutionManagmentPrivateRoom2().getParent().remove(getParticularInstitutionManagmentPrivateRoom2());
        }

        if(getHeavySkinManegement().getParent()!=null){
          getHeavySkinManegement().getParent().remove(getHeavySkinManegement());
        }

        if(getMedicineManegementLeading().getParent()!=null){
          getMedicineManegementLeading().getParent().remove(getMedicineManegementLeading());
        }

        if(getSpecialMedicineManagementLeading().getParent()!=null){
          getSpecialMedicineManagementLeading().getParent().remove(getSpecialMedicineManagementLeading());
        }

        if(getMedicalScienceInfo1().getParent()!=null){
          getMedicalScienceInfo1().getParent().remove(getMedicalScienceInfo1());
        }

        if(getMedicalScienceInfo2().getParent()!=null){
          getMedicalScienceInfo2().getParent().remove(getMedicalScienceInfo2());
        }

        if(getScienceTherapy().getParent()!=null){
          getScienceTherapy().getParent().remove(getScienceTherapy());
        }

        if(getWorkTherapyFrame().getParent()!=null){
          getWorkTherapyFrame().getParent().remove(getWorkTherapyFrame());
        }

        if(getGroupCommunication().getParent()!=null){
          getGroupCommunication().getParent().remove(getGroupCommunication());
        }

        getDementiaShortRehabilitation().setVisible(true);

        if(getLanguageTherapy1Conteiner().getParent()!=null){
          getLanguageTherapy1Conteiner().getParent().remove(getLanguageTherapy1Conteiner());
        }

        if(getLanguage1Conteiner().getParent()!=null){
          getLanguage1Conteiner().getParent().remove(getLanguage1Conteiner());
        }

        if(getRehabilitationSystem3().getParent()!=null){
          getRehabilitationSystem3().getParent().remove(getRehabilitationSystem3());
        }

        if(getDinner().getParent()!=null){
          getDinner().getParent().remove(getDinner());
        }

        if(getConcentratedRehabilitation().getParent()!=null){
          getConcentratedRehabilitation().getParent().remove(getConcentratedRehabilitation());
        }

  }

}
