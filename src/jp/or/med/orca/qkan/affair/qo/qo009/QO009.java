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
 * �쐬��: 2006/01/16  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ��Ë@�֊Ǘ� (009)
 * �v���O���� ��Ë@�ֈꗗ (QO009)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo009;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qo.qo010.QO010;

/**
 * ��Ë@�ֈꗗ(QO009)
 */
public class QO009 extends QO009Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO009() {
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
		// �p�b�V�u�L�[�̒�`
		setPASSIVE_CHECK_KEY(new ACPassiveKey("MEDICAL_FACILITY",
				new String[] { "MEDICAL_FACILITY_ID" }, "LAST_TIME",
				"LAST_TIME"));

		// �n��p�����[�^��ޔ�����B
		// medicalFacilityId = MEDICAL_FACILITY_ID�i��Ë@��ID�j
		VRMap parameters = affair.getParameters();

		// �f�[�^�����݂��Ă��邩���`�F�b�N
		if (VRBindPathParser.has("MEDICAL_FACILITY_ID", parameters)) {

			// int�^�Ɍ^�ϊ������p��ID��ޔ�
			setMedicalFacilityId(Integer.parseInt(String
					.valueOf(VRBindPathParser.get("MEDICAL_FACILITY_ID",
							parameters))));

			// ��d�ɋN�����Ȃ��悤�ɃL�[���폜
			parameters.remove("MEDICAL_FACILITY_ID");
		}

		// ��ʂ̏��������s���B
		initialize();

		// �����������s���B
		doFind();
	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		// �O��ʂɖ߂�B

		// TODO �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// �V�X�e�����I������B

