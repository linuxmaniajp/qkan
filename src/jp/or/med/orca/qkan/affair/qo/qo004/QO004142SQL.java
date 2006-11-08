
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
 * �J����: ���Ə��o�^
 * �쐬��: 2006/05/02  ���{�R���s���[�^�[������� ���Ə��o�^ �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� ���\�h�Z�������×{���i��K���f�Ï��^�j (QO004142)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * ���\�h�Z�������×{���i��K���f�Ï��^�jSQL��`(QO004142) 
 */
public class QO004142SQL extends QO004142State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004142SQL() {
  }

  /**
   * �u���Z��E�H��̎擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_RESIDENCE_FOOD(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" RESIDENCE_FOOD_COST_ID");

    sb.append(",RESIDENCE_FOOD_COST");

    sb.append(" FROM");

    sb.append(" M_RESIDENCE_FOOD_COST");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" RESIDENCE_FOOD_COST_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("SYSTEM_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" RESIDENCE_FOOD_COST_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("SYSTEM_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

}
