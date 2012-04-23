
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

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * システムから登録可能なマスタの補正用操作クラス
 * 
 */
public class QM001UpdateMasterOperation {

    /**
     * コンストラクタ
     */
    public QM001UpdateMasterOperation() {
    }

    /**
     * マスタバージョンを取得します。
     * 
     * @param dbm
     * @return version マスタバージョン
     * @throws Exception
     */
    protected String getVersion(ACDBManager dbm) throws Exception {

        String version = "";

        try {
            VRList result = dbm.executeQuery(getSQL_GET_QKAN_VERSION(null));
            version = ACCastUtilities.toString(VRBindPathParser.get(
                    "MASTER_DATA_VERSION", (VRMap) result.get(0)));
        } catch (Exception ex) {
            throw ex;
        }

        return version;

    }

    protected void updateVersion(ACDBManager dbm, String version)
            throws Exception {

        try {
            VRMap param = new VRHashMap();
            VRBindPathParser.set("MASTER_DATA_VERSION", param, version);
            dbm.executeUpdate(getSQL_UPDATE_MASTER_VERSION(param));
        } catch (Exception ex) {
            throw ex;
        }

    }

    /**
     * 郵便番号テーブルのPRIMARY KEY削除
     * 
     * @throws Exception
     */
    protected void dropPostPrimaryKey(ACDBManager dbm) throws Exception {

        try {

            VRMap sqlParam = new VRHashMap();
            VRBindPathParser.set("TABLE_NAME", sqlParam, "M_POST");

            // M_POSTのPRIMARY KEY名を取得
            VRList result = dbm.executeQuery(getSQL_PRIMARY_KEY_NAME(sqlParam));
            
            // PRIMARY KEYが設定されている場合は、drop
            if (0 < result.size()) {
                String primaryKeyName = ACCastUtilities.toString(((VRMap)result.get(0)).get("PRIMARY_KEY_NAME"), null);
                primaryKeyName = ACTextUtilities.trim(primaryKeyName);
                
                // null取得の場合は処理終了
                if (ACTextUtilities.isNullText(primaryKeyName)) {
                    return;
                }
                
                // primary key削除実行
                VRBindPathParser.set("PRIMARY_KEY_NAME", sqlParam, primaryKeyName);
                dbm.executeUpdate(getSQL_DROP_PRIMARY_KEY(sqlParam));
            }
            
            
            // m_postにindexが存在するか確認
            sqlParam = new VRHashMap();
            VRBindPathParser.set("INDEX_NAME", sqlParam, "IDX_M_POST");
            result = dbm.executeQuery(getSQL_INDEX_EXISTS(sqlParam));
            
            // indexが存在しない場合は、作成
            if (result.size() <= 0) {
                // index 付与
                dbm.executeUpdate(getSQL_CREATE_INDEX_M_POST(null));
            }
            
            
        } catch (Exception ex) {
            throw ex;
        }

    }

    /**
     * 「給付管理台帳システムの」のためのSQLを返します。
     * 
     * @param sqlParam
     *            SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception
     *             処理例外
     * @return SQL文
     */
    public String getSQL_GET_QKAN_VERSION(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT");

        sb.append(" MASTER_DATA_VERSION");

        sb.append(",SCHEME_VERSION");

        sb.append(" FROM");

        sb.append(" M_QKAN_VERSION");

        return sb.toString();
    }

    /**
     * 「マスタバージョン更新」のためのSQLを返します。
     * 
     * @param sqlParam
     *            SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception
     *             処理例外
     * @return SQL文
     */
    public String getSQL_UPDATE_MASTER_VERSION(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("UPDATE");

        sb.append(" M_QKAN_VERSION");

        sb.append(" SET");

        sb.append(" MASTER_DATA_VERSION");

        sb.append(" =");

        sb.append(ACSQLSafeStringFormat.getInstance().format(
                VRBindPathParser.get("MASTER_DATA_VERSION", sqlParam)));

        sb.append(",");

        sb.append(" LAST_TIME");

        sb.append(" =");

        sb.append(" CURRENT_TIMESTAMP");

        return sb.toString();
    }

    /**
     * 指定したテーブルのプライマリキー名称を取得
     * 
     * @param sqlParam
     *            SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception
     *             処理例外
     * @return SQL文
     */
    public String getSQL_PRIMARY_KEY_NAME(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT");
        sb.append(" RDB$CONSTRAINT_NAME AS PRIMARY_KEY_NAME");
        sb.append(" FROM");
        sb.append(" RDB$RELATION_CONSTRAINTS");
        sb.append(" WHERE");
        sb.append(" (RDB$RELATION_NAME =");
        sb.append(ACSQLSafeStringFormat.getInstance().format(
                VRBindPathParser.get("TABLE_NAME", sqlParam)));
        sb.append(")");
        sb.append(" AND (RDB$CONSTRAINT_TYPE = 'PRIMARY KEY')");

        return sb.toString();
    }

    /**
     * 指定したテーブルのプライマリキーを削除
     * 
     * @param sqlParam
     *            SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception
     *             処理例外
     * @return SQL文
     */
    public String getSQL_DROP_PRIMARY_KEY(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("ALTER TABLE ");
        sb.append(VRBindPathParser.get("TABLE_NAME", sqlParam));
        sb.append(" DROP CONSTRAINT ");
        sb.append(VRBindPathParser.get("PRIMARY_KEY_NAME", sqlParam));

        return sb.toString();
    }
    
    /**
     * 指定したテーブルのプライマリキー名称を取得
     * 
     * @param sqlParam
     *            SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception
     *             処理例外
     * @return SQL文
     */
    public String getSQL_INDEX_EXISTS(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * FROM");
        sb.append(" RDB$INDICES");
        sb.append(" WHERE");
        sb.append(" (RDB$INDEX_NAME =");
        sb.append(ACSQLSafeStringFormat.getInstance().format(
                VRBindPathParser.get("INDEX_NAME", sqlParam)));
        sb.append(")");

        return sb.toString();
    }
    
    /**
     * M_POSTのPOST_CDにインデックスを付与する
     * 
     * @param sqlParam
     *            SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception
     *             処理例外
     * @return SQL文
     */
    public String getSQL_CREATE_INDEX_M_POST(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("CREATE INDEX IDX_M_POST ON M_POST (POST_CD)");

        return sb.toString();
    }    
}
