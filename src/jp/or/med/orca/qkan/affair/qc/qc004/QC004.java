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
 * 作成日: 2006/01/06  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 訪問看護記録書Ⅰ (004)
 * プログラム 訪問看護記録書Ⅰ (QC004)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc004;

import java.awt.event.ActionEvent;
import java.text.Format;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 訪問看護記録書Ⅰ(QC004)
 */

public class QC004 extends QC004Event {
	/**
	 * コンストラクタです。
	 */
	public QC004() {
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
		// 渡りパラメーターを退避する。
		// patientId = PATIENT_ID
		// targetDate = TARGET_DATE

		VRMap parameters = affair.getParameters();

		if (VRBindPathParser.has("PATIENT_ID", parameters)) {
			setPatientId(ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID", parameters)));
		}

		if (VRBindPathParser.has("TARGET_DATE", parameters)) {
			setTargetDate(ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE", parameters)));
		}

		// 訪問看護の記録書ⅠTBL（HOMONKANGO_KIROKUSHO）のパッシブチェックキーを定義する。
		// テーブル：HOMONKANGO_KIROKUSHO
		// キー：PATIENT_ID,TARGET_DATE
		// フォーマット,数値,年月日
		// クライアントタイムフィールド：LAST_TIME
		// サーバータイムフィールド：LAST_TIME

		setPASSIVE_CHECK_KEY_KIROKUSHO(new ACPassiveKey("HOMONKANGO_KIROKUSHO", new String[] { "PATIENT_ID", "TARGET_DATE" }, new Format[] { null, new ACSQLSafeDateFormat("yyyy/M/d") }, "LAST_TIME", "LAST_TIME"));

		// スナップショットの撮影対象指定する。※撮影対象として「クライアント領域（contents）」を指定する。
		getSnapshot().setRootContainer(getContents());

		// 利用者情報を取得する。
		VRArrayList patientList = new VRArrayList();
		patientList = (VRArrayList) QkanCommon.getPatientInfo(getDBManager(), getPatientId());

		if (patientList.isEmpty()) {
			// レコードが取得出来なかった場合
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_FIND
			QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();
			// 渡しパラメーターを作成する。※KEY：NEXT_AFFAIR VALUE：QC004
			setParameter(parameters);
			// 「利用者一覧（QU001)｣に戻る。
			ACFrame.getInstance().back();
		}

		// レコードが取得できた場合
		// 取得したレコードをpatientMapに格納する。
		setPatientMap((VRMap) patientList.getData(0));

		// patientNameに利用者のフルネームを格納する。
		String patientName = QkanCommon.toFullName(ACCastUtilities.toString(getPatientMap().getData("PATIENT_FAMILY_NAME")), ACCastUtilities.toString(getPatientMap().get("PATIENT_FIRST_NAME")));

		// patientAgeにレコードの生年月日からシステム日付を基準にして年齢を算出した結果を格納する。
		int patientAge = QkanCommon.calcAge(ACCastUtilities.toDate(getPatientMap().getData("PATIENT_BIRTHDAY")));

		// patientMapに利用者のフルネームと年齢を下記のKEY/VALUEで設定する。
		// KEY：PATIENT_NAME VALUE：patientName
		// KEY：PATIENT_AGE VALUE：patientAge
		getPatientMap().setData("PATIENT_NAME", patientName);
		getPatientMap().setData("PATIENT_AGE", new Integer(patientAge));

		// 訪問看護記録書Ⅰ情報の取得を行う。
		doFindPassive();

		// 医療機関コンボボックスを表示する
		getMedicalFacilityInfo();

		// 利用者の登録している医療機関情報を取得する。
		// PROCESS_MODEが、共通定数の「PROCESS_MODE_INSERT(4)」だった場合
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {

			// 医療機関情報取得のため、HashMap：paramを作成し下記のパラメーターを設定する。
			VRHashMap param = new VRHashMap();
			// KEY：PATIENT_ID VALUE：patientId
			param.setData("PATIENT_ID", new Integer(getPatientId()));

			// 医療機関情報取得のためのSQL文を取得する。
			// 取得したSQL文を実行する。
			VRList hospitalList = getDBManager().executeQuery(getSQL_GET_PATIENT_STATION_HISTORY(param));
			
			// レコードが取得できた場合
			if (!hospitalList.isEmpty()) {
				// 取得レコード集合の1件目のレコードを退避する。
				VRMap hospitalMap = (VRMap) hospitalList.getData(0);
				// 取得したレコードをstationMapに格納する。
				setStationMap(hospitalMap);

				// kirokushoMapとstationMapをマージする。※取得した医療機関情報がマージされる。
				getKirokushoMap().putAll(getStationMap());

			} else {
				// レコードが取得できなかった場合
				// kirokushoMapに以下のKEY/VALUEを設定する。※利用者登録医療機関が存在しない場合、未選択状態にするためnullを設定。
				// KEY：PROVIDER_NAME VALUE：null
				VRHashMap defaultKirokushoMap = new VRHashMap();
				defaultKirokushoMap.setData("PROVIDER_NAME", null);
				setKirokushoMap(defaultKirokushoMap);
			}
		}

		// 医療機関情報を画面に展開する。
		// 訪問看護記録書Ⅰ情報（kirokushoMap）に利用者情報（patientMap）をマージする。
		getKirokushoMap().putAll(getPatientMap());

		// kirokushoMapを「クライアント領域（contents）｣にセットする。
		getContents().setSource(getKirokushoMap());

		// 画面に展開する。
		getContents().bindSource();

		// 業務情報マスタから、業務名を取得する。※画面ID = "QC004"
		// 取得したデータの「ウインドウタイトル（WINDOW_TITLE）」をウインドウに設定する。
		// 取得したデータの「業務タイトル（AFFAIR_TITLE）」を業務ボタンバーに設定する。
		setAffairTitle("QC004", getButtons());
		// スナップショットを撮影する。
		getSnapshot().snapshot();
	}

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // メッセージ判定フラグ
        int msgID;

        // 変更チェック（スナップショット）
        if (getSnapshot().isModified()) {
            // 変更されている場合
            // PROCESS_MODEの確認を行う。
            // PROCESS_MODEが、共通定数の「PROCESS_MODE_INSERT(4)」だった場合（登録モード）
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // 登録確認メッセージを表示する。※メッセージID = WARNING_OF_INSERT_ON_MODIFIED
                msgID = QkanMessageList.getInstance()
                        .WARNING_OF_INSERT_ON_MODIFIED();

                switch (msgID) {
                case ACMessageBox.RESULT_YES:
                    // 「更新して戻る」押下時
                    // 入力チェックを行う。
                    if (!doCheck()) {
                        // 入力エラーがある場合
                        // 処理を抜ける。
                        return false;
                    }

                    // 入力エラーがない場合
                    // 保存処理を行う。
                    if (doInsert()) {
                        // 保存処理が正常終了した場合
                        // 渡しパラメーターを作成する。※KEY：NEXT_AFFAIR VALUE：QC004
                        setParameter(parameters);

                        // 「利用者一覧（QU001）」画面に戻る。
                    } else {
                        // 保存処理が異常終了した場合
                        // 処理を抜ける。
                        return false;
                    }

                    break;

                case ACMessageBox.RESULT_NO:
                    // 「破棄して戻る」押下時
                    // 渡しパラメーターを作成する。※KEY：NEXT_AFFAIR VALUE：QC004
                    setParameter(parameters);
                    // 「利用者一覧（QU001）」画面に戻る。
                    return true;

                default:
                    // 「キャンセル」押下時
                    // 処理を抜ける。
                    return false;
                }

            } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // PROCESS_MODEが、共通定数の「PROCESS_MODE_UPDATE(3)」だった場合（更新モード）
                // 更新確認メッセージを表示する。※メッセージID = WARNING_OF_UPDATE_ON_MODIFIED
                msgID = QkanMessageList.getInstance()
                        .WARNING_OF_UPDATE_ON_MODIFIED();
                switch (msgID) {
                case ACMessageBox.RESULT_YES:
                    // 「更新して戻る」押下時
                    // 入力チェックを行う。
                    if (!doCheck()) {
                        // 入力エラーがある場合
                        // 処理を抜ける。
                        return false;
                    }
                    // 入力エラーがない場合
                    // 更新処理を行う。
                    if(doUpdate()){

                    // 保存処理が正常終了した場合
                    // 渡しパラメーターを作成する。※KEY：NEXT_AFFAIR VALUE：QC004
                    setParameter(parameters);

                    // 「利用者一覧（QU001）」画面に戻る。
                    }else{
                    // 保存処理が異常終了した場合
                    // 処理を抜ける。
                        return false;
                    }
                    break;

                case ACMessageBox.RESULT_NO:
                    // 「破棄して戻る」押下時
                    // 渡しパラメーターを作成する。※KEY：NEXT_AFFAIR VALUE：QC004
                    setParameter(parameters);

                    // 「利用者一覧（QU001）」画面に戻る。
                    return true;

                default:
                    // 「キャンセル」押下時
                    // 処理を抜ける。
                    return false;
                }
            }
        }
        return true;
    }

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// 変更チェック（スナップショット）
		if (getSnapshot().isModified()) {
			// 変更されている場合
			// 終了確認メッセージを表示する。

			if (QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED() == ACMessageBox.RESULT_OK) {
				// 「はい」押下時
				// 給管帳システムを終了する。
				return true;

			} else {
				// 「いいえ」押下時
				// 処理を抜ける。（処理を行わない）
				return false;
			}

		} else {
			// 変更されていない場合
			// 給管帳システムを終了する。
			return true;
		}
	}

	// コンポーネントイベント

	/**
	 * 「読込み処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void openActionPerformed(ActionEvent e) throws Exception {
		// 前月以前の訪問看護記録書Ⅰ情報の中で最新の情報を読込む。
		// 読込み確認を行う。※メッセージID = QC001_WARNING_ON_READ_OF_MOST_NEW_DATA
		if (QkanMessageList.getInstance().QC001_WARNING_ON_READ_OF_MOST_NEW_DATA() == ACMessageBox.RESULT_OK) {
			// 「OK｣押下時
			// 訪問看護記録書Ⅰ情報取得のためのSQL文を取得すためHashMap：paramを作成し、下記のKEY/VALUEを設定する。
			VRMap param = new VRHashMap();

			// KEY：PATIENT_ID VALUE：patientId
			// KEY：TARGET_DATE VALUE：targetDate
			param.setData("PATIENT_ID", new Integer(getPatientId()));
			param.setData("TARGET_DATE", ACDateUtilities.toFirstDayOfMonth(getTargetDate()));

			// SQL文を取得する。
			// 取得したSQL文を実行する。
			VRList lastKirokushoList = getDBManager().executeQuery(getSQL_GET_LAST_HOMONKANGO_KIROKUSHO(param));

			// レコードが取得できた場合
			if (!lastKirokushoList.isEmpty()) {
				// 取得した配列を、kirokushoMapに格納する。
				VRMap lastKirokushoMap = (VRMap) lastKirokushoList.getData(0);

				setKirokushoMap(lastKirokushoMap);
				// kirokushoMapを「クライアント領域（contents）」にセットする。
				getContents().setSource(getKirokushoMap());
				// 画面に展開する。
				getContents().bindSource();
//				 スナップショットを撮影する。
//				getSnapshot().snapshot();
			} else {
				// レコードが取得できなかった場合
				// メッセージを表示する。※メッセージID QC001_NOTICE_HAS_NO_LAST_DATA
				// 処理を抜ける。（何も行わない）
				QkanMessageList.getInstance().QC001_NOTICE_HAS_NO_LAST_DATA();
			}
		}
	}

	/**
	 * 「印刷処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void printActionPerformed(ActionEvent e) throws Exception {
		// 訪問看護記録書Ⅰの印刷を行う。
		// 以下の引数を渡し、印刷確認を行う。※メッセージID = WARNING_OF_PRINT
//		if (QkanMessageList.getInstance().WARNING_OF_PRINT("訪問看護記録書I") == ACMessageBox.RESULT_OK) {
		
		if(getSnapshot().isModified()){
			// 画面上のデータに変更がある場合は印刷前の保存確認メッセージを表示する。
            // メッセージ格納用
            int msgID = 0;

            // 変更があった場合
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // 登録用メッセージを作成する
                msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("登録",
                        "訪問看護記録書I");
            } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // 更新用メッセージIDを作成する
                msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("更新",
                        "訪問看護記録書I");
            }

            // 保存確認で「OK」以外が選択された場合、印刷処理を中断する。
            if (msgID != ACMessageBox.RESULT_OK) {
            	return;
            }

		}
		
		// 入力チェックを行う。
		// 入力エラーがない場合
		// 情報を保存する。
		if(!doSave()) {
			return;
		}

		// パッシブチェック用のデータを登録する。
		doFindPassive();

		// 画面上の情報をkirokushoMapに格納する。
		getContents().setSource(getKirokushoMap());
		getContents().applySource();

		// 印刷クラスへの渡りパラメータ(レコード) printParameterを生成する。
		VRMap printParameter = null;
		printParameter = new VRHashMap();

		// printParameterに、KirokushoMapの値をコピーする。
		printParameter = getKirokushoMap();

		// 印刷管理クラスを生成
		ACChotarouXMLWriter writer = new ACChotarouXMLWriter();

		// 印刷開始を宣言
		writer.beginPrintEdit();
		QC004P01 qc00401 = new QC004P01();
		QC004P02 qc00402 = new QC004P02();

		// 印刷する。
		// 訪問看護記録書ⅠのN0.1を作成する。
		// 訪問看護記録書IのNO.2を作成する。
		// 帳票を出力する。
		if (qc00401.doPrint(writer, printParameter) && qc00402.doPrint(writer, printParameter)) {

			// 生成された場合
			// 印刷終了を制限
			writer.endPrintEdit();

			// PDFファイルを生成して開く
			ACChotarouXMLUtilities.openPDF(writer);

		} else {
			// 生成されなかった場合
		}
//		}
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
		// 訪問看護記録書Ⅰ情報を保存する。
		// 入力チェックを行う。
		if (doCheck()) {
			// 「OK」押下時
			// 登録処理を行う。
			if (doSave()) {

				// パッシブチェック用のデータを登録する。
				doFindPassive();

				// 登録完了メッセージを表示する。※メッセージID = INSERT_SUCCESSED
				QkanMessageList.getInstance().INSERT_SUCCESSED();
				// 画面状態を変更する。
				setState_UPDATE_STATE();
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
		// 訪問看護記録書Ⅰ情報を更新する。
		// 入力チェックを行う。
		if (doCheck()) {
			if (doSave()) {
				// パッシブチェック用のデータを登録する。
				doFindPassive();

				// 更新完了メッセージを表示する。※メッセージID = UPDATE_SUCCESSED
				QkanMessageList.getInstance().UPDATE_SUCCESSED();
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
	protected void syujiMedicalNameActionPerformed(ActionEvent e) throws Exception {
		// 選択された｢医療機関(syujiMedicalName）｣の情報を表示する。
		// providerListに格納されている配列レコードの中から、選択された事業所のレコードをproviderMapに格納する。
		// ※以下、選択された事業所のことを「選択事業所」と呼称する。
		VRMap selectedMap = (VRMap) getSyujiMedicalName().getSelectedModelItem();

		if (!(selectedMap == null)) {
			setProviderMap(selectedMap);
			// ｢主治医領域（syujis）｣にproviderMapをセットする。
			getSyujis().setSource(getProviderMap());
			// 画面に展開する。
			getSyujis().bindSource();
		}
	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		param.setData("PATIENT_ID", new Integer(2));
		param.setData("TARGET_DATE", "2006/02/02");
		ACFrame.debugStart(new ACAffairInfo(QC004.class.getName(), param));
	}

	// 内部関数

	/**
	 * 「パッシブチェック用データ登録」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindPassive() throws Exception {
		// 訪問看護記録書Ⅰの情報を取得しパッシブキーを登録する。
		// 訪問看護記録書Ⅰ情報取得のため、HashMap：paramに下記のKEY/VALUEを設定する。
		VRMap param = new VRHashMap();
		// KEY：PATIENT_ID VALUE：patientId
		// KEY：TARGET_DATE VALUE：targetDate
		param.setData("PATIENT_ID", new Integer(getPatientId()));
		param.setData("TARGET_DATE", getTargetDate());

		// 訪問看護記録書Ⅰ情報取得のためのSQL文を取得する。
		// 取得したSQL文を実行する。

		VRList houmonKangoKirokushoList = getDBManager().executeQuery(getSQL_GET_HOMONKANGO_KIROKUSHO(param));

		if (!houmonKangoKirokushoList.isEmpty()) {
			// レコードが取得できた場合
			// PROCESS_MODEを、共通定数の「PROCESS_MODE_UPDATE(3)」に設定する。（更新モード）
			// 画面の状態を変更する。
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

			// 画面の状態をUPDATE_STATEに変更する。
			setState_UPDATE_STATE();

			// 取得したレコードをkirokushoListに格納する。
			setKirokushoList(houmonKangoKirokushoList);
			// 取得したレコードの最初のレコードをkirokushoMapに格納する。
			VRMap houmonKangoKirokushoMap = (VRMap) houmonKangoKirokushoList.getData(0);

			setKirokushoMap(houmonKangoKirokushoMap);

			// パッシブチェック用の比較データをキー（PASSIVE_CHECK_KEY_KIROKUSHO）で登録する。
			getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY_KIROKUSHO(), getKirokushoList());

			// 医療機関情報再取得処理
			getMedicalFacilityInfo();
			getContents().setSource(houmonKangoKirokushoMap);
			getContents().bindSource();
			// スナップショットを撮影する。
			getSnapshot().snapshot();

		} else {

			// レコードが取得できなかった場合
			// PROCESS_MODEを、共通定数の「PROCESS_MODE_INSERT(4)」に設定する。（登録モード）
			setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
			// 画面の状態をINSERT_STATEに変更する。
			setState_INSERT_STATE();
		}
	}

	/**
	 * 「保存処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doSave() throws Exception {
		// 訪問看護記録書Ⅰ情報を保存する処理
		// PROCESS_MODEをチェックする。
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// PROCESS_MODEが、共通定数の「PROCESS_MODE_INSERT(4)」だった場合
			// 登録処理を行う
			if (doInsert()) {
				return true;
			} else {
				return false;
			}
		} else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
			// PROCESS_MODEが、共通定数の「PROCESS_MODE_UPDATE(3)」だった場合（更新モード）
			// 更新処理を行う。
			if (doUpdate()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * 「登録処理を行う」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doInsert() throws Exception {
		// 訪問看護記録書Iの登録を行う処理
		try {
			// トランザクションを開始する。
			getDBManager().beginTransaction();
			// パッシブタスクをクリアする。
			getPassiveChecker().clearPassiveTask();

			// kirokushoMapに画面上の情報を格納する。
			getContents().setSource(getKirokushoMap());
			getContents().applySource();

			// kirokushoMapに下記のパラメーターを設定する。
			// KEY：PATIENT_ID VALUE：patientId
			// KEY：TARGET_DATE VALUE：targetDate
			getKirokushoMap().setData("PATIENT_ID", new Integer(getPatientId()));
			getKirokushoMap().setData("TARGET_DATE", getTargetDate());

			// パッシブタスクを登録する。
			getPassiveChecker().addPassiveInsertTask(getPASSIVE_CHECK_KEY_KIROKUSHO(), getKirokushoMap());

			// パッシブチェックを行う。
			if (getPassiveChecker().passiveCheck(getDBManager())) {
				// パッシブエラーがない場合
				// 初回訪問年月日の訪問時間（登録用）の設定を行う。
				// setFirstVisitTime();

				// 訪問看護記録書Ⅰ情報登録用の、SQL文を取得する。
				// 取得したSQL文を実行する。
				getDBManager().executeUpdate(getSQL_INSERT_KIROKUSHO(getKirokushoMap()));

				// SQL文実行処理でエラーが発生しなかった場合
				// 処理をコミットする。
				getDBManager().commitTransaction();

				// PROCESS_MODEを、共通定数の「PROCESS_MODE_UPDATE(3)」に設定する。（更新モード）
				setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

			} else {
				// パッシブエラーがある場合
				// エラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_FIND
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();
				// 処理を抜ける。（異常終了）
				getDBManager().beginTransaction();
				return false;
			}

		} catch (Exception ex) {
			// SQL文実行処理でエラーが発生した場合
			// 処理をロールバックする。
			getDBManager().rollbackTransaction();
			// 例外エラーを投げる。
			// 処理を抜ける。（異常終了）
			throw ex;
		}
		return true;
	}

	/**
	 * 「更新処理を行う」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doUpdate() throws Exception {
		// 訪問看護記録書Ⅰ情報の更新を行う。
		try {
			// トランザクションを開始する。
			getDBManager().beginTransaction();
			// パッシブタスクをクリアする。
			getPassiveChecker().clearPassiveTask();

			// kirokushoMapに画面上の情報を格納する。
			getContents().setSource(getKirokushoMap());
			getContents().applySource();

			// kirokushoMapに下記のパラメーターを設定する。
			// KEY：PATIENT_ID VALUE：patientId
			// KEY：TARGET_DATE VALUE：targetDate
			getKirokushoMap().setData("PATIENT_ID", new Integer(getPatientId()));
			getKirokushoMap().setData("TARGET_DATE", getTargetDate());

			// パッシブタスクを登録する。
			getPassiveChecker().addPassiveUpdateTask(getPASSIVE_CHECK_KEY_KIROKUSHO());

			// パッシブチェックを行う。
			if (getPassiveChecker().passiveCheck(getDBManager())) {
				// パッシブエラーがない場合
				// 訪問看護記録書Ⅰ情報更新用のSQL文を取得する。
				// 取得したSQL文を実行する。
				getDBManager().executeUpdate(getSQL_UPDATE_KIROKUSHO(getKirokushoMap()));

				// SQL実行処理でエラーがない場合
				// 処理をコミットする。
				getDBManager().commitTransaction();

			} else {
				// パッシブエラーがある場合
				// エラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_FIND
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();
				// 処理を抜ける。（異常終了）
				getDBManager().beginTransaction();
				return false;
			}

		} catch (Exception ex) {
			// SQL文実行処理でエラーがある場合
			// 処理をロールバックする。
			getDBManager().rollbackTransaction();
			// 処理を抜ける。（異常終了）
			throw ex;
		}
		return true;
	}

	/**
	 * 「渡しパラメーター作成」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void setParameter(VRMap parameters) throws Exception {
		// 利用者一覧画面で使用する渡しパラメーターの作成を行う。
		// affairMapに下記のKEY/VALUEを設定する。
		// KEY：NEXT_AFFAIR VALUE：QC004
		parameters.setData("NEXT_AFFAIR", "QC004");
		ACAffairInfo affair = new ACAffairInfo(QC004.class.getName(), parameters);
	}

	/**
	 * 「訪問開始時間・訪問終了時間入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doCheck() throws Exception {
		// 訪問開始時間・訪問終了時間の入力チェックを行う。
		// 訪問開始時間のチェックを行う。
		// 訪問終了時間のチェックを行う。
		if (doCheckStartTime() && doCheckEndTime()) {
			// 上記2つのチェックでエラーが発生しなかった場合trueを返す。
			return true;
		}
		return false;
	}

	/**
	 * 「訪問開始時間入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doCheckStartTime() throws Exception {
		// 初回訪問開始時間をチェックする処理
		// 初回訪問開始時間（firstVisitDateStartHour）が入力されているかチェックする。
		if (getFirstVisitDateStartHour().equals("")) {
			// 入力されていなかった場合
			// 以下の引数を渡し、エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("初回訪問年月日の訪問開始時間");
			// 初回訪問開始時間（firstVisitDateStartMinute）にフォーカスを当てる。
			getFirstVisitDateStartHour().requestFocus();
			// 処理を抜ける。（異常：未入力）
			return false;
		}
		return true;
	}

	/**
	 * 「訪問終了時間入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doCheckEndTime() throws Exception {
		// 訪問終了期間チェック処理
		// 初回訪問開始時間（firstVisitDateEndHour）が入力されているかチェックする。
		if (getFirstVisitDateEndHour().equals("")) {
			// 入力されていなかった場合
			// 以下の引数を渡し、エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("初回訪問年月日の訪問終了時間");
			// 初回訪問開始時間（firstVisitDateEndHour）にフォーカスを当てる。
			getFirstVisitDateEndHour().requestFocus();
			// 処理を抜ける。（異常：未入力）
			return false;
		}
		return true;
	}

	/**
	 * 「医療機関情報コンボセット」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void getMedicalFacilityInfo() throws Exception {
		// 医療機関の事業所情報を取得する
		// 医療機関の事業所情報を取得するためのSQL文を取得する。
		// 取得したSQL文を実行する。
		VRList hospitalList = getDBManager().executeQuery(getSQL_GET_MEDICAL_FACILITY(null));

		// レコードが取得できた場合
		if (!hospitalList.isEmpty()) {
			// 取得したレコード配列をproviderListに格納する。
			setProviderList(hospitalList);
			// 医療を提供している事業所情報を以下のKEYでmapに設定する。
			VRHashMap map = new VRHashMap();

			// KEY：MEDICAL_FACILITY_ID VALUE：providerList
			map.setData("MEDICAL_FACILITY_ID", getProviderList());

			// mapを「医療機関コンボ(syujiMedicalName)」に、設定する。
			getSyujiMedicalName().setModelSource(map);

			// 医療機関コンボにモデル（選択候補）を取り込む
			getSyujiMedicalName().bindModelSource();
		}
	}
}
