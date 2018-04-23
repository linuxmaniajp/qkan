
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
 * �쐬��: 2011/11/16  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�����p��ݗ^ (QS001_16711_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[�����\�h�����p��ݗ^��Ԓ�`(QS001_16711_201804) 
 */
@SuppressWarnings("serial")
public class QS001_16711_201804State extends QS001_16711_201804Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_16711_201804State(){
  }

  /**
   * �u���n���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_ADD_SPECIAL_AREA() throws Exception {

        getWelfareTokuchiPoint().setEnabled(false);

  }

  /**
   * �u���n���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_ADD_SPECIAL_AREA() throws Exception {

        getWelfareTokuchiPoint().setEnabled(true);

  }

  /**
   * �u���R�Ԓn�擙���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_ADD_MOUNTAINOUS_AREA() throws Exception {

        getProviderAddMountainousAreaScalePoint().setEnabled(false);

  }

  /**
   * �u���R�Ԓn�擙���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_ADD_MOUNTAINOUS_AREA() throws Exception {

        getProviderAddMountainousAreaScalePoint().setEnabled(true);

  }

}
