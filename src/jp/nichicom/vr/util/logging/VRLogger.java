/** TODO <HEAD> */
package jp.nichicom.vr.util.logging;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

/**
 * ログ出力を補助するクラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/10/31
 * @see Logger
 * @see Level
 */
public class VRLogger {
    /**
     * シンプルなテキスト出力をあらわすファイル形式定数です。
     */
    public static final int FILE_FORMAT_SIMPLE = 0;

    /**
     * XML出力をあらわすファイル形式定数です。
     */
    public static final int FILE_FORMAT_XML = 1;

    private static int fileFormat = FILE_FORMAT_SIMPLE;

    private static FileHandler fileHandler;

    private static int lastDate;

    private static String path;

    private static Logger singleton;
    
    private static int stockDayCount;
    
    /**
     * 静的初期化を行います。
     */
    static {
        singleton = Logger.getLogger(VRLogger.class.getName());
        setLevel(Level.INFO);
        setStockDayCount(30);
        //実行パス直下のlogsフォルダへ出力
        try {
            setPath("logs");
        } catch (IOException ex) {
        }
    }
    
    /**
     * ファイルハンドラを開放します。
     */
    public static void close() {
        if (getFileHandler() != null) {
            getFileHandler().close();
            setFileHandler(null);
        }
    }

    /**
     * CONFIGレベルでログを出力します。
     * 
     * @param o データ
     */
    public static void config(Object o) {
        log(Level.CONFIG, o);
    }

    /**
     * FINEレベルでログを出力します。
     * 
     * @param o データ
     */
    public static void fine(Object o) {
        log(Level.FINE, o);
    }

    /**
     * FINERレベルでログを出力します。
     * 
     * @param o データ
     */
    public static void finer(Object o) {
        log(Level.FINER, o);
    }

    /**
     * FINESTレベルでログを出力します。
     * 
     * @param o データ
     */
    public static void finest(Object o) {
        log(Level.FINEST, o);
    }

    /**
     * ファイル出力形式 を返します。
     * @return fileFormat ファイル出力形式
     * @see #FILE_FORMAT_SIMPLE
     * @see #FILE_FORMAT_XML
     */
    public static int getFileFormat() {
        return fileFormat;
    }

    /**
     * 出力レベルを返します。
     * 
     * @return 出力レベル
     */
    public static Level getLevel() {
        return getInstance().getLevel();
    }

    /**
     * 出力フォルダパスを返します。
     * 
     * @return 出力フォルダパス
     */
    public static String getPath() {
        return path;
    }

    /**
     * 保存期限日数を返します。
     * 
     * @return 保存期限日数
     */
    public static int getStockDayCount() {
        return stockDayCount;
    }

    /**
     * INFOレベルでログを出力します。
     * 
     * @param o データ
     */
    public static void info(Object o) {
        log(Level.INFO, o);
    }

    /**
     * ログを出力します。
     * 
     * @param l 出力レベル
     * @param o データ
     */
    public static void log(Level l, Object o) {
        Logger logger = getInstance();
        int paramLVal = l.intValue();
        int loggerLVal = logger.getLevel().intValue();
        //閾値チェック
        if ((paramLVal < loggerLVal) || (loggerLVal == Level.OFF.intValue())) {
            return;
        }

        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH) + 1;
        int d = cal.get(Calendar.DATE);
        int date = y * 10000 + m * 100 + d;

