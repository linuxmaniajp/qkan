package jp.nichicom.ac.sql;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.EventListener;

import javax.swing.event.EventListenerList;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.core.debugger.ACFrameEventDebugger;
import jp.nichicom.ac.sql.event.ACDBRetryEvent;
import jp.nichicom.ac.sql.event.ACDBRetryListener;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.logging.VRLogger;

/**
 * ログ出力を行なうDBマネージャラッパです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/01/24
 */
public class ACLoggerDBManager implements ACDBManager {
    private ACDBManager adaptee;
    private boolean printExceptionSQL = true;
    protected EventListenerList listenerList = new EventListenerList();

    /**
     * 指定クラスタイプと一致するイベントリスナ配列を返します。
     * @param listenerType クラスタイプ 
     * @return イベントリスナ配列
     */
    public EventListener[] getListeners(Class listenerType) {
        EventListener[] result = null;
        if(listenerList!=null){
            result = listenerList.getListeners(listenerType);
        }else{
            result = (EventListener[])Array.newInstance(listenerType, 0);; 
        }
        return result;
    }
    /**
     * 再試行イベントリスナを追加します。
     * @param listener 再試行イベントリスナ
     */
    public void addDBRetryListener(ACDBRetryListener listener) {
        listenerList.add(ACDBRetryListener.class, listener);
    }

    /**
     * 再試行イベントリスナを除外します。
     * @param listener 再試行イベントリスナ
     */
    public void removeDBRetryListener(ACDBRetryListener listener) {
        listenerList.remove(ACDBRetryListener.class, listener);
    }

    /**
     * 再試行イベントリスナを返します。
     * 
     * @return 再試行イベントリスナ
     */
    public synchronized ACDBRetryListener[] getDBRetryListeners() {
        return (ACDBRetryListener[]) (getListeners(ACDBRetryListener.class));
    }

    /**
     * 再試行イベントリスナを全走査してcanRetryUpdateイベントを呼び出します。
     * 
     * @param e イベント情報
     */
    protected boolean canRetryUpdate(ACDBRetryEvent e){
        ACDBRetryListener[] listeners = getDBRetryListeners();
        for (int i = 0; i < listeners.length; i++) {
            if(listeners[i].canRetryUpdate(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 再試行イベントリスナを全走査してcanRetryQueryイベントを呼び出します。
     * 
     * @param e イベント情報
     */
    protected boolean canRetryQuery(ACDBRetryEvent e){
        ACDBRetryListener[] listeners = getDBRetryListeners();
        for (int i = 0; i < listeners.length; i++) {
            if(listeners[i].canRetryQuery(e)){
                return true;
            }
        }
        return false;
    }
    /**
     * コンストラクタです。
     */
    public ACLoggerDBManager() {
        super();
    }

    /**
     * コンストラクタです。
     * 
     * @param dbm ラップするDBマネージャ
     */
    public ACLoggerDBManager(ACDBManager dbm) {
        super();
        setAdaptee(dbm);
    }

    public void beginTransaction() throws SQLException {
        logOfDB("beginTransaction");
        adaptee.beginTransaction();
    }

    public boolean canConnect() throws Exception {
        logOfDB("canConnect");
        return adaptee.canConnect();
    }

    public void commitTransaction() throws SQLException {
        logOfDB("commitTransaction");
        adaptee.commitTransaction();
    }

    public VRList executeQuery(String sql) throws SQLException {
        logOfDB("executeQuery: " + sql);
        VRList result = null;
        try {
            result = adaptee.executeQuery(sql);
        } catch (SQLException ex) {
            //2006/06/28 add-begin Tozo TANAKA Firebirdのデッドロック対応のため
            boolean throwException = true;
            int tryCount = 1;
            SQLException tryEx = ex;
            while (canRetryQuery(new ACDBRetryEvent(this, tryEx, tryCount++))) {
                try {
                    result = adaptee.executeQuery(sql);
                    // 再試行で成功した場合はループを抜け出す
                    throwException = false;
                    break;
                } catch (SQLException ex2) {
                    tryEx = ex2;
                }
            }
            //2006/06/28 add-end Tozo TANAKA Firebirdのデッドロック対応のため
            
            if (throwException) {
                if (isPrintExceptionSQL()) {
                    // 例外を起こしたSQL文も出力
                    throw new SQLException(sql + ACConstants.LINE_SEPARATOR
                            + ex.toString());
                } else {
                    throw ex;
                }
            }
        }
        logOfDB(result);
        return result;
    }

    public int executeUpdate(String sql) throws SQLException {
        logOfDB("executeUpdate: " + sql);
        try {
            return adaptee.executeUpdate(sql);
        } catch (SQLException ex) {
            //2006/06/28 add-begin Tozo TANAKA Firebirdのデッドロック対応のため
            int tryCount = 1;
            SQLException tryEx = ex;
            while (canRetryUpdate(new ACDBRetryEvent(this, tryEx, tryCount++))) {
                try {
                    return adaptee.executeUpdate(sql);
                } catch (SQLException ex2) {
                    tryEx = ex2;
                }
            }
            //2006/06/28 add-end Tozo TANAKA Firebirdのデッドロック対応のため
            
            
            if (isPrintExceptionSQL()) {
                // 例外を起こしたSQL文も出力
                throw new SQLException(sql + ACConstants.LINE_SEPARATOR
                        + ex.toString());
            } else {
                throw ex;
            }
        }
    }

    /**
     * ラップするDBManager を返します。
     * 
     * @return ラップするDBManager
     */
    public ACDBManager getAdaptee() {
        return adaptee;
    }

    /**
     * 例外を起こしたSQL文もラップして出力するか を返します。
     * 
     * @return 例外を起こしたSQL文もラップして出力するか
     */
    public boolean isPrintExceptionSQL() {
        return printExceptionSQL;
    }

    public void rollbackTransaction() throws SQLException {
        logOfDB("rollbackTransaction");
        adaptee.rollbackTransaction();
    }

    /**
     * ラップするDBManager を設定します。
     * 
     * @param dbm ラップするDBManager
     */
    public void setAdaptee(ACDBManager dbm) {
        this.adaptee = dbm;
    }

    /**
     * 例外を起こしたSQL文もラップして出力するか を設定します。
     * 
     * @param printExceptionSQL 例外を起こしたSQL文もラップして出力するか
     */
    public void setPrintExceptionSQL(boolean printExceptionSQL) {
        this.printExceptionSQL = printExceptionSQL;
    }

    /**
     * ログメッセージを出力します。
     * 
     * @param message メッセージ
     */
    protected void logOfDB(String message) {
        ACFrameEventProcesser eventProcesser = ACFrame.getInstance()
                .getFrameEventProcesser();
        if (eventProcesser instanceof ACFrameEventDebugger) {
            VRLogger.log(((ACFrameEventDebugger) eventProcesser)
                    .getDBLogLevel(), message);
        }
    }

    /**
     * 取得したレコード内容をログ出力します。
     * 
     * @param recode 取得したレコード内容
     */
    protected void logOfDB(VRList recode) {
        ACFrameEventProcesser eventProcesser = ACFrame.getInstance()
                .getFrameEventProcesser();
        if (eventProcesser instanceof ACFrameEventDebugger) {
            if ((((ACFrameEventDebugger) eventProcesser).getDBLogRange() & ACFrameEventDebugger.LOG_RANGE_DB_QUERY_RESULT) != 0) {
                VRLogger.log(((ACFrameEventDebugger) eventProcesser)
                        .getDBLogLevel(), "queryResult: "
                        + String.valueOf(recode));
            }
        }
    }

}
