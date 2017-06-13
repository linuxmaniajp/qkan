
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
 * �쐬��: 2016/09/14  ���{�R���s���[�^�[�������  �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X �������ƃT�[�r�X�R�[�h�Ǘ� (016)
 * �v���O���� �������ƃT�[�r�X�R�[�h�ꗗ (QO016)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo016;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceUnitGetter;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.bridge.sql.BridgeFirebirdSeparateTable;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qo.qo017.QO017;

/**
 * �������ƃT�[�r�X�R�[�h�ꗗ(QO016) 
 */
public class QO016 extends QO016Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO016(){
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
		// ��ʂ̏����\�����s������
		
		// ���E�B���h�E�^�C�g���̐ݒ�
		setAffairTitle("QO016", getButtons());

		// ��������ƃT�[�r�X�R�[�h���TABLE�iM_SJ_SERVICE_CODE)��̃p�b�V�u�`�F�b�N�L�[���`����B
		setM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(new ACPassiveKey("M_SJ_SERVICE_CODE",
				new String[] { "SYSTEM_SERVICE_CODE_ITEM", "TEKIYO_ST_DATE" }, new Format[] {
				ACConstants.FORMAT_SQL_STRING, new ACSQLSafeDateFormat("yyyy-MM-dd") },
				"LAST_TIME", "LAST_TIME"));

		// �n��p�����[�^��ޔ�����B
		VRMap params = affair.getParameters();
		
		// �Ώ۔N���̐ݒ�
		// ��ʂ́u�Ώ۔N��(targetDate)�v�ɁA�擾�����V�X�e�����t��ݒ肷��B
		Date sysDate = QkanSystemInformation.getInstance().getSystemDate();
		getTargetDate().setDate(sysDate);

		// �ی��҃R���{�̍��ڂ�ݒ肷��B
		VRMap comboInsureMap = new VRHashMap();
		comboInsureMap.setData("INSURER_ID", QkanCommon.getInsurerInfo(getDBManager()));
		getInsurerNoCombo().setModelSource(comboInsureMap);
		getInsurerNoCombo().bindModelSource();

		// �T�[�r�X��ރR���{�̍��ڂ�ݒ肷��B
		VRMap comboMap = new VRHashMap();
		comboMap.setData("SERVICE_CODE_KIND", QkanSjServiceCodeManager.getMasterServiceSogojigyo(getDBManager(), sysDate));
		// comboMap��N���C�A���g�̈�icontents�j��ɐݒ肷��B
		getServiceCodeKindCombo().setModelSource(comboMap);
		getServiceCodeKindCombo().bindModelSource();

		// ���e�[�u�����f�����`����B
		ACTableModelAdapter sjServiceCodeInfoTableModel = new ACTableModelAdapter();
		sjServiceCodeInfoTableModel.setColumns(new String[] { 
				"SERVICE_CODE_KIND+'-'+SERVICE_CODE_ITEM",
				"TEKIYO_ST_DATE",
				"TEKIYO_ED_DATE",
				"SERVICE_NAME",
				"SERVICE_UNIT",
				"SAKUSEI_DATE"
		});
		// ���A�_�v�^���e�[�u���̃��f���Ƃ��Đݒ肷��B
		setSjServiceCodeInfoTableModel(sjServiceCodeInfoTableModel);
		getSjServiceCodeInfoTable().setModel(getSjServiceCodeInfoTableModel());

		// ����params��null�̏ꍇ�������I������
		if (params == null) {
			return;
		}

		// �T�[�r�X�R�[�h����ID���Z�b�g(�捞��ʂ���J�ڂ����ꍇ)
		if (VRBindPathParser.has("SJ_SERVICE_CODE_HISTORY_ID", params)) {
			setSjServiceCodeHistoryId(String.valueOf(VRBindPathParser.get("SJ_SERVICE_CODE_HISTORY_ID",
					params)));
		}

		// �ی��Ҕԍ������������ɃZ�b�g(�捞��ʂ���J�ڂ����ꍇ)
		if (VRBindPathParser.has("INSURER_ID", params)) {
			getInsurerNoText().setText(ACCastUtilities.toString(VRBindPathParser.get(
					"INSURER_ID", params)));
			// �ی��҃R���{��\������
			String insureNo = getInsurerNoText().getText();
			for (int i = 0; getInsurerNoCombo().getModel().getSize() > i; i++) {
				VRMap map = (VRMap) getInsurerNoCombo().getModelItem(i);
				if (insureNo.equals(map.getData("INSURER_ID"))) {
					getInsurerNoCombo().setSelectedIndex(i);
					break;
				}
			}
		}

		// �ڍוҏW��ʂ���߂��Ă����ꍇ�̍ĕ`�揈��
		if( VRBindPathParser.has("QO016_DATA", params) ){
			VRMap memory = (VRMap)VRBindPathParser.get("QO016_DATA", params);
			this.setSource( memory );
			this.bindSource();
			params.removeData("QO016_DATA");
		}
		
		doFind();
		
		// �n��p�����[�^�[�̒��ɑO��ʂ̃V�X�e���T�[�r�X���ڃR�[�h�A�K�p�J�n�N���������邩�`�F�b�N����
		if (VRBindPathParser.has("SYSTEM_SERVICE_CODE_ITEM", params) &&
				VRBindPathParser.has("TEKIYO_ST_DATE", params)) {

			// �ڍ׉�ʂőI������Ă����������ƃT�[�r�X�R�[�h�ƍ��v���郌�R�[�h��index���擾����B
			String key1 = ACCastUtilities.toString(params.get("SYSTEM_SERVICE_CODE_ITEM"));
			VRDateFormat df = new VRDateFormat();
			String key2 = df.format((Date) params.get("TEKIYO_ST_DATE"), "yyyy-MM-dd");

            int index = -1;
			for(int i = 0; i < getSjServiceCodeInfoList().size(); i++){
				VRMap map = (VRMap)getSjServiceCodeInfoList().get(i);
				if(ACCastUtilities.toString(map.get("SYSTEM_SERVICE_CODE_ITEM")).equals(key1) &&
						ACCastUtilities.toString(map.get("TEKIYO_ST_DATE")).equals(key2)){
					index = i;
					break;
				}
			}
			// ��v����
			if (index != -1) {
				// �ڍׂ���̑������ƃT�[�r�X�R�[�h��I����Ԃɂ���
				getSjServiceCodeInfoTable().setSelectedModelRow(index);

			} else {
				// ���R�[�h��1�s�ڂ�I����Ԃɂ���B
				getSjServiceCodeInfoTable().setSelectedSortedFirstRow();
			}

		} else {
			// ���R�[�h��1�s�ڂ�I����Ԃɂ���B
			getSjServiceCodeInfoTable().setSelectedSortedFirstRow();

		}
		// �I�𑍍����ƃT�[�r�X�R�[�h�ɃX�N���[������
		getSjServiceCodeInfoTable().scrollSelectedToVisible();

		params.clear();

	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		
		parameters.setData("SJ_SERVICE_CODE_HISTORY_ID", getSjServiceCodeHistoryId());

		// �O��ʂɑJ�ڂ���B
		return true;
	}

	//�R���|�[�l���g�C�x���g

	/**
	 * �u���������v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void findActionPerformed(ActionEvent e) throws Exception{

		// �������s���Ă悢���m�F���s���B
		if (!checkFind()) {
			return;
		}

		// �������s���B
		doFind();
		
		//���R�[�h��1�s�ڂ�I����Ԃɂ���B
		getSjServiceCodeInfoTable().setSelectedSortedFirstRow();

	}

	/**
	 * �u�������ƃT�[�r�X�R�[�h�o�^��ʂɑJ�ځi�X�V�j�v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void detailActionPerformed(ActionEvent e) throws Exception{
		moveQO017();
	}

	/**
	 * �u�������ƃT�[�r�X�R�[�h�o�^��ʂɑJ�ځi�V�K�j�v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception{
		// ��ʏ��̑ޔ�
		VRHashMap memory = new VRHashMap();
		this.setSource( memory );
		this.applySource();
		ACFrame.getInstance().addNowAffairParameter("QO016_DATA", memory);

		// �������ƃT�[�r�X�R�[�h���o�^��ʂɐV�K�o�^���[�h�őJ�ڂ��鏈��
		VRMap param = new VRHashMap();
		param.setData("PROCESS_MODE", new Integer(
				QkanConstants.PROCESS_MODE_INSERT));
		param.setData("INSURER_ID", getInsurerNoText().getText());

		// ����ʑJ�ڂ̂��߂̃p�����[�^�[ACAffairInfo affair���`����B
		ACAffairInfo affair = null;
		affair = new ACAffairInfo(QO017.class.getName(), param);

		// �QO017�i�������ƃT�[�r�X�R�[�h�o�^�j��ɑJ�ڂ���B
		ACFrame.getInstance().next(affair);

	}

	/**
	 * �u�폜�����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void deleteActionPerformed(ActionEvent e) throws Exception{
		
    	// ��ʂ̢�������ƃT�[�r�X�R�[�h�ꗗ��̍s���I������Ă��邩�`�F�b�N����B
		// �I������Ă���ꍇ
		if (getSjServiceCodeInfoTable().isSelected()) {

			// �I���T�[�r�X�R�[�h���g�p����Ă��邩�ǂ����`�F�b�N����B
			if (!checkSjServiceCode()) {
				// �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance().ERROR_OF_DELETE_USED("�\��A�܂��͎���");
				// �����𔲂���B�i�����𒆒f����j
				return;

			} else {

				VRMap tableData = (VRMap) getSjServiceCodeInfoTable()
						.getSelectedModelRowValue();
				setSystemServiceCodeItem((String.valueOf(tableData.getData("SYSTEM_SERVICE_CODE_ITEM"))));
				setTekiyoStDate((Date) VRBindPathParser.get("TEKIYO_ST_DATE",tableData));
	
				// �폜�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_DELETE
				int msgID = QkanMessageList.getInstance().WARNING_OF_DELETE(
						"�I�𒆂̑������ƃT�[�r�X�R�[�h���");
	
				// ��͂��������
				if (msgID == ACMessageBox.RESULT_YES) {
	
					// ���݂̑I���s��ޔ�����
					int sel = getSjServiceCodeInfoTable().getSelectedModelRow();
	
					// �폜�������s���B
					if (!doDelete()) {
						// ���炩�̃G���[�����������ꍇ�����𒆒f����
						return;
					}
	
					// �폜��̗��z�ƂȂ�s�ԍ���ݒ肷��
					getSjServiceCodeInfoTable()
					.setSelectedSortedRowOnAfterDelete(sel);
	
				}
			}

			// ��������������
			// �����𔲂���B�i�������s��Ȃ��j
			return;
		}
	}

	/**
	 * �u�Ώۃ��R�[�h��\���v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void sjServiceCodeInfoTableSelectionChanged(ListSelectionEvent e) throws Exception{
		// ����ʂ̐���
		if (!getSjServiceCodeInfoTable().isSelected()) {
			// �I������Ă��Ȃ��ꍇ
			// �Ɩ��{�^���̏�Ԃ�ύX����B
			setState_UNSELECTED();
			// �E���ID�FUNSELECTED
		} else {
			// �I������Ă���ꍇ
			// �Ɩ��{�^���̏�Ԃ�ύX����B
			setState_SELECTED();
			// �E���ID�FSELECTED
		}
	}

	/**
	 * �u��ʑJ�ڏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void sjServiceCodeInfoTableMouseClicked(MouseEvent e) throws Exception{
		moveQO017();
	}

	/**
	 * �u�ی��Җ��\���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insurerNoTextFocusLost(FocusEvent e) throws Exception {

		String insureNo = getInsurerNoText().getText();
		for (int i = 0; getInsurerNoCombo().getModel().getSize() > i; i++) {
			VRMap map = (VRMap) getInsurerNoCombo().getModelItem(i);
			if (insureNo.equals(map.getData("INSURER_ID"))) {
				getInsurerNoCombo().setSelectedIndex(i);
				return;
			}
		}
		getInsurerNoCombo().setSelectedItem(null);

	}
	
	/**
	 * �u�ی��Җ��̃R���{�{�b�N�X�I�����̏����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insurerNoComboActionPerformed(ActionEvent e)
			throws Exception {
		// �I�����ꂽ�R���{�̃C���f�b�N�X
		int index = getInsurerNoCombo().getSelectedIndex();

		if (index < 0)
			return;

		VRMap map = (VRMap) getInsurerNoCombo().getSelectedItem();
		String insureNo = ACCastUtilities.toString(map.get("INSURER_ID"));

		if (insureNo == null)
			return;

		// ��ʏ�ɐݒ肷��B
		getInsurerNoText().setText(insureNo);
	}

	public static void main(String[] args) {
		//�f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		//param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QO016.class.getName(), param));
	}

	//�����֐�

	/**
	 * �u���R�[�h���擾����ʂɐݒ肷��B�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void doFind() throws Exception{

		if (!ACTextUtilities.isNullText(getInsurerNoText().getText())) {
			doFindData();
		}

		if (!getSjServiceCodeInfoList().isEmpty()) {
			// ���R�[�h��1���ȏ�̏ꍇ
			// �擾�����S�ی��ҏ��iinsurerInfoList�j��insurerTableModel�ɐݒ肷��B
			getSjServiceCodeInfoTableModel().setAdaptee(getSjServiceCodeInfoList());
			// �������ƃT�[�r�X�R�[�h���TABLE�p�b�V�u�`�F�b�N�p�Ƀf�[�^��o�^����B
			getPassiveChecker().reservedPassive(
					getM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(), getSjServiceCodeInfoList());

		} else {
			// ��񂪎擾�ł��Ȃ������ꍇ
			getSjServiceCodeInfoList().clearData();
			getSjServiceCodeInfoTableModel().setAdaptee(getSjServiceCodeInfoList());

			// ��ʏ�Ԃ�ύX����
			setState_UNSELECTED();
		}

	}

	/**
	 * �u�I�𑍍����ƃT�[�r�X�R�[�h�폜�����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public boolean doDelete() throws Exception{
		// �������ƃT�[�r�X�R�[�h�����폜���鏈��
		try {
			// �g�����U�N�V�������J�n����B
			getDBManager().beginTransaction();
			// �p�b�V�u�^�X�N���N���A����B
			getPassiveChecker().clearPassiveTask();
			// �p�b�V�u�^�X�N��ǉ�����B�i�������ƃT�[�r�X�R�[�h���폜�p�j
			getPassiveChecker().addPassiveUpdateTask(
					getM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY());

			// �p�b�V�u�`�F�b�N�����s����B
			if (!getPassiveChecker().passiveCheck(getDBManager())) {
				//�e�[�u�����b�N�����̂��߃��[���o�b�N
				getDBManager().rollbackTransaction();
				// �p�b�V�u�G���[������ꍇ
				// �G���[���b�Z�[�W��\������B
				QkanMessageList.getInstance()
				.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
				// �����𔲂���B�i�����𒆒f����j
				return false;
			}

			// �p�b�V�u�G���[���Ȃ��ꍇ
			// �������ƃT�[�r�X�R�[�h���폜�p��SQL�����擾����B
			// SQL���擾�̂���VRMap�Fparam���쐬���A���L�̃p�����[�^�[��ݒ肷��B
			VRMap param = new VRHashMap();
			param.setData("SYSTEM_SERVICE_CODE_ITEM", getSystemServiceCodeItem());
			param.setData("TEKIYO_ST_DATE", getTekiyoStDate());

			// �������ƃT�[�r�X�R�[�h���폜�p��SQL�����擾����
			// �擾����SQL�������s����B
			getDBManager().executeUpdate(getSQL_UPDATE_TO_DELETE_M_SJ_SERVICE_CODE(param));
			// ��������SQL���̎��s����1���G���[���������Ȃ������ꍇ
			// �R�~�b�g����B
			getDBManager().commitTransaction();
			// �������ƃT�[�r�X�R�[�h�֘A�����擾���p�b�V�u�`�F�b�N�p�ɑޔ�����B
			doFind();
			// ����I��
			return true;
		} catch (Exception sqlEx) {
			// ��������SQL���̎��s����1�ł��G���[�����������ꍇ
			// ���������[���o�b�N����B
			getDBManager().rollbackTransaction();
			// �����𔲂���B�i�����𒆒f����j
			throw sqlEx;
		}
	}

	/**
	 * �u���������̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkFind() throws Exception {
		// �ی��Ҕԍ������̓`�F�b�N
		if (ACTextUtilities.isNullText(getInsurerNoText().getText())) {
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("�ی��Ҕԍ�");
			getInsurerNoText().requestFocus();
			return false;
		}
		// �Ώ۔N���Ó����`�F�b�N
		if (!ACTextUtilities.isNullText(getTargetDate().getText())) {
			if (!getTargetDate().isValidDate()) {
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�Ώ۔N����");
				getTargetDate().requestFocus();
				return false;
			}
		}

		return true;

	}

	/**
	 * �u�����������s���B�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void doFindData() throws Exception{
		// ��DB����T�[�r�X�R�[�h�ꗗ���擾�A��ʂɐݒ�
		VRMap findParam = new VRHashMap();

		getSjServiceCodeInfoFind().setSource(findParam);

		// ���������p�ɢ���������̈�ifindContens�j��̃f�[�^���擾��findParam�Ɋi�[����B
		getSjServiceCodeInfoFind().applySource();

		// SQL�������s����B
		setSjServiceCodeInfoList(getDBManager().executeQuery(
				getSQL_GET_M_SJ_SERVICE_CODE_INFO(findParam)));

	}
	
	/**
	 * �u�V�X�e���T�[�r�X���ڃR�[�h���g�p����Ă��邩�`�F�b�N����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public boolean checkSjServiceCode() throws Exception{
		
		VRMap tableData = (VRMap) getSjServiceCodeInfoTable()
				.getSelectedModelRowValue();
		
		// �V�X�e���T�[�r�X���ڃR�[�h���g�p����Ă��邩�`�F�b�N���鏈��
		// �����ϐ� sqlParam�𐶐������L��KEY/VALUE��ݒ肷��B
		VRMap sqlParam = new VRHashMap();
		sqlParam.setData("SJ_SERVICE_CODE_BIND_PATH_ST", 
				Qkan10011_ServiceUnitGetter.SJ_SERVICE_CODE_BIND_PATH_ST);
		sqlParam.setData("SJ_SERVICE_CODE_BIND_PATH_ED", 
				Qkan10011_ServiceUnitGetter.SJ_SERVICE_CODE_BIND_PATH_ED);
		sqlParam.setData("SYSTEM_SERVICE_CODE_ITEM", 
				(String.valueOf(tableData.getData("SYSTEM_SERVICE_CODE_ITEM"))));
		
		for (int year = 2015; year < 2099; year++) {
			sqlParam.setData("YEAR", year);

			// �e�[�u�������݂��邩
			BridgeFirebirdSeparateTable table = new BridgeFirebirdSeparateTable("SERVICE_DETAIL_TEXT", "");
			if (table.isExistTable(getDBManager(), year)) {
				// �V�X�e���T�[�r�X���ڃR�[�h�擾�̂��߂�SQL�����擾����B
				VRList list = getDBManager().executeQuery(
						getSQL_GET_M_SJ_SERVICE_CODE_INFO_IN_USE(sqlParam));

				if (Integer.parseInt(String.valueOf(VRBindPathParser
						.get("CNT", (VRMap) list.getData(0)))) > 0) {
					// ���R�[�h��1���ȏ�擾�ł����ꍇ�A�폜�s�\�Ƃ��ď�����Ԃ�(false)
					return false;
				}
			} else {
				return true;
			}

		}

		// ���R�[�h���擾�ł��Ȃ������ꍇ�A�폜�\�Ƃ��ď�����Ԃ�(true)
		return true;
	}

	/**
	 * �u�������ƃT�[�r�X�R�[�h�o�^��ʂɑJ�ځi�X�V�j�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
    public void moveQO017() throws Exception {
		// �������ƃT�[�r�X�R�[�h���o�^��ʂɍX�V���[�h�őJ�ڂ��鏈��
		// ��ʂ̢�������ƃT�[�r�X�R�[�h�ꗗ����I������Ă��邩�`�F�b�N����B
		if (getSjServiceCodeInfoTable().isSelected()) {
			// �I������Ă����ꍇ
			
			// �I���T�[�r�X�R�[�h���g�p����Ă��邩�ǂ����`�F�b�N����B
			if (!checkSjServiceCode()) {
				// �x�����b�Z�[�W��\������B
				if (QkanMessageList.getInstance().QO016_WARNING_OF_SJ_SERVICE_CODE_USE() != ACMessageBox.RESULT_OK) {
					return;
				}
			}
			
			// ��ʏ��̑ޔ�
			VRHashMap memory = new VRHashMap();
			this.setSource( memory );
			this.applySource();
			ACFrame.getInstance().addNowAffairParameter("QO016_DATA", memory);
	
			// �I���V�X�e���T�[�r�X���ڃR�[�h��systemServiceCodeItem�Ɋi�[����B
			VRMap rec = (VRMap) getSjServiceCodeInfoTable()
					.getSelectedModelRowValue();
	
			// VPMap�Fparam�𐶐����p�����[�^�[���i�[����B
			VRMap param = new VRHashMap();
			param.setData("SYSTEM_SERVICE_CODE_ITEM", rec.getData("SYSTEM_SERVICE_CODE_ITEM"));
			param.setData("TEKIYO_ST_DATE", rec.getData("TEKIYO_ST_DATE"));
			param.setData("PROCESS_MODE", new Integer(
					QkanConstants.PROCESS_MODE_UPDATE));

			// ����ʑJ�ڂ̂��߂̃p�����[�^�[NCAffairInfo affair���`����B
			ACAffairInfo affair = null;
	
			affair = new ACAffairInfo(QO017.class.getName(), param);
	
			// �QO017�i�������ƃT�[�r�X�R�[�h�o�^�j��ɑJ�ڂ���B
			ACFrame.getInstance().next(affair);
	
		}
    }

}
