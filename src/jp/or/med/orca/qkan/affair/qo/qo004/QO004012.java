
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
 * �v���O���� �Z�������×{���i�F�m�ǎ����^�j (QO004012)
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
 * �Z�������×{���i�F�m�ǎ����^�j(QO004012) 
 */
public class QO004012 extends QO004012Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004012(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�Z�������×{���i�F�m�ǎ����^�j�H�����v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i�F�m�ǎ����^�j�H�����v�\������
    // �Z�������×{���i�F�m�ǎ����^�j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();

  }

  /**
   * �u�Z�������×{���i�F�m�ǎ����^�j�H�����v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i�F�m�ǎ����^�j�H�����v�\������
    // �Z�������×{���i�F�m�ǎ����^�j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();

  }

  /**
   * �u�Z�������×{���i�F�m�ǎ����^�j�H�����v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayRecuperateCareCognitiveNightDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i�F�m�ǎ����^�j�H�����v�\������
    // �Z�������×{���i�F�m�ǎ����^�j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
    dinnerStandeirdMoneyTotal();

  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QO004012.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�Z�������×{���i�F�m�ǎ����^�j�H�����v�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // �Z�������×{���i�F�m�ǎ����^�j�H�����v����
    // ���L�̃e�L�X�g�t�B�[���h�ɓ��͂���Ă���l�����v�� shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal�i�H���z�E���v�e�L�X�g�t�B�[���h�j�ɒl��������B
    // �EshortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney(�H���z�E���E�e�L�X�g)
    // �EshortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney(�H���z�E���E�e�L�X�g)
    // �EshortStayRecuperateCareCognitiveNightDinnerStandeirdMoney(�H���z�E��E�e�L�X�g)
	int valMorning = 0;
	int valNoon = 0;
	int valNight = 0;
	
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney().getText())){
		valMorning = ACCastUtilities.toInt(getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney().getText())){
		valNoon = ACCastUtilities.toInt(getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney().getText())){
		valNight = ACCastUtilities.toInt(getShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney().getText());
	}
	
	int valTotal = valMorning + valNoon + valNight;
	
	if(valTotal == 0){
		getShortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal().setText("");
	}else{
		getShortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal().setText(ACCastUtilities.toString(valTotal));
	}

  }

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
    // ��������------------------------------------------------------
    // �������l�ݒ�------------------------------------------------------
    // �\�[�X�𐶐����A�p�l���S�̂ɐݒ肷��B
    // ��ʂɓW�J���A�����l��\������B
	// �������e�L�X�g�ɏ����l0��\������B
	getShortStayDementiaDiseaseRecuperationDiscountRate().setText("0");
	
    // ���R���{�A�C�e���̐ݒ�------------------------------------------------------
    // �R�[�h�}�X�^��艺�L�̃f�[�^���擾���A�l�����Z�R���{�̌��Ƃ��Đݒ肷��B
    // CODE_ID = 173
    VRList list = QkanCommon.getArrayFromMasterCode(CODE_STAFF_REDUCE, PATH_STAFF_REDUCE);
    getShortStayDementiaDiseaseRecuperationStaffReduce().setModel(list);
    
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
    // �EshortStayDementiaDiseaseRecuperationDiscountRate�i�������e�L�X�g�j�@��errMsg = ������
    if(ACTextUtilities.isNullText(getShortStayDementiaDiseaseRecuperationDiscountRate().getText())){
    	errMsg = "������";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayDementiaDiseaseRecuperationDiscountRate().requestFocus();
    	return false;
    }

    // �������̒l���`�F�b�N����B
    int reductRate = ACCastUtilities.toInt(getShortStayDementiaDiseaseRecuperationDiscountRate().getText());
    if(reductRate > 100){
    	// 100�𒴂���l�����͂���Ă����ꍇ
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
    	getShortStayDementiaDiseaseRecuperationDiscountRate().requestFocus();
	    return false;    	
    }   
    
    // ���L�̃��W�I�O���[�v�ɑ΂��đI���`�F�b�N���s���B���I���������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
    // �EshortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio�i�{�݋敪���W�I�O���[�v�j�@��errMsg = �{�݋敪
    if(!getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio().isSelected()){
    	errMsg = "�{�݋敪";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio().requestFocus();
        return false;
    }
        
    // �EshortStayDementiaDiseaseRecuperationStaffAssignmentDivision�i�l���z�u�敪���W�I�O���[�v�j�@��errMsg = �l���z�u�敪
    if(!getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision().isSelected()){
    	errMsg = "�l���z�u�敪";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision().requestFocus();
        return false;
    }
        
    // �EshortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem�i���}�̐����W�I�O���[�v�j�@��errMsg = ���}�̐�
    if(!getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem().isSelected()){
    	errMsg = "���}�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem().requestFocus();
        return false;
    }
        
    // �EshortStayDementiaDiseaseRecuperationNutritionManageRadio�i�h�{�Ǘ��̐����W�I�O���[�v�j�@��errMsg = �h�{�Ǘ��̐�
    if(!getShortStayDementiaDiseaseRecuperationNutritionManageRadio().isSelected()){
    	errMsg = "�h�{�Ǘ��̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayDementiaDiseaseRecuperationNutritionManageRadio().requestFocus();
        return false;
    }
        
    // �EshortStayDementiaDiseaseRecuperationRecuperateDinnerRadio�i�×{�H�̐����W�I�O���[�v�j�@��errMsg = �×{�H�̐�
    if(!getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio().isSelected()){
    	errMsg = "�×{�H�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio().requestFocus();
        return false;
    }
    
    // �EshortStayDementiaDiseaseRecuperationStaffReduce�i�l�����Z�R���{�j�@��errMsg = �l�����Z
    if(!getShortStayDementiaDiseaseRecuperationStaffReduce().isSelected()){
    	errMsg = "�l�����Z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayDementiaDiseaseRecuperationStaffReduce().requestFocus();
        return false;
    }

    // �EshortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney�i�H���z����j
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney�i�H���z�E���j
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareCognitiveNightDinnerStandeirdMoney�i�H���z�E��j
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText�@�� errMsg = ���j�b�g�^����z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText().getText())){
    	errMsg = "���j�b�g�^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText�@�� errMsg = ���j�b�g�^������z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText().getText())){
    	errMsg = " ���j�b�g�^������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText�@�� errMsg = �]���^����z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText().getText())){
    	errMsg = " �]���^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // �EshortStayRecuperateCareCognitiveTasyouRoomText�@�� errMsg = ��������z
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveTasyouRoomText().getText())){
    	errMsg = " ��������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareCognitiveTasyouRoomText().requestFocus();
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
