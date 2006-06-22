
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
 * �쐬��: 2006/04/16  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ��ÊŌ��� (003)
 * �v���O���� ��ÊŌ��� (QU003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu003;
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
 * ��ÊŌ����Ԓ�`(QU003) 
 */
public class QU003State extends QU003Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU003State(){
  }

  /**
   * �u�V�l��Ë��t������s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_OLD_RADIO_FALSE() throws Exception {

        getMedicalInfoOld9AndOld8Radio().setEnabled(false);

  }

  /**
   * �u�V�l��Ë��t������v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_OLD_RADIO_TRUE() throws Exception {

        getMedicalInfoOld9AndOld8Radio().setEnabled(true);

  }

  /**
   * �u��×���ҏW�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_MEDICAL_BUTTON_FALSE() throws Exception {

        getMedicalInfoButtonConpile().setEnabled(false);

        getMedicalInfoButtonDelete().setEnabled(false);

  }

  /**
   * �u��×���ҏW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_MEDICAL_BUTTON_TRUE() throws Exception {

        getMedicalInfoButtonConpile().setEnabled(true);

        getMedicalInfoButtonDelete().setEnabled(true);

  }

  /**
   * �u�Ɩ��{�^����Ԑݒ�i�o�^���[�h�֕ύX�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INSERT_MODE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * �u�Ɩ��{�^����Ԑݒ�i�X�V���[�h�֕ύX�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UPDATE_MODE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

  /**
   * �u�m�[�}���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_ONLY_KOHI() throws Exception {

        getMedicalInfoInsurerNoContena().setEnabled(true);

        getMedicalInfoInsurerName().getParent().setEnabled(true);

        getMedicalInfoMark().getParent().setEnabled(true);

        getMedicalInfoProvideContena().setEnabled(true);

        getMedicalInfoCitiesNoContena().setEnabled(true);

        getMedicalInfoCitiesName().getParent().setEnabled(true);

        getMedicalInfoOldPersonReceiptNo().getParent().setEnabled(true);

  }

  /**
   * �u����P�Ɓv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ONLY_KOHI() throws Exception {

        getMedicalInfoInsurerNoContena().setEnabled(false);

        getMedicalInfoInsurerName().getParent().setEnabled(false);

        getMedicalInfoMark().getParent().setEnabled(false);

        getMedicalInfoProvideContena().setEnabled(false);

        getMedicalInfoCitiesNoContena().setEnabled(false);

        getMedicalInfoCitiesName().getParent().setEnabled(false);

        getMedicalInfoOldPersonReceiptNo().getParent().setEnabled(false);

  }

}
