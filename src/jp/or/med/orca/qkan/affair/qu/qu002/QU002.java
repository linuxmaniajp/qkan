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
 * 開発者: 上司 和善
 * 作成日: 2006/01/12  日本コンピューター株式会社 上司 和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 利用者登録 (002)
 * プログラム 利用者登録 (QU002)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qu.qu002;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.text.Format;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACHashMapFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.ACZipRelation;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
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
import jp.or.med.orca.qkan.affair.qu.qu001.QU001;
import jp.or.med.orca.qkan.affair.qu.qu004.QU004;

/**
 * 利用者登録(QU002)
 */
public class QU002 extends QU002Event {
	/**
	 * コンストラクタです。
	 */
	public QU002() {
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
		VRMap param = affair.getParameters();

		// KEY：COMPULSORY_BACK_FLG
		if (VRBindPathParser.has("COMPULSORY_BACK_FLG", param)) {
			setCompulsoryBackFlg(ACCastUtilities.toInt(VRBindPathParser.get(
					"COMPULSORY_BACK_FLG", param)));
			// 戻りフラグが1の場合
			if (getCompulsoryBackFlg() == 1) {
				// 前画面へ遷移する。
				ACFrame.getInstance().back();
				return;
			}

		}

		// KEY：PATIENT_ID(利用者ID)
		if (VRBindPathParser.has("PATIENT_ID", param)) {
			setPatientId(ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", param)));
		}

		// KEY：PROCESS_MODE(処理モード)
		if (VRBindPathParser.has("PROCESS_MODE", param)) {
			setProcessMode(ACCastUtilities.toInt(VRBindPathParser.get(
					"PROCESS_MODE", param)));
		}

		// KEY：PROCESS_START(遷移元画面)
		if (VRBindPathParser.has("PROCESS_START", param)) {
			setProcessStart(ACCastUtilities.toString(VRBindPathParser.get(
					"PROCESS_START", param)));
		} else {
			// PROCESS_STARTが送られていない場合
			// 前画面IDを取得する。
			ACAffairInfo info = ACFrame.getInstance().getBackAffair();

			if (info != null) {
				if (QM002.class.getName().equals(info.getClassName())) {
					// 前画面がメニュー画面（QM002）の場合
					setProcessStart("FROM_MENU");

				} else if (QU001.class.getName().equals(info.getClassName())) {
					// 前画面が利用者一覧画面（QU001）の場合
					setProcessStart("FROM_LIST");

				}
			}
		}

		// 渡りパラメータの削除
		param.clear();

		// [ID:0000749][Masahiko.Higuchi] add - begin 特定入所者の履歴管理機能
		// テーブルモデルを定義する。
		ACTableModelAdapter model = new ACTableModelAdapter();

		model.setColumns(new String[] { "SHOW_FLAG", "SHISETSU_VALID_START",
				"SHISETSU_VALID_END", "TOKUTEI_NYUSHO_FLAG", "KYUSOCHI_FLAG",
				"DISEASE" });
		
		// フォーマッタの設定を行う
		getShisetsuInfoTableColumn3().setFormat(
				new ACHashMapFormat(new String[] {
						"jp/nichicom/ac/images/icon/pix16/btn_080.png",
						"jp/nichicom/ac/images/icon/pix16/btn_079.png" },
						new Integer[] { new Integer(1), new Integer(2), }));
		getShisetsuInfoTableColumn4().setFormat(
				new ACHashMapFormat(new String[] {
						"jp/nichicom/ac/images/icon/pix16/btn_080.png",
						"jp/nichicom/ac/images/icon/pix16/btn_079.png" },
						new Integer[] { new Integer(1), new Integer(2), }));
		setShisetsuTableModel(model);

		// アダプタをテーブルのモデルとして設定する。
		getShisetsuInfoTable().setModel(getShisetsuTableModel());
		// [ID:0000749][Masahiko.Higuchi] add - end

		// 画面の初期化を行う。
		initialize();

		// DBよりレコードを取得し、画面に展開する。
		doFind();

	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}

		boolean unsettledInfoExistFlg = false;

		// 強制的に戻す
		if (getCompulsoryBackFlg() == 1) {
			return true;
		}

		// 変更チェック(破棄する可能性のある情報)
		// [ID:0000749][Masahiko.Higuchi] edit - begin 特定入所者の履歴管理機能
// 2015/1/14 [Yoichiro Kamei] mod - begin 住所地特例対応
//		if (getSnapShotIdou().isModified() || getSnapShotKaigo().isModified() || getSnapShotShisetsu().isModified()) {
		if (getSnapShotIdou().isModified() || getSnapShotKaigo().isModified() || getSnapShotShisetsu().isModified() || getSnapShotJushotiTokurei().isModified()) {
// 2015/1/14 [Yoichiro Kamei] mod - end
		// [ID:0000749][Masahiko.Higuchi] edit - end
			unsettledInfoExistFlg = true;
		}

		// [ID:0000749][Masahiko.Higuchi] edit - begin 特定入所者の履歴管理機能
		// 変更チェック（スナップショットのチェック、画面テーブルのチェック）
		if (getSnapshot().isModified() || getIdouTableChangeFlg() == 1
				|| getKaigoTableChangeFlg() == 1 || unsettledInfoExistFlg
// 2015/1/14 [Yoichiro Kamei] mod - begin 住所地特例対応
//				|| getShisetsuTableChangeFlg() == 1) {
				|| getShisetsuTableChangeFlg() == 1 || getJushotiTokureiTableChangeFlg() == 1) {
// 2015/1/14 [Yoichiro Kamei] mod - end
			// 最後に保存されてから、項目・画面テーブルが変更されている場合(下記のいずれかの場合）
			// ・isModified
			// ・idouTableChangeFlg = 1
			// ・kaigoTableChangeFlg = 1
		// [ID:0000749][Masahiko.Higuchi] edit - end
			
			// 確認メッセージを表示する。
			if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
				// 新規の場合（processModeが共通定数のPROCESS_MODE_INSERT）
				// ・メッセージID：WARNING_OF_INSERT_ON_MODIFIED

				switch (QkanMessageList.getInstance()
						.WARNING_OF_INSERT_ON_MODIFIED()) {
				case ACMessageBox.RESULT_OK:
					// 「はい」を選択した場合

					try {
						// 破棄される情報があることを伝えるメッセージ
						if (unsettledInfoExistFlg) {
							// メッセージ表示
							// [ID:0000749][Masahiko.Higuchi] edit - begin 特定入所者の履歴管理機能
// 2015/1/14 [Yoichiro Kamei] mod - begin 住所地特例対応
//							String msgParam = "要介護認定情報もしくは異動情報・施設情報";
							String msgParam = "要介護認定情報もしくは異動情報・施設情報・住所地特例情報";
// 2015/1/14 [Yoichiro Kamei] mod - end
							// [ID:0000749][Masahiko.Higuchi] edit - end
							switch (QkanMessageList.getInstance()
									.WARNING_OF_CANCELLATION_UNSETTLED_DATA(
											msgParam)) {
							// 「OK」なら破棄
							case ACMessageBox.RESULT_OK:
								break;
							// 「CANCEL」なら処理中断
							case ACMessageBox.RESULT_CANCEL:
								return false;
							}
						}

						// 入力チェックを行う。
						if (!isValidInputPatient()) {
							// 入力エラーがある場合
							// 処理を終了する。
							return false;
						}

						// 保存処理を行う。
						if (!doSave()) {
							// パッシブエラーの場合
							return false;
						}

						// 処理モードを更新モードに変更する。
						setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

					} catch (Exception ex) {

						// 保存処理が正常終了しなかった場合
						// 処理を中断する。
						throw ex;
					}

					break;

				case ACMessageBox.RESULT_CANCEL:
					// 「キャンセル」を選択した場合
					// 処理を終了する。
					return false;
				}

			} else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
				// 編集の場合（processModeが共通定数のPROCESS_MODE_UPDATE）
				// ・メッセージID：WARNING_OF_UPDATE_ON_MODIFIED

				switch (QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED()) {
				case ACMessageBox.RESULT_OK:
					// 「はい」を選択した場合

					try {
						// 破棄される情報があることを伝えるメッセージ
						if (unsettledInfoExistFlg) {
							// メッセージ表示
							// [ID:0000749][Masahiko.Higuchi] edit - begin 特定入所者の履歴管理機能
// 2015/1/14 [Yoichiro Kamei] mod - begin 住所地特例対応
//							String msgParam = "要介護認定情報もしくは異動情報・施設情報";
							String msgParam = "要介護認定情報もしくは異動情報・施設情報・住所地特例情報";
// 2015/1/14 [Yoichiro Kamei] mod - end
							// [ID:0000749][Masahiko.Higuchi] edit - end
							switch (QkanMessageList.getInstance()
									.WARNING_OF_CANCELLATION_UNSETTLED_DATA(
											msgParam)) {
							// 「OK」なら破棄
							case ACMessageBox.RESULT_OK:
								break;
							// 「CANCEL」なら処理中断
							case ACMessageBox.RESULT_CANCEL:
								return false;
							}
						}

						// 入力チェックを行う。
						if (!isValidInputPatient()) {
							// 入力エラーがある場合
							// 処理を終了する。
							return false;
						}

						// 保存処理を行う。
						if (!doSave()) {
							// パッシブエラーの場合
							return false;
						}

					} catch (Exception ex) {
						// 保存処理が正常終了しなかった場合
						// 処理を中断する。(終了)
						throw ex;
					}

					break;

				case ACMessageBox.RESULT_CANCEL:
					// 「はい」「いいえ」以外を選択した場合
					// 処理を中断する（何もしない）。
					return false;
				}
			}
		}

		// 前画面に遷移する。
		if ("FROM_LIST".equals(getProcessStart())) {
			// 利用者一覧画面から遷移してきた場合（processStart = "FROM_LIST"）

			if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
				// 更新モードの場合、下記を渡りパラメータとする。
				// ・KEY：PATIENT_ID　VALUE：patientId
				VRBindPathParser.set("PATIENT_ID", parameters, new Integer(
						getPatientId()));
			}
		}

		// 前画面への遷移を許可するならばtrueを返す。
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}

		// 変更チェック（スナップショット、画面テーブルのチェック）
		if (getSnapshot().isModified() || getIdouTableChangeFlg() == 1
				|| getKaigoTableChangeFlg() == 1) {
			// 最後に保存されてから、項目・画面テーブルが変更されている場合(下記のいずれかの場合）
			// ・isModified
			// ・idouTableChangeFlg = 1
			// ・kaigoTableChangeFlg = 1

			// 終了確認メッセージを表示する。
			// ・メッセージID：WARNING_OF_CLOSE_ON_MODIFIED
			switch (QkanMessageList.getInstance()
					.WARNING_OF_CLOSE_ON_MODIFIED()) {

			case ACMessageBox.RESULT_CANCEL:
				// 「キャンセル」を選択した場合
				// 処理を中断する（何もしない）。
				return false;
			}

		}

		// 終了を許可するならばtrueを返す。
		return true;
	}

	// コンポーネントイベント

	/**
	 * 「DB登録」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {

		// ※登録処理
		try {

			// [ID:0000749][Masahiko.Higuchi] edit - begin 特定入所者の履歴管理機能
			// 変更チェック(破棄する可能性のある情報)
			if (getSnapShotIdou().isModified()
					|| getSnapShotKaigo().isModified()
// 2015/1/14 [Yoichiro Kamei] mod - begin 住所地特例対応
//					|| getSnapShotShisetsu().isModified()) {
					|| getSnapShotShisetsu().isModified()
					|| getSnapShotJushotiTokurei().isModified()) {
// 2015/1/14 [Yoichiro Kamei] mod - end
				// メッセージ表示
// 2015/1/14 [Yoichiro Kamei] mod - begin 住所地特例対応
//				String msgParam = "要介護認定情報もしくは異動情報・施設情報";
				String msgParam = "要介護認定情報もしくは異動情報・施設情報・住所地特例情報";
// 2015/1/14 [Yoichiro Kamei] mod - end
				// [ID:0000749][Masahiko.Higuchi] edit - end
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

			// 入力チェックを行う。
			if (!isValidInputPatient()) {
				// 入力エラーがあった場合
				// 処理を中断する。(終了)
				return;
			}

			// 保存処理を行う。
			if (!doSave()) {
				// パッシブエラーの場合
				return;
			}

			// 保存処理が正常終了した場合
			// 処理モードを更新モードに変更する。
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

			// 画面の設定を行う。
			casualInitialize();

			// 最新のデータを取得する。
			doFind();

			// 完了メッセージを表示する。
			// ・メッセージID：INSERT_SUCCESSED
			QkanMessageList.getInstance().INSERT_SUCCESSED();

		} catch (Exception ex) {
			// 保存処理が正常終了しなかった場合
			// 処理を終了する。（何もしない）
			throw ex;
		}

	}

	/**
	 * 「DB更新」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void updateActionPerformed(ActionEvent e) throws Exception {

		// ※更新処理
		try {

			// [ID:0000749][Masahiko.Higuchi] edit - begin 特定入所者の履歴管理機能
			// 変更チェック(破棄する可能性のある情報)
			if (getSnapShotIdou().isModified()
					|| getSnapShotKaigo().isModified()
// 2015/1/14 [Yoichiro Kamei] mod - begin 住所地特例対応
//					|| getSnapShotShisetsu().isModified()) {
				|| getSnapShotShisetsu().isModified()
				|| getSnapShotJushotiTokurei().isModified()) {
// 2015/1/14 [Yoichiro Kamei] mod - end
				// メッセージ表示
// 2015/1/14 [Yoichiro Kamei] mod - begin 住所地特例対応
//				String msgParam = "要介護認定情報もしくは異動情報・施設情報";
				String msgParam = "要介護認定情報もしくは異動情報・施設情報・住所地特例情報";
// 2015/1/14 [Yoichiro Kamei] mod - end
			// [ID:0000749][Masahiko.Higuchi] edit - end
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

			// 入力チェックを行う。
			if (!isValidInputPatient()) {
				// 入力エラーがあった場合
				// 処理を中断する。(終了)
				return;
			}

			// 保存処理を行う。
			if (!doSave()) {
				// パッシブエラーの場合
				return;
			}

			// 保存処理が正常終了した場合
			// 画面の設定を行う。
			casualInitialize();

			// 最新のデータを取得する。
			doFind();

			// 完了メッセージを表示する。
			// ・メッセージID：UPDATE_SUCCESSED
			QkanMessageList.getInstance().UPDATE_SUCCESSED();

		} catch (Exception ex) {
			// 保存処理が正常終了しなかった場合
			// 処理を終了する。（何もしない）
			throw ex;
		}

	}

	/**
	 * 「画面全体クリア処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void clearInsertModeActionPerformed(ActionEvent e)
			throws Exception {

		// [ID:0000749][Masahiko.Higuchi] edit - begin 特定入所者の履歴管理機能
		// 変更チェック（スナップショットのチェック、画面テーブルのチェック）
		if (getSnapshot().isModified() || getIdouTableChangeFlg() == 1
				|| getKaigoTableChangeFlg() == 1
// 2015/1/14 [Yoichiro Kamei] mod - begin 住所地特例対応
//				|| getShisetsuTableChangeFlg() == 1) {
				|| getShisetsuTableChangeFlg() == 1
				|| getJushotiTokureiTableChangeFlg() == 1) {
// 2015/1/14 [Yoichiro Kamei] mod - end
			// [ID:0000749][Masahiko.Higuchi] edit - end
			// 最後に保存されてから、項目・画面テーブルが変更されている場合(下記のいずれかの場合）
			// ・isModified
			// ・idouTableChangeFlg = 1
			// ・kaigoTableChangeFlg = 1

			// 処理確認メッセージを表示する。
			// ・メッセージID：WARNING_OF_CLEAR_ON_MODIFIED
			switch (QkanMessageList.getInstance()
					.WARNING_OF_CLEAR_ON_MODIFIED()) {

			case ACMessageBox.RESULT_CANCEL:
				// 「キャンセル」を選択した場合
				// 処理を中断する（何もしない）。
				return;

			}
		}

		// 画面全体クリア処理を行う。
		doClear();

	}

	/**
	 * 「画面全体クリア処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void clearUpdateModeActionPerformed(ActionEvent e)
			throws Exception {

		// 変更チェック（スナップショットのチェック、画面テーブルのチェック）
		if (getSnapshot().isModified() || getIdouTableChangeFlg() == 1
				|| getKaigoTableChangeFlg() == 1) {
			// 最後に保存されてから、項目・画面テーブルが変更されている場合(下記のいずれかの場合）
			// ・isModified
			// ・idouTableChangeFlg = 1
			// ・kaigoTableChangeFlg = 1

			// 処理確認メッセージを表示する。
			// ・メッセージID：WARNING_OF_CLEAR_ON_MODIFIED
			switch (QkanMessageList.getInstance()
					.WARNING_OF_CLEAR_ON_MODIFIED()) {

			case ACMessageBox.RESULT_CANCEL:
				// 「キャンセル」を選択した場合
				// 処理を中断する（何もしない）。
				return;

			}
		}

		// 画面全体クリア処理を行う。
		doClear();

	}

	/**
	 * 「画面遷移処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void toKohiInfoButtonActionPerformed(ActionEvent e)
			throws Exception {

		boolean unsettledInfoExistFlg = false;

		// [ID:0000749][Masahiko.Higuchi] edit - begin 特定入所者の履歴管理機能
		// 変更チェック(破棄する可能性のある情報)
// 2015/1/14 [Yoichiro Kamei] mod - begin 住所地特例対応
//		if (getSnapShotIdou().isModified() || getSnapShotKaigo().isModified() || getSnapShotShisetsu().isModified()) {
		if (getSnapShotIdou().isModified() || getSnapShotKaigo().isModified() || getSnapShotShisetsu().isModified() || getSnapShotJushotiTokurei().isModified()) {
// 2015/1/14 [Yoichiro Kamei] mod - end
		// [ID:0000749][Masahiko.Higuchi] edit - end
			unsettledInfoExistFlg = true;
		}

		// メッセージ表示用引数
		String msgParam1 = null;
		String msgParam2 = null;

		// 下記の確認メッセージを表示する。
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// 新規の場合（processModeが共通定数のPROCESS_MODE_INSERT）
			// ・メッセージID：QU002_WARNING_OF_TRANSFER
			// 第一引数："公費・社福軽減情報"
			// 第ニ引数："登録"

			msgParam1 = "公費・社福軽減情報";
			msgParam2 = "登録";

		} else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// 編集の場合（processModeが共通定数のPROCESS_MODE_UPDATE）

			// 変更チェック（スナップショットのチェック、画面テーブルのチェック）
			if (getSnapshot().isModified() || getIdouTableChangeFlg() == 1
					|| getKaigoTableChangeFlg() == 1 || unsettledInfoExistFlg) {
				// 最後に保存されてから、項目・画面テーブルが変更されている場合(下記のいずれかの場合）
				// ・not isModified
				// ・idouTableChangeFlg = 1
				// ・kaigoTableChangeFlg = 1

				// ・メッセージID：QU002_WARNING_OF_TRANSFER
				// 第一引数："公費・社福軽減情報"
				// 第ニ引数："更新"

				msgParam1 = "公費・社福軽減情報";
				msgParam2 = "更新";
			}
		}

		// 引数が設定されている場合、メッセージを表示する。
		if (!(msgParam1 == null || "".equals(msgParam1))) {

			switch (QkanMessageList.getInstance().QU002_WARNING_OF_TRANSFER(
					msgParam1, msgParam2)) {

			case ACMessageBox.RESULT_OK:
				// 「はい」を選択した場合

				try {
					if (unsettledInfoExistFlg) {
						// メッセージ表示
						// [ID:0000749][Masahiko.Higuchi] edit - begin 特定入所者の履歴管理機能
// 2015/1/14 [Yoichiro Kamei] mod - begin 住所地特例対応
//						String msgParam = "要介護認定情報もしくは異動情報・施設情報";
						String msgParam = "要介護認定情報もしくは異動情報・施設情報・住所地特例情報";
// 2015/1/14 [Yoichiro Kamei] mod - end
						// [ID:0000749][Masahiko.Higuchi] edit - end
						switch (QkanMessageList.getInstance()
								.WARNING_OF_CANCELLATION_UNSETTLED_DATA(
										msgParam)) {
						// 「OK」なら破棄
						case ACMessageBox.RESULT_OK:
							break;
						// 「CANCEL」なら処理中断
						case ACMessageBox.RESULT_CANCEL:
							return;
						}
					}

					// 入力チェックを行う。
					if (!isValidInputPatient()) {
						// 入力エラーがあった場合
						// 処理を中断する。(終了)
						return;
					}

					// 保存処理を行う。
					if (!doSave()) {
						// パッシブエラーの場合
						return;
					}

					// 保存処理が正常終了した場合
					// 画面状態の初期化を行う。
					casualInitialize();

					// 最新のデータを取得する。
					doFind();

				} catch (Exception ex) {
					// 保存処理が正常終了しなかった場合
					// 処理を終了する。（何もしない）
					throw ex;
				}

				break;

			case ACMessageBox.RESULT_CANCEL:
				// 「はい」選択以外の場合
				// 処理を抜ける。
				return;

			}
		}

		// 以下を渡りパラメータとして、公費・社福軽減情報画面（QU004）に遷移する。
		// ・KEY：PATIENT_ID　VALUE：patientId
		// ・KEY：PROCESS_START　VALUE：processStart
		VRMap param = new VRHashMap();
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));
		VRBindPathParser.set("PROCESS_START", param, getProcessStart());

		ACAffairInfo affair = new ACAffairInfo(QU004.class.getName(), param);

		ACFrame.getInstance().next(affair);

	}

	/**
	 * 「対象レコードを表示」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void idouInfoTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		VRMap map = new VRHashMap();

		if (!getIdouInfoTable().isSelected()) {
			// 画面テーブルの行を選択していない場合
			// Enable制御を行う。
			// ・状態ID：ENABLE_IDOU_BUTTON_FALSE
			setState_ENABLE_IDOU_BUTTON_FALSE();

			// 画面のソースを生成する。
			map = (VRMap) getIdouInfo().createSource();

		} else {
			// 画面テーブルの行を選択している場合
			// ・状態ID：ENABLE_IDOU_BUTTON_TRUE
			// Enable制御を行う。
			setState_ENABLE_IDOU_BUTTON_TRUE();

			// 選択されているレコードを取得する。
			map = (VRMap) getIdouInfoTable().getSelectedModelRowValue();

		}

		// 「異動情報領域（idouInfo）」のソースとして設定する。
		getIdouInfo().setSource(map);

		// 画面に展開する。
		getIdouInfo().bindSource();

		// スナップショット
		getSnapShotIdou().snapshot();

	}

	/**
	 * 「クリア処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void idouInfoButtonClearActionPerformed(ActionEvent e)
			throws Exception {

		if (getIdouInfoTable().isSelected()) {
			// 画面テーブルが選択されている場合
			// 画面テーブルの行を未選択の状態に設定する。
			getIdouInfoTable().clearSelection();
		} else {
			VRMap map = new VRHashMap();

			// 画面のソースを生成する。
			map = (VRMap) getIdouInfo().createSource();

			// 「異動情報領域（idouInfo）」のソースとして設定する。
			getIdouInfo().setSource(map);

			// 画面に展開する。
			getIdouInfo().bindSource();

			// スナップショット
			getSnapShotIdou().snapshot();
		}

		// 異動領域の状態を初期化する。
		setState_IDOU_INIT();

	}

	/**
	 * 「追加処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void idouInfoButtonInsertActionPerformed(ActionEvent e)
			throws Exception {

		// 入力チェックを行う。
		if (!isValidInputIdou()) {
			// 入力エラーがあった場合
			// 処理を中断する。
			return;
		}

		// 入力エラーがなかった場合
		// 医療看護の訪問終了でない場合(時間テキストが無効の場合)
		// 「時間」の値に空文字を代入する。
		if (!getIdouInfoTime().isEnabled()) {
			getIdouInfoTime().setText("");
		}

		// 取得したデータの異動理由が「その他」以外の場合（その他内容テキストが非表示の場合）
		// 「その他　内容」の値に空文字を代入する。
		if (!getIdouInfoReasonMemo().getParent().isVisible()) {
			getIdouInfoReasonMemo().setText("");
		}

		// 空のHashMapを生成し、「異動情報領域（idouInfo）」のソースとして設定する。
		VRMap map = new VRHashMap();
		getIdouInfo().setSource(map);

		// 入力されたデータをソースに流し込み、データを取得する。
		getIdouInfo().applySource();

		// idouHistoryListを件数分ループし、CHANGES_HISTORY_IDの最大値+1の値を取得する。
		int maxId = 0;

		// 最大値の取得
		if (!(getIdouHistoryList() == null || getIdouHistoryList().size() == 0)) {

			// 画面テーブルに既にデータが存在している場合
			for (int i = 0; i < getIdouHistoryList().size(); i++) {

				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_HISTORY_ID",
						(VRMap) getIdouHistoryList().get(i)));

				// 比較対象が比較元より大きい値の場合
				if (maxId < target) {
					// 比較対象を比較元とする。
					maxId = target;
				}

			}
		}

		// 取得した値を、取得した異動情報にKEY：CHANGES_HISTORY_IDで設定する。
		VRBindPathParser.set("CHANGES_HISTORY_ID", map, new Integer(maxId + 1));

		// 利用者IDの設定
		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// 更新モードの場合
			// 取得したデータにKEY：PATIENT_ID　VALUE：patientidを設定する。
			VRBindPathParser
					.set("PATIENT_ID", map, new Integer(getPatientId()));
		}

		// テーブル表示用に編集する。
		map = toIdouTableList(map);

		// 取得したデータをidouHistoryListに追加する。
		getIdouHistoryList().add(map);

		// 追加行のインデックスを退避(最終行のインデックス)
		int selectedRow = getIdouHistoryList().size() - 1;

		// 以下の条件で異動情報テーブルのソートを行う。
		// CHANGES_DATE（異動日付）　DESC
		getIdouInfoTable().sort("CHANGES_DATE DESC");

		// 退避していたインデックスの行を選択
		getIdouInfoTable().setSelectedModelRow(selectedRow);

		// idouTableChangeFlgに1（変更あり）を代入する。
		setIdouTableChangeFlg(1);

	}

	/**
	 * 「編集処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void idouInfoButtonEditActionPerformed(ActionEvent e)
			throws Exception {

		// 入力チェックを行う。
		if (!isValidInputIdou()) {
			// 入力エラーがあった場合
			// 処理を中断する。
			return;
		}

		// 入力エラーがなかった場合
		// 医療看護の訪問終了でない場合(時間テキストが無効の場合)
		// 「時間」の値に空文字を代入する。
		if (!getIdouInfoTime().isEnabled()) {
			getIdouInfoTime().setText("");
		}

		// 取得したデータの異動理由が「その他」以外の場合（その他内容テキストが非表示の場合）
		// 「その他　内容」の値に空文字を代入する。
		if (!getIdouInfoReasonMemo().getParent().isVisible()) {
			getIdouInfoReasonMemo().setText("");
		}

		// 選択行のインデックスを退避
		int selectedRow = getIdouInfoTable().getSelectedModelRow();

		// 入力されたデータを取得する。
		VRMap map = new VRHashMap();
		getIdouInfo().setSource(map);
		getIdouInfo().applySource();

		// 選択行のデータを取得する。
		VRMap temp = (VRMap) getIdouHistoryList().get(selectedRow);

		// 選択行のデータより、画面上にないデータを画面上データに移す。
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));
		VRBindPathParser.set("CHANGES_HISTORY_ID", map,
				VRBindPathParser.get("CHANGES_HISTORY_ID", temp));

		// テーブル表示用に編集する。
		map = toIdouTableList(map);

		// 選択行に画面上のデータを設定する。
		getIdouHistoryList().setData(selectedRow, map);

		// 以下の条件で異動情報テーブルのソートを行う。
		// CHANGES_DATE（異動日付）　DESC
		getIdouInfoTable().sort("CHANGES_DATE DESC");

		// 選択されていた行を選択
		getIdouInfoTable().setSelectedModelRow(selectedRow);

		// idouTableChangeFlgに1（変更あり）を代入する。
		setIdouTableChangeFlg(1);

	}

	/**
	 * 「削除処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void idouInfoButtonDeleteActionPerformed(ActionEvent e)
			throws Exception {

		if (!(getIdouHistoryList() == null || getIdouHistoryList().size() == 0)) {
			// 確認メッセージを表示する。
			// 　・メッセージID：WARNING_OF_DELETE_SELECTION
			switch (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION()) {

			case ACMessageBox.RESULT_OK:
				// 「はい」を選択した場合
				// 選択されているレコードの画面上のインデックス
				int sortedRow = getIdouInfoTable().getSelectedSortedRow();

				// 選択されているレコードをidouHistoryListから削除する。
				getIdouHistoryList().remove(
						getIdouInfoTable().getSelectedModelRow());

				// 削除された行の1行上の行を選択する。
				getIdouInfoTable().setSelectedSortedRowOnAfterDelete(sortedRow);

				// idouTableChangeFlgに1（変更あり）を代入する。
				setIdouTableChangeFlg(1);

				break;

			case ACMessageBox.RESULT_CANCEL:
				// 「キャンセル」を選択した場合
				// 処理を抜ける。（何もしない）
				break;
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
	protected void kaigoInfoTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		VRMap map = new VRHashMap();

		if (!getKaigoInfoTable().isSelected()) {
			// 画面テーブルの行を選択していない場合

			// Enable制御を行う。
			// ・状態ID：ENABLE_KAIGO_BUTTON_FALSE
			setState_ENABLE_KAIGO_BUTTON_FALSE();

			// 画面のソースを生成する。
			map = (VRMap) getKaigoInfo().createSource();

			// 給付率にはデフォルト値：90を設定する。
			VRBindPathParser.set("INSURE_RATE", map, "90");

		} else {
			// 画面テーブルの行を選択している場合

			// Enable制御を行う。
			// ・状態ID：ENABLE_KAIGO_BUTTON_TRUE
			setState_ENABLE_KAIGO_BUTTON_TRUE();

			// 選択されているレコードを取得する。
			map = (VRMap) getKaigoInfoTable().getSelectedModelRowValue();

		}

		// 「介護情報領域（kaigoInfo）」のソースとして設定する。
		getKaigoInfo().setSource(map);

		// 画面に展開する。
		getKaigoInfo().bindSource();

		// スナップショット
		getSnapShotKaigo().snapshot();

	}

	/**
	 * 「クリア処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoButtonClearActionPerformed(ActionEvent e)
			throws Exception {

		if (getKaigoInfoTable().isSelected()) {
			// 画面テーブルが選択されている場合
			// 画面テーブルの行を未選択の状態に設定する。
			getKaigoInfoTable().clearSelection();

		} else {
			VRMap map = new VRHashMap();

			// 画面のソースを生成する。
			map = (VRMap) getKaigoInfo().createSource();

			// 給付率
			VRBindPathParser.set("INSURE_RATE", map, "90");

			// 「介護情報領域（kaigoInfo）」のソースとして設定する。
			getKaigoInfo().setSource(map);

			// 画面に展開する。
			getKaigoInfo().bindSource();

			// スナップショット
			getSnapShotKaigo().snapshot();
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
	protected void kaigoInfoButtonInsertActionPerformed(ActionEvent e)
			throws Exception {

		// 要介護度をチェック
		if (getKaigoInfoYokaigoInfo().isSelected()) {
			VRMap temp = (VRMap) getKaigoInfoYokaigoInfo()
					.getSelectedModelItem();
			int jotaiCode = ACCastUtilities.toInt(VRBindPathParser.get(
					"JOTAI_CODE", temp));
			if (jotaiCode == YOUKAIGODO_HIGAITOU) {
				// 非該当が選択されている場合　※追加・編集処理で使用する。
				setNonCorrespondenceFlg(1);
			} else {
				setNonCorrespondenceFlg(0);
			}
		}

		// 入力チェックを行う。
		if (!isValidInputKaigo(CHECK_MODE_INSERT)) {
			// 入力エラーがあった場合
			// 処理を中断する。
			return;
		}

		// 入力エラーがなかった場合

		// 「居宅サービス計画作成者」ラジオで、「被保険者」が選択されている場合
		// ※「居宅介護支援事業所名」コンボが無効の場合
		// 「居宅介護支援事業所名」コンボを未選択に設定する。
		if (!getKaigoInfoKyotakuServicePlanCombo().isEnabled()) {
			getKaigoInfoKyotakuServicePlanCombo().setSelectedItem(null);
		}

		// 空のHashMapを生成し、「介護情報領域（kaigoInfo）」のソースとして設定する。
		VRMap map = new VRHashMap();
		getKaigoInfo().setSource(map);

		// 入力されたデータをソースに流し込み、データを取得する。
		getKaigoInfo().applySource();

		// kaigoHistoryListを件数分ループし、NINTEI_HISTORY_IDの最大値+1の値を取得する。
		int maxId = 0;

		// 最大値の取得
		if (!(getKaigoHistoryList() == null || getKaigoHistoryList().size() == 0)) {

			// 画面テーブルに既にデータが存在している場合
			for (int i = 0; i < getKaigoHistoryList().size(); i++) {

				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"NINTEI_HISTORY_ID",
						(VRMap) getKaigoHistoryList().get(i)));

				// 比較対象が比較元より大きい値の場合
				if (maxId < target) {
					// 比較対象を比較元とする。
					maxId = target;
				}

			}
		}

		// 取得した値を、取得した認定情報にKEY：NINTEI_HISTORY_IDで設定する。
		VRBindPathParser.set("NINTEI_HISTORY_ID", map, new Integer(maxId + 1));

		// 利用者IDの設定
		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// 更新モードの場合
			// 取得したデータにKEY：PATIENT_ID　VALUE：patientidを設定する。
			VRBindPathParser
					.set("PATIENT_ID", map, new Integer(getPatientId()));
		}

		// if(getNonCorrespondenceFlg() == 0){
		// // 被保険者番号が「H～」となっている場合　※非該当の場合は当処理を通らない
		// // 被保険者番号
		// String insuredId =
		// ACCastUtilities.toString(VRBindPathParser.get("INSURED_ID", map));
		//
		// // 給付率
		// int insureRate = 0;
		// insureRate =
		// ACCastUtilities.toInt(VRBindPathParser.get("INSURE_RATE", map));
		//
		// if(insuredId.charAt(0) == 'H'){
		// if(insureRate != INSURE_RATE_SEIHO){
		// // 給付率が「0%」となっていない場合
		// if (QkanMessageList.getInstance()
		// .QU002_WARNING_OF_CHANGE_RATE_FOR_SEIHO_TANDOKU() ==
		// ACMessageBox.RESULT_YES) {
		// // 給付率を「0%」に設定する。
		// VRBindPathParser.set("INSURE_RATE", map, new
		// Integer(INSURE_RATE_SEIHO));
		// }
		// }
		// // 公費登録をうながすメッセージを表示する。
		// // ・メッセージID：QU002_REQUEST_TO_INSERT_SEIHO
		// QkanMessageList.getInstance().QU002_REQUEST_TO_INSERT_SEIHO();
		// }
		// }

		// テーブル表示用に編集
		map = toKaigoTableList(map);

// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//		// 要介護度が非該当の場合、上限・下限日付を有効期間に設定する。
//		if (getNonCorrespondenceFlg() == 1) {
//			setMaxAndMinDate(map);
//		}
		setMaxAndMinDate(map);
// 2016/7/5 [Yoichiro Kamei] mod - end

		// StringからIntegerに型変換　※ソート時対策
		final String[] keys = new String[] { "INSURE_RATE", "LIMIT_RATE",
				"EXTERNAL_USE_LIMIT" };
		QkanCommon.convertValueFromStringToInteger(map, keys);

		// 取得したデータをkaigoHistoryListに追加する。
		getKaigoHistoryList().add(map);

		// 追加行のインデックスを退避(最終行のインデックス)
		int selectedRow = getKaigoHistoryList().size() - 1;

		// 以下の条件で介護情報テーブルのソートを行う。
		// INSURE_VALID_START（有効期間開始）　DESC
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//		getKaigoInfoTable().sort("INSURE_VALID_START DESC");
		getKaigoInfoTable().sort("SYSTEM_INSURE_VALID_START DESC");
// 2014/12/17 [Yoichiro Kamei] mod - end
		// 追加行を選択
		getKaigoInfoTable().setSelectedModelRow(selectedRow);

		// kaigoTableChangeFlgに1（変更あり）を代入する。
		setKaigoTableChangeFlg(1);

		// 非該当フラグを初期化
		setNonCorrespondenceFlg(0);

		// システム日付において有効な要介護度を表示する。
		displayNowYokaigodo();

	}

	/**
	 * 「編集処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoButtonEditActionPerformed(ActionEvent e)
			throws Exception {

		// 要介護度をチェック
		if (getKaigoInfoYokaigoInfo().isSelected()) {
			VRMap temp = (VRMap) getKaigoInfoYokaigoInfo()
					.getSelectedModelItem();
			int jotaiCode = ACCastUtilities.toInt(VRBindPathParser.get(
					"JOTAI_CODE", temp));
			if (jotaiCode == YOUKAIGODO_HIGAITOU) {
				// 非該当が選択されている場合　※追加・編集処理で使用する。
				setNonCorrespondenceFlg(1);
			} else {
				setNonCorrespondenceFlg(0);
			}
		}

		// 入力チェックを行う。
		if (!isValidInputKaigo(CHECK_MODE_UPDATE)) {
			// 入力エラーがあった場合
			// 処理を中断する。
			return;
		}

		// 入力エラーがなかった場合
		// 「居宅サービス計画作成者」ラジオで、「被保険者」が選択されている場合
		// ※「居宅介護支援事業所名」コンボが無効の場合
		// 「居宅介護支援事業所名」コンボを未選択に設定する。
		if (!getKaigoInfoKyotakuServicePlanCombo().isEnabled()) {
			getKaigoInfoKyotakuServicePlanCombo().setSelectedItem(null);
		}

		// 選択行のインデックスを退避
		int selectedRow = getKaigoInfoTable().getSelectedModelRow();

		// 画面上のデータを取得する。
		VRMap map = new VRHashMap();

		getKaigoInfo().setSource(map);
		getKaigoInfo().applySource();

		// 選択行のデータを取得する。
		VRMap temp = (VRMap) getKaigoHistoryList().get(selectedRow);

		// 選択行のデータより画面上にないデータを画面上データに移す。
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));
		VRBindPathParser.set("NINTEI_HISTORY_ID", map,
				VRBindPathParser.get("NINTEI_HISTORY_ID", temp));

		// if(getNonCorrespondenceFlg() == 0){
		// // 被保険者番号が「H～」となっている場合
		//
		// // 被保険者番号
		// String insuredId =
		// ACCastUtilities.toString(VRBindPathParser.get("INSURED_ID", map));
		//
		// // 給付率
		// int insureRate = 0;
		// insureRate =
		// ACCastUtilities.toInt(VRBindPathParser.get("INSURE_RATE", map));
		//
		// if(insuredId.charAt(0) == 'H'){
		// if(insureRate != INSURE_RATE_SEIHO){
		// // 給付率が「0%」となっていない場合
		// if (QkanMessageList.getInstance()
		// .QU002_WARNING_OF_CHANGE_RATE_FOR_SEIHO_TANDOKU() ==
		// ACMessageBox.RESULT_YES) {
		// // 給付率を「0%」に設定する。
		// VRBindPathParser.set("INSURE_RATE", map, new
		// Integer(INSURE_RATE_SEIHO));
		// }
		// }
		// // 公費登録をうながすメッセージを表示する。
		// // ・メッセージID：QU002_REQUEST_TO_INSERT_SEIHO
		// QkanMessageList.getInstance().QU002_REQUEST_TO_INSERT_SEIHO();
		// }
		// }

		// テーブル表示用に編集する。
		map = toKaigoTableList(map);

// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//		// 要介護度が非該当の場合、上限・下限日付を有効期間に設定する。
//		if (getNonCorrespondenceFlg() == 1) {
//			setMaxAndMinDate(map);
//		}
		setMaxAndMinDate(map);
// 2016/7/5 [Yoichiro Kamei] mod - end

		// StringからIntegerに型変換　※ソート時対策
		final String[] keys = new String[] { "INSURE_RATE", "LIMIT_RATE",
				"EXTERNAL_USE_LIMIT" };
		QkanCommon.convertValueFromStringToInteger(map, keys);

		// 選択行に画面上のデータを設定する。
		getKaigoHistoryList().setData(selectedRow, map);

		// 以下の条件で介護情報テーブルのソートを行う。
		// INSURE_VALID_START（有効期間開始）　DESC
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//		getKaigoInfoTable().sort("INSURE_VALID_START DESC");
		getKaigoInfoTable().sort("SYSTEM_INSURE_VALID_START DESC");
// 2014/12/17 [Yoichiro Kamei] mod - end

		// 選択されていた行を選択
		getKaigoInfoTable().setSelectedModelRow(selectedRow);

		// kaigoTableChangeFlgに1（変更あり）を代入する。
		setKaigoTableChangeFlg(1);

		// 非該当フラグを初期化
		setNonCorrespondenceFlg(0);

		// システム日付において有効な要介護度を表示する。
		displayNowYokaigodo();

	}

	/**
	 * 「上限、下限日付設定」処理です。
	 * 
	 * @param VRMap
	 *            値を詰め込みたいVRMap
	 * @throws Exception
	 *             処理例外
	 */
	public void setMaxAndMinDate(VRMap map) throws Exception {
		// 非該当の場合の処理

		// 有効期間開始日が入力されていない場合
		// 下限日付を自動設定
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit1().getText())) {
			VRBindPathParser.set("INSURE_VALID_START", map, MIN_DATE);
		}

		// 有効期間終了日が入力されていない場合
		// 上限日付を自動設定
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
			VRBindPathParser.set("INSURE_VALID_END", map, MAX_DATE);
		}
		
