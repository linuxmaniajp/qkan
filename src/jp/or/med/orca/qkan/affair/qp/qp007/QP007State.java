
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
 * �J����: �����@�L
 * �쐬��: 2006/02/15  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X ���p�Ҍ������ (007)
 * �v���O���� ���p�Ҍ�����������ݒ� (QP007)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp007;
/**
 * ���p�Ҍ�����������ݒ��Ԓ�`(QP007) 
 */
public class QP007State extends QP007Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP007State(){
  }

  /**
   * �u���������W�I�{�^���N���b�N�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_RADIO_1() throws Exception {

        getPatientBillSetupUnderPrintOn().setEnabled(true);

        getPatientBillSetupMedicalTreatmentOn().setEnabled(false);

  }

  /**
   * �u�̎������W�I�{�^���N���b�N�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_RADIO_2() throws Exception {

        getPatientBillSetupUnderPrintOn().setEnabled(false);

        getPatientBillSetupMedicalTreatmentOn().setEnabled(true);

  }

  /**
   * �u�������E�̎������W�I�{�^���N���b�N�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_RADIO_3() throws Exception {

        getPatientBillSetupUnderPrintOn().setEnabled(true);

        getPatientBillSetupMedicalTreatmentOn().setEnabled(true);

  }

}
