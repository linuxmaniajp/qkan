
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
 * �쐬��: 2012/02/16  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[���Z�������×{���i�F�m�ǎ����j (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i�F�m�ǎ����j (QS001_12313_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[���Z�������×{���i�F�m�ǎ����j��Ԓ�`(QS001_12313_201504) 
 */
public class QS001_12313_201504State extends QS001_12313_201504Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_12313_201504State(){
  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_MEAT() throws Exception {

        getShortStayDementiaRecuperationDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getShortStayDementiaRecuperationDinnerCost().setEnabled(false);

  }

  /**
   * �u�]���^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(true);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(true);

        getShortStayDementiaRecuperationDivision().setEnabled(true);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(true);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationType1().setEnabled(true);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(false);

        getShortStayDementiaRecuperationType5().setEnabled(false);

  }

  /**
   * �u���j�b�g�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_FORM() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(true);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(true);

        getShortStayDementiaRecuperationDivision().setEnabled(true);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(true);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(true);

        getShortStayDementiaRecuperationType3().setEnabled(true);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

  }

  /**
   * �u���A��V���[�g�X�e�C�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_SHORT_STAY() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(false);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationDivision().setEnabled(false);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(false);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

  }

  /**
   * �u���j�b�g�P�A�̐����E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_UNIT_CARE() throws Exception {

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

  }

  /**
   * �u���j�b�g�P�A�̐����E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_UNIT_CARE() throws Exception {

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

  }

  /**
   * �u�l���z�u�敪�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_STAFF_ASSIGNMENT() throws Exception {

        getShortStayDementiaRecuperationType2().setEnabled(true);

        getShortStayDementiaRecuperationType3().setEnabled(true);

  }

  /**
   * �u�l���z�u�敪�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_STAFF_ASSIGNMENT() throws Exception {

        getShortStayDementiaRecuperationType1().setEnabled(true);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

  }

  /**
   * �u�l���z�u�敪�E��w�a�@�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_HOSPITAL() throws Exception {

        getShortStayDementiaRecuperationType1().setEnabled(true);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(false);

        getShortStayDementiaRecuperationType5().setEnabled(false);

  }

  /**
   * �u�l���z�u�敪�E��w�a�@��I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNSELECT_HOSPITAL() throws Exception {

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

  }

  /**
   * �u�l���z�u�敪�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_STAFF() throws Exception {

        getShortStayDementiaRecuperationDivision().setEnabled(true);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(true);

  }

  /**
   * �u�l���z�u�敪�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_STAFF() throws Exception {

        getShortStayDementiaRecuperationDivision().setEnabled(false);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(false);

  }

  /**
   * �u�l���z�u�敪�T�^�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_STAFF_DIVISION1() throws Exception {

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(true);

        getShortStayDementiaRecuperationType3().setEnabled(true);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

  }

  /**
   * �u���A��V���[�g�X�e�C�E�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SHORT_STAY_SELECT() throws Exception {

        getShortStayDementiaRecuperationSickroomDivisionRadio().getParent().setVisible(true);

        getShortStayDementiaRecuperationSickroomDivisionRadio().setEnabled(true);
        getShortStayDementiaRecuperationSickroomDivisionRadio().getParent().setEnabled(true);

        getShortStayDementiaRecuperationHospitalRoomDivisionContena().setVisible(false);

        getTankinyusyoTimeDivision().setEnabled(true);

  }

  /**
   * �u���A��V���[�g�X�e�C�E��I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SHORT_STAY_UNSELECT() throws Exception {

        getShortStayDementiaRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayDementiaRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayDementiaRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationHospitalRoomDivisionContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

  }

  /**
   * �u�o�ߌ^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PASSAGE_FORM() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(false);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationDivision().setEnabled(false);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(false);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

  }

}
