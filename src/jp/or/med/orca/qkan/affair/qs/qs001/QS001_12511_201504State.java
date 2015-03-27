
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
 * �J����: ����@��F
 * �쐬��: 2012/03/08  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�Z�������×{���i���V�l�ی��{�݁j (QS001_12511_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[�����\�h�Z�������×{���i���V�l�ی��{�݁j��Ԓ�`(QS001_12511_201504) 
 */
public class QS001_12511_201504State extends QS001_12511_201504Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_12511_201504State(){
  }

  /**
   * �u���V�l�ی��{�݁iI�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_1() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision1RadioGroup().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision2RadioGroup().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(false);

        getRecuperationRadio().setEnabled(false);
        getRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iI�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_2() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1RadioGroup().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision2RadioGroup().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(false);

        getRecuperationRadio().setEnabled(false);
        getRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * �u���V�l�ی��{�݁iII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_3() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision1RadioGroup().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2RadioGroup().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_4() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1RadioGroup().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2RadioGroup().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���V�l�ی��{�݁iIII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_5() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision1RadioGroup().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2RadioGroup().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iIII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_6() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1RadioGroup().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2RadioGroup().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u�H���e�L�X�g�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DINNER_COST_ENABLE_FALSE() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(false);

  }

  /**
   * �u�H���e�L�X�g�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DINNER_COST_ENABLE_TRUE() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(true);

  }

  /**
   * �u��N���F�m�Ǘ��p�Ҏ�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u��N���F�m�Ǘ��p�Ҏ�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_DEMENTIA_ACTION() throws Exception {

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_DEMENTIA_ACTION() throws Exception {

        getDementiaActionAddRadioGroup().setEnabled(false);
        getDementiaActionAddRadioGroup().getParent().setEnabled(false);

  }

}
