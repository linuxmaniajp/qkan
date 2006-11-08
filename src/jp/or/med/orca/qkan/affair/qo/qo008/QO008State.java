
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
 * �J����: ��i�@�a�P
 * �쐬��: 2006/02/18  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ��^���ҏW (008)
 * �v���O���� ��^���ҏW (QO008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo008;
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
 * ��^���ҏW��Ԓ�`(QO008) 
 */
public class QO008State extends QO008Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO008State(){
  }

  /**
   * �u��^�����I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ITEM_UNSELECTED() throws Exception {

        getFixedFormEditInsert().setEnabled(true);

        getFixedFormEditUpdate().setEnabled(false);

        getFixedFormEditDelete().setEnabled(false);

        getFixedFormEditCancelDelete().setEnabled(false);

        getFixedFormEditItemManipulateButtonUp().setEnabled(false);

        getFixedFormEditItemManipulateButtonDown().setEnabled(false);

  }

  /**
   * �u��^���I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ITEM_SELECTED() throws Exception {

        getFixedFormEditInsert().setEnabled(true);

        getFixedFormEditUpdate().setEnabled(true);

        getFixedFormEditDelete().setEnabled(true);

        getFixedFormEditCancelDelete().setEnabled(true);

        getFixedFormEditItemManipulateButtonUp().setEnabled(true);

        getFixedFormEditItemManipulateButtonDown().setEnabled(true);

  }

  /**
   * �u�ҏW�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNEDITABLE() throws Exception {

        getFixedFormEditInsert().setEnabled(false);

        getFixedFormEditUpdate().setEnabled(false);

        getFixedFormEditDelete().setEnabled(false);

        getFixedFormEditCancelDelete().setEnabled(false);

        getFixedFormEditItemManipulateButtonUp().setEnabled(false);

        getFixedFormEditItemManipulateButtonDown().setEnabled(false);

        getFixedFormEditComments().setEnabled(false);

        getFixedFormEditComment1().setEnabled(false);

        getFixedFormEditComment2().setEnabled(false);

        getFixedFormEditItemTable().setEnabled(false);

        getFixedFormEditInputLeft().setEnabled(false);

        getFixedFormEditInputCaption1().setEnabled(false);

        getFixedFormEditInputCaption2().setEnabled(false);

        getFixedFormEditInputCaption3().setEnabled(false);

        getFixedFormEditInputAndCompileTextBox().setEnabled(false);

  }

  /**
   * �u�ҏW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_EDITABLE() throws Exception {

        getFixedFormEditInsert().setEnabled(true);

        getFixedFormEditUpdate().setEnabled(true);

        getFixedFormEditDelete().setEnabled(true);

        getFixedFormEditCancelDelete().setEnabled(true);

        getFixedFormEditItemManipulateButtonUp().setEnabled(true);

        getFixedFormEditItemManipulateButtonDown().setEnabled(true);

        getFixedFormEditComments().setEnabled(true);

        getFixedFormEditComment1().setEnabled(true);

        getFixedFormEditComment2().setEnabled(true);

        getFixedFormEditItemTable().setEnabled(true);

        getFixedFormEditInputLeft().setEnabled(true);

        getFixedFormEditInputCaption1().setEnabled(true);

        getFixedFormEditInputCaption2().setEnabled(true);

        getFixedFormEditInputCaption3().setEnabled(true);

        getFixedFormEditInputAndCompileTextBox().setEnabled(true);

  }

}
