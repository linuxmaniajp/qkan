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
 * 作成日: 2006/01/19  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 老人訪問看護・訪問看護情報提供書 (003)
 * プログラム 老人訪問看護・訪問看護の情報提供書 (QC003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc003;

import java.awt.event.ActionEvent;
import java.text.Format;
import java.util.Date;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
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
 * 老人訪問看護・訪問看護の情報提供書(QC003)
 */
@SuppressWarnings("serial")
public class QC003 extends QC003Event {
    /**
     * コンストラクタです。
     */
    public QC003() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * 初期化処理を行ないます。
     * 
     * @param affair 業務情報
     * @throws Exception 処理例外
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        // 渡りパラメーターを退避する。
        VRMap parameters = affair.getParameters();
        // this.patientId = PATIENT_ID(利用者ID)
        setPatientId(ACCastUtilities.toInt(parameters.getData("PATIENT_ID")));
        // this.targetDate = TARGET_DATE(対象年月）
        setTargetDate((Date) parameters.getData("TARGET_DATE"));
        // パッシブチェックのキーを定義する。
        // テーブル:HOMONKANGO_JOHO_TEIKYOSHO
        // キー:PATIENT_ID, TARGET_DATE
        // フォーマット:null,日付
        // クライアントタイムフィールド:LAST_TIME
        // サーバタイムフィールド:LAST_TIME
        setPASSIVE_CHECK_JOHO_TEIKYOSHO(new ACPassiveKey(
                "HOMONKANGO_JOHO_TEIKYOSHO", new String[] { "PATIENT_ID",
                        "TARGET_DATE" }, new Format[] { null,
                        new ACSQLSafeDateFormat("yyyy/M/d") }, "LAST_TIME",
                "LAST_TIME"));

        setAffairTitle("QC003", getButtons());
        // 取得したデータの「ウインドウタイトル（WINDOW_TITLE）」をウインドウに設定する。
        // 取得したデータの「業務タイトル（AFFAIR_TITLE）」を業務ボタンバーに設定する。

        // 要介護度の初期値の設定
        getPatientYokaigodo().setSelectedIndex(1);
        
        // 画面の初期状態を設定する。
        setState_INSERT_STATE();

        // 強制戻り判別フラグの値の初期設定
        setForciblyBackCheckFlag(false);

        // 訪問看護の情報提供書情報（HOMONKANGO_JOHO_TEIKYOSHO）を取得する。
        doFindPassive();

    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // 強制戻りかチェックする。
        if (getForciblyBackCheckFlag()) {

            return true;
        }

        // 現在の利用者を選択状態にするためパラメーターを送る
        parameters.setData("PATIENT_ID", new Integer(getPatientId()));

        // 変更チェック（スナップショット）
        if (!getSnapshot().isModified()) {
            // 変更されていない場合
            // 渡しパラメータを作成する。※KEY：NEXT_AFFAIR VALUE：QC003
            return true;
        }

        // 「利用者一覧（QU001）」画面に戻る。※利用者一覧で識別するためパラメーターとして自画面の画面IDを渡す。
        // 更新されている場合

        int msgID = 0;
        // PROCESS_MODEの確認を行う。
        if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
            msgID = QkanMessageList.getInstance()
                    .WARNING_OF_INSERT_ON_MODIFIED();
        } else {
            msgID = QkanMessageList.getInstance()
                    .WARNING_OF_UPDATE_ON_MODIFIED();
        }
        // PROCESS_MODEが、共通定数の「PROCESS_MODE_INSERT（4）」だった場合（登録モード）
        // 登録確認メッセージを表示する。※メッセージID = WARNING_OF_INSERT_ON_MODIFIED
        switch (msgID) {
        // 「登録して戻る」押下時
        case ACMessageBox.RESULT_YES:
            // 入力チェックを行う。
            if (!doCheck()) {
                return false;
            }

            // 入力エラーがない場合
            // 保存処理を行う。
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                if (!doInsert()) {
                    return false;
                }
            } else {
                if (!doUpdate()) {
                    return false;
                }
            }

            // 保存処理が正常終了した場合
            // 渡しパラメータを作成する。※KEY：NEXT_AFFAIR VALUE：QC003
            return true;

        // 「利用者一覧（QU001）」画面に戻る。※利用者一覧で識別するためパラメーターとして自画面の画面IDを渡す。
        // 「破棄して戻る」押下時
        case ACMessageBox.RESULT_NO:

            return true;

        default:

            return false;

        }
    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // 終了処理
        // 変更チェック（スナップショット）
        if (!getSnapshot().isModified()) {
            // 最後に保存されてから、項目が変更されていない場合
            // 給付管理台帳システムを終了する。
            return true;
            
        }

        // 最後の保存されてから、項目が変更されている場合
        // 了確認メッセージを表示する。※メッセージID = WARNING_OF_UPDATE_ON_MODIFIED
        int msgID = QkanMessageList.getInstance()
                .WARNING_OF_CLOSE_ON_MODIFIED();

        if (msgID == ACMessageBox.RESULT_YES) {
            // 「はい」押下時
            // 給管帳システムを終了する。
            return true;
            
        } else {
            // 「いいえ」押下時
            // 処理を抜ける。
            return false;
            
        }

    }

    // コンポーネントイベント

    /**
     * 「読込み処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void openActionPerformed(ActionEvent e) throws Exception {

        // 前月以前のデータの中で最新のものを読込む処理
        // 読込み確認メッセージを表示する。メッセージID = QC001_WARNING_ON_READ_OF_MOST_NEW_DATA
        int msgID = QkanMessageList.getInstance()
                .QC001_WARNING_ON_READ_OF_MOST_NEW_DATA();
        // 「OK」ボタン押下時
        if (msgID == ACMessageBox.RESULT_OK) {
            // 前月以前の訪問看護の情報提供書情報のデータの中で最新の情報を取得する。
            // SQL文取得のためHashMap：paramを生成し、下記のKEY/VALUEを設定する。
            VRMap param = new VRHashMap();
            // KEY：PATIENT_ID VALUE：this.patientId
            // KEY：TARGET_DATE VALUE：targetDate
            param.setData("PATIENT_ID", new Integer(getPatientId()));
            param.setData("TARGET_DATE", (Date) getTargetDate());

            // 訪問看護の情報提供書情報取得のためのSQL文を取得する。
            // 取得したSQL文を実行する。
            VRList lastInfoList = getDBManager().executeQuery(
                    getSQL_GET_LAST_HOMONKANGO_JOHO_TEIKYOSHO(param));

            if (!lastInfoList.isEmpty()) {
                // レコードが取得できた場合
                // 取得した配列をjohoTeikyoshoMapに格納する。
                VRMap lastInfoMap = (VRMap) lastInfoList.getData(0);
                // 取得したレコードの中から下記のKEYを削除する。
                // KEY：JOHO_TEIKYO_SAKI
                // KEY：HOMON_KAISU_DAY
                // KEY：HOMON_KAISU_COUNT
                lastInfoMap.removeData("JOHO_TEIKYO_SAKI");
                lastInfoMap.removeData("HOMON_KAISU_DAY");
                lastInfoMap.removeData("HOMON_KAISU_COUNT");
                lastInfoMap.removeData("CREATE_DATE");
                
                // [ID:0000574][Masahiko Higuchi] 2010/01 add begin 2009年度対応 
                // 要介護度の認定チェック
                VRList patientNinteiHistory = QkanCommon
                        .getPatientInsureInfoOnEndOfMonth(getDBManager(),
                                getTargetDate(), getPatientId());
                if(patientNinteiHistory != null && patientNinteiHistory.size() >= 1){
                    // 当月の末の情報を取得する
                    VRMap history = (VRMap)patientNinteiHistory.getData(0);
                    lastInfoMap.setData("JOTAI_CODE",history.getData("JOTAI_CODE"));
                } else {
                    // 履歴が取得できないので、自立に設定
                    lastInfoMap.setData("JOTAI_CODE",new Integer(1));
                }
                // [ID:0000574][Masahiko Higuchi] 2010/01 add end

                // johoTeikyoshoMaoを「クライアント領域（contents）」にセットする。
                getContents().setSource(lastInfoMap);

                // contentsにデータを展開する。
                getContents().bindSource();

            } else {
                // 取得件数が0件の場合
                // 過去情報が存在しなかったことを通知するメッセージを表示する。※メッセージID =
                // QC001_NOTICE_HAS_NO_LAST_DATA
                QkanMessageList.getInstance().QC001_NOTICE_HAS_NO_LAST_DATA();
                // データの上書は行わない。
                return;

            }
        }
    }

    /**
     * 「登録処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // 訪問看護の情報提供書情報を登録する処理
        // 入力チェックを行う。
        // 入力エラーがない場合
        if (!doCheck()) {
            return;
        }

        // 訪問看護の情報提供書情報を保存する処理
        // PROCESS_MODEの確認を行う。
        if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
            // PROCESS_MODEが、共通定数の「PROCESS_MODE_INSERT(4)」だった場合（登録モード）
            // 登録処理を行う
            if (!doInsert()) {
                // エラーが発生した場合は処理を抜ける
                return;
            }
        } else {
            // 処理が矛盾している場合
            ACMessageBox.show("INSERTボタン　処理モードが矛盾");

        }

        // 登録完了メッセージを表示する。※メッセージID = INSERT_SUCCESSED
        QkanMessageList.getInstance().INSERT_SUCCESSED();

        // 画面状態を変更する。
        setState_UPDATE_STATE();

        // パッシブチェック情報を登録する。
        doFindPassive();

    }

    /**
     * 「更新処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {
        // 訪問看護の情報提供書情報を更新する
        // 入力チェックを行う。
        // 入力エラーがない場合
        if (!doCheck()) {
            // 処理を抜ける
            return;
        }

        // 訪問看護の情報提供書情報を保存する処理
        // PROCESS_MODEの確認を行う。
        if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
            // PROCESS_MODEが、共通定数の「PROCESS_MODE_UPDATE(3)」だった場合（更新モード）
            // 更新処理を行う
            if (!doUpdate()) {
                // エラーが発生した場合は処理を抜ける
                return;
            }

        } else {
            // 処理モードが矛盾している場合
            ACMessageBox.show("UPDATEボタン　処理モードが矛盾");
        }

        // 更新完了メッセージを表示する。※メッセージID = UPDATE_SUCCESSED
        QkanMessageList.getInstance().UPDATE_SUCCESSED();

        // パッシブチェック情報を登録する。
        doFindPassive();

    }

    /**
     * 「印刷処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void printActionPerformed(ActionEvent e) throws Exception {
        // 訪問看護情報提供書を印刷する処理
        // 入力チェックを行う。
        if (!doCheck()) {
            return;
        }

        // 入力エラーがない場合
        // 以下の引数を渡し、印刷確認メッセージを表示する。※メッセージID = WARNING_OF_PRINT
        // 変更があった場合
        int msgID = 0;

        if (getSnapshot().isModified()) {

            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // 登録用メッセージを作成する
                msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("登録",
                        "訪問看護計画書");
            } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // 更新用メッセージIDを作成する
                msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("更新",
                        "訪問看護計画書");
            }

        }

        // ｢OK」押下時
        if (msgID == ACMessageBox.RESULT_OK) {
            // 保存処理を行う。※保存処理に失敗した場合は処理を中断する。
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // 何らかのエラーがあった場合処理を中断する。
                if (!doInsert()) {
                    return;
                }

            } else {
                // 何らかのエラーがあった場合処理を中断する。
                if (!doUpdate()) {
                    return;
                }
            }

        } else {
            // キャンセルが選ばれた場合処理を中断する。
            return;

        }

        VRMap printParam = new VRHashMap();
        // 画面上の情報をprintParamに格納する。
        getContents().setSource(printParam);
        getContents().applySource();
        // 訪問看護の情報提供書を作成する。
        // dojPrint(QC00301, printParam);

        // 訪問看護の情報提供書を出力する。
        // 印刷管理クラスを生成
        ACChotarouXMLWriter writer = new ACChotarouXMLWriter();

        // 印刷開始を宣言
        writer.beginPrintEdit();

        // printParam.setData()
        QC003P01 qc003p01 = new QC003P01();

        // 印刷する。
        if (qc003p01.doPrint(writer, printParam)) {

            // 生成された場合
            writer.endPrintEdit();
            // PDFファイルを生成して開く
            ACChotarouXMLUtilities.openPDF(writer);

        } else {
            // 生成されなかった場合
            return;
        }

        doFindPassive();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();

        param.setData("PATIENT_ID", new Integer(38));
        param.setData("TARGET_DATE", new Date(106, 0, 1));
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QC003.class.getName(), param));
    }

    // 内部関数

    /**
     * 「パッシブチェック情報登録」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFindPassive() throws Exception {

        // 画面展開用のデータを格納する。
        VRMap copyPatientMap = new VRHashMap();

        VRList patientList = (VRList) QkanCommon.getPatientInfo(getDBManager(),
                getPatientId());

        // 利用者情報が取得出来たかチェックする
        if (patientList.size() > 0) {
            // 取得したデーターを格納する
            copyPatientMap.putAll((VRMap) patientList.getData(0));

        } else {
            int msgID = QkanMessageList.getInstance()
                    .ERROR_OF_PASSIVE_CHECK_ON_FIND();

            // エラー発生時強制戻り判別
            setForciblyBackCheckFlag(true);
            ACFrame.getInstance().back();
            return;
        }

        // 利用者要介護情報を取得する。
        VRList yokaigodoList = QkanCommon.getPatientInsureInfoOnEndOfMonth(
                getDBManager(), getTargetDate(), getPatientId());

        if (!(yokaigodoList == null || yokaigodoList.size() == 0)) {
            copyPatientMap.putAll((VRMap) yokaigodoList.getData(0));
        }

        
        // レコードが取得できた場合
        Date systemDate = QkanSystemInformation.getInstance().getSystemDate();

        copyPatientMap.setData("CREATE_DATE", systemDate);
        // patientMapに利用者基本情報を格納する。
        // patientNameに利用者のフルネームを格納する。
        // toFullName(PATIENT_FAMILY_NAME, PATIENT_FIRST_NAME);
        copyPatientMap.setData("PATIENT_FULL_NAME",
                QkanCommon.toFullName(
                copyPatientMap.getData("PATIENT_FAMILY_NAME"), copyPatientMap
                        .getData("PATIENT_FIRST_NAME")));

        copyPatientMap.setData("JOHO_TEIKYO_SAKI", "");
        // patientMapに、下記のKEY/VALUEを設定する
        // KEY：PATIENT_AGE VALUE：patientAge
        // KEY：PATIENT_NAME VALUE：patientName

        // ログイン事業所番号を取得し、以下のKEYでloginProviderMap（VRMap）に格納する。
        // KEY：PROVIDER_ID
        VRMap loginProviderMap = new VRHashMap();
        loginProviderMap.setData("PROVIDER_ID", QkanSystemInformation
                .getInstance().getLoginProviderID());

        // ※事業所のサービス詳細情報を取得
        VRList johoList = new VRArrayList();

        johoList = getJohoteikyoshoInfo();

        // レコードが取得できた場合
        if (!johoList.isEmpty()) {
            // 取得した配列をjohoTeikyoshoListに格納する。
            // johoTeikyoshoListの最初のレコードをjohoTeikyoshoMapに格納する。
            copyPatientMap.putAll((VRMap) johoList.getData(0));
        }

        if (johoList.size() > 0) {
            // PROCESS_MODEを、共通定数の「PROCESS_MODE_UPDATE(3)」に設定する。（更新モード）
            setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
            // 画面状態を変更する。
            setState_UPDATE_STATE();
        } else {
            // レコードが取得できなかった場合
            // PROCESS_MODEを、共通定数の「PROCESS_MODE_INSERT(4)」に設定する。（登録モード）
            setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
            // 画面状態を変更する。
            setState_INSERT_STATE();
        }

        // 取得した情報を画面に設定する
        getContents().setSource(copyPatientMap);
        // 画面に展開する。
        getContents().bindSource();
        // パッシブタスクをクリアする。
        getPassiveChecker().clearPassiveTask();
        // パッシブキーを登録する。
        getPassiveChecker().reservedPassive(getPASSIVE_CHECK_JOHO_TEIKYOSHO(),
                copyPatientMap);
        // スナップショットの撮影対象を指定する。
        getSnapshot().setRootContainer(getContents());
        // スナップショットを撮影する。
        getSnapshot().snapshot();
    }

    /**
     * 「登録処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean doInsert() throws Exception {
        // 訪問看護情報提供書情報を登録する処理
        VRMap applyMap = new VRHashMap();

        // 画面上のデータを取得する。
        getContents().setSource(applyMap);
        getContents().applySource();

        // KEY：PATIENT_ID VALUE：patientId
        // KEY：TARGET_DATE VALUE：targetDate
        applyMap.setData("PATIENT_ID", new Integer(getPatientId()));
        applyMap.setData("TARGET_DATE", (Date) getTargetDate());

        // トランザクションを開始する
        try {
            getDBManager().beginTransaction();
            // パッシブタスクをクリアする。
            getPassiveChecker().clearPassiveTask();
            // パッシブタスクを登録する。
            getPassiveChecker().addPassiveInsertTask(
                    getPASSIVE_CHECK_JOHO_TEIKYOSHO(), applyMap);
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                //テーブルロック解除のためロールバック
                getDBManager().rollbackTransaction();
                // パッシブエラーがある場合
                // パッシブエラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // 処理を中断する。(異常終了)
                return false;
            }
            // パッシブエラーがない場合
            // 訪問看護の情報提供書情報登録用の、SQL文を取得する。
            // 取得したSQL文を実行する。
            getDBManager()
                    .executeUpdate(getSQL_INSERT_JOHO_TEIKYOSHO(applyMap));

            // SQL文実行処理で、エラーがない場合
            // 処理をコミットする。
            getDBManager().commitTransaction();
            // PROCESS_MODEを、共通定数の「PROCESS_MODE_UPDATE(3)」に設定する。（更新モード）
            setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
            // 画面状態を変更する。
            setState_UPDATE_STATE();
            // スナップショットを撮影する。
            getSnapshot().snapshot();

            return true;

        } catch (Exception sqlEx) {
            // SQL文実行処理でエラーがある場合
            sqlEx.printStackTrace();
            // 処理をロールバックする。
            getDBManager().rollbackTransaction();
            // 例外エラーを投げる
            throw sqlEx;
        }
    }

    /**
     * 「更新処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean doUpdate() throws Exception {
        VRMap applyMap = new VRHashMap();
        // 画面の情報を取得する
        getContents().setSource(applyMap);
        getContents().applySource();

        // KEY：PATIENT_ID VALUE：patientId
        // KEY：TARGET_DATE VALUE：targetDate
        applyMap.setData("PATIENT_ID", new Integer(getPatientId()));
        applyMap.setData("TARGET_DATE", (Date) getTargetDate());

        // 訪問看護情報提供書情報を更新する処理
        try {
            // トランザクションを開始する
            getDBManager().beginTransaction();
            // パッシブタスクをクリアする。
            getPassiveChecker().clearPassiveTask();
            // パッシブタスクを登録する。
            getPassiveChecker().addPassiveUpdateTask(
                    getPASSIVE_CHECK_JOHO_TEIKYOSHO());
            // パッシブチェックを行う。
            // パッシブエラーがない場合

            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                //テーブルロック解除のためロールバック
                getDBManager().rollbackTransaction();
                // パッシブエラーがある場合
                // パッシブエラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // 処理を中断する。(異常終了)
                return false;
            }

            // 訪問看護の情報提供書情報更新用SQL文を取得する。
            // 取得したSQL文を実行する。
            getDBManager()
                    .executeUpdate(getSQL_UPDATE_JOHO_TEIKYOSHO(applyMap));

            // SQL文実行処理で、エラーがない場合
            // 処理をコミットする。
            getDBManager().commitTransaction();

            // スナップショットを撮影する。
            getSnapshot().snapshot();

            return true;

        } catch (Exception sqlEx) {
            // SQL文実行処理で、エラーがある場合
            sqlEx.printStackTrace();
            // 処理をロールバックする。
            getDBManager().rollbackTransaction();
            // 例外エラーを投げる
            // 処理を抜ける。
            throw sqlEx;

        }

    }

    /**
     * 「入力チェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean doCheck() throws Exception {
        // 入力チェックを行う処理
        // 下記のテキストフィールドに正しい値が入力されているかチェックする。
        // ・実施日（resultDay）が入力されているかチェックする。
        if (ACTextUtilities.isNullText(getResultDay().getText())) {
            // 入力されていなかった場合
            // エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("実施日");

            getResultDay().requestFocus();
            // 処理を抜ける。（処理を中断する）
            return false;
        }

        // ・実施日（resultDay）の値をチェックする。
        // 値が不正だった場合
        if (!getResultDay().isValidDate()) {
            // 以下の引数を渡し、エラーメッセージを表示する。※メッセージID = ERROR_OF_WRONG_DATE 引数 = 実施日
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("実施日");
            // エラーが発生したインスタンスにフォーカスを当てる。
            getResultDay().requestFocus();
            return false;
            // 処理を中断する。
        }
        return true;

    }

    /**
     * 「渡しパラメーター作成」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void setParameter() throws Exception {
        // affairMapに、下記のKEY/VALUEを設定する。
        // KEY：NEXT_AFFAIR VALUE：QC003

    }

    /**
     * 訪問看護の情報提供書情報取得に関する処理を行います。
     * 
     * @throws Exception
     */
    public VRList getJohoteikyoshoInfo() throws Exception {

        VRMap param = new VRHashMap();
        // 訪問看護の情報提供書情報を取得する処理
        // SQL文取得のためHashMap：paramを生成し、下記のKEY/VALUEを設定する。
        param = new VRHashMap();
        // KEY：PATIENT_ID VALUE：this.patientId
        param.setData("PATIENT_ID", new Integer(getPatientId()));
        // KEY：TARGET_DATE VALUE：taragetDate
        param.setData("TARGET_DATE", (Date) getTargetDate());
        // 訪問看護の情報提供書情報取得のためのSQL文を取得する。
        // 取得したSQL文を実行する。
        VRList johoList = getDBManager().executeQuery(
                getSQL_GET_HOMONKANGO_JOHO_TEIKYOSHO(param));

        return johoList;
    }

}
