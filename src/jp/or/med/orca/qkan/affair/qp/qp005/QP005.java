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
 * �J����: �A�� ��C
 * �쐬��: 2006/02/13  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���уf�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (005)
 * �v���O���� ���׏��ڍוҏW (QP005)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp005;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.im.InputSubset;
import java.text.Format;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewerCustomCell;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001ReTotal;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjTankaNotFoundException;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACCharacterConverter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * ���׏��ڍוҏW(QP005)
 */
public class QP005 extends QP005Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QP005() {
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

		// ���L�̓n��p�����[�^��ޔ�����B
		VRMap parameters = affair.getParameters();

		// �EpatientId KEY�FPATIENT_ID
		if (VRBindPathParser.has("PATIENT_ID", parameters)) {
			setPatientId(ACCastUtilities.toInt(parameters.getData("PATIENT_ID")));
		}
		// �EtargetDate KEY�FTARGET_DATE
		if (VRBindPathParser.has("TARGET_DATE", parameters)) {
			setTargetDate(ACCastUtilities.toDate(parameters.getData("TARGET_DATE")));
		}
		// �EclaimDate KEY�FCLAIM_DATE
		if (VRBindPathParser.has("CLAIM_DATE", parameters)) {
			setClaimDate(ACCastUtilities.toDate(parameters.getData("CLAIM_DATE")));
		}

		// �EproviderId KEY�FPROVIDER_ID
		if (VRBindPathParser.has("PROVIDER_ID", parameters)) {
			setProviderId(ACCastUtilities.toString(parameters.getData("PROVIDER_ID")));
		}
		// �EclaimStyleType KEY�FCLAIM_STYLE_TYPE
		if (VRBindPathParser.has("CLAIM_STYLE_TYPE", parameters)) {
			setClaimStyleType(ACCastUtilities.toInt(parameters.getData("CLAIM_STYLE_TYPE")));
		}
		// �ElistIndex KEY�FLIST_INDEX
		if (VRBindPathParser.has("LIST_INDEX", parameters)) {
			setListIndex(ACCastUtilities.toInteger(parameters.getData("LIST_INDEX")));
		}
		// �EinsuredId KEY�FINSURED_ID
		if (VRBindPathParser.has("INSURED_ID", parameters)) {
			setInsuredId(ACCastUtilities.toString(parameters.getData("INSURED_ID")));
		}
		
		switch (getClaimStyleType()){
			case FORMAT_STYLE4:
			case FORMAT_STYLE42:
			case FORMAT_STYLE9:
				break;
				
			//��L�l���ȊO�ł́A����×{��^�u����������B
			default:
			    getEtcInfoTabs().remove(getRecuperationInfos());
			    break;
		}

		//[ID:0000429][Shin Fujihara] 2009/07 add start 2009�N�x�Ή�
		//�T�[�r�X�ǉ��{�^������
		switch (getClaimStyleType()){
		case FORMAT_STYLE3:
		case FORMAT_STYLE32:
		case FORMAT_STYLE4:
		case FORMAT_STYLE42:
		case FORMAT_STYLE5:
		case FORMAT_STYLE52:
		case FORMAT_STYLE8:
		case FORMAT_STYLE9:
		case FORMAT_STYLE10:
			break;
		default:
			setState_TYPE9();
			break;
		}
		
		//2009.8.10 �b��I�Ƀ{�^����\���ŁA�@�\�𕕈󂷂�
		getServiceDelButton().setVisible(false);
		getServiceAddButton().setVisible(false);
		//[ID:0000429][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
		
		// �p�b�V�u�`�F�b�N�̃L�[���`����B
		// TABLE�FCLAIM
		// �L�[�FCLAIM_ID
		// �t�H�[�}�b�g�F���l
		// �N���C�A���g�^�C���t�B�[���h�FLAST_TIME
		// �T�[�o�^�C���t�B�[���h�FLAST_TIME
		setPASSIVE_CHECK_KEY(new ACPassiveKey("CLAIM", new String[] { "CLAIM_ID" }, new Format[] { null }, "LAST_TIME", "LAST_TIME"));

		// �f�[�^���擾���A��ʂɓW�J����B
		doFind();
		
		//[ID:0000567][Shin Fujihara] 2009/12/10 add begin 2009�N�x�Ή�
		if (getTableClaimList2().size() < 2) {
			//�폜�{�^�����g�p�s�\�ɂ���
			setState_TYPE11();
		} else {
			setState_TYPE10();
		}
		//[ID:0000567][Shin Fujihara] 2009/12/10 add end 2009�N�x�Ή�
		
// 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
		if (getTableClaimList8().size() < 2) {
			//�폜�{�^�����g�p�s�\�ɂ���
			setState_TYPE13();
		} else {
			setState_TYPE12();
		}
		// H2704�ȍ~�łȂ���΁A���׏��i�Z���n����j�^�u��\�����Ȃ�
		//if (!(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2704,
		//        getTargetDate()) < 1)) {
		//	getEtcInfoTabs().remove(getDetailsJushotiTokureiInfos());
		//}
// 2014/12/24 [Yoichiro Kamei] add - end
		
		//[ID:0000429][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
		//�X�i�b�v�V���b�g�擾
		doSnap();
		//[ID:0000429][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		// �Ō�ɕۑ�����Ă���A��ʃe�[�u���̃f�[�^���ύX����Ă���ꍇ�itableChangeFlg�̒l��1�̏ꍇ�j
		// �m�F���b�Z�[�W��\������B
		//[ID:0000429][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
		//if (getTableChangeFlg() == ON) {
		if (isModified() ) {
		//[ID:0000429][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
			switch(QkanMessageList.getInstance().WARNING_OF_UPDATE_ON_MODIFIED()){
			case ACMessageBox.RESULT_OK:

				// �E���b�Z�[�WID�FWARNING_OF_UPDATE_ON_MODIFIED
				// �u�͂��v��I�������ꍇ
				// �ۑ��������s���B
				if (doSave()) {
					// �ۑ�����������I�������ꍇ
					// �������b�Z�[�W��\������B
//					QkanMessageList.getInstance().UPDATE_SUCCESSED();
					// �E���b�Z�[�WID�FUPDATE_SUCCESSED
				} else {
					// �ۑ�����������I�����Ȃ������ꍇ
					// �����𒆒f����B(�I��)
					return false;
				}
				break;
			case ACMessageBox.RESULT_CANCEL:
				// �u�͂��v�u�������v�ȊO��I�������ꍇ
				// �����𒆒f����i�������Ȃ��j�B
				return false;
			}
		}
		// �O��ʂɑJ�ڂ���B
		// ����ʂɁuQP002 ���[(�l��)�E���Ə��I���v��ʂ���J�ڂ��Ă���ꍇ
		// �ȉ���n��p�����[�^�Ƃ��āuQP002 ���[(�l��)�E���Ə��I���v��ʂɑJ�ڂ���B
		if (ACFrame.getInstance().getBackAffair().getClassName().equals(QP002)) {
			// �EKEY�FPATIENT_ID VALUE�FpatientId
			parameters.setData("PATIENT_ID", ACCastUtilities.toString(getPatientId()));
			// �EKEY�FCLAIM_DATE VALUE�FclaimDate
			parameters.setData("CLAIM_DATE", getClaimDate());
			// �EKEY�FLIST_INDEX VALUE�FlistIndex
			parameters.setData("LIST_INDEX", getListIndex());
		}

		// ����ʂɁuQP004 ���׏���{���ҏW�v��ʂ���J�ڂ��Ă���ꍇ
		// �ȉ���n��p�����[�^�Ƃ��āuQP004 ���׏���{���ҏW�v��ʂɑJ�ڂ���B
		if (ACFrame.getInstance().getBackAffair().getClassName().equals(QP004)) {
			// �EKEY�FPATIENT_ID VALUE�FpatientId
			parameters.setData("PATIENT_ID", ACCastUtilities.toString(getPatientId()));
			// �EKEY�FTARGET_DATE VALUE�FtargetDate
			parameters.setData("TARGET_DATE", getTargetDate());
			// �EKEY�FCLAIM_DATE VALUE�FclaimDate
			parameters.setData("CLAIM_DATE", getClaimDate());
			// �EKEY�FPROVIDER_ID VALUE�FproviderId
			parameters.setData("PROVIDER_ID", getProviderId());
			// �EKEY�FCLAIM_STYLE_TYPE VALUE�FclaimStyleType
			parameters.setData("CLAIM_STYLE_TYPE", ACCastUtilities.toString(getClaimStyleType()));
			// �EKEY�FLIST_INDEX VALUE�FlistIndex
			parameters.setData("LIST_INDEX", getListIndex());
			// �EKEY�FINSURED_ID VALUE�FinsuredId
			parameters.setData("INSURED_ID", getInsuredId());
		}
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// �Ō�ɕۑ�����Ă���A��ʃe�[�u���̃f�[�^���ύX����Ă��Ȃ��ꍇ�itableChangeFlg�̒l��0�̏ꍇ�j
		//[ID:0000429][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
		//if (getTableChangeFlg() == OFF) {
		if (!isModified()) {
		//[ID:0000429][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
			// �V�X�e�����I������B
			return true;
		}
		// �Ō�ɕۑ�����Ă���A��ʃe�[�u���̃f�[�^���ύX����Ă���ꍇ�itableChangeFlg�̒l��1�̏ꍇ�j
		//[ID:0000429][Shin Fujihara] 2009/07 delete begin 2009�N�x�Ή�
		//if (getTableChangeFlg() == ON) {
		//[ID:0000429][Shin Fujihara] 2009/07 delete end 2009�N�x�Ή�
			// �I���m�F���b�Z�[�W��\������B
			if (QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED() == ACMessageBox.RESULT_OK) {
				// �E���b�Z�[�WID�FWARNING_OF_CLOSE_ON_MODIFIED
				// �u�͂��v��I�������ꍇ
				// �V�X�e�����I������B
				return true;
			} else {
				// �u�L�����Z���v��I�������ꍇ
				// �����𒆒f����i�������Ȃ��j�B
				return false;
			}
		//[ID:0000429][Shin Fujihara] 2009/07 delete begin 2009�N�x�Ή�
		/*
		}
		return false;
		*/
		//[ID:0000429][Shin Fujihara] 2009/07 delete end 2009�N�x�Ή�
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u�X�V�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void renewalActionPerformed(ActionEvent e) throws Exception {
		// �m�F���b�Z�[�W��\������B
		// �E���b�Z�[�WID�FQP005_WARNING_OF_UPDATE
		if (QkanMessageList.getInstance().QP005_WARNING_OF_UPDATE() == ACMessageBox.RESULT_OK) {
			// �u�͂��v��I�������ꍇ
			// �ۑ��������s���B
			if (doSave()) {
				// �ۑ�����������I�������ꍇ
				// �������b�Z�[�W��\������B
				QkanMessageList.getInstance().UPDATE_SUCCESSED();
				
				//[ID:0000429][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
				//�X�i�b�v�V���b�g�Ď擾
				doSnap();
				//[ID:0000429][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
				
				// �E���b�Z�[�WID�FUPDATE_SUCCESSED
			} else {
				// �E���b�Z�[�WID�FUPDATE_SUCCESSED
				// �ۑ�����������I�����Ȃ������ꍇ
				// �����𒆒f����B(�I��)
			}
		} else {
			// �u�L�����Z���v��I�������ꍇ
			// �������I������B
		}
	}