// 2016/7/5 [Yoichiro Kamei] add - begin 総合事業対応
		// システム有効期間終了日が入力されていない場合
		// 上限日付を自動設定
		if (ACTextUtilities.isNullText(getKaigoInfoSystemValidLimit3().getText())) {
			VRBindPathParser.set("SYSTEM_INSURE_VALID_END", map, MAX_DATE);
		}
// 2016/7/5 [Yoichiro Kamei] add - end
	}

	/**
	 * 「削除処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoDeleteActionPerformed(ActionEvent e)
			throws Exception {

		if (!(getKaigoHistoryList() == null || getKaigoHistoryList().size() == 0)) {

			// 確認メッセージを表示する。
			// ・メッセージID：WARNING_OF_DELETE_SELECTION
			switch (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION()) {
			case ACMessageBox.RESULT_OK:
				// 「はい」を選択した場合

				// 選択行データを取得する。
				VRMap map = (VRMap) getKaigoInfoTable()
						.getSelectedModelRowValue();
				int jotaiCode = ACCastUtilities.toInt(VRBindPathParser.get(
						"JOTAI_CODE", map));

				// 非該当でない場合
				if (jotaiCode != YOUKAIGODO_HIGAITOU) {

					// 有効期間中のサービス予定・実績のレコードを取得するためのHashMap：paramを生成し、下記のKEY/VALUEを設定する。
					// ・KEY：PATIENT_ID　VALUE：patientId
					// ・KEY：VALID_START　VALUE：（有効期間開始）
					// ・KEY：VALID_END　VALUE：（有効期間終了）
					VRMap param = new VRHashMap();
					VRBindPathParser.set("PATIENT_ID", param, new Integer(
							getPatientId()));
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//					VRBindPathParser.set("VALID_START", param,
//							VRBindPathParser.get("INSURE_VALID_START", map));
//					VRBindPathParser.set("VALID_END", param,
//							VRBindPathParser.get("INSURE_VALID_END", map));
					VRBindPathParser.set("VALID_START", param,
							VRBindPathParser.get("SYSTEM_INSURE_VALID_START", map));
					VRBindPathParser.set("VALID_END", param,
							VRBindPathParser.get("SYSTEM_INSURE_VALID_END", map));
// 2014/12/17 [Yoichiro Kamei] mod - end
					
					// 有効期間中のサービス予定・実績のレコードを取得する。
					String strSql = getSQL_GET_PATIENT_RESERVED_SERVICE(param);
					VRList list = getDBManager().executeQuery(strSql);

					if (!(list == null || list.size() == 0)) {
						// レコードが1件以上だった場合
						// エラーメッセージを表示する。
						// ・メッセージID：QU002_ERROR_OF_RESERVED_SERVICE
						String msgParam = "編集";
						switch (QkanMessageList.getInstance()
								.QU002_WARNING_OF_OUT_OF_VALID(msgParam)) {
						case ACMessageBox.RESULT_CANCEL:
							return;
						}
					}
				}

				// レコードが0件だった場合
				// 選択されているレコードの画面上のインデックス
				int sortedRow = getKaigoInfoTable().getSelectedSortedRow();

				// 選択されているレコードをkaigoHistoryListから削除する。
				getKaigoHistoryList().remove(
						getKaigoInfoTable().getSelectedModelRow());

				// 削除された行の1行上を選択する。
				getKaigoInfoTable()
						.setSelectedSortedRowOnAfterDelete(sortedRow);

				// kaigoTableChangeFlgに1（変更あり）を代入する。
				setKaigoTableChangeFlg(1);

				// システム日付において有効な要介護度を表示する。
				displayNowYokaigodo();

				break;

			case ACMessageBox.RESULT_CANCEL:
				// 「いいえ」を選択した場合
				// 処理を抜ける。（何もしない）
				break;

			}
		}
	}

	/**
	 * 「画面処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void idouInfoServiseActionPerformed(ActionEvent e)
			throws Exception {

		VRList list = new VRArrayList();

		// 選択されたサービスにより異動事由コンボ（idouInfoChangeContent）に下記のCODE_IDの選択枝を設定する。
		VRMap map = (VRMap) getIdouInfoServise().getSelectedModelItem();

		if (map != null) {

			switch (ACCastUtilities.toInt(VRBindPathParser.get(
					"CHANGES_CONTENT_TYPE", map))) {

			// ・居宅系　CODE_ID：CODE_IDOU_CONTENT_KYOTAKU
			case IDOU_SERVICE_KYOTAKU:
				list = QkanCommon.getArrayFromMasterCode(
						CODE_IDOU_CONTENT_KYOTAKU, "CHANGES_CONTENT");
				break;

			// ・施設系1　CODE_ID：CODE_IDOU_CONTENT_SHISETSU1
			case IDOU_SERVICE_SHISETSU1:
				list = QkanCommon.getArrayFromMasterCode(
						CODE_IDOU_CONTENT_SHISETSU1, "CHANGES_CONTENT");
				break;

			// ・施設系2　CODE_ID：CODE_IDOU_CONTENT_SHISETSU2
			case IDOU_SERVICE_SHISETSU2:
				list = QkanCommon.getArrayFromMasterCode(
						CODE_IDOU_CONTENT_SHISETSU2, "CHANGES_CONTENT");
				break;

			// ・医療看護　CODE_ID：CODE_IDOU_CONTENT_IRYO_KANGO
			case IDOU_SERVICE_IRYO_KANGO:
				list = QkanCommon.getArrayFromMasterCode(
						CODE_IDOU_CONTENT_IRYO_KANGO, "CHANGES_CONTENT");
				break;

			// ・施設系3　CODE_ID：CODE_IDOU_CONTENT_SHISETSU3
			case IDOU_SERVICE_SHISETSU3:
				list = QkanCommon.getArrayFromMasterCode(
						CODE_IDOU_CONTENT_SHISETSU3, "CHANGES_CONTENT");
				break;
			}

			getIdouInfoChangeContent().setModel(list);

			// 異動領域初期化
			// クリア
			getIdouInfoDate().setText("");
			getIdouInfoTime().setText("");
			getIdouInfoReason().setModel(new VRArrayList());
			getIdouInfoReasonMemo().setText("");
			getIdouInfoReasonContainer().setText("理由/状況");
			// 異動領域の状態の初期化
			setState_IDOU_INIT();
			// 異動事由を有効にする。
			setState_ENABLE_CONTENT_TRUE();

		} else {
			// 異動領域の状態の初期化
			setState_IDOU_INIT();

		}
	}

	/**
	 * 「画面処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void idouInfoChangeContentActionPerformed(ActionEvent e)
			throws Exception {

		String caption = null;
		VRList list = new VRArrayList();

		VRMap service = (VRMap) getIdouInfoServise().getSelectedModelItem();
		VRMap content = (VRMap) getIdouInfoChangeContent()
				.getSelectedModelItem();

		// 選択された異動事由により異動理由コンボ（idouInfoReason）の
		// キャプションと選択枝を下記のとおりに設定する。
		if (service != null && content != null) {

			switch (ACCastUtilities.toInt(VRBindPathParser.get(
					"CHANGES_CONTENT_TYPE", service))) {

			case IDOU_SERVICE_KYOTAKU:
				// 居宅系サービスの場合
				if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_STOP_KYOTAKU) {
					// ・「中止」が選択された場合　
					// キャプション：「中止理由」　CODE_ID：CODE_IDOU_REASON_KYOTAKU
					caption = "中止理由";
					list = QkanCommon.getArrayFromMasterCode(
							CODE_IDOU_REASON_KYOTAKU, "CHANGES_REASON");
					// Enable制御を行う。
					// 異動理由コンボを有効にする。
					// ・状態ID：setState_ENABLE_REASON_TRUE
					setState_ENABLE_REASON_TRUE();
					break;
				} else {
					// 「中止」以外が選択された場合
					caption = "理由/状況";
					// Enable制御を行う。
					// 異動理由コンボを無効にする。
					// ・状態ID：setState_ENABLE_REASON_FALSE
					setState_ENABLE_REASON_FALSE();
					// その他テキストを非表示にする。
					// ・状態ID：setState_ENABLE_REASON_FALSE
					setState_VISIBLE_REASON_MEMO_FALSE();
					break;
				}

			case IDOU_SERVICE_SHISETSU1:
				// 施設系1サービスの場合
				if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_STOP_SHISETSU1) {
					// ・「退所」が選択された場合　
					// キャプション：「退所後の状況」　CODE_ID：CODE_IDOU_REASON_SHISETSU1
					caption = "退所後の状況";
					list = QkanCommon.getArrayFromMasterCode(
							CODE_IDOU_REASON_SHISETSU1, "CHANGES_REASON");
					// Enable制御を行う。
					// 異動理由コンボを有効にする。
					// ・状態ID：setState_ENABLE_REASON_TRUE
					setState_ENABLE_REASON_TRUE();
					break;

					// [ID:0000453][Shin Fujihara] 2009/02 add begin
					// 平成21年4月法改正対応
				} else if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_START_SHISETSU1) {
					caption = "入所前の状況";
					list = QkanCommon.getArrayFromMasterCode(
							CODE_IDOU_REASON_NYUSYO_NYUIN, "CHANGES_REASON");
					setState_ENABLE_REASON_TRUE();
					break;
					// [ID:0000453][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応

				} else {
					// 「退所」以外が選択された場合
					caption = "理由/状況";
					// Enable制御を行う。
					// 異動理由コンボを無効にする。
					// ・状態ID：setState_ENABLE_REASON_FALSE
					setState_ENABLE_REASON_FALSE();
					// その他テキストを非表示にする。
					// ・状態ID：setState_ENABLE_REASON_FALSE
					setState_VISIBLE_REASON_MEMO_FALSE();
					break;
				}

			case IDOU_SERVICE_SHISETSU2:
				// 施設系2サービスの場合
				if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_STOP_SHISETSU2) {
					// ・「退院」が選択された場合　
					// キャプション：「退院後の状況」　CODE_ID：CODE_IDOU_REASON_SHISETSU2
					caption = "退院後の状況";
					list = QkanCommon.getArrayFromMasterCode(
							CODE_IDOU_REASON_SHISETSU2, "CHANGES_REASON");
					// 異動理由コンボを有効にする。
					// ・状態ID：setState_ENABLE_REASON_TRUE
					setState_ENABLE_REASON_TRUE();
					break;

					// [ID:0000453][Shin Fujihara] 2009/02 add begin
					// 平成21年4月法改正対応
				} else if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_START_SHISETSU2) {
					caption = "入院前の状況";
					list = QkanCommon.getArrayFromMasterCode(
							CODE_IDOU_REASON_NYUSYO_NYUIN, "CHANGES_REASON");
					setState_ENABLE_REASON_TRUE();
					break;
					// [ID:0000453][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応

				} else {
					// 「退院」以外が選択された場合
					caption = "理由/状況";
					// Enable制御を行う。
					// 異動理由コンボを無効にする。
					// ・状態ID：setState_ENABLE_REASON_FALSE
					setState_ENABLE_REASON_FALSE();
					// その他テキストを非表示にする。
					// ・状態ID：setState_ENABLE_REASON_FALSE
					setState_VISIBLE_REASON_MEMO_FALSE();
					break;
				}

			case IDOU_SERVICE_IRYO_KANGO:
				// 医療看護の場合
				if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_STOP_IRYO_KANGO) {
					// ・「終了」が選択された場合　
					// キャプション：「終了の状況」　CODE_ID：CODE_IDOU_REASON_IRYO_KANGO
					caption = "終了の状況";
					list = QkanCommon.getArrayFromMasterCode(
							CODE_IDOU_REASON_IRYO_KANGO, "CHANGES_REASON");
					// Enable制御を行う。
					// 異動理由コンボを有効にする。
					// ・状態ID：setState_ENABLE_REASON_TRUE
					setState_ENABLE_REASON_TRUE();
					// 時間テキストを有効にする。
					// ・状態ID：ENABLE_TIME_TRUE
					setState_ENABLE_TIME_TRUE();
					break;
				} else {
					// 「終了」以外が選択された場合
					caption = "理由/状況";
					// Enable制御を行う。
					// 異動理由コンボを無効にする。
					// ・状態ID：setState_ENABLE_REASON_FALSE
					setState_ENABLE_REASON_FALSE();
					// 時間テキストを無効にする。
					// ・状態ID：ENABLE_TIME_FALSE
					setState_ENABLE_TIME_FALSE();
					// その他テキストを非表示にする。
					// ・状態ID：setState_ENABLE_REASON_FALSE
					setState_VISIBLE_REASON_MEMO_FALSE();
					break;
				}

			case IDOU_SERVICE_SHISETSU3:
				// 施設系3サービスの場合
				if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_STOP_SHISETSU3) {
					// ・「退居」が選択された場合　
					// キャプション：「退居後の状況」　CODE_ID：CODE_IDOU_REASON_SHISETSU3
					caption = "退居後の状況";
					list = QkanCommon.getArrayFromMasterCode(
							CODE_IDOU_REASON_SHISETSU3, "CHANGES_REASON");
					// 異動理由コンボを有効にする。
					// ・状態ID：setState_ENABLE_REASON_TRUE
					setState_ENABLE_REASON_TRUE();
					break;

					// [ID:0000453][Shin Fujihara] 2009/02 add begin
					// 平成21年4月法改正対応
				} else if (ACCastUtilities.toInt(VRBindPathParser.get(
						"CHANGES_CONTENT", content)) == IDOU_START_SHISETSU3) {
					caption = "入居前の状況";
					list = QkanCommon.getArrayFromMasterCode(
							CODE_IDOU_REASON_NYUSYO_NYUIN, "CHANGES_REASON");
					setState_ENABLE_REASON_TRUE();
					break;
					// [ID:0000453][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応

				} else {
					// 「退居」以外が選択された場合
					caption = "理由/状況";
					// Enable制御を行う。
					// 異動理由コンボを無効にする。
					// ・状態ID：setState_ENABLE_REASON_FALSE
					setState_ENABLE_REASON_FALSE();
					// その他テキストを非表示にする。
					// ・状態ID：setState_ENABLE_REASON_FALSE
					setState_VISIBLE_REASON_MEMO_FALSE();
					break;
				}
			}

			// キャプションの設定
			getIdouInfoReasonContainer().setText(caption);

			// コンボ候補の設定
			getIdouInfoReason().setModel(list);

		}

	}

	/**
	 * 「画面処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void idouInfoReasonActionPerformed(ActionEvent e)
			throws Exception {

		VRMap service = new VRHashMap();
		VRMap reason = new VRHashMap();

		if (getIdouInfoServise().getSelectedModelItem() == null
				|| "".equals(getIdouInfoServise().getSelectedModelItem())) {
			// サービスが選択されていない場合
			setState_VISIBLE_REASON_MEMO_FALSE();
			return;
		}

		if (getIdouInfoReason().getSelectedModelItem() == null
				|| "".equals(getIdouInfoReason().getSelectedModelItem())) {
			// 理由が選択されていない場合
			setState_VISIBLE_REASON_MEMO_FALSE();
			return;
		}

		service = (VRMap) getIdouInfoServise().getSelectedModelItem();
		reason = (VRMap) getIdouInfoReason().getSelectedModelItem();

		// 異動事由の種類
		int contentType = ACCastUtilities.toInt(VRBindPathParser.get(
				"CHANGES_CONTENT_TYPE", service));
		// 理由/状況の値
		int reasonValue = ACCastUtilities.toInt(VRBindPathParser.get(
				"CHANGES_REASON", reason));

		switch (contentType) {

		// 居宅系の場合
		case IDOU_SERVICE_KYOTAKU:
			if (reasonValue == IDOU_OTHER_KYOTAKU) {
				// 選択された異動理由が「その他」の場合
				// Visible制御を行う。
				setState_VISIBLE_REASON_MEMO_TRUE();
				break;
			} else {
				// 選択された異動理由が「その他」以外の場合
				setState_VISIBLE_REASON_MEMO_FALSE();
				break;
			}

			// 施設系1の場合
		case IDOU_SERVICE_SHISETSU1:
			if (reasonValue == IDOU_OTHER_SHISETSU1) {
				// 選択された異動理由が「その他」の場合
				// Visible制御を行う。
				setState_VISIBLE_REASON_MEMO_TRUE();
				break;
			} else {
				// 選択された異動理由が「その他」以外の場合
				setState_VISIBLE_REASON_MEMO_FALSE();
				break;
			}

			// 施設系2の場合
		case IDOU_SERVICE_SHISETSU2:
			if (reasonValue == IDOU_OTHER_SHISETSU2) {
				// 選択された異動理由が「その他」の場合
				// Visible制御を行う。
				setState_VISIBLE_REASON_MEMO_TRUE();
				break;
			} else {
				// 選択された異動理由が「その他」以外の場合
				setState_VISIBLE_REASON_MEMO_FALSE();
				break;
			}

			// 医療看護の場合
		case IDOU_SERVICE_IRYO_KANGO:
			if (reasonValue == IDOU_OTHER_IRYO_KANGO) {
				// 選択された異動理由が「その他」の場合
				// Visible制御を行う。
				setState_VISIBLE_REASON_MEMO_TRUE();
				break;
			} else {
				// 選択された異動理由が「その他」以外の場合
				setState_VISIBLE_REASON_MEMO_FALSE();
				break;
			}

			// 施設系3の場合
		case IDOU_SERVICE_SHISETSU3:
			if (reasonValue == IDOU_OTHER_SHISETSU3) {
				// 選択された異動理由が「その他」の場合
				// Visible制御を行う。
				setState_VISIBLE_REASON_MEMO_TRUE();
				break;
			} else {
				// 選択された異動理由が「その他」以外の場合
				setState_VISIBLE_REASON_MEMO_FALSE();
				break;
			}
		}

	}

	/**
	 * 「保険者名表示・支給限度額表示」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoInsurerIdFocusLost(FocusEvent e) throws Exception {

		String insurerId = getKaigoInfoInsurerId().getText();

		// 入力された保険者番号に該当する保険者が存在する場合
		VRMap map = (VRMap) getKaigoInfoInsurerName().getDataFromBindPath(
				insurerId);

		// 保険者名コンボ（kaigoInfoInsurerName）の該当保険者を選択状態にする。
		getKaigoInfoInsurerName().setSelectedItem(map);

		// 支給限度額を支給限度額テキストフィールド（kaigoInfoProvideLimit）に表示する。
		doFindLimitRate();

	}

	/**
	 * 「保険者番号表示・支給限度額表示」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoInsurerNameActionPerformed(ActionEvent e)
			throws Exception {

		// 選択された保険者の保険者番号を保険者番号フィールド（kaigoInfoInsurerId）
		// に表示する。
		VRMap map = (VRMap) getKaigoInfoInsurerName().getSelectedModelItem();

		if (VRBindPathParser.get("INSURER_ID", map) == null) {
			getKaigoInfoInsurerId().setText("");
		} else {
			getKaigoInfoInsurerId().setText(
					ACCastUtilities.toString(VRBindPathParser.get("INSURER_ID",
							map)));
		}

		// 支給限度額を支給限度額テキストフィールド（kaigoInfoProvideLimit）に表示する。
		doFindLimitRate();

	}

	/**
	 * 「画面処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoKyotakuServiceRadioSelectionChanged(
			ListSelectionEvent e) throws Exception {

		switch (getKaigoInfoKyotakuServiceRadio().getSelectedIndex()) {
		case 1:
			// 居宅介護支援事業所（kaigoInfoKyotakuServiceRadioItem1）が選択された場合
			// Enable制御を行う。
			// ・状態ID：ENABLE_SHIEN_TRUE
			setState_ENABLE_SHIEN_TRUE();
			// 居宅サービス計画作成者・コンボ（kaigoInfoKyotakuServicePlanCombo）の候補として、providerListKaigoShienを設定する。
			getKaigoInfoKyotakuServicePlanCombo().setModel(
					getProviderListKaigoShien());
			break;
		case 2:
			// 被保険者（kaigoInfoKyotakuServiceRadioItem2）が選択された場合
			// Enable制御を行う。
			// ・状態ID：ENABLE_SHIEN_FALSE
			setState_ENABLE_SHIEN_FALSE();
			break;
		case 3:
			// 居宅介護支援事業所（kaigoInfoKyotakuServiceRadioItem1）が選択された場合
			// Enable制御を行う。
			// ・状態ID：ENABLE_SHIEN_TRUE
			setState_ENABLE_SHIEN_TRUE();
			// 居宅サービス計画作成者・コンボ（kaigoInfoKyotakuServicePlanCombo）の候補として、providerListYobouShienを設定する。
			getKaigoInfoKyotakuServicePlanCombo().setModel(
					getProviderListYobouShien());
			break;
		default:
			setState_ENABLE_SHIEN_FALSE();
		}
	}

	/**
	 * 「支給限度額表示」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoYokaigoInfoActionPerformed(ActionEvent e)
			throws Exception {

		// 支給限度額を支給限度額テキストフィールド（kaigoInfoProvideLimit）に表示する。
		doFindLimitRate();

		doFindExternalUseLimit();
		
		// 2016/7/18 [Yoichiro Kamei] add - begin 総合事業対応 事業対象者の限度額変更フラグ
		doCheckLimitChange();
		// 2016/7/18 [Yoichiro Kamei] add - end
	}

	/**
	 * 「支給限度額表示」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoValidLimit1FocusLost(FocusEvent e) throws Exception {

		// 支給限度額を支給限度額テキストフィールド（kaigoInfoProvideLimit）に表示する。
		doFindLimitRate();

		doFindExternalUseLimit();
		
	}

	/**
	 * 「支給限度額表示」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoValidLimit3FocusLost(FocusEvent e) throws Exception {

		// 支給限度額を支給限度額テキストフィールド（kaigoInfoProvideLimit）に表示する。
		doFindLimitRate();

		doFindExternalUseLimit();

	}

	/**
	 * 「年齢表示」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void basicInfoBirthFocusLost(FocusEvent e) throws Exception {

		// 年齢を表示する。
		VRMap map = new VRHashMap();

		if (ACTextUtilities.isNullText(getBasicInfoBirth().getText())) {
			// 空白の場合
			VRBindPathParser.set("PATIENT_BIRTHDAY", map, "");
		} else if (!getBasicInfoBirth().isValidDate()) {
			// 存在しない日付の場合
			VRBindPathParser.set("PATIENT_BIRTHDAY", map, "");
		} else {
			// 正しく入力されている場合
			VRBindPathParser.set("PATIENT_BIRTHDAY", map, getBasicInfoBirth()
					.getDate());
		}

		// 表示
		getBasicInfoAge().setSource(map);
		getBasicInfoAge().bindSource();

	}

	/**
	 * 「画面処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void institutionInfoTokuteiNyushoActionPerformed(ActionEvent e)
			throws Exception {

		if (getShisetsuInfoTokuteiCheck().isSelected()) {
			// 選択されている場合
			setState_ENABLE_TOKUTEI_NYUSHO_TRUE();
		} else {
			// 選択されていない場合
			setState_ENABLE_TOKUTEI_NYUSHO_FALSE();
		}
	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();

		// param.setData("PATIENT_ID", new Integer(10));
		param.setData("PROCESS_MODE", new Integer(
				QkanConstants.PROCESS_MODE_INSERT));

		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QU002.class.getName(), param));
	}

	// 内部関数

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean isValidInputPatient() throws Exception {

		// 利用者基本情報の入力チェックを行う。

		// メッセージ表示用
		String msgParam = null;

		// 氏名のチェック
		// ・basicInfoName1（氏）　
		// ・basicInfoName2（名）　※氏名はどちらか一方に入力されていれば可
		// ※エラーの場合、String：msgParamを宣言し、"氏名"を代入する。
		if (ACTextUtilities.isNullText(getBasicInfoName1().getText())
				&& ACTextUtilities.isNullText(getBasicInfoName2().getText())) {
			getBasicInfoName1().requestFocus();
			msgParam = "氏名";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam);
			return false;
		}

		// ふりがなのチェック
		// ・basicInfoFurigana1（ふりがな氏）
		// ・basicInfoFurigana2（ふりがな名）　※ふりがなも氏名と同様どちらか一方に入力されていれば可
		// ※エラーの場合、String：msgParamを宣言し、"ふりがな"を代入する。
		if (ACTextUtilities.isNullText(getBasicInfoFurigana1().getText())
				&& ACTextUtilities
						.isNullText(getBasicInfoFurigana2().getText())) {
			getBasicInfoFurigana1().requestFocus(); // フォーカス
			msgParam = "ふりがな";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam);
			return false;
		}

		// 性別のチェック
		// ・basicInfoSexs（性別）

		// ※エラーの場合、String：msgParamを宣言し、"性別"を代入する。
		if (!getBasicInfoSexs().isSelected()) {
			getBasicInfoSexs().requestFocus(); // フォーカス
			msgParam = "性別";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					msgParam);
			return false;
		}

		// 生年月日のチェック
		// ・basicInfoBirth（生年月日）
		// 未入力かどうか
		// ※エラーの場合、String：msgParamを宣言し、"生年月日"を代入する。
		if (ACTextUtilities.isNullText(getBasicInfoBirth().getText())) {
			getBasicInfoBirth().requestFocus(); // フォーカス
			msgParam = "生年月日";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					msgParam);
			return false;
		}
		// 存在しない日付かどうか
		// ※エラーの場合、String：msgParamを宣言し、"生年月日の"を代入する。
		if (!getBasicInfoBirth().isValidDate()) {
			getBasicInfoBirth().requestFocus(); // フォーカス
			msgParam = "生年月日の";
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam);
			return false;
		}
		// 未来の日付かどうか
		// ※エラーの場合、String：msgParamを宣言し、"生年月日に"を代入する。
		Date nowDate = new Date(); // 現在日付
		Date birth = getBasicInfoBirth().getDate(); // 生年月日
		if (ACDateUtilities.getDifferenceOnDay(nowDate, birth) < 0) {
			getBasicInfoBirth().requestFocus(); // フォーカス
			msgParam = "生年月日に";
			QkanMessageList.getInstance().ERROR_OF_FUTURE_DATE(msgParam);
			return false;
		}

		// 施設情報領域
		// ※特定施設入所者チェックがONの場合のみチェックする。
		if (getShisetsuInfoTokuteiCheck().isSelected()) {
			// 未入力でないかチェックする。
			// ・institutionInfoDinnerBearLimitMoneyText
			// ※エラーの場合、String：msgParamを宣言し、"負担限度額"を代入する。
			if (ACTextUtilities
					.isNullText(getShisetsuInfoDinnerBearLimitMoneyText()
							.getText())) {
				getShisetsuInfoDinnerBearLimitMoneyText().requestFocus();
				msgParam = "負担限度額";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam);
				return false;
			}

			// ・institutionInfoUnitRoomLimitMoneyText
			// ※エラーの場合、String：msgParamを宣言し、"負担限度額"を代入する。
			if (ACTextUtilities
					.isNullText(getShisetsuInfoUnitRoomLimitMoneyText()
							.getText())) {
				getShisetsuInfoUnitRoomLimitMoneyText().requestFocus();
				msgParam = "負担限度額";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam);
				return false;
			}

			// ・institutionInfoUnitSemiRoomLimitMoneyText
			// ※エラーの場合、String：msgParamを宣言し、"負担限度額"を代入する。
			if (ACTextUtilities
					.isNullText(getShisetsuInfoUnitSemiRoomLimitMoneyText()
							.getText())) {
				getShisetsuInfoUnitSemiRoomLimitMoneyText().requestFocus();
				msgParam = "負担限度額";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam);
				return false;
			}

			// ・institutionInfoNormalRoomLimitMoneyText
			// ※エラーの場合、String：msgParamを宣言し、"負担限度額"を代入する。
			if (ACTextUtilities
					.isNullText(getShisetsuInfoNormalRoomLimitMoneyText()
							.getText())) {
				getShisetsuInfoNormalRoomLimitMoneyText().requestFocus();
				msgParam = "負担限度額";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam);
				return false;
			}

			// ・institutionInfoNormalRoomLimitMoneyText2
			// ※エラーの場合、String：msgParamを宣言し、"負担限度額"を代入する。
			if (ACTextUtilities
					.isNullText(getShisetsuInfoNormalRoomLimitMoneyText2()
							.getText())) {
				getShisetsuInfoNormalRoomLimitMoneyText2().requestFocus();
				msgParam = "負担限度額";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam);
				return false;
			}

			// ・institutionInfoTasyoRoomLimitMoneyText
			// ※エラーの場合、String：msgParamを宣言し、"負担限度額"を代入する。
			if (ACTextUtilities
					.isNullText(getShisetsuInfoTasyoRoomLimitMoneyText()
							.getText())) {
				getShisetsuInfoTasyoRoomLimitMoneyText().requestFocus();
				msgParam = "負担限度額";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam);
				return false;
			}

			// ・institutionInfoTasyoRoomLimitMoneyText2
			// ※エラーの場合、String：msgParamを宣言し、"負担限度額"を代入する。
			if (ACTextUtilities
					.isNullText(getShisetsuInfoTasyoRoomLimitMoneyText2()
							.getText())) {
				getShisetsuInfoTasyoRoomLimitMoneyText2().requestFocus();
				msgParam = "負担限度額";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam);
				return false;
			}

		}

		// 入力チェックエラーが発生しなかった場合
		// 　戻り値としてtrueを返す。
		return true;

	}

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean isValidInputIdou() throws Exception {
		// 異動情報の入力チェックを行う。

		String msgParam = null;

		// サービスのチェック
		// ・idouInfoServise（サービス）
		// 選択されているかどうか
		// ※エラーの場合、String：msgParamを宣言し、"サービス"を代入する。
		if (!getIdouInfoServise().isSelected()) {
			getIdouInfoServise().requestFocus();
			msgParam = "サービス";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					msgParam);
			return false;
		}

		// 異動事由のチェック
		// ・idouInfoChangeContent（異動事由）
		// 選択されているかどうか
		// ※エラーの場合、String：msgParamを宣言し、"異動事由"を代入する。
		if (!getIdouInfoChangeContent().isSelected()) {
			getIdouInfoChangeContent().requestFocus();
			msgParam = "異動事由";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					msgParam);
			return false;
		}

		// 日付のチェック
		// ・idouInfoDate（日付）
		// 入力されているかどうか
		// ※エラーの場合、String：msgParamを宣言し、"日付"を代入する。
		if (ACTextUtilities.isNullText(getIdouInfoDate().getText())) {
			getIdouInfoDate().requestFocus();
			msgParam = "日付";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam);
			return false;
		}
		// 存在する日付かどうか
		// ※エラーの場合、String：msgParamを宣言し、"日付の"を代入する。
		if (!getIdouInfoDate().isValidDate()) {
			getIdouInfoDate().requestFocus();
			msgParam = "日付の";
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam);
			return false;
		}

		// [ID:0000582][Masahiko Higuchi] 2010/01 add begin
		// 利用者情報詳細・異動情報の追加・編集時のチェック機能
		// 状況コードの入力チェック
		// ・idouInfoReason
		VRMap service = (VRMap) getIdouInfoServise().getSelectedModelItem();
		if (service != null) {
			int systemServiceKindDetail = ACCastUtilities
					.toInt(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
							service), 0);
			// 施設系/順施設系のサービスにおいては状況の入力を必須とする。
			if (CareServiceCommon.isFacility(systemServiceKindDetail)
					|| CareServiceCommon.isLifeCare(systemServiceKindDetail)) {
				// 理由/状況が未選択もしくは、選択項目が空白である場合
				if (!(getIdouInfoReason().isSelected())
						|| !(getIdouInfoReason().getSelectedModelItem() instanceof VRMap)) {
					VRMap idou = (VRMap) getIdouInfoChangeContent()
							.getSelectedModelItem();
					// 異動情報の選択を行っている場合
					int codeId = ACCastUtilities.toInt(idou.getData("CODE_ID"),
							0);
					boolean isIdouReasonCheck = false;
					// 施設系のみチェック対象とする
					switch (codeId) {
					case CODE_IDOU_CONTENT_SHISETSU1:
						isIdouReasonCheck = true;
						break;
					case CODE_IDOU_CONTENT_SHISETSU2:
						isIdouReasonCheck = true;
						break;
					case CODE_IDOU_CONTENT_SHISETSU3:
						isIdouReasonCheck = true;
						break;
					}
					// 施設系は状況コードをチェックする。
					if (isIdouReasonCheck) {
						// 選択されている履歴のチェック
						getIdouInfoReason().requestFocus();
						// コンテナから名称取得
						msgParam = getIdouInfoReasonContainer().getText();
						QkanMessageList.getInstance()
								.ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam);
						return false;
					}
				}
			}
		}
		// [ID:0000582][Masahiko Higuchi] 2010/01 add end

		// 入力チェックエラーが発生しなかった場合
		// 戻り値としてtrueを返す。
		return true;

	}

	/**
	 * 「支給限度額表示」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindLimitRate() throws Exception {

		// 支給限度額を取得する。
		int limitRate = getLimitRate();

		// 取得した支給限度額の値が‐1の場合
		if (limitRate == -1) {
			// 画面上の支給限度額テキストを空にする。
			getKaigoInfoProvideLimit().setText("");
			return;
		}

		// 取得した支給限度額を支給限度額テキストフィールド
		// （kaigoInfoProvideLimit）に表示する。
		getKaigoInfoProvideLimit().setText(ACCastUtilities.toString(limitRate));

	}

	/**
	 * 「支給限度額取得」に関する処理を行ないます。
	 * 
	 * @return limitRate 支給限度額
	 * @throws Exception
	 *             処理例外
	 */
	public int getLimitRate() throws Exception {

		// 戻り値
		int limitRate = -1;

		// 入力チェックを行い、支給限度額を取得するために必要な引数を取得し、
		// VRMap paramに格納する。
		VRMap param = getParamForLimitRate();

		if (param != null) {
			// 引数を取得できた場合（param <> null）

			// 支給限度額を取得する。
			// ※介護保険の有効期間と保険者の支給限度額有効期間を比較し、有効な支給限度額を表示する。
			// ※有効な支給限度額が複数ある場合は、最新（LIMIT_RATE_HISTORY_IDの大きい）の支給限度額を表示する。
			VRBindPathParser.set("LIMIT_RATE_TYPE", param, new Integer(1));
			String strSql = null;
			strSql = getSQL_GET_INSURER_LIMIT_RATE(param);
			VRList list = getDBManager().executeQuery(strSql);

			if (list == null || list.size() == 0) {
				// 取得したデータ件数が0件の場合
				// 厚生労働省規定の支給限度額を取得する。
				
				// 2016/9/27 [Shinobu Hitaka] add - begin 総合事業対応
				// 事業対象者の支給限度額超の場合は、要支援２の支給限度額とする
				int jotaiCode = ACCastUtilities.toInt(VRBindPathParser.get("JOTAI_CODE", param), -1);
				if (jotaiCode == QkanConstants.YOUKAIGODO_JIGYOTAISHO_OVER_LIMIT) {
					VRBindPathParser.set("JOTAI_CODE", param, QkanConstants.YOUKAIGODO_YOUSHIEN2);
				}
				// 2016/9/27 [Shinobu Hitaka] add - end
				
				strSql = getSQL_GET_OFFICIAL_LIMIT_RATE(param);
				list = getDBManager().executeQuery(strSql);

				// 取得した支給限度額テキストフィールド（kaigoInfoProvideLimit）に表示する。
				if (!(list == null || list.size() == 0)) {
					limitRate = ACCastUtilities.toInt(VRBindPathParser.get(
							"LIMIT_RATE_VALUE", (VRMap) list.get(0)));
				}

			} else {
				// 保険者の支給限度額を設定する。
				limitRate = ACCastUtilities.toInt(VRBindPathParser.get(
						"LIMIT_RATE_VALUE", (VRMap) list.get(0)));
			}

		}

		return limitRate;

	}

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * 
	 * @return param 支給限度額取得に必要な値
	 * @throws Exception
	 *             処理例外
	 */
	public VRMap getParamForLimitRate() throws Exception {

		// 支給限度額情報取得用の入力チェックを行う。

		// 保険者名のチェック
		// ・kaigoInfoInsurerName（保険者名）
		// 選択されているかどうか
		if (!getKaigoInfoInsurerName().isSelected()) {
			// 選択されていない場合
			return null;
		}

		// 要介護情報のチェック
		// ・kaigoInfoYokaigoInfo（要介護情報）
		// 選択されているかどうか
		if (!getKaigoInfoYokaigoInfo().isSelected()) {
			// 選択されていない場合
			return null;
		}

		// 有効期間開始日のチェック
		// ・kaigoInfoValidLimit1（有効期間開始日）
		// 入力されているかどうか
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit1().getText())) {
			// 入力されていない場合
			return null;
		}

		// 存在しない日付が入力されていないかどうか
		if (!getKaigoInfoValidLimit1().isValidDate()) {
			// 存在しない日付が入力されている場合
			return null;
		}

		
// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//		// 有効期間終了日のチェック
//		// ・kaigoInfoValidLimit3（有効期間終了日）
//		// 入力されているかどうか
//		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
//			// 入力されていない場合
//			return null;
//		}
//
//		// 存在しない日付が入力されていないかどうか
//		if (!getKaigoInfoValidLimit3().isValidDate()) {
//			// 存在しない日付が入力されている場合
//			return null;
//		}
		
		
		// 要介護度に事業対象者が選択されているかどうか
		boolean isJigyotaisho = isJigyotaisho();
		if (!isJigyotaisho) {
			// 入力されているかどうか
			if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
				// 入力されていない場合
				return null;
			}
	
			// 存在しない日付が入力されていないかどうか
			if (!getKaigoInfoValidLimit3().isValidDate()) {
				// 存在しない日付が入力されている場合
				return null;
			}
		} else {
			if (!ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
				// 存在しない日付が入力されていないかどうか
				if (!getKaigoInfoValidLimit3().isValidDate()) {
					// 存在しない日付が入力されている場合
					return null;
				}
			}
		}
		
// 2016/7/5 [Yoichiro Kamei] mod - end
				


		// 有効期間の前後関係が誤っていないかどうか
		// ・kaigoInfoValidLimit1（有効期間開始日）
		// ・kaigoInfoValidLimit2（有効期間終了日）
		Date start = getKaigoInfoValidLimit1().getDate();
// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//		Date end = getKaigoInfoValidLimit3().getDate();
		Date end;
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
		    end = MAX_DATE;
		} else {
		    end = getKaigoInfoValidLimit3().getDate();
		}
// 2016/7/5 [Yoichiro Kamei] mod - end

		if (ACDateUtilities.getDifferenceOnDay(start, end) > 0) {
			// 前後関係が誤っている場合
			return null;
		}

		// エラーがなかった場合
		// 以下の値をVRMap mapに設定する。
		// ・kaigoInfoInsurerId（保険者番号）　KEY：INSURER_ID
		// ・kaigoInfoYokaigoInfo（要介護情報）　KEY：JOTAI_CODE
		// ・kaigoInfoValidLimit1（有効期間開始）　KEY：VALID_START
		// ・kaigoInfoValidLimit3（有効期間終了）　KEY：VALID_END
		VRMap param = new VRHashMap();
		VRBindPathParser.set("INSURER_ID", param, getKaigoInfoInsurerId()
				.getText());
		VRMap yokaigo = (VRMap) getKaigoInfoYokaigoInfo()
				.getSelectedModelItem();
		
// 2016/7/18 [Yoichiro Kamei] add - begin 総合事業対応 事業対象者の限度額変更フラグ
//		VRBindPathParser.set("JOTAI_CODE", param,
//				VRBindPathParser.get("JOTAI_CODE", yokaigo));
		int jotaiCode = ACCastUtilities.toInt(VRBindPathParser.get("JOTAI_CODE", yokaigo), -1);
		// 事業対象者で「要支援１の額を超えてサービスを利用」のチェック有の場合
		// 要支援２の基準額を表示
		if (isJigyotaisho) {
			if (getKaigoInfoLimitChange().isSelected()) {
				// 2016/9/27 [Shinobu Hitaka] mod 保険者支給限度額マスタ追加に伴い修正
				//jotaiCode = QkanConstants.YOUKAIGODO_YOUSHIEN2;
				jotaiCode = QkanConstants.YOUKAIGODO_JIGYOTAISHO_OVER_LIMIT;
			}
		}
		VRBindPathParser.set("JOTAI_CODE", param, jotaiCode);
// 2016/7/18 [Yoichiro Kamei] add - end

		VRBindPathParser.set("VALID_START", param, getKaigoInfoValidLimit1()
				.getDate());
		
// 2016/7/5 [Yoichiro Kamei] add - begin 総合事業対応
//		VRBindPathParser.set("VALID_END", param, getKaigoInfoValidLimit3()
//				.getDate());
		VRBindPathParser.set("VALID_END", param, end);
// 2016/7/5 [Yoichiro Kamei] add - end

		// 戻り値としてmapを返す。
		return param;
	}

	// 2016/7/5 [Yoichiro Kamei] add - begin 総合事業対応
	// 介護保険情報の「要介護度」に事業対象者が選択されているかどうか
	private boolean isJigyotaisho() throws Exception {
		boolean isJigyotaisho = false;
		if (getKaigoInfoYokaigoInfo().isSelected()) {
			VRMap temp = (VRMap) getKaigoInfoYokaigoInfo()
		            .getSelectedModelItem();
			int jotaiCode = ACCastUtilities.toInt(VRBindPathParser.get(
		            "JOTAI_CODE", temp));
			if (jotaiCode == QkanConstants.YOUKAIGODO_JIGYOTAISHO) {
				isJigyotaisho = true;
			}
		}
		return isJigyotaisho;
	}
	// 2016/7/5 [Yoichiro Kamei] add - begin
			
			
	/**
	 * 「外部利用型上限単位数表示」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindExternalUseLimit() throws Exception {

		// 外部利用型上限単位数を取得する。
		int externalUseLimit = getExternalUseLimit();

		// 取得した外部利用型上限単位数の値が‐1の場合
		if (externalUseLimit == -1) {
			// 画面上の外部利用型上限単位数テキストを空にする。
			getKaigoInfoExternalUseLimit().setText("");
			return;
		}

		// 取得した外部利用型上限単位数を外部利用型上限単位数テキストフィールド
		// （kaigoInfoExternalUseLimit）に表示する。
		getKaigoInfoExternalUseLimit().setText(
				ACCastUtilities.toString(externalUseLimit));

	}

	/**
	 * 「外部利用型上限単位数取得」に関する処理を行ないます。
	 * 
	 * @return externalUseLimit 外部利用型上限単位数
	 * @throws Exception
	 *             処理例外
	 */
	public int getExternalUseLimit() throws Exception {

		// 戻り値
		int externalUseLimit = -1;

		// 入力チェックを行い、外部利用型上限単位数を取得するために必要な引数を取得し、
		// VRMap paramに格納する。
		VRMap param = getParamForExternalUseLimit();

		if (param != null) {
			// 引数を取得できた場合（param <> null）

			// 外部利用型上限単位数を取得する。
			// ※介護保険の有効期間とマスタの有効期間を比較し、有効な外部利用型上限単位数を表示する。
			// ※有効な外部利用型上限単位数が複数ある場合は、最新（LIMIT_RATE_HISTORY_IDの大きい）の
			// 外部利用型上限単位数を表示する。
			VRBindPathParser.set("LIMIT_RATE_TYPE", param, new Integer(2));
			String strSql = null;
			strSql = getSQL_GET_OFFICIAL_LIMIT_RATE(param);
			VRList list = getDBManager().executeQuery(strSql);

			if (!(list == null || list.size() == 0)) {
				// 外部利用型上限単位数を設定する。
				externalUseLimit = ACCastUtilities.toInt(VRBindPathParser.get(
						"LIMIT_RATE_VALUE", (VRMap) list.get(0)));
			}

		}

		return externalUseLimit;
	}

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * 
	 * @return param 外部利用型上限単位数取得に必要な値
	 * @throws Exception
	 *             処理例外
	 */
	public VRMap getParamForExternalUseLimit() throws Exception {

		// 外部利用型上限単位数取得用の入力チェックを行う。

		// 要介護情報のチェック
		// ・kaigoInfoYokaigoInfo（要介護情報）
		// 選択されているかどうか
		if (!getKaigoInfoYokaigoInfo().isSelected()) {
			// 選択されていない場合
			return null;
		}

		// 有効期間開始日のチェック
		// ・kaigoInfoValidLimit1（有効期間開始日）
		// 入力されているかどうか
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit1().getText())) {
			// 入力されていない場合
			return null;
		}

		// 存在しない日付が入力されていないかどうか
		if (!getKaigoInfoValidLimit1().isValidDate()) {
			// 存在しない日付が入力されている場合
			return null;
		}

		
		// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//		// 有効期間終了日のチェック
//		// ・kaigoInfoValidLimit3（有効期間終了日）
//		// 入力されているかどうか
//		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
//			// 入力されていない場合
//			return null;
//		}
//
//		// 存在しない日付が入力されていないかどうか
//		if (!getKaigoInfoValidLimit3().isValidDate()) {
//			// 存在しない日付が入力されている場合
//			return null;
//		}
		
		
		// 要介護度に事業対象者が選択されているかどうか
		boolean isJigyotaisho = isJigyotaisho();
		if (!isJigyotaisho) {
			// 入力されているかどうか
			if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
				// 入力されていない場合
				return null;
			}
	
			// 存在しない日付が入力されていないかどうか
			if (!getKaigoInfoValidLimit3().isValidDate()) {
				// 存在しない日付が入力されている場合
				return null;
			}
		} else {
			if (!ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
				// 存在しない日付が入力されていないかどうか
				if (!getKaigoInfoValidLimit3().isValidDate()) {
					// 存在しない日付が入力されている場合
					return null;
				}
			}
		}
		
// 2016/7/5 [Yoichiro Kamei] mod - end
		
		// 有効期間の前後関係が誤っていないかどうか
		// ・kaigoInfoValidLimit1（有効期間開始日）
		// ・kaigoInfoValidLimit2（有効期間終了日）
		Date start = getKaigoInfoValidLimit1().getDate();
		
// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//		Date end = getKaigoInfoValidLimit3().getDate();
		Date end;
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
		    end = MAX_DATE;
		} else {
		    end = getKaigoInfoValidLimit3().getDate();
		}
// 2016/7/5 [Yoichiro Kamei] mod - end

		if (ACDateUtilities.getDifferenceOnDay(start, end) > 0) {
			// 前後関係が誤っている場合
			return null;
		}

		// エラーがなかった場合
		// 以下の値をVRMap mapに設定する。
		// ・kaigoInfoYokaigoInfo（要介護情報）　KEY：JOTAI_CODE
		// ・kaigoInfoValidLimit1（有効期間開始）　KEY：VALID_START
		// ・kaigoInfoValidLimit3（有効期間終了）　KEY：VALID_END
		VRMap param = new VRHashMap();
		VRMap yokaigo = (VRMap) getKaigoInfoYokaigoInfo()
				.getSelectedModelItem();
		VRBindPathParser.set("JOTAI_CODE", param,
				VRBindPathParser.get("JOTAI_CODE", yokaigo));
		VRBindPathParser.set("VALID_START", param, getKaigoInfoValidLimit1()
				.getDate());

// 2016/7/5 [Yoichiro Kamei] add - begin 総合事業対応
//		VRBindPathParser.set("VALID_END", param, getKaigoInfoValidLimit3()
//				.getDate());
		VRBindPathParser.set("VALID_END", param, end);
