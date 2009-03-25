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
 * 作成日: 2006/04/07  日本コンピューター株式会社 廣瀬 一海 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム CSVビュアー (O)
 * プロセス CSVビュアー (012)
 * プログラム CSVビュアー (QO012)
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
 * 給付管理/介護報酬請求 CSVファイルビューア(QO012)
 */
public class QO012 extends QO012Event {
	/**
	 * コンストラクタです。
	 */
	public QO012() {
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
		// 画面を展開する
		getSnapshot().setRootContainer(getContents());

		// DB接続を確認する
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
		// ※終了処理
		// 終了確認のメッセージを表示する。CSVビューアを終了してもよろしいですか？
		if (ACMessageBox.showOkCancel(MESSAGE_PROGRAM_EXIT) == ACMessageBox.RESULT_OK) {
			// 「OK」選択時
			// プログラムを終了する。（基盤にtrueを返す）
			return true;
		}
		// 「キャンセル」選択時
		// 処理を中断する。(基盤にfalseを返す)
		return false;
	}

	// コンポーネントイベント

	/**
	 * 「CSVファイルを開く」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void openButtonActionPerformed(ActionEvent e) throws Exception {
		// ファイル読み込みダイアログを表示する（読み込みファイルはcsv）
		if (csvReader()) {
			// ファイル読み込みがtrueなら
			// スプラッシュスクリーンを展開表示する
			// 印刷データ作成までスプラッシュを表示
			ACSplash splash = null;
			try {
				splash = (ACSplash) ACFrame.getInstance().getFrameEventProcesser().createSplash(MESSAGE_SPLASH_TEXT1);

				// ファイル読み込み前の必要変数初期化処理
				// outputTableの初期化を行う
				VRList tempList = new VRArrayList();
				setOutputTableList(tempList);

				VRList tempList2 = new VRArrayList();
				setTotalInfoTableList(tempList2);

				VRList tempList3 = new VRArrayList();
				setClaimInfoTableList(tempList3);
				
				// ファイルからコントロールレコードを解析して画面に反映させる
				if (!controlRecordParser()) {
					// falseが返却されたらreturn
					return;
				}

				splash.setMessage(MESSAGE_SPLASH_TEXT2);
				if (!dataRecordPaser()) {
					return;
				}

				// 情報テーブル部処理
				splash.setMessage(MESSAGE_SPLASH_TEXT4);
				if (!totalRecordInfo()) {
					return;
				}

				// レコードをテーブルに反映する処理
				dataMapping();
				// falseが返却されたらreturn

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
	 * 「CSVファイル結合」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void unitingButtonActionPerformed(ActionEvent e) throws Exception {
		// QO012001クラス(CSVファイル結合)をロードする
		QO012001 qo012001 = new QO012001();
		qo012001.initAction();
		qo012001.setVisible(true);
	}

	public static void main(String[] args) {
		// // デフォルトデバッグ起動
		// ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
		// QkanCommon.debugInitialize();
		// VRMap param = new VRHashMap();
		// // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
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

	// 内部関数

	/**
	 * 「CSVデータ取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean csvReader() throws Exception {
		// ※ファイル選択処理
		ACFileChooser csvFileChooser = new ACFileChooser();
		ACFileFilter csvFileFilter = new ACFileFilter();
		csvFileFilter.setFileExtensions(CSV_FILE_EXTENSIONS);
		csvFileFilter.setDescription("CSVファイル(*.csv)");
		File csvFile;

		// ファイル選択ダイアログを開く。(拡張子はcsv)
		if (hasProperty("Claim/Folder")) {
			csvFile = csvFileChooser.showOpenDialog(new File(getProperty("Claim/Folder")).getAbsolutePath(), "", MESSAGE_FILE_OPEN_DIALOG_TITLE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
		} else {
			csvFile = csvFileChooser.showOpenDialog(new File(".").getAbsolutePath(), "", MESSAGE_FILE_OPEN_DIALOG_TITLE, csvFileFilter.getFileExtensions(), csvFileFilter.getDescription());
		}

		if (!(csvFile == null)) {
			// ファイルが選択された場合
			// 取得したファイルから拡張子を補完する
			csvFile = new File(csvFile.getParent(), getCSVFilePathWithExtension(csvFile.getName(), 0, CSV_FILE_EXTENSIONS));

			if (!csvFile.exists()) {
				ACMessageBox.show(ERROR_SELECTED_FILE_NOT_FOUND);
				return false;
			}

			// 選択されたファイルパスを、inputcsvfilepathに設定する。
			setInputCSVFilePath(csvFile.getAbsolutePath());

			// inputcsvfilepathをinputcsvfileに設定する。
			VRCSVFile selectedCSVFile = new VRCSVFile(getInputCSVFilePath());
			setInputCSVFile(selectedCSVFile);
			getInputCSVFile().setEncode(VRCSVFile.SJIS);
			if (getInputCSVFile().canRead() && getInputCSVFile().isFile()) {
				getInputCSVFile().read(false);

			} else {
				// CSVファイルがreadできない場合
				ACMessageBox.show(ERROR_CSV_FILE_CAN_NOT_READ);
				return false;
			}

			// 処理を継続する。

		} else {
			// ファイルが選択されなかった場合
			// 処理を中断する。
			return false;
		}

		return true;
	}

	/**
	 * 「コントロールレコード解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean controlRecordParser() throws Exception {
		// CSVファイルの第一行目（コントロールレコードを読み出して、以下のBINDPATHに格納する）
		// コントロールレコードフォーマット構造
		// 1.レコード種別
		// 2.レコード番号
		// 3.ボリューム通番
		// 4.レコード件数 コントロールとエンドを除いたデータレコード件数
		// 5.データ種別 711なら介護給付費明細情報 FILE_TYPE
		// 6.福祉事業所特定番号 事業者なら0
		// 7.保険者番号 保険者では無いので0
		// 8.事業所番号 PROVIDER_ID DB取得でPROVIDER_NAMEも取得
		// 9.都道府県番号 2桁の都道府県番号
		// 10.媒体区分 1(伝送） 2（MO） 3(ＭＴ) 4(FD) MEDIA_TYPE
		// 11.処理対象年月 TARGET_MONTH
		// 12.ファイル管理番号
		if (getInputCSVFile().getRowCount() < 1) {
			ACMessageBox.show(ERROR_DATA_NOT_FOUND);
		}

		List controlRecord = getInputCSVFile().getRow(0);
		// レコード種別を確認する
		if (!controlRecord.get(COMMON_RECORD_FORMAT_1_RECORD_TYPE).equals("1")) {
			// レコード種別が1以外の場合
			// エラーメッセージを表示する「コントロールレコードが存在しません」
			// falseを返却する
			ACMessageBox.show(ERROR_CONTROL_RECORD_NOT_FOUND);
			return false;
		}

		// データ種別を確認して、格納する

		if (!checkControlRecordDataType(controlRecord.get(CONTROL_RECORD_FORMAT_5_DATA_TYPE))) {
			// エラーメッセージを表示する「介護給付費明細書、給付管理票情報を格納したCSVではありません」
			ACMessageBox.show(ERROR_NON_CORRESPONDENCE_DATA_RECORD_TYPE);
			return false;
		}

		// 媒体区分を確認して、格納する
		if (!checkControlRecordMediaType(controlRecord.get(CONTROL_RECORD_FORMAT_10_MEDIA_TYPE))) {
			ACMessageBox.show(ERROR_MEDIA_TYPE_NOT_FOUND);
			return false;
		}

		// 事業所情報を取得する
		// headerMapに8.事業所番号を文字列でBINDPATH PROVIDER_IDに格納する
		if (ACTextUtilities.isNullText(controlRecord.get(CONTROL_RECORD_FORMAT_8_PROVIDER_NUMBER))) {
			ACMessageBox.show(ERROR_PROVIDER_NUMBER_NOT_FOUND);
			return false;
		} else {
			getHeaderMap().setData("PROVIDER_ID", controlRecord.get(CONTROL_RECORD_FORMAT_8_PROVIDER_NUMBER));
			// 事業所番号から結果をproviderMapに取得する
			if (getCanDBConnect()) {
				VRList providerList = getDBManager().executeQuery(getSQL_GET_PROVIDER_INFO(getHeaderMap()));
				if (!providerList.isEmpty()) {
					// providerMapからPROVIDER_NAMEを取得し、headerMapに格納する
					setProviderMap((VRMap) providerList.getData(0));
					getHeaderMap().setData("PROVIDER_NAME", getProviderMap().getData("PROVIDER_NAME"));
				} else {
					getHeaderMap().setData("PROVIDER_NAME", PROVIDER_LESS);
				}
			} else {
				getHeaderMap().setData("PROVIDER_NAME", PROVIDER_LESS);
			}
		}

		// 処理対象月を取得する
		// 処理対象月を取得し、DATE型で生成してheaderMapにBINDPATH TARGET_MONTHで格納する
		if (ACTextUtilities.isNullText(controlRecord.get(CONTROL_RECORD_FORMAT_11_TARGET_YEAR_AND_MONTH))) {
			ACMessageBox.show(ERROR_TARGET_DATE_NOT_FOUND);
			return false;
		} else {
			getHeaderMap().setData("TARGET_MONTH", (ACCastUtilities.toString(controlRecord.get(CONTROL_RECORD_FORMAT_11_TARGET_YEAR_AND_MONTH)) + "01"));
		}
		// trueを返却する
		return true;
	}

	/**
	 * 「明細基本情報レコード（サービス事業所）解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean dataRecordPaser() throws Exception {
		// データレコードを解析する処理
		// 初期化処理
		VRList dataRecordList = new VRArrayList();

		// 基本情報レコードループ処理開始(インデックス0からgetInputCSVFile().getRowCount()まで)
		for (int rowIndex = 0; rowIndex < getInputCSVFile().getRowCount(); rowIndex++) {
			VRMap dataRecordMap = new VRHashMap();
			// 取得したCSV行(Listで取得)の1番目が2（データレコード）であるか？
			if (!(getInputCSVFile().getValueAtString(rowIndex, COMMON_RECORD_FORMAT_1_RECORD_TYPE).equals("2"))) {
				// 違う場合
				// ループをスキップする
				continue;
			}

			// 存在するのが前提になるが、念の為から文字チェックを入れておく
			// 交換識別情報の確認
			String exchangeType = getInputCSVFile().getValueAtString(rowIndex, COMMON_RECORD_FORMAT_3_EXCHANGE_TYPE);

			if (exchangeType.equals("7131")) {
				// 7131 様式第2
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("7132")) {
				// 7132 様式第2-2
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("7143")) {
				// 7143 様式第3
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("7144")) {
				// 7144 様式第4
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			// 2008/03/27 [Masahiko_Higuchi] edit - begin 平成20年度4月法改正対応（介護療養型老人保健施設）
			} else if (exchangeType.equals("7153")||exchangeType.equals("7155")) {
				// 7153 様式第4
            // 2008/03/27 [Masahiko_Higuchi] edit - end
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
            // 2008/03/27 [Masahiko_Higuchi] edit - begin 平成20年度4月法改正対応（介護療養型老人保健施設）
			} else if (exchangeType.equals("7154")||exchangeType.equals("7156")) {
            // 2008/03/27 [Masahiko_Higuchi] edit - end
				// 7154 様式第4-2
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("7164")) {
				// 7164 様式第5
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("7165")) {
				// 7165 様式第5-2
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("7171")) {
				// 7171 様式第6
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("7172")) {
				// 7172 様式第6-2
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("7173")) {
				// 7173 様式第6-3
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("7174")) {
				// 7174 様式第6-4
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("7175")) {
				// 7175 様式第6-5
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("7176")) {
				// 7175 様式第6-6
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("7183")) {
				// 7183 様式第8
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
            // 2008/03/27 [Masahiko_Higuchi] edit - begin 平成20年度4月法改正対応（介護療養型老人保健施設）
			} else if (exchangeType.equals("7193")||exchangeType.equals("7194")) {
            // 2008/03/27 [Masahiko_Higuchi] edit - end
				// 7193 様式第9
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("71A3")) {
				// 7193 様式第10
				if (!dataRecord711Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("8122")) {
				// 8122 様式第7
				if (!dataRecord812Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("8123")) {
				// 8123 様式第7-2
				if (!dataRecord812Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
				
			//[ID:0000448][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
			} else if (exchangeType.equals("8124")) {
				// 8124 H21.4以降　様式第7
				if (!dataRecord812ParserH2104(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("8125")) {
				// 8125 H21.4以降 様式第7-2
				if (!dataRecord812ParserH2104(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			//[ID:0000448][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
				
			} else if (exchangeType.equals("8222")) {
				// 8123 様式第11(給付管理表情報)
				if (!dataRecord822Parser(rowIndex, dataRecordMap)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else if (exchangeType.equals("7111")) {
				// 7111 様式第1
				if (!dataRecord7111Parser(rowIndex)) {
					// パーサを実行して、解析に問題が有った場合はスキップする
					continue;
				}
			} else {
				// 交換識別番号が該当しない場合(4月以前の交換識別番号はスキップする)
				continue;
			}

			if (!dataRecordMap.isEmpty()) {
				// dataRecordListに追加する。
				dataRecordList.addData(dataRecordMap);
			}
		}

//		// outputTableの初期化を行う
//		VRList tempList = new VRArrayList();
//		setOutputTableList(tempList);

		// データレコードの結合処理を行う
		if (!dataRecordMerge(dataRecordList)) {
			return false;
		}

		return true;
	}

	/**
	 * 「画面展開」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void dataMapping() throws Exception {

		// 上部レコード情報部分をbindする
		getFileInfoGroup().setSource(getHeaderMap());
		getFileInfoGroup().bindSource();

		// csvDataTableを以下のフィールドで設定する。
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

		// 格納
		ACTableModelAdapter csvDataTableModel = new ACTableModelAdapter();
		csvDataTableModel.setColumns(csvDataTableSchema);

		// csvDataTableにcsvDataTableModelをセットする
		getCsvDataTable().setModel(csvDataTableModel);

		// モデルにデータをセットする
		csvDataTableModel.setAdaptee(getOutputTableList());

		// 上部集計情報用テーブル
		String[] totalInfoDataTableSchema = new String[6];
		totalInfoDataTableSchema[0] = "TOTAL1";
		totalInfoDataTableSchema[1] = "TOTAL2";
		totalInfoDataTableSchema[2] = "TOTAL3";
		totalInfoDataTableSchema[3] = "TOTAL4";
		totalInfoDataTableSchema[4] = "TOTAL5";
		totalInfoDataTableSchema[5] = "TOTAL6";

		// テーブルモデルアダプタ生成
		ACTableModelAdapter totalInfoDataTableModel = new ACTableModelAdapter();
		totalInfoDataTableModel.setColumns(totalInfoDataTableSchema);

		getTotalInfoTable().setModel(totalInfoDataTableModel);
		totalInfoDataTableModel.setAdaptee(getTotalInfoTableList());

	}

	/**
	 * 「抽出したテーブル用Listを展開」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean totalRecordInfo() throws Exception {
		// 初期化処理
		VRList initList = new VRArrayList();
		setTotalInfoTableList(initList);

		// 年次情報集計の基礎になる、請年月度を取得する
		VRList yearIndexDataList = new VRArrayList();
		Iterator outputTableListIterator = getOutputTableList().iterator();
		while (outputTableListIterator.hasNext()) {
			VRMap outputTableMap = (VRMap) outputTableListIterator.next();

			// キーを抽出
			VRMap dataIndexMap = new VRHashMap();
			dataIndexMap.setData("YEAR_AND_MONTH", outputTableMap.getData("YEAR_AND_MONTH"));
			yearIndexDataList.add(dataIndexMap);
		}

		// レコードをユニークに纏める
		Set uniqueSet = new HashSet();
		uniqueSet.addAll(yearIndexDataList);

		// outputTableListからIteratorで上部テーブルの年次集計情報を纏める
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

					// 年月を取得
					totalMap.setData("TOTAL1", claimTotalData.getData("YEAR_AND_MONTH"));

					if ("01".equals(claimTotalData.getData("CLAIM_STATUS"))) {
						// サービス件数を取得
						totalMap.setData("TOTAL3", ACCastUtilities.toInteger(ACBindUtilities.getMatchListFromValue((VRList) annualTotalList, "SERVICE_FLAG", ON).size()));
					} else {
						// PLAN_FLAGで抽出し、プラン件数を取得
						totalMap.setData("TOTAL4", ACCastUtilities.toInteger(ACBindUtilities.getMatchListFromValue((VRList) annualTotalList, "PLAN_FLAG", ON).size()));
					}

					claimUnit = claimUnit + ACCastUtilities.toInt(claimTotalData.getData("CLAIM_UNIT"));
					claimAmount = claimAmount + ACCastUtilities.toInt(claimTotalData.getData("CLAIM_AMOUNT"));
				}

				// 件数を取得(件数はレコードの件数から)
				totalMap.setData("TOTAL2", ACCastUtilities.toInteger(annualTotalList.size()));

				// 以前の7111を使わないレコード集計型の合計計算ロジック
				// 合計計算
				// int totalUnitCount = 0;
				// int totalInsuranceCount = 0;
				// Iterator splitDataIter = annualTotalList.iterator();
				// while (splitDataIter.hasNext()) {
				// VRMap annualDetailData = (VRMap) splitDataIter.next();
				// totalUnitCount = totalUnitCount + ACCastUtilities.toInt(annualDetailData.getData("UNIT_TOTAL"));
				// totalInsuranceCount = totalInsuranceCount + ACCastUtilities.toInt(annualDetailData.getData("INSURANCE_AMOUNT"));
				// }

				// 年月別単位数合計を取得
				totalMap.setData("TOTAL5", ACCastUtilities.toInteger(claimUnit));
				// 年月別保険請求額合計を取得
				totalMap.setData("TOTAL6", ACCastUtilities.toInteger(claimAmount));

				// 給付管理票を読み込んだ後の場合は非表示になっているので表示に
				getTotalInfoTableColumn3().setVisible(true);
				getTotalInfoTableColumn4().setVisible(true);
				getTotalInfoTableColumn5().setVisible(true);
				getTotalInfoTableColumn6().setVisible(true);
				// 文字列調整
				getTotalInfoTableColumn2().setColumns(10);
				
			} else {
				// 給付管理表の場合
				totalMap.setData("TOTAL1", claimYearAndMonth.getData("YEAR_AND_MONTH"));
				// 件数を取得
				totalMap.setData("TOTAL2", ACCastUtilities.toInteger(annualTotalList.size()));
				
				// 表示しない部分を非表示に
				getTotalInfoTableColumn3().setVisible(false);
				getTotalInfoTableColumn4().setVisible(false);
				getTotalInfoTableColumn5().setVisible(false);
				getTotalInfoTableColumn6().setVisible(false);
			}
			
			// 集計情報テーブルリストに加える
			getTotalInfoTableList().add(totalMap);

		}

		return true;
	}

	/**
	 * 「コントロールデータの種別判定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkControlRecordDataType(Object dataType) throws Exception {
		if (ACTextUtilities.isNullText(dataType)) {
			return false;
		}
		switch (ACCastUtilities.toInt(dataType)) {
			case 711:
				// データ種別が711の場合
				// headerMapに文字列"介護給付費明細書情報" BINDPATH FILE_TYPEで格納する
				// そのまま継続する
				getHeaderMap().setData("FILE_TYPE", CSV_FILE_TYPE_711);
				break;
			case 812:
				// データ種別が812の場合
				// headerMapに文字列"介護給付費請求明細書（居宅サービス計画費）情報" BINDPATH FILE_TYPEで格納する
				// そのまま継続する
				getHeaderMap().setData("FILE_TYPE", CSV_FILE_TYPE_812);
				break;
			case 821:
				// データ種別が821の場合
				// headerMapに文字列"介護給付費請求明細書（居宅サービス計画費）情報" BINDPATH FILE_TYPEで格納する
				// そのまま継続する
				getHeaderMap().setData("FILE_TYPE", CSV_FILE_TYPE_821);
				break;
			default:
				// データ種別がそれら以外の場合
				// falseを返却する
				return false;
		}

		return true;
	}

	/**
	 * 「媒体種別の種別判定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkControlRecordMediaType(Object mediaType) throws Exception {
		if (ACTextUtilities.isNullText(mediaType)) {
			return false;
		}
		switch (ACCastUtilities.toInt(mediaType)) {
			case 1:
				// 媒体区分が1の場合
				// headerMapに文字列"伝送"をBINDPATH MEDIA_TYPEで格納する
				getHeaderMap().setData("MEDIA_TYPE", MEDIA_TYPE1);
				break;
			case 2:
				// 媒体区分が2の場合
				// headerMapに文字列"MO"をBINDPATH MEDIA_TYPEで格納する
				getHeaderMap().setData("MEDIA_TYPE", MEDIA_TYPE2);
				break;
			case 3:
				// 媒体区分が3の場合
				// headerMapに文字列"MT"をBINDPATH MEDIA_TYPEで格納する
				getHeaderMap().setData("MEDIA_TYPE", MEDIA_TYPE3);
				break;
			case 4:
				// 媒体区分が4の場合
				// headerMapに文字列"FD"をBINDPATH MEDIA_TYPEで格納する
				getHeaderMap().setData("MEDIA_TYPE", MEDIA_TYPE4);
				break;
			default:
				// 媒体区分がそれら以外の場合
				return false;
		}
		return true;
	}

	/**
	 * 「要介護度チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
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
	 * 「71系交換識別情報基本解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean dataRecord711Parser(int rowIndex, VRMap returnDataMap) throws Exception {
		// 711系基本情報パーサ
		if (ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, DATA_RECORD_FORMAT_711TYPE_2_RECORD_TYPE_CODE))) {
			return false;
		}

		// レコードタイプ判別
		int recordType = getInputCSVFile().getValueAtInteger(rowIndex, DATA_RECORD_FORMAT_711TYPE_2_RECORD_TYPE_CODE);
		switch (recordType) {
			case 1:
				// レコードタイプ1（基本情報）
				if (!dataType711Paser01(rowIndex, returnDataMap)) {
					return false;
				}
				break;

			case 2:
				// レコードタイプ2（明細情報）
				if (!dataType711Paser02(rowIndex, returnDataMap)) {
					return false;
				}
				break;

			case 4:
				// レコードタイプ4(特定診療費)
				if (!dataType711Paser04(rowIndex, returnDataMap)) {
					return false;
				}
				break;

			case 10:
				// レコードタイプ10（集計情報）
				if (!dataType711Paser10(rowIndex, returnDataMap)) {
					return false;
				}
				break;

			default:
				// それ以外の場合
				break;
		}
		return true;
	}

	/**
	 * 「711系基本情報レコードの解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean dataType711Paser01(int rowIndex, VRMap returnDataMap) throws Exception {

		// returnDataMapに9.被保険者番号INSURED_IDと6.サービス提供年月YEAR_AND_MONTHを格納する。
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
			// 18.要介護度状態区分コードを取得してreturnDataMapにBIND PATH CARE_LEVELで格納する
			returnDataMap.setData("CARE_LEVEL", checkCareLevel(getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_15_CARE_LEVEL)));
		} else {
			return false;
		}

		// 被保険者番号から利用者名を取得する、取得した値はBIND PATH NAMEで格納する
		// SQLパラメータ
		// 6.被保険者番号
		// 20.認定有効期間開始年月日
		// 21.認定有効期間終了年月日

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
				// 返却されたPATIENT_FIRST_NAMEとPATIENT_FAMILY_NAMEを間をスペースで区切り結合してNAMEに格納する
				String patientName = ACCastUtilities.toString(patientMap.getData("PATIENT_FAMILY_NAME")) + " " + ACCastUtilities.toString(patientMap.getData("PATIENT_FIRST_NAME"));
				returnDataMap.setData("NAME", patientName);
			} else {
				returnDataMap.setData("NAME", NAME_LESS);
			}
		} else {
			returnDataMap.setData("NAME", NAME_LESS);
		}

		// 集計用に一意のキーを作成して格納する
		String dataIndexStr = getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_6_INSURED_ID) + getInputCSVFile().getValueAtString(rowIndex, BASIC_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH);
		returnDataMap.setData("DATA_INDEX", dataIndexStr);

		return true;
	}

	/**
	 * 「711系明細情報レコードの解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean dataType711Paser02(int rowIndex, VRMap returnDataMap) throws Exception {
		// 識別番号02 明細情報

		// サービス種別を確認する
		// 10.サービス種類コードをBIND_PATHとしてフラグ1を格納する。
		// そのうちフォーマッタ化する
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, DETAIL_RECORD_7_SERVICE_TYPE_CODE))) {
			returnDataMap.setData(getInputCSVFile().getValueAtString(rowIndex, DETAIL_RECORD_7_SERVICE_TYPE_CODE), MATRIX_ON);
			// 集計カウント用フラグを格納する
			returnDataMap.setData("SERVICE_FLAG", ON);
		} else {
			return false;
		}

		// 集計用に一意のキーを作成して格納する
		String dataIndexStr = getInputCSVFile().getValueAtString(rowIndex, DETAIL_RECORD_6_INSURED_ID) + getInputCSVFile().getValueAtString(rowIndex, DETAIL_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH);
		returnDataMap.setData("DATA_INDEX", dataIndexStr);
		return true;
	}

	/**
	 * 「711系特定診療費レコードの解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean dataType711Paser04(int rowIndex, VRMap returnDataMap) throws Exception {
		// 識別番号04 明細情報

		if (getInputCSVFile().getValueAtString(rowIndex, SPECIAL_CLINIC_RECORD_7_SEQUENCE_CODE).equals("99")) {
			returnDataMap.setData("UNIT_TOTAL", ACCastUtilities.toInteger(getInputCSVFile().getValueAtInteger(rowIndex, SPECIAL_CLINIC_RECORD_13_UNIT_TOTAL)));
		} else {
			return false;
		}

		// 集計用に一意のキーを作成して格納する
		String dataIndexStr = getInputCSVFile().getValueAtString(rowIndex, SPECIAL_CLINIC_RECORD_6_INSURED_ID) + getInputCSVFile().getValueAtString(rowIndex, SPECIAL_CLINIC_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH);
		returnDataMap.setData("DATA_INDEX", dataIndexStr);
		return true;
	}

	/**
	 * 「711系集計情報レコードの解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean dataType711Paser10(int rowIndex, VRMap returnDataMap) throws Exception {
		// 9.被保険者番号とoutputTableMapのINSURED_IDが一致するなら
		// 10.サービス種類コードをBIND_PATHとしてフラグ1を格納する。
		// 単位数を取得する
		returnDataMap.setData("UNIT_TOTAL", ACCastUtilities.toInteger(getInputCSVFile().getValueAtInteger(rowIndex, TOTAL_RECORD_14_UNIT_TOTAL)));

		// 保険対象請求額を取得する
		returnDataMap.setData("INSURANCE_AMOUNT", ACCastUtilities.toInteger(getInputCSVFile().getValueAtInteger(rowIndex, TOTAL_RECORD_16_AMOUNT_TOTAL)));
		// System.out.println(insuranceTotal);

		// 集計用に一意のキーを作成して格納する
		String dataIndexStr = getInputCSVFile().getValueAtString(rowIndex, TOTAL_RECORD_6_INSURED_ID) + getInputCSVFile().getValueAtString(rowIndex, TOTAL_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH);
		returnDataMap.setData("DATA_INDEX", dataIndexStr);
		return true;
	}

	/**
	 * 「7111系様式第一レコードの解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean dataRecord7111Parser(int rowIndex) throws Exception {
		
		if (!"1".equals(getInputCSVFile().getValueAtString(rowIndex, CLAIM_RECORD_4_CARE_OR_PUBLIC_EXPENCE_ID))) {
			// 保険分のみを含める
			return false;
		}

		// 請求情報格納用MAPを生成する。
		VRMap claimMap = new VRHashMap();

		// サービス提供年月を取得する
		claimMap.setData("YEAR_AND_MONTH", ACCastUtilities.toDate(getInputCSVFile().getValueAtString(rowIndex, CLAIM_RECORD_2_SERVICE_PROVIDE_YEAR_AND_MONTH) + "01"));

		// 請求情報区分を取得する
		claimMap.setData("CLAIM_STATUS", getInputCSVFile().getValueAtString(rowIndex, CLAIM_RECORD_6_CLAIM_STATUS));

		// 件数を取得する
		claimMap.setData("CLAIM_COUNTS", getInputCSVFile().getValueAtString(rowIndex, CLAIM_RECORD_7_TOTAL_COUNTS));

		// 単位数を取得する
		claimMap.setData("CLAIM_UNIT", getInputCSVFile().getValueAtString(rowIndex, CLAIM_RECORD_8_TOTAL_UNITS));

		// 保険請求額を取得する
		claimMap.setData("CLAIM_AMOUNT", getInputCSVFile().getValueAtString(rowIndex, CLAIM_RECORD_10_TOTAL_AMOUNT));

		getClaimInfoTableList().add(claimMap);
		return true;
	}

	/**
	 * 「812系交換識別情報基本解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean dataRecord812Parser(int rowIndex, VRMap returnDataMap) throws Exception {
		// returnDataMapに9.被保険者番号INSURED_IDと6.サービス提供年月YEAR_AND_MONTHを格納する。
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

		// 18.要介護度状態区分コードを取得してreturnDataMapにBIND PATH CARE_LEVELで格納する
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_12_CARE_LEVEL))) {
			returnDataMap.setData("CARE_LEVEL", checkCareLevel(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_12_CARE_LEVEL)));
		} else {
			return false;
		}

		// 被保険者番号から利用者名を取得する、取得した値はBIND PATH NAMEで格納する
		// SQLパラメータ
		// 6.被保険者番号
		// 20.認定有効期間開始年月日
		// 21.認定有効期間終了年月日

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
				// 返却されたPATIENT_FIRST_NAMEとPATIENT_FAMILY_NAMEを間をスペースで区切り結合してNAMEに格納する
				String patientName = ACCastUtilities.toString(patientMap.getData("PATIENT_FAMILY_NAME")) + " " + ACCastUtilities.toString(patientMap.getData("PATIENT_FIRST_NAME"));
				returnDataMap.setData("NAME", patientName);
			} else {
				returnDataMap.setData("NAME", NAME_LESS);
			}
		} else {
			returnDataMap.setData("NAME", NAME_LESS);
		}

		// 被保険者番号とoutputTableMapのINSURED_IDが一致するなら
		
		// 交換識別番号を調べて
		if (getInputCSVFile().getValueAtString(rowIndex, COMMON_RECORD_FORMAT_3_EXCHANGE_TYPE).equals("8122")) {
			// 介護の場合
			// 43(プラン)をBIND_PATHとしてフラグ1を格納する。
			returnDataMap.setData("43", MATRIX_ON);
			// 集計カウント用フラグを格納する
			returnDataMap.setData("PLAN_FLAG", ON);		
		} else if(getInputCSVFile().getValueAtString(rowIndex, COMMON_RECORD_FORMAT_3_EXCHANGE_TYPE).equals("8123")) {
			// 予防の場合
			// 46(プラン)をBIND_PATHとしてフラグ1を格納する。
			returnDataMap.setData("46", MATRIX_ON);
			// 集計カウント用フラグを格納する
			returnDataMap.setData("PLAN_FLAG", ON);
		}
		
		// 単位数を取得する
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_17_UNIT_TOTAL))) {
			returnDataMap.setData("UNIT_TOTAL", ACCastUtilities.toInteger(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_17_UNIT_TOTAL)));
		} else {
			return false;
		}

		// 保険対象請求額を取得する
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_19_AMOUNT_TOTAL))) {
			returnDataMap.setData("INSURANCE_AMOUNT", ACCastUtilities.toInteger(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_19_AMOUNT_TOTAL)));
		} else {
			return false;
		}

		// 集計用に一意のキーを作成して格納する
		String dataIndexStr = getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_7_INSURED_ID) + getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_4_SERVICE_PROVIDE_YEAR_AND_MONTH);
		returnDataMap.setData("DATA_INDEX", dataIndexStr);

		return true;
	}

	//[ID:0000448][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
	/**
	 * H21.4以降の「812系交換識別情報基本解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean dataRecord812ParserH2104(int rowIndex, VRMap returnDataMap) throws Exception {
		// returnDataMapに9.被保険者番号INSURED_IDと6.サービス提供年月YEAR_AND_MONTHを格納する。
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

		// 18.要介護度状態区分コードを取得してreturnDataMapにBIND PATH CARE_LEVELで格納する
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_12_CARE_LEVEL))) {
			returnDataMap.setData("CARE_LEVEL", checkCareLevel(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_12_CARE_LEVEL)));
		} else {
			return false;
		}

		// 被保険者番号から利用者名を取得する、取得した値はBIND PATH NAMEで格納する
		// SQLパラメータ
		// 6.被保険者番号
		// 20.認定有効期間開始年月日
		// 21.認定有効期間終了年月日

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
				// 返却されたPATIENT_FIRST_NAMEとPATIENT_FAMILY_NAMEを間をスペースで区切り結合してNAMEに格納する
				String patientName = ACCastUtilities.toString(patientMap.getData("PATIENT_FAMILY_NAME")) + " " + ACCastUtilities.toString(patientMap.getData("PATIENT_FIRST_NAME"));
				returnDataMap.setData("NAME", patientName);
			} else {
				returnDataMap.setData("NAME", NAME_LESS);
			}
		} else {
			returnDataMap.setData("NAME", NAME_LESS);
		}

		// 被保険者番号とoutputTableMapのINSURED_IDが一致するなら
		
		// 交換識別番号を調べて
		if (getInputCSVFile().getValueAtString(rowIndex, COMMON_RECORD_FORMAT_3_EXCHANGE_TYPE).equals("8124")) {
			// 介護の場合
			// 43(プラン)をBIND_PATHとしてフラグ1を格納する。
			returnDataMap.setData("43", MATRIX_ON);
			// 集計カウント用フラグを格納する
			returnDataMap.setData("PLAN_FLAG", ON);		
		} else if(getInputCSVFile().getValueAtString(rowIndex, COMMON_RECORD_FORMAT_3_EXCHANGE_TYPE).equals("8125")) {
			// 予防の場合
			// 46(プラン)をBIND_PATHとしてフラグ1を格納する。
			returnDataMap.setData("46", MATRIX_ON);
			// 集計カウント用フラグを格納する
			returnDataMap.setData("PLAN_FLAG", ON);
		}
		
		// 単位数を取得する
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_21_UNIT_TOTAL))) {
			returnDataMap.setData("UNIT_TOTAL", ACCastUtilities.toInteger(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_21_UNIT_TOTAL)));
		} else {
			return false;
		}

		// 保険対象請求額を取得する
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_22_AMOUNT_TOTAL))) {
			returnDataMap.setData("INSURANCE_AMOUNT", ACCastUtilities.toInteger(getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_22_AMOUNT_TOTAL)));
		} else {
			return false;
		}

		// 集計用に一意のキーを作成して格納する
		String dataIndexStr = getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_7_INSURED_ID) + getInputCSVFile().getValueAtString(rowIndex, CAREPLAN_RECORD_4_SERVICE_PROVIDE_YEAR_AND_MONTH);
		returnDataMap.setData("DATA_INDEX", dataIndexStr);

		return true;
	}
	//[ID:0000448][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
	
	
	/**
	 * 「822系交換識別情報基本解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean dataRecord822Parser(int rowIndex, VRMap returnDataMap) throws Exception {
		// returnDataMapに9.被保険者番号INSURED_IDと6.サービス提供年月YEAR_AND_MONTHを格納する。
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

		// 18.要介護度状態区分コードを取得してreturnDataMapにBIND PATH CARE_LEVELで格納する
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_12_CARE_LEVEL))) {
			returnDataMap.setData("CARE_LEVEL", checkCareLevel(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_12_CARE_LEVEL)));
		} else {
			return false;
		}

		// 被保険者番号から利用者名を取得する、取得した値はBIND PATH NAMEで格納する
		// SQLパラメータ
		// 6.被保険者番号
		// 20.認定有効期間開始年月日
		// 21.認定有効期間終了年月日

		VRMap sqlParam = new VRHashMap();

		// INSURED_ID
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_10_INSURED_ID))) {
			sqlParam.setData("INSURED_ID", getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_10_INSURED_ID));
		}

		if (getCanDBConnect()) {
			VRList patientList = getDBManager().executeQuery(getSQL_GET_PATIENT_INFO_MANAGEMENT(sqlParam));

			if (!patientList.isEmpty()) {
				VRMap patientMap = (VRMap) patientList.getData(0);
				// 返却されたPATIENT_FIRST_NAMEとPATIENT_FAMILY_NAMEを間をスペースで区切り結合してNAMEに格納する
				String patientName = ACCastUtilities.toString(patientMap.getData("PATIENT_FAMILY_NAME")) + " " + ACCastUtilities.toString(patientMap.getData("PATIENT_FIRST_NAME"));
				returnDataMap.setData("NAME", patientName);
			} else {
				returnDataMap.setData("NAME", NAME_LESS);
			}
		} else {
			returnDataMap.setData("NAME", NAME_LESS);
		}

		// 被保険者番号とoutputTableMapのINSURED_IDが一致するなら
		// 43(プラン)をBIND_PATHとしてフラグ1を格納する。
		// そのうちフォーマッタ化する

		// 10.サービス種類コードをBIND_PATHとしてフラグ1を格納する。
		// そのうちフォーマッタ化する
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_19_SERVICE_TYPE_CODE))) {
			returnDataMap.setData(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_19_SERVICE_TYPE_CODE), MATRIX_ON);
		} else {
			return false;
		}

		// 集計カウント用フラグを格納する
		returnDataMap.setData("MANAGEMENT_FLAG", ON);

		// 単位数を取得する
		if (!ACTextUtilities.isNullText(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_20_UNIT_TOTAL))) {
			returnDataMap.setData("UNIT_TOTAL", ACCastUtilities.toInteger(getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_20_UNIT_TOTAL)));
		} else {
			return false;
		}

		// 集計用に一意のキーを作成して格納する
		String dataIndexStr = getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_10_INSURED_ID) + getInputCSVFile().getValueAtString(rowIndex, MANAGEMENT_RECORD_2_SERVICE_PROVIDE_YEAR_AND_MONTH);
		returnDataMap.setData("DATA_INDEX", dataIndexStr);

		return true;
	}

	/**
	 * 「解析した行データの結合処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean dataRecordMerge(VRList dataRecordList) throws Exception {
		VRList keyIndexDataList = new VRArrayList();
		Iterator dataRecordIterator = dataRecordList.iterator();
		while (dataRecordIterator.hasNext()) {
			VRMap dataRecordMap = (VRMap) dataRecordIterator.next();

			// キーを抽出
			VRMap dataIndexMap = new VRHashMap();
			dataIndexMap.setData("DATA_INDEX", dataRecordMap.getData("DATA_INDEX"));
			keyIndexDataList.add(dataIndexMap);
		}

		// レコードをユニークに纏める
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
			// 結果を表示用リストに返す
			getOutputTableList().addData(outputMap);
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
