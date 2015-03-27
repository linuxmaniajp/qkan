
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
 * �쐬��: 2012/02/20  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h����×{�Ǘ��w�� (QS001_13411_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[�����\�h����×{�Ǘ��w����Ԓ�`(QS001_13411_201504) 
 */
public class QS001_13411_201504State extends QS001_13411_201504Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_13411_201504State(){
  }

  /**
   * �u��ʏ��-��t�I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_1() throws Exception {

        getMedicineManagementRadioGroup().setEnabled(true);
        getMedicineManagementRadioGroup().getParent().setEnabled(true);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getSpecialMedicineRadioGroup().setEnabled(false);
        getSpecialMedicineRadioGroup().getParent().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

  /**
   * �u��ʏ��-���Ȉ�t�I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_2() throws Exception {

        getMedicineManagementRadioGroup().setEnabled(false);
        getMedicineManagementRadioGroup().getParent().setEnabled(false);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getSpecialMedicineRadioGroup().setEnabled(false);
        getSpecialMedicineRadioGroup().getParent().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

  /**
   * �u��ʏ��-��܎t�i��Ë@�ցj�I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_3() throws Exception {

        getMedicineManagementRadioGroup().setEnabled(false);
        getMedicineManagementRadioGroup().getParent().setEnabled(false);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getSpecialMedicineRadioGroup().setEnabled(true);
        getSpecialMedicineRadioGroup().getParent().setEnabled(true);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

  /**
   * �u��ʏ��-��܎t�i��ǁj�I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_4() throws Exception {

        getMedicineManagementRadioGroup().setEnabled(false);
        getMedicineManagementRadioGroup().getParent().setEnabled(false);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getSpecialMedicineRadioGroup().setEnabled(true);
        getSpecialMedicineRadioGroup().getParent().setEnabled(true);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(true);

  }

  /**
   * �u��ʏ��-�Ǘ��h�{�m�I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_5() throws Exception {

        getMedicineManagementRadioGroup().setEnabled(false);
        getMedicineManagementRadioGroup().getParent().setEnabled(false);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getSpecialMedicineRadioGroup().setEnabled(false);
        getSpecialMedicineRadioGroup().getParent().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

  /**
   * �u��ʏ��-���ȉq���m���I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_6() throws Exception {

        getMedicineManagementRadioGroup().setEnabled(false);
        getMedicineManagementRadioGroup().getParent().setEnabled(false);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getSpecialMedicineRadioGroup().setEnabled(false);
        getSpecialMedicineRadioGroup().getParent().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

  /**
   * �u��ʏ��-�Ō�E���I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_7() throws Exception {

        getMedicineManagementRadioGroup().setEnabled(false);
        getMedicineManagementRadioGroup().getParent().setEnabled(false);

        getKyotakuClass().setEnabled(true);
        getKyotakuClass().getParent().setEnabled(true);

        getSpecialMedicineRadioGroup().setEnabled(false);
        getSpecialMedicineRadioGroup().getParent().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

}
