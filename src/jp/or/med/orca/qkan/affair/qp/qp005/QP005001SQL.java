
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
 * �J����: �m�F�E�C��
 * �쐬��: 2009/07/07  ���{�R���s���[�^�[������� �m�F�E�C�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (005)
 * �v���O���� ���׏��ڍוҏW (QP005001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * ���׏��ڍוҏWSQL��`(QP005001) 
 */
public class QP005001SQL extends QP005001Design {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP005001SQL() {
  }

  /**
   * �u�T�[�r�X�R�[�h�}�X�^�̃f�[�^�擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_SPECIAL_CLINIC_SERVICE_CODE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(",SYSTEM_SERVICE_CODE_ITEM");

    sb.append(",SERVICE_VALID_START");

    sb.append(",SERVICE_VALID_END");

    sb.append(",SERVICE_CODE_KIND");

    sb.append(",SERVICE_CODE_ITEM");

    sb.append(",SERVICE_NAME");

    sb.append(",SERVICE_UNIT");

    sb.append(",LIMIT_AMOUNT_OBJECT");

    sb.append(",SERVICE_ADD_FLAG");

    sb.append(",TOTAL_GROUPING_TYPE");

    sb.append(",SUMMARY_FLAG");

    sb.append(",SUMMARY_MEMO");

    sb.append(",CLASS_TYPE");

    sb.append(",CODE_ID");

    sb.append(",EDITABLE_FLAG");

    sb.append(" FROM");

    sb.append(" M_SERVICE_CODE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" SERVICE_CODE_KIND");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SERVICE_CODE_KIND", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_CODE_ITEM");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SERVICE_CODE_ITEM", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" SERVICE_CODE_KIND");

    sb.append(" ");

    sb.append(",SERVICE_CODE_ITEM");

    return sb.toString();
  }

}
