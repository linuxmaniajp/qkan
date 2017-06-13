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
 * 開発者: 
 * 作成日: 2006/06/06  日本コンピューター株式会社  新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その多機能 (O)
 * プロセス 日医標準レセプトソフト連携 (013)
 * プログラム 日医標準レセプトソフト連携 (QO013)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo013;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001SpecialCase;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACKanaConvert;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.ACMessageBoxExceptionPanel;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.ac.util.splash.ACSplash;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.ac.util.splash.ACStopButtonSplash;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qo.qo002.QO002_M_InsurerBridgeFirebirdDBManager;

/**
 * 日医標準レセプトソフト連携(QO013)
 */
public class QO013 extends QO013Event {
    /**
     * コンストラクタです。
     */
    public QO013() {
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
        // ※画面展開処理
        // ※初期化
        // 画面状態を初期化する。
        setState_NOT_CONNECTED();
        // 初期化処理を行う。
        initialize();

    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // ※戻り処理
        // 前画面に遷移する。
        try {
            // 中間テーブルの破棄
            QkanReceiptSoftDBManager.clearAccessSpace(getDBManager());
        } catch (Exception e) {
        }

        return true;
    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // ※終了処理
        // システムを終了する。
        try {
            // 中間テーブルの破棄
            QkanReceiptSoftDBManager.clearAccessSpace(getDBManager());
        } catch (Exception e) {
        }

        return true;
    }

    // コンポーネントイベント

