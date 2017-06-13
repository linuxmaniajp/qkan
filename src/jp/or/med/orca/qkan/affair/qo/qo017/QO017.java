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
 * 作成日: 2016/09/16  日本コンピューター株式会社  新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 総合事業サービスコード登録 (017)
 * プログラム 総合事業サービスコード登録 (QO017)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo017;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.text.Format;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 総合事業サービスコード登録(QO017)
 */
public class QO017 extends QO017Event {

	/**
	 * コンストラクタです。
	 */
	public QO017() {
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
		
		// 画面展開処理
		// 前画面からの渡りパラメーターを退避する。
		VRMap params = affair.getParameters();
		
		if (VRBindPathParser.has("PROCESS_MODE", params)) {
			setPROCESS_MODE(String.valueOf(VRBindPathParser.get("PROCESS_MODE",
					params)));
		}
		// データが存在しているかをチェック
		if (VRBindPathParser.has("SYSTEM_SERVICE_CODE_ITEM", params) &&
				VRBindPathParser.has("TEKIYO_ST_DATE", params)) {
			setSystemServiceCodeItem(String.valueOf(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM",
					params)));
			setTekiyoStDate((Date) VRBindPathParser.get("TEKIYO_ST_DATE", params));
		}
		if (VRBindPathParser.has("PROCESS_MODE", params)) {
			setPROCESS_MODE(String.valueOf(VRBindPathParser.get("PROCESS_MODE",
					params)));
		}
		if (getPROCESS_MODE() == null) {
			setPROCESS_MODE(String.valueOf(QkanConstants.PROCESS_MODE_INSERT));
		}
        
		// ｢総合事業サービスコード情報TABLE（M_SJ_SERVICE_CODE)｣のパッシブチェックキーを定義する。
		setM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(new ACPassiveKey("M_SJ_SERVICE_CODE",
				new String[] { "SYSTEM_SERVICE_CODE_ITEM", "TEKIYO_ST_DATE" }, new Format[] {
				ACConstants.FORMAT_SQL_STRING, new ACSQLSafeDateFormat("yyyy-MM-dd") },
				"LAST_TIME", "LAST_TIME"));

		// 業務情報マスタより、データを取得する。
		setAffairTitle("QO017", getButtons());

		// 保険者コンボの項目を設定する。
		VRMap comboInsureMap = new VRHashMap();
		comboInsureMap.setData("INSURER_ID", QkanCommon.getInsurerInfo(getDBManager()));
		getInsurerIdCombo().setModelSource(comboInsureMap);
		getInsurerIdCombo().bindModelSource();

		// サービス種類コンボの項目を設定する。
		VRMap comboMap = new VRHashMap();
		Date sysDate = QkanSystemInformation.getInstance().getSystemDate();
		comboMap.setData("SERVICE_CODE_KIND", QkanSjServiceCodeManager.getMasterServiceSogojigyo(getDBManager(), sysDate));
		// comboMapを｢クライアント領域（contents）｣に設定する。
		getServiceCodeKindCombo().setModelSource(comboMap);
		getServiceCodeKindCombo().bindModelSource();

		// 算定単位コンボの項目を設定する。
		getSanteiTaniCombo().setModel(convertValueFromIntegerToString(300, "SANTEI_TANI", "2"));
		
		// 算定回数制限期間コンボの項目を設定する。
		getSanteiKaisuSeigenKikanCombo().setModel(convertValueFromIntegerToString(301, "SANTEI_KAISU_SEIGEN_KIKAN", "2"));

		// 事業対象者実施区分コンボの項目を設定する。
		getJigyoJisshiKbnCombo().setModel(convertValueFromIntegerToString(302, "JIGYO_TAISHOSHA_JISSHI_KBN", null));
		
		// 要支援１受給者実施区分コンボの項目を設定する。
		getYoshien1JisshikbnCombo().setModel(convertValueFromIntegerToString(302, "YOSHIEN1_JUKYUSHA_JISSHI_KBN", null));

