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
 * �쐬��: 2006/01/18  ���{�R���s���[�^�[������� �A�� ��C �V�K�쐬
 * �X�V��: 2006/03/14
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (006)
 * �v���O���� ��Ö��׏��ڍוҏW (QP006)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp006;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.text.Format;
import java.util.Date;

import javax.swing.event.DocumentEvent;

import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACTimeTextField;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.component.QkanDateTextField;

/**
 * ��Ö��׏��ڍוҏW(QP006)
 */

public class QP006 extends QP006Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QP006() {
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
		// �Ethis.patientId ��KEY�FPATIENT_ID
		// �Ethis.targetDate ��KEY�FTARGET_DATE
		// �Ethis.providerId ��KEY�FPROVIDER_ID
		// �Ethis.claimStyleType ��KEY�FCLAIM_STYLE_TYPE
		// �Ethis.listIndex ��KEY�FLIST_INDEX

		VRMap parameters = affair.getParameters();

		if (VRBindPathParser.has("PATIENT_ID", parameters)) {
			setPatientId(ACCastUtilities.toInt(parameters.getData("PATIENT_ID")));
		}

		if (VRBindPathParser.has("TARGET_DATE", parameters)) {
			setTargetDate(ACCastUtilities.toDate(parameters.getData("TARGET_DATE")));
		}

		if (VRBindPathParser.has("CLAIM_DATE", parameters)) {
			setClaimDate(ACCastUtilities.toDate(parameters.getData("CLAIM_DATE")));
		}

		if (VRBindPathParser.has("PROVIDER_ID", parameters)) {
			setProviderId(ACCastUtilities.toString(parameters.getData("PROVIDER_ID")));
		}

		if (VRBindPathParser.has("CLAIM_STYLE_TYPE", parameters)) {
			setClaimStyleType(ACCastUtilities.toInt(parameters.getData("CLAIM_STYLE_TYPE")));
		}

		if (VRBindPathParser.has("LIST_INDEX", parameters)) {
			setListIndex(ACCastUtilities.toInt(parameters.getData("LIST_INDEX")));
		}

		if (VRBindPathParser.has("INSURER_ID", parameters)) {
			setInsurerID(ACCastUtilities.toString(VRBindPathParser.get("INSURER_ID", parameters)));
		}

		// �p�b�V�u�`�F�b�N�L�[���Z�b�g����
		setPASSIVE_CHECK_KEY(new ACPassiveKey("CLAIM", new String[] { "CLAIM_ID" }, new Format[] { null }, "LAST_TIME", "LAST_TIME"));

		// �X�i�b�v�V���b�g�̎B�e�Ώۂ��u���̈�iinfos�j�v�ɐݒ肷��B
		getSnapshot().setRootContainer(getInfos());

		// �R���{�̐ݒ���s���B
		// �R�[�h�}�X�^�f�[�^���擾����B
		VRMap modelMap = new VRHashMap();

		// �擾�����R�[�h�}�X�^�f�[�^���ACODE_ID�F19�i�E����̎��R�j���擾����B
		// �擾�������R�[�h�W���i�E����̎��R�̑I�����j���R���{�ݒ�pHashMap�Fthis.modelMap�Ɉȉ���KEY�Őݒ肷��B
		// �EKEY�FSHOKUMU_JIYU
		modelMap.setData("SHOKUMU_JIYU", QkanCommon.getArrayFromMasterCode(19, "1301022"));
		modelMap.setData("HOUMON_END_STATE", QkanCommon.getArrayFromMasterCode(9, "1301099"));
		setModelMap(modelMap);

		// this.modelMap���u���̈�iinfos�j�v�ɐݒ肷��B
		getInfos().setModelSource(getModelMap());
		// ��ʂɓW�J����B
		getInfos().bindModelSource();
		// �f�[�^���擾���A��ʂɓW�J����B
		doFind();

		// �X�i�b�v�V���b�g���B�e����B
		getSnapshot().snapshot();

        
        String osName = System.getProperty("os.name");
        if ((osName != null) && (osName.indexOf("Mac") >= 0)) {
            //Mac�̏ꍇ�A�s�����𒲐����ĉ�ʓ��Ɏ��߂�
            getOfferInfoText().setRows(3);
            getSpecialEtcText().setRows(3);
            getVisitCareDetailedTotalMoneyStanderdEtcText().setColumns(52);
            getVisitCareDetailedTotalMoneyStanderdEtcText().setMaxRows(5);
            getVisitCareDetailedTotalMoneyStanderdEtcText().setRows(6);
            
            getVisitCareDetailedExpenseMoneyText1().setColumns(6);
            getVisitCareDetailedExpenseMoneyText2().setColumns(6);
            getVisitCareDetailedExpenseMoneyText3().setColumns(6);
            getVisitCareDetailedOneshareText().setColumns(6);
            getVisitCareDetailedOneshareTex2().setColumns(6);
            getVisitCareDetailedOneshareTex3().setColumns(6);
        }
	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�̃`�F�b�N�j
		if (getSnapshot().isModified()) {
			// �E���b�Z�[�WID�FWARNING_OF_UPDATE_ON_MODIFIED
			int buttonStatus = QkanMessageList.getInstance().WARNING_OF_UPDATE_ON_MODIFIED();
			// �Ō�ɕۑ�����Ă���A���ڂ��ύX����Ă���ꍇ�iisModified�j
			// �m�F���b�Z�[�W��\������B
			switch (buttonStatus) {
				case ACMessageBox.RESULT_YES:
					// �u�͂��v��I�������ꍇ
					// ���̓`�F�b�N���s���B
					if (isValidInput() && doSave()) {
						// �ۑ�����������I�������ꍇ
						// �������b�Z�[�W��\������B
						// ���b�Z�[�WID�FUPDATE_SUCCESSED
						// �X�i�b�v�V���b�g�ɕύX�����������ꍇ
						// ���L��n��p�����[�^�Ƃ��āA�uQP003 ���[�i�l���j�E���Ə��I���v��ʂɑJ�ڂ���B
						// �EKEY�FPATIENT_ID VALUE�Fthis.patientId
						// �EKEY�FTARGET_DATE VALUE�Fthis.targetDate
						// �EKEY�FLIST_INDEX VALUE�Fthis.listIndex

						parameters.setData("PATIENT_ID", new Integer(getPatientId()));
						parameters.setData("TARGET_DATE", getTargetDate());
						parameters.setData("LIST_INDEX", new Integer(getListIndex()));
						parameters.setData("QP003", getClass().getName());
						return true;

					} else {
						// ���̓G���[���������ꍇ
						// �����𒆒f����B(�I��)
						// �ۑ�����������I�����Ȃ������ꍇ
						// �����𒆒f����B(�I��)
					}
					break;

				case ACMessageBox.RESULT_NO:
					// �u�������v��I�������ꍇ
					return true;

				default:
					break;
			}
		} else {
			parameters.setData("PATIENT_ID", new Integer(getPatientId()));
			parameters.setData("TARGET_DATE", getTargetDate());
			parameters.setData("LIST_INDEX", new Integer(getListIndex()));
			parameters.setData("QP003", getClass().getName());
			return true;
		}

		return false;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�̃`�F�b�N�j
		if (!getSnapshot().isModified()) {
			// �Ō�ɕۑ�����Ă���A���ڂ��ύX����Ă��Ȃ��ꍇ�iisModified�j
			// �V�X�e�����I������B
			return true;
		} else {
			// �Ō�ɕۑ�����Ă���A���ڂ��ύX����Ă���ꍇ�inot isModified�j
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
		}
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �uDB�o�^�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void updateActionPerformed(ActionEvent e) throws Exception {
		// ���̓`�F�b�N���s���B
		// ���̓G���[���������ꍇ
		// �����𒆒f����B(�I��)
		if (!isValidInput()) {
			return;
		}
		// �ۑ��������s���B
		if (doSave()) {

			// �ۑ�����������I�������ꍇ
			// �������b�Z�[�W��\������B
			QkanMessageList.getInstance().UPDATE_SUCCESSED();
			// �E���b�Z�[�WID�FUPDATE_SUCCESSED
			// �ۑ�����������I�����Ȃ������ꍇ
		} else {
			// �����𒆒f����B(�I��)
			return;
		}
		// �X�i�b�v�V���b�g���B�e����B
		getSnapshot().snapshot();
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText1FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText1�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText2�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText1(), getVisitCareDetailedDayText1())) {
			multiPlication(getVisitCareDetailedMoneyText1(), getVisitCareDetailedDayText1(), getVisitCareDetailedMoneyText2());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedDayText1FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText1�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText2�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText1(), getVisitCareDetailedDayText1())) {
			multiPlication(getVisitCareDetailedMoneyText1(), getVisitCareDetailedDayText1(), getVisitCareDetailedMoneyText2());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText2FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText3FocusLost(FocusEvent e) throws Exception {
		// ����1�̐������z�̍��v���v�Z����B
		doCalcTotalKohi1();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText4FocusLost(FocusEvent e) throws Exception {
		// ����2�̐������z�̍��v���v�Z����B
		doCalcTotalKohi2();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText5FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText2�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText6�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText5(), getVisitCareDetailedDayText2())) {
			multiPlication(getVisitCareDetailedMoneyText5(), getVisitCareDetailedDayText2(), getVisitCareDetailedMoneyText6());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedDayText2FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText5�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText6�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText5(), getVisitCareDetailedDayText2())) {
			multiPlication(getVisitCareDetailedMoneyText5(), getVisitCareDetailedDayText2(), getVisitCareDetailedMoneyText6());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText6FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText7FocusLost(FocusEvent e) throws Exception {
		// ����1�̐������z�̍��v���v�Z����B
		doCalcTotalKohi1();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText8FocusLost(FocusEvent e) throws Exception {
		// ����2�̐������z�̍��v���v�Z����B
		doCalcTotalKohi2();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText9FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText3�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText10�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText9(), getVisitCareDetailedDayText3())) {
			multiPlication(getVisitCareDetailedMoneyText9(), getVisitCareDetailedDayText3(), getVisitCareDetailedMoneyText10());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedDayText3FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText9�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText10�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText9(), getVisitCareDetailedDayText3())) {
			multiPlication(getVisitCareDetailedMoneyText9(), getVisitCareDetailedDayText3(), getVisitCareDetailedMoneyText10());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText10FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText11FocusLost(FocusEvent e) throws Exception {
		// ����1�̐������z�̍��v���v�Z����B
		doCalcTotalKohi1();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText12FocusLost(FocusEvent e) throws Exception {
		// ����2�̐������z�̍��v���v�Z����B
		doCalcTotalKohi2();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText13FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText4�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText14�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText13(), getVisitCareDetailedDayText4())) {
			multiPlication(getVisitCareDetailedMoneyText13(), getVisitCareDetailedDayText4(), getVisitCareDetailedMoneyText14());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedDayText4FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText13�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText14�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText13(), getVisitCareDetailedDayText4())) {
			multiPlication(getVisitCareDetailedMoneyText13(), getVisitCareDetailedDayText4(), getVisitCareDetailedMoneyText14());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText14FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText15FocusLost(FocusEvent e) throws Exception {
		// ����1�̐������z�̍��v���v�Z����B
		doCalcTotalKohi1();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText16FocusLost(FocusEvent e) throws Exception {
		// ����2�̐������z�̍��v���v�Z����B
		doCalcTotalKohi2();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText17FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText5�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText18�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText17(), getVisitCareDetailedDayText5())) {
			multiPlication(getVisitCareDetailedMoneyText17(), getVisitCareDetailedDayText5(), getVisitCareDetailedMoneyText18());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedDayText5FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText17�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText18�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText17(), getVisitCareDetailedDayText5())) {
			multiPlication(getVisitCareDetailedMoneyText17(), getVisitCareDetailedDayText5(), getVisitCareDetailedMoneyText18());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText18FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText19FocusLost(FocusEvent e) throws Exception {
		// ����1�̐������z�̍��v���v�Z����B
		doCalcTotalKohi1();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText20FocusLost(FocusEvent e) throws Exception {
		// ����2�̐������z�̍��v���v�Z����B
		doCalcTotalKohi2();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText51FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText8�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText52�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText51(), getVisitCareDetailedDayText8())) {
			multiPlication(getVisitCareDetailedMoneyText51(), getVisitCareDetailedDayText8(), getVisitCareDetailedMoneyText52());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedDayText8FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText51�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText52�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText51(), getVisitCareDetailedDayText8())) {
			multiPlication(getVisitCareDetailedMoneyText51(), getVisitCareDetailedDayText8(), getVisitCareDetailedMoneyText52());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText52FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText53FocusLost(FocusEvent e) throws Exception {
		// ����1�̐������z�̍��v���v�Z����B
		doCalcTotalKohi1();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText54FocusLost(FocusEvent e) throws Exception {
		// ����2�̐������z�̍��v���v�Z����B
		doCalcTotalKohi2();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText21FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText6�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText22�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText21(), getVisitCareDetailedDayText6())) {
			multiPlication(getVisitCareDetailedMoneyText21(), getVisitCareDetailedDayText6(), getVisitCareDetailedMoneyText22());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedDayText6FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText21�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText22�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText21(), getVisitCareDetailedDayText6())) {
			multiPlication(getVisitCareDetailedMoneyText21(), getVisitCareDetailedDayText6(), getVisitCareDetailedMoneyText22());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText22FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText23FocusLost(FocusEvent e) throws Exception {
		// ����1�̐������z�̍��v���v�Z����B
		doCalcTotalKohi1();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText24FocusLost(FocusEvent e) throws Exception {
		// ����2�̐������z�̍��v���v�Z����B
		doCalcTotalKohi2();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText25FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedTimeText1�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText26�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText25(), getVisitCareDetailedTimeText1())) {
			multiPlication(getVisitCareDetailedMoneyText25(), getVisitCareDetailedTimeText1(), getVisitCareDetailedMoneyText26());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedTimeText1FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText25�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText26�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText25(), getVisitCareDetailedTimeText1())) {
			multiPlication(getVisitCareDetailedMoneyText25(), getVisitCareDetailedTimeText1(), getVisitCareDetailedMoneyText26());
		}

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText26FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText27FocusLost(FocusEvent e) throws Exception {
		// ����1�̐������z�̍��v���v�Z����B
		doCalcTotalKohi1();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText28FocusLost(FocusEvent e) throws Exception {
		// ����2�̐������z�̍��v���v�Z����B
		doCalcTotalKohi2();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText29FocusLost(FocusEvent e) throws Exception {
		// �ȉ��̃t�B�[���h�S�Ăɒl�����͂���Ă���ꍇ
		// �EvisitCareDetailedMoneyText29Insert
		// �EvisitCareDetailedDayText7
		if (!ACTextUtilities.isNullText(getVisitCareDetailedMoneyText29Insert().getText()) && !ACTextUtilities.isNullText(getVisitCareDetailedDayText7().getText())) {
			// �ȉ��̌v�Z���s���B
			// �i�����̋��z�j + �i2���ڈȍ~�̋��z�j �~ �i�����j = �i���v���z�j
			// �Z�o�������v���z��visitCareDetailedMoneyText30�ɕ\������B
			multiPlication(getVisitCareDetailedMoneyText29(), getVisitCareDetailedMoneyText29Insert(), getVisitCareDetailedDayText7(), getVisitCareDetailedMoneyText30());
		} else {
			// ��L�ȊO�̏ꍇ
			// visitCareDetailedMoneyText29�ɓ��͂���Ă���l��visitCareDetailedMoneyText30�ɕ\������B
			getVisitCareDetailedMoneyText30().setText(ACCastUtilities.toString(getVisitCareDetailedMoneyText29().getText()));
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText29InsertFocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText7�ɒl�����͂���Ă���ꍇ
		if (!ACTextUtilities.isNullText(getVisitCareDetailedDayText7().getText())) {
			// �ȉ��̌v�Z���s���B
			// �i�����̋��z�j + �i2���ڈȍ~�̋��z�j �~ �i�����j = �i���v���z�j
			// �Z�o�������v���z��visitCareDetailedMoneyText30�ɕ\������B
			// visitCareDetailedMoneyText29�ɒl�����͂���Ă��Ȃ��ꍇ
			multiPlication(getVisitCareDetailedMoneyText29(), getVisitCareDetailedMoneyText29Insert(), getVisitCareDetailedDayText7(), getVisitCareDetailedMoneyText30());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedDayText7FocusLost(FocusEvent e) throws Exception {
		if (!ACTextUtilities.isNullText(getVisitCareDetailedDayText7().getText())) {
			// visitCareDetailedMoneyText29Insert�ɒl�����͂���Ă���ꍇ
			if (!ACTextUtilities.isNullText(getVisitCareDetailedMoneyText29Insert().getText())) {

				// visitCareDetailedMoneyText29�ɒl�����͂���Ă���ꍇ
				if (!ACTextUtilities.isNullText(getVisitCareDetailedMoneyText29().getText())) {
					// �ȉ��̌v�Z���s���B
					// �i�����̋��z�j + �i2���ڈȍ~�̋��z�j �~ �i�����j = �i���v���z�j
					// �Z�o�������v���z��visitCareDetailedMoneyText30�ɕ\������B

					multiPlication(getVisitCareDetailedMoneyText29(), getVisitCareDetailedMoneyText29Insert(), getVisitCareDetailedDayText7(), getVisitCareDetailedMoneyText30());

				} else {
					// visitCareDetailedMoneyText29�ɒl�����͂���Ă��Ȃ��ꍇ
					// �ȉ��̌v�Z���s���B
					// �i2���ڈȍ~�̋��z�j �~ �i�����j = �i2���ڈȍ~�̍��v���z�j
					// 2���ڈȍ~�̍��v���z��visitCareDetailedMoneyText30�ɕ\������B
					multiPlication(getVisitCareDetailedMoneyText29Insert(), getVisitCareDetailedDayText7(), getVisitCareDetailedMoneyText30());
				}
				// visitCareDetailedMoneyText29Insert�ɒl�����͂���Ă��Ȃ��ꍇ
			} else {
				// visitCareDetailedMoneyText29�ɒl�����͂���Ă���ꍇ
				// visitCareDetailedMoneyText29�ɓ��͂���Ă���l��visitCareDetailedMoneyText30�ɕ\������B
				getVisitCareDetailedMoneyText30().setText(ACCastUtilities.toString(getVisitCareDetailedMoneyText29().getText()));

			}
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText30FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText31FocusLost(FocusEvent e) throws Exception {
		// ����1�̐������z�̍��v���v�Z����B
		doCalcTotalKohi1();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText32FocusLost(FocusEvent e) throws Exception {
		// ����2�̐������z�̍��v���v�Z����B
		doCalcTotalKohi2();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText36FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText37FocusLost(FocusEvent e) throws Exception {
		// ����1�̐������z�̍��v���v�Z����B
		doCalcTotalKohi1();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText38FocusLost(FocusEvent e) throws Exception {
		// ����2�̐������z�̍��v���v�Z����B
		doCalcTotalKohi2();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText39FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText40FocusLost(FocusEvent e) throws Exception {
		// ����1�̐������z�̍��v���v�Z����B
		doCalcTotalKohi1();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText41FocusLost(FocusEvent e) throws Exception {
		// ����2�̐������z�̍��v���v�Z����B
		doCalcTotalKohi2();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText42FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText43FocusLost(FocusEvent e) throws Exception {
		// ����1�̐������z�̍��v���v�Z����B
		doCalcTotalKohi1();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText44FocusLost(FocusEvent e) throws Exception {
		// ����2�̐������z�̍��v���v�Z����B
		doCalcTotalKohi2();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText45FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText46FocusLost(FocusEvent e) throws Exception {
		// ����1�̐������z�̍��v���v�Z����B
		doCalcTotalKohi1();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText47FocusLost(FocusEvent e) throws Exception {
		// ����2�̐������z�̍��v���v�Z����B
		doCalcTotalKohi2();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText48FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText49FocusLost(FocusEvent e) throws Exception {
		// ����1�̐������z�̍��v���v�Z����B
		doCalcTotalKohi1();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText50FocusLost(FocusEvent e) throws Exception {
		// ����2�̐������z�̍��v���v�Z����B
		doCalcTotalKohi2();

	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */

	protected void visitCareDetailedDayText9FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText55�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText52�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText55(), getVisitCareDetailedDayText9())) {
			multiPlication(getVisitCareDetailedMoneyText55(), getVisitCareDetailedDayText9(), getVisitCareDetailedMoneyText56());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText55FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText9�ɒl�����͂���Ă���ꍇ
		// �ȉ��̌v�Z���s���B
		// �i1��������̋��z�j �~ �i�����j = �i���v���z�j
		// �Z�o�������v���z��visitCareDetailedMoneyText56�ɕ\������B
		if (!checkEmpty(getVisitCareDetailedMoneyText55(), getVisitCareDetailedDayText9())) {
			multiPlication(getVisitCareDetailedMoneyText55(), getVisitCareDetailedDayText9(), getVisitCareDetailedMoneyText56());
		}
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText56FocusLost(FocusEvent e) throws Exception {
		// �������z�̍��v���v�Z����B
		doCalcTotal();
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText57FocusLost(FocusEvent e) throws Exception {
		doCalcTotalKohi1();
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText58FocusLost(FocusEvent e) throws Exception {
		doCalcTotalKohi2();
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText61FocusLost(FocusEvent e) throws Exception {
		doCalcTotal();
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText62FocusLost(FocusEvent e) throws Exception {
		doCalcTotalKohi1();
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedMoneyText63FocusLost(FocusEvent e) throws Exception {
		doCalcTotalKohi2();
	}

	/**
	 * �u���z�v�Z�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedExpenseMoneyText1FocusLost(FocusEvent e) throws Exception {
		// ���S���z���v�Z����B
		// ��ʏ�̈ȉ��̃f�[�^���擾����B
		// �E���t����
		// �E�ی������~
		doCalcTotal();
	}

	/**
	 * �uEnable���䏈���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedReductionFocusLost(FocusEvent e) throws Exception {
		// ���l�����͂���Ă���ꍇ
		if (!ACTextUtilities.isNullText(getVisitCareDetailedReduction().getText())) {
			// ���z���W�I�O���[�v�Ə�ԃ��W�I�O���[�v��Enable������s���B
			setState_REDUCTION_ENABLE_TRUE();
			// �E���ID�FREDUCTION_ENABLE_TRUE
		} else {
			// �������͂���Ă��Ȃ��ꍇ
			// ���z���W�I�O���[�v�Ə�ԃ��W�I�O���[�v��Enable������s���B
			setState_REDUCTION_ENABLE_FALSE();
			// �E���ID�FREDUCTION_ENABLE_FALSE
		}
	}

	/**
	 * �uEnable���䏈���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void visitCareDetailedReductionTextChanged(DocumentEvent e) throws Exception {
		// ���l�����͂���Ă���ꍇ
		if (!ACTextUtilities.isNullText(getVisitCareDetailedReduction().getText())) {
			// ���z���W�I�O���[�v�Ə�ԃ��W�I�O���[�v��Enable������s���B
			setState_REDUCTION_ENABLE_TRUE();
			// �E���ID�FREDUCTION_ENABLE_TRUE
		} else {
			// �������͂���Ă��Ȃ��ꍇ
			// ���z���W�I�O���[�v�Ə�ԃ��W�I�O���[�v��Enable������s���B
			setState_REDUCTION_ENABLE_FALSE();
			// �E���ID�FREDUCTION_ENABLE_FALSE
		}
	}

	// {PATIENT_ID=2, CLAIM_DATE=Thu Jun 01 00:00:00 JST 2006, PROVIDER_ID=9999999999, LIST_INDEX=0, TARGET_DATE=2006-05-01, CLAIM_STYLE_TYPE=20101}
	// public static void main(String[] args) {
	// // �f�t�H���g�f�o�b�O�N��
	// ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
	// QkanCommon.debugInitialize();
	// VRMap param = new VRHashMap();
	// param.setData("PATIENT_ID", new Integer(2));
	// param.setData("PROVIDER_ID", "9999999999");
	// param.setData("LIST_INDEX", new Integer(0));
	// param.setData("CLAIM_STYLE_TYPE", new Integer(20101));
	// param.setData("CLAIM_DATE", "2006-06-01");
	// param.setData("TARGET_DATE", "2006-05-01");
	// // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
	// ACFrame.debugStart(new ACAffairInfo(QP006.class.getName(), param));
	// }

	// �����֐�

	/**
	 * �u�f�[�^�擾�E��ʓW�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFind() throws Exception {
		// �����\�������B
		// �����\����Ԃł�FALSE�ŕ\������B
		// setState_REDUCTION_ENABLE_FALSE();

		// �Ɩ����}�X�^���A�f�[�^���擾����B
		// �擾�����f�[�^�̃E�B���h�E�^�C�g���iWINDOW_TITLE�j���E�B���h�E�ɐݒ肷��B
		// �擾�����f�[�^�̋Ɩ��^�C�g���iAFFAIR_TITLE�j���Ɩ��{�^���o�[�ɐݒ肷��B
		setAffairTitle("QP006", getButtons());
		// ���p�҂̈�Ð����f�[�^���擾���Athis.claimList�Ɋi�[����B
		doFindClaim();

	}

	/**
	 * �u�����f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFindClaim() throws Exception {
		// �����f�[�^�擾�����B
		// �����f�[�^�擾�p��WHERE����쐬����B
		// WHERE��
		// (PATIENT_ID = this.patientId)
		// AND (TARGET_DATE = this.targetDate)
		// AND (PROVIDER_ID = this.providerId)
		// AND (CLAIM_STYLE_TYPE = this.claimStyleType)
		String whereString = "(PATIENT_ID = " + String.valueOf(getPatientId()) + ") AND (TARGET_DATE = '" + VRDateParser.format(getTargetDate(), "yyyy-MM-dd") + "') AND (PROVIDER_ID = '" + String.valueOf(getProviderId()) + "') AND (CLAIM_STYLE_TYPE = " + String.valueOf(getClaimStyleType()) + ")" + " AND (INSURER_ID = '" + getInsurerID() + "')";

		// �����f�[�^���擾���Athis.claimList�Ɋi�[����B
		// getClaimDetailCustom(String(WHERE��));
		VRList claimDetailCustomList = QkanCommon.getClaimDetailCustom(getDBManager(), getClaimDate(), whereString);
		if (!(claimDetailCustomList == null)) {
			setClaimList(claimDetailCustomList);

			setWindowMap((VRMap) getClaimList().getData(0));

			// ��ʕ\���p�Ƀf�[�^��ҏW����B
			doEditDataForDisplay();
		}

		getInfos().setSource(getWindowMap());

		// ��ʂɓW�J����B
		getInfos().bindSource();

		// �p�b�V�u�`�F�b�N�p�ɑޔ�����B
		getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), getClaimList());

	}

	/**
	 * �u�\���p�ɕҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doEditDataForDisplay() throws Exception {
		// �����f�[�^�̕ҏW�����B
		// this.claimList�̍ŏ��̃��R�[�h����ʕ\���p�ɕҏW����B

		// �擾�����l��1301141�i���z�j�ɒl�������Ă���Ȃ�
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301141"))) {
			setState_REDUCTION_ENABLE_TRUE();
		} else {
			setState_REDUCTION_ENABLE_FALSE();
		}

		// �ȉ���Bindpath�Ɋւ��Ă�DB����null�̎擾���\���Ƃ��Ă��肦�鎖��O��ɋ󕶎��ɒu������B
		// 1301003 ����
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301003"))) {
			getWindowMap().setData("1301003", "");
		}
		// 1301004 �X�e�[�V�����R�[�h
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301004"))) {
			getWindowMap().setData("1301004", "");
		}
		// 1301019 ����
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301019"))) {
			getWindowMap().setData("1301019", "");
		}
		// 1301022 �E����̎��R
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301022"))) {
			getWindowMap().setData("1301022", "");
		}
		// 1301023 ���L����
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301023"))) {
			getWindowMap().setData("1301023", "");
		}
		// 1301016 �ی��Ҕԍ�
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301016"))) {
			getWindowMap().setData("1301016", "");
		}
		// 1301018 �L���ԍ�
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301018"))) {
			getWindowMap().setData("1301018", "");
		}
		// 1301024 �K��Ō�X�e�[�V����
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301024"))) {
			getWindowMap().setData("1301024", "");
		}
		// 1301005 �s�����ԍ�
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301005"))) {
			getWindowMap().setData("1301005", "");
		}
		// 1301006 �V�l�󋋎Ҕԍ�
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301006"))) {
			getWindowMap().setData("1301006", "");
		}
		// 1301007 ����S�Ҕԍ��@
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301007"))) {
			getWindowMap().setData("1301007", "");
		}
		// 1301008 ����󋋎Ҕԍ��@
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301008"))) {
			getWindowMap().setData("1301008", "");
		}
		// 1301009 ����S�Ҕԍ��A
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301009"))) {
			getWindowMap().setData("1301009", "");
		}
		// 1301010 ����󋋎Ҕԍ��A
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301010"))) {
			getWindowMap().setData("1301010", "");
		}

		// ���t�P
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301104"))) {
			getWindowMap().setData("1301104", new Integer(0));
		}
		// ���t�Q
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301105"))) {
			getWindowMap().setData("1301105", new Integer(0));
		}
		// ���t�R
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301106"))) {
			getWindowMap().setData("1301106", new Integer(0));
		}
		// ���t�S
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301107"))) {
			getWindowMap().setData("1301107", new Integer(0));
		}
		// ���t�T
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301108"))) {
			getWindowMap().setData("1301108", new Integer(0));
		}
		// ���t�U
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301109"))) {
			getWindowMap().setData("1301109", new Integer(0));
		}
		// ���t�V
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301110"))) {
			getWindowMap().setData("1301110", new Integer(0));
		}
		// ���t�W
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301111"))) {
			getWindowMap().setData("1301111", new Integer(0));
		}
		// ���t�X
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301112"))) {
			getWindowMap().setData("1301112", new Integer(0));
		}
		// ���t�P�O
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301113"))) {
			getWindowMap().setData("1301113", new Integer(0));
		}
		// ���t�P�P
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301114"))) {
			getWindowMap().setData("1301114", new Integer(0));
		}
		// ���t�P�Q
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301115"))) {
			getWindowMap().setData("1301115", new Integer(0));
		}
		// ���t�P�R
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301116"))) {
			getWindowMap().setData("1301116", new Integer(0));
		}
		// ���t�P�S
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301117"))) {
			getWindowMap().setData("1301117", new Integer(0));
		}
		// ���t�P�T
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301118"))) {
			getWindowMap().setData("1301118", new Integer(0));
		}
		// ���t�P�U
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301119"))) {
			getWindowMap().setData("1301119", new Integer(0));
		}
		// ���t�P�V
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301120"))) {
			getWindowMap().setData("1301120", new Integer(0));
		}
		// ���t�P�W
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301121"))) {
			getWindowMap().setData("1301121", new Integer(0));
		}
		// ���t�P�X
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301122"))) {
			getWindowMap().setData("1301122", new Integer(0));
		}
		// ���t�Q�O
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301123"))) {
			getWindowMap().setData("1301123", new Integer(0));
		}
		// ���t�Q�P
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301124"))) {
			getWindowMap().setData("1301124", new Integer(0));
		}
		// ���t�Q�Q
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301125"))) {
			getWindowMap().setData("1301125", new Integer(0));
		}
		// ���t�Q�R
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301126"))) {
			getWindowMap().setData("1301126", new Integer(0));
		}
		// ���t�Q�S
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301127"))) {
			getWindowMap().setData("1301127", new Integer(0));
		}
		// ���t�Q�T
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301128"))) {
			getWindowMap().setData("1301128", new Integer(0));
		}
		// ���t�Q�U
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301129"))) {
			getWindowMap().setData("1301129", new Integer(0));
		}
		// ���t�Q�V
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301130"))) {
			getWindowMap().setData("1301130", new Integer(0));
		}
		// ���t�Q�W
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301131"))) {
			getWindowMap().setData("1301131", new Integer(0));
		}
		// ���t�Q�X
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301132"))) {
			getWindowMap().setData("1301132", new Integer(0));
		}
		// ���t�R�O
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301133"))) {
			getWindowMap().setData("1301133", new Integer(0));
		}
		// ���t�R�P
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301134"))) {
			getWindowMap().setData("1301134", new Integer(0));
		}

		// �E����
		// KEY�F1301020�̒l��1�̏ꍇ

		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301020"))) {
			if (Male.equals(getWindowMap().getData("1301020"))) {
				// ���R�[�h�Ɉȉ���KEY/VALUE��ݒ肷��B
				// �EKEY�FSEX VALUE�F"�j"
				getWindowMap().setData("SEX", "�j");
			} else if (feMale.equals(getWindowMap().getData("1301020"))) {
				// KEY�F1301020�̒l��2�̏ꍇ
				// ���R�[�h�Ɉȉ���KEY/VALUE��ݒ肷��B
				// �EKEY�FSEX VALUE�F"��"
				getWindowMap().setData("SEX", "��");
			} else {
				// ������ݒ肳��Ă��Ȃ������ꍇ
				getWindowMap().setData("SEX", "");
			}
		}
		// �E���N����
		// KEY�F1301021�̒l��a�N�����^�ɕϊ����A���R�[�h�Ɉȉ���KEY/VALUE��ݒ肷��B
		// �EKEY�FBIRTH_DAY VALUE�F�a�N�����^�ɕϊ������l
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301021"))) {
			getWindowMap().setData("BIRTH_DAY", VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("1301021")), "gggee�NMM��dd��"));
		}
		// �E�K��I���N�����A�I������
		// KEY�F1301095�̒l����N�����Ǝ��������o���A���R�[�h�Ɉȉ���KEY/VALUE��ݒ肷��B
		// �EKEY�FHOMON_END_DATE VALUE�F�N����
		// �EKEY�FHOMON_END_TIME VALUE�F���� �������^
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301095"))) {
			getWindowMap().setData("HOMON_END_DATE", VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("1301095")), "gggee�NMM��dd��"));
			getWindowMap().setData("HOMON_END_TIME", VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("1301095")), "HH:mm"));
		}
		// �E���S�N�����A���S����
		// KEY�F1301101�̒l����N�����Ǝ��������o���A���R�[�h�Ɉȉ���KEY/VALUE��ݒ肷��B
		// �EKEY�FDIE_DATE VALUE�F�N����
		// �EKEY�FDIE_TIME VALUE�F���� �������^
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301101"))) {
			getWindowMap().setData("DIE_DATE", VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("1301101")), "ggggee�NMM��dd��"));
			getWindowMap().setData("DIE_TIME", VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("1301101")), "HH:mm"));
		}

		int type = 0;
		// 1-�Е� 2-���� 3-����
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301011"))) {
			type = ACCastUtilities.toInt(getWindowMap().getData("1301011"), 0);
			switch (type) {
				case 1:
					getWindowMap().setData("INS_TYPE1", "�Е�");
					break;

				case 2:
					getWindowMap().setData("INS_TYPE1", "����");
					break;

				case 3:
					getWindowMap().setData("INS_TYPE1", "����");
					break;
				default:
					break;
			}
		}

		// 1-�V�l 2-�ސE
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301012"))) {
			type = ACCastUtilities.toInt(getWindowMap().getData("1301012"), 0);
			switch (type) {
				case 1:
					getWindowMap().setData("INS_TYPE2", "�V�l");
					break;

				case 2:
					getWindowMap().setData("INS_TYPE2", "�ސE");
					break;

				default:
					break;
			}
		}
		// 1-�P�� 2-�Q�� 3-�R��
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301013"))) {
			type = ACCastUtilities.toInt(getWindowMap().getData("1301013"), 0);
			switch (type) {
				case 1:
					getWindowMap().setData("INS_TYPE3", "�P��");
					break;

				case 2:
					getWindowMap().setData("INS_TYPE3", "�Q��");
					break;

				case 3:
					getWindowMap().setData("INS_TYPE3", "�R��");
					break;

				default:
					break;
			}
		}

		// 1-�{�l 2-�O�� 3-�Ƒ�
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301014"))) {
			type = ACCastUtilities.toInt(getWindowMap().getData("1301014"), 0);
			switch (type) {
				case 1:
					getWindowMap().setData("INS_TYPE4", "�{�l");
					break;

				case 2:
					getWindowMap().setData("INS_TYPE4", "�O��");
					break;

				case 3:
					getWindowMap().setData("INS_TYPE4", "�Ƒ�");
					break;

				default:
					break;
			}
		}

		// 1-����X 2-����W 3-����V
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301015"))) {
			type = ACCastUtilities.toInt(getWindowMap().getData("1301015"), 0);
			switch (type) {
				case 1:
					getWindowMap().setData("INS_TYPE5", "����X");
					break;

				case 2:
					getWindowMap().setData("INS_TYPE5", "����W");
					break;

                case 3:
                    getWindowMap().setData("INS_TYPE5", "����V");
                    break;

				default:
					break;
			}
		}

		// 1301017 --> BENEFIT_RATE
		// �EKEY�FBENEFIT_RATE
		// CONTENT_KEY=1, CONTENT=10
		// CONTENT_KEY=2, CONTENT=9
		// CONTENT_KEY=3, CONTENT=8
		// CONTENT_KEY=4, CONTENT=7
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301017"))) {
			type = ACCastUtilities.toInt(getWindowMap().getData("1301017"), 0);
			switch (type) {
				case 1:
					getWindowMap().setData("BENEFIT_RATE", "10");
					break;

				case 2:
					getWindowMap().setData("BENEFIT_RATE", "9");
					break;

				case 3:
					getWindowMap().setData("BENEFIT_RATE", "8");
					break;

				case 4:
					getWindowMap().setData("BENEFIT_RATE", "7");
					break;

				default:
					break;
			}
		}
	}

	/**
	 * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doSave() throws Exception {
		// �ۑ������B
		try {
			// �g�����U�N�V�������J�n����B
			getDBManager().beginTransaction();
			// �p�b�V�u�^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();

			// �S���폜�p�̃p�b�V�u�`�F�b�N�^�X�N��o�^����B
			getPassiveChecker().addPassiveDeleteTask(getPASSIVE_CHECK_KEY());

			// �p�b�V�u�`�F�b�N���s���B
			if (getPassiveChecker().passiveCheck(getDBManager())) {
				// �p�b�V�u�G���[���Ȃ��ꍇ

				// ��ʂ̃f�[�^���擾����B
				getInfos().setSource(getWindowMap());
				getInfos().applySource();

				// DB�X�V�p�Ƀf�[�^��ҏW����B
				doEditDataForUpdate();

				// �����f�[�^���X�V���邽�߂�WHERE����쐬����B
				// WHERE��
				// (PATIENT_ID = this.patientId)
				// AND (TARGET_DATE = this.targetDate)
				// AND (PROVIDER_ID = this.providerId)
				// AND (CLAIM_STYLE_TYPE = this.claimStyleType)

				String whereString = "(PATIENT_ID = " + getPatientId() + ") AND (TARGET_DATE = '" + VRDateParser.format(getTargetDate(), "yyyy-MM-dd") + "') AND (PROVIDER_ID = '" + getProviderId() + "') AND (CLAIM_STYLE_TYPE = " + getClaimStyleType() + ")";

				// �����f�[�^���X�V����B
				// updateClaimDetailCustom(DBManager, claimList,
				// String(WHERE��));
				// QkanCommon.updateClaimDetailCustom()

				QkanCommon.updateClaimDetailCustom(getDBManager(), getClaimList(), getTargetDate(), whereString);

				// �X�V�ɐ��������ꍇ
				// DB�������R�~�b�g����B
				getDBManager().commitTransaction();

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
			// DB���������[���o�b�N����B
			getDBManager().rollbackTransaction();
			// ��O�𓊂���B
			// �i�I���j
			throw ex;
		}

		// �ŐV�̐����f�[�^���擾���A�p�b�V�u�`�F�b�N�p�ɑޔ�����B
		doFindClaim();
		return true;
	}

	/**
	 * �u�X�V�p�ɕҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doEditDataForUpdate() throws Exception {
		// �����f�[�^�̕ҏW�����B
		// �E�K��I���N�����A�I������
		// ���R�[�h���A���L��KEY�̒l���擾����B
		// �EKEY�FHOMON_END_DATE
		// �EKEY�FHOMON_END_TIME
		// �擾�����K��I���N������String�^�ɕϊ����A���p�X�y�[�X������ŏI�������ƘA������B
		if (!ACTextUtilities.isNullText(getWindowMap().getData("HOMON_END_DATE"))) {
			if (!ACTextUtilities.isNullText(getWindowMap().getData("HOMON_END_TIME"))) {
				String endDate = VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("HOMON_END_DATE")), "yyyy-MM-dd ");
				String endTime = VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("HOMON_END_TIME")), "HH:mm");
				String houmonEndDateAndTime = endDate + endTime;
				// �A�������f�[�^��Date�^�ɕϊ����A���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
				// �EKEY�F1301095 VALUE�F�A�������f�[�^
				getWindowMap().setData("1301095", houmonEndDateAndTime);
			}
		}

		// �E���S�N�����A���S����
		// ���R�[�h���A���L��KEY�̒l���擾����B
		// �EKEY�FDIE_DATE
		// �EKEY�FDIE_TIME
		// �擾�������S�N������String�^�ɕϊ����A���p�X�y�[�X������Ŏ��S�����ƘA������B
		if (!ACTextUtilities.isNullText(getWindowMap().getData("DIE_DATE"))) {
			if (!ACTextUtilities.isNullText(getWindowMap().getData("DIE_TIME"))) {
				String dieDate = VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("DIE_DATE")), "yyyy-MM-dd ");
				String dieTime = VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("DIE_TIME")), "HH:mm");
				String dieDateAndTime = dieDate + dieTime;
				// �A�������f�[�^��Date�^�ɕϊ����A���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
				// �EKEY�F1301101 VALUE�F�A�������f�[�^
				getWindowMap().setData("1301101", dieDateAndTime);
			}
		}

		// �E���z�i���j/���z�i�~�j
		// ���z���W�I�O���[�v��E������������False�̏ꍇ
		if (!getVisitCareDetailedReductionRadio().isEnabled()) {
			// ���z���W�I�O���[�v���I������Ă���ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F1301142 VALUE�F0
			getWindowMap().setData("1301142", new Integer(0));
		}

		// �E�Ə�/�x���P�\
		// ��ԃ��W�I�O���[�v��Enable��False�̏ꍇ
		if (!getVisitCareDetailedStateRadio().isEnabled()) {
			// ��ԃ��W�I�O���[�v���I������Ă���ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F1301143 VALUE�F0
			getWindowMap().setData("1301143", new Integer(0));
		}

		// �E����
		// KEY�F1301020�̒l��1�̏ꍇ
		if (getWindowMap().getData("1301020").equals(Male)) {
			// ���R�[�h�Ɉȉ���KEY/VALUE��ݒ肷��B
			// �EKEY�FSEX VALUE�F"�j"
			getWindowMap().setData("SEX", "�j");
		}

		if (getWindowMap().getData("1301020").equals(feMale)) {
			// ���R�[�h�Ɉȉ���KEY/VALUE��ݒ肷��B
			// �EKEY�FSEX VALUE�F"�j"
			getWindowMap().setData("SEX", "�j");
		}

	}

	/**
	 * �u�������z�̍��v�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doCalcTotal() throws Exception {
		// �ȉ��̃t�B�[���h�ɓ��͂���Ă���l�̍��v���v�Z����B
		// �EvisitCareDetailedMoneyText2
		// �EvisitCareDetailedMoneyText6
		// �EvisitCareDetailedMoneyText10
		// �EvisitCareDetailedMoneyText14
		// �EvisitCareDetailedMoneyText18
		// �EvisitCareDetailedMoneyText52
		// �EvisitCareDetailedMoneyText22
		// �EvisitCareDetailedMoneyText26
		// �EvisitCareDetailedMoneyText30
		// �EvisitCareDetailedMoneyText36
		// �EvisitCareDetailedMoneyText39
		// �EvisitCareDetailedMoneyText42
		// �EvisitCareDetailedMoneyText45
		// �EvisitCareDetailedMoneyText48
		// �Z�o�������v���z��visitCareDetailedExpenseMoneyText1�ɕ\������B

		ACTextField sumTextFieldArray[] = { getVisitCareDetailedMoneyText2(), getVisitCareDetailedMoneyText6(), getVisitCareDetailedMoneyText10(), getVisitCareDetailedMoneyText14(), getVisitCareDetailedMoneyText18(), getVisitCareDetailedMoneyText52(), getVisitCareDetailedMoneyText22(), getVisitCareDetailedMoneyText26(), getVisitCareDetailedMoneyText30(), getVisitCareDetailedMoneyText36(), getVisitCareDetailedMoneyText39(), getVisitCareDetailedMoneyText42(), getVisitCareDetailedMoneyText45(),
				getVisitCareDetailedMoneyText48(), getVisitCareDetailedMoneyText56(), getVisitCareDetailedMoneyText61() };

		sumMachine(sumTextFieldArray, getVisitCareDetailedExpenseMoneyText1(), getVisitCareDetailedOneshareText());
	}

	/**
	 * �u����1�������z�̍��v�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doCalcTotalKohi1() throws Exception {
		// �ȉ��̃t�B�[���h�ɓ��͂���Ă���l�̍��v���v�Z����B
		// �EvisitCareDetailedMoneyText3
		// �EvisitCareDetailedMoneyText7
		// �EvisitCareDetailedMoneyText11
		// �EvisitCareDetailedMoneyText15
		// �EvisitCareDetailedMoneyText19
		// �EvisitCareDetailedMoneyText53
		// �EvisitCareDetailedMoneyText23
		// �EvisitCareDetailedMoneyText27
		// �EvisitCareDetailedMoneyText31
		// �EvisitCareDetailedMoneyText37
		// �EvisitCareDetailedMoneyText40
		// �EvisitCareDetailedMoneyText43
		// �EvisitCareDetailedMoneyText46
		// �EvisitCareDetailedMoneyText49
		// �Z�o�������v���z��visitCareDetailedExpenseMoneyText2�ɕ\������B

		ACTextField sumTextFieldArray[] = { getVisitCareDetailedMoneyText3(), getVisitCareDetailedMoneyText7(), getVisitCareDetailedMoneyText11(), getVisitCareDetailedMoneyText15(), getVisitCareDetailedMoneyText19(), getVisitCareDetailedMoneyText53(), getVisitCareDetailedMoneyText23(), getVisitCareDetailedMoneyText27(), getVisitCareDetailedMoneyText31(), getVisitCareDetailedMoneyText37(), getVisitCareDetailedMoneyText40(), getVisitCareDetailedMoneyText43(), getVisitCareDetailedMoneyText46(),
				getVisitCareDetailedMoneyText49(), getVisitCareDetailedMoneyText57(), getVisitCareDetailedMoneyText62() };
		sumMachine(sumTextFieldArray, getVisitCareDetailedExpenseMoneyText2(), getVisitCareDetailedOneshareTex2());
	}

	/**
	 * �u����2�������z�̍��v�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doCalcTotalKohi2() throws Exception {
		// �ȉ��̃t�B�[���h�ɓ��͂���Ă���l�̍��v���v�Z����B
		// �EvisitCareDetailedMoneyText4
		// �EvisitCareDetailedMoneyText8
		// �EvisitCareDetailedMoneyText12
		// �EvisitCareDetailedMoneyText16
		// �EvisitCareDetailedMoneyText20
		// �EvisitCareDetailedMoneyText54
		// �EvisitCareDetailedMoneyText24
		// �EvisitCareDetailedMoneyText28
		// �EvisitCareDetailedMoneyText32
		// �EvisitCareDetailedMoneyText38
		// �EvisitCareDetailedMoneyText41
		// �EvisitCareDetailedMoneyText44
		// �EvisitCareDetailedMoneyText47
		// �EvisitCareDetailedMoneyText50
		// �Z�o�������v���z��visitCareDetailedExpenseMoneyText3�ɕ\������B

		ACTextField sumTextFieldArray[] = { getVisitCareDetailedMoneyText4(), getVisitCareDetailedMoneyText8(), getVisitCareDetailedMoneyText12(), getVisitCareDetailedMoneyText16(), getVisitCareDetailedMoneyText20(), getVisitCareDetailedMoneyText54(), getVisitCareDetailedMoneyText24(), getVisitCareDetailedMoneyText28(), getVisitCareDetailedMoneyText32(), getVisitCareDetailedMoneyText38(), getVisitCareDetailedMoneyText41(), getVisitCareDetailedMoneyText44(), getVisitCareDetailedMoneyText47(),
				getVisitCareDetailedMoneyText50(), getVisitCareDetailedMoneyText58(), getVisitCareDetailedMoneyText63() };

		sumMachine(sumTextFieldArray, getVisitCareDetailedExpenseMoneyText3(), getVisitCareDetailedOneshareTex3());
	}

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean isValidInput() throws Exception {
		// ���̓`�F�b�N�����B
		// �ȉ��̓��t�����͂���Ă���ꍇ�A���݂��Ȃ����t�����͂���Ă��Ȃ����`�F�b�N����B

		// �E�w�����ԊJ�n�ivisitCareDetailedInstructDateText1�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�w�����ԊJ�n����"��������B
		if (checkErrorDate(getVisitCareDetailedInstructDateText1(), "�w�����ԊJ�n����")) {
			return false;
		}
		// �E�w�����ԏI���ivisitCareDetailedInstructDateText2�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�w�����ԏI������"��������B
		if (checkErrorDate(getVisitCareDetailedInstructDateText2(), "�w�����ԏI������")) {
			return false;
		}
		// �E���ʎw�����ԊJ�n�ivisitCareDetailedSpecialInstructDateText1�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���ʎw�����ԊJ�n����"��������B
		if (checkErrorDate(getVisitCareDetailedSpecialInstructDateText1(), "���ʎw�����ԊJ�n����")) {
			return false;
		}
		// �E���ʎw�����ԏI���ivisitCareDetailedSpecialInstructDateText2�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���ʎw�����ԏI������"��������B
		if (checkErrorDate(getVisitCareDetailedSpecialInstructDateText2(), "���ʎw�����ԏI������")) {
			return false;
		}
		// �E�K��J�n�N�����ivisitStart�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�K��J�n�N������"��������B
		if (checkErrorDate(getVisitStart(), "�K��J�n�N������")) {
			return false;
		}
		// �E�K��I���N�����ivisitEnd�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�K��I���N������"��������B
		if (checkErrorDate(getVisitEnd(), "�K��I���N������")) {
			return false;
		}
		// �E���S�N�����idieDate�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���S�N������"��������B
		if (checkErrorDate(getDieDate(), "���S�N������")) {
			return false;
		}
		// �E�厡��ւ̒��ߕ񍐔N�����imainDoctorInfoDate�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�厡��ւ̒��ߕ񍐔N������"��������B
		if (checkErrorDate(getMainDoctorInfoDate(), "�厡��ւ̒��ߕ񍐔N������")) {
			return false;
		}

		// �ȉ��̓��t�����͂���Ă���ꍇ�A�����̓��t�����͂���Ă��Ȃ����`�F�b�N����B
		// �E�w�����ԊJ�n�ivisitCareDetailedInstructDateText1�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�w�����ԊJ�n����"��������B
		// �������̃`�F�b�N��p�~6��8��
		// if (checkFutureDate(getVisitCareDetailedInstructDateText1(), "�w�����ԊJ�n����")) {
		// return false;
		// }

		// �E���ʎw�����ԊJ�n�ivisitCareDetailedSpecialInstructDateText1�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���ʎw�����ԊJ�n����"��������B
		// �������̃`�F�b�N��p�~6��8��
		// if (checkFutureDate(getVisitCareDetailedSpecialInstructDateText1(), "���ʎw�����ԊJ�n����")) {
		// return false;
		// }

		// �E�K��J�n�N�����ivisitStart�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�K��J�n�N������"��������B
		// �������̃`�F�b�N��p�~6��8��
		// if (checkFutureDate(getVisitStart(), "�K��J�n�N������")) {
		// return false;
		// }

		// �E���S�N�����idieDate�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���S�N������"��������B
		// �������̃`�F�b�N��p�~6��8��
		// if (checkFutureDate(getDieDate(), "���S�N������")) {
		// return false;
		// }

		// �E�厡��ւ̒��ߕ񍐔N�����imainDoctorInfoDate�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�厡��ւ̒��ߕ񍐔N������"��������B
		// �������̃`�F�b�N��p�~6��8��
		// if (checkFutureDate(getMainDoctorInfoDate(), "�厡��ւ̒��ߕ񍐔N������")) {
		// return false;
		// }

		// �ȉ��̓��t�����͂���Ă���ꍇ�A�J�n�ƏI���̑O��֌W���`�F�b�N����B
		// �E�w�����ԊJ�n�ivisitCareDetailedInstructDateText1�j�`�w�����ԏI���ivisitCareDetailedInstructDateText2�j
		// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�w�����Ԃ�"��������B
		// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"�J�n��"��������B
		// ���G���[�̏ꍇ�AString�FmsgParam3��錾���A"�I����"��������B
		if (checkRelationDate(getVisitCareDetailedInstructDateText1(), getVisitCareDetailedInstructDateText2(), "�w�����Ԃ�", "�J�n��", "�I����")) {
			return false;
		}
		// �E���ʎw�����ԊJ�n�ivisitCareDetailedSpecialInstructDateText1�j�`���ʎw�����ԏI���ivisitCareDetailedSpecialInstructDateText2�j
		// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"���ʎw�����Ԃ�"��������B
		// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"�J�n��"��������B
		// ���G���[�̏ꍇ�AString�FmsgParam3��錾���A"�I����"��������B
		if (checkRelationDate(getVisitCareDetailedSpecialInstructDateText1(), getVisitCareDetailedSpecialInstructDateText2(), "���ʎw�����Ԃ�", "�J�n��", "�I����")) {
			return false;
		}
		// �E�K��J�n�N�����ivisitStart�j�`�K��I���N�����ivisitEnd�j
		// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�K����Ԃ�"��������B
		// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"�J�n��"��������B
		// ���G���[�̏ꍇ�AString�FmsgParam3��錾���A"�I����"��������B
		if (checkRelationDate(getVisitStart(), getVisitEnd(), "�K����Ԃ�", "�J�n��", "�I����")) {
			return false;
		}

		// �ȉ��̎��������͂���Ă���ꍇ�A���݂��Ȃ����������͂���Ă��Ȃ����`�F�b�N����B
		// �E�K��I�������ivisitEndTime�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�K��I����"��������B
		if (checkErrorTime(getVisitEndTime(), "�K��I����")) {
			return false;
		}

		// �E���S�����idieTime�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���S��"��������B
		if (checkErrorTime(getDieTime(), "���S��")) {
			return false;
		}

		return true;
	}

	/**
	 * �ufirst * second = output�v�Ɋւ��鏈�����s�Ȃ��܂��B first��second���|�����l���A��3�����Ɏw�肳�ꂽACTextField�I�u�W�F�N�g�ɒl�𔽉f���܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void multiPlication(ACTextField first, ACTextField second, ACTextField output) throws Exception {
		// first��second��null�Ŗ������l���`�F�b�N����
		if (!(ACTextUtilities.isNullText(first.getText()))) {
			if (!(ACTextUtilities.isNullText(second.getText()))) {
				long total = ACCastUtilities.toLong(first.getText()) * ACCastUtilities.toLong(second.getText());
				output.setText(ACCastUtilities.toString(total));
			}
		}
	}

	/**
	 * �u(second * third) + first = output �̌v�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void multiPlication(ACTextField first, ACTextField second, ACTextField third, ACTextField output) throws Exception {
		long total = 0;
		if (!(ACTextUtilities.isNullText(first.getText()))) {
			if (!(ACTextUtilities.isNullText(second.getText()))) {
				if (!(ACTextUtilities.isNullText(third.getText()))) {
					total = ACCastUtilities.toLong(second.getText()) * ACCastUtilities.toLong(third.getText()) + ACCastUtilities.toLong(first.getText());
				}
			}
		} else {
			// First��NULL�������͋󕶎��̏ꍇ��second+third�݂̂����Z���ĕԋp����
			if (!(ACTextUtilities.isNullText(second.getText()))) {
				if (!(ACTextUtilities.isNullText(third.getText()))) {
					total = ACCastUtilities.toLong(second.getText()) * ACCastUtilities.toLong(third.getText());
				}
			}
		}
		output.setText(ACCastUtilities.toString(total));
	}

	/**
	 * �u���v�v�Ɋւ��鏈�����s�Ȃ��܂��B ACTextField�̃I�u�W�F�N�g�z��̒l�����ׂč��Z���āAoutputTextField�ɕԂ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void sumMachine(ACTextField sumArray[], ACTextField output, ACTextField oneShare) throws Exception {
		// first��second��null�Ŗ������l���`�F�b�N����
		// null �`�F�b�N���s���Ȃ���A���v���v�Z���Ă���
		long total = 0;

		for (int i = 0; i < sumArray.length; i++) {
			if (!ACTextUtilities.isNullText(sumArray[i].getText())) {
				total = total + ACCastUtilities.toLong(sumArray[i].getText());
			}
		}
		// ���v���ɒl��Ԃ�
		output.setText(ACCastUtilities.toString(total));

		if (!ACTextUtilities.isNullText(getVisitCareDetailedRatio().getText())) {
			// ���t���z�̂����̕��S���z�v�Z���s��
			// �ȉ��̌v�Z���s���B ��10�~�����l�̌ܓ�
			// '�ی������~' �~ �i1 - '���t����'/10�j = '���S���z'
			double patientPaymentReal = (total * (1.0 - (ACCastUtilities.toDouble(getVisitCareDetailedRatio().getText()) / 10)));

			// �����_�ȉ����l�̌ܓ�
			long patientPaymentCast = Math.round(patientPaymentReal);

			// ����1���Ŏl�̌ܓ����s��
			long patientPayment = ((patientPaymentCast + 5) / 10) * 10;

			// �l��ԋp����
			oneShare.setText(ACCastUtilities.toString(patientPayment));
		}
	}

	/**
	 * �u�Ó��ȓ��t�̓��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkErrorDate(QkanDateTextField dateParam, String errMsg) throws Exception {
		if (!ACTextUtilities.isNullText(dateParam.getText())) {
			if (!dateParam.isValidDate()) {
				// �s���Ȓl�̏ꍇ
				// �C���X�^���X�Ƀt�H�[�J�X�����Ă�B
				dateParam.requestFocus();
				// �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(errMsg);
				// �E���b�Z�[�WID�FERROR_OF_WRONG_DATE
				// �i�I���j
				return true;
			}
		}
		return false;
	}

	/**
	 * �u�Ó��Ȏ����̓��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkErrorTime(ACTimeTextField timeParam, String errMsg) throws Exception {
		if (!ACTextUtilities.isNullText(timeParam.getText())) {
			if (!timeParam.isValidDate()) {
				// �s���Ȓl�̏ꍇ
				// �C���X�^���X�Ƀt�H�[�J�X�����Ă�B
				timeParam.requestFocus();
				// �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().QP006_ERROR_OF_WRONG_TIME(errMsg);
				// �E���b�Z�[�WID�FERROR_OF_WRONG_TIME
				// �i�I���j
				return true;
			}
		}
		return false;
	}

	/**
	 * �u�������t�̓��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkFutureDate(QkanDateTextField dateParam, String errMsg) throws Exception {
		if (!ACTextUtilities.isNullText(dateParam.getText())) {
			Date nowDate = QkanSystemInformation.getInstance().getSystemDate();
			if (ACDateUtilities.compareOnDay(nowDate, ACCastUtilities.toDate(dateParam.getText())) < 0) {
				// �s���Ȓl�̏ꍇ
				// �C���X�^���X�Ƀt�H�[�J�X�����Ă�B
				dateParam.requestFocus();
				// �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_FUTURE_DATE(errMsg);
				// �E���b�Z�[�WID�FERROR_OF_FUTURE_DATE
				// �i�I���j
				return true;
			}
		}
		return false;
	}

	/**
	 * �u���t�̊J�n���ƏI�����̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkRelationDate(QkanDateTextField firstDateParam, QkanDateTextField secondDateParam, String errMsg1, String errMsg2, String errMsg3) throws Exception {
		if (!ACTextUtilities.isNullText(firstDateParam.getText())) {
			if (!ACTextUtilities.isNullText(secondDateParam.getText())) {
				if (ACDateUtilities.compareOnDay(ACCastUtilities.toDate(firstDateParam.getText()), ACCastUtilities.toDate(secondDateParam.getText())) > 0) {
					// �s���Ȓl�̏ꍇ
					// �C���X�^���X�Ƀt�H�[�J�X�����Ă�B
					firstDateParam.requestFocus();
					// �G���[���b�Z�[�W��\������B
					QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION(errMsg1, errMsg2, errMsg3);

					// �E���b�Z�[�WID�FERROR_OF_GREATER_DATE_RELATION
					// �i�I���j
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * �u�󕶎��`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkEmpty(ACTextField arg1, ACTextField arg2) throws Exception {
		if (ACTextUtilities.isNullText(arg1.getText()) || ACTextUtilities.isNullText(arg2.getText())) {
			return true;
		}
		return false;
	}

	/**
	 * �u�󕶎��`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkEmpty(ACTextField arg1, ACTextField arg2, ACTextField arg3) throws Exception {
		if (ACTextUtilities.isNullText(arg1.getText()) || ACTextUtilities.isNullText(arg2.getText()) || ACTextUtilities.isNullText(arg3.getText())) {
			return true;
		}
		return false;
	}
    
      protected void addVisitCareDetailedReductionContena() {
        String osName = System.getProperty("os.name");
        if ((osName != null) && (osName.indexOf("Mac") >= 0)) {
            //Mac�̏ꍇ�A�i�g�𒲐����ĉ�ʓ��Ɏ��߂�
            getVisitCareDetailedReductionContena().add(
                    getVisitCareDetailedReductionContainer(),
                    VRLayout.FLOW_RETURN);

            getVisitCareDetailedReductionContena().add(
                    getVisitCareDetailedReductionRadioContainer(),
                    VRLayout.FLOW);

            getVisitCareDetailedReductionContena().add(
                    getVisitCareDetailedStateRadioContainer(), VRLayout.FLOW);
        } else {
            super.addVisitCareDetailedReductionContena();
        }

    }
      protected void addVisitCareDetailedContentLeftCenter1() {
        String osName = System.getProperty("os.name");
        if ((osName != null) && (osName.indexOf("Mac") >= 0)) {
            //Mac�̏ꍇ�A�i�g�𒲐����ĉ�ʓ��Ɏ��߂�

            getVisitCareDetailedContentLeftCenter1().add(
                    getVisitCareDetailedNameContainer(), VRLayout.FLOW_RETURN);

            getVisitCareDetailedContentLeftCenter1().add(
                    getVisitCareDetailedSexContenaContainer(),
                    VRLayout.FLOW_INSETLINE);

            getVisitCareDetailedContentLeftCenter1().add(
                    getVisitCareDetailedBirthContainer(),
                    VRLayout.FLOW_INSETLINE_RETURN);

            getVisitCareDetailedContentLeftCenter1().add(
                    getVisitCareDetailedOfficialReasonContainer(),
                    VRLayout.FLOW_INSETLINE_RETURN);
        } else {
            super.addVisitCareDetailedContentLeftCenter1();
        }

    }
      
//      protected void addRealityDate() {
//        String osName = System.getProperty("os.name");
//        if ((osName != null) && (osName.indexOf("Mac") >= 0)) {
//            getRealityDate()
//                    .add(getInsuranceContena(), VRLayout.FLOW_INSETLINE);
//
//            getRealityDate().add(getPublicExpenseContena(),
//                    VRLayout.FLOW_INSETLINE_RETURN);
//
//            getRealityDate().add(getPublicExpense2Contena(),
//                    VRLayout.FLOW_INSETLINE_RETURN);
//        } else {
//            super.addRealityDate();
//        }
//    }
}