    /**
     * 「通信処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void connectActionPerformed(ActionEvent e) throws Exception {
        // ※通信処理（日レセデータ取得）
        // 通信処理
        // 日レセデータを取得する。
        doFind();

    }

    /**
     * 「取り込み処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void importPatientActionPerformed(ActionEvent e) throws Exception {
        // ※患者情報取り込み処理
        // 取り込み前に情報を保存しておく
        saveProperty();
        // 再度設定読込み
        readProperty();
        // 患者情報取り込み
        if (doInsert()) {

            VRList list = new VRArrayList();
            // テーブルから現在の情報を取得する
            Object obj = getReceiptTableModel().getAdaptee();
            if (obj instanceof VRList) {
                // listに変換
                list = (VRList) obj;
            } else {
                // 変換できない場合は処理終了
                return;
            }
            // 重複チェックを行う。
            list = checkSameName(list);
            
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin 日レセ連携機能追加対応
            //画面上のチェックをOFFに
            int count = list.size();
            for (int i = 0; i < count; i++) {
                VRMap row = (VRMap)list.get(i);
                VRBindPathParser.set("IMPORT_FLAG", row, new Boolean(false));
            }
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - end 日レセ連携機能追加対応
            
            // 結果を格納する。
            getReceiptTableModel().setAdaptee(list);
            // メッセージ表示
            // [H28.4 要望][Shnobu Hitaka] 2016/02/03 edit - begin 介護情報連携対応
            // QkanMessageList.getInstance().QO013_SUCCESS_INSERT();
            if (getImportMessage().length() > 0) {
	            ACMessageBoxExceptionPanel pnl = new ACMessageBoxExceptionPanel();
	            String msg1 = "患者情報を取り込みました。";
	            String msg2 = "介護認定・介護保険情報が取り込めない患者がありました。" + ACConstants.LINE_SEPARATOR + "詳細をご確認の上、利用者情報詳細画面で認定情報を登録してください。";
	            pnl.setEnvironment(msg2);
	            pnl.setInfomation(ACConstants.LINE_SEPARATOR + getImportMessage() + ACConstants.LINE_SEPARATOR + ACConstants.LINE_SEPARATOR);
	            ACMessageBox.show(msg1, pnl, true);
	            if (pnl.getParent() != null) {
	                pnl.getParent().remove(pnl);
	            }
	            pnl = null;
            } else {
            	QkanMessageList.getInstance().QO013_SUCCESS_INSERT();
            }
            // [H28.4 要望][Shnobu Hitaka] 2016/02/03 edit - end
        } else {
        	// [H28.4 要望][Shnobu Hitaka] 2016/02/03 add - begin 介護情報連携対応
            QkanMessageList.getInstance().QO013_ERROR_OF_CONECT_CUSTOM(
                    "介護保険・介護認定情報の取り込み", 
                    ACConstants.LINE_SEPARATOR + "最新のdbsパッケージ(jma-receipt-dbs)をインストールするか、" +
                    ACConstants.LINE_SEPARATOR + "設定変更・メンテナンス画面で介護保険・介護認定情報の取り込みチェックをはずしてください。");
            // [H28.4 要望][Shnobu Hitaka] 2016/02/03 add - end
            return;
        }
    }

    /**
     * 「前へボタン押下」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void previewPageActionPerformed(ActionEvent e) throws Exception {
        // ※前へボタン押下時の処理
        
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin 日レセ連携機能追加対応
        //画面上のチェック状態を保存する
        updateCheckState();
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end 日レセ連携機能追加対応
        
        // 前へボタン押下時
        // 現在のページ数が1ページ以外だった場合
        // 次ページ情報取得
        if (getNowPage() > 1) {
            // ページ数を1引く
            setNowPage(getNowPage() - 1);

            // ボタン状態制御
            pageButtonState();
            int begin = ((getNowPage() - 1) * PAGE_COUNT) + 1;
            int end = (getNowPage() * PAGE_COUNT) + 1;
            // 前ページ情報取得
            VRList list = getPageData(begin, end);
            // 結果を格納する。
            getReceiptTableModel().setAdaptee(list);
        }
    }

    /**
     * 「次へボタン押下」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void nextPageActionPerformed(ActionEvent e) throws Exception {
        // ※次へボタン押下時の処理
        
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin 日レセ連携機能追加対応
        //画面上のチェック状態を保存する
        updateCheckState();
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end 日レセ連携機能追加対応
        
        // 次へボタン押下時
        int begin = (getNowPage() * PAGE_COUNT) + 1;
        int end = ((getNowPage() + 1) * PAGE_COUNT) + 1;
        // ページ数を + 1
        setNowPage(getNowPage() + 1);
        // 1ページ分データ取得
        VRList list = getPageData(begin, end);
        // 結果を格納する。
        getReceiptTableModel().setAdaptee(list);
        // 状態制御
        pageButtonState();
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QO013.class.getName(), param));
    }

    // 内部関数

    /**
     * 「初期設定」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void initialize() throws Exception {
        // ※初期設定
        // ※ウインドウタイトル・業務ボタンを設定する。
        setAffairTitle("QO013", getButtons());

        // テーブルモデルを作成し設定する。
        ACTableModelAdapter receiptTable = new ACTableModelAdapter();

        // [ID:0000679][Shin Fujihara] 2012/01/23 edit 日レセ連携機能追加対応
        //IMPORT_NO => SERIAL_IDに変更
        receiptTable
                .setColumns(new String[] { "SERIAL_ID", "IMPORT_FLAG",
                        "BATTING_FLAG",
                        "PATIENT_FAMILY_NAME+'　'+PATIENT_FIRST_NAME",
                        "PATIENT_FAMILY_KANA+'　'+PATIENT_FIRST_KANA",
                        "PATIENT_SEX", "PATIENT_BIRTHDAY", "PATIENT_BIRTHDAY",
                        "PATIENT_ZIP_FIRST+'-'+PATIENT_ZIP_SECOND",
                        "PATIENT_ADDRESS",
                        "PATIENT_TEL_FIRST+'-'+PATIENT_TEL_SECOND+'-'+PATIENT_TEL_THIRD" });
        setReceiptTableModel(receiptTable);
        getPatients().setModel(getReceiptTableModel());
        // ウィンドウタイトルに、取得レコードのKEY : WINDOW_TITLEのVALUEを設定する。
        // 業務ボタンバーのテキストに、取得レコードのKEY : AFFAIR_TITLEのVALUEを設定する。

        // 2008/01/15 [Masahiko Higuchi] add - begin 日レセ連携対応 version 5.3.8
        // コンボの値を設定する。
        VRList versionComboList = new VRArrayList();
        // コードマスタから選択肢の取得
        versionComboList = QkanCommon.getArrayFromMasterCode(
                CODE_RECEIPT_VERSION, "RECEIPT_VERSION_CONTENT");
        // 値の設定
        getReceiptVersionCombo().setModel(versionComboList);
        // 2008/01/15 [Masahiko Higuchi] add - end

        // 通信の設定情報を読込む
        readProperty();
        // 設定復元
        setRestoration();
        // 初期設定
        setNowPage(1);
        // ボタン状態設定
        pageButtonState();
        // ページ数のみ初期設定
        getViewBeginNo().setText("0");
        
        
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin 日レセ連携機能追加対応
        QkanReceiptSoftDBManager.initReceiptAccessSpace(getDBManager());
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end 日レセ連携機能追加対応

    }

    /**
     * 「接続用情報不正チェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean checkConectInfo() throws Exception {
        // ※接続用情報不正チェック
        // dbsサーバーに接続する。（QkanReceiptSoftDBManager)に引数を渡す。
        // 接続時にエラーが発生した場合
        // メッセージを表示する。 ※接続先の設定が不正です。接続先ホストやポート番号を見直してください。
        // 返り値として false を返す。
        return false;
    }

    /**
     * 「通信設定読込み」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void readProperty() throws Exception {
        // ※通信設定読込み処理
        // 設定ファイルが読込めるかチェックする。
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/IP")) {
            // 読込めた場合
            // 接続先ホストを読込み変数 portNo に格納する。
            setIp(ACFrame.getInstance().getProperty("ReceiptAccess/IP"));
        } else {
            // 読込めなかった場合
            // 初期値を設定する。
            setIp("127.0.0.1");
        }
        // 設定ファイルが読込めるかチェックする。
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/DBSVersion")) {
            // 読込めた場合
            // DBSVerを読込み変数 dbsVer に格納する。
            setDbsVer(ACFrame.getInstance().getProperty(
                    "ReceiptAccess/DBSVersion"));
        } else {
            // 読込めなかった場合
            // 初期値を設定する。
            setDbsVer("1.2.5");
        }
        // 設定ファイルが読込めるかチェックする。
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/Port")) {
            // 読込めた場合
            // ポート番号を読込み portNo に格納する。
            setPort(ACFrame.getInstance().getProperty("ReceiptAccess/Port"));
        } else {
            // 読込めなかった場合
            // 初期値を設定する。
            setPort("8013");
        }
        // 設定ファイルが読込めるかチェックする。
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/UserName")) {
            // 読込めた場合
            // ユーザー名を読込み user に格納する。
            setUser(ACFrame.getInstance().getProperty("ReceiptAccess/UserName"));
        } else {
            // 読込めなかった場合
            // 初期値を設定する。
            setUser("ormaster");
        }
        // 設定ファイルが読込めるかチェックする。
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/Password")) {
            // 読込めた場合
            // パスワードを読込み pass に格納する。
            setPass(ACFrame.getInstance().getProperty("ReceiptAccess/Password"));
        } else {
            // 読込めなかった場合
            // 初期値を設定する。
            setPass("ormaster");
        }
        // 設定ファイルが読込めるかチェックする。
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/ToHiragana")) {
            // 読込めた場合
            // パスワードを読込み toHiraganaConvert に格納する。
            setToHiraganaConvert(ACFrame.getInstance().getProperty(
                    "ReceiptAccess/ToHiragana"));
        } else {
            setToHiraganaConvert("");
        }

        // 2008/01/15 [Masahiko Higuchi] add - begin 日レセ連携対応 version 5.3.8
        // 設定ファイルが読込めるかチェックする。
        if (ACFrame.getInstance().hasProperty(
                "ReceiptAccess/ReceiptSoftVersion")) {
            // 読込めた場合
            // パスワードを読込み receiptVersion に格納する。
            setReceiptVersion(ACFrame.getInstance().getProperty(
                    "ReceiptAccess/ReceiptSoftVersion"));
        } else {
            setReceiptVersion(ACCastUtilities
                    .toString(DEFAULT_RECEIPT_VERSION_INDEX));
        }
        // 2008/01/15 [Masahiko Higuchi] add - end

        // [H28.4 要望][Shnobu Hitaka] 2016/02/26 add - begin 介護情報連携対応
        // 設定ファイルが読込めるかチェックする。
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/KaigoHoken")) {
            // 読込めた場合
            // パスワードを読込み toHiraganaConvert に格納する。
            setKaigoHoken(ACFrame.getInstance().getProperty(
                    "ReceiptAccess/KaigoHoken"));
        } else {
        	setKaigoHoken("");
        }
        // [H28.4 要望][Shnobu Hitaka] 2016/02/26 add - end
    }

    /**
     * 「通信設定書き込み」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void saveProperty() throws Exception {
        // ※通信設定書き込み処理
        // 通信設定書き込み
        setPort(getPortNo().getText());
        setIp(getHostName().getText());
        setUser(getUserName().getText());
        setPass(getPassword().getText());
        setDbsVer(getDbsVersion().getText());
        // 2008/01/15 [Masahiko Higuchi] add - begin 日レセ連携対応 version 5.3.8
        setReceiptVersion(ACCastUtilities.toString(getReceiptVersionCombo()
                .getSelectedIndex()));
        // 2008/01/15 [Masahiko Higuchi] add - end

        ACFrame.getInstance().getPropertyXML().setForceValueAt(
                "ReceiptAccess/IP", getIp());
        ACFrame.getInstance().getPropertyXML().setForceValueAt(
                "ReceiptAccess/DBSVersion", getDbsVer());
        ACFrame.getInstance().getPropertyXML().setForceValueAt(
                "ReceiptAccess/Port", getPort());
        ACFrame.getInstance().getPropertyXML().setForceValueAt(
                "ReceiptAccess/UserName", getUser());
        ACFrame.getInstance().getPropertyXML().setForceValueAt(
                "ReceiptAccess/Password", getPass());

        // 2008/01/15 [Masahiko Higuchi] add - begin 日レセ連携対応 version 5.3.8
        ACFrame.getInstance().getPropertyXML().setForceValueAt(
                "ReceiptAccess/ReceiptSoftVersion", getReceiptVersion());
        // 2008/01/15 [Masahiko Higuchi] add - end

        // ひらがな変換がチェックされているか。
        if (getToHiragana().isSelected()) {
            // チェックされている場合
            ACFrame.getInstance().getPropertyXML().setForceValueAt(
                    "ReceiptAccess/ToHiragana", "true");
        } else {
            // チェックされていない場合
            ACFrame.getInstance().getPropertyXML().setForceValueAt(
                    "ReceiptAccess/ToHiragana", "false");
        }
    }

    /**
     * 「重複患者名チェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRList checkSameName(VRList list) throws Exception {
        // ※重複患者名チェック処理
        // 重複患者名チェック
        ACDBManager dbm = getDBManager();
        // 給管鳥テーブルから比較用データを取得します。
        VRList nowPatients = (VRList) dbm
                .executeQuery(getSQL_GET_PATIENT_INFO(null));

        int destEnd = list.size();
        int nowEnd = nowPatients.size();
        for (int i = 0; i < nowEnd; i++) {
            // 給管鳥テーブルデータを1行分取得
            VRMap nowRow = (VRMap) nowPatients.getData(i);
            // 利用者名を取得
            String nowName = QkanCommon.toFullName(VRBindPathParser.get(
                    "PATIENT_FAMILY_NAME", nowRow), VRBindPathParser.get(
                    "PATIENT_FIRST_NAME", nowRow));
            // 比較の差異を防ぐため空白を除去
            nowName = ACTextUtilities.trim(nowName);
            String nowBirth = "";
            Object nowObj = VRBindPathParser.get("PATIENT_BIRTHDAY", nowRow);
            if (nowObj instanceof Date) {
                nowBirth = VRDateParser.format((Date) nowObj, "yyyyMMdd");
            }
            for (int j = 0; j < destEnd; j++) {
                VRMap destRow = (VRMap) list.getData(j);
                String destName = String.valueOf(VRBindPathParser.get("NAME",
                        destRow));
                if (nowName.equals(destName)) {
                    String destBirth = "";
                    Object destObj = VRBindPathParser.get("PATIENT_BIRTHDAY",
                            destRow);
                    if (destObj instanceof Date) {
                        destBirth = VRDateParser.format((Date) destObj,
                                "yyyyMMdd");
                    }
                    if (nowBirth.equals(destBirth)) {
                        VRBindPathParser.set("BATTING_FLAG", destRow, "あり");
                        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - begin 日レセ連携機能追加対応
                        //チェック状態は、データベースに登録されている値を信じる
//                        VRBindPathParser.set("IMPORT_FLAG", destRow,
//                                new Boolean(false));
                        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - end 日レセ連携機能追加対応
                    }
                }
            }
        }
        // 編集を加えたリストを返却
        return list;
    }

    /**
     * 「取り込み患者データ保存処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean doInsert() throws Exception {
        // ※取り込み患者データ取り込み処理
        // 取り込み患者データ取り込み
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin 日レセ連携機能追加対応
        //処理に時間がかかるようになったので、スプラッシュを追加
        ACSplashable splash = ACFrame.getInstance().getFrameEventProcesser().createSplash("日レセデータ");
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end 日レセ連携機能追加対応
        
        ACDBManager dbm = getDBManager();
        
        // [H28.4 要望][Shnobu Hitaka] 2016/02/03 add - begin 介護情報連携対応
        ACDBManager insurerDbm = null;
        setImportMessage("");
        // [H28.4 要望][Shnobu Hitaka] 2016/02/03 add - end
        
        try {
            
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin 日レセ連携機能追加対応
            //一旦、チェック状態を確定
            updateCheckState();
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - end 日レセ連携機能追加対応
            
            // トランザクション開始
            dbm.beginTransaction();

            VRList importPatients = getInsertCheckedRows();
            int end = importPatients.getDataSize();

            // 利用者数ループ処理
            for (int i = 0; i < importPatients.size(); i++) {
                // 1行取得
                VRMap sqlParam = (VRMap) importPatients.getData(i);
                // 不足情報を追加
                VRBindPathParser.set("SHOW_FLAG", sqlParam, new Integer(1));
                VRBindPathParser.set("DELETE_FLAG", sqlParam, new Integer(0));

                // 変換する場合は変換する。
                if ("true".equals(getToHiraganaConvert())) {
                    VRBindPathParser.set("PATIENT_FAMILY_KANA", sqlParam,
                            ACKanaConvert.toHiragana(ACCastUtilities
                                    .toString(sqlParam
                                            .getData("PATIENT_FAMILY_KANA"))));
                    VRBindPathParser.set("PATIENT_FIRST_KANA", sqlParam,
                            ACKanaConvert.toHiragana(ACCastUtilities
                                    .toString(sqlParam
                                            .getData("PATIENT_FIRST_KANA"))));
                }
                // 登録
                dbm.executeUpdate(getSQL_INSERT_PATIENT(sqlParam));
                
                // [H28.4 要望][Shnobu Hitaka] 2016/02/03 add - begin 介護情報連携対応
                if("1".equals(getKaigoHoken())){
	                // 入力チェック後、介護認定情報を登録する。生保単独などの公費情報は登録しない。
	                // 保険者番号:6桁
	                // 被保険者番号:10桁
	                String insurerId = ACCastUtilities.toString(sqlParam.getData("INSURER_ID"));
	                String insuredId = ACCastUtilities.toString(sqlParam.getData("INSURED_ID"));
	                // 要介護状態区分
	                String jotaiCode = ACCastUtilities.toString(sqlParam.getData("JOTAI_CODE"));
	                
	                // 取り込めない患者のログを作成する
	                String msg = "";
	                if (insurerId.length() != 6 && jotaiCode.length() > 0) {
	                	msg = "：保険者番号を６桁にしてください";
	                }
	                if (insuredId.length() != 10 && jotaiCode.length() > 0) {
	                	msg = "：被保険者番号を１０桁にしてください";
	                }
	                if (insurerId.length() == 0 && jotaiCode.length() > 0) {
	                	msg = "：介護認定期間に有効な介護保険情報が存在しません。";
	                }
	                if (msg.length() > 0) {
		                msg = ACCastUtilities.toString(sqlParam.getData("PATIENT_FAMILY_NAME"))
		                	+ ACCastUtilities.toString(sqlParam.getData("PATIENT_FIRST_NAME"))
		                	+ msg
		                	+ ACConstants.LINE_SEPARATOR;
		                setImportMessage(getImportMessage() + msg);
	                }
	                
	                if (insurerId != null && insurerId.length() == 6
	                		&& insuredId != null && insuredId.length() == 10) {
	
	                    // 利用者IDを取得し、sqlParamに格納する。
	                    String strSql = getSQL_GET_NEW_PATIENT_ID(sqlParam);
	                    VRList list = dbm.executeQuery(strSql);
	                    VRMap temp = (VRMap) list.get(0);
	                    VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities.toInt(VRBindPathParser.get(
	                    		"PATIENT_ID", temp)));
	                    
	                    // 保険者の登録有無チェック
	                    strSql = getSQL_GET_INSURER_INFO(sqlParam);
	                    list = dbm.executeQuery(strSql);
	                    if (list.isEmpty()){
	                        String insureName = "日レセ連携仮保険者";
	                        // 保険者マスタから名称を取得する。なければ仮の名称とする。
	                        if (QkanSystemInformation.getInstance().isInsurerMasterDatabese()
	                        	    && insurerDbm == null) {
	                            insurerDbm = new QO002_M_InsurerBridgeFirebirdDBManager();
	                        }
	                        if (insurerDbm != null) {
	                            list = insurerDbm.executeQuery(getSQL_GET_FIND_M_INSURER_INFO(sqlParam));
	                            if (!list.isEmpty()){
	                                temp = (VRMap) list.get(0);
	                                insureName = ACCastUtilities.toString(VRBindPathParser.get("INSURER_NAME", temp));
	                            }
	                        }
	                        // 保険者を新規追加
	                        VRBindPathParser.set("INSURER_NAME", sqlParam, insureName);
	                        dbm.executeUpdate(getSQL_INSERT_INSURER_INFO(sqlParam));
	                    } else {
	                        // 保険者の削除フラグを0に更新
	                        dbm.executeUpdate(getSQL_UPDATE_INSURER_INFO(sqlParam));
	                    }
	                    
	                    // 初期値を設定する。
	                    VRBindPathParser.set("NINTEI_HISTORY_ID", sqlParam, new Integer(1));
	                    VRBindPathParser.set("SYSTEM_INSURE_VALID_START", sqlParam, sqlParam.getData("INSURE_VALID_START"));
	                    VRBindPathParser.set("SYSTEM_INSURE_VALID_END", sqlParam, sqlParam.getData("INSURE_VALID_END"));
	                    // 生保単独の場合は給付率0%とする。
	                    if (QP001SpecialCase.isSeihoOnly(insuredId)) {
	                    	VRBindPathParser.set("INSURE_RATE", sqlParam, new Integer(0));
	                    } else {
	                    	VRBindPathParser.set("INSURE_RATE", sqlParam, new Integer(90));
	                    }
	                    // 厚生労働省規定の区分支給限度額を取得する。
	                    int limitRate = -1;
	                    limitRate = QkanCommon.getOfficialLimitRate(dbm, ACCastUtilities.toDate(sqlParam.getData("INSURE_VALID_START")), 
	                    		new Integer(1), sqlParam.getData("JOTAI_CODE").toString());
	                    if (limitRate > 0) {
	                        VRBindPathParser.set("LIMIT_RATE", sqlParam, limitRate);
	                    }
	                    // 厚生労働省規定の外部利用型給付上限単位数を取得する。
	                    limitRate = QkanCommon.getOfficialLimitRate(dbm, ACCastUtilities.toDate(sqlParam.getData("INSURE_VALID_START")), 
	                    		new Integer(2), sqlParam.getData("JOTAI_CODE").toString());
	                    if (limitRate > 0) {
	                    	VRBindPathParser.set("EXTERNAL_USE_LIMIT", sqlParam, limitRate);
	                    }
	                    
	                    // 介護認定情報を登録する。
	                    strSql = getSQL_INSERT_NINTEI_HISTORY(sqlParam);
	                    dbm.executeUpdate(strSql);
	                }
                }
                // [H28.4 要望][Shnobu Hitaka] 2016/02/03 add - end
            }
            
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin 日レセ連携機能追加対応
            //500件以降も取り込むにチェックがついている場合は、データベースのフラグを未チェックで更新
            if(getAllPageCheck().isSelected()){
                VRMap sqlParam = new VRHashMap();
                sqlParam.put("LOCAL_IP", QkanReceiptSoftDBManager.getLocalIP());
                dbm.executeUpdate(getSQL_UPDATE_RECEPT_INFO_ALL(sqlParam));
            }
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - end 日レセ連携機能追加対応

            dbm.commitTransaction();
            // 処理正常終了
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            // ロールバック
            dbm.rollbackTransaction();
            return false;
        }
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin 日レセ連携機能追加対応
        finally {
            if(splash!=null){
                splash.close();
                splash = null;
            }
        }
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end 日レセ連携機能追加対応

    }

    /**
     * 「取り込み患者取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRList getInsertCheckedRows() throws Exception {
        // ※取り込み患者取得処理
        
        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - begin 日レセ連携機能追加対応
        /*
        // 取り込み患者取得
        VRList rows = new VRArrayList();
        // テーブルから現在の情報を取得する
        Object obj = getReceiptTableModel().getAdaptee();
        if (obj instanceof VRList) {
            // listに変換
            rows = (VRList) obj;
        } else {
            // 変換できない場合は処理終了
            return new VRArrayList();
        }
        int end = rows.size();
        VRList result = new VRArrayList();
        for (int i = 0; i < end; i++) {
            VRMap row = (VRMap) rows.getData(i);
            // テーブルの一行からフラグをチェックする。
            Object objs = row.getData("IMPORT_FLAG");
            if (objs instanceof Boolean) {
                Boolean val = (Boolean) objs;
                if (val.booleanValue()) {
                    result.add(row);
                }
            }
        }
        */
        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - end 日レセ連携機能追加対応
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin 日レセ連携機能追加対応
        VRList result = new VRArrayList();
        VRMap sqlParam = new VRHashMap();
        sqlParam.setData("LOCAL_IP", QkanReceiptSoftDBManager.getLocalIP());
        //500件以降も取り込むにチェックがついている場合は、データベースから登録用のデータを取得する
        if(getAllPageCheck().isSelected()){
            VRList list = getDBManager().executeQuery(getSQL_GET_RECEPT_INFO_ALL_CHECKED(sqlParam));
            result = convertQkanData(list);
            
        //チェックがついていない場合は、表示しているデータのみ処理を行う
        } else {
            VRList list;
            Object obj = getReceiptTableModel().getAdaptee();
            if (obj instanceof VRList) {
                // listに変換
                list = (VRList) obj;
            } else {
                // 変換できない場合は処理終了
                return result;
            }
            
            int count = list.getDataSize();
            for (int i = 0; i < count; i++) {
                VRMap row = (VRMap) list.getData(i);
                // テーブルの一行からフラグをチェックする。
                Object objs = row.getData("IMPORT_FLAG");
                if (objs instanceof Boolean) {
                    Boolean val = (Boolean) objs;
                    if (val.booleanValue()) {
                        result.add(row);
                    }
                }
            }
        }
        
