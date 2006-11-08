
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
 * �v���O���� ���×{�^��Î{�݁i�F�m�ǎ����^�j (QO004020)
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
 * ���×{�^��Î{�݁i�F�m�ǎ����^�j(QO004020) 
 */
public class QO004020 extends QO004020Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004020(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u���×{�^��Î{�݁i�F�m�ǎ����^�j�H����z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // ���×{�^��Î{�݁i�F�m�ǎ����^�j�H����z���v�\������
    // ���×{�^��Î{�݁i�F�m�ǎ����^�j�H����z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();

  }

  /**
   * �u���×{�^��Î{�݁i�F�m�ǎ����^�j�H����z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // ���×{�^��Î{�݁i�F�m�ǎ����^�j�H����z���v�\������
    // ���×{�^��Î{�݁i�F�m�ǎ����^�j�H����z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();


  }

  /**
   * �u���×{�^��Î{�݁i�F�m�ǎ����^�j�H����z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // ���×{�^��Î{�݁i�F�m�ǎ����^�j�H����z���v�\������
    // ���×{�^��Î{�݁i�F�m�ǎ����^�j�H����z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();

  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QO004020.class.getName(), param));
  }

  //�����֐�

  /**
   * �u���×{�^��Î{�݁i�F�m�ǎ����^�j�H����z���v�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // ���×{�^��Î{�݁i�F�m�ǎ����^�j�H����z���v����
    // ���L�̃e�L�X�g�t�B�[���h�ɓ��͂���Ă���l�����v�� kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal
	// �i�H���z�E���v�e�L�X�g�t�B�[���h�j�ɒl��������B
    // �EkaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney(�H���z�E���E�e�L�X�g)
    // �EkaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney(�H���z�E���E�e�L�X�g)
    // �EkaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney(�H���z�E��E�e�L�X�g)
	int valMorning = 0;
	int valNoon = 0;
	int valNight = 0;
	
	if(!ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney().getText())){
		valMorning = ACCastUtilities.toInt(getKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney().getText())){
		valNoon = ACCastUtilities.toInt(getKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney().getText())){
		valNight = ACCastUtilities.toInt(getKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney().getText());
	}
	
	int valTotal = valMorning + valNoon + valNight;
	
	if(valTotal == 0){
		getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal().setText("");
	}else{
		getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal().setText(ACCastUtilities.toString(valTotal));
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
    // �EkaigoRecuperationMedicalFacilitiesDiscountRate
	getKaigoRecuperationMedicalFacilitiesDiscountRate().setText("0");
	
    // ���R���{�A�C�e���̐ݒ�------------------------------------------------------
    // �R�[�h�}�X�^��艺�L�̃f�[�^���擾����B
    // CODE_ID = CODE_STAFF_REDUCE
    VRList list = QkanCommon.getArrayFromMasterCode(CODE_STAFF_REDUCE, PATH_STAFF_REDUCE);
    
    // �擾�����f�[�^��l�����Z�R���{�̌��Ƃ��Đݒ肷��B
    getStaffLack().setModel(list);
    
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
    // �EkaigoRecuperationMedicalFacilitiesDiscountRate�i�������e�L�X�g�j�@��errMsg = ������
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesDiscountRate().getText())){
    	errMsg = "������";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesDiscountRate().requestFocus();
    	return false;
    }

    // �������̒l���`�F�b�N����B
    int reductRate = ACCastUtilities.toInt(getKaigoRecuperationMedicalFacilitiesDiscountRate().getText());
    if(reductRate > 100){
    	// 100�𒴂���l�����͂���Ă����ꍇ
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
    	getKaigoRecuperationMedicalFacilitiesDiscountRate().requestFocus();
	    return false;    	
    }   
    
    // ���L�̃��W�I�O���[�v�ɑ΂��đI���`�F�b�N���s���B���I���������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
    // �EInstitutionDivisionRadio�i�{�݋敪�j ���@errMsg = �{�݋敪
    if(!getInstitutionDivisionRadio().isSelected()){
    	errMsg = "�{�݋敪";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getInstitutionDivisionRadio().requestFocus();
        return false;
    }
        
    // �EstaffAssignmentDivision�i�l���z�u�敪���W�I�O���[�v�j�@��errMsg = �l���z�u�敪
    if(!getStaffAssignmentDivision().isSelected()){
    	errMsg = "�l���z�u�敪";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getStaffAssignmentDivision().requestFocus();
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
    
    // �ErecuperateDinnerRadio�i�×{�H�̐����W�I�O���[�v�j  ��errMsg = �×{�H�̐�
    if(!getRecuperateDinnerRadio().isSelected()){
    	errMsg = "�×{�H�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getRecuperateDinnerRadio().requestFocus();
        return false;
    }

    // �EstaffLack�i�l�����Z�R���{�j  ��errMsg = �l�����Z
    if(!getStaffLack().isSelected()){
    	errMsg = "�l�����Z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getStaffLack().requestFocus();
        return false;
    }

    // �EkaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney�i�H���z�E���j�@��errMsg = �H���z
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EkaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney�i�H���z�E���j�@��errMsg = �H���z
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EkaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney�i�H���z�E��j�@��errMsg = �H���z
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EkaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText�@�� errMsg = ���j�b�g�^����z
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText().getText())){
    	errMsg = "���j�b�g�^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EkaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText�@�� errMsg = ���j�b�g�^������z
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText().getText())){
    	errMsg = "���j�b�g�^������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EkaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText�@�� errMsg = �]���^����z
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText().getText())){
    	errMsg = "�]���^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EkaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText�@�� errMsg = ��������z
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText().getText())){
    	errMsg = "��������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText().requestFocus();
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
