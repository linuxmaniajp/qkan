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
 * 作成日: 2005/12/20  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他 (O)
 * プロセス 設定変更・メンテナンス (005)
 * プログラム 設定変更・メンテナンス (QO005)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo005;

import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.filechooser.ACFileChooser;
import jp.nichicom.ac.filechooser.ACFileFilter;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.bridge.sql.BridgeFirebirdDBManager;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 設定変更・メンテナンス(QO005)
 */
public class QO005 extends QO005Event {
    /**
     * コンストラクタです。
     */
    public QO005() {
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
        // Mac OSだったらPDF設定コンテナを表示しない
        final String osName = String.valueOf(System.getProperty("os.name"))
                .toLowerCase();
        if (osName.indexOf("mac") >= 0) {
            getPdfFileSelects().setVisible(false);
        }

        // スナップショットの撮影対象を指定する。
        getSnapshot().setRootContainer(getContents());
        // 設定ファイルから、設定情報を取得する。

        // loadSettingFile();
        doLoad();

        // 画面の「IP(serverSelectIpText)」の状態を初期化する。
        setServerSelectIpTextState();

        // 過去の事業所体制は一度非表示に
        getShowOldLowProviderElements().setVisible(false);
        
        // 画面の値の初期化を行う。
        setInitValue();

    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // ※終了処理
        // ※スナップショットチェック
        // スナップショットの更新チェックを行う。
        if (getSnapshot().isModified()) {
            // 更新されていない場合
            // システムを終了する。
            return true;
        }
        // 更新されている場合
        // 処理を継続する。
        // ※保存確認
        // 保存確認のメッセージを表示する。※メッセージID = WARNING_OF_CLOSE_ON_MODIFIED
        QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED();
        boolean loopFlg = false;

        do {
            // 「OK」選択時
            // 処理を継続する。
            if (QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED() == SELECT_OK) {
                // 「キャンセル」選択時
                // 処理を中断する。
                return true;
            }
            // ※保存処理
            // 保存処理を行う。
            if (doSave()) {

                // 保存処理が正常終了した場合
                // システムを終了する。
                return true;
            } else {
                // 保存処理が異常終了した場合
                // 処理を中断する。
                return false;
            }
        } while (loopFlg);
    }

    // コンポーネントイベント