// 2016/7/5 [Yoichiro Kamei] add - end
		
		// 戻り値としてmapを返す。
		return param;
	}

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * 
	 * @param checkMode
	 *            1：追加モード　2：編集モード
	 * @throws Exception
	 *             処理例外
	 */
	public boolean isValidInputKaigo(int checkMode) throws Exception {
		// 介護保険情報の入力チェックを行う。

		// フラグ
		int doUpdateFlg = 0;

		// メッセージ表示用
		String msgParam1 = null;
		String msgParam2 = null;
		String msgParam3 = null;

		// 登録されている履歴の有効期間
		Date reservedStart = null;
		Date reservedEnd = null;

// 2016/7/5 [Yoichiro Kamei] add - begin 総合事業対応
		// 要介護度に事業対象者が選択されているかどうか
		boolean isJigyotaisho = isJigyotaisho();
// 2016/7/5 [Yoichiro Kamei] add - begin
        
		if (getNonCorrespondenceFlg() == 0) { // ※要介護度-非該当の場合は処理を通らない。
			// 保険者番号のチェック
			// ・kaigoInfoInsurerId（保険者番号）
			// 入力されているかどうか
			// ※エラーの場合、String：msgParam1を宣言し、"保険者番号"を代入する。
			if (ACTextUtilities.isNullText(getKaigoInfoInsurerId().getText())) {
				getKaigoInfoInsurerId().requestFocus(); // フォーカス
				msgParam1 = "保険者番号";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
			// // 桁数が6桁かどうか
			// // ※エラーの場合、String：msgParam1を宣言し、"保険者番号"を代入する。
			// // ※エラーの場合、String：msgParam2を宣言し、"6"を代入する。
			// String insurerId = getKaigoInfoInsurerId().getText();
			// if(insurerId.length() != 6){
			// getKaigoInfoInsurerId().requestFocus(); // フォーカス
			// msgParam1 = "保険者番号";
			// msgParam2 = "6";
			// QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
			// msgParam2);
			// return false;
			// }

			// 保険者名のチェック
			// ・kaigoInfoInsurerName（保険者名）
			// 選択されているかどうか
			// ※エラーの場合、String：msgParam1を宣言し、"保険者名"を代入する。
			if (!getKaigoInfoInsurerName().isSelected()) {
				getKaigoInfoInsurerName().requestFocus(); // フォーカス
				msgParam1 = "保険者名";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
						msgParam1);
				return false;
			}

			// 被保険者番号のチェック
			// ・kaigoInfoInsuredId（被保険者番号）
			// 入力されているかどうか
			// ※エラーの場合、String：msgParam1を宣言し、"被保険者番号"を代入する。
			if (ACTextUtilities.isNullText(getKaigoInfoInsuredId().getText())) {
				getKaigoInfoInsuredId().requestFocus(); // フォーカス
				msgParam1 = "被保険者番号";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
			// 桁数が10桁かどうか
			// ※エラーの場合、String：msgParam1を宣言し、"被保険者番号"を代入する。
			// ※エラーの場合、String：msgParam2を宣言し、"10"を代入する。
			if (getKaigoInfoInsuredId().getText().length() != 10) {
				getKaigoInfoInsuredId().requestFocus(); // フォーカス
				msgParam1 = "被保険者番号";
				msgParam2 = "10";
				QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
						msgParam2);
				return false;
			}

			// 給付率のチェック
			// ・kaigoInfoBenefit（給付率）
			// 入力されているかどうか
			// ※エラーの場合、String：msgParam1を宣言し、"給付率"を代入する。
			if (ACTextUtilities.isNullText(getKaigoInfoBenefit().getText())) {
				getKaigoInfoBenefit().requestFocus(); // フォーカス
				msgParam1 = "給付率";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// 給付率に入力されている値が不正でないかどうか
			int benefitRate = ACCastUtilities.toInt(getKaigoInfoBenefit()
					.getText());
			if (benefitRate < 0 || benefitRate > 100) {
				getKaigoInfoBenefit().requestFocus(); // フォーカス
				msgParam1 = "給付率";
				msgParam2 = "100";
				QkanMessageList.getInstance().ERROR_OF_VALUE_TOO_MUCH(
						msgParam1, msgParam2);
				return false;
			}

			// 被保険者番号
			String insuredId = getKaigoInfoInsuredId().getText();
			// 給付率
			int insureRate = ACCastUtilities.toInt(getKaigoInfoBenefit()
					.getText(), 0);

			if (insuredId.charAt(0) != 'H') {
				if (insureRate == INSURE_RATE_SEIHO) {
					// 生保単独でない時に給付率が「0%」と設定されていた場合
					getKaigoInfoBenefit().requestFocus(); // フォーカス
					QkanMessageList.getInstance()
							.QU002_ERROR_OF_RATE_FOR_NOT_SEIHO_TANDOKU();
					return false;
				}
			}

			// 居宅サービス計画作成者のチェック
			// ・kaigoInfoKyotakuServiceRadio（居宅サービス計画作成者）
			// // 選択されているかどうか
			// // ※エラーの場合、String：msgParamを宣言し、"居宅サービス計画作成者"を代入する。
			// if(!getKaigoInfoKyotakuServiceRadio().isSelected()){
			// getKaigoInfoKyotakuServiceRadio().requestFocus(); // フォーカス
			// msgParam1 = "居宅サービス計画作成者";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
			// return false;
			// }

			// 支援事業所のチェック　※居宅サービス作成者で居宅介護支援事業所が選択されている場合のみ
			// ・kaigoInfoKyotakuServicePlanCombo（居宅介護支援事業所）
			// ※エラーの場合、String：msgParamを宣言し、"居宅介護支援事業所"を代入する。
			if (getKaigoInfoKyotakuServiceRadio().getSelectedIndex() == INDEX_OF_PROVIDER_SHIEN
					|| getKaigoInfoKyotakuServiceRadio().getSelectedIndex() == INDEX_OF_PROVIDER_YOBOU_SHIEN) {
				if (!getKaigoInfoKyotakuServicePlanCombo().isSelected()) {
					getKaigoInfoKyotakuServicePlanCombo().requestFocus(); // フォーカス
					// msgParam1 = "居宅介護支援事業所";
					// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
					QkanMessageList.getInstance()
							.QU002_ERROR_OF_NO_DATA_SHIEN_PROVIDER();
					return false;
				}
			}

			// 申請区分のチェック
			// 選択されているかどうか
			// ・kaigoInfoRequestDivisionRadio（申請区分）
			// ※エラーの場合、String：msgParamを宣言し、"申請区分"を代入する。
			if (!getKaigoInfoRequestDivisionRadio().isSelected()) {
				getKaigoInfoRequestDivisionRadio().requestFocus(); // フォーカス
				msgParam1 = "申請区分";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
						msgParam1);
				return false;
			}

			// 要介護情報のチェック
			// 選択されているかどうか
			// ・kaigoInfoYokaigoInfo（要介護情報）
			// ※エラーの場合、String：msgParamを宣言し、"要介護情報"を代入する。
			if (!getKaigoInfoYokaigoInfo().isSelected()) {
				getKaigoInfoYokaigoInfo().requestFocus(); // フォーカス
				msgParam1 = "要介護情報";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
						msgParam1);
				return false;
			}

		}

		// 届出日のチェック　※入力されている場合のみ
		// ・kaigoInfoReportDate（届出日）
		// 存在する日付が入力されているかどうか
		// ※エラーの場合、String：msgParamを宣言し、"届出日の"を代入する。
		if (!ACTextUtilities.isNullText(getKaigoInfoReportDate().getText())) {
			if (!getKaigoInfoReportDate().isValidDate()) {
				getKaigoInfoReportDate().requestFocus(); // フォーカス
				msgParam1 = "届出日の";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		// 申請日のチェック　※入力されている場合のみ
		// ・kaigoInfoRequestDate（申請日）
		// 存在する日付が入力されているかどうか
		// ※エラーの場合、String：msgParamを宣言し、"申請日の"を代入する。
		if (!ACTextUtilities.isNullText(getKaigoInfoRequestDate().getText())) {
			if (!getKaigoInfoRequestDate().isValidDate()) {
				getKaigoInfoRequestDate().requestFocus(); // フォーカス
				msgParam1 = "申請日の";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		// 認定日のチェック　※入力されている場合のみ
		// ・kaigoInfoAuthorizeDate（認定日）
		// 存在する日付が入力されているかどうか
		// ※エラーの場合、String：msgParamを宣言し、"認定日の"を代入する。
		if (!ACTextUtilities.isNullText(getKaigoInfoAuthorizeDate().getText())) {
			if (!getKaigoInfoAuthorizeDate().isValidDate()) {
				getKaigoInfoAuthorizeDate().requestFocus(); // フォーカス
				msgParam1 = "認定日の";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		if (getNonCorrespondenceFlg() == 0) {
			// 有効期間開始日のチェック　※要介護度-非該当の場合は行わない。
			// ・kaigoInfoValidLimit1（有効期間開始日）
			// 入力されているかどうか
			// ※エラーの場合、String：msgParam1を宣言し、"有効期間開始日"を代入する。
			if (ACTextUtilities.isNullText(getKaigoInfoValidLimit1().getText())) {
				getKaigoInfoValidLimit1().requestFocus(); // フォーカス
				msgParam1 = "有効期間開始日";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
		}

		// 存在する日付が入力されているかどうか
		// ※エラーの場合、String：msgParamを宣言し、"有効期間開始日の"を代入する。
		if (!ACTextUtilities.isNullText(getKaigoInfoValidLimit1().getText())) {
			if (!getKaigoInfoValidLimit1().isValidDate()) {
				getKaigoInfoValidLimit1().requestFocus(); // フォーカス
				msgParam1 = "有効期間開始日の";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		if (getNonCorrespondenceFlg() == 0) {
			// 有効期間終了日のチェック　※要介護度-非該当の場合は行わない。
			// ・kaigoInfoValidLimit3（有効期間終了日）
			// 入力されているかどうか
			// ※エラーの場合、String：msgParam1を宣言し、"有効期間終了日"を代入する。
		    
// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//          if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
//                getKaigoInfoValidLimit3().requestFocus(); // フォーカス
//                msgParam1 = "有効期間終了日";
//                QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
//                        msgParam1);
//                return false;
//          }
		    // 事業対象者の場合、認定期間終了日の必須チェックはしない
		    if (!isJigyotaisho) {
		        if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
                    getKaigoInfoValidLimit3().requestFocus(); // フォーカス
                    msgParam1 = "有効期間終了日";
                    QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
                              msgParam1);
                    return false;
		        }
		    }
// 2016/7/5 [Yoichiro Kamei] mod - end
		}

		// 存在する日付が入力されているかどうか　※要介護度-非該当の場合は行わない。
		// ※エラーの場合、String：msgParamを宣言し、"有効期間終了日の"を代入する。
		if (!ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
			if (!getKaigoInfoValidLimit3().isValidDate()) {
				getKaigoInfoValidLimit3().requestFocus(); // フォーカス
				msgParam1 = "有効期間終了日の";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		// [CCCX:03750][Shinobu Hitaka] 2016/12/19 add - begin システム有効期間の日付チェック
		// 存在する日付が入力されているかどうか
		// ※エラーの場合、String：msgParamを宣言し、"システム有効期間開始日の"を代入する。
		if (!ACTextUtilities.isNullText(getKaigoInfoSystemValidLimit1().getText())) {
			if (!getKaigoInfoSystemValidLimit1().isValidDate()) {
				getKaigoInfoSystemValidLimit1().requestFocus(); // フォーカス
				msgParam1 = "システム有効期間開始日の";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		// 存在する日付が入力されているかどうか　
		// ※エラーの場合、String：msgParamを宣言し、"システム有効期間終了日の"を代入する。
		if (!ACTextUtilities.isNullText(getKaigoInfoSystemValidLimit3().getText())) {
			if (!getKaigoInfoSystemValidLimit3().isValidDate()) {
				getKaigoInfoSystemValidLimit3().requestFocus(); // フォーカス
				msgParam1 = "システム有効期間終了日の";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}
		// [CCCX:03750][Shinobu Hitaka] 2016/12/19 add - end

		int targetIndex = -1; // 編集対象となる履歴のインデックス

		if (getNonCorrespondenceFlg() == 0) {
			// 有効期間開始日と有効期間終了日の前後関係のチェック　※要介護度-非該当の場合は行わない。
			// ・kaigoInfoValidLimit1（有効期間開始日）
			// ・kaigoInfoValidLimit3（有効期間終了日）
			// ※エラーの場合、String：msgParam1を宣言し、"有効期間は"を代入する。
			// ※エラーの場合、String：msgParam2を宣言し、"開始日"を代入する。
			// ※エラーの場合、String：msgParam3を宣言し、"終了日"を代入する。

			Date start = getKaigoInfoValidLimit1().getDate();
// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//			Date end = getKaigoInfoValidLimit3().getDate();
			Date end;
			if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
			    end = MAX_DATE;
			} else {
			    end = getKaigoInfoValidLimit3().getDate();
			}
// 2016/7/5 [Yoichiro Kamei] mod - end

			if (ACDateUtilities.getDifferenceOnDay(start, end) > 0) {
				getKaigoInfoValidLimit1().requestFocus();
				msgParam1 = "有効期間は";
				msgParam2 = "開始日";
				msgParam3 = "終了日";
				QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION(
						msgParam1, msgParam2, msgParam3);
				return false;
			}

// 2014/12/17 [Yoichiro Kamei] comment out - begin システム有効期間対応
//			// 既に登録されている要介護認定の有効期間と重なっていないかどうか　※要介護度-非該当の場合は行わない。
//			// ・kaigoInfoValidLimit1（有効期間開始日）
//			// ・kaigoInfoValidLimit2（有効期間終了日）
//
//			if (!(getKaigoHistoryList() == null || getKaigoHistoryList().size() == 0)) {
//
//				Date latestStart = null;
//
//				// 最後の履歴のインデックスを取得する。
//				for (int i = 0; i < getKaigoHistoryList().size(); i++) { // 認定履歴件数分ループ
//
//					// 編集モードの場合
//					// 自身の履歴は無視する。
//					if (checkMode == CHECK_MODE_UPDATE) {
//						if (i == getKaigoInfoTable().getSelectedModelRow()) {
//							continue;
//						}
//					}
//
//					VRMap map = (VRMap) getKaigoHistoryList().get(i); // 履歴抽出
//
//					// 対象の履歴が非該当の場合は無視する。
//					int targetJotaiCode = ACCastUtilities
//							.toInt(VRBindPathParser.get("JOTAI_CODE", map));
//					if (targetJotaiCode == YOUKAIGODO_HIGAITOU) {
//						continue;
//					}
//
//					reservedStart = (Date) VRBindPathParser.get(
//							"INSURE_VALID_START", map); // 履歴の有効期間開始日
//					if (latestStart == null) {
//						latestStart = reservedStart;
//						targetIndex = i;
//					} else if (ACDateUtilities.getDifferenceOnDay(latestStart,
//							reservedStart) < 0) {
//						latestStart = reservedStart;
//						targetIndex = i;
//					}
//				}
//
//				// 最後の履歴以外の履歴と重複していないかチェックする。
//				for (int i = 0; i < getKaigoHistoryList().size(); i++) { // 認定履歴件数分ループ
//
//					// 最後の履歴は後で比較する
//					if (i == targetIndex) {
//						continue;
//					}
//
//					// 編集モードの場合
//					// 自身の履歴は無視する。
//					if (checkMode == CHECK_MODE_UPDATE) {
//						if (i == getKaigoInfoTable().getSelectedModelRow()) {
//							continue;
//						}
//					}
//
//					VRMap map = (VRMap) getKaigoHistoryList().get(i); // 履歴抽出
//
//					// 対象の履歴が非該当の場合は無視する。
//					int targetJotaiCode = ACCastUtilities
//							.toInt(VRBindPathParser.get("JOTAI_CODE", map));
//					if (targetJotaiCode == YOUKAIGODO_HIGAITOU) {
//						continue;
//					}
//
//					reservedStart = (Date) VRBindPathParser.get(
//							"INSURE_VALID_START", map);
//					reservedEnd = (Date) VRBindPathParser.get(
//							"INSURE_VALID_END", map);
//
//					// 期間重複チェック
//					// チェックの結果を取得
//					int result = ACDateUtilities.getDuplicateTermCheck(
//							reservedStart, reservedEnd, start, end);
//
//					if (result != ACDateUtilities.DUPLICATE_NONE) {
//						// 重複していた場合
//
//						getKaigoInfoValidLimit1().requestFocus();
//						QkanMessageList.getInstance()
//								.QU002_ERROR_OF_DUPLICATE_KAIGO();
//						return false;
//
//					}
//				}
//
//				// 最後の履歴と重複していないかチェックする。
//				if (targetIndex != -1) {
//					VRMap latestMap = (VRMap) getKaigoHistoryList().get(
//							targetIndex); // 最後の履歴抽出
//					reservedStart = (Date) VRBindPathParser.get(
//							"INSURE_VALID_START", latestMap); // 最後の履歴の有効期間開始日
//					reservedEnd = (Date) VRBindPathParser.get(
//							"INSURE_VALID_END", latestMap); // 最後の履歴の有効期間終了日
//
//					// チェックの結果を取得
//					int result = ACDateUtilities.getDuplicateTermCheck(
//							reservedStart, reservedEnd, start, end);
//
//					if (result != ACDateUtilities.DUPLICATE_NONE) {
//						// 重複していた場合
//
//						if (result == ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND
//								|| result == ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND_EQUALS_BOTH_END
//								|| result == ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN
//								|| result == ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN_ON_ONE_DAY) {
//							// 有効期間を自動で調整できる場合
//							// 確認メッセージを表示する。
//							// ・メッセージID：WARNING_OF_DUPLICATE_TERM
//							msgParam1 = "要介護認定";
//							switch (QkanMessageList.getInstance()
//									.WARNING_OF_DUPLICATE_TERM(msgParam1)) {
//							case ACMessageBox.RESULT_OK:
//								// 「OK」が選択された場合
//								// 入力チェックを完全にパスした後処理を行う。
//								doUpdateFlg = 1;
//								break;
//							case ACMessageBox.RESULT_CANCEL:
//								// 「キャンセル」が選択された場合
//								// エラーが発生したインスタンスにフォーカスを当てる。
//								getKaigoInfoValidLimit1().requestFocus();
//								// 戻り値としてfalseを返す。
//								return false;
//							}
//
//						} else {
//							// 有効期間を自動で調整できない場合
//							getKaigoInfoValidLimit1().requestFocus();
//							QkanMessageList.getInstance()
//									.QU002_ERROR_OF_DUPLICATE_KAIGO();
//							return false;
//						}
//
//					}
//				}
//			}
// 2014/12/17 [Yoichiro Kamei] comment out - end

		}
// 2014/12/17 [Yoichiro Kamei] add - begin システム有効期間対応
		
		if (getNonCorrespondenceFlg() == 0) { // ※要介護度-非該当の場合は処理を通らない。
			boolean warn1 = false;
			boolean warn2 = false;
			if (ACTextUtilities.isNullText(getKaigoInfoSystemValidLimit1().getText())) {
				warn1 = true;
			}
// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//			if (ACTextUtilities.isNullText(getKaigoInfoSystemValidLimit3().getText())) {
//				warn2 = true;
//			}
			if (!isJigyotaisho) {
				if (ACTextUtilities.isNullText(getKaigoInfoSystemValidLimit3().getText())) {
					warn2 = true;
				}
			}
// 2016/7/5 [Yoichiro Kamei] mod - end
			
			//システム適用期間が未入力のとき
			if (warn1 || warn2) {
				switch (QkanMessageList.getInstance()
						.QU002_WARNING_OF_NEED_CHECK_OF_INPUT_SYSTEM_VALID()) {
				case ACMessageBox.RESULT_OK:
					if (warn1) {
						getKaigoInfoSystemValidLimit1().setText(getKaigoInfoValidLimit1().getText());
					}
					if (warn2) {
						getKaigoInfoSystemValidLimit3().setText(getKaigoInfoValidLimit3().getText());
					}
					break;
				case ACMessageBox.RESULT_CANCEL:
					if (warn1) {
						getKaigoInfoSystemValidLimit1().requestFocus();
					}
					if (warn2) {
						getKaigoInfoSystemValidLimit3().requestFocus();
					}
					return false;
				}
			}
		}
		if (getNonCorrespondenceFlg() == 0) { // ※要介護度-非該当の場合は処理を通らない。
			
// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//			//システム適用期間が認定有効期間の範囲外のとき
//			Date validStart = getKaigoInfoValidLimit1().getDate();
//			Date validEnd = getKaigoInfoValidLimit3().getDate();
//			Date sysValidStart = getKaigoInfoSystemValidLimit1().getDate();
//			Date sysValidEnd = getKaigoInfoSystemValidLimit3().getDate();
			
			Date validStart = getKaigoInfoValidLimit1().getDate();
			Date sysValidStart = getKaigoInfoSystemValidLimit1().getDate();
		    
			Date validEnd;
			if (ACTextUtilities.isNullText(getKaigoInfoValidLimit3().getText())) {
				validEnd = MAX_DATE;
			} else {
				validEnd = getKaigoInfoValidLimit3().getDate();
			}
			
			Date sysValidEnd;
			if (ACTextUtilities.isNullText(getKaigoInfoSystemValidLimit3().getText())) {
				sysValidEnd = MAX_DATE;
			} else {
				sysValidEnd = getKaigoInfoSystemValidLimit3().getDate();
			}
// 2016/7/5 [Yoichiro Kamei] mod - end
			
			boolean warn1 = false;
			boolean warn2 = false;
			
			if (ACDateUtilities.getDifferenceOnDay(sysValidStart, validStart) < 0 ||
				ACDateUtilities.getDifferenceOnDay(sysValidStart, validEnd) > 0 ) {
				warn1 = true;
			}
			if (ACDateUtilities.getDifferenceOnDay(sysValidEnd, validEnd) > 0 ||
				ACDateUtilities.getDifferenceOnDay(sysValidEnd, validStart) < 0 ) {
				warn2 = true;
			}
			if (warn1 || warn2) {
				switch (QkanMessageList.getInstance()
						.QU002_WARNING_OF_INVALID_SYSTEM_VALID()) {
				case ACMessageBox.RESULT_OK:
					if (warn1) {
						getKaigoInfoSystemValidLimit1().setText(getKaigoInfoValidLimit1().getText());
					}
					if (warn2) {
						getKaigoInfoSystemValidLimit3().setText(getKaigoInfoValidLimit3().getText());
					}
					break;
				case ACMessageBox.RESULT_CANCEL:
					if (warn1) {
						getKaigoInfoSystemValidLimit1().requestFocus();
					}
					if (warn2) {
						getKaigoInfoSystemValidLimit3().requestFocus();
					}
					return false;
				}
			}
		}
		
		// ・kaigoInfoSystemValidLimit1（システム有効期間開始日）
		// 入力されているかどうか
		// ※エラーの場合、String：msgParam1を宣言し、"有効期間開始日"を代入する。
		if (ACTextUtilities.isNullText(getKaigoInfoSystemValidLimit1().getText())) {
			getKaigoInfoSystemValidLimit1().requestFocus(); // フォーカス
			msgParam1 = "システム有効期間開始日";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// 有効期間終了日のチェック　※要介護度-非該当の場合は行わない。
		// ・kaigoInfoSystemValidLimit3（有効期間終了日）
		// 入力されているかどうか
		// ※エラーの場合、String：msgParam1を宣言し、"有効期間終了日"を代入する。
		
// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//		if (ACTextUtilities.isNullText(getKaigoInfoSystemValidLimit3().getText())) {
//			getKaigoInfoSystemValidLimit3().requestFocus(); // フォーカス
//			msgParam1 = "システム有効期間終了日";
//			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
//					msgParam1);
//			return false;
//		}
		// 事業対象者の場合、システム有効期間終了日の必須チェックはしない
		if (!isJigyotaisho) {
			if (ACTextUtilities.isNullText(getKaigoInfoSystemValidLimit3().getText())) {
				getKaigoInfoSystemValidLimit3().requestFocus(); // フォーカス
				msgParam1 = "システム有効期間終了日";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
				return false;
		    }
		}
// 2016/7/5 [Yoichiro Kamei] mod - end

		// システム有効期間開始日とシステム有効期間終了日の前後関係のチェック
		// ・kaigoInfoSystemValidLimit1（システム有効期間開始日）
		// ・kaigoInfoSystemValidLimit3（システム有効期間終了日）
		// ※エラーの場合、String：msgParam1を宣言し、"システム有効期間は"を代入する。
		// ※エラーの場合、String：msgParam2を宣言し、"開始日"を代入する。
		// ※エラーの場合、String：msgParam3を宣言し、"終了日"を代入する。

		Date start = getKaigoInfoSystemValidLimit1().getDate();
// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//      Date end = getKaigoInfoSystemValidLimit3().getDate();
		Date end;
		if (ACTextUtilities.isNullText(getKaigoInfoSystemValidLimit3().getText())) {
			end = MAX_DATE;
		} else {
			end = getKaigoInfoSystemValidLimit3().getDate();
		}
//2016/7/5 [Yoichiro Kamei] mod - end
        
		if (ACDateUtilities.getDifferenceOnDay(start, end) > 0) {
			getKaigoInfoSystemValidLimit1().requestFocus();
			msgParam1 = "システム有効期間は";
			msgParam2 = "開始日";
			msgParam3 = "終了日";
			QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION(
					msgParam1, msgParam2, msgParam3);
			return false;
		}

		// 既に登録されているシステム有効期間と重なっていないかどうか
		// ・kaigoInfoSystemValidLimit1（システム有効期間開始日）
		// ・kaigoInfoSystemValidLimit3（システム有効期間終了日）

		if (!(getKaigoHistoryList() == null || getKaigoHistoryList().size() == 0)) {

			Date latestStart = null;

			// 最後の履歴のインデックスを取得する。
			for (int i = 0; i < getKaigoHistoryList().size(); i++) { // 認定履歴件数分ループ

				// 編集モードの場合
				// 自身の履歴は無視する。
				if (checkMode == CHECK_MODE_UPDATE) {
					if (i == getKaigoInfoTable().getSelectedModelRow()) {
						continue;
					}
				}

				VRMap map = (VRMap) getKaigoHistoryList().get(i); // 履歴抽出

				// 対象の履歴が非該当の場合は無視する。
				int targetJotaiCode = ACCastUtilities
						.toInt(VRBindPathParser.get("JOTAI_CODE", map));
				if (targetJotaiCode == YOUKAIGODO_HIGAITOU) {
					continue;
				}

				reservedStart = (Date) VRBindPathParser.get(
						"SYSTEM_INSURE_VALID_START", map); // 履歴の有効期間開始日
				if (latestStart == null) {
					latestStart = reservedStart;
					targetIndex = i;
				} else if (ACDateUtilities.getDifferenceOnDay(latestStart,
						reservedStart) < 0) {
					latestStart = reservedStart;
					targetIndex = i;
				}
			}

			// 最後の履歴以外の履歴と重複していないかチェックする。
			for (int i = 0; i < getKaigoHistoryList().size(); i++) { // 認定履歴件数分ループ

				// 最後の履歴は後で比較する
				if (i == targetIndex) {
					continue;
				}

				// 編集モードの場合
				// 自身の履歴は無視する。
				if (checkMode == CHECK_MODE_UPDATE) {
					if (i == getKaigoInfoTable().getSelectedModelRow()) {
						continue;
					}
				}

				VRMap map = (VRMap) getKaigoHistoryList().get(i); // 履歴抽出

				// 対象の履歴が非該当の場合は無視する。
				int targetJotaiCode = ACCastUtilities
						.toInt(VRBindPathParser.get("JOTAI_CODE", map));
				if (targetJotaiCode == YOUKAIGODO_HIGAITOU) {
					continue;
				}

				reservedStart = (Date) VRBindPathParser.get(
						"SYSTEM_INSURE_VALID_START", map);
				reservedEnd = (Date) VRBindPathParser.get(
						"SYSTEM_INSURE_VALID_END", map);

				// 期間重複チェック
				// チェックの結果を取得
				int result = ACDateUtilities.getDuplicateTermCheck(
						reservedStart, reservedEnd, start, end);

				if (result != ACDateUtilities.DUPLICATE_NONE) {
					// 重複していた場合

					getKaigoInfoSystemValidLimit1().requestFocus();
					QkanMessageList.getInstance()
							.QU002_ERROR_OF_DUPLICATE_SYSTEM_VALID();
					return false;

				}
			}

			// 最後の履歴と重複していないかチェックする。
			if (targetIndex != -1) {
				VRMap latestMap = (VRMap) getKaigoHistoryList().get(
						targetIndex); // 最後の履歴抽出
				reservedStart = (Date) VRBindPathParser.get(
						"SYSTEM_INSURE_VALID_START", latestMap); // 最後の履歴の有効期間開始日
				reservedEnd = (Date) VRBindPathParser.get(
						"SYSTEM_INSURE_VALID_END", latestMap); // 最後の履歴の有効期間終了日

				// チェックの結果を取得
				int result = ACDateUtilities.getDuplicateTermCheck(
						reservedStart, reservedEnd, start, end);

				if (result != ACDateUtilities.DUPLICATE_NONE) {
					// 重複していた場合

					if (result == ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND
							|| result == ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND_EQUALS_BOTH_END
							|| result == ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN
							|| result == ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN_ON_ONE_DAY) {
						// 有効期間を自動で調整できる場合
						// 確認メッセージを表示する。
						// ・メッセージID：WARNING_OF_DUPLICATE_TERM
						msgParam1 = "システム";
						switch (QkanMessageList.getInstance()
								.WARNING_OF_DUPLICATE_TERM(msgParam1)) {
						case ACMessageBox.RESULT_OK:
							// 「OK」が選択された場合
							// 入力チェックを完全にパスした後処理を行う。
							doUpdateFlg = 1;
							break;
						case ACMessageBox.RESULT_CANCEL:
							// 「キャンセル」が選択された場合
							// エラーが発生したインスタンスにフォーカスを当てる。
							getKaigoInfoSystemValidLimit1().requestFocus();
							// 戻り値としてfalseを返す。
							return false;
						}

					} else {
						// 有効期間を自動で調整できない場合
						getKaigoInfoSystemValidLimit1().requestFocus();
						QkanMessageList.getInstance()
								.QU002_ERROR_OF_DUPLICATE_SYSTEM_VALID();
						return false;
					}

				}
			}
		}

// 2014/12/17 [Yoichiro Kamei] add - end

		if (getNonCorrespondenceFlg() == 0) { // 非該当の場合は処理を通らない。
			// 中断日のチェック　※中断理由が選択されている場合のみ
			// ・kaigoInfoInterruptionDate（中断日）
			// 中断理由が選択されている場合、入力されているかどうか
			if (getKaigoInfoInterruptionReasonRadio().isSelected()) {
				if (ACTextUtilities.isNullText(getKaigoInfoInterruptionDate()
						.getText())) {
					// 入力されているかどうか
					// ※エラーの場合、String：msgParam1を宣言し、"中断日"を代入する。
					getKaigoInfoInterruptionDate().requestFocus(); // フォーカス
					msgParam1 = "中断日";
					QkanMessageList.getInstance()
							.ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
					return false;
				}
			}
		}

		// 中断日のチェック　※中断理由が選択されている場合のみ
		// ・kaigoInfoInterruptionDate（中断日）
		// 入力されている場合、存在する日付が入力されているかどうか
		if (!ACTextUtilities.isNullText(getKaigoInfoInterruptionDate()
				.getText())) {
			if (!getKaigoInfoInterruptionDate().isValidDate()) {
				// 存在する日付が入力されているかどうか
				// ※エラーの場合、String：msgParamを宣言し、"中断日の"を代入する。
				getKaigoInfoInterruptionDate().requestFocus(); // フォーカス
				msgParam1 = "中断日の";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		if (getNonCorrespondenceFlg() == 0) { // 非該当の場合は処理を通らない。
			// 中断理由のチェック　※中断日が入力されている場合のみ
			// 選択されているかどうか
			// ・kaigoInfoInterruptionReasonRadio（中断理由）
			// ※エラーの場合、String：msgParamを宣言し、"中断理由"を代入する。
			if (!(ACTextUtilities.isNullText(getKaigoInfoInterruptionDate()
					.getText()))) {
				if (!getKaigoInfoInterruptionReasonRadio().isSelected()) {
					getKaigoInfoInterruptionReasonRadio().requestFocus(); // フォーカス
					msgParam1 = "中断理由";
					QkanMessageList.getInstance()
							.ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
					return false;
				}
			}
		}

		if (getNonCorrespondenceFlg() == 0) {
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//			Date start = getKaigoInfoValidLimit1().getDate();
//			Date end = getKaigoInfoValidLimit3().getDate();
			start = getKaigoInfoSystemValidLimit1().getDate();
			
// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//          end = getKaigoInfoSystemValidLimit3().getDate();
			if (ACTextUtilities.isNullText(getKaigoInfoSystemValidLimit3().getText())) {
				end = MAX_DATE;
			} else {
				end = getKaigoInfoSystemValidLimit3().getDate();
			}
// 2016/7/5 [Yoichiro Kamei] mod - end
						
// 2014/12/17 [Yoichiro Kamei] mod - end
			
			// 1月（ひとつき）に、異なる被保険者番号が3つ以上存在することにならないかチェックする。
			if (!(getKaigoHistoryList() == null || getKaigoHistoryList().size() == 0)) {

				int num = 0; // 重複した回数をカウントする。
				String insuredId = getKaigoInfoInsuredId().getText();

				// 有効期間開始日の月に存在する認定履歴を検索する。
				// 検索して取得した認定履歴の件数分ループする。
				for (int i = 0; i < getKaigoHistoryList().size(); i++) {

					// 編集モードの場合
					// 自身の履歴は無視する。
					if (checkMode == CHECK_MODE_UPDATE) {
						if (i == getKaigoInfoTable().getSelectedModelRow()) {
							continue;
						}
					}

					// 履歴の取得
					VRMap map = (VRMap) getKaigoHistoryList().get(i);

					// 対象の履歴が非該当の場合は無視する。
					int targetJotaiCode = ACCastUtilities
							.toInt(VRBindPathParser.get("JOTAI_CODE", map));
					if (targetJotaiCode == YOUKAIGODO_HIGAITOU) {
						continue;
					}
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//					reservedStart = (Date) VRBindPathParser.get(
//							"INSURE_VALID_START", map);
//					reservedEnd = (Date) VRBindPathParser.get(
//							"INSURE_VALID_END", map);
					reservedStart = (Date) VRBindPathParser.get(
							"SYSTEM_INSURE_VALID_START", map);
					reservedEnd = (Date) VRBindPathParser.get(
							"SYSTEM_INSURE_VALID_END", map);
// 2014/12/17 [Yoichiro Kamei] mod - end
					if (ACDateUtilities.getDifferenceOnMonth(start,
							reservedStart) == 0
							|| ACDateUtilities.getDifferenceOnMonth(start,
									reservedEnd) == 0) {
						// 履歴の被保険者番号とkaigoInfoInsuredId（被保険者番号）に
						// 入力されている被保険者番号が異なる場合
						if (!insuredId.equals(ACCastUtilities
								.toString(VRBindPathParser.get("INSURED_ID",
										map)))) {
							// 数値型変数numに1を加える。
							num += 1;
						}

						// numの値が2の場合
						if (num == 2) {
							getKaigoInfoInsuredId().requestFocus(); // フォーカス
							// エラーメッセージを表示する。
							QkanMessageList.getInstance()
									.QP002_ERROR_OF_INSURED_ID();
							return false;
						}

					}
				}

				// カウンタ初期化
				num = 0;

				// 有効期間終了日の月に存在する認定履歴を検索する。
				// 検索して取得した認定履歴の件数分ループする。
				for (int i = 0; i < getKaigoHistoryList().size(); i++) {

					// 編集モードの場合
					// 自身の履歴は無視する。
					if (checkMode == CHECK_MODE_UPDATE) {
						if (i == getKaigoInfoTable().getSelectedModelRow()) {
							continue;
						}
					}

					VRMap map = (VRMap) getKaigoHistoryList().get(i);

					// 対象の履歴が非該当の場合は無視する。
					int targetJotaiCode = ACCastUtilities
							.toInt(VRBindPathParser.get("JOTAI_CODE", map));
					if (targetJotaiCode == YOUKAIGODO_HIGAITOU) {
						continue;
					}
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//					reservedStart = (Date) VRBindPathParser.get(
//							"INSURE_VALID_START", map);
//					reservedEnd = (Date) VRBindPathParser.get(
//							"INSURE_VALID_END", map);
					reservedStart = (Date) VRBindPathParser.get(
							"SYSTEM_INSURE_VALID_START", map);
					reservedEnd = (Date) VRBindPathParser.get(
							"SYSTEM_INSURE_VALID_END", map);
// 2014/12/17 [Yoichiro Kamei] mod - end
					if (ACDateUtilities.compareOnMonth(end, reservedStart) == 0
							|| ACDateUtilities.compareOnMonth(end, reservedEnd) == 0) {
						// 履歴の被保険者番号とkaigoInfoInsuredId（被保険者番号）に
						// 入力されている被保険者番号が異なる場合
						if (!insuredId.equals(ACCastUtilities
								.toString(VRBindPathParser.get("INSURED_ID",
										map)))) {
							// 数値型変数numに1を加える。
							num += 1;
						}

						// numの値が2の場合
						if (num == 2) {
							getKaigoInfoInsuredId().requestFocus(); // フォーカス
							// エラーメッセージを表示する。
							QkanMessageList.getInstance()
									.QP002_ERROR_OF_INSURED_ID();
							return false;
						}

					}
				}
			}
		}

		// [ID:0000444][Tozo TANAKA] 2009/03/07 add begin 平成21年4月法改正対応
		if (getNonCorrespondenceFlg() == 0) {
			// 経過的要介護の期間チェック　※要介護度-非該当の場合は行わない
			// 下記のフィールドに入力されている日付が、要介護度と矛盾していないかチェックする。
			// ・kaigoInfoValidLimit1（有効期間開始日）
			// ・kaigoInfoValidLimit3（有効期間終了日）

			// 選択している要介護度を取得する。
			VRMap temp = (VRMap) getKaigoInfoYokaigoInfo()
					.getSelectedModelItem();
			int jotaiCode = ACCastUtilities.toInt(VRBindPathParser.get(
					"JOTAI_CODE", temp));
			if (jotaiCode == QkanConstants.YOUKAIGODO_KEIKATEKI_YOUKAIGO) {
				// 選択している要介護度が経過的要介護の場合
				// 入力している要介護認定の有効期間を取得する。

// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//				Date start = getKaigoInfoValidLimit1().getDate();
//				Date end = getKaigoInfoValidLimit3().getDate();
				start = getKaigoInfoSystemValidLimit1().getDate();
				
// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//	          end = getKaigoInfoSystemValidLimit3().getDate();
				if (ACTextUtilities.isNullText(getKaigoInfoSystemValidLimit3().getText())) {
					end = MAX_DATE;
				} else {
					end = getKaigoInfoSystemValidLimit3().getDate();
				}
// 2016/7/5 [Yoichiro Kamei] mod - end

// 2014/12/17 [Yoichiro Kamei] mod - end
				if (ACDateUtilities
						.getDifferenceOnDay(QkanConstants.H2104, end) < 1) {
					// 有効期間の終了日が平成21年4月以降の場合
					// 経過的要介護の有効期間は平成21年3月31日以前にするようエラーメッセージを表示する。
					QkanMessageList.getInstance()
							.ERROR_OF_GREATER_DATE_RELATION("経過的要介護の有効期間は", "",
									"平成21年3月31日");
					// 処理を中断する。
					return false;
				}
			}

		}
		// [ID:0000444][Tozo TANAKA] 2009/03/07 add end

		// 編集ボタン押下時
		if (checkMode == CHECK_MODE_UPDATE) {
			// 更新モードの場合
			if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {

				// 対象の認定の情報を取得
				VRMap temp = (VRMap) getKaigoInfoTable()
						.getSelectedModelRowValue();
				// 対象の認定の要介護度を退避
				int targetJotaiCode = ACCastUtilities.toInt(VRBindPathParser
						.get("JOTAI_CODE", temp));

				// SQL文取得用
				VRMap param = null;
				// SQL文格納用
				String strSql = null;

				// トランザクション開始　※サービス情報の更新を防ぐ
				getDBManager().beginTransaction();

				// 新たに入力された有効期間中のサービス予定・実績のレコードを取得するための
				// HashMap：paramを生成し、下記のKEY/VALUEを設定する。
				// ・KEY：PATIENT_ID　VALUE：patientId
				// ・KEY：VALID_START　VALUE：kaigoInfoValidLimit1（有効期間開始）の値
				// ・KEY：VALID_END　VALUE：kaigoInfoValidLimit3（有効期間終了）の値
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));
				if (getNonCorrespondenceFlg() == 0) {
					// 非該当の場合は入力された有効期間は必要ない

// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//					VRBindPathParser.set("VALID_START", param,
//							getKaigoInfoValidLimit1().getDate());
//					VRBindPathParser.set("VALID_END", param,
//							getKaigoInfoValidLimit3().getDate());
					VRBindPathParser.set("VALID_START", param,
							getKaigoInfoSystemValidLimit1().getDate());
					
// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
//                  VRBindPathParser.set("VALID_END", param,
//                  getKaigoInfoSystemValidLimit3().getDate());
					if (ACTextUtilities.isNullText(getKaigoInfoSystemValidLimit3().getText())) {
						VRBindPathParser.set("VALID_END", param, MAX_DATE);
					} else {
						VRBindPathParser.set("VALID_END", param,
								getKaigoInfoSystemValidLimit3().getDate());
					}
// 2016/7/5 [Yoichiro Kamei] mod - end

// 2014/12/17 [Yoichiro Kamei] mod - end
				}

				// 新たに入力された有効期間中のサービス予定・実績のレコードを取得する。
				strSql = getSQL_GET_PATIENT_RESERVED_SERVICE(param);
				VRList newList = getDBManager().executeQuery(strSql);

				// 登録されていた有効期間中のサービス予定・実績のレコードを取得するための
				// HashMap：paramを生成し、下記のKEY/VALUEを設定する。
				// ・KEY：PATIENT_ID　VALUE：patientId
				// ・KEY：VALID_START　VALUE：選択レコードの有効期間開始の値
				// ・KEY：VALID_END　VALUE：選択レコードの有効期間終了の値
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));
				if (targetJotaiCode != YOUKAIGODO_HIGAITOU) {
					// 対象の認定の要介護度が非該当の場合は必要ない
					
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//					VRBindPathParser.set("VALID_START", param,
//							VRBindPathParser.get("INSURE_VALID_START", temp));
//					VRBindPathParser.set("VALID_END", param,
//							VRBindPathParser.get("INSURE_VALID_END", temp));
					VRBindPathParser.set("VALID_START", param,
							VRBindPathParser.get("SYSTEM_INSURE_VALID_START", temp));
					VRBindPathParser.set("VALID_END", param,
							VRBindPathParser.get("SYSTEM_INSURE_VALID_END", temp));
// 2014/12/17 [Yoichiro Kamei] mod - end
				}

				// 登録されていた有効期間中のサービス予定・実績のレコードを取得する。
				strSql = getSQL_GET_PATIENT_RESERVED_SERVICE(param);
				VRList oldList = getDBManager().executeQuery(strSql);

				// コミット
				getDBManager().commitTransaction();

				// 選択された履歴の要介護度が非該当でない場合
				if (targetJotaiCode != YOUKAIGODO_HIGAITOU) {
					if (getNonCorrespondenceFlg() == 0) {
						// 選択された要介護度が非該当でない場合
						// 取得した2つのデータを比較する。
						if (!(oldList == null || oldList.size() == 0)) {
							boolean stopFlg = false;
							for (int i = 0; i < oldList.size(); i++) {
								// 登録されていた有効期間中のサービスが、入力された有効期間に存在しない場合

								// oldListのレコードをnewListから検索し、インデックスを取得する。
								int index = ACBindUtilities
										.getMatchIndexFromMap(newList,
												"SERVICE_ID",
												(VRMap) oldList.get(i));

								// 存在しなかった場合
								if (index == -1) {
									// メッセージを表示する。
									// ・メッセージID：QU002_WARNING_OF_OUT_OF_VALID
									msgParam1 = "編集";
									switch (QkanMessageList.getInstance()
											.QU002_WARNING_OF_OUT_OF_VALID(
													msgParam1)) {
									case ACMessageBox.RESULT_OK:
										stopFlg = true;
										break;
									case ACMessageBox.RESULT_CANCEL:
										return false;
									}
								}
								// OKが選択された場合はループ終了
								if (stopFlg) {
									break;
								}
							}
						}
					} else {
						// 選択された要介護度が非該当の場合
						// 要介護度あり ⇒ 非該当のケース
						if (!(oldList == null || oldList.size() == 0)) {
							// 既に登録されているサービスがある場合
							msgParam1 = "編集";
							switch (QkanMessageList.getInstance()
									.QU002_WARNING_OF_OUT_OF_VALID(msgParam1)) {
							case ACMessageBox.RESULT_CANCEL:
								return false;
							}
						}
					}
				}
			}
		}

		if (getNonCorrespondenceFlg() == 0) {
			// 入力チェックエラーが発生しなかった場合

			// 給付率補正

			// 被保険者番号
			String insuredId = getKaigoInfoInsuredId().getText();
			// 給付率
			int insureRate = ACCastUtilities.toInt(getKaigoInfoBenefit()
					.getText(), 0);

			if (insuredId.charAt(0) == 'H') {
				// 被保険者番号が「H～」となっている場合
				if (insureRate != INSURE_RATE_SEIHO) {
					// 給付率が「0%」となっていない場合
					switch (QkanMessageList.getInstance()
							.QU002_WARNING_OF_CHANGE_RATE_FOR_SEIHO_TANDOKU()) {
					case ACMessageBox.RESULT_YES:
						// 給付率を「0%」に設定する。
						getKaigoInfoBenefit().setText(
								ACCastUtilities.toString(INSURE_RATE_SEIHO));
						break;
					case ACMessageBox.RESULT_CANCEL:
						// 処理を抜ける
						return false;
					}
				}
				// 公費登録をうながすメッセージを表示する。
				// ・メッセージID：QU002_REQUEST_TO_INSERT_SEIHO
				QkanMessageList.getInstance().QU002_REQUEST_TO_INSERT_SEIHO();
			}

			// 有効期間自動調整
			if (doUpdateFlg == 1) {

				// 入力された有効期間開始日
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//				Date start = getKaigoInfoValidLimit1().getDate();
				start = getKaigoInfoSystemValidLimit1().getDate();
// 2014/12/17 [Yoichiro Kamei] mod - end
				// 自動調整確認メッセージで「OK」を選択した場合
				// kaigoInfoSystemValidLimit1（システム有効期間開始日）の値を取得し、前日の値に変換する。
				Date changedDate = ACDateUtilities.addDay(start, -1);
				// 変換した値を、既にテーブルに登録されている要介護認定履歴のうち、
				// 重なっている認定の有効期間終了日に設定する。
				
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//				VRBindPathParser.set("INSURE_VALID_END",
//						(VRMap) getKaigoHistoryList().get(targetIndex),
//						changedDate);
				VRBindPathParser.set("SYSTEM_INSURE_VALID_END",
						(VRMap) getKaigoHistoryList().get(targetIndex),
						changedDate);
// 2014/12/17 [Yoichiro Kamei] mod - end
			}
		}

// 2016/7/18 [Yoichiro Kamei] add - begin 総合事業対応 事業対象者の限度額変更フラグ
		doCheckLimitChange();
// 2016/7/18 [Yoichiro Kamei] add - end
		
// 2015/4/15 [Yoichiro Kamei] add - begin 短期入所利用日数の初期値対応
        if (getNonCorrespondenceFlg() == 0) { // 非該当の場合は処理を通らない。
            //短期入所利用日数の初期値が設定されていて、
            //認定有効期間が変更されていた場合、短期入所利用日数の初期値をクリアするかどうか聞く
            int shortCount = ACCastUtilities.toInt(getKaigoInfoShortCount().getText(), 0);
            if (shortCount > 0) {
        
                boolean doAlert = false; //アラートを行うかどうか
                Date validStartInput = getKaigoInfoValidLimit1().getDate(); //認定有効期間（開始）
                
                //書替の場合、変更前の日付と違う場合、アラート
                if (checkMode == CHECK_MODE_UPDATE) {
                    VRMap map = (VRMap) getKaigoHistoryList().get(getKaigoInfoTable().getSelectedModelRow());
                    Date validStart = (Date) VRBindPathParser.get("INSURE_VALID_START", map);
                    if (ACDateUtilities.getDifferenceOnDay(validStartInput, validStart) != 0) {
                        doAlert = true;
                    }
                }
        	    
        	    if (checkMode == CHECK_MODE_INSERT && getKaigoHistoryList().size() > 0) {
        	        //追加の場合で、履歴が登録されている場合
        	        doAlert = true;
        	        //登録済の日付と同じ場合、アラートしない
        	        for (int i = 0; i < getKaigoHistoryList().size(); i++) {
        	            VRMap map = (VRMap) getKaigoHistoryList().get(i);
        	            Date validStart = (Date) VRBindPathParser.get("INSURE_VALID_START", map);
        	            if (ACDateUtilities.getDifferenceOnDay(validStartInput, validStart) == 0) {
        	                doAlert = false;
        	                break;
        	            }
        	        }
        	    }
        
                if (doAlert) {
                    switch (QkanMessageList.getInstance()
                            .QU002_WARNING_OF_CHANGE_VALID_FOR_SHORTSTAY_USE_INIT_COUNT()) {
                    case ACMessageBox.RESULT_YES:
                        // 短期入所利用日数の初期値を「0」に設定する。
                        getKaigoInfoShortCount().setText(ACCastUtilities.toString(0));
                        break;
                    case ACMessageBox.RESULT_CANCEL:
                        // 何もしない
                    }
                }
        	}
    	}
// 2015/4/15 [Yoichiro Kamei] add - end 
		
		// 戻り値としてtrueを返す。
		return true;

	}

	/**
	 * 「保存処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doSave() throws Exception {
		// 保存処理を行う。
		// 利用者情報の登録
		try {

			// SQL文取得用VRMap paramを定義する。
			VRMap param = null;
			// SQL文格納用String strSqlを定義する。
			String strSql = null;
			// 画面上のデータ格納用
			VRMap data = new VRHashMap();

			// [ID:0000749][Masahiko.Higuchi] del - begin 特定入所者の履歴管理機能
//			// 特定入所者チェックがOFFの場合
//			if (!getShisetsuInfoTokuteiCheck().isSelected()) {
//				// 負担限度額に空文字を表示する。
//				getShisetsuInfoDinnerBearLimitMoneyText().setText("");
//				getShisetsuInfoUnitRoomLimitMoneyText().setText("");
//				getShisetsuInfoUnitSemiRoomLimitMoneyText().setText("");
//				getShisetsuInfoNormalRoomLimitMoneyText().setText("");
//				getShisetsuInfoNormalRoomLimitMoneyText2().setText("");
//				getShisetsuInfoTasyoRoomLimitMoneyText().setText("");
//			}
			// [ID:0000749][Masahiko.Higuchi] del - end

			// 画面上のデータの取得
			// ソース生成
			data = (VRMap) getContents().createSource();
			// 画面に設定
			getContents().setSource(data);
			// 画面上のデータを流し込む
			getContents().applySource();

			// トランザクション開始
			getDBManager().beginTransaction();

			// 利用者基本情報
			if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
				// 新規の場合（processModeが共通定数のPROCESS_MODE_INSERT）

				// // 利用者IDを取得し、patientIdに格納する。
				// setPatientId(
				// QkanCommon.getBookingNumber(getDBManager(), "PATIENT",
				// "PATIENT_ID", 1));

				// // 画面上のデータに取得した利用者IDを追加する。
				// VRBindPathParser.set("PATIENT_ID", data, new
				// Integer(getPatientId()));

				// SQL文取得用HashMap：paramを生成し、画面上のデータを設定する。
				param = new VRHashMap();
				param = data;

				// 利用者情報（PATIENT）に画面上のデータを登録する。
				// ※まだコミットしない。
				strSql = getSQL_INSERT_PATIENT(param);
				getDBManager().executeUpdate(strSql);

				// 利用者IDを取得し、patientIdに格納する。
				param = new VRHashMap();

				strSql = getSQL_GET_NEW_PATIENT_ID(param);
				VRList list = getDBManager().executeQuery(strSql);
				VRMap temp = (VRMap) list.get(0);

				// 利用者IDを取得し、patientIdに格納する。
				setPatientId(ACCastUtilities.toInt(VRBindPathParser.get(
						"PATIENT_ID", temp)));

				// 画面上のデータに取得した利用者IDを追加する。
				VRBindPathParser.set("PATIENT_ID", data, new Integer(
						getPatientId()));

			} else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
				// 編集の場合（processModeが共通定数のPROCESS_MODE_UPDATE）

				// パッシブチェックのタスクをクリアする。
				getPassiveChecker().clearPassiveTask();

				// パッシブチェックを下記のパッシブキーで行う。
				// ・KEY：PASSIVE_CHECK_KEY_PATIENT
				getPassiveChecker().addPassiveUpdateTask(
						getPASSIVE_CHECK_KEY_PATIENT(), 0);

				if (!(getPassiveChecker().passiveCheck(getDBManager()))) {
					// パッシブエラーが発生した場合

					// エラーメッセージを表示する。
					// ・メッセージID：ERROR_OF_PASSIVE_CHECK_ON_UPDATE
					QkanMessageList.getInstance()
							.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();

					// トランザクション解除
					getDBManager().rollbackTransaction();

					// 処理を終了する。
					return false;
				}

				// SQL文取得用HashMap：paramを生成し、画面上のデータを設定する。
				param = new VRHashMap();
				param = data;

				// 利用者IDを追加
				VRBindPathParser.set("PATIENT_ID", data, new Integer(
						getPatientId()));

				// 利用者情報（PATIENT）を画面上のデータで更新する。
				// ※まだコミットしない。
				strSql = getSQL_UPDATE_PATIENT(param);
				getDBManager().executeUpdate(strSql);

			}

			// 要介護認定履歴情報
			// 要介護認定履歴情報全件削除
			if (getKaigoDataFlg() == 1) {
				// kaigoDataFlgの値が1の場合

				// 全件削除用SQL文取得のためのHashMap：paramを生成し、下記のKEY/VALUEを設定する。
				// ・KEY：PATIENT_ID VALUE：patientId
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// 要介護認定履歴（PATIENT_NINTEI_HISTORY）の該当利用者のレコードを全件削除する。
				// ※まだコミットしない。
				strSql = getSQL_DELETE_NINTEI_HISTORY(param);
				getDBManager().executeUpdate(strSql);

			}

			// 要介護認定履歴情報登録
			if (!(getKaigoHistoryList() == null || getKaigoHistoryList().size() == 0)) {

				for (int i = 0; i < getKaigoHistoryList().size(); i++) {

					param = new VRHashMap();
					param = (VRMap) getKaigoHistoryList().get(i);

					if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
						// 新規の場合（processModeが共通定数のPROCESS_MODE_INSERT）
						// 画面上のデータ（kaigoHistoryList）に、下記のKEY/VALUEを設定する。
						// ・KEY：PATIENT_ID VALUE：patientId
						VRBindPathParser.set("PATIENT_ID", param, new Integer(
								getPatientId()));
					}

					// 要介護認定履歴（PATIENT_NINTEI_HISTORY）に画面上のデータ（kaigoHistoryList）を登録する。
					// ※まだコミットしない。
					strSql = getSQL_INSERT_NINTEI_HISTORY(param);
					getDBManager().executeUpdate(strSql);

				}
			}

			// 異動履歴情報
			// 異動履歴情報全件削除
			if (getIdouDataFlg() == 1) {
				// idouDataFlgの値が1の場合

				// 全件削除用SQL文取得のためのHashMap：paramを生成し、下記のKEY/VALUEを設定する。
				// ・KEY：PATIENT_ID VALUE：patientId
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// 異動履歴（PATIENT_CHANGES_HISTORY）の該当利用者のレコードを全件削除する。
				// ※まだコミットしない。
				strSql = getSQL_DELETE_CHANGES_HISTORY(param);
				getDBManager().executeUpdate(strSql);

			}

			// 異動履歴情報登録
			if (!(getIdouHistoryList() == null || getIdouHistoryList().size() == 0)) {

				for (int i = 0; i < getIdouHistoryList().size(); i++) {

					param = new VRHashMap();
					param = (VRMap) getIdouHistoryList().get(i);

					if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
						// 新規の場合（processModeが共通定数のPROCESS_MODE_INSERT）
						// 画面上のデータ（idouHistoryList）に、下記のKEY/VALUEを設定する。
						// ・KEY：PATIENT_ID VALUE：patientId
						VRBindPathParser.set("PATIENT_ID", param, new Integer(
								getPatientId()));

					}

					// 異動履歴（PATIENT_CHANGES_HISTORY）に画面上のデータ（idouHistoryList）を登録する。
					// ※まだコミットしない。
					strSql = getSQL_INSERT_CHANGES_HISTORY(param);
					getDBManager().executeUpdate(strSql);

				}
			}

			// 施設履歴情報
			// 施設履歴情報全件削除
			if (getShisetsuDataFlg() == 1) {
				// shisetsuDataFlgの値が1の場合

				// 全件削除用SQL文取得のためのHashMap：paramを生成し、下記のKEY/VALUEを設定する。
				// ・KEY：PATIENT_ID VALUE：patientId
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// 施設履歴（PATIENT_SHISETSU_HISTORY）の該当利用者のレコードを全件削除する。
				// ※まだコミットしない。
				strSql = getSQL_DELETE_SHISETSU_HISTORY(param);
				getDBManager().executeUpdate(strSql);

			}

			// [ID:0000749][Masahiko.Higuchi] add - begin 特定入所者の履歴管理機能
			if(!(getShisetsuHistoryList() == null || getShisetsuHistoryList().size() == 0)) {
				
				for (int j = 0; j < getShisetsuHistoryList().size(); j++) {
					// 施設履歴情報登録
					param = new VRHashMap();
					param = (VRMap)getShisetsuHistoryList().get(j);

					// 利用者ID追加
					VRBindPathParser.set("PATIENT_ID", param, new Integer(
							getPatientId()));
					// 特定入所フラグによる値の初期化
					if(VRBindPathParser.has("TOKUTEI_NYUSHO_FLAG", param) && ACCastUtilities.toInt(param.getData("TOKUTEI_NYUSHO_FLAG"),1) == 1) {
						param.setData("LIMIT_SHOKUHI",null);
						param.setData("LIMIT_UNIT_KOSHITSU",null);
						param.setData("LIMIT_UNIT_JUNKOSHITSU",null);
						param.setData("LIMIT_JURAIGATA1",null);
						param.setData("LIMIT_JURAIGATA2",null);
						param.setData("LIMIT_TASHOSHITSU",null);
						param.setData("LIMIT_TASHOSHITSU2",null);
					}

					// 施設履歴（PATIENT_SHISETSU_HISTORY）に画面上のデータ（shisetsuHistoryList）を登録する。
					// ※まだコミットしない。
					strSql = getSQL_INSERT_SHISETSU_HISTORY(param);
					getDBManager().executeUpdate(strSql);
				}
				
			}
			// [ID:0000749][Masahiko.Higuchi] add - end
			// [ID:0000749][Masahiko.Higuchi] del - begin 特定入所者の履歴管理機能
//			// 施設履歴情報登録
//			param = new VRHashMap();
//			param = data;
//
//			// 利用者ID追加
//			VRBindPathParser.set("PATIENT_ID", param, new Integer(
//					getPatientId()));
//
//			// 履歴番号を追加する。
//			VRBindPathParser.set("SHISETSU_HISTORY_ID", param, new Integer(1));
//
//			// 施設履歴（PATIENT_SHISETSU_HISTORY）に画面上のデータ（shisetsuHistoryList）を登録する。
//			// ※まだコミットしない。
//			strSql = getSQL_INSERT_SHISETSU_HISTORY(param);
//			getDBManager().executeUpdate(strSql);
			// [ID:0000749][Masahiko.Higuchi] del - end
			
			
// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
			// 住所地特例情報
			
			// 住所地特例情報全件削除
			if (getJushotiTokureiDataFlg() == 1) {
				// jushotiTokureiDataFlgの値が1の場合

				// 全件削除用SQL文取得のためのHashMap：paramを生成し、下記のKEY/VALUEを設定する。
				// ・KEY：PATIENT_ID VALUE：patientId
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// 住所地特例情報（PATIENT_JUSHOTI_TOKUREI）の該当利用者のレコードを全件削除する。
				// ※まだコミットしない。
				strSql = getSQL_DELETE_JUSHOTI_TOKUREI(param);
				getDBManager().executeUpdate(strSql);
			}
			
			if(!(getJushotiTokureiList() == null || getJushotiTokureiList().size() == 0)) {
				
				for (int j = 0; j < getJushotiTokureiList().size(); j++) {
					// 施設履歴情報登録
					param = new VRHashMap();
					param = (VRMap)getJushotiTokureiList().get(j);

					// 利用者ID追加
					VRBindPathParser.set("PATIENT_ID", param, new Integer(
							getPatientId()));
					
					// ※まだコミットしない。
					strSql = getSQL_INSERT_JUSHOTI_TOKUREI(param);
					getDBManager().executeUpdate(strSql);
				}
			}
// 2015/1/14 [Yoichiro Kamei] add - end
			
			// 上記のSQL発行処理に成功した場合
			// DB処理をコミットする。
			getDBManager().commitTransaction();


			// 下記のフラグを初期化する。
			// ・idouTableChangeFlg
			// ・kaigoTableChangeFlg
			// ・kaigoDataFlg
			// ・idouDataFlg
			// ・shisetsuDataFlg
			setIdouTableChangeFlg(0);
			setKaigoTableChangeFlg(0);
			setKaigoDataFlg(0);
			setIdouDataFlg(0);
			setShisetsuDataFlg(0);
			// [ID:0000749][Masahiko.Higuchi] add - begin 特定入所者の履歴管理機能
			setShisetsuTableChangeFlg(0);
			// [ID:0000749][Masahiko.Higuchi] add - end

// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
			setJushotiTokureiTableChangeFlg(0);
// 2015/1/14 [Yoichiro Kamei] add - end
			
			return true;

		} catch (Exception ex) {
			// 上記のSQL発行処理に失敗した場合
			// ロールバックする。
			getDBManager().rollbackTransaction();

			// 例外を投げる。
			throw ex;
		}
	}

	/**
	 * 「レコード取得・画面設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFind() throws Exception {
		// レコード取得・画面設定を行う。

		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// 編集の場合（processModeが共通定数のPROCESS_MODE_UPDATE）
			// 利用者情報を取得する。
			doFindPatient();

			// 要介護履歴情報を取得する。
			doFindKaigo();

			// 異動履歴情報を取得する。
			doFindIdou();

			// 施設履歴情報を取得する。
			doFindShisetsu();
			
// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
			// 住所地特例情報を取得する。
			doFindJushotiTokurei();
// 2015/1/14 [Yoichiro Kamei] add - end

			// 取得した利用者情報（patientInfoList）の最初のレコードを抽出し、
			// 「クライアント領域(contents)」のsourceに設定する。
			if (getPatientInfoList().size() > 0) {
				getBasicInfoAndInfoButton().setSource(
						(VRMap) getPatientInfoList().get(0));
			}

			// 取得した施設履歴情報（shisetsuHistoryList）の最初のレコードを抽出し、
			// 「クライアント領域(contents)」のsourceに設定する。
			if (getShisetsuHistoryList().size() > 0) {
				getShisetsuInfoPanel().setSource(
						(VRMap) getShisetsuHistoryList().get(0));
			}
			
// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
			// 取得した住所地特例情報（jushotiTokureiList）の最初のレコードを抽出し、
			// 「クライアント領域(contents)」のsourceに設定する。
			if (getJushotiTokureiList().size() > 0) {
				getJushotiTokureiInputPanel().setSource(
						(VRMap) getJushotiTokureiList().get(0));
			}
// 2015/1/14 [Yoichiro Kamei] add - end

			// 画面に展開する。
			getContents().bindSource();

		}

		// 取得した要介護履歴情報（kaigoHistoryList）をkaigoTableModelに設定する。
		getKaigoTableModel().setAdaptee(getKaigoHistoryList());

		// 取得した異動履歴情報（idouHistoryList）をidouTableModelに設定する。
		getIdouTableModel().setAdaptee(getIdouHistoryList());

		// [ID:0000749][Masahiko.Higuchi] add - begin 特定入所者の履歴管理機能
		getShisetsuTableModel().setAdaptee(getShisetsuHistoryList());
		// [ID:0000749][Masahiko.Higuchi] add - end
		
// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
		getJushotiTokureiTableModel().setAdaptee(getJushotiTokureiList());
// 2015/1/14 [Yoichiro Kamei] add - end

		if (getKaigoHistoryList() == null || getKaigoHistoryList().size() == 0) {
			// kaigoInfoTableのレコードが0件の場合

			// 居宅介護支援事業所コンボを無効にする。
			setState_ENABLE_SHIEN_FALSE();

			// 介護保健情報領域の初期値作成
			VRMap defaultMap = (VRMap) getKaigoInfo().createSource();
			// 給付率に初期ト値：90を設定する。
			VRBindPathParser.set("INSURE_RATE", defaultMap, "90");
			// 領域のクリア
			getKaigoInfo().setSource(defaultMap);
			getKaigoInfo().bindSource();

			// ボタンの状態を未選択の場合の状態に設定する。
			setState_ENABLE_KAIGO_BUTTON_FALSE();

		} else {
			// kaigoInfoTableのレコードが1件以上の場合

			// テーブルの1列目を選択した状態にする。
			getKaigoInfoTable().setSelectedSortedFirstRow();

		}

		if (getIdouHistoryList() == null || getIdouHistoryList().size() == 0) {
			// idouInfoTableのレコードが0件の場合

			// 異動領域の状態を初期化する。
			setState_IDOU_INIT();

			// 異動情報領域の初期値作成
			VRMap defaultMap = (VRMap) getIdouInfo().createSource();
			// 領域のクリア
			getIdouInfo().setSource(defaultMap);
			getIdouInfo().bindSource();

			// ボタンの状態を未選択の場合の状態に設定する。
			setState_ENABLE_IDOU_BUTTON_FALSE();

		} else {
			// idouInfoTableのレコードが1件以上の場合

			// テーブルの1列目を選択した状態にする。
			getIdouInfoTable().setSelectedSortedFirstRow();

		}

		// [ID:0000749][Masahiko.Higuchi] del - begin 特定入所者の履歴管理機能
//		if (getShisetsuInfoTokuteiCheck().isSelected()) {
//			// 特定入所者チェックがONの場合
//			// 負担限度額領域を有効にする。
//			setState_ENABLE_TOKUTEI_NYUSHO_TRUE();
//		} else {
//			// 特定入所者チェックがOFFの場合
//			// 負担限度額領域を有効にする。
//			setState_ENABLE_TOKUTEI_NYUSHO_FALSE();
//		}
		// [ID:0000749][Masahiko.Higuchi] del - end
		// [ID:0000749][Masahiko.Higuchi] add - begin 特定入所者の履歴管理機能
		if (getShisetsuHistoryList() == null || getShisetsuHistoryList().size() == 0) {
			// shisetsuTableのレコードが0件の場合

			// 異動情報領域の初期値作成
			VRMap defaultMap = (VRMap) getIdouInfo().createSource();
			// 領域のクリア
			getShisetsuInputPanel().setSource(defaultMap);
			getShisetsuInputPanel().bindSource();

			// ボタンの状態を未選択の場合の状態に設定する。
			changeShisetsuState();

		} else {

			// テーブルの1列目を選択した状態にする。
			getShisetsuInfoTable().setSelectedSortedFirstRow();

		}						
		// [ID:0000749][Masahiko.Higuchi] add - begin 特定入所者の履歴管理機能
		
		
// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
		if (getJushotiTokureiList() == null || getJushotiTokureiList().size() == 0) {
			// JushotiTokureiInfoTableのレコードが0件の場合

			// 住所地特例情報領域の初期値作成
			VRMap defaultMap = (VRMap) getJushotiTokureiInputPanel().createSource();
			// 領域のクリア
			getJushotiTokureiInputPanel().setSource(defaultMap);
			getJushotiTokureiInputPanel().bindSource();

			// ボタンの状態を未選択の場合の状態に設定する。
			setState_ENABLE_JUSHOTI_TOKUREI_BUTTON_FALSE();

		} else {

			// テーブルの1列目を選択した状態にする。
			getJushotiTokureiInfoTable().setSelectedSortedFirstRow();

		}
// 2015/1/14 [Yoichiro Kamei] add - end
		
		// システム日付において有効な要介護度を表示する。
		displayNowYokaigodo();

		// フォーカス
		getBasicInfoPatientCd().requestFocus();

		// スナップショットを撮影する。
		getSnapshot().snapshot();
		getSnapShotKaigo().snapshot();
		getSnapShotIdou().snapshot();
		// [ID:0000749][Masahiko.Higuchi] add - begin 特定入所者の履歴管理機能
		getSnapShotShisetsu().snapshot();
		// [ID:0000749][Masahiko.Higuchi] add - end
		
// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
		getSnapShotJushotiTokurei().snapshot();
// 2015/1/14 [Yoichiro Kamei] add - end
	}

	/**
	 * 「利用者情報取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindPatient() throws Exception {
		// 利用者情報取得を行う。

		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {

			// 利用者情報取得し、patientInfoListに格納する。
			setPatientInfoList(QkanCommon.getPatientInfo(getDBManager(),
					getPatientId()));

			if (getPatientInfoList().size() == 0) {
				// レコードが取得できなかった場合

				// 例外処理を行う。このロジックを通るのは当画面に遷移する間に利用者(PATIENT)が削除された場合であるため。
				// エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();

				// 前画面に戻る。(処理を抜ける)
				setCompulsoryBackFlg(1);
				ACFrame.getInstance().back();
				return;

			} else {
				// レコードが取得できた場合

				// 利用者情報（patientInfoList）をパッシブチェック用に退避する。
				getPassiveChecker().reservedPassive(
						getPASSIVE_CHECK_KEY_PATIENT(), getPatientInfoList());
			}
		}

	}

	/**
	 * 「要介護履歴情報取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindKaigo() throws Exception {
		// 要介護履歴情報取得を行う。

		// 取得のためにHashMap：paramを生成し、以下のKEY/VALUEを設定する。
		VRMap param = new VRHashMap();

		// KEY：PATIENT_ID　VALUE：patientId
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

		// 要介護履歴情報を取得し、kaigoHistoryListに格納する。
		String strSql = getSQL_GET_PATIENT_KAIGO(param);
		// 取得
		VRList list = getDBManager().executeQuery(strSql);

		// テーブル表示用に編集して格納する。
		setKaigoHistoryList(toKaigoTableList(list));

		if (getKaigoHistoryList().size() > 0) {
			// 要介護履歴のレコードが1件以上の場合
			// kaigoDataFlgに1を代入する。
			setKaigoDataFlg(1);
		}

// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
		// 「経過的要介護」が履歴にあれば、コンボにも追加する
		boolean keikatekiAri = false;
		for (int i = 0; i < list.size(); i++) {
			// データよりレコードを取り出す。
			VRMap map = (VRMap) list.get(i);
			Integer yokaigodo = ACCastUtilities.toInteger(map.get("JOTAI_CODE"));
			if (yokaigodo == QkanConstants.YOUKAIGODO_KEIKATEKI_YOUKAIGO) {
				keikatekiAri = true;
				break;
			}
		}
		if (keikatekiAri) {
			VRMap map = (VRMap) getKaigoInfoYokaigoInfo().getModelSource();
			VRBindPathParser
			.set("JOTAI_CODE", map, QkanCommon.getArrayFromMasterCode(
					CODE_YOKAIGODO, "JOTAI_CODE"));
			getKaigoInfoYokaigoInfo().setModelSource(map);
			getKaigoInfoYokaigoInfo().bindModelSource();
		}
// 2016/7/5 [Yoichiro Kamei] mod - end
	}

	/**
	 * 「異動履歴情報取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindIdou() throws Exception {
		// 異動履歴情報取得を行う。

		// 取得のためにHashMap：paramを生成し、以下のKEY/VALUEを設定する。
		VRMap param = new VRHashMap();

		// KEY：PATIENT_ID　VALUE：patientId
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

		// 異動履歴情報を取得し、idouHistoryListに格納する。
		String strSql = getSQL_GET_PATIENT_CHANGES(param);

		VRList list = getDBManager().executeQuery(strSql);

		// テーブル表示用に編集する。
		setIdouHistoryList(toIdouTableList(list));

		if (getIdouHistoryList().size() > 0) {
			// 異動履歴のレコードが1件以上の場合
			// idouDataFlgに1を代入する。
			setIdouDataFlg(1);
		}
	}

	/**
	 * 「施設履歴情報取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindShisetsu() throws Exception {
		// 施設履歴情報取得を行う。

		// 取得のためにHashMap：paramを生成し、以下のKEY/VALUEを設定する。
		VRMap param = new VRHashMap();

		// KEY：PATIENT_ID　VALUE：patientId
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

		// 施設履歴情報を取得し、shisetsuHistoryListに格納する。
		String strSql = getSQL_GET_PATIENT_SHISETSU(param);

		setShisetsuHistoryList(getDBManager().executeQuery(strSql));

		if (getShisetsuHistoryList().size() > 0) {
			// 施設履歴のレコードが1件以上の場合
			// shisetsuDataFlgに1を代入する。
			setShisetsuDataFlg(1);
		}
	}

// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
	  /**
	   * 「住所地特例情報取得」に関する処理を行ないます。
	   *
	   * @throws Exception 処理例外
	   *
	   */
	  public void doFindJushotiTokurei() throws Exception {

			// 取得のためにHashMap：paramを生成し、以下のKEY/VALUEを設定する。
			VRMap param = new VRHashMap();

			// KEY：PATIENT_ID　VALUE：patientId
			VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

			// 住所地特例情報を取得し、jushotiTokureiListに格納する。
			String strSql = getSQL_GET_PATIENT_JUSHOTI_TOKUREI(param);

			setJushotiTokureiList(getDBManager().executeQuery(strSql));

			if (getJushotiTokureiList().size() > 0) {
				// 住所地特例のレコードが1件以上の場合
				// jushotiTokureiDataFlgに1を代入する。
				setJushotiTokureiDataFlg(1);
			}
	  }
// 2015/1/14 [Yoichiro Kamei] add - end
	  
	/**
	 * 「画面全体クリア処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doClear() throws Exception {
		// ※画面全体クリア処理
		// ※画面項目クリア
		// 「クライアント領域(contents)」のソースを生成する。
		VRMap map = (VRMap) getContents().createSource();
		// 「一覧に表示する」チェックボックスの値を設定する。
		VRBindPathParser.set("SHOW_FLAG", map, new Integer(1));
		// 給付率
		VRBindPathParser.set("INSURE_RATE", map, "90");

		getContents().setSource(map);

		// 画面に展開する。
		getContents().bindSource();

		// 負担限度額領域を無効にする。
		setState_ENABLE_TOKUTEI_NYUSHO_FALSE();

// 2016/7/5 [Yoichiro Kamei] add - begin 総合事業対応
		// 要介護度のコンボボックスの内容をクリア
		// 「経過的要介護」は詳細画面に表示しない
		VRList list = QkanCommon.getArrayFromMasterCode(CODE_YOKAIGODO, "JOTAI_CODE");
		VRList newList = new VRArrayList();
		for (int i = 0; i < list.size(); i++) {
			VRMap yokaigoMap = (VRMap) list.get(i);
			Integer yokaigo = ACCastUtilities.toInteger(yokaigoMap.get("CONTENT_KEY"));
			if (yokaigo != QkanConstants.YOUKAIGODO_KEIKATEKI_YOUKAIGO) {
				newList.add(yokaigoMap);
			}
		}
		VRMap modelSource = (VRMap) getKaigoInfoYokaigoInfo().getModelSource();
		VRBindPathParser.set("JOTAI_CODE", modelSource, newList);
		getKaigoInfoYokaigoInfo().setModelSource(modelSource);
		getKaigoInfoYokaigoInfo().bindModelSource();
// 2016/7/5 [Yoichiro Kamei] add - end
				
		// ※プライベート変数クリア
		// 以下のプライベート変数を初期化する。
		// ・patientId
		// ・patientInfoList
		// ・kaigoHistoryList
		// ・idouHistoryList
		// ・shisetsuHistoryList
		// ・idouTableChangeFlg
		// ・kaigoTableChangeFlg
		// ・kaigoDataFlg
		// ・idouDataFlg
		// ・shisetsuDataFlg
		setPatientId(0);
		getPatientInfoList().clear();
		getKaigoHistoryList().clear();
		getIdouHistoryList().clear();
		getShisetsuHistoryList();
		setIdouTableChangeFlg(0);
		setKaigoTableChangeFlg(0);
		setKaigoDataFlg(0);
		setIdouDataFlg(0);
		setShisetsuDataFlg(0);
		// [ID:0000749][Masahiko.Higuchi] add - begin 特定入所者の履歴管理機能
		setShisetsuTableChangeFlg(0);
		// [ID:0000749][Masahiko.Higuchi] add - end

// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
		getJushotiTokureiList().clear();
		setJushotiTokureiTableChangeFlg(0);
		setJushotiTokureiDataFlg(0);
// 2015/1/14 [Yoichiro Kamei] add - end
		
		// システム日付において有効な要介護度を表示する。
		displayNowYokaigodo();

		// ※モードの切り替え
		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// 更新モードの場合（processModeが共通定数のPROCESS_MODE_UPDATE）

			// processModeにPROCESS_MODE_INSERTを代入する。
			setProcessMode(QkanConstants.PROCESS_MODE_INSERT);

		}

		// 業務ボタンの状態設定を行う。
		setState_INSERT_MODE();

		// フォーカス
		getBasicInfoPatientCd().requestFocus();

		// スナップショット撮影
		getSnapshot().snapshot();
		getSnapShotKaigo().snapshot();
		getSnapShotIdou().snapshot();
		
// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
		getSnapShotJushotiTokurei().snapshot();
// 2015/1/14 [Yoichiro Kamei] add - end
	}

	/**
	 * 「画面初期化」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void initialize() throws Exception {
		// 画面の初期化を行う。

		// 業務情報マスタより、データを取得する。
		// 取得したデータのウィンドウタイトル（WINDOW_TITLE）をウィンドウに設定する。
		// 取得したデータの業務タイトル（AFFAIR_TITLE）を業務ボタンバーに設定する。
		setAffairTitle(AFFAIR_ID, getButtons());

		// パッシブキーの定義
		setPASSIVE_CHECK_KEY_PATIENT(new ACPassiveKey("PATIENT",
				new String[] { "PATIENT_ID" }, new Format[] { null },
				"LAST_TIME", "LAST_TIME"));

		// テーブルモデルの生成
		ACTableModelAdapter model = null;

		// kaigoTableModelを生成する。
		// "SHINSEI_DATE" "SHUBETSU_CODE" "JOTAI_CODE" "INSURE_VALID_START"
		// "INSURE_VALID_END" "REPORTED_DATE"
		// "STOP_DATE" "STOP_REASON" "LIMIT_RATE"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "SYSTEM_INSURE_VALID_START", "SYSTEM_INSURE_VALID_END", "INSURE_RATE",
				"SHINSEI_DATE", "SHUBETSU_CODE_NAME",
				"JOTAI_CODE_NAME", "INSURE_VALID_START", "INSURE_VALID_END",
				"REPORTED_DATE", "STOP_DATE", "STOP_REASON_NAME", "LIMIT_RATE" });
		setKaigoTableModel(model);

		// idouTableModelを生成する。
		// "SYSTEM_SERVICE_KIND_DETAIL" "CHANGES_CONTENT" "CHANGES_DATE"
		// "CHANGES_TIME" "CHANGES_REASON"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "SERVICE_ABBREVIATION", "CONTENT",
				"CHANGES_DATE", "CHANGES_TIME", "REASON" });
		// model.setColumns(new String[]{
		// "SYSTEM_SERVICE_KIND_DETAIL",
		// "CONTENT",
		// "CHANGES_DATE",
		// "CHANGES_TIME",
		// "REASON"
		// });
		setIdouTableModel(model);
		
// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "JUSHOTI_VALID_START", "JUSHOTI_VALID_END",
				"JUSHOTI_INSURER_ID" });
		setJushotiTokureiTableModel(model);
		getJushotiTokureiInfoTable().setModel(getJushotiTokureiTableModel());
// 2015/1/14 [Yoichiro Kamei] add - end

		// テーブルモデルを下記の画面テーブルに設定する。
		// ・「介護情報・テーブル領域（kaigoInfoTable）」
		getKaigoInfoTable().setModel(getKaigoTableModel());
		// ・「異動情報・テーブル領域（idouInfoTable）」
		getIdouInfoTable().setModel(getIdouTableModel());

		// 各テーブルカラムにフォーマッタを設定する。
		// 申請区分
		// getKaigoInfoTableColumn2().setFormat(new ACHashMapFormat(
		// new String[] { "新規・期間終了後新規", "更新", "変更" },
		// new Integer[] {new Integer(1), new Integer(2), new Integer(3),}));

		// 要介護度
		// getKaigoInfoTableColumn3().setFormat(new
		// QkanJotaiCodeUnapplicableFormat());

		// // 中断理由
		// getKaigoInfoTableColumn8().setFormat(new ACHashMapFormat(
		// new String[] { "非更新", "非該当", "死亡" },
		// new Integer[] {new Integer(1),new Integer(2), new Integer(3),}));
		//
		// // サービス
		// getIdouInfoTableColumn1().setFormat(new QkanServiceFormat());

		// // 異動事由
		// getIdouInfoTableColumn2().setFormat(new QkanChangesContentFormat());

		// // 異動理由
		// getIdouInfoTableColumn5().setFormat(new QkanChangesReasonFormat());

		// かな補完
		// 氏名とかなを関連付ける。
		getBasicInfoName1().setKanaField(getBasicInfoFurigana1());
		getBasicInfoName2().setKanaField(getBasicInfoFurigana2());

		// 郵便番号から住所変換
		// 郵便番号と住所を関連付ける。
		new ACZipRelation(getBasicInfoZip1(), getBasicInfoZip3(),
				getBasicInfoAddress());

		// スナップショットの撮影対象を「クライアント領域（contents）」に指定する。
		getSnapshot().setRootContainer(getContents());

		// ※スナップショットの撮影対象から下記の領域を除外する。
		// ・「異動情報領域・上（idouInfoUp）」
		// ・「介護保険領域（kaigoInfo）」
		VRList excusions = new VRArrayList();
		excusions.add(getIdouInfoUp());
		excusions.add(getKaigoInfo());

		getSnapshot().setExclusions(excusions);

		// 要介護情報領域のスナップショット
		getSnapShotKaigo().setRootContainer(getKaigoInfo());
		// 異動情報領域のスナップショット
		getSnapShotIdou().setRootContainer(getIdouInfo());

		// [ID:0000749][Masahiko.Higuchi] add - begin 特定入所者の履歴管理機能
		// 施設情報のスナップショット
		getSnapShotShisetsu().setRootContainer(getShisetsuInputPanel());
		// [ID:0000749][Masahiko.Higuchi] add - end

// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
		getSnapShotJushotiTokurei().setRootContainer(getJushotiTokureiInputPanel());
// 2015/1/14 [Yoichiro Kamei] add - end
		
		// 画面設定を行う。
		casualInitialize();

		// if(getProcessMode() == QkanConstants.PROCESS_MODE_INSERT){
		// // 新規追加モードの場合
		// // 「一覧に表示する」チェックボックスに初期値を設定する。
		// getBasicInfoCheck().setValue(1);
		// }

		// 画面に初期値を表示する。
		VRMap map = (VRMap) getContents().createSource();
		// 「一覧に表示する」チェックボックスの値を設定する。
		VRBindPathParser.set("SHOW_FLAG", map, new Integer(1));

		getContents().setSource(map);
		getContents().bindSource();

	}

	/**
	 * 「画面設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void casualInitialize() throws Exception {
		// 画面を設定する。

		// VRMap mapを生成する。
		VRMap map = new VRHashMap();

		// システム日付の取得
		setSystemDate(QkanSystemInformation.getInstance().getSystemDate());

		// コードマスタデータの取得
		setMasterCode(QkanSystemInformation.getInstance().getMasterCode());

		

		// コードマスタから下記のCODE_IDのレコードを抽出し、下記のKEYでmapに設定する。
		// ・CODE_ID：CODE_YOKAIGODO　KEY：JOTAI_CODE

// 2016/7/5 [Yoichiro Kamei] mod - begin 総合事業対応
// 「経過的要介護」は詳細画面に表示しない
// 履歴に登録されている場合は、介護保険情報の取得後にコンボに追加する。
//		VRBindPathParser
//				.set("JOTAI_CODE", map, QkanCommon.getArrayFromMasterCode(
//						CODE_YOKAIGODO, "JOTAI_CODE"));
		
		VRList list = QkanCommon.getArrayFromMasterCode(CODE_YOKAIGODO, "JOTAI_CODE");
		VRList newList = new VRArrayList();
		for (int i = 0; i < list.size(); i++) {
			VRMap yokaigoMap = (VRMap) list.get(i);
			Integer yokaigo = ACCastUtilities.toInteger(yokaigoMap.get("CONTENT_KEY"));
			if (yokaigo != QkanConstants.YOUKAIGODO_KEIKATEKI_YOUKAIGO) {
				newList.add(yokaigoMap);
			}
		}
		VRBindPathParser.set("JOTAI_CODE", map, newList);
// 2016/7/5 [Yoichiro Kamei] mod - end

		// ・CODE_ID：CODE_INSURE_RATE　KEY：INSURE_RATE
		// VRBindPathParser.set(
		// "INSURE_RATE", map,
		// QkanCommon.getArrayFromMasterCode(CODE_INSURE_RATE, "INSURE_RATE"));

		// サービスマスタレコードを取得し、以下のKEYでmapに設定する。
		// ・KEY：SERVICE
		VRList service = new VRArrayList();
// 2016/2/8 [Shinobu Hitaka] mod - begin H28.4改正対応
//// 2015/1/9 [Yoichiro Kamei] mod - begin H27.4改正対応
////		setMasterService(QkanCommon.getMasterService(getDBManager(),
////				QkanConstants.H2404));
//		setMasterService(QkanCommon.getMasterService(getDBManager(),
//		QkanConstants.H2704));
//// 2015/1/9 [Yoichiro Kamei] mod - end
		setMasterService(QkanCommon.getMasterService(getDBManager(),
		QkanConstants.H2804));
// 2016/2/8 [Shinobu Hitaka] mod - end
		VRList temp = new VRArrayList(getMasterService().values());

		if (!(temp == null || temp.size() == 0)) {
			for (int i = 0; i < temp.size(); i++) {
				VRMap serviceMap = (VRMap) temp.get(i);
				int systemServiceKindDetail = ACCastUtilities
						.toInt(VRBindPathParser.get(
								"SYSTEM_SERVICE_KIND_DETAIL", serviceMap));

				// 「その他」「主な日常生活上の活動」を排除
				if (!(systemServiceKindDetail == SERVICE_TYPE_OTHER || systemServiceKindDetail == SERVICE_TYPE_ROUTINE)) {
					// 2016/2/8 [Shinobu Hitaka] add - begin 「サービス種類:サービス名」を表示
					String serviceName = ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_KIND", serviceMap))
							+ ":"
							+ ACCastUtilities.toString(VRBindPathParser.get("SERVICE_ABBREVIATION", serviceMap));
					// 2016/2/8 [Shinobu Hitaka] add - end
					VRBindPathParser.set("SERVICE_ABBREVIATION", serviceMap, serviceName);
					service.add(serviceMap);
				}

			}
		}

		VRBindPathParser.set("SERVICE", map, service);

		// 居宅介護支援事業所情報を取得し、listに格納する。
		// ※居宅介護支援、小規模多機能型を提供している事業所
		VRList serviceKind = new VRArrayList();
		serviceKind.add(new Integer(SERVICE_TYPE_SHIEN));
		serviceKind.add(new Integer(SERVICE_TYPE_SHOKIBO));
		// [ID:0000724][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
		serviceKind.add(new Integer(SERVICE_TYPE_FUKUGOUGATA));
		// [ID:0000724][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add end
		setProviderListKaigoShien(QkanCommon.getProviderInfo(getDBManager(),
				serviceKind));

		// ※介護予防支援、介護予防小規模多機能型を提供している事業所
		serviceKind = new VRArrayList();
		serviceKind.add(new Integer(SERVICE_TYPE_YOBOU_SHIEN));
		serviceKind.add(new Integer(SERVICE_TYPE_YOBOU_SHOKIBO));
		
// 2016/7/5 [Yoichiro Kamei] add - begin 総合事業対応
		// 介護予防ケアマネジメントを提供している事業所
		serviceKind.add(new Integer(SERVICE_TYPE_YOBOU_CAREMGM));
// 2016/7/5 [Yoichiro Kamei] add - end
		
		setProviderListYobouShien(QkanCommon.getProviderInfo(getDBManager(),
				serviceKind));

		// VRBindPathParser.set(
		// "PROVIDER", map, QkanCommon.getProviderInfo(getDBManager(),
		// serviceKind));

		// 保険者情報を取得し、以下のKEYでmapに設定する。（パラメータ省略）
		// ・KEY：INSURER
		VRBindPathParser.set("INSURER", map,
				QkanCommon.getInsurerInfoCareOnly(getDBManager()));

// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
		//住所地特例の保険者コンボ用にキー値をコピー
		if (VRBindPathParser.get("INSURER", map) != null) {
			ACBindUtilities.copyBindPath((VRList)VRBindPathParser.get("INSURER", map), "INSURER_ID", "JUSHOTI_INSURER_ID");
		}
// 2015/1/14 [Yoichiro Kamei] add - end
		
		// mapを「クライアント領域（contents）」に設定する。
		getContents().setModelSource(map);

		// mapを画面に展開する。
		getContents().bindModelSource();

		// 業務ボタンの状態設定を行う。
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// 新規の場合（processModeが共通定数のPROCESS_MODE_INSERT）
			setState_INSERT_MODE();
		} else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// 編集の場合（processModeが共通定数のPROCESS_MODE_UPDATE）
			setState_UPDATE_MODE();
		}

		// 異動情報領域の状態を初期化する。
		setState_IDOU_INIT();
	}

	/**
	 * 「データ編集」に関する処理を行ないます。 認定情報をテーブル表示用に編集する関数です。
	 * 
	 * @return VRList 認定情報（編集済）
	 * @param VRList
	 *            認定情報（複数件）
	 * @throws Exception
	 *             処理例外
	 */
	public VRList toKaigoTableList(VRList list) throws Exception {

		if (list == null) {
			return null;
		}

		VRList result = new VRArrayList();

		// 渡されたデータの件数分ループする。
		for (int i = 0; i < list.size(); i++) {
			// データよりレコードを取り出す。
			VRMap map = (VRMap) list.get(i);
			// レコードをテーブル表示用に編集する。
			map = toKaigoTableList(map);
			// データに追加
			result.add(map);
		}

		return result;

	}

	/**
	 * 「データ編集」に関する処理を行ないます。 認定情報をテーブル表示用に編集する関数です。
	 * 
	 * @return VRMap 認定情報（編集済）
	 * @param VRMap
	 *            認定情報（単件）
	 * @throws Exception
	 *             処理例外
	 */
	public VRMap toKaigoTableList(VRMap map) throws Exception {

		if (map == null) {
			return null;
		}

		// コードマスタより名称を取得する。
		VRList list = null;
		VRMap temp = null;

		// 要介護度
		list = new VRArrayList();
		list = (VRList) VRBindPathParser.get(new Integer(CODE_YOKAIGODO),
				getMasterCode());
		temp = new VRHashMap();
		if (VRBindPathParser.has("JOTAI_CODE", map)) {
			temp = ACBindUtilities.getMatchRowFromValue(list, "CONTENT_KEY",
					VRBindPathParser.get("JOTAI_CODE", map));
			if (temp != null) {
				VRBindPathParser.set("JOTAI_CODE_NAME", map,
						VRBindPathParser.get("CONTENT", temp));
			}
		}

		// 申請区分
		list = new VRArrayList();
		list = (VRList) VRBindPathParser.get(new Integer(CODE_SHINSEI_KUBUN),
				getMasterCode());
		temp = new VRHashMap();
		if (VRBindPathParser.has("SHUBETSU_CODE", map)) {
			temp = ACBindUtilities.getMatchRowFromValue(list, "CONTENT_KEY",
					VRBindPathParser.get("SHUBETSU_CODE", map));
			if (temp != null) {
				VRBindPathParser.set("SHUBETSU_CODE_NAME", map,
						VRBindPathParser.get("CONTENT", temp));
			}
		}

		// 中断理由
		list = new VRArrayList();
		list = (VRList) VRBindPathParser.get(new Integer(CODE_TYUDAN_RIYU),
				getMasterCode());
		temp = new VRHashMap();
		if (VRBindPathParser.has("STOP_REASON", map)) {
			temp = ACBindUtilities.getMatchRowFromValue(list, "CONTENT_KEY",
					VRBindPathParser.get("STOP_REASON", map));
			if (temp != null) {
				VRBindPathParser.set("STOP_REASON_NAME", map,
						VRBindPathParser.get("CONTENT", temp));
			}
		}
		
		
		// 2016/7/18 [Yoichiro Kamei] add - begin 総合事業対応
		// 事業対象者の限度額変更フラグ値がNULLの場合１を設定する
		if (VRBindPathParser.has("LIMIT_CHANGE_FLAG", map)) {
			if (VRBindPathParser.get("LIMIT_CHANGE_FLAG", map) == null) {
				VRBindPathParser.set("LIMIT_CHANGE_FLAG", map, 1);
			}
		}
		// 2016/7/18 [Yoichiro Kamei] add - end
				
		return map;

	}

	/**
	 * 「データ編集」に関する処理を行ないます。 異動情報をテーブル表示用に編集する関数です。
	 * 
	 * @return VRList 異動情報（編集済）
	 * @param VRList
	 *            異動情報（複数件）
	 * @throws Exception
	 *             処理例外
	 */
	public VRList toIdouTableList(VRList list) throws Exception {

		if (list == null) {
			return null;
		}

		VRList result = new VRArrayList();

		// 渡されたデータの件数分ループする。
		for (int i = 0; i < list.size(); i++) {
			// データよりレコードを取り出す。
			VRMap map = (VRMap) list.get(i);
			// レコードをテーブル表示用に編集する。
			map = toIdouTableList(map);
			// データに追加
			result.add(map);
		}

		return result;

	}

	/**
	 * 「データ編集」に関する処理を行ないます。 異動情報をテーブル表示用に編集する関数です。
	 * 
	 * @return VRMap 異動情報（編集済）
	 * @param VRMap
	 *            異動情報（1件）
	 * @throws Exception
	 *             処理例外
	 */
	public VRMap toIdouTableList(VRMap map) throws Exception {

		// 異動情報をテーブル表示用に編集する。

		if (map == null) {
			return null;
		}

		// 渡された異動情報のサービス種類コード
		int serviceType = ACCastUtilities.toInt(VRBindPathParser.get(
				"SYSTEM_SERVICE_KIND_DETAIL", map));

		// サービス種類コードを用いて、サービスデータを取得
		VRMap service = (VRMap) VRBindPathParser.get(new Integer(serviceType),
				getMasterService());

		// 対象外サービスの場合
		if (service == null) {
			return null;
		}

		// マスタデータよりサービス名称の取得
		String serviceName = ACCastUtilities.toString(VRBindPathParser.get(
				"SERVICE_ABBREVIATION", service));

		// 渡されたVRMapに設定
		VRBindPathParser.set("SERVICE_ABBREVIATION", map, serviceName);

		// 渡された異動情報の異動事由
		int content = 0;

		if (!(VRBindPathParser.get("CHANGES_CONTENT", map) == null || ""
				.equals(VRBindPathParser.get("CHANGES_CONTENT", map)))) {
			content = ACCastUtilities.toInt(VRBindPathParser.get(
					"CHANGES_CONTENT", map));
		}

		// 渡された異動情報の異動理由
		int reason = 0;

		if (!(VRBindPathParser.get("CHANGES_REASON", map) == null || ""
				.equals(VRBindPathParser.get("CHANGES_REASON", map)))) {
			reason = ACCastUtilities.toInt(VRBindPathParser.get(
					"CHANGES_REASON", map));
		}

		// サービスのCHANGES_CONTENT_TYPEを取得
		int contentType = ACCastUtilities.toInt(VRBindPathParser.get(
				"CHANGES_CONTENT_TYPE", service));

		// 異動事由・異動理由の変換処理
		// 定義
		// コードマスタより取得した異動事由と異動理由を格納する。
		VRList codeContentList;
		VRList codeReasonList;

		VRMap temp;

		switch (contentType) {

		// 居宅系
		case IDOU_SERVICE_KYOTAKU:
			// コードマスタより居宅系異動事由のデータ取得
			codeContentList = new VRArrayList();
			codeContentList = (VRList) VRBindPathParser.get(new Integer(
					CODE_IDOU_CONTENT_KYOTAKU), getMasterCode());

			// 異動事由　※CONTENT列追加
			temp = new VRHashMap();
			temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
					codeContentList, "CONTENT_KEY", new Integer(content));

			VRBindPathParser.set("CONTENT", map,
					VRBindPathParser.get("CONTENT", temp));

			if (content == IDOU_STOP_KYOTAKU) {

				// コードマスタより居宅系異動理由のデータ取得
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(
						CODE_IDOU_REASON_KYOTAKU), getMasterCode());

				// 異動理由　※REASON列追加
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
						codeReasonList, "CONTENT_KEY", new Integer(reason));

				VRBindPathParser.set("REASON", map,
						VRBindPathParser.get("CONTENT", temp));

			}

			break;

		// 施設系1
		case IDOU_SERVICE_SHISETSU1:
			// コードマスタより施設系1異動事由のデータ取得
			codeContentList = new VRArrayList();
			codeContentList = (VRList) VRBindPathParser.get(new Integer(
					CODE_IDOU_CONTENT_SHISETSU1), getMasterCode());

			// 異動事由　※CONTENT列追加
			temp = new VRHashMap();
			temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
					codeContentList, "CONTENT_KEY", new Integer(content));

			VRBindPathParser.set("CONTENT", map,
					VRBindPathParser.get("CONTENT", temp));

			if (content == IDOU_STOP_SHISETSU1) {

				// コードマスタより施設系1異動理由のデータ取得
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(
						CODE_IDOU_REASON_SHISETSU1), getMasterCode());

				// 異動理由　※REASON列追加
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
						codeReasonList, "CONTENT_KEY", new Integer(reason));

				VRBindPathParser.set("REASON", map,
						VRBindPathParser.get("CONTENT", temp));

			}
			// [ID:0000453][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
			else if (content == IDOU_START_SHISETSU1) {
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(
						CODE_IDOU_REASON_NYUSYO_NYUIN), getMasterCode());
				// 異動理由　※REASON列追加
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
						codeReasonList, "CONTENT_KEY", new Integer(reason));
				VRBindPathParser.set("REASON", map,
						VRBindPathParser.get("CONTENT", temp));
			}
			// [ID:0000453][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
			break;

		// 施設系2
		case IDOU_SERVICE_SHISETSU2:
			// コードマスタより施設系2異動事由のデータ取得
			codeContentList = new VRArrayList();
			codeContentList = (VRList) VRBindPathParser.get(new Integer(
					CODE_IDOU_CONTENT_SHISETSU2), getMasterCode());

			// 異動事由　※CONTENT列追加
			temp = new VRHashMap();
			temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
					codeContentList, "CONTENT_KEY", new Integer(content));

			VRBindPathParser.set("CONTENT", map,
					VRBindPathParser.get("CONTENT", temp));

			if (content == IDOU_STOP_SHISETSU2) {

				// コードマスタより施設系2異動理由のデータ取得
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(
						CODE_IDOU_REASON_SHISETSU2), getMasterCode());

				// 異動理由　※REASON列追加
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
						codeReasonList, "CONTENT_KEY", new Integer(reason));

				VRBindPathParser.set("REASON", map,
						VRBindPathParser.get("CONTENT", temp));

			}
			// [ID:0000453][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
			else if (content == IDOU_START_SHISETSU2) {
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(
						CODE_IDOU_REASON_NYUSYO_NYUIN), getMasterCode());
				// 異動理由　※REASON列追加
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
						codeReasonList, "CONTENT_KEY", new Integer(reason));
				VRBindPathParser.set("REASON", map,
						VRBindPathParser.get("CONTENT", temp));
			}
			// [ID:0000453][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応

			break;

		// 医療看護
		case IDOU_SERVICE_IRYO_KANGO:
			// コードマスタより医療看護異動事由のデータ取得
			codeContentList = new VRArrayList();
			codeContentList = (VRList) VRBindPathParser.get(new Integer(
					CODE_IDOU_CONTENT_IRYO_KANGO), getMasterCode());

			// 異動事由　※CONTENT列追加
			temp = new VRHashMap();
			temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
					codeContentList, "CONTENT_KEY", new Integer(content));

			VRBindPathParser.set("CONTENT", map,
					VRBindPathParser.get("CONTENT", temp));

			if (content == IDOU_STOP_IRYO_KANGO) {

				// コードマスタより医療看護異動理由のデータ取得
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(
						CODE_IDOU_REASON_IRYO_KANGO), getMasterCode());

				// 異動理由　※REASON列追加
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
						codeReasonList, "CONTENT_KEY", new Integer(reason));

				VRBindPathParser.set("REASON", map,
						VRBindPathParser.get("CONTENT", temp));

			}

			break;

		// 施設系3
		case IDOU_SERVICE_SHISETSU3:
			// コードマスタより施設系3異動事由のデータ取得
			codeContentList = new VRArrayList();
			codeContentList = (VRList) VRBindPathParser.get(new Integer(
					CODE_IDOU_CONTENT_SHISETSU3), getMasterCode());

			// 異動事由　※CONTENT列追加
			temp = new VRHashMap();
			temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
					codeContentList, "CONTENT_KEY", new Integer(content));

			VRBindPathParser.set("CONTENT", map,
					VRBindPathParser.get("CONTENT", temp));

			if (content == IDOU_STOP_IRYO_KANGO) {

				// コードマスタより施設系3異動理由のデータ取得
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(
						CODE_IDOU_REASON_SHISETSU3), getMasterCode());

				// 異動理由　※REASON列追加
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
						codeReasonList, "CONTENT_KEY", new Integer(reason));

				VRBindPathParser.set("REASON", map,
						VRBindPathParser.get("CONTENT", temp));

			}
			// [ID:0000453][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
			else if (content == IDOU_START_SHISETSU3) {
				codeReasonList = new VRArrayList();
				codeReasonList = (VRList) VRBindPathParser.get(new Integer(
						CODE_IDOU_REASON_NYUSYO_NYUIN), getMasterCode());
				// 異動理由　※REASON列追加
				temp = new VRHashMap();
				temp = (VRMap) ACBindUtilities.getMatchRowFromValue(
						codeReasonList, "CONTENT_KEY", new Integer(reason));
				VRBindPathParser.set("REASON", map,
						VRBindPathParser.get("CONTENT", temp));
			}
			// [ID:0000453][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
			break;
		}

		return map;

	}

	/**
	 * 「現在の要介護度を表示」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void displayNowYokaigodo() throws Exception {
		// 現在の要介護度を表示する
		String yokaigodoNow = "";
		boolean hasHigaito = false;
		VRList target = (VRList) getKaigoTableModel().getAdaptee();

		if (target == null || target.size() == 0) {
			// 履歴を持っていないケース
			yokaigodoNow = "認定履歴なし";
		} else {
			for (int i = 0; i < target.size(); i++) {
				VRMap temp = (VRMap) target.get(i);
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//				Date start = ACCastUtilities.toDate(VRBindPathParser.get(
//						"INSURE_VALID_START", temp));
//				Date end = ACCastUtilities.toDate(VRBindPathParser.get(
//						"INSURE_VALID_END", temp));
				Date start = ACCastUtilities.toDate(VRBindPathParser.get(
						"SYSTEM_INSURE_VALID_START", temp));
				
// 2016/7/5 [Yoichiro Kamei] add - begin 総合事業対応
//				Date end = ACCastUtilities.toDate(VRBindPathParser.get(
//						"SYSTEM_INSURE_VALID_END", temp));
				Date end;
				if (ACTextUtilities.isNullText(VRBindPathParser.get("SYSTEM_INSURE_VALID_END", temp))) {
					end = MAX_DATE;
				} else {
					end = ACCastUtilities.toDate(VRBindPathParser.get(
							"SYSTEM_INSURE_VALID_END", temp));
				}
// 2016/7/5 [Yoichiro Kamei] mod - end
				
// 2014/12/17 [Yoichiro Kamei] mod - end
				if (isValidTermOnTargetDate(getSystemDate(), start, end)) {
					// システム日付において有効な認定履歴である場合
					int yokaigodo = ACCastUtilities.toInt(VRBindPathParser.get(
							"JOTAI_CODE", temp));
					if (yokaigodo == YOUKAIGODO_HIGAITOU) {
						// 非該当の場合は一時保留
						hasHigaito = true;
					} else {
						// 非該当でない場合はループ終了
						yokaigodoNow = ACCastUtilities
								.toString(VRBindPathParser.get(
										"JOTAI_CODE_NAME", temp));
						break;
					}
				}
			}
		}

		// 上記ループで現在の要介護度を取得できないケース
		if (yokaigodoNow == null || "".equals(yokaigodoNow)) {
			if (hasHigaito) {
				// 非該当を持っているケース
				yokaigodoNow = "非該当";
			} else {
				// 非該当を持っていないケース
				yokaigodoNow = "有効期間外";
			}
		}

		// 表示
		getYokaigodoNow().setText(yokaigodoNow);

	}

	/**
	 * 「有効な期間かどうかの判定」に関する処理を行ないます。 指定日付において有効な期間かどうかを判定する関数です。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean isValidTermOnTargetDate(Date targetDate, Date start, Date end)
			throws Exception {
		// 指定日付において有効な期間かどうかを判定する関数

		if (ACDateUtilities.getDifferenceOnDay(targetDate, start) >= 0
				&& ACDateUtilities.getDifferenceOnDay(targetDate, end) <= 0) {
			return true;
		}

		return false;
	}

	public Component getFirstFocusComponent() {
		return getBasicInfoPatientCd();
	}


	/**
	 * 特定入所者チェック イベント
	 * 
	 */
	protected void shisetsuInfoTokuteiCheckActionPerformed(ActionEvent e)
			throws Exception {
		// 状態制御
		changeShisetsuState();

	}
	
	/**
	 * 施設情報 - クリアボタンイベント
	 * 
	 */
	protected void shisetsuInfoButtonClearActionPerformed(ActionEvent e)
			throws Exception {

		int kyusochiFlag = 1;
		String disease = "";
		VRMap src = null;
		VRMap tempSrc = null;
		Date historyDate = null;
		
		// 施設情報の先頭を取得する
		if(getShisetsuHistoryList().size() > 0) {
			for(int i=0; i < getShisetsuHistoryList().size();i++) {
				// 採用するレコードを判定する
				tempSrc = (VRMap)getShisetsuHistoryList().getData(i);
				if(historyDate == null) {
					historyDate = ACCastUtilities.toDate(tempSrc.getData("SHISETSU_VALID_START"));
					src = (VRMap)getShisetsuHistoryList().getData(i);
					continue;
				}
				if(ACDateUtilities.compareOnDay(historyDate, ACCastUtilities.toDate(tempSrc.getData("SHISETSU_VALID_START"))) < 0) {
					// 有効期間開始が現在のレコードより後ろのものを採用する
					src = (VRMap)getShisetsuHistoryList().getData(i);
				}
			}
			
			disease = ACCastUtilities.toString(src.getData("DISEASE"),"");
			kyusochiFlag = ACCastUtilities.toInt(src.getData("KYUSOCHI_FLAG"),1);
		}
		
		if (getShisetsuInfoTable().isSelected()) {
			// 画面テーブルが選択されている場合
			// 画面テーブルの行を未選択の状態に設定する。
			getShisetsuInfoTable().clearSelection();

		}
		
		VRMap map = new VRHashMap();
		// 画面のソースを生成する。
		map = (VRMap) getShisetsuInputPanel().createSource();
		map.setData("DISEASE", disease);
		map.setData("KYUSOCHI_FLAG", kyusochiFlag);

		// 「施設情報領域」のソースとして設定する。
		getShisetsuInputPanel().setSource(map);

		// 画面に展開する。
		getShisetsuInputPanel().bindSource();
		
		// 非選択状態ならスナップショットを取る
		if(!getShisetsuInfoTable().isSelected()) {
			// スナップショット
			getSnapShotShisetsu().snapshot();

		}

		// 画面状態制御
		changeShisetsuState();

	}

	/**
	 * 施設履歴 - 追加ボタンイベント
	 * 
	 */
	protected void shisetsuInfoButtonInsertActionPerformed(ActionEvent e)
			throws Exception {

		// データ抽出
		VRMap map = new VRHashMap();

		// データの整合性確認
		// 入力チェックを行う。
		if (!isValidInputShisetsu(CHECK_MODE_INSERT)) {
			// 入力エラーがあった場合
			// 処理を中断する。
			return;
		}
		
		// データ取得
		getShisetsuInputPanel().setSource(map);
		getShisetsuInputPanel().applySource();
		

		// 最大値+1の値を取得する。
		int maxId = 0;

		// 最大値の取得
		if (!(getShisetsuHistoryList() == null || getShisetsuHistoryList()
				.size() == 0)) {

			// 画面テーブルに既にデータが存在している場合
			for (int i = 0; i < getShisetsuHistoryList().size(); i++) {

				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"SHISETSU_HISTORY_ID", (VRMap) getShisetsuHistoryList()
								.get(i)));

				// 比較対象が比較元より大きい値の場合
				if (maxId < target) {
					// 比較対象を比較元とする。
					maxId = target;
				}

			}
		}

		// 取得した値を、取得した認定情報にKEY：NINTEI_HISTORY_IDで設定する。
		VRBindPathParser
				.set("SHISETSU_HISTORY_ID", map, new Integer(maxId + 1));

		// 利用者IDの設定
		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// 更新モードの場合
			// 取得したデータにKEY：PATIENT_ID　VALUE：patientidを設定する。
			VRBindPathParser
					.set("PATIENT_ID", map, new Integer(getPatientId()));
		}

		
		// StringからIntegerに型変換　※ソート時対策
		final String[] keys = new String[] { "SHISETSU_HISTORY_ID" };
		QkanCommon.convertValueFromStringToInteger(map, keys);

		// [CCCX:2930][Shinobu Hitaka] 2015/10/15 add - begin 
        // 有効期間の付加処理
        setMaxAndMinDateShisetsu(map);
		// [CCCX:2930][Shinobu Hitaka] 2015/10/15 add - end 
        
        // データの追加
		getShisetsuHistoryList().add(map);

		// 追加行のインデックスを退避(最終行のインデックス)
		int selectedRow = getShisetsuHistoryList().size() - 1;

		// 以下の条件で介護情報テーブルのソートを行う。
		// INSURE_VALID_START（有効期間開始）　DESC
		getShisetsuInfoTable().sort("SHISETSU_VALID_START DESC");

		// 追加行を選択
		getShisetsuInfoTable().setSelectedModelRow(selectedRow);

		// 1（変更あり）を代入する。
		setShisetsuTableChangeFlg(1);


	}

	/**
	 * 施設履歴 - 編集ボタンイベント
	 * 
	 */
	protected void shisetsuInfoButtonEditActionPerformed(ActionEvent e)
			throws Exception {
		// 入力チェックを行う。
		if (!isValidInputShisetsu(CHECK_MODE_UPDATE)) {
			// 入力エラーがあった場合
			// 処理を中断する。
			return;
		}


		// 選択行のインデックスを退避
		int selectedRow = getShisetsuInfoTable().getSelectedModelRow();

		// 入力されたデータを取得する。
		VRMap map = new VRHashMap();
		getShisetsuInputPanel().setSource(map);
		getShisetsuInputPanel().applySource();

		// 選択行のデータを取得する。
		VRMap temp = (VRMap) getShisetsuHistoryList().get(selectedRow);

		// 選択行のデータより、画面上にないデータを画面上データに移す。
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));
		VRBindPathParser.set("SHISETSU_HISTORY_ID", map,
				VRBindPathParser.get("SHISETSU_HISTORY_ID", temp));

		// [CCCX:2930][Shinobu Hitaka] 2015/10/15 add - begin 
        // 有効期間の付加処理
        setMaxAndMinDateShisetsu(map);
        // [CCCX:2930][Shinobu Hitaka] 2015/10/15 add - end 

        
		// 選択行に画面上のデータを設定する。
		getShisetsuHistoryList().setData(selectedRow, map);

		// 以下の条件で異動情報テーブルのソートを行う。
		getShisetsuInfoTable().sort("SHISETSU_VALID_START DESC");

		// 選択されていた行を選択
		getShisetsuInfoTable().setSelectedModelRow(selectedRow);

		// 1（変更あり）を代入する。
		setShisetsuTableChangeFlg(1);

	}

	/**
	 * 施設履歴 - 削除ボタン
	 * 
	 */
	protected void shisetsuInfoButtonDeleteActionPerformed(ActionEvent e)
			throws Exception {

		if (!(getShisetsuHistoryList() == null || getShisetsuHistoryList()
				.size() == 0)) {
			// 確認メッセージを表示する。
			// 　・メッセージID：WARNING_OF_DELETE_SELECTION
			switch (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION()) {

			case ACMessageBox.RESULT_OK:
				// 「はい」を選択した場合
				// 選択されているレコードの画面上のインデックス
				int sortedRow = getShisetsuInfoTable().getSelectedSortedRow();

				// 選択されているレコードをidouHistoryListから削除する。
				getShisetsuHistoryList().remove(
						getShisetsuInfoTable().getSelectedModelRow());

				// 削除された行の1行上の行を選択する。
				getShisetsuInfoTable().setSelectedSortedRowOnAfterDelete(
						sortedRow);

				// shisetsuDataFlgに1（変更あり）を代入する。
				setShisetsuDataFlg(1);

				break;

			case ACMessageBox.RESULT_CANCEL:
				// 「キャンセル」を選択した場合
				// 処理を抜ける。（何もしない）
				break;
			}
		}

	}

	/**
	 * 施設履歴テーブル選択イベントです。
	 * 
	 */
	protected void shisetsuInfoTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		VRMap map = new VRHashMap();

		if (!getShisetsuInfoTable().isSelected()) {
			// 画面テーブルの行を選択していない場合
			// 画面のソースを生成する。
			map = (VRMap) getShisetsuInputPanel().createSource();

		} else {
			// 選択されているレコードを取得する。
			map = (VRMap) getShisetsuInfoTable().getSelectedModelRowValue();

		}

		// 「異動情報領域（idouInfo）」のソースとして設定する。
		getShisetsuInputPanel().setSource(map);

		// 画面に展開する。
		getShisetsuInputPanel().bindSource();

		// 画面状態制御
		changeShisetsuState();

		// スナップショット
		getSnapShotShisetsu().snapshot();

	}

	/**
	 * 施設情報タブの画面制御
	 * 
	 */
	public void changeShisetsuState() throws Exception {
		if (getShisetsuInfoTokuteiCheck().isSelected()) {
			// 選択されている場合
			setState_ENABLE_TOKUTEI_NYUSHO_TRUE();
		} else {
			// 選択されていない場合
			setState_ENABLE_TOKUTEI_NYUSHO_FALSE();
		}
		// ボタンの状態制御
		if (!getShisetsuInfoTable().isSelected()) {
			setState_ENABLE_SHISETSU_BUTTON_FALSE();
		} else {
			setState_ENABLE_SHISETSU_BUTTON_TRUE();
		}
	}

	/**
	 * 施設情報入力チェック
	 * 
	 */
	public boolean isValidInputShisetsu(int checkMode) throws Exception {

		// フラグ
		int doUpdateFlg = 0;

		// メッセージ表示用引数
		String msgParam1 = null;
		String msgParam2 = null;
		String msgParam3 = null;

		// 登録されている履歴の有効期間
		Date reservedStart = null;
		Date reservedEnd = null;

		// 編集対象となる履歴のインデックス
		int targetIndex = -1;

		if (getNonCorrespondenceFlg() == 0) {
			// 有効期間開始日のチェック　※要介護度-非該当の場合は行わない。
			// 入力されているかどうか
			// ※エラーの場合、String：msgParam1を宣言し、"有効期間開始日"を代入する。
			if (ACTextUtilities.isNullText(getShisetsuInfoValidLimitDateStart()
					.getText())) {
				getShisetsuInfoValidLimitDateStart().requestFocus(); // フォーカス
				msgParam1 = "有効期間開始日";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
		}
		
		// [CCCX:2930][Shinobu Hitaka] 2015/10/15 edit - begin 
		// 施設情報領域
		// ※特定施設入所者チェックがONの場合のみチェックする。
		if (getShisetsuInfoTokuteiCheck().isSelected()) {
			// 未入力でないかチェックする。
			// ・institutionInfoDinnerBearLimitMoneyText
			// ※エラーの場合、String：msgParamを宣言し、"負担限度額"を代入する。
			if (ACTextUtilities
					.isNullText(getShisetsuInfoDinnerBearLimitMoneyText()
							.getText())) {
				getShisetsuInfoDinnerBearLimitMoneyText().requestFocus();
				msgParam1 = "負担限度額";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// ・institutionInfoUnitRoomLimitMoneyText
			// ※エラーの場合、String：msgParamを宣言し、"負担限度額"を代入する。
			if (ACTextUtilities
					.isNullText(getShisetsuInfoUnitRoomLimitMoneyText()
							.getText())) {
				getShisetsuInfoUnitRoomLimitMoneyText().requestFocus();
				msgParam1 = "負担限度額";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// ・institutionInfoUnitSemiRoomLimitMoneyText
			// ※エラーの場合、String：msgParamを宣言し、"負担限度額"を代入する。
			if (ACTextUtilities
					.isNullText(getShisetsuInfoUnitSemiRoomLimitMoneyText()
							.getText())) {
				getShisetsuInfoUnitSemiRoomLimitMoneyText().requestFocus();
				msgParam1 = "負担限度額";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// ・institutionInfoNormalRoomLimitMoneyText
			// ※エラーの場合、String：msgParamを宣言し、"負担限度額"を代入する。
			if (ACTextUtilities
					.isNullText(getShisetsuInfoNormalRoomLimitMoneyText()
							.getText())) {
				getShisetsuInfoNormalRoomLimitMoneyText().requestFocus();
				msgParam1 = "負担限度額";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// ・institutionInfoNormalRoomLimitMoneyText2
			// ※エラーの場合、String：msgParamを宣言し、"負担限度額"を代入する。
			if (ACTextUtilities
					.isNullText(getShisetsuInfoNormalRoomLimitMoneyText2()
							.getText())) {
				getShisetsuInfoNormalRoomLimitMoneyText2().requestFocus();
				msgParam1 = "負担限度額";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// ・institutionInfoTasyoRoomLimitMoneyText
			// ※エラーの場合、String：msgParamを宣言し、"負担限度額"を代入する。
			if (ACTextUtilities
					.isNullText(getShisetsuInfoTasyoRoomLimitMoneyText()
							.getText())) {
				getShisetsuInfoTasyoRoomLimitMoneyText().requestFocus();
				msgParam1 = "負担限度額";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// ・institutionInfoTasyoRoomLimitMoneyText2
			// ※エラーの場合、String：msgParamを宣言し、"負担限度額"を代入する。
			if (ACTextUtilities
					.isNullText(getShisetsuInfoTasyoRoomLimitMoneyText2()
							.getText())) {
				getShisetsuInfoTasyoRoomLimitMoneyText2().requestFocus();
				msgParam1 = "負担限度額";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
		}
		// [CCCX:2930][Shinobu Hitaka] 2015/10/15 edit - end 

		// 存在する日付が入力されているかどうか
		// ※エラーの場合、String：msgParamを宣言し、"有効期間開始日の"を代入する。
		if (!ACTextUtilities.isNullText(getShisetsuInfoValidLimitDateStart()
				.getText())) {
			if (!getShisetsuInfoValidLimitDateStart().isValidDate()) {
				getShisetsuInfoValidLimitDateStart().requestFocus(); // フォーカス
				msgParam1 = "有効期間開始日の";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}
		
		// [CCCX:2930][Shinobu Hitaka] 2015/10/15 edit - begin 特定入所者の場合のみ終了日必須
//		if (getNonCorrespondenceFlg() == 0) {
//			// 有効期間終了日のチェック　※要介護度-非該当の場合は行わない。
//			// 入力されているかどうか
//			// ※エラーの場合、String：msgParam1を宣言し、"有効期間終了日"を代入する。
//			if (ACTextUtilities.isNullText(getShisetsuInfoValidLimitDateEnd()
//					.getText())) {
//				getShisetsuInfoValidLimitDateEnd().requestFocus(); // フォーカス
//				msgParam1 = "有効期間終了日";
//				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
//						msgParam1);
//				return false;
//			}
//		}
		if (getNonCorrespondenceFlg() == 0 && getShisetsuInfoTokuteiCheck().isSelected()) {
			// 有効期間終了日のチェック　※要介護度-非該当の場合は行わない。
			// 入力されているかどうか
			// ※エラーの場合、String：msgParam1を宣言し、"有効期間終了日"を代入する。
			if (ACTextUtilities.isNullText(getShisetsuInfoValidLimitDateEnd()
					.getText())) {
				getShisetsuInfoValidLimitDateEnd().requestFocus(); // フォーカス
				msgParam1 = "有効期間終了日";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
		}
		// [CCCX:2930][Shinobu Hitaka] 2015/10/15 edit - end
		
		// 存在する日付が入力されているかどうか　※要介護度-非該当の場合は行わない。
		// ※エラーの場合、String：msgParamを宣言し、"有効期間終了日の"を代入する。
		if (!ACTextUtilities.isNullText(getShisetsuInfoValidLimitDateEnd()
				.getText())) {
			if (!getShisetsuInfoValidLimitDateEnd().isValidDate()) {
				getShisetsuInfoValidLimitDateEnd().requestFocus(); // フォーカス
				msgParam1 = "有効期間終了日の";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		Date start = getShisetsuInfoValidLimitDateStart().getDate();
		// [CCCX:2930][Shinobu Hitaka] 2015/10/15 edit - begin 
		//Date end = getShisetsuInfoValidLimitDateEnd().getDate();
		Date end;
		if (ACTextUtilities.isNullText(getShisetsuInfoValidLimitDateEnd()
				.getText())) {
			end = MAX_DATE;
		} else {
			end = getShisetsuInfoValidLimitDateEnd().getDate();
		}
		// [CCCX:2930][Shinobu Hitaka] 2015/10/15 edit - end 

		if (ACDateUtilities.getDifferenceOnDay(start, end) > 0) {
			getShisetsuInfoTokuteiCheck().requestFocus();
			msgParam1 = "有効期間は";
			msgParam2 = "開始日";
			msgParam3 = "終了日";
			QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION(
					msgParam1, msgParam2, msgParam3);
			return false;
		}

		// 既に登録されている要介護認定の有効期間と重なっていないかどうか

		if (!(getShisetsuHistoryList() == null || getShisetsuHistoryList()
				.size() == 0)) {

			Date latestStart = null;

			// 最後の履歴のインデックスを取得する。
			for (int i = 0; i < getShisetsuHistoryList().size(); i++) { // 認定履歴件数分ループ

				// 編集モードの場合
				// 自身の履歴は無視する。
				if (checkMode == CHECK_MODE_UPDATE) {
					if (i == getShisetsuInfoTable().getSelectedModelRow()) {
						continue;
					}
				}

				// 履歴抽出
				VRMap map = (VRMap) getShisetsuHistoryList().get(i);

				reservedStart = (Date) VRBindPathParser.get(
						"SHISETSU_VALID_START", map); // 履歴の有効期間開始日
				if (latestStart == null) {
					latestStart = reservedStart;
					targetIndex = i;
				} else if (ACDateUtilities.getDifferenceOnDay(latestStart,
						reservedStart) < 0) {
					latestStart = reservedStart;
					targetIndex = i;
				}
			}

			// 最後の履歴以外の履歴と重複していないかチェックする。
			for (int i = 0; i < getShisetsuHistoryList().size(); i++) { // 認定履歴件数分ループ

				// 最後の履歴は後で比較する
				if (i == targetIndex) {
					continue;
				}

				// 編集モードの場合
				// 自身の履歴は無視する。
				if (checkMode == CHECK_MODE_UPDATE) {
					if (i == getShisetsuInfoTable().getSelectedModelRow()) {
						continue;
					}
				}

				VRMap map = (VRMap) getShisetsuHistoryList().get(i); // 履歴抽出

				reservedStart = (Date) VRBindPathParser.get(
						"SHISETSU_VALID_START", map);
				reservedEnd = (Date) VRBindPathParser.get("SHISETSU_VALID_END",
						map);

				// 期間重複チェック
				// チェックの結果を取得
				int result = ACDateUtilities.getDuplicateTermCheck(
						reservedStart, reservedEnd, start, end);

				if (result != ACDateUtilities.DUPLICATE_NONE) {
					// 重複していた場合

					getShisetsuInfoTokuteiCheck().requestFocus();
					// TODO
					QkanMessageList.getInstance()
							.QU002_ERROR_OF_DUPLICATE_KAIGO();
					return false;

				}
			}

			// 最後の履歴と重複していないかチェックする。
			if (targetIndex != -1) {
				VRMap latestMap = (VRMap) getShisetsuHistoryList().get(
						targetIndex); // 最後の履歴抽出
				reservedStart = (Date) VRBindPathParser.get(
						"SHISETSU_VALID_START", latestMap); // 最後の履歴の有効期間開始日
				reservedEnd = (Date) VRBindPathParser.get("SHISETSU_VALID_END",
						latestMap); // 最後の履歴の有効期間終了日

				// チェックの結果を取得
				int result = ACDateUtilities.getDuplicateTermCheck(
						reservedStart, reservedEnd, start, end);

				if (result != ACDateUtilities.DUPLICATE_NONE) {
					// 重複していた場合

					if (result == ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND
							|| result == ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND_EQUALS_BOTH_END
							|| result == ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN
							|| result == ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN_ON_ONE_DAY) {
						// 有効期間を自動で調整できる場合
						// 確認メッセージを表示する。
						// ・メッセージID：WARNING_OF_DUPLICATE_TERM
						msgParam1 = "施設情報";
						switch (QkanMessageList.getInstance()
								.WARNING_OF_DUPLICATE_TERM(msgParam1)) {
						case ACMessageBox.RESULT_OK:
							// 「OK」が選択された場合
							// 入力チェックを完全にパスした後処理を行う。
							doUpdateFlg = 1;
							break;
						case ACMessageBox.RESULT_CANCEL:
							// 「キャンセル」が選択された場合
							// エラーが発生したインスタンスにフォーカスを当てる。
							getShisetsuInfoTokuteiCheck().requestFocus();
							// 戻り値としてfalseを返す。
							return false;
						}

					} else {
						// 有効期間を自動で調整できない場合
						getShisetsuInfoTokuteiCheck().requestFocus();
						// TODO
						QkanMessageList.getInstance()
								.QU002_ERROR_OF_DUPLICATE_KAIGO();
						return false;
					}

				}
			}
			
			// 有効期間自動調整
			if (doUpdateFlg == 1) {

				// 入力された有効期間開始日
				Date startLimit = getShisetsuInfoValidLimitDateStart().getDate();

				// 自動調整確認メッセージで「OK」を選択した場合
				// 有効期間開始日の値を取得し、前日の値に変換する。
				Date changedDate = ACDateUtilities.addDay(startLimit, -1);
				// 変換した値を、既にテーブルに登録されている要介護認定履歴のうち、
				// 重なっている認定の有効期間終了日に設定する。
				VRBindPathParser.set("SHISETSU_VALID_END",
						(VRMap) getShisetsuHistoryList().get(targetIndex),
						changedDate);
			}
			
		}

		return true;
	}

// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
	/**
	 * 住所地特例情報 - クリアボタンイベント
	 * 
	 */
	protected void jushotiTokureiInfoButtonClearActionPerformed(ActionEvent e)
			throws Exception {

		String insurerId = "";
		VRMap src = null;
		VRMap tempSrc = null;
		Date historyDate = null;
		
		// 住所地特例情報の先頭を取得する
		if(getJushotiTokureiList().size() > 0) {
			for(int i=0; i < getJushotiTokureiList().size();i++) {
				// 採用するレコードを判定する
				tempSrc = (VRMap)getJushotiTokureiList().getData(i);
				if(historyDate == null) {
					historyDate = ACCastUtilities.toDate(tempSrc.getData("JUSHOTI_VALID_START"));
					src = (VRMap)getJushotiTokureiList().getData(i);
					continue;
				}
				if(ACDateUtilities.compareOnDay(historyDate, ACCastUtilities.toDate(tempSrc.getData("JUSHOTI_VALID_START"))) < 0) {
					// 有効期間開始が現在のレコードより後ろのものを採用する
					src = (VRMap)getJushotiTokureiList().getData(i);
				}
			}
			
			insurerId = ACCastUtilities.toString(src.getData("JUSHOTI_INSURER_ID"),"");
		}
		
		if (getJushotiTokureiInfoTable().isSelected()) {
			// 画面テーブルが選択されている場合
			// 画面テーブルの行を未選択の状態に設定する。
			getJushotiTokureiInfoTable().clearSelection();

		}
		
		VRMap map = new VRHashMap();
		// 画面のソースを生成する。
		map = (VRMap) getJushotiTokureiInputPanel().createSource();
		map.setData("JUSHOTI_INSURER_ID", insurerId);
		

		// 「施設情報領域」のソースとして設定する。
		getJushotiTokureiInputPanel().setSource(map);

		// 画面に展開する。
		getJushotiTokureiInputPanel().bindSource();
		
		// 非選択状態ならスナップショットを取る
		if(!getJushotiTokureiInfoTable().isSelected()) {
			// スナップショット
			getSnapShotJushotiTokurei().snapshot();

		}

		// 画面状態制御
//		changeShisetsuState();

	}

	/**
	 * 住所地特例情報 - 追加ボタンイベント
	 * 
	 */
	protected void jushotiTokureiInfoButtonInsertActionPerformed(ActionEvent e)
			throws Exception {

		// データ抽出
		VRMap map = new VRHashMap();

		// データの整合性確認
		// 入力チェックを行う。
		if (!isValidInputJushotiTokurei(CHECK_MODE_INSERT)) {
			// 入力エラーがあった場合
			// 処理を中断する。
			return;
		}
		
		// データ取得
		getJushotiTokureiInputPanel().setSource(map);
		getJushotiTokureiInputPanel().applySource();
		

		// 最大値+1の値を取得する。
		int maxId = 0;

		// 最大値の取得
		if (!(getJushotiTokureiList() == null || getJushotiTokureiList()
				.size() == 0)) {

			// 画面テーブルに既にデータが存在している場合
			for (int i = 0; i < getJushotiTokureiList().size(); i++) {

				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"JUSHOTI_HISTORY_ID", (VRMap) getJushotiTokureiList()
								.get(i)));

				// 比較対象が比較元より大きい値の場合
				if (maxId < target) {
					// 比較対象を比較元とする。
					maxId = target;
				}

			}
		}

		// 取得した値を、取得した認定情報にKEY：JUSHOTI_HISTORY_IDで設定する。
		VRBindPathParser
				.set("JUSHOTI_HISTORY_ID", map, new Integer(maxId + 1));

		// 利用者IDの設定
		if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// 更新モードの場合
			// 取得したデータにKEY：PATIENT_ID　VALUE：patientidを設定する。
			VRBindPathParser
					.set("PATIENT_ID", map, new Integer(getPatientId()));
		}

		
		// StringからIntegerに型変換　※ソート時対策
		final String[] keys = new String[] { "JUSHOTI_HISTORY_ID" };
		QkanCommon.convertValueFromStringToInteger(map, keys);

        // 有効期間の付加処理
        setMaxAndMinDateJushotiTokurei(map);
        
		// データの追加
		getJushotiTokureiList().add(map);

		// 追加行のインデックスを退避(最終行のインデックス)
		int selectedRow = getJushotiTokureiList().size() - 1;

		// 以下の条件で介護情報テーブルのソートを行う。
		// INSURE_VALID_START（有効期間開始）　DESC
		getJushotiTokureiInfoTable().sort("JUSHOTI_VALID_START DESC");

		// 追加行を選択
		getJushotiTokureiInfoTable().setSelectedModelRow(selectedRow);

		// 1（変更あり）を代入する。
		setJushotiTokureiTableChangeFlg(1);

	}

	/**
	 * 住所地特例情報 - 編集ボタンイベント
	 * 
	 */
	protected void jushotiTokureiInfoButtonEditActionPerformed(ActionEvent e)
			throws Exception {
		// 入力チェックを行う。
		if (!isValidInputJushotiTokurei(CHECK_MODE_UPDATE)) {
			// 入力エラーがあった場合
			// 処理を中断する。
			return;
		}


		// 選択行のインデックスを退避
		int selectedRow = getJushotiTokureiInfoTable().getSelectedModelRow();

		// 入力されたデータを取得する。
		VRMap map = new VRHashMap();
		getJushotiTokureiInputPanel().setSource(map);
		getJushotiTokureiInputPanel().applySource();

		// 選択行のデータを取得する。
		VRMap temp = (VRMap) getJushotiTokureiList().get(selectedRow);

		// 選択行のデータより、画面上にないデータを画面上データに移す。
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));
		VRBindPathParser.set("JUSHOTI_HISTORY_ID", map,
				VRBindPathParser.get("JUSHOTI_HISTORY_ID", temp));

        // 有効期間の付加処理
        setMaxAndMinDateJushotiTokurei(map);
        
		// 選択行に画面上のデータを設定する。
		getJushotiTokureiList().setData(selectedRow, map);

		// 以下の条件で異動情報テーブルのソートを行う。
		getJushotiTokureiInfoTable().sort("JUSHOTI_VALID_START DESC");

		// 選択されていた行を選択
		getJushotiTokureiInfoTable().setSelectedModelRow(selectedRow);

		// 1（変更あり）を代入する。
		setJushotiTokureiTableChangeFlg(1);

	}

	/**
	 * 住所地特例情報 - 削除ボタン
	 * 
	 */
	protected void jushotiTokureiInfoButtonDeleteActionPerformed(ActionEvent e)
			throws Exception {

		if (!(getJushotiTokureiList() == null || getJushotiTokureiList()
				.size() == 0)) {
			// 確認メッセージを表示する。
			// 　・メッセージID：WARNING_OF_DELETE_SELECTION
			switch (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION()) {

			case ACMessageBox.RESULT_OK:
				// 「はい」を選択した場合
				// 選択されているレコードの画面上のインデックス
				int sortedRow = getJushotiTokureiInfoTable().getSelectedSortedRow();

				// 選択されているレコードをidouHistoryListから削除する。
				getJushotiTokureiList().remove(
						getJushotiTokureiInfoTable().getSelectedModelRow());

				// 削除された行の1行上の行を選択する。
				getJushotiTokureiInfoTable().setSelectedSortedRowOnAfterDelete(
						sortedRow);

				// shisetsuDataFlgに1（変更あり）を代入する。
				//setShisetsuDataFlg(1);
				setJushotiTokureiDataFlg(1);

				break;

			case ACMessageBox.RESULT_CANCEL:
				// 「キャンセル」を選択した場合
				// 処理を抜ける。（何もしない）
				break;
			}
		}

	}

	/**
	 * 住所地特例情報テーブル選択イベントです。
	 * 
	 */
	protected void jushotiTokureiInfoTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		
		VRMap map = new VRHashMap();

		if (!getJushotiTokureiInfoTable().isSelected()) {
			// 画面テーブルの行を選択していない場合
			// Enable制御を行う。
			// ・状態ID：ENABLE_JUSHOTI_TOKUREI_BUTTON_FALSE
			setState_ENABLE_JUSHOTI_TOKUREI_BUTTON_FALSE();

			// 画面のソースを生成する。
			map = (VRMap) getJushotiTokureiInputPanel().createSource();

		} else {
			// 画面テーブルの行を選択している場合
			// ・状態ID：ENABLE_JUSHOTI_TOKUREI_BUTTON_TRUE
			// Enable制御を行う。
			setState_ENABLE_JUSHOTI_TOKUREI_BUTTON_TRUE();

			// 選択されているレコードを取得する。
			map = (VRMap) getJushotiTokureiInfoTable().getSelectedModelRowValue();

		}

		// 住所地特例情報領域」のソースとして設定する。。
		getJushotiTokureiInputPanel().setSource(map);

		// 画面に展開する。
		getJushotiTokureiInputPanel().bindSource();

		// スナップショット
		getSnapShotJushotiTokurei().snapshot();
	}
	
	/**
	 * 住所地特例情報入力チェック
	 * 
	 */
	public boolean isValidInputJushotiTokurei(int checkMode) throws Exception {
		
		// フラグ
		int doUpdateFlg = 0;

		// メッセージ表示用引数
		String msgParam1 = null;
		String msgParam2 = null;
		String msgParam3 = null;

		// 登録されている履歴の有効期間
		Date reservedStart = null;
		Date reservedEnd = null;

		// 編集対象となる履歴のインデックス
		int targetIndex = -1;


        
        // ・施設所在保険者番号（jushotiTokureiInfoInsurerId）
        // 入力されているかどうか。
        // ※エラーの場合、String：msgParamを宣言し、"減額割合"を代入する。
		if (!getJushotiTokureiInfoInsurerName().isSelected()) {
			getJushotiTokureiInfoInsurerName().requestFocus(); // フォーカス
			msgParam1 = "施設所在保険者名";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					msgParam1);
			return false;
		}
        if (ACTextUtilities.isNullText(getJushotiTokureiInfoInsurerId()
                .getText())) {
        	getJushotiTokureiInfoInsurerId().requestFocus();
            msgParam1 = "施設所在保険者番号";
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
                    msgParam1);
            return false;
        }

        // ・有効期間開始（jushotiTokureiInfoValidLimitDateStart）
        // 入力されている日付が存在するか。
        // ※エラーの場合、String：msgParamを宣言し、"有効期間開始日の"を代入する。
        if (!ACTextUtilities.isNullText(getJushotiTokureiInfoValidLimitDateStart()
                .getText())) {
            if (!getJushotiTokureiInfoValidLimitDateStart().isValidDate()) {
            	getJushotiTokureiInfoValidLimitDateStart().requestFocus();
                msgParam1 = "有効期間開始日の";
                QkanMessageList.getInstance()
                        .ERROR_OF_WRONG_DATE(msgParam1);
                return false;
            }
        }

        // ・有効期間終了（jushotiTokureiInfoValidLimitDateEnd）
        // 入力されている日付が存在するか。
        // ※エラーの場合、String：msgParamを宣言し、"有効期間終了日の"を代入する。
        if (!ACTextUtilities.isNullText(getJushotiTokureiInfoValidLimitDateEnd()
                .getText())) {
            if (!getJushotiTokureiInfoValidLimitDateEnd().isValidDate()) {
            	getJushotiTokureiInfoValidLimitDateEnd().requestFocus();
                msgParam1 = "有効期間終了日の";
                QkanMessageList.getInstance()
                        .ERROR_OF_WRONG_DATE(msgParam1);
                return false;
            }
        }

        // 有効期間開始
        Date start;
        // 有効期間終了
        Date end;
        
        if (ACTextUtilities.isNullText(getJushotiTokureiInfoValidLimitDateStart()
                .getText())) {
        	start = MIN_DATE;
        } else {
        	start = getJushotiTokureiInfoValidLimitDateStart().getDate();
        }
        if (ACTextUtilities.isNullText(getJushotiTokureiInfoValidLimitDateEnd()
                .getText())) {
        	end = MAX_DATE;
        } else {
        	end = getJushotiTokureiInfoValidLimitDateEnd().getDate();
        }
        
        // ・有効期間開始（jushotiTokureiInfoValidLimitDateStart）
        // ・有効期間終了（jushotiTokureiInfoValidLimitDateEnd）
        // 前後関係が矛盾していないか。
        // ※エラーの場合、String：msgParam1を宣言し、"有効期間は"を代入する。
        // ※エラーの場合、String：msgParam2を宣言し、"開始日"を代入する。
        // ※エラーの場合、String：msgParam3を宣言し、"終了日"を代入する。
        if (!(ACTextUtilities.isNullText(getJushotiTokureiInfoValidLimitDateStart()
                .getText()))
                && !(ACTextUtilities.isNullText(getJushotiTokureiInfoValidLimitDateEnd()
                        .getText()))) {

            if (ACDateUtilities.compareOnDay(start, end) > 0) {
            	getJushotiTokureiInfoValidLimitDateStart().requestFocus();
                msgParam1 = "有効期間は";
                msgParam2 = "開始日";
                msgParam3 = "終了日";
                QkanMessageList.getInstance()
                        .ERROR_OF_GREATER_DATE_RELATION(msgParam1,
                                msgParam2, msgParam3);
                return false;
            }
        }
        
        

		// 既に登録されているデータの有効期間と重なっていないかどうか

		if (!(getJushotiTokureiList() == null || getJushotiTokureiList()
				.size() == 0)) {

			Date latestStart = null;

			// 最後の履歴のインデックスを取得する。
			for (int i = 0; i < getJushotiTokureiList().size(); i++) { // 件数分ループ

				// 編集モードの場合
				// 自身の履歴は無視する。
				if (checkMode == CHECK_MODE_UPDATE) {
					if (i == getJushotiTokureiInfoTable().getSelectedModelRow()) {
						continue;
					}
				}

				// 履歴抽出
				VRMap map = (VRMap) getJushotiTokureiList().get(i);

				reservedStart = (Date) VRBindPathParser.get(
						"JUSHOTI_VALID_START", map); // 履歴の有効期間開始日
				if (latestStart == null) {
					latestStart = reservedStart;
					targetIndex = i;
				} else if (ACDateUtilities.getDifferenceOnDay(latestStart,
						reservedStart) < 0) {
					latestStart = reservedStart;
					targetIndex = i;
				}
			}

			// 最後の履歴以外の履歴と重複していないかチェックする。
			for (int i = 0; i < getJushotiTokureiList().size(); i++) { // 履歴件数分ループ

				// 最後の履歴は後で比較する
				if (i == targetIndex) {
					continue;
				}

				// 編集モードの場合
				// 自身の履歴は無視する。
				if (checkMode == CHECK_MODE_UPDATE) {
					if (i == getJushotiTokureiInfoTable().getSelectedModelRow()) {
						continue;
					}
				}

				VRMap map = (VRMap) getJushotiTokureiList().get(i); // 履歴抽出

				reservedStart = (Date) VRBindPathParser.get(
						"JUSHOTI_VALID_START", map);
				reservedEnd = (Date) VRBindPathParser.get("JUSHOTI_VALID_END",
						map);

				// 期間重複チェック
				// チェックの結果を取得
				int result = ACDateUtilities.getDuplicateTermCheck(
						reservedStart, reservedEnd, start, end);

				if (result != ACDateUtilities.DUPLICATE_NONE) {
					// 重複していた場合

					getJushotiTokureiInfoValidLimitDateStart().requestFocus();
					
					QkanMessageList.getInstance()
							.QU002_ERROR_OF_DUPLICATE_JUSHOTI_TOKUREI_VALID();
					return false;

				}
			}

			// 最後の履歴と重複していないかチェックする。
			if (targetIndex != -1) {
				VRMap latestMap = (VRMap) getJushotiTokureiList().get(
						targetIndex); // 最後の履歴抽出
				reservedStart = (Date) VRBindPathParser.get(
						"JUSHOTI_VALID_START", latestMap); // 最後の履歴の有効期間開始日
				reservedEnd = (Date) VRBindPathParser.get("JUSHOTI_VALID_END",
						latestMap); // 最後の履歴の有効期間終了日

				// チェックの結果を取得
				int result = ACDateUtilities.getDuplicateTermCheck(
						reservedStart, reservedEnd, start, end);

				if (result != ACDateUtilities.DUPLICATE_NONE) {
					// 重複していた場合

					if (result == ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND
							|| result == ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND_EQUALS_BOTH_END
							|| result == ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN
							|| result == ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN_ON_ONE_DAY) {
						// 有効期間を自動で調整できる場合
						// 確認メッセージを表示する。
						// ・メッセージID：WARNING_OF_DUPLICATE_TERM
						msgParam1 = "住所地特例情報";
						switch (QkanMessageList.getInstance()
								.WARNING_OF_DUPLICATE_TERM(msgParam1)) {
						case ACMessageBox.RESULT_OK:
							// 「OK」が選択された場合
							// 入力チェックを完全にパスした後処理を行う。
							doUpdateFlg = 1;
							break;
						case ACMessageBox.RESULT_CANCEL:
							// 「キャンセル」が選択された場合
							// エラーが発生したインスタンスにフォーカスを当てる。
							getJushotiTokureiInfoValidLimitDateStart().requestFocus();
							// 戻り値としてfalseを返す。
							return false;
						}

					} else {
						// 有効期間を自動で調整できない場合
						getJushotiTokureiInfoValidLimitDateStart().requestFocus();
						
						QkanMessageList.getInstance()
								.QU002_ERROR_OF_DUPLICATE_JUSHOTI_TOKUREI_VALID();
						return false;
					}

				}
			}
			
			// 有効期間自動調整
			if (doUpdateFlg == 1) {

				// 入力された有効期間開始日
				Date startLimit = getJushotiTokureiInfoValidLimitDateStart().getDate();

				// 自動調整確認メッセージで「OK」を選択した場合
				// 有効期間開始日の値を取得し、前日の値に変換する。
				Date changedDate = ACDateUtilities.addDay(startLimit, -1);
				// 変換した値を、既にテーブルに登録されている履歴のうち、
				// 重なっているデータの有効期間終了日に設定する。
				VRBindPathParser.set("JUSHOTI_VALID_END",
						(VRMap) getJushotiTokureiList().get(targetIndex),
						changedDate);
			}
			
		}
        
		// 入力エラーがなかった場合
		return true;
	}

  /**
   * 「保険者名表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
	protected void jushotiTokureiInfoInsurerIdFocusLost(FocusEvent e)
			throws Exception {
		String insurerId = getJushotiTokureiInfoInsurerId().getText();

		// 入力された保険者番号に該当する保険者が存在する場合
		VRMap map = (VRMap) getJushotiTokureiInfoInsurerName().getDataFromBindPath(
				insurerId);

		// 保険者名コンボ（jushotiTokureiInfoInsurerName）の該当保険者を選択状態にする。
		getJushotiTokureiInfoInsurerName().setSelectedItem(map);
	}

  /**
   * 「保険者番号表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
	protected void jushotiTokureiInfoInsurerNameActionPerformed(ActionEvent e)
			throws Exception {
		// 選択された保険者の保険者番号を保険者番号フィールド（jushotiTokureiInfoInsurerId）
		// に表示する。
		VRMap map = (VRMap) getJushotiTokureiInfoInsurerName().getSelectedModelItem();

		if (VRBindPathParser.get("JUSHOTI_INSURER_ID", map) == null) {
			getJushotiTokureiInfoInsurerId().setText("");
		} else {
			getJushotiTokureiInfoInsurerId().setText(
					ACCastUtilities.toString(VRBindPathParser.get("JUSHOTI_INSURER_ID",
							map)));
		}
	}
	
	/**
	 * 「上限、下限日付設定」処理です。
	 * 
	 * @param VRMap
	 *            値を詰め込みたいVRMap
	 * @throws Exception
	 *             処理例外
	 */
	private void setMaxAndMinDateJushotiTokurei(VRMap map) throws Exception {
		// 非該当の場合の処理

		// 有効期間開始日が入力されていない場合
		// 下限日付を自動設定
		if (ACTextUtilities.isNullText(getJushotiTokureiInfoValidLimitDateStart().getText())) {
			VRBindPathParser.set("JUSHOTI_VALID_START", map, MIN_DATE);
		}

		// 有効期間終了日が入力されていない場合
		// 上限日付を自動設定
		if (ACTextUtilities.isNullText(getJushotiTokureiInfoValidLimitDateEnd().getText())) {
			VRBindPathParser.set("JUSHOTI_VALID_END", map, MAX_DATE);
		}
	}
// 2015/1/14 [Yoichiro Kamei] add - end


// 2016/7/18 [Yoichiro Kamei] add - begin 総合事業対応 事業対象者の限度額変更フラグ
	/**
	 * 「要支援１の額を超えてサービスを利用」の設定チェックに関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doCheckLimitChange() throws Exception {

		// 要介護度が事業対象者でない場合、要支援１の額を超えてサービスを利用のフラグ設定を初期化する。
		// 要介護度をチェック
		if (getKaigoInfoYokaigoInfo().isSelected()) {
			VRMap temp = (VRMap) getKaigoInfoYokaigoInfo()
					.getSelectedModelItem();
			int jotaiCode = ACCastUtilities.toInt(VRBindPathParser.get(
					"JOTAI_CODE", temp));
			// 事業対象者が選択されていない場合
			if (jotaiCode != QkanConstants.YOUKAIGODO_JIGYOTAISHO) {
				getKaigoInfoLimitChange().setSelected(false);
				setState_VISIBLE_LIMIT_CHANGE_FALSE();
			} else {
				setState_VISIBLE_LIMIT_CHANGE_TRUE();
			}
		}

	}
	
	/* 
	 * 「要支援１の額を超えてサービスを利用」チェッククリック時のイベント処理
	 */
	@Override
	protected void kaigoInfoLimitChangeActionPerformed(ActionEvent e)
			throws Exception {
		// 支給限度額を支給限度額テキストフィールド（kaigoInfoProvideLimit）に表示する。
		doFindLimitRate();
	}
	
// 2016/7/18 [Yoichiro Kamei] add - end
		
// [CCCX:2930][Shinobu Hitaka] 2015/10/15 add - begin 施設情報有効期間の日付設定
	/**
	 * 「上限、下限日付設定」処理です。
	 * 
	 * @param VRMap
	 *            値を詰め込みたいVRMap
	 * @throws Exception
	 *             処理例外
	 */
	private void setMaxAndMinDateShisetsu(VRMap map) throws Exception {
		// 非該当の場合の処理

		// 有効期間開始日が入力されていない場合
		// 下限日付を自動設定
		if (ACTextUtilities.isNullText(getShisetsuInfoValidLimitDateStart().getText())) {
			VRBindPathParser.set("SHISETSU_VALID_START", map, MIN_DATE);
		}

		// 有効期間終了日が入力されていない場合
		// 上限日付を自動設定
		if (ACTextUtilities.isNullText(getShisetsuInfoValidLimitDateEnd().getText())) {
			VRBindPathParser.set("SHISETSU_VALID_END", map, MAX_DATE);
		}
	}
// [CCCX:2930][Shinobu Hitaka] 2015/10/15 add - end


	
}
