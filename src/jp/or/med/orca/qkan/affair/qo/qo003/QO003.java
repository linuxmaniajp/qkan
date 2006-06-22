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
 * �J����: ����@��F
 * �쐬��: 2006/01/13  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��ꗗ (003)
 * �v���O���� ���Ə��ꗗ (QO003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo003;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.util.List;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACTextUtilities;
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
import jp.or.med.orca.qkan.affair.qm.qm002.QM002;
import jp.or.med.orca.qkan.affair.qo.qo004.QO004;
import jp.or.med.orca.qkan.text.QkanProviderAreaTypeFormat;
import jp.or.med.orca.qkan.text.QkanProviderJigyoTypeFormat;
import jp.or.med.orca.qkan.text.QkanProviderTypeFormat;

/**
 * ���Ə��ꗗ(QO003)
 */
public class QO003 extends QO003Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO003() {
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
		setPROVIDER_PASSIVE_CHECK_KEY(new ACPassiveKey("PROVIDER",
				new String[] { "PROVIDER_ID" },new boolean[] { true },
				 "LAST_TIME","LAST_TIME"));

		// �n��p�����[�^��ޔ�����B
		// medicalFacilityId = MEDICAL_FACILITY_ID�i��Ë@��ID�j
		VRMap parameters = affair.getParameters();
		// �f�[�^�����݂��Ă��邩���`�F�b�N
		if (VRBindPathParser.has("PROVIDER_ID", parameters)) {

			// int�^�Ɍ^�ϊ������p��ID��ޔ�
			setProviderId(String.valueOf(VRBindPathParser.get("PROVIDER_ID",
					parameters)));

			// ��d�ɋN�����Ȃ��悤�ɃL�[���폜
			parameters.remove("PROVIDER_ID");
		}

		// ��ʓW�J���̏����ݒ�y�я����\���������s���܂��B
		QkanCommon.getAffairInfo(getDBManager(), "QO001");
		// �Ɩ��}�X�^���A�f�[�^���擾����B
		QkanCommon.getAffairInfo(getDBManager(), "QO001");
		// �擾�����f�[�^�̃E�C���h�E�^�C�g���iWINDOW_TITLE�j���E�C���h�E�ɐݒ肷��B
		// �擾�����f�[�^�̋Ɩ��^�C�g���iAFFAIR_TITLE�j���Ɩ��{�^���o�[�ɐݒ肷��B
		setAffairTitle("QO003", "0", getButtons());

		// �e�[�u�����f�����`����B
		ACTableModelAdapter model = new ACTableModelAdapter();

		model
				.setColumns(new String[] {
						"PROVIDER_TYPE",
						"PROVIDER_ID",
						"PROVIDER_NAME",
						"PROVIDER_ZIP_FIRST+'-'+PROVIDER_ZIP_SECOND",
						"PROVIDER_ADDRESS",
						"PROVIDER_TEL_FIRST+'-'+PROVIDER_TEL_SECOND+'-'+PROVIDER_TEL_THIRD",
						"PROVIDER_FAX_FIRST+'-'+PROVIDER_FAX_SECOND+'-'+PROVIDER_FAX_THIRD",
						"PROVIDER_JIGYOU_TYPE", "PROVIDER_AREA_TYPE",
						"STAFF_FAMILY_NAME+'�@'+STAFF_FIRST_NAME", });

		setProviderTableModel(model);

		// �e�[�u�����f�������L�̉�ʂ̃e�[�u���ɐݒ肷��B
		// ���Ə����e�[�u���iproviderTable) �e�[�u�����f���FproviderTableModel
		getProviderTable().setModel(getProviderTableModel());

		getProviderTypeColumn().setFormat(QkanProviderTypeFormat.getInstance());
		getProviderDivisionColumn().setFormat(
				QkanProviderJigyoTypeFormat.getInstance());
		getProviderRegionColumn().setFormat(
				QkanProviderAreaTypeFormat.getInstance());

		// DB��莖�Ə������擾���A��ʂɓW�J����B
		//setAffairMap(affair.getParameters());

		// ���Ə���ʃR���{�̍��ڂ�ݒ肷��B
		// �R�[�h�}�X�^���牺�L��CODE_ID�̃��R�[�h�𒊏o���A���L��KEY��comboMap�ɐݒ肷��B
		VRMap comboMap = new VRHashMap();
		// �E
		comboMap.setData("PROVIDER_TYPE", QkanCommon.getArrayFromMasterCode(
				195, "PROVIDER_TYPE"));

		// comboMap��N���C�A���g�̈�icontents�j��ɐݒ肷��B
		getFindContentproviderType().setModelSource(comboMap);
		getFindContentproviderType().bindModelSource();
		
		doFind();
		// providerList�̃��R�[�h��1���ȏ�̏ꍇ
		if (getProviderList().size() > 0) {
			// �n��p�����[�^�Ƃ��Ď��Ə��ԍ����n����Ă����ꍇ
			if (getProviderId() != null) {
				// �n���ꂽ���Ə��ԍ���I��������Ԃɂ���B
				VRList temp = (VRList) getProviderTableModel().getAdaptee();
				int index = ACBindUtilities.getMatchIndexFromValue(temp,
						"PROVIDER_ID", getProviderId());
				getProviderTable().setSelectedModelRow(index);

				// �n��p�����[�^�Ƃ��Ď��Ə��ԍ����n����Ă��Ȃ��ꍇ
			} else {
				// �e�[�u����1�s�ڂ�I����Ԃɂ���B
				getProviderTable().setSelectedSortedFirstRow();
			}
		}
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u���������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void findActionPerformed(ActionEvent e) throws Exception {
		// ��ʕ����p�̃f�[�^���쐬����B
		createFindState();
		
		// ��������
		// �����������s���B
		doFindProvider();

	}

	/**
	 * �u���Ə��o�^��ʂɑJ�ځi�X�V�j�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void detailActionPerformed(ActionEvent e) throws Exception {
		// ���I������Ă����Ë@�ւ̏��Łu���Ə��o�^��ʁiQO004�j�v��ʂɑJ��
		// ����ʂɑJ�ڂ���B
		transferNext();
	}

	/**
	 * �u���Ə��o�^��ʂɑJ�ځi�o�^�j�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {
		// ���Ə��o�^��ʂɑJ�ڂ��鏈���i�o�^�j
		// VRMap�Fparam���쐬����ʑJ�ڗp�̃p�����[�^�[���i�[����B
		VRMap param = new VRHashMap();

		// KEY�FPROCESS_MODE VALUE�F���ʒ萔�̢PROCESS_MODE_INSERT(4)�
		param.setData("PROCESS_MODE", new Integer(
				QkanConstants.PROCESS_MODE_INSERT));

		// ����ʑJ�ڂ̂��߃p�����[�^�[NCAffairInfo affair���`����B
		ACAffairInfo affair = null;
		// ���L�̃p�����[�^�[��affair�𐶐�����B
		// className�FQO004.class.getName() parameters�Fparam
		affair = new ACAffairInfo(QO004.class.getName(), param);
		// ����Ə��o�^��ʁiQO004�j��ɑJ�ڂ���B
		ACFrame.getInstance().next(affair);

	}

	/**
	 * �u�폜�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void deleteActionPerformed(ActionEvent e) throws Exception {
		// �I�����Ə��̏����폜���鏈��
		if (getProviderTable().getSelectedSortedRow() == -1) {
			// �I������Ă��Ȃ��ꍇ
			// �����𒆒f����B
			return;
		}

		// �I������Ă��鎖�Ə��ԍ���providerId�ɑޔ�����B
		// �ꎞ���pHashMap
		VRMap providerIDMap = new VRHashMap();
		providerIDMap = (VRMap) getProviderTable().getSelectedModelRowValue();
		setProviderId(String.valueOf(VRBindPathParser.get("PROVIDER_ID",
				providerIDMap)));

		// ���݂̑I���s��ޔ�����
		int sel = getProviderTable().getSelectedModelRow();

		// �폜�۔��ʃ`�F�b�N���s���B
		doDeleteCheck();

		// �폜�������ꍇ(True)
		// �폜�m�F���s���B�����b�Z�[�WID = WARNING_OF_DELETE ���� = "�I������Ă��鎖�Ə�"
		if (doDeleteCheck()) {
			int msgID = QkanMessageList.getInstance().WARNING_OF_DELETE(
					"�I�𒆂̎��Ə�");
			// �OK�������
			// �폜�������s���B
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				if (!doDelete()) {
					return;
				}
				break;

			case ACMessageBox.RESULT_CANCEL:
				// �u�L�����Z���v�I����
				return;
			// �����𒆒f����B
			}
            
            if(QkanSystemInformation.getInstance().getLoginProviderID().equals(getProviderId())){
                //�폜�Ώۂ����O�C�����Ə��̏ꍇ
//�J�ڗ������璼�O�̗������폜���A���O�C����ʂ֋����I�ɖ߂��悤�ɂ���B
                List history = ACFrame.getInstance().getTraceAffairs();
                if(history!=null){
                    int size=history.size();
                    if(size>2){
                        //���O�̉�ʁi���C�����j���[�j���Ȃ��������Ƃɂ���
                        ACFrame.getInstance().getTraceAffairs().remove(size-2);
                    }
                }
//                �폜�������b�Z�[�W��\������B�����b�Z�[�WID = QO003_DELETE_SUCCESSED_AND_MUST_LOGOUT
//                QkanMessageList.getInstance().QO003_DELETE_SUCCESSED_AND_MUST_LOGOUT();
            }
//            }else{
//
//			// �폜�������b�Z�[�W��\������B�����b�Z�[�WID = DELETE_SUCCESSED
//                QkanMessageList.getInstance().DELETE_SUCCESSED();
//            }

			// �폜��A�폜�����f�[�^�̂ЂƂ��I������B
			getProviderTable().setSelectedSortedRowOnAfterDelete(sel);

			// �폜�s�������ꍇ(false)
		} else {
			// �G���[���b�Z�[�W��\������B �����b�Z�[�WID = ERROR_OF_DELETE_USED ���� = ��1����
			QkanMessageList.getInstance().ERROR_OF_DELETE_USED(
					getDeleteErrorMsg());
			// ��1�����FdeleteErrorMsg
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
	protected void providerTableMouseClicked(MouseEvent e) throws Exception {
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
		ACFrame.debugStart(new ACAffairInfo(QO003.class.getName(), param));
	}

	// �����֐�

	/**
	 * �u���Ə����擾�����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFind() throws Exception {
		// ���Ə����e�[�u���ɕ\������f�[�^���擾���鏈��
		// ��ʑJ�ڃp�����^�� KEY�F"��������"�����݂��邩�`�F�b�N����B
		VRMap param = getAffairMap();

		if (VRBindPathParser.has("��������", param)) {
			// ���݂����ꍇ
			// HashMap�Fmemory���쐬����B
			// VRMap memory = new VRHashMap();
			// KEY�F"��������"�̒l��memory�Ɋi�[����B
			VRMap memory = new VRHashMap();
			memory = (VRMap) VRBindPathParser.get("��������", param);
			// memory��contents�i�N���C�A���g�̈�j�̃\�[�X�Ƃ��Đݒ肷��B
			this.setSource(memory);
			// ��ʂɓW�J����B
			this.bindSource();

			//doFindProvider();

			// ��d�ɕ������Ȃ��悤�ɃL�[���폜����B
			param.remove("��������");
		} else {
			// ���݂��Ȃ������ꍇ
			// ���Ə������擾�����߂�SQL�����擾����B
			// getSQL_GET_PROVIDER(null);
			// �擾����SQL�������s����B
			// getDBManager().executeQuery(getSQL_GET_PROVIDER(null));
			// ���R�[�h���擾�ł����ꍇ
			// providerList�Ɏ擾�������R�[�h�W�����i�[����B
			setProviderList(getDBManager().executeQuery(
					getSQL_GET_PROVIDER(null)));

			// �X�^�b�t�����擾��providerList���̊Y�����Ə��ɏ���ݒ肷��B
			//if (getProviderList().size() > 0) {
				doFindStaff();

			//}
		}

		// �p�b�V�u�`�F�b�N�p�̃f�[�^��o�^����B
		getPassiveChecker().reservedPassive(getPROVIDER_PASSIVE_CHECK_KEY(),
				getProviderList());

		// �擾�������Ə����iproviderList�j��providerTableModel�ɐݒ肷��B
		getProviderTableModel().setAdaptee(getProviderList());

	}

	/**
	 * �u�X�^�b�t�����擾����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFindStaff() throws Exception {
		// �X�^�b�t�����擾����B
		// �X�^�b�t�����擾���邽�߂�SQL�����擾����B
		// �擾����SQL�������s����B
		// VRMap staffMap= new VRHashMap();
		VRList providerList = getDBManager().executeQuery(
				getSQL_GET_PROVIDER(null));
		for (int i = 0; i < providerList.size(); i++) {
			VRMap sqlparam = new VRHashMap();
			sqlparam.setData("PROVIDER_ID", VRBindPathParser.get("PROVIDER_ID",
					(VRMap) providerList.getData(i)));
			VRList providerStaffList = getDBManager().executeQuery(
					getSQL_GET_STAFF(sqlparam));
			if (providerStaffList.size() > 0) {
				((VRMap) getProviderList().getData(i))
						.putAll((VRMap) providerStaffList.getData());
			}
		}

	}

	/**
	 * �u�폜�����ۊm�F�����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doDeleteCheck() throws Exception {
		// �폜�\�Ȏ��Ə���񂩂𔻕ʂ��鏈��
		// �v���F�藚��TABLE�ŋ���x�����Ə��Ƃ��ēo�^����Ă��邩�`�F�b�N����B
		// SQL���擾�̂���VRMap�FproviderMap���쐬���A���L��KEY/VALUE��ݒ肷��B
		VRMap providerMap = new VRHashMap();
		// KEY�FPROVIDER_ID VALUE�FproviderId
		providerMap.setData("PROVIDER_ID", getProviderId());

		// �v���F�藚��TABLE�`�F�b�N�p��SQL�����擾����B
		// getSQL_GET_PATIENT_NINTEI_HISTORY(providerMap);
		// SQL�������s����B
		VRList PatientNinteiHistoryList = getDBManager().executeQuery(
				getSQL_GET_PATIENT_NINTEI_HISTORY(providerMap));
		// ���R�[�h���擾�ł����ꍇ
		if (PatientNinteiHistoryList.size() > 0) {
			// �폜�s�G���[���b�Z�[�W�Ŏg�p����p�����[�^�[���쐬����B
			// deleteErrorMsg = ����x�����Ə�
			setDeleteErrorMsg("����x�����Ə�");
			// �߂�l�Ƃ��� false ��Ԃ��B
			return false;
		}

		// �T�[�r�XTABLE�i�\��j�Ƃ��ēo�^����Ă��鎖�Ə����`�F�b�N����B
		// �T�[�r�XTABLE�`�F�b�N�p��SQL�����擾����B��param�͎g���܂킵�ő�p
		// getSQL_GET_SERVICE_PLAN(providerMap);
		// �擾����SQL�������s����B
		VRList ServicePlanList = getDBManager().executeQuery(
				getSQL_GET_SERVICE_PATTEN(providerMap));
		// ���R�[�h���擾�ł����ꍇ
		if (ServicePlanList != null && ServicePlanList.size() > 0) {
            VRMap serviceMap = new VRHashMap();
            
            serviceMap  = (VRMap)ServicePlanList.getData();
            //�T�[�r�X�p�^�[���Ƃ��ēo�^����Ă����ꍇ
            if(new Integer(1).equals(serviceMap.getData("SERVICE_USE_TYPE"))){
                setDeleteErrorMsg("�T�[�r�X�p�^�[��");
                // �߂�l�Ƃ��� false ��Ԃ��B                
                return false;
                
                // �폜�s�G���[���b�Z�[�W�Ŏg�p����p�����[�^�[���쐬����B
                // deleteErrorMsg = �T�[�r�X�\��
            } else if (new Integer(2).equals(serviceMap
                    .getData("SERVICE_USE_TYPE"))
                    || new Integer(3).equals(serviceMap
                            .getData("SERVICE_USE_TYPE"))
                    || new Integer(4).equals(serviceMap
                            .getData("SERVICE_USE_TYPE"))
                    || new Integer(5).equals(serviceMap
                            .getData("SERVICE_USE_TYPE"))) {
                
                setDeleteErrorMsg("�T�[�r�X�\��");
                // �߂�l�Ƃ��� false ��Ԃ��B
                return false;
                
            } else if (new Integer(6).equals(serviceMap
                    .getData("SERVICE_USE_TYPE"))
                    || new Integer(7).equals(serviceMap
                            .getData("SERVICE_USE_TYPE"))
                    || new Integer(8).equals(serviceMap
                            .getData("SERVICE_USE_TYPE"))
                    || new Integer(9).equals(serviceMap
                            .getData("SERVICE_USE_TYPE"))) {
                // �폜�s�G���[���b�Z�[�W�Ŏg�p����p�����[�^�[���쐬����B
                // deleteErrorMsg = �T�[�r�X����
                setDeleteErrorMsg("�T�[�r�X����");
                // �߂�l�Ƃ��� false ��Ԃ��B
                return false;
            }

        }
		// �������TABLE�ɐ��������Ə��Ƃ��ēo�^����Ă��Ȃ����`�F�b�N����B
		// �������TABLE�`�F�b�N�p��SQL�����擾����B
		// getSQL_GET_CLAIM(providerMap);
		// �擾����SQL�������s����B
		VRList ClaimList = getDBManager().executeQuery(
				getSQL_GET_CLAIM(providerMap));
		// ���R�[�h���擾�ł����ꍇ
		if (ClaimList.size() > 0) {
			// �폜�s�G���[���b�Z�[�W�Ŏg�p����p�����[�^�[���쐬����B
			// deleteErrorMsg = ���������Ə�
			setDeleteErrorMsg("���������Ə�");
			// �߂�l�Ƃ��� false ��Ԃ��B
			return false;
		}

		// ���R�[�h���擾�ł��Ȃ������ꍇ
		// �S�Ă�SQL���̌��ʂ�0���������ꍇ
		// �߂�l�Ƃ��� true ��Ԃ�
		return true;
	}

	/**
	 * �u�폜�����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doDelete() throws Exception {
		// �I������Ă��郌�R�[�h�̃C���f�b�N�X���i�[����index���`����B
		int index;

		// �����̓`�F�b�N
		// ��ʂ́u���Ə��ꗗ�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
		if (getProviderTable().getSelectedSortedRow() == -1) {
			// �I������Ă��Ȃ��ꍇ
			// �����𒆒f����B
			return false;
		} else {
			// �I������Ă���ꍇ
			// �I���s�̃C���f�b�N�X(���f���ł͂Ȃ���ʏ�)���擾����B
			index = getProviderTable().getSelectedModelRow();
		}

		try {
			// �g�����U�N�V�����J�n
			getDBManager().beginTransaction();

			// ���p�b�V�u�`�F�b�N
			// �p�b�V�u�^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();

			// �p�b�V�u�^�X�N��o�^����B
			getPassiveChecker().addPassiveDeleteTask(
					getPROVIDER_PASSIVE_CHECK_KEY(), index);

			// �p�b�V�u�`�F�b�N�����s����B
			if (!getPassiveChecker().passiveCheck(getDBManager())) {
				// �p�b�V�u�G���[������ꍇ
				// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
				QkanMessageList.getInstance()
						.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
				// �����𒆒f����B(�ُ�I��)
				getDBManager().rollbackTransaction();
				return false;
			}

			// �p�b�V�u�G���[���������Ȃ������ꍇ
			// �߂�l�Ƃ��ċA���Ă���DBManager�� deleteDBManager �ɑޔ�����B
			ACDBManager deleteDBManager = getDBManager();
			// ���VRList�FdeleteList�𐶐�����B
			VRList deleteList = new VRArrayList();
			// VRmap�FproviderMap�𐶐������L��KEY/VALUE��ݒ肷��B
			VRMap providerMap = new VRHashMap();
			// KEY�FPROVIDER_ID VALUE�FproviderId
			providerMap.setData("PROVIDER_ID", getProviderId());

			// ���Ə��̃T�[�r�X�ڍׂ��폜����B
			QkanCommon.updateProviderServiceDetail(deleteDBManager, deleteList,
					getProviderId());
			// ���Ə��̐e�����폜����B
			// �e���Ə������폜���邽�߂�SQL�����擾����B
			// getSQL_DELETE_PROVIDER(providerMap);
			// �擾����SQL�������s����B
			getDBManager().executeUpdate(getSQL_DELETE_PROVIDER(providerMap));

			// SQL�����s���ɃG���[���������Ȃ������ꍇ
			getDBManager().commitTransaction();
			// ���Ə������ĕ`�ʂ���B
			doFind();

		} catch (Exception ex) {
			// �G���[���������ꍇ
			// ���������[���o�b�N����B
			// �����𒆒f����B(�ُ�I��)
			getDBManager().rollbackTransaction();

			// ��ʃN���X�ɗ�O��Ԃ��B
			throw ex;
		}
		return true;
	}

	/**
	 * �u���������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFindProvider() throws Exception {
		// ���Ə��̌�������
		// ���������i�[�p��VRMap�FfindParam�𐶐�����B
		VRMap findParam = new VRHashMap();

		getFindContens().setSource(findParam);

		// ���������p�ɢ���������̈�ifindContens�j��̃f�[�^���擾��findParam�Ɋi�[����B
		getFindContens().applySource();

		// ����Ə���ʃR���{�ifindContentproviderType�j��̒l���`�F�b�N����B
		if(getFindContentproviderType().getSelectedIndex() == 0){
			//�Ȃɂ����Ȃ�
		}else if (getFindContentproviderType().isSelected()) {
			// ���͂���Ă����ꍇ
			// findParam�iVRMap�j�Ɉȉ���KEY/VALUE��ݒ肷��B
			// KEY�FFIND_PROVIDER_TYPE VALUE�F"" ��SQL���Ŏg�p���邽�ߒl�͋󔒂ł悢
			findParam.setData("FIND_PROVIDER_TYPE", "");
		}

		// ����Ə��ԍ��e�L�X�g�ifindContentproviderId�j��̒l���`�F�b�N����B
		if (!ACTextUtilities.isNullText(getFindContentproviderId().getText())) {
			// ���͂���Ă����ꍇ
			// findParam�iVRMap�j�Ɉȉ���KEY/VALUE��ݒ肷��B
			// KEY�FFIND_PROVIDER_ID VALUE"" ��SQL���Ŏg�p���邽�ߒl�͋󔒂ł悢
			findParam.setData("FIND_PROVIDER_ID", "");
		}

		// ����Ə����̃e�L�X�g�ifindContentproviderName)��̒l���`�F�b�N����B
		if (!ACTextUtilities.isNullText(getFindContentproviderName().getText())) {
			// ���͂���Ă����ꍇ
			// findParam�iVRMap�j�Ɉȉ���KEY/VALUE��ݒ肷��B
			// KEY�FFIND_PROVIDER_NAME VALUE�F"" ��SQL���Ŏg�p���邽�ߋ󕶎��ł悢
			findParam.setData("FIND_PROVIDER_NAME", "");
		}

		// findParam��
		// KEY�FFIND_PROVIDER_TYPE�AFIND_PROVIDER_NAME�AFINDPROVIDER_ID�����݂��邩�`�F�b�N����B
		if (!VRBindPathParser.has("FIND_PROVIDER_TYPE", findParam)
				&& !VRBindPathParser.has("FIND_PROVIDER_NAME", findParam)
				&& !VRBindPathParser.has("FIND_PROVIDER_ID", findParam)) {
			// ���݂��Ȃ������ꍇ
			
			// ���Ə��̈ꗗ��������ʂɓW�J����B���S��������
			doFind();
		}

		// �����𔲂���B
		// �����Ɏg�p���邽�߂�SQL�����擾����B
		// getSQL_FIND_PROVIDER(findParam);
		// �擾����SQL�����s����B
		setProviderList(getDBManager().executeQuery(
				getSQL_FIND_PROVIDER(findParam)));

		// ���R�[�h���擾�ł����ꍇ
		//if (getProviderList().size() > 0) {
			// �擾�������Ə�����providerList�Ɋi�[����B
			// �X�^�b�t�����擾��providerList���̊Y�����Ə��ɏ���ݒ肷��B
			// doFindStaff();
			for (int i = 0; i < getProviderList().size(); i++) {
				VRMap sqlparam = new VRHashMap();
				sqlparam.setData("PROVIDER_ID", VRBindPathParser.get(
						"PROVIDER_ID", (VRMap) getProviderList().getData(i)));

				VRList providerStaffList = getDBManager().executeQuery(
						getSQL_GET_STAFF(sqlparam));

				if (providerStaffList.size() > 0) {
					((VRMap) getProviderList().getData(i))
							.putAll((VRMap) providerStaffList.getData(0));
				}
			}

			// �擾�������Ə����iproviderList�j��providerTableModel�ɐݒ肷��B
			getProviderTableModel().setAdaptee(getProviderList());
			// �e�[�u����1�s�ڂ�I����Ԃɂ���B
			getProviderTable().setSelectedSortedFirstRow();
		//} else {
			// ���R�[�h���擾�ł��Ȃ������ꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = NOT_FOUND ���� = ���Ə�
			//QkanMessageList.getInstance().NOT_FOUND("���Ə�");
		//}

	}

	/**
	 * �u���������ޔ��v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void createFindState() throws Exception {
		// �����������̑ޔ�
		// ���������L���p�̃��R�[�h memory�𐶐�����B
		VRMap memory = new VRHashMap();
		// �����������L�������ʍ���(contents)�̃\�[�X�Ƃ��āAmemory���w�肷��B
		getContents().setSource(memory);
		// ��ʍ��ڂ̏��𒊏o����B
		getContents().applySource();
		// ���݂̉�ʑJ�ڗp�p�����^�Ɉȉ���KEY/VALUE��ݒ肷��B
		// ��EY�F"��������" VALUE�Fmemory
		ACFrame.getInstance().addNowAffairParameter("��������", memory);
	}

	/**
	 * �u�ڍ׉�ʑJ�ځv�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void transferNext() throws Exception {
		// ���Ə��o�^��ʂɑJ�ڂ��鏈���i�X�V�j
		// ��ʂ̢���Ə��ꗗ�e�[�u����̃��R�[�h���I������Ă邩�`�F�b�N����B
		if (getProviderTable().getSelectedSortedRow() != -1) {
			// ���R�[�h���I������Ă����ꍇ
			// VRMap�Fparam���쐬�����L�̃p�����[�^�[���i�[����B
			VRMap param = new VRHashMap();
			// KEY�FPROCESS_MODE VALUE�F���ʒ萔�̢PROCESS_MODE_UPDATE(3)�
			param.setData("PROCESS_MODE", new Integer(
					QkanConstants.PROCESS_MODE_UPDATE));
			// KEY�FPROVIDER_ID VALUE�F�I�����Ə�ID
			// �ꎞ���pHashMap
			VRMap providerIDMap = new VRHashMap();

			providerIDMap = (VRMap) getProviderTable()
					.getSelectedModelRowValue();

			param.setData("PROVIDER_ID", VRBindPathParser.get("PROVIDER_ID",
					providerIDMap));
			// ��ʏ��擾�p��VRMap�FstateMap�𐶐�����B
			VRMap stateMap = new VRHashMap();
			// ��Ԃ��L�������ʍ��ڂ̃\�[�X�Ƃ��Ďw��ithis)
			getContents().setSource(stateMap);
			// ��ʍ��ڂ̏��𒊏o����
			getContents().applySource();
			// ���o�����l��param�ɉ��L��KEY/VALUE���i�[����B
			// KEY�FSTATE VALUE�F���o�����l
			param.setData("STATE", stateMap);
			// ����ʑJ�ڂ̂��߃p�����[�^�[NCAffairInfo affair���`����B
			ACAffairInfo affair = null;
			// ���L�̃p�����[�^�[��affair�𐶐�����B
			// className�FQO004.class.getName() parameters�Fparam
			affair = new ACAffairInfo(QO004.class.getName(), param);
			// ����Ə��o�^��ʁiQO004�j��ɑJ�ڂ���B
			ACFrame.getInstance().next(affair);
		}
	}
}
