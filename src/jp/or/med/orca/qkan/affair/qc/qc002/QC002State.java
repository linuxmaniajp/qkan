
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
 * �쐬��: 2006/01/16  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �񍐏������� (002)
 * �v���O���� �񍐏������� (QC002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc002;
/**
 * �񍐏������͏�Ԓ�`(QC002) 
 */
public class QC002State extends QC002Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC002State(){
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
   * �u�J�����_�[���E��̌��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_CALENDAR_LEFT_ODD_MONTH() throws Exception {

        getCalendarLeftDay29().setVisible(true);

        getCalendarLeftDay30().setVisible(true);

        getCalendarLeftDay31().setVisible(true);

        getCalendarLeftDay29Label().setVisible(false);

        getCalendarLeftDay30Label().setVisible(false);

        getCalendarLeftDay31Label().setVisible(false);

  }

  /**
   * �u�J�����_�[���E���̌��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_CALENDAR_LEFT_EVEN_MONTH() throws Exception {

        getCalendarLeftDay29().setVisible(true);

        getCalendarLeftDay30().setVisible(true);

        getCalendarLeftDay31().setVisible(false);

        getCalendarLeftDay29Label().setVisible(false);

        getCalendarLeftDay30Label().setVisible(false);

        getCalendarLeftDay31Label().setVisible(true);

  }

  /**
   * �u�J�����_�[���E2���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_CALENDAR_LEFT_FEBRUARY() throws Exception {

        getCalendarLeftDay29().setVisible(false);

        getCalendarLeftDay30().setVisible(false);

        getCalendarLeftDay31().setVisible(false);

        getCalendarLeftDay29Label().setVisible(true);

        getCalendarLeftDay30Label().setVisible(true);

        getCalendarLeftDay31Label().setVisible(true);

  }

  /**
   * �u�J�����_�[���E2���[�N�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_CALENDAR_LEFT_BISSEXTILE() throws Exception {

        getCalendarLeftDay29().setVisible(true);

        getCalendarLeftDay30().setVisible(false);

        getCalendarLeftDay31().setVisible(false);

        getCalendarLeftDay29Label().setVisible(false);

        getCalendarLeftDay30Label().setVisible(true);

        getCalendarLeftDay31Label().setVisible(true);

  }

  /**
   * �u�J�����_�[�E�E��̌��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_CALENDAR_RIGHT_ODD_MONTH() throws Exception {

        getCalendarRightDay29().setVisible(true);

        getCalendarRightDay30().setVisible(true);

        getCalendarRightDay31().setVisible(true);

        getCalendarRightDay29Label().setVisible(false);

        getCalendarRightDay30Label().setVisible(false);

        getCalendarRightDay31Label().setVisible(false);

  }

  /**
   * �u�J�����_�[�E�E���̌��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_CALENDAR_RIGHT_EVEN_MONTH() throws Exception {

        getCalendarRightDay29().setVisible(true);

        getCalendarRightDay30().setVisible(true);

        getCalendarRightDay31().setVisible(false);

        getCalendarRightDay29Label().setVisible(false);

        getCalendarRightDay30Label().setVisible(false);

        getCalendarRightDay31Label().setVisible(true);

  }

  /**
   * �u�J�����_�[�E�E2���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_CALENDAR_RIGHT_FEBRUARY() throws Exception {

        getCalendarRightDay29().setVisible(false);

        getCalendarRightDay30().setVisible(false);

        getCalendarRightDay31().setVisible(false);

        getCalendarRightDay29Label().setVisible(true);

        getCalendarRightDay30Label().setVisible(true);

        getCalendarRightDay31Label().setVisible(true);

  }

  /**
   * �u�J�����_�[�E�E2���[�N�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  protected void setState_CALENDAR_RIGHT_BISSEXTILE() throws Exception {

        getCalendarRightDay29().setVisible(true);

        getCalendarRightDay30().setVisible(false);

        getCalendarRightDay31().setVisible(false);

        getCalendarRightDay29Label().setVisible(false);

        getCalendarRightDay30Label().setVisible(true);

        getCalendarRightDay31Label().setVisible(true);

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