		// TODO �I����������Ȃ��true��Ԃ��B
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
		// ���I������Ă����Ë@�ւ̏��ŁuQO010 ��Ë@�֓o�^�v��ʂɑJ��
		// ����ʂɑJ�ڂ���B
		transferNext();
	}

	/**
	 * �u�o�^��ʂɑJ�ځv�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {
		// ���uQO010 ��Ë@�֓o�^�v��ʂɑJ��
		// ����ʂւ̓n��p�����[�^�i�[�p�Ƀ��R�[�h param�𐶐�����B
		VRMap param = new VRHashMap();
		// param�ɉ��L�̒l��ݒ肷��B
		// KEY�FPROCESS_MODE VALUE�FPROCESS_MODE_INSERT
		param.setData("PROCESS_MODE", new Integer(
				QkanConstants.PROCESS_MODE_INSERT));
		// ���L�p�����[�^�ɂ�NCAffairInfo affair�𐶐�����B
		ACAffairInfo affair = null;
		// className : QO010.class.getName(), parameters : param
		affair = new ACAffairInfo(QO010.class.getName(), param);
		// ����ʂɑJ�ڂ���B
		// next(affair);
		ACFrame.getInstance().next(affair);
	}

	/**
	 * �u��Ë@�֍폜�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void deleteActionPerformed(ActionEvent e) throws Exception {
		// ����Ë@�֍폜����
		// ���폜����
		// SQL���擾�p��VRMap sqlParam���`����B
		VRMap sqlParam = new VRHashMap();
		
		// sqlParam�𐶐�����B
		// sqlParam�ɉ��L�p�����[�^��ݒ肷��B
		// KEY�FMEDICAL_FACILITY_ID VALUE�F�i��Ë@�֏��e�[�u���őI������Ă����Ë@�ւ̈�Ë@��ID�j
		// �ꎞ���pHashMap
		VRMap MedicalFacilityIdMap = new VRHashMap();

		MedicalFacilityIdMap = (VRMap) getMedicalFacilityTable()
				.getSelectedModelRowValue();

		sqlParam.setData("MEDICAL_FACILITY_ID", VRBindPathParser.get(
				"MEDICAL_FACILITY_ID", MedicalFacilityIdMap));

		// sqlParam�������Ƃ��āA�K��Ō�X�e�[�V���������擾�p��SQL�����擾����B
		VRList StationHistoryList = getDBManager().executeQuery(
				getSQL_GET_STATION_HISTORY(sqlParam));
		// �擾�����f�[�^������0����葽���ꍇ
		if (StationHistoryList.size() > 0) {
			// String msgParam�𐶐�����B
			String msgParam = null;
			// msgParam��"���p�ҏ��"��������B
			msgParam = "���p�ҏ��";

			// �G���[���b�Z�[�W��\������B
			int msgID = QkanMessageList.getInstance().ERROR_OF_DELETE_USED(
					msgParam);
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// �E���b�Z�[�WID�FERROR_OF_DELETE_USED
				// �������I������B
				return;
			}
		}
		
		// �I������Ă��郌�R�[�h�̃C���f�b�N�X���i�[����index���`����B
		int index;


		// �������m�F
		// �폜�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_DELETE
		int msgID = QkanMessageList.getInstance()
				.WARNING_OF_DELETE("�I�𒆂̈�Ë@�֏��");
		switch (msgID) {
		case ACMessageBox.RESULT_CANCEL:
			// �uOK�v�I���ȊO�̏ꍇ(�폜���f)
			// �����𒆒f����B
			return;
		case ACMessageBox.RESULT_OK:
			// ����Ë@�ւ��o�^����Ă��邩�`�F�b�N����B
			// ��Ë@�֏��e�[�u���ň�Ë@�ւ��I������Ă��邩�`�F�b�N����B
			if (getMedicalFacilityTable().getSelectedSortedRow() == -1) {
				// �I������Ă��Ȃ��ꍇ
				// �������I������B
				return;
			} else {
				// �I������Ă���ꍇ
				// �I���s�̃C���f�b�N�X(���f���ł͂Ȃ���ʏ�)���擾����B
				index = getMedicalFacilityTable().getSelectedModelRow();


				try {
					// �g�����U�N�V�����J�n
					getDBManager().beginTransaction();

					// ���p�b�V�u�`�F�b�N
					// �p�b�V�u�^�X�N���N���A����B
					getPassiveChecker().clearPassiveTask();

					// �p�b�V�u�^�X�N��o�^����B
					getPassiveChecker().addPassiveDeleteTask(
							getPASSIVE_CHECK_KEY(), index);

					// �p�b�V�u�`�F�b�N�����s����B
					if (!getPassiveChecker().passiveCheck(getDBManager())) {
						// �p�b�V�u�G���[������ꍇ
						// �G���[���b�Z�[�W��\������B�����b�Z�[�WID =
						// ERROR_OF_PASSIVE_CHECK_ON_UPDATE
						QkanMessageList.getInstance()
								.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
						// �����𒆒f����B(�ُ�I��)
						getDBManager().rollbackTransaction();
						return;
					}
					// ����Ë@�֍폜
					// sqlParam�������Ƃ��āA��Ë@�֍폜�p��SQL�����擾����B
					// getSQL_DELETE_MEDICAL_FACILITY(sqlParam);
					// �擾����SQL���𔭍s����B
					getDBManager().executeUpdate(
							getSQL_DELETE_MEDICAL_FACILITY(sqlParam));

					getDBManager().commitTransaction();

					// ���������ʒm���b�Z�[�W��\������B�����b�Z�[�WID = DELETE_SUCCESSED
					// QkanMessageList.getInstance().DELETE_SUCCESSED();
					// �������I������B(����I��)

					// ��Ë@�֏����Č�������B
					doFind();

					// �폜��̗��z�ƂȂ�s�ԍ���ݒ肷��
					getMedicalFacilityTable()
							.setSelectedSortedRowOnAfterDelete(index);

				} catch (Exception ex) {
					// ���R�~�b�g�E���[���o�b�N
					// ��L��SQL���s�����ŃG���[���Ȃ������ꍇ
					// �������R�~�b�g����B
					getDBManager().rollbackTransaction();

					// ��ʃN���X�ɗ�O��Ԃ��B
					throw ex;
				}
			}
		}

	}

	/**
	 * �u�e�[�u���I���������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void medicalFacilityTableSelectionChanged(ListSelectionEvent e)
			throws Exception {
		// ���e�[�u���I��������
		// ����ʏ�Ԑݒ�
		// �e�[�u���̃Z�����I������Ă���ꍇ
		if (getMedicalFacilityTable().getSelectedSortedRow() != -1) {
			// ��ʂ̏�Ԃ�ݒ肷��B
			setState_SELECTED();
			// ��Ԑݒ�FSELECTED
			// �e�[�u���̃Z�����I������Ă��Ȃ��ꍇ
		} else {
			// ��ʂ̏�Ԃ�ݒ肷��B
			setState_UNSELECTED();
			// ��Ԑݒ�FUNSELECTED
		}

	}

	/**
	 * �u�ڍ׉�ʑJ�ځv�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void medicalFacilityTableMouseClicked(MouseEvent e)
			throws Exception {
		// ���ڍ׉�ʂɑJ��
		// ����ʂɑJ�ڂ���B
		transferNext();
	}

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QO009.class.getName(), param));
	}

	// �����֐�

	/**
	 * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void initialize() throws Exception {
		// ����ʂ̏����������B
		// ���E�B���h�E�^�C�g���E�Ɩ��{�^���o�[�̐ݒ�
		// �E�B���h�E�^�C�g���E�Ɩ��{�^���o�[��ݒ肷��B
		setAffairTitle("QO009", "0", getButtons());
		// ���e�[�u�����f������
		// tableModel�𐶐����A�ȉ��̃J������ݒ肷��B
		// ��Ë@�֖��� "MEDICAL_FACILITY_NAME"
		// �X�֔ԍ� "MEDICAL_FACILITY_ZIP_FIRST+'-'+MEDICAL_FACILITY_ZIP_SECOND"
		// ���ݒn "MEDICAL_FACILITY_ADDRESS"
		// �d�b�ԍ�
		// "MEDICAL_FACILITY_TEL_FIRST+'-'+MEDICAL_FACILITY_TEL_SECOND+'-'+MEDICAL_FACILITY_TEL_THIRD"
		// FAX
		// "MEDICAL_FACILITY_FAX_FIRST+'-'+MEDICAL_FACILITY_FAX_SECOND+'-'+MEDICAL_FACILITY_FAX_THIRD"
		// (�B���J����)
		// �X�֔ԍ�1 "MEDICAL_FACILITY_ZIP_FIRST"
		// �X�֔ԍ�2 "MEDICAL_FACILITY_ZIP_SECOND"
		// �d�b�ԍ�1 "MEDICAL_FACILITY_TEL_FIRST"
		// �d�b�ԍ�2 "MEDICAL_FACILITY_TEL_SECOND"
		// �d�b�ԍ�3 "MEDICAL_FACILITY_TEL_THIRD"
		// FAX�ԍ�1 "MEDICAL_FACILITY_FAX_FIRST"
		// FAX�ԍ�2 "MEDICAL_FACILITY_FAX_SECOND"
		// FAX�ԍ�3 "MEDICAL_FACILITY_FAX_THIRD"
		ACTableModelAdapter model = new ACTableModelAdapter();

		model
				.setColumns(new String[] {
						"MEDICAL_FACILITY_NAME",
						"MEDICAL_FACILITY_ZIP_FIRST+'-'+MEDICAL_FACILITY_ZIP_SECOND",
						"MEDICAL_FACILITY_ADDRESS",
						"MEDICAL_FACILITY_TEL_FIRST+'-'+MEDICAL_FACILITY_TEL_SECOND+'-'+MEDICAL_FACILITY_TEL_THIRD",
						"MEDICAL_FACILITY_FAX_FIRST+'-'+MEDICAL_FACILITY_FAX_SECOND+'-'+MEDICAL_FACILITY_FAX_THIRD", });

		setTableModel(model);

		// �e�[�u�����f�������L�̉�ʂ̃e�[�u���ɐݒ肷��B
		// ���Ə����e�[�u���iMedicalFacilityTable) �e�[�u�����f���FTableModel
		getMedicalFacilityTable().setModel(getTableModel());

	}

	/**
	 * �u�����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFind() throws Exception {
		// ����������
		// ����������
		// SQL�擾�p��VRMap splParam�𐶐�����B
		VRMap sqlParam = new VRHashMap();

		// ����Ë@�֖��̂̎擾
		// medicalFacilityName�����͂���Ă��镶������擾����B
		String StrMedicalFacilityName = getMedicalFacilityName().getText();
		// �擾����������������p�ɕϊ�����B
		// StrMedicalFacilityName = changeString(StrMedicalFacilityName);

		// �ϊ�����������̕����񒷂�0���傫���ꍇ
		// sqlParam�ɕϊ�������������ȉ���KEY�Œǉ�����B
		// �EKEY�FMEDICAL_FACILITY_NAME
		if (StrMedicalFacilityName.length() > 0) {
			sqlParam.setData("MEDICAL_FACILITY_NAME", StrMedicalFacilityName);
		}

		// ���������s
		// sqlParam�������Ƃ��āA��Ë@�֎擾�p��SQL�����擾����B
		// getSQL_GET_MEDICAL_FACILITY(sqlParam);
		// �擾����SQL�������s���A�擾�����f�[�^��medicalFacilityList�Ɋi�[����B
		setMedicalFacilityList(getDBManager().executeQuery(
				getSQL_GET_MEDICAL_FACILITY(sqlParam)));

		// ���擾�����f�[�^����ʂɓW�J
		// �擾�����f�[�^��0����葽���ꍇ
		if (getMedicalFacilityList().size() > 0) {
			// tableModel��medicalFacilityList���Z�b�g����B
			getTableModel().setAdaptee(getMedicalFacilityList());

			// �n��p�����[�^�Ƃ��Ĉ�Ë@��ID���n����Ă����ꍇ�imedicalFacilityId <> 0�j
			if (getMedicalFacilityId() != 0) {
				int index = ACCommon.getInstance().getMatchIndexFromValue(
						getMedicalFacilityList(), "MEDICAL_FACILITY_ID",
						new Integer(getMedicalFacilityId()));

				// �n���ꂽ��Ë@��ID�̈�Ë@�ւ�I��������Ԃɂ���B
				getMedicalFacilityTable().setSelectedModelRow(index);

				// ��Ë@��ID����d�Ɏg�p����Ȃ��悤�ɁAmedicalFacilityId��0��������B
				setMedicalFacilityId(0);

				// �n��p�����[�^�Ƃ��Ĉ�Ë@��ID���n����Ă��Ȃ��ꍇ�imedicalFacilityId == 0�j
			} else {
				// ��Ë@�֏��e�[�u����1�s�ڂ�I��������Ԃɂ���B
				getMedicalFacilityTable().setSelectedSortedFirstRow();
			}
            //�I�𗘗p�҂܂ŃX�N���[������
            getMedicalFacilityTable().scrollSelectedToVisible();
		} else {
			// �擾�����f�[�^��0���ł���ꍇ
			// tableModel��medicalFacilityList���Z�b�g����B
			getTableModel().setAdaptee(getMedicalFacilityList());
			// ��ʂ̏�Ԃ�ݒ肷��B
			// �E���ID�FUNSELECTED
			setState_UNSELECTED();
		}

		// ���p�b�V�u�L�[�̍ēo�^
		// �p�b�V�u�L�[���N���A����B
		getPassiveChecker().clearReservedPassive();
		// �p�b�V�u�L�[��o�^����B
		getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
				getMedicalFacilityList());

	}

	/**
	 * �u������̕ϊ��v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	/**
	 * public String changeString(String str) throws Exception { // ��������̕ϊ� //
	 * �O��̃X�y�[�X����������B ACTextUtilities.trim(str); // �߂�l�Ƃ��ĕϊ���̕������Ԃ��B return str; }
	 */

	/**
	 * �u�ڍ׉�ʑJ�ځv�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void transferNext() throws Exception {
		// ���ڍ׉�ʑJ�ڏ����B
		// ��Ë@�֏��e�[�u���ň�Ë@�ւ��I������Ă��邩�`�F�b�N����B
		if (getMedicalFacilityTable().getSelectedSortedRow() == -1) {
			// �I������Ă��Ȃ��ꍇ
			// �������I������B
			return;
		} else {
			// �I������Ă���ꍇ
			// ����ʂւ̓n��p�����[�^�i�[�p�Ƀ��R�[�h param�𐶐�����B
			VRMap param = new VRHashMap();
			// param�ɉ��L�̒l��ݒ肷��B
			// KEY�FMEDICAL_FACILITY_ID VALUE�F�i��Ë@�֏��e�[�u���őI������Ă����Ë@�ւ̈�Ë@��ID�j
			// KEY�FPROCESS_MODE VALUE�FPROCESS_MODE_UPDATE
			// �ꎞ���pHashMap
			VRMap MedicalFacilityIdMap = new VRHashMap();

			MedicalFacilityIdMap = (VRMap) getMedicalFacilityTable()
					.getSelectedModelRowValue();

			param.setData("MEDICAL_FACILITY_ID", VRBindPathParser.get(
					"MEDICAL_FACILITY_ID", MedicalFacilityIdMap));
			param.setData("PROCESS_MODE", new Integer(
					QkanConstants.PROCESS_MODE_UPDATE));
			// ���L�p�����[�^�ɂ�NCAffairInfo affair�𐶐�����B
			ACAffairInfo affair = null;
			// className : QO010.class.getName(), parameters : param
			affair = new ACAffairInfo(QO010.class.getName(), param);
			// ����ʂɑJ�ڂ���B
			// next(affair);
			ACFrame.getInstance().next(affair);
		}
	}
}
