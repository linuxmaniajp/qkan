
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
 * �J����: �T�[�r�X�\��
 * �쐬��: 2009/03/27  ���{�R���s���[�^�[������� �T�[�r�X�\�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �W�v���׉�� (QS001030)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * �W�v���׉��SQL��`(QS001030) 
 */
public class QS001005SQL extends QS001005State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001005SQL() {
  }

  /**
   * �u�O�����p�^�̋��t����P�ʐ��擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_SELECT_EXTERNAL_USE_LIMIT(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" LIMIT_RATE_VALUE");

    sb.append(" AS EXTERNAL_USE_LIMIT");

    sb.append(" FROM");

    sb.append(" M_LIMIT_RATE");

    sb.append(",M_LIMIT_RATE_DETAIL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_TYPE");

    sb.append(" =");

    sb.append(" 2");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_TYPE");

    sb.append(" =");

    sb.append(" M_LIMIT_RATE_DETAIL.LIMIT_RATE_TYPE");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_HISTORY_ID");

    sb.append(" =");

    sb.append(" M_LIMIT_RATE_DETAIL.LIMIT_RATE_HISTORY_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE_DETAIL.JOTAI_CODE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("JOTAI_CODE", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

}
