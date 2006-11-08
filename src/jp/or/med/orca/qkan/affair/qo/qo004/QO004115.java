
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
 * �v���O���� ����{�ݓ����҉�� (QO004115)
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
 * ����{�ݓ����҉��(QO004115) 
 */
public class QO004115 extends QO004115Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004115(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u��ʏ�Ԑݒ�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void staffAssignmentDivisionSelectionChanged(ListSelectionEvent e)
			throws Exception {
		// ��ʏ�Ԑݒ�
		setState();
	}

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QO004115.class.getName(), param));
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
	// �{�݋敪�̏����l�Ƃ��āA�u����{�ݓ����ҁv��I������B
	// �ʋ@�\�P���w���̐��̏����l�Ƃ��āA�u�Ȃ��v��I������B
	// ��ԊŌ�̐��̏����l�Ƃ��āA�u�Ȃ��v��I������B
	// �l�����Z�̏����l�Ƃ��āA�u�Ȃ��v��I������B

	getReduceRate().setText("0");
	getFacilitiesDivision().setSelectedIndex(1);
	getStaffAssignmentDivision().setSelectedIndex(1);
	getFunctionTrainingGuidanceSystem().setSelectedIndex(1);
	getNightNursingSystemAdd().setSelectedIndex(1);
	getStaffLack().setSelectedIndex(1);

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
    // �EfacilitiesDivision�i�{�݋敪���W�I�O���[�v�j
    // �� errMsg = �{�݋敪
    if(!getFacilitiesDivision().isSelected()){
    	errMsg = "�{�݋敪";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getFacilitiesDivision().requestFocus();
    	return false;
    }
    
    // �EfunctionTrainingGuidanceSystem�i�ʋ@�\�P���w���̐����W�I�O���[�v�j
    // �� errMsg = �ʋ@�\�P���w���̐�
    if(!getFunctionTrainingGuidanceSystem().isSelected()){
    	errMsg = "�ʋ@�\�P���w���̐�";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getFunctionTrainingGuidanceSystem().requestFocus();
    	return false;
    }
    
    // �EnightNursingSystemAdd�i��ԊŌ�̐����W�I�O���[�v�j
    // �� errMsg = ��ԊŌ�̐�
    if(!getNightNursingSystemAdd().isSelected()){
    	errMsg = "��ԊŌ�̐�";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getNightNursingSystemAdd().requestFocus();
    	return false;
    }
    
    // �EstaffLack�i�l�����Z���W�I�O���[�v�j
    // ��errMsg = �l�����Z
    if(!getStaffLack().isSelected()){
    	errMsg = "�l�����Z";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getStaffLack().requestFocus();
    	return false;
    }

    // ���L�̃e�L�X�g�t�B�[���h�ɑ΂��ē��̓`�F�b�N���s���B�����͂������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
    // �EreduceRate�i�������e�L�X�g�j�� errMsg = ������
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
	  // �EfunctionTrainingGuidanceSystem �폜KEY�F1330101
	  // �EnightNursingSystemAdd �폜KEY�F1330104
	  // �EstaffLack �폜KEY�F1330102
	  if(!getFunctionTrainingGuidanceSystem().isEnabled()){
		  map.removeData("1330101");
	  }
	  if(!getNightNursingSystemAdd().isEnabled()){
		  map.removeData("1330104");
	  }
//	  if(!getStaffLack().isEnabled()){
//		  map.removeData("1330102");
//	  }
	  	  
  }

  /**
   * �u��Ԑ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  public void setState() throws Exception {
	  
	  // ��ʂ̏�Ԃ𐧌䂷��B
	  setStateByStaffAssignmentDivision();
	  
  }
  
  /**
   * �u�l���z�u�敪�敪�ɂ���Ԑ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  public void setStateByStaffAssignmentDivision() throws Exception {

		// �l���z�u�敪�敪�̒l���`�F�b�N����B
		if (getStaffAssignmentDivision().getSelectedIndex() == STAFF_ASSIGNMENT_NORMAL) {
			// �u��ʌ^�v���I�����ꂽ�ꍇ
			setState_STAFF_ASSIGNMENT_TYPE_NORMAL();			
		} else {
			// �u����{�ݓ����ҁv�ȊO���I�����ꂽ�ꍇ
			setState_STAFF_ASSIGNMENT_TYPE_OUTSIDE_SERVICE();
		}
	}

}
