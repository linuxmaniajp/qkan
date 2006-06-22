
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
 * �J����: �� ����
 * �쐬��: 2006/01/18  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[������×{�Ǘ��w�� (001)
 * �v���O���� �T�[�r�X�p�^�[������×{�Ǘ��w�� (QS001018)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[������×{�Ǘ��w����Ԓ�`(QS001018) 
 */
public class QS001017State extends QS001017Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001017State(){
  }

  /**
   * �u��t�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_DOCTOR() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(true);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio().setEnabled(false);

  }

  /**
   * �u���Ȉ�t�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_DENTAL() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio().setEnabled(false);

  }

  /**
   * �u��܎t�i��Ë@�ցj�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_CHEMIST_HOSPITAL() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(true);

        getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio().setEnabled(false);

  }

  /**
   * �u��܎t�i��ǁj�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_CHEMIST_PHARMACY() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(true);

        getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio().setEnabled(true);

  }

  /**
   * �u�h�{�m�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_DIETICIAN() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio().setEnabled(false);

  }

  /**
   * �u���ȉq���m���I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_DENTAL_HYGIENIST() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio().setEnabled(true);

  }

}
