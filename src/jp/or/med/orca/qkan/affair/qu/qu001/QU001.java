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
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACHashMapFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.ac.util.splash.ACSplash;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.component.table.VRSortableTableModel;
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
import jp.or.med.orca.qkan.affair.qc.qc005.QC005P01;
import jp.or.med.orca.qkan.affair.qc.qc005.QC005P02;
import jp.or.med.orca.qkan.affair.qc.qc006.QC006;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001;
import jp.or.med.orca.qkan.affair.qu.qu002.QU002;
import jp.or.med.orca.qkan.text.QkanPatientListDataTypeFormat;

/**
 * ���p�҈ꗗ(QU001)
 */
public class QU001 extends QU001Event {

	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QU001() {
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

		// �n��p�����[�^��ޔ�����B
		// this.nextAffair = NEXT_AFFAIR (���ɑJ�ڂ���Ɩ�ID)
		VRMap param = affair.getParameters();

		// �f�[�^�����݂��Ă��邩�`�F�b�N����B
		// NEXT_AFFAIR�̑ޔ�
		if (VRBindPathParser.has("NEXT_AFFAIR", param)) {
			setNextAffair(ACCastUtilities.toString(VRBindPathParser.get(
					"NEXT_AFFAIR", param)));
		}

		// �f�[�^�����݂��Ă��邩�`�F�b�N����B
		// PATIENT_ID�̑ޔ�
		if (VRBindPathParser.has("PATIENT_ID", param)) {
			setPatientId(ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", param)));
		}

		// �f�[�^�����݂��Ă��邩�`�F�b�N����B
		// TARGET_DATE�̑ޔ�
		if (VRBindPathParser.has("TARGET_DATE", param)) {
			setFindTargetDate((Date) VRBindPathParser.get("TARGET_DATE", param));
		}

		// �n��p�����[�^�̍폜
		param.clear();

		// ���������s���B
		initialize();

		// �e�[�u�����f�����`����B
		ACTableModelAdapter model = new ACTableModelAdapter();

		model.setColumns(new String[] {
				"SHOW_FLAG",
				"SHOW_FLAG",
				"REPORT",
				"FINISH_FLAG",
				"CHOISE",
				"PATIENT_CODE",
				"PATIENT_FAMILY_NAME+'�@'+PATIENT_FIRST_NAME",
				"PATIENT_FAMILY_KANA+'�@'+PATIENT_FIRST_KANA",
				"PATIENT_SEX",
				"PATIENT_BIRTHDAY",
				"PATIENT_ZIP_FIRST+'-'+PATIENT_ZIP_SECOND",
				"PATIENT_ADDRESS",
				"PATIENT_TEL_FIRST+'-'+PATIENT_TEL_SECOND+'-'+PATIENT_TEL_THIRD",
				"PATIENT_FAMILY_NAME", "PATIENT_FIRST_NAME",
				"PATIENT_FAMILY_KANA", "PATIENT_FIRST_KANA",
				"PATIENT_ZIP_FIRST", "PATIENT_ZIP_SECOND", "PATIENT_TEL_FIRST",
				"PATIENT_TEL_SECOND", "PATIENT_TEL_THIRD", "JOTAI_CODE",
				"INSURED_ID", "INSURE_VALID_START", "INSURE_VALID_END"
				// [ID:0000637][Shin Fujihara] 2011/03 add begin 2010�N�x�Ή�
				, "INSURER_ID"
		// [ID:0000637][Shin Fujihara] 2011/03 add begin 2010�N�x�Ή�
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

		/** 2007�N�x�Ή� */
		// �t�H�[�}�b�^�̐ݒ���s��
		getPatientReportColumn().setFormat(
				new ACHashMapFormat(new String[] { "",
						"jp/nichicom/ac/images/icon/pix16/btn_013.png" },
						new Integer[] { new Integer(0), new Integer(1), }));

		getPatientFinishFlagColumn().setFormat(
				new QkanPatientListDataTypeFormat(getNextAffair()));

		// �������s���B
		doFind();

	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}

		// �O��ʂɖ߂�B
		// �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}

		// �V�X�e�����I������B
		// �I����������Ȃ��true��Ԃ��B
		return true;
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void findActionPerformed(ActionEvent e) throws Exception {
		// �������s���B
		doFind();
	}

	/**
	 * �u�ڍ׉�ʂɑJ�ځv�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void detailActionPerformed(ActionEvent e) throws Exception {

		// PATIENT_ID���i�[����patientId���`����B
		int patientId;

		// �����̓`�F�b�N
		// ���̓`�F�b�N���s���B
		if (!checkValue()) {
			return;
		}

		// ��ʂ́u���p�҈ꗗ(patients)�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
		if (!getPatients().isSelected()) {
			// �I������Ă��Ȃ��ꍇ
			// �������Ȃ��B
			return;
		} else {
			// �I������Ă���ꍇ
			// �I������Ă��闘�p�҂́u���p��ID(PATIENT_ID)�v���擾����B
			patientId = ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", (VRMap) getPatients()
							.getSelectedModelRowValue()));

		}

		// ����ʂɑJ�ڂ���B
		transferNext(patientId);
	}

	/**
	 * �u�ڍ׉�ʂɑJ�ځv�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {
		// ������ʂɑJ��

		// ����ʂւ̓n��p�����[�^�i�[�p�Ƀ��R�[�h param�𐶐�����B
		VRMap param = new VRHashMap();

		// ����ʑJ�ڂ̂��߂̃p�����[�^ ACAffairInfo affair ���`����B
		ACAffairInfo affair = null;

		if ("QU002".equals(getNextAffair())) {
			// �uQU002�v�̏ꍇ

			// param�ɉ��L�p�����[�^��ݒ肷��B
			// KEY : PROCESS_MODE, VALUE : PROCESS_MODE_INSERT
			VRBindPathParser.set("PROCESS_MODE", param, new Integer(
					QkanConstants.PROCESS_MODE_INSERT));

			// ���L�p�����[�^�ɂ�affair�𐶐�����B
			affair = new ACAffairInfo(QU002.class.getName(), param);

		}

		// NEXT_AFFAIR����ʑJ�ڑO�Ƀt���[���ɑޔ����Ă����B
		ACFrame.getInstance().addNowAffairParameter("NEXT_AFFAIR",
				getNextAffair());

		// ���n�菈��
		// ����ʂɑJ�ڂ���B
		ACFrame.getInstance().next(affair);

	}

	/**
	 * �u�T�[�r�X�\��ɑJ�ځv�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
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
	protected void resultInsertActionPerformed(ActionEvent e) throws Exception {
		// ���T�[�r�X���тɑJ��

		// PATIENT_ID���i�[����patientId���`����B
		int patientId;

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

		// ���p�҂̗v�������`�F�b�N����B
		if (!checkInsureInfo(patientId)) {
			return;
		}

		// ����ʂɑJ�ڂ���B
		transferNext(patientId);

	}

	/**
	 * �u���p�ҍ폜�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void deleteActionPerformed(ActionEvent e) throws Exception {
		// ����ʂőI�����ꂽ���p�҂̍폜

		// �I������Ă��郌�R�[�h�̃��f���̃C���f�b�N�X���i�[����modelRow���`����B
		int modelRow;

		// �I������Ă��郌�R�[�h�̉�ʏ�̃C���f�b�N�X���i�[����sortedRow���`����B
		int sortedRow;

		// �����̓`�F�b�N
		// ��ʂ́u���p�҈ꗗ(patients)�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
		if (!getPatients().isSelected()) {
			// �I������Ă��Ȃ��ꍇ

			// �����𒆒f����B
			return;

		} else {
			// �I������Ă���ꍇ

			// �I���s�̃C���f�b�N�X(���f���ł͂Ȃ���ʏ�)���擾����B
			modelRow = getPatients().getSelectedModelRow();
			sortedRow = getPatients().getSelectedSortedRow();
		}

		// �������m�F
		// �폜�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_DELETE
		if (QkanMessageList.getInstance().WARNING_OF_DELETE("�I�𒆂̗��p�ҏ��") == ACMessageBox.RESULT_CANCEL) {
			// �u�L�����Z���v��I�������ꍇ(�폜���f)
			// �����𒆒f����B
			return;
		}

		try {

			// �g�����U�N�V�����J�n
			getDBManager().beginTransaction();

			// ���p�b�V�u�`�F�b�N
			// �p�b�V�u�^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();

			// �p�b�V�u�^�X�N��o�^����B
			getPassiveChecker().addPassiveUpdateTask(getPASSIVE_CHECK_KEY(),
					modelRow);

			// �p�b�V�u�`�F�b�N�����s����B
			if (!(getPassiveChecker().passiveCheck(getDBManager()))) {
				// �p�b�V�u�G���[������ꍇ

				// �p�b�V�u�G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
				QkanMessageList.getInstance()
						.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();

				// �g�����U�N�V��������
				getDBManager().rollbackTransaction();

				// �����𒆒f����B(�ُ�I��)
				return;
			}

			// �p�b�V�u�G���[���Ȃ��ꍇ
			// �����𑱍s����B
			// ���폜
			// �I���s�́u���p��ID(PATIENT_ID)�v���擾����B
			int patientId = ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", (VRMap) getPatientData().get(modelRow)));

			// SQL���擾�֐��ɓn�����R�[�h sqlParam�𐶐�����B
			VRMap sqlParam = new VRHashMap();

			// sqlParam�ɉ��L�̒l��ݒ肷��B
			// KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
			VRBindPathParser
					.set("PATIENT_ID", sqlParam, new Integer(patientId));

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

			// // ���������ʒm���b�Z�[�W��\������B�����b�Z�[�WID = DELETE_SUCCESSED
			// QkanMessageList.getInstance().DELETE_SUCCESSED();

		} catch (Exception ex) {
			// �G���[���������ꍇ
			// ���������[���o�b�N����B
			// �����𒆒f����B(�ُ�I��)
			getDBManager().rollbackTransaction();

			// ��ʃN���X�ɗ�O��Ԃ��B
			throw ex;
		}

	}

	/**
	 * �u�Z���I���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void patientsSelectionChanged(ListSelectionEvent e)
			throws Exception {

		// ��ʂ́u���p�҈ꗗ(patients)�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
		if (!getPatients().isSelected()) {
			// �I������Ă��Ȃ��ꍇ

			// �Ɩ��{�^���̏�Ԃ�ύX����B
			setState_UNSELECTED();

		} else {
			// �I������Ă���ꍇ
			// �Ɩ��{�^���̏�Ԃ�ύX����B
			setState_SELECTED();

		}
	}

	/**
	 * �u�_�u���N���b�N�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void patientsMouseClicked(MouseEvent e) throws Exception {

		// PATIENT_ID���i�[����patientId���`����B
		int patientId;

		// �����̓`�F�b�N
		// �@���̓`�F�b�N���s���B
		if (!checkValue()) {
			return;
		}

		// ��ʂ́u���p�҈ꗗ(patients)�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
		if (!getPatients().isSelected()) {
			// �I������Ă��Ȃ��ꍇ
			// �������Ȃ��B
			return;
		} else {
			// �I������Ă���ꍇ
			// �I������Ă��闘�p�҂́u���p��ID(PATIENT_ID)�v���擾����B
			patientId = ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", (VRMap) getPatients()
							.getSelectedModelRowValue()));
		}

		if ("QS001".equals(getNextAffair()) || "QR001".equals(getNextAffair())) {
			// �\��E���щ�ʂ֑J�ڂ���ꍇ
			// ���p�҂̗v�������`�F�b�N����B
			if (!checkInsureInfo(patientId)) {
				return;
			}
		}

		// ����ʂɑJ�ڂ���B
		transferNext(patientId);

	}

	/**
	 * �u���p�҈ꗗ����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void printActionPerformed(ActionEvent e) throws Exception {
		// �����p�҈ꗗ�̈��

		// ���O����
		// ����N���X�ɓn�����R�[�h printParam�𐶐�����B
		VRMap printParam = new VRHashMap();

		// ���n���p�����[�^�̎擾
		// ���p�҈ꗗ�f�[�^
		VRList printList = new VRArrayList();
		VRList sourceList = getPatientData();
		VRMap row;
		String providerId;

		VRSortableTableModel sorterModel;
		// �\�[�^�ł��邩�`�F�b�N����
		if (getPatients().getModel() instanceof VRSortableTableModel) {
			sorterModel = (VRSortableTableModel) getPatients().getModel();
			for (int i = 0; i < sourceList.getDataSize(); i++) {
				// �\�[�^�[�𗘗p���ă��f�������ʏ�̏��Ƀf�[�^�i�[���Ȃ���
				int rowIndex = sorterModel.getTranslateIndex(i);

				row = (VRMap) sourceList.getData(rowIndex);

				// ������x�����Ə����̎擾
				providerId = ACCastUtilities.toString(VRBindPathParser.get(
						"PROVIDER_ID", row));

				if (!(providerId == null || "".equals(providerId))) {
					// ���Ə������擾����B
					VRList providerList = (VRList) QkanCommon.getProviderInfo(
							getDBManager(), providerId);

					if (providerList.getDataSize() > 0) {
						// ���p�ҏ��ɋ�����x�����Ə�����������B
						VRBindPathParser
								.set("PROVIDER_NAME", row, VRBindPathParser
										.get("PROVIDER_NAME",
												(VRBindSource) providerList
														.getData(0)));
					}
				}

				printList.addData(row);
			}
		}

		// ���p�ҏ����AprintParam��KEY : PARAM��VALUE�Ƃ��Đݒ肷��B
		VRBindPathParser.set("PARAM", printParam, printList);

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
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();

		// ���N��
		VRHashMap param = new VRHashMap();
		param.setData("NEXT_AFFAIR", "QU002");
		// Date date = new Date();
		// param.setData("PATIENT_ID", new Integer(111));
		// param.setData("PATIENT_ID", date);
		ACFrame.debugStart(new ACAffairInfo(QU001.class.getName(), param));
		// ACFrame.debugStart(new ACAffairInfo(QU001.class.getName()));
	}

	/**
	 * �u�����������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void initialize() throws Exception {
		// ������������

		// ���E�B���h�E�^�C�g���E�Ɩ��{�^���o�[�̐ݒ�
		setAffairTitle(AFFAIR_ID, getNextAffair(), getButtons());

		// ��ʂ̏�����Ԃ�ݒ肷��BnextAffair�̒l�ɂ���āA�ݒ肪���򂷂�B

		if ("QU002".equals(getNextAffair())) {
			// �uQU002�v�̏ꍇ

			// �p�b�V�u�L�[�̒�`
			setPASSIVE_CHECK_KEY(new ACPassiveKey("PATIENT",
					new String[] { "PATIENT_ID" }, new Format[] { null },
					"LAST_TIME", "LAST_TIME"));

			// QU002�p�̐ݒ���s���B
			setState_INIT_PATIENT();

		} else if ("QS001".equals(getNextAffair())) {
			// �uQS001�v�̏ꍇ

			// QS001�p�̐ݒ���s���B
			setState_INIT_SERVICE_PLAN();

		} else if ("QR001".equals(getNextAffair())) {
			// �uQR001�v�̏ꍇ

			// QR001�p�̐ݒ���s���B
			setState_INIT_SERVICE_RESULT();

		} else if ("QC001".equals(getNextAffair())) {
			// �uQC001�v�̏ꍇ

			// QC001�p�̐ݒ���s���B
			setState_INIT_HOMONKANGO_PLAN();

			// [ID:0000667][Masahiko.Higuchi] 2012/12 add begin ����24�N4���̏����ݒ�Ή�
			// ���[�n�Ɩ��̂݋���
			getTargetDate()
					.setMinimumDate(ACCastUtilities.toDate("2006/04/01"));
			// [ID:0000667][Masahiko.Higuchi] 2012/12 add end

		} else if ("QC002".equals(getNextAffair())) {
			// �uQC002�v�̏ꍇ

			// QC002�p�̐ݒ���s���B
			setState_INIT_HOMONKANGO_RESULT();

			// [ID:0000667][Masahiko.Higuchi] 2012/12 add begin ����24�N4���̏����ݒ�Ή�
			// ���[�n�Ɩ��̂݋���
			getTargetDate()
					.setMinimumDate(ACCastUtilities.toDate("2006/04/01"));
			// [ID:0000667][Masahiko.Higuchi] 2012/12 add end

		} else if ("QC003".equals(getNextAffair())) {
			// �uQC003�v�̏ꍇ

			// QC003�p�̐ݒ���s���B
			setState_INIT_HOMONKANGO_JOHO_TEIKYOSHO();

			// [ID:0000667][Masahiko.Higuchi] 2012/12 add begin ����24�N4���̏����ݒ�Ή�
			// ���[�n�Ɩ��̂݋���
			getTargetDate()
					.setMinimumDate(ACCastUtilities.toDate("2006/04/01"));
			// [ID:0000667][Masahiko.Higuchi] 2012/12 add end

		} else if ("QC004".equals(getNextAffair())) {
			// �uQC004�v�̏ꍇ

			// QC004�p�̐ݒ���s���B
			setState_INIT_HOMONKANGO_KIROKUSHO();

			// [ID:0000667][Masahiko.Higuchi] 2012/12 add begin ����24�N4���̏����ݒ�Ή�
			// ���[�n�Ɩ��̂݋���
			getTargetDate()
					.setMinimumDate(ACCastUtilities.toDate("2006/04/01"));
			// [ID:0000667][Masahiko.Higuchi] 2012/12 add end

		// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add - begin ����×{�Ǘ��w�����ꗗ�ǉ�
		//} else if ("QC005".equals(getNextAffair())) {
		} else if ("QC005".equals(getNextAffair()) || "QC006".equals(getNextAffair())) {
		// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add - end   ����×{�Ǘ��w�����ꗗ�ǉ�
			
			// �uQC005�v�̏ꍇ

			// 2008/01/07 [Masahiko Higuchi] del - begin ����×{�Ǘ��w�����ꊇ���
			// QC005�p�̐ݒ���s���B
			// setState_INIT_KYOTAKU();
			// 2008/01/07 [Masahiko Higuchi] del - end
			// 2008/01/07 [Masahiko Higuchi] add - begin ����×{�Ǘ��w�����ꊇ���
			doInitializeQC005();
			// 2008/01/07 [Masahiko Higuchi] add - end

			// [ID:0000667][Masahiko.Higuchi] 2012/12 add begin ����24�N4���̏����ݒ�Ή�
			// ���[�n�Ɩ��̂݋���
			getTargetDate()
					.setMinimumDate(ACCastUtilities.toDate("2006/04/01"));
			// [ID:0000667][Masahiko.Higuchi] 2012/12 add end

        }

		// ���Ώ۔N���̐ݒ�
		// �V�X�e������A�u�V�X�e�����t�v���擾����B
		if (getFindTargetDate() == null) {
			// �n��p�����[�^�Ƃ��āATARGET_DATE���n����Ă��Ȃ��ꍇ

			Date sysDate = QkanSystemInformation.getInstance().getSystemDate();
			
			// [H27.4�����Ή�][Shinobu Hitaka] 2015/02/20 edit begin ����27�N4���̏����ݒ�Ή�
			if (("QS001".equals(getNextAffair()) || "QR001"
					.equals(getNextAffair()))
					&& (ACDateUtilities.compareOnDay(sysDate,
							QkanConstants.H2704) < 0)) {
				sysDate = QkanConstants.H2704;
			}
			// [H27.4�����Ή�][Shinobu Hitaka] 2015/02/20 edit end

			// [ID:0000667][Masahiko.Higuchi] 2012/04 edit begin ����27�N4���̏����ݒ�Ή�
			if (("QS001".equals(getNextAffair()) || "QR001"
					.equals(getNextAffair()))
					&& (ACDateUtilities.compareOnDay(sysDate,
							QkanConstants.H2404) < 0)) {
				sysDate = QkanConstants.H2404;
			}
			// [ID:0000667][Masahiko.Higuchi] 2012/04 edit end

			if (ACDateUtilities.compareOnDay(sysDate, QkanConstants.H1904) < 0) {
				// �V�X�e�����t������19�N4���ȑO�̓��t�̏ꍇ
				getTargetDate().setDate(QkanConstants.H1904);
			} else {
				// �V�X�e�����t������19�N4���ȍ~�̓��t�̏ꍇ
				// ��ʂ́u�Ώ۔N��(targetDate)�v�ɁA�擾�����V�X�e�����t��ݒ肷��B
				getTargetDate().setDate(sysDate);
			}

		} else {
			// �n��p�����[�^�Ƃ��āATARGET_DATE���n����Ă���ꍇ

			// �n���ꂽTARGET_DATE����ʂ́u�Ώ۔N��(targetDate)�v�ɐݒ肷��B
			getTargetDate().setDate(getFindTargetDate());

			// ��d�Ɏg�p����Ȃ��悤�폜����B
			setFindTargetDate(null);

		}
	}

	/**
	 * �u�����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFind() throws Exception {
		// ��DB���痘�p�҈ꗗ���擾�A��ʂɐݒ�

		// ����������
		// SQL���擾�֐��ɓn�����R�[�h sqlParam�𐶐�����B
		VRMap sqlParam = new VRHashMap();

		// ���������̎擾
		VRMap selectKey = new VRHashMap();

		getFindConditions().setSource(selectKey);
		getFindConditions().applySource();

		// �����p�҃R�[�h�̎擾
		String patientCode = ACCastUtilities.toString(selectKey
				.get("PATIENT_CODE"));

		// ��ʂ́u���p�҃R�[�h(patientCode)�v��Text���擾���A�댯�����̒u�����s���B
		patientCode = QkanCommon.toFindString(patientCode);

		if (patientCode.length() > 0) {
			// �擾���������񂪑��݂���ꍇ(�����񒷂�0���傫���ꍇ)

			// �擾�����������sqlParam�� KEY : PATIENT_CODE �� VALUE �Ƃ��Đݒ肷��B
			VRBindPathParser.set("PATIENT_CODE", sqlParam, patientCode);

		}

		// ���ӂ肪�Ȃ̎擾
		String patientKana = ACCastUtilities.toString(selectKey
				.get("PATIENT_KANA"));

		// ��ʂ́u�ӂ肪��(patientKana)�v��Text���擾���A�댯�����̒u�����s���B
		patientKana = QkanCommon.toFindString(patientKana);

		if (patientKana.length() > 0) {
			// �擾���������񂪑��݂���ꍇ(�����񒷂�0���傫���ꍇ)
			// �擾�����������sqlParam�� KEY : PATIENT_KANA �� VALUE �Ƃ��Đݒ肷��B
			VRBindPathParser.set("PATIENT_KANA", sqlParam, patientKana);

		}

		// �����N�����̎擾
		if (getBirthday().isValidDate()) {
			// ���݂�����t�����͂���Ă���ꍇ

			if (selectKey.get("PATIENT_BIRTHDAY") instanceof Date) {

				// ��ʂ́u���N����(birthday)�v�̒l���擾����B
				Date birthDay = (Date) selectKey.get("PATIENT_BIRTHDAY");

				// �擾�����l��sqlParam�� KEY : PATIENT_BIRTHDAY �� VALUE �Ƃ��Đݒ肷��B
				VRBindPathParser.set("PATIENT_BIRTHDAY", sqlParam, birthDay);

			}

		} else {
			// ���݂��Ȃ����t�����͂���Ă���ꍇ

			// �t�H�[�J�X�����Ă�B
			getBirthday().requestFocus();

			// �G���[���b�Z�[�W
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("���N������");

			return;

		}

		// ���u���ݗL���łȂ����p�҂��܂߂Č����v�t���O�̎擾
		// ��ʂ́u���ݗL���łȂ����p�҂��܂߂Č���(nowNotEnabledPatientIncludeFind)�v�̒l���擾����B
		if (!(selectKey.get("HIDE_FLAG") == null)) {

			int hideFlag = ACCastUtilities.toInt(selectKey.get("HIDE_FLAG"));

			if (hideFlag == 0) {
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

        // [2014�N�v�]][Shinobu Hitaka] 2014/12/02 edit begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
		// "QC006"�������ɒǉ�
		//
		// 2008/01/07 [Masahiko Higuchi] add - begin ����×{�Ǘ��w�����̈ꊇ���
		// if ("QC005".equals(getNextAffair())) {
	    if ("QC005".equals(getNextAffair()) || "QC006".equals(getNextAffair())) {
			// �Ɩ��Ǝ���������
			patientData = doFindQC005(patientData, sqlParam);
			if (patientData == null) {
				// �����O�`�F�b�N�ɂ��������ꍇ�͏����I��
				return;
			}
		}
		// 2008/01/07 [Masahiko Higuchi] add - end
		//
	    // [2014�N�v�]][Shinobu Hitaka] 2014/12/02 edit end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
		
		// patientData��ޔ�����B
		setPatientData(patientData);

		// ���n���p�����[�^�̎擾
		// patientData�̌��������[�v����B
		VRMap cur = getNinteiRireki();

		for (int i = 0; i < getPatientData().size(); i++) {
			VRMap row = (VRMap) getPatientData().get(i);

			Object id = row.get("PATIENT_ID");
			if (cur.containsKey(id)) {
				putNinteiRireki(row, (VRMap) cur.get(id));
				continue;
			}
		}

		/*
		 * �ߋ��o�[�W���� for (int i = 0; i < getPatientData().size(); i++) {
		 * 
		 * // PATIENT_ID�i�[�p�ϐ����`����B int patientId; // ���p�ҏ��i�[�pMap���`����B VRMap
		 * patientMap = new VRHashMap(); // �v����i�[�pList���`����B VRList
		 * patientInsureList;
		 * 
		 * // patientData��KEY : PATIENT_ID��VALUE���擾����(���p��ID)�B patientMap =
		 * (VRMap) getPatientData().get(i); patientId =
		 * ACCastUtilities.toInt(VRBindPathParser.get( "PATIENT_ID",
		 * patientMap));
		 * 
		 * // sqlParam�̐ݒ� // ���p��ID�ǉ� VRBindPathParser .set("PATIENT_ID",
		 * sqlParam, new Integer(patientId)); // ���ݓ��t�ǉ�
		 * VRBindPathParser.set("NOW_DATE", sqlParam, new Date());
		 * 
		 * // ���ݓ��t���_�̗v�������擾����B // SQL���̎擾 strSql =
		 * getSQL_GET_NINTEI_NOW(sqlParam);
		 * 
		 * // SQL���̎��s patientInsureList = getDBManager().executeQuery(strSql);
		 * 
		 * // ���ݓ��t���_�̗v�����0���̏ꍇ if (patientInsureList.size() == 0) {
		 * 
		 * // ���ݓ��t��薢���̗v�����̂������߂̏����擾����B // SQL���̎擾 strSql =
		 * getSQL_GET_NINTEI_FUTURE(sqlParam);
		 * 
		 * // SQL���̎��s patientInsureList = getDBManager().executeQuery(strSql);
		 * 
		 * if (patientInsureList.size() == 0) {
		 * 
		 * // ���ݓ��t���ߋ��̗v�����̂������߂̏����擾����B // SQL���̎擾 strSql =
		 * getSQL_GET_NINTEI_PAST(sqlParam);
		 * 
		 * // SQL���̎��s patientInsureList = getDBManager().executeQuery(strSql);
		 * 
		 * } }
		 * 
		 * // �擾�����v�����1���ȏ�̏ꍇ if (patientInsureList.size() > 0) {
		 * 
		 * // �v����񃌃R�[�h�����o���B VRMap map = (VRMap) patientInsureList.get(0);
		 * 
		 * // ���p�ҏ��Ɉȉ��̒l��ǉ�����B // ��ی��Ҕԍ� VRBindPathParser.set("INSURED_ID",
		 * patientMap, VRBindPathParser.get("INSURED_ID", map)); // �v���x
		 * VRBindPathParser.set("JOTAI_CODE", patientMap,
		 * VRBindPathParser.get("JOTAI_CODE", map)); // �L�����ԏI��
		 * VRBindPathParser.set("INSURE_VALID_END", patientMap,
		 * VRBindPathParser.get("INSURE_VALID_END", map)); // �L�����ԊJ�n
		 * VRBindPathParser.set("INSURE_VALID_START", patientMap,
		 * VRBindPathParser.get("INSURE_VALID_START", map));
		 * 
		 * // [ID:0000637][Shin Fujihara] 2011/03 add begin 2010�N�x�Ή� // �ی��Ҕԍ�
		 * VRBindPathParser.set("INSURER_ID", patientMap,
		 * VRBindPathParser.get("INSURER_ID", map)); // [ID:0000637][Shin
		 * Fujihara] 2011/03 add begin 2010�N�x�Ή� } }
		 */

		// ���擾�����f�[�^����ʂɓW�J
		getPatientTableModel().setAdaptee(patientData);

		// patientData�̌������`�F�b�N����B
		if (patientData.size() > 0) {

			// �ޔ��������p��ID���`�F�b�N����B
			if (getPatientId() == 0) {
				// ���p��ID���n����Ă��Ȃ������ꍇ

				// ��ʂ́u���p�҈ꗗ(patients)�v��1�s�ڂ�I������B
				getPatients().setSelectedSortedFirstRow();

			} else {
				// ���p��ID���n����Ă����ꍇ

				// �n���ꂽ���p��ID�������p�҂�I������B
				int index = ACCommon.getInstance().getMatchIndexFromValue(
						getPatientData(), "PATIENT_ID",
						new Integer(getPatientId()));

				if (index == -1) {

					// �Y�����闘�p�҂����Ȃ������ꍇ�A1�s�ڂ�I������B
					getPatients().setSelectedSortedFirstRow();

				} else {

					// �Y�����闘�p�҂������ꍇ�A�Y�����p�҂�I������B
					getPatients().setSelectedModelRow(index);
					getPatients().scrollSelectedToVisible();
				}

				// ��d�Ɏg�p����Ȃ��悤�ɍ폜����B
				setPatientId(0);

			}
		} else {
			// �Ɩ��{�^���̏�Ԃ�ύX����B
			setState_UNSELECTED();
		}

		// ���p�b�V�u�L�[�̍ēo�^
		// �p�b�V�u�L�[���N���A����B
		getPassiveChecker().clearReservedPassive();

		// �p�b�V�u�L�[��o�^����B
		getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
				getPatientData());

		// �X�e�[�^�X�o�[
		// setStatusText("");

		// �t�H�[�J�X
		if (getTargetDate().getParent().isVisible()) {
			getTargetDate().requestFocus();
		} else {
			getPatientCode().requestFocus();
		}

	}

	// �F�藚���f�[�^��ݒ肷��
	private void putNinteiRireki(VRMap row, VRMap riki) throws Exception {
		VRBindPathParser.set("INSURED_ID", row,
				VRBindPathParser.get("INSURED_ID", riki));
		VRBindPathParser.set("JOTAI_CODE", row,
				VRBindPathParser.get("JOTAI_CODE", riki));
		VRBindPathParser.set("INSURE_VALID_END", row,
				VRBindPathParser.get("INSURE_VALID_END", riki));
		VRBindPathParser.set("INSURE_VALID_START", row,
				VRBindPathParser.get("INSURE_VALID_START", riki));
		VRBindPathParser.set("INSURER_ID", row,
				VRBindPathParser.get("INSURER_ID", riki));
		VRBindPathParser.set("PROVIDER_ID", row,
				VRBindPathParser.get("PROVIDER_ID", riki));
	}

	// ���p�҂̔F�藚�����擾����
	private VRMap getNinteiRireki() throws Exception {

		Date now = QkanSystemInformation.getInstance().getSystemDate();

		VRList list = getDBManager().executeQuery(getSQL_GET_NINTEI_ALL(null));
		VRMap result = new VRHashMap();
		// PATIENT_ID

		for (int i = 0; i < list.size(); i++) {
			VRMap row = (VRMap) list.get(i);

			Object id = row.get("PATIENT_ID");
			// ���t1 < ���t2 �� 0��菬�����l
			// ���t1 > ���t2 �� 0���傫���l
			// ���t1 = ���t2 �� 0
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//			Date start = (Date) row.get("INSURE_VALID_START");
//			Date end = (Date) row.get("INSURE_VALID_END");
			Date start = (Date) row.get("SYSTEM_INSURE_VALID_START");
			Date end = (Date) row.get("SYSTEM_INSURE_VALID_END");
// 2014/12/17 [Yoichiro Kamei] mod - end
			// ���Ԕ͈͓�
			if ((ACDateUtilities.compareOnDay(start, now) <= 0)
					&& (ACDateUtilities.compareOnDay(end, now) >= 0)) {
				// ��ԓ�����Ȃ̂ŏ�ɏ㏑��
				row.put("marge_state", new Integer(0));
				result.put(id, row);
				continue;
			}

			// ����
			if (ACDateUtilities.compareOnDay(start, now) >= 0) {
				// �ݒ肳��Ă��Ȃ���΁A�Ƃ肠���������
				if (!result.containsKey(id)) {
					row.put("marge_state", new Integer(1));
					result.put(id, row);
					continue;
				}

				VRMap target = (VRMap) result.get(id);
				// ���Ɉ�Ԃ����̂������Ă����珈���L�����Z��
				int flag = ((Integer) target.get("marge_state")).intValue();
				if (flag == 0) {
					continue;

					// �ߋ����f�[�^�������Ă�����㏑�����ďI��
				} else if (flag == 2) {
					row.put("marge_state", new Integer(1));
					result.put(id, row);
					continue;
				}

				// �����Ă���f�[�^�Ƃǂ��炪�ߖ�������r
				// �����Ă���f�[�^��荡�̃f�[�^���������ꍇ�͐ݒ�
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//				Date fur = (Date) target.get("INSURE_VALID_START");
				Date fur = (Date) target.get("SYSTEM_INSURE_VALID_START");
// 2014/12/17 [Yoichiro Kamei] mod - end
				if (ACDateUtilities.compareOnDay(start, fur) < 0) {
					row.put("marge_state", new Integer(1));
					result.put(id, row);
				}
				continue;
			}

			// �ߋ�
			if (ACDateUtilities.compareOnDay(end, now) <= 0) {
				// �ݒ肳��Ă��Ȃ���΁A�Ƃ肠���������
				if (!result.containsKey(id)) {
					row.put("marge_state", new Integer(2));
					result.put(id, row);
					continue;
				}

				VRMap target = (VRMap) result.get(id);
				// ���Ɉ�Ԃ����̂▢���̂������Ă����珈���L�����Z��
				int flag = ((Integer) target.get("marge_state")).intValue();
				if (flag <= 1) {
					continue;
				}

				// �����Ă���f�[�^�Ƃǂ��炪���ɋ߂�����r
				// �����Ă���f�[�^��荡�̃f�[�^���������ꍇ�͐ݒ�
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//				Date pas = (Date) target.get("INSURE_VALID_END");
				Date pas = (Date) target.get("SYSTEM_INSURE_VALID_END");
// 2014/12/17 [Yoichiro Kamei] mod - end
				if (ACDateUtilities.compareOnDay(pas, end) < 0) {
					row.put("marge_state", new Integer(2));
					result.put(id, row);
				}
				continue;
			}

		}

		return result;
	}

	/**
	 * �f�[�^���蓮�������܂��B
	 * 
	 * @param targetList
	 * @param findParam
	 * @param keys
	 * @return
	 * @throws Exception
	 */
	public VRList doMultiFind(VRList targetList, VRMap findParam, String[] keys)
			throws Exception {
		// �s���Ȓl�������Ȃ̂ŏ����l�ŕԂ�
		if (targetList == null || targetList.isEmpty()) {
			return new VRArrayList();
		}
		boolean isFindKey = false;
		// �����L�[�̑��݂̗L��
		for (int i = 0; i < keys.length; i++) {
			if (findParam.containsKey(keys[i])) {
				// ���ݗL�̏ꍇ�̓��[�v���I��
				isFindKey = true;
				break;
			}
		}
		// �p�����[�^�[���s���������͌����L�[�͖�����
		if (findParam == null || !isFindKey) {
			// ���������ɕԂ�
			return targetList;
		}

		// ���Ə�����
		// ���x������
		for (int j = 0; j < keys.length; j++) {
			// �����L�[�̑��݂̗L��
			if (findParam.containsKey(keys[j])) {
				// �蓮����
				targetList = filterData(targetList, findParam, keys[j]);
			}
		}

		return targetList;
	}

	/**
	 * �����L�[�����ɑΏۂ̃f�[�^�W�����t�B���^�����O���܂��B
	 * 
	 * @param targetList
	 * @param findParam
	 * @param filterKey
	 * @return
	 */
	public VRList filterData(VRList targetList, VRMap findParam,
			String filterKey) throws Exception {
		VRMap editMap = new VRHashMap();
		VRList resultList = new VRArrayList();
		String convValue;
		// ���X�g�̐����[�v����
		for (int i = 0; i < targetList.size(); i++) {
			if (targetList.getData(i) instanceof VRMap) {
				// ��r�s�����o��
				editMap = (VRMap) targetList.getData(i);
				// ��r����l�����o��
				convValue = ACCastUtilities.toString(
						editMap.getData(filterKey), "");
				// ��r����
				if (convValue.equals(findParam.getData(filterKey))) {
					resultList.add(editMap);
				}
			}
		}

		return resultList;
	}

	/**
	 * �u��ʑJ�ڏ����v�Ɋւ��鏈�����s���܂��B
	 * 
	 * @param �ꗗ�e�[�u���őI������Ă��闘�p�҂̗��p��ID
	 * @throws Exception
	 *             ������O
	 */
	public void transferNext(int patientId) throws Exception {

		// �X�e�[�^�X�o�[�ɑI�����ꂽ���p�҂̖��O��\������B
		VRMap patientData = ACBindUtilities.getMatchRowFromValue(
				getPatientData(), "PATIENT_ID", new Integer(patientId));
		String familyName = ACCastUtilities.toString(VRBindPathParser.get(
				"PATIENT_FAMILY_NAME", patientData));
		String firstName = ACCastUtilities.toString(VRBindPathParser.get(
				"PATIENT_FIRST_NAME", patientData));
		setStatusText(QkanCommon.toFullName(familyName, firstName)
				+ "���񂪑I������܂����B");

		// ����ʂւ̓n��p�����[�^�i�[�p�Ƀ��R�[�h param�𐶐�����B
		VRMap param = new VRHashMap();

		// ���n��p�����[�^�̐ݒ�
		// ����ʑJ�ڂ̂��߂̃p�����[�^ NCAffairInfo affair ���`����B
		// affair(new ACAffair());
		ACAffairInfo affair = null;

		if ("QU002".equals(getNextAffair())) {
			// �uQU002�v�̏ꍇ

			// param�ɉ��L�p�����[�^��ݒ肷��B
			// KEY : PROCESS_MODE, VALUE : PROCESS_MODE_UPDATE
			// KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
			VRBindPathParser.set("PROCESS_MODE", param, new Integer(
					QkanConstants.PROCESS_MODE_UPDATE));
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));

			// ���L�p�����[�^�ɂ�affair�𐶐�����B
			// className : QU002.class.getName(), parameters : param
			affair = new ACAffairInfo(QU002.class.getName(), param);

		} else if ("QC001".equals(getNextAffair())) {
			// �uQC001�v�̏ꍇ

			// param�ɉ��L�p�����[�^��ݒ肷��B
			// KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
			// KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());

			// ���L�p�����[�^�ɂ�affair�𐶐�����B
			// className : QC001.class.getName(), parameters : param
			affair = new ACAffairInfo(QC001.class.getName(), param);

		} else if ("QC002".equals(getNextAffair())) {
			// �uQC002�v�̏ꍇ

			// param�ɉ��L�p�����[�^��ݒ肷��B
			// KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
			// KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());

			// ���L�p�����[�^�ɂ�affair�𐶐�����B
			// className : QC002.class.getName(), parameters : param
			affair = new ACAffairInfo(QC002.class.getName(), param);

		} else if ("QC003".equals(getNextAffair())) {
			// �uQC003�v�̏ꍇ

			// param�ɉ��L�p�����[�^��ݒ肷��B
			// KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
			// KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());

			// ���L�p�����[�^�ɂ�affair�𐶐�����B
			// className : QC003.class.getName(), parameters : param
			affair = new ACAffairInfo(QC003.class.getName(), param);

		} else if ("QC004".equals(getNextAffair())) {
			// �uQC004�v�̏ꍇ

			// param�ɉ��L�p�����[�^��ݒ肷��B
			// KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
			// KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());

			// ���L�p�����[�^�ɂ�affair�𐶐�����B
			// className : QC004.class.getName(), parameters : param
			affair = new ACAffairInfo(QC004.class.getName(), param);

		} else if ("QC005".equals(getNextAffair())) {
			// �uQC005�v�̏ꍇ

			// param�ɉ��L�p�����[�^��ݒ肷��B
			// KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
			// KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());

			// ���L�p�����[�^�ɂ�affair�𐶐�����B
			// className : QC005.class.getName(), parameters : param
			affair = new ACAffairInfo(QC005.class.getName(), param);

		} else if ("QC006".equals(getNextAffair())) {
			// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
			// �uQC006�v�̏ꍇ
			
			// param�ɉ��L�p�����[�^��ݒ肷��B
			// KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
			// KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());
			
			// ���L�p�����[�^�ɂ�affair�𐶐�����B
			// className : QC006.class.getName(), parameters : param
			affair = new ACAffairInfo(QC006.class.getName(), param);
			
			// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�

		} else if ("QS001".equals(getNextAffair())) {
			// �uQS001�v�̏ꍇ

			// param�ɉ��L�p�����[�^��ݒ肷��B
			// KEY : PATIENT_ID, VALUE : ���p��ID
			// KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
			// KEY : PROCESS_TYPE, VALUE : PROCESS_TYPE_PLAN
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());
			VRBindPathParser.set("PROCESS_TYPE", param, new Integer(
					QkanConstants.PROCESS_TYPE_PLAN));

