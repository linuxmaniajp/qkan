package jp.nichicom.ac.sql.event;

import jp.nichicom.vr.util.logging.VRLogger;
/**
 * 一定時間待って再試行する基本的なDB再試行リスナです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/06/28
 */
public class ACDefaultDBRetryListener implements ACDBRetryListener {
    private int queryTryCount = 0;
    private long queryWaitTime = 1000;
    private int updateTryCount = 3;
    private long updateWaitTime = 1000;
    
    
    /**
     * コンストラクタです。<br/>
     * それぞれ以下の通り初期化されます。<br/>
     * ・更新再試行回数(updateTryCount) = 3<br/>
     * ・更新再試行の待ち時間(ms)(updateWaitTime) = 1000<br/>
     * ・検索再試行回数(queryTryCount) = 0<br/>
     * ・検索再試行の待ち時間(ms)(queryWaitTime) = 1000<br/>
     */
    public ACDefaultDBRetryListener() {
        this(3,1000,0,1000);
    }
    /**
     * コンストラクタです。<br/>
     * それぞれ以下の通り初期化されます。<br/>
     * ・更新再試行の待ち時間(ms)(updateWaitTime) = 1000<br/>
     * ・検索再試行回数(queryTryCount) = 0<br/>
     * ・検索再試行の待ち時間(ms)(queryWaitTime) = 1000<br/>
     * @param updateTryCount 更新再試行回数
     */
    public ACDefaultDBRetryListener(int updateTryCount) {
        this(updateTryCount,1000,0,1000);
    }
    /**
     * コンストラクタです。<br/>
     * それぞれ以下の通り初期化されます。<br/>
     * ・検索再試行回数(queryTryCount) = 0<br/>
     * ・検索再試行の待ち時間(ms)(queryWaitTime) = 1000<br/>
     * @param updateTryCount 更新再試行回数
     * @param updateWaitTime 更新再試行の待ち時間(ms)
     */
    public ACDefaultDBRetryListener(int updateTryCount, long updateWaitTime) {
        this(updateTryCount,updateWaitTime,0,1000);
    }
    /**
     * コンストラクタです。
     * @param updateTryCount 更新再試行回数
     * @param updateWaitTime 更新再試行の待ち時間(ms)
     * @param queryTryCount 検索再試行回数(queryTryCount)
     * @param queryWaitTime 検索再試行の待ち時間(ms)
     */
    public ACDefaultDBRetryListener(int updateTryCount, long updateWaitTime, int queryTryCount, long queryWaitTime) {
        super();
        
    }
    public boolean canRetryQuery(ACDBRetryEvent e) {
        if (e.getTryCount() < getQueryTryCount()) {
            try {
                Thread.sleep(getQueryWaitTime());
                return true;
            } catch (Throwable ex) {
                VRLogger.info(ex);
            }
        }
        return false;
    }
    public boolean canRetryUpdate(ACDBRetryEvent e) {
        if (e.getTryCount() < getUpdateTryCount()) {
            try {
                Thread.sleep(getUpdateWaitTime());
                return true;
            } catch (Throwable ex) {
                VRLogger.info(ex);
            }
        }
        return false;
    }
    /**
     * 検索再試行回数 を返します。
     * @return 検索再試行回数
     */
    public int getQueryTryCount() {
        return queryTryCount;
    }
    /**
     * 検索再試行の待ち時間(ms) を返します。
     * @return 検索再試行の待ち時間(ms)
     */
    public long getQueryWaitTime() {
        return queryWaitTime;
    }
    /**
     * 更新再試行回数 を返します。
     * @return 更新再試行回数
     */
    public int getUpdateTryCount() {
        return updateTryCount;
    }
    /**
     * 更新再試行の待ち時間(ms) を返します。
     * @return 更新再試行の待ち時間(ms)
     */
    public long getUpdateWaitTime() {
        return updateWaitTime;
    }
    /**
     * 検索再試行回数 を設定します。
     * @param queryTryCount 検索再試行回数
     */
    public void setQueryTryCount(int queryTryCount) {
        this.queryTryCount = queryTryCount;
    }
    /**
     * 検索再試行の待ち時間(ms) を設定します。
     * @param queryWaitTime 検索再試行の待ち時間(ms)
     */
    public void setQueryWaitTime(long queryWaitTime) {
        this.queryWaitTime = queryWaitTime;
    }

    /**
     * 更新再試行回数 を設定します。
     * @param updateTryCount 更新再試行回数
     */
    public void setUpdateTryCount(int updateTryCount) {
        this.updateTryCount = updateTryCount;
    }

    /**
     * 更新再試行の待ち時間(ms) を設定します。
     * @param updateWaitTime 更新再試行の待ち時間(ms)
     */
    public void setUpdateWaitTime(long updateWaitTime) {
        this.updateWaitTime = updateWaitTime;
    }

}
