
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
 * 開発者: 
 * 作成日: 2016/09/02  日本コンピューター株式会社  新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他 (O)
 * プロセス 総合事業サービスコード取込 (015)
 * プログラム 総合事業サービスコード取込 (QO015)
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
 * 総合事業サービスコード取込 (QO015)
 */
public class QO015 extends QO015Event {
	/**
	 * コンストラクタです。
	 */
	public QO015() {
	}

	public void initAffair(ACAffairInfo affair) throws Exception {
		super.initAffair(affair);
		initAction(affair);
	}

	/**
	 * 初期化処理を行ないます。
	 * 
	 * @param affair
	 *            業務情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void initAction(ACAffairInfo affair) throws Exception {
		
		// 画面の初期表示を行う処理
		// 取得したデータのウィンドウタイトル（WINDOW_TITLE）をウィンドウに設定する。
		// 取得したデータの業務タイトル（AFFAIR_TITLE）を業務ボタンバーに設定する。
		VRMap params = affair.getParameters();
		setAffairTitle("QO015", getButtons());

		setM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(new ACPassiveKey("M_SJ_SERVICE_CODE",
				new String[] { "SYSTEM_SERVICE_CODE_ITEM", "TEKIYO_ST_DATE" }, new Format[] {
				ACConstants.FORMAT_SQL_STRING, new ACSQLSafeDateFormat("yyyy-MM-dd") },
				"LAST_TIME", "LAST_TIME"));

		// テーブルモデルを下記の画面のテーブルに設定する。
		ACTableModelAdapter historyInfoTableModel = new ACTableModelAdapter();

		// テーブルモデルを定義
		historyInfoTableModel
		.setColumns(new String[] { "INSURER_ID", "INSURER_NAME", "RECORD_CNT", "IMPORT_TIME" });

		// 定義したテーブルモデルを格納
		setHistoryInfoTableModel(historyInfoTableModel);

		// テーブルモデルをテーブルにセット
		getHistoryInfoTable().setModel(getHistoryInfoTableModel());

		// 詳細編集画面から戻ってきた場合の再描画処理
		if( VRBindPathParser.has("QO015_DATA", params) ){
			VRMap memory = (VRMap)VRBindPathParser.get("QO015_DATA", params);
			this.setSource( memory );
			this.bindSource();
			params.removeData("QO015_DATA");
		}

		// DBよりレコードを取得し、画面に展開する。
		doFind();

		// もしparamsがnullの場合処理を終了する
		if (params == null) {
			return;
		}

		// 渡りパラメーターの中にサービスコード履歴IDがあるかチェックする
		if (VRBindPathParser.has("SJ_SERVICE_CODE_HISTORY_ID", params)) {

			// 詳細画面で選択されていたサービスコード履歴IDと合致するレコードのindexを取得する。
			int index = ACCommon.getInstance().getMatchIndexFromValue(
					getHistoryInfoList(), "SJ_SERVICE_CODE_HISTORY_ID",
					ACCastUtilities.toInt(params.getData("SJ_SERVICE_CODE_HISTORY_ID"), -1));

			// 一致する
			if (index != -1) {
				// サービスコード履歴IDを選択状態にする
				getHistoryInfoTable().setSelectedModelRow(index);
				// 選択サービスコード履歴IDにスクロールする
				getHistoryInfoTable().scrollSelectedToVisible();
			}
		}

	}

	// コンポーネントイベント

	/**
	 * 「取込ファイル参照」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void csvFileSelectFileCompareButtonActionPerformed(ActionEvent e)
			throws Exception {
		// ファイル読み込みダイアログを表示する（読み込みファイルはcsv）
		if (csvReader()) {
			// ファイル読み込みがtrueなら
			// スプラッシュスクリーンを展開表示する
			ACSplash splash = null;
			try {
				splash = (ACSplash) ACFrame.getInstance()
						.getFrameEventProcesser()
						.createSplash(MESSAGE_SPLASH_TEXT1);

				// ファイルの情報より取込内容を画面に反映させる
				if (!setImportInfo()) {
					// falseが返却されたらreturn
					return;
				}

			} finally {
				// ウェイティングフォームを終了する。
				if (splash != null) {
					splash.close();
					splash = null;
				}
			}
		} else {
			// ファイル読み込みがfalseなら
			// 何もしない
		}

	}

	/**
	 * 「取込」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void importButtonActionPerformed(ActionEvent e) throws Exception {
		// スプラッシュスクリーンを展開表示する
		// データ作成までスプラッシュを表示
		ACSplash splash = null;
		try {
			
			if (!checkControlRecord()) {
				// falseが返却されたらreturn
				return;
			}

			// 取り込み確認メッセージ
			// 取込確認メッセージを表示する。※メッセージID = QO015_WARNING_OF_IMPORT
			int msgID = QkanMessageList.getInstance()
					.QO015_WARNING_OF_IMPORT();
			// ｢はい｣選択時
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// OKの場合、行単位のデータチェックを行う

				// ファイル読み込み前の必要変数初期化処理
				// outputTableの初期化を行う
				VRList tempList = new VRArrayList();
				setOutputTableList(tempList);

				splash = (ACSplash) ACFrame.getInstance()
				.getFrameEventProcesser()
				.createSplash(MESSAGE_SPLASH_TEXT1);

				// ファイルからコントロールレコードを解析して画面に反映させる
				// ファイル読み込み前の必要変数初期化処理
				if (!controlRecordParser()) {
					// falseが返却されたらreturn
					return;
				}

				splash.setMessage(MESSAGE_SPLASH_TEXT2);
				
				// レコードをテーブルに反映する処理
				if (!doSave()) {
					// falseが返却されたらreturn
					return;
				}
				
				// 登録完了メッセージを表示する。※メッセージID = QO015_IMPORT_SUCCESSED
				QkanMessageList.getInstance().QO015_IMPORT_SUCCESSED();
				
				// DBよりレコードを取得し、画面に展開する。
				doFind();

				break;
				
			case ACMessageBox.RESULT_CANCEL:
				// ｢キャンセル｣選択時
				// 処理を抜ける。（処理を行わない）
				return;
			}

		} finally {
			// ウェイティングフォームを終了する。
			if (splash != null) {
				splash.close();
				splash = null;
			}
		}
	}


	/**
	 * 「編集」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void editButtonActionPerformed(ActionEvent e) throws Exception{
		moveQO016();
	}

	/**
	 * 「画面遷移処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void historyInfoTableMouseClicked(MouseEvent e) throws Exception {
		moveQO016();
	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		ACFrame.debugStart(new ACAffairInfo(QO015.class.getName()));
	}

	// 内部関数

	/**
	 * 「検索処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFind() throws Exception {
		// 画面展開用の情報を取得する処理
		// 保険者情報TABLEに存在する、全保険者情報を取得する。
		doFindHistoryInfo();

		if (!getHistoryInfoList().isEmpty()) {
			// 取得した全保険者情報（insurerInfoList）をinsurerTableModelに設定する。
			getHistoryInfoTableModel().setAdaptee(getHistoryInfoList());

			// insurerInfoTableのレコードが1件以上の場合

		} else {
			// 情報が取得できなかった場合
			getHistoryInfoList().clearData();
			getHistoryInfoTableModel().setAdaptee(getHistoryInfoList());

		}

	}

	/**
	 * 「総合事業サービスコード取込履歴情報取得」に関する処理を行ないます。
	 * 
	 * @throws Exception 処理例外
	 */
	public void doFindHistoryInfo() throws Exception {
		// 総合事業サービスコード取込履歴情報を取得する処理
		// 総合事業サービスコード取込履歴情報を取得するためのSQL文を取得する。
		// 取得したSQL文を実行する。
		VRList historyInfoList = getDBManager().executeQuery(
				getSQL_GET_M_SJ_SERVICE_CODE_HISTORY_INFO(null));

		// レコードが取得できた場合
		if (!historyInfoList.isEmpty()) {
			// 取得したレコード配列をinsurerInfoListに格納する。
			setHistoryInfoList(historyInfoList);

		} else {

			historyInfoList.clearData();
			setHistoryInfoList(historyInfoList);

		}

	}
    
