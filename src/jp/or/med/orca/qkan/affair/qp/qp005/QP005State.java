
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
 * �쐬��: 2009/12/10  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���уf�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (005)
 * �v���O���� ���׏��ڍוҏW (QP005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;
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
 * ���׏��ڍוҏW��Ԓ�`(QP005) 
 */
public class QP005State extends QP005Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP005State(){
  }

  /**
   * �u��ԃR���g���[��1�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TYPE1() throws Exception {

        getParticularInfos().setEnabled(false);

        getNyushoInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * �u��ԃR���g���[��2�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TYPE2() throws Exception {

        getParticularInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * �u��ԃR���g���[��3�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TYPE3() throws Exception {

        getShahukuInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * �u��ԃR���g���[��4�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TYPE4() throws Exception {

        getShahukuInfos().setVisible(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(false);

        getSpecialClinicInfoTable().setVisible(true);

  }

  /**
   * �u��ԃR���g���[��5�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TYPE5() throws Exception {

        getParticularInfos().setEnabled(false);

        getNyushoInfos().setEnabled(false);

        getShahukuInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * �u��ԃR���g���[��6�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TYPE6() throws Exception {

        getBasicInfos().setEnabled(false);

        getParticularInfos().setEnabled(false);

        getTotalInfos().setEnabled(false);

        getNyushoInfos().setEnabled(false);

        getShahukuInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(false);

        getKyotakuDetailsInfoTable().setVisible(true);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * �u��ԃR���g���[��7�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TYPE7() throws Exception {

        getServiceDelButton().setEnabled(true);

  }

  /**
   * �u��ԃR���g���[��8�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TYPE8() throws Exception {

        getServiceDelButton().setEnabled(false);

  }

  /**
   * �u��ԃR���g���[��9�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TYPE9() throws Exception {

        getServiceDelButton().setEnabled(false);

        getServiceAddButton().setEnabled(false);

  }

  /**
   * �u��ԃR���g���[��10�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TYPE10() throws Exception {

        getDetailsDelButton().setEnabled(true);

  }

  /**
   * �u��ԃR���g���[��11�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TYPE11() throws Exception {

        getDetailsDelButton().setEnabled(false);

  }

}
