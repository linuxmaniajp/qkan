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
 * 作成日: 2006/08/22  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 訪問看護療養費領収書編集 (012)
 * プログラム 訪問看護療養費領収書編集 (QP012)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp012;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * 訪問看護療養費領収書編集(QP012)
 */
public class QP012 extends QP012Event {
    /**
     * コンストラクタです。
     */
    public QP012() {
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
        // 画面を初期化します。
        // ※初期定義
        // 業務のウィンドウタイトル・ボタンバーにタイトルを設定する。
        setAffairTitle("QP012");
        // ※パッシブキー(BILL_PASSIVE_CHECK_KEY)を定義する。
        // テーブル：CLAIM_PATIENT_MEDICAL
        // キー：CLAIM_PATIENT_MEDICAL_ID
        // フォーマット：なし
        // クライアントタイムフィールド：LAST_TIME
        // サーバータイムフィールド：LAST_TIME
        setBILL_PASSIVE_CHECK_KEY(new ACPassiveKey("CLAIM_PATIENT_MEDICAL",
                new String[] { "CLAIM_PATIENT_MEDICAL_ID" }, "LAST_TIME",
                "LAST_TIME"));
        setByInsurerAndPatientNameCache(new HashSet());
        // スナップショットの対象にクライアント領域(contents)、除外対象に合計領域(totalContents)を設定する。
        getSnapshot().setRootContainer(getContents(),
                new Component[] { getTotalContents() });
        getSnapshot().snapshot();

        // ※定型文コンボの読み込み
        // 画面展開用のレコードinfoを定義・生成する。
        VRMap info = new VRHashMap();
        // SQL生成用のレコードsqlParamを定義・生成する。
        VRMap sqlParam = new VRHashMap();
        // レコードsqlParamにキー「FIXED_FORM_ID」、値「1」を設定する。
        VRBindPathParser.set("FIXED_FORM_ID", sqlParam, new Integer(1));
        // 定型文テーブルから、保険負担分用の定型文を取得する。
        VRList pureForms = getDBManager().executeQuery(
                getSQL_SELECT_FIXED_FORM(sqlParam));
        VRList forms = new VRArrayList();
        ACBindUtilities.toListFromSingleRowMap(pureForms, forms);
        // レコードinfoにキー「BY_INSURER_NAME」で取得した定型文一覧を割り当てる。
        VRBindPathParser.set("BY_INSURER_NAME", info, forms);
        // レコードsqlParamにキー「FIXED_FORM_ID」、値「2」を設定する。
        VRBindPathParser.set("FIXED_FORM_ID", sqlParam, new Integer(2));
        // 定型文テーブルから、保険外負担分用の定型文を取得する。
        pureForms = getDBManager().executeQuery(
                getSQL_SELECT_FIXED_FORM(sqlParam));
        forms = new VRArrayList();
        ACBindUtilities.toListFromSingleRowMap(pureForms, forms);
        // レコードinfoにキー「BY_PATIENT_NAME」で取得した定型文一覧を割り当てる。
        VRBindPathParser.set("BY_PATIENT_NAME", info, forms);
        // クライアント領域(contents)にレコードinfoをモデル割り当て・展開する。
        getItemContents().setModelSource(info);
        getItemContents().bindModelSource();

        // ※登録・更新モードの判定
        if (!VRBindPathParser.has("PATIENT_ID", affair.getParameters())) {
            // 遷移パラメタにキー「PATIENT_ID」がない場合
            // プロセスモードを「更新モード」に設定する。
            setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
            // 画面状態を更新モード(UPDATE_MODE)にする。
            setState_UPDATE_MODE();
            if (!VRBindPathParser.has("CLAIM_PATIENT_MEDICAL_ID", affair
                    .getParameters())) {
                // 遷移パラメタにキー「CLAIM_PATIENT_MEDICAL_ID」がない場合
                // 不正なパラメタもしくは削除された情報とみなし、メッセージを表示する。※メッセージID = NOT_FOUND
                QkanMessageList.getInstance().NOT_FOUND("領収書");
                // 前画面に戻り処理を中断する。
                ACFrame.getInstance().back();
                return;
            }
            // 遷移パラメタを引数に、検索SQL文を発行する。
            VRList bills = getDBManager().executeQuery(
                    getSQL_SELECT_BILL(affair.getParameters()));
            if (bills.isEmpty()) {
                // 検索結果が存在しない場合
                // 不正なパラメタもしくは削除された情報とみなし、メッセージを表示する。※メッセージID = NOT_FOUND
                QkanMessageList.getInstance().NOT_FOUND("領収書");
                // 前画面に戻り処理を中断する。
                ACFrame.getInstance().back();
                return;
            }
            VRMap bill = (VRMap) bills.getData();
            // 内部変数claimMedicalIDに遷移パラメタのキー「CLAIM_PATIENT_MEDICAL_ID」の値を退避する。
            setClaimMedicalID(ACCastUtilities.toInt(VRBindPathParser.get(
                    "CLAIM_PATIENT_MEDICAL_ID", affair.getParameters()), 0));
            // 内部変数patientIDに検索結果のキー「PATIENT_ID」の値を退避する。
            setPatientID(ACCastUtilities.toInt(VRBindPathParser.get(
                    "PATIENT_ID", bill), 0));
            // 内部変数billStartに検索結果のキー「BILL_SPAN_START」の値を退避する。
            setBillStart(ACCastUtilities.toDate(VRBindPathParser.get(
                    "BILL_SPAN_START", bill), null));
            // 内部変数billEndに検索結果のキー「BILL_SPAN_END」の値を退避する。
            setBillEnd(ACCastUtilities.toDate(VRBindPathParser.get(
                    "BILL_SPAN_END", bill), null));
            // 内部変数byPatientRateValueに検索結果のキー「BY_PATIENT_RATE」の値を退避する。
            setByPatientRateValue(ACCastUtilities.toInt(VRBindPathParser.get(
                    "BY_PATIENT_RATE", bill), 0));

            // 平成19年4月改定(基本内税)対応をすべきか判定する。
            checkInnerTaxModeH1804();

            // 検索結果を画面に割り当て・展開する。
            getContents().setSource(bill);
            getContents().bindSource();

            // 外税チェックおよび消費税等テキストの有効状態を設定する。
            ACTextField[] prices = getByPatientPrices();
            ACTextField[] numbers = getByPatientNumbers();
            ACTextField[] sums = getByPatientSums();
            ACIntegerCheckBox[] taxTargets = getByPatientTaxTargets();
            ACIntegerCheckBox[] useTaxs = getByPatientUseTaxs();
            ACTextField[] taxs = getByPatientTaxs();
            int taxEnd = useTaxs.length;
            for (int i = 0; i < taxEnd; i++) {
                getByPatientSumCache().put(sums[i], sums[i].getText());
                doCheckTax(prices[i], numbers[i], sums[i], taxTargets[i],
                        useTaxs[i], taxs[i], false);
            }

            // 検索結果をパッシブデータとして登録する。
            getPassiveChecker().reservedPassive(getBILL_PASSIVE_CHECK_KEY(),
                    bills);
        } else {
            // 遷移パラメタにキー「PATIENT_ID」がある場合
            // プロセスモードを「登録モード」に設定する。
            setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
            // 内部変数patientIDに遷移パラメタのキー「PATIENT_ID」の値を退避する。
            setPatientID(ACCastUtilities.toInt(VRBindPathParser.get(
                    "PATIENT_ID", affair.getParameters()), 0));
        }
        // ※利用者情報の取得・展開
        // 内部変数patientIDをキー「PATIENT_ID」で格納したレコードを引数に、利用者情報を取得する。
        VRList patients = QkanCommon.getPatientInfo(getDBManager(),
                getPatientID());
        if (patients.isEmpty()) {
            // 利用者情報を取得できなかった場合
            // 不正なパラメタもしくは削除された情報とみなし、メッセージを表示する。※メッセージID = NOT_FOUND
            QkanMessageList.getInstance().NOT_FOUND("利用者");
            // 前画面に戻り処理を中断する。
            ACFrame.getInstance().back();
            return;
        }
        VRMap patient = (VRMap) patients.getData();
        // 取得した利用者の氏名を結合して氏名(patientName)に設定する。
        getPatientName().setText(
                QkanCommon.toFullName(VRBindPathParser.get(
                        "PATIENT_FAMILY_NAME", patient), VRBindPathParser.get(
                        "PATIENT_FIRST_NAME", patient)));

        if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
            // プロセスモードが「登録」の場合
            // ※画面の初期設定
            // 画面状態を登録モード(INSERT_MODE)にする。
            setState_INSERT_MODE();
            Date start = ACCastUtilities.toDate(VRBindPathParser.get(
                    "BILL_SPAN_START", affair.getParameters()), null);
            Date end = ACCastUtilities.toDate(VRBindPathParser.get(
                    "BILL_SPAN_END", affair.getParameters()), null);
            if ((start == null) || (end == null)) {
                // 遷移パラメタにキー「BILL_SPAN_START」や「BILL_SPAN_END」がない場合
                // 不正なパラメタもしくは削除された情報とみなし、メッセージを表示する。※メッセージID = NOT_FOUND
                QkanMessageList.getInstance().NOT_FOUND("請求期間");
                // 前画面に戻り処理を中断する。
                ACFrame.getInstance().back();
                return;
            }
            // 請求保険情報領域(insurerContents)に遷移パラメタを割り当て・展開する。
            getInsurerContents().setSource(affair.getParameters());
            getInsurerContents().bindSource();
            // 内部変数billStartに遷移パラメタのキー「BILL_SPAN_START」の値を退避する。
            setBillStart(start);
            // 内部変数billEndに遷移パラメタのキー「BILL_SPAN_END」の値を退避する。
            setBillEnd(end);
            // 保険外負担の外税チェックをすべて付ける。
            ACIntegerCheckBox[] useTaxs = getByPatientUseTaxs();
            int taxEnd = useTaxs.length;
            for (int i = 0; i < taxEnd; i++) {
                useTaxs[i].setSelected(true);
            }

            // 平成19年4月改定(基本内税)対応をすべきか判定する。
            checkInnerTaxModeH1804();

            // 患者番号(patientCode)に利用者コードを設定する。
            getPatientCode().setText(
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "PATIENT_CODE", patient)));
            // 発行日(printDate)にログイン日付を設定する。
            getPrintDate().setDate(
                    QkanSystemInformation.getInstance().getSystemDate());
            // 消費税率(tax)にマスタの消費税率を設定する。
            double val = QkanCommon.getTax(getDBManager());
            if (val >= 0) {
                getTax().setText(ACCastUtilities.toString(val));
            }
            // ※既存履歴の複写
            if (VRBindPathParser.has("CLAIM_PATIENT_MEDICAL_ID", affair
                    .getParameters())) {
                // 遷移パラメタにキー「CLAIM_PATIENT_MEDICAL_ID」がある場合
                // 遷移パラメタを引数として、複製元の領収書の患者番号・保険外負担・備考を取得するSQL文を発行する。
                VRList bills = getDBManager().executeQuery(
                        getSQL_SELECT_COPY_BILL(affair.getParameters()));
                if (!bills.isEmpty()) {
                    // 複製元の領収書情報を取得できた場合
                    // 取得した情報を画面に展開する。
                    getContents().setSource((VRMap) bills.getData());
                    getContents().bindSource();

                    // 外税チェックが付いていれば、消費税等欄を有効にする。
                    ACTextField[] taxs = getByPatientTaxs();
                    for (int i = 0; i < taxEnd; i++) {
                        taxs[i].setEnabled(useTaxs[i].isSelected());
                    }

                }
            }
            // ※実績の読み込み
            // 請求期間の実績を読み込んで画面に展開する。
            if (!doOpenResult(false)) {
                // 実績の読み込みに失敗した場合
                // 前画面に戻り処理を中断する。
                ACFrame.getInstance().back();
                return;
            }
        }
        // ※提供日コンボの最適化
        // データ収集用のレコードinfoを定義・生成する。
        info = new VRHashMap();
        // 請求期間開始年月日(billSpanStart)にレコードinfoを割り当て・収集する。
        getBillSpanStart().setSource(info);
        getBillSpanStart().applySource();
        // レコードinfoのキー「BILL_SPAN_START」の値をDate値に変換し、当月末日の日にちで以下の通り分岐する。
        switch (ACDateUtilities.getDayOfMonth(ACDateUtilities
                .toLastDayOfMonth(ACCastUtilities.toDate(VRBindPathParser.get(
                        "BILL_SPAN_START", info))))) {
        case 28:
            // 末日が28日の場合
            // 画面状態を最大提供日28日(MAX_DAY_28)にする。
            setState_MAX_DAY_28();
            break;
        case 29:
            // 末日が29日の場合
            // 画面状態を最大提供日29日(MAX_DAY_29)にする。
            setState_MAX_DAY_29();
            break;
        case 30:
            // 末日が30日の場合
            // 画面状態を最大提供日30日(MAX_DAY_30)にする。
            setState_MAX_DAY_30();
            break;
        default:
            // それ以外
            // 画面状態を最大提供日31日(MAX_DAY_31)にする。
            setState_MAX_DAY_31();
            break;
        }
        // 画面のスナップショットを取る。
        getSnapshot().snapshot();

        ACTextField[] sums = getByPatientSums();
        for (int i = 0; i < sums.length; i++) {
            getByPatientSumCache().put(sums[i], sums[i].getText());
        }
        ACComboBox[] names = getByInsurerNamesAndPatientNames();
        for (int i = 0; i < names.length; i++) {
            if (!ACTextUtilities.isNullText(names[i])) {
                getByInsurerAndPatientNameCache().add(names[i]);
            }
        }

    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // 前画面遷移時に選択情報を引き渡す。
        // ※変更チェック
        if (getSnapshot().isModified()) {
            // スナップショットに変化がある場合
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // プロセスモードが「登録モード」の場合
                // 登録確認メッセージを表示する。※メッセージID = WARNING_OF_INSERT_ON_MODIFIED
                switch (QkanMessageList.getInstance()
                        .WARNING_OF_INSERT_ON_MODIFIED()) {
                case ACMessageBox.RESULT_YES:
                    // 「登録して戻る」押下時
                    // 保存処理を行う。
                    if (!doInsert()) {
                        // 保存処理に失敗した場合
                        // 前画面繊維を許可せず、関数を抜ける。
                        return false;
                    }
                    break;
                case ACMessageBox.RESULT_NO:
                    // 「破棄して戻る」押下時
                    // 何もしない。
                    break;
                default:
                    // それ以外
                    // 前画面繊維を許可せず、関数を抜ける。
                    return false;
                }
            } else {
                // プロセスモードが「更新モード」の場合
                // 更新確認メッセージを表示する。※メッセージID = WARNING_OF_UPDATE_ON_MODIFIED
                switch (QkanMessageList.getInstance()
                        .WARNING_OF_UPDATE_ON_MODIFIED()) {
                case ACMessageBox.RESULT_YES:
                    // 「更新して戻る」押下時
                    // 保存処理を行う。
                    if (!doUpdate()) {
                        // 保存処理に失敗した場合
                        // 前画面繊維を許可せず、関数を抜ける。
                        return false;
                    }
                    break;
                case ACMessageBox.RESULT_NO:
                    // 「破棄して戻る」押下時
                    // 何もしない。
                    break;
                default:
                    // それ以外
                    // 前画面繊維を許可せず、関数を抜ける。
                    return false;
                }
            }
        }
        // ※遷移パラメタの設定
        if (getClaimMedicalID() > 0) {
            // 内部変数claimMedicalIDが0より大きい場合
            // 遷移パラメタに以下を設定する。
            // KEY : CLAIM_PATIENT_MEDICAL_ID, VALUE : 内部変数claimMedicalID
            VRBindPathParser.set("CLAIM_PATIENT_MEDICAL_ID", parameters,
                    ACCastUtilities.toInteger(getClaimMedicalID()));
        } else {
            // 内部変数claimMedicalIDが0より大きくない場合
            // 遷移パラメタからキー「CLAIM_PATIENT_MEDICAL_ID」を削除する。
            parameters.remove("CLAIM_PATIENT_MEDICAL_ID");
        }

        // 前画面遷移を許可する。
        return true;
    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // 終了時に保存確認を行う。
        if (getSnapshot().isModified()) {
            // スナップショットに変化がある場合
            // 終了確認メッセージを表示する。※メッセージID = WARNING_OF_CLOSE_ON_MODIFIED
            if (QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED() != ACMessageBox.RESULT_OK) {
                // 「OK」押下以外
                // 終了を許可せず、関数を抜ける。
                return false;
            }
        }
        // 終了を許可する。
        return true;
    }

    // コンポーネントイベント

    /**
     * 「実績読み込み」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void openActionPerformed(ActionEvent e) throws Exception {
        // 実績読み込みを行う。
        // 読み込み確認のメッセージを表示する。※メッセージID = QP012_WARNING_OF_OPEN_RESULT
        if (QkanMessageList.getInstance().QP012_WARNING_OF_OPEN_RESULT() != ACMessageBox.RESULT_OK) {
            // OKボタン以外が押下された場合
            // 処理を中断する。
            return;
        }
        // 請求期間の実績を読み込んで画面に展開する。
        doOpenResult(true);

    }

    /**
     * 「登録」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // 現在の情報を登録モードで保存する。
        // 登録処理を行なう。
        if (doInsert()) {

            // 登録に成功した場合
            // 完了メッセージを表示する。※メッセージID = INSERT_SUCCESSED
            QkanMessageList.getInstance().INSERT_SUCCESSED();
        }
    }

    /**
     * 「更新」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {
        // 現在の情報を更新モードで保存する。
        // 更新処理を行なう。
        if (doUpdate()) {

            // 更新に成功した場合
            // 完了メッセージを表示する。※メッセージID = UPDATE_SUCCESSED
            QkanMessageList.getInstance().UPDATE_SUCCESSED();
        }
    }

    /**
     * 「印刷」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void printActionPerformed(ActionEvent e) throws Exception {
        // 印刷を行う。
        if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
            // 登録モードの場合
            // 保存後印刷確認のメッセージを表示する。※メッセージID = WARNING_OF_DO_PRINT
            if (QkanMessageList.getInstance().WARNING_OF_DO_PRINT("登録",
                    "訪問看護療養費領収書") != ACMessageBox.RESULT_OK) {
                // 「OK」を押下していない場合
                // 処理を中断する。
                return;
            }
            // 保存処理を行う。
            if (!doInsert()) {

                // 保存処理に失敗した場合
                // 処理を中断する。
                return;
            }
        } else if (getSnapshot().isModified()) {
            // 登録モード以外でスナップショットに変化がある場合
            // 保存後印刷確認のメッセージを表示する。※メッセージID = WARNING_OF_DO_PRINT
            if (QkanMessageList.getInstance().WARNING_OF_DO_PRINT("更新",
                    "訪問看護療養費領収書") != ACMessageBox.RESULT_OK) {
                // 「OK」を押下していない場合
                // 処理を中断する。
                return;
            }
            // 保存処理を行う。
            if (!doUpdate()) {
                // 保存処理に失敗した場合
                // 処理を中断する。
                return;
            }
        }
        // 印刷パラメタをあらわすレコードparamを定義・生成する。
        VRMap param = new VRHashMap();
        // クライアント領域(contents)にレコードparamを割り当て・収集する。
        getContents().setSource(param);
        getContents().applySource();
        // 収集したデータのバインドパスをフィルタリングする。
        filterBindPath(param);

        // レコードparamにキー「DBM」でDBManagerを設定する。
        VRBindPathParser.set("DBM", param, getDBManager());
        // レコードparamにキー「InnerTaxH1904Mode」でInnerTaxH1904Modeを設定する。
        VRBindPathParser.set("InnerTaxH1904Mode", param, new Boolean(
                getInnerTaxH1904Mode()));

        ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
        writer.beginPrintEdit();
        // 印刷クラス(QP012P01)を生成し、印刷パラメタを引数に印刷を実行する。
        if (new QP012P01().doPrint(writer, param)) {
            // 印刷に成功した場合
            writer.endPrintEdit();
            ACChotarouXMLUtilities.openPDF(writer);
            // 印刷済みにするかの確認メッセージを表示する。※メッセージID = QP012_QUESTION_OF_PRINT_COMMIT
            if (QkanMessageList.getInstance().QP012_QUESTION_OF_PRINT_COMMIT() == ACMessageBox.RESULT_OK) {
                // 「はい」を押下した場合
                // 印刷済みフラグを済みに更新するSQL文を発行する。※パッシブチェックは行わない。
                VRMap sqlParam = new VRHashMap();
                VRBindPathParser.set("CLAIM_PATIENT_MEDICAL_ID", sqlParam,
                        ACCastUtilities.toInteger(getClaimMedicalID()));
                getDBManager()
                        .executeUpdate(getSQL_UPDATE_TO_PRINTED(sqlParam));
            }
        }
    }

    /**
     * 「税率変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void taxChangeActionPerformed(ActionEvent e) throws Exception {
        // 税率を再設定します。
        // 税率変更確認のメッセージを表示する。※メッセージID = QP012_QUESTION_OF_TAX_CHANGE
        if (QkanMessageList.getInstance().QP012_QUESTION_OF_TAX_CHANGE() != ACMessageBox.RESULT_OK) {
            // 「OK」以外が押下された場合
            // 処理を中断する。
            return;
        }
        // 消費税率(tax)にマスタの消費税率を設定する。
        getTax().setText(
                ACCastUtilities.toString(QkanCommon.getTax(getDBManager())));
        // 新しい税率で、保険外負担分項目の税分の再計算と、合計欄の再計算を行う。
        doCalcTax();
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice1FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice1(), getByInsurerNumber1(),
                getByInsurerSum1());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber1FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice1(), getByInsurerNumber1(),
                getByInsurerSum1());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum1FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice2FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice2(), getByInsurerNumber2(),
                getByInsurerSum2());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber2FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice2(), getByInsurerNumber2(),
                getByInsurerSum2());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum2FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice3FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice3(), getByInsurerNumber3(),
                getByInsurerSum3());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber3FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice3(), getByInsurerNumber3(),
                getByInsurerSum3());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum3FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice4FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice4(), getByInsurerNumber4(),
                getByInsurerSum4());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber4FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice4(), getByInsurerNumber4(),
                getByInsurerSum4());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum4FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice5FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice5(), getByInsurerNumber5(),
                getByInsurerSum5());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber5FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice5(), getByInsurerNumber5(),
                getByInsurerSum5());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum5FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice6FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice6(), getByInsurerNumber6(),
                getByInsurerSum6());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber6FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice6(), getByInsurerNumber6(),
                getByInsurerSum6());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum6FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice7FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice7(), getByInsurerNumber7(),
                getByInsurerSum7());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber7FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice7(), getByInsurerNumber7(),
                getByInsurerSum7());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum7FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice8FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice8(), getByInsurerNumber8(),
                getByInsurerSum8());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber8FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice8(), getByInsurerNumber8(),
                getByInsurerSum8());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum8FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice9FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice9(), getByInsurerNumber9(),
                getByInsurerSum9());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber9FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice9(), getByInsurerNumber9(),
                getByInsurerSum9());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum9FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice10FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice10(), getByInsurerNumber10(),
                getByInsurerSum10());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber10FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice10(), getByInsurerNumber10(),
                getByInsurerSum10());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum10FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice1FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice1(), getByPatientNumber1(),
                getByPatientSum1(), getByPatientTaxTarget1(),
                getByPatientUseTax1(), getByPatientTax1(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber1FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice1(), getByPatientNumber1(),
                getByPatientSum1(), getByPatientTaxTarget1(),
                getByPatientUseTax1(), getByPatientTax1(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum1FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum1(), getByPatientTaxTarget1(),
                getByPatientUseTax1(), getByPatientTax1());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget1ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice1(), getByPatientNumber1(),
                getByPatientSum1(), getByPatientTaxTarget1(),
                getByPatientUseTax1(), getByPatientTax1(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax1ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice1(), getByPatientNumber1(),
                getByPatientSum1(), getByPatientTaxTarget1(),
                getByPatientUseTax1(), getByPatientTax1(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax1FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice2FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice2(), getByPatientNumber2(),
                getByPatientSum2(), getByPatientTaxTarget2(),
                getByPatientUseTax2(), getByPatientTax2(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber2FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice2(), getByPatientNumber2(),
                getByPatientSum2(), getByPatientTaxTarget2(),
                getByPatientUseTax2(), getByPatientTax2(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum2FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum2(), getByPatientTaxTarget2(),
                getByPatientUseTax2(), getByPatientTax2());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget2ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice2(), getByPatientNumber2(),
                getByPatientSum2(), getByPatientTaxTarget2(),
                getByPatientUseTax2(), getByPatientTax2(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax2ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice2(), getByPatientNumber2(),
                getByPatientSum2(), getByPatientTaxTarget2(),
                getByPatientUseTax2(), getByPatientTax2(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax2FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice3FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice3(), getByPatientNumber3(),
                getByPatientSum3(), getByPatientTaxTarget3(),
                getByPatientUseTax3(), getByPatientTax3(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber3FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice3(), getByPatientNumber3(),
                getByPatientSum3(), getByPatientTaxTarget3(),
                getByPatientUseTax3(), getByPatientTax3(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum3FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum3(), getByPatientTaxTarget3(),
                getByPatientUseTax3(), getByPatientTax3());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget3ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice3(), getByPatientNumber3(),
                getByPatientSum3(), getByPatientTaxTarget3(),
                getByPatientUseTax3(), getByPatientTax3(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax3ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice3(), getByPatientNumber3(),
                getByPatientSum3(), getByPatientTaxTarget3(),
                getByPatientUseTax3(), getByPatientTax3(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax3FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice4FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice4(), getByPatientNumber4(),
                getByPatientSum4(), getByPatientTaxTarget4(),
                getByPatientUseTax4(), getByPatientTax4(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber4FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice4(), getByPatientNumber4(),
                getByPatientSum4(), getByPatientTaxTarget4(),
                getByPatientUseTax4(), getByPatientTax4(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum4FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum4(), getByPatientTaxTarget4(),
                getByPatientUseTax4(), getByPatientTax4());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget4ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice4(), getByPatientNumber4(),
                getByPatientSum4(), getByPatientTaxTarget4(),
                getByPatientUseTax4(), getByPatientTax4(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax4ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice4(), getByPatientNumber4(),
                getByPatientSum4(), getByPatientTaxTarget4(),
                getByPatientUseTax4(), getByPatientTax4(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax4FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice5FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice5(), getByPatientNumber5(),
                getByPatientSum5(), getByPatientTaxTarget5(),
                getByPatientUseTax5(), getByPatientTax5(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber5FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice5(), getByPatientNumber5(),
                getByPatientSum5(), getByPatientTaxTarget5(),
                getByPatientUseTax5(), getByPatientTax5(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum5FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum5(), getByPatientTaxTarget5(),
                getByPatientUseTax5(), getByPatientTax5());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget5ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice5(), getByPatientNumber5(),
                getByPatientSum5(), getByPatientTaxTarget5(),
                getByPatientUseTax5(), getByPatientTax5(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax5ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice5(), getByPatientNumber5(),
                getByPatientSum5(), getByPatientTaxTarget5(),
                getByPatientUseTax5(), getByPatientTax5(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax5FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice6FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice6(), getByPatientNumber6(),
                getByPatientSum6(), getByPatientTaxTarget6(),
                getByPatientUseTax6(), getByPatientTax6(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber6FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice6(), getByPatientNumber6(),
                getByPatientSum6(), getByPatientTaxTarget6(),
                getByPatientUseTax6(), getByPatientTax6(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum6FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum6(), getByPatientTaxTarget6(),
                getByPatientUseTax6(), getByPatientTax6());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget6ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice6(), getByPatientNumber6(),
                getByPatientSum6(), getByPatientTaxTarget6(),
                getByPatientUseTax6(), getByPatientTax6(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax6ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice6(), getByPatientNumber6(),
                getByPatientSum6(), getByPatientTaxTarget6(),
                getByPatientUseTax6(), getByPatientTax6(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax6FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice7FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice7(), getByPatientNumber7(),
                getByPatientSum7(), getByPatientTaxTarget7(),
                getByPatientUseTax7(), getByPatientTax7(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber7FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice7(), getByPatientNumber7(),
                getByPatientSum7(), getByPatientTaxTarget7(),
                getByPatientUseTax7(), getByPatientTax7(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum7FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum7(), getByPatientTaxTarget7(),
                getByPatientUseTax7(), getByPatientTax7());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget7ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice7(), getByPatientNumber7(),
                getByPatientSum7(), getByPatientTaxTarget7(),
                getByPatientUseTax7(), getByPatientTax7(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax7ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice7(), getByPatientNumber7(),
                getByPatientSum7(), getByPatientTaxTarget7(),
                getByPatientUseTax7(), getByPatientTax7(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax7FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice8FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice8(), getByPatientNumber8(),
                getByPatientSum8(), getByPatientTaxTarget8(),
                getByPatientUseTax8(), getByPatientTax8(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber8FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice8(), getByPatientNumber8(),
                getByPatientSum8(), getByPatientTaxTarget8(),
                getByPatientUseTax8(), getByPatientTax8(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum8FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum8(), getByPatientTaxTarget8(),
                getByPatientUseTax8(), getByPatientTax8());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget8ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice8(), getByPatientNumber8(),
                getByPatientSum8(), getByPatientTaxTarget8(),
                getByPatientUseTax8(), getByPatientTax8(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax8ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice8(), getByPatientNumber8(),
                getByPatientSum8(), getByPatientTaxTarget8(),
                getByPatientUseTax8(), getByPatientTax8(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax8FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice9FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice9(), getByPatientNumber9(),
                getByPatientSum9(), getByPatientTaxTarget9(),
                getByPatientUseTax9(), getByPatientTax9(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber9FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice9(), getByPatientNumber9(),
                getByPatientSum9(), getByPatientTaxTarget9(),
                getByPatientUseTax9(), getByPatientTax9(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum9FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum9(), getByPatientTaxTarget9(),
                getByPatientUseTax9(), getByPatientTax9());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget9ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice9(), getByPatientNumber9(),
                getByPatientSum9(), getByPatientTaxTarget9(),
                getByPatientUseTax9(), getByPatientTax9(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax9ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice9(), getByPatientNumber9(),
                getByPatientSum9(), getByPatientTaxTarget9(),
                getByPatientUseTax9(), getByPatientTax9(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax9FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice10FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice10(), getByPatientNumber10(),
                getByPatientSum10(), getByPatientTaxTarget10(),
                getByPatientUseTax10(), getByPatientTax10(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber10FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice10(), getByPatientNumber10(),
                getByPatientSum10(), getByPatientTaxTarget10(),
                getByPatientUseTax10(), getByPatientTax10(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum10FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum10(), getByPatientTaxTarget10(),
                getByPatientUseTax10(), getByPatientTax10());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget10ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice10(), getByPatientNumber10(),
                getByPatientSum10(), getByPatientTaxTarget10(),
                getByPatientUseTax10(), getByPatientTax10(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax10ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice10(), getByPatientNumber10(),
                getByPatientSum10(), getByPatientTaxTarget10(),
                getByPatientUseTax10(), getByPatientTax10(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax10FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName1FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName1());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName2FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName2());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName3FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName3());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName4FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName4());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName5FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName5());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName6FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName6());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName7FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName7());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName8FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName8());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName9FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName9());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName10FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName10());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName1FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName1());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName2FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName2());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName3FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName3());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName4FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName4());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName5FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName5());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName6FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName6());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName7FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName7());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName8FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName8());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName9FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName9());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName10FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName10());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice11FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice11(), getByInsurerNumber11(),
                getByInsurerSum11());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber11FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice11(), getByInsurerNumber11(),
                getByInsurerSum11());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum11FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice12FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice12(), getByInsurerNumber12(),
                getByInsurerSum12());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber12FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice12(), getByInsurerNumber12(),
                getByInsurerSum12());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum12FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice13FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice13(), getByInsurerNumber13(),
                getByInsurerSum13());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber13FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice13(), getByInsurerNumber13(),
                getByInsurerSum13());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum13FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice14FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice14(), getByInsurerNumber14(),
                getByInsurerSum14());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber14FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice14(), getByInsurerNumber14(),
                getByInsurerSum14());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum14FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice15FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice15(), getByInsurerNumber15(),
                getByInsurerSum15());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber15FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice15(), getByInsurerNumber15(),
                getByInsurerSum15());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum15FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice16FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice16(), getByInsurerNumber16(),
                getByInsurerSum16());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber16FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice16(), getByInsurerNumber16(),
                getByInsurerSum16());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum16FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice17FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice17(), getByInsurerNumber17(),
                getByInsurerSum17());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber17FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice17(), getByInsurerNumber17(),
                getByInsurerSum17());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum17FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice18FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice18(), getByInsurerNumber18(),
                getByInsurerSum18());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber18FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice18(), getByInsurerNumber18(),
                getByInsurerSum18());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum18FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice19FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice19(), getByInsurerNumber19(),
                getByInsurerSum19());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber19FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice19(), getByInsurerNumber19(),
                getByInsurerSum19());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum19FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerPrice20FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice20(), getByInsurerNumber20(),
                getByInsurerSum20());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerNumber20FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByInsurerPrice20(), getByInsurerNumber20(),
                getByInsurerSum20());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerSum20FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice11FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice11(), getByPatientNumber11(),
                getByPatientSum11(), getByPatientTaxTarget11(),
                getByPatientUseTax11(), getByPatientTax11(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber11FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice11(), getByPatientNumber11(),
                getByPatientSum11(), getByPatientTaxTarget11(),
                getByPatientUseTax11(), getByPatientTax11(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum11FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum11(), getByPatientTaxTarget11(),
                getByPatientUseTax11(), getByPatientTax11());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget11ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice11(), getByPatientNumber11(),
                getByPatientSum11(), getByPatientTaxTarget11(),
                getByPatientUseTax11(), getByPatientTax11(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax11ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice11(), getByPatientNumber11(),
                getByPatientSum11(), getByPatientTaxTarget11(),
                getByPatientUseTax11(), getByPatientTax11(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax11FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice12FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice12(), getByPatientNumber12(),
                getByPatientSum12(), getByPatientTaxTarget12(),
                getByPatientUseTax12(), getByPatientTax12(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber12FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice12(), getByPatientNumber12(),
                getByPatientSum12(), getByPatientTaxTarget12(),
                getByPatientUseTax12(), getByPatientTax12(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum12FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum12(), getByPatientTaxTarget12(),
                getByPatientUseTax12(), getByPatientTax12());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget12ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice12(), getByPatientNumber12(),
                getByPatientSum12(), getByPatientTaxTarget12(),
                getByPatientUseTax12(), getByPatientTax12(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax12ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice12(), getByPatientNumber12(),
                getByPatientSum12(), getByPatientTaxTarget12(),
                getByPatientUseTax12(), getByPatientTax12(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax12FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice13FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice13(), getByPatientNumber13(),
                getByPatientSum13(), getByPatientTaxTarget13(),
                getByPatientUseTax13(), getByPatientTax13(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber13FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice13(), getByPatientNumber13(),
                getByPatientSum13(), getByPatientTaxTarget13(),
                getByPatientUseTax13(), getByPatientTax13(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum13FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum13(), getByPatientTaxTarget13(),
                getByPatientUseTax13(), getByPatientTax13());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget13ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice13(), getByPatientNumber13(),
                getByPatientSum13(), getByPatientTaxTarget13(),
                getByPatientUseTax13(), getByPatientTax13(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax13ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice13(), getByPatientNumber13(),
                getByPatientSum13(), getByPatientTaxTarget13(),
                getByPatientUseTax13(), getByPatientTax13(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax13FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice14FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice14(), getByPatientNumber14(),
                getByPatientSum14(), getByPatientTaxTarget14(),
                getByPatientUseTax14(), getByPatientTax14(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber14FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice14(), getByPatientNumber14(),
                getByPatientSum14(), getByPatientTaxTarget14(),
                getByPatientUseTax14(), getByPatientTax14(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum14FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum14(), getByPatientTaxTarget14(),
                getByPatientUseTax14(), getByPatientTax14());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget14ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice14(), getByPatientNumber14(),
                getByPatientSum14(), getByPatientTaxTarget14(),
                getByPatientUseTax14(), getByPatientTax14(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax14ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice14(), getByPatientNumber14(),
                getByPatientSum14(), getByPatientTaxTarget14(),
                getByPatientUseTax14(), getByPatientTax14(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax14FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice15FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice15(), getByPatientNumber15(),
                getByPatientSum15(), getByPatientTaxTarget15(),
                getByPatientUseTax15(), getByPatientTax15(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber15FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice15(), getByPatientNumber15(),
                getByPatientSum15(), getByPatientTaxTarget15(),
                getByPatientUseTax15(), getByPatientTax15(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum15FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum15(), getByPatientTaxTarget15(),
                getByPatientUseTax15(), getByPatientTax15());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax15ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice15(), getByPatientNumber15(),
                getByPatientSum15(), getByPatientTaxTarget15(),
                getByPatientUseTax15(), getByPatientTax15(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget15ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice15(), getByPatientNumber15(),
                getByPatientSum15(), getByPatientTaxTarget15(),
                getByPatientUseTax15(), getByPatientTax15(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax15FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice16FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice16(), getByPatientNumber16(),
                getByPatientSum16(), getByPatientTaxTarget16(),
                getByPatientUseTax16(), getByPatientTax16(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber16FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice16(), getByPatientNumber16(),
                getByPatientSum16(), getByPatientTaxTarget16(),
                getByPatientUseTax16(), getByPatientTax16(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum16FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum16(), getByPatientTaxTarget16(),
                getByPatientUseTax16(), getByPatientTax16());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget16ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice16(), getByPatientNumber16(),
                getByPatientSum16(), getByPatientTaxTarget16(),
                getByPatientUseTax16(), getByPatientTax16(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax16ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice16(), getByPatientNumber16(),
                getByPatientSum16(), getByPatientTaxTarget16(),
                getByPatientUseTax16(), getByPatientTax16(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax16FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice17FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice17(), getByPatientNumber17(),
                getByPatientSum17(), getByPatientTaxTarget17(),
                getByPatientUseTax17(), getByPatientTax17(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber17FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice17(), getByPatientNumber17(),
                getByPatientSum17(), getByPatientTaxTarget17(),
                getByPatientUseTax17(), getByPatientTax17(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum17FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum17(), getByPatientTaxTarget17(),
                getByPatientUseTax17(), getByPatientTax17());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget17ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice17(), getByPatientNumber17(),
                getByPatientSum17(), getByPatientTaxTarget17(),
                getByPatientUseTax17(), getByPatientTax17(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax17ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice17(), getByPatientNumber17(),
                getByPatientSum17(), getByPatientTaxTarget17(),
                getByPatientUseTax17(), getByPatientTax17(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax17FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice18FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice18(), getByPatientNumber18(),
                getByPatientSum18(), getByPatientTaxTarget18(),
                getByPatientUseTax18(), getByPatientTax18(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber18FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice18(), getByPatientNumber18(),
                getByPatientSum18(), getByPatientTaxTarget18(),
                getByPatientUseTax18(), getByPatientTax18(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum18FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum18(), getByPatientTaxTarget18(),
                getByPatientUseTax18(), getByPatientTax18());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget18ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice18(), getByPatientNumber18(),
                getByPatientSum18(), getByPatientTaxTarget18(),
                getByPatientUseTax18(), getByPatientTax18(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax18ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice18(), getByPatientNumber18(),
                getByPatientSum18(), getByPatientTaxTarget18(),
                getByPatientUseTax18(), getByPatientTax18(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax18FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice19FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice19(), getByPatientNumber19(),
                getByPatientSum19(), getByPatientTaxTarget19(),
                getByPatientUseTax19(), getByPatientTax19(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber19FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice19(), getByPatientNumber19(),
                getByPatientSum19(), getByPatientTaxTarget19(),
                getByPatientUseTax19(), getByPatientTax19(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum19FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum19(), getByPatientTaxTarget19(),
                getByPatientUseTax19(), getByPatientTax19());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget19ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice19(), getByPatientNumber19(),
                getByPatientSum19(), getByPatientTaxTarget19(),
                getByPatientUseTax19(), getByPatientTax19(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax19ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice19(), getByPatientNumber19(),
                getByPatientSum19(), getByPatientTaxTarget19(),
                getByPatientUseTax19(), getByPatientTax19(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax19FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientPrice20FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice20(), getByPatientNumber20(),
                getByPatientSum20(), getByPatientTaxTarget20(),
                getByPatientUseTax20(), getByPatientTax20(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientNumber20FocusLost(FocusEvent e) throws Exception {
        // 同行の金額列の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientPrice20(), getByPatientNumber20(),
                getByPatientSum20(), getByPatientTaxTarget20(),
                getByPatientUseTax20(), getByPatientTax20(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientSum20FocusLost(FocusEvent e) throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCalcSum(getByPatientSum20(), getByPatientTaxTarget20(),
                getByPatientUseTax20(), getByPatientTax20());

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTaxTarget20ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice20(), getByPatientNumber20(),
                getByPatientSum20(), getByPatientTaxTarget20(),
                getByPatientUseTax20(), getByPatientTax20(), false);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientUseTax20ActionPerformed(ActionEvent e)
            throws Exception {
        // 同行の税の再計算と合計欄の再計算を行う。
        doCheckTax(getByPatientPrice20(), getByPatientNumber20(),
                getByPatientSum20(), getByPatientTaxTarget20(),
                getByPatientUseTax20(), getByPatientTax20(), true);

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientTax20FocusLost(FocusEvent e) throws Exception {
        // 合計欄の再計算を行う。
        doCalcTotal();

    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName11FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName11());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName12FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName12());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName13FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName13());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName14FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName14());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName15FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName15());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName16FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName16());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName17FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName17());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName18FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName18());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName19FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName19());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byInsurerName20FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByInsurerName20());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName11FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName11());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName12FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName12());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName13FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName13());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName14FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName14());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName15FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName15());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName16FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName16());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName17FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName17());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName18FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName18());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName19FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName19());
    }

    /**
     * 「再計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void byPatientName20FocusLost(FocusEvent e) throws Exception {
        // 項目名の入力を監視し、必要に応じて合計の再計算を行う。
        doCheckName(getByPatientName20());
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        param.setData("PATIENT_ID", new Integer(7));
        param
                .setData("BILL_SPAN_START", ACDateUtilities.createDate(2007, 4,
                        1));
        param.setData("BILL_SPAN_END", ACDateUtilities.createDate(2007, 4, 31));
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QP012.class.getName(), param));
    }

    // 内部関数

    /**
     * 「実績読み込み処理」に関する処理を行ないます。
     * 
     * @param fullAleart fullAleart
     * @throws Exception 処理例外
     * @return boolean
     */
    public boolean doOpenResult(boolean fullAleart) throws Exception {
        // 実績を読み込んで画面に展開する。実績を読み込めなかった場合は偽(false)を返す。
        // ※請求期間チェック
        // 請求期間に有効な保険情報の取得
        // 以下のパラメタを引数に請求期間に有効な保険情報を取得する。
        // ・利用者ID(patientID)
        // ・請求開始年月日(billStart)
        // ・請求終了年月日(billEnd)
        VRList insures = QkanCommon.getMedicalInsureInfo(getDBManager(),
                getPatientID(), getBillStart(), getBillEnd());
        boolean fullPatientRate = false;
        // 有効な保険情報が存在しない場合
        if (insures.isEmpty()) {
            if (fullAleart) {
                // 保険情報がない場合に警告を出す場合
                // メッセージを表示する。※メッセージID = QP012_ERROR_OF_INVALID_INSURE_SPAN
                if (QkanMessageList.getInstance()
                        .QP012_WARNING_OF_INVALID_INSURE_SPAN() != ACMessageBox.RESULT_OK) {
                    // OK以外を押下した場合
                    // 処理を中断し、偽(false)を返す。
                    return false;
                }
            }
            // 全額利用者負担とする。
            fullPatientRate = true;
        } else if (insures.size() > 1) {
            // 2つの保険情報をまたがる請求期間が設定されている場合
            // メッセージを表示する。※メッセージID = QP012_ERROR_OF_MULTIPLE_INSURE_SPAN
            QkanMessageList.getInstance().QP012_ERROR_OF_MULTIPLE_INSURE_SPAN();
            // 処理を中断し、偽(false)を返す。
            return false;
        }

        // スプラッシュを表示する。
        ACSplashable splash = ACFrame.getInstance().getFrameEventProcesser()
                .createSplash("実績");

        // 画面展開用のレコードinfoを定義・生成する。
        VRMap info = new VRHashMap();
        // ※負担割合
        // 負担割合をあらわす整数rateを宣言し、0で初期化する。
        int rate = 0;
        if (fullPatientRate) {
            // 全額利用者負担の場合
            // 整数rateに10を設定する。
            rate = 10;
            // ※本人・家族
            // レコードinfoにキー「SELF_FLAG」で0を設定する。
            VRBindPathParser.set("SELF_FLAG", info, ACCastUtilities
                    .toInteger(0));
            // ※区分
            // レコードinfoにキー「BILL_INSURE_TYPE」で空文字を設定する。
            VRBindPathParser.set("BILL_INSURE_TYPE", info, "");
        } else {
            VRMap insure = (VRMap) insures.getData();
            // 保険情報のキー「BENEFIT_RATE」の値によって以下の通り分岐する。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("BENEFIT_RATE",
                    insure), 0)) {
            case 2:
                // 値が2の場合：整数rateに1を設定する。
                rate = 1;
                break;
            case 3:
                // 値が3の場合：整数rateに2を設定する。
                rate = 2;
                break;
            case 4:
                // 値が4の場合：整数rateに3を設定する。
                rate = 3;
                break;
            }
            // ※本人・家族
            // レコードinfoにキー「SELF_FLAG」で保険情報のキー「SELF_FLAG」の値を設定する。
            VRBindPathParser.set("SELF_FLAG", info, VRBindPathParser.get(
                    "SELF_FLAG", insure));
            // ※区分
            // レコードinfoにキー「BILL_INSURE_TYPE」で保険区分算出関数の呼び出し結果を設定する。
            VRBindPathParser.set("BILL_INSURE_TYPE", info,
                    createInsureType(insure));
        }
        // 利用者負担割合(byPatientRateValue)に整数rateを設定する。
        setByPatientRateValue(rate);
        // レコードinfoにキー「BY_PATIENT_RATE」で整数rateを設定する。
        VRBindPathParser.set("BY_PATIENT_RATE", info, ACCastUtilities
                .toInteger(rate));

        // ※提供日・保険適用負担の集計
        // 集計クラス(QP012001)を生成し、以下を引数として集計結果を取得する。
        // ・patientID、billStart、billEnd、DBManager、byPatientRateValue
        // レコードinfoに集計結果をマージする。
        info.putAll(new QP012001().calculate(getPatientID(), getBillStart(),
                getBillEnd(), getDBManager()));

        // クライアント領域(contents)にレコードinfoを割り当て・展開する。
        getContents().setSource(info);
        getContents().bindSource();

        if (VRBindPathParser.has("BY_PATIENT_NAME1", info)) {
            // 保険外負担のキーが存在する場合
            ACCheckBox[] useTaxs = getByPatientUseTaxs();
            ACTextField[] taxs = getByPatientTaxs();
            ACCheckBox[] taxTargets = getByPatientTaxTargets();
            int end = useTaxs.length;
            // ※平成19年4月改定(基本内税)対応をすべきか判定する
            if (getInnerTaxH1904Mode()) {
                // innerTaxH1904Modeがtrueの場合

                // 保険外負担の課税チェックをすべて付け直す。
                // 保険外負担の外税チェックをすべて外し直す。
                for (int i = 0; i < end; i++) {
                    useTaxs[i].setSelected(false);
                    taxs[i].setEnabled(true);
                    taxTargets[i].setSelected(true);
                }
            } else {
                // innerTaxH1904Modeがfalseの場合
                // 保険外負担の外税チェックをすべて付け直す。
                for (int i = 0; i < end; i++) {
                    useTaxs[i].setSelected(true);
                    taxs[i].setEnabled(true);
                    taxTargets[i].setSelected(true);
                }
            }
        }

        // 税分と合計欄の再計算を行う
        doCalcTax();

        // スプラッシュを消す。
        if (splash != null) {
            splash.close();
            splash = null;
        }

        return true;
    }

    /**
     * 「登録処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean doInsert() throws Exception {
        // 登録に成功した場合、真(true)を返す。
        // ※入力チェック
        if (!isValidInput()) {
            // 入力チェックの結果、問題があった場合
            // 処理を中断する。
            return false;
        }
        // ※SQLの発行
        // SQL生成用のレコードsqlParamを定義・生成する。
        VRMap sqlParam = new VRHashMap();
        // クライアント領域(contents)にレコードsqlParamを割り当て・収集する。
        getContents().setSource(sqlParam);
        getContents().applySource();
        // 収集したデータのバインドパスをフィルタリングする。
        filterBindPath(sqlParam);
        // レコードsqlPramに以下の値を設定する。
        // ・キー：PATIENT_ID、値：patientID
        VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities
                .toInteger(getPatientID()));
        // ・キー：PROVIDER_ID、値：ログイン事業所ID
        VRBindPathParser.set("PROVIDER_ID", sqlParam, QkanSystemInformation
                .getInstance().getLoginProviderID());
        // ・キー：BILL_SPAN_START、値：billStart
        VRBindPathParser.set("BILL_SPAN_START", sqlParam, getBillStart());
        // ・キー：BILL_SPAN_END、値：billEnd
        VRBindPathParser.set("BILL_SPAN_END", sqlParam, getBillEnd());
        // トランザクションを開始する。
        getDBManager().beginTransaction();
        try {
            // レコードsqlParamを引数に登録SQL文を発行する。
            getDBManager().executeUpdate(getSQL_INSERT_BILL(sqlParam));
            // 登録した領収書の「CLAIM_PATIENT_MEDICAL_ID」「BILL_NO」「LAST_TIME」を取得する。
            VRList bills = getDBManager().executeQuery(
                    getSQL_SELECT_INSERTED_BILL(null));
            VRMap bill = (VRMap) bills.getData();
            // 内部変数claimMedicalIDに検索結果のキー「CLAIM_PATIENT_MEDICAL_ID」の値を退避する。
            setClaimMedicalID(ACCastUtilities.toInt(VRBindPathParser.get(
                    "CLAIM_PATIENT_MEDICAL_ID", bill)));
            // 領収書No.(billNo)に検索結果のキー「BILL_NO」の値を設定する。
            getBillNo().setText(
                    ACCastUtilities.toString(VRBindPathParser.get("BILL_NO",
                            bill)));
            // トランザクションをコミットする。
            getDBManager().commitTransaction();
            // 検索結果をパッシブデータとして登録する。
            getPassiveChecker().reservedPassive(getBILL_PASSIVE_CHECK_KEY(),
                    bills);
        } catch (SQLException ex) {
            // 例外が発生した場合
            // トランザクションをロールバックする。
            getDBManager().rollbackTransaction();
            // 例外を上位に投げて処理を中断する。
            throw ex;
        }
        // ※更新モードに変更
        // プロセスモードを「更新モード」に設定する。
        setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
        // 画面状態を更新モード(UPDATE_MODE)にする。
        setState_UPDATE_MODE();
        // ※状態の再記憶
        // 収集したデータを引数として、新規の定型文を追加登録する。
        insertFixedForm(sqlParam);
        // スナップショットをとる。
        getSnapshot().snapshot();
        // 真(true)を返す。
        return true;
    }

    /**
     * 「更新処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean doUpdate() throws Exception {
        // 更新に成功した場合、真(true)を返す。
        // ※入力チェック
        // 入力チェックの結果、問題があった場合
        if (!isValidInput()) {
            // 処理を中断する。
            return false;
        }
        // ※SQLの発行
        // SQL生成用のレコードsqlParamを定義・生成する。
        VRMap sqlParam = new VRHashMap();
        // クライアント領域(contents)にレコードsqlParamを割り当て・収集する。
        getContents().setSource(sqlParam);
        getContents().applySource();
        // 収集したデータのバインドパスをフィルタリングする。
        filterBindPath(sqlParam);
        // レコードsqlPramに以下の値を設定する。
        // ・キー：CLAIM_PATIENT_MEDICAL_ID、値：claimMedicalID
        VRBindPathParser.set("CLAIM_PATIENT_MEDICAL_ID", sqlParam,
                ACCastUtilities.toInteger(getClaimMedicalID()));
        // ・キー：PATIENT_ID、値：patientID
        VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities
                .toInteger(getPatientID()));
        // ・キー：PROVIDER_ID、値：ログイン事業所ID
        VRBindPathParser.set("PROVIDER_ID", sqlParam, QkanSystemInformation
                .getInstance().getLoginProviderID());
        // ・キー：BILL_SPAN_START、値：billStart
        VRBindPathParser.set("BILL_SPAN_START", sqlParam, getBillStart());
        // ・キー：BILL_SPAN_END、値：billEnd
        VRBindPathParser.set("BILL_SPAN_END", sqlParam, getBillEnd());
        // トランザクションを開始する。
        getDBManager().beginTransaction();
        try {
            // 更新のパッシブチェックを実行する。
            getPassiveChecker().clearPassiveTask();
            getPassiveChecker().addPassiveUpdateTask(
                    getBILL_PASSIVE_CHECK_KEY());
            // パッシブチェックの結果、競合があった場合
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                // トランザクションをロールバックする。
                getDBManager().rollbackTransaction();
                // パッシブエラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // 偽(false)を返して処理を中断する。
                return false;
            }
            // レコードsqlParamを引数に登録SQL文を発行する。
            getDBManager().executeUpdate(getSQL_UPDATE_BILL(sqlParam));
            // 登録した領収書の「CLAIM_PATIENT_MEDICAL_ID」「LAST_TIME」を取得する。
            VRList bills = getDBManager().executeQuery(
                    getSQL_SELECT_UPDATED_BILL(sqlParam));
            // トランザクションをコミットする。
            getDBManager().commitTransaction();
            // 検索結果をパッシブデータとして登録する。
            getPassiveChecker().reservedPassive(getBILL_PASSIVE_CHECK_KEY(),
                    bills);
            // 例外が発生した場合
        } catch (SQLException ex) {
            // トランザクションをロールバックする。
            getDBManager().rollbackTransaction();
            // 例外を上位に投げて処理を中断する。
            throw ex;
        }
        // ※状態の再記憶
        // 収集したデータを引数として、新規の定型文を追加登録する。
        insertFixedForm(sqlParam);
        // スナップショットをとる。
        getSnapshot().snapshot();
        // 真(true)を返す。
        return true;
    }

    /**
     * 「入力チェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean isValidInput() throws Exception {
        // 入力項目をチェックし、すべて保存可能な状態である場合、真(true)を返す。
        // 領収額合計額(totalFull)の値が10桁以上の場合
        if (getTotalFull().getText().replaceAll(",", "").length() > 9) {
            // 合計金額は9桁までのエラーメッセージを表示する。※メッセージID =
            // QP012_ERROR_OF_TOTAL_LIMIT_OVER
            QkanMessageList.getInstance().QP012_ERROR_OF_TOTAL_LIMIT_OVER();
            // 偽(false)を返す。
            return false;
        }
        // 真(true)を返す。
        return true;
    }

    /**
     * 「項目名チェック変更」に関する処理を行ないます。
     * 
     * @param name ACComboBox
     * @throws Exception 処理例外
     */
    public void doCheckName(ACComboBox name) throws Exception {
        // 項目名の入力を監視して合計に反映する。
        if (ACTextUtilities.isNullText(name.getText())) {
            // 引数nameが空欄の場合
            if (!getByInsurerAndPatientNameCache().contains(name)) {
                // 引数nameがbyInsurerAndPatientNameCacheに含まれていない場合(以前から空欄)
                // 処理を中断する。
                return;
            }
            // 引数nameをbyInsurerAndPatientNameCacheから除外する。
            getByInsurerAndPatientNameCache().remove(name);
        } else {
            // 引数nameが空欄ではない場合
            if (getByInsurerAndPatientNameCache().contains(name)) {
                // 引数nameがbyInsurerAndPatientNameCacheに含まれている場合(以前から入力済み)
                // 処理を中断する。
                return;
            }
            // 引数nameをbyInsurerAndPatientNameCacheに追加する。
            getByInsurerAndPatientNameCache().add(name);
        }
        // 合計欄を再計算する。
        doCalcTotal();
    }

    /**
     * 「保険適用負担の金額再計算」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doCalcSum(ACTextField price, ACTextField number, ACTextField sum)
            throws Exception {
        // 保険適用負担の金額を再計算する。
        // 引数priceかnumberのいずれかが空欄の場合
        if (ACTextUtilities.isNullText(price)
                || ACTextUtilities.isNullText(number)) {
            // 処理を中断する。
            return;
        }
        // 「引数priceの値」×「引数numberの値」を引数sumに設定する。
        sum.setText(ACCastUtilities.toString(ACCastUtilities.toInt(price
                .getText())
                * ACCastUtilities.toInt(number.getText())));
        // 合計欄を再計算する。
        doCalcTotal();

    }

    /**
     * 「外税チェック変更」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doCheckTax(ACTextField price, ACTextField number,
            ACTextField sum, ACCheckBox taxTarget, ACCheckBox useTax,
            ACTextField tax, boolean mustCalcTax) throws Exception {
        // 外税チェックを切り替える。
        if (taxTarget.isSelected()) {
            // 引数taxTargetにチェックが付いている場合
            // 引数useTaxを有効にする。
            useTax.setEnabled(true);
            if (getInnerTaxH1904Mode() || useTax.isSelected()) {
                // innerTaxH1904Modeがtrueか引数useTaxのチェックが付いている場合
                // 引数taxを有効にする。
                tax.setEnabled(true);
            } else {
                // innerTaxH1904Modeがfalseかつ引数useTaxのチェックが付いていない場合
                // 引数taxを無効にする。
                tax.setEnabled(false);
            }
        } else {
            // 引数taxTargetにチェックが付いていない場合
            // 引数taxを無効にする。
            tax.setEnabled(false);
            // 引数useTaxを無効にする。
            useTax.setEnabled(false);
        }

        if (getInnerTaxH1904Mode() && mustCalcTax) {
            // innerTaxH1904Modeがtrueかつ引数calcTaxがtrueの場合
            // 消費税等の再計算を行う。
            getByPatientSumCache().remove(sum);
        }

        // 保険外負担の金額を再計算する。
        doCalcSum(price, number, sum, taxTarget, useTax, tax, false);

    }

    /**
     * 「保険外負担の金額再計算」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doCalcSum(ACTextField price, ACTextField number,
            ACTextField sum, ACCheckBox taxTarget, ACCheckBox useTax,
            ACTextField tax, boolean mustCalcSum) throws Exception {
        // 保険外負担の金額を再計算する。
        // 引数priceかnumberのいずれかが空欄の場合
        if (ACTextUtilities.isNullText(price)
                || ACTextUtilities.isNullText(number)) {
            // 処理を中断する。
            return;
        }
        if (mustCalcSum) {
            // 「引数mustCalcSum」がtrueの場合
            // 「引数priceの値」×「引数numberの値」を引数sumに設定する。
            sum.setText(ACCastUtilities.toString(ACCastUtilities.toInt(price
                    .getText())
                    * ACCastUtilities.toInt(number.getText())));
        }
        // 保険外負担の税金を再計算する。
        doCalcSum(sum, taxTarget, useTax, tax);

    }

    /**
     * 「保険外負担の税再計算」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doCalcSum(ACTextField sum, ACCheckBox taxTarget,
            ACCheckBox useTax, ACTextField tax) throws Exception {
        // 保険外負担の税金を再計算する。
        if (taxTarget.isSelected()
                && (getInnerTaxH1904Mode() || useTax.isSelected())) {
            // 引数taxTargetにチェックが付いており、かつinnerTaxH1904Modeがtrueか引数useTaxにチェックが付いている場合
            String val = sum.getText();
            if (!val.equals(getByPatientSumCache().get(sum))) {
                // byPatientSumCacheのキーにsumが含まれないか、キーに対応する値が現在のsumの値と異なる場合
                // byPatientSumCacheにsumをキー、値をsumの値として設定する。
                getByPatientSumCache().put(sum, val);
                if (ACTextUtilities.isNullText(val)) {
                    // 引数sumが空欄の場合
                    // 引数taxに空欄を設定する。
                    tax.setText("");
                } else {
                    // 引数sumが空欄ではない場合
                    if (getInnerTaxH1904Mode() && !useTax.isSelected()) {
                        // innerTaxH1904Modeがtrueかつ引数useTaxにチェックが付いていない場合
                        // 内税として消費税を算出する。
                        // ※
                        // 「引数sumの値」－「引数sumの値」÷(100.0＋「消費税率(tax)の値」）×100.0を小数点以下切捨てで引数taxに設定する。
                        int sumVal = ACCastUtilities.toInt(val, 0);
                        tax
                                .setText(ACCastUtilities.toString((int) Math
                                        .floor(sumVal
                                                - sumVal
                                                / (100d + ACCastUtilities
                                                        .toDouble(getTax()
                                                                .getText(), 0))
                                                * 100d)));

                    } else {
                        // innerTaxH1904Modeがfalseまたは引数useTaxにチェックが付いている場合
                        // 外税として消費税を算出する。
                        // ※「引数sumの値」×「消費税率(tax)の値」を小数点以下切捨てで引数taxに設定する。
                        tax.setText(ACCastUtilities.toString((int) Math
                                .ceil(ACCastUtilities.toInt(val, 0)
                                        * ACCastUtilities.toDouble(getTax()
                                                .getText(), 0)) / 100));
                    }
                }
            }
        }
        // 合計欄を再計算する。
        doCalcTotal();

    }

    /**
     * 「合計欄の再計算」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doCalcTotal() throws Exception {
        // 合計欄を再計算する。
        // 画面展開用のレコードinfoを定義・生成する。
        VRMap info = new VRHashMap();
        VRMap data = new VRHashMap();
        getItemContents().setSource(data);
        getItemContents().applySource();
        filterBindPath(data);
        // 保険適用負担の金額(byInsurerSum～)の合計額に利用者負担割合(byPatientRateValue)を乗じ、
        // 小数点以下を四捨五入した結果を、レコードinfoのキー「BILL_NO_TAX_BY_INSURER」で設定する。
        long noTaxByInsurer = 0;
        for (int i = 1; i <= ROWS_OF_ITEM; i++) {
            noTaxByInsurer += ACCastUtilities.toInt(VRBindPathParser.get(
                    "BY_INSURER_SUM" + i, data), 0);
        }
        noTaxByInsurer = Math.round(noTaxByInsurer / 100.0
                * getByPatientRateValue()) * 10;
        VRBindPathParser.set("BILL_NO_TAX_BY_INSURER", info, new Long(
                noTaxByInsurer));
        // 保険外負担の金額(byPatientSum～)の合計額をレコードinfoのキー「BILL_NO_TAX_BY_PATIENT」で設定する。
        long noTaxByPatient = 0;
        for (int i = 1; i <= ROWS_OF_ITEM; i++) {
            noTaxByPatient += ACCastUtilities.toInt(VRBindPathParser.get(
                    "BY_PATIENT_SUM" + i, data), 0);
        }
        VRBindPathParser.set("BILL_NO_TAX_BY_PATIENT", info, new Long(
                noTaxByPatient));

        // 保険外負担の消費税等(byPatientTax～)の合計額をレコードinfoのキー「BILL_IN_TAX_BY_PATIENT」で設定する。
        int inTaxByPatient = 0;
        for (int i = 1; i <= ROWS_OF_ITEM; i++) {
            inTaxByPatient += ACCastUtilities.toInt(VRBindPathParser.get(
                    "BY_PATIENT_TAX" + i, data), 0);
        }
        VRBindPathParser.set("BILL_IN_TAX_BY_PATIENT", info, ACCastUtilities
                .toInteger(inTaxByPatient));
        // 上記3件の合計額をレコードinfoのキー「BILL_FULL_TOTAL」で設定する。
        VRBindPathParser.set("BILL_FULL_TOTAL", info, new Long(noTaxByInsurer
                + noTaxByPatient + inTaxByPatient
                             - ACCastUtilities.toInt(VRBindPathParser.get(
                        "BY_PATIENT_TOTAL_INNER_TAX", data), 0)
        
        ));
        
        if(getInnerTaxH1904Mode()){
            //平成19年4月改定(基本内税)対応版の場合
            // 明細合計には消費税も含んだ値を印字すべきとの仕様から、
            // 保険外負担の金額(byPatientSum～)の合計額であるレコードinfoのキー「BILL_NO_TAX_BY_PATIENT」の値に、
            // 領収額合計から保険の明細合計額を引いた値を再設定する。
            VRBindPathParser.set("BILL_NO_TAX_BY_PATIENT", info, new Long(
                    noTaxByPatient
                            + inTaxByPatient
                            - ACCastUtilities.toInt(VRBindPathParser.get(
                                    "BY_PATIENT_TOTAL_INNER_TAX", data), 0)));
        }

        // 合計領域(totalContents)にレコードinfoを割り当て・展開する。
        getTotalContents().setSource(info);
        getTotalContents().bindSource();
    }

    /**
     * 「税再集計」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doCalcTax() throws Exception {
        // 保険外負担分項目の税分の再計算と、合計欄の再計算を行う。
        getByPatientSumCache().clear();
        ACTextField[] sums = getByPatientSums();
        ACCheckBox[] taxTargets = getByPatientTaxTargets();
        ACCheckBox[] useTaxs = getByPatientUseTaxs();
        ACTextField[] taxs = getByPatientTaxs();
        int end = sums.length;
        for (int i = 0; i < end; i++) {
            doCalcSum(sums[i], taxTargets[i], useTaxs[i], taxs[i]);
        }
    }

    /**
     * 「データのフィルタリング」に関する処理を行ないます。
     * 
     * @param data VRMap
     * @throws Exception 処理例外
     */
    public void filterBindPath(VRMap data) throws Exception {
        // データ中のバインドパスをフィルタリングする。

      // 内税の合計を表す変数totalInnerTaxを定義し0で初期化する。
      long totalInnerTax = 0;

        for (int i = 1; i <= ROWS_OF_ITEM; i++) {
            // 保険負担分の項目名の値が空欄ならば「項目名」「単価」「数量」「金額」のバインドパスを削除する。
            if (ACTextUtilities.isNullText(VRBindPathParser.get(
                    "BY_INSURER_NAME" + i, data))) {
                data.remove("BY_INSURER_NAME" + i);
                data.remove("BY_INSURER_PRICE" + i);
                data.remove("BY_INSURER_NUMBER" + i);
                data.remove("BY_INSURER_SUM" + i);
            }
            // 保険外負担分の項目名の値が空欄ならば「項目名」「単価」「数量」「金額」「消費税等」のバインドパスを削除する。
            if (ACTextUtilities.isNullText(VRBindPathParser.get(
                    "BY_PATIENT_NAME" + i, data))) {
                data.remove("BY_PATIENT_NAME" + i);
                data.remove("BY_PATIENT_PRICE" + i);
                data.remove("BY_PATIENT_NUMBER" + i);
                data.remove("BY_PATIENT_SUM" + i);
                if (getInnerTaxH1904Mode()) {
                    // innerTaxH1904Mode が true の場合
                    // 「外税」のバインドパスを削除する。
                    data.remove("BY_PATIENT_USE_TAX" + i);
                } else {
                    // innerTaxH1904Mode が false の場合
                    // 「外税」の値を1とし、チェックが付く状態にする。
                    VRBindPathParser.set("BY_PATIENT_USE_TAX" + i, data,
                            ACCastUtilities.toInteger(1));
                }
                data.remove("BY_PATIENT_TAX" + i);
                // 「課税」の値を1とし、チェックが付く状態にする。
                VRBindPathParser.set("BY_PATIENT_TAX_TARGET" + i, data,
                        ACCastUtilities.toInteger(1));
            } else if (ACCastUtilities.toInt(VRBindPathParser.get(
                    "BY_PATIENT_TAX_TARGET" + i, data), -1) == 0) {
                // 保険外負担分の項目名が入力済みでも、「課税」の値が0(チェックなし)の場合は「消費税等」のバインドパスを削除する。
                data.remove("BY_PATIENT_TAX" + i);
            } else if (ACCastUtilities.toInt(VRBindPathParser.get(
                    "BY_PATIENT_USE_TAX" + i, data), -1) == 0) {
                // 保険外負担分の項目名が入力済みでも、「税」の値が0(チェックなし)の場合

                // replace-begin 2007/03/10 Tozo Tanaka
                // // 「消費税等」のバインドパスを削除する。
                // data.remove("BY_PATIENT_TAX" + i);

                if (getInnerTaxH1904Mode()) {
                    // innerTaxH1904Mode が true の場合

                    // 「金額」×「消費税率(tax)の値」を小数点以下切捨てて内税の合計(totalInnerTax)に加算する。
                    totalInnerTax += ACCastUtilities.toInt(VRBindPathParser
                            .get("BY_PATIENT_TAX" + i, data), 0);
                } else {
                    // innerTaxH1904Mode が false の場合
                    // 「消費税等」のバインドパスを削除する。
                    data.remove("BY_PATIENT_TAX" + i);

                }
                // replace-end 2007/03/10 Tozo Tanaka
            }
        }
      // 引数「data」にキー「BY_PATIENT_TOTAL_INNER_TAX」で内税の合計(totalInnerTax)を設定する。
      data.put("BY_PATIENT_TOTAL_INNER_TAX", new Long(totalInnerTax));
    }

    /**
     * 「定型文の追加」に関する処理を行ないます。
     * 
     * @param data VRMap
     * @throws Exception 処理例外
     */
    public void insertFixedForm(VRMap data) throws Exception {

        // 保険負担分・保険外負担分の項目名として、定型文に登録されていないものがあれば定型文に追加する。
        // SQL生成用のレコードsqlParamを定義・生成する。
        VRMap sqlParam = new VRHashMap();
        // 追加定型文用のセットformsを定義・生成する。
        Set forms = new TreeSet();
        // トランザクションを開始する。
        getDBManager().beginTransaction();
        try {
            // レコードsqlParamにキー「FIXED_FORM_ID」、値「1」を設定する。
            VRBindPathParser.set("FIXED_FORM_ID", sqlParam, ACCastUtilities
                    .toInteger(1));
            // 定型文テーブルから、保険負担分用の定型文を取得する。
            VRList list = getDBManager().executeQuery(
                    getSQL_SELECT_FIXED_FORM(sqlParam));
            // 引数dataから、保険負担分の項目名にあたるキーを全走査し、以下の条件に合致するものをセットformsに追加する。
            for (int i = 1; i <= ROWS_OF_ITEM; i++) {
                String val = ACCastUtilities.toString(VRBindPathParser.get(
                        "BY_INSURER_NAME" + i, data));
                if (!ACTextUtilities.isNullText(val)) {
                    // ・取得した定型文テーブルには存在しない項目名であること。
                    if (ACBindUtilities.getMatchIndexFromValue(list, "CONTENT",
                            val) < 0) {
                        // ・今回追加分の中で重複しないものであること。(セットformsに追加済みでないこと)
                        if (!forms.contains(val)) {
                            forms.add(val);
                        }
                    }
                }
            }

            // セットformsを全走査し、以下の処理を行なう。
            Iterator it = forms.iterator();
            while (it.hasNext()) {
                // sqlParamのキー「CONTENT」の値として、走査した値を追加する。
                VRBindPathParser.set("CONTENT", sqlParam, it.next());
                // 定型文への追加SQLを発行する。
                getDBManager()
                        .executeUpdate(getSQL_INSERT_FIXED_FORM(sqlParam));
            }
            // セットformsをクリアする。
            forms.clear();
            // レコードsqlParamにキー「FIXED_FORM_ID」、値「2」を設定する。
            VRBindPathParser.set("FIXED_FORM_ID", sqlParam, ACCastUtilities
                    .toInteger(2));
            // 定型文テーブルから、保険外負担分用の定型文を取得する。
            list = getDBManager().executeQuery(
                    getSQL_SELECT_FIXED_FORM(sqlParam));
            // 引数dataから、保険外負担分の項目名にあたるキーを全走査し、以下の条件に合致するものをレコードformsのキーとして追加する。
            for (int i = 1; i <= ROWS_OF_ITEM; i++) {
                String val = ACCastUtilities.toString(VRBindPathParser.get(
                        "BY_PATIENT_NAME" + i, data));
                if (!ACTextUtilities.isNullText(val)) {
                    // ・取得した定型文テーブルには存在しない項目名であること。
                    if (ACBindUtilities.getMatchIndexFromValue(list, "CONTENT",
                            val) < 0) {
                        // ・今回追加分の中で重複しないものであること。(セットformsに追加済みでないこと)
                        if (!forms.contains(val)) {
                            forms.add(val);
                        }
                    }
                }
            }
            // セットformsを全走査し、以下の処理を行なう。
            it = forms.iterator();
            while (it.hasNext()) {
                // sqlParamのキー「CONTENT」の値として、走査した値を追加する。
                VRBindPathParser.set("CONTENT", sqlParam, it.next());
                // 定型文への追加SQLを発行する。
                getDBManager()
                        .executeUpdate(getSQL_INSERT_FIXED_FORM(sqlParam));
            }
            // トランザクションをコミットする。
            getDBManager().commitTransaction();
        } catch (SQLException ex) {
            getDBManager().rollbackTransaction();
            throw ex;
        }

    }

    /**
     * 「保険区分の解析」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public String createInsureType(VRMap insureInfo) throws Exception {
        // 医療保険情報から保険者区分を解析して返す。
        StringBuffer sb = new StringBuffer();

        // ※主保険の制度略称を結合
        String mainInsure;
        String insurerID = ACCastUtilities.toString(VRBindPathParser.get(
                "MEDICAL_LAW_NO", insureInfo))
                + ACCastUtilities.toString(VRBindPathParser.get(
                        "MEDICAL_INSURER_ID", insureInfo));
        switch (insurerID.length()) {
        case 4:
            // 保険者番号が4桁の場合は「政管」を連結する。
            mainInsure = "政管";
            break;
        case 6:
            // 保険者番号が6桁の場合は「国保」を連結する。
            mainInsure = "国保";
            break;
        case 8:
            // 保険者番号が8桁の場合は、保険(公費)短縮制度名フォーマットの変換結果を連結する。
            // replace-begin 2006-10-25 Tozo TANAKA
            // mainInsure =
            // QkanMedicalInsureTypeFormat.getInstance().format(ACCastUtilities.toInteger(insurerID.substring(0,2),0));
            mainInsure = QkanMedicalInsureTypeFormat.getInstance().format(
                    insurerID);
            // replace-end 2006-10-25 Tozo TANAKA
            break;
        default:
            // いずれの桁数にも該当しない場合は保険種別(INSURE_TYPE)の変換結果を連結する。
            mainInsure = QkanInsureTypeFormat.getInstance().format(
                    VRBindPathParser.get("INSURE_TYPE", insureInfo));
            break;
        }
        sb.append(mainInsure);

        Set insureSet = new HashSet();
        insureSet.add(mainInsure);

        // ※老人区分を結合
        if (ACCastUtilities.toInt(VRBindPathParser.get("OLD_FLAG", insureInfo),
                0) == 1) {
            // 保険情報として老人が選択されていた場合
            if (!"老人".equals(mainInsure)) {
                // 主保険として老人が指定されていない場合
                // 「 老人」を連結する。
                if (sb.length() != 0) {
                    sb.append("　");
                }
                sb.append("老人");
                insureSet.add("老人");
            }
            switch (ACCastUtilities.toInt(VRBindPathParser.get("OLD_RATE_FLAG",
                    insureInfo), 0)) {
            case 1:
                // 保険情報として高齢9が選択されていた場合
                // 「一割」を連結する。
                sb.append("一割");
                break;
            case 2:
                // 保険情報として高齢8が選択されていた場合
                // 「二割」を連結する。
                sb.append("二割");
                break;
            case 3:
                // 保険情報として高齢7が選択されていた場合
                // 「三割」を連結する。
                sb.append("三割");
                break;
            }
        }

        // ※公費制度略称を結合
        // SQL生成用のレコードsqlParamを定義・生成する。
        VRMap sqlParam = new VRHashMap();

        // レコードsqlPramに以下の値を設定する。
        // ・キー：PATIENT_ID、値：patientID
        VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities
                .toInteger(getPatientID()));
        // ・キー：BILL_SPAN_START、値：billStart
        VRBindPathParser.set("BILL_SPAN_START", sqlParam, getBillStart());
        // ・キー：BILL_SPAN_END、値：billEnd
        VRBindPathParser.set("BILL_SPAN_END", sqlParam, getBillEnd());
        // レコードsqlParamを引数に請求期間の公費取得SQL文を発行する。
        VRList kohis = getDBManager().executeQuery(
                getSQL_SELECT_BILL_KOHI(sqlParam));

        // 取得した公費一覧を全走査し、以下の結合処理を行なう。
        boolean blank = sb.length() == 0;
        Iterator it = kohis.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            // 公費の法別番号(KOHI_LAW_NO)を保険(公費)短縮制度名フォーマットで変換する。
            // replace-begin 2006-10-25 Tozo TANAKA
            // String kohiName =
            // QkanMedicalInsureTypeFormat.getInstance().format(
            // ACCastUtilities.toInteger(VRBindPathParser.get(
            // "KOHI_LAW_NO", row),0));
            String kohiName = QkanMedicalInsureTypeFormat.getInstance().format(
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "KOHI_LAW_NO", row))
                            + ACCastUtilities.toString(VRBindPathParser.get(
                                    "INSURER_ID", row)));
            // replace-end 2006-10-25 Tozo TANAKA
            if ((!ACTextUtilities.isNullText(kohiName))
                    && (!insureSet.contains(kohiName))) {
                // 変換結果が空文字でなく新出の公費名の場合
                if (blank) {
                    blank = false;
                } else {
                    // 「 」を連結する。
                    sb.append("　");
                }
                // 変換した公費の短縮制度名を連結する。
                sb.append(kohiName);
                // add-begin 2006-10-25 Tozo TANAKA
                insureSet.add(kohiName);
                // add-end 2006-10-25 Tozo TANAKA
            }
        }

        // 結合結果を返す。
        return sb.toString();
    }

    /**
     * 「項目名配列を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return ACComboBox[]
     */
    public ACComboBox[] getByInsurerNamesAndPatientNames() throws Exception {
        return new ACComboBox[] { getByInsurerName1(), getByInsurerName2(),
                getByInsurerName3(), getByInsurerName4(), getByInsurerName5(),
                getByInsurerName6(), getByInsurerName7(), getByInsurerName8(),
                getByInsurerName9(), getByInsurerName10(),
                getByInsurerName11(), getByInsurerName12(),
                getByInsurerName13(), getByInsurerName14(),
                getByInsurerName15(), getByInsurerName16(),
                getByInsurerName17(), getByInsurerName18(),
                getByInsurerName19(), getByInsurerName20(),
                getByPatientName1(), getByPatientName2(), getByPatientName3(),
                getByPatientName4(), getByPatientName5(), getByPatientName6(),
                getByPatientName7(), getByPatientName8(), getByPatientName9(),
                getByPatientName10(), getByPatientName11(),
                getByPatientName12(), getByPatientName13(),
                getByPatientName14(), getByPatientName15(),
                getByPatientName16(), getByPatientName17(),
                getByPatientName18(), getByPatientName19(),
                getByPatientName20(), };
    }

    /**
     * 「利用者負担の単価配列を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return ACTextField[]
     */
    public ACTextField[] getByPatientPrices() throws Exception {
        return new ACTextField[] { getByPatientPrice1(), getByPatientPrice2(),
                getByPatientPrice3(), getByPatientPrice4(),
                getByPatientPrice5(), getByPatientPrice6(),
                getByPatientPrice7(), getByPatientPrice8(),
                getByPatientPrice9(), getByPatientPrice10(),
                getByPatientPrice11(), getByPatientPrice12(),
                getByPatientPrice13(), getByPatientPrice14(),
                getByPatientPrice15(), getByPatientPrice16(),
                getByPatientPrice17(), getByPatientPrice18(),
                getByPatientPrice19(), getByPatientPrice20(), };
    }

    /**
     * 「利用者負担の個数配列を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return ACTextField[]
     */
    public ACTextField[] getByPatientNumbers() throws Exception {
        return new ACTextField[] { getByPatientNumber1(),
                getByPatientNumber2(), getByPatientNumber3(),
                getByPatientNumber4(), getByPatientNumber5(),
                getByPatientNumber6(), getByPatientNumber7(),
                getByPatientNumber8(), getByPatientNumber9(),
                getByPatientNumber10(), getByPatientNumber11(),
                getByPatientNumber12(), getByPatientNumber13(),
                getByPatientNumber14(), getByPatientNumber15(),
                getByPatientNumber16(), getByPatientNumber17(),
                getByPatientNumber18(), getByPatientNumber19(),
                getByPatientNumber20(), };
    }

    /**
     * 「利用者負担の金額配列を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return ACTextField[]
     */
    public ACTextField[] getByPatientSums() throws Exception {
        return new ACTextField[] { getByPatientSum1(), getByPatientSum2(),
                getByPatientSum3(), getByPatientSum4(), getByPatientSum5(),
                getByPatientSum6(), getByPatientSum7(), getByPatientSum8(),
                getByPatientSum9(), getByPatientSum10(), getByPatientSum11(),
                getByPatientSum12(), getByPatientSum13(), getByPatientSum14(),
                getByPatientSum15(), getByPatientSum16(), getByPatientSum17(),
                getByPatientSum18(), getByPatientSum19(), getByPatientSum20(), };
    }

    /**
     * 「利用者負担の税配列を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return ACIntegerCheckBox[]
     */
    public ACIntegerCheckBox[] getByPatientUseTaxs() throws Exception {
        return new ACIntegerCheckBox[] { getByPatientUseTax1(),
                getByPatientUseTax2(), getByPatientUseTax3(),
                getByPatientUseTax4(), getByPatientUseTax5(),
                getByPatientUseTax6(), getByPatientUseTax7(),
                getByPatientUseTax8(), getByPatientUseTax9(),
                getByPatientUseTax10(), getByPatientUseTax11(),
                getByPatientUseTax12(), getByPatientUseTax13(),
                getByPatientUseTax14(), getByPatientUseTax15(),
                getByPatientUseTax16(), getByPatientUseTax17(),
                getByPatientUseTax18(), getByPatientUseTax19(),
                getByPatientUseTax20(), };
    }

    /**
     * 「利用者負担の消費税等配列を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return ACTextField[]
     */
    public ACTextField[] getByPatientTaxs() throws Exception {
        return new ACTextField[] { getByPatientTax1(), getByPatientTax2(),
                getByPatientTax3(), getByPatientTax4(), getByPatientTax5(),
                getByPatientTax6(), getByPatientTax7(), getByPatientTax8(),
                getByPatientTax9(), getByPatientTax10(), getByPatientTax11(),
                getByPatientTax12(), getByPatientTax13(), getByPatientTax14(),
                getByPatientTax15(), getByPatientTax16(), getByPatientTax17(),
                getByPatientTax18(), getByPatientTax19(), getByPatientTax20(), };
    }

    /**
     * 「利用者負担の課税対象配列を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return ACIntegerCheckBox[]
     */
    public ACIntegerCheckBox[] getByPatientTaxTargets() throws Exception {
        return new ACIntegerCheckBox[] { getByPatientTaxTarget1(),
                getByPatientTaxTarget2(), getByPatientTaxTarget3(),
                getByPatientTaxTarget4(), getByPatientTaxTarget5(),
                getByPatientTaxTarget6(), getByPatientTaxTarget7(),
                getByPatientTaxTarget8(), getByPatientTaxTarget9(),
                getByPatientTaxTarget10(), getByPatientTaxTarget11(),
                getByPatientTaxTarget12(), getByPatientTaxTarget13(),
                getByPatientTaxTarget14(), getByPatientTaxTarget15(),
                getByPatientTaxTarget16(), getByPatientTaxTarget17(),
                getByPatientTaxTarget18(), getByPatientTaxTarget19(),
                getByPatientTaxTarget20(), };
    }

    /**
     * 「平成19年4月改定チェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkInnerTaxModeH1804() throws Exception {
        // ※平成19年4月改定(基本内税)対応をすべきか判定する
        if (
                ACDateUtilities.compareOnDay(getBillStart(), ACDateUtilities
                .createDate(2007, 4, 1)) >= 0) {
            // 請求期間の開始が平成19年4月1日以降の場合
            // innerTaxH1904Mode に true を代入する。
            setInnerTaxH1904Mode(true);
            // 画面状態を基本内税対応あり(VALID_INNER_TAX_H1804)にする。
            setState_VALID_INNER_TAX_H1804();
            // 課税対象額(totalInTaxTitle)のテキストを「(うち消費税額)」にする。
            getTotalInTaxTitle().setText("(うち消費税額)");
            // 保険外負担分外税タイトル(byPatientUseTaxTitle)のテキストを「外税」にする。
            getByPatientUseTaxTitle().setText("外税");

            // 税説明(useTaxInfomation)のテキストを以下とする。
            // 「課税」列にチェックをつけると、課税対象の項目として内税/外税の選択が可能になります。
            // 「外税」列にチェックをつけると、外税として消費税等列に全額が自動入力されます。
            // チェックを外すと、内税となります。
            getUseTaxInfomation()
                    .setText(
                            "「課税」列にチェックをつけると、課税対象の項目として内税/外税の選択が"
                                    + ACConstants.LINE_SEPARATOR
                                    + "　可能になります。チェックを外すと、非課税として扱います。"
                                    + ACConstants.LINE_SEPARATOR
                                    +"「外税」列にチェックをつけると、消費税等列に外税額が自動入力されます。"
                                    + ACConstants.LINE_SEPARATOR
                                    + "　チェックをはずすと、消費税等列に内税額が自動入力されます。");

            // 保険外負担分外税の各チェックのテキストを半角空白( )にする。
            // 保険外負担の外税チェックをすべて外す。
            // 保険外負担の課税チェックをすべてつける。
            ACIntegerCheckBox[] useTaxs = getByPatientUseTaxs();
            ACIntegerCheckBox[] taxTargets = getByPatientTaxTargets();
            int end = useTaxs.length;
            for (int i = 0; i < end; i++) {
                useTaxs[i].setText(" ");
                useTaxs[i].setSelected(false);
                taxTargets[i].setSelected(true);
            }

        } else {
            // 請求期間の開始が平成19年4月1日より前の場合
            // innerTaxH1904Mode に false を代入する。
            setInnerTaxH1904Mode(false);
            // 画面状態を基本内税対応なし(INVALID_INNER_TAX_H1804)にする。
            setState_INVALID_INNER_TAX_H1804();

            // 保険外負担の課税チェックをすべてつける。
            ACIntegerCheckBox[] taxTargets = getByPatientTaxTargets();
            int end = taxTargets.length;
            for (int i = 0; i < end; i++) {
                taxTargets[i].setSelected(true);
            }
        }
    }

}
