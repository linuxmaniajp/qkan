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
 * 開発者: 上司　和善
 * 作成日: 2006/01/16  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 医療機関管理 (009)
 * プログラム 医療機関一覧 (QO009)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo009;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qo.qo010.QO010;

/**
 * 医療機関一覧(QO009)
 */
public class QO009 extends QO009Event {
	/**
	 * コンストラクタです。
	 */
	public QO009() {
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
		// パッシブキーの定義
		setPASSIVE_CHECK_KEY(new ACPassiveKey("MEDICAL_FACILITY",
				new String[] { "MEDICAL_FACILITY_ID" }, "LAST_TIME",
				"LAST_TIME"));

		// 渡りパラメータを退避する。
		// medicalFacilityId = MEDICAL_FACILITY_ID（医療機関ID）
		VRMap parameters = affair.getParameters();

		// データが存在しているかをチェック
		if (VRBindPathParser.has("MEDICAL_FACILITY_ID", parameters)) {

			// int型に型変換し利用者IDを退避
			setMedicalFacilityId(Integer.parseInt(String
					.valueOf(VRBindPathParser.get("MEDICAL_FACILITY_ID",
							parameters))));

			// 二重に起動しないようにキーを削除
			parameters.remove("MEDICAL_FACILITY_ID");
		}

		// 画面の初期化を行う。
		initialize();

		// 検索処理を行う。
		doFind();
	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		// 前画面に戻る。

		// TODO 前画面への遷移を許可するならばtrueを返す。
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// システムを終了する。

		// TODO 終了を許可するならばtrueを返す。
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
		// ※選択されている医療機関の情報で「QO010 医療機関登録」画面に遷移
		// 次画面に遷移する。
		transferNext();
	}