        // 選択されている日レセのバージョンを確認
        // 初期値(4.0.0未満)の場合は、PTNUMは取得できないので処理終了
        if (getReceiptVersionCombo().getSelectedIndex() != DEFAULT_RECEIPT_VERSION_INDEX) {
            return result;
        }
        
        
        //4.0.0以上の場合は、PTNUMを取得する
        QkanReceiptSoftDBManager receiptDbm = null;
        
        try {
            receiptDbm = new QkanReceiptSoftDBManager(getIp(), ACCastUtilities.toInt(getPort()), getUser(), getPass(), getDbsVer());
            
        } catch (Exception e){
            VRLogger.warning("HOSPNUM取得時、日レセ端末との接続に失敗");
            return result;
        }
        
        VRMap findParam = new VRHashMap();
        findParam.put("tbl_ptnum.HOSPNUM", getHospNum());
        
        int count = result.getDataSize();
        for (int i = 0; i < count; i++) {
            VRMap row = (VRMap)result.get(i);
            
            // [Shnobu Hitaka] 2016/02/18 add - begin 1度取得したら取得しない（連続で同じ患者取込の場合を考慮）
            String ptnumGetFlag = ACCastUtilities.toString(row.get("PTNUM_GET_FLAG"), null);
            if (ptnumGetFlag == null || ptnumGetFlag.length() == 0) {
            // [Shnobu Hitaka] 2016/02/18 add - end
            	
	            String patientCode = ACCastUtilities.toString(row.get("PATIENT_CODE"), null);
	            if (patientCode == null || patientCode.length() == 0) {
	                continue;
	            }
	            
	            findParam.put("tbl_ptnum.PTID", patientCode);
	            try {
	                
	                // 通信準備
	                receiptDbm.executeSetUp();
	                Map sqlResult = receiptDbm.executeQueryData("tbl_ptnum", "key", findParam);
	                // トランザクションの終了
	                receiptDbm.commitTransaction();
	                
	                patientCode = ACTextUtilities.trim(ACCastUtilities.toString(sqlResult.get("tbl_ptnum.PTNUM"), ""));
	                row.put("PATIENT_CODE", patientCode);
	                
	                // [Shnobu Hitaka] 2016/02/18 add 1度取得したら取得フラグをON
	                row.put("PTNUM_GET_FLAG", "1");
	                
	            } catch (Exception e) {
	                VRLogger.warning(e);
	            }
	            
	        // [Shnobu Hitaka] 2016/02/18 add - begin
            }
            // [Shnobu Hitaka] 2016/02/18 add - end
            
            // [H28.4 要望][Shnobu Hitaka] 2016/01/20 add - begin 介護情報連携対応
            if("1".equals(getKaigoHoken())){
            	try {
		            VRMap findCareParam = new VRHashMap();
		            String tekstymd = "";
		            String tekedymd = "";
		            Map sqlResult = new VRHashMap();
		            
		            String patientId = ACCastUtilities.toString(row.get("PTID"), null);
		            if (patientId == null || patientId.length() == 0) {
		                continue;
		            }
//	                【TEST】dbsパッケージの定義体（dbs.dbd）には、介護保険・介護認定情報がない。
//	                そのまま接続した場合はエラーとなるので処理を中断する。エラーを無視するとタスクが終了しないので注意。
//	                公費情報でテスト。
//	                findCareParam.clear();
//	                findCareParam.put("tbl_ptkohinf.HOSPNUM", getHospNum());
//	                findCareParam.put("tbl_ptkohinf.PTID", patientId);
//	                findCareParam.put("tbl_ptkohinf.KOHID", "1");
//	                // 通信準備
//	                receiptDbm.executeSetUp();
//	                sqlResult = receiptDbm.executeQueryData("tbl_ptkohinf", "key2", findCareParam);
//	                // トランザクションの終了
//	                receiptDbm.commitTransaction();
	
		            // 介護認定情報取得
		            findCareParam.clear();
		            findCareParam.put("tbl_ptcare_nintei.HOSPNUM", getHospNum());
		            findCareParam.put("tbl_ptcare_nintei.PTID", patientId);
		            
		            // 通信準備
		            receiptDbm.executeSetUp();
		            sqlResult = receiptDbm.executeQueryData("tbl_ptcare_nintei", "key2", findCareParam);
		            // トランザクションの終了
		            receiptDbm.commitTransaction();
		            
		            if ((sqlResult != null) && (sqlResult.size() > 0)) {
		                String val = "";
		                // 摘要開始日TEKSTYMDの取得
		                tekstymd = ACTextUtilities.trim(ACCastUtilities.toString(sqlResult.get("tbl_ptcare_nintei.TEKSTYMD"), ""));
		                row.put("INSURE_VALID_START", ACCastUtilities.toDate(tekstymd));
		                // 摘要終了日TEKEDYMDの取得
		                tekedymd = ACTextUtilities.trim(ACCastUtilities.toString(sqlResult.get("tbl_ptcare_nintei.TEKEDYMD"), ""));
		                row.put("INSURE_VALID_END", ACCastUtilities.toDate(tekedymd));
		                // 要介護状態区分CAREJOTAICDの取得
		                val = ACTextUtilities.trim(ACCastUtilities.toString(sqlResult.get("tbl_ptcare_nintei.CAREJOTAICD"), ""));
		                row.put("JOTAI_CODE", val);
		                // 認定日NINTEIYMDの取得
		                val = ACTextUtilities.trim(ACCastUtilities.toString(sqlResult.get("tbl_ptcare_nintei.NINTEIYMD"), ""));
		                row.put("NINTEI_DATE", ACCastUtilities.toDate(val, null));
		            }
		
		            // 介護保険情報取得（介護認定情報が取得できた場合のみ）
		            if (tekstymd != null && tekstymd.length() > 0) {
		                findCareParam.clear();
		                findCareParam.put("tbl_ptcare_hkninf.HOSPNUM", getHospNum());
		                findCareParam.put("tbl_ptcare_hkninf.PTID", patientId);
		                findCareParam.put("tbl_ptcare_hkninf.TEKSTYMD", tekstymd);
		                findCareParam.put("tbl_ptcare_hkninf.TEKEDYMD", tekedymd);
		                
		                // 通信準備
		                receiptDbm.executeSetUp();
		                sqlResult = receiptDbm.executeQueryData("tbl_ptcare_hkninf", "key1", findCareParam);
		                // トランザクションの終了
		                receiptDbm.commitTransaction();
		                
		                //System.out.println(sqlResult);
		                if ((sqlResult != null) && (sqlResult.size() > 0)) {
			                String val = "";
			                // 保険者番号HKNJANUMの取得
			                val = ACTextUtilities.trim(ACCastUtilities.toString(sqlResult.get("tbl_ptcare_hkninf.HKNJANUM"), ""));
			                row.put("INSURER_ID", val);
			                // 被保険者番号HIHKNJANUMの取得
			                val = ACTextUtilities.trim(ACCastUtilities.toString(sqlResult.get("tbl_ptcare_hkninf.HIHKNJANUM"), ""));
			                row.put("INSURED_ID", val);
		                }
		                
		            }
		            //System.out.println(row);
            	} catch (Exception e) {
                    VRLogger.warning(e);
                    throw e;
                }
            }
            // [H28.4 要望][Shinobu Hitaka] 2016/01/20 add - end 介護情報連携対応
            
        }
        
