
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
 * �쐬��: 2006/02/13  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� �Z�������×{���i��K���f�Ï��^�j (QO004013)
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
import jp.or.med.orca.qkan.lib.*;

/**
 * �Z�������×{���i��K���f�Ï��^�j(QO004013) 
 */
public class QO004013 extends QO004013Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004013(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�Z�������×{���i��K���f�Ï��j�H���z���v�\�����������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayRecuperateCareStandardMorningDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i��K���f�Ï��j�H���z���v�\����������
    // �Z�������×{���i��K���f�Ï��j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();

  }

  /**
   * �u�Z�������×{���i��K���f�Ï��j�H���z���v�\�����������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayRecuperateCareStandardNoonDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i��K���f�Ï��j�H���z���v�\����������
    // �Z�������×{���i��K���f�Ï��j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();

  }

  /**
   * �u�Z�������×{���i��K���f�Ï��j�H���z���v�\�����������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayRecuperateCareStandardNightDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i��K���f�Ï��j�H���z���v�\����������
    // �Z�������×{���i��K���f�Ï��j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();

  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QO004013.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�Z�������×{���i��K���f�Ï��^�j�H�����v�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // �Z�������×{���i��K���f�Ï��^�j�H�����v����
    // ���L�̃e�L�X�g�t�B�[���h�ɓ��͂���Ă���l�����v��shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal�i�H���z�E���v�e�L�X�g�t�B�[���h�j�ɒl��������B
    // �EshortStayRecuperateCareStandardMorningDinnerStandeirdMoney(�H���z�E���E�e�L�X�g)
    // �EshortStayRecuperateCareStandardNoonDinnerStandeirdMoney(�H���z�E���E�e�L�X�g)
    // �EshortStayRecuperateCareStandardNightDinnerStandeirdMoney(�H���z�E��E�e�L�X�g)
	int valMorning = 0;
	int valNoon = 0;
	int valNight = 0;
	
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareStandardMorningDinnerStandeirdMoney().getText())){
		valMorning = ACCastUtilities.toInt(getShortStayRecuperateCareStandardMorningDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareStandardNoonDinnerStandeirdMoney().getText())){
		valNoon = ACCastUtilities.toInt(getShortStayRecuperateCareStandardNoonDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareStandardNightDinnerStandeirdMoney().getText())){
		valNoon = ACCastUtilities.toInt(getShortStayRecuperateCareStandardNightDinnerStandeirdMoney().getText());
	}
	
	int valTotal = valMorning + valNoon + valNight;
	
	if(valTotal == 0){
		getShortStayRecuperateCareStandardDinnerStandeirdMoneyTotal().setText("");
	}else{
		getShortStayRecuperateCareStandardDinnerStandeirdMoneyTotal().setText(ACCastUtilities.toString(valTotal));
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
	getShortStayStandardAgreementRecuperationDiscountRate().setText("0");

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
    // �EshortStayStandardAgreementRecuperationDiscountRate�i�������j�@��errMsg = ������
    if(ACTextUtilities.isNullText(getShortStayStandardAgreementRecuperationDiscountRate().getText())){
    	errMsg = "������";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayStandardAgreementRecuperationDiscountRate().requestFocus();
    	return false;
    }

    // �������̒l���`�F�b�N����B
    int reductRate = ACCastUtilities.toInt(getShortStayStandardAgreementRecuperationDiscountRate().getText());
    if(reductRate > 100){
    	// 100�𒴂���l�����͂���Ă����ꍇ
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
    	getShortStayStandardAgreementRecuperationDiscountRate().requestFocus();
	    return false;    	
    }   
    
    // ���L�̃��W�I�O���[�v�ɑ΂��đI���`�F�b�N���s���B���I���������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
    // �EshortStayStandardAgreementRecuperationMeetingAndSendingOffSystem�i���}�̐����W�I�O���[�v�j�@��errMsg = ���}�̐�
    if(!getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem().isSelected()){
    	errMsg = "���}�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem().requestFocus();
        return false;
    }
        
    // �EshortStayStandardAgreementRecuperationNutritionManageRadio�i�h�{�Ǘ��̐����W�I�O���[�v�j�@��errMsg = �h�{�Ǘ��̐�
    if(!getShortStayStandardAgreementRecuperationNutritionManageRadio().isSelected()){
    	errMsg = "�h�{�Ǘ��̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayStandardAgreementRecuperationNutritionManageRadio().requestFocus();
        return false;
    }
        
    // �EshortStayStandardAgreementRecuperationRecuperateRadio�i�×{�H�̐����W�I�O���[�v�j�@��errMsg = �×{�H�̐�
    if(!getShortStayStandardAgreementRecuperationRecuperateRadio().isSelected()){
    	errMsg = "�×{�H�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayStandardAgreementRecuperationRecuperateRadio().requestFocus();
        return false;
    }
        
    // �EshortStayStandardAgreementRecuperationStaffReduceRadio�i�l�����Z���W�I�O���[�v�j�@��errMsg = �l�����Z
    if(!getShortStayStandardAgreementRecuperationStaffReduceRadio().isSelected()){
    	errMsg = "�l�����Z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayStandardAgreementRecuperationStaffReduceRadio().requestFocus();
        return false;
    }

    // �EshortStayRecuperateCareStandardMorningDinnerStandeirdMoney�i�H���z�E���j�@��errMsg = �H���z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareStandardMorningDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareStandardMorningDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareStandardNoonDinnerStandeirdMoney�i�H���z�E���j�@��errMsg = �H���z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareStandardNoonDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareStandardNoonDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareStandardNightDinnerStandeirdMoney�i�H���z�E��j�@��errMsg = �H���z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareStandardNightDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareStandardNightDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareStandardUnitRoomStandeirdMoneyText�@�� errMsg = ���j�b�g�^����z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyText().getText())){
    	errMsg = "���j�b�g�^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText�@�� errMsg = ���j�b�g�^������z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText().getText())){
    	errMsg = "���j�b�g�^������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareStandardNormalRoomStandeirdMoneyText�@�� errMsg = �]���^����z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyText().getText())){
    	errMsg = "�]���^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareStandardTasyouRoomText�@�� errMsg = ��������z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareStandardTasyouRoomText().getText())){
    	errMsg = "��������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareStandardTasyouRoomText().requestFocus();
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