    /**
     * 「設定ファイルの更新」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {
        // ※保存処理
        // 設定情報の保存処理を行う。
        if (doSave()) {
            QkanMessageList.getInstance().UPDATE_SUCCESSED();
            setUpdateSuccessed(true);
        }
    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        if (getUpdateSuccessed()) {
            // 更新した場合はメインメニューではなくログイン画面へ遷移させる
            List history = ACFrame.getInstance().getTraceAffairs();
            if (history != null) {
                int size = history.size();
                if (size > 2) {
                    // 直前の画面（メインメニュー）をなかったことにする
                    ACFrame.getInstance().getTraceAffairs().remove(size - 2);
                }
            }
            QkanMessageList.getInstance().QO005_AUTO_LOGOUT();
        }
        return true;
    }

    /**
     * 「画面の状態設定」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void serverSelectRadiosActionPerformed(ActionEvent e)
            throws Exception {
        // ※画面の状態設定
        // 画面の「IP(serverSelectIpText)」の状態を設定する。
        setServerSelectIpTextState();
    }

    /**
     * 「DBファイル参照」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void dbFileSelectFileCompareButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ※ファイル選択処理
        ACFileChooser DBfileChooser = new ACFileChooser();
        ACFileFilter DBFilefilter = new ACFileFilter();
        DBFilefilter.setFileExtensions(new String[] { "fdb" });
        DBFilefilter.setDescription("データベースファイル(*.fdb)");

        // ファイル選択ダイアログを開く。
        File selectFile = null;
        String defaultPath = "";
        if (ACFrame.getInstance().hasProperty("DBConfig/Path")) {
            defaultPath = (new File(getProperty("DBConfig/Path")).getParent());
        } else {
            defaultPath = (new File(".").getAbsolutePath());
        }
        selectFile = DBfileChooser.showOpenDialog(defaultPath, "",
                "使用するデータベースファイルを指定して下さい。", DBFilefilter.getFileExtensions(),
                DBFilefilter.getDescription());

        // キャンセル時は中断
        if (selectFile == null) {
            return;
        }

        // 取得したファイルから拡張子を補完する
        selectFile = new File(selectFile.getParent(),
                getFBFilePathWithExtension(selectFile.getName(), 1,
                        FB_FILE_EXTENSIONS));

        // ファイル存在チェック
        if (!selectFile.exists()) {
            QkanMessageList.getInstance().QO005_ERROR_OF_NOT_A_DATABASE();
            return;

        }

        // 許可文字コード
        if (!VRCharType.ONLY_HALF_CHAR.isMatch(String.valueOf(String
                .valueOf(selectFile)))) {
            getDbFileSelectFileName().requestFocus();
            QkanMessageList.getInstance()
                    .QO005_ERROR_OF_DBPATH_INCLUDE_JAPANESE_CHAR();
            return;
        }

        // ファイルが選択された場合
        // 選択されたファイル名を、画面の「ファイル名(dbFileSelectFileName)」に設定する。
        if (selectFile.exists()) {
            getDbFileSelectFileName().setText(String.valueOf(selectFile));
            return;
        }

        // ファイルが選択されなかった場合
        // 何もしない。
    }

    /**
     * 「FDBファイルバックアップ」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void backupActionPerformed(ActionEvent e) throws Exception {
        // ※FDBファイルのバックアップ
        if (ACTextUtilities.isNullText(getDbFileSelectFileName().getText())) {
            QkanMessageList.getInstance().QO005_ERROR_OF_EMPTY_DBFILE_PATH();
            return;
        }
        // プロパティファイルパスと画面のファイルパス同一性チェック
        File properityPath = null;
        if (ACFrame.getInstance().hasProperty("DBConfig/Path")) {
            properityPath = new File(getProperty("DBConfig/Path"));
        }

        File displayPath = new File(getDbFileSelectFileName().getText());
        if (!displayPath.equals(properityPath)) {
            QkanMessageList.getInstance()
                    .QO005_ERROR_OF_NOT_SAME_PROPERTY_DBPATH();
            return;
        }

        // ※DBサーバ端末チェック
        // 画面の「サーバ種類(serverSelectRadios)」の値をチェックする。
        if (getServerSelectRadios().getSelectedIndex() == SERVER_RADIO_LOCAL) {
            // 1(ローカル)の場合
            // 処理を継続する。
        } else if (getServerSelectRadios().getSelectedIndex() == SERVER_RADIO_REMOTE) {
            // 2(他のコンピュータ)の場合
            // エラーメッセージを表示する。 ID = QO005_ERROR_OF_USER_OTHER_COMPUTER
            // 処理を中断する。
            QkanMessageList.getInstance().QO005_ERROR_OF_USER_OTHER_COMPUTER();
            return;
        }

        // MEMO loopFlgがtrueである限りLOOP
        // ※ファイル選択ダイアログ
        ACFileChooser DBfileChooser = new ACFileChooser();
        ACFileFilter DBFilefilter = new ACFileFilter();
        DBFilefilter.setFileExtensions(new String[] { "old", "fdb" });
        DBFilefilter.setDescription("データベースファイル(*.old|*.fdb)");

        // ※準備
        // 退避先FDBファイルパス保存用の変数 backupPath を定義する。(文字列)
        String backupPath = new File(getProperty("DBConfig/Path")).getParent()
                + FILE_SEPARATOR + "QKANOLD.FDB";
        File saveFile = null;

        // ※ファイル選択処理
        // ファイル選択ダイアログ(保存)を表示する。
        saveFile = DBfileChooser
                .showSaveDialog(
                        new File(getProperty("DBConfig/Path")).getParent(),
                        getDefaultFileName("old"),
                        "データベースファイルの保存場所と退避ファイル名を指定して下さい。",
                        DBFilefilter.getFileExtensions(),
                        DBFilefilter.getDescription());

        if (!(saveFile == null)) {

            // ファイルが選択された場合
            // 取得したファイルから拡張子を補完する
            saveFile = new File(saveFile.getParent(),
                    getFBFilePathWithExtension(saveFile.getName(), 1,
                            FB_FILE_EXTENSIONS));

            // backupPathに、選択されたファイルのパスを格納する。
            // 処理を継続する。
            backupPath = String.valueOf(saveFile);

        } else {
            // ファイルが選択されなかった場合
            // 処理を中断する。
            return;
        }

        // ※指定された退避先チェック
        // backupPathをチェックする。
        if (backupPath.equals(getProperty("DBConfig/Path"))) {
            // 現在使用中のFDBファイルを選択した場合
            // エラーメッセージを表示する。 ID = QO005_ERROR_OF_BACKUP_SAME_TO_USED
            QkanMessageList.getInstance().QO005_ERROR_OF_BACKUP_SAME_TO_USED();
            // 「※ファイル選択ダイアログ」に戻る。(№9)
            return;
        }

        // 現在使用中以外のFDBファイルを選択した場合
        // 処理を継続する。
        // ※退避先ファイル名チェック
        // 指定された退避先ファイルが既に存在しているかどうかチェックする。
        if (saveFile.exists()) {
            // 存在する場合
            // ※上書確認
            // 上書確認メッセージを表示する。 ID = QO005_QUESTION_OF_EXIST_SELECTED_FDB

            if (QkanMessageList.getInstance()
                    .QO005_QUESTION_OF_EXIST_SELECTED_FDB() == SELECT_CANCEL) {
                // 「キャンセル」選択時
                // 「※ファイル選択ダイアログ」に戻る。(№9)
                return;
            }
            // 処理を継続する。
        }

        // ※開始確認
        // 退避処理開始確認メッセージを表示する。 ID = QO005_QUESTION_OF_TO_START_BACKUP
        if (QkanMessageList.getInstance().QO005_QUESTION_OF_TO_START_BACKUP() == SELECT_CANCEL) {
            // 「キャンセル」選択時
            // 処理を中断する。
            return;
        }

        // 「OK」選択時
        // 処理を継続する。
        // 正常終了した場合
        // 正常終了通知メッセージを表示する。 ID = QO005_BACKUP_SUCCESSED
        try {
            fileCpy(getProperty("DBConfig/Path"), String.valueOf(saveFile));
            QkanMessageList.getInstance().QO005_BACKUP_SUCCESSED();
        } catch (Exception ex) {
            // ※エラートラップ
            // 上記バックアップ処理でエラーが発生した場合
            // エラー発生通知メッセージを表示する。 ID = QO005_BACKUP_FAILED
            QkanMessageList.getInstance().QO005_BACKUP_FAILED();
        }

    }

    /**
     * 「FDBファイルリストア」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void restoreActionPerformed(ActionEvent e) throws Exception {
        // ※FDBファイルのリストア
        // ※準備
        // 復元元のFDBファイルパス保存用の変数 restorePath を定義する。(文字列)
        String restorePath = null;
        // 現行のFDBファイルの退避先パス保存用の変数 backupPath を定義する。(文字列)
        String backupPath = null;
        // 復元元のFDBの接続チェックを行う為に一度退避する、退避先ファイルパス(文字列)
        String checkPath = null;

        // ※DBサーバ端末チェック
        // 画面の「サーバ種類(serverSelectRadios)」の値をチェックする。
        // 1(ローカル)の場合
        // 処理を継続する。
        if (getServerSelectRadios().getSelectedIndex() == SERVER_RADIO_REMOTE) {
            // 2(他のコンピュータ)の場合
            // エラーメッセージを表示する。 ID = QO005_ERROR_OF_USER_OTHER_COMPUTER
            QkanMessageList.getInstance().QO005_ERROR_OF_USER_OTHER_COMPUTER();
            // 処理を中断する。
            return;
        }

        if (ACTextUtilities.isNullText(getDbFileSelectFileName().getText())) {
            QkanMessageList.getInstance().QO005_ERROR_OF_EMPTY_DBFILE_PATH();
            return;
        }
        // プロパティファイルパスと画面のファイルパス同一性チェック
        File properityPath = null;
        if (ACFrame.getInstance().hasProperty("DBConfig/Path")) {
            properityPath = new File(getProperty("DBConfig/Path"));
        }

        File displayPath = new File(getDbFileSelectFileName().getText());
        if (!displayPath.equals(properityPath)) {
            QkanMessageList.getInstance()
                    .QO005_ERROR_OF_NOT_SAME_PROPERTY_DBPATH();
            return;
        }

        // ※ファイル選択ダイアログ
        ACFileChooser DBfileChooser = new ACFileChooser();
        ACFileFilter DBFilefilter = new ACFileFilter();
        DBFilefilter.setFileExtensions(new String[] { "old", "fdb" });
        DBFilefilter.setDescription("データベースファイル(*.old|*.fdb)");
        File restoreFile = null;
        // ※ファイル選択処理
        // ファイル選択ダイアログ(開く)を表示する。
        restoreFile = DBfileChooser.showOpenDialog(new File(
                getProperty("DBConfig/Path")).getParent(), "",
                "退避したデータベースファイルを指定して下さい。", DBFilefilter.getFileExtensions(),
                DBFilefilter.getDescription());

        if (!(restoreFile == null)) {

            // ファイルが選択された場合
            // 取得したファイルから拡張子を補完する
            restoreFile = new File(restoreFile.getParent(),
                    getFBFilePathWithExtension(restoreFile.getName(), 1,
                            FB_FILE_EXTENSIONS));

            // restorePathに、選択されたファイルのパスを格納する。
            // 処理を継続する。
            restorePath = String.valueOf(restoreFile);

        } else {
            // ファイルが選択されなかった場合
            // 処理を中断する。
            return;
        }

        // ※指定された退避先チェック(現行FDBとの同一チェック)
        // restorePathをチェックする。
        if (restorePath.equals(getProperty("DBConfig/Path"))) {
            // 現在使用中のFDBファイルを選択した場合
            // エラーメッセージを表示する。 ID = QO005_ERROR_OF_BACKUP_SAME_TO_RESTORE
            QkanMessageList.getInstance()
                    .QO005_ERROR_OF_BACKUP_SAME_TO_RESTORE();
            // 「※ファイル選択ダイアログ」に戻る。(№12)
            return;
        }

        // DB接続をチェックする為にレストアファイルをテンポラリ領域にコピーしてチェックを行う
        checkPath = new File(getProperty("DBConfig/Path")).getParent()
                + FILE_SEPARATOR + "QKANCHECK.FDB";
        try {
            fileCpy(restorePath, checkPath);
        } catch (Exception ex) {
            // ※エラートラップ
            // 上記リストア処理でエラーが発生した場合
            // エラー発生通知メッセージを表示する。 ID = QO005_RESTORE_FAILED
            QkanMessageList.getInstance()
                    .QO005_ERROR_OF_COPY_DBFILE_TEMP_FAILED();
            return;
        }

        // チェック先パスに対して疑似的にプロパティファイルを模したmapを作成する。
        VRMap checkParams = new VRHashMap();
        // 格納対象はDBのファイルパスとローカル、リモート判別のラジオのみで、他はメソッド内部でプロパティファイルから取ってくる
        checkParams.setData("DB_FILE_SELECT_FILE_NAME", checkPath);
        checkParams.setData("SERVER_SELECT_RADIOS", new Integer(
                SERVER_RADIO_LOCAL));
        
        switch(checkDBConnect(checkParams)) {
        case DB_CONNECT_ERROR:
            // 接続チェックで接続できなかった場合
            QkanMessageList.getInstance().QO005_ERROR_OF_NOT_FIREBIRD_DB();
            return;
        case DB_SCHEMA_ERROR:
            //スキーマバージョンが古い場合
            QkanMessageList.getInstance().QO005_ERROR_OF_SCHEMA_VERSION();
            return;
        }

        try {
            // テンポラリファイルの削除
            new File(checkPath).delete();
        } catch (Exception ex) {
            // ※エラートラップ
            // テンポラリファイルの削除でエラーが発生した場合
            // エラー発生通知メッセージを表示する。 ID = QO005_ERROR_OF_COPY_DBFILE_TEMP_FAILED
            QkanMessageList.getInstance()
                    .QO005_ERROR_OF_DELETE_DBFILE_TEMP_FAILED();
            return;
        }

        // ※現行DB退避確認
        // backupPathに (現在のFDBファイルのフォルダ) + "qkanold.fdb"を格納する。
        //
        backupPath = new File(getProperty("DBConfig/Path")).getParent()
                + FILE_SEPARATOR + "QKANOLD.FDB";
        File backupFile = new File(backupPath);

        // でも、リストア元が実はQKANOLD.FDBだったなんて場合
        if (backupFile.equals(restoreFile)) {
            // バックアップする為のファイルはOLD2とか変えてみる
            backupPath = new File(getProperty("DBConfig/Path")).getParent()
                    + FILE_SEPARATOR + "QKANOLD2.FDB";
            backupFile = new File(backupPath);
        }

        // 現行DB退避確認メッセージを表示する。 ID = QO005_QUESTION_OF_BACKUP_FILENAME
        // 「OK」を選択した場合
        // 処理を継続する。
        if (QkanMessageList.getInstance().QO005_QUESTION_OF_BACKUP_FILENAME(
                restorePath, backupFile.getAbsolutePath()) == SELECT_CANCEL) {
            // 「キャンセル」を選択した場合
            // 処理を中断する。
            return;
        }

        if (backupFile.exists()) {
            // 存在する場合
            // 「※上書確認」へ。(№44)
            // 存在しない場合
            // 「※開始確認」へ。(№71)
            // ※上書確認
            // 上書確認メッセージを表示する。ID = QO005_QUESTION_OF_EXIST_SELECTED_FDB
            if (QkanMessageList.getInstance()
                    .QO005_QUESTION_OF_EXIST_SELECTED_FDB() == SELECT_CANCEL) {
                // 「OK」選択時
                // 「※開始確認」へ。(№71)
                // 「キャンセル」選択時
                // 「※退避先ファイル選択ダイアログ」へ。(№50)

                // ※退避先ファイル選択ダイアログ
                ACFileChooser backupFileChooser = new ACFileChooser();
                ACFileFilter backupFilefilter = new ACFileFilter();
                backupFilefilter.setFileExtensions(new String[] { "fdb" });
                backupFilefilter.setDescription("データベースファイル(*.fdb)");
                // ファイル選択ダイアログ(保存)を表示する。
                backupFile = backupFileChooser.showSaveDialog(new File(
                        getProperty("DBConfig/Path")).getParent(), "",
                        "データベースファイルの保存場所と退避ファイル名を指定して下さい。", DBFilefilter
                                .getFileExtensions(), DBFilefilter
                                .getDescription());

                if (!(backupFile == null)) {

                    // ファイルが選択された場合
                    // 取得したファイルから拡張子を補完する
                    backupFile = new File(backupFile.getParent(),
                            getFBFilePathWithExtension(backupFile.getName(), 1,
                                    FB_FILE_EXTENSIONS));

                    // backupPathに、選択されたファイルのパスを格納する。
                    // 処理を継続する。
                    backupPath = String.valueOf(backupFile);

                } else {
                    // ファイルが選択されなかった場合
                    // 処理を中断する。
                    return;
                }

                // ※退避先ファイルチェック(現行ファイルと同一でないか)
                // backupPathをチェックする。
                if (backupPath.equals(getProperty("DBConfig/Path"))) {
                    // 現在使用中のFDBファイルを選択した場合
                    // エラーメッセージを表示する。 ID =
                    // QO005_ERROR_OF_BACKUP_SAME_TO_USED
                    QkanMessageList.getInstance()
                            .QO005_ERROR_OF_BACKUP_SAME_TO_USED();
                    // 「※退避先ファイル選択ダイアログ」へ戻る。(№50)
                    return;
                }

                // 現在使用中以外のFDBファイルを選択した場合
                // 処理を継続する。
                if (backupPath.equals(restorePath)) {
                    // ※退避先ファイル名(復元元ファイルと同一でないか)
                    // backupPathをチェックする。
                    // 退避先ファイル名と同一の場合
                    // エラーメッセージを表示する。 ID =
                    // QO005_ERROR_OF_BACKUP_SAME_TO_RESTORE
                    QkanMessageList.getInstance()
                            .QO005_ERROR_OF_BACKUP_SAME_TO_RESTORE();
                    // 「※退避先ファイル選択ダイアログ」へ戻る。(№50)
                    return;
                }
                // 退避先ファイル名と異なる場合
                // 「※開始確認」へ。(№71)
            }
        }

        // ※開始確認
        // 処理開始確認メッセージを表示する。ID = QO005_QUESTION_OF_TO_START_RESTORE
        if (QkanMessageList.getInstance().QO005_QUESTION_OF_TO_START_RESTORE() == SELECT_CANCEL) {
            // 「OK」選択時
            // 処理を継続する。
            // 「キャンセル」選択時
            // 処理を中断する。
            return;
        }

        // ※リストア処理
        try {
            // プールしているコネクションを強制的に開放する。
            BridgeFirebirdDBManager dbm = new BridgeFirebirdDBManager();
            if (dbm.isAvailableDBConnection()) {
                dbm.releaseAll();
            } else {
                dbm.releaseAll();
            }

            // 現行FDBをbackupPathにコピー(上書)する。
            fileCpy(getProperty("DBConfig/Path"), backupPath);

        } catch (Exception ex) {
            // ※エラートラップ
            // 上記リストア処理でエラーが発生した場合
            // エラー発生通知メッセージを表示する。 ID = QO005_RESTORE_FAILED
            // データベースの接続開放処理もしくは現行DBの退避に失敗しました。
            QkanMessageList.getInstance().QO005_RESTORE_FAILED_COPY();
            return;
        }

        try {
            // restorePathのFDBファイルを現行FDBに上書する。
            fileCpy(restorePath, getProperty("DBConfig/Path"));

            // 正常終了した場合
            // 税率を再設定する。
            checkTax();

            // 正常終了通知メッセージを表示する。 ID = QO005_RESTORE_SUCCESSED
            QkanMessageList.getInstance().QO005_RESTORE_SUCCESSED();

            setUpdateSuccessed(true);
        } catch (Exception ex) {
            // ※エラートラップ
            // 上記リストア処理でエラーが発生した場合
            // エラー発生通知メッセージを表示する。 ID = QO005_RESTORE_FAILED
            // 復元用DBのファイル移動に失敗しました。
            QkanMessageList.getInstance().QO005_RESTORE_FAILED_FILEIO();
            return;
        }

    }

    /**
     * 「PDFファイル参照」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void pdfFileSelectFileCompareButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ※ファイル選択処理
        ACFileChooser pdffileChooser = new ACFileChooser();
        ACFileFilter pdfFilefilter = new ACFileFilter();
        pdfFilefilter.setFileExtensions(new String[] { "exe" });
        pdfFilefilter.setDescription("PDFビュアープログラム(*.exe)");

        File pdfViewerExecuteFile = null;

        // ファイル選択ダイアログを開く。
        pdfViewerExecuteFile = pdffileChooser.showOpenDialog(
                "使用するPDFファイル閲覧プログラムを指定してください。",
                pdfFilefilter.getFileExtensions(),
                pdfFilefilter.getDescription());

        // キャンセル時は中断
        if (pdfViewerExecuteFile == null) {
            return;
        }

        // 取得したファイルから拡張子を補完する
        pdfViewerExecuteFile = new File(pdfViewerExecuteFile.getParent(),
                getPDFFilePathWithExtension(pdfViewerExecuteFile.getName(), 0,
                        PDF_FILE_EXTENSIONS));

        // ファイル存在チェック
        if (!pdfViewerExecuteFile.exists()) {
            QkanMessageList.getInstance().QO005_ERROR_OF_NOT_EXECUTE_FILE();
            return;
        }

        // ファイルが選択された場合
        // 選択されたファイル名を、画面の「ファイル名(pdfFileSelectFileName)」に設定する。
        if (pdfViewerExecuteFile.exists()) {
            getPdfFileSelectFileName().setText(pdfViewerExecuteFile.toString());
            return;
        }
        // ファイルが選択されなかった場合
        // 何もしない。
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        ACFrame.debugStart(new ACAffairInfo(QO005.class.getName()));
    }

    // 内部関数

    /**
     * 「状態の切替」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void setServerSelectIpTextState() throws Exception {
        // ※状態を切り替える
        // 画面の「サーバ種類(serverSelectRadios)」の値をチェックする。

        if (getServerSelectRadios().getSelectedIndex() == SERVER_RADIO_LOCAL) {
            // 1(ローカル)の場合
            // 画面の「IP(serverSelectIpText)」を無効にする。
            setState_SERVER_TYPE_LOCAL();
        } else if (getServerSelectRadios().getSelectedIndex() == SERVER_RADIO_REMOTE) {
            // 2(他のコンピュータ)の場合
            // 画面の「IP(serverSelectIpText)」を有効にする。
            setState_SERVER_TYPE_OTHER();
        }
    }

    /**
     * 「設定情報取込処理」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void doLoad() throws Exception {
        // ※設定情報を設定ファイルから読み込み、画面に展開する
        // 設定情報格納用レコード settings を生成する。
        VRMap settings = new VRHashMap();
        // 設定ファイルから情報を取得し、settingsに格納する。
        settings = loadSettingFile();
        // contentsのバインドソースとしてsettingsを指定する。
        getContents().setSource(settings);
        // contentsにsettingsをバインドする(画面項目に値を設定する)。
        getContents().bindSource();
        // ※画面の状態の設定
        // 画面の「IP(serverSelectIpText)」の状態を設定する。
        setServerSelectIpTextState();

        // 税率を再設定する。
        checkTax();
    }

    /**
     * 「設定をファイルから読込」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public VRMap loadSettingFile() throws Exception {
        // ※ファイルから設定を読込
        // 戻り値用レコード params を生成する。
        VRMap params = new VRHashMap();

        // paramsの KEY : DB_FILE_SELECT_FILE_NAME のVALUEに、設定ファイル(XML)の ID :
        // DBConfig/Pathの値を設定する。
        if (ACFrame.getInstance().hasProperty("DBConfig/Path")) {
            params.setData("DB_FILE_SELECT_FILE_NAME",
                    getProperty("DBConfig/Path"));
        } else {
            params.setData("DB_FILE_SELECT_FILE_NAME", new String(
                    "DATABASE_PATH"));
        }
        // 設定ファイルの ID : DBConfig/Server の値をチェックする。
        if (ACFrame.getInstance().hasProperty("DBConfig/Server")) {
            if ("localhost".equals(getProperty("DBConfig/Server"))
                    || "127.0.0.1".equals(getProperty("DBConfig/Server"))) {
                // 「localhost」の場合
                // paramsの KEY : SERVER_SELECT_RADIOS のVALUEに 1 を設定する。
                // paramsの KEY : SERVER_SELECT_IP_TEXT のVALUEに ""(ブランク) を設定する。
                // 「127.0.0.1」の場合
                // paramsの KEY : SERVER_SELECT_RADIOS のVALUEに 1 を設定する。
                // paramsの KEY : SERVER_SELECT_IP_TEXT のVALUEに ""(ブランク) を設定する。
                params.setData("SERVER_SELECT_RADIOS", new Integer(
                        SERVER_RADIO_LOCAL));
                params.setData("SERVER_SELECT_IP_TEXT", new String(""));
            } else {
                // 上記以外の場合
                // paramsの KEY : SERVER_SELECT_RADIOS のVALUEに 2 を設定する。
                params.setData("SERVER_SELECT_RADIOS", new Integer(
                        SERVER_RADIO_REMOTE));
                // paramsの KEY : SERVER_SELECT_IP_TEXT のVALUEに、設定ファイルの ID :
                // DBConfig/Server の値を設定する。
                params.setData("SERVER_SELECT_IP_TEXT",
                        getProperty("DBConfig/Server"));
            }
        } else {
            // デフォルト値の設定を行う
            params.setData("SERVER_SELECT_RADIOS", new Integer(
                    SERVER_RADIO_LOCAL));
            params.setData("SERVER_SELECT_IP_TEXT", "");
        }

        if (ACFrame.getInstance().hasProperty("Acrobat/Path")) {
            // paramsの KEY : PDF_FILE_SELECT_FILE_NAME のVALUEに、設定ファイルの ID :
            // Acrobat/Path の値を設定する。
            params.setData("PDF_FILE_SELECT_FILE_NAME",
                    getProperty("Acrobat/Path"));
        } else {
            params.setData("PDF_FILE_SELECT_FILE_NAME", "PDF_VIEWER_PATH");
        }

        if (ACFrame.getInstance().hasProperty("PrintConfig/YoshikiBango")) {
            // paramsの KEY : YOSHIKI_BANGO のVALUEに、設定ファイルの ID :
            // PrintConfig/yoshikiBango の値を設定する。
            params.setData("YOSHIKI_BANGO",
                    getProperty("PrintConfig/YoshikiBango"));
        } else {
            params.setData("YOSHIKI_BANGO", new Integer(CHECKBOX_ON));
        }

        if (ACFrame.getInstance().hasProperty(
                "PrintConfig/NinchishoTokuteiShisetsu")) {
            // paramsの KEY : NINCHISHO_TOKUTEI_SHISETSU のVALUEに、設定ファイルの ID :
            // PrintConfig/ninchishoTokuteiShisetsu の値を設定する。
            params.setData("NINCHISHO_TOKUTEI_SHISETSU",
                    getProperty("PrintConfig/NinchishoTokuteiShisetsu"));
        } else {
            params.setData("NINCHISHO_TOKUTEI_SHISETSU", new Integer(
                    CHECKBOX_ON));
        }

        if (ACFrame.getInstance().hasProperty("PrintConfig/ShisetsuService")) {
            // paramsの KEY : SHISETSU_SERVICE のVALUEに、設定ファイルの ID :
            // PrintConfig/shisetsuService の値を設定する。
            params.setData("SHISETSU_SERVICE",
                    getProperty("PrintConfig/ShisetsuService"));
        } else {
            params.setData("SHISETSU_SERVICE", new Integer(CHECKBOX_ON));
        }

        if (ACFrame.getInstance().hasProperty("PrintConfig/HomeMedicalAdvice")) {
            // paramsの KEY : PRINT_HOME_MEDICAL_ADVICE のVALUEに、設定ファイルの ID :
            // PrintConfig/HomeMedicalAdvice の値を設定する。
            params.setData("PRINT_HOME_MEDICAL_ADVICE",
                    getProperty("PrintConfig/HomeMedicalAdvice"));
        } else {
            params.setData("PRINT_HOME_MEDICAL_ADVICE", new Integer(
                    CHECKBOX_OFF));
        }

        // [H27.4改正対応][Shinobu Hitaka] 2015/3/10 add - begin
        // 特別地域加算・小規模事業所加算
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrintSpecialArea")) {
            // paramsの KEY : PRINT_SPECIAL_AREA のVALUEに、設定ファイルの ID :
            // PrintConfig/PrintSpecialArea の値を設定する。
            params.setData("PRINT_SPECIAL_AREA",
                    getProperty("PrintConfig/PrintSpecialArea"));
        } else {
            params.setData("PRINT_SPECIAL_AREA", new Integer(
                    CHECKBOX_OFF));
        }
        // 中山間地域等提供加算
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrintChusankanArea")) {
            // paramsの KEY : PRINT_CHUSANKAN_AREA のVALUEに、設定ファイルの ID :
            // PrintConfig/PrintChusankanArea の値を設定する。
            params.setData("PRINT_CHUSANKAN_AREA",
                    getProperty("PrintConfig/PrintChusankanArea"));
        } else {
            params.setData("PRINT_CHUSANKAN_AREA", new Integer(
                    CHECKBOX_OFF));
        }
        // 介護職員処遇改善加算
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrintSyoguKaizen")) {
            // paramsの KEY : PRINT_SYOGU_KAIZEN のVALUEに、設定ファイルの ID :
            // PrintConfig/PrintSyoguKaizen の値を設定する。
            params.setData("PRINT_SYOGU_KAIZEN",
                    getProperty("PrintConfig/PrintSyoguKaizen"));
        } else {
            params.setData("PRINT_SYOGU_KAIZEN", new Integer(
                    CHECKBOX_OFF));
        }
        // [H27.4改正対応][Shinobu Hitaka] 2015/3/10 add - end

        if (ACFrame.getInstance().hasProperty("PrintConfig/OncePerMonth")) {
            // paramsの KEY : ONCE_PER_MONTH のVALUEに、設定ファイルの ID :
            // PrintConfig/oncePerMonth の値を設定する。
            params.setData("ONCE_PER_MONTH",
                    getProperty("PrintConfig/OncePerMonth"));
        } else {
            params.setData("ONCE_PER_MONTH", new Integer(CHECKBOX_ON));
        }
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrivateExpenses")) {
            // paramsの KEY : PRIVATE_EXPENSES のVALUEに、設定ファイルの ID :
            // PrintConfig/privateExpenses の値を設定する。
            params.setData("PRIVATE_EXPENSES",
                    getProperty("PrintConfig/PrivateExpenses"));
        } else {
            params.setData("PRIVATE_EXPENSES", new Integer(CHECKBOX_OFF));
        }

        // 2009/02/25 [ID:0000440][Tozo TANAKA] add begin - 平成21年4月法改正対応
        // ＜平成21年4月法改正対応＞
        // paramsの KEY : SHOW_OLD_LOW_PROVIDER_ELEMENTSのVALUEに、設定ファイルの
        // ID : ScreenConfig/ShowOldLowProviderElements の値を設定する。
        if (ACFrame.getInstance().hasProperty(
                "ScreenConfig/ShowOldLowProviderElements")) {
            // paramsの KEY : SHOW_OLD_IRYO のVALUEに、設定ファイルの ID :
            params.setData("SHOW_OLD_LOW_PROVIDER_ELEMENTS",
                    getProperty("ScreenConfig/ShowOldLowProviderElements"));
        } else {
            params.setData("SHOW_OLD_LOW_PROVIDER_ELEMENTS", new Integer(
                    CHECKBOX_OFF));
        }
        // 2009/02/25 [ID:0000440][Tozo TANAKA] add end - 平成21年4月法改正対応

        // [ID:0000449][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
        if (ACFrame.getInstance().hasProperty("PrintConfig/printNursingZero")) {
            // paramsの KEY : PRINT_NURSING_ZERO のVALUEに、設定ファイルの ID :
            // PrintConfig/printNursingZero の値を設定する。
            params.setData("PRINT_NURSING_ZERO",
                    getProperty("PrintConfig/printNursingZero"));
        } else {
            params.setData("PRINT_NURSING_ZERO", new Integer(CHECKBOX_OFF));
        }
        // [ID:0000449][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応

        // [ID:0000651][Shin Fujihara] 2011/07/06 add begin 負担限度額0円表示対応
        if (ACFrame.getInstance().hasProperty(
                "PrintConfig/printNursingLimitZero")) {
            // paramsの KEY : PRINT_NURSING_LIMIT_ZEROのVALUEに、設定ファイルの
            // ID : PrintConfig/printNursingLimitZero の値を設定する。
            params.setData("PRINT_NURSING_LIMIT_ZERO",
                    getProperty("PrintConfig/printNursingLimitZero"));
        } else {
            params.setData("PRINT_NURSING_LIMIT_ZERO",
                    new Integer(CHECKBOX_OFF));
        }
        // [ID:0000651][Shin Fujihara] 2011/07/06 add end 負担限度額0円表示対応

        // [H28.4 要望][Shnobu Hitaka] 2016/02/26 add - begin 介護情報連携対応
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/KaigoHoken")) {
            // paramsの KEY : KAIGO_HOKENのVALUEに、設定ファイルの
            // ID : ReceiptAccess/KaigoHoken の値を設定する。
            params.setData("KAIGO_HOKEN",
                    getProperty("ReceiptAccess/KaigoHoken"));
        } else {
            params.setData("KAIGO_HOKEN", new Integer(CHECKBOX_OFF));
        }
        // [H28.4 要望][Shnobu Hitaka] 2016/02/26 add - end
        
        // 関数の変数として、paramsを返す。
        return params;
    }

    /**
     * 「設定情報保存処理」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public boolean doSave() throws Exception {
        // ※画面の設定情報を、設定ファイルに保存する。
        // 設定情報格納用レコード settings を生成する。
        VRMap settings = new VRHashMap();
        // contentsのバインドソースとしてsettingsを指定する。
        getContents().setSource(settings);
        // 画面の情報をsettingsに格納する。
        getContents().applySource();
        // 設定ファイルに情報を書き込む。
        if (saveSettingFile(settings)) {
            // 税率を再設定する。
            checkTax();
            return true;
        }
        return false;
    }

    /**
     * 「設定をファイルに保存」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public boolean saveSettingFile(VRMap params) throws Exception {

        // 値の事前チェックを行う
        if (checkValue(params)) {
            // ※設定をファイルに保存
            // 設定ファイル(XML)の ID : DBConfig/Path の値に、paramsの KEY :
            // DB_FILE_SELECT_FILE_NAME の VALUE を設定する。
            setProperty("DBConfig/Path",
                    String.valueOf(params.getData("DB_FILE_SELECT_FILE_NAME")));

            // paramsの KEY : DB_FILE_SELECT_FILE_NAME の VALUE をチェックする。
            if (params.getData("SERVER_SELECT_RADIOS").equals(
                    new Integer(SERVER_RADIO_LOCAL))) {
                // 1の場合
                // 設定ファイルの ID : DBConfig/Server の値に、「localhost」を設定する。
                setProperty("DBConfig/Server", "127.0.0.1");
            } else if (params.getData("SERVER_SELECT_RADIOS").equals(
                    new Integer(SERVER_RADIO_REMOTE))) {
                // 2の場合
                // 設定ファイルの ID : DBConfig/Server の値に、paramsの KEY :
                // SERVER_SELECT_IP_TEXT の VALUE を設定する。
                setProperty("DBConfig/Server",
                        String.valueOf(params.getData("SERVER_SELECT_IP_TEXT")));
            }

            // 設定ファイルが空、もしくは編集されていた時の事を考えここで設定しておく
            setProperty("DBConfig/Port", "3050");

            // 設定ファイルの ID : Acrobat/Path の値に、paramsの KEY :
            // PDF_FILE_SELECT_FILE_NAME
            // のVALUEを設定する。
            setProperty("Acrobat/Path",
                    (String) params.getData("PDF_FILE_SELECT_FILE_NAME"));
            // 設定ファイルの ID : PrintConfig/yoshikiBango の値に、paramsの KEY :
            // YOSHIKI_BANGO
            // のVALUEを設定する。
            setProperty("PrintConfig/YoshikiBango",
                    String.valueOf(params.getData("YOSHIKI_BANGO")));
            // 設定ファイルの ID : PrintConfig/ninchishoTokuteiShisetsu の値に、paramsの KEY
            // :
            // NINCHISHO_TOKUTEI_SHISETSU のVALUEを設定する。
            setProperty(
                    "PrintConfig/NinchishoTokuteiShisetsu",
                    String.valueOf(params.getData("NINCHISHO_TOKUTEI_SHISETSU")));
            // 設定ファイルの ID : PrintConfig/shisetsuService の値に、paramsの KEY :
            // SHISETSU_SERVICE のVALUEを設定する。
            setProperty("PrintConfig/ShisetsuService",
                    String.valueOf(params.getData("SHISETSU_SERVICE")));
            // 設定ファイルの ID : PrintConfig/HomeMedicalAdvice の値に、paramsの KEY :
            // PRINT_HOME_MEDICAL_ADVICE のVALUEを設定する。
            setProperty("PrintConfig/HomeMedicalAdvice",
                    String.valueOf(params.getData("PRINT_HOME_MEDICAL_ADVICE")));
            
            // [H27.4改正対応][Shinobu Hitaka] 2015/3/10 add - begin
            // 設定ファイルの ID : PrintConfig/PrintSpecialArea の値に、paramsの KEY :
            // PRINT_SPECIAL_AREA のVALUEを設定する。
            setProperty("PrintConfig/PrintSpecialArea",
                    String.valueOf(params.getData("PRINT_SPECIAL_AREA")));
            // 設定ファイルの ID : PrintConfig/PrintChusankanArea の値に、paramsの KEY :
            // PRINT_CHUSANKAN_AREA のVALUEを設定する。
            setProperty("PrintConfig/PrintChusankanArea",
                    String.valueOf(params.getData("PRINT_CHUSANKAN_AREA")));
            // 設定ファイルの ID : PrintConfig/PrintSyoguKaizen の値に、paramsの KEY :
            // PRINT_SYOGU_KAIZEN のVALUEを設定する。
            setProperty("PrintConfig/PrintSyoguKaizen",
                    String.valueOf(params.getData("PRINT_SYOGU_KAIZEN")));
            // [H27.4改正対応][Shinobu Hitaka] 2015/3/10 add - end
            
            // 設定ファイルの ID : PrintConfig/oncePerMonth の値に、paramsの KEY :
            // ONCE_PER_MONTH のVALUEを設定する。
            setProperty("PrintConfig/OncePerMonth",
                    String.valueOf(params.getData("ONCE_PER_MONTH")));
            // 設定ファイルの ID : PrintConfig/privateExpenses の値に、paramsの KEY :
            // PRIVATE_EXPENSES のVALUEを設定する。
            setProperty("PrintConfig/PrivateExpenses",
                    String.valueOf(params.getData("PRIVATE_EXPENSES")));

            // 2009/02/25 [ID:0000440][Tozo TANAKA] add begin - 平成21年4月法改正対応
            // ＜平成21年4月法改正対応＞
            // 設定ファイルの ID : ScreenConfig/ShowOldLowProviderElements の値に、paramsの
            // KEY : SHOW_OLD_LOW_PROVIDER_ELEMENTS のVALUEを設定する。
            setProperty("ScreenConfig/ShowOldLowProviderElements",
                    String.valueOf(params
                            .getData("SHOW_OLD_LOW_PROVIDER_ELEMENTS")));
            // 2009/02/25 [ID:0000440][Tozo TANAKA] add end - 平成21年4月法改正対応

            // [ID:0000449][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
            // 設定ファイルの ID : ScreenConfig/ShowOldLowProviderElements の値に、paramsの
            // KEY : SHOW_OLD_LOW_PROVIDER_ELEMENTS のVALUEを設定する。
            setProperty("PrintConfig/printNursingZero",
                    String.valueOf(params.getData("PRINT_NURSING_ZERO")));
            // [ID:0000449][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応

            // [ID:0000651][Shin Fujihara] 2011/07/06 add begin 負担限度額0円表示対応
            // 設定ファイルの ID : PrintConfig/printNursingLimitZero の値に、paramsの
            // KEY : PRINT_NURSING_LIMIT_ZERO のVALUEを設定する。
            setProperty("PrintConfig/printNursingLimitZero",
                    String.valueOf(params.getData("PRINT_NURSING_LIMIT_ZERO")));
            // [ID:0000651][Shin Fujihara] 2011/07/06 add end 負担限度額0円表示対応

            // [H28.4 要望][Shnobu Hitaka] 2016/02/26 add - begin 介護情報連携対応
            // 設定ファイルの ID : ReceiptAccess/KaigoHoken の値に、paramsの KEY :
            // KAIGO_HOKEN のVALUEを設定する。
            setProperty("ReceiptAccess/KaigoHoken",
                    String.valueOf(params.getData("KAIGO_HOKEN")));
            // [H28.4 要望][Shnobu Hitaka] 2016/02/26 add - end
            
            saveProperty();

            return true;
        }
        return false;
    }

    /**
     * 「画面初期値の設定」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void setInitValue() throws Exception {
        // ※ウィンドウタイトルの設定
        // 業務情報レコードを取得する。
        // ウィンドウタイトルに、取得レコードのKEY : WINDOW_TITLEのVALUEを設定する。
        // 業務ボタンバーのテキストに、取得レコードのKEY : AFFAIR_TITLEのVALUEを設定する。
        setAffairTitle("QO005", getButtons());
    }

    /**
     * ファイルのコピーを行います。
     * 
     * @param orgFile
     *            コピー元ファイルパス
     * @param newFile
     *            コピー先ファイルパス
     * @throws Exception
     */
    public void fileCpy(String orgFile, String newFile) throws Exception {
        BufferedInputStream input = new BufferedInputStream(
                new FileInputStream(orgFile));
        BufferedOutputStream output = new BufferedOutputStream(
                new FileOutputStream(newFile));
        byte buf[] = new byte[256];
        int len;
        while ((len = input.read(buf)) != -1) {
            output.write(buf, 0, len);
        }
        output.flush();
        output.close();
        input.close();
    }

