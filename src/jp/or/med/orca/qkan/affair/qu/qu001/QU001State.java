
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
 * �쐬��: 2005/12/29  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�҈ꗗ (001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu001;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
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
 * ��Ԓ�`(QU001) 
 */
public class QU001State extends QU001Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU001State(){
  }

  /**
   * �u���p�ғo�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INIT_PATIENT() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(true);

        getInsert().setVisible(true);

        getDelete().setVisible(true);

        getPrint().setVisible(true);

        getPlanInsert().setVisible(false);

        getResultInsert().setVisible(false);

        getTargetDate().getParent().setVisible(false);

  }

  /**
   * �u�T�[�r�X�\��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INIT_SERVICE_PLAN() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(false);

        getInsert().setVisible(false);

        getDelete().setVisible(false);

        getPrint().setVisible(false);

        getPlanInsert().setVisible(true);

        getResultInsert().setVisible(false);

        getTargetDate().setVisible(true);

  }

  /**
   * �u�T�[�r�X���сv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INIT_SERVICE_RESULT() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(false);

        getInsert().setVisible(false);

        getDelete().setVisible(false);

        getPrint().setVisible(false);

        getPlanInsert().setVisible(false);

        getResultInsert().setVisible(true);

        getTargetDate().setVisible(true);

  }

  /**
   * �u�K��Ō�v�揑�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INIT_HOMONKANGO_PLAN() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(true);

        getInsert().setVisible(false);

        getDelete().setVisible(false);

        getPrint().setVisible(false);

        getPlanInsert().setVisible(false);

        getResultInsert().setVisible(false);

        getTargetDate().setVisible(true);

  }

  /**
   * �u�K��Ō�񍐏��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INIT_HOMONKANGO_RESULT() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(true);

        getInsert().setVisible(false);

        getDelete().setVisible(false);

        getPrint().setVisible(false);

        getPlanInsert().setVisible(false);

        getResultInsert().setVisible(false);

        getTargetDate().setVisible(true);

  }

  /**
   * �u�K��Ō���񋟏��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INIT_HOMONKANGO_JOHO_TEIKYOSHO() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(true);

        getInsert().setVisible(false);

        getDelete().setVisible(false);

        getPrint().setVisible(false);

        getPlanInsert().setVisible(false);

        getResultInsert().setVisible(false);

        getTargetDate().setVisible(true);

  }

  /**
   * �u�K��Ō�L�^���T�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INIT_HOMONKANGO_KIROKUSHO() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(true);

        getInsert().setVisible(false);

        getDelete().setVisible(false);

        getPrint().setVisible(false);

        getPlanInsert().setVisible(false);

        getResultInsert().setVisible(false);

        getTargetDate().setVisible(true);

  }

  /**
   * �u����K��Ō�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INIT_KYOTAKU() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(true);

        getInsert().setVisible(false);

        getDelete().setVisible(false);

        getPrint().setVisible(false);

        getPlanInsert().setVisible(false);

        getResultInsert().setVisible(false);

        getTargetDate().setVisible(true);

  }

  /**
   * �u�e�[�u���s�I����ԁv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_SELECTED() throws Exception {

        getDetail().setEnabled(true);

        getDelete().setEnabled(true);

        getPrint().setEnabled(true);

        getPlanInsert().setEnabled(true);

        getResultInsert().setEnabled(true);

  }

  /**
   * �u�e�[�u���s���I����ԁv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_UNSELECTED() throws Exception {

        getDetail().setEnabled(false);

        getDelete().setEnabled(false);

        getPlanInsert().setEnabled(false);

        getResultInsert().setEnabled(false);

  }

}
