
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
 * �쐬��: 2018/02/16  ���{�R���s���[�^�[�������  �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X ���ʐf�Ô��� (001)
 * �v���O���� ����f�Ô��� (QS001S03_201804)
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
 * ����f�Ô��ʏ�Ԓ�`(QS001S03_201804) 
 */
public class QS001S03_201804State extends QS001S03_201804Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001S03_201804State(){
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
   * �u���w�Ö@���퓮��P���w�����Z�E��\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_DISPLAY_RIGAKU_ACTION_NO_22() throws Exception {

        getNormalAction().setVisible(false);

  }

  /**
   * �u���w�Ö@���퓮��P���w�����Z�E�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DISPLAY_RIGAKU_ACTION_NO_22() throws Exception {

        getNormalAction().setVisible(true);

  }

  /**
   * �u���w�Ö@���n�r���v����Z�E��\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_DISPLAY_RIGAKU_PLAN_NO_20() throws Exception {

        getRehabilitationPlan().setVisible(false);

  }

  /**
   * �u���w�Ö@���n�r���v����Z�E�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DISPLAY_RIGAKU_PLAN_NO_20() throws Exception {

        getRehabilitationPlan().setVisible(true);

  }

  /**
   * �u��ƗÖ@���퓮��P���w�����Z�E��\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_DISPLAY_SAGYO_ACTION_NO_29() throws Exception {

        getNormalActionTraning().setVisible(false);

  }

  /**
   * �u��ƗÖ@���퓮��P���w�����Z�E�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DISPLAY_SAGYO_ACTION_NO_29() throws Exception {

        getNormalActionTraning().setVisible(true);

  }

  /**
   * �u��ƗÖ@���n�r���v����Z�E��\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_DISPLAY_SAGYO_PLAN_NO_27() throws Exception {

        getRehabilitationPlan2().setVisible(false);

  }

  /**
   * �u��ƗÖ@���n�r���v����Z�E�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DISPLAY_SAGYO_PLAN_NO_27() throws Exception {

        getRehabilitationPlan2().setVisible(true);

  }

  /**
   * �u�Z���W�����n�r�����Z�E��\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_DISPLAY_SHORT_RIHA_NO_52() throws Exception {

        getConcentratedRehabilitation().setVisible(false);

  }

  /**
   * �u�Z���W�����n�r�����Z�E�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DISPLAY_SHORT_RIHA_NO_52() throws Exception {

        getConcentratedRehabilitation().setVisible(true);

  }

  /**
   * �u�F�m�ǒZ���W�����n�r�����Z�E��\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_DISPLAY_NINCHI_SHORT_RIHA_NO_55() throws Exception {

        getDementiaShortRehabilitation().setVisible(false);

  }

  /**
   * �u�F�m�ǒZ���W�����n�r�����Z�E�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DISPLAY_NINCHI_SHORT_RIHA_NO_55() throws Exception {

        getDementiaShortRehabilitation().setVisible(true);

  }

  /**
   * �u���n�r���̐��������Z�i���w�j�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_RIHABIRI_SYSTEM1() throws Exception {

        getRehabilitationSystem1Combo().setEnabled(false);

  }

  /**
   * �u���n�r���̐��������Z�i���w�j�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_RIHABIRI_SYSTEM1() throws Exception {

        getRehabilitationSystem1Combo().setEnabled(true);

  }

  /**
   * �u���n�r���̐��������Z�i��Ɓj�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_RIHABIRI_SYSTEM2() throws Exception {

        getRehabilitationSystem2Combo().setEnabled(false);

  }

  /**
   * �u���n�r���̐��������Z�i��Ɓj�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_RIHABIRI_SYSTEM2() throws Exception {

        getRehabilitationSystem2Combo().setEnabled(true);

  }

  /**
   * �u���n�r���̐��������Z�i����j�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_RIHABIRI_SYSTEM3() throws Exception {

        getRehabilitationSystem3Combo().setEnabled(false);

  }

  /**
   * �u���n�r���̐��������Z�i����j�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_RIHABIRI_SYSTEM3() throws Exception {

        getRehabilitationSystem3Combo().setEnabled(true);

  }

  /**
   * �u�W�c�R�~���j�P�[�V�����E��\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_GROUP() throws Exception {

        getGroupCommunicationCombo().setEnabled(false);

  }

  /**
   * �u�W�c�R�~���j�P�[�V�����E�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_GROUP() throws Exception {

        getGroupCommunicationCombo().setEnabled(true);

  }

}
