
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
 * �쐬��: 2009/03/30  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� ��ԑΉ��^�K���� (QO004123)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
/**
 * ��ԑΉ��^�K�����Ԓ�`(QO004123) 
 */
public class QO004_17111_201804State extends QO004_17111_201804Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004_17111_201804State(){
  }

  /**
   * �u�p�l���S�̗L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SET_PANEL_TRUE() throws Exception {

        getMainGroup().setEnabled(true);

  }

  /**
   * �u�p�l���S�̖����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SET_PANEL_FALSE() throws Exception {

        getMainGroup().setEnabled(false);

  }

  /**
   * �u��{��ԖK��I�s�����Ǝ����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_BASE_MUNICIPALITY_ADD() throws Exception {

        getBaseMunicipalityAdd().setEnabled(true);
        getBaseMunicipalityAdd().getParent().setEnabled(true);

  }

  /**
   * �u��{��ԖK��I�s�����Ǝ����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_BASE_MUNICIPALITY_ADD() throws Exception {

        getBaseMunicipalityAdd().setEnabled(false);
        getBaseMunicipalityAdd().getParent().setEnabled(false);

  }

  /**
   * �u��ԖK��II�s�����Ǝ����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SERVICE_MUNICIPALITY_ADD() throws Exception {

        getServiceMunicipalityAdd().setEnabled(true);
        getServiceMunicipalityAdd().getParent().setEnabled(true);

  }

  /**
   * �u��ԖK��II�s�����Ǝ����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SERVICE_MUNICIPALITY_ADD() throws Exception {

        getServiceMunicipalityAdd().setEnabled(false);
        getServiceMunicipalityAdd().getParent().setEnabled(false);

  }

}
