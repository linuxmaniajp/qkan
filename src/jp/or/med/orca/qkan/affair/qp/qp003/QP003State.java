
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
 * �쐬��: 2009/08/10  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (P)
 * �v���Z�X �m�F�E�C�� (003)
 * �v���O���� ���p�Ҍ��������ڍוҏW (QP003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp003;
/**
 * ���p�Ҍ��������ڍוҏW��Ԓ�`(QP003) 
 */
public class QP003State extends QP003Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP003State(){
  }

  /**
   * �u�o�^���[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INSERT_STATE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * �u�X�V���[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UPDATE_STATE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

  /**
   * �u���Ŕ�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVISIBLE_INNER_TAX() throws Exception {

        getContentInnerTaxLabel().setVisible(false);

        getContentInnerTaxText().setVisible(false);

  }

  /**
   * �u�J�����_�[�\��28���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CALENDER_MODE28() throws Exception {

        if(getCalendar29().getParent()!=null){
          getCalendar29().getParent().remove(getCalendar29());
        }

        if(getCalendar30().getParent()!=null){
          getCalendar30().getParent().remove(getCalendar30());
        }

        if(getCalendar31().getParent()!=null){
          getCalendar31().getParent().remove(getCalendar31());
        }

  }

  /**
   * �u�J�����_�[�\��29���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CALENDER_MODE29() throws Exception {

        if(getCalendar30().getParent()!=null){
          getCalendar30().getParent().remove(getCalendar30());
        }

        if(getCalendar31().getParent()!=null){
          getCalendar31().getParent().remove(getCalendar31());
        }

  }

  /**
   * �u�J�����_�[�\��30���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CALENDER_MODE30() throws Exception {

        if(getCalendar31().getParent()!=null){
          getCalendar31().getParent().remove(getCalendar31());
        }

  }

  /**
   * �u�J�����_�[�̈�E�I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CALENDER_SELECT() throws Exception {

        getOpen().setEnabled(false);

  }

  /**
   * �u�J�����_�[�̈�E��I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CALENDER_UNSELECT() throws Exception {

        getOpen().setEnabled(true);

  }

}