	/**
	 * 「登録画面に遷移」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {
		// ※「QO010 医療機関登録」画面に遷移
		// 次画面への渡りパラメータ格納用にレコード paramを生成する。
		VRMap param = new VRHashMap();
		// paramに下記の値を設定する。
		// KEY：PROCESS_MODE VALUE：PROCESS_MODE_INSERT
		param.setData("PROCESS_MODE", new Integer(
				QkanConstants.PROCESS_MODE_INSERT));
		// 下記パラメータにてNCAffairInfo affairを生成する。
		ACAffairInfo affair = null;
		// className : QO010.class.getName(), parameters : param
		affair = new ACAffairInfo(QO010.class.getName(), param);
		// 次画面に遷移する。
		// next(affair);
		ACFrame.getInstance().next(affair);
	}

	/**
	 * 「医療機関削除処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void deleteActionPerformed(ActionEvent e) throws Exception {
		// ※医療機関削除処理
		// ※削除準備
		// SQL文取得用のVRMap sqlParamを定義する。
		VRMap sqlParam = new VRHashMap();
		
		// sqlParamを生成する。
		// sqlParamに下記パラメータを設定する。
		// KEY：MEDICAL_FACILITY_ID VALUE：（医療機関情報テーブルで選択されている医療機関の医療機関ID）
		// 一時利用HashMap
		VRMap MedicalFacilityIdMap = new VRHashMap();

		MedicalFacilityIdMap = (VRMap) getMedicalFacilityTable()
				.getSelectedModelRowValue();

		sqlParam.setData("MEDICAL_FACILITY_ID", VRBindPathParser.get(
				"MEDICAL_FACILITY_ID", MedicalFacilityIdMap));

		// sqlParamを引数として、訪問看護ステーション履歴取得用のSQL文を取得する。
		VRList StationHistoryList = getDBManager().executeQuery(
				getSQL_GET_STATION_HISTORY(sqlParam));
		// 取得したデータ件数が0件より多い場合
		if (StationHistoryList.size() > 0) {
			// String msgParamを生成する。
			String msgParam = null;
			// msgParamに"利用者情報"を代入する。
			msgParam = "利用者情報";

			// エラーメッセージを表示する。
			int msgID = QkanMessageList.getInstance().ERROR_OF_DELETE_USED(
					msgParam);
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// ・メッセージID：ERROR_OF_DELETE_USED
				// 処理を終了する。
				return;
			}
		}
		
		// 選択されているレコードのインデックスを格納するindexを定義する。
		int index;


		// ※処理確認
		// 削除確認メッセージを表示する。※メッセージID = WARNING_OF_DELETE
		int msgID = QkanMessageList.getInstance()
				.WARNING_OF_DELETE("選択中の医療機関情報");
		switch (msgID) {
		case ACMessageBox.RESULT_CANCEL:
			// 「OK」選択以外の場合(削除中断)
			// 処理を中断する。
			return;
		case ACMessageBox.RESULT_OK:
			// ※医療機関が登録されているかチェックする。
			// 医療機関情報テーブルで医療機関が選択されているかチェックする。
			if (getMedicalFacilityTable().getSelectedSortedRow() == -1) {
				// 選択されていない場合
				// 処理を終了する。
				return;
			} else {
				// 選択されている場合
				// 選択行のインデックス(モデルではなく画面上)を取得する。
				index = getMedicalFacilityTable().getSelectedModelRow();


				try {
					// トランザクション開始
					getDBManager().beginTransaction();

					// ※パッシブチェック
					// パッシブタスクをクリアする。
					getPassiveChecker().clearPassiveTask();

					// パッシブタスクを登録する。
					getPassiveChecker().addPassiveDeleteTask(
							getPASSIVE_CHECK_KEY(), index);

					// パッシブチェックを実行する。
					if (!getPassiveChecker().passiveCheck(getDBManager())) {
						// パッシブエラーがある場合
						// エラーメッセージを表示する。※メッセージID =
						// ERROR_OF_PASSIVE_CHECK_ON_UPDATE
						QkanMessageList.getInstance()
								.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
						// 処理を中断する。(異常終了)
						getDBManager().rollbackTransaction();
						return;
					}
					// ※医療機関削除
					// sqlParamを引数として、医療機関削除用のSQL文を取得する。
					// getSQL_DELETE_MEDICAL_FACILITY(sqlParam);
					// 取得したSQL文を発行する。
					getDBManager().executeUpdate(
							getSQL_DELETE_MEDICAL_FACILITY(sqlParam));

					getDBManager().commitTransaction();

					// 処理完了通知メッセージを表示する。※メッセージID = DELETE_SUCCESSED
					// QkanMessageList.getInstance().DELETE_SUCCESSED();
					// 処理を終了する。(正常終了)

					// 医療機関情報を再検索する。
					doFind();

					// 削除後の理想となる行番号を設定する
					getMedicalFacilityTable()
							.setSelectedSortedRowOnAfterDelete(index);

				} catch (Exception ex) {
					// ※コミット・ロールバック
					// 上記のSQL発行処理でエラーがなかった場合
					// 処理をコミットする。
					getDBManager().rollbackTransaction();

					// 上位クラスに例外を返す。
					throw ex;
				}
			}
		}

	}

	/**
	 * 「テーブル選択時処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void medicalFacilityTableSelectionChanged(ListSelectionEvent e)
			throws Exception {
		// ※テーブル選択時処理
		// ※画面状態設定
		// テーブルのセルが選択されている場合
		if (getMedicalFacilityTable().getSelectedSortedRow() != -1) {
			// 画面の状態を設定する。
			setState_SELECTED();
			// 状態設定：SELECTED
			// テーブルのセルが選択されていない場合
		} else {
			// 画面の状態を設定する。
			setState_UNSELECTED();
			// 状態設定：UNSELECTED
		}

	}

	/**
	 * 「詳細画面遷移」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void medicalFacilityTableMouseClicked(MouseEvent e)
			throws Exception {
		// ※詳細画面に遷移
		// 次画面に遷移する。
		transferNext();
	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QO009.class.getName(), param));
	}

	// 内部関数

	/**
	 * 「初期化」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void initialize() throws Exception {
		// ※画面の初期化処理。
		// ※ウィンドウタイトル・業務ボタンバーの設定
		// ウィンドウタイトル・業務ボタンバーを設定する。
		setAffairTitle("QO009", "0", getButtons());
		// ※テーブルモデル生成
		// tableModelを生成し、以下のカラムを設定する。
		// 医療機関名称 "MEDICAL_FACILITY_NAME"
		// 郵便番号 "MEDICAL_FACILITY_ZIP_FIRST+'-'+MEDICAL_FACILITY_ZIP_SECOND"
		// 所在地 "MEDICAL_FACILITY_ADDRESS"
		// 電話番号
		// "MEDICAL_FACILITY_TEL_FIRST+'-'+MEDICAL_FACILITY_TEL_SECOND+'-'+MEDICAL_FACILITY_TEL_THIRD"
		// FAX
		// "MEDICAL_FACILITY_FAX_FIRST+'-'+MEDICAL_FACILITY_FAX_SECOND+'-'+MEDICAL_FACILITY_FAX_THIRD"
		// (隠しカラム)
		// 郵便番号1 "MEDICAL_FACILITY_ZIP_FIRST"
		// 郵便番号2 "MEDICAL_FACILITY_ZIP_SECOND"
		// 電話番号1 "MEDICAL_FACILITY_TEL_FIRST"
		// 電話番号2 "MEDICAL_FACILITY_TEL_SECOND"
		// 電話番号3 "MEDICAL_FACILITY_TEL_THIRD"
		// FAX番号1 "MEDICAL_FACILITY_FAX_FIRST"
		// FAX番号2 "MEDICAL_FACILITY_FAX_SECOND"
		// FAX番号3 "MEDICAL_FACILITY_FAX_THIRD"
		ACTableModelAdapter model = new ACTableModelAdapter();

		model
				.setColumns(new String[] {
						"MEDICAL_FACILITY_NAME",
						"MEDICAL_FACILITY_ZIP_FIRST+'-'+MEDICAL_FACILITY_ZIP_SECOND",
						"MEDICAL_FACILITY_ADDRESS",
						"MEDICAL_FACILITY_TEL_FIRST+'-'+MEDICAL_FACILITY_TEL_SECOND+'-'+MEDICAL_FACILITY_TEL_THIRD",
						"MEDICAL_FACILITY_FAX_FIRST+'-'+MEDICAL_FACILITY_FAX_SECOND+'-'+MEDICAL_FACILITY_FAX_THIRD", });

		setTableModel(model);

		// テーブルモデルを下記の画面のテーブルに設定する。
		// 事業所情報テーブル（MedicalFacilityTable) テーブルモデル：TableModel
		getMedicalFacilityTable().setModel(getTableModel());

	}

	/**
	 * 「検索」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFind() throws Exception {
		// ※検索処理
		// ※検索準備
		// SQL取得用のVRMap splParamを生成する。
		VRMap sqlParam = new VRHashMap();

		// ※医療機関名称の取得
		// medicalFacilityNameより入力されている文字列を取得する。
		String StrMedicalFacilityName = getMedicalFacilityName().getText();
		// 取得した文字列を検索用に変換する。
		// StrMedicalFacilityName = changeString(StrMedicalFacilityName);

		// 変換した文字列の文字列長が0より大きい場合
		// sqlParamに変換した文字列を以下のKEYで追加する。
		// ・KEY：MEDICAL_FACILITY_NAME
		if (StrMedicalFacilityName.length() > 0) {
			sqlParam.setData("MEDICAL_FACILITY_NAME", StrMedicalFacilityName);
		}

		// ※検索実行
		// sqlParamを引数として、医療機関取得用のSQL文を取得する。
		// getSQL_GET_MEDICAL_FACILITY(sqlParam);
		// 取得したSQL文を実行し、取得したデータをmedicalFacilityListに格納する。
		setMedicalFacilityList(getDBManager().executeQuery(
				getSQL_GET_MEDICAL_FACILITY(sqlParam)));

		// ※取得したデータを画面に展開
		// 取得したデータが0件より多い場合
		if (getMedicalFacilityList().size() > 0) {
			// tableModelにmedicalFacilityListをセットする。
			getTableModel().setAdaptee(getMedicalFacilityList());

			// 渡りパラメータとして医療機関IDが渡されていた場合（medicalFacilityId <> 0）
			if (getMedicalFacilityId() != 0) {
				int index = ACCommon.getInstance().getMatchIndexFromValue(
						getMedicalFacilityList(), "MEDICAL_FACILITY_ID",
						new Integer(getMedicalFacilityId()));

				// 渡された医療機関IDの医療機関を選択した状態にする。
				getMedicalFacilityTable().setSelectedModelRow(index);

				// 医療機関IDが二重に使用されないように、medicalFacilityIdに0を代入する。
				setMedicalFacilityId(0);

				// 渡りパラメータとして医療機関IDが渡されていない場合（medicalFacilityId == 0）
			} else {
				// 医療機関情報テーブルの1行目を選択した状態にする。
				getMedicalFacilityTable().setSelectedSortedFirstRow();
			}
            //選択利用者までスクロール処理
            getMedicalFacilityTable().scrollSelectedToVisible();
		} else {
			// 取得したデータが0件である場合
			// tableModelにmedicalFacilityListをセットする。
			getTableModel().setAdaptee(getMedicalFacilityList());
			// 画面の状態を設定する。
			// ・状態ID：UNSELECTED
			setState_UNSELECTED();
		}

		// ※パッシブキーの再登録
		// パッシブキーをクリアする。
		getPassiveChecker().clearReservedPassive();
		// パッシブキーを登録する。
		getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
				getMedicalFacilityList());

	}

	/**
	 * 「文字列の変換」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	/**
	 * public String changeString(String str) throws Exception { // ※文字列の変換 //
	 * 前後のスペースを除去する。 ACTextUtilities.trim(str); // 戻り値として変換後の文字列を返す。 return str; }
	 */

