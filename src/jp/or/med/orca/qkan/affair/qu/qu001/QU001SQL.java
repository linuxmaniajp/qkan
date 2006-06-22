
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
 * �J����: ���p�҈ꗗ
 * �쐬��: 2006/04/17  ���{�R���s���[�^�[������� ���p�҈ꗗ �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�҈ꗗ (001)
 * �v���O���� ���p�҈ꗗ (QU001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu001;
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
 * ���p�҈ꗗSQL��`(QU001) 
 */
public class QU001SQL extends QU001State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU001SQL() {
  }

  /**
   * �u���p�҈ꗗ���擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_PATIENT(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(",PATIENT.PATIENT_CODE");

    sb.append(",PATIENT.PATIENT_FAMILY_NAME");

    sb.append(",PATIENT.PATIENT_FIRST_NAME");

    sb.append(",PATIENT.PATIENT_FAMILY_KANA");

    sb.append(",PATIENT.PATIENT_FIRST_KANA");

    sb.append(",PATIENT.PATIENT_SEX");

    sb.append(",PATIENT.PATIENT_BIRTHDAY");

    sb.append(",PATIENT.PATIENT_TEL_FIRST");

    sb.append(",PATIENT.PATIENT_TEL_SECOND");

    sb.append(",PATIENT.PATIENT_TEL_THIRD");

    sb.append(",PATIENT.PATIENT_ZIP_FIRST");

    sb.append(",PATIENT.PATIENT_ZIP_SECOND");

    sb.append(",PATIENT.PATIENT_ADDRESS");

    sb.append(",PATIENT.SHOW_FLAG");

    sb.append(",PATIENT.LAST_TIME");

    sb.append(" FROM");

    sb.append(" PATIENT");

    conditionStack.push(new Boolean(firstCondition));
    firstCondition = true;

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }

    sb.append("(");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(")");

    if(
      VRBindPathParser.has("PATIENT_CODE", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append("AND");

      }

    sb.append("(");

    sb.append(" PATIENT.PATIENT_CODE");

    sb.append(" LIKE");

    sb.append(" ");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_CODE", sqlParam)+"%"));

    sb.append(")");

    }

    if(
      VRBindPathParser.has("PATIENT_KANA", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append("AND");

      }

    sb.append("(");

    sb.append(" CASE WHEN PATIENT.PATIENT_FAMILY_KANA IS NULL THEN PATIENT.PATIENT_FIRST_KANA WHEN PATIENT.PATIENT_FIRST_KANA IS NULL THEN PATIENT.PATIENT_FAMILY_KANA ELSE PATIENT.PATIENT_FAMILY_KANA || PATIENT.PATIENT_FIRST_KANA END");

    sb.append(" LIKE");

    sb.append(" ");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_KANA", sqlParam)+"%"));

    sb.append(")");

    }

    if(
      VRBindPathParser.has("PATIENT_BIRTHDAY", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append("AND");

      }

    sb.append("(");

    sb.append(" PATIENT.PATIENT_BIRTHDAY");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("PATIENT_BIRTHDAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    }

    if(
      VRBindPathParser.has("HIDE_FLAG", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append("AND");

      }

    sb.append("(");

    sb.append(" PATIENT.SHOW_FLAG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    }

    firstCondition = ((Boolean)conditionStack.pop()).booleanValue();

    sb.append(" ORDER BY");

    sb.append(" PATIENT_FAMILY_KANA");

    sb.append(" ASC");

    sb.append(",PATIENT_FIRST_KANA");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * �u���p�ҏ����폜����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_DELETE_PATIENT(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" PATIENT");

    sb.append(" SET");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�p�����[�^���t���_�̗��p�ҔF����擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_NINTEI_NOW(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURED_ID");

    sb.append(",JOTAI_CODE");

    sb.append(",INSURE_VALID_END");

    sb.append(",PROVIDER_ID");

    sb.append(" FROM");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURE_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("NOW_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURE_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("NOW_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" JOTAI_CODE");

    sb.append(" DESC");

    return sb.toString();
  }

  /**
   * �u�p�����[�^���t��薢���̗��p�ҔF��̂������߂̂��̂��擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_NINTEI_FUTURE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURED_ID");

    sb.append(",JOTAI_CODE");

    sb.append(",INSURE_VALID_END");

    sb.append(",PROVIDER_ID");

    sb.append(" FROM");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURE_VALID_START");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" MIN(INSURE_VALID_START)");

    sb.append(" FROM");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURE_VALID_START");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("NOW_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" JOTAI_CODE");

    sb.append(" DESC");

    return sb.toString();
  }

  /**
   * �u�p�����[�^���t���ߋ��̗��p�ҔF��̂������߂̂��̂��擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_NINTEI_PAST(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURED_ID");

    sb.append(",JOTAI_CODE");

    sb.append(",INSURE_VALID_END");

    sb.append(",PROVIDER_ID");

    sb.append(" FROM");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURE_VALID_END");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" MAX(INSURE_VALID_END)");

    sb.append(" FROM");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURE_VALID_END");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("NOW_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" JOTAI_CODE");

    sb.append(" DESC");

    return sb.toString();
  }

}
