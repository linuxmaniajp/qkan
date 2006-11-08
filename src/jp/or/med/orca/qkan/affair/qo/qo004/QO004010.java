
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
 * �쐬��: 2006/02/13  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� �Z�������×{���i�a�@�×{�^�j (QO004010)
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
 * �Z�������×{���i�a�@�×{�^�j(QO004010) 
 */
public class QO004010 extends QO004010Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004010(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�Z�������×{���i�×{�^�a�@�j�H���z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i�×{�^�a�@�j�H���z���v�\������
    // �Z�������×{���i�×{�^�a�@�j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();

  }

  /**
   * �u�Z�������×{���i�×{�^�a�@�j�H���z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i�×{�^�a�@�j�H���z���v�\������
    // �Z�������×{���i�×{�^�a�@�j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();

  }

  /**
   * �u�Z�������×{���i�×{�^�a�@�j�H���z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayRecuperateCareHospitalNightDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i�×{�^�a�@�j�H���z���v�\������
    // �Z�������×{���i�×{�^�a�@�j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();

  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QO004010.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
    // ��������------------------------------------------------------
    // �������l�ݒ�------------------------------------------------------
	getShortStayHospitalRecuperationDiscountRate().setText("0");

    // ���R���{�A�C�e���̐ݒ�------------------------------------------------------
    // �R�[�h�}�X�^��艺�L�̃f�[�^���擾���A�l�����Z�R���{�̌��Ƃ��Đݒ肷��B
    // CODE_ID = CODE_STAFF_REDUCE
    VRList list = QkanCommon.getArrayFromMasterCode(CODE_STAFF_REDUCE, PATH_STAFF_REDUCE);
    getShortStayHospitalRecuperationStaffReduce().setModel(list);
    
  }

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public boolean isValidInput() throws Exception{
    // �����̓`�F�b�N------------------------------------------------------
    // �G���[���b�Z�[�W�����i�[�p�� errMsg�@���쐬����B
    String errMsg = null;
    
    // ���L�̃e�L�X�g�t�B�[���h�ɑ΂��ē��̓`�F�b�N���s���B�����͂������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
    // �EshortStayHospitalRecuperationDiscountRate�i�������j�� errMsg = ������
    if(ACTextUtilities.isNullText(getShortStayHospitalRecuperationDiscountRate().getText())){
    	errMsg = "������";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayHospitalRecuperationDiscountRate().requestFocus();
    	return false;
    }

    // �������̒l���`�F�b�N����B
    int reductRate = ACCastUtilities.toInt(getShortStayHospitalRecuperationDiscountRate().getText());
    if(reductRate > 100){
    	// 100�𒴂���l�����͂���Ă����ꍇ
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
    	getShortStayHospitalRecuperationDiscountRate().requestFocus();
	    return false;    	
    }   
    
    // ���L�̃��W�I�O���[�v�ɑ΂��đI���`�F�b�N���s���B���I���������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
    // �EshortStayHospitalRecuperationInstitutionDivisionRadio�i�{�݋敪���W�I�O���[�v�j�@��errMsg = �{�݋敪
    if(!getShortStayHospitalRecuperationInstitutionDivisionRadio().isSelected()){
    	errMsg = "�{�݋敪";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationInstitutionDivisionRadio().requestFocus();
        return false;
    }
    
    // �EshortStayHospitalRecuperationStaffAssignmentDivision�i�l���z�u�敪���W�I�O���[�v�j�@��errMsg = �l���z�u�敪
    if(!getShortStayHospitalRecuperationStaffAssignmentDivision().isSelected()){
    	errMsg = "�l���z�u�敪";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationStaffAssignmentDivision().requestFocus();
        return false;
    }
    
    // �EshortStayHospitalRecuperationNightShiftCondition�i��ԋΖ���������W�I�O���[�v�j�@��errMsg = ��ԋΖ������
    if(!getShortStayHospitalRecuperationNightShiftCondition().isSelected()){
    	errMsg = "��ԋΖ������";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationNightShiftCondition().requestFocus();
        return false;
    }
    
    // �EshortStayHospitalRecuperationRecuperationEnvironmental�i�×{������W�I�O���[�v�@��errMsg = �×{���
    if(!getShortStayHospitalRecuperationRecuperationEnvironmental().isSelected()){
    	errMsg = "�×{���";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationRecuperationEnvironmental().requestFocus();
        return false;
    }
    
    // �EshortStayHospitalRecuperationDoctorsArrangement�i��t�̔z�u����W�I�O���[�v�j�@��errMsg = ��t�̔z�u�
    if(!getShortStayHospitalRecuperationDoctorsArrangement().isSelected()){
    	errMsg = "��t�̔z�u�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationDoctorsArrangement().requestFocus();
        return false;
    }
    
    // �EshortStayHospitalRecuperationMeetingAndSendingOffSystem�i���}�̐����W�I�O���[�v�j�@��errMsg = ���}�̐�
    if(!getShortStayHospitalRecuperationMeetingAndSendingOffSystem().isSelected()){
    	errMsg = "���}�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationMeetingAndSendingOffSystem().requestFocus();
        return false;
    }
    
    // �EshortStayHospitalRecuperationNutritionManageRadio�i�h�{�Ǘ��̐����W�I�O���[�v�j�@��errMsg = �h�{�Ǘ��̐�
    if(!getShortStayHospitalRecuperationNutritionManageRadio().isSelected()){
    	errMsg = "�h�{�Ǘ��̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationNutritionManageRadio().requestFocus();
        return false;
    }
    
    // �EshortStayHospitalRecuperationRecuperationRadio�i�×{�H�̐����W�I�O���[�v�j�@��errMsg = �×{�H�̐�
    if(!getShortStayHospitalRecuperationRecuperationRadio().isSelected()){
    	errMsg = "�×{�H�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationRecuperationRadio().requestFocus();
        return false;
    }
    
    // ���L�̃R���{�̍��ڂ��I������Ă��邩�`�F�b�N���s���B���I���������ꍇ�� errMsg�@�Ƀ��b�Z�[�W���i�[����B
    // �EshortStayHospitalRecuperationStaffReduce�i�l�����Z�R���{�j�� errMsg = �l�����Z
    if(!getShortStayHospitalRecuperationStaffReduce().isSelected()){
    	errMsg = "�l�����Z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationStaffReduce().requestFocus();
        return false;
    }

    // �EshortStayRecuperateCareHospitalMorningDinnerStandeirdMoney�i�H���z�E���j�� errMsg = �H���z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareHospitalNoonDinnerStandeirdMoney�i�H���z�E���j�� errMsg = �H���z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney().requestFocus();
    	return false;
    }
	    
    // �EshortStayRecuperateCareHospitalNightDinnerStandeirdMoney�i�H���z�E��j�� errMsg =�@�H���z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalNightDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareHospitalNightDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText�@�� errMsg = ���j�b�g�^����z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText().getText())){
    	errMsg = "���j�b�g�^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText�@�� errMsg = ���j�b�g�^������z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText().getText())){
    	errMsg = "���j�b�g�^������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText�@�� errMsg = �]���^����z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText().getText())){
    	errMsg = "�]���^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareHospitalTasyouRoomText�@�� errMsg = ��������z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalTasyouRoomText().getText())){
    	errMsg = "��������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareHospitalTasyouRoomText().requestFocus();
    	return false;
    }
    
    return true;
    
  }

  /**
   * �u�H���z���v�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // �H���z���v����
    // ���L�̃e�L�X�g�t�B�[���h�̓��͂���Ă���l�����v�� shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal�i�H���z�E���v�e�L�X�g�t�B�[���h�j�ɒl��������B
    // �EshortStayRecuperateCareHospitalMorningDinnerStandeirdMoney(�H���z�E���E�e�L�X�g)
    // �EshortStayRecuperateCareHospitalNoonDinnerStandeirdMoney(�H���z�E���E�e�L�X�g)
    // �EshortStayRecuperateCareHospitalNightDinnerStandeirdMoney(�H���z�E��E�e�L�X�g)
	int valMorning = 0;
	int valNoon = 0;
	int valNight = 0;
	
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney().getText())){
		valMorning = ACCastUtilities.toInt(getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalNoonDinnerStandeirdMoney().getText())){
		valNoon = ACCastUtilities.toInt(getShortStayRecuperateCareHospitalNoonDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalNightDinnerStandeirdMoney().getText())){
    	valNight = ACCastUtilities.toInt(getShortStayRecuperateCareHospitalNightDinnerStandeirdMoney().getText());
	}
    
    int valTotal = valMorning + valNoon + valNight;
    
    if(valTotal == 0){
    	getShortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal().setText("");
    }else{
    	getShortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal().setText(ACCastUtilities.toString(valTotal));
    }
  }

  /**
	 * �u�p�l����Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception ������O
	 */
  public void stateManager(boolean state) throws Exception {
	
  }

  /**
   * �u�p�l���f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public void getDetails(VRMap map) throws Exception{
	  
  }

}
