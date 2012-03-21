
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
 * �쐬��: 2005/12/14  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �v�揑������ (001)
 * �v���O���� �v�揑������ (QC001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc001;
/**
 * �v�揑�����͏�Ԓ�`(QC001) 
 */
public class QC001State extends QC001Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC001State(){
  }

  /**
   * �u������ԁv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_INIT_STATE() throws Exception {

        getPatientName().setEditable(false);

        getPatientBirth().setEditable(false);

        getPatientAge().setEditable(false);

        getPatientAddress().setEditable(false);

  }

  /**
   * �u���_�E�������I����ԁv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_NOTE_SELECTED() throws Exception {

        getPlanNoteEditButtonEdit().setEnabled(true);

        getPlanNoteEditButtonDelete().setEnabled(true);

  }

  /**
   * �u���_�E���������I����ԁv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_NOTE_UNSELECTED() throws Exception {

        getPlanNoteEditButtonEdit().setEnabled(false);

        getPlanNoteEditButtonDelete().setEnabled(false);

  }

  /**
   * �u�o�^���[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_PROCESS_MODE_INSERT() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * �u�X�V���[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_PROCESS_MODE_UPDATE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

}
