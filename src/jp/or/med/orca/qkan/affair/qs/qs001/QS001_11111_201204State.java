
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
 * �쐬��: 2012/02/24  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K���� (QS001_11111_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[���K�����Ԓ�`(QS001_11111_201204) 
 */
public class QS001_11111_201204State extends QS001_11111_201204Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_11111_201204State(){
  }

  /**
   * �u�g�̉��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SHINTAI_KAIGO() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(true);
        getHomonkaigoTeikyoTime().getParent().setEnabled(true);

        getHoumonKaigoInTime().setEnabled(false);
        getHoumonKaigoInTime().getParent().setEnabled(false);

        getHoumonKaigoNumberOfPeople().setEnabled(true);
        getHoumonKaigoNumberOfPeople().getParent().setEnabled(true);

        getHoumonKaigoEmergencyAddRadioGroup().setEnabled(true);
        getHoumonKaigoEmergencyAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u���������v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SEIKATSU_ENJO() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(false);
        getHomonkaigoTeikyoTime().getParent().setEnabled(false);

        getHoumonKaigoInTime().setEnabled(true);
        getHoumonKaigoInTime().getParent().setEnabled(true);

        getHoumonKaigoNumberOfPeople().setEnabled(true);
        getHoumonKaigoNumberOfPeople().getParent().setEnabled(true);

        getHoumonKaigoEmergencyAddRadioGroup().setEnabled(false);
        getHoumonKaigoEmergencyAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u�g�̐����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SHINTAI_SEIKATSU() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(true);
        getHomonkaigoTeikyoTime().getParent().setEnabled(true);

        getHoumonKaigoInTime().setEnabled(true);
        getHoumonKaigoInTime().getParent().setEnabled(true);

        getHoumonKaigoNumberOfPeople().setEnabled(true);
        getHoumonKaigoNumberOfPeople().getParent().setEnabled(true);

        getHoumonKaigoEmergencyAddRadioGroup().setEnabled(true);
        getHoumonKaigoEmergencyAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�ʉ@����~��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_JOKOKAIJO() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(false);
        getHomonkaigoTeikyoTime().getParent().setEnabled(false);

        getHoumonKaigoInTime().setEnabled(false);
        getHoumonKaigoInTime().getParent().setEnabled(false);

        getHoumonKaigoNumberOfPeople().setEnabled(false);
        getHoumonKaigoNumberOfPeople().getParent().setEnabled(false);

        getHoumonKaigoEmergencyAddRadioGroup().setEnabled(false);
        getHoumonKaigoEmergencyAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u2���T�[�r�X�񋟐ӔC�ҁE�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CLASS2_VALID() throws Exception {

        getHoumonKaigoClass().setEnabled(true);
        getHoumonKaigoClass().getParent().setEnabled(true);

  }

  /**
   * �u2���T�[�r�X�񋟐ӔC�ҁE�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CLASS2_INVALID() throws Exception {

        getHoumonKaigoClass().setEnabled(false);
        getHoumonKaigoClass().getParent().setEnabled(false);

  }

}
