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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/01/14  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 報告書情報入力 (002)
 * プログラム 報告書情報入力 (QC002)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc002;

import java.awt.event.ActionEvent;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRDateFormat;
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
 * 報告書情報入力(QC002)
 */
@SuppressWarnings("serial")
public class QC002 extends QC002Event {
    /**
     * コンストラクタです。
     */
    public QC002() {
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
        // 渡りデータの取得/前画面「利用者一覧」から渡されたパラメータを退避する。
        VRMap parameters = affair.getParameters();
        // this.patientID = PATIENT_ID(利用者ID)
        if (VRBindPathParser.has("PATIENT_ID", parameters)) {
            setPatientID(Integer.parseInt(String.valueOf(VRBindPathParser.get(
                    "PATIENT_ID", parameters))));
        }
        // this.targetDateSource = TARGET_DATE(対象年月)
        if (VRBindPathParser.has("TARGET_DATE", parameters)) {
            setTargetDateSource((Date) VRBindPathParser.get("TARGET_DATE",
                    parameters));
        }
        // 「訪問看護報告書TABLE(HOMONKANGO_RESULT)」のパッシブチェックのキーを定義する。
        // テーブル:HOMONKANGO_RESULT
        // キー:PATIENT_ID, TARGET_DATE
        // フォーマット:数値,年月日
        // クライアントタイムフィールド:LAST_TIME
        // サーバタイムフィールド:LAST_TIME
        setPASSIVE_CHECK_KEY_RESULT(new ACPassiveKey("HOMONKANGO_RESULT",
                new String[] { "PATIENT_ID", "TARGET_DATE" }, new Format[] {
                        null, new ACSQLSafeDateFormat("yyyy/M/d") },
                "LAST_TIME", "LAST_TIME"));
        // 「訪問看護計画書・訪問日TABLE(HOMONKANGO_RESULT_CALENDAR)」(当月分)のパッシブチェックのキーを定義する。
        // テーブル:HOMONKANGO_RESULT_CALENDAR
        // キー:PATIENT_ID, NOTE_ID
        // フォーマット:数値,年月日
        // クライアントタイムフィールド:LAST_TIME
        // サーバタイムフィールド:LAST_TIME
        setPASSIVE_CHECK_KEY_CALENDAR_LEFT(new ACPassiveKey(
                "HOMONKANGO_RESULT_CALENDAR", new String[] { "PATIENT_ID",
                        "VISIT_DATE" }, new Format[] { null,
                        new ACSQLSafeDateFormat("yyyy/M/d") }, "LAST_TIME",
                "LAST_TIME"));
        // 「訪問看護計画書・訪問日TABLE(HOMONKANGO_RESULT_CALENDAR)」(翌月分)のパッシブチェックのキーを定義する。
        // テーブル:HOMONKANGO_RESULT_CALENDAR
        // キー:PATIENT_ID, NOTE_ID
        // フォーマット:数値,年月日
        // クライアントタイムフィールド:LAST_TIME
        // サーバタイムフィールド:LAST_TIME
        setPASSIVE_CHECK_KEY_CALENDAR_RIGHT(new ACPassiveKey(
                "HOMONKANGO_RESULT_CALENDAR", new String[] { "PATIENT_ID",
                        "VISIT_DATE" }, new Format[] { null,
                        new ACSQLSafeDateFormat("yyyy/M/d") }, "LAST_TIME",
                "LAST_TIME"));
        // 表示する対象年月を作成する処理
        Date from = getTargetDateSource();
        // フォーマットを定義する
        VRDateFormat fr = new VRDateFormat("ggge年M月");

        // フォーマットを適用したデータを変数に格納する
        String createDate = fr.format(from);

        getTargetDate().setText(createDate);

        // 画面の初期化を行う。
        doInitialize();

        // スナップショットの撮影対象を指定する。
        getSnapshot().setRootContainer(getContents());

        // DBからデータを取得する。
        doFind();

    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }

        parameters.setData("PATIENT_ID", new Integer(getPatientID()));

        // 強制戻りであるか判別
        if (getForciblyBackCheckFlag()) {
            return true;
        }

        // ※スナップショットチェック
        // スナップショットの更新チェックを行う。
        if (!getSnapshot().isModified()) {
            // 更新されていない場合
            // 前画面に戻る。
            return true;
        }

