package jp.nichicom.ac.sql.event;

import java.util.EventListener;

/**
 * DBのクエリ再試行可否を判断するインタフェースです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/06/28
 */
public interface ACDBRetryListener extends EventListener {
    /**
     * 更新のSQLで例外が発生した場合に再試行を行うかを返します。
     * 
     * @param e イベント情報
     * @return 再試行を行うか
     */
    public boolean canRetryUpdate(ACDBRetryEvent e);

    /**
     * 検索のSQLで例外が発生した場合に再試行を行うかを返します。
     * 
     * @param e イベント情報
     * @return 再試行を行うか
     */
    public boolean canRetryQuery(ACDBRetryEvent e);

}
