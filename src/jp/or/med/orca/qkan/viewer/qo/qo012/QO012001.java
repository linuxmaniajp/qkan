/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKANCHO（JMA care benefit management software）
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
 * アプリ: QKANCHO
 * 開発者: 廣瀬 一海
 * 作成日: 2006/04/11  日本コンピューター株式会社 廣瀬 一海 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム CSVビューア (O)
 * プロセス CSVビューア (012)
 * プログラム CSV結合画面 (QO012001)
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
 * CSV結合画面(QO012001)
 */
public class QO012001 extends QO012001Event {
	/**
	 * コンストラクタです。
	 */
	public QO012001() {
	}

	/**
	 * 初期化処理を行ないます。
	 * 
	 * @param affair
	 *            業務情報
	 * @throws Exception
	 *             処理例外
	 */
	public void initAction() throws Exception {
		// 画面を展開する
		getSnapshot().setRootContainer(getContents());
		setWindowTitle(MESSAGE_WINDOW_TITLE);

        
        // 設定したファイルパス
        if (ACFrame.getInstance().hasProperty("Claim/Folder")) {
           setLastOpenDir(new File(getProperty("Claim/Folder")).getAbsolutePath());
        } else {
           setLastOpenDir(new File(".").getAbsolutePath());
        }
        
	}

	// コンポーネントイベント

