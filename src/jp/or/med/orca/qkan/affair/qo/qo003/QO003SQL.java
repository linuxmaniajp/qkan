
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
 * �J����: ���Ə��ꗗ
 * �쐬��: 2006/06/02  ���{�R���s���[�^�[������� ���Ə��ꗗ �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��ꗗ (003)
 * �v���O���� ���Ə��ꗗ (QO003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo003;
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
 * ���Ə��ꗗSQL��`(QO003) 
 */
public class QO003SQL extends QO003Design {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO003SQL() {
  }

  /**
   * �u���Ə������擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_PROVIDER(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

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

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" PROVIDER");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" DELETE_FLAG");

    sb.append(" <>");

    sb.append(" 1");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" PROVIDER_TYPE");

    sb.append(" ");

    sb.append(",PROVIDER_ID");

    return sb.toString();
  }

  /**
   * �u���Ə�������������v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_FIND_PROVIDER(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

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

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" PROVIDER");

    conditionStack.push(new Boolean(firstCondition));
    firstCondition = true;

    if(
      VRBindPathParser.has("FIND_PROVIDER_TYPE", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }

    sb.append("(");

    sb.append(" PROVIDER_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TYPE", sqlParam)));

    sb.append(")");

    }

    if(
      VRBindPathParser.has("FIND_PROVIDER_ID", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append("AND");

      }

    sb.append("(");

    sb.append(" PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    }

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append("AND");

      }

    sb.append("(");

    sb.append(" DELETE_FLAG");

    sb.append(" <>");

    sb.append(" 1");

    sb.append(")");

    if(
      VRBindPathParser.has("FIND_PROVIDER_NAME", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append("AND");

      }

    sb.append("(");

    sb.append(" PROVIDER_NAME");

    sb.append(" LIKE");

    sb.append(" ");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_NAME", sqlParam)+"%"));

    sb.append(")");

    }

    firstCondition = ((Boolean)conditionStack.pop()).booleanValue();

    return sb.toString();
  }

  /**
   * �u���Ə������폜����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_DELETE_PROVIDER(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" PROVIDER");

    sb.append(" SET");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

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

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(",PATIENT");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_NINTEI_HISTORY.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_NINTEI_HISTORY.PATIENT_ID");

    sb.append(" =");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT.DELETE_FLAG");

    sb.append(" <>");

    sb.append(" 1");

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�������TABLE�̊Y�����Ə��ԍ����擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_CLAIM(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PROVIDER_ID");

    sb.append(" FROM");

    sb.append(" CLAIM");

    sb.append(",PATIENT");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.PATIENT_ID");

    sb.append(" =");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT.DELETE_FLAG");

    sb.append(" <>");

    sb.append(" 1");

    sb.append(")");

    return sb.toString();
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

    sb.append("  PROVIDER_ID");

    sb.append(", STAFF_ID");

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

    sb.append(" PROVIDER_ID");

    sb.append(" ");

    sb.append(",STAFF_ID");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * �u�T�[�r�X�p�^�[�����擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_SERVICE_PATTEN(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" FIRST 1 SERVICE.SERVICE_USE_TYPE");

    sb.append(" FROM");

    sb.append(" SERVICE");

    sb.append(",PATIENT");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE.PATIENT_ID");

    sb.append(" =");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT.DELETE_FLAG");

    sb.append(" <>");

    sb.append(" 1");

    sb.append(")");

    return sb.toString();
  }

}
