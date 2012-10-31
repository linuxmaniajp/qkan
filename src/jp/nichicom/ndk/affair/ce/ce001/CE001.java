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
 * **************************************************************** 
 * アプリ: QKANCHO
 * 開発者: 田中 統蔵 
 * 作成日: 2005/11/04  日本コンピューター株式会社 田中 統蔵 新規作成 
 * 更新日: ----/--/-- 
 * システム CodeWall
 * サブシステム CodeWall
 * プロセス 暗号化 (001) 
 * プログラム 暗号化 (CE001)
 * ****************************************************************
 */
package jp.nichicom.ndk.affair.ce.ce001;

import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACClassLoader;
import jp.nichicom.ac.core.ACDefaultFrameEventProcesser;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.filechooser.ACFileChooser;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACHashMapFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * 暗号化(CE001)
 */
@SuppressWarnings("serial")
public class CE001 extends CE001Event {
    /** 対象のモデルとしてtargetsModel : VRArrayListを定義。 */
    private VRArrayList targetsModel = new VRArrayList();
    /** フォルダを表す対象の種類定数 TARGET_TYPE_DIRECTORY(1) を定義。 */
    private final static int TARGET_TYPE_DIRECTORY = 1;
    /** ファイルを表す対象の種類定数 TARGET_TYPE_FILE(2) を定義。 */
    private final static int TARGET_TYPE_FILE = 2;
    /** 追加を表す対象のフィルタ定数 TARGET_FILTER_ADD(1) を定義。 */
    private final static int TARGET_FILTER_ADD = 1;
    /** 除外を表す対象のフィルタ定数 TARGET_FILTER_REMOVE(2) を定義。 */
    private final static int TARGET_FILTER_REMOVE = 2;


