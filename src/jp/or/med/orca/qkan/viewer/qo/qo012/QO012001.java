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
 * �쐬��: 2006/04/11  ���{�R���s���[�^�[������� �A�� ��C �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� CSV�r���[�A (O)
 * �v���Z�X CSV�r���[�A (012)
 * �v���O���� CSV������� (QO012001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.viewer.qo.qo012;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.filechooser.ACFileChooser;
import jp.nichicom.ac.filechooser.ACFileFilter;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.io.VRCSVFile;
import jp.or.med.orca.qkan.viewer.QkanCSVViewerCSVFile;

/**
 * CSV�������(QO012001)
 */
public class QO012001 extends QO012001Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO012001() {
	}

	/**
	 * �������������s�Ȃ��܂��B
	 * 
	 * @param affair
	 *            �Ɩ����
	 * @throws Exception
	 *             ������O
	 */
	public void initAction() throws Exception {
		// ��ʂ�W�J����
		getSnapshot().setRootContainer(getContents());
		setWindowTitle(MESSAGE_WINDOW_TITLE);

        
        // �ݒ肵���t�@�C���p�X
        if (ACFrame.getInstance().hasProperty("Claim/Folder")) {
           setLastOpenDir(new File(getProperty("Claim/Folder")).getAbsolutePath());
        } else {
           setLastOpenDir(new File(".").getAbsolutePath());
        }
        
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �uCSV�t�@�C���������I���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void closeButtonActionPerformed(ActionEvent e) throws Exception {
		// ���I������
		// �_�C�A���O��j�����܂�
		dispose();
	}

	/**
	 * �uCSV�t�@�C�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void unitButtonActionPerformed(ActionEvent e) throws Exception {
		// CSV�t�@�C���̌�������
		// �o�͐�̃t�@�C���p�X�A�e�L�X�g�{�b�N�X�����O�Ɋm�F����B

		if (ACTextUtilities.isNullText(getFile1Text().getText())) {
			ACMessageBox.show(MESSAGE_PLEASE_SELECT_CSV_FILE);
			return;
		}

		if (ACTextUtilities.isNullText(getFile2Text().getText())) {
			ACMessageBox.show(MESSAGE_PLEASE_SELECT_CSV_FILE);
			return;
		}

		if (ACTextUtilities.isNullText(getFile3Text().getText())) {
			ACMessageBox.show(ERROR_OUTPUT_FOLDER_EMPTY);
			return;
		}

		// ���t�Ǘ��[��񌋍�����
		if (recordUniting()) {
			ACMessageBox.show(MESSAGE_CSV_UNITING_OVER);
		} else {
			return;
		}
	}

	/**
	 * �uCSV1�t�@�C���_�C�A���O�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void file1ButtonActionPerformed(ActionEvent e) throws Exception {
		// CSV1�t�@�C���_�C�A���O��W�J����
		// ���t�@�C���I������
		ACFileChooser csvFileChooser = new ACFileChooser();
		ACFileFilter csvFileFilter = new ACFileFilter();
		csvFileFilter.setFileExtensions(new String[] { "csv" });
		csvFileFilter.setDescription("CSV�t�@�C��(*.csv)");
		File csvFile;
		getFile1Text().setText("");
		getFile1InfoText().setText("");

		// �t�@�C���I���_�C�A���O���J���B(�g���q��csv)
		csvFile = csvFileChooser.showOpenDialog(getLastOpenDir(), "", MESSAGE_PLEASE_SELECT_CSV_FILE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
//        if (ACFrame.getInstance().hasProperty("Claim/Folder")) {
//            csvFile = csvFileChooser.showOpenDialog(new File(getProperty("Claim/Folder")).getAbsolutePath(), "", MESSAGE_PLEASE_SELECT_CSV_FILE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
//        } else {
//            csvFile = csvFileChooser.showOpenDialog(new File(".").getAbsolutePath(), "", MESSAGE_PLEASE_SELECT_CSV_FILE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
//        }

		if (!(csvFile == null)) {

			// �t�@�C�����I�����ꂽ�ꍇ
			// �擾�����t�@�C������g���q��⊮����
			csvFile = new File(csvFile.getParent(), getCSVFilePathWithExtension(csvFile.getName(), 0, CSV_FILE_EXTENSIONS));

			if (!csvFile.exists()) {
				ACMessageBox.show(ERROR_FILE_NOT_FOUND);
				return;
			}

			VRCSVFile selectedCSVFile = new VRCSVFile(csvFile.getAbsolutePath());
			setInputCSVFile1(selectedCSVFile);
			getInputCSVFile1().setEncode(VRCSVFile.SJIS);

			if (getInputCSVFile1().canRead()) {

				// CSV�t�@�C������������ɓW�J����
				getInputCSVFile1().read(false);

				// �f�[�^�`�F�b�N
				if (getInputCSVFile1().getRowCount() < 1) {
					ACMessageBox.show(ERROR_DATA_NOT_FOUND);
					return;
				}

				List controlRecord = getInputCSVFile1().getRow(0);
				// ���R�[�h��ʂ��m�F����
				if (!controlRecord.get(0).equals("1")) {
					// ���R�[�h��ʂ�1�ȊO�̏ꍇ
					// �G���[���b�Z�[�W��\������u�R���g���[�����R�[�h�����݂��܂���v
					// false��ԋp����
					ACMessageBox.show(ERROR_CONTROL_RECORD_NOT_FOUND);
					return;
				}

				// �f�[�^��ʂ��m�F���āA�i�[����
				if (!checkControlRecordDataType(controlRecord.get(4), getFile1InfoText())) {
					// �G���[���b�Z�[�W��\������u��싋�t��׏��A���t�Ǘ��[�����i�[����CSV�ł͂���܂���v
					ACMessageBox.show(ERROR_NON_CORRESPONDENCE_DATA_RECORD_TYPE);
					return;
				}

				// �t�@�C���p�X���e�L�X�g�{�b�N�X�ɔ��f����
				getFile1Text().setText(getInputCSVFile1().getPath());

                if(csvFile.getParentFile()!=null){
                    setLastOpenDir(csvFile.getParentFile().getAbsolutePath());
                }
			} else {
				// CSV�t�@�C����read�ł��Ȃ��ꍇ
				ACMessageBox.show(ERROR_CAN_NOT_READ_CSV);
				return;
			}

		} else {
			// �t�@�C�����I������Ȃ������ꍇ
			// �����𒆒f����B
		}
		return;
	}

	/**
	 * �uCSV2�t�@�C���_�C�A���O�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void file2ButtonActionPerformed(ActionEvent e) throws Exception {
		// CSV1�t�@�C���_�C�A���O��W�J����
		// ���t�@�C���I������
		ACFileChooser csvFileChooser = new ACFileChooser();
		ACFileFilter csvFileFilter = new ACFileFilter();
		csvFileFilter.setFileExtensions(new String[] { "csv" });
		csvFileFilter.setDescription("CSV�t�@�C��(*.csv)");
		File csvFile;
		getFile2Text().setText("");
		getFile2InfoText().setText("");

		// �t�@�C���I���_�C�A���O���J���B(�g���q��csv)
        
        csvFile = csvFileChooser.showOpenDialog(getLastOpenDir(), "", MESSAGE_PLEASE_SELECT_CSV_FILE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
//		if (ACFrame.getInstance().hasProperty("Claim/Folder")) {
//			csvFile = csvFileChooser.showOpenDialog(new File(getProperty("Claim/Folder")).getAbsolutePath(), "", MESSAGE_PLEASE_SELECT_CSV_FILE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
//		} else {
//			csvFile = csvFileChooser.showOpenDialog(new File(".").getAbsolutePath(), "", MESSAGE_PLEASE_SELECT_CSV_FILE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
//		}
		if (!(csvFile == null)) {

			// �t�@�C�����I�����ꂽ�ꍇ
			// �擾�����t�@�C������g���q��⊮����
			csvFile = new File(csvFile.getParent(), getCSVFilePathWithExtension(csvFile.getName(), 0, CSV_FILE_EXTENSIONS));

			if (!csvFile.exists()) {
				ACMessageBox.show(ERROR_FILE_NOT_FOUND);
				return;
			}

			VRCSVFile selectedCSVFile = new VRCSVFile(csvFile.getAbsolutePath());
			setInputCSVFile2(selectedCSVFile);
			getInputCSVFile2().setEncode(VRCSVFile.SJIS);

			if (getInputCSVFile2().canRead() && getInputCSVFile2().isFile()) {

				// CSV�t�@�C�����̓���"k"��t������FileText4�ɃZ�b�g����B
				String outputFileName = "k" + csvFile.getName().toString();
				getFile4Text().setText(outputFileName);

				// CSV����������ɓW�J����
				getInputCSVFile2().read(false);

				// �f�[�^�`�F�b�N
				if (getInputCSVFile2().getRowCount() < 1) {
					ACMessageBox.show(ERROR_DATA_NOT_FOUND);
					return;
				}

				List controlRecord = getInputCSVFile2().getRow(0);
				// ���R�[�h��ʂ��m�F����
				if (!controlRecord.get(0).equals("1")) {
					// ���R�[�h��ʂ�1�ȊO�̏ꍇ
					// �G���[���b�Z�[�W��\������u�R���g���[�����R�[�h�����݂��܂���v
					// false��ԋp����
					ACMessageBox.show(ERROR_CONTROL_RECORD_NOT_FOUND);
					return;
				}

				// �f�[�^��ʂ��m�F���āA�i�[����
				if (!checkControlRecordDataType(controlRecord.get(4), getFile2InfoText())) {
					// �G���[���b�Z�[�W��\������
					ACMessageBox.show(ERROR_NON_CORRESPONDENCE_DATA_RECORD_TYPE);
					return;
				}

				// �t�@�C���p�X���e�L�X�g�{�b�N�X�ɔ��f����
				getFile2Text().setText(getInputCSVFile2().getPath());

                if(csvFile.getParentFile()!=null){
                    setLastOpenDir(csvFile.getParentFile().getAbsolutePath());
                }
			} else {
				// CSV�t�@�C����read�ł��Ȃ��ꍇ
				ACMessageBox.show(ERROR_CAN_NOT_READ_CSV);
				return;
			}

		} else {
			// �t�@�C�����I������Ȃ������ꍇ
			// �����𒆒f����B
		}
		return;
	}

	/**
	 * �uCSV3�t�@�C���_�C�A���O�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void file3ButtonActionPerformed(ActionEvent e) throws Exception {
		// CSV3�t�@�C���_�C�A���O��W�J����
		// ���t�@�C���I������
		ACFileChooser csvFolderChooser = new ACFileChooser();
		File outputFolder;
		getFile3Text().setText("");

		// �t�@�C���I���_�C�A���O���J���B(�g���q��csv)
        outputFolder = csvFolderChooser.showDirectorySelectDaialog(MESSAGE_PLEASE_CSV_OUTPUT_FOLDER, getLastOpenDir());
//		if (ACFrame.getInstance().hasProperty("Claim/Folder")) {
//			outputFolder = csvFolderChooser.showDirectorySelectDaialog(MESSAGE_PLEASE_CSV_OUTPUT_FOLDER, new File(getProperty("Claim/Folder")).getAbsolutePath());
//		} else {
//			outputFolder = csvFolderChooser.showDirectorySelectDaialog(MESSAGE_PLEASE_CSV_OUTPUT_FOLDER, new File(".").getAbsolutePath());
//		}
		if (!(outputFolder == null)) {
			if (!(outputFolder.isDirectory()) || outputFolder.isFile() || !(outputFolder.exists())) {
				ACMessageBox.show(ERROR_CAN_NOT_OUTPUT_SELECTED_FOLDER);
				return;
			}
			// �t�@�C���p�X���e�L�X�g�{�b�N�X�ɔ��f����
			getFile3Text().setText(outputFolder.getAbsolutePath());

            setLastOpenDir(outputFolder.getAbsolutePath());
		}
	}

	/**
	 * �u�R���g���[���f�[�^�̎�ʔ���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean checkControlRecordDataType(Object dataType, ACTextField returnField) throws Exception {
		if (ACTextUtilities.isNullText(dataType)) {
			return false;
		}
        //[H27.4 �����Ή�][Shinobu Hitaka] 2016/07/13 edit begin �������ƑΉ�
        //�f�[�^��ʂ͉p�����ł��邽�߁Aswitch-case��p�~
		//switch (ACCastUtilities.toInt(dataType)) {
		//	case 711:
		//		// �f�[�^��ʂ�711�̏ꍇ
		//		// ���̂܂܌p������
		//		returnField.setText(CSV_FILE_TYPE_711);
		//		break;
		//
		//	case 812:
		//		// �f�[�^��ʂ�812�̏ꍇ
		//		// ���̂܂܌p������
		//		returnField.setText(CSV_FILE_TYPE_812);
		//		break;
		//
		//	case 821:
		//		// �f�[�^��ʂ�821�̏ꍇ
		//		// ���̂܂܌p������
		//		returnField.setText(CSV_FILE_TYPE_821);.
		//		break;
		//
		//	default:
		//		// �f�[�^��ʂ������ȊO�̏ꍇ
		//		// false��ԋp����
		//		return false;
		//}
        if (dataType.equals("711")) {
			// �f�[�^��ʂ�711�̏ꍇ
			// ���̂܂܌p������
			returnField.setText(CSV_FILE_TYPE_711);
        } else if (dataType.equals("812")) {
			// �f�[�^��ʂ�812�̏ꍇ
			// ���̂܂܌p������
			returnField.setText(CSV_FILE_TYPE_812);
        } else if (dataType.equals("821")) {
			// �f�[�^��ʂ�821�̏ꍇ
			// ���̂܂܌p������
			returnField.setText(CSV_FILE_TYPE_821);
        } else if (dataType.equals("71R")) {
			// �f�[�^��ʂ�71R�̏ꍇ
			// ���̂܂܌p������
			returnField.setText(CSV_FILE_TYPE_71R);
        } else {
            // �f�[�^��ʂ������ȊO�̏ꍇ
            // false��ԋp����
            return false;
        }
        //[H27.4 �����Ή�][Shinobu Hitaka] 2016/07/13 edit end

		return true;
	}

	/**
	 * �u���������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean recordUniting() throws Exception {
		// �K�{���R�[�h�`�F�b�N
		if (ACTextUtilities.isNullText(getInputCSVFile1().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_5_DATA_TYPE))) {
			ACMessageBox.show(ERROR_CONTROL_RECORD_NOT_FOUND);
			return false;
		}
		if (ACTextUtilities.isNullText(getInputCSVFile2().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_5_DATA_TYPE))) {
			ACMessageBox.show(ERROR_CONTROL_RECORD_NOT_FOUND);
			return false;
		}
		if (ACTextUtilities.isNullText(getInputCSVFile1().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_11_TARGET_YEAR_AND_MONTH))) {
			ACMessageBox.show(ERROR_CONTROL_RECORD_NOT_FOUND);
			return false;
		}
		if (ACTextUtilities.isNullText(getInputCSVFile2().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_11_TARGET_YEAR_AND_MONTH))) {
			ACMessageBox.show(ERROR_CONTROL_RECORD_NOT_FOUND);
			return false;
		}
		if (ACTextUtilities.isNullText(getInputCSVFile1().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_4_RECORD_COUNT))) {
			ACMessageBox.show(ERROR_CONTROL_RECORD_NOT_FOUND);
			return false;
		}
		if (ACTextUtilities.isNullText(getInputCSVFile2().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_4_RECORD_COUNT))) {
			ACMessageBox.show(ERROR_CONTROL_RECORD_NOT_FOUND);
			return false;
		}

		// �^�[�Q�b�g���X�g������������(ArrayList)
		ArrayList targetList = new ArrayList();

		// �������ʔԍ��`�F�b�N�i�ǂ���̃t�@�C���̎��ʔԍ�������̕��݂̂���������j
		if (!(getInputCSVFile1().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_5_DATA_TYPE).equals(getInputCSVFile2().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_5_DATA_TYPE)))) {
			ACMessageBox.show(ERROR_NOT_SAME_FILE_DATA_TYPE);
			return false;
		}

		// �O�̈׃R���g���[�����R�[�h��null�`�F�b�N�����Ă���
		if (!ACTextUtilities.isNullText(getInputCSVFile1().getRow(0))) {
			// ��̃R���g���[�����R�[�h���擾���āA��r����B�����Ώ۔N�����Ⴄ�ꍇ�͏R��
			if (!(getInputCSVFile1().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_11_TARGET_YEAR_AND_MONTH).equals(getInputCSVFile2().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_11_TARGET_YEAR_AND_MONTH)))) {
				ACMessageBox.show(ERROR_NOT_SAME_TARGET_DATE);
				return false;
			}

			// �R���g���[�����R�[�h(List)���擾
			ArrayList controlRecord = (ArrayList) getInputCSVFile1().getRow(0);

			// ��̃R���g���[�����R�[�h�̌��������ꂼ��擾���ĉ��Z����
			if (ACTextUtilities.isNullText(getInputCSVFile1().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_4_RECORD_COUNT)) && ACTextUtilities.isNullText(getInputCSVFile2().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_4_RECORD_COUNT))) {
				ACMessageBox.show(ERROR_RECORD_COUNT_NOT_FOUND);
				return false;
			} else {
				int totalCount = getInputCSVFile1().getValueAtInteger(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_4_RECORD_COUNT) + getInputCSVFile2().getValueAtInteger(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_4_RECORD_COUNT);
				// �R���g���[�����R�[�h���X�V����
				controlRecord.set(CONTROL_RECORD_FORMAT_4_RECORD_COUNT, ACCastUtilities.toString(totalCount));
			}

			// �R���g���[�����R�[�h���^�[�Q�b�g���X�g�Ɋi�[����
			targetList.add(controlRecord);
		}

		// ��1CSV�t�@�C������������
		ArrayList firstCsvDataRecordArrayList = new ArrayList();
		firstCsvDataRecordArrayList.addAll(getInputCSVFile1().getRows());

		// �ŏ��̃��R�[�h(ControlRecord�����O)
		firstCsvDataRecordArrayList.remove(0);
		// �Ō�̃��R�[�h(EndRecord�����O)
		firstCsvDataRecordArrayList.remove((firstCsvDataRecordArrayList.size() - 1));

		// ��2CSV�t�@�C������������
		ArrayList secondCsvDataRecordArrayList = new ArrayList();
		secondCsvDataRecordArrayList.addAll(getInputCSVFile2().getRows());

		// �ŏ��̃��R�[�h(ControlRecord�����O)
		secondCsvDataRecordArrayList.remove(0);
		// �Ō�̃��R�[�h(EndRecord�����O)
		secondCsvDataRecordArrayList.remove((secondCsvDataRecordArrayList.size() - 1));

		// ��̃f�[�^���R�[�h���^�[�Q�b�g���X�g�ɒǉ�����
		targetList.addAll(firstCsvDataRecordArrayList);
		targetList.addAll(secondCsvDataRecordArrayList);

		// �G���h���R�[�h�i�擪3�j�𐶐����āA�^�[�Q�b�g���X�g�ɒǉ�����
		ArrayList endRecord = new ArrayList();
		endRecord.add("3");
		// �b��I��1��U���Ă����A�ȉ��̃��R�[�h�ԍ��Đ����ŐU��Ȃ������
		endRecord.add("1");
		targetList.add(endRecord);

		// ���R�[�h�ԍ��i�A�ԁj���Đ�������AIterator���g���A�ԍ���U��Ȃ����B
		int recordNumber = 1;
		// ������t�@�C���p�X��p�ӂ���B
		String outputFilePath = getFile3Text().getText() + ACConstants.FILE_SEPARATOR + getFile4Text().getText();
		// VRCSVFile�I�u�W�F�N�g�𐶐�����
		QkanCSVViewerCSVFile outputCsvFile = new QkanCSVViewerCSVFile(outputFilePath);

		// �o�͐�t�@�C�����`�F�b�N����
		File checkOutputFile = new File(outputFilePath);
		if (checkOutputFile.getAbsoluteFile().exists()) {
			int buttonStatus = ACMessageBox.showOkCancel(ERROR_OUTPUT_FILE_EXSISTS);
			if (buttonStatus == ACMessageBox.BUTTON_CANCEL) {
				return false;
			}
		}

		// ���݂��Ȃ��Ȃ�o�͂���
		Iterator targetListIterator = targetList.iterator();
		while (targetListIterator.hasNext()) {
			ArrayList targetRow = (ArrayList) targetListIterator.next();
			targetRow.set(1, ACCastUtilities.toString(recordNumber));
			// List���i�[
			outputCsvFile.addRow(targetRow);
			recordNumber = recordNumber + 1;
		}

		// �Ώۏꏊ��CSV��ۑ�����B
		try {
			outputCsvFile.write(false, true);
		} catch (Exception e) {
			ACMessageBox.show(ERROR_CAN_NOT_OUTPUT_SELECTED_FOLDER);
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
