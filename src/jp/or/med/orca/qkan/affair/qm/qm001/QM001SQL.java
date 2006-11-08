
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
 * �J����: ���O�C�����
 * �쐬��: 2006/05/25  ���{�R���s���[�^�[������� ���O�C����� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���j���[ (M)
 * �v���Z�X ���O�C����� (001)
 * �v���O���� ���O�C����� (QM001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qm.qm001;
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
 * ���O�C�����SQL��`(QM001) 
 */
public class QM001SQL extends QM001State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QM001SQL() {
  }

  /**
   * �u�����Ə��ꗗ���擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_MY_PROVIDER(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PROVIDER_ID");

    sb.append(",PROVIDER_NAME");

    sb.append(",PROVIDER_ID || '�@' || PROVIDER_NAME");

    sb.append(" AS SHOW_PROVIDER_NAME");

    sb.append(" FROM");

    sb.append(" PROVIDER");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PROVIDER_JIJIGYOUSHO_TYPE");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" DELETE_FLAG");

    sb.append(" <>");

    sb.append(" 1");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" PROVIDER_ID");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * �u���t�Ǘ��䒠�V�X�e���́v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_QKAN_VERSION(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" MASTER_DATA_VERSION");

    sb.append(",SCHEME_VERSION");

    sb.append(" FROM");

    sb.append(" M_QKAN_VERSION");

    return sb.toString();
  }

  /**
   * �u�R�[�h�}�X�^���擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_MASTER_CODE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CODE_ID");

    sb.append(",CONTENT_KEY");

    sb.append(",CONTENT");

    sb.append(",CONTENT_SORT");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" M_CODE");

    sb.append(" ORDER BY");

    sb.append(" CODE_ID");

    sb.append(" ASC");

//    sb.append(",CONTENT_KEY");
//
//    sb.append(" ASC");

    sb.append(",CONTENT_SORT");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * �u�T�[�r�X��ރ}�X�^���擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_MASTER_SERVICE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(",SERVICE_CODE_KIND");

    sb.append(",SERVICE_NAME");

    sb.append(",SERVICE_ABBREVIATION");

    sb.append(",SERVICE_CALENDAR_ABBREVIATION");

    sb.append(",CLAIM_STYLE_TYPE");

    sb.append(",SERVICE_SORT");

    sb.append(",BUSINESS_TYPE");

    sb.append(",CALENDAR_PASTE_FLAG");

    sb.append(",CHANGES_CONTENT_TYPE");

    sb.append(",SERVICE_VALID_START");

    sb.append(",SERVICE_VALID_END");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" M_SERVICE");

    sb.append(" ORDER BY");

    sb.append(" SERVICE_SORT");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * �u�R�[�h�}�X�^���擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_MASTER_WELFARE_TOOL(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CODE_ID");

    sb.append(",CONTENT_KEY");

    sb.append(",CONTENT");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" M_CODE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CODE_ID");

    sb.append(" =");

    sb.append(" 47");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" CODE_ID");

    sb.append(" ASC");

    sb.append(",CONTENT_KEY");

    sb.append(" ASC");

    sb.append(",CONTENT_SORT");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * �u�ԍ��Ǘ��e�[�u���̍̔�(�T�[�r�X)�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_UPDATE_NO_OF_SERVICE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" M_NO_CONTROL");

    sb.append(" SET");

    sb.append(" M_NO_CONTROL.CONTROL_NO");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" CASE");

    sb.append(" WHEN");

    sb.append(" MAX(SERVICE.SERVICE_ID)");

    sb.append(" IS");

    sb.append(" NULL");

    sb.append(" THEN");

    sb.append(" 1");

    sb.append(" ELSE");

    sb.append(" MAX(SERVICE.SERVICE_ID)+1");

    sb.append(" END");

    sb.append(" FROM");

    sb.append(" SERVICE");

    sb.append(")");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" M_NO_CONTROL.TABLE_NAME");

    sb.append(" =");

    sb.append(" 'SERVICE'");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_NO_CONTROL.FIELD_NAME");

    sb.append(" =");

    sb.append(" 'SERVICE_ID'");

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�ԍ��Ǘ��e�[�u���̍̔�(���Ə��񋟃T�[�r�X)�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_UPDATE_NO_OF_PROVIDER_SERVICE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" M_NO_CONTROL");

    sb.append(" SET");

    sb.append(" M_NO_CONTROL.CONTROL_NO");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" CASE");

    sb.append(" WHEN");

    sb.append(" MAX(PROVIDER_SERVICE.PROVIDER_SERVICE_ID)");

    sb.append(" IS");

    sb.append(" NULL");

    sb.append(" THEN");

    sb.append(" 1");

    sb.append(" ELSE");

    sb.append(" MAX(PROVIDER_SERVICE.PROVIDER_SERVICE_ID)+1");

    sb.append(" END");

    sb.append(" FROM");

    sb.append(" PROVIDER_SERVICE");

    sb.append(")");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" M_NO_CONTROL.TABLE_NAME");

    sb.append(" =");

    sb.append(" 'PROVIDER_SERVICE'");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_NO_CONTROL.FIELD_NAME");

    sb.append(" =");

    sb.append(" 'PROVIDER_SERVICE_ID'");

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�ԍ��Ǘ��e�[�u���̍̔�(����)�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_UPDATE_NO_OF_CLAIM(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" M_NO_CONTROL");

    sb.append(" SET");

    sb.append(" M_NO_CONTROL.CONTROL_NO");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" CASE");

    sb.append(" WHEN");

    sb.append(" MAX(CLAIM.CLAIM_ID)");

    sb.append(" IS");

    sb.append(" NULL");

    sb.append(" THEN");

    sb.append(" 1");

    sb.append(" ELSE");

    sb.append(" MAX(CLAIM.CLAIM_ID)+1");

    sb.append(" END");

    sb.append(" FROM");

    sb.append(" CLAIM");

    sb.append(")");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" M_NO_CONTROL.TABLE_NAME");

    sb.append(" =");

    sb.append(" 'CLAIM'");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_NO_CONTROL.FIELD_NAME");

    sb.append(" =");

    sb.append(" 'CLAIM_ID'");

    sb.append(")");

    return sb.toString();
  }

}
