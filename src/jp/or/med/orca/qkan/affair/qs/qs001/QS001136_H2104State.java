
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
 * �쐬��: 2009/08/26  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�ʏ����n�r���e�[�V���� (QS001136_H2104)
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
 * �T�[�r�X�p�^�[�����\�h�ʏ����n�r���e�[�V������Ԓ�`(QS001136_H2104) 
 */
public class QS001136_H2104State extends QS001136_H2104Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001136_H2104State(){
  }

  /**
   * �u�^����@�\������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_MOVE_FUNCTION_IMPROVEMENT_ENABLE_FALSE() throws Exception {

        getMoveFunctionImprovementAddRadio().setEnabled(false);

  }

  /**
   * �u�^����@�\������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_MOVE_FUNCTION_IMPROVEMENT_ENABLE_TRUE() throws Exception {

        getMoveFunctionImprovementAddRadio().setEnabled(true);

  }

  /**
   * �u�h�{���P���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOURISHMENT_IMPROVEMENT_ENABLE_FALSE() throws Exception {

        getNourishmentImprovementAddRadio().setEnabled(false);

  }

  /**
   * �u�h�{���P���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOURISHMENT_IMPROVEMENT_ENABLE_TRUE() throws Exception {

        getNourishmentImprovementAddRadio().setEnabled(true);

  }

  /**
   * �u���o�@�\������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_MOUTH_FUNCTION_IMPROVEMENT_ENABLE_FALSE() throws Exception {

        getMouthFunctionImprovementAddRadio().setEnabled(false);

  }

  /**
   * �u���o�@�\������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_MOUTH_FUNCTION_IMPROVEMENT_ENABLE_TRUE() throws Exception {

        getMouthFunctionImprovementAddRadio().setEnabled(true);

  }

  /**
   * �u���Ə��]�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_OFFICE_EVALUATION_ENABLE_FALSE() throws Exception {

        getOfficeEvaluationAddRadio().setEnabled(false);

  }

  /**
   * �u���Ə��]�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_OFFICE_EVALUATION_ENABLE_TRUE() throws Exception {

        getOfficeEvaluationAddRadio().setEnabled(true);

  }

  /**
   * �u��N���F�m�Ǘ��p�Ҏ�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);

  }

  /**
   * �u��N���F�m�Ǘ��p�Ҏ�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);

  }

  /**
   * �u�����`�F�b�N�L��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_ON() throws Exception {

        getPrintable().setEnabled(true);

  }

  /**
   * �u�����`�F�b�N�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_OFF() throws Exception {

        getPrintable().setEnabled(false);

  }

}