	/**
	 * 「CSVデータ取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean csvReader() throws Exception {
		// ※ファイル選択処理
		ACFileChooser csvFileChooser = new ACFileChooser();
		ACFileFilter csvFilefilter = new ACFileFilter();
		csvFilefilter.setFileExtensions(CSV_FILE_EXTENSIONS);
		csvFilefilter.setDescription("CSVファイル(*.csv)");

		// ファイル選択ダイアログを開く。
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

		// キャンセル時は中断
		if (selectFile == null) {
			return false;
		}

		// 取得したファイルから拡張子を補完する
		selectFile = new File(selectFile.getParent(),
				getCSVFilePathWithExtension(selectFile.getName(), 0,
						CSV_FILE_EXTENSIONS));

		// ファイル存在チェック
		if (!selectFile.exists()) {
			ACMessageBox.show(ERROR_SELECTED_FILE_NOT_FOUND);
			return false;

		} else {

			// ファイルが選択された場合
			// 選択されたファイル名を、画面の「ファイル名(dbFileSelectFileName)」に設定する。
			getImportFileSelectFileName().setText(String.valueOf(selectFile));

			// 選択されたファイルパスを、inputcsvfilepathに設定する。
			setInputCSVFilePath(selectFile.getAbsolutePath());
			// inputcsvfilepathをinputcsvfileに設定する。
			VRCSVFile selectedCSVFile = new VRCSVFile(getInputCSVFilePath());
			setInputCSVFile(selectedCSVFile);
			getInputCSVFile().setEncode(VRCSVFile.MS932);  // ★SJISでは機種依存文字が文字化けする
			if (getInputCSVFile().canRead() && getInputCSVFile().isFile()) {
				getInputCSVFile().read(false);

			} else {
				// CSVファイルがreadできない場合
				ACMessageBox.show(ERROR_CSV_FILE_CAN_NOT_READ);
				return false;
			}

		}

		return true;

	}

	/**
	 * 「レコード解析」を行い、取込内容に情報を表示する。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean setImportInfo() throws Exception {
		boolean isHeader = false;
		int item = 0;
		String insurerId = "";
		String insurerName = "";
		// 取込情報レコードループ処理開始(インデックス0からgetInputCSVFile().getRowCount()まで)
		for (int rowIndex = 0; rowIndex < getInputCSVFile().getRowCount(); rowIndex++) {
			item = ACCastUtilities.toInt(getInputCSVFile().getValueAtString(rowIndex,
					COMMON_RECORD_FORMAT_INSURERID),0);
			if (rowIndex == 0) {
				if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex,
						COMMON_RECORD_FORMAT_INSURERID))) {
					if (item == 0) {
						// 1行目が数値でない場合、ヘッダーとみなす
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
				// 2016.11.30 保険者番号の1桁目が0の県は省略される可能性あり
				if (insurerId.length() == 5) {
					insurerId = "0" + insurerId;
		        }
				getInsurerId().setText(
						ACCastUtilities.toString(insurerId, ""));
				// 保険者名称を取得する
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

        // trueを返却する
        return true;
    }

	/**
	 * 取込可能なファイルかチェックする
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkControlRecord() throws Exception {
		
		// ファイル選択チェック
		if (getInputCSVFile() == null) {
			ACMessageBox.show(ERROR_FILE_NOT_SELECTED);
			return false;
		}

		// ファイル存在チェック
		if (!getInputCSVFile().isFile()) {
			ACMessageBox.show(ERROR_SELECTED_FILE_NOT_FOUND);
			return false;
		}
		
		// 読込可能かどうか
		if (!getInputCSVFile().canRead()) {
			// CSVファイルがreadできない場合
			ACMessageBox.show(ERROR_CSV_FILE_CAN_NOT_READ);
			return false;
		}

		// 対象データが0件の場合
		if (getInputCSVFile().getRowCount() < 1) {
			ACMessageBox.show(ERROR_DATA_NOT_FOUND);
			return false;
		}
		
		// 保険者番号が取得できていない場合
		if (ACTextUtilities.isNullText(getInsurerId().getText())) {
			ACMessageBox.show(ERROR_DATA_NOT_FOUND_INSURERID);
			return false;
		}
		
		// 保険者番号がマスタに存在しない場合
		if (ACTextUtilities.isNullText(getInsurerName().getText())) {
			ACMessageBox.show("保険者番号が登録されていません。");
			return false;
		}
		
		// trueを返却する
		return true;
	}
	
	/**
	 * 「コントロールレコード解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean controlRecordParser() throws Exception {
		// サービスマスタを取得しておく
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

		// 取込情報レコードループ処理開始(インデックス0からgetInputCSVFile().getRowCount()まで)
		for (int rowIndex = 0; rowIndex < getInputCSVFile().getRowCount(); rowIndex++) {
			VRMap dataRecordMap = new VRHashMap();

			int item = ACCastUtilities.toInt(getInputCSVFile().getValueAtString(rowIndex,
					COMMON_RECORD_FORMAT_INSURERID),0);
			if (rowIndex == 0 && item == 0) {
				// 1行目が数値でない場合、ヘッダーとみなす
				continue;
			}
			// サービス種類コードが多様なサービスの場合スキップ
			String skipServiceCodeKind = ACTextUtilities.trim(getInputCSVFile().getValueAtString(rowIndex, 
					COMMON_RECORD_FORMAT_SERVICE_CODE_KIND));;
			if (!ACTextUtilities.isNullText(skipServiceCodeKind)) {
				if(Arrays.asList(arySonota).contains(skipServiceCodeKind)){
					continue;
				}
			}
			// ◆項目数のチェック
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
					// ◆必須チェック
					// --証記載保険者番号
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"証記載保険者番号");
						return false;
					}
					// 2016.11.30 保険者番号の1桁目が0の県は省略される可能性あり
					if (field.length() == 5) {
						field = "0" + field;
			        }
					insurerId = field;
					dataRecordMap.setData("INSURER_ID", field);
					break;

				case 1:
					// ◆必須チェック
					// --サービス種類コード
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"サービス種類コード");
						return false;
					}
					serviceCodeKind = field;
					dataRecordMap.setData("SERVICE_CODE_KIND", field);
					break;

				case 2:
					// ◆必須チェック
					// --サービス項目コード
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"サービス項目コード");
						return false;
					}
					serviceCodeItem = field;
					dataRecordMap.setData("SERVICE_CODE_ITEM", field);
					break;

				case 3:
					// ◆必須チェック
					// --適用開始年月
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"適用開始年月");
						return false;
					}
					// ※「999999」の場合は「9999/12/01」を設定
					Date tekiyoStDt = convYmToDate(field, "ST");
					// 日付に変換できない場合エラーとする
					if (tekiyoStDt == null || !VRDateParser.isValid(VRDateParser.format(tekiyoStDt, "yyyy/MM/dd"))) {
						QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
								rowIndex + 1,
								"日付に変換できませんでした。",
								"適用開始年月");
						return false;
					}
					dataRecordMap.setData("TEKIYO_ST_DATE", tekiyoStDt);
					break;

				case 4:
					// ◆必須チェック
					// --適用終了年月
					if (ACTextUtilities.isNullText(field)) {
						// 2016.11.30 実際の保険者でNullのケースがあったので対応
						//QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
						//		rowIndex + 1,
						//		"適用終了年月");
						//return false;
						field = "999999";
					}
					// ※「999999」の場合は「9999/12/31」を設定
					Date tekiyoEdDt = convYmToDate(field, "ED");
					if (!field.equals("999999")) {
						// 日付に変換できない場合エラーとする 
						if (tekiyoEdDt == null || !VRDateParser.isValid(VRDateParser.format(tekiyoEdDt, "yyyy/MM/dd"))) {
							QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
									rowIndex + 1,
									"日付に変換できませんでした。",
									"適用終了年月");
							return false;
						}
					}
					dataRecordMap.setData("TEKIYO_ED_DATE", tekiyoEdDt);
					break;

				case 5:
					// ◆必須チェック
					// --サービス名称
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"サービス名称");
						return false;
					} else {
						if (field.length() > 64) {
							QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
									rowIndex + 1,
									"64桁以内で取込可能です。",
									"サービス名称");
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
					// 単位数
					// ①前後の半角スペースの除去（既に取り除かれている）
					// ②マイナス符号の退避-->「00-376」に対応するため
					// ③先頭「０」の除去
					// ④マイナス符号の復元
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
							// 数値に変換できない場合、エラーとする
							QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
									rowIndex + 1,
									"数値に変換できませんでした。",
									"単位数");
							return false;
						}
					} else {
						// ◆必須チェック
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"単位数");
						return false;
					}
					dataRecordMap.setData("SERVICE_UNIT", serviceUnit);
					break;

				case 7:
					// 算定単位
					// ①前後の半角スペースの除去
					// ②先頭「００」の付加 及び 桁数調整（２桁）
					// ③01,02,03,05以外の場合、空文字列に変換※
					String santeiTani = "";
					if (!ACTextUtilities.isNullText(field)) {
						santeiTani = String.format("%2s", field).replace(" ", "0");
					} else {
						// ◆必須チェック
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"算定単位");
						return false;
					}
					String[] arySanteiTani = new String[] { "01", "02", "03", "05" };
					if(!Arrays.asList(arySanteiTani).contains(santeiTani)){
						santeiTani = "";
					}
					dataRecordMap.setData("SANTEI_TANI", santeiTani);
					break;

				case 8:
					// 制限日数回数
					// ①前後の半角スペースの除去
					// ②先頭「０」の除去
					// ③設定内容が「０」の場合、空文字列に変換
					//  0->"",00->""
					String nissuKaisu = "";
					if (!ACTextUtilities.isNullText(field) && !field.equals("0") && !field.equals("00")) {
						int d = ACCastUtilities.toInt(field, -1);
						if (d > -1) {
							nissuKaisu = String.valueOf(d);
						} else {
							// 数値に変換できない場合、エラーとする
							QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
									rowIndex + 1,
									"数値に変換できませんでした。",
									"制限日数回数");
							return false;
						}
					}
					if (nissuKaisu.length() > 2) {
						QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
								rowIndex + 1,
								"2桁以内で取込可能です。",
								"制限日数回数");
						return false;
					}
					dataRecordMap.setData("SEIGEN_NISSU_KAISU", nissuKaisu);
					break;

				case 9:
					// 算定回数制限期間
					// ①前後の半角スペースの除去
					// ②先頭「００」の付加 及び 桁数調整（２桁）
					// ③01,08,16以外の場合、空文字列に変換
					String santeiKaisuSeigenKikan = "";
					santeiKaisuSeigenKikan = String.format("%2s", field).replace(" ", "0");
					String[] arySanteiSeigen = new String[] { "01", "08", "16" };
					if(!Arrays.asList(arySanteiSeigen).contains(santeiKaisuSeigenKikan)){
						santeiKaisuSeigenKikan = "";
					}
					dataRecordMap.setData("SANTEI_KAISU_SEIGEN_KIKAN", santeiKaisuSeigenKikan);
					break;

				case 10:
					// 支給限度額対象区分
					// ①「３」以外の場合、空文字列に変換
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
								"10桁以内で取込可能です。",
								"予備項目");
						return false;
					}
					dataRecordMap.setData("YOBI", field);
					break;

				case 12:
					// 給付率
					// ①前後の半角スペースの除去
					// ②先頭「０」の除去
					// ※定率サービス以外の場合、空文字列に変換
					String kyufuritsu = "";
					String[] aryTeiritsu = new String[] { "A3", "A7", "A9", "AB", "AD" };
					if(Arrays.asList(aryTeiritsu).contains(serviceCodeKind)){
						int d = ACCastUtilities.toInt(field, -1);
						if (!(d > 0 && d <= 100)) {
							QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
									rowIndex + 1,
									"1～100で取込可能です。",
									"給付率");
							return false;
						}
						kyufuritsu = String.valueOf(d);
					} else {
						kyufuritsu = "";
					}
					dataRecordMap.setData("KYUFURITSU", kyufuritsu);
					break;

				case 13:
					// 利用者負担額
					// ①前後の半角スペースの除去
					// ②先頭「０」の除去
					// ※定額サービス以外の場合、空文字列に変換
					//ナレッジではマイナスの変換をしていないが、※Sの項目なのでマイナスの変換を行う
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
										"-999999～999999で取込可能です。",
										"利用者負担額");
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
					// ◆必須チェック
					// --事業対象者実施区分
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"事業対象者実施区分");
						return false;
					}
					// 1,2以外は2に変換
					String[] aryJisshiKbn = new String[] { "1", "2" };
					if(!Arrays.asList(aryJisshiKbn).contains(field)){
						field = "2";
					}
					dataRecordMap.setData("JIGYO_TAISHOSHA_JISSHI_KBN", field);
					break;

				case 15:
					// ◆必須チェック
					// --要支援１受給者実施区分
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"要支援１受給者実施区分");
						return false;
					}
					// 1,2以外は2に変換
					String[] aryYoshien1JisshiKbn = new String[] { "1", "2" };
					if(!Arrays.asList(aryYoshien1JisshiKbn).contains(field)){
						field = "2";
					}
					dataRecordMap.setData("YOSHIEN1_JUKYUSHA_JISSHI_KBN", field);
					break;

				case 16:
					// ◆必須チェック
					// --要支援２受給者実施区分
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"要支援２受給者実施区分");
						return false;
					}
					// 1,2以外は2に変換
					String[] aryYoshien2JisshiKbn = new String[] { "1", "2" };
					if(!Arrays.asList(aryYoshien2JisshiKbn).contains(field)){
						field = "2";
					}
					dataRecordMap.setData("YOSHIEN2_JUKYUSHA_JISSHI_KBN", field);
					break;

				case 17:
					// ◆必須チェック
					// --国保連合会委託区分
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"国保連合会委託区分");
						return false;
					}
					// 1,2以外は1に変換
					String[] aryItakuKbn = new String[] { "1", "2" };
					if(!Arrays.asList(aryItakuKbn).contains(field)){
						field = "1";
					}
					dataRecordMap.setData("KOKUHO_ITAKU_KBN", field);
					break;

				case 18:
					// ◆必須チェック
					// --作成年月日
					if (ACTextUtilities.isNullText(field)) {
						QkanMessageList.getInstance().QO015_ERROR_OF_NEED_CHECK_FOR_INPUT(
								rowIndex + 1,
								"作成年月日");
						return false;
					}
					Date sakuseiDt = convYmdToDate(field);
					// 日付に変換できない場合はエラー
					if (sakuseiDt == null || !VRDateParser.isValid(VRDateParser.format(sakuseiDt, "yyyy/MM/dd"))) {
						QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
								rowIndex + 1,
								"日付に変換できませんでした。",
								"作成年月日");
						return false;
					}
					dataRecordMap.setData("SAKUSEI_DATE", sakuseiDt);
					break;
                    
				default:
				}

			}

			// システムサービス種類コードを取得する（M_SERVICE）
			int systemServiceCodeDetail = ACCastUtilities.toInt(mServiceKeyMap.get(serviceCodeKind), 0);
			if (systemServiceCodeDetail == 0) {
				// 取得できなかった場合、もしくは数値でない場合はエラーにする
				QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
						rowIndex + 1,
						"システムサービス種類コードに変換できませんでした。" + ACConstants.LINE_SEPARATOR,
						"サービス種類コード");
				return false;
			}
			dataRecordMap.setData("SYSTEM_SERVICE_KIND_DETAIL", systemServiceCodeDetail);

			// システムサービス項目コードを組み立てる
			// 保険者番号＋システムサービス種類コード＋サービス項目コード
		    StringBuilder sb = new StringBuilder();
		    sb.append(insurerId);
		    sb.append(ACCastUtilities.toString(systemServiceCodeDetail));
		    sb.append(serviceCodeItem);
			dataRecordMap.setData("SYSTEM_SERVICE_CODE_ITEM", sb.toString());
			// 15桁でなかった場合はエラーにする
			if (sb.length() != 15) {
				// 取得できなかった場合、もしくは数値でない場合はエラーにする
				QkanMessageList.getInstance().QO015_ERROR_OF_FOR_INPUT(
						rowIndex + 1,
						"システムサービス項目コードに変換できませんでした。" + ACConstants.LINE_SEPARATOR,
						"保険者番号、サービス種類コード、サービス項目コード");
				return false;
			}

			// 行
			dataRecordMap.setData("ROW_INDEX", rowIndex + 1);

			// 削除フラグ
			dataRecordMap.setData("DELETE_FLG", "0");

			if (!dataRecordMap.isEmpty()) {
				getOutputTableList().addData(dataRecordMap);
			}

		}

		return true;
	}

	/**
	 * 「保存処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doSave() throws Exception {

		// 総合事業サービスコードマスタの情報をDBに登録する。
		try {
			// トランザクションを開始する。
			getDBManager().beginTransaction();
			
            // 削除用のSQL文を取得するためVRMap：paramを作成し、下記のKEY/VALUEを設定する。
			VRMap param = new VRHashMap();
			// KEY：INSURER_ID VALUE：insurerId
			param.setData("INSURER_ID", getInsurerId().getText());
			// 削除用のSQL文を取得する。
			getDBManager().executeUpdate(getSQL_DELETE_M_SJ_SERVICE_CODE(param));
			// outputTableListのレコードを総合事業サービスコードマスタ情報TABLEに登録する。
			for (int i = 0; i < getOutputTableList().size(); i++) {

				// パッシブタスクをクリアする。
	            getPassiveChecker().clearPassiveTask();
				// 重複キーをセット
				VRMap data = new VRHashMap();
				VRMap item = (VRMap) getOutputTableList().getData(i);
				data.setData("SYSTEM_SERVICE_CODE_ITEM", item.getData("SYSTEM_SERVICE_CODE_ITEM"));
				data.setData("TEKIYO_ST_DATE", (Date) item.getData("TEKIYO_ST_DATE"));

				// パッシブタスクを追加する。
				getPassiveChecker().addPassiveInsertTask(
						getM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(), data);

				// パッシブチェックを実行する。
				if (!getPassiveChecker().passiveCheck(getDBManager())) {
					//テーブルロック解除のためロールバック
					getDBManager().rollbackTransaction();
					// パッシブエラーがある場合
					// エラーメッセージを表示する。
					String rowIndex = ACCastUtilities.toString(item.getData("ROW_INDEX"), "");
					QkanMessageList.getInstance()
					.QO015_ERROR_OF_PASSIVE_CHECK_ON_INSERT(rowIndex);
					// 処理を抜ける。（処理を中断する）
					return false;
				}

				getDBManager()
				.executeUpdate(
						getSQL_INSERT_M_SJ_SERVICE_CODE((VRMap) getOutputTableList()
								.getData(i)));
			}
			
			// SQL文取得用VRMap sqlParamを生成する。
			VRMap sqlParam = new VRHashMap();
			// 画面上のデータを取得し、sqlParamに格納する。
			getImportContents().setSource(sqlParam);
			getImportContents().applySource();

			// 処理が完了したら、履歴テーブルに登録する。
			getDBManager()
			.executeUpdate(
					getSQL_INSERT_M_SJ_SERVICE_CODE_HISTORY((VRMap) sqlParam));

		} catch (Exception sqlEx) {
			// SQL実行時にエラーが発生した場合
			sqlEx.printStackTrace();

			getDBManager().rollbackTransaction();
			// 処理を抜ける。（処理を中断する）
			throw sqlEx;
		}
		// 1つもエラーが発生しなかった場合
		// 処理をコミットする。
		getDBManager().commitTransaction();

		return true;
	}
	

	/**
	 * 「総合事業サービスコード一覧画面に遷移」に関する処理を行ないます。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	public void moveQO016() throws Exception {
		// 総合事業サービスコード一覧画面に遷移する処理

		// 画面情報の退避
		VRHashMap memory = new VRHashMap();
		this.setSource( memory );
		this.applySource();
		ACFrame.getInstance().addNowAffairParameter("QO015_DATA", memory);

		// VRMap：paramを生成し下記のパラメーターを格納する。
		VRMap param = new VRHashMap();

		// 画面の｢総合事業サービスコード一覧｣が選択されていた場合、保険者番号を引き継ぐ
		if (getHistoryInfoTable().isSelected()) {
			// 選択されていた場合
			VRMap rec = (VRMap) getHistoryInfoTable()
					.getSelectedModelRowValue();

			param.setData("INSURER_ID", rec.getData("INSURER_ID"));
			param.setData("SJ_SERVICE_CODE_HISTORY_ID", rec.getData("SJ_SERVICE_CODE_HISTORY_ID"));

	
		} else {
			// 選択されていない場合は、取込内容の保険者番号を引き継ぐ
			param.setData("INSURER_ID", getInsurerId().getText());
		}

		// 次画面遷移のためのパラメーターACAffairInfo affairを定義する。
		ACAffairInfo affair = null;
		affair = new ACAffairInfo(QO016.class.getName(), param);

		// ｢QO016（総合事業サービスコード一覧）｣に遷移する。
		ACFrame.getInstance().next(affair);
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
	public String getCSVFilePathWithExtension(String fileName,
			int defaultExtensionIndex, String[] extensions) {
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
	
	/**
	 * 文字列（年月）を日付型に変換する
	 * 
	 * @param field 対象の文字列
	 * @param mode 開始年月日 or 終了年月日
	 * @return 日付
	 * @throws Exception
	 *             処理例外
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
	 * 文字列（年月日）を日付型に変換する
	 * 
	 * @param field 対象の文字列
	 * @return 日付
	 * @throws Exception
	 *             処理例外
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
	 * 機種依存文字を置換する
	 * 
	 * @param str 対象の文字列
	 * @return 置換後の文字列
	 * @throws Exception
	 *             処理例外
	 */
	public String convCharacters(String str) throws Exception {
		final String[] TARGET_ARRAY = new String[] {
				"Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ", "Ⅵ", "Ⅶ", "Ⅷ", "Ⅸ", "Ⅹ",
				"ⅰ", "ⅱ", "ⅲ", "ⅳ", "ⅴ", "ⅵ", "ⅶ", "ⅷ", "ⅸ", "ⅹ",
				"①","②","③","④","⑤","⑥","⑦","⑧","⑨","⑩",
				"⑪","⑫","⑬","⑭","⑮","⑯","⑰","⑱","⑲","⑳"
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
