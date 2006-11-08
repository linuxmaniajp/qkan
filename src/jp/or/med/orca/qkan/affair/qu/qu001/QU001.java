
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
 * �J����: �� ����
 * �쐬��: 2005/12/15  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�҈ꗗ (001)
 * �v���O���� ���p�҈ꗗ (QU001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qu.qu001;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACHashMapFormat;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qc.qc001.QC001;
import jp.or.med.orca.qkan.affair.qc.qc002.QC002;
import jp.or.med.orca.qkan.affair.qc.qc003.QC003;
import jp.or.med.orca.qkan.affair.qc.qc004.QC004;
import jp.or.med.orca.qkan.affair.qc.qc005.QC005;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001;
import jp.or.med.orca.qkan.affair.qu.qu002.QU002;

/**
 * ���p�҈ꗗ(QU001) 
 */
public class QU001 extends QU001Event {

  /**
   * �R���X�g���N�^�ł��B
   */
  public QU001(){
  }
  
  public void initAffair(ACAffairInfo affair) throws Exception  {
    super.initAffair(affair);
    initAction(affair);  
  }
  
  /**
   * �������������s�Ȃ��܂��B
   * @param affair �Ɩ����
   * @throws Exception ������O
   */
  protected void initAction(ACAffairInfo affair) throws Exception {
    
    // �n��p�����[�^��ޔ�����B
    // this.nextAffair = NEXT_AFFAIR (���ɑJ�ڂ���Ɩ�ID)
    VRMap param = affair.getParameters();
    
    // �f�[�^�����݂��Ă��邩�`�F�b�N����B
    // NEXT_AFFAIR�̑ޔ�
    if(VRBindPathParser.has("NEXT_AFFAIR", param)){
    	setNextAffair(ACCastUtilities.toString(VRBindPathParser.get("NEXT_AFFAIR", param)));
    }
    
    // �f�[�^�����݂��Ă��邩�`�F�b�N����B
    // PATIENT_ID�̑ޔ�
    if(VRBindPathParser.has("PATIENT_ID", param)){
    	setPatientId(ACCastUtilities.toInt(
    			VRBindPathParser.get("PATIENT_ID", param)));
    }
    
    // �f�[�^�����݂��Ă��邩�`�F�b�N����B
    // TARGET_DATE�̑ޔ�
    if(VRBindPathParser.has("TARGET_DATE", param)){
    	setFindTargetDate((Date)VRBindPathParser.get("TARGET_DATE", param));
    }
    
    // �n��p�����[�^�̍폜
    param.clear();
    
  	// ���������s���B
    initialize();

    // �e�[�u�����f�����`����B
    ACTableModelAdapter model = new ACTableModelAdapter();

    model.setColumns(new String[]{
    		"SHOW_FLAG",
			"PATIENT_CODE",
			"PATIENT_FAMILY_NAME+'�@'+PATIENT_FIRST_NAME",
			"PATIENT_FAMILY_KANA+'�@'+PATIENT_FIRST_KANA",
			"PATIENT_SEX",
			"PATIENT_BIRTHDAY",
			"PATIENT_ZIP_FIRST+'-'+PATIENT_ZIP_SECOND",
			"PATIENT_ADDRESS",
			"PATIENT_TEL_FIRST+'-'+PATIENT_TEL_SECOND+'-'+PATIENT_TEL_THIRD",
			"PATIENT_FAMILY_NAME",
			"PATIENT_FIRST_NAME",
			"PATIENT_FAMILY_KANA",
			"PATIENT_FIRST_KANA",
			"PATIENT_ZIP_FIRST",
			"PATIENT_ZIP_SECOND",
			"PATIENT_TEL_FIRST",
			"PATIENT_TEL_SECOND",
			"PATIENT_TEL_THIRD",
    });
    
    setPatientTableModel(model);
    
    // �A�_�v�^���e�[�u���̃��f���Ƃ��Đݒ肷��B
    getPatients().setModel(getPatientTableModel());
 
    // �e�[�u���J�����Ƀt�H�[�}�b�^��ݒ肷��B
		getPatientEnabledColumn().setFormat(
				new ACHashMapFormat(new String[] {
						"jp/nichicom/ac/images/icon/pix16/btn_080.png",
						"jp/nichicom/ac/images/icon/pix16/btn_079.png" },
						new Integer[] { new Integer(0), new Integer(1), }));
  
    // �������s���B
    doFind();
    
  }

  public boolean canBack(VRMap parameters) throws Exception {
    if(!super.canBack(parameters)){
      return false;
    }
    
    // �O��ʂɖ߂�B
    // �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
    return true;
  }

  public boolean canClose() throws Exception {
    if(!super.canClose()){
      return false;
    }
    
    // �V�X�e�����I������B
    // �I����������Ȃ��true��Ԃ��B
    return true;
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void findActionPerformed(ActionEvent e) throws Exception{
    // �������s���B
    doFind();
  }

  /**
   * �u�ڍ׉�ʂɑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void detailActionPerformed(ActionEvent e) throws Exception{
  	
    //PATIENT_ID���i�[����patientId���`����B
  	int patientId;
    
    // �����̓`�F�b�N
    // ���̓`�F�b�N���s���B
  	if(!checkValue()){
  		return;
  	}
  	
    // ��ʂ́u���p�҈ꗗ(patients)�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
    if(!getPatients().isSelected()){
    	// �I������Ă��Ȃ��ꍇ
    	// �������Ȃ��B
    	return;
    }else{
	    // �I������Ă���ꍇ
	    // �I������Ă��闘�p�҂́u���p��ID(PATIENT_ID)�v���擾����B
    	patientId = ACCastUtilities.toInt(
    			VRBindPathParser.get("PATIENT_ID", (VRMap)getPatients().getSelectedModelRowValue()));
    	
    }
    
    // ����ʂɑJ�ڂ���B
    transferNext(patientId);
  }

  /**
   * �u�ڍ׉�ʂɑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void insertActionPerformed(ActionEvent e) throws Exception{
    // ������ʂɑJ��
  	
    // ����ʂւ̓n��p�����[�^�i�[�p�Ƀ��R�[�h param�𐶐�����B
    VRMap param = new VRHashMap();    

    // ����ʑJ�ڂ̂��߂̃p�����[�^ ACAffairInfo affair ���`����B
    ACAffairInfo affair = null;
  	
    if("QU002".equals(getNextAffair())){
	    // �uQU002�v�̏ꍇ
    	
	    // param�ɉ��L�p�����[�^��ݒ肷��B
	    // KEY : PROCESS_MODE, VALUE : PROCESS_MODE_INSERT
	    VRBindPathParser.set("PROCESS_MODE", param, new Integer(QkanConstants.PROCESS_MODE_INSERT));
	        	
	    // ���L�p�����[�^�ɂ�affair�𐶐�����B
	    affair = new ACAffairInfo(QU002.class.getName(), param);
	    
    }
    
	//NEXT_AFFAIR����ʑJ�ڑO�Ƀt���[���ɑޔ����Ă����B
	ACFrame.getInstance().addNowAffairParameter("NEXT_AFFAIR", getNextAffair());
    
    // ���n�菈��
    // ����ʂɑJ�ڂ���B
    ACFrame.getInstance().next(affair);

  }

  /**
   * �u�T�[�r�X�\��ɑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void planInsertActionPerformed(ActionEvent e) throws Exception {
		// ���T�[�r�X�\��ɑJ��

		// PATIENT_ID���i�[����patientId���`����B
		int patientId;

		// ������ʂɓn���l�̎擾
		// ���̓`�F�b�N���s���B
		if (!checkValue()) {
			return;
		}

		// ��ʂ́u���p�҈ꗗ(patients)�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
		if (!getPatients().isSelected()) {
			// �I������Ă��Ȃ��ꍇ

			// �����𒆒f����B
			return;

		} else {
			// �I������Ă���ꍇ

			// �I������Ă��闘�p�҂́u���p��ID(PATIENT_ID)�v���擾����B
			patientId = ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", (VRMap) getPatients()
							.getSelectedModelRowValue()));

		}

		if (!checkInsureInfo(patientId)) {
			// ���p�҂̗v�������`�F�b�N����B
			return;
		}

		// ����ʂɑJ�ڂ���B
		transferNext(patientId);

	}

  /**
	 * �u�T�[�r�X���тɑJ�ځv�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
  protected void resultInsertActionPerformed(ActionEvent e) throws Exception{
    // ���T�[�r�X���тɑJ��
    
    // PATIENT_ID���i�[����patientId���`����B
    int patientId;
    
    // ���̓`�F�b�N���s���B
    if(!checkValue()){
    	return;
    }

    // ��ʂ́u���p�҈ꗗ(patients)�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
    if(!getPatients().isSelected()){
	    // �I������Ă��Ȃ��ꍇ
    	
	    // �����𒆒f����B
    	return;
    	
    }else{
	    // �I������Ă���ꍇ
    	
    	// �I������Ă��闘�p�҂́u���p��ID(PATIENT_ID)�v���擾����B
    	patientId = ACCastUtilities.toInt(VRBindPathParser
    			.get("PATIENT_ID", (VRMap)getPatients().getSelectedModelRowValue()));
    	
    }
    
    // ���p�҂̗v�������`�F�b�N����B
    if(!checkInsureInfo(patientId)){
    	return;
    } 
    
    // ����ʂɑJ�ڂ���B
    transferNext(patientId);

  }

  /**
   * �u���p�ҍ폜�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void deleteActionPerformed(ActionEvent e) throws Exception{
    // ����ʂőI�����ꂽ���p�҂̍폜
    
  	// �I������Ă��郌�R�[�h�̃��f���̃C���f�b�N�X���i�[����modelRow���`����B
  	int modelRow;
  	
  	// �I������Ă��郌�R�[�h�̉�ʏ�̃C���f�b�N�X���i�[����sortedRow���`����B
  	int sortedRow;
  	
  	// �����̓`�F�b�N
    // ��ʂ́u���p�҈ꗗ(patients)�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
  	if(!getPatients().isSelected()){
  	    // �I������Ă��Ȃ��ꍇ
  		
  	    // �����𒆒f����B
  		return;
  	
  	}else{
  		// �I������Ă���ꍇ
  		
  		// �I���s�̃C���f�b�N�X(���f���ł͂Ȃ���ʏ�)���擾����B
  		modelRow = getPatients().getSelectedModelRow();
  		sortedRow = getPatients().getSelectedSortedRow();
  	}
  	
  	// �������m�F
    // �폜�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_DELETE
    if(QkanMessageList.getInstance().
    		WARNING_OF_DELETE("�I�𒆂̗��p�ҏ��") == ACMessageBox.RESULT_CANCEL){
	    // �u�L�����Z���v��I�������ꍇ(�폜���f)
	    // �����𒆒f����B
    	return;    	
    }
    
    try{
    	
    	// �g�����U�N�V�����J�n
    	getDBManager().beginTransaction();
    	
	    // ���p�b�V�u�`�F�b�N
	    // �p�b�V�u�^�X�N���N���A����B
	    getPassiveChecker().clearPassiveTask();
	    
	    // �p�b�V�u�^�X�N��o�^����B
	    getPassiveChecker().addPassiveUpdateTask(getPASSIVE_CHECK_KEY(), modelRow);    
	
	    // �p�b�V�u�`�F�b�N�����s����B
	    if(!(getPassiveChecker().passiveCheck(getDBManager()))){
		    // �p�b�V�u�G���[������ꍇ
	    	
		    // �p�b�V�u�G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
		    QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
		    
		    // �g�����U�N�V��������
		    getDBManager().rollbackTransaction();
		    
		    // �����𒆒f����B(�ُ�I��)
		    return;
	    }
	    
	    // �p�b�V�u�G���[���Ȃ��ꍇ
	    // �����𑱍s����B
	    // ���폜
	    // �I���s�́u���p��ID(PATIENT_ID)�v���擾����B
	    int patientId = ACCastUtilities.toInt(
	    		VRBindPathParser.get("PATIENT_ID", (VRMap)getPatientData().get(modelRow)));
	    
	    // SQL���擾�֐��ɓn�����R�[�h sqlParam�𐶐�����B
	    VRMap sqlParam = new VRHashMap();
	    
	    // sqlParam�ɉ��L�̒l��ݒ肷��B
	    // KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
	    VRBindPathParser.set("PATIENT_ID", sqlParam, new Integer(patientId));
	    
	    // ���p�ҏ��폜�p��SQL�����擾����B
	    String strSql = getSQL_DELETE_PATIENT(sqlParam);
	    
	    // �擾����SQL���𔭍s����B
	    getDBManager().executeUpdate(strSql);
	    
	    // ��L��SQL���s�����ŃG���[���Ȃ������ꍇ
	    // �������R�~�b�g����B
	    getDBManager().commitTransaction();

	    // �Č������āA�ŐV�̃f�[�^���擾����B
	    doFind();
	    
	    // �폜�����s��1�s��̍s��I������B
	    getPatients().setSelectedSortedRowOnAfterDelete(sortedRow);
	    
//	    // ���������ʒm���b�Z�[�W��\������B�����b�Z�[�WID = DELETE_SUCCESSED
//	    QkanMessageList.getInstance().DELETE_SUCCESSED();
	       
    }catch(Exception ex){
        // �G���[���������ꍇ
        // ���������[���o�b�N����B
        // �����𒆒f����B(�ُ�I��)
    	getDBManager().rollbackTransaction();
    	
    	//��ʃN���X�ɗ�O��Ԃ��B
    	throw ex;
    }

  }

  /**
   * �u�Z���I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void patientsSelectionChanged(ListSelectionEvent e) throws Exception {
  	
  	// ��ʂ́u���p�҈ꗗ(patients)�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
    if(!getPatients().isSelected()){
    	//�I������Ă��Ȃ��ꍇ
    	
    	//�Ɩ��{�^���̏�Ԃ�ύX����B
    	 setState_UNSELECTED();
    	
    }else{
	    // �I������Ă���ꍇ
    	// �Ɩ��{�^���̏�Ԃ�ύX����B
    	 setState_SELECTED();
    	 
    }  	
  }
  
  /**
   * �u�_�u���N���b�N�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void patientsMouseClicked(MouseEvent e) throws Exception{
  	
    //PATIENT_ID���i�[����patientId���`����B
  	int patientId;
    
    // �����̓`�F�b�N
    // �@���̓`�F�b�N���s���B
  	if(!checkValue()){
  		return;
  	}
  	
    // ��ʂ́u���p�҈ꗗ(patients)�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
    if(!getPatients().isSelected()){
    	// �I������Ă��Ȃ��ꍇ
    	// �������Ȃ��B
    	return;
    }else{
	    // �I������Ă���ꍇ
	    // �I������Ă��闘�p�҂́u���p��ID(PATIENT_ID)�v���擾����B
    	patientId = ACCastUtilities.toInt(VRBindPathParser
    			.get("PATIENT_ID", (VRMap)getPatients().getSelectedModelRowValue()));
    }
    
    if("QS001".equals(getNextAffair()) || "QR001".equals(getNextAffair())){
	    // �\��E���щ�ʂ֑J�ڂ���ꍇ
    	// ���p�҂̗v�������`�F�b�N����B
	    if(!checkInsureInfo(patientId)){
	    	return;
	    }
    }
    
    // ����ʂɑJ�ڂ���B
    transferNext(patientId);
  	  	
  }
  
  
  /**
   * �u���p�҈ꗗ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void printActionPerformed(ActionEvent e) throws Exception{
    // �����p�҈ꗗ�̈��
    
  	// ���O����
    // ����N���X�ɓn�����R�[�h printParam�𐶐�����B
    VRMap printParam = new VRHashMap();
    
    // ���n���p�����[�^�̎擾
    // patientData�̌��������[�v����B
    for(int i = 0; i < getPatientData().size(); i++){   
    
	    // PATIENT_ID�i�[�p�ϐ����`����B
    	int patientId;
    	// ���p�ҏ��i�[�pMap���`����B
    	VRMap patientMap = new VRHashMap();
    	// �v����i�[�pList���`����B
    	VRList patientInsureList;
    	// ���Ə����i�[�pMap���`����B
    	VRMap providerMap = new VRHashMap();
    	// SQL���i�[�pString���`����B
    	String strSql;
    	// sqlParam�̐���
	    VRMap sqlParam = new VRHashMap();	    
    	    	
    	// patientData��KEY : PATIENT_ID��VALUE���擾����(���p��ID)�B
	    patientMap = (VRMap)getPatientData().get(i);
	    patientId = ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID", patientMap));	
	   
	    // sqlParam�̐ݒ�
	    // ���p��ID�ǉ�
	    VRBindPathParser.set("PATIENT_ID", sqlParam, new Integer(patientId));
	    // ���ݓ��t�ǉ�
	    VRBindPathParser.set("NOW_DATE", sqlParam, new Date());
	    
	    // ���ݓ��t���_�̗v�������擾����B
	    // SQL���̎擾
	    strSql = getSQL_GET_NINTEI_NOW(sqlParam);
	    	
	    // SQL���̎��s
	    patientInsureList = getDBManager().executeQuery(strSql);
	    
	    // ���ݓ��t���_�̗v�����0���̏ꍇ
	    if(patientInsureList.size() == 0){
	    	
	    	// ���ݓ��t��薢���̗v�����̂������߂̏����擾����B
		    // SQL���̎擾
		    strSql = getSQL_GET_NINTEI_FUTURE(sqlParam);
		    	
		    // SQL���̎��s
		    patientInsureList = getDBManager().executeQuery(strSql);
		    
		    if(patientInsureList.size() == 0){
		    	
		    	// ���ݓ��t���ߋ��̗v�����̂������߂̏����擾����B
			    // SQL���̎擾
			    strSql = getSQL_GET_NINTEI_PAST(sqlParam);
			    	
			    // SQL���̎��s
			    patientInsureList = getDBManager().executeQuery(strSql);	    	
		    	
		    }	    	
	    }
	    
	    // �擾�����v�����1���ȏ�̏ꍇ
	    if(patientInsureList.size() > 0){
	    	
	    	//�v����񃌃R�[�h�����o���B
	    	VRMap map = (VRMap)patientInsureList.get(0);
	    	
	    	// ���p�ҏ��Ɉȉ��̒l��ǉ�����B
	    	// ��ی��Ҕԍ�
	    	VRBindPathParser.set("INSURED_ID", patientMap, VRBindPathParser.get("INSURED_ID", map));
	    	// �v���x
	    	VRBindPathParser.set("JOTAI_CODE", patientMap, VRBindPathParser.get("JOTAI_CODE", map));
	    	// �L�����ԏI��
	    	VRBindPathParser.set("INSURE_VALID_END", patientMap, VRBindPathParser.get("INSURE_VALID_END", map));
	    	
		    // ������x�����Ə�ID���擾����B
		    String providerId = ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID", map));
		    
		    if(!(providerId == null || "".equals(providerId))){
			    // ���Ə������擾����B
			    VRList providerList = (VRList)QkanCommon.getProviderInfo(getDBManager(), providerId);
			    
		    	if(providerList.size() > 0){
		    		providerMap = (VRMap)(providerList).get(0);
		    	}		    
			    
			    // ���p�ҏ��ɋ�����x�����Ə�����������B
		    	VRBindPathParser.set("PROVIDER_NAME", patientMap, providerMap.get("PROVIDER_NAME"));
		    }
	    }
    }
    
    // ���p�ҏ����AprintParam��KEY : PARAM��VALUE�Ƃ��Đݒ肷��B
    VRBindPathParser.set("PARAM", printParam, getPatientData());
    
    // �����
    // �������B
    QU001P01 qu001p01 = new QU001P01();
    ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
    
    // ����J�n��錾
    writer.beginPrintEdit();
    
    // ����N���X�֏�����n���B
    qu001p01.doPrint(writer, printParam);
    
    // ����I����錾
    writer.endPrintEdit();

    // PDF�t�@�C���𐶐����ĊJ���B
    ACChotarouXMLUtilities.openPDF(writer);
    
  }


  public static void main(String[] args) {
    // �f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    
    // ���N��
    VRHashMap param = new VRHashMap();
    param.setData("NEXT_AFFAIR", "QU002");
//    Date date = new Date();
//    param.setData("PATIENT_ID", new Integer(111));
//    param.setData("PATIENT_ID", date);
    ACFrame.debugStart(new ACAffairInfo(QU001.class.getName(), param));
//    ACFrame.debugStart(new ACAffairInfo(QU001.class.getName()));
  }

  /**
   * �u�����������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
    // ������������
  	
    // ���E�B���h�E�^�C�g���E�Ɩ��{�^���o�[�̐ݒ�
  	setAffairTitle(AFFAIR_ID, getNextAffair(), getButtons());
  	
  	// ��ʂ̏�����Ԃ�ݒ肷��BnextAffair�̒l�ɂ���āA�ݒ肪���򂷂�B

  	if("QU002".equals(getNextAffair())){
  	  	//�uQU002�v�̏ꍇ
  		
  		// �p�b�V�u�L�[�̒�`
  		setPASSIVE_CHECK_KEY(new ACPassiveKey("PATIENT",
				new String[] { "PATIENT_ID" },
				new Format[] { null },
				"LAST_TIME", "LAST_TIME"));
  		
  		// QU002�p�̐ݒ���s���B
  		setState_INIT_PATIENT();
  		
  	}else if("QS001".equals(getNextAffair())){
  		//�uQS001�v�̏ꍇ
  		
	    // QS001�p�̐ݒ���s���B
	    setState_INIT_SERVICE_PLAN();
	    
	}else if("QR001".equals(getNextAffair())){
	    //�uQR001�v�̏ꍇ
		
	    // QR001�p�̐ݒ���s���B
	    setState_INIT_SERVICE_RESULT();
	    	    
    }else if("QC001".equals(getNextAffair())){
    	//�uQC001�v�̏ꍇ
    	
	    // QC001�p�̐ݒ���s���B
	    setState_INIT_HOMONKANGO_PLAN();
	    
    }else if("QC002".equals(getNextAffair())){
        //�uQC002�v�̏ꍇ
    	
    	// QC002�p�̐ݒ���s���B
	    setState_INIT_HOMONKANGO_RESULT();
	    
    }else if("QC003".equals(getNextAffair())){
        //�uQC003�v�̏ꍇ
    	
	    // QC003�p�̐ݒ���s���B
	    setState_INIT_HOMONKANGO_JOHO_TEIKYOSHO();
	    
    }else if("QC004".equals(getNextAffair())){
        //�uQC004�v�̏ꍇ
    	
    	// QC004�p�̐ݒ���s���B
	    setState_INIT_HOMONKANGO_KIROKUSHO();
	    
    }else if("QC005".equals(getNextAffair())){
        //�uQC005�v�̏ꍇ
    	
    	// QC005�p�̐ݒ���s���B
	    setState_INIT_KYOTAKU();
	    
    }
      	
    // ���Ώ۔N���̐ݒ�
    // �V�X�e������A�u�V�X�e�����t�v���擾����B
    if(getFindTargetDate() == null){    
    	// �n��p�����[�^�Ƃ��āATARGET_DATE���n����Ă��Ȃ��ꍇ
	
    	Date sysDate = QkanSystemInformation.getInstance().getSystemDate();
    	
    	if(ACDateUtilities.compareOnDay(sysDate, TARGET_DATE_20060401) < 0){
        	// �V�X�e�����t������18�N4���ȑO�̓��t�̏ꍇ
    		getTargetDate().setDate(TARGET_DATE_20060401);
    	}else{
        	// �V�X�e�����t������18�N4���ȍ~�̓��t�̏ꍇ
	    	// ��ʂ́u�Ώ۔N��(targetDate)�v�ɁA�擾�����V�X�e�����t��ݒ肷��B
		    getTargetDate().setDate(sysDate);
    	}
	    
    }else{
    	// �n��p�����[�^�Ƃ��āATARGET_DATE���n����Ă���ꍇ
    	
    	// �n���ꂽTARGET_DATE����ʂ́u�Ώ۔N��(targetDate)�v�ɐݒ肷��B
    	getTargetDate().setDate(getFindTargetDate());
    	
    	// ��d�Ɏg�p����Ȃ��悤�폜����B
    	setFindTargetDate(null);
    	
    }   
  }

  /**
   * �u�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void doFind() throws Exception{
    // ��DB���痘�p�҈ꗗ���擾�A��ʂɐݒ�
  	
    // ����������
  	// SQL���擾�֐��ɓn�����R�[�h sqlParam�𐶐�����B
    VRMap sqlParam = new VRHashMap();

    // ���������̎擾
    VRMap selectKey = new VRHashMap();
    
    getFindConditions().setSource(selectKey);
    getFindConditions().applySource();
    
    // �����p�҃R�[�h�̎擾
    String patientCode = ACCastUtilities.toString(selectKey.get("PATIENT_CODE"));
    
    // ��ʂ́u���p�҃R�[�h(patientCode)�v��Text���擾���A�댯�����̒u�����s���B
	patientCode = QkanCommon.toFindString(patientCode);

	if(patientCode.length() > 0){
		// �擾���������񂪑��݂���ꍇ(�����񒷂�0���傫���ꍇ)
		
		// �擾�����������sqlParam�� KEY : PATIENT_CODE �� VALUE �Ƃ��Đݒ肷��B
		VRBindPathParser.set("PATIENT_CODE", sqlParam, patientCode);
		
	}
    
    // ���ӂ肪�Ȃ̎擾
    String patientKana = ACCastUtilities.toString(selectKey.get("PATIENT_KANA"));
    
    // ��ʂ́u�ӂ肪��(patientKana)�v��Text���擾���A�댯�����̒u�����s���B
	patientKana = QkanCommon.toFindString(patientKana);
	
	if(patientKana.length() > 0){    
		// �擾���������񂪑��݂���ꍇ(�����񒷂�0���傫���ꍇ)
		// �擾�����������sqlParam�� KEY : PATIENT_KANA �� VALUE �Ƃ��Đݒ肷��B
		VRBindPathParser.set("PATIENT_KANA", sqlParam, patientKana);
		
	}
    
    // �����N�����̎擾   	
    if(getBirthday().isValidDate()){  
    	// ���݂�����t�����͂���Ă���ꍇ
    
	    if(selectKey.get("PATIENT_BIRTHDAY") instanceof Date){   	 
		       	
		        // ��ʂ́u���N����(birthday)�v�̒l���擾����B
		    	Date birthDay = (Date)selectKey.get("PATIENT_BIRTHDAY");
	    	
			    // �擾�����l��sqlParam�� KEY : PATIENT_BIRTHDAY �� VALUE �Ƃ��Đݒ肷��B
		    	VRBindPathParser.set("PATIENT_BIRTHDAY", sqlParam, birthDay);
	    		
	    }
	    
    }else{
    	// ���݂��Ȃ����t�����͂���Ă���ꍇ
    	
    	//�t�H�[�J�X�����Ă�B
    	getBirthday().requestFocus();
    	
    	// �G���[���b�Z�[�W
    	QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("���N������");
    	
    	return;
    	
    }
    
	// ���u���ݗL���łȂ����p�҂��܂߂Č����v�t���O�̎擾
    // ��ʂ́u���ݗL���łȂ����p�҂��܂߂Č���(nowNotEnabledPatientIncludeFind)�v�̒l���擾����B
    if(!(selectKey.get("HIDE_FLAG") == null)){
    	
    	int hideFlag = ACCastUtilities.toInt(selectKey.get("HIDE_FLAG"));
    
	    if(hideFlag == 0){
		    // 0�̏ꍇ(���I���̏ꍇ)
	    	// sqlParam�� KEY : HIDE_FLAG, VALUE : null ��ݒ肷��B
	        VRBindPathParser.set("HIDE_FLAG", sqlParam, null);
	        
	    }
    }
    
    // ��DB����f�[�^���擾
    // �����pSQL�����擾����B
	String strSql = getSQL_GET_PATIENT(sqlParam);
    
	// �擾����SQL���𔭍s���A���ʂ�patientData�Ɋi�[����B
    VRList patientData = new VRArrayList();    
    patientData = getDBManager().executeQuery(strSql);
    
    // patientData��ޔ�����B
    setPatientData(patientData);
    
    // ���擾�����f�[�^����ʂɓW�J
    getPatientTableModel().setAdaptee(patientData);
    
    // patientData�̌������`�F�b�N����B
    if(patientData.size() > 0){
	    
    	// �ޔ��������p��ID���`�F�b�N����B
    	if(getPatientId() == 0){
    		// ���p��ID���n����Ă��Ȃ������ꍇ
    		
	    	// ��ʂ́u���p�҈ꗗ(patients)�v��1�s�ڂ�I������B
	    	getPatients().setSelectedSortedFirstRow();
	    	
    	}else{
    		// ���p��ID���n����Ă����ꍇ
    		
    		// �n���ꂽ���p��ID�������p�҂�I������B
    		int index = ACCommon.getInstance().getMatchIndexFromValue(
    				getPatientData(), "PATIENT_ID", new Integer(getPatientId()));
    		
    		if(index == -1){
    			
    			// �Y�����闘�p�҂����Ȃ������ꍇ�A1�s�ڂ�I������B
    			getPatients().setSelectedSortedFirstRow();
    			
    		}else{
    			
    			// �Y�����闘�p�҂������ꍇ�A�Y�����p�҂�I������B
    			getPatients().setSelectedModelRow(index);
                getPatients().scrollSelectedToVisible();
    		}
    			
    		// ��d�Ɏg�p����Ȃ��悤�ɍ폜����B
    		setPatientId(0);
    		
    	}    	
    }else{
    	// �Ɩ��{�^���̏�Ԃ�ύX����B
    	setState_UNSELECTED();
    }
    
    // ���p�b�V�u�L�[�̍ēo�^
    // �p�b�V�u�L�[���N���A����B
    getPassiveChecker().clearReservedPassive();
    
    // �p�b�V�u�L�[��o�^����B
    getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), getPatientData());
    
    // �X�e�[�^�X�o�[
//    setStatusText("");
    
    // �t�H�[�J�X
    if(getTargetDate().getParent().isVisible()){
    	getTargetDate().requestFocus();
    }else{
    	getPatientCode().requestFocus();
    }
    
  }
  
  /**
   * �u��ʑJ�ڏ����v�Ɋւ��鏈�����s���܂��B
   * @param �ꗗ�e�[�u���őI������Ă��闘�p�҂̗��p��ID
   * @throws Exception ������O
   */
  public void transferNext(int patientId) throws Exception{
  	
	// �X�e�[�^�X�o�[�ɑI�����ꂽ���p�҂̖��O��\������B
	VRMap patientData = ACBindUtilities.getMatchRowFromValue(
			getPatientData(), "PATIENT_ID", new Integer(patientId));
	String familyName = ACCastUtilities.toString(
			VRBindPathParser.get("PATIENT_FAMILY_NAME", patientData));
	String firstName = ACCastUtilities.toString(
			VRBindPathParser.get("PATIENT_FIRST_NAME", patientData));
	setStatusText(QkanCommon.toFullName(familyName, firstName) + "���񂪑I������܂����B");
	
	
    // ����ʂւ̓n��p�����[�^�i�[�p�Ƀ��R�[�h param�𐶐�����B
    VRMap param = new VRHashMap();
        
    // ���n��p�����[�^�̐ݒ�
    // ����ʑJ�ڂ̂��߂̃p�����[�^ NCAffairInfo affair ���`����B
    // affair(new ACAffair());
    ACAffairInfo affair = null;

    if("QU002".equals(getNextAffair())){
	    // �uQU002�v�̏ꍇ

	    // param�ɉ��L�p�����[�^��ݒ肷��B
	    // KEY : PROCESS_MODE, VALUE : PROCESS_MODE_UPDATE
	    // KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
    	VRBindPathParser.set("PROCESS_MODE", param, new Integer(QkanConstants.PROCESS_MODE_UPDATE));
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	
	    // ���L�p�����[�^�ɂ�affair�𐶐�����B
	    // className : QU002.class.getName(), parameters : param
    	affair = new ACAffairInfo(QU002.class.getName(), param); 
    	
    }else if("QC001".equals(getNextAffair())){
	    // �uQC001�v�̏ꍇ
    	
	    // param�ɉ��L�p�����[�^��ݒ肷��B
	    // KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
	    // KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	VRBindPathParser.set("TARGET_DATE", param, getTargetDate().getDate());
    	
	    // ���L�p�����[�^�ɂ�affair�𐶐�����B
	    // className : QC001.class.getName(), parameters : param
    	affair = new ACAffairInfo(QC001.class.getName(), param); 
    	
    }else if("QC002".equals(getNextAffair())){    	
	    // �uQC002�v�̏ꍇ
    	
	    // param�ɉ��L�p�����[�^��ݒ肷��B
	    // KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
	    // KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	VRBindPathParser.set("TARGET_DATE", param, getTargetDate().getDate());
    	
	    // ���L�p�����[�^�ɂ�affair�𐶐�����B
	    // className : QC002.class.getName(), parameters : param
    	affair = new ACAffairInfo(QC002.class.getName(), param);
    	
    }else if("QC003".equals(getNextAffair())){
	    // �uQC003�v�̏ꍇ
    	
	    // param�ɉ��L�p�����[�^��ݒ肷��B
	    // KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
	    // KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	VRBindPathParser.set("TARGET_DATE", param, getTargetDate().getDate());
    	
	    // ���L�p�����[�^�ɂ�affair�𐶐�����B
	    // className : QC003.class.getName(), parameters : param
    	affair = new ACAffairInfo(QC003.class.getName(), param);
    	
    }else if("QC004".equals(getNextAffair())){
	    // �uQC004�v�̏ꍇ
    	
	    // param�ɉ��L�p�����[�^��ݒ肷��B
	    // KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
	    // KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	VRBindPathParser.set("TARGET_DATE", param, getTargetDate().getDate());
    	
	    // ���L�p�����[�^�ɂ�affair�𐶐�����B
	    // className : QC004.class.getName(), parameters : param
    	affair = new ACAffairInfo(QC004.class.getName(), param);
    	
    }else if("QC005".equals(getNextAffair())){
	    // �uQC005�v�̏ꍇ
    	
	    // param�ɉ��L�p�����[�^��ݒ肷��B
	    // KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
	    // KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	VRBindPathParser.set("TARGET_DATE", param, getTargetDate().getDate());
    	
	    // ���L�p�����[�^�ɂ�affair�𐶐�����B
	    // className : QC005.class.getName(), parameters : param
    	affair = new ACAffairInfo(QC005.class.getName(), param);
    	
    }else if("QS001".equals(getNextAffair())){
	    // �uQS001�v�̏ꍇ
    	
	    // param�ɉ��L�p�����[�^��ݒ肷��B
    	// KEY : PATIENT_ID, VALUE : ���p��ID
	    // KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
    	// KEY : PROCESS_TYPE, VALUE : PROCESS_TYPE_PLAN
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	VRBindPathParser.set("TARGET_DATE", param, getTargetDate().getDate());
    	VRBindPathParser.set("PROCESS_TYPE", param, new Integer(QkanConstants.PROCESS_TYPE_PLAN));
    	
    	// ��L�p�����[�^�ɂ�affair�𐶐�����B
	    // className : QS001.class.getName(), parameters : param
	    affair = new ACAffairInfo(QS001.class.getName(), param, true);
	    
    }else if("QR001".equals(getNextAffair())){
        // �uQR001�v�̏ꍇ
    	
	    // param�ɉ��L�p�����[�^��ݒ肷��B
	    // KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
	    // KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
    	// KEY : PROCESS_TYPE, VALUE : PROCESS_TYPE_RESULT
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	VRBindPathParser.set("TARGET_DATE", param, getTargetDate().getDate());
    	VRBindPathParser.set("PROCESS_TYPE", param, new Integer(QkanConstants.PROCESS_TYPE_RESULT));
    	
	    // ���L�p�����[�^�ɂ�affair�𐶐�����B
	    // className : QR001.class.getName(), parameters : param
    	affair = new ACAffairInfo(QS001.class.getName(), param, true);
    	
    }
    
	// NEXT_AFFAIR, TARGET_DATE����ʑJ�ڑO�Ƀt���[���ɑޔ����Ă����B
	ACFrame.getInstance().addNowAffairParameter("NEXT_AFFAIR", getNextAffair());
	ACFrame.getInstance().addNowAffairParameter("TARGET_DATE", getTargetDate().getDate());
	ACFrame.getInstance().addNowAffairParameter("PATIENT_ID", new Integer(patientId));
    
    // ���J�ڏ���
    // ����ʂɑJ�ڂ���B
    ACFrame.getInstance().next(affair);
  	
  }
  
  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @return �G���[���Ȃ��ꍇtrue �G���[������ꍇfalse
   * @throws Exception ������O
   */
  public boolean checkValue() throws Exception{
    // �����̓`�F�b�N
    // ��ʂ́u�Ώ۔N��(targetDate)�v�ɒl�����͂���Ă��邩�ǂ����`�F�b�N����B

  	if("".equals(getTargetDate().getText())){
  		// ���͂���Ă��Ȃ��ꍇ  		
  		// �t�H�[�J�X�����Ă�B
  		getTargetDate().requestFocus();
  		
  		// ���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT
  		QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("�Ώ۔N��");
  	
  		return false;
  	}
  	
	if(!getTargetDate().isValidDate()){
  		// ���݂��Ȃ����t�����͂���Ă���ꍇ	
  		// �t�H�[�J�X�����Ă�B
  		getTargetDate().requestFocus();
  		
  		// ���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_WRONG_DATE 		
  		QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�Ώ۔N����");
  		
  		return false;
  		
  	}
	
	if(ACDateUtilities.compareOnDay(getTargetDate().getDate(), TARGET_DATE_20060401) < 0){
		// ����18�N4���ȑO�̓��t�����͂���Ă���ꍇ
  		// �t�H�[�J�X�����Ă�B
  		getTargetDate().requestFocus();

  		// ���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_WRONG_DATE 		
  		QkanMessageList.getInstance().QU001_ERROR_OF_DATE_BEFORE_LAW_CHANGE();
  		
  		return false;
  		
	}
	
    return true;
    
  }

  /**
   * �u���p�҂̗v�����`�F�b�N�v�Ɋւ��鏈�����s���܂��B
   * @param �`�F�b�N���s���Ώۗ��p�҂̗��p��ID
   * @return �v���x�������Ă���ꍇtrue �����Ă��Ȃ��ꍇfalse
   * @throws Exception ������O
   */
  public boolean checkInsureInfo(int patientId) throws Exception {
		// �I�����ꂽ���p�҂̏��(��{���E�v���x���)���擾����B
	  	Date targetDate = getTargetDate().getDate();
		VRList list = QkanCommon.getPatientInsureInfoOnEndOfMonth(
				getDBManager(), targetDate, patientId);

		if ((list.size() == 0)
				|| !(QkanCommon.isFullDecisionPatientInsureInfo(getDBManager(),
						targetDate, patientId))) {
			// �v���x��񂪎擾�ł��Ȃ������ꍇ
			// �������͐\�����̗v����񂪑��݂���ꍇ

			// �������s�m�F���b�Z�[�W��\������B�����b�Z�[�WID = QU001_HAS_NO_YOKAIGODO
			if (QkanMessageList.getInstance().QU001_HAS_NO_YOKAIGODO() == ACMessageBox.RESULT_CANCEL) {
				// �L�����Z���I����(�������f��)

				// �����𒆒f����B
				return false;

			}
		}

		return true;

	}

  public Component getFirstFocusComponent() {

		if (getTargetDate().getParent().isVisible()) {
			return getTargetDate();
		} else {
			return getPatientCode();
		}

	}
}
