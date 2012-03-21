
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
 * �J����: �ی��ҊǗ�
 * �쐬��: 2006/04/17  ���{�R���s���[�^�[������� �ی��ҊǗ� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X �ی��ҊǗ� (001)
 * �v���O���� �ی��ҏ��ꗗ (QO001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo001;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * �ی��ҏ��ꗗSQL��`(QO001) 
 */
public class QO001SQL extends QO001State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO001SQL() {
  }

  /**
   * �uTABLE�ɓo�^����Ă���S�Ắv�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_INSURER_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_ID");

    sb.append(",INSURER_NAME");

    sb.append(",INSURER_TYPE");

    sb.append(",INSURER_ZIP_FIRST");

    sb.append(",INSURER_ZIP_SECOND");

    sb.append(",INSURER_ADDRESS");

    sb.append(",INSURER_TEL_FIRST");

    sb.append(",INSURER_TEL_SECOND");

    sb.append(",INSURER_TEL_THIRD");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" INSURER");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" INSURER_ID");

    sb.append(" ");

    return sb.toString();
  }

  /**
   * �u�ی��҂̎x�����x�z�����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_INSURER_LIMIT_RATE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_ID");

    sb.append(",LIMIT_RATE_HISTORY_ID");

    sb.append(",LIMIT_RATE_VALID_START");

    sb.append(",LIMIT_RATE_VALID_END");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" INSURER_LIMIT_RATE");

    sb.append(" ORDER BY");

    sb.append(" INSURER_LIMIT_RATE.INSURER_ID");

    sb.append(" ");

    sb.append(",INSURER_LIMIT_RATE.LIMIT_RATE_HISTORY_ID");

    return sb.toString();
  }

  /**
   * �u�ی��҂̎x�����x�z�ڍ׏����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_INSURER_LIMIT_RATE_DETAIL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_ID");

    sb.append(",LIMIT_RATE_HISTORY_ID");

    sb.append(",JOTAI_CODE");

    sb.append(",LIMIT_RATE_VALUE");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" INSURER_LIMIT_RATE_DETAIL");

    sb.append(" ORDER BY");

    sb.append(" INSURER_ID");

    sb.append(" ");

    sb.append(",LIMIT_RATE_HISTORY_ID");

    return sb.toString();
  }

  /**
   * �u�ی��ҏ����폜����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_DELETE_INSURER_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" INSURER");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�x�����x�z�����폜����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_DELETE_INSURER_LIMIT_RATE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" INSURER_LIMIT_RATE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�x�����x�z�ڍ׏����폜����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_DELETE_INSURER_LIMIT_RATE_DETAIL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" INSURER_LIMIT_RATE_DETAIL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�ی��Җ��̂Ō�������B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_FIND_INSURER_NAME(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_ID");

    sb.append(",INSURER_NAME");

    sb.append(",INSURER_TYPE");

    sb.append(",INSURER_ZIP_FIRST");

    sb.append(",INSURER_ZIP_SECOND");

    sb.append(",INSURER_ADDRESS");

    sb.append(",INSURER_TEL_FIRST");

    sb.append(",INSURER_TEL_SECOND");

    sb.append(",INSURER_TEL_THIRD");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" INSURER");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURER_NAME");

    sb.append(" LIKE");

    sb.append(" ");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_NAME_FIND", sqlParam)+"%"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�v���F�藚���e�[�u���Ŏg�p����Ă���ی��҂��`�F�b�N����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_INSURER_ID(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(" FROM");

    sb.append(" PATIENT");

    sb.append(",PATIENT_NINTEI_HISTORY");

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

    sb.append(" PATIENT_NINTEI_HISTORY.PATIENT_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_NINTEI_HISTORY.INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�ی��ҏ����폜��Ԃɂ���B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_UPDATE_TO_DELETE_INSURER(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" INSURER");

    sb.append(" SET");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

}
