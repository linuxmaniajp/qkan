
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
 * �쐬��: 2016/07/19  ���{�R���s���[�^�[������� �T��@�z��Y �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K��^�T�[�r�X�i�݂Ȃ��j (QS001_50111_201504)
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
 * �T�[�r�X�p�^�[���K��^�T�[�r�X�i�݂Ȃ��j��Ԓ�`(QS001_50111_201504) 
 */
public class QS001_50111_201504State extends QS001_50111_201504Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_50111_201504State(){
  }

  /**
   * �u�v�x���P�E���������v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SHIEN1_DAY_CHECK_OFF() throws Exception {

        getPrintable().setEnabled(false);

        getVisitCareExpenseAddRadioItem1().setEnabled(true);

        getVisitCareExpenseAddRadioItem2().setEnabled(true);

        getVisitCareExpenseAddRadioItem3().setEnabled(false);

        getVisitCareExpenseAddRadioItem4().setEnabled(true);

        getVisitCareExpenseAddRadioItem5().setEnabled(true);

        getVisitCareExpenseAddRadioItem6().setEnabled(false);

        getVisitCareExpenseAddRadioItem7().setEnabled(true);

  }

  /**
   * �u�v�x���P�E�����L��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SHIEN1_DAY_CHECK_ON() throws Exception {

        getPrintable().setEnabled(true);

        getVisitCareExpenseAddRadioItem1().setEnabled(true);

        getVisitCareExpenseAddRadioItem2().setEnabled(true);

        getVisitCareExpenseAddRadioItem3().setEnabled(false);

        getVisitCareExpenseAddRadioItem4().setEnabled(false);

        getVisitCareExpenseAddRadioItem5().setEnabled(false);

        getVisitCareExpenseAddRadioItem6().setEnabled(false);

        getVisitCareExpenseAddRadioItem7().setEnabled(false);

  }

  /**
   * �u�v�x���P�ȊO�E���������v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_OTHER_SHIEN1_DAY_CHECK_OFF() throws Exception {

        getPrintable().setEnabled(false);

        getVisitCareExpenseAddRadioItem1().setEnabled(true);

        getVisitCareExpenseAddRadioItem2().setEnabled(true);

        getVisitCareExpenseAddRadioItem3().setEnabled(true);

        getVisitCareExpenseAddRadioItem4().setEnabled(true);

        getVisitCareExpenseAddRadioItem5().setEnabled(true);

        getVisitCareExpenseAddRadioItem6().setEnabled(true);

        getVisitCareExpenseAddRadioItem7().setEnabled(true);

  }

  /**
   * �u�v�x���P�ȊO�E�����L��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_OTHER_SHIEN1_DAY_CHECK_ON() throws Exception {

        getPrintable().setEnabled(true);

        getVisitCareExpenseAddRadioItem1().setEnabled(true);

        getVisitCareExpenseAddRadioItem2().setEnabled(true);

        getVisitCareExpenseAddRadioItem3().setEnabled(true);

        getVisitCareExpenseAddRadioItem4().setEnabled(false);

        getVisitCareExpenseAddRadioItem5().setEnabled(false);

        getVisitCareExpenseAddRadioItem6().setEnabled(false);

        getVisitCareExpenseAddRadioItem7().setEnabled(false);

  }

}