    /**
     * Firebirdの拡張子付きファイルファイル名を取得します。
     * 
     * @param fileName
     *            ファイル名
     * @param defaultExtension
     *            拡張子が付いていない場合、拡張子候補の何番目の拡張子を付与するか
     * @param extensions
     *            拡張子候補
     * @return 拡張子付きファイル名
     */
    public String getFBFilePathWithExtension(String fileName,
            int defaultExtensionIndex, String[] extensions) {
        if (fileName == null) {
            return "";
        }

        int pos = fileName.lastIndexOf('.'); // 最後のピリオド位置を取得
        if (pos == -1) {
            // 拡張子を追加して返す
            return fileName + "." + extensions[defaultExtensionIndex];
        }

        if ((pos > 0) && (pos < (fileName.length() - 1))) {
            String ext = fileName.substring(pos + 1).toLowerCase(); // 最後のピリオドより後の文字列を小文字で返す
            for (int i = 0; i < FB_FILE_EXTENSIONS.length; i++) {
                if (ext.equals(FB_FILE_EXTENSIONS[i])) {
                    return fileName;
                }
            }
            return fileName + "." + extensions[defaultExtensionIndex];
        } else {
            return "";
        }
    }

    /**
     * Acrobatの拡張子付きファイルファイル名を取得します。
     * 
     * @param fileName
     *            ファイル名
     * @param defaultExtension
     *            拡張子が付いていない場合、拡張子候補の何番目の拡張子を付与するか
     * @param extensions
     *            拡張子候補
     * @return 拡張子付きファイル名
     */
    public String getPDFFilePathWithExtension(String fileName,
            int defaultExtensionIndex, String[] extensions) {
        if (fileName == null) {
            return "";
        }

        int pos = fileName.lastIndexOf('.'); // 最後のピリオド位置を取得
        if (pos == -1) {
            // 拡張子を追加して返す
            return fileName + "." + extensions[defaultExtensionIndex];
        }

        if ((pos > 0) && (pos < (fileName.length() - 1))) {
            String ext = fileName.substring(pos + 1).toLowerCase(); // 最後のピリオドより後の文字列を小文字で返す
            for (int i = 0; i < PDF_FILE_EXTENSIONS.length; i++) {
                if (ext.equals(PDF_FILE_EXTENSIONS[i])) {
                    return fileName;
                }
            }
            return fileName + "." + extensions[defaultExtensionIndex];
        } else {
            return "";
        }
    }

