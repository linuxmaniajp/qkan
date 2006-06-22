
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
 * �v���O���� �F�m�ǑΉ��^�ʏ���� (QO004124)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo004;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �F�m�ǑΉ��^�ʏ����(QO004124) 
 */
public class QO004124 extends QO004124Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004124(){
  }

  //�R���|�[�l���g�C�x���g

//  /**
//   * �u��ʏ�Ԑݒ�v�C�x���g�ł��B
//   * @param e �C�x���g���
//   * @throws Exception ������O
//   */
//  protected void facilitiesDivisionSelectionChanged(ListSelectionEvent e)
//			throws Exception {
//		// ��ʏ�Ԑݒ�
//		setState();
//	}

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QO004124.class.getName(), param));
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
	// �{�݋敪�̏����l�Ƃ��āA�u�T�^�v��I������B
	// �敪�̏����l�Ƃ��āA�u�P�ƌ^�v��I������B
	// �h�{�}�l�W�����g�̐��̏����l�Ƃ��āA�u�Ȃ��v��I������B
	// ���o�@�\����̐��̏����l�Ƃ��āA�u�Ȃ��v��I������B
	// �l�����Z�̏����l�Ƃ��āA�u�Ȃ��v��I������B

	getReduceRate().setText("0");
//	getFacilitiesDivision().setSelectedIndex(1);
//	getFacilitiesDivision2().setSelectedIndex(1);
//	getFunctionTrainingGuidanceSystem().setSelectedIndex(1);
//	getBathingHelpSystem().setSelectedIndex(1);
//	getNourishmentManagementAdd().setSelectedIndex(1);
//	getMouthImprovementAdd().setSelectedIndex(1);
//	getStaffLack().setSelectedIndex(1);
	QkanCommon.selectFirstRadioItem(getMainGroup());
	
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
    // ��errMsg = �{�݋敪1
    if(!getFacilitiesDivision().isSelected()){
    	errMsg = "�{�݋敪1";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getFacilitiesDivision().requestFocus();
    	return false;
    }
    
//    // �EfacilitiesDivision2�i�敪���W�I�O���[�v�j
//    // ��errMsg = �{�݋敪2
//    if(getFacilitiesDivision2().isEnabled()){
//	    if(!getFacilitiesDivision2().isSelected()){
//	    	errMsg = "�{�݋敪2";
//	    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
//	    	getFacilitiesDivision2().requestFocus();
//	    	return false;
//	    }
//    }

    // �EfunctionTrainingGuidanceSystem�i�ʋ@�\�P���w���̐����W�I�O���[�v�j
    // ��errMsg = �ʋ@�\�P���w���̐�
    if(!getFunctionTrainingGuidanceSystem().isSelected()){
    	errMsg = "�ʋ@�\�P���w���̐�";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getFunctionTrainingGuidanceSystem().requestFocus();
    	return false;
    }

    // �EbathingHelpSystem�i������̐����W�I�O���[�v�j
    // ��errMsg = ������̐�
    if(!getBathingHelpSystem().isSelected()){
    	errMsg = "������̐�";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getBathingHelpSystem().requestFocus();
    	return false;
    }
    
    // �EnourishmentManagementAdd�i�h�{�}�l�W�����g�̐����W�I�O���[�v�j
    // ��errMsg = �h�{�}�l�W�����g�̐�
    if(!getNourishmentManagementAdd().isSelected()){
    	errMsg = "�h�{�}�l�W�����g�̐�";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getNourishmentManagementAdd().requestFocus();
    	return false;
    }
    
    // �EmouthImprovementAdd�i���o�@�\����̐����W�I�O���[�v�j
    // ��errMsg = ���o�@�\����̐�
    if(!getMouthImprovementAdd().isSelected()){
    	errMsg = "���o�@�\����̐�";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getMouthImprovementAdd().requestFocus();
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
	  // �EfacilitiesDivision2�@�폜KEY�F1720102
//	  if(!getFacilitiesDivision2().isEnabled()){
//		  map.removeData("1720102");
//	  }

  }

  /**
   * �u��Ԑ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  public void setState() throws Exception {
	  
	  // ��ʂ̏�Ԃ𐧌䂷��B
//	  setStateByFacilitiesDivision();
	  
  }
 
}
