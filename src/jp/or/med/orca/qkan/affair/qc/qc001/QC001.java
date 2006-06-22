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
 * 作成日: 2005/12/10  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 計画書情報入力 (001)
 * プログラム 計画書情報入力 (QC001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc001;

import java.awt.event.ActionEvent;
import java.text.Format;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.component.table.VRSortableTableModelar;
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
 * 計画書情報入力(QC001)
 */
public class QC001 extends QC001Event {
    /**
     * コンストラクタです。
     */
    public QC001() {
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
        // ※画面展開時イベント

        // 渡りデータの取得/前画面「利用者一覧」から渡されたパラメータを退避する。
        VRMap parameters = affair.getParameters();
        // this.patientID = PATIENT_ID(利用者ID)
        // String patientID = (String)parameters.getData("PATIENT_ID");
        if (VRBindPathParser.has("PATIENT_ID", parameters)) {
            // 利用者ID有り
            // int型に型変換し利用者IDを退避
            setPatientID(Integer.parseInt(String.valueOf(VRBindPathParser.get(
                    "PATIENT_ID", parameters))));
        }
        // this.targetDateSource = TARGET_DATE(対象年月)
        if (VRBindPathParser.has("TARGET_DATE", parameters)) {
            // 対象年月有り
            // 日付型に型変換し退避
            setTargetDateSource((Date) VRBindPathParser.get("TARGET_DATE",
                    parameters));

        }

        setPASSIVE_CHECK_KEY_PLAN(new ACPassiveKey("HOMONKANGO_PLAN",
                new String[] { "PATIENT_ID", "TARGET_DATE" }, new Format[] {
                       null , new ACSQLSafeDateFormat("yyyy/M/d") },
                "LAST_TIME", "LAST_TIME"));

        // 画面の状態の初期化を行う。
        setState_INIT_STATE();

        getPlanNotesColumn1().setFormat(new VRDateFormat("ggge年MM月dd日"));

        // DBからデータを取得する。
        doFind();

        // セルの1行目を選択状態にする
        if (getPlanNoteData().size() > 0) {
            getPlanNotes().setSelectedModelRow(
                    ((VRSortableTableModelar) getPlanNotes().getModel())
                            .getReverseTranslateIndex(0));

        }

    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }

        // 強制戻り判別処理かどうか判別する
        if (getForciblyBackCheckFlag()) {

            // 戻り用渡りパラメータに、下記の値を設定する。

            // 前画面に戻る。
            return true;
        }

        parameters.setData("PATIENT_ID", new Integer(getPatientID()));

        // ※スナップショットチェック
        // スナップショットの更新チェックを行う。
        if (!getPlanNoteChangeFlag() && !getSnapshot().isModified()) {
            // 更新されていない場合
            // 前画面に戻る。
            // TODO ACAffairInfo affair = new
            // ACAffairInfo(QU001.class.getName());
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
        switch (msgID) {
        case ACMessageBox.RESULT_YES:
            // 「更新して戻る」選択時
            // 処理を継続する。
            break;
        case ACMessageBox.RESULT_NO:

            // 「破棄して戻る」選択時
            // 戻り用渡りパラメータに、下記の値を設定する。
            // KEY : NEXT_AFFAIR
            // 前画面に戻る。
            return true;

        case ACMessageBox.RESULT_CANCEL:
            // 「キャンセル」選択時
            // 処理を中断する。
            return false;
            
        default:
            return true;
                

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
        boolean saveState = false;

        if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
            saveState = doInsert();
        } else {
            saveState = doUpdate();
        }

        if (!saveState) {
            // 保存処理が異常終了した場合
            // 処理を中断する。
            return false;
            // 保存処理が正常終了した場合
        } else {
            // 戻り用渡りパラメータに、下記の値を設定する。
            // KEY : NEXT_AFFAIR
            // 前画面に戻る。
            // 前画面への遷移を許可するならばtrueを返す。
            return true;
        }
    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }

        // ※スナップショットチェック
        // スナップショットの更新チェックを行う。
        // 更新されていない場合
        // システムを終了する。

        // 更新されている場合

        // 処理を継続する。
        // ※終了確認
        if (!getPlanNoteChangeFlag() && !getSnapshot().isModified()) {
            return true;

        } else {

            int msgID = QkanMessageList.getInstance()
                    .WARNING_OF_CLOSE_ON_MODIFIED();
            // 終了確認のメッセージを表示する。※メッセージID = WARNING_OF_CLOSE_ON_MODIFIED
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
        // 終了を許可するならばtrueを返す。
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

        // テーブルに変更があるかチェックする
        if (getPlanNoteChangeFlag()) {
            // 変更があった場合
            changeFlag = true;
        }

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

        // planDataに、画面から抽出した情報を格納する。
        VRMap planData = getPlanData();
        getContents().setSource(planData);
        getContents().applySource();

        // 印刷クラスへの渡りパラメータ(レコード) printParamを生成する。
        VRMap printParam = null;
        printParam = new VRHashMap();

        // printParamに、planDataの値をコピーする。
        printParam = planData;

        // printParamに、下記パラメータを設定する。
        // KEY : PLAN_NOTE
        printParam.setData("PLAN_NOTE", getPlanNoteData());

        // 印刷管理クラスを生成
        ACChotarouXMLWriter writer = new ACChotarouXMLWriter();

        // 印刷開始を宣言
        writer.beginPrintEdit();
        // printParam.setData()
        QC001P01 qc001p01 = new QC001P01();

        // 印刷する。
        if (qc001p01.doPrint(writer, printParam)) {

            // 生成された場合
            // 印刷終了を宣言
            writer.endPrintEdit();

            // PDFファイルを生成して開く
            ACChotarouXMLUtilities.openPDF(writer);

        } else {
            // 生成されなかった場合
        }

    }

    /**
     * 「直近の訪問看護計画書情報の読込」イベントです。
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
        switch (msgID) {
        case ACMessageBox.RESULT_OK:
            // 「OK」選択時
            // 処理を継続する。
            break;
        case ACMessageBox.RESULT_CANCEL:
            // 「キャンセル」選択時
            return;
        // 処理を中断する。
        }
        // ※過去の直近の情報を取得
        // SQL文取得関数への渡りパラメータ(レコード) sqlParamに下記パラメータを設定する。
        VRMap sqlParam = null;
        sqlParam = new VRHashMap();
        // KEY : PATIENT_ID
        sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
        // KEY : TARGET_DATE
        sqlParam.setData("TARGET_DATE", (Date) getTargetDateSource());
        // 過去の直近の情報を取得するためのSQL文を取得する。
        // 取得したSQL文を発行する。
        VRList lastPlanData = getDBManager().executeQuery(
                getSQL_GET_LAST_PLAN(sqlParam));
        // 取得件数が0件より多い場合
        if (lastPlanData.size() > 0) {

            // 取得レコード集合の1件目のレコードを退避する。
            VRMap lastPlanDataMap = (VRMap) lastPlanData.getData(0);

            // contetnsパネルのsourceとして、退避したレコードを設定する。
            getContents().setSource(lastPlanDataMap);

            // bindSourceを実行し、退避したレコードの値をcontentsパネルに展開する。
            getContents().bindSource();

        } else {
            // 取得件数が0件の場合
            // 過去情報が存在しなかったことを通知するメッセージを表示する。
            QkanMessageList.getInstance().QC001_NOTICE_HAS_NO_LAST_DATA();
            // データの上書は行わない。
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

        // 現在選択されてる行数を格納する変数
        int n = 0;
        // 現在選択されている行数取得
        if (getPlanNotes().isSelected()) {
            n = getPlanNotes().getSelectedModelRow();
        }

        // エラーがない場合
        // 処理を継続する。
        // ※保存処理
        // 保存処理を行う。
        if (doInsert()) {
            // 登録完了メッセージを表示する
            QkanMessageList.getInstance().INSERT_SUCCESSED();
        }

        // 選択されていた行にフォーカスを当てる。
        getPlanNotes().setSelectedModelRow(n);

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

        // 現在選択されてる行数を格納する変数
        int n = 0;
        // 現在選択されている行数取得
        if (getPlanNotes().isSelected()) {
            n = getPlanNotes().getSelectedModelRow();
        }

        // エラーがない場合
        // 処理を継続する。
        // ※保存処理
        // 保存処理を行う。
        if (doUpdate()) {
            // 更新完了メッセージを表示する。
            QkanMessageList.getInstance().UPDATE_SUCCESSED();
        }

        // 選択されていた行にフォーカスを当てる。
        getPlanNotes().setSelectedModelRow(n);

    }

    /**
     * 「選択事業所の管理者氏名の設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void providerNameActionPerformed(ActionEvent e) throws Exception {
        // コンボに入力されている事業所名から、その事業所の「管理者氏名(ADMINISTRATOR_NAME)」(文字列)を取得する。
        // getAdministratorName((コンボの選択アイテムのレコード));       

        if (getProviderName().getSelectedIndex() >= 0) {
            // 画面の「管理者氏名(administratorName)」に、取得した文字列を設定する。

            String adName = "";

            adName = (String) getAdministratorName((VRMap) getProviderName()
                    .getSelectedModelItem());

            getAdministratorName().setText(adName);

        }

    }

    /**
     * 「問題点・解決策の追加」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void planNoteEditButtonAddActionPerformed(ActionEvent e)
            throws Exception {
        // ※入力チェック
        // 入力チェックを行う。
        if (!checkNoteValue()) {
            // 入力エラーがあった場合
            // 処理を中断する。
            return;
        }
        // 入力エラーがなかった場合
        // 処理を継続する。
        // ※テーブルへの行の追加
        // 画面の「問題点・解決策一覧(planNotes)」に、入力内容(planNoteEditDate,
        // planNoteEditComment)を追加する。

        VRMap tableSource = null;
        // テーブル用のソース取得用のハッシュマップを初期化
        tableSource = new VRHashMap();
        // applySourceするパネルを指定
        getTabsNotes().setSource(tableSource);
        // 画面上の情報を取得
        getTabsNotes().applySource();

        // 指定したフォーマットで変換した日付を格納する
        tableSource.setData("NOTE_DATE", (Date) tableSource
                .getData("NOTE_DATE"));

        getPlanNoteData().add(tableSource);

        // 追加下レコードの行にフォーカスを当てる
        getPlanNotes().setSelectedSortedRow(getPlanNoteData().size() - 1);

        // テーブルフラグを変更有りにする
        setPlanNoteChangeFlag(true);

        // 登録件数が0件以上の場合は編集、削除押下可能にする
        if (getPlanNoteData().size() >= 0) {
            setState_NOTE_SELECTED();
        }

    }

    /**
     * 「問題点・解決策の更新」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void planNoteEditButtonEditActionPerformed(ActionEvent e)
            throws Exception {
        // ※入力チェック
        // 入力チェックを行う。
        if (!checkNoteValue()) {
            // 入力エラーがあった場合
            // 処理を中断する。
            return;
        }
        if (getPlanNotes().isSelected()) {
            // 入力エラーがなかった場合
            // 処理を継続する。
            // ※テーブルの行の更新
            // 画面の「問題点・解決策一覧(planNotes)」上の選択行を、入力内容(planNoteEditDate,
            // planNoteEditComment)で更新する。
            VRHashMap planNoteSource = new VRHashMap();
            // 情報を取得するハッシュマップ生成する。
            getTabsNotes().setSource(planNoteSource);
            getTabsNotes().applySource();

            planNoteSource.setData("NOTE_DATE", (Date) VRBindPathParser.get(
                    "NOTE_DATE", planNoteSource));
            // テーブルの元データを参照設定する。
            VRList pND = (VRList) getPlanNoteData();
            // テーブルの選択行のデータと入力データの差し替えを行う
            pND.setData(getPlanNotes().getSelectedModelRow(), planNoteSource);

            getTabsNotes().revalidate();
            getTabsNotes().repaint();

            // テーブルフラグを変更有りにする
            setPlanNoteChangeFlag(true);
        }

    }

    /**
     * 「問題点・解決策の削除」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void planNoteEditButtonDeleteActionPerformed(ActionEvent e)
            throws Exception {
        // ※テーブルの行の削除
        // 画面の「問題点・解決策一覧(planNotes)」上から、選択行のデータを削除する。
        // 選択行を削除（テーブルに反映）
        // 選択されているかチェックする。
        if (getPlanNotes().isSelected()) {

            // 選択されていた場合削除する。
            // 選択されている行のデータと対応する内部データ番号を返す
            int sel = getPlanNotes().getSelectedModelRow();

            // 選択行のデータを削除する
            getPlanNoteData().removeData(sel);

            // 削除後の理想となる列番号を設定する。
            getPlanNotes().setSelectedSortedRowOnAfterDelete(sel);

            // テーブルフラグを変更有りにする
            setPlanNoteChangeFlag(true);

            // もしテーブルの行数が0行になった場合、編集、削除ボタンを押下不能にする。
            if (getPlanNoteData().size() <= 0) {
                // 画面状態を変更する
                setState_NOTE_UNSELECTED();
                // クリアする
                getPlanNoteEditDate().setText("");
                getPlanNoteEditComment().setText("");

            }
        }
    }

    /**
     * 「問題点・解決策のクリア」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void planNoteEditButtonClearActionPerformed(ActionEvent e)
            throws Exception {
        // ※問題点・解決策の入力欄をクリアする。
        // 日付テキスト（planNoteEditDate）に ""を設定する。
        getPlanNoteEditDate().setText("");
        // 問題点・解決策コメント（planNoteEditComment）に""を設定する。
        getPlanNoteEditComment().setText("");

    }

    /**
     * 「セル選択イベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void planNotesSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 問題点・解決策のセル選択のイベント
        // 選択行のレコードを取得する。
        if (getPlanNotes().isSelected()) {

            // 現在選択中のレコードを取得する
            VRMap selectMap = (VRMap) getPlanNoteData().getData(
                    getPlanNotes().getSelectedModelRow());

            // 取得したレコードをセットする
            getPlanNoteEditDates().setSource(selectMap);

            // レコード中の PLAN_DATE と PLAN_COMMENT をテキストに表示する。
            // セットしたレコードを展開する
            getPlanNoteEditDates().bindSource();

        } else {
            // クリアする
            getPlanNoteEditDate().setText("");
            getPlanNoteEditComment().setText("");
        }

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        try {
            VRHashMap param = new VRHashMap();
            param.setData("PATIENT_ID", "1");
            // param.setData("TARGET_DATE", new Date(105, 12, 5));

            Date result = ACDateUtilities.createDate(2006, 1, 18);
            param.setData("TARGET_DATE", (Date) result);

            System.out.println(VRBindPathParser.get("TARGET_DATE", param));

            ACFrame.setVRLookAndFeel();
            ACFrame.getInstance().setFrameEventProcesser(
                    new QkanFrameEventProcesser());
            QkanCommon.debugInitialize();
            // ACFrame.debugStart(new
            // ACAffairInfo(QC001.class.getName(),param));
            ACAffairInfo affair = new ACAffairInfo(QC001.class.getName(), param);
            // ACFrame.getInstance().next(affair);
            ACFrame.debugStart(affair);
            // ACFrame.getInstance().next(affair);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 内部関数

    /**
     * 「ウィンドウタイトルの設定」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void initialize() throws Exception {

        // ※ウィンドウタイトル・業務ボタンバーの設定
        setAffairTitle("QC001", "0", getButtons());

        // 表示する対象年月を作成する処理
        Date from = getTargetDateSource();
        // 年号（和暦）を取得する
        int eraYear = ACDateUtilities.getEraYear(from);
        // 元号(正式名称）を取得
        String result = ACDateUtilities.getEraFull(from);
        // 月を取得
        int month = ACDateUtilities.getMonth(from);

        getTargetDate().setText(
                String.valueOf(result + eraYear + "年" + month + "月"));

        // 要介護度の初期値の設定
        getYokaigodo().setSelectedIndex(1);
        
        // ※コンボのアイテムの初期設定
        // ※指定訪問看護ステーション名(providerName)
        // サービス提供事業所取得関数に渡すパラメータ(レコード集合) servicesを生成する。
        VRArrayList services = new VRArrayList();
        // servicesに以下の数値型の値を設定する。
        // 11311
        // 20101
        services.add(new Integer(11311));
        services.add(new Integer(20101));

        // 訪問看護を提供する事業所を取得する。
        VRList stationList = new VRArrayList();
        stationList = QkanCommon.getProviderInfo(getDBManager(), services);

        // 取得したレコード集合を「指定訪問看護ステーション名」コンボに設定する。
        getProviderName().setModel(stationList);

        // 問題点・解決策テーブルの変更確認フラグ初期設定を行う
        setPlanNoteChangeFlag(false);

        // 強制戻りでチェックフラグの初期設定を行う。
        setForciblyBackCheckFlag(false);

    }

    /**
     * 「訪問看護計画書情報の取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFind() throws Exception {
        // ※DBから訪問看護計画書情報を取得
        // SQL文取得関数への渡りパラメータ(レコード) sqlParamに下記パラメータを設定する。
        VRHashMap sqlParam = new VRHashMap();
        VRMap planDataMap = null;

        // 初期設定を行う
        initialize();

        // 初期化
        planDataMap = new VRHashMap();

        // 参照先決定
        planDataMap = getPlanData();

        // KEY : PATIENT_ID
        // KEY : TARGET_DATE
        sqlParam.setData("PATIENT_ID", String.valueOf(getPatientID()));
        sqlParam.setData("TARGET_DATE", (Date) getTargetDateSource());

        // ※利用者情報をDBから取得
        // 対象利用者(利用者一覧で選択された利用者)の基本情報を取得する。
        VRList patientInfoList = QkanCommon.getPatientInfo(getDBManager(),
                getPatientID());
        // 取得できなかった場合

        if (patientInfoList.size() < 1) {
            // エラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_FIND
            int msgID = QkanMessageList.getInstance()
                    .ERROR_OF_PASSIVE_CHECK_ON_FIND();
            // 「QU001 利用者一覧」画面に戻る。(処理を抜ける)
            // エラー発生時強制戻り判別
            setForciblyBackCheckFlag(true);
            ACFrame.getInstance().back();
            return;                  
        } else {
            // 取得できた場合
            // 処理を継続する。
            // 取得したレコードをplanDataに設定する。
            planDataMap.putAll((VRMap) patientInfoList.getData(0));

        }

        // 要介護度を取得
        VRList patientYokaigo = QkanCommon.getPatientInsureInfoOnEndOfMonth(
                getDBManager(), getTargetDateSource(), getPatientID());

        //
//        if (patientYokaigo.size() < 1) {
//            // エラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_FIND
//            int msgID = QkanMessageList.getInstance()
//                    .ERROR_OF_NO_NINTEI_HISTORY();
//            // 「QU001 利用者一覧」画面に戻る。(処理を抜ける)
//
//            // エラー発生時強制戻り判別
//            setForciblyBackCheckFlag(true);
//            ACFrame.getInstance().back();
//            return;
//        } 
        
        if (!(patientYokaigo == null || patientYokaigo.size() == 0)) {
			// 取得できた場合
			// 取得したレコードをplanDataに設定する。
			planDataMap.putAll((VRMap) patientYokaigo.getData(0));

		}

        // ※年齢の取得
        // システムから、システム日付を取得する。
        QkanSystemInformation.getInstance().getSystemDate();

        // 利用者生年月日、及びシステム日付から年齢を算出する。
        // calcAge((取得したレコードのPATIENT_BIRTHDAY), (システム日付));
        // planDataに下記の値を設定する。
        // KEY : PATIENT_AGE
        if (VRBindPathParser.get("PATIENT_BIRTHDAY", getPlanData()) != null) {
            int ageInt = QkanCommon.calcAge((Date) VRBindPathParser.get(
                    "PATIENT_BIRTHDAY", getPlanData()));
            planDataMap.setData("PATIENT_AGE", new Integer(ageInt));
        }

        // ※利用者氏名の取得
        // 利用者の姓・名を連結し、利用者のフルネームを取得する。
        // toFullName((planDataのKEY:PATIENT_FAMILY_NAMEのVALUE),
        // (planDataのKEY:PATIENT_FIRST_NAMEのVALUE));
        // planDataに下記の値を設定する。
        // KEY : PATIENT_NAME
        planDataMap.setData("PATIENT_NAME", QkanCommon.toFullName(
                VRBindPathParser.get("PATIENT_FAMILY_NAME", getPlanData()),
                VRBindPathParser.get("PATIENT_FIRST_NAME", getPlanData())));

        // 訪問看護計画書情報取得用のSQL文を取得する。
        // 取得したSQL文を発行する。
        VRList planList = getDBManager()
                .executeQuery(getSQL_GET_PLAN(sqlParam));

        // 取得件数が0件の場合
        if (planList.size() <= 0) {
            // processModeにPROCESS_MODE_INSERTを設定する。(登録モード)
            setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
            // 登録ボタンを表示する。
            setState_PROCESS_MODE_INSERT();
            // planDataをcontentsパネルに設定し、createSourceを実行する。
            VRMap clearMap = (VRMap) getContents().createSource();
            // planDataに、初期値を設定する。
            planDataMap.setData(clearMap);

            setInitValue();
        } else {

            // 取得件数が0件より多い場合
            // processModeにPROCESS_MODE_UPDATEを設定する。(更新モード)
            setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

            // 更新ボタンを表示する。
            setState_PROCESS_MODE_UPDATE();

            // planDataに、取得したレコード集合の1件目のレコードの値を追加する。
            planDataMap.putAll((VRMap) planList.getData(0));

            // パッシブキーを登録する。
            getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY_PLAN(),
                    planList);
        }

        // contentsパネルのsourceとして、planDataを設定する。
        getContents().setSource(getPlanData());
        // bindSourceを実行し、planDataの値をcontentsパネルに展開する。
        getContents().bindSource();
        // ※訪問看護計画書・問題点・解決策情報の取得、設定
        // SQL文取得関数への渡りパラメータ(レコード) sqlParamに下記パラメータを設定する。
        // KEY : PATIENT_ID VALUE : patientID (退避した渡りパラメータ)
        // KEY : NOTE_DATE VALUE : targetDateSource + 1ヶ月 (対象年月の翌月1日を設定)
        sqlParam.clear();
        sqlParam.setData("PATIENT_ID", String.valueOf(getPatientID()));
        // 対象年月＋１日を設定
        Date result = ACDateUtilities.addMonth(getTargetDateSource(), 1);
        sqlParam.setData("NOTE_DATE", result);
        // 訪問看護計画書・問題点・解決策情報取得用のSQL文を取得する。

        // 取得したSQL文を発行し、結果をplanNoteDataに格納する。

        // getPlanNoteData().setData(getDBManager().executeQuery(getSQL_GET_PLAN_NOTE(sqlParam)));
        VRList nd = getDBManager().executeQuery(getSQL_GET_PLAN_NOTE(sqlParam));

        if (nd.size() > 0) {
            getPlanNoteData().clearData();
            getPlanNoteData().addAll((VRList) nd);
        }
        // 取得件数が0件より多い場合
        // テーブルモデルを作成し設定する。
        ACTableModelAdapter planTableModel = new ACTableModelAdapter();

        planTableModel.setColumns(new String[] { "NOTE_DATE", "NOTE_COMMENT" });

        if (getPlanNoteData().getDataSize() > 0) {

            // 画面の「問題点・解決策一覧(planNotes)」に、取得したレコード集合を設定する。
            // getPlanNotes().setModel()
            // 0 : NOTE_DATE
            // 1 : NOTE_COMMENT
            getPlanNotes().setModel(planTableModel);
            // テーブルを表示
            planTableModel.setAdaptee(getPlanNoteData());

            // パッシブキーを登録する。
            // reservedPassive(PASSIVE_CHECK_KEY_PLAN_NOTE, (取得したレコード集合));

            // getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY_PLAN_NOTE(),getPlanNoteData());

        } else {
            // 0件の場合
            // 画面の「問題点・解決策一覧(planNotes)」は、列ヘッダの設定のみ行う。
            getPlanNotes().setModel(planTableModel);
            planTableModel.setAdaptee(getPlanNoteData());
            // パッシブキーを登録する。
            // getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY_PLAN_NOTE(),getPlanNoteData());

        }

        // 変数noteCountに、取得件数を退避する。
        setNoteCount(getPlanNoteData().size());

        // ※初期状態の設定
        // 画面の初期状態を設定する。
        setState_INIT_STATE();
        // 現在の登録件数をチェックする
        if (getNoteMaxCount() == 0) {
            // 問題点・解決策が１つも登録されていない場合
            setState_NOTE_UNSELECTED();
        } else {
            // １つでも登録されていた場合
            setState_NOTE_SELECTED();
        }

        // スナップショットの撮影対象を指定する。
        getSnapshot().setRootContainer(getContents());

        // ※スナップショットの撮影
        // スナップショット撮影除外対象格納用のレコード集合excludedInstanceを生成する。
        VRList excludedInstance = null;
        excludedInstance = new VRArrayList();

        // excludedInstanceに下記のインスタンスを追加する。
        // ・planNoteEditDates
        excludedInstance.add(getPlanNoteEdits());

        // 撮影対象から除外するインスタンスを設定する。
        getSnapshot().setExclusions(excludedInstance);
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
        // SQL文取得関数への渡りパラメータ(レコード) sqlParamを生成する。
        VRMap sqlParam = null;
        sqlParam = new VRHashMap();

        // sqlParamに下記の値を設定する。
        // KEY :PATIENT_ID
        sqlParam.setData("PATIENT_ID", String.valueOf(getPatientID()));

        // 「訪問看護ステーション履歴TABLE(PATIENT_STATION_HISTORY)」の情報取得用のSQL文を取得する。
        // 取得したSQL文を発行する。
        VRList patientStationHistory = getDBManager().executeQuery(
                getSQL_GET_PATIENT_STATION_HISTORY(sqlParam));

        // 取得件数が0件より多い場合
        // HashMapを一時的に格納するMap
        VRMap homonData = null;

        // 初期化
        homonData = new VRHashMap();

        // 参照設定
        VRMap setMap = getPlanData();

        if (patientStationHistory.size() > 0) {
            // 取得したレコード集合の最初のレコードを退避する。
            VRMap ps = (VRMap) patientStationHistory.getData(0);

            // planDataに下記の値を設定する。
            // KEY : DOCTOR_NAME
            // DOCTOR_NAMEが存在しているかチェックする。
            if (VRBindPathParser.has("DOCTOR_NAME", ps)) {
                homonData.setData("DOCTOR_NAME", VRBindPathParser.get(
                        "DOCTOR_NAME", ps));
                setMap.putAll(homonData);
            } else {
                System.out.println("データがないです");
            }

        } else {
            // 取得件数が0件の場合
            // planDataに下記の値を設定する。
            // KEY : DOCTOR_NAME
            homonData.setData("DOCTOR_NAME", "");

            setMap.putAll(homonData);
        }
        // ※作成年月の設定
        // システムから、「システム日付」を取得する。
        Date systemDate = QkanSystemInformation.getInstance().getSystemDate();

        // planDataに下記の値を設定する。
        // KEY : CREATE_DATE
        homonData.setData("CREATE_DATE", systemDate);
        setMap.putAll(homonData);

        // ※訪問看護提供事業所コンボの初期選択アイテムの設定
        // ログイン事業所番号を取得する。
        String loginProvider = QkanSystemInformation.getInstance()
                .getLoginProviderID();

        // VRMap stationMap = null;
        VRMap stationMap = new VRHashMap();

        // 初期値を設定する。
        setMap.setData("PROVIDER_NAME", "");

        // 訪問看護提供事業所コンボの中に、ログイン事業所番号と同一のIDの事業所が存在するかどうかチェックする。
        for (int i = 0; getProviderName().getModel().getSize() > i; i++) {

            stationMap = (VRMap) getProviderName().getModelItem(i);

            // ログイン事業所と同一の事業所が存在した場合
            if (loginProvider.equals(stationMap.getData("PROVIDER_ID"))) {
                // 存在する場合
                // planDataに下記の値を設定する。
                // KEY : PROVIDER_NAME
                getProviderName().setSelectedIndex(i);

                // 存在しない場合
                // planDataに下記の値を設定する。
                // KEY : PROVIDER_NAME

            }
        }
        // ※管理者氏名の設定
        // コンボに入力されている事業所名から、その事業所の「管理者氏名(ADMINISTRATOR_NAME)」を取得する。
        // getAdministratorName((コンボの選択アイテムのレコード));

        // planDataに下記の値を設定する。
        // KEY : ADMINISTRATOR_NAME
        // 事業所名は選択イベントで設定するため除去
        setMap.remove("PROVIDER_NAME");

        // 画面上に初期値として展開する
        getContents().setSource(setMap);
        getContents().bindSource();

    }

    /**
     * 「入力チェック(問題点・解決策)」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean checkNoteValue() throws Exception {
        // ※入力チェック
        // ※「問題点・解決策」日付項目のチェック
        // 画面の「問題点・解決策・日付(planNoteEditDate)」の値をチェックする。
        if (ACTextUtilities.isNullText(getPlanNoteEditDate().getText())) {
            // 未入力の場合
            // エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT
            // 処理を中断する。(入力エラー)
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
                    "問題点・解決策の日付");

            // フォーカスを当てる
            getPlanNoteEditDate().requestFocus();

            // 処理を中断する。(入力エラー)
            return false;
        }

        // ※｢問題点・解決策・日付｣の値が不正でないかチェックする。
        if (!getPlanNoteEditDate().isValidDate()) {
            // 処理を中断する。(不正な日付)
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("問題点・解決策の");

            // フォーカスを当てる
            getPlanNoteEditDate().requestFocus();

            // 処理を中断する。(入力エラー)
            return false;
        }
        
        // ※「問題点・解決策」コメント項目のチェック
        // 画面の「問題点・解決策・コメント(planNoteEditComment)」の値をチェックする。
        if (ACTextUtilities.isNullText(getPlanNoteEditComment().getText())) {
            // 未入力の場合
            // エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
                    "問題点・解決策の内容");

            // フォーカスを当てる
            getPlanNoteEditComment().requestFocus();

            // 処理を中断する。(入力エラー)
            return false;
        }

        // 上記チェックで入力エラーが発生しなかった場合、「正常入力」とする。
        return true;
    }

    /**
     * 「登録処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean doInsert() throws Exception {
        // ※パッシブチェックのための準備
        // planDataに、画面から抽出した情報を格納する。
        VRMap planDataMap = null;
        planDataMap = new VRHashMap();
        planDataMap = getPlanData();

        // DBマネージャー定義
        ACDBManager dbm = getDBManager();

        try {
            // トランザクション開始
            dbm.beginTransaction();

            getContents().setSource(planDataMap);
            getContents().applySource();
            // planDataに下記の値を追加する。
            // KEY : PATIENT_ID
            // KEY : TARGET_DATE
            planDataMap.setData("PATIENT_ID", new Integer(getPatientID()));
            planDataMap.setData("TARGET_DATE", (Date) getTargetDateSource());

            // パッシブタスクをクリアする。
            getPassiveChecker().clearPassiveTask();

            // ※訪問看護計画書情報のパッシブタスクを登録
            // 訪問看護計画書情報のパッシブキーを登録する。
            // 訪問看護計画書情報追加用のパッシブタスクを登録する。
            getPassiveChecker().addPassiveInsertTask(
                    getPASSIVE_CHECK_KEY_PLAN(), planDataMap);

            // ※訪問看護計画書・問題点・解決策のパッシブタスクを登録
            // 訪問看護計画書・問題点・解決策レコードの件数を取得する。
            if (getNoteMaxCount() != getNoteCount()) {
                //テーブルロック解除のためロールバック
                dbm.rollbackTransaction();
                // 取得した件数とnoteCountの値とを比較し、現在とレコード取得時の件数の違いをチェックする。
                // 件数が異なる場合
                // パッシブエラーメッセージを表示する。
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();

                // 処理を中断する。(異常終了)
                return false;

            }
            // 件数が同じ場合
            // 処理を継続する。

            // ※パッシブチェック
            // パッシブチェックを実行する。
            if (!getPassiveChecker().passiveCheck(dbm)) {
                //テーブルロック解除のためロールバック
                dbm.rollbackTransaction();
                // パッシブエラーがある場合
                // パッシブエラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // 処理を中断する。(異常終了)
                return false;
            }

            // パッシブエラーがない場合
            // 処理を継続する。
            // ※訪問看護計画書の登録
            // 訪問看護計画書情報登録用のSQL文を取得する。
            // 取得したSQL文を発行する。
            dbm.executeUpdate(getSQL_INSERT_PLAN(planDataMap));

            // 問題点解決策が未入力だった場合
            // ※訪問看護計画書・問題点・解決策情報の登録
            // noteCountの値をチェックする。
            // 0件の場合
            // DELETE処理は行わない。(何もせず、次へ。)
            if (getNoteMaxCount() > 0) {
                // 0件より多い場合
                // 訪問看護計画書・問題点・解決策情報削除用のSQL文を取得する。
                // 取得したSQL文を発行する。
                dbm.executeUpdate(getSQL_DELETE_PLAN_NOTE(planDataMap));
            }
            // planNoteDataの最初のレコードをplanNoteDataMapに格納する。
            VRMap planNoteDataMap = null;
            // 初期化処理
            planNoteDataMap = new VRHashMap();

            if (getPlanNoteData().size() > 0) {
                // 件数分登録する

                for (int i = 0; i < getPlanNoteData().size(); i++) {
                    planNoteDataMap = (VRMap) getPlanNoteData().getData(i);
                    planNoteDataMap.setData("PATIENT_ID", new Integer(
                            getPatientID()));
                    planNoteDataMap.setData("NOTE_ID", new Integer(i));

                    // 訪問看護計画書・問題点・解決策情報登録用のSQL文を取得する。
                    // 取得したSQL文を発行する。
                    dbm.executeUpdate(getSQL_INSERT_PLAN_NOTE(planNoteDataMap));
                }
            }

            // ※コミット/ロールバック

            // 上記一連のSQL発行処理でエラーがなかった場合
            // 処理をコミットする。
            dbm.commitTransaction();
            // 更新モードに変更する
            setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);

            // 検索処理を行う。
            doFind();

            return true;
        } catch (Exception sqlEx) {
            // TODO: handle exception
            // 処理を終了する。(正常終了)
            // SQL発行処理でエラーがあった場合
            // 処理をロールSバックする。
            sqlEx.printStackTrace();

            dbm.rollbackTransaction();

            // 処理を中断する。(異常終了)
            throw sqlEx;
        }

    }

    /**
     * 「更新処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean doUpdate() throws Exception {

        // ※パッシブチェックのための準備
        VRMap planData = getPlanData();
        // planDataに、画面から抽出した情報を格納する。
        getContents().setSource(planData);
        getContents().applySource();
        VRMap sqlParam = null;
        sqlParam = new VRHashMap();

        ACDBManager dbm = getDBManager();

        try {
            // トランザクション開始
            dbm.beginTransaction();

            // planDataに下記の値を追加する。
            // KEY : PATIENT_ID
            // KEY : TARGET_DATE
            // SQL取得関数への渡しパラメータ(レコード) sqlParamを生成する。
            sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
            sqlParam.setData("TARGET_DATE", (Date) getTargetDateSource());
            sqlParam.setData("NOTE_DATE", (Date) getTargetDateSource());

            // パッシブタスクをクリアする。
            getPassiveChecker().clearPassiveTask();

            // ※訪問看護計画書情報のパッシブタスクを登録
            // processModeの値をチェックする。
            // 訪問看護計画書情報更新用のパッシブタスクを登録する。
            getPassiveChecker().addPassiveUpdateTask(
                    getPASSIVE_CHECK_KEY_PLAN());

            // 取得した件数とnoteMaxCountの値とを比較し、現在とレコード取得時の件数の違いをチェックする。
            if (getNoteCount() != getNoteMaxCount()) {
                //テーブルロック解除のためロールバック
                getDBManager().rollbackTransaction();
                // 件数が異なる場合
                // パッシブエラーメッセージを表示する。
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // 処理を中断する。(異常終了)
                return false;
            }
            // 件数が同じ場合
            // 処理を継続する。

            // noteMaxCountの値をチェックする。

            // ※パッシブチェック
            // パッシブチェックを実行する。
            if (!getPassiveChecker().passiveCheck(dbm)) {
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
            // 処理を継続する。
            // ※訪問看護計画書の登録
            // 訪問看護計画書情報更新用のSQL文を取得する。
            // 取得したSQL文を発行する。
            dbm.executeUpdate(getSQL_UPDATE_PLAN(getPlanData()));
            // ※訪問看護計画書・問題点・解決策情報の登録
            // oteCountの値をチェックする。
            // 0件の場合
            // DELETE処理は行わない。(何もせず、次へ。)
            if (getNoteMaxCount() > 0) {
                // 0件より多い場合
                // 訪問看護計画書・問題点・解決策情報削除用のSQL文を取得する。
                // 取得したSQL文を発行する。
                dbm.executeUpdate(getSQL_DELETE_PLAN_NOTE(sqlParam));
            }
            VRMap planNoteDataMap = null;
            planNoteDataMap = new VRHashMap();
            if (getPlanNoteData().size() > 0) {
                for (int i = 0; i < getPlanNoteData().size(); i++) {
                    // planNoteDataの最初のレコードをplanNoteDataMapに格納する。
                    planNoteDataMap = (VRMap) getPlanNoteData().getData(i);
                    planNoteDataMap.setData("PATIENT_ID", new Integer(
                            getPatientID()));
                    planNoteDataMap.setData("NOTE_ID", new Integer(i));
                    // 訪問看護計画書・問題点・解決策情報登録用のSQL文を取得する。
                    // 取得したSQL文を発行する。
                    dbm.executeUpdate(getSQL_INSERT_PLAN_NOTE(planNoteDataMap));
                }
            }

            // ※コミット/ロールバック
            // 上記一連のSQL発行処理でエラーがなかった場合
            // 処理をコミットする。
            dbm.commitTransaction();

            // 検索処理を行う。
            doFind();

            return true;

            // 処理を終了する。(正常終了)
            // SQL発行処理でエラーがあった場合
        } catch (Exception e) {
            // TODO: handle exception

            e.printStackTrace();
            // 処理をロールバックする。
            dbm.rollbackTransaction();
            // 処理を中断する。(異常終了)
            throw e;

        }
    }

    /**
     * 「問題点・解決策情報の件数取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public int getNoteMaxCount() throws Exception {
        // ※問題点・解決策情報の件数取得
        // SQL取得関数への渡しパラメータ(レコード) sqlParamを生成する。
        VRMap sqlParam = null;

        // sqlParamに下記パラメータを設定する。
        sqlParam = new VRHashMap();
        // KEY : PATIENT_ID
        // KEY : NOTE_DATE
        sqlParam.setData("PATIENT_ID", String.valueOf(getPatientID()));
        Date result = ACDateUtilities.addMonth(getTargetDateSource(), 1);
        sqlParam.setData("NOTE_DATE", result);

        // 訪問看護計画書・問題点・解決策レコードの件数取得用のSQL文を取得する。
        // 取得したSQL文を発行する。
        VRList planNoteDataList = getDBManager().executeQuery(
                getSQL_GET_NOTE_COUNT(sqlParam));

        // 取得したレコード集合のうち、最初のレコードのKEY : NOTE_COUNTのVALUEを取得する。(数値型)
        int planNoteData = Integer.parseInt(String.valueOf(VRBindPathParser
                .get("NOTE_COUNT", (VRMap) planNoteDataList.getData(0))));

        // 取得した数値を、関数の変数として返す。
        return planNoteData;

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
        } else {
            // null以外の場合
            // 処理を継続する。
            // ※PROVIDER_IDの抽出
            // 引数で渡されたレコードから、KEY : PROVIDER_IDのVALUEを取得する。
            // 取得できた場合
            // 処理を継続する。
            if (!VRBindPathParser.has("PROVIDER_ID", rec)) {
                // 取得できなかった場合
                // 空白を返す。(処理終了)
                return "";
            }
            // ※事業所のサービス情報の取得
            // 事業所のサービス詳細情報を取得する。
            StringBuffer sb = new StringBuffer();
            sb.append(" SYSTEM_SERVICE_KIND_DETAIL IN (11311,20101)");
            sb.append(" AND PROVIDER_ID = ");
            sb.append(String.valueOf("'"+ VRBindPathParser.get("PROVIDER_ID",rec) + "'"));
            
            VRList providerServiceList = QkanCommon.getProviderServiceDetailCustom(
                    getDBManager(),sb.toString());
            // getProviderServiceDetail((取得した事業所ID));
            if (providerServiceList.size() <= 0) {
                // 取得件数が0件の場合
                // 空白を返す。(処理終了)
                return "";

            } else {
                // 取得件数が0件より多い場合
                // 処理を継続する。
                // ※管理者氏名の抽出
                // 取得したレコード集合の、最初のレコードの KEY : 1130103のVALUEを取得する。
                VRMap administratorMap = (VRMap) providerServiceList.getData(0);

                if (VRBindPathParser.get("1130103", administratorMap) == null) {
                    return "";
                } else {
                    // 取得した値を戻り値として返す。(処理終了)
                    return String.valueOf(VRBindPathParser.get("1130103",
                            administratorMap));
                }
            }
        }
    }

    /**
     * 「入力チェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean checkValidInput() throws Exception {
        // ※入力チェック
        // ※作成年月日・未入力チェック
        // 画面の「作成年月日(createDate)」の値をチェックする。
        if (ACTextUtilities.isNullText(getCreateDate().getText())) {
            // 入力されている場合
            // 処理を継続する。
            // 未入力の場合
            // エラーメッセージを表示する。
            QkanMessageList.getInstance()
                    .ERROR_OF_NEED_CHECK_FOR_INPUT("作成年月日");

            // QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(sqlParam);
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
            // エラーメッセージを表示する。
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

}