        // 更新されている場合
        // 処理を継続する。
        // ※保存確認
        // ※表示メッセージの決定
        // 表示メッセージID格納用の数値型変数 msgID を定義する。
        int msgID = 0;
        // processModeの値をチェックする。
        if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
            // PROCESS_MODE_INSERT(登録)の場合
            // msgIDに、WARNING_OF_INSERT_ON_MODIFIEDを設定する。
            msgID = QkanMessageList.getInstance()
                    .WARNING_OF_INSERT_ON_MODIFIED();
        } else {
            // PROCESS_MODE_UPDATE(更新)の場合
            // msgIDに、WARNING_OF_UPDATE_ON_MODIFIEDを設定する。
            msgID = QkanMessageList.getInstance()
                    .WARNING_OF_UPDATE_ON_MODIFIED();
        }

        // ※確認メッセージの表示
        // 保存確認のメッセージを表示する。※メッセージIDはmsgIDの値
        // showMsg(msgID);
        switch (msgID) {
        case ACMessageBox.RESULT_YES:
            // 「更新して戻る」選択時
            // 処理を継続する。
            break;

        case ACMessageBox.RESULT_NO:
            // 「破棄して戻る」選択時
            // 前画面に戻る。
            return true;

        case ACMessageBox.RESULT_CANCEL:
            // 「キャンセル」選択時
            // 処理を中断する。
            return false;
        }

        // ※入力チェック
        // 入力チェックを行う。
        if (!checkValidInput()) {
            // エラーがある場合
            // 処理を中断する。
            return false;
        }
        // エラーがない場合
        // 処理を継続する。

        // ※保存処理
        // 保存処理を行う。
        // 処理モードを判別する
        if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
            // 登録モードだった場合
            if (!doInsert()) {
                // 何らかのエラーが発生した場合
                return false;
            }
        } else {
            // 更新モードだった場合
            if (!doUpdate()) {
                // 何らかのエラーが発生した場合
                return false;
            }
        }

        // 保存処理が正常終了した場合
        // 前画面に戻る。
        return true;
        // 保存処理が異常終了した場合
        // 処理を中断する。

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
        // 終了確認のメッセージを表示する。※メッセージID = WARNING_OF_CLOSE_ON_MODIFIED
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
     * 「印刷処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void printActionPerformed(ActionEvent e) throws Exception {
        // ※印刷処理

        // 作成年月日の入力チェックを行う
        if (!checkValidInput()) {
            // 何も行わない
            return;
        }

        // 変更判別フラグ true : 変更有り false : 変更無し
        boolean changeFlag = false;

        // 画面状態に変更があるかチェックする
        if (getSnapshot().isModified()) {
            changeFlag = true;
        }

        if (changeFlag) {
            // メッセージ格納用
            int msgID = 0;

            // 変更があった場合
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // 登録用メッセージを作成する
                msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("登録",
                        "訪問看護計画書");
            } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // 更新用メッセージIDを作成する
                msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("更新",
                        "訪問看護計画書");
            }

            // 保存確認
            if (msgID == ACMessageBox.RESULT_OK) {

                // OK押下時
                if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                    // 登録処理を行う 何らかのエラーが発生した場合は中断
                    if (!doInsert()) {
                        return;
                    }
                } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                    // 更新処理を行う 何らかのエラーが発生した場合は中断
                    if (!doUpdate()) {
                        return;
                    }
                }

                // 保存しない場合
            } else {

                // 何も行わない
                return;
            }

        } else {

            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // 登録処理を行う 何らかのエラーが発生した場合は中断
                if (!doInsert()) {
                    return;
                }
            } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // 更新処理を行う 何らかのエラーが発生した場合は中断
                if (!doUpdate()) {
                    return;
                }
            }
        }

        // 印刷クラスへの渡りパラメータ(レコード) printParamを生成する。
        VRMap printParam = new VRHashMap();
        // 基本情報を格納する
        VRMap houkokusyoInfo = new VRHashMap();
        // カレンダー情報を格納する
        VRMap calendarMap = new VRHashMap();

        // printParamに、画面から抽出した情報を格納する。
        getContents().setSource(houkokusyoInfo);
        getContents().applySource();

        // カレンダー情報を取得し格納する
        getCalendars().setSource(calendarMap);
        getCalendars().applySource();

        // printクラスで使用するデータを格納する。
        houkokusyoInfo.setData("PRINT_CALENDAR_LEFT_MONTH",
                getTargetDateSource());
        houkokusyoInfo.setData("PRINT_CALENDAR_RIGHT_MONTH", ACDateUtilities
                .addMonth(getTargetDateSource(), 1));
        calendarMap.removeData("CALENDAR_LEFT_YEAR");
        calendarMap.removeData("CALENDAR_LEFT_MONTH");
        calendarMap.removeData("CALENDAR_RIGHT_YEAR");
        calendarMap.removeData("CALENDAR_RIGHT_MONTH");

        // printParamに格納する
        printParam.setData("HOUKOKUSYO_INFO", houkokusyoInfo);
        printParam.setData("CALENDAR", calendarMap);

        // 印刷する。
        // doPrint(QC00201, printParam);
        ACChotarouXMLWriter writer = new ACChotarouXMLWriter();

        // 印刷開始を宣言
        writer.beginPrintEdit();

        // 印刷クラス生成
        QC002P01 qc002p01 = new QC002P01();

        // 印刷する。
        if (qc002p01.doPrint(writer, printParam)) {

            // 生成された場合
            // 印刷終了を宣言
            writer.endPrintEdit();

            // PDFファイルを生成して開く
            ACChotarouXMLUtilities.openPDF(writer);

        } else {
            // 生成されなかった場合
        }

        doFind();

    }

    /**
     * 「直近の訪問看護報告書情報の読込」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void openActionPerformed(ActionEvent e) throws Exception {
        // ※処理実行確認
        // 処理実行の確認のため、メッセージを表示する。※メッセージID =
        // QC001_WARNING_ON_READ_OF_MOST_NEW_DATA
        int msgID = QkanMessageList.getInstance()
                .QC001_WARNING_ON_READ_OF_MOST_NEW_DATA();

        // ｢OK」選択時
        // 処理を継続する。
        if (msgID == ACMessageBox.RESULT_CANCEL) {
            // 「キャンセル」選択時
            // 処理を中断する。
            return;
        }
        // ※過去の直近の情報を取得
        VRMap sqlParam = new VRHashMap();
        // SQL文取得関数への渡りパラメータ(レコード) sqlParamに下記パラメータを設定する。
        // KEY : PATIENT_ID, VALUE : patientID (退避した渡りパラメータ)
        sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
        // KEY : TARGET_DATE, VALUE : targetDateSource (退避した渡りパラメータ)
        sqlParam.setData("TARGET_DATE", getTargetDateSource());

        // 過去の訪問看護報告書情報のうち、最新の情報を取得するためのSQL文を取得する。
        // 取得したSQL文を発行する。
        VRList lastHoukokusyo = getDBManager().executeQuery(
                getSQL_GET_LAST_RESULT(sqlParam));
        VRMap lastHoukokusyoMap = new VRHashMap();

        if (lastHoukokusyo.size() > 0) {
            // 取得件数が0件より多い場合
            // 取得レコード集合の1件目のレコードを退避する。
            VRMap map = (VRMap) lastHoukokusyo.getData(0);

            lastHoukokusyoMap.putAll(map);

            Date leftDate = (Date) map.getData("TARGET_DATE");
            Date rightDate = ACDateUtilities.addMonth(leftDate, 1);
            // 画面展開用のデータを作成する。
            lastHoukokusyoMap.putAll(createBindData(leftDate, "LEFT"));
            lastHoukokusyoMap.putAll(createBindData(rightDate, "RIGHT"));

            // [ID:0000574][Masahiko Higuchi] 2010/01 add begin 2009年度対応 
            // 要介護度の認定チェック 
            VRList patientNinteiHistory = QkanCommon
                    .getPatientInsureInfoOnEndOfMonth(getDBManager(),
                            getTargetDateSource(), getPatientID());
            if(patientNinteiHistory != null && patientNinteiHistory.size() >= 1){
                // 当月の末の情報を取得する
                VRMap history = (VRMap)patientNinteiHistory.getData(0);
                lastHoukokusyoMap.setData("JOTAI_CODE",history.getData("JOTAI_CODE"));
            } else {
                // 履歴が取得できないので、自立に設定
                lastHoukokusyoMap.setData("JOTAI_CODE",new Integer(1));
            }
            // [ID:0000574][Masahiko Higuchi] 2010/01 add end
            
            // カレンダー情報の初期値を設定する
            initializeCalendar();
            // 画面に前月情報を展開する
            getContents().setSource(lastHoukokusyoMap);
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

    /**
     * 「登録処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // ※データをDBに登録
        // ※入力チェック
        // 入力チェックを行う。
        if (!checkValidInput()) {
            // エラーがある場合
            // 処理を中断する。
            return;
        }

        // エラーがない場合
        // 処理を継続する。
        // ※登録処理
        // 登録処理を行う。
        if (!doInsert()) {
            return;
        }

        // 処理完了通知メッセージを表示する。※メッセージID = UPDATE_SUCCESSED
        QkanMessageList.getInstance().INSERT_SUCCESSED();

        // 画面の初期化を行う。
        doInitialize();

        // 検索処理を行う。
        doFind();

    }

    /**
     * 「更新処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {
        // ※データをDBに更新
        // ※入力チェック
        // 入力チェックを行う。
        if (!checkValidInput()) {
            // エラーがある場合
            // 処理を中断する。
            return;
        }

        // エラーがない場合
        // 処理を継続する。
        // ※更新処理
        // 更新処理を行う。
        if (!doUpdate()) {
            return;
        }

        // 処理完了通知メッセージを表示する。※メッセージID = UPDATE_SUCCESSED
        QkanMessageList.getInstance().UPDATE_SUCCESSED();

        // 画面の初期化を行う。
        doInitialize();

        // 検索処理を行う。
        doFind();

    }

    /**
     * 「選択事業所の管理者氏名の設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void providerNameActionPerformed(ActionEvent e) throws Exception {
        // コンボに入力されている事業所名から、その事業所の「管理者氏名(ADMINISTRATOR_NAME)」(文字列)を取得する。
        Object a = getProviderName().getSelectedItem();

        if (getProviderName().getSelectedIndex() >= 0) {
            // getAdministratorName((コンボの選択アイテムのレコード));
            // 画面の「管理者氏名(administratorName)」に、取得した文字列を設定する。

            String adName = "";

            // 管理者氏名を取得する
            adName = String.valueOf(getAdministratorName((VRMap) getProviderName()
                    .getSelectedModelItem()));

            // テキストエリアにセット
            getAdministratorName().setText(adName);

        }
    }

    /**
     * 「訪問日情報（左）を展開する処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void resultReadButtonLeftActionPerformed(ActionEvent e)
            throws Exception {
        // 訪問日情報（左）を展開する処理

        VRDateFormat vf = new VRDateFormat("ggge年M月");

        String message = String.valueOf(vf.format(getTargetDateSource()) + "度");

        int msgID = QkanMessageList.getInstance().QC002_WARNING_OF_RESULT(
                message);

        if (msgID == ACMessageBox.RESULT_YES) {
            // 内部変数 leftMap を生成する。
            VRMap leftMap = new VRHashMap();

            // leftMapに実績を取得する
            leftMap = getVisitDataFromService(getTargetDateSource(), "LEFT");

            // 実績が読込めなかった場合
            if (leftMap.isEmpty()) {
                QkanMessageList.getInstance().QC002_ERROR_OF_RESULT();
                return;
            }

            // カレンダーを初期化する
            initializeCalendar(true, false);
            // calendarRightDayContainer に applyMap をセットする。
            getCalendarLeftDayContainer().setSource(leftMap);
            // 画面に展開する。
            getCalendarLeftDayContainer().bindSource();
        }

    }

    /**
     * 「訪問日情報（右）を展開する処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void resultReadButtonRightActionPerformed(ActionEvent e)
            throws Exception {
        // 訪問日情報（右）を展開する処理
        VRDateFormat vf = new VRDateFormat("ggge年M月");

        String message = String.valueOf(vf.format(ACDateUtilities.addMonth(
                getTargetDateSource(), 1))
                + "度");

        int msgID = QkanMessageList.getInstance().QC002_WARNING_OF_RESULT(
                message);

        if (msgID == ACMessageBox.RESULT_YES) {

            // 内部変数 rightMap を生成する
            VRMap rightMap = new VRHashMap();

            // rightMapに実績を取得する。
            rightMap = getVisitDataFromService(ACDateUtilities.addMonth(
                    getTargetDateSource(), 1), "RIGHT");

            // 実績が読込めなかった場合
            if (rightMap.isEmpty()) {
                QkanMessageList.getInstance().QC002_ERROR_OF_RESULT();
                return;
            }

            // カレンダーを初期化する
            initializeCalendar(false, true);

            // 取得したMapをapplyMapにマージする。
            // calendarLeftDayContainer に applyMap をセットする。
            getCalendarRightDayContainer().setSource(rightMap);
            // 画面に展開する。
            getCalendarRightDayContainer().bindSource();

        }

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QC002.class.getName(), param));
    }

    // 内部関数

    /**
     * 「ウィンドウタイトルの設定」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doInitialize() throws Exception {
        // ※ウィンドウタイトルの設定
        // 業務情報レコードを取得する。
        // ウィンドウタイトルに、取得レコードのKEY : WINDOW_TITLEのVALUEを設定する。
        // 業務ボタンバーのテキストに、取得レコードのKEY : AFFAIR_TITLEのVALUEを設定する。
        setAffairTitle("QC002", String.valueOf(0), getButtons());

        // 要介護度の初期値の設定
        getYokaigodo().setSelectedIndex(1);
        
        // ※コンボのアイテムの初期設定
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRList comboItemMap = new VRArrayList();

        // ※指定訪問看護ステーション名(providerName)
        // サービス提供事業所取得関数に渡すパラメータ(レコード集合) servicesを生成する。
        ArrayList services = new ArrayList();
        // servicesに以下の数値型の値を設定する。
        // 11301(訪問看護・介護)
        services.add("11311");

        // 訪問看護を提供する事業所を取得する。
        comboItemMap = QkanCommon.getProviderInfo(getDBManager(), services);

        // 取得したレコード集合を、「指定訪問看護ステーション名(providerName)」に設定する。
        getProviderName().setModel(comboItemMap);

        setInitValue();

        // ※表示/非表示の設定
        // ※訪問日カレンダー(左)の最終日表示設定
        int calendarLeftMaxDay = ACDateUtilities
                .getLastDayOfMonth(getTargetDateSource());

        // targetDateSourceの最終日を取得し、カレンダー(左)の日付コンボの表示設定を行う。(翌月0日など)
        switch (calendarLeftMaxDay) {
        // 28日の場合
        case 28:
            // 28日用の日付コンボの表示設定を行う。
            setState_CALENDAR_LEFT_FEBRUARY();
            break;

        // 29日の場合
        case 29:
            // 29日用の日付コンボの表示設定を行う。
            setState_CALENDAR_LEFT_BISSEXTILE();
            break;

        // 30日の場合
        case 30:
            // 30日用の日付コンボの表示設定を行う。
            setState_CALENDAR_LEFT_EVEN_MONTH();
            break;

        // 31日の場合
        case 31:

            // 31日用の日付コンボの表示設定を行う。
            setState_CALENDAR_LEFT_ODD_MONTH();
            break;

        default:
            break;
        }

        // ※訪問日カレンダー(右)の最終日表示設定
        // targetDateSource + 1 (翌月)の最終日を取得し、カレンダー(右)の日付コンボの表示設定を行う。
        int calendarRightMaxDay = ACDateUtilities
                .getLastDayOfMonth(ACDateUtilities.addMonth(
                        getTargetDateSource(), 1));

        switch (calendarRightMaxDay) {
        // 28日の場合
        case 28:
            // 28日用の日付コンボの表示設定を行う。
            setState_CALENDAR_RIGHT_FEBRUARY();
            break;

        // 29日の場合
        case 29:
            // 29日用の日付コンボの表示設定を行う。
            setState_CALENDAR_RIGHT_BISSEXTILE();
            break;

        // 30日の場合
        case 30:
            // 30日用の日付コンボの表示設定を行う。
            setState_CALENDAR_RIGHT_EVEN_MONTH();
            break;

        // 31日の場合
        case 31:
            // 31日用の日付コンボの表示設定を行う。
            setState_CALENDAR_RIGHT_ODD_MONTH();
            break;

        }

        // ※初期状態の設定
        // 画面の初期状態を設定する。
        setState_INIT_STATE();
    }

    /**
     * 「訪問看護報告書情報の設定」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFind() throws Exception {
        // ※訪問看護報告書情報の設定
        // SQL文取得関数への渡りパラメータ(レコード) sqlParamに、下記の値を設定する。
        VRMap findMap = new VRHashMap();
        VRMap sqlParam = new VRHashMap();

        // KEY : PATIENT_ID, VALUE : patientID (退避した渡りパラメータ)
        // KEY : TARGET_DATE, VALUE : targetDateSource (退避した渡りパラメータ)
        VRBindPathParser.set("PATIENT_ID", sqlParam,
                new Integer(getPatientID()));
        VRBindPathParser.set("TARGET_DATE", sqlParam,
                (Date) getTargetDateSource());

        // ※利用者情報をDBから取得
        // 対象利用者(利用者一覧で選択された利用者)の基本情報を取得する。
        VRList patientInfo = QkanCommon.getPatientInfo(getDBManager(),
                getPatientID());
        if (patientInfo.size() <= 0) {
            // 取得できなかった場合
            // エラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_FIND
            int msgID = QkanMessageList.getInstance()
                    .ERROR_OF_PASSIVE_CHECK_ON_FIND();
            // 「QU001 利用者一覧」画面に戻る。(処理を抜ける)
            // 強制戻りであるか判別する
            setForciblyBackCheckFlag(true);
            ACFrame.getInstance().back();
            return;
        }

        findMap.putAll((VRMap) patientInfo.getData(0));


        // ※年齢の取得
        // システムから、システム日付を取得する。
        Date sysDate = QkanSystemInformation.getInstance().getSystemDate();
        // 利用者生年月日、及びシステム日付から年齢を算出する。
        // calcAge((取得したレコードのPATIENT_BIRTHDAY), (システム日付));
        // findMapに下記の値を設定する。

        // ※利用者氏名の取得
        // 利用者の姓・名を連結し、利用者のフルネームを取得する。
        // toFullName((findMapのKEY:PATIENT_FAMILY_NAMEのVALUE),
        // (findMapのKEY:PATIENT_FIRST_NAMEのVALUE));
        VRBindPathParser.set("PATIENT_NAME", findMap, QkanCommon.toFullName(
                VRBindPathParser.get("PATIENT_FAMILY_NAME", findMap),
                VRBindPathParser.get("PATIENT_FIRST_NAME", findMap)));
        
        VRList patientYokaigodo = QkanCommon.getPatientInsureInfoOnEndOfMonth(
                getDBManager(), getTargetDateSource(), getPatientID());

        if (!(patientYokaigodo == null || patientYokaigodo.size() == 0)) {
            // 取得できた場合
            // 取得したレコードをfindMapに設定する。
            findMap.putAll((VRMap) patientYokaigodo.getData(0));
        }

        // 訪問看護報告書情報取得用のSQL文を取得する。
        // 取得したSQL文を発行する。
        VRList houkokusyoData = getDBManager().executeQuery(
                getSQL_GET_RESULT(sqlParam));

        // カレンダー（左）日付
        Date leftDate = getTargetDateSource();
        // カレンダー（右）日付
        Date rightDate = ACDateUtilities.addMonth(getTargetDateSource(), 1);

        if (houkokusyoData.size() <= 0) {
            // 取得件数が0件の場合
            // processModeにPROCESS_MODE_INSERTを設定する。(登録モード)
            setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
            // 登録ボタンを表示する。
            setState_PROCESS_MODE_INSERT();
            // resultDataに、contentsパネルからcretateSourceしたレコードを設定する。
            VRMap map = new VRHashMap();
            getContents().setSource(map);
            getContents().createSource();
            setResultData(map);
        } else {
            findMap.putAll((VRMap) houkokusyoData.getData(0));
            // 取得件数が0件より多い場合
            // processModeにPROCESS_MODE_UPDATEを設定する。(更新モード)
            setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
            // 更新ボタンを表示する。
            setState_PROCESS_MODE_UPDATE();
            // resultDataに、取得したレコード集合の1件目のレコードの値を追加する。
            setResultData((VRMap) houkokusyoData.getData(0));
            // パッシブキーを登録する。
            // reservedPassive(PASSIVE_CHECK_KEY_PLAN, (取得したレコード集合));
            getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY_RESULT(),
                    findMap);
        }

        // findMapに下記の値を設定する。
        // KEY : PATIENT_NAME, VALUE : (取得した利用者フルネーム)
        // カレンダー情報を画面に展開する
        findCalendar();
        // 初期値を設定
        initializeCalendar();

        VRList calendarLeftList = new VRArrayList();
        VRList calendarRightList = new VRArrayList();

        // ※訪問日情報の取得
        // if(getProcessMode()==QkanConstants.PROCESS_MODE_UPDATE){
        // processModeの値をチェックする。
        // PROCESS_MODE_UPDATE(更新)の場合
        // ※訪問日カレンダー(左)情報の取得
        // 訪問日カレンダー(左)情報を取得し、calendarLeftDataに格納する。
        calendarLeftList = getVisitDataFromResult(leftDate);

        /*
         * 
         */
        int leftMode = checkMode(calendarLeftList);

        // 変数calendarLeftCountに、訪問日（左）の件数を格納する。
        setCalendarLeftCount(calendarLeftList.size());

        // 0件の場合
        if (leftMode == QkanConstants.PROCESS_MODE_INSERT) {
            // サービス実績情報から訪問日情報を取得し、calendarLeftDataに格納する。
            findMap.putAll(getVisitDataFromService(leftDate, "LEFT"));

        } else {
            // 0件より多い場合
            // 画面展開用のデータとしてカレンダー（左）を追加する。
            VRMap map = new VRHashMap();
            map = createBindData(leftDate, "LEFT");
            findMap.putAll(map);

        }
        // ※訪問日カレンダー(右)情報の取得
        // 訪問日カレンダー(右)情報を取得し、calendarRightDataに格納する。
        calendarRightList = getVisitDataFromResult(rightDate);

        /*
         * 
         */
        int rightMode = checkMode(calendarRightList);

        // 変数calendarRightCountに、calendarRightDataの件数を格納する。
        setCalendarRightCount(calendarRightList.size());

        // 0件の場合
        if (rightMode == QkanConstants.PROCESS_MODE_INSERT) {
            // サービス実績情報から訪問日情報を取得し、calendarRightDataに格納する。
            findMap.putAll(getVisitDataFromService(rightDate, "RIGHT"));

        } else {
            // 0件より多い場合
            // 画面展開用のデータとしてカレンダー（右）を追加する。
            findMap.putAll(createBindData(rightDate, "RIGHT"));

        }

        // findMapに下記の値を設定する。
        // KEY : CALENDAR_LEFT_YEAR, VALUE : targetDateSourceの和暦の年
        findMap.setData("CALENDAR_LEFT_YEAR", new Integer(ACDateUtilities
                .getEraYear(leftDate)));
        // KEY : CALENDAR_LEFT_MONTH, VALUE : targetDateSourceの月
        findMap.setData("CALENDAR_LEFT_MONTH", new Integer(ACDateUtilities
                .getMonth(leftDate)));
        // KEY : CALENDAR_RIGHT_YEAR, VALUE : targetDateSource + 1ヶ月 (翌月1日)
        // の和暦の年
        findMap.setData("CALENDAR_RIGHT_YEAR", new Integer(ACDateUtilities
                .getEraYear(rightDate)));
        // KEY : CALENDAR_RIGHT_MONTH, VALUE : targetDateSource + 1ヶ月 (翌月1日) の月
        findMap.setData("CALENDAR_RIGHT_MONTH", new Integer(ACDateUtilities
                .getMonth(rightDate)));

        // contentsパネルのdataSourceとして、resultDataを設定する。
        getContents().setSource(findMap);
        // resultDataを画面に展開する。
        getContents().bindSource();
        // スナップショットを撮影する。
        getSnapshot().snapshot();

    }

    /**
     * 「初期値の設定」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void setInitValue() throws Exception {
        // ※担当医師名(主治医氏名)の取得
        VRMap initMap = new VRHashMap();
        
        initMap.setData("DOCTOR_NAME", "");

        // ※作成年月の設定
        // システムから、「システム日付」を取得する。
        initMap.setData("CREATE_DATE", QkanSystemInformation.getInstance()
                .getSystemDate());

        // resultDataに下記の値を設定する。
        // KEY : CREATE_DATE, VALUE : (取得したシステム日付)
        // ※訪問看護提供事業所コンボの初期選択アイテムの設定
        // ログイン事業所番号を取得する。
        String loginProvider = QkanSystemInformation.getInstance()
                .getLoginProviderID();

        // 訪問看護提供事業所コンボの中に、ログイン事業所番号と同一のIDの事業所が存在するかどうかチェックする。
        for (int i = 0; getProviderName().getModel().getSize() > i; i++) {

            VRMap map = (VRMap) getProviderName().getModelItem(i);

            // ログイン事業所と同一の事業所が存在した場合
            if (loginProvider.equals(map.getData("PROVIDER_ID"))) {
                // 存在する場合
                // planDataに下記の値を設定する。
                // KEY : PROVIDER_NAME
                getProviderName().setSelectedIndex(i);

            }

            // 存在しない場合
            // planDataに下記の値を設定する。
            // KEY : PROVIDER_NAME

        }

        getContents().setSource(initMap);
        getContents().bindSource();
        // ※管理者氏名の設定
        // コンボに入力されている事業所名から、その事業所の「管理者氏名(ADMINISTRATOR_NAME)」を取得する。
        // getAdministratorName((コンボの選択アイテムのレコード));

        // resultDataに下記の値を設定する。
        // KEY : ADMINISTRATOR_NAME, VALUE : (取得した管理者氏名)
        setResultData(initMap);
    }

    /**
     * 「登録済みの訪問日情報取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRList getVisitDataFromResult(Date visitDate) throws Exception {
        // ※第一引数 : visitDate(日付型) : 対象年月
        // SQL文取得関数への渡りパラメータ(レコード) sqlParamを生成し、下記の値を設定する。
        VRMap sqlParam = new VRHashMap();

        // KEY : PATIENT_ID, VALUE : patientID (退避した渡りパラメータ)
        sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));

        // KEY : DATE_START, VALUE : visitDate
        sqlParam.setData("DATE_START", ACDateUtilities
                .toFirstDayOfMonth(visitDate));

        // KEY : DATE_END, VALUE : (visitDate + 1ヶ月) (visitDateの翌月1日)
        sqlParam.setData("DATE_END", ACDateUtilities
                .toLastDayOfMonth(visitDate));

        // 訪問日取得用SQL文を取得する。
        // 取得したSQL文を発行する。
        VRList list = getDBManager()
                .executeQuery(getSQL_GET_CALENDAR(sqlParam));

        // 取得したレコード集合を、関数の戻り値として返す。
        return list;
    }

    /**
     * 「サービス実績から訪問日を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getVisitDataFromService(Date targetDate, String type)
            throws Exception {
        // ※サービス実績から訪問日を取得

        // sql文取得用にレコード sqlParam を生成し、下記の値を設定する。
        VRMap sqlParam = new VRHashMap();

        // KEY : PATIENT_ID, VALUE : patientID (退避した渡りパラメータ)
        sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));

        // ※サービス実績の取得
        // サービスカレンダー情報格納用の serviceResultMapを生成する。
        VRMap serviceResultMap = new VRHashMap();
        // サービス実績情報格納用のレコード集合 serviceListを生成する。
        VRList serviceList = new VRArrayList();
        // 内部変数 sqlParamを生成する。
        // KEY：TARGET_DATE_START VALUE：targetDate の月初
        sqlParam.setData("TARGET_DATE_START", ACDateUtilities
                .toFirstDayOfMonth(targetDate));
        // KEY：TARGET_DATE_START VALUE：targetDate の月末
        sqlParam.setData("TARGET_DATE_END", ACDateUtilities
                .toLastDayOfMonth(targetDate));
        
        sqlParam.setData("PROVIDER_ID", QkanSystemInformation
                .getInstance().getLoginProviderID());
        // サービス実績を取得するSQL文を取得する
        // 取得したSQL文を発行し、serviceListに格納する。
        serviceList = getDBManager().executeQuery(
                getSQL_GET_SERVICE_RESULT_DATA(sqlParam));
        // ※サービス実績の訪問日情報への変換
        // monthInfo を生成する。
        String monthInfo = type;

        VRMap map = new VRHashMap();

        for (int i = 0; i < serviceList.size(); i++) {
            // VISIT_VALUEの値を取得し 以下のKEYで格納する。
            map = (VRMap) serviceList.getData(i);
            // KEY：CALENDAR_ + monthInfo + _DAY +
            // 取得した府フィールドの値（VISIT_DATE_OF_DAY（2桁））
            serviceResultMap.setData("CALENDAR_" + monthInfo + "_DAY"
                    + map.getData("VISIT_DATE_OF_DAY"), new Integer(String
                    .valueOf(map.getData("VISIT_VALUE"))));
            // VISIT_DATEの値を下記のKEYで格納する。
            // KEY：VISIT_DATE
            serviceResultMap.setData("VISIT_DATE", map.getData("SERVICE_DATE"));
            // 利用者番号を下記のKEYで格納する。
            serviceResultMap.setData("PATIENT_ID", new Integer(getPatientID()));
            // KEY:PATIENT_ID
            // 件数分ループした場合次処理へ
        }

        return serviceResultMap;

    }

    /**
     * 「保存処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean doInsert() throws Exception {
        // ※報告書情報の取得
        // resultDataに、画面の報告書情報を格納する。
        VRMap resultData = new VRHashMap();
        VRMap saveMap = new VRHashMap();

        try {
            // 画面上の情報を取得
            getContents().setSource(resultData);
            getContents().applySource();

            // 登録用のデータを取得
            saveMap = createSaveData();

            // resultDataに下記の値を追加する。
            // KEY : PATIENT_ID, VALUE : patientID (退避した渡りパラメータ)
            resultData.setData("PATIENT_ID", new Integer(getPatientID()));
            // KEY : TARGET_DATE, VALUE : targetDateSource (退避した渡りパラメータ)
            resultData.setData("TARGET_DATE", getTargetDateSource());

            // ※パッシブチェックの準備
            // パッシブタスクをクリアする。
            getPassiveChecker().clearPassiveTask();

            // ※訪問看護報告書のパッシブタスクの登録
            // 訪問看護報告書情報のパッシブキーを登録する。
            getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY_RESULT(),
                    resultData);

            // 訪問看護報告書情報追加用のパッシブタスクを登録する。
            getPassiveChecker().addPassiveInsertTask(
                    getPASSIVE_CHECK_KEY_RESULT(), resultData);

            VRList leftList = (VRList) saveMap.getData("CALENDAR_LEFT");

            VRList rightList = (VRList) saveMap.getData("CALENDAR_RIGHT");

            // トランザクションを開始する
            getDBManager().beginTransaction();
            // ※パッシブチェック
            // パッシブチェックを実行する。
            // パッシブエラーがある場合
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                //テーブルロック解除のためロールバック
                getDBManager().rollbackTransaction();
                // パッシブエラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // 処理を中断する。(異常終了)
                return false;
            }

            // パッシブエラーがない場合
            // 処理を継続する。
            // ※訪問看護報告書の登録
            // processModeの値をチェックする。
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // 訪問看護報告書情報登録用のSQL文を取得する。
                // 取得したSQL文を発行する。
                getDBManager().executeUpdate(getSQL_INSERT_RESULT(resultData));
                // カレンダー情報を保存する処理
                doSaveCalendar(leftList, rightList);

            } else {
                //テーブルロック解除のためロールバック
                getDBManager().rollbackTransaction();
                return false;
            }
            // 上記一連のSQL発行処理でエラーがなかった場合
            // 処理をコミットする。
            getDBManager().commitTransaction();
            // 処理を終了する（正常終了）
            return true;

        } catch (Exception sqlEx) {
            // 処理を終了する。(正常終了)
            sqlEx.printStackTrace();

            // SQL発行処理でエラーがあった場合
            // 処理をロールバックする。
            getDBManager().rollbackTransaction();

            // 処理を中断する。(異常終了)
            throw sqlEx;
        }

    }

    /**
     * 「保存処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean doUpdate() throws Exception {
        // ※報告書情報の取得
        VRMap resultData = new VRHashMap();

        try {
            // 対象月の日付
            Date leftDate = getTargetDateSource();
            // 対象月＋1月
            Date rightDate = ACDateUtilities.addMonth(getTargetDateSource(), 1);
            // resultDataに、画面の報告書情報を格納する。
            getContents().setSource(resultData);
            getContents().applySource();

            // resultDataに下記の値を追加する。
            // KEY : PATIENT_ID, VALUE : patientID (退避した渡りパラメータ)
            resultData.setData("PATIENT_ID", new Integer(getPatientID()));
            // KEY : TARGET_DATE, VALUE : targetDateSource (退避した渡りパラメータ)
            resultData.setData("TARGET_DATE", leftDate);

            // ※訪問日情報の取得
            VRMap saveMap = new VRHashMap();
            saveMap = createSaveData();

            // カレンダー情報（左）を取得
            VRList leftList = (VRList) saveMap.getData("CALENDAR_LEFT");
            // カレンダー情報（右）を取得
            VRList rightList = (VRList) saveMap.getData("CALENDAR_RIGHT");

            // ※パッシブチェックの準備
            // パッシブタスクをクリアする。
            getPassiveChecker().clearPassiveTask();
            // ※訪問看護報告書のパッシブタスクの登録
            if (getProcessMode() != QkanConstants.PROCESS_MODE_UPDATE) {
                //テーブルロック解除のためロールバック
                getDBManager().rollbackTransaction();
                
                return false;
            }
            // processModeの値をチェックする。
            // 訪問看護報告書情報更新用のパッシブタスクを登録する。
            getPassiveChecker().addPassiveUpdateTask(
                    getPASSIVE_CHECK_KEY_RESULT());

            // トランザクションを開始する
            getDBManager().beginTransaction();
            // ※パッシブチェック
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                //テーブルロック解除のためロールバック
                getDBManager().rollbackTransaction();
                // パッシブチェックを実行する。
                // パッシブエラーがある場合
                // パッシブエラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // 処理を中断する。(異常終了)
                return false;
            }

            // パッシブエラーがない場合
            // 処理を継続する。
            // ※訪問看護報告書の登録
            // 訪問看護報告書情報更新用のSQL文を取得する。
            // 取得したSQL文を発行する。
            getDBManager().executeUpdate(getSQL_UPDATE_RESULT(resultData));
            // ※訪問看護報告書・訪問日(カレンダー(左))情報の登録

            doSaveCalendar(leftList, rightList);

            // 上記一連のSQL発行処理でエラーがなかった場合
            // 処理をコミットする。
            getDBManager().commitTransaction();
            // 処理を終了する（正常終了）
            return true;

        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
            // 処理を終了する。(正常終了)
            // SQL発行処理でエラーがあった場合
            // 処理をロールバックする。
            getDBManager().rollbackTransaction();
            // 処理を中断する。(異常終了)
            throw sqlEx;
        }
    }

    /**
     * 「事業所の管理者氏名取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public String getAdministratorName(VRMap rec) throws Exception {
        // ※引数チェック
        // 引数で渡されたレコードをチェックする。
        if (rec == null) {
            // nullの場合
            // 空白を返す。(処理終了)
            return "";
        }
        // null以外の場合
        // 処理を継続する。
        // ※引数からPROVIDER_IDを抽出
        // 引数で渡されたレコードから、KEY : PROVIDER_IDのVALUEを取得する。
        if (!VRBindPathParser.has("PROVIDER_ID", rec)) {
            // 取得できなかった場合
            // 空白を返す。(処理終了)
            return "";
        }
        // 取得できた場合
        // 処理を継続する。
        // ※事業所のサービス詳細情報を取得
        // 事業所のサービス詳細情報を取得する。
        StringBuilder sb = new StringBuilder();
        sb.append(" SYSTEM_SERVICE_KIND_DETAIL IN (11311)");
        sb.append(" AND PROVIDER_ID = ");
        sb.append(String.valueOf("'"+ VRBindPathParser.get("PROVIDER_ID",rec) + "'"));
        
        VRList list = QkanCommon.getProviderServiceDetailCustom(
                getDBManager(),sb.toString());

        if (list.size() <= 0) {
            // 取得件数が0件の場合
            // 空白を返す。(処理終了)
            return "";
        }
        // 取得件数が0件より多い場合
        // 処理を継続する。
        // ※管理者氏名の抽出
        VRMap record = (VRMap) list.getData(0);
        // 取得したレコード集合の、最初のレコードの KEY : 1130103のVALUEを取得する。
        String admnisutatorName = ACCastUtilities.toString(record
                .getData("1130103"));
        // 取得した値を戻り値として返す。(処理終了)
        return admnisutatorName;
    }

    /**
     * 「入力チェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean checkValidInput() throws Exception {
        // ※入力チェック
        // ※作成年月日・未入力チェック
        if (ACTextUtilities.isNullText(getCreateDate().getText())) {
            // 画面の「作成年月日(createDate)」の値をチェックする。
            // 入力されている場合
            // 処理を継続する。
            // 未入力の場合
            // エラーメッセージを表示する。※ID = ERROR_OF_NEED_CHECK_FOR_INPUT
            QkanMessageList.getInstance()
                    .ERROR_OF_NEED_CHECK_FOR_INPUT("作成年月日");
            // createDateにフォーカスを当てる。
            getCreateDate().requestFocus();
            // 戻り値としてfalseを返し、処理を中断する。
            return false;
        }
        // ※作成年月日・不正チェック
        // 画面の「作成年月日(createDate)」の値をチェックする。
        // 正常値の場合
        // 処理を継続する。
        if (!getCreateDate().isValidDate()) {
            // 異常値の場合
            // エラーメッセージを表示する。※ID = ERROR_OF_WRONG_DATE
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("作成年月日の");
            // createDateにフォーカスを当てる。
            getCreateDate().requestFocus();
            // 戻り値としてfalseを返し、処理を中断する。
            return false;
        }
        // ※正常終了
        // 上記エラーチェックをパスした場合、戻り値としてtrueを返す。
        return true;
    }

    /**
     * 「訪問日のコンボデータを作成する処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap createCalendarData(Date targetDate, String type)
            throws Exception {
        // 訪問日のコンボデータ(左）を作成する処理
        // 内部変数 calendarList を生成する。
        VRList calendarList = new VRArrayList();
        // 内部変数 calendarBindMap を生成する
        VRMap calendarBindDataMap = new VRHashMap();
        // 内部変数 codeMastarList を生成する
        VRList codeMasterList = new VRArrayList();
        // 内部変数 calendarLeftDate を生成し、対象月の月初の値を設定する。
        Date calendarStartData = targetDate;

        // コードマスタから訪問種別を表す記号情報を取得するためのSQL文を取得する。
        codeMasterList = QkanCommon.getArrayFromMasterCode(199, "VISIT_VALUE");
        // codeMasterListにコードマスターから訪問種別を表す記号を取得し格納する。

        // 対象月の日を取得する
        int lastDay = ACDateUtilities.getLastDayOfMonth(calendarStartData);

        VRMap calendarData = new VRHashMap();

        // 末日の数字分ループする
        for (int i = 1; i <= lastDay; i++) {
            // コードマスターから取得した件数分ループする
            for (int j = 0; j < codeMasterList.size(); j++) {
                VRMap map = (VRMap) codeMasterList.getData(j);
                // 1件目のみ初期値を生成
                if (j == 0) {
                    calendarData.setData("CALENDAR_DATA_STRING", String
                            .valueOf(i));
                    calendarData.setData("CALENDAR_" + type + "_DAY" + i,
                            new Integer(String.valueOf(map
                                    .getData("CONTENT_KEY"))));
                    calendarList.add(calendarData);
                    // 初期化
                    calendarData = new VRHashMap();
                }
                // 結合した値を下記のKEYでcalendarLeftDataに格納する。
                // KEY：CALENDAR_DATA_STRING
                String str = String.valueOf(map.getData("CONTENT"));
                calendarData.setData("CALENDAR_DATA_STRING", i + str);

                int contentKeyNo = Integer.parseInt(String.valueOf(map
                        .getData("CONTENT_KEY")));

                // //calendarLeftData に
                // コードマスタより取得したCONTENT_KEYのVALUEを下記のKEYで格納する。
                calendarData.setData("CALENDAR_" + type + "_DAY" + i,
                        new Integer(contentKeyNo + 1));

                // KEY：VISIT_VALUE_LEFT + 現在の件数
                // calendarDataListにcalendaLeftrDataを追加する。
                calendarList.add(calendarData);

                // calendarLeftData を新規に生成する。（初期化処理）
                calendarData = new VRHashMap();
            }
            // 記号の数だけ作成した場合
            // calendarBindMap に calendarDataListを下記のKEY/VALUEで設定する。
            calendarBindDataMap.setData("CALENDAR_" + type + i, calendarList);

            // KEY：CALENDEAR_LEFT_DAY_ + 現在の件数
            // calendarDataListを新規生成する。（初期化）
            calendarList = new VRArrayList();

            // calendarLeftDateの日付を+1日する。
            calendarStartData = ACDateUtilities
                    .addDay(getTargetDateSource(), 1);
            // 値を＋１する。
        }
        // 戻り値としてcalendarBindMapを返す。
        return calendarBindDataMap;
    }

    /**
     * 
     */
    public void findCalendar() throws Exception {

        // TODO 自動生成されたメソッド・スタブ
        // カレンダー情報（右）を取得する。
        VRMap mapRight = createCalendarData(ACDateUtilities.addMonth(
                getTargetDateSource(), 1), "RIGHT");

        // カレンダー情報（左）を取得する。
        VRMap mapLeft = createCalendarData(getTargetDateSource(), "LEFT");

        VRMap calendarMap = new VRHashMap();

        // 取得したMapをマージして画面に展開する。
        calendarMap.putAll(mapLeft);
        calendarMap.putAll(mapRight);
        // 画面に展開する。
        getCalendars().setModelSource(calendarMap);
        getCalendars().bindModelSource();

    }

    /**
     * 
     */
    public VRMap createBindData(Date targetDate, String type) throws Exception {
        // TODO 自動生成されたメソッド・スタブ

        // 内部変数 sqlParam を生成し 以下のKEY/VALUEで格納する。
        VRMap sqlParam = new VRHashMap();
        // KEY：PATIENT_ID VALUE：利用者ID
        sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
        // KEY：VISIT_DATE_START VALUE：渡りパラメーター日付の月初
        sqlParam.setData("VISIT_DATE_START", ACDateUtilities
                .toFirstDayOfMonth(targetDate));
        // KEY：VISIT_DATE_END VALUE：渡りパラメーター日付の月末
        sqlParam.setData("VISIT_DATE_END", ACDateUtilities
                .toLastDayOfMonth(targetDate));
        // 画面展開用のデータを取得するためのSQL文を取得する。
        // 取得したSQL文を発行する。
        VRList list = getDBManager().executeQuery(
                getSQL_GET_CALENDAR_CUSTOM(sqlParam));
        // 返ってきた結果を内部変数に格納する。
        // 内部変数 bindData を生成する。
        VRMap bindData = new VRHashMap();

        // 帰ってきたレコード件数分以下の処理を繰り返す。
        for (int i = 0; i < list.size(); i++) {
            VRMap map = (VRMap) list.getData(i);
            // bindDataに下記KEY/VALUEを格納する。
            bindData.setData("CALENDAR_" + type + "_DAY"
                    + map.getData("VISIT_DATE_OF_DAY"), new Integer(String
                    .valueOf(map.getData("VISIT_VALUE"))));
            // KEY：CALENDAR_ +type + DAY + KEY：VISIT_DATE_OF_DAYのVALUE
            // VALUE：VISIT_VALUEのVALUE

        }
        // 件数分処理した場合戻り値としてbindDataを返す。
        return bindData;
    }

    /**
     * 
     */
    public VRMap createSaveData() throws Exception {
        // カレンダー情報格納用
        VRMap calendarMap = new VRHashMap();
        getCalendars().setSource(calendarMap);
        getCalendars().applySource();

        VRMap saveData = new VRHashMap();
        // カレンダー（左）情報格納用
        VRList saveLeftList = new VRArrayList();
        // カレンダー（右）情報格納用
        VRList saveRightList = new VRArrayList();
        // 戻り値を格納する変数
        VRMap saveMap = new VRHashMap();

        // カレンダー（左）月初の日付を取得
        Date leftDate = ACDateUtilities
                .toFirstDayOfMonth(getTargetDateSource());
        // カレンダー（右）月初の日付を取得
        Date rightDate = ACDateUtilities.addMonth(leftDate, 1);

        Iterator it = calendarMap.entrySet().iterator();
        // キー名を取得
        Map.Entry key = null;
        // KEYをString型で格納
        String strKey = "";

        // 画面から取得したコンボデータ数ループ
        while (it.hasNext()) {
            key = (Map.Entry) it.next();
            // KEYをString型で格納
            strKey = String.valueOf(key.getKey());
            // KEYの文字列からコンボであるかを判断
            if (strKey.indexOf("CALENDAR_LEFT_DAY") == 0
                    || strKey.indexOf("CALENDAR_RIGHT_DAY") == 0) {
                // コンボの値が空白もしくは初期値以外だった場合
                if (key.getValue() != "" && key.getValue() != null) {
                    // カレンダーの種類を判別して日付データを作成

                    if (strKey.indexOf("CALENDAR_LEFT") == 0) {
                        // 日付を設定する
                        saveData.setData("VISIT_DATE", ACDateUtilities
                                .setDayOfMonth(leftDate, Integer
                                        .parseInt(strKey.substring(17, strKey
                                                .length()))));
                        // 値を取得し格納
                        saveData.setData("VISIT_VALUE", new Integer(String
                                .valueOf(key.getValue())));
                        // 利用者IDを設定する
                        saveData.setData("PATIENT_ID", new Integer(
                                getPatientID()));
                        // 戻り値として使うListに格納
                        saveLeftList.add(saveData);
                    } else {
                        saveData.setData("VISIT_DATE", ACDateUtilities
                                .setDayOfMonth(rightDate, Integer
                                        .parseInt(strKey.substring(18, strKey
                                                .length()))));
                        // 値を取得し格納
                        saveData.setData("VISIT_VALUE", new Integer(String
                                .valueOf(key.getValue())));
                        // 利用者IDを設定する
                        saveData.setData("PATIENT_ID", new Integer(
                                getPatientID()));
                        // 戻り値として使うListに格納
                        saveRightList.add(saveData);
                    }
                    // 初期化
                    saveData = new VRHashMap();
                }
            }

        }
        saveMap.setData("CALENDAR_LEFT", saveLeftList);
        saveMap.setData("CALENDAR_RIGHT", saveRightList);
        // 登録用データを返す
        return saveMap;
    }

    /**
     * 
     */
    public void doSaveCalendar(VRList leftList, VRList rightList)
            throws Exception {

        // 対象月
        Date targetDateLeft = getTargetDateSource();
        // 対象月＋１月
        Date targetDateRight = ACDateUtilities.addMonth(targetDateLeft, 1);

        VRMap sqlParam = new VRHashMap();

        // ※訪問看護報告書・訪問日(カレンダー(左))情報の登録
        // calendarLeftCountの値をチェックする。
        if (getCalendarLeftCount() != 0) {
            // 0件の場合
            // DELETE処理は行わない。(何もせず、次へ。)
            // 0件より多い場合
            // sqlParamに下記の値を設定する。
            // KEY : PATIENT_ID, VALUE : patientID (退避した渡りパラメータ)
            sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
            // KEY : DATE_START, VALUE : targetDateSource
            sqlParam.setData("DATE_START", ACDateUtilities
                    .toFirstDayOfMonth(targetDateLeft));
            // KEY : DATE_END, VALUE : (targetDateSource + 1ヶ月)
            // (targetDateSourceの翌月1日)
            sqlParam.setData("DATE_END", ACDateUtilities
                    .toLastDayOfMonth(targetDateLeft));

            // 訪問看護報告書・訪問日情報削除用のSQL文を取得する。
            // 取得したSQL文を発行する。
            getDBManager().executeUpdate(getSQL_DELETE_CALENDAR(sqlParam));
        }

        // KEY : PATIENT_ID, VALUE : patientID
        sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
        // calendarLeftDataの件数分ループする。
        for (int i = 0; i < leftList.size(); i++) {
            // sqlParamに下記の値を設定する。
            VRMap saveData = (VRMap) leftList.getData(i);
            // 初期値であるか判断する
            if (saveData.getData("VISIT_VALUE") != "") {
                // KEY : VISIT_DATE, VALUE : (calendarLeftDataのn番目のレコードの KEY :
                // VISIT_DATEのVALUE)
                sqlParam.setData("VISIT_DATE", saveData.getData("VISIT_DATE"));
                // KEY : VISIT_VALUE, VALUE : (calendarLeftDataのn番目のレコードの KEY :
                // VISIT_VALUEのVALUE)
                sqlParam
                        .setData("VISIT_VALUE", saveData.getData("VISIT_VALUE"));
                // 訪問看護報告書・訪問日情報追加用のSQL文を取得する。
                // 取得したSQL文を発行する。
                getDBManager().executeUpdate(getSQL_INSERT_CALENDAR(sqlParam));
            }
        }

        // ※訪問看護報告書・訪問日(カレンダー(右))情報の登録
        // calendarRightCountの値をチェックする。
        if (getCalendarRightCount() != 0) {
            // 0件の場合
            // DELETE処理は行わない。(何もせず、次へ。)
            // 0件より多い場合
            // sqlParamに下記の値を設定する。
            // KEY : PATIENT_ID, VALUE : patientID (退避した渡りパラメータ)
            sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
            sqlParam.setData("DATE_START", ACDateUtilities
                    .toFirstDayOfMonth(targetDateRight));
            // KEY : DATE_END, VALUE : (targetDateSource + 1ヶ月)
            // (targetDateSourceの翌月1日)
            sqlParam.setData("DATE_END", ACDateUtilities
                    .toLastDayOfMonth(targetDateRight));
            // 訪問看護報告書・訪問日情報削除用のSQL文を取得する。
            // 取得したSQL文を発行する。
            getDBManager().executeUpdate(getSQL_DELETE_CALENDAR(sqlParam));
        }
        // KEY : PATIENT_ID, VALUE : patientID
        sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));

        // calendarRightDataの件数分ループする。
        for (int i = 0; i < rightList.size(); i++) {
            // sqlParamに下記の値を設定する。
            VRMap saveData = (VRMap) rightList.getData(i);
            // 初期値であるか判断する
            if (saveData.getData("VISIT_VALUE") != new Integer(1)) {
                // KEY : VISIT_DATE, VALUE : (calendarRightDataのn番目のレコードの KEY :
                // VISIT_DATEのVALUE)
                sqlParam.setData("VISIT_DATE", saveData.getData("VISIT_DATE"));
                // KEY : VISIT_VALUE, VALUE : (calendarRightDataのn番目のレコードの KEY :
                // VISIT_VALUEのVALUE)
                sqlParam
                        .setData("VISIT_VALUE", saveData.getData("VISIT_VALUE"));
                // 訪問看護報告書・訪問日情報追加用のSQL文を取得する。
                // 取得したSQL文を発行する。
                getDBManager().executeUpdate(getSQL_INSERT_CALENDAR(sqlParam));
            }
        }

    }

    /**
     * 
     */
    public void initializeCalendar(boolean isLeft, boolean isRight)
            throws Exception {
        // 初期化に使う値を格納する変数
        VRMap bindData = new VRHashMap();
        // 対象月の末日
        int leftDayOfMonth = ACDateUtilities
                .getLastDayOfMonth(getTargetDateSource());
        // 対象月＋１月の末日
        int rightDayOfMonth = ACDateUtilities.getLastDayOfMonth(ACDateUtilities
                .addMonth(getTargetDateSource(), 1));
        if (isLeft) {
            // カレンダー（左）の初期値を生成する
            for (int i = 0; i <= leftDayOfMonth; i++) {
                bindData.setData("CALENDAR_LEFT_DAY" + i, new Integer(1));
            }
        }

        // カレンダー（右）の初期値を生成する
        if (isRight) {
            for (int j = 0; j <= rightDayOfMonth; j++) {
                bindData.setData("CALENDAR_RIGHT_DAY" + j, new Integer(1));
            }
            // TODO
            // 生成したデータを画面に展開する。
        }
        getCalendars().setSource(bindData);
        getCalendars().bindSource();
    }

    /**
     * @throws Exception
     */
    public void initializeCalendar() throws Exception {
        // 初期化に使う値を格納する変数
        VRMap bindData = new VRHashMap();
        // 対象月の末日
        int leftDayOfMonth = ACDateUtilities
                .getLastDayOfMonth(getTargetDateSource());
        // 対象月＋１月の末日
        int rightDayOfMonth = ACDateUtilities.getLastDayOfMonth(ACDateUtilities
                .addMonth(getTargetDateSource(), 1));
        // カレンダー（左）の初期値を生成する
        for (int i = 0; i <= leftDayOfMonth; i++) {
            bindData.setData("CALENDAR_LEFT_DAY" + i, new Integer(1));
        }

        // カレンダー（右）の初期値を生成する
        for (int j = 0; j <= rightDayOfMonth; j++) {
            bindData.setData("CALENDAR_RIGHT_DAY" + j, new Integer(1));
        }
        // TODO
        // 生成したデータを画面に展開する。
        getCalendars().setSource(bindData);
        getCalendars().bindSource();

    }

    /**
     * @param list
     * @return mode 処理モード
     * @throws Exception
     */
    public int checkMode(VRList list) throws Exception {

        // 件数が取得できなかった場合
        if (list.size() <= 0) {
            // 新規モードとして返す
            return QkanConstants.PROCESS_MODE_INSERT;
        }

        // カレンダーデータが全て初期値であるかチェックする
        for (int i = 0; i < list.size(); i++) {
            VRMap map = (VRMap) list.getData(i);

            if (!new Integer(1).equals(map.getData("VISIT_VALUE"))) {
                // 初期値以外なので更新モードとして返す
                return QkanConstants.PROCESS_MODE_UPDATE;

            } else if (map.getData("VISIT_VALUE") == null) {
                // nullの場合は何もしない

            }

        }

        // 値が全て1だった場合は更新モードとして処理する。
        return QkanConstants.PROCESS_MODE_UPDATE;

    }

}