    /**
     * プロパティファイルに格納するデータの事前チェックを行います。
     * 
     * @throws Exception
     *             処理例外
     */
    public boolean checkValue(VRMap params) throws Exception {
        // DBのIPアドレス未入力チェック
        if (params.getData("SERVER_SELECT_RADIOS").equals(
                new Integer(SERVER_RADIO_REMOTE))) {
            // サーバのラジオがリモートだった場合で、IPアドレスが入力されているかチェック
            if (ACTextUtilities.isNullText(params
                    .getData("SERVER_SELECT_IP_TEXT"))) {
                QkanMessageList.getInstance().QO005_ERROR_OF_EMPTY_IP_OR_HOST();
                getServerSelectIpText().requestFocus();
                return false;
            }
        }

        // ファイル名未入力
        if (ACTextUtilities.isNullText(params
                .getData("DB_FILE_SELECT_FILE_NAME"))) {
            QkanMessageList.getInstance().QO005_ERROR_OF_EMPTY_DBFILE_PATH();
            getDbFileSelectFileName().requestFocus();
            return false;
        }

        // PDFファイル名未入力
        if (getPdfFileSelects().isVisible()
                && ACTextUtilities.isNullText(params
                        .getData("PDF_FILE_SELECT_FILE_NAME"))) {
            QkanMessageList.getInstance()
                    .QO005_ERROR_OF_EMPTY_PDF_VIEWER_PATH();
            getPdfFileSelectFileName().requestFocus();
            return false;
        }

        // 許可文字コード
        if (!VRCharType.ONLY_HALF_CHAR.isMatch(String.valueOf(params
                .getData("DB_FILE_SELECT_FILE_NAME")))) {
            final String osName = String.valueOf(System.getProperty("os.name"))
                    .toLowerCase();
            if ((osName.indexOf("mac") < 0)
                    || (getServerSelectRadioItem1().isSelected())) {
                // Macではないかローカルコンピューターを指定した場合は許可文字チェックを書ける

                getDbFileSelectFileName().requestFocus();
                QkanMessageList.getInstance()
                        .QO005_ERROR_OF_DBPATH_INCLUDE_JAPANESE_CHAR();
                return false;
            }
        }
        
        switch(checkDBConnect(params)) {
        case DB_CONNECT_ERROR:
            // 接続チェックで接続できなかった場合
            getDbFileSelectFileName().requestFocus();
            QkanMessageList.getInstance().QO005_ERROR_OF_NOT_CONNECT_FIREBIRD();
            return false;
        case DB_SCHEMA_ERROR:
            //スキーマバージョンが古い場合
            getDbFileSelectFileName().requestFocus();
            QkanMessageList.getInstance().QO005_ERROR_OF_SCHEMA_VERSION();
            return false;
        }
        return true;
    }

