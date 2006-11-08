
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
 * �J����: �񍐏�������
 * �쐬��: 2006/05/17  ���{�R���s���[�^�[������� �񍐏������� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �񍐏������� (002)
 * �v���O���� �񍐏������� (QC002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc002;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.text.*;
import java.io.*;
import java.sql.SQLException;
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
 * �񍐏�������SQL��`(QC002) 
 */
public class QC002SQL extends QC002State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC002SQL() {
  }

  /**
   * �u�Ώۗ��p�҂̑Ώی��̖K��Ō�񍐏����擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_RESULT(VRMap sqlParam) throws Exception{
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

    sb.append(",BYOJO_STATE");

    sb.append(",KANGO_REHA_NAIYO");

    sb.append(",RYOYO_KAIGO_STATE");

    sb.append(",REPORT_COMMENT");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_RESULT");

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
   * �u�Ώۗ��p�҂̑Ώی����O�̖K��Ō�񍐏��̂����A�ŐV�̏����擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_LAST_RESULT(VRMap sqlParam) throws Exception{
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

    sb.append(",BYOJO_STATE");

    sb.append(",KANGO_REHA_NAIYO");

    sb.append(",RYOYO_KAIGO_STATE");

    sb.append(",REPORT_COMMENT");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_RESULT");

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

    sb.append(" HOMONKANGO_RESULT");

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
   * �u�K��Ō�񍐏�����ǉ�����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_INSERT_RESULT(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" HOMONKANGO_RESULT");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(",TARGET_DATE");

    sb.append(",JOTAI_CODE");

    sb.append(",DOCTOR_NAME");

    sb.append(",CREATE_DATE");

    sb.append(",PROVIDER_NAME");

    sb.append(",ADMINISTRATOR_NAME");

    sb.append(",BYOJO_STATE");

    sb.append(",KANGO_REHA_NAIYO");

    sb.append(",RYOYO_KAIGO_STATE");

    sb.append(",REPORT_COMMENT");

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

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BYOJO_STATE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("KANGO_REHA_NAIYO", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("RYOYO_KAIGO_STATE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("REPORT_COMMENT", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�K��Ō�񍐏������X�V����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_UPDATE_RESULT(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" HOMONKANGO_RESULT");

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

    sb.append(" BYOJO_STATE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BYOJO_STATE", sqlParam)));

    sb.append(",");

    sb.append(" KANGO_REHA_NAIYO");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("KANGO_REHA_NAIYO", sqlParam)));

    sb.append(",");

    sb.append(" RYOYO_KAIGO_STATE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("RYOYO_KAIGO_STATE", sqlParam)));

    sb.append(",");

    sb.append(" REPORT_COMMENT");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("REPORT_COMMENT", sqlParam)));

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
   * �u�Ώۗ��p�҂̖K��������폜����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_DELETE_CALENDAR(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" HOMONKANGO_RESULT_CALENDAR");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" VISIT_DATE");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("DATE_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" VISIT_DATE");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("DATE_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�Ώۗ��p�҂̖K�������ǉ�����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_INSERT_CALENDAR(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" HOMONKANGO_RESULT_CALENDAR");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(",VISIT_DATE");

    sb.append(",VISIT_VALUE");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("VISIT_VALUE", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�Ώۗ��p�҂̖K������̃��R�[�h�����擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_CALENDAR_COUNT(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" COUNT(*) AS CALENDAR");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_RESULT_CALENDAR");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" VISIT_DATE");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("DATE_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" VISIT_DATE");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("DATE_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�Ώۗ��p�҂̖K��Ō�X�e�[�V��������TABLE�����擾����v�̂��߂�SQL��Ԃ��܂��B
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

    sb.append(" MEDICAL_FACILITY_ID");

    sb.append(",DOCTOR_NAME");

    sb.append(",SHIJISHO_VALID_START");

    sb.append(",SHIJISHO_VALID_END");

    sb.append(",SPECIAL_SHIJISHO_VALID_START");

    sb.append(",SPECIAL_SHIJISHO_VALID_END");

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

  /**
   * �u�T�[�r�X���т��擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_SERVICE_RESULT_DATA(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" EXTRACT(DAY FROM SERVICE_DATE)");

    sb.append(" AS VISIT_DATE_OF_DAY");

    sb.append(",SERVICE_DATE");

    sb.append(",CASE COUNT(SERVICE_DATE)");

    sb.append(" WHEN");

    sb.append(" 1 THEN 2 WHEN 2THEN 5 ELSE 6 END AS VISIT_VALUE");

    sb.append(",COUNT(SERVICE_DATE)");

    sb.append(" FROM");

    sb.append(" SERVICE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_DATE");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_DATE");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(" IN");

    sb.append(" (11311,20101,16311)");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_USE_TYPE");

    sb.append(" =");

    sb.append(" 6");

    sb.append(")");

    sb.append(" GROUP BY");

    sb.append(" SERVICE_DATE");

    sb.append(" ");

    return sb.toString();
  }

  /**
   * �u�w�����L�����Ԃ̃T�[�r�X���т��擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_SIJISYO_RESULT_DATA(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" EXTRACT(DAY FROM SERVICE_DATE)");

    sb.append(" AS VISIT_DATE_OF_DAY");

    sb.append(",SERVICE_DATE");

    sb.append(",CASE COUNT(SERVICE_DATE)");

    sb.append(" WHEN");

    sb.append(" 1 THEN 3 END AS VISIT_VALUE");

    sb.append(",COUNT(SERVICE_DATE)");

    sb.append(" FROM");

    sb.append(" SERVICE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_DATE");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("SPECIAL_SHIJISHO_VALID_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_DATE");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("SPECIAL_SHIJISHO_VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_DATE");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_DATE");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(" IN");

    sb.append(" (11311,20101,16311)");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_USE_TYPE");

    sb.append(" =");

    sb.append(" 6");

    sb.append(")");

    sb.append(" GROUP BY");

    sb.append(" SERVICE_DATE");

    sb.append(" ");

    return sb.toString();
  }

  /**
   * �u��ʓW�J�p�̃J�����_�[�f�[�^�[���擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_CALENDAR_CUSTOM(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",VISIT_DATE");

    sb.append(",EXTRACT(DAY FROM VISIT_DATE)");

    sb.append(" AS VISIT_DATE_OF_DAY");

    sb.append(",VISIT_VALUE");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_RESULT_CALENDAR");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" VISIT_DATE");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_DATE_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" VISIT_DATE");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_DATE_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�Ώۗ��p�҂̖K��������擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_CALENDAR(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",VISIT_DATE");

    sb.append(",VISIT_VALUE");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_RESULT_CALENDAR");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" VISIT_DATE");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("DATE_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" VISIT_DATE");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("DATE_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

}
