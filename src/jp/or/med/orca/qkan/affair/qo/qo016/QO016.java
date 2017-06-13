
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
 * 作成日: 2016/09/14  日本コンピューター株式会社  新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 総合事業サービスコード管理 (016)
 * プログラム 総合事業サービスコード一覧 (QO016)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo016;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceUnitGetter;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.bridge.sql.BridgeFirebirdSeparateTable;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qo.qo017.QO017;

/**
 * 総合事業サービスコード一覧(QO016) 
 */
public class QO016 extends QO016Event {
	/**
	 * コンストラクタです。
	 */
	public QO016(){
	}

	public void initAffair(ACAffairInfo affair) throws Exception  {
		super.initAffair(affair);
		initAction(affair);
	}
	/**
	 * 初期化処理を行ないます。
	 * @param affair 業務情報
	 * @throws Exception 処理例外
	 */
	protected void initAction(ACAffairInfo affair) throws Exception {
		// 画面の初期表示を行う処理
		
		// ※ウィンドウタイトルの設定
		setAffairTitle("QO016", getButtons());

		// ｢総合事業サービスコード情報TABLE（M_SJ_SERVICE_CODE)｣のパッシブチェックキーを定義する。
		setM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(new ACPassiveKey("M_SJ_SERVICE_CODE",
				new String[] { "SYSTEM_SERVICE_CODE_ITEM", "TEKIYO_ST_DATE" }, new Format[] {
				ACConstants.FORMAT_SQL_STRING, new ACSQLSafeDateFormat("yyyy-MM-dd") },
				"LAST_TIME", "LAST_TIME"));

		// 渡りパラメータを退避する。
		VRMap params = affair.getParameters();
		
		// 対象年月の設定
		// 画面の「対象年月(targetDate)」に、取得したシステム日付を設定する。
		Date sysDate = QkanSystemInformation.getInstance().getSystemDate();
		getTargetDate().setDate(sysDate);

		// 保険者コンボの項目を設定する。
		VRMap comboInsureMap = new VRHashMap();
		comboInsureMap.setData("INSURER_ID", QkanCommon.getInsurerInfo(getDBManager()));
		getInsurerNoCombo().setModelSource(comboInsureMap);
		getInsurerNoCombo().bindModelSource();

		// サービス種類コンボの項目を設定する。
		VRMap comboMap = new VRHashMap();
		comboMap.setData("SERVICE_CODE_KIND", QkanSjServiceCodeManager.getMasterServiceSogojigyo(getDBManager(), sysDate));
		// comboMapを｢クライアント領域（contents）｣に設定する。
		getServiceCodeKindCombo().setModelSource(comboMap);
		getServiceCodeKindCombo().bindModelSource();

		// ※テーブルモデルを定義する。
		ACTableModelAdapter sjServiceCodeInfoTableModel = new ACTableModelAdapter();
		sjServiceCodeInfoTableModel.setColumns(new String[] { 
				"SERVICE_CODE_KIND+'-'+SERVICE_CODE_ITEM",
				"TEKIYO_ST_DATE",
				"TEKIYO_ED_DATE",
				"SERVICE_NAME",
				"SERVICE_UNIT",
				"SAKUSEI_DATE"
		});
		// ※アダプタをテーブルのモデルとして設定する。
		setSjServiceCodeInfoTableModel(sjServiceCodeInfoTableModel);
		getSjServiceCodeInfoTable().setModel(getSjServiceCodeInfoTableModel());

		// もしparamsがnullの場合処理を終了する
		if (params == null) {
			return;
		}

		// サービスコード履歴IDをセット(取込画面から遷移した場合)
		if (VRBindPathParser.has("SJ_SERVICE_CODE_HISTORY_ID", params)) {
			setSjServiceCodeHistoryId(String.valueOf(VRBindPathParser.get("SJ_SERVICE_CODE_HISTORY_ID",
					params)));
		}

		// 保険者番号を検索条件にセット(取込画面から遷移した場合)
		if (VRBindPathParser.has("INSURER_ID", params)) {
			getInsurerNoText().setText(ACCastUtilities.toString(VRBindPathParser.get(
					"INSURER_ID", params)));
			// 保険者コンボを表示する
			String insureNo = getInsurerNoText().getText();
			for (int i = 0; getInsurerNoCombo().getModel().getSize() > i; i++) {
				VRMap map = (VRMap) getInsurerNoCombo().getModelItem(i);
				if (insureNo.equals(map.getData("INSURER_ID"))) {
					getInsurerNoCombo().setSelectedIndex(i);
					break;
				}
			}
		}

		// 詳細編集画面から戻ってきた場合の再描画処理
		if( VRBindPathParser.has("QO016_DATA", params) ){
			VRMap memory = (VRMap)VRBindPathParser.get("QO016_DATA", params);
			this.setSource( memory );
			this.bindSource();
			params.removeData("QO016_DATA");
		}
		
		doFind();
		
		// 渡りパラメーターの中に前画面のシステムサービス項目コード、適用開始年月日があるかチェックする
		if (VRBindPathParser.has("SYSTEM_SERVICE_CODE_ITEM", params) &&
				VRBindPathParser.has("TEKIYO_ST_DATE", params)) {

			// 詳細画面で選択されていた総合事業サービスコードと合致するレコードのindexを取得する。
			String key1 = ACCastUtilities.toString(params.get("SYSTEM_SERVICE_CODE_ITEM"));
			VRDateFormat df = new VRDateFormat();
			String key2 = df.format((Date) params.get("TEKIYO_ST_DATE"), "yyyy-MM-dd");

            int index = -1;
			for(int i = 0; i < getSjServiceCodeInfoList().size(); i++){
				VRMap map = (VRMap)getSjServiceCodeInfoList().get(i);
				if(ACCastUtilities.toString(map.get("SYSTEM_SERVICE_CODE_ITEM")).equals(key1) &&
						ACCastUtilities.toString(map.get("TEKIYO_ST_DATE")).equals(key2)){
					index = i;
					break;
				}
			}
			// 一致する
			if (index != -1) {
				// 詳細からの総合事業サービスコードを選択状態にする
				getSjServiceCodeInfoTable().setSelectedModelRow(index);

			} else {
				// レコードの1行目を選択状態にする。
				getSjServiceCodeInfoTable().setSelectedSortedFirstRow();
			}

		} else {
			// レコードの1行目を選択状態にする。
			getSjServiceCodeInfoTable().setSelectedSortedFirstRow();

		}
		// 選択総合事業サービスコードにスクロールする
		getSjServiceCodeInfoTable().scrollSelectedToVisible();

		params.clear();

	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		
		parameters.setData("SJ_SERVICE_CODE_HISTORY_ID", getSjServiceCodeHistoryId());

		// 前画面に遷移する。
		return true;
	}

