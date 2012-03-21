
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
 * �쐬��: 2006/02/21  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��Ǘ� (004)
 * �v���O���� ���Ə��o�^ (QO004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
/**
 * ���Ə��o�^��Ԓ�`(QO004) 
 */
public class QO004State extends QO004Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004State(){
  }

  /**
   * �u������ԁv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_STATE() throws Exception {

        getProviderStaffInsert().setEnabled(true);

        getProviderStaffFind().setEnabled(false);

        getProviderStaffDelete().setEnabled(false);

        getReflection().setEnabled(true);

        getOfferCheck().setEnabled(true);

        getProviderDetailServiceDetails().setEnabled(false);

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

        getClear().setVisible(true);

        getNewData().setVisible(false);

        getProviderId().setEditable(true);

  }

  /**
   * �u�ǉ�����\�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STAFF_BUTTON_STATE1() throws Exception {

        getProviderStaffInsert().setEnabled(true);

        getProviderStaffFind().setEnabled(false);

        getProviderStaffDelete().setEnabled(false);

  }

  /**
   * �u�ǉ��E�ҏW�E�폜�\�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STAFF_BUTTON_STATE2() throws Exception {

        getProviderStaffInsert().setEnabled(true);

        getProviderStaffFind().setEnabled(true);

        getProviderStaffDelete().setEnabled(true);

  }

  /**
   * �u�񋟃T�[�r�X�ڍ׏��{�^��������ԁv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_DETAIL_BUTTON_ENABLE_TRUE() throws Exception {

        getReflection().setEnabled(true);

        getOfferCheck().setEnabled(true);

  }

  /**
   * �u�񋟃T�[�r�X�ڍ׏��{�^�������s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_DETAIL_BUTTON_ENABLE_FALSE() throws Exception {

        getReflection().setEnabled(false);

        getOfferCheck().setEnabled(false);

  }

  /**
   * �u�T�[�r�X�p�l������\�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_PANEL_ENABLE_TRUE() throws Exception {

        getProviderDetailServiceDetails().setEnabled(true);

  }

  /**
   * �u�T�[�r�X�p�l������s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_PANEL_ENABLE_FALSE() throws Exception {

        getProviderDetailServiceDetails().setEnabled(false);

  }

  /**
   * �u�o�^���[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INSERT_STATE() throws Exception {

        getReflection().setVisible(true);

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

        getClear().setVisible(true);

        getNewData().setVisible(false);

        getProviderId().setEditable(true);

  }

  /**
   * �u�X�V���[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UPDATE_STATE() throws Exception {

        getReflection().setVisible(true);

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

        getClear().setVisible(false);

        getNewData().setVisible(true);

        getProviderId().setEditable(false);

  }

}
