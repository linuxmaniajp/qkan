
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
 * �J����: 
 * �쐬��: 2006/02/13  ���{�R���s���[�^�[�������  �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� �Z�������×{���i�f�Ï��×{�^�j (QO004011)
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
 * �Z�������×{���i�f�Ï��×{�^�j(QO004011) 
 */
public class QO004011 extends QO004011Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004011(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�Z�������×{���i�f�Ï��×{�^�j�H�����v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayRecuperateCareClinicMorningDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i�f�Ï��×{�^�j�H�����v�\������
    // �Z�������×{���i�f�Ï��×{�^�j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();
  }

  /**
   * �u�Z�������×{���i�f�Ï��×{�^�j�H�����v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayRecuperateCareClinicNoonDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i�f�Ï��×{�^�j�H�����v�\������
    // �Z�������×{���i�f�Ï��×{�^�j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();
  }

  /**
   * �u�Z�������×{���i�f�Ï��×{�^�j�H�����v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayRecuperateCareClinicNightDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i�f�Ï��×{�^�j�H�����v�\������
    // �Z�������×{���i�f�Ï��×{�^�j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QO004011.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�Z�������×{���i�f�Ï��×{�^�j�H�����v�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // �Z�������×{���i�f�Ï��×{�^�j�H�����v����
    // ���L�̃e�L�X�g�t�B�[���h�ɓ��͂���Ă���l�����v�� shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal
	// �i�H���z�E���v�e�L�X�g�t�B�[���h�j�ɒl��������B
	// �EshortStayRecuperateCareClinicMorningDinnerStandeirdMoney(�H���z�E���E�e�L�X�g)
	// �EshortStayRecuperateCareClinicNoonDinnerStandeirdMoney(�H���z�E���E�e�L�X�g)
	// �EshortStayRecuperateCareClinicNightDinnerStandeirdMoney(�H���z�E��E�e�L�X�g)
	int valMorning = 0;
	int valNoon = 0;
	int valNight = 0;
	
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareClinicMorningDinnerStandeirdMoney().getText())){
		valMorning = ACCastUtilities.toInt(getShortStayRecuperateCareClinicMorningDinnerStandeirdMoney().getText()); 
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareClinicNoonDinnerStandeirdMoney().getText())){
		valNoon = ACCastUtilities.toInt(getShortStayRecuperateCareClinicNoonDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareClinicNightDinnerStandeirdMoney().getText())){
		valNight = ACCastUtilities.toInt(getShortStayRecuperateCareClinicNightDinnerStandeirdMoney().getText());
	}
	
	int valTotal = valMorning + valNoon + valNight;
	
	if(valTotal == 0){
		getShortStayRecuperateCareClinicDinnerStandeirdMoneyTotal().setText("");
	}else{
		getShortStayRecuperateCareClinicDinnerStandeirdMoneyTotal().setText(ACCastUtilities.toString(valTotal));
	}

  }

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
    // ��������------------------------------------------------------
    // �������l�ݒ�------------------------------------------------------
	// �������e�L�X�g�ɏ����l0��\������B
	getShortStayClinicRecuperationDiscountRate().setText("0");

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
    // �EshortStayClinicRecuperationDiscountRate�i�������j�@��errMsg = ������
    if(ACTextUtilities.isNullText(getShortStayClinicRecuperationDiscountRate().getText())){
    	errMsg = "������";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayClinicRecuperationDiscountRate().requestFocus();
    	return false;
    }

    // �������̒l���`�F�b�N����B
    int reductRate = ACCastUtilities.toInt(getShortStayClinicRecuperationDiscountRate().getText());
    if(reductRate > 100){
    	// 100�𒴂���l�����͂���Ă����ꍇ
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
    	getShortStayClinicRecuperationDiscountRate().requestFocus();
	    return false;    	
    }   
    
    // ���L�̃��W�I�O���[�v�ɑ΂��đI���`�F�b�N���s���B���I���������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
    // �EshortStayInstitutionDivisionRadio�i�{�݋敪���W�I�O���[�v�j�@��errMsg = �{�݋敪
    if(!getShortStayInstitutionDivisionRadio().isSelected()){
    	errMsg = "�{�݋敪";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayInstitutionDivisionRadio().requestFocus();
        return false;
    }
        
    // �EshortStayStaffAssignmentDivision�i�l���z�u�敪���W�I�O���[�v�j�@��errMsg = �l���z�u�敪
    if(!getShortStayStaffAssignmentDivision().isSelected()){
    	errMsg = "�l���z�u�敪";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayStaffAssignmentDivision().requestFocus();
        return false;
    }
        
    // �EshortStayRecuperationEnvironmental�i�×{������W�I�O���[�v�j�@��errMsg = �×{���
    if(!getShortStayRecuperationEnvironmental().isSelected()){
    	errMsg = "�×{���";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayRecuperationEnvironmental().requestFocus();
        return false;
    }
        
    // �EshortStayMeetingAndSendingOffSystem�i���}�̐����W�I�O���[�v�j�� errMsg = ���}�̐�
    if(!getShortStayMeetingAndSendingOffSystem().isSelected()){
    	errMsg = "���}�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayMeetingAndSendingOffSystem().requestFocus();
        return false;
    }
        
    // �EshortStayNutritionManageRadio�i�h�{�Ǘ��̐����W�I�O���[�v�j�@��errMsg = �h�{�Ǘ��̐�
    if(!getShortStayNutritionManageRadio().isSelected()){
    	errMsg = "�h�{�Ǘ��̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayNutritionManageRadio().requestFocus();
        return false;
    }
        
    // �EshortStayRecuperateDinnerRadio�i�×{�H�̐����W�I�O���[�v�j�@��errMsg = �×{�H�̐�
    if(!getShortStayRecuperateDinnerRadio().isSelected()){
    	errMsg = "�×{�H�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayRecuperateDinnerRadio().requestFocus();
        return false;
    }
     
    // �EshortStayStaffReduce�i�l�����Z���W�I�O���[�v�j�@��errMsg = �l�����Z
    if(!getShortStayStaffReduce().isSelected()){
    	errMsg = "�l�����Z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayStaffReduce().requestFocus();
        return false;
    }

    // �EshortStayRecuperateCareClinicMorningDinnerStandeirdMoney�i�H���z�E���j
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareClinicMorningDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareClinicMorningDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareClinicNoonDinnerStandeirdMoney�i�H���z�E���j
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareClinicNoonDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareClinicNoonDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareClinicNightDinnerStandeirdMoney�i�H���z�E��j
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareClinicNightDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareClinicNightDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareClinicUnitRoomStandeirdMoneyText�@�� errMsg = ���j�b�g�^����z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyText().getText())){
    	errMsg = "���j�b�g�^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText�@�� errMsg = ���j�b�g�^������z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText().getText())){
    	errMsg = "���j�b�g�^������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareClinicNormalRoomStandeirdMoneyText�@�� errMsg = �]���^����z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyText().getText())){
    	errMsg = "�]���^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareClinicTasyouRoomText�@�� errMsg = ��������z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareClinicTasyouRoomText().getText())){
    	errMsg = "��������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareClinicTasyouRoomText().requestFocus();
    	return false;
    }
    
    return true;
    
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