	//コンポーネントイベント

	/**
	 * 「検索処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void findActionPerformed(ActionEvent e) throws Exception{

		// 検索を行ってよいか確認を行う。
		if (!checkFind()) {
			return;
		}

		// 検索を行う。
		doFind();
		
		//レコードの1行目を選択状態にする。
		getSjServiceCodeInfoTable().setSelectedSortedFirstRow();

	}

	/**
	 * 「総合事業サービスコード登録画面に遷移（更新）」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void detailActionPerformed(ActionEvent e) throws Exception{
		moveQO017();
	}

	/**
	 * 「総合事業サービスコード登録画面に遷移（新規）」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception{
		// 画面情報の退避
		VRHashMap memory = new VRHashMap();
		this.setSource( memory );
		this.applySource();
		ACFrame.getInstance().addNowAffairParameter("QO016_DATA", memory);

		// 総合事業サービスコード情報登録画面に新規登録モードで遷移する処理
		VRMap param = new VRHashMap();
		param.setData("PROCESS_MODE", new Integer(
				QkanConstants.PROCESS_MODE_INSERT));
		param.setData("INSURER_ID", getInsurerNoText().getText());

		// 次画面遷移のためのパラメーターACAffairInfo affairを定義する。
		ACAffairInfo affair = null;
		affair = new ACAffairInfo(QO017.class.getName(), param);

		// ｢QO017（総合事業サービスコード登録）｣に遷移する。
		ACFrame.getInstance().next(affair);

	}

	/**
	 * 「削除処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void deleteActionPerformed(ActionEvent e) throws Exception{
		
    	// 画面の｢総合事業サービスコード一覧｣の行が選択されているかチェックする。
		// 選択されている場合
		if (getSjServiceCodeInfoTable().isSelected()) {

			// 選択サービスコードが使用されているかどうかチェックする。
			if (!checkSjServiceCode()) {
				// エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_DELETE_USED("予定、または実績");
				// 処理を抜ける。（処理を中断する）
				return;

			} else {

				VRMap tableData = (VRMap) getSjServiceCodeInfoTable()
						.getSelectedModelRowValue();
				setSystemServiceCodeItem((String.valueOf(tableData.getData("SYSTEM_SERVICE_CODE_ITEM"))));
				setTekiyoStDate((Date) VRBindPathParser.get("TEKIYO_ST_DATE",tableData));
	
				// 削除確認メッセージを表示する。※メッセージID = WARNING_OF_DELETE
				int msgID = QkanMessageList.getInstance().WARNING_OF_DELETE(
						"選択中の総合事業サービスコード情報");
	
				// ｢はい｣押下時
				if (msgID == ACMessageBox.RESULT_YES) {
	
					// 現在の選択行を退避する
					int sel = getSjServiceCodeInfoTable().getSelectedModelRow();
	
					// 削除処理を行う。
					if (!doDelete()) {
						// 何らかのエラーが発生した場合処理を中断する
						return;
					}
	
					// 削除後の理想となる行番号を設定する
					getSjServiceCodeInfoTable()
					.setSelectedSortedRowOnAfterDelete(sel);
	
				}
			}

			// ｢いいえ｣押下時
			// 処理を抜ける。（処理を行わない）
			return;
		}
	}

	/**
	 * 「対象レコードを表示」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void sjServiceCodeInfoTableSelectionChanged(ListSelectionEvent e) throws Exception{
		// ※画面の制御
		if (!getSjServiceCodeInfoTable().isSelected()) {
			// 選択されていない場合
			// 業務ボタンの状態を変更する。
			setState_UNSELECTED();
			// ・状態ID：UNSELECTED
		} else {
			// 選択されている場合
			// 業務ボタンの状態を変更する。
			setState_SELECTED();
			// ・状態ID：SELECTED
		}
	}

	/**
	 * 「画面遷移処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void sjServiceCodeInfoTableMouseClicked(MouseEvent e) throws Exception{
		moveQO017();
	}

	/**
	 * 「保険者名表示」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insurerNoTextFocusLost(FocusEvent e) throws Exception {

		String insureNo = getInsurerNoText().getText();
		for (int i = 0; getInsurerNoCombo().getModel().getSize() > i; i++) {
			VRMap map = (VRMap) getInsurerNoCombo().getModelItem(i);
			if (insureNo.equals(map.getData("INSURER_ID"))) {
				getInsurerNoCombo().setSelectedIndex(i);
				return;
			}
		}
		getInsurerNoCombo().setSelectedItem(null);

	}
	
	/**
	 * 「保険者名称コンボボックス選択時の処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insurerNoComboActionPerformed(ActionEvent e)
			throws Exception {
		// 選択されたコンボのインデックス
		int index = getInsurerNoCombo().getSelectedIndex();

		if (index < 0)
			return;

		VRMap map = (VRMap) getInsurerNoCombo().getSelectedItem();
		String insureNo = ACCastUtilities.toString(map.get("INSURER_ID"));

		if (insureNo == null)
			return;

		// 画面上に設定する。
		getInsurerNoText().setText(insureNo);
	}

	public static void main(String[] args) {
		//デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		//paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QO016.class.getName(), param));
	}

	//内部関数

	/**
	 * 「レコードを取得し画面に設定する。」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public void doFind() throws Exception{

		if (!ACTextUtilities.isNullText(getInsurerNoText().getText())) {
			doFindData();
		}

		if (!getSjServiceCodeInfoList().isEmpty()) {
			// レコードが1件以上の場合
			// 取得した全保険者情報（insurerInfoList）をinsurerTableModelに設定する。
			getSjServiceCodeInfoTableModel().setAdaptee(getSjServiceCodeInfoList());
			// 総合事業サービスコード情報TABLEパッシブチェック用にデータを登録する。
			getPassiveChecker().reservedPassive(
					getM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(), getSjServiceCodeInfoList());

		} else {
			// 情報が取得できなかった場合
			getSjServiceCodeInfoList().clearData();
			getSjServiceCodeInfoTableModel().setAdaptee(getSjServiceCodeInfoList());

			// 画面状態を変更する
			setState_UNSELECTED();
		}

	}

	/**
	 * 「選択総合事業サービスコード削除処理」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public boolean doDelete() throws Exception{
		// 総合事業サービスコード情報を削除する処理
		try {
			// トランザクションを開始する。
			getDBManager().beginTransaction();
			// パッシブタスクをクリアする。
			getPassiveChecker().clearPassiveTask();
			// パッシブタスクを追加する。（総合事業サービスコード情報削除用）
			getPassiveChecker().addPassiveUpdateTask(
					getM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY());

			// パッシブチェックを実行する。
			if (!getPassiveChecker().passiveCheck(getDBManager())) {
				//テーブルロック解除のためロールバック
				getDBManager().rollbackTransaction();
				// パッシブエラーがある場合
				// エラーメッセージを表示する。
				QkanMessageList.getInstance()
				.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
				// 処理を抜ける。（処理を中断する）
				return false;
			}

			// パッシブエラーがない場合
			// 総合事業サービスコード情報削除用のSQL文を取得する。
			// SQL文取得のためVRMap：paramを作成し、下記のパラメーターを設定する。
			VRMap param = new VRHashMap();
			param.setData("SYSTEM_SERVICE_CODE_ITEM", getSystemServiceCodeItem());
			param.setData("TEKIYO_ST_DATE", getTekiyoStDate());

			// 総合事業サービスコード情報削除用のSQL文を取得する
			// 取得したSQL文を実行する。
			getDBManager().executeUpdate(getSQL_UPDATE_TO_DELETE_M_SJ_SERVICE_CODE(param));
			// 処理したSQL文の実行中に1つもエラーが発生しなかった場合
			// コミットする。
			getDBManager().commitTransaction();
			// 総合事業サービスコード関連情報を取得しパッシブチェック用に退避する。
			doFind();
			// 正常終了
			return true;
		} catch (Exception sqlEx) {
			// 処理したSQL文の実行中に1つでもエラーが発生した場合
			// 処理をロールバックする。
			getDBManager().rollbackTransaction();
			// 処理を抜ける。（処理を中断する）
			throw sqlEx;
		}
	}

	/**
	 * 「検索条件のチェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkFind() throws Exception {
		// 保険者番号未入力チェック
		if (ACTextUtilities.isNullText(getInsurerNoText().getText())) {
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("保険者番号");
			getInsurerNoText().requestFocus();
			return false;
		}
		// 対象年月妥当性チェック
		if (!ACTextUtilities.isNullText(getTargetDate().getText())) {
			if (!getTargetDate().isValidDate()) {
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("対象年月の");
				getTargetDate().requestFocus();
				return false;
			}
		}

		return true;

	}

	/**
	 * 「検索処理を行う。」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public void doFindData() throws Exception{
		// ■DBからサービスコード一覧を取得、画面に設定
		VRMap findParam = new VRHashMap();

		getSjServiceCodeInfoFind().setSource(findParam);

		// 検索処理用に｢検索条件領域（findContens）｣のデータを取得しfindParamに格納する。
		getSjServiceCodeInfoFind().applySource();

		// SQL文を実行する。
		setSjServiceCodeInfoList(getDBManager().executeQuery(
				getSQL_GET_M_SJ_SERVICE_CODE_INFO(findParam)));

	}
	
	/**
	 * 「システムサービス項目コードが使用されているかチェックする」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public boolean checkSjServiceCode() throws Exception{
		
		VRMap tableData = (VRMap) getSjServiceCodeInfoTable()
				.getSelectedModelRowValue();
		
		// システムサービス項目コードが使用されているかチェックする処理
		// 内部変数 sqlParamを生成し下記のKEY/VALUEを設定する。
		VRMap sqlParam = new VRHashMap();
		sqlParam.setData("SJ_SERVICE_CODE_BIND_PATH_ST", 
				Qkan10011_ServiceUnitGetter.SJ_SERVICE_CODE_BIND_PATH_ST);
		sqlParam.setData("SJ_SERVICE_CODE_BIND_PATH_ED", 
				Qkan10011_ServiceUnitGetter.SJ_SERVICE_CODE_BIND_PATH_ED);
		sqlParam.setData("SYSTEM_SERVICE_CODE_ITEM", 
				(String.valueOf(tableData.getData("SYSTEM_SERVICE_CODE_ITEM"))));
		
		for (int year = 2015; year < 2099; year++) {
			sqlParam.setData("YEAR", year);

			// テーブルが存在するか
			BridgeFirebirdSeparateTable table = new BridgeFirebirdSeparateTable("SERVICE_DETAIL_TEXT", "");
			if (table.isExistTable(getDBManager(), year)) {
				// システムサービス項目コード取得のためのSQL文を取得する。
				VRList list = getDBManager().executeQuery(
						getSQL_GET_M_SJ_SERVICE_CODE_INFO_IN_USE(sqlParam));

				if (Integer.parseInt(String.valueOf(VRBindPathParser
						.get("CNT", (VRMap) list.getData(0)))) > 0) {
					// レコードが1件以上取得できた場合、削除不可能として処理を返す(false)
					return false;
				}
			} else {
				return true;
			}

		}

		// レコードが取得できなかった場合、削除可能として処理を返す(true)
		return true;
	}

	/**
	 * 「総合事業サービスコード登録画面に遷移（更新）」に関する処理を行ないます。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
    public void moveQO017() throws Exception {
		// 総合事業サービスコード情報登録画面に更新モードで遷移する処理
		// 画面の｢総合事業サービスコード一覧｣が選択されているかチェックする。
		if (getSjServiceCodeInfoTable().isSelected()) {
			// 選択されていた場合
			
			// 選択サービスコードが使用されているかどうかチェックする。
			if (!checkSjServiceCode()) {
				// 警告メッセージを表示する。
				if (QkanMessageList.getInstance().QO016_WARNING_OF_SJ_SERVICE_CODE_USE() != ACMessageBox.RESULT_OK) {
					return;
				}
			}
			
			// 画面情報の退避
			VRHashMap memory = new VRHashMap();
			this.setSource( memory );
			this.applySource();
			ACFrame.getInstance().addNowAffairParameter("QO016_DATA", memory);
	
			// 選択システムサービス項目コードをsystemServiceCodeItemに格納する。
			VRMap rec = (VRMap) getSjServiceCodeInfoTable()
					.getSelectedModelRowValue();
	
			// VPMap：paramを生成しパラメーターを格納する。
			VRMap param = new VRHashMap();
			param.setData("SYSTEM_SERVICE_CODE_ITEM", rec.getData("SYSTEM_SERVICE_CODE_ITEM"));
			param.setData("TEKIYO_ST_DATE", rec.getData("TEKIYO_ST_DATE"));
			param.setData("PROCESS_MODE", new Integer(
					QkanConstants.PROCESS_MODE_UPDATE));

			// 次画面遷移のためのパラメーターNCAffairInfo affairを定義する。
			ACAffairInfo affair = null;
	
			affair = new ACAffairInfo(QO017.class.getName(), param);
	
			// ｢QO017（総合事業サービスコード登録）｣に遷移する。
			ACFrame.getInstance().next(affair);
	
		}
    }

}