			// ��L�p�����[�^�ɂ�affair�𐶐�����B
			// className : QS001.class.getName(), parameters : param
			affair = new ACAffairInfo(QS001.class.getName(), param, true);

		} else if ("QR001".equals(getNextAffair())) {
			// �uQR001�v�̏ꍇ

			// param�ɉ��L�p�����[�^��ݒ肷��B
			// KEY : PATIENT_ID, VALUE : (�擾�������p��ID)
			// KEY : TARGET_DATE, VALUE : (��ʁu�Ώ۔N��(targetDate)�v�̒l)
			// KEY : PROCESS_TYPE, VALUE : PROCESS_TYPE_RESULT
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());
			VRBindPathParser.set("PROCESS_TYPE", param, new Integer(
					QkanConstants.PROCESS_TYPE_RESULT));

			// ���L�p�����[�^�ɂ�affair�𐶐�����B
			// className : QR001.class.getName(), parameters : param
			affair = new ACAffairInfo(QS001.class.getName(), param, true);

		}

		// NEXT_AFFAIR, TARGET_DATE����ʑJ�ڑO�Ƀt���[���ɑޔ����Ă����B
		ACFrame.getInstance().addNowAffairParameter("NEXT_AFFAIR",
				getNextAffair());
		ACFrame.getInstance().addNowAffairParameter("TARGET_DATE",
				getTargetDate().getDate());
		ACFrame.getInstance().addNowAffairParameter("PATIENT_ID",
				new Integer(patientId));

		// ���J�ڏ���
		// ����ʂɑJ�ڂ���B
		ACFrame.getInstance().next(affair);

	}

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @return �G���[���Ȃ��ꍇtrue �G���[������ꍇfalse
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkValue() throws Exception {
		// �����̓`�F�b�N
		// ��ʂ́u�Ώ۔N��(targetDate)�v�ɒl�����͂���Ă��邩�ǂ����`�F�b�N����B

		if ("".equals(getTargetDate().getText())) {
			// ���͂���Ă��Ȃ��ꍇ
			// �t�H�[�J�X�����Ă�B
			getTargetDate().requestFocus();

			// ���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("�Ώ۔N��");

			return false;
		}

		if (!getTargetDate().isValidDate()) {
			// ���݂��Ȃ����t�����͂���Ă���ꍇ
			// �t�H�[�J�X�����Ă�B
			getTargetDate().requestFocus();

			// ���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_WRONG_DATE
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�Ώ۔N����");

			return false;

		}

		if (ACDateUtilities.compareOnDay(getTargetDate().getDate(),
				TARGET_DATE_20060401) < 0) {
			// ����18�N4���ȑO�̓��t�����͂���Ă���ꍇ
			// �t�H�[�J�X�����Ă�B
			getTargetDate().requestFocus();

			// ���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_WRONG_DATE
			QkanMessageList.getInstance()
					.QU001_ERROR_OF_DATE_BEFORE_LAW_CHANGE();

			return false;

		}

		return true;

	}

	/**
	 * �u���p�҂̗v�����`�F�b�N�v�Ɋւ��鏈�����s���܂��B
	 * 
	 * @param �`�F�b�N���s���Ώۗ��p�҂̗��p��ID
	 * @return �v���x�������Ă���ꍇtrue �����Ă��Ȃ��ꍇfalse
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkInsureInfo(int patientId) throws Exception {
		// �I�����ꂽ���p�҂̏��(��{���E�v���x���)���擾����B
		Date targetDate = getTargetDate().getDate();
		VRList list = QkanCommon.getPatientInsureInfoOnEndOfMonth(
				getDBManager(), targetDate, patientId);
		
		//[ID:0000749][Shin Fujihara] 2012/09 edit begin 2012�N�x�Ή� �{�ݏ��L�����Ԑ؂�̃`�F�b�N
//		if ((list.size() == 0)
//				|| !(QkanCommon.isFullDecisionPatientInsureInfo(getDBManager(),
//						targetDate, patientId))) {
//			// �v���x��񂪎擾�ł��Ȃ������ꍇ
//			// �������͐\�����̗v����񂪑��݂���ꍇ
//
//			// �������s�m�F���b�Z�[�W��\������B�����b�Z�[�WID = QU001_HAS_NO_YOKAIGODO
//			if (QkanMessageList.getInstance().QU001_HAS_NO_YOKAIGODO() == ACMessageBox.RESULT_CANCEL) {
//				// �L�����Z���I����(�������f��)
//
//				// �����𒆒f����B
//				return false;
//
//			}
//		}
		
		
		int msgFlag = 0;
		int msgResult = ACMessageBox.RESULT_OK;
		
		// �v���x�̗L�����Ԑ؂�`�F�b�N
		if ((list.size() == 0) || !(QkanCommon.isFullDecisionPatientInsureInfo(getDBManager(), targetDate, patientId))) {
			// �v���x��񂪎擾�ł��Ȃ������ꍇ
			// �������͐\�����̗v����񂪑��݂���ꍇ
			msgFlag += 1;
		}
		
		// �{�ݏ��̗L�����Ԑ؂�`�F�b�N
		VRMap sqlParam = new VRHashMap();
		VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities.toString(patientId));
		list = getDBManager().executeQuery(getSQL_GET_SHISETSU_HISTORY_ALL(sqlParam));
		
		if (list.size() > 0) {
			
			msgFlag += 2;
			
			for (int i = 0; i < list.size(); i++) {
				VRMap row = (VRMap)list.get(i);
				
				Date validStart = ACCastUtilities.toDate(row.get("SHISETSU_VALID_START"), null);
				Date validEnd = ACCastUtilities.toDate(row.get("SHISETSU_VALID_END"), null);
				
				if ((validStart == null) || (validEnd == null)) {
					continue;
				}
				
				int diff = ACDateUtilities.getDuplicateTermCheck(validStart, validEnd, targetDate, targetDate);
				
				//�u�d�Ȃ�Ȃ��v�ȊO�̌��ʂł���ΗL���f�[�^����
				if (diff != ACDateUtilities.DUPLICATE_NONE) {
					msgFlag -= 2;
					break;
				}
			}
		}
		
		// [H27.4�����Ή�][Shinobu Hitaka] 2015/3/12 add - begin
		// ������̗L�����Ԑ؂�`�F�b�N
		VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities.toString(patientId));
		VRBindPathParser.set("TARGET_DATE_START", sqlParam, ACDateUtilities.addMonth(targetDate, -1));
		VRBindPathParser.set("TARGET_DATE_END", sqlParam, ACDateUtilities.toLastDayOfMonth(targetDate));
		list = getDBManager().executeQuery(getSQL_GET_PATIENT_KOHI(sqlParam));
		if (list.size() > 0) {
			msgFlag += 4;
		}
		// [H27.4�����Ή�][Shinobu Hitaka] 2015/3/12 add - begin
		
		switch(msgFlag) {
		case 0: //�G���[�Ȃ�
			return true;
			
		case 1: //�v���x���Ԑ؂�
			msgResult = QkanMessageList.getInstance().QU001_HAS_NO_YOKAIGODO();
			break;
			
		case 2: //�{�ݏ����Ԑ؂�
			msgResult = QkanMessageList.getInstance().QU001_HAS_NO_SHISETSU();
			break;
			
		case 3: //�v���x���Ԑ؂�A���{�ݏ����Ԑ؂�
			msgResult = QkanMessageList.getInstance().QU001_HAS_NO_YOKAIGODO_AND_SHISETSU();
			break;
			
		case 4: //��������Ԑ؂� [H27.4�����Ή�][Shinobu Hitaka] 2015/3/12 add
			msgResult = QkanMessageList.getInstance().QU001_HAS_NO_KOHI();
			break;
			
		case 5: //��������Ԑ؂�A���v���x���Ԑ؂� [H27.4�����Ή�][Shinobu Hitaka] 2015/3/12 add
			msgResult = QkanMessageList.getInstance().QU001_HAS_NO_YOKAIGODO_AND_KOHI();
			break;
			
		case 6: //��������Ԑ؂�A���{�ݏ����Ԑ؂� [H27.4�����Ή�][Shinobu Hitaka] 2015/3/12 add
			msgResult = QkanMessageList.getInstance().QU001_HAS_NO_SHISETSU_AND_KOHI();
			break;
			
		case 7: //��������Ԑ؂�A���v���x���Ԑ؂�A���{�ݏ����Ԑ؂� [H27.4�����Ή�][Shinobu Hitaka] 2015/3/12 add
			msgResult = QkanMessageList.getInstance().QU001_HAS_NO_YOKAIGODO_AND_SHISETSU_AND_KOHI();
			break;
		}
		
		//�L�����Z���������́A�������f
		if (msgResult == ACMessageBox.RESULT_CANCEL) {
			return false;
		}
		
		//[ID:0000749][Shin Fujihara] 2012/09 edit end 2012�N�x�Ή� �{�ݏ��L�����Ԑ؂�̃`�F�b�N

		return true;

	}

	public Component getFirstFocusComponent() {

		if (getTargetDate().getParent().isVisible()) {
			return getTargetDate();
		} else {
			return getPatientCode();
		}

	}

	/**
	 * ����������s���܂��B
	 * 
	 * @author Masahiko Higuchi
	 * @since version 5.4.1
	 * 
	 */
	protected void printReportActionPerformed(ActionEvent e) throws Exception {
		
		// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 edit begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
	    //if ("QC005".equals(getNextAffair())) {
		if ("QC005".equals(getNextAffair()) || "QC006".equals(getNextAffair())) {
		// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 edit end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
			
			// �e�[�u�����f�[�^���擾
			VRList patientList = (VRList) getPatientTableModel().getAdaptee();
			// ����O�`�F�b�N
			int result = checkPrintData(patientList);
			// ����Ώۃf�[�^�i�[�v
			VRList printData = new VRArrayList();
			ACSplash splash = null;
			
			// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 add begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
			// ����Ώۂ��u����ς��܂߂Ȃ��v�܂��́u�S�āv�����m�F����
			int printMode = 0;
			if (result == PRINT_NORMAL || result == PRINT_EMPTY_AND_TARGET || result == PRINT_NO_SELECT){
				int msgID = QkanMessageList.getInstance().QU001_WARNING_OF_PRINT_MODE();
				if (msgID == ACMessageBox.RESULT_CANCEL) {
					return;
				} else if (msgID == ACMessageBox.RESULT_YES) {
					printMode = 0;
				} else {
					printMode = 1;
				}
			}
			// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 add end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
			
			switch (result) {
			case PRINT_NORMAL: // ����
			case PRINT_EMPTY_AND_TARGET: // �f�[�^�����i������s�j
				try {
					// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 add begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
					boolean isPrint = false;
					// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 add end
					
					// �X�v���b�V���̐���
					splash = (ACSplash) ACFrame.getInstance()
							.getFrameEventProcesser()
							.createSplash("����×{�Ǘ��w�������");
					for (int i = 0; i < patientList.size(); i++) {
						VRMap editMap = (VRMap) patientList.getData(i);
						// �I��L
						if (new Boolean(true).equals(VRBindPathParser.get(
								"CHOISE", editMap))) {
							// ����×{�Ǘ��w���f�[�^
							if (VRBindPathParser.has("TARGET_DATE", editMap)) {
								
								// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 edit begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
								// �������ɕێ���������×{�Ǘ��w������藘�p�҂ƈ���������ōi�荞�݈������
								//--del begin
								// �������ɕێ���������×{�Ǘ��w������藘�p�҂ōi�荞�ݑS�Ĉ������
								//printData.add(editMap);
								//--del end
								//--add begin
								//����m��t���O��ێ�����
								int finishFlag = ACCastUtilities.toInt(editMap.getData("FINISH_FLAG"),0);
								//�����̋���×{�Ǘ��w�������擾����
								VRList kyotakuData = doFindPrintDataQC006(editMap, printMode);
								for (int k = 0; k < kyotakuData.size(); k++) {
									VRMap kyotakuMap = new VRHashMap();
									kyotakuMap = (VRMap) kyotakuData.get(k);
									editMap.putAll(kyotakuMap);
									printData.add(QkanValidServiceCommon.deepCopyVRMap(editMap));
									
									// ����Ώۂ���
									isPrint = true;
								}
								//����m��t���O�����ɖ߂�
								VRBindPathParser.set("FINISH_FLAG", editMap, finishFlag);
								//--add end
								// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 edit end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
							}
						}
					}
					// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 add begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
					// ����Ώۂ����݂��Ȃ��ꍇ
					if (!isPrint) {
						QkanMessageList.getInstance()
								.QU001_ERROR_OF_NO_PRINT_DATA("����×{�Ǘ��w����");
						return;
					}
					// [2014�N�v�]][Shinobu Hitaka] 2015/01/05 add end 
					// �������
					if (!doPrintQC005(printData)) {
						// ������s��
						QkanMessageList.getInstance().ERROR_OF_PRINT();
						return;
					}
				} finally {
					// �X�v���b�V�����I������B
					if (splash != null) {
						splash.close();
						splash = null;
					}
				}
				break;
			case PRINT_NO_SELECT: // �f�[�^�I�𖳂��i���s�j
				try {
					boolean isPrint = false;
					splash = (ACSplash) ACFrame.getInstance()
							.getFrameEventProcesser()
							.createSplash("����×{�Ǘ��w�������");
					for (int i = 0; i < patientList.size(); i++) {
						VRMap editMap = (VRMap) patientList.getData(i);
						// ����×{�Ǘ��w���f�[�^
						if (VRBindPathParser.has("TARGET_DATE", editMap)) {
							// �I������ɐݒ肷��B
							VRBindPathParser.set("CHOISE", editMap,
									new Boolean(true));
							
							// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 edit begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
							// �������ɕێ���������×{�Ǘ��w������藘�p�҂ƈ���������ōi�荞�݈������
							//--del begin
							// �������ɕێ���������×{�Ǘ��w������藘�p�҂ōi�荞�ݑS�Ĉ������
							//printData.add(editMap);
							//--del end
							//--add begin
							//����m��t���O��ێ�����
							int finishFlag = ACCastUtilities.toInt(editMap.getData("FINISH_FLAG"),0);
							//�����̋���×{�Ǘ��w�������擾����
							VRList kyotakuData = doFindPrintDataQC006(editMap, printMode);
							for (int k = 0; k < kyotakuData.size(); k++) {
								VRMap kyotakuMap = new VRHashMap();
								kyotakuMap = (VRMap) kyotakuData.get(k);
								editMap.putAll(kyotakuMap);
								printData.add(QkanValidServiceCommon.deepCopyVRMap(editMap));

								// ����Ώۂ���
								isPrint = true;
							}
							//����m��t���O�����ɖ߂�
							VRBindPathParser.set("FINISH_FLAG", editMap, finishFlag);
							//--add end
							//--del begin
							// �Œ�ł�1���͈���f�[�^������B
							//isPrint = true;
							//--del end
							// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 edit end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
						}
					}
					// ����Ώۂ����݂��Ȃ��ꍇ
					if (!isPrint) {
						QkanMessageList.getInstance()
								.QU001_ERROR_OF_NO_PRINT_DATA("����×{�Ǘ��w����");
						return;
					}
					// �������
					if (!doPrintQC005(printData)) {
						// ������s��
						QkanMessageList.getInstance().ERROR_OF_PRINT();
						return;
					}
					// �e�[�u���ĕ`��
					getPatients().repaint();
				} finally {
					// �X�v���b�V�����I������B
					if (splash != null) {
						splash.close();
						splash = null;
					}
				}
				break;
			case PRINT_ERROR: // �G���[�܂��̓L�����Z��
				// �����I��
				return;
			}
			// ����������m�肷��ꍇ
			if (QkanMessageList.getInstance().QP001_PRINT_COMMIT() == ACMessageBox.RESULT_YES) {
				// �g�����U�N�V�����̊J�n
				getDBManager().beginTransaction();
				try {
					// �e�[�u���̌������[�v����
					for (int i = 0; i < patientList.size(); i++) {
						VRMap updateMap = (VRMap) patientList.get(i);
						// ����Ώۂł���ꍇ
						if (new Boolean(true).equals(updateMap
								.getData("CHOISE"))
								&& new Integer(1).equals(updateMap
										.getData("REPORT"))) {
							VRMap updateParam = new VRHashMap();
							// ����ς݃R�[�h
							int printedCode = QkanPatientListDataTypeFormat
									.getPrintedCode(getNextAffair(),
											updateMap.getData("FINISH_FLAG"));
							// �e�[�u���ɂ��f�[�^�𔽉f����
							updateMap.setData("FINISH_FLAG",
									ACCastUtilities.toInteger(printedCode));
							// �p�����[�^�[�ݒ�
							updateParam.setData("FINISH_FLAG",
									ACCastUtilities.toInteger(printedCode));
							updateParam.setData("PATIENT_ID",
									updateMap.getData("PATIENT_ID"));
							updateParam.setData("TARGET_DATE",
									updateMap.getData("TARGET_DATE"));
							// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
							updateParam.setData("TARGET_DATE_START",
									ACDateUtilities.toFirstDayOfMonth(ACCastUtilities.toDate(updateMap.getData("TARGET_DATE"))));
							updateParam.setData("TARGET_DATE_END",
									ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(updateMap.getData("TARGET_DATE"))));
							setFinishFlagQC006(updateMap.getData("PATIENT_ID"));
							// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
							// �X�V����
							getDBManager()
									.executeUpdate(
											getSQL_UPDATE_KYOTAKU_RYOYO_FINISH_FLAG(updateParam));
						}
					}

					// �f�[�^���R�~�b�g����B
					getDBManager().commitTransaction();

				} catch (Exception sqlExp) {
					// ���[���o�b�N����B
					getDBManager().rollbackTransaction();
				}
			}
			// �e�[�u���̍ĕ`�揈��
			getPatients().repaint();
		}
	}

	/**
	 * ���Ə��R���{�I��������
	 * 
	 * @since version 5.4.1
	 * @author Masahiko Higuchi
	 */
	protected void providerNameActionPerformed(ActionEvent e) throws Exception {
		// Map�𐶐�
		VRMap comboItemMap = new VRHashMap();
		// �󔒑I���ɑΉ�
		if (getProviderName().getSelectedModelItem() instanceof VRMap) {
			// ���ݑI�𒆂̃R���{���烌�R�[�h���擾
			comboItemMap = (VRMap) getProviderName().getSelectedModelItem();

			if (comboItemMap != null) {
				// ���x���������擾
				VRList senmoninList = getDBManager().executeQuery(
						getSQL_GET_CARE_MANAGER(comboItemMap));

				if (senmoninList != null && senmoninList.size() > 0) {
					for (int i = 0; i < senmoninList.size(); i++) {
						VRMap map = new VRHashMap();
						map = (VRMap) senmoninList.getData(i);
						// �����̖��O���擾����������������B
						map.setData("STAFF_NAME", QkanCommon.toFullName(
								ACCastUtilities.toString(map
										.getData("STAFF_FAMILY_NAME")),
								ACCastUtilities.toString(map
										.getData("STAFF_FIRST_NAME"))));
					}
				}
				// �o�C���h�p�X��ݒ�
				comboItemMap.setData("SENMONIN", senmoninList);
				// ��ʂɓW�J
				getSenmonin().setModelSource(comboItemMap);
				getSenmonin().bindModelSource();
			}
		} else {
			// ���I�����͋󔒂Ŋi�[����
			VRList blankList = new VRArrayList();
			comboItemMap.setData("SENMONIN", blankList);
			getSenmonin().setModelSource(comboItemMap);
			getSenmonin().bindModelSource();
		}
	}

	/**
	 * ����×{�Ǘ��w���̈ꗗ����������
	 * 
	 * @since version 5.4.1
	 * @author Masahiko Higuchi
	 */
	public void doInitializeQC005() throws Exception {
		// QC005�p�̐ݒ���s���B
		setState_INIT_KYOTAKU();
		// ���Ə����̎擾
		VRList providerList = QkanCommon.getProviderInfo(getDBManager());
		// ���Ə�����ݒ�
		VRMap comboItemMap = new VRHashMap();
		comboItemMap.setData("PROVIDER_NAMES", providerList);
		// ���f���ݒ�
		getProviderFindContents().setModelSource(comboItemMap);
		// ���f�����f
		getProviderFindContents().bindModelSource();
	}

	/**
	 * ����×{�Ǘ��w���̈ꗗ��������
	 * 
	 * @since version 5.4.1
	 * @author Masahiko Higuchi
	 */
	public VRList doFindQC005(VRList patientData, VRMap sqlParam)
			throws Exception {
		// �Ώ۔N��
		if (getTargetDate().isValidDate()) {
			// ��ʂ́u�Ώ۔N���v�̒l���擾����B
			Date targetDate = getTargetDate().getDate();
			// �擾�����l��sqlParam�� KEY : DATE_START �� VALUE �Ƃ��Đݒ肷��B
			VRBindPathParser.set("DATE_START", sqlParam,
					ACDateUtilities.toFirstDayOfMonth(targetDate));
			// �擾�����l��sqlParam�� KEY : DATE_END �� VALUE �Ƃ��Đݒ肷��B
			VRBindPathParser.set("DATE_END", sqlParam,
					ACDateUtilities.toLastDayOfMonth(targetDate));
			// ���ڂ��I������Ă���ꍇ
			if (getProviderName().getSelectedModelItem() instanceof VRMap) {
				VRMap providerMap = (VRMap) getProviderName()
						.getSelectedModelItem();
				String providerName = ACCastUtilities.toString(VRBindPathParser
						.get("PROVIDER_NAME", providerMap));
				VRBindPathParser.set("PROVIDER_NAME", sqlParam, providerName);
			}
			// ���ڂ��I������Ă���ꍇ
			if (getSenmonin().getSelectedModelItem() instanceof VRMap) {
				VRMap senmoninMap = (VRMap) getSenmonin()
						.getSelectedModelItem();
				String senmoninName = ACCastUtilities.toString(VRBindPathParser
						.get("STAFF_NAME", senmoninMap));
				VRBindPathParser.set("SENMONIN", sqlParam, senmoninName);
			}
			// ����×{�Ǘ��f�[�^�擾�pSQL
			String strKyotakuSql = getSQL_GET_KYOTAKU_RYOYO_PATIENT(sqlParam);
			// �i�[�p�f�[�^�Q
			VRList kyotakuData = new VRArrayList();
			kyotakuData = getDBManager().executeQuery(strKyotakuSql);
			
			// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
			setKyotakuData(kyotakuData);
			// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
			
			// �f�[�^�����[�v����
			for (int j = 0; j < patientData.size(); j++) {
				VRMap patientMap = new VRHashMap();
				patientMap = (VRMap) patientData.get(j);
				// ���p�҂̐����[�v����
				for (int k = 0; k < kyotakuData.size(); k++) {
					VRMap kyotakuMap = new VRHashMap();
					kyotakuMap = (VRMap) kyotakuData.get(k);
					// ����×{�Ǘ��w���̃f�[�^������ꍇ�͗L���ɂ���B
					if (VRBindPathParser.get("TARGET_DATE", kyotakuMap) != null
							&& patientMap.getData("PATIENT_ID").equals(
									kyotakuMap.getData("PATIENT_ID"))) {
						// �I��L
						patientMap.setData("REPORT", new Integer(1));
						
						// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 del begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
						// �@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�����Ԃ́A��������̂ōŌ�ɐݒ肷��
						// ������
						//patientMap.setData(
						//		"FINISH_FLAG",
						//		ACCastUtilities.toInteger(
						//				kyotakuMap.getData("FINISH_FLAG"), 0));
						// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 del end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
						
						// �I���`�F�b�N�̃t���O�������Ă��Ȃ��ꍇ
						if (!patientMap.containsKey("CHOISE")) {
							patientMap.setData("CHOISE", new Boolean(false));
						}
						// �S�Ă̒��[�f�[�^���������Ă���
						patientMap.putAll(kyotakuMap);
						// ��v�����ꍇ�͎��̑Ώێ҂�
						
						// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
						//-- �S�Ă̈󎚍ςȂ�ON�A����ȊO��OFF�Ƃ���
						patientMap.setData("FINISH_FLAG", getFinishFlagQC006(kyotakuMap));
						// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
						
						break;
					} else {
						// ���[�����I���̏ꍇ�̂�
						if (!patientMap.containsKey("CHOISE")) {
							patientMap.setData("CHOISE", new Boolean(false));
							patientMap.setData("REPORT", new Integer(0));
						}
					}
				}
			}
			// �蓮��������
			String[] keys = { "PROVIDER_NAME", "SENMONIN" };
			// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
			//patientData = doMultiFind(patientData, sqlParam, keys);
			patientData = doMultiFindQC006(patientData, sqlParam, keys);
			// [2014�N�v�]][Shinobu Hitaka] 2014/12/02 edit end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
			
			return patientData;

		} else {
			// �G���[���b�Z�[�W
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�Ώ۔N����");
			// �t�H�[�J�X�𓖂Ă�
			getTargetDate().requestFocus();

			return null;

		}
	}

	/**
	 * ����×{�Ǘ��w�����̈ꊇ�������
	 * 
	 * @author Masahiko Higuchi
	 * @since version 5.4.1
	 */
	public boolean doPrintQC005(VRList printData) throws Exception {

		QC005P01 pageCreater1 = new QC005P01();
		QC005P02 pageCreater2 = new QC005P02();
		ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
		
		// ����Ώۂ��Ȃ���΃G���[ 2015/01/04 add Hitaka
		if (printData.size() == 0) {
			return false;
		}
		
		// ����J�n
		writer.beginPrintEdit();

		for (int i = 0; i < printData.size(); i++) {
			VRMap printParam = parseQC005PrintData((VRMap) printData.getData(i));
			// 1����
			if (!pageCreater1.doPrint(writer, printParam)) {
				// ���炩�̃G���[�����������ꍇ
				return false;
			}
			// 2����
			if (!pageCreater2.doPrint(writer, printParam)) {
				return false;
			}
		}
		// ����I��
		writer.endPrintEdit();
		// ���[�̐���
		ACChotarouXMLUtilities.openPDF(writer);

		return true;
	}

	/**
	 * ����Ώۂ̃f�[�^���`�F�b�N���܂��B
	 * 
	 * @return 0:���� 1:�f�[�^�I�𖳂�(���s) 2:����ΏہE�ΏۊO�f�[�^�̍����f�[�^(���s) 99:�G���[(�����L�����Z���j
	 * @since version 5.4.1
	 * @author Masahiko Higuchi
	 * 
	 */
	public int checkPrintData(VRList patientData) throws Exception {
		// ���p�ҏ����ꊇ�擾
		boolean isPrintData = false; // ����Ώۃf�[�^���I������Ă��邩
		boolean isEmptyDataSelect = false; // ����ΏۊO�f�[�^��I�����Ă��邩
		boolean isPrintDataToAllPatient = false; // ����\�ȃf�[�^�͂��邩�i�S���p�ҁj

		for (int i = 0; i < patientData.size(); i++) {
			VRMap editMap = (VRMap) patientData.getData(i);
			// �I����TRUE�̏ꍇ
			if (new Boolean(true).equals(VRBindPathParser
					.get("CHOISE", editMap))) {
				// ����×{�Ǘ��w���̃f�[�^�����݂��Ă��邩
				if (VRBindPathParser.has("TARGET_DATE", editMap)) {
					isPrintData = true;
					isPrintDataToAllPatient = true;
				} else {
					// �ΏۊO�f�[�^�I��L
					isEmptyDataSelect = true;
				}
				// �����ύX�ς݂̏ꍇ�̓��[�v�I��
				if (isPrintData && isEmptyDataSelect) {
					break;
				}
			} else {
				// ����×{�Ǘ��w���̃f�[�^�����݂��Ă��邩
				if (VRBindPathParser.has("TARGET_DATE", editMap)) {
					isPrintDataToAllPatient = true;
				}
			}
		}
		// �S���p�Ƀf�[�^�����݂��Ȃ�
		if (!isPrintDataToAllPatient) {
			QkanMessageList.getInstance().QU001_ERROR_OF_NO_PRINT_DATA(
					"����×{�Ǘ��w����");
			return PRINT_ERROR;
		}
		// ����Ώۃf�[�^�Ȃ� And �ΏۊO�f�[�^�I������
		// �ΏۊO�������I������Ă���
		if (!isPrintData && isEmptyDataSelect) {
			QkanMessageList.getInstance().QU001_ERROR_OF_NO_PRINT_DATA(
					"����×{�Ǘ��w����");
			return PRINT_ERROR;
		}
		// ����Ώۃf�[�^�Ȃ� And �ΏۊO�f�[�^�I���Ȃ�
		// �S���I������Ă��Ȃ�
		if (!isPrintData && !isEmptyDataSelect) {
			if (QkanMessageList.getInstance()
					.QU001_WARNING_OF_PRINT_TARGET_NO_SELECT("����×{�Ǘ��w����") == ACMessageBox.RESULT_OK) {
				// ���s
				return PRINT_NO_SELECT;
			} else {
				// �L�����Z��
				return PRINT_ERROR;
			}
		}
		// ����Ώۃf�[�^���� And �ΏۊO�f�[�^����
		// ����E�ُ퍬��
		if (isPrintData && isEmptyDataSelect) {
			if (QkanMessageList.getInstance()
					.QU001_WARNING_OF_EMPTY_DATA_REPORT_MIXED("����×{�Ǘ��w����") == ACMessageBox.RESULT_OK) {
				// ���s
				return PRINT_EMPTY_AND_TARGET;
			} else {
				// �L�����Z��
				return PRINT_ERROR;
			}
		}
		// ����
		return PRINT_NORMAL;
	}

	/**
	 * ���[����p�̃f�[�^�ϊ��������s���܂��B
	 * 
	 * @param ���[�f�[�^
	 * @return �ϊ���̃f�[�^�i1���p�Ғ��[�f�[�^�j
	 * @since version 5.4.1
	 * @author Masahiko Higuchi
	 * 
	 */
	public VRMap parseQC005PrintData(VRMap printParam) throws Exception {
		VRMap parseParam = new VRHashMap();

		parseParam = (VRMap) printParam.clone();

		String patientName = QkanCommon.toFullName(
				VRBindPathParser.get("PATIENT_FAMILY_NAME", printParam),
				VRBindPathParser.get("PATIENT_FIRST_NAME", printParam));
		// ���p�Җ�
		VRBindPathParser.set("PATIENT_NAME", parseParam, patientName);
		// �ϊ������p��KEY�Q
		String convKeys[] = { "VISIT_THIS_MONTH_NO1", "VISIT_THIS_MONTH_NO2",
				"VISIT_THIS_MONTH_NO3", "VISIT_THIS_MONTH_NO4",
				"VISIT_THIS_MONTH_NO5", "VISIT_THIS_MONTH_NO6",
				"VISIT_NEXT_MONTH_NO1", "VISIT_NEXT_MONTH_NO2",
				"VISIT_NEXT_MONTH_NO3", "VISIT_NEXT_MONTH_NO4",
				"VISIT_NEXT_MONTH_NO5", "VISIT_NEXT_MONTH_NO6" };
		// �ϊ��Ώۂ̃L�[��A���ϊ�����
		for (int i = 0; i < convKeys.length; i++) {
			int dayValue = 0;
			String key = convKeys[i];
			// null�̏ꍇ�͋󔒂ɕϊ�����
			if (ACTextUtilities.isNullText(VRBindPathParser
					.get(key, printParam))) {
				VRBindPathParser.set(key, parseParam, "");
				// ���̑Ώۏ�����
				continue;
			}
			// null�ȊO�̏ꍇ�͓��ŕϊ�
			dayValue = ACDateUtilities.getDayOfMonth(ACCastUtilities
					.toDate(VRBindPathParser.get(key, printParam)));
			// �f�[�^���i�[
			VRBindPathParser.set(key, parseParam,
					ACCastUtilities.toString(dayValue));
		}
		// �f�[�^�V�t�g����
		String thisMonth[] = new String[6];
		String nextMonth[] = new String[6];
		// �������̓��t���R�s�[
		System.arraycopy(convKeys, 0, thisMonth, 0, 6);
		// �������̓��t���R�s�[
		System.arraycopy(convKeys, 6, nextMonth, 0, 6);
		// ����×{�Ǘ��w������胍�W�b�N�p�N��
		int end = thisMonth.length;
		for (int i = 0; i < end; i++) {
			if (ACTextUtilities.isNullText(VRBindPathParser.get(thisMonth[i],
					parseParam))) {
				// �󗓂�����ΉE�����֑���
				boolean find = false;
				for (int j = i + 1; j < end; j++) {
					Object obj = VRBindPathParser.get(thisMonth[j], parseParam);
					if (!ACTextUtilities.isNullText(obj)) {
						// �󗓈ȊO�f�[�^��������΍��֓]�L
						VRBindPathParser.set(thisMonth[i], parseParam, obj);
						VRBindPathParser.set(thisMonth[j], parseParam, "");
						find = true;
						break;
					}
				}
				if (!find) {
					// �E�����ɐV�K�f�[�^���Ȃ���Ώ����I��
					break;
				}
			}
		}

		end = nextMonth.length;
		for (int i = 0; i < end; i++) {
			if (ACTextUtilities.isNullText(VRBindPathParser.get(nextMonth[i],
					parseParam))) {
				// �󗓂�����ΉE�����֑���
				boolean find = false;
				for (int j = i + 1; j < end; j++) {
					Object obj = VRBindPathParser.get(nextMonth[j], parseParam);
					if (!ACTextUtilities.isNullText(obj)) {
						// �󗓈ȊO�f�[�^��������΍��֓]�L
						VRBindPathParser.set(nextMonth[i], parseParam, obj);
						VRBindPathParser.set(nextMonth[j], parseParam, "");
						find = true;
						break;
					}
				}
				if (!find) {
					// �E�����ɐV�K�f�[�^���Ȃ���Ώ����I��
					break;
				}
			}
		}

		VRBindPathParser.set("PATIENT_ADDRESS", parseParam,
				VRBindPathParser.get("KYOTAKU_PATIENT_ADDRESS", parseParam));
		VRBindPathParser.set("PATIENT_TEL_FIRST", parseParam,
				VRBindPathParser.get("KYOTAKU_PATIENT_TEL_FIRST", parseParam));
		VRBindPathParser.set("PATIENT_TEL_SECOND", parseParam,
				VRBindPathParser.get("KYOTAKU_PATIENT_TEL_SECOND", parseParam));
		VRBindPathParser.set("PATIENT_TEL_THIRD", parseParam,
				VRBindPathParser.get("KYOTAKU_PATIENT_TEL_THIRD", parseParam));

		return parseParam;
	}

	protected void patientChoiseColumnCheckMenuActionPerformed(ActionEvent e)
			throws Exception {

	}
	
	/**
	 * ����×{�Ǘ��w���̈���ϔ��菈��
     * [2014�N�v�]] ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
	 * 
     * @since version 6.2.3
     * @author Shinobu Hitaka 2014/12/02
	 */
	public int getFinishFlagQC006(VRMap param) throws Exception {
		
		// ���p�҈ꗗ�������Ɏ擾��������×{�Ǘ��w���������蓮�Ŏw�藘�p�҂̃f�[�^����������
		// ���p��ID��Int�^�̂��߁A�����L�[�Ƃ��Ĉ�v���Ȃ��B������ɕϊ����Č����L�[�Ƃ���B
		// �w�藘�p�҂̋���×{�Ǘ��w������񂪑S�Ĉ󎚍�=1�A����ȊO=0��Ԃ�
		int finishFlag = 1;
		String[] keys = { "PATIENT_ID" };
		VRMap dataMap = new VRHashMap();
		VRBindPathParser.set("PATIENT_ID", dataMap,
				ACCastUtilities.toString(VRBindPathParser.get("PATIENT_ID", param)));
		VRList kyotakuData = doMultiFind(getKyotakuData(), dataMap, keys);
		for (int i = 0; i < kyotakuData.size(); i++) {
			VRMap kyotakuMap = new VRHashMap();
			kyotakuMap = (VRMap) kyotakuData.get(i);
			// ������
			if (ACCastUtilities.toInteger(
									kyotakuMap.getData("FINISH_FLAG"), 0) == 0) {
				finishFlag = 0;
				break;
			}
		}

		return finishFlag;

	}

	/**
	 * ����×{�Ǘ��w���̈���ϐݒ菈��
     * [2014�N�v�]] ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
	 * 
     * @since version 6.2.3
     * @author Shinobu Hitaka 2015/01/05
	 */
	public void setFinishFlagQC006(Object patientId) throws Exception {
		
		// ���p�҈ꗗ�������Ɏ擾��������×{�Ǘ��w���������蓮�Ŏw�藘�p�҂̃f�[�^����������
		// ���p��ID��Int�^�̂��߁A�����L�[�Ƃ��Ĉ�v���Ȃ��B������ɕϊ����Č����L�[�Ƃ���B
		// �󎚍�=1��ݒ肷��
		String[] keys = { "PATIENT_ID" };
		VRMap dataMap = new VRHashMap();
		VRBindPathParser.set("PATIENT_ID", dataMap, ACCastUtilities.toString(patientId));
		VRList kyotakuData = doMultiFind(getKyotakuData(), dataMap, keys);
		for (int i = 0; i < kyotakuData.size(); i++) {
			VRMap kyotakuMap = new VRHashMap();
			kyotakuMap = (VRMap) kyotakuData.get(i);
			kyotakuMap.setData("FINISH_FLAG", 1);
		}

		return;

	}

	/**
	 * ����×{�Ǘ��w���̈���p�f�[�^��������
     * [2014�N�v�]] ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
	 * 
     * @since version 6.2.3
     * @author Shinobu Hitaka 2014/12/02
	 * @param param ���������i���p��ID�A��������t���O�j
	 * @param printMode 0�F����ς��܂߂Ȃ��A1�F�S�Ĉ��
	 */
	public VRList doFindPrintDataQC006(VRMap param, int printMode) throws Exception {
		
		VRMap dataMap = new VRHashMap();
		VRList kyotakuData = new VRArrayList();
		
		// ���p�҈ꗗ�������Ɏ擾��������×{�Ǘ��w���������蓮�Ŏw�藘�p�҂̃f�[�^����������
		if (printMode == 0) {
			//������m��̂�
			// ���p��ID�A��������t���O���w�肷��B
			// Int�^�̂��߁A�����L�[�Ƃ��Ĉ�v���Ȃ��B������ɕϊ����Č����L�[�Ƃ���B
			String[] keys = { "PATIENT_ID", "FINISH_FLAG" };
			VRBindPathParser.set("PATIENT_ID", dataMap,
					ACCastUtilities.toString(VRBindPathParser.get("PATIENT_ID", param)));
			VRBindPathParser.set("FINISH_FLAG", dataMap, "0");
			kyotakuData = doMultiFind(getKyotakuData(), dataMap, keys);
		} else if (printMode == 1) {
			//�S���
			// ���p��ID���w�肷��B
			String[] keys = { "PATIENT_ID" };
			VRBindPathParser.set("PATIENT_ID", dataMap,
					ACCastUtilities.toString(VRBindPathParser.get("PATIENT_ID", param)));
			kyotakuData = doMultiFind(getKyotakuData(), dataMap, keys);
		}

		return kyotakuData;

	}
	
	/**
	 * �f�[�^���蓮�������܂��B
	 * [2014�N�v�]] ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
	 * 
	 * @param targetList
	 * @param findParam
	 * @param keys
	 * @return
	 * @throws Exception
	 */
	public VRList doMultiFindQC006(VRList targetList, VRMap findParam, String[] keys)
			throws Exception {
		// �s���Ȓl�������Ȃ̂ŏ����l�ŕԂ�
		if (targetList == null || targetList.isEmpty()) {
			return new VRArrayList();
		}
		boolean isFindKey = false;
		// �����L�[�̑��݂̗L��
		for (int i = 0; i < keys.length; i++) {
			if (findParam.containsKey(keys[i])) {
				// ���ݗL�̏ꍇ�̓��[�v���I��
				isFindKey = true;
				break;
			}
		}
		// �p�����[�^�[���s���������͌����L�[�͖�����
		if (findParam == null || !isFindKey) {
			// ���������ɕԂ�
			return targetList;
		}
		
		// ����×{�Ǘ��w���S�Ă�茟��
		// ���p��
		// ���Ə�����
		// ���x������
		// ��������t���O
		VRList kyotakuData = doMultiFind(getKyotakuData(), findParam, keys);
		
		// ���p�҈ꗗ�Ƌ���×{�Ǘ��w�����������ʂ��r����v���闘�p�҂����ʂƂ��ĕԂ��B
		VRMap searchMap = new VRHashMap();
		VRList searchList = new VRArrayList();
		VRList resultList = new VRArrayList();
		
		for (int m = 0; m < targetList.size(); m++) {
			VRMap targetMap = new VRHashMap();
			targetMap = (VRMap) targetList.get(m);
			String patientId = ACCastUtilities.toString(targetMap.getData("PATIENT_ID"));
			
			VRBindPathParser.set("PATIENT_ID", searchMap, patientId);
			searchList = filterData(kyotakuData, searchMap, "PATIENT_ID");
			// ���ʃ��X�g�֒ǉ�
			if (searchList.size() > 0) {
				resultList.addData(targetMap);
			}
		}
		targetList = resultList;
		
		return targetList;
	}

}
