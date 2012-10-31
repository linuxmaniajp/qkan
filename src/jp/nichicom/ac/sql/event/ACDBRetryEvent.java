package jp.nichicom.ac.sql.event;

import java.sql.SQLException;
import java.util.EventObject;

/**
 * DB再試行イベント情報です。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/06/28
 */
public class ACDBRetryEvent extends EventObject {
    private SQLException exception;
    private int tryCount;

    /**
     * コンストラクタです。
     * 
     * @param source イベント発生元
     * @param ex 発生した例外
     */
    public ACDBRetryEvent(Object source, SQLException ex) {
        this(source, ex, 1);

    }

    /**
     * /** コンストラクタです。
     * 
     * @param source イベント発生元
     * @param ex 発生した例外
     * @param tryCount 試行回数
     */
    public ACDBRetryEvent(Object source, SQLException ex, int tryCount) {
        super(source);
        setException(ex);
        setTryCount(tryCount);
    }

    /**
     * 発生した例外 を返します。
     * 
     * @return 発生した例外
     */
    public SQLException getException() {
        return exception;
    }

    /**
     * 発生した例外 を設定します。
     * 
     * @param exception 発生した例外
     */
    protected void setException(SQLException exception) {
        this.exception = exception;
    }

    /**
     * 試行回数 を返します。
     * 
     * @return 試行回数
     */
    public int getTryCount() {
        return tryCount;
    }

    /**
     * 試行回数 を設定します。
     * 
     * @param tryCount 試行回数
     */
    protected void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

}