	/**
	 * 「CSVファイル結合を終了」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void closeButtonActionPerformed(ActionEvent e) throws Exception {
		// ※終了処理
		// ダイアログを破棄します
		dispose();
	}

	/**
	 * 「CSVファイル結合」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void unitButtonActionPerformed(ActionEvent e) throws Exception {
		// CSVファイルの結合処理
		// 出力先のファイルパス、テキストボックスを事前に確認する。

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

		// 給付管理票情報結合処理
		if (recordUniting()) {
			ACMessageBox.show(MESSAGE_CSV_UNITING_OVER);
		} else {
			return;
		}
	}

	/**
	 * 「CSV1ファイルダイアログ」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void file1ButtonActionPerformed(ActionEvent e) throws Exception {
		// CSV1ファイルダイアログを展開する
		// ※ファイル選択処理
		ACFileChooser csvFileChooser = new ACFileChooser();
		ACFileFilter csvFileFilter = new ACFileFilter();
		csvFileFilter.setFileExtensions(new String[] { "csv" });
		csvFileFilter.setDescription("CSVファイル(*.csv)");
		File csvFile;
		getFile1Text().setText("");
		getFile1InfoText().setText("");

		// ファイル選択ダイアログを開く。(拡張子はcsv)
		csvFile = csvFileChooser.showOpenDialog(getLastOpenDir(), "", MESSAGE_PLEASE_SELECT_CSV_FILE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
//        if (ACFrame.getInstance().hasProperty("Claim/Folder")) {
//            csvFile = csvFileChooser.showOpenDialog(new File(getProperty("Claim/Folder")).getAbsolutePath(), "", MESSAGE_PLEASE_SELECT_CSV_FILE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
//        } else {
//            csvFile = csvFileChooser.showOpenDialog(new File(".").getAbsolutePath(), "", MESSAGE_PLEASE_SELECT_CSV_FILE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
//        }

		if (!(csvFile == null)) {

			// ファイルが選択された場合
			// 取得したファイルから拡張子を補完する
			csvFile = new File(csvFile.getParent(), getCSVFilePathWithExtension(csvFile.getName(), 0, CSV_FILE_EXTENSIONS));

			if (!csvFile.exists()) {
				ACMessageBox.show(ERROR_FILE_NOT_FOUND);
				return;
			}

			VRCSVFile selectedCSVFile = new VRCSVFile(csvFile.getAbsolutePath());
			setInputCSVFile1(selectedCSVFile);
			getInputCSVFile1().setEncode(VRCSVFile.SJIS);

			if (getInputCSVFile1().canRead()) {

				// CSVファイルをメモリ上に展開する
				getInputCSVFile1().read(false);

				// データチェック
				if (getInputCSVFile1().getRowCount() < 1) {
					ACMessageBox.show(ERROR_DATA_NOT_FOUND);
					return;
				}

				List controlRecord = getInputCSVFile1().getRow(0);
				// レコード種別を確認する
				if (!controlRecord.get(0).equals("1")) {
					// レコード種別が1以外の場合
					// エラーメッセージを表示する「コントロールレコードが存在しません」
					// falseを返却する
					ACMessageBox.show(ERROR_CONTROL_RECORD_NOT_FOUND);
					return;
				}

				// データ種別を確認して、格納する
				if (!checkControlRecordDataType(controlRecord.get(4), getFile1InfoText())) {
					// エラーメッセージを表示する「介護給付費明細書、給付管理票情報を格納したCSVではありません」
					ACMessageBox.show(ERROR_NON_CORRESPONDENCE_DATA_RECORD_TYPE);
					return;
				}

				// ファイルパスをテキストボックスに反映する
				getFile1Text().setText(getInputCSVFile1().getPath());

                if(csvFile.getParentFile()!=null){
                    setLastOpenDir(csvFile.getParentFile().getAbsolutePath());
                }
			} else {
				// CSVファイルがreadできない場合
				ACMessageBox.show(ERROR_CAN_NOT_READ_CSV);
				return;
			}

		} else {
			// ファイルが選択されなかった場合
			// 処理を中断する。
		}
		return;
	}

	/**
	 * 「CSV2ファイルダイアログ」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void file2ButtonActionPerformed(ActionEvent e) throws Exception {
		// CSV1ファイルダイアログを展開する
		// ※ファイル選択処理
		ACFileChooser csvFileChooser = new ACFileChooser();
		ACFileFilter csvFileFilter = new ACFileFilter();
		csvFileFilter.setFileExtensions(new String[] { "csv" });
		csvFileFilter.setDescription("CSVファイル(*.csv)");
		File csvFile;
		getFile2Text().setText("");
		getFile2InfoText().setText("");

		// ファイル選択ダイアログを開く。(拡張子はcsv)
        
        csvFile = csvFileChooser.showOpenDialog(getLastOpenDir(), "", MESSAGE_PLEASE_SELECT_CSV_FILE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
//		if (ACFrame.getInstance().hasProperty("Claim/Folder")) {
//			csvFile = csvFileChooser.showOpenDialog(new File(getProperty("Claim/Folder")).getAbsolutePath(), "", MESSAGE_PLEASE_SELECT_CSV_FILE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
//		} else {
//			csvFile = csvFileChooser.showOpenDialog(new File(".").getAbsolutePath(), "", MESSAGE_PLEASE_SELECT_CSV_FILE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
//		}
		if (!(csvFile == null)) {

			// ファイルが選択された場合
			// 取得したファイルから拡張子を補完する
			csvFile = new File(csvFile.getParent(), getCSVFilePathWithExtension(csvFile.getName(), 0, CSV_FILE_EXTENSIONS));

			if (!csvFile.exists()) {
				ACMessageBox.show(ERROR_FILE_NOT_FOUND);
				return;
			}

			VRCSVFile selectedCSVFile = new VRCSVFile(csvFile.getAbsolutePath());
			setInputCSVFile2(selectedCSVFile);
			getInputCSVFile2().setEncode(VRCSVFile.SJIS);

			if (getInputCSVFile2().canRead() && getInputCSVFile2().isFile()) {

				// CSVファイル名の頭に"k"を付加してFileText4にセットする。
				String outputFileName = "k" + csvFile.getName().toString();
				getFile4Text().setText(outputFileName);

				// CSVをメモリ上に展開する
				getInputCSVFile2().read(false);

				// データチェック
				if (getInputCSVFile2().getRowCount() < 1) {
					ACMessageBox.show(ERROR_DATA_NOT_FOUND);
					return;
				}

				List controlRecord = getInputCSVFile2().getRow(0);
				// レコード種別を確認する
				if (!controlRecord.get(0).equals("1")) {
					// レコード種別が1以外の場合
					// エラーメッセージを表示する「コントロールレコードが存在しません」
					// falseを返却する
					ACMessageBox.show(ERROR_CONTROL_RECORD_NOT_FOUND);
					return;
				}

				// データ種別を確認して、格納する
				if (!checkControlRecordDataType(controlRecord.get(4), getFile2InfoText())) {
					// エラーメッセージを表示する
					ACMessageBox.show(ERROR_NON_CORRESPONDENCE_DATA_RECORD_TYPE);
					return;
				}

				// ファイルパスをテキストボックスに反映する
				getFile2Text().setText(getInputCSVFile2().getPath());

                if(csvFile.getParentFile()!=null){
                    setLastOpenDir(csvFile.getParentFile().getAbsolutePath());
                }
			} else {
				// CSVファイルがreadできない場合
				ACMessageBox.show(ERROR_CAN_NOT_READ_CSV);
				return;
			}

		} else {
			// ファイルが選択されなかった場合
			// 処理を中断する。
		}
		return;
	}

	/**
	 * 「CSV3ファイルダイアログ」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void file3ButtonActionPerformed(ActionEvent e) throws Exception {
		// CSV3ファイルダイアログを展開する
		// ※ファイル選択処理
		ACFileChooser csvFolderChooser = new ACFileChooser();
		File outputFolder;
		getFile3Text().setText("");

		// ファイル選択ダイアログを開く。(拡張子はcsv)
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
			// ファイルパスをテキストボックスに反映する
			getFile3Text().setText(outputFolder.getAbsolutePath());

            setLastOpenDir(outputFolder.getAbsolutePath());
		}
	}

	/**
	 * 「コントロールデータの種別判定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkControlRecordDataType(Object dataType, ACTextField returnField) throws Exception {
		if (ACTextUtilities.isNullText(dataType)) {
			return false;
		}
        //[H27.4 改正対応][Shinobu Hitaka] 2016/07/13 edit begin 総合事業対応
        //データ種別は英数字であるため、switch-caseを廃止
		//switch (ACCastUtilities.toInt(dataType)) {
		//	case 711:
		//		// データ種別が711の場合
		//		// そのまま継続する
		//		returnField.setText(CSV_FILE_TYPE_711);
		//		break;
		//
		//	case 812:
		//		// データ種別が812の場合
		//		// そのまま継続する
		//		returnField.setText(CSV_FILE_TYPE_812);
		//		break;
		//
		//	case 821:
		//		// データ種別が821の場合
		//		// そのまま継続する
		//		returnField.setText(CSV_FILE_TYPE_821);.
		//		break;
		//
		//	default:
		//		// データ種別がそれら以外の場合
		//		// falseを返却する
		//		return false;
		//}
        if (dataType.equals("711")) {
			// データ種別が711の場合
			// そのまま継続する
			returnField.setText(CSV_FILE_TYPE_711);
        } else if (dataType.equals("812")) {
			// データ種別が812の場合
			// そのまま継続する
			returnField.setText(CSV_FILE_TYPE_812);
        } else if (dataType.equals("821")) {
			// データ種別が821の場合
			// そのまま継続する
			returnField.setText(CSV_FILE_TYPE_821);
        } else if (dataType.equals("71R")) {
			// データ種別が71Rの場合
			// そのまま継続する
			returnField.setText(CSV_FILE_TYPE_71R);
        } else {
            // データ種別がそれら以外の場合
            // falseを返却する
            return false;
        }
        //[H27.4 改正対応][Shinobu Hitaka] 2016/07/13 edit end

		return true;
	}

	/**
	 * 「結合処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean recordUniting() throws Exception {
		// 必須レコードチェック
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

		// ターゲットリストを初期化する(ArrayList)
		ArrayList targetList = new ArrayList();

		// 交換識別番号チェック（どちらのファイルの識別番号も同一の物のみを処理する）
		if (!(getInputCSVFile1().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_5_DATA_TYPE).equals(getInputCSVFile2().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_5_DATA_TYPE)))) {
			ACMessageBox.show(ERROR_NOT_SAME_FILE_DATA_TYPE);
			return false;
		}

		// 念の為コントロールレコードのnullチェックもしておく
		if (!ACTextUtilities.isNullText(getInputCSVFile1().getRow(0))) {
			// 二つのコントロールレコードを取得して、比較する。処理対象年月が違う場合は蹴る
			if (!(getInputCSVFile1().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_11_TARGET_YEAR_AND_MONTH).equals(getInputCSVFile2().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_11_TARGET_YEAR_AND_MONTH)))) {
				ACMessageBox.show(ERROR_NOT_SAME_TARGET_DATE);
				return false;
			}

			// コントロールレコード(List)を取得
			ArrayList controlRecord = (ArrayList) getInputCSVFile1().getRow(0);

			// 二つのコントロールレコードの件数をそれぞれ取得して加算する
			if (ACTextUtilities.isNullText(getInputCSVFile1().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_4_RECORD_COUNT)) && ACTextUtilities.isNullText(getInputCSVFile2().getValueAtString(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_4_RECORD_COUNT))) {
				ACMessageBox.show(ERROR_RECORD_COUNT_NOT_FOUND);
				return false;
			} else {
				int totalCount = getInputCSVFile1().getValueAtInteger(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_4_RECORD_COUNT) + getInputCSVFile2().getValueAtInteger(CONTROL_RECORD_INDEX, CONTROL_RECORD_FORMAT_4_RECORD_COUNT);
				// コントロールレコードを更新する
				controlRecord.set(CONTROL_RECORD_FORMAT_4_RECORD_COUNT, ACCastUtilities.toString(totalCount));
			}

			// コントロールレコードをターゲットリストに格納する
			targetList.add(controlRecord);
		}

		// 第1CSVファイル初期化処理
		ArrayList firstCsvDataRecordArrayList = new ArrayList();
		firstCsvDataRecordArrayList.addAll(getInputCSVFile1().getRows());

		// 最初のレコード(ControlRecordを除外)
		firstCsvDataRecordArrayList.remove(0);
		// 最後のレコード(EndRecordを除外)
		firstCsvDataRecordArrayList.remove((firstCsvDataRecordArrayList.size() - 1));

		// 第2CSVファイル初期化処理
		ArrayList secondCsvDataRecordArrayList = new ArrayList();
		secondCsvDataRecordArrayList.addAll(getInputCSVFile2().getRows());

		// 最初のレコード(ControlRecordを除外)
		secondCsvDataRecordArrayList.remove(0);
		// 最後のレコード(EndRecordを除外)
		secondCsvDataRecordArrayList.remove((secondCsvDataRecordArrayList.size() - 1));

		// 二つのデータレコードをターゲットリストに追加する
		targetList.addAll(firstCsvDataRecordArrayList);
		targetList.addAll(secondCsvDataRecordArrayList);

		// エンドレコード（先頭3）を生成して、ターゲットリストに追加する
		ArrayList endRecord = new ArrayList();
		endRecord.add("3");
		// 暫定的に1を振っておく、以下のレコード番号再生成で振りなおされる
		endRecord.add("1");
		targetList.add(endRecord);

		// レコード番号（連番）を再生成する、Iteratorを使い、番号を振りなおす。
		int recordNumber = 1;
		// 生成先ファイルパスを用意する。
		String outputFilePath = getFile3Text().getText() + ACConstants.FILE_SEPARATOR + getFile4Text().getText();
		// VRCSVFileオブジェクトを生成する
		QkanCSVViewerCSVFile outputCsvFile = new QkanCSVViewerCSVFile(outputFilePath);

		// 出力先ファイルをチェックする
		File checkOutputFile = new File(outputFilePath);
		if (checkOutputFile.getAbsoluteFile().exists()) {
			int buttonStatus = ACMessageBox.showOkCancel(ERROR_OUTPUT_FILE_EXSISTS);
			if (buttonStatus == ACMessageBox.BUTTON_CANCEL) {
				return false;
			}
		}

		// 存在しないなら出力する
		Iterator targetListIterator = targetList.iterator();
		while (targetListIterator.hasNext()) {
			ArrayList targetRow = (ArrayList) targetListIterator.next();
			targetRow.set(1, ACCastUtilities.toString(recordNumber));
			// Listを格納
			outputCsvFile.addRow(targetRow);
			recordNumber = recordNumber + 1;
		}

		// 対象場所にCSVを保存する。
		try {
			outputCsvFile.write(false, true);
		} catch (Exception e) {
			ACMessageBox.show(ERROR_CAN_NOT_OUTPUT_SELECTED_FOLDER);
		}
		return true;
	}

	/**
	 * CSVの拡張子付きファイルファイル名を取得します。
	 * 
	 * @param fileName
	 *            ファイル名
	 * @param defaultExtension
	 *            拡張子が付いていない場合、拡張子候補の何番目の拡張子を付与するか
	 * @param extensions
	 *            拡張子候補
	 * @return 拡張子付きファイル名
	 */
	public String getCSVFilePathWithExtension(String fileName, int defaultExtensionIndex, String[] extensions) {
		if (fileName == null) {
			return "";
		}

		int pos = fileName.lastIndexOf('.'); // 最後のピリオド位置を取得
		if (pos == -1) {
			// 拡張子を追加して返す
			return fileName + "." + extensions[defaultExtensionIndex];
		}

		if ((pos > 0) && (pos < (fileName.length() - 1))) {
			String ext = fileName.substring(pos + 1).toLowerCase(); // 最後のピリオドより後の文字列を小文字で返す
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