    /**
     * DBの接続試験を行います。
     * 
     * @throws Exception
     *             処理例外
     */
    public int checkDBConnect(VRMap params) throws Exception {
        // サーバのアドレスの格納
        BridgeFirebirdDBManager dbm = new BridgeFirebirdDBManager();
        try {
            String server;
            if (params.getData("SERVER_SELECT_RADIOS").equals(
                    new Integer(SERVER_RADIO_LOCAL))) {
                server = "127.0.0.1";
            } else {
                server = String
                        .valueOf(params.getData("SERVER_SELECT_IP_TEXT"));
            }

            int port = ACCastUtilities.toInt(getProperty("DBConfig/Port"));
            String userName = getProperty("DBConfig/UserName");
            String passWord = getProperty("DBConfig/Password");
            String path = String.valueOf(params
                    .getData("DB_FILE_SELECT_FILE_NAME"));
            int loginTimeout = ACCastUtilities
                    .toInt(getProperty("DBConfig/LoginTimeOut"));
            int maxPoolSize = ACCastUtilities
                    .toInt(getProperty("DBConfig/MaxPoolSize"));
            String charSet = getProperty("DBConfig/CharSet");
            String encoding = getProperty("DBConfig/Encoding");

            dbm.releaseAll();
            dbm = new BridgeFirebirdDBManager(server, port, userName, passWord,
                    path, loginTimeout, maxPoolSize, charSet, encoding);

            if (dbm.isAvailableDBConnection()) {

                VRList list = dbm
                        .executeQuery("SELECT M_QKAN_VERSION.SCHEME_VERSION FROM M_QKAN_VERSION");
                if ((list == null) || (list.isEmpty())) {
                    // DBのVer取得できず。
                    dbm.releaseAll();
                    return DB_CONNECT_ERROR;
                } else {
                    String version = ACCastUtilities.toString(((VRMap)list.getData(0)).get("SCHEME_VERSION"), "");
                    if (!QkanCommon.isValidSchemaVersion(version)) {
                        // 2015/4/17 [Yoichiro Kamei] add - begin 旧バージョンのDBに接続したままとなっていた為、接続を解放
                        dbm.releaseAll();
                        // 2015/4/17 [Yoichiro Kamei] add - end
                        return DB_SCHEMA_ERROR;
                    }
                }
                dbm.releaseAll();
                return DB_OK;
            } else {
                dbm.releaseAll();
                return DB_CONNECT_ERROR;
            }
        } catch (Exception ex) {
            dbm.releaseAll();
            return DB_CONNECT_ERROR;
        }
    }

