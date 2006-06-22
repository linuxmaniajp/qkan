
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
 * �쐬��: 2006/03/03  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ����E���Ə�� (004)
 * �v���O���� ����E���Ə�� (QU004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu004;
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
import jp.or.med.orca.qkan.lib.*;
/**
 * ����E���Ə���Ԓ�`(QU004) 
 */
public class QU004State extends QU004Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU004State(){
  }

  /**
   * �u������ҏW�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_KAIGO_BUTTON_FALSE() throws Exception {

        getKaigoInfoButtonConpile().setEnabled(false);

        getKaigoInfoButtonDelete().setEnabled(false);

  }

  /**
   * �u������ҏW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_KAIGO_BUTTON_TRUE() throws Exception {

        getKaigoInfoButtonConpile().setEnabled(true);

        getKaigoInfoButtonDelete().setEnabled(true);

  }

  /**
   * �u��Ì���ҏW�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_IRYO_BUTTON_FALSE() throws Exception {

        getIryoInfoButtonConpile().setEnabled(false);

        getIryoInfoButtonDelete().setEnabled(false);

  }

  /**
   * �u��Ì���ҏW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_IRYO_BUTTON_TRUE() throws Exception {

        getIryoInfoButtonConpile().setEnabled(true);

        getIryoInfoButtonDelete().setEnabled(true);

  }

  /**
   * �u�Ɩ��{�^���ݒ�i�o�^���[�h�֕ύX�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INSERT_MODE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * �u�Ɩ��{�^���ݒ�i�X�V���[�h�֕ύX�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UPDATE_MODE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

  /**
   * �u���t���ҏW�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_EDITABLE_BENEFIT_RATE_FALSE() throws Exception {

  }

  /**
   * �u���t���ҏW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_EDITABLE_BENEFIT_RATE_TRUE() throws Exception {

  }

  /**
   * �u�Љ�����ƕҏW�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_SHAHUKU_BUTTON_FALSE() throws Exception {

        getShahukuInfoButtonConpile().setEnabled(false);

        getShahukuInfoButtonDelete().setEnabled(false);

  }

  /**
   * �u�Љ�����ƕҏW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_SHAHUKU_BUTTON_TRUE() throws Exception {

        getShahukuInfoButtonConpile().setEnabled(true);

        getShahukuInfoButtonDelete().setEnabled(true);

  }

}
