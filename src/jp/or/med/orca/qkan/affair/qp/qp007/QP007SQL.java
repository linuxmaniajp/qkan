
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
 * �J����: ���p�Ҍ������
 * �쐬��: 2010/11/12  ���{�R���s���[�^�[������� ���p�Ҍ������ �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X ���p�Ҍ������ (007)
 * �v���O���� ���p�Ҍ�����������ݒ� (QP007)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp007;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * ���p�Ҍ�����������ݒ�SQL��`(QP007) 
 */
public class QP007SQL extends QP007State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP007SQL() {
  }

  /**
   * �u��^�����擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_FIXED_FORM(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" FIXED_FORM_ID");

    sb.append(",CONTENT_KEY");

    sb.append(",CONTENT");

    sb.append(" FROM");

    sb.append(" FIXED_FORM");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" TABLE_TYPE");

    sb.append(" =");

    sb.append(" 3");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" CONTENT_KEY");

    sb.append(" ");

    return sb.toString();
  }

  /**
   * �u��^���o�^�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_INSERT_FIXED_FORM(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" FIXED_FORM");

    sb.append("(");

    sb.append(" TABLE_TYPE");

    sb.append(",FIXED_FORM_ID");

    sb.append(",CONTENT_KEY");

    sb.append(",CONTENT");

    sb.append(",CONTENT_SORT");

    sb.append(",LAST_TIME");

    sb.append(",PROVIDER_ID");

    sb.append(")VALUES(");

    sb.append(" 3");

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FIXED_FORM_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CONTENT_KEY", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CONTENT", sqlParam)));

    sb.append(",");

    sb.append(" 0");

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_UPDATE_FIXED_FORM(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" FIXED_FORM");

    sb.append(" SET");

    sb.append(" CONTENT");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CONTENT", sqlParam)));

    sb.append(",");

    sb.append(" LAST_TIME");

    sb.append(" =");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" TABLE_TYPE");

    sb.append(" =");

    sb.append(" 3");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" FIXED_FORM_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FIXED_FORM_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CONTENT_KEY");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CONTENT_KEY", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u��^�����ޏ��擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_MAX_FIXED_FORM_ID(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CASE WHEN MAX(FIXED_FORM_ID) IS NULL THEN 1 ELSE MAX(FIXED_FORM_ID) + 1 END AS MAX_FIXED_FORM_ID");

    sb.append(" FROM");

    sb.append(" FIXED_FORM");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" TABLE_TYPE");

    sb.append(" =");

    sb.append(" 3");

    sb.append(")");

    return sb.toString();
  }

}
