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
 * プロセス 医療機関管理 (010)
 * プログラム 医療機関登録 (QO010)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo010;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.ACZipRelation;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 医療機関登録(QO010)
 */
public class QO010 extends QO010Event {
	/**
	 * コンストラクタです。
	 */
	public QO010() {
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
		// 郵便番号から住所変換
		new ACZipRelation(getMedicalFacilityPostnoOn(),
				getMedicalFacilityPostnoUnder(), getMedicalFacilityAddress());

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
		}
		if (VRBindPathParser.has("PROCESS_MODE", parameters)) {

			// int型に型変換しプロセスモードを退避
			setProcessMode(Integer.parseInt(String.valueOf(VRBindPathParser
					.get("PROCESS_MODE", parameters))));
		}

		// 画面状態の初期化を行う。
		initialize();

		// スナップショット撮影対象を「医療機関情報領域（medicalFacilityContents）」に指定する。
		getSnapshot().setRootContainer(getMedicalFacilityContents());
		// 更新モードの場合（processModeが共通定数のPROCESS_MODE_UPDATE）
		// データを検索し、取得する。
		doFind();
	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		// 最後に保存されてから変更されているかどうかチェックする。
		if (getSnapshot().isModified()) {
			// 最後に保存されてから変更されている場合（ACSnapshot.isModified == true）
			// 確認メッセージを表示する。
			// 登録モードの場合（processModeが共通定数のPROCESS_MODE_INSERT）
			int msgID = 0;
			if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
				// ・メッセージID：WARNING_OF_INSERT_ON_MODIFIED
				msgID = QkanMessageList.getInstance()
						.WARNING_OF_INSERT_ON_MODIFIED();
			} else {
				// 更新モードの場合（processModeが共通定数のPROCESS_MODE_UPDATE）
				msgID = QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED();
				// ・メッセージID：WARNING_OF_UPDATE_ON_MODIFIED
			}
			switch (msgID) {
			// 「はい」「いいえ」以外を選択した場合
			case ACMessageBox.RESULT_CANCEL:
				// 処理を中断する（何もしない）。
				return false;

			case ACMessageBox.RESULT_YES:
				// 「はい」を選択した場合
				// 入力チェックを行う。
				if (!isValidInput()) {
					// 入力エラーがあった場合（戻り値がfalseであった場合）
					// 処理を中断する。(終了)
					return false;
				}
				// 保存処理を行う。
				if (doSave()) {
					// 保存処理が正常終了した場合
					// 登録モードの場合（processModeが共通定数のPROCESS_MODE_INSERT）
					if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
						// 処理完了通知メッセージを表示する。
						// ・メッセージID：INSERT_SUCCESSED
//						QkanMessageList.getInstance().INSERT_SUCCESSED();
						// 処理モードを更新モードに変更する。
						setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
					} else {
						// 更新モードの場合（processModeが共通定数のPROCESS_MODE_UPDATE）
						// 処理完了通知メッセージを表示する。
						// ・メッセージID：UPDATE_SUCCESSED
//						QkanMessageList.getInstance().UPDATE_SUCCESSED();
					}
				} else {
					// 保存処理が正常終了しなかった場合
					// 処理を中断する。(終了)
					return false;
				}

			}
		}

		// 更新モードの場合
		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// 下記パラメータを戻り時の渡りパラメータに設定する。
			// KEY：MEDICAL_FACILITY_ID VALUE：medicalFacilityId
			parameters.setData("MEDICAL_FACILITY_ID", new Integer(
					getMedicalFacilityId()));
		}
		// TODO 前画面への遷移を許可するならばtrueを返す。
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// 最後に保存されてから変更されているかどうかチェックする。
		int msgID = 0;
		if (getSnapshot().isModified()) {
			// 最後に保存されてから変更されている場合（ACSnapshot.isModified == true）
			// 終了確認メッセージを表示する。
			msgID = QkanMessageList.getInstance()
					.WARNING_OF_CLOSE_ON_MODIFIED();
			// ・メッセージID：WARNING_OF_CLOSE_ON_MODIFIED
			switch (msgID) {
			case ACMessageBox.RESULT_CANCEL:
				// 「はい」選択以外の場合
				// 処理を中断する（何もしない）。
				return false;
			}
		}
		// システムを終了する。
		// TODO 終了を許可するならばtrueを返す。
		return true;
	}

	// コンポーネントイベント

	/**
	 * 「登録処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {
		// 入力チェックを行う。
		if (!isValidInput()) {
			// 入力エラーがあった場合（戻り値がfalseであった場合）
			// 処理を中断する。(終了)
			return;
		}
		// 保存処理を行う。
		if (doSave()) {
			// 保存処理が正常終了した場合
			// 処理モードを更新モードに変更する。
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
			// 画面状態の初期化を行う。
			initialize();

			// 「MEDICAL_FACILITY」TABLEより最新のデータを取得する。
			doFind();

			// 処理完了通知メッセージを表示する。
			// ・メッセージID：INSERT_SUCCESSED
			QkanMessageList.getInstance().INSERT_SUCCESSED();
		} else {
			// 保存処理が正常終了しなかった場合
			// 処理を中断する。(終了)
			return;
		}
	}

	/**
	 * 「更新処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void updateActionPerformed(ActionEvent e) throws Exception {
		// 入力チェックを行う。
		if (!isValidInput()) {
			// 入力エラーがあった場合（戻り値がfalseであった場合）
			// 処理を中断する。(終了)
			return;
		}
		// 保存処理を行う。
		if (doSave()) {
			// 保存処理が正常終了した場合
			// 画面状態の初期化を行う。
			initialize();

			// 「MEDICAL_FACILITY」TABLEより最新のデータを取得する。
			doFind();

			// 処理完了通知メッセージを表示する。
			QkanMessageList.getInstance().UPDATE_SUCCESSED();
			// ・メッセージID：UPDATE_SUCCESSED
		} else {
			// 保存処理が正常終了しなかった場合
			// 処理を中断する。(終了)
			return;
		}
	}

	/**
	 * 「画面クリア（更新モード時）」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void newDataActionPerformed(ActionEvent e) throws Exception {
		// 最後に保存されてから変更されているかどうかチェックする。
		int msgID = 0;
		if (getSnapshot().isModified()) {
			// 最後に保存されてから変更されている場合（ACSnapshot.isModified == true）
			// 確認メッセージを表示する。
			msgID = QkanMessageList.getInstance()
					.WARNING_OF_CLEAR_ON_MODIFIED();
			// ・メッセージID：WARNING_OF_CLEAR_ON_MODIFIED
			switch (msgID) {
			case ACMessageBox.RESULT_CANCEL:
				// 「OK」選択以外の場合
				// 処理を終了する。
				return;
			}
		}
		// 画面全体をクリアする。
		doClear();
	}

	/**
	 * 「画面クリア（新規モード時）」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void clearActionPerformed(ActionEvent e) throws Exception {
		// 最後に保存されてから変更されているかどうかチェックする。
		int msgID = 0;
		if (getSnapshot().isModified()) {
			// 最後に保存されてから変更されている場合（ACSnapshot.isModified == true）
			// 確認メッセージを表示する。
			msgID = QkanMessageList.getInstance()
					.WARNING_OF_CLEAR_ON_MODIFIED();
			// ・メッセージID：WARNING_OF_CLEAR_ON_MODIFIED
			switch (msgID) {
			case ACMessageBox.RESULT_CANCEL:
				// 「OK」選択以外の場合
				// 処理を終了する。
				return;
			}
		}
		// 画面全体をクリアする。
		doClear();
	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QO010.class.getName(), param));
	}

	// 内部関数

	/**
	 * 「画面初期化」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void initialize() throws Exception {
		// ※画面初期化処理
		// ※ウィンドウタイトル・業務ボタンバーの設定
		// ウィンドウタイトル・業務ボタンバーを設定する。
		setAffairTitle("QO010", "0", getButtons());
		// ※業務ボタンの状態設定
		// 登録モードの場合（processModeが共通定数のPROCESS_MODE_INSERT）
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// 業務ボタンの状態を設定する。
			setState_INSERT_MODE();
			// ・状態ID：INSERT_MODE
		} else {
			// 更新モードの場合（processModeが共通定数のPROCESS_MODE_UPDATE）
			// 業務ボタンの状態を設定する。
			setState_UPDATE_MODE();
			// ・状態ID：UPDATE_MODE
		}

	}

	/**
	 * 「検索処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFind() throws Exception {
		// ※検索処理および画面展開
		// SQL文取得用VRMap sqlParamを生成する。
		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {

			VRMap sqlParam = new VRHashMap();
			// sqlParamに下記の値を設定する。
			// KEY：MEDICAL_FACILITY_ID VALUE：medicalFacilityId
			sqlParam.setData("MEDICAL_FACILITY_ID", new Integer(
					getMedicalFacilityId()));
			// sqlParamを引数として、医療機関情報取得用SQL文を取得する。
			// getSQL_GET_MEDICAL_FACILITY(sqlParam);
			// 取得したSQL文を実行し、医療機関情報を取得する。
			VRList MedicalFacilityList = getDBManager().executeQuery(
					getSQL_GET_MEDICAL_FACILITY(sqlParam));

			// 取得したデータの件数が0件である場合
			if (MedicalFacilityList.size() == 0) {
				// エラーメッセージを表示する。
				// ・メッセージID：ERROR_OF_PASSIVE_CHECK_ON_FIND
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();
				// 「医療機関一覧」画面に戻る。

			} else {
				// 取得したデータの件数が1件以上である場合
				// パッシブキーをクリアする。
				getPassiveChecker().clearReservedPassive();
				// 取得したデータをパッシブキーに登録する。
				// reservedPassive(PASSIVE_CHECK_KEY, （取得したデータ）);
				getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
						MedicalFacilityList);
				// 取得したデータの最初のレコードを「医療機関情報領域（medicalFacilityContents）」のソースとして設定する。
				VRMap MedicalFacilityMap = (VRMap) MedicalFacilityList
						.getData(0);
				// this.setSource(MedicalFacilityMap);
				getMedicalFacilityContents().setSource(MedicalFacilityMap);

				// 画面に展開する。
				getMedicalFacilityContents().bindSource();
			}
		}
		// スナップショットを撮影する。
		getSnapshot().snapshot();
	}

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean isValidInput() throws Exception {
		// ※入力チェック
		// メッセージに渡す文字列格納用String msgParamを生成する。
		String msgParam = null;
		// ・医療機関名称（medicalFacilityName）
		if (ACTextUtilities.isNullText(getMedicalFacilityName().getText())) {
			// 未入力の場合
			// msgParamに"医療機関名称"を代入する。
			msgParam = "医療機関名称";
			// エラーメッセージを表示する。
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam);
			// ・メッセージID：ERROR_OF_NEED_CHECK_FOR_INPUT
			// エラーが発生したインスタンスにフォーカスを当てる。
			getMedicalFacilityName().requestFocus();
			// 戻り値としてfalseを返す。
			return false;
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

		// ※保存処理
		// SQL文取得用VRMap sqlParamを生成する。
		VRMap sqlParam = new VRHashMap();
		// 画面上のデータを取得し、sqlParamに格納する。
		getMedicalFacilityContents().setSource(sqlParam);
		getMedicalFacilityContents().applySource();

		// DBマネージャー定義
		ACDBManager dbm = getDBManager();

		try {
			// トランザクション開始
			dbm.beginTransaction();

			// 登録モードの場合（processModeが共通定数のPROCESS_MODE_INSERT）
			if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {

				// 「MEDICAL_FACILITY」TABLE登録用のSQL文を取得する。
				// getSQL_INSERT_MEDICAL_FACILITY(null);
				// 取得したSQL文を実行する。
				getDBManager().executeUpdate(
						getSQL_INSERT_MEDICAL_FACILITY(sqlParam));

				// 一時HashMap
				VRMap medicalFacilityIdMap = new VRHashMap();
				medicalFacilityIdMap = (VRMap) dbm.executeQuery(
						getSQL_GET_NEW_MEDICAL_FACILITY_ID(null)).getData();

				setMedicalFacilityId(ACCastUtilities.toInt(VRBindPathParser
						.get("MEDICAL_FACILITY_ID_MAX", medicalFacilityIdMap)));

			} else {
				// パッシブタスクをクリアする。
				getPassiveChecker().clearPassiveTask();

				// パッシブタスクを登録する。
				getPassiveChecker().addPassiveUpdateTask(
						getPASSIVE_CHECK_KEY(), 0);

				// パッシブチェックを実行する。
				if (!getPassiveChecker().passiveCheck(dbm)) {
					// パッシブエラーがある場合
					// パッシブエラーメッセージを表示する。※メッセージID =
					// ERROR_OF_PASSIVE_CHECK_ON_UPDATE
					QkanMessageList.getInstance()
							.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
					// 処理を中断する。
					dbm.rollbackTransaction();
					return false;
				}

				// sqlParamに下記の値を追加する。
				// KEY：MEDICAL_FACILITY_ID VALUE：medicalFacilityId
				sqlParam.setData("MEDICAL_FACILITY_ID", new Integer(
						getMedicalFacilityId()));
				// 「MEDICAL_FACILITY」TABLE更新用のSQL文を取得する。
				// getSQL_UPDATE_MEDICAL_FACILITY(null);
				// 取得したSQL文を実行する。
				getDBManager().executeUpdate(
						getSQL_UPDATE_MEDICAL_FACILITY(sqlParam));

			}
		} catch (Exception sqlEx) {
			// 上記のSQL処理中にエラーが発生した場合
			// 処理をロールバックする。
			sqlEx.printStackTrace();

			dbm.rollbackTransaction();
			// 処理を中断する。(異常終了)
			throw sqlEx;
			// return false;
		}
		// 上記のSQL処理が正常に終了した場合
		// 処理をコミットする。
		getDBManager().commitTransaction();

		return true;
	}

	/**
	 * 「画面クリア処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doClear() throws Exception {
		// ※画面全体をクリアする処理
		// ※画面クリア
		// 空のVRMapを生成し、「医療機関情報領域（medicalFacilityContents）」のソースとして設定する。
		VRMap clearMap = new VRHashMap();

		clearMap = (VRMap) getMedicalFacilityContents().createSource();
		getMedicalFacilityContents().setSource(clearMap);
		// 画面に空のVRMapを展開する。
		getMedicalFacilityContents().bindSource();

		// ※変数クリア、処理モード変更
		// 更新モードの場合（processModeが共通定数のPROCESS_MODE_UPDATE）
		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// medicalFacilityIdをクリアする。（0を代入する）
			setMedicalFacilityId(0);
			// 処理モードを登録モードに変更する。
			setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
		}
		// ※画面初期化
		// 画面状態の初期化を行う。
		initialize();

		// ※スナップショットの撮影
		// スナップショットを撮影する。
		getSnapshot().snapshot();
	}

}
