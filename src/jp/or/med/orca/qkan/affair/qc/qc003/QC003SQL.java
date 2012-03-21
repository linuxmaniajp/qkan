
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
 * �J����: �V�l�K��Ō�E�K��Ō���񋟏�
 * �쐬��: 2011/12/19  ���{�R���s���[�^�[������� �V�l�K��Ō�E�K��Ō���񋟏� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �V�l�K��Ō�E�K��Ō���񋟏� (003)
 * �v���O���� �V�l�K��Ō�E�K��Ō���񋟏� (QC003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc003;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * �V�l�K��Ō�E�K��Ō���񋟏�SQL��`(QC003) 
 */
public class QC003SQL extends QC003State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC003SQL() {
  }

  /**
   * �u�K��Ō�̏��񋟏������擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_HOMONKANGO_JOHO_TEIKYOSHO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",TARGET_DATE");

    sb.append(",CREATE_DATE");

    sb.append(",JOHO_TEIKYO_SAKI");

    sb.append(",JOTAI_CODE");

    sb.append(",DISEASE");

    sb.append(",PROVIDER_ADDRESS");

    sb.append(",PROVIDER_NAME");

    sb.append(",PROVIDER_TEL_FIRST");

    sb.append(",PROVIDER_TEL_SECOND");

    sb.append(",PROVIDER_TEL_THIRD");

    sb.append(",PROVIDER_ADMINISTRATOR");

    sb.append(",PATIENT_JOB");

    sb.append(",DOCTOR_NAME");

    sb.append(",DOCTOR_ADDRESS");

    sb.append(",ADL_MOVE");

    sb.append(",ADL_EXCRETION");

    sb.append(",ADL_CHANGE_CLOTH");

    sb.append(",ADL_FOOD");

    sb.append(",ADL_BATH");

    sb.append(",ADL_COSMETIC");

    sb.append(",BYOJO_SHOGAI_STATE");

    sb.append(",HOMON_KAISU_DAY");

    sb.append(",HOMON_KAISU_COUNT");

    sb.append(",KANGO_NAIYO");

    sb.append(",HOKEN_FUKUSHI_SERVICE");

    sb.append(",RYUIJIKO");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_JOHO_TEIKYOSHO");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�K��Ō�̏��񋟏��̏����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_INSERT_JOHO_TEIKYOSHO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append("  HOMONKANGO_JOHO_TEIKYOSHO");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(",TARGET_DATE");

    sb.append(",CREATE_DATE");

    sb.append(",JOHO_TEIKYO_SAKI");

    sb.append(",JOTAI_CODE");

    sb.append(",DISEASE");

    sb.append(",PROVIDER_ADDRESS");

    sb.append(",PROVIDER_NAME");

    sb.append(",PROVIDER_TEL_FIRST");

    sb.append(",PROVIDER_TEL_SECOND");

    sb.append(",PROVIDER_TEL_THIRD");

    sb.append(",PROVIDER_ADMINISTRATOR");

    sb.append(",PATIENT_JOB");

    sb.append(",DOCTOR_NAME");

    sb.append(",DOCTOR_ADDRESS");

    sb.append(",ADL_MOVE");

    sb.append(",ADL_EXCRETION");

    sb.append(",ADL_CHANGE_CLOTH");

    sb.append(",ADL_FOOD");

    sb.append(",ADL_BATH");

    sb.append(",ADL_COSMETIC");

    sb.append(",BYOJO_SHOGAI_STATE");

    sb.append(",HOMON_KAISU_DAY");

    sb.append(",HOMON_KAISU_COUNT");

    sb.append(",KANGO_NAIYO");

    sb.append(",HOKEN_FUKUSHI_SERVICE");

    sb.append(",RYUIJIKO");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("CREATE_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("JOHO_TEIKYO_SAKI", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("JOTAI_CODE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DISEASE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ADDRESS", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TEL_FIRST", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TEL_SECOND", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TEL_THIRD", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ADMINISTRATOR", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_JOB", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DOCTOR_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DOCTOR_ADDRESS", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_MOVE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_EXCRETION", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_CHANGE_CLOTH", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_FOOD", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_BATH", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_COSMETIC", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BYOJO_SHOGAI_STATE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("HOMON_KAISU_DAY", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("HOMON_KAISU_COUNT", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("KANGO_NAIYO", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("HOKEN_FUKUSHI_SERVICE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("RYUIJIKO", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�K��Ō�̏��񋟏������v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_UPDATE_JOHO_TEIKYOSHO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" HOMONKANGO_JOHO_TEIKYOSHO");

    sb.append(" SET");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" CREATE_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("CREATE_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" JOHO_TEIKYO_SAKI");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("JOHO_TEIKYO_SAKI", sqlParam)));

    sb.append(",");

    sb.append(" JOTAI_CODE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("JOTAI_CODE", sqlParam)));

    sb.append(",");

    sb.append(" DISEASE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DISEASE", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_ADDRESS");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ADDRESS", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_NAME", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_TEL_FIRST");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TEL_FIRST", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_TEL_SECOND");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TEL_SECOND", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_TEL_THIRD");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_TEL_THIRD", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_ADMINISTRATOR");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ADMINISTRATOR", sqlParam)));

    sb.append(",");

    sb.append(" PATIENT_JOB");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_JOB", sqlParam)));

    sb.append(",");

    sb.append(" DOCTOR_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DOCTOR_NAME", sqlParam)));

    sb.append(",");

    sb.append(" DOCTOR_ADDRESS");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DOCTOR_ADDRESS", sqlParam)));

    sb.append(",");

    sb.append(" ADL_MOVE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_MOVE", sqlParam)));

    sb.append(",");

    sb.append(" ADL_EXCRETION");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_EXCRETION", sqlParam)));

    sb.append(",");

    sb.append(" ADL_CHANGE_CLOTH");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_CHANGE_CLOTH", sqlParam)));

    sb.append(",");

    sb.append(" ADL_FOOD");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_FOOD", sqlParam)));

    sb.append(",");

    sb.append(" ADL_BATH");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_BATH", sqlParam)));

    sb.append(",");

    sb.append(" ADL_COSMETIC");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_COSMETIC", sqlParam)));

    sb.append(",");

    sb.append(" BYOJO_SHOGAI_STATE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BYOJO_SHOGAI_STATE", sqlParam)));

    sb.append(",");

    sb.append(" HOMON_KAISU_DAY");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("HOMON_KAISU_DAY", sqlParam)));

    sb.append(",");

    sb.append(" HOMON_KAISU_COUNT");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("HOMON_KAISU_COUNT", sqlParam)));

    sb.append(",");

    sb.append(" KANGO_NAIYO");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("KANGO_NAIYO", sqlParam)));

    sb.append(",");

    sb.append(" HOKEN_FUKUSHI_SERVICE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("HOKEN_FUKUSHI_SERVICE", sqlParam)));

    sb.append(",");

    sb.append(" RYUIJIKO");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("RYUIJIKO", sqlParam)));

    sb.append(",");

    sb.append(" LAST_TIME");

    sb.append(" =");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�O���ȑO�̖K��Ō�̏��񋟏��v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_LAST_HOMONKANGO_JOHO_TEIKYOSHO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",TARGET_DATE");

    sb.append(",CREATE_DATE");

    sb.append(",JOHO_TEIKYO_SAKI");

    sb.append(",JOTAI_CODE");

    sb.append(",DISEASE");

    sb.append(",PROVIDER_ADDRESS");

    sb.append(",PROVIDER_NAME");

    sb.append(",PROVIDER_TEL_FIRST");

    sb.append(",PROVIDER_TEL_SECOND");

    sb.append(",PROVIDER_TEL_THIRD");

    sb.append(",PROVIDER_ADMINISTRATOR");

    sb.append(",PATIENT_JOB");

    sb.append(",DOCTOR_NAME");

    sb.append(",DOCTOR_ADDRESS");

    sb.append(",ADL_MOVE");

    sb.append(",ADL_EXCRETION");

    sb.append(",ADL_CHANGE_CLOTH");

    sb.append(",ADL_FOOD");

    sb.append(",ADL_BATH");

    sb.append(",ADL_COSMETIC");

    sb.append(",BYOJO_SHOGAI_STATE");

    sb.append(",HOMON_KAISU_DAY");

    sb.append(",HOMON_KAISU_COUNT");

    sb.append(",KANGO_NAIYO");

    sb.append(",HOKEN_FUKUSHI_SERVICE");

    sb.append(",RYUIJIKO");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_JOHO_TEIKYOSHO");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" MAX(TARGET_DATE)");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_JOHO_TEIKYOSHO");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" <");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

    return sb.toString();
  }

}
