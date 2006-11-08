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
 * 作成日: 2006/01/21  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 医療看護情報画面 (003)
 * プログラム 医療看護情報画面 (QU003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qu.qu003;

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

/**
 * 医療看護情報画面(QU003) 
 */
public class QU003 extends QU003Event {
	/**
	 * コンストラクタです。
	 */
	public QU003() {
	}

	public void initAffair(ACAffairInfo affair) throws Exception {
		super.initAffair(affair);
		initAction(affair);
	}

	/**
	 * 初期化処理を行ないます。
	 * @param affair 業務情報
	 * @throws Exception 処理例外
	 */
	protected void initAction(ACAffairInfo affair) throws Exception {

		// 渡りパラメータを退避する。
		VRMap param = affair.getParameters();

		// ・patientId　KEY：PATIENT_ID
		if (VRBindPathParser.has("PATIENT_ID", param)) {
			setPatientId(ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", param)));
		}

		// ・processStart　KEY：PROCESS_START
		if (VRBindPathParser.has("PROCESS_START", param)) {
			setProcessStart(ACCastUtilities.toString(VRBindPathParser.get(
					"PROCESS_START", param)));
		}

		// 渡りパラメータの削除
		param.clear();

		// 画面の初期化を行う。
		initialize();

		// DBよりデータを取得し、画面に設定する。
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
			// KEY：COMPULSORY_BACK_FLG  VALUE：compulsoryBackFlg
			VRBindPathParser.set("COMPULSORY_BACK_FLG", parameters,
					new Integer(getCompulsoryBackFlg()));
			// 前画面に遷移する。	
			return true;
		}

		// 変更チェック(破棄する可能性のある情報)
		if (getSnapShotIryo().isModified()) {
			unsettledInfoExistFlg = true;
		}

		// 変更チェック（スナップショットのチェック、画面テーブルのチェック）
		if (getSnapshot().isModified() || getMedicalTableChangeFlg() == 1
				|| unsettledInfoExistFlg) {
			// 最後に保存されてから、項目・画面テーブルが変更されている場合
			// (下記のいずれかの場合)
			// ・isModified
			// ・medicalTableChangeFlg = 1

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
							String msgParam = "医療保険情報";
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
						if (!isValidInputStation()) {
							// 入力エラーがある場合				    	
							// 処理を終了する。
							return false;
						}

						// 保存処理を行う。
						if (!doSave()) {
							// パッシブエラーが発生した場合
							return false;
						}

						// 保存処理が正常終了した場合
						//				    	// 処理完了通知メッセージを表示する。
						//				        // ・メッセージID：INSERT_SUCCESSED
						//				    	QkanMessageList.getInstance().INSERT_SUCCESSED();

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
							String msgParam = "医療保険情報";
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
						if (!isValidInputStation()) {
							// 入力エラーがある場合				    	
							// 処理を終了する。
							return false;
						}

						// 保存処理を行う。
						if (!doSave()) {
							// パッシブエラーが発生した場合
							return false;
						}

						// 保存処理が正常終了した場合
						//					    // 処理完了通知メッセージを表示する。
						//					    // ・メッセージID：UPDATE_SUCCESSED
						//					    QkanMessageList.getInstance().UPDATE_SUCCESSED();

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

		// 変更チェック（スナップショット、画面テーブルのチェック）
		if (getSnapshot().isModified() || getMedicalTableChangeFlg() == 1) {
			// 最後に保存されてから、項目・テーブルが変更されている場合
			// (下記のいずれかの場合）
			// ・isModified
			// ・medicalTableChangeFlg = 1

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

	//コンポーネントイベント

	/**
	 * 「DB登録」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {

		try {

			// 変更チェック(破棄する可能性のある情報)
			if (getSnapShotIryo().isModified()) {
				// メッセージ表示
				String msgParam = "医療保険情報";
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
			if (!isValidInputStation()) {
				// 入力エラーがあった場合
				// 処理を中断する。(終了)
				return;
			}

			// 保存処理を行う。
			if (!doSave()) {
				// パッシブエラーが起きた場合
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
			// （終了）
			QkanMessageList.getInstance().INSERT_SUCCESSED();

		} catch (Exception ex) {
			// 保存処理が正常終了しなかった場合
			// 処理を終了する。
			throw ex;
		}
	}

	/**
	 * 「DB更新」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void updateActionPerformed(ActionEvent e) throws Exception {

		try {

			// 変更チェック(破棄する可能性のある情報)
			if (getSnapShotIryo().isModified()) {
				// メッセージ表示
				String msgParam = "医療保険情報";
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
			if (!isValidInputStation()) {
				// 入力エラーがあった場合
				// 処理を中断する。(終了)
				return;
			}

			// 保存処理を行う。
			if (!doSave()) {
				// パッシブエラーが起きた場合
				return;
			}

			// 保存処理が正常終了した場合
			// 画面の設定を行う。
			casualInitialize();

			// 最新のデータを取得する。
			doFind();

			// 完了メッセージを表示する。
			// ・メッセージID：UPDATE_SUCCESSED
			//（終了）
			QkanMessageList.getInstance().UPDATE_SUCCESSED();

		} catch (Exception ex) {
			// 保存処理が正常終了しなかった場合
			// 処理を終了する。
			throw ex;
		}
	}

	/**
	 * 「対象レコードを表示」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void medicalInfoTableSelectionChanged(ListSelectionEvent e)
			throws Exception {

		VRMap map = new VRHashMap();

		if (!getMedicalInfoTable().isSelected()) {
			// 画面テーブルの行を選択していない場合

			// Enable制御を行う。
			// ・状態ID：ENABLE_MEDICAL_BUTTON_FALSE
			setState_ENABLE_MEDICAL_BUTTON_FALSE();

			// 画面のソースを生成する。
			map = (VRMap) getMedicalInfos().createSource();

			//  	    // 保険者名、市町村名コンボのクリア　※bindpathを持たないため
			//  	    getMedicalInfoInsurerName().setSelectedItem(null);
			//  	    getMedicalInfoCitiesName().setSelectedItem(null);

		} else {
			// 画面テーブルの行を選択している場合

			// Enable制御を行う。
			// ・状態ID：ENABLE_MEDICAL_BUTTON_TRUE
			setState_ENABLE_MEDICAL_BUTTON_TRUE();

			// 選択されているレコードを取得する。
			map = (VRMap) getMedicalInfoTable().getSelectedModelRowValue();

		}

		// 「医療保険領域・情報（medicalInfos）」のソースとして設定する。
		getMedicalInfos().setSource(map);

		// 画面に展開する。
		getMedicalInfos().bindSource();

		// 保険者名、市町村名を選択状態にする。
		Object temp;
		// 保険者名
		temp = VRBindPathParser.get("MEDICAL_INSURER_ID", map);
		getMedicalInfoInsurerName().setSelectedItem(
				ACBindUtilities.getMatchRowFromValue(getInsurerList(),
						"INSURER_ID", temp));
		// 市町村名
		temp = VRBindPathParser.get("CITY_INSURER_ID", map);
		getMedicalInfoCitiesName().setSelectedItem(
				ACBindUtilities.getMatchRowFromValue(getInsurerList(),
						"INSURER_ID", temp));

		// スナップショット
		getSnapShotIryo().snapshot();

	}

	/**
	 * 「クリア処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void medicalInfoButtonClearActionPerformed(ActionEvent e)
			throws Exception {

		if (getMedicalInfoTable().isSelected()) {
			// 画面テーブルが選択されている場合
			// 画面テーブルの行を未選択の状態に設定する。
			getMedicalInfoTable().clearSelection();
		} else {
			VRMap map = new VRHashMap();
			// 画面のソースを生成する。
			map = (VRMap) getMedicalInfos().createSource();

			// 「医療保険領域・情報（medicalInfos）」のソースとして設定する。
			getMedicalInfos().setSource(map);

			// 画面に展開する。
			getMedicalInfos().bindSource();

			// スナップショット
			getSnapShotIryo().snapshot();

		}

	}

	/**
	 * 「追加処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void medicalInfoButtonInsertActionPerformed(ActionEvent e)
			throws Exception {

		// 入力チェックを行う。
		if (!isValidInputMedical(CHECK_MODE_INSERT)) {
			// 入力エラーがあった場合
			// 処理を中断する。
			return;
		}

		// 入力エラーがなかった場合
		// 有効なデータのみ取得する。
		VRMap map = getValidMedicalData();

		// 取得した画面上のデータにPATIENT_IDを設定する。
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));

		// medicalHistoryListを件数分ループし、MEDICAL_HISTORY_IDの最大値+1の値を取得する。
		int maxId = 0;

		// 最大値の取得
		if (!(getMedicalHistoryList() == null || getMedicalHistoryList().size() == 0)) {

			// 画面テーブルに既にデータが存在している場合    	
			for (int i = 0; i < getMedicalHistoryList().size(); i++) {

				int target = ACCastUtilities.toInt(VRBindPathParser.get(
						"MEDICAL_HISTORY_ID", (VRMap) getMedicalHistoryList()
								.get(i)));

				// 比較対象が比較元より大きい値の場合
				if (maxId < target) {
					// 比較対象を比較元とする。
					maxId = target;
				}

			}
		}

		// MEDICAL_HISTORY_IDを追加する。
		VRBindPathParser.set("MEDICAL_HISTORY_ID", map, new Integer(maxId + 1));

		//    // 画面の高齢9/高齢8ラジオ（medicalInfoOld9AndOld8Radio）が無効状態の場合
		//    if(!getMedicalInfoOld9AndOld8Radio().isEnabled()){
		//	    // 画面の高齢9/高齢8ラジオ（medicalInfoOld9AndOld8Radio）が
		//    	// 選択されている場合
		//    	if(getMedicalInfoOld9AndOld8Radio().isSelected()){
		//    		// 取得したデータのOLD_RATE_FLAGの値に0を代入する。
		//    		VRBindPathParser.set("OLD_RATE_FLAG", map, new Integer(0));
		//    	}
		//    }

		// 取得したデータをテーブル表示用に編集する。
		map = toMedicalTableList(map);

		// 取得したデータをmedicalHistoryListに追加する。
		getMedicalHistoryList().add(map);

		// 追加行のインデックスを退避(最終行のインデックス)
		int selectedRow = getMedicalHistoryList().size() - 1;

		// 以下の条件で医療保険テーブルのソートを行う。
		// MEDICAL_VALID_START（医療保険有効期間開始）　DESC
		getMedicalInfoTable().sort("MEDICAL_VALID_START DESC");

		// 選択されていた行を選択
		getMedicalInfoTable().setSelectedModelRow(selectedRow);

		// medicalTableChangeFlgに1（変更あり）を代入する。
		setMedicalTableChangeFlg(1);

	}

	/**
	 * 「編集処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void medicalInfoButtonConpileActionPerformed(ActionEvent e)
			throws Exception {

		// 入力チェックを行う。
		if (!isValidInputMedical(CHECK_MODE_UPDATE)) {
			// 入力エラーがあった場合
			// 処理を中断する。
			return;
		}

		// 入力エラーがなかった場合
		// 選択行のインデックスを退避
		int selectedRow = getMedicalInfoTable().getSelectedModelRow();

		// 有効なデータのみ取得する。
		VRMap map = getValidMedicalData();

		//    // 画面の高齢9/高齢8ラジオ（medicalInfoOld9AndOld8Radio）が無効状態の場合
		//    if(!getMedicalInfoOld9AndOld8Radio().isEnabled()){
		//	    // 画面の高齢9/高齢8ラジオ（medicalInfoOld9AndOld8Radio）が
		//    	// 選択されている場合
		//    	if(getMedicalInfoOld9AndOld8Radio().isSelected()){
		//    		// 取得したデータのOLD_RATE_FLAGの値に0を代入する。
		//    		VRBindPathParser.set("OLD_RATE_FLAG", map, new Integer(0));
		//    	}
		//    }

		// 選択行のデータを取得する。
		VRMap temp = (VRMap) getMedicalHistoryList().get(selectedRow);

		// 選択行のデータより画面上にないデータを画面上データに移す。
		VRBindPathParser.set("PATIENT_ID", map, new Integer(getPatientId()));
		VRBindPathParser.set("MEDICAL_HISTORY_ID", map, VRBindPathParser.get(
				"MEDICAL_HISTORY_ID", temp));

		// 取得したデータをテーブル表示用に編集する。
		map = toMedicalTableList(map);

		// 選択行に画面上のデータを設定する。
		getMedicalHistoryList().setData(selectedRow, map);

		// 以下の条件で医療保険テーブルのソートを行う。
		// MEDICAL_VALID_START（医療保険有効期間開始）　DESC
		getMedicalInfoTable().sort("MEDICAL_VALID_START DESC");

		// 選択されていた行を選択
		getMedicalInfoTable().setSelectedModelRow(selectedRow);

		// medicalTableChangeFlgに1（変更あり）を代入する。
		setMedicalTableChangeFlg(1);

	}

	/**
	 * 「削除処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void medicalInfoButtonDeleteActionPerformed(ActionEvent e)
			throws Exception {

		// 確認メッセージを表示する。
		// ・メッセージID：WARNING_OF_DELETE_SELECTION
		switch (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION()) {

		// 「はい」を選択した場合
		case ACMessageBox.RESULT_OK:

			// 選択されているレコードの画面上のインデックス
			int sortedRow = getMedicalInfoTable().getSelectedSortedRow();

			// 選択されているレコードをidouHistoryListから削除する。
			getMedicalHistoryList().remove(
					getMedicalInfoTable().getSelectedModelRow());

			// 削除された行の1行上の行を選択する。
			getMedicalInfoTable().setSelectedSortedRowOnAfterDelete(sortedRow);

			// medicalTableChangeFlgに1（変更あり）を代入する。
			setMedicalTableChangeFlg(1);

			break;

		case ACMessageBox.RESULT_CANCEL:
			// 「キャンセル」を選択した場合
			// 処理を抜ける。（何もしない）
			break;

		}
	}

	/**
	 * 「クリア処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void specialInstructButton2ActionPerformed(ActionEvent e)
			throws Exception {

		// 特別指示書期間開始（specialInstruct1）、
		// 特別指示書期間終了（specialInstruct2）をクリアする。
		VRMap map = (VRMap) getSpecialInstructPanel1().createSource();
		getSpecialInstructPanel1().setSource(map);
		getSpecialInstructPanel1().bindSource();

	}

	/**
	 * 「画面処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void medicalInfoInsurerNoFocusLost(FocusEvent e) throws Exception {

		// 入力された保険者番号で、保険者情報（insurerList）を検索する。
		String medicalInsurerId = getMedicalInfoInsurerNo().getText();
		VRMap map = ACBindUtilities.getMatchRowFromValue(getInsurerList(),
				"INSURER_ID", medicalInsurerId);

		// 該当レコードの保険者名を、保険者名コンボ（medicalInfoInsurerName）
		// で選択状態にする。
		getMedicalInfoInsurerName().setSelectedItem(map);
	}

	/**
	 * 「画面処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void medicalInfoInsurerNameActionPerformed(ActionEvent e)
			throws Exception {

		// 選択された保険者の保険者番号を保険者番号フィールド（medicalInfoInsurerNo）
		// に表示する。
		VRMap map = (VRMap) getMedicalInfoInsurerName().getSelectedModelItem();

		if (VRBindPathParser.get("INSURER_ID", map) != null) {
			getMedicalInfoInsurerNo().setText(
					ACCastUtilities.toString(VRBindPathParser.get("INSURER_ID",
							map)));
		}
	}

	/**
	 * 「画面処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void medicalInfoCitiesNoFocusLost(FocusEvent e) throws Exception {

		// 入力された保険者番号で、保険者情報（insurerList）を検索する。
		String cityInsurerId = getMedicalInfoCitiesNo().getText();
		VRMap map = ACBindUtilities.getMatchRowFromValue(getInsurerList(),
				"INSURER_ID", cityInsurerId);

		// 該当レコードの保険者名を、保険者名コンボ（medicalInfoCitiesName）
		// で選択状態にする。
		getMedicalInfoCitiesName().setSelectedItem(map);
	}

	/**
	 * 「画面処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void medicalInfoCitiesNameActionPerformed(ActionEvent e)
			throws Exception {

		// 選択された保険者の保険者番号を保険者番号フィールド（medicalInfoInsurerNo）
		// に表示する。
		VRMap map = (VRMap) getMedicalInfoCitiesName().getSelectedModelItem();

		if (VRBindPathParser.get("INSURER_ID", map) != null) {
			getMedicalInfoCitiesNo().setText(
					ACCastUtilities.toString(VRBindPathParser.get("INSURER_ID",
							map)));
		}

	}

	/**
	 * 「画面処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void medicalTreatmentInfoOrganActionPerformed(ActionEvent e)
			throws Exception {

		VRMap map;

		// 医療機関情報表示処理
		if (getMedicalTreatmentInfoOrgan().isSelected()) {
			// コンボで選択されている医療機関の情報を取得する。
			if (getMedicalTreatmentInfoOrgan().getSelectedModelItem() == null
					|| "".equals(getMedicalTreatmentInfoOrgan()
							.getSelectedModelItem())) {

				// 新たなソースを生成する。
				map = (VRMap) getMedicalTreatmentInfos().createSource();

				// 主治医氏名のKEYを削る
				map.remove("DOCTOR_NAME");

			} else {
				map = (VRMap) getMedicalTreatmentInfoOrgan()
						.getSelectedModelItem();

				// medicalFacilityMapから、以下のフィールドを取得し、結合する。
				// ・MEDICAL_FACILITY_TEL_FIRST
				// ・MEDICAL_FACILITY_TEL_SECOND
				// ・MEDICAL_FACILITY_TEL_THIRD
				String tel1 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_TEL_FIRST", map));
				String tel2 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_TEL_SECOND", map));
				String tel3 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_TEL_THIRD", map));
				String tel = QkanCommon.toTel(tel1, tel2, tel3);

				// 結合した値をmedicalFacilityMapにKEY：MEDICAL_FACILITY_TELで設定する。
				VRBindPathParser.set("MEDICAL_FACILITY_TEL", map, tel);

				// medicalFacilityMapから、以下のフィールドを取得し、結合する。
				// ・MEDICAL_FACILITY_ZIP_FIRST
				// ・MEDICAL_FACILITY_ZIP_SECOND
				String zip1 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_ZIP_FIRST", map));
				String zip2 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_ZIP_SECOND", map));
				String zip = QkanCommon.toZip(zip1, zip2);

				// 結合した値をmedicalFacilityMapにKEY：MEDICAL_FACILITY_ZIPで設定する。
				VRBindPathParser.set("MEDICAL_FACILITY_ZIP", map, zip);

				// medicalFacilityMapから、以下のフィールドを取得し、結合する。
				// ・MEDICAL_FACILITY_FAX_FIRST
				// ・MEDICAL_FACILITY_FAX_SECOND
				// ・MEDICAL_FACILITY_FAX_THIRD
				String fax1 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_FAX_FIRST", map));
				String fax2 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_FAX_SECOND", map));
				String fax3 = ACCastUtilities.toString(VRBindPathParser.get(
						"MEDICAL_FACILITY_FAX_THIRD", map));
				String fax = QkanCommon.toTel(fax1, fax2, fax3);

				// 結合した値をmedicalFacilityMapにKEY：MEDICAL_FACILITY_FAXで設定する。
				VRBindPathParser.set("MEDICAL_FACILITY_FAX", map, fax);

			}

		} else {
			// 新たなソースを生成する。
			map = (VRMap) getMedicalTreatmentInfos().createSource();

			// 主治医氏名のKEYを削る
			map.remove("DOCTOR_NAME");

		}

		// 主治医氏名のソースを退避する。
		VRMap temp = (VRMap) getMedicalTreatmentInfoMainDoctorName()
				.getSource();

		// 医療機関情報（medicalTreatmentInfos）のソースとしてmedicalFacilityMapを設定する。
		getMedicalTreatmentInfos().setSource(map);

		// 画面に展開する。
		getMedicalTreatmentInfos().bindSource();

		// 退避しておいた主治医氏名のソースを設定する。
		getMedicalTreatmentInfoMainDoctorName().setSource(temp);

	}

	/**
	 * 「画面処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void medicalInfoInsuranceVarietyRadio2SelectionChanged(
			ListSelectionEvent e) throws Exception {

		//  	if(getMedicalInfoInsuranceVarietyRadio2().isSelected()){
		//  	    // 選択されている場合
		//  		if(getMedicalInfoInsuranceVarietyRadio2().getSelectedIndex() == 1){
		//	  	    // 「老人」が選択されている場合
		//	  	    // Enable制御を行う。
		//	  	    // ・状態ID：ENABLE_OLD_RADIO_TRUE
		//  			setState_ENABLE_OLD_RADIO_TRUE();
		//  		}else{
		//  		    // Enable制御を行う。
		//  		    // ・状態ID：ENABLE_OLD_RADIO_FALSE
		//  		    setState_ENABLE_OLD_RADIO_FALSE();
		//  		}
		//  	}else{
		//	  	// 選択されていない場合（クリアされた状態）
		//	    // Enable制御を行う。
		//	    // ・状態ID：ENABLE_OLD_RADIO_FALSE
		//	    setState_ENABLE_OLD_RADIO_FALSE();
		//  	}

	}

	/**
	 * 「画面処理」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void medicalInfoInsuranceVarietyRadio1SelectionChanged(
			ListSelectionEvent e) throws Exception {

		if (getMedicalInfoInsuranceVarietyRadio1().isSelected()) {
			// 選択されている場合
			if (getMedicalInfoInsuranceVarietyRadio1().getSelectedIndex() == INSURE_TYPE_KOHI) {
				// 公費が選択されている場合
				setState_ONLY_KOHI();
			} else {
				// 公費以外が選択されている場合
				setState_NOT_ONLY_KOHI();
			}
		} else {
			// 選択されていない場合
			setState_NOT_ONLY_KOHI();
		}
	}

	public static void main(String[] args) {
		//デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		//paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QU003.class.getName(), param));
	}

	// 内部関数

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public boolean isValidInputStation() throws Exception {

		// 訪問看護ステーション情報の入力チェックを行う。

		String msgParam1 = null;
		String msgParam2 = null;
		String msgParam3 = null;

		// 下記のフィールドが未入力でないかチェックする。
		// ・指示書有効期間開始（instructInfoValidLimit1）
		// ※エラーの場合、String：msgParam1を宣言し、"指示書有効期間開始日"を代入する。
		// ・指示書有効期間終了（instructInfoValidLimit2）
		// ※エラーの場合、String：msgParam1を宣言し、"指示書有効期間終了日"を代入する。
		// 開始‐入力、終了‐未入力
		if (ACTextUtilities.isNullText(getInstructInfoValidLimit1().getText())
				&& !(ACTextUtilities.isNullText(getInstructInfoValidLimit2()
						.getText()))) {
			getInstructInfoValidLimit1().requestFocus();
			msgParam1 = "指示書有効期間開始日";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// ・指示書有効期間開始（instructInfoValidLimit1）
		// 入力されている場合、存在する日付が入力されているか。
		// ※エラーの場合、String：msgParam1を宣言し、"指示書有効期間開始日の"を代入する。
		if (!(ACTextUtilities
				.isNullText(getInstructInfoValidLimit1().getText()))) {
			if (!(getInstructInfoValidLimit1().isValidDate())) {
				getInstructInfoValidLimit1().requestFocus();
				msgParam1 = "指示書有効期間開始日の";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		// 開始‐未入力、終了‐入力
		if (!(ACTextUtilities
				.isNullText(getInstructInfoValidLimit1().getText()))
				&& ACTextUtilities.isNullText(getInstructInfoValidLimit2()
						.getText())) {
			getInstructInfoValidLimit2().requestFocus();
			msgParam1 = "指示書有効期間終了日";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// ・指示書有効期間終了（instructInfoValidLimit2）
		// 入力されている場合、存在する日付が入力されているか。
		// ※エラーの場合、String：msgParam1を宣言し、"指示書有効期間終了日の"を代入する。
		if (!(ACTextUtilities
				.isNullText(getInstructInfoValidLimit2().getText()))) {
			if (!(getInstructInfoValidLimit2().isValidDate())) {
				getInstructInfoValidLimit2().requestFocus();
				msgParam1 = "指示書有効期間終了日の";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		// ・特別指示書有効期間開始（specialInstruct1）
		// ※エラーの場合、String：msgParamを宣言し、"特別指示書有効期間開始日"を代入する。
		// ・特別指示書有効期間終了（specialInstruct2）
		// ※エラーの場合、String：msgParamを宣言し、"特別指示書有効期間終了日"を代入する。
		// 開始‐入力、終了‐未入力
		if (ACTextUtilities.isNullText(getSpecialInstruct1().getText())
				&& !(ACTextUtilities
						.isNullText(getSpecialInstruct2().getText()))) {
			getSpecialInstruct1().requestFocus();
			msgParam1 = "特別指示書有効期間開始日";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// ・特別指示書有効期間開始（specialInstruct1）
		// 入力されている場合、存在する日付が入力されているか。
		// ※エラーの場合、String：msgParamを宣言し、"特別指示書有効期間開始日の"を代入する。
		if (!(ACTextUtilities.isNullText(getSpecialInstruct1().getText()))) {
			if (!(getSpecialInstruct1().isValidDate())) {
				getSpecialInstruct1().requestFocus();
				msgParam1 = "特別指示書有効期間開始日の";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		// 開始‐未入力、終了‐入力
		if (!(ACTextUtilities.isNullText(getSpecialInstruct1().getText()))
				&& ACTextUtilities.isNullText(getSpecialInstruct2().getText())) {
			getSpecialInstruct2().requestFocus();
			msgParam1 = "特別指示書有効期間終了日";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// ・特別指示書有効期間終了（specialInstruct2）
		// 入力されている場合、存在する日付が入力されているか。
		// ※エラーの場合、String：msgParamを宣言し、"特別指示書有効期間終了日の"を代入する。
		if (!(ACTextUtilities.isNullText(getSpecialInstruct2().getText()))) {
			if (!(getSpecialInstruct2().isValidDate())) {
				getSpecialInstruct2().requestFocus();
				msgParam1 = "特別指示書有効期間開終了日の";
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
				return false;
			}
		}

		// ・指示書有効期間開始（instructInfoValidLimit1）
		// ・指示書有効期間終了（instructInfoValidLimit2）
		// 前後関係をチェックする。※入力されている場合
		// 不正な値の場合
		// String：msgParam1を宣言し、"指示書有効期間は"を代入する。
		// String：msgParam2を宣言し、"開始日"を代入する。
		// String：msgParam3を宣言し、"終了日"を代入する。
		if (!(ACTextUtilities
				.isNullText(getInstructInfoValidLimit1().getText()))
				&& !(ACTextUtilities.isNullText(getInstructInfoValidLimit2()
						.getText()))) {
			Date start = getInstructInfoValidLimit1().getDate();
			Date end = getInstructInfoValidLimit2().getDate();
			if (ACDateUtilities.compareOnDay(start, end) > 0) {
				getInstructInfoValidLimit1().requestFocus();
				msgParam1 = "指示書有効期間は";
				msgParam2 = "開始日";
				msgParam3 = "終了日";
				QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION(
						msgParam1, msgParam2, msgParam3);
				return false;
			}
		}

		// ・特別指示書有効期間開始（specialInstruct1）
		// ・特別指示書有効期間終了（specialInstruct2）
		// 前後関係をチェックする。※入力されている場合
		// 不正な値の場合
		// String：msgParam1を宣言し、"特別指示書有効期間は"を代入する。
		// String：msgParam2を宣言し、"開始日"を代入する。
		// String：msgParam3を宣言し、"終了日"を代入する。
		if (!(ACTextUtilities.isNullText(getSpecialInstruct1().getText()))
				&& !(ACTextUtilities
						.isNullText(getSpecialInstruct2().getText()))) {
			Date start = getSpecialInstruct1().getDate();
			Date end = getSpecialInstruct2().getDate();
			if (ACDateUtilities.compareOnDay(start, end) > 0) {
				getSpecialInstruct1().requestFocus();
				msgParam1 = "特別指示書有効期間は";
				msgParam2 = "開始日";
				msgParam3 = "終了日";
				QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION(
						msgParam1, msgParam2, msgParam3);
				return false;
			}
		}

		// 入力エラーがなかった場合
		return true;

	}

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public boolean isValidInputMedical(int checkMode) throws Exception {

		// 医療保険情報の入力チェックを行う。

		// フラグ
		int doUpdateFlg = 0;

		String msgParam1 = null;
		String msgParam2 = null;
		String msgParam3 = null;

		// ・「保険種類・上（medicalInfoInsuranceVarietyRadio1）」
		// 選択されているかどうか。
		// ※エラーの場合、String：msgParamを宣言し、"保険種類"を代入する。
		if (!(getMedicalInfoInsuranceVarietyRadio1().isSelected())) {
			getMedicalInfoInsuranceVarietyRadio1().requestFocus();
			msgParam1 = "保険種類";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
					msgParam1);
			return false;
		}

		// ・「本人/家族（medicalInfoPersonAndFamilyRadio）」
		// 選択されているかどうか。
		// ※エラーの場合、String：msgParamを宣言し、"本人/家族"を代入する。
//		if (!(getMedicalInfoPersonAndFamilyRadio().isSelected())) {
//			getMedicalInfoPersonAndFamilyRadio().requestFocus();
//			msgParam1 = "本人/家族";
//			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
//					msgParam1);
//			return false;
//		}

		// ・「保険者番号（medicalInfoInsurerNo）」
		// 入力されているかどうか。
		// ※エラーの場合、String：msgParamを宣言し、"保険者番号"を代入する。
		if (getMedicalInfoInsurerNo().isEnabled()) {
			if (ACTextUtilities.isNullText(getMedicalInfoInsurerNo().getText())) {
				getMedicalInfoInsurerNo().requestFocus();
				msgParam1 = "保険者番号";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						msgParam1);
				return false;
			}
		}

		// ・「保険者名（medicalInfoInsurerName）」
		// 選択されているかどうか。
		// ※エラーの場合、String：msgParamを宣言し、"保険者名"を代入する。
		//    if(!(getMedicalInfoInsurerName().isSelected())){
		//    	getMedicalInfoInsurerName().requestFocus();
		//    	msgParam1 = "保険者名";
		//    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
		//    	return false;
		//    }

		// ・「記号・番号（medicalInfoMark）」
		// 入力されているかどうか。※保険種類で公費(INSURE_TYPE_KOHI)以外を選択している場合
		// ※エラーの場合、String：msgParamを宣言し、"記号・番号"を代入する。
		//    if(getMedicalInfoInsuranceVarietyRadio1().getSelectedIndex() != INSURE_TYPE_KOHI){
		//    	if(ACTextUtilities.isNullText(getMedicalInfoMark().getText())){
		//    		getMedicalInfoMark().requestFocus();
		//    		msgParam1 = "記号・番号";
		//        	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
		//        	return false;
		//    	}
		//    }

		// ・「有効期間開始（medicalInfoValidLimit1）」
		// 入力されているかどうか。
		// ※エラーの場合、String：msgParamを宣言し、"有効期間開始日"を代入する。
		if (ACTextUtilities.isNullText(getMedicalInfoValidLimit1().getText())) {
			getMedicalInfoValidLimit1().requestFocus();
			msgParam1 = "有効期間開始日";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// ・「有効期間開始（medicalInfoValidLimit1）」
		// 存在する日付が入力されているかどうか。
		// ※エラーの場合、String：msgParamを宣言し、"有効期間開始日の"を代入する。
		if (!(getMedicalInfoValidLimit1().isValidDate())) {
			getMedicalInfoValidLimit1().requestFocus();
			msgParam1 = "有効期間開始日の";
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
			return false;
		}

		// ・「有効期間終了（medicalInfoValidLimit2）」
		// 入力されているかどうか。
		// ※エラーの場合、String：msgParamを宣言し、"有効期間終了日"を代入する。
		if (ACTextUtilities.isNullText(getMedicalInfoValidLimit2().getText())) {
			getMedicalInfoValidLimit2().requestFocus();
			msgParam1 = "有効期間終了日";
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					msgParam1);
			return false;
		}

		// ・「有効期間終了（medicalInfoValidLimit2）」
		// 存在する日付が入力されているかどうか。
		// ※エラーの場合、String：msgParamを宣言し、"有効期間終了日の"を代入する。
		if (!(getMedicalInfoValidLimit2().isValidDate())) {
			getMedicalInfoValidLimit2().requestFocus();
			msgParam1 = "有効期間終了日の";
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(msgParam1);
			return false;
		}

		// ・「有効期間開始（medicalInfoValidLimit1）」
		// ・「有効期間終了（medicalInfoValidLimit2）」
		// 前後関係をチェックする。
		// ※エラーの場合、String：msgParam1を宣言し、"有効期間は"を代入する。
		// ※エラーの場合、String：msgParam2を宣言し、"開始日"を代入する。
		// ※エラーの場合、String：msgParam3を宣言し、"終了日"を代入する。
		Date start = getMedicalInfoValidLimit1().getDate();
		Date end = getMedicalInfoValidLimit2().getDate();

		if (ACDateUtilities.compareOnDay(start, end) > 0) {
			getMedicalInfoValidLimit1().requestFocus();
			msgParam1 = "有効期間は";
			msgParam2 = "開始日";
			msgParam3 = "終了日";
			QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION(
					msgParam1, msgParam2, msgParam3);
			return false;
		}

		// ・「有効期間開始（medicalInfoValidLimit1）」
		// ・「有効期間終了（medicalInfoValidLimit2）」
		// 既に登録されている履歴の有効期間と重なっていないかチェックする。
		// ・メッセージID：EQU003_ERROR_OF_DUPLICATE_IRYO

		int targetIndex = -1; // 自身の履歴以外で、有効期間が最後の履歴のインデックス
		int selectedRow = getMedicalInfoTable().getSelectedModelRow(); // 選択されている履歴のインデックス

		if (!(getMedicalHistoryList() == null || getMedicalHistoryList().size() == 0)) {

			Date latestStart = null;
			Date reservedStart = null;
			Date reservedEnd = null;

			// 最後の履歴のインデックスを取得する。
			for (int i = 0; i < getMedicalHistoryList().size(); i++) { // 認定履歴件数分ループ

				// 編集モードの場合
				// 自身の履歴は無視する。
				if (checkMode == CHECK_MODE_UPDATE) {
					if (i == selectedRow) {
						continue;
					}
				}

				VRMap map = (VRMap) getMedicalHistoryList().get(i); // 履歴抽出

				reservedStart = (Date) VRBindPathParser.get(
						"MEDICAL_VALID_START", map); // 履歴の有効期間開始日
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
			for (int i = 0; i < getMedicalHistoryList().size(); i++) { // 認定履歴件数分ループ

				// 最後の履歴は後で比較する
				if (i == targetIndex) {
					continue;
				}

				// 編集モードの場合
				// 自身の履歴は無視する。
				if (checkMode == CHECK_MODE_UPDATE) {
					if (i == selectedRow) {
						continue;
					}
				}

				VRMap map = (VRMap) getMedicalHistoryList().get(i); // 履歴抽出

				reservedStart = ACCastUtilities.toDate(VRBindPathParser.get(
						"MEDICAL_VALID_START", map));
				reservedEnd = ACCastUtilities.toDate(VRBindPathParser.get(
						"MEDICAL_VALID_END", map));

				// 期間重複チェック
				// チェックの結果を取得
				int result = ACDateUtilities.getDuplicateTermCheck(
						reservedStart, reservedEnd, start, end);

				if (result != ACDateUtilities.DUPLICATE_NONE) {
					// 重複していた場合
					getMedicalInfoValidLimit1().requestFocus();
					QkanMessageList.getInstance()
							.QU003_ERROR_OF_DUPLICATE_IRYO();
					return false;
				}
			}

			// 最後の履歴と重複していないかチェックする。
			if (targetIndex != -1) {
				VRMap latestMap = (VRMap) getMedicalHistoryList().get(
						targetIndex); // 最後の履歴抽出
				reservedStart = (Date) VRBindPathParser.get(
						"MEDICAL_VALID_START", latestMap); // 最後の履歴の有効期間開始日
				reservedEnd = (Date) VRBindPathParser.get("MEDICAL_VALID_END",
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
						msgParam1 = "医療保険";
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
							getMedicalInfoValidLimit1().requestFocus();
							// 戻り値としてfalseを返す。
							return false;
						}

					} else {
						// 有効期間を自動で調整できない場合
						getMedicalInfoValidLimit1().requestFocus();
						QkanMessageList.getInstance()
								.QU003_ERROR_OF_DUPLICATE_IRYO();
						return false;
					}

				}

			}
		}

		// ・「給付割合(medicalInfoProvide)」
		// 選択されているかどうか。
		// ※エラーの場合、String：msgParamを宣言し、"給付割合"を代入する。
		if (getMedicalInfoProvide().isEnabled()) {
			if (!(getMedicalInfoProvide().isSelected())) {
				getMedicalInfoProvide().requestFocus();
				msgParam1 = "給付割合";
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
						msgParam1);
				return false;
			}
		}

		// 市町村番号
		// 入力されている場合のみチェック
		// 市町村番号-法別番号が入力されている場合
		if (getMedicalInfoCitiesLawNo().isEnabled()) {
			if (!ACTextUtilities.isNullText(getMedicalInfoCitiesLawNo()
					.getText())) {
				if (getMedicalInfoCitiesLawNo().getText().length() != 2) {
					getMedicalInfoCitiesLawNo().requestFocus();
					msgParam1 = "法別番号";
					msgParam2 = "2";
					QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
							msgParam2);
					return false;
				}
				if (ACTextUtilities.isNullText(getMedicalInfoCitiesNo()
						.getText())) {
					getMedicalInfoCitiesNo().requestFocus();
					msgParam1 = "市町村番号";
					QkanMessageList.getInstance()
							.ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
					return false;
				}
				//    	if(!(getMedicalInfoCitiesName().isSelected())){
				//    		getMedicalInfoCitiesName().requestFocus();
				//    		msgParam1 = "市町村名";
				//        	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
				//        	return false;
				//    	}
			}
		}

		// 市町村番号-保険者番号が入力されている場合
		if (getMedicalInfoCitiesNo().isEnabled()) {
			if (!ACTextUtilities.isNullText(getMedicalInfoCitiesNo().getText())) {
				if (ACTextUtilities.isNullText(getMedicalInfoCitiesLawNo()
						.getText())) {
					getMedicalInfoCitiesLawNo().requestFocus();
					msgParam1 = "市町村番号";
					QkanMessageList.getInstance()
							.ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
					return false;
				}
				if (getMedicalInfoCitiesLawNo().getText().length() != 2) {
					getMedicalInfoCitiesLawNo().requestFocus();
					msgParam1 = "法別番号";
					msgParam2 = "2";
					QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
							msgParam2);
					return false;
				}
				//    	if(!(getMedicalInfoCitiesName().isSelected())){
				//    		getMedicalInfoCitiesName().requestFocus();
				//    		msgParam1 = "市町村名";
				//        	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(msgParam1);
				//        	return false;
				//    	}
			}
		}

		// 市町村名が選択されている場合
		if (getMedicalInfoCitiesName().isEnabled()) {
			if (getMedicalInfoCitiesName().isSelected()) {
				if (ACTextUtilities.isNullText(getMedicalInfoCitiesLawNo()
						.getText())) {
					getMedicalInfoCitiesLawNo().requestFocus();
					msgParam1 = "市町村番号";
					QkanMessageList.getInstance()
							.ERROR_OF_NEED_CHECK_FOR_INPUT(msgParam1);
					return false;
				}
				if (getMedicalInfoCitiesLawNo().getText().length() != 2) {
					getMedicalInfoCitiesLawNo().requestFocus();
					msgParam1 = "法別番号";
					msgParam2 = "2";
					QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
							msgParam2);
					return false;
				}
			}
		}
		// 受給者番号
		// 入力されている場合のみチェック
		if (getMedicalInfoOldPersonReceiptNo().isEnabled()) {
			if (!ACTextUtilities.isNullText(getMedicalInfoOldPersonReceiptNo()
					.getText())) {
				if (getMedicalInfoOldPersonReceiptNo().getText().length() != 7) {
					getMedicalInfoOldPersonReceiptNo().requestFocus();
					msgParam1 = "受給者番号";
					msgParam2 = "7";
					QkanMessageList.getInstance().ERROR_OF_LENGTH(msgParam1,
							msgParam2);
					return false;
				}
			}
		}

		// 有効期間自動調整
		if (doUpdateFlg == 1) {

			// 自動調整確認メッセージで「OK」を選択した場合
			// kaigoInfoValidLimit1（有効期間開始日）の値を取得し、前日の値に変換する。
			Date changedDate = ACDateUtilities.addDay(start, -1);
			// 変換した値を、既にテーブルに登録されている要介護認定履歴のうち、
			// 重なっている認定の有効期間終了日に設定する。
			VRBindPathParser.set("MEDICAL_VALID_END",
					(VRMap) getMedicalHistoryList().get(targetIndex),
					changedDate);
		}

		// 入力エラーがなかった場合
		return true;

	}

	/**
	 * 「有効データの取得」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public VRMap getValidMedicalData() throws Exception {
		// 医療保険のデータのうち有効なデータのみ取得する。
		VRMap map = new VRHashMap();
		getMedicalInfos().setSource(map);

		// 入力されたデータをソースに流し込み、データを取得する。
		getMedicalInfos().applySource();

		if (!getMedicalInfoOld9AndOld8Radio().isEnabled()) {
			map.remove("OLD_RATE_FLAG");
		}

		if (!getMedicalInfoInsurerLawNo().isEnabled()) {
			map.remove("MEDICAL_LAW_NO");
		}

		if (!getMedicalInfoInsurerNo().isEnabled()) {
			map.remove("MEDICAL_INSURER_ID");
		}

		if (!getMedicalInfoMark().isEnabled()) {
			map.remove("MEDICAL_INSURE_ID");
		}

		if (!getMedicalInfoProvide().isEnabled()) {
			map.remove("BENEFIT_RATE");
		}

		if (!getMedicalInfoCitiesLawNo().isEnabled()) {
			map.remove("CITY_LAW_NO");
		}

		if (!getMedicalInfoCitiesNo().isEnabled()) {
			map.remove("CITY_INSURER_ID");
		}

		if (!getMedicalInfoOldPersonReceiptNo().isEnabled()) {
			map.remove("OLD_RECIPIENT_ID");
		}

		return map;
	}

	/**
	 * 「保存処理」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public boolean doSave() throws Exception {
		// 保存処理を行う。
		try {

			// トランザクション開始
			getDBManager().beginTransaction();

			// 画面上のデータを取得する。
			VRMap map = new VRHashMap();

			getPoint2().setSource(map);
			getPoint2().applySource();

			// 画面上にないデータを追加する。
			VRBindPathParser
					.set("PATIENT_ID", map, new Integer(getPatientId()));
			VRBindPathParser.set("STATION_HISTORY_ID", map, new Integer(
					STATION_HISTORY_ID));

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

				// （処理終了）
				return false;
			}

			// SQL文取得用
			VRMap param = null;
			String strSql = null;

			// 医療保険履歴の登録
			// 全館削除
			if (getMedicalDataFlg() == 1) {
				// medicalDataFlgが1の場合

				// SQL文取得のためのHashMap：paramを生成し、下記のKEYを設定する。
				// ・PATIENT_ID
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// 医療保険履歴（PATIENT_MEDICAL_HISTORY）の該当利用者のレコードを全件削除する。　※まだコミットしないこと。
				strSql = getSQL_DELETE_MEDICAL_HISTORY(param);
				getDBManager().executeUpdate(strSql);
			}

			// 登録
			if (!(getMedicalHistoryList() == null || getMedicalHistoryList()
					.size() == 0)) {
				for (int i = 0; i < getMedicalHistoryList().size(); i++) {
					// 医療保険履歴（PATIENT_MEDICAL_HISTORY）に画面上のデータ
					// （medicalHistoryList）を登録する。　※まだコミットしないこと。
					param = new VRHashMap();
					param = (VRMap) getMedicalHistoryList().get(i);

					strSql = getSQL_INSERT_MEDICAL_HISTORY(param);
					getDBManager().executeUpdate(strSql);
				}
			}

			// 訪問看護ステーション履歴の登録
			// 全件削除
			if (getStationDataFlg() == 1) {
				// stationDataFlgが1の場合
				// SQL文取得のためのHashMap：paramを生成し、下記のKEYを設定する。
				// ・PATIENT_ID
				param = new VRHashMap();
				VRBindPathParser.set("PATIENT_ID", param, new Integer(
						getPatientId()));

				// 訪問看護ステーション履歴（PATIENT_STATION_HISTORY）
				// の該当利用者のレコードを全件削除する。　※まだコミットしないこと。
				strSql = getSQL_DELETE_STATION_HISTORY(param);
				getDBManager().executeUpdate(strSql);
			}

			// 登録
			param = new VRHashMap();
			param = map;

			// 訪問看護ステーション履歴（PATIENT_MEDICAL_HISTORY）に
			// 画面上のデータを登録する。
			strSql = getSQL_INSERT_STATION_HISTORY(param);
			getDBManager().executeUpdate(strSql);

			// 利用者基本情報TBLの最終更新日時を更新する。
			param = new VRHashMap();
			VRBindPathParser.set("PATIENT_ID", param, new Integer(
					getPatientId()));
			strSql = getSQL_UPDATE_PATIENT_LAST_TIME(param);
			getDBManager().executeUpdate(strSql);

			// コミット
			// 上記のSQL発行処理に成功した場合
			// DB処理をコミットする。
			getDBManager().commitTransaction();

			// 下記のフラグを初期化する。
			// ・medicalTableChangeFlg
			// ・medicalDataFlg
			// ・stationDataFlg
			setMedicalTableChangeFlg(0);
			setMedicalDataFlg(0);
			setStationDataFlg(0);

			return true;

		} catch (Exception ex) {
			// 上記のSQL発行処理に失敗した場合
			// ロールバックする。
			getDBManager().rollbackTransaction();
			// 例外を投げる。
			// （終了）
			throw ex;
		}

	}

	/**
	 * 「レコード取得・画面設定」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public void doFind() throws Exception {
		// レコード取得・画面設定を行う。

		// 渡された利用者IDを用いて、利用者情報を取得する。
		VRList list = QkanCommon.getPatientInfo(getDBManager(), getPatientId());

		if (list == null || list.size() == 0) {
			// 利用者基本情報が取得できなかった場合		
			// 例外処理を行う。このロジックを通るのは当画面に遷移する間に利用者(PATIENT)が削除された場合であるため。	
			// エラーメッセージを表示する。	
			// ・メッセージID：ERROR_OF_PASSIVE_CHECK_ON_FIND
			QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();

			// 前画面に遷移する。
			setCompulsoryBackFlg(1);
			ACFrame.getInstance().back();
			return;

		}

		// パッシブキーに登録
		getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), list);

		// 取得した利用者情報より、以下のフィールドの値を取得する。
		// ・PATIENT_FAMILY_NAME
		// ・PATIENT_FIRST_NAME
		VRMap map = (VRMap) list.get(0);
		String familyName = ACCastUtilities.toString(VRBindPathParser.get(
				"PATIENT_FAMILY_NAME", map));
		String firstName = ACCastUtilities.toString(VRBindPathParser.get(
				"PATIENT_FIRST_NAME", map));

		// 上記の値を結合して、patientNameに表示する。
		getPatientName().setText(QkanCommon.toFullName(familyName, firstName));

		// DBより医療保険履歴を取得する。
		doFindMedical();

		// 医療保険履歴（medicalHistoryList）を医療保険テーブルモデル
		// （medicalTableModel）にセットする。
		getMedicalTableModel().setAdaptee(getMedicalHistoryList());

		// DBより訪問看護ステーション情報を取得する。
		doFindStation();

		// 訪問看護ステーション履歴（stationHistoryList）の最初のレコードを、
		// 「訪問看護療養費明細書情報登録領域（point2）」に設定する。
		// 画面に展開する。
		if (!(getStationHistoryList() == null || getStationHistoryList().size() == 0)) {
			getPoint2().setSource((VRMap) getStationHistoryList().get(0));
			getPoint2().bindSource();
		}

		// 業務ボタンの設定
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// 新規の場合（processModeが共通定数のPROCESS_MODE_INSERT）
			// 業務ボタンの状態設定を行う。
			// ･状態ID：INSERT_MODE
			setState_INSERT_MODE();
		} else {
			// 更新モード（processModeが共通定数のPROCESS_MODE_UPDATE）の場合
			// 業務ボタンの状態設定を行う。
			// ･状態ID：UPDATE_MODE
			setState_UPDATE_MODE();
		}

		if (getMedicalHistoryList() == null
				|| getMedicalHistoryList().size() == 0) {
			// 医療保険履歴テーブル（medicalInfoTable）のレコードが0件の場合

			// 医療保険情報領域の初期値作成
			VRMap defaultMap = (VRMap) getPoint1().createSource();
			// 領域のクリア
			getPoint1().setSource(defaultMap);
			getPoint1().bindSource();

			// Enable制御を行う。
			// ・状態ID：setState_ENABLE_OLD_RADIO_FALSE
			//    	setState_ENABLE_OLD_RADIO_FALSE();

			// ・状態ID：ENABLE_MEDICAL_BUTTON_FALSE
			setState_ENABLE_MEDICAL_BUTTON_FALSE();
		} else {
			// 医療保険履歴テーブル（medicalInfoTable）のレコードが1件以上の場合
			// テーブルの1列目を選択した状態にする。
			getMedicalInfoTable().setSelectedSortedFirstRow();
		}

		// フォーカス
		getMedicalInfoInsuranceVarietyRadio1().requestFocus();

		// スナップショット撮影。
		getSnapshot().snapshot();
		getSnapShotIryo().snapshot();

	}

	/**
	 * 「医療保険履歴を取得」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public void doFindMedical() throws Exception {
		// 医療保険履歴を取得する。

		// SQL文取得のためのHashMap：paramを生成し、下記のKEY/VALUEで設定する。
		// ・patientId/patientId
		VRMap param = new VRHashMap();
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

		// 医療保険履歴を取得する。
		// 取得したデータをmedicalHistoryListに格納する。
		String strSql = getSQL_GET_MEDICAL_HISTORY(param);
		setMedicalHistoryList(getDBManager().executeQuery(strSql));

		// レコードが1件以上の場合
		if (!(getMedicalHistoryList() == null || getMedicalHistoryList().size() == 0)) {

			// 画面テーブル表示用に編集する。
			toMedicalTableList(getMedicalHistoryList());

			// プロセスモード（processMode）に
			// 共通定数のPROCESS_MODE_UPDATEを代入する。
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

			// medicalDataFlgに1を代入する。
			setMedicalDataFlg(1);

		}

	}

	/**
	 * 「訪問看護ステーション履歴を取得」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public void doFindStation() throws Exception {
		// 訪問看護ステーション履歴を取得する。

		// SQL文取得のためのHashMap：paramを生成し、下記のKEY/VALUEで設定する。
		// ・patientId/patientId
		VRMap param = new VRHashMap();
		VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));

		// 訪問看護ステーション情報を取得する。
		// 取得したデータをstationHistoryListに格納する。
		String strSql = getSQL_GET_STATION_HISTORY(param);
		setStationHistoryList(getDBManager().executeQuery(strSql));

		if (!(getStationHistoryList() == null || getStationHistoryList().size() == 0)) {
			// レコードが1件以上の場合
			// プロセスモード（processMode）に
			// 共通定数のPROCESS_MODE_UPDATEを代入する。
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

			// stationDataFlgに1を代入する。
			setStationDataFlg(1);

		}

		//    // 訪問看護ステーション履歴（stationHistoryList）をパッシブチェック用に退避する。
		//    getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY_STATION(), getStationHistoryList());

	}

	/**
	 * 「画面初期化」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public void initialize() throws Exception {
		// 画面の初期化を行う。

		// 業務情報マスタより、データを取得する。
		// 取得したデータのウィンドウタイトル（WINDOW_TITLE）をウィンドウに設定する。
		// 取得したデータの業務タイトル（AFFAIR_TITLE）を業務ボタンバーに設定する。
		setAffairTitle(AFFAIR_ID, getButtons());

		// パッシブキーの定義
		setPASSIVE_CHECK_KEY(new ACPassiveKey("PATIENT",
				new String[] { "PATIENT_ID" }, new Format[] { null },
				"LAST_TIME", "LAST_TIME"));

		// テーブルモデルの定義
		// カラムの設定
		// "INSURE_TYPE" "SELF_FLAG" "MEDICAL_LAW_NO+MEDICAL_INSURER_ID"
		// "MEDICAL_INSURER_NAME" "MEDICAL_INSURE_ID" "MEDICAL_VALID_START"
		// "MEDICAL_VALID_END" "BENEFIT_RATE" "CITY_LAW_NO+CITY_INSURER_ID" 
		// "CITY_NAME" "OLD_RECIPIENT_ID"
		ACTableModelAdapter model = new ACTableModelAdapter();

		model.setColumns(new String[] { "INSURE_TYPE_NAME",
				"HONNIN_KAZOKU_NAME", "MEDICAL_LAW_NO+''+MEDICAL_INSURER_ID",
				"MEDICAL_INSURER_NAME", "MEDICAL_INSURE_ID",
				"MEDICAL_VALID_START", "MEDICAL_VALID_END", "BENEFIT_RATE",
				"CITY_LAW_NO+''+CITY_INSURER_ID", "CITY_INSURER_NAME",
				"OLD_RECIPIENT_ID" });

		setMedicalTableModel(model);

		// テーブル(medicalInfoTable)にmedicalTableModelをセットする。
		getMedicalInfoTable().setModel(getMedicalTableModel());

		// 各テーブルカラムにフォーマッタを設定する。
		//    // 保険種類
		//    getMedicalInfoTableColumn1().setFormat(new ACHashMapFormat(
		//			new String[] { "社保", "国保", "公費" }, 
		//			new Integer[] {new Integer(1), new Integer(2), new Integer(3), }));

		// 本人/家族
		//    getMedicalInfoTableColumn2().setFormat(new ACHashMapFormat(
		//			new String[] { "本人", "3歳", "家族" }, 
		//			new Integer[] {new Integer(1), new Integer(2), new Integer(3), }));

		// 給付割合
		getMedicalInfoTableColumn8().setFormat(
				new ACHashMapFormat(new String[] { "10割", "9割", "8割", "7割" },
						new Integer[] { new Integer(1), new Integer(2),
								new Integer(3), new Integer(4), }));

		// スナップショットの撮影対象を「訪問看護療養費明細書情報登録領域（point2）」設定する。
		getSnapshot().setRootContainer(getPoint2());

		// スナップショット（医療保険情報領域）
		getSnapShotIryo().setRootContainer(getMedicalInfos());

		// 画面設定を行う。
		casualInitialize();

	}

	/**
	 * 「画面設定」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public void casualInitialize() throws Exception {

		// VRMap mapを生成する。
		VRMap map = new VRHashMap();

		// 保険者情報を取得し、insurerListに格納する。
		setInsurerList(QkanCommon.getInsurerInfoMedicalOnly(getDBManager()));

		// insurerListの件数分ループする。
		if (!(getInsurerList() == null || getInsurerList().size() == 0)) {
			for (int i = 0; i < getInsurerList().size(); i++) {

				// insurerListに格納されているVRMapのKEY：INSURER_IDを取得する。
				Object insurerId = VRBindPathParser.get("INSURER_ID",
						(VRMap) getInsurerList().get(i));

				// 取得した保険者IDをMEDICAL_INSURER_IDにコピーする。
				VRBindPathParser.set("MEDICAL_INSURER_ID",
						(VRMap) getInsurerList().get(i), insurerId);
				// 取得した保険者IDをCITY_INSURER_IDにコピーする。
				VRBindPathParser.set("CITY_INSURER_ID",
						(VRMap) getInsurerList().get(i), insurerId);
			}
		}

		// 保険者情報を以下のKEYでmapに設定する。
		// ・KEY：MEDICAL_INSURER
		// ・KEY：CITY_INSURER
		VRBindPathParser.set("MEDICAL_INSURER", map, getInsurerList());
		VRBindPathParser.set("CITY_INSURER", map, getInsurerList());

		// 医療機関情報を取得し、medicalFacilityListに退避する。
		setMedicalFacilityList(QkanCommon
				.getMedicalFacilityInfo(getDBManager()));

		// 医療機関情報をmapに下記のKEYで設定する。
		// ・KEY：MEDICAL_FACILITY
		VRBindPathParser.set("MEDICAL_FACILITY", map, getMedicalFacilityList());

		// コードマスタデータの退避
		setMasterCode(QkanSystemInformation.getInstance().getMasterCode());

		// コードマスタデータよりCODE_ID：CODE_BENEFIT_RATEを取得する。
		// カラム：CONTENT_KEYのカラム名をBENEFIT_RATEに変換する。
		// 取得した割合の選択肢をmapに下記のKEYで設定する。
		// ・KEY：BENEFIT_RATE    
		VRBindPathParser.set("BENEFIT_RATE", map, QkanCommon
				.getArrayFromMasterCode(CODE_BENEFIT_RATE, "BENEFIT_RATE"));

		// mapを「クライアント領域（contents）」に設定する。
		getContents().setModelSource(map);

		// 画面に展開する。
		getContents().bindModelSource();

	}

	/**
	 * 「データ編集」に関する処理を行ないます。
	 * 医療保険情報をテーブル表示用に編集する関数です。
	 * @return VRList 医療保険情報（編集済）
	 * @param VRList 医療保険情報（1件）
	 * @throws Exception 処理例外
	 */
	public VRList toMedicalTableList(VRList list) throws Exception {
		// 渡された医療保険情報を画面テーブル表示用に編集する。		

		if (list == null) {
			// 渡されたデータがnullの場合		
			// 戻り値としてnullを返す。
			return null;
		} else {
			// 渡されたデータの件数分ループする。
			for (int i = 0; i < list.size(); i++) {
				// レコードを編集する。
				toMedicalTableList((VRMap) list.get(i));
			}
		}

		//戻り値としてlistを返す。
		return list;
	}

	/**
	 * 「データ編集」に関する処理を行ないます。
	 * 医療保険情報をテーブル表示用に編集する関数です。
	 * @return VRMap 医療保険情報（編集済）
	 * @param VRMap 医療保険情報（1件）
	 * @throws Exception 処理例外
	 */
	public VRMap toMedicalTableList(VRMap map) throws Exception {
		// 渡された医療保険情報を画面テーブル表示用に編集する。			

		VRMap temp = null;

		// 渡されたレコードのMEDICAL_INSURER_IDの値で、insurerListの
		// INSURER_IDを検索する。
		if (VRBindPathParser.has("MEDICAL_INSURER_ID", map)) {
			temp = new VRHashMap();
			temp = ACBindUtilities.getMatchRowFromValue(getInsurerList(),
					"INSURER_ID", VRBindPathParser.get("MEDICAL_INSURER_ID",
							map));
		}

		if (temp != null) {
			// 該当する保険者情報があった場合	
			// 該当する保険者情報のINSURER_NAMEを渡されたレコードに
			// KEY：MEDICAL_INSURER_NAMEで追加する。
			VRBindPathParser.set("MEDICAL_INSURER_NAME", map, VRBindPathParser
					.get("INSURER_NAME", temp));
		}

		// 渡されたレコードのCITY_INSURER_IDの値で、insurerListの
		// INSURER_IDを検索する。
		if (VRBindPathParser.has("CITY_INSURER_ID", map)) {
			temp = new VRHashMap();
			temp = ACBindUtilities.getMatchRowFromValue(getInsurerList(),
					"INSURER_ID", VRBindPathParser.get("CITY_INSURER_ID", map));
		}

		if (temp != null) {
			// 該当する保険者情報があった場合	
			// 該当する保険者情報のINSURER_NAMEを渡されたレコードに
			// KEY：CITY_INSURER_NAMEで追加する。
			VRBindPathParser.set("CITY_INSURER_NAME", map, VRBindPathParser
					.get("INSURER_NAME", temp));
		}

		// コードマスタより名称を取得
		VRList list = null;

		// 保険種類名称の追加
		list = new VRArrayList();
		list = (VRList) VRBindPathParser.get(new Integer(CODE_INSURE_TYPE),
				getMasterCode());
		if (VRBindPathParser.has("INSURE_TYPE", map)) {
			temp = new VRHashMap();
			temp = ACBindUtilities.getMatchRowFromValue(list, "CONTENT_KEY",
					VRBindPathParser.get("INSURE_TYPE", map));
			if (temp != null) {
				VRBindPathParser.set("INSURE_TYPE_NAME", map, VRBindPathParser
						.get("CONTENT", temp));
			}
		}

		// 本人/家族名称の追加
		list = new VRArrayList();
		list = (VRList) VRBindPathParser.get(new Integer(CODE_HONNIN_KAZOKU),
				getMasterCode());
		if (VRBindPathParser.has("SELF_FLAG", map)) {
			temp = new VRHashMap();
			temp = ACBindUtilities.getMatchRowFromValue(list, "CONTENT_KEY",
					VRBindPathParser.get("SELF_FLAG", map));
			if (temp != null) {
				VRBindPathParser.set("HONNIN_KAZOKU_NAME", map,
						VRBindPathParser.get("CONTENT", temp));
			}
		}

		// 戻り値としてmapを返す。		
		return map;
	}

	public Component getFirstFocusComponent() {
		return getMedicalInfoInsuranceVarietyRadio1();
	}
}
