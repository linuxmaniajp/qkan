
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
 * �J����: �T��@�z��Y
 * �쐬��: 2016/07/13  ���{�R���s���[�^�[������� �T��@�z��Y �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���ʏ��^�T�[�r�X(�݂Ȃ�) (QS001_50511_201504)
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
 * �T�[�r�X�p�^�[���ʏ��^�T�[�r�X(�݂Ȃ�)��Ԓ�`(QS001_50511_201504) 
 */
public class QS001_50511_201504State extends QS001_50511_201504Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_50511_201504State(){
  }

  /**
   * �u�����`�F�b�N�L��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_ON() throws Exception {

        getPrintable().setEnabled(true);

        getCrackOnCntCheck().setEnabled(false);

  }

  /**
   * �u�����`�F�b�N�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_OFF() throws Exception {

        getPrintable().setEnabled(false);

        getCrackOnCntCheck().setEnabled(true);

  }

  /**
   * �u�����@�\����O���[�v�������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_ACTIVITY_ADD() throws Exception {

        getActivityAddRadio().setEnabled(true);
        getActivityAddRadio().getParent().setEnabled(true);

  }

  /**
   * �u�����@�\����O���[�v�������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_ACTIVITY_ADD() throws Exception {

        getActivityAddRadio().setEnabled(false);
        getActivityAddRadio().getParent().setEnabled(false);

  }

  /**
   * �u�^����@�\������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_MOVE_FUNCTION_ADD() throws Exception {

        getMoveFunctionImprovementAddRadio().setEnabled(true);
        getMoveFunctionImprovementAddRadio().getParent().setEnabled(true);

  }

  /**
   * �u�^����@�\������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_MOVE_FUNCTION_ADD() throws Exception {

        getMoveFunctionImprovementAddRadio().setEnabled(false);
        getMoveFunctionImprovementAddRadio().getParent().setEnabled(false);

  }

  /**
   * �u�h�{���P���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NOURISHMENT_ADD() throws Exception {

        getNourishmentImprovementAddRadio().setEnabled(true);
        getNourishmentImprovementAddRadio().getParent().setEnabled(true);

  }

  /**
   * �u�h�{���P���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NOURISHMENT_ADD() throws Exception {

        getNourishmentImprovementAddRadio().setEnabled(false);
        getNourishmentImprovementAddRadio().getParent().setEnabled(false);

  }

  /**
   * �u���o�@�\������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_MOUTH_ADD() throws Exception {

        getMouthFunctionImprovementAddRadio().setEnabled(true);
        getMouthFunctionImprovementAddRadio().getParent().setEnabled(true);

  }

  /**
   * �u���o�@�\������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_MOUTH_ADD() throws Exception {

        getMouthFunctionImprovementAddRadio().setEnabled(false);
        getMouthFunctionImprovementAddRadio().getParent().setEnabled(false);

  }

  /**
   * �u�񐔃`�F�b�N�L��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_COUNT_CHECK_ON() throws Exception {

        getCrackOnDayCheck().setEnabled(true);

  }

  /**
   * �u�񐔃`�F�b�N�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_COUNT_CHECK_OFF() throws Exception {

        getCrackOnDayCheck().setEnabled(false);

  }

  /**
   * �u�ʏ��^�T�[�r�X��E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SERVICE() throws Exception {

        getPreventiveExpertPlaceCareServiceRadio().setEnabled(true);
        getPreventiveExpertPlaceCareServiceRadio().getParent().setEnabled(true);

  }

  /**
   * �u�ʏ��^�T�[�r�X��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SERVICE() throws Exception {

        getPreventiveExpertPlaceCareServiceRadio().setEnabled(false);
        getPreventiveExpertPlaceCareServiceRadio().getParent().setEnabled(false);

  }

}