	/**
	 * 「詳細画面遷移」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void transferNext() throws Exception {
		// ※詳細画面遷移処理。
		// 医療機関情報テーブルで医療機関が選択されているかチェックする。
		if (getMedicalFacilityTable().getSelectedSortedRow() == -1) {
			// 選択されていない場合
			// 処理を終了する。
			return;
		} else {
			// 選択されている場合
			// 次画面への渡りパラメータ格納用にレコード paramを生成する。
			VRMap param = new VRHashMap();
			// paramに下記の値を設定する。
			// KEY：MEDICAL_FACILITY_ID VALUE：（医療機関情報テーブルで選択されている医療機関の医療機関ID）
			// KEY：PROCESS_MODE VALUE：PROCESS_MODE_UPDATE
			// 一時利用HashMap
			VRMap MedicalFacilityIdMap = new VRHashMap();

			MedicalFacilityIdMap = (VRMap) getMedicalFacilityTable()
					.getSelectedModelRowValue();

			param.setData("MEDICAL_FACILITY_ID", VRBindPathParser.get(
					"MEDICAL_FACILITY_ID", MedicalFacilityIdMap));
			param.setData("PROCESS_MODE", new Integer(
					QkanConstants.PROCESS_MODE_UPDATE));
			// 下記パラメータにてNCAffairInfo affairを生成する。
			ACAffairInfo affair = null;
			// className : QO010.class.getName(), parameters : param
			affair = new ACAffairInfo(QO010.class.getName(), param);
			// 次画面に遷移する。
			// next(affair);
			ACFrame.getInstance().next(affair);
		}
	}
}
