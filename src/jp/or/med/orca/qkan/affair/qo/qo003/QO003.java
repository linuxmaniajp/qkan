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
 * 開発者: 樋口　雅彦
 * 作成日: 2006/01/13  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所一覧 (003)
 * プログラム 事業所一覧 (QO003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo003;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.util.List;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qm.qm002.QM002;
import jp.or.med.orca.qkan.affair.qo.qo004.QO004;
import jp.or.med.orca.qkan.text.QkanProviderAreaTypeFormat;
import jp.or.med.orca.qkan.text.QkanProviderJigyoTypeFormat;
import jp.or.med.orca.qkan.text.QkanProviderTypeFormat;

/**
 * 事業所一覧(QO003)
 */
public class QO003 extends QO003Event {
	/**
	 * コンストラクタです。
	 */
	public QO003() {
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
		setPROVIDER_PASSIVE_CHECK_KEY(new ACPassiveKey("PROVIDER",
				new String[] { "PROVIDER_ID" },new boolean[] { true },
				 "LAST_TIME","LAST_TIME"));

		// 渡りパラメータを退避する。
		// medicalFacilityId = MEDICAL_FACILITY_ID（医療機関ID）
		VRMap parameters = affair.getParameters();
		// データが存在しているかをチェック
		if (VRBindPathParser.has("PROVIDER_ID", parameters)) {

			// int型に型変換し利用者IDを退避
			setProviderId(String.valueOf(VRBindPathParser.get("PROVIDER_ID",
					parameters)));

			// 二重に起動しないようにキーを削除
			parameters.remove("PROVIDER_ID");
		}

		// 画面展開時の初期設定及び初期表示処理を行います。
		QkanCommon.getAffairInfo(getDBManager(), "QO001");
		// 業務マスタより、データを取得する。
		QkanCommon.getAffairInfo(getDBManager(), "QO001");
		// 取得したデータのウインドウタイトル（WINDOW_TITLE）をウインドウに設定する。
		// 取得したデータの業務タイトル（AFFAIR_TITLE）を業務ボタンバーに設定する。
		setAffairTitle("QO003", "0", getButtons());

		// テーブルモデルを定義する。
		ACTableModelAdapter model = new ACTableModelAdapter();

		model
				.setColumns(new String[] {
						"PROVIDER_TYPE",
						"PROVIDER_ID",
						"PROVIDER_NAME",
						"PROVIDER_ZIP_FIRST+'-'+PROVIDER_ZIP_SECOND",
						"PROVIDER_ADDRESS",
						"PROVIDER_TEL_FIRST+'-'+PROVIDER_TEL_SECOND+'-'+PROVIDER_TEL_THIRD",
						"PROVIDER_FAX_FIRST+'-'+PROVIDER_FAX_SECOND+'-'+PROVIDER_FAX_THIRD",
						"PROVIDER_JIGYOU_TYPE", "PROVIDER_AREA_TYPE",
						"STAFF_FAMILY_NAME+'　'+STAFF_FIRST_NAME", });

		setProviderTableModel(model);

		// テーブルモデルを下記の画面のテーブルに設定する。
		// 事業所情報テーブル（providerTable) テーブルモデル：providerTableModel
		getProviderTable().setModel(getProviderTableModel());

		getProviderTypeColumn().setFormat(QkanProviderTypeFormat.getInstance());
		getProviderDivisionColumn().setFormat(
				QkanProviderJigyoTypeFormat.getInstance());
		getProviderRegionColumn().setFormat(
				QkanProviderAreaTypeFormat.getInstance());

		// DBより事業所情報を取得し、画面に展開する。
		//setAffairMap(affair.getParameters());

		// 事業所種別コンボの項目を設定する。
		// コードマスタから下記のCODE_IDのレコードを抽出し、下記のKEYでcomboMapに設定する。
		VRMap comboMap = new VRHashMap();
		// ・
		comboMap.setData("PROVIDER_TYPE", QkanCommon.getArrayFromMasterCode(
				195, "PROVIDER_TYPE"));

		// comboMapを｢クライアント領域（contents）｣に設定する。
		getFindContentproviderType().setModelSource(comboMap);
		getFindContentproviderType().bindModelSource();
		
		doFind();
		// providerListのレコードが1件以上の場合
		if (getProviderList().size() > 0) {
			// 渡りパラメータとして事業所番号が渡されていた場合
			if (getProviderId() != null) {
				// 渡された事業所番号を選択した状態にする。
				VRList temp = (VRList) getProviderTableModel().getAdaptee();
				int index = ACBindUtilities.getMatchIndexFromValue(temp,
						"PROVIDER_ID", getProviderId());
				getProviderTable().setSelectedModelRow(index);

				// 渡りパラメータとして事業所番号が渡されていない場合
			} else {
				// テーブルの1行目を選択状態にする。
				getProviderTable().setSelectedSortedFirstRow();
			}
		}
	}

	// コンポーネントイベント

	/**
	 * 「検索処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void findActionPerformed(ActionEvent e) throws Exception {
		// 画面復元用のデータを作成する。
		createFindState();
		
		// 検索処理
		// 検索処理を行う。
		doFindProvider();

	}

	/**
	 * 「事業所登録画面に遷移（更新）」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void detailActionPerformed(ActionEvent e) throws Exception {
		// ※選択されている医療機関の情報で「事業所登録画面（QO004）」画面に遷移
		// 次画面に遷移する。
		transferNext();
	}

	/**
	 * 「事業所登録画面に遷移（登録）」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {
		// 事業所登録画面に遷移する処理（登録）
		// VRMap：paramを作成し画面遷移用のパラメーターを格納する。
		VRMap param = new VRHashMap();

		// KEY：PROCESS_MODE VALUE：共通定数の｢PROCESS_MODE_INSERT(4)｣
		param.setData("PROCESS_MODE", new Integer(
				QkanConstants.PROCESS_MODE_INSERT));

		// 次画面遷移のためパラメーターNCAffairInfo affairを定義する。
		ACAffairInfo affair = null;
		// 下記のパラメーターでaffairを生成する。
		// className：QO004.class.getName() parameters：param
		affair = new ACAffairInfo(QO004.class.getName(), param);
		// ｢事業所登録画面（QO004）｣に遷移する。
		ACFrame.getInstance().next(affair);

	}

	/**
	 * 「削除処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void deleteActionPerformed(ActionEvent e) throws Exception {
		// 選択事業所の情報を削除する処理
		if (getProviderTable().getSelectedSortedRow() == -1) {
			// 選択されていない場合
			// 処理を中断する。
			return;
		}

		// 選択されている事業所番号をproviderIdに退避する。
		// 一時利用HashMap
		VRMap providerIDMap = new VRHashMap();
		providerIDMap = (VRMap) getProviderTable().getSelectedModelRowValue();
		setProviderId(String.valueOf(VRBindPathParser.get("PROVIDER_ID",
				providerIDMap)));

		// 現在の選択行を退避する
		int sel = getProviderTable().getSelectedModelRow();

		// 削除可否判別チェックを行う。
		doDeleteCheck();

		// 削除可だった場合(True)
		// 削除確認を行う。※メッセージID = WARNING_OF_DELETE 引数 = "選択されている事業所"
		if (doDeleteCheck()) {
			int msgID = QkanMessageList.getInstance().WARNING_OF_DELETE(
					"選択中の事業所");
			// ｢OK｣押下時
			// 削除処理を行う。
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				if (!doDelete()) {
					return;
				}
				break;

			case ACMessageBox.RESULT_CANCEL:
				// 「キャンセル」選択時
				return;
			// 処理を中断する。
			}
            
            if(QkanSystemInformation.getInstance().getLoginProviderID().equals(getProviderId())){
                //削除対象がログイン事業所の場合
//遷移履歴から直前の履歴を削除し、ログイン画面へ強制的に戻すようにする。
                List history = ACFrame.getInstance().getTraceAffairs();
                if(history!=null){
                    int size=history.size();
                    if(size>2){
                        //直前の画面（メインメニュー）をなかったことにする
                        ACFrame.getInstance().getTraceAffairs().remove(size-2);
                    }
                }
//                削除完了メッセージを表示する。※メッセージID = QO003_DELETE_SUCCESSED_AND_MUST_LOGOUT
//                QkanMessageList.getInstance().QO003_DELETE_SUCCESSED_AND_MUST_LOGOUT();
            }
//            }else{
//
//			// 削除完了メッセージを表示する。※メッセージID = DELETE_SUCCESSED
//                QkanMessageList.getInstance().DELETE_SUCCESSED();
//            }

			// 削除後、削除したデータのひとつ上を選択する。
			getProviderTable().setSelectedSortedRowOnAfterDelete(sel);

			// 削除不可だった場合(false)
		} else {
			// エラーメッセージを表示する。 ※メッセージID = ERROR_OF_DELETE_USED 引数 = 第1引数
			QkanMessageList.getInstance().ERROR_OF_DELETE_USED(
					getDeleteErrorMsg());
			// 第1引数：deleteErrorMsg
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
	protected void providerTableMouseClicked(MouseEvent e) throws Exception {
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
		ACFrame.debugStart(new ACAffairInfo(QO003.class.getName(), param));
	}

	// 内部関数

	/**
	 * 「事業所情報取得処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFind() throws Exception {
		// 事業所情報テーブルに表示するデータを取得する処理
		// 画面遷移パラメタに KEY："検索条件"が存在するかチェックする。
		VRMap param = getAffairMap();

		if (VRBindPathParser.has("検索条件", param)) {
			// 存在した場合
			// HashMap：memoryを作成する。
			// VRMap memory = new VRHashMap();
			// KEY："検索条件"の値をmemoryに格納する。
			VRMap memory = new VRHashMap();
			memory = (VRMap) VRBindPathParser.get("検索条件", param);
			// memoryをcontents（クライアント領域）のソースとして設定する。
			this.setSource(memory);
			// 画面に展開する。
			this.bindSource();

			//doFindProvider();

			// 二重に復元しないようにキーを削除する。
			param.remove("検索条件");
		} else {
			// 存在しなかった場合
			// 事業所情報を取得すためのSQL文を取得する。
			// getSQL_GET_PROVIDER(null);
			// 取得したSQL文を実行する。
			// getDBManager().executeQuery(getSQL_GET_PROVIDER(null));
			// レコードが取得できた場合
			// providerListに取得したレコード集合を格納する。
			setProviderList(getDBManager().executeQuery(
					getSQL_GET_PROVIDER(null)));

			// スタッフ情報を取得しproviderList内の該当事業所に情報を設定する。
			//if (getProviderList().size() > 0) {
				doFindStaff();

			//}
		}

		// パッシブチェック用のデータを登録する。
		getPassiveChecker().reservedPassive(getPROVIDER_PASSIVE_CHECK_KEY(),
				getProviderList());

		// 取得した事業所情報（providerList）をproviderTableModelに設定する。
		getProviderTableModel().setAdaptee(getProviderList());

	}

	/**
	 * 「スタッフ情報を取得する」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindStaff() throws Exception {
		// スタッフ情報を取得する。
		// スタッフ情報を取得するためのSQL文を取得する。
		// 取得したSQL文を実行する。
		// VRMap staffMap= new VRHashMap();
		VRList providerList = getDBManager().executeQuery(
				getSQL_GET_PROVIDER(null));
		for (int i = 0; i < providerList.size(); i++) {
			VRMap sqlparam = new VRHashMap();
			sqlparam.setData("PROVIDER_ID", VRBindPathParser.get("PROVIDER_ID",
					(VRMap) providerList.getData(i)));
			VRList providerStaffList = getDBManager().executeQuery(
					getSQL_GET_STAFF(sqlparam));
			if (providerStaffList.size() > 0) {
				((VRMap) getProviderList().getData(i))
						.putAll((VRMap) providerStaffList.getData());
			}
		}

	}

	/**
	 * 「削除処理可否確認処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doDeleteCheck() throws Exception {
		// 削除可能な事業所情報かを判別する処理
		// 要介護認定履歴TABLEで居宅支援事業所として登録されているかチェックする。
		// SQL文取得のためVRMap：providerMapを作成し、下記のKEY/VALUEを設定する。
		VRMap providerMap = new VRHashMap();
		// KEY：PROVIDER_ID VALUE：providerId
		providerMap.setData("PROVIDER_ID", getProviderId());

		// 要介護認定履歴TABLEチェック用のSQL文を取得する。
		// getSQL_GET_PATIENT_NINTEI_HISTORY(providerMap);
		// SQL文を実行する。
		VRList PatientNinteiHistoryList = getDBManager().executeQuery(
				getSQL_GET_PATIENT_NINTEI_HISTORY(providerMap));
		// レコードが取得できた場合
		if (PatientNinteiHistoryList.size() > 0) {
			// 削除不可エラーメッセージで使用するパラメーターを作成する。
			// deleteErrorMsg = 居宅支援事業所
			setDeleteErrorMsg("居宅支援事業所");
			// 戻り値として false を返す。
			return false;
		}

		// サービスTABLE（予定）として登録されている事業所かチェックする。
		// サービスTABLEチェック用のSQL文を取得する。※paramは使いまわしで代用
		// getSQL_GET_SERVICE_PLAN(providerMap);
		// 取得したSQL文を実行する。
		VRList ServicePlanList = getDBManager().executeQuery(
				getSQL_GET_SERVICE_PATTEN(providerMap));
		// レコードが取得できた場合
		if (ServicePlanList != null && ServicePlanList.size() > 0) {
            VRMap serviceMap = new VRHashMap();
            
            serviceMap  = (VRMap)ServicePlanList.getData();
            //サービスパターンとして登録されていた場合
            if(new Integer(1).equals(serviceMap.getData("SERVICE_USE_TYPE"))){
                setDeleteErrorMsg("サービスパターン");
                // 戻り値として false を返す。                
                return false;
                
                // 削除不可エラーメッセージで使用するパラメーターを作成する。
                // deleteErrorMsg = サービス予定
            } else if (new Integer(2).equals(serviceMap
                    .getData("SERVICE_USE_TYPE"))
                    || new Integer(3).equals(serviceMap
                            .getData("SERVICE_USE_TYPE"))
                    || new Integer(4).equals(serviceMap
                            .getData("SERVICE_USE_TYPE"))
                    || new Integer(5).equals(serviceMap
                            .getData("SERVICE_USE_TYPE"))) {
                
                setDeleteErrorMsg("サービス予定");
                // 戻り値として false を返す。
                return false;
                
            } else if (new Integer(6).equals(serviceMap
                    .getData("SERVICE_USE_TYPE"))
                    || new Integer(7).equals(serviceMap
                            .getData("SERVICE_USE_TYPE"))
                    || new Integer(8).equals(serviceMap
                            .getData("SERVICE_USE_TYPE"))
                    || new Integer(9).equals(serviceMap
                            .getData("SERVICE_USE_TYPE"))) {
                // 削除不可エラーメッセージで使用するパラメーターを作成する。
                // deleteErrorMsg = サービス実績
                setDeleteErrorMsg("サービス実績");
                // 戻り値として false を返す。
                return false;
            }

        }
		// 請求情報TABLEに請求元事業所として登録されていないかチェックする。
		// 請求情報TABLEチェック用のSQL文を取得する。
		// getSQL_GET_CLAIM(providerMap);
		// 取得したSQL文を実行する。
		VRList ClaimList = getDBManager().executeQuery(
				getSQL_GET_CLAIM(providerMap));
		// レコードが取得できた場合
		if (ClaimList.size() > 0) {
			// 削除不可エラーメッセージで使用するパラメーターを作成する。
			// deleteErrorMsg = 請求元事業所
			setDeleteErrorMsg("請求元事業所");
			// 戻り値として false を返す。
			return false;
		}

		// レコードが取得できなかった場合
		// 全てのSQL文の結果が0件だった場合
		// 戻り値として true を返す
		return true;
	}

	/**
	 * 「削除処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doDelete() throws Exception {
		// 選択されているレコードのインデックスを格納するindexを定義する。
		int index;

		// ※入力チェック
		// 画面の「事業所一覧」の行が選択されているかどうかチェックする。
		if (getProviderTable().getSelectedSortedRow() == -1) {
			// 選択されていない場合
			// 処理を中断する。
			return false;
		} else {
			// 選択されている場合
			// 選択行のインデックス(モデルではなく画面上)を取得する。
			index = getProviderTable().getSelectedModelRow();
		}

		try {
			// トランザクション開始
			getDBManager().beginTransaction();

			// ※パッシブチェック
			// パッシブタスクをクリアする。
			getPassiveChecker().clearPassiveTask();

			// パッシブタスクを登録する。
			getPassiveChecker().addPassiveDeleteTask(
					getPROVIDER_PASSIVE_CHECK_KEY(), index);

			// パッシブチェックを実行する。
			if (!getPassiveChecker().passiveCheck(getDBManager())) {
				// パッシブエラーがある場合
				// エラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
				QkanMessageList.getInstance()
						.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
				// 処理を中断する。(異常終了)
				getDBManager().rollbackTransaction();
				return false;
			}

			// パッシブエラーが発生しなかった場合
			// 戻り値として帰ってきたDBManagerを deleteDBManager に退避する。
			ACDBManager deleteDBManager = getDBManager();
			// 空のVRList：deleteListを生成する。
			VRList deleteList = new VRArrayList();
			// VRmap：providerMapを生成し下記のKEY/VALUEを設定する。
			VRMap providerMap = new VRHashMap();
			// KEY：PROVIDER_ID VALUE：providerId
			providerMap.setData("PROVIDER_ID", getProviderId());

			// 事業所のサービス詳細を削除する。
			QkanCommon.updateProviderServiceDetail(deleteDBManager, deleteList,
					getProviderId());
			// 事業所の親情報を削除する。
			// 親事業所情報を削除するためのSQL文を取得する。
			// getSQL_DELETE_PROVIDER(providerMap);
			// 取得したSQL文を実行する。
			getDBManager().executeUpdate(getSQL_DELETE_PROVIDER(providerMap));

			// SQL文実行時にエラーが発生しなかった場合
			getDBManager().commitTransaction();
			// 事業所情報を再描写する。
			doFind();

		} catch (Exception ex) {
			// エラーがあった場合
			// 処理をロールバックする。
			// 処理を中断する。(異常終了)
			getDBManager().rollbackTransaction();

			// 上位クラスに例外を返す。
			throw ex;
		}
		return true;
	}

	/**
	 * 「検索処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindProvider() throws Exception {
		// 事業所の検索処理
		// 検索条件格納用にVRMap：findParamを生成する。
		VRMap findParam = new VRHashMap();

		getFindContens().setSource(findParam);

		// 検索処理用に｢検索条件領域（findContens）｣のデータを取得しfindParamに格納する。
		getFindContens().applySource();

		// ｢事業所種別コンボ（findContentproviderType）｣の値をチェックする。
		if(getFindContentproviderType().getSelectedIndex() == 0){
			//なにもしない
		}else if (getFindContentproviderType().isSelected()) {
			// 入力されていた場合
			// findParam（VRMap）に以下のKEY/VALUEを設定する。
			// KEY：FIND_PROVIDER_TYPE VALUE："" ※SQL文で使用するため値は空白でよい
			findParam.setData("FIND_PROVIDER_TYPE", "");
		}

		// ｢事業所番号テキスト（findContentproviderId）｣の値をチェックする。
		if (!ACTextUtilities.isNullText(getFindContentproviderId().getText())) {
			// 入力されていた場合
			// findParam（VRMap）に以下のKEY/VALUEを設定する。
			// KEY：FIND_PROVIDER_ID VALUE"" ※SQL文で使用するため値は空白でよい
			findParam.setData("FIND_PROVIDER_ID", "");
		}

		// ｢事業所名称テキスト（findContentproviderName)｣の値をチェックする。
		if (!ACTextUtilities.isNullText(getFindContentproviderName().getText())) {
			// 入力されていた場合
			// findParam（VRMap）に以下のKEY/VALUEを設定する。
			// KEY：FIND_PROVIDER_NAME VALUE："" ※SQL文で使用するため空文字でよい
			findParam.setData("FIND_PROVIDER_NAME", "");
		}

		// findParamに
		// KEY：FIND_PROVIDER_TYPE、FIND_PROVIDER_NAME、FINDPROVIDER_IDが存在するかチェックする。
		if (!VRBindPathParser.has("FIND_PROVIDER_TYPE", findParam)
				&& !VRBindPathParser.has("FIND_PROVIDER_NAME", findParam)
				&& !VRBindPathParser.has("FIND_PROVIDER_ID", findParam)) {
			// 存在しなかった場合
			
			// 事業所の一覧を情報を画面に展開する。※全検索処理
			doFind();
		}

		// 処理を抜ける。
		// 検索に使用するためのSQL文を取得する。
		// getSQL_FIND_PROVIDER(findParam);
		// 取得したSQL文実行する。
		setProviderList(getDBManager().executeQuery(
				getSQL_FIND_PROVIDER(findParam)));

		// レコードが取得できた場合
		//if (getProviderList().size() > 0) {
			// 取得した事業所情報をproviderListに格納する。
			// スタッフ情報を取得しproviderList内の該当事業所に情報を設定する。
			// doFindStaff();
			for (int i = 0; i < getProviderList().size(); i++) {
				VRMap sqlparam = new VRHashMap();
				sqlparam.setData("PROVIDER_ID", VRBindPathParser.get(
						"PROVIDER_ID", (VRMap) getProviderList().getData(i)));

				VRList providerStaffList = getDBManager().executeQuery(
						getSQL_GET_STAFF(sqlparam));

				if (providerStaffList.size() > 0) {
					((VRMap) getProviderList().getData(i))
							.putAll((VRMap) providerStaffList.getData(0));
				}
			}

			// 取得した事業所情報（providerList）をproviderTableModelに設定する。
			getProviderTableModel().setAdaptee(getProviderList());
			// テーブルの1行目を選択状態にする。
			getProviderTable().setSelectedSortedFirstRow();
		//} else {
			// レコードが取得できなかった場合
			// エラーメッセージを表示する。※メッセージID = NOT_FOUND 引数 = 事業所
			//QkanMessageList.getInstance().NOT_FOUND("事業所");
		//}

	}

	/**
	 * 「検索条件退避」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void createFindState() throws Exception {
		// ※検索条件の退避
		// 検索条件記憶用のレコード memoryを生成する。
		VRMap memory = new VRHashMap();
		// 検索条件を記憶する画面項目(contents)のソースとして、memoryを指定する。
		getContents().setSource(memory);
		// 画面項目の情報を抽出する。
		getContents().applySource();
		// 現在の画面遷移用パラメタに以下のKEY/VALUEを設定する。
		// ｋEY："検索条件" VALUE：memory
		ACFrame.getInstance().addNowAffairParameter("検索条件", memory);
	}

	/**
	 * 「詳細画面遷移」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void transferNext() throws Exception {
		// 事業所登録画面に遷移する処理（更新）
		// 画面の｢事業所一覧テーブル｣のレコードが選択されてるかチェックする。
		if (getProviderTable().getSelectedSortedRow() != -1) {
			// レコードが選択されていた場合
			// VRMap：paramを作成し下記のパラメーターを格納する。
			VRMap param = new VRHashMap();
			// KEY：PROCESS_MODE VALUE：共通定数の｢PROCESS_MODE_UPDATE(3)｣
			param.setData("PROCESS_MODE", new Integer(
					QkanConstants.PROCESS_MODE_UPDATE));
			// KEY：PROVIDER_ID VALUE：選択事業所ID
			// 一時利用HashMap
			VRMap providerIDMap = new VRHashMap();

			providerIDMap = (VRMap) getProviderTable()
					.getSelectedModelRowValue();

			param.setData("PROVIDER_ID", VRBindPathParser.get("PROVIDER_ID",
					providerIDMap));
			// 画面情報取得用にVRMap：stateMapを生成する。
			VRMap stateMap = new VRHashMap();
			// 状態を記憶する画面項目のソースとして指定（this)
			getContents().setSource(stateMap);
			// 画面項目の情報を抽出する
			getContents().applySource();
			// 抽出した値をparamに下記のKEY/VALUEを格納する。
			// KEY：STATE VALUE：抽出した値
			param.setData("STATE", stateMap);
			// 次画面遷移のためパラメーターNCAffairInfo affairを定義する。
			ACAffairInfo affair = null;
			// 下記のパラメーターでaffairを生成する。
			// className：QO004.class.getName() parameters：param
			affair = new ACAffairInfo(QO004.class.getName(), param);
			// ｢事業所登録画面（QO004）｣に遷移する。
			ACFrame.getInstance().next(affair);
		}
	}
}
