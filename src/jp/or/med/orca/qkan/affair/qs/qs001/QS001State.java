
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
 * �쐬��: 2011/12/13  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�\�� (QS001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�\���Ԓ�`(QS001) 
 */
public class QS001State extends QS001Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001State(){
  }

  /**
   * �u�X�V���[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PROCESS_MODE_INSERT() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * �u�o�^���[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PROCESS_MODE_UPDATE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

  /**
   * �u�T�ԃT�[�r�X�v��[����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PRINT_WEEKLY() throws Exception {

        getPrintWeekly().setVisible(true);

        getPrintMonthly().setVisible(false);

        getOpenPlan().setEnabled(true);

        getOpenResult().setEnabled(false);

  }

  /**
   * �u���p�[�E�񋟕[����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PRINT_MONTHLY() throws Exception {

        getPrintWeekly().setVisible(false);

        getPrintMonthly().setVisible(true);

        getOpenPlan().setEnabled(false);

        getOpenResult().setEnabled(true);

  }

  /**
   * �u�T�[�r�X�p�^�[���I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_PATTERN_SELECTED() throws Exception {

        getPatternDelete().setEnabled(true);

        getServiceDelete().setEnabled(false);

        getPatternNameChange().setEnabled(true);

  }

  /**
   * �u�T�[�r�X�p�^�[�����I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_PATTERN_UNSELECTED() throws Exception {

        getPatternDelete().setEnabled(false);

        getPatternNameChange().setEnabled(false);

  }

  /**
   * �u�\�胂�[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_AFFIR_MODE_PLAN() throws Exception {

        getClearPlan().setVisible(true);

        getOpenPlan().setVisible(true);

        getClearResult().setVisible(false);

        getOpenResult().setVisible(false);

  }

  /**
   * �u���у��[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_AFFIR_MODE_RESULT() throws Exception {

        getPrintWeekly().setVisible(false);

        getClearPlan().setVisible(false);

        getOpenPlan().setVisible(false);

        getClearResult().setVisible(true);

        getOpenResult().setVisible(true);

  }

  /**
   * �u���Ə����g�p�T�[�r�X�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_PROVIDER_SERVICE() throws Exception {

        getServiceOfferEntrepreneur().setEnabled(true);

  }

  /**
   * �u���Ə���񖢎g�p�T�[�r�X�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_PROVIDER_SERVICE() throws Exception {

        getServiceOfferEntrepreneur().setEnabled(false);

  }

  /**
   * �u�T�[�r�X�I�𒆁v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_SELECTED() throws Exception {

        getServiceSet().setEnabled(true);

        getServiceDelete().setEnabled(true);

  }

  /**
   * �u�T�[�r�X���I�𒆁v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_UNSELECTED() throws Exception {

        getServiceSet().setEnabled(false);

        getServiceDelete().setEnabled(false);

  }

  /**
   * �u�����Ə�������x�����񋟁v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_PROVIDE_CARE_MANAGEMENT() throws Exception {

        getOpenResult().setVisible(false);

  }

  /**
   * �u�����Ə�������x���񋟁v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PROVIDE_CARE_MANAGEMENT() throws Exception {

        getOpenResult().setVisible(true);

  }

  /**
   * �u�T�[�r�X���сE�T�Ԍv��\��������v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_RESULT_PRINT_WEEKLY() throws Exception {

        getPrintWeekly().setEnabled(false);

  }

  /**
   * �u���p�\���Ə��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USABLE_PROVIDER() throws Exception {

        getServiceSet().setEnabled(true);

        getPatternAdd().setEnabled(true);

        getPicture().setEnabled(true);

  }

  /**
   * �u���p�s�\���Ə��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USABLE_PROVIDER() throws Exception {

        getServiceSet().setEnabled(false);

        getPatternAdd().setEnabled(false);

        getPicture().setEnabled(false);

  }

}
