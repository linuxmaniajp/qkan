
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
 * �J����: �v�揑������
 * �쐬��: 2006/01/27  ���{�R���s���[�^�[������� �v�揑������ �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �v�揑������ (001)
 * �v���O���� �v�揑������ (QC001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc001;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.text.*;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
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
 * �v�揑������SQL��`(QC001) 
 */
public class QC001SQL extends QC001State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC001SQL() {
  }

  /**
   * �u�Ώۗ��p�҂̑Ώی��̖K��Ō�v�揑���擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_PLAN(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",TARGET_DATE");

    sb.append(",DOCTOR_NAME");

    sb.append(",JOTAI_CODE");

    sb.append(",CREATE_DATE");

    sb.append(",PROVIDER_NAME");

    sb.append(",ADMINISTRATOR_NAME");

    sb.append(",PLAN_PURPOSE");

    sb.append(",PLAN_COMMENT");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_PLAN");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�Ώۗ��p�҂̑Ώی��ȑO�̖K��Ō�v�揑���̂����A���_�E������̏����擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_PLAN_NOTE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",NOTE_ID");

    sb.append(",NOTE_DATE");

    sb.append(",NOTE_COMMENT");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_PLAN_NOTE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" NOTE_DATE");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * �u�Ώۗ��p�҂̑Ώی����O�̖K��Ō�v�揑�̂����A�ŐV�̏����擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_LAST_PLAN(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",TARGET_DATE");

    sb.append(",JOTAI_CODE");

    sb.append(",DOCTOR_NAME");

    sb.append(",CREATE_DATE");

    sb.append(",PROVIDER_NAME");

    sb.append(",ADMINISTRATOR_NAME");

    sb.append(",PLAN_PURPOSE");

    sb.append(",PLAN_COMMENT");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_PLAN");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" MAX(TARGET_DATE)");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_PLAN");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" <");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u��ʂ̖K��Ō�v�揑����DB�ɒǉ�����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_INSERT_PLAN(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" HOMONKANGO_PLAN");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(",TARGET_DATE");

    sb.append(",JOTAI_CODE");

    sb.append(",DOCTOR_NAME");

    sb.append(",CREATE_DATE");

    sb.append(",PROVIDER_NAME");

    sb.append(",ADMINISTRATOR_NAME");

    sb.append(",PLAN_PURPOSE");

    sb.append(",PLAN_COMMENT");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("JOTAI_CODE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DOCTOR_NAME", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("CREATE_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("ADMINISTRATOR_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PLAN_PURPOSE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PLAN_COMMENT", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�Ώ۔N���ȑO�̖��_�E��������폜����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_DELETE_PLAN_NOTE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" HOMONKANGO_PLAN_NOTE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u���_�E�������ǉ�����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_INSERT_PLAN_NOTE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" HOMONKANGO_PLAN_NOTE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(",NOTE_ID");

    sb.append(",NOTE_DATE");

    sb.append(",NOTE_COMMENT");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("NOTE_ID", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("NOTE_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("NOTE_COMMENT", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u��ʂ̖K��Ō�v�揑����DB���X�V����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_UPDATE_PLAN(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" HOMONKANGO_PLAN");

    sb.append(" SET");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" JOTAI_CODE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("JOTAI_CODE", sqlParam)));

    sb.append(",");

    sb.append(" DOCTOR_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DOCTOR_NAME", sqlParam)));

    sb.append(",");

    sb.append(" CREATE_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("CREATE_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" PROVIDER_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_NAME", sqlParam)));

    sb.append(",");

    sb.append(" ADMINISTRATOR_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("ADMINISTRATOR_NAME", sqlParam)));

    sb.append(",");

    sb.append(" PLAN_PURPOSE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PLAN_PURPOSE", sqlParam)));

    sb.append(",");

    sb.append(" PLAN_COMMENT");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PLAN_COMMENT", sqlParam)));

    sb.append(",");

    sb.append(" LAST_TIME");

    sb.append(" =");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�Ώۗ��p�҂̖K��Ō�v�揑�E�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_NOTE_COUNT(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" COUNT(*) AS NOTE_COUNT");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_PLAN_NOTE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�Ώۗ��p�҂̖K��Ō�X�e�[�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_PATIENT_STATION_HISTORY(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",DOCTOR_NAME");

    sb.append(" FROM");

    sb.append(" PATIENT_STATION_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" STATION_HISTORY_ID");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    return sb.toString();
  }

}
