
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
 * �쐬��: 2006/06/12  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\��E���� (001)
 * �v���O���� ���p�E�񋟕[��� (QS001031)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * ���p�E�񋟕[�����Ԓ�`(QS001031) 
 */
@SuppressWarnings("serial")
public class QS001003State extends QS001003Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001003State(){
  }

  /**
   * �u�쐬�ҁE���Ə��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PROVIDER_MADE() throws Exception {

        getSupportProviderCd().setEnabled(true);

        getSupportProviderName().setEnabled(true);

        getPersonInCharge().setEnabled(true);

        getDateOfWrittenReport().setEnabled(false);

  }

  /**
   * �u�쐬�ҁE��ی��ҁv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELF_MADE() throws Exception {

        getSupportProviderCd().setEnabled(false);

        getSupportProviderName().setEnabled(false);

        getPersonInCharge().setEnabled(false);

        getDateOfWrittenReport().setEnabled(true);

  }

  /**
   * �u�\�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PROCESS_TYPE_PLAN() throws Exception {

        getDateOfMakingOutsideFrame().getParent().setVisible(true);

        getPublicExpense().setVisible(true);

        getSlitKinds().setVisible(true);

  }

  /**
   * �u���ш���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PROCESS_TYPE_RESULT() throws Exception {

        getDateOfMakingOutsideFrame().getParent().setVisible(false);

        getPublicExpense().setVisible(false);

        getSlitKinds().setVisible(false);

  }

}
