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
 * 作成日: 2006/01/25  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 利用者登録 (004)
 * プログラム 公費・軽減情報 (QU004)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qu.qu004;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACHashMapFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
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
import jp.or.med.orca.qkan.text.QkanClaimStyleFormat;

/**
 * 公費・軽減情報(QU004)
 */
public class QU004 extends QU004Event {

	public final static int RESULT_TRUE = 0;

	public final static int RESULT_FALSE = 1;

	public final static int RESULT_CHANGEABLE = 2;

	public final static int NOT_SHOW_KOHI= 0;
	public final static int SHOW_KOHI = 1;
	

	/**
	 * コンストラクタです。
	 */
	public QU004() {
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

		// 渡りパラメータを退避する。
		VRMap param = affair.getParameters();

		// ・patientId KEY：PATIENT_ID
		if (VRBindPathParser.has("PATIENT_ID", param)) {
			setPatientId(ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", param)));
		}

		// ・processStart KEY：PROCESS_START
		if (VRBindPathParser.has("PROCESS_START", param)) {
			setProcessStart(ACCastUtilities.toString(VRBindPathParser.get(
					"PROCESS_START", param)));
		}

		// 渡りパラメータの削除
		param.clear();

		// 画面の初期化を行う。
		initialize();

		// レコードを取得し、画面に設定する。
		doFind();

	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}

		boolean unsettledInfoExistFlg = false;

		// 強制戻りフラグが1の場合
		if (getCompulsoryBackFlg() == 1) {
			// 以下の値をパラメータに設定する。
			// KEY：COMPULSORY_BACK_FLG VALUE：compulsoryBackFlg
			VRBindPathParser.set("COMPULSORY_BACK_FLG", parameters,
					new Integer(getCompulsoryBackFlg()));
			// 前画面に遷移する。
			return true;
		}

		// 変更チェック(破棄される可能性のある情報)
		if (getSnapShotKaigo().isModified() || getSnapShotIryo().isModified()
				|| getSnapShotShahuku().isModified()) {
			unsettledInfoExistFlg = true;
		}

		// 変更チェック（画面テーブルのチェック）を行う。
		if (getKaigoTableChangeFlg() == 1 || getIryoTableChangeFlg() == 1
				|| getShahukuTableChangeFlg() == 1 || unsettledInfoExistFlg) {
			// 最後に保存されてから、画面テーブルが変更されている場合（下記のいずれかの場合）
			// ・kaigoTableChangeFlg = 1
			// ・iryoTableChangeFlg = 1
			// ・shahukuTableChangeFlg = 1
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
							String msgParam = "公費情報もしくは社会福祉軽減情報";
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

						// 保存処理を行う。
						if (!doSave()) {
							// パッシブエラーが発生した場合
							return false;
						}

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
				// ・メッセージID：WARNING_OF_UPDATE_ON_MODIFIED;

				switch (QkanMessageList.getInstance()
						.WARNING_OF_UPDATE_ON_MODIFIED()) {
				case ACMessageBox.RESULT_OK:
					// 「はい」を選択した場合

					try {
						// 破棄される情報があることを伝えるメッセージ
						if (unsettledInfoExistFlg) {
							// メッセージ表示
							String msgParam = "公費情報もしくは社会福祉軽減情報";
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

						// 保存処理を行う。
						if (!doSave()) {
							// パッシブエラーが発生した場合
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

		// 下記を渡りパラメータとして、「利用者登録（QU002）」画面に戻る。
		// ・KEY：PATIENT_ID VALUE：patientId（利用者ID）
		// ・KEY：PROCESS_MODE VALUE：（共通定数のPROCESS_MODE_UPDATE（プロセスモード「更新」））
		// ・KEY：PROCESS_START VALUE：processStart
		VRBindPathParser.set("PATIENT_ID", parameters, new Integer(
				getPatientId()));
		VRBindPathParser.set("PROCESS_MODE", parameters, new Integer(
				QkanConstants.PROCESS_MODE_UPDATE));
		VRBindPathParser.set("PROCESS_START", parameters, getProcessStart());

		// 前画面への遷移を許可するならばtrueを返す。
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// 変更チェック（画面テーブルのチェック）を行う。
		if (getKaigoTableChangeFlg() == 1 || getIryoTableChangeFlg() == 1
				|| getShahukuTableChangeFlg() == 1) {
			// 最後に保存されてから、画面テーブルが変更されている場合（下記のいずれかの場合）
			// ・kaigoTableChangeFlg = 1
			// ・iryoTableChangeFlg = 1
			// ・shahukuTableChangeFlg = 1

			// 終了確認メッセージを表示する。
			switch (QkanMessageList.getInstance()
					.WARNING_OF_CLOSE_ON_MODIFIED()) {
			// ・メッセージID：WARNING_OF_CLOSE_ON_MODIFIED

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

		// 登録処理

		try {

			// 変更チェック(破棄される可能性のある情報)
			if (getSnapShotKaigo().isModified()
					|| getSnapShotIryo().isModified()
					|| getSnapShotShahuku().isModified()) {

				// メッセージ表示
				String msgParam = "公費情報もしくは社会福祉軽減情報";
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

			// 保存処理を行う。
			if (!doSave()) {
				// パッシブエラーが発生した場合
				return;
			}

			// 保存処理が正常終了した場合
			// 処理モードを更新モードに変更する。
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

			// 画面の設定を行う。
			casualInitialize();

			// 最新のデータを取得する。
			doFind();

			// ･状態ID：UPDATE_MODE
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

		// 更新処理

		try {

			// 変更チェック(破棄される可能性のある情報)
			if (getSnapShotKaigo().isModified()
					|| getSnapShotIryo().isModified()
					|| getSnapShotShahuku().isModified()) {

				// メッセージ表示
				String msgParam = "公費情報もしくは社会福祉軽減情報";
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

			// 保存処理を行う。
			if (!doSave()) {
				// パッシブエラーが発生した場合
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
	 * 「介護公費情報クリア処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoButtonClearActionPerformed(ActionEvent e)
			throws Exception {

		// クリア処理

		if (getKaigoInfoTable().isSelected()) {
			// 画面テーブルの行が選択されている場合
			// テーブルの選択をクリアする。
			getKaigoInfoTable().clearSelection();
		} else {
			// 画面テーブルの行が選択されている場合
			VRMap map = new VRHashMap();
			// 新たなソースを生成する。
			map = (VRMap) getKaigoInfo().createSource();
			getKaigoInfo().setSource(map);
			getKaigoInfo().bindSource();

			// スナップショット
			getSnapShotKaigo().snapshot();
		}
	}

	/**
	 * 「介護公費情報追加処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoButtonInsertActionPerformed(ActionEvent e)
			throws Exception {

		// 入力チェックを行う。
		if (!isValidInput(INSURE_TYPE_KAIGO, CHECK_MODE_INSERT)) {
			// 入力エラーがあった場合
			return;
		}

		// 入力エラーがなかった場合
		// 空のHashMapを生成し、「介護公費領域・情報2（kaigoInfo）」のソースとして設定する。
		VRMap map = new VRHashMap();
		getKaigoInfo().setSource(map);

		// 入力されたデータをソースに流し込み、データを取得する。
		getKaigoInfo().applySource();

		// 取得した画面上のデータにPATIENT_IDを設定する。
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));

		// patientKohiListを件数分ループし、KOHI_IDの最大値+1の値を取得する。
		int maxId = 0;

		// 最大値の取得
		if (!(getPatientKohiList() == null || getPatientKohiList().size() == 0)) {

			// 画面テーブルに既にデータが存在している場合
			for (int i = 0; i < getPatientKohiList().size(); i++) {

				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"KOHI_ID", (VRMap) getPatientKohiList().get(i)));

				// 比較対象が比較元より大きい値の場合
				if (maxId < target) {
					// 比較対象を比較元とする。
					maxId = target;
				}

			}
		}

		// KOHI_IDを追加する。
		VRBindPathParser.set("KOHI_ID", map, new Integer(maxId + 1));

		// INSURE_TYPEを設定する。
		VRBindPathParser
				.set("INSURE_TYPE", map, new Integer(INSURE_TYPE_KAIGO));

		// 有効期間の付加処理
		setMaxAndMinDate(map);

		// テーブル表示用に編集する。
		map = toKohiTableList(map);

		// StringからIntegerに型変換 ※ソート時対策
		final String[] keys = new String[] { "BENEFIT_RATE", };
		QkanCommon.convertValueFromStringToInteger(map, keys);

		// 取得したデータをpatientKohiListの新しいレコードとして追加する。
		getPatientKohiList().add(map);

		// 画面の利用者公費サービス情報取得関数を呼び出し、戻り値をArrayList：Listに格納する。
		// ・第一引数：kohiId
		// ・第ニ引数：INSURE_TYPE_KAIGO
		VRList list = getPatientKohiService(maxId + 1, INSURE_TYPE_KAIGO);

		// ListをpatientKohiServiceListに追加する。
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				getPatientKohiServiceList().add(list.get(i));
			}
		}

		// patientKohiListより介護公費のデータを取得し、テーブルモデルに設定する。
		VRList kaigoKohiList = getListToSetTable(getPatientKohiList(),
				INSURE_TYPE_KAIGO);
		getKaigoTableModel().setAdaptee(kaigoKohiList);

		// 以下の条件で介護公費テーブルのソートを行う。
		// KOHI_VALID_START（公費有効期間開始） DESC
		getKaigoInfoTable().sort("KOHI_VALID_START DESC");

		// 追加行を選択
		int selectedRow = ACBindUtilities.getMatchIndexFromMap(kaigoKohiList,
				"KOHI_ID", map);
		getKaigoInfoTable().setSelectedModelRow(selectedRow);

		// kaigoTableChangeFlgに1（変更あり）を代入する。
		setKaigoTableChangeFlg(1);

	}

	/**
	 * 「介護公費情報編集処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoButtonConpileActionPerformed(ActionEvent e)
			throws Exception {

		// 入力チェックを行う。
		if (!isValidInput(INSURE_TYPE_KAIGO, CHECK_MODE_UPDATE)) {
			// 入力エラーがあった場合
			return;
		}

		// 入力エラーがなかった場合

		// 入力されたデータを取得する。
		VRMap map = new VRHashMap();
		getKaigoInfo().setSource(map);
		getKaigoInfo().applySource();

		// 選択行のデータを取得する。
		VRMap temp = (VRMap) getKaigoInfoTable().getSelectedModelRowValue();

		// 画面上にないデータを、テーブルのデータから移す。
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));
		VRBindPathParser.set("KOHI_ID", map, VRBindPathParser.get("KOHI_ID",
				temp));
		VRBindPathParser.set("INSURE_TYPE", map, VRBindPathParser.get(
				"INSURE_TYPE", temp));

		// 有効期間の付加処理
		setMaxAndMinDate(map);

		// 取得したデータをテーブル表示用に編集する。
		map = toKohiTableList(map);

		// 選択データのpatientKohiListでのインデックスを取得する。
		int row = ACBindUtilities.getMatchIndexFromMap(getPatientKohiList(),
				"KOHI_ID", temp);

		// StringからIntegerに型変換 ※ソート時対策
		final String[] keys = new String[] { "BENEFIT_RATE", };
		QkanCommon.convertValueFromStringToInteger(map, keys);

		// 画面上のデータを設定する。
		getPatientKohiList().set(row, map);

		// レコードのKOHI_ID（以下、kohiId）を取得する。
		int kohiId = ACCastUtilities
				.toInt(VRBindPathParser.get("KOHI_ID", map));

		// patientKohiServiceListから、KOHI_ID=kohiIdのレコードを削除する。
		if (getPatientKohiServiceList() != null) {
			for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
				VRMap patientKohiService = (VRMap) getPatientKohiServiceList()
						.get(i);

				if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
						patientKohiService)) == kohiId) {
					getPatientKohiServiceList().remove(i);

					// 削除したのでインデックスを1つ戻す。
					i = i - 1;
				}

			}
		}

		// 画面の利用者公費サービス情報取得関数を呼び出し、戻り値をArrayList：Listに格納する。
		// ・第一引数：kohiId
		// ・第ニ引数：INSURE_TYPE_KAIGO
		VRList list = getPatientKohiService(kohiId, INSURE_TYPE_KAIGO);

		// ListをpatientKohiServiceListに追加する。
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				getPatientKohiServiceList().add(list.get(i));
			}
		}

		// patientKohiListより介護公費のデータを取得し、テーブルモデルに設定する。
		VRList kaigoKohiList = getListToSetTable(getPatientKohiList(),
				INSURE_TYPE_KAIGO);
		getKaigoTableModel().setAdaptee(kaigoKohiList);

		// 以下の条件で介護公費テーブルのソートを行う。
		// KOHI_VALID_START（公費有効期間開始） DESC
		getKaigoInfoTable().sort("KOHI_VALID_START DESC");

		// 選択していた行を選択
		int selectedRow = ACBindUtilities.getMatchIndexFromMap(kaigoKohiList,
				"KOHI_ID", map);
		getKaigoInfoTable().setSelectedModelRow(selectedRow);

		// kaigoTableChangeFlgに1（変更あり）を代入する。
		setKaigoTableChangeFlg(1);

	}

	/**
	 * 「介護公費情報削除処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoButtonDeleteActionPerformed(ActionEvent e)
			throws Exception {

		// 確認メッセージを表示する。
		// ・メッセージID：WARNING_OF_DELETE_SELECTION
		if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() == ACMessageBox.RESULT_OK) {
			// 「はい」を選択した場合

			// 選択されているデータの画面上のインデックスを退避する。
			int sortedRow = getKaigoInfoTable().getSelectedSortedRow();

			// 選択データのKOHI_IDを退避する。
			VRMap map = (VRMap) getKaigoInfoTable().getSelectedModelRowValue();
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					map));

			// 選択行データの削除
			int selectedRow = ACBindUtilities.getMatchIndexFromMap(
					getPatientKohiList(), "KOHI_ID", map);
			getPatientKohiList().remove(selectedRow);

			// patientKohiListより介護公費のデータを取得し、テーブルモデルに設定する。
			VRList kaigoKohiList = getListToSetTable(getPatientKohiList(),
					INSURE_TYPE_KAIGO);
			getKaigoTableModel().setAdaptee(kaigoKohiList);

			// 選択されているレコードのKOHI_IDで下記のレコード集合を検索し、該当レコードを削除する。
			// ・patientKohiServiceList
			if (getPatientKohiServiceList() != null) {
				for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
					VRMap patientKohiService = (VRMap) getPatientKohiServiceList()
							.get(i);

					if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
							patientKohiService)) == kohiId) {
						getPatientKohiServiceList().remove(i);

						// 削除したのでインデックスを1つ戻す。
						i = i - 1;
					}
				}
			}

			// 削除された行の1行上を選択する。
			getKaigoInfoTable().setSelectedSortedRowOnAfterDelete(sortedRow);

			// kaigoTableChangeFlgに1（変更あり）を代入する。
			setKaigoTableChangeFlg(1);

		}

	}

	/**
	 * 「医療公費情報クリア処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void iryoInfoButtonClearActionPerformed(ActionEvent e)
			throws Exception {

		// クリア処理

		if (getIryoInfoTable().isSelected()) {
			// 画面テーブルの行が選択されている場合
			// テーブルの選択をクリアする。
			getIryoInfoTable().clearSelection();
		} else {
			// 画面テーブルの行が選択されている場合
			VRMap map = new VRHashMap();
			// 新たなソースを生成する。
			map = (VRMap) getIryoInfo().createSource();
			getIryoInfo().setSource(map);
			getIryoInfo().bindSource();

			// スナップショット
			getSnapShotIryo().snapshot();

		}

	}

	/**
	 * 「医療公費情報追加処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void iryoInfoButtonInsertActionPerformed(ActionEvent e)
			throws Exception {

		// 入力チェックを行う。
		if (!isValidInput(INSURE_TYPE_IRYO, CHECK_MODE_INSERT)) {
			// 入力エラーがあった場合
			return;
		}

		// 入力エラーがなかった場合
		// 空のHashMapを生成し、「医療公費領域・情報2（iryoInfo）」のソースとして設定する。
		VRMap map = new VRHashMap();
		getIryoInfo().setSource(map);

		// 入力されたデータをソースに流し込み、データを取得する。
		getIryoInfo().applySource();

		// 取得した画面上のデータにPATIENT_IDを設定する。
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));

		// patientKohiListを件数分ループし、KOHI_IDの最大値+1の値を取得する。
		int maxId = 0;

		// 最大値の取得
		if (!(getPatientKohiList() == null || getPatientKohiList().size() == 0)) {

			// 画面テーブルに既にデータが存在している場合
			for (int i = 0; i < getPatientKohiList().size(); i++) {

				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"KOHI_ID", (VRMap) getPatientKohiList().get(i)));

				// 比較対象が比較元より大きい値の場合
				if (maxId < target) {
					// 比較対象を比較元とする。
					maxId = target;
				}

			}
		}

		// KOHI_IDを追加する。
		VRBindPathParser.set("KOHI_ID", map, new Integer(maxId + 1));

		// INSURE_TYPEを設定する。
		VRBindPathParser.set("INSURE_TYPE", map, new Integer(INSURE_TYPE_IRYO));

		// テーブル表示用に編集する。
		map = toKohiTableList(map);

		// 有効期間の付加処理
		setMaxAndMinDate(map);

		// StringからIntegerに型変換 ※ソート時対策
		final String[] keys = new String[] { "BENEFIT_RATE", };
		QkanCommon.convertValueFromStringToInteger(map, keys);

		// 取得したデータをpatientKohiListの新しいレコードとして追加する。
		getPatientKohiList().add(map);

		// 画面の利用者公費サービス情報取得関数を呼び出し、戻り値をArrayList：Listに格納する。
		// ・第一引数：kohiId
		// ・第ニ引数：INSURE_TYPE_IRYO
		VRList list = getPatientKohiService(maxId + 1, INSURE_TYPE_IRYO);

		// ListをpatientKohiServiceListに追加する。
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				getPatientKohiServiceList().add(list.get(i));
			}
		}

		// patientKohiListより医療公費のデータを取得し、テーブルモデルに設定する。
		VRList iryoKohiList = getListToSetTable(getPatientKohiList(),
				INSURE_TYPE_IRYO);
		getIryoTableModel().setAdaptee(iryoKohiList);

		// 以下の条件で医療公費テーブルのソートを行う。
		// KOHI_VALID_START（公費有効期間開始） DESC
		getIryoInfoTable().sort("KOHI_VALID_START DESC");

		// 追加行を選択
		int selectedRow = ACBindUtilities.getMatchIndexFromMap(iryoKohiList,
				"KOHI_ID", map);
		getIryoInfoTable().setSelectedModelRow(selectedRow);

		// iryoTableChangeFlgに1（変更あり）を代入する。
		setIryoTableChangeFlg(1);

	}

	/**
	 * 「医療公費情報編集処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void iryoInfoButtonConpileActionPerformed(ActionEvent e)
			throws Exception {

		// 入力チェックを行う。
		if (!isValidInput(INSURE_TYPE_IRYO, CHECK_MODE_UPDATE)) {
			// 入力エラーがあった場合
			return;
		}

		// 入力エラーがなかった場合

		// 入力されたデータを取得する。
		VRMap map = new VRHashMap();
		getIryoInfo().setSource(map);
		getIryoInfo().applySource();

		// 選択行のデータを取得する。
		VRMap temp = (VRMap) getIryoInfoTable().getSelectedModelRowValue();

		// 画面上にないデータを、テーブルのデータから移す。
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));
		VRBindPathParser.set("KOHI_ID", map, VRBindPathParser.get("KOHI_ID",
				temp));
		VRBindPathParser.set("INSURE_TYPE", map, VRBindPathParser.get(
				"INSURE_TYPE", temp));

		// 有効期間の付加処理
		setMaxAndMinDate(map);

		// 取得したデータをテーブル表示用に編集する。
		map = toKohiTableList(map);

		// 選択データのpatientKohiListでのインデックスを取得する。
		int row = ACBindUtilities.getMatchIndexFromMap(getPatientKohiList(),
				"KOHI_ID", temp);

		// StringからIntegerに型変換 ※ソート時対策
		final String[] keys = new String[] { "BENEFIT_RATE", };
		QkanCommon.convertValueFromStringToInteger(map, keys);

		// 画面上のデータを設定する。
		getPatientKohiList().set(row, map);

		// レコードのKOHI_ID（以下、kohiId）を取得する。
		int kohiId = ACCastUtilities
				.toInt(VRBindPathParser.get("KOHI_ID", map));

		// patientKohiServiceListから、KOHI_ID=kohiIdのレコードを削除する。
		if (getPatientKohiServiceList() != null) {
			for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
				VRMap patientKohiService = (VRMap) getPatientKohiServiceList()
						.get(i);

				if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
						patientKohiService)) == kohiId) {

					// 削除
					getPatientKohiServiceList().remove(i);

					// 削除したのでインデックスを1つ戻す。
					i = i - 1;
				}

			}
		}

		// 画面の利用者公費サービス情報取得関数を呼び出し、戻り値をArrayList：Listに格納する。
		// ・第一引数：kohiId
		// ・第ニ引数：INSURE_TYPE_IRYO
		VRList list = getPatientKohiService(kohiId, INSURE_TYPE_IRYO);

		// ListをpatientKohiServiceListに追加する。
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				getPatientKohiServiceList().add(list.get(i));
			}
		}

		// patientKohiListより医療公費のデータを取得し、テーブルモデルに設定する。
		VRList iryoKohiList = getListToSetTable(getPatientKohiList(),
				INSURE_TYPE_IRYO);
		getIryoTableModel().setAdaptee(iryoKohiList);

		// 以下の条件で医療公費テーブルのソートを行う。
		// KOHI_VALID_START（公費有効期間開始） DESC
		getIryoInfoTable().sort("KOHI_VALID_START DESC");

		// 選択していた行を選択
		int selectedRow = ACBindUtilities.getMatchIndexFromMap(iryoKohiList,
				"KOHI_ID", map);
		getIryoInfoTable().setSelectedModelRow(selectedRow);

		// iryoTableChangeFlgに1（変更あり）を代入する。
		setIryoTableChangeFlg(1);

	}

	/**
	 * 「医療公費情報削除処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void iryoInfoButtonDeleteActionPerformed(ActionEvent e)
			throws Exception {

		// 確認メッセージを表示する。
		// ・メッセージID：WARNING_OF_DELETE_SELECTION
		if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() == ACMessageBox.RESULT_OK) {
			// 「はい」を選択した場合

			// 選択されているデータの画面上のインデックスを退避する。
			int sortedRow = getIryoInfoTable().getSelectedSortedRow();

			// 選択データのKOHI_IDを退避する。
			VRMap map = (VRMap) getIryoInfoTable().getSelectedModelRowValue();
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					map));

			// 選択行データの削除
			int selectedRow = ACBindUtilities.getMatchIndexFromMap(
					getPatientKohiList(), "KOHI_ID", map);
			getPatientKohiList().remove(selectedRow);

			// patientKohiListより医療公費のデータを取得し、テーブルモデルに設定する。
			VRList iryoKohiList = getListToSetTable(getPatientKohiList(),
					INSURE_TYPE_IRYO);
			getIryoTableModel().setAdaptee(iryoKohiList);

			// 選択されているレコードのKOHI_IDで下記のレコード集合を検索し、該当レコードを削除する。
			// ・patientKohiServiceList
			if (getPatientKohiServiceList() != null) {
				for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
					VRMap patientKohiService = (VRMap) getPatientKohiServiceList()
							.get(i);

					if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
							patientKohiService)) == kohiId) {
						getPatientKohiServiceList().remove(i);

						// 削除したのでインデックスを1つ戻す。
						i = i - 1;
					}
				}
			}

			// 削除された行の1行上を選択する。
			getIryoInfoTable().setSelectedSortedRowOnAfterDelete(sortedRow);

			// kaigoTableChangeFlgに1（変更あり）を代入する。
			setIryoTableChangeFlg(1);

		}

	}

	/**
	 * 「介護公費情報展開処理」イベントです。
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
			// 画面テーブルの行が選択されていない場合

			// 新たなソースを生成する。
			map = (VRMap) getKaigoInfo().createSource();
			getKaigoInfo().setSource(map);
			getKaigoInfo().bindSource();

			// 負担者名コンボのクリア
			getKaigoInfoBearName().setSelectedItem(null);

			// Enable制御を行う。
			// ・状態ID：ENABLE_KAIGO_BUTTON_FALSE
			setState_ENABLE_KAIGO_BUTTON_FALSE();

		} else {
			// 画面テーブルの行が選択されている場合

			// 選択されたレコードを、「介護公費領域・情報2（kaigoInfo）」
			// のソースとして設定する。
			map = (VRMap) getKaigoInfoTable().getSelectedModelRowValue();
			getKaigoInfo().setSource(map);

			// 画面に展開する。
			getKaigoInfo().bindSource();

			// 負担者名コンボの設定
			Object temp = VRBindPathParser.get("INSURER_ID", map);
			getKaigoInfoBearName().setSelectedItem(
					ACBindUtilities.getMatchRowFromValue(getInsurerList(),
							"INSURER_ID", temp));

			// 選択された公費情報よりKOHI_IDを取得し、int：kohiIdに格納する。
			// 利用者公費サービス情報を画面に展開する。
			// ・第一引数：kohiId
			// ・第ニ引数：INSURE_TYPE_KAIGO
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					map));

			setPatientKohiService(kohiId, INSURE_TYPE_KAIGO);

			// Enable制御を行う。
			// ・状態ID：ENABLE_KAIGO_BUTTON_TRUE
			setState_ENABLE_KAIGO_BUTTON_TRUE();

		}

		// スナップショット
		getSnapShotKaigo().snapshot();

	}

	/**
	 * 「医療公費情報展開処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void iryoInfoTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		VRMap map = new VRHashMap();

		if (!getIryoInfoTable().isSelected()) {
			// 画面テーブルの行が選択されていない場合

			// 新たなソースを生成する。
			map = (VRMap) getIryoInfo().createSource();
			getIryoInfo().setSource(map);
			getIryoInfo().bindSource();

			// 負担者名コンボのクリア
			getIryoInfoBearName().setSelectedItem(null);

			// Enable制御を行う。
			// ・状態ID：ENABLE_IRYO_BUTTON_FALSE
			setState_ENABLE_IRYO_BUTTON_FALSE();

		} else {
			// 画面テーブルの行が選択されている場合

			// 選択されているレコードを、「医療公費領域・情報2（iryoInfo）」に設定する。
			map = (VRMap) getIryoInfoTable().getSelectedModelRowValue();
			getIryoInfo().setSource(map);

			// 画面に展開する。
			getIryoInfo().bindSource();

			// 負担者名コンボの設定
			Object temp = VRBindPathParser.get("INSURER_ID", map);
			getIryoInfoBearName().setSelectedItem(
					ACBindUtilities.getMatchRowFromValue(getInsurerList(),
							"INSURER_ID", temp));

			// 選択された公費情報よりKOHI_IDを取得し、int：kohiIdに格納する。
			// 利用者公費サービス情報を画面に展開する。
			// ・第一引数：kohiId
			// ・第ニ引数：INSURE_TYPE_IRYO
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					map));

			setPatientKohiService(kohiId, INSURE_TYPE_IRYO);

			// Enable制御を行う。
			// ・状態ID：ENABLE_IRYO_BUTTON_TRUE
			setState_ENABLE_IRYO_BUTTON_TRUE();

		}

		// スナップショット
		getSnapShotIryo().snapshot();

	}

	/**
	 * 「負担者番号入力時処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoInsurerNoFocusLost(FocusEvent e) throws Exception {

		// 入力された負担者番号を持つ負担者の名称を負担者名コンボ（kaigoInfoBearName）に表示する。
		doFindInsurerName(INSURE_TYPE_KAIGO);

	}

	/**
	 * 「負担者名選択時処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoBearNameActionPerformed(ActionEvent e)
			throws Exception {

		// 選択された負担者の負担者番号を負担者番号フィールド（kaigoInfoInsurerNo）に表示する。
		doFindInsurerId(INSURE_TYPE_KAIGO);

	}

	/**
	 * 「負担者番号入力時処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void iryoInfoInsurerNoFocusLost(FocusEvent e) throws Exception {

		// 入力された負担者番号を持つ負担者の名称を負担者名コンボ（iryoInfoBearName）に表示する。
		doFindInsurerName(INSURE_TYPE_IRYO);

	}

	/**
	 * 「負担者名選択時処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void iryoInfoBearNameActionPerformed(ActionEvent e)
			throws Exception {

		// 選択された負担者の負担者番号を負担者番号フィールド（iryoInfoInsurerNo）に表示する。
		doFindInsurerId(INSURE_TYPE_IRYO);

	}

	/**
	 * 「公費情報選択時処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kaigoInfoPublicExpenseActionPerformed(ActionEvent e)
			throws Exception {

		// 選択された公費の法別番号（BENEFIT_RATE）を取得し、kaigoInfoBenefitRateに表示する。
		// 選択された公費の法別番号（KOHI_LAW_NO）を取得し、kaigoInfoKohiNoに表示する。
		if (getKaigoInfoPublicExpense().isSelected()) {
			VRMap map = (VRMap) getKaigoInfoPublicExpense().getSelectedItem();
			getKaigoInfoBenefitRate().setText(
					ACCastUtilities.toString(VRBindPathParser.get(
							"BENEFIT_RATE", map)));
			getKaigoInfoKohiNo().setText(
					ACCastUtilities.toString(VRBindPathParser.get(
							"KOHI_LAW_NO", map)));

			// 選択された公費の給付対象サービスを検索する。
			int kohiType = ACCastUtilities.toInt(VRBindPathParser.get(
					"KOHI_TYPE", map));
			doFindTargetService(kohiType, INSURE_TYPE_KAIGO);

			// 法別番号テキストのEditableを切り替える。
//			if (kohiType == KAIGO_OTHER_KOHI) {
//				// 「その他公費」の場合Editable = true
//				setState_KAIGO_OTHER_ON();
//			} else {
				// 「その他公費」以外の場合Editable = false
				setState_KAIGO_OTHER_OFF();
//			}

		} else {
			// 選択されていない場合
			getKaigoInfoKohiNo().setText("");

			VRList list = new VRArrayList();
			getKaigoServiceTableModel().setAdaptee(list);

			// 法別番号テキストのEditable = false
			setState_KAIGO_OTHER_OFF();

		}
	}

	/**
	 * 「公費情報選択時処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void iryoInfoPublicExpenseActionPerformed(ActionEvent e)
			throws Exception {

		// 選択された公費の法別番号（BENEFIT_RATE）を取得し、iryoInfoBenefitRateに表示する。
		// 選択された公費の法別番号（KOHI_LAW_NO）を取得し、iryoInfoKohiNoに表示する。
		if (getIryoInfoPublicExpense().isSelected()) {
			VRMap map = (VRMap) getIryoInfoPublicExpense().getSelectedItem();
			getIryoInfoBenefitRate().setText(
					ACCastUtilities.toString(VRBindPathParser.get(
							"BENEFIT_RATE", map)));
			getIryoInfoKohiNo().setText(
					ACCastUtilities.toString(VRBindPathParser.get(
							"KOHI_LAW_NO", map)));

			// 選択された公費の給付対象サービスを検索する。
			int kohiType = ACCastUtilities.toInt(VRBindPathParser.get(
					"KOHI_TYPE", map));
			doFindTargetService(kohiType, INSURE_TYPE_IRYO);

			// 法別番号テキストのEditableを切り替える。
			if (kohiType == IRYO_OTHER_KOHI) {
				// 「その他公費」の場合Editable = true
				setState_IRYO_OTHER_ON();
			} else {
				// 「その他公費」以外の場合Editable = false
				setState_IRYO_OTHER_OFF();
			}

		} else {
			// 選択されていない場合
			getIryoInfoKohiNo().setText("");

			VRList list = new VRArrayList();
			getIryoServiceTableModel().setAdaptee(list);

			// 法別番号テキストのEditable = false
			setState_IRYO_OTHER_OFF();
		}

	}

	/**
	 * 「クリア処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void shahukuInfoButtonClearActionPerformed(ActionEvent e)
			throws Exception {

		// クリア処理

		if (getShahukuInfoTable().isSelected()) {
			// 画面テーブルの行が選択されている場合
			// テーブルの選択をクリアする。
			getShahukuInfoTable().clearSelection();
		} else {
			// 画面テーブルの行が選択されている場合
			VRMap map = new VRHashMap();
			// 新たなソースを生成する。
			map = (VRMap) getShahukuInfo().createSource();
			getShahukuInfo().setSource(map);
			getShahukuInfo().bindSource();

			// スナップショット
			getSnapShotShahuku().snapshot();

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
	protected void shahukuInfoButtonInsertActionPerformed(ActionEvent e)
			throws Exception {

		// 入力チェックを行う。
		if (!isValidInput(INSURE_TYPE_SHAHUKU, CHECK_MODE_INSERT)) {
			// 入力エラーがあった場合
			return;
		}

		// 入力エラーがなかった場合
		// 空のHashMapを生成し、ソースとして設定する。
		VRMap map = new VRHashMap();
		getShahukuInfo().setSource(map);

		// 入力されたデータをソースに流し込み、データを取得する。
		getShahukuInfo().applySource();

		// 取得した画面上のデータにPATIENT_IDを設定する。
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));

		// patientKohiListを件数分ループし、KOHI_IDの最大値+1の値を取得する。
		int maxId = 0;

		// 最大値の取得
		if (!(getPatientKohiList() == null || getPatientKohiList().size() == 0)) {

			// 画面テーブルに既にデータが存在している場合
			for (int i = 0; i < getPatientKohiList().size(); i++) {

				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"KOHI_ID", (VRMap) getPatientKohiList().get(i)));

				// 比較対象が比較元より大きい値の場合
				if (maxId < target) {
					// 比較対象を比較元とする。
					maxId = target;
				}

			}
		}

		// KOHI_IDを追加する。
		VRBindPathParser.set("KOHI_ID", map, new Integer(maxId + 1));

		// KOHI_TYPEを追加する。
		VRBindPathParser.set("KOHI_TYPE", map, "7701");

		// INSURE_TYPEを設定する。
		VRBindPathParser.set("INSURE_TYPE", map, new Integer(
				INSURE_TYPE_SHAHUKU));

		// 有効期間の付加処理
		setMaxAndMinDate(map);

		// テーブル表示用に編集する。
		map = toShahukuTableList(map, "FROM_INPUT");

		// 取得したデータをpatientKohiListの新しいレコードとして追加する。
		getPatientKohiList().add(map);

		// 画面の利用者公費サービス情報取得関数を呼び出し、戻り値をArrayList：Listに格納する。
		// ・第一引数：kohiId
		// ・第ニ引数：INSURE_TYPE_SHAHUKU
		VRList list = getPatientKohiService(maxId + 1, INSURE_TYPE_SHAHUKU);

		// ListをpatientKohiServiceListに追加する。
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				getPatientKohiServiceList().add(list.get(i));
			}
		}

		// patientKohiListより社会福祉軽減のデータを取得し、テーブルモデルに設定する。
		VRList shahukuKohiList = getListToSetTable(getPatientKohiList(),
				INSURE_TYPE_SHAHUKU);
		getShahukuTableModel().setAdaptee(shahukuKohiList);

		// 以下の条件で医療公費テーブルのソートを行う。
		// KOHI_VALID_START（公費有効期間開始） DESC
		getShahukuInfoTable().sort("KOHI_VALID_START DESC");

		// 追加行を選択
		int selectedRow = ACBindUtilities.getMatchIndexFromMap(shahukuKohiList,
				"KOHI_ID", map);
		getShahukuInfoTable().setSelectedModelRow(selectedRow);

		// shahukuTableChangeFlgに1（変更あり）を代入する。
		setShahukuTableChangeFlg(1);

	}

	/**
	 * 「編集処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void shahukuInfoButtonConpileActionPerformed(ActionEvent e)
			throws Exception {

		// 入力チェックを行う。
		if (!isValidInput(INSURE_TYPE_SHAHUKU, CHECK_MODE_UPDATE)) {
			// 入力エラーがあった場合
			return;
		}

		// 入力エラーがなかった場合

		// 入力されたデータを取得する。
		VRMap map = new VRHashMap();
		getShahukuInfo().setSource(map);
		getShahukuInfo().applySource();

		// 選択行のデータを取得する。
		VRMap temp = (VRMap) getShahukuInfoTable().getSelectedModelRowValue();

		// 画面上にないデータを、テーブルのデータから移す。
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));
		VRBindPathParser.set("KOHI_ID", map, VRBindPathParser.get("KOHI_ID",
				temp));
		VRBindPathParser.set("INSURE_TYPE", map, VRBindPathParser.get(
				"INSURE_TYPE", temp));

		// KOHI_TYPEを追加する。
		VRBindPathParser.set("KOHI_TYPE", map, "7701");

		// 有効期間の付加処理
		setMaxAndMinDate(map);

		// テーブル表示用に編集する。
		map = toShahukuTableList(map, "FROM_INPUT");

		// 選択データのpatientKohiListでのインデックスを取得する。
		int row = ACBindUtilities.getMatchIndexFromMap(getPatientKohiList(),
				"KOHI_ID", temp);

		// 画面上のデータを設定する。
		getPatientKohiList().set(row, map);

		// レコードのKOHI_ID（以下、kohiId）を取得する。
		int kohiId = ACCastUtilities
				.toInt(VRBindPathParser.get("KOHI_ID", map));

		// patientKohiServiceListから、KOHI_ID=kohiIdのレコードを削除する。
		if (getPatientKohiServiceList() != null) {
			for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
				VRMap patientKohiService = (VRMap) getPatientKohiServiceList()
						.get(i);

				if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
						patientKohiService)) == kohiId) {

					// 削除
					getPatientKohiServiceList().remove(i);

					// 削除したのでインデックスを1つ戻す。
					i = i - 1;
				}

			}
		}

		// 画面の利用者公費サービス情報取得関数を呼び出し、戻り値をArrayList：Listに格納する。
		// ・第一引数：kohiId
		// ・第ニ引数：INSURE_TYPE_SHAHUKU
		VRList list = getPatientKohiService(kohiId, INSURE_TYPE_SHAHUKU);

		// ListをpatientKohiServiceListに追加する。
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				getPatientKohiServiceList().add(list.get(i));
			}
		}

		// patientKohiListより社会福祉軽減のデータを取得し、テーブルモデルに設定する。
		VRList shahukuKohiList = getListToSetTable(getPatientKohiList(),
				INSURE_TYPE_SHAHUKU);
		getShahukuTableModel().setAdaptee(shahukuKohiList);

		// 以下の条件で社会福祉軽減公費テーブルのソートを行う。
		// KOHI_VALID_START（公費有効期間開始） DESC
		getShahukuInfoTable().sort("KOHI_VALID_START DESC");

		// 選択していた行を選択
		int selectedRow = ACBindUtilities.getMatchIndexFromMap(shahukuKohiList,
				"KOHI_ID", map);
		getShahukuInfoTable().setSelectedModelRow(selectedRow);

		// shahukuTableChangeFlgに1（変更あり）を代入する。
		setShahukuTableChangeFlg(1);
	}

	/**
	 * 「削除処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void shahukuInfoButtonDeleteActionPerformed(ActionEvent e)
			throws Exception {

		// 確認メッセージを表示する。
		// ・メッセージID：WARNING_OF_DELETE_SELECTION
		if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() == ACMessageBox.RESULT_OK) {
			// 「はい」を選択した場合

			// 選択されているデータの画面上のインデックスを退避する。
			int sortedRow = getShahukuInfoTable().getSelectedSortedRow();

			// 選択データのKOHI_IDを退避する。
			VRMap map = (VRMap) getShahukuInfoTable()
					.getSelectedModelRowValue();
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					map));

			// 選択行データの削除
			int selectedRow = ACBindUtilities.getMatchIndexFromMap(
					getPatientKohiList(), "KOHI_ID", map);
			getPatientKohiList().remove(selectedRow);

			// patientKohiListより社会福祉軽減のデータを取得し、テーブルモデルに設定する。
			VRList shahukuKohiList = getListToSetTable(getPatientKohiList(),
					INSURE_TYPE_SHAHUKU);
			getShahukuTableModel().setAdaptee(shahukuKohiList);

			// 選択されているレコードのKOHI_IDで下記のレコード集合を検索し、該当レコードを削除する。
			// ・patientKohiServiceList
			if (getPatientKohiServiceList() != null) {
				for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
					VRMap patientKohiService = (VRMap) getPatientKohiServiceList()
							.get(i);

					if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
							patientKohiService)) == kohiId) {
						getPatientKohiServiceList().remove(i);

						// 削除したのでインデックスを1つ戻す。
						i = i - 1;
					}
				}
			}

			// 削除された行の1行上を選択する。
			getShahukuInfoTable().setSelectedSortedRowOnAfterDelete(sortedRow);

			// kaigoTableChangeFlgに1（変更あり）を代入する。
			setShahukuTableChangeFlg(1);

		}

	}

	/**
	 * 「社会福祉軽減情報展開処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void shahukuInfoTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		VRMap map = new VRHashMap();

		if (!getShahukuInfoTable().isSelected()) {
			// 画面テーブルの行が選択されていない場合

			// 新たなソースを生成する。
			map = (VRMap) getShahukuInfo().createSource();
			getShahukuInfo().setSource(map);
			getShahukuInfo().bindSource();

			// Enable制御を行う。
			// ・状態ID：ENABLE_SHAHUKU_BUTTON_FALSE
			setState_ENABLE_SHAHUKU_BUTTON_FALSE();

		} else {
			// 画面テーブルの行が選択されている場合

			// 選択されているレコードを、「社会福祉軽減領域・情報2（shahukuInfo）」に設定する。
			map = (VRMap) getShahukuInfoTable().getSelectedModelRowValue();
			getShahukuInfo().setSource(map);

			// 画面に展開する。
			getShahukuInfo().bindSource();

			// 選択された公費情報よりKOHI_IDを取得し、int：kohiIdに格納する。
			// 利用者公費サービス情報を画面に展開する。
			// ・第一引数：kohiId
			// ・第ニ引数：INSURE_TYPE_SHAHUKU
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					map));

			setPatientKohiService(kohiId, INSURE_TYPE_SHAHUKU);

			// Enable制御を行う。
			// ・状態ID：ENABLE_SHAHUKU_BUTTON_TRUE
			setState_ENABLE_SHAHUKU_BUTTON_TRUE();

		}

		// スナップショット
		getSnapShotShahuku().snapshot();

	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		param.setData("PATIENT_ID", new Integer(40));
		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QU004.class.getName(), param));
	}

	// 内部関数

	/**
	 * 「レコード取得・画面設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFind() throws Exception {
		// レコード取得・画面設定

		// 渡された利用者IDを用いて、利用者基本情報を取得する。
		VRList patientList = QkanCommon.getPatientInfo(getDBManager(),
				getPatientId());

		// 利用者基本情報が取得できなかった場合
		if (patientList == null || patientList.size() == 0) {
			// 例外処理を行う。このロジックを通るのは当画面に遷移する間に
			// 利用者(PATIENT)が削除された場合であるため。
			// エラーメッセージを表示する。
			// ・メッセージID：ERROR_OF_PASSIVE_CHECK_ON_FIND
			QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();

			// 強制戻りフラグに1を代入する。
			setCompulsoryBackFlg(1);

			// 前画面へ遷移する。
			ACFrame.getInstance().back();
			return;
		}

		// パッシブチェック用に退避する。
		getPassiveChecker()
				.reservedPassive(getPASSIVE_CHECK_KEY(), patientList);

		// 取得した利用者情報より、以下のフィールドの値を取得する。
		// ・PATIENT_FAMILY_NAME
		// ・PATIENT_FIRST_NAME
		String patientFamilyName = ACCastUtilities.toString(VRBindPathParser
				.get("PATIENT_FAMILY_NAME", (VRMap) patientList.get(0)));
		String patientFirstName = ACCastUtilities.toString(VRBindPathParser
				.get("PATIENT_FIRST_NAME", (VRMap) patientList.get(0)));

		// 上記の値を結合して、patientNameに表示する。
		getPatientName().setText(
				QkanCommon.toFullName(patientFamilyName, patientFirstName));

		// 利用者公費情報を取得する。
		doFindPatientKohi();

		// 利用者公費サービス情報を取得する。
		doFindPatientKohiService();

		// patientKohiListより介護公費情報（INSURE_TYPE = INSURE_TYPE_KAIGOのレコード）
		// を抽出し、kaigoKohiListに格納する。
		// patientKohiListより医療公費情報（INSURE_TYPE = INSURE_TYPE_IRYOのレコード）
		// を抽出し、iryoKohiListに格納する。
		VRList kaigoKohiList = new VRArrayList();
		VRList iryoKohiList = new VRArrayList();
		VRList shahukuKohiList = new VRArrayList();

		if (!(getPatientKohiList() == null || getPatientKohiList().size() == 0)) {
			for (int i = 0; i < getPatientKohiList().size(); i++) {

				VRMap temp = (VRMap) getPatientKohiList().get(i);

				if (ACCastUtilities.toInt(VRBindPathParser.get("INSURE_TYPE",
						temp)) == INSURE_TYPE_KAIGO) {

					toKohiTableList(temp);
					kaigoKohiList.add(temp);

				} else if (ACCastUtilities.toInt(VRBindPathParser.get(
						"INSURE_TYPE", temp)) == INSURE_TYPE_IRYO) {

					toKohiTableList(temp);
					iryoKohiList.add(temp);

				} else if (ACCastUtilities.toInt(VRBindPathParser.get(
						"INSURE_TYPE", temp)) == INSURE_TYPE_SHAHUKU) {

					toShahukuTableList(temp, "FROM_DB");
					shahukuKohiList.add(temp);

				}
			}
		}

		// 利用者介護公費情報（kaigoKohiList）をkaigoTableModelに設定する。
		getKaigoTableModel().setAdaptee(kaigoKohiList);

		if (!(kaigoKohiList == null || kaigoKohiList.size() == 0)) {
			// 介護公費テーブルに1件以上レコードが存在する場合
			// 介護公費テーブルの1列目を選択した状態にする。
			getKaigoInfoTable().setSelectedSortedFirstRow();

			// processModeに共通定数のPROCESS_MODE_UPDATEを代入する。
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

		} else {
			// 介護公費テーブルのレコードが0件の場合
			// 介護公費情報領域の初期値作成
			VRMap defaultMap = (VRMap) getKaigoInfo().createSource();
			// 領域のクリア
			getKaigoInfo().setSource(defaultMap);
			getKaigoInfo().bindSource();

			// Enable制御を行う。
			// ・状態ID：ENABLE_KAIGO_BUTTON_FALSE
			setState_ENABLE_KAIGO_BUTTON_FALSE();
		}

		// 利用者医療公費情報（iryoKohiList）をiryoTableModelに設定する。
		getIryoTableModel().setAdaptee(iryoKohiList);

		if (!(iryoKohiList == null || iryoKohiList.size() == 0)) {
			// 医療公費テーブルに1件以上レコードが存在する場合
			// 医療公費テーブルの1列目を選択した状態にする。
			getIryoInfoTable().setSelectedSortedFirstRow();

			// processModeに共通定数のPROCESS_MODE_UPDATEを代入する。
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

		} else {
			// 医療公費テーブルのレコードが0件の場合
			// 医療公費情報の初期値作成
			VRMap defaultMap = (VRMap) getIryoInfo().createSource();
			// 領域のクリア
			getIryoInfo().setSource(defaultMap);
			getIryoInfo().bindSource();

			// Enable制御を行う。
			// ・状態ID：ENABLE_IRYO_BUTTON_FALSE
			setState_ENABLE_IRYO_BUTTON_FALSE();
		}

		// 社会福祉軽減公費情報（shahukuKohiList）をshahukuTableModelに設定する。
		getShahukuTableModel().setAdaptee(shahukuKohiList);

		if (!(shahukuKohiList == null || shahukuKohiList.size() == 0)) {
			// 社会福祉軽減テーブルに1件以上レコードが存在する場合
			// 社会福祉軽減テーブルの1列目を選択した状態にする。
			getShahukuInfoTable().setSelectedSortedFirstRow();

			// processModeに共通定数のPROCESS_MODE_UPDATEを代入する。
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

		} else {
			// 社会福祉軽減テーブルのレコードが0件の場合
			// 社会福祉軽減情報領域の初期値作成
			VRMap defaultMap = (VRMap) getShahukuInfo().createSource();
			// 領域のクリア
			getShahukuInfo().setSource(defaultMap);
			getShahukuInfo().bindSource();

			// Enable制御を行う。
			// ・状態ID：ENABLE_SHAHUKU_BUTTON_FALSE
			setState_ENABLE_SHAHUKU_BUTTON_FALSE();
		}

		// 業務ボタンの状態設定
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// 新規モード（processModeが共通定数のPROCESS_MODE_INSERT）の場合
			// 業務ボタンの状態設定を行う。
			// ･状態ID：INSERT_MODE
			setState_INSERT_MODE();
		} else {
			// 更新モード（processModeが共通定数のPROCESS_MODE_UPDATE）の場合
			// 業務ボタンの状態設定を行う。
			// ･状態ID：UPDATE_MODE
			setState_UPDATE_MODE();
		}

		// フォーカス
		getKaigoInfoPublicExpense().requestFocus();

		// スナップショット
		getSnapShotKaigo().snapshot();
		getSnapShotIryo().snapshot();
		getSnapShotShahuku().snapshot();

	}

	/**
	 * 「利用者公費情報取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindPatientKohi() throws Exception {
		// DB（PATIENT_KOHI）より利用者公費情報を取得する。

		// SQL文格納用
		String strSql = "";

		// SQL文取得のためのHashMap：paramを生成し、以下のKEY/VALUEを設定する。
		VRMap param = new VRHashMap();

		// ・PATIENT_ID/patientId
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

		// 利用者公費情報を取得する。
		strSql = getSQL_GET_PATIENT_KOHI(param);
		VRList temp = getDBManager().executeQuery(strSql);

		// patientKohiListに格納する。
		setPatientKohiList(temp);

		// patientKohiListをパッシブチェック用に退避する。
		// getPassiveChecker().reservedPassive(
		// getPASSIVE_CHECK_KEY_KOHI(), getPatientKohiList());

		// 利用者公費情報のレコードが1件以上の場合
		if (!(getPatientKohiList() == null || getPatientKohiList().size() == 0)) {
			// kohiDataFlgに1を代入する。
			setKohiDataFlg(1);
		}
	}

	/**
	 * 「利用者公費サービス情報取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindPatientKohiService() throws Exception {
		// DB（PATIENT_KOHI_SERVICE）より利用者公費サービス情報を取得する。

		// SQL文格納用
		String strSql = "";

		// SQL文取得のためのHashMap：paramを生成し、以下のKEY/VALUEを設定する。
		VRMap param = new VRHashMap();

		// ・PATIENT_ID/patientId
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

		// 利用者公費サービス情報を取得し、patientKohiServiceListに格納する。
		strSql = getSQL_GET_PATIENT_KOHI_SERVICE(param);
		setPatientKohiServiceList(getDBManager().executeQuery(strSql));

		// // patientKohiServiceListをパッシブチェック用に退避する。
		// getPassiveChecker().reservedPassive(
		// getPASSIVE_CHECK_KEY_KOHI_SERVICE(), getPatientKohiServiceList());

		// 利用者公費サービス情報のレコードが1件以上の場合
		if (!(getPatientKohiServiceList() == null || getPatientKohiServiceList()
				.size() == 0)) {
			// kohiServiceDataFlgに1を代入する。
			setKohiServiceDataFlg(1);
		}
	}

	/**
	 * 「負担者名検索」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindInsurerName(int insureType) throws Exception {

		// 負担者名検索を行う。

		// 入力された負担者番号を取得する。
		String insurerId = "";

		if (insureType == INSURE_TYPE_KAIGO) {
			// 介護の場合
			insurerId = getKaigoInfoInsurerNo().getText();
		} else if (insureType == INSURE_TYPE_IRYO) {
			// 医療の場合
			insurerId = getIryoInfoInsurerNo().getText();
		}

		// 負担者番号で負担者情報（insurerList）を検索する。
		VRMap map = (VRMap) ACBindUtilities.getMatchRowFromValue(
				getInsurerList(), "INSURER_ID", insurerId);

		// 負担者名を表示する。
		if (insureType == INSURE_TYPE_KAIGO) {
			// 介護の場合、負担者名コンボ（kaigoInfoBearName）に設定する。
			getKaigoInfoBearName().setSelectedItem(map);
		} else if (insureType == INSURE_TYPE_IRYO) {
			// 医療の場合、負担者名コンボ（iryoInfoBearName）に設定する。
			getIryoInfoBearName().setSelectedItem(map);
		}

	}

	/**
	 * 「負担者番号検索」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindInsurerId(int insureType) throws Exception {

		// 負担者番号検索を行う。
		VRMap map = new VRHashMap();

		if (insureType == INSURE_TYPE_KAIGO) {
			// 介護の場合
			map = (VRMap) getKaigoInfoBearName().getSelectedModelItem();

			if (VRBindPathParser.get("INSURER_ID", map) != null) {
				getKaigoInfoInsurerNo().setText(
						ACCastUtilities.toString(VRBindPathParser.get(
								"INSURER_ID", map)));
			}
		} else if (insureType == INSURE_TYPE_IRYO) {
			// 医療の場合
			map = (VRMap) getIryoInfoBearName().getSelectedModelItem();

			if (VRBindPathParser.get("INSURER_ID", map) != null) {
				getIryoInfoInsurerNo().setText(
						ACCastUtilities.toString(VRBindPathParser.get(
								"INSURER_ID", map)));
			}
		}

	}

	/**
	 * 「給付対象サービス検索」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindTargetService(int kohiType, int insureType)
			throws Exception {

		// 給付対象サービス検索を行う。

		// VRList listを生成する。
		VRList list = new VRArrayList();
		// ソート用TreeMap
		TreeMap sortMap = new TreeMap();

		// masterKohiServiceListの件数分ループする。
		if (getMasterKohiServiceList() == null) {
			return;
		}

		for (int i = 0; i < getMasterKohiServiceList().size(); i++) {

			VRMap temp = (VRMap) getMasterKohiServiceList().get(i);

			if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_TYPE", temp)) == kohiType) {

				// KOHI_TYPE == kohiTypeのレコードのSYSTEM_SERVICE_KIND_DETAILを取得する。
				int systemServiceKindDetail = ACCastUtilities
						.toInt(VRBindPathParser.get(
								"SYSTEM_SERVICE_KIND_DETAIL", temp));

				// systemServiceKindDetailを用いて、masterServiceよりレコードを取得する。
				if (VRBindPathParser.has(new Integer(systemServiceKindDetail),
						getMasterService())) {
					VRMap map = (VRMap) VRBindPathParser.get(new Integer(
							systemServiceKindDetail), getMasterService());

					// mapのCHECK_VALUEを初期化する。
					// デフォルト：チェックON
					// 2006/09/07 replacle begin kamitsukasa
					try{
						// 同期中の例外対応
						VRBindPathParser.set("CHECK_VALUE", map, new Boolean(
								true));
					}catch(Exception ex){
						
					}
					// 2006/09/07 replacle end kamitsukasa
					
					// sortMapに追加（キー：SERVICE_SORT）
					sortMap.put(ACCastUtilities.toInteger(VRBindPathParser.get(
							"SERVICE_SORT", map)), map);

				}
			}
		}

		// sortMapよりレコード集合を作成
		list.addAll(sortMap.values());

		if (insureType == INSURE_TYPE_KAIGO) {
			// 介護の場合（insureType == INSURE_TYPE_KAIGO の場合）
			// listをkaigoServiceTableModelにセットする。
			getKaigoServiceTableModel().setAdaptee(list);

		} else if (insureType == INSURE_TYPE_IRYO) {
			// 医療の場合（insureType == INSURE_TYPE_IRYO の場合）
			// listをiryoServiceTableModelにセットする。
			getIryoServiceTableModel().setAdaptee(list);
		} else {
			// 医療の場合（insureType == INSURE_TYPE_SHAHUKU の場合）
			// listをshahukuServiceTableModelにセットする。
			getShahukuServiceTableModel().setAdaptee(list);
		}

	}

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean isValidInput(int insureType, int checkMode) throws Exception {

		// 入力チェックを行う。
		String msgParam1 = "";
		String msgParam2 = "";
		String msgParam3 = "";
		String temp = "";

		VRMap map = null;
		// 公費種類
		int kohiType;
		// 給付率
		int benefitRate;
		// 有効期間開始
		Date start;
		// 有効期間終了
		Date end;

		if (insureType == INSURE_TYPE_KAIGO) {
			// 介護の場合

			// ・公費情報（kaigoInfoPublicExpense）
			// 選択されているかどうか。
			// ※エラーの場合、String：msgParamを宣言し、"公費情報"を代入する。
			if (!getKaigoInfoPublicExpense().isSelected()) {
				getKaigoInfoPublicExpense().requestFocus();
				msgParam1 = "公費情報";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
						msgParam1);
				return false;
			}

			// ・給付率（kaigoInfoBenefitRate）
			// 入力されているかどうか。
			// ※エラーの場合、String：msgParamを宣言し、"給付率"を代入する。
			if (ACTextUtilities.isNullText(getKaigoInfoBenefitRate().getText())) {
				getKaigoInfoBenefitRate().requestFocus();
				msgParam1 = "給付率";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// ・給付率（kaigoInfoBenefitRate）
			// 入力されているデータをチェックする。
			// ※社会福祉軽減に関しては当チェックは行わない。
			// 画面上のデータを取得する。
			map = new VRHashMap();
			getKaigoInfo().setSource(map);
			getKaigoInfo().applySource();
			// 公費種類取得
			kohiType = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_TYPE",
					map));
			benefitRate = ACCastUtilities.toInt(VRBindPathParser.get(
					"BENEFIT_RATE", map));
			if (benefitRate <= 90 || benefitRate > 100) {
				getKaigoInfoBenefitRate().requestFocus();
				QkanMessageList.getInstance()
						.QU004_ERROR_OF_BENEFIT_RATE_VALUE();
				return false;
			}

			// ・公費法別番号（kaigoInfoKohiNo）
			// 入力されているかどうか。
			// ※エラーの場合、String：msgParamを宣言し、"法別番号"を代入する。
			if (ACTextUtilities.isNullText(getKaigoInfoKohiNo().getText())) {
				getKaigoInfoKohiNo().requestFocus();
				msgParam1 = "法別番号";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
			
			// 桁数が2桁かどうか。
			// ※エラーの場合、String：msgParam1を宣言し、"受給者番号"を代入する。
			// ※エラーの場合、String：msgParam2を宣言し、"7"を代入する。
			temp = getKaigoInfoKohiNo().getText();
			if (temp.length() != 2) {
				getKaigoInfoKohiNo().requestFocus();
				msgParam1 = "法別番号";
				msgParam2 = "2";
				QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
						msgParam2);
				return false;
			}
			
			// ・負担者番号（kaigoInfoInsurerNo）
			// 入力されているかどうか。
			// ※エラーの場合、String：msgParamを宣言し、"負担者番号"を代入する。
			if (ACTextUtilities.isNullText(getKaigoInfoInsurerNo().getText())) {
				getKaigoInfoInsurerNo().requestFocus();
				msgParam1 = "負担者番号";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// ・負担者番号（kaigoInfoInsurerNo）
			// 桁数が6桁かどうか。
			// ※エラーの場合、String：msgParam1を宣言し、"負担者番号"を代入する。
			// ※エラーの場合、String：msgParam2を宣言し、"6"を代入する。
			// temp = getKaigoInfoInsurerNo().getText();
			// if(temp.length() != 6){
			// getKaigoInfoInsurerNo().requestFocus();
			// msgParam1 = "負担者番号";
			// msgParam2 = "6";
			// QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
			// msgParam2);
			// return false;
			// }

			// ・負担者名（kaigoInfoBearName）
			// 選択されているかどうか。
			// ※エラーの場合、String：msgParamを宣言し、"負担者名"を代入する。
			// if(!getKaigoInfoBearName().isSelected()){
			// getKaigoInfoBearName().requestFocus();
			// msgParam1 = "負担者名";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
			// return false;
			// }

			// ・受給者番号（kaigoInfoReceiptNo）
			// 入力されているかどうか。
			// ※エラーの場合、String：msgParamを宣言し、"受給者番号"を代入する。
			if (ACTextUtilities.isNullText(getKaigoInfoReceiptNo().getText())) {
				getKaigoInfoReceiptNo().requestFocus();
				msgParam1 = "受給者番号";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// ・受給者番号（kaigoInfoReceiptNo）
			// 桁数が7桁かどうか。
			// ※エラーの場合、String：msgParam1を宣言し、"受給者番号"を代入する。
			// ※エラーの場合、String：msgParam2を宣言し、"7"を代入する。
			temp = getKaigoInfoReceiptNo().getText();
			if (temp.length() != 7) {
				getKaigoInfoReceiptNo().requestFocus();
				msgParam1 = "受給者番号";
				msgParam2 = "7";
				QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
						msgParam2);
				return false;
			}

			// // ・有効期間開始（kaigoInfoValidLimit1）
			// // 入力されているかどうか。
			// // ※エラーの場合、String：msgParamを宣言し、"有効期間開始日"を代入する。
			// if(ACTextUtilities.isNullText(getKaigoInfoValidLimit1().getText())){
			// getKaigoInfoValidLimit1().requestFocus();
			// msgParam1 = "有効期間開始日";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
			// return false;
			// }

			// ・有効期間開始（kaigoInfoValidLimit1）
			// 入力されている日付が存在するか。
			// ※エラーの場合、String：msgParamを宣言し、"有効期間開始日の"を代入する。
			if (!ACTextUtilities
					.isNullText(getKaigoInfoValidLimit1().getText())) {
				if (!getKaigoInfoValidLimit1().isValidDate()) {
					getKaigoInfoValidLimit1().requestFocus();
					msgParam1 = "有効期間開始日の";
					QkanMessageList.getInstance()
							.ERROR_OF_WRONG_DATE(msgParam1);
					return false;
				}
			}

			// // ・有効期間開始（kaigoInfoValidLimit1）
			// // 月初の日付が入力されているか。
			// // ※エラーの場合、String：msgParam1を宣言し、"開始"を代入する。
			// // ※エラーの場合、String：msgParam2を宣言し、"月初"を代入する。
			// start = getKaigoInfoValidLimit1().getDate();
			// if(ACDateUtilities.compareOnDay(start,
			// ACDateUtilities.toFirstDayOfMonth(start)) != 0){
			// getKaigoInfoValidLimit1().requestFocus();
			// msgParam1 = "開始";
			// msgParam2 = "月初";
			// QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD(msgParam1,
			// msgParam2);
			// return false;
			// }

			// // ・有効期間終了（kaigoInfoValidLimit2）
			// // 入力されているかどうか。
			// // ※エラーの場合、String：msgParamを宣言し、"有効期間終了日"を代入する。
			// if(ACTextUtilities.isNullText(getKaigoInfoValidLimit2().getText())){
			// getKaigoInfoValidLimit2().requestFocus();
			// msgParam1 = "有効期間終了日";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
			// return false;
			// }

			// ・有効期間終了（kaigoInfoValidLimit2）
			// 入力されている日付が存在するか。
			// ※エラーの場合、String：msgParamを宣言し、"有効期間終了日の"を代入する。
			if (!ACTextUtilities
					.isNullText(getKaigoInfoValidLimit2().getText())) {
				if (!getKaigoInfoValidLimit2().isValidDate()) {
					getKaigoInfoValidLimit2().requestFocus();
					msgParam1 = "有効期間終了日の";
					QkanMessageList.getInstance()
							.ERROR_OF_WRONG_DATE(msgParam1);
					return false;
				}
			}

			// // ・有効期間終了（kaigoInfoValidLimit2）
			// // 月末の日付が入力されているか。
			// // ※エラーの場合、String：msgParam1を宣言し、"終了"を代入する。
			// // ※エラーの場合、String：msgParam2を宣言し、"月末"を代入する。
			// end = getKaigoInfoValidLimit2().getDate();
			// if(ACDateUtilities.compareOnDay(end,
			// ACDateUtilities.toLastDayOfMonth(end)) != 0){
			// getKaigoInfoValidLimit2().requestFocus();
			// msgParam1 = "終了";
			// msgParam2 = "月末";
			// QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD(msgParam1,
			// msgParam2);
			// return false;
			// }

			// ・有効期間開始（kaigoInfoValidLimit1）
			// ・有効期間終了（kaigoInfoValidLimit2）
			// 前後関係のチェック
			// ※エラーの場合、String：msgParam1を宣言し、"有効期間は"を代入する。
			// ※エラーの場合、String：msgParam2を宣言し、"開始日"を代入する。
			// ※エラーの場合、String：msgParam3を宣言し、"終了日"を代入する。
			if (!(ACTextUtilities.isNullText(getKaigoInfoValidLimit1()
					.getText()))
					&& !(ACTextUtilities.isNullText(getKaigoInfoValidLimit2()
							.getText()))) {

				start = getKaigoInfoValidLimit1().getDate();
				end = getKaigoInfoValidLimit2().getDate();

				if (ACDateUtilities.compareOnDay(start, end) > 0) {
					getKaigoInfoValidLimit1().requestFocus();
					msgParam1 = "有効期間は";
					msgParam2 = "開始日";
					msgParam3 = "終了日";
					QkanMessageList.getInstance()
							.ERROR_OF_GREATER_DATE_RELATION(msgParam1,
									msgParam2, msgParam3);
					return false;
				}
			}

			// 同じ公費の有効期間が重複していないかチェックする。
			// ※エラーの場合、String：msgParam1を宣言し、"公費・軽減"を代入する。
			// 画面上のデータを取得する。
			map = new VRHashMap();
			getKaigoInfo().setSource(map);
			getKaigoInfo().applySource();

			// 公費履歴を取得する。
			VRList tempKaigoKohiList = (VRList) getKaigoTableModel()
					.getAdaptee();
			VRList kaigoKohiList = new VRArrayList();

			if (checkMode == CHECK_MODE_INSERT) {
				// 追加モードの場合
				kaigoKohiList = tempKaigoKohiList;
			} else if (checkMode == CHECK_MODE_UPDATE) {
				// 編集モードの場合、自身の履歴は飛ばす。
				for (int i = 0; i < tempKaigoKohiList.size(); i++) {
					if (i == getKaigoInfoTable().getSelectedModelRow()) {
						continue;
					}
					kaigoKohiList.add(tempKaigoKohiList.get(i));
				}
			}

			// 同公費の履歴のうち最新のもののインデックスを取得する（キー：KOHI_TYPE, KOHI_LAW_NO）
			int newHistoryIndex = getIndexNewHistory(ACCastUtilities
					.toInt(VRBindPathParser.get("KOHI_TYPE", map)),
					ACCastUtilities.toString(VRBindPathParser.get(
							"KOHI_LAW_NO", map)), kaigoKohiList);
			int duplicateTermCheckResult = isDuplicateTerm(map, kaigoKohiList,
					newHistoryIndex);

			if (duplicateTermCheckResult == RESULT_TRUE) {
				getKaigoInfoPublicExpense().requestFocus();
				msgParam1 = "公費";
				QkanMessageList.getInstance()
						.QU004_ERROR_OF_DUPLICATE_KOHI_TERM(msgParam1);
				return false;
			}

			// 介護公費情報（kaigoKohiList）の同月内における対象サービスについてチェックする。
			// ※エラーの場合、String：msgParam1を宣言し、"3"を代入する。
			// ※社会福祉軽減に関しては当チェックは行わない。
			kohiType = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_TYPE",
					map));
			if (!doCheckKaigoKohi(checkMode)) {
				// 同月内に、同一の帳票種類のサービスを選択した公費情報が4件以上あった場合
				getKaigoInfoPublicExpense().requestFocus();
				msgParam1 = "3";
				QkanMessageList.getInstance().QU004_ERROR_ON_KOHI_OVER_LIMIT(
						msgParam1);
				return false;
			}

			// 最後の履歴の有効期間終了を変更可能な場合
			if (duplicateTermCheckResult == RESULT_CHANGEABLE) {
				// 確認メッセージを表示する。
				// ・メッセージID：WARNING_OF_DUPLICATE_TERM
				msgParam1 = "公費";
				switch (QkanMessageList.getInstance()
						.WARNING_OF_DUPLICATE_TERM(msgParam1)) {
				case ACMessageBox.RESULT_OK:
					// 「OK」が選択された場合
					// 補正
					changeSpanEnd(map, kaigoKohiList, newHistoryIndex);
					break;
				case ACMessageBox.RESULT_CANCEL:
					// 「キャンセル」が選択された場合
					// エラーが発生したインスタンスにフォーカスを当てる。
					getKaigoInfoValidLimit1().requestFocus();
					// 戻り値としてfalseを返す。
					return false;
				}
			}

		} else if (insureType == INSURE_TYPE_IRYO) {
			// 医療の場合

			// ・公費情報（iryoInfoPublicExpense）
			// 選択されているか。
			// ※エラーの場合、String：msgParamを宣言し、"公費情報"を代入する。
			if (!getIryoInfoPublicExpense().isSelected()) {
				getIryoInfoPublicExpense().requestFocus();
				msgParam1 = "公費情報";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
						msgParam1);
				return false;
			}

			// ・給付率（iryoInfoBenefitRate）
			// 入力されているかどうか。
			// ※エラーの場合、String：msgParamを宣言し、"給付率"を代入する。
			if (ACTextUtilities.isNullText(getIryoInfoBenefitRate().getText())) {
				getIryoInfoBenefitRate().requestFocus();
				msgParam1 = "給付率";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// ・給付率（iryoInfoBenefitRate）
			// 入力されているデータをチェックする。
			benefitRate = ACCastUtilities.toInt(getIryoInfoBenefitRate()
					.getText());

			//
			// 医療公費の下限制限撤廃
			//
			// if (benefitRate <= 90 || benefitRate > 100) {
			if (benefitRate > 100) {
				getIryoInfoBenefitRate().requestFocus();
				msgParam1 = "給付率";
				msgParam2 = "100";
				QkanMessageList.getInstance().ERROR_OF_VALUE_TOO_MUCH(
						msgParam1, msgParam2);
				return false;
			}

			// ・公費法別番号（iryoInfoKohiNo）
			// 入力されているかどうか。
			// ※エラーの場合、String：msgParamを宣言し、"法別番号"を代入する。
			if (ACTextUtilities.isNullText(getIryoInfoKohiNo().getText())) {
				getIryoInfoKohiNo().requestFocus();
				msgParam1 = "法別番号";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// 桁数が2桁かどうか。
			// ※エラーの場合、String：msgParam1を宣言し、"受給者番号"を代入する。
			// ※エラーの場合、String：msgParam2を宣言し、"7"を代入する。
			temp = getIryoInfoKohiNo().getText();
			if (temp.length() != 2) {
				getIryoInfoKohiNo().requestFocus();
				msgParam1 = "法別番号";
				msgParam2 = "2";
				QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
						msgParam2);
				return false;
			}
			
			// ・負担者番号（iryoInfoInsurerNo）
			// 入力されているかどうか。
			// ※エラーの場合、String：msgParamを宣言し、"負担者番号"を代入する。
			if (ACTextUtilities.isNullText(getIryoInfoInsurerNo().getText())) {
				getIryoInfoInsurerNo().requestFocus();
				msgParam1 = "負担者番号";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// ・負担者番号（iryoInfoInsurerNo）
			// 桁数が6桁かどうか。
			// ※エラーの場合、String：msgParam1を宣言し、"負担者番号"を代入する。
			// ※エラーの場合、String：msgParam2を宣言し、"6"を代入する。
			// temp = getIryoInfoInsurerNo().getText();
			// if(temp.length() != 6){
			// getIryoInfoInsurerNo().requestFocus();
			// msgParam1 = "負担者番号";
			// msgParam2 = "6";
			// QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
			// msgParam2);
			// return false;
			// }

			// ・負担者名（iryoInfoBearName）
			// 選択されているか。
			// ※エラーの場合、String：msgParamを宣言し、"負担者名"を代入する。
			// if(!getIryoInfoBearName().isSelected()){
			// getIryoInfoBearName().requestFocus();
			// msgParam1 = "負担者名";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
			// return false;
			// }

			// ・受給者番号（iryoInfoReceiptNo）
			// 入力されているかどうか。
			// ※エラーの場合、String：msgParamを宣言し、"受給者番号"を代入する。
			if (ACTextUtilities.isNullText(getIryoInfoReceiptNo().getText())) {
				getIryoInfoReceiptNo().requestFocus();
				msgParam1 = "受給者番号";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}

			// ・受給者番号（iryoInfoReceiptNo）
			// 桁数が7桁かどうか。
			// ※エラーの場合、String：msgParam1を宣言し、"受給者番号"を代入する。
			// ※エラーの場合、String：msgParam2を宣言し、"7"を代入する。
			temp = getIryoInfoReceiptNo().getText();
			if (temp.length() != 7) {
				getIryoInfoReceiptNo().requestFocus();
				msgParam1 = "受給者番号";
				msgParam2 = "7";
				QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
						msgParam2);
				return false;
			}

			// // ・有効期間開始（iryoInfoValidLimit1）
			// // 入力されているかどうか。
			// // ※エラーの場合、String：msgParamを宣言し、"有効期間開始日"を代入する。
			// if(ACTextUtilities.isNullText(getIryoInfoValidLimit1().getText())){
			// getIryoInfoValidLimit1().requestFocus();
			// msgParam1 = "有効期間開始日";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
			// return false;
			// }

			// ・有効期間開始（iryoInfoValidLimit1）
			// 入力されている日付が存在するか。
			// ※エラーの場合、String：msgParamを宣言し、"有効期間開始日の"を代入する。
			if (!ACTextUtilities.isNullText(getIryoInfoValidLimit1().getText())) {
				if (!getIryoInfoValidLimit1().isValidDate()) {
					getIryoInfoValidLimit1().requestFocus();
					msgParam1 = "有効期間開始日の";
					QkanMessageList.getInstance()
							.ERROR_OF_WRONG_DATE(msgParam1);
					return false;
				}
			}

			// // ・有効期間開始（iryoInfoValidLimit1）
			// // 月初の日付が入力されているか。
			// // ※エラーの場合、String：msgParam1を宣言し、"開始"を代入する。
			// // ※エラーの場合、String：msgParam2を宣言し、"月初"を代入する。
			// start = getIryoInfoValidLimit1().getDate();
			// if(ACDateUtilities.compareOnDay(start,
			// ACDateUtilities.toFirstDayOfMonth(start)) != 0){
			// getIryoInfoValidLimit1().requestFocus();
			// msgParam1 = "開始";
			// msgParam2 = "月初";
			// QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD(msgParam1,
			// msgParam2);
			// return false;
			// }

			// // ・有効期間終了（iryoInfoValidLimit2）
			// // 入力されているかどうか。
			// // ※エラーの場合、String：msgParamを宣言し、"有効期間終了日"を代入する。
			// if(ACTextUtilities.isNullText(getIryoInfoValidLimit2().getText())){
			// getIryoInfoValidLimit2().requestFocus();
			// msgParam1 = "有効期間終了日";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
			// return false;
			// }

			// ・有効期間終了（iryoInfoValidLimit2）
			// 入力されている日付が存在するか。
			// ※エラーの場合、String：msgParamを宣言し、"有効期間終了日の"を代入する。
			if (!ACTextUtilities.isNullText(getIryoInfoValidLimit2().getText())) {
				if (!getIryoInfoValidLimit2().isValidDate()) {
					getIryoInfoValidLimit2().requestFocus();
					msgParam1 = "有効期間終了日の";
					QkanMessageList.getInstance()
							.ERROR_OF_WRONG_DATE(msgParam1);
					return false;
				}
			}

			// // ・有効期間終了（iryoInfoValidLimit2）
			// // 月末の日付が入力されているか。
			// // ※エラーの場合、String：msgParam1を宣言し、"終了"を代入する。
			// // ※エラーの場合、String：msgParam2を宣言し、"月末"を代入する。
			// end = getIryoInfoValidLimit2().getDate();
			// if(ACDateUtilities.compareOnDay(end,
			// ACDateUtilities.toLastDayOfMonth(end)) != 0){
			// getIryoInfoValidLimit2().requestFocus();
			// msgParam1 = "終了";
			// msgParam2 = "月末";
			// QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD(msgParam1,
			// msgParam2);
			// return false;
			// }

			// ・有効期間開始（iryoInfoValidLimit1）
			// ・有効期間終了（iryoInfoValidLimit2）
			// 前後関係が矛盾していないか。
			// ※エラーの場合、String：msgParam1を宣言し、"有効期間は"を代入する。
			// ※エラーの場合、String：msgParam2を宣言し、"開始日"を代入する。
			// ※エラーの場合、String：msgParam3を宣言し、"終了日"を代入する。
			if (!(ACTextUtilities
					.isNullText(getIryoInfoValidLimit1().getText()))
					&& !(ACTextUtilities.isNullText(getIryoInfoValidLimit2()
							.getText()))) {
				start = getIryoInfoValidLimit1().getDate();
				end = getIryoInfoValidLimit2().getDate();

				if (ACDateUtilities.compareOnDay(start, end) > 0) {
					getIryoInfoValidLimit1().requestFocus();
					msgParam1 = "有効期間は";
					msgParam2 = "開始日";
					msgParam3 = "終了日";
					QkanMessageList.getInstance()
							.ERROR_OF_GREATER_DATE_RELATION(msgParam1,
									msgParam2, msgParam3);
					return false;
				}
			}

			// 同じ公費の有効期間が重複していないかチェックする。
			// ※エラーの場合、String：msgParam1を宣言し、"公費"を代入する。
			// 画面上のデータを取得する。
			map = new VRHashMap();
			getIryoInfo().setSource(map);
			getIryoInfo().applySource();

			// 公費履歴を取得する。
			VRList tempIryoKohiList = (VRList) getIryoTableModel().getAdaptee();
			VRList iryoKohiList = new VRArrayList();

			if (checkMode == CHECK_MODE_INSERT) {
				// 追加モードの場合
				iryoKohiList = tempIryoKohiList;
			} else if (checkMode == CHECK_MODE_UPDATE) {
				// 編集モードの場合、自身の履歴は飛ばす。
				for (int i = 0; i < tempIryoKohiList.size(); i++) {
					if (i == getIryoInfoTable().getSelectedModelRow()) {
						continue;
					}
					iryoKohiList.add(tempIryoKohiList.get(i));
				}
			}

			// 同公費の履歴のうち最新のもののインデックスを取得する。（検索キー：KOHI_TYPE, KOHI_LAW_NO）
			int newHistoryIndex = getIndexNewHistory(ACCastUtilities
					.toInt(VRBindPathParser.get("KOHI_TYPE", map)),
					ACCastUtilities.toString(VRBindPathParser.get(
							"KOHI_LAW_NO", map)), iryoKohiList);
			int duplicateTermCheckResult = isDuplicateTerm(map, iryoKohiList,
					newHistoryIndex);

			if (duplicateTermCheckResult == RESULT_TRUE) {
				// 重複している場合
				getIryoInfoPublicExpense().requestFocus();
				msgParam1 = "公費";
				QkanMessageList.getInstance()
						.QU004_ERROR_OF_DUPLICATE_KOHI_TERM(msgParam1);
				return false;
			}

			// 医療公費情報（iryoKohiList）の同月内における対象サービスについてチェックする。
			// ※エラーの場合、String：msgParam1を宣言し、"2件"を代入する。
			if (!doCheckIryoKohi(checkMode)) {
				// 同月内に、同一の帳票種類のサービスを選択した公費情報が3件以上あった場合
				getIryoInfoPublicExpense().requestFocus();
				msgParam1 = "2";
				QkanMessageList.getInstance().QU004_ERROR_ON_KOHI_OVER_LIMIT(
						msgParam1);
				return false;
			}

			// 最後の履歴の有効期間終了を変更可能な場合
			if (duplicateTermCheckResult == RESULT_CHANGEABLE) {
				// 確認メッセージを表示する。
				// ・メッセージID：WARNING_OF_DUPLICATE_TERM
				msgParam1 = "公費";
				switch (QkanMessageList.getInstance()
						.WARNING_OF_DUPLICATE_TERM(msgParam1)) {
				case ACMessageBox.RESULT_OK:
					// 「OK」が選択された場合
					// 補正
					changeSpanEnd(map, iryoKohiList, newHistoryIndex);
					break;
				case ACMessageBox.RESULT_CANCEL:
					// 「キャンセル」が選択された場合
					// エラーが発生したインスタンスにフォーカスを当てる。
					getIryoInfoValidLimit1().requestFocus();
					// 戻り値としてfalseを返す。
					return false;
				}
			}

		} else if (insureType == INSURE_TYPE_SHAHUKU) {

			// ・減額割合（shahukuInfoBenefitRate）
			// 入力されているかどうか。
			// ※エラーの場合、String：msgParamを宣言し、"減額割合"を代入する。
			if (ACTextUtilities.isNullText(getShahukuInfoBenefitRate()
					.getText())) {
				getShahukuInfoBenefitRate().requestFocus();
				msgParam1 = "減額割合";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
			// 減額割合の値のチェック
			double look = ACCastUtilities.toDouble(getShahukuInfoBenefitRate()
					.getText());
			if (look > 100) {
				getShahukuInfoBenefitRate().requestFocus();
				msgParam1 = "減額割合";
				msgParam2 = "100";
				QkanMessageList.getInstance().ERROR_OF_VALUE_TOO_MUCH(
						msgParam1, msgParam2);
				return false;
			}

			// // ・有効期間開始（shahukuInfoValidLimit1）
			// // 入力されているかどうか。
			// // ※エラーの場合、String：msgParamを宣言し、"有効期間開始日"を代入する。
			// if(ACTextUtilities.isNullText(getShahukuInfoValidLimit1().getText())){
			// getShahukuInfoValidLimit1().requestFocus();
			// msgParam1 = "有効期間開始日";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
			// return false;
			// }

			// ・有効期間開始（shahukuInfoValidLimit1）
			// 入力されている日付が存在するか。
			// ※エラーの場合、String：msgParamを宣言し、"有効期間開始日の"を代入する。
			if (!ACTextUtilities.isNullText(getShahukuInfoValidLimit1()
					.getText())) {
				if (!getShahukuInfoValidLimit1().isValidDate()) {
					getShahukuInfoValidLimit1().requestFocus();
					msgParam1 = "有効期間開始日の";
					QkanMessageList.getInstance()
							.ERROR_OF_WRONG_DATE(msgParam1);
					return false;
				}
			}

			// // ・有効期間開始（shahukuInfoValidLimit1）
			// // 月初の日付が入力されているか。
			// // ※エラーの場合、String：msgParam1を宣言し、"開始"を代入する。
			// // ※エラーの場合、String：msgParam2を宣言し、"月初"を代入する。
			// start = getShahukuInfoValidLimit1().getDate();
			// if(ACDateUtilities.compareOnDay(start,
			// ACDateUtilities.toFirstDayOfMonth(start)) != 0){
			// getShahukuInfoValidLimit1().requestFocus();
			// msgParam1 = "開始";
			// msgParam2 = "月初";
			// QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD(msgParam1,
			// msgParam2);
			// return false;
			// }

			// // ・有効期間終了（shahukuInfoValidLimit2）
			// // 入力されているかどうか。
			// // ※エラーの場合、String：msgParamを宣言し、"有効期間終了日"を代入する。
			// if(ACTextUtilities.isNullText(getShahukuInfoValidLimit2().getText())){
			// getShahukuInfoValidLimit2().requestFocus();
			// msgParam1 = "有効期間終了日";
			// QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
			// return false;
			// }

			// ・有効期間終了（shahukuInfoValidLimit2）
			// 入力されている日付が存在するか。
			// ※エラーの場合、String：msgParamを宣言し、"有効期間終了日の"を代入する。
			if (!ACTextUtilities.isNullText(getShahukuInfoValidLimit2()
					.getText())) {
				if (!getShahukuInfoValidLimit2().isValidDate()) {
					getShahukuInfoValidLimit2().requestFocus();
					msgParam1 = "有効期間終了日の";
					QkanMessageList.getInstance()
							.ERROR_OF_WRONG_DATE(msgParam1);
					return false;
				}
			}

			// // ・有効期間終了（shahukuInfoValidLimit2）
			// // 月末の日付が入力されているか。
			// // ※エラーの場合、String：msgParam1を宣言し、"終了"を代入する。
			// // ※エラーの場合、String：msgParam2を宣言し、"月末"を代入する。
			// end = getShahukuInfoValidLimit2().getDate();
			// if(ACDateUtilities.compareOnDay(end,
			// ACDateUtilities.toLastDayOfMonth(end)) != 0){
			// getShahukuInfoValidLimit2().requestFocus();
			// msgParam1 = "終了";
			// msgParam2 = "月末";
			// QkanMessageList.getInstance().ERROR_OF_VALID_PERIOD(msgParam1,
			// msgParam2);
			// return false;
			// }

			// ・有効期間開始（shahukuInfoValidLimit1）
			// ・有効期間終了（shahukuInfoValidLimit2）
			// 前後関係が矛盾していないか。
			// ※エラーの場合、String：msgParam1を宣言し、"有効期間は"を代入する。
			// ※エラーの場合、String：msgParam2を宣言し、"開始日"を代入する。
			// ※エラーの場合、String：msgParam3を宣言し、"終了日"を代入する。
			if (!(ACTextUtilities.isNullText(getShahukuInfoValidLimit1()
					.getText()))
					&& !(ACTextUtilities.isNullText(getShahukuInfoValidLimit2()
							.getText()))) {
				start = getShahukuInfoValidLimit1().getDate();
				end = getShahukuInfoValidLimit2().getDate();

				if (ACDateUtilities.compareOnDay(start, end) > 0) {
					getShahukuInfoValidLimit1().requestFocus();
					msgParam1 = "有効期間は";
					msgParam2 = "開始日";
					msgParam3 = "終了日";
					QkanMessageList.getInstance()
							.ERROR_OF_GREATER_DATE_RELATION(msgParam1,
									msgParam2, msgParam3);
					return false;
				}
			}

			// 有効期間が重複していないかチェックする。
			// ※エラーの場合、String：msgParam1を宣言し、"公費"を代入する。
			// 画面上のデータを取得する。
			map = new VRHashMap();
			getShahukuInfo().setSource(map);
			getShahukuInfo().applySource();

			// KOHI_TYPEを設定する。
			VRBindPathParser.set("KOHI_TYPE", map, new Integer(7701));

			// 社福軽減履歴を取得する。
			VRList tempShahukuKohiList = (VRList) getShahukuTableModel()
					.getAdaptee();
			VRList shahukuKohiList = new VRArrayList();

			if (checkMode == CHECK_MODE_INSERT) {
				// 追加モードの場合
				shahukuKohiList = tempShahukuKohiList;
			} else if (checkMode == CHECK_MODE_UPDATE) {
				// 編集モードの場合、自身の履歴は飛ばす。
				for (int i = 0; i < tempShahukuKohiList.size(); i++) {
					if (i == getShahukuInfoTable().getSelectedModelRow()) {
						continue;
					}
					shahukuKohiList.add(tempShahukuKohiList.get(i));
				}
			}

			// 同公費の履歴のうち最新のもののインデックスを取得する。（検索キー：KOHI_TYPE, KOHI_LAW_NO）
			int newHistoryIndex = getIndexNewHistory(ACCastUtilities
					.toInt(VRBindPathParser.get("KOHI_TYPE", map)),
					ACCastUtilities.toString(VRBindPathParser.get(
							"KOHI_LAW_NO", map)), shahukuKohiList);
			int duplicateTermCheckResult = isDuplicateTerm(map,
					shahukuKohiList, newHistoryIndex);

			if (duplicateTermCheckResult == RESULT_TRUE) {
				// 重複している場合
				getShahukuInfoValidLimit1().requestFocus();
				msgParam1 = "社会福祉軽減";
				QkanMessageList.getInstance()
						.QU004_ERROR_OF_DUPLICATE_KOHI_TERM(msgParam1);
				return false;
			} else if (duplicateTermCheckResult == RESULT_CHANGEABLE) {
				// 最後の履歴の有効期間終了を変更可能な場合
				// 確認メッセージを表示する。
				// ・メッセージID：WARNING_OF_DUPLICATE_TERM
				msgParam1 = "社会福祉軽減";
				switch (QkanMessageList.getInstance()
						.WARNING_OF_DUPLICATE_TERM(msgParam1)) {
				case ACMessageBox.RESULT_OK:
					// 「OK」が選択された場合
					// 補正
					changeSpanEnd(map, shahukuKohiList, newHistoryIndex);
					break;
				case ACMessageBox.RESULT_CANCEL:
					// 「キャンセル」が選択された場合
					// エラーが発生したインスタンスにフォーカスを当てる。
					getShahukuInfoValidLimit1().requestFocus();
					// 戻り値としてfalseを返す。
					return false;
				}
			}
		}

		// 入力エラーがなかった場合
		return true;

	}

	/**
	 * 「介護公費のチェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doCheckKaigoKohi(int checkMode) throws Exception {

		// 介護公費のチェックを行う。
		int maxCount = 3;

		// 既に登録されている公費サービス履歴がない場合
		if (getPatientKohiServiceList() == null
				|| getPatientKohiServiceList().size() == 0) {
			return true;
		}

		// 既に登録されている履歴
		VRList kohiList = (VRList) getKaigoTableModel().getAdaptee();

		if (kohiList == null) {
			return true;
		}

		// 介護公費履歴が4件未満の場合
		if (checkMode == CHECK_MODE_INSERT) {
			if (kohiList.size() < 3) {
				return true;
			}
		} else if (checkMode == CHECK_MODE_UPDATE) {
			if (kohiList.size() <= 3) {
				return true;
			}
		}

		// 介護公費履歴が4件以上の場合

		// 入力されている有効期間開始
		Date targetStart;
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit1().getText())) {
			targetStart = MIN_DATE;
		} else {
			targetStart = getKaigoInfoValidLimit1().getDate();
		}

		// 入力されている有効期間終了
		Date targetEnd;
		if (ACTextUtilities.isNullText(getKaigoInfoValidLimit2().getText())) {
			targetEnd = MAX_DATE;
		} else {
			targetEnd = getKaigoInfoValidLimit2().getDate();
		}

		// 選択公費の対象サービス
		VRList targetService = (VRList) getKaigoServiceTableModel()
				.getAdaptee();

		// 対象サービスより選択されているサービスを取得する。
		VRList selectedService = new VRArrayList();
		if (targetService != null) {
			for (int i = 0; i < targetService.size(); i++) {
				VRMap map = (VRMap) targetService.get(i);
				if (ACCastUtilities.toBoolean(VRBindPathParser.get(
						"CHECK_VALUE", map))) {
					selectedService.add(map);
				}
			}
		} else {
			return false;
		}

		// 選択サービスがない場合
		if (selectedService == null || selectedService.size() == 0) {
			return true;
		}

		// 選択サービスの帳票様式一覧を取得する。
		VRList claimStyles = getClaimStyles(selectedService);

		// すでに登録されている公費
		ArrayList reservedKohi = new ArrayList();
		VRList tempList = (VRList) getKaigoTableModel().getAdaptee();
		int selectedRow = getKaigoInfoTable().getSelectedModelRow();
		for (int i = 0; i < tempList.size(); i++) {
			if (checkMode == CHECK_MODE_UPDATE) {
				if (i == selectedRow) {
					// 更新モードの場合、自身の履歴はスキップする。
					continue;
				}
			}
			reservedKohi.add(((VRMap) tempList.get(i)).clone());
		}

		// 公費ID
		int kohiId = -1;
		if (checkMode == CHECK_MODE_UPDATE) {
			VRMap temp = (VRMap) tempList.get(selectedRow);
			kohiId = ACCastUtilities.toInt(VRBindPathParser
					.get("KOHI_ID", temp));
		}

		// 様式分チェック
		for (int i = 0; i < claimStyles.size(); i++) {
			int claimStyle = ACCastUtilities.toInt(claimStyles.get(i));
			if (!checkKohiRange(getKohi(reservedKohi, claimStyle), kohiId,
					targetStart, targetEnd, maxCount)) {
				// 限界突破
				return false;
			}
		}

		// // 有効期間開始を1日に変換
		// targetStart = ACDateUtilities.toFirstDayOfMonth(targetStart);
		//
		// // 入力された期間を1月ごとに比較していく。
		// while (ACDateUtilities.compareOnDay(targetStart, targetEnd) <= 0) {
		//
		// VRList list = new VRArrayList();
		//
		// // 登録されている履歴より、年月単位で重複している履歴を抽出。
		// for (int i = 0; i < kohiList.size(); i++) {
		//
		// // 編集モードの場合、自身の履歴は飛ばす。
		// if (checkMode == CHECK_MODE_UPDATE) {
		// if (i == getKaigoInfoTable().getSelectedModelRow()) {
		// continue;
		// }
		// }
		//
		// VRMap temp = (VRMap) kohiList.get(i);
		// Date paraStart = ACCastUtilities.toDate(VRBindPathParser.get(
		// "KOHI_VALID_START", temp));
		// Date paraEnd = ACCastUtilities.toDate(VRBindPathParser.get(
		// "KOHI_VALID_END", temp));
		// if (isDuplicateOnMonth(targetStart, paraStart, paraEnd)) {
		// // 抽出
		// list.add(temp);
		// }
		// }
		//
		// // 選択サービスと抽出した履歴の帳票種類を比較する。
		// if (!isValidKohiService(selectedService, list, INSURE_TYPE_KAIGO)) {
		// return false;
		// }
		//
		// // 1月加算
		// targetStart = ACDateUtilities.addMonth(targetStart, 1);
		// }

		return true;
	}

	/**
	 * 「医療公費のチェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doCheckIryoKohi(int checkMode) throws Exception {

		// 医療公費のチェックを行う。
		// 登録許可件数
		int maxCount = 2;

		// 既に登録されている公費サービス履歴がない場合
		if (getPatientKohiServiceList() == null
				|| getPatientKohiServiceList().size() == 0) {
			return true;
		}

		// 既に登録されている履歴
		VRList kohiList = (VRList) getIryoTableModel().getAdaptee();

		if (kohiList == null) {
			return true;
		}

		// 医療公費履歴が3件未満の場合
		if (checkMode == CHECK_MODE_INSERT) {
			if (kohiList.size() < 2) {
				return true;
			}
		} else if (checkMode == CHECK_MODE_UPDATE) {
			// 編集モードの場合は自身の履歴も含めて2件までOK
			if (kohiList.size() <= 2) {
				return true;
			}
		}

		// 医療公費履歴が3件以上の場合

		// 入力されている有効期間開始
		Date targetStart;
		if (ACTextUtilities.isNullText(getIryoInfoValidLimit1().getText())) {
			targetStart = MIN_DATE;
		} else {
			targetStart = getIryoInfoValidLimit1().getDate();
		}

		// 入力されている有効期間終了
		Date targetEnd;
		if (ACTextUtilities.isNullText(getIryoInfoValidLimit2().getText())) {
			targetEnd = MAX_DATE;
		} else {
			targetEnd = getIryoInfoValidLimit2().getDate();
		}

		// 選択公費の対象サービス
		VRList targetService = (VRList) getIryoServiceTableModel().getAdaptee();

		// 対象サービスより選択されているサービスを取得する。
		VRList selectedService = new VRArrayList();
		if (targetService != null) {
			for (int i = 0; i < targetService.size(); i++) {
				VRMap map = (VRMap) targetService.get(i);
				if (ACCastUtilities.toBoolean(VRBindPathParser.get(
						"CHECK_VALUE", map))) {
					selectedService.add(map);
				}
			}
		} else {
			return false;
		}

		// 選択サービスがない場合
		if (selectedService == null || selectedService.size() == 0) {
			return true;
		}

		// 選択サービスの帳票様式一覧を取得する。
		VRList claimStyles = getClaimStyles(selectedService);

		// すでに登録されている公費
		ArrayList reservedKohi = new ArrayList();
		VRList tempList = ((VRList) getIryoTableModel().getAdaptee());
		int selectedRow = getIryoInfoTable().getSelectedModelRow();
		for (int i = 0; i < tempList.size(); i++) {
			if (checkMode == CHECK_MODE_UPDATE) {
				if (i == selectedRow) {
					// 更新モードの場合、自身の履歴はスキップする。
					continue;
				}
			}
			reservedKohi.add(((VRMap) tempList.get(i)).clone());
		}

		// 公費ID
		int kohiId = -1;
		if (checkMode == CHECK_MODE_UPDATE) {
			VRMap temp = (VRMap) tempList.get(selectedRow);
			kohiId = ACCastUtilities.toInt(VRBindPathParser
					.get("KOHI_ID", temp));
		}

		// 様式分チェック
		for (int i = 0; i < claimStyles.size(); i++) {
			int claimStyle = ACCastUtilities.toInt(claimStyles.get(i));
			if (!checkKohiRange(getKohi(reservedKohi, claimStyle), kohiId,
					targetStart, targetEnd, maxCount)) {
				// 限界突破
				return false;
			}
		}

		// // 有効期間開始を1日に変換
		// targetStart = ACDateUtilities.toFirstDayOfMonth(targetStart);
		//
		// // 入力された期間を1月ごとに比較していく。
		// while (ACDateUtilities.compareOnDay(targetStart, targetEnd) <= 0) {
		//
		// VRList list = new VRArrayList();
		//
		// // 登録されている履歴より、年月単位で重複している履歴を抽出。
		// for (int i = 0; i < kohiList.size(); i++) {
		//
		// // 編集モードの場合、自身の履歴は飛ばす。
		// if (checkMode == CHECK_MODE_UPDATE) {
		// if (i == getIryoInfoTable().getSelectedModelRow()) {
		// continue;
		// }
		// }
		//
		// VRMap temp = (VRMap) kohiList.get(i);
		// Date paraStart = ACCastUtilities.toDate(VRBindPathParser.get(
		// "KOHI_VALID_START", temp));
		// Date paraEnd = ACCastUtilities.toDate(VRBindPathParser.get(
		// "KOHI_VALID_END", temp));
		// if (isDuplicateOnMonth(targetStart, paraStart, paraEnd)) {
		// // 抽出
		// list.add(temp);
		// }
		// }
		//
		// // 選択サービスと抽出した履歴の帳票種類を比較する。
		// if (!isValidKohiService(selectedService, list, INSURE_TYPE_IRYO)) {
		// return false;
		// }
		//
		// // 1月加算
		// targetStart = ACDateUtilities.addMonth(targetStart, 1);
		// }

		return true;
	}

	/**
	 * 帳票様式のリストを返します。
	 * 
	 * @param serviceList
	 *            サービスのリスト
	 * @throws Exception
	 *             処理例外
	 */
	public VRList getClaimStyles(VRList serviceList) throws Exception {

		// 選択公費の帳票様式を配列化
		VRList claimStyles = new VRArrayList();
		for (int i = 0; i < serviceList.size(); i++) {
			VRMap service = (VRMap) serviceList.get(i);
			int claimStyle = ACCastUtilities.toInt(VRBindPathParser.get(
					"CLAIM_STYLE_TYPE", service));
			int count = 0;
			for (int j = 0; j < claimStyles.size(); j++) {
				int tempStyle = ACCastUtilities.toInt(claimStyles.get(count));
				if (claimStyle == tempStyle) {
					count++;
					break;
				}
			}
			if (count == 0) {
				claimStyles.add(new Integer(claimStyle));
			}
		}

		return claimStyles;
	}

	/**
	 * 「保存処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doSave() throws Exception {

		// 保存処理を行う。

		try {

			// トランザクション開始
			getDBManager().beginTransaction();

			// パッシブチェックのタスクをクリアする。
			getPassiveChecker().clearPassiveTask();

			// パッシブチェックのタスクを追加する。
			// ※KEY：PASSIVE_CHECK_KEY
			getPassiveChecker().addPassiveUpdateTask(getPASSIVE_CHECK_KEY(), 0);

			// パッシブチェックを行う。
			if (!getPassiveChecker().passiveCheck(getDBManager())) {
				// パッシブエラーが発生した場合
				// エラーメッセージを表示する。
				// ・メッセージID：ERROR_OF_PASSIVE_CHECK_ON_UPDATE
				QkanMessageList.getInstance()
						.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();

				// トランザクション解除
				getDBManager().rollbackTransaction();
				// 終了
				return false;
			}

			// SQL文取得用
			VRMap param = null;
			String strSql = "";

			// 利用者公費情報テーブル（PATIENT_KOHI）の更新処理
			// 全件削除
			if (getKohiDataFlg() == 1) {
				// kohiDataFlgの値が1の場合

				// SQL文取得のためのHashMap：paramを生成し、以下のKEY/VALUEを設定する。
				// KEY：PATIENT_ID VALUE：patientId
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// SQL文取得、実行
				strSql = getSQL_DELETE_PATIENT_KOHI(param);
				getDBManager().executeUpdate(strSql);

			}

			// 登録
			if (!(getPatientKohiList() == null || getPatientKohiList().size() == 0)) {
				for (int i = 0; i < getPatientKohiList().size(); i++) {
					// パラメータ設定
					param = new VRHashMap();
					param = (VRMap) getPatientKohiList().get(i);

					// SQL文取得、実行
					strSql = getSQL_INSERT_PATIENT_KOHI(param);
					getDBManager().executeUpdate(strSql);
				}
			}

			// 利用者公費サービス情報テーブル（PATIENT_KOHI_SERVICE）の更新処理
			// 全件削除
			if (getKohiServiceDataFlg() == 1) {
				// kohiServiceDataFlgの値が1の場合

				// SQL文取得のためのHashMap：paramを生成し、以下のKEY/VALUEを設定する。
				// KEY：PATIENT_ID VALUE：patientId
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// SQL文取得、実行
				strSql = getSQL_DELETE_PATIENT_KOHI_SERVICE(param);
				getDBManager().executeUpdate(strSql);
			}

			// 登録
			if (!(getPatientKohiServiceList() == null || getPatientKohiServiceList()
					.size() == 0)) {
				for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
					// パラメータ設定
					param = new VRHashMap();
					param = (VRMap) getPatientKohiServiceList().get(i);

					// SQL文取得、実行
					strSql = getSQL_INSERT_PATIENT_KOHI_SERVICE(param);
					getDBManager().executeUpdate(strSql);
				}
			}

			// 利用者基本情報TBLの最終更新日時を更新する。
			param = new VRHashMap();
			VRBindPathParser.set("PATIENT_ID", param, new Integer(
					getPatientId()));
			strSql = getSQL_UPDATE_PATIENT_LAST_TIME(param);
			getDBManager().executeUpdate(strSql);

			// コミット/ロールバック
			// 上記のSQL発行処理に成功した場合
			// DB処理をコミットする。
			getDBManager().commitTransaction();

		} catch (Exception ex) {
			// 上記のSQL発行処理に失敗した場合
			// ロールバックする。
			getDBManager().rollbackTransaction();
			// 例外を投げる。
			throw ex;
		}

		// 下記の変更フラグを初期化する。
		// ・kaigoTableChangeFlg
		// ・iryoTableChangeFlg
		// ・kohiDataFlg
		// ・kohiServiceDataFlg
		setKaigoTableChangeFlg(0);
		setIryoTableChangeFlg(0);
		setShahukuTableChangeFlg(0);
		setKohiDataFlg(0);
		setKohiServiceDataFlg(0);

		return true;

	}

	/**
	 * 「利用者公費サービス情報展開」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void setPatientKohiService(int kohiId, int insureType)
			throws Exception {

		// 利用者公費サービス情報を画面に展開する。
		VRList list = new VRArrayList();

		if (insureType == INSURE_TYPE_KAIGO) {
			// 介護公費（insureType == INSURE_TYPE_KAIGO）の場合
			// kaigoServiceTableModelにセットされているレコード集合を取得する。
			list = (VRList) getKaigoServiceTableModel().getAdaptee();
		} else if (insureType == INSURE_TYPE_IRYO) {
			// 医療公費（insureType == INSURE_TYPE_IRYO）の場合
			// iryoServiceTableModelにセットされているレコード集合を取得する。
			list = (VRList) getIryoServiceTableModel().getAdaptee();
		} else {
			// 社会福祉軽減（insureType == INSURE_TYPE_SHAHUKU）の場合
			// shahukuServiceTableModelにセットされているレコード集合を取得する。
			list = (VRList) getShahukuServiceTableModel().getAdaptee();
		}

		if (list == null) {
			return;
		}

		// listの件数分ループする。
		// ※以下、listのレコードをmapとする。
		for (int i = 0; i < list.size(); i++) {

			VRMap map = (VRMap) list.get(i);

			// mapのSYSTEM_SERVICE_KIND_DETAILを取得する。（以下、systemServiceKindDetailとする。）
			int systemServiceKindDetail = ACCastUtilities
					.toInt(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
							map));

			// patientKohiServiceListに以下のKEY/VALUEが一致するレコードがあるかチェックする。
			// ・KEY：KOHI_ID VALUE：kohiId
			// ・KEY：SYSTEM_SERVICE_KIND_DETAIL VALUE：systemServiceKindDetail
			if (doCheckUseService(kohiId, systemServiceKindDetail)) {
				// // 一致するレコードがあった場合（戻り値がtrueの場合）
				// // mapに以下のKEY/VALUE設定する。
				// // ・KEY：CHECK_VALUE VALUE：TRUE
				VRBindPathParser.set("CHECK_VALUE", map, new Boolean(true));
			} else {
				// // 一致するレコードがなかった場合（戻り値がfalseの場合）
				// // mapに以下のKEY/VALUE設定する。
				// // ・KEY：CHECK_VALUE VALUE：FALSE
				VRBindPathParser.set("CHECK_VALUE", map, new Boolean(false));
			}

			// listに戻す。
			list.set(i, map);

		}

		// テーブルモデルに再び設定する。
		if (insureType == INSURE_TYPE_KAIGO) {
			// 介護公費（insureType == INSURE_TYPE_KAIGO）の場合
			// kaigoServiceTableModelにセットされているレコード集合を取得する。
			getKaigoServiceTableModel().setAdaptee(list);
		} else if (insureType == INSURE_TYPE_IRYO) {
			// 医療公費（insureType == INSURE_TYPE_IRYO）の場合
			// iryoServiceTableModelにセットされているレコード集合を取得する。
			getIryoServiceTableModel().setAdaptee(list);
		} else {
			// 社会福祉軽減（insureType == INSURE_TYPE_SHAHUKU）の場合
			// shahukuServiceTableModelにセットされているレコード集合を取得する。
			getShahukuServiceTableModel().setAdaptee(list);
		}

	}

	/**
	 * 「給付対象のサービスの判定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doCheckUseService(int kohiId, int systemServiceKindDetail)
			throws Exception {

		// 給付対象サービスとして指定されているサービスか判定する。

		if (getPatientKohiServiceList() == null) {
			return false;
		}

		// patientKohiServiceListの件数分ループする。
		for (int i = 0; i < getPatientKohiServiceList().size(); i++) {

			VRMap map = (VRMap) getPatientKohiServiceList().get(i);

			// 以下のKEY/VALUEが一致するレコードの場合
			// ・KEY：KOHI_ID VALUE：kohiId
			// ・KEY：SYSTEM_SERVICE_KIND_DETAIL VALUE：systemServiceKindDetail
			// 戻り値としてtrueを返す。
			if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID", map)) == kohiId
					&& ACCastUtilities.toInt(VRBindPathParser.get(
							"SYSTEM_SERVICE_KIND_DETAIL", map)) == systemServiceKindDetail) {
				return true;
			}

		}

		// 一致するレコードがなく、ループを抜けた場合
		// 戻り値としてfalseを返す。
		return false;

	}

	/**
	 * 「利用者公費サービス情報を画面より取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public VRList getPatientKohiService(int kohiId, int insureType)
			throws Exception {
		// 利用者公費サービス情報を画面より取得する。

		// 戻り値用のArrayList：listを生成する。
		VRList list = new VRArrayList();

		VRList serviceList = new VRArrayList();

		if (insureType == INSURE_TYPE_KAIGO) {
			// insureTypeの値がINSURE_TYPE_KAIGOの場合
			// kaigoServiceTableModelにセットしているレコード集合を取得する。
			serviceList = (VRList) getKaigoServiceTableModel().getAdaptee();
		} else if (insureType == INSURE_TYPE_IRYO) {
			// insureTypeの値がINSURE_TYPE_IRYOの場合
			// iryoServiceTableModelにセットしているレコード集合を取得する。
			serviceList = (VRList) getIryoServiceTableModel().getAdaptee();
		} else {
			// insureTypeの値がINSURE_TYPE_SHAHUKUの場合
			// shahukuServiceTableModelにセットしているレコード集合を取得する。
			serviceList = (VRList) getShahukuServiceTableModel().getAdaptee();
		}

		// ServiceListの件数分ループする。
		for (int i = 0; i < serviceList.size(); i++) {
			VRMap temp = (VRMap) serviceList.get(i);
			// tempのKEY：CHECK_VALUEのVALUEがtrueの場合
			if (ACCastUtilities.toBoolean(VRBindPathParser.get("CHECK_VALUE",
					temp))) {
				// tempのKEY：SYSTEM_SERVICE_KIND_DETAILのVALUEを取得する。
				int systemServiceKindDetail = ACCastUtilities
						.toInt(VRBindPathParser.get(
								"SYSTEM_SERVICE_KIND_DETAIL", temp));

				// VRMap mapを生成し、以下のKEY/VALUEを設定する。
				// ・KEY：PATIENT_ID VALUE：patientId
				// ・KEY：KOHI_ID VALUE：kohiId
				// ・KEY：SYSTEM_SERVICE_KIND_DETAIL VALUE：systemServiceKindDetail
				// mapをlistに追加する。
				VRMap map = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", map, new Integer(
						getPatientId()));
				VRBindPathParser.set("KOHI_ID", map, new Integer(kohiId));
				VRBindPathParser.set("SYSTEM_SERVICE_KIND_DETAIL", map,
						new Integer(systemServiceKindDetail));

				list.add(map);
			}
		}

		// 戻り値としてlistを返す。
		return list;

	}

	/**
	 * 「画面初期化」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void initialize() throws Exception {
		// 画面の初期化処理。

		// 業務情報マスタより、データを取得する。
		// 取得したデータのウィンドウタイトル（WINDOW_TITLE）をウィンドウに設定する。
		// 取得したデータの業務タイトル（AFFAIR_TITLE）を業務ボタンバーに設定する。
		setAffairTitle(AFFAIR_ID, getButtons());

		// パッシブキーの定義
		setPASSIVE_CHECK_KEY(new ACPassiveKey("PATIENT",
				new String[] { "PATIENT_ID" }, new Format[] { null },
				"LAST_TIME", "LAST_TIME"));

		// テーブルモデルの生成
		ACTableModelAdapter model = null;

		// kaigoTableModelを生成し、以下のカラムで設定する。
		// "KOHI_ABBREVIATION" "KOHI_PAYER_NO" "KOHI_PAYER_NAME"
		// "KOHI_RECIPIENT_NO" "KOHI_VALID_START"
		// "PATIENT_KOHI.KOHI_VALID_END"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "KOHI_NAME", "BENEFIT_RATE",
				"KOHI_LAW_NO+''+INSURER_ID", "KOHI_PAYER_NAME",
				"KOHI_RECIPIENT_NO", "KOHI_VALID_START", "KOHI_VALID_END" });

		setKaigoTableModel(model);

		// 介護公費テーブル（kaigoInfoTable）にセットする。
		getKaigoInfoTable().setModel(getKaigoTableModel());

		// iryoTableModelを生成し、以下のカラムで設定する。
		// "KOHI_ABBREVIATION" "KOHI_PAYER_NO" "KOHI_PAYER_NAME"
		// "KOHI_RECIPIENT_NO" "KOHI_VALID_START"
		// "KOHI_VALID_END"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "KOHI_NAME", "BENEFIT_RATE",
				"KOHI_LAW_NO+''+INSURER_ID", "KOHI_PAYER_NAME",
				"KOHI_RECIPIENT_NO", "KOHI_VALID_START", "KOHI_VALID_END" });

		setIryoTableModel(model);

		// 医療公費テーブル（iryoInfoTable）にセットする。
		getIryoInfoTable().setModel(getIryoTableModel());

		// shahukuableModelを生成し、以下のカラムで設定する。
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "LOOK", "KOHI_VALID_START",
				"KOHI_VALID_END" });

		setShahukuTableModel(model);

		// 社会福祉軽減テーブル（shahukuInfoTable）にセットする。
		getShahukuInfoTable().setModel(getShahukuTableModel());

		// kaigoServiceTableModelを生成し、以下のカラムで設定する。
		// "CHECK_VALUE" "SERVICE_ABBREVIATION" "CLAIM_STYLE_TYPE"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "CHECK_VALUE", "SERVICE_ABBREVIATION",
				"CLAIM_STYLE_TYPE" });

		setKaigoServiceTableModel(model);

		// 介護公費使用サービステーブル（kaigoInfoServiceTable）にセットする。
		getKaigoInfoServiceTable().setModel(getKaigoServiceTableModel());

		// iryoServiceTableModelを生成し、以下のカラムで設定する。
		// "CHECK_VALUE" "SERVICE_ABBREVIATION" "CLAIM_STYLE_TYPE"
		model = new ACTableModelAdapter();
		model.setColumns(new String[] { "CHECK_VALUE", "SERVICE_ABBREVIATION",
				"CLAIM_STYLE_TYPE" });

		setIryoServiceTableModel(model);

		// shahukuServiceTableModelを生成する。
		model = new ACTableModelAdapter();
		setShahukuServiceTableModel(model);

		// スナップショットの撮影対象指定
		getSnapShotKaigo().setRootContainer(getPoints1());
		getSnapShotIryo().setRootContainer(getPoints2());
		getSnapShotShahuku().setRootContainer(getPoints3());

		// 医療公費使用サービステーブル（iryoInfoServiceTable）にセットする。
		getIryoInfoServiceTable().setModel(getIryoServiceTableModel());

		// フォーマッタの設定
		// // 公費種類(介護)
		// getKaigoInfoTableColumn1().setFormat(new QkanKaigoKohiFormat());

		// 帳票種類(介護)
		getKaigoInfoServiceTableColumn3().setFormat(new QkanClaimStyleFormat());

		// // 公費種類(医療)
		// getIryoInfoTableColumn1().setFormat(new QkanIryoKohiFormat());

		// 帳票種類(医療)
		getIryoInfoServiceTableColumn3().setFormat(
				new ACHashMapFormat(new String[] { "訪問看護療養費明細書" },
						new Integer[] { new Integer(20101) }));

		//医療系非表示対応 fujihara.shin 2009.1.13 add start
		if (!QkanCommon.isShowOldIryo()){
			setState_OLD_IRYO_OFF();
		}
		//医療系非表示対応 fujihara.shin 2009.1.13 add enf
		
		// 画面設定
		casualInitialize();

	}

	/**
	 * 「画面設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void casualInitialize() throws Exception {
		// 画面の設定を行う。

		// VRMap mapを生成する。画面設定用
		VRMap map = new VRHashMap();

		// SQL文取得用
		VRMap param = new VRHashMap();

		// SQL文格納用
		String strSql = "";

		// 下記の情報を取得し、mapに設定する。
		// ・公費マスタ情報取得
		// 公費マスタ情報を取得し、masterKohiListに格納する。
		// VRBindPathParser.set("SYSTEM_DATE", param,
		// QkanSystemInformation.getInstance().getSystemDate());

		strSql = getSQL_GET_MASTER_KOHI(param);
		setMasterKohiList(getDBManager().executeQuery(strSql));

		// ・介護公費情報、医療公費情報取得
		// ArrayList masterKaigoKohiListを生成する。
		VRList masterKaigokohiList = new VRArrayList();

		// ArrayList masterIryoKohiListを生成する。
		VRList masterIryoKohiList = new VRArrayList();

		
		/* 2007-04-05 結核予防法対応 change start kamitsukasa */
		/* 設定・変更メンテナンスで設定された値（ScreenConfig/ShowOldKohi）により
		 * システム日付において無効な公費の表示（1）・非表示（0）を切り替える */
		
		// ScreenConfig/ShowOldKohiの取得(デフォルト：0)
		int showOldKohi = 0;
		if(ACFrame.getInstance().hasProperty("ScreenConfig/ShowOldKohi")){
			showOldKohi = ACCastUtilities.toInt(getProperty("ScreenConfig/ShowOldKohi"), 0);
		}
		// システム日付の取得
		Date systemDate = QkanSystemInformation.getInstance().getSystemDate();
		
		// masterKohiListの件数分ループする。
		for (int i = 0; i < getMasterKohiList().size(); i++) {

			VRMap temp = (VRMap) getMasterKohiList().get(i);
			if(!canShowKohi(temp, systemDate, showOldKohi)){
				// 表示可能ではない公費である場合
				continue;
			}
			if (ACCastUtilities
					.toInt(VRBindPathParser.get("INSURE_TYPE", temp)) == INSURE_TYPE_KAIGO) {
				// INSURE_TYPEの値がINSURE_TYPE_KAIGOの場合
				// レコードをmasterKaigoKohiListに追加する。
				masterKaigokohiList.add(temp);
			} else if (ACCastUtilities.toInt(VRBindPathParser.get(
					"INSURE_TYPE", temp)) == INSURE_TYPE_IRYO) {
				// masterKohiListよりINSURE_TYPEの値がINSURE_TYPE_IRYOの場合
				// レコードをmasterIryoKohiListに追加する。
				masterIryoKohiList.add(temp);
			}
		}

		/* 2007-04-05 結核予防法対応 change end kamitsukasa */

		
		// masterKaigokohiListをmapにKEY：KAIGO_KOHIで設定する。
		// masterIryoKohiListをmapにKEY：IRYO_KOHIで設定する。
		VRBindPathParser.set("KAIGO_KOHI", map, masterKaigokohiList);
		VRBindPathParser.set("IRYO_KOHI", map, masterIryoKohiList);

		// ・負担者（保険者）情報
		// 保険者情報を取得し、insurerListに格納する。
		setInsurerList(QkanCommon.getInsurerInfo(getDBManager()));

		// mapにKEY：KOHI_PAYER_NAMEで設定する。
		VRBindPathParser.set("KOHI_PAYER_NAME", map, getInsurerList());

		// mapを「クライアント領域（contents）」に設定する。
		getContents().setModelSource(map);

		// 画面にデータを展開する。
		getContents().bindModelSource();

		// DB（M_KOHI_SERVICE）より公費サービスマスタ情報を取得する。
		// 公費マスタサービス情報を取得し、masterKohiServiceListに格納する。
		strSql = getSQL_GET_MASTER_KOHI_SERVICE(null);
		setMasterKohiServiceList(getDBManager().executeQuery(strSql));

		// サービスマスタデータを取得し、masterServceに格納する。
		setMasterService(QkanCommon.getMasterService(getDBManager()));

		// 社会福祉軽減のみ固定のため、サービスマスタデータを先にセットしておく。
		doFindTargetService(TYPE_SHAHUKU, INSURE_TYPE_SHAHUKU);

	}

	/**
	 * 「データ編集」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @param VRMap
	 *            編集前データ
	 * @return VRMap 編集後データ
	 */
	public VRMap toKohiTableList(VRMap map) throws Exception {

		// テーブル表示用にデータを編集する。

		VRMap temp = null;

		// 渡されたレコードのINSURER_IDの値で、insurerListの
		// INSURER_IDを検索する。
		temp = new VRHashMap();
		temp = ACBindUtilities.getMatchRowFromValue(getInsurerList(),
				"INSURER_ID", VRBindPathParser.get("INSURER_ID", map));

		if (temp != null) {
			// 該当する保険者情報があった場合
			// 該当する保険者情報のINSURER_NAMEを渡されたレコードに
			// KEY：KOHI_PAYER_NAMEで追加する。
			VRBindPathParser.set("KOHI_PAYER_NAME", map, VRBindPathParser.get(
					"INSURER_NAME", temp));
		}

		// 公費名称の追加
		temp = new VRHashMap();
		temp = ACBindUtilities.getMatchRowFromValue(getMasterKohiList(),
				"KOHI_TYPE", VRBindPathParser.get("KOHI_TYPE", map));

		if (temp != null) {
			VRBindPathParser.set("KOHI_NAME", map, VRBindPathParser.get(
					"KOHI_NAME", temp));
		}
		return map;

	}

	/**
	 * 「データ編集」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @param VRList
	 *            編集前データ集合
	 * @return VRList 編集後データ集合
	 */
	public VRList toKohiTableList(VRList list) throws Exception {

		// テーブル表示用にデータを編集する。

		if (list == null) {
			// 渡されたデータがnullの場合
			// 戻り値としてnullを返す。
			return null;
		} else {
			// 渡されたデータの件数分ループする。
			for (int i = 0; i < list.size(); i++) {
				// レコードを編集する。
				toKohiTableList((VRMap) list.get(i));
			}
		}

		return list;
	}

	/**
	 * 「データ編集」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @param VRMap
	 *            編集前データ
	 * @return VRMap 編集後データ
	 */
	public VRMap toShahukuTableList(VRMap map, String mode) throws Exception {

		// テーブル表示用にデータを編集する。

		NumberFormat nf = new DecimalFormat("0.0");

		if ("FROM_DB".equals(mode)) {
			// DBからのデータの場合
			double look = ACCastUtilities.toDouble(VRBindPathParser.get(
					"BENEFIT_RATE", map)) / 10;

			// 小数点の形式に成形し、セット
			VRBindPathParser.set("LOOK", map, new Double(nf.format(look)));

		} else if ("FROM_INPUT".equals(mode)) {
			// ユーザ入力のデータの場合
			double look = ACCastUtilities.toDouble(VRBindPathParser.get("LOOK",
					map));

			// DB登録用に成形し、セット
			VRBindPathParser.set("LOOK", map, new Double(nf.format(look)));
			VRBindPathParser.set("BENEFIT_RATE", map, ACCastUtilities
					.toString((look * 10)));
		}

		return map;
	}

	/**
	 * 「データ編集」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @param VRList
	 *            編集前データ集合
	 * @return VRList 編集後データ集合
	 */
	public VRList toShahukuTableList(VRList list, String mode) throws Exception {

		// テーブル表示用にデータを編集する。

		if (list == null) {
			// 渡されたデータがnullの場合
			// 戻り値としてnullを返す。
			return null;
		} else {
			// 渡されたデータの件数分ループする。
			for (int i = 0; i < list.size(); i++) {
				// レコードを編集する。
				toShahukuTableList((VRMap) list.get(i), mode);
			}
		}

		return list;
	}

	/**
	 * 「各保険のデータ取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @param 編集前データ集合
	 * @return 編集後データ集合
	 */
	public VRList getListToSetTable(VRList list, int insureType)
			throws Exception {

		// 戻り値用のVRListを生成
		VRList result = new VRArrayList();

		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				VRMap map = (VRMap) list.get(i);
				if (ACCastUtilities.toInt(VRBindPathParser.get("INSURE_TYPE",
						map)) == insureType) {
					result.add(map);
				}
			}
		}
		return result;

	}

	/**
	 * 「年月比較」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @param Date
	 *            比較元の日付
	 * @param Date
	 *            比較先期間の開始日
	 * @param Date
	 *            比較先期間の終了日
	 * @return boolean 重なる場合true 重ならない場合false
	 */
	public boolean isDuplicateOnMonth(Date target, Date paraStart, Date paraEnd)
			throws Exception {

		// targetが渡された期間と、年月単位で重複しているかをチェックする関数。

		// 引数の開始を1日に変換
		Date start = ACDateUtilities.toFirstDayOfMonth(paraStart);
		// 引数の終了を末日に変換
		Date end = ACDateUtilities.toLastDayOfMonth(paraEnd);

		if (ACDateUtilities.compareOnDay(target, start) >= 0
				&& ACDateUtilities.compareOnDay(target, end) <= 0) {

			return true;

		}

		return false;
	}

	/**
	 * 「公費対象選択サービス判定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @param VRList
	 *            選択されたサービス（比較元）
	 * @param VRList
	 *            登録されている公費履歴
	 * @param int
	 *            保険種類
	 * @return boolean 矛盾する場合false
	 */
	public boolean isValidKohiService(VRList selectedService, VRList reserved,
			int insureType) throws Exception {

		// 選択サービスを一件ずつ判定していく。
		for (int i = 0; i < selectedService.size(); i++) {
			// 選択サービスレコード
			VRMap map = (VRMap) selectedService.get(i);
			// 選択サービスの帳票種類
			int claimStyle = ACCastUtilities.toInt(VRBindPathParser.get(
					"CLAIM_STYLE_TYPE", map));

			// 選択サービスの帳票種類と重複する履歴の件数を取得。
			int count = getCountDuplicateOnClaimStyle(claimStyle, reserved);

			if (insureType == INSURE_TYPE_KAIGO) {
				// 介護公費の場合
				if (count > 2) {
					return false;
				}
			} else if (insureType == INSURE_TYPE_IRYO) {
				// 医療公費の場合
				if (count > 1) {
					return false;
				}
			}

		}

		return true;
	}

	/**
	 * 「公費対象選択サービス判定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @param int
	 *            帳票種類（比較元）
	 * @param VRList
	 *            登録されている公費履歴
	 * @return int 重複した件数
	 */
	public int getCountDuplicateOnClaimStyle(int claimStyle, VRList reserved)
			throws Exception {

		// 戻り値用
		int count = 0;

		for (int i = 0; i < reserved.size(); i++) {
			// 公費履歴よりレコードを取得
			VRMap patientKohi = (VRMap) reserved.get(i);
			// レコードのIDを取得
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					patientKohi));

			// 公費サービス履歴の件数分ループ
			for (int j = 0; j < getPatientKohiServiceList().size(); j++) {
				VRMap patientKohiService = (VRMap) getPatientKohiServiceList()
						.get(j);

				// 公費履歴レコードのIDと紐づく、公費サービス履歴の場合
				if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
						patientKohiService)) == kohiId) {
					// サービス種類コードを取得する。
					int systemServiceKindDetail = ACCastUtilities
							.toInt(VRBindPathParser.get(
									"SYSTEM_SERVICE_KIND_DETAIL",
									patientKohiService));

					// 取得したサービス種類コードでサービスマスタデータを取得
					VRMap service = (VRMap) VRBindPathParser.get(new Integer(
							systemServiceKindDetail), getMasterService());

					// 渡された帳票種類とサービスマスタの帳票種類を比較
					if (ACCastUtilities.toInt(VRBindPathParser.get(
							"CLAIM_STYLE_TYPE", service)) == claimStyle) {
						// 重複していた場合カウンタを1加算する。
						count += 1;

						// 次のKOHI_IDへ
						break;
					}
				}
			}
		}

		// 件数を返す。
		return count;

	}

	/**
	 * 同公費の履歴のうち、最新の履歴を返します。 同公費の履歴がない場合、-1を返します。 検索キー：KOHI_TYPE, KOHI_LAW_NO
	 */
	public int getIndexNewHistory(int kohiType, String kohiLawNo,
			VRList kohiList) throws Exception {
		int result = -1;
		Date keepBegin = null;
		for (int i = 0; i < kohiList.size(); i++) {
			VRMap row = (VRMap) kohiList.get(i);
			if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_TYPE", row)) == kohiType
					&& kohiLawNo
							.equals(ACCastUtilities.toString(VRBindPathParser
									.get("KOHI_LAW_NO", row)))) {
				Date tempBegin = ACCastUtilities.toDate(VRBindPathParser.get(
						"KOHI_VALID_START", row));
				if (keepBegin == null) {
					keepBegin = tempBegin;
					result = i;
				} else if (ACDateUtilities.compareOnDay(keepBegin, tempBegin) < 0) {
					keepBegin = tempBegin;
					result = i;
				}
			}
		}
		return result;
	}

	/**
	 * 「有効期間重複判定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @param VRMap
	 *            画面上で入力されているデータ
	 * @param VRList
	 *            登録されている履歴
	 * @return boolean 重複している場合true
	 */
	public int isDuplicateTerm(VRMap map, VRList list, int newHistoryIndex)
			throws Exception {

		int result = RESULT_FALSE;

		// 同じ公費の有効期間が重複していないか判定する。(検索キー：KOHI_TYPE, KOHI_LAW_NO)
		if (list == null) {
			return result;
		}

		// 登録しようとしている公費の種類
		int kohiType = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_TYPE",
				map));
		String kohiLawNo = ACCastUtilities.toString(VRBindPathParser.get(
				"KOHI_LAW_NO", map));

		for (int i = 0; i < list.size(); i++) {
			VRMap temp = (VRMap) list.get(i);

			if (ACCastUtilities.toInt(VRBindPathParser.get("KOHI_TYPE", temp)) == kohiType
					&& kohiLawNo
							.equals(ACCastUtilities.toString(VRBindPathParser
									.get("KOHI_LAW_NO", temp)))) {
				Object obj;

				Date inputSta;
				obj = VRBindPathParser.get("KOHI_VALID_START", map);
				if (obj == null || "".equals(obj)) {
					inputSta = MIN_DATE;
				} else {
					inputSta = ACCastUtilities.toDate(obj);
				}

				Date inputEnd;
				obj = VRBindPathParser.get("KOHI_VALID_END", map);
				if (obj == null || "".equals(obj)) {
					inputEnd = MAX_DATE;
				} else {
					inputEnd = ACCastUtilities.toDate(obj);
				}

				Date reservedSta = ACCastUtilities.toDate(VRBindPathParser.get(
						"KOHI_VALID_START", temp));
				Date reservedEnd = ACCastUtilities.toDate(VRBindPathParser.get(
						"KOHI_VALID_END", temp));

				int compareDateResult = (ACDateUtilities.getDuplicateTermCheck(
						reservedSta, reservedEnd, inputSta, inputEnd));

				// 重複チェックの値により分岐
				if (i == newHistoryIndex) {
					// この履歴が最後の履歴の場合
					if (compareDateResult == ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND
							|| compareDateResult == ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND_EQUALS_BOTH_END
							|| compareDateResult == ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN
							|| compareDateResult == ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN_ON_ONE_DAY) {
						// 変更可能
						// ただし、他の履歴と重複していないことが保証されること
						if (ACDateUtilities.compareOnDay(inputSta, MIN_DATE) == 0) {
							// 登録されようとしている有効期間開始が未入力もしくはMINの場合
							return RESULT_TRUE;
						} else {
							result = RESULT_CHANGEABLE;
						}
					} else if (compareDateResult != ACDateUtilities.DUPLICATE_NONE) {
						return RESULT_TRUE;
					}
				} else {
					if (compareDateResult != ACDateUtilities.DUPLICATE_NONE) {
						return RESULT_TRUE;
					}
				}
			}
		}

		// 重複がなかった場合
		return result;

	}

	/**
	 * 有効期間終了を補正します。
	 * 
	 * @param map
	 * @param list
	 * @param newHistoryIndex
	 * @throws Exception
	 */
	public void changeSpanEnd(VRMap map, VRList list, int newHistoryIndex)
			throws Exception {

		Date newEnd = ACDateUtilities.addDay(ACCastUtilities
				.toDate(VRBindPathParser.get("KOHI_VALID_START", map)), -1);

		VRMap tempMap = (VRMap) list.get(newHistoryIndex);
		VRBindPathParser.set("KOHI_VALID_END", tempMap, newEnd);
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
		Object obj;
		obj = VRBindPathParser.get("KOHI_VALID_START", map);
		if (obj == null || "".equals(obj)) {
			VRBindPathParser.set("KOHI_VALID_START", map, MIN_DATE);
		}

		// 有効期間終了日が入力されていない場合
		// 上限日付を自動設定
		obj = VRBindPathParser.get("KOHI_VALID_END", map);
		if (obj == null || "".equals(obj)) {
			VRBindPathParser.set("KOHI_VALID_END", map, MAX_DATE);
		}
	}

	/**
	 * 指定の様式を使用する公費を抽出して返します。
	 * 
	 * @param VRMap
	 *            値を詰め込みたいVRMap
	 * @throws Exception
	 *             処理例外
	 */
	public ArrayList getKohi(ArrayList kohiList, int claimStyle)
			throws Exception {
		ArrayList result = new ArrayList();
		// kohiListを走査して、styleに一致するものを抽出
		Iterator it = kohiList.iterator();
		while (it.hasNext()) {
			VRMap row = (VRMap) it.next();
			int kohiId = ACCastUtilities.toInt(VRBindPathParser.get("KOHI_ID",
					row));
			// for (int i = 0; i < getMasterKohiServiceList().size(); i++) {
			for (int i = 0; i < getPatientKohiServiceList().size(); i++) {
				// VRMap temp = (VRMap) getMasterKohiServiceList().get(i);
				VRMap temp = (VRMap) getPatientKohiServiceList().get(i);
				if (kohiId == ACCastUtilities.toInt(VRBindPathParser.get(
						"KOHI_ID", temp))) {
					int serviceKindDetail = ACCastUtilities
							.toInt(VRBindPathParser.get(
									"SYSTEM_SERVICE_KIND_DETAIL", temp));
					VRMap service = (VRMap) VRBindPathParser.get(new Integer(
							serviceKindDetail), getMasterService());
					int masterClaimStyle = ACCastUtilities
							.toInt(VRBindPathParser.get("CLAIM_STYLE_TYPE",
									service));
					if (claimStyle == masterClaimStyle) {
						result.add(row.clone());
						break;
					}
				}
			}
		}
		return result;
	}

	/**
	 * 同一様式で重複する公費の件数をカウントし 指定した件数を超えた場合falseを返します。
	 */
	public boolean checkKohiRange(ArrayList kohiList, int kohiId, Date begin,
			Date end, int maxCount) throws Exception {

		// 対象公費一覧をKohiRangeの集合に変換する
		ArrayList targetRanges = new ArrayList();

		// 登録しようとする公費
		QU004KohiRange range = new QU004KohiRange();
		range.setBegin(begin);
		range.setEnd(end);
		range.setCount(1);
		range.setMaxCount(maxCount);
		range.getKohiIdList().add(new Integer(kohiId));
		targetRanges.add(range);

		// 登録済みの公費を全走査し、登録しようとする公費との期間重複をチェックする。
		Iterator it = kohiList.iterator();
		while (it.hasNext()) {
			VRMap row = (VRMap) it.next();
			ArrayList list = new ArrayList();
			list.add(row);

			// ここまでに比較した期間すべてを対象に重複をチェックする
			int size = targetRanges.size();
			for (int i = 0; i < size; i++) {
				QU004KohiRange kohiRange = (QU004KohiRange) targetRanges.get(i);
				if (!kohiRange.check(targetRanges, list)) {
					return false;
				}
			}
			if (list != null || !list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					// 分割された比較元の公費履歴のうち、残っているものをtargetRangesに追加
					VRMap leftKohi = (VRMap) list.get(i);
					QU004KohiRange leftKohiRange = new QU004KohiRange();
					leftKohiRange.setBegin(ACCastUtilities
							.toDate(VRBindPathParser.get("KOHI_VALID_START",
									leftKohi)));
					leftKohiRange.setEnd(ACCastUtilities
							.toDate(VRBindPathParser.get("KOHI_VALID_END",
									leftKohi)));
					leftKohiRange.setCount(1);
					leftKohiRange.setMaxCount(maxCount);
					leftKohiRange.getKohiIdList().add(
							VRBindPathParser.get("KOHI_ID", leftKohi));
					targetRanges.add(leftKohiRange);
				}
			}
		}

		// 月ごとに最終チェック(月内でmaxCountを超える場合falseを返す)
		for (int i = 0; i < targetRanges.size(); i++) {
			QU004KohiRange row = (QU004KohiRange) targetRanges.get(i);
			ArrayList rowKohiId = (ArrayList)row.getKohiIdList().clone();
			Date rowBegin = row.getBegin();
			Date rowEnd = row.getEnd();

			// 開始日の属する月に存在する公費履歴をカウントする
			int beginCount = rowKohiId.size();
			// 終了日の属する月に存在する公費履歴をカウントする
			int endCount = rowKohiId.size();

			// 他の要素との比較
			for (int j = 0; j < targetRanges.size(); j++) {
				// 自身はスキップ
				if (i == j) {
					continue;
				}
				QU004KohiRange tempRow = (QU004KohiRange) targetRanges.get(j);
				ArrayList tempRowKohiId = tempRow.getKohiIdList();
				Date tempRowBegin = tempRow.getBegin();
				Date tempRowEnd = tempRow.getEnd();

				if (ACDateUtilities.compareOnMonth(rowBegin, tempRowEnd) == 0) {
					// 比較元：開始と比較先：終了が同月の場合
					// 開始日の月に存在する履歴をマージしてカウント
					beginCount = countKohiOnMonth(rowKohiId, tempRowKohiId,
							beginCount);
				} else if (ACDateUtilities.compareOnMonth(rowBegin,
						tempRowBegin) == 0) {
					// 比較元：開始と比較先：開始が同月の場合
					// 開始日の月に存在する履歴をマージしてカウント
					beginCount = countKohiOnMonth(rowKohiId, tempRowKohiId,
							beginCount);
				}
				if (ACDateUtilities.compareOnMonth(rowEnd, tempRowBegin) == 0) {
					// 比較元：終了と比較先：開始が同月の場合
					// 終了日の月に存在する履歴をマージしてカウント
					endCount = countKohiOnMonth(rowKohiId, tempRowKohiId,
							endCount);
				} else if (ACDateUtilities.compareOnMonth(rowEnd, tempRowEnd) == 0) {
					// 比較元：終了と比較先：終了が同月の場合
					// 終了日の月に存在する履歴をマージしてカウント
					endCount = countKohiOnMonth(rowKohiId, tempRowKohiId,
							endCount);
				}
				if (beginCount > maxCount || endCount > maxCount) {
					// 限界値突破
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * 同月内の公費履歴をカウントします。(マージ処理)
	 */
	public int countKohiOnMonth(ArrayList kohiIdList, ArrayList subKohiIdList,
			int count) throws Exception {
		boolean flag;
		for (int k = 0; k < subKohiIdList.size(); k++) {
			flag = false;
			int tempId = ACCastUtilities.toInt(subKohiIdList.get(k));
			for (int l = 0; l < kohiIdList.size(); l++) {
				if (tempId == ACCastUtilities.toInt(kohiIdList.get(l))) {
					flag = true;
				}
			}
			if (!flag) {
				// 比較した公費IDを追加しておく
				kohiIdList.add(new Integer(tempId));
				count++;
			}
		}
		return count;
	}

	public Component getFirstFocusComponent() {
		return getKaigoInfoPublicExpense();
	}

	/* 2007-04-05 結核予防法対応 change start kamitsukasa */
	/**
	 * 公費の表示・非表示を判定します。
	 * @param kohi			公費レコード
	 * @param aimDate		基準となる日付
	 * @param showOldKohi	過去の公費を表示するかどうか
	 */
	public boolean canShowKohi(VRMap kohi, Date aimDate, int showOldKohi)
			throws Exception {

		if (showOldKohi == SHOW_KOHI) {
			// 過去の公費も表示する設定となっている場合
			return true;
		}

		Date start = ACCastUtilities.toDate(VRBindPathParser.get(
				"KOHI_VALID_START", kohi));
		Date end = ACCastUtilities.toDate(VRBindPathParser.get(
				"KOHI_VALID_END", kohi));

		if (ACDateUtilities.compareOnDay(aimDate, start) >= 0
				&& ACDateUtilities.compareOnDay(aimDate, end) <= 0) {
			// 基準日付が有効期間内にある場合
			return true;
		}

		return false;
	}
	/* 2007-04-05 結核予防法対応 change end kamitsukasa */
}
