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
 * 作成日: 2006/01/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 保険者管理 (002)
 * プログラム 保険者登録 (QO002)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo002;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Date;
import java.util.Iterator;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.io.ACPropertyXML;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.ACZipRelation;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.bridge.sql.BridgeFirebirdDBManager;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 保険者登録(QO002)
 */
public class QO002 extends QO002Event {

	/**
	 * 編集ボタンが押されたかどうかの判定
	 */
	private boolean insurerLimitRateEditHantei;

	/**
	 * 戻るボタンが押されたかどうか
	 */
	private boolean canBackBtnHantei;

	/**
	 * コンストラクタです。
	 */
	public QO002() {
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
		new ACZipRelation(getInsurerZip1(), getInsurerZip2(),
				getInsurerAddress());
        // [ID:0000520][Masahiko Higuchi] 2009/07 add begin 保険者マスタより保険者番号のエラーチェック機能を追加
        // データベース接続が許可され、保険者マスタが生成できていない場合
        if (QkanSystemInformation.getInstance().isInsurerMasterDatabese()
                && getMasterInsurerDBManager() == null) {

            // マスタデータベースを生成する。
            setMasterInsurerDBManager(new QO002_M_InsurerBridgeFirebirdDBManager());

        }
        // [ID:0000520][Masahiko Higuchi] 2009/07 add end
        
		// 編集ボタン判定の初期化
		insurerLimitRateEditHantei = false;
		
		//戻るボタンの判定の初期化
		canBackBtnHantei=false;

		// 画面展開処理
		// 前画面からの渡りパラメーターを退避する。
		VRMap parameters = affair.getParameters();
		// 
		// データが存在しているかをチェック
		if (VRBindPathParser.has("INSURER_ID", parameters)) {
			// int型に型変換し利用者IDを退避
			setInsurereId(String.valueOf(VRBindPathParser.get("INSURER_ID",
					parameters)));
		}
		if (VRBindPathParser.has("PROCESS_MODE", parameters)) {

			// int型に型変換しプロセスモードを退避
			setPROCESS_MODE(String.valueOf(VRBindPathParser.get("PROCESS_MODE",
					parameters)));
		}
		if (getPROCESS_MODE() == null) {
			setPROCESS_MODE(String.valueOf(QkanConstants.PROCESS_MODE_INSERT));
		}
        
		// this.insurerId = insurerId （保険者番号）
		// ｢保険者情報TABLE（INSURER)｣のパッシブチェックキーを定義する。
		// テーブル：INSURER
		// キー：INSURER_ID
		// フォーマット：文字列
		// クライアントタイムフィールド：LAST_TIME
		// サーバータイムフィールド：LAST_TIME
		setINSURER_INFO_PASSIVE_CHECK_KEY(new ACPassiveKey("INSURER",
				new String[] { "INSURER_ID" }, new boolean[] { true },
				"LAST_TIME", "LAST_TIME"));

		// 業務情報マスタより、データを取得する。
		QkanCommon.getAffairInfo(getDBManager(), "QO002");
		// 取得したデータのウィンドウタイトル（WINDOW_TITLE）をウィンドウに設定する。
		// 取得したデータの業務タイトル（AFFAIR_TITLE）を業務ボタンバーに設定する。
		setAffairTitle("QO002", "0", getButtons());

		// 画面の状態を変更する。
		setState_INSURER_LIMIT_RATE_ENABLE_FALSE();
		// 業務ボタンのキャプションを変更する。
		// PROCESS_MODEが、共通定数の「PROCESS_MODE_INSERT(4)｣だった場合
		if (getPROCESS_MODE().equals(
				Integer.toString(QkanConstants.PROCESS_MODE_INSERT))) {
			// 画面状態を変更する。
			setState_INSERT_STATE();
            // [ID:0000520][Masahiko Higuchi] 2009/07 add begin 保険者マスタより保険者番号のエラーチェック機能を追加
            // 保険者マスタが存在する場合、保険者番号連動イベントを組み込む
            if (getMasterInsurerDBManager() != null
                    && QkanSystemInformation.getInstance()
                            .isInsurerMasterDatabese()) {
                // 解析処理
                setQO002_InsurerRelation(new QO002_InsurerRelation(
                        getMasterInsurerDBManager(), getInsurerId(),
                        getInsurerName(), true, true, true, true));
            }
            // [ID:0000520][Masahiko Higuchi] 2009/07 add end
            
		} else if (getPROCESS_MODE().equals(
				Integer.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
			// PROCESS_MODEが、共通定数の｢PROCESS_MODE_UPDATE(3)｣だった場合
			// 画面状態を変更する。
			setState_UPDATE_STATE();
		}

		// テーブルモデルを下記の画面のテーブルに設定する。
		ACTableModelAdapter model = new ACTableModelAdapter();

		model
				.setColumns(new String[] { "12", "13", "11", "21", "22", "23",
						"24", "25", "LIMIT_RATE_VALID_START",
						"LIMIT_RATE_VALID_END", });

		setInsurerLimitRateTableModel(model);

		// ・保険支給限度額情報テーブル（insurerLimitRateTable)
		// テーブルモデル：insurerLimitRateTableModel
		getInsurerLimitRateTable().setModel(getInsurerLimitRateTableModel());
		// DBよりレコードを取得し、画面に展開する。
		doFind();

		// スナップショットを撮影する
		snapshotCustom();
	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		
		//戻るボタンの判定
		canBackBtnHantei=true;
		
		// 前画面に遷移する処理。
		// 変更をチェックする。※スナップショット
		if (getSnapshot().isModified()) {
			// 変更されていた場合
			// PROCESS_MODEを確認する。
			// PROCESS_MODEが、共通定数の｢PROCESS_MODE_INSERT(4｣)だった場合
			if (getPROCESS_MODE().equals(
					Integer.toString(QkanConstants.PROCESS_MODE_INSERT))) {
				// 登録確認メッセージを表示する。※メッセージID = CAN_BACK_ON_INSERT
				int msgID = QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED();
				switch (msgID) {
				case ACMessageBox.RESULT_OK:
					// ｢登録して戻る｣押下時
					// 保険者全情報入力チェックを行う。
					if (getInsurerLimitRateTableChangeFlg() == 1) {
						if (!doValidCheck()) {
							canBackBtnHantei=false;
							return false;
						}
					} else {
						if (!doValidInsurerInfoCheck()) {
							canBackBtnHantei=false;
							return false;
						}
					}

					// 登録処理を行う。
					if(!doSave()){
						canBackBtnHantei=false;
						return false;
					}

					// 登録完了メッセージを表示する。※メッセージID = INSERT_SUCCESSED
					// QkanMessageList.getInstance().INSERT_SUCCESSED();
					// 渡しパラメーターを作成する。
					parameters
							.setData("QO001.class", this.getClass().getName());
					parameters.setData("INSURER_ID", getInsurereId());

					// 前画面に遷移する。
					return true;
				case ACMessageBox.RESULT_NO:
					// ｢破棄して戻る｣押下時
					// 渡しパラメーターを作成する。
					parameters
							.setData("QO001.class", this.getClass().getName());
					// 更新モードの時、遷移先へパラメータを渡す。
					if (getPROCESS_MODE()
							.equals(
									Integer
											.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
						parameters.setData("INSURER_ID", getInsurereId());
					}

					// 前画面に遷移する。
					return true;
				case ACMessageBox.RESULT_CANCEL:
					canBackBtnHantei=false;
					return false;
					
				}
			} else {
				// PROCESS_MODEが、共通定数の｢PROCESS_MODE_UPDATE(3)｣だった場合
				// 更新確認メッセージを表示する。※メッセージID = WARNING_OF_UPDATE_ON_MODIFIED
				int msgID = QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED();
				switch (msgID) {
				case ACMessageBox.RESULT_OK:

					// ｢更新して戻る｣押下時
					// 保険者全情報入力チェックを行う。
					if (doValidInsurerNameCheck()) {
						// 更新処理を行う。
						if(!doSave()){
							canBackBtnHantei=false;
							return false;
						}
					} else {
						canBackBtnHantei=false;
						return false;
					}

					// 更新完了メッセージを表示する。※メッセージID = UPDATE_SUCCESSED
					// QkanMessageList.getInstance().UPDATE_SUCCESSED();
					// 渡しパラメーターを作成する。
					parameters
							.setData("QO001.class", this.getClass().getName());
					parameters.setData("INSURER_ID", getInsurereId());
					// 前画面に遷移する。
					return true;
					
				case ACMessageBox.RESULT_NO:
					// ｢破棄して戻る｣押下時
					// 渡しパラメーターを作成する。
					parameters
							.setData("QO001.class", this.getClass().getName());
					// 更新モードの時、遷移先へパラメータを渡す。
					if (getPROCESS_MODE()
							.equals(
									Integer
											.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
						parameters.setData("INSURER_ID", getInsurereId());
					}

					// 前画面に遷移する。
					return true;
				case ACMessageBox.RESULT_CANCEL:
					canBackBtnHantei=false;
					return false;
				}
			}
		} else {
			// 変更されていなかった場合
			// insurerLimitRateTableChangeFlgの値をチェックする。
			if (getInsurerLimitRateTableChangeFlg() == 1) {
				// 値が1（変更あり）だった場合
				// 更新確認メッセージを表示する。※メッセージID = WARNING_OF_UPDATE_ON_MODIFIED
				int msgID = QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED();
				switch (msgID) {
				case ACMessageBox.RESULT_OK:

					// ｢更新して戻る｣押下時
					// 保険者基本情報の入力チェックを行う。※基本情報がないため更新できない
					if (doValidInsurerInfoCheck()) {
						// 更新処理を行う。
						if(!doSave()){
							canBackBtnHantei=false;
							return false;
						}
					} else {
						canBackBtnHantei=false;
						return false;
					}
				case ACMessageBox.RESULT_NO:
					// ｢破棄して戻る｣押下時
					// 渡しパラメーターを作成する。
					parameters
							.setData("QO001.class", this.getClass().getName());
					// 更新モードの時、遷移先へパラメータを渡す。
					if (getPROCESS_MODE()
							.equals(
									Integer
											.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
						parameters.setData("INSURER_ID", getInsurereId());
					}

					// 前画面に遷移する。
					return true;
				case ACMessageBox.RESULT_CANCEL:
					canBackBtnHantei=false;
					return false;
				}
			} else {
				// 渡しパラメーターを作成する。
				parameters.setData("QO001.class", this.getClass().getName());
				// 更新モードの時、遷移先へパラメータを渡す。
				if (getPROCESS_MODE().equals(
						Integer.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
					parameters.setData("INSURER_ID", getInsurereId());
				}

				// 前画面に遷移する。
				return true;
			}
		}
		// TODO 前画面への遷移を許可するならばtrueを返す。
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
	 * 「区分支給限度額情報パネルを制御する」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insurerLimitRateEnableCheckActionPerformed(ActionEvent e)
			throws Exception {
		// 区分支給限度額情報パネルを制御する処理
		// insurerLimitRateEnableCheck の値をチェックする。

		// 値が1（チェックあり）だった場合
		if (getInsurerLimitRateEnableCheck().isSelected() == true) {
			// 画面の状態を変更する。
			setState_INSURER_LIMIT_RATE_ENABLE_TRUE();
			// テーブルに情報が空の時
			if (getInsurerLimitRateTable().getRowCount() == 0) {
				setState_NOT_POSSIBLE_FIND_AND_DELETE_LIMIT_RATE();
			}

			// フォーカス設定
			getValidPeriodStart().requestFocus();

		} else {
			// 値が0（チェックなし）だった場合
			// 画面の状態を変更する。
			setState_INSURER_LIMIT_RATE_ENABLE_FALSE();

			// フォーカス設定
			if (getPROCESS_MODE().equals(
					String.valueOf(QkanConstants.PROCESS_MODE_INSERT))) {
				getInsurerId().requestFocus();
			} else {
				getInsurerName().requestFocus();
			}
		}
	}

	/**
	 * 「対象レコードを表示」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insurerLimitRateTableSelectionChanged(ListSelectionEvent e)
			throws Exception {
		// テーブル内が選択されていないとき
		if (!getInsurerLimitRateTable().isSelected()) {
			// 編集・削除ボタンを押下付加にする
			setState_NOT_POSSIBLE_FIND_AND_DELETE_LIMIT_RATE();
		}

		// 選択レコードの支給限度額情報を表示する。
		// 選択されているレコードを｢支給限度額情報領域左｢validPeriodLeft｣のソースとして設定する。
		// setSource(insurerLimitRateTable, 選択レコード);
		if (getInsurerLimitRateTable().getSelectedRow() != -1) {
			getValidPeriodPanel().setSource(
					(VRMap) getInsurerLimitRateTable()
							.getSelectedModelRowValue());
			// 画面に展開する。
			// bindSource(insurerLimitRatePanel);
			getValidPeriodPanel().bindSource();

			// 編集・削除ボタンを押下可能にする
			setState_POSSIBLE_FIND_AND_DELETE_LIMIT_RATE();

			// スナップショット
			getSnapShotPeriod().snapshot();
		}
	}

	/**
	 * 「追加処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insurerLimitRateInsertButtonActionPerformed(ActionEvent e)
			throws Exception {
		// 入力された支給限度額をテーブルに追加する処理
		// 入力チェックを行う。
		if (doValidLimitRateCheck()) {
			setInsurereId(getInsurerId().getText());

			// 空のHashMapを生成し、｢保険者支給限度額情報領域( insurerLimitRateInfo)｣にソースとして設定する。
			// setSource( insurerLimitRateInfo);
			VRMap insurerLimitInfoMap = new VRHashMap();
			// insurerLimitInfoMap = null;
			getValidPeriodPanel().setSource(insurerLimitInfoMap);

			// 入力されたデータをソースに流し込み、データを取得する。
			// applySource( insurerLimitRateInfo);
			getValidPeriodPanel().applySource();
			insurerLimitInfoMap.setData("LIMIT_RATE_HISTORY_ID", Integer
					.toString(getInsurerLimitRateTable().getRowCount() + 1));
			insurerLimitInfoMap.setData("INSURER_ID", getInsurereId());

			// テーブルのソートを有効にするため、
			// 指定キーのデータ型をStringからIntegerに変換する。
			final String[] Keys = new String[] { "11", "12", "13", "21", "22",
					"23", "24", "25" };
			QkanCommon.convertValueFromStringToInteger(insurerLimitInfoMap,
					Keys);

			getInsurerLimitRateList().add(insurerLimitInfoMap);
			// getInsurerLimitRateTableModel().setAdaptee(
			// getInsurerLimitRateList());

			// insurerLimitRateList内のレコードに下記のKEY/VALUEを設定する。
			// KEY：LIMIT_RATE_HISTORY_ID VALUE：リスト内のインデックス
			// getInsurerLimitRateList().setData("LIMIT_RATE_HISTORY_ID",getInsurerLimitRateList().getData());
			getInsurerLimitRateTable().setSelectedSortedLastRow();
			// insurerLimitRateTableChangeFlgに1（変更あり）を代入する。
			setInsurerLimitRateTableChangeFlg(1);
			// 画面状態を変更する。（削除、編集ボタンをEnable制御し、押下可能にする）
			setState_POSSIBLE_FIND_AND_DELETE_LIMIT_RATE();
		}
	}

	/**
	 * 「編集処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insurerLimitRateEditButtonActionPerformed(ActionEvent e)
			throws Exception {
		// テーブルが選択されているとき
		if (getInsurerLimitRateTable().isSelected()) {
			// 選択レコードを入力された支給限度額で更新する処理。
			// 入力チェックを行う。
			insurerLimitRateEditHantei = true;
			if (doValidLimitRateCheck()) {

				// 入力されたデータを取得する。
				// applySource( insurerLimitRateInfo);
				VRMap insurerLimitInfoMap = new VRHashMap();
				getValidPeriodPanel().setSource(insurerLimitInfoMap);
				getValidPeriodPanel().applySource();

				// テーブルを再描写する。
				insurerLimitInfoMap.setData("INSURER_ID", getInsurereId());

				getInsurerLimitRateList().setData(
						getInsurerLimitRateTable().getSelectedModelRow(),
						insurerLimitInfoMap);

				// テーブルのソートを有効にするため、
				// 指定キーのデータ型をStringからIntegerに変換する。
				final String[] Keys = new String[] { "11", "12", "13", "21",
						"22", "23", "24", "25" };
				QkanCommon.convertValueFromStringToInteger(insurerLimitInfoMap,
						Keys);

				getInsurerLimitRateTable().revalidate();
				getInsurerLimitRateTable().repaint();

				// insurerLimitRateTableChangeFlgに1（変更あり）を代入する。
				setInsurerLimitRateTableChangeFlg(1);

				// スナップショットの撮影
				getSnapShotPeriod().snapshot();

			}
		}
	}

	/**
	 * 「削除処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insurerLimitRateDeleteButtonActionPerformed(ActionEvent e)
			throws Exception {

		// テーブルが選択されているか
		if (getInsurerLimitRateTable().isSelected()) {
			// 選択レコードを削除する処理
			// 削除確認メッセージを表示する。※メッセージID = WARNING_OF_DELETE_SELECTION
			int msgID = QkanMessageList.getInstance()
					.WARNING_OF_DELETE_SELECTION();
			// ｢はい｣選択時
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// 選択されたレコードをinsurerLimitRateListから削除する。
				int index = getInsurerLimitRateTable().getSelectedRow();

				getInsurerLimitRateList().remove(
						getInsurerLimitRateTable().getSelectedModelRowValue());
				getInsurerLimitRateTableModel().setAdaptee(
						getInsurerLimitRateList());
				// insurerLimitRateTableChangeFlgに1（変更あり）を代入する。
				setInsurerLimitRateTableChangeFlg(1);
				// レコードの件数が0件になった場合
				if (getInsurerLimitRateTable().getRowCount() == 0) {
					// 画面状態を変更する。（削除、編集ボタンをEnable制御し、押下不可にする）
					setState_NOT_POSSIBLE_FIND_AND_DELETE_LIMIT_RATE();
				} else {
					getInsurerLimitRateTable()
							.setSelectedSortedRowOnAfterDelete(index);
				}

			case ACMessageBox.RESULT_CANCEL:
				// ｢キャンセル｣選択時
				// 処理を抜ける。（処理を行わない）
				return;
			}
		}
	}

	/**
	 * 「基準支給限度額を表示する処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insurerLimitRateRegularButtonActionPerformed(ActionEvent e)
			throws Exception {
		// 内部変数 regularLimitRateList を生成する。
		VRMap regularLimitRateMap = new VRHashMap();

		// 基準支給限度額を表示する処理
		//  
		// 値が1（変更あり）だった場合
		if (getInsurerLimitRateTableChangeFlg() == 1) {
			// 確認メッセージを表示する。 ※メッセージID = QO002_WARNING_OF_LIMIT_RATE_REGULAR
			int msgID = QkanMessageList.getInstance()
					.QO002_WARNING_OF_LIMIT_RATE_REGULAR();
			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// 「OK」だった場合
				// 保険者支給限度額情報パネル(insurerLimitRateInfo)のソースとして
				// regularLimitRateMap を設定する。
				getValidPeriodPanel().setSource(regularLimitRateMap);
				// 保険者支給限度額情報パネルにcreateSourceを行う。
				getValidPeriodPanel().createSource();
				// 画面をクリアする。
				getValidPeriodPanel().bindSource();
				// 基準支給限度額情報を取得する。
				regularLimitRateMap.putAll(doFindRegularLImitRate());

				// 取得した情報をregularLimitRateMapに格納する。
				// 保険者支給限度額情報パネル(insurerLimitRateInfo)のソースとして
				// regularLimitRateMap を設定する。
				getValidPeriodPanel().setSource(regularLimitRateMap);
				// 保険者支給限度額情報パネル(insurerLimitRateInfo)に情報を展開する。
				getValidPeriodPanel().bindSource();
			}
		} else {
			// 保険者支給限度額情報パネル(insurerLimitRateInfo)のソースとして regularLimitRateMap
			// を設定する。
			getValidPeriodPanel().setSource(regularLimitRateMap);
			// 保険者支給限度額情報パネルにcreateSourceを行う。
			getValidPeriodPanel().createSource();
			// 画面をクリアする。
			getValidPeriodPanel().bindSource();
			// 基準支給限度額情報を取得する。
			regularLimitRateMap.putAll(doFindRegularLImitRate());

			// 取得した情報をregularLimitRateMapに格納する。
			// 保険者支給限度額情報パネル(insurerLimitRateInfo)のソースとして regularLimitRateMap
			// を設定する。
			getValidPeriodPanel().setSource(regularLimitRateMap);
			// 保険者支給限度額情報パネル(insurerLimitRateInfo)に情報を展開する。
			getValidPeriodPanel().bindSource();
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
		// 保険者情報を登録する処理
		// 変更チェックを行う。※スナップショット
		// 変更チェック(破棄する可能性のある情報)
		if (getSnapShotPeriod().isModified()) {
			// メッセージ表示
			String msgParam = "支給限度額履歴情報";
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

		if (getSnapshot().isModified()) {
			// 変更があった場合
			// 保険者情報の入力チェックを行う。
			if (doValidInsurerInfoCheck()) {

				// 登録処理を行う。
				if (doSave()) {

					// PROCESS_MODEを、共通定数｢PROCESS_MODE_UPDATE(3)｣に変更する。
					setPROCESS_MODE(Integer
							.toString(QkanConstants.PROCESS_MODE_UPDATE));
					// insurerLimitRateChangeFlgの値に0（変更なし）を代入する。
					setInsurerLimitRateTableChangeFlg(0);
					// 登録完了メッセージを表示する。※メッセージID = INSERT_SUCCESSED
					QkanMessageList.getInstance().INSERT_SUCCESSED();
					// 画面状態を変更する。
					setState_UPDATE_STATE();
					// DBよりレコードを取得し、画面に展開する。
					doFind();
					// スナップショットを撮影する。
					snapshotCustom();
				}
			}

		} else {
			// 変更がなかった場合
			// insurerLimitRateChangeFlgの値をチェックする。
			// 値が1（変更あり）だった場合
			if (getInsurerLimitRateTableChangeFlg() == 1) {
				// 保険者情報の入力チェックを行う。
				if (doValidInsurerInfoCheck()) {
					// 登録処理を行う。
					if (doSave()) {

						// PROCESS_MODEをPROCESS_MODE_UPDATEに変更する。
						setPROCESS_MODE(Integer
								.toString(QkanConstants.PROCESS_MODE_UPDATE));
						// insurerLimitRateChangeFlgの値に0（変更なし）を代入する。
						setInsurerLimitRateTableChangeFlg(0);
						// 登録完了メッセージを表示する。※メッセージID = INSERT_SUCCESSED
						QkanMessageList.getInstance().INSERT_SUCCESSED();
						// 画面状態を変更する。
						setState_UPDATE_STATE();
						// DBよりレコードを取得し、画面に展開する。
						doFind();
						// スナップショットを撮影する。
						snapshotCustom();
					}
				}
			} else {
				// 保険者情報の入力チェックを行う。
				if (doValidInsurerInfoCheck()) {
					// 登録処理を行う。
					if (doSave()) {

						// PROCESS_MODEをPROCESS_MODE_UPDATEに変更する。
						setPROCESS_MODE(Integer
								.toString(QkanConstants.PROCESS_MODE_UPDATE));
						// insurerLimitRateChangeFlgの値に0（変更なし）を代入する。
						setInsurerLimitRateTableChangeFlg(0);
						// 登録完了メッセージを表示する。※メッセージID = INSERT_SUCCESSED
						QkanMessageList.getInstance().INSERT_SUCCESSED();
						// 画面状態を変更する。
						setState_UPDATE_STATE();
						// DBよりレコードを取得し、画面に展開する。
						doFind();
						// スナップショットを撮影する。
						snapshotCustom();
					}
				}
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
		// 保険者情報を更新する処理
		// 変更チェックを行う。※スナップショット
		if (getSnapShotPeriod().isModified()) {
			// メッセージ表示
			String msgParam = "支給限度額履歴情報";
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

		if (getSnapshot().isModified()) {
			// 変更があった場合
			if (doValidInsurerNameCheck()) {
				// 更新処理を行う。
				if (doSave()) {
					// insurerLimitRateChangeFlgの値に0（変更なし）を代入する。
					setInsurerLimitRateTableChangeFlg(0);
					// 更新完了メッセージを表示する。※メッセージID = UPDATE_SUCCESSED
					QkanMessageList.getInstance().UPDATE_SUCCESSED();
					// DBよりレコードを取得し、画面に展開する。
					doFind();
					// スナップショットを撮影する。
					snapshotCustom();
				}
			}
		} else {
			// 変更がなかった場合
			// insurerLimitRateChangeFlgの値をチェックする。
			// 値が1（変更あり）だった場合
			if (getInsurerLimitRateTableChangeFlg() == 1) {
				// 保険者情報の入力チェックを行う。
				if (doValidInsurerNameCheck()) {
					// 更新処理を行う。
					if (doSave()) {
						// insurerLimitRateChangeFlgの値に0（変更なし）を代入する。
						setInsurerLimitRateTableChangeFlg(0);
						// 更新完了メッセージを表示する。※メッセージID = UPDATE_SUCCESSED
						QkanMessageList.getInstance().UPDATE_SUCCESSED();
						// DBよりレコードを取得し、画面に展開する。
						doFind();
						// スナップショットを撮影する。
						snapshotCustom();
					}
				}
			} else {
				if (doValidInsurerNameCheck()) {
					// 更新処理を行う。
					if (doSave()) {
						// insurerLimitRateChangeFlgの値に0（変更なし）を代入する。
						setInsurerLimitRateTableChangeFlg(0);
						// 更新完了メッセージを表示する。※メッセージID = UPDATE_SUCCESSED
						QkanMessageList.getInstance().UPDATE_SUCCESSED();
						// DBよりレコードを取得し、画面に展開する。
						doFind();
						// スナップショットを撮影する。
						snapshotCustom();
					}
				}
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
				getInsurerId().requestFocus();
				// スナップショットを撮影する。
				snapshotCustom();
			}
		} else {
			// 変更がなかった場合
			// insurerLimitRateTableChangeFlgの値をチェックする。
			// 値が1（変更あり）だった場合
			if (getInsurerLimitRateTableChangeFlg() == 1) {
				// 新規登録モード遷移確認メッセージを表示する。
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
					getInsurerId().requestFocus();
					// スナップショットを撮影する。
					snapshotCustom();
				}
			} else {
				// 新規登録モードに変更する
				insertModeChange();
				// 画面の状態を変更する。
				setState_INIT_STATE();
				// 保険者番号にフォーカス
				getInsurerId().requestFocus();
				// スナップショットを撮影する。
				snapshotCustom();
			}
		}
        
        // [ID:0000520][Masahiko Higuchi] 2009/07 add begin 保険者マスタより保険者番号のエラーチェック機能を追加
        if (getMasterInsurerDBManager() != null
                && QkanSystemInformation.getInstance()
                        .isInsurerMasterDatabese()) {
            setState_VALID_INSURER_SELECT();
        } else {
            setState_INVALID_INSURER_SELECT();
        }
        // [ID:0000520][Masahiko Higuchi] 2009/07 add end
        
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
			// 変更がなかった場合
			// insurerLimitRateTableChangeFlgの値をチェックする。
			// 値が1（変更あり）だった場合
			if (getInsurerLimitRateTableChangeFlg() == 1) {
				// 確認メッセージを表示する ※メッセージID = WARNING_OF_CLEAR_ON_MODIFIED
				int msgID = QkanMessageList.getInstance()
						.WARNING_OF_CLEAR_ON_MODIFIED();
				switch (msgID) {
				case ACMessageBox.RESULT_OK:
					// 「OK」だった場合
					// クリア処理を行う。
					allClear();
				}
			} else {
				allClear();
			}
		}

	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		param.setData("INSURER_ID", "000001");
		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QO002.class.getName(), param));
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
		// 選択保険者の情報を取得する。
		// 保険者情報TABLEに存在する、保険者情報を取得する。
		doFindInsurerInfo();

		// 取得した保険者情報（insurerInfoMap）を｢保険者情報入力領域（insurerInfos)｣に設定する。
		getInsurerInfos().setSource(getInsurerInfoMap());
		// 画面に展開する。
		getInsurerInfos().bindSource();
		// 支給限度額情報を取得する。
		doFindInsurerLimitRate();

		// 支給限度額情報テーブルに取得レコードを表示する。
		getInsurerLimitRateTableModel().setAdaptee(getInsurerLimitRateList());

		// レコードが1件以上あった場合
		if (getInsurerLimitRateList().size() > 0) {
			// 画面の状態を変更する。
			setState_INSURER_LIMIT_RATE_ENABLE_TRUE();
			// レコードの1件目を選択状態にする。※セル選択イベント
			getInsurerLimitRateTable().setSelectedSortedFirstRow();
		} else {

		}

		// フォーカス処理
		if (getPROCESS_MODE().equals(
				String.valueOf(QkanConstants.PROCESS_MODE_INSERT))) {
			getInsurerId().requestFocus();
		} else {
			getInsurerName().requestFocus();
		}
	}

	/**
	 * 「保険者情報取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindInsurerInfo() throws Exception {
		// 保険者情報を取得する。
		// 保険者情報取得用SQL文を取得するためにVRMap：paramを作成し、以下のKEY/VALUEで設定する。
		VRMap param = new VRHashMap();

		// KEY：INSURER_ID VALUE：insurerId

		if (getInsurereId() != null) {
			param.setData("INSURER_ID", getInsurereId());

			// 保険者情報を取得するためのSQL文を取得する。
			// getSQL_GET_INSURER_INFO(param);
			// 取得したSQL文を実行する。
			setInsurerInfoList(getDBManager().executeQuery(
					getSQL_GET_INSURER_INFO(param)));
		}

		// レコードが取得できた場合
		if (getInsurerInfoList().size() > 0) {
			setPROCESS_MODE(String.valueOf(QkanConstants.PROCESS_MODE_UPDATE));

			// 取得したレコードをinsurerInfoMapに格納する。
			setInsurerInfoMap((VRMap) getInsurerInfoList().getData());
			// // insurerInfoListに取得したinsurerInfoMapを格納する。
			// setInsurerInfoList((VRList) getInsurerInfoMap().getData());
			// 保険者情報TABLEパッシブチェック用にデータを登録する。
			getPassiveChecker().reservedPassive(
					getINSURER_INFO_PASSIVE_CHECK_KEY(), getInsurerInfoList());
			// 画面状態を変更する。
			setState_UPDATE_STATE();
            
            // [ID:0000520][Masahiko Higuchi] 2009/07 add begin 保険者マスタより保険者番号のエラーチェック機能を追加
            if(getQO002_InsurerRelation() != null) {
                getQO002_InsurerRelation().deleteInsurerNameListener();
                getQO002_InsurerRelation().deleteInsurerNoListener();
            }
            // [ID:0000520][Masahiko Higuchi] 2009/07 add end
            
		} else {
			// レコードが取得できなかった場合
			// PROCESS_MODEのチェックを行う。
			// if (getPROCESS_MODE() == Integer
			// .toString(QkanConstants.PROCESS_MODE_INSERT)) {
			// // PROCESS_MODEが、共通定数の｢PROCESS_MODE_INSERT(4)｣だった場合
			// // insurerInfoMapのソースを生成する。（新規登録時クリア処理に用いる）
			// // createSource();
			// setInsurerInfoMap((VRMap) getContents().createSource());
			// getContents().setSource(getInsurerInfoMap());
			// getContents().bindSource();
			//
			// // 画面状態を変更する。
			// setState_INSERT_STATE();
			setPROCESS_MODE(String.valueOf(QkanConstants.PROCESS_MODE_INSERT));

			// if(getPROCESS_MODE() == Integer
			// .toString(QkanConstants.PROCESS_MODE_UPDATE)) {
			// // PROCESS_MODEが、共通定数の｢PROCESS_MODE_UPDATE(3)｣だった場合
			// // エラーメッセージを表示する。 ※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
			// QkanMessageList.getInstance()
			// .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
			// // 保険者一覧｢QO001｣画面に遷移する。
			// ACFrame.getInstance().back();
			// }else{
			// PROCESS_MODEが、共通定数の｢PROCESS_MODE_INSERT(4)｣だった場合
			// insurerInfoMapのソースを生成する。（新規登録時クリア処理に用いる）
			// createSource();
			setInsurerInfoMap((VRMap) getContents().createSource());
			// [ID:0000461][Masahiko Higuchi] 2009/03 add begin 保険者登録時の初期値
            getInsurerInfoMap().setData("INSURER_TYPE",new Integer(1));
            // [ID:0000461][Masahiko Higuchi] 2009/03 add end
			getContents().setSource(getInsurerInfoMap());
			getContents().bindSource();
			// 画面状態を変更する。
			setState_INSERT_STATE();
			// }
            // [ID:0000520][Masahiko Higuchi] 2009/07 add begin 保険者マスタより保険者番号のエラーチェック機能を追加 
            // 保険者マスタとの接続が出来ているならば
            if (getMasterInsurerDBManager() != null
                    && QkanSystemInformation.getInstance()
                            .isInsurerMasterDatabese()) {
                setState_VALID_INSURER_SELECT();
            } else {
                setState_INVALID_INSURER_SELECT();
            }
            // [ID:0000520][Masahiko Higuchi] 2009/07 add end
		}
	}

	/**
	 * 「支給限度額情報取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindInsurerLimitRate() throws Exception {
		// 支給限度額情報を取得する。
		// 支給限度額情報取得のためHashMap：paramを作成し以下のKEY/VALUEを設定する。
		VRMap param = new VRHashMap();
		// KEY：INSURER_ID VALUE：insurerId
		if (getInsurereId() != null) {
			param.setData("INSURER_ID", getInsurereId());
			// 支給限度額情報を取得するためのSQL文を取得する。
			// getSQL_GET_INSURER_LIMIT_RATE(param);
			// 取得したSQL文を実行する。
			setInsurerLimitRateList(getDBManager().executeQuery(
					getSQL_GET_INSURER_LIMIT_RATE(param)));

		}

		if (getInsurerLimitRateList().size() > 0) {
			// レコードが取得できた場合
			// 取得したレコードをinsurerLimitRateListSourceに設定する。
			setInsurerLimitRateListSource(getInsurerLimitRateList());
			// 並列に持っている支給限度額情報を保険者ID、支給限度額履歴をKEYにして1レコード（直列）にしinsurerLimitRateListに格納する。※共通関数：getSeriesedKeyList使用
			VRMap map = new VRHashMap();

			Iterator it = getInsurerLimitRateList().iterator();

			VRList list = new VRArrayList();
			int limitRateHistoryOldId = 1;

			while (it.hasNext()) {
				VRMap row = (VRMap) it.next();
				// JOTAI_CODEをキー、LIMIT_RATE_VALUEを値として追加

				if (ACCastUtilities.toInt(VRBindPathParser.get(
						"LIMIT_RATE_HISTORY_ID", row)) == limitRateHistoryOldId) {
					map.put("LIMIT_RATE_HISTORY_ID", VRBindPathParser.get(
							"LIMIT_RATE_HISTORY_ID", row));
					map.put("INSURER_ID", getInsurereId());
					map.put(String.valueOf(VRBindPathParser.get("JOTAI_CODE",
							row)), VRBindPathParser
							.get("LIMIT_RATE_VALUE", row));
					map.put("LIMIT_RATE_VALID_START", VRBindPathParser.get(
							"LIMIT_RATE_VALID_START", row));
					map.put("LIMIT_RATE_VALID_END", VRBindPathParser.get(
							"LIMIT_RATE_VALID_END", row));
				} else {

					list.add(map);
					map = new VRHashMap();
					map.put(String.valueOf(VRBindPathParser.get("JOTAI_CODE",
							row)), VRBindPathParser
							.get("LIMIT_RATE_VALUE", row));
				}

				limitRateHistoryOldId = ACCastUtilities.toInt(VRBindPathParser
						.get("LIMIT_RATE_HISTORY_ID", row));
			}

			list.add(map);
			setInsurerLimitRateList(list);

			// setInsurerLimitRateList(ACBindUtilities.getSeriesedKeyListWithoutGroupField(getInsurerLimitRateListSource(),str1,str2,str3,str4,ob));
			// 画面状態を変更する。
			setState_INSURER_LIMIT_RATE_ENABLE_TRUE();
			// 支給限度額変更チェック（insurerLimitRateEnableCheck）をチェック状態にする。
			getInsurerLimitRateEnableCheck().setSelected(true);
		} else {
			// レコードが取得できなかった場合
			// 厚生労働省規定の支給限度額を取得しinsurerLimitRateListSourceに格納する。
			VRMap regularLimitRateMap = new VRHashMap();
			regularLimitRateMap = (VRMap) doFindRegularLImitRate();
			getValidPeriodPanel().createSource();
			getValidPeriodPanel().setSource(regularLimitRateMap);
			getValidPeriodPanel().bindSource();

			// 画面状態を変更する。
			setState_INSURER_LIMIT_RATE_ENABLE_FALSE();
		}

	}

	/**
	 * 「保存処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doSave() throws Exception {
		setInsurereId(getInsurerId().getText());
        
		// 入力モードがINSERTの時
		if (getPROCESS_MODE().equals(
				Integer.toString(QkanConstants.PROCESS_MODE_INSERT))) {

			// 一時退避map
			VRMap map = new VRHashMap();
			map.setData("INSURER_ID", getInsurerId().getText());

			// 一時退避list
			VRList list = null;

			list = getDBManager().executeQuery(
					getSQL_GET_INSURER_INFO_DELETE_FLAG(map));
			// 削除済みにデータがあるかどうかのチェックをする
			if (list.size() > 0) {
				int msgID = QkanMessageList.getInstance()
						.WARNING_OF_RESTORATION_OF_DELETE_DATA("保険者番号", "保険者");

				switch (msgID) {
				case ACMessageBox.RESULT_OK:

//					setInsurereId(getInsurerId().getText());
					doFind();
					return false;

				case ACMessageBox.RESULT_CANCEL:
					// VRMap param = new VRHashMap();
					// param.setData(getInsurereId());

					// ※遷移処理
					// ACAffairInfo affair = null;
					// affair = new ACAffairInfo(QO001.class.getName(), param);
					// 次画面に遷移する。
					// ACFrame.getInstance().next(affair);
					return false;
				}
			}

			list = getDBManager().executeQuery(getSQL_GET_INSURER_INFO(map));
			// 既に登録済みかチェックする。
			if (list.size() > 0) {
				// 登録済みの時、メッセージを表示する。
				QkanMessageList.getInstance().QO002_ERROR_OF_OVERLAP("保険番号");

				// フォーカスを保険者番号テキストにあわせる。
				getInsurerId().requestFocus();

				// falseを返す。
				return false;
			}
			// 登録済みでないとき処理を抜ける。
            // [ID:0000520][Masahiko Higuchi] 2009/07 add begin 保険者マスタより保険者番号のエラーチェック機能を追加
            // 保険者マスタが取得できた場合
            if ((getMasterInsurerDBManager() != null && QkanSystemInformation
                    .getInstance().isInsurerMasterDatabese())
                    && !getQO002_InsurerRelation().isValidInsurer()) {
                int msgID = QkanMessageList.getInstance().QO002_WARNING_OF_INSURER();
                // メッセージID
                switch(msgID) {
                case ACMessageBox.RESULT_OK:
                    // 処理続行
                    break;
                case ACMessageBox.RESULT_CANCEL:
                    return false;
                }
            }
            // [ID:0000520][Masahiko Higuchi] 2009/07 add end
            
		}

		// 保険者の情報をDBに登録する。
		try {
			// トランザクションを開始する。
			getDBManager().beginTransaction();

			// パッシブタスクをクリアする。
			getPassiveChecker().clearPassiveTask();

			// 画面上の情報を取得しinsurerInfoMapに格納する
			getInsurerInfos().setSource(getInsurerInfoMap());
			getInsurerInfos().applySource();

			getInsurerInfoList().clearData();
			getInsurerInfoList().addData(getInsurerInfoMap());

			// PROCESS_MODEの値をチェックする。
			// PROCESS_MODEが、共通定数の｢PROCESS_MODE_INSERT(4)｣だった場合
			if (getPROCESS_MODE().equals(
					String.valueOf(QkanConstants.PROCESS_MODE_INSERT))) {

				setInsurereId(getInsurerId().getText());

				// パッシブタスクを登録する。（INSERT） ※保険者情報登録用
				getPassiveChecker().addPassiveInsertTask(
						getINSURER_INFO_PASSIVE_CHECK_KEY(),
						getInsurerInfoList());

			} else if (getPROCESS_MODE().equals(
					Integer.toString(QkanConstants.PROCESS_MODE_UPDATE))) {
				// PROCESS_MODEが、共通定数の｢PROCESS_MODE_UPDATE(3)｣だった場合
				// パッシブタスクを登録する。（UPDATE） ※保険者情報更新用
				getPassiveChecker().addPassiveUpdateTask(
						getINSURER_INFO_PASSIVE_CHECK_KEY());
			}
			// パッシブチェックを行う
			// パッシブエラーが発生した場合
			if (!getPassiveChecker().passiveCheck(getDBManager())) {
				// エラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
				QkanMessageList.getInstance()
						.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
				// 処理を抜ける。（処理を中断する）
				getDBManager().rollbackTransaction();
				return false;
			} else {
				// パッシブエラーが発生しなかった場合
				// PROCESS_MODEのチェックをする。
				// PROCESS_MODEが、共通定数の｢PROCESS_MODE_INSERT(4)｣だった場合
				if (getPROCESS_MODE().equals(
						Integer.toString(QkanConstants.PROCESS_MODE_INSERT))) {
					// 画面上の情報を取得しinsurerInfoMapに格納する。
					// getInsurerInfos().setSource(getInsurerInfoMap());
					// getInsurerInfos().applySource();

					// 保険者情報登録のためのSQL文を取得する。
					// 保険者情報登録用のSQL文を取得する。
					// getSQL_INSERT_INSURER_INFO(getInsurerInfoMap());
					// 取得したSQL文を実行する。
					getDBManager().executeUpdate(
							getSQL_INSERT_INSURER_INFO(getInsurerInfoMap()));

					// SQL実行時にエラーが発生しなかった場合
					// insurerLimitRateEnableCheck の値をチェックする。
					// 値が1（チェックあり）だった場合
					// if (getInsurerLimitRateEnableCheck().getValue() == 1) {
					// 入力チェックを行う
					// if(doValidLimitRateCheck()){
					// 入力エラーがなかった場合
					// 支給限度額情報を登録する
					doSaveLimitRate();

					// 入力エラーがあった場合
					// }else{
					// 処理を中断する。
					// return false;
					// }
					// PROCESS_MODEが、共通定数の｢PROCESS_MODE_UPDATE(3)｣だった場合
					// }
				} else {
					// 画面上の情報を取得しinsurerInfoMaoに格納する。
					// getInsurerInfos().setSource(getInsurerInfoMap());
					// getInsurerInfos().applySource();
					// 保険者情報更新のためのSQL文を取得する。
					// 保険者情報更新用のSQL文を取得する。
					// getSQL_UPDATE_INSURER_INFO(getInsurerInfoMap());
					// 取得したSQL文を実行する。
					getDBManager().executeUpdate(
							getSQL_UPDATE_INSURER_INFO(getInsurerInfoMap()));

					// SQL実行時にエラーが発生しなかった場合
					// insurerLimitRateEnableCheck の値をチェックする。
					// 値が1（チェックあり）だった場合
					// 入力チェックを行う
					// if (getInsurerLimitRateEnableCheck().getValue() == 1) {
					// if(doValidLimitRateCheck()){

					// 入力エラーがなかった場合
					// 支給限度額情報を登録する
					doSaveLimitRate();

					// 入力エラーがあった場合
					// }else{
					// 処理を中断する。
					// return false;
					// }

					// }
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
		// スナップショットを撮影する。
		snapshotCustom();

		return true;
	}

	/**
	 * 「支給限度額情報登録処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doSaveLimitRate() throws Exception {
		// 支給限度額情報を更新する（更新モード）
		// 支給限度額情報削除用のSQL文を取得するためVRMap：paramを作成し、下記のKEY/VALUEを設定する。
		VRMap param = new VRHashMap();
		// KEY：INSURER_ID VALUE：insurerId
		param.setData("INSURER_ID", getInsurereId());
		// 支給限度額情報削除用のSQL文を取得する。
		// getSQL_DELETE_INSURER_LIMIT_RATE(param);
		// 取得したSQL文を実行する。

		getDBManager().executeUpdate(getSQL_DELETE_INSURER_LIMIT_RATE(param));
		// SQL文実行時にエラーが発生した場合
		// 処理を抜ける。（処理を中断する）
		// SQL文実行時にエラーが発生しなかった場合
		// 支給限度額情報を削除する。※まだコミットは行わない。
		// 支給限度額詳細情報削除用のSQL文を取得する。
		// getSQL_DELETE_INSURER_LIMIT_RATE_DETAIL(param);
		// 取得したSQL文を実行する。
		getDBManager().executeUpdate(
				getSQL_DELETE_INSURER_LIMIT_RATE_DETAIL(param));
		// SQL文実行時にエラーが発生した場合
		// 処理を抜ける。（処理を中断する）
		// SQL文実行時にエラーが発生しなかった場合
		// 支給限度額詳細情報を削除する。※まだコミットは行わない。
		// insurerLimitRateListのレコードを支給限度額情報TABLEに登録する。
		// insurerLimitRateList内のレコード数だけ以下の処理を行う。
		// insurerLimitRateList内からレコードを取得しinsurerLimitRateMapに格納する。
		// 支給限度額情報登録用のSQL文を取得する。
		// getSQL_INSURT_INSURER_LIMIT_RATE(getInsurerLimitRateMap());
		// 取得したSQL文を実行する。
		// SQL文実行時にエラーが発生した場合
		// 処理を抜ける。（処理を中断する）
		// SQL文実行時にエラーが発生しなかった場合
		// 支給限度額情報を登録する。※まだコミットは行わない。
		// ループのカウントを+1する。
		// レコード数分ループした場合次処理へ。

		// getValidPeriodPanel().setSource(getInsurerLimitRateMap());
		// getValidPeriodPanel().applySource();
		//		
		// getInsurerLimitRateList().clearData();
		// getInsurerLimitRateList().addData(getInsurerLimitRateMap());

		for (int i = 0; i < getInsurerLimitRateList().size(); i++) {
			VRMap insurerLimitRateMap = new VRHashMap();
			insurerLimitRateMap = (VRMap) getInsurerLimitRateList().getData(i);
			insurerLimitRateMap.setData("LIMIT_RATE_HISTORY_ID", Integer
					.toString(i + 1));

			getDBManager()
					.executeUpdate(
							getSQL_INSURT_INSURER_LIMIT_RATE((VRMap) getInsurerLimitRateList()
									.getData(i)));
		}
		// 支給限度額詳細情報登録用SQL文で使用するためのデーターを取得しinsurerLimitRateListSourceに格納する。
		String[] str1 = { "INSURER_ID", "LIMIT_RATE_HISTORY_ID",
				"LIMIT_RATE_VALID_START", "LIMIT_RATE_VALID_END" };
		String[] str2 = { "12", "13", "11", "21", "22", "23", "24", "25" };
		Object obj = null;

		setInsurerLimitRateListSource(ACBindUtilities.getParalleledKeyList(
				getInsurerLimitRateList(), str1, "JOTAI_CODE",
				"LIMIT_RATE_VALUE", str2, obj));

		// insurerLimitRateSource内のレコードを支給限度額詳細情報TABLEに登録する。
		// insurerLimtRateSource内のレコードの数だけ以下の処理を行う。
		// insurerLimitRateSourceからレコードを取得しinsurerLimitRateSourceMapに格納する。
		VRMap insurerLimitRateListSourceMap = new VRHashMap();
		for (int i = 0; i < getInsurerLimitRateListSource().size(); i++) {
			insurerLimitRateListSourceMap
					.putAll((VRMap) getInsurerLimitRateListSource().getData(i));
			getDBManager()
					.executeUpdate(
							getSQL_INSURT_INSURER_LIMIT_RATE_DETAIL(insurerLimitRateListSourceMap));
		}
		// 支給限度額詳細情報登録用のSQL文を取得する
		// getSQL_INSURT_INSURER_LIMIT_RATE_DETAIL(insurerLimitRateListSourceMap);
		// 取得したSQL文を実行する。
		// getDBManager().executeUpdate(getSQL_INSURT_INSURER_LIMIT_RATE_DETAIL(insurerLimitRateListSourceMap));
		// SQL文実行時にエラーが発生した場合
		// 処理を抜ける。（処理を中断する）
		// SQL文実行時にエラーが発生しなかった場合
		// ループのカウントを+1する。
		// レコード数分ループした場合次処理へ。

	}

	/**
	 * 「渡しパラメーターを設定する。」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void setParameter() throws Exception {
		// 前画面のIDを設定する処理
		// 保険者番号テキスト(insurerId)から値を取得し、渡しパラメーターとして下記のKEY/VALUEで格納する。
		// KEY：INSURER_ID VALUE：保険者番号テキストから取得した値
		// setParameter("INSURER_ID",getInsurerId().getText());

	}

	/**
	 * 「保険者全情報入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doValidCheck() throws Exception {
		// 保険者登録に入力必須な項目のチェックを行う処理。
		// 保険者基本情報入力チェックをする。
		if (doValidInsurerInfoCheck() && doValidLimitRateCheck()) {
			return true;
		}
		// 有効期間入力チェックを行う。
		// doValidLimitRateCheck();

		// 上記２つのチェックでエラーが発生しなかった場合 true を返す
		return false;
	}

	/**
	 * 「保険者基本情報入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doValidInsurerInfoCheck() throws Exception {
		// ｢保険者番号（insurerId）｣が入力されているかチェックする処理
		// 入力されていなかった場合
		if (ACTextUtilities.isNullText(getInsurerId().getText())) {
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT 第1引数 =
			// "保険者番号"
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("保険者番号");
			// ｢保険者番号（insurerId）｣にフォーカスを当てる。
			getInsurerId().requestFocus();
			// 処理を抜ける。（処理を中断する）
			return false;

			// 入力されていた場合
		} else {
//			if (getInsurerId().getText().length() != 6) {
//				QkanMessageList.getInstance().ERROR_OF_LENGTH("保険者番号", "6");
//				// ｢保険者番号（insurerId）｣にフォーカスを当てる。
//				getInsurerId().requestFocus();
//				// 処理を抜ける。（処理を中断する）
//				return false;
//			}

			// ｢保険者名称（insurerName）｣が入力されているかチェックする。
			// 入力されていなかった場合
			if (ACTextUtilities.isNullText(getInsurerName().getText())) {
				// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT 第1引数 =
				// "保険者名称"
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						"保険者名称");
				// ｢保険者名称（insurerName）｣にフォーカスを当てる。
				getInsurerName().requestFocus();
				// 処理を抜ける。（処理を中断する）
				return false;
			}
		}

		// ｢保険者番号テキスト（insurerId）｣に入力されている保険者番号と、登録済みデータの保険者番号が重複していないかチェックする。
		// insurerLimitRateList内に｢保険者番号テキスト（insurerId）｣に入力されている保険者番号と、同一の保険者番号が存在するかチェックする。
		// if(VRBindPathParser.get("INSURER_ID",getInsurerLimitRateList()) !=
		// null){
		// for (int i = 0; i < getInsurerLimitRateList().size(); i++) {
		// if (VRBindPathParser.get("INSURER_ID",
		// (VRMap) getInsurerLimitRateList().getData(i)).equals(
		// getInsurerId().getText())) {
		// // 存在した場合
		// // エラーメッセージを表示する。※メッセージID = ERROR_OF_SAME_DATA_FOUND
		// QkanMessageList.getInstance().ERROR_OF_SAME_DATA_FOUND("保険者");
		// // ｢保険者番号テキスト（insurerId）｣にフォーカスを当てる。
		// getInsurerId().requestFocus();
		// // 処理を抜ける。（処理を中断する）
		// return false;
		// }
		// }
		// }
		return true;
	}

	/**
	 * 「保険者名称入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doValidInsurerNameCheck() throws Exception {
		// ｢保険者名称（insurerName）｣が入力されているかチェックする。
		// 入力されていなかった場合
		if (ACTextUtilities.isNullText(getInsurerName().getText())) {
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT 第1引数 =
			// "保険者名称"
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("保険者名称");
			// ｢保険者名称（insurerName）｣にフォーカスを当てる。
			getInsurerName().requestFocus();
			// 処理を抜ける。（処理を中断する）
			return false;
		}
		return true;
	}

	/**
	 * 「支給限度額情報チェック処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doValidLimitRateCheck() throws Exception {
		// 支給限度額情報正しく入力されているかチェックする処理
		// ｢有効期間テキスト（開始）（validPeriodStart）｣が入力されているかチェックする。
		// 入力されていた場合
		if (!ACTextUtilities.isNullText(getValidPeriodStart().getText())) {
			// 日付型かどうかのチェック
			if (!getValidPeriodStart().isValidDate()) {
				// エラーメッセージを表示する。※メッセージID = ERROR_OF_WRONG_DATE 引数 = 有効期間
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("有効期間");
				// ｢有効期間テキスト（終了）（validPeriodEnd）｣にフォーカスを当てる。
				getValidPeriodStart().requestFocus();
				// 処理を抜ける。（処理を中断する）
				return false;
			}

			// ｢有効期間テキスト（終了）（validPeriodEnd）｣が入力されているかチェックする。
			// 入力されていた場合
			if (!ACTextUtilities.isNullText(getValidPeriodEnd().getText())) {
				if (!getValidPeriodEnd().isValidDate()) {
					// エラーメッセージを表示する。※メッセージID = ERROR_OF_WRONG_DATE 引数 = 有効期間
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("有効期間");
					// ｢有効期間テキスト（終了）（validPeriodEnd）｣にフォーカスを当てる。
					getValidPeriodEnd().requestFocus();
					// 処理を抜ける。（処理を中断する）
					return false;
				}

				// 有効期間テキストに入力された値をチェックする。
				// 値が、有効期間テキスト（開始）＞有効期間テキスト（終了）だった場合
				if (ACDateUtilities
						.compareOnDay(
								ACCastUtilities.toDate(getValidPeriodStart()
										.getText()),
								ACCastUtilities.toDate(getValidPeriodEnd()
										.getText())) == 1) {
					// エラーメッセージを表示する。※メッセージID = ERROR_OF_WRONG_DATE 引数 = 有効期間
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("有効期間");
					// ｢有効期間テキスト（終了）（validPeriodEnd）｣にフォーカスを当てる。
					getValidPeriodEnd().requestFocus();
					// 処理を抜ける。（処理を中断する）
					return false;
				} else if (ACDateUtilities
						.compareOnDay(
								ACCastUtilities.toDate(getValidPeriodStart()
										.getText()),
								ACCastUtilities.toDate(getValidPeriodEnd()
										.getText())) == 0) {
					// 値が、有効期間テキスト（開始）=有効期間テキスト（終了）だった場合
					// エラーメッセージを表示する。※メッセージID = ERROR_OF_WRONG_DATE 引数 = 有効期間
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("有効期間");
					// ｢有効期間テキスト（終了）（validPeriodEnd）｣にフォーカスを当てる。
					getValidPeriodEnd().requestFocus();
					// 処理を抜ける。（処理を中断する）
					return false;
				}
			} else {
				// 入力されていなかった場合
				// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT 引数 =
				// 有効期間
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						"有効期間");
				// ｢有効期間テキスト（終了）（validPeriodEnd）｣にフォーカスを当てる。
				getValidPeriodEnd().requestFocus();
				// 処理を抜ける。（処理を中断する）
				return false;
			}
		} else {
			// 入力されていなかった場合
			// 有効期間テキスト（終了）（validPeriodEnd）｣が入力されているかチェックする。
			// 入力されていた場合
			if (!ACTextUtilities.isNullText(getValidPeriodEnd().getText())) {
				if (!getValidPeriodEnd().isValid()) {
					// エラーメッセージを表示する。※メッセージID = ERROR_OF_WRONG_DATE 引数 = 有効期間
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("有効期間");
					// ｢有効期間テキスト（終了）（validPeriodEnd）｣にフォーカスを当てる。
					getValidPeriodEnd().requestFocus();
					// 処理を抜ける。（処理を中断する）
					return false;
				}

				// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT 引数 =
				// 有効期間
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						"有効期間");
				// ｢有効期間テキスト（開始）（validPeriodStart）｣にフォーカスを当てる。
				getValidPeriodStart().requestFocus();
				// 処理を抜ける。（処理を中断する）
				return false;
				// 入力されていなかった場合
			} else {
				// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						"有効期間");
				// ｢有効期間テキスト（開始）（validPeriodStart）｣にフォーカスを当てる。
				getValidPeriodStart().requestFocus();
				// 処理を抜ける。（処理を中断する）
				return false;
			}
		}

		// 有効期間テキスト（開始）（validPeriodStart）の値をチェックする。
		// 入力されている値が月初以外の値だった場合
		if (ACDateUtilities.compareOnDay(
				ACCastUtilities.toDate(getValidPeriodStart().getText()),
				ACDateUtilities
						.toFirstDayOfMonth(
								ACCastUtilities.toDate(getValidPeriodStart()
										.getText()))) != 0) {
			// エラーメッセージを表示する。 メッセージID：ERROR_OF_VALID_PERIOD
			QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD("開始", "月初");
			return false;
		}
		// ・有効期間テキスト（終了）（validPeriodEnd）
		// 入力されている値が月末以外の値だった場合
		if (ACDateUtilities.compareOnDay(
				ACCastUtilities.toDate(getValidPeriodEnd().getText()),
				ACDateUtilities.toLastDayOfMonth(
						ACCastUtilities.toDate(getValidPeriodEnd().getText()))) != 0) {
			// エラーメッセージを表示する。 メッセージID：ERROR_OF_VALID_PERIOD
			QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD("終了", "月末");
			return false;
		}

		// 下記のフィールドに入力されている日付が既に登録されている有効期間と重複していないかチェックする。※有効期間が正しく入力されている場合のみ通過するロジック。
		// ・有効期間テキスト（開始）（validPeriodStart）
		// ・有効期間テキスト（終了）（validPeriodEnd）
		// insurerLimitRateList内のLIMIT_RATE_VALID_START及び、LIMIT_RATE_VALID_ENDの日付と比較する。
		// validPeriodStart > LIMIT_RATE_VALID_START
		// validPeriodStart < LIMIT_RATE_VALID_END
		// validPeriodEnd > LIMIT_RATE_VALID_START
		// validPeriodEnd > LIMIT_RATE_VALID_END

		if (getInsurerLimitRateList().size() > 0) {
			for (int i = 0; i < getInsurerLimitRateList().size(); i++) {
				if(canBackBtnHantei==true){
					return true;
				}
				
				if (insurerLimitRateEditHantei == true
						&& getInsurerLimitRateTable().getSelectedModelRow() == i) {
					insurerLimitRateEditHantei = false;
					break;
				}

				if (ACDateUtilities
						.compareOnDay(
								ACCastUtilities.toDate(getValidPeriodStart()
										.getText()),
								(Date) VRBindPathParser.get(
										"LIMIT_RATE_VALID_START",
										(VRMap) getInsurerLimitRateList()
												.getData(i))) == 0) {
					// 下記の条件と一致する場合エラーメッセージを表示する。メッセージID =
					// QO002_ERROR_OF_DUPLICATE_LIMIT_RATE 引数 = "有効期間"
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("有効期間");
					return false;
				}
				if (ACDateUtilities.compareOnDay(
						ACCastUtilities.toDate(getValidPeriodEnd().getText()),
						(Date) VRBindPathParser.get("LIMIT_RATE_VALID_END",
								(VRMap) getInsurerLimitRateList().getData(i))) == 0) {
					// 下記の条件と一致する場合エラーメッセージを表示する。メッセージID =
					// QO002_ERROR_OF_DUPLICATE_LIMIT_RATE 引数 = "有効期間"
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("有効期間");
					return false;
				}
				if (ACDateUtilities
						.compareOnDay(
								ACCastUtilities.toDate(getValidPeriodStart()
										.getText()),
								(Date) VRBindPathParser.get(
										"LIMIT_RATE_VALID_START",
										(VRMap) getInsurerLimitRateList()
												.getData(i))) == 1
						&& ACDateUtilities.compareOnDay(
								ACCastUtilities.toDate(getValidPeriodStart()
										.getText()),
								(Date) VRBindPathParser.get(
										"LIMIT_RATE_VALID_END",
										(VRMap) getInsurerLimitRateList()
												.getData(i))) == -1) {
					// 下記の条件と一致する場合エラーメッセージを表示する。メッセージID =
					// QO002_ERROR_OF_DUPLICATE_LIMIT_RATE 引数 = "有効期間"
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("有効期間");
					return false;
				}
				if (ACDateUtilities.compareOnDay(
						ACCastUtilities.toDate(getValidPeriodEnd().getText()),
						(Date) VRBindPathParser.get("LIMIT_RATE_VALID_START",
								(VRMap) getInsurerLimitRateList().getData(i))) == 1
						&& ACDateUtilities.compareOnDay(
								ACCastUtilities.toDate(getValidPeriodEnd()
										.getText()),
								(Date) VRBindPathParser.get(
										"LIMIT_RATE_VALID_END",
										(VRMap) getInsurerLimitRateList()
												.getData(i))) == -1) {
					// 下記の条件と一致する場合エラーメッセージを表示する。メッセージID =
					// QO002_ERROR_OF_DUPLICATE_LIMIT_RATE 引数 = "有効期間"
					QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("有効期間");
					return false;
				}
			}
		}

		// 下記のフィールドが空白でないかチェックする。
		// ・支給限度額（要支援）（yosien）
		// ・支給限度額（要介護1）（yokaigo1）
		// ・支給限度額（要介護2）（yokaigo2）
		// ・支給限度額（要介護3）（yokaigo3）
		// ・支給限度額（要介護4）（yokaigo4）
		// ・支給限度額（要介護5）（yokaigo5）
		// 空白だった場合
		if (getYosien1().getText().equals("")
				|| getYosien2().getText().equals("")
				|| getYosien().getText().equals("")
				|| getYokaigo1().getText().equals("")
				|| getYokaigo2().getText().equals("")
				|| getYokaigo3().getText().equals("")
				|| getYokaigo4().getText().equals("")
				|| getYokaigo5().getText().equals("")) {
			// エラーメッセージを表示する。 ※メッセージID：ERROR_OF_NEED_CHECK_FOR_INPUT
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("支給限度額");
			// 処理を抜ける。（処理を中断する）
			return false;
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
		allClearMap = (VRMap) getInsurerInfos().createSource();
        // [ID:0000461][Masahiko Higuchi] 2009/03 add begin 保険者登録時の初期値
        allClearMap.setData("INSURER_TYPE",new Integer(1));
        // [ID:0000461][Masahiko Higuchi] 2009/03 add end
        // [ID:0000520][Masahiko Higuchi] 2009/07 add begin 保険者マスタより保険者番号のエラーチェック機能を追加
        // 保険者マスタが存在する場合、保険者番号連動イベントを組み込む
        if (getMasterInsurerDBManager() != null
                && QkanSystemInformation.getInstance()
                        .isInsurerMasterDatabese()) {
            // 解析処理
            setQO002_InsurerRelation(new QO002_InsurerRelation(
                    getMasterInsurerDBManager(), getInsurerId(),
                    getInsurerName(), true, true, true , true));
        }
        // [ID:0000520][Masahiko Higuchi] 2009/07 add end
		getInsurerInfos().setSource(allClearMap);
		getInsurerInfos().bindSource();

		// insurerLImitRateListを初期化する。
		// setInsurerLimitRateList(null);
		// 支給限度額情報テーブルに初期化したレコードを表示する。※テーブルがクリアされる
		// getInsurerLimitRateTableModel().setAdaptee(getInsurerLimitRateList());
		getInsurerLimitRateTableModel().clearData();

		// PROCESS_MODEを、共通定数の｢PROCESS_MODE_INSERT(4)｣にする。
		setPROCESS_MODE(Integer.toString(QkanConstants.PROCESS_MODE_INSERT));

		// insurerLimitRateTableChangeFlgに0（変化なし）を代入する。
		setInsurerLimitRateTableChangeFlg(0);

		// 支給限度額チェックをはずす
		getInsurerLimitRateEnableCheck().setSelected(false);

		// 内部変数 map を生成する。
		VRMap map = new VRHashMap();
		// 厚労省規定の支給限度額を取得し map に格納する
		map.putAll(doFindRegularLImitRate());
		// 取得した支給限度額を保険者支給限度額情報パネル（insurerLimitRateInfo）にセットする
		// setSource(contents, allClearMap);
		getValidPeriodPanel().setSource(map);
		// 画面に展開する
		getValidPeriodPanel().bindSource();

		// 保険者番号テキストを有効にする
		getInsurerId().setEnabled(true);

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
        // [ID:0000520][Masahiko Higuchi] 2009/07 add begin 保険者マスタより保険者番号のエラーチェック機能を追加
        // 保険者マスタが存在する場合、保険者番号連動イベントを組み込む
        if (getMasterInsurerDBManager() != null
                && QkanSystemInformation.getInstance()
                        .isInsurerMasterDatabese()) {
            setState_VALID_INSURER_SELECT();
        } else {
            setState_INVALID_INSURER_SELECT();
        }
        // [ID:0000520][Masahiko Higuchi] 2009/07 add end
		// フォーカス設定
		getInsurerId().requestFocus();

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
		// getSnapshot().snapshot();
		// ※スナップショットの撮影対象から下記の領域を除外する。
		VRList excusions = new VRArrayList();
		excusions.add(getInsurerLimitRateInfo());

		getSnapshot().setExclusions(excusions);

		// 要介護情報領域のスナップショット
		getSnapShotPeriod().setRootContainer(getInsurerLimitRateInfo());

		getSnapshot().snapshot();
		getSnapShotPeriod().snapshot();
	}

	/**
	 * 「規定支給限度額を取得する処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public VRMap doFindRegularLImitRate() throws Exception {
		// 規定支給限度額を取得する処理
		// 内部変数 regularLimitRateList を生成する。
		VRList regularLimitRateList = new VRArrayList();
		// 内部変数 regularLimitRateMap を生成する。
		VRMap regularLimitRateMap = new VRHashMap();
		// 規定支給限度額を取得するためのSQL文を取得する。
		// getSQL_SELECT_M_LIMIT_RATE(null);
		// 取得したSQL文を実行する。
		VRMap sqlParam = new VRHashMap();
		// sqlParam.setData("M_LIMIT_RATE_DETAIL.LIMIT_RATE_HISTORY_ID","1");
		regularLimitRateList = getDBManager().executeQuery(
				getSQL_SELECT_M_LIMIT_RATE(null));
		// 取得したレコード数が1件以上だった場合
		if (regularLimitRateList.size() > 0) {
			// 取得した情報をregularLimitRateListに格納する。
			// 並列のレコードを直列化する。
			// 直列化した値をregularLImitRateMapに格納する。
			// regularLimitRateMapを戻り値として返す。

			VRMap map = new VRHashMap();
			if (regularLimitRateList.size() > 0) {
				// 親情報だけ転記
				map.putAll((VRMap) regularLimitRateList.getData());
				map.remove("JOTAI_CODE");
				map.remove("LIMIT_RATE_VALUE");
				map.setData("LIMIT_RATE_VALID_END", "");

				Iterator it = regularLimitRateList.iterator();
				while (it.hasNext()) {
					VRMap row = (VRMap) it.next();
					// JOTAI_CODEをキー、LIMIT_RATE_VALUEを値として追加
					map.put(String.valueOf(VRBindPathParser.get("JOTAI_CODE",
							row)), VRBindPathParser
							.get("LIMIT_RATE_VALUE", row));
				}
			}
			regularLimitRateMap = map;

			return regularLimitRateMap;

		} else {
			return null;
		}
	}

    /**
     * 保険者選択ボタン押下時の処理
     * 
     * @author Masahiko Higuchi
     * @since V5.5.0
     */
    protected void insurerSelectButtonActionPerformed(ActionEvent e)
            throws Exception {
        // 保険者選択画面を生成する。
        QO002001 insurerSelectDialog = new QO002001();
        VRMap selectData = insurerSelectDialog.showModal(getMasterInsurerDBManager());
        // 選択されていない場合
        if(selectData == null) {
            return;
        }
        // ×ボタン対策
        if(selectData.isEmpty()) {
            return;
        }
        // 保険者番号
        getInsurerId().setText(
                ACCastUtilities.toString(VRBindPathParser.get("INSURER_NO",
                        selectData), ""));
        // 保険者名称
        getInsurerName().setText(
                ACCastUtilities.toString(VRBindPathParser.get("INSURER_NAME",
                        selectData), ""));
        getQO002_InsurerRelation().validDataNo(getInsurerId(),
                getInsurerId().getText());
        getQO002_InsurerRelation().validDataName(getInsurerName(),
                getInsurerName().getText());
        revalidate();
        repaint();
        
    }

}
