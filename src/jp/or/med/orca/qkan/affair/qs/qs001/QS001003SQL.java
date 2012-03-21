
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
 * �쐬��: 2006/05/30  ���{�R���s���[�^�[������� �T�[�r�X�\�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� ���p�E�񋟕[��� (QS001031)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * ���p�E�񋟕[���SQL��`(QS001031) 
 */
@SuppressWarnings("serial")
public class QS001003SQL extends QS001003State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001003SQL() {
  }

  /**
   * �u�I�����Ə��ɑ�����X�^�b�t�ꗗ���擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_STAFF(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" STAFF.PROVIDER_ID");

    sb.append(",STAFF.STAFF_ID");

    sb.append(",STAFF.CARE_MANAGER_NO");

    sb.append(",STAFF.STAFF_FAMILY_NAME");

    sb.append(",STAFF.STAFF_FIRST_NAME");

    sb.append(" FROM");

    sb.append(" STAFF");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" STAFF.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" STAFF.STAFF_ID");

    sb.append(" ");

    return sb.toString();
  }

  /**
   * �u�O���܂ł̒Z���������p�������擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_PREVIEW_SHORT_STAY(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" DISTINCT");

    sb.append(" SERVICE.SERVICE_DATE");

    sb.append(" FROM");

    sb.append(" SERVICE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" SERVICE.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE.SERVICE_USE_TYPE");

    sb.append(" =");

    sb.append(" 6");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(" >=");

    sb.append(" 12000");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(" <=");

    sb.append(" 12999");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE.SERVICE_DATE");

    sb.append(" <");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-01"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE.SERVICE_DATE");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("INSURE_VALID_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

}