	/**
	 * �u�f�[�^�\�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void basicInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// ��{���e�[�u���őI������Ă���s�̃��R�[�h���ڍ׃e�[�u���ɕ\������B
		// �E�������F"BASIC"
		if (getBasicInfoTable().isSelected()) {
			doShowClaimDetail("BASIC");
		}
	}

	/**
	 * �u�f�[�^�\�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void detailsInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// ���׏��e�[�u���őI������Ă���s�̃��R�[�h���ڍ׃e�[�u���ɕ\������B
		// �E�������F"DETAIL
		if (getDetailsInfoTable().isSelected()) {
			doShowClaimDetail("DETAIL");
		}
	}

	/**
	 * �u�f�[�^�\�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void kyotakuDetailsInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// ������x�����׏��e�[�u���őI������Ă���s�̃��R�[�h���ڍ׃e�[�u���ɕ\������B
		// �E�������F"KYOTAKU"
		if (getKyotakuDetailsInfoTable().isSelected()) {
			doShowClaimDetail("KYOTAKU");
		}
	}

	/**
	 * �u�f�[�^�\�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void particularInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// ���莡�Ô���e�[�u���őI������Ă���s�̃��R�[�h���ڍ׃e�[�u���ɕ\������B
		// �E�������F"PARTICULAR"
		if (getParticularInfoTable().isSelected()) {
			doShowClaimDetail("PARTICULAR");
		}
	}

	/**
	 * �u�f�[�^�\�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void specialClinicInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// ����f�Ô���e�[�u���őI������Ă���s�̃��R�[�h���ڍ׃e�[�u���ɕ\������B
		// �E�������F"SPECIAL_CLINIC"
		if (getSpecialClinicInfoTable().isSelected()) {
			doShowClaimDetail("SPECIAL_CLINIC");
		}
	}

	/**
	 * �u�f�[�^�\�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void totalInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// �W�v���e�[�u���őI������Ă���s�̃��R�[�h���ڍ׃e�[�u���ɕ\������B
		// �E�������F"TOTAL"
		if (getTotalInfoTable().isSelected()) {
			doShowClaimDetail("TOTAL");
		}
	}

	/**
	 * �u�f�[�^�\�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void nyushoInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// ��������҉�����e�[�u���őI������Ă���s�̃��R�[�h���ڍ׃e�[�u���ɕ\������B
		if (getNyushoInfoTable().isSelected()) {
			doShowClaimDetail("NYUSHO");
			//[ID:0000429][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
			setState_TYPE7();
		} else {
			setState_TYPE8();
		}
		//[ID:0000429][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
		// �E�������F"NYUSHO"
	}

	/**
	 * �u�f�[�^�\�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void shahukuInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {

		// �Љ���@�l�y���z���e�[�u���őI������Ă���s�̃��R�[�h���ڍ׃e�[�u���ɕ\������B
		if (getShahukuInfoTable().isSelected()) {
			doShowClaimDetail("SHAHUKU");
		}
		// �E�������F"SHAHUKU"
	}

	//[H20.5 �@�����Ή�] fujihara add start
	/**
	 * �u�f�[�^�\�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
    protected void recuperationInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// ����×{����e�[�u���őI������Ă���s�̃��R�[�h���ڍ׃e�[�u���ɕ\������B
		// �E�������F"RYOYO"
		if (getRecuperationInfoTable().isSelected()) {
			doShowClaimDetail("RYOYO");
		}
    }
    //[H20.5 �@�����Ή�] fujihara add end/
	
 // 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
    protected void detailsJushotiTokureiInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// ���׏��i�Z���n����j�e�[�u���őI������Ă���s�̃��R�[�h���ڍ׃e�[�u���ɕ\������B
		// �E�������F"DETAIL_JUSHOTI_TOKUREI"
		if (getDetailsJushotiTokureiInfoTable().isSelected()) {
			doShowClaimDetail("DETAIL_JUSHOTI_TOKUREI");
		}
    }
 // 2014/12/24 [Yoichiro Kamei] add - end
    
	/**
	 * �u�f�[�^�؂�ւ������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void basicInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
		if (getBasicInfoRevisionCheck().isSelected()) {
			// ��{���̈�ibasicInfos�j��Enable��true�̏ꍇ
			if (getBasicInfos().isEnabled()) {
				// �����ږ���̐ݒ�
				// columnList1Name��basicInfoRevisionTablecolumn1�ɐݒ肷��B
				getBasicInfoRevisionTablecolumn1().setCustomCells(getColumnList1Name());

				// ���ݒ�l��̐ݒ�
				// columnList1Value��basicInfoRevisionTablecolumn2�ɐݒ肷��B
				getBasicInfoRevisionTablecolumn2().setCustomCells(getColumnList1Value());
				// ���R�����g��̐ݒ�
				// columnList1Comment��basicInfoRevisionTablecolumn3�ɐݒ肷��B
				getBasicInfoRevisionTablecolumn3().setCustomCells(getColumnList1Comment());

				// ��{���e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getBasicInfoTable().isSelected()) {
					// ��{���e�[�u���őI������Ă��郌�R�[�h����{���ڍ׃e�[�u���ɕ\������B
					// �E�������F"BASIC"
					doShowClaimDetail("BASIC");
				}
			}
			getBasicInfoRevisionCheck().setSelected(true);

			// �`�F�b�N�{�b�N�X���I�t�̏ꍇ
		} else {
			// ��{���̈�ibasicInfos�j��Enable��true�̏ꍇ
			if (getBasicInfos().isEnabled()) {
				// �����ږ���̐ݒ�
				// columnList1Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����basicInfoRevisionTablecolumn1�ɐݒ肷��B
				getBasicInfoRevisionTablecolumn1().setCustomCells(getColumnList1NameSimple());

				// ���ݒ�l��̐ݒ�
				// columnList1Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����basicInfoRevisionTablecolumn2�ɐݒ肷��B
				getBasicInfoRevisionTablecolumn2().setCustomCells(getColumnList1ValueSimple());

				// ���R�����g��̐ݒ�
				// columnList1Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����basicInfoRevisionTablecolumn3�ɐݒ肷��B
				getBasicInfoRevisionTablecolumn3().setCustomCells(getColumnList1CommentSimple());

				// ��{���e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getBasicInfoTable().isSelected()) {
					// ��{���e�[�u���őI������Ă��郌�R�[�h����{���ڍ׃e�[�u���ɕ\������B
					// �E�������F"BASIC"
					doShowClaimDetail("BASIC");
				}
			}
			getBasicInfoRevisionCheck().setSelected(false);
		}
		getBasicInfoTable().validate();
		getBasicInfoTable().repaint();
	}

	/**
	 * �u�f�[�^�؂�ւ������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void detailsInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
		if (getDetailsInfoRevisionCheck().isSelected()) {
			// ���׏��̈�idetailsInfos�j��Enable��true�̏ꍇ
			if (getDetailsInfos().isEnabled()) {
				// �����ږ���̐ݒ�
				// columnList2Name��detailsInfoRevisionTablecolumn1�ɐݒ肷��B
				getDetailsInfoRevisionTablecolumn1().setCustomCells(getColumnList2Name());
				// ���ݒ�l��̐ݒ�
				// columnList2Value��detailsInfoRevisionTablecolumn2�ɐݒ肷��B
				getDetailsInfoRevisionTablecolumn2().setCustomCells(getColumnList2Value());
				// ���R�����g��̐ݒ�
				// columnList2Comment��detailsInfoRevisionTablecolumn3�ɐݒ肷��B
				getDetailsInfoRevisionTablecolumn3().setCustomCells(getColumnList2Comment());

				// ���׏��e�[�u����Visible��true�̏ꍇ
				// ���׏��e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getDetailsInfoTable().isVisible() && getDetailsInfoTable().isSelected()) {
					// ���׏��e�[�u���őI������Ă��郌�R�[�h�𖾍׏��ڍ׃e�[�u���ɕ\������B
					// �E�������F"DETAIL"
					doShowClaimDetail("DETAIL");
				}

				// �����c�x�����׏��e�[�u����Visible��true�̏ꍇ
				// ������x�����׏��e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getKyotakuDetailsInfoTable().isVisible() && getKyotakuDetailsInfoTable().isSelected()) {
					// ������x�����׏��e�[�u���őI������Ă��郌�R�[�h�𖾍׏��ڍ׃e�[�u���ɕ\������B
					// �E�������F"KYOTAKU"
					doShowClaimDetail("KYOTAKU");
				}
			}
			getDetailsInfoRevisionCheck().setSelected(true);
		} else {
			// �`�F�b�N�{�b�N�X���I�t�̏ꍇ
			// ���׏��̈�idetailsInfos�j��Enable��true�̏ꍇ
			if (getDetailsInfos().isEnabled()) {
				// �����ږ���̐ݒ�
				// columnList2Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����detailsInfoRevisionTablecolumn1�ɐݒ肷��B
				getDetailsInfoRevisionTablecolumn1().setCustomCells(getColumnList2NameSimple());
				// ���ݒ�l��̐ݒ�
				// columnList2Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����detailsInfoRevisionTablecolumn2�ɐݒ肷��B
				getDetailsInfoRevisionTablecolumn2().setCustomCells(getColumnList2ValueSimple());
				// ���R�����g��̐ݒ�
				// columnList2Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����detailsInfoRevisionTablecolumn3�ɐݒ肷��B
				getDetailsInfoRevisionTablecolumn3().setCustomCells(getColumnList2CommentSimple());
				// ���׏��e�[�u����Visible��true�̏ꍇ
				// ���׏��e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getDetailsInfoTable().isVisible() && getDetailsInfoTable().isSelected()) {
					// ���׏��e�[�u���őI������Ă��郌�R�[�h�𖾍׏��ڍ׃e�[�u���ɕ\������B
					// �E�������F"DETAIL"
					doShowClaimDetail("DETAIL");
				}

				// ������x�����׏��e�[�u����Visible��true�̏ꍇ
				// ������x�����׏��e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getKyotakuDetailsInfoTable().isVisible() && getKyotakuDetailsInfoTable().isSelected()) {
					// ������x�����׏��e�[�u���őI������Ă��郌�R�[�h�𖾍׏��ڍ׃e�[�u���ɕ\������B
					// �E�������F"KYOTAKU"
					doShowClaimDetail("KYOTAKU");
				}
			}
			getDetailsInfoRevisionCheck().setSelected(false);
		}
		getDetailsInfoTable().validate();
		getDetailsInfoTable().repaint();
	}

	/**
	 * �u�f�[�^�؂�ւ������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void particularInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
		if (getParticularInfoRevisionCheck().isSelected()) {
			// ���莡�ÁE����f�Ï��̈�iparticularInfos�j��Enable��true�̏ꍇ
			if (getParticularInfos().isEnabled()) {
				// �����ږ���̐ݒ�
				// columnList3Name��particularInfoRevisionTablecolumn1�ɐݒ肷��B
				getParticularInfoRevisionTablecolumn1().setCustomCells(getColumnList3Name());
				// ���ݒ�l��̐ݒ�
				// columnList3Value��particularInfoRevisionTablecolumn2�ɐݒ肷��B
				getParticularInfoRevisionTablecolumn2().setCustomCells(getColumnList3Value());
				// ���R�����g��̐ݒ�
				// columnList3Comment��particularInfoRevisionTablecolumn3�ɐݒ肷��B
				getParticularInfoRevisionTablecolumn3().setCustomCells(getColumnList3Comment());

				// ���莡�Ô���e�[�u����Visible��true�̏ꍇ
				// ���莡�Ô���e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getParticularInfoTable().isVisible() && getParticularInfoTable().isSelected()) {
					// ���莡�Ô���e�[�u���őI������Ă��郌�R�[�h����莡�Ô�E����f�Ô���ڍ׃e�[�u���ɕ\������B
					// �E�������F"PARTICULAR"
					doShowClaimDetail("PARTICULAR");
				}

				// ����f�Ô���e�[�u����Visible��true�̏ꍇ
				// ����f�Ô���e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getSpecialClinicInfoTable().isVisible() && getSpecialClinicInfoTable().isSelected()) {
					// ���莡�Ô���e�[�u���őI������Ă��郌�R�[�h����莡�Ô�E����f�Ô���ڍ׃e�[�u���ɕ\������B
					// �E�������F"SPECIAL_CLINIC"
					doShowClaimDetail("SPECIAL_CLINIC");
				}
			}
			getParticularInfoRevisionCheck().setSelected(true);
		} else {
			// �`�F�b�N�{�b�N�X���I�t�̏ꍇ
			// ���׏��̈�idetailsInfos�j��Enable��true�̏ꍇ
			if (getParticularInfos().isEnabled()) {
				// �����ږ���̐ݒ�
				// columnList3Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����particularInfoRevisionTablecolumn1�ɐݒ肷��B
				getParticularInfoRevisionTablecolumn1().setCustomCells(getColumnList3NameSimple());
				// ���ݒ�l��̐ݒ�
				// columnList3Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����particularInfoRevisionTablecolumn2�ɐݒ肷��B
				getParticularInfoRevisionTablecolumn2().setCustomCells(getColumnList3ValueSimple());
				// ���R�����g��̐ݒ�
				// columnList3Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����particularInfoRevisionTablecolumn3�ɐݒ肷��B
				getParticularInfoRevisionTablecolumn3().setCustomCells(getColumnList3CommentSimple());
				// ���莡�Ô���e�[�u����Visible��true�̏ꍇ
				// ���莡�Ô���e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getParticularInfoTable().isVisible() && getParticularInfoTable().isSelected()) {
					// ���莡�Ô���e�[�u���őI������Ă��郌�R�[�h����莡�Ô�E����f�Ô���ڍ׃e�[�u���ɕ\������B
					// �E�������F"PARTICULAR"
					doShowClaimDetail("PARTICULAR");
				}

				// ����f�Ô���e�[�u����Visible��true�̏ꍇ
				// ����f�Ô���e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getSpecialClinicInfoTable().isVisible() && getSpecialClinicInfoTable().isSelected()) {
					// ���莡�Ô���e�[�u���őI������Ă��郌�R�[�h����莡�Ô�E����f�Ô���ڍ׃e�[�u���ɕ\������B
					// �E�������F"SPECIAL_CLINIC"
					doShowClaimDetail("SPECIAL_CLINIC");
				}

			}
			getParticularInfoRevisionCheck().setSelected(false);
		}
		getParticularInfoTable().validate();
		getParticularInfoTable().repaint();

	}

	/**
	 * �u�f�[�^�؂�ւ������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void totalInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
		if (getTotalInfoRevisionCheck().isSelected()) {
			// �W�v���̈�itotalInfos�j��Enable��true�̏ꍇ
			if (getTotalInfos().isEnabled()) {
				// �����ږ���̐ݒ�
				// columnList4Name��totalInfoRevisionTablecolumn1�ɐݒ肷��B
				getTotalInfoRevisionTablecolumn1().setCustomCells(getColumnList4Name());
				// ���ݒ�l��̐ݒ�
				// columnList4Value��totalInfoRevisionTablecolumn2�ɐݒ肷��B
				getTotalInfoRevisionTablecolumn2().setCustomCells(getColumnList4Value());
				// ���R�����g��̐ݒ�
				// columnList4Comment��totalInfoRevisionTablecolumn3�ɐݒ肷��B
				getTotalInfoRevisionTablecolumn3().setCustomCells(getColumnList4Comment());

				// �W�v���e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getTotalInfoTable().isSelected()) {
					// �W�v���e�[�u���őI������Ă��郌�R�[�h���W�v���ڍ׃e�[�u���ɕ\������B
					// �E�������F"TOTAL"
					doShowClaimDetail("TOTAL");
				}
			}
			getTotalInfoRevisionCheck().setSelected(true);
		} else {
			// �`�F�b�N�{�b�N�X���I�t�̏ꍇ
			// �W�v���̈�itotalInfos�j��Enable��true�̏ꍇ
			if (getTotalInfos().isEnabled()) {
				// �����ږ���̐ݒ�
				// columnList4Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����totalInfoRevisionTablecolumn1�ɐݒ肷��B
				getTotalInfoRevisionTablecolumn1().setCustomCells(getColumnList4NameSimple());
				// ���ݒ�l��̐ݒ�
				// columnList4Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����totalInfoRevisionTablecolumn2�ɐݒ肷��B
				getTotalInfoRevisionTablecolumn2().setCustomCells(getColumnList4ValueSimple());
				// ���R�����g��̐ݒ�
				// columnList4Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����totalInfoRevisionTablecolumn3�ɐݒ肷��B
				getTotalInfoRevisionTablecolumn3().setCustomCells(getColumnList4CommentSimple());
				// �W�v���e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getTotalInfoTable().isSelected()) {
					// �W�v���e�[�u���őI������Ă��郌�R�[�h���W�v���ڍ׃e�[�u���ɕ\������B
					// �E�������F"TOTAL"
					doShowClaimDetail("TOTAL");
				}
			}
			getTotalInfoRevisionCheck().setSelected(false);

		}
		getTotalInfoTable().validate();
		getTotalInfoTable().repaint();
	}

	/**
	 * �u�f�[�^�؂�ւ������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void nyushoInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
		if (getNyushoInfoRevisionCheck().isSelected()) {
			// �`�F�b�N�{�b�N�X���I���̏ꍇ
			if (getNyushoInfos().isEnabled()) {
				// ��������҉�����̈�inyushoInfos�j��Enable��true�̏ꍇ
				if (getNyushoInfos().isEnabled()) {
					// �����ږ���̐ݒ�
					// columnList5Name��nyushoInfoRevisionTablecolumn1�ɐݒ肷��B
					getNyushoInfoRevisionTablecolumn1().setCustomCells(getColumnList5Name());
					// ���ݒ�l��̐ݒ�
					// columnList5Value��nyushoInfoRevisionTablecolumn2�ɐݒ肷��B
					getNyushoInfoRevisionTablecolumn2().setCustomCells(getColumnList5Value());
					// ���R�����g��̐ݒ�
					// columnList5Comment��nyushoInfoRevisionTablecolumn3�ɐݒ肷��B
					getNyushoInfoRevisionTablecolumn3().setCustomCells(getColumnList5Comment());

					// ��������҉�����e�[�u���Ń��R�[�h���I������Ă���ꍇ
					if (getNyushoInfoTable().isSelected()) {
						// ��������҉�����e�[�u���őI������Ă��郌�R�[�h���������҉�����ڍ׃e�[�u���ɕ\������B
						// �E�������F"TOTAL"
						doShowClaimDetail("NYUSHO");
					}
				}
			}
			getNyushoInfoRevisionCheck().setSelected(true);
		} else {
			// �`�F�b�N�{�b�N�X���I�t�̏ꍇ
			if (getNyushoInfos().isEnabled()) {
				// ��������҉�����̈�inyushoInfos�j��Enable��true�̏ꍇ
				if (getNyushoInfos().isEnabled()) {
					// �����ږ���̐ݒ�
					// columnList5Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
					// �擾�������R�[�h�W����nyushoInfoRevisionTablecolumn1�ɐݒ肷��B
					getNyushoInfoRevisionTablecolumn1().setCustomCells(getColumnList5NameSimple());
					// ���ݒ�l��̐ݒ�
					// columnList5Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
					// �擾�������R�[�h�W����nyushoInfoRevisionTablecolumn2�ɐݒ肷��B
					getNyushoInfoRevisionTablecolumn2().setCustomCells(getColumnList5ValueSimple());
					// ���R�����g��̐ݒ�
					// columnList5Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
					// �擾�������R�[�h�W����nyushoInfoRevisionTablecolumn3�ɐݒ肷��B
					getNyushoInfoRevisionTablecolumn3().setCustomCells(getColumnList5CommentSimple());
					// ��������҉�����e�[�u���Ń��R�[�h���I������Ă���ꍇ
					if (getNyushoInfoTable().isSelected()) {
						// ��������҉�����e�[�u���őI������Ă��郌�R�[�h���������҉�����ڍ׃e�[�u���ɕ\������B
						// �E�������F"TOTAL"
						doShowClaimDetail("NYUSHO");
					}
				}
			}
			getNyushoInfoRevisionCheck().setSelected(false);
		}
		getNyushoInfoTable().validate();
		getNyushoInfoTable().repaint();
	}

	/**
	 * �u�f�[�^�؂�ւ������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void shahukuInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
		// �`�F�b�N�{�b�N�X���I���̏ꍇ
		if (getShahukuInfoRevisionCheck().isSelected()) {
			// �Љ���@�l�y���z���̈�ishahukuInfos�j��Enable��true�̏ꍇ
			if (getShahukuInfos().isEnabled()) {
				// �����ږ���̐ݒ�
				// columnList6Name��shahukuInfoRevisionTablecolumn1�ɐݒ肷��B
				getShahukuInfoRevisionTablecolumn1().setCustomCells(getColumnList6Name());
				// ���ݒ�l��̐ݒ�
				// columnList6Value��shahukuInfoRevisionTablecolumn2�ɐݒ肷��B
				getShahukuInfoRevisionTablecolumn2().setCustomCells(getColumnList6Value());
				// ���R�����g��̐ݒ�
				// columnList6Comment��shahukuInfoRevisionTablecolumn3�ɐݒ肷��B
				getShahukuInfoRevisionTablecolumn3().setCustomCells(getColumnList6Comment());

				// �Љ���@�l�y���z���e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getShahukuInfoTable().isSelected()) {
					// �Љ���@�l�y���z���e�[�u���őI������Ă��郌�R�[�h���Љ���@�l�y���z���ڍ׃e�[�u���ɕ\������B
					// �E�������F"SHAHUKU"
					doShowClaimDetail("SHAHUKU");
				}
			}
			getShahukuInfoRevisionCheck().setSelected(true);
		} else {
			// �`�F�b�N�{�b�N�X���I�t�̏ꍇ
			// �Љ���@�l�y���z���̈�ishahukuInfos�j��Enable��true�̏ꍇ
			if (getShahukuInfos().isEnabled()) {
				// �����ږ���̐ݒ�
				// columnList6Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����shahukuInfoRevisionTablecolumn1�ɐݒ肷��B
				getShahukuInfoRevisionTablecolumn1().setCustomCells(getColumnList6NameSimple());
				// ���ݒ�l��̐ݒ�
				// columnList6Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����shahukuInfoRevisionTablecolumn2�ɐݒ肷��B
				getShahukuInfoRevisionTablecolumn2().setCustomCells(getColumnList6ValueSimple());
				// ���R�����g��̐ݒ�
				// columnList6Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����shahukuInfoRevisionTablecolumn3�ɐݒ肷��B
				getShahukuInfoRevisionTablecolumn3().setCustomCells(getColumnList6CommentSimple());
				// �Љ���@�l�y���z���e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getShahukuInfoTable().isSelected()) {
					// �Љ���@�l�y���z���e�[�u���őI������Ă��郌�R�[�h���Љ���@�l�y���z���ڍ׃e�[�u���ɕ\������B
					// �E�������F"SHAHUKU"
					doShowClaimDetail("SHAHUKU");
				}
			}
			getShahukuInfoRevisionCheck().setSelected(false);
		}
		getShahukuInfoTable().validate();
		getShahukuInfoTable().repaint();
	}
	
	//[H20.5 �@�����Ή�] fujihara add start
	/**
	 * �u�f�[�^�؂�ւ������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
    protected void recuperationInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
    	
		if (getRecuperationInfoRevisionCheck().isSelected()) {
			// ����×{����̈�iparticularInfos�j��Enable��true�̏ꍇ
			if (getRecuperationInfos().isEnabled()) {
				// �����ږ���̐ݒ�
				// columnList7Name��particularInfoRevisionTablecolumn1�ɐݒ肷��B
				getRecuperationInfoRevisionTablecolumn1().setCustomCells(getColumnList7Name());

				// ���ݒ�l��̐ݒ�
				// columnList7Value��particularInfoRevisionTablecolumn2�ɐݒ肷��B
				getRecuperationInfoRevisionTablecolumn2().setCustomCells(getColumnList7Value());
				// ���R�����g��̐ݒ�
				// columnList7Comment��particularInfoRevisionTablecolumn3�ɐݒ肷��B
				getRecuperationInfoRevisionTablecolumn3().setCustomCells(getColumnList7Comment());

				// ����×{����e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getRecuperationInfoTable().isSelected()) {
					// ����×{����e�[�u���őI������Ă��郌�R�[�h�����×{����ڍ׃e�[�u���ɕ\������B
					// �E�������F"RYOYO"
					doShowClaimDetail("RYOYO");
				}
			}
			getRecuperationInfoRevisionCheck().setSelected(true);

			// �`�F�b�N�{�b�N�X���I�t�̏ꍇ
		} else {
			// ����×{����̈�iparticularInfos�j��Enable��true�̏ꍇ
			if (getRecuperationInfos().isEnabled()) {
				// �����ږ���̐ݒ�
				// columnList7Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����particularInfoRevisionTablecolumn1�ɐݒ肷��B
				getRecuperationInfoRevisionTablecolumn1().setCustomCells(getColumnList7NameSimple());

				// ���ݒ�l��̐ݒ�
				// columnList7Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����particularInfoRevisionTablecolumn2�ɐݒ肷��B
				getRecuperationInfoRevisionTablecolumn2().setCustomCells(getColumnList7ValueSimple());

				// ���R�����g��̐ݒ�
				// columnList7Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����particularInfoRevisionTablecolumn3�ɐݒ肷��B
				getRecuperationInfoRevisionTablecolumn3().setCustomCells(getColumnList7CommentSimple());

				// ����×{����e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getRecuperationInfoTable().isSelected()) {
					// ����×{����e�[�u���őI������Ă��郌�R�[�h�����×{����ڍ׃e�[�u���ɕ\������B
					// �E�������F"RYOYO"
					doShowClaimDetail("RYOYO");
				}
			}
			getRecuperationInfoRevisionCheck().setSelected(false);
		}
		getRecuperationInfoTable().validate();
		getRecuperationInfoTable().repaint();
        
    }
    //[H20.5 �@�����Ή�] fujihara add end

 // 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
	/**
	 * �u�f�[�^�؂�ւ������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
    protected void detailsJushotiTokureiInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
		if (getDetailsJushotiTokureiInfoRevisionCheck().isSelected()) {
			// ���׏��̈�idetailsJushotiTokureiInfos�j��Enable��true�̏ꍇ
			if (getDetailsJushotiTokureiInfos().isEnabled()) {
				// �����ږ���̐ݒ�
				// columnList8Name��detailsJushotiTokureiInfoRevisionTablecolumn1�ɐݒ肷��B
				getDetailsJushotiTokureiInfoRevisionTablecolumn1().setCustomCells(getColumnList8Name());
				// ���ݒ�l��̐ݒ�
				// columnList8Value��detailsJushotiTokureiInfoRevisionTablecolumn2�ɐݒ肷��B
				getDetailsJushotiTokureiInfoRevisionTablecolumn2().setCustomCells(getColumnList8Value());
				// ���R�����g��̐ݒ�
				// columnList8Comment��detailsJushotiTokureiInfoRevisionTablecolumn3�ɐݒ肷��B
				getDetailsJushotiTokureiInfoRevisionTablecolumn3().setCustomCells(getColumnList8Comment());

				// ���׏��e�[�u����Visible��true�̏ꍇ
				// ���׏��e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getDetailsJushotiTokureiInfoTable().isVisible() && getDetailsJushotiTokureiInfoTable().isSelected()) {
					// ���׏��e�[�u���őI������Ă��郌�R�[�h�𖾍׏��ڍ׃e�[�u���ɕ\������B
					// �E�������F"DETAIL_JUSHOTI_TOKUREI"
					doShowClaimDetail("DETAIL_JUSHOTI_TOKUREI");
				}
			}
			getDetailsJushotiTokureiInfoRevisionCheck().setSelected(true);
		} else {
			// �`�F�b�N�{�b�N�X���I�t�̏ꍇ
			// ���׏��̈�idetailsInfos�j��Enable��true�̏ꍇ
			if (getDetailsJushotiTokureiInfos().isEnabled()) {
				// �����ږ���̐ݒ�
				// columnList8Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����detailsJushotiTokureiInfoRevisionTablecolumn1�ɐݒ肷��B
				getDetailsJushotiTokureiInfoRevisionTablecolumn1().setCustomCells(getColumnList8NameSimple());
				// ���ݒ�l��̐ݒ�
				// columnList8Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����detailsJushotiTokureiInfoRevisionTablecolumn2�ɐݒ肷��B
				getDetailsJushotiTokureiInfoRevisionTablecolumn2().setCustomCells(getColumnList8ValueSimple());
				// ���R�����g��̐ݒ�
				// columnList8Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
				// �擾�������R�[�h�W����detailsJushotiTokureiInfoRevisionTablecolumn3�ɐݒ肷��B
				getDetailsJushotiTokureiInfoRevisionTablecolumn3().setCustomCells(getColumnList8CommentSimple());
				// ���׏��e�[�u����Visible��true�̏ꍇ
				// ���׏��e�[�u���Ń��R�[�h���I������Ă���ꍇ
				if (getDetailsJushotiTokureiInfoTable().isVisible() && getDetailsJushotiTokureiInfoTable().isSelected()) {
					// ���׏��e�[�u���őI������Ă��郌�R�[�h�𖾍׏��ڍ׃e�[�u���ɕ\������B
					// �E�������F"DETAIL"
					doShowClaimDetail("DETAIL_JUSHOTI_TOKUREI");
				}
			}
			getDetailsJushotiTokureiInfoRevisionCheck().setSelected(false);
		}
		getDetailsJushotiTokureiInfoTable().validate();
		getDetailsJushotiTokureiInfoTable().repaint();
    }
 // 2014/12/24 [Yoichiro Kamei] add - end
    
	/**
	 * �u�f�[�^�ύX�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void basicInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception {
		// tableChangeFlg��1��������B
		// ��{���e�[�u�����ĕ`�悷��B
		setTableChangeFlg(ON);
	}

	/**
	 * �u�f�[�^�ύX�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void detailsInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception {
		// tableChangeFlg��1��������B
		setTableChangeFlg(ON);
		if (getDetailsInfoTable().isVisible()) {
			// ���׏��e�[�u����Visible��true�̏ꍇ
			// ���׏��e�[�u�����ĕ`�悷��B
			getDetailsInfoTable().validate();
			getDetailsInfoTable().repaint();
		}

		if (getKyotakuDetailsInfoTable().isVisible()) {
			// ������x�����׏��e�[�u����Visible��true�̏ꍇ
			// ������x�����׏��e�[�u�����ĕ`�悷��B
			getKyotakuDetailsInfoTable().validate();
			getKyotakuDetailsInfoTable().repaint();
		}
	}

	/**
	 * �u�f�[�^�ύX�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void particularInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception {
		// tableChangeFlg��1��������B
		setTableChangeFlg(ON);
		// ���莡�Ô���e�[�u����Visible��true�̏ꍇ
		if (getParticularInfoTable().isVisible()) {
			// ���莡�Ô���e�[�u�����ĕ`�悷��B
			getParticularInfoTable().validate();
			getParticularInfoTable().repaint();
		}

		if (getSpecialClinicInfoTable().isVisible()) {
			// ����f�Ô���e�[�u����Visible��true�̏ꍇ
			// ����f�Ô���e�[�u�����ĕ`�悷��B
			getSpecialClinicInfoTable().validate();
			getSpecialClinicInfoTable().repaint();
		}
	}

	/**
	 * �u�f�[�^�ύX�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void totalInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception {
		// tableChangeFlg��1��������B
		setTableChangeFlg(ON);
		// �W�v���e�[�u�����ĕ`�悷��B
		getTotalInfoTable().validate();
		getTotalInfoTable().repaint();
	}

	/**
	 * �u�f�[�^�ύX�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void nyushoInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception {
		// tableChangeFlg��1��������B
		setTableChangeFlg(ON);
		// ��������҉�����e�[�u�����ĕ`�悷��B
		getNyushoInfoTable().validate();
		getNyushoInfoTable().repaint();
	}

	/**
	 * �u�f�[�^�ύX�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void shahukuInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception {
		// tableChangeFlg��1��������B
		setTableChangeFlg(ON);
		// �Љ���@�l�y���z���e�[�u�����ĕ`�悷��B
		getShahukuInfoTable().validate();
		getShahukuInfoTable().repaint();
	}
	
	//[ID:0000429][Shin Fujihara] 2009/07 add start 2009�N�x�Ή�
	//���ʗ×{��^�u�̕ύX�`�F�b�N�R��Ή�
	/**
	 * �u�f�[�^�ύX�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void recuperationInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception {
		// tableChangeFlg��1��������B
		setTableChangeFlg(ON);
		// ���ʗ×{����e�[�u�����ĕ`�悷��B
		getRecuperationInfoTable().validate();
		getRecuperationInfoTable().repaint();
		
	}
	//[ID:0000429][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		
		
		param.setData("PATIENT_ID", new Integer(27));
		param.setData("INSURED_ID", "9000000001");
		param.setData("PROVIDER_ID", "2000000000");
		param.setData("LIST_INDEX", new Integer(1));
		param.setData("INSURER_ID", "111111");
		param.setData("CLAIM_STYLE_TYPE", new Integer(10411));
		param.setData("CLAIM_DATE", jp.nichicom.ac.util.ACDateUtilities.createDate(2009, 8, 1));
		param.setData("TARGET_DATE", jp.nichicom.ac.util.ACDateUtilities.createDate(2009, 7, 1));
		

		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QP005.class.getName(), param));
	}

	// �����֐�

	/**
	 * �u�f�[�^�擾�A��ʓW�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFind() throws Exception {
		// �f�[�^���擾���A��ʂɓW�J���鏈���B
		// ��ʓW�J�pVRMap map�𐶐�����B
		VRMap map = new VRHashMap();
		// SQL�n���p��
		VRMap param = new VRHashMap();

		// �Ɩ����}�X�^���A�f�[�^���擾����B

		// �擾�����f�[�^�̃E�B���h�E�^�C�g���iWindow_TITLE�j���E�B���h�E�ɐݒ肷��B
		// �擾�����f�[�^�̋Ɩ��^�C�g���iAFFAIR_TITLE�j���Ɩ��{�^���o�[�ɐݒ肷��B
		setAffairTitle("QP005", getButtons());

		// �R�[�h�}�X�^�̃f�[�^���擾���AmasterCode�Ɋi�[����B
		setMasterCode(QkanSystemInformation.getInstance().getMasterCode());

		// ��ʂ�Visible����EEnable����E���x���̃L���v�V����������s���B
		doControlWindow();

		// ���ڃR�����g�}�X�^�iM_DETAIL_COMMENT�jTABLE���f�[�^���擾����B
		doFindComment();

		// �����f�[�^���擾����B
		doFindClaim();

		// ��ʃe�[�u���̐ݒ���s���B
		doSetTable();

		// ��ʓW�J�pHashMap�FWindowMap�̐ݒ���s���B

		// ���p�ҕی������擾����B
		// ���L���擾����B
		// �E���p�Җ�
		// toFullName();
		// ���L�̃f�[�^����������B
		// �����i���j�iPATIENT_FAMILY_NAME�j
		// �����i���j�iPATIENT_FIRST_NAME�j
		VRMap patientInfo = (VRMap) QkanCommon.getPatientInfo(getDBManager(), getPatientId()).getData(0);
		String patientName = QkanCommon.toFullName(patientInfo.getData("PATIENT_FAMILY_NAME"), patientInfo.getData("PATIENT_FIRST_NAME"));

		// �E���p�ҕی����̗��p�҃R�[�h�iPATIENT_CODE�j
		VRList patientInsureInfoList = QkanCommon.getPatientInsureInfoOnEndOfMonth(getDBManager(), getTargetDate(), getPatientId());
		VRMap patientInsureInfoMap = (VRMap) patientInsureInfoList.getData(0);

		// �E���p�ҕی����̔�ی��Ҕԍ��iINSURED_ID�j
		String insuredID = new String();
		if (ACTextUtilities.isNullText(patientInsureInfoMap.getData("INSURED_ID"))) {
			insuredID = "";
		} else {
			insuredID = ACCastUtilities.toString(patientInsureInfoMap.getData("INSURED_ID"));
		}

		String patientCode = new String();
		if (ACTextUtilities.isNullText(patientInfo.getData("PATIENT_CODE"))) {
			patientCode = "�R�[�h����";
		} else {
			patientCode = ACCastUtilities.toString(patientInfo.getData("PATIENT_CODE"));
		}

		// ��L�̃f�[�^���ȉ��̌^�ɕҏW����B
		// �E'PATIENT_NAME'�i��ی��Ҕԍ� = 'INSURED_ID'. ���p��CD = 'PATIENT_CODE'�j
		String patient = patientName + "�i��ی��Ҕԍ� : " + insuredID + "  ���p�҃R�[�h : " + patientCode + ")";

		// �ҏW�����f�[�^��map�Ɉȉ���KEY�Őݒ肷��B
		// �EKEY�FPATIENT_NAME
		map.setData("PATIENT_NAME", patient);

		// ���Ə������擾����B
		VRList providerIDList = QkanCommon.getProviderInfo(getDBManager(), getProviderId());
		VRMap providerIDMap = (VRMap) providerIDList.getData(0);

		// �擾�������Ə����̎��Ə����iPROVIDER_NAME�j���ȉ��̌^�ɕҏW����B
		// �E'PROVIDER_NAME'�i'providerId'�j
		String provider = providerIDMap.getData("PROVIDER_NAME") + "(" + getProviderId() + ")";

		// �ҏW�����f�[�^��map�Ɉȉ���KEY�Őݒ肷��B
		// �EKEY�FPROVIDER_NAME
		map.setData("PROVIDER_NAME", provider);

		// ���[�l�������擾����B
		// �擾�����f�[�^��map�Ɉȉ���KEY�Őݒ肷��B
		// �EKEY�FCLAIM_STYLE_NAME
		String claimStyle = getClaimStyleName();
		map.setData("CLAIM_STYLE_NAME", claimStyle);

		// targetDate��map�Ɉȉ���KEY�Őݒ肷��B
		// �EKEY�FTARGET_DATE
		String dateInfo = VRDateParser.format(getTargetDate(), "gggee�NMM���x");
		map.setData("TARGET_DATE", dateInfo);

		// ����N�G���i�[�p�e���|����
		VRList kohiData = new VRArrayList();
		VRMap claimData = new VRHashMap();
		
		ArrayList kohiType = new ArrayList();

		// ������̎擾
		// 10701�̒萔��
		
		// replace begin 2006/09/14 kamitsukasa
		if (!(getClaimStyleType() == FORMAT_STYLE7 || getClaimStyleType() == FORMAT_STYLE72)) {
			if (!getTableClaimList1().isEmpty()) {
				claimData = (VRMap) getTableClaimList1().getData(0);
			}
//		if (!(getClaimStyleType() == 10701)) {
			// replace end 2006/09/14 kamitsukasa
			
			// claimStyleType�̒l��10701�ȊO�̏ꍇ
			// tableClaimList1�̉��L�̒l���擾���A�z��ɂ���B
			// �E201058�i����1 �����ށj
			// �E201059�i����2 �����ށj
			// �E201060�i����3 �����ށj

			if (!ACTextUtilities.isNullText(claimData.getData("201058"))) {
				kohiType.add(ACCastUtilities.toInteger(claimData.getData("201058")));
			}

			if (!ACTextUtilities.isNullText(claimData.getData("201059"))) {
				kohiType.add(ACCastUtilities.toInteger(claimData.getData("201059")));
			}

			if (!ACTextUtilities.isNullText(claimData.getData("201060"))) {
				kohiType.add(ACCastUtilities.toInteger(claimData.getData("201060")));
			}

			if (!kohiType.isEmpty()) {
				// ��L�̔z���SQL�擾�p��HashMap�Fparam�Ɉȉ���KEY�Őݒ肷��B
				// �EKEY�FKOHI_TYPE
				param.setData("KOHI_TYPE", kohiType.toArray());
				// ��������擾����B
				kohiData = getDBManager().executeQuery(getSQL_GET_KOHI(param));
			}
			
		// replace begin 2006/09/14 kamitsukasa
//		} else if (getClaimStyleType() == 10701) {
		} else {
			if (!getTableClaimList2().isEmpty()) {
				claimData = (VRMap) getTableClaimList2().getData(0);
			}
			// replace end 2006/09/14 kamitsukasa
			
			// claimStyleType�̒l��10711/10712�̏ꍇ
			// tableClaimList2�̉��L�̒l���擾���A�z��ɂ���B
			// �E1001019�i���� �����ށj
			if (!ACTextUtilities.isNullText(claimData.getData("1001019"))) {
				kohiType.add(ACCastUtilities.toInteger(claimData.getData("1001019")));
			}

			if (!kohiType.isEmpty()) {
				// ��L�̔z���SQL�擾�p��HashMap�Fparam�Ɉȉ���KEY�Őݒ肷��B
				// �EKEY�FKOHI_TYPE
				param.setData("KOHI_TYPE", kohiType.toArray());

				// ��������擾����B
				kohiData = getDBManager().executeQuery(getSQL_GET_KOHI(param));
			}
		}

		// �擾���������񂩂牺�L�̏����擾����B
		// �EKOHI_ABBREVIATION
		// �EBENEFIT_RATE
		// �擾�����f�[�^���ȉ��̌^�ɕҏW����B
		// �E1. 'KOHI_ABBREVIATION'�i'BENEFIT_RATE'%�j
		// �������̏ꍇ�A���s���͂��݁A�����s�̕�����ɂ���B
		// ������No���J��グ��B

		String kohiString = "";
		if (!kohiData.isEmpty()) {
			Iterator kohiIterator = kohiData.iterator();

			int i = 0;
			while (kohiIterator.hasNext()) {
				VRMap kohiMap = (VRMap) kohiIterator.next();
				kohiString = kohiString + "����" + ACCastUtilities.toString(++i) + ":    " + ACCastUtilities.toString(kohiMap.getData("KOHI_ABBREVIATION")) + "(" + ACCastUtilities.toString(kohiMap.getData("BENEFIT_RATE")) + "%)    ";
			}
		} else {
			kohiString = "�����";
		}
		// �ҏW�����f�[�^��map�Ɉȉ���KEY�Őݒ肷��B
		// �EKEY�FKOHI_NAME
		map.setData("KOHI_NAME", kohiString);

		// map���u�N���C�A���g�̈�icontents�j�v�̃\�[�X�Ƃ��Đݒ肷��B
		setSource(map);

		// ��ʂɓW�J����B
		bindSource();

	}

	/**
	 * �u���[�l�����̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public String getClaimStyleName() throws Exception {
		// ���[�l������Ԃ������B
		// claimStyleType�̒l��10211�̏ꍇ
		// "�l�����"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE2) {
			return "�l�����";
		}

		// claimStyleType�̒l��10212�̏ꍇ
		// "�l�����̓�"��Ԃ��B	
		if (getClaimStyleType() == FORMAT_STYLE22) {
			return "�l�����̓�";
		}
		
		// 2016/7/8 [Shinobu Hitaka] add - begin �������ƑΉ�
		// claimStyleType�̒l��10213�̏ꍇ
		// "�l�����̎O"��Ԃ��B	
		if (getClaimStyleType() == FORMAT_STYLE23) {
			return "�l�����̎O";
		}
		// 2016/7/8 [Shinobu Hitaka] add - end
		
		// claimStyleType�̒l��10311�̏ꍇ
		// "�l����O"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE3) {
			return "�l����O";
		}
		
		// claimStyleType�̒l��10312�̏ꍇ
		// "�l����O"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE32) {
			return "�l����O�̃j";
		}
		
		// claimStyleType�̒l��10411�̏ꍇ
		// "�l����l"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE4) {
			return "�l����l";
		}

		// claimStyleType�̒l��10412�̏ꍇ
		// "�l����l"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE42) {
			return "�l����l�̃j";
		}
		
		// claimStyleType�̒l��10511�̏ꍇ
		// "�l�����"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE5) {
			return "�l�����";
		}

		// claimStyleType�̒l��10512�̏ꍇ
		// "�l�����"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE52) {
			return "�l����܂̃j";
		}
		
		// claimStyleType�̒l��10611�̏ꍇ
		// "�l����Z"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE6) {
			return "�l����Z";
		}

		// claimStyleType�̒l��10612�̏ꍇ
		// "�l����Z�̎O"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE62) {
			return "�l����Z�̃j";
		}
		
		// claimStyleType�̒l��10613�̏ꍇ
		// "�l����Z�̎O"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE63) {
			return "�l����Z�̎O";
		}

		// claimStyleType�̒l��10614�̏ꍇ
		// "�l����Z�̎l"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE64) {
			return "�l����Z�̎l";
		}
		
		// claimStyleType�̒l��10615�̏ꍇ
		// "�l����Z�̌�"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE65) {
			return "�l����Z�̌�";
		}

		// claimStyleType�̒l��10616�̏ꍇ
		// "�l����Z�̘Z"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE66) {
			return "�l����Z�̘Z";
		}
		
        // claimStyleType�̒l��10617�̏ꍇ
        // "�l����Z�̎�"��Ԃ��B
        if (getClaimStyleType() == FORMAT_STYLE67) {
            return "�l����Z�̎�";
        }
		
		// claimStyleType�̒l��10711�̏ꍇ
		// "�l���掵"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE7) {
			return "�l���掵";
		}

		// claimStyleType�̒l��10712�̏ꍇ
		// "�l���掵"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE72) {
			return "�l���掵�̃j";
		}
		
		// claimStyleType�̒l��10811�̏ꍇ
		// "�l���攪"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE8) {
			return "�l���攪";
		}

		// claimStyleType�̒l��10911�̏ꍇ
		// "�l�����"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE9) {
			return "�l�����";
		}

		// claimStyleType�̒l��11011�̏ꍇ
		// "�l����\"��Ԃ��B
		if (getClaimStyleType() == FORMAT_STYLE10) {
			return "�l����\";
		}
		// ��L�̂�����ł��Ȃ������ꍇ(�����ǂꂩ�̂̂͂�)
		return "";
	}

	/**
	 * �u��ʂ�Visible����EEnable����E�L���v�V��������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doControlWindow() throws Exception {
		// ��ʂ�Visible����EEnable����E���x���̃L���v�V����������s�������B

		// claimStyleType�̒l��10211�̏ꍇ
		// �l��2
		if (getClaimStyleType() == FORMAT_STYLE2) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE1();
			// ���ID�FTYPE1
		}

		// claimStyleType�̒l��10212�̏ꍇ
		// �l��2��2
		if (getClaimStyleType() == FORMAT_STYLE22) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE1();
			// ���ID�FTYPE1
		}
		
		// 2016/7/8 [Shinobu Hitaka] add - begin �������ƑΉ�
		// claimStyleType�̒l��10213�̏ꍇ
		// �l��2��3
		if (getClaimStyleType() == FORMAT_STYLE23) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE1();
			// ���ID�FTYPE1
		}
		// 2016/7/8 [Shinobu Hitaka] add - end
		
		// claimStyleType�̒l��10311�̏ꍇ
		// �l��3
		if (getClaimStyleType() == FORMAT_STYLE3) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE2();
			// ���ID�FTYPE2
		}

		// claimStyleType�̒l��10312�̏ꍇ
		// �l��3��2
		if (getClaimStyleType() == FORMAT_STYLE32) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE2();
			// ���ID�FTYPE2
		}

		// claimStyleType�̒l��10411�̏ꍇ
		// �l��4
		if (getClaimStyleType() == FORMAT_STYLE4) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE3();
			// ���ID�FTYPE3
			// �ȉ��̃R���g���[���̃L���v�V������"���莡�Ô�"�ɐݒ肷��B
			// �EparticularInfos
			getEtcInfoTabs().setTitleAt(2, "���莡�Ô�");
		}

		// claimStyleType�̒l��10412�̏ꍇ
		// �l��4��2
		if (getClaimStyleType() == FORMAT_STYLE42) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE3();
			// ���ID�FTYPE3
			// �ȉ��̃R���g���[���̃L���v�V������"���莡�Ô�"�ɐݒ肷��B
			// �EparticularInfos
			getEtcInfoTabs().setTitleAt(2, "���莡�Ô�");
		}

		// claimStyleType�̒l��10511�̏ꍇ
		// �l��5
		if (getClaimStyleType() == FORMAT_STYLE5) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE4();
			// ���ID�FTYPE4
			// �ȉ��̃R���g���[���̃L���v�V������"����f�Ô�"�ɐݒ肷��B
			// �EparticularInfos
			// �EparticularInfoLabel
			// �EparticularInfoRevision
			getEtcInfoTabs().setTitleAt(2, "����f�Ô�");
			getParticularInfoLabel().setText("����f�Ô�");
			getParticularInfoRevision().setText("����f�Ô�");
		}

		// claimStyleType�̒l��10512�̏ꍇ
		// �l��5��2
		if (getClaimStyleType() == FORMAT_STYLE52) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE4();
			// ���ID�FTYPE4
			// �ȉ��̃R���g���[���̃L���v�V������"����f�Ô�"�ɐݒ肷��B
			// �EparticularInfos
			// �EparticularInfoLabel
			// �EparticularInfoRevision
			getEtcInfoTabs().setTitleAt(2, "����f�Ô�");
			getParticularInfoLabel().setText("����f�Ô�");
			getParticularInfoRevision().setText("����f�Ô�");
		}

		// claimStyleType�̒l��10611�̏ꍇ
		// �l��6
		if (getClaimStyleType() == FORMAT_STYLE6) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE5();
			// ���ID�FTYPE5
		}

		// claimStyleType�̒l��10612�̏ꍇ
		// �l��6��2
		if (getClaimStyleType() == FORMAT_STYLE62) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE5();
			// ���ID�FTYPE5
		}
		
		// claimStyleType�̒l��10613�̏ꍇ
		// �l��6��3
		if (getClaimStyleType() == FORMAT_STYLE63) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE5();
			// ���ID�FTYPE5
		}
		
		// claimStyleType�̒l��10614�̏ꍇ
		// �l��6��3
		if (getClaimStyleType() == FORMAT_STYLE64) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE5();
			// ���ID�FTYPE5
		}

		// claimStyleType�̒l��10615�̏ꍇ
		// �l��6��5
		if (getClaimStyleType() == FORMAT_STYLE65) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE5();
			// ���ID�FTYPE5
		}

		// claimStyleType�̒l��10616�̏ꍇ
		// �l��6��6
		if (getClaimStyleType() == FORMAT_STYLE66) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE5();
			// ���ID�FTYPE5
		}
		
        // claimStyleType�̒l��10617�̏ꍇ
        // �l��6��7
        if (getClaimStyleType() == FORMAT_STYLE67) {
            // ��ʂ�Visible����EEnable������s���B
            setState_TYPE5();
            // ���ID�FTYPE5
        }

		
		// claimStyleType�̒l��10711�̏ꍇ
		// �l��7
		if (getClaimStyleType() == FORMAT_STYLE7) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE6();
			// ���ID�FTYPE6
		}

		// claimStyleType�̒l��10712�̏ꍇ
		// �l��7
		if (getClaimStyleType() == FORMAT_STYLE72) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE6();
			// ���ID�FTYPE6
		}
		
		// claimStyleType�̒l��10811�̏ꍇ
		// �l��8
		if (getClaimStyleType() == FORMAT_STYLE8) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE2();
			// ���ID�FTYPE2
		}

		// claimStyleType�̒l��10911�̏ꍇ
		// �l��9
		if (getClaimStyleType() == FORMAT_STYLE9) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE3();
			// ���ID�FTYPE3
			// �ȉ��̃R���g���[���̃L���v�V������"���莡�Ô�"�ɐݒ肷��B
			// �EparticularInfos
			getEtcInfoTabs().setTitleAt(2, "���莡�Ô�");
		}

		// claimStyleType�̒l��11011�̏ꍇ
		// �l��10
		if (getClaimStyleType() == FORMAT_STYLE10) {
			// ��ʂ�Visible����EEnable������s���B
			setState_TYPE4();
			// ���ID�FTYPE4
			// �ȉ��̃R���g���[���̃L���v�V������"����f�Ô�"�ɐݒ肷��B
			// �EparticularInfos
			// �EparticularInfoLabel
			// �EparticularInfoRevision
			getEtcInfoTabs().setTitleAt(2, "����f�Ô�");
			getParticularInfoLabel().setText("����f�Ô�");
			getParticularInfoRevision().setText("����f�Ô�");
		}
	}

	/**
	 * �u�}�X�^�f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFindComment() throws Exception {
		// ���ڃR�����g�}�X�^�iM_DETAIL_COMMENT�jTABLE���f�[�^���擾���鏈���B
		// SQL���擾�pVRMap param�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
		// �EKEY�FTARGET_DATE VALUE�FtargetDate
		VRMap param = new VRHashMap();
		param.setData("TARGET_DATE", getTargetDate());

		// �}�X�^�f�[�^�擾�p��SQL�����擾����B
		// �ESQL_ID�FGET_DETAIL_COMMENT
		// �}�X�^�f�[�^���擾���AdetailCommentList�Ɋi�[����B
		setDetailCommentList(getDBManager().executeQuery(getSQL_GET_DETAIL_COMMENT(param)));
		
		//[ID:0000452][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
		switch (getClaimStyleType()){
		case FORMAT_STYLE2:
		case FORMAT_STYLE22:
		case FORMAT_STYLE23: // 2016.7.22 [Shinobu Hitaka] add �������ƑΉ�
			Integer categoryNo = new Integer("2");
			Integer commentId = new Integer("22");
			for (int i = 0; i < getDetailCommentList().getDataSize(); i++){
				VRMap map = (VRMap)getDetailCommentList().get(i);
				if (categoryNo.equals(map.get("CATEGORY_NO"))
					&&	commentId.equals(map.get("COMMENT_ID"))){
					// 2016.7.22 [Shinobu Hitaka] edit - begin �������ƑΉ�
					//map.put("COMMENT", "1:��Y�� 3:��Ë@�֓��@ 4:���S 5:���̑� 6:���V�l�����{�ݓ��� 7:���V�l�ی��{�ݓ��� 8:���×{�^��Î{�ݓ��@");
					if (getClaimStyleType() != FORMAT_STYLE23) {
						map.put("COMMENT", "1:��Y�� 3:��Ë@�֓��@ 4:���S 5:���̑� 6:���V�l�����{�ݓ��� 7:���V�l�ی��{�ݓ��� 8:���×{�^��Î{�ݓ��@");
					} else {
						map.put("COMMENT", "�ݒ�s�v�ł��B");
					}
					// 2016.7.22 [Shinobu Hitaka] edit - end
					break;
				}
			}
			break;
		}
		//[ID:0000452][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
	}

	/**
	 * �u�����f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFindClaim() throws Exception {
		// �����f�[�^���擾���鏈���B
		// �����f�[�^���擾���邽�߂́AWHERE����쐬����B
		// WHERE��
		// (PATIENT_ID = patientId)
		// AND (INSURED_ID = insuredId)
		// AND (TARGET_DATE = targetDate)
		// AND (CLAIM_DATE = claimDate)
		// AND (PROVIDER_ID = providerId)
		// AND (CLAIM_STYLE_TYPE = claimStyleType)
		String whereStr = "(PATIENT_ID = " + getPatientId() + ") " + "AND (INSURED_ID = '" + getInsuredId() + "') " + "AND (TARGET_DATE = '" + VRDateParser.format(getTargetDate(), "yyyy-MM-dd") + "') " + "AND (CLAIM_DATE = '" + VRDateParser.format(getClaimDate(), "yyyy-MM-dd") + "') " + "AND (PROVIDER_ID = '" + getProviderId() + "') " + "AND (CLAIM_STYLE_TYPE = " + getClaimStyleType() + ") ";

		// �����f�[�^���擾���AclaimList�Ɋi�[����B
		// �����Ǘ��e�[�u�����X�V����\��������׃g�����U�N�V���������Ŏ��s����
		try {

			// �g�����U�N�V�������J�n����B
			getDBManager().beginTransaction();

			VRList claimList = QkanCommon.getClaimDetailCustom(getDBManager(), getClaimDate(), whereStr);
			setClaimList(claimList);

			// �R�~�b�g����
			getDBManager().commitTransaction();

			// �p�b�V�u�`�F�b�N�p�ɑޔ�����B
			getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), getClaimList());

		} catch (Exception ex) {
			// �X�V�Ɏ��s�����ꍇ
			// ���[���o�b�N����B
			getDBManager().rollbackTransaction();
			// ��O�𓊂���B
			// �i�ُ�I���j
			throw ex;
		}

	}

	/**
	 * �u��ʃe�[�u���̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doSetTable() throws Exception {
		// ��ʂ̃e�[�u���̐ݒ���s�������B
		
		// claimList�����Ɍ��Ă����B�i���[�v�J�n�j
		Iterator claimListIterator = getClaimList().iterator();
		while (claimListIterator.hasNext()) {
			VRMap claimDataMap = (VRMap) claimListIterator.next();

			// ���R�[�h�̊i�[�����AclaimDataMap��doMoveRecord�ɓn���B
			doMoveRecord(claimDataMap);
		}
		
		switch (getClaimStyleType()) {
			case FORMAT_STYLE2:
				// claimStyleType�̒l��10211�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11001010�i2�i���\�L�j
// 2014/12/24 [Yoichiro Kamei] mod - begin �Z���n����Ή�
//				doSetTableModel(202);
				
				//�E�������F10011001010�i2�i���\�L�j
				doSetTableModel(1226);
// 2014/12/24 [Yoichiro Kamei] mod - end

				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11001010�i2�i���\�L�j
// 2014/12/24 [Yoichiro Kamei] mod - begin �Z���n����Ή�
//				doSetTableRow(202);
				
				//�E�������F10011001010�i2�i���\�L�j
				doSetTableRow(1226);
// 2014/12/24 [Yoichiro Kamei] mod - end

				break;

			case FORMAT_STYLE22:
				// claimStyleType�̒l��10212�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11001010�i2�i���\�L�j
// 2014/12/24 [Yoichiro Kamei] mod - begin �Z���n����Ή�
//				doSetTableModel(202);
				//�E�������F10011001010�i2�i���\�L�j
				doSetTableModel(1226);
// 2014/12/24 [Yoichiro Kamei] mod - end
				
				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11001010�i2�i���\�L�j
// 2014/12/24 [Yoichiro Kamei] mod - begin �Z���n����Ή�
//				doSetTableRow(202);
				//�E�������F10011001010�i2�i���\�L�j
				doSetTableRow(1226);
// 2014/12/24 [Yoichiro Kamei] mod - end
				
				break;

			// 2016/7/8 [Shinobu Hitaka] add - begin �������ƑΉ�
			case FORMAT_STYLE23:
				// claimStyleType�̒l��10213�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				//�E�������F10011001010�i2�i���\�L�j
				doSetTableModel(1226);
				
				// �e�[�u���̊e�s�̐ݒ���s���B
				//�E�������F10011001010�i2�i���\�L�j
				doSetTableRow(1226);
				
				break;
			// 2016/7/8 [Shinobu Hitaka] add - end
							
			case FORMAT_STYLE3:
				// claimStyleType�̒l��10311�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11001110�i2�i���\�L�j
				doSetTableModel(206);

				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11001110�i2�i���\�L�j
				doSetTableRow(206);
				break;

			case FORMAT_STYLE32:
				// claimStyleType�̒l��10312�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11001110�i2�i���\�L�j
				doSetTableModel(206);

				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11001110�i2�i���\�L�j
				doSetTableRow(206);
				break;

				
			case FORMAT_STYLE4:
				// claimStyleType�̒l��10411�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				
				//[H20.5 �@�����Ή�] fujihara edit start
				//doSetTableModel(236);
				doSetTableModel(492);
				// �E�������F11101100�i2�i���\�L�j

				// �e�[�u���̊e�s�̐ݒ���s���B
				//doSetTableRow(236);
				doSetTableRow(492);
				// �E�������F11101100�i2�i���\�L�j
				//[H20.5 �@�����Ή�] fujihara edit end

				break;

			case FORMAT_STYLE42:
				// claimStyleType�̒l��10412�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				//[H20.5 �@�����Ή�] fujihara edit start
				//doSetTableModel(236);
				doSetTableModel(492);
				// �E�������F11101100�i2�i���\�L�j

				// �e�[�u���̊e�s�̐ݒ���s���B
				//doSetTableRow(236);
				doSetTableRow(492);
				// �E�������F11101100�i2�i���\�L�j
				//[H20.5 �@�����Ή�] fujihara edit end

				break;

				
			case FORMAT_STYLE5:
				// claimStyleType�̒l��10511�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11011100�i2�i���\�L�j
				doSetTableModel(220);
				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11011100�i2�i���\�L�j
				doSetTableRow(220);
				break;

			case FORMAT_STYLE52:
				// claimStyleType�̒l��10512�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11011100�i2�i���\�L�j
				doSetTableModel(220);
				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11011100�i2�i���\�L�j
				doSetTableRow(220);
				break;

				
			case FORMAT_STYLE6:
				// claimStyleType�̒l��10611�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11001000�i2�i���\�L�j
				doSetTableModel(200);

				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11001000�i2�i���\�L�j
				doSetTableRow(200);
				break;

			case FORMAT_STYLE62:
				// claimStyleType�̒l��10612�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11001000�i2�i���\�L�j
				doSetTableModel(200);

				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11001000�i2�i���\�L�j
				doSetTableRow(200);
				break;

				
			case FORMAT_STYLE63:
				// claimStyleType�̒l��10613�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11001000�i2�i���\�L�j
				doSetTableModel(200);

				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11001000�i2�i���\�L�j
				doSetTableRow(200);
				break;

			case FORMAT_STYLE64:
				// claimStyleType�̒l��10614�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11001000�i2�i���\�L�j
				doSetTableModel(200);

				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11001000�i2�i���\�L�j
				doSetTableRow(200);
				break;

				
			case FORMAT_STYLE65:
				// claimStyleType�̒l��10615�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11001000�i2�i���\�L�j
				doSetTableModel(200);

				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11001000�i2�i���\�L�j
				doSetTableRow(200);
				break;

			case FORMAT_STYLE66:
				// claimStyleType�̒l��10616�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11001000�i2�i���\�L�j
				doSetTableModel(200);

				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11001000�i2�i���\�L�j
				doSetTableRow(200);
				break;
				
            case FORMAT_STYLE67:
                // claimStyleType�̒l��10617�̏ꍇ
                // �e�[�u�����f���̐ݒ���s���B
                // �E�������F11001000�i2�i���\�L�j
                doSetTableModel(200);

                // �e�[�u���̊e�s�̐ݒ���s���B
                // �E�������F11001000�i2�i���\�L�j
                doSetTableRow(200);
                break;

			case FORMAT_STYLE7:
				// claimStyleType�̒l��10711�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F00000001�i2�i���\�L�j
				doSetTableModel(1);

				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F00000001�i2�i���\�L�j
				doSetTableRow(1);
				break;

			case FORMAT_STYLE72:
				// claimStyleType�̒l��10712�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F00000001�i2�i���\�L�j
				doSetTableModel(1);

				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F00000001�i2�i���\�L�j
				doSetTableRow(1);
				break;

				
			case FORMAT_STYLE8:
				// claimStyleType�̒l��10801�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11001110�i2�i���\�L�j
				doSetTableModel(206);

				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11001110�i2�i���\�L�j
				doSetTableRow(206);
				break;

			case FORMAT_STYLE9:
				// claimStyleType�̒l��10901�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11101100�i2�i���\�L�j
				//[H20.5 �@�����Ή�] fujihara edit start
				//doSetTableModel(236);
				//doSetTableModel(492);
				doSetTableModel(972);

				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11101100�i2�i���\�L�j
				//doSetTableRow(236);
				//doSetTableRow(492);
				doSetTableRow(972);
				//[H20.5 �@�����Ή�] fujihara edit end
				break;

			case FORMAT_STYLE10:
				// claimStyleType�̒l��11001�̏ꍇ
				// �e�[�u�����f���̐ݒ���s���B
				// �E�������F11011100�i2�i���\�L�j
				doSetTableModel(220);

				// �e�[�u���̊e�s�̐ݒ���s���B
				// �E�������F11011100�i2�i���\�L�j
				doSetTableRow(220);
				break;

			default:
				break;

		}
		
		// �����f�[�^���e�[�u�����f���ɐݒ肷��B
		doSetClaimData();
	}

	/**
	 * �u���R�[�h�̊i�[�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doMoveRecord(VRMap claimDataMap) throws Exception {
		// �����f�[�^���e�J�e�S�����ƂɊi�[���鏈���B
		// claimDataMap����L�["CATEGORY_NO"���擾����B
		int categoryNo = ACCastUtilities.toInt(claimDataMap.getData("CATEGORY_NO"));

		// �擾����"CATEGORY_NO"�ɂ���ă��R�[�h�𔻕ʂ��ăe�[�u���ɒǉ�����B
		switch (categoryNo) {
			case 2:
				// categoryNo�̒l��2�̏ꍇ
				// tableClaimList1��record��ǉ�����B
				getTableClaimList1().addData(claimDataMap);
				break;

			case 3:
				// categoryNo�̒l��3�̏ꍇ
				// tableClaimList2��record��ǉ�����B
				getTableClaimList2().addData(claimDataMap);
				break;

			case 4:
			case 17:
				// categoryNo�̒l��4�܂���17�̏ꍇ
				// tableClaimList3��record��ǉ�����B
				getTableClaimList3().addData(claimDataMap);
				break;

			case 5:
				// categoryNo�̒l��5�̏ꍇ
				// tableClaimList3��record��ǉ�����B
				
				//[H20.5 �@�����Ή�] fujihara edit start
				//�l����l�A��l�̓�A���̏ꍇ�́AtableClaimList7�ɐݒ肷��
				switch (getClaimStyleType()){
					case FORMAT_STYLE4:
					case FORMAT_STYLE42:
					case FORMAT_STYLE9:
						getTableClaimList7().addData(claimDataMap);
						break;
					default:
						getTableClaimList3().addData(claimDataMap);
						break;
				
				}
				//[H20.5 �@�����Ή�] fujihara edit start
				break;

			case 7:
				// categoryNo�̒l��7�̏ꍇ
				// tableClaimList4��record��ǉ�����B
				getTableClaimList4().addData(claimDataMap);
				break;

			case 8:
				// categoryNo�̒l��8�̏ꍇ
				// tableClaimList5��record��ǉ�����B
				getTableClaimList5().addData(claimDataMap);
				break;

			case 9:
				// categoryNo�̒l��9�̏ꍇ
				// tableClaimList6��record��ǉ�����B
				getTableClaimList6().addData(claimDataMap);
				break;

			case 10:
				// categoryNo�̒l��10�̏ꍇ
				// tableClaimList2��record��ǉ�����B
				getTableClaimList2().addData(claimDataMap);
				break;
// 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
			case 18:
				// categoryNo�̒l��18�̏ꍇ
				// tableClaimList8��record��ǉ�����B
				getTableClaimList8().addData(claimDataMap);
				break;
// 2014/12/24 [Yoichiro Kamei] add - end
			default:
				break;
		}
	}

	/**
	 * �u�e�[�u�����f���̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doSetTableModel(int firstArg) throws Exception {
		// �e�[�u�����f���̐ݒ���s�������B
		// ��������10000000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 128) == 0)) {
			// ����{���e�[�u���Ɗ�{���ڍ׃e�[�u���̃e�[�u�����f���̐ݒ�B
			// tableModelList1���ȉ��̃t�B�[���h�Őݒ肷��B

			String[] tableModelList1 = new String[14];
			tableModelList1[0] = "201005"; // "201005�i�ی��Ҕԍ��j"
			tableModelList1[1] = "201006"; // "201006�i��ی��Ҕԍ��j"
			tableModelList1[2] = "201015"; // "201015�i�v���x��ԋ敪�R�[�h�j"
			tableModelList1[3] = "201017"; // "201017�i�F��L�����ԊJ�n�j"
			tableModelList1[4] = "201018"; // "201018�i�F��L�����ԏI���j"
			tableModelList1[5] = "201020"; // "201020�i����T�[�r�X�v��Ҏ��Ə��ԍ��j"
			tableModelList1[6] = "201057"; // "201057�i����T�[�r�X�v��Ҏ��Ə����j"
			tableModelList1[7] = "201021"; // "201021�i�J�n�N�����j"
			tableModelList1[8] = "201022"; // "201022�i���~�N�����j"
			tableModelList1[9] = "201023"; // "201023�i���~���R�R�[�h�j"
			tableModelList1[10] = "201024"; // "201024�i�����i�@�j�N�����j"
			tableModelList1[11] = "201025"; // "201025�i�ޏ��i�@�j�N�����j"
			tableModelList1[12] = "201026"; // "201026�i�����i�@�j�������j"
			tableModelList1[13] = "201061"; // "201061�i�叝�a���j"

			// �i�[
			setTableModelList1(new ACTableModelAdapter());
			getTableModelList1().setColumns(tableModelList1);

			// tableModelList1����{���e�[�u���ibasicInfoTable�j�ɐݒ肷��B
			getBasicInfoTable().setModel(getTableModelList1());

			// tableModelDetail1���ȉ��̃t�B�[���h�Őݒ肷��B
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail1 = new String[3];
			tableModelDetail1[0] = "DETAIL_NAME";
			tableModelDetail1[1] = "DETAIL_VALUE";
			tableModelDetail1[2] = "COMMENT";

			// �i�[
			setTableModelDetail1(new ACTableModelAdapter());
			getTableModelDetail1().setColumns(tableModelDetail1);

			// tableModelDetail1����{���ڍ׃e�[�u���ibasicInfoRevisionTable�j�ɐݒ肷��B
			getBasicInfoRevisionTable().setModel(getTableModelDetail1());

			// ���L���v�V�����̐ݒ�
			// �ȉ��̃��x���̃L���v�V������ "��{���" ��ݒ肷��B
			// etcInfoTabs
			// basicInfoLabel
			// basicInfoRevisionLabel2
			getEtcInfoTabs().setTitleAt(0, "��{���");
			getBasicInfoLabel().setText("��{���");
			getBasicInfoRevisionLabel2().setText("��{���");
		}

		// ��������01000000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 64) == 0)) {
			// �����׏��e�[�u���Ɩ��׏��ڍ׃e�[�u���̃e�[�u�����f���̐ݒ�B
			// tableModelList2���ȉ��̃t�B�[���h�Őݒ肷��B

			String[] tableModelList2 = new String[12];
			tableModelList2[0] = "301007+''+301008"; // "301007+301008"
			tableModelList2[1] = "301019"; // "301019�i�T�[�r�X���́j"
			tableModelList2[2] = "301009"; // "301009�i�P�ʐ��j"
			tableModelList2[3] = "301010"; // "301010�i������񐔁j"
			tableModelList2[4] = "301011"; // "301011�i����1�Ώۓ����E�񐔁j"
			tableModelList2[5] = "301012"; // "301012�i����2�Ώۓ����E�񐔁j"
			tableModelList2[6] = "301013"; // "301013�i����3�Ώۓ����E�񐔁j"
			tableModelList2[7] = "301014"; // "301014�i�T�[�r�X�P�ʐ��j"
			tableModelList2[8] = "301015"; // "301015�i����1�ΏۃT�[�r�X�P�ʐ��j"
			tableModelList2[9] = "301016"; // "301016�i����2�ΏۃT�[�r�X�P�ʐ��j"
			tableModelList2[10] = "301017"; // "301017�i����3�ΏۃT�[�r�X�P�ʐ��j"
			tableModelList2[11] = "301018"; // "301018�i�E�v�j"

			// �i�[
			setTableModelList2(new ACTableModelAdapter());
			getTableModelList2().setColumns(tableModelList2);

			// tableModelList2�𖾍׏��e�[�u���idetailsInfoTable�j�ɐݒ肷��B
			getDetailsInfoTable().setModel(getTableModelList2());

			// tableModelDetail2���ȉ��̃t�B�[���h�Őݒ肷��B
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail2 = new String[3];
			tableModelDetail2[0] = "DETAIL_NAME";
			tableModelDetail2[1] = "DETAIL_VALUE";
			tableModelDetail2[2] = "COMMENT";

			// �i�[
			setTableModelDetail2(new ACTableModelAdapter());
			getTableModelDetail2().setColumns(tableModelDetail2);

			// tableModelDetail2�𖾍׏��ڍ׃e�[�u���idetailsInfoRevisionTable�j�ɐݒ肷��B
			getDetailsInfoRevisionTable().setModel(getTableModelDetail2());

			// ���L���v�V�����̐ݒ�
			// �ȉ��̃��x���̃L���v�V������ "���׏��" ��ݒ肷��B
			// detailsInfos
			// detailsInfoLabel
			// detailsInfoRevision
			getEtcInfoTabs().setTitleAt(1, "���׏��");
			getDetailsInfoLabel().setText("���׏��");
			getDetailsInfoRevision().setText("���׏��");

		}

		// ��������00100000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 32) == 0)) {
			// �����莡�Ô���e�[�u���Ɠ��莡�Ô�E����f�Ô���ڍ׃e�[�u���̃e�[�u�����f���̐ݒ�B
			// tableModelList3���ȉ��̃t�B�[���h�Őݒ肷��B

			String[] tableModelList3 = new String[19];
			tableModelList3[0] = "401004"; // "401004�i���Ə��ԍ��j"
			tableModelList3[1] = "401008"; // "401008�i�ً}�����a��1�j"
			tableModelList3[2] = "401009"; // "401009�i�ً}�����a��2�j"
			tableModelList3[3] = "401010"; // "401010�i�ً}�����a��3�j"
			tableModelList3[4] = "401011"; // "401011�i�ً}�����ÊJ�n�N����1�j"
			tableModelList3[5] = "401012"; // "401012�i�ً}�����ÊJ�n�N����2�j"
			tableModelList3[6] = "401013"; // "401013�i�ً}�����ÊJ�n�N����3�j"
			tableModelList3[7] = "401014"; // "401014�i���f�����j"
			tableModelList3[8] = "401015"; // "401015�i���f��Ë@�֖��j"
			tableModelList3[9] = "401016"; // "401016�i�ʉ@�����j"
			tableModelList3[10] = "401017"; // "401017�i�ʉ@��Ë@�֖��j"
			tableModelList3[11] = "401018"; // "401018�i�ً}�����ÊǗ��P�ʐ��j"
			tableModelList3[12] = "401019"; // "401019�i�ً}�����ÊǗ������j"
			tableModelList3[13] = "401020"; // "401020�i�ً}�����ÊǗ����v�j"
			tableModelList3[14] = "401021"; // "401021(���n�r���e�[�V�����_���j"
			tableModelList3[15] = "401022"; // "401022�i���u�_���j"
			tableModelList3[16] = "401023"; // "401023�i��p�_���j"
			tableModelList3[17] = "401024"; // "401024�i�����_���j"
			tableModelList3[18] = "401025"; // "401025�i���ː����Ó_���j"

			// �i�[
			setTableModelList3(new ACTableModelAdapter());
			getTableModelList3().setColumns(tableModelList3);
			// tableModelList3����莡�Ô���e�[�u���iparticularInfoTable�j�ɐݒ肷��B
			getParticularInfoTable().setModel(getTableModelList3());

			// tableModelDetail3���ȉ��̃t�B�[���h�Őݒ肷��B
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail3 = new String[3];
			tableModelDetail3[0] = "DETAIL_NAME";
			tableModelDetail3[1] = "DETAIL_VALUE";
			tableModelDetail3[2] = "COMMENT";

			// �i�[
			setTableModelDetail3(new ACTableModelAdapter());
			getTableModelDetail3().setColumns(tableModelDetail3);

			// tableModelDetail3����莡�Ô�E����f�Ô���ڍ׃e�[�u���iparticularInfoRevisionTable�j�ɐݒ肷��B
			getParticularInfoRevisionTable().setModel(getTableModelDetail3());

			// ���L���v�V�����̐ݒ�
			// �ȉ��̃��x���̃L���v�V������ "���莡�Ô���" ��ݒ肷��B
			// particularInfos
			// particularInfoLabel
			// particularInfoRevision
			getEtcInfoTabs().setTitleAt(2, "���莡�Ô���");
			getParticularInfoLabel().setText("���莡�Ô���");
			getParticularInfoRevision().setText("���莡�Ô���");

		}

		// ��������00010000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 16) == 0)) {
			// ������f�Ô���e�[�u���Ɠ��莡�Ô�E����f�Ô���ڍ׃e�[�u���̃e�[�u�����f���̐ݒ�B
			// tableModelList3���ȉ��̃t�B�[���h�Őݒ肷��B

			String[] tableModelList3 = new String[12];
			tableModelList3[0] = "501004"; // "501004�i���Ə��ԍ��j"
			tableModelList3[1] = "501007"; // "501007�i���R�[�h�����ԍ��j"
			tableModelList3[2] = "501008"; // "501008�i���a���j"
			tableModelList3[3] = "501009"; // "501009�i���ʔԍ��j"
			tableModelList3[4] = "501010"; // "501010�i�P�ʐ��j"
			tableModelList3[5] = "501011"; // "501011�i�ی��񐔁j"
			tableModelList3[6] = "501012"; // "501012�i�ی��T�[�r�X�P�ʐ��j"
			tableModelList3[7] = "501013"; // "501013�i�ی����v�P�ʐ��j"
			tableModelList3[8] = "501014"; // "501014�i����1�񐔁j"
			tableModelList3[9] = "501017"; // "501017�i����2�񐔁j"
			tableModelList3[10] = "501020"; // "501020�i����3�񐔁j"
			tableModelList3[11] = "501023"; // "501023�i�E�v�j"

			// �i�[
			setTableModelList3(new ACTableModelAdapter());
			getTableModelList3().setColumns(tableModelList3);

			// tableModelList3�����f�Ô���e�[�u���ispecialClinicInfoTable�j�ɐݒ肷��B
			getSpecialClinicInfoTable().setModel(getTableModelList3());
			// getParticularInfoTable().setModel(getTableModelList3());

			// tableModelDetail3���ȉ��̃t�B�[���h�Őݒ肷��B
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail3 = new String[3];
			tableModelDetail3[0] = "DETAIL_NAME";
			tableModelDetail3[1] = "DETAIL_VALUE";
			tableModelDetail3[2] = "COMMENT";

			// �i�[
			setTableModelDetail3(new ACTableModelAdapter());
			getTableModelDetail3().setColumns(tableModelDetail3);

			// tableModelDetail3����莡�Ô�E����f�Ô���ڍ׃e�[�u���iparticularInfoRevisionTable�j�ɐݒ肷��B
			getParticularInfoRevisionTable().setModel(getTableModelDetail3());

			// ���L���v�V�����̐ݒ�
			// �ȉ��̃��x���̃L���v�V������ "����f�Ô���" ��ݒ肷��B
			// particularInfos
			// particularInfoLabel
			// particularInfoRevision
			getEtcInfoTabs().setTitleAt(2, "����f�Ô���");
			getParticularInfoLabel().setText("����f�Ô���");
			getParticularInfoRevision().setText("����f�Ô���");

		}

		// ��������00001000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 8) == 0)) {
			// ���W�v���e�[�u���ƏW�v���ڍ׃e�[�u���̃e�[�u�����f���̐ݒ�B
			// tableModelList4���ȉ��̃t�B�[���h�Őݒ肷��B
			String[] tableModelList4 = new String[20];
			tableModelList4[0] = "701007"; // "701007�i�T�[�r�X��ރR�[�h�j"
			tableModelList4[1] = "701008"; // "701008�i�T�[�r�X�������j"
			tableModelList4[2] = "701009"; // "701009�i�v��P�ʐ��j"
			tableModelList4[3] = "701010"; // "701010�i���x�z�Ǘ��ΏےP�ʐ��j"
			tableModelList4[4] = "701011"; // "701011�i���x�z�Ǘ��ΏۊO�P�ʐ��j"
			tableModelList4[5] = "701012"; // "701012�i�Z�������v������j"
			tableModelList4[6] = "701013"; // "701013�i�Z�������������j"
			tableModelList4[7] = "701014"; // "701014�i�ی��P�ʐ����v�j"
			tableModelList4[8] = "701015"; // "701015�i�ی��P�ʐ��P���j"
			tableModelList4[9] = "701016"; // "701016�i�ی������z�j"
			tableModelList4[10] = "701017"; // "701017�i�ی����p�ҕ��S�z�j"
			tableModelList4[11] = "701019"; // "701019�i����1�����z�j"
			tableModelList4[12] = "701020"; // "701020�i����1�{�l���S�z�j"
			tableModelList4[13] = "701022"; // "701022�i����2�����z�j"
			tableModelList4[14] = "701023"; // "701023�i����2�{�l���S�z�j"
			tableModelList4[15] = "701025"; // "701025�i����3�����z�j"
			tableModelList4[16] = "701026"; // "701026�i����3�{�l���S�z�j"
			tableModelList4[17] = "701027"; // "701027�i�ی����o������Ô�P�ʐ����v�j"
			tableModelList4[18] = "701028"; // "701028�i�ی����o������Ô���z�j"
			tableModelList4[19] = "701029"; // "701029�i�ی����o������Ô�o������Ô�p�ҕ��S�z�j"

			// �i�[
			setTableModelList4(new ACTableModelAdapter());
			getTableModelList4().setColumns(tableModelList4);

			// tableModelList4���W�v���e�[�u���itotalInfoTable�j�ɐݒ肷��B
			getTotalInfoTable().setModel(getTableModelList4());

			// tableModelDetail4���ȉ��̃t�B�[���h�Őݒ肷��B
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail4 = new String[3];
			tableModelDetail4[0] = "DETAIL_NAME";
			tableModelDetail4[1] = "DETAIL_VALUE";
			tableModelDetail4[2] = "COMMENT";

			// �i�[
			setTableModelDetail4(new ACTableModelAdapter());
			getTableModelDetail4().setColumns(tableModelDetail4);
			// tableModelDetail4���W�v���ڍ׃e�[�u���itotalInfoRevisionTable�j�ɐݒ肷��B
			getTotalInfoRevisionTable().setModel(getTableModelDetail4());

			// ���L���v�V�����̐ݒ�
			// �ȉ��̃��x���̃L���v�V������ "�W�v���" ��ݒ肷��B
			// totalInfos
			// totalInfoLabel
			// totalInfoRevision
			getEtcInfoTabs().setTitleAt(3, "�W�v���");
			getTotalInfoLabel().setText("�W�v���");
			getTotalInfoRevision().setText("�W�v���");
		}
		// ��������00000100�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 4) == 0)) {
			// ����������҉�����e�[�u���Ɠ�������҉�����ڍ׃e�[�u���̃e�[�u�����f���̐ݒ�B
			// tableModelList5���ȉ��̃t�B�[���h�Őݒ肷��B
			String[] tableModelList5 = new String[27];
			tableModelList5[0] = "801007"; // "801007�i���R�[�h�����ԍ��j"
			tableModelList5[1] = "801008+''+801009"; // "801008+801009"
			tableModelList5[2] = "801034"; // "801034�i�T�[�r�X���́j"
			tableModelList5[3] = "801010"; // "801010�i��p�P���j"
			tableModelList5[4] = "801011"; // "801011�i���S���x�z�j"
			tableModelList5[5] = "801012"; // "801012�i�����j"
			tableModelList5[6] = "801013"; // "801013�i����1�����j"
			tableModelList5[7] = "801014"; // "801014�i����2�����j"
			tableModelList5[8] = "801015"; // "801015�i����3�����j"
			tableModelList5[9] = "801016"; // "801016�i��p�z�j"
			tableModelList5[10] = "801017"; // "801017�i�ی��������z�j"
			tableModelList5[11] = "801018"; // "801018�i����1���S�z���ׁj"
			tableModelList5[12] = "801019"; // "801019�i����2���S�z���ׁj"
			tableModelList5[13] = "801020"; // "801020�i����3���S�z���ׁj"
			tableModelList5[14] = "801021"; // "801021�i���p�ҕ��S�z�j"
			tableModelList5[15] = "801022"; // "801022�i��p�z���v�j"
			tableModelList5[16] = "801023"; // "801023�i�ی��������z���v�j"
			tableModelList5[17] = "801024"; // "801024�i���p�ҕ��S�z���v�j"
			tableModelList5[18] = "801025"; // "801025�i����1���S�z���v�j"
			tableModelList5[19] = "801026"; // "801026�i����1�����z�j"
			tableModelList5[20] = "801027"; // "801027�i����1�{�l���S���z�j"
			tableModelList5[21] = "801028"; // "801028�i����2���S�z���v�j"
			tableModelList5[22] = "801029"; // "801029�i����2�����z�j"
			tableModelList5[23] = "801030"; // "801030�i����2�{�l���S���z�j"
			tableModelList5[24] = "801031"; // "801031�i����3���S�z���v�j"
			tableModelList5[25] = "801032"; // "801032�i����3�����z�j"
			tableModelList5[26] = "801033"; // "801033�i����3�{�l���S���z�j"

			// �i�[
			setTableModelList5(new ACTableModelAdapter());
			getTableModelList5().setColumns(tableModelList5);

			// tableModelList5���������҉�����e�[�u���inyushoInfoTable�j�ɐݒ肷��B
			getNyushoInfoTable().setModel(getTableModelList5());

			// tableModelDetail5���ȉ��̃t�B�[���h�Őݒ肷��B
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail5 = new String[3];
			tableModelDetail5[0] = "DETAIL_NAME";
			tableModelDetail5[1] = "DETAIL_VALUE";
			tableModelDetail5[2] = "COMMENT";

			// �i�[
			setTableModelDetail5(new ACTableModelAdapter());
			getTableModelDetail5().setColumns(tableModelDetail5);

			// tableModelDetail5���������҉�����ڍ׃e�[�u���inyushoInfoRevisionTable�j�ɐݒ肷��B
			getNyushoInfoRevisionTable().setModel(getTableModelDetail5());

			// ���L���v�V�����̐ݒ�
			// �ȉ��̃��x���̃L���v�V������ "��������҉�����" ��ݒ肷��B
			// nyushoInfos
			// nyushoInfoLabel
			// nyushoInfoRevision
			getEtcInfoTabs().setTitleAt(4, "��������҉�����");
			getNyushoInfoLabel().setText("��������҉�����");
			getNyushoInfoRevision().setText("��������҉�����");
		}

		// ��������00000010�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 2) == 0)) {
			// ���Љ���@�l�y���z���e�[�u���ƎЉ���@�l�y���z���ڍ׃e�[�u���̃e�[�u�����f���̐ݒ�B
			// tableModelList6���ȉ��̃t�B�[���h�Őݒ肷��B
			String[] tableModelList6 = new String[6];
			tableModelList6[0] = "901007"; // "901007�i�y�����j"
			tableModelList6[1] = "901008"; // "901008�i�T�[�r�X��ރR�[�h�j"
			tableModelList6[2] = "901009"; // "901009�i��̂��ׂ����p�ҕ��S�̑��z�j"
			tableModelList6[3] = "901010"; // "901010�i�y���z�j"
			tableModelList6[4] = "901011"; // "901011�i�y���㗘�p�ҕ��S�z�j"
			tableModelList6[5] = "901012"; // "901012�i���l�j"

			// �i�[
			setTableModelList6(new ACTableModelAdapter());
			getTableModelList6().setColumns(tableModelList6);

			// tableModelList6���Љ���@�l�y���z���e�[�u���ishahukuInfoTable�j�ɐݒ肷��B
			getShahukuInfoTable().setModel(getTableModelList6());

			// tableModelDetail6���ȉ��̃t�B�[���h�Őݒ肷��B
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail6 = new String[3];
			tableModelDetail6[0] = "DETAIL_NAME";
			tableModelDetail6[1] = "DETAIL_VALUE";
			tableModelDetail6[2] = "COMMENT";

			// �i�[
			setTableModelDetail6(new ACTableModelAdapter());
			getTableModelDetail6().setColumns(tableModelDetail6);

			// tableModelDetail6���Љ���@�l�y���z���ڍ׃e�[�u���ishahukuInfoRevisionTable�j�ɐݒ肷��B
			getShahukuInfoRevisionTable().setModel(getTableModelDetail6());

			// ���L���v�V�����̐ݒ�
			// �ȉ��̃��x���̃L���v�V������ "�Љ���@�l�y�����" ��ݒ肷��B
			// shahukuInfos
			// shahukuInfoLabel
			// shahukuInfoRevision
			getEtcInfoTabs().setTitleAt(5, "�Љ���@�l�y�����");
			getShahukuInfoLabel().setText("�Љ���@�l�y�����");
			getShahukuInfoRevisionLabel().setText("�Љ���@�l�y�����");
		}

		// ��������00000001�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 1) == 0)) {
			// ��������x�����׏��e�[�u���Ɩ��׏��ڍ׃e�[�u���̃e�[�u�����f���̐ݒ�B
			// tableModelList2���ȉ��̃t�B�[���h�Őݒ肷��B

			//[ID:0000452][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
			/*
			String[] tableModelList2 = new String[17];
			tableModelList2[0] = "1001002"; // "1001002�i���Ə��ԍ��j"
			tableModelList2[1] = "1001003"; // "1001003�i�w��/��Y�������Ə��敪�R�[�h�j"
			tableModelList2[2] = "1001004"; // "1001004�i�T�[�r�X�񋟔N���j"
			tableModelList2[3] = "1001005"; // "1001005�i�ی��Ҕԍ��j"
			tableModelList2[4] = "1001006"; // "1001006�i�P�ʐ��P���j"
			tableModelList2[5] = "1001007"; // "1001007�i��ی��Ҕԍ��j"
			tableModelList2[6] = "1001008"; // "1001008�i����S�Ҕԍ��j"
			tableModelList2[7] = "1001009"; // "1001009�i����󋋎Ҕԍ��j"
			tableModelList2[8] = "1001010"; // "1001010�i���N�����j"
			tableModelList2[9] = "1001011"; // "1001011�i���ʃR�[�h�j"
			tableModelList2[10] = "1001012"; // "1001012�i�v����ԋ敪�R�[�h�j"
			tableModelList2[11] = "1001013"; // "1001013�i�F��L�����ԊJ�n)"
			tableModelList2[12] = "1001014"; // "1001014�i�F��L�����ԏI��)"
			tableModelList2[13] = "1001015"; // "1001015�i����T�[�r�X�v��쐬�˗��͏o�N�����j"
			tableModelList2[14] = "1001016"; // "1001016�i�T�[�r�X�R�[�h�j"
			tableModelList2[15] = "1001017"; // "1001017�i�P�ʐ��j"
			tableModelList2[16] = "1001018"; // "1001018�i�������z�j"
			*/
			String[] tableModelList2 = new String[10];
			tableModelList2[0] = "1001010"; // "1001010 (���N����)"
			tableModelList2[1] = "1001011"; // "1001011 (���ʃR�[�h)"
			tableModelList2[2] = "1001012"; // "1001012 (�v����ԋ敪�R�[�h)"
			tableModelList2[3] = "1001013"; // "1001013 (�F��L�����ԊJ�n��)"
			tableModelList2[4] = "1001014"; // "1001014 (�F��L�����ԏI����)"
			tableModelList2[5] = "1001015"; // "1001015 (����T�[�r�X�v��쐬�˗��͏o�N����)"
			tableModelList2[6] = "1001016"; // "1001016 (�T�[�r�X�R�[�h)"
			tableModelList2[7] = "1001028"; // "1001028 (�T�[�r�X����)"
			tableModelList2[8] = "1001017"; // "1001017 (�P�ʐ�)"
			tableModelList2[9] = "1001018"; // "1001018 (�������z)"
			//[ID:0000452][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�

			// �i�[
			setTableModelList2(new ACTableModelAdapter());
			getTableModelList2().setColumns(tableModelList2);

			// tableModelList2�𖾍׏��e�[�u���idetailsInfoTable�j�ɐݒ肷��B
			//[ID:0000452][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
			//�݌v���̌����C��
			//getDetailsInfoTable().setModel(getTableModelList2());
			getKyotakuDetailsInfoTable().setModel(getTableModelList2());
			//[ID:0000452][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�
			
			// tableModelDetail2���ȉ��̃t�B�[���h�Őݒ肷��B
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail2 = new String[3];
			tableModelDetail2[0] = "DETAIL_NAME";
			tableModelDetail2[1] = "DETAIL_VALUE";
			tableModelDetail2[2] = "COMMENT";

			// �i�[
			setTableModelDetail2(new ACTableModelAdapter());
			getTableModelDetail2().setColumns(tableModelDetail2);

			// tableModelDetail2�𖾍׏��ڍ׃e�[�u���idetailsInfoRevisionTable�j�ɐݒ肷��B
			getDetailsInfoRevisionTable().setModel(getTableModelDetail2());

			// ���L���v�V�����̐ݒ�
			// �ȉ��̃��x���̃L���v�V������ "���׏��" ��ݒ肷��B
			// detailsInfos
			// detailsInfoLabel
			// detailsInfoRevision
			getEtcInfoTabs().setTitleAt(1, "���׏��");
			getDetailsInfoLabel().setText("���׏��");
			getDetailsInfoRevision().setText("���׏��");

		}
		
		//[H20.5 �@�����Ή�] fujihara add start
		//TODO
		// ��������100000000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 256) == 0)) {
			// ������f�Ô���e�[�u���Ɠ��莡�Ô�E����f�Ô���ڍ׃e�[�u���̃e�[�u�����f���̐ݒ�B
			// tableModelList7���ȉ��̃t�B�[���h�Őݒ肷��B

			String[] tableModelList7 = new String[12];
			tableModelList7[0] = "501004"; // "501004�i���Ə��ԍ��j"
			tableModelList7[1] = "501007"; // "501007�i���R�[�h�����ԍ��j"
			tableModelList7[2] = "501008"; // "501008�i���a���j"
			tableModelList7[3] = "501009"; // "501009�i���ʔԍ��j"
			tableModelList7[4] = "501010"; // "501010�i�P�ʐ��j"
			tableModelList7[5] = "501011"; // "501011�i�ی��񐔁j"
			tableModelList7[6] = "501012"; // "501012�i�ی��T�[�r�X�P�ʐ��j"
			tableModelList7[7] = "501013"; // "501013�i�ی����v�P�ʐ��j"
			tableModelList7[8] = "501014"; // "501014�i����1�񐔁j"
			tableModelList7[9] = "501017"; // "501017�i����2�񐔁j"
			tableModelList7[10] = "501020"; // "501020�i����3�񐔁j"
			tableModelList7[11] = "501023"; // "501023�i�E�v�j"

			// �i�[
			setTableModelList7(new ACTableModelAdapter());
			getTableModelList7().setColumns(tableModelList7);

			// tableModelList7�����×{����e�[�u���irecuperationInfoTable�j�ɐݒ肷��B
			getRecuperationInfoTable().setModel(getTableModelList7());

			// tableModelDetail3���ȉ��̃t�B�[���h�Őݒ肷��B
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail7 = new String[3];
			tableModelDetail7[0] = "DETAIL_NAME";
			tableModelDetail7[1] = "DETAIL_VALUE";
			tableModelDetail7[2] = "COMMENT";

			// �i�[
			setTableModelDetail7(new ACTableModelAdapter());
			getTableModelDetail7().setColumns(tableModelDetail7);

			// tableModelDetail7�����×{����ڍ׃e�[�u���irecuperationInfoRevisionTable�j�ɐݒ肷��B
			getRecuperationInfoRevisionTable().setModel(getTableModelDetail7());

		}
		//[H20.5 �@�����Ή�] fujihara add end
		
		
		
		//�ً}���{�ݗ×{��E���{�ݗ×{���񃌃R�[�h
		//���ً}���{�ݗ×{��Ɠ����^�u�ɕ\������
		if (!((firstArg & 512) == 0)) {
            // �ً}���{�ݗ×{��E���{�ݗ×{����ڍ׃e�[�u���̃e�[�u�����f���̐ݒ�B
            // tableModelList3���ȉ��̃t�B�[���h�Őݒ肷��B

            String[] tableModelList3 = new String[19];
            tableModelList3[0] = "1701004"; // "1701004�i���Ə��ԍ��j"
            tableModelList3[1] = "1701008"; // "1701008�i�ً}�����a��1�j"
            tableModelList3[2] = "1701009"; // "1701009�i�ً}�����a��2�j"
            tableModelList3[3] = "1701010"; // "1701010�i�ً}�����a��3�j"
            tableModelList3[4] = "1701011"; // "1701011�i�ً}�����ÊJ�n�N����1�j"
            tableModelList3[5] = "1701012"; // "1701012�i�ً}�����ÊJ�n�N����2�j"
            tableModelList3[6] = "1701013"; // "1701013�i�ً}�����ÊJ�n�N����3�j"
            tableModelList3[7] = "1701014"; // "1701014�i���f�����j"
            tableModelList3[8] = "1701015"; // "1701015�i���f��Ë@�֖��j"
            tableModelList3[9] = "1701016"; // "1701016�i�ʉ@�����j"
            tableModelList3[10] = "1701017"; // "1701017�i�ʉ@��Ë@�֖��j"
            tableModelList3[11] = "1701018"; // "1701018�i�ً}�����ÊǗ��P�ʐ��j"
            tableModelList3[12] = "1701019"; // "1701019�i�ً}�����ÊǗ������j"
            tableModelList3[13] = "1701020"; // "1701020�i�ً}�����ÊǗ����v�j"
            tableModelList3[14] = "1701021"; // "1701021(���n�r���e�[�V�����_���j"
            tableModelList3[15] = "1701022"; // "1701022�i���u�_���j"
            tableModelList3[16] = "1701023"; // "1701023�i��p�_���j"
            tableModelList3[17] = "1701024"; // "1701024�i�����_���j"
            tableModelList3[18] = "1701025"; // "1701025�i���ː����Ó_���j"

            // �i�[
            setTableModelList3(new ACTableModelAdapter());
            getTableModelList3().setColumns(tableModelList3);
            // tableModelList3����莡�Ô���e�[�u���iparticularInfoTable�j�ɐݒ肷��B
            getParticularInfoTable().setModel(getTableModelList3());

            // tableModelDetail3���ȉ��̃t�B�[���h�Őݒ肷��B
            // "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
            String[] tableModelDetail3 = new String[3];
            tableModelDetail3[0] = "DETAIL_NAME";
            tableModelDetail3[1] = "DETAIL_VALUE";
            tableModelDetail3[2] = "COMMENT";

            // �i�[
            setTableModelDetail3(new ACTableModelAdapter());
            getTableModelDetail3().setColumns(tableModelDetail3);

            // tableModelDetail3����莡�Ô�E����f�Ô���ڍ׃e�[�u���iparticularInfoRevisionTable�j�ɐݒ肷��B
            getParticularInfoRevisionTable().setModel(getTableModelDetail3());

            // ���L���v�V�����̐ݒ�
            // �ȉ��̃��x���̃L���v�V������ "���莡�Ô���" ��ݒ肷��B
            // particularInfos
            // particularInfoLabel
            // particularInfoRevision
            getEtcInfoTabs().setTitleAt(2, "���莡�Ô���");
            getParticularInfoLabel().setText("���莡�Ô���");
            getParticularInfoRevision().setText("���莡�Ô���");
		}

