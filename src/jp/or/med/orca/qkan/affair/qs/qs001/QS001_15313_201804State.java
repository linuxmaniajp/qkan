
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
 * �쐬��: 2018/02/26  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj (QS001_15313_201804)
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
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj��Ԓ�`(QS001_15313_201804) 
 */
public class QS001_15313_201804State extends QS001_15313_201804Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_15313_201804State(){
  }

  /**
   * �u�o���ڍs�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getMedicalFacilityCognitiveHospitalOralSwitchRadio().setEnabled(true);
        getMedicalFacilityCognitiveHospitalOralSwitchRadio().getParent().setEnabled(true);

  }

  /**
   * �u�o���ڍs�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getMedicalFacilityCognitiveHospitalOralSwitchRadio().setEnabled(false);
        getMedicalFacilityCognitiveHospitalOralSwitchRadio().getParent().setEnabled(false);

  }

  /**
   * �u�]���^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getHospitalDivisionRadio().setEnabled(true);
        getHospitalDivisionRadio().getParent().setEnabled(true);

  }

  /**
   * �u���j�b�g�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_FORM() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalRoomRadio().setEnabled(false);

        getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getHospitalDivisionRadio().setEnabled(true);
        getHospitalDivisionRadio().getParent().setEnabled(true);

  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_MEAT() throws Exception {

        getMedicalFacilityCognitiveHospitalDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getMedicalFacilityCognitiveHospitalDinnerCost().setEnabled(false);

  }

  /**
   * �u�l���z�u�敪�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_HUMAN_TYPE() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalDivision().setEnabled(true);
        getMedicalFacilityCognitiveHospitalHospitalDivision().getParent().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision1().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision2().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision3().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision4().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision5().setEnabled(true);

  }

  /**
   * �u�l���z�u�敪�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_HUMAN_TYPE() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalDivision().setEnabled(false);
        getMedicalFacilityCognitiveHospitalHospitalDivision().getParent().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision1().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision2().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision3().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision4().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision5().setEnabled(false);

  }

  /**
   * �u�l���z�u�敪�����E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_HUMAN_COST_DOWN() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalDivision().setEnabled(true);
        getMedicalFacilityCognitiveHospitalHospitalDivision().getParent().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision1().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision2().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision3().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision4().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision5().setEnabled(true);

  }

  /**
   * �u�l���z�u�敪�E�����T�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_HUMAN_COST_DOWN1() throws Exception {

        getMedicalFacilityCognitiveHospitalDivision1().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision2().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision3().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision4().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision5().setEnabled(false);

  }

  /**
   * �u�l���z�u�敪�E�����T�^�ȊO�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_HUMAN_COST_DOWN_NOT1() throws Exception {

        getMedicalFacilityCognitiveHospitalDivision1().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision2().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision3().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision4().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision5().setEnabled(true);

  }

  /**
   * �u�l���z�u�敪�E�����EIV�EV�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_HUMAN_COST_DOWN14_OR_5() throws Exception {

        getMedicalFacilityCognitiveHospitalDivision1().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision2().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision3().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision4().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision5().setEnabled(true);

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
   * �u���Ȏ�M���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_TAKAJUSIN_ADD() throws Exception {

        getMedicalFacilityCognitiveHospitalMedicalExaminationRadio().setEnabled(true);
        getMedicalFacilityCognitiveHospitalMedicalExaminationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���Ȏ�M���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_TAKAJUSIN_ADD() throws Exception {

        getMedicalFacilityCognitiveHospitalMedicalExaminationRadio().setEnabled(false);
        getMedicalFacilityCognitiveHospitalMedicalExaminationRadio().getParent().setEnabled(false);

  }

  /**
   * �u�O�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_GAIHAKU_ADD() throws Exception {

        getMedicalFacilityCognitiveHospitalStayRadio().setEnabled(true);
        getMedicalFacilityCognitiveHospitalStayRadio().getParent().setEnabled(true);

  }

  /**
   * �u�O�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_GAIHAKU_ADD() throws Exception {

        getMedicalFacilityCognitiveHospitalStayRadio().setEnabled(false);
        getMedicalFacilityCognitiveHospitalStayRadio().getParent().setEnabled(false);

  }

  /**
   * �u�o�ߌ^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PASSAGE_FORM() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getMedicalFacilityCognitiveHospitalHospitalDivision().setEnabled(false);
        getMedicalFacilityCognitiveHospitalHospitalDivision().getParent().setEnabled(false);

        getHospitalDivisionRadio().setEnabled(false);
        getHospitalDivisionRadio().getParent().setEnabled(false);

  }

  /**
   * �u���o�@�\�ێ��Ǘ����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_ORAL_CARE() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u���o�@�\�ێ��Ǘ����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_ORAL_CARE() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(false);

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
   * �u���@���Ҋ�̊֘A���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_HOSPITAL_PATIENT_RELATED() throws Exception {

        getMedicalFacilityCognitiveHospitalOralSwitchRadio().setEnabled(true);
        getMedicalFacilityCognitiveHospitalOralSwitchRadio().getParent().setEnabled(true);

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(true);

        getMedicalFacilityCognitiveHospitalHijoAddition().setEnabled(true);

        getLowNutritionalRiskImprovementAdd().setEnabled(true);
        getLowNutritionalRiskImprovementAdd().getParent().setEnabled(true);

        getOralMaintenanceAddContainer().setEnabled(true);

        getOralKeepStructureAddRadioGroup().setEnabled(true);
        getOralKeepStructureAddRadioGroup().getParent().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getMedicalFacilityCognitiveHospitalConsultationFee().setEnabled(true);

        getExcretionSupport().setEnabled(true);
        getExcretionSupport().getParent().setEnabled(true);

  }

  /**
   * �u���@���Ҋ�̊֘A���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_HOSPITAL_PATIENT_RELATED() throws Exception {

        getMedicalFacilityCognitiveHospitalOralSwitchRadio().setEnabled(false);
        getMedicalFacilityCognitiveHospitalOralSwitchRadio().getParent().setEnabled(false);

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(false);

        getMedicalFacilityCognitiveHospitalHijoAddition().setEnabled(false);

        getLowNutritionalRiskImprovementAdd().setEnabled(false);
        getLowNutritionalRiskImprovementAdd().getParent().setEnabled(false);

        getOralMaintenanceAddContainer().setEnabled(false);

        getOralKeepStructureAddRadioGroup().setEnabled(false);
        getOralKeepStructureAddRadioGroup().getParent().setEnabled(false);

        getStayReturnSupportAddRadio().setEnabled(false);
        getStayReturnSupportAddRadio().getParent().setEnabled(false);

        getMedicalFacilityCognitiveHospitalConsultationFee().setEnabled(false);

        getExcretionSupport().setEnabled(false);
        getExcretionSupport().getParent().setEnabled(false);

  }

  /**
   * �u��h�{���X�N���P���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_LOW_NUTRITIONAL() throws Exception {

        getLowNutritionalRiskImprovementAdd().setEnabled(true);
        getLowNutritionalRiskImprovementAdd().getParent().setEnabled(true);

  }

  /**
   * �u��h�{���X�N���P���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_LOW_NUTRITIONAL() throws Exception {

        getLowNutritionalRiskImprovementAdd().setEnabled(false);
        getLowNutritionalRiskImprovementAdd().getParent().setEnabled(false);

  }

}