    public static void main(String[] args) {
        try {
            ACFrame.setVRLookAndFeel();
            ACFrame.getInstance().setFrameEventProcesser(
                    new ACDefaultFrameEventProcesser());
            ACFrame.getInstance().next(
                    new ACAffairInfo(CE001.class.getName()));
            
            if (ACFrame.getInstance().getNowPanel() instanceof CE001) {
                if (((CE001) ACFrame.getInstance().getNowPanel())
                        .executeArguments(args)) {
                    //コマンドライン実行
                    System.exit(0);
                    return;
                }
            }
            ACFrame frame = ACFrame.getInstance();
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    
    protected boolean executeArguments(String[] args) throws Exception{
        if((args!=null)&&(args.length>=2)){
            String command = args[0]; 
            String param = args[1];
            if(command.equals("encode")){
                addTargets(param);
                encodeActionPerformed(null);
            }else if(command.equals("decode")){
                addTargets(param);
                decodeActionPerformed(null);
            }else if(command.equals("stub")){
                addTargets(param);
                if(args.length>=3){
                    //スタブ出力先
                    getStubOutPath().setText(args[2]);
                }
                stubOutActionPerformed(null);
            }else{
                jp.nichicom.vr.util.logging.VRLogger.info("unknown command: "+ command);
            }
            return true;
        }
        return false;
    }
    
    protected void addTargets(String arg) throws Exception{
        String[] args = arg.split("\\} \\{");
        int end = args.length;
        for(int i=0; i<end; i++){
            String[] params = args[i].split("\\] \\[");
            if(params.length>3){
                //category
                
                VRMap newRow = new VRHashMap();
                //type
                VRBindPathParser.set("TARGET_TYPE", newRow, ACCastUtilities.toInteger(params[1], 1));
                //filter
                VRBindPathParser.set("TARGET_FILTER", newRow, ACCastUtilities.toInteger(params[2], 1));
                //path
                VRBindPathParser.set("TARGET_PATH", newRow, ACCastUtilities.toString(params[3]));

                targetsModel.addData(newRow);
            }else{
                jp.nichicom.vr.util.logging.VRLogger.info("unknown parameter: "+ args[i]);
            }
        }
    }
    
    
    /**
     * コンストラクタです。
     */
    public CE001() {
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
        // targetsのModelとしてtargetModelを設定。
        getTargets().setModel(
                new ACTableModelAdapter(targetsModel, new String[] {
                        "TARGET_SERIAL", "TARGET_TYPE", "TARGET_FILTER",
                        "TARGET_PATH" }));
        // カラム「targetsType」のフォーマッタとして以下のハッシュフォーマットを設定。
        // 1：フォルダ
        // 2：ファイル
        getTargetsType().setFormat(
                new ACHashMapFormat(new String[] { "フォルダ", "ファイル" },
                        new Integer[] { new Integer(TARGET_TYPE_DIRECTORY),
                                new Integer(TARGET_TYPE_FILE) }));
        // カラム「targetsFilter」のフォーマッタとして以下のハッシュフォーマットを設定。
        // 1：追加
        // 2：除外
        getTargetsFilter().setFormat(
                new ACHashMapFormat(new String[] { "追加", "除外" }, new Integer[] {
                        new Integer(TARGET_FILTER_ADD),
                        new Integer(TARGET_FILTER_REMOVE) }));

        // 「対象の種類」と「フィルタ」それぞれ最初のラジオを選択する。
        getTargetType().setSelectedIndex(TARGET_TYPE_DIRECTORY);
        getTargetFilter().setSelectedIndex(1);

    }

    // コンポーネントイベント

    /**
     * 「暗号化」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void encodeActionPerformed(ActionEvent e) throws Exception {

        // targetsModelを走査して対象の追加・除外条件をマージし、対象とするクラスファイルパスの集合を得る。
        ArrayList<String> files = getTargetFilePathes();

        if (files.isEmpty()) {
            // 対象が存在しない場合、以下の処理を行なう。
            // 以下の設定でメッセージを表示する。
            // 本文：対象のファイルが存在しません。
            // アイコン：感嘆符
            // ボタン：OK
            ACMessageBox.showExclamation("対象のファイルが存在しません。");
            // 処理を終了する。
            return;
        }

        ACSplashable splash = ACFrame.getInstance().getFrameEventProcesser().createSplash("暗号化");

        // エラー内容記録用のバッファを確保する。
        StringBuilder errorSB = new StringBuilder();

        // 設定を元に暗号化ヘッダを取得する。
        byte[] protectHeader = getProtectHeader();
        // 対象のファイルパス集合を走査し、以下の処理を行なう。
        Iterator<String> it = files.iterator();
        while (it.hasNext()) {

            String srcPath = String.valueOf(it.next());
            String tmpPath = srcPath + ".~tmp";
            BufferedInputStream in = null;
            BufferedOutputStream out = null;
            boolean modified = false;
            try {
                // 対象のファイルを開く。
                in = new BufferedInputStream(new FileInputStream(srcPath));

                byte[] inHead = new byte[3];
                if (in.read(inHead) >= 0) {
                    if ((inHead[0] != 'n') && (inHead[1] != 'c')
                            && (inHead[2] != 'w')) {
                        // 対象ファイルの先頭3バイトが"ncw"でなければ、暗号化していないとみなし以下の処理を行なう。

                        // 対象のファイルパス+".~tmp"というファイル名で出力ファイルを開く。
                        out = new BufferedOutputStream(new FileOutputStream(
                                tmpPath));

                        // 出力ファイルに暗号化ヘッダを出力する。
                        out.write(protectHeader);
                        // 出力ファイルに入力ファイルの内容をすべてビット反転して出力する。
                        for (int i = 0; i < inHead.length; i++) {
                            out.write(inHead[i] ^ 0xFF);
                        }

                        int c;
                        while ((c = in.read()) != -1) {
                            out.write(c ^ 0xFF);
                        }
                        modified = true;
                    }
                }
            } finally {

                // 入力・出力ファイルを閉じる。
                if (in != null) {
                    in.close();
                    in = null;
                }
                if (out != null) {
                    out.close();
                    out = null;
                }
            }

            if (modified) {
                // 出力した場合、以下の処理を行なう。
                // 対象のファイルを削除する。
                File f = new File(srcPath);
                if (f.delete()) {
                    // 対象のファイル削除に成功した場合、以下の処理を行なう。
                    // 出力ファイルを対象のファイル名にリネームする。
                    new File(tmpPath).renameTo(f);
                } else {
                    // 対象のファイル削除に失敗した場合、以下の処理を行なう。
                    // エラー内容記録バッファに以下の書式でエラー情報を追加する。
                    // "[削除エラー] " + エラーファイル名
                    errorSB.append("[削除エラー] " + srcPath);
                }
            }
        }

        if(splash!=null){
            splash.close();
            splash = null;
        }
        
        if(e!=null){
            // 以下の設定でメッセージを表示する。
            ACMessageBox.show("暗号化しました。");
        }
        
    }

    /**
     * 「復号化」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void decodeActionPerformed(ActionEvent e) throws Exception {
        // targetsModelを走査して対象の追加・除外条件をマージし、対象とするクラスファイルパスの集合を得る。
        ArrayList<String> files = getTargetFilePathes();

        if (files.isEmpty()) {
            // 対象が存在しない場合、以下の処理を行なう。
            // 以下の設定でメッセージを表示する。
            // 本文：対象のファイルが存在しません。
            // アイコン：感嘆符
            // ボタン：OK
            ACMessageBox.showExclamation("対象のファイルが存在しません。");
            // 処理を終了する。
            return;
        }
        
        ACSplashable splash = ACFrame.getInstance().getFrameEventProcesser().createSplash("復号化");
        
        // エラー内容記録用のバッファを確保する。
        StringBuilder errorSB = new StringBuilder();

        // 対象のファイルパス集合を走査し、以下の処理を行なう。
        Iterator<String> it = files.iterator();
        while (it.hasNext()) {

            String srcPath = String.valueOf(it.next());
            String tmpPath = srcPath + ".~tmp";
            BufferedInputStream in = null;
            BufferedOutputStream out = null;
            boolean modified = false;
            try {
                // 対象のファイルを開く。
                in = new BufferedInputStream(new FileInputStream(srcPath));

                byte[] inHead = new byte[3];
                if (in.read(inHead) >= 0) {
                    if ((inHead[0] == 'n') && (inHead[1] == 'c')
                            && (inHead[2] == 'w')) {
                        // 対象ファイルの先頭3バイトが"ncw"ならば、暗号化しているとみなし以下の処理を行なう。

                        // 暗号化バージョンとして4バイトの情報を読み込む。
                        byte[] inVer = new byte[4];
                        if (in.read(inVer) < 4) {
                            // 暗号化バージョンの読み込みに失敗した場合、以下の処理を行なう。
                            // エラー内容記録バッファに以下の書式でエラー情報を追加する。
                            // "[暗号化バージョンエラー] " + エラーファイル名
                            errorSB.append("[暗号化バージョンエラー] " + srcPath);
                            // 繰り返しの終端にとび、次のファイルを処理する。
                            continue;
                        }

                        int ver = parseInt(inVer);
                        if (ver != 1) {
                            // 暗号化バージョンがバイト情報{1,0,0,0}でなければ、以下の処理を行なう。
                            // エラー内容記録バッファに以下の書式でエラー情報を追加する。
                            // "[未対応の暗号化バージョン](" + 読み込んだバージョン + ") " + エラーファイル名

                            errorSB.append("[未対応の暗号化バージョン](" + ver + ") "
                                    + srcPath);
                            // 繰り返しの終端にとび、次のファイルを処理する。
                            continue;
                        }

                        // 埋め込み情報サイズとして4バイトの情報を読み込む。
                        byte[] inJump = new byte[4];
                        if (in.read(inJump) < 4) {
                            // 埋め込み情報サイズの読み込みに失敗した場合、以下の処理を行なう。
                            // エラー内容記録バッファに以下の書式でエラー情報を追加する。
                            // "[埋め込み情報サイズエラー] " + エラーファイル名
                            errorSB.append("[埋め込み情報サイズエラー] " + srcPath);
                            // 繰り返しの終端にとび、次のファイルを処理する。
                            continue;
                        }

                        // 埋め込み情報サイズ分読みとばす。
                        int jump = parseInt(inJump);
                        if (in.skip(jump) < jump) {
                            // 埋め込み情報の読みとばしに失敗した場合、以下の処理を行なう。
                            // エラー内容記録バッファに以下の書式でエラー情報を追加する。
                            // "[埋め込み情報エラー] " + エラーファイル名
                            errorSB.append("[埋め込み情報エラー] " + srcPath);
                            continue;
                        }

                        // 対象のファイルパス+".~tmp"というファイル名で出力ファイルを開く。
                        out = new BufferedOutputStream(new FileOutputStream(
                                tmpPath));
                        // 出力ファイルに入力ファイルの内容をすべてビット反転して出力する。
                        int c;
                        while ((c = in.read()) != -1) {
                            out.write(c ^ 0xFF);
                        }
                        modified = true;

                    }
                }
            } finally {

                // 入力・出力ファイルを閉じる。
                if (in != null) {
                    in.close();
                    in = null;
                }
                if (out != null) {
                    out.close();
                    out = null;
                }
            }

            if (modified) {
                // 出力した場合、以下の処理を行なう。
                // 対象のファイルを削除する。
                File f = new File(srcPath);
                if (f.delete()) {
                    // 対象のファイル削除に成功した場合、以下の処理を行なう。
                    // 出力ファイルを対象のファイル名にリネームする。
                    new File(tmpPath).renameTo(f);
                } else {
                    // 対象のファイル削除に失敗した場合、以下の処理を行なう。
                    // エラー内容記録バッファに以下の書式でエラー情報を追加する。
                    // "[削除エラー] " + エラーファイル名
                    errorSB.append("[削除エラー] " + srcPath);
                }
            }
        }

        if(splash!=null){
            splash.close();
            splash = null;
        }
        
        if(e!=null){
            // 以下の設定でメッセージを表示する。
            ACMessageBox.show("復号化しました。");
        }
    }

    /**
     * 4バイトのバイト配列をリトルエンディアン形式のint型として解釈して返します。
     * 
     * @param src 解釈元
     * @return 解釈結果
     */
    public int parseInt(byte[] src) {
        // int型の解釈値をバイト配列の添え字[0]の値で初期化する。
        int ver = src[0];
        // バイト配列の添え字[1]から添え字[3]まで、以下の処理を行なう。
        for (int i = 1; i < 4; i++) {
            // 解釈値に対象のバイト値を「添え字*8ビット」左シフトした値を加算する。
            ver += src[i] << (i * 8);
        }
        // 関数の返り値として解釈値を返す。
        return ver;
    }

    /**
     * 「既存の対象を選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void targetsSelectionChanged(ListSelectionEvent e)
            throws Exception {
        if (getTargets().isSelected()) {
            // テーブルの要素を選択している場合
            // 「対象の更新」「対象の削除」を有効にする。
            getTargetSettingUpdate().setEnabled(true);
            getTargetSettingDelete().setEnabled(true);

            // 選択した対象情報であるVRMapをtargetSettingのソースとして設定する。
            getTargetSetting().setSource(
                    (VRMap) getTargets().getSelectedModelRowValue());
            // targetSettingのbindSourceを呼び出し値を取り込む。
            getTargetSetting().bindSource();

        } else {

            // テーブルの要素を選択していない場合
            // 「対象の更新」「対象の削除」を無効にする。
            getTargetSettingUpdate().setEnabled(false);
            getTargetSettingDelete().setEnabled(false);
        }
    }

    /**
     * 対象が有効か検証します。
     * 
     * @return 対象が有効か
     */
    public boolean isValidTarget() {
        switch (getTargetType().getSelectedIndex()) {
        case TARGET_TYPE_DIRECTORY:
            // targetType の選択番号が1（フォルダ）の場合、以下の処理を行なう。

            if (!new File(getTargetPath().getText()).isDirectory()) {
                // targetPath に指定されたパスが存在するフォルダではない場合、以下の処理を行なう。
                // 以下の設定でメッセージを表示する。
                // 本文：有効なフォルダではありません。
                // アイコン：エラー
                // ボタン：OK
                ACMessageBox.showExclamation("有効なフォルダではありません。");
                // 関数の返り値としてfalseを返す
                return false;
            }
            break;
        case TARGET_TYPE_FILE:
            // targetType の選択番号が2（ファイル）の場合、以下の処理を行なう。
            if (!new File(getTargetPath().getText()).isFile()) {
                // targetPath に指定されたパスが存在するファイルではない場合、以下の処理を行なう。
                // 以下の設定でメッセージを表示する。
                // 本文：有効なファイルではありません。
                // アイコン：エラー
                // ボタン：OK
                ACMessageBox.showExclamation("有効なファイルではありません。");
                // 関数の返り値としてfalseを返す
                return false;
            }
        }
        // 関数の返り値としてtrueを返す。
        return true;
    }

    /**
     * 「対象先を参照」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void targetPathBroseActionPerformed(ActionEvent e)
            throws Exception {
        File f;
        ACFileChooser fc = new ACFileChooser();
        // 対象の種類に応じて以下の設定でパス選択ダイアログを表示する。
        switch (getTargetType().getSelectedIndex()) {
        case TARGET_TYPE_DIRECTORY:
            // 1.対象の種類が「フォルダ」の場合
            // フォルダ選択のみ許可する。
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            f = fc.showOpenDialog("対象のフォルダを選択", new String[] { "*" }, "フォルダ");
            break;
        case TARGET_TYPE_FILE:
            // 2.対象の種類が「ファイル」の場合
            // ファイル選択のみ許可し、フィルタに「*.class」を指定。
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            f = fc.showOpenDialog("対象のファイルを選択", new String[] { "class" },
                    "クラスファイル(*.class)");
            break;
        default:
            return;
        }
        // パス選択ダイアログにてパスを選択した場合、選択したパスを「targetPath」に設定する。
        if (f != null) {
            getTargetPath().setText(f.getAbsolutePath());
        }
    }

    /**
     * 「対象を追加」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void targetSettingInsertActionPerformed(ActionEvent e)
            throws Exception {
        // 対象の設定が有効か検証し、無効であれば処理を終了する。。
        if (!isValidTarget()) {
            return;
        }
        // 空のVRMap(newRow)を生成する。
        VRMap newRow = new VRHashMap();
        // targetSettingのバインドソースとしてにnewRowを設定する。
        getTargetSetting().setSource(newRow);

        // targetSettingのapplySourceを呼び出し、値を流し込む。
        getTargetSetting().applySource();

        // 値を取り込んだnewRowをテーブルの新たな列として追加する。
        targetsModel.addData(newRow);
    }

    /**
     * 「対象を更新」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void targetSettingUpdateActionPerformed(ActionEvent e)
            throws Exception {
        if (getTargets().isSelected()) {
            // 対象の設定が有効か検証し、無効であれば処理を終了する。。
            if (!isValidTarget()) {
                return;
            }
            // テーブルの要素を選択している場合、以下の処理を行なう。
            // targetSettingのapplySourceを呼び出し、値を流し込む。
            getTargetSetting().applySource();

            // テーブルを再描画する。
            getTargets().revalidate();
            getTargets().repaint();

        }

    }

    /**
     * 「対象を削除」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void targetSettingDeleteActionPerformed(ActionEvent e)
            throws Exception {
        if (getTargets().isSelected()) {
            // テーブルの要素を選択している場合、以下の処理を行なう。
            // テーブルの選択行の情報を削除する。
            targetsModel.removeData(getTargets().getSelectedModelRow());
        }
    }

    // 内部関数

    /**
     * 埋め込むヘッダ情報を返します。
     * 
     * @return 埋め込むヘッダ情報
     */
    public byte[] getProtectHeader() {

        byte[] chank = new byte[] { 'n', 'c', 'w' };
        byte[] ver = new byte[] { 1, 0, 0, 0 };
        byte[] jump = new byte[4];
        byte[] implant = getInformation().getText().getBytes();
        int implantSize = implant.length+1;
        for (int i = 0; i < 4; i++) {
            jump[i] = (byte) ((implantSize >> (i * 8)) & 0xFF);
        }
        int size = chank.length + ver.length + jump.length + implantSize;
        // ヘッダ情報格納用のバッファを生成する。
        byte[] protectHeader = new byte[size];
        int pos = 0;
        // バッファにCodeWallのチャンク情報である3バイトの文字列"ncw"を追加する。
        System.arraycopy(chank, 0, protectHeader, pos, chank.length);
        pos += chank.length;
        // バッファに暗号化バージョンとして4バイトの数値{ 1, 0, 0, 0}を追加する。
        System.arraycopy(ver, 0, protectHeader, pos, ver.length);
        pos += ver.length;
        // バッファに埋め込む情報のサイズとして以下の通り4バイトの情報を追加する。
        // ・1バイト目：埋め込む情報サイズの1～8ビット目を1バイトで格納
        // ・2バイト目：埋め込む情報サイズの9～16ビット目を1バイトで格納
        // ・3バイト目：埋め込む情報サイズの17～24ビット目を1バイトで格納
        // ・4バイト目：埋め込む情報サイズの25～32ビット目を1バイトで格納
        System.arraycopy(jump, 0, protectHeader, pos, jump.length);
        pos += jump.length;
        // バッファに埋め込む情報としてinformationの入力値を追加する。
        System.arraycopy(implant, 0, protectHeader, pos, implant.length);
        // 関数の返り値としてバッファを返す。
        return protectHeader;
    }

    /**
     * 対象とするファイル集合を返します。
     * 
     * @return 対象とするファイル集合
     * @throws Exception 処理例外
     */
    public ArrayList<String> getTargetFilePathes() throws Exception {
        // 追加用のリストと除外用のリストを生成する。
        ArrayList<String> add = new ArrayList<String>();
        ArrayList<String> remove = new ArrayList<String>();
        // targetsModelを走査し、以下の処理を行なう。
        Iterator<VRMap> it = targetsModel.iterator();
        while (it.hasNext()) {
            VRMap map = (VRMap) it.next();
            switch (Integer.parseInt(String.valueOf(VRBindPathParser.get(
                    "TARGET_FILTER", map)))) {
            case TARGET_FILTER_ADD:
                // フィルタに追加が指定されていれば、追加用リストに対象ファイル/フォルダを追加する。
                stockClassFile(new File(String.valueOf(VRBindPathParser.get(
                        "TARGET_PATH", map))), add, ".class");
                break;
            case TARGET_FILTER_REMOVE:
                // フィルタに除外が指定されていれば、除外用リストに対象ファイル/フォルダを追加する。
                stockClassFile(new File(String.valueOf(VRBindPathParser.get(
                        "TARGET_PATH", map))), remove, ".class");
                break;
            }
        }
        // 追加用リストから削除用リストの内容を削除する。
        add.removeAll(remove);
        // 関数の返り値として追加用リストを返す。
        return add;
    }

    /**
     * 指定の拡張子を有するクラスファイルを再帰的に追加します。
     * 
     * @param file ファイルオブジェクト
     * @param dest 追加先
     * @param extention 拡張子
     */
    public void stockClassFile(File file, ArrayList<String> dest, String extention) {
        if (file.isFile()) {
            // 引数がファイルの場合、以下の処理を行なう。
            if (file.getName().endsWith(extention)) {
                // 許容する拡張子の場合、引数のリストに追加する。
                dest.add(file.getAbsolutePath());
            }
        } else if (file.isDirectory()) {
            // 引数がフォルダの場合、以下の処理を行なう。
            File[] files = file.listFiles();
            int end = files.length;
            for (int i = 0; i < end; i++) {
                // フォルダの下位の項目を走査する。
                stockClassFile(files[i], dest, extention);
            }
        }else{
            jp.nichicom.vr.util.logging.VRLogger.info(file);
        }
    }

    /**
     * 「スタブ生成」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void stubOutActionPerformed(ActionEvent e) throws Exception {
        // targetsModelを走査して対象の追加・除外条件をマージし、対象とするクラスファイルパスの集合を得る。
        ArrayList<String> files = getTargetFilePathes();

        if (files.isEmpty()) {
            // 対象が存在しない場合、以下の処理を行なう。
            // 以下の設定でメッセージを表示する。
            // 本文：対象のファイルが存在しません。
            // アイコン：感嘆符
            // ボタン：OK
            ACMessageBox.showExclamation("対象のファイルが存在しません。");
            // 処理を終了する。
            return;
        }
        File outDir = new File(getStubOutPath().getText());
        if((outDir==null)||ACTextUtilities.isNullText(getStubOutPath().getText())){
            ACMessageBox.showExclamation("スタブ出力先フォルダが不正です。");
                     // 処理を終了する。
            return;
        }
        
        
        ACSplashable splash = ACFrame.getInstance().getFrameEventProcesser().createSplash("スタブファイル");
        
        HashSet<String> classPathes = new HashSet<String>(); 
        ArrayList<String> classes = new ArrayList<String>();
        
        final String FILE_SEPARATOR = System.getProperty("file.separator");
        final String CLASS_PATH_TOKEN =FILE_SEPARATOR+ "bin"+FILE_SEPARATOR;
        final String REPLACE_TOKEN = FILE_SEPARATOR.replaceAll("\\\\", "\\\\\\\\");
        // 対象のファイルパス集合を走査し、以下の処理を行なう。
        Iterator it = files.iterator();
        while (it.hasNext()) {
            String path= String.valueOf(it.next());
            int pos=path.indexOf(CLASS_PATH_TOKEN);
            if(pos>=0){
                String[] arr = new String[2];
                arr[0] = path.substring(0, pos);
                arr[1] = path.substring(pos+CLASS_PATH_TOKEN.length(),path.length()-6);
                if(arr[1].lastIndexOf("$")>=0){
                    //内部クラスは除外
                    continue;
                }
                if(!classPathes.contains(arr[0])){
                    //新規
                    classPathes.add(arr[0]);
                }
                classes.add(arr[1].replaceAll(REPLACE_TOKEN, "."));
            }
        }
        
        //パスにbinの付加
        ArrayList<String> pathList = new ArrayList<String>();
        it = classPathes.iterator();
        while (it.hasNext()) {
            pathList.add(String.valueOf(it.next()) + CLASS_PATH_TOKEN);
        }

        //jarクラスパスの追加
        it = targetsModel.iterator();
        while (it.hasNext()) {
            VRMap map = (VRMap) it.next();
            if(Integer.parseInt(String.valueOf(VRBindPathParser.get(
                    "TARGET_FILTER", map)))==TARGET_FILTER_ADD){
                // フィルタに追加が指定されていれば、追加用リストに対象ファイル/フォルダを追加する。
                stockClassFile(new File(String.valueOf(VRBindPathParser.get(
                        "TARGET_PATH", map))), pathList, ".jar");
            }
        }

        int end = pathList.size();
        String[] pathes = new String[end];
        for(int i=0; i<end; i++){
            pathes[i] = String.valueOf(pathList.get(i));

            //簡易変換
            pathes[i] = "file:/"+pathes[i].replace('\\', '/');
        }        
        StringBuilder errorBuf = new StringBuilder();
        createStab(pathes, classes, outDir, errorBuf);
        
        if(splash!=null){
            splash.close();
            splash = null;
        }
        
        if(errorBuf.length()>0){
            ACMessageBox.show("スタブファイルを出力しました。以下のエラーがあります。"
                    + System.getProperty("line.separator")
                    + errorBuf.toString());
        }else{
            // 以下の設定でメッセージを表示する。
            ACMessageBox.show("スタブファイルを出力しました。");
        }
    }

    /**
     * 「対象先を参照」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void stubOutPathBroseActionPerformed(ActionEvent e) throws Exception {
        File f;
        ACFileChooser fc = new ACFileChooser();

        // フォルダ選択のみ許可する。
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f = fc.showOpenDialog("対象のフォルダを選択", new String[] { "*" }, "フォルダ");

        // パス選択ダイアログにてパスを選択した場合、選択したパスを「targetPath」に設定する。
        if (f != null) {
            getStubOutPath().setText(f.getAbsolutePath());
        }
    }
    
    
/**
 * スタブファイルを生成します。
 * @param pathes クラスパス配列
 * @param classes スタブ対象クラス集合
 * @param outDir 出力先
 * @throws Exception 処理例外
 */
    public void createStab(String[] pathes, ArrayList<String> classes, File outDir, StringBuilder errorBuf) throws Exception{
        
        URLClassLoader loader = new URLClassLoader(ACClassLoader.toURL(pathes),
                Thread.currentThread().getContextClassLoader());
        
        final String FILE_SEPARATOR = System.getProperty("file.separator");
        final String REPLACE_TOKEN = FILE_SEPARATOR.replaceAll("\\\\", "\\\\\\\\");
        Iterator<String> it = classes.iterator();
        while(it.hasNext()){
            String classsName = String.valueOf(it.next());
            Class c;
            try{
                c = loader.loadClass(classsName);
            }catch(ClassNotFoundException ex){
                errorBuf.append("クラス生成失敗 :");
                errorBuf.append(classsName);
                errorBuf.append(System.getProperty("line.separator"));
                ex.printStackTrace();
                continue;
            }catch(NoClassDefFoundError ex){
                errorBuf.append("クラス未定義 :");
                errorBuf.append(classsName);
                errorBuf.append(System.getProperty("line.separator"));
                ex.printStackTrace();
                continue;
            }
            File f = new File(outDir, c.getName().replaceAll("\\.", REPLACE_TOKEN)+".java");
            if(f.getParent()!=null){
                f.getParentFile().mkdirs();
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(f));
            out.write(getStub(c));
            out.close();
        }
        
    }
    
    
    /**
     * スタブクラスを文字列で返します。
     * @param c クラスオブジェクト
     * @return スタブクラス
     * @throws Exception 処理例外
     */
    public String getStub(Class c) throws Exception{
        final String LINE_SEPARATOR = System.getProperty("line.separator");

        StringBuilder sb = new StringBuilder();
        
        boolean isInteface = c.isInterface();
        String clsName = c.getName();
        // パッケージ定義を解析する。
        Package pkg = c.getPackage();
        String pkgClassName = clsName;
        if (pkg != null) {
            String pkgName = pkg.getName();
            sb.append("package " + pkgName + ";");
            sb.append(LINE_SEPARATOR);
            clsName = clsName.substring(pkgName.length() + 1);
            pkgClassName = pkgName + "." + clsName;
        }
        String classModText =Modifier.toString(c.getModifiers()); 
        if (isInteface) {
            // インターフェース
            sb.append(classModText.replaceFirst(" abstract ", " "));
            sb.append(" ");
        } else {
            // クラス
            sb.append(classModText);
            sb.append(" class ");
        }
        sb.append(clsName);
        sb.append(LINE_SEPARATOR);

        // 親クラス定義を解析する。
        Class parentClass = c.getSuperclass();
        if (Object.class.equals(parentClass)) {
            parentClass = null;
        }
        if (parentClass != null) {
            sb.append("extends ");
            sb.append(parentClass.getName());
            sb.append(LINE_SEPARATOR);
        }

        // インターフェース定義を解析する。
        Class[] is = c.getInterfaces();
        int end = is.length;
        if (end > 0) {
            // 実装インターフェースあり
            if (isInteface) {
                // インターフェース
                sb.append(" extends ");
            } else {
                // クラス
                sb.append(" implements ");
            }
            sb.append(is[0].getName());
            for (int i = 1; i < end; i++) {
                sb.append(",");
                sb.append(is[i].getName());
            }
            sb.append(LINE_SEPARATOR);
        }

        sb.append("{");
        sb.append(LINE_SEPARATOR);

        // アクセス可能なコンストラクタを解析する。
        Constructor[] cons;
        try{
            cons = c.getConstructors();
        }catch(NoClassDefFoundError ex){
            System.out.println("Error Class: " + c);
            throw ex;
        }
        for (int i = 0; i < cons.length; i++) {
            sb.append(getArgumentNaming(cons[i].toString().replaceFirst(
                    pkgClassName, clsName)));
            sb.append("{");
            if (parentClass != null) {
                try{
                    parentClass.getConstructor(new Class[]{});
                } catch (Exception ex) {
                    //デフォルトコンストラクタがない場合
                    Constructor[] parentCons= parentClass.getConstructors();
                    if (parentCons.length > 0) {
                        int parentConsParamSize = parentCons[0]
                                .getParameterTypes().length;
                        int thisConsParamSize = cons[i].getParameterTypes().length;
                        if (thisConsParamSize == 0) {
                            // デフォルトコンストラクタの新設
                            // TODO パラメタクラスに応じてプリミティブ切り替え
                            sb.append("super(null");
                            for (int j = 1; j < parentConsParamSize; j++) {
                                sb.append(",null");
                            }
                            sb.append(");");
                        } else {
                            end = Math.min(thisConsParamSize,
                                    parentConsParamSize);
                            if (end > 0) {
                                sb.append("super(_arg1");
                                for (int j = 1; j < end; j++) {
                                    sb.append(",_arg");
                                    sb.append(j + 1);
                                }
                                sb.append(");");
                            }
                        }
                    }
                }
            }
            sb.append("}");
            sb.append(LINE_SEPARATOR);
        }

        // アクセス可能なフィールドを解析する。
        Field[] field;
        try {
            field = c.getDeclaredFields();
        } catch (NoClassDefFoundError ex) {
            System.out.println("フィールド取得エラー: " + c.toString());
            ex.printStackTrace();
            field = c.getFields();
        }
        for (int i = 0; i < field.length; i++) {
            Field f = field[i];
            String fText = getRemovePackage(f.toString(), pkgClassName);
            if (fText != null) {
                int mod = f.getModifiers();
                if (Modifier.isPrivate(mod)) {
                    continue;
                }
                if (isInteface) {
                    fText = fText.replaceFirst(" abstract ", " ");
                }
                if (Modifier.isFinal(mod)) {
                    // finalあり
                    Class type = f.getType();
                    if (type.isPrimitive()) {
                        String fVal;
                        if(Modifier.isProtected(mod)){
                            if (boolean.class.equals(type)) {
                                fVal = "false";
                            }else{
                                fVal = String.valueOf(i);
                            }
                        }else{
                            if (char.class.equals(type)) {
                                fVal = "'" + f.get(null) + "'";
                            } else {
                                fVal = String.valueOf(f.get(null));
                            }
                        }
                        fText += " = " + fVal;
                    }else if (String.class.equals(type)&&(!Modifier.isProtected(mod))&&(fText.indexOf(" static ")>=0)) {
                        fText += " = \""
                                + String.valueOf(f.get(null)).replaceAll(
                                        "\\\\", "\\\\\\\\").replaceAll("\t",
                                        "\\\\t").replaceAll("\r", "\\\\r")
                                        .replaceAll("\n", "\\\\n") + "\"";
                    } else {
                        fText += " = null";
                    }
                }
                sb.append(fText + ";");
                sb.append(LINE_SEPARATOR);
            }
        }

        // アクセス可能なメンバメソッドを解析する。
        Method[] method;
        try {
            method = c.getDeclaredMethods();
        } catch (NoClassDefFoundError ex) {
            System.out.println("メソッド取得エラー: " + c.toString());
            ex.printStackTrace();
            method = c.getMethods();
        }
        for (int i = 0; i < method.length; i++) {
            Method m = method[i];
            String mText = getRemovePackage(m.toString(), pkgClassName);
            if (mText != null) {
                int mod = m.getModifiers();
                if (Modifier.isPrivate(mod)) {
                    continue;
                }
                if (isInteface) {
                    mText = mText.replaceFirst(" abstract ", " ");
                }
                sb.append(getArgumentNaming(mText));
                if (isInteface) {
                    sb.append(";");
                } else if(mText.indexOf(" abstract ")>=0){
                    sb.append(";");
                } else {
                    sb.append("{");
                    Class type = m.getReturnType();
                    sb.append("Object v=null;int i=0;for(;i<10;i*=2)v=new Integer((int)Math.random()*100);");
                    if (!void.class.equals(type)) {
                        if (type.isPrimitive()) {
                            if (boolean.class.equals(type)) {
                                sb.append("if(((Integer)v).intValue()>10)return true;");
                                sb.append("return false;");
                            } else {
                                sb.append("return (char)((Integer)v).intValue();");
                            }
                        } else {
                            if(type.isArray()){
                                String retType = type.getName();
                                Matcher mch = Pattern.compile("^.*[^ ]* (([^\\]]*\\])*) [^(]*\\(.*$").matcher(mText); 
                                if(mch.find()){
                                    if(mch.groupCount()>0){
                                        retType = mch.group(1);
                                    }
                                }
                                sb.append("return ("+retType+")v;");
                            }else{
                                sb.append("return ("+type.getName().replaceAll("\\$",".")+")v;");
                            }
//                            sb.append("return null;");
                        }
                    }
                    sb.append("}");
                }
                sb.append(LINE_SEPARATOR);
            }
        }

        sb.append("}");
        sb.append(LINE_SEPARATOR);

        // 解析結果を返す。
        return sb.toString();
    }
    /**
     * 関数コードからパッケージ名を除外して返します。
     * @param functionCode 関数コード
     * @param packageName パッケージ名
     * @return 変換結果
     * @throws Exception 処理例外
     */
    protected String getRemovePackage(String functionCode, String packageName) throws Exception{
        int hesesPos =functionCode.lastIndexOf("(");
        int pos;
        if(hesesPos<0){
            pos = functionCode.lastIndexOf(packageName+".");
        }else{
            pos =functionCode.lastIndexOf(packageName+".", hesesPos);
            if(pos>=0){
                if (functionCode.matches(".*"+packageName
                        .replaceAll("\\.", "\\\\.")
                        + "[^ ,$]*\\$.*")) {
                    //内部クラス関数
                    return null;
                }
//                int innerPos = functionCode.indexOf('$');//, pos+packageName.length());
//                if(innerPos>0){
//                    //内部クラス関数
//                    return null;
//                }
            }
        }
        if(pos>=0){
            return functionCode.substring(0,pos)+functionCode.substring(pos+packageName.length()+1);
        }
        return null;
    }
    /**
     * 関数コードに引数名を付加して返します。
     * @param functionCode 関数コード 
     * @return 変換結果
     * @throws Exception 処理例外
     */
    protected String getArgumentNaming(String functionCode) throws Exception{
        StringBuilder sb = new StringBuilder();

        String[] args = functionCode.replaceAll("\\$", ".").split("\\)", 2);
        String head =args[0];
        String foot = args[1];
        args = head.split("\\(", 2);
        head = args[0];

        sb.append(head);
        sb.append("(");
        if(!"".equals(args[1].trim())){
            //引数あり
            args = args[1].split(",");
            sb.append(args[0]);
            sb.append(" _arg1");

            int end = args.length;
                for (int i = 1; i < end; i++) {
                sb.append(",");
                sb.append(args[i]);
                sb.append(" _arg" + (i + 1));
            }
        }
        sb.append(")");
        sb.append(foot);
        
        return sb.toString();
    }
}
