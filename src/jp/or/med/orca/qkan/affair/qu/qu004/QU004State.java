
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
 * �J����: ��i�@�a�P
 * �쐬��: 2011/11/16  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ����E�Е��y����� (004)
 * �v���O���� ����E�Е��y����� (QU004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu004;
/**
 * ����E�Е��y������Ԓ�`(QU004) 
 */
@SuppressWarnings("serial")
public class QU004State extends QU004Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU004State(){
  }

  /**
   * �u������ҏW�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_KAIGO_BUTTON_FALSE() throws Exception {

        getKaigoInfoButtonConpile().setEnabled(false);

        getKaigoInfoButtonDelete().setEnabled(false);

  }

  /**
   * �u������ҏW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_KAIGO_BUTTON_TRUE() throws Exception {

        getKaigoInfoButtonConpile().setEnabled(true);

        getKaigoInfoButtonDelete().setEnabled(true);

  }

  /**
   * �u�Ɩ��{�^���ݒ�i�o�^���[�h�֕ύX�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INSERT_MODE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * �u�Ɩ��{�^���ݒ�i�X�V���[�h�֕ύX�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UPDATE_MODE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

  /**
   * �u�Љ�����ƕҏW�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_SHAHUKU_BUTTON_FALSE() throws Exception {

        getShahukuInfoButtonConpile().setEnabled(false);

        getShahukuInfoButtonDelete().setEnabled(false);

  }

  /**
   * �u�Љ�����ƕҏW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_SHAHUKU_BUTTON_TRUE() throws Exception {

        getShahukuInfoButtonConpile().setEnabled(true);

        getShahukuInfoButtonDelete().setEnabled(true);

  }

  /**
   * �u��삻�̑�����OFF�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_KAIGO_OTHER_OFF() throws Exception {

        getKaigoInfoKohiNo().setEditable(false);

        getKaigoInfoServices().setVisible(false);

  }

  /**
   * �u��삻�̑�����ON�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_KAIGO_OTHER_ON() throws Exception {

        getKaigoInfoKohiNo().setEditable(true);

        getKaigoInfoServices().setVisible(true);

  }

}
