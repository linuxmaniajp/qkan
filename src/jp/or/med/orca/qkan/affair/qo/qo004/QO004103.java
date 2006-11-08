
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
 * �v���O���� �K��Ō� (QO004103)
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
 * �K��Ō�(QO004103) 
 */
public class QO004103 extends QO004103Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004103(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�K��Ō�p�l��Enable����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void facilitiesDivisionSelectionChanged(ListSelectionEvent e) throws Exception{
    // ���K��Ō�p�l����Enable������s���B
	  setState();
	  
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QO004103.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
    // ��������
    // �������l�ݒ�
    // �������e�L�X�g�ɏ����l0��������B
	// �{�݋敪���W�I�̏����l�Ƃ��āu�K��Ō�X�e�[�V�����v��I������B
	// �ً}���K��Ō�̐����W�I�̏����l�Ƃ��āu�Ȃ��v��I������B
	// ���ʊǗ��̐����W�I�̏����l�Ƃ��āu�Ȃ��v��I������B
	getReduceRate().setText("0");
	getFacilitiesDivision().setSelectedIndex(FACILITY_TYPE_STATION);
	getHomonkangoPressing().setSelectedIndex(1);
	getSpecialManagementSystem().setSelectedIndex(1);
	getTerminalCare().setSelectedIndex(1);
	getContactAllDay().setSelectedIndex(1);
	getSeriousCaseManagement().setSelectedIndex(1);
	
  }

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public boolean isValidInput() throws Exception{
    // �����̓`�F�b�N
    // �G���[���b�Z�[�W�����i�[�p�� errMsg�@���쐬����B
    String errMsg = null;
    
    // ���L�̃��W�I�O���[�v�ɑ΂��đI���`�F�b�N���s���B���I���������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
    // �EfacilitiesDivision�i�{�݋敪���W�I�O���[�v�j�� errMsg = �{�݋敪
    if(!getFacilitiesDivision().isSelected()){
    	errMsg = "�{�݋敪";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getFacilitiesDivision().requestFocus();
    	return false;
    }
    
    // �EhomonkangoPressing�i�ً}���K��Ō���Z�̐����W�I�O���[�v�j�� errMsg = �ً}���K��Ō�̐�
    if(!getHomonkangoPressing().isSelected()){
    	errMsg = "�ً}���K��Ō�̐�";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getHomonkangoPressing().requestFocus();
    	return false;
    }
    
    // �EspecialManagementSystem�i���ʊǗ��̐����W�I�O���[�v�j�� errMsg = ���ʊǗ��̐�
    if(!getSpecialManagementSystem().isSelected()){
    	errMsg = "���ʊǗ��̐�";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getSpecialManagementSystem().requestFocus();
    	return false;
    }

    // �EmanagerName�i�Ǘ��Ҏ����j��errMsg = �Ǘ��Ҏ���
    if(ACTextUtilities.isNullText(getManagerName().getText())){
    	errMsg = "�Ǘ��Ҏ���";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getManagerName().requestFocus();
    	return false;
    }
    
//    // �{�݋敪�̒l��FACILITY_TYPE_STATION�̏ꍇ�̂�
//    // �EstationCode�i�X�e�[�V�����R�[�h�j��errMsg = �X�e�[�V�����R�[�h�@
//    if(getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_STATION){
//    	if(ACTextUtilities.isNullText(getStationCode().getText())){
//        	errMsg = "�X�e�[�V�����R�[�h";
//            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//            getStationCode().requestFocus();
//        	return false;    		
//    	}
//    }

    // ���L�̃e�L�X�g�t�B�[���h�ɑ΂��ē��̓`�F�b�N���s���B�����͂������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
    // �EreduceRate�i�������e�L�X�g�j��errMsg = ������
    if(ACTextUtilities.isNullText(getReduceRate().getText())){
    	errMsg = "������";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
    	getReduceRate().requestFocus();
    	return false;
    }

    // �������̒l���`�F�b�N����B
    int reduceRate = ACCastUtilities.toInt(getReduceRate().getText());
    if(reduceRate > 100){
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
	 * @throws Exception ������O
	 */
  public void stateManager(boolean state) throws Exception {
	// ���p�l����Ԑ���
	if (state) {
		// �����Ƃ���true���n���ꂽ�ꍇ
		// ���ID�FSET_PANEL_TRUE
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
	  // �EstationCode�@�@�폜KEY�F2010101
	  if(!getStationCode().isEnabled()){
		  map.removeData("2010101");
	  }
	  
	  // 24���ԘA���̐����Z
	  if(!getContactAllDay().isEnabled()){
		  map.removeData("2010102");
	  }
	  
	  // �d�ǎҊǗ����Z
	  if(!getSeriousCaseManagement().isEnabled()){
		  map.removeData("2010103");
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
	  
  }
  
  /**
   * �u�{�݋敪�ɂ���Ԑ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  public void setStateByFacilitiesDivision() throws Exception{

    // facilitiesDivision�i�{�݋敪���W�I�j�̒l���`�F�b�N����B
	if (getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_STATION) {
		// �l��FACILITY_TYPE_STATION�i�K��Ō�X�e�[�V�����j�������ꍇ
		// ��ʏ�Ԃ�ύX����B��Enable������s���ҏW�\�ɂ���B
		setState_MEDICAL_INSURE_TRUE();
	} else if (getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_HOSPITAL) {
		// �l��FACILITY_TYPE_HOSPITAL�i�a�@���͐f�Ï��j�������ꍇ
		// ��ʏ�Ԃ�ύX����B��Enable������s���ҏW�s�\�ɂ���B
		setState_MEDICAL_INSURE_FALSE();
	}

  }
}
