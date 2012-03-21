
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
 * �쐬��: 2011/12/19  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�ғo�^ (002)
 * �v���O���� ���p�ғo�^ (QU002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu002;
/**
 * ���p�ғo�^��Ԓ�`(QU002) 
 */
@SuppressWarnings("serial")
public class QU002State extends QU002Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU002State(){
  }

  /**
   * �u�����ҏW�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_KAIGO_BUTTON_FALSE() throws Exception {

        getKaigoInfoButtonEdit().setEnabled(false);

        getKaigoInfoDelete().setEnabled(false);

  }

  /**
   * �u�����ҏW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_KAIGO_BUTTON_TRUE() throws Exception {

        getKaigoInfoButtonEdit().setEnabled(true);

        getKaigoInfoDelete().setEnabled(true);

  }

  /**
   * �u�ٓ����ҏW�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_IDOU_BUTTON_FALSE() throws Exception {

        getIdouInfoButtonEdit().setEnabled(false);

        getIdouInfoButtonDelete().setEnabled(false);

  }

  /**
   * �u�ٓ����ҏW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_IDOU_BUTTON_TRUE() throws Exception {

        getIdouInfoButtonEdit().setEnabled(true);

        getIdouInfoButtonDelete().setEnabled(true);

  }

  /**
   * �u�ٓ������L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_TIME_TRUE() throws Exception {

        getIdouInfoTime().setEnabled(true);
        getIdouInfoTime().getParent().setEnabled(true);

  }

  /**
   * �u�ٓ������L���s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_TIME_FALSE() throws Exception {

        getIdouInfoTime().setEnabled(false);
        getIdouInfoTime().getParent().setEnabled(false);

  }

  /**
   * �u�x�����Ə��R���{�L���s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_SHIEN_FALSE() throws Exception {

        getKaigoInfoKyotakuServicePlanCombo().setEnabled(false);

  }

  /**
   * �u�x�����Ə��R���{�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_SHIEN_TRUE() throws Exception {

        getKaigoInfoKyotakuServicePlanCombo().setEnabled(true);

  }

  /**
   * �u���̑����e��\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VISIBLE_REASON_MEMO_FALSE() throws Exception {

        getIdouInfoReasonMemo().getParent().setVisible(false);

  }

  /**
   * �u���̑����e�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VISIBLE_REASON_MEMO_TRUE() throws Exception {

        getIdouInfoReasonMemo().getParent().setVisible(true);

  }

  /**
   * �u�Ɩ��{�^���ݒ�i�o�^���[�h��ԂɕύX�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INSERT_MODE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

        getClearInsertMode().setVisible(true);

        getClearUpdateMode().setVisible(false);

  }

  /**
   * �u�Ɩ��{�^���ݒ�i�X�V���[�h��ԂɕύX�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UPDATE_MODE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

        getClearInsertMode().setVisible(false);

        getClearUpdateMode().setVisible(true);

  }

  /**
   * �u�ٓ��̈揉�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_IDOU_INIT() throws Exception {

        getIdouInfoChangeContent().setEnabled(false);
        getIdouInfoChangeContent().getParent().setEnabled(false);

        getIdouInfoTime().setEnabled(false);
        getIdouInfoTime().getParent().setEnabled(false);

        getIdouInfoReason().setEnabled(false);
        getIdouInfoReason().getParent().setEnabled(false);

        getIdouInfoReasonMemo().getParent().setVisible(false);

  }

  /**
   * �u�ٓ����R�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_REASON_TRUE() throws Exception {

        getIdouInfoReason().setEnabled(true);
        getIdouInfoReason().getParent().setEnabled(true);

  }

  /**
   * �u�ٓ����R�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_REASON_FALSE() throws Exception {

        getIdouInfoReason().setEnabled(false);
        getIdouInfoReason().getParent().setEnabled(false);

  }

  /**
   * �u�ٓ����R�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_CONTENT_TRUE() throws Exception {

        getIdouInfoChangeContent().setEnabled(true);
        getIdouInfoChangeContent().getParent().setEnabled(true);

  }

  /**
   * �u�ٓ����R�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_CONTENT_FALSE() throws Exception {

        getIdouInfoChangeContent().setEnabled(false);
        getIdouInfoChangeContent().getParent().setEnabled(false);

  }

  /**
   * �u���S���x�z�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_TOKUTEI_NYUSHO_FALSE() throws Exception {

        getInstitutionInfoDinnerBearLimitMoneyText().setEnabled(false);

        getInstitutionInfoUnitRoomLimitMoneyText().setEnabled(false);

        getInstitutionInfoUnitSemiRoomLimitMoneyText().setEnabled(false);

        getInstitutionInfoNormalRoomLimitMoneyText().setEnabled(false);

        getInstitutionInfoNormalRoomLimitMoneyText2().setEnabled(false);

        getInstitutionInfoTasyoRoomLimitMoneyText().setEnabled(false);

        getInstitutionInfoDinnerBearLimitMoneyContena().setEnabled(false);

        getInstitutionInfoDinnerBearLimitMoneyLabel().setEnabled(false);

        getInstitutionInfoUnitRoomLimitMoneyContena().setEnabled(false);

        getInstitutionInfoUnitRoomLimitMoneyLabel().setEnabled(false);

        getInstitutionInfoUnitSemiRoomLimitMoneyContena().setEnabled(false);

        getInstitutionInfoUnitSemiRoomLimitMoneyLabel().setEnabled(false);

        getInstitutionInfoNormalRoomLimitMoneyContena().setEnabled(false);

        getInstitutionInfoNormalRoomLimitMoneyLabel().setEnabled(false);

        getInstitutionInfoNormalRoomLimitMoneyContena2().setEnabled(false);

        getInstitutionInfoNormalRoomLimitMoneyLabel2().setEnabled(false);

        getInstitutionInfoTasyoRoomLimitMoneyContena().setEnabled(false);

        getInstitutionInfoTasyoRoomLimitMoneyLabel().setEnabled(false);

  }

  /**
   * �u���S���x�z�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_TOKUTEI_NYUSHO_TRUE() throws Exception {

        getInstitutionInfoDinnerBearLimitMoneyText().setEnabled(true);

        getInstitutionInfoUnitRoomLimitMoneyText().setEnabled(true);

        getInstitutionInfoUnitSemiRoomLimitMoneyText().setEnabled(true);

        getInstitutionInfoNormalRoomLimitMoneyText().setEnabled(true);

        getInstitutionInfoNormalRoomLimitMoneyText2().setEnabled(true);

        getInstitutionInfoTasyoRoomLimitMoneyText().setEnabled(true);

        getInstitutionInfoDinnerBearLimitMoneyContena().setEnabled(true);

        getInstitutionInfoDinnerBearLimitMoneyLabel().setEnabled(true);

        getInstitutionInfoUnitRoomLimitMoneyContena().setEnabled(true);

        getInstitutionInfoUnitRoomLimitMoneyLabel().setEnabled(true);

        getInstitutionInfoUnitSemiRoomLimitMoneyContena().setEnabled(true);

        getInstitutionInfoUnitSemiRoomLimitMoneyLabel().setEnabled(true);

        getInstitutionInfoNormalRoomLimitMoneyContena().setEnabled(true);

        getInstitutionInfoNormalRoomLimitMoneyLabel().setEnabled(true);

        getInstitutionInfoNormalRoomLimitMoneyContena2().setEnabled(true);

        getInstitutionInfoNormalRoomLimitMoneyLabel2().setEnabled(true);

        getInstitutionInfoTasyoRoomLimitMoneyContena().setEnabled(true);

        getInstitutionInfoTasyoRoomLimitMoneyLabel().setEnabled(true);

  }

}
