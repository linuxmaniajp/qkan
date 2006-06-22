
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
 * �v���O���� ���V�l�ی��{�� (QO004009)
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
 * ���V�l�ی��{��(QO004009) 
 */
public class QO004009 extends QO004009Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004009(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�Z�������×{���i���V�l�ی��{�݁j�H���z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayCareOldPersonMorningDinnerStandardMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i���V�l�ی��{�݁j�H���z���v�\������
    // �@�Z�������×{���i���V�l�ی��{�݁j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
	  dinnerStandeirdMoneyTotal();

  }

  /**
   * �u�Z�������×{���i���V�l�ی��{�݁j�H���z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayCareOldPersonNoonDinnerStandardMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i���V�l�ی��{�݁j�H���z���v�\������
    // �@�Z�������×{���i���V�l�ی��{�݁j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
	  dinnerStandeirdMoneyTotal();

  }

  /**
   * �u�Z�������×{���i���V�l�ی��{�݁j�H���z���v�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayCareOldPersonNightDinnerStandardMoneyFocusLost(FocusEvent e) throws Exception{
    // �Z�������×{���i���V�l�ی��{�݁j�H���z���v�\������
    // �@�Z�������×{���i���V�l�ی��{�݁j�H���z�����v�����ʂ����v�e�L�X�g�t�B�[���h�ɑ������
	  dinnerStandeirdMoneyTotal();

  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QO004009.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�Z�������×{���i���V�l�ی��{�݁j�H���z���v�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // �Z�������×{���i���V�l�ی��{�݁j�H���z���v����
    // ���L�̃e�L�X�g�t�B�[���h�̓��͂���Ă���l�����v����B
	// shortStayCareOldPersonDinnerStandarTotal�i�H���z�E���v�e�L�X�g�t�B�[���h�j�ɒl��������B
	// �EshortStayCareOldPersonMorningDinnerStandardMoney(�H���z�E���E�e�L�X�g)
	// �EshortStayCareOldPersonNoonDinnerStandardMoney(�H���z�E���E�e�L�X�g)
	// �EshortStayCareOldPersonNightDinnerStandardMoney(�H���z�E��E�e�L�X�g)
    int valMorning = 0;
    int valNoon = 0;
    int valNight = 0;
	
    if(!ACTextUtilities.isNullText(getShortStayCareOldPersonMorningDinnerStandardMoney().getText())){
    	valMorning = ACCastUtilities.toInt(getShortStayCareOldPersonMorningDinnerStandardMoney().getText());
    }
    if(!ACTextUtilities.isNullText(getShortStayCareOldPersonNoonDinnerStandardMoney().getText())){
    	valNoon = ACCastUtilities.toInt(getShortStayCareOldPersonNoonDinnerStandardMoney().getText());
    }
    if(!ACTextUtilities.isNullText(getShortStayCareOldPersonNightDinnerStandardMoney().getText())){
    	valNight = ACCastUtilities.toInt(getShortStayCareOldPersonNightDinnerStandardMoney().getText());
    }
    
    int valTotal = valMorning + valNoon + valNight;
    
    if(valTotal == 0){
    	getShortStayCareOldPersonDinnerStandarTotal().setText("");
    }else{
    	getShortStayCareOldPersonDinnerStandarTotal().setText(ACCastUtilities.toString(valTotal));
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
	getShortStayCareOldPersonDiscountText().setText("0");
	  
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
    // �EshortStayCareOldPersonDiscountText�i�������e�L�X�g�j�@��errMsg = ������
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonDiscountText().getText())){
    	errMsg = "������";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonDiscountText().requestFocus();
    	return false;
    }

    // �������̒l���`�F�b�N����B
    int reductRate = ACCastUtilities.toInt(getShortStayCareOldPersonDiscountText().getText());
    if(reductRate > 100){
    	// 100�𒴂���l�����͂���Ă����ꍇ
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
    	getShortStayCareOldPersonDiscountText().requestFocus();
	    return false;    	
    }   
    
    // ���L�̃��W�I�O���[�v�ɑ΂��đI���`�F�b�N���s���B���I���������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
    // �EshortStayCareOldPersonInstitutionDivisionRadio�i�{�݋敪���W�I�O���[�v�j�@��errMsg = �{�݋敪
    if(!getShortStayCareOldPersonInstitutionDivisionRadio().isSelected()){
    	errMsg = "�{�݋敪";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonInstitutionDivisionRadio().requestFocus();
        return false;
    }
    
    // �EshortStayCareOldPersonNightWorkDivisionRadio�i��ԋΖ���������W�I�O���[�v�j�@��errMsg = ��ԋΖ������
    if(!getShortStayCareOldPersonNightWorkDivisionRadio().isSelected()){
    	errMsg = "��ԋΖ������";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonNightWorkDivisionRadio().requestFocus();
        return false;
    }
    
    // �EshortStayCareOldPersonRehabilitationRadio�i���n�r���e�[�V�����@�\�������W�I�O���[�v�j�@��errMsg = ���n�r���@�\�����̐�
    if(!getShortStayCareOldPersonRehabilitationRadio().isSelected()){
    	errMsg = "���n�r���@�\�����̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonRehabilitationRadio().requestFocus();
        return false;
    }
    
    // �EshortStayCareOldPersonCognitiveRadio�i�F�m�ǐ�哏���W�I�O���[�v�j�@��errMsg = �F�m�ǐ�哏
    if(!getShortStayCareOldPersonCognitiveRadio().isSelected()){
    	errMsg = "�F�m�ǐ�哏";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonCognitiveRadio().requestFocus();
        return false;
    }
    
    // �EshortStayCareOldPersonMeetingAndSendingRadio�i���}�̐����W�I�O���[�v�j�@��errMsg = ���}�̐�
    if(!getShortStayCareOldPersonMeetingAndSendingRadio().isSelected()){
    	errMsg = "���}�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonMeetingAndSendingRadio().requestFocus();
        return false;
    }
    
    // �EshortStayCareOldPersonRecuperationNutritionManageRadio�i�h�{�Ǘ��̐����W�I�O���[�v�j�@��errMsg = �h�{�Ǘ��̐�
    if(!getShortStayCareOldPersonRecuperationNutritionManageRadio().isSelected()){
    	errMsg = "�h�{�Ǘ��̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonRecuperationNutritionManageRadio().requestFocus();
        return false;
    }
    
    // �EshortStayCareOldPersonRecuperationRadio�i�×{�H�̐����W�I�O���[�v�j�@��errMsg = �×{�H�̐�
    if(!getShortStayCareOldPersonRecuperationRadio().isSelected()){
    	errMsg = "�×{�H�̐�";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonRecuperationRadio().requestFocus();
        return false;
    }
    
    // �EshortStayCareOldPersonStaffReduceRadio�i�l�����Z�j�@��errMsg = �l�����Z
    if(!getShortStayCareOldPersonStaffReduceRadio().isSelected()){
    	errMsg = "�l�����Z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonStaffReduceRadio().requestFocus();
        return false;
    }

    // �EshortStayCareOldPersonMorningDinnerStandardMoney�i�H���z�E���e�L�X�g�j�@��errMsg = �H���z
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonMorningDinnerStandardMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonMorningDinnerStandardMoney().requestFocus();
    	return false;
    }
    
    // �EshortStayCareOldPersonNoonDinnerStandardMoney�i�H���z�E���e�L�X�g�j�@��errMsg = �H���z
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonNoonDinnerStandardMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonNoonDinnerStandardMoney().requestFocus();
    	return false;
    }
    
    // �EshortStayCareOldPersonNightDinnerStandardMoney�i�H���z�E��e�L�X�g�j�@��errMsg = �H���z
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonNightDinnerStandardMoney().getText())){
    	errMsg = "�H���z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonNightDinnerStandardMoney().requestFocus();
    	return false;
    }
    
    // �EshortStayCareOldPersonUnitRoomText�@�� errMsg = ���j�b�g�^����z
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonUnitRoomText().getText())){
    	errMsg = "���j�b�g�^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonUnitRoomText().requestFocus();
    	return false;
    }
    
    // �EshortStayCareOldPersonUnitSemiRoomText�@�� errMsg = ���j�b�g�^������z
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonUnitSemiRoomText().getText())){
    	errMsg = "���j�b�g�^������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonUnitSemiRoomText().requestFocus();
    	return false;
    }
    
    // �EshortStayCareOldPersonNormalRoomText�@�� errMsg = �]���^����z
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonNormalRoomText().getText())){
    	errMsg = "�]���^����z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonNormalRoomText().requestFocus();
    	return false;
    }
    
    // �EshortStayCareOldPersonTasyouRoomText�@�� errMsg = ��������z
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonTasyouRoomText().getText())){
    	errMsg = "��������z";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonTasyouRoomText().requestFocus();
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
