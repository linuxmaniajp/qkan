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
 * �쐬��: 2006/02/06  ���{�R���s���[�^�[������� ��i�@�a�P
 * �X�V��: 2006/03/09
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (004)
 * �v���O���� ���׏���{���ҏW (QP004)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp004;

import java.awt.event.ActionEvent;
import java.awt.im.InputSubset;
import java.text.Format;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACTableCellViewerCustomCell;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACCharacterConverter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qp.qp003.QP003;
import jp.or.med.orca.qkan.affair.qp.qp005.QP005;
import jp.or.med.orca.qkan.component.QkanDateTextField;
import jp.or.med.orca.qkan.text.QkanCustomForClaimCodeMasterFormat;

/**
 * ���׏���{���ҏW(QP004)
 */
public class QP004 extends QP004Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QP004() {
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
		// �EpatientId KEY�FPATIENT_ID
		// �EclaimDate KEY�FCLAIM_DATE
		// �EinsuredId KEY�FINSURED_ID
		// �EproviderId KEY�FPROVIDER_ID
		// �ElistIndex KEY�FLIST_INDEX
		// �EtargetDate KEY�FTARGET_DATE
		// �EclaimStyleType KEY�FCLAIM_STYLE_TYPE

		VRMap parameters = affair.getParameters();

		if (VRBindPathParser.has("PATIENT_ID", parameters)) {
			setPatientId(ACCastUtilities.toInt(parameters.getData("PATIENT_ID")));
		}

		if (VRBindPathParser.has("CLAIM_DATE", parameters)) {
			setClaimDate(ACCastUtilities.toDate(parameters.getData("CLAIM_DATE")));
		}

		if (VRBindPathParser.has("INSURED_ID", parameters)) {
			setInsuredId(ACCastUtilities.toString(parameters.getData("INSURED_ID")));
		}

		if (VRBindPathParser.has("PROVIDER_ID", parameters)) {
			setProviderId(ACCastUtilities.toString(parameters.getData("PROVIDER_ID")));
		}

		if (VRBindPathParser.has("LIST_INDEX", parameters)) {
			setListIndex(ACCastUtilities.toInt(parameters.getData("LIST_INDEX")));
		}

		if (VRBindPathParser.has("TARGET_DATE", parameters)) {
			setTargetDate(ACCastUtilities.toDate(parameters.getData("TARGET_DATE")));
		}

		if (VRBindPathParser.has("CLAIM_STYLE_TYPE", parameters)) {
			setClaimStyleType(ACCastUtilities.toInt(parameters.getData("CLAIM_STYLE_TYPE")));
		}

		// �p�b�V�u�`�F�b�N�̃L�[���`����B
		// TABLE�FCLAIM
		// �L�[�FCLAIM_ID
		// �t�H�[�}�b�g�F���l
		// �N���C�A���g�^�C���t�B�[���h�FLAST_TIME
		// �T�[�o�^�C���t�B�[���h�FLAST_TIME
		setPASSIVE_CHECK_KEY(new ACPassiveKey("CLAIM", new String[] { "CLAIM_ID" }, new Format[] { null }, "LAST_TIME", "LAST_TIME"));

		// ���[�`���e�X�g�p�̈�
		// �X�i�b�v�V���b�g�̎B�e�Ώۂ��u�N���C�A���g�̈�icontents�j�v�ɐݒ肷��B
		getSnapshot().setRootContainer(getContents());
		// ��ʂ̏��������s���B
		initialize();

		// �����f�[�^���擾���A��ʂɓW�J����B
		doFind();

		// �X�i�b�v�V���b�g���B�e����B
		getSnapshot().snapshot();

	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�̃`�F�b�N�A��ʃe�[�u���̃`�F�b�N�j
		// �Ō�ɕۑ�����Ă���A���ځE��ʃe�[�u�����ύX����Ă���ꍇ(���L�̂����ꂩ�̏ꍇ)
		// �EisModified
		// �EtableChangedFlg = 1
		// �m�F���b�Z�[�W��\������B
		// �E���b�Z�[�WID�FWARNING_OF_UPDATE_ON_MODIFIED
		// �u�͂��v��I�������ꍇ
		// ���̓`�F�b�N���s���B
		// ���̓G���[���������ꍇ
		// �����𒆒f����B(�I��)
		if (getSnapshot().isModified() || (getTableChangedFlg() == FLAG_ON)) {
			int selectButton = QkanMessageList.getInstance().WARNING_OF_UPDATE_ON_MODIFIED();
			switch (selectButton) {
				case ACMessageBox.RESULT_YES:
					if (isValidInput() && doSave()) {
						// �ۑ��������s���B
					} else {
						// �ۑ�����������I�����Ȃ������ꍇ
						// �����𒆒f����B(�I��)

						return false;
					}
					break;

				case ACMessageBox.RESULT_CANCEL:
					return false;

				default:
			}
		}
		// ���L��n��p�����[�^�Ƃ��āA�uQP003 ���[�i�l���j�E���Ə��I���v��ʂɑJ�ڂ���B
		// �EKEY�FPATIENT_ID VALUE�FpatientId
		// �EKEY�FCLAIM_DATE VALUE�FclaimDate
		// �EKEY�FLIST_INDEX VALUE�FlistIndex
		parameters.setData("PATIENT_ID", ACCastUtilities.toInteger(getPatientId()));
		parameters.setData("CLAIM_DATE", getClaimDate());
		parameters.setData("LIST_INDEX", ACCastUtilities.toInteger(getListIndex()));

		// KEY�FNEXT_AFFAIR VALUE�FQP003
		parameters.setData("NEXT_AFFAIR", "QP003");

		// QP003 ���[�i�l���j�E���Ə��I���Ŏg�p����n���p�����[�^�[�̍쐬���s���B
		ACAffairInfo affair = new ACAffairInfo(QP003.class.getName(), parameters);
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�A�e�[�u���̃`�F�b�N�j
		// �Ō�ɕۑ�����Ă���A���ځE��ʃe�[�u�����ύX����Ă���ꍇ(���L�̂����ꂩ�̏ꍇ)
		if (getSnapshot().isModified() || (getTableChangedFlg() == FLAG_ON)) {
			if (QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED() == ACMessageBox.RESULT_YES) {
				// �EisModified
				// �EtableChangedFlg = 1
				// �I���m�F���b�Z�[�W��\������B
				// �E���b�Z�[�WID�FWARNING_OF_CLOSE_ON_MODIFIED
			} else {
				// �u�L�����Z���v��I�������ꍇ
				// �����𒆒f����i�������Ȃ��j�B
				// �V�X�e�����I������B
				return false;
			}
		}
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
	protected void updateActionPerformed(ActionEvent e) throws Exception {
		// ���̓`�F�b�N���s���B
		if (isValidInput()) {
			// �ۑ��������s���B
			if (doSave()) {
				// �ۑ�����������I�������ꍇ
				// changedFlg��0�i�ύX�Ȃ��j��������B
				setTableChangedFlg(FLAG_OFF);
				// �������b�Z�[�W��\������B
				QkanMessageList.getInstance().UPDATE_SUCCESSED();
				// �E���b�Z�[�WID�FUPDATE_SUCCESSED
			} else {
				// �ۑ�����������I�����Ȃ������ꍇ
				// �����𒆒f����B(�I��)
			}
		}
		// ���̓G���[���������ꍇ
		// �����𒆒f����B(�I��)
	}

	/**
	 * �u�ڍׁv�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void detailActionPerformed(ActionEvent e) throws Exception {
		// �ύX�`�F�b�N�i�X�i�b�v�V���b�g�̃`�F�b�N�A��ʃe�[�u���̃`�F�b�N�j
		// �Ō�ɕۑ�����Ă���A���ځE��ʃe�[�u�����ύX����Ă���ꍇ(���L�̂����ꂩ�̏ꍇ)
		// �EisModified
		// �EtableChangedFlg = 1
		// �m�F���b�Z�[�W��\������B
		// �E���b�Z�[�WID�FWARNING_OF_UPDATE_ON_MODIFIED
		// �u�͂��v��I�������ꍇ
		// ���̓`�F�b�N���s���B
		// ���̓G���[���������ꍇ
		// �����𒆒f����B(�I��)
		if (getSnapshot().isModified() || (getTableChangedFlg() == FLAG_ON)) {
			int selectButton = ACMessageBox.showYesNoCancel("�ύX����Ă��܂��B" + ACConstants.LINE_SEPARATOR + "�X�V���܂����H", "�X�V���Đi��(U)", 'U', "�j�����Đi��(R)", 'R', ACMessageBox.FOCUS_CANCEL);
			switch (selectButton) {
				case ACMessageBox.RESULT_YES:
					if (isValidInput() && doSave()) {
						// �ۑ��������s���B
					} else {
						// �ۑ�����������I�����Ȃ������ꍇ
						// �����𒆒f����B(�I��)
						return;
					}
					break;

				case ACMessageBox.RESULT_CANCEL:
					return;

				default:

			}
		}

		// �ڍׂɎ󂯓n���p�����[�^���i�[�A�쐬����B
		VRMap parameters = new VRHashMap();
		parameters.setData("PATIENT_ID", ACCastUtilities.toInteger(getPatientId()));
		parameters.setData("CLAIM_DATE", getClaimDate());
		parameters.setData("INSURED_ID", getInsuredId());
		parameters.setData("PROVIDER_ID", getProviderId());
		parameters.setData("LIST_INDEX", ACCastUtilities.toInteger(getListIndex()));
		parameters.setData("TARGET_DATE", getTargetDate());
		parameters.setData("CLAIM_STYLE_TYPE", ACCastUtilities.toInteger(getClaimStyleType()));

		// QP005 ��얾�׏��ڍוҏW�Ŏg�p����n���p�����[�^�[�̍쐬���s���B
		ACAffairInfo affair = new ACAffairInfo(QP005.class.getName(), parameters);
		ACFrame.getInstance().next(affair);
	}

	/**
	 * �u�E�v��������\���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void tekiyoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		if (getTekiyoTable().isSelected()) {
			// �I������Ă���ꍇ
			// �I������Ă��郌�R�[�h��DETAIL_SUMMARY_MEMO���A�E�v���L�ڎ����e�L�X�g�itekiyoText�j�ɕ\������B
			VRMap selectedRowValueMap = (VRMap) getTekiyoTable().getSelectedModelRowValue();
			getTekiyoText().setText(ACCastUtilities.toString(selectedRowValueMap.getData("DETAIL_SUMMARY_MEMO")));
		} else {
			// �I������Ă��Ȃ��ꍇ
			// FIRST_SUMMARY_MEMO��E�v���L�ڎ����e�L�X�g�itekiyoText�j�ɕ\������B
			getTekiyoText().setText(FIRST_SUMMARY_MEMO);
		}
	}

	/**
	 * �u�E�v��������\���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void sinryoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		if (getSinryoTable().isSelected()) {
			// �I������Ă���ꍇ
			// �I������Ă��郌�R�[�h��SPECIAL_CLINIC_SUMMARY_MEMO���A����f�Ô�e�L�X�g�ishinryoText�j�ɕ\������B
			VRMap selectedRowValueMap = (VRMap) getSinryoTable().getSelectedModelRowValue();
			getShinryoText().setText(ACCastUtilities.toString(selectedRowValueMap.getData("SPECIAL_CLINIC_SUMMARY_MEMO")));
		} else {
			// �I������Ă��Ȃ��ꍇ
			// FIRST_SUMMARY_MEMO��E�v���L�ڎ����e�L�X�g�itekiyoText�j�ɕ\������B
			getTekiyoText().setText(FIRST_SUMMARY_MEMO);
		}

	}

	/**
	 * �u�ύX�t���O�𗧂Ă�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void tekiyoTekiyoColumnCellEditing(ChangeEvent e) throws Exception {
		// tableChangedFlg��1�i�ύX����j��������B
		setTableChangedFlg(FLAG_ON);
	}

	/**
	 * �u�ύX�t���O�𗧂Ă�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void sinryoTekiyoColumnCellEditing(ChangeEvent e) throws Exception {
		// tableChangedFlg��1�i�ύX����j��������B
		setTableChangedFlg(FLAG_ON);
	}

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();

		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		param.setData("PATIENT_ID", new Integer(8));
		param.setData("CLAIM_DATE", ACDateUtilities.createDate(2008, 6, 1));
		param.setData("INSURED_ID", "8888888888");
		param.setData("PROVIDER_ID", "2000000000");
		param.setData("LIST_INDEX", new Integer(0));
		param.setData("TARGET_DATE", ACDateUtilities.createDate(2008, 5, 1));
		param.setData("INSURER_ID", "111111");
		param.setData("CLAIM_STYLE_TYPE", new Integer(10411));
		ACFrame.debugStart(new ACAffairInfo(QP004.class.getName(), param));
	}

	// �����֐�

	/**
	 * �u�f�[�^�̎擾�E��ʐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFind() throws Exception {
		// �f�[�^�̎擾�E��ʐݒ�
		// �����f�[�^���擾���邽�߂�where���p�ӂ���B
		// WHERE��
		String whereStr = "(PATIENT_ID = " + getPatientId() + ") " + "AND (INSURED_ID = '" + getInsuredId() + "') " + "AND (TARGET_DATE = '" + VRDateParser.format(getTargetDate(), "yyyy-MM-dd") + "') " + "AND (CLAIM_DATE = '" + VRDateParser.format(getClaimDate(), "yyyy-MM-dd") + "') " + "AND (PROVIDER_ID = '" + getProviderId() + "') " + "AND (CLAIM_STYLE_TYPE = " + getClaimStyleType() + ") " + "AND (CATEGORY_NO IN (2, 3, 5, 7))";

		try {
			// �g�����U�N�V�������J�n����B
			getDBManager().beginTransaction();
			// �����f�[�^���擾���AVRList dataList�Ɋi�[����B
			VRList dataList = QkanCommon.getClaimDetailCustom(getDBManager(), getClaimDate(), whereStr);

			// �R�~�b�g����B
			getDBManager().commitTransaction();

			// �p�b�V�u�`�F�b�N�p��list��ޔ�����B
			getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), dataList);

			// dataList�����{���A���׏��A���莡�Ô�A����f�Ô�A�W�v�������ꂼ�ꒊ�o����B
			doFindCategory(dataList);

		} catch (Exception ex) {
			// SQL�����s�����ŃG���[�����������ꍇ
			// ���������[���o�b�N����B
			getDBManager().rollbackTransaction();
			// ��O�G���[�𓊂���B
			// �����𔲂���B�i�ُ�I���j
			throw ex;
		}

		// ��{��񃌃R�[�h��setSource����
		if (!(getClaimListBasic() == null || getClaimListBasic().isEmpty())) {
			VRMap map = (VRMap) getClaimListBasic().getData(0);
			// �Z�������n�̏ꍇ
			if (getClaimStyleType() == CLAIM_STYLE_TYPE31 || getClaimStyleType() == CLAIM_STYLE_TYPE32 || getClaimStyleType() == CLAIM_STYLE_TYPE41 || getClaimStyleType() == CLAIM_STYLE_TYPE42 || getClaimStyleType() == CLAIM_STYLE_TYPE51 || getClaimStyleType() == CLAIM_STYLE_TYPE52 || getClaimStyleType() == CLAIM_STYLE_TYPE65 || getClaimStyleType() == CLAIM_STYLE_TYPE66) {

				if (!(getClaimListTotal() == null || getClaimListTotal().isEmpty())) {
					VRMap temp = (VRMap) getClaimListTotal().getData(0);
					if (temp != null) {
						Object obj = VRBindPathParser.get("701008", temp);
						VRBindPathParser.set("701008", map, obj);
					}
				}
			}
			setSource(map);
		}

		// ���׏�񃌃R�[�h�W����null�łȂ��ꍇ
		// ���׏�񃌃R�[�h�W����tableModelDetail�ɐݒ肷��B

		if (!(getClaimListDetail() == null || getClaimListDetail().isEmpty())) {
			getTableModelDetail().setAdaptee(getClaimListDetail());
			getTekiyoTable().setSelectedSortedFirstRow();
		}

		// ����f�Ô�R�[�h�W����null�łȂ��ꍇ
		// ����f�Ô�R�[�h�W����tableModelSpecialClinic�ɐݒ肷��B
		if (!(getClaimListSpecialClinic() == null || getClaimListSpecialClinic().isEmpty())) {
			getTableModelSpecialClinic().setAdaptee(getClaimListSpecialClinic());
			getSinryoTable().setSelectedSortedFirstRow();
		}

		// map���u�N���C�A���g�̈�icontents�j�v�ɐݒ肷��B
		// ��ʂɓW�J����B
		bindSource();

	}

	/**
	 * �u�e���R�[�h�W���̒��o�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFindCategory(VRList claimDataList) throws Exception {

		// CATEGORY_NO��5�ł���map�𒊏o����categoryList5�Ɋi�[����
		List categoryList5 = ACBindUtilities.getMatchListFromValue(claimDataList, "CATEGORY_NO", new Integer(CATEGORY_NO5));

		// �e���R�[�h�W���̒��o
		// �����f�[�^�iclaimDataList�j�����Ɍ��Ă����B�i���[�v�J�n�j
		Iterator claimDataListIterator = claimDataList.iterator();
		while (claimDataListIterator.hasNext()) {
			VRMap claimDataMap = (VRMap) claimDataListIterator.next();

			// ��{��񃌃R�[�h�̏ꍇ�iCATEGORY_NO = 2�j
			if (new Integer(CATEGORY_NO2).equals(claimDataMap.getData("CATEGORY_NO"))) {
				// ��{��񃌃R�[�h��claimListBasic�ɒǉ�����B
				getClaimListBasic().addData(claimDataMap);
			}

			// ���׏�񃌃R�[�h�̏ꍇ�iCATEGORY_NO = 3�j
			if (new Integer(CATEGORY_NO3).equals(claimDataMap.getData("CATEGORY_NO"))) {
				// SQL���擾�p��HashMap�Fparam�𐶐����A�V�X�e���T�[�r�X��ރR�[�h�iKEY�F301021�j�A�V�X�e���T�[�r�X���ڃR�[�h�iKEY�F301022�j��
				VRMap param = new VRHashMap();
				// ���o���A���L��KEY/VALUE�Őݒ肷��B
				// �EKEY�FSYSTEM_SERVICE_KIND_DETAIL VALUE�F���o�����V�X�e���T�[�r�X��ރR�[�h
				// �EKEY�FSYSTEM_SERVICE_CODE_ITEM VALUE�F���o�����V�X�e���T�[�r�X���ڃR�[�h
				// �EKEY�FTARGET_DATE VALUE�FtargetDate

				param.setData("SYSTEM_SERVICE_KIND_DETAIL", claimDataMap.getData(SYSTEM_SERVICE_KIND_CODE));
				param.setData("SYSTEM_SERVICE_CODE_ITEM", claimDataMap.getData(SYSTEM_SERVICE_ITEM_CODE));
				param.setData("TARGET_DATE", getTargetDate());

				// DB�iM_SERVICE_CODE�j���Y������T�[�r�X���́A�E�v���L�ڕK�{�t���O�A�E�v�������A�N���X��ށA�R�[�hID���擾����B
				VRList serviceCodeMaster = getDBManager().executeQuery(getSQL_GET_SERVICE_NAME(param));
				// DB���擾�����f�[�^�̍ŏ��̃��R�[�h�̓E�v���L�ڕK�{�t���O�iSUMMARY_FLAG�j��0�̏ꍇ
				VRMap firstServiceCodeMaster = (VRMap) serviceCodeMaster.getData(0);

				if (new Integer(FLAG_OFF).equals(firstServiceCodeMaster.getData("SUMMARY_FLAG"))) {
					// ���׏�񃌃R�[�h��claimListHideDetail�i�\�����Ȃ����׏�񃌃R�[�h�j�ɒǉ�����B
					// ���[�v�J�n�֖߂�B
					getClaimListHideDetail().addData(claimDataMap);
				} else if (new Integer(FLAG_ON).equals(firstServiceCodeMaster.getData("SUMMARY_FLAG"))) {
					// DB���擾�����f�[�^�̍ŏ��̃��R�[�h�̓E�v���L�ڕK�{�t���O�iSUMMARY_FLAG�j��1�̏ꍇ
					// DB���擾�����f�[�^�̍ŏ��̃��R�[�h�̃f�[�^���A���׏�񃌃R�[�h�ɉ��L��KEY/VALUE�Őݒ肷��B
					// �EKEY�FSERVICE_NAME VALUE�FSERVICE_NAME�iDB���擾�����T�[�r�X���́j
					// �EKEY�FDETAIL_SUMMARY_MEMO
					// VALUE�FSUMMARY_MEMO�iDB���擾�����E�v�������j
					// �EKEY�FCLASS_TYPE VALUE�FCLASS_TYPE�iDB���擾�����N���X��ށj
					// �EKEY�FCODE_ID VALUE�FCODE_ID�iDB���擾�����R�[�hID�j

					claimDataMap.setData("SERVICE_NAME", firstServiceCodeMaster.getData("SERVICE_NAME"));
					claimDataMap.setData("DETAIL_SUMMARY_MEMO", firstServiceCodeMaster.getData("SUMMARY_MEMO"));
					claimDataMap.setData("CLASS_TYPE", firstServiceCodeMaster.getData("CLASS_TYPE"));
					claimDataMap.setData("CODE_ID", firstServiceCodeMaster.getData("CODE_ID"));

					// �E�v���L�ڎ����ꗗ�e�[�u���̍s�̃R���|�[�l���g�̐ݒ���s���B
					// �E�������FHashMap�i���׏�񃌃R�[�h�j
					// �E��j�����FcolumnListDetail
					doSetTableRow(claimDataMap, getColumnListDetail(), ACCastUtilities.toInt(claimDataMap.getData("CATEGORY_NO")));

					// ���׏�񃌃R�[�h��claimListDetail�ɒǉ�����B
					getClaimListDetail().addData(claimDataMap);
				}
			}

			if (new Integer(CATEGORY_NO5).equals(claimDataMap.getData("CATEGORY_NO"))) {

				// KEY�F501007�i���R�[�h�����ԍ��j�̒l��1�̏ꍇ
				// ���R�[�h�ɓ���f�Ô�a���e�L�X�g�̈ȉ���KEY�ɒl��ݒ肷��B
				// �EKEY�F501008�i���a���j
				if (categoryList5.size() == 1) {
					if (FLAG_END.equals(ACCastUtilities.toInteger(claimDataMap.getData("501007")))) {
						if (!ACTextUtilities.isNullText(claimDataMap.getData("501008"))) {
							getShinryoDeseaseText().setText(ACCastUtilities.toString(claimDataMap.getData("501008")));
						}
					}
				} else if (categoryList5.size() > 1) {
					if (FLAG_START.equals(ACCastUtilities.toInteger(claimDataMap.getData("501007")))) {
						if (!ACTextUtilities.isNullText(claimDataMap.getData("501008"))) {
							getShinryoDeseaseText().setText(ACCastUtilities.toString(claimDataMap.getData("501008")));
						}
					}
				}
				// ����f�Ô��񃌃R�[�h�̏ꍇ�iCATEGORY_NO = 5�j
				// SQL���擾�p��HashMap�Fparam�𐶐����A���ʔԍ��iKEY�F501009�j���擾���A���L��KEY/VALUE�Őݒ肷��B
				// �EKEY�FSPECIAL_CLINIC_TYPE VALUE�F�擾�������ʔԍ�
				// �EKEY�FTARGET_DATE VALUE�FtargetDate
				VRMap param = new VRHashMap();
				param.setData("SPECIAL_CLINIC_TYPE", claimDataMap.getData(SPECIAL_CLINIC_FLAG_CODE));
				param.setData("TARGET_DATE", getTargetDate());
				//[H20.5 �@�����Ή�] fujihara add start
				param.setData("RECORD_TYPE", "1");
				switch (getClaimStyleType()){
					case CLAIM_STYLE_TYPE41:
					case CLAIM_STYLE_TYPE42:
					case CLAIM_STYLE_TYPE9:
						param.setData("RECORD_TYPE", "2");
						break;
				}
				//[H20.5 �@�����Ή�] fujihara add end

				// DB������f�Ô�A�E�v�������A�N���X��ށA�R�[�hID���擾����B
				VRList serviceCodeMaster = getDBManager().executeQuery(getSQL_GET_SPECIAL_CLINIC_NAME(param));
				VRMap firstServiceCodeMaster = (VRMap) serviceCodeMaster.getData(0);

				// DB���擾�������R�[�h������f�Ô�ƓK�p���������擾���A����f�Ô�R�[�h�ɉ��L��KEY/VALUE�Őݒ肷��B
				// �EKEY�FSPECIAL_CLINIC_NAME VALUE�F�擾��������f�Ô
				// �EKEY�FSPECIAL_CLINIC_SUMMARY_MEMO VALUE�F�擾�����E�v������
				// �EKEY�F VALUE�F�iDB���擾�����N���X��ށj
				// �EKEY�FCODE_ID VALUE�FCODE_ID�iDB���擾�����R�[�hID�j

				claimDataMap.setData("SPECIAL_CLINIC_NAME", firstServiceCodeMaster.getData("SPECIAL_CLINIC_NAME"));
				claimDataMap.setData("SPECIAL_CLINIC_SUMMARY_MEMO", firstServiceCodeMaster.getData("SUMMARY_MEMO"));
				claimDataMap.setData("CLASS_TYPE", firstServiceCodeMaster.getData("CLASS_TYPE"));
				claimDataMap.setData("CODE_ID", firstServiceCodeMaster.getData("CODE_ID"));

				// ��ʕ\���p�Ƀf�[�^��ϊ�����B
				doChangeTekiyoForDisplay(claimDataMap);
				// �E�������FHashMap�i����f�Ô�R�[�h�j

				// ����f�Ô�ꗗ�e�[�u���̍s�̃R���|�[�l���g�̐ݒ���s���B
				doSetTableRow(claimDataMap, getColumnListSpecialClinic(), ACCastUtilities.toInt(claimDataMap.getData("CATEGORY_NO")));
				// �E�������FHashMap�i����f�Ô�R�[�h�j
				// �E��j�����FcolumnListSpecialClinic
				// ����f�Ô�R�[�h��claimListSpecialClinic�ɒǉ�����B
				getClaimListSpecialClinic().addData(claimDataMap);

			}

			// �W�v��񃌃R�[�h�̏ꍇ�iCATEGORY_NO = 7�j
			if (new Integer(CATEGORY_NO7).equals(claimDataMap.getData("CATEGORY_NO"))) {
				// ��{��񃌃R�[�h��claimListBasic�ɒǉ�����B
				getClaimListTotal().addData(claimDataMap);
			}

		}
		// columnListDetail��E�v���L�ڎ����ꗗ�e�[�u���́u�E�v�v��ɐݒ肷��B
		// columnListSpecialClinic�����f�Ô�ꗗ�e�[�u���́u�E�v�v��ɐݒ肷��B
		getTekiyoTekiyoColumn().setCustomCells(getColumnListDetail());
		getSinryoTekiyoColumn().setCustomCells(getColumnListSpecialClinic());
	}

	/**
	 * �u��ʂ̏�Ԑݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doControlState() throws Exception {
		
		// ��ʂ̏�Ԑݒ�
		// ���[�l����2�̏ꍇ�iclaimStyleType = 2�j
		// ��ʂ�Visible������s���B
		if (getClaimStyleType() == CLAIM_STYLE_TYPE21 || getClaimStyleType() == CLAIM_STYLE_TYPE22) {
			setState_STATE_TYPE_2();
			// �E���ID�FSTATE_TYPE_2
		}

		// ���[�l����3�̏ꍇ�iclaimStyleType = 3�j
		// ��ʂ�Visible������s���B
		if (getClaimStyleType() == CLAIM_STYLE_TYPE31 || getClaimStyleType() == CLAIM_STYLE_TYPE32) {
			setState_STATE_TYPE_3();
			// �E���ID�FSTATE_TYPE_3
		}

		// ���[�l����4�̏ꍇ�iclaimStyleType = 4�j
		// ��ʂ�Visible������s���B
		if (getClaimStyleType() == CLAIM_STYLE_TYPE41 || getClaimStyleType() == CLAIM_STYLE_TYPE42) {
			setState_STATE_TYPE_4();
			// �E���ID�FSTATE_TYPE_4
		}

		// ���[�l����5�̏ꍇ�iclaimStyleType = 5�j
		// ��ʂ�Visible������s���B
		if (getClaimStyleType() == CLAIM_STYLE_TYPE51 || getClaimStyleType() == CLAIM_STYLE_TYPE52) {
			setState_STATE_TYPE_5();
			// �E���ID�FSTATE_TYPE_5
		}

		// ���[�l����6�̏ꍇ�iclaimStyleType = 6�j
		// ��ʂ�Visible������s���B
		if (getClaimStyleType() == CLAIM_STYLE_TYPE61 || getClaimStyleType() == CLAIM_STYLE_TYPE62 || getClaimStyleType() == CLAIM_STYLE_TYPE63 || getClaimStyleType() == CLAIM_STYLE_TYPE64) {
			setState_STATE_TYPE_6();
			// �E���ID�FSTATE_TYPE_6
		}

		// ���[�l����6��5��6��6�̏ꍇ�iclaimStyleType = 65��66�j
		// ��ʂ�Visible������s���B
		if (getClaimStyleType() == CLAIM_STYLE_TYPE65 || getClaimStyleType() == CLAIM_STYLE_TYPE66) {
			setState_STATE_TYPE_65();
			// �E���ID�FSTATE_TYPE_65
		}

		// ���[�l����8�̏ꍇ�iclaimStyleType = 8�j
		// ��ʂ�Visible������s���B
		if (getClaimStyleType() == CLAIM_STYLE_TYPE8) {
			setState_STATE_TYPE_8();
			// �E���ID�FSTATE_TYPE_8
		}

		if (getClaimStyleType() == CLAIM_STYLE_TYPE9) {
			// ���[�l����9�̏ꍇ�iclaimStyleType = 9�j
			// ��ʂ�Visible������s���B
			setState_STATE_TYPE_9();
			// �E���ID�FSTATE_TYPE_9
		}

		if (getClaimStyleType() == CLAIM_STYLE_TYPE10) {
			// ���[�l����10�̏ꍇ�iclaimStyleType = 10�j
			// ��ʂ�Visible������s���B
			setState_STATE_TYPE_10();
			// �E���ID�FSTATE_TYPE_10
		}
		
		//[H20.5 �@�����Ή�] fujihara add start
		//H20.5�ȑO�ł���΁A����×{��^�u����������B
		boolean isShinryos = false;
		
		switch (getClaimStyleType()){
			case CLAIM_STYLE_TYPE41:
			case CLAIM_STYLE_TYPE42:
			case CLAIM_STYLE_TYPE9:
				int term = jp.nichicom.ac.lib.care.claim.calculation.QP001Util.getTerm(getTargetDate());
				isShinryos = (jp.nichicom.ac.lib.care.claim.calculation.QP001Util.TERM_200805_AFFTER <= term);
				break;
		}
		
		if (isShinryos){
			getShinryos().setVisible(true);
			getShinryos().setText("���ʗ×{��");
		}
		//[H20.5 �@�����Ή�] fujihara add end
		
		//[ID:0000474][Shin Fujihara] 2009/04/02 edit begin ��Q�Ή�
		//[ID:0000451][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
		boolean isNyusyomaeShow = false;
		int term = jp.nichicom.ac.lib.care.claim.calculation.QP001Util.getTerm(getTargetDate());
		if (jp.nichicom.ac.lib.care.claim.calculation.QP001Util.TERM_200904_AFFTER <= term) {
			//getContentsNyushoJotais().getParent().setVisible(false);
			switch (getClaimStyleType()){
			case CLAIM_STYLE_TYPE61:
			case CLAIM_STYLE_TYPE62:
			case CLAIM_STYLE_TYPE63:
			case CLAIM_STYLE_TYPE64:
			case CLAIM_STYLE_TYPE8:
			case CLAIM_STYLE_TYPE9:
			case CLAIM_STYLE_TYPE10:
				isNyusyomaeShow = true;
				break;
			}
		}
		if (isNyusyomaeShow){
			setState_STATE_NYUSYO_SHOW();
		} else {
			setState_STATE_NYUSYO_HIDE();
		}
		//getShisetsuIdouGroup().remove(getContentsNyushoJotaisContainer());
		//isShinryos = (jp.nichicom.ac.lib.care.claim.calculation.QP001Util.TERM_200805_AFFTER <= term);
		//[ID:0000451][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
		//[ID:0000474][Shin Fujihara] 2009/04/02 edit end ��Q�Ή�
	}

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean isValidInput() throws Exception {
		// ���̓`�F�b�N
		// ���L�̃t�B�[���h��Visible��True�ŁA�����͂���Ă���ꍇ�A���݂�����t���ǂ����`�F�b�N����B

		// �E�J�n�N�����icontentsStartDate�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�J�n�N������"��������B
		if (!checkValidDate(getContentsStartDate(), "�J�n�N������")) {
			return false;
		}

		// �E�I���N�����icontentsStopDate�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�I���N������"��������B
		if (!checkValidDate(getContentsStopDate(), "�I���N������")) {
			return false;
		}

		// �E�����i�@�j�N�����icontentsNyushoDate�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�����i�@�j�N������"��������B
		if (!checkValidDate(getContentsNyushoDate(), "�����i�@�j�N������")) {
			return false;
		}

		// �E�ޏ��i�@�j�N�����icontentsTaishoDate�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�ޏ��i�@�j�N������"��������B
		if (!checkValidDate(getContentsTaishoDate(), "�ޏ��i�@�j�N������")) {
			return false;
		}

		// �s���Ȓl�̏ꍇ
		// �G���[���b�Z�[�W��\������B
		// �E���b�Z�[�WID�FERROR_OF_WRONG_DATE
		// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
		// (�����𔲂���)

		// ���L�̃t�B�[���h��Visible��True�ŁA�����͂���Ă���ꍇ�A�����̓��t�����͂���Ă��Ȃ����`�F�b�N����B
		// �E�J�n�N�����icontentsStartDate�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�J�n�N������"��������B

		// �������� ���t�֌W���疢�����̐��������� 2006/05/19�� �A��
		// 	
		/*
		if (!checkFutureDate(getContentsStartDate(), "�J�n�N������")) {
			return false;
		}

		// �E�I���N�����icontentsStopDate�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�I���N������"��������B
		if (!checkFutureDate(getContentsStopDate(), "�I���N������")) {
			return false;
		}

		// �E�����i�@�j�N�����icontentsNyushoDate�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�����i�@�j�N������"��������B
		if (!checkFutureDate(getContentsNyushoDate(), "�����i�@�j�N������")) {
			return false;
		}

		// �E�ޏ��i�@�j�N�����icontentsTaishoDate�j
		// ���G���[�̏ꍇ�AString�FmsgParam��錾���A"�ޏ��i�@�j�N������"��������B
		if (!checkFutureDate(getContentsTaishoDate(), "�ޏ��i�@�j�N������")) {
			return false;
		}
		*/
		// �����܂� ���t�֌W���疢�����̐��������� 2006/05/19�� �A��		
		
		// �s���Ȓl�̏ꍇ
		// �G���[���b�Z�[�W��\������B
		// �E���b�Z�[�WID�FERROR_OF_FUTURE_DATE
		// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
		// (�����𔲂���)

		// ���L�̃t�B�[���h��Visible��True�ŁA�����͂���Ă���ꍇ�A���t�̑O��֌W���`�F�b�N����B
		// �E�J�n�N�����icontentsStartDate�j
		// �I���N�����icontentsStopDate�j
		// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�J�n�N����/�I���N������"��������B
		// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"�J�n�N����"��������B
		// ���G���[�̏ꍇ�AString�FmsgParam3��錾���A"�I���N����"��������B
		if (!checkRelationDate(getContentsStartDate(), getContentsStopDate(), "�J�n�N����/�I���N������", "�J�n�N����", "�I���N����")) {
			return false;
		}

		// �E�����i�@�j�N�����icontentsNyushoDate�j
		// �ޏ��i�@�j�N�����icontentsTaishoDate�j
		// ���G���[�̏ꍇ�AString�FmsgParam1��錾���A"�����i�@�j�N����/�ޏ��i�@�j�N������"��������B
		// ���G���[�̏ꍇ�AString�FmsgParam2��錾���A"�����i�@�j�N����"��������B
		// ���G���[�̏ꍇ�AString�FmsgParam3��錾���A"�ޏ��i�@�j�N����"��������B
		// �s���Ȓl�̏ꍇ
		// �G���[���b�Z�[�W��\������B

		if (!checkRelationDate(getContentsNyushoDate(), getContentsTaishoDate(), "�����i�@�j�N����/�ޏ��i�@�j�N������", "�����i�@�j�N����", "�ޏ��i�@�j�N����")) {
			return false;
		}

		// �s���Ȓl�̏ꍇ
		// �C���X�^���X�Ƀt�H�[�J�X�����Ă�B
		// �E���b�Z�[�WID�FERROR_OF_GREATER_DATE_RELATION
		// �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
		// (�����𔲂���)

		// ����Ȓl�̏ꍇtrue��Ԃ�
		return true;
	}

	/**
	 * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doSave() throws Exception {
		// �ۑ�����
		try {
			// �g�����U�N�V�������J�n����B
			getDBManager().beginTransaction();
			// �p�b�V�u�`�F�b�N�̃^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();

			// �����f�[�^�o�^�iDELETE, INSERT�j�̂��߂̃p�b�V�u�`�F�b�N���A���L�̃p�b�V�u�L�[�ōs���B
			getPassiveChecker().addPassiveDeleteTask(getPASSIVE_CHECK_KEY());

			// �EPASSIVE_CHECK_KEY
			// �p�b�V�u�`�F�b�N���s���B
			if (getPassiveChecker().passiveCheck(getDBManager())) {

				// ��ʏ�̃f�[�^���擾����B
				// �p�l�������{��񃌃R�[�h���擾����
				VRMap saveMap = (VRMap) getClaimListBasic().getData(0);
				getContents().setSource(saveMap);
				getContents().applySource();

				// ��{��񃌃R�[�h�W���̉��L�̃f�[�^�̌^��Date�^����String�^�iyyyyMMdd�j�ɕϊ�����B
				// �EKEY�F201021�i�J�n�N�����j
				// �EKEY�F201022�i���~�N�����j
				// �EKEY�F201024�i�����i�@�j�N�����j
				// �EKEY�F201025�i�ޏ��i�@�j�N�����j

				if (!ACTextUtilities.isNullText(saveMap.getData("201021"))) {
					saveMap.setData("201021", ACCastUtilities.toString(VRDateParser.format(ACCastUtilities.toDate(saveMap.getData("201021")), "yyyyMMdd")));
				}
				if (!ACTextUtilities.isNullText(saveMap.getData("201022"))) {
					saveMap.setData("201022", ACCastUtilities.toString(VRDateParser.format(ACCastUtilities.toDate(saveMap.getData("201022")), "yyyyMMdd")));
				}
				if (!ACTextUtilities.isNullText(saveMap.get("201024"))) {
					saveMap.setData("201024", ACCastUtilities.toString(VRDateParser.format(ACCastUtilities.toDate(saveMap.getData("201024")), "yyyyMMdd")));
				}
				if (!ACTextUtilities.isNullText(saveMap.getData("201025"))) {
					saveMap.setData("201025", ACCastUtilities.toString(VRDateParser.format(ACCastUtilities.toDate(saveMap.getData("201025")), "yyyyMMdd")));
				}

				// �Z�������n�̏ꍇ
				if (getClaimStyleType() == CLAIM_STYLE_TYPE31 || getClaimStyleType() == CLAIM_STYLE_TYPE32 || getClaimStyleType() == CLAIM_STYLE_TYPE41 || getClaimStyleType() == CLAIM_STYLE_TYPE42 || getClaimStyleType() == CLAIM_STYLE_TYPE51 || getClaimStyleType() == CLAIM_STYLE_TYPE52 || getClaimStyleType() == CLAIM_STYLE_TYPE65 || getClaimStyleType() == CLAIM_STYLE_TYPE66) {

					Object obj = VRBindPathParser.get("701008", saveMap);
					VRMap temp = (VRMap) getClaimListTotal().getData(0);
					if (temp != null) {
						VRBindPathParser.set("701008", temp, obj);
					}
					saveMap.remove("701008");
				}

				// ����f�Ô��񃌃R�[�h��null�łȂ��ꍇ
				if (!(getClaimListSpecialClinic() == null || getClaimListSpecialClinic().isEmpty())) {
					Iterator specialClinicIterator = getClaimListSpecialClinic().listIterator();

					while (specialClinicIterator.hasNext()) {
						VRMap specialClinicRecord = (VRMap) specialClinicIterator.next();
						// ����f�Ô��񃌃R�[�h�W�������Ɍ��Ă����B�i���[�v�J�n�j
						// KEY�F501009�i���ʔԍ��j�̒l��35�i�d�x�×{�Ǘ��j�̏ꍇ
						if (new Integer(HEAVY_RECUPERATION_MANAGEMENT).equals(ACCastUtilities.toInteger(specialClinicRecord.getData("501009")))) {
							// DB�X�V�p�Ƀf�[�^��ϊ�����B
							doChangeTekiyoForUpdate(specialClinicRecord);
							// �E�����FHashMap�i����f�Ô�R�[�h�j
						}
						if (getClaimListSpecialClinic().size() > 1) {
							if (FLAG_START.equals(ACCastUtilities.toInteger(specialClinicRecord.getData("501007")))) {
								// KEY�F501007�i���R�[�h�����ԍ��j�̒l��1�̏ꍇ
								// ���R�[�h�ɓ���f�Ô�a���e�L�X�g�̒l���ȉ���KEY�Őݒ肷��B
								// �EKEY�F501008�i���a���j
								specialClinicRecord.setData("501008", getShinryoDeseaseText().getText());
							}
						} else if (getClaimListSpecialClinic().size() == 1) {
							if (FLAG_END.equals(ACCastUtilities.toInteger(specialClinicRecord.getData("501007")))) {
								specialClinicRecord.setData("501008", getShinryoDeseaseText().getText());
							}
						}
					}
				}

				// ���׏���񃌃R�[�h���擾����

				// ��{��񃌃R�[�h�W���E���׏�񃌃R�[�h�W���E�\�����Ȃ����׏�񃌃R�[�h�W���E����f�Ô�R�[�h�W����1�̃��R�[�h�W���ɂ܂Ƃ߂�B
				VRList allList = new VRArrayList();

				allList.addAll(getClaimListBasic());
				allList.addAll(getClaimListDetail());
				allList.addAll(getClaimListHideDetail());
				allList.addAll(getClaimListSpecialClinic());
				allList.addAll(getClaimListTotal());

				// �f�[�^�o�^�̂��߂�WHERE����쐬����B
				// WHERE��
				String whereStr = "(PATIENT_ID = " + getPatientId() + ") " + "AND (INSURED_ID = '" + getInsuredId() + "') " + "AND (TARGET_DATE = '" + VRDateParser.format(getTargetDate(), "yyyy-MM-dd") + "') " + "AND (CLAIM_DATE = '" + VRDateParser.format(getClaimDate(), "yyyy-MM-dd") + "') " + "AND (PROVIDER_ID = '" + getProviderId() + "') " + "AND (CLAIM_STYLE_TYPE = " + getClaimStyleType() + ") " + "AND (CATEGORY_NO IN (2, 3, 5, 7))";

				// �܂Ƃ߂����R�[�h�W����DB���X�V����B
				QkanCommon.updateClaimDetailCustom(getDBManager(), allList, getTargetDate(), whereStr);

				// �X�V�ɐ��������ꍇ
				// �R�~�b�g����B
				getDBManager().commitTransaction();

				// �ŐV�̃f�[�^���擾���AVRList list�Ɋi�[����B
				VRList dataList = QkanCommon.getClaimDetailCustom(getDBManager(), getClaimDate(), whereStr);
				
				// add start 2006.06.06 shin.fujihara [QKAN500:0000152]�ŐV�f�[�^����ʂɔ��f����悤�C��//
				//�ێ����Ă���f�[�^����U����
				getClaimListBasic().clear();
				getClaimListDetail().clear();
				getClaimListHideDetail().clear();
				getClaimListSpecialClinic().clear();
				getClaimListTotal().clear();
				
				//DB����擾�����ŐV�����Đݒ肷��
				doFindCategory(dataList);
				// add end 2006.06.06 shin.fujihara
				
				// �p�b�V�u�`�F�b�N�p��list��ޔ�����B
				getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), dataList);

				// �X�i�b�v�V���b�g���B�e����B
				getSnapshot().snapshot();

				return true;

			} else {
				// �p�b�V�u�G���[�����������ꍇ
				// �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
				// �E���b�Z�[�WID�FERROR_OF_PASSIVE_CHECK_ON_UPDATE
				// �i�I���j
				// �p�b�V�u�`�F�b�N���~�X�����ꍇ�ASave���s��Ȃ�
				getDBManager().beginTransaction();
				return false;
			}
		} catch (Exception ex) {
			// SQL�����s�����ŃG���[�����������ꍇ
			// ���������[���o�b�N����B
			getDBManager().rollbackTransaction();
			// ��O�G���[�𓊂���B
			// �����𔲂���B�i�ُ�I���j
			throw ex;
		}
	}

	/**
	 * �u��ʕ\���p�Ƀf�[�^�ϊ��v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public VRMap doChangeTekiyoForDisplay(VRMap claimDataMap) throws Exception {
		// ��ʕ\���p�Ƀf�[�^�ϊ�
		// ��ʕ\���p�Ƀ��R�[�h�̒l��ϊ�����B
		if (("�C").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// ���R�[�h��KEY�F501023�̒l��"�C"�̏ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F501023 VALUE�F1
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(1));
		} else if (("��").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// ���R�[�h��KEY�F501023�̒l��"��"�̏ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F501023 VALUE�F2
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(2));
		} else if (("�n").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// ���R�[�h��KEY�F501023�̒l��"�n"�̏ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F501023 VALUE�F3
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(3));
		} else if (("�j").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// ���R�[�h��KEY�F501023�̒l��"�j"�̏ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F501023 VALUE�F4
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(4));
		} else if (("�z").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// ���R�[�h��KEY�F501023�̒l��"�z"�̏ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F501023 VALUE�F5
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(5));
		} else if (("�w").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// ���R�[�h��KEY�F501023�̒l��"�w"�̏ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F501023 VALUE�F6
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(6));
		} else if (("").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// ���R�[�h��KEY�F501023�̒l��""�i�󕶎��j�̏ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F501023 VALUE�F0
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(0));
		}
		return claimDataMap;
	}

	/**
	 * �uDB�X�V�p�Ƀf�[�^�ϊ��v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public VRMap doChangeTekiyoForUpdate(VRMap claimDataMap) throws Exception {
		// DB�X�V�p�Ƀf�[�^�ϊ�
		// DB�X�V�p�Ƀ��R�[�h�̒l��ϊ�����B
		if (new Integer(1).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// ���R�[�h��KEY�F501023�̒l��"1"�̏ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F501023 VALUE�F"�C"
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, "�C");
		} else if (new Integer(2).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// ���R�[�h��KEY�F501023�̒l��"2"�̏ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F501023 VALUE�F"��"
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, "��");
		} else if (new Integer(3).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// ���R�[�h��KEY�F501023�̒l��"3"�̏ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F501023 VALUE�F"�n"
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, "�n");
		} else if (new Integer(4).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// ���R�[�h��KEY�F501023�̒l��"4"�̏ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F501023 VALUE�F"�j"
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, "�j");
		} else if (new Integer(5).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// ���R�[�h��KEY�F501023�̒l��"5"�̏ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F501023 VALUE�F"�z"
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, "�z");
		} else if (new Integer(6).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// ���R�[�h��KEY�F501023�̒l��"6"�̏ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F501023 VALUE�F"�w"
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, "�w");
		} else if (new Integer(0).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// ���R�[�h��KEY�F501023�̒l��"0"�̏ꍇ
			// ���R�[�h�Ɉȉ���KEY/VALUE�Őݒ肷��B
			// �EKEY�F501023 VALUE�F""�i�󕶎��j
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, "");
		}
		return claimDataMap;
	}

	/**
	 * �u�E�v���L�ڎ����ꗗ�e�[�u���̊e�s�̐ݒ菈���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doSetTableRow(VRMap claimDataMap, VRList colomListDetail, int categoryType) throws Exception {

		// NCTableCellViewerCustomCell�𐶐�����B�i�ȉ��Acell�Ƃ���j
		ACTableCellViewerCustomCell cell = new ACTableCellViewerCustomCell();

		switch (categoryType) {
			case CATEGORY_NO3:
				// �ʏ�̖��׏��E�v���̏ꍇ

				// �E�v���L�ڎ����ꗗ�e�[�u���̊e�s�̐ݒ菈��
				// �ȉ��A�n���ꂽ���������L�̂Ƃ���ɌĂԁB
				// �E�������F���R�[�h
				// �E��j�����FcolumnList

				// ���R�[�h��CLASS_TYPE��1�i�e�L�X�g�j�̏ꍇ
				if (new Integer(TEXT).equals(claimDataMap.getData("CLASS_TYPE"))) {
					// �e�L�X�g�𐶐�����B
					ACTextField cellTextField = new ACTextField();
					// cell��editor�ɐ��������e�L�X�g��ǉ�����B
					cell.setEditor(cellTextField);
					cellTextField.setMaxLength(20);
					cellTextField.setByteMaxLength(true);
					cellTextField.setBindPath("301018");
					// cell��editable��true��ݒ肷��B
					cell.setEditable(true);
				} else if (new Integer(COMBO).equals(claimDataMap.getData("CLASS_TYPE"))) {
					// ���R�[�h��CLASS_TYPE��2�i�R���{�j�̏ꍇ
					// �R���{�𐶐�����B
					ACComboBox cellComboBox = new ACComboBox();
					cellComboBox.setEditable(false);

					// ���R�[�h��CODE_ID��p���āAmasterCode���ȉ��̏�������ArrayList�i�R���{�̑I�����j���擾����B
					// �ECONTENT_KEY
					// �ECONTENT
					int id = ACCastUtilities.toInt(claimDataMap.getData("CODE_ID"));
					VRList masterCodeData = QkanCommon.getArrayFromMasterCode(id, "301018");

					boolean isEndOfKey = false;
					String endOfKey = "";

					// �R���{���̕ҏW
					String temp = ACCastUtilities.toString(VRBindPathParser.get("301018", claimDataMap));
					if (!("".equals(temp) || temp == null)) {
						// �u/�v�������Ă��邩�ǂ���
						int number = temp.indexOf("/");
						if (number < 0) {
							// �u/�v�������Ă��Ȃ��ꍇ
							try {
								ACCastUtilities.toInt(temp);
							} catch (Exception e) {
								endOfKey = temp;
								isEndOfKey = true;
							}
						} else {
							// �u/�v�������Ă���ꍇ
							String[] ary = temp.split("/", 2);
							endOfKey = ary[1];
							isEndOfKey = true;
						}
					}

					VRList newList = new VRArrayList();
					// �R���{���ɕt��
					if (isEndOfKey) {
						for (int i = 0; i < masterCodeData.size(); i++) {
							VRMap codeMap = (VRMap) masterCodeData.get(i);
							codeMap = (VRMap) codeMap.clone();
							String target = ACCastUtilities.toString(VRBindPathParser.get("301018", codeMap));
							VRBindPathParser.set("301018", codeMap, target + "/" + endOfKey);
							newList.add(codeMap);
						}
						masterCodeData = newList;
					} else {
						for (int i = 0; i < masterCodeData.size(); i++) {
							VRMap codeMap = (VRMap) masterCodeData.get(i);
							codeMap = (VRMap) codeMap.clone();
							String newKey = ACCastUtilities.toString(VRBindPathParser.get("301018", codeMap));
							VRBindPathParser.set("301018", codeMap, newKey);
							newList.add(codeMap);
						}
						masterCodeData = newList;
					}

					ACLabel cellLabel = new ACLabel();
					cellLabel.setFormat(new QkanCustomForClaimCodeMasterFormat(id));
					cell.setRenderer(cellLabel);

					// bindPath��"CONTENT"�Őݒ肷��B
					// renderBindPath��"CONTENT"�Őݒ肷��B
					cellComboBox.setBindPath("301018");
					cellComboBox.setFormat(new QkanCustomForClaimCodeMasterFormat(id));
					cellComboBox.setRenderBindPath("CONTENT");

					// �擾����ArrayList���R���{�̑I�����Ƃ��Đݒ肷��B
					cellComboBox.setModel(masterCodeData);

					// cell��editor�ɐ��������R���{��ǉ�����B
					cell.setEditor(cellComboBox);

					// cell��editable��true��ݒ肷��B
					cell.setEditable(true);

				}

				// cell��columnList�ɒǉ�����B
				colomListDetail.add(cell);

				break;

			case CATEGORY_NO5:

				// �ʏ�̓���f�Ô�E�v���̏ꍇ

				// �E�v���L�ڎ����ꗗ�e�[�u���̊e�s�̐ݒ菈��
				// �ȉ��A�n���ꂽ���������L�̂Ƃ���ɌĂԁB
				// �E�������F���R�[�h
				// �E��j�����FcolumnList

				// ���R�[�h��CLASS_TYPE��1�i�e�L�X�g�j�̏ꍇ
				if (new Integer(TEXT).equals(claimDataMap.getData("CLASS_TYPE"))) {
					// �e�L�X�g�𐶐�����B
					ACTextField cellTextField = new ACTextField();
					// cell��editor�ɐ��������e�L�X�g��ǉ�����B
					cell.setEditor(cellTextField);

					// V4.5.8�Ή� �S�p�����̂݋���
					cellTextField.setConvertToCharacter(ACCharacterConverter.TO_WIDE_CHAR);
					cellTextField.setIMEMode(InputSubset.KANJI);
					cellTextField.setMaxLength(100);
					cellTextField.setByteMaxLength(true);
					cellTextField.setBindPath("501023");

					// cell��editable��true��ݒ肷��B
					cell.setEditable(true);
				} else if (new Integer(COMBO).equals(claimDataMap.getData("CLASS_TYPE"))) {
					// ���R�[�h��CLASS_TYPE��2�i�R���{�j�̏ꍇ
					// �R���{�𐶐�����B
					ACComboBox cellComboBox = new ACComboBox();
					cellComboBox.setEditable(false);

					// ���R�[�h��CODE_ID��p���āAmasterCode���ȉ��̏�������ArrayList�i�R���{�̑I�����j���擾����B
					// �ECONTENT_KEY
					// �ECONTENT
					int id = ACCastUtilities.toInt(claimDataMap.getData("CODE_ID"));
					VRList masterCodeData = QkanCommon.getArrayFromMasterCode(id, "501023");

					// �R���{���̕ҏW
					String temp = ACCastUtilities.toString(VRBindPathParser.get("501023", claimDataMap));
					if (!("".equals(temp) || temp == null)) {
						// �u/�v�������Ă��邩�ǂ���
						boolean isEndOfKey = false;
						int number = temp.indexOf("/");
						String endOfKey = "";
						if (number < 0) {
							// �u/�v�������Ă��Ȃ��ꍇ
							try {
								ACCastUtilities.toInt(temp);
							} catch (Exception e) {
								endOfKey = temp;
								isEndOfKey = true;
							}
						} else {
							// �u/�v�������Ă���ꍇ
							String[] ary = temp.split("/", 2);
							endOfKey = ary[1];
							isEndOfKey = true;
						}
						VRList newList = new VRArrayList();
						// �R���{���ɕt��
						if (isEndOfKey) {
							for (int i = 0; i < masterCodeData.size(); i++) {
								VRMap codeMap = (VRMap) masterCodeData.get(i);
								codeMap = (VRMap) codeMap.clone();
								String target = ACCastUtilities.toString(VRBindPathParser.get("501023", codeMap));
								VRBindPathParser.set("501023", codeMap, target + "/" + endOfKey);
								newList.add(codeMap);
							}
							masterCodeData = newList;
						}
					}
					ACLabel cellLabel = new ACLabel();
					cellLabel.setFormat(new QkanCustomForClaimCodeMasterFormat(id));
					cell.setRenderer(cellLabel);

					// bindPath��"CONTENT"�Őݒ肷��B
					// renderBindPath��"CONTENT"�Őݒ肷��B
					cellComboBox.setBindPath("501023");
					cellComboBox.setFormat(new QkanCustomForClaimCodeMasterFormat(id));
					cellComboBox.setRenderBindPath("CONTENT");

					// �擾����ArrayList���R���{�̑I�����Ƃ��Đݒ肷��B
					cellComboBox.setModel(masterCodeData);

					// cell��editor�ɐ��������R���{��ǉ�����B
					cell.setEditor(cellComboBox);

					// cell��editable��true��ݒ肷��B
					cell.setEditable(true);

				}

				// cell��columnList�ɒǉ�����B
				colomListDetail.add(cell);

				break;

			default:
				// �������Ȃ�
				break;
		}
	}

	/**
	 * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void initialize() throws Exception {
		// ��ʏ������B
		// �Ɩ����}�X�^���f�[�^���擾���A�E�B���h�E�^�C�g���A�Ɩ��{�^���o�[�ɐݒ肷��B
		setAffairTitle("QP004", getButtons());
		// �R�[�h�}�X�^�f�[�^���擾���AmasterCodeData�Ɋi�[����B
		setMasterCodeData(QkanSystemInformation.getInstance().getMasterCode());

		// �e�[�u�����f���̐ݒ�B
		// tableModelDetail���A���L�̃t�B�[���h�Ő�������B
		// "301007+301008�i�T�[�r�X�R�[�h�j" "SERVICE_NAME" "301010�i�����E�񐔁j"
		// "301014�i�T�[�r�X�P�ʐ��j" "301018�i�E�v�j"

		String[] tableDetailColums = new String[5];
		tableDetailColums[0] = "301007+''+301008"; // �T�[�r�X�R�[�h
		tableDetailColums[1] = "SERVICE_NAME"; // �T�[�r�X����
		tableDetailColums[2] = "301010"; // �����E��
		tableDetailColums[3] = "301014"; // �T�[�r�X�P�ʐ�
		tableDetailColums[4] = "301018"; // �E�v

		// ������������Ɋi�[
		setTableModelDetail(new ACTableModelAdapter());
		getTableModelDetail().setColumns(tableDetailColums);

		// tableModelSpecialClinic���A���L�̃t�B�[���h�Ő�������B
		// "501009�i���ʔԍ��j" "SPECIAL_CLINIC_NAME" "501011�i�񐔁j" "501012�i�P�ʐ��j"
		// "501023�i�E�v�j"
		String[] tableSpecialClinicColums = new String[5];
		tableSpecialClinicColums[0] = "501009"; // ���ʔԍ�
		tableSpecialClinicColums[1] = "SPECIAL_CLINIC_NAME";// �����Ë@�֖���
		tableSpecialClinicColums[2] = "501011"; // ��
		tableSpecialClinicColums[3] = "501012"; // �P�ʐ�
		tableSpecialClinicColums[4] = "501023"; // �E�v

		// ������������Ɋi�[
		setTableModelSpecialClinic(new ACTableModelAdapter());
		getTableModelSpecialClinic().setColumns(tableSpecialClinicColums);

		// �e�[�u�����f�����e��ʃe�[�u���ɐݒ肷��B
		// �EtableModelDetail �E�v�L�ڎ����ꗗ�e�[�u���itekiyoTable�j
		getTekiyoTable().setModel(getTableModelDetail());
		// �EtableModelSpecialClinic ����f�Ô�ꗗ�e�[�u���isinryoTable�j
		getSinryoTable().setModel(getTableModelSpecialClinic());

		// �E�v�������i�萔������FFIRST_SUMMARY_MEMO�j�����L�̃e�L�X�g�t�B�[���h�ɕ\������B
		// �E�E�v���L�ڎ����itekiyoText�j
		// �E����f�Ô�ishinryoText�j
		getTekiyoText().setText(FIRST_SUMMARY_MEMO);
		getShinryoText().setText(FIRST_SUMMARY_MEMO);

		// ��ʂ�Visible������s���B
		doControlState();

		VRList patientList = QkanCommon.getPatientInfo(getDBManager(), getPatientId());
		if (!patientList.isEmpty()) {
			VRMap patientMap = (VRMap) patientList.getData();
			patientMap.setData("PATIENT_NAME", QkanCommon.toFullName(patientMap.getData("PATIENT_FAMILY_NAME"), patientMap.getData("PATIENT_FIRST_NAME")));
			getPatientNames().setSource(patientMap);
			getPatientNames().bindSource();
		}
	}

	/**
	 * �u�Ó��ȓ��t�̓��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkValidDate(QkanDateTextField dateParam, String errMsg) throws Exception {
		if (!ACTextUtilities.isNullText(dateParam.getText())) {
			if (!dateParam.isValidDate()) {
				// �s���Ȓl�̏ꍇ
				// �C���X�^���X�Ƀt�H�[�J�X�����Ă�B
				dateParam.requestFocus();
				// �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(errMsg);
				// �E���b�Z�[�WID�FERROR_OF_WRONG_DATE
				// �i�I���j
				return false;
			}
		}
		return true;
	}

	/**
	 * �u�������t�̓��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkFutureDate(QkanDateTextField dateParam, String errMsg) throws Exception {

		if (!ACTextUtilities.isNullText(dateParam.getText())) {
			Date systemDate = QkanSystemInformation.getInstance().getSystemDate();
			if (ACDateUtilities.compareOnDay(systemDate, ACCastUtilities.toDate(dateParam.getText())) < 0) {
				// �s���Ȓl�̏ꍇ
				// �C���X�^���X�Ƀt�H�[�J�X�����Ă�B
				dateParam.requestFocus();
				// �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_FUTURE_DATE(errMsg);
				// �E���b�Z�[�WID�FERROR_OF_FUTURE_DATE
				// �i�I���j
				return false;
			}
		}
		return true;
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
					return false;
				}
			}
		}
		return true;
	}
}
