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
 * 作成日: 2006/04/10  日本コンピューター株式会社 廣瀬 一海 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム CSVビュアー (O)
 * プロセス CSVビュアー (012)
 * プログラム CSVビュアー (QO012)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.viewer.qo.qo012;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.io.VRCSVFile;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * CSVビュアーイベント定義(QO012)
 */
public abstract class QO012Event extends QO012SQL {
	/**
	 * コンストラクタです。
	 */
	public QO012Event() {
		addEvents();
	}

	/**
	 * イベント発生条件を定義します。
	 */
	protected void addEvents() {
		getOpenButton().addActionListener(new ActionListener() {
			private boolean lockFlag = false;

			public void actionPerformed(ActionEvent e) {
				if (lockFlag) {
					return;
				}
				lockFlag = true;
				try {
					openButtonActionPerformed(e);
				} catch (Throwable ex) {
					ACCommon.getInstance().showExceptionMessage(ex);
				} finally {
					lockFlag = false;
				}
			}
		});
		getUnitingButton().addActionListener(new ActionListener() {
			private boolean lockFlag = false;

			public void actionPerformed(ActionEvent e) {
				if (lockFlag) {
					return;
				}
				lockFlag = true;
				try {
					unitingButtonActionPerformed(e);
				} catch (Throwable ex) {
					ACCommon.getInstance().showExceptionMessage(ex);
				} finally {
					lockFlag = false;
				}
			}
		});

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
	protected abstract void openButtonActionPerformed(ActionEvent e) throws Exception;

	/**
	 * 「CSVファイル結合」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected abstract void unitingButtonActionPerformed(ActionEvent e) throws Exception;

	// 変数定義

	private VRMap headerMap = new VRHashMap();

	private VRMap providerMap = new VRHashMap();

	private VRList outputTableList = new VRArrayList();

	private VRList totalInfoTableList = new VRArrayList();
	
	private VRList claimInfoTableList = new VRArrayList();

	private String inputCSVFilePath;

	private VRCSVFile inputCSVFile;
	
	private boolean canDBConnect;

	public static final String[] CSV_FILE_EXTENSIONS = { "csv" };

	public static final Integer ON = new Integer(1);

	// 定数定義
	public static final String MATRIX_ON = "○";

	public static final String MEDIA_TYPE4 = "ＦＤ";

	public static final String MEDIA_TYPE3 = "ＭＴ";

	public static final String MEDIA_TYPE2 = "ＭＯ";

	public static final String MEDIA_TYPE1 = "伝送";

	public static final String CSV_FILE_TYPE_821 = "給付管理表情報";
	
	public static final String CSV_FILE_TYPE_812 = "介護給付費請求明細書（居宅サービス計画費）情報";

	public static final String CSV_FILE_TYPE_711 = "介護給付費請求書情報";

	public static final String NURSING_NECESSARY_LEVEL25 = "要介護5";

	public static final String NURSING_NECESSARY_LEVEL24 = "要介護4";

	public static final String NURSING_NECESSARY_LEVEL23 = "要介護3";

	public static final String NURSING_NECESSARY_LEVEL22 = "要介護2";

	public static final String NURSING_NECESSARY_LEVEL21 = "要介護1";

	public static final String NURSING_NECESSARY_LEVEL13 = "要支援2";

	public static final String NURSING_NECESSARY_LEVEL12 = "要支援1";

	public static final String NURSING_NECESSARY_LEVEL11 = "経過的要介護";

	public static final String NURSING_NECESSARY_LEVEL01 = "非該当";

	public static final String NAME_LESS = "";

	public static final String PROVIDER_LESS = "";

	// エラーメッセージ
	public static final String ERROR_TARGET_DATE_NOT_FOUND = "処理対象年月を取得できませんでした";

	public static final String ERROR_PROVIDER_NUMBER_NOT_FOUND = "事業所番号を取得できませんでした";

	public static final String ERROR_MEDIA_TYPE_NOT_FOUND = "媒体区分を取得できませんでした";
	
	public static final String ERROR_SERVICE_PROVIDE_YEAR_AND_MONTH_NOT_FOUND = "サービス提供年月を取得できませんでした";
	
	public static final String ERROR_NON_CORRESPONDENCE_DATA_RECORD_TYPE = "介護給付費請求や居宅サービス計画費を格納したCSVではありません";

	public static final String ERROR_CONTROL_RECORD_NOT_FOUND = "コントロールレコードが存在しません";

	public static final String ERROR_DATA_NOT_FOUND = "データが存在しません";

	public static final String ERROR_CSV_FILE_CAN_NOT_READ = "CSVファイルの読み込みに失敗しました";

	public static final String ERROR_SELECTED_FILE_NOT_FOUND = "選択されたファイルは存在しませんでした";

	public static final String MESSAGE_FILE_OPEN_DIALOG_TITLE = "CSVファイルを指定して下さい";

	public static final String MESSAGE_SPLASH_TEXT1 = "CSVファイルコントロールレコード解析中";
	public static final String MESSAGE_SPLASH_TEXT2 = "CSVファイル情報レコード解析中";
	public static final String MESSAGE_SPLASH_TEXT4 = "CSVファイル集計解析中";

	public static final String MESSAGE_PROGRAM_EXIT = "給付管理/介護報酬請求 CSVファイルビューアを終了してもよろしいですか？";

	public static final String MESSAGE_PROGRAM_TITLE = "給付管理/介護報酬請求 CSVファイルビューア";

	// CONTROL RECORD解析処理のCSVインデックス
	public static final int CONTROL_RECORD_FORMAT_5_DATA_TYPE = 4; // データ種別

	public static final int CONTROL_RECORD_FORMAT_8_PROVIDER_NUMBER = 7; // 事業所番号

	public static final int CONTROL_RECORD_FORMAT_10_MEDIA_TYPE = 9; // 媒体区分

	public static final int CONTROL_RECORD_FORMAT_11_TARGET_YEAR_AND_MONTH = 10; // 処理対象年月

	// 各CSVフォーマット共通のCSVインデックス
	public static final int COMMON_RECORD_FORMAT_1_RECORD_TYPE = 0; // レコード種別

	public static final int COMMON_RECORD_FORMAT_3_EXCHANGE_TYPE = 2; // 交換識別番号(データレコードのフォーマットとしては通しで3番目)

	// データレコード共通
	public static final int DATA_RECORD_FORMAT_711TYPE_2_RECORD_TYPE_CODE = 3; // 711系請求帳票レコード種別コード

	// 基本レコード（711系）のCSVインデックス
	public static final int BASIC_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH = 4; // サービス提供年月

	public static final int BASIC_RECORD_6_INSURED_ID = 7; // 被保険者番号

	public static final int BASIC_RECORD_15_CARE_LEVEL = 16; // 要介護度状態区分コード

	public static final int BASIC_RECORD_18_INSURED_END_DATE = 19; // 認定有効期間開始年月日

	public static final int BASIC_RECORD_17_INSURED_START_DATE = 18; // 認定有効期間終了年月日

	// 明細レコード(711系)のCSVインデックス
	public static final int DETAIL_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH = 4; // サービス提供年月

	public static final int DETAIL_RECORD_6_INSURED_ID = 7; // 被保険者番号
	
	public static final int DETAIL_RECORD_7_SERVICE_TYPE_CODE = 8; // サービス種類コード

	// 特定診療費レコード(711系)のCSVインデックス
	public static final int SPECIAL_CLINIC_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH = 4; // サービス提供年月

	public static final int SPECIAL_CLINIC_RECORD_6_INSURED_ID = 7; // 被保険者番号
	
	public static final int SPECIAL_CLINIC_RECORD_7_SEQUENCE_CODE = 8; // レコード順次番号
	
	public static final int SPECIAL_CLINIC_RECORD_13_UNIT_TOTAL = 14; // 保険合計単位数	
	
	
	// 集計レコード(711系)のCSVインデックス
	public static final int TOTAL_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH = 4; // サービス提供年月
	
	public static final int TOTAL_RECORD_6_INSURED_ID = 7; // 被保険者番号

	public static final int TOTAL_RECORD_14_UNIT_TOTAL = 15; // 保険単位数合計

	public static final int TOTAL_RECORD_27_MEDICAL_UNIT_TOTAL = 28; // 保険分出来高医療費単位数

	public static final int TOTAL_RECORD_16_AMOUNT_TOTAL = 17; // 請求額

	public static final int TOTAL_RECORD_28_MEDICAL_AMOUNT_TOTAL = 29; // 保険分出来高医療費請求額

	// ケアプランレコード(812系)のCSVインデックス
	public static final int CAREPLAN_RECORD_4_SERVICE_PROVIDE_YEAR_AND_MONTH = 5; // サービス提供年月

	public static final int CAREPLAN_RECORD_7_INSURED_ID = 8; // 被保険者番号

	public static final int CAREPLAN_RECORD_12_CARE_LEVEL = 13; // 要介護度区分コード

	public static final int CAREPLAN_RECORD_13_INSURED_START_DATE = 14; // 認定有効期間開始年月日

	public static final int CAREPLAN_RECORD_14_INSURED_END_DATE = 15; // 認定有効期間終了年月日

	public static final int CAREPLAN_RECORD_17_UNIT_TOTAL = 18; // 単位数

	public static final int CAREPLAN_RECORD_19_AMOUNT_TOTAL = 19; // 請求額
	
	//[ID:0000448][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
	public static final int CAREPLAN_RECORD_21_UNIT_TOTAL = 21; // 単位数
	public static final int CAREPLAN_RECORD_22_AMOUNT_TOTAL = 22; // 請求額
	//[ID:0000448][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
	
	// 給付管理情報のインデックス

	public static final int MANAGEMENT_RECORD_2_SERVICE_PROVIDE_YEAR_AND_MONTH = 3; // サービス提供年月
	
	public static final int MANAGEMENT_RECORD_10_INSURED_ID = 10; // 被保険者番号
	
	public static final int MANAGEMENT_RECORD_12_CARE_LEVEL = 13; // 要介護度状態区分
	
	public static final int MANAGEMENT_RECORD_20_UNIT_TOTAL = 21; // 単位数
	
	public static final int MANAGEMENT_RECORD_19_SERVICE_TYPE_CODE = 20; // サービス種別コード
	
	public static final int MANAGEMENT_RECORD_13_INSURED_END_DATE = 14; // 認定有効期間開始年月日

	public static final int MANAGEMENT_RECORD_14_INSURED_START_DATE = 15; // 認定有効期間終了年月日

	
	// 7111のCSVインデックス
	public static final int CLAIM_RECORD_2_SERVICE_PROVIDE_YEAR_AND_MONTH = 3; // サービス提供年月

	public static final int CLAIM_RECORD_3_PROVIDER_ID = 4; // 事業者番号
	
	public static final int CLAIM_RECORD_4_CARE_OR_PUBLIC_EXPENCE_ID = 5; // 保険・公費区分

	public static final int CLAIM_RECORD_6_CLAIM_STATUS = 7; // 請求状態区分

	public static final int CLAIM_RECORD_7_TOTAL_COUNTS = 8; // 合計件数

	public static final int CLAIM_RECORD_8_TOTAL_UNITS = 9; // 合計単位数

	public static final int CLAIM_RECORD_10_TOTAL_AMOUNT = 11; // 合計保険請求額
	
	// [ID:0000623][Shin Fujihara] 2010/11 add begin 2010年度対応
	// データレコード711系
	public static final int BASIC_RECORD_5_INSURER_ID = 6; // 基本情報レコード内 保険者番号インデックス
	public static final int DETAIL_RECORD_5_INSURER_ID = 6; //明細情報レコード内 保険者番号インデックス
	public static final int SPECIAL_CLINIC_RECORD_5_INSURER_ID = 6; // 特定診療費レコード内 保険者番号インデックス
	public static final int TOTAL_RECORD_5_INSURER_ID = 6;  // 集計レコード内 保険者番号インデックス
	
	// データレコード812系 保険者番号インデックス
	public static final int CAREPLAN_RECORD_5_INSURER_ID = 6; // 保険者番号インデックス
	
	// データレコード822系 保険者番号インデックス
	public static final int MANAGEMENT_RECORD_3_INSURER_ID = 4; // 保険者番号インデックス
	// [ID:0000623][Shin Fujihara] 2010/11 add end 2010年度対応

	
	// getter/setter

	/**
	 * headerMapを返します。
	 * 
	 * @return headerMap
	 */
	protected VRMap getHeaderMap() {
		return headerMap;
	}

	/**
	 * headerMapを設定します。
	 * 
	 * @param headerMap
	 *            headerMap
	 */
	protected void setHeaderMap(VRMap headerMap) {
		this.headerMap = headerMap;
	}

	/**
	 * canDBConnectを返します。
	 * 
	 * @return headerMap
	 */
	protected boolean getCanDBConnect() {
		return canDBConnect;
	}

	/**
	 * canDBConnectを設定します。
	 * 
	 * @param headerMap
	 *            headerMap
	 */
	protected void setCanDBConnect(boolean canDBConnect) {
		this.canDBConnect = canDBConnect;
	}

	
	/**
	 * providerMapを返します。
	 * 
	 * @return providerMap
	 */
	protected VRMap getProviderMap() {
		return providerMap;
	}

	/**
	 * providerMapを設定します。
	 * 
	 * @param providerMap
	 *            providerMap
	 */
	protected void setProviderMap(VRMap providerMap) {
		this.providerMap = providerMap;
	}

	/**
	 * outputTableListを返します。
	 * 
	 * @return outputTableList
	 */
	protected VRList getOutputTableList() {
		return outputTableList;
	}

	/**
	 * outputTableListを設定します。
	 * 
	 * @param outputTableList
	 *            outputTableList
	 */
	protected void setOutputTableList(VRList outputTableList) {
		this.outputTableList = outputTableList;
	}

	/**
	 * totalInfoTableListを返します。
	 * 
	 * @return totalInfoTableList
	 */
	protected VRList getTotalInfoTableList() {
		return totalInfoTableList;
	}

	/**
	 * totalInfoTableListを設定します。
	 * 
	 * @param totalInfoTableList
	 *            totalInfoTableList
	 */
	protected void setTotalInfoTableList(VRList totalInfoTableList) {
		this.totalInfoTableList = totalInfoTableList;
	}

	/**
	 * claimInfoTableListを返します。
	 * 
	 * @return claimInfoTableList
	 */
	protected VRList getClaimInfoTableList() {
		return claimInfoTableList;
	}

	/**
	 * claimInfoTableListを設定します。
	 * 
	 * @param claimInfoTableList
	 *            claimInfoTableList
	 */
	protected void setClaimInfoTableList(VRList claimInfoTableList) {
		this.claimInfoTableList = claimInfoTableList;
	}
	
	/**
	 * inputCSVFilePathを返します。
	 * 
	 * @return inputCSVFilePath
	 */
	protected String getInputCSVFilePath() {
		return inputCSVFilePath;
	}

	/**
	 * inputCSVFilePathを設定します。
	 * 
	 * @param inputCSVFilePath
	 *            inputCSVFilePath
	 */
	protected void setInputCSVFilePath(String inputCSVFilePath) {
		this.inputCSVFilePath = inputCSVFilePath;
	}

	/**
	 * inputCSVFileを返します。
	 * 
	 * @return inputCSVFile
	 */
	protected VRCSVFile getInputCSVFile() {
		return inputCSVFile;
	}

	/**
	 * inputCSVFileを設定します。
	 * 
	 * @param inputCSVFile
	 *            inputCSVFile
	 */
	protected void setInputCSVFile(VRCSVFile inputCSVFile) {
		this.inputCSVFile = inputCSVFile;
	}

	// 内部関数

	/**
	 * 「CSVデータ取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @return boolean
	 */
	public abstract boolean csvReader() throws Exception;

	/**
	 * 「コントロールレコード解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @return boolean
	 */
	public abstract boolean controlRecordParser() throws Exception;

	/**
	 * 「データレコード解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @return boolean
	 */
	public abstract boolean dataRecordPaser() throws Exception;

	 /**
	 * 「711系基本情報レコードの解析」に関する処理を行ないます。
	 *
	 * @throws Exception
	 * 処理例外
	 */
	public abstract boolean dataType711Paser01(int rowIndex, VRMap returnDataMap) throws Exception;

	 /**
	 * 「711系明細情報レコードの解析」に関する処理を行ないます。
	 *
	 * @throws Exception
	 * 処理例外
	 */
	public abstract boolean dataType711Paser02(int rowIndex, VRMap returnDataMap) throws Exception;

	 /**
	 * 「711系集計情報レコードの解析」に関する処理を行ないます。
	 *
	 * @throws Exception
	 * 処理例外
	 */
	public abstract boolean dataType711Paser10(int rowIndex, VRMap returnDataMap) throws Exception;

	/**
	 * 「解析した行データの結合処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public abstract boolean dataRecordMerge(VRList dataRecordList) throws Exception;

	/**
	 * 「711系特定診療費レコードの解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public abstract boolean dataType711Paser04(int rowIndex, VRMap returnDataMap) throws Exception;

	/**
	 * 「822系交換識別情報基本解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public abstract boolean dataRecord822Parser(int rowIndex, VRMap returnDataMap) throws Exception;

	/**
	 * 「7111系様式第一レコードの解析」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public abstract boolean dataRecord7111Parser(int rowIndex) throws Exception;

	
}
