
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
 * �v���O���� �T�[�r�X�p�^�[�����V�l�ی��{�� (QS001_15211_201504)
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
 * �T�[�r�X�p�^�[�����V�l�ی��{�ݏ�Ԓ�`(QS001_15211_201504) 
 */
public class QS001_15211_201504State extends QS001_15211_201504Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_15211_201504State(){
  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_MEAT() throws Exception {

        getKaigoHealthCareOfTheAgedDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getKaigoHealthCareOfTheAgedDinnerCost().setEnabled(false);

  }

  /**
   * �u�o���ڍs�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getKaigoHealthCareOfTheAgedOralSwitchRadio().setEnabled(true);
        getKaigoHealthCareOfTheAgedOralSwitchRadio().getParent().setEnabled(true);

  }

  /**
   * �u�o���ڍs�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getKaigoHealthCareOfTheAgedOralSwitchRadio().setEnabled(false);
        getKaigoHealthCareOfTheAgedOralSwitchRadio().getParent().setEnabled(false);

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
   * �u�O�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_GAIHAKU() throws Exception {

        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().setEnabled(true);
        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().getParent().setEnabled(true);

  }

  /**
   * �u�O�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_GAIHAKU() throws Exception {

        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().setEnabled(false);
        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().getParent().setEnabled(false);

  }

  /**
   * �u���V�l�ی��{�݁iI�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_1() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(true);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(false);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(true);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(true);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(true);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(false);

        getStayReturnSupportAddRadio().setEnabled(false);
        getStayReturnSupportAddRadio().getParent().setEnabled(false);

        getRecuperationRadio().setEnabled(false);
        getRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iI�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_2() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(false);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(false);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(false);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(true);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(false);

        getStayReturnSupportAddRadio().setEnabled(false);
        getStayReturnSupportAddRadio().getParent().setEnabled(false);

        getRecuperationRadio().setEnabled(false);
        getRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * �u���V�l�ی��{�݁iII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_3() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(true);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(true);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(true);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_4() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(false);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(false);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(false);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���V�l�ی��{�݁iIII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_5() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(true);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(true);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(true);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iIII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_6() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(false);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(false);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(false);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * �u�ݑ�A�x���@�\���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_STAY_RETURN() throws Exception {

        getStayReturnSupportRyoyoAddRadio().setEnabled(true);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(true);

  }

  /**
   * �u�ݑ�A�x���@�\���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_STAY_RETURN() throws Exception {

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

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
   * �u�Ŏ����E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_TERMINAL() throws Exception {

        getTerminalDays().setEnabled(true);
        getTerminalDays().getParent().setEnabled(true);

  }

  /**
   * �u�Ŏ����E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_TERMINAL() throws Exception {

        getTerminalDays().setEnabled(false);
        getTerminalDays().getParent().setEnabled(false);

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
