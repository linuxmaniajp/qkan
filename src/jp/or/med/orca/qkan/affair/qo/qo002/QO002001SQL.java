
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
 * �J����: �ی��ҏ��o�^
 * �쐬��: 2009/08/03  ���{�R���s���[�^�[������� �ی��ҏ��o�^ �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �ی��ҊǗ� (O)
 * �v���Z�X �ی��ҏ��o�^ (002)
 * �v���O���� �ی��ґI�� (QO002001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo002;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * �ی��ґI��SQL��`(QO002001) 
 */
public class QO002001SQL extends QO002001State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO002001SQL() {
  }

  /**
   * �u����SQL�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_FIND_M_INSURER_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_NAME");

    sb.append(",INSURER_NO");

    sb.append(" FROM");

    sb.append(" M_INSURER");

    conditionStack.push(new Boolean(firstCondition));
    firstCondition = true;

    if(
      VRBindPathParser.has("FIND_INSURER_NAME", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }

    sb.append("(");

    sb.append(" INSURER_NAME");

    sb.append(" LIKE");

    sb.append(" ");

    sb.append(ACSQLSafeStringFormat.getInstance().format("%"+VRBindPathParser.get("FIND_INSURER_NAME", sqlParam)+"%"));

    sb.append(")");

    }

    firstCondition = ((Boolean)conditionStack.pop()).booleanValue();

    sb.append(" ORDER BY");

    sb.append(" INSURER_PREFECTURAL_CODE");

    sb.append(" ASC");

    sb.append(",INSURER_NO");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * �u�ی��҃}�X�^�f�[�^��S�Ď擾���܂��B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_M_INSURER_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_NAME");

    sb.append(",INSURER_NO");

    sb.append(" FROM");

    sb.append(" M_INSURER");

    sb.append(" ORDER BY");

    sb.append(" INSURER_PREFECTURAL_CODE");

    sb.append(" ASC");

    sb.append(",INSURER_NO");

    sb.append(" ASC");

    return sb.toString();
  }

}
