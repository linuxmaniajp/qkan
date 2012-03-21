/*
 * 作成日: 2006/06/08
 *
 */
package jp.or.med.orca.qkan.affair.qm.qm001;

import jp.nichicom.ac.sql.ACDBManager;

/**
 * システムから登録可能なマスタの補正用タスククラス
 * 
 * @author n0153
 * 
 */
public class QM001UpdateMasterTask {
    // マスタバージョン
    public String version = "";

    /**
     * コンストラクタ
     */
    public QM001UpdateMasterTask() {
    }

    /**
     * コンストラクタ
     */
    public QM001UpdateMasterTask(String version) {
        setVersion(version);
    }

    /**
     * バージョン補正タスク管理
     * 
     * @param dbm
     * @throws Exception
     */
    public void adjustTask(ACDBManager dbm) throws Exception {

        try {

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return this.version;
    }

}
