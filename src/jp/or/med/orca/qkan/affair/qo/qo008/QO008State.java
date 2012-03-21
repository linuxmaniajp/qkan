
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
 * �쐬��: 2006/02/18  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ��^���ҏW (008)
 * �v���O���� ��^���ҏW (QO008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo008;
/**
 * ��^���ҏW��Ԓ�`(QO008) 
 */
public class QO008State extends QO008Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO008State(){
  }

  /**
   * �u��^�����I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ITEM_UNSELECTED() throws Exception {

        getFixedFormEditInsert().setEnabled(true);

        getFixedFormEditUpdate().setEnabled(false);

        getFixedFormEditDelete().setEnabled(false);

        getFixedFormEditCancelDelete().setEnabled(false);

        getFixedFormEditItemManipulateButtonUp().setEnabled(false);

        getFixedFormEditItemManipulateButtonDown().setEnabled(false);

  }

  /**
   * �u��^���I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ITEM_SELECTED() throws Exception {

        getFixedFormEditInsert().setEnabled(true);

        getFixedFormEditUpdate().setEnabled(true);

        getFixedFormEditDelete().setEnabled(true);

        getFixedFormEditCancelDelete().setEnabled(true);

        getFixedFormEditItemManipulateButtonUp().setEnabled(true);

        getFixedFormEditItemManipulateButtonDown().setEnabled(true);

  }

  /**
   * �u�ҏW�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNEDITABLE() throws Exception {

        getFixedFormEditInsert().setEnabled(false);

        getFixedFormEditUpdate().setEnabled(false);

        getFixedFormEditDelete().setEnabled(false);

        getFixedFormEditCancelDelete().setEnabled(false);

        getFixedFormEditItemManipulateButtonUp().setEnabled(false);

        getFixedFormEditItemManipulateButtonDown().setEnabled(false);

        getFixedFormEditComments().setEnabled(false);

        getFixedFormEditComment1().setEnabled(false);

        getFixedFormEditComment2().setEnabled(false);

        getFixedFormEditItemTable().setEnabled(false);

        getFixedFormEditInputLeft().setEnabled(false);

        getFixedFormEditInputCaption1().setEnabled(false);

        getFixedFormEditInputCaption2().setEnabled(false);

        getFixedFormEditInputCaption3().setEnabled(false);

        getFixedFormEditInputAndCompileTextBox().setEnabled(false);

  }

  /**
   * �u�ҏW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_EDITABLE() throws Exception {

        getFixedFormEditInsert().setEnabled(true);

        getFixedFormEditUpdate().setEnabled(true);

        getFixedFormEditDelete().setEnabled(true);

        getFixedFormEditCancelDelete().setEnabled(true);

        getFixedFormEditItemManipulateButtonUp().setEnabled(true);

        getFixedFormEditItemManipulateButtonDown().setEnabled(true);

        getFixedFormEditComments().setEnabled(true);

        getFixedFormEditComment1().setEnabled(true);

        getFixedFormEditComment2().setEnabled(true);

        getFixedFormEditItemTable().setEnabled(true);

        getFixedFormEditInputLeft().setEnabled(true);

        getFixedFormEditInputCaption1().setEnabled(true);

        getFixedFormEditInputCaption2().setEnabled(true);

        getFixedFormEditInputCaption3().setEnabled(true);

        getFixedFormEditInputAndCompileTextBox().setEnabled(true);

  }

}