// 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
		// ��������10000000000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 1024) == 0)) {
			// �����׏��e�[�u���Ɩ��׏��ڍ׃e�[�u���̃e�[�u�����f���̐ݒ�B
			// tableModelList8���ȉ��̃t�B�[���h�Őݒ肷��B

			String[] tableModelList8 = new String[13];
			tableModelList8[0] = "1801007+''+1801008"; // "1801007+1801008"
			tableModelList8[1] = "1801020"; // "1801020�i�T�[�r�X���́j"
			tableModelList8[2] = "1801009"; // "1801009�i�P�ʐ��j"
			tableModelList8[3] = "1801010"; // "1801010�i������񐔁j"
			tableModelList8[4] = "1801011"; // "1801011�i����1�Ώۓ����E�񐔁j"
			tableModelList8[5] = "1801012"; // "1801012�i����2�Ώۓ����E�񐔁j"
			tableModelList8[6] = "1801013"; // "1801013�i����3�Ώۓ����E�񐔁j"
			tableModelList8[7] = "1801014"; // "1801014�i�T�[�r�X�P�ʐ��j"
			tableModelList8[8] = "1801015"; // "1801015�i����1�ΏۃT�[�r�X�P�ʐ��j"
			tableModelList8[9] = "1801016"; // "1801016�i����2�ΏۃT�[�r�X�P�ʐ��j"
			tableModelList8[10] = "1801017"; // "1801017�i����3�ΏۃT�[�r�X�P�ʐ��j"
			tableModelList8[11] = "1801018"; // "1801018�i�{�ݏ��ݕی��Ҕԍ��j"
			tableModelList8[12] = "1801019"; // "1801019�i�E�v�j"

			// �i�[
			setTableModelList8(new ACTableModelAdapter());
			getTableModelList8().setColumns(tableModelList8);

			// tableModelList8�𖾍׏��e�[�u���idetailsJushotiTokureiInfoTable�j�ɐݒ肷��B
			getDetailsJushotiTokureiInfoTable().setModel(getTableModelList8());

			// tableModelDetail8���ȉ��̃t�B�[���h�Őݒ肷��B
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail8 = new String[3];
			tableModelDetail8[0] = "DETAIL_NAME";
			tableModelDetail8[1] = "DETAIL_VALUE";
			tableModelDetail8[2] = "COMMENT";

			// �i�[
			setTableModelDetail8(new ACTableModelAdapter());
			getTableModelDetail8().setColumns(tableModelDetail8);

			// tableModelDetail8�𖾍׏��ڍ׃e�[�u���idetailsInfoRevisionTable�j�ɐݒ肷��B
			getDetailsJushotiTokureiInfoRevisionTable().setModel(getTableModelDetail8());

			// ���L���v�V�����̐ݒ�
			// �ȉ��̃��x���̃L���v�V������ "���׏��" ��ݒ肷��B
			// detailsInfos
			// detailsInfoLabel
			// detailsInfoRevision
			getEtcInfoTabs().setTitleAt(6, "���׏��i�Z���n����j");
			getDetailsJushotiTokureiLabel().setText("���׏��i�Z���n����j");
			getDetailsJushotiTokureiInfoRevision().setText("���׏��i�Z���n����j");
		}
