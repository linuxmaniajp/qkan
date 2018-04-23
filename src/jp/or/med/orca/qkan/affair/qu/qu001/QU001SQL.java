
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
 * �J����: ���p�҈ꗗ
 * �쐬��: 2012/10/17  ���{�R���s���[�^�[������� ���p�҈ꗗ �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�҈ꗗ (001)
 * �v���O���� ���p�҈ꗗ (QU001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu001;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * ���p�҈ꗗSQL��`(QU001) 
 */
public class QU001SQL extends QU001State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU001SQL() {
  }

  /**
   * �u���p�҈ꗗ���擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_PATIENT(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(",PATIENT.PATIENT_CODE");

    sb.append(",PATIENT.PATIENT_FAMILY_NAME");

    sb.append(",PATIENT.PATIENT_FIRST_NAME");

    sb.append(",PATIENT.PATIENT_FAMILY_KANA");

    sb.append(",PATIENT.PATIENT_FIRST_KANA");

    sb.append(",PATIENT.PATIENT_SEX");

    sb.append(",PATIENT.PATIENT_BIRTHDAY");

    sb.append(",PATIENT.PATIENT_TEL_FIRST");

    sb.append(",PATIENT.PATIENT_TEL_SECOND");

    sb.append(",PATIENT.PATIENT_TEL_THIRD");

    sb.append(",PATIENT.PATIENT_ZIP_FIRST");

    sb.append(",PATIENT.PATIENT_ZIP_SECOND");

    sb.append(",PATIENT.PATIENT_ADDRESS");

    sb.append(",PATIENT.SHOW_FLAG");

    sb.append(",PATIENT.LAST_TIME");

    sb.append(" FROM");

    sb.append(" PATIENT");

    conditionStack.push(new Boolean(firstCondition));
    firstCondition = true;

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }

    sb.append("(");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(")");

    if(
      VRBindPathParser.has("PATIENT_CODE", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" PATIENT.PATIENT_CODE");

    sb.append(" LIKE");

    sb.append(" ");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_CODE", sqlParam)+"%"));

    sb.append(")");

    }

    if(
      VRBindPathParser.has("PATIENT_KANA", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" CASE WHEN PATIENT.PATIENT_FAMILY_KANA IS NULL THEN PATIENT.PATIENT_FIRST_KANA WHEN PATIENT.PATIENT_FIRST_KANA IS NULL THEN PATIENT.PATIENT_FAMILY_KANA ELSE PATIENT.PATIENT_FAMILY_KANA || PATIENT.PATIENT_FIRST_KANA END");

    sb.append(" LIKE");

    sb.append(" ");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_KANA", sqlParam)+"%"));

    sb.append(")");

    }

    if(
      VRBindPathParser.has("PATIENT_BIRTHDAY", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" PATIENT.PATIENT_BIRTHDAY");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("PATIENT_BIRTHDAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    }

    if(
      VRBindPathParser.has("HIDE_FLAG", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" PATIENT.SHOW_FLAG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    }

    firstCondition = ((Boolean)conditionStack.pop()).booleanValue();

    sb.append(" ORDER BY");

    sb.append(" PATIENT_FAMILY_KANA");

    sb.append(" ASC");

    sb.append(",PATIENT_FIRST_KANA");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * �u���p�ҏ����폜����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_DELETE_PATIENT(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" PATIENT");

    sb.append(" SET");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�p�����[�^���t���_�̗��p�ҔF����擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_NINTEI_NOW(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_ID");

    sb.append(",INSURED_ID");

    sb.append(",JOTAI_CODE");

    sb.append(",INSURE_VALID_START");

    sb.append(",INSURE_VALID_END");

    sb.append(",PROVIDER_ID");

    sb.append(" FROM");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURE_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("NOW_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURE_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("NOW_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" JOTAI_CODE");

    sb.append(" DESC");

    return sb.toString();
  }

  /**
   * �u�p�����[�^���t��薢���̗��p�ҔF��̂������߂̂��̂��擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_NINTEI_FUTURE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_ID");

    sb.append(",INSURED_ID");

    sb.append(",JOTAI_CODE");

    sb.append(",INSURE_VALID_START");

    sb.append(",INSURE_VALID_END");

    sb.append(",PROVIDER_ID");

    sb.append(" FROM");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURE_VALID_START");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" MIN(INSURE_VALID_START)");

    sb.append(" FROM");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURE_VALID_START");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("NOW_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" JOTAI_CODE");

    sb.append(" DESC");

    return sb.toString();
  }

  /**
   * �u�p�����[�^���t���ߋ��̗��p�ҔF��̂������߂̂��̂��擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_NINTEI_PAST(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_ID");

    sb.append(",INSURED_ID");

    sb.append(",JOTAI_CODE");

    sb.append(",INSURE_VALID_START");

    sb.append(",INSURE_VALID_END");

    sb.append(",PROVIDER_ID");

    sb.append(" FROM");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURE_VALID_END");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" MAX(INSURE_VALID_END)");

    sb.append(" FROM");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURE_VALID_END");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("NOW_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" JOTAI_CODE");

    sb.append(" DESC");

    return sb.toString();
  }

  /**
   * �u����×{�Ǘ��w���̃f�[�^���擾���܂��B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_KYOTAKU_RYOYO_PATIENT(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(",PATIENT.PATIENT_CODE");

    sb.append(",PATIENT.PATIENT_FAMILY_NAME");

    sb.append(",PATIENT.PATIENT_FIRST_NAME");

    sb.append(",PATIENT.PATIENT_FAMILY_KANA");

    sb.append(",PATIENT.PATIENT_FIRST_KANA");

    sb.append(",PATIENT.PATIENT_SEX");

    sb.append(",PATIENT.PATIENT_BIRTHDAY");

    sb.append(",PATIENT.PATIENT_TEL_FIRST");

    sb.append(",PATIENT.PATIENT_TEL_SECOND");

    sb.append(",PATIENT.PATIENT_TEL_THIRD");

    sb.append(",PATIENT.PATIENT_ZIP_FIRST");

    sb.append(",PATIENT.PATIENT_ZIP_SECOND");

    sb.append(",PATIENT.PATIENT_ADDRESS");

    sb.append(",PATIENT.SHOW_FLAG");

    sb.append(",PATIENT.BELONG_TYPE");

    sb.append(",PATIENT.AREA_TYPE");

    sb.append(",PATIENT.DELETE_FLAG");

    sb.append(",PATIENT.LAST_TIME");

    sb.append(",KYOTAKU_RYOYO.TARGET_DATE");

    sb.append(",KYOTAKU_RYOYO.JOTAI_CODE");

    sb.append(",KYOTAKU_RYOYO.SHOGAI_JIRITSUDO");

    sb.append(",KYOTAKU_RYOYO.NINCHISHO_JIRITSUDO");

    sb.append(",KYOTAKU_RYOYO.PATIENT_ADDRESS AS KYOTAKU_PATIENT_ADDRESS");

    sb.append(",KYOTAKU_RYOYO.PATIENT_TEL_FIRST AS KYOTAKU_PATIENT_TEL_FIRST");

    sb.append(",KYOTAKU_RYOYO.PATIENT_TEL_SECOND AS KYOTAKU_PATIENT_TEL_SECOND");

    sb.append(",KYOTAKU_RYOYO.PATIENT_TEL_THIRD AS KYOTAKU_PATIENT_TEL_THIRD");

    sb.append(",KYOTAKU_RYOYO.CREATE_DATE_ZAITAKU");

    sb.append(",KYOTAKU_RYOYO.VISIT_THIS_MONTH_NO1");

    sb.append(",KYOTAKU_RYOYO.VISIT_THIS_MONTH_NO2");

    sb.append(",KYOTAKU_RYOYO.VISIT_THIS_MONTH_NO3");

    sb.append(",KYOTAKU_RYOYO.VISIT_THIS_MONTH_NO4");

    sb.append(",KYOTAKU_RYOYO.VISIT_THIS_MONTH_NO5");

    sb.append(",KYOTAKU_RYOYO.VISIT_THIS_MONTH_NO6");

    sb.append(",KYOTAKU_RYOYO.VISIT_NEXT_MONTH_NO1");

    sb.append(",KYOTAKU_RYOYO.VISIT_NEXT_MONTH_NO2");

    sb.append(",KYOTAKU_RYOYO.VISIT_NEXT_MONTH_NO3");

    sb.append(",KYOTAKU_RYOYO.VISIT_NEXT_MONTH_NO4");

    sb.append(",KYOTAKU_RYOYO.VISIT_NEXT_MONTH_NO5");

    sb.append(",KYOTAKU_RYOYO.VISIT_NEXT_MONTH_NO6");

    sb.append(",KYOTAKU_RYOYO.ADVICE_MONTH");

    sb.append(",KYOTAKU_RYOYO.ADVICE");

    sb.append(",KYOTAKU_RYOYO.MEDICAL_FACILITY_NAME");

    sb.append(",KYOTAKU_RYOYO.DOCTOR_NAME");

    sb.append(",KYOTAKU_RYOYO.MEDICAL_FACILITY_ADDRESS");

    sb.append(",KYOTAKU_RYOYO.MEDICAL_FACILITY_TEL_FIRST");

    sb.append(",KYOTAKU_RYOYO.MEDICAL_FACILITY_TEL_SECOND");

    sb.append(",KYOTAKU_RYOYO.MEDICAL_FACILITY_TEL_THIRD");

    sb.append(",KYOTAKU_RYOYO.SENMONIN");

    sb.append(",KYOTAKU_RYOYO.PROVIDER_NAME");

    sb.append(",KYOTAKU_RYOYO.CREATE_DATE_KYOTAKU");

    sb.append(",KYOTAKU_RYOYO.CONDITION");

    sb.append(",KYOTAKU_RYOYO.CONDITION_PASSAGE");

    sb.append(",KYOTAKU_RYOYO.NOTE_OF_KAIGO_SERVICE");

    sb.append(",KYOTAKU_RYOYO.NOTE_OF_DAILY_LIFE");

    sb.append(",KYOTAKU_RYOYO.REMARKS");

    sb.append(",KYOTAKU_RYOYO.LAST_TIME");

    sb.append(",KYOTAKU_RYOYO.FINISH_FLAG");

    sb.append(" FROM");

    sb.append(" PATIENT");

    sb.append(" INNER JOIN");

    sb.append(" KYOTAKU_RYOYO");

    conditionStack.push(new Boolean(firstCondition));
    firstCondition = true;

      if(firstCondition){
        sb.append(" ON");
        firstCondition = false;

      }

    sb.append("(");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(" =");

    sb.append(" KYOTAKU_RYOYO.PATIENT_ID");

    sb.append(")");

      if(firstCondition){
        sb.append(" ON");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" KYOTAKU_RYOYO.TARGET_DATE");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("DATE_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

      if(firstCondition){
        sb.append(" ON");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" KYOTAKU_RYOYO.TARGET_DATE");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("DATE_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    if(
      VRBindPathParser.has("PROVIDER_NAME", sqlParam)
    ){

      if(firstCondition){
        sb.append(" ON");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" KYOTAKU_RYOYO.PROVIDER_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_NAME", sqlParam)));

    sb.append(")");

    }

    if(
      VRBindPathParser.has("SENMONIN_NAME", sqlParam)
    ){

      if(firstCondition){
        sb.append(" ON");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" KYOTAKU_RYOYO.SENMONIN");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SENMONIN_NAME", sqlParam)));

    sb.append(")");

    }

    firstCondition = ((Boolean)conditionStack.pop()).booleanValue();

    sb.append(" ORDER BY");

    sb.append(" PATIENT.PATIENT_FAMILY_KANA");

    sb.append(" ASC");

    sb.append(",PATIENT.PATIENT_FIRST_KANA");

    sb.append(" ASC");

    sb.append(",KYOTAKU_RYOYO.CREATE_DATE_KYOTAKU");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * �u���x���������̎擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_CARE_MANAGER(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
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

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * �u����×{�Ǘ��w�����Ώێҁv�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_KYOTAKU_RYOYO_TARGET_PATIENT(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",TARGET_DATE");

    sb.append(" FROM");

    sb.append(" KYOTAKU_RYOYO");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("DATE_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("DATE_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u����×{�Ǘ��w�����̈����Ԃ��X�V�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_UPDATE_KYOTAKU_RYOYO_FINISH_FLAG(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" KYOTAKU_RYOYO");

    sb.append(" SET");

    sb.append(" FINISH_FLAG");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FINISH_FLAG", sqlParam)));

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    // [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
    if (ACTextUtilities.isNullText(VRBindPathParser.get("TARGET_DATE_START", sqlParam))) {

        sb.append("(");

        sb.append(" TARGET_DATE");

        sb.append(" =");

        sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

        sb.append(")");

    } else {

        sb.append("(");

        sb.append(" TARGET_DATE");

        sb.append(" >=");

        sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START", sqlParam), "yyyy-MM-dd"));

        sb.append(")");

        sb.append("AND");

        sb.append("(");

        sb.append(" TARGET_DATE");

        sb.append(" <=");

        sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_END", sqlParam), "yyyy-MM-dd"));

        sb.append(")");

    }
    // [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�

    return sb.toString();
  }

  /**
   * �u�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_NINTEI_ALL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",INSURER_ID");

    sb.append(",INSURED_ID");

    sb.append(",JOTAI_CODE");

    sb.append(",INSURE_VALID_START");

    sb.append(",INSURE_VALID_END");

    sb.append(",SYSTEM_INSURE_VALID_START");

    sb.append(",SYSTEM_INSURE_VALID_END");

    sb.append(",PROVIDER_ID");

    sb.append(" FROM");

    sb.append(" PATIENT_NINTEI_HISTORY");

    return sb.toString();
  }

  /**
   * �u�{�ݏ��̑S�������擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_SHISETSU_HISTORY_ALL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_SHISETSU_HISTORY.SHISETSU_VALID_START");

    sb.append(",PATIENT_SHISETSU_HISTORY.SHISETSU_VALID_END");

    sb.append(",PATIENT_SHISETSU_HISTORY.TOKUTEI_NYUSHO_FLAG"); //add

    sb.append(" FROM");

    sb.append(" PATIENT_SHISETSU_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_SHISETSU_HISTORY.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

// [CCCX:4273][Shinobu Hitaka] 2017/08/29 edit begin �`�F�b�N���@�ύX
//
// [CCCX:2846][Shinobu Hitaka] 2015/07/23 add begin ��������җL�݂̂��擾
//    sb.append("AND");
//
//    sb.append("(");
//
//    sb.append(" PATIENT_SHISETSU_HISTORY.TOKUTEI_NYUSHO_FLAG = 2");
//    
//    sb.append(")");
// [CCCX:2846][Shinobu Hitaka] 2015/07/23 add end

    sb.append(" ORDER BY");

    sb.append(" SHISETSU_VALID_START");

    sb.append(" DESC");
// [CCCX:4273][Shinobu Hitaka] 2017/08/29 edit end

    return sb.toString();
  }

  /**
   * �u���p�Ҍ�������擾�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_PATIENT_KOHI(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",KOHI_ID");

    sb.append(",KOHI_VALID_START");

    sb.append(",KOHI_VALID_END");

    sb.append(" FROM");

    sb.append(" PATIENT_KOHI");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" KOHI_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" KOHI_VALID_END");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" KOHI_TYPE NOT IN(");

    sb.append(" SELECT");

    sb.append(" KOHI_TYPE");

    sb.append(" FROM");

    sb.append(" PATIENT_KOHI");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append(" AND");

    sb.append("(");

    sb.append(" KOHI_VALID_END");

    sb.append(" >");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(" GROUP BY KOHI_TYPE");

    sb.append(")");

    sb.append(")");

    return sb.toString();
  }
}
