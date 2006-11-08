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
 * 開発者: 田中　統蔵
 * 作成日: 2006/08/19  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 訪問看護療養費領収書一覧 (011)
 * プログラム 訪問看護療養費領収書一覧 (QP011)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp011;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qp.qp012.QP012;

/**
 * 訪問看護療養費領収書一覧(QP011)
 */
public class QP011 extends QP011Event {
    /**
     * コンストラクタです。
     */
    public QP011() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    public boolean canBack(VRMap parameters) throws Exception {
        // 遷移パラメタに以下を設定する。
        // KEY : TARGET_DATE, VALUE : 請求年月(billDate)
        VRBindPathParser.set("TARGET_DATE", parameters, getBillDate());
        // KEY : PATIENT_ID, VALUE : 利用者ID(patientID)
        VRBindPathParser.set("PATIENT_ID", parameters, ACCastUtilities
                .toInteger(getPatientID()));
        // 前画面遷移を許可する。
        return true;
    }

    /**
     * 初期化処理を行ないます。
     * 
     * @param affair 業務情報
     * @throws Exception 処理例外
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        // 初期化を行う。
        // ※ウィンドウタイトル・業務ボタンバーの設定
        // 業務のウィンドウタイトル・ボタンバーにタイトルを設定する。
        setAffairTitle("QP011", getButtons());
        // ※パッシブキー(BILL_PASSIVE_CHECK_KEY)を定義する。
        // テーブル：CLAIM_PATIENT_MEDICAL
        // キー：CLAIM_PATIENT_MEDICAL_ID
        // フォーマット：なし
        // クライアントタイムフィールド：LAST_TIME
        // サーバータイムフィールド：LAST_TIME
        setBILL_PASSIVE_CHECK_KEY(new ACPassiveKey("CLAIM_PATIENT_MEDICAL",
                new String[] { "CLAIM_PATIENT_MEDICAL_ID" }, "LAST_TIME",
                "LAST_TIME"));
        // ※テーブルモデルを定義する。
        ACTableModelAdapter model = new ACTableModelAdapter();
        model.setColumns(new String[] { "BILL_PRINTED", "BILL_SPAN_START",
                "BILL_SPAN_END", "BILL_PRINT_DATE", "BILL_FULL_TOTAL",
                "MEDICAL_INSURER_NO", "BILL_INSURE_TYPE", });
        setBillTableModel(model);
        getBills().setModel(getBillTableModel());
        // ※設定情報の初期化
        // ※利用者情報の設定
        // 遷移パラメタからキー「PATIENT_ID」で利用者IDを抜き出し、内部変数(patientID)に退避する。
        setPatientID(ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID",
                affair.getParameters()), 0));
        // 内部変数(patientID)を使用して利用者情報を検索する。
        VRList patients = QkanCommon.getPatientInfo(getDBManager(),
                getPatientID());
        if (patients.isEmpty()) {
            // 検索結果が0件の場合
            // 不正なパラメタもしくは削除された情報とみなし、メッセージを表示する。※メッセージID = NOT_FOUND
            QkanMessageList.getInstance().NOT_FOUND("利用者");
            // 前画面に戻り処理を中断する。
            ACFrame.getInstance().back();
            return;
        }

        // 設定展開用の内部変数レコードinfoを定義・生成する。
        VRMap info = new VRHashMap();
        VRMap patient = (VRMap) patients.getData();
        // レコードinfoにキー「PATIENT_CODE」で検索結果の利用者コードを設定する。
        VRBindPathParser.set("PATIENT_CODE", info, VRBindPathParser.get(
                "PATIENT_CODE", patient));
        // レコードinfoにキー「PATIENT_NAME」で検索結果の利用者氏名を設定する。
        VRBindPathParser.set("PATIENT_NAME", info, QkanCommon.toFullName(
                VRBindPathParser.get("PATIENT_FAMILY_NAME", patient),
                VRBindPathParser.get("PATIENT_FIRST_NAME", patient)));
        // ※対象年月の設定
        Object obj = VRBindPathParser
                .get("TARGET_DATE", affair.getParameters());
        if (obj instanceof Date) {
            // 遷移パラメタとして対象年月「TARGET_DATE」が渡されている場合
            // 請求年月(billDate)に、遷移パラメタの値「TARGET_DATE」を設定する。
            setBillDate((Date) obj);
        } else {
            // 遷移パラメタとして対象年月が渡されていない場合
            // システムから、「システム日付」を取得する。
            // 請求年月(billDate)に、取得したシステム日付を設定する。
            setBillDate(QkanSystemInformation.getInstance().getSystemDate());
        }
        // レコードinfoにキー「TARGET_DATE」で請求年月(billDate)を設定する。
        VRBindPathParser.set("TARGET_DATE", info, getBillDate());
        // レコードinfoにキー「BILL_DATE」で請求年月(billDate)を設定する。
        VRBindPathParser.set("BILL_DATE", info, getBillDate());
        // 請求年月(billDate)の末日を取得し、レコードinfoにキー「BILL_SPAN_END_DAY」で設定する。
        int lastDate = ACDateUtilities.getDayOfMonth(ACDateUtilities
                .toLastDayOfMonth(getBillDate()));
        VRBindPathParser.set("BILL_SPAN_END_DAY", info, ACCastUtilities
                .toInteger(lastDate));
        // ※入力可能な請求日の設定
        // 末日の日にちに応じて以下の4種類の正規表現を構築し、請求期間開始日(billSpanStartDay)と
        // 請求期間終了日(billSpanEndDay)の入力許可文字列として設定する。
        VRCharType charType;
        switch (lastDate) {
        case 28:
            // 末日が28の場合：^([1-9]|(1[0-9])|(2[0-8]))$
            charType = new VRCharType("LAST_DAY", "^([1-9]|(1[0-9])|(2[0-8]))$");
            break;
        case 29:
            // 末日が29の場合：^([1-9]|([1-2][0-9]))$
            charType = new VRCharType("LAST_DAY", "^([1-9]|([1-2][0-9]))$");
            break;
        case 30:
            // 末日が30の場合：^(([1-9])|([1-2][0-9])|(30))$
            charType = new VRCharType("LAST_DAY",
                    "^(([1-9])|([1-2][0-9])|(30))$");
            break;
        default:
            // 末日が31の場合：^(([1-9])|([1-2][0-9])|(3[0-1]))$
            charType = new VRCharType("LAST_DAY",
                    "^(([1-9])|([1-2][0-9])|(3[0-1]))$");
            break;
        }
        getBillSpanStartDay().setCharType(charType);
        getBillSpanEndDay().setCharType(charType);
        // レコードinfoをクライアント領域(contents)に設定・展開する。
        getContents().setSource(info);
        getContents().bindSource();

        // ※再現情報の展開
        // 遷移パラメタにキー「REPRODUCTION_PARAM」が含まれ、かつその値がレコードの場合
        Object reproductionParam = VRBindPathParser.get("REPRODUCTION_PARAM",
                affair.getParameters());
        if (reproductionParam instanceof VRMap) {
            // 遷移パラメタのキー「REPRODUCTION_MODE」が渡されている場合、その値で処理を分岐する。
            switch (ACCastUtilities.toInt(VRBindPathParser.get(
                    "REPRODUCTION_MODE", affair.getParameters()), 0)) {
            case QkanConstants.PROCESS_MODE_UPDATE:
                // 値が更新モードの定数の場合
                // 遷移パラメタのキー「REPRODUCTION_PARAM」の値を作成条件(createConditions)に割り当て・展開する。
                getCreateConditions().setSource((VRMap) reproductionParam);
                getCreateConditions().bindSource();
                // 遷移パラメタのキー「REPRODUCTION_PARAM」の値を検索条件(findConditions)に割り当て・展開する。
                getFindConditions().setSource((VRMap) reproductionParam);
                getFindConditions().bindSource();
                break;
            case QkanConstants.PROCESS_MODE_INSERT:
                // 値が登録モードの定数の場合
                // 遷移パラメタのキー「REPRODUCTION_PARAM」の値を作成条件(createConditions)に割り当て・展開する。
                getCreateConditions().setSource((VRMap) reproductionParam);
                getCreateConditions().bindSource();
                if (!VRBindPathParser.has("CLAIM_PATIENT_MEDICAL_ID", affair
                        .getParameters())) {
                    // 遷移パラメタとして領収書IDが渡されていない場合
                    // 遷移パラメタのキー「REPRODUCTION_PARAM」の値を検索条件(findConditions)に割り当て・展開する。
                    getFindConditions().setSource((VRMap) reproductionParam);
                    getFindConditions().bindSource();
                    //遷移パラメタにキー「CLAIM_PATIENT_MEDICAL_ID」で遷移パラメタのキー「REPRODUCTION_PARAM」の値から
                    //キー「CLAIM_PATIENT_MEDICAL_ID」で取得した値を設定する。
                    VRBindPathParser.set("CLAIM_PATIENT_MEDICAL_ID", affair
                            .getParameters(), VRBindPathParser.get(
                            "CLAIM_PATIENT_MEDICAL_ID",
                            (VRMap) reproductionParam));
                }
                break;
            }
            // 遷移パラメタからキー「REPRODUCTION_MODE」と「REPRODUCTION_PARAM」を削除する。
            affair.getParameters().remove("REPRODUCTION_MODE");
            affair.getParameters().remove("REPRODUCTION_PARAM");
        }

        // 検索を行う。
        doFind();

        // 遷移パラメタとして領収書IDが渡されている場合
        // 領収書IDに該当する領収書を選択する。
        int backID = ACBindUtilities.getMatchIndexFromValue(getBillData(),
                "CLAIM_PATIENT_MEDICAL_ID", VRBindPathParser.get(
                        "CLAIM_PATIENT_MEDICAL_ID", affair.getParameters()));
        if (backID >= 0) {
            getBills().setSelectedModelRow(backID);
            getBills().scrollSelectedToVisible();
        }
    }

    // コンポーネントイベント

    /**
     * 「検索」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void findActionPerformed(ActionEvent e) throws Exception {
        // 検索を行う。
        doFind();

    }

    /**
     * 「詳細画面に遷移」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void detailActionPerformed(ActionEvent e) throws Exception {
        // ※選択された領収書の情報で、次画面に遷移
        // 次画面に遷移する。
        doNext();

    }

    /**
     * 「新規作成」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // 新規に領収書を作成する。
        // ※入力チェック
        if (ACTextUtilities.isNullText(getBillSpanStartDay())) {
            // 請求期間開始日(billSpanStartDay)が未入力の場合
            // メッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("請求期間");
            // 請求期間開始日(billSpanStartDay)にフォーカスをあてる。
            getBillSpanStartDay().requestFocus();
            // 処理を中断する。
            return;
        }
        if (ACTextUtilities.isNullText(getBillSpanEndDay())) {
            // 請求期間終了日(billSpanEndDay)が未入力の場合
            // メッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("請求期間");
            // 請求期間終了日(billSpanEndDay)にフォーカスをあてる。
            getBillSpanEndDay().requestFocus();
            // 処理を中断する。
            return;
        }

        // 請求期間の構築
        // 請求開始年月日をあらわす内部変数billBeginを定義・生成する。
        // 請求年月(billDate)と請求期間開始日(billSpanStartDay)から請求開始年月日(billBegin)を設定する。
        Date billBegin = ACDateUtilities.setDayOfMonth((Date) getBillDate()
                .clone(), ACCastUtilities.toInt(
                getBillSpanStartDay().getText(), 1));
        // 請求終了年月日をあらわす内部変数billEndを定義・生成する。
        // 請求年月(billDate)と請求期間終了日(billSpanEndDay)から請求終了年月日(billEnd)を設定する。
        Date billEnd = ACDateUtilities.setDayOfMonth((Date) getBillDate()
                .clone(), ACCastUtilities.toInt(getBillSpanEndDay().getText(),
                1));
        if (ACDateUtilities.compareOnDay(billBegin, billEnd) > 0) {
            // 請求期間開始日(billSpanStartDay)よりも請求期間終了日(billSpanEndDay)が大きい場合
            // メッセージを表示する。※メッセージID = ERROR_OF_GREATER_DATE_RELATION
            QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION(
                    "請求期間は", "開始", "終了");
            // 請求期間開始日(billSpanStartDay)にフォーカスをあてる。
            getBillSpanStartDay().requestFocus();
            // 処理を中断する。
            return;
        }
        if (getCopyCreate().isSelected() && (!getBills().isSelected())) {
            // 複製可否(copyCreate)にチェックが付いていて、かつ領収書一覧が選択されていない場合
            // メッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_SELECT
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
                    "過去に作成した領収書を複製する場合は" + ACConstants.LINE_SEPARATOR
                            + "複製元の領収書");
            // 複製可否(copyCreate)にフォーカスをあてる。
            getCopyCreate().requestFocus();
            // 処理を中断する。
            return;
        }

        // 請求期間に有効な保険情報の取得
        // 以下のパラメタを引数に請求期間に有効な保険情報を取得する。
        // ・利用者ID(patientID)
        // ・請求開始年月日(billBegin)
        // ・請求終了年月日(billEnd)
        VRList insures = QkanCommon.getMedicalInsureInfo(getDBManager(),
                getPatientID(), billBegin, billEnd);
        if (insures.isEmpty()) {
            // 有効な保険情報が存在しない場合
            // メッセージを表示する。※メッセージID = QP011_ERROR_OF_INVALID_INSURE_SPAN
            if (QkanMessageList.getInstance()
                    .QP011_WARNING_OF_INVALID_INSURE_SPAN() != ACMessageBox.RESULT_OK) {
                // OK以外を押下した場合
                // 処理を中断する。
                return;
            }
        }else if (insures.size() > 1) {
            // 2つの保険情報をまたがる請求期間が設定されている場合
            // メッセージを表示する。※メッセージID = QP011_ERROR_OF_MULTIPLE_INSURE_SPAN
            QkanMessageList.getInstance().QP011_ERROR_OF_MULTIPLE_INSURE_SPAN();
            // 処理を中断する。
            return;
        }

        // ※再現情報の退避
        // 情報収集用にレコード infoを生成する。
        VRMap info = new VRHashMap();
        // 作成条件(createConditions)にレコードinfoを割り当て・収集する。
        getCreateConditions().setSource(info);
        getCreateConditions().applySource();
        // レコードinfoに検索設定(findedParam)を追加する。
        info.putAll(getFindedParam());
        // 当業務への遷移パラメタにキー「REPRODUCTION_MODE」で登録モードの定数を追加する。
        ACFrame.getInstance().addNowAffairParameter("REPRODUCTION_MODE",
                ACCastUtilities.toInteger(QkanConstants.PROCESS_MODE_INSERT));
        // 当業務への遷移パラメタにキー「REPRODUCTION_PARAM」でレコードinfoを追加する。
        ACFrame.getInstance().addNowAffairParameter("REPRODUCTION_PARAM", info);

        // ※遷移パラメタの設定
        // 次画面への渡りパラメータ格納用にレコード paramを生成する。
        VRMap param = new VRHashMap();
        if (getCopyCreate().isSelected()) {
            // 複製可否(copyCreate)にチェックが付いている場合
            // paramに選択した領収書の情報を追加する。
            VRMap row=(VRMap) getBills().getSelectedModelRowValue();
            param.putAll(row);
            //レコードinfoにキー「CLAIM_PATIENT_MEDICAL_ID」で選択した領収書のキー「CLAIM_PATIENT_MEDICAL_ID」の値を設定する。
            VRBindPathParser.set("CLAIM_PATIENT_MEDICAL_ID", info, VRBindPathParser.get("CLAIM_PATIENT_MEDICAL_ID", row));
        }
        // paramに下記パラメータを設定する。
        // KEY : PATIENT_ID, VALUE : 利用者ID(patientID)
        VRBindPathParser.set("PATIENT_ID", param, ACCastUtilities
                .toInteger(getPatientID()));
        // KEY : BILL_SPAN_START, VALUE : 請求開始年月日(billBegin)
        VRBindPathParser.set("BILL_SPAN_START", param, billBegin);
        // KEY : BILL_SPAN_END, VALUE : 請求終了年月日(billEnd)
        VRBindPathParser.set("BILL_SPAN_END", param, billEnd);
        // 下記パラメータにて業務情報を生成する。
        // className : QP012.class.getName(), parameters : param
        // ※遷移パラメタを使用して次画面に遷移
        ACFrame.getInstance().next(
                new ACAffairInfo(QP012.class.getName(), param));

    }

    /**
     * 「削除」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void deleteActionPerformed(ActionEvent e) throws Exception {
        // 選択した領収書を削除する。
        // ※入力チェック
        if (!getBills().isSelected()) {
            // 領収書一覧が選択されていない場合
            // メッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_SELECT
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
                    "削除する領収書");
            // 処理を中断する。
            return;
        }
        // 削除確認のメッセージを表示する。
        if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() != ACMessageBox.RESULT_OK) {
            // OK以外が選択された場合
            // 処理を中断する。
            return;
        }
        try {
            getDBManager().beginTransaction();
            // パッシブタスクを登録する。
            getPassiveChecker().clearPassiveTask();
            getPassiveChecker().addPassiveDeleteTask(
                    getBILL_PASSIVE_CHECK_KEY(),
                    getBills().getSelectedModelRow());
            // パッシブチェックを行う。
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                // パッシブエラーが発生した場合
                // エラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // 処理を中断する。
                return;
            }
            // パッシブエラーが発生しなかった場合
            // 選択した領収書を削除する。
            getDBManager().executeUpdate(
                    getSQL_DELETE_BILL((VRMap) getBills()
                            .getSelectedModelRowValue()));
            getDBManager().commitTransaction();
        } catch (SQLException ex) {
            // SQL文実行時にエラーが発生した場合
            // 処理をロールバックする。
            getDBManager().rollbackTransaction();
            // 例外エラーを投げ処理を中断する。
            throw ex;
        }
        // 検索に使用した対象年月(findTargetDate)で領収書一覧を再取得する。
        int selectRow = getBills().getSelectedRow();
        if (getFindTargetDate() != null) {
            String oldText = getTargetDate().getText();
            getTargetDate().setDate(getFindTargetDate());
            doFind();
            getTargetDate().setText(oldText);
        }
        // 削除した領収書の一つ上の領収書を選択する。
        getBills().setSelectedSortedRowOnAfterDelete(selectRow);
    }

    /**
     * 「画面制御」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void billsSelectionChanged(ListSelectionEvent e) throws Exception {
        // ※画面の制御
        if (!getBills().isSelected()) {
            // 一覧が選択されていない場合
            // 業務ボタンの状態をINVALID_DETAILに変更する。
            setState_INVALID_DETAIL();
        } else {
            // 一覧が選択されている場合
            // 業務ボタンの状態をVALID_DETAILに変更する。
            setState_VALID_DETAIL();
        }
    }

    /**
     * 「画面遷移処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void billsMouseClicked(MouseEvent e) throws Exception {
        // ※選択された領収書の情報で、次画面に遷移
        // 次画面に遷移する。
        doNext();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QP011.class.getName(), param));
    }

    // 内部関数

    /**
     * 「検索」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFind() throws Exception {
        // ※DBから利用者一覧を取得、画面に設定
        // ※入力チェック
        // 画面の「対象年月(targetDate)」に値が入力されているかどうかチェックする。
        if (ACTextUtilities.isNullText(getTargetDate().getText())) {
            // 入力されていない場合
            // メッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("対象年月");
            // 対象年月(targetDate)にフォーカスをあてる。
            getTargetDate().requestFocus();
            // 処理を中断する。
            return;
        }
        // 画面の「対象年月(targetDate)」に有効な値が入力されているかどうかチェックする。
        if (!getTargetDate().isValidDate()) {
            // 有効な値が入力されていない場合
            // メッセージを表示する。※メッセージID = ERROR_OF_WRONG_DATE
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("対象年月の");
            //対象年月(targetDate)にフォーカスをあてる。
            getTargetDate().requestFocus();
            // 処理を中断する。
            return;
        }
        
        // ※検索準備
        // SQL文取得関数に渡すレコード sqlParamを生成する。
        VRMap sqlParam = new VRHashMap();
        Date date = getTargetDate().getDate();
        // 利用者ID(patientID)をsqlParamの KEY : PATIENT_ID の VALUE として設定する。
        VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities
                .toInteger(getPatientID()));
        // ログイン事業者番号をsqlParamの KEY : PROVIDER__ID の VALUE として設定する。
        VRBindPathParser.set("PROVIDER_ID", sqlParam, QkanSystemInformation
                .getInstance().getLoginProviderID());
        // 対象年月(targetDate)の初日をsqlParamの KEY : BILL_SPAN_START の VALUE として設定する。
        VRBindPathParser.set("BILL_SPAN_START", sqlParam, ACDateUtilities
                .toFirstDayOfMonth(date));
        // 対象年月(targetDate)の末日をsqlParamの KEY : BILL_SPAN_END の VALUE として設定する。
        VRBindPathParser.set("BILL_SPAN_END", sqlParam, ACDateUtilities
                .toLastDayOfMonth(date));
        // ※DBからデータを取得
        // 領収書検索用のSQL文を発行し、結果をbillDataに格納する。
        setBillData(getDBManager().executeQuery(getSQL_SELECT_BILL(sqlParam)));

        // ※再現情報の退避
        // 抽出条件領域(findCondition)に検索設定(findedParam)を割り当て・収集する。
        getFindConditions().setSource(getFindedParam());
        getFindConditions().applySource();

        // 検索時の対象年月を退避する。
        setFindTargetDate(date);
        // 検索結果をパッシブデータとして退避する。
        getPassiveChecker().reservedPassive(getBILL_PASSIVE_CHECK_KEY(),
                getBillData());
        // ※取得したデータを画面に展開
        getBillTableModel().setAdaptee(getBillData());
        // 画面の「利用者一覧(patients)」の1行目を選択する。
        getBills().setSelectedSortedFirstRow();
        if (getBillData().isEmpty()) {
            // billDataの件数が0件の場合
            // 業務ボタンの状態をINVALID_DETAILに変更する。
            setState_INVALID_DETAIL();
        }
        // ※検索結果の領収額合計をすべて合算し、当月領収額合計を求める。
        long total = 0;
        Iterator it = getBillData().iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            total += ACCastUtilities.toInt(VRBindPathParser.get(
                    "BILL_FULL_TOTAL", row), 0);
        }
        // ステータスバーに「＜対象年月＞の領収額合計は＜当月領収額合計＞円です。」と設定する。
        setStatusText(ACConstants.FORMAT_FULL_ERA_YM.format(date) + " の領収額合計は "
                + NumberFormat.getIntegerInstance().format(total) + "円です。");
    }

    /**
     * 「画面遷移処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doNext() throws Exception {
        // ※選択された領収書の情報で、次画面に遷移
        // ※入力チェック
        // 画面の「領収書一覧(bills)」の行が選択されているかどうかチェックする。
        if (!getBills().isSelected()) {
            // 選択されていない場合
            // 処理を中断する。
            return;
        }

        // ※再現情報の退避
        // 情報収集用にレコード infoを生成する。
        VRMap info = new VRHashMap();
        // 作成条件(createConditions)にレコードinfoを割り当て・収集する。
        getCreateConditions().setSource(info);
        getCreateConditions().applySource();
        // レコードinfoに検索設定(findedParam)を追加する。
        info.putAll(getFindedParam());
        // 当業務への遷移パラメタにキー「REPRODUCTION_MODE」で更新モードの定数を追加する。
        ACFrame.getInstance().addNowAffairParameter("REPRODUCTION_MODE",
                ACCastUtilities.toInteger(QkanConstants.PROCESS_MODE_UPDATE));
        // 当業務への遷移パラメタにキー「REPRODUCTION_PARAM」でレコードinfoを追加する。
        ACFrame.getInstance().addNowAffairParameter("REPRODUCTION_PARAM", info);

        // ※遷移パラメタの設定
        // 次画面への遷移パラメタ格納用にレコード paramを生成する。
        VRMap param = new VRHashMap();
        // paramに選択した領収書の情報を追加する。
        param.putAll((VRMap) getBills().getSelectedModelRowValue());
        // 下記パラメータにて業務情報を生成する。
        // className : QP012.class.getName(), parameters : param
        // ※遷移パラメタを使用して次画面に遷移
        ACFrame.getInstance().next(
                new ACAffairInfo(QP012.class.getName(), param));

    }

}
