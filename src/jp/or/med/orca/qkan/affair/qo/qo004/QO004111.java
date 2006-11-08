
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
 * �쐬��: 2006/02/21  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� �Z�������×{���i�a�@�×{�^�j (QO004111)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo004;

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
import jp.or.med.orca.qkan.text.*;

/**
 * �Z�������×{���i�a�@�×{�^�j(QO004111) 
 */
public class QO004111 extends QO004111Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004111(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u��ʏ�Ԑݒ�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void facilitiesDivisionSelectionChanged(ListSelectionEvent e) throws Exception {
	  // ��ʏ�Ԑݒ�
	  setState();
	  
	}

  /**
   * �u�H���z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void dinnerMorningFocusLost(FocusEvent e) throws Exception {
		// �H���z���v�\������
		// �H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
		totalDinnerMoney();

	}

  /**
   * �u�H���z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void dinnerNoonFocusLost(FocusEvent e) throws Exception {
		// �H���z���v�\������
		// �H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
		totalDinnerMoney();

	}

  /**
   * �u�H���z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void dinnerNightFocusLost(FocusEvent e) throws Exception {
		// �H���z���v�\������
		// �H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
		totalDinnerMoney();

	}

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QO004111.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�H���z���v�\�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void totalDinnerMoney() throws Exception {
		// �H���z���v����
		// ���L�̃e�L�X�g�t�B�[���h�̓��͂���Ă���l�����v�� dinnerTotal �i�H���z�E���v�e�L�X�g�t�B�[���h�j�ɒl��������B
		// �EdinnerMorning(�H���z�E���E�e�L�X�g)
		// �EdinnerNoon(�H���z�E���E�e�L�X�g)
		// �EdinnerNight(�H���z�E��E�e�L�X�g)
	  
//	  if (ACTextUtilities.isNullText(getDinnerTotal().getText())) {
//			int valMorning = 0;
//			int valNoon = 0;
//			int valNight = 0;
//
//			if (!ACTextUtilities.isNullText(getDinnerMorning().getText())) {
//				valMorning = ACCastUtilities
//						.toInt(getDinnerMorning().getText());
//			}
//			if (!ACTextUtilities.isNullText(getDinnerNoon().getText())) {
//				valNoon = ACCastUtilities.toInt(getDinnerNoon().getText());
//			}
//			if (!ACTextUtilities.isNullText(getDinnerNight().getText())) {
//				valNight = ACCastUtilities.toInt(getDinnerNight().getText());
//			}
//
//			int valTotal = valMorning + valNoon + valNight;
//
//			if (valTotal == 0) {
//				getDinnerTotal().setText("");
//			} else {
//				getDinnerTotal().setText(ACCastUtilities.toString(valTotal));
//			}
//		}
	}

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception {
		// ��������

//		// ���R���{�A�C�e���̐ݒ�
//		// �R�[�h�}�X�^��艺�L�̃f�[�^���擾���l�����Z�R���{�̑I�����Ƃ��Đݒ肷��B
//		// CODE_ID = CODE_STAFF_REDUCE
//		VRList list = QkanCommon.getArrayFromMasterCode(CODE_STAFF_REDUCE,
//				PATH_STAFF_REDUCE);
//		getStaffLack().setModel(list);

		// �������l�ݒ�
		// �������e�L�X�g�ɏ����l0��\������B
		// �{�݋敪�̏����l�Ƃ��āu�a�@�v��I������B
		// �l���z�u�敪�̏����l�Ƃ��āu�T�^�v��I������B
		// ��ԋΖ�������̏����l�Ƃ��āu��^�v��I������B
		// �×{����̏����l�Ƃ��āu��^�v��I������B
		// ��t�̔z�u��̏����l�Ƃ��āu��v��I������B
		// ���}�̐��̏����l�Ƃ��āu�Ȃ��v��I������B
		// �h�{�Ǘ��̐��̏����l�Ƃ��āu�Ȃ��v��I������B
		// �×{�H�̐��̏����l�Ƃ��āu�Ȃ��v��I������B
		// ���j�b�g�P�A�̐����̏����l�Ƃ��āu�������v��I������B
		// �ً}�Z�������l�b�g���[�N�̐��̏����l�Ƃ��āu�Ȃ��v��I������B
		// �l�����Z�̏����l�Ƃ��āu�Ȃ��v��I������B

		getReduceRate().setText("0");
		getFacilitiesDivision().setSelectedIndex(1);
		getStaffAssignmentDivision().setSelectedIndex(1);
		getNightWorkDivision().setSelectedIndex(1);
		getRecuperationEnvironmental().setSelectedIndex(1);
		getDoctorsAssignment().setSelectedIndex(1);
		getMeetingAndSendingOffSystem().setSelectedIndex(1);
		getNourishmentControlAdd().setSelectedIndex(1);
//		getRecuperatDinner().setSelectedIndex(1);
		getUnitCareMaintenance().setSelectedIndex(1);
		getEmergencyNetworkAdd().setSelectedIndex(1);
		getStaffLack().setSelectedIndex(1);

		// �H��E���Z��̎擾�ƕ\��
		VRMap param = new VRHashMap();
		VRBindPathParser.set("SYSTEM_DATE", param, QkanSystemInformation
				.getInstance().getSystemDate());
		String strSql = getSQL_GET_RESIDENCE_FOOD(param);
		VRList residenceFood = getDBManager().executeQuery(strSql);

		if (residenceFood != null) {
			for (int i = 0; i < residenceFood.size(); i++) {
				VRMap temp = (VRMap) residenceFood.get(i);
				int id = ACCastUtilities.toInt(VRBindPathParser.get(
						"RESIDENCE_FOOD_COST_ID", temp));
				String cost = ACCastUtilities.toString(VRBindPathParser.get(
						"RESIDENCE_FOOD_COST", temp));

				switch (id) {
				// �H��
				case 1:
					getDinnerTotal().setText(cost);
					break;
				// ���j�b�g��
				case 2:
					getUnitRoom().setText(cost);
					break;
				// ���j�b�g����
				case 3:
					getUnitSemiRoom().setText(cost);
					break;
				// �]���^��
				case 5:
					getNormalRoom().setText(cost);
					break;
				// ������
				case 6:
					getTasyouRoom().setText(cost);
					break;
				}

			}
		}
	}

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public boolean isValidInput() throws Exception {
		// �����̓`�F�b�N
		// �G���[���b�Z�[�W�����i�[�p�� errMsg ���쐬����B
		String errMsg = null;

		// ���L�̃��W�I�O���[�v�ɑ΂��đI���`�F�b�N���s���B���I���������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
		// �EfacilitiesDivision�i�{�݋敪���W�I�O���[�v�j
		// �� errMsg = �{�݋敪
		if (!getFacilitiesDivision().isSelected()) {
			errMsg = "�{�݋敪";
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			getFacilitiesDivision().requestFocus();
			return false;
		}

		// �EstaffAssignmentDivision�i�l���z�u�敪���W�I�O���[�v�j
		// ��errMsg = �l���z�u�敪
		if(getStaffAssignmentDivision().isEnabled()){
			if (!getStaffAssignmentDivision().isSelected()) {
				errMsg = "�l���z�u�敪";
				QkanMessageList.getInstance()
						.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
				getStaffAssignmentDivision().requestFocus();
				return false;
			}
			// �I������Ă��鍀�ڂ�������Ԃ̏ꍇ�A�I�����Ă��Ȃ��Ƃ݂Ȃ��B
			if(!(getStaffAssignmentDivision().getSelectedButton()).isEnabled()){
				errMsg = "�l���z�u�敪";
				QkanMessageList.getInstance()
						.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
				getStaffAssignmentDivision().requestFocus();
				return false;			
			}
		}

		// �EnightWorkDivision�i��ԋΖ���������W�I�O���[�v�j
		// �� errMsg = ��ԋΖ������
		if (!getNightWorkDivision().isSelected()) {
			errMsg = "��ԋΖ������";
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			getNightWorkDivision().requestFocus();
			return false;
		}

		// �ErecuperationEnvironmental�i�×{������W�I�O���[�v�j
		// ��errMsg = �×{���
		if (!getRecuperationEnvironmental().isSelected()) {
			errMsg = "�×{���";
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			getRecuperationEnvironmental().requestFocus();
			return false;
		}

		// �EdoctorsAssignment�i��t�̔z�u����W�I�O���[�v�j
		// ��errMsg = ��t�̔z�u�
		if (!getDoctorsAssignment().isSelected()) {
			errMsg = "��t�̔z�u�";
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			getDoctorsAssignment().requestFocus();
			return false;
		}

		// �EmeetingAndSendingOffSystem�i���}�̐����W�I�O���[�v�j
		// �� errMsg = ���}�̐�
		if (!getMeetingAndSendingOffSystem().isSelected()) {
			errMsg = "���}�̐�";
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			getMeetingAndSendingOffSystem().requestFocus();
			return false;
		}

		// �EnourishmentControlAdd�i�h�{�Ǘ��̐����W�I�O���[�v�j
		// �� errMsg = �h�{�Ǘ��̐�
		if (!getNourishmentControlAdd().isSelected()) {
			errMsg = "�h�{�Ǘ��̐�";
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			getNourishmentControlAdd().requestFocus();
			return false;
		}

//		// �ErecuperatDinner�i�×{�H�̐����W�I�O���[�v�j
//		// �� errMsg = �×{�H�̐�
//		if (!getRecuperatDinner().isSelected()) {
//			errMsg = "�×{�H�̐�";
//			QkanMessageList.getInstance()
//					.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
//			getRecuperatDinner().requestFocus();
//			return false;
//		}

		// �EunitCareMaintenance�i���j�b�g�P�A�̐������W�I�O���[�v�j
		// �� errMsg = ���j�b�g�P�A�̐���
		if(getUnitCareMaintenance().isEnabled()){
			if (!getUnitCareMaintenance().isSelected()) {
				errMsg = "���j�b�g�P�A�̐���";
				QkanMessageList.getInstance()
						.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
				getUnitCareMaintenance().requestFocus();
				return false;
			}
		}

		// �EemergencyNetworkAdd�i�ً}�Z�������l�b�g���[�N�̐����W�I�O���[�v�j
		// �� errMsg = �ً}�Z�������l�b�g���[�N�̐�
		if (!getEmergencyNetworkAdd().isSelected()) {
			errMsg = "�ً}�Z�������l�b�g���[�N�̐�";
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			getEmergencyNetworkAdd().requestFocus();
			return false;
		}

		// ���L�̃R���{�̍��ڂ��I������Ă��邩�`�F�b�N���s���B���I���������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
		// �EstaffLack�i�l�����Z�R���{�j�� errMsg = �l�����Z
		if (!getStaffLack().isSelected()) {
			errMsg = "�l�����Z";
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			getStaffLack().requestFocus();
			return false;
		}

//		// �EdinnerMorning�i�H���z�E���e�L�X�g�j�� errMsg = �H���z
//		if (ACTextUtilities.isNullText(getDinnerMorning().getText())) {
//			errMsg = "�H���z";
//			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//			getDinnerMorning().requestFocus();
//			return false;
//		}
//
//		// �EdinnerNoon�i�H���z�E���e�L�X�g�j�� errMsg = �H���z
//		if (ACTextUtilities.isNullText(getDinnerNoon().getText())) {
//			errMsg = "�H���z";
//			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//			getDinnerNoon().requestFocus();
//			return false;
//		}
//
//		// �EdinnerNight�i�H���z�E��e�L�X�g�j�� errMsg = �H���z
//		if (ACTextUtilities.isNullText(getDinnerNight().getText())) {
//			errMsg = "�H���z";
//			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//			getDinnerNight().requestFocus();
//			return false;
//		}
//
//		// �EunitRoom�� errMsg = ���j�b�g�^����z
//		if (ACTextUtilities.isNullText(getUnitRoom().getText())) {
//			errMsg = "���j�b�g�^����z";
//			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//			getUnitRoom().requestFocus();
//			return false;
//		}
//
//		// �EunitSemiRoom�� errMsg = ���j�b�g�^������z
//		if (ACTextUtilities.isNullText(getUnitSemiRoom().getText())) {
//			errMsg = "���j�b�g�^������z";
//			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//			getUnitSemiRoom().requestFocus();
//			return false;
//		}
//
//		// �EnormalRoom�� errMsg = �]���^����z
//		if (ACTextUtilities.isNullText(getNormalRoom().getText())) {
//			errMsg = "�]���^����z";
//			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//			getNormalRoom().requestFocus();
//			return false;
//		}
//
//		// �EtasyouRoom�� errMsg = ��������z
//		if (ACTextUtilities.isNullText(getTasyouRoom().getText())) {
//			errMsg = "��������z";
//			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//			getTasyouRoom().requestFocus();
//			return false;
//		}

		// ���L�̃e�L�X�g�t�B�[���h�ɑ΂��ē��̓`�F�b�N���s���B�����͂������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
		// �EreduceRate�i�������e�L�X�g�j�� errMsg = ������
		if (ACTextUtilities.isNullText(getReduceRate().getText())) {
			errMsg = "������";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
			getReduceRate().requestFocus();
			return false;
		}

		// �������̒l���`�F�b�N����B
		int reduceRate = ACCastUtilities.toInt(getReduceRate().getText());
		if (reduceRate > 100) {
			// 100�𒴂���l�����͂���Ă����ꍇ
			QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
			// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
			getReduceRate().requestFocus();
			return false;
		}

		return true;
	}

  /**
	 * �u�p�l����Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
  public void stateManager(boolean state) throws Exception {
		// ���p�l����Ԑ���
		if (state) {
			// �����Ƃ���true���n���ꂽ�ꍇ
			setState_SET_PANEL_TRUE();
			
			setState();

		} else {
			// �����Ƃ���false���n���ꂽ�ꍇ
			// ���ID�FSET_PANEL_FALSE
			setState_SET_PANEL_FALSE();
		}

	}

  /**
   * �u�p�l���f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   */
  public void getDetails(VRMap map) throws Exception{
	  // �p�l���f�[�^�擾
	  
	  getMainGroup().setSource(map);
	  getMainGroup().applySource();
	  
	  // ������Ԃ̃R���g���[���̃f�[�^���폜����B
	  removeInvalidData(map);
	    
  }

  /**
   * �u�����f�[�^�폜�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param map VRMap
   * @throws Exception ������O
   */
  public void removeInvalidData(VRMap map) throws Exception{
	  // �����f�[�^�폜
	  
	  // �ȉ��̃R���g���[����������Ԃ̏ꍇ�A�ȉ���KEY��map���폜����B
	  // �EstaffAssignmentDivision �폜KEY�F1230102
	  // �EunitCareMaintenance �폜KEY�F1230118
	  if(!getStaffAssignmentDivision().isEnabled()){
		  map.removeData("1230102");
	  }
	  if(!getUnitCareMaintenance().isEnabled()){
		  map.removeData("1230118");
	  }
	  	  
  }

  /**
   * �u��Ԑ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  public void setState() throws Exception {
	  
	  // ��ʂ̏�Ԃ𐧌䂷��B
	  setStateByFacilitiesDivision();
//	  setStateByStaffLack();
	  
  }
  
  /**
   * �u�{�݋敪�ɂ���Ԑ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  public void setStateByFacilitiesDivision() throws Exception {

		// �{�݋敪�̒l���`�F�b�N����B
		int facilityType = getFacilitiesDivision().getSelectedIndex();
		if (facilityType == FACILITY_TYPE_BYOIN) {
			// �u�a�@�v���I�����ꂽ�ꍇ
			setState_FACILITY_TYPE_NORMAL();
		} else if (facilityType == FACILITY_TYPE_UNIT) {
			// �u���j�b�g�^�a�@�v���I�����ꂽ�ꍇ
			setState_FACILITY_TYPE_UNIT();
		} else {
			// �u�o�ߌ^�v���I�����ꂽ�ꍇ
			setState_FACILITY_TYPE_PASSAGE();
		}
	}

//  /**
//   * �u�l�����Z�ɂ���Ԑ���v�C�x���g�ł��B
//   * @param e �C�x���g���
//   * @throws Exception ������O
//   */
//  public void setStateByStaffLack() throws Exception {
//
//		// �{�݋敪�ɂ����āA�a�@�ȊO���I������Ă���ꍇ
//		if (getFacilitiesDivision().getSelectedIndex() != FACILITY_TYPE_BYOIN) {
//			return;
//		}
//
//		// �l�����Z�̒l���`�F�b�N����B
//		if (getStaffLack().getSelectedIndex() == STAFF_LACK_KANGO_KAIGO
//				|| getStaffLack().getSelectedIndex() == STAFF_LACK_SEIKAN
//				|| getStaffLack().getSelectedIndex() == STAFF_LACK_HEKICHI) {
//			// �ȉ��̍��ڂ��I�����ꂽ�ꍇ
//			// �u�Ō�E���E���������̏ꍇ�v
//			// �u���Ŕ䗦��20%�����̏ꍇ�v
//			// �u�ƒn�̈�t�m�یv���͂��o�Ă�����̈ȊO�̕a�@�̈�t�����K�v��60%�����̏ꍇ�v
//			setState_STAFF_ASSIGNMENT_TYPE2();
//		} else {
//			// ��L�ȊO�̏ꍇ
//			setState_STAFF_ASSIGNMENT_TYPE1();
//		}
//
//	}
}
