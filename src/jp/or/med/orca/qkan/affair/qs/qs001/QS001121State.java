
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
 * �J����: �c���@����
 * �쐬��: 2006/03/21  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�f�Ï��j (QS001121)
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
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�f�Ï��j��Ԓ�`(QS001121) 
 */
public class QS001121State extends QS001121Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001121State(){
  }

  /**
   * �u�h�{�Ǘ��E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_DIETICIAN_MANAGE() throws Exception {

        getMedicalFacilityClinicNutritionManageRadio().setEnabled(true);

  }

  /**
   * �u�h�{�Ǘ��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_DIETICIAN_MANAGE() throws Exception {

        getMedicalFacilityClinicNutritionManageRadio().setEnabled(false);

  }

  /**
   * �u�h�{�}�l�W�����g�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_MANAGE() throws Exception {

        getMedicalFacilityClinicNutritionRadio().setEnabled(true);

  }

  /**
   * �u�h�{�}�l�W�����g�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_MANAGE() throws Exception {

        getMedicalFacilityClinicNutritionRadio().setEnabled(false);

  }

  /**
   * �u�o���ڍs�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getMedicalFacilityClinicOralSwitchRadio().setEnabled(true);

  }

  /**
   * �u�o���ڍs�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getMedicalFacilityClinicOralSwitchRadio().setEnabled(false);

  }

  /**
   * �u�×{�H�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getMedicalFacilityClinicRecuperateDinnerRadio().setEnabled(true);

  }

  /**
   * �u�×{�H�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getMedicalFacilityClinicRecuperateDinnerRadio().setEnabled(false);

  }

  /**
   * �u�]���^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getMedicalFacilityClinicHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityClinicUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);

        getMedicalFacilityClinicDivision().setEnabled(true);

  }

  /**
   * �u���j�b�g�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_FORM() throws Exception {

        getMedicalFacilityClinicHospitalRoomRadio().setEnabled(false);

        getMedicalFacilityClinicUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);

        getMedicalFacilityClinicDivision().setEnabled(false);

  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_MEAT() throws Exception {

        getMedicalFacilityClinicDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getMedicalFacilityClinicDinnerCost().setEnabled(false);

  }

  /**
   * �u���j�b�g�P�A�̐��E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_UNIT_CARE() throws Exception {

        getUnitCareMaintenanceRadio().setEnabled(true);

  }

  /**
   * �u���j�b�g�P�A�̐��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_UNIT_CARE() throws Exception {

        getUnitCareMaintenanceRadio().setEnabled(false);

  }

  /**
   * �u�o���ێ����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceAddRadio().setEnabled(true);

  }

  /**
   * �u�o���ێ����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceAddRadio().setEnabled(false);

  }

  /**
   * �u���Ȏ�M���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_TAKAJUSIN() throws Exception {

        getMedicalFacilityClinicMedicalExaminationRadio().setEnabled(true);

  }

  /**
   * �u���Ȏ�M���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_TAKAJUSIN() throws Exception {

        getMedicalFacilityClinicMedicalExaminationRadio().setEnabled(false);

  }

  /**
   * �u�O�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_GAIHAKU_ADD() throws Exception {

        getMedicalFacilityClinicStayRadio().setEnabled(true);

  }

  /**
   * �u�O�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_GAIHAKU_ADD() throws Exception {

        getMedicalFacilityClinicStayRadio().setEnabled(false);

  }

}
