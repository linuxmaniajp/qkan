
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
 * �J����: ��Ë@�֊Ǘ�
 * �쐬��: 2006/04/17  ���{�R���s���[�^�[������� ��Ë@�֊Ǘ� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ��Ë@�֊Ǘ� (009)
 * �v���O���� ��Ë@�ֈꗗ (QO009)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo009;
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
 * ��Ë@�ֈꗗSQL��`(QO009) 
 */
public class QO009SQL extends QO009State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO009SQL() {
  }

  /**
   * �u��Ë@�֏��擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_MEDICAL_FACILITY(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" MEDICAL_FACILITY_ID");

    sb.append(",MEDICAL_FACILITY_NAME");

    sb.append(",MEDICAL_FACILITY_TEL_FIRST");

    sb.append(",MEDICAL_FACILITY_TEL_SECOND");

    sb.append(",MEDICAL_FACILITY_TEL_THIRD");

    sb.append(",MEDICAL_FACILITY_ZIP_FIRST");

    sb.append(",MEDICAL_FACILITY_ZIP_SECOND");

    sb.append(",MEDICAL_FACILITY_ADDRESS");

    sb.append(",MEDICAL_FACILITY_FAX_FIRST");

    sb.append(",MEDICAL_FACILITY_FAX_SECOND");

    sb.append(",MEDICAL_FACILITY_FAX_THIRD");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" MEDICAL_FACILITY");

    conditionStack.push(new Boolean(firstCondition));
    firstCondition = true;

    if(
      VRBindPathParser.has("MEDICAL_FACILITY_NAME", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }

    sb.append("(");

    sb.append(" MEDICAL_FACILITY_NAME");

    sb.append(" LIKE");

    sb.append(" ");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_NAME", sqlParam)+"%"));

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

    firstCondition = ((Boolean)conditionStack.pop()).booleanValue();

    sb.append(" ORDER BY");

    sb.append(" MEDICAL_FACILITY_NAME");

    sb.append(" ");

    return sb.toString();
  }

  /**
   * �u�X�e�[�V�����������擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_STATION_HISTORY(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_STATION_HISTORY.MEDICAL_FACILITY_ID");

    sb.append(" FROM");

    sb.append(" PATIENT");

    sb.append(",PATIENT_STATION_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT.DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(" =");

    sb.append(" PATIENT_STATION_HISTORY.PATIENT_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_STATION_HISTORY.MEDICAL_FACILITY_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u��Ë@�֏��폜�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_DELETE_MEDICAL_FACILITY(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" MEDICAL_FACILITY");

    sb.append(" SET");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" MEDICAL_FACILITY_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

}
