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
 * �J����: 
 * �쐬��: 2016/09/16  ���{�R���s���[�^�[�������  �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X �������ƃT�[�r�X�R�[�h�o�^ (017)
 * �v���O���� �������ƃT�[�r�X�R�[�h�o�^ (QO017)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo017;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.text.Format;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �������ƃT�[�r�X�R�[�h�o�^(QO017)
 */
public class QO017 extends QO017Event {

	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO017() {
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
		// �O��ʂ���̓n��p�����[�^�[��ޔ�����B
		VRMap params = affair.getParameters();
		
		if (VRBindPathParser.has("PROCESS_MODE", params)) {
			setPROCESS_MODE(String.valueOf(VRBindPathParser.get("PROCESS_MODE",
					params)));
		}
		// �f�[�^�����݂��Ă��邩���`�F�b�N
		if (VRBindPathParser.has("SYSTEM_SERVICE_CODE_ITEM", params) &&
				VRBindPathParser.has("TEKIYO_ST_DATE", params)) {
			setSystemServiceCodeItem(String.valueOf(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM",
					params)));
			setTekiyoStDate((Date) VRBindPathParser.get("TEKIYO_ST_DATE", params));
		}
		if (VRBindPathParser.has("PROCESS_MODE", params)) {
			setPROCESS_MODE(String.valueOf(VRBindPathParser.get("PROCESS_MODE",
					params)));
		}
		if (getPROCESS_MODE() == null) {
			setPROCESS_MODE(String.valueOf(QkanConstants.PROCESS_MODE_INSERT));
		}
        
		// ��������ƃT�[�r�X�R�[�h���TABLE�iM_SJ_SERVICE_CODE)��̃p�b�V�u�`�F�b�N�L�[���`����B
		setM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(new ACPassiveKey("M_SJ_SERVICE_CODE",
				new String[] { "SYSTEM_SERVICE_CODE_ITEM", "TEKIYO_ST_DATE" }, new Format[] {
				ACConstants.FORMAT_SQL_STRING, new ACSQLSafeDateFormat("yyyy-MM-dd") },
				"LAST_TIME", "LAST_TIME"));

		// �Ɩ����}�X�^���A�f�[�^���擾����B
		setAffairTitle("QO017", getButtons());

		// �ی��҃R���{�̍��ڂ�ݒ肷��B
		VRMap comboInsureMap = new VRHashMap();
		comboInsureMap.setData("INSURER_ID", QkanCommon.getInsurerInfo(getDBManager()));
		getInsurerIdCombo().setModelSource(comboInsureMap);
		getInsurerIdCombo().bindModelSource();

		// �T�[�r�X��ރR���{�̍��ڂ�ݒ肷��B
		VRMap comboMap = new VRHashMap();
		Date sysDate = QkanSystemInformation.getInstance().getSystemDate();
		comboMap.setData("SERVICE_CODE_KIND", QkanSjServiceCodeManager.getMasterServiceSogojigyo(getDBManager(), sysDate));
		// comboMap��N���C�A���g�̈�icontents�j��ɐݒ肷��B
		getServiceCodeKindCombo().setModelSource(comboMap);
		getServiceCodeKindCombo().bindModelSource();

		// �Z��P�ʃR���{�̍��ڂ�ݒ肷��B
		getSanteiTaniCombo().setModel(convertValueFromIntegerToString(300, "SANTEI_TANI", "2"));
		
		// �Z��񐔐������ԃR���{�̍��ڂ�ݒ肷��B
		getSanteiKaisuSeigenKikanCombo().setModel(convertValueFromIntegerToString(301, "SANTEI_KAISU_SEIGEN_KIKAN", "2"));

		// ���ƑΏێҎ��{�敪�R���{�̍��ڂ�ݒ肷��B
		getJigyoJisshiKbnCombo().setModel(convertValueFromIntegerToString(302, "JIGYO_TAISHOSHA_JISSHI_KBN", null));
		
		// �v�x���P�󋋎Ҏ��{�敪�R���{�̍��ڂ�ݒ肷��B
		getYoshien1JisshikbnCombo().setModel(convertValueFromIntegerToString(302, "YOSHIEN1_JUKYUSHA_JISSHI_KBN", null));

		// �v�x���Q�󋋎Ҏ��{�敪�R���{�̍��ڂ�ݒ肷��B
		getYoshien2JisshikbnCombo().setModel(convertValueFromIntegerToString(302, "YOSHIEN2_JUKYUSHA_JISSHI_KBN", null));

		// DB��背�R�[�h���擾���A��ʂɓW�J����B
		doFind();

		if (getPROCESS_MODE().equals(
				Integer.toString(QkanConstants.PROCESS_MODE_INSERT))) {
			// �V�K�̏ꍇ�́A�ی��Ҕԍ��������p��
			if (VRBindPathParser.has("INSURER_ID", params)) {
				// �V�K�A�N���A���̏����l�p�ɑޔ�
				setInsurerId(String.valueOf(VRBindPathParser.get("INSURER_ID", params)));
				getInsurerIdText().setText(String.valueOf(VRBindPathParser.get("INSURER_ID", params)));
			}

		} else if (getPROCESS_MODE().equals(
				Integer.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
			setInsurerId(getInsurerIdText().getText());
		}
		// �ی��҃R���{��\������
		insurerComboSelected();

		// �X�i�b�v�V���b�g���B�e����
		snapshotCustom();
	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		
		// �O��ʂɑJ�ڂ��鏈���B
		// �ύX���`�F�b�N����B���X�i�b�v�V���b�g
		if (getSnapshot().isModified()) {
			// �ύX����Ă����ꍇ
			// �o�^�m�F���b�Z�[�W��\������B�����b�Z�[�WID = CAN_BACK_ON_INSERT
			int msgID = QkanMessageList.getInstance()
					.WARNING_OF_UPDATE_ON_MODIFIED();
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// ��o�^���Ė߂飉�����
				if (!doValidSjServiceCodeInfoCheck()) {
					return false;
				}

				// �o�^�������s���B
				if(!doSave()){
					return false;
				}

				// �n���p�����[�^�[���쐬����B
				parameters
						.setData("QO016.class", this.getClass().getName());
				parameters.setData("SYSTEM_SERVICE_CODE_ITEM", getSystemServiceCodeItem());
				parameters.setData("TEKIYO_ST_DATE", getTekiyoStDate());

				// �O��ʂɑJ�ڂ���B
				return true;
			case ACMessageBox.RESULT_NO:
				// ��j�����Ė߂飉�����
				// �n���p�����[�^�[���쐬����B
				parameters
						.setData("QO016.class", this.getClass().getName());
				// �X�V���[�h�̎��A�J�ڐ�փp�����[�^��n���B
				if (getPROCESS_MODE().equals(Integer.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
					parameters.setData("SYSTEM_SERVICE_CODE_ITEM", getSystemServiceCodeItem());
					parameters.setData("TEKIYO_ST_DATE", getTekiyoStDate());
				}

				// �O��ʂɑJ�ڂ���B
				return true;
			case ACMessageBox.RESULT_CANCEL:
				return false;
				
			}
		} else {
			// �ύX����Ă��Ȃ������ꍇ
			// �n���p�����[�^�[���쐬����B
			parameters.setData("QO016.class", this.getClass().getName());
			// �X�V���[�h�̎��A�J�ڐ�փp�����[�^��n���B
			if (getPROCESS_MODE().equals(
					Integer.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
				parameters.setData("SYSTEM_SERVICE_CODE_ITEM", getSystemServiceCodeItem());
				parameters.setData("TEKIYO_ST_DATE", getTekiyoStDate());
			}

			// �O��ʂɑJ�ڂ���B
			return true;
		}
		// �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
		return true;
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
	 * �u�o�^�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {
		// �������ƃT�[�r�X�R�[�h���̓��̓`�F�b�N���s���B
		if (doValidSjServiceCodeInfoCheck()) {
			// �o�^�������s���B
			if (doSave()) {
				// PROCESS_MODE���A���ʒ萔�PROCESS_MODE_UPDATE(3)��ɕύX����B
				setPROCESS_MODE(Integer
						.toString(QkanConstants.PROCESS_MODE_UPDATE));
				// �o�^�������b�Z�[�W��\������B�����b�Z�[�WID = INSERT_SUCCESSED
				QkanMessageList.getInstance().INSERT_SUCCESSED();
				// DB��背�R�[�h���擾���A��ʂɓW�J����B
				doFind();
				// �X�i�b�v�V���b�g���B�e����B
				snapshotCustom();
			}
		}
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
		// �������ƃT�[�r�X�R�[�h�����X�V���鏈��
		if (doValidSjServiceCodeInfoCheck()) {
			// �X�V�������s���B
			if (doSave()) {
				// �X�V�������b�Z�[�W��\������B�����b�Z�[�WID = UPDATE_SUCCESSED
				QkanMessageList.getInstance().UPDATE_SUCCESSED();
				// DB��背�R�[�h���擾���A��ʂɓW�J����B
				doFind();
				// �X�i�b�v�V���b�g���B�e����B
				snapshotCustom();
			}
		}
	}

	/**
	 * �u�V�K�o�^���[�h�ύX�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void newDataActionPerformed(ActionEvent e) throws Exception {
		// �V�K�o�^���[�h�ύX���鏈��
		// �ύX�`�F�b�N���s���B ���X�i�b�v�V���b�g
		if (getSnapshot().isModified()) {
			// �ύX���������ꍇ
			// �V�K�o�^���[�h�J�ڊm�F���b�Z�[�W��\������B �����b�Z�[�WID = WARNING_OF_CLEAR_ON_MODIFIED
			int msgID = QkanMessageList.getInstance()
					.WARNING_OF_CLEAR_ON_MODIFIED();
			// �uOK�v�������ꍇ
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// �V�K�o�^���[�h�ɕύX����
				insertModeChange();
				// ��ʂ̏�Ԃ�ύX����B
				setState_INIT_STATE();
				// �ی��Ҕԍ��Ƀt�H�[�J�X
				getInsurerIdText().requestFocus();
				// �X�i�b�v�V���b�g���B�e����B
				snapshotCustom();
			}
		} else {
			// �V�K�o�^���[�h�ɕύX����
			insertModeChange();
			// ��ʂ̏�Ԃ�ύX����B
			setState_INIT_STATE();
			// �ی��Ҕԍ��Ƀt�H�[�J�X
			getInsurerIdText().requestFocus();
			// �X�i�b�v�V���b�g���B�e����B
			snapshotCustom();
		}
	}

	/**
	 * �u��ʏ��̃N���A�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void clearActionPerformed(ActionEvent e) throws Exception {
		// ��ʏ����N���A���鏈��
		// �ύX�`�F�b�N���s���B ���X�i�b�v�V���b�g
		if (getSnapshot().isModified()) {
			// �ύX���������ꍇ
			// �m�F���b�Z�[�W��\������ �����b�Z�[�WID = WARNING_OF_CLEAR_ON_MODIFIED
			int msgID = QkanMessageList.getInstance()
					.WARNING_OF_CLEAR_ON_MODIFIED();
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// �uOK�v�������ꍇ
				// �N���A�������s��
				allClear();
			}
		} else {
			allClear();
		}

	}

	/**
	 * �u�ی��Җ��\���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insurerIdTextFocusLost(FocusEvent e) throws Exception {

		String insureNo = getInsurerIdText().getText();
		for (int i = 0; getInsurerIdCombo().getModel().getSize() > i; i++) {
			VRMap map = (VRMap) getInsurerIdCombo().getModelItem(i);
			if (insureNo.equals(map.getData("INSURER_ID"))) {
				getInsurerIdCombo().setSelectedIndex(i);
				return;
			}
		}
		getInsurerIdCombo().setSelectedItem(null);

	}
	
	/**
	 * �u�ی��Җ��̃R���{�{�b�N�X�I�����̏����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insurerIdComboActionPerformed(ActionEvent e)
			throws Exception {
		// �I�����ꂽ�R���{�̃C���f�b�N�X
		int index = getInsurerIdCombo().getSelectedIndex();

		if (index < 0)
			return;

		VRMap map = (VRMap) getInsurerIdCombo().getSelectedItem();
		String insureNo = ACCastUtilities.toString(map.get("INSURER_ID"));

		if (insureNo == null)
			return;
		
		// ��ʏ�ɐݒ肷��B
		getInsurerIdText().setText(insureNo);
	}

	// �����֐�

	/**
	 * �u���R�[�h���擾����ʂɐݒ肷��B�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFind() throws Exception {
		// ������ʓW�J���s������
		// �������ƃT�[�r�X�R�[�h���TABLE�ɑ��݂���A�������ƃT�[�r�X�R�[�h�����擾����B
		VRMap param = new VRHashMap();

		if (getSystemServiceCodeItem() != null &&
				getTekiyoStDate() != null) {
			param.setData("SYSTEM_SERVICE_CODE_ITEM", getSystemServiceCodeItem());
			param.setData("TEKIYO_ST_DATE", getTekiyoStDate());

			// �������ƃT�[�r�X�R�[�h�����擾���邽�߂�SQL�����擾����B
			// �擾����SQL�������s����B
			setSjServiceCodeInfoList(getDBManager().executeQuery(
					getSQL_GET_M_SJ_SERVICE_CODE_INFO(param)));
		}

		// ���R�[�h���擾�ł����ꍇ
		if (getSjServiceCodeInfoList().size() > 0) {
			setPROCESS_MODE(String.valueOf(QkanConstants.PROCESS_MODE_UPDATE));
			// �擾�������R�[�h��sjServiceCodeInfoMap�Ɋi�[����B
			setSjServiceCodeInfoMap((VRMap) getSjServiceCodeInfoList().getData());
			// �������ƃT�[�r�X�R�[�h���TABLE�p�b�V�u�`�F�b�N�p�Ƀf�[�^��o�^����B
			getPassiveChecker().reservedPassive(
					getM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(), getSjServiceCodeInfoList());
			// ��ʏ�Ԃ�ύX����B
			setState_UPDATE_STATE();

		} else {
			// ���R�[�h���擾�ł��Ȃ������ꍇ
			setPROCESS_MODE(String.valueOf(QkanConstants.PROCESS_MODE_INSERT));

			setSjServiceCodeInfoMap((VRMap) getContents().createSource());
			getContents().setSource(getSjServiceCodeInfoMap());
			getContents().bindSource();
			// ��ʏ�Ԃ�ύX����B
			setState_INSERT_STATE();
		}
		
		// �擾�����������ƃT�[�r�X�R�[�h���𢑍�����ƃT�[�r�X�R�[�h�����͗̈棂ɐݒ肷��B
		getSjServiceCodeInfos().setSource(getSjServiceCodeInfoMap());
		// ��ʂɓW�J����B
		getSjServiceCodeInfos().bindSource();

		// �t�H�[�J�X����
		if (getPROCESS_MODE().equals(
				String.valueOf(QkanConstants.PROCESS_MODE_INSERT))) {
			getInsurerIdText().requestFocus();
		} else {
			getTekiyoKikanEd().requestFocus();
			// �T�[�r�X��ޖ��̂́A���̂�\������
			VRMap serviceCodeKindMap = (VRMap) getServiceCodeKindCombo().getSelectedItem();
			getServeceCodeKindNameText().setText(ACCastUtilities.toString(serviceCodeKindMap.get("SERVICE_NAME")));
		}
	}

	/**
	 * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doSave() throws Exception {

		// ���̓��[�h��INSERT�̎�
		if (getPROCESS_MODE().equals(
				Integer.toString(QkanConstants.PROCESS_MODE_INSERT))) {

			// �T�[�r�X��ރR�[�h���V�X�e���T�[�r�X��ރR�[�h���擾����
			int systemServiceKindDetail = getSystemServiceKindDetail();
			if (systemServiceKindDetail == 0) {
				QkanMessageList.getInstance().QO017_ERROR_OF_FOR_INPUT_SYSTEM_KIND_DETAIL();
				getServiceCodeKindCombo().requestFocus();
				return false;
			}

			// �V�X�e���T�[�r�X���ڃR�[�h��g�ݗ��Ă�
			// �ی��Ҕԍ��{�V�X�e���T�[�r�X��ރR�[�h�{�T�[�r�X���ڃR�[�h
			StringBuilder sb = new StringBuilder();
			sb.append(getInsurerIdText().getText());
			sb.append(ACCastUtilities.toString(systemServiceKindDetail));
			sb.append(getServiceCodeItemText().getText());
			// 15���łȂ������ꍇ�̓G���[�ɂ���
			if (sb.length() != 15) {
				QkanMessageList.getInstance().QO017_ERROR_OF_FOR_INPUT_SYSTEM_CODE_ITEM();
				getServiceCodeKindCombo().requestFocus();
				return false;
			}
			String systemServiceCodeItem = sb.toString();

			// �ꎞ�ޔ�map
			VRMap map = new VRHashMap();
			map.setData("SYSTEM_SERVICE_CODE_ITEM", systemServiceCodeItem);
			map.setData("TEKIYO_ST_DATE", getTekiyoKikanSt().getDate());

			// �ꎞ�ޔ�list
			VRList list = null;

			list = getDBManager().executeQuery(
					getSQL_GET_M_SJ_SERVICE_CODE_INFO_DELETE_FLAG(map));
			// �폜�ς݂Ƀf�[�^�����邩�ǂ����̃`�F�b�N������
			if (list.size() > 0) {
				int msgID = QkanMessageList.getInstance()
						.WARNING_OF_RESTORATION_OF_DELETE_DATA("�������ƃT�[�r�X�R�[�h", "�������ƃT�[�r�X�R�[�h");

				switch (msgID) {
				case ACMessageBox.RESULT_OK:
					setSystemServiceCodeItem(systemServiceCodeItem);
					setTekiyoStDate(getTekiyoKikanSt().getDate());
					doFind();
					return false;

				case ACMessageBox.RESULT_CANCEL:
					return false;
				}
			}

			list = getDBManager().executeQuery(getSQL_GET_M_SJ_SERVICE_CODE_INFO(map));
			// ���ɓo�^�ς݂��`�F�b�N����B
			if (list.size() > 0) {
				QkanMessageList.getInstance().QO017ERROR_OF_OVERLAP();
				getInsurerIdText().requestFocus();
				return false;
			}

			// ��ʏ�ł͓ǂݎ��Ȃ�����t��
			getSjServiceCodeInfoMap().setData("SYSTEM_SERVICE_CODE_ITEM", systemServiceCodeItem);
			getSjServiceCodeInfoMap().setData("SYSTEM_SERVICE_KIND_DETAIL", systemServiceKindDetail);

		}

		// �������ƃT�[�r�X�R�[�h�̏���DB�ɓo�^����B
		try {
			// �g�����U�N�V�������J�n����B
			getDBManager().beginTransaction();

			// �p�b�V�u�^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();

			// ��ʏ�̏����擾��sjServiceCodeInfoMap�Ɋi�[����
			getSjServiceCodeInfos().setSource(getSjServiceCodeInfoMap());
			getSjServiceCodeInfos().applySource();

			// �x�����x�z�Ώۋ敪���u�Ώہv�ȊO�̏ꍇ�A�󕶎���ɕϊ�
			if (!getShikyuGendogakuTaishoKbnTaisho().isSelected()) {
				getSjServiceCodeInfoMap().setData("SHIKYU_GENDOGAKU_TAISHO_KBN", "");
			}

			// �I���� �󔒎� 
			if (ACTextUtilities.isNullText(getTekiyoKikanEd().getText())) {
				getSjServiceCodeInfoMap().setData("TEKIYO_ED_DATE", MAX_DATE);
			} else {
				getSjServiceCodeInfoMap().setData("TEKIYO_ED_DATE", getTekiyoKikanEd().getDate());
			}

			getSjServiceCodeInfoList().clearData();
			getSjServiceCodeInfoList().addData(getSjServiceCodeInfoMap());

			// PROCESS_MODE�̒l���`�F�b�N����B
			if (getPROCESS_MODE().equals(
					String.valueOf(QkanConstants.PROCESS_MODE_INSERT))) {

				// �V�K�o�^��A��ʍĕ\���̍ۂɃL�[���Z�b�g���Ă���
				setSystemServiceCodeItem(String.valueOf(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM",
						getSjServiceCodeInfoMap())));
				setTekiyoStDate((Date) VRBindPathParser.get("TEKIYO_ST_DATE", getSjServiceCodeInfoMap()));

				getSjServiceCodeInfoMap().setData("KOKUHO_ITAKU_KBN", "1");// �ϑ��敪�́A�V�K�̏ꍇ�́u����v
				
				// �p�b�V�u�^�X�N��o�^����B�iINSERT�j ���������ƃT�[�r�X�R�[�h���o�^�p
				getPassiveChecker().addPassiveInsertTask(
						getM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(),
						getSjServiceCodeInfoList());

			} else if (getPROCESS_MODE().equals(
					Integer.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
				// �p�b�V�u�^�X�N��o�^����B�iUPDATE�j ���������ƃT�[�r�X�R�[�h���X�V�p
				getPassiveChecker().addPassiveUpdateTask(
						getM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY());
			}
			
			// �p�b�V�u�`�F�b�N���s��
			if (!getPassiveChecker().passiveCheck(getDBManager())) {
				// �p�b�V�u�G���[�����������ꍇ
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
				getDBManager().rollbackTransaction();
				return false;
			} else {
				// �p�b�V�u�G���[���������Ȃ������ꍇ
				if (getPROCESS_MODE().equals(
						Integer.toString(QkanConstants.PROCESS_MODE_INSERT))) {

					// �������ƃT�[�r�X�R�[�h���o�^�̂��߂�SQL�������s����B
					getDBManager().executeUpdate(
							getSQL_INSERT_M_SJ_SERVICE_CODE(getSjServiceCodeInfoMap()));

				} else {
					// �������ƃT�[�r�X�R�[�h���X�V�̂��߂�SQL�������s����B
					getDBManager().executeUpdate(
							getSQL_UPDATE_M_SJ_SERVICE_CODE_INFO(getSjServiceCodeInfoMap()));
				}
			}
		} catch (Exception sqlEx) {
			// SQL���s���ɃG���[�����������ꍇ
			sqlEx.printStackTrace();

			getDBManager().rollbackTransaction();
			// �����𔲂���B�i�����𒆒f����j
			throw sqlEx;
		}
		// 1���G���[���������Ȃ������ꍇ
		// �������R�~�b�g����B
		getDBManager().commitTransaction();
		// �i����I���j

		return true;
	}

	/**
	 * �u�������ƃT�[�r�X�R�[�h�����̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doValidSjServiceCodeInfoCheck() throws Exception {
		// ��ی��Ҕԍ��iinsurerId�j������͂���Ă��邩�`�F�b�N����
		if (ACTextUtilities.isNullText(getInsurerIdText().getText())) {
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT ��1���� =
			// "�ی��Ҕԍ�"
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("�ی��Ҕԍ�");
			// ��ی��Ҕԍ��iinsurerId�j��Ƀt�H�[�J�X�𓖂Ă�B
			getInsurerIdText().requestFocus();
			// �����𔲂���B�i�����𒆒f����j
			return false;
		}

		if (getInsurerIdText().getText().length() != 6) {
			QkanMessageList.getInstance().ERROR_OF_LENGTH("�ی��Ҕԍ�", "6");
			// ��ی��Ҕԍ��iinsurerId�j��Ƀt�H�[�J�X�𓖂Ă�B
			getInsurerIdText().requestFocus();
			// �����𔲂���B�i�����𒆒f����j
			return false;
		}
		
		// �ی��Ҕԍ������݂��邩�`�F�b�N����
		boolean insurerIdExists = false;
		String insureNo = getInsurerIdText().getText();
		for (int i = 0; getInsurerIdCombo().getModel().getSize() > i; i++) {
			VRMap map = (VRMap) getInsurerIdCombo().getModelItem(i);
			if (insureNo.equals(map.getData("INSURER_ID"))) {
				insurerIdExists = true;
				break;
			}
		}
		if (!insurerIdExists) {
			ACMessageBox.show("�ی��Ҕԍ����o�^����Ă��܂���B");
			getInsurerIdText().requestFocus();
			return false;
		}

		// �T�[�r�X��ނ����͂���Ă��邩�`�F�b�N����
		if (!getServiceCodeKindCombo().isSelected()) {
			QkanMessageList.getInstance()
			.ERROR_OF_NEED_CHECK_FOR_INPUT("�T�[�r�X���");
			getServiceCodeKindCombo().requestFocus();
			return false;
		}

		// �T�[�r�X���ڂ����͂���Ă��邩�`�F�b�N����
		if (ACTextUtilities.isNullText(getServiceCodeItemText().getText())) {
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("�T�[�r�X����");
			getServiceCodeItemText().requestFocus();
			return false;
		}

		if (getServiceCodeItemText().getText().length() != 4) {
			QkanMessageList.getInstance().ERROR_OF_LENGTH("�T�[�r�X����", "4");
			getServiceCodeItemText().requestFocus();
			return false;
		}

		// �K�p�J�n�N���������͂���Ă��邩�`�F�b�N����
		if (ACTextUtilities.isNullText(getTekiyoKikanSt().getText())) {
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("�K�p�J�n�N����");
			getTekiyoKikanSt().requestFocus();
			return false;
		} else {
			// ���t�^���ǂ����̃`�F�b�N
			if (!getTekiyoKikanSt().isValidDate()) {
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�K�p�J�n�N����");
				getTekiyoKikanSt().requestFocus();
				return false;
			}
		}

		// �K�p�I���N���������͂���Ă��邩�`�F�b�N����
		if (!ACTextUtilities.isNullText(getTekiyoKikanEd().getText())) {
			// ���t�^���ǂ����̃`�F�b�N
			if (!getTekiyoKikanEd().isValidDate()) {
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�K�p�I���N����");
				getTekiyoKikanEd().requestFocus();
				return false;
			}
		}

		// �i�J�n�j���i�I���j���`�F�b�N
		if (!ACTextUtilities.isNullText(getTekiyoKikanSt().getText()) &&
				!ACTextUtilities.isNullText(getTekiyoKikanEd().getText())) {
			if (ACDateUtilities
					.compareOnDay(
							ACCastUtilities.toDate(getTekiyoKikanSt().getText()),
							ACCastUtilities.toDate(getTekiyoKikanEd().getText())) == 1) {
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�K�p����");
				getTekiyoKikanEd().requestFocus();
				return false;
			}
		}

		// �T�[�r�X���̂����͂���Ă��邩�`�F�b�N����
		if (ACTextUtilities.isNullText(getServiceNameText().getText())) {
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("�T�[�r�X����");
			getServiceNameText().requestFocus();
			return false;
		}

		// �P�ʐ������͂���Ă��邩�`�F�b�N����
		if (ACTextUtilities.isNullText(getServiceUnitText().getText())) {
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("�P�ʐ�");
			getServiceUnitText().requestFocus();
			return false;
		} else {
			if (getServiceUnitText().getText().equals("-")) {
				QkanMessageList.getInstance()
				.ERROR_OF_NEED_CHECK_FOR_INPUT("�P�ʐ�");
				getServiceUnitText().requestFocus();
				return false;
			}
		}

		// �Z��P�ʂ����͂���Ă��邩�`�F�b�N����
		if (!getSanteiTaniCombo().isSelected()) {
			QkanMessageList.getInstance()
			.ERROR_OF_NEED_CHECK_FOR_INPUT("�Z��P��");
			getSanteiTaniCombo().requestFocus();
			return false;
		}

		// �x�����x�z�Ώۋ敪�����͂���Ă��邩�`�F�b�N����
		if (!getShikyuGendogakuTaishoKbn().isSelected()) {
			QkanMessageList.getInstance()
			.ERROR_OF_NEED_CHECK_FOR_INPUT("�x�����x�z�Ώۋ敪");
			getShikyuGendogakuTaishoKbn().requestFocus();
			return false;
		}

		// ���t���ɓ��͂���Ă���l���s���łȂ����ǂ���
		int benefitRate = ACCastUtilities.toInt(getKyufuritsuText().getText(), 0);
		if (benefitRate < 0 || benefitRate > 100) {
			QkanMessageList.getInstance().ERROR_OF_VALUE_TOO_MUCH(
					"���t��", "100");
			getKyufuritsuText().requestFocus();
			return false;
		}

		if (!ACTextUtilities.isNullText(getFutangakuText().getText()) &&
				(getFutangakuText().getText().equals("-"))) {
			QkanMessageList.getInstance()
			.ERROR_OF_NEED_CHECK_FOR_INPUT("���p�ҕ��S�z");
			getFutangakuText().requestFocus();
			return false;
		}

		// ���ƑΏێҎ��{�敪�����͂���Ă��邩�`�F�b�N����
		if (!getJigyoJisshiKbnCombo().isSelected()) {
			QkanMessageList.getInstance()
			.ERROR_OF_NEED_CHECK_FOR_INPUT("���ƑΏێҎ��{�敪");
			getJigyoJisshiKbnCombo().requestFocus();
			return false;
		}

		// �v�x���P���{�敪�����͂���Ă��邩�`�F�b�N����
		if (!getYoshien1JisshikbnCombo().isSelected()) {
			QkanMessageList.getInstance()
			.ERROR_OF_NEED_CHECK_FOR_INPUT("�v�x���P�󋋎Ҏ��{�敪");
			getYoshien1JisshikbnCombo().requestFocus();
			return false;
		}

		// �v�x���Q���{�敪�����͂���Ă��邩�`�F�b�N����
		if (!getYoshien2JisshikbnCombo().isSelected()) {
			QkanMessageList.getInstance()
			.ERROR_OF_NEED_CHECK_FOR_INPUT("�v�x���Q�󋋎Ҏ��{�敪");
			getYoshien2JisshikbnCombo().requestFocus();
			return false;
		}

		// �쐬�N���������͂���Ă��邩�`�F�b�N����
		if (ACTextUtilities.isNullText(getSakuseiDate().getText())) {
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("�쐬�N����");
			getSakuseiDate().requestFocus();
			return false;
		} else {
			// ���t�^���ǂ����̃`�F�b�N
			if (!getSakuseiDate().isValidDate()) {
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�쐬�N����");
				getSakuseiDate().requestFocus();
				return false;
			}
		}

		return true;
	}

	/**
	 * �u�V�K�o�^���[�h�ɕύX���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void insertModeChange() throws Exception {
		// �V�K�o�^���[�h�ɕύX���鏈��
		// ��ʃN���A�̂���allClearMap�𐶐�����B
		VRMap allClearMap = new VRHashMap();
		// allClearMap�̃\�[�X�𐶐�����B�i�V�K�o�^���N���A�����ɗp����j
		allClearMap = (VRMap) getSjServiceCodeInfos().createSource();
		getSjServiceCodeInfos().setSource(allClearMap);
		getSjServiceCodeInfos().bindSource();
		
		// �O��ʂ�������p�����ی��Ҕԍ����Z�b�g
		if (!ACTextUtilities.isNullText(getInsurerId())) {
			getInsurerIdText().setText(getInsurerId());
			// �ی��҃R���{��\������
			insurerComboSelected();
		}

		// PROCESS_MODE���A���ʒ萔�̢PROCESS_MODE_INSERT(4)��ɂ���B
		setPROCESS_MODE(Integer.toString(QkanConstants.PROCESS_MODE_INSERT));
	}

	/**
	 * �u��ʂ��N���A���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void allClear() throws Exception {
		insertModeChange();
		// ��ʂ̏�Ԃ�ύX����B
		setState_INIT_STATE();
		// �t�H�[�J�X�ݒ�
		getInsurerIdText().requestFocus();
	}

	/**
	 * �u�X�i�b�v�V���b�g���B�e���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void snapshotCustom() throws Exception {
		// �X�i�b�v�V���b�g���B�e���鏈��
		// �X�i�b�v�V���b�g�̎B�e�Ώۂ��w�肷��B
		getSnapshot().setRootContainer(getContents());
		// �X�i�b�v�V���b�g���B�e����
		getSnapshot().snapshot();
	}
	
	/**
	 * �T�[�r�X��ރR�[�h���V�X�e���T�[�r�X��ރR�[�h���擾����
	 */
	private int getSystemServiceKindDetail() throws Exception, ParseException {
		VRMap mServiceMap = QkanCommon.getMasterService(getDBManager(), 
				QkanSystemInformation.getInstance().getSystemDate());
		Iterator it = mServiceMap.values().iterator();
		VRMap mServiceKeyMap = new VRHashMap();
		while (it.hasNext()) {
			VRMap row = (VRMap) it.next();
			mServiceKeyMap.put(String.valueOf(VRBindPathParser.get("SERVICE_CODE_KIND",
					row)), VRBindPathParser
					.get("SYSTEM_SERVICE_KIND_DETAIL", row));
		}
		// �V�X�e���T�[�r�X��ރR�[�h���擾����iM_SERVICE�j
		VRMap serviceCodeKindMap = (VRMap) getServiceCodeKindCombo().getSelectedItem();
		String serviceCodeKind = ACCastUtilities.toString(serviceCodeKindMap.get("SERVICE_CODE_KIND"));
		int systemServiceKindDetail = ACCastUtilities.toInt(mServiceKeyMap.get(serviceCodeKind), 0);
		return systemServiceKindDetail;
	}


	/**
	 * �u�R�[�h�}�X�^�f�[�^�̎w��L�[�̃f�[�^�^��Integer����String�ɕϊ��v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception ������O
	 */
	private static VRList convertValueFromIntegerToString(int codeId, String key, String formatLength)
			throws Exception {
		VRList codeList = QkanCommon.getArrayFromMasterCode(codeId, key);
		if ((codeList != null) && (key != null)) {
			for (int i = 0; i < codeList.size(); i++) {
				VRMap map = (VRMap)codeList.get(i);
				Object targetData = VRBindPathParser.get(key, map);
				String convertValue = "";
				if (formatLength == null) {
					convertValue = ACCastUtilities.toString(targetData, null);
				} else {
					String targetFormat = "%" + formatLength + "s";
					convertValue = String.format(targetFormat, targetData).replace(" ", "0");
				}
				VRBindPathParser.set(key, map, convertValue);
			}
		}
		return codeList;
    }
	
	// �ی��҃R���{��\������
	private void insurerComboSelected() {
		// �ی��҃R���{��\������
		String insureNo = getInsurerIdText().getText();
		for (int i = 0; getInsurerIdCombo().getModel().getSize() > i; i++) {
			VRMap map = (VRMap) getInsurerIdCombo().getModelItem(i);
			if (insureNo.equals(map.getData("INSURER_ID"))) {
				getInsurerIdCombo().setSelectedIndex(i);
				break;
			}
		}
	}



}