        try {
            // DBClose
            receiptDbm.close();
            // 念のため明示的に初期化
            receiptDbm = null;
            
        } catch (Exception e) {
            VRLogger.warning(e);
        }
        
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end 日レセ連携機能追加対応
        
        return result;
    }

    /**
     * スプラッシュを閉じる
     */
    public ACSplashable closeSplash(ACSplashable splash) {
        if (splash != null) {
            splash.close();
        }
        return null;
    }

    /**
     * 日レセデータ取得処理
     */
    public void doFind() throws Exception {
        // 通信設定保存処理
        saveProperty();
        // 書き込んでみる
        if (!ACFrame.getInstance().getPropertyXML().writeWithCheck()) {
            // 書き込めなかった場合は処理を終了する。
            return;
        }
        // 通信設定読込み
        readProperty();

        // 2008/01/15 [Masahiko Higuchi] add - begin 日レセ連携対応
        // パスがnullでないか念のためチェックする
        if (getPass() != null) {
            // 空白がパスワードに設定されている場合
            if (getPass().indexOf(" ") != -1 || getPass().indexOf("　") != -1) {
                QkanMessageList.getInstance()
                        .QO013_ERROR_OF_BLANK_IN_PASSWORD();
                // 処理終了
                getPassword().requestFocus();
                return;
            }
        }
        // 2008/01/15 [Masahiko Higuchi] add - end
        
        // 2011/10 [MantisID:0000655] [Shin.Fujihara] Addition - begin
        if (!checkReceiptFindKey()) {
            return;
        }
        // 2011/10 [MantisID:0000655] [Shin.Fujihara] Addition - end

        QkanReceiptSoftDBManager dbm;
        ACSplashable splash = null;

        try {
            // 接続処理をやってみる
            dbm = new QkanReceiptSoftDBManager(getIp(), ACCastUtilities
                    .toInt(getPort()), getUser(), getPass(), getDbsVer());
        } catch (Exception ex) {
            // 接続不正
            QkanMessageList.getInstance().QO013_ERROR_OF_CONECT();
            // 処理終了
            return;
        }

        int count = 0;
        try {

            // 患者取り込みを行うのかチェックする。
            if (QkanMessageList.getInstance().QO013_QUESTION_OF_FIND() == ACMessageBox.RESULT_OK) {
                // OK選択時
                ACFrameEventProcesser processer = ACFrame.getInstance()
                        .getFrameEventProcesser();
                if (processer instanceof QkanFrameEventProcesser) {
                    splash = new ACStopButtonSplash();
                    // アイコン指定
                    ((ACSplash) splash)
                            .setIconPathes(((QkanFrameEventProcesser) processer)
                                    .getSplashFilePathes());

                    // サイズ
                    Dimension d = ((QkanFrameEventProcesser) processer)
                            .getSplashWindowSize();
                    if (d != null) {
                        // スプラッシュサイズ指定
                        d = new Dimension((int) d.getWidth(), (int) d
                                .getHeight() + 20);
                    }

                    ((ACSplash) splash).refreshSize(d);
                    // スプラッシュ表示
                    if (!((ACSplash) splash).isVisible()) {
                        ((ACSplash) splash).showModaless("データ通信");
                    }
                    
                    //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin 日レセ連携機能追加対応
                    VRMap refiners = new VRHashMap();
                    refiners.put("AGE_START", getAgeStartText().getText());
                    refiners.put("AGE_END", getAgeEndText().getText());
                    refiners.put("DEDUPLICATION", new Boolean(getDeduplicationCheck().isSelected()));
                    //[ID:0000679][Shin Fujihara] 2012/01/23 add - end 日レセ連携機能追加対応

                    // 2008/01/15 [Masahiko Higuchi] add - begin 日レセ連携対応
                    // 日医標準レセプトソフトのバージョンを判定する
                    if (getReceiptVersionCombo().getSelectedIndex() != DEFAULT_RECEIPT_VERSION_INDEX) {
                        // 2008/01/15 [Masahiko Higuchi] add - end
                        // ストアドプロシージャ引数 今回はnull
                        VRMap param = null;
                        // opassから結果を取得
                        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - begin 日レセ連携機能追加対応
//                        count = dbm.executeQuery(getDBManager(), "tbl_ptinf",
//                                "all", param, splash);
                        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - end 日レセ連携機能追加対応
                        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin 日レセ連携機能追加対応
                        count = dbm.executeQuery(getDBManager(), "tbl_ptinf",
                                "all", param, splash, refiners);
                        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end 日レセ連携機能追加対応

                        // 2008/01/15 [Masahiko Higuchi] add - begin 日レセ連携対応
                    } else {
                        // HOSPNUM取得用の関数情報定義
                        String key = "key";
                        VRMap initialParam = new VRHashMap();
                        HashMap hospNumResult = new HashMap();
                        initialParam.put("tbl_sysuser.USERID", getUser());
                        // 通信準備
                        dbm.executeSetUp();

                        // 一旦HOSPNUMを取得する。
                        hospNumResult = dbm.executeQueryData("tbl_sysuser",
                                key, initialParam);

                        // COMMIT
                        dbm.commitTransaction();

                        // 患者情報取得用の関数情報定義
                        key = "all";
                        // 変数準備
                        VRMap findParam = new VRHashMap();
                        // HOSPNUMの取得
                        Integer hospNum = ACCastUtilities.toInteger(
                                hospNumResult.get("tbl_sysuser.HOSPNUM"), 0);
                        // 検索キー設定
                        findParam.put("tbl_ptinf.HOSPNUM", hospNum);
                        // 2008/09/18 [Masahiko_Higuchi] add - begin 管理番号の取得仕様を変更
                        // HOSPNUMの保持
                        setHospNum(hospNum);
                        // 2008/09/18 [Masahiko_Higuchi] add - end
                        
                        // 患者情報取得
                        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - begin 日レセ連携機能追加対応
//                        count = dbm.executeQuery(getDBManager(), "tbl_ptinf",
//                                key, findParam, splash);
                        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - end 日レセ連携機能追加対応
                        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin 日レセ連携機能追加対応
                        count = dbm.executeQuery(getDBManager(), "tbl_ptinf",
                                key, findParam, splash, refiners);
                        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end 日レセ連携機能追加対応

                        // 表示している患者の表示番号を取得する。

                        // TODO: 患者の本当の患者番号を取得する。
                        // VRMap sendParam = new VRHashMap();
                        // sendParam.put("tbl_ptnum.HOSPNUM", hospNum);
                        // sendParam.put("tbl_ptnum.PTID", // 取得したPTID);
                        // count = dbm.executeQuery(getDBManager(), "tbl_ptnum",
                        // key, sendParam, splash);

                        // 終了処理
                        dbm.close();

                    }
                    // 2008/01/15 [Masahiko Higuchi] add - end

                }

            } else {
                // キャンセル選択時
                // 処理終了
                return;
            }

        } catch (Exception ex) {
            splash = closeSplash(splash);
            Throwable cause = ex.getCause();
            if (cause instanceof java.net.ConnectException) {
                QkanMessageList.getInstance().QO013_ERROR_OF_CONECT_CUSTOM(
                        "接続", "");
                return;
            } else if (cause instanceof UnknownHostException) {
                // エラーメッセージ表示
                QkanMessageList.getInstance().QO013_ERROR_OF_CONECT_CUSTOM(
                        "接続", "接続先ホストの設定を見直してください。");
                // 処理終了
                return;

            } else if (cause instanceof java.net.SocketException) {
                // エラーメッセージ表示
                QkanMessageList.getInstance().QO013_ERROR_OF_CONECT_CUSTOM(
                        "接続", "通信を切断された可能性あります。再度試行してください。");
                return;

            } else if (ex.getMessage().indexOf("invalid version") >= 0) {
                // エラーメッセージを表示
                QkanMessageList.getInstance()
                        .QO013_ERROR_OF_CONECT_DATA_BASE_VERSION();
                return;

            } else if (ex.getMessage().indexOf("authentication error") >= 0) {
                // エラーメッセージ表示
                QkanMessageList.getInstance().QO013_ERROR_OF_CONECT_CUSTOM(
                        "認証", "ユーザー名およびパスワードが不正です。");
                return;

                // 2008/01/15 [Masahiko_Higuchi] add - begin 日レセ連携 version 3.0.5
            } else if ("Connection reset".equals(ex.getMessage())) {
                // 日レセのバージョン選択にミスの可能性有り
                QkanMessageList
                        .getInstance()
                        .QO013_ERROR_OF_CONECT_CUSTOM(
                                "接続",
                                ACConstants.LINE_SEPARATOR
                                        + "通信の切断、もしくは日医標準レセプトソフトのバージョンが異なる可能性があります。"
                                        + ACConstants.LINE_SEPARATOR
                                        + "接続設定を確認してください。");
                return;
                // 2008/01/15 [Masahiko_Higuchi] add - end

            } else if (cause == null) {
                // エラーメッセージ
                // エラーメッセージ表示
                QkanMessageList.getInstance().QO013_ERROR_OF_CONECT_CUSTOM(
                        "接続", "通信を切断された可能性あります。再度試行してください。");
                return;

            }
            throw ex;
        }

        // 患者情報が取得できなかった場合
        if (count <= 0) {
            splash = closeSplash(splash);
            ACMessageBox.show("患者情報が存在しません。");
            // 画面状態制御
            setState_NOT_CONNECTED();
            // 処理終了
            return;
        } else {
            // 画面状態制御
            setState_CONNECTED();
        }

        // 取得件数表示処理
        setStatusText(count + "件取得しました。");
        getTotalCount().setText(ACCastUtilities.toString(count));
        getViewEndNo().setText(ACCastUtilities.toString(count));
        // ページ数指定
        setNowPage(1);

        // 患者情報を取得する。
        // 初期設定
        setNowPage(1);
        int end = getNowPage() + PAGE_COUNT;
        // テーブル用データを取得する。
        VRList list = getPageData(getNowPage(), end);
        // 結果を格納する。
        getReceiptTableModel().setAdaptee(list);
        // 日レセデータを退避
        setReceiptDataList(list);
        // 画面状態制御
        pageButtonState();
        // スプラッシュを閉じる
        splash = closeSplash(splash);

        // メッセージ表示処理
        QkanMessageList.getInstance().QO013_SUCCESS_PATIENT();
    }

    /**
     * 退避領域から患者情報を取得します。
     */
    public VRList readFromAccessSpace(int begin, int end) throws Exception {

        VRMap sqlParam = new VRHashMap();
        // パラメータ格納
        sqlParam.setData("SERIAL_ID_HOME", ACCastUtilities.toInteger(begin));
        sqlParam.setData("SERIAL_ID_END", ACCastUtilities.toInteger(end));
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin 日レセ連携機能追加対応
        //既存障害対応
        sqlParam.setData("LOCAL_IP", QkanReceiptSoftDBManager.getLocalIP());
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end 日レセ連携機能追加対応
        // 一時領域から指定件数文のデータを取得します。
        VRList list = getDBManager().executeQuery(
                getSQL_GET_RECEPT_INFO(sqlParam));
        // 投げ返す
        return list;
    }

    /**
     * 給管鳥形式のデータに変換する
     */
    public VRList convertQkanData(VRList src) throws Exception {
        if (src == null || src.size() <= 0) {
            // 処理を終了する。
            return new VRArrayList();
        }
        int size = src.size();

        
        boolean encode = false;
        String osName = System.getProperty("os.name");
        // Mac以外であれば文字コード変換を行う。
        if ((osName != null) && (osName.indexOf("Mac") < 0)) {
            encode = true;
        }
        // 患者番号→利用者Cd
        // キーの有無で処理を判断
        VRMap checkRow = (VRMap) src.getData(0);
        if (VRBindPathParser.has("PTID", checkRow)) {
            // 患者ID
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                        .toString(VRBindPathParser.get("PTID", row)));

                if (val.length() > 16) {
                    // 16文字制限
                    val = val.substring(0, 16);
                }
                VRBindPathParser.set("PATIENT_CODE", row, val);
            }
        } else {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                VRBindPathParser.set("PATIENT_CODE", row, "");
            }
        }

        // 患者氏名→利用者氏名
        if (VRBindPathParser.has("NAME", checkRow)) {
            // 氏名
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                        .toString(VRBindPathParser.get("NAME", row)));
                // 全角スペースがあるかをチェック
                int sepPos = val.indexOf("　");
                if (sepPos < 0) {
                    sepPos = val.indexOf(" ");
                }
                if (sepPos >= 0) {
                    String first = "";
                    String family = "";
                    // 半角・全角によって分岐

                    first = val.substring(0, sepPos);
                    family = val.substring(sepPos, val.length());
                    // 姓が16文字以上であれば名に結合する。
                    // 16文字で切る
                    VRBindPathParser.set("PATIENT_FAMILY_NAME", row, first
                            .substring(0, Math.min(16, first.length())));
                    // スペースを取り除く
                    family = ACTextUtilities.trim(family);

                    // 名が16文字以上の場合
                    // 16文字で切る
                    VRBindPathParser.set("PATIENT_FIRST_NAME", row, family
                            .substring(0, Math.min(16, family.length())));

                } else {
                    // 全角・半角スペースがない場合
                    // 文字数が16文字以上である場合
                    if (val.length() > 15) {
                        // 16文字で区切る
                        VRBindPathParser.set("PATIENT_FAMILY_NAME", row, val
                                .substring(0, 16));
                        VRBindPathParser.set("PATIENT_FIRST_NAME", row, val
                                .substring(16, Math.min(31, val.length())));
                    } else {
                        VRBindPathParser.set("PATIENT_FAMILY_NAME", row, val);
                        VRBindPathParser.set("PATIENT_FIRST_NAME", row, "");
                    }
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                // 全て空白を設定
                VRBindPathParser.set("PATIENT_FAMILY_NAME", row, "");
                VRBindPathParser.set("PATIENT_FIRST_NAME", row, "");
            }
        }
        // カナ→かな氏名
        if (VRBindPathParser.has("KANANAME", checkRow)) {
            // かな氏名
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                        .toString(VRBindPathParser.get("KANANAME", row)));
                int sepPos = val.indexOf("　");
                if (sepPos < 0) {
                    sepPos = val.indexOf(" ");
                }
                // 全角スペースがあるかをチェック
                if (sepPos >= 0) {
                    String firstKana = "";
                    String familyKana = "";
                    // 半角・全角によって分岐

                    firstKana = val.substring(0, sepPos);
                    familyKana = val.substring(sepPos, val.length());

                    // 16文字で切る
                    VRBindPathParser.set("PATIENT_FAMILY_KANA", row, firstKana
                            .substring(0, Math.min(16, firstKana.length())));

                    // スペースを取り除く
                    familyKana = ACTextUtilities.trim(familyKana);
                    // 名が16文字以上の場合
                    // 16文字で切る
                    VRBindPathParser.set("PATIENT_FIRST_KANA", row, familyKana
                            .substring(0, Math.min(16, familyKana.length())));

                } else {
                    // 全角・半角スペースがない場合
                    // 文字数が16文字以上である場合
                    if (val.length() > 15) {
                        // 16文字で区切る
                        VRBindPathParser.set("PATIENT_FAMILY_KANA", row, val
                                .substring(0, 16));
                        VRBindPathParser.set("PATIENT_FIRST_KANA", row, val
                                .substring(16, Math.min(31, val.length())));
                    } else {
                        VRBindPathParser.set("PATIENT_FAMILY_KANA", row, val);
                    }
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                // 全て空白を設定
                VRBindPathParser.set("PATIENT_FAMILY_KANA", row, "");
                VRBindPathParser.set("PATIENT_FIRST_KANA", row, "");
            }
        }
        // 性別→性別
        if (VRBindPathParser.has("SEX", checkRow)) {
            // 性別
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                VRBindPathParser.set("PATIENT_SEX", row, Integer
                        .valueOf(ACTextUtilities.toBlankIfNull(ACCastUtilities
                                .toString(VRBindPathParser.get("SEX", row)))));
            }
        } else {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                VRBindPathParser.set("PATIENT_SEX", row, new Integer(0));
            }
        }
        // 年齢
        if (VRBindPathParser.has("BIRTHDAY", checkRow)) {
            // 年齢
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                Object obj = VRBindPathParser.get("BIRTHDAY", row);
                // 解析失敗時はnullを返す。
                Date val = ACCastUtilities.toDate(obj, null);
                // 日付型に変換できるパターン
                if (val != null) {
                    // 設定
                    VRBindPathParser.set("PATIENT_BIRTHDAY", row, val);
                } else {
                    // キャストが無理なら初期値を入れる
                    VRBindPathParser.set("PATIENT_BIRTHDAY", row, "");
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                VRBindPathParser.set("PATIENT_BIRTHDAY", row, "");
            }
        }
        // 郵便番号
        if (VRBindPathParser.has("HOME_POST", checkRow)) {
            // 郵便番号
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                        .toString(VRBindPathParser.get("HOME_POST", row)));
                // 8文字以下であるかチェックする。
                if (val.length() < 8) {
                    if (val.length() >= 3) {
                        // 設定
                        VRBindPathParser.set("PATIENT_ZIP_FIRST", row, val
                                .substring(0, 3));
                        VRBindPathParser.set("PATIENT_ZIP_SECOND", row, val
                                .substring(3, Math.min(7, val.length())));
                    } else {
                        // 3文字以下の場合
                        VRBindPathParser.set("PATIENT_ZIP_FIRST", row, val
                                .substring(0, val.length()));
                        VRBindPathParser.set("PATIENT_ZIP_SECOND", row, "");
                    }
                } else {
                    // 8文字以上の場合
                    VRBindPathParser.set("PATIENT_ZIP_FIRST", row, val
                            .substring(0, 3));
                    VRBindPathParser.set("PATIENT_ZIP_SECOND", row, val
                            .substring(3, Math.min(7, val.length())));
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                VRBindPathParser.set("PATIENT_ZIP_FIRST", row, "");
                VRBindPathParser.set("PATIENT_ZIP_SECOND", row, "");
            }
        }
        // 住所＋番地 → 住所
        if (VRBindPathParser.has("HOME_ADRS", checkRow)) {
            // 住所が入力されているかチェックする。
            if (VRBindPathParser.has("HOME_BANTI", checkRow)) {
                for (int i = 0; i < size; i++) {
                    VRMap row = (VRMap) src.getData(i);
                    // 住所と番地を結合する
                    String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                            .toString(VRBindPathParser.get("HOME_ADRS", row)))
                            + ACTextUtilities.toBlankIfNull(ACCastUtilities
                                    .toString(VRBindPathParser.get(
                                            "HOME_BANTI", row)));
                    // 64文字制限
                    if (val.length() > 64) {
                        val = val.substring(0, 64);
                    }
                    VRBindPathParser.set("PATIENT_ADDRESS", row, val);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    VRMap row = (VRMap) src.getData(i);
                    // 住所のみを設定
                    String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                            .toString(VRBindPathParser.get("HOME_ADRS", row)));
                    // 64文字制限
                    if (val.length() > 64) {
                        val = val.substring(0, 64);
                    }
                    VRBindPathParser.set("PATIENT_ADDRESS", row, val);
                }
            }
        } else if (VRBindPathParser.has("HOME_BANTI", checkRow)) {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                // 番地のみを設定
                String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                        .toString(VRBindPathParser.get("HOME_BANTI", row)));
                // 64文字制限
                if (val.length() > 64) {
                    val = val.substring(0, 64);
                }
                VRBindPathParser.set("PATIENT_ADDRESS", row, val);
            }
        } else {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                VRBindPathParser.set("PATIENT_ADDRESS", row, "");
            }
        }

        if (VRBindPathParser.has("HOME_TEL1", checkRow)) {
            // 電話番号
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                        .toString(VRBindPathParser.get("HOME_TEL1", row)));
                // 数値のみの文字列に置換し返却
                val = toNotTelCharReplace(val);
                String[] tels = val.split("-");
                if ((tels.length <= 0) || ACTextUtilities.isNullText(tels[0])) {
                    // 全て初期化してループをスキップ
                    VRBindPathParser.set("PATIENT_TEL_FIRST", row, "");
                    VRBindPathParser.set("PATIENT_TEL_SECOND", row, "");
                    VRBindPathParser.set("PATIENT_TEL_THIRD", row, "");
                    continue;
                }
                // 文字数の長さが0の場合
                // 分割した文字列1つ目が5文字以上かチェックする。
                if (tels[0].length() > 6) {
                    String[] telSrc;
                    if (tels[0].length() > 10) {
                        // 9文字より多いので2、3と設定
                        telSrc = new String[3];
                        // １つ設定
                        telSrc[0] = tels[0].substring(0, 6);
                        telSrc[1] = tels[0].substring(6, 10);
                        telSrc[2] = tels[0].substring(10, Math.min(14, tels[0]
                                .length()));
                    } else {
                        // 9文字未満は2つめまで
                        telSrc = new String[2];
                        // １つ設定
                        telSrc[0] = tels[0].substring(0, 6);
                        telSrc[1] = tels[0].substring(6, tels[0].length());

                    }
                    tels = telSrc;
                }

                // 整形した文字列から設定
                switch (tels.length) {
                case 1:
                    VRBindPathParser.set("PATIENT_TEL_FIRST", row, tels[0]
                            .substring(0, Math.min(6, tels[0].length())));
                    VRBindPathParser.set("PATIENT_TEL_SECOND", row, "");
                    VRBindPathParser.set("PATIENT_TEL_THIRD", row, "");
                    break;
                case 2:
                    VRBindPathParser.set("PATIENT_TEL_FIRST", row, tels[0]
                            .substring(0, Math.min(6, tels[0].length())));
                    VRBindPathParser.set("PATIENT_TEL_SECOND", row, tels[1]
                            .substring(0, Math.min(4, tels[1].length())));
                    VRBindPathParser.set("PATIENT_TEL_THIRD", row, "");
                    break;
                default:
                    VRBindPathParser.set("PATIENT_TEL_FIRST", row, tels[0]
                            .substring(0, Math.min(6, tels[0].length())));
                    VRBindPathParser.set("PATIENT_TEL_SECOND", row, tels[1]
                            .substring(0, Math.min(4, tels[1].length())));
                    VRBindPathParser.set("PATIENT_TEL_THIRD", row, tels[2]
                            .substring(0, Math.min(4, tels[2].length())));
                    break;
                }

            }

        }

        // 初期値を設定
        for (int i = 0; i < size; i++) {
            VRMap row = (VRMap) src.getData(i);
            //[ID:0000679][Shin Fujihara] 2012/01/23 delete - begin 日レセ連携機能追加対応
            //VRBindPathParser.set("IMPORT_FLAG", row, new Boolean(true));
            //[ID:0000679][Shin Fujihara] 2012/01/23 delete - end 日レセ連携機能追加対応
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin 日レセ連携機能追加対応
            if (ACCastUtilities.toInt(VRBindPathParser.get("CHECKED", row), 0) == 1) {
                VRBindPathParser.set("IMPORT_FLAG", row, new Boolean(true));
            } else {
                VRBindPathParser.set("IMPORT_FLAG", row, new Boolean(false));
            }
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - end 日レセ連携機能追加対応
            
            VRBindPathParser.set("BATTING_FLAG", row, "");
        }

        return src;
    }

    /**
     * 設定復元処理
     */
    public void setRestoration() throws Exception {
        getHostName().setText(getIp());
        getDbsVersion().setText(getDbsVer());
        getPortNo().setText(getPort());
        getUserName().setText(getUser());
        getPassword().setText(getPass());
        // 2008/01/15 [Masahiko Higuchi] add - begin 日レセ連携対応 version 5.3.8
        // 日医標準レセプトソフトバージョン情報コンボを設定する。
        getReceiptVersionCombo().setSelectedIndex(
                ACCastUtilities.toInt(getReceiptVersion(),
                        DEFAULT_RECEIPT_VERSION_INDEX));
        // 2008/01/15 [Masahiko Higuchi] add - end
        // チェックの状態を復元
        if ("true".equals(getToHiraganaConvert())) {
            getToHiragana().setSelected(true);
        } else {
            getToHiragana().setSelected(false);
        }
    }

    /**
     * 数値のみに置換します。
     */
    public String toNotTelCharReplace(String src) throws Exception {
        StringBuilder sb = new StringBuilder();
        int end = src.length();
        for (int i = 0; i < end; i++) {
            char c = src.charAt(i);
            if ((c == '-') || ((c >= '0') && (c <= '9'))) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * ページボタン状態制御
     */
    public void pageButtonState() throws Exception {
        int total = ACCastUtilities.toInt(getTotalCount().getText());
        // 前ページボタンの状態制御
        if (getNowPage() - 1 < 1) {
            // 1ページ目の場合
            setState_INVALID_PREVIEW_PAGE();
            // ページ表示処理
            getViewBeginNo().setText("1");
            getViewEndNo()
                    .setText(ACCastUtilities.toString(PAGE_COUNT) + " 件目");
        } else {
            // 1ページ目以外
            setState_VALID_PREVIEW_PAGE();
            // ページ表示処理
            getViewBeginNo().setText(
                    ACCastUtilities
                            .toString(((getNowPage() - 1) * PAGE_COUNT) + 1));
            getViewEndNo()
                    .setText(
                            ACCastUtilities.toString(getNowPage() * PAGE_COUNT)
                                    + " 件目");
        }

        // 次ページボタンの状態制御
        if (total < getNowPage() * PAGE_COUNT) {
            // 最大ページ
            setState_INVALID_NEXT_PAGE();
            // ページ表示処理
            getViewEndNo().setText(getTotalCount().getText() + " 件目");
            getViewBeginNo().setText(
                    ACCastUtilities
                            .toString(((getNowPage() - 1) * PAGE_COUNT) + 1));
        } else {
            // 最大ページ未満
            setState_VALID_NEXT_PAGE();
            // ページ表示処理
            getViewBeginNo().setText(
                    ACCastUtilities
                            .toString(((getNowPage() - 1) * PAGE_COUNT) + 1));
            getViewEndNo()
                    .setText(
                            ACCastUtilities.toString(getNowPage() * PAGE_COUNT)
                                    + " 件目");
        }
    }

    /**
     * 1ページ分のデータを取得します。
     */
    public VRList getPageData(int begin, int end) throws Exception {
        // 次ページ情報取得
        VRList list = readFromAccessSpace(begin, end);
        // 給管鳥データに変換
        list = convertQkanData(list);
        // 重複チェックを行う。
        list = checkSameName(list);
        // リストを返す
        return list;
    }

    /**
     * 画面のチェック状態を更新します。
     */
    @Override
    public void updateCheckState() throws Exception {
        VRList list;
        Object obj = getReceiptTableModel().getAdaptee();
        if (obj instanceof VRList) {
            // listに変換
            list = (VRList) obj;
        } else {
            // 変換できない場合は処理終了
            return;
        }
        
        //チェックされているシリアルID
        List<Object> checkedList = new ArrayList<Object>();
        //チェックされていないシリアルID
        List<Object> uncheckedList = new ArrayList<Object>();
        
        int count = list.size();
        for (int i = 0; i < count; i++) {
            VRMap row = (VRMap) list.getData(i);
            // テーブルの一行からフラグをチェックする。
            Object objs = row.getData("IMPORT_FLAG");
            if (objs instanceof Boolean) {
                Boolean val = (Boolean) objs;
                if (val.booleanValue()) {
                    checkedList.add(row.getData("SERIAL_ID"));
                } else {
                    uncheckedList.add(row.getData("SERIAL_ID"));
                }
            }
        }
        
        VRMap sqlParam = new VRHashMap();
        sqlParam.setData("LOCAL_IP", QkanReceiptSoftDBManager.getLocalIP());
        
        if (!checkedList.isEmpty()) {
            sqlParam.put("CHECKED", new Integer(1));
            sqlParam.put("SERIAL_ID", checkedList.toArray());
            getDBManager().executeUpdate(getSQL_UPDATE_RECEPT_INFO(sqlParam));
        }
        
        if (!uncheckedList.isEmpty()) {
            sqlParam.put("CHECKED", new Integer(0));
            sqlParam.put("SERIAL_ID", uncheckedList.toArray());
            getDBManager().executeUpdate(getSQL_UPDATE_RECEPT_INFO(sqlParam));
        }
        
    }
    
    /**
     * 検索条件のチェックを行います。
     * 
     * @return
     * @author Masahiko.Higuchi
     * @since 3.1.5
     * @throws Exception
     */
    public boolean checkReceiptFindKey() throws Exception {

        String ageStartString = getAgeStartText().getText();
        String ageEndString = getAgeEndText().getText();
        int ageStart = ACCastUtilities.toInt(ageStartString, 0);
        int ageEnd = ACCastUtilities.toInt(ageEndString, 0);

        if (!"".equals(ageStartString) && !"".equals(ageEndString)) {
            if (ageStart > ageEnd) {
                ACMessageBox.showExclamation("年齢の開始と終了の入力が逆転しています。");
                getAgeStartText().transferFocus();
                return false;
            }
        }

        return true;
    }
}
