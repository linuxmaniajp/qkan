
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
 * �쐬��: 2006/09/06  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �K��Ō�×{��̎����ҏW (012)
 * �v���O���� �K��Ō�×{��̎��� (QP012P01)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp012;
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
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * �K��Ō�×{��̎����C�x���g��`(QP012P01) 
 * ���[��`�̃t�@�C���� �F QP012P01.xml
 */
public abstract class QP012P01Event  {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP012P01Event(){
  }
  /**
   * ������܂��B
   * @param writer ����Ǘ��N���X
   * @param printParam ����p�����^
   * @throws Exception ������O
   */
  public abstract boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception;

  //�ϐ���`

  public static final String NO_MARK = "";
  public static final String CIRCLE = "��";
  public static final String TRIANGLE = "��";
  public static final String DOUBLE_CIRCLE = "��";
  public static final String RHOMBUS = "��";
  public static final String[] CALC_INSURER = new String[] {"BY_INSURER_NAME11","BY_INSURER_NAME12","BY_INSURER_NAME13","BY_INSURER_NAME14","BY_INSURER_NAME15","BY_INSURER_NAME16","BY_INSURER_NAME17","BY_INSURER_NAME18","BY_INSURER_NAME19","BY_INSURER_NAME20"};
  public static final String[] CALC_PATIENT_INSURER = new String[] {"BY_PATIENT_NAME11","BY_PATIENT_NAME12","BY_PATIENT_NAME13","BY_PATIENT_NAME14","BY_PATIENT_NAME15","BY_PATIENT_NAME16","BY_PATIENT_NAME17","BY_PATIENT_NAME18","BY_PATIENT_NAME19","BY_PATIENT_NAME20"};
  //getter/setter

  //�����֐�

  /**
   * �u����p�Ƀf�[�^��ϊ����܂��B�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param printParam VRMap
   * @param key String
   * @throws Exception ������O
   *
   */
  public abstract void convertCalenderData(VRMap printParam, String key) throws Exception;

  /**
   * �u�ł̓��E�O��ϊ����܂��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param printParam VRMap
   * @param key String
   * @throws Exception ������O
   *
   */
  public abstract void convertTax(VRMap printParam, String key) throws Exception;

  /**
   * �u�y�[�W���v�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param printParam VRMap
   * @throws Exception ������O
   *
   */
  public abstract void pageCalc(VRMap printParam) throws Exception;

}
