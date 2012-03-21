package jp.or.med.orca.qkan.affair.qm.qm002;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

import jp.nichicom.ac.component.ACEditorPane;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACTextUtilities;

/**
 * 
 * HTMLページ読込みを行います。
 * 
 * QM001HtmlPageReaderです。
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2007/11/05
 * @since 5.4.1
 */
public class QM002HtmlPageReader implements Runnable {
    // スレッド
    Thread th;

    ACEditorPane editor;
    
    /**
     * お知らせ領域 を返します。
     * @return editor
     */
    protected ACEditorPane getEditor() {
        return editor;
    }

    /**
     * お知らせ領域 を設定します。
     * @param editor editor
     */
    protected void setEditor(ACEditorPane editor) {
        this.editor = editor;
    }
    
    /**
     * ページ読込み処理・表示処理
     */
    public void run() {
        // 最初は非表示
        getEditor().setVisible(false);
        URL url;
        try {
            // OS種類を取得
            String osName = System.getProperty("os.name");
            // Macの場合は非適用
            if ((osName != null) && (osName.indexOf("Mac") < 0)) {
                // プロキシサーバ名称を設定する
                System.setProperty("http.proxyHost", PropertyUtil
                        .getProperty("http.proxyHost"));
                // プロキシのポート番号を設定する。
                System.setProperty("http.proxyPort", PropertyUtil
                        .getProperty("http.proxyPort"));
                // プロキシを使わないサーバの設定
                System.setProperty("http.nonProxyHosts", PropertyUtil
                        .getProperty("http.nonProxyHosts"));
            }
            // URLを生成
            url = new URL(getVersionUpInfoURL());
            // 先にVisibleを切り替える
            getEditor().setVisible(true);
            // ページの表示
            getEditor().showHtmlPage(url);
            // Enable制御
            getEditor().setEnabled(true);
            // スレッドの破棄
            //th = null;
            // 念のため再描画処理を走らせる
            getEditor().repaint();
            getEditor().revalidate();
        } catch (Exception e) {
            // 読み込み失敗時は非表示
            getEditor().setVisible(false);
            e.printStackTrace();
        }
        

    }

    /**
     * 新規のスレッドを生成して処理を実行します。
     */
    public void start(ACEditorPane editor){
        // スレッド生成
        th = new Thread(this);
        // エディターを設定
        setEditor(editor);
        // スレッドスタート
        th.start();
    }
    
    /**
     * アクセスするURLを返します。
     * 
     * @return アクセスするURL
     */
    protected String getVersionUpInfoURL() {
        try {
            File f = new File(ACFrame.getInstance().getExeFolderPath(),
                    "versionUpInfo.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(f)));
            if (br != null) {
                String txt = br.readLine();
                if (!ACTextUtilities.isNullText(txt)) {
                    return txt;
                }
                br.close();
            }
        } catch (Exception e) {
        }
        return "";
    }
    
    
}
