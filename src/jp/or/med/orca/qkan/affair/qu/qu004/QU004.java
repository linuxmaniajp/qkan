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
 * �쐬��: 2006/01/25  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�ғo�^ (004)
 * �v���O���� ����E�y����� (QU004)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qu.qu004;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACHashMapFormat;
import jp.nichicom.ac.text.ACTextUtilities;
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
import jp.or.med.orca.qkan.text.QkanClaimStyleFormat;

/**
 * ����E�y�����(QU004)
 */
public class QU004 extends QU004Event {

	public final static int RESULT_TRUE = 0;

	public final static int RESULT_FALSE = 1;

	public final static int RESULT_CHANGEABLE = 2;

	public final static int NOT_SHOW_KOHI= 0;
	public final static int SHOW_KOHI = 1;
	

	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QU004() {
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

		// ��ʓW�J����

		// �n��p�����[�^��ޔ�����B
		VRMap param = affair.getParameters();

		// �EpatientId KEY�FPATIENT_ID
		if (VRBindPathParser.has("PATIENT_ID", param)) {
			setPatientId(ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", param)));
		}

		// �EprocessStart KEY�FPROCESS_START
		if (VRBindPathParser.has("PROCESS_START", param)) {
			setProcessStart(ACCastUtilities.toString(VRBindPathParser.get(
					"PROCESS_START", param)));
		}

		// �n��p�����[�^�̍폜
		param.clear();

		// ��ʂ̏��������s���B
		initialize();

		// ���R�[�h���擾���A��ʂɐݒ肷��B
		doFind();

	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}

		boolean unsettledInfoExistFlg = false;

		// �����߂�t���O��1�̏ꍇ
		if (getCompulsoryBackFlg() == 1) {
			// �ȉ��̒l���p�����[�^�ɐݒ肷��B
			// KEY�FCOMPULSORY_BACK_FLG VALUE�FcompulsoryBackFlg
			VRBindPathParser.set("COMPULSORY_BACK_FLG", parameters,
					new Integer(getCompulsoryBackFlg()));
			// �O��ʂɑJ�ڂ���B
			return true;
		}

		// �ύX�`�F�b�N(�j�������\���̂�����)
		if (getSnapShotKaigo().isModified() || getSnapShotIryo().isModified()
				|| getSnapShotShahuku().isModified()) {
			unsettledInfoExistFlg = true;
		}

		// �ύX�`�F�b�N�i��ʃe�[�u���̃`�F�b�N�j���s���B
		if (getKaigoTableChangeFlg() == 1 || getIryoTableChangeFlg() == 1
				|| getShahukuTableChangeFlg() == 1 || unsettledInfoExistFlg) {
			// �Ō�ɕۑ�����Ă���A��ʃe�[�u�����ύX����Ă���ꍇ�i���L�̂����ꂩ�̏ꍇ�j
			// �EkaigoTableChangeFlg = 1
			// �EiryoTableChangeFlg = 1
			// �EshahukuTableChangeFlg = 1
			// �m�F���b�Z�[�W��\������B
			if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
				// �V�K�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�j
				// �E���b�Z�[�WID�FWARNING_OF_INSERT_ON_MODIFIED

				switch (QkanMessageList.getInstance()
						.WARNING_OF_INSERT_ON_MODIFIED()) {
				case ACMessageBox.RESULT_OK:
					// �u�͂��v��I�������ꍇ

					try {
						// �j��������񂪂��邱�Ƃ�`���郁�b�Z�[�W
						if (unsettledInfoExistFlg) {
							// ���b�Z�[�W�\��
							String msgParam = "������������͎Љ���y�����";
							switch (QkanMessageList.getInstance()
									.WARNING_OF_CANCELLATION_UNSETTLED_DATA(
											msgParam)) {
							// �uOK�v�Ȃ�j��
							case ACMessageBox.RESULT_OK:
								break;
							// �uCANCEL�v�Ȃ珈�����f
							case ACMessageBox.RESULT_CANCEL:
								return false;
							}
						}

						// �ۑ��������s���B
						if (!doSave()) {
							// �p�b�V�u�G���[�����������ꍇ
							return false;
						}

					} catch (Exception ex) {

						// �ۑ�����������I�����Ȃ������ꍇ
						// �����𒆒f����B
						throw ex;
					}

					break;

				case ACMessageBox.RESULT_CANCEL:
					// �u�L�����Z���v��I�������ꍇ
					// �������I������B
					return false;
				}

			} else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
				// �ҏW�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j
				// �E���b�Z�[�WID�FWARNING_OF_UPDATE_ON_MODIFIED;

				switch (QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED()) {
				case ACMessageBox.RESULT_OK:
					// �u�͂��v��I�������ꍇ

					try {
						// �j��������񂪂��邱�Ƃ�`���郁�b�Z�[�W
						if (unsettledInfoExistFlg) {
							// ���b�Z�[�W�\��
							String msgParam = "������������͎Љ���y�����";
							switch (QkanMessageList.getInstance()
									.WARNING_OF_CANCELLATION_UNSETTLED_DATA(
											msgParam)) {
							// �uOK�v�Ȃ�j��
							case ACMessageBox.RESULT_OK:
								break;
							// �uCANCEL�v�Ȃ珈�����f
							case ACMessageBox.RESULT_CANCEL:
								return false;
							}
						}

						// �ۑ��������s���B
						if (!doSave()) {
							// �p�b�V�u�G���[�����������ꍇ
							return false;
						}

					} catch (Exception ex) {
						// �ۑ�����������I�����Ȃ������ꍇ
						// �����𒆒f����B(�I��)
						throw ex;
					}

					break;

				case ACMessageBox.RESULT_CANCEL:
					// �u�͂��v�u�������v�ȊO��I�������ꍇ
					// �����𒆒f����i�������Ȃ��j�B
					return false;
				}

			}
		}

		// ���L��n��p�����[�^�Ƃ��āA�u���p�ғo�^�iQU002�j�v��ʂɖ߂�B
		// �EKEY�FPATIENT_ID VALUE�FpatientId�i���p��ID�j
		// �EKEY�FPROCESS_MODE VALUE�F�i���ʒ萔��PROCESS_MODE_UPDATE�i�v���Z�X���[�h�u�X�V�v�j�j
		// �EKEY�FPROCESS_START VALUE�FprocessStart
		VRBindPathParser.set("PATIENT_ID", parameters, new Integer(
				getPatientId()));
		VRBindPathParser.set("PROCESS_MODE", parameters, new Integer(
				QkanConstants.PROCESS_MODE_UPDATE));
		VRBindPathParser.set("PROCESS_START", parameters, getProcessStart());

		// �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// �ύX�`�F�b�N�i��ʃe�[�u���̃`�F�b�N�j���s���B
		if (getKaigoTableChangeFlg() == 1 || getIryoTableChangeFlg() == 1
				|| getShahukuTableChangeFlg() == 1) {
			// �Ō�ɕۑ�����Ă���A��ʃe�[�u�����ύX����Ă���ꍇ�i���L�̂����ꂩ�̏ꍇ�j
			// �EkaigoTableChangeFlg = 1
			// �EiryoTableChangeFlg = 1
			// �EshahukuTableChangeFlg = 1

			// �I���m�F���b�Z�[�W��\������B
			switch (QkanMessageList.getInstance()
					.WARNING_OF_CLOSE_ON_MODIFIED()) {
			// �E���b�Z�[�WID�FWARNING_OF_CLOSE_ON_MODIFIED

			case ACMessageBox.RESULT_CANCEL:
				// �u�L�����Z���v��I�������ꍇ
				// �����𒆒f����i�������Ȃ��j�B
				return false;

			}
		}

		// �I����������Ȃ��true��Ԃ��B
		return true;

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
	protected void insertActionPerformed(ActionEvent e) throws Exception {

		// �o�^����

		try {

			// �ύX�`�F�b�N(�j�������\���̂�����)
			if (getSnapShotKaigo().isModified()
					|| getSnapShotIryo().isModified()
					|| getSnapShotShahuku().isModified()) {

				// ���b�Z�[�W�\��
				String msgParam = "������������͎Љ���y�����";
				switch (QkanMessageList.getInstance()
						.WARNING_OF_CANCELLATION_UNSETTLED_DATA(msgParam)) {
				// �uOK�v�Ȃ�j��
				case ACMessageBox.RESULT_OK:
					break;
				// �uCANCEL�v�Ȃ珈�����f
				case ACMessageBox.RESULT_CANCEL:
					return;
				}

			}

			// �ۑ��������s���B
			if (!doSave()) {
				// �p�b�V�u�G���[�����������ꍇ
				return;
			}

			// �ۑ�����������I�������ꍇ
			// �������[�h���X�V���[�h�ɕύX����B
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

			// ��ʂ̐ݒ���s���B
			casualInitialize();

			// �ŐV�̃f�[�^���擾����B
			doFind();

			// ����ID�FUPDATE_MODE
			// �������b�Z�[�W��\������B
			// �E���b�Z�[�WID�FINSERT_SUCCESSED
			QkanMessageList.getInstance().INSERT_SUCCESSED();

		} catch (Exception ex) {
			// �ۑ�����������I�����Ȃ������ꍇ
			// �������I������B�i�������Ȃ��j
			throw ex;
		}
	}

	/**
	 * �uDB�X�V�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void updateActionPerformed(ActionEvent e) throws Exception {

		// �X�V����

		try {

			// �ύX�`�F�b�N(�j�������\���̂�����)
			if (getSnapShotKaigo().isModified()
					|| getSnapShotIryo().isModified()
					|| getSnapShotShahuku().isModified()) {

				// ���b�Z�[�W�\��
				String msgParam = "������������͎Љ���y�����";
				switch (QkanMessageList.getInstance()
						.WARNING_OF_CANCELLATION_UNSETTLED_DATA(msgParam)) {
				// �uOK�v�Ȃ�j��
				case ACMessageBox.RESULT_OK:
					break;
				// �uCANCEL�v�Ȃ珈�����f
				case ACMessageBox.RESULT_CANCEL:
					return;
				}

			}

			// �ۑ��������s���B
			if (!doSave()) {
				// �p�b�V�u�G���[�����������ꍇ
				return;
			}

			// �ۑ�����������I�������ꍇ
			// ��ʂ̐ݒ���s���B
			casualInitialize();

			// �ŐV�̃f�[�^���擾����B
			doFind();

			// �������b�Z�[�W��\������B
			// �E���b�Z�[�WID�FUPDATE_SUCCESSED
			QkanMessageList.getInstance().UPDATE_SUCCESSED();

		} catch (Exception ex) {
			// �ۑ�����������I�����Ȃ������ꍇ
			// �������I������B�i�������Ȃ��j
			throw ex;
		}
	}

	/**
	 * �u��������N���A�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void kaigoInfoButtonClearActionPerformed(ActionEvent e)
			throws Exception {

		// �N���A����

		if (getKaigoInfoTable().isSelected()) {
			// ��ʃe�[�u���̍s���I������Ă���ꍇ
			// �e�[�u���̑I�����N���A����B
			getKaigoInfoTable().clearSelection();
		} else {
			// ��ʃe�[�u���̍s���I������Ă���ꍇ
			VRMap map = new VRHashMap();
			// �V���ȃ\�[�X�𐶐�����B
			map = (VRMap) getKaigoInfo().createSource();
			getKaigoInfo().setSource(map);
			getKaigoInfo().bindSource();

			// �X�i�b�v�V���b�g
			getSnapShotKaigo().snapshot();
		}
	}

	/**
	 * �u��������ǉ������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void kaigoInfoButtonInsertActionPerformed(ActionEvent e)
			throws Exception {

		// ���̓`�F�b�N���s���B
		if (!isValidInput(INSURE_TYPE_KAIGO, CHECK_MODE_INSERT)) {
			// ���̓G���[���������ꍇ
			return;
		}

		// ���̓G���[���Ȃ������ꍇ
		// ���HashMap�𐶐����A�u������̈�E���2�ikaigoInfo�j�v�̃\�[�X�Ƃ��Đݒ肷��B
		VRMap map = new VRHashMap();
		getKaigoInfo().setSource(map);

		// ���͂��ꂽ�f�[�^���\�[�X�ɗ������݁A�f�[�^���擾����B
		getKaigoInfo().applySource();

		// �擾������ʏ�̃f�[�^��PATIENT_ID��ݒ肷��B
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));

		// patientKohiList�����������[�v���AKOHI_ID�̍ő�l+1�̒l���擾����B
		int maxId = 0;

		// �ő�l�̎擾
		if (!(getPatientKohiList() == null || getPatientKohiList().size() == 0)) {

			// ��ʃe�[�u���Ɋ��Ƀf�[�^�����݂��Ă���ꍇ
			for (int i = 0; i < getPatientKohiList().size(); i++) {

				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"KOHI_ID", (VRMap) getPatientKohiList().get(i)));

				// ��r�Ώۂ���r�����傫���l�̏ꍇ
				if (maxId < target) {
					// ��r�Ώۂ��r���Ƃ���B
					maxId = target;
				}

			}
		}

		// KOHI_ID��ǉ�����B
		VRBindPathParser.set("KOHI_ID", map, new Integer(maxId + 1));

		// INSURE_TYPE��ݒ肷��B
		VRBindPathParser
				.set("INSURE_TYPE", map, new Integer(INSURE_TYPE_KAIGO));

		// �L�����Ԃ̕t������
		setMaxAndMinDate(map);

		// �e�[�u���\���p�ɕҏW����B
		map = toKohiTableList(map);

		// String����Integer�Ɍ^�ϊ� ���\�[�g���΍�
		final String[] keys = new String[] { "BENEFIT_RATE", };
		QkanCommon.convertValueFromStringToInteger(map, keys);

		// �擾�����f�[�^��patientKohiList�̐V�������R�[�h�Ƃ��Ēǉ�����B
		getPatientKohiList().add(map);

		// ��ʂ̗��p�Ҍ���T�[�r�X���擾�֐����Ăяo���A�߂�l��ArrayList�FList�Ɋi�[����B
		// �E�������FkohiId
		// �E��j�����FINSURE_TYPE_KAIGO
		VRList list = getPatientKohiService(maxId + 1, INSURE_TYPE_KAIGO);

		// List��patientKohiServiceList�ɒǉ�����B
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				getPatientKohiServiceList().add(list.get(i));
			}
		}

		// patientKohiList��������̃f�[�^���擾���A�e�[�u�����f���ɐݒ肷��B
		VRList kaigoKohiList = getListToSetTable(getPatientKohiList(),
				INSURE_TYPE_KAIGO);
		getKaigoTableModel().setAdaptee(kaigoKohiList);

		// �ȉ��̏����ŉ�����e�[�u���̃\�[�g���s���B
		// KOHI_VALID_START�i����L�����ԊJ�n�j DESC
		getKaigoInfoTable().sort("KOHI_VALID_START DESC");

		// �ǉ��s��I��
		int selectedRow = ACBindUtilities.getMatchIndexFromMap(kaigoKohiList,
				"KOHI_ID", map);
		getKaigoInfoTable().setSelectedModelRow(selectedRow);

		// kaigoTableChangeFlg��1�i�ύX����j��������B
		setKaigoTableChangeFlg(1);

	}

	/**
	 * �u��������ҏW�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void kaigoInfoButtonConpileActionPerformed(ActionEvent e)
			throws Exception {

		// ���̓`�F�b�N���s���B
		if (!isValidInput(INSURE_TYPE_KAIGO, CHECK_MODE_UPDATE)) {
			// ���̓G���[���������ꍇ
			return;
		}

		// ���̓G���[���Ȃ������ꍇ

		// ���͂��ꂽ�f�[�^���擾����B
		VRMap map = new VRHashMap();
		getKaigoInfo().setSource(map);
		getKaigoInfo().applySource();

		// �I���s�̃f�[�^���擾����B
		VRMap temp = (VRMap) getKaigoInfoTable().getSelectedModelRowValue();

		// ��ʏ�ɂȂ��f�[�^���A�e�[�u���̃f�[�^����ڂ��B
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));
		VRBindPathParser.set("KOHI_ID", map, VRBindPathParser.get("KOHI_ID",
				temp));
		VRBindPathParser.set("INSURE_TYPE", map, VRBindPathParser.get(
				"INSURE_TYPE", temp));

		// �L�����Ԃ̕t������
		setMaxAndMinDate(map);

		// �擾�����f�[�^���e�[�u���\���p�ɕҏW����B
		map = toKohiTableList(map);

		// �I���f�[�^��patientKohiList�ł̃C���f�b�N�X���擾����B
		int row = ACBindUtilities.getMatchIndexFromMap(getPatientKohiList(),
				"KOHI_ID", temp);

		// String����Integer�Ɍ^�ϊ� ���\�[�g���΍�
		final String[] keys = new String[] { "BENEFIT_RATE", };
		QkanCommon.convertValueFromStringToInteger(map, keys);

		// ��ʏ�̃f�[�^��ݒ肷��B
		getPatientKohiList().set(row, map);

		// ���R�[�h��KOHI_ID�i�ȉ��AkohiId�j���擾����B
		int kohiId = ACCastUtilities
				.toInt(VRBindPathParser.get("KOHI_ID", map));

		// patientKohiServiceList����AKOHI_ID=kohiId�̃��R�[�h���폜����B
		if (getPatientKohiServiceList() != null) {
			for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
				VRMap patientKohiService = (VRMap) getPatientKohiServiceList()
						.get(i);

				if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
						patientKohiService)) == kohiId) {
					getPatientKohiServiceList().remove(i);

					// �폜�����̂ŃC���f�b�N�X��1�߂��B
					i = i - 1;
				}

			}
		}

		// ��ʂ̗��p�Ҍ���T�[�r�X���擾�֐����Ăяo���A�߂�l��ArrayList�FList�Ɋi�[����B
		// �E�������FkohiId
		// �E��j�����FINSURE_TYPE_KAIGO
		VRList list = getPatientKohiService(kohiId, INSURE_TYPE_KAIGO);

		// List��patientKohiServiceList�ɒǉ�����B
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				getPatientKohiServiceList().add(list.get(i));
			}
		}

		// patientKohiList��������̃f�[�^���擾���A�e�[�u�����f���ɐݒ肷��B
		VRList kaigoKohiList = getListToSetTable(getPatientKohiList(),
				INSURE_TYPE_KAIGO);
		getKaigoTableModel().setAdaptee(kaigoKohiList);

		// �ȉ��̏����ŉ�����e�[�u���̃\�[�g���s���B
		// KOHI_VALID_START�i����L�����ԊJ�n�j DESC
		getKaigoInfoTable().sort("KOHI_VALID_START DESC");

		// �I�����Ă����s��I��
		int selectedRow = ACBindUtilities.getMatchIndexFromMap(kaigoKohiList,
				"KOHI_ID", map);
		getKaigoInfoTable().setSelectedModelRow(selectedRow);

		// kaigoTableChangeFlg��1�i�ύX����j��������B
		setKaigoTableChangeFlg(1);

	}

	/**
	 * �u��������폜�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void kaigoInfoButtonDeleteActionPerformed(ActionEvent e)
			throws Exception {

		// �m�F���b�Z�[�W��\������B
		// �E���b�Z�[�WID�FWARNING_OF_DELETE_SELECTION
		if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() == ACMessageBox.RESULT_OK) {
			// �u�͂��v��I�������ꍇ

			// �I������Ă���f�[�^�̉�ʏ�̃C���f�b�N�X��ޔ�����B
			int sortedRow = getKaigoInfoTable().getSelectedSortedRow();

			// �I���f�[�^��KOHI_ID��ޔ�����B
			VRMap map = (VRMap) getKaigoInfoTable().getSelectedModelRowValue();
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					map));

			// �I���s�f�[�^�̍폜
			int selectedRow = ACBindUtilities.getMatchIndexFromMap(
					getPatientKohiList(), "KOHI_ID", map);
			getPatientKohiList().remove(selectedRow);

			// patientKohiList��������̃f�[�^���擾���A�e�[�u�����f���ɐݒ肷��B
			VRList kaigoKohiList = getListToSetTable(getPatientKohiList(),
					INSURE_TYPE_KAIGO);
			getKaigoTableModel().setAdaptee(kaigoKohiList);

			// �I������Ă��郌�R�[�h��KOHI_ID�ŉ��L�̃��R�[�h�W�����������A�Y�����R�[�h���폜����B
			// �EpatientKohiServiceList
			if (getPatientKohiServiceList() != null) {
				for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
					VRMap patientKohiService = (VRMap) getPatientKohiServiceList()
							.get(i);

					if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
							patientKohiService)) == kohiId) {
						getPatientKohiServiceList().remove(i);

						// �폜�����̂ŃC���f�b�N�X��1�߂��B
						i = i - 1;
					}
				}
			}

			// �폜���ꂽ�s��1�s���I������B
			getKaigoInfoTable().setSelectedSortedRowOnAfterDelete(sortedRow);

			// kaigoTableChangeFlg��1�i�ύX����j��������B
			setKaigoTableChangeFlg(1);

		}

	}

	/**
	 * �u��Ì�����N���A�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void iryoInfoButtonClearActionPerformed(ActionEvent e)
			throws Exception {

		// �N���A����

		if (getIryoInfoTable().isSelected()) {
			// ��ʃe�[�u���̍s���I������Ă���ꍇ
			// �e�[�u���̑I�����N���A����B
			getIryoInfoTable().clearSelection();
		} else {
			// ��ʃe�[�u���̍s���I������Ă���ꍇ
			VRMap map = new VRHashMap();
			// �V���ȃ\�[�X�𐶐�����B
			map = (VRMap) getIryoInfo().createSource();
			getIryoInfo().setSource(map);
			getIryoInfo().bindSource();

			// �X�i�b�v�V���b�g
			getSnapShotIryo().snapshot();

		}

	}

	/**
	 * �u��Ì�����ǉ������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void iryoInfoButtonInsertActionPerformed(ActionEvent e)
			throws Exception {

		// ���̓`�F�b�N���s���B
		if (!isValidInput(INSURE_TYPE_IRYO, CHECK_MODE_INSERT)) {
			// ���̓G���[���������ꍇ
			return;
		}

		// ���̓G���[���Ȃ������ꍇ
		// ���HashMap�𐶐����A�u��Ì���̈�E���2�iiryoInfo�j�v�̃\�[�X�Ƃ��Đݒ肷��B
		VRMap map = new VRHashMap();
		getIryoInfo().setSource(map);

		// ���͂��ꂽ�f�[�^���\�[�X�ɗ������݁A�f�[�^���擾����B
		getIryoInfo().applySource();

		// �擾������ʏ�̃f�[�^��PATIENT_ID��ݒ肷��B
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));

		// patientKohiList�����������[�v���AKOHI_ID�̍ő�l+1�̒l���擾����B
		int maxId = 0;

		// �ő�l�̎擾
		if (!(getPatientKohiList() == null || getPatientKohiList().size() == 0)) {

			// ��ʃe�[�u���Ɋ��Ƀf�[�^�����݂��Ă���ꍇ
			for (int i = 0; i < getPatientKohiList().size(); i++) {

				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"KOHI_ID", (VRMap) getPatientKohiList().get(i)));

				// ��r�Ώۂ���r�����傫���l�̏ꍇ
				if (maxId < target) {
					// ��r�Ώۂ��r���Ƃ���B
					maxId = target;
				}

			}
		}

		// KOHI_ID��ǉ�����B
		VRBindPathParser.set("KOHI_ID", map, new Integer(maxId + 1));

		// INSURE_TYPE��ݒ肷��B
		VRBindPathParser.set("INSURE_TYPE", map, new Integer(INSURE_TYPE_IRYO));

		// �e�[�u���\���p�ɕҏW����B
		map = toKohiTableList(map);

		// �L�����Ԃ̕t������
		setMaxAndMinDate(map);

		// String����Integer�Ɍ^�ϊ� ���\�[�g���΍�
		final String[] keys = new String[] { "BENEFIT_RATE", };
		QkanCommon.convertValueFromStringToInteger(map, keys);

		// �擾�����f�[�^��patientKohiList�̐V�������R�[�h�Ƃ��Ēǉ�����B
		getPatientKohiList().add(map);

		// ��ʂ̗��p�Ҍ���T�[�r�X���擾�֐����Ăяo���A�߂�l��ArrayList�FList�Ɋi�[����B
		// �E�������FkohiId
		// �E��j�����FINSURE_TYPE_IRYO
		VRList list = getPatientKohiService(maxId + 1, INSURE_TYPE_IRYO);

		// List��patientKohiServiceList�ɒǉ�����B
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				getPatientKohiServiceList().add(list.get(i));
			}
		}

		// patientKohiList����Ì���̃f�[�^���擾���A�e�[�u�����f���ɐݒ肷��B
		VRList iryoKohiList = getListToSetTable(getPatientKohiList(),
				INSURE_TYPE_IRYO);
		getIryoTableModel().setAdaptee(iryoKohiList);

		// �ȉ��̏����ň�Ì���e�[�u���̃\�[�g���s���B
		// KOHI_VALID_START�i����L�����ԊJ�n�j DESC
		getIryoInfoTable().sort("KOHI_VALID_START DESC");

		// �ǉ��s��I��
		int selectedRow = ACBindUtilities.getMatchIndexFromMap(iryoKohiList,
				"KOHI_ID", map);
		getIryoInfoTable().setSelectedModelRow(selectedRow);

		// iryoTableChangeFlg��1�i�ύX����j��������B
		setIryoTableChangeFlg(1);

	}

	/**
	 * �u��Ì�����ҏW�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void iryoInfoButtonConpileActionPerformed(ActionEvent e)
			throws Exception {

		// ���̓`�F�b�N���s���B
		if (!isValidInput(INSURE_TYPE_IRYO, CHECK_MODE_UPDATE)) {
			// ���̓G���[���������ꍇ
			return;
		}

		// ���̓G���[���Ȃ������ꍇ

		// ���͂��ꂽ�f�[�^���擾����B
		VRMap map = new VRHashMap();
		getIryoInfo().setSource(map);
		getIryoInfo().applySource();

		// �I���s�̃f�[�^���擾����B
		VRMap temp = (VRMap) getIryoInfoTable().getSelectedModelRowValue();

		// ��ʏ�ɂȂ��f�[�^���A�e�[�u���̃f�[�^����ڂ��B
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));
		VRBindPathParser.set("KOHI_ID", map, VRBindPathParser.get("KOHI_ID",
				temp));
		VRBindPathParser.set("INSURE_TYPE", map, VRBindPathParser.get(
				"INSURE_TYPE", temp));

		// �L�����Ԃ̕t������
		setMaxAndMinDate(map);

		// �擾�����f�[�^���e�[�u���\���p�ɕҏW����B
		map = toKohiTableList(map);

		// �I���f�[�^��patientKohiList�ł̃C���f�b�N�X���擾����B
		int row = ACBindUtilities.getMatchIndexFromMap(getPatientKohiList(),
				"KOHI_ID", temp);

		// String����Integer�Ɍ^�ϊ� ���\�[�g���΍�
		final String[] keys = new String[] { "BENEFIT_RATE", };
		QkanCommon.convertValueFromStringToInteger(map, keys);

		// ��ʏ�̃f�[�^��ݒ肷��B
		getPatientKohiList().set(row, map);

		// ���R�[�h��KOHI_ID�i�ȉ��AkohiId�j���擾����B
		int kohiId = ACCastUtilities
				.toInt(VRBindPathParser.get("KOHI_ID", map));

		// patientKohiServiceList����AKOHI_ID=kohiId�̃��R�[�h���폜����B
		if (getPatientKohiServiceList() != null) {
			for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
				VRMap patientKohiService = (VRMap) getPatientKohiServiceList()
						.get(i);

				if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
						patientKohiService)) == kohiId) {

					// �폜
					getPatientKohiServiceList().remove(i);

					// �폜�����̂ŃC���f�b�N�X��1�߂��B
					i = i - 1;
				}

			}
		}

		// ��ʂ̗��p�Ҍ���T�[�r�X���擾�֐����Ăяo���A�߂�l��ArrayList�FList�Ɋi�[����B
		// �E�������FkohiId
		// �E��j�����FINSURE_TYPE_IRYO
		VRList list = getPatientKohiService(kohiId, INSURE_TYPE_IRYO);

		// List��patientKohiServiceList�ɒǉ�����B
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				getPatientKohiServiceList().add(list.get(i));
			}
		}

		// patientKohiList����Ì���̃f�[�^���擾���A�e�[�u�����f���ɐݒ肷��B
		VRList iryoKohiList = getListToSetTable(getPatientKohiList(),
				INSURE_TYPE_IRYO);
		getIryoTableModel().setAdaptee(iryoKohiList);

		// �ȉ��̏����ň�Ì���e�[�u���̃\�[�g���s���B
		// KOHI_VALID_START�i����L�����ԊJ�n�j DESC
		getIryoInfoTable().sort("KOHI_VALID_START DESC");

		// �I�����Ă����s��I��
		int selectedRow = ACBindUtilities.getMatchIndexFromMap(iryoKohiList,
				"KOHI_ID", map);
		getIryoInfoTable().setSelectedModelRow(selectedRow);

		// iryoTableChangeFlg��1�i�ύX����j��������B
		setIryoTableChangeFlg(1);

	}

	/**
	 * �u��Ì�����폜�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void iryoInfoButtonDeleteActionPerformed(ActionEvent e)
			throws Exception {

		// �m�F���b�Z�[�W��\������B
		// �E���b�Z�[�WID�FWARNING_OF_DELETE_SELECTION
		if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() == ACMessageBox.RESULT_OK) {
			// �u�͂��v��I�������ꍇ

			// �I������Ă���f�[�^�̉�ʏ�̃C���f�b�N�X��ޔ�����B
			int sortedRow = getIryoInfoTable().getSelectedSortedRow();

			// �I���f�[�^��KOHI_ID��ޔ�����B
			VRMap map = (VRMap) getIryoInfoTable().getSelectedModelRowValue();
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					map));

			// �I���s�f�[�^�̍폜
			int selectedRow = ACBindUtilities.getMatchIndexFromMap(
					getPatientKohiList(), "KOHI_ID", map);
			getPatientKohiList().remove(selectedRow);

			// patientKohiList����Ì���̃f�[�^���擾���A�e�[�u�����f���ɐݒ肷��B
			VRList iryoKohiList = getListToSetTable(getPatientKohiList(),
					INSURE_TYPE_IRYO);
			getIryoTableModel().setAdaptee(iryoKohiList);

			// �I������Ă��郌�R�[�h��KOHI_ID�ŉ��L�̃��R�[�h�W�����������A�Y�����R�[�h���폜����B
			// �EpatientKohiServiceList
			if (getPatientKohiServiceList() != null) {
				for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
					VRMap patientKohiService = (VRMap) getPatientKohiServiceList()
							.get(i);

					if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
							patientKohiService)) == kohiId) {
						getPatientKohiServiceList().remove(i);

						// �폜�����̂ŃC���f�b�N�X��1�߂��B
						i = i - 1;
					}
				}
			}

			// �폜���ꂽ�s��1�s���I������B
			getIryoInfoTable().setSelectedSortedRowOnAfterDelete(sortedRow);

			// kaigoTableChangeFlg��1�i�ύX����j��������B
			setIryoTableChangeFlg(1);

		}

	}

	/**
	 * �u��������W�J�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void kaigoInfoTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		VRMap map = new VRHashMap();

		if (!getKaigoInfoTable().isSelected()) {
			// ��ʃe�[�u���̍s���I������Ă��Ȃ��ꍇ

			// �V���ȃ\�[�X�𐶐�����B
			map = (VRMap) getKaigoInfo().createSource();
			getKaigoInfo().setSource(map);
			getKaigoInfo().bindSource();

			// ���S�Җ��R���{�̃N���A
			getKaigoInfoBearName().setSelectedItem(null);

			// Enable������s���B
			// �E���ID�FENABLE_KAIGO_BUTTON_FALSE
			setState_ENABLE_KAIGO_BUTTON_FALSE();

		} else {
			// ��ʃe�[�u���̍s���I������Ă���ꍇ

			// �I�����ꂽ���R�[�h���A�u������̈�E���2�ikaigoInfo�j�v
			// �̃\�[�X�Ƃ��Đݒ肷��B
			map = (VRMap) getKaigoInfoTable().getSelectedModelRowValue();
			getKaigoInfo().setSource(map);

			// ��ʂɓW�J����B
			getKaigoInfo().bindSource();

			// ���S�Җ��R���{�̐ݒ�
			Object temp = VRBindPathParser.get("INSURER_ID", map);
			getKaigoInfoBearName().setSelectedItem(
					ACBindUtilities.getMatchRowFromValue(getInsurerList(),
							"INSURER_ID", temp));

			// �I�����ꂽ��������KOHI_ID���擾���Aint�FkohiId�Ɋi�[����B
			// ���p�Ҍ���T�[�r�X������ʂɓW�J����B
			// �E�������FkohiId
			// �E��j�����FINSURE_TYPE_KAIGO
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					map));

			setPatientKohiService(kohiId, INSURE_TYPE_KAIGO);

			// Enable������s���B
			// �E���ID�FENABLE_KAIGO_BUTTON_TRUE
			setState_ENABLE_KAIGO_BUTTON_TRUE();

		}

		// �X�i�b�v�V���b�g
		getSnapShotKaigo().snapshot();

	}

	/**
	 * �u��Ì�����W�J�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void iryoInfoTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		VRMap map = new VRHashMap();

		if (!getIryoInfoTable().isSelected()) {
			// ��ʃe�[�u���̍s���I������Ă��Ȃ��ꍇ

			// �V���ȃ\�[�X�𐶐�����B
			map = (VRMap) getIryoInfo().createSource();
			getIryoInfo().setSource(map);
			getIryoInfo().bindSource();

			// ���S�Җ��R���{�̃N���A
			getIryoInfoBearName().setSelectedItem(null);

			// Enable������s���B
			// �E���ID�FENABLE_IRYO_BUTTON_FALSE
			setState_ENABLE_IRYO_BUTTON_FALSE();

		} else {
			// ��ʃe�[�u���̍s���I������Ă���ꍇ

			// �I������Ă��郌�R�[�h���A�u��Ì���̈�E���2�iiryoInfo�j�v�ɐݒ肷��B
			map = (VRMap) getIryoInfoTable().getSelectedModelRowValue();
			getIryoInfo().setSource(map);

			// ��ʂɓW�J����B
			getIryoInfo().bindSource();

			// ���S�Җ��R���{�̐ݒ�
			Object temp = VRBindPathParser.get("INSURER_ID", map);
			getIryoInfoBearName().setSelectedItem(
					ACBindUtilities.getMatchRowFromValue(getInsurerList(),
							"INSURER_ID", temp));

			// �I�����ꂽ��������KOHI_ID���擾���Aint�FkohiId�Ɋi�[����B
			// ���p�Ҍ���T�[�r�X������ʂɓW�J����B
			// �E�������FkohiId
			// �E��j�����FINSURE_TYPE_IRYO
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					map));

			setPatientKohiService(kohiId, INSURE_TYPE_IRYO);

			// Enable������s���B
			// �E���ID�FENABLE_IRYO_BUTTON_TRUE
			setState_ENABLE_IRYO_BUTTON_TRUE();

		}

		// �X�i�b�v�V���b�g
		getSnapShotIryo().snapshot();

	}

	/**
	 * �u���S�Ҕԍ����͎������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void kaigoInfoInsurerNoFocusLost(FocusEvent e) throws Exception {

		// ���͂��ꂽ���S�Ҕԍ��������S�҂̖��̂𕉒S�Җ��R���{�ikaigoInfoBearName�j�ɕ\������B
		doFindInsurerName(INSURE_TYPE_KAIGO);

	}

	/**
	 * �u���S�Җ��I���������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void kaigoInfoBearNameActionPerformed(ActionEvent e)
			throws Exception {

		// �I�����ꂽ���S�҂̕��S�Ҕԍ��𕉒S�Ҕԍ��t�B�[���h�ikaigoInfoInsurerNo�j�ɕ\������B
		doFindInsurerId(INSURE_TYPE_KAIGO);

	}

	/**
	 * �u���S�Ҕԍ����͎������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void iryoInfoInsurerNoFocusLost(FocusEvent e) throws Exception {

		// ���͂��ꂽ���S�Ҕԍ��������S�҂̖��̂𕉒S�Җ��R���{�iiryoInfoBearName�j�ɕ\������B
		doFindInsurerName(INSURE_TYPE_IRYO);

	}

	/**
	 * �u���S�Җ��I���������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void iryoInfoBearNameActionPerformed(ActionEvent e)
			throws Exception {

		// �I�����ꂽ���S�҂̕��S�Ҕԍ��𕉒S�Ҕԍ��t�B�[���h�iiryoInfoInsurerNo�j�ɕ\������B
		doFindInsurerId(INSURE_TYPE_IRYO);

	}

	/**
	 * �u������I���������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void kaigoInfoPublicExpenseActionPerformed(ActionEvent e)
			throws Exception {

		// �I�����ꂽ����̖@�ʔԍ��iBENEFIT_RATE�j���擾���AkaigoInfoBenefitRate�ɕ\������B
		// �I�����ꂽ����̖@�ʔԍ��iKOHI_LAW_NO�j���擾���AkaigoInfoKohiNo�ɕ\������B
		if (getKaigoInfoPublicExpense().isSelected()) {
			VRMap map = (VRMap) getKaigoInfoPublicExpense().getSelectedItem();
			getKaigoInfoBenefitRate().setText(
					ACCastUtilities.toString(VRBindPathParser.get(
							"BENEFIT_RATE", map)));
			getKaigoInfoKohiNo().setText(
					ACCastUtilities.toString(VRBindPathParser.get(
							"KOHI_LAW_NO", map)));

			// �I�����ꂽ����̋��t�ΏۃT�[�r�X����������B
			int kohiType = ACCastUtilities.toInt(VRBindPathParser.get(
					"KOHI_TYPE", map));
			doFindTargetService(kohiType, INSURE_TYPE_KAIGO);

			// �@�ʔԍ��e�L�X�g��Editable��؂�ւ���B
//			if (kohiType == KAIGO_OTHER_KOHI) {
//				// �u���̑�����v�̏ꍇEditable = true
//				setState_KAIGO_OTHER_ON();
//			} else {
				// �u���̑�����v�ȊO�̏ꍇEditable = false
				setState_KAIGO_OTHER_OFF();
//			}

		} else {
			// �I������Ă��Ȃ��ꍇ
			getKaigoInfoKohiNo().setText("");

			VRList list = new VRArrayList();
			getKaigoServiceTableModel().setAdaptee(list);

			// �@�ʔԍ��e�L�X�g��Editable = false
			setState_KAIGO_OTHER_OFF();

		}
	}

	/**
	 * �u������I���������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void iryoInfoPublicExpenseActionPerformed(ActionEvent e)
			throws Exception {

		// �I�����ꂽ����̖@�ʔԍ��iBENEFIT_RATE�j���擾���AiryoInfoBenefitRate�ɕ\������B
		// �I�����ꂽ����̖@�ʔԍ��iKOHI_LAW_NO�j���擾���AiryoInfoKohiNo�ɕ\������B
		if (getIryoInfoPublicExpense().isSelected()) {
			VRMap map = (VRMap) getIryoInfoPublicExpense().getSelectedItem();
			getIryoInfoBenefitRate().setText(
					ACCastUtilities.toString(VRBindPathParser.get(
							"BENEFIT_RATE", map)));
			getIryoInfoKohiNo().setText(
					ACCastUtilities.toString(VRBindPathParser.get(
							"KOHI_LAW_NO", map)));

			// �I�����ꂽ����̋��t�ΏۃT�[�r�X����������B
			int kohiType = ACCastUtilities.toInt(VRBindPathParser.get(
					"KOHI_TYPE", map));
			doFindTargetService(kohiType, INSURE_TYPE_IRYO);

			// �@�ʔԍ��e�L�X�g��Editable��؂�ւ���B
			if (kohiType == IRYO_OTHER_KOHI) {
				// �u���̑�����v�̏ꍇEditable = true
				setState_IRYO_OTHER_ON();
			} else {
				// �u���̑�����v�ȊO�̏ꍇEditable = false
				setState_IRYO_OTHER_OFF();
			}

		} else {
			// �I������Ă��Ȃ��ꍇ
			getIryoInfoKohiNo().setText("");

			VRList list = new VRArrayList();
			getIryoServiceTableModel().setAdaptee(list);

			// �@�ʔԍ��e�L�X�g��Editable = false
			setState_IRYO_OTHER_OFF();
		}

	}

	/**
	 * �u�N���A�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void shahukuInfoButtonClearActionPerformed(ActionEvent e)
			throws Exception {

		// �N���A����

		if (getShahukuInfoTable().isSelected()) {
			// ��ʃe�[�u���̍s���I������Ă���ꍇ
			// �e�[�u���̑I�����N���A����B
			getShahukuInfoTable().clearSelection();
		} else {
			// ��ʃe�[�u���̍s���I������Ă���ꍇ
			VRMap map = new VRHashMap();
			// �V���ȃ\�[�X�𐶐�����B
			map = (VRMap) getShahukuInfo().createSource();
			getShahukuInfo().setSource(map);
			getShahukuInfo().bindSource();

			// �X�i�b�v�V���b�g
			getSnapShotShahuku().snapshot();

		}

	}

	/**
	 * �u�ǉ������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void shahukuInfoButtonInsertActionPerformed(ActionEvent e)
			throws Exception {

		// ���̓`�F�b�N���s���B
		if (!isValidInput(INSURE_TYPE_SHAHUKU, CHECK_MODE_INSERT)) {
			// ���̓G���[���������ꍇ
			return;
		}

		// ���̓G���[���Ȃ������ꍇ
		// ���HashMap�𐶐����A�\�[�X�Ƃ��Đݒ肷��B
		VRMap map = new VRHashMap();
		getShahukuInfo().setSource(map);

		// ���͂��ꂽ�f�[�^���\�[�X�ɗ������݁A�f�[�^���擾����B
		getShahukuInfo().applySource();

		// �擾������ʏ�̃f�[�^��PATIENT_ID��ݒ肷��B
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));

		// patientKohiList�����������[�v���AKOHI_ID�̍ő�l+1�̒l���擾����B
		int maxId = 0;

		// �ő�l�̎擾
		if (!(getPatientKohiList() == null || getPatientKohiList().size() == 0)) {

			// ��ʃe�[�u���Ɋ��Ƀf�[�^�����݂��Ă���ꍇ
			for (int i = 0; i < getPatientKohiList().size(); i++) {

				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"KOHI_ID", (VRMap) getPatientKohiList().get(i)));

				// ��r�Ώۂ���r�����傫���l�̏ꍇ
				if (maxId < target) {
					// ��r�Ώۂ��r���Ƃ���B
					maxId = target;
				}

			}
		}

		// KOHI_ID��ǉ�����B
		VRBindPathParser.set("KOHI_ID", map, new Integer(maxId + 1));

		// KOHI_TYPE��ǉ�����B
		VRBindPathParser.set("KOHI_TYPE", map, "7701");

		// INSURE_TYPE��ݒ肷��B
		VRBindPathParser.set("INSURE_TYPE", map, new Integer(
				INSURE_TYPE_SHAHUKU));

		// �L�����Ԃ̕t������
		setMaxAndMinDate(map);

		// �e�[�u���\���p�ɕҏW����B
		map = toShahukuTableList(map, "FROM_INPUT");

		// �擾�����f�[�^��patientKohiList�̐V�������R�[�h�Ƃ��Ēǉ�����B
		getPatientKohiList().add(map);

		// ��ʂ̗��p�Ҍ���T�[�r�X���擾�֐����Ăяo���A�߂�l��ArrayList�FList�Ɋi�[����B
		// �E�������FkohiId
		// �E��j�����FINSURE_TYPE_SHAHUKU
		VRList list = getPatientKohiService(maxId + 1, INSURE_TYPE_SHAHUKU);

		// List��patientKohiServiceList�ɒǉ�����B
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				getPatientKohiServiceList().add(list.get(i));
			}
		}

		// patientKohiList���Љ���y���̃f�[�^���擾���A�e�[�u�����f���ɐݒ肷��B
		VRList shahukuKohiList = getListToSetTable(getPatientKohiList(),
				INSURE_TYPE_SHAHUKU);
		getShahukuTableModel().setAdaptee(shahukuKohiList);

		// �ȉ��̏����ň�Ì���e�[�u���̃\�[�g���s���B
		// KOHI_VALID_START�i����L�����ԊJ�n�j DESC
		getShahukuInfoTable().sort("KOHI_VALID_START DESC");

		// �ǉ��s��I��
		int selectedRow = ACBindUtilities.getMatchIndexFromMap(shahukuKohiList,
				"KOHI_ID", map);
		getShahukuInfoTable().setSelectedModelRow(selectedRow);

		// shahukuTableChangeFlg��1�i�ύX����j��������B
		setShahukuTableChangeFlg(1);

	}

	/**
	 * �u�ҏW�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void shahukuInfoButtonConpileActionPerformed(ActionEvent e)
			throws Exception {

		// ���̓`�F�b�N���s���B
		if (!isValidInput(INSURE_TYPE_SHAHUKU, CHECK_MODE_UPDATE)) {
			// ���̓G���[���������ꍇ
			return;
		}

		// ���̓G���[���Ȃ������ꍇ

		// ���͂��ꂽ�f�[�^���擾����B
		VRMap map = new VRHashMap();
		getShahukuInfo().setSource(map);
		getShahukuInfo().applySource();

		// �I���s�̃f�[�^���擾����B
		VRMap temp = (VRMap) getShahukuInfoTable().getSelectedModelRowValue();

		// ��ʏ�ɂȂ��f�[�^���A�e�[�u���̃f�[�^����ڂ��B
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));
		VRBindPathParser.set("KOHI_ID", map, VRBindPathParser.get("KOHI_ID",
				temp));
		VRBindPathParser.set("INSURE_TYPE", map, VRBindPathParser.get(
				"INSURE_TYPE", temp));

		// KOHI_TYPE��ǉ�����B
		VRBindPathParser.set("KOHI_TYPE", map, "7701");

		// �L�����Ԃ̕t������
		setMaxAndMinDate(map);

		// �e�[�u���\���p�ɕҏW����B
		map = toShahukuTableList(map, "FROM_INPUT");

		// �I���f�[�^��patientKohiList�ł̃C���f�b�N�X���擾����B
		int row = ACBindUtilities.getMatchIndexFromMap(getPatientKohiList(),
				"KOHI_ID", temp);

		// ��ʏ�̃f�[�^��ݒ肷��B
		getPatientKohiList().set(row, map);

		// ���R�[�h��KOHI_ID�i�ȉ��AkohiId�j���擾����B
		int kohiId = ACCastUtilities
				.toInt(VRBindPathParser.get("KOHI_ID", map));

		// patientKohiServiceList����AKOHI_ID=kohiId�̃��R�[�h���폜����B
		if (getPatientKohiServiceList() != null) {
			for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
				VRMap patientKohiService = (VRMap) getPatientKohiServiceList()
						.get(i);

				if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
						patientKohiService)) == kohiId) {

					// �폜
					getPatientKohiServiceList().remove(i);

					// �폜�����̂ŃC���f�b�N�X��1�߂��B
					i = i - 1;
				}

			}
		}

		// ��ʂ̗��p�Ҍ���T�[�r�X���擾�֐����Ăяo���A�߂�l��ArrayList�FList�Ɋi�[����B
		// �E�������FkohiId
		// �E��j�����FINSURE_TYPE_SHAHUKU
		VRList list = getPatientKohiService(kohiId, INSURE_TYPE_SHAHUKU);

		// List��patientKohiServiceList�ɒǉ�����B
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				getPatientKohiServiceList().add(list.get(i));
			}
		}

		// patientKohiList���Љ���y���̃f�[�^���擾���A�e�[�u�����f���ɐݒ肷��B
		VRList shahukuKohiList = getListToSetTable(getPatientKohiList(),
				INSURE_TYPE_SHAHUKU);
		getShahukuTableModel().setAdaptee(shahukuKohiList);

		// �ȉ��̏����ŎЉ���y������e�[�u���̃\�[�g���s���B
		// KOHI_VALID_START�i����L�����ԊJ�n�j DESC
		getShahukuInfoTable().sort("KOHI_VALID_START DESC");

		// �I�����Ă����s��I��
		int selectedRow = ACBindUtilities.getMatchIndexFromMap(shahukuKohiList,
				"KOHI_ID", map);
		getShahukuInfoTable().setSelectedModelRow(selectedRow);

		// shahukuTableChangeFlg��1�i�ύX����j��������B
		setShahukuTableChangeFlg(1);
	}

	/**
	 * �u�폜�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void shahukuInfoButtonDeleteActionPerformed(ActionEvent e)
			throws Exception {

		// �m�F���b�Z�[�W��\������B
		// �E���b�Z�[�WID�FWARNING_OF_DELETE_SELECTION
		if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() == ACMessageBox.RESULT_OK) {
			// �u�͂��v��I�������ꍇ

			// �I������Ă���f�[�^�̉�ʏ�̃C���f�b�N�X��ޔ�����B
			int sortedRow = getShahukuInfoTable().getSelectedSortedRow();

			// �I���f�[�^��KOHI_ID��ޔ�����B
			VRMap map = (VRMap) getShahukuInfoTable()
					.getSelectedModelRowValue();
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					map));

			// �I���s�f�[�^�̍폜
			int selectedRow = ACBindUtilities.getMatchIndexFromMap(
					getPatientKohiList(), "KOHI_ID", map);
			getPatientKohiList().remove(selectedRow);

			// patientKohiList���Љ���y���̃f�[�^���擾���A�e�[�u�����f���ɐݒ肷��B
			VRList shahukuKohiList = getListToSetTable(getPatientKohiList(),
					INSURE_TYPE_SHAHUKU);
			getShahukuTableModel().setAdaptee(shahukuKohiList);

			// �I������Ă��郌�R�[�h��KOHI_ID�ŉ��L�̃��R�[�h�W�����������A�Y�����R�[�h���폜����B
			// �EpatientKohiServiceList
			if (getPatientKohiServiceList() != null) {
				for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
					VRMap patientKohiService = (VRMap) getPatientKohiServiceList()
							.get(i);

					if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
							patientKohiService)) == kohiId) {
						getPatientKohiServiceList().remove(i);

						// �폜�����̂ŃC���f�b�N�X��1�߂��B
						i = i - 1;
					}
				}
			}

			// �폜���ꂽ�s��1�s���I������B
			getShahukuInfoTable().setSelectedSortedRowOnAfterDelete(sortedRow);

			// kaigoTableChangeFlg��1�i�ύX����j��������B
			setShahukuTableChangeFlg(1);

		}

	}

	/**
	 * �u�Љ���y�����W�J�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void shahukuInfoTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		VRMap map = new VRHashMap();

		if (!getShahukuInfoTable().isSelected()) {
			// ��ʃe�[�u���̍s���I������Ă��Ȃ��ꍇ

			// �V���ȃ\�[�X�𐶐�����B
			map = (VRMap) getShahukuInfo().createSource();
			getShahukuInfo().setSource(map);
			getShahukuInfo().bindSource();

			// Enable������s���B
			// �E���ID�FENABLE_SHAHUKU_BUTTON_FALSE
			setState_ENABLE_SHAHUKU_BUTTON_FALSE();

		} else {
			// ��ʃe�[�u���̍s���I������Ă���ꍇ

			// �I������Ă��郌�R�[�h���A�u�Љ���y���̈�E���2�ishahukuInfo�j�v�ɐݒ肷��B
			map = (VRMap) getShahukuInfoTable().getSelectedModelRowValue();
			getShahukuInfo().setSource(map);

			// ��ʂɓW�J����B
			getShahukuInfo().bindSource();

			// �I�����ꂽ��������KOHI_ID���擾���Aint�FkohiId�Ɋi�[����B
			// ���p�Ҍ���T�[�r�X������ʂɓW�J����B
			// �E�������FkohiId
			// �E��j�����FINSURE_TYPE_SHAHUKU
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					map));

			setPatientKohiService(kohiId, INSURE_TYPE_SHAHUKU);

			// Enable������s���B
			// �E���ID�FENABLE_SHAHUKU_BUTTON_TRUE
			setState_ENABLE_SHAHUKU_BUTTON_TRUE();

		}

		// �X�i�b�v�V���b�g
		getSnapShotShahuku().snapshot();

	}

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		param.setData("PATIENT_ID", new Integer(40));
		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QU004.class.getName(), param));
	}

	// �����֐�

	/**
	 * �u���R�[�h�擾�E��ʐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFind() throws Exception {
		// ���R�[�h�擾�E��ʐݒ�

		// �n���ꂽ���p��ID��p���āA���p�Ҋ�{�����擾����B
		VRList patientList = QkanCommon.getPatientInfo(getDBManager(),
				getPatientId());

		// ���p�Ҋ�{��񂪎擾�ł��Ȃ������ꍇ
		if (patientList == null || patientList.size() == 0) {
			// ��O�������s���B���̃��W�b�N��ʂ�͓̂���ʂɑJ�ڂ���Ԃ�
			// ���p��(PATIENT)���폜���ꂽ�ꍇ�ł��邽�߁B
			// �G���[���b�Z�[�W��\������B
			// �E���b�Z�[�WID�FERROR_OF_PASSIVE_CHECK_ON_FIND
			QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();

			// �����߂�t���O��1��������B
			setCompulsoryBackFlg(1);

			// �O��ʂ֑J�ڂ���B
			ACFrame.getInstance().back();
			return;
		}

		// �p�b�V�u�`�F�b�N�p�ɑޔ�����B
		getPassiveChecker()
				.reservedPassive(getPASSIVE_CHECK_KEY(), patientList);

		// �擾�������p�ҏ����A�ȉ��̃t�B�[���h�̒l���擾����B
		// �EPATIENT_FAMILY_NAME
		// �EPATIENT_FIRST_NAME
		String patientFamilyName = ACCastUtilities.toString(VRBindPathParser
				.get("PATIENT_FAMILY_NAME", (VRMap) patientList.get(0)));
		String patientFirstName = ACCastUtilities.toString(VRBindPathParser
				.get("PATIENT_FIRST_NAME", (VRMap) patientList.get(0)));

		// ��L�̒l���������āApatientName�ɕ\������B
		getPatientName().setText(
				QkanCommon.toFullName(patientFamilyName, patientFirstName));

		// ���p�Ҍ�������擾����B
		doFindPatientKohi();

		// ���p�Ҍ���T�[�r�X�����擾����B
		doFindPatientKohiService();

		// patientKohiList����������iINSURE_TYPE = INSURE_TYPE_KAIGO�̃��R�[�h�j
		// �𒊏o���AkaigoKohiList�Ɋi�[����B
		// patientKohiList����Ì�����iINSURE_TYPE = INSURE_TYPE_IRYO�̃��R�[�h�j
		// �𒊏o���AiryoKohiList�Ɋi�[����B
		VRList kaigoKohiList = new VRArrayList();
		VRList iryoKohiList = new VRArrayList();
		VRList shahukuKohiList = new VRArrayList();

		if (!(getPatientKohiList() == null || getPatientKohiList().size() == 0)) {
			for (int i = 0; i < getPatientKohiList().size(); i++) {

				VRMap temp = (VRMap) getPatientKohiList().get(i);

				if (ACCastUtilities.toInt(VRBindPathParser.get("INSURE_TYPE",
						temp)) == INSURE_TYPE_KAIGO) {

					toKohiTableList(temp);
					kaigoKohiList.add(temp);

				} else if (ACCastUtilities.toInt(VRBindPathParser.get(
						"INSURE_TYPE", temp)) == INSURE_TYPE_IRYO) {

					toKohiTableList(temp);
					iryoKohiList.add(temp);

				} else if (ACCastUtilities.toInt(VRBindPathParser.get(
						"INSURE_TYPE", temp)) == INSURE_TYPE_SHAHUKU) {

					toShahukuTableList(temp, "FROM_DB");
					shahukuKohiList.add(temp);

				}
			}
		}

		// ���p�҉�������ikaigoKohiList�j��kaigoTableModel�ɐݒ肷��B
		getKaigoTableModel().setAdaptee(kaigoKohiList);

		if (!(kaigoKohiList == null || kaigoKohiList.size() == 0)) {
			// ������e�[�u����1���ȏヌ�R�[�h�����݂���ꍇ
			// ������e�[�u����1��ڂ�I��������Ԃɂ���B
			getKaigoInfoTable().setSelectedSortedFirstRow();

			// processMode�ɋ��ʒ萔��PROCESS_MODE_UPDATE��������B
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

		} else {
			// ������e�[�u���̃��R�[�h��0���̏ꍇ
			// ��������̈�̏����l�쐬
			VRMap defaultMap = (VRMap) getKaigoInfo().createSource();
			// �̈�̃N���A
			getKaigoInfo().setSource(defaultMap);
			getKaigoInfo().bindSource();

			// Enable������s���B
			// �E���ID�FENABLE_KAIGO_BUTTON_FALSE
			setState_ENABLE_KAIGO_BUTTON_FALSE();
		}

		// ���p�҈�Ì�����iiryoKohiList�j��iryoTableModel�ɐݒ肷��B
		getIryoTableModel().setAdaptee(iryoKohiList);

		if (!(iryoKohiList == null || iryoKohiList.size() == 0)) {
			// ��Ì���e�[�u����1���ȏヌ�R�[�h�����݂���ꍇ
			// ��Ì���e�[�u����1��ڂ�I��������Ԃɂ���B
			getIryoInfoTable().setSelectedSortedFirstRow();

			// processMode�ɋ��ʒ萔��PROCESS_MODE_UPDATE��������B
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

		} else {
			// ��Ì���e�[�u���̃��R�[�h��0���̏ꍇ
			// ��Ì�����̏����l�쐬
			VRMap defaultMap = (VRMap) getIryoInfo().createSource();
			// �̈�̃N���A
			getIryoInfo().setSource(defaultMap);
			getIryoInfo().bindSource();

			// Enable������s���B
			// �E���ID�FENABLE_IRYO_BUTTON_FALSE
			setState_ENABLE_IRYO_BUTTON_FALSE();
		}

		// �Љ���y��������ishahukuKohiList�j��shahukuTableModel�ɐݒ肷��B
		getShahukuTableModel().setAdaptee(shahukuKohiList);

		if (!(shahukuKohiList == null || shahukuKohiList.size() == 0)) {
			// �Љ���y���e�[�u����1���ȏヌ�R�[�h�����݂���ꍇ
			// �Љ���y���e�[�u����1��ڂ�I��������Ԃɂ���B
			getShahukuInfoTable().setSelectedSortedFirstRow();

			// processMode�ɋ��ʒ萔��PROCESS_MODE_UPDATE��������B
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

		} else {
			// �Љ���y���e�[�u���̃��R�[�h��0���̏ꍇ
			// �Љ���y�����̈�̏����l�쐬
			VRMap defaultMap = (VRMap) getShahukuInfo().createSource();
			// �̈�̃N���A
			getShahukuInfo().setSource(defaultMap);
			getShahukuInfo().bindSource();

			// Enable������s���B
			// �E���ID�FENABLE_SHAHUKU_BUTTON_FALSE
			setState_ENABLE_SHAHUKU_BUTTON_FALSE();
		}

		// �Ɩ��{�^���̏�Ԑݒ�
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// �V�K���[�h�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�j�̏ꍇ
			// �Ɩ��{�^���̏�Ԑݒ���s���B
			// ����ID�FINSERT_MODE
			setState_INSERT_MODE();
		} else {
			// �X�V���[�h�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�j�̏ꍇ
			// �Ɩ��{�^���̏�Ԑݒ���s���B
			// ����ID�FUPDATE_MODE
			setState_UPDATE_MODE();
		}

		// �t�H�[�J�X
		getKaigoInfoPublicExpense().requestFocus();

		// �X�i�b�v�V���b�g
		getSnapShotKaigo().snapshot();
		getSnapShotIryo().snapshot();
		getSnapShotShahuku().snapshot();

	}

	/**
	 * �u���p�Ҍ�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFindPatientKohi() throws Exception {
		// DB�iPATIENT_KOHI�j��藘�p�Ҍ�������擾����B

		// SQL���i�[�p
		String strSql = "";

		// SQL���擾�̂��߂�HashMap�Fparam�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
		VRMap param = new VRHashMap();

		// �EPATIENT_ID/patientId
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

		// ���p�Ҍ�������擾����B
		strSql = getSQL_GET_PATIENT_KOHI(param);
		VRList temp = getDBManager().executeQuery(strSql);

		// patientKohiList�Ɋi�[����B
		setPatientKohiList(temp);

		// patientKohiList���p�b�V�u�`�F�b�N�p�ɑޔ�����B
		// getPassiveChecker().reservedPassive(
		// getPASSIVE_CHECK_KEY_KOHI(), getPatientKohiList());

		// ���p�Ҍ�����̃��R�[�h��1���ȏ�̏ꍇ
		if (!(getPatientKohiList() == null || getPatientKohiList().size() == 0)) {
			// kohiDataFlg��1��������B
			setKohiDataFlg(1);
		}
	}

	/**
	 * �u���p�Ҍ���T�[�r�X���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFindPatientKohiService() throws Exception {
		// DB�iPATIENT_KOHI_SERVICE�j��藘�p�Ҍ���T�[�r�X�����擾����B

		// SQL���i�[�p
		String strSql = "";

		// SQL���擾�̂��߂�HashMap�Fparam�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
		VRMap param = new VRHashMap();

		// �EPATIENT_ID/patientId
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

		// ���p�Ҍ���T�[�r�X�����擾���ApatientKohiServiceList�Ɋi�[����B
		strSql = getSQL_GET_PATIENT_KOHI_SERVICE(param);
		setPatientKohiServiceList(getDBManager().executeQuery(strSql));

		// // patientKohiServiceList���p�b�V�u�`�F�b�N�p�ɑޔ�����B
		// getPassiveChecker().reservedPassive(
		// getPASSIVE_CHECK_KEY_KOHI_SERVICE(), getPatientKohiServiceList());

		// ���p�Ҍ���T�[�r�X���̃��R�[�h��1���ȏ�̏ꍇ
		if (!(getPatientKohiServiceList() == null || getPatientKohiServiceList()
				.size() == 0)) {
			// kohiServiceDataFlg��1��������B
			setKohiServiceDataFlg(1);
		}
	}

	/**
	 * �u���S�Җ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFindInsurerName(int insureType) throws Exception {

		// ���S�Җ��������s���B

		// ���͂��ꂽ���S�Ҕԍ����擾����B
		String insurerId = "";

		if (insureType == INSURE_TYPE_KAIGO) {
			// ���̏ꍇ
			insurerId = getKaigoInfoInsurerNo().getText();
		} else if (insureType == INSURE_TYPE_IRYO) {
			// ��Â̏ꍇ
			insurerId = getIryoInfoInsurerNo().getText();
		}

		// ���S�Ҕԍ��ŕ��S�ҏ��iinsurerList�j����������B
		VRMap map = (VRMap) ACBindUtilities.getMatchRowFromValue(
				getInsurerList(), "INSURER_ID", insurerId);

		// ���S�Җ���\������B
		if (insureType == INSURE_TYPE_KAIGO) {
			// ���̏ꍇ�A���S�Җ��R���{�ikaigoInfoBearName�j�ɐݒ肷��B
			getKaigoInfoBearName().setSelectedItem(map);
		} else if (insureType == INSURE_TYPE_IRYO) {
			// ��Â̏ꍇ�A���S�Җ��R���{�iiryoInfoBearName�j�ɐݒ肷��B
			getIryoInfoBearName().setSelectedItem(map);
		}

	}

	/**
	 * �u���S�Ҕԍ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFindInsurerId(int insureType) throws Exception {

		// ���S�Ҕԍ��������s���B
		VRMap map = new VRHashMap();

		if (insureType == INSURE_TYPE_KAIGO) {
			// ���̏ꍇ
			map = (VRMap) getKaigoInfoBearName().getSelectedModelItem();

			if (VRBindPathParser.get("INSURER_ID", map) != null) {
				getKaigoInfoInsurerNo().setText(
						ACCastUtilities.toString(VRBindPathParser.get(
								"INSURER_ID", map)));
			}
		} else if (insureType == INSURE_TYPE_IRYO) {
			// ��Â̏ꍇ
			map = (VRMap) getIryoInfoBearName().getSelectedModelItem();

			if (VRBindPathParser.get("INSURER_ID", map) != null) {
				getIryoInfoInsurerNo().setText(
						ACCastUtilities.toString(VRBindPathParser.get(
								"INSURER_ID", map)));
			}
		}

	}

	/**
	 * �u���t�ΏۃT�[�r�X�����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFindTargetService(int kohiType, int insureType)
			throws Exception {

		// ���t�ΏۃT�[�r�X�������s���B

		// VRList list�𐶐�����B
		VRList list = new VRArrayList();
		// �\�[�g�pTreeMap
		TreeMap sortMap = new TreeMap();

		// masterKohiServiceList�̌��������[�v����B
		if (getMasterKohiServiceList() == null) {
			return;
		}

		for (int i = 0; i < getMasterKohiServiceList().size(); i++) {

			VRMap temp = (VRMap) getMasterKohiServiceList().get(i);

			if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_TYPE", temp)) == kohiType) {

				// KOHI_TYPE == kohiType�̃��R�[�h��SYSTEM_SERVICE_KIND_DETAIL���擾����B
				int systemServiceKindDetail = ACCastUtilities
						.toInt(VRBindPathParser.get(
								"SYSTEM_SERVICE_KIND_DETAIL", temp));

				// systemServiceKindDetail��p���āAmasterService��背�R�[�h���擾����B
				if (VRBindPathParser.has(new Integer(systemServiceKindDetail),
						getMasterService())) {
					VRMap map = (VRMap) VRBindPathParser.get(new Integer(
							systemServiceKindDetail), getMasterService());

					// map��CHECK_VALUE������������B
					// �f�t�H���g�F�`�F�b�NON
					// 2006/09/07 replacle begin kamitsukasa
					try{
						// �������̗�O�Ή�
						VRBindPathParser.set("CHECK_VALUE", map, new Boolean(
								true));
					}catch(Exception ex){
						
					}
					// 2006/09/07 replacle end kamitsukasa
					
					// sortMap�ɒǉ��i�L�[�FSERVICE_SORT�j
					sortMap.put(ACCastUtilities.toInteger(VRBindPathParser.get(
							"SERVICE_SORT", map)), map);

				}
			}
		}

		// sortMap��背�R�[�h�W�����쐬
		list.addAll(sortMap.values());

		if (insureType == INSURE_TYPE_KAIGO) {
			// ���̏ꍇ�iinsureType == INSURE_TYPE_KAIGO �̏ꍇ�j
			// list��kaigoServiceTableModel�ɃZ�b�g����B
			getKaigoServiceTableModel().setAdaptee(list);

		} else if (insureType == INSURE_TYPE_IRYO) {
			// ��Â̏ꍇ�iinsureType == INSURE_TYPE_IRYO �̏ꍇ�j
			// list��iryoServiceTableModel�ɃZ�b�g����B
			getIryoServiceTableModel().setAdaptee(list);
		} else {
			// ��Â̏ꍇ�iinsureType == INSURE_TYPE_SHAHUKU �̏ꍇ�j
			// list��shahukuServiceTableModel�ɃZ�b�g����B
			getShahukuServiceTableModel().setAdaptee(list);
		}

	}

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean isValidInput(int insureType, int checkMode) throws Exception {

		// ���̓`�F�b�N���s���B
		String msgParam1 = "";
		String msgParam2 = "";
		String msgParam3 = "";
		String temp = "";

		VRMap map = null;
		// ������
		int kohiType;
		// ���t��
		int benefitRate;
		// �L�����ԊJ�n
		Date start;
		// �L�����ԏI��
		Date end;

		if (insureType == INSURE_TYPE_KAIGO) {
			// ���̏ꍇ

			// �E������ikaigoInfoPublicExpense�j
			// �I������Ă��邩�ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"������"��������B
			if (!getKaigoInfoPublicExpense().isSelected()) {
				getKaigoInfoPublicExpense().requestFocus();
				msgParam1 = "������";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
						msgParam1);
				return false;
			}

			// �E���t���ikaigoInfoBenefitRate�j
			// ���͂���Ă��邩�ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���t��"��������B
			if (ACTextUtilities.isNullText(getKaigoInfoBenefitRate().getText())) {
				getKaigoInfoBenefitRate().requestFocus();
				msgParam1 = "���t��";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// �E���t���ikaigoInfoBenefitRate�j
			// ���͂���Ă���f�[�^���`�F�b�N����B
			// ���Љ���y���Ɋւ��Ă͓��`�F�b�N�͍s��Ȃ��B
			// ��ʏ�̃f�[�^���擾����B
			map = new VRHashMap();
			getKaigoInfo().setSource(map);
			getKaigoInfo().applySource();
			// �����ގ擾
			kohiType = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_TYPE",
					map));
			benefitRate = ACCastUtilities.toInt(VRBindPathParser.get(
					"BENEFIT_RATE", map));
			if (benefitRate <= 90 || benefitRate > 100) {
				getKaigoInfoBenefitRate().requestFocus();
				QkanMessageList.getInstance()
						.QU004_ERROR_OF_BENEFIT_RATE_VALUE();
				return false;
			}

			// �E����@�ʔԍ��ikaigoInfoKohiNo�j
			// ���͂���Ă��邩�ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�@�ʔԍ�"��������B
			if (ACTextUtilities.isNullText(getKaigoInfoKohiNo().getText())) {
				getKaigoInfoKohiNo().requestFocus();
				msgParam1 = "�@�ʔԍ�";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
			
			// ������2�����ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�󋋎Ҕԍ�"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"7"��������B
			temp = getKaigoInfoKohiNo().getText();
			if (temp.length() != 2) {
				getKaigoInfoKohiNo().requestFocus();
				msgParam1 = "�@�ʔԍ�";
				msgParam2 = "2";
				QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
						msgParam2);
				return false;
			}
			
			// �E���S�Ҕԍ��ikaigoInfoInsurerNo�j
			// ���͂���Ă��邩�ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���S�Ҕԍ�"��������B
			if (ACTextUtilities.isNullText(getKaigoInfoInsurerNo().getText())) {
				getKaigoInfoInsurerNo().requestFocus();
				msgParam1 = "���S�Ҕԍ�";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// �E���S�Ҕԍ��ikaigoInfoInsurerNo�j
			// ������6�����ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"���S�Ҕԍ�"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"6"��������B
			// temp = getKaigoInfoInsurerNo().getText();
			// if(temp.length() != 6){
			// getKaigoInfoInsurerNo().requestFocus();
			// msgParam1 = "���S�Ҕԍ�";
			// msgParam2 = "6";
			// QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
			// msgParam2);
			// return false;
			// }

			// �E���S�Җ��ikaigoInfoBearName�j
			// �I������Ă��邩�ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���S�Җ�"��������B
			// if(!getKaigoInfoBearName().isSelected()){
			// getKaigoInfoBearName().requestFocus();
			// msgParam1 = "���S�Җ�";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
			// return false;
			// }

			// �E�󋋎Ҕԍ��ikaigoInfoReceiptNo�j
			// ���͂���Ă��邩�ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�󋋎Ҕԍ�"��������B
			if (ACTextUtilities.isNullText(getKaigoInfoReceiptNo().getText())) {
				getKaigoInfoReceiptNo().requestFocus();
				msgParam1 = "�󋋎Ҕԍ�";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// �E�󋋎Ҕԍ��ikaigoInfoReceiptNo�j
			// ������7�����ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�󋋎Ҕԍ�"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"7"��������B
			temp = getKaigoInfoReceiptNo().getText();
			if (temp.length() != 7) {
				getKaigoInfoReceiptNo().requestFocus();
				msgParam1 = "�󋋎Ҕԍ�";
				msgParam2 = "7";
				QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
						msgParam2);
				return false;
			}

			// // �E�L�����ԊJ�n�ikaigoInfoValidLimit1�j
			// // ���͂���Ă��邩�ǂ����B
			// // ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԊJ�n��"��������B
			// if(ACTextUtilities.isNullText(getKaigoInfoValidLimit1().getText())){
			// getKaigoInfoValidLimit1().requestFocus();
			// msgParam1 = "�L�����ԊJ�n��";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
			// return false;
			// }

			// �E�L�����ԊJ�n�ikaigoInfoValidLimit1�j
			// ���͂���Ă�����t�����݂��邩�B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԊJ�n����"��������B
			if (!ACTextUtilities
					.isNullText(getKaigoInfoValidLimit1().getText())) {
				if (!getKaigoInfoValidLimit1().isValidDate()) {
					getKaigoInfoValidLimit1().requestFocus();
					msgParam1 = "�L�����ԊJ�n����";
					QkanMessageList.getInstance()
							.ERROR_OF_WRONG_DATE(msgParam1);
					return false;
				}
			}

			// // �E�L�����ԊJ�n�ikaigoInfoValidLimit1�j
			// // �����̓��t�����͂���Ă��邩�B
			// // ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�J�n"��������B
			// // ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"����"��������B
			// start = getKaigoInfoValidLimit1().getDate();
			// if(ACDateUtilities.compareOnDay(start,
			// ACDateUtilities.toFirstDayOfMonth(start)) != 0){
			// getKaigoInfoValidLimit1().requestFocus();
			// msgParam1 = "�J�n";
			// msgParam2 = "����";
			// QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD(msgParam1,
			// msgParam2);
			// return false;
			// }

			// // �E�L�����ԏI���ikaigoInfoValidLimit2�j
			// // ���͂���Ă��邩�ǂ����B
			// // ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԏI����"��������B
			// if(ACTextUtilities.isNullText(getKaigoInfoValidLimit2().getText())){
			// getKaigoInfoValidLimit2().requestFocus();
			// msgParam1 = "�L�����ԏI����";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
			// return false;
			// }

			// �E�L�����ԏI���ikaigoInfoValidLimit2�j
			// ���͂���Ă�����t�����݂��邩�B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԏI������"��������B
			if (!ACTextUtilities
					.isNullText(getKaigoInfoValidLimit2().getText())) {
				if (!getKaigoInfoValidLimit2().isValidDate()) {
					getKaigoInfoValidLimit2().requestFocus();
					msgParam1 = "�L�����ԏI������";
					QkanMessageList.getInstance()
							.ERROR_OF_WRONG_DATE(msgParam1);
					return false;
				}
			}

			// // �E�L�����ԏI���ikaigoInfoValidLimit2�j
			// // �����̓��t�����͂���Ă��邩�B
			// // ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�I��"��������B
			// // ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"����"��������B
			// end = getKaigoInfoValidLimit2().getDate();
			// if(ACDateUtilities.compareOnDay(end,
			// ACDateUtilities.toLastDayOfMonth(end)) != 0){
			// getKaigoInfoValidLimit2().requestFocus();
			// msgParam1 = "�I��";
			// msgParam2 = "����";
			// QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD(msgParam1,
			// msgParam2);
			// return false;
			// }

			// �E�L�����ԊJ�n�ikaigoInfoValidLimit1�j
			// �E�L�����ԏI���ikaigoInfoValidLimit2�j
			// �O��֌W�̃`�F�b�N
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�L�����Ԃ�"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"�J�n��"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam3��錾���A"�I����"��������B
			if (!(ACTextUtilities.isNullText(getKaigoInfoValidLimit1()
					.getText()))
					&& !(ACTextUtilities.isNullText(getKaigoInfoValidLimit2()
							.getText()))) {

				start = getKaigoInfoValidLimit1().getDate();
				end = getKaigoInfoValidLimit2().getDate();

				if (ACDateUtilities.compareOnDay(start, end) > 0) {
					getKaigoInfoValidLimit1().requestFocus();
					msgParam1 = "�L�����Ԃ�";
					msgParam2 = "�J�n��";
					msgParam3 = "�I����";
					QkanMessageList.getInstance()
							.ERROR_OF_GREATER_DATE_RELATION(msgParam1,
									msgParam2, msgParam3);
					return false;
				}
			}

			// ��������̗L�����Ԃ��d�����Ă��Ȃ����`�F�b�N����B
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"����E�y��"��������B
			// ��ʏ�̃f�[�^���擾����B
			map = new VRHashMap();
			getKaigoInfo().setSource(map);
			getKaigoInfo().applySource();

			// ��������擾����B
			VRList tempKaigoKohiList = (VRList) getKaigoTableModel()
					.getAdaptee();
			VRList kaigoKohiList = new VRArrayList();

			if (checkMode == CHECK_MODE_INSERT) {
				// �ǉ����[�h�̏ꍇ
				kaigoKohiList = tempKaigoKohiList;
			} else if (checkMode == CHECK_MODE_UPDATE) {
				// �ҏW���[�h�̏ꍇ�A���g�̗����͔�΂��B
				for (int i = 0; i < tempKaigoKohiList.size(); i++) {
					if (i == getKaigoInfoTable().getSelectedModelRow()) {
						continue;
					}
					kaigoKohiList.add(tempKaigoKohiList.get(i));
				}
			}

			// ������̗����̂����ŐV�̂��̂̃C���f�b�N�X���擾����i�L�[�FKOHI_TYPE, KOHI_LAW_NO�j
			int newHistoryIndex = getIndexNewHistory(ACCastUtilities
					.toInt(VRBindPathParser.get("KOHI_TYPE", map)),
					ACCastUtilities.toString(VRBindPathParser.get(
							"KOHI_LAW_NO", map)), kaigoKohiList);
			int duplicateTermCheckResult = isDuplicateTerm(map, kaigoKohiList,
					newHistoryIndex);

			if (duplicateTermCheckResult == RESULT_TRUE) {
				getKaigoInfoPublicExpense().requestFocus();
				msgParam1 = "����";
				QkanMessageList.getInstance()
						.QU004_ERROR_OF_DUPLICATE_KOHI_TERM(msgParam1);
				return false;
			}

			// ��������ikaigoKohiList�j�̓������ɂ�����ΏۃT�[�r�X�ɂ��ă`�F�b�N����B
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"3"��������B
			// ���Љ���y���Ɋւ��Ă͓��`�F�b�N�͍s��Ȃ��B
			kohiType = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_TYPE",
					map));
			if (!doCheckKaigoKohi(checkMode)) {
				// �������ɁA����̒��[��ނ̃T�[�r�X��I������������4���ȏ゠�����ꍇ
				getKaigoInfoPublicExpense().requestFocus();
				msgParam1 = "3";
				QkanMessageList.getInstance().QU004_ERROR_ON_KOHI_OVER_LIMIT(
						msgParam1);
				return false;
			}

			// �Ō�̗����̗L�����ԏI����ύX�\�ȏꍇ
			if (duplicateTermCheckResult == RESULT_CHANGEABLE) {
				// �m�F���b�Z�[�W��\������B
				// �E���b�Z�[�WID�FWARNING_OF_DUPLICATE_TERM
				msgParam1 = "����";
				switch (QkanMessageList.getInstance()
						.WARNING_OF_DUPLICATE_TERM(msgParam1)) {
				case ACMessageBox.RESULT_OK:
					// �uOK�v���I�����ꂽ�ꍇ
					// �␳
					changeSpanEnd(map, kaigoKohiList, newHistoryIndex);
					break;
				case ACMessageBox.RESULT_CANCEL:
					// �u�L�����Z���v���I�����ꂽ�ꍇ
					// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
					getKaigoInfoValidLimit1().requestFocus();
					// �߂�l�Ƃ���false��Ԃ��B
					return false;
				}
			}

		} else if (insureType == INSURE_TYPE_IRYO) {
			// ��Â̏ꍇ

			// �E������iiryoInfoPublicExpense�j
			// �I������Ă��邩�B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"������"��������B
			if (!getIryoInfoPublicExpense().isSelected()) {
				getIryoInfoPublicExpense().requestFocus();
				msgParam1 = "������";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
						msgParam1);
				return false;
			}

			// �E���t���iiryoInfoBenefitRate�j
			// ���͂���Ă��邩�ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���t��"��������B
			if (ACTextUtilities.isNullText(getIryoInfoBenefitRate().getText())) {
				getIryoInfoBenefitRate().requestFocus();
				msgParam1 = "���t��";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// �E���t���iiryoInfoBenefitRate�j
			// ���͂���Ă���f�[�^���`�F�b�N����B
			benefitRate = ACCastUtilities.toInt(getIryoInfoBenefitRate()
					.getText());

			//
			// ��Ì���̉��������P�p
			//
			// if (benefitRate <= 90 || benefitRate > 100) {
			if (benefitRate > 100) {
				getIryoInfoBenefitRate().requestFocus();
				msgParam1 = "���t��";
				msgParam2 = "100";
				QkanMessageList.getInstance().ERROR_OF_VALUE_TOO_MUCH(
						msgParam1, msgParam2);
				return false;
			}

			// �E����@�ʔԍ��iiryoInfoKohiNo�j
			// ���͂���Ă��邩�ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�@�ʔԍ�"��������B
			if (ACTextUtilities.isNullText(getIryoInfoKohiNo().getText())) {
				getIryoInfoKohiNo().requestFocus();
				msgParam1 = "�@�ʔԍ�";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// ������2�����ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�󋋎Ҕԍ�"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"7"��������B
			temp = getIryoInfoKohiNo().getText();
			if (temp.length() != 2) {
				getIryoInfoKohiNo().requestFocus();
				msgParam1 = "�@�ʔԍ�";
				msgParam2 = "2";
				QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
						msgParam2);
				return false;
			}
			
			// �E���S�Ҕԍ��iiryoInfoInsurerNo�j
			// ���͂���Ă��邩�ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���S�Ҕԍ�"��������B
			if (ACTextUtilities.isNullText(getIryoInfoInsurerNo().getText())) {
				getIryoInfoInsurerNo().requestFocus();
				msgParam1 = "���S�Ҕԍ�";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// �E���S�Ҕԍ��iiryoInfoInsurerNo�j
			// ������6�����ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"���S�Ҕԍ�"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"6"��������B
			// temp = getIryoInfoInsurerNo().getText();
			// if(temp.length() != 6){
			// getIryoInfoInsurerNo().requestFocus();
			// msgParam1 = "���S�Ҕԍ�";
			// msgParam2 = "6";
			// QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
			// msgParam2);
			// return false;
			// }

			// �E���S�Җ��iiryoInfoBearName�j
			// �I������Ă��邩�B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���S�Җ�"��������B
			// if(!getIryoInfoBearName().isSelected()){
			// getIryoInfoBearName().requestFocus();
			// msgParam1 = "���S�Җ�";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
			// return false;
			// }

			// �E�󋋎Ҕԍ��iiryoInfoReceiptNo�j
			// ���͂���Ă��邩�ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�󋋎Ҕԍ�"��������B
			if (ACTextUtilities.isNullText(getIryoInfoReceiptNo().getText())) {
				getIryoInfoReceiptNo().requestFocus();
				msgParam1 = "�󋋎Ҕԍ�";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// �E�󋋎Ҕԍ��iiryoInfoReceiptNo�j
			// ������7�����ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�󋋎Ҕԍ�"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"7"��������B
			temp = getIryoInfoReceiptNo().getText();
			if (temp.length() != 7) {
				getIryoInfoReceiptNo().requestFocus();
				msgParam1 = "�󋋎Ҕԍ�";
				msgParam2 = "7";
				QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
						msgParam2);
				return false;
			}

			// // �E�L�����ԊJ�n�iiryoInfoValidLimit1�j
			// // ���͂���Ă��邩�ǂ����B
			// // ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԊJ�n��"��������B
			// if(ACTextUtilities.isNullText(getIryoInfoValidLimit1().getText())){
			// getIryoInfoValidLimit1().requestFocus();
			// msgParam1 = "�L�����ԊJ�n��";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
			// return false;
			// }

			// �E�L�����ԊJ�n�iiryoInfoValidLimit1�j
			// ���͂���Ă�����t�����݂��邩�B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԊJ�n����"��������B
			if (!ACTextUtilities.isNullText(getIryoInfoValidLimit1().getText())) {
				if (!getIryoInfoValidLimit1().isValidDate()) {
					getIryoInfoValidLimit1().requestFocus();
					msgParam1 = "�L�����ԊJ�n����";
					QkanMessageList.getInstance()
							.ERROR_OF_WRONG_DATE(msgParam1);
					return false;
				}
			}

			// // �E�L�����ԊJ�n�iiryoInfoValidLimit1�j
			// // �����̓��t�����͂���Ă��邩�B
			// // ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�J�n"��������B
			// // ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"����"��������B
			// start = getIryoInfoValidLimit1().getDate();
			// if(ACDateUtilities.compareOnDay(start,
			// ACDateUtilities.toFirstDayOfMonth(start)) != 0){
			// getIryoInfoValidLimit1().requestFocus();
			// msgParam1 = "�J�n";
			// msgParam2 = "����";
			// QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD(msgParam1,
			// msgParam2);
			// return false;
			// }

			// // �E�L�����ԏI���iiryoInfoValidLimit2�j
			// // ���͂���Ă��邩�ǂ����B
			// // ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԏI����"��������B
			// if(ACTextUtilities.isNullText(getIryoInfoValidLimit2().getText())){
			// getIryoInfoValidLimit2().requestFocus();
			// msgParam1 = "�L�����ԏI����";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
			// return false;
			// }

			// �E�L�����ԏI���iiryoInfoValidLimit2�j
			// ���͂���Ă�����t�����݂��邩�B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԏI������"��������B
			if (!ACTextUtilities.isNullText(getIryoInfoValidLimit2().getText())) {
				if (!getIryoInfoValidLimit2().isValidDate()) {
					getIryoInfoValidLimit2().requestFocus();
					msgParam1 = "�L�����ԏI������";
					QkanMessageList.getInstance()
							.ERROR_OF_WRONG_DATE(msgParam1);
					return false;
				}
			}

			// // �E�L�����ԏI���iiryoInfoValidLimit2�j
			// // �����̓��t�����͂���Ă��邩�B
			// // ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�I��"��������B
			// // ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"����"��������B
			// end = getIryoInfoValidLimit2().getDate();
			// if(ACDateUtilities.compareOnDay(end,
			// ACDateUtilities.toLastDayOfMonth(end)) != 0){
			// getIryoInfoValidLimit2().requestFocus();
			// msgParam1 = "�I��";
			// msgParam2 = "����";
			// QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD(msgParam1,
			// msgParam2);
			// return false;
			// }

			// �E�L�����ԊJ�n�iiryoInfoValidLimit1�j
			// �E�L�����ԏI���iiryoInfoValidLimit2�j
			// �O��֌W���������Ă��Ȃ����B
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�L�����Ԃ�"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"�J�n��"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam3��錾���A"�I����"��������B
			if (!(ACTextUtilities
					.isNullText(getIryoInfoValidLimit1().getText()))
					&& !(ACTextUtilities.isNullText(getIryoInfoValidLimit2()
							.getText()))) {
				start = getIryoInfoValidLimit1().getDate();
				end = getIryoInfoValidLimit2().getDate();

				if (ACDateUtilities.compareOnDay(start, end) > 0) {
					getIryoInfoValidLimit1().requestFocus();
					msgParam1 = "�L�����Ԃ�";
					msgParam2 = "�J�n��";
					msgParam3 = "�I����";
					QkanMessageList.getInstance()
							.ERROR_OF_GREATER_DATE_RELATION(msgParam1,
									msgParam2, msgParam3);
					return false;
				}
			}

			// ��������̗L�����Ԃ��d�����Ă��Ȃ����`�F�b�N����B
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"����"��������B
			// ��ʏ�̃f�[�^���擾����B
			map = new VRHashMap();
			getIryoInfo().setSource(map);
			getIryoInfo().applySource();

			// ��������擾����B
			VRList tempIryoKohiList = (VRList) getIryoTableModel().getAdaptee();
			VRList iryoKohiList = new VRArrayList();

			if (checkMode == CHECK_MODE_INSERT) {
				// �ǉ����[�h�̏ꍇ
				iryoKohiList = tempIryoKohiList;
			} else if (checkMode == CHECK_MODE_UPDATE) {
				// �ҏW���[�h�̏ꍇ�A���g�̗����͔�΂��B
				for (int i = 0; i < tempIryoKohiList.size(); i++) {
					if (i == getIryoInfoTable().getSelectedModelRow()) {
						continue;
					}
					iryoKohiList.add(tempIryoKohiList.get(i));
				}
			}

			// ������̗����̂����ŐV�̂��̂̃C���f�b�N�X���擾����B�i�����L�[�FKOHI_TYPE, KOHI_LAW_NO�j
			int newHistoryIndex = getIndexNewHistory(ACCastUtilities
					.toInt(VRBindPathParser.get("KOHI_TYPE", map)),
					ACCastUtilities.toString(VRBindPathParser.get(
							"KOHI_LAW_NO", map)), iryoKohiList);
			int duplicateTermCheckResult = isDuplicateTerm(map, iryoKohiList,
					newHistoryIndex);

			if (duplicateTermCheckResult == RESULT_TRUE) {
				// �d�����Ă���ꍇ
				getIryoInfoPublicExpense().requestFocus();
				msgParam1 = "����";
				QkanMessageList.getInstance()
						.QU004_ERROR_OF_DUPLICATE_KOHI_TERM(msgParam1);
				return false;
			}

			// ��Ì�����iiryoKohiList�j�̓������ɂ�����ΏۃT�[�r�X�ɂ��ă`�F�b�N����B
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"2��"��������B
			if (!doCheckIryoKohi(checkMode)) {
				// �������ɁA����̒��[��ނ̃T�[�r�X��I������������3���ȏ゠�����ꍇ
				getIryoInfoPublicExpense().requestFocus();
				msgParam1 = "2";
				QkanMessageList.getInstance().QU004_ERROR_ON_KOHI_OVER_LIMIT(
						msgParam1);
				return false;
			}

			// �Ō�̗����̗L�����ԏI����ύX�\�ȏꍇ
			if (duplicateTermCheckResult == RESULT_CHANGEABLE) {
				// �m�F���b�Z�[�W��\������B
				// �E���b�Z�[�WID�FWARNING_OF_DUPLICATE_TERM
				msgParam1 = "����";
				switch (QkanMessageList.getInstance()
						.WARNING_OF_DUPLICATE_TERM(msgParam1)) {
				case ACMessageBox.RESULT_OK:
					// �uOK�v���I�����ꂽ�ꍇ
					// �␳
					changeSpanEnd(map, iryoKohiList, newHistoryIndex);
					break;
				case ACMessageBox.RESULT_CANCEL:
					// �u�L�����Z���v���I�����ꂽ�ꍇ
					// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
					getIryoInfoValidLimit1().requestFocus();
					// �߂�l�Ƃ���false��Ԃ��B
					return false;
				}
			}

		} else if (insureType == INSURE_TYPE_SHAHUKU) {

			// �E���z�����ishahukuInfoBenefitRate�j
			// ���͂���Ă��邩�ǂ����B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"���z����"��������B
			if (ACTextUtilities.isNullText(getShahukuInfoBenefitRate()
					.getText())) {
				getShahukuInfoBenefitRate().requestFocus();
				msgParam1 = "���z����";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
			// ���z�����̒l�̃`�F�b�N
			double look = ACCastUtilities.toDouble(getShahukuInfoBenefitRate()
					.getText());
			if (look > 100) {
				getShahukuInfoBenefitRate().requestFocus();
				msgParam1 = "���z����";
				msgParam2 = "100";
				QkanMessageList.getInstance().ERROR_OF_VALUE_TOO_MUCH(
						msgParam1, msgParam2);
				return false;
			}

			// // �E�L�����ԊJ�n�ishahukuInfoValidLimit1�j
			// // ���͂���Ă��邩�ǂ����B
			// // ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԊJ�n��"��������B
			// if(ACTextUtilities.isNullText(getShahukuInfoValidLimit1().getText())){
			// getShahukuInfoValidLimit1().requestFocus();
			// msgParam1 = "�L�����ԊJ�n��";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
			// return false;
			// }

			// �E�L�����ԊJ�n�ishahukuInfoValidLimit1�j
			// ���͂���Ă�����t�����݂��邩�B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԊJ�n����"��������B
			if (!ACTextUtilities.isNullText(getShahukuInfoValidLimit1()
					.getText())) {
				if (!getShahukuInfoValidLimit1().isValidDate()) {
					getShahukuInfoValidLimit1().requestFocus();
					msgParam1 = "�L�����ԊJ�n����";
					QkanMessageList.getInstance()
							.ERROR_OF_WRONG_DATE(msgParam1);
					return false;
				}
			}

			// // �E�L�����ԊJ�n�ishahukuInfoValidLimit1�j
			// // �����̓��t�����͂���Ă��邩�B
			// // ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�J�n"��������B
			// // ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"����"��������B
			// start = getShahukuInfoValidLimit1().getDate();
			// if(ACDateUtilities.compareOnDay(start,
			// ACDateUtilities.toFirstDayOfMonth(start)) != 0){
			// getShahukuInfoValidLimit1().requestFocus();
			// msgParam1 = "�J�n";
			// msgParam2 = "����";
			// QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD(msgParam1,
			// msgParam2);
			// return false;
			// }

			// // �E�L�����ԏI���ishahukuInfoValidLimit2�j
			// // ���͂���Ă��邩�ǂ����B
			// // ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԏI����"��������B
			// if(ACTextUtilities.isNullText(getShahukuInfoValidLimit2().getText())){
			// getShahukuInfoValidLimit2().requestFocus();
			// msgParam1 = "�L�����ԏI����";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
			// return false;
			// }

			// �E�L�����ԏI���ishahukuInfoValidLimit2�j
			// ���͂���Ă�����t�����݂��邩�B
			// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�L�����ԏI������"��������B
			if (!ACTextUtilities.isNullText(getShahukuInfoValidLimit2()
					.getText())) {
				if (!getShahukuInfoValidLimit2().isValidDate()) {
					getShahukuInfoValidLimit2().requestFocus();
					msgParam1 = "�L�����ԏI������";
					QkanMessageList.getInstance()
							.ERROR_OF_WRONG_DATE(msgParam1);
					return false;
				}
			}

			// // �E�L�����ԏI���ishahukuInfoValidLimit2�j
			// // �����̓��t�����͂���Ă��邩�B
			// // ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�I��"��������B
			// // ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"����"��������B
			// end = getShahukuInfoValidLimit2().getDate();
			// if(ACDateUtilities.compareOnDay(end,
			// ACDateUtilities.toLastDayOfMonth(end)) != 0){
			// getShahukuInfoValidLimit2().requestFocus();
			// msgParam1 = "�I��";
			// msgParam2 = "����";
			// QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD(msgParam1,
			// msgParam2);
			// return false;
			// }

			// �E�L�����ԊJ�n�ishahukuInfoValidLimit1�j
			// �E�L�����ԏI���ishahukuInfoValidLimit2�j
			// �O��֌W���������Ă��Ȃ����B
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�L�����Ԃ�"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"�J�n��"��������B
			// ���G���[�̏ꍇ�AString�FmsgParam3��錾���A"�I����"��������B
			if (!(ACTextUtilities.isNullText(getShahukuInfoValidLimit1()
					.getText()))
					&& !(ACTextUtilities.isNullText(getShahukuInfoValidLimit2()
							.getText()))) {
				start = getShahukuInfoValidLimit1().getDate();
				end = getShahukuInfoValidLimit2().getDate();

				if (ACDateUtilities.compareOnDay(start, end) > 0) {
					getShahukuInfoValidLimit1().requestFocus();
					msgParam1 = "�L�����Ԃ�";
					msgParam2 = "�J�n��";
					msgParam3 = "�I����";
					QkanMessageList.getInstance()
							.ERROR_OF_GREATER_DATE_RELATION(msgParam1,
									msgParam2, msgParam3);
					return false;
				}
			}

			// �L�����Ԃ��d�����Ă��Ȃ����`�F�b�N����B
			// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"����"��������B
			// ��ʏ�̃f�[�^���擾����B
			map = new VRHashMap();
			getShahukuInfo().setSource(map);
			getShahukuInfo().applySource();

			// KOHI_TYPE��ݒ肷��B
			VRBindPathParser.set("KOHI_TYPE", map, new Integer(7701));

			// �Е��y���������擾����B
			VRList tempShahukuKohiList = (VRList) getShahukuTableModel()
					.getAdaptee();
			VRList shahukuKohiList = new VRArrayList();

			if (checkMode == CHECK_MODE_INSERT) {
				// �ǉ����[�h�̏ꍇ
				shahukuKohiList = tempShahukuKohiList;
			} else if (checkMode == CHECK_MODE_UPDATE) {
				// �ҏW���[�h�̏ꍇ�A���g�̗����͔�΂��B
				for (int i = 0; i < tempShahukuKohiList.size(); i++) {
					if (i == getShahukuInfoTable().getSelectedModelRow()) {
						continue;
					}
					shahukuKohiList.add(tempShahukuKohiList.get(i));
				}
			}

			// ������̗����̂����ŐV�̂��̂̃C���f�b�N�X���擾����B�i�����L�[�FKOHI_TYPE, KOHI_LAW_NO�j
			int newHistoryIndex = getIndexNewHistory(ACCastUtilities
					.toInt(VRBindPathParser.get("KOHI_TYPE", map)),
					ACCastUtilities.toString(VRBindPathParser.get(
							"KOHI_LAW_NO", map)), shahukuKohiList);
			int duplicateTermCheckResult = isDuplicateTerm(map,
					shahukuKohiList, newHistoryIndex);

			if (duplicateTermCheckResult == RESULT_TRUE) {
				// �d�����Ă���ꍇ
				getShahukuInfoValidLimit1().requestFocus();
				msgParam1 = "�Љ���y��";
				QkanMessageList.getInstance()
						.QU004_ERROR_OF_DUPLICATE_KOHI_TERM(msgParam1);
				return false;
			} else if (duplicateTermCheckResult == RESULT_CHANGEABLE) {
				// �Ō�̗����̗L�����ԏI����ύX�\�ȏꍇ
				// �m�F���b�Z�[�W��\������B
				// �E���b�Z�[�WID�FWARNING_OF_DUPLICATE_TERM
				msgParam1 = "�Љ���y��";
				switch (QkanMessageList.getInstance()
						.WARNING_OF_DUPLICATE_TERM(msgParam1)) {
				case ACMessageBox.RESULT_OK:
					// �uOK�v���I�����ꂽ�ꍇ
					// �␳
					changeSpanEnd(map, shahukuKohiList, newHistoryIndex);
					break;
				case ACMessageBox.RESULT_CANCEL:
					// �u�L�����Z���v���I�����ꂽ�ꍇ
					// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
					getShahukuInfoValidLimit1().requestFocus();
					// �߂�l�Ƃ���false��Ԃ��B
					return false;
				}
			}
		}

		// ���̓G���[���Ȃ������ꍇ
		return true;

	}

	/**
	 * �u������̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doCheckKaigoKohi(int checkMode) throws Exception {

		// ������̃`�F�b�N���s���B
		int maxCount = 3;

		// ���ɓo�^����Ă������T�[�r�X�������Ȃ��ꍇ
		if (getPatientKohiServiceList() == null
				|| getPatientKohiServiceList().size() == 0) {
			return true;
		}

		// ���ɓo�^����Ă��闚��
		VRList kohiList = (VRList) getKaigoTableModel().getAdaptee();

		if (kohiList == null) {
			return true;
		}

		// ���������4�������̏ꍇ
		if (checkMode == CHECK_MODE_INSERT) {
			if (kohiList.size() < 3) {
				return true;
			}
		} else if (checkMode == CHECK_MODE_UPDATE) {
			if (kohiList.size() <= 3) {
				return true;
			}
		}

		// ���������4���ȏ�̏ꍇ

		// ���͂���Ă���L�����ԊJ�n
		Date targetStart;
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit1().getText())) {
			targetStart = MIN_DATE;
		} else {
			targetStart = getKaigoInfoValidLimit1().getDate();
		}

		// ���͂���Ă���L�����ԏI��
		Date targetEnd;
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit2().getText())) {
			targetEnd = MAX_DATE;
		} else {
			targetEnd = getKaigoInfoValidLimit2().getDate();
		}

		// �I������̑ΏۃT�[�r�X
		VRList targetService = (VRList) getKaigoServiceTableModel()
				.getAdaptee();

		// �ΏۃT�[�r�X���I������Ă���T�[�r�X���擾����B
		VRList selectedService = new VRArrayList();
		if (targetService != null) {
			for (int i = 0; i < targetService.size(); i++) {
				VRMap map = (VRMap) targetService.get(i);
				if (ACCastUtilities.toBoolean(VRBindPathParser.get(
						"CHECK_VALUE", map))) {
					selectedService.add(map);
				}
			}
		} else {
			return false;
		}

		// �I���T�[�r�X���Ȃ��ꍇ
		if (selectedService == null || selectedService.size() == 0) {
			return true;
		}

		// �I���T�[�r�X�̒��[�l���ꗗ���擾����B
		VRList claimStyles = getClaimStyles(selectedService);

		// ���łɓo�^����Ă������
		ArrayList reservedKohi = new ArrayList();
		VRList tempList = (VRList) getKaigoTableModel().getAdaptee();
		int selectedRow = getKaigoInfoTable().getSelectedModelRow();
		for (int i = 0; i < tempList.size(); i++) {
			if (checkMode == CHECK_MODE_UPDATE) {
				if (i == selectedRow) {
					// �X�V���[�h�̏ꍇ�A���g�̗����̓X�L�b�v����B
					continue;
				}
			}
			reservedKohi.add(((VRMap) tempList.get(i)).clone());
		}

		// ����ID
		int kohiId = -1;
		if (checkMode == CHECK_MODE_UPDATE) {
			VRMap temp = (VRMap) tempList.get(selectedRow);
			kohiId = ACCastUtilities.toInt(VRBindPathParser
					.get("KOHI_ID", temp));
		}

		// �l�����`�F�b�N
		for (int i = 0; i < claimStyles.size(); i++) {
			int claimStyle = ACCastUtilities.toInt(claimStyles.get(i));
			if (!checkKohiRange(getKohi(reservedKohi, claimStyle), kohiId,
					targetStart, targetEnd, maxCount)) {
				// ���E�˔j
				return false;
			}
		}

		// // �L�����ԊJ�n��1���ɕϊ�
		// targetStart = ACDateUtilities.toFirstDayOfMonth(targetStart);
		//
		// // ���͂��ꂽ���Ԃ�1�����Ƃɔ�r���Ă����B
		// while (ACDateUtilities.compareOnDay(targetStart, targetEnd) <= 0) {
		//
		// VRList list = new VRArrayList();
		//
		// // �o�^����Ă��闚�����A�N���P�ʂŏd�����Ă��闚���𒊏o�B
		// for (int i = 0; i < kohiList.size(); i++) {
		//
		// // �ҏW���[�h�̏ꍇ�A���g�̗����͔�΂��B
		// if (checkMode == CHECK_MODE_UPDATE) {
		// if (i == getKaigoInfoTable().getSelectedModelRow()) {
		// continue;
		// }
		// }
		//
		// VRMap temp = (VRMap) kohiList.get(i);
		// Date paraStart = ACCastUtilities.toDate(VRBindPathParser.get(
		// "KOHI_VALID_START", temp));
		// Date paraEnd = ACCastUtilities.toDate(VRBindPathParser.get(
		// "KOHI_VALID_END", temp));
		// if (isDuplicateOnMonth(targetStart, paraStart, paraEnd)) {
		// // ���o
		// list.add(temp);
		// }
		// }
		//
		// // �I���T�[�r�X�ƒ��o���������̒��[��ނ��r����B
		// if (!isValidKohiService(selectedService, list, INSURE_TYPE_KAIGO)) {
		// return false;
		// }
		//
		// // 1�����Z
		// targetStart = ACDateUtilities.addMonth(targetStart, 1);
		// }

		return true;
	}

	/**
	 * �u��Ì���̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doCheckIryoKohi(int checkMode) throws Exception {

		// ��Ì���̃`�F�b�N���s���B
		// �o�^������
		int maxCount = 2;

		// ���ɓo�^����Ă������T�[�r�X�������Ȃ��ꍇ
		if (getPatientKohiServiceList() == null
				|| getPatientKohiServiceList().size() == 0) {
			return true;
		}

		// ���ɓo�^����Ă��闚��
		VRList kohiList = (VRList) getIryoTableModel().getAdaptee();

		if (kohiList == null) {
			return true;
		}

		// ��Ì������3�������̏ꍇ
		if (checkMode == CHECK_MODE_INSERT) {
			if (kohiList.size() < 2) {
				return true;
			}
		} else if (checkMode == CHECK_MODE_UPDATE) {
			// �ҏW���[�h�̏ꍇ�͎��g�̗������܂߂�2���܂�OK
			if (kohiList.size() <= 2) {
				return true;
			}
		}

		// ��Ì������3���ȏ�̏ꍇ

		// ���͂���Ă���L�����ԊJ�n
		Date targetStart;
		if (ACTextUtilities.isNullText(getIryoInfoValidLimit1().getText())) {
			targetStart = MIN_DATE;
		} else {
			targetStart = getIryoInfoValidLimit1().getDate();
		}

		// ���͂���Ă���L�����ԏI��
		Date targetEnd;
		if (ACTextUtilities.isNullText(getIryoInfoValidLimit2().getText())) {
			targetEnd = MAX_DATE;
		} else {
			targetEnd = getIryoInfoValidLimit2().getDate();
		}

		// �I������̑ΏۃT�[�r�X
		VRList targetService = (VRList) getIryoServiceTableModel().getAdaptee();

		// �ΏۃT�[�r�X���I������Ă���T�[�r�X���擾����B
		VRList selectedService = new VRArrayList();
		if (targetService != null) {
			for (int i = 0; i < targetService.size(); i++) {
				VRMap map = (VRMap) targetService.get(i);
				if (ACCastUtilities.toBoolean(VRBindPathParser.get(
						"CHECK_VALUE", map))) {
					selectedService.add(map);
				}
			}
		} else {
			return false;
		}

		// �I���T�[�r�X���Ȃ��ꍇ
		if (selectedService == null || selectedService.size() == 0) {
			return true;
		}

		// �I���T�[�r�X�̒��[�l���ꗗ���擾����B
		VRList claimStyles = getClaimStyles(selectedService);

		// ���łɓo�^����Ă������
		ArrayList reservedKohi = new ArrayList();
		VRList tempList = ((VRList) getIryoTableModel().getAdaptee());
		int selectedRow = getIryoInfoTable().getSelectedModelRow();
		for (int i = 0; i < tempList.size(); i++) {
			if (checkMode == CHECK_MODE_UPDATE) {
				if (i == selectedRow) {
					// �X�V���[�h�̏ꍇ�A���g�̗����̓X�L�b�v����B
					continue;
				}
			}
			reservedKohi.add(((VRMap) tempList.get(i)).clone());
		}

		// ����ID
		int kohiId = -1;
		if (checkMode == CHECK_MODE_UPDATE) {
			VRMap temp = (VRMap) tempList.get(selectedRow);
			kohiId = ACCastUtilities.toInt(VRBindPathParser
					.get("KOHI_ID", temp));
		}

		// �l�����`�F�b�N
		for (int i = 0; i < claimStyles.size(); i++) {
			int claimStyle = ACCastUtilities.toInt(claimStyles.get(i));
			if (!checkKohiRange(getKohi(reservedKohi, claimStyle), kohiId,
					targetStart, targetEnd, maxCount)) {
				// ���E�˔j
				return false;
			}
		}

		// // �L�����ԊJ�n��1���ɕϊ�
		// targetStart = ACDateUtilities.toFirstDayOfMonth(targetStart);
		//
		// // ���͂��ꂽ���Ԃ�1�����Ƃɔ�r���Ă����B
		// while (ACDateUtilities.compareOnDay(targetStart, targetEnd) <= 0) {
		//
		// VRList list = new VRArrayList();
		//
		// // �o�^����Ă��闚�����A�N���P�ʂŏd�����Ă��闚���𒊏o�B
		// for (int i = 0; i < kohiList.size(); i++) {
		//
		// // �ҏW���[�h�̏ꍇ�A���g�̗����͔�΂��B
		// if (checkMode == CHECK_MODE_UPDATE) {
		// if (i == getIryoInfoTable().getSelectedModelRow()) {
		// continue;
		// }
		// }
		//
		// VRMap temp = (VRMap) kohiList.get(i);
		// Date paraStart = ACCastUtilities.toDate(VRBindPathParser.get(
		// "KOHI_VALID_START", temp));
		// Date paraEnd = ACCastUtilities.toDate(VRBindPathParser.get(
		// "KOHI_VALID_END", temp));
		// if (isDuplicateOnMonth(targetStart, paraStart, paraEnd)) {
		// // ���o
		// list.add(temp);
		// }
		// }
		//
		// // �I���T�[�r�X�ƒ��o���������̒��[��ނ��r����B
		// if (!isValidKohiService(selectedService, list, INSURE_TYPE_IRYO)) {
		// return false;
		// }
		//
		// // 1�����Z
		// targetStart = ACDateUtilities.addMonth(targetStart, 1);
		// }

		return true;
	}

	/**
	 * ���[�l���̃��X�g��Ԃ��܂��B
	 * 
	 * @param serviceList
	 *            �T�[�r�X�̃��X�g
	 * @throws Exception
	 *             ������O
	 */
	public VRList getClaimStyles(VRList serviceList) throws Exception {

		// �I������̒��[�l����z��
		VRList claimStyles = new VRArrayList();
		for (int i = 0; i < serviceList.size(); i++) {
			VRMap service = (VRMap) serviceList.get(i);
			int claimStyle = ACCastUtilities.toInt(VRBindPathParser.get(
					"CLAIM_STYLE_TYPE", service));
			int count = 0;
			for (int j = 0; j < claimStyles.size(); j++) {
				int tempStyle = ACCastUtilities.toInt(claimStyles.get(count));
				if (claimStyle == tempStyle) {
					count++;
					break;
				}
			}
			if (count == 0) {
				claimStyles.add(new Integer(claimStyle));
			}
		}

		return claimStyles;
	}

	/**
	 * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doSave() throws Exception {

		// �ۑ��������s���B

		try {

			// �g�����U�N�V�����J�n
			getDBManager().beginTransaction();

			// �p�b�V�u�`�F�b�N�̃^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();

			// �p�b�V�u�`�F�b�N�̃^�X�N��ǉ�����B
			// ��KEY�FPASSIVE_CHECK_KEY
			getPassiveChecker().addPassiveUpdateTask(getPASSIVE_CHECK_KEY(), 0);

			// �p�b�V�u�`�F�b�N���s���B
			if (!getPassiveChecker().passiveCheck(getDBManager())) {
				// �p�b�V�u�G���[�����������ꍇ
				// �G���[���b�Z�[�W��\������B
				// �E���b�Z�[�WID�FERROR_OF_PASSIVE_CHECK_ON_UPDATE
				QkanMessageList.getInstance()
						.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();

				// �g�����U�N�V��������
				getDBManager().rollbackTransaction();
				// �I��
				return false;
			}

			// SQL���擾�p
			VRMap param = null;
			String strSql = "";

			// ���p�Ҍ�����e�[�u���iPATIENT_KOHI�j�̍X�V����
			// �S���폜
			if (getKohiDataFlg() == 1) {
				// kohiDataFlg�̒l��1�̏ꍇ

				// SQL���擾�̂��߂�HashMap�Fparam�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
				// KEY�FPATIENT_ID VALUE�FpatientId
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// SQL���擾�A���s
				strSql = getSQL_DELETE_PATIENT_KOHI(param);
				getDBManager().executeUpdate(strSql);

			}

			// �o�^
			if (!(getPatientKohiList() == null || getPatientKohiList().size() == 0)) {
				for (int i = 0; i < getPatientKohiList().size(); i++) {
					// �p�����[�^�ݒ�
					param = new VRHashMap();
					param = (VRMap) getPatientKohiList().get(i);

					// SQL���擾�A���s
					strSql = getSQL_INSERT_PATIENT_KOHI(param);
					getDBManager().executeUpdate(strSql);
				}
			}

			// ���p�Ҍ���T�[�r�X���e�[�u���iPATIENT_KOHI_SERVICE�j�̍X�V����
			// �S���폜
			if (getKohiServiceDataFlg() == 1) {
				// kohiServiceDataFlg�̒l��1�̏ꍇ

				// SQL���擾�̂��߂�HashMap�Fparam�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
				// KEY�FPATIENT_ID VALUE�FpatientId
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// SQL���擾�A���s
				strSql = getSQL_DELETE_PATIENT_KOHI_SERVICE(param);
				getDBManager().executeUpdate(strSql);
			}

			// �o�^
			if (!(getPatientKohiServiceList() == null || getPatientKohiServiceList()
					.size() == 0)) {
				for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
					// �p�����[�^�ݒ�
					param = new VRHashMap();
					param = (VRMap) getPatientKohiServiceList().get(i);

					// SQL���擾�A���s
					strSql = getSQL_INSERT_PATIENT_KOHI_SERVICE(param);
					getDBManager().executeUpdate(strSql);
				}
			}

			// ���p�Ҋ�{���TBL�̍ŏI�X�V�������X�V����B
			param = new VRHashMap();
			VRBindPathParser.set("PATIENT_ID", param, new Integer(
					getPatientId()));
			strSql = getSQL_UPDATE_PATIENT_LAST_TIME(param);
			getDBManager().executeUpdate(strSql);

			// �R�~�b�g/���[���o�b�N
			// ��L��SQL���s�����ɐ��������ꍇ
			// DB�������R�~�b�g����B
			getDBManager().commitTransaction();

		} catch (Exception ex) {
			// ��L��SQL���s�����Ɏ��s�����ꍇ
			// ���[���o�b�N����B
			getDBManager().rollbackTransaction();
			// ��O�𓊂���B
			throw ex;
		}

		// ���L�̕ύX�t���O������������B
		// �EkaigoTableChangeFlg
		// �EiryoTableChangeFlg
		// �EkohiDataFlg
		// �EkohiServiceDataFlg
		setKaigoTableChangeFlg(0);
		setIryoTableChangeFlg(0);
		setShahukuTableChangeFlg(0);
		setKohiDataFlg(0);
		setKohiServiceDataFlg(0);

		return true;

	}

	/**
	 * �u���p�Ҍ���T�[�r�X���W�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void setPatientKohiService(int kohiId, int insureType)
			throws Exception {

		// ���p�Ҍ���T�[�r�X������ʂɓW�J����B
		VRList list = new VRArrayList();

		if (insureType == INSURE_TYPE_KAIGO) {
			// ������iinsureType == INSURE_TYPE_KAIGO�j�̏ꍇ
			// kaigoServiceTableModel�ɃZ�b�g����Ă��郌�R�[�h�W�����擾����B
			list = (VRList) getKaigoServiceTableModel().getAdaptee();
		} else if (insureType == INSURE_TYPE_IRYO) {
			// ��Ì���iinsureType == INSURE_TYPE_IRYO�j�̏ꍇ
			// iryoServiceTableModel�ɃZ�b�g����Ă��郌�R�[�h�W�����擾����B
			list = (VRList) getIryoServiceTableModel().getAdaptee();
		} else {
			// �Љ���y���iinsureType == INSURE_TYPE_SHAHUKU�j�̏ꍇ
			// shahukuServiceTableModel�ɃZ�b�g����Ă��郌�R�[�h�W�����擾����B
			list = (VRList) getShahukuServiceTableModel().getAdaptee();
		}

		if (list == null) {
			return;
		}

		// list�̌��������[�v����B
		// ���ȉ��Alist�̃��R�[�h��map�Ƃ���B
		for (int i = 0; i < list.size(); i++) {

			VRMap map = (VRMap) list.get(i);

			// map��SYSTEM_SERVICE_KIND_DETAIL���擾����B�i�ȉ��AsystemServiceKindDetail�Ƃ���B�j
			int systemServiceKindDetail = ACCastUtilities
					.toInt(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
							map));

			// patientKohiServiceList�Ɉȉ���KEY/VALUE����v���郌�R�[�h�����邩�`�F�b�N����B
			// �EKEY�FKOHI_ID VALUE�FkohiId
			// �EKEY�FSYSTEM_SERVICE_KIND_DETAIL VALUE�FsystemServiceKindDetail
			if (doCheckUseService(kohiId, systemServiceKindDetail)) {
				// // ��v���郌�R�[�h���������ꍇ�i�߂�l��true�̏ꍇ�j
				// // map�Ɉȉ���KEY/VALUE�ݒ肷��B
				// // �EKEY�FCHECK_VALUE VALUE�FTRUE
				VRBindPathParser.set("CHECK_VALUE", map, new Boolean(true));
			} else {
				// // ��v���郌�R�[�h���Ȃ������ꍇ�i�߂�l��false�̏ꍇ�j
				// // map�Ɉȉ���KEY/VALUE�ݒ肷��B
				// // �EKEY�FCHECK_VALUE VALUE�FFALSE
				VRBindPathParser.set("CHECK_VALUE", map, new Boolean(false));
			}

			// list�ɖ߂��B
			list.set(i, map);

		}

		// �e�[�u�����f���ɍĂѐݒ肷��B
		if (insureType == INSURE_TYPE_KAIGO) {
			// ������iinsureType == INSURE_TYPE_KAIGO�j�̏ꍇ
			// kaigoServiceTableModel�ɃZ�b�g����Ă��郌�R�[�h�W�����擾����B
			getKaigoServiceTableModel().setAdaptee(list);
		} else if (insureType == INSURE_TYPE_IRYO) {
			// ��Ì���iinsureType == INSURE_TYPE_IRYO�j�̏ꍇ
			// iryoServiceTableModel�ɃZ�b�g����Ă��郌�R�[�h�W�����擾����B
			getIryoServiceTableModel().setAdaptee(list);
		} else {
			// �Љ���y���iinsureType == INSURE_TYPE_SHAHUKU�j�̏ꍇ
			// shahukuServiceTableModel�ɃZ�b�g����Ă��郌�R�[�h�W�����擾����B
			getShahukuServiceTableModel().setAdaptee(list);
		}

	}

	/**
	 * �u���t�Ώۂ̃T�[�r�X�̔���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doCheckUseService(int kohiId, int systemServiceKindDetail)
			throws Exception {

		// ���t�ΏۃT�[�r�X�Ƃ��Ďw�肳��Ă���T�[�r�X�����肷��B

		if (getPatientKohiServiceList() == null) {
			return false;
		}

		// patientKohiServiceList�̌��������[�v����B
		for (int i = 0; i < getPatientKohiServiceList().size(); i++) {

			VRMap map = (VRMap) getPatientKohiServiceList().get(i);

			// �ȉ���KEY/VALUE����v���郌�R�[�h�̏ꍇ
			// �EKEY�FKOHI_ID VALUE�FkohiId
			// �EKEY�FSYSTEM_SERVICE_KIND_DETAIL VALUE�FsystemServiceKindDetail
			// �߂�l�Ƃ���true��Ԃ��B
			if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID", map)) == kohiId
					&& ACCastUtilities.toInt(VRBindPathParser.get(
							"SYSTEM_SERVICE_KIND_DETAIL", map)) == systemServiceKindDetail) {
				return true;
			}

		}

		// ��v���郌�R�[�h���Ȃ��A���[�v�𔲂����ꍇ
		// �߂�l�Ƃ���false��Ԃ��B
		return false;

	}

	/**
	 * �u���p�Ҍ���T�[�r�X������ʂ��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public VRList getPatientKohiService(int kohiId, int insureType)
			throws Exception {
		// ���p�Ҍ���T�[�r�X������ʂ��擾����B

		// �߂�l�p��ArrayList�Flist�𐶐�����B
		VRList list = new VRArrayList();

		VRList serviceList = new VRArrayList();

		if (insureType == INSURE_TYPE_KAIGO) {
			// insureType�̒l��INSURE_TYPE_KAIGO�̏ꍇ
			// kaigoServiceTableModel�ɃZ�b�g���Ă��郌�R�[�h�W�����擾����B
			serviceList = (VRList) getKaigoServiceTableModel().getAdaptee();
		} else if (insureType == INSURE_TYPE_IRYO) {
			// insureType�̒l��INSURE_TYPE_IRYO�̏ꍇ
			// iryoServiceTableModel�ɃZ�b�g���Ă��郌�R�[�h�W�����擾����B
			serviceList = (VRList) getIryoServiceTableModel().getAdaptee();
		} else {
			// insureType�̒l��INSURE_TYPE_SHAHUKU�̏ꍇ
			// shahukuServiceTableModel�ɃZ�b�g���Ă��郌�R�[�h�W�����擾����B
			serviceList = (VRList) getShahukuServiceTableModel().getAdaptee();
		}

		// ServiceList�̌��������[�v����B
		for (int i = 0; i < serviceList.size(); i++) {
			VRMap temp = (VRMap) serviceList.get(i);
			// temp��KEY�FCHECK_VALUE��VALUE��true�̏ꍇ
			if (ACCastUtilities.toBoolean(VRBindPathParser.get("CHECK_VALUE",
					temp))) {
				// temp��KEY�FSYSTEM_SERVICE_KIND_DETAIL��VALUE���擾����B
				int systemServiceKindDetail = ACCastUtilities
						.toInt(VRBindPathParser.get(
								"SYSTEM_SERVICE_KIND_DETAIL", temp));

				// VRMap map�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
				// �EKEY�FPATIENT_ID VALUE�FpatientId
				// �EKEY�FKOHI_ID VALUE�FkohiId
				// �EKEY�FSYSTEM_SERVICE_KIND_DETAIL VALUE�FsystemServiceKindDetail
				// map��list�ɒǉ�����B
				VRMap map = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", map, new Integer(
						getPatientId()));
				VRBindPathParser.set("KOHI_ID", map, new Integer(kohiId));
				VRBindPathParser.set("SYSTEM_SERVICE_KIND_DETAIL", map,
						new Integer(systemServiceKindDetail));

				list.add(map);
			}
		}

		// �߂�l�Ƃ���list��Ԃ��B
		return list;

	}

	/**
	 * �u��ʏ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void initialize() throws Exception {
		// ��ʂ̏����������B

		// �Ɩ����}�X�^���A�f�[�^���擾����B
		// �擾�����f�[�^�̃E�B���h�E�^�C�g���iWINDOW_TITLE�j���E�B���h�E�ɐݒ肷��B
		// �擾�����f�[�^�̋Ɩ��^�C�g���iAFFAIR_TITLE�j���Ɩ��{�^���o�[�ɐݒ肷��B
		setAffairTitle(AFFAIR_ID, getButtons());

		// �p�b�V�u�L�[�̒�`
		setPASSIVE_CHECK_KEY(new ACPassiveKey("PATIENT",
				new String[] { "PATIENT_ID" }, new Format[] { null },
				"LAST_TIME", "LAST_TIME"));

		// �e�[�u�����f���̐���
		ACTableModelAdapter model = null;

		// kaigoTableModel�𐶐����A�ȉ��̃J�����Őݒ肷��B
		// "KOHI_ABBREVIATION" "KOHI_PAYER_NO" "KOHI_PAYER_NAME"
		// "KOHI_RECIPIENT_NO" "KOHI_VALID_START"
		// "PATIENT_KOHI.KOHI_VALID_END"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "KOHI_NAME", "BENEFIT_RATE",
				"KOHI_LAW_NO+''+INSURER_ID", "KOHI_PAYER_NAME",
				"KOHI_RECIPIENT_NO", "KOHI_VALID_START", "KOHI_VALID_END" });

		setKaigoTableModel(model);

		// ������e�[�u���ikaigoInfoTable�j�ɃZ�b�g����B
		getKaigoInfoTable().setModel(getKaigoTableModel());

		// iryoTableModel�𐶐����A�ȉ��̃J�����Őݒ肷��B
		// "KOHI_ABBREVIATION" "KOHI_PAYER_NO" "KOHI_PAYER_NAME"
		// "KOHI_RECIPIENT_NO" "KOHI_VALID_START"
		// "KOHI_VALID_END"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "KOHI_NAME", "BENEFIT_RATE",
				"KOHI_LAW_NO+''+INSURER_ID", "KOHI_PAYER_NAME",
				"KOHI_RECIPIENT_NO", "KOHI_VALID_START", "KOHI_VALID_END" });

		setIryoTableModel(model);

		// ��Ì���e�[�u���iiryoInfoTable�j�ɃZ�b�g����B
		getIryoInfoTable().setModel(getIryoTableModel());

		// shahukuableModel�𐶐����A�ȉ��̃J�����Őݒ肷��B
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "LOOK", "KOHI_VALID_START",
				"KOHI_VALID_END" });

		setShahukuTableModel(model);

		// �Љ���y���e�[�u���ishahukuInfoTable�j�ɃZ�b�g����B
		getShahukuInfoTable().setModel(getShahukuTableModel());

		// kaigoServiceTableModel�𐶐����A�ȉ��̃J�����Őݒ肷��B
		// "CHECK_VALUE" "SERVICE_ABBREVIATION" "CLAIM_STYLE_TYPE"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "CHECK_VALUE", "SERVICE_ABBREVIATION",
				"CLAIM_STYLE_TYPE" });

		setKaigoServiceTableModel(model);

		// ������g�p�T�[�r�X�e�[�u���ikaigoInfoServiceTable�j�ɃZ�b�g����B
		getKaigoInfoServiceTable().setModel(getKaigoServiceTableModel());

		// iryoServiceTableModel�𐶐����A�ȉ��̃J�����Őݒ肷��B
		// "CHECK_VALUE" "SERVICE_ABBREVIATION" "CLAIM_STYLE_TYPE"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "CHECK_VALUE", "SERVICE_ABBREVIATION",
				"CLAIM_STYLE_TYPE" });

		setIryoServiceTableModel(model);

		// shahukuServiceTableModel�𐶐�����B
		model = new ACTableModelAdapter();
		setShahukuServiceTableModel(model);

		// �X�i�b�v�V���b�g�̎B�e�Ώێw��
		getSnapShotKaigo().setRootContainer(getPoints1());
		getSnapShotIryo().setRootContainer(getPoints2());
		getSnapShotShahuku().setRootContainer(getPoints3());

		// ��Ì���g�p�T�[�r�X�e�[�u���iiryoInfoServiceTable�j�ɃZ�b�g����B
		getIryoInfoServiceTable().setModel(getIryoServiceTableModel());

		// �t�H�[�}�b�^�̐ݒ�
		// // ������(���)
		// getKaigoInfoTableColumn1().setFormat(new QkanKaigoKohiFormat());

		// ���[���(���)
		getKaigoInfoServiceTableColumn3().setFormat(new QkanClaimStyleFormat());

		// // ������(���)
		// getIryoInfoTableColumn1().setFormat(new QkanIryoKohiFormat());

		// ���[���(���)
		getIryoInfoServiceTableColumn3().setFormat(
				new ACHashMapFormat(new String[] { "�K��Ō�×{��׏�" },
						new Integer[] { new Integer(20101) }));

		//��Ìn��\���Ή� fujihara.shin 2009.1.13 add start
		if (!QkanCommon.isShowOldIryo()){
			setState_OLD_IRYO_OFF();
		}
		//��Ìn��\���Ή� fujihara.shin 2009.1.13 add enf
		
		// ��ʐݒ�
		casualInitialize();

	}

	/**
	 * �u��ʐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void casualInitialize() throws Exception {
		// ��ʂ̐ݒ���s���B

		// VRMap map�𐶐�����B��ʐݒ�p
		VRMap map = new VRHashMap();

		// SQL���擾�p
		VRMap param = new VRHashMap();

		// SQL���i�[�p
		String strSql = "";

		// ���L�̏����擾���Amap�ɐݒ肷��B
		// �E����}�X�^���擾
		// ����}�X�^�����擾���AmasterKohiList�Ɋi�[����B
		// VRBindPathParser.set("SYSTEM_DATE", param,
		// QkanSystemInformation.getInstance().getSystemDate());

		strSql = getSQL_GET_MASTER_KOHI(param);
		setMasterKohiList(getDBManager().executeQuery(strSql));

		// �E��������A��Ì�����擾
		// ArrayList masterKaigoKohiList�𐶐�����B
		VRList masterKaigokohiList = new VRArrayList();

		// ArrayList masterIryoKohiList�𐶐�����B
		VRList masterIryoKohiList = new VRArrayList();

		
		/* 2007-04-05 ���j�\�h�@�Ή� change start kamitsukasa */
		/* �ݒ�E�ύX�����e�i���X�Őݒ肳�ꂽ�l�iScreenConfig/ShowOldKohi�j�ɂ��
		 * �V�X�e�����t�ɂ����Ė����Ȍ���̕\���i1�j�E��\���i0�j��؂�ւ��� */
		
		// ScreenConfig/ShowOldKohi�̎擾(�f�t�H���g�F0)
		int showOldKohi = 0;
		if(ACFrame.getInstance().hasProperty("ScreenConfig/ShowOldKohi")){
			showOldKohi = ACCastUtilities.toInt(getProperty("ScreenConfig/ShowOldKohi"), 0);
		}
		// �V�X�e�����t�̎擾
		Date systemDate = QkanSystemInformation.getInstance().getSystemDate();
		
		// masterKohiList�̌��������[�v����B
		for (int i = 0; i < getMasterKohiList().size(); i++) {

			VRMap temp = (VRMap) getMasterKohiList().get(i);
			if(!canShowKohi(temp, systemDate, showOldKohi)){
				// �\���\�ł͂Ȃ�����ł���ꍇ
				continue;
			}
			if (ACCastUtilities
					.toInt(VRBindPathParser.get("INSURE_TYPE", temp)) == INSURE_TYPE_KAIGO) {
				// INSURE_TYPE�̒l��INSURE_TYPE_KAIGO�̏ꍇ
				// ���R�[�h��masterKaigoKohiList�ɒǉ�����B
				masterKaigokohiList.add(temp);
			} else if (ACCastUtilities.toInt(VRBindPathParser.get(
					"INSURE_TYPE", temp)) == INSURE_TYPE_IRYO) {
				// masterKohiList���INSURE_TYPE�̒l��INSURE_TYPE_IRYO�̏ꍇ
				// ���R�[�h��masterIryoKohiList�ɒǉ�����B
				masterIryoKohiList.add(temp);
			}
		}

		/* 2007-04-05 ���j�\�h�@�Ή� change end kamitsukasa */

		
		// masterKaigokohiList��map��KEY�FKAIGO_KOHI�Őݒ肷��B
		// masterIryoKohiList��map��KEY�FIRYO_KOHI�Őݒ肷��B
		VRBindPathParser.set("KAIGO_KOHI", map, masterKaigokohiList);
		VRBindPathParser.set("IRYO_KOHI", map, masterIryoKohiList);

		// �E���S�ҁi�ی��ҁj���
		// �ی��ҏ����擾���AinsurerList�Ɋi�[����B
		setInsurerList(QkanCommon.getInsurerInfo(getDBManager()));

		// map��KEY�FKOHI_PAYER_NAME�Őݒ肷��B
		VRBindPathParser.set("KOHI_PAYER_NAME", map, getInsurerList());

		// map���u�N���C�A���g�̈�icontents�j�v�ɐݒ肷��B
		getContents().setModelSource(map);

		// ��ʂɃf�[�^��W�J����B
		getContents().bindModelSource();

		// DB�iM_KOHI_SERVICE�j������T�[�r�X�}�X�^�����擾����B
		// ����}�X�^�T�[�r�X�����擾���AmasterKohiServiceList�Ɋi�[����B
		strSql = getSQL_GET_MASTER_KOHI_SERVICE(null);
		setMasterKohiServiceList(getDBManager().executeQuery(strSql));

		// �T�[�r�X�}�X�^�f�[�^���擾���AmasterServce�Ɋi�[����B
		setMasterService(QkanCommon.getMasterService(getDBManager()));

		// �Љ���y���̂݌Œ�̂��߁A�T�[�r�X�}�X�^�f�[�^���ɃZ�b�g���Ă����B
		doFindTargetService(TYPE_SHAHUKU, INSURE_TYPE_SHAHUKU);

	}

	/**
	 * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @param VRMap
	 *            �ҏW�O�f�[�^
	 * @return VRMap �ҏW��f�[�^
	 */
	public VRMap toKohiTableList(VRMap map) throws Exception {

		// �e�[�u���\���p�Ƀf�[�^��ҏW����B

		VRMap temp = null;

		// �n���ꂽ���R�[�h��INSURER_ID�̒l�ŁAinsurerList��
		// INSURER_ID����������B
		temp = new VRHashMap();
		temp = ACBindUtilities.getMatchRowFromValue(getInsurerList(),
				"INSURER_ID", VRBindPathParser.get("INSURER_ID", map));

		if (temp != null) {
			// �Y������ی��ҏ�񂪂������ꍇ
			// �Y������ی��ҏ���INSURER_NAME��n���ꂽ���R�[�h��
			// KEY�FKOHI_PAYER_NAME�Œǉ�����B
			VRBindPathParser.set("KOHI_PAYER_NAME", map, VRBindPathParser.get(
					"INSURER_NAME", temp));
		}

		// ����̂̒ǉ�
		temp = new VRHashMap();
		temp = ACBindUtilities.getMatchRowFromValue(getMasterKohiList(),
				"KOHI_TYPE", VRBindPathParser.get("KOHI_TYPE", map));

		if (temp != null) {
			VRBindPathParser.set("KOHI_NAME", map, VRBindPathParser.get(
					"KOHI_NAME", temp));
		}
		return map;

	}

	/**
	 * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @param VRList
	 *            �ҏW�O�f�[�^�W��
	 * @return VRList �ҏW��f�[�^�W��
	 */
	public VRList toKohiTableList(VRList list) throws Exception {

		// �e�[�u���\���p�Ƀf�[�^��ҏW����B

		if (list == null) {
			// �n���ꂽ�f�[�^��null�̏ꍇ
			// �߂�l�Ƃ���null��Ԃ��B
			return null;
		} else {
			// �n���ꂽ�f�[�^�̌��������[�v����B
			for (int i = 0; i < list.size(); i++) {
				// ���R�[�h��ҏW����B
				toKohiTableList((VRMap) list.get(i));
			}
		}

		return list;
	}

	/**
	 * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @param VRMap
	 *            �ҏW�O�f�[�^
	 * @return VRMap �ҏW��f�[�^
	 */
	public VRMap toShahukuTableList(VRMap map, String mode) throws Exception {

		// �e�[�u���\���p�Ƀf�[�^��ҏW����B

		NumberFormat nf = new DecimalFormat("0.0");

		if ("FROM_DB".equals(mode)) {
			// DB����̃f�[�^�̏ꍇ
			double look = ACCastUtilities.toDouble(VRBindPathParser.get(
					"BENEFIT_RATE", map)) / 10;

			// �����_�̌`���ɐ��`���A�Z�b�g
			VRBindPathParser.set("LOOK", map, new Double(nf.format(look)));

		} else if ("FROM_INPUT".equals(mode)) {
			// ���[�U���͂̃f�[�^�̏ꍇ
			double look = ACCastUtilities.toDouble(VRBindPathParser.get("LOOK",
					map));

			// DB�o�^�p�ɐ��`���A�Z�b�g
			VRBindPathParser.set("LOOK", map, new Double(nf.format(look)));
			VRBindPathParser.set("BENEFIT_RATE", map, ACCastUtilities
					.toString((look * 10)));
		}

		return map;
	}

	/**
	 * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @param VRList
	 *            �ҏW�O�f�[�^�W��
	 * @return VRList �ҏW��f�[�^�W��
	 */
	public VRList toShahukuTableList(VRList list, String mode) throws Exception {

		// �e�[�u���\���p�Ƀf�[�^��ҏW����B

		if (list == null) {
			// �n���ꂽ�f�[�^��null�̏ꍇ
			// �߂�l�Ƃ���null��Ԃ��B
			return null;
		} else {
			// �n���ꂽ�f�[�^�̌��������[�v����B
			for (int i = 0; i < list.size(); i++) {
				// ���R�[�h��ҏW����B
				toShahukuTableList((VRMap) list.get(i), mode);
			}
		}

		return list;
	}

	/**
	 * �u�e�ی��̃f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @param �ҏW�O�f�[�^�W��
	 * @return �ҏW��f�[�^�W��
	 */
	public VRList getListToSetTable(VRList list, int insureType)
			throws Exception {

		// �߂�l�p��VRList�𐶐�
		VRList result = new VRArrayList();

		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				VRMap map = (VRMap) list.get(i);
				if (ACCastUtilities.toInt(VRBindPathParser.get("INSURE_TYPE",
						map)) == insureType) {
					result.add(map);
				}
			}
		}
		return result;

	}

	/**
	 * �u�N����r�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @param Date
	 *            ��r���̓��t
	 * @param Date
	 *            ��r����Ԃ̊J�n��
	 * @param Date
	 *            ��r����Ԃ̏I����
	 * @return boolean �d�Ȃ�ꍇtrue �d�Ȃ�Ȃ��ꍇfalse
	 */
	public boolean isDuplicateOnMonth(Date target, Date paraStart, Date paraEnd)
			throws Exception {

		// target���n���ꂽ���ԂƁA�N���P�ʂŏd�����Ă��邩���`�F�b�N����֐��B

		// �����̊J�n��1���ɕϊ�
		Date start = ACDateUtilities.toFirstDayOfMonth(paraStart);
		// �����̏I���𖖓��ɕϊ�
		Date end = ACDateUtilities.toLastDayOfMonth(paraEnd);

		if (ACDateUtilities.compareOnDay(target, start) >= 0
				&& ACDateUtilities.compareOnDay(target, end) <= 0) {

			return true;

		}

		return false;
	}

	/**
	 * �u����ΏۑI���T�[�r�X����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @param VRList
	 *            �I�����ꂽ�T�[�r�X�i��r���j
	 * @param VRList
	 *            �o�^����Ă�������
	 * @param int
	 *            �ی����
	 * @return boolean ��������ꍇfalse
	 */
	public boolean isValidKohiService(VRList selectedService, VRList reserved,
			int insureType) throws Exception {

		// �I���T�[�r�X���ꌏ�����肵�Ă����B
		for (int i = 0; i < selectedService.size(); i++) {
			// �I���T�[�r�X���R�[�h
			VRMap map = (VRMap) selectedService.get(i);
			// �I���T�[�r�X�̒��[���
			int claimStyle = ACCastUtilities.toInt(VRBindPathParser.get(
					"CLAIM_STYLE_TYPE", map));

			// �I���T�[�r�X�̒��[��ނƏd�����闚���̌������擾�B
			int count = getCountDuplicateOnClaimStyle(claimStyle, reserved);

			if (insureType == INSURE_TYPE_KAIGO) {
				// ������̏ꍇ
				if (count > 2) {
					return false;
				}
			} else if (insureType == INSURE_TYPE_IRYO) {
				// ��Ì���̏ꍇ
				if (count > 1) {
					return false;
				}
			}

		}

		return true;
	}

	/**
	 * �u����ΏۑI���T�[�r�X����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @param int
	 *            ���[��ށi��r���j
	 * @param VRList
	 *            �o�^����Ă�������
	 * @return int �d����������
	 */
	public int getCountDuplicateOnClaimStyle(int claimStyle, VRList reserved)
			throws Exception {

		// �߂�l�p
		int count = 0;

		for (int i = 0; i < reserved.size(); i++) {
			// �������背�R�[�h���擾
			VRMap patientKohi = (VRMap) reserved.get(i);
			// ���R�[�h��ID���擾
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					patientKohi));

			// ����T�[�r�X�����̌��������[�v
			for (int j = 0; j < getPatientKohiServiceList().size(); j++) {
				VRMap patientKohiService = (VRMap) getPatientKohiServiceList()
						.get(j);

				// ��������R�[�h��ID�ƕR�Â��A����T�[�r�X�����̏ꍇ
				if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
						patientKohiService)) == kohiId) {
					// �T�[�r�X��ރR�[�h���擾����B
					int systemServiceKindDetail = ACCastUtilities
							.toInt(VRBindPathParser.get(
									"SYSTEM_SERVICE_KIND_DETAIL",
									patientKohiService));

					// �擾�����T�[�r�X��ރR�[�h�ŃT�[�r�X�}�X�^�f�[�^���擾
					VRMap service = (VRMap) VRBindPathParser.get(new Integer(
							systemServiceKindDetail), getMasterService());

					// �n���ꂽ���[��ނƃT�[�r�X�}�X�^�̒��[��ނ��r
					if (ACCastUtilities.toInt(VRBindPathParser.get(
							"CLAIM_STYLE_TYPE", service)) == claimStyle) {
						// �d�����Ă����ꍇ�J�E���^��1���Z����B
						count += 1;

						// ����KOHI_ID��
						break;
					}
				}
			}
		}

		// ������Ԃ��B
		return count;

	}

	/**
	 * ������̗����̂����A�ŐV�̗�����Ԃ��܂��B ������̗������Ȃ��ꍇ�A-1��Ԃ��܂��B �����L�[�FKOHI_TYPE, KOHI_LAW_NO
	 */
	public int getIndexNewHistory(int kohiType, String kohiLawNo,
			VRList kohiList) throws Exception {
		int result = -1;
		Date keepBegin = null;
		for (int i = 0; i < kohiList.size(); i++) {
			VRMap row = (VRMap) kohiList.get(i);
			if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_TYPE", row)) == kohiType
					&& kohiLawNo
							.equals(ACCastUtilities.toString(VRBindPathParser
									.get("KOHI_LAW_NO", row)))) {
				Date tempBegin = ACCastUtilities.toDate(VRBindPathParser.get(
						"KOHI_VALID_START", row));
				if (keepBegin == null) {
					keepBegin = tempBegin;
					result = i;
				} else if (ACDateUtilities.compareOnDay(keepBegin, tempBegin) < 0) {
					keepBegin = tempBegin;
					result = i;
				}
			}
		}
		return result;
	}

	/**
	 * �u�L�����ԏd������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @param VRMap
	 *            ��ʏ�œ��͂���Ă���f�[�^
	 * @param VRList
	 *            �o�^����Ă��闚��
	 * @return boolean �d�����Ă���ꍇtrue
	 */
	public int isDuplicateTerm(VRMap map, VRList list, int newHistoryIndex)
			throws Exception {

		int result = RESULT_FALSE;

		// ��������̗L�����Ԃ��d�����Ă��Ȃ������肷��B(�����L�[�FKOHI_TYPE, KOHI_LAW_NO)
		if (list == null) {
			return result;
		}

		// �o�^���悤�Ƃ��Ă������̎��
		int kohiType = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_TYPE",
				map));
		String kohiLawNo = ACCastUtilities.toString(VRBindPathParser.get(
				"KOHI_LAW_NO", map));

		for (int i = 0; i < list.size(); i++) {
			VRMap temp = (VRMap) list.get(i);

			if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_TYPE", temp)) == kohiType
					&& kohiLawNo
							.equals(ACCastUtilities.toString(VRBindPathParser
									.get("KOHI_LAW_NO", temp)))) {
				Object obj;

				Date inputSta;
				obj = VRBindPathParser.get("KOHI_VALID_START", map);
				if (obj == null || "".equals(obj)) {
					inputSta = MIN_DATE;
				} else {
					inputSta = ACCastUtilities.toDate(obj);
				}

				Date inputEnd;
				obj = VRBindPathParser.get("KOHI_VALID_END", map);
				if (obj == null || "".equals(obj)) {
					inputEnd = MAX_DATE;
				} else {
					inputEnd = ACCastUtilities.toDate(obj);
				}

				Date reservedSta = ACCastUtilities.toDate(VRBindPathParser.get(
						"KOHI_VALID_START", temp));
				Date reservedEnd = ACCastUtilities.toDate(VRBindPathParser.get(
						"KOHI_VALID_END", temp));

				int compareDateResult = (ACDateUtilities.getDuplicateTermCheck(
						reservedSta, reservedEnd, inputSta, inputEnd));

				// �d���`�F�b�N�̒l�ɂ�蕪��
				if (i == newHistoryIndex) {
					// ���̗������Ō�̗����̏ꍇ
					if (compareDateResult == ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND
							|| compareDateResult == ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND_EQUALS_BOTH_END
							|| compareDateResult == ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN
							|| compareDateResult == ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN_ON_ONE_DAY) {
						// �ύX�\
						// �������A���̗����Əd�����Ă��Ȃ����Ƃ��ۏ؂���邱��
						if (ACDateUtilities.compareOnDay(inputSta, MIN_DATE) == 0) {
							// �o�^����悤�Ƃ��Ă���L�����ԊJ�n�������͂�������MIN�̏ꍇ
							return RESULT_TRUE;
						} else {
							result = RESULT_CHANGEABLE;
						}
					} else if (compareDateResult != ACDateUtilities.DUPLICATE_NONE) {
						return RESULT_TRUE;
					}
				} else {
					if (compareDateResult != ACDateUtilities.DUPLICATE_NONE) {
						return RESULT_TRUE;
					}
				}
			}
		}

		// �d�����Ȃ������ꍇ
		return result;

	}

	/**
	 * �L�����ԏI����␳���܂��B
	 * 
	 * @param map
	 * @param list
	 * @param newHistoryIndex
	 * @throws Exception
	 */
	public void changeSpanEnd(VRMap map, VRList list, int newHistoryIndex)
			throws Exception {

		Date newEnd = ACDateUtilities.addDay(ACCastUtilities
				.toDate(VRBindPathParser.get("KOHI_VALID_START", map)), -1);

		VRMap tempMap = (VRMap) list.get(newHistoryIndex);
		VRBindPathParser.set("KOHI_VALID_END", tempMap, newEnd);
	}

	/**
	 * �u����A�������t�ݒ�v�����ł��B
	 * 
	 * @param VRMap
	 *            �l���l�ߍ��݂���VRMap
	 * @throws Exception
	 *             ������O
	 */
	public void setMaxAndMinDate(VRMap map) throws Exception {
		// ��Y���̏ꍇ�̏���

		// �L�����ԊJ�n�������͂���Ă��Ȃ��ꍇ
		// �������t�������ݒ�
		Object obj;
		obj = VRBindPathParser.get("KOHI_VALID_START", map);
		if (obj == null || "".equals(obj)) {
			VRBindPathParser.set("KOHI_VALID_START", map, MIN_DATE);
		}

		// �L�����ԏI���������͂���Ă��Ȃ��ꍇ
		// ������t�������ݒ�
		obj = VRBindPathParser.get("KOHI_VALID_END", map);
		if (obj == null || "".equals(obj)) {
			VRBindPathParser.set("KOHI_VALID_END", map, MAX_DATE);
		}
	}

	/**
	 * �w��̗l�����g�p�������𒊏o���ĕԂ��܂��B
	 * 
	 * @param VRMap
	 *            �l���l�ߍ��݂���VRMap
	 * @throws Exception
	 *             ������O
	 */
	public ArrayList getKohi(ArrayList kohiList, int claimStyle)
			throws Exception {
		ArrayList result = new ArrayList();
		// kohiList�𑖍����āAstyle�Ɉ�v������̂𒊏o
		Iterator it = kohiList.iterator();
		while (it.hasNext()) {
			VRMap row = (VRMap) it.next();
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					row));
			// for (int i = 0; i < getMasterKohiServiceList().size(); i++) {
			for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
				// VRMap temp = (VRMap) getMasterKohiServiceList().get(i);
				VRMap temp = (VRMap) getPatientKohiServiceList().get(i);
				if (kohiId == ACCastUtilities.toInt(VRBindPathParser.get(
						"KOHI_ID", temp))) {
					int serviceKindDetail = ACCastUtilities
							.toInt(VRBindPathParser.get(
									"SYSTEM_SERVICE_KIND_DETAIL", temp));
					VRMap service = (VRMap) VRBindPathParser.get(new Integer(
							serviceKindDetail), getMasterService());
					int masterClaimStyle = ACCastUtilities
							.toInt(VRBindPathParser.get("CLAIM_STYLE_TYPE",
									service));
					if (claimStyle == masterClaimStyle) {
						result.add(row.clone());
						break;
					}
				}
			}
		}
		return result;
	}

	/**
	 * ����l���ŏd���������̌������J�E���g�� �w�肵�������𒴂����ꍇfalse��Ԃ��܂��B
	 */
	public boolean checkKohiRange(ArrayList kohiList, int kohiId, Date begin,
			Date end, int maxCount) throws Exception {

		// �Ώی���ꗗ��KohiRange�̏W���ɕϊ�����
		ArrayList targetRanges = new ArrayList();

		// �o�^���悤�Ƃ������
		QU004KohiRange range = new QU004KohiRange();
		range.setBegin(begin);
		range.setEnd(end);
		range.setCount(1);
		range.setMaxCount(maxCount);
		range.getKohiIdList().add(new Integer(kohiId));
		targetRanges.add(range);

		// �o�^�ς݂̌����S�������A�o�^���悤�Ƃ������Ƃ̊��ԏd�����`�F�b�N����B
		Iterator it = kohiList.iterator();
		while (it.hasNext()) {
			VRMap row = (VRMap) it.next();
			ArrayList list = new ArrayList();
			list.add(row);

			// �����܂łɔ�r�������Ԃ��ׂĂ�Ώۂɏd�����`�F�b�N����
			int size = targetRanges.size();
			for (int i = 0; i < size; i++) {
				QU004KohiRange kohiRange = (QU004KohiRange) targetRanges.get(i);
				if (!kohiRange.check(targetRanges, list)) {
					return false;
				}
			}
			if (list != null || !list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					// �������ꂽ��r���̌�����̂����A�c���Ă�����̂�targetRanges�ɒǉ�
					VRMap leftKohi = (VRMap) list.get(i);
					QU004KohiRange leftKohiRange = new QU004KohiRange();
					leftKohiRange.setBegin(ACCastUtilities
							.toDate(VRBindPathParser.get("KOHI_VALID_START",
									leftKohi)));
					leftKohiRange.setEnd(ACCastUtilities
							.toDate(VRBindPathParser.get("KOHI_VALID_END",
									leftKohi)));
					leftKohiRange.setCount(1);
					leftKohiRange.setMaxCount(maxCount);
					leftKohiRange.getKohiIdList().add(
							VRBindPathParser.get("KOHI_ID", leftKohi));
					targetRanges.add(leftKohiRange);
				}
			}
		}

		// �����ƂɍŏI�`�F�b�N(������maxCount�𒴂���ꍇfalse��Ԃ�)
		for (int i = 0; i < targetRanges.size(); i++) {
			QU004KohiRange row = (QU004KohiRange) targetRanges.get(i);
			ArrayList rowKohiId = (ArrayList)row.getKohiIdList().clone();
			Date rowBegin = row.getBegin();
			Date rowEnd = row.getEnd();

			// �J�n���̑����錎�ɑ��݂����������J�E���g����
			int beginCount = rowKohiId.size();
			// �I�����̑����錎�ɑ��݂����������J�E���g����
			int endCount = rowKohiId.size();

			// ���̗v�f�Ƃ̔�r
			for (int j = 0; j < targetRanges.size(); j++) {
				// ���g�̓X�L�b�v
				if (i == j) {
					continue;
				}
				QU004KohiRange tempRow = (QU004KohiRange) targetRanges.get(j);
				ArrayList tempRowKohiId = tempRow.getKohiIdList();
				Date tempRowBegin = tempRow.getBegin();
				Date tempRowEnd = tempRow.getEnd();

				if (ACDateUtilities.compareOnMonth(rowBegin, tempRowEnd) == 0) {
					// ��r���F�J�n�Ɣ�r��F�I���������̏ꍇ
					// �J�n���̌��ɑ��݂��闚�����}�[�W���ăJ�E���g
					beginCount = countKohiOnMonth(rowKohiId, tempRowKohiId,
							beginCount);
				} else if (ACDateUtilities.compareOnMonth(rowBegin,
						tempRowBegin) == 0) {
					// ��r���F�J�n�Ɣ�r��F�J�n�������̏ꍇ
					// �J�n���̌��ɑ��݂��闚�����}�[�W���ăJ�E���g
					beginCount = countKohiOnMonth(rowKohiId, tempRowKohiId,
							beginCount);
				}
				if (ACDateUtilities.compareOnMonth(rowEnd, tempRowBegin) == 0) {
					// ��r���F�I���Ɣ�r��F�J�n�������̏ꍇ
					// �I�����̌��ɑ��݂��闚�����}�[�W���ăJ�E���g
					endCount = countKohiOnMonth(rowKohiId, tempRowKohiId,
							endCount);
				} else if (ACDateUtilities.compareOnMonth(rowEnd, tempRowEnd) == 0) {
					// ��r���F�I���Ɣ�r��F�I���������̏ꍇ
					// �I�����̌��ɑ��݂��闚�����}�[�W���ăJ�E���g
					endCount = countKohiOnMonth(rowKohiId, tempRowKohiId,
							endCount);
				}
				if (beginCount > maxCount || endCount > maxCount) {
					// ���E�l�˔j
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * �������̌�������J�E���g���܂��B(�}�[�W����)
	 */
	public int countKohiOnMonth(ArrayList kohiIdList, ArrayList subKohiIdList,
			int count) throws Exception {
		boolean flag;
		for (int k = 0; k < subKohiIdList.size(); k++) {
			flag = false;
			int tempId = ACCastUtilities.toInt(subKohiIdList.get(k));
			for (int l = 0; l < kohiIdList.size(); l++) {
				if (tempId == ACCastUtilities.toInt(kohiIdList.get(l))) {
					flag = true;
				}
			}
			if (!flag) {
				// ��r��������ID��ǉ����Ă���
				kohiIdList.add(new Integer(tempId));
				count++;
			}
		}
		return count;
	}

	public Component getFirstFocusComponent() {
		return getKaigoInfoPublicExpense();
	}

	/* 2007-04-05 ���j�\�h�@�Ή� change start kamitsukasa */
	/**
	 * ����̕\���E��\���𔻒肵�܂��B
	 * @param kohi			����R�[�h
	 * @param aimDate		��ƂȂ���t
	 * @param showOldKohi	�ߋ��̌����\�����邩�ǂ���
	 */
	public boolean canShowKohi(VRMap kohi, Date aimDate, int showOldKohi)
			throws Exception {

		if (showOldKohi == SHOW_KOHI) {
			// �ߋ��̌�����\������ݒ�ƂȂ��Ă���ꍇ
			return true;
		}

		Date start = ACCastUtilities.toDate(VRBindPathParser.get(
				"KOHI_VALID_START", kohi));
		Date end = ACCastUtilities.toDate(VRBindPathParser.get(
				"KOHI_VALID_END", kohi));

		if (ACDateUtilities.compareOnDay(aimDate, start) >= 0
				&& ACDateUtilities.compareOnDay(aimDate, end) <= 0) {
			// ����t���L�����ԓ��ɂ���ꍇ
			return true;
		}

		return false;
	}
	/* 2007-04-05 ���j�\�h�@�Ή� change end kamitsukasa */
}