		// 要支援２受給者実施区分コンボの項目を設定する。
		getYoshien2JisshikbnCombo().setModel(convertValueFromIntegerToString(302, "YOSHIEN2_JUKYUSHA_JISSHI_KBN", null));

		// DBよりレコードを取得し、画面に展開する。
		doFind();

		if (getPROCESS_MODE().equals(
				Integer.toString(QkanConstants.PROCESS_MODE_INSERT))) {
			// 新規の場合は、保険者番号を引き継ぐ
			if (VRBindPathParser.has("INSURER_ID", params)) {
				// 新規、クリア時の初期値用に退避
				setInsurerId(String.valueOf(VRBindPathParser.get("INSURER_ID", params)));
				getInsurerIdText().setText(String.valueOf(VRBindPathParser.get("INSURER_ID", params)));
			}

		} else if (getPROCESS_MODE().equals(
				Integer.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
			setInsurerId(getInsurerIdText().getText());
		}
		// 保険者コンボを表示する
		insurerComboSelected();

		// スナップショットを撮影する
		snapshotCustom();
	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		
		// 前画面に遷移する処理。
		// 変更をチェックする。※スナップショット
		if (getSnapshot().isModified()) {
			// 変更されていた場合
			// 登録確認メッセージを表示する。※メッセージID = CAN_BACK_ON_INSERT
			int msgID = QkanMessageList.getInstance()
					.WARNING_OF_UPDATE_ON_MODIFIED();
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// ｢登録して戻る｣押下時
				if (!doValidSjServiceCodeInfoCheck()) {
					return false;
				}

				// 登録処理を行う。
				if(!doSave()){
					return false;
				}

				// 渡しパラメーターを作成する。
				parameters
						.setData("QO016.class", this.getClass().getName());
				parameters.setData("SYSTEM_SERVICE_CODE_ITEM", getSystemServiceCodeItem());
				parameters.setData("TEKIYO_ST_DATE", getTekiyoStDate());

				// 前画面に遷移する。
				return true;
			case ACMessageBox.RESULT_NO:
				// ｢破棄して戻る｣押下時
				// 渡しパラメーターを作成する。
				parameters
						.setData("QO016.class", this.getClass().getName());
				// 更新モードの時、遷移先へパラメータを渡す。
				if (getPROCESS_MODE().equals(Integer.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
					parameters.setData("SYSTEM_SERVICE_CODE_ITEM", getSystemServiceCodeItem());
					parameters.setData("TEKIYO_ST_DATE", getTekiyoStDate());
				}

				// 前画面に遷移する。
				return true;
			case ACMessageBox.RESULT_CANCEL:
				return false;
				
			}
		} else {
			// 変更されていなかった場合
			// 渡しパラメーターを作成する。
			parameters.setData("QO016.class", this.getClass().getName());
			// 更新モードの時、遷移先へパラメータを渡す。
			if (getPROCESS_MODE().equals(
					Integer.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
				parameters.setData("SYSTEM_SERVICE_CODE_ITEM", getSystemServiceCodeItem());
				parameters.setData("TEKIYO_ST_DATE", getTekiyoStDate());
			}

			// 前画面に遷移する。
			return true;
		}
		// 前画面への遷移を許可するならばtrueを返す。
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// ※スナップショットチェック
		// スナップショットの更新チェックを行う。
		if (!getSnapshot().isModified()) {
			// 更新されていない場合
			// システムを終了する。
			return true;
		}
		// 更新されている場合
		// 処理を継続する。
		// ※終了確認
		// 終了確認のメッセージを表示する。
		// ※メッセージID = WARNING_OF_CLOSE_ON_MODIFIED

		int msgID = QkanMessageList.getInstance()
				.WARNING_OF_CLOSE_ON_MODIFIED();
		if (msgID == ACMessageBox.RESULT_OK) {
			// 「OK」選択時
			// システムを終了する。
			return true;
		} else {
			// 「キャンセル」選択時
			// 処理を中断する。
			return false;
		}
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
		// 総合事業サービスコード情報の入力チェックを行う。
		if (doValidSjServiceCodeInfoCheck()) {
			// 登録処理を行う。
			if (doSave()) {
				// PROCESS_MODEを、共通定数｢PROCESS_MODE_UPDATE(3)｣に変更する。
				setPROCESS_MODE(Integer
						.toString(QkanConstants.PROCESS_MODE_UPDATE));
				// 登録完了メッセージを表示する。※メッセージID = INSERT_SUCCESSED
				QkanMessageList.getInstance().INSERT_SUCCESSED();
				// DBよりレコードを取得し、画面に展開する。
				doFind();
				// スナップショットを撮影する。
				snapshotCustom();
			}
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
		// 総合事業サービスコード情報を更新する処理
		if (doValidSjServiceCodeInfoCheck()) {
			// 更新処理を行う。
			if (doSave()) {
				// 更新完了メッセージを表示する。※メッセージID = UPDATE_SUCCESSED
				QkanMessageList.getInstance().UPDATE_SUCCESSED();
				// DBよりレコードを取得し、画面に展開する。
				doFind();
				// スナップショットを撮影する。
				snapshotCustom();
			}
		}
	}

	/**
	 * 「新規登録モード変更」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void newDataActionPerformed(ActionEvent e) throws Exception {
		// 新規登録モード変更する処理
		// 変更チェックを行う。 ※スナップショット
		if (getSnapshot().isModified()) {
			// 変更があった場合
			// 新規登録モード遷移確認メッセージを表示する。 ※メッセージID = WARNING_OF_CLEAR_ON_MODIFIED
			int msgID = QkanMessageList.getInstance()
					.WARNING_OF_CLEAR_ON_MODIFIED();
			// 「OK」だった場合
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// 新規登録モードに変更する
				insertModeChange();
				// 画面の状態を変更する。
				setState_INIT_STATE();
				// 保険者番号にフォーカス
				getInsurerIdText().requestFocus();
				// スナップショットを撮影する。
				snapshotCustom();
			}
		} else {
			// 新規登録モードに変更する
			insertModeChange();
			// 画面の状態を変更する。
			setState_INIT_STATE();
			// 保険者番号にフォーカス
			getInsurerIdText().requestFocus();
			// スナップショットを撮影する。
			snapshotCustom();
		}
	}

	/**
	 * 「画面情報のクリア」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void clearActionPerformed(ActionEvent e) throws Exception {
		// 画面情報をクリアする処理
		// 変更チェックを行う。 ※スナップショット
		if (getSnapshot().isModified()) {
			// 変更があった場合
			// 確認メッセージを表示する ※メッセージID = WARNING_OF_CLEAR_ON_MODIFIED
			int msgID = QkanMessageList.getInstance()
					.WARNING_OF_CLEAR_ON_MODIFIED();
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// 「OK」だった場合
				// クリア処理を行う
				allClear();
			}
		} else {
			allClear();
		}

	}

	/**
	 * 「保険者名表示」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insurerIdTextFocusLost(FocusEvent e) throws Exception {

		String insureNo = getInsurerIdText().getText();
		for (int i = 0; getInsurerIdCombo().getModel().getSize() > i; i++) {
			VRMap map = (VRMap) getInsurerIdCombo().getModelItem(i);
			if (insureNo.equals(map.getData("INSURER_ID"))) {
				getInsurerIdCombo().setSelectedIndex(i);
				return;
			}
		}
		getInsurerIdCombo().setSelectedItem(null);

	}
	
	/**
	 * 「保険者名称コンボボックス選択時の処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insurerIdComboActionPerformed(ActionEvent e)
			throws Exception {
		// 選択されたコンボのインデックス
		int index = getInsurerIdCombo().getSelectedIndex();

		if (index < 0)
			return;

		VRMap map = (VRMap) getInsurerIdCombo().getSelectedItem();
		String insureNo = ACCastUtilities.toString(map.get("INSURER_ID"));

		if (insureNo == null)
			return;
		
		// 画面上に設定する。
		getInsurerIdText().setText(insureNo);
	}

	// 内部関数

	/**
	 * 「レコードを取得し画面に設定する。」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFind() throws Exception {
		// 初期画面展開を行う処理
		// 総合事業サービスコード情報TABLEに存在する、総合事業サービスコード情報を取得する。
		VRMap param = new VRHashMap();

		if (getSystemServiceCodeItem() != null &&
				getTekiyoStDate() != null) {
			param.setData("SYSTEM_SERVICE_CODE_ITEM", getSystemServiceCodeItem());
			param.setData("TEKIYO_ST_DATE", getTekiyoStDate());

			// 総合事業サービスコード情報を取得するためのSQL文を取得する。
			// 取得したSQL文を実行する。
			setSjServiceCodeInfoList(getDBManager().executeQuery(
					getSQL_GET_M_SJ_SERVICE_CODE_INFO(param)));
		}

		// レコードが取得できた場合
		if (getSjServiceCodeInfoList().size() > 0) {
			setPROCESS_MODE(String.valueOf(QkanConstants.PROCESS_MODE_UPDATE));
			// 取得したレコードをsjServiceCodeInfoMapに格納する。
			setSjServiceCodeInfoMap((VRMap) getSjServiceCodeInfoList().getData());
			// 総合事業サービスコード情報TABLEパッシブチェック用にデータを登録する。
			getPassiveChecker().reservedPassive(
					getM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(), getSjServiceCodeInfoList());
			// 画面状態を変更する。
			setState_UPDATE_STATE();

		} else {
			// レコードが取得できなかった場合
			setPROCESS_MODE(String.valueOf(QkanConstants.PROCESS_MODE_INSERT));

			setSjServiceCodeInfoMap((VRMap) getContents().createSource());
			getContents().setSource(getSjServiceCodeInfoMap());
			getContents().bindSource();
			// 画面状態を変更する。
			setState_INSERT_STATE();
		}
		
		// 取得した総合事業サービスコード情報を｢総合事業サービスコード情報入力領域｣に設定する。
		getSjServiceCodeInfos().setSource(getSjServiceCodeInfoMap());
		// 画面に展開する。
		getSjServiceCodeInfos().bindSource();

		// フォーカス処理
		if (getPROCESS_MODE().equals(
				String.valueOf(QkanConstants.PROCESS_MODE_INSERT))) {
			getInsurerIdText().requestFocus();
		} else {
			getTekiyoKikanEd().requestFocus();
			// サービス種類名称は、名称を表示する
			VRMap serviceCodeKindMap = (VRMap) getServiceCodeKindCombo().getSelectedItem();
			getServeceCodeKindNameText().setText(ACCastUtilities.toString(serviceCodeKindMap.get("SERVICE_NAME")));
		}
	}

	/**
	 * 「保存処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doSave() throws Exception {

		// 入力モードがINSERTの時
		if (getPROCESS_MODE().equals(
				Integer.toString(QkanConstants.PROCESS_MODE_INSERT))) {

			// サービス種類コードよりシステムサービス種類コードを取得する
			int systemServiceKindDetail = getSystemServiceKindDetail();
			if (systemServiceKindDetail == 0) {
				QkanMessageList.getInstance().QO017_ERROR_OF_FOR_INPUT_SYSTEM_KIND_DETAIL();
				getServiceCodeKindCombo().requestFocus();
				return false;
			}

			// システムサービス項目コードを組み立てる
			// 保険者番号＋システムサービス種類コード＋サービス項目コード
			StringBuilder sb = new StringBuilder();
			sb.append(getInsurerIdText().getText());
			sb.append(ACCastUtilities.toString(systemServiceKindDetail));
			sb.append(getServiceCodeItemText().getText());
			// 15桁でなかった場合はエラーにする
			if (sb.length() != 15) {
				QkanMessageList.getInstance().QO017_ERROR_OF_FOR_INPUT_SYSTEM_CODE_ITEM();
				getServiceCodeKindCombo().requestFocus();
				return false;
			}
			String systemServiceCodeItem = sb.toString();

			// 一時退避map
			VRMap map = new VRHashMap();
			map.setData("SYSTEM_SERVICE_CODE_ITEM", systemServiceCodeItem);
			map.setData("TEKIYO_ST_DATE", getTekiyoKikanSt().getDate());

			// 一時退避list
			VRList list = null;

			list = getDBManager().executeQuery(
					getSQL_GET_M_SJ_SERVICE_CODE_INFO_DELETE_FLAG(map));
			// 削除済みにデータがあるかどうかのチェックをする
			if (list.size() > 0) {
				int msgID = QkanMessageList.getInstance()
						.WARNING_OF_RESTORATION_OF_DELETE_DATA("総合事業サービスコード", "総合事業サービスコード");

				switch (msgID) {
				case ACMessageBox.RESULT_OK:
					setSystemServiceCodeItem(systemServiceCodeItem);
					setTekiyoStDate(getTekiyoKikanSt().getDate());
					doFind();
					return false;

				case ACMessageBox.RESULT_CANCEL:
					return false;
				}
			}

			list = getDBManager().executeQuery(getSQL_GET_M_SJ_SERVICE_CODE_INFO(map));
			// 既に登録済みかチェックする。
			if (list.size() > 0) {
				QkanMessageList.getInstance().QO017ERROR_OF_OVERLAP();
				getInsurerIdText().requestFocus();
				return false;
			}

			// 画面上では読み取れない情報を付加
			getSjServiceCodeInfoMap().setData("SYSTEM_SERVICE_CODE_ITEM", systemServiceCodeItem);
			getSjServiceCodeInfoMap().setData("SYSTEM_SERVICE_KIND_DETAIL", systemServiceKindDetail);

		}

		// 総合事業サービスコードの情報をDBに登録する。
		try {
			// トランザクションを開始する。
			getDBManager().beginTransaction();

			// パッシブタスクをクリアする。
			getPassiveChecker().clearPassiveTask();

			// 画面上の情報を取得しsjServiceCodeInfoMapに格納する
			getSjServiceCodeInfos().setSource(getSjServiceCodeInfoMap());
			getSjServiceCodeInfos().applySource();

			// 支給限度額対象区分が「対象」以外の場合、空文字列に変換
			if (!getShikyuGendogakuTaishoKbnTaisho().isSelected()) {
				getSjServiceCodeInfoMap().setData("SHIKYU_GENDOGAKU_TAISHO_KBN", "");
			}

			// 終了日 空白時 
			if (ACTextUtilities.isNullText(getTekiyoKikanEd().getText())) {
				getSjServiceCodeInfoMap().setData("TEKIYO_ED_DATE", MAX_DATE);
			} else {
				getSjServiceCodeInfoMap().setData("TEKIYO_ED_DATE", getTekiyoKikanEd().getDate());
			}

			getSjServiceCodeInfoList().clearData();
			getSjServiceCodeInfoList().addData(getSjServiceCodeInfoMap());

			// PROCESS_MODEの値をチェックする。
			if (getPROCESS_MODE().equals(
					String.valueOf(QkanConstants.PROCESS_MODE_INSERT))) {

				// 新規登録後、画面再表示の際にキーをセットしておく
				setSystemServiceCodeItem(String.valueOf(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM",
						getSjServiceCodeInfoMap())));
				setTekiyoStDate((Date) VRBindPathParser.get("TEKIYO_ST_DATE", getSjServiceCodeInfoMap()));

				getSjServiceCodeInfoMap().setData("KOKUHO_ITAKU_KBN", "1");// 委託区分は、新規の場合は「する」
				
				// パッシブタスクを登録する。（INSERT） ※総合事業サービスコード情報登録用
				getPassiveChecker().addPassiveInsertTask(
						getM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(),
						getSjServiceCodeInfoList());

			} else if (getPROCESS_MODE().equals(
					Integer.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
				// パッシブタスクを登録する。（UPDATE） ※総合事業サービスコード情報更新用
				getPassiveChecker().addPassiveUpdateTask(
						getM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY());
			}
			
			// パッシブチェックを行う
			if (!getPassiveChecker().passiveCheck(getDBManager())) {
				// パッシブエラーが発生した場合
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
				getDBManager().rollbackTransaction();
				return false;
			} else {
				// パッシブエラーが発生しなかった場合
				if (getPROCESS_MODE().equals(
						Integer.toString(QkanConstants.PROCESS_MODE_INSERT))) {

					// 総合事業サービスコード情報登録のためのSQL文を実行する。
					getDBManager().executeUpdate(
							getSQL_INSERT_M_SJ_SERVICE_CODE(getSjServiceCodeInfoMap()));

				} else {
					// 総合事業サービスコード情報更新のためのSQL文を実行する。
					getDBManager().executeUpdate(
							getSQL_UPDATE_M_SJ_SERVICE_CODE_INFO(getSjServiceCodeInfoMap()));
				}
			}
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
		// （正常終了）

		return true;
	}

	/**
	 * 「総合事業サービスコード情報入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doValidSjServiceCodeInfoCheck() throws Exception {
		// ｢保険者番号（insurerId）｣が入力されているかチェックする
		if (ACTextUtilities.isNullText(getInsurerIdText().getText())) {
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT 第1引数 =
			// "保険者番号"
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("保険者番号");
			// ｢保険者番号（insurerId）｣にフォーカスを当てる。
			getInsurerIdText().requestFocus();
			// 処理を抜ける。（処理を中断する）
			return false;
		}

		if (getInsurerIdText().getText().length() != 6) {
			QkanMessageList.getInstance().ERROR_OF_LENGTH("保険者番号", "6");
			// ｢保険者番号（insurerId）｣にフォーカスを当てる。
			getInsurerIdText().requestFocus();
			// 処理を抜ける。（処理を中断する）
			return false;
		}
		
		// 保険者番号が存在するかチェックする
		boolean insurerIdExists = false;
		String insureNo = getInsurerIdText().getText();
		for (int i = 0; getInsurerIdCombo().getModel().getSize() > i; i++) {
			VRMap map = (VRMap) getInsurerIdCombo().getModelItem(i);
			if (insureNo.equals(map.getData("INSURER_ID"))) {
				insurerIdExists = true;
				break;
			}
		}
		if (!insurerIdExists) {
			ACMessageBox.show("保険者番号が登録されていません。");
			getInsurerIdText().requestFocus();
			return false;
		}

		// サービス種類が入力されているかチェックする
		if (!getServiceCodeKindCombo().isSelected()) {
			QkanMessageList.getInstance()
			.ERROR_OF_NEED_CHECK_FOR_INPUT("サービス種類");
			getServiceCodeKindCombo().requestFocus();
			return false;
		}

		// サービス項目が入力されているかチェックする
		if (ACTextUtilities.isNullText(getServiceCodeItemText().getText())) {
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("サービス項目");
			getServiceCodeItemText().requestFocus();
			return false;
		}

		if (getServiceCodeItemText().getText().length() != 4) {
			QkanMessageList.getInstance().ERROR_OF_LENGTH("サービス項目", "4");
			getServiceCodeItemText().requestFocus();
			return false;
		}

		// 適用開始年月日が入力されているかチェックする
		if (ACTextUtilities.isNullText(getTekiyoKikanSt().getText())) {
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("適用開始年月日");
			getTekiyoKikanSt().requestFocus();
			return false;
		} else {
			// 日付型かどうかのチェック
			if (!getTekiyoKikanSt().isValidDate()) {
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("適用開始年月日");
				getTekiyoKikanSt().requestFocus();
				return false;
			}
		}

		// 適用終了年月日が入力されているかチェックする
		if (!ACTextUtilities.isNullText(getTekiyoKikanEd().getText())) {
			// 日付型かどうかのチェック
			if (!getTekiyoKikanEd().isValidDate()) {
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("適用終了年月日");
				getTekiyoKikanEd().requestFocus();
				return false;
			}
		}

		// （開始）＞（終了）かチェック
		if (!ACTextUtilities.isNullText(getTekiyoKikanSt().getText()) &&
				!ACTextUtilities.isNullText(getTekiyoKikanEd().getText())) {
			if (ACDateUtilities
					.compareOnDay(
							ACCastUtilities.toDate(getTekiyoKikanSt().getText()),
							ACCastUtilities.toDate(getTekiyoKikanEd().getText())) == 1) {
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("適用期間");
				getTekiyoKikanEd().requestFocus();
				return false;
			}
		}

		// サービス名称が入力されているかチェックする
		if (ACTextUtilities.isNullText(getServiceNameText().getText())) {
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("サービス名称");
			getServiceNameText().requestFocus();
			return false;
		}

		// 単位数が入力されているかチェックする
		if (ACTextUtilities.isNullText(getServiceUnitText().getText())) {
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("単位数");
			getServiceUnitText().requestFocus();
			return false;
		} else {
			if (getServiceUnitText().getText().equals("-")) {
				QkanMessageList.getInstance()
				.ERROR_OF_NEED_CHECK_FOR_INPUT("単位数");
				getServiceUnitText().requestFocus();
				return false;
			}
		}

		// 算定単位が入力されているかチェックする
		if (!getSanteiTaniCombo().isSelected()) {
			QkanMessageList.getInstance()
			.ERROR_OF_NEED_CHECK_FOR_INPUT("算定単位");
			getSanteiTaniCombo().requestFocus();
			return false;
		}

		// 支給限度額対象区分が入力されているかチェックする
		if (!getShikyuGendogakuTaishoKbn().isSelected()) {
			QkanMessageList.getInstance()
			.ERROR_OF_NEED_CHECK_FOR_INPUT("支給限度額対象区分");
			getShikyuGendogakuTaishoKbn().requestFocus();
			return false;
		}

		// 給付率に入力されている値が不正でないかどうか
		int benefitRate = ACCastUtilities.toInt(getKyufuritsuText().getText(), 0);
		if (benefitRate < 0 || benefitRate > 100) {
			QkanMessageList.getInstance().ERROR_OF_VALUE_TOO_MUCH(
					"給付率", "100");
			getKyufuritsuText().requestFocus();
			return false;
		}

		if (!ACTextUtilities.isNullText(getFutangakuText().getText()) &&
				(getFutangakuText().getText().equals("-"))) {
			QkanMessageList.getInstance()
			.ERROR_OF_NEED_CHECK_FOR_INPUT("利用者負担額");
			getFutangakuText().requestFocus();
			return false;
		}

		// 事業対象者実施区分が入力されているかチェックする
		if (!getJigyoJisshiKbnCombo().isSelected()) {
			QkanMessageList.getInstance()
			.ERROR_OF_NEED_CHECK_FOR_INPUT("事業対象者実施区分");
			getJigyoJisshiKbnCombo().requestFocus();
			return false;
		}

		// 要支援１実施区分が入力されているかチェックする
		if (!getYoshien1JisshikbnCombo().isSelected()) {
			QkanMessageList.getInstance()
			.ERROR_OF_NEED_CHECK_FOR_INPUT("要支援１受給者実施区分");
			getYoshien1JisshikbnCombo().requestFocus();
			return false;
		}

		// 要支援２実施区分が入力されているかチェックする
		if (!getYoshien2JisshikbnCombo().isSelected()) {
			QkanMessageList.getInstance()
			.ERROR_OF_NEED_CHECK_FOR_INPUT("要支援２受給者実施区分");
			getYoshien2JisshikbnCombo().requestFocus();
			return false;
		}

		// 作成年月日が入力されているかチェックする
		if (ACTextUtilities.isNullText(getSakuseiDate().getText())) {
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("作成年月日");
			getSakuseiDate().requestFocus();
			return false;
		} else {
			// 日付型かどうかのチェック
			if (!getSakuseiDate().isValidDate()) {
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("作成年月日");
				getSakuseiDate().requestFocus();
				return false;
			}
		}

		return true;
	}

	/**
	 * 「新規登録モードに変更する処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void insertModeChange() throws Exception {
		// 新規登録モードに変更する処理
		// 画面クリアのためallClearMapを生成する。
		VRMap allClearMap = new VRHashMap();
		// allClearMapのソースを生成する。（新規登録時クリア処理に用いる）
		allClearMap = (VRMap) getSjServiceCodeInfos().createSource();
		getSjServiceCodeInfos().setSource(allClearMap);
		getSjServiceCodeInfos().bindSource();
		
		// 前画面から引き継いだ保険者番号をセット
		if (!ACTextUtilities.isNullText(getInsurerId())) {
			getInsurerIdText().setText(getInsurerId());
			// 保険者コンボを表示する
			insurerComboSelected();
		}

		// PROCESS_MODEを、共通定数の｢PROCESS_MODE_INSERT(4)｣にする。
		setPROCESS_MODE(Integer.toString(QkanConstants.PROCESS_MODE_INSERT));
	}

	/**
	 * 「画面をクリアする処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void allClear() throws Exception {
		insertModeChange();
		// 画面の状態を変更する。
		setState_INIT_STATE();
		// フォーカス設定
		getInsurerIdText().requestFocus();
	}

	/**
	 * 「スナップショットを撮影する処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void snapshotCustom() throws Exception {
		// スナップショットを撮影する処理
		// スナップショットの撮影対象を指定する。
		getSnapshot().setRootContainer(getContents());
		// スナップショットを撮影する
		getSnapshot().snapshot();
	}
	
	/**
	 * サービス種類コードよりシステムサービス種類コードを取得する
	 */
	private int getSystemServiceKindDetail() throws Exception, ParseException {
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
		// システムサービス種類コードを取得する（M_SERVICE）
		VRMap serviceCodeKindMap = (VRMap) getServiceCodeKindCombo().getSelectedItem();
		String serviceCodeKind = ACCastUtilities.toString(serviceCodeKindMap.get("SERVICE_CODE_KIND"));
		int systemServiceKindDetail = ACCastUtilities.toInt(mServiceKeyMap.get(serviceCodeKind), 0);
		return systemServiceKindDetail;
	}


	/**
	 * 「コードマスタデータの指定キーのデータ型をIntegerからStringに変換」に関する処理を行ないます。
	 * 
	 * @throws Exception 処理例外
	 */
	private static VRList convertValueFromIntegerToString(int codeId, String key, String formatLength)
			throws Exception {
		VRList codeList = QkanCommon.getArrayFromMasterCode(codeId, key);
		if ((codeList != null) && (key != null)) {
			for (int i = 0; i < codeList.size(); i++) {
				VRMap map = (VRMap)codeList.get(i);
				Object targetData = VRBindPathParser.get(key, map);
				String convertValue = "";
				if (formatLength == null) {
					convertValue = ACCastUtilities.toString(targetData, null);
				} else {
					String targetFormat = "%" + formatLength + "s";
					convertValue = String.format(targetFormat, targetData).replace(" ", "0");
				}
				VRBindPathParser.set(key, map, convertValue);
			}
		}
		return codeList;
    }
	
	// 保険者コンボを表示する
	private void insurerComboSelected() {
		// 保険者コンボを表示する
		String insureNo = getInsurerIdText().getText();
		for (int i = 0; getInsurerIdCombo().getModel().getSize() > i; i++) {
			VRMap map = (VRMap) getInsurerIdCombo().getModelItem(i);
			if (insureNo.equals(map.getData("INSURER_ID"))) {
				getInsurerIdCombo().setSelectedIndex(i);
				break;
			}
		}
	}



}
