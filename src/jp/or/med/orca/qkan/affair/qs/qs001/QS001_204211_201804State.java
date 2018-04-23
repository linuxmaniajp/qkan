
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
 * �J����: �T��@�z��Y
 * �쐬��: 2018/02/16  ���{�R���s���[�^�[������� �T��@�z��Y �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[���Z�������×{���i�a�@�×{�j (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i����É@�j (QS001_204211_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
/**
 * �T�[�r�X�p�^�[���Z�������×{���i����É@�j��Ԓ�`(QS001_204211_201804) 
 */
public class QS001_204211_201804State extends QS001_204211_201804Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_204211_201804State(){
  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_MEAT() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(false);

  }

  /**
   * �u�l���z�u�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_PERSON_SUBTRACTION() throws Exception {

        getStaffAssignmentDivisionItem1().setEnabled(false);

        getStaffAssignmentDivisionItem2().setEnabled(false);

        getStaffAssignmentDivisionItem4().setEnabled(false);

        getStaffAssignmentDivisionItem5().setEnabled(false);

        getStaffAssignmentDivisionItem6().setEnabled(false);

        getStaffAssignmentDivisionItem8().setEnabled(false);

  }

  /**
   * �u�l���z�u�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_PERSON_SUBTRACTION() throws Exception {

        getStaffAssignmentDivisionItem1().setEnabled(true);

        getStaffAssignmentDivisionItem2().setEnabled(true);

        getStaffAssignmentDivisionItem4().setEnabled(true);

        getStaffAssignmentDivisionItem5().setEnabled(true);

        getStaffAssignmentDivisionItem6().setEnabled(true);

        getStaffAssignmentDivisionItem8().setEnabled(true);

  }

  /**
   * �u�l���z�u�E�����i���j�b�g�^�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_PERSON_SUBTRACTION_UNIT() throws Exception {

        getStaffAssignmentDivisionItem1().setEnabled(false);

  }

  /**
   * �u��N���F�m�Ǘ��p�Ҏ�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u��N���F�m�Ǘ��p�Ҏ�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_DEMENTIA_ACTION() throws Exception {

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_DEMENTIA_ACTION() throws Exception {

        getDementiaActionAddRadioGroup().setEnabled(false);
        getDementiaActionAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u�{�݋敪�EI�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_NORMAL() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

        getStaffAssignment1Division().setVisible(true);

        getStaffAssignment1Division().setEnabled(true);
        getStaffAssignment1Division().getParent().setEnabled(true);

        getStaffAssignment2Division().setVisible(false);

        getStaffAssignment2Division().setEnabled(false);

        getStaffAssignment3Division().setVisible(false);

        getStaffAssignment3Division().setEnabled(false);

        getShortStayHospitalRecuperationSpecificConsultationFee().setEnabled(true);

        getMedicalFacilityHospitalSubstractionItem4().setEnabled(true);

  }

  /**
   * �u�{�݋敪�EII�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_NORMAL2() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

        getStaffAssignment1Division().setVisible(false);

        getStaffAssignment1Division().setEnabled(false);

        getStaffAssignment2Division().setVisible(true);

        getStaffAssignment2Division().setEnabled(true);
        getStaffAssignment2Division().getParent().setEnabled(true);

        getStaffAssignment3Division().setVisible(false);

        getStaffAssignment3Division().setEnabled(false);

        getShortStayHospitalRecuperationSpecificConsultationFee().setEnabled(true);

        getMedicalFacilityHospitalSubstractionItem4().setEnabled(true);

  }

  /**
   * �u�{�݋敪�E���ʌ^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_SPECIAL() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

        getStaffAssignment1Division().setVisible(false);

        getStaffAssignment1Division().setEnabled(false);

        getStaffAssignment2Division().setVisible(false);

        getStaffAssignment2Division().setEnabled(false);

        getStaffAssignment3Division().setVisible(true);

        getStaffAssignment3Division().setEnabled(true);
        getStaffAssignment3Division().getParent().setEnabled(true);

        getShortStayHospitalRecuperationSpecificConsultationFee().setEnabled(false);

        getMedicalFacilityHospitalSubstractionItem4().setEnabled(true);

  }

  /**
   * �u�{�݋敪�E���j�b�g�^I�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_UNIT() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

        getStaffAssignment1Division().setVisible(true);

        getStaffAssignment1Division().setEnabled(true);
        getStaffAssignment1Division().getParent().setEnabled(true);

        getStaffAssignmentDivisionItem1().setEnabled(true);

        getStaffAssignmentDivisionItem2().setEnabled(true);

        getStaffAssignmentDivisionItem3().setEnabled(false);

        getStaffAssignment2Division().setVisible(false);

        getStaffAssignment2Division().setEnabled(false);

        getStaffAssignment3Division().setVisible(false);

        getStaffAssignment3Division().setEnabled(false);

        getShortStayHospitalRecuperationSpecificConsultationFee().setEnabled(true);

        getMedicalFacilityHospitalSubstractionItem4().setEnabled(true);

  }

  /**
   * �u�{�݋敪�E���j�b�g�^II�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_UNIT2() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

        getStaffAssignment1Division().setEnabled(false);
        getStaffAssignment1Division().getParent().setEnabled(false);

        getStaffAssignment2Division().setEnabled(false);
        getStaffAssignment2Division().getParent().setEnabled(false);

        getStaffAssignment3Division().setEnabled(false);
        getStaffAssignment3Division().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSpecificConsultationFee().setEnabled(true);

        getMedicalFacilityHospitalSubstractionItem4().setEnabled(true);

  }

  /**
   * �u�{�݋敪�E���j�b�g�^���ʌ^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_UNIT_SPECIAL() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

        getStaffAssignment1Division().setVisible(false);

        getStaffAssignment1Division().setEnabled(false);

        getStaffAssignment2Division().setVisible(false);

        getStaffAssignment2Division().setEnabled(false);

        getStaffAssignment3Division().setVisible(true);

        getStaffAssignment3Division().setEnabled(true);
        getStaffAssignment3Division().getParent().setEnabled(true);

        getShortStayHospitalRecuperationSpecificConsultationFee().setEnabled(false);

        getMedicalFacilityHospitalSubstractionItem4().setEnabled(true);

  }

  /**
   * �u�{�݋敪�E���A��V���[�g�X�e�C�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_SHORT_STAY() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(true);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(true);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(false);

        getTankinyusyoTimeDivision().setEnabled(true);

        getShortStayHospitalRecuperationAdditionType().setEnabled(false);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(false);
        getDementiaActionAddRadioGroup().getParent().setEnabled(false);

        getEmergencyAcceptanceRadioGroup().setEnabled(false);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(false);

        getStaffAssignment1Division().setEnabled(false);
        getStaffAssignment1Division().getParent().setEnabled(false);

        getStaffAssignment2Division().setEnabled(false);
        getStaffAssignment2Division().getParent().setEnabled(false);

        getStaffAssignment3Division().setEnabled(false);
        getStaffAssignment3Division().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSpecificConsultationFee().setEnabled(true);

        getMedicalFacilityHospitalSubstractionItem4().setEnabled(false);

  }

  /**
   * �u�ً}�Z������������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_EMERGENCY_ACCEPTANCE() throws Exception {

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�ً}�Z������������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_EMERGENCY_ACCEPTANCE() throws Exception {

        getEmergencyAcceptanceRadioGroup().setEnabled(false);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u��ԋΖ����Ō���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_HOSPITAL_RECUPERATION() throws Exception {

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

  }

  /**
   * �u��ԋΖ����Ō���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_HOSPITAL_RECUPERATION() throws Exception {

        getShortStayHospitalRecuperationAdditionType().setEnabled(false);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(false);

  }

}
