package jp.or.med.orca.qkan.affair;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;

import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.core.ACAffairDialog;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.io.ACPropertyXML;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACLoggerDBManager;
import jp.nichicom.ac.sql.ACPassiveCheck;
import jp.nichicom.ac.util.ACSnapshot;
import jp.nichicom.ac.util.ACSplashable;
import jp.nichicom.bridge.sql.BridgeFirebirdDBManager;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * 給管帳システムの業務用ダイアログです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/12/01
 */
public class QkanAffairDialog extends ACAffairDialog {
    private ACPassiveCheck passiveChecker = new ACPassiveCheck();
    private ACSnapshot snapshot = new ACSnapshot();
    private ACDBManager dbm;

    public QkanAffairDialog() throws HeadlessException {
        super();
    }

    public QkanAffairDialog(Dialog owner) throws HeadlessException {
        super(owner);
    }

    public QkanAffairDialog(Dialog owner, boolean modal)
            throws HeadlessException {
        super(owner, modal);
    }

    public QkanAffairDialog(Frame owner) throws HeadlessException {
        super(owner);
    }

    public QkanAffairDialog(Frame owner, boolean modal)
            throws HeadlessException {
        super(owner, modal);
    }

    public QkanAffairDialog(Dialog owner, String title)
            throws HeadlessException {
        super(owner, title);
    }

    public QkanAffairDialog(Dialog owner, String title, boolean modal)
            throws HeadlessException {
        super(owner, title, modal);
    }

    public QkanAffairDialog(Frame owner, String title) throws HeadlessException {
        super(owner, title);
    }

    public QkanAffairDialog(Frame owner, String title, boolean modal)
            throws HeadlessException {
        super(owner, title, modal);
    }

    public QkanAffairDialog(Dialog owner, String title, boolean modal,
            GraphicsConfiguration p3) throws HeadlessException {
        super(owner, title, modal, p3);
    }

    public QkanAffairDialog(Frame owner, String title, boolean modal,
            GraphicsConfiguration p3) {
        super(owner, title, modal, p3);
    }

    /**
     * 業務で使用するDBManagerを取得します。
     * 
     * @return DBManager
     * @throws Exception 処理例外
     */
    protected ACDBManager getDBManager() throws Exception {
        if (dbm == null) {
            // システム設定ファイルからDBの設定を取得
            ACPropertyXML xml = ACFrame.getInstance().getPropertyXML();
            if (xml == null) {
                throw new FileNotFoundException("システム設定ファイルを開けません。");
            }
            String server = xml.getValueAt("DBConfig/Server");
            int port = Integer.parseInt(xml.getValueAt("DBConfig/Port"));
            String userName = xml.getValueAt("DBConfig/UserName");
            String pass = xml.getValueAt("DBConfig/Password");
            String path = xml.getValueAt("DBConfig/Path");
            int loginTimeout = Integer.parseInt(xml
                    .getValueAt("DBConfig/LoginTimeOut"));
            int maxPoolSize = Integer.parseInt(xml
                    .getValueAt("DBConfig/MaxPoolSize"));

            String charSet = xml.getValueAt("DBConfig/CharSet");
            dbm = new ACLoggerDBManager(new BridgeFirebirdDBManager(server, port, userName, pass,
                    path, loginTimeout, maxPoolSize, charSet));
        }
        return dbm;
    }

    /**
     * スナップショットマネージャを返します。
     * 
     * @return スナップショットマネージャ
     */
    protected ACSnapshot getSnapshot() {
        return snapshot;
    }

    /**
     * パッシブチェックマネージャを返します。
     * 
     * @return パッシブチェックマネージャ
     */
    protected ACPassiveCheck getPassiveChecker() {
        return passiveChecker;
    }

    /**
     * プロパティファイルから値を取得します。
     * 
     * @param path キー
     * @throws Exception 処理例外
     * @return キーに対応する値
     */
    public String getProperty(String path) throws Exception {
        return ACFrame.getInstance().getProperty(path);
    }

    /**
     * プロパティファイルに値を書き込みます。
     * 
     * @param path キー
     * @param value キーに対応する値
     * @throws Exception 処理例外
     */
    protected void setProperty(String path, String value) throws Exception {
        ACPropertyXML xml = ACFrame.getInstance().getPropertyXML();
        xml.setForceValueAt(path, value);
        xml.write();
    }
    /**
     * DBから現在の業務ID/モードに対応したウィンドウタイトル・業務ボタンバーを取得して設定します。
     * 
     * @param affairID 業務ID
     * @param mode モード
     * @param affairButtonBar 業務ボタンバー
     * @return 業務情報
     * @throws Exception 処理例外
     */
    protected VRMap setAffairTitle(String affairID, String mode,
            ACAffairButtonBar affairButtonBar) throws Exception {
        // ※ウィンドウタイトル・業務ボタンバーの設定
        // 業務情報レコードを取得する。
        VRMap affairInfo = QkanCommon.getAffairInfo(getDBManager(), affairID,
                mode);
        
        
        // ウィンドウタイトルに、取得レコードのKEY : WINDOW_TITLEのVALUEを設定する。
        Object title=VRBindPathParser.get("WINDOW_TITLE", affairInfo);
        if(title!=null){
            setTitle(String.valueOf(title));
            if (ACFrame.getInstance().getNowAffair() != null) {
                ACFrame.getInstance().getNowAffair().setTitle(String.valueOf(title));
            }
        }else{
            VRLogger.info("ウィンドウタイトルの取得に失敗：" + affairInfo);
        }

        // 業務ボタンバーのテキストに、取得レコードのKEY : AFFAIR_TITLEのVALUEを設定する。
        if (affairButtonBar != null) {
            Object affirTitle = VRBindPathParser.get(
                    "AFFAIR_TITLE", affairInfo);
            if(affirTitle !=null){
                affairButtonBar.setText(String.valueOf(affirTitle));
            }
        }


        return affairInfo;
    }

    /**
     * DBから現在の業務ID/モードに対応したウィンドウタイトル・業務ボタンバーを取得して設定します。
     * 
     * @param affairID 業務ID
     * @param affairButtonBar 業務ボタンバー
     * @return 業務情報
     * @throws Exception 処理例外
     */
    protected VRMap setAffairTitle(String affairID,
            ACAffairButtonBar affairButtonBar) throws Exception {
        return setAffairTitle(affairID, null, affairButtonBar);
    }

    /**
     * DBから現在の業務ID/モードに対応したウィンドウタイトルを取得して設定します。
     * 
     * @param affairID 業務ID
     * @return 業務情報
     * @throws Exception 処理例外
     */
    protected VRMap setAffairTitle(String affairID) throws Exception {
        return setAffairTitle(affairID, null, null);
    }

    /**
     * スプラッシュを表示します。
     * @param message メッセージ
     * @return スプラッシュ
     * @throws Exception 処理例外
     */
    protected ACSplashable createSplash(String message) throws Exception {
        ACFrameEventProcesser processer = ACFrame.getInstance().getFrameEventProcesser();
        if(processer!=null){
            return processer.createSplash(message);
        }
        return null;
    }
}
