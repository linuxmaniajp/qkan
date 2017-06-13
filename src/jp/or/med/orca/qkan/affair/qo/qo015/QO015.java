
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
 * �쐬��: 2016/09/02  ���{�R���s���[�^�[�������  �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑� (O)
 * �v���Z�X �������ƃT�[�r�X�R�[�h�捞 (015)
 * �v���O���� �������ƃT�[�r�X�R�[�h�捞 (QO015)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo015;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.Format;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.filechooser.ACFileChooser;
import jp.nichicom.ac.filechooser.ACFileFilter;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.ac.util.splash.ACSplash;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.io.VRCSVFile;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qo.qo016.QO016;

/**
 * �������ƃT�[�r�X�R�[�h�捞 (QO015)
 */
public class QO015 extends QO015Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO015() {
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
		
		// ��ʂ̏����\�����s������
		// �擾�����f�[�^�̃E�B���h�E�^�C�g���iWINDOW_TITLE�j���E�B���h�E�ɐݒ肷��B
		// �擾�����f�[�^�̋Ɩ��^�C�g���iAFFAIR_TITLE�j���Ɩ��{�^���o�[�ɐݒ肷��B
		VRMap params = affair.getParameters();
		setAffairTitle("QO015", getButtons());

		setM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(new ACPassiveKey("M_SJ_SERVICE_CODE",
				new String[] { "SYSTEM_SERVICE_CODE_ITEM", "TEKIYO_ST_DATE" }, new Format[] {
				ACConstants.FORMAT_SQL_STRING, new ACSQLSafeDateFormat("yyyy-MM-dd") },
				"LAST_TIME", "LAST_TIME"));

		// �e�[�u�����f�������L�̉�ʂ̃e�[�u���ɐݒ肷��B
		ACTableModelAdapter historyInfoTableModel = new ACTableModelAdapter();

		// �e�[�u�����f�����`
		historyInfoTableModel
		.setColumns(new String[] { "INSURER_ID", "INSURER_NAME", "RECORD_CNT", "IMPORT_TIME" });

		// ��`�����e�[�u�����f�����i�[
		setHistoryInfoTableModel(historyInfoTableModel);

		// �e�[�u�����f�����e�[�u���ɃZ�b�g
		getHistoryInfoTable().setModel(getHistoryInfoTableModel());

		// �ڍוҏW��ʂ���߂��Ă����ꍇ�̍ĕ`�揈��
		if( VRBindPathParser.has("QO015_DATA", params) ){
			VRMap memory = (VRMap)VRBindPathParser.get("QO015_DATA", params);
			this.setSource( memory );
			this.bindSource();
			params.removeData("QO015_DATA");
		}

		// DB��背�R�[�h���擾���A��ʂɓW�J����B
		doFind();

		// ����params��null�̏ꍇ�������I������
		if (params == null) {
			return;
		}

		// �n��p�����[�^�[�̒��ɃT�[�r�X�R�[�h����ID�����邩�`�F�b�N����
		if (VRBindPathParser.has("SJ_SERVICE_CODE_HISTORY_ID", params)) {

			// �ڍ׉�ʂőI������Ă����T�[�r�X�R�[�h����ID�ƍ��v���郌�R�[�h��index���擾����B
			int index = ACCommon.getInstance().getMatchIndexFromValue(
					getHistoryInfoList(), "SJ_SERVICE_CODE_HISTORY_ID",
					ACCastUtilities.toInt(params.getData("SJ_SERVICE_CODE_HISTORY_ID"), -1));

			// ��v����
			if (index != -1) {
				// �T�[�r�X�R�[�h����ID��I����Ԃɂ���
				getHistoryInfoTable().setSelectedModelRow(index);
				// �I���T�[�r�X�R�[�h����ID�ɃX�N���[������
				getHistoryInfoTable().scrollSelectedToVisible();
			}
		}

	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u�捞�t�@�C���Q�Ɓv�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void csvFileSelectFileCompareButtonActionPerformed(ActionEvent e)
			throws Exception {
		// �t�@�C���ǂݍ��݃_�C�A���O��\������i�ǂݍ��݃t�@�C����csv�j
		if (csvReader()) {
			// �t�@�C���ǂݍ��݂�true�Ȃ�
			// �X�v���b�V���X�N���[����W�J�\������
			ACSplash splash = null;
			try {
				splash = (ACSplash) ACFrame.getInstance()
						.getFrameEventProcesser()
						.createSplash(MESSAGE_SPLASH_TEXT1);

				// �t�@�C���̏����捞���e����ʂɔ��f������
				if (!setImportInfo()) {
					// false���ԋp���ꂽ��return
					return;
				}

			} finally {
				// �E�F�C�e�B���O�t�H�[�����I������B
				if (splash != null) {
					splash.close();
					splash = null;
				}
			}
		} else {
			// �t�@�C���ǂݍ��݂�false�Ȃ�
			// �������Ȃ�
		}

	}

	/**
	 * �u�捞�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void importButtonActionPerformed(ActionEvent e) throws Exception {
		// �X�v���b�V���X�N���[����W�J�\������
		// �f�[�^�쐬�܂ŃX�v���b�V����\��
		ACSplash splash = null;
		try {
			
			if (!checkControlRecord()) {
				// false���ԋp���ꂽ��return
				return;
			}

			// ��荞�݊m�F���b�Z�[�W
			// �捞�m�F���b�Z�[�W��\������B�����b�Z�[�WID = QO015_WARNING_OF_IMPORT
			int msgID = QkanMessageList.getInstance()
					.QO015_WARNING_OF_IMPORT();
			// ��͂���I����
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// OK�̏ꍇ�A�s�P�ʂ̃f�[�^�`�F�b�N���s��

				// �t�@�C���ǂݍ��ݑO�̕K�v�ϐ�����������
				// outputTable�̏��������s��
				VRList tempList = new VRArrayList();
				setOutputTableList(tempList);

				splash = (ACSplash) ACFrame.getInstance()
				.getFrameEventProcesser()
				.createSplash(MESSAGE_SPLASH_TEXT1);

				// �t�@�C������R���g���[�����R�[�h����͂��ĉ�ʂɔ��f������
				// �t�@�C���ǂݍ��ݑO�̕K�v�ϐ�����������
				if (!controlRecordParser()) {
					// false���ԋp���ꂽ��return
					return;
				}

				splash.setMessage(MESSAGE_SPLASH_TEXT2);
				
				// ���R�[�h���e�[�u���ɔ��f���鏈��
				if (!doSave()) {
					// false���ԋp���ꂽ��return
					return;
				}
				
				// �o�^�������b�Z�[�W��\������B�����b�Z�[�WID = QO015_IMPORT_SUCCESSED
				QkanMessageList.getInstance().QO015_IMPORT_SUCCESSED();
				
				// DB��背�R�[�h���擾���A��ʂɓW�J����B
				doFind();

				break;
				
			case ACMessageBox.RESULT_CANCEL:
				// ��L�����Z����I����
				// �����𔲂���B�i�������s��Ȃ��j
				return;
			}

		} finally {
			// �E�F�C�e�B���O�t�H�[�����I������B
			if (splash != null) {
				splash.close();
				splash = null;
			}
		}
	}


	/**
	 * �u�ҏW�v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void editButtonActionPerformed(ActionEvent e) throws Exception{
		moveQO016();
	}

	/**
	 * �u��ʑJ�ڏ����v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void historyInfoTableMouseClicked(MouseEvent e) throws Exception {
		moveQO016();
	}

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		ACFrame.debugStart(new ACAffairInfo(QO015.class.getName()));
	}

	// �����֐�

	/**
	 * �u���������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void doFind() throws Exception {
		// ��ʓW�J�p�̏����擾���鏈��
		// �ی��ҏ��TABLE�ɑ��݂���A�S�ی��ҏ����擾����B
		doFindHistoryInfo();

		if (!getHistoryInfoList().isEmpty()) {
			// �擾�����S�ی��ҏ��iinsurerInfoList�j��insurerTableModel�ɐݒ肷��B
			getHistoryInfoTableModel().setAdaptee(getHistoryInfoList());

			// insurerInfoTable�̃��R�[�h��1���ȏ�̏ꍇ

		} else {
			// ��񂪎擾�ł��Ȃ������ꍇ
			getHistoryInfoList().clearData();
			getHistoryInfoTableModel().setAdaptee(getHistoryInfoList());

		}

	}

	/**
	 * �u�������ƃT�[�r�X�R�[�h�捞�������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception ������O
	 */
	public void doFindHistoryInfo() throws Exception {
		// �������ƃT�[�r�X�R�[�h�捞���������擾���鏈��
		// �������ƃT�[�r�X�R�[�h�捞���������擾���邽�߂�SQL�����擾����B
		// �擾����SQL�������s����B
		VRList historyInfoList = getDBManager().executeQuery(
				getSQL_GET_M_SJ_SERVICE_CODE_HISTORY_INFO(null));

		// ���R�[�h���擾�ł����ꍇ
		if (!historyInfoList.isEmpty()) {
			// �擾�������R�[�h�z���insurerInfoList�Ɋi�[����B
			setHistoryInfoList(historyInfoList);

		} else {

			historyInfoList.clearData();
			setHistoryInfoList(historyInfoList);

		}

	}
    
	/**
	 * �uCSV�f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean csvReader() throws Exception {
		// ���t�@�C���I������
		ACFileChooser csvFileChooser = new ACFileChooser();
		ACFileFilter csvFilefilter = new ACFileFilter();
		csvFilefilter.setFileExtensions(CSV_FILE_EXTENSIONS);
		csvFilefilter.setDescription("CSV�t�@�C��(*.csv)");

		// �t�@�C���I���_�C�A���O���J���B
		File selectFile = null;
		String defaultPath = "";
		if (ACFrame.getInstance().hasProperty("Claim/Folder")) {
			defaultPath = (new File(getProperty("Claim/Folder")).getParent());
		} else {
			defaultPath = (new File(".").getAbsolutePath());
		}
		selectFile = csvFileChooser.showOpenDialog(defaultPath, "",
				MESSAGE_FILE_OPEN_DIALOG_TITLE, csvFilefilter.getFileExtensions(),
				csvFilefilter.getDescription());

		// �L�����Z�����͒��f
		if (selectFile == null) {
			return false;
		}

		// �擾�����t�@�C������g���q��⊮����
		selectFile = new File(selectFile.getParent(),
				getCSVFilePathWithExtension(selectFile.getName(), 0,
						CSV_FILE_EXTENSIONS));

		// �t�@�C�����݃`�F�b�N
		if (!selectFile.exists()) {
			ACMessageBox.show(ERROR_SELECTED_FILE_NOT_FOUND);
			return false;

		} else {

			// �t�@�C�����I�����ꂽ�ꍇ
			// �I�����ꂽ�t�@�C�������A��ʂ́u�t�@�C����(dbFileSelectFileName)�v�ɐݒ肷��B
			getImportFileSelectFileName().setText(String.valueOf(selectFile));

			// �I�����ꂽ�t�@�C���p�X���Ainputcsvfilepath�ɐݒ肷��B
			setInputCSVFilePath(selectFile.getAbsolutePath());
			// inputcsvfilepath��inputcsvfile�ɐݒ肷��B
			VRCSVFile selectedCSVFile = new VRCSVFile(getInputCSVFilePath());
			setInputCSVFile(selectedCSVFile);
			getInputCSVFile().setEncode(VRCSVFile.MS932);  // ��SJIS�ł͋@��ˑ�������������������
			if (getInputCSVFile().canRead() && getInputCSVFile().isFile()) {
				getInputCSVFile().read(false);

			} else {
				// CSV�t�@�C����read�ł��Ȃ��ꍇ
				ACMessageBox.show(ERROR_CSV_FILE_CAN_NOT_READ);
				return false;
			}

		}

		return true;

	}

	/**
	 * �u���R�[�h��́v���s���A�捞���e�ɏ���\������B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean setImportInfo() throws Exception {
		boolean isHeader = false;
		int item = 0;
		String insurerId = "";
		String insurerName = "";
		// �捞��񃌃R�[�h���[�v�����J�n(�C���f�b�N�X0����getInputCSVFile().getRowCount()�܂�)
		for (int rowIndex = 0; rowIndex < getInputCSVFile().getRowCount(); rowIndex++) {
			item = ACCastUtilities.toInt(getInputCSVFile().getValueAtString(rowIndex,
					COMMON_RECORD_FORMAT_INSURERID),0);
			if (rowIndex == 0) {
				if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex,
						COMMON_RECORD_FORMAT_INSURERID))) {
					if (item == 0) {
						// 1�s�ڂ����l�łȂ��ꍇ�A�w�b�_�[�Ƃ݂Ȃ�
						isHeader = true;
						continue;
					}
				}
			}
			if (item == 0){
				insurerId = "";
				insurerName = "";
				break;
			} else {
				insurerId = getInputCSVFile().getValueAtString(rowIndex,
						COMMON_RECORD_FORMAT_INSURERID);
				// 2016.11.30 �ی��Ҕԍ���1���ڂ�0�̌��͏ȗ������\������
				if (insurerId.length() == 5) {
					insurerId = "0" + insurerId;
		        }
				getInsurerId().setText(
						ACCastUtilities.toString(insurerId, ""));
				// �ی��Җ��̂��擾����
				VRMap insurerMap = new VRHashMap();
				ACBindUtilities.setMapFromArray(QkanCommon.getInsurerInfo(getDBManager()), insurerMap, "INSURER_ID");
				VRMap insureNameMap = (VRMap)insurerMap.get(insurerId);
				if(insureNameMap != null){
					insurerName = ACCastUtilities.toString(insureNameMap.get("INSURER_NAME"), "");
				}
				break;
			}
		}
		
		int recordCnt = getInputCSVFile().getRowCount();
		if (isHeader) {
			recordCnt--;
		}
		getInsurerId().setText(insurerId);
		getInsurerName().setText(insurerName);
		getRecordCnt().setText(ACCastUtilities.toString(recordCnt,""));
		revalidate();
		repaint();

        // true��ԋp����
        return true;
    }

	/**
	 * �捞�\�ȃt�@�C�����`�F�b�N����
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkControlRecord() throws Exception {
		
		// �t�@�C���I���`�F�b�N
		if (getInputCSVFile() == null) {
			ACMessageBox.show(ERROR_FILE_NOT_SELECTED);
			return false;
		}

		// �t�@�C�����݃`�F�b�N
		if (!getInputCSVFile().isFile()) {
			ACMessageBox.show(ERROR_SELECTED_FILE_NOT_FOUND);
			return false;
		}
		
		// �Ǎ��\���ǂ���
		if (!getInputCSVFile().canRead()) {
			// CSV�t�@�C����read�ł��Ȃ��ꍇ
			ACMessageBox.show(ERROR_CSV_FILE_CAN_NOT_READ);
			return false;
		}

		// �Ώۃf�[�^��0���̏ꍇ
		if (getInputCSVFile().getRowCount() < 1) {
			ACMessageBox.show(ERROR_DATA_NOT_FOUND);
			return false;
		}
		
		// �ی��Ҕԍ����擾�ł��Ă��Ȃ��ꍇ
		if (ACTextUtilities.isNullText(getInsurerId().getText())) {
			ACMessageBox.show(ERROR_DATA_NOT_FOUND_INSURERID);
			return false;
		}
		
		// �ی��Ҕԍ����}�X�^�ɑ��݂��Ȃ��ꍇ
		if (ACTextUtilities.isNullText(getInsurerName().getText())) {
			ACMessageBox.show("�ی��Ҕԍ����o�^����Ă��܂���B");
			return false;
		}
		
		// true��ԋp����
		return true;
	}
	
	/**
	 * �u�R���g���[�����R�[�h��́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean controlRecordParser() throws Exception {
		// �T�[�r�X�}�X�^���擾���Ă���
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
		String[] arySonota = new String[] { "X1", "X2", "X3" };

		// �捞��񃌃R�[�h���[�v�����J�n(�C���f�b�N�X0����getInputCSVFile().getRowCount()�܂�)
		for (int rowIndex = 0; rowIndex < getInputCSVFile().getRowCount(); rowIndex++) {
			VRMap dataRecordMap = new VRHashMap();

			int item = ACCastUtilities.toInt(getInputCSVFile().getValueAtString(rowIndex,
					COMMON_RECORD_FORMAT_INSURERID),0);
			if (rowIndex == 0 && item == 0) {
				// 1�s�ڂ����l�łȂ��ꍇ�A�w�b�_�[�Ƃ݂Ȃ�
				continue;
			}
			// �T�[�r�X��ރR�[�h�����l�ȃT�[�r�X�̏ꍇ�X�L�b�v
			String skipServiceCodeKind = ACTextUtilities.trim(getInputCSVFile().getValueAtString(rowIndex, 
					COMMON_RECORD_FORMAT_SERVICE_CODE_KIND));;
			if (!ACTextUtilities.isNullText(skipServiceCodeKind)) {
				if(Arrays.asList(arySonota).contains(skipServiceCodeKind)){
					continue;
				}
			}
			// �����ڐ��̃`�F�b�N
			if (getInputCSVFile().getColumnCount(rowIndex) != CSV_REC_CNT) {
				QkanMessageList.getInstance().QO015_ERROR_OF_IMPORT_ITEM_CNT(
						rowIndex,
						CSV_REC_CNT);
				return false;
			}
			
			String insurerId = "";
			String serviceCodeKind = "";
			String serviceCodeItem = "";
			
			for (int colIndex = 0; colIndex < getInputCSVFile().getRow(rowIndex).size(); colIndex++) {
				
				String field = ACTextUtilities.trim(getInputCSVFile().getValueAtString(rowIndex, colIndex));
			
				switch (colIndex) {
				case 0:
					// ���K�{�`�F�b�N
					// --�؋L�ڕی��Ҕԍ�
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"�؋L�ڕی��Ҕԍ�");
						return false;
					}
					// 2016.11.30 �ی��Ҕԍ���1���ڂ�0�̌��͏ȗ������\������
					if (field.length() == 5) {
						field = "0" + field;
			        }
					insurerId = field;
					dataRecordMap.setData("INSURER_ID", field);
					break;

				case 1:
					// ���K�{�`�F�b�N
					// --�T�[�r�X��ރR�[�h
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"�T�[�r�X��ރR�[�h");
						return false;
					}
					serviceCodeKind = field;
					dataRecordMap.setData("SERVICE_CODE_KIND", field);
					break;

				case 2:
					// ���K�{�`�F�b�N
					// --�T�[�r�X���ڃR�[�h
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"�T�[�r�X���ڃR�[�h");
						return false;
					}
					serviceCodeItem = field;
					dataRecordMap.setData("SERVICE_CODE_ITEM", field);
					break;

				case 3:
					// ���K�{�`�F�b�N
					// --�K�p�J�n�N��
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"�K�p�J�n�N��");
						return false;
					}
					// ���u999999�v�̏ꍇ�́u9999/12/01�v��ݒ�
					Date tekiyoStDt = convYmToDate(field, "ST");
					// ���t�ɕϊ��ł��Ȃ��ꍇ�G���[�Ƃ���
					if (tekiyoStDt == null || !VRDateParser.isValid(VRDateParser.format(tekiyoStDt, "yyyy/MM/dd"))) {
						QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
								rowIndex + 1,
								"���t�ɕϊ��ł��܂���ł����B",
								"�K�p�J�n�N��");
						return false;
					}
					dataRecordMap.setData("TEKIYO_ST_DATE", tekiyoStDt);
					break;

				case 4:
					// ���K�{�`�F�b�N
					// --�K�p�I���N��
					if (ACTextUtilities.isNullText(field)) {
						// 2016.11.30 ���ۂ̕ی��҂�Null�̃P�[�X���������̂őΉ�
						//QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
						//		rowIndex + 1,
						//		"�K�p�I���N��");
						//return false;
						field = "999999";
					}
					// ���u999999�v�̏ꍇ�́u9999/12/31�v��ݒ�
					Date tekiyoEdDt = convYmToDate(field, "ED");
					if (!field.equals("999999")) {
						// ���t�ɕϊ��ł��Ȃ��ꍇ�G���[�Ƃ��� 
						if (tekiyoEdDt == null || !VRDateParser.isValid(VRDateParser.format(tekiyoEdDt, "yyyy/MM/dd"))) {
							QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
									rowIndex + 1,
									"���t�ɕϊ��ł��܂���ł����B",
									"�K�p�I���N��");
							return false;
						}
					}
					dataRecordMap.setData("TEKIYO_ED_DATE", tekiyoEdDt);
					break;

				case 5:
					// ���K�{�`�F�b�N
					// --�T�[�r�X����
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"�T�[�r�X����");
						return false;
					} else {
						if (field.length() > 64) {
							QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
									rowIndex + 1,
									"64���ȓ��Ŏ捞�\�ł��B",
									"�T�[�r�X����");
							return false;
						}
					}
					String convField = convCharacters(field);
					if (convField.length() > 64) {
						convField = convField.substring(0, convField.length());
					}
					dataRecordMap.setData("SERVICE_NAME", convField);
					break;

				case 6:
					// �P�ʐ�
					// �@�O��̔��p�X�y�[�X�̏����i���Ɏ�菜����Ă���j
					// �A�}�C�i�X�����̑ޔ�-->�u00-376�v�ɑΉ����邽��
					// �B�擪�u�O�v�̏���
					// �C�}�C�i�X�����̕���
					String serviceUnit = "";
					if (!ACTextUtilities.isNullText(field)) {
						boolean isMinus = false;
						if (field.indexOf("-") > -1) {
							isMinus = true;
						}
						int d = ACCastUtilities.toInt(field.replace("-", ""), -1);
						if (d > -1) {
							serviceUnit = String.valueOf(d);
							if (isMinus) {
								serviceUnit = "-" + serviceUnit;
							}
						} else {
							// ���l�ɕϊ��ł��Ȃ��ꍇ�A�G���[�Ƃ���
							QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
									rowIndex + 1,
									"���l�ɕϊ��ł��܂���ł����B",
									"�P�ʐ�");
							return false;
						}
					} else {
						// ���K�{�`�F�b�N
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"�P�ʐ�");
						return false;
					}
					dataRecordMap.setData("SERVICE_UNIT", serviceUnit);
					break;

				case 7:
					// �Z��P��
					// �@�O��̔��p�X�y�[�X�̏���
					// �A�擪�u�O�O�v�̕t�� �y�� ���������i�Q���j
					// �B01,02,03,05�ȊO�̏ꍇ�A�󕶎���ɕϊ���
					String santeiTani = "";
					if (!ACTextUtilities.isNullText(field)) {
						santeiTani = String.format("%2s", field).replace(" ", "0");
					} else {
						// ���K�{�`�F�b�N
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"�Z��P��");
						return false;
					}
					String[] arySanteiTani = new String[] { "01", "02", "03", "05" };
					if(!Arrays.asList(arySanteiTani).contains(santeiTani)){
						santeiTani = "";
					}
					dataRecordMap.setData("SANTEI_TANI", santeiTani);
					break;

				case 8:
					// ����������
					// �@�O��̔��p�X�y�[�X�̏���
					// �A�擪�u�O�v�̏���
					// �B�ݒ���e���u�O�v�̏ꍇ�A�󕶎���ɕϊ�
					//  0->"",00->""
					String nissuKaisu = "";
					if (!ACTextUtilities.isNullText(field) && !field.equals("0") && !field.equals("00")) {
						int d = ACCastUtilities.toInt(field, -1);
						if (d > -1) {
							nissuKaisu = String.valueOf(d);
						} else {
							// ���l�ɕϊ��ł��Ȃ��ꍇ�A�G���[�Ƃ���
							QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
									rowIndex + 1,
									"���l�ɕϊ��ł��܂���ł����B",
									"����������");
							return false;
						}
					}
					if (nissuKaisu.length() > 2) {
						QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
								rowIndex + 1,
								"2���ȓ��Ŏ捞�\�ł��B",
								"����������");
						return false;
					}
					dataRecordMap.setData("SEIGEN_NISSU_KAISU", nissuKaisu);
					break;

				case 9:
					// �Z��񐔐�������
					// �@�O��̔��p�X�y�[�X�̏���
					// �A�擪�u�O�O�v�̕t�� �y�� ���������i�Q���j
					// �B01,08,16�ȊO�̏ꍇ�A�󕶎���ɕϊ�
					String santeiKaisuSeigenKikan = "";
					santeiKaisuSeigenKikan = String.format("%2s", field).replace(" ", "0");
					String[] arySanteiSeigen = new String[] { "01", "08", "16" };
					if(!Arrays.asList(arySanteiSeigen).contains(santeiKaisuSeigenKikan)){
						santeiKaisuSeigenKikan = "";
					}
					dataRecordMap.setData("SANTEI_KAISU_SEIGEN_KIKAN", santeiKaisuSeigenKikan);
					break;

				case 10:
					// �x�����x�z�Ώۋ敪
					// �@�u�R�v�ȊO�̏ꍇ�A�󕶎���ɕϊ�
					String shikyuGendogakuTaishoKbn = "";
					if (field.equals("3")) {
						shikyuGendogakuTaishoKbn = field;
					}
					dataRecordMap.setData("SHIKYU_GENDOGAKU_TAISHO_KBN", shikyuGendogakuTaishoKbn);
					break;

				case 11:
					if (field.length() > 10) {
						QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
								rowIndex + 1,
								"10���ȓ��Ŏ捞�\�ł��B",
								"�\������");
						return false;
					}
					dataRecordMap.setData("YOBI", field);
					break;

				case 12:
					// ���t��
					// �@�O��̔��p�X�y�[�X�̏���
					// �A�擪�u�O�v�̏���
					// ���藦�T�[�r�X�ȊO�̏ꍇ�A�󕶎���ɕϊ�
					String kyufuritsu = "";
					String[] aryTeiritsu = new String[] { "A3", "A7", "A9", "AB", "AD" };
					if(Arrays.asList(aryTeiritsu).contains(serviceCodeKind)){
						int d = ACCastUtilities.toInt(field, -1);
						if (!(d > 0 && d <= 100)) {
							QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
									rowIndex + 1,
									"1�`100�Ŏ捞�\�ł��B",
									"���t��");
							return false;
						}
						kyufuritsu = String.valueOf(d);
					} else {
						kyufuritsu = "";
					}
					dataRecordMap.setData("KYUFURITSU", kyufuritsu);
					break;

				case 13:
					// ���p�ҕ��S�z
					// �@�O��̔��p�X�y�[�X�̏���
					// �A�擪�u�O�v�̏���
					// ����z�T�[�r�X�ȊO�̏ꍇ�A�󕶎���ɕϊ�
					//�i���b�W�ł̓}�C�i�X�̕ϊ������Ă��Ȃ����A��S�̍��ڂȂ̂Ń}�C�i�X�̕ϊ����s��
					String futangaku = "";
					String[] aryTeigaku = new String[] { "A4", "A8", "AA", "AC", "AE" };
					if(Arrays.asList(aryTeigaku).contains(serviceCodeKind)){
						if (!ACTextUtilities.isNullText(field)) {
							boolean isMinus = false;
							if (field.indexOf("-") > -1) {
								isMinus = true;
							}
							int d = ACCastUtilities.toInt(field.replace("-", ""), -1);
							if (!(d >= 0 && d <= 999999)) {
								QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
										rowIndex + 1,
										"-999999�`999999�Ŏ捞�\�ł��B",
										"���p�ҕ��S�z");
								return false;
							}
							futangaku = String.valueOf(d);
							if (isMinus) {
								futangaku = "-" + futangaku;
							}
						}
					} else {
						futangaku = "";
					}
					dataRecordMap.setData("FUTANGAKU", futangaku);
					break;

				case 14:
					// ���K�{�`�F�b�N
					// --���ƑΏێҎ��{�敪
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"���ƑΏێҎ��{�敪");
						return false;
					}
					// 1,2�ȊO��2�ɕϊ�
					String[] aryJisshiKbn = new String[] { "1", "2" };
					if(!Arrays.asList(aryJisshiKbn).contains(field)){
						field = "2";
					}
					dataRecordMap.setData("JIGYO_TAISHOSHA_JISSHI_KBN", field);
					break;

				case 15:
					// ���K�{�`�F�b�N
					// --�v�x���P�󋋎Ҏ��{�敪
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"�v�x���P�󋋎Ҏ��{�敪");
						return false;
					}
					// 1,2�ȊO��2�ɕϊ�
					String[] aryYoshien1JisshiKbn = new String[] { "1", "2" };
					if(!Arrays.asList(aryYoshien1JisshiKbn).contains(field)){
						field = "2";
					}
					dataRecordMap.setData("YOSHIEN1_JUKYUSHA_JISSHI_KBN", field);
					break;

				case 16:
					// ���K�{�`�F�b�N
					// --�v�x���Q�󋋎Ҏ��{�敪
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"�v�x���Q�󋋎Ҏ��{�敪");
						return false;
					}
					// 1,2�ȊO��2�ɕϊ�
					String[] aryYoshien2JisshiKbn = new String[] { "1", "2" };
					if(!Arrays.asList(aryYoshien2JisshiKbn).contains(field)){
						field = "2";
					}
					dataRecordMap.setData("YOSHIEN2_JUKYUSHA_JISSHI_KBN", field);
					break;

				case 17:
					// ���K�{�`�F�b�N
					// --���ۘA����ϑ��敪
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"���ۘA����ϑ��敪");
						return false;
					}
					// 1,2�ȊO��1�ɕϊ�
					String[] aryItakuKbn = new String[] { "1", "2" };
					if(!Arrays.asList(aryItakuKbn).contains(field)){
						field = "1";
					}
					dataRecordMap.setData("KOKUHO_ITAKU_KBN", field);
					break;

				case 18:
					// ���K�{�`�F�b�N
					// --�쐬�N����
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"�쐬�N����");
						return false;
					}
					Date sakuseiDt = convYmdToDate(field);
					// ���t�ɕϊ��ł��Ȃ��ꍇ�̓G���[
					if (sakuseiDt == null || !VRDateParser.isValid(VRDateParser.format(sakuseiDt, "yyyy/MM/dd"))) {
						QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
								rowIndex + 1,
								"���t�ɕϊ��ł��܂���ł����B",
								"�쐬�N����");
						return false;
					}
					dataRecordMap.setData("SAKUSEI_DATE", sakuseiDt);
					break;
                    
				default:
				}

			}

			// �V�X�e���T�[�r�X��ރR�[�h���擾����iM_SERVICE�j
			int systemServiceCodeDetail = ACCastUtilities.toInt(mServiceKeyMap.get(serviceCodeKind), 0);
			if (systemServiceCodeDetail == 0) {
				// �擾�ł��Ȃ������ꍇ�A�������͐��l�łȂ��ꍇ�̓G���[�ɂ���
				QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
						rowIndex + 1,
						"�V�X�e���T�[�r�X��ރR�[�h�ɕϊ��ł��܂���ł����B" + ACConstants.LINE_SEPARATOR,
						"�T�[�r�X��ރR�[�h");
				return false;
			}
			dataRecordMap.setData("SYSTEM_SERVICE_KIND_DETAIL", systemServiceCodeDetail);

			// �V�X�e���T�[�r�X���ڃR�[�h��g�ݗ��Ă�
			// �ی��Ҕԍ��{�V�X�e���T�[�r�X��ރR�[�h�{�T�[�r�X���ڃR�[�h
		    StringBuilder sb = new StringBuilder();
		    sb.append(insurerId);
		    sb.append(ACCastUtilities.toString(systemServiceCodeDetail));
		    sb.append(serviceCodeItem);
			dataRecordMap.setData("SYSTEM_SERVICE_CODE_ITEM", sb.toString());
			// 15���łȂ������ꍇ�̓G���[�ɂ���
			if (sb.length() != 15) {
				// �擾�ł��Ȃ������ꍇ�A�������͐��l�łȂ��ꍇ�̓G���[�ɂ���
				QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
						rowIndex + 1,
						"�V�X�e���T�[�r�X���ڃR�[�h�ɕϊ��ł��܂���ł����B" + ACConstants.LINE_SEPARATOR,
						"�ی��Ҕԍ��A�T�[�r�X��ރR�[�h�A�T�[�r�X���ڃR�[�h");
				return false;
			}

			// �s
			dataRecordMap.setData("ROW_INDEX", rowIndex + 1);

			// �폜�t���O
			dataRecordMap.setData("DELETE_FLG", "0");

			if (!dataRecordMap.isEmpty()) {
				getOutputTableList().addData(dataRecordMap);
			}

		}

		return true;
	}

	/**
	 * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean doSave() throws Exception {

		// �������ƃT�[�r�X�R�[�h�}�X�^�̏���DB�ɓo�^����B
		try {
			// �g�����U�N�V�������J�n����B
			getDBManager().beginTransaction();
			
            // �폜�p��SQL�����擾���邽��VRMap�Fparam���쐬���A���L��KEY/VALUE��ݒ肷��B
			VRMap param = new VRHashMap();
			// KEY�FINSURER_ID VALUE�FinsurerId
			param.setData("INSURER_ID", getInsurerId().getText());
			// �폜�p��SQL�����擾����B
			getDBManager().executeUpdate(getSQL_DELETE_M_SJ_SERVICE_CODE(param));
			// outputTableList�̃��R�[�h�𑍍����ƃT�[�r�X�R�[�h�}�X�^���TABLE�ɓo�^����B
			for (int i = 0; i < getOutputTableList().size(); i++) {

				// �p�b�V�u�^�X�N���N���A����B
	            getPassiveChecker().clearPassiveTask();
				// �d���L�[���Z�b�g
				VRMap data = new VRHashMap();
				VRMap item = (VRMap) getOutputTableList().getData(i);
				data.setData("SYSTEM_SERVICE_CODE_ITEM", item.getData("SYSTEM_SERVICE_CODE_ITEM"));
				data.setData("TEKIYO_ST_DATE", (Date) item.getData("TEKIYO_ST_DATE"));

				// �p�b�V�u�^�X�N��ǉ�����B
				getPassiveChecker().addPassiveInsertTask(
						getM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(), data);

				// �p�b�V�u�`�F�b�N�����s����B
				if (!getPassiveChecker().passiveCheck(getDBManager())) {
					//�e�[�u�����b�N�����̂��߃��[���o�b�N
					getDBManager().rollbackTransaction();
					// �p�b�V�u�G���[������ꍇ
					// �G���[���b�Z�[�W��\������B
					String rowIndex = ACCastUtilities.toString(item.getData("ROW_INDEX"), "");
					QkanMessageList.getInstance()
					.QO015_ERROR_OF_PASSIVE_CHECK_ON_INSERT(rowIndex);
					// �����𔲂���B�i�����𒆒f����j
					return false;
				}

				getDBManager()
				.executeUpdate(
						getSQL_INSERT_M_SJ_SERVICE_CODE((VRMap) getOutputTableList()
								.getData(i)));
			}
			
			// SQL���擾�pVRMap sqlParam�𐶐�����B
			VRMap sqlParam = new VRHashMap();
			// ��ʏ�̃f�[�^���擾���AsqlParam�Ɋi�[����B
			getImportContents().setSource(sqlParam);
			getImportContents().applySource();

			// ����������������A�����e�[�u���ɓo�^����B
			getDBManager()
			.executeUpdate(
					getSQL_INSERT_M_SJ_SERVICE_CODE_HISTORY((VRMap) sqlParam));

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

		return true;
	}
	

	/**
	 * �u�������ƃT�[�r�X�R�[�h�ꗗ��ʂɑJ�ځv�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	public void moveQO016() throws Exception {
		// �������ƃT�[�r�X�R�[�h�ꗗ��ʂɑJ�ڂ��鏈��

		// ��ʏ��̑ޔ�
		VRHashMap memory = new VRHashMap();
		this.setSource( memory );
		this.applySource();
		ACFrame.getInstance().addNowAffairParameter("QO015_DATA", memory);

		// VRMap�Fparam�𐶐������L�̃p�����[�^�[���i�[����B
		VRMap param = new VRHashMap();

		// ��ʂ̢�������ƃT�[�r�X�R�[�h�ꗗ����I������Ă����ꍇ�A�ی��Ҕԍ��������p��
		if (getHistoryInfoTable().isSelected()) {
			// �I������Ă����ꍇ
			VRMap rec = (VRMap) getHistoryInfoTable()
					.getSelectedModelRowValue();

			param.setData("INSURER_ID", rec.getData("INSURER_ID"));
			param.setData("SJ_SERVICE_CODE_HISTORY_ID", rec.getData("SJ_SERVICE_CODE_HISTORY_ID"));

	
		} else {
			// �I������Ă��Ȃ��ꍇ�́A�捞���e�̕ی��Ҕԍ��������p��
			param.setData("INSURER_ID", getInsurerId().getText());
		}

		// ����ʑJ�ڂ̂��߂̃p�����[�^�[ACAffairInfo affair���`����B
		ACAffairInfo affair = null;
		affair = new ACAffairInfo(QO016.class.getName(), param);

		// �QO016�i�������ƃT�[�r�X�R�[�h�ꗗ�j��ɑJ�ڂ���B
		ACFrame.getInstance().next(affair);
	}

	/**
	 * CSV�̊g���q�t���t�@�C���t�@�C�������擾���܂��B
	 * 
	 * @param fileName
	 *            �t�@�C����
	 * @param defaultExtension
	 *            �g���q���t���Ă��Ȃ��ꍇ�A�g���q���̉��Ԗڂ̊g���q��t�^���邩
	 * @param extensions
	 *            �g���q���
	 * @return �g���q�t���t�@�C����
	 */
	public String getCSVFilePathWithExtension(String fileName,
			int defaultExtensionIndex, String[] extensions) {
		if (fileName == null) {
			return "";
		}

		int pos = fileName.lastIndexOf('.'); // �Ō�̃s���I�h�ʒu���擾
		if (pos == -1) {
			// �g���q��ǉ����ĕԂ�
			return fileName + "." + extensions[defaultExtensionIndex];
		}

		if ((pos > 0) && (pos < (fileName.length() - 1))) {
			String ext = fileName.substring(pos + 1).toLowerCase(); // �Ō�̃s���I�h����̕�������������ŕԂ�
			for (int i = 0; i < CSV_FILE_EXTENSIONS.length; i++) {
				if (ext.equals(CSV_FILE_EXTENSIONS[i])) {
					return fileName;
				}
			}
			return fileName + "." + extensions[defaultExtensionIndex];
		} else {
			return "";
		}
	}
	
	/**
	 * ������i�N���j����t�^�ɕϊ�����
	 * 
	 * @param field �Ώۂ̕�����
	 * @param mode �J�n�N���� or �I���N����
	 * @return ���t
	 * @throws Exception
	 *             ������O
	 */
	public Date convYmToDate(String field, String mode) throws Exception {
		Date convDate = null;

		if (field.equals("999999")) {
			if (mode == "ED") {
				convDate = ACDateUtilities.createDate(9999, 12, 31);
			}
			return convDate;
		} else if (field.length() == 6) {
			int year = ACCastUtilities.toInt(field.substring(0, 4), 0);
			int month = ACCastUtilities.toInt(field.substring(4, 6), 0);
			convDate = ACDateUtilities.createDate(year, month);
			if (mode == "ED") {
				int lastDay = ACDateUtilities.getLastDayOfMonth(convDate);
				convDate = ACDateUtilities.createDate(year, month, lastDay);
			}
		}
		return convDate;
	}
	
	/**
	 * ������i�N�����j����t�^�ɕϊ�����
	 * 
	 * @param field �Ώۂ̕�����
	 * @return ���t
	 * @throws Exception
	 *             ������O
	 */
	public Date convYmdToDate(String field) throws Exception {
		Date convDate = null;
		
		if (!field.equals("99999999") && field.length() == 8) {
			int year = ACCastUtilities.toInt(field.substring(0, 4));
			int month = ACCastUtilities.toInt(field.substring(4, 6));
			int day = ACCastUtilities.toInt(field.substring(6, 8));
			convDate = ACDateUtilities.createDate(year, month, day);
		}
		return convDate;
	}

	/**
	 * �@��ˑ�������u������
	 * 
	 * @param str �Ώۂ̕�����
	 * @return �u����̕�����
	 * @throws Exception
	 *             ������O
	 */
	public String convCharacters(String str) throws Exception {
		final String[] TARGET_ARRAY = new String[] {
				"�T", "�U", "�V", "�W", "�X", "�Y", "�Z", "�[", "�\", "�]",
				"�@", "�A", "�B", "�C", "�D", "�E", "�F", "�G", "�H", "�I",
				"�@","�A","�B","�C","�D","�E","�F","�G","�H","�I",
				"�J","�K","�L","�M","�N","�O","�P","�Q","�R","�S"
		};
		final String[] REPLACE_ARRAY = new String[] {
				"I", "II", "III", "IV", "V", "VI","VII", "VIII", "IX", "X", 
				"i", "ii", "iii", "iv", "v", "vi","vii", "viii", "ix", "x", 
				"(1)","(2)","(3)","(4)","(5)","(6)","(7)","(8)","(9)","(10)",
				"(11)","(12)","(13)","(14)","(15)","(16)","(17)","(18)","(19)","(20)",
		};

		for (int i = 0; i < TARGET_ARRAY.length; i++ ) {
			str = str.replace(TARGET_ARRAY[i], REPLACE_ARRAY[i]);
		}
		return str;
	}
	
}
