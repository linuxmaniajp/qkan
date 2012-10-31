
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
 * �J����: �����@�L
 * �쐬��: 2011/02/10  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���ъm��/�������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� ���p�҈ꗗ�i�����j (QP001)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;
/**
 * ���p�҈ꗗ�i�����j��Ԓ�`(QP001) 
 */
@SuppressWarnings("serial")
public class QP001State extends QP001Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP001State(){
  }

  /**
   * �u���p�҈ꗗ�i���ъm��E�����f�[�^�쐬�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_01() throws Exception {

        getEntry().setVisible(true);

        getEntry().setEnabled(false);

        getFind().setVisible(true);

        getDelete().setVisible(true);

        getDelete().setEnabled(false);

        getPrint().setVisible(false);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(false);

        getCsvOut().setEnabled(false);

        getCommit().setVisible(true);

        getCommit().setEnabled(false);

        getClaimDateContainer().setVisible(false);

        getPrintConditions().setVisible(false);

        getTypeCountInfomations().setVisible(false);

        getDemandMoneyAndTotalDenominations().setVisible(false);

        getInfoTableColumn14().setVisible(false);

        getInfoTableColumn17().setVisible(false);

        getInfoTableColumn18().setVisible(false);

        getInfoTableColumn19().setVisible(false);

        getInfoTableColumn20().setVisible(false);

        getInfoTableColumn21().setVisible(false);

        getInfoTableColumn22().setVisible(false);

        getInfoTableColumn23().setVisible(false);

        getPrintList().setVisible(false);

        getPrintList().setEnabled(false);

  }

  /**
   * �u���p�҈ꗗ�i���t�Ǘ��[�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_02() throws Exception {

        getEntry().setVisible(false);

        getFind().setVisible(true);

        getDelete().setVisible(false);

        getPrint().setVisible(true);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(true);

        getCsvOut().setEnabled(false);

        getCommit().setVisible(false);

        getTargetDateContena().setVisible(false);

        getPrintConditions().setVisible(false);

        getUpdateConditions().setVisible(false);

        getNursingCountContainer().setVisible(false);

        getType7CountContainer().setVisible(false);

        getType2CountContainer().setVisible(false);

        getType3CountContainer().setVisible(false);

        getType4CountContainer().setVisible(false);

        getType5CountContainer().setVisible(false);

        getType6CountContainer().setVisible(false);

        getType8CountContainer().setVisible(false);

        getType9CountContainer().setVisible(false);

        getType10CountContainer().setVisible(false);

        getVisitCountContainer().setVisible(false);

        getSyahoCountContainer().setVisible(false);

        getKokuhoCountContainer().setVisible(false);

        getServiceCountContainer().setVisible(false);

        getDemandMoneyAndTotalDenominations().setVisible(false);

        getInfoTableColumn4().setVisible(false);

        getInfoTableColumn14().setVisible(false);

        getInfoTableColumn17().setVisible(false);

        getInfoTableColumn18().setVisible(false);

        getInfoTableColumn19().setVisible(false);

        getInfoTableColumn20().setVisible(false);

        getInfoTableColumn21().setVisible(false);

        getInfoTableColumn22().setVisible(false);

        getPrintList().setVisible(false);

        getPrintList().setEnabled(false);

  }

  /**
   * �u���p�҈ꗗ�i�ݑ�T�[�r�X�x�����Ə������j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_03() throws Exception {

        getEntry().setVisible(false);

        getFind().setVisible(true);

        getDelete().setVisible(false);

        getPrint().setVisible(true);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(false);

        getCsvOut().setEnabled(false);

        getCommit().setVisible(false);

        getTargetDateContena().setVisible(false);

        getPrintConditions().setVisible(false);

        getUpdateConditions().setVisible(false);

        getSupplyCountContainer().setVisible(false);

        getNursingCountContainer().setVisible(false);

        getType2CountContainer().setVisible(false);

        getType3CountContainer().setVisible(false);

        getType4CountContainer().setVisible(false);

        getType5CountContainer().setVisible(false);

        getType6CountContainer().setVisible(false);

        getType8CountContainer().setVisible(false);

        getType9CountContainer().setVisible(false);

        getType10CountContainer().setVisible(false);

        getVisitCountContainer().setVisible(false);

        getSyahoCountContainer().setVisible(false);

        getKokuhoCountContainer().setVisible(false);

        getServiceCountContainer().setVisible(false);

        getDemandMoneyInsuranceMoneyTextContainer().setVisible(false);

        getDemandMoneyPatientMoneyTextContainer().setVisible(false);

        getTotalDenominationPublicExpenseMoneyTextContainer().setVisible(false);

        getInfoTableColumn4().setVisible(false);

        getInfoTableColumn17().setVisible(false);

        getInfoTableColumn20().setVisible(false);

        getInfoTableColumn21().setVisible(false);

        getInfoTableColumn22().setVisible(false);

        getInfoTableColumn23().setVisible(false);

        getPrintList().setVisible(false);

        getPrintList().setEnabled(false);

  }

  /**
   * �u���p�҈ꗗ�i�ݑ�T�[�r�X�񋟎��Ə������j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_04() throws Exception {

        getEntry().setVisible(false);

        getFind().setVisible(true);

        getDelete().setVisible(false);

        getPrint().setVisible(true);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(false);

        getCsvOut().setEnabled(false);

        getCommit().setVisible(false);

        getTargetDateContena().setVisible(false);

        getPrintConditions().setVisible(false);

        getUpdateConditions().setVisible(false);

        getSupplyCountContainer().setVisible(false);

        getNursingCountContainer().setVisible(false);

        getType7CountContainer().setVisible(false);

        getVisitCountContainer().setVisible(false);

        getSyahoCountContainer().setVisible(false);

        getKokuhoCountContainer().setVisible(false);

        getServiceCountContainer().setVisible(false);

        getInfoTableColumn4().setVisible(false);

        getInfoTableColumn23().setVisible(false);

        getPrintList().setVisible(true);

        getPrintList().setEnabled(false);

  }

  /**
   * �u���p�҈ꗗ�i�{�݃T�[�r�X�񋟎��ƎҐ����j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_05() throws Exception {

        getEntry().setVisible(false);

        getFind().setVisible(true);

        getDelete().setVisible(false);

        getPrint().setVisible(true);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(false);

        getCsvOut().setEnabled(false);

        getCommit().setVisible(false);

        getTargetDateContena().setVisible(false);

        getPrintConditions().setVisible(false);

        getUpdateConditions().setVisible(false);

        getSupplyCountContainer().setVisible(false);

        getNursingCountContainer().setVisible(false);

        getType7CountContainer().setVisible(false);

        getType2CountContainer().setVisible(false);

        getType3CountContainer().setVisible(false);

        getType4CountContainer().setVisible(false);

        getType5CountContainer().setVisible(false);

        getType6CountContainer().setVisible(false);

        getVisitCountContainer().setVisible(false);

        getSyahoCountContainer().setVisible(false);

        getKokuhoCountContainer().setVisible(false);

        getServiceCountContainer().setVisible(false);

        getInfoTableColumn4().setVisible(false);

        getInfoTableColumn23().setVisible(false);

        getPrintList().setVisible(true);

        getPrintList().setEnabled(false);

  }

  /**
   * �u���p�҈ꗗ�i��Ð����j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_06() throws Exception {

        getEntry().setVisible(false);

        getFind().setVisible(true);

        getDelete().setVisible(false);

        getPrint().setVisible(true);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(false);

        getCommit().setVisible(false);

        getTargetDateContena().setVisible(false);

        getUpdateConditions().setVisible(false);

        getSupplyCountContainer().setVisible(false);

        getNursingCountContainer().setVisible(false);

        getType7CountContainer().setVisible(false);

        getType2CountContainer().setVisible(false);

        getType3CountContainer().setVisible(false);

        getType4CountContainer().setVisible(false);

        getType5CountContainer().setVisible(false);

        getType6CountContainer().setVisible(false);

        getType8CountContainer().setVisible(false);

        getType9CountContainer().setVisible(false);

        getType10CountContainer().setVisible(false);

        getServiceCountContainer().setVisible(false);

        getTotalDenominationTextContainer().setVisible(false);

        getDemandMoneyInsuranceMoneyTextContainer().setVisible(false);

        getTotalDenominationPublicExpenseMoneyTextContainer().setVisible(false);

        getInfoTableColumn4().setVisible(false);

        getInfoTableColumn14().setVisible(false);

        getInfoTableColumn17().setVisible(false);

        getInfoTableColumn18().setVisible(false);

        getInfoTableColumn20().setVisible(false);

        getInfoTableColumn21().setVisible(false);

        getInfoTableColumn23().setVisible(false);

        getPrintList().setVisible(false);

        getPrintList().setEnabled(false);

  }

  /**
   * �u���p�҈ꗗ(���p�Ҍ������)�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_07() throws Exception {

        getEntry().setVisible(false);

        getFind().setVisible(true);

        getDelete().setVisible(false);

        getPrint().setVisible(true);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(false);

        getCommit().setVisible(false);

        getTargetDateContena().setVisible(false);

        getPrintConditions().setVisible(false);

        getUpdateConditions().setVisible(false);

        getSupplyCountContainer().setVisible(false);

        getNursingCountContainer().setVisible(false);

        getType7CountContainer().setVisible(false);

        getType2CountContainer().setVisible(false);

        getType3CountContainer().setVisible(false);

        getType4CountContainer().setVisible(false);

        getType5CountContainer().setVisible(false);

        getType6CountContainer().setVisible(false);

        getType8CountContainer().setVisible(false);

        getType9CountContainer().setVisible(false);

        getType10CountContainer().setVisible(false);

        getVisitCountContainer().setVisible(false);

        getSyahoCountContainer().setVisible(false);

        getKokuhoCountContainer().setVisible(false);

        getTypeCountInfomations().setVisible(false);

        getDemandMoneyAndTotalDenominations().setVisible(false);

        getInfoTableColumn4().setVisible(false);

        getInfoTableColumn14().setVisible(false);

        getInfoTableColumn17().setVisible(false);

        getInfoTableColumn18().setVisible(false);

        getInfoTableColumn19().setVisible(false);

        getInfoTableColumn20().setVisible(false);

        getInfoTableColumn21().setVisible(false);

        getInfoTableColumn22().setVisible(false);

        getInfoTableColumn23().setVisible(false);

        getPrintList().setVisible(false);

        getPrintList().setEnabled(false);

  }

  /**
   * �u���p�҈ꗗ�i��싋�t������j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_08() throws Exception {

        getEntry().setVisible(false);

        getFind().setVisible(true);

        getDelete().setVisible(false);

        getPrint().setVisible(true);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(true);

        getCsvOut().setEnabled(false);

        getCommit().setVisible(false);

        getTargetDateContena().setVisible(false);

        getUpdateConditions().setVisible(false);

        getSupplyCountContainer().setVisible(false);

        getType7CountContainer().setVisible(false);

        getType2CountContainer().setVisible(false);

        getType3CountContainer().setVisible(false);

        getType4CountContainer().setVisible(false);

        getType5CountContainer().setVisible(false);

        getType6CountContainer().setVisible(false);

        getType8CountContainer().setVisible(false);

        getType9CountContainer().setVisible(false);

        getType10CountContainer().setVisible(false);

        getVisitCountContainer().setVisible(false);

        getSyahoCountContainer().setVisible(false);

        getKokuhoCountContainer().setVisible(false);

        getServiceCountContainer().setVisible(false);

        getTypeCountInfomations().setVisible(false);

        getDemandMoneyAndTotalDenominations().setVisible(false);

        getInfoTableColumn4().setVisible(false);

        getInfoTableColumn14().setVisible(false);

        getInfoTableColumn17().setVisible(false);

        getInfoTableColumn18().setVisible(false);

        getInfoTableColumn19().setVisible(false);

        getInfoTableColumn20().setVisible(false);

        getInfoTableColumn21().setVisible(false);

        getInfoTableColumn22().setVisible(false);

        getInfoTableColumn23().setVisible(false);

        getPrintList().setVisible(false);

        getPrintList().setEnabled(false);

  }

  /**
   * �u�������ʗL(�W�v�f�[�^����I��)�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECTED_CLAIM() throws Exception {

        getEntry().setEnabled(true);

        getDelete().setEnabled(false);

        getPrint().setEnabled(true);

        getCsvOut().setEnabled(true);

        getCommit().setEnabled(true);

        getPrintList().setEnabled(true);

  }

  /**
   * �u�������ʗL(�W�v�f�[�^����I��)�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECTED_NO_CLAIM() throws Exception {

        getEntry().setEnabled(false);

        getDelete().setEnabled(false);

        getPrint().setEnabled(true);

        getCsvOut().setEnabled(true);

        getCommit().setEnabled(true);

        getPrintList().setEnabled(true);

  }

  /**
   * �u�������ʖ����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNSELECTED() throws Exception {

        getEntry().setEnabled(false);

        getDelete().setEnabled(false);

        getPrint().setEnabled(false);

        getCsvOut().setEnabled(false);

        getCommit().setEnabled(false);

        getPrintList().setEnabled(false);

  }

  /**
   * �u�����N���ύX���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CLAIM_DATE_ENABLE() throws Exception {

        getClaimDateUpdate().setEditable(true);

  }

  /**
   * �u�����N���ύX�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CLAIM_DATE_DISABLE() throws Exception {

        getClaimDateUpdate().setEditable(false);

  }

}
