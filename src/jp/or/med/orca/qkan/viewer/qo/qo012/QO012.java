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
 * �쐬��: 2006/04/07  ���{�R���s���[�^�[������� �A�� ��C �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� CSV�r���A�[ (O)
 * �v���Z�X CSV�r���A�[ (012)
 * �v���O���� CSV�r���A�[ (QO012)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.viewer.qo.qo012;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.filechooser.ACFileChooser;
import jp.nichicom.ac.filechooser.ACFileFilter;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.ac.util.splash.ACSplash;
import jp.nichicom.vr.io.VRCSVFile;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * ���t�Ǘ�/����V���� CSV�t�@�C���r���[�A(QO012)
 */
public class QO012 extends QO012Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO012() {
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
		// ��ʂ�W�J����
		getSnapshot().setRootContainer(getContents());

		// DB�ڑ����m�F����
		if (getDBManager().canConnect()) {
			setCanDBConnect(true);
		} else {
			setCanDBConnect(false);
		}
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// ���I������
		// �I���m�F�̃��b�Z�[�W��\������BCSV�r���[�A���I�����Ă���낵���ł����H
		if (ACMessageBox.showOkCancel(MESSAGE_PROGRAM_EXIT) == ACMessageBox.RESULT_OK) {
			// �uOK�v�I����
			// �v���O�������I������B�i��Ղ�true��Ԃ��j
			return true;
		}
		// �u�L�����Z���v�I����
		// �����𒆒f����B(��Ղ�false��Ԃ�)
		return false;
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �uCSV�t�@�C�����J���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void openButtonActionPerformed(ActionEvent e) throws Exception {
		// �t�@�C���ǂݍ��݃_�C�A���O��\������i�ǂݍ��݃t�@�C����csv�j
		if (csvReader()) {
			// �t�@�C���ǂݍ��݂�true�Ȃ�
			// �X�v���b�V���X�N���[����W�J�\������
			// ����f�[�^�쐬�܂ŃX�v���b�V����\��
			ACSplash splash = null;
			try {
				splash = (ACSplash) ACFrame.getInstance().getFrameEventProcesser().createSplash(MESSAGE_SPLASH_TEXT1);

				// �t�@�C���ǂݍ��ݑO�̕K�v�ϐ�����������
				// outputTable�̏��������s��
				VRList tempList = new VRArrayList();
				setOutputTableList(tempList);

				VRList tempList2 = new VRArrayList();
				setTotalInfoTableList(tempList2);

				VRList tempList3 = new VRArrayList();
				setClaimInfoTableList(tempList3);
				
				// �t�@�C������R���g���[�����R�[�h����͂��ĉ�ʂɔ��f������
				if (!controlRecordParser()) {
					// false���ԋp���ꂽ��return
					return;
				}

				splash.setMessage(MESSAGE_SPLASH_TEXT2);
				if (!dataRecordPaser()) {
					return;
				}

				// ���e�[�u��������
				splash.setMessage(MESSAGE_SPLASH_TEXT4);
				if (!totalRecordInfo()) {
					return;
				}

				// ���R�[�h���e�[�u���ɔ��f���鏈��
				dataMapping();
				// false���ԋp���ꂽ��return

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
	 * �uCSV�t�@�C�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void unitingButtonActionPerformed(ActionEvent e) throws Exception {
		// QO012001�N���X(CSV�t�@�C������)�����[�h����
		QO012001 qo012001 = new QO012001();
		qo012001.initAction();
		qo012001.setVisible(true);
	}

	public static void main(String[] args) {
		// // �f�t�H���g�f�o�b�O�N��
		// ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
		// QkanCommon.debugInitialize();
		// VRMap param = new VRHashMap();
		// // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		// ACFrame.debugStart(new ACAffairInfo(QO012.class.getName(), param));
		try {
			ACFrame.setVRLookAndFeel();
			ACFrameEventProcesser processer = new QkanFrameEventProcesser();
			ACFrame.getInstance().setFrameEventProcesser(processer);
			ACFrame.getInstance().next(new ACAffairInfo(QO012.class.getName()));
			ACFrame.getInstance().setTitle(MESSAGE_PROGRAM_TITLE);
			ACFrame.getInstance().setExtendedState(Frame.MAXIMIZED_BOTH);
			ACFrame.getInstance().setVisible(true);
		} catch (Exception ex) {
			VRLogger.info(ex);
		}
	}

	// �����֐�

	/**
	 * �uCSV�f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean csvReader() throws Exception {
		// ���t�@�C���I������
		ACFileChooser csvFileChooser = new ACFileChooser();
		ACFileFilter csvFileFilter = new ACFileFilter();
		csvFileFilter.setFileExtensions(CSV_FILE_EXTENSIONS);
		csvFileFilter.setDescription("CSV�t�@�C��(*.csv)");
		File csvFile;

		// �t�@�C���I���_�C�A���O���J���B(�g���q��csv)
		if (hasProperty("Claim/Folder")) {
			csvFile = csvFileChooser.showOpenDialog(new File(getProperty("Claim/Folder")).getAbsolutePath(), "", MESSAGE_FILE_OPEN_DIALOG_TITLE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
		} else {
			csvFile = csvFileChooser.showOpenDialog(new File(".").getAbsolutePath(), "", MESSAGE_FILE_OPEN_DIALOG_TITLE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
		}

		if (!(csvFile == null)) {
			// �t�@�C�����I�����ꂽ�ꍇ
			// �擾�����t�@�C������g���q��⊮����
			csvFile = new File(csvFile.getParent(), getCSVFilePathWithExtension(csvFile.getName(), 0, CSV_FILE_EXTENSIONS));

			if (!csvFile.exists()) {
				ACMessageBox.show(ERROR_SELECTED_FILE_NOT_FOUND);
				return false;
			}

			// �I�����ꂽ�t�@�C���p�X���Ainputcsvfilepath�ɐݒ肷��B
			setInputCSVFilePath(csvFile.getAbsolutePath());

			// inputcsvfilepath��inputcsvfile�ɐݒ肷��B
			VRCSVFile selectedCSVFile = new VRCSVFile(getInputCSVFilePath());
			setInputCSVFile(selectedCSVFile);
			getInputCSVFile().setEncode(VRCSVFile.SJIS);
			if (getInputCSVFile().canRead() && getInputCSVFile().isFile()) {
				getInputCSVFile().read(false);

			} else {
				// CSV�t�@�C����read�ł��Ȃ��ꍇ
				ACMessageBox.show(ERROR_CSV_FILE_CAN_NOT_READ);
				return false;
			}

			// �������p������B

		} else {
			// �t�@�C�����I������Ȃ������ꍇ
			// �����𒆒f����B
			return false;
		}

		return true;
	}

	/**
	 * �u�R���g���[�����R�[�h��́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean controlRecordParser() throws Exception {
		// CSV�t�@�C���̑��s�ځi�R���g���[�����R�[�h��ǂݏo���āA�ȉ���BINDPATH�Ɋi�[����j
		// �R���g���[�����R�[�h�t�H�[�}�b�g�\��
		// 1.���R�[�h���
		// 2.���R�[�h�ԍ�
		// 3.�{�����[���ʔ�
		// 4.���R�[�h���� �R���g���[���ƃG���h���������f�[�^���R�[�h����
		// 5.�f�[�^��� 711�Ȃ��싋�t��׏�� FILE_TYPE
		// 6.�������Ə�����ԍ� ���Ǝ҂Ȃ�0
		// 7.�ی��Ҕԍ� �ی��҂ł͖����̂�0
		// 8.���Ə��ԍ� PROVIDER_ID DB�擾��PROVIDER_NAME���擾
		// 9.�s���{���ԍ� 2���̓s���{���ԍ�
		// 10.�}�̋敪 1(�`���j 2�iMO�j 3(�l�s) 4(FD) MEDIA_TYPE
		// 11.�����Ώ۔N�� TARGET_MONTH
		// 12.�t�@�C���Ǘ��ԍ�
		if (getInputCSVFile().getRowCount() < 1) {
			ACMessageBox.show(ERROR_DATA_NOT_FOUND);
		}

		List controlRecord = getInputCSVFile().getRow(0);
		// ���R�[�h��ʂ��m�F����
		if (!controlRecord.get(COMMON_RECORD_FORMAT_1_RECORD_TYPE).equals("1")) {
			// ���R�[�h��ʂ�1�ȊO�̏ꍇ
			// �G���[���b�Z�[�W��\������u�R���g���[�����R�[�h�����݂��܂���v
			// false��ԋp����
			ACMessageBox.show(ERROR_CONTROL_RECORD_NOT_FOUND);
			return false;
		}

		// �f�[�^��ʂ��m�F���āA�i�[����

		if (!checkControlRecordDataType(controlRecord.get(CONTROL_RECORD_FORMAT_5_DATA_TYPE))) {
			// �G���[���b�Z�[�W��\������u��싋�t��׏��A���t�Ǘ��[�����i�[����CSV�ł͂���܂���v
			ACMessageBox.show(ERROR_NON_CORRESPONDENCE_DATA_RECORD_TYPE);
			return false;
		}

		// �}�̋敪���m�F���āA�i�[����
		if (!checkControlRecordMediaType(controlRecord.get(CONTROL_RECORD_FORMAT_10_MEDIA_TYPE))) {
			ACMessageBox.show(ERROR_MEDIA_TYPE_NOT_FOUND);
			return false;
		}

		// ���Ə������擾����
		// headerMap��8.���Ə��ԍ��𕶎����BINDPATH PROVIDER_ID�Ɋi�[����
		if (ACTextUtilities.isNullText(controlRecord.get(CONTROL_RECORD_FORMAT_8_PROVIDER_NUMBER))) {
			ACMessageBox.show(ERROR_PROVIDER_NUMBER_NOT_FOUND);
			return false;
		} else {
			getHeaderMap().setData("PROVIDER_ID", controlRecord.get(CONTROL_RECORD_FORMAT_8_PROVIDER_NUMBER));
			// ���Ə��ԍ����猋�ʂ�providerMap�Ɏ擾����
			if (getCanDBConnect()) {
				VRList providerList = getDBManager().executeQuery(getSQL_GET_PROVIDER_INFO(getHeaderMap()));
				if (!providerList.isEmpty()) {
					// providerMap����PROVIDER_NAME���擾���AheaderMap�Ɋi�[����
					setProviderMap((VRMap) providerList.getData(0));
					getHeaderMap().setData("PROVIDER_NAME", getProviderMap().getData("PROVIDER_NAME"));
				} else {
					getHeaderMap().setData("PROVIDER_NAME", PROVIDER_LESS);
				}
			} else {
				getHeaderMap().setData("PROVIDER_NAME", PROVIDER_LESS);
			}
		}

		// �����Ώی����擾����
		// �����Ώی����擾���ADATE�^�Ő�������headerMap��BINDPATH TARGET_MONTH�Ŋi�[����
		if (ACTextUtilities.isNullText(controlRecord.get(CONTROL_RECORD_FORMAT_11_TARGET_YEAR_AND_MONTH))) {
			ACMessageBox.show(ERROR_TARGET_DATE_NOT_FOUND);
			return false;
		} else {
			getHeaderMap().setData("TARGET_MONTH", (ACCastUtilities.toString(controlRecord.get(CONTROL_RECORD_FORMAT_11_TARGET_YEAR_AND_MONTH)) + "01"));
		}
		// true��ԋp����
		return true;
	}

	/**
	 * �u���׊�{��񃌃R�[�h�i�T�[�r�X���Ə��j��́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean dataRecordPaser() throws Exception {
		// �f�[�^���R�[�h����͂��鏈��
		// ����������
		VRList dataRecordList = new VRArrayList();

		// ��{��񃌃R�[�h���[�v�����J�n(�C���f�b�N�X0����getInputCSVFile().getRowCount()�܂�)
		for (int rowIndex = 0; rowIndex < getInputCSVFile().getRowCount(); rowIndex++) {
			VRMap dataRecordMap = new VRHashMap();
			// �擾����CSV�s(List�Ŏ擾)��1�Ԗڂ�2�i�f�[�^���R�[�h�j�ł��邩�H
			if (!(getInputCSVFile().getValueAtString(rowIndex, COMMON_RECORD_FORMAT_1_RECORD_TYPE).equals("2"))) {
				// �Ⴄ�ꍇ
				// ���[�v���X�L�b�v����
				continue;
			}

			// ���݂���̂��O��ɂȂ邪�A�O�ׂ̈��當���`�F�b�N�����Ă���
			// �������ʏ��̊m�F
			String exchangeType = getInputCSVFile().getValueAtString(rowIndex, COMMON_RECORD_FORMAT_3_EXCHANGE_TYPE);

			if (exchangeType.equals("7131")) {
				// 7131 �l����2
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("7132")) {
				// 7132 �l����2-2
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("7143")) {
				// 7143 �l����3
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("7144")) {
				// 7144 �l����4
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			// 2008/03/27 [Masahiko_Higuchi] edit - begin ����20�N�x4���@�����Ή��i���×{�^�V�l�ی��{�݁j
			} else if (exchangeType.equals("7153")||exchangeType.equals("7155")) {
				// 7153 �l����4
            // 2008/03/27 [Masahiko_Higuchi] edit - end
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
            // 2008/03/27 [Masahiko_Higuchi] edit - begin ����20�N�x4���@�����Ή��i���×{�^�V�l�ی��{�݁j
			} else if (exchangeType.equals("7154")||exchangeType.equals("7156")) {
            // 2008/03/27 [Masahiko_Higuchi] edit - end
				// 7154 �l����4-2
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("7164")) {
				// 7164 �l����5
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("7165")) {
				// 7165 �l����5-2
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("7171")) {
				// 7171 �l����6
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("7172")) {
				// 7172 �l����6-2
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("7173")) {
				// 7173 �l����6-3
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("7174")) {
				// 7174 �l����6-4
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("7175")) {
				// 7175 �l����6-5
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("7176")) {
				// 7175 �l����6-6
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("7183")) {
				// 7183 �l����8
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
            // 2008/03/27 [Masahiko_Higuchi] edit - begin ����20�N�x4���@�����Ή��i���×{�^�V�l�ی��{�݁j
			} else if (exchangeType.equals("7193")||exchangeType.equals("7194")) {
            // 2008/03/27 [Masahiko_Higuchi] edit - end
				// 7193 �l����9
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("71A3")) {
				// 7193 �l����10
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("8122")) {
				// 8122 �l����7
				if (!dataRecord812Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("8123")) {
				// 8123 �l����7-2
				if (!dataRecord812Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
				
			//[ID:0000448][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
			} else if (exchangeType.equals("8124")) {
				// 8124 H21.4�ȍ~�@�l����7
				if (!dataRecord812ParserH2104(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("8125")) {
				// 8125 H21.4�ȍ~ �l����7-2
				if (!dataRecord812ParserH2104(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			//[ID:0000448][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
				
			} else if (exchangeType.equals("8222")) {
				// 8123 �l����11(���t�Ǘ��\���)
				if (!dataRecord822Parser(rowIndex, dataRecordMap)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else if (exchangeType.equals("7111")) {
				// 7111 �l����1
				if (!dataRecord7111Parser(rowIndex)) {
					// �p�[�T�����s���āA��͂ɖ�肪�L�����ꍇ�̓X�L�b�v����
					continue;
				}
			} else {
				// �������ʔԍ����Y�����Ȃ��ꍇ(4���ȑO�̌������ʔԍ��̓X�L�b�v����)
				continue;
			}

			if (!dataRecordMap.isEmpty()) {
				// dataRecordList�ɒǉ�����B
				dataRecordList.addData(dataRecordMap);
			}
		}

//		// outputTable�̏��������s��
//		VRList tempList = new VRArrayList();
//		setOutputTableList(tempList);

		// �f�[�^���R�[�h�̌����������s��
		if (!dataRecordMerge(dataRecordList)) {
			return false;
		}

		return true;
	}

	/**
	 * �u��ʓW�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void dataMapping() throws Exception {

		// �㕔���R�[�h��񕔕���bind����
		getFileInfoGroup().setSource(getHeaderMap());
		getFileInfoGroup().bindSource();

		// csvDataTable���ȉ��̃t�B�[���h�Őݒ肷��B
		// YEAR_AND_MONTH
		// INSURED_ID
		// NAME
		// CARE_LEVEL
		// 11
		// 12
		// 13
		// 14
		// 15
		// 16
		// 17
		// 21
		// 22
		// 23
		// 31
		// 32
		// 33
		// 36
		// 38
		// 51
		// 52
		// 53
		// 54
		// 71
		// 72
		// 73
		// 43
		// UNIT_TOTAL

		String[] csvDataTableSchema = new String[45];
		csvDataTableSchema[0] = "YEAR_AND_MONTH";
		csvDataTableSchema[1] = "INSURED_ID";
		csvDataTableSchema[2] = "NAME";
		csvDataTableSchema[3] = "CARE_LEVEL";
		csvDataTableSchema[4] = "11";
		csvDataTableSchema[5] = "12";
		csvDataTableSchema[6] = "13";
		csvDataTableSchema[7] = "14";
		csvDataTableSchema[8] = "15";
		csvDataTableSchema[9] = "16";
		csvDataTableSchema[10] = "17";
		csvDataTableSchema[11] = "21";
		csvDataTableSchema[12] = "22";
		csvDataTableSchema[13] = "23";
		csvDataTableSchema[14] = "31";
		csvDataTableSchema[15] = "32";
		csvDataTableSchema[16] = "33";
		csvDataTableSchema[17] = "36";
		csvDataTableSchema[18] = "38";
		csvDataTableSchema[19] = "51";
		csvDataTableSchema[20] = "52";
		csvDataTableSchema[21] = "53";
		csvDataTableSchema[22] = "54";
		csvDataTableSchema[23] = "71";
		csvDataTableSchema[24] = "72";
		csvDataTableSchema[25] = "73";
		csvDataTableSchema[26] = "43";
		csvDataTableSchema[27] = "61";
		csvDataTableSchema[28] = "62";
		csvDataTableSchema[29] = "63";
		csvDataTableSchema[30] = "64";
		csvDataTableSchema[31] = "65";
		csvDataTableSchema[32] = "66";
		csvDataTableSchema[33] = "67";
		csvDataTableSchema[34] = "24";
		csvDataTableSchema[35] = "25";
		csvDataTableSchema[36] = "26";
		csvDataTableSchema[37] = "34";
		csvDataTableSchema[38] = "35";
		csvDataTableSchema[39] = "46";
		csvDataTableSchema[40] = "74";
		csvDataTableSchema[41] = "75";
		csvDataTableSchema[42] = "37";
		csvDataTableSchema[43] = "39";
		csvDataTableSchema[44] = "UNIT_TOTAL";

		// �i�[
		ACTableModelAdapter csvDataTableModel = new ACTableModelAdapter();
		csvDataTableModel.setColumns(csvDataTableSchema);

		// csvDataTable��csvDataTableModel���Z�b�g����
		getCsvDataTable().setModel(csvDataTableModel);

		// ���f���Ƀf�[�^���Z�b�g����
		csvDataTableModel.setAdaptee(getOutputTableList());

		// �㕔�W�v���p�e�[�u��
		String[] totalInfoDataTableSchema = new String[6];
		totalInfoDataTableSchema[0] = "TOTAL1";
		totalInfoDataTableSchema[1] = "TOTAL2";
		totalInfoDataTableSchema[2] = "TOTAL3";
		totalInfoDataTableSchema[3] = "TOTAL4";
		totalInfoDataTableSchema[4] = "TOTAL5";
		totalInfoDataTableSchema[5] = "TOTAL6";

		// �e�[�u�����f���A�_�v�^����
		ACTableModelAdapter totalInfoDataTableModel = new ACTableModelAdapter();
		totalInfoDataTableModel.setColumns(totalInfoDataTableSchema);

		getTotalInfoTable().setModel(totalInfoDataTableModel);
		totalInfoDataTableModel.setAdaptee(getTotalInfoTableList());

	}

	/**
	 * �u���o�����e�[�u���pList��W�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean totalRecordInfo() throws Exception {
		// ����������
		VRList initList = new VRArrayList();
		setTotalInfoTableList(initList);

		// �N�����W�v�̊�b�ɂȂ�A���N���x���擾����
		VRList yearIndexDataList = new VRArrayList();
		Iterator outputTableListIterator = getOutputTableList().iterator();
		while (outputTableListIterator.hasNext()) {
			VRMap outputTableMap = (VRMap) outputTableListIterator.next();

			// �L�[�𒊏o
			VRMap dataIndexMap = new VRHashMap();
			dataIndexMap.setData("YEAR_AND_MONTH", outputTableMap.getData("YEAR_AND_MONTH"));
			yearIndexDataList.add(dataIndexMap);
		}

		// ���R�[�h�����j�[�N�ɓZ�߂�
		Set uniqueSet = new HashSet();
		uniqueSet.addAll(yearIndexDataList);

		// outputTableList����Iterator�ŏ㕔�e�[�u���̔N���W�v����Z�߂�
		Iterator uniqueSetIterator = uniqueSet.iterator();
		while (uniqueSetIterator.hasNext()) {
			VRMap claimYearAndMonth = (VRMap) uniqueSetIterator.next();
			VRMap totalMap = new VRHashMap();

			List annualTotalList = ACBindUtilities.getMatchListFromValue(getOutputTableList(), "YEAR_AND_MONTH", claimYearAndMonth.getData("YEAR_AND_MONTH"));

			if ((ACBindUtilities.getMatchListFromValue((VRList) annualTotalList, "MANAGEMENT_FLAG", ON).size()) <= 0) {

				List claimList = ACBindUtilities.getMatchListFromValue(getClaimInfoTableList(), "YEAR_AND_MONTH", claimYearAndMonth.getData("YEAR_AND_MONTH"));

				int claimUnit = 0;
				int claimAmount = 0;
				Iterator claimListIterator = claimList.iterator();
				while (claimListIterator.hasNext()) {
					VRMap claimTotalData = (VRMap) claimListIterator.next();

					// �N�����擾
					totalMap.setData("TOTAL1", claimTotalData.getData("YEAR_AND_MONTH"));

					if ("01".equals(claimTotalData.getData("CLAIM_STATUS"))) {
						// �T�[�r�X�������擾
						totalMap.setData("TOTAL3", ACCastUtilities.toInteger(ACBindUtilities.getMatchListFromValue((VRList) annualTotalList, "SERVICE_FLAG", ON).size()));
					} else {
						// PLAN_FLAG�Œ��o���A�v�����������擾
						totalMap.setData("TOTAL4", ACCastUtilities.toInteger(ACBindUtilities.getMatchListFromValue((VRList) annualTotalList, "PLAN_FLAG", ON).size()));
					}

					claimUnit = claimUnit + ACCastUtilities.toInt(claimTotalData.getData("CLAIM_UNIT"));
					claimAmount = claimAmount + ACCastUtilities.toInt(claimTotalData.getData("CLAIM_AMOUNT"));
				}

				// �������擾(�����̓��R�[�h�̌�������)
				totalMap.setData("TOTAL2", ACCastUtilities.toInteger(annualTotalList.size()));

				// �ȑO��7111���g��Ȃ����R�[�h�W�v�^�̍��v�v�Z���W�b�N
				// ���v�v�Z
				// int totalUnitCount = 0;
				// int totalInsuranceCount = 0;
				// Iterator splitDataIter = annualTotalList.iterator();
				// while (splitDataIter.hasNext()) {
				// VRMap annualDetailData = (VRMap) splitDataIter.next();
				// totalUnitCount = totalUnitCount + ACCastUtilities.toInt(annualDetailData.getData("UNIT_TOTAL"));
				// totalInsuranceCount = totalInsuranceCount + ACCastUtilities.toInt(annualDetailData.getData("INSURANCE_AMOUNT"));
				// }

				// �N���ʒP�ʐ����v���擾
				totalMap.setData("TOTAL5", ACCastUtilities.toInteger(claimUnit));
				// �N���ʕی������z���v���擾
				totalMap.setData("TOTAL6", ACCastUtilities.toInteger(claimAmount));

				// ���t�Ǘ��[��ǂݍ��񂾌�̏ꍇ�͔�\���ɂȂ��Ă���̂ŕ\����
				getTotalInfoTableColumn3().setVisible(true);
				getTotalInfoTableColumn4().setVisible(true);
				getTotalInfoTableColumn5().setVisible(true);
				getTotalInfoTableColumn6().setVisible(true);
				// �����񒲐�
				getTotalInfoTableColumn2().setColumns(10);
				
			} else {
				// ���t�Ǘ��\�̏ꍇ
				totalMap.setData("TOTAL1", claimYearAndMonth.getData("YEAR_AND_MONTH"));
				// �������擾
				totalMap.setData("TOTAL2", ACCastUtilities.toInteger(annualTotalList.size()));
				
				// �\�����Ȃ��������\����
				getTotalInfoTableColumn3().setVisible(false);
				getTotalInfoTableColumn4().setVisible(false);
				getTotalInfoTableColumn5().setVisible(false);
				getTotalInfoTableColumn6().setVisible(false);
			}
			
			// �W�v���e�[�u�����X�g�ɉ�����
			getTotalInfoTableList().add(totalMap);

		}

		return true;
	}

	/**
	 * �u�R���g���[���f�[�^�̎�ʔ���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkControlRecordDataType(Object dataType) throws Exception {
		if (ACTextUtilities.isNullText(dataType)) {
			return false;
		}
		switch (ACCastUtilities.toInt(dataType)) {
			case 711:
				// �f�[�^��ʂ�711�̏ꍇ
				// headerMap�ɕ�����"��싋�t��׏����" BINDPATH FILE_TYPE�Ŋi�[����
				// ���̂܂܌p������
				getHeaderMap().setData("FILE_TYPE", CSV_FILE_TYPE_711);
				break;
			case 812:
				// �f�[�^��ʂ�812�̏ꍇ
				// headerMap�ɕ�����"��싋�t������׏��i����T�[�r�X�v���j���" BINDPATH FILE_TYPE�Ŋi�[����
				// ���̂܂܌p������
				getHeaderMap().setData("FILE_TYPE", CSV_FILE_TYPE_812);
				break;
			case 821:
				// �f�[�^��ʂ�821�̏ꍇ
				// headerMap�ɕ�����"��싋�t������׏��i����T�[�r�X�v���j���" BINDPATH FILE_TYPE�Ŋi�[����
				// ���̂܂܌p������
				getHeaderMap().setData("FILE_TYPE", CSV_FILE_TYPE_821);
				break;
			default:
				// �f�[�^��ʂ������ȊO�̏ꍇ
				// false��ԋp����
				return false;
		}

		return true;
	}

	/**
	 * �u�}�̎�ʂ̎�ʔ���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkControlRecordMediaType(Object mediaType) throws Exception {
		if (ACTextUtilities.isNullText(mediaType)) {
			return false;
		}
		switch (ACCastUtilities.toInt(mediaType)) {
			case 1:
				// �}�̋敪��1�̏ꍇ
				// headerMap�ɕ�����"�`��"��BINDPATH MEDIA_TYPE�Ŋi�[����
				getHeaderMap().setData("MEDIA_TYPE", MEDIA_TYPE1);
				break;
			case 2:
				// �}�̋敪��2�̏ꍇ
				// headerMap�ɕ�����"MO"��BINDPATH MEDIA_TYPE�Ŋi�[����
				getHeaderMap().setData("MEDIA_TYPE", MEDIA_TYPE2);
				break;
			case 3:
				// �}�̋敪��3�̏ꍇ
				// headerMap�ɕ�����"MT"��BINDPATH MEDIA_TYPE�Ŋi�[����
				getHeaderMap().setData("MEDIA_TYPE", MEDIA_TYPE3);
				break;
			case 4:
				// �}�̋敪��4�̏ꍇ
				// headerMap�ɕ�����"FD"��BINDPATH MEDIA_TYPE�Ŋi�[����
				getHeaderMap().setData("MEDIA_TYPE", MEDIA_TYPE4);
				break;
			default:
				// �}�̋敪�������ȊO�̏ꍇ
				return false;
		}
		return true;
	}

	/**
	 * �u�v���x�`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public String checkCareLevel(String careLevelCode) throws Exception {
		String careLevel = new String();
		if (ACTextUtilities.isNullText(careLevelCode)) {
			return "";
		}

		switch (ACCastUtilities.toInt(careLevelCode)) {
			case 11:
				careLevel = NURSING_NECESSARY_LEVEL11;
				break;

			case 12:
				careLevel = NURSING_NECESSARY_LEVEL12;
				break;

			case 13:
				careLevel = NURSING_NECESSARY_LEVEL13;
				break;

			case 21:
				careLevel = NURSING_NECESSARY_LEVEL21;
				break;

			case 22:
				careLevel = NURSING_NECESSARY_LEVEL22;
				break;

			case 23:
				careLevel = NURSING_NECESSARY_LEVEL23;
				break;

			case 24:
				careLevel = NURSING_NECESSARY_LEVEL24;
				break;

			case 25:
				careLevel = NURSING_NECESSARY_LEVEL25;
				break;

			default:
				careLevel = NURSING_NECESSARY_LEVEL01;
				break;
		}
		return careLevel;
	}

	/**
	 * �u71�n�������ʏ���{��́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean dataRecord711Parser(int rowIndex, VRMap returnDataMap) throws Exception {
		// 711�n��{���p�[�T
		if (ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, DATA_RECORD_FORMAT_711TYPE_2_RECORD_TYPE_CODE))) {
			return false;
		}

		// ���R�[�h�^�C�v����
		int recordType = getInputCSVFile().getValueAtInteger(rowIndex, DATA_RECORD_FORMAT_711TYPE_2_RECORD_TYPE_CODE);
		switch (recordType) {
			case 1:
				// ���R�[�h�^�C�v1�i��{���j
				if (!dataType711Paser01(rowIndex, returnDataMap)) {
					return false;
				}
				break;

			case 2:
				// ���R�[�h�^�C�v2�i���׏��j
				if (!dataType711Paser02(rowIndex, returnDataMap)) {
					return false;
				}
				break;

			case 4:
				// ���R�[�h�^�C�v4(����f�Ô�)
				if (!dataType711Paser04(rowIndex, returnDataMap)) {
					return false;
				}
				break;

			case 10:
				// ���R�[�h�^�C�v10�i�W�v���j
				if (!dataType711Paser10(rowIndex, returnDataMap)) {
					return false;
				}
				break;

			default:
				// ����ȊO�̏ꍇ
				break;
		}
		return true;
	}

	/**
	 * �u711�n��{��񃌃R�[�h�̉�́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean dataType711Paser01(int rowIndex, VRMap returnDataMap) throws Exception {

		// returnDataMap��9.��ی��Ҕԍ�INSURED_ID��6.�T�[�r�X�񋟔N��YEAR_AND_MONTH���i�[����B
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH))) {
			returnDataMap.setData("YEAR_AND_MONTH", ACCastUtilities.toDate(getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH) + "01"));
		} else {
			return false;
		}

		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_6_INSURED_ID))) {
			returnDataMap.setData("INSURED_ID", getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_6_INSURED_ID));
		} else {
			return false;
		}

		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_15_CARE_LEVEL))) {
			// 18.�v���x��ԋ敪�R�[�h���擾����returnDataMap��BIND PATH CARE_LEVEL�Ŋi�[����
			returnDataMap.setData("CARE_LEVEL", checkCareLevel(getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_15_CARE_LEVEL)));
		} else {
			return false;
		}

		// ��ی��Ҕԍ����痘�p�Җ����擾����A�擾�����l��BIND PATH NAME�Ŋi�[����
		// SQL�p�����[�^
		// 6.��ی��Ҕԍ�
		// 20.�F��L�����ԊJ�n�N����
		// 21.�F��L�����ԏI���N����

		VRMap sqlParam = new VRHashMap();
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_17_INSURED_START_DATE))) {
			// StartDate
			sqlParam.setData("START_DATE", ACCastUtilities.toDate(getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_17_INSURED_START_DATE)));
		} else {
			return false;
		}

		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_18_INSURED_END_DATE))) {
			// EndDate
			sqlParam.setData("END_DATE", ACCastUtilities.toDate(getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_18_INSURED_END_DATE)));
		} else {
			return false;
		}

		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_6_INSURED_ID))) {
			// INSURED_ID
			sqlParam.setData("INSURED_ID", getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_6_INSURED_ID));
		} else {
			return false;
		}

		if (getCanDBConnect()) {
			VRList patientList = getDBManager().executeQuery(getSQL_GET_PATIENT_INFO(sqlParam));
			if (!patientList.isEmpty()) {
				VRMap patientMap = (VRMap) patientList.getData(0);
				// �ԋp���ꂽPATIENT_FIRST_NAME��PATIENT_FAMILY_NAME���Ԃ��X�y�[�X�ŋ�؂茋������NAME�Ɋi�[����
				String patientName = ACCastUtilities.toString(patientMap.getData("PATIENT_FAMILY_NAME")) + " " + ACCastUtilities.toString(patientMap.getData("PATIENT_FIRST_NAME"));
				returnDataMap.setData("NAME", patientName);
			} else {
				returnDataMap.setData("NAME", NAME_LESS);
			}
		} else {
			returnDataMap.setData("NAME", NAME_LESS);
		}

		// �W�v�p�Ɉ�ӂ̃L�[���쐬���Ċi�[����
		String dataIndexStr = getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_6_INSURED_ID) + getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH);
		returnDataMap.setData("DATA_INDEX", dataIndexStr);

		return true;
	}

	/**
	 * �u711�n���׏�񃌃R�[�h�̉�́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean dataType711Paser02(int rowIndex, VRMap returnDataMap) throws Exception {
		// ���ʔԍ�02 ���׏��

		// �T�[�r�X��ʂ��m�F����
		// 10.�T�[�r�X��ރR�[�h��BIND_PATH�Ƃ��ăt���O1���i�[����B
		// ���̂����t�H�[�}�b�^������
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, DETAIL_RECORD_7_SERVICE_TYPE_CODE))) {
			returnDataMap.setData(getInputCSVFile().getValueAtString(rowIndex, DETAIL_RECORD_7_SERVICE_TYPE_CODE), MATRIX_ON);
			// �W�v�J�E���g�p�t���O���i�[����
			returnDataMap.setData("SERVICE_FLAG", ON);
		} else {
			return false;
		}

		// �W�v�p�Ɉ�ӂ̃L�[���쐬���Ċi�[����
		String dataIndexStr = getInputCSVFile().getValueAtString(rowIndex, DETAIL_RECORD_6_INSURED_ID) + getInputCSVFile().getValueAtString(rowIndex, DETAIL_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH);
		returnDataMap.setData("DATA_INDEX", dataIndexStr);
		return true;
	}

	/**
	 * �u711�n����f�Ô�R�[�h�̉�́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean dataType711Paser04(int rowIndex, VRMap returnDataMap) throws Exception {
		// ���ʔԍ�04 ���׏��

		if (getInputCSVFile().getValueAtString(rowIndex, SPECIAL_CLINIC_RECORD_7_SEQUENCE_CODE).equals("99")) {
			returnDataMap.setData("UNIT_TOTAL", ACCastUtilities.toInteger(getInputCSVFile().getValueAtInteger(rowIndex, SPECIAL_CLINIC_RECORD_13_UNIT_TOTAL)));
		} else {
			return false;
		}

		// �W�v�p�Ɉ�ӂ̃L�[���쐬���Ċi�[����
		String dataIndexStr = getInputCSVFile().getValueAtString(rowIndex, SPECIAL_CLINIC_RECORD_6_INSURED_ID) + getInputCSVFile().getValueAtString(rowIndex, SPECIAL_CLINIC_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH);
		returnDataMap.setData("DATA_INDEX", dataIndexStr);
		return true;
	}

	/**
	 * �u711�n�W�v��񃌃R�[�h�̉�́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean dataType711Paser10(int rowIndex, VRMap returnDataMap) throws Exception {
		// 9.��ی��Ҕԍ���outputTableMap��INSURED_ID����v����Ȃ�
		// 10.�T�[�r�X��ރR�[�h��BIND_PATH�Ƃ��ăt���O1���i�[����B
		// �P�ʐ����擾����
		returnDataMap.setData("UNIT_TOTAL", ACCastUtilities.toInteger(getInputCSVFile().getValueAtInteger(rowIndex, TOTAL_RECORD_14_UNIT_TOTAL)));

		// �ی��Ώې����z���擾����
		returnDataMap.setData("INSURANCE_AMOUNT", ACCastUtilities.toInteger(getInputCSVFile().getValueAtInteger(rowIndex, TOTAL_RECORD_16_AMOUNT_TOTAL)));
		// System.out.println(insuranceTotal);

		// �W�v�p�Ɉ�ӂ̃L�[���쐬���Ċi�[����
		String dataIndexStr = getInputCSVFile().getValueAtString(rowIndex, TOTAL_RECORD_6_INSURED_ID) + getInputCSVFile().getValueAtString(rowIndex, TOTAL_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH);
		returnDataMap.setData("DATA_INDEX", dataIndexStr);
		return true;
	}

	/**
	 * �u7111�n�l����ꃌ�R�[�h�̉�́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean dataRecord7111Parser(int rowIndex) throws Exception {
		
		if (!"1".equals(getInputCSVFile().getValueAtString(rowIndex, CLAIM_RECORD_4_CARE_OR_PUBLIC_EXPENCE_ID))) {
			// �ی����݂̂��܂߂�
			return false;
		}

		// �������i�[�pMAP�𐶐�����B
		VRMap claimMap = new VRHashMap();

		// �T�[�r�X�񋟔N�����擾����
		claimMap.setData("YEAR_AND_MONTH", ACCastUtilities.toDate(getInputCSVFile().getValueAtString(rowIndex, CLAIM_RECORD_2_SERVICE_PROVIDE_YEAR_AND_MONTH) + "01"));

		// �������敪���擾����
		claimMap.setData("CLAIM_STATUS", getInputCSVFile().getValueAtString(rowIndex, CLAIM_RECORD_6_CLAIM_STATUS));

		// �������擾����
		claimMap.setData("CLAIM_COUNTS", getInputCSVFile().getValueAtString(rowIndex, CLAIM_RECORD_7_TOTAL_COUNTS));

		// �P�ʐ����擾����
		claimMap.setData("CLAIM_UNIT", getInputCSVFile().getValueAtString(rowIndex, CLAIM_RECORD_8_TOTAL_UNITS));

		// �ی������z���擾����
		claimMap.setData("CLAIM_AMOUNT", getInputCSVFile().getValueAtString(rowIndex, CLAIM_RECORD_10_TOTAL_AMOUNT));

		getClaimInfoTableList().add(claimMap);
		return true;
	}

	/**
	 * �u812�n�������ʏ���{��́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean dataRecord812Parser(int rowIndex, VRMap returnDataMap) throws Exception {
		// returnDataMap��9.��ی��Ҕԍ�INSURED_ID��6.�T�[�r�X�񋟔N��YEAR_AND_MONTH���i�[����B
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_4_SERVICE_PROVIDE_YEAR_AND_MONTH))) {
			returnDataMap.setData("YEAR_AND_MONTH", ACCastUtilities.toDate(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_4_SERVICE_PROVIDE_YEAR_AND_MONTH) + "01"));
		} else {
			return false;
		}

		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_7_INSURED_ID))) {
			returnDataMap.setData("INSURED_ID", getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_7_INSURED_ID));
		} else {
			return false;
		}

		// 18.�v���x��ԋ敪�R�[�h���擾����returnDataMap��BIND PATH CARE_LEVEL�Ŋi�[����
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_12_CARE_LEVEL))) {
			returnDataMap.setData("CARE_LEVEL", checkCareLevel(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_12_CARE_LEVEL)));
		} else {
			return false;
		}

		// ��ی��Ҕԍ����痘�p�Җ����擾����A�擾�����l��BIND PATH NAME�Ŋi�[����
		// SQL�p�����[�^
		// 6.��ی��Ҕԍ�
		// 20.�F��L�����ԊJ�n�N����
		// 21.�F��L�����ԏI���N����

		VRMap sqlParam = new VRHashMap();
		// StartDate
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_13_INSURED_START_DATE))) {
			sqlParam.setData("START_DATE", ACCastUtilities.toDate(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_13_INSURED_START_DATE)));
		}

		// EndDate
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_14_INSURED_END_DATE))) {
			sqlParam.setData("END_DATE", ACCastUtilities.toDate(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_14_INSURED_END_DATE)));
		}

		// INSURED_ID
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_7_INSURED_ID))) {
			sqlParam.setData("INSURED_ID", getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_7_INSURED_ID));
		}

		if (getCanDBConnect()) {
			VRList patientList = getDBManager().executeQuery(getSQL_GET_PATIENT_INFO(sqlParam));

			if (!patientList.isEmpty()) {
				VRMap patientMap = (VRMap) patientList.getData(0);
				// �ԋp���ꂽPATIENT_FIRST_NAME��PATIENT_FAMILY_NAME���Ԃ��X�y�[�X�ŋ�؂茋������NAME�Ɋi�[����
				String patientName = ACCastUtilities.toString(patientMap.getData("PATIENT_FAMILY_NAME")) + " " + ACCastUtilities.toString(patientMap.getData("PATIENT_FIRST_NAME"));
				returnDataMap.setData("NAME", patientName);
			} else {
				returnDataMap.setData("NAME", NAME_LESS);
			}
		} else {
			returnDataMap.setData("NAME", NAME_LESS);
		}

		// ��ی��Ҕԍ���outputTableMap��INSURED_ID����v����Ȃ�
		
		// �������ʔԍ��𒲂ׂ�
		if (getInputCSVFile().getValueAtString(rowIndex, COMMON_RECORD_FORMAT_3_EXCHANGE_TYPE).equals("8122")) {
			// ���̏ꍇ
			// 43(�v����)��BIND_PATH�Ƃ��ăt���O1���i�[����B
			returnDataMap.setData("43", MATRIX_ON);
			// �W�v�J�E���g�p�t���O���i�[����
			returnDataMap.setData("PLAN_FLAG", ON);		
		} else if(getInputCSVFile().getValueAtString(rowIndex, COMMON_RECORD_FORMAT_3_EXCHANGE_TYPE).equals("8123")) {
			// �\�h�̏ꍇ
			// 46(�v����)��BIND_PATH�Ƃ��ăt���O1���i�[����B
			returnDataMap.setData("46", MATRIX_ON);
			// �W�v�J�E���g�p�t���O���i�[����
			returnDataMap.setData("PLAN_FLAG", ON);
		}
		
		// �P�ʐ����擾����
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_17_UNIT_TOTAL))) {
			returnDataMap.setData("UNIT_TOTAL", ACCastUtilities.toInteger(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_17_UNIT_TOTAL)));
		} else {
			return false;
		}

		// �ی��Ώې����z���擾����
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_19_AMOUNT_TOTAL))) {
			returnDataMap.setData("INSURANCE_AMOUNT", ACCastUtilities.toInteger(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_19_AMOUNT_TOTAL)));
		} else {
			return false;
		}

		// �W�v�p�Ɉ�ӂ̃L�[���쐬���Ċi�[����
		String dataIndexStr = getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_7_INSURED_ID) + getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_4_SERVICE_PROVIDE_YEAR_AND_MONTH);
		returnDataMap.setData("DATA_INDEX", dataIndexStr);

		return true;
	}

	//[ID:0000448][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
	/**
	 * H21.4�ȍ~�́u812�n�������ʏ���{��́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean dataRecord812ParserH2104(int rowIndex, VRMap returnDataMap) throws Exception {
		// returnDataMap��9.��ی��Ҕԍ�INSURED_ID��6.�T�[�r�X�񋟔N��YEAR_AND_MONTH���i�[����B
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_4_SERVICE_PROVIDE_YEAR_AND_MONTH))) {
			returnDataMap.setData("YEAR_AND_MONTH", ACCastUtilities.toDate(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_4_SERVICE_PROVIDE_YEAR_AND_MONTH) + "01"));
		} else {
			return false;
		}

		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_7_INSURED_ID))) {
			returnDataMap.setData("INSURED_ID", getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_7_INSURED_ID));
		} else {
			return false;
		}

		// 18.�v���x��ԋ敪�R�[�h���擾����returnDataMap��BIND PATH CARE_LEVEL�Ŋi�[����
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_12_CARE_LEVEL))) {
			returnDataMap.setData("CARE_LEVEL", checkCareLevel(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_12_CARE_LEVEL)));
		} else {
			return false;
		}

		// ��ی��Ҕԍ����痘�p�Җ����擾����A�擾�����l��BIND PATH NAME�Ŋi�[����
		// SQL�p�����[�^
		// 6.��ی��Ҕԍ�
		// 20.�F��L�����ԊJ�n�N����
		// 21.�F��L�����ԏI���N����

		VRMap sqlParam = new VRHashMap();
		// StartDate
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_13_INSURED_START_DATE))) {
			sqlParam.setData("START_DATE", ACCastUtilities.toDate(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_13_INSURED_START_DATE)));
		}

		// EndDate
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_14_INSURED_END_DATE))) {
			sqlParam.setData("END_DATE", ACCastUtilities.toDate(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_14_INSURED_END_DATE)));
		}

		// INSURED_ID
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_7_INSURED_ID))) {
			sqlParam.setData("INSURED_ID", getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_7_INSURED_ID));
		}

		if (getCanDBConnect()) {
			VRList patientList = getDBManager().executeQuery(getSQL_GET_PATIENT_INFO(sqlParam));

			if (!patientList.isEmpty()) {
				VRMap patientMap = (VRMap) patientList.getData(0);
				// �ԋp���ꂽPATIENT_FIRST_NAME��PATIENT_FAMILY_NAME���Ԃ��X�y�[�X�ŋ�؂茋������NAME�Ɋi�[����
				String patientName = ACCastUtilities.toString(patientMap.getData("PATIENT_FAMILY_NAME")) + " " + ACCastUtilities.toString(patientMap.getData("PATIENT_FIRST_NAME"));
				returnDataMap.setData("NAME", patientName);
			} else {
				returnDataMap.setData("NAME", NAME_LESS);
			}
		} else {
			returnDataMap.setData("NAME", NAME_LESS);
		}

		// ��ی��Ҕԍ���outputTableMap��INSURED_ID����v����Ȃ�
		
		// �������ʔԍ��𒲂ׂ�
		if (getInputCSVFile().getValueAtString(rowIndex, COMMON_RECORD_FORMAT_3_EXCHANGE_TYPE).equals("8124")) {
			// ���̏ꍇ
			// 43(�v����)��BIND_PATH�Ƃ��ăt���O1���i�[����B
			returnDataMap.setData("43", MATRIX_ON);
			// �W�v�J�E���g�p�t���O���i�[����
			returnDataMap.setData("PLAN_FLAG", ON);		
		} else if(getInputCSVFile().getValueAtString(rowIndex, COMMON_RECORD_FORMAT_3_EXCHANGE_TYPE).equals("8125")) {
			// �\�h�̏ꍇ
			// 46(�v����)��BIND_PATH�Ƃ��ăt���O1���i�[����B
			returnDataMap.setData("46", MATRIX_ON);
			// �W�v�J�E���g�p�t���O���i�[����
			returnDataMap.setData("PLAN_FLAG", ON);
		}
		
		// �P�ʐ����擾����
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_21_UNIT_TOTAL))) {
			returnDataMap.setData("UNIT_TOTAL", ACCastUtilities.toInteger(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_21_UNIT_TOTAL)));
		} else {
			return false;
		}

		// �ی��Ώې����z���擾����
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_22_AMOUNT_TOTAL))) {
			returnDataMap.setData("INSURANCE_AMOUNT", ACCastUtilities.toInteger(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_22_AMOUNT_TOTAL)));
		} else {
			return false;
		}

		// �W�v�p�Ɉ�ӂ̃L�[���쐬���Ċi�[����
		String dataIndexStr = getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_7_INSURED_ID) + getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_4_SERVICE_PROVIDE_YEAR_AND_MONTH);
		returnDataMap.setData("DATA_INDEX", dataIndexStr);

		return true;
	}
	//[ID:0000448][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
	
	
	/**
	 * �u822�n�������ʏ���{��́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean dataRecord822Parser(int rowIndex, VRMap returnDataMap) throws Exception {
		// returnDataMap��9.��ی��Ҕԍ�INSURED_ID��6.�T�[�r�X�񋟔N��YEAR_AND_MONTH���i�[����B
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_2_SERVICE_PROVIDE_YEAR_AND_MONTH))) {
			returnDataMap.setData("YEAR_AND_MONTH", ACCastUtilities.toDate(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_2_SERVICE_PROVIDE_YEAR_AND_MONTH) + "01"));
		} else {
			return false;
		}

		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_10_INSURED_ID))) {
			returnDataMap.setData("INSURED_ID", getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_10_INSURED_ID));
		} else {
			return false;
		}

		// 18.�v���x��ԋ敪�R�[�h���擾����returnDataMap��BIND PATH CARE_LEVEL�Ŋi�[����
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_12_CARE_LEVEL))) {
			returnDataMap.setData("CARE_LEVEL", checkCareLevel(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_12_CARE_LEVEL)));
		} else {
			return false;
		}

		// ��ی��Ҕԍ����痘�p�Җ����擾����A�擾�����l��BIND PATH NAME�Ŋi�[����
		// SQL�p�����[�^
		// 6.��ی��Ҕԍ�
		// 20.�F��L�����ԊJ�n�N����
		// 21.�F��L�����ԏI���N����

		VRMap sqlParam = new VRHashMap();

		// INSURED_ID
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_10_INSURED_ID))) {
			sqlParam.setData("INSURED_ID", getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_10_INSURED_ID));
		}

		if (getCanDBConnect()) {
			VRList patientList = getDBManager().executeQuery(getSQL_GET_PATIENT_INFO_MANAGEMENT(sqlParam));

			if (!patientList.isEmpty()) {
				VRMap patientMap = (VRMap) patientList.getData(0);
				// �ԋp���ꂽPATIENT_FIRST_NAME��PATIENT_FAMILY_NAME���Ԃ��X�y�[�X�ŋ�؂茋������NAME�Ɋi�[����
				String patientName = ACCastUtilities.toString(patientMap.getData("PATIENT_FAMILY_NAME")) + " " + ACCastUtilities.toString(patientMap.getData("PATIENT_FIRST_NAME"));
				returnDataMap.setData("NAME", patientName);
			} else {
				returnDataMap.setData("NAME", NAME_LESS);
			}
		} else {
			returnDataMap.setData("NAME", NAME_LESS);
		}

		// ��ی��Ҕԍ���outputTableMap��INSURED_ID����v����Ȃ�
		// 43(�v����)��BIND_PATH�Ƃ��ăt���O1���i�[����B
		// ���̂����t�H�[�}�b�^������

		// 10.�T�[�r�X��ރR�[�h��BIND_PATH�Ƃ��ăt���O1���i�[����B
		// ���̂����t�H�[�}�b�^������
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_19_SERVICE_TYPE_CODE))) {
			returnDataMap.setData(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_19_SERVICE_TYPE_CODE), MATRIX_ON);
		} else {
			return false;
		}

		// �W�v�J�E���g�p�t���O���i�[����
		returnDataMap.setData("MANAGEMENT_FLAG", ON);

		// �P�ʐ����擾����
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_20_UNIT_TOTAL))) {
			returnDataMap.setData("UNIT_TOTAL", ACCastUtilities.toInteger(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_20_UNIT_TOTAL)));
		} else {
			return false;
		}

		// �W�v�p�Ɉ�ӂ̃L�[���쐬���Ċi�[����
		String dataIndexStr = getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_10_INSURED_ID) + getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_2_SERVICE_PROVIDE_YEAR_AND_MONTH);
		returnDataMap.setData("DATA_INDEX", dataIndexStr);

		return true;
	}

	/**
	 * �u��͂����s�f�[�^�̌��������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean dataRecordMerge(VRList dataRecordList) throws Exception {
		VRList keyIndexDataList = new VRArrayList();
		Iterator dataRecordIterator = dataRecordList.iterator();
		while (dataRecordIterator.hasNext()) {
			VRMap dataRecordMap = (VRMap) dataRecordIterator.next();

			// �L�[�𒊏o
			VRMap dataIndexMap = new VRHashMap();
			dataIndexMap.setData("DATA_INDEX", dataRecordMap.getData("DATA_INDEX"));
			keyIndexDataList.add(dataIndexMap);
		}

		// ���R�[�h�����j�[�N�ɓZ�߂�
		Set uniqueSet = new HashSet();
		uniqueSet.addAll(keyIndexDataList);

		Iterator uniqueSetIterator = uniqueSet.iterator();
		while (uniqueSetIterator.hasNext()) {
			VRMap dataIndex = (VRMap) uniqueSetIterator.next();
			List indexMatchList = ACBindUtilities.getMatchListFromValue(dataRecordList, "DATA_INDEX", dataIndex.getData("DATA_INDEX"));

			VRMap outputMap = new VRHashMap();
			int totalUnits = 0;
			int totalInsurance = 0;
			Iterator indexMatchListIterator = indexMatchList.iterator();
			while (indexMatchListIterator.hasNext()) {
				VRMap dataMatchMap = (VRMap) indexMatchListIterator.next();
				if (outputMap.containsKey("UNIT_TOTAL") && dataMatchMap.containsKey("UNIT_TOTAL")) {
					totalUnits = ACCastUtilities.toInt(outputMap.getData("UNIT_TOTAL")) + ACCastUtilities.toInt(dataMatchMap.getData("UNIT_TOTAL"));
					outputMap.setData("UNIT_TOTAL", ACCastUtilities.toInteger(totalUnits));
					dataMatchMap.removeData("UNIT_TOTAL");
				}

				if (outputMap.containsKey("INSURANCE_AMOUNT") && dataMatchMap.containsKey("INSURANCE_AMOUNT")) {
					totalInsurance = ACCastUtilities.toInt(outputMap.getData("INSURANCE_AMOUNT")) + ACCastUtilities.toInt(dataMatchMap.getData("INSURANCE_AMOUNT"));
					outputMap.setData("INSURANCE_AMOUNT", ACCastUtilities.toInteger(totalInsurance));
					dataMatchMap.removeData("INSURANCE_AMOUNT");
				}
				outputMap.putAll(dataMatchMap);
			}
			// ���ʂ�\���p���X�g�ɕԂ�
			getOutputTableList().addData(outputMap);
		}
		return true;
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
	public String getCSVFilePathWithExtension(String fileName, int defaultExtensionIndex, String[] extensions) {
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
}
