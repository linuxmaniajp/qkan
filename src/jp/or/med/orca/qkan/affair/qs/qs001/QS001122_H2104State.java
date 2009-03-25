
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
 * �쐬��: 2009/02/09  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj (QS001122_H2104)
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
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj��Ԓ�`(QS001122_H2104) 
 */
public class QS001122_H2104State extends QS001122_H2104Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001122_H2104State(){
  }


  /**
   * �u�h�{�}�l�W�����g�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_MANAGE() throws Exception {

        getMedicalFacilityCognitiveHospitalNutritionRadio().setEnabled(true);

  }

  /**
   * �u�h�{�}�l�W�����g�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_MANAGE() throws Exception {

        getMedicalFacilityCognitiveHospitalNutritionRadio().setEnabled(false);

  }

  /**
   * �u�o���ڍs�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getMedicalFacilityCognitiveHospitalOralSwitchRadio().setEnabled(true);

  }

  /**
   * �u�o���ڍs�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getMedicalFacilityCognitiveHospitalOralSwitchRadio().setEnabled(false);

  }

  /**
   * �u�×{�H�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio().setEnabled(true);

  }

  /**
   * �u�×{�H�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio().setEnabled(false);

  }

  /**
   * �u�]���^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);

        getHospitalDivisionRadio().setEnabled(true);

  }

  /**
   * �u���j�b�g�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_FORM() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalRoomRadio().setEnabled(false);

        getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio().setEnabled(true);

        getHospitalDivisionRadio().setEnabled(true);

  }

  /**
   * �u���j�b�g�P�A�̐����E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_UNIT_CARE() throws Exception {

        getUnitCareMaintenanceRadio().setEnabled(true);

  }

  /**
   * �u���j�b�g�P�A�̐����E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_UNIT_CARE() throws Exception {

        getUnitCareMaintenanceRadio().setEnabled(false);

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
  public void setState_VALID_TAKAJUSIN_ADD() throws Exception {

        getMedicalFacilityCognitiveHospitalMedicalExaminationRadio().setEnabled(true);

  }

  /**
   * �u���Ȏ�M���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_TAKAJUSIN_ADD() throws Exception {

        getMedicalFacilityCognitiveHospitalMedicalExaminationRadio().setEnabled(false);

  }

  /**
   * �u�O�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_GAIHAKU_ADD() throws Exception {

        getMedicalFacilityCognitiveHospitalStayRadio().setEnabled(true);

  }

  /**
   * �u�O�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_GAIHAKU_ADD() throws Exception {

        getMedicalFacilityCognitiveHospitalStayRadio().setEnabled(false);

  }

  /**
   * �u�o�ߌ^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PASSAGE_FORM() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);

        getMedicalFacilityCognitiveHospitalHospitalDivision().setEnabled(false);

        getHospitalDivisionRadio().setEnabled(false);

  }

}
