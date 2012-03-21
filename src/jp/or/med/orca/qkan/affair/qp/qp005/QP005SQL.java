
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
 * �쐬��: 2006/03/03  ���{�R���s���[�^�[������� �m�F�E�C�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (005)
 * �v���O���� ���׏��ڍוҏW (QP005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * ���׏��ڍוҏWSQL��`(QP005) 
 */
public class QP005SQL extends QP005State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP005SQL() {
  }

  /**
   * �u���ڃR�����g�}�X�^�f�[�^�̎擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_DETAIL_COMMENT(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CATEGORY_NO");

    sb.append(",COMMENT_ID");

    sb.append(",TABLE_TYPE");

    sb.append(",DETAIL_NAME");

    sb.append(",COMMENT");

    sb.append(",SHOW_FLAG");

    sb.append(",EDITABLE_FLAG");

    sb.append(",SYSTEM_BIND_PATH");

    sb.append(",MAX_LENGTH");

    sb.append(",CHAR_TYPE");

    sb.append(",ALIGNMENT");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" M_DETAIL_COMMENT");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" COMMENT_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" COMMENT_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" CATEGORY_NO");

    sb.append(" ");

    sb.append(",COMMENT_ID");

    return sb.toString();
  }

  /**
   * �u����}�X�^���̎擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_KOHI(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" KOHI_TYPE");

    sb.append(",KOHI_LAW_NO");

    sb.append(",KOHI_NAME");

    sb.append(",KOHI_ABBREVIATION");

    sb.append(",KOHI_SORT");

    sb.append(",BENEFIT_RATE");

    sb.append(",CITY_CLAIM_FLAG");

    sb.append(",INSURE_TYPE");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" M_KOHI");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" KOHI_TYPE");

    sb.append(" IN");

    sb.append(" (");

    inValues = (Object[])VRBindPathParser.get("KOHI_TYPE", sqlParam);
    
    sb.append(ACSQLSafeIntegerFormat.getInstance().format(inValues[0]));

    for(int i=1; i<inValues.length; i++){
      sb.append(", ");
      
    sb.append(ACSQLSafeIntegerFormat.getInstance().format(inValues[i]));

    }

    sb.append(")");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" KOHI_SORT");

    sb.append(" ");

    return sb.toString();
  }

}
