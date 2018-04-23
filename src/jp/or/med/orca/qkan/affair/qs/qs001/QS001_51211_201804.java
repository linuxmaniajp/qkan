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
 * �J����: �����@���̂�
 * �쐬��: 2016/09/08 �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����̑��̐����x���T�[�r�X(������z) (QS001_51211_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[�����̑��̐����x���T�[�r�X(������z)(QS001_51211_201804)
 */
public class QS001_51211_201804 extends QS001_51211_201804Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QS001_51211_201804() {
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u�R�[�h���ꗗ�֒ǉ��{�^���̃N���b�N�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void addCodeToListButtonActionPerformed(ActionEvent e)
			throws Exception {
		// �ی��Җ��̃`�F�b�N
		// �I������Ă��邩�ǂ���
		if (!getInsurerName().isSelected()) {
			// �I������Ă��Ȃ��ꍇ
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT("�ی���");
			return;
		}
		// �R�[�h�̃`�F�b�N
		if (ACTextUtilities.isNullText(getItemCodeText())) {
			// �I������Ă��Ȃ��ꍇ
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("�R�[�h");
			return;
		}
		// �R�[�h�̌����`�F�b�N
		String itemCode = getItemCodeText().getText();
		if (4 != itemCode.length()) {
			QkanMessageList.getInstance().ERROR_OF_LENGTH("�R�[�h", 4);
			return;
		}

		// �R�[�h����}�X�^���Q�Ƃ��A�ꗗ�֒ǉ�
		VRMap map = (VRMap) getInsurerName().getSelectedItem();
		String insurerId = ACCastUtilities.toString(map.get("INSURER_ID"));
		if (findCodeToList(insurerId, itemCode)) {
			if (getSvCodeList().size() > 1){
				getSvCodeList().remove(0);
			}
			getItemCodeText().setText("");
			getSvCodeTable().requestFocusInWindow();
			getSvCodeTable().setSelectedSortedLastRow();
		}

	}

	/**
	 * �u�R�[�h�I���{�^���̃N���b�N�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void codeFindButtonActionPerformed(ActionEvent e)
			throws Exception {
		// ���R�[�h�ꗗ�_�C�A���O���N������B�I����e�����X�g�ɒǉ�����B
		VRMap map = (VRMap) getInsurerName().getSelectedItem();
		String insurerId = ACCastUtilities.toString(map.get("INSURER_ID"));
		if (selectCodeToList(insurerId)) {
			if (getSvCodeList().size() > 1){
				getSvCodeList().remove(0);
			}
			getItemCodeText().setText("");
			getSvCodeTable().requestFocusInWindow();
			getSvCodeTable().setSelectedSortedLastRow();
		}
	}

	/**
	 * �u�R�[�h�폜�{�^���̃N���b�N�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void deleteCodeButtonActionPerformed(ActionEvent e)
			throws Exception {
		// ���R�[�h��0���������ꍇ
		// �I������Ă��郌�R�[�h�̉�ʏ�̃C���f�b�N�X
		int sortedRow = getSvCodeTable().getSelectedSortedRow();

		// �I������Ă��郌�R�[�h���폜����B
		getSvCodeList().remove(getSvCodeTable().getSelectedModelRow());

		// �폜���ꂽ�s��1�s���I������B
		getSvCodeTable().setSelectedSortedRowOnAfterDelete(sortedRow);

		// ��ʏ�Ԑ���
		checkState();
	}

	/**
	 * �u�R�[�h�ꗗ�̑I���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void svCodeTableSelectionChanged(ListSelectionEvent e)
			throws Exception {
		// ��ʏ�Ԑ���
		checkState();
	}

	/**
	 * �u�ی��҂̑I���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void insurerNameActionPerformed(ActionEvent e) throws Exception {
		// �ی��҃R���{�N���b�N�̏ꍇ�Ƀ`�F�b�N����B
		if ( e.getModifiers() == MouseEvent.BUTTON1_MASK ){
			// �T�[�r�X�R�[�h�ꗗ�ɒǉ�����Ă�����N���A�m�F���b�Z�[�W��\������B
			if (getSvCodeList().size() != 0 && getInsurerName().getSelectedIndex() != getNowInsurerSelectedIndex()) {
	            int msgID = QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_SVCODELIST();
	            if (msgID == ACMessageBox.RESULT_OK) {
	                // �uOK�v�I�����A�N���A����B
	            	getSvCodeList().clear();
	            	getItemCodeText().setText("");
	            } else {
	                // �u�L�����Z���v�I�����A�ύX�����Ȃ��B
	            	getInsurerName().setSelectedIndex(getNowInsurerSelectedIndex());
	            }
			}
		}
		// �ی��҃R���{�̃C���f�b�N�X��ێ�����B
		setNowInsurerSelectedIndex(getInsurerName().getSelectedIndex());
	}

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QS001_51211_201804.class.getName(),
				param));
	}

	// �����֐�

	/**
	 * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void initialize() throws Exception {
		// ����ʓW�J���̏����ݒ�

		// �e�[�u�����f�������L�̉�ʂ̃e�[�u���ɐݒ肷��B
		ACTableModelAdapter tableModel = new ACTableModelAdapter();

		// �e�[�u�����f�����`
		tableModel.setColumns(new String[] {
				"SERVICE_CODE_KIND+'-'+SERVICE_CODE_ITEM", "SERVICE_NAME",
				"SERVICE_UNIT", "FUTANGAKU", "INSURER_ID" });

		setSvCodeTableModel(tableModel);
		// �e�[�u�����f�����e�[�u���ɃZ�b�g
		getSvCodeTable().setModel(tableModel);

		// ���R���{�A�C�e���̐ݒ�
		// ������
		// �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
		VRMap comboItemMap = new VRHashMap();
		// ���J�n����
		// �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
		// �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
		comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
		// ���I������
		// �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
		// �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
		comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));

		// �ی��҃R���{
		VRList insurerList = QkanCommon.getInsurerInfoCareOnly(getDBManager());
		// �ی��Ҕԍ��𑍍����Ɨp�̃o�C���h�p�X�փR�s�[
		ACBindUtilities.copyBindPath(insurerList, "INSURER_ID",
				String.valueOf(SJ_HOKENSHA_NO_BIND_PATH));
		VRBindPathParser.set("INSURER", comboItemMap, insurerList);

		// ���R���{�A�C�e���̐ݒ�
		// ���g(this)�̃��f���\�[�X�Ƃ���comboItemMap�ɐݒ肷��B
		getThis().setModelSource(comboItemMap);
		// �R���{�A�C�e����W�J����B
		getThis().bindModelSource();

		// �ی��҃R���{�̏����l�ݒ�
		String insurerId = getInitialInsurerId();

		// �擾�����ی��Ҕԍ��ɊY������ی��҂����݂���ꍇ
		VRMap item = (VRMap) getInsurerName().getDataFromBindPath(insurerId);

		// �ی��Җ��R���{�̊Y���ی��҂�I����Ԃɂ���B
		getInsurerName().setSelectedItem(item);

		// �ی��Җ��R���{�̃C���f�b�N�X������������B
		if (getNowInsurerSelectedIndex() < 0) {
			setNowInsurerSelectedIndex(getInsurerName().getSelectedIndex());
		}

		// ��ʏ�Ԑ���
		checkState();
	}

	/**
	 * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void providerSelected(VRMap provider) throws Exception {
		// �����Ə��R���{�ύX���ɌĂԊ֐�

	}

	/**
	 * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public VRMap getValidData() throws Exception {
		// �ی��Җ��̃`�F�b�N
		// �EkaigoInfoInsurerName�i�ی��Җ��j
		// �I������Ă��邩�ǂ���
		if (!getInsurerName().isSelected()) {
			// �I������Ă��Ȃ��ꍇ
			QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
			return null;
		}

		// �o�^�����̃`�F�b�N
		if (getSvCodeList().size() == 0) {
			// �R�[�h���I������Ă��Ȃ��ꍇ
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					"�T�[�r�X�R�[�h");
			return null;
		}

		if ((!getSoACBeginTime().isValidDate())
				|| (!getSoACEndTime().isValidDate())) {
			// �J�n�����R���{�ƏI�������R���{�̂����ꂩ���s���̏ꍇ
			// �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
			QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
			// null��Ԃ��B
			return null;
		}
		// ���ԋp�p�̃��R�[�h(data)�𐶐�
		VRMap data = new VRHashMap();
		// ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
		getThis().setSource(data);
		// ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
		getThis().applySource();

		// ���ԋp�p���R�[�h����s�v�ȃL�[������
		if (ACTextUtilities.isNullText(getSoACBeginTime().getText())) {
			// �J�n�����R���{���󗓂̏ꍇ
			// �ԋp�p���R�[�h����A�J�n�����R���{��bindPath����������B
			data.remove(getSoACBeginTime().getBindPath());
		}
		if (ACTextUtilities.isNullText(getSoACEndTime().getText())) {
			// �I�������R���{���󗓂̏ꍇ
			// �ԋp�p���R�[�h����A�I�������R���{��bindPath����������B
			data.remove(getSoACEndTime().getBindPath());
		}
		// �T�[�r�X�ꗗ�̃f�[�^��ǉ�
		addSvCodeToData(data);

		// ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
		return data;
	}

	/**
	 * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean isUseProvider() throws Exception {
		// �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
		// �@true��Ԃ��B
		return true;
	}

	/**
	 * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public ACComboBox getBeginTimeCombo() throws Exception {
		// ���J�n�������͗p�̃R���{��Ԃ��B
		// �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
		return getSoACBeginTime();
	}

	/**
	 * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public ACComboBox getEndTimeCombo() throws Exception {
		// ���I���������͗p�̃R���{��Ԃ��B
		// �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
		return getSoACEndTime();
	}

	/**
	 * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	protected void checkState() throws Exception {
		if (getSvCodeTable().isSelected()) {
			setState_VALID_EDIT();
		} else {
			setState_INVALID_EDIT();
		}
		if (getSvCodeList().size() >= DOKUJI_TEIRITSU_SVCODE_SELECT_MAX) {
			setState_INVALID_ADD();
		} else {
			setState_VALID_ADD();
		}
	}

}