        try {
            //日にちが変わっていたらファイルハンドラを更新
            if ((getFileHandler() == null) || (date != getLastDate())) {
                //出力日付を更新
                setLastDate(date);
                refleshFileHandler();
                removeHistory();
            }

            logger.log(l, o.toString());
        } catch (IOException ex) {
            //ログ出力失敗
        }
    }

    /**
     * ファイルハンドラを再生成します。
     * @throws IOException 処理例外
     */
    public static void refleshFileHandler() throws IOException{
        Logger logger = getInstance();
        //既存のハンドラを削除
        if (getFileHandler() != null) {
            logger.removeHandler(getFileHandler());
        }

        Formatter fmt;
        String encoding = null;
        switch(getFileFormat()){
        case FILE_FORMAT_XML:
            fmt = new XMLFormatter();
            encoding = "UTF-8";
            break;
        default:
            fmt = new SimpleFormatter();
            break;
        }
        
        setFileHandler( new FileHandler(getPath()
                + System.getProperty("file.separator")
                + String.valueOf(getLastDate()) + getFileFormatExt(), true));
        getFileHandler().setFormatter(fmt);
        if(encoding!=null){
            getFileHandler().setEncoding(encoding);
        }
        logger.addHandler(getFileHandler());

    }

    /**
     * 削除期限を基準に出力済みの履歴を削除します。
     * @see #getStockDayCount
     */
    public static void removeHistory(){
        Calendar cal = Calendar.getInstance();
        int stock = getStockDayCount();
        if (stock > 0) {
            //削除期限が0より大きければ、過去ログ削除
            cal.add(Calendar.DATE, -stock);
            int y = cal.get(Calendar.YEAR);
            int m = cal.get(Calendar.MONTH) + 1;
            int d = cal.get(Calendar.DATE);
            int date = y * 10000 + m * 100 + d;

            String ext = getFileFormatExt();
            File[] files = new File(getPath()).listFiles();
            int count = files.length;
            for (int i = 0; i < count; i++) {
                if (files[i].isFile()) {
                    try {
                        String fileName = files[i].getName();
                        if (fileName.indexOf(ext) > 0) {
                            int nameDate = Integer.parseInt(fileName
                                    .split(ext, 2)[0]);
                            if (nameDate < date) {
                                files[i].delete();
                            }
                        }
                    } catch (Throwable ex) {
                    }
                }
            }
        }
        
    }

    /**
     * ファイル出力形式 を設定します。
     * @param fileFormat ファイル出力形式
     * @see #FILE_FORMAT_SIMPLE
     * @see #FILE_FORMAT_XML
     */
    public static void setFileFormat(int fileFormat) {
        VRLogger.fileFormat = fileFormat;
    }

    /**
     * 出力レベルを設定します。
     * 
     * @param l 出力レベル
     */
    public static void setLevel(Level l) {
        getInstance().setLevel(l);
    }
    
    /**
     * 出力フォルダパスを設定します。
     * 
     * @param path 出力フォルダパス
     * @throws IOException フォルダ生成失敗
     */
    public static void setPath(String path) throws IOException {
        VRLogger.path = path;

        File f = new File(getPath());
        if (!f.exists()) {
            if (!f.mkdir()) {
                throw new IOException(getPath() + "を作成できません。");
            }
        }

    }
    
    /**
     * 保存期限日数を設定します。
     * 
     * @param stockDayCount 保存期限日数
     */
    public static void setStockDayCount(int stockDayCount) {
        if (stockDayCount < 0) {
            return;
        }
        VRLogger.stockDayCount = stockDayCount;
    }
    
    /**
     * SEVEREレベルでログを出力します。
     * 
     * @param o データ
     */
    public static void severe(Object o) {
        log(Level.SEVERE, o);
    }

    /**
     * WARNINGレベルでログを出力します。
     * 
     * @param o データ
     */
    public static void warning(Object o) {
        log(Level.WARNING, o);
    }

    /**
     * ファイル出力形式に対応した拡張子を返します。
     * <p>
     * "."を含みます。
     * </p>
     * @return 拡張子
     */
    protected static String getFileFormatExt(){
        switch(getFileFormat()){
        case FILE_FORMAT_XML:
            return ".xml";
        default:
            return ".log";
        }  
    }

    /**
     * 出力ファイルハンドラ を返します。
     * @return 出力ファイルハンドラ
     */
    protected static FileHandler getFileHandler() {
        return fileHandler;
    }

    /**
     * 唯一のインスタンスを返します。 <br />
     * Singleton Pattern
     * 
     * @return インスタンス
     */
    protected static Logger getInstance() {
        return singleton;
    }

    /**
     * 最終出力日時 を返します。
     * @return 最終出力日時
     */
    protected static int getLastDate() {
        return lastDate;
    }

    /**
     * 出力ファイルハンドラ を設定します。
     * @param fileHandler 出力ファイルハンドラ
     */
    protected static void setFileHandler(FileHandler fileHandler) {
        VRLogger.fileHandler = fileHandler;
    }

    /**
     * 最終出力日時 を設定します。
     * @param lastDate 最終出力日時
     */
    protected static void setLastDate(int lastDate) {
        VRLogger.lastDate = lastDate;
    }

    /**
     * コンストラクタ
     */
    protected VRLogger() {
    }

    public void finalize(){
        close();
    }

}