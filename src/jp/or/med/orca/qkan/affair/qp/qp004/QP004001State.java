
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
 * �J����: �c���@����
 * �쐬��: 2006/04/07  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (004)
 * �v���O���� ���莡�Ô�ҏW��� (QP004001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp004;
/**
 * ���莡�Ô�ҏW��ʏ�Ԓ�`(QP004001) 
 */
public class QP004001State extends QP004001Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP004001State(){
  }

  /**
   * �u���R�[�h���I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_RECORD_DESELECTED() throws Exception {

        getMedicalUpdate().setEnabled(false);

        getMedicalDelete().setEnabled(false);

  }

  /**
   * �u���R�[�h�I�𒆁v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_RECORD_SELECTED() throws Exception {

        getMedicalUpdate().setEnabled(true);

        getMedicalDelete().setEnabled(true);

  }

}
