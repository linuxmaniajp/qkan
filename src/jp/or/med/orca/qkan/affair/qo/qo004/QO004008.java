
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
 * �쐬��: 2006/02/10  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� �Z������������� (QO004008)
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
 * �Z�������������(QO004008) 
 */
public class QO004008 extends QO004008Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004008(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�Z�������������E���z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayMorningDinnerStandardMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������������E���z���v�\������
    // �Z�������������H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
	  dinnerStandeirdMoneyTotal();

  }

  /**
   * �u�Z�������������E���z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayNoonDinnerStandardMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������������E���z���v�\������
    // �Z�������������H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
	  dinnerStandeirdMoneyTotal();

  }

  /**
   * �u�Z�������������E���z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayNightDinnerStandardMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������������E���z���v�\������
    // �Z�������������H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
	  dinnerStandeirdMoneyTotal();

  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QO004008.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�Z�������������E���z���v�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // �Z�������������E���z���v����
    // ���L�̃e�L�X�g�t�B�[���h�̓��͂���Ă���l�����v�� shortStayDinnerStandardMoneyTotal �i�H���z�E���v�e�L�X�g�t�B�[���h�j�ɒl��������B
	// �EshortStayMorningDinnerStandardMoney(�H���z�E���E�e�L�X�g)
	// �EshortStayNoonDinnerStandardMoney(�H���z�E���E�e�L�X�g)
	// �EshortStayNightDinnerStandardMoney(�H���z�E��E�e�L�X�g)
	int valMorning = 0;
	int valNoon = 0;
	int valNight = 0;
	
	if(!ACTextUtilities.isNullText(getShortStayMorningDinnerStandardMoney().getText())){
		valMorning = ACCastUtilities.toInt(getShortStayMorningDinnerStandardMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayNoonDinnerStandardMoney().getText())){
		valNoon	 = ACCastUtilities.toInt(getShortStayNoonDinnerStandardMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayNightDinnerStandardMoney().getText())){
		valNight = ACCastUtilities.toInt(getShortStayNightDinnerStandardMoney().getText());
	}
	int valTotal = valMorning + valNoon + valNight;
	
	if(valTotal == 0){
		getShortStayDinnerStandardMoneyTotal().setText("");
	}else{
		getShortStayDinnerStandardMoneyTotal().setText(ACCastUtilities.toString(valTotal));
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
	getShortStayLifeDiscountRate().setText("0");
	
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
    // �EshortStayLifeDiscountRate�i�������e�L�X�g�j�� errMsg = ������
    if(ACTextUtilities.isNullText(getShortStayLifeDiscountRate().getText())){
    	errMsg = "������";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayLifeDiscountRate().requestFocus();
        return false;
    }

    // �������̒l���`�F�b�N����B
    int reductRate = ACCastUtilities.toInt(getShortStayLifeDiscountRate().getText());
    if(reductRate > 100){
    	// 100�𒴂���l�����͂���Ă����ꍇ
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
    	getShortStayLifeDiscountRate().requestFocus();
	    return false;    	
    }   
        
    // ���L�̃��W�I�O���[�v�ɑ΂��đI���`�F�b�N���s���B���I���������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
    // �EshortStayLifeFacilitiesDivision�i�{�݋敪���W�I�O���[�v�j�� errMsg = �{�݋敪
    if(!getShortStayLifeFacilitiesDivision().isSelected()){
    	errMsg = "�{�݋敪";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayLifeFacilitiesDivision().requestFocus();
    	return false;
    }
    
    // �EshortStayNightWorkDivision�i��ԋΖ���������W�I�O���[�v�j�� errMsg = ��ԋΖ������
    if(!getShortStayNightWorkDivision().isSelected()){
    	errMsg = "��ԋΖ������";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayNightWorkDivision().requestFocus();
    	return false;
    }
    
    // �EshortStayLifeFunctionTrainingGuidanceSystem�i�@�\�P���w���̐����W�I�O���[�v�j�� errMsg = �@�\�P���w���̐�
    if(!getShortStayLifeFunctionTrainingGuidanceSystem().isSelected()){
    	errMsg = "�@�\�P���w���̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayLifeFunctionTrainingGuidanceSystem().requestFocus();
    	return false;
    }
    
    // �EshortStayMeetingAndSendingOffSystem�i���}�̐����W�I�O���[�v�j�� errMsg = ���}�̐�
    if(!getShortStayMeetingAndSendingOffSystem().isSelected()){
    	errMsg = "���}�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayMeetingAndSendingOffSystem().requestFocus();
    	return false;
    }
    
    // �EshortStayLifeNutritionManageRadio�i�h�{�Ǘ��̐����W�I�O���[�v�j�� errMsg = �h�{�Ǘ��̐�
    if(!getShortStayLifeNutritionManageRadio().isSelected()){
    	errMsg = "�h�{�Ǘ��̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayLifeNutritionManageRadio().requestFocus();
    	return false;
    }
    
    // �EshortStayLifeRecuperatDinnerRadio�i�×{�H�̐����W�I�O���[�v�j�� errMsg = �×{�H�̐�
    if(!getShortStayLifeRecuperatDinnerRadio().isSelected()){
    	errMsg = "�×{�H�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayLifeRecuperatDinnerRadio().requestFocus();
    	return false;
    }
    
    // �EshortStayStaffReduceRadio�i�l�����Z���W�I�O���[�v�j�� errMsg = �l�����Z
    if(!getShortStayStaffReduceRadio().isSelected()){
    	errMsg = "�l�����Z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayStaffReduceRadio().requestFocus();
    	return false;
    }

    // �EshortStayMorningDinnerStandardMoney�i�H���z�E���e�L�X�g�j�� errMsg = �H���z
    if(ACTextUtilities.isNullText(getShortStayMorningDinnerStandardMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayMorningDinnerStandardMoney().requestFocus();
        return false;
    }
    
    // �EshortStayNoonDinnerStandardMoney�i�H���z�E���e�L�X�g�j�� errMsg = �H���z
    if(ACTextUtilities.isNullText(getShortStayNoonDinnerStandardMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayNoonDinnerStandardMoney().requestFocus();
        return false;
    }
    
    // �EshortStayNightDinnerStandardMoney�i�H���z�E��e�L�X�g�j�� errMsg = �H���z
    if(ACTextUtilities.isNullText(getShortStayNightDinnerStandardMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayNightDinnerStandardMoney().requestFocus();
        return false;
    }
    
    // �EshortStayUnitRoomStandardMoneyText�@�� errMsg = ���j�b�g�^����z
    if(ACTextUtilities.isNullText(getShortStayUnitRoomStandardMoneyText().getText())){
    	errMsg = "���j�b�g�^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayUnitRoomStandardMoneyText().requestFocus();
        return false;
    }
    
    // �EshortStayUnitSemiRoomStandardMoneyText�@�� errMsg = ���j�b�g�^������z
    if(ACTextUtilities.isNullText(getShortStayUnitSemiRoomStandardMoneyText().getText())){
    	errMsg = "���j�b�g�^������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayUnitSemiRoomStandardMoneyText().requestFocus();
        return false;
    }
    
    // �EshortStayNormalRoomStandardMoneyText�@�� errMsg = �]���^����z
    if(ACTextUtilities.isNullText(getShortStayNormalRoomStandardMoneyText().getText())){
    	errMsg = "�]���^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayNormalRoomStandardMoneyText().requestFocus();
        return false;
    }
    
    // �EshortStayTasyouRoomText�@�� errMsg = ��������z
    if(ACTextUtilities.isNullText(getShortStayTasyouRoomText().getText())){
    	errMsg = "��������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayTasyouRoomText().requestFocus();
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
