
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
 * �J����: ���Ə��Ǘ�
 * �쐬��: 2006/03/07  ���{�R���s���[�^�[������� ���Ə��Ǘ� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��Ǘ� (004)
 * �v���O���� ���Ə��o�^ (QO004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
 * ���Ə��o�^SQL��`(QO004) 
 */
public class QO004SQL extends QO004State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004SQL() {
  }

  /**
   * �u�X�^�b�t���擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_STAFF(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append("  STAFF_ID");

    sb.append(",CARE_MANAGER_NO");

    sb.append(", STAFF_FAMILY_NAME");

    sb.append(", STAFF_FIRST_NAME");

    sb.append(" FROM");

    sb.append(" STAFF");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" STAFF_ID");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * �u���Ə������擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_INSERT_PROVIDER(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" PROVIDER");

    sb.append("(");

    sb.append(" PROVIDER_ID");

    sb.append(",PROVIDER_TYPE");

    sb.append(",MEDICAL_FLAG");

    sb.append(",PROVIDER_NAME");

    sb.append(",PROVIDER_ZIP_FIRST");

    sb.append(",PROVIDER_ZIP_SECOND");

    sb.append(",PROVIDER_ADDRESS");

    sb.append(",PROVIDER_TEL_FIRST");

    sb.append(",PROVIDER_TEL_SECOND");

    sb.append(",PROVIDER_TEL_THIRD");

    sb.append(",PROVIDER_FAX_FIRST");

    sb.append(",PROVIDER_FAX_SECOND");

    sb.append(",PROVIDER_FAX_THIRD");

    sb.append(",PROVIDER_JIJIGYOUSHO_TYPE");

    sb.append(",PROVIDER_JIGYOU_TYPE");

    sb.append(",PROVIDER_AREA_TYPE");

    sb.append(",SPECIAL_AREA_FLAG");

    sb.append(",PROVIDER_OWNER_NAME");

    sb.append(",BANK_NAME");

    sb.append(",BANK_BRANCH_NAME");

    sb.append(",ACCOUNT_NUMBER");

    sb.append(",ACCOUNT_TYPE");

    sb.append(",ACCOUNT_HOLDER");

    sb.append(",DELETE_FLAG");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TYPE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FLAG", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ZIP_FIRST", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ZIP_SECOND", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ADDRESS", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TEL_FIRST", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TEL_SECOND", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TEL_THIRD", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_FAX_FIRST", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_FAX_SECOND", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_FAX_THIRD", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDER_JIJIGYOUSHO_TYPE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDER_JIGYOU_TYPE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDER_AREA_TYPE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SPECIAL_AREA_FLAG", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_OWNER_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BANK_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BANK_BRANCH_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("ACCOUNT_NUMBER", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ACCOUNT_TYPE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("ACCOUNT_HOLDER", sqlParam)));

    sb.append(",");

    sb.append(" 0");

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u���Ə������X�V����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_UPDATE_PROVIDER(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" PROVIDER");

    sb.append(" SET");

    sb.append(" PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TYPE", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_FLAG");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FLAG", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_NAME", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_ZIP_FIRST");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ZIP_FIRST", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_ZIP_SECOND");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ZIP_SECOND", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_ADDRESS");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ADDRESS", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_TEL_FIRST");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TEL_FIRST", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_TEL_SECOND");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TEL_SECOND", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_TEL_THIRD");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TEL_THIRD", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_FAX_FIRST");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_FAX_FIRST", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_FAX_SECOND");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_FAX_SECOND", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_FAX_THIRD");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_FAX_THIRD", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_JIJIGYOUSHO_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDER_JIJIGYOUSHO_TYPE", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_JIGYOU_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDER_JIGYOU_TYPE", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_AREA_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDER_AREA_TYPE", sqlParam)));

    sb.append(",");

    sb.append(" SPECIAL_AREA_FLAG");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SPECIAL_AREA_FLAG", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_OWNER_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_OWNER_NAME", sqlParam)));

    sb.append(",");

    sb.append(" BANK_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BANK_NAME", sqlParam)));

    sb.append(",");

    sb.append(" BANK_BRANCH_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BANK_BRANCH_NAME", sqlParam)));

    sb.append(",");

    sb.append(" ACCOUNT_NUMBER");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("ACCOUNT_NUMBER", sqlParam)));

    sb.append(",");

    sb.append(" ACCOUNT_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ACCOUNT_TYPE", sqlParam)));

    sb.append(",");

    sb.append(" ACCOUNT_HOLDER");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("ACCOUNT_HOLDER", sqlParam)));

    sb.append(",");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(",");

    sb.append(" LAST_TIME");

    sb.append(" =");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�S���ҏ����폜����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_DELETE_STAFF(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" STAFF");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�S���ҏ���ǉ�����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_INSERT_STAFF(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" STAFF");

    sb.append("(");

    sb.append(" PROVIDER_ID");

    sb.append(",STAFF_ID");

    sb.append(",CARE_MANAGER_NO");

    sb.append(",STAFF_FAMILY_NAME");

    sb.append(",STAFF_FIRST_NAME");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("STAFF_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CARE_MANAGER_NO", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("STAFF_FAMILY_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("STAFF_FIRST_NAME", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u���j���[�}�X�^�������擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_M_MENU(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" MENU_ID");

    sb.append(",BUSINESS_TYPE");

    sb.append(",CAPTION");

    sb.append(" FROM");

    sb.append(" M_MENU");

    return sb.toString();
  }

  /**
   * �u���Ə����j���[����o�^����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_INSERT_PROVIDER_MENU(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" PROVIDER_MENU");

    sb.append("(");

    sb.append(" LOGIN_PROVIDER_ID");

    sb.append(",MENU_ID");

    sb.append(",SHOW_FLAG");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MENU_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SHOW_FLAG", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�v���F�藚��TABLE�̊Y�����Ə��ԍ����擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_PATIENT_NINTEI_HISTORY(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PROVIDER_ID");

    sb.append(" FROM");

    sb.append(" PATIENT");

    sb.append(",PATIENT_NINTEI_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(" =");

    sb.append(" PATIENT_NINTEI_HISTORY.PATIENT_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT.DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_NINTEI_HISTORY.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�T�[�r�XTABLE�i���сj�̊Y�����Ə��ԍ����擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_SERVICE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" SERVICE_ID");

    sb.append(" FROM");

    sb.append(" PATIENT");

    sb.append(",SERVICE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" SERVICE.PATIENT_ID");

    sb.append(" =");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT.DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�w�莖�Ə�ID�����폜�ςݎ��Ə����擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_DELETE_PROVIDER_OF_DUPLICATE_ID(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PROVIDER_ID");

    sb.append(" FROM");

    sb.append(" PROVIDER");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u���Ə����j���[����S���폜����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_DELETE_PROVIDER_MENU(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" PROVIDER_MENU");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" LOGIN_PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u���Ə����j���[�����擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_PROVIDER_MENU(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" LOGIN_PROVIDER_ID");

    sb.append(",MENU_ID");

    sb.append(",SHOW_FLAG");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" PROVIDER_MENU");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" LOGIN_PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u������x�������ԍ��̏����擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_SAME_CARE_MANAGER_NO(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PROVIDER_ID");

    sb.append(",STAFF_ID");

    sb.append(",CARE_MANAGER_NO");

    sb.append(",STAFF_FAMILY_NAME");

    sb.append(",STAFF_FIRST_NAME");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" STAFF");

    conditionStack.push(new Boolean(firstCondition));
    firstCondition = true;

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }

    sb.append("(");

    sb.append(" CARE_MANAGER_NO");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CARE_MANAGER_NO", sqlParam)));

    sb.append(")");

    if(
      VRBindPathParser.has("PROVIDER_ID", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append("AND");

      }

    sb.append("(");

    sb.append(" PROVIDER_ID");

    sb.append(" <>");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    }

    firstCondition = ((Boolean)conditionStack.pop()).booleanValue();

    return sb.toString();
  }

}