// 2014/12/24 [Yoichiro Kamei] add - end 
		
	}

	/**
	 * �u�e�[�u���̊e�s�̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doSetTableRow(int firstArg) throws Exception {
		// �ڍ׃e�[�u���̊e�s�̐ݒ���s�������B
		// ��������10000000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 128) == 0)) {
			// ����{���ڍ׃e�[�u���̊e�s�̐ݒ�B
			// �e�s�̃R���|�[�l���g�𐶐����A������ArrayList�Ɋi�[����B
			// doMakeComponent();
			// �E�������F2
			// �E�������FdetailList1
			// �E��O�����FcolumnList1Name
			// �E��l�����FcolumnList1Value
			// �E��܈����FcolumnList1Comment
			setDetailList1(new VRArrayList());
			setColumnList1Name(new VRArrayList());
			setColumnList1Value(new VRArrayList());
			setColumnList1Comment(new VRArrayList());
			setColumnList1NameSimple(new VRArrayList());
			setColumnList1ValueSimple(new VRArrayList());
			setColumnList1CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO2, getDetailList1(), getColumnList1Name(), getColumnList1Value(), getColumnList1Comment(), getColumnList1NameSimple(), getColumnList1ValueSimple(), getColumnList1CommentSimple());

			// �����ږ���̐ݒ�
			// columnList1Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����basicInfoRevisionTablecolumn1�ɐݒ肷��B
			getBasicInfoRevisionTablecolumn1().setCustomCells(getColumnList1NameSimple());

			// ���ݒ�l��̐ݒ�
			// columnList1Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����basicInfoRevisionTablecolumn2�ɐݒ肷��B
			getBasicInfoRevisionTablecolumn2().setCustomCells(getColumnList1ValueSimple());
			// ���R�����g��̐ݒ�
			// columnList1Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����basicInfoRevisionTablecolumn3�ɐݒ肷��B
			getBasicInfoRevisionTablecolumn3().setCustomCells(getColumnList1CommentSimple());

		}

		// ��������01000000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 64) == 0)) {
			// �����׏��ڍ׃e�[�u���̊e�s�̐ݒ�B
			// �e�s�̃R���|�[�l���g�𐶐����A������ArrayList�Ɋi�[����B
			// doMakeComponent();
			// �E�������F3
			// �E�������FdetailList2
			// �E��O�����FcolumnList2Name
			// �E��l�����FcolumnList2Value
			// �E��܈����FcolumnList2Comment
			setDetailList2(new VRArrayList());
			setColumnList2Name(new VRArrayList());
			setColumnList2Value(new VRArrayList());
			setColumnList2Comment(new VRArrayList());
			setColumnList2NameSimple(new VRArrayList());
			setColumnList2ValueSimple(new VRArrayList());
			setColumnList2CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO3, getDetailList2(), getColumnList2Name(), getColumnList2Value(), getColumnList2Comment(), getColumnList2NameSimple(), getColumnList2ValueSimple(), getColumnList2CommentSimple());

			// �����ږ���̐ݒ�
			// columnList2Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����detailsInfoRevisionTablecolumn1�ɐݒ肷��B
			getDetailsInfoRevisionTablecolumn1().setCustomCells(getColumnList2NameSimple());

			// ���ݒ�l��̐ݒ�
			// columnList2Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����detailsInfoRevisionTablecolumn2�ɐݒ肷��B
			getDetailsInfoRevisionTablecolumn2().setCustomCells(getColumnList2ValueSimple());

			// ���R�����g��̐ݒ�
			// columnList2Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����detailsInfoRevisionTablecolumn3�ɐݒ肷��B
			getDetailsInfoRevisionTablecolumn3().setCustomCells(getColumnList2CommentSimple());
		}

		// ��������00100000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 32) == 0)) {
			// �����莡�Ô�E����f�Ô���ڍ׃e�[�u���̊e�s�̐ݒ�B
			// �e�s�̃R���|�[�l���g�𐶐����A������ArrayList�Ɋi�[����B
			// doMakeComponent();
			// �E�������F4
			// �E�������FdetailList3
			// �E��O�����FcolumnList3Name
			// �E��l�����FcolumnList3Value
			// �E��܈����FcolumnList3Comment
			setDetailList3(new VRArrayList());
			setColumnList3Name(new VRArrayList());
			setColumnList3Value(new VRArrayList());
			setColumnList3Comment(new VRArrayList());
			setColumnList3NameSimple(new VRArrayList());
			setColumnList3ValueSimple(new VRArrayList());
			setColumnList3CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO4, getDetailList3(), getColumnList3Name(), getColumnList3Value(), getColumnList3Comment(), getColumnList3NameSimple(), getColumnList3ValueSimple(), getColumnList3CommentSimple());

			// �����ږ���̐ݒ�
			// columnList3Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����particularInfoRevisionTablecolumn1�ɐݒ肷��B
			getParticularInfoRevisionTablecolumn1().setCustomCells(getColumnList3NameSimple());

			// ���ݒ�l��̐ݒ�
			// columnList3Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����particularInfoRevisionTablecolumn2�ɐݒ肷��B
			getParticularInfoRevisionTablecolumn2().setCustomCells(getColumnList3ValueSimple());

			// ���R�����g��̐ݒ�
			// columnList3Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����particularInfoRevisionTablecolumn3�ɐݒ肷��B
			getParticularInfoRevisionTablecolumn3().setCustomCells(getColumnList3CommentSimple());
		}

		// ��������00010000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 16) == 0)) {
			// �����莡�Ô�E����f�Ô���ڍ׃e�[�u���̊e�s�̐ݒ�B
			// �e�s�̃R���|�[�l���g�𐶐����A������ArrayList�Ɋi�[����B
			// doMakeComponent();
			// �E�������F5
			// �E�������FdetailList3
			// �E��O�����FcolumnList3Name
			// �E��l�����FcolumnList3Value
			// �E��܈����FcolumnList3Comment
			setDetailList3(new VRArrayList());
			setColumnList3Name(new VRArrayList());
			setColumnList3Value(new VRArrayList());
			setColumnList3Comment(new VRArrayList());
			setColumnList3NameSimple(new VRArrayList());
			setColumnList3ValueSimple(new VRArrayList());
			setColumnList3CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO5, getDetailList3(), getColumnList3Name(), getColumnList3Value(), getColumnList3Comment(), getColumnList3NameSimple(), getColumnList3ValueSimple(), getColumnList3CommentSimple());

			// �����ږ���̐ݒ�
			// columnList3Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����particularInfoRevisionTablecolumn1�ɐݒ肷��B
			getParticularInfoRevisionTablecolumn1().setCustomCells(getColumnList3NameSimple());

			// ���ݒ�l��̐ݒ�
			// columnList3Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����particularInfoRevisionTablecolumn2�ɐݒ肷��B
			getParticularInfoRevisionTablecolumn2().setCustomCells(getColumnList3ValueSimple());

			// ���R�����g��̐ݒ�
			// columnList3Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����particularInfoRevisionTablecolumn3�ɐݒ肷��B
			getParticularInfoRevisionTablecolumn3().setCustomCells(getColumnList3CommentSimple());
		}

		// ��������00001000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 8) == 0)) {
			// ���W�v���ڍ׃e�[�u���̊e�s�̐ݒ�B
			// �e�s�̃R���|�[�l���g�𐶐����A������ArrayList�Ɋi�[����B
			// doMakeComponent();
			// �E�������F7
			// �E�������FdetailList4
			// �E��O�����FcolumnList4Name
			// �E��l�����FcolumnList4Value
			// �E��܈����FcolumnList4Comment
			setDetailList4(new VRArrayList());
			setColumnList4Name(new VRArrayList());
			setColumnList4Value(new VRArrayList());
			setColumnList4Comment(new VRArrayList());
			setColumnList4NameSimple(new VRArrayList());
			setColumnList4ValueSimple(new VRArrayList());
			setColumnList4CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO7, getDetailList4(), getColumnList4Name(), getColumnList4Value(), getColumnList4Comment(), getColumnList4NameSimple(), getColumnList4ValueSimple(), getColumnList4CommentSimple());

			// �����ږ���̐ݒ�
			// columnList4Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����totalInfoRevisionTablecolumn1�ɐݒ肷��B
			getTotalInfoRevisionTablecolumn1().setCustomCells(getColumnList4NameSimple());

			// ���ݒ�l��̐ݒ�
			// columnList4Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����totalInfoRevisionTablecolumn2�ɐݒ肷��B
			getTotalInfoRevisionTablecolumn2().setCustomCells(getColumnList4ValueSimple());

			// ���R�����g��̐ݒ�
			// columnList4Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����totalInfoRevisionTablecolumn3�ɐݒ肷��B
			getTotalInfoRevisionTablecolumn3().setCustomCells(getColumnList4CommentSimple());
		}

		// ��������00000100�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 4) == 0)) {
			// ����������҉�����ڍ׃e�[�u���̊e�s�̐ݒ�B
			// �e�s�̃R���|�[�l���g�𐶐����A������ArrayList�Ɋi�[����B
			// doMakeComponent();
			// �E�������F8
			// �E�������FdetailList5
			// �E��O�����FcolumnList5Name
			// �E��l�����FcolumnList5Value
			// �E��܈����FcolumnList5Comment
			setDetailList5(new VRArrayList());
			setColumnList5Name(new VRArrayList());
			setColumnList5Value(new VRArrayList());
			setColumnList5Comment(new VRArrayList());
			setColumnList5NameSimple(new VRArrayList());
			setColumnList5ValueSimple(new VRArrayList());
			setColumnList5CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO8, getDetailList5(), getColumnList5Name(), getColumnList5Value(), getColumnList5Comment(), getColumnList5NameSimple(), getColumnList5ValueSimple(), getColumnList5CommentSimple());

			// �����ږ���̐ݒ�
			// columnList5Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����nyushoInfoRevisionTablecolumn1�ɐݒ肷��B
			getNyushoInfoRevisionTablecolumn1().setCustomCells(getColumnList5NameSimple());

			// ���ݒ�l��̐ݒ�
			// columnList5Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����nyushoInfoRevisionTablecolumn2�ɐݒ肷��B
			getNyushoInfoRevisionTablecolumn2().setCustomCells(getColumnList5ValueSimple());

			// ���R�����g��̐ݒ�
			// columnList5Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����nyushoInfoRevisionTablecolumn3�ɐݒ肷��B
			getNyushoInfoRevisionTablecolumn3().setCustomCells(getColumnList5CommentSimple());
		}

		// ��������00000010�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 2) == 0)) {
			// ���Љ���@�l�y���z���ڍ׃e�[�u���̊e�s�̐ݒ�B
			// �e�s�̃R���|�[�l���g�𐶐����A������ArrayList�Ɋi�[����B
			// doMakeComponent();
			// �E�������F9
			// �E�������FdetailList6
			// �E��O�����FcolumnList6Name
			// �E��l�����FcolumnList6Value
			// �E��܈����FcolumnList6Comment
			setDetailList6(new VRArrayList());
			setColumnList6Name(new VRArrayList());
			setColumnList6Value(new VRArrayList());
			setColumnList6Comment(new VRArrayList());
			setColumnList6NameSimple(new VRArrayList());
			setColumnList6ValueSimple(new VRArrayList());
			setColumnList6CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO9, getDetailList6(), getColumnList6Name(), getColumnList6Value(), getColumnList6Comment(), getColumnList6NameSimple(), getColumnList6ValueSimple(), getColumnList6CommentSimple());

			// �����ږ���̐ݒ�
			// columnList6Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����shahukuInfoRevisionTablecolumn1�ɐݒ肷��B
			getShahukuInfoRevisionTablecolumn1().setCustomCells(getColumnList6NameSimple());

			// ���ݒ�l��̐ݒ�
			// columnList6Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����shahukuInfoRevisionTablecolumn2�ɐݒ肷��B
			getShahukuInfoRevisionTablecolumn2().setCustomCells(getColumnList6ValueSimple());

			// ���R�����g��̐ݒ�
			// columnList6Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����shahukuInfoRevisionTablecolumn3�ɐݒ肷��B
			getShahukuInfoRevisionTablecolumn3().setCustomCells(getColumnList6CommentSimple());
		}

		// ��������00000001�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 1) == 0)) {
			// �����׏��ڍ׃e�[�u���̊e�s�̐ݒ�B
			// �e�s�̃R���|�[�l���g�𐶐����A������ArrayList�Ɋi�[����B
			// doMakeComponent();
			// �E�������F10
			// �E�������FdetailList2
			// �E��O�����FcolumnList2Name
			// �E��l�����FcolumnList2Value
			// �E��܈����FcolumnList2Comment
			setDetailList2(new VRArrayList());
			setColumnList2Name(new VRArrayList());
			setColumnList2Value(new VRArrayList());
			setColumnList2Comment(new VRArrayList());
			setColumnList2NameSimple(new VRArrayList());
			setColumnList2ValueSimple(new VRArrayList());
			setColumnList2CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO10, getDetailList2(), getColumnList2Name(), getColumnList2Value(), getColumnList2Comment(), getColumnList2NameSimple(), getColumnList2ValueSimple(), getColumnList2CommentSimple());

			// �����ږ���̐ݒ�
			// columnList2Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����detailsInfoRevisionTablecolumn1�ɐݒ肷��B
			getDetailsInfoRevisionTablecolumn1().setCustomCells(getColumnList2NameSimple());

			// ���ݒ�l��̐ݒ�
			// columnList2Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����detailsInfoRevisionTablecolumn2�ɐݒ肷��B
			getDetailsInfoRevisionTablecolumn2().setCustomCells(getColumnList2ValueSimple());

			// ���R�����g��̐ݒ�
			// columnList2Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����detailsInfoRevisionTablecolumn3�ɐݒ肷��B
			getDetailsInfoRevisionTablecolumn3().setCustomCells(getColumnList2CommentSimple());
		}
		
		
		//[H20.5 �@�����Ή�] fujihara add start
		// ��������100000000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 256) == 0)) {
			// �����莡�Ô�E����f�Ô���ڍ׃e�[�u���̊e�s�̐ݒ�B
			// �e�s�̃R���|�[�l���g�𐶐����A������ArrayList�Ɋi�[����B
			// doMakeComponent();
			// �E�������F5
			// �E�������FdetailList7
			// �E��O�����FcolumnList7Name
			// �E��l�����FcolumnList7Value
			// �E��܈����FcolumnList7Comment
			setDetailList7(new VRArrayList());
			setColumnList7Name(new VRArrayList());
			setColumnList7Value(new VRArrayList());
			setColumnList7Comment(new VRArrayList());
			setColumnList7NameSimple(new VRArrayList());
			setColumnList7ValueSimple(new VRArrayList());
			setColumnList7CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO5, getDetailList7(), getColumnList7Name(), getColumnList7Value(), getColumnList7Comment(), getColumnList7NameSimple(), getColumnList7ValueSimple(), getColumnList7CommentSimple());

			// �����ږ���̐ݒ�
			// columnList7Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����recuperationInfoRevisionTablecolumn1�ɐݒ肷��B
			getRecuperationInfoRevisionTablecolumn1().setCustomCells(getColumnList7NameSimple());

			// ���ݒ�l��̐ݒ�
			// columnList7Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����particularInfoRevisionTablecolumn2�ɐݒ肷��B
			getRecuperationInfoRevisionTablecolumn2().setCustomCells(getColumnList7ValueSimple());

			// ���R�����g��̐ݒ�
			// columnList3Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����particularInfoRevisionTablecolumn3�ɐݒ肷��B
			getRecuperationInfoRevisionTablecolumn3().setCustomCells(getColumnList7CommentSimple());
		}
		//[H20.5 �@�����Ή�] fujihara add end
		
		
	      // ��������1000000000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
        if (!((firstArg & 512) == 0)) {
            // ���ً}���{�ݗ×{�E���{�ݗ×{����ڍ׃e�[�u���̊e�s�̐ݒ�B
            // �e�s�̃R���|�[�l���g�𐶐����A������ArrayList�Ɋi�[����B
            // doMakeComponent();
            // �E�������F17
            // �E�������FdetailList3
            // �E��O�����FcolumnList3Name
            // �E��l�����FcolumnList3Value
            // �E��܈����FcolumnList3Comment
            setDetailList3(new VRArrayList());
            setColumnList3Name(new VRArrayList());
            setColumnList3Value(new VRArrayList());
            setColumnList3Comment(new VRArrayList());
            setColumnList3NameSimple(new VRArrayList());
            setColumnList3ValueSimple(new VRArrayList());
            setColumnList3CommentSimple(new VRArrayList());

            doMakeComponent(CATEGORY_NO17, getDetailList3(), getColumnList3Name(), getColumnList3Value(), getColumnList3Comment(), getColumnList3NameSimple(), getColumnList3ValueSimple(), getColumnList3CommentSimple());

            // �����ږ���̐ݒ�
            // columnList3Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
            // �擾�������R�[�h�W����particularInfoRevisionTablecolumn1�ɐݒ肷��B
            getParticularInfoRevisionTablecolumn1().setCustomCells(getColumnList3NameSimple());

            // ���ݒ�l��̐ݒ�
            // columnList3Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
            // �擾�������R�[�h�W����particularInfoRevisionTablecolumn2�ɐݒ肷��B
            getParticularInfoRevisionTablecolumn2().setCustomCells(getColumnList3ValueSimple());

            // ���R�����g��̐ݒ�
            // columnList3Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
            // �擾�������R�[�h�W����particularInfoRevisionTablecolumn3�ɐݒ肷��B
            getParticularInfoRevisionTablecolumn3().setCustomCells(getColumnList3CommentSimple());
        }
		
 // 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
     	// ��������10000000000�i2�i���\�L�j�̘_���ς̒l��0�łȂ��ꍇ
		if (!((firstArg & 1024) == 0)) {
			// �����׏��ڍ׃e�[�u���̊e�s�̐ݒ�B
			// �e�s�̃R���|�[�l���g�𐶐����A������ArrayList�Ɋi�[����B
			// doMakeComponent();
			// �E�������F3
			// �E�������FdetailList8
			// �E��O�����FcolumnList8Name
			// �E��l�����FcolumnList8Value
			// �E��܈����FcolumnList8Comment
			setDetailList8(new VRArrayList());
			setColumnList8Name(new VRArrayList());
			setColumnList8Value(new VRArrayList());
			setColumnList8Comment(new VRArrayList());
			setColumnList8NameSimple(new VRArrayList());
			setColumnList8ValueSimple(new VRArrayList());
			setColumnList8CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO18, getDetailList8(), getColumnList8Name(), getColumnList8Value(), getColumnList8Comment(), getColumnList8NameSimple(), getColumnList8ValueSimple(), getColumnList8CommentSimple());

			// �����ږ���̐ݒ�
			// columnList2Name���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����detailsJushotiTokureiInfoRevisionTablecolumn1�ɐݒ肷��B
			getDetailsJushotiTokureiInfoRevisionTablecolumn1().setCustomCells(getColumnList8NameSimple());

			// ���ݒ�l��̐ݒ�
			// columnList2Value���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����detailsJushotiTokureiInfoRevisionTablecolumn2�ɐݒ肷��B
			getDetailsJushotiTokureiInfoRevisionTablecolumn2().setCustomCells(getColumnList8ValueSimple());

			// ���R�����g��̐ݒ�
			// columnList2Comment���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B
			// �擾�������R�[�h�W����detailsJushotiTokureiInfoRevisionTablecolumn3�ɐݒ肷��B
			getDetailsJushotiTokureiInfoRevisionTablecolumn3().setCustomCells(getColumnList8CommentSimple());
		}
// 2014/12/24 [Yoichiro Kamei] add - end
		
	}

	/**
	 * �u�e�s�̃R���|�[�l���g�𐶐��v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doMakeComponent(int categoryNo, VRList detailList, VRList columnListName, VRList columnListValue, VRList columnListComment, VRList columnListNameSimple, VRList columnListValueSimple, VRList columnListCommentSimple) throws Exception {
		// �ڍ׃e�[�u���̊e�s�̃R���|�[�l���g�𐶐����Ēǉ����鏈���B
		// �ȉ��A���������L�̖��O�ŌĂԁB
		// �E�������FcategoryNo
		// �E��j�����FdetailList
		// �E��O�����FcolumnListName
		// �E��l�����FcolumnListValue
		// �E��܈����FcolumnListComment
		// �E��Z�����FcolumnListNameSimple
		// �E�掵�����FcolumnListValueSimple
		// �E�攪�����FcolumnListCommentSimple

		// detailCommentList�����Ɍ��Ă����B�i���[�v�J�n�j
		Iterator detaiDataListIterator = getDetailCommentList().iterator();
		while (detaiDataListIterator.hasNext()) {
			VRMap detailDataMap = (VRMap) detaiDataListIterator.next();
			detailDataMap = new DetailValueAdapter(detailDataMap);

			if (new Integer(categoryNo).equals(detailDataMap.getData("CATEGORY_NO"))) {
				// ���R�[�h��CATEGORY_NO�̒l��categoryNo�Ɠ������ꍇ
				// ACTableCellViewerCustomCell�𐶐�����B�i�ȉ��AcellName�Ƃ���j
				// ACTableCellViewerCustomCell�𐶐�����B�i�ȉ��AcellValue�Ƃ���j
				// ACTableCellViewerCustomCell�𐶐�����B�i�ȉ��AcellComment�Ƃ���j
				ACTableCellViewerCustomCell cellName = new ACTableCellViewerCustomCell();
				ACTableCellViewerCustomCell cellValue = new ACTableCellViewerCustomCell();
				ACTableCellViewerCustomCell cellComment = new ACTableCellViewerCustomCell();

				if (new Integer(OFF).equals(detailDataMap.getData("EDITABLE_FLAG"))) {
					// ���R�[�h��EDITABLE_FLAG��0�i�ҏW�s�j�̏ꍇ
					// ���x���𐶐�����B
					// ���x���̔w�i�F���D�F�ɐݒ肷��B
					ACLabel grayLabel = new ACLabel();
					grayLabel.setBackground(Color.lightGray);

					// cellName��renderer�ɐ����������x����ݒ肷��B
					cellName.setRenderer(grayLabel);

					// cellValue��renderer�ɐ����������x����ݒ肷��B
					cellValue.setRenderer(grayLabel);

					// cellComment��renderer�ɐ����������x����ݒ肷��B
					cellComment.setRenderer(grayLabel);

					// cellName��IgnoreSelectColor��true��ݒ肷��B
					cellName.setIgnoreSelectColor(true);

					// cellValue��IgnoreSelectColor��true��ݒ肷��B
					cellValue.setIgnoreSelectColor(true);

					// cellComment��IgnoreSelectColor��true��ݒ肷��B
					cellComment.setIgnoreSelectColor(true);

				} else if (new Integer(ON).equals(detailDataMap.getData("EDITABLE_FLAG"))) {

					// ���R�[�h��EDITABLE_FLAG��1�i�ҏW�j�̏ꍇ
					// cellValue��editable��true��ݒ肷��B
					cellValue.setEditable(true);

					// �e�L�X�g�𐶐�����B
					ACTextField valueTextField = new ACTextField();
					ACLabel valueLabel = new ACLabel();

					// �ő包�������R�[�h��MAX_LENGTH�̒l�ɐݒ肷��B
					valueTextField.setMaxLength(ACCastUtilities.toInt(detailDataMap.getData("MAX_LENGTH")));
					valueTextField.setByteMaxLength(true);
					
					switch (ACCastUtilities.toInt(detailDataMap.getData("CHAR_TYPE"))) {
						// ���R�[�h��CHAR_TYPE�̒l��1�̏ꍇ
						// ���p�����̂ݓ��͉\�ɐݒ肷��B
						case 1:
							valueTextField.setCharType(VRCharType.ONLY_DIGIT);
							break;

						// ���R�[�h��CHAR_TYPE�̒l��2�̏ꍇ
						// ���p�����̂݁i���l�܂ށj���͉\�ɐݒ肷��B
						case 2:
							valueTextField.setCharType(VRCharType.ONLY_NUMBER);
							break;
						// ���R�[�h��CHAR_TYPE�̒l��3�̏ꍇ
						// ���p�p�����̂ݓ��͉\�ɐݒ肷��B

						case 3:
							valueTextField.setCharType(VRCharType.ONLY_ALNUM);
							break;

						// ���R�[�h��CHAR_TYPE��4�̏ꍇ
						// ���������͉\�ɐݒ肷��B
						case 4:
							valueTextField.setCharType(VRCharType.ONLY_FLOAT);
							break;

						// ���R�[�h��CHAR_TYPE��5�̏ꍇ
						// IME���[�h��KANJI�ɐݒ肷��B
						case 5:
							valueTextField.setIMEMode(InputSubset.KANJI);
							break;

						default:
							break;
					}

					int commentAlignment = ACCastUtilities.toInt(detailDataMap.getData("ALIGNMENT"));
					switch (commentAlignment) {
						// ���R�[�h��ALIGNMENT�̒l��1�̏ꍇ
						// �A���C�����g�����񂹂ɐݒ肷��B
						case 1:

							valueTextField.setHorizontalAlignment(SwingConstants.LEFT);
							valueLabel.setHorizontalAlignment(SwingConstants.LEFT);
							break;
						// ���R�[�h��ALIGNMENT�̒l��2�̏ꍇ
						// �A���C�����g���E�񂹂ɐݒ肷��B
						case 2:
							valueTextField.setHorizontalAlignment(SwingConstants.RIGHT);
							valueLabel.setHorizontalAlignment(SwingConstants.RIGHT);
							break;
						default:
							break;
					}

					// V4.5.8�Ή�
					int commentId = ACCastUtilities.toInt(detailDataMap.getData("COMMENT_ID"));
					switch(categoryNo){
					case 4:
						switch(commentId){
						case 6://�ً}�����a���P
						case 7://�ً}�����a���Q
						case 8://�ً}�����a���R
						case 13://���f��Ë@��
						case 15://�ʉ@��Ë@��
						case 24://�E�v���i�ً}���j
						case 25://�E�v���i�ً}���j
						case 26://�E�v���i�ً}���j
						case 27://�E�v���i�ً}���j
						case 28://�E�v���i�ً}���j
						case 29://�E�v���i�ً}���j
						case 30://�E�v���i�ً}���j
						case 31://�E�v���i�ً}���j
						case 32://�E�v���i�ً}���j
						case 33://�E�v���i�ً}���j
						case 34://�E�v���i�ً}���j
						case 35://�E�v���i�ً}���j
						case 36://�E�v���i�ً}���j
						case 37://�E�v���i�ً}���j
						case 38://�E�v���i�ً}���j
						case 39://�E�v���i�ً}���j
						case 40://�E�v���i�ً}���j
						case 41://�E�v���i�ً}���j
						case 42://�E�v���i�ً}���j
						case 43://�E�v���i�ً}���j
							valueTextField.setConvertToCharacter(ACCharacterConverter.TO_WIDE_CHAR);
							valueTextField.setIMEMode(InputSubset.KANJI);
							break;
						}
						break;
					case 5:
						switch(commentId){
						case 6://���a���i����f�Ô�j
						case 21://�E�v���i����f�Ô�j
							valueTextField.setConvertToCharacter(ACCharacterConverter.TO_WIDE_CHAR);
							valueTextField.setIMEMode(InputSubset.KANJI);
							break;
						}
						break;
					case 9:
						switch(commentId){
						case 10://���l�i�Е��j
							valueTextField.setCharType(VRCharType.ONLY_HALF_CHAR);
							valueTextField.setConvertToCharacter(ACCharacterConverter.TO_HALF_CHAR|ACCharacterConverter.TO_HALF_KATAKANA);
							valueTextField.setIMEMode(InputSubset.KANJI);
							break;
						}
						break;
					}
					
					// cellValue��editor�ɐ��������e�L�X�g��ݒ肷��B
					cellValue.setEditor(valueTextField);
					cellValue.setRenderer(valueLabel);
				}
				
				// detailList�Ƀ��R�[�h��ǉ�����B
				detailList.add(detailDataMap);

				if (new Integer(ON).equals(detailDataMap.getData("SHOW_FLAG"))) {
					// cellName��columnListNameSimple�ɒǉ�����B
					columnListNameSimple.add(cellName);
					// cellValue��columnListValueSimple�ɒǉ�����B
					columnListValueSimple.add(cellValue);
					// cellComment��columnListCommentSimple�ɒǉ�����B
					columnListCommentSimple.add(cellComment);
				}
				// cellName��columnListName�ɒǉ�����B
				columnListName.add(cellName);
				// cellValue��columnListValue�ɒǉ�����B
				columnListValue.add(cellValue);
				// cellComment��columnListComment�ɒǉ�����B
				columnListComment.add(cellComment);
			}
		}
	}

	/**
	 * �u�����f�[�^����ʃe�[�u���ɐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doSetClaimData() throws Exception {

		if (!getTableClaimList1().isEmpty()) {
			// tableClaimList1��null�łȂ��ꍇ
			// �\�[�g����B
			// 201017 �F��L�����ԊJ�n�N����
			String[] keys = new String[]{"201017"};
			setTableClaimList1(getSortedData(getTableClaimList1(), keys));
			// tableClaimList1��tableModelList1�ɐݒ肷��
			getTableModelList1().setAdaptee(getTableClaimList1());
			// �o�C���h���BasicInfoTable��1�s�ڂ�I��������Ԃɂ���B
			getBasicInfoTable().setSelectedSortedFirstRow();
		}

		if (!getTableClaimList2().isEmpty()) {
			// tableClaimList2��null�łȂ��ꍇ
			// �\�[�g����B
			switch(getClaimStyleType()){
			case FORMAT_STYLE7:
			case FORMAT_STYLE72:
				break;
			default:
				// 301007 �T�[�r�X��ރR�[�h + 301008 �T�[�r�X���ڃR�[�h
				String[] keys = new String[]{"301007", "301008", "301009", "301014"};
				int[] digits = new int[]{0, 0, 4, 6};
				setTableClaimList2(getSortedData(getTableClaimList2(), keys, digits));
				break;
			}
			// tableClaimList2��tableModelList2�ɐݒ肷��B
			getTableModelList2().setAdaptee(getTableClaimList2());
			// �o�C���h���DetailsInfoTable��1�s�ڂ�I��������Ԃɂ���B
			getDetailsInfoTable().setSelectedSortedFirstRow();
			getKyotakuDetailsInfoTable().setSelectedSortedFirstRow();
		}

		if (!getTableClaimList3().isEmpty()) {
			// tableClaimList3��null�łȂ��ꍇ
			// �\�[�g����B
			switch(getClaimStyleType()){
			case FORMAT_STYLE4:
			case FORMAT_STYLE42:
			case FORMAT_STYLE9:
				break;
			case FORMAT_STYLE5:
			case FORMAT_STYLE52:
			case FORMAT_STYLE10:
				// 501007 ����f�Ô��񃌃R�[�h�����ԍ�2��
				String[] keys = new String[]{"501007"};
				int[] digits = new int[]{2};
				setTableClaimList3(getSortedData(getTableClaimList3(), keys, digits));
				break;
			}
			// tableClaimList3��tableModelList3�ɐݒ肷��B
			getTableModelList3().setAdaptee(getTableClaimList3());
			// �o�C���h���ParticularInfoTable��1�s�ڂ�I��������Ԃɂ���B
			getParticularInfoTable().setSelectedSortedFirstRow();
			getSpecialClinicInfoTable().setSelectedSortedFirstRow();
		}

		if (!getTableClaimList4().isEmpty()) {
			// tableClaimList4��null�łȂ��ꍇ 
			// �\�[�g����B
			// 701007 �T�[�r�X��ރR�[�h
			String[] keys = new String[]{"701007"};
			setTableClaimList4(getSortedData(getTableClaimList4(), keys));
			// tableClaimList4��tableModelList4�ɐݒ肷��B
			getTableModelList4().setAdaptee(getTableClaimList4());
			// �o�C���h���TotalInfoTable��1�s�ڂ�I��������Ԃɂ���B
			getTotalInfoTable().setSelectedSortedFirstRow();
		}

		if (!getTableClaimList5().isEmpty()) {
			// tableClaimList5��null�łȂ��ꍇ
			// �\�[�g����B
			// 801007 ��������҉��T�[�r�X��p��񃌃R�[�h�����ԍ�2��
			String[] keys = new String[]{"801007"};
			int[] digits = new int[]{2};
			setTableClaimList5(getSortedData(getTableClaimList5(), keys, digits));
			// tableClaimList5��tableModelList5�ɐݒ肷��B
			getTableModelList5().setAdaptee(getTableClaimList5());
			// �o�C���h���NyushoInfoTable��1�s�ڂ�I��������Ԃɂ���B
			getNyushoInfoTable().setSelectedSortedFirstRow();
		}

		if (!getTableClaimList6().isEmpty()) {
			// tableClaimList6��null�łȂ��ꍇ
			// �\�[�g����B
			// 901008 �T�[�r�X��ރR�[�h2��
			String[] keys = new String[]{"901008"};
			setTableClaimList6(getSortedData(getTableClaimList6(), keys));
			// tableClaimList6��tableModelList6�ɐݒ肷��B
			getTableModelList6().setAdaptee(getTableClaimList6());
			// �o�C���h���ShahukuInfoTable��1�s�ڂ�I��������Ԃɂ���B
			getShahukuInfoTable().setSelectedSortedFirstRow();
		}
		
		//[H20.5 �@�����Ή�] fujihara add start
		if (!getTableClaimList7().isEmpty()) {
			// tableClaimList7��null�łȂ��ꍇ
			// �\�[�g����B
			// 501007 ����×{���񃌃R�[�h�����ԍ�2��
			String[] keys = new String[]{"501007"};
			int[] digits = new int[]{2};
			setTableClaimList7(getSortedData(getTableClaimList7(), keys, digits));
			
			// tableClaimList7��tableModelList7�ɐݒ肷��B
			getTableModelList7().setAdaptee(getTableClaimList7());
			// �o�C���h���ParticularInfoTable��1�s�ڂ�I��������Ԃɂ���B
			getParticularInfoTable().setSelectedSortedFirstRow();
			//[ID:0000429][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
			//������Q�@�擪�s��\������
			getRecuperationInfoTable().setSelectedSortedFirstRow();
			//[ID:0000429][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
			getRecuperationInfoRevisionTable().setSelectedSortedFirstRow();
		}
		//[H20.5 �@�����Ή�] fujihara add end

// 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
		if (!getTableClaimList8().isEmpty()) {
			// tableClaimList8��null�łȂ��ꍇ
			// �\�[�g����B
			switch(getClaimStyleType()){
			case FORMAT_STYLE7:
			case FORMAT_STYLE72:
				break;
			default:
				// 301007 �T�[�r�X��ރR�[�h + 301008 �T�[�r�X���ڃR�[�h
				String[] keys = new String[]{"1801007", "1801008", "1801009", "1801014"};
				int[] digits = new int[]{0, 0, 4, 6};
				setTableClaimList8(getSortedData(getTableClaimList8(), keys, digits));
				break;
			}
			// tableClaimList8��tableModelList8�ɐݒ肷��B
			getTableModelList8().setAdaptee(getTableClaimList8());
			// �o�C���h���DetailsJushotiTokureiInfoTable��1�s�ڂ�I��������Ԃɂ���B
			getDetailsJushotiTokureiInfoTable().setSelectedSortedFirstRow();
		}
// 2014/12/24 [Yoichiro Kamei] add - end
	}

	/**
	 * �u�����f�[�^�̃\�[�g�v�Ɋւ��鏈�����s���܂��B
	 * @param list �Ώۃ��R�[�h�W��
	 * @param keys �\�[�g�L�[
	 * @return �\�[�g���ꂽ���R�[�h�W��
	 * @throws Exception
	 */
	public VRList getSortedData(VRList list, String[] keys) throws Exception {
		
		int num = keys.length;
		int[] digits = new int[num];
		
		for(int i = 0; i < num; i++){
			digits[i] = 0;
		}
		
		return getSortedData(list, keys, digits);
		
	}

	/**
	 * �u�����f�[�^�̃\�[�g�v�Ɋւ��鏈�����s���܂��B
	 * @param list �Ώۃ��R�[�h�W��
	 * @param keys �\�[�g�L�[
	 * @param digits �w�茅��
	 * @return �\�[�g���ꂽ���R�[�h�W��
	 * @throws Exception
	 */
	public VRList getSortedData(VRList list, String[] keys, int[] digits) throws Exception {
		
		// VRList result�𐶐�����B
		VRList result = new VRArrayList();
		// TreeMap map �𐶐�����B
		TreeMap map = new TreeMap();
		// �n���ꂽlist�����[�v����B�i�ȉ��A�e�v�f��record�Ƃ���B�j
		for(int i = 0; i < list.size(); i++){
			VRMap record = (VRMap)list.get(i);
			// String newKey�𐶐�����B
			String newKey = "";
			// �n���ꂽkeys�����[�v����B�i�ȉ��A�e�v�f��key�Ƃ���B�j
			for(int j = 0; j < keys.length; j++){
				// record���AKEY�Fkey�̒l�����o���AString�ɕϊ�����B
				String temp = ACCastUtilities.toString(VRBindPathParser.get(keys[j], record));
				// newKey�̖����ɒǉ�����B
				newKey += getStringOnSpecifiedDigit(temp, digits[j]);
			}
			// record��KEY�FnewKey�Ƃ��āAmap�ɒǉ�����B
			//del start 2006.6.14 fujihara.shin
			//map.put(newKey, record);
			//del end 2006.6.14 fujihara.shin
			//add start 2006.6.14 fujihara.shin
			int esc = 0;
			while(true){
				if(!map.containsKey(newKey + esc)){
					map.put(newKey + esc, record);
					break;
				}
				esc++;
			}
			//add end 2006.6.14 fujihara.shin
		}
		// map��list�ɖ߂��B
		result.addAll(map.values());
		return result;
		
	}
	
	/**
	 * �w�茅���܂�0���߂���֐�
	 * @param temp �Ώە�����
	 * @param digit �w�茅��
	 * @return 0���߂��ꂽ������
	 */
	public String getStringOnSpecifiedDigit(String temp, int digit){
		
		if(digit <= 0){
			return temp;
		}
		
		String head = "";
		int num = digit - temp.length();
		
		for(int i = 0; i < num; i++){
			head += "0";
		}
		
		return head + temp;
		
	}
	
	/**
	 * �u�ڍ׃e�[�u���\���p�f�[�^�쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doMakeDetailTableList(VRMap claimData, VRList detailList) throws Exception {
		// �ȉ��A�n���ꂽ���������L�̖��O�ŌĂԁB
		// �E�������FclaimData
		// �E�������FdetailList

		// detailList�����Ɍ��Ă����B�i���[�v�J�n�j
		Iterator detailListIterator = detailList.iterator();
		while (detailListIterator.hasNext()) {
			// detailList�̃��R�[�h��SYSTEM_BIND_PATH��KEY�Ƃ���l��claimData����擾����B
			VRMap detailMap = (VRMap) detailListIterator.next();
			// �擾�����f�[�^���ȉ���KEY��detailList�̃��R�[�h�ɒǉ�����B
			// �EKEY�FDETAIL_VALUE

			// TODO �Q�Ɠ]�L�p�̃p�X�ݒ�
			if (detailMap instanceof DetailValueAdapter) {
				((DetailValueAdapter) detailMap).setAdaptee(claimData);
				((DetailValueAdapter) detailMap).setPath(ACCastUtilities.toString(detailMap.getData("SYSTEM_BIND_PATH")));
			}

			// if(("null").equals(claimData.getData(ACCastUtilities.toString(detailMap.getData("SYSTEM_BIND_PATH"))))){
			// detailMap.setData("DETAIL_VALUE", "");
			// }

			if (ACTextUtilities.isNullText(claimData.getData(ACCastUtilities.toString(detailMap.getData("SYSTEM_BIND_PATH"))))) {
				detailMap.setData("DETAIL_VALUE", "");
			} else {
				detailMap.setData("DETAIL_VALUE", claimData.getData(ACCastUtilities.toString(detailMap.getData("SYSTEM_BIND_PATH"))));
			}
		}
	}

	private class DetailValueAdapter extends VRHashMap {
		// TODO �ڍׂƖ{�̂̑��ݎQ�Ɨp�A�_�v�^�}�b�v�N���X
		public Object put(Object key, Object value) {
			if ((adaptee != null) && (path != null)) {
				try {
					if ("DETAIL_VALUE".equals(ACCastUtilities.toString(key))) {
						adaptee.put(path, value);
					}
				} catch (Exception ex) {
				}
			}

			return super.put(key, value);
		}

		private String path;

		private Map adaptee;

		public DetailValueAdapter(Map adaptee) {
			super(adaptee);
			this.adaptee = adaptee;
		}

		public DetailValueAdapter(Map adaptee, String path) {
			this(adaptee);
			this.path = path;
		}

		/**
		 * path ��Ԃ��܂��B
		 * 
		 * @return path
		 */
		public String getPath() {
			return path;
		}

		/**
		 * path ��ݒ肵�܂��B
		 * 
		 * @param path
		 *            path
		 */
		public void setPath(String path) {
			this.path = path;
		}

		/**
		 * adaptee ��Ԃ��܂��B
		 * 
		 * @return adaptee
		 */
		public Map getAdaptee() {
			return adaptee;
		}

		/**
		 * adaptee ��ݒ肵�܂��B
		 * 
		 * @param adaptee
		 *            adaptee
		 */
		public void setAdaptee(Map adaptee) {
			this.adaptee = adaptee;
		}
	}

	/**
	 * �u�ڍ׃e�[�u���\���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doShowClaimDetail(String recordDataType) throws Exception {
		// �n���ꂽ�����̒l��"BASIC"�̏ꍇ
		if (recordDataType.equals("BASIC")) {
			// ��{���e�[�u���őI������Ă���s�̃��R�[�h�i�ȉ��A�I�����R�[�h�j���擾����B
			if (getBasicInfoRevisionCheck().isSelected()) {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�ibasicInfoRevisionCheck�j���I���ɂȂ��Ă���ꍇ
				// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
				if (!(getDetailList1().isEmpty())) {
					doMakeDetailTableList((VRMap) getBasicInfoTable().getSelectedModelRowValue(), getDetailList1());
					// �E�������F�I�����R�[�h
					// �E�������FdetailList1

					// detailList1���e�[�u�����f���itableModelDetail1�j�ɐݒ肷��B
					getTableModelDetail1().setAdaptee(getDetailList1());
				}
			} else {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�ibasicInfoRevisionCheck�j���I�t�ɂȂ��Ă���ꍇ
				// detailList1���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B�i�ȉ��AtempList�j
				if (!(getDetailList1().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList1(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
					doMakeDetailTableList((VRMap) getBasicInfoTable().getSelectedModelRowValue(), tempList);
					// �E�������F�I�����R�[�h
					// �E�������FtempList

					// tempList���e�[�u�����f���itableModelDetail1�j�ɐݒ肷��B
					getTableModelDetail1().setAdaptee(tempList);
				}
			}
		}

		// �n���ꂽ�����̒l��"DETAIL"�̏ꍇ
		if (recordDataType.equals("DETAIL")) {
			// ���׏��e�[�u���őI������Ă���s�̃��R�[�h�i�ȉ��A�I�����R�[�h�j���擾����B
			if (getDetailsInfoRevisionCheck().isSelected()) {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�idetailsInfoRevisionCheck�j���I���ɂȂ��Ă���ꍇ
				// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
				if (!(getDetailList2().isEmpty())) {
					doMakeDetailTableList((VRMap) getDetailsInfoTable().getSelectedModelRowValue(), getDetailList2());
					// �E�������F�I�����R�[�h
					// �E�������FdetailList2

					// detailList2���e�[�u�����f���itableModelDetail2�j�ɐݒ肷��B
					getTableModelDetail2().setAdaptee(getDetailList2());
				}

			} else {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�idetailsInfoRevisionCheck�j���I�t�ɂȂ��Ă���ꍇ
				// detailList2���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B�i�ȉ��AtempList�j
				if (!(getDetailList2().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList2(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
					doMakeDetailTableList((VRMap) getDetailsInfoTable().getSelectedModelRowValue(), tempList);
					// �E�������F�I�����R�[�h
					// �E�������FtempList

					// tempList���e�[�u�����f���itableModelDetail2�j�ɐݒ肷��B
					getTableModelDetail2().setAdaptee(tempList);
				}
			}
		}

		// �n���ꂽ�����̒l��"KYOTAKU"�̏ꍇ
		if (recordDataType.equals("KYOTAKU")) {
			// ������x�����׏��e�[�u���őI������Ă���s�̃��R�[�h�i�ȉ��A�I�����R�[�h�j���擾����B
			if (getDetailsInfoRevisionCheck().isSelected()) {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�idetailsInfoRevisionCheck�j���I���ɂȂ��Ă���ꍇ
				// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
				if (!(getDetailList2().isEmpty())) {
					doMakeDetailTableList((VRMap) getKyotakuDetailsInfoTable().getSelectedModelRowValue(), getDetailList2());
					// �E�������F�I�����R�[�h
					// �E�������FdetailList2

					// detailList2���e�[�u�����f���itableModelDetail2�j�ɐݒ肷��B
					getTableModelDetail2().setAdaptee(getDetailList2());
				}
				// setAdaptee();
			} else {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�idetailsInfoRevisionCheck�j���I�t�ɂȂ��Ă���ꍇ
				// detailList2���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B�i�ȉ��AtempList�j
				if (!(getDetailList2().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList2(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
					doMakeDetailTableList((VRMap) getKyotakuDetailsInfoTable().getSelectedModelRowValue(), tempList);
					// �E�������F�I�����R�[�h
					// �E�������FtempList

					// tempList���e�[�u�����f���itableModelDetail2�j�ɐݒ肷��B
					getTableModelDetail2().setAdaptee(tempList);
				}
			}
		}

		// �n���ꂽ�����̒l��"PARTICULAR"�̏ꍇ
		if (recordDataType.equals("PARTICULAR")) {
			// ���莡�Ô���e�[�u���őI������Ă���s�̃��R�[�h�i�ȉ��A�I�����R�[�h�j���擾����B
			if (getParticularInfoRevisionCheck().isSelected()) {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�iparticularInfoRevisionCheck�j���I���ɂȂ��Ă���ꍇ
				// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
				if (!(getDetailList3().isEmpty())) {
					doMakeDetailTableList((VRMap) getParticularInfoTable().getSelectedModelRowValue(), getDetailList3());
					// �E�������F�I�����R�[�h
					// �E�������FdetailList3

					// detailList3���e�[�u�����f���itableModelDetail3�j�ɐݒ肷��B
					getTableModelDetail3().setAdaptee(getDetailList3());
				}
			} else {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�iparticularInfoRevisionCheck�j���I�t�ɂȂ��Ă���ꍇ
				// detailList3���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B�i�ȉ��AtempList�j
				if (!(getDetailList3().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList3(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
					doMakeDetailTableList((VRMap) getParticularInfoTable().getSelectedModelRowValue(), tempList);
					// �E�������F�I�����R�[�h
					// �E�������FtempList

					// tempList���e�[�u�����f���itableModelDetail3�j�ɐݒ肷��B
					getTableModelDetail3().setAdaptee(tempList);
				}
			}
		}

		// �n���ꂽ�����̒l��"SPECIAL_CLINIC"�̏ꍇ
		if (recordDataType.equals("SPECIAL_CLINIC")) {
			// ����f�Ô���e�[�u���őI������Ă���s�̃��R�[�h�i�ȉ��A�I�����R�[�h�j���擾����B
			if (getParticularInfoRevisionCheck().isSelected()) {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�iparticularInfoRevisionCheck�j���I���ɂȂ��Ă���ꍇ
				// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
				if (!(getDetailList3().isEmpty())) {
					doMakeDetailTableList((VRMap) getSpecialClinicInfoTable().getSelectedModelRowValue(), getDetailList3());
					// �E�������F�I�����R�[�h
					// �E�������FdetailList3

					// detailList3���e�[�u�����f���itableModelDetail3�j�ɐݒ肷��B
					getTableModelDetail3().setAdaptee(getDetailList3());
				}

			} else {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�iparticularInfoRevisionCheck�j���I�t�ɂȂ��Ă���ꍇ
				// detailList3���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B�i�ȉ��AtempList�j
				if (!(getDetailList3().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList3(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
					doMakeDetailTableList((VRMap) getSpecialClinicInfoTable().getSelectedModelRowValue(), tempList);
					// �E�������F�I�����R�[�h
					// �E�������FtempList

					// tempList���e�[�u�����f���itableModelDetail3�j�ɐݒ肷��B
					getTableModelDetail3().setAdaptee(tempList);
				}
			}
		}

		// �n���ꂽ�����̒l��"TOTAL"�̏ꍇ
		if (recordDataType.equals("TOTAL")) {
			// �W�v���e�[�u���őI������Ă���s�̃��R�[�h�i�ȉ��A�I�����R�[�h�j���擾����B
			if (getTotalInfoRevisionCheck().isSelected()) {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�itotalInfoRevisionCheck�j���I���ɂȂ��Ă���ꍇ
				// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
				if (!(getDetailList4().isEmpty())) {
					doMakeDetailTableList((VRMap) getTotalInfoTable().getSelectedModelRowValue(), getDetailList4());
					// �E�������F�I�����R�[�h
					// �E�������FdetailList4

					// detailList4���e�[�u�����f���itableModelDetail4�j�ɐݒ肷��B
					getTableModelDetail4().setAdaptee(getDetailList4());
				}
			} else {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�itotalInfoRevisionCheck�j���I�t�ɂȂ��Ă���ꍇ
				// detailList4���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B�i�ȉ��AtempList�j
				if (!(getDetailList4().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList4(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
					doMakeDetailTableList((VRMap) getTotalInfoTable().getSelectedModelRowValue(), tempList);
					// �E�������F�I�����R�[�h
					// �E�������FtempList

					// tempList���e�[�u�����f���itableModelDetail4�j�ɐݒ肷��B
					getTableModelDetail4().setAdaptee(tempList);
				}
			}
		}

		// �n���ꂽ�����̒l��"NYUSHO"�̏ꍇ
		if (recordDataType.equals("NYUSHO")) {
			// ��������҉�����e�[�u���őI������Ă���s�̃��R�[�h�i�ȉ��A�I�����R�[�h�j���擾����B
			if (getNyushoInfoRevisionCheck().isSelected()) {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�inyushoInfoRevisionCheck�j���I���ɂȂ��Ă���ꍇ
				// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
				if (!(getDetailList5().isEmpty())) {
					doMakeDetailTableList((VRMap) getNyushoInfoTable().getSelectedModelRowValue(), getDetailList5());
					// �E�������F�I�����R�[�h
					// �E�������FdetailList5

					// detailList5���e�[�u�����f���itableModelDetail5�j�ɐݒ肷��B
					getTableModelDetail5().setAdaptee(getDetailList5());
				}
			} else {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�inyushoInfoRevisionCheck�j���I�t�ɂȂ��Ă���ꍇ
				// detailList5���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B�i�ȉ��AtempList�j
				if (!(getDetailList5().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList5(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
					doMakeDetailTableList((VRMap) getNyushoInfoTable().getSelectedModelRowValue(), tempList);
					// �E�������F�I�����R�[�h
					// �E�������FtempList

					// tempList���e�[�u�����f���itableModelDetail5�j�ɐݒ肷��B
					getTableModelDetail5().setAdaptee(tempList);
				}
			}
		}

		// �n���ꂽ�����̒l��"SHAHUKU"�̏ꍇ
		if (recordDataType.equals("SHAHUKU")) {
			// �Љ���@�l�y���z���e�[�u���őI������Ă���s�̃��R�[�h�i�ȉ��A�I�����R�[�h�j���擾����B
			if (getShahukuInfoRevisionCheck().isSelected()) {
				if (!(getDetailList6().isEmpty())) {
					// �S�Ă̏���\���`�F�b�N�{�b�N�X�ishahukuInfoRevisionCheck�j���I���ɂȂ��Ă���ꍇ
					// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
					doMakeDetailTableList((VRMap) getShahukuInfoTable().getSelectedModelRowValue(), getDetailList6());
					// �E�������F�I�����R�[�h
					// �E�������FdetailList6

					// detailList6���e�[�u�����f���itableModelDetail6�j�ɐݒ肷��B
					getTableModelDetail6().setAdaptee(getDetailList6());
				}
			} else {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�ishahukuInfoRevisionCheck�j���I�t�ɂȂ��Ă���ꍇ
				// detailList6���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B�i�ȉ��AtempList�j
				if (!(getDetailList6().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList6(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
					doMakeDetailTableList((VRMap) getShahukuInfoTable().getSelectedModelRowValue(), tempList);
					// �E�������F�I�����R�[�h
					// �E�������FtempList

					// tempList���e�[�u�����f���itableModelDetail6�j�ɐݒ肷��B
					getTableModelDetail6().setAdaptee(tempList);
				}
			}
		}
		
		//[H20.5 �@�����Ή�] fujihara add start
		// �n���ꂽ�����̒l��"RYOYO"�̏ꍇ
		if (recordDataType.equals("RYOYO")) {
			// ����×{����e�[�u���őI������Ă���s�̃��R�[�h�i�ȉ��A�I�����R�[�h�j���擾����B
			if (getRecuperationInfoRevisionCheck().isSelected()) {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�irecuperationInfoRevisionCheck�j���I���ɂȂ��Ă���ꍇ
				// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
				if (!(getDetailList7().isEmpty())) {
					doMakeDetailTableList((VRMap) getRecuperationInfoTable().getSelectedModelRowValue(), getDetailList7());
					// �E�������F�I�����R�[�h
					// �E�������FdetailList7

					// detailList7���e�[�u�����f���itableModelDetail7�j�ɐݒ肷��B
					getTableModelDetail7().setAdaptee(getDetailList7());
				}
			} else {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�irecuperationInfoRevisionCheck�j���I�t�ɂȂ��Ă���ꍇ
				// detailList1���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B�i�ȉ��AtempList�j
				if (!(getDetailList7().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList7(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
					doMakeDetailTableList((VRMap) getRecuperationInfoTable().getSelectedModelRowValue(), tempList);
					// �E�������F�I�����R�[�h
					// �E�������FtempList

					// tempList���e�[�u�����f���itableModelDetail7�j�ɐݒ肷��B
					getTableModelDetail7().setAdaptee(tempList);
				}
			}
		}
		//[H20.5 �@�����Ή�] fujihara add end

// 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
		// �n���ꂽ�����̒l��"DETAIL_JUSHOTI_TOKUREI"�̏ꍇ
		if (recordDataType.equals("DETAIL_JUSHOTI_TOKUREI")) {
			// ���׏��e�[�u���őI������Ă���s�̃��R�[�h�i�ȉ��A�I�����R�[�h�j���擾����B
			
			if (getDetailsJushotiTokureiInfoRevisionCheck().isSelected()) {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�idetailsJushotiTokureiInfoRevisionCheck�j���I���ɂȂ��Ă���ꍇ
				// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
				if (!(getDetailList8().isEmpty())) {
					
					doMakeDetailTableList((VRMap) getDetailsJushotiTokureiInfoTable().getSelectedModelRowValue(), getDetailList8());
					// �E�������F�I�����R�[�h
					// �E�������FdetailList8

					// detailList8���e�[�u�����f���itableModelDetail8�j�ɐݒ肷��B
					getTableModelDetail8().setAdaptee(getDetailList8());
				}

			} else {
				// �S�Ă̏���\���`�F�b�N�{�b�N�X�idetailsJushotiTokureiInfoRevisionCheck�j���I�t�ɂȂ��Ă���ꍇ
				// detailList8���KEY�FSHOW_FLAG�̒l��1�̃��R�[�h���擾����B�i�ȉ��AtempList�j
				if (!(getDetailList8().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList8(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// �ڍ׃e�[�u���ɕ\�����邽�߂ɁA�ڍ׃e�[�u���\���p�̃f�[�^���쐬����B
					doMakeDetailTableList((VRMap) getDetailsJushotiTokureiInfoTable().getSelectedModelRowValue(), tempList);
					// �E�������F�I�����R�[�h
					// �E�������FtempList

					// tempList���e�[�u�����f���itableModelDetail8�j�ɐݒ肷��B
					getTableModelDetail8().setAdaptee(tempList);
				}
			}
		}
// 2014/12/24 [Yoichiro Kamei] add - end
	}

	/**
	 * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doSave() throws Exception {
		// DB�֕ۑ����s�������B
		try {
			// �g�����U�N�V�������J�n����B
			getDBManager().beginTransaction();
			// �p�b�V�u�`�F�b�N�̃^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();

			// �S���폜�p�̃p�b�V�u�`�F�b�N�̃^�X�N��ǉ�����B
			getPassiveChecker().addPassiveDeleteTask(getPASSIVE_CHECK_KEY());

			// �E�p�b�V�u�L�[�FPASSIVE_CHECK_KEY
			// �p�b�V�u�`�F�b�N���s���B
			if (getPassiveChecker().passiveCheck(getDBManager())) {

				// ���������e�[�u�������ׂĂЂƂ�List�Ɍł߂�
				VRList allList = new VRArrayList();
				allList.addAll(getTableClaimList1());
				allList.addAll(getTableClaimList2());
				allList.addAll(getTableClaimList3());
				allList.addAll(getTableClaimList4());
				allList.addAll(getTableClaimList5());
				allList.addAll(getTableClaimList6());
				//[H20.5 �@�����Ή�] fujihara add start
				allList.addAll(getTableClaimList7());
				//[H20.5 �@�����Ή�] fujihara add end

// 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
				allList.addAll(getTableClaimList8());
// 2014/12/24 [Yoichiro Kamei] add - end
				
				// DB���X�V���邽�߂�WHERE����쐬����B
				// WHERE��
				String whereStr = "(PATIENT_ID = " + getPatientId() + ") AND (INSURED_ID = '" + getInsuredId() + "') AND (TARGET_DATE = '" + VRDateParser.format(getTargetDate(), "yyyy-MM-dd") + "') AND (CLAIM_DATE = '" + VRDateParser.format(getClaimDate(), "yyyy-MM-dd") + "') AND (PROVIDER_ID = '" + getProviderId() + "') AND (CLAIM_STYLE_TYPE =" + getClaimStyleType() + ")";

				// �����f�[�^�iallList�j��DB���X�V����B
				QkanCommon.updateClaimDetailCustom(getDBManager(), allList, getTargetDate(), whereStr);

				// �X�V�ɐ��������ꍇ
				// �R�~�b�g����B
				getDBManager().commitTransaction();

				// ���L�̃t���O������������B
				// �EtableChangeFlg
				setTableChangeFlg(OFF);

				// �ŐV�̐����f�[�^���擾���A�p�b�V�u�`�F�b�N�p�ɑޔ�����B
				doFindClaim();
				return true;

			} else {

				// �p�b�V�u�G���[�����������ꍇ
				// �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
				// �E���b�Z�[�WID�FERROR_OF_PASSIVE_CHECK_ON_UPDATE
				// �i�I���j
				getDBManager().rollbackTransaction();
				return false;
			}
		} catch (Exception ex) {
			// �X�V�Ɏ��s�����ꍇ
			// ���[���o�b�N����B
			getDBManager().rollbackTransaction();
			// ��O�𓊂���B
			// �i�ُ�I���j
			throw ex;
		}
	}

	
	
	/*=================================================================
	 * [ID:0000429][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
	 =================================================================*/
	
	/**
	 * �ďW�v�{�^���������̏���
	 */
	protected void retotalActionPerformed(ActionEvent e) throws Exception {
		
		//�m�F���b�Z�[�W��\��
		if (QkanMessageList.getInstance().QP005_WARNING_OF_RETOTAL() != ACMessageBox.RESULT_OK){
			return;
		}
		//�ďW�v���s
		doRecount(false);
		
		QkanMessageList.getInstance().QP005_RETOTAL_SUCCESSED();
	}
	
	
	private void doRecount(boolean isPlanOverwrite) throws Exception {
// 2014/12/24 [Yoichiro Kamei] mod - begin �Z���n����Ή�
//		VRList[] list = new VRArrayList[7];
		VRList[] list = new VRArrayList[8];
// 2014/12/24 [Yoichiro Kamei] mod - end
		list[0] = getTableClaimList1();
		list[1] = getTableClaimList2();
		list[2] = getTableClaimList3();
		list[3] = getTableClaimList4();
		list[4] = getTableClaimList5();
		list[5] = getTableClaimList6();
		list[6] = getTableClaimList7();
// 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
		list[7] = getTableClaimList8();
// 2014/12/24 [Yoichiro Kamei] add - end
		dump(list, "before.txt");
		
		//�ďW�v���s�I
		QP001ReTotal qp001retotal = new QP001ReTotal();
// 2016/10/13 [Yoichiro Kamei] mod - begin �������ƑΉ�
//		qp001retotal.calc(list, getDBManager(), getPatientId(), isPlanOverwrite);
		try {
			qp001retotal.calc(list, getDBManager(), getPatientId(), isPlanOverwrite);
		} catch (QkanSjTankaNotFoundException e) {
			QkanMessageList.getInstance().QS001_SJ_TANKA_NOT_FOUND();
		}
// 2016/10/13 [Yoichiro Kamei] mod - end
		
		dump(list, "after.txt");
		
		//�S�e�[�u���ĕ`��
		repaintTable(getBasicInfoTable(), "BASIC", getTableClaimList1());
		repaintTable(getDetailsInfoTable(), "DETAIL", getTableClaimList2());
		repaintTable(getKyotakuDetailsInfoTable(), "KYOTAKU", getTableClaimList2());
		repaintTable(getParticularInfoTable(), "PARTICULAR", getTableClaimList3());
		repaintTable(getSpecialClinicInfoTable(), "SPECIAL_CLINIC", getTableClaimList3());
		repaintTable(getTotalInfoTable(), "TOTAL", getTableClaimList4());
		repaintTable(getNyushoInfoTable(), "NYUSHO", getTableClaimList5());
		repaintTable(getShahukuInfoTable(), "SHAHUKU", getTableClaimList6());
		repaintTable(getRecuperationInfoTable(), "RYOYO", getTableClaimList7());
// 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
		repaintTable(getDetailsJushotiTokureiInfoTable(), "DETAIL_JUSHOTI_TOKUREI", getTableClaimList8());
// 2014/12/24 [Yoichiro Kamei] add - end
		
		repaintTable(getTableModelList1());
		repaintTable(getTableModelList2());
		repaintTable(getTableModelList3());
		repaintTable(getTableModelList4());
		repaintTable(getTableModelList5());
		repaintTable(getTableModelList6());
		repaintTable(getTableModelList7());
// 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
		repaintTable(getTableModelList8());
// 2014/12/24 [Yoichiro Kamei] add - end
	}
	
	private void repaintTable(ACTableModelAdapter ta) throws Exception {
		if ((ta != null) && (ta.getTable() != null)) {
			ta.getTable().repaint();
		}
	}
	
	private void repaintTable(ACTable table, String key, VRList list) throws Exception {
		if ((list == null) || (list.size() <= 0)) {
			return;
		}
		
		if (table.isVisible() && (table.getRowCount() > 0)){
			if (!table.isSelected()){
				table.setSelectedSortedFirstRow();
			}
			doShowClaimDetail(key);
		}
	}
	
	/**
	 * �T�[�r�X�ǉ��{�^���������̏���
	 */
	protected void serviceAddButtonActionPerformed(ActionEvent e) throws Exception {
		QP005001 qp005001 = new QP005001();
		qp005001.showModal(getTargetDate());
		
		//�L�����Z�����ꂽ���m�F����
		if (!qp005001.getIsAdd()) {
			return;
		}
		//���͂��ꂽ�l���擾
		VRMap map = qp005001.getValues();
		
		//���R�[�h�ɕK�{�̏���ݒ�
		//CATEGORY_NO
		map.put("CATEGORY_NO", "8");
		//���R�[�h��ʃR�[�h2��(11��ݒ�)
		map.put("801002", "11");
		
		//��{��񃌃R�[�h����l���R�s�[
		if (getTableClaimList1().size() <= 0) {
			return;
		}
		
		int claim_id = QkanCommon.getBookingNumber(getDBManager(), "CLAIM","CLAIM_ID", 1);
		
		String[] copyKeys = new String[]
		{"PATIENT_ID",
		 "LAST_TIME",
		 "CLAIM_DATE",
		 "PROVIDER_ID",
		 "INSURER_ID",
		 "CLAIM_STYLE_TYPE",
		 "TARGET_DATE",
		 "INSURED_ID",
		 "CLAIM_FINISH_FLAG"};
		
		String[] copyKeysNum = new String[]
		{"01001", "01003", "01004", "01005", "01006"};
		
		VRMap base = (VRMap)getTableClaimList1().get(0);
		
		for (int i = 0; i < copyKeys.length; i++) {
			map.put(copyKeys[i], base.get(copyKeys[i]));
		}
		for (int i = 0; i < copyKeysNum.length; i++) {
			map.put("8" + copyKeysNum[i], base.get("2" + copyKeysNum[i]));
		}
		
		//CLAIM_ID
		map.put("CLAIM_ID", String.valueOf(claim_id));
		
		//�Ƃ肠�����l��ݒ�
		//��������҉��T�[�r�X��p��񃌃R�[�h�����ԍ�2��
		map.put("801007", "0");
		//����1����2��
		map.put("801013", "0");
		//����2����2��
		map.put("801014", "0");
		//����3����2��
		map.put("801015", "0");
		//��p�z6��
		map.put("801016", "0");
		//�ی��������z6��
		map.put("801017", "0");
		//����1���S�z(����)6��
		map.put("801018", "0");
		//����2���S�z(����)6��
		map.put("801019", "0");
		//����3���S�z(����)6��
		map.put("801020", "0");
		//���p�ҕ��S�z5��
		map.put("801021", "0");
		//��p�z���v6��
		map.put("801022", "0");
		//�ی��������z���v6��
		map.put("801023", "0");
		//���p�ҕ��S�z���v6��
		map.put("801024", "0");
		//(����1)���S�z���v6��
		map.put("801025", "0");
		//(����1)�����z6��
		map.put("801026", "0");
		//(����1)�{�l���S���z5��
		map.put("801027", "0");
		//(����2)���S�z���v6��
		map.put("801028", "0");
		//(����2)�����z6��
		map.put("801029", "0");
		//(����2)�{�l���S���z5��
		map.put("801030", "0");
		//(����3)���S�z���v6��
		map.put("801031", "0");
		//(����3)�����z6��
		map.put("801032", "0");
		//(����3)�{�l���S���z5��
		map.put("801033", "0");
		
		getTableClaimList5().addData(map);
		
		getTableModelList5().setAdaptee(getTableClaimList5());
		repaintTable(getNyushoInfoTable(), "NYUSHO", getTableClaimList5());
		repaintTable(getTableModelList5());
		
		//�ŏI�s��I����Ԃɂ���B
		getNyushoInfoTable().setSelectedSortedLastRow();
	}
	/**
	 * �T�[�r�X�폜�{�^���������̏���
	 */
	protected void serviceDelButtonActionPerformed(ActionEvent e) throws Exception {
		if (!getNyushoInfoTable().isSelected()) {
			return;
		}
		if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() != ACMessageBox.RESULT_OK){
			return;
		}
		VRMap map = (VRMap) getNyushoInfoTable().getSelectedModelRowValue();
		
		getTableClaimList5().remove(map);
		
		//�f�[�^���Ȃ��Ȃ�����A�ڍ׃e�[�u�����\���ɂ���
		if (getTableClaimList5().size() <= 0) {
			getTableModelDetail5().setAdaptee(new VRArrayList());
		} else {
			//��s�ڂ�I����Ԃɂ���
			getNyushoInfoTable().setSelectedSortedFirstRow();
		}
	}
	
	/**
	 * �X�i�b�v�V���b�g�擾
	 * @throws Exception
	 */
	private void doSnap() throws Exception {
		VRList list = new VRArrayList();
		
		list.add(deepCopy(getTableClaimList1()));
		list.add(deepCopy(getTableClaimList2()));
		list.add(deepCopy(getTableClaimList3()));
		list.add(deepCopy(getTableClaimList4()));
		list.add(deepCopy(getTableClaimList5()));
		list.add(deepCopy(getTableClaimList6()));
		list.add(deepCopy(getTableClaimList7()));
// 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
		list.add(deepCopy(getTableClaimList8()));
// 2014/12/24 [Yoichiro Kamei] add - end
		
		setSnapList(list);
	}
	
	private VRList deepCopy(VRList list) throws Exception {
		
		VRList r = new VRArrayList();
		
		for (int i = 0; i < list.size(); i++) {
			VRMap rm = new VRHashMap();
			VRMap map = (VRMap)list.get(i);
			
			Iterator it = map.keySet().iterator();
			
			while(it.hasNext()) {
				String key = it.next().toString();
				rm.put(key, map.get(key));
			}
			
			r.add(rm);
		}
		
		return r;
	}
	
	/**
	 * �X�i�b�v�V���b�g�`�F�b�N
	 * @return
	 * @throws Exception
	 */
	private boolean isModified() throws Exception {
		VRList list = new VRArrayList();
		
		list.add(getTableClaimList1());
		list.add(getTableClaimList2());
		list.add(getTableClaimList3());
		list.add(getTableClaimList4());
		list.add(getTableClaimList5());
		list.add(getTableClaimList6());
		list.add(getTableClaimList7());
// 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
		list.add(getTableClaimList8());
// 2014/12/24 [Yoichiro Kamei] add - end
				
		if (getSnapList().size() != list.size()) {
			return true;
		}
		
		for (int i = 0; i < list.size(); i++) {
			VRList l1 = (VRList)getSnapList().get(i);
			VRList l2 = (VRList)list.get(i);
			
			if (l1.size() != l2.size()){
				return true;
			}
			
			for (int j = 0; j < l2.size(); j++) {
				VRMap m1 = (VRMap)l1.get(j);
				VRMap m2 = (VRMap)l2.get(j);
				
				Iterator it = m1.keySet().iterator();
				
				while(it.hasNext()) {
					String key = it.next().toString();
					if (!m2.containsKey(key)) {
						return true;
					}
					
					String v1 = ACCastUtilities.toString(m1.get(key), ""); 
					String v2 = ACCastUtilities.toString(m2.get(key), "");
					
					if (!v1.equals(v2)) {
						return true;
					}
				}
			}
		}
		
		
		return false;
	}
	
	private void dump(VRList[] lists, String fileName) {
		
		try {
		
			if (!isDebugMode()) {
				return;
			}
			
			java.io.FileOutputStream fos = new java.io.FileOutputStream(fileName);
			java.io.OutputStreamWriter osw = new java.io.OutputStreamWriter(fos , "MS932");
			java.io.BufferedWriter bw = new java.io.BufferedWriter(osw);
	
			for (int i = 0; i < lists.length; i++ ){
				for (int j = 0; j < lists[i].size(); j++) {
					VRMap map = (VRMap)lists[i].get(j);
					
					Iterator it = map.keySet().iterator();
					while(it.hasNext()) {
						String key = it.next().toString();
						bw.write(key);
						bw.write(",");
						bw.write(ACCastUtilities.toString(map.get(key), ""));
						bw.write("\r\n");
					}
					
					
				}
			}
			bw.close();
			osw.close();
			fos.close();
		
		} catch (Exception e){
			e.printStackTrace();
		}
	}
    public boolean isDebugMode() {
		try {
			if (ACFrame.getInstance().hasProperty("ReTotalDump")
					&& "true".equalsIgnoreCase(ACCastUtilities.toString(ACFrame
							.getInstance().getProperty("ReTotalDump")))) {
				return true;
			}
		} catch (Exception ex) {
		}
		return false;
	}
	/*
	 * =================================================================
	 * [ID:0000429][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
	 * =================================================================
	 */

	/*=================================================================
	 * [ID:0000563][ID:0000576][Shin Fujihara] 2009/12 add begin 2009�N�x�Ή�
	 =================================================================*/
    
	protected void detailsDelButtonActionPerformed(ActionEvent e) throws Exception {
		if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() != ACMessageBox.RESULT_OK){
			return;
		}
		
		int deleteRow = getDetailsInfoTable().getSelectedRow();
		VRMap map = (VRMap) getDetailsInfoTable().getSelectedModelRowValue();
		
		getTableClaimList2().remove(map);
		//�폜�s�̈�s���I����Ԃɂ���
		getDetailsInfoTable().setSelectedSortedRowOnAfterDelete(deleteRow);
		
		if (getTableClaimList2().size() < 2) {
			//�폜�{�^�����g�p�s�\�ɂ���
			setState_TYPE11();
		}
		
		//[ID:0000576]�T�[�r�X�폜��A�ďW�v�����s����
		//���̂Ƃ��̍ďW�v�ł́A�v��P�ʐ����㏑������
		doRecount(true);
		
	}
	/*
	 * =================================================================
	 * [ID:0000563][ID:0000576][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
	 * =================================================================
	 */
	
// 2014/12/26 [Yoichiro Kamei] mod - begin �Z���n����Ή�
	protected void detailsJushotiTokureiDelButtonActionPerformed(ActionEvent e) throws Exception {
		if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() != ACMessageBox.RESULT_OK){
			return;
		}
		
		int deleteRow = getDetailsJushotiTokureiInfoTable().getSelectedRow();
		VRMap map = (VRMap) getDetailsJushotiTokureiInfoTable().getSelectedModelRowValue();
		
		getTableClaimList8().remove(map);
		//�폜�s�̈�s���I����Ԃɂ���
		getDetailsJushotiTokureiInfoTable().setSelectedSortedRowOnAfterDelete(deleteRow);
		
		if (getTableClaimList8().size() < 2) {
			//�폜�{�^�����g�p�s�\�ɂ���
			setState_TYPE13();
		}
		
		//[ID:0000576]�T�[�r�X�폜��A�ďW�v�����s����
		//���̂Ƃ��̍ďW�v�ł́A�v��P�ʐ����㏑������
		doRecount(true);
		
	}
// 2014/12/26 [Yoichiro Kamei] mod - end

}
