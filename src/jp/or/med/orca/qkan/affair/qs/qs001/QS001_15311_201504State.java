
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
 * �쐬��: 2015/03/14  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�a�@�j (QS001_15311_201504)
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
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�a�@�j��Ԓ�`(QS001_15311_201504) 
 */
public class QS001_15311_201504State extends QS001_15311_201504Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_15311_201504State(){
  }

  /**
   * �u�o���ڍs�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getMedicalFacilityHospitalOralSwitchRadio().setEnabled(true);
        getMedicalFacilityHospitalOralSwitchRadio().getParent().setEnabled(true);

  }

  /**
   * �u�o���ڍs�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getMedicalFacilityHospitalOralSwitchRadio().setEnabled(false);
        getMedicalFacilityHospitalOralSwitchRadio().getParent().setEnabled(false);

  }

  /**
   * �u�]���^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getMedicalFacilityHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityHospitalUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getTrialHijoRadio().setEnabled(false);
        getTrialHijoRadio().getParent().setEnabled(false);

        getStaffAssignment1Division().setVisible(true);

        getStaffAssignment1Division().setEnabled(true);
        getStaffAssignment1Division().getParent().setEnabled(true);

        getStaffAssignment2Division().setVisible(false);

        getStaffAssignment2Division().setEnabled(false);

        getStaffAssignment3Division().setVisible(false);

        getStaffAssignment3Division().setEnabled(false);

  }

  /**
   * �u���j�b�g�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_FORM() throws Exception {

        getMedicalFacilityHospitalHospitalRoomRadio().setEnabled(false);

        getMedicalFacilityHospitalUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getTrialHijoRadio().setEnabled(false);
        getTrialHijoRadio().getParent().setEnabled(false);

        getStaffAssignment1Division().setVisible(false);

        getStaffAssignment1Division().setEnabled(false);

        getStaffAssignment2Division().setVisible(true);

        getStaffAssignment2Division().setEnabled(true);
        getStaffAssignment2Division().getParent().setEnabled(true);

        getStaffAssignment3Division().setVisible(false);

        getStaffAssignment3Division().setEnabled(false);

  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_MEAT() throws Exception {

        getMedicalFacilityDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getMedicalFacilityDinnerCost().setEnabled(false);

  }

  /**
   * �u�l�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SUBTRACTION() throws Exception {

        getStaffAssignmentDivisionItem1().setEnabled(true);

        getStaffAssignmentDivisionItem2().setEnabled(true);

        getStaffAssignmentDivisionItem3().setEnabled(true);

        getStaffAssignmentDivisionItem4().setEnabled(true);

        getStaffAssignmentDivisionItem5().setEnabled(true);

  }

  /**
   * �u�l�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SUBTRACTION() throws Exception {

        getStaffAssignmentDivisionItem1().setEnabled(false);

        getStaffAssignmentDivisionItem2().setEnabled(false);

        getStaffAssignmentDivisionItem3().setEnabled(false);

        getStaffAssignmentDivisionItem4().setEnabled(false);

        getStaffAssignmentDivisionItem5().setEnabled(false);

  }

  /**
   * �u�o���ێ����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceAdd().setEnabled(true);
        getOralMaintenanceAdd().getParent().setEnabled(true);

  }

  /**
   * �u�o���ێ����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceAdd().setEnabled(false);
        getOralMaintenanceAdd().getParent().setEnabled(false);

  }

  /**
   * �u���Ȏ�M�̗L���E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_TAKAJYUSIN() throws Exception {

        getMedicalFacilityHospitalMedicalExaminationRadio().setEnabled(true);
        getMedicalFacilityHospitalMedicalExaminationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���Ȏ�M�̗L���E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_TAKAJYUSIN() throws Exception {

        getMedicalFacilityHospitalMedicalExaminationRadio().setEnabled(false);
        getMedicalFacilityHospitalMedicalExaminationRadio().getParent().setEnabled(false);

  }

  /**
   * �u�O�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_GAIHAKU() throws Exception {

        getMedicalFacilityHospitalStayRadio().setEnabled(true);
        getMedicalFacilityHospitalStayRadio().getParent().setEnabled(true);

  }

  /**
   * �u�O�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_GAIHAKU() throws Exception {

        getMedicalFacilityHospitalStayRadio().setEnabled(false);
        getMedicalFacilityHospitalStayRadio().getParent().setEnabled(false);

  }

  /**
   * �u�o�ߌ^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PASSAGE_FORM() throws Exception {

        getMedicalFacilityHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityHospitalUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getTrialHijoRadio().setEnabled(true);
        getTrialHijoRadio().getParent().setEnabled(true);

        getStaffAssignment1Division().setVisible(false);

        getStaffAssignment1Division().setEnabled(false);

        getStaffAssignment2Division().setVisible(false);

        getStaffAssignment2Division().setEnabled(false);

        getStaffAssignment3Division().setVisible(true);

        getStaffAssignment3Division().setEnabled(true);
        getStaffAssignment3Division().getParent().setEnabled(true);

  }

  /**
   * �u���s�I�މ@�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_TRIAL_HIJO() throws Exception {

        getTrialHijoRadio().setEnabled(true);
        getTrialHijoRadio().getParent().setEnabled(true);

  }

  /**
   * �u���s�I�މ@�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_TRIAL_HIJO() throws Exception {

        getTrialHijoRadio().setEnabled(false);
        getTrialHijoRadio().getParent().setEnabled(false);

  }

  /**
   * �u�l�����Z�E�����i�o�ߌ^_1�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SUBTRACTION_3_ENABLE() throws Exception {

        getStaffAssignmentDivisionItem10().setEnabled(true);

  }

  /**
   * �u�l�����Z�E�����i�o�ߌ^_2�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SUBTRACTION_1_3_ENABLE() throws Exception {

        getStaffAssignmentDivisionItem1().setEnabled(false);

        getStaffAssignmentDivisionItem2().setEnabled(false);

        getStaffAssignmentDivisionItem3().setEnabled(false);

        getStaffAssignmentDivisionItem6().setEnabled(false);

        getStaffAssignmentDivisionItem10().setEnabled(false);

  }

  /**
   * �u���o�@�\�ێ��Ǘ����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_ORAL_CARE() throws Exception {

        getOralKeepAddRadioGroup().setEnabled(true);
        getOralKeepAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u���o�@�\�ێ��Ǘ����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_ORAL_CARE() throws Exception {

        getOralKeepAddRadioGroup().setEnabled(false);
        getOralKeepAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u�o���ێ����Z�Q�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_ORAL_MAINTENANCE2() throws Exception {

        getOralMaintenanceAddItem3().setEnabled(true);

  }

  /**
   * �u�o���ێ����Z�Q�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_ORAL_MAINTENANCE2() throws Exception {

        getOralMaintenanceAddItem3().setEnabled(false);

  }

  /**
   * �u���j�b�g�^�o�ߌ^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_PASSAGE_FORM() throws Exception {

        getMedicalFacilityHospitalHospitalRoomRadio().setEnabled(false);

        getMedicalFacilityHospitalUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getTrialHijoRadio().setEnabled(false);
        getTrialHijoRadio().getParent().setEnabled(false);

        getStaffAssignment1Division().setEnabled(false);
        getStaffAssignment1Division().getParent().setEnabled(false);

        getStaffAssignment2Division().setEnabled(false);
        getStaffAssignment2Division().getParent().setEnabled(false);

        getStaffAssignment3Division().setEnabled(false);
        getStaffAssignment3Division().getParent().setEnabled(false);

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

        getDementiaEmergencyAddRadioGroup().setEnabled(true);
        getDementiaEmergencyAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_DEMENTIA_ACTION() throws Exception {

        getDementiaEmergencyAddRadioGroup().setEnabled(false);
        getDementiaEmergencyAddRadioGroup().getParent().setEnabled(false);

  }

}
