
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
 */

package jp.or.med.orca.qkan.affair.qm.qm001;

import jp.nichicom.ac.sql.ACDBManager;

/**
 * システムから登録可能なマスタの補正用タスククラス
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
            // 予防版タスク
            task1(dbm);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    /**
     * 郵便番号テーブルのPRIMARY KEY削除
     * @param dbm DBManager
     * @throws Exception
     */
    public void task1(ACDBManager dbm) throws Exception{

        try{ 
            QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();
            
            // 郵便番号テーブルのPRIMARY KEY削除実行
            op.dropPostPrimaryKey(dbm);
            
            // コミット
            dbm.commitTransaction();
                
            
        }catch(Exception ex){
            dbm.rollbackTransaction();
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
