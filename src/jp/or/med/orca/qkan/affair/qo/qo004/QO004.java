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
 * 作成日: 2006/02/09  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所管理 (004)
 * プログラム 事業所登録 (QO004)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo004;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.io.ACPropertyXML;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACHashMapFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.ACZipRelation;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServicePanel;

/**
 * 事業所登録(QO004)
 */
public class QO004 extends QO004Event {
	/**
	 * コンストラクタです。
	 */
	public QO004() {
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
		// 画面の初期表示を行う処理。

		VRMap param = affair.getParameters();

		// 前画面からの渡りパラメーターを退避する。
		// PROCESS_MODE = PROCESS_MODE
		// selectedProviderId = providerId
		if (VRBindPathParser.has("PROCESS_MODE", param)) {
			setPROCESS_MODE(ACCastUtilities.toInt(VRBindPathParser.get(
					"PROCESS_MODE", param)));
		}

		if (VRBindPathParser.has("PROVIDER_ID", param)) {
			setSelectedProviderId(ACCastUtilities.toString(VRBindPathParser
					.get("PROVIDER_ID", param)));
		}

		// 画面の初期化、設定
		initialize();

		// DBよりレコードを取得し、画面に展開する。
		doFind();

	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}

		// 前画面に遷移する処理。
		// 強制戻りフラグが1の場合
		if (getCompulsoryBackFlag() == 1) {
			return true;
		}

