
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
 * �쐬��: 2006/02/14  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� ���V�l�ی��{�� (QO004017)
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

/**
 * ���V�l�ی��{��(QO004017) 
 */
public class QO004017 extends QO004017Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004017(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u���V�l�ی��{�ݐH����z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // ���V�l�ی��{�ݐH����z���v�\������
    // ���V�l�ی��{�ݐH����z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();

  }

  /**
   * �u���V�l�ی��{�ݐH����z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // ���V�l�ی��{�ݐH����z���v�\������
    // ���V�l�ی��{�ݐH����z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();

  }

  /**
   * �u���V�l�ی��{�ݐH����z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void careOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // ���V�l�ی��{�ݐH����z���v�\������
    // ���V�l�ی��{�ݐH����z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();

  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QO004017.class.getName(), param));
  }

  //�����֐�

  /**
   * �u���V�l�ی��{�ݐH����z���v�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // ���V�l�ی��{�ݐH����z���v����
    // ���L�̃e�L�X�g�t�B�[���h�ɓ��͂���Ă���l�����v��careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal�i�H���z�E���v�e�L�X�g�t�B�[���h�j�ɒl��������B
    // �EcareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney(�H���z�E���E�e�L�X�g)
    // �EcareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney(�H���z�E���E�e�L�X�g)
    // �EcareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney(�H���z�E��E�e�L�X�g)
	int valMorning = 0;
	int valNoon = 0;
	int valNight = 0;
	
	if(!ACTextUtilities.isNullText(getCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney().getText())){
		valMorning = ACCastUtilities.toInt(getCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney().getText())){
		valNoon = ACCastUtilities.toInt(getCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney().getText())){
		valNight = ACCastUtilities.toInt(getCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney().getText());
	}
	
	int valTotal = valMorning + valNoon + valNight;
	
	if(valTotal == 0){
		getCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal().setText("");
	}else{
		getCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal().setText(ACCastUtilities.toString(valTotal));
	}

  }

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
    // ��������------------------------------------------------------
    // �������l�ݒ�------------------------------------------------------
    // �������e�L�X�g�ɏ����l0��������B
    // �EagedPeopleHealthFacilityDiscountRate
	getAgedPeopleHealthFacilityDiscountRate().setText("0");

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
    // �EagedPeopleHealthFacilityDiscountRate(�������e�L�X�g�j�@��errMsg = ������
    if(ACTextUtilities.isNullText(getAgedPeopleHealthFacilityDiscountRate().getText())){
    	errMsg = "������";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getAgedPeopleHealthFacilityDiscountRate().requestFocus();
    	return false;
    }

    // �������̒l���`�F�b�N����B
    int reductRate = ACCastUtilities.toInt(getAgedPeopleHealthFacilityDiscountRate().getText());
    if(reductRate > 100){
    	// 100�𒴂���l�����͂���Ă����ꍇ
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
    	getAgedPeopleHealthFacilityDiscountRate().requestFocus();
	    return false;    	
    }   
    
    // ���L�̃��W�I�O���[�v�ɑ΂��đI���`�F�b�N���s���B���I���������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
    // �EinstitutionDivisionRadio�i�{�݋敪�j ���@errMsg = �{�݋敪
    if(!getInstitutionDivisionRadio().isSelected()){
    	errMsg = "�{�݋敪";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getInstitutionDivisionRadio().requestFocus();
        return false;
    }
        
    // �EnightShiftCondition�i��ԋΖ�������j�@��errMsg = ��ԋΖ������
    if(!getNightShiftCondition().isSelected()){
    	errMsg = "��ԋΖ������";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getNightShiftCondition().requestFocus();
        return false;
    }
        
    // �ErehabilitationFunctionalEnhancement�i���n�r���e�[�V�����@�\�������W�I�O���[�v�j�@��errMsg = ���n�r���e�[�V�����@�\����
    if(!getRehabilitationFunctionalEnhancement().isSelected()){
    	errMsg = "���n�r���e�[�V�����@�\����";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getRehabilitationFunctionalEnhancement().requestFocus();
        return false;
    }
        
    // �EdementiaSpecialBuilding�i�F�m�ǐ�哏���W�I�O���[�v�j�@��errMsg = �F�m�ǐ�哏
    if(!getDementiaSpecialBuilding().isSelected()){
    	errMsg = "�F�m�ǐ�哏";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getDementiaSpecialBuilding().requestFocus();
        return false;
    }
        
    // �EnutritionManageRadio�i�h�{�Ǘ��̐����W�I�O���[�v�h�{�Ǘ��̐����W�I�O���[�v�j�@��errMsg = �h�{�Ǘ��̐�
    if(!getNutritionManageRadio().isSelected()){
    	errMsg = "�h�{�Ǘ��̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getNutritionManageRadio().requestFocus();
        return false;
    }
        
    // �EnutritionRadio�i�h�{�}�l�W�����g�̐����W�I�O���[�v�j�@��errMsg =�@�h�{�}�l�W�����g�̐�
    if(!getNutritionRadio().isSelected()){
    	errMsg = "�h�{�}�l�W�����g�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getNutritionRadio().requestFocus();
        return false;
    }
        
    // �EoralSwitchRadio�i�o���ڍs�̐����W�I�O���[�v�j�@��errMsg = �o���ڍs�̐�
    if(!getOralSwitchRadio().isSelected()){
    	errMsg = "�o���ڍs�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getOralSwitchRadio().requestFocus();
        return false;
    }
        
    // �ErecuperateDinnerRadio�i�×{�H�̐����W�I�O���[�v�j  ���×{�H�̐�
    if(!getRecuperateDinnerRadio().isSelected()){
    	errMsg = "�×{�H�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getRecuperateDinnerRadio().requestFocus();
        return false;
    }
        
    // �EstaffLack�i�l�����Z���W�I�O���[�v�j�@���l�����Z
    if(!getStaffLack().isSelected()){
    	errMsg = "�l�����Z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getStaffLack().requestFocus();
        return false;
    }

    // �EcareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney�i�H����z�E���j�@��errMsg = �H���z
    if(ACTextUtilities.isNullText(getCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EcareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney�i�H����z�E���j�@��errMsg = �H���z
    if(ACTextUtilities.isNullText(getCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EcareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney�i�H����z�E��j�@��errMsg = �H���z
    if(ACTextUtilities.isNullText(getCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EcareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText�@�� errMsg = ���j�b�g�^����z
    if(ACTextUtilities.isNullText(getCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText().getText())){
    	errMsg = "���j�b�g�^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EcareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText�@�� errMsg = ���j�b�g�^������z
    if(ACTextUtilities.isNullText(getCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText().getText())){
    	errMsg = "���j�b�g�^������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EcareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText�@�� errMsg = �]���^����z
    if(ACTextUtilities.isNullText(getCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText().getText())){
    	errMsg = "�]���^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EcareOldPeopleHealthFacilitiesTasyouRoomText�@�� errMsg = ��������z
    if(ACTextUtilities.isNullText(getCareOldPeopleHealthFacilitiesTasyouRoomText().getText())){
    	errMsg = "��������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getCareOldPeopleHealthFacilitiesTasyouRoomText().requestFocus();
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
