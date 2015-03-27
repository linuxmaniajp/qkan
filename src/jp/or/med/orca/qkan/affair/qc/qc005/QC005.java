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
 * �쐬��: 2005/12/16  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �ݑ�×{�����̃|�C���g (005)
 * �v���O���� �ݑ�×{�����̃|�C���g (QC005)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc005;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.text.Format;
import java.util.Date;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �ݑ�×{�����̃|�C���g(QC005)
 */
public class QC005 extends QC005Event {

	/**
	 * �Ώ۔N���ɔF��L�����Ԃ����邩�Ȃ����̔���
	 */
	private boolean NoNinteiHistory;

	/**
	 * �����A�����̖K�����BindPath�̔z��i�[�ϐ�
	 */
	private static String[] VisitDayKey = { "VISIT_THIS_MONTH_NO1",
			"VISIT_THIS_MONTH_NO2", "VISIT_THIS_MONTH_NO3",
			"VISIT_THIS_MONTH_NO4", "VISIT_THIS_MONTH_NO5",
			"VISIT_THIS_MONTH_NO6", "VISIT_NEXT_MONTH_NO1",
			"VISIT_NEXT_MONTH_NO2", "VISIT_NEXT_MONTH_NO3",
			"VISIT_NEXT_MONTH_NO4", "VISIT_NEXT_MONTH_NO5",
			"VISIT_NEXT_MONTH_NO6" };

	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QC005() {
	}

	public void initAffair(ACAffairInfo affair) throws Exception {
		super.initAffair(affair);
		initAction(affair);
	}

	/**
	 * �������������s�Ȃ��܂��B
	 * 
	 * @param affair
	 *            �Ɩ����
	 * @throws Exception
	 *             ������O
	 */
	protected void initAction(ACAffairInfo affair) throws Exception {
		// �F��L�����ԃt���O�̏�����
		NoNinteiHistory = false;

		// �n��f�[�^�̎擾/�O��ʁu���p�҈ꗗ�v����n���ꂽ�p�����[�^��ޔ�����B
		// this.patientID = PATIENT_ID(���p��ID)
		// this.targetDate = TARGET_DATE(�Ώ۔N��)
		VRMap parameters = affair.getParameters();

		// �f�[�^�����݂��Ă��邩���`�F�b�N
		if (VRBindPathParser.has("PATIENT_ID", parameters)
				&& VRBindPathParser.has("TARGET_DATE", parameters)) {

			// int�^�Ɍ^�ϊ������p��ID��ޔ�
			setPatientID(Integer.parseInt(String.valueOf(VRBindPathParser.get(
					"PATIENT_ID", parameters))));
			// Date�^�Ɍ^�ϊ����Ώ۔N����ޔ�
			setTargetDate((Date) VRBindPathParser
					.get("TARGET_DATE", parameters));

        }
		
		// ��������Ԃ̐ݒ�
		// ��ʂ̏�����Ԃ�ݒ肷��B
		
		// ��ʂ̏��������s���B
		doInitialize();

		// �X�i�b�v�V���b�g�̎B�e�Ώۂ��w�肷��B
		getSnapshot().setRootContainer(getContents());

		// DB����f�[�^���擾����B
		doFind();
	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}

		// �F����Ԃ̔���t���O���^�̂Ƃ�
		if (NoNinteiHistory == true) {
			return true;
		}

		// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
		parameters.setData("PATIENT_ID", getPatientID());
		parameters.setData("TARGET_DATE", getTargetDate());
		// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add end
		
		// ���X�i�b�v�V���b�g�`�F�b�N
		// �X�i�b�v�V���b�g�̍X�V�`�F�b�N���s���B
		if (!getSnapshot().isModified()) {
			// �X�V����Ă��Ȃ��ꍇ
			// �O��ʂɖ߂�B
			// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 edit begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
			//parameters.setData("QU001.class", parameters);
			parameters.setData("QC006.class", this.getClass().getName());
			// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 edit end

			// �O��ʂɑJ�ڂ��Ă��悯���true��Ԃ�
			return true;
		}
		// �X�V����Ă���ꍇ
		// �������p������B
		// ���ۑ��m�F
		// ���\�����b�Z�[�W�̌���
		// �\�����b�Z�[�WID�i�[�p�̐��l�^�ϐ� msgID ���`����B
		int msgID = 0;
		// processMode�̒l���`�F�b�N����B
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// PROCESS_MODE_INSERT(�o�^)�̏ꍇ
			// msgID�ɁAWARNING_OF_INSERT_ON_MODIFIED��ݒ肷��B
			msgID = QkanMessageList.getInstance()
					.WARNING_OF_INSERT_ON_MODIFIED();
		} else {
			// PROCESS_MODE_UPDATE(�X�V)�̏ꍇ
			// msgID�ɁAWARNING_OF_UPDATE_ON_MODIFIED��ݒ肷��B
			msgID = QkanMessageList.getInstance()
					.WARNING_OF_UPDATE_ON_MODIFIED();
		}
		// ���m�F���b�Z�[�W�̕\��
		// �ۑ��m�F�̃��b�Z�[�W��\������B�����b�Z�[�WID��msgID�̒l
		switch (msgID) {
		case ACMessageBox.RESULT_YES:
			// �u�X�V���Ė߂�v�I����
			// �������p������B
			break;

		case ACMessageBox.RESULT_NO:
			// �u�j�����Ė߂�v�I����
			// �߂�p�n��p�����[�^�ɁA���L�̒l��ݒ肷��B
			// KEY : NEXT_AFFAIR, VALUE : QC005
			parameters.setData("NEXT_AFFAIR", "QC005");
			// �O��ʂɖ߂�B
			return true;

		case ACMessageBox.RESULT_CANCEL:
			// �u�L�����Z���v�I����
			// �����𒆒f����B
			return false;
		}

		// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 edit begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
		//--del begin
//		// �����̓`�F�b�N
//		// ���̓`�F�b�N���s���B
//		if (!checkValidInput()) {
//			// �G���[������ꍇ
//			// �����𒆒f����B
//			return false;
//		}
//		
//		// 2007/12/25 [Masahiko Higuchi] add - begin Ver 5.4.1�Ή�
//		 ����Ώۂ̂��̂��m�F����
//		if(isPrintFinish()){
//		    msgID = QkanMessageList.getInstance().QC005_WARNING_OF_PRINTED_KYOTAKU_RYOYO("����×{�Ǘ��w����");
//		    // �X�V���Ȃ��ꍇ
//		    if(msgID != ACMessageBox.RESULT_YES){
//		        return false;
//		    }
//		}
//		// 2007/12/25 [Masahiko Higuchi] add - end        
//		
//		// �G���[���Ȃ��ꍇ
//		// �������p������B
//		// ���ۑ�����
//		// �ۑ��������s���B
//		boolean saveState = false;
//		
//		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
//			saveState = doInsert();
//		} else {
//			saveState = doUpdate();
//		}
		//--del end
		//--add begin
		boolean saveState = doInsertOrUpdate(false);
		//--add end
		// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 edit end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
		
		if (!saveState) {
			// �ۑ��������ُ�I�������ꍇ
			// �����𒆒f����B
			return false;
			// �ۑ�����������I�������ꍇ
		} else {
			// �߂�p�n��p�����[�^�ɁA���L�̒l��ݒ肷��B
			// KEY : NEXT_AFFAIR
			parameters.setData("NEXT_AFFAIR");
			// �O��ʂɖ߂�B

			// �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
			return true;
		}
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}

		// ���X�i�b�v�V���b�g�`�F�b�N
		// �X�i�b�v�V���b�g�̍X�V�`�F�b�N���s���B
		if (!getSnapshot().isModified()) {
			// �X�V����Ă��Ȃ��ꍇ
			// �V�X�e�����I������B
			return true;
		}

		// �X�V����Ă���ꍇ
		// �������p������B
		// ���I���m�F
		// �I���m�F�̃��b�Z�[�W��\������B
		// �����b�Z�[�WID = WARNING_OF_CLOSE_ON_MODIFIED
		int msgID = QkanMessageList.getInstance()
				.WARNING_OF_CLOSE_ON_MODIFIED();
		if (msgID == ACMessageBox.RESULT_OK) {
			// �uOK�v�I����
			// �V�X�e�����I������B
			return true;
		} else {
			// �u�L�����Z���v�I����
			// �����𒆒f����B
			return false;
		}
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u��������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void printActionPerformed(ActionEvent e) throws Exception {
		// ���X�i�b�v�V���b�g�`�F�b�N
		// �X�i�b�v�V���b�g�̍X�V�`�F�b�N���s���B
		if (getSnapshot().isModified()) {
			int msgID = 0;
			if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
				msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("�o�^",
						"����×{�Ǘ��w����");
			} else {
				msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("�X�V",
						"����×{�Ǘ��w����");
			}

			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// �uOK�v�I����
				// �������p������B
				break;
			case ACMessageBox.RESULT_CANCEL:
				// �u�L�����Z���v�I����
				return;
			// �����𒆒f����B
			}
        // 2007/12/25 [Masahiko Higuchi] add - begin Ver 5.4.1�Ή�
        }
        boolean isPrinted = isPrintFinish();
        // 2007/12/25 [Masahiko Higuchi] add - end
        
			// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 edit begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
			//--del begin
//			// �����̓`�F�b�N
//			// ���̓`�F�b�N���s���B
//			if (!checkValidInput()) {
//				// �G���[������ꍇ
//				// �����𒆒f����B
//				return;
//			}
//			
//			// �G���[���Ȃ��ꍇ
//			// �������p������B
//			// ���ۑ�����
//			// �ۑ��������s���B
//			boolean saveState = false;
//			
//			if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
//				saveState = doInsert();
//			} else {
//				saveState = doUpdate();
//			}
			//--del end
			//--add begin
			// �������b�Z�[�W��\�����Ȃ�
        	boolean saveState = true;
			if (getSnapshot().isModified()) {
				saveState = doInsertOrUpdate(false);
				isPrinted = false;
	        }
			//--add end
			// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 edit end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�

			if (!saveState) {
				// �ۑ��������ُ�I�������ꍇ
				// �����𒆒f����B
				return;
			}
            
        // 2007/12/25 [Masahiko Higuchi] del - begin Ver 5.4.1�Ή�
		//}
        // 2007/12/25 [Masahiko Higuchi] del - end            

		// ���������
		// kyotakuData�ɁA��ʂ��璊�o���������i�[����B
		VRMap kyotakuData = getKyotakuData();

		getContents().setSource(kyotakuData);
		getContents().applySource();

        ACTextField[] shiftFields = new ACTextField[]{
               getVisitThisMonth1(),
               getVisitThisMonth2(),
               getVisitThisMonth3(),
               getVisitThisMonth4(),
               getVisitThisMonth5(),
               getVisitThisMonth6(),
        };
        int end = shiftFields.length;
        for(int i=0; i<end; i++){
            if(ACTextUtilities.isNullText(
                    VRBindPathParser.get(shiftFields[i].getBindPath(), kyotakuData))){
                //�󗓂�����ΉE�����֑���
                boolean find=false;
                for(int j=i+1; j<end; j++){
                    Object obj =VRBindPathParser.get(shiftFields[j].getBindPath(), kyotakuData); 
                    if(!ACTextUtilities.isNullText(obj)){
                        //�󗓈ȊO�f�[�^��������΍��֓]�L
                        VRBindPathParser.set(shiftFields[i].getBindPath(), kyotakuData, obj);
                        VRBindPathParser.set(shiftFields[j].getBindPath(), kyotakuData, "");
                        find = true;
                        break;
                    }
                }
                if(!find){
                    //�E�����ɐV�K�f�[�^���Ȃ���Ώ����I��
                    break;
                }
            }
        }
        shiftFields = new ACTextField[]{
                getVisitNextMonth1(),
                getVisitNextMonth2(),
                getVisitNextMonth3(),
                getVisitNextMonth4(),
                getVisitNextMonth5(),
                getVisitNextMonth6(),
         };
        end = shiftFields.length;
        for(int i=0; i<end; i++){
            if(ACTextUtilities.isNullText(
                    VRBindPathParser.get(shiftFields[i].getBindPath(), kyotakuData))){
                //�󗓂�����ΉE�����֑���
                boolean find=false;
                for(int j=i+1; j<end; j++){
                    Object obj =VRBindPathParser.get(shiftFields[j].getBindPath(), kyotakuData); 
                    if(!ACTextUtilities.isNullText(obj)){
                        //�󗓈ȊO�f�[�^��������΍��֓]�L
                        VRBindPathParser.set(shiftFields[i].getBindPath(), kyotakuData, obj);
                        VRBindPathParser.set(shiftFields[j].getBindPath(), kyotakuData, "");
                        find = true;
                        break;
                    }
                }
                if(!find){
                    //�E�����ɐV�K�f�[�^���Ȃ���Ώ����I��
                    break;
                }
            }
        }
        
		// ����N���X�ւ̓n��p�����[�^(���R�[�h) printParam�𐶐�����B
		VRMap printParam = null;

		// printParam�ɁAkyotakuData�̒l���R�s�[����B
		printParam = kyotakuData;

		// ����Ǘ��N���X�𐶐�
		ACChotarouXMLWriter writer = new ACChotarouXMLWriter();

		// ����J�n��錾
		writer.beginPrintEdit();
		// printParam.setData()
		QC005P01 qc00501 = new QC005P01();
		// �������B
		// doPrint(printParam);
		if (qc00501.doPrint(writer, printParam)) {
			// �������ꂽ�ꍇ

		} else {
			// ��������Ȃ������ꍇ
			return;
		}

        QC005P02 qc00502 = new QC005P02();
		if (qc00502.doPrint(writer, printParam)) {
			// �������ꂽ�ꍇ
			// ����I���𐧌�
			writer.endPrintEdit();
			// PDF�t�@�C���𐶐����ĊJ��
			ACChotarouXMLUtilities.openPDF(writer);

		} else {
			// ��������Ȃ������ꍇ
			return;
		}
        
        
		//  2008/01/07 [Masahiko Higuchi] add - begin ����×{�Ǘ��w�����ꊇ���
        int msgID = ACMessageBox.RESULT_YES;
        // �o�^���Ɉ���ς݃t���O�̒l���N���A�����̂őޔ������ݒ�l�Ń`�F�b�N����B
        if(!isPrinted){
            // ��������̊m��L�����m�F
            msgID = QkanMessageList.getInstance().QP001_PRINT_COMMIT();
        }
        // �w�͂��x�ȊO�͏����I��
        if(msgID != ACMessageBox.RESULT_YES){
            return;
        }
        
        try{
            // �g�����U�N�V�����̊J�n
            getDBManager().beginTransaction();
            // �p�����[�^�[�̐ݒ�
            VRMap sqlParam = new VRHashMap();
            sqlParam.setData("PATIENT_ID",ACCastUtilities.toInteger(getPatientID()));
            sqlParam.setData("TARGET_DATE",getTargetDate());
            sqlParam.setData("FINISH_FLAG",new Integer(1));
            // ��������̊m��
            getDBManager().executeUpdate(getSQL_UPDATE_FINISH_FLAG(sqlParam));
            // �R�~�b�g
            getDBManager().commitTransaction();
        }catch(Exception ex){
            ex.printStackTrace();
            // �G���[�̏ꍇ�̓��[���o�b�N
            getDBManager().rollbackTransaction();
            throw ex;
        }
        		//  2008/01/07 [Masahiko Higuchi] add - end
	}

	/**
	 * �u���߂̋���×{�Ǘ��w�������̓Ǎ��v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void openActionPerformed(ActionEvent e) throws Exception {
		// ���������s�m�F
		// �������s�̊m�F�̂��߁A���b�Z�[�W��\������B�����b�Z�[�WID =
		// QC001_WARNING_ON_READ_OF_MOST_NEW_DATA
		int msgID = QkanMessageList.getInstance()
				.QC001_WARNING_ON_READ_OF_MOST_NEW_DATA();

		switch (msgID) {
		case ACMessageBox.RESULT_OK:
			// �uOK�v�I����
			// �������p������B
			break;
		case ACMessageBox.RESULT_CANCEL:
			// �u�L�����Z���v�I����
			return;
		// �����𒆒f����B
		}

		// ���ߋ��̒��߂̏����擾
		// SQL���擾�֐��ւ̓n��p�����[�^(���R�[�h) sqlParam�ɉ��L�p�����[�^��ݒ肷��B
		VRMap sqlParam = null;
		sqlParam = new VRHashMap();

		// KEY : PATIENT_ID, VALUE : patientID (�ޔ������n��p�����[�^)
		sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
		// KEY : TARGET_DATE, VALUE : targetDate (�ޔ������n��p�����[�^)
		// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 edit begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
		//sqlParam.setData("TARGET_DATE", getTargetDate());
		sqlParam.setData("TARGET_DATE", ACDateUtilities.toLastDayOfMonth(getTargetDate()));
		// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 edit end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
		
		// �ߋ��̒��߂̏����擾���邽�߂�SQL�����擾����B
		// �擾����SQL���𔭍s����B
		VRList lastKyotakuData = getDBManager().executeQuery(
				getSQL_GET_LAST_KYOTAKU_RYOYO(sqlParam));

		// �擾������0����葽���ꍇ
		if (lastKyotakuData.size() > 0) {
			// �擾���R�[�h�W����1���ڂ̃��R�[�h��ޔ�����B
			VRMap lastKyotakuDataMap = new VRHashMap();
            
            // �����p�ҏ���DB����擾
            // �Ώۗ��p��(���p�҈ꗗ�őI�����ꂽ���p��)�̊�{�����擾����B
            VRList patientInfoList = QkanCommon.getPatientInfo(getDBManager(),
                    getPatientID());

            // �擾�ł��Ȃ������ꍇ
            if (patientInfoList.size() <= 0) {
                // �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_FIND
                QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();
                // �uQU001 ���p�҈ꗗ�v��ʂɖ߂�B(�����𔲂���)
                // OK�{�^���������̃C�x���g
                NoNinteiHistory = true;
                ACFrame.getInstance().back();
                return;
            } else {
                // �擾�ł����ꍇ
                // �������p������B
                // �擾�������R�[�h��kyotakuData�ɐݒ肷��B

                lastKyotakuDataMap.putAll((VRMap) patientInfoList.getData());

                // �����p�Ҏ����̎擾
                // ���p�҂̐��E����A�����A���p�҂̃t���l�[�����擾����B
                // toFullName((kyotakuData��KEY:PATIENT_FAMILY_NAME��VALUE),
                // (kyotakuData��KEY:PATIENT_FIRST_NAME��VALUE);
                // kyotakuData�ɉ��L�̒l��ݒ肷��B
                // KEY : PATIENT_NAME, VALUE : (�擾�������p�҃t���l�[��)

                lastKyotakuDataMap.setData("PATIENT_NAME", QkanCommon
                        .toFullName(VRBindPathParser.get("PATIENT_FAMILY_NAME",
                                lastKyotakuDataMap), VRBindPathParser.get(
                                "PATIENT_FIRST_NAME", lastKyotakuDataMap)));
            }

            // kyotakuData�̌������`�F�b�N����B
            // 0���̏ꍇ
            // �v���x�̔F��`�F�b�N
            VRList patientNinteiHistory = QkanCommon
                    .getPatientInsureInfoOnEndOfMonth(getDBManager(),
                            getTargetDate(), getPatientID());
            // [ID:0000508][Masahiko Higuchi] 2010/01 edit begin 2009�N�x�Ή�
            if(patientNinteiHistory != null && patientNinteiHistory.size() >= 1){
                VRMap history = (VRMap)patientNinteiHistory.getData(0);
                // ���v���x�̎擾
                Integer jotaiCode = ACCastUtilities.toInteger(history.getData("JOTAI_CODE"),0);
                // ���p�ҏ���D�悷�邽�ߗ��p�ҏ��ŏ㏑��
                ((VRMap)lastKyotakuData.getData()).setData("JOTAI_CODE",jotaiCode);
                // [ID:0000508][Masahiko Higuchi] 2010/01 edit end
            } else {
                // [ID:0000508][Masahiko Higuchi] 2009/07 add begin 2009�N�x�Ή�
                ((VRMap)lastKyotakuData.getData()).setData("JOTAI_CODE",new Integer(1));
                // [ID:0000508][Masahiko Higuchi] 2009/07 add end
            }
            
            
            //���p�ҏ��擾��ɏ㏑������`�Ŏ擾����
            lastKyotakuDataMap = (VRMap) lastKyotakuData.getData();
            
            // [ID:0000595][Masahiko Higuchi] 2010/01 edit begin 2009�N�x�Ή�
            //�S�Ẵe�L�X�g�{�b�N�X�������͂ł���ꍇ
            if (ACTextUtilities.isNullText(getVisitThisMonth1().getText())
            	&& ACTextUtilities.isNullText(getVisitThisMonth2().getText())
                && ACTextUtilities.isNullText(getVisitThisMonth3().getText())
                && ACTextUtilities.isNullText(getVisitThisMonth4().getText())
                && ACTextUtilities.isNullText(getVisitThisMonth5().getText())
                && ACTextUtilities.isNullText(getVisitThisMonth6().getText())) {
            	
    			// �����̖K��\��̓��t�������̖K����ɐݒ肷��B
    			for (int i = 6; i < 12; i++) {
    				if (VRBindPathParser.get(VisitDayKey[i], lastKyotakuDataMap) != null) {
    					lastKyotakuDataMap.setData(
    						VisitDayKey[i - 6],
    						String.valueOf(ACDateUtilities.getDayOfMonth(ACCastUtilities.toDate(VRBindPathParser.get(VisitDayKey[i],lastKyotakuDataMap))))
    					);
    				} else {
    					lastKyotakuDataMap.setData(VisitDayKey[i - 6], "");
    				}
    			}
    			
    		//�o�^����Ă���ꍇ�́A�ݒ�l���c��
            } else {
            	lastKyotakuDataMap.setData(VisitDayKey[0], getVisitThisMonth1().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[1], getVisitThisMonth2().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[2], getVisitThisMonth3().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[3], getVisitThisMonth4().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[4], getVisitThisMonth5().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[5], getVisitThisMonth6().getText());
            }
            
            
            if (ACTextUtilities.isNullText(getVisitNextMonth1().getText())
                && ACTextUtilities.isNullText(getVisitNextMonth2().getText())
                && ACTextUtilities.isNullText(getVisitNextMonth3().getText())
                && ACTextUtilities.isNullText(getVisitNextMonth4().getText())
                && ACTextUtilities.isNullText(getVisitNextMonth5().getText())
                && ACTextUtilities.isNullText(getVisitNextMonth6().getText())) {
    			// �K����̃L�[�ɋ��o�^
    			for (int i = 6; i < 12; i++) {
    				lastKyotakuDataMap.setData(VisitDayKey[i], "");
    			}
            } else {
            	lastKyotakuDataMap.setData(VisitDayKey[6], getVisitNextMonth1().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[7], getVisitNextMonth2().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[8], getVisitNextMonth3().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[9], getVisitNextMonth4().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[10], getVisitNextMonth5().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[11], getVisitNextMonth6().getText());
            }
            // [ID:0000595][Masahiko Higuchi] 2010/01 edit end

			// �Ώ۔N����a��ɕϊ�
			lastKyotakuDataMap.setData("TARGET_DATE", VRDateParser.format(
					getTargetDate(), "ggge�NM��"));

			// �������̃A�h�o�C�X�̏����l�̐ݒ�
			// lastKyotakuDataMap�ɉ��L�̒l��ݒ肷��B
			// KEY : ADVICE_MONTH, VALUE : targetDate (M)
			lastKyotakuDataMap.setData("ADVICE_MONTH", VRDateParser.format(
					getTargetDate(), "M"));
            
            //�厡�㎁�������x���Ɉ�
            if(lastKyotakuDataMap.getData("DOCTOR_NAME") != null){
                String doctorName = ACCastUtilities.toString(lastKyotakuDataMap
                        .getData("DOCTOR_NAME"));
                //�厡�㎁����ݒ�
                getYourDoctor().setText(doctorName);
            }
            
            
            //�f�[�^�ڍs�Ή�
            //�@�����O�̃f�[�^�ɂ��Ă͗��p�ҏ��̃o�C���h���s��Ȃ��B
            Date defaultDate = ACCastUtilities.toDate("2006/05/01");
            if(ACDateUtilities.compareOnDay(getTargetDate(),defaultDate) < 0){
                lastKyotakuDataMap.removeData("PATIENT_ADDRESS");
                lastKyotakuDataMap.removeData("PATIENT_TEL_FIRST");
                lastKyotakuDataMap.removeData("PATIENT_TEL_SECOND");
                lastKyotakuDataMap.removeData("PATIENT_TEL_THIRD");
            }
            

			// contents�p�l����source�Ƃ��āA�ޔ��������R�[�h��ݒ肷��B
			getContents().setSource(lastKyotakuDataMap);

			// bindSource�����s���A�ޔ��������R�[�h�̒l��contents�p�l���ɓW�J����B
			getContents().bindSource();
            
			// �擾������0���̏ꍇ
			// �ߋ���񂪑��݂��Ȃ��������Ƃ�ʒm���郁�b�Z�[�W��\������B
		} else {
			QkanMessageList.getInstance().QC001_NOTICE_HAS_NO_LAST_DATA();
			// �f�[�^�̏㏑�͍s��Ȃ��B
		}
	}

	/**
	 * �u�o�^�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {
		// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 edit begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
		//--del begin
//		// ���f�[�^��DB�ɓo�^
//		// �����̓`�F�b�N
//		// ���̓`�F�b�N���s���B
//		if (!checkValidInput()) {
//			// �G���[������ꍇ
//			// �����𒆒f����B
//			return;
//		}
//		// �G���[���Ȃ��ꍇ
//		// �������p������B
//		// ���o�^����
//		// �o�^�������s���B
//        //����������I�������ꍇ
//		if(doInsert()){
//            // ���������ʒm���b�Z�[�W��\������B�����b�Z�[�WID = UPDATE_SUCCESSED
//            QkanMessageList.getInstance().INSERT_SUCCESSED();
//        }else{
//            return;
//        }
		//--del end
		//--add begin
		doInsertOrUpdate(true);
		//--add end
		// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 edit end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�

	}

	/**
	 * �u�X�V�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void updateActionPerformed(ActionEvent e) throws Exception {
		// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 edit begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
		//--del begin
//		// ���f�[�^��DB�ɍX�V
//		// �����̓`�F�b�N
//		// ���̓`�F�b�N���s���B
//		if (!checkValidInput()) {
//
//			// �G���[������ꍇ
//			// �����𒆒f����B
//			return;
//		}
//        
//        // 2007/12/25 [Masahiko Higuchi] add - begin Ver 5.4.1�Ή�
//        // ����Ώۂ̂��̂��m�F����
//        if(isPrintFinish()){
//            int msgID = QkanMessageList.getInstance().QC005_WARNING_OF_PRINTED_KYOTAKU_RYOYO("����×{�Ǘ��w����");
//            // �X�V���Ȃ��ꍇ
//            if(msgID != ACMessageBox.RESULT_YES){
//                return;
//            }
//        }
//        // 2007/12/25 [Masahiko Higuchi] add - end
//        
//		// �G���[���Ȃ��ꍇ
//		// �������p������B
//		// ���X�V����
//		// �X�V�������s���B
//        //����ɏI�������ꍇ
//		if(doUpdate()){
//            // ���������ʒm���b�Z�[�W��\������B�����b�Z�[�WID = UPDATE_SUCCESSED
//            QkanMessageList.getInstance().UPDATE_SUCCESSED();
//        }else{
//            return;
//        }
		//--del end
		//--add begin
		doInsertOrUpdate(true);
		//--add end
		// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 edit end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�

	}

	/**
	 * �u�u���Ȃ��̎厡��v�̐ݒ�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void doctorNameFocusLost(FocusEvent e) throws Exception {
		// ��ʂ́u���Ȃ��̎厡��(yourDoctorName)�v�ɁAdoctorName�̒l��ݒ肷��B
		getYourDoctor().setText(getDoctorName().getText());
	}

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		try {
			VRHashMap param = new VRHashMap();
			param.setData("PATIENT_ID", "1");
			param.setData("TARGET_DATE", new Date(106, 02, 01));
			ACFrame.setVRLookAndFeel();
			ACFrame.getInstance().setFrameEventProcesser(
					new QkanFrameEventProcesser());
			QkanCommon.debugInitialize();
			ACAffairInfo affair = new ACAffairInfo(QC005.class.getName(), param);
			ACFrame.debugStart(affair);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �����֐�

	/**
	 * �u�E�B���h�E�^�C�g���̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doInitialize() throws Exception {
		// ���E�B���h�E�^�C�g���̐ݒ�
		// �Ɩ���񃌃R�[�h���擾����B
		// �E�B���h�E�^�C�g���ɁA�擾���R�[�h��KEY : WINDOW_TITLE��VALUE��ݒ肷��B
		// �Ɩ��{�^���o�[�̃e�L�X�g�ɁA�擾���R�[�h��KEY : AFFAIR_TITLE��VALUE��ݒ肷��B
		setAffairTitle("QC005", "0", getButtons());
		setPASSIVE_CHECK_KEY(new ACPassiveKey("KYOTAKU_RYOYO", new String[] {
				"PATIENT_ID", "TARGET_DATE" }, new Format[] { null,
				new ACSQLSafeDateFormat("yyyy/M/d") }, "LAST_TIME", "LAST_TIME"));
        
		// [ID:0000547][Masahiko Higuchi] 2009/08 add begin 2009�N�x�v�]�Ή�
        Object obj = getCreateDateZaitaku().getParent();
        // �e�����x���R���e�i�Ȃ�q�̗L����ԂƘA������
        if(obj instanceof ACLabelContainer) {
            ((ACLabelContainer)obj).setVisible(getCreateDateZaitaku().isVisible());
        }
        // [ID:0000547][Masahiko Higuchi] 2009/08 add begin 2009�N�x�v�]�Ή�

		// �v���x�ɏ����l�ݒ�
		getJotaiCode().setSelectedIndex(1);
		
		// ���R���{�̃A�C�e���̏����ݒ�
		// �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
		VRMap comboItemMap = new VRHashMap();

		// ����Ë@�֖�(medicalInstitusion)
		// ��Ë@�֎擾�p��SQL�����擾����B
		// �擾����SQL���𔭍s����B
		VRList ListMedicalInstitusion = getDBManager().executeQuery(
				getSQL_GET_MEDICAL_FACIRITY(null));

		// �擾�������R�[�h�W�����AcomboItemMap �� KEY : MEDICAL_INSTITUSIONS �� VALUE
		// �Ƃ��Đݒ肷��B
		comboItemMap.setData("MEDICAL_INSTITUSIONS", ListMedicalInstitusion);

		// �����Ə���
		// ���Ə������擾����B
		VRList ListProvider = QkanCommon.getProviderInfo(getDBManager());

		// �擾�������R�[�h�W�����AcomboItemMap �� KEY : PROVIDER_NAMES �� VALUE �Ƃ��Đݒ肷��B
		comboItemMap.setData("PROVIDER_NAMES", ListProvider);

        
        VRMap sqlParam = new VRHashMap();
        sqlParam.setData("PATIENT_ID",new Integer(getPatientID()));

        
		// ��model�̓W�J
		// �u�X�e�[�V�������̈�(stations)�v��model�Ƃ��āAcomboItemMap��ݒ肷��B
		getContents().setModelSource(comboItemMap);

		// �u�X�e�[�V�������̈�(stations)�v��model��W�J����B
		getContents().bindModelSource();
        //�o�C���h�p��Map
        VRMap bindMap = new VRHashMap();

        //���O�C�����Ə��ƃR���{���̑I�����ň�v���Ă��郌�R�[�h���擾����
		VRMap providerMap = ACCommon.getInstance().getMatchRowFromValue(ListProvider,
                "PROVIDER_ID",
                QkanSystemInformation.getInstance().getLoginProviderID());
        //�R���{�I�����̑I������
        int index = ACCommon.getInstance().getMatchIndexFromValue(ListProvider,
                "PROVIDER_ID",
                QkanSystemInformation.getInstance().getLoginProviderID());
        
        // [ID:0000519][Masahiko Higuchi] 2009/07 add begin 2009�N�x�Ή�
        // �����p�ҏ���DB����擾
        // �Ώۗ��p��(���p�҈ꗗ�őI�����ꂽ���p��)�̊�{�����擾����B
        VRList patientInfoList = QkanCommon.getPatientInfo(getDBManager(),
                getPatientID());
        // �i�[�p�ϐ�
        VRMap patientMap = new VRHashMap();
        patientMap = (VRMap)patientInfoList.getData();
        // �Z�����ʐݒ肷��B
        bindMap.put("PATIENT_ADDRESS", ACCastUtilities.toString(patientMap.getData("PATIENT_ADDRESS"),""));
        // [ID:0000519][Masahiko Higuchi] 2009/07 add end
        
        if(providerMap != null){
            bindMap.putAll(providerMap);
        }
        getContents().setSource(bindMap);
        getContents().bindSource();
        
        if(index >= 0){
            getProviderName().setSelectedIndex(index);
        }
        
	}

	/**
	 * �u����×{�Ǘ��w�������̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFind() throws Exception {
		// ��DB���狏��×{�Ǘ��w���������擾
		// sql�ւ̓n��p�����[�^(���R�[�h) sqlParam�𐶐�����B
		VRMap sqlParam = new VRHashMap();
		VRMap kyotakuDataMap = new VRHashMap();
		VRMap bindMap = new VRHashMap();
        
        // �����p�ҏ���DB����擾
        // �Ώۗ��p��(���p�҈ꗗ�őI�����ꂽ���p��)�̊�{�����擾����B
        VRList patientInfoList = QkanCommon.getPatientInfo(getDBManager(),
                getPatientID());
        
        VRMap patientMap = new VRHashMap();
        patientMap = (VRMap)patientInfoList.getData();
        
        // �擾�ł��Ȃ������ꍇ
        if (patientInfoList.size() <= 0) {
            // �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_FIND
            QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();
            // �uQU001 ���p�҈ꗗ�v��ʂɖ߂�B(�����𔲂���)
            // OK�{�^���������̃C�x���g
            NoNinteiHistory = true;
            ACFrame.getInstance().back();
            return;
        } else {
            // �擾�ł����ꍇ
            // �������p������B
            // �擾�������R�[�h��kyotakuData�ɐݒ肷��B

            bindMap.putAll(patientMap);

            // �����p�Ҏ����̎擾
            // ���p�҂̐��E����A�����A���p�҂̃t���l�[�����擾����B
            // toFullName((kyotakuData��KEY:PATIENT_FAMILY_NAME��VALUE),
            // (kyotakuData��KEY:PATIENT_FIRST_NAME��VALUE);
            // kyotakuData�ɉ��L�̒l��ݒ肷��B
            // KEY : PATIENT_NAME, VALUE : (�擾�������p�҃t���l�[��)

            bindMap.setData("PATIENT_NAME", QkanCommon
                    .toFullName(VRBindPathParser.get("PATIENT_FAMILY_NAME",
                            patientMap), VRBindPathParser.get(
                            "PATIENT_FIRST_NAME", patientMap)));
        }

        // kyotakuData�̌������`�F�b�N����B
        // 0���̏ꍇ
        // �v���x�̔F��`�F�b�N
        VRList patientNinteiHistory = QkanCommon
                .getPatientInsureInfoOnEndOfMonth(getDBManager(),
                        getTargetDate(), getPatientID());
            
        if(!(patientNinteiHistory == null || patientNinteiHistory.size() == 0)){
            // ���v���x�̎擾
            // ���p�ҏ�񃌃R�[�h��KEY:JOTAI_CODE��VALUE���A�v���x��\��������ɕϊ�����B
            // kyotakuData�ɉ��L�̒l��ݒ肷��B
            // KEY : YOKAIGODO
            patientMap.putAll((VRMap)patientNinteiHistory.getData());
            bindMap.setData("JOTAI_CODE",patientMap.getData("JOTAI_CODE"));
            
        }
        
        
        
		// sqlParam�ɉ��L�̒l��ݒ肷��B
		// KEY : PATIENT_ID, VALUE : patientID (�ޔ������l)
		// KEY : TARGET_DATE, VALUE : targetDate (�ޔ������l)
		sqlParam.setData("PATIENT_ID", String.valueOf(getPatientID()));
		sqlParam.setData("TARGET_DATE", getTargetDate());

		// ����×{�Ǘ��w�������擾�p��SQL�����擾����B
		// �擾����SQL���𔭍s���A���ʂ�kyotakuData�ɒǉ�����B
		VRList kyotakuList = getDBManager().executeQuery(
				getSQL_GET_KYOTAKU_RYOYO(sqlParam));

		// kyotakuData�̌������`�F�b�N����B
		// 0���̏ꍇ
		if (kyotakuList.size() <= 0) {
			// processMode��PROCESS_MODE_INSERT��ݒ肷��B(�o�^���[�h)
			setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
			// �o�^�{�^����\������B
			setState_PROCESS_MODE_INSERT();
			// kyotakuData��contents�p�l���ɐݒ肵�AcreateSource�����s����B
			// kyotakuData�̏����l��ݒ肷��B
			setKyotakuData((VRMap) getContents().createSource());
            //�����l���擾
			setInitValue();
            
			kyotakuDataMap.putAll(getKyotakuData());

			// 0����葽���ꍇ
		} else {
			// processMode��PROCESS_MODE_UPDATE��ݒ肷��B(�X�V���[�h)
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
			// �X�V�{�^����\������B
			setState_PROCESS_MODE_UPDATE();
			// resultData�ɁA�擾�������R�[�h�W����1���ڂ̃��R�[�h�̒l��ǉ�����B
			kyotakuDataMap.putAll((VRMap) kyotakuList.getData());

			// �Ώ۔N����a��ɕϊ�
			kyotakuDataMap.setData("TARGET_DATE", VRDateParser.format(
					ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE",
							kyotakuDataMap)), "ggge�NM��"));

			// ��t�����x���ɓ\�t
			kyotakuDataMap.setData("YOUR_DOCTOR_NAME", VRBindPathParser.get(
					"DOCTOR_NAME", kyotakuDataMap));

			// �����̖K����Ɨ����̖K��\��̓��t���擾����B
			for (int i = 0; i < 12; i++) {
				if (VRBindPathParser.get(VisitDayKey[i], kyotakuDataMap) != null) {
					kyotakuDataMap.setData(VisitDayKey[i], String
							.valueOf(ACDateUtilities
									.getDayOfMonth(ACCastUtilities
											.toDate(VRBindPathParser.get(
													VisitDayKey[i],
													kyotakuDataMap)))));
				}
			}
			
			// �p�b�V�u�L�[��o�^����B
			// reservedPassive(PASSIVE_CHECK_KEY, (�擾�������R�[�h�W��));
			getPassiveChecker().clearReservedPassive();

			getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
					kyotakuList);

		}
        
        //�o�C���h�p��Map�ƃ}�[�W����
        bindMap.putAll(kyotakuDataMap);
		// contents�p�l����source�Ƃ��āAkyotakuData��ݒ肷��B
		getContents().setSource(bindMap);
		// bindSource�����s���AkyotakuData�̒l��contents�p�l���ɓW�J����B
		getContents().bindSource();

		// �X�i�b�v�V���b�g���B�e����B
		getSnapshot().snapshot();
	}

	/**
	 * �u�����l�̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void setInitValue() throws Exception {
		// ���쐬�N���̏����l�̐ݒ�
		// kyotakuData�ɉ��L�̒l��ݒ肷��B
		// KEY : CREATE_DATE_ZAITAKU, VALUE : targetDate (ggge�NM��)
		VRMap kyotakuDataMap = null;
		kyotakuDataMap = new VRHashMap();

		kyotakuDataMap.setData("TARGET_DATE", VRDateParser.format(
				getTargetDate(), "ggge�NM��"));
		kyotakuDataMap.setData("CREATE_DATE_ZAITAKU", getTargetDate());

		// �������̃A�h�o�C�X�̏����l�̐ݒ�
		// kyotakuData�ɉ��L�̒l��ݒ肷��B
		// KEY : ADVICE_MONTH, VALUE : targetDate (M)
		kyotakuDataMap.setData("ADVICE_MONTH", VRDateParser.format(
				getTargetDate(), "M"));


		// ���쐬�N�����̏����l�̐ݒ�
		// �V�X�e������A�u�V�X�e�����t�v���擾����B
		Date systemDate = QkanSystemInformation.getInstance().getSystemDate();

		// kyotakuData�ɉ��L�̒l��ݒ肷��B
		// KEY : CREATE_DATE_KYOTAKU, VALUE : (�擾�����V�X�e�����t)
		kyotakuDataMap.setData("CREATE_DATE_KYOTAKU", systemDate);

		// �����Ə��R���{�̏����I��l�̐ݒ�
		// ���O�C�����Ə�ID���擾����B
		String loginProvider = QkanSystemInformation.getInstance()
				.getLoginProviderID();

		// ���O�C�����Ə�����ݒ肷��B
		VRList loginProviderName = QkanCommon.getProviderInfo(getDBManager(),
				loginProvider);

		// ��ʂ̎��Ə���(providerName)�ɁA���O�C�����Ə�����ݒ肷��B
		kyotakuDataMap.setData("PROVIDER_NAME", VRBindPathParser.get(
				"PROVIDER_NAME", (VRMap) loginProviderName.getData()));
        
        // [ID:0000431][Masahiko Higuchi] 2009/07 add begin ���ѓǍ�(V5.4.9)
        // �T�[�r�X���т��񋟓����擾
        VRMap serviceResult = getKyotakuResult();
        // �����l�Ƃ��Đݒ�
        kyotakuDataMap.putAll(serviceResult);
        // [ID:0000431][Masahiko Higuchi] 2009/07 add end
        
		setKyotakuData(kyotakuDataMap);
	}

	/**
	 * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doInsert() throws Exception {
		// ���p�b�V�u�`�F�b�N
		// ���p�b�V�u�`�F�b�N�̂��߂̏���
		// kyotakuData�ɁA��ʂ��璊�o���������i�[����B
		VRMap kyotakuDataMap = null;
		kyotakuDataMap = new VRHashMap();
		kyotakuDataMap = getKyotakuData();

		// DB�}�l�[�W���[��`
		ACDBManager dbm = getDBManager();

		try {
			// �g�����U�N�V�����J�n
			dbm.beginTransaction();

			getContents().setSource(kyotakuDataMap);
			getContents().applySource();

			// kyotakuData�ɉ��L�̒l��ݒ肷��B
			// KEY : PATIENT_ID, VALUE : patientID (�ޔ������n��p�����[�^)
			// KEY : TARGET_DATE, VALUE : targetDate (�ޔ������n��p�����[�^)
			kyotakuDataMap
					.setData("PATIENT_ID", String.valueOf(getPatientID()));
			kyotakuDataMap.setData("TARGET_DATE", getTargetDate());

			// �K�����HashMap�ϊ�
			if (!getVisitThisMonth1().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO1", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth1().getText()));
			}
			if (!getVisitThisMonth2().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO2", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth2().getText()));
			}
			if (!getVisitThisMonth3().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO3", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth3().getText()));
			}
			if (!getVisitThisMonth4().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO4", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth4().getText()));
			}
			if (!getVisitThisMonth5().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO5", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth5().getText()));
			}
			if (!getVisitThisMonth6().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO6", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth6().getText()));
			}

			// �����̖K�����HashMap�ϊ�
			// �����̒l
			Date nextMonth = ACDateUtilities.addMonth(getTargetDate(), 1);
			
			if (!getVisitNextMonth1().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO1", ACCastUtilities
						.toDate(VRDateParser.format(nextMonth, "yyyy/MM") + "/"
								+ getVisitNextMonth1().getText()));
			}
			if (!getVisitNextMonth2().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO2", ACCastUtilities
						.toDate(VRDateParser.format(nextMonth, "yyyy/MM") + "/"
								+ getVisitNextMonth2().getText()));
			}
			if (!getVisitNextMonth3().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO3", ACCastUtilities
						.toDate(VRDateParser.format(nextMonth, "yyyy/MM") + "/"
								+ getVisitNextMonth3().getText()));
			}
			if (!getVisitNextMonth4().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO4", ACCastUtilities
						.toDate(VRDateParser.format(nextMonth, "yyyy/MM") + "/"
								+ getVisitNextMonth4().getText()));
			}
			if (!getVisitNextMonth5().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO5", ACCastUtilities
						.toDate(VRDateParser.format(nextMonth, "yyyy/MM") + "/"
								+ getVisitNextMonth5().getText()));
			}
			if (!getVisitNextMonth6().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO6", ACCastUtilities
						.toDate(VRDateParser.format(nextMonth, "yyyy/MM") + "/"
								+ getVisitNextMonth6().getText()));
			}

			// SQL�擾�֐��ւ̓n���p�����[�^(���R�[�h) sqlParam�𐶐�����B
			// VRMap sqlParam = null;

			// �p�b�V�u�^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();

			// ���p�b�V�u�^�X�N�̓o�^
			// processMode�̒l���`�F�b�N����B

			// ���R�[�h�W�� kyotakuDataList �𐶐����A���R�[�h kyotakuData ��ǉ�����B
			VRList kyotakuDataList = null;
			kyotakuDataList = new VRArrayList();

			kyotakuDataList.add(getKyotakuData());

			// ����×{�Ǘ��w�������̃p�b�V�u�L�[��o�^����B
			// �p�b�V�u�L�[��o�^����B
			// reservedPassive(PASSIVE_CHECK_KEY, (�擾�������R�[�h�W��));
			// ����×{�Ǘ��w�������ǉ��p�̃p�b�V�u�^�X�N��o�^����B
			getPassiveChecker().addPassiveInsertTask(getPASSIVE_CHECK_KEY(),
					kyotakuDataList);

			// ���p�b�V�u�`�F�b�N�̎��s
			// �p�b�V�u�`�F�b�N�����s����B
			if (!getPassiveChecker().passiveCheck(dbm)) {
				// �p�b�V�u�G���[������ꍇ
				// �p�b�V�u�G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
				QkanMessageList.getInstance()
						.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();

				// ���������[���o�b�N����B
				dbm.rollbackTransaction();
				// �����𒆒f����B(�ُ�I��)
				return false;
			}

			// �p�b�V�u�G���[���Ȃ��ꍇ
			// �������p������B
			// ���ݑ�×{�����̃|�C���g�E����×{�Ǘ��w�������̓o�^
			// processMode�̒l���`�F�b�N����B
			// ����×{�Ǘ��w�������o�^�p��SQL�����擾����B
			// �擾����SQL���𔭍s����B
			dbm.executeUpdate(getSQL_INSERT_KYOTAKU_RYOYO(kyotakuDataMap));

			// ���R�~�b�g/���[���o�b�N
			// ��L��A��SQL���s�����ŃG���[���Ȃ������ꍇ
			dbm.commitTransaction();
			// �������R�~�b�g����B
			// ��ʂ̏��������s���B
			doInitialize();

			// �����������s���B
			doFind();

			// �������I������B(����I��)
			return true;

		} catch (Exception sqlEx) {
			// SQL���s�����ŃG���[���������ꍇ
			// ���������[���o�b�N����B
			sqlEx.printStackTrace();

			dbm.rollbackTransaction();
			// �����𒆒f����B(�ُ�I��)
			throw sqlEx;
		}
	}

	/**
	 * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doUpdate() throws Exception {
		// ���p�b�V�u�`�F�b�N
		// ���p�b�V�u�`�F�b�N�̂��߂̏���
		// kyotakuData�ɁA��ʂ��璊�o���������i�[����B
		VRMap kyotakuDataMap = null;
		kyotakuDataMap = new VRHashMap();
		kyotakuDataMap = getKyotakuData();

		// DB�}�l�[�W���[��`
		ACDBManager dbm = getDBManager();

		try {
			// �g�����U�N�V�����J�n
			dbm.beginTransaction();

			getContents().setSource(kyotakuDataMap);
			getContents().applySource();

			// kyotakuData�ɉ��L�̒l��ݒ肷��B
			// KEY : PATIENT_ID, VALUE : patientID (�ޔ������n��p�����[�^)
			// KEY : TARGET_DATE, VALUE : targetDate (�ޔ������n��p�����[�^)
			kyotakuDataMap
					.setData("PATIENT_ID", String.valueOf(getPatientID()));
			kyotakuDataMap.setData("TARGET_DATE", getTargetDate());

			// �K�����HashMap�ϊ�
			if (!getVisitThisMonth1().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO1", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth1().getText()));
			}
			if (!getVisitThisMonth2().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO2", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth2().getText()));
			}
			if (!getVisitThisMonth3().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO3", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth3().getText()));
			}
			if (!getVisitThisMonth4().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO4", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth4().getText()));
			}
			if (!getVisitThisMonth5().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO5", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth5().getText()));
			}
			if (!getVisitThisMonth6().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO6", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth6().getText()));
			}

			// �����̖K�����HashMap�ϊ�
			if (!getVisitNextMonth1().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO1", ACCastUtilities
						.toDate(VRDateParser.format(ACDateUtilities.addMonth(
								getTargetDate(), 1), "yyyy/MM")
								+ "/" + getVisitNextMonth1().getText()));
			}
			if (!getVisitNextMonth2().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO2", ACCastUtilities
						.toDate(VRDateParser.format(ACDateUtilities.addMonth(
								getTargetDate(), 1), "yyyy/MM")
								+ "/" + getVisitNextMonth2().getText()));
			}
			if (!getVisitNextMonth3().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO3", ACCastUtilities
						.toDate(VRDateParser.format(ACDateUtilities.addMonth(
								getTargetDate(), 1), "yyyy/MM")
								+ "/" + getVisitNextMonth3().getText()));
			}
			if (!getVisitNextMonth4().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO4", ACCastUtilities
						.toDate(VRDateParser.format(ACDateUtilities.addMonth(
								getTargetDate(), 1), "yyyy/MM")
								+ "/" + getVisitNextMonth4().getText()));
			}
			if (!getVisitNextMonth5().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO5", ACCastUtilities
						.toDate(VRDateParser.format(ACDateUtilities.addMonth(
								getTargetDate(), 1), "yyyy/MM")
								+ "/" + getVisitNextMonth5().getText()));
			}
			if (!getVisitNextMonth6().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO6", ACCastUtilities
						.toDate(VRDateParser.format(ACDateUtilities.addMonth(
								getTargetDate(), 1), "yyyy/MM")
								+ "/" + getVisitNextMonth6().getText()));
			}

			// SQL�擾�֐��ւ̓n���p�����[�^(���R�[�h) sqlParam�𐶐�����B
			// VRMap sqlParam = new VRHashMap();
			// �p�b�V�u�^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();
			// ���p�b�V�u�^�X�N�̓o�^
			// processMode�̒l���`�F�b�N����B
			// ����×{�Ǘ��w�������X�V�p�̃p�b�V�u�^�X�N��o�^����B
			getPassiveChecker().addPassiveUpdateTask(getPASSIVE_CHECK_KEY());

			// ���p�b�V�u�`�F�b�N�̎��s
			// �p�b�V�u�`�F�b�N�����s����B
			if (!getPassiveChecker().passiveCheck(dbm)) {
				// �p�b�V�u�G���[������ꍇ
				// �p�b�V�u�G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
				QkanMessageList.getInstance()
						.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();

				// ���������[���o�b�N����B
				dbm.rollbackTransaction();
				// �����𒆒f����B(�ُ�I��)
				return false;
			}

			// �p�b�V�u�G���[���Ȃ��ꍇ
			// �������p������B
			// ���ݑ�×{�����̃|�C���g�E����×{�Ǘ��w�������̓o�^
			// ����×{�Ǘ��w�������X�V�p��SQL�����擾����B
			// �擾����SQL���𔭍s����B
			dbm.executeUpdate(getSQL_UPDATE_KYOTAKU_RYOYO(kyotakuDataMap));

			// ���R�~�b�g/���[���o�b�N
			// ��L��A��SQL���s�����ŃG���[���Ȃ������ꍇ
			// �������R�~�b�g����B
			dbm.commitTransaction();
			// ��ʂ̏��������s���B
			doInitialize();

			// �����������s���B
			doFind();

			// �������I������B(����I��)
			return true;
		} catch (Exception sqlEx) {
			// SQL���s�����ŃG���[���������ꍇ
			// ���������[���o�b�N����B
			sqlEx.printStackTrace();

			dbm.rollbackTransaction();
			// �����𒆒f����B(�ُ�I��)
			throw sqlEx;
		}
	}

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkValidInput() throws Exception {
		// �����̓`�F�b�N

        // [ID:0000547][Masahiko Higuchi] 2009/08 del begin 2009�N�x�v�]�Ή�
//		// ���쐬�N���E�����̓`�F�b�N
//		// ��ʂ́u�쐬�N��(createDateZaitaku)�v�̒l���`�F�b�N����B
//		if (!ACTextUtilities.isNullText(getCreateDateZaitaku().getText())) {
//			// ���͂���Ă���ꍇ
//			// �������p������B
//		} else {
//			// �����͂̏ꍇ
//			// �G���[���b�Z�[�W��\������B
//			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("�쐬�N��");
//			// createDateZaitaku�Ƀt�H�[�J�X�𓖂Ă�B
//            getTabsArea().setSelectedIndex(1);
//			getCreateDateZaitaku().requestFocus();
//
//			// �߂�l�Ƃ���false��Ԃ��A�����𒆒f����B
//			return false;
//		}
//
//		// ���쐬�N���E�s���`�F�b�N
//		// ��ʂ́u�쐬�N��(createDateZaitaku)�v�̒l���`�F�b�N����B
//		if (getCreateDateZaitaku().isValidDate()) {
//			// ����l�̏ꍇ
//			// �������p������B
//		} else {
//			// �ُ�l�̏ꍇ
//			// �G���[���b�Z�[�W��\������B
//			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�쐬�N����");
//			// createDateZaitaku�Ƀt�H�[�J�X�𓖂Ă�B
//            getTabsArea().setSelectedIndex(1);
//			getCreateDateZaitaku().requestFocus();
//			// �߂�l�Ƃ���false��Ԃ��A�����𒆒f����B
//			return false;
//		}
        // [ID:0000547][Masahiko Higuchi] 2009/08 del end

		// ���쐬�N�����E�����̓`�F�b�N
		// ��ʂ́u�쐬�N����(createDateKyotaku)�v�̒l���`�F�b�N����B
		if (!ACTextUtilities.isNullText(getCreateDateKyotaku().getText())) {
			// ���͂���Ă���ꍇ
			// �������p������B
		} else {
			// �����͂̏ꍇ
			// �G���[���b�Z�[�W��\������B
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("�쐬�N����");

			// createDateKyotaku�Ƀt�H�[�J�X�𓖂Ă�B
            getTabsArea().setSelectedIndex(2);
            getKyotakuPoints().setSelectedIndex(0);
			getCreateDateKyotaku().requestFocus();
			// �߂�l�Ƃ���false��Ԃ��A�����𒆒f����B
			return false;
		}

		// ���쐬�N�����E�s���`�F�b�N
		// ��ʂ́u�쐬�N����(createDateKyotaku)�v�̒l���`�F�b�N����B
		if (getCreateDateKyotaku().isValidDate()) {
			// ����l�̏ꍇ
			// �������p������B
		} else {
			// �ُ�l�̏ꍇ
			// �G���[���b�Z�[�W��\������B
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�쐬�N������");

			// createDateKyotaku�Ƀt�H�[�J�X�𓖂Ă�B
            getTabsArea().setSelectedIndex(2);
            getKyotakuPoints().setSelectedIndex(0);
			getCreateDateKyotaku().requestFocus();
			// �߂�l�Ƃ���false��Ԃ��A�����𒆒f����B
			return false;
		}

		// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 add begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
		// ���쐬�N�����E�s���`�F�b�N�i�Ώ۔N���ƈقȂ�쐬�N���̏ꍇ�j
		// ��ʂ́u�쐬�N����(createDateKyotaku)�v�̒l���`�F�b�N����B
		String strCreateDateYM = VRDateParser.format(getCreateDateKyotaku().getDate(), "yyyy/MM");
		String strTargetDateYM = VRDateParser.format(getTargetDate(), "yyyy/MM");
		if (strCreateDateYM.compareTo(strTargetDateYM) == 0) {
			// ����l�̏ꍇ
			// �������p������B
		} else {
			// �ُ�l�̏ꍇ
			// ���[�j���O���b�Z�[�W��\������B
		    if (QkanMessageList.getInstance().QC005_WARNING_OF_CREATE_DATE() != ACMessageBox.RESULT_OK) {
				// createDateKyotaku�Ƀt�H�[�J�X�𓖂Ă�B
	            getTabsArea().setSelectedIndex(2);
	            getKyotakuPoints().setSelectedIndex(0);
				getCreateDateKyotaku().requestFocus();
				// �߂�l�Ƃ���false��Ԃ��A�����𒆒f����B
				return false;
		    }
		}
		// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 add end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
		
		// �������̖K���1�E�s���`�F�b�N
		// ��ʂ́u�����̖K���1(visitThisMonth1)�v�̒l�����͂���Ă��邩�`�F�b�N����B
		if (ACTextUtilities.isNullText(getVisitThisMonth1().getText())) {
			// ���͂���Ă��Ȃ��ꍇ
			// �����s��Ȃ��B
		} else {
			// ���͂���Ă���ꍇ

			// ��ʂ́u�����̖K���1(visitThisMonth1)�v����A�Ώ۔N����N�A�y�ь��Ƃ������t���쐬����B
			if (VRDateParser.isValid(VRDateParser.format(getTargetDate(),
					"yyyy/MM")
					+ "/" + getVisitThisMonth1().getText())) {
				// ����l�̏ꍇ
				// �������p������B
			} else {
				// �ُ�l�̏ꍇ
				// �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����̖K�����");
				// visitThisMonth1�Ƀt�H�[�J�X�𓖂Ă�B
                getTabsArea().setSelectedIndex(1);
				getVisitThisMonth1().requestFocus();
				// �߂�l�Ƃ���false��Ԃ��A�����𒆒f����B
				return false;
			}
		}
		// �������̖K���2�`6�E�s���`�F�b�N
		// �u�����̖K���1�v�Ɠ��l�̃`�F�b�N���A�u�����̖K���2�`6�v�ɑ΂��čs���B
		if (ACTextUtilities.isNullText(getVisitThisMonth2().getText())) {
			// ���͂���Ă��Ȃ��ꍇ �����s��Ȃ��B
		} else {
			// ���͂���Ă���ꍇ
			if (VRDateParser.isValid(VRDateParser.format(getTargetDate(),
					"yyyy/MM")
					+ "/" + getVisitThisMonth2().getText())) {
				// ����l�̏ꍇ �������p������B
			} else {
				// �ُ�l�̏ꍇ �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����̖K�����");
                getTabsArea().setSelectedIndex(1);
				getVisitThisMonth2().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitThisMonth3().getText())) {
			// ���͂���Ă��Ȃ��ꍇ �����s��Ȃ��B
		} else {
			// ���͂���Ă���ꍇ
			if (VRDateParser.isValid(VRDateParser.format(getTargetDate(),
					"yyyy/MM")
					+ "/" + getVisitThisMonth3().getText())) {
				// ����l�̏ꍇ �������p������B
			} else {
				// �ُ�l�̏ꍇ
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����̖K�����");
                getTabsArea().setSelectedIndex(1);
                getVisitThisMonth3().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitThisMonth4().getText())) {
			// ���͂���Ă��Ȃ��ꍇ
		} else {
			// ���͂���Ă���ꍇ
			if (VRDateParser.isValid(VRDateParser.format(getTargetDate(),
					"yyyy/MM")
					+ "/" + getVisitThisMonth4().getText())) {
				// ����l�̏ꍇ
			} else {
				// �ُ�l�̏ꍇ
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����̖K�����");
                getTabsArea().setSelectedIndex(1);
                getVisitThisMonth4().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitThisMonth5().getText())) {
			// ���͂���Ă��Ȃ��ꍇ
		} else {
			// ���͂���Ă���ꍇ
			if (VRDateParser.isValid(VRDateParser.format(getTargetDate(),
					"yyyy/MM")
					+ "/" + getVisitThisMonth5().getText())) {
				// ����l�̏ꍇ
			} else {
				// �ُ�l�̏ꍇ
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����̖K�����");
                getTabsArea().setSelectedIndex(1);
                getVisitThisMonth5().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitThisMonth6().getText())) {
			// ���͂���Ă��Ȃ��ꍇ
		} else {
			// ���͂���Ă���ꍇ
			if (VRDateParser.isValid(VRDateParser.format(getTargetDate(),
					"yyyy/MM")
					+ "/" + getVisitThisMonth6().getText())) {
				// ����l�̏ꍇ
			} else {
				// �ُ�l�̏ꍇ
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����̖K�����");
                getTabsArea().setSelectedIndex(1);
                getVisitThisMonth6().requestFocus();
				return false;
			}
		}
		// �������̖K��\��1�E�s���`�F�b�N
		// ��ʂ́u�����̖K��\��1(visitNextMonth1)�v�̒l�����͂���Ă��邩�`�F�b�N����B
		if (ACTextUtilities.isNullText(getVisitNextMonth1().getText())) {
			// ���͂���Ă��Ȃ��ꍇ
			// �����s��Ȃ��B
		} else {
			// ���͂���Ă���ꍇ
			// ��ʂ́u�����̖K��\��1(visitNextMonth1)�v����A�Ώ۔N���̗�����N�A�y�ь��Ƃ������t���쐬����B

			if (VRDateParser.isValid(VRDateParser.format(ACDateUtilities
					.addMonth(getTargetDate(), 1), "yyyy/MM")
					+ "/" + getVisitNextMonth1().getText())) {
				// ����l�̏ꍇ
				// �������p������B
			} else {
				// �ُ�l�̏ꍇ
				// �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����̖K��\���");
				// visitNextMonth1�Ƀt�H�[�J�X�𓖂Ă�B
                getTabsArea().setSelectedIndex(1);
                getVisitNextMonth1().requestFocus();
				// �߂�l�Ƃ���false��Ԃ��A�����𒆒f����B
				return false;
			}
		}

		// �������̖K��\��2�`6�E�s���`�F�b�N
		// �u�����̖K��\��1�v�Ɠ��l�̃`�F�b�N���A�u�����̖K��\��2�`6�v�ɑ΂��čs���B
		if (ACTextUtilities.isNullText(getVisitNextMonth2().getText())) {
			// ���͂���Ă��Ȃ��ꍇ
		} else {
			if (VRDateParser.isValid(VRDateParser.format(ACDateUtilities
					.addMonth(getTargetDate(), 1), "yyyy/MM")
					+ "/" + getVisitNextMonth2().getText())) {
				// ����l�̏ꍇ �������p������B
			} else {
				// �ُ�l�̏ꍇ �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����̖K��\���");
                getTabsArea().setSelectedIndex(1);
                getVisitNextMonth2().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitNextMonth3().getText())) {
			// ���͂���Ă��Ȃ��ꍇ
		} else {
			if (VRDateParser.isValid(VRDateParser.format(ACDateUtilities
					.addMonth(getTargetDate(), 1), "yyyy/MM")
					+ "/" + getVisitNextMonth3().getText())) {
				// ����l�̏ꍇ �������p������B
			} else {
				// �ُ�l�̏ꍇ �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����̖K��\���");
                getTabsArea().setSelectedIndex(1);
                getVisitNextMonth3().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitNextMonth4().getText())) {
			// ���͂���Ă��Ȃ��ꍇ
		} else {
			if (VRDateParser.isValid(VRDateParser.format(ACDateUtilities
					.addMonth(getTargetDate(), 1), "yyyy/MM")
					+ "/" + getVisitNextMonth4().getText())) {
				// ����l�̏ꍇ �������p������B
			} else {
				// �ُ�l�̏ꍇ �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����̖K��\���");
                getTabsArea().setSelectedIndex(1);
                getVisitNextMonth4().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitNextMonth5().getText())) {
			// ���͂���Ă��Ȃ��ꍇ
		} else {
			if (VRDateParser.isValid(VRDateParser.format(ACDateUtilities
					.addMonth(getTargetDate(), 1), "yyyy/MM")
					+ "/" + getVisitNextMonth5().getText())) {
				// ����l�̏ꍇ �������p������B
			} else {
				// �ُ�l�̏ꍇ �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����̖K��\���");
                getTabsArea().setSelectedIndex(1);
                getVisitNextMonth5().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitNextMonth6().getText())) {
			// ���͂���Ă��Ȃ��ꍇ
		} else {
			// if (VRDateParser.isValid(VRDateParser.format(getTargetDate(),
			// "yyyy/MM")
			// + "/" + getVisitNextMonth6().getText())) {
			// // ����l�̏ꍇ �������p������B
			// } else {
			// // �ُ�l�̏ꍇ �G���[���b�Z�[�W��\������B
			// QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����̖K��\���");
			// getVisitNextMonth6().requestFocus();
			// return false;
			// }
			// ���͂���Ă���ꍇ
			if (VRDateParser.isValid(VRDateParser.format(ACDateUtilities
					.addMonth(getTargetDate(), 1), "yyyy/MM")
					+ "/" + getVisitNextMonth6().getText())) {
				// ����l�̏ꍇ �������p������B
			} else {
				// �ُ�l�̏ꍇ �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����̖K��\���");
                getTabsArea().setSelectedIndex(1);
                getVisitNextMonth6().requestFocus();
				return false;
			}
		}
		return true;
	}
	
    /**
     * ��Ë@�֏��A���\���Ɋւ��鏈��
     */
    protected void medicalInstitusionActionPerformed(ActionEvent e) throws Exception {
        // �����ϐ� medicalMap�𐶐�����
        VRMap medicalMap = new VRHashMap();
        // �I�����ꂽ��Ë@�֏��̃��R�[�h���擾����B
        Object obj = getMedicalInstitusion().getSelectedModelItem();
        // �擾�������R�[�h�� medicalMap �Ɋi�[����
        if(obj != null){
            medicalMap = (VRMap)obj;
        // medicalMap �� providerAndMedicaiInfoArea(��Ë@�֏��̈�j�ɐݒ肷��B
            getProviderAndMedicaiInfoArea().setSource(medicalMap);
        //      �ݒ肵��������ʂɓW�J����B
            getProviderAndMedicaiInfoArea().bindSource();
        }
    }
    
    /**
     * ���Ə��R���{�I�����̏���
     */
    protected void providerNameActionPerformed(ActionEvent e) throws Exception {
        //Map�𐶐�
        VRMap comboItemMap = new VRHashMap();
        //���ݑI�𒆂̃R���{���烌�R�[�h���擾
        comboItemMap = (VRMap)getProviderName().getSelectedModelItem();
        
        if(comboItemMap != null){
            //���x���������擾
            VRList senmoninList = getDBManager().executeQuery(
                    getSQL_GET_CARE_MANAGER(comboItemMap));
            
            if(senmoninList != null && senmoninList.size() > 0){
                for(int i = 0; i < senmoninList.size(); i++){
                    VRMap map = new VRHashMap();
                    map = (VRMap)senmoninList.getData(i);
                    //�����̖��O���擾����������������B
                    map.setData("STAFF_NAME", QkanCommon.toFullName(
                            ACCastUtilities.toString(map
                                    .getData("STAFF_FAMILY_NAME")),
                            ACCastUtilities.toString(map
                                    .getData("STAFF_FIRST_NAME"))));
                }
            }
            //�o�C���h�p�X��ݒ�
            comboItemMap.setData("SENMONIN",senmoninList);
            //��ʂɓW�J
            getSenmonin().setModelSource(comboItemMap);
            getSenmonin().bindModelSource();
        }
        
    }
    /**
     * �f�[�^�̈���ς݂̗L�����`�F�b�N���ĕԂ��܂��B
     * 
     * @return True�F����ς�
     * @author Masahiko Higuchi
     * @since Ver 5.4.1  
     */
    public boolean isPrintFinish() throws Exception {
        // �p�����[�^�[�̐ݒ�
        VRMap sqlParam = new VRHashMap();
        VRBindPathParser.set("PATIENT_ID",sqlParam,ACCastUtilities.toInteger(getPatientID()));
        VRBindPathParser.set("TARGET_DATE",sqlParam,getTargetDate());
        // SQL���s
        VRList resultList = getDBManager().executeQuery(getSQL_GET_FINISH_FLAG(sqlParam));
        
        if(resultList != null && !resultList.isEmpty()){
            VRMap result = (VRMap)resultList.getData(0);
            // �擾����B
            int index = ACCastUtilities.toInt(result.getData("FINISH_FLAG"),0);
            // ����ς݂̏ꍇ
            if(index == 1){
                return true;
            }
        }

        return false;
    }

    /**
     * �����̋���×{�Ǘ��w���̎��уf�[�^��ǂݍ��݉�ʓW�J�p�ɐ��`���܂��B
     * 
     * [ID:0000431]
     * @return ��ʓW�J�p���уf�[�^
     * @author Masahiko Higuchi
     * @since Ver.5.4.9
     */
    public VRMap getKyotakuResult() throws Exception {
        // �ԋp�p�̃}�b�v
        VRMap returnResult = new VRHashMap();
        // SQL���p�̒l��ݒ肷��B
        Date firstDate =  ACDateUtilities.toFirstDayOfMonth(getTargetDate());
        Date lastDate =  ACDateUtilities.toLastDayOfMonth(getTargetDate());
        VRMap sqlParam = new VRHashMap();
        VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities.toInteger(getPatientID()));
        VRBindPathParser.set("TARGET_DATE_START", sqlParam, firstDate);
        VRBindPathParser.set("TARGET_DATE_END", sqlParam, lastDate);
        // ���ю擾
        VRList resultList = getDBManager().executeQuery(getSQL_GET_SERVICE_RESULT_DATA(sqlParam));
        
        if(resultList != null && !resultList.isEmpty()){
            // ���[�v���W�J�p�̃f�[�^�ɐ��`����
            for(int i=0; i < resultList.size(); i++){
                VRMap map = (VRMap)resultList.getData(i);
                // 6�ȏ�͐ݒ�s�\�Ȃ̂ŃX�L�b�v
                if(i==6) {
                    break;
                }
                // ���`����
                VRBindPathParser.set("VISIT_THIS_MONTH_NO"
                        + ACCastUtilities.toString(i + 1), returnResult, map.getData("EXTRACT_SERVICE_DAY"));                
            }
            // �擾�ł����f�[�^�ȊO�͋�Ń��R�[�h�𐶐�
            for (int j = 1; j <= 6; j++) {
                String bindKey = "VISIT_THIS_MONTH_NO"
                        + ACCastUtilities.toString(j);
                if (!returnResult.containsKey(bindKey)) {
                    VRBindPathParser.set(bindKey, returnResult, "");
                }
            }
        }
        // �l�̕ԋp
        return returnResult;
    }

    /**
     * ���ѓǍ��݃{�^���������̏���
     * 
     * [ID:0000431]
     * @author Masahiko Higuchi
     * @since Ver.5.4.9
     */
    protected void resultReadButtonActionPerformed(ActionEvent e) throws Exception {

        VRDateFormat vf = new VRDateFormat("ggge�NM��");
        // ���b�Z�[�W�\�z
        String message = String.valueOf(vf.format(getTargetDate()) + "�x");
        String serviceName = "����×{�Ǘ��w��";
        // ���b�Z�[�W�擾
        int msgID = QkanMessageList.getInstance().WARNING_OF_RESULT_SERVICE(
                message, serviceName);
        if (msgID == ACMessageBox.RESULT_YES) {
            // ���ю擾
            VRMap result = getKyotakuResult();
            // �擾�ł��Ȃ��ꍇ�̓��b�Z�[�W
            if(result == null || result.isEmpty()) {
                QkanMessageList.getInstance().ERROR_OF_RESULT_READ_NOTHING(serviceName);
                return;
            }
            // ��ʓW�J����
            getContents().setSource(result);
            getContents().bindSource();
        }
        
    }

    /**
     * �u����×{�Ǘ��w�������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * ���p�҂ƑΏ۔N��������͂����쐬�N������񂪑��݂��邩���`�F�b�N���܂��B
     * @throws Exception
     *             ������O
     * @author Shinobu Hitaka
     * @since Ver.6.2.3
     */
    protected Date getUpdateTargetDate() throws Exception {
    	
    	Date targetDate = null;
    	
        // ����×{�Ǘ��w���������擾���s���B

        // �擾�̂��߂�HashMap�Fparam�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
        VRMap sqlParam = new VRHashMap();

        // KEY�FPATIENT_ID�@VALUE�FpatientId
        VRBindPathParser.set("PATIENT_ID", sqlParam,
                new Integer(getPatientID()));
        // KEY�FTARGET_DATE_START VALUE�FtargetDate �̌���
        sqlParam.setData("TARGET_DATE_START",
                ACDateUtilities.toFirstDayOfMonth(getTargetDate()));
        // KEY�FTARGET_DATE_START VALUE�FtargetDate �̌���
        sqlParam.setData("TARGET_DATE_END",
                ACDateUtilities.toLastDayOfMonth(getTargetDate()));

		// kyotakuData�ɁA��ʂ��璊�o���������i�[����B
        VRMap kyotakuData = getKyotakuData();
		getContents().setSource(kyotakuData);
		getContents().applySource();
		
        // CREATE_DATE_KYOTAKU VALUE�FcreateDate
        sqlParam.setData("CREATE_DATE_KYOTAKU",
        		kyotakuData.getData("CREATE_DATE_KYOTAKU"));

        // ����×{�Ǘ��w�����������擾�����ݗL����Ԃ��B
        String strSql = getSQL_GET_KYOTAKU_RYOYO_CREATEDATE(sqlParam);
        VRList kyotakuList = getDBManager().executeQuery(strSql);
        
        if(kyotakuList != null && kyotakuList.size() > 0){
            for(int i = 0; i < kyotakuList.size(); i++){
                VRMap map = new VRHashMap();
                map = (VRMap)kyotakuList.getData(i);
                //�L�[�ƂȂ�Ώ۔N�������擾����
                targetDate = ACCastUtilities.toDate(map.getData("TARGET_DATE"));
            }
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
    			// �p�b�V�u�L�[��o�^����B
    			// reservedPassive(PASSIVE_CHECK_KEY, (�擾�������R�[�h�W��));
    			getPassiveChecker().clearReservedPassive();
    			getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), kyotakuList);
            }
        }
        
        return targetDate;
    }
    
    /**
     * �u����×{�Ǘ��w�������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * ���p�҂ƑΏ۔N��������͂����쐬�N������񂪑��݂��邩���`�F�b�N���܂��B
     * @throws Exception
     *             ������O
     * @author Shinobu Hitaka
     * @since Ver.6.2.3
     */
    protected Date getInsertTargetDate() throws Exception {
        // �V�K�o�^�p�̑Ώ۔N�������擾����
    	
        // ����×{�Ǘ��w���������擾���s���B

        // �擾�̂��߂�HashMap�Fparam�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
        VRMap sqlParam = new VRHashMap();

        // KEY�FPATIENT_ID�@VALUE�FpatientId
        VRBindPathParser.set("PATIENT_ID", sqlParam,
                new Integer(getPatientID()));
        // KEY�FTARGET_DATE_START VALUE�FtargetDate �̌���
        sqlParam.setData("TARGET_DATE_START",
                ACDateUtilities.toFirstDayOfMonth(getTargetDate()));
        // KEY�FTARGET_DATE_START VALUE�FtargetDate �̌���
        sqlParam.setData("TARGET_DATE_END",
                ACDateUtilities.toLastDayOfMonth(getTargetDate()));

        // ����×{�Ǘ��w�����������擾�����ݗL����Ԃ��B
        String strSql = getSQL_GET_KYOTAKU_RYOYO_CREATEDATE(sqlParam);
        VRList kyotakuList = getDBManager().executeQuery(strSql);
        
        // �o�^����Ă��Ȃ����t���擾����B
        int maxDay = ACDateUtilities.getDayOfMonth(ACDateUtilities.toLastDayOfMonth(getTargetDate()));
        int targetDay = 1;
        int cnt = 0;
        
        // �Ώ۔N�����̍ő�{�P���擾����
        if(kyotakuList != null && kyotakuList.size() > 0){
            for(int i = 0; i < kyotakuList.size(); i++){
                //�L�[�ƂȂ�Ώ۔N�������擾����
                int listDay = ACDateUtilities.getDayOfMonth(
                        ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE", (VRMap) kyotakuList.getData(i))));
                if (listDay > targetDay) {
                	targetDay = listDay;
                }
            }
	        targetDay = targetDay + 1;
	    	
	    	// �����𒴂�����r���̓o�^����Ă��Ȃ�����T��
	    	if (targetDay > maxDay) {
		    	targetDay = 1;
		    	cnt = 0;
		        for (cnt = 1; cnt <= maxDay; cnt++) {
		        	boolean findFlg = false;
		        	for(int i = 0; i < kyotakuList.size(); i++){
		                int listDay = ACDateUtilities.getDayOfMonth(
		                        ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE", (VRMap) kyotakuList.getData(i))));
		                if (listDay == cnt) {
		                	findFlg = true;
		                    break;
		                }
		            }
		        	if (!findFlg) {
		        		break;
		        	}
		        }
		        targetDay = cnt;
	    	}
        }
        
        // �Ώی��̓��������ő�o�^�\�����Ƃ��邽�߁A����ȏ�͐V�K�o�^�ł��Ȃ��B
        if (targetDay > maxDay) {
            return null;
        } else {
        	Date targetDate = ACDateUtilities.createDate(
                    ACDateUtilities.getYear(getTargetDate()), ACDateUtilities.getMonth(getTargetDate()), targetDay);
        	return targetDate;
        }

    }

    /**
     * �u����×{�Ǘ��w�������o�^�܂��͍X�V�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * ���p�҂ƑΏ۔N��������͂����쐬�N������񂪑��݂��邩���`�F�b�N���܂��B
     * �@���݂���ꍇ�@�F�X�V�m�F��ʂ�\�����A�X�V�������s���܂��B
     * �@���݂��Ȃ��ꍇ�F�V�K�o�^�������s���܂��B
     * ���ꗗ����J�ڂ������̏�ԂɊւ�炸�A�쐬�N�����̗L���ŏ��������肵�܂��B
	 * @param bDispMsg �������b�Z�[�W�\���L���itrue:�\���^false:��\���j
     * @throws Exception
     *             ������O
     * @author Shinobu Hitaka
     * @since Ver.6.2.3
     */
    protected boolean doInsertOrUpdate(boolean bDispMsg) throws Exception {
    	
		// ���f�[�^��DB�ɍX�V
		// �����̓`�F�b�N
		// ���̓`�F�b�N���s���B
		if (!checkValidInput()) {

			// �G���[������ꍇ
			// �����𒆒f����B
			return false;
		}
        
		//�����Ώ۔N���A�쐬�N�����̏�񑶍݃`�F�b�N
		Date wkTargetDate = getUpdateTargetDate();
		if(wkTargetDate != null) {
			//���ݕҏW���̏��͊m�F��ʂ�\�����Ȃ�
			if(ACDateUtilities.compareOnDay(getTargetDate(),wkTargetDate) != 0) {
				//�X�V
				//�X�V�m�F��ʂ�\������B
				int msgID = QkanMessageList.getInstance().QC005_WARNING_OF_HISTORY_KYOTAKU_RYOYO();
				if(msgID != ACMessageBox.RESULT_YES){
					// �X�V���Ȃ��ꍇ
					return false;
				}
				
				//�Ώ۔N�������X�V�p�ɐݒ肷��
				setTargetDate(wkTargetDate);
				setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
				
			}
			// ����������m�F����
			if(isPrintFinish()){
				int msgID = QkanMessageList.getInstance().QC005_WARNING_OF_PRINTED_KYOTAKU_RYOYO("����×{�Ǘ��w����");
				// �X�V���Ȃ��ꍇ
				if(msgID != ACMessageBox.RESULT_YES){
					return false;
				}
			}
		} else {
			//�V�K
			//�Ώ۔N������V�K�p�ɐݒ肷��
			wkTargetDate = getInsertTargetDate();
			if (wkTargetDate != null) {
				setTargetDate(wkTargetDate);
				setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
			}else{
				QkanMessageList.getInstance().QC005_ERROR_OF_MAX_KYOTAKU_RYOYO();
				return false;
			}
		}
		
		// �G���[���Ȃ��ꍇ
		// �������p������B
		// ���X�V����
		// �X�V�������s���B
        //����ɏI�������ꍇ
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			if(doInsert()){
				// ���������ʒm���b�Z�[�W��\������B�����b�Z�[�WID = UPDATE_SUCCESSED
				if (bDispMsg == true) {
					QkanMessageList.getInstance().INSERT_SUCCESSED();
				}
			}else{
				return false;
			}
		} else {
			if(doUpdate()){
				// ���������ʒm���b�Z�[�W��\������B�����b�Z�[�WID = UPDATE_SUCCESSED
				if (bDispMsg == true) {
					QkanMessageList.getInstance().UPDATE_SUCCESSED();
				}
			}else{
				return false;
			}
		}
		
		return true;
    }
    

}
