
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
 * �쐬��: 2010/11/11  ���{�R���s���[�^�[������� �m�F�E�C�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (002)
 * �v���O���� ���[(�l��)�I�� (QP002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp002;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * ���[(�l��)�I��SQL��`(QP002) 
 */
public class QP002SQL extends QP002State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP002SQL() {
  }

  /**
   * �u��쐿�����R�[�h���擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_CLAIM(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" DISTINCT");

    sb.append(" CLAIM.CLAIM_STYLE_TYPE");

    sb.append(",CASE WHEN CLAIM.INSURED_ID IS NULL THEN CLAIM.CLAIM_STYLE_TYPE ELSE CLAIM.INSURED_ID || '-' || CLAIM.CLAIM_STYLE_TYPE END");

    sb.append(" AS INSURED_ID");

    sb.append(",CLAIM.TARGET_DATE");

    sb.append(",CLAIM.CLAIM_DATE");

    sb.append(",CLAIM.INSURER_ID");

    sb.append(",CLAIM.PROVIDER_ID");

    sb.append(",CLAIM.INSURED_ID");

    sb.append(" AS UNIT_INSURED_ID");

    sb.append(",PROVIDER.PROVIDER_NAME");

    sb.append(" FROM");

    sb.append(" CLAIM");

    sb.append(",PROVIDER");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.CLAIM_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("CLAIM_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("LOGIN_PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.PROVIDER_ID");

    sb.append(" =");

    sb.append(" PROVIDER.PROVIDER_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.CLAIM_STYLE_TYPE");

    sb.append(" NOT IN");

    sb.append(" (10101,10102,10201,10301,10401,10501,10601,10701,10801,10901,10101,11101,11201,20201,20202,30101,10111,11111,11211)");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" CLAIM.PROVIDER_ID");

    sb.append(" ");

    sb.append(",CLAIM.CLAIM_STYLE_TYPE");

    return sb.toString();
  }

  /**
   * �u���p�Ҍ����������R�[�h���擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_CLAIM_PATIENT_DETAIL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CLAIM.TARGET_DATE");

    sb.append(",CLAIM_PATIENT_DETAIL.SERVICE_CODE_KIND");

    sb.append(" FROM");

    sb.append(" CLAIM");

    sb.append(",CLAIM_PATIENT_DETAIL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM.CLAIM_ID");

    sb.append(" =");

    sb.append(" CLAIM_PATIENT_DETAIL.CLAIM_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.CLAIM_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("CLAIM_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("LOGIN_PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.CLAIM_STYLE_TYPE");

    sb.append(" =");

    sb.append(" 30101");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM_PATIENT_DETAIL.SERVICE_CODE_KIND");

    sb.append(" <>");

    sb.append(" '00'");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" CLAIM.TARGET_DATE");

    sb.append(" ");

    sb.append(",CLAIM_PATIENT_DETAIL.SERVICE_CODE_KIND");

    return sb.toString();
  }

}
