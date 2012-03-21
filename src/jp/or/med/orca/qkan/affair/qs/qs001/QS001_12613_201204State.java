
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
 * �쐬��: 2012/02/20  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�Z�������×{���i�F�m�ǁj (QS001_12613_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[�����\�h�Z�������×{���i�F�m�ǁj��Ԓ�`(QS001_12613_201204) 
 */
public class QS001_12613_201204State extends QS001_12613_201204Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_12613_201204State(){
  }

  /**
   * �u��ʏ�ԂP�E�F�m�ǎ����^-��w�a�@�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_1() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationDivision().setEnabled(true);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(true);

        getShortStayDementiaRecuperationType1().setEnabled(true);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(false);

        getShortStayDementiaRecuperationType5().setEnabled(false);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(true);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(true);

  }

  /**
   * �u��ʏ�ԂQ�E�F�m�ǎ����^-��ʕa�@-(�Ȃ��A������߁A�ƒn�͏o��)�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_2() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationDivision().setEnabled(true);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(true);

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(true);

        getShortStayDementiaRecuperationType3().setEnabled(true);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(true);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(true);

  }

  /**
   * �u��ʏ�ԂR�E�F�m�ǎ����^-��ʕa�@-(�Ō�E���E���̕s���A���Ŕ䗦��20%�����A�ƒn�͏o�L)�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_3() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationDivision().setEnabled(true);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(true);

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(true);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(true);

  }

  /**
   * �u��ʏ�ԂS�E���j�b�g�^�F�m�ǎ����^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_4() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationDivision().setEnabled(false);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(false);

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(false);

        getShortStayDementiaRecuperationType5().setEnabled(false);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(true);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(true);

  }

  /**
   * �u��ʏ�ԂT�E�o�ߌ^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_5() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationDivision().setEnabled(false);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(false);

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(false);

        getShortStayDementiaRecuperationType5().setEnabled(false);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(false);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(false);

  }

  /**
   * �u�H��e�L�X�g�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DINNER_COST_ENABLE_FALSE() throws Exception {

        getShortStayDementiaRecuperationDinnerCost().setEnabled(false);

  }

  /**
   * �u�H��e�L�X�g�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DINNER_COST_ENABLE_TRUE() throws Exception {

        getShortStayDementiaRecuperationDinnerCost().setEnabled(true);

  }

}
