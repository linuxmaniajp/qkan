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
 * 開発者: 堤 瑞樹
 * 作成日: 2005/12/15  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 利用者一覧 (001)
 * プログラム 利用者一覧 (QU001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qu.qu001;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACHashMapFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.ac.util.splash.ACSplash;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.component.table.VRSortableTableModel;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qc.qc001.QC001;
import jp.or.med.orca.qkan.affair.qc.qc002.QC002;
import jp.or.med.orca.qkan.affair.qc.qc003.QC003;
import jp.or.med.orca.qkan.affair.qc.qc004.QC004;
import jp.or.med.orca.qkan.affair.qc.qc005.QC005;
import jp.or.med.orca.qkan.affair.qc.qc005.QC005P01;
import jp.or.med.orca.qkan.affair.qc.qc005.QC005P02;
import jp.or.med.orca.qkan.affair.qc.qc006.QC006;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001;
import jp.or.med.orca.qkan.affair.qu.qu002.QU002;
import jp.or.med.orca.qkan.text.QkanPatientListDataTypeFormat;

/**
 * 利用者一覧(QU001)
 */
public class QU001 extends QU001Event {

	/**
	 * コンストラクタです。
	 */
	public QU001() {
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

		// 渡りパラメータを退避する。
		// this.nextAffair = NEXT_AFFAIR (次に遷移する業務ID)
		VRMap param = affair.getParameters();

		// データが存在しているかチェックする。
		// NEXT_AFFAIRの退避
		if (VRBindPathParser.has("NEXT_AFFAIR", param)) {
			setNextAffair(ACCastUtilities.toString(VRBindPathParser.get(
					"NEXT_AFFAIR", param)));
		}

		// データが存在しているかチェックする。
		// PATIENT_IDの退避
		if (VRBindPathParser.has("PATIENT_ID", param)) {
			setPatientId(ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", param)));
		}

		// データが存在しているかチェックする。
		// TARGET_DATEの退避
		if (VRBindPathParser.has("TARGET_DATE", param)) {
			setFindTargetDate((Date) VRBindPathParser.get("TARGET_DATE", param));
		}

		// 渡りパラメータの削除
		param.clear();

		// 初期化を行う。
		initialize();

		// テーブルモデルを定義する。
		ACTableModelAdapter model = new ACTableModelAdapter();

		model.setColumns(new String[] {
				"SHOW_FLAG",
				"SHOW_FLAG",
				"REPORT",
				"FINISH_FLAG",
				"CHOISE",
				"PATIENT_CODE",
				"PATIENT_FAMILY_NAME+'　'+PATIENT_FIRST_NAME",
				"PATIENT_FAMILY_KANA+'　'+PATIENT_FIRST_KANA",
				"PATIENT_SEX",
				"PATIENT_BIRTHDAY",
				"PATIENT_ZIP_FIRST+'-'+PATIENT_ZIP_SECOND",
				"PATIENT_ADDRESS",
				"PATIENT_TEL_FIRST+'-'+PATIENT_TEL_SECOND+'-'+PATIENT_TEL_THIRD",
				"PATIENT_FAMILY_NAME", "PATIENT_FIRST_NAME",
				"PATIENT_FAMILY_KANA", "PATIENT_FIRST_KANA",
				"PATIENT_ZIP_FIRST", "PATIENT_ZIP_SECOND", "PATIENT_TEL_FIRST",
				"PATIENT_TEL_SECOND", "PATIENT_TEL_THIRD", "JOTAI_CODE",
				"INSURED_ID", "INSURE_VALID_START", "INSURE_VALID_END"
				// [ID:0000637][Shin Fujihara] 2011/03 add begin 2010年度対応
				, "INSURER_ID"
		// [ID:0000637][Shin Fujihara] 2011/03 add begin 2010年度対応
		});

		setPatientTableModel(model);

		// アダプタをテーブルのモデルとして設定する。
		getPatients().setModel(getPatientTableModel());

		// テーブルカラムにフォーマッタを設定する。
		getPatientEnabledColumn().setFormat(
				new ACHashMapFormat(new String[] {
						"jp/nichicom/ac/images/icon/pix16/btn_080.png",
						"jp/nichicom/ac/images/icon/pix16/btn_079.png" },
						new Integer[] { new Integer(0), new Integer(1), }));

		/** 2007年度対応 */
		// フォーマッタの設定を行う
		getPatientReportColumn().setFormat(
				new ACHashMapFormat(new String[] { "",
						"jp/nichicom/ac/images/icon/pix16/btn_013.png" },
						new Integer[] { new Integer(0), new Integer(1), }));

		getPatientFinishFlagColumn().setFormat(
				new QkanPatientListDataTypeFormat(getNextAffair()));

		// 検索を行う。
		doFind();

	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}

		// 前画面に戻る。
		// 前画面への遷移を許可するならばtrueを返す。
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}

		// システムを終了する。
		// 終了を許可するならばtrueを返す。
		return true;
	}

	// コンポーネントイベント

	/**
	 * 「検索」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void findActionPerformed(ActionEvent e) throws Exception {
		// 検索を行う。
		doFind();
	}

	/**
	 * 「詳細画面に遷移」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void detailActionPerformed(ActionEvent e) throws Exception {

		// PATIENT_IDを格納するpatientIdを定義する。
		int patientId;

		// ※入力チェック
		// 入力チェックを行う。
		if (!checkValue()) {
			return;
		}

		// 画面の「利用者一覧(patients)」の行が選択されているかどうかチェックする。
		if (!getPatients().isSelected()) {
			// 選択されていない場合
			// 何もしない。
			return;
		} else {
			// 選択されている場合
			// 選択されている利用者の「利用者ID(PATIENT_ID)」を取得する。
			patientId = ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", (VRMap) getPatients()
							.getSelectedModelRowValue()));

		}

		// 次画面に遷移する。
		transferNext(patientId);
	}

	/**
	 * 「詳細画面に遷移」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {
		// ※次画面に遷移

		// 次画面への渡りパラメータ格納用にレコード paramを生成する。
		VRMap param = new VRHashMap();

		// 次画面遷移のためのパラメータ ACAffairInfo affair を定義する。
		ACAffairInfo affair = null;

		if ("QU002".equals(getNextAffair())) {
			// 「QU002」の場合

			// paramに下記パラメータを設定する。
			// KEY : PROCESS_MODE, VALUE : PROCESS_MODE_INSERT
			VRBindPathParser.set("PROCESS_MODE", param, new Integer(
					QkanConstants.PROCESS_MODE_INSERT));

			// 下記パラメータにてaffairを生成する。
			affair = new ACAffairInfo(QU002.class.getName(), param);

		}

		// NEXT_AFFAIRを画面遷移前にフレームに退避しておく。
		ACFrame.getInstance().addNowAffairParameter("NEXT_AFFAIR",
				getNextAffair());

		// ※渡り処理
		// 次画面に遷移する。
		ACFrame.getInstance().next(affair);

	}

	/**
	 * 「サービス予定に遷移」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void planInsertActionPerformed(ActionEvent e) throws Exception {
		// ※サービス予定に遷移

		// PATIENT_IDを格納するpatientIdを定義する。
		int patientId;

		// ※次画面に渡す値の取得
		// 入力チェックを行う。
		if (!checkValue()) {
			return;
		}

		// 画面の「利用者一覧(patients)」の行が選択されているかどうかチェックする。
		if (!getPatients().isSelected()) {
			// 選択されていない場合

			// 処理を中断する。
			return;

		} else {
			// 選択されている場合

			// 選択されている利用者の「利用者ID(PATIENT_ID)」を取得する。
			patientId = ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", (VRMap) getPatients()
							.getSelectedModelRowValue()));

		}

		if (!checkInsureInfo(patientId)) {
			// 利用者の要介護情報をチェックする。
			return;
		}

		// 次画面に遷移する。
		transferNext(patientId);

	}

	/**
	 * 「サービス実績に遷移」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void resultInsertActionPerformed(ActionEvent e) throws Exception {
		// ※サービス実績に遷移

		// PATIENT_IDを格納するpatientIdを定義する。
		int patientId;

		// 入力チェックを行う。
		if (!checkValue()) {
			return;
		}

		// 画面の「利用者一覧(patients)」の行が選択されているかどうかチェックする。
		if (!getPatients().isSelected()) {
			// 選択されていない場合

			// 処理を中断する。
			return;

		} else {
			// 選択されている場合

			// 選択されている利用者の「利用者ID(PATIENT_ID)」を取得する。
			patientId = ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", (VRMap) getPatients()
							.getSelectedModelRowValue()));

		}

		// 利用者の要介護情報をチェックする。
		if (!checkInsureInfo(patientId)) {
			return;
		}

		// 次画面に遷移する。
		transferNext(patientId);

	}

	/**
	 * 「利用者削除」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void deleteActionPerformed(ActionEvent e) throws Exception {
		// ※画面で選択された利用者の削除

		// 選択されているレコードのモデルのインデックスを格納するmodelRowを定義する。
		int modelRow;

		// 選択されているレコードの画面上のインデックスを格納するsortedRowを定義する。
		int sortedRow;

		// ※入力チェック
		// 画面の「利用者一覧(patients)」の行が選択されているかどうかチェックする。
		if (!getPatients().isSelected()) {
			// 選択されていない場合

			// 処理を中断する。
			return;

		} else {
			// 選択されている場合

			// 選択行のインデックス(モデルではなく画面上)を取得する。
			modelRow = getPatients().getSelectedModelRow();
			sortedRow = getPatients().getSelectedSortedRow();
		}

		// ※処理確認
		// 削除確認メッセージを表示する。※メッセージID = WARNING_OF_DELETE
		if (QkanMessageList.getInstance().WARNING_OF_DELETE("選択中の利用者情報") == ACMessageBox.RESULT_CANCEL) {
			// 「キャンセル」を選択した場合(削除中断)
			// 処理を中断する。
			return;
		}

		try {

			// トランザクション開始
			getDBManager().beginTransaction();

			// ※パッシブチェック
			// パッシブタスクをクリアする。
			getPassiveChecker().clearPassiveTask();

			// パッシブタスクを登録する。
			getPassiveChecker().addPassiveUpdateTask(getPASSIVE_CHECK_KEY(),
					modelRow);

			// パッシブチェックを実行する。
			if (!(getPassiveChecker().passiveCheck(getDBManager()))) {
				// パッシブエラーがある場合

				// パッシブエラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
				QkanMessageList.getInstance()
						.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();

				// トランザクション解除
				getDBManager().rollbackTransaction();

				// 処理を中断する。(異常終了)
				return;
			}

			// パッシブエラーがない場合
			// 処理を続行する。
			// ※削除
			// 選択行の「利用者ID(PATIENT_ID)」を取得する。
			int patientId = ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", (VRMap) getPatientData().get(modelRow)));

			// SQL文取得関数に渡すレコード sqlParamを生成する。
			VRMap sqlParam = new VRHashMap();

			// sqlParamに下記の値を設定する。
			// KEY : PATIENT_ID, VALUE : (取得した利用者ID)
			VRBindPathParser
					.set("PATIENT_ID", sqlParam, new Integer(patientId));

			// 利用者情報削除用のSQL文を取得する。
			String strSql = getSQL_DELETE_PATIENT(sqlParam);

			// 取得したSQL文を発行する。
			getDBManager().executeUpdate(strSql);

			// 上記のSQL発行処理でエラーがなかった場合
			// 処理をコミットする。
			getDBManager().commitTransaction();

			// 再検索して、最新のデータを取得する。
			doFind();

			// 削除した行の1行上の行を選択する。
			getPatients().setSelectedSortedRowOnAfterDelete(sortedRow);

			// // 処理完了通知メッセージを表示する。※メッセージID = DELETE_SUCCESSED
			// QkanMessageList.getInstance().DELETE_SUCCESSED();

		} catch (Exception ex) {
			// エラーがあった場合
			// 処理をロールバックする。
			// 処理を中断する。(異常終了)
			getDBManager().rollbackTransaction();

			// 上位クラスに例外を返す。
			throw ex;
		}

	}

	/**
	 * 「セル選択」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void patientsSelectionChanged(ListSelectionEvent e)
			throws Exception {

		// 画面の「利用者一覧(patients)」の行が選択されているかどうかチェックする。
		if (!getPatients().isSelected()) {
			// 選択されていない場合

			// 業務ボタンの状態を変更する。
			setState_UNSELECTED();

		} else {
			// 選択されている場合
			// 業務ボタンの状態を変更する。
			setState_SELECTED();

		}
	}

	/**
	 * 「ダブルクリック」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void patientsMouseClicked(MouseEvent e) throws Exception {

		// PATIENT_IDを格納するpatientIdを定義する。
		int patientId;

		// ※入力チェック
		// 　入力チェックを行う。
		if (!checkValue()) {
			return;
		}

		// 画面の「利用者一覧(patients)」の行が選択されているかどうかチェックする。
		if (!getPatients().isSelected()) {
			// 選択されていない場合
			// 何もしない。
			return;
		} else {
			// 選択されている場合
			// 選択されている利用者の「利用者ID(PATIENT_ID)」を取得する。
			patientId = ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", (VRMap) getPatients()
							.getSelectedModelRowValue()));
		}

		if ("QS001".equals(getNextAffair()) || "QR001".equals(getNextAffair())) {
			// 予定・実績画面へ遷移する場合
			// 利用者の要介護情報をチェックする。
			if (!checkInsureInfo(patientId)) {
				return;
			}
		}

		// 次画面に遷移する。
		transferNext(patientId);

	}

	/**
	 * 「利用者一覧印刷」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void printActionPerformed(ActionEvent e) throws Exception {
		// ※利用者一覧の印刷

		// ※前準備
		// 印刷クラスに渡すレコード printParamを生成する。
		VRMap printParam = new VRHashMap();

		// ※渡すパラメータの取得
		// 利用者一覧データ
		VRList printList = new VRArrayList();
		VRList sourceList = getPatientData();
		VRMap row;
		String providerId;

		VRSortableTableModel sorterModel;
		// ソータであるかチェックする
		if (getPatients().getModel() instanceof VRSortableTableModel) {
			sorterModel = (VRSortableTableModel) getPatients().getModel();
			for (int i = 0; i < sourceList.getDataSize(); i++) {
				// ソーターを利用してモデルから画面上の順にデータ格納しなおす
				int rowIndex = sorterModel.getTranslateIndex(i);

				row = (VRMap) sourceList.getData(rowIndex);

				// 居宅介護支援事業所名の取得
				providerId = ACCastUtilities.toString(VRBindPathParser.get(
						"PROVIDER_ID", row));

				if (!(providerId == null || "".equals(providerId))) {
					// 事業所情報を取得する。
					VRList providerList = (VRList) QkanCommon.getProviderInfo(
							getDBManager(), providerId);

					if (providerList.getDataSize() > 0) {
						// 利用者情報に居宅介護支援事業所名を加える。
						VRBindPathParser
								.set("PROVIDER_NAME", row, VRBindPathParser
										.get("PROVIDER_NAME",
												(VRBindSource) providerList
														.getData(0)));
					}
				}

				printList.addData(row);
			}
		}

		// 利用者情報を、printParamのKEY : PARAMのVALUEとして設定する。
		VRBindPathParser.set("PARAM", printParam, printList);

		// ※印刷
		// 印刷する。
		QU001P01 qu001p01 = new QU001P01();
		ACChotarouXMLWriter writer = new ACChotarouXMLWriter();

		// 印刷開始を宣言
		writer.beginPrintEdit();

		// 印刷クラスへ処理を渡す。
		qu001p01.doPrint(writer, printParam);

		// 印刷終了を宣言
		writer.endPrintEdit();

		// PDFファイルを生成して開く。
		ACChotarouXMLUtilities.openPDF(writer);

	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();

		// 仮起動
		VRHashMap param = new VRHashMap();
		param.setData("NEXT_AFFAIR", "QU002");
		// Date date = new Date();
		// param.setData("PATIENT_ID", new Integer(111));
		// param.setData("PATIENT_ID", date);
		ACFrame.debugStart(new ACAffairInfo(QU001.class.getName(), param));
		// ACFrame.debugStart(new ACAffairInfo(QU001.class.getName()));
	}

	/**
	 * 「初期化処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void initialize() throws Exception {
		// ※初期化処理

		// ※ウィンドウタイトル・業務ボタンバーの設定
		setAffairTitle(AFFAIR_ID, getNextAffair(), getButtons());

		// 画面の初期状態を設定する。nextAffairの値によって、設定が分岐する。

		if ("QU002".equals(getNextAffair())) {
			// 「QU002」の場合

			// パッシブキーの定義
			setPASSIVE_CHECK_KEY(new ACPassiveKey("PATIENT",
					new String[] { "PATIENT_ID" }, new Format[] { null },
					"LAST_TIME", "LAST_TIME"));

			// QU002用の設定を行う。
			setState_INIT_PATIENT();

		} else if ("QS001".equals(getNextAffair())) {
			// 「QS001」の場合

			// QS001用の設定を行う。
			setState_INIT_SERVICE_PLAN();

		} else if ("QR001".equals(getNextAffair())) {
			// 「QR001」の場合

			// QR001用の設定を行う。
			setState_INIT_SERVICE_RESULT();

		} else if ("QC001".equals(getNextAffair())) {
			// 「QC001」の場合

			// QC001用の設定を行う。
			setState_INIT_HOMONKANGO_PLAN();

			// [ID:0000667][Masahiko.Higuchi] 2012/12 add begin 平成24年4月の初期設定対応
			// 帳票系業務のみ許可
			getTargetDate()
					.setMinimumDate(ACCastUtilities.toDate("2006/04/01"));
			// [ID:0000667][Masahiko.Higuchi] 2012/12 add end

		} else if ("QC002".equals(getNextAffair())) {
			// 「QC002」の場合

			// QC002用の設定を行う。
			setState_INIT_HOMONKANGO_RESULT();

			// [ID:0000667][Masahiko.Higuchi] 2012/12 add begin 平成24年4月の初期設定対応
			// 帳票系業務のみ許可
			getTargetDate()
					.setMinimumDate(ACCastUtilities.toDate("2006/04/01"));
			// [ID:0000667][Masahiko.Higuchi] 2012/12 add end

		} else if ("QC003".equals(getNextAffair())) {
			// 「QC003」の場合

			// QC003用の設定を行う。
			setState_INIT_HOMONKANGO_JOHO_TEIKYOSHO();

			// [ID:0000667][Masahiko.Higuchi] 2012/12 add begin 平成24年4月の初期設定対応
			// 帳票系業務のみ許可
			getTargetDate()
					.setMinimumDate(ACCastUtilities.toDate("2006/04/01"));
			// [ID:0000667][Masahiko.Higuchi] 2012/12 add end

		} else if ("QC004".equals(getNextAffair())) {
			// 「QC004」の場合

			// QC004用の設定を行う。
			setState_INIT_HOMONKANGO_KIROKUSHO();

			// [ID:0000667][Masahiko.Higuchi] 2012/12 add begin 平成24年4月の初期設定対応
			// 帳票系業務のみ許可
			getTargetDate()
					.setMinimumDate(ACCastUtilities.toDate("2006/04/01"));
			// [ID:0000667][Masahiko.Higuchi] 2012/12 add end

		// [2014年要望][Shinobu Hitaka] 2014/12/02 add - begin 居宅療養管理指導書一覧追加
		//} else if ("QC005".equals(getNextAffair())) {
		} else if ("QC005".equals(getNextAffair()) || "QC006".equals(getNextAffair())) {
		// [2014年要望][Shinobu Hitaka] 2014/12/02 add - end   居宅療養管理指導書一覧追加
			
			// 「QC005」の場合

			// 2008/01/07 [Masahiko Higuchi] del - begin 居宅療養管理指導書一括印刷
			// QC005用の設定を行う。
			// setState_INIT_KYOTAKU();
			// 2008/01/07 [Masahiko Higuchi] del - end
			// 2008/01/07 [Masahiko Higuchi] add - begin 居宅療養管理指導書一括印刷
			doInitializeQC005();
			// 2008/01/07 [Masahiko Higuchi] add - end

			// [ID:0000667][Masahiko.Higuchi] 2012/12 add begin 平成24年4月の初期設定対応
			// 帳票系業務のみ許可
			getTargetDate()
					.setMinimumDate(ACCastUtilities.toDate("2006/04/01"));
			// [ID:0000667][Masahiko.Higuchi] 2012/12 add end

        }

		// ※対象年月の設定
		// システムから、「システム日付」を取得する。
		if (getFindTargetDate() == null) {
			// 渡りパラメータとして、TARGET_DATEが渡されていない場合

			Date sysDate = QkanSystemInformation.getInstance().getSystemDate();
			
			// [H27.4改正対応][Shinobu Hitaka] 2015/02/20 edit begin 平成27年4月の初期設定対応
			if (("QS001".equals(getNextAffair()) || "QR001"
					.equals(getNextAffair()))
					&& (ACDateUtilities.compareOnDay(sysDate,
							QkanConstants.H2704) < 0)) {
				sysDate = QkanConstants.H2704;
			}
			// [H27.4改正対応][Shinobu Hitaka] 2015/02/20 edit end

			// [ID:0000667][Masahiko.Higuchi] 2012/04 edit begin 平成27年4月の初期設定対応
			if (("QS001".equals(getNextAffair()) || "QR001"
					.equals(getNextAffair()))
					&& (ACDateUtilities.compareOnDay(sysDate,
							QkanConstants.H2404) < 0)) {
				sysDate = QkanConstants.H2404;
			}
			// [ID:0000667][Masahiko.Higuchi] 2012/04 edit end

			if (ACDateUtilities.compareOnDay(sysDate, QkanConstants.H1904) < 0) {
				// システム日付が平成19年4月以前の日付の場合
				getTargetDate().setDate(QkanConstants.H1904);
			} else {
				// システム日付が平成19年4月以降の日付の場合
				// 画面の「対象年月(targetDate)」に、取得したシステム日付を設定する。
				getTargetDate().setDate(sysDate);
			}

		} else {
			// 渡りパラメータとして、TARGET_DATEが渡されている場合

			// 渡されたTARGET_DATEを画面の「対象年月(targetDate)」に設定する。
			getTargetDate().setDate(getFindTargetDate());

			// 二重に使用されないよう削除する。
			setFindTargetDate(null);

		}
	}

	/**
	 * 「検索」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFind() throws Exception {
		// ※DBから利用者一覧を取得、画面に設定

		// ※検索準備
		// SQL文取得関数に渡すレコード sqlParamを生成する。
		VRMap sqlParam = new VRHashMap();

		// 検索条件の取得
		VRMap selectKey = new VRHashMap();

		getFindConditions().setSource(selectKey);
		getFindConditions().applySource();

		// ※利用者コードの取得
		String patientCode = ACCastUtilities.toString(selectKey
				.get("PATIENT_CODE"));

		// 画面の「利用者コード(patientCode)」のTextを取得し、危険文字の置換を行う。
		patientCode = QkanCommon.toFindString(patientCode);

		if (patientCode.length() > 0) {
			// 取得した文字列が存在する場合(文字列長が0より大きい場合)

			// 取得した文字列をsqlParamの KEY : PATIENT_CODE の VALUE として設定する。
			VRBindPathParser.set("PATIENT_CODE", sqlParam, patientCode);

		}

		// ※ふりがなの取得
		String patientKana = ACCastUtilities.toString(selectKey
				.get("PATIENT_KANA"));

		// 画面の「ふりがな(patientKana)」のTextを取得し、危険文字の置換を行う。
		patientKana = QkanCommon.toFindString(patientKana);

		if (patientKana.length() > 0) {
			// 取得した文字列が存在する場合(文字列長が0より大きい場合)
			// 取得した文字列をsqlParamの KEY : PATIENT_KANA の VALUE として設定する。
			VRBindPathParser.set("PATIENT_KANA", sqlParam, patientKana);

		}

		// ※生年月日の取得
		if (getBirthday().isValidDate()) {
			// 存在する日付が入力されている場合

			if (selectKey.get("PATIENT_BIRTHDAY") instanceof Date) {

				// 画面の「生年月日(birthday)」の値を取得する。
				Date birthDay = (Date) selectKey.get("PATIENT_BIRTHDAY");

				// 取得した値をsqlParamの KEY : PATIENT_BIRTHDAY の VALUE として設定する。
				VRBindPathParser.set("PATIENT_BIRTHDAY", sqlParam, birthDay);

			}

		} else {
			// 存在しない日付が入力されている場合

			// フォーカスをあてる。
			getBirthday().requestFocus();

			// エラーメッセージ
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("生年月日の");

			return;

		}

		// ※「現在有効でない利用者を含めて検索」フラグの取得
		// 画面の「現在有効でない利用者も含めて検索(nowNotEnabledPatientIncludeFind)」の値を取得する。
		if (!(selectKey.get("HIDE_FLAG") == null)) {

			int hideFlag = ACCastUtilities.toInt(selectKey.get("HIDE_FLAG"));

			if (hideFlag == 0) {
				// 0の場合(未選択の場合)
				// sqlParamに KEY : HIDE_FLAG, VALUE : null を設定する。
				VRBindPathParser.set("HIDE_FLAG", sqlParam, null);

			}
		}

		// ※DBからデータを取得
		// 検索用SQL文を取得する。
		String strSql = getSQL_GET_PATIENT(sqlParam);

		// 取得したSQL文を発行し、結果をpatientDataに格納する。
		VRList patientData = new VRArrayList();
		patientData = getDBManager().executeQuery(strSql);

        // [2014年要望][Shinobu Hitaka] 2014/12/02 edit begin 居宅療養管理指導書の対象年月に複数登録対応
		// "QC006"を条件に追加
		//
		// 2008/01/07 [Masahiko Higuchi] add - begin 居宅療養管理指導書の一括印刷
		// if ("QC005".equals(getNextAffair())) {
	    if ("QC005".equals(getNextAffair()) || "QC006".equals(getNextAffair())) {
			// 業務独自検索処理
			patientData = doFindQC005(patientData, sqlParam);
			if (patientData == null) {
				// 検索前チェックにかかった場合は処理終了
				return;
			}
		}
		// 2008/01/07 [Masahiko Higuchi] add - end
		//
	    // [2014年要望][Shinobu Hitaka] 2014/12/02 edit end   居宅療養管理指導書の対象年月に複数登録対応
		
		// patientDataを退避する。
		setPatientData(patientData);

		// ※渡すパラメータの取得
		// patientDataの件数分ループする。
		VRMap cur = getNinteiRireki();

		for (int i = 0; i < getPatientData().size(); i++) {
			VRMap row = (VRMap) getPatientData().get(i);

			Object id = row.get("PATIENT_ID");
			if (cur.containsKey(id)) {
				putNinteiRireki(row, (VRMap) cur.get(id));
				continue;
			}
		}

		/*
		 * 過去バージョン for (int i = 0; i < getPatientData().size(); i++) {
		 * 
		 * // PATIENT_ID格納用変数を定義する。 int patientId; // 利用者情報格納用Mapを定義する。 VRMap
		 * patientMap = new VRHashMap(); // 要介護報格納用Listを定義する。 VRList
		 * patientInsureList;
		 * 
		 * // patientDataのKEY : PATIENT_IDのVALUEを取得する(利用者ID)。 patientMap =
		 * (VRMap) getPatientData().get(i); patientId =
		 * ACCastUtilities.toInt(VRBindPathParser.get( "PATIENT_ID",
		 * patientMap));
		 * 
		 * // sqlParamの設定 // 利用者ID追加 VRBindPathParser .set("PATIENT_ID",
		 * sqlParam, new Integer(patientId)); // 現在日付追加
		 * VRBindPathParser.set("NOW_DATE", sqlParam, new Date());
		 * 
		 * // 現在日付時点の要介護情報を取得する。 // SQL文の取得 strSql =
		 * getSQL_GET_NINTEI_NOW(sqlParam);
		 * 
		 * // SQL文の実行 patientInsureList = getDBManager().executeQuery(strSql);
		 * 
		 * // 現在日付時点の要介護情報が0件の場合 if (patientInsureList.size() == 0) {
		 * 
		 * // 現在日付より未来の要介護情報のうち直近の情報を取得する。 // SQL文の取得 strSql =
		 * getSQL_GET_NINTEI_FUTURE(sqlParam);
		 * 
		 * // SQL文の実行 patientInsureList = getDBManager().executeQuery(strSql);
		 * 
		 * if (patientInsureList.size() == 0) {
		 * 
		 * // 現在日付より過去の要介護情報のうち直近の情報を取得する。 // SQL文の取得 strSql =
		 * getSQL_GET_NINTEI_PAST(sqlParam);
		 * 
		 * // SQL文の実行 patientInsureList = getDBManager().executeQuery(strSql);
		 * 
		 * } }
		 * 
		 * // 取得した要介護情報が1件以上の場合 if (patientInsureList.size() > 0) {
		 * 
		 * // 要介護情報レコードを取り出す。 VRMap map = (VRMap) patientInsureList.get(0);
		 * 
		 * // 利用者情報に以下の値を追加する。 // 被保険者番号 VRBindPathParser.set("INSURED_ID",
		 * patientMap, VRBindPathParser.get("INSURED_ID", map)); // 要介護度
		 * VRBindPathParser.set("JOTAI_CODE", patientMap,
		 * VRBindPathParser.get("JOTAI_CODE", map)); // 有効期間終了
		 * VRBindPathParser.set("INSURE_VALID_END", patientMap,
		 * VRBindPathParser.get("INSURE_VALID_END", map)); // 有効期間開始
		 * VRBindPathParser.set("INSURE_VALID_START", patientMap,
		 * VRBindPathParser.get("INSURE_VALID_START", map));
		 * 
		 * // [ID:0000637][Shin Fujihara] 2011/03 add begin 2010年度対応 // 保険者番号
		 * VRBindPathParser.set("INSURER_ID", patientMap,
		 * VRBindPathParser.get("INSURER_ID", map)); // [ID:0000637][Shin
		 * Fujihara] 2011/03 add begin 2010年度対応 } }
		 */

		// ※取得したデータを画面に展開
		getPatientTableModel().setAdaptee(patientData);

		// patientDataの件数をチェックする。
		if (patientData.size() > 0) {

			// 退避した利用者IDをチェックする。
			if (getPatientId() == 0) {
				// 利用者IDが渡されていなかった場合

				// 画面の「利用者一覧(patients)」の1行目を選択する。
				getPatients().setSelectedSortedFirstRow();

			} else {
				// 利用者IDが渡されていた場合

				// 渡された利用者IDを持つ利用者を選択する。
				int index = ACCommon.getInstance().getMatchIndexFromValue(
						getPatientData(), "PATIENT_ID",
						new Integer(getPatientId()));

				if (index == -1) {

					// 該当する利用者がいなかった場合、1行目を選択する。
					getPatients().setSelectedSortedFirstRow();

				} else {

					// 該当する利用者がいた場合、該当利用者を選択する。
					getPatients().setSelectedModelRow(index);
					getPatients().scrollSelectedToVisible();
				}

				// 二重に使用されないように削除する。
				setPatientId(0);

			}
		} else {
			// 業務ボタンの状態を変更する。
			setState_UNSELECTED();
		}

		// ※パッシブキーの再登録
		// パッシブキーをクリアする。
		getPassiveChecker().clearReservedPassive();

		// パッシブキーを登録する。
		getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
				getPatientData());

		// ステータスバー
		// setStatusText("");

		// フォーカス
		if (getTargetDate().getParent().isVisible()) {
			getTargetDate().requestFocus();
		} else {
			getPatientCode().requestFocus();
		}

	}

	// 認定履歴データを設定する
	private void putNinteiRireki(VRMap row, VRMap riki) throws Exception {
		VRBindPathParser.set("INSURED_ID", row,
				VRBindPathParser.get("INSURED_ID", riki));
		VRBindPathParser.set("JOTAI_CODE", row,
				VRBindPathParser.get("JOTAI_CODE", riki));
		VRBindPathParser.set("INSURE_VALID_END", row,
				VRBindPathParser.get("INSURE_VALID_END", riki));
		VRBindPathParser.set("INSURE_VALID_START", row,
				VRBindPathParser.get("INSURE_VALID_START", riki));
		VRBindPathParser.set("INSURER_ID", row,
				VRBindPathParser.get("INSURER_ID", riki));
		VRBindPathParser.set("PROVIDER_ID", row,
				VRBindPathParser.get("PROVIDER_ID", riki));
	}

	// 利用者の認定履歴を取得する
	private VRMap getNinteiRireki() throws Exception {

		Date now = QkanSystemInformation.getInstance().getSystemDate();

		VRList list = getDBManager().executeQuery(getSQL_GET_NINTEI_ALL(null));
		VRMap result = new VRHashMap();
		// PATIENT_ID

		for (int i = 0; i < list.size(); i++) {
			VRMap row = (VRMap) list.get(i);

			Object id = row.get("PATIENT_ID");
			// 日付1 < 日付2 → 0より小さい値
			// 日付1 > 日付2 → 0より大きい値
			// 日付1 = 日付2 → 0
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//			Date start = (Date) row.get("INSURE_VALID_START");
//			Date end = (Date) row.get("INSURE_VALID_END");
			Date start = (Date) row.get("SYSTEM_INSURE_VALID_START");
			Date end = (Date) row.get("SYSTEM_INSURE_VALID_END");
// 2014/12/17 [Yoichiro Kamei] mod - end
			// 期間範囲内
			if ((ACDateUtilities.compareOnDay(start, now) <= 0)
					&& (ACDateUtilities.compareOnDay(end, now) >= 0)) {
				// 一番当たりなので常に上書き
				row.put("marge_state", new Integer(0));
				result.put(id, row);
				continue;
			}

			// 未来
			if (ACDateUtilities.compareOnDay(start, now) >= 0) {
				// 設定されていなければ、とりあえず入れる
				if (!result.containsKey(id)) {
					row.put("marge_state", new Integer(1));
					result.put(id, row);
					continue;
				}

				VRMap target = (VRMap) result.get(id);
				// 既に一番いいのが入っていたら処理キャンセル
				int flag = ((Integer) target.get("marge_state")).intValue();
				if (flag == 0) {
					continue;

					// 過去分データが入っていたら上書きして終了
				} else if (flag == 2) {
					row.put("marge_state", new Integer(1));
					result.put(id, row);
					continue;
				}

				// 入っているデータとどちらが近未来か比較
				// 入っているデータより今のデータが小さい場合は設定
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//				Date fur = (Date) target.get("INSURE_VALID_START");
				Date fur = (Date) target.get("SYSTEM_INSURE_VALID_START");
// 2014/12/17 [Yoichiro Kamei] mod - end
				if (ACDateUtilities.compareOnDay(start, fur) < 0) {
					row.put("marge_state", new Integer(1));
					result.put(id, row);
				}
				continue;
			}

			// 過去
			if (ACDateUtilities.compareOnDay(end, now) <= 0) {
				// 設定されていなければ、とりあえず入れる
				if (!result.containsKey(id)) {
					row.put("marge_state", new Integer(2));
					result.put(id, row);
					continue;
				}

				VRMap target = (VRMap) result.get(id);
				// 既に一番いいのや未来のが入っていたら処理キャンセル
				int flag = ((Integer) target.get("marge_state")).intValue();
				if (flag <= 1) {
					continue;
				}

				// 入っているデータとどちらが今に近いか比較
				// 入っているデータより今のデータが小さい場合は設定
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//				Date pas = (Date) target.get("INSURE_VALID_END");
				Date pas = (Date) target.get("SYSTEM_INSURE_VALID_END");
// 2014/12/17 [Yoichiro Kamei] mod - end
				if (ACDateUtilities.compareOnDay(pas, end) < 0) {
					row.put("marge_state", new Integer(2));
					result.put(id, row);
				}
				continue;
			}

		}

		return result;
	}

	/**
	 * データを手動検索します。
	 * 
	 * @param targetList
	 * @param findParam
	 * @param keys
	 * @return
	 * @throws Exception
	 */
	public VRList doMultiFind(VRList targetList, VRMap findParam, String[] keys)
			throws Exception {
		// 不正な値が引数なので初期値で返す
		if (targetList == null || targetList.isEmpty()) {
			return new VRArrayList();
		}
		boolean isFindKey = false;
		// 検索キーの存在の有無
		for (int i = 0; i < keys.length; i++) {
			if (findParam.containsKey(keys[i])) {
				// 存在有の場合はループを終了
				isFindKey = true;
				break;
			}
		}
		// パラメーターが不正もしくは検索キーは未入力
		if (findParam == null || !isFindKey) {
			// 何もせずに返す
			return targetList;
		}

		// 事業所等名
		// 介護支援専門員
		for (int j = 0; j < keys.length; j++) {
			// 検索キーの存在の有無
			if (findParam.containsKey(keys[j])) {
				// 手動検索
				targetList = filterData(targetList, findParam, keys[j]);
			}
		}

		return targetList;
	}

	/**
	 * 検索キーを元に対象のデータ集合をフィルタリングします。
	 * 
	 * @param targetList
	 * @param findParam
	 * @param filterKey
	 * @return
	 */
	public VRList filterData(VRList targetList, VRMap findParam,
			String filterKey) throws Exception {
		VRMap editMap = new VRHashMap();
		VRList resultList = new VRArrayList();
		String convValue;
		// リストの数ループ処理
		for (int i = 0; i < targetList.size(); i++) {
			if (targetList.getData(i) instanceof VRMap) {
				// 比較行を取り出す
				editMap = (VRMap) targetList.getData(i);
				// 比較する値を取り出す
				convValue = ACCastUtilities.toString(
						editMap.getData(filterKey), "");
				// 比較処理
				if (convValue.equals(findParam.getData(filterKey))) {
					resultList.add(editMap);
				}
			}
		}

		return resultList;
	}

	/**
	 * 「画面遷移処理」に関する処理を行います。
	 * 
	 * @param 一覧テーブルで選択されている利用者の利用者ID
	 * @throws Exception
	 *             処理例外
	 */
	public void transferNext(int patientId) throws Exception {

		// ステータスバーに選択された利用者の名前を表示する。
		VRMap patientData = ACBindUtilities.getMatchRowFromValue(
				getPatientData(), "PATIENT_ID", new Integer(patientId));
		String familyName = ACCastUtilities.toString(VRBindPathParser.get(
				"PATIENT_FAMILY_NAME", patientData));
		String firstName = ACCastUtilities.toString(VRBindPathParser.get(
				"PATIENT_FIRST_NAME", patientData));
		setStatusText(QkanCommon.toFullName(familyName, firstName)
				+ "さんが選択されました。");

		// 次画面への渡りパラメータ格納用にレコード paramを生成する。
		VRMap param = new VRHashMap();

		// ※渡りパラメータの設定
		// 次画面遷移のためのパラメータ NCAffairInfo affair を定義する。
		// affair(new ACAffair());
		ACAffairInfo affair = null;

		if ("QU002".equals(getNextAffair())) {
			// 「QU002」の場合

			// paramに下記パラメータを設定する。
			// KEY : PROCESS_MODE, VALUE : PROCESS_MODE_UPDATE
			// KEY : PATIENT_ID, VALUE : (取得した利用者ID)
			VRBindPathParser.set("PROCESS_MODE", param, new Integer(
					QkanConstants.PROCESS_MODE_UPDATE));
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));

			// 下記パラメータにてaffairを生成する。
			// className : QU002.class.getName(), parameters : param
			affair = new ACAffairInfo(QU002.class.getName(), param);

		} else if ("QC001".equals(getNextAffair())) {
			// 「QC001」の場合

			// paramに下記パラメータを設定する。
			// KEY : PATIENT_ID, VALUE : (取得した利用者ID)
			// KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());

			// 下記パラメータにてaffairを生成する。
			// className : QC001.class.getName(), parameters : param
			affair = new ACAffairInfo(QC001.class.getName(), param);

		} else if ("QC002".equals(getNextAffair())) {
			// 「QC002」の場合

			// paramに下記パラメータを設定する。
			// KEY : PATIENT_ID, VALUE : (取得した利用者ID)
			// KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());

			// 下記パラメータにてaffairを生成する。
			// className : QC002.class.getName(), parameters : param
			affair = new ACAffairInfo(QC002.class.getName(), param);

		} else if ("QC003".equals(getNextAffair())) {
			// 「QC003」の場合

			// paramに下記パラメータを設定する。
			// KEY : PATIENT_ID, VALUE : (取得した利用者ID)
			// KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());

			// 下記パラメータにてaffairを生成する。
			// className : QC003.class.getName(), parameters : param
			affair = new ACAffairInfo(QC003.class.getName(), param);

		} else if ("QC004".equals(getNextAffair())) {
			// 「QC004」の場合

			// paramに下記パラメータを設定する。
			// KEY : PATIENT_ID, VALUE : (取得した利用者ID)
			// KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());

			// 下記パラメータにてaffairを生成する。
			// className : QC004.class.getName(), parameters : param
			affair = new ACAffairInfo(QC004.class.getName(), param);

		} else if ("QC005".equals(getNextAffair())) {
			// 「QC005」の場合

			// paramに下記パラメータを設定する。
			// KEY : PATIENT_ID, VALUE : (取得した利用者ID)
			// KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());

			// 下記パラメータにてaffairを生成する。
			// className : QC005.class.getName(), parameters : param
			affair = new ACAffairInfo(QC005.class.getName(), param);

		} else if ("QC006".equals(getNextAffair())) {
			// [2014年要望][Shinobu Hitaka] 2014/12/02 add begin 居宅療養管理指導書の対象年月に複数登録対応
			// 「QC006」の場合
			
			// paramに下記パラメータを設定する。
			// KEY : PATIENT_ID, VALUE : (取得した利用者ID)
			// KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());
			
			// 下記パラメータにてaffairを生成する。
			// className : QC006.class.getName(), parameters : param
			affair = new ACAffairInfo(QC006.class.getName(), param);
			
			// [2014年要望][Shinobu Hitaka] 2014/12/02 add begin 居宅療養管理指導書の対象年月に複数登録対応

		} else if ("QS001".equals(getNextAffair())) {
			// 「QS001」の場合

			// paramに下記パラメータを設定する。
			// KEY : PATIENT_ID, VALUE : 利用者ID
			// KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
			// KEY : PROCESS_TYPE, VALUE : PROCESS_TYPE_PLAN
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());
			VRBindPathParser.set("PROCESS_TYPE", param, new Integer(
					QkanConstants.PROCESS_TYPE_PLAN));

			// 上記パラメータにてaffairを生成する。
			// className : QS001.class.getName(), parameters : param
			affair = new ACAffairInfo(QS001.class.getName(), param, true);

		} else if ("QR001".equals(getNextAffair())) {
			// 「QR001」の場合

			// paramに下記パラメータを設定する。
			// KEY : PATIENT_ID, VALUE : (取得した利用者ID)
			// KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
			// KEY : PROCESS_TYPE, VALUE : PROCESS_TYPE_RESULT
			VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
			VRBindPathParser.set("TARGET_DATE", param, getTargetDate()
					.getDate());
			VRBindPathParser.set("PROCESS_TYPE", param, new Integer(
					QkanConstants.PROCESS_TYPE_RESULT));

			// 下記パラメータにてaffairを生成する。
			// className : QR001.class.getName(), parameters : param
			affair = new ACAffairInfo(QS001.class.getName(), param, true);

		}

		// NEXT_AFFAIR, TARGET_DATEを画面遷移前にフレームに退避しておく。
		ACFrame.getInstance().addNowAffairParameter("NEXT_AFFAIR",
				getNextAffair());
		ACFrame.getInstance().addNowAffairParameter("TARGET_DATE",
				getTargetDate().getDate());
		ACFrame.getInstance().addNowAffairParameter("PATIENT_ID",
				new Integer(patientId));

		// ※遷移処理
		// 次画面に遷移する。
		ACFrame.getInstance().next(affair);

	}

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * 
	 * @return エラーがない場合true エラーがある場合false
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkValue() throws Exception {
		// ※入力チェック
		// 画面の「対象年月(targetDate)」に値が入力されているかどうかチェックする。

		if ("".equals(getTargetDate().getText())) {
			// 入力されていない場合
			// フォーカスをあてる。
			getTargetDate().requestFocus();

			// メッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("対象年月");

			return false;
		}

		if (!getTargetDate().isValidDate()) {
			// 存在しない日付が入力されている場合
			// フォーカスをあてる。
			getTargetDate().requestFocus();

			// メッセージを表示する。※メッセージID = ERROR_OF_WRONG_DATE
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("対象年月の");

			return false;

		}

		if (ACDateUtilities.compareOnDay(getTargetDate().getDate(),
				TARGET_DATE_20060401) < 0) {
			// 平成18年4月以前の日付が入力されている場合
			// フォーカスをあてる。
			getTargetDate().requestFocus();

			// メッセージを表示する。※メッセージID = ERROR_OF_WRONG_DATE
			QkanMessageList.getInstance()
					.QU001_ERROR_OF_DATE_BEFORE_LAW_CHANGE();

			return false;

		}

		return true;

	}

	/**
	 * 「利用者の要介護情報チェック」に関する処理を行います。
	 * 
	 * @param チェックを行う対象利用者の利用者ID
	 * @return 要介護度を持っている場合true 持っていない場合false
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkInsureInfo(int patientId) throws Exception {
		// 選択された利用者の情報(基本情報・要介護度情報)を取得する。
		Date targetDate = getTargetDate().getDate();
		VRList list = QkanCommon.getPatientInsureInfoOnEndOfMonth(
				getDBManager(), targetDate, patientId);
		
		//[ID:0000749][Shin Fujihara] 2012/09 edit begin 2012年度対応 施設情報有効期間切れのチェック
//		if ((list.size() == 0)
//				|| !(QkanCommon.isFullDecisionPatientInsureInfo(getDBManager(),
//						targetDate, patientId))) {
//			// 要介護度情報が取得できなかった場合
//			// もしくは申請中の要介護情報が存在する場合
//
//			// 処理続行確認メッセージを表示する。※メッセージID = QU001_HAS_NO_YOKAIGODO
//			if (QkanMessageList.getInstance().QU001_HAS_NO_YOKAIGODO() == ACMessageBox.RESULT_CANCEL) {
//				// キャンセル選択時(処理中断時)
//
//				// 処理を中断する。
//				return false;
//
//			}
//		}
		
		
		int msgFlag = 0;
		int msgResult = ACMessageBox.RESULT_OK;
		
		// 要介護度の有効期間切れチェック
		if ((list.size() == 0) || !(QkanCommon.isFullDecisionPatientInsureInfo(getDBManager(), targetDate, patientId))) {
			// 要介護度情報が取得できなかった場合
			// もしくは申請中の要介護情報が存在する場合
			msgFlag += 1;
		}
		
		// 施設情報の有効期間切れチェック
		VRMap sqlParam = new VRHashMap();
		VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities.toString(patientId));
		list = getDBManager().executeQuery(getSQL_GET_SHISETSU_HISTORY_ALL(sqlParam));
		
		if (list.size() > 0) {
			
			msgFlag += 2;
			
			for (int i = 0; i < list.size(); i++) {
				VRMap row = (VRMap)list.get(i);
				
				Date validStart = ACCastUtilities.toDate(row.get("SHISETSU_VALID_START"), null);
				Date validEnd = ACCastUtilities.toDate(row.get("SHISETSU_VALID_END"), null);
				
				if ((validStart == null) || (validEnd == null)) {
					continue;
				}
				
				int diff = ACDateUtilities.getDuplicateTermCheck(validStart, validEnd, targetDate, targetDate);
				
				//「重ならない」以外の結果であれば有効データあり
				if (diff != ACDateUtilities.DUPLICATE_NONE) {
					msgFlag -= 2;
					break;
				}
			}
		}
		
		// [H27.4改正対応][Shinobu Hitaka] 2015/3/12 add - begin
		// 公費情報の有効期間切れチェック
		VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities.toString(patientId));
		VRBindPathParser.set("TARGET_DATE_START", sqlParam, ACDateUtilities.addMonth(targetDate, -1));
		VRBindPathParser.set("TARGET_DATE_END", sqlParam, ACDateUtilities.toLastDayOfMonth(targetDate));
		list = getDBManager().executeQuery(getSQL_GET_PATIENT_KOHI(sqlParam));
		if (list.size() > 0) {
			msgFlag += 4;
		}
		// [H27.4改正対応][Shinobu Hitaka] 2015/3/12 add - begin
		
		switch(msgFlag) {
		case 0: //エラーなし
			return true;
			
		case 1: //要介護度期間切れ
			msgResult = QkanMessageList.getInstance().QU001_HAS_NO_YOKAIGODO();
			break;
			
		case 2: //施設情報期間切れ
			msgResult = QkanMessageList.getInstance().QU001_HAS_NO_SHISETSU();
			break;
			
		case 3: //要介護度期間切れ、かつ施設情報期間切れ
			msgResult = QkanMessageList.getInstance().QU001_HAS_NO_YOKAIGODO_AND_SHISETSU();
			break;
			
		case 4: //公費情報期間切れ [H27.4改正対応][Shinobu Hitaka] 2015/3/12 add
			msgResult = QkanMessageList.getInstance().QU001_HAS_NO_KOHI();
			break;
			
		case 5: //公費情報期間切れ、かつ要介護度期間切れ [H27.4改正対応][Shinobu Hitaka] 2015/3/12 add
			msgResult = QkanMessageList.getInstance().QU001_HAS_NO_YOKAIGODO_AND_KOHI();
			break;
			
		case 6: //公費情報期間切れ、かつ施設情報期間切れ [H27.4改正対応][Shinobu Hitaka] 2015/3/12 add
			msgResult = QkanMessageList.getInstance().QU001_HAS_NO_SHISETSU_AND_KOHI();
			break;
			
		case 7: //公費情報期間切れ、かつ要介護度期間切れ、かつ施設情報期間切れ [H27.4改正対応][Shinobu Hitaka] 2015/3/12 add
			msgResult = QkanMessageList.getInstance().QU001_HAS_NO_YOKAIGODO_AND_SHISETSU_AND_KOHI();
			break;
		}
		
		//キャンセル押下時は、処理中断
		if (msgResult == ACMessageBox.RESULT_CANCEL) {
			return false;
		}
		
		//[ID:0000749][Shin Fujihara] 2012/09 edit end 2012年度対応 施設情報有効期間切れのチェック

		return true;

	}

	public Component getFirstFocusComponent() {

		if (getTargetDate().getParent().isVisible()) {
			return getTargetDate();
		} else {
			return getPatientCode();
		}

	}

	/**
	 * 印刷処理を行います。
	 * 
	 * @author Masahiko Higuchi
	 * @since version 5.4.1
	 * 
	 */
	protected void printReportActionPerformed(ActionEvent e) throws Exception {
		
		// [2014年要望][Shinobu Hitaka] 2014/12/02 edit begin 居宅療養管理指導書の対象年月に複数登録対応
	    //if ("QC005".equals(getNextAffair())) {
		if ("QC005".equals(getNextAffair()) || "QC006".equals(getNextAffair())) {
		// [2014年要望][Shinobu Hitaka] 2014/12/02 edit end   居宅療養管理指導書の対象年月に複数登録対応
			
			// テーブルよりデータを取得
			VRList patientList = (VRList) getPatientTableModel().getAdaptee();
			// 印刷前チェック
			int result = checkPrintData(patientList);
			// 印刷対象データ格納要
			VRList printData = new VRArrayList();
			ACSplash splash = null;
			
			// [2014年要望][Shinobu Hitaka] 2015/01/05 add begin 居宅療養管理指導書の対象年月に複数登録対応
			// 印刷対象が「印刷済を含めない」または「全て」かを確認する
			int printMode = 0;
			if (result == PRINT_NORMAL || result == PRINT_EMPTY_AND_TARGET || result == PRINT_NO_SELECT){
				int msgID = QkanMessageList.getInstance().QU001_WARNING_OF_PRINT_MODE();
				if (msgID == ACMessageBox.RESULT_CANCEL) {
					return;
				} else if (msgID == ACMessageBox.RESULT_YES) {
					printMode = 0;
				} else {
					printMode = 1;
				}
			}
			// [2014年要望][Shinobu Hitaka] 2015/01/05 add end   居宅療養管理指導書の対象年月に複数登録対応
			
			switch (result) {
			case PRINT_NORMAL: // 正常
			case PRINT_EMPTY_AND_TARGET: // データ混合（印刷続行）
				try {
					// [2014年要望][Shinobu Hitaka] 2015/01/05 add begin 居宅療養管理指導書の対象年月に複数登録対応
					boolean isPrint = false;
					// [2014年要望][Shinobu Hitaka] 2015/01/05 add end
					
					// スプラッシュの生成
					splash = (ACSplash) ACFrame.getInstance()
							.getFrameEventProcesser()
							.createSplash("居宅療養管理指導書印刷");
					for (int i = 0; i < patientList.size(); i++) {
						VRMap editMap = (VRMap) patientList.getData(i);
						// 選択有
						if (new Boolean(true).equals(VRBindPathParser.get(
								"CHOISE", editMap))) {
							// 居宅療養管理指導データ
							if (VRBindPathParser.has("TARGET_DATE", editMap)) {
								
								// [2014年要望][Shinobu Hitaka] 2015/01/05 edit begin 居宅療養管理指導書の対象年月に複数登録対応
								// 検索時に保持した居宅療養管理指導情報より利用者と印刷未完了で絞り込み印刷する
								//--del begin
								// 検索時に保持した居宅療養管理指導情報より利用者で絞り込み全て印刷する
								//printData.add(editMap);
								//--del end
								//--add begin
								//印刷確定フラグを保持する
								int finishFlag = ACCastUtilities.toInt(editMap.getData("FINISH_FLAG"),0);
								//複数の居宅療養管理指導書を取得する
								VRList kyotakuData = doFindPrintDataQC006(editMap, printMode);
								for (int k = 0; k < kyotakuData.size(); k++) {
									VRMap kyotakuMap = new VRHashMap();
									kyotakuMap = (VRMap) kyotakuData.get(k);
									editMap.putAll(kyotakuMap);
									printData.add(QkanValidServiceCommon.deepCopyVRMap(editMap));
									
									// 印刷対象あり
									isPrint = true;
								}
								//印刷確定フラグを元に戻す
								VRBindPathParser.set("FINISH_FLAG", editMap, finishFlag);
								//--add end
								// [2014年要望][Shinobu Hitaka] 2015/01/05 edit end   居宅療養管理指導書の対象年月に複数登録対応
							}
						}
					}
					// [2014年要望][Shinobu Hitaka] 2015/01/05 add begin 居宅療養管理指導書の対象年月に複数登録対応
					// 印刷対象が存在しない場合
					if (!isPrint) {
						QkanMessageList.getInstance()
								.QU001_ERROR_OF_NO_PRINT_DATA("居宅療養管理指導書");
						return;
					}
					// [2014年要望][Shinobu Hitaka] 2015/01/05 add end 
					// 印刷処理
					if (!doPrintQC005(printData)) {
						// 印刷失敗時
						QkanMessageList.getInstance().ERROR_OF_PRINT();
						return;
					}
				} finally {
					// スプラッシュを終了する。
					if (splash != null) {
						splash.close();
						splash = null;
					}
				}
				break;
			case PRINT_NO_SELECT: // データ選択無し（続行）
				try {
					boolean isPrint = false;
					splash = (ACSplash) ACFrame.getInstance()
							.getFrameEventProcesser()
							.createSplash("居宅療養管理指導書印刷");
					for (int i = 0; i < patientList.size(); i++) {
						VRMap editMap = (VRMap) patientList.getData(i);
						// 居宅療養管理指導データ
						if (VRBindPathParser.has("TARGET_DATE", editMap)) {
							// 選択ありに設定する。
							VRBindPathParser.set("CHOISE", editMap,
									new Boolean(true));
							
							// [2014年要望][Shinobu Hitaka] 2014/12/02 edit begin 居宅療養管理指導書の対象年月に複数登録対応
							// 検索時に保持した居宅療養管理指導情報より利用者と印刷未完了で絞り込み印刷する
							//--del begin
							// 検索時に保持した居宅療養管理指導情報より利用者で絞り込み全て印刷する
							//printData.add(editMap);
							//--del end
							//--add begin
							//印刷確定フラグを保持する
							int finishFlag = ACCastUtilities.toInt(editMap.getData("FINISH_FLAG"),0);
							//複数の居宅療養管理指導書を取得する
							VRList kyotakuData = doFindPrintDataQC006(editMap, printMode);
							for (int k = 0; k < kyotakuData.size(); k++) {
								VRMap kyotakuMap = new VRHashMap();
								kyotakuMap = (VRMap) kyotakuData.get(k);
								editMap.putAll(kyotakuMap);
								printData.add(QkanValidServiceCommon.deepCopyVRMap(editMap));

								// 印刷対象あり
								isPrint = true;
							}
							//印刷確定フラグを元に戻す
							VRBindPathParser.set("FINISH_FLAG", editMap, finishFlag);
							//--add end
							//--del begin
							// 最低でも1件は印刷データがある。
							//isPrint = true;
							//--del end
							// [2014年要望][Shinobu Hitaka] 2014/12/02 edit end   居宅療養管理指導書の対象年月に複数登録対応
						}
					}
					// 印刷対象が存在しない場合
					if (!isPrint) {
						QkanMessageList.getInstance()
								.QU001_ERROR_OF_NO_PRINT_DATA("居宅療養管理指導書");
						return;
					}
					// 印刷処理
					if (!doPrintQC005(printData)) {
						// 印刷失敗時
						QkanMessageList.getInstance().ERROR_OF_PRINT();
						return;
					}
					// テーブル再描画
					getPatients().repaint();
				} finally {
					// スプラッシュを終了する。
					if (splash != null) {
						splash.close();
						splash = null;
					}
				}
				break;
			case PRINT_ERROR: // エラーまたはキャンセル
				// 処理終了
				return;
			}
			// 印刷履歴を確定する場合
			if (QkanMessageList.getInstance().QP001_PRINT_COMMIT() == ACMessageBox.RESULT_YES) {
				// トランザクションの開始
				getDBManager().beginTransaction();
				try {
					// テーブルの件数ループ処理
					for (int i = 0; i < patientList.size(); i++) {
						VRMap updateMap = (VRMap) patientList.get(i);
						// 印刷対象である場合
						if (new Boolean(true).equals(updateMap
								.getData("CHOISE"))
								&& new Integer(1).equals(updateMap
										.getData("REPORT"))) {
							VRMap updateParam = new VRHashMap();
							// 印刷済みコード
							int printedCode = QkanPatientListDataTypeFormat
									.getPrintedCode(getNextAffair(),
											updateMap.getData("FINISH_FLAG"));
							// テーブルにもデータを反映する
							updateMap.setData("FINISH_FLAG",
									ACCastUtilities.toInteger(printedCode));
							// パラメーター設定
							updateParam.setData("FINISH_FLAG",
									ACCastUtilities.toInteger(printedCode));
							updateParam.setData("PATIENT_ID",
									updateMap.getData("PATIENT_ID"));
							updateParam.setData("TARGET_DATE",
									updateMap.getData("TARGET_DATE"));
							// [2014年要望][Shinobu Hitaka] 2014/12/02 add begin 居宅療養管理指導書の対象年月に複数登録対応
							updateParam.setData("TARGET_DATE_START",
									ACDateUtilities.toFirstDayOfMonth(ACCastUtilities.toDate(updateMap.getData("TARGET_DATE"))));
							updateParam.setData("TARGET_DATE_END",
									ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(updateMap.getData("TARGET_DATE"))));
							setFinishFlagQC006(updateMap.getData("PATIENT_ID"));
							// [2014年要望][Shinobu Hitaka] 2014/12/02 add end   居宅療養管理指導書の対象年月に複数登録対応
							// 更新処理
							getDBManager()
									.executeUpdate(
											getSQL_UPDATE_KYOTAKU_RYOYO_FINISH_FLAG(updateParam));
						}
					}

					// データをコミットする。
					getDBManager().commitTransaction();

				} catch (Exception sqlExp) {
					// ロールバックする。
					getDBManager().rollbackTransaction();
				}
			}
			// テーブルの再描画処理
			getPatients().repaint();
		}
	}

	/**
	 * 事業所コンボ選択時処理
	 * 
	 * @since version 5.4.1
	 * @author Masahiko Higuchi
	 */
	protected void providerNameActionPerformed(ActionEvent e) throws Exception {
		// Mapを生成
		VRMap comboItemMap = new VRHashMap();
		// 空白選択に対応
		if (getProviderName().getSelectedModelItem() instanceof VRMap) {
			// 現在選択中のコンボからレコードを取得
			comboItemMap = (VRMap) getProviderName().getSelectedModelItem();

			if (comboItemMap != null) {
				// 介護支援専門員を取得
				VRList senmoninList = getDBManager().executeQuery(
						getSQL_GET_CARE_MANAGER(comboItemMap));

				if (senmoninList != null && senmoninList.size() > 0) {
					for (int i = 0; i < senmoninList.size(); i++) {
						VRMap map = new VRHashMap();
						map = (VRMap) senmoninList.getData(i);
						// 専門員の名前を取得し姓名を結合する。
						map.setData("STAFF_NAME", QkanCommon.toFullName(
								ACCastUtilities.toString(map
										.getData("STAFF_FAMILY_NAME")),
								ACCastUtilities.toString(map
										.getData("STAFF_FIRST_NAME"))));
					}
				}
				// バインドパスを設定
				comboItemMap.setData("SENMONIN", senmoninList);
				// 画面に展開
				getSenmonin().setModelSource(comboItemMap);
				getSenmonin().bindModelSource();
			}
		} else {
			// 未選択時は空白で格納する
			VRList blankList = new VRArrayList();
			comboItemMap.setData("SENMONIN", blankList);
			getSenmonin().setModelSource(comboItemMap);
			getSenmonin().bindModelSource();
		}
	}

	/**
	 * 居宅療養管理指導の一覧初期化処理
	 * 
	 * @since version 5.4.1
	 * @author Masahiko Higuchi
	 */
	public void doInitializeQC005() throws Exception {
		// QC005用の設定を行う。
		setState_INIT_KYOTAKU();
		// 事業所情報の取得
		VRList providerList = QkanCommon.getProviderInfo(getDBManager());
		// 事業所情報を設定
		VRMap comboItemMap = new VRHashMap();
		comboItemMap.setData("PROVIDER_NAMES", providerList);
		// モデル設定
		getProviderFindContents().setModelSource(comboItemMap);
		// モデル反映
		getProviderFindContents().bindModelSource();
	}

	/**
	 * 居宅療養管理指導の一覧検索処理
	 * 
	 * @since version 5.4.1
	 * @author Masahiko Higuchi
	 */
	public VRList doFindQC005(VRList patientData, VRMap sqlParam)
			throws Exception {
		// 対象年月
		if (getTargetDate().isValidDate()) {
			// 画面の「対象年月」の値を取得する。
			Date targetDate = getTargetDate().getDate();
			// 取得した値をsqlParamの KEY : DATE_START の VALUE として設定する。
			VRBindPathParser.set("DATE_START", sqlParam,
					ACDateUtilities.toFirstDayOfMonth(targetDate));
			// 取得した値をsqlParamの KEY : DATE_END の VALUE として設定する。
			VRBindPathParser.set("DATE_END", sqlParam,
					ACDateUtilities.toLastDayOfMonth(targetDate));
			// 項目が選択されている場合
			if (getProviderName().getSelectedModelItem() instanceof VRMap) {
				VRMap providerMap = (VRMap) getProviderName()
						.getSelectedModelItem();
				String providerName = ACCastUtilities.toString(VRBindPathParser
						.get("PROVIDER_NAME", providerMap));
				VRBindPathParser.set("PROVIDER_NAME", sqlParam, providerName);
			}
			// 項目が選択されている場合
			if (getSenmonin().getSelectedModelItem() instanceof VRMap) {
				VRMap senmoninMap = (VRMap) getSenmonin()
						.getSelectedModelItem();
				String senmoninName = ACCastUtilities.toString(VRBindPathParser
						.get("STAFF_NAME", senmoninMap));
				VRBindPathParser.set("SENMONIN", sqlParam, senmoninName);
			}
			// 居宅療養管理データ取得用SQL
			String strKyotakuSql = getSQL_GET_KYOTAKU_RYOYO_PATIENT(sqlParam);
			// 格納用データ群
			VRList kyotakuData = new VRArrayList();
			kyotakuData = getDBManager().executeQuery(strKyotakuSql);
			
			// [2014年要望][Shinobu Hitaka] 2014/12/02 add begin 居宅療養管理指導書の対象年月に複数登録対応
			setKyotakuData(kyotakuData);
			// [2014年要望][Shinobu Hitaka] 2014/12/02 add begin 居宅療養管理指導書の対象年月に複数登録対応
			
			// データ数ループ処理
			for (int j = 0; j < patientData.size(); j++) {
				VRMap patientMap = new VRHashMap();
				patientMap = (VRMap) patientData.get(j);
				// 利用者の数ループ処理
				for (int k = 0; k < kyotakuData.size(); k++) {
					VRMap kyotakuMap = new VRHashMap();
					kyotakuMap = (VRMap) kyotakuData.get(k);
					// 居宅療養管理指導のデータがある場合は有効にする。
					if (VRBindPathParser.get("TARGET_DATE", kyotakuMap) != null
							&& patientMap.getData("PATIENT_ID").equals(
									kyotakuMap.getData("PATIENT_ID"))) {
						// 選択有
						patientMap.setData("REPORT", new Integer(1));
						
						// [2014年要望][Shinobu Hitaka] 2014/12/02 del begin 居宅療養管理指導書の対象年月に複数登録対応
						// 　　　　　　　　　　　　　　　　　　　　　　　　　印刷状態は、複数あるので最後に設定する
						// 印刷状態
						//patientMap.setData(
						//		"FINISH_FLAG",
						//		ACCastUtilities.toInteger(
						//				kyotakuMap.getData("FINISH_FLAG"), 0));
						// [2014年要望][Shinobu Hitaka] 2014/12/02 del end   居宅療養管理指導書の対象年月に複数登録対応
						
						// 選択チェックのフラグが入っていない場合
						if (!patientMap.containsKey("CHOISE")) {
							patientMap.setData("CHOISE", new Boolean(false));
						}
						// 全ての帳票データを持たせておく
						patientMap.putAll(kyotakuMap);
						// 一致した場合は次の対象者へ
						
						// [2014年要望][Shinobu Hitaka] 2014/12/02 add begin 居宅療養管理指導書の対象年月に複数登録対応
						//-- 全ての印字済ならON、それ以外はOFFとする
						patientMap.setData("FINISH_FLAG", getFinishFlagQC006(kyotakuMap));
						// [2014年要望][Shinobu Hitaka] 2014/12/02 add end   居宅療養管理指導書の対象年月に複数登録対応
						
						break;
					} else {
						// 帳票が未選択の場合のみ
						if (!patientMap.containsKey("CHOISE")) {
							patientMap.setData("CHOISE", new Boolean(false));
							patientMap.setData("REPORT", new Integer(0));
						}
					}
				}
			}
			// 手動検索処理
			String[] keys = { "PROVIDER_NAME", "SENMONIN" };
			// [2014年要望][Shinobu Hitaka] 2014/12/02 add begin 居宅療養管理指導書の対象年月に複数登録対応
			//patientData = doMultiFind(patientData, sqlParam, keys);
			patientData = doMultiFindQC006(patientData, sqlParam, keys);
			// [2014年要望][Shinobu Hitaka] 2014/12/02 edit end   居宅療養管理指導書の対象年月に複数登録対応
			
			return patientData;

		} else {
			// エラーメッセージ
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("対象年月の");
			// フォーカスを当てる
			getTargetDate().requestFocus();

			return null;

		}
	}

	/**
	 * 居宅療養管理指導書の一括印刷処理
	 * 
	 * @author Masahiko Higuchi
	 * @since version 5.4.1
	 */
	public boolean doPrintQC005(VRList printData) throws Exception {

		QC005P01 pageCreater1 = new QC005P01();
		QC005P02 pageCreater2 = new QC005P02();
		ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
		
		// 印刷対象がなければエラー 2015/01/04 add Hitaka
		if (printData.size() == 0) {
			return false;
		}
		
		// 印刷開始
		writer.beginPrintEdit();

		for (int i = 0; i < printData.size(); i++) {
			VRMap printParam = parseQC005PrintData((VRMap) printData.getData(i));
			// 1枚目
			if (!pageCreater1.doPrint(writer, printParam)) {
				// 何らかのエラーが発生した場合
				return false;
			}
			// 2枚目
			if (!pageCreater2.doPrint(writer, printParam)) {
				return false;
			}
		}
		// 印刷終了
		writer.endPrintEdit();
		// 帳票の生成
		ACChotarouXMLUtilities.openPDF(writer);

		return true;
	}

	/**
	 * 印刷対象のデータをチェックします。
	 * 
	 * @return 0:正常 1:データ選択無し(続行) 2:印刷対象・対象外データの混合データ(続行) 99:エラー(処理キャンセル）
	 * @since version 5.4.1
	 * @author Masahiko Higuchi
	 * 
	 */
	public int checkPrintData(VRList patientData) throws Exception {
		// 利用者情報を一括取得
		boolean isPrintData = false; // 印刷対象データが選択されているか
		boolean isEmptyDataSelect = false; // 印刷対象外データを選択しているか
		boolean isPrintDataToAllPatient = false; // 印刷可能なデータはあるか（全利用者）

		for (int i = 0; i < patientData.size(); i++) {
			VRMap editMap = (VRMap) patientData.getData(i);
			// 選択がTRUEの場合
			if (new Boolean(true).equals(VRBindPathParser
					.get("CHOISE", editMap))) {
				// 居宅療養管理指導のデータが存在しているか
				if (VRBindPathParser.has("TARGET_DATE", editMap)) {
					isPrintData = true;
					isPrintDataToAllPatient = true;
				} else {
					// 対象外データ選択有
					isEmptyDataSelect = true;
				}
				// 両方変更済みの場合はループ終了
				if (isPrintData && isEmptyDataSelect) {
					break;
				}
			} else {
				// 居宅療養管理指導のデータが存在しているか
				if (VRBindPathParser.has("TARGET_DATE", editMap)) {
					isPrintDataToAllPatient = true;
				}
			}
		}
		// 全利用にデータが存在しない
		if (!isPrintDataToAllPatient) {
			QkanMessageList.getInstance().QU001_ERROR_OF_NO_PRINT_DATA(
					"居宅療養管理指導書");
			return PRINT_ERROR;
		}
		// 印刷対象データなし And 対象外データ選択あり
		// 対象外だけが選択されている
		if (!isPrintData && isEmptyDataSelect) {
			QkanMessageList.getInstance().QU001_ERROR_OF_NO_PRINT_DATA(
					"居宅療養管理指導書");
			return PRINT_ERROR;
		}
		// 印刷対象データなし And 対象外データ選択なし
		// 全く選択されていない
		if (!isPrintData && !isEmptyDataSelect) {
			if (QkanMessageList.getInstance()
					.QU001_WARNING_OF_PRINT_TARGET_NO_SELECT("居宅療養管理指導書") == ACMessageBox.RESULT_OK) {
				// 続行
				return PRINT_NO_SELECT;
			} else {
				// キャンセル
				return PRINT_ERROR;
			}
		}
		// 印刷対象データあり And 対象外データあり
		// 正常・異常混合
		if (isPrintData && isEmptyDataSelect) {
			if (QkanMessageList.getInstance()
					.QU001_WARNING_OF_EMPTY_DATA_REPORT_MIXED("居宅療養管理指導書") == ACMessageBox.RESULT_OK) {
				// 続行
				return PRINT_EMPTY_AND_TARGET;
			} else {
				// キャンセル
				return PRINT_ERROR;
			}
		}
		// 正常
		return PRINT_NORMAL;
	}

	/**
	 * 帳票印刷用のデータ変換処理を行います。
	 * 
	 * @param 帳票データ
	 * @return 変換後のデータ（1利用者帳票データ）
	 * @since version 5.4.1
	 * @author Masahiko Higuchi
	 * 
	 */
	public VRMap parseQC005PrintData(VRMap printParam) throws Exception {
		VRMap parseParam = new VRHashMap();

		parseParam = (VRMap) printParam.clone();

		String patientName = QkanCommon.toFullName(
				VRBindPathParser.get("PATIENT_FAMILY_NAME", printParam),
				VRBindPathParser.get("PATIENT_FIRST_NAME", printParam));
		// 利用者名
		VRBindPathParser.set("PATIENT_NAME", parseParam, patientName);
		// 変換処理用のKEY群
		String convKeys[] = { "VISIT_THIS_MONTH_NO1", "VISIT_THIS_MONTH_NO2",
				"VISIT_THIS_MONTH_NO3", "VISIT_THIS_MONTH_NO4",
				"VISIT_THIS_MONTH_NO5", "VISIT_THIS_MONTH_NO6",
				"VISIT_NEXT_MONTH_NO1", "VISIT_NEXT_MONTH_NO2",
				"VISIT_NEXT_MONTH_NO3", "VISIT_NEXT_MONTH_NO4",
				"VISIT_NEXT_MONTH_NO5", "VISIT_NEXT_MONTH_NO6" };
		// 変換対象のキーを連続変換処理
		for (int i = 0; i < convKeys.length; i++) {
			int dayValue = 0;
			String key = convKeys[i];
			// nullの場合は空白に変換する
			if (ACTextUtilities.isNullText(VRBindPathParser
					.get(key, printParam))) {
				VRBindPathParser.set(key, parseParam, "");
				// 次の対象処理へ
				continue;
			}
			// null以外の場合は日で変換
			dayValue = ACDateUtilities.getDayOfMonth(ACCastUtilities
					.toDate(VRBindPathParser.get(key, printParam)));
			// データを格納
			VRBindPathParser.set(key, parseParam,
					ACCastUtilities.toString(dayValue));
		}
		// データシフト処理
		String thisMonth[] = new String[6];
		String nextMonth[] = new String[6];
		// 今月分の日付をコピー
		System.arraycopy(convKeys, 0, thisMonth, 0, 6);
		// 次月分の日付をコピー
		System.arraycopy(convKeys, 6, nextMonth, 0, 6);
		// 居宅療養管理指導書よりロジックパクリ
		int end = thisMonth.length;
		for (int i = 0; i < end; i++) {
			if (ACTextUtilities.isNullText(VRBindPathParser.get(thisMonth[i],
					parseParam))) {
				// 空欄があれば右方向へ走査
				boolean find = false;
				for (int j = i + 1; j < end; j++) {
					Object obj = VRBindPathParser.get(thisMonth[j], parseParam);
					if (!ACTextUtilities.isNullText(obj)) {
						// 空欄以外データが見つかれば左へ転記
						VRBindPathParser.set(thisMonth[i], parseParam, obj);
						VRBindPathParser.set(thisMonth[j], parseParam, "");
						find = true;
						break;
					}
				}
				if (!find) {
					// 右方向に新規データがなければ処理終了
					break;
				}
			}
		}

		end = nextMonth.length;
		for (int i = 0; i < end; i++) {
			if (ACTextUtilities.isNullText(VRBindPathParser.get(nextMonth[i],
					parseParam))) {
				// 空欄があれば右方向へ走査
				boolean find = false;
				for (int j = i + 1; j < end; j++) {
					Object obj = VRBindPathParser.get(nextMonth[j], parseParam);
					if (!ACTextUtilities.isNullText(obj)) {
						// 空欄以外データが見つかれば左へ転記
						VRBindPathParser.set(nextMonth[i], parseParam, obj);
						VRBindPathParser.set(nextMonth[j], parseParam, "");
						find = true;
						break;
					}
				}
				if (!find) {
					// 右方向に新規データがなければ処理終了
					break;
				}
			}
		}

		VRBindPathParser.set("PATIENT_ADDRESS", parseParam,
				VRBindPathParser.get("KYOTAKU_PATIENT_ADDRESS", parseParam));
		VRBindPathParser.set("PATIENT_TEL_FIRST", parseParam,
				VRBindPathParser.get("KYOTAKU_PATIENT_TEL_FIRST", parseParam));
		VRBindPathParser.set("PATIENT_TEL_SECOND", parseParam,
				VRBindPathParser.get("KYOTAKU_PATIENT_TEL_SECOND", parseParam));
		VRBindPathParser.set("PATIENT_TEL_THIRD", parseParam,
				VRBindPathParser.get("KYOTAKU_PATIENT_TEL_THIRD", parseParam));

		return parseParam;
	}

	protected void patientChoiseColumnCheckMenuActionPerformed(ActionEvent e)
			throws Exception {

	}
	
	/**
	 * 居宅療養管理指導の印刷済判定処理
     * [2014年要望] 居宅療養管理指導書の対象年月に複数登録対応
	 * 
     * @since version 6.2.3
     * @author Shinobu Hitaka 2014/12/02
	 */
	public int getFinishFlagQC006(VRMap param) throws Exception {
		
		// 利用者一覧検索時に取得した居宅療養管理指導書情報より手動で指定利用者のデータを検索する
		// 利用者IDはInt型のため、検索キーとして一致しない。文字列に変換して検索キーとする。
		// 指定利用者の居宅療養管理指導書情報が全て印字済=1、それ以外=0を返す
		int finishFlag = 1;
		String[] keys = { "PATIENT_ID" };
		VRMap dataMap = new VRHashMap();
		VRBindPathParser.set("PATIENT_ID", dataMap,
				ACCastUtilities.toString(VRBindPathParser.get("PATIENT_ID", param)));
		VRList kyotakuData = doMultiFind(getKyotakuData(), dataMap, keys);
		for (int i = 0; i < kyotakuData.size(); i++) {
			VRMap kyotakuMap = new VRHashMap();
			kyotakuMap = (VRMap) kyotakuData.get(i);
			// 印刷状態
			if (ACCastUtilities.toInteger(
									kyotakuMap.getData("FINISH_FLAG"), 0) == 0) {
				finishFlag = 0;
				break;
			}
		}

		return finishFlag;

	}

	/**
	 * 居宅療養管理指導の印刷済設定処理
     * [2014年要望] 居宅療養管理指導書の対象年月に複数登録対応
	 * 
     * @since version 6.2.3
     * @author Shinobu Hitaka 2015/01/05
	 */
	public void setFinishFlagQC006(Object patientId) throws Exception {
		
		// 利用者一覧検索時に取得した居宅療養管理指導書情報より手動で指定利用者のデータを検索する
		// 利用者IDはInt型のため、検索キーとして一致しない。文字列に変換して検索キーとする。
		// 印字済=1を設定する
		String[] keys = { "PATIENT_ID" };
		VRMap dataMap = new VRHashMap();
		VRBindPathParser.set("PATIENT_ID", dataMap, ACCastUtilities.toString(patientId));
		VRList kyotakuData = doMultiFind(getKyotakuData(), dataMap, keys);
		for (int i = 0; i < kyotakuData.size(); i++) {
			VRMap kyotakuMap = new VRHashMap();
			kyotakuMap = (VRMap) kyotakuData.get(i);
			kyotakuMap.setData("FINISH_FLAG", 1);
		}

		return;

	}

	/**
	 * 居宅療養管理指導の印刷用データ検索処理
     * [2014年要望] 居宅療養管理指導書の対象年月に複数登録対応
	 * 
     * @since version 6.2.3
     * @author Shinobu Hitaka 2014/12/02
	 * @param param 検索条件（利用者ID、印刷完了フラグ）
	 * @param printMode 0：印刷済を含めない、1：全て印刷
	 */
	public VRList doFindPrintDataQC006(VRMap param, int printMode) throws Exception {
		
		VRMap dataMap = new VRHashMap();
		VRList kyotakuData = new VRArrayList();
		
		// 利用者一覧検索時に取得した居宅療養管理指導書情報より手動で指定利用者のデータを検索する
		if (printMode == 0) {
			//印刷未確定のみ
			// 利用者ID、印刷完了フラグを指定する。
			// Int型のため、検索キーとして一致しない。文字列に変換して検索キーとする。
			String[] keys = { "PATIENT_ID", "FINISH_FLAG" };
			VRBindPathParser.set("PATIENT_ID", dataMap,
					ACCastUtilities.toString(VRBindPathParser.get("PATIENT_ID", param)));
			VRBindPathParser.set("FINISH_FLAG", dataMap, "0");
			kyotakuData = doMultiFind(getKyotakuData(), dataMap, keys);
		} else if (printMode == 1) {
			//全印刷
			// 利用者IDを指定する。
			String[] keys = { "PATIENT_ID" };
			VRBindPathParser.set("PATIENT_ID", dataMap,
					ACCastUtilities.toString(VRBindPathParser.get("PATIENT_ID", param)));
			kyotakuData = doMultiFind(getKyotakuData(), dataMap, keys);
		}

		return kyotakuData;

	}
	
	/**
	 * データを手動検索します。
	 * [2014年要望] 居宅療養管理指導書の対象年月に複数登録対応
	 * 
	 * @param targetList
	 * @param findParam
	 * @param keys
	 * @return
	 * @throws Exception
	 */
	public VRList doMultiFindQC006(VRList targetList, VRMap findParam, String[] keys)
			throws Exception {
		// 不正な値が引数なので初期値で返す
		if (targetList == null || targetList.isEmpty()) {
			return new VRArrayList();
		}
		boolean isFindKey = false;
		// 検索キーの存在の有無
		for (int i = 0; i < keys.length; i++) {
			if (findParam.containsKey(keys[i])) {
				// 存在有の場合はループを終了
				isFindKey = true;
				break;
			}
		}
		// パラメーターが不正もしくは検索キーは未入力
		if (findParam == null || !isFindKey) {
			// 何もせずに返す
			return targetList;
		}
		
		// 居宅療養管理指導全てより検索
		// 利用者
		// 事業所等名
		// 介護支援専門員
		// 印刷完了フラグ
		VRList kyotakuData = doMultiFind(getKyotakuData(), findParam, keys);
		
		// 利用者一覧と居宅療養管理指導書検索結果を比較し一致する利用者を結果として返す。
		VRMap searchMap = new VRHashMap();
		VRList searchList = new VRArrayList();
		VRList resultList = new VRArrayList();
		
		for (int m = 0; m < targetList.size(); m++) {
			VRMap targetMap = new VRHashMap();
			targetMap = (VRMap) targetList.get(m);
			String patientId = ACCastUtilities.toString(targetMap.getData("PATIENT_ID"));
			
			VRBindPathParser.set("PATIENT_ID", searchMap, patientId);
			searchList = filterData(kyotakuData, searchMap, "PATIENT_ID");
			// 結果リストへ追加
			if (searchList.size() > 0) {
				resultList.addData(targetMap);
			}
		}
		targetList = resultList;
		
		return targetList;
	}

}