    /**
     * デフォルトのファイル名を取得します。
     * 
     * @param fileExtension
     *            拡張子
     * @return ファイル名
     */
    public String getDefaultFileName(String fileExtension) throws Exception {
        String today = "";
        Calendar cal = Calendar.getInstance();
        VRDateFormat vrdf = new VRDateFormat("yyMMdd");
        today = vrdf.format(cal.getTime());
        return "qk" + today + "." + fileExtension;
    }

    /**
     * 「消費税率設定」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void taxChangeActionPerformed(ActionEvent e) throws Exception {
        // ※消費税率の設定
        if (ACTextUtilities.isNullText(getTax())) {
            // 消費税率(tax)が空欄の場合
            // データベースの設定が完了していない旨のメッセージを表示する。※メッセージID = QO005_ERROR_OF_DB_FAILED
            QkanMessageList.getInstance().QO005_ERROR_OF_DB_FAILED();
            // 処理を中断する。
            return;
        }
        // 消費税率編集画面を生成し、現在の消費税率(tax)の値を引数に表示する。
        double oldVal = ACCastUtilities.toDouble(getTax().getText(), 0);
        double newVal = new QO005001().showModal(oldVal);
        if (oldVal != newVal) {
            // 表示結果として返却された消費税率が、現在の消費税率(tax)の値と異なる場合
            // 返却された消費税率でマスタを更新する。
            QkanCommon.setTax(getDBManager(), newVal);
            // 消費税率(tax)に返却された消費税率を設定する。
            getTax().setText(ACCastUtilities.toString(newVal));
        }
    }

    /**
     * 「消費税率の取得」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     * 
     */
    public void checkTax() throws Exception {
        // 消費税率が取得可能か検査する。
        double val = QkanCommon.getTax(getDBManager());
        if (val >= 0) {
            // 消費税率を取得できた場合は消費税率(tax)にその値を設定する。
            getTax().setText(ACCastUtilities.toString(val));
        } else {
            // 消費税率を取得できなかった場合は消費税率(tax)を空欄とする。
            getTax().setText("");
        }
    }

}