		// 変更をチェックする。※スナップショット
		if (getSnapshot().isModified()
				|| getProviderStaffTableChangeFlag() == 1
				|| getProviderServiceTableChangeFlag() == 1) {
			// 最後に保存されてから、項目・テーブルが変更されている場合(下記のいずれかの場合）
			// ・isModified
			// ・providerServiceTableChangeFlag = 1
			// ・providerStaffTableChangeFlag = 1
			if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
				// PROCESS_MODEが、共通定数｢PROCESS_MODE_INSERT(4)｣だった場合
				// 登録確認メッセージを表示する。※メッセージID = WARNING_OF_INSERT_ON_MODIFIED
				switch (QkanMessageList.getInstance()
						.WARNING_OF_INSERT_ON_MODIFIED()) {
				// 「登録して戻る」押下時
				case ACMessageBox.RESULT_OK:
					try {
						// 事業所基本情報入力チェックを行う。
						if (!doValidProviderCheck()) {
							return false;
						}
						// 保存処理を行う。
						if (!doSave()) {
							return false;
						}
						setPROCESS_MODE(QkanConstants.PROCESS_MODE_UPDATE);
						break;
					} catch (Exception ex) {
						throw ex;
					}

				case ACMessageBox.RESULT_CANCEL:
					return false;
				}
			} else {
				// PROCESS_MODEが、共通定数の｢PROCESS_MODE_UPDATE(3)｣だった場合
				// 更新確認メッセージを表示する。※メッセージID = CAN_BACK_ON_UPDATE
				switch (QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED()) {
				// 「更新して戻る」押下時
				case ACMessageBox.RESULT_OK:
					// 事業所基本情報入力チェック
					if (!doValidProviderCheck()) {
						return false;
					}
					// 保存処理を行う。
					if (!doSave()) {
						return false;
					}
					break;
				case ACMessageBox.RESULT_CANCEL:
					return false;
				}
			}
		}

		// 前画面遷移用パラメーターを設定する。
		// KEY：BOOMERANG_AFFAIR VALUE：AFFAIR_ID
		VRBindPathParser.set("BOOMERANG_AFFAIR", parameters, AFFAIR_ID);

		// 更新モードの場合
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_UPDATE) {
			// KEY：PROVIDER_ID VALUE：selectedProviderId
			VRBindPathParser.set("PROVIDER_ID", parameters,
					getSelectedProviderId());
		}

		// 前画面への遷移を許可するならばtrueを返す。
		return true;
	}

	public boolean canClose() throws Exception {
		// 変更チェック（スナップショット、画面テーブルのチェック）
		if (getSnapshot().isModified()
				|| getProviderStaffTableChangeFlag() == 1
				|| getProviderServiceTableChangeFlag() == 1) {
			// 最後に保存されてから、項目・テーブルが変更されている場合(下記のいずれかの場合）
			// ・isModified
			// ・providerServiceTableChangeFlag = 1
			// ・providerStaffTableChangeFlag = 1
			// 終了確認メッセージを表示する。
			// ・メッセージID：WARNING_OF_CLOSE_ON_MODIFIED
			if (QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED() == ACMessageBox.RESULT_CANCEL) {
				// 「キャンセル」を選択した場合
				// 処理を中断する（何もしない）。
				return false;
			}
		}

		// システムを終了する。
		return true;

	}

	// コンポーネントイベント

	/**
	 * 「提供サービス情報反映」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void reflectionActionPerformed(ActionEvent e) throws Exception {
		// 提供サービス情報を反映する処理
		reflect();

	}

	/**
	 * 「新規登録モード」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void newDataActionPerformed(ActionEvent e) throws Exception {
		// 新規登録モードに変更する処理
		if (getSnapshot().isModified()
				|| getProviderStaffTableChangeFlag() == 1
				|| getProviderServiceTableChangeFlag() == 1) {
			// 新規モード変更確認メッセージを表示する。 ※メッセージID = WARNING_OF_CLEAR_ON_MODIFIED
			if (QkanMessageList.getInstance().WARNING_OF_CLEAR_ON_MODIFIED() == ACMessageBox.RESULT_CANCEL) {
				// 「キャンセル」の場合
				// 処理を終了する。
				return;
			}
		}

		// クリア処理を行う。
		allClear();

	}

	/**
	 * 「クリア処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void clearActionPerformed(ActionEvent e) throws Exception {
		// 画面をクリアする処理
		// 変更チェックを行う。
		// ※スナップショット（全体）、スナップショット（サービスパネル）、providerStaffTableChangeFlag
		if (getSnapshot().isModified()
				|| getProviderStaffTableChangeFlag() == 1
				|| getProviderServiceTableChangeFlag() == 1) {
			// 変更があった場合
			// クリア処理確認メッセージを表示する。 ※メッセージID = WARNING_OF_CLEAR_ON_MODIFIED
			if (QkanMessageList.getInstance().WARNING_OF_CLEAR_ON_MODIFIED() == ACMessageBox.RESULT_CANCEL) {
				// 「キャンセル」の場合
				// 処理を終了する。
				return;
			}
		}

		// クリア処理を行う。
		allClear();

	}

	/**
	 * 「対象レコードを画面に展開」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void providerStaffTableSelectionChanged(ListSelectionEvent e)
			throws Exception {
		// 選択されたセルの担当者名を画面に展開する処理
		VRMap map = new VRHashMap();

		if (getProviderStaffTable().isSelected()) {
			// 選択されたレコードを取得する。
			map = (VRMap) getProviderStaffTable().getSelectedModelRowValue();
			// ボタンの状態設定
			setState_STAFF_BUTTON_STATE2();
		} else {
			// 担当者領域のソースを生成する。
			map = (VRMap) getProviderStaffInputPanel().createSource();
			// ボタンの状態設定
			setState_STAFF_BUTTON_STATE1();
		}

		// ソースとして設定する。
		getProviderStaffInputPanel().setSource(map);

		// 画面に展開する。
		getProviderStaffInputPanel().bindSource();

		// スナップショット撮影
		getStaffSnapshot().snapshot();

	}

	/**
	 * 「対象レコードを画面に展開」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void serviceKindTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		// 選択されたセルの提供サービス詳細情報を画面に展開する処理
		// テーブル行が選択されていない場合
		if (!getServiceKindTable().isSelected()) {
			// 反映ボタンを無効にする。
			setState_SERVICE_DETAIL_BUTTON_ENABLE_FALSE();
			// 提供チェックのクリア
			getOfferCheck().setValue(0);
			// サービスパネルのクリア
			getProviderDetailServiceDetails().removeAll();
			setProviderServiceClass(null);
			// 退避サービス種類コードの初期化
			setCurrentServiceType(0);
			// サービスパネルのスナップショット撮影
			getServiceSnapshot().snapshot();
			return;
		}

		// 選択行レコード取得
		VRMap selectedService = (VRMap) getServiceKindTable()
				.getSelectedModelRowValue();
		// 選択レコードのサービス種類を取得
		int selectedServiceType = ACCastUtilities.toInt(VRBindPathParser.get(
				"SYSTEM_SERVICE_KIND_DETAIL", selectedService));

		// 再度同一の行が選択された場合、処理を抜ける
		if (getCurrentServiceType() == selectedServiceType) {
			return;
		}

		// 提供サービス詳細情報パネルの変更チェックを行う。※スナップショット
		if (isModifiedOnService()) {
			// 変更がある場合
			// 提供サービス確認メッセージを表示する。
			// ※メッセージID = QO004_WARNING_OF_SERVICE_INSERT
			switch (QkanMessageList.getInstance()
					.QO004_WARNING_OF_SERVICE_INSERT()) {
			// 「YES」が選択された場合
			case ACMessageBox.RESULT_YES:
				// 反映処理
				if (!reflect()) {
					// 選択を元に戻す
					VRList temp = (VRList) getProviderServiceTableModel()
							.getAdaptee();
					int i = ACBindUtilities.getMatchIndexFromValue(temp,
							"SYSTEM_SERVICE_KIND_DETAIL", new Integer(
									getCurrentServiceType()));
					getServiceKindTable().setSelectedModelRow(i);
					return;
				}
				break;
			// 「NO」が選択された場合
			case ACMessageBox.RESULT_NO:
				// 退避していた選択サービス種類コードを初期化
				setCurrentServiceType(0);
				break;
			// 「CANCEL」が選択された場合
			case ACMessageBox.RESULT_CANCEL:
				// 選択を元に戻す
				VRList temp = (VRList) getProviderServiceTableModel()
						.getAdaptee();
				int i = ACBindUtilities.getMatchIndexFromValue(temp,
						"SYSTEM_SERVICE_KIND_DETAIL", new Integer(
								getCurrentServiceType()));
				getServiceKindTable().setSelectedModelRow(i);
				return;
			}
		}

		ACPanel panel = createProviderServicePanel(selectedServiceType);

		if (panel == null) {
			getProviderDetailServiceDetails().removeAll();
			setProviderServiceClass(null);
		} else {

			panel.setFollowChildEnabled(true);

            //2009/02/25 [ID:0000440][Tozo TANAKA] replace begin - 平成21年4月法改正対応
            //＜平成21年4月法改正対応＞
//			((QS001ServicePanel) panel).setDBManager(getDBManager());
//
//			setProviderServiceClass((iProviderServicePanel) panel);
//
//			getProviderServiceClass().initialize();
            if(panel instanceof QO004ProviderPanel){
                ((QO004ProviderPanel) panel).setDBManager(getDBManager());
            }
            if(panel instanceof iProviderServicePanel){
                setProviderServiceClass((iProviderServicePanel) panel);
            }
            getProviderServiceClass().initialize();
            
            if (panel instanceof QO004ProviderPanel) {
                int oldLowSetting = 0;
                if (ACFrame.getInstance().getPropertyXML().hasValueAt(
                        "ScreenConfig/ShowOldLowProviderElements")) {
                    //システム設定[ScreenConfig/ShowOldLowProviderElements]の値を取得する。
                    oldLowSetting = ACCastUtilities.toInt(ACFrame
                            .getInstance().getPropertyXML().getValueAt(
                                    "ScreenConfig/ShowOldLowProviderElements"),
                            0);
                }
                //取得した値が0より大きい場合
                //旧法項目の表示状態を「表示」に設定する。
                //取得した値が0以下の場合
                //旧法項目の表示状態を「非表示」に設定する。
                ((QO004ProviderPanel) panel)
                        .setOldLowElementAreaVisible(oldLowSetting > 0);
            }            
            // 2009/02/25 [ID:0000440][Tozo TANAKA] replace end - 平成21年4月法改正対応

			// サービス種類詳細領域（providerDetailServiceDetails）以下のパネルを削除する。セットされているパネルの削除処理
			getProviderDetailServiceDetails().removeAll();

			// 提供サービスパネルとしてservicePanelを追加する。※パネルの切り替え処理
			getProviderDetailServiceDetails().add(
					(ACPanel) getProviderServiceClass(), VRLayout.CLIENT);
			getProviderDetailServiceDetails().revalidate();
			getProviderDetailServiceDetails().repaint();

			// servicePanel に選択されたセルのレコードをソースとして設定する。
			panel.setSource(selectedService);

			// servicePanel に展開する。
			panel.bindSource();

		}

		// 提供チェックにも値を与える。
		getOfferCheck().setSource(selectedService);
		getOfferCheck().bindSource();

		// サービスの状態を設定する。
		setStateServiceInfos();

		// 反映ボタンを有効にする。
		setState_SERVICE_DETAIL_BUTTON_ENABLE_TRUE();

		// サービスパネル用のスナップショットを撮影する。
		getServiceSnapshot().snapshot();

		// 選択サービスのサービス種類コードを退避
		setCurrentServiceType(selectedServiceType);

	}

	/**
	 * 「サービスパネルの制御」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void offerCheckActionPerformed(ActionEvent e) throws Exception {
		// サービス提供の有無を判別する処理
		setStateServiceInfos();

	}

	/**
	 * 「担当者追加」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void providerStaffInsertActionPerformed(ActionEvent e)
			throws Exception {
		// 担当者を追加する処理

		// 入力チェック
		if (!isValidInputStaff(CHECK_MODE_INSERT)) {
			return;
		}

		// 画面上のデータを取得
		VRMap map = new VRHashMap();
		getProviderStaffInputPanel().setSource(map);
		getProviderStaffInputPanel().applySource();

		// providerStaffListを件数分ループし、STAFF_IDの最大値+1の値を取得する。
		int maxId = 0;
		// 最大値の取得
		if (!(getProviderStaffList() == null)) {
			// 画面テーブルに既にデータが存在している場合
			for (int i = 0; i < getProviderStaffList().size(); i++) {
				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"STAFF_ID", (VRMap) getProviderStaffList().get(i)));
				// 比較対象が比較元より大きい値の場合
				if (maxId < target) {
					// 比較対象を比較元とする。
					maxId = target;
				}
			}
		}

		// STAFF_IDの設定
		VRBindPathParser.set("STAFF_ID", map, new Integer(maxId + 1));

		// providerStaffListに画面上のデータを追加する。
		getProviderStaffList().add(map);

		// 追加行を選択状態に設定する。
		getProviderStaffTable().setSelectedModelRow(
				getProviderStaffList().size() - 1);

		// STAFF_PROCESS_MODEをチェックする。
		if (getSTAFF_PROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
			// STAFF_PROCESS_MODEが、共通定数の｢PROCESS_MODE_INSERT(4)｣だった場合
			// 画面状態を変更する。（編集削除ボタンを押下可能にする。）
			setState_STAFF_BUTTON_STATE2();
		}

		// 担当者テーブルフラグ providerStaffTableChangeFlag を 1（変更あり）に変更する。
		setProviderStaffTableChangeFlag(1);

		// スナップショット撮影
		getStaffSnapshot().snapshot();

	}

	/**
	 * 「担当者編集」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void providerStaffFindActionPerformed(ActionEvent e)
			throws Exception {
		// 担当者テーブルで選択された担当者の編集を行う処理

		// 入力チェック
		if (!isValidInputStaff(CHECK_MODE_UPDATE)) {
			return;
		}

		// 画面上のデータを取得
		VRMap map = new VRHashMap();
		getProviderStaffInputPanel().setSource(map);
		getProviderStaffInputPanel().applySource();

		// 選択されているレコードを取得
		VRMap selectedMap = (VRMap) getProviderStaffTable()
				.getSelectedModelRowValue();

		// 選択レコードより、画面上にないデータを移す。
		int staffId = ACCastUtilities.toInt(VRBindPathParser.get("STAFF_ID",
				selectedMap));
		VRBindPathParser.set("STAFF_ID", map, new Integer(staffId));

		// 選択レコードと画面上のデータを置き換える。
		getProviderStaffList().setData(
				getProviderStaffTable().getSelectedModelRow(), map);

		// 再描画
		getProviderStaffTable().repaint();
		getProviderStaffTable().revalidate();

		// 担当者テーブルフラグ providerStaffTableChangeFlag を 1（変更あり）に変更する。
		setProviderStaffTableChangeFlag(1);

		// スナップショット撮影
		getStaffSnapshot().snapshot();
	}

	/**
	 * 「担当者削除」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void providerStaffDeleteActionPerformed(ActionEvent e)
			throws Exception {
		// 担当者テーブルで選択された担当者の削除を行う処理

		// 選択されたレコードをproviderStaffListから削除する。
		if (!(getProviderStaffList() == null || getProviderStaffList().size() == 0)) {
			// 確認メッセージを表示する。
			// ・メッセージID：WARNING_OF_DELETE_SELECTION
			switch (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION()) {

			case ACMessageBox.RESULT_OK:
				// 「はい」を選択した場合
				// 選択されているレコードの画面上のインデックス
				int sortedRow = getProviderStaffTable().getSelectedSortedRow();

				// 選択されているレコードをproviderStaffListから削除する。
				getProviderStaffList().remove(
						getProviderStaffTable().getSelectedModelRow());

				// 削除された行の1行上の行を選択する。
				getProviderStaffTable().setSelectedSortedRowOnAfterDelete(
						sortedRow);

				// 担当者テーブルフラグ providerStaffTableChangeFlag を 1（変更あり）に変更する。
				setProviderStaffTableChangeFlag(1);

				break;

			case ACMessageBox.RESULT_CANCEL:
				// 「キャンセル」を選択した場合
				// 処理を抜ける。（何もしない）
				break;
			}
		}

	}

	/**
	 * 「登録処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {
		// 事業所情報を登録する処理

		try {

			// 事業所サービス情報が変更されていないかチェックする。
			if (isModifiedOnService()) {
				// 変更がある場合
				// 提供サービス確認メッセージを表示する。
				// ※メッセージID = QO004_WARNING_OF_SERVICE_INSERT
				switch (QkanMessageList.getInstance()
						.QO004_WARNING_OF_SERVICE_INSERT()) {
				// 「YES」が選択された場合
				case ACMessageBox.RESULT_YES:
					// 反映処理
					if (!reflect()) {
						return;
					}
					break;
				// 「NO」が選択された場合
				case ACMessageBox.RESULT_NO:
					break;
				// 「CANCEL」が選択された場合
				case ACMessageBox.RESULT_CANCEL:
					return;
				}
			}

			// 担当者情報が変更されていないかチェックする。
			if (getStaffSnapshot().isModified()) {
				// メッセージ表示
				String msgParam = "担当者情報";
				switch (QkanMessageList.getInstance()
						.WARNING_OF_CANCELLATION_UNSETTLED_DATA(msgParam)) {
				// 「OK」なら破棄
				case ACMessageBox.RESULT_OK:
					break;
				// 「CANCEL」なら処理中断
				case ACMessageBox.RESULT_CANCEL:
					return;
				}
			}

			// 事業所基本情報入力チェックを行う。
			if (!doValidProviderCheck()) {
				return;
			}

			// 保存処理を行う。
			if (!doSave()) {
				return;
			}

			// 処理モードを更新モードに変更する。
			setPROCESS_MODE(QkanConstants.PROCESS_MODE_UPDATE);

			// 画面状態を設定する。
			affairSetUp();

			// 再検索
			doFind();

			// サービスの一行目を選択
			getServiceKindTable().setSelectedSortedFirstRow();

			// 登録完了メッセージを表示する。 ※メッセージID = INSERT_SUCCESSED
			QkanMessageList.getInstance().INSERT_SUCCESSED();

		} catch (Exception ex) {
			throw ex;
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
		// 事業所情報を更新する処理

		try {

			// 事業所サービス情報が変更されていないかチェックする。
			if (isModifiedOnService()) {
				// 変更がある場合
				// 提供サービス確認メッセージを表示する。
				// ※メッセージID = QO004_WARNING_OF_SERVICE_INSERT
				switch (QkanMessageList.getInstance()
						.QO004_WARNING_OF_SERVICE_INSERT()) {
				// 「YES」が選択された場合
				case ACMessageBox.RESULT_YES:
					// 反映処理
					if (!reflect()) {
						return;
					}
					break;
				// 「NO」が選択された場合
				case ACMessageBox.RESULT_NO:
					break;
				// 「CANCEL」が選択された場合
				case ACMessageBox.RESULT_CANCEL:
					return;
				}
			}

			// 担当者情報が変更されていないかチェックする。
			if (getStaffSnapshot().isModified()) {
				// メッセージ表示
				String msgParam = "担当者情報";
				switch (QkanMessageList.getInstance()
						.WARNING_OF_CANCELLATION_UNSETTLED_DATA(msgParam)) {
				// 「OK」なら破棄
				case ACMessageBox.RESULT_OK:
					break;
				// 「CANCEL」なら処理中断
				case ACMessageBox.RESULT_CANCEL:
					return;
				}
			}

			// 事業所基本情報入力チェックを行う。
			if (!doValidProviderCheck()) {
				return;
			}

			// 保存処理を行う。
			if (!doSave()) {
				return;
			}

			// 画面状態を設定する。
			affairSetUp();

			// 再検索
			doFind();

			// サービスの一行目を選択
			getServiceKindTable().setSelectedSortedFirstRow();

			// 更新完了メッセージを表示する。 ※メッセージID = UPDATE_SUCCESSED
			QkanMessageList.getInstance().UPDATE_SUCCESSED();

		} catch (Exception ex) {
			throw ex;
		}

	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		// ACFrame.getInstance().setFrameEventProcesser(new
		// QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		param.setData("PROVIDER_ID", "0000000006");
		param.setData("PROCESS_MODE", new Integer(
				QkanConstants.PROCESS_MODE_INSERT));
		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QO004.class.getName(), param));
	}

	// 内部関数
	/**
	 * 「初期化」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void initialize() throws Exception {

		// タイトルの設定
		// 業務情報マスタより、データを取得する。
		// 取得したデータのウィンドウタイトル（WINDOW_TITLE）をウィンドウに設定する。
		// 取得したデータの業務タイトル（AFFAIR_TITLE）を業務ボタンバーに設定する。
		setAffairTitle(AFFAIR_ID, getButtons());

		// パッシブキーの定義
		setPROVIDER_PASSIVE_CHECK_KEY(new ACPassiveKey("PROVIDER",
				new String[] { "PROVIDER_ID" }, new boolean[] { true },
				"LAST_TIME", "LAST_TIME"));

		// スナップショット撮影対象指定
		// スナップショットの対象を指定する。（全体）
		getSnapshot().setRootContainer(getProviderContents());

		// ※対象より、以下の領域を除外する。
		// ・サービス詳細情報領域（providerDetailServiceDetails）
		// ・事業所詳細情報領域（providerDetailContents）
		// ・担当者詳細情報領域（providerMainContentChargesPanel）
		VRList excusions = new VRArrayList();
		excusions.add(getProviderDetailServiceDetails());
		excusions.add(getProviderDetailContents());
		excusions.add(getProviderMainContentChargesPanel());
		getSnapshot().setExclusions(excusions);

		// スナップショットの対象を指定する。（サービス）
		getServiceSnapshot()
				.setRootContainer(getProviderDetailServiceDetails());
		// スナップショットの対象を指定する。（担当者）
		getStaffSnapshot().setRootContainer(getProviderStaffInputPanel());

		// テーブルモデルの設定
		ACTableModelAdapter model = null;

		// providerStaffTableModelを設定する。
		// "STAFF_FAMILY_NAME+' '+STAFF_FIRST_NAME"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "CARE_MANAGER_NO",
				"STAFF_FAMILY_NAME+'　'+STAFF_FIRST_NAME" });
		setProviderStaffTableModel(model);

		// providerServiceTableModelを設定する。
		// "OFFER" "SERVICE_NAME"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "OFFER", "SERVICE_ABBREVIATION" });
		setProviderServiceTableModel(model);

		// テーブルモデルを下記の画面のテーブルに設定する。
		// ・担当者テーブル（providerStaffTable） ・テーブルモデル（providerStaffTableModel）
		// ・提供サービステーブル（serviceKindTable） ・テーブルモデル（providerServiceTableModel）
		getProviderStaffTable().setModel(getProviderStaffTableModel());
		getServiceKindTable().setModel(getProviderServiceTableModel());

		// アイコンの設定
		getServiceKindTableColum1()
				.setFormat(
						new ACHashMapFormat(
								new String[] {
										"jp/nichicom/ac/images/icon/pix16/btn_079.png",
										"jp/nichicom/ac/images/icon/pix16/btn_080.png" },
								new Boolean[] { new Boolean(true),
										new Boolean(false) }));

		// 郵便番号から住所変換
		// 郵便番号と住所を関連付ける。
		new ACZipRelation(getProviderPostnoOn(), getProviderPostnoUnder(),
				getProviderAddress());

		// メニューマスタデータの取得
		getMasterMenu();

		// 画面状態を初期設定にする。
		setState_INIT_STATE();

		// 画面の設定
		affairSetUp();

	}

	/**
	 * 「画面設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void affairSetUp() throws Exception {

		// コンボ設定
		VRMap comboMap = new VRHashMap();
		VRList temp = new VRArrayList();

		// コードマスタより下記のCODE_IDのデータを取得しcomboMapに格納する。
		// ・CODE_ID = CODE_PROVIDER_TYPE ※事業所種別
		temp = QkanCommon.getArrayFromMasterCode(CODE_PROVIDER_TYPE,
				"PROVIDER_TYPE");
		VRBindPathParser.set("PROVIDER_TYPE", comboMap, temp);

		// ・CODE_ID = CODE_LAW_VERSION ※法改正区分
		temp = QkanCommon.getArrayFromMasterCode(CODE_LAW_VERSION,
				"LAW_VERSION");
		VRBindPathParser.set("LAW_VERSION", comboMap, temp);

		// comboMap を事業所情報領域（providerContents）にセットする。
		getProviderContents().setModelSource(comboMap);

		// 画面に展開する。※コンボセット処理
		getProviderContents().bindModelSource();

		// 処理モードによる画面状態設定
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
			setState_INSERT_STATE();
		} else {
			setState_UPDATE_STATE();
		}

	}

	/**
	 * 「事業所情報取得処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFind() throws Exception {
		// 事業所情報取得を取得する処理

		// PROCESS_MODEのチェックを行う。
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_UPDATE) {
			// 更新モード
			// PROCESS_MODEが、共通定数の｢PROCESS_MODE_UPDATE(3)｣だった場合

			// 事業所情報を取得し、providerListに格納。 ※共通関数 getProviderInfoを使用
			setProviderList(QkanCommon.getProviderInfo(getDBManager(),
					getSelectedProviderId()));

			// パッシブチェック用のデータを登録する。
			getPassiveChecker().reservedPassive(
					getPROVIDER_PASSIVE_CHECK_KEY(), getProviderList());

			if (getProviderList() == null || getProviderList().size() == 0) {
				// 更新モードにおいて事業所情報を取得できなかった場合
				// 強制的に全画面に遷移する。

				// エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();

				// 前画面に戻る。(処理を抜ける)
				setCompulsoryBackFlag(1);
				ACFrame.getInstance().back();
				return;
			}

			// 「事業所情報領域（providerContents）｣に取得した事業所情報を設定する。
			getProviderContents().setSource(getFirstRecord(getProviderList()));

			// 画面に展開する。
			getProviderContents().bindSource();

			// 事業所メニュー情報を取得する。
			doFindProviderMenu();

		}

		// 提供サービステーブルのデータを取得する。
		doCreateServiceTableData();

		// 担当者情報を取得する。
		doCreateStaffData();

		// 取得した担当者テーブルのデータ（providerServiceList）をproviderServiceTableModelに設定する。
		getProviderServiceTableModel().setAdaptee(getProviderServiceList());

		// 取得した担当者テーブルのデータ（providerStaffList）をproviderStaffTableModelに設定する。
		getProviderStaffTableModel().setAdaptee(getProviderStaffList());

		if (!(getProviderStaffList() == null || getProviderStaffList().size() == 0)) {
			// 担当者情報が1件以上の場合
			// テーブルの一行目を選択した状態にする。 ※選択イベント
			getProviderStaffTable().setSelectedSortedFirstRow();
		}

		// 提供サービス関連の状態設定
		setState_SERVICE_DETAIL_BUTTON_ENABLE_FALSE();

		// フォーカス
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
			getProviderId().requestFocus();
		} else {
			getProviderName().requestFocus();
		}

		// スナップショットを撮影する。
		getSnapshot().snapshot();
		getServiceSnapshot().snapshot();
		getStaffSnapshot().snapshot();

	}

	/**
	 * 「事業所メニュー情報を取得する」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * 
	 */
	public void doFindProviderMenu() throws Exception {

		// 事業所メニュー情報を取得する取得する処理
		// SQL文取得用のVRMap paramを生成し、以下のKEY/VALUEを設定する。
		// KEY：PROVIDER_ID VALUE：selectedProviderId
		VRMap param = new VRHashMap();
		VRBindPathParser.set("PROVIDER_ID", param, getSelectedProviderId());

		// 事業所メニュー取得用のSQL文を取得する。
		// SQL_ID：GET_PROVIDER_MENU
		String strSql = getSQL_GET_PROVIDER_MENU(param);

		// SQL文を実行し、事業所メニュー情報を取得する。
		// 取得した事業所メニュー情報をproviderMenuListに格納する。
		setProviderMenuList(getDBManager().executeQuery(strSql));

		if (getProviderMenuList() == null || getProviderMenuList().size() == 0) {
			// 事業所メニュー情報が存在しない場合
			setMenuDataExistenceFlag(0);
		} else {
			// 事業所メニュー情報が存在する場合
			setMenuDataExistenceFlag(1);
		}

	}

	/**
	 * 「提供サービスリスト用のデータを作成する」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doCreateServiceTableData() throws Exception {
		// 提供サービスリストを作成する処理

		// サービスマスタデータを取得する。
		VRMap temp = QkanCommon.getMasterService(getDBManager(),
				TARGET_DATE_20060401);

		if (temp == null) {
			// マスタデータを取得できなかった場合
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_SERVICE_MASTER
			QkanMessageList.getInstance().QO004_ERROR_OF_SERVICE_MASTER();

			// 強制的に前画面に戻る。
			setCompulsoryBackFlag(1);
			ACFrame.getInstance().back();
			return;

		}

		// 医療看護、その他、主な日常生活上の活動を排除する。
		if (VRBindPathParser.has(new Integer(SERVICE_TYPE_IRYO_KANGO), temp)) {
			temp.remove(new Integer(SERVICE_TYPE_IRYO_KANGO));
		}
		if (VRBindPathParser.has(new Integer(SERVICE_TYPE_OTHER), temp)) {
			temp.remove(new Integer(SERVICE_TYPE_OTHER));
		}
		if (VRBindPathParser.has(new Integer(SERVICE_TYPE_ROUTINE), temp)) {
			temp.remove(new Integer(SERVICE_TYPE_ROUTINE));
		}

		VRList list = new VRArrayList(temp.values());
		setProviderServiceList(list);

		// マスタデータを取得できた場合
		// 詳細情報格納用
		VRList providerServiceDetailList = new VRArrayList();

		// PROCESS_MODEをチェックする。
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_UPDATE) {
			// 更新モード
			// PROCESS_MODEが、共通定数の｢PROCESS_MODE_UPDATE(3)｣だった場合

			// 提供サービス詳細情報を取得する。
			providerServiceDetailList = QkanCommon.getProviderServiceDetail(
					getDBManager(), getSelectedProviderId());

		}

		if (providerServiceDetailList != null
				|| providerServiceDetailList.size() == 0) {
			// 事業所サービス情報が存在しない場合
			setServiceDataExistenceFlag(0);
		} else {
			// 事業所サービス情報が存在する場合
			setServiceDataExistenceFlag(1);
		}

		// マスタデータに提供フラグの値を追加する。
		for (int i = 0; i < getProviderServiceList().size(); i++) {
			// 提供サービス情報（providerServiceList）のサービス種類と、
			// 提供サービス詳細情報（providerServiceDetailList）のサービス種類を1レコードずつ比較する。
			VRMap service = (VRMap) getProviderServiceList().get(i);

			// 詳細情報に一致するデータがあるか検索する。
			VRMap detail = ACBindUtilities.getMatchRowFromMap(
					providerServiceDetailList, "SYSTEM_SERVICE_KIND_DETAIL",
					service);

			if (detail == null) {
				// サービス種類の一致するレコードが無かった場合
				// providerServiceList内の比較したレコードに以下のKEY/VALUEを設定する。
				// KEY：OFFER VALUE：FALSE
				VRBindPathParser.set("OFFER", service, new Boolean(false));
			} else {
				// サービス種類の一致するレコードがあった場合
				// レコード同士をマージしproviderServiceListに格納する。
				service.putAll(detail);
				// レコード内に以下のKEY/VALUEを設定する。
				// KEY：OFFER VALUE：TRUE
				VRBindPathParser.set("OFFER", service, new Boolean(true));
			}

			// レコードをproviderServiceListに戻す。
			getProviderServiceList().set(i, service);
		}
        

        // [ID:0000440][Tozo TANAKA] 2009/03/09 add begin 平成21年4月法改正対応
        int oldLowSetting = 0;
        if (ACFrame.getInstance().getPropertyXML().hasValueAt(
                "ScreenConfig/ShowOldLowProviderElements")) {
            //システム設定[ScreenConfig/ShowOldLowProviderElements]の値を取得する。
            oldLowSetting = ACCastUtilities.toInt(ACFrame
                    .getInstance().getPropertyXML().getValueAt(
                            "ScreenConfig/ShowOldLowProviderElements"),
                    0);
        }
        if(oldLowSetting <= 0){
            //取得した値が0以下の場合
            //法改正後になくなるサービスはフィルタリングして表示する。

            //提供サービス除外リストをクリアする。
            getFilteredServiceList().clear();
            Iterator it=getProviderServiceList().iterator();
            while(it.hasNext()){
                // 提供サービス情報（providerServiceList）のサービス種類を全走査する。
                VRMap service = (VRMap) it.next();
                switch (ACCastUtilities.toInt(VRBindPathParser.get(
                        "SYSTEM_SERVICE_KIND_DETAIL", service), 0)) {
                    //システムサービス種類が以下のいずれかの場合
                    case 12314:
                        //短期入所療養介護(基準適合診療所)
                    case 12614:
                        //介護予防短期入所療養介護(基準適合診療所)
                        //提供サービス除外リストに対象サービスを追加する。
                        getFilteredServiceList().add(service);
                        break;
                }
            }
            //提供サービス情報から提供サービス除外リストの項目を除外する。
            getProviderServiceList().removeAll(getFilteredServiceList());
        }
        // [ID:0000440][Tozo TANAKA] 2009/03/09 add end
        
	}

	/**
	 * 「担当者情報取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doCreateStaffData() throws Exception {
		// 担当者情報を取得する処理

		// PROCESS_MODEをチェックする。
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
			// PROCESS_MODEが、共通定数の｢PROCESS_MODE_INSERT(4)｣だった場合
			// STAFF_PROCESS_MODEを、共通定数の｢PROCESS_MODE_INSERT(4)｣に設定する。
			setSTAFF_PROCESS_MODE(QkanConstants.PROCESS_MODE_INSERT);
			// 画面状態を設定する。※編集・削除ボタンをEnable制御し押下不可にする。
			setState_STAFF_BUTTON_STATE1();
			// 存在フラグ
			setStaffDataExistenceFlag(0);
		} else {
			// PROCESS_MODEが、共通定数の｢PROCESS_MODE_UPDATE(3)｣だった場合
			// HashMap：paramを作成し以下のKEY/VALUEで設定する。
			// KEY：PROVIDER_ID VALUE：selectedProviderId
			VRMap param = new VRHashMap();
			VRBindPathParser.set("PROVIDER_ID", param, getSelectedProviderId());

			// 担当者情報を取得するためのSQL文を取得する。
			String strSql = getSQL_GET_STAFF(param);

			// 取得したSQL文を実行する。
			setProviderStaffList(getDBManager().executeQuery(strSql));

			if (getProviderStaffList() == null
					|| getProviderStaffList().size() == 0) {
				// レコードが取得できなかった場合
				// STAFF_PROCESS_MODEを、共通定数の｢PROCESS_MODE_INSERT(4)｣に設定する。
				setSTAFF_PROCESS_MODE(QkanConstants.PROCESS_MODE_INSERT);
				// 担当者情報領域の初期値作成
				VRMap defaultMap = (VRMap) getProviderStaffInputPanel()
						.createSource();
				// 領域のクリア
				getProviderStaffInputPanel().setSource(defaultMap);
				getProviderStaffInputPanel().bindSource();
				// 画面状態を設定する。※編集・削除ボタンをEnable制御し押下不可にする。
				setState_STAFF_BUTTON_STATE1();
				// 存在フラグ
				setStaffDataExistenceFlag(0);
			} else {
				// レコードが取得できた場合
				// STAFF_PROCESS_MODEを、共通定数の｢PROCESS_MODE_UPDATE(3)｣に設定する。
				setSTAFF_PROCESS_MODE(QkanConstants.PROCESS_MODE_UPDATE);
				// 存在フラグ
				setStaffDataExistenceFlag(1);
			}
		}
	}

	/**
	 * 「担当者情報入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @return boolean
	 */
	public boolean isValidInputStaff(int checkMode) throws Exception {
		// 担当者情報の入力チェックを行う。
		String msgParam1;
		String msgParam2;

		// 下記のテキストフィールドに入力されている場合、文字列の長さをチェックする。
		// ・providerStaffCareManagerNo（支援専門員番号）
		// ※エラーの場合、String：msgParam1を宣言し、"支援専門員番号"を代入する。
		// ※エラーの場合、String：msgParam2を宣言し、"8"を代入する。
		if (!ACTextUtilities.isNullText(getProviderStaffCareManagerNo()
				.getText())) {
			String careManagerNo = getProviderStaffCareManagerNo().getText();

			if (careManagerNo.length() != 8) {
				// 文字列長が8桁でない場合
				getProviderStaffCareManagerNo().requestFocus();
				msgParam1 = "支援専門員番号";
				msgParam2 = "8";
				QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
						msgParam2);
				return false;
			}

			// 同事業所内に同一の介護支援専門員番号が存在しないかチェックする。
			for (int i = 0; i < getProviderStaffList().size(); i++) {
				// 編集モードの場合、自身のレコードは無視する。
				if (checkMode == CHECK_MODE_UPDATE) {
					if (i == getProviderStaffTable().getSelectedModelRow()) {
						continue;
					}
				}

				// 介護支援専門員番号を比較する。
				VRMap temp = (VRMap) getProviderStaffList().get(i);
				if (careManagerNo
						.equals(ACCastUtilities.toString(VRBindPathParser.get(
								"CARE_MANAGER_NO", temp)))) {
					getProviderStaffCareManagerNo().requestFocus();
					QkanMessageList.getInstance()
							.QO004_ERROR_OF_DUPLICATE_CARE_MANAGER_NO();
					return false;
				}
			}

			// // 他の事業所内に同一の介護支援専門員番号が存在しないかチェックする。
			// VRMap param = new VRHashMap();
			// if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_UPDATE) {
			// // 更新モードの場合
			// // パラメータに事業所IDを含める
			// VRBindPathParser.set("PROVIDER_ID", param,
			// getSelectedProviderId());
			// }
			// VRBindPathParser.set("CARE_MANAGER_NO", param, careManagerNo);
			//
			// String strSql = getSQL_GET_SAME_CARE_MANAGER_NO(param);
			// VRList sameNoStaffList = getDBManager().executeQuery(strSql);
			//
			// if (!(sameNoStaffList == null || sameNoStaffList.size() == 0)) {
			// getProviderStaffCareManagerNo().requestFocus();
			// QkanMessageList.getInstance().QO004_ERROR_OF_DUPLICATE_CARE_MANAGER_NO();
			// return false;
			// }

		}

		// 下記のテキストフィールドが入力されているかチェックする。
		// ・providerStaffFamilyName（担当者姓）
		// ・providerStaffInsert（担当者名） ※姓名はどちらか一方に入力されていれば可
		// ※エラーの場合、String：msgParamを宣言し、"担当者名"を代入する。
		if (ACTextUtilities.isNullText(getProviderStaffFamilyName().getText())
				&& ACTextUtilities.isNullText(getProviderStaffFirstName()
						.getText())) {
			getProviderStaffFamilyName().requestFocus();
			msgParam1 = "担当者名";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// 入力エラーがなかった場合
		return true;

	}

	/**
	 * 「保存処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doSave() throws Exception {
		// 保存を行う処理
		try {

			// 定義
			String errMsg;
			String errMsg2;
			String strSql;

			// 画面上のデータを取得する。
			VRMap affairData = new VRHashMap();
			getProviderContents().setSource(affairData);
			getProviderContents().applySource();

            //2009/02/25 [ID:0000440][Tozo TANAKA] add begin - 平成21年4月法改正対応
            //＜平成21年4月法改正対応＞
            //入力エラーの検出
            if (ACCastUtilities.toInt(VRBindPathParser.get("SPECIAL_AREA_FLAG",
                    affairData), 1) == 2) {
                // 特別地域にチェックがついている場合
                // 地域・規模ともに「中山間地域等」に該当する提供サービス情報がないかをチェックする。
                int serviceCount = getProviderServiceList().size();
                for (int i = 0; i < serviceCount; i++) {
                    VRMap serviceInfo = (VRMap) getProviderServiceList().get(i);
                    if (ACCastUtilities.toInt(VRBindPathParser.get(
                            BIND_PATH_OF_MOUNTAINOUS_AREA_RAFIO, serviceInfo),
                            1) == 2
                            && ACCastUtilities.toInt(VRBindPathParser.get(
                                    BIND_PATH_OF_MOUNTAINOUS_AREA_SCALE,
                                    serviceInfo), 1) == 2) {
                        // 地域・規模ともに「中山間地域等」に該当する提供サービス情報があった場合
                        // エラーメッセージを表示する。
                        VRMap messageParam = new VRHashMap();
                        messageParam.put("serviceName", VRBindPathParser.get(
                                "SERVICE_ABBREVIATION", serviceInfo));
                        QkanMessageList.getInstance()
                                .QO004_ERROR_OF_AREA_COLLISION(messageParam);

                        // 提供サービステーブルの当該サービスにフォーカスをあて、サービス詳細情報を表示させる。
                        getServiceKindTable().setSelectedModelRow(i);
                        //戻り値としてfalseを返す。
                        return false;
                    }
                }
            }
            //2009/02/25 [ID:0000440][Tozo TANAKA] add end - 平成21年4月法改正対応
            
			// トランザクションを開始する。
			getDBManager().beginTransaction();

			// 削除された事業所の中に、入力された事業所番号と
			// 一致する事業所番号を持つ事業所がいないかチェックする。
			if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
				strSql = getSQL_GET_DELETE_PROVIDER_OF_DUPLICATE_ID(affairData);
				VRList list = getDBManager().executeQuery(strSql);
				if (!(list == null || list.size() == 0)) {
					// 事業所が存在する場合
					errMsg = "事業所番号";
					errMsg2 = "事業所";
					switch (QkanMessageList.getInstance()
							.WARNING_OF_RESTORATION_OF_DELETE_DATA(errMsg,
									errMsg2)) {
					case ACMessageBox.RESULT_OK:
						// 更新モードに切り替える
						setPROCESS_MODE(QkanConstants.PROCESS_MODE_UPDATE);
						// 事業所番号を設定
						setSelectedProviderId(ACCastUtilities
								.toString(VRBindPathParser.get("PROVIDER_ID",
										affairData)));
						// フラグの初期化
						clearFlags();
						// 画面セットアップ
						affairSetUp();
						// 検索
						doFind();
						// サービスの一行目を選択
						getServiceKindTable().setSelectedSortedFirstRow();
						break;
					}
					// トランザクション解除
					getDBManager().rollbackTransaction();
					// 処理終了
					return false;
				}
			}

			// パッシブタスクをクリアする。
			getPassiveChecker().clearPassiveTask();

			// PROCESS_MODEをチェックする。
			if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
				// PROCESS_MODEが、共通定数の｢PROCESS_MODE_INSERT(4)｣だった場合
				// 登録用パッシブタスクを登録する。
				getPassiveChecker().addPassiveInsertTask(
						getPROVIDER_PASSIVE_CHECK_KEY(), affairData);
			} else {
				// PROCESS_MODEが、共通定数の｢PROCESS_MODE_UPDATE(3)｣だった場合
				// 更新用パッシブタスクを登録する。
				getPassiveChecker().addPassiveUpdateTask(
						getPROVIDER_PASSIVE_CHECK_KEY(), 0);
			}

			// パッシブチェックを行う。
			if (!getPassiveChecker().passiveCheck(getDBManager())) {
				// パッシブエラーが発生した場合
				if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
					// PROCESS_MODEが、共通定数の｢PROCESS_MODE_INSERT(4)｣だった場合
					// エラーメッセージを表示する。
					// ※メッセージID = ERROR_OF_SAME_DATA_FOUND 引数 = "事業所"
					errMsg = "事業所番号";
					QkanMessageList.getInstance().ERROR_OF_SAME_DATA_FOUND(
							errMsg);
					getProviderId().requestFocus();
				} else {
					// PROCESS_MODEが、共通定数の｢PROCESS_MODE_UPDATE(3)｣だった場合
					// エラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
					QkanMessageList.getInstance()
							.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
				}
				// トランザクション解除
				getDBManager().rollbackTransaction();
				// 処理終了
				return false;
			}

			// 事業所基本情報の登録
			// PROCESS_MODEをチェックする。
			if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
				// PROCESS_MODEが、共通定数の｢PROCESS_MODE_INSERT(4)｣だった場合
				// 事業所情報登録のためのSQL文を取得する
				strSql = getSQL_INSERT_PROVIDER(affairData);
				// 取得したSQL文を実行する。
				getDBManager().executeUpdate(strSql);
				// 事業所番号の退避
				setSelectedProviderId(getProviderId().getText());
			} else {
				// PROCESS_MODEが、共通定数の｢PROCESS_MODE_UPDATE(3)｣だった場合
				// 事業所情報更新のためのSQL文を取得する。
				strSql = getSQL_UPDATE_PROVIDER(affairData);
				// 取得したSQL文を実行する。
				getDBManager().executeUpdate(strSql);
			}

			// 担当者情報の登録
			VRMap staffMap;
			// 削除
			if (getStaffDataExistenceFlag() == 1) {
				// 画面展開時に担当者情報が存在した場合
				// 全件削除
				staffMap = new VRHashMap();
				// staffMapに下記のKEY/VALUEを設定する。
				// KEY：PROVIDER_ID VALUE：selectedProviderId
				VRBindPathParser.set("PROVIDER_ID", staffMap,
						getSelectedProviderId());
				// 担当者情報削除のためのSQL文を取得する。
				strSql = getSQL_DELETE_STAFF(staffMap);
				// 取得したSQL文を実行する。
				getDBManager().executeUpdate(strSql);

			}
			// 登録
			// providerStaffListのレコード数をチェックする。
			// レコードが1件以上だった場合
			if (!(getProviderStaffList() == null || getProviderStaffList()
					.size() == 0)) {
				for (int i = 0; i < getProviderStaffList().size(); i++) {
					// VRMap：staffMapを作成する。
					staffMap = new VRHashMap();
					staffMap = (VRMap) getProviderStaffList().get(i);
					// staffMapに下記のKEY/VALUEを設定する。
					// KEY：PROVIDER_ID VALUE：selectedProviderId
					VRBindPathParser.set("PROVIDER_ID", staffMap,
							getSelectedProviderId());
					// 担当者情報登録のためのSQL文を取得する。
					strSql = getSQL_INSERT_STAFF(staffMap);
					// 取得したSQL文を実行する。
					getDBManager().executeUpdate(strSql);
				}
			}

            // [ID:0000444][Tozo TANAKA] 2009/03/09 replace begin 平成21年4月法改正対応
//            // providerServiceList内のレコード数分ループを回し登録処理をする。
//            VRList insertServiceList = new VRArrayList();
//            for (int i = 0; i < getProviderServiceList().size(); i++) {
//                VRMap temp = (VRMap) getProviderServiceList().get(i);
//                boolean offer = ACCastUtilities.toBoolean(VRBindPathParser.get(
//                        "OFFER", temp));
//                int systemServiceKindDetail = ACCastUtilities
//                        .toInt(VRBindPathParser.get(
//                                "SYSTEM_SERVICE_KIND_DETAIL", temp));
//
//                // providerServiceListよりOFFERの値がtrueのレコードを取得する。
//                if (offer) {
//                    // 登録用VRListに追加
//                    insertServiceList.add(temp);
//                    // SYSTEM_SERVICE_KIND_DETAILが11301（訪問看護（介護））の場合
//                    if (systemServiceKindDetail == SERVICE_TYPE_KAIGO_KANGO) {
//                        // 訪問看護（医療）の作成
//                        // 訪問看護（医療）のマスタデータをサービスマスタより取得
//                        // ※訪問看護（医療）は画面展開時に削除
//                        VRMap iryoKango = (VRMap) VRBindPathParser.get(
//                                new Integer(SERVICE_TYPE_IRYO_KANGO),
//                                (VRMap) QkanCommon
//                                        .getMasterService(getDBManager()));
//                        // 画面上データ（訪問看護（介護））とマスタデータ（訪問看護（医療））をマージ
//                        VRMap cloneTemp = (VRMap) temp.clone();
//                        cloneTemp.putAll(iryoKango);
//                        insertServiceList.add(cloneTemp);
//                    }
//                }
//            }
            //フィルタされないサービス、フィルタされるサービス両方を結合したリストnoFilteredProviderServiceListを生成する。
            VRList noFilteredProviderServiceList = new VRArrayList();
            noFilteredProviderServiceList.addAll(getProviderServiceList());
            noFilteredProviderServiceList.addAll(getFilteredServiceList());
            
			// noFilteredProviderServiceList内のレコード数分ループを回し登録処理をする。
			VRList insertServiceList = new VRArrayList();
			for (int i = 0; i < noFilteredProviderServiceList.size(); i++) {
				VRMap temp = (VRMap) noFilteredProviderServiceList.get(i);
				boolean offer = ACCastUtilities.toBoolean(VRBindPathParser.get(
						"OFFER", temp));
				int systemServiceKindDetail = ACCastUtilities
						.toInt(VRBindPathParser.get(
								"SYSTEM_SERVICE_KIND_DETAIL", temp));

				// noFilteredProviderServiceListよりOFFERの値がtrueのレコードを取得する。
				if (offer) {
					// 登録用VRListに追加
					insertServiceList.add(temp);
					// SYSTEM_SERVICE_KIND_DETAILが11301（訪問看護（介護））の場合
					if (systemServiceKindDetail == SERVICE_TYPE_KAIGO_KANGO) {
						// 訪問看護（医療）の作成
						// 訪問看護（医療）のマスタデータをサービスマスタより取得
						// ※訪問看護（医療）は画面展開時に削除
						VRMap iryoKango = (VRMap) VRBindPathParser.get(
								new Integer(SERVICE_TYPE_IRYO_KANGO),
								(VRMap) QkanCommon
										.getMasterService(getDBManager()));
						// 画面上データ（訪問看護（介護））とマスタデータ（訪問看護（医療））をマージ
						VRMap cloneTemp = (VRMap) temp.clone();
						cloneTemp.putAll(iryoKango);
						insertServiceList.add(cloneTemp);
					}
				}
			}
            // [ID:0000444][Tozo TANAKA] 2009/03/09 replace end

			if (insertServiceList != null) {

				// メニュー情報登録
				// 画面展開時にデータが存在していた場合、全件削除
				if (getMenuDataExistenceFlag() == 1) {
					// 事業所メニュー情報が存在する場合
					// パラメータ作成
					VRMap param = new VRHashMap();
					VRBindPathParser.set("PROVIDER_ID", param,
							getSelectedProviderId());

					// SQL文取得、実行
					strSql = getSQL_DELETE_PROVIDER_MENU(param);
					getDBManager().executeUpdate(strSql);
				}

				// 自事業所の場合のみ、登録
				// providerList内のPROVIDER_JIJIGYOUSHO_TYPE の値をチェックする。
				int jijigyoshoType = ACCastUtilities.toInt(VRBindPathParser
						.get("PROVIDER_JIJIGYOUSHO_TYPE", affairData));
				if (jijigyoshoType == PROVIDER_TYPE_JIJIGYOSHO) {
					// 自事業所である場合
					// 事業所メニューを確定し登録する処理を行う。
					insertProviderMenu(insertServiceList);
				}

				// 余計なキーを排除
				final String[] removeKeys = new String[] {
						"PROVIDER_SERVICE_ID", "SERVICE_VALID_START",
						"SERVICE_VALID_END", "SERVICE_CODE_KIND",
						"SERVICE_NAME", "SERVICE_ABBREVIATION",
						"SERVICE_KIND_NAME", "SERVICE_CALENDAR_ABBREVIATION",
						"CLAIM_STYLE_TYPE", "BUSINESS_TYPE",
						"CALENDAR_PASTE_FLAG", "CHANGES_CONTENT_TYPE",
						"CLAIM_LAYER", "SERVICE_FAMILY", "SERVICE_SORT",
						"LAST_TIME", "OFFER" };

				ACBindUtilities.removeKeys(insertServiceList, removeKeys);

				// 事業所IDを付加
				for (int i = 0; i < insertServiceList.size(); i++) {
					VRBindPathParser.set("PROVIDER_ID",
							(VRMap) insertServiceList.get(i),
							getSelectedProviderId());
				}

				// 事業所サービス詳細情報の登録を行う。
				QkanCommon.updateProviderServiceDetail(getDBManager(),
						insertServiceList, getSelectedProviderId());

			}

			// 処理をコミットする。
			getDBManager().commitTransaction();

		} catch (Exception ex) {
			// トランザクション開始から、エラーが発生していた場合
			// 処理をロールバックする。
			getDBManager().rollbackTransaction();
			throw ex;
		}

		// フラグの初期化
		clearFlags();

		return true;
	}

	/**
	 * 「削除可能なサービスか判断する処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doCheckDeleteService() throws Exception {
		// 削除可能なサービスか判別する処理

		// 内部変数
		VRMap sqlParam;
		VRList list;
		String strSql;
		String errMsg;

		// 登録モードの場合
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
			// チェックを行わない
			return true;
		}

		// 対象データの取得
		VRMap temp = getServiceInfos(getCurrentServiceType());
		int systemServiceKindDetail = ACCastUtilities.toInt(VRBindPathParser
				.get("SYSTEM_SERVICE_KIND_DETAIL", temp));

		// sqlParamに下記の値を格納する。
		// KEY：SYSTEM_SERVICE_KIND_DETAIL
		// VALUE：現在表示しているパネルのSYSTEM_SERVICE_KIND_DETAIL
		// KEY：PROVIDER_ID VALUE：selectedProviderId
		sqlParam = new VRHashMap();
		VRBindPathParser.set("SYSTEM_SERVICE_KIND_DETAIL", sqlParam,
				new Integer(systemServiceKindDetail));
		VRBindPathParser.set("PROVIDER_ID", sqlParam, getSelectedProviderId());

		// 現在表示されているパネルが居宅介護支援事業（14301）だった場合
		if (systemServiceKindDetail == SERVICE_TYPE_CARE_PLAN) {
			// 要介護認定TABLEで登録されている事業所かチェックする。

			// 要介護認定TABLEチェック用のSQL文を取得する。
			strSql = getSQL_GET_PATIENT_NINTEI_HISTORY(sqlParam);
			// 取得したSQL文を実行する。
			list = new VRArrayList();
			list = getDBManager().executeQuery(strSql);

			// レコードが取得できた場合
			if (list.size() > 0) {
				// errMsg = 利用者登録で居宅介護支援事業所
				// エラーメッセージーを表示する。
				// ※メッセージID=ERROR_OF_DELETE_USED 第1引数=errMsg
				errMsg = "利用者登録で居宅介護支援事業所";
				QkanMessageList.getInstance().ERROR_OF_DELETE_USED(errMsg);
				// 戻り値としてfalseを返す。
				return false;
			}
		}

		// サービスTABLEで登録されている事業所として登録されているかチェックする。
		// サービスTABLE用のSQL文を取得する。
		strSql = getSQL_GET_SERVICE(sqlParam);
		// 取得したSQL文を実行する。
		list = new VRArrayList();
		list = getDBManager().executeQuery(strSql);

		// レコードが取得できた場合
		if (list.size() > 0) {
			// errMsg = サービスの予定又は実績
			// エラーメッセージーを表示する。
			// ※メッセージID=ERROR_OF_DELETE_USED 第1引数=errMsg
			errMsg = "サービスの提供事業所";
			QkanMessageList.getInstance().ERROR_OF_DELETE_USED(errMsg);
			// 戻り値としてfalseを返す。
			return false;
		}

		// 全てのSQL文の結果が0件だった場合
		// 戻り値としてtrueを返す
		return true;

	}

	/**
	 * 「事業所メニュー情報を登録する」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void insertProviderMenu(VRList list) throws Exception {
		// 事業所登録メニューを確定する。
		// 定義
		// SQL文取得用
		String strSql;

		try {

			// 登録したサービスをBUSINESS_TYPEを全て統合（論理和で計算）し結果を businessType（変数）に格納する。
			int businessTypeSum = 0;
			int businessTypeTemp = 0;
			for (int i = 0; i < list.size(); i++) {
				VRMap temp = (VRMap) list.get(i);
				businessTypeTemp = ACCastUtilities.toInt(VRBindPathParser.get(
						"BUSINESS_TYPE", temp));
				businessTypeSum = businessTypeSum | businessTypeTemp;
			}

			// 取得したメニューマスタのレコード数分 下記の処理を行う。
			int businessTypeMaster = 0;
			for (int i = 0; i < getMasterMenuList().size(); i++) {
				// masterMenuList内のレコードをmasterMenuMapに格納する。
				VRMap masterMenuMap = new VRHashMap();
				masterMenuMap = (VRMap) getMasterMenuList().get(i);
				businessTypeMaster = ACCastUtilities.toInt(VRBindPathParser
						.get("BUSINESS_TYPE", masterMenuMap));

				// businessTypeMasterとbusinessTypeを論理積で計算する。
				if ((businessTypeMaster & businessTypeSum) == 0) {
					// 計算した値が0だった場合
					// masterMenuMapに下記のKEY/VALUEを設定する。
					// KEY：PROVIDER_ID VALUE：selectedProviderId
					// KEY：SHOW_FLAG VALUE：0
					VRBindPathParser.set("PROVIDER_ID", masterMenuMap,
							getSelectedProviderId());
					VRBindPathParser.set("SHOW_FLAG", masterMenuMap,
							new Integer(0));
				} else {
					// 計算した値が0以外の場合
					// masterMenuMapに下記のKEY/VALUEを設定する。
					// KEY：PROVIDER_ID VALUE：selectedProviderId
					// KEY：SHOW_FLAG VALUE：1
					VRBindPathParser.set("PROVIDER_ID", masterMenuMap,
							getSelectedProviderId());
					VRBindPathParser.set("SHOW_FLAG", masterMenuMap,
							new Integer(1));
				}

				// 事業所メニュー情報登録処理を行うためのSQL文を取得する。
				strSql = getSQL_INSERT_PROVIDER_MENU(masterMenuMap);
				// 取得したSQL文を実行する。
				getDBManager().executeUpdate(strSql);

				// ログイン事業所の編集を行った場合のみ
				// システムに退避している事業所のメニューデータを削除する。
				if (getSelectedProviderId().equals(
						QkanSystemInformation.getInstance()
								.getLoginProviderID())) {
					QkanSystemInformation.getInstance().setMenuTree(null);
				}
			}

		} catch (Exception ex) {
			// SQL文実行時にエラーが発生した場合
			// 例外エラーを投げる。
			throw ex;
		}

	}

	/**
	 * 「マスタメニューから情報を取得する処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void getMasterMenu() throws Exception {
		// マスタメニューから情報を取得する処理
		// マスタメニューから情報を取得するためのSQL文を取得する。
		String strSql = getSQL_GET_M_MENU(null);
		// 取得したSQL文を実行する。
		VRList list = getDBManager().executeQuery(strSql);

		if (list == null || list.size() == 0) {
			// 取得したレコードが0件だった場合
			// エラーメッセージを表示する。
			// ※メッセージID = QO004_ERROR_OF_MASTER_MENU
			QkanMessageList.getInstance().QO004_ERROR_OF_MASTER_MENU();
			return;
		}

		// レコードが1件以上取得できた場合
		// 取得したレコード集合をMasterMenuListに格納する。
		setMasterMenuList(list);

	}

	/**
	 * 「事業所基本情報チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doValidProviderCheck() throws Exception {
		// 事業所基本情報をチェックする。

		// エラーメッセージ文言格納用にerrMsgを作成する。
		String errMsg1;
		String errMsg2;

		// 下記のテキストフィールドに対して入力チェックを行う。
		// ・providerId（事業所番号）
		if (ACTextUtilities.isNullText(getProviderId().getText())) {
			getProviderId().requestFocus();
			errMsg1 = "事業所番号";
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg1);
			return false;
		}

		// 事業所番号を10桁かチェックする。
		String temp = getProviderId().getText();
		if (temp.length() != 10) {
			getProviderId().requestFocus();
			errMsg1 = "事業所番号";
			errMsg2 = "10";
			QkanMessageList.getInstance().ERROR_OF_LENGTH(errMsg1, errMsg2);
			return false;
		}

		// ・providerName（事業所名称）
		if (ACTextUtilities.isNullText(getProviderName().getText())) {
			getProviderName().requestFocus();
			errMsg1 = "事業所名称";
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg1);
			return false;
		}

		// 下記のラジオグループに対して選択チェックを行う。
		// 未選択だった場合は errMsg にメッセージを格納する。
		// ・providerMainContentDivision（自事業所区分ラジオグループ）※ errMsg = 自事業所区分
		if (!getProviderMainContentDivision().isSelected()) {
			getProviderMainContentDivision().requestFocus();
			errMsg1 = "自事業所区分";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					errMsg1);
			return false;
		}

		// ・providerMainContentBusiness（事業区分ラジオグループ）※ errMsg = 事業区分
		if (!getProviderMainContentBusiness().isSelected()) {
			getProviderMainContentBusiness().requestFocus();
			errMsg1 = "事業区分";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					errMsg1);
			return false;
		}

		// ・providerMainContentRegion（地域区分ラジオグループ） ※errMsg = 地域区分
		if (!getProviderMainContentRegion().isSelected()) {
			getProviderMainContentRegion().requestFocus();
			errMsg1 = "地域区分";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					errMsg1);
			return false;
		}

		return true;
	}

	/**
	 * 「サービスパネル生成」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @param int
	 *            システムサービス種類コード
	 */
	public ACPanel createProviderServicePanel(int serviceType) throws Exception {

		switch (serviceType) {
		// // 値が 11101（訪問介護） だった場合
		// case 11101:
		// // panelにACPanel "QO004001"（訪問介護）を生成する。
		// return new QO004001();
		// // 値が 11201（訪問入浴介護） だった場合
		// case 11201:
		// // panelにACPanel"QO004002"（訪問入浴介護）を生成する。
		// return new QO004002();
		// // 値が 11301（訪問看護） だった場合
		// case 11301:
		// // panelにACPanel"QO004003"（訪問介護）を生成する。
		// return new QO004003();
		// // 値が 11401（訪問リハ） だった場合
		// case 11401:
		// // panelにACPanel"QO004004"（訪問リハ）を生成する。
		// return new QO004004();
		// // 値が 11501（通所介護） だった場合
		// case 11501:
		// // panelにACPanel"QO004005"（通所介護）を生成する。
		// return new QO004005();
		// // 値が 11601（通所リハ） だった場合
		// case 11601:
		// // panelにACPanel"QO004006"（通所リハ）を生成する。
		// return new QO004006();
		// // 値が 11701（福祉用具） だった場合
		// case 11701:
		// // panelにACPanel"QO004007"（福祉用具）を生成する。
		// return new QO004007();
		// // 値が 12101（短期入所生活） だった場合
		// case 12101:
		// // panelにACPanel"QO004008"（短期入所生活）を生成する。
		// return new QO004008();
		// // 値が 12201（短期入所療養介護（老健）） だった場合
		// case 12201:
		// // panelにACPanel"QO004009"（短期入所療養介護（老健））を生成する。
		// return new QO004009();
		// // 値が 12301（短期入所療養介護(病院療養型)） だった場合
		// case 12301:
		// // panelにACPanel"QO004010"（短期入所療養介護(病院療養型)）を生成する。
		// return new QO004010();
		// // 値が 12302（短期入所療養介護(診療所療養型)） だった場合
		// case 12302:
		// // panelにACPanel"QO004011"（短期入所療養介護(診療所療養型)）を生成する。
		// return new QO004011();
		// // 値が 12303（短期入所療養介護(短期入所療養介護(認知症疾患型)） だった場合
		// case 12303:
		// // panelにACPanel"QO004012"（短期入所療養介護(認知症疾患型)）を生成する。
		// return new QO004012();
		// // 値が 12304（短期入所療養介護(基準適合診療所)） だった場合
		// case 12304:
		// // panelにACPanel"QO004013"（短期入所療養介護(基準適合診療所)）を生成する。
		// return new QO004013();
		// // 値が 13201（認知症対応型共同生活介護） だった場合
		// case 13201:
		// // panelにACPanel"QO004014"（認知症対応型共同生活介護）を生成する。
		// return new QO004014();
		// // 値が 13301（特定施設入所者生活介護） だった場合
		// case 13301:
		// // panelにACPanel"QO004015"（特定施設入所者生活介護）を生成する。
		// return new QO004015();
		// // 値が 15101（介護老人福祉施設） だった場合
		// case 15101:
		// // panelにACPanel"QO004016"（介護老人福祉施設）を生成する。
		// return new QO004016();
		// // 値が 15201（介護老人保健施設） だった場合
		// case 15201:
		// // panelにACPanel"QO004017"（介護老人保健施設）を生成する。
		// return new QO004017();
		// // 値が 15301（介護療養型医療施設(療養型病院)） だった場合
		// case 15301:
		// // panelにACPanel"QO004018"（介護療養型医療施設(療養型病院)）を生成する。
		// return new QO004018();
		// // 値が 15302（介護療養型医療施設(診療所型)） だった場合
		// case 15302:
		// // panelにACPanel"QO004019"（介護療養型医療施設(診療所型)）を生成する。
		// return new QO004019();
		// // 値が 15303（介護療養型医療施設(介護療養型医療施設(認知症疾患型)） だった場合
		// case 15303:
		// // panelにACPanel"QO004020"（介護療養型医療施設(認知症疾患型)）を生成する。
		// return new QO004020();
		// 値が 11111（訪問介護） だった場合
		case 11111:
			// 変数 servicePanel に ACPanel "QO004101"（訪問介護）を生成する。
			return new QO004101();
		// 値が 11211（訪問入浴介護） だった場合
		case 11211:
			// 変数 servicePanel に ACPanel"QO004102"（訪問入浴介護）を生成する。
			return new QO004102();
		// 値が 11311（訪問看護） だった場合
		case 11311:
			// 変数 servicePanel に ACPanel"QO004103"（訪問看護）を生成する。
			return new QO004103();
		// 値が 11411（訪問リハ） だった場合
		case 11411:
			// 変数 servicePanel に ACPanel"QO004105"（訪問リハ）を生成する。
			return new QO004105();
		// 値が 11511（通所介護） だった場合
		case 11511:
			// 変数 servicePanel に ACPanel"QO004107"（通所介護）を生成する。
			return new QO004107();
		// 値が 11611（通所リハ） だった場合
		case 11611:
			// 変数 servicePanel に ACPanel"QO004108"（通所リハ）を生成する。
			return new QO004108();
		// 値が 11711（福祉用具） だった場合
		case 11711:
			// 変数 servicePanel に ACPanel"QO004116"（福祉用具）を生成する。
			return new QO004116();
		// 値が 12111（短期入所生活） だった場合
		case 12111:
			// 変数 servicePanel に ACPanel"QO004109"（短期入所生活介護）を生成する。
			return new QO004109();
		// 値が 12211（短期入所療養介護（老健）） だった場合
		case 12211:
			// 変数 servicePanel に ACPanel"QO004110"（短期入所療養介護（老健））を生成する。
			return new QO004110();
		// 値が 12311（短期入所療養介護(病院療養型)） だった場合
		case 12311:
			// 変数 servicePanel に ACPanel"QO004111"（短期入所療養介護(病院療養型)）を生成する。
			return new QO004111();
		// 値が 12312（短期入所療養介護(診療所療養型)） だった場合
		case 12312:
			// 変数 servicePanel に ACPanel"QO004112"（短期入所療養介護(診療所療養型)）を生成する。
			return new QO004112();
		// 値が 12313（短期入所療養介護(短期入所療養介護(認知症疾患型)） だった場合
		case 12313:
			// 変数 servicePanel に ACPanel"QO004113"（短期入所療養介護(認知症疾患型)）を生成する。
			return new QO004113();
		// 値が 12314（短期入所療養介護(基準適合診療所)） だった場合
		case 12314:
			// 変数 servicePanel に ACPanel"QO004114"（短期入所療養介護(基準適合診療所)）を生成する。
			return new QO004114();
		// 値が 13111（居宅療養管理指導） だった場合
		case 13111:
			// 変数 servicePanel に ACPanel"QO004106"（居宅療養管理指導）を生成する。
			return new QO004106();
		// 値が 13311（特定施設入所者生活介護） だった場合
		case 13311:
			// 変数 servicePanel に ACPanel"QO004115"（特定施設入所者生活介護）を生成する。
			return new QO004115();
		// 値が 14311（居宅療養管理指導） だった場合
		case 14311:
			// 変数 servicePanel に ACPanel"QO004117"（居宅療養管理指導）を生成する。
			return new QO004117();
		// 値が 15111（介護老人福祉施設） だった場合
		case 15111:
			// 変数 servicePanel に ACPanel"QO004118"（介護老人福祉施設）を生成する。
			return new QO004118();
		// 値が 15211（介護老人保健施設） だった場合
		case 15211:
			// 変数 servicePanel に ACPanel"QO004119"（介護老人保健施設）を生成する。
			return new QO004119();
		// 値が 15311（介護療養型医療施設(療養型病院)） だった場合
		case 15311:
			// 変数 servicePanel に ACPanel"QO004120"（介護療養型医療施設(療養型病院)）を生成する。
			return new QO004120();
		// 値が 15312（介護療養型医療施設(診療所型)） だった場合
		case 15312:
			// 変数 servicePanel に ACPanel"QO004121"（介護療養型医療施設(診療所型)）を生成する。
			return new QO004121();
		// 値が 15313（介護療養型医療施設(介護療養型医療施設(認知症疾患型)） だった場合
		case 15313:
			// 変数 servicePanel に ACPanel"QO004122"（介護療養型医療施設(認知症疾患型)）を生成する。
			return new QO004122();
		// 値が 17111（夜間対応型訪問介護） だった場合
		case 17111:
			// 変数 servicePanel に ACPanel"QO004123"（夜間対応型訪問介護）を生成する。
			return new QO004123();
		// 値が 17211（認知症対応型通所介護） だった場合
		case 17211:
			// 変数 servicePanel に ACPanel"QO004124"（認知症対応型通所介護）を生成する。
			return new QO004124();
		// 値が 17311（小規模多機能型居宅介護） だった場合
		case 17311:
			// 変数 servicePanel に ACPanel"QO004125"（小規模多機能型居宅介護）を生成する。
			return new QO004125();
		// 値が 13211（認知症対応型共同生活介護（短期利用以外）） だった場合
		case 13211:
			// 変数 servicePanel に ACPanel"QO004126"（認知症対応型共同生活介護（短期利用以外））を生成する。
			return new QO004126();
		// 値が 13811（認知症対応型共同生活介護（短期利用）） だった場合
		case 13811:
			// 変数 servicePanel に ACPanel"QO004127"（認知症対応型共同生活介護（短期利用））を生成する。
			return new QO004127();
		// 値が 13611（地域密着型特定施設入居者生活介護） だった場合
		case 13611:
			// 変数 servicePanel に ACPanel"QO004128"（地域密着型特定施設入居者生活介護）を生成する。
			return new QO004128();
		// 値が 15411（地域密着型介護老人福祉施設） だった場合
		case 15411:
			// 変数 servicePanel に ACPanel"QO004129"（地域密着型介護老人福祉施設）を生成する。
			return new QO004129();

		// 値が 16111 ( 介護予防訪問介護 ) だった場合
		case 16111:
			// 変数 servicePanelにACPanel" QO004130 " ( 介護予防訪問介護 )を生成する。 16111
			return new QO004130();

		// 値が 16211 ( 介護予防訪問入浴介護 ) だった場合
		case 16211:
			// 変数 servicePanelにACPanel" QO004131 " ( 介護予防訪問入浴介護 )を生成する。 16211
			return new QO004131();

		// 値が 16311 ( 介護予防訪問看護 ) だった場合
		case 16311:
			// 変数 servicePanelにACPanel" QO004132 " ( 介護予防訪問看護 )を生成する。 16311
			return new QO004132();

		// 値が 16411 ( 介護予防訪問リハビリテーション ) だった場合
		case 16411:
			// 変数 servicePanelにACPanel" QO004133 " ( 介護予防訪問リハビリテーション )を生成する。
			// 16411
			return new QO004133();

		// 値が 13411 ( 介護予防居宅療養管理指導 ) だった場合
		case 13411:
			// 変数 servicePanelにACPanel" QO004134 " ( 介護予防居宅療養管理指導 )を生成する。 13411
			return new QO004134();

		// 値が 16511 ( 介護予防通所介護 ) だった場合
		case 16511:
			// 変数 servicePanelにACPanel" QO004135 " ( 介護予防通所介護 )を生成する。 16511
			return new QO004135();

		// 値が 16611 ( 介護予防通所リハビリテーション ) だった場合
		case 16611:
			// 変数 servicePanelにACPanel" QO004136 " ( 介護予防通所リハビリテーション )を生成する。
			// 16611
			return new QO004136();

		// 値が 12411 ( 介護予防短期入所生活介護 ) だった場合
		case 12411:
			// 変数 servicePanelにACPanel" QO004137 " ( 介護予防短期入所生活介護 )を生成する。 12411
			return new QO004137();

		// 値が 12511 ( 介護予防短期入所療養介護(老健) ) だった場合
		case 12511:
			// 変数 servicePanelにACPanel" QO004138 " ( 介護予防短期入所療養介護(老健) )を生成する。
			// 12511
			return new QO004138();

		// 値が 12611 ( 介護予防短期入所療養介護(療養病床を有する病院) ) だった場合
		case 12611:
			// 変数 servicePanelにACPanel" QO004139 " ( 介護予防短期入所療養介護(療養病床を有する病院)
			// )を生成する。 12611
			return new QO004139();

		// 値が 12612 ( 介護予防短期入所療養介護(療養病床を有する診療所) ) だった場合
		case 12612:
			// 変数 servicePanelにACPanel" QO004140 " ( 介護予防短期入所療養介護(療養病床を有する診療所)
			// )を生成する。 12612
			return new QO004140();

		// 値が 12613 ( 介護予防短期入所療養介護(老人性認知症疾患療養病棟を有する病院) ) だった場合
		case 12613:
			// 変数 servicePanelにACPanel" QO004141 " (
			// 介護予防短期入所療養介護(老人性認知症疾患療養病棟を有する病院) )を生成する。 12613
			return new QO004141();

		// 値が 12614 ( 介護予防短期入所療養介護(基準適合診療所) ) だった場合
		case 12614:
			// 変数 servicePanelにACPanel" QO004142 " ( 介護予防短期入所療養介護(基準適合診療所)
			// )を生成する。 12614
			return new QO004142();

		// 値が 13511 ( 介護予防特定施設入居者生活介護 ) だった場合
		case 13511:
			// 変数 servicePanelにACPanel" QO004143 " ( 介護予防特定施設入居者生活介護 )を生成する。
			// 13511
			return new QO004143();

		// 値が 16711 ( 介護予防福祉用具貸与 ) だった場合
		case 16711:
			// 変数 servicePanelにACPanel" QO004144 " ( 介護予防福祉用具貸与 )を生成する。 16711
			return new QO004144();

		// 値が 14611 ( 介護予防支援 ) だった場合
		case 14611:
			// 変数 servicePanelにACPanel" QO004145 " ( 介護予防支援 )を生成する。 14611
			return new QO004145();

		// 値が 17411 ( 介護予防認知症対応型通所介護 ) だった場合
		case 17411:
			// 変数 servicePanelにACPanel" QO004146 " ( 介護予防認知症対応型通所介護 )を生成する。
			// 17411
			return new QO004146();

		// 値が 17511 ( 介護予防小規模多機能型居宅介護 ) だった場合
		case 17511:
			// 変数 servicePanelにACPanel" QO004147 " ( 介護予防小規模多機能型居宅介護 )を生成する。
			// 17511
			return new QO004147();

		// 値が 13711 ( 介護予防認知症対応型共同生活介護(短期利用以外) ) だった場合
		case 13711:
			// 変数 servicePanelにACPanel" QO004148 " ( 介護予防認知症対応型共同生活介護(短期利用以外)
			// )を生成する。 13711
			return new QO004148();

		// 値が 13911 ( 介護予防認知症対応型共同生活介護(短期利用) ) だった場合
		case 13911:
			// 変数 servicePanelにACPanel" QO004149 " ( 介護予防認知症対応型共同生活介護(短期利用)
			// )を生成する。 13911
			return new QO004149();

		}
		return null;
	}

	/**
	 * 「サービス詳細情報変更チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean isModifiedOnService() throws Exception {

		// 提供チェックの変更チェック
		boolean oldOffer = ACCastUtilities.toBoolean(VRBindPathParser.get(
				"OFFER", getServiceInfos(getCurrentServiceType())));

		if (getOfferCheck().isSelected()) {
			if (!oldOffer) {
				return true;
			}
			// 提供チェックがONの場合のみパネルの変更チェック
			if (getServiceSnapshot().isModified()) {
				return true;
			}
		} else {
			if (oldOffer) {
				return true;
			}
		}

		// チェック、パネル共に変更がない場合
		return false;

	}

	/**
	 * 「クリア処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void allClear() throws Exception {
		// 画面クリア処理
		// 変数、フラグのクリア
		clearFlags();
		setSelectedProviderId("");
		setPROCESS_MODE(QkanConstants.PROCESS_MODE_INSERT);
		setSTAFF_PROCESS_MODE(QkanConstants.PROCESS_MODE_INSERT);
		setProviderList(new VRArrayList());
		setProviderServiceList(new VRArrayList());
		setProviderStaffList(new VRArrayList());

		// providerContentsにcreateSource処理を行い、戻り値をproviderMapに格納する。
		// 画面にソースとして(providerMap)をセットする。
		VRMap map = (VRMap) getProviderContents().createSource();
		getProviderContents().setSource(map);
		getProviderContents().bindSource();

		// 画面に展開する。
		getProviderContents().bindSource();

		// テーブルのクリア
		// 提供サービステーブル
		doCreateServiceTableData();
		getProviderServiceTableModel().setAdaptee(getProviderServiceList());

		// 一行目(訪問介護)選択
		getServiceKindTable().setSelectedSortedFirstRow();

		// スタッフテーブル
		getProviderStaffTableModel().setAdaptee(getProviderStaffList());

		// 画面状態初期化
		setState_INIT_STATE();

		// フォーカス
		getProviderId().requestFocus();

		// スナップショット（全体）を撮影する。
		getSnapshot().snapshot();
		// スナップショット（サービスパネル用）を撮影する。
		getServiceSnapshot().snapshot();
		// スナップショット（担当者用）を撮影する。
		getStaffSnapshot().snapshot();

	}

	/**
	 * 「サービス領域状態設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void setStateServiceInfos() throws Exception {

		if (getProviderServiceClass() == null) {
			return;
		}

		// offerCheck（提供チェックボックス）の値をチェックする。
		switch (getOfferCheck().getValue()) {
		case 0:
			// 値が false（提供していない）だった場合
			// サービスパネルを編集不可にする。サービスパネルのEnableをfalse に設定する。
			getProviderServiceClass().stateManager(false);
			break;
		case 1:
			// 値がtrue（提供している）だった場合
			// サービスパネルを編集可能にする。サービスパネルのEnableをtrue に設定する。
			getProviderServiceClass().stateManager(true);
			break;
		}
	}

	/**
	 * 「レコード抽出処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @return VRMap
	 */
	public VRMap getFirstRecord(VRList list) throws Exception {
		// 渡されたレコード集合の最初のレコードを抽出し、戻り値として返す処理。

		// 戻り値
		VRMap map = new VRHashMap();

		// 最初のレコード抽出
		if (!(list == null || list.size() == 0)) {
			map = (VRMap) list.get(0);
		}

		// 戻り値を返す
		return map;

	}

	/**
	 * 「サービス詳細情報反映」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean reflect() throws Exception {
		// サービス詳細情報を取得し、テーブルに反映する処理

		// 対象レコードの取得
		VRMap map = getServiceInfos(getCurrentServiceType());

		// 提供チェックボックスの値をチェックする。
		// 0=提供していない
		// 1=提供している
		if (getOfferCheck().getValue() == 0) {
			// サービスを提供していなかった場合
			// 削除可能なサービスか判別する
			if (!doCheckDeleteService()) {
				return false;
			} else {
				// 削除可能だった場合
				// 対象レコードの提供カラムの値をfalseにする。
				VRBindPathParser.set("OFFER", map, new Boolean(false));
			}

		} else {

			// サービスを提供していた場合
			// 入力チェックを行う。
			if (getProviderServiceClass() != null) {
				if (!getProviderServiceClass().isValidInput()) {
					return false;
				}
			}

			// // 初期化
			// map.putAll((VRMap)getProviderDetailServiceDetails().createSource());
			// 画面上のサービス詳細情報を取得する。
			getProviderServiceClass().getDetails(map);

			// 提供サービステーブルで現在選択されているレコードの提供カラムの値をtrueにする。
			VRBindPathParser.set("OFFER", map, new Boolean(true));

		}

		// 再描画
		getServiceKindTable().repaint();
		getServiceKindTable().revalidate();

		// 変更フラグを1に設定する。
		setProviderServiceTableChangeFlag(1);

		// サービスパネル用スナップショットを撮影する。
		getServiceSnapshot().snapshot();

		return true;

	}

	/**
	 * 「フラグの初期化」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void clearFlags() throws Exception {

		// フラグの初期化
		// providerServiceTableChangeFlag
		setProviderServiceTableChangeFlag(0);
		// providerStaffTableChangeFlag
		setProviderStaffTableChangeFlag(0);
		// serviceDataExistenceFlag
		setServiceDataExistenceFlag(0);
		// staffDataExistenceFlag
		setStaffDataExistenceFlag(0);
		// compulsoryBackFlag
		setCompulsoryBackFlag(0);
	}

	/**
	 * 「KEYを指定してサービス情報を取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public VRMap getServiceInfos(int systemServiceKindDetail) throws Exception {

		// システムサービス種類コードを指定してサービス情報を取得する。
		VRMap map = ACBindUtilities.getMatchRowFromValue(
				getProviderServiceList(), "SYSTEM_SERVICE_KIND_DETAIL",
				new Integer(systemServiceKindDetail));

		return map;

	}

	public Component getFirstFocusComponent() {
		if (getPROCESS_MODE() == QkanConstants.PROCESS_MODE_INSERT) {
			return getProviderId();
		} else {
			return getProviderName();
		}
	}
}
