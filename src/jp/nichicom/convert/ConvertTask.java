package jp.nichicom.convert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jp.nichicom.convert.util.DBConnect;
import jp.nichicom.convert.util.Log;

/**
 * 給管鳥 V5 => V6 コンバートタスク
 * 
 * @version 1.00 2011.11.25
 * @author shin fujihara
 */
public class ConvertTask implements Runnable {

    private MainFrame frame = null;
    private DBConnect from = null;
    private DBConnect to = null;
    
    private Set<Integer> providerServiceId = null;
    private Set<Integer> kohiType = null;

    public void putTask(MainFrame frame, DBConnect from, DBConnect to) {
        this.frame = frame;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        
        // 単純移行するテーブルリスト
        Map<String, String> tableListSimple = new LinkedHashMap<String, String>();
        
        tableListSimple.put("FIXED_FORM", "定型文");
        tableListSimple.put("INSURER", "保険者");
//        tableListSimple.put("INSURER_LIMIT_RATE", "保険者単価");
//        tableListSimple.put("INSURER_LIMIT_RATE_DETAIL", "保険者単価詳細");
        
        tableListSimple.put("PATIENT", "利用者");
        tableListSimple.put("PATIENT_CHANGES_HISTORY", "利用者変更履歴");
        tableListSimple.put("PATIENT_NINTEI_HISTORY", "利用者認定履歴");
        tableListSimple.put("PATIENT_SHISETSU_HISTORY", "利用者施設履歴");
        
        tableListSimple.put("PROVIDER", "事業所");
        tableListSimple.put("PROVIDER_MENU", "事業所メニュー");
        tableListSimple.put("PROVIDER_SERVICE", "事業所提供サービス");
        tableListSimple.put("STAFF", "スタッフ");
        tableListSimple.put("MEDICAL_FACILITY", "医療機関情報");
        
        tableListSimple.put("HOMONKANGO_JOHO_TEIKYOSHO", "訪問看護の情報提供書");
        tableListSimple.put("HOMONKANGO_KIROKUSHO", "訪問看護記録書Ｉ");
        tableListSimple.put("HOMONKANGO_PLAN", "訪問看護計画書");
        tableListSimple.put("HOMONKANGO_PLAN_NOTE", "訪問看護計画書詳細");
        tableListSimple.put("HOMONKANGO_RESULT", "訪問看護報告書");
        tableListSimple.put("HOMONKANGO_RESULT_CALENDAR", "訪問看護報告書詳細");
        tableListSimple.put("KYOTAKU_RYOYO", "居宅療養管理指導書");
        
        // 事業所のバインドパスを変換しながら移行するテーブル
        Map<String, String> tableListProviderDetail = new LinkedHashMap<String, String>();
        tableListProviderDetail.put("PROVIDER_SERVICE_DETAIL_DATE", "事業所提供サービス詳細１");
        tableListProviderDetail.put("PROVIDER_SERVICE_DETAIL_TEXT", "事業所提供サービス詳細２");
        tableListProviderDetail.put("PROVIDER_SERVICE_DETAIL_INTEGER", "事業所提供サービス詳細３");
        
        
        // 現在有効な公費情報のみ移行するテーブル
        Map<String, String> tableListKohi = new LinkedHashMap<String, String>();
        tableListKohi.put("PATIENT_KOHI", "利用者公費");
        
        
        Exception runException = null;
        
        int state = 5;
        
        try {
            
            try {
                to.begin();
                
                
                //そのままコピー実行
                for (Entry<String, String> table : tableListSimple.entrySet()) {
                    setStatus(table.getValue() + "情報を移行中...", state);
                    copyTable(table.getKey());
                    state += 4;
                }
                
                //BIND_PATHを変換しながら実行
                for (Entry<String, String> table : tableListProviderDetail.entrySet()) {
                    setStatus(table.getValue() + "情報を移行中...", state);
                    copyTableConvertBindPath(table.getKey());
                    state += 4;
                }
                
                //M_KOHIの値をチェックしながらコピー実行
                for (Entry<String, String> table : tableListKohi.entrySet()) {
                    setStatus(table.getValue() + "情報を移行中...", state);
                    copyTableCheckKohi(table.getKey());
                    state += 5;
                }
                

                // 最後にM_NO_CONTROLのPROVIDER_SERVICEを移行
                copyNoControl("PROVIDER_SERVICE", "PROVIDER_SERVICE_ID");
                
// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] add - begin
                //介護保険情報のシステム適用期間を設定
                updateSystemInsureValid();
                
                //地域区分　５級地の２⇒５級地
                updateProviderAreaType();
// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] add - end
                
                setStatus("終了処理を実行中...", 100);
                
                to.commit();

            } catch (Exception e) {
                to.rollback();
                throw e;
            } finally {
                from = null;
                to = null;
            }
        } catch (Exception ex) {
            runException = ex;
        }
        
        frame.taskEnd(runException);
    }
    
    private void copyTable(String tableName) throws Exception {
        
        // テーブルの列情報を取得
        Connection con_from = from.getConnection();
        Statement stmt_from = con_from.createStatement();
        
        Connection con_to = to.getConnection();
        Statement stmt_to = con_to.createStatement();
        
        stmt_to.execute("DELETE FROM " + tableName);
        con_from.commit();
        
        ResultSet rs_from = stmt_from.executeQuery("SELECT * FROM " + tableName);
        ResultSetMetaData meta = rs_from.getMetaData();
         
        int columnSize = meta.getColumnCount();
        
        
        StringBuffer params = new StringBuffer();
        StringBuffer sql = new StringBuffer("insert into ");
        sql.append(tableName);
        sql.append(" (");
        
        for (int i = 1; i <= columnSize; i++) {
            
            Log.info(meta.getColumnName(i));
            
            if (i != 1) {
                sql.append(",");
                params.append(",");
            }
            sql.append(meta.getColumnName(i));
            params.append("?");
        }
        
        sql.append(") values (");
        sql.append(params.toString());
        sql.append(")");
        
        
        int batchCounter = 0;
        
        PreparedStatement p = stmt_to.getConnection().prepareStatement(sql.toString());
        
        lbl:while(rs_from.next()) {
            for (int i = 1; i <= columnSize; i++) {
                try {
                    p.setObject(i, rs_from.getObject(i));
                    
                } catch (Exception e){
                    Log.info("-----------------------------");
                    Log.info(meta.getColumnName(i));
                    Log.info(rs_from.getObject(i).toString());
                    Log.info("-----------------------------");
                    continue lbl;
                }
            }
            p.addBatch();
            p.clearParameters();
            
            //適当なタイミングでバッチをクリア
            if (1000 < batchCounter) {
                p.executeBatch();
                stmt_to.getConnection().commit();
                
                p.clearBatch();
                batchCounter = 0;
            } else {
                batchCounter++;
            }
        }
        
        p.executeBatch();
        stmt_to.getConnection().commit();
        Log.info("=========================================");
    }
    
    
    
    private void copyTableConvertBindPath(String tableName) throws Exception {
        
        if (providerServiceId == null) {
            providerServiceId = getProviderServiceId();
        }
        
        // テーブルの列情報を取得
        Connection con_from = from.getConnection();
        Statement stmt_from = con_from.createStatement();
        
        Connection con_to = to.getConnection();
        Statement stmt_to = con_to.createStatement();
        
        stmt_to.execute("DELETE FROM " + tableName);
        con_from.commit();
        
        ResultSet rs_from = stmt_from.executeQuery("SELECT * FROM " + tableName);
        ResultSetMetaData meta = rs_from.getMetaData();
         
        int columnSize = meta.getColumnCount();
        int systemBindPathIndex = 0;
        
        StringBuffer params = new StringBuffer();
        StringBuffer sql = new StringBuffer("insert into ");
        sql.append(tableName);
        sql.append(" (");
        
        for (int i = 1; i <= columnSize; i++) {
            
            Log.info(meta.getColumnName(i));
            
            if (i != 1) {
                sql.append(",");
                params.append(",");
            }
            sql.append(meta.getColumnName(i));
            params.append("?");
            
            if ("SYSTEM_BIND_PATH".equals(meta.getColumnName(i))) {
                systemBindPathIndex = i;
            }
        }
        
        sql.append(") values (");
        sql.append(params.toString());
        sql.append(")");
        
        
        int batchCounter = 0;
        
        PreparedStatement p = stmt_to.getConnection().prepareStatement(sql.toString());
        
        lbl:while(rs_from.next()) {
            
            int systemBindPath = rs_from.getInt("SYSTEM_BIND_PATH");
            
            // providerServiceIdのチェック(認知症対応型通所介護の情報であるか)
            if (providerServiceId.contains(rs_from.getInt("PROVIDER_SERVICE_ID"))) {
                
                switch (systemBindPath) {
                case 1150102:
                    systemBindPath = 1720110;
                    Log.info("変換：" + rs_from.getString("PROVIDER_SERVICE_ID") + ":1150102->1720110:" + rs_from.getString("DETAIL_VALUE"));
                    break;
                case 1150103:
                    systemBindPath = 1720111;
                    Log.info("変換：" + rs_from.getString("PROVIDER_SERVICE_ID") + ":1150103->1720111:" + rs_from.getString("DETAIL_VALUE"));
                    break;
                }
                
            }
            
            for (int i = 1; i <= columnSize; i++) {
                try {
                    
                    if (systemBindPathIndex == i) {
                        p.setObject(i, systemBindPath);
                    } else {
                        p.setObject(i, rs_from.getObject(i));
                    }
                    
                } catch (Exception e){
                    Log.info("-----------------------------");
                    Log.info(meta.getColumnName(i));
                    Log.info(rs_from.getObject(i).toString());
                    Log.info("-----------------------------");
                    continue lbl;
                }
            }
            p.addBatch();
            p.clearParameters();
            
            //適当なタイミングでバッチをクリア
            if (1000 < batchCounter) {
                p.executeBatch();
                stmt_to.getConnection().commit();
                
                p.clearBatch();
                batchCounter = 0;
            } else {
                batchCounter++;
            }
        }
        
        p.executeBatch();
        stmt_to.getConnection().commit();
        Log.info("=========================================");
        
    }
    
    
    private void copyTableCheckKohi(String tableName) throws Exception {
        
        if (kohiType == null) {
            kohiType = getKohiType();
        }
        
        // テーブルの列情報を取得
        Connection con_from = from.getConnection();
        Statement stmt_from = con_from.createStatement();
        
        Connection con_to = to.getConnection();
        Statement stmt_to = con_to.createStatement();
        
        stmt_to.execute("DELETE FROM " + tableName);
        con_from.commit();
        
        ResultSet rs_from = stmt_from.executeQuery("SELECT * FROM " + tableName);
        ResultSetMetaData meta = rs_from.getMetaData();
         
        int columnSize = meta.getColumnCount();
        
        StringBuffer params = new StringBuffer();
        StringBuffer sql = new StringBuffer("insert into ");
        sql.append(tableName);
        sql.append(" (");
        
        for (int i = 1; i <= columnSize; i++) {
            
            Log.info(meta.getColumnName(i));
            
            if (i != 1) {
                sql.append(",");
                params.append(",");
            }
            sql.append(meta.getColumnName(i));
            params.append("?");
        }
        
        sql.append(") values (");
        sql.append(params.toString());
        sql.append(")");
        
        
        int batchCounter = 0;
        
        PreparedStatement p = stmt_to.getConnection().prepareStatement(sql.toString());
        
        lbl:while(rs_from.next()) {
            
            // SYSTEM_BIND_PATHのチェック
            if (!kohiType.contains(rs_from.getInt("KOHI_TYPE"))) {
                StringBuffer logInfo = new StringBuffer();
                logInfo.append("公費情報：");
                logInfo.append(rs_from.getInt("KOHI_TYPE"));
                logInfo.append("の公費は移行しませんでした。");
                logInfo.append("PATIENT_ID(");
                logInfo.append(rs_from.getString("PATIENT_ID"));
                logInfo.append(") INSURER_ID(");
                logInfo.append(rs_from.getString("INSURER_ID"));
                logInfo.append(") KOHI_RECIPIENT_NO(");
                logInfo.append(rs_from.getString("KOHI_RECIPIENT_NO"));
                logInfo.append(")");
                
                Log.info(logInfo.toString());
                continue;
            }
            
            for (int i = 1; i <= columnSize; i++) {
                try {
                    p.setObject(i, rs_from.getObject(i));
                    
                } catch (Exception e){
                    Log.info("-----------------------------");
                    Log.info(meta.getColumnName(i));
                    Log.info(rs_from.getObject(i).toString());
                    Log.info("-----------------------------");
                    continue lbl;
                }
            }
            p.addBatch();
            p.clearParameters();
            
            //適当なタイミングでバッチをクリア
            if (1000 < batchCounter) {
                p.executeBatch();
                stmt_to.getConnection().commit();
                
                p.clearBatch();
                batchCounter = 0;
            } else {
                batchCounter++;
            }
        }
        
        p.executeBatch();
        stmt_to.getConnection().commit();
        Log.info("=========================================");
    }
    
    private void copyNoControl(String tableName, String fieldName) throws Exception {
        //String num = from.execQuerySingle("");
        
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT CONTROL_NO");
        sql.append(" FROM M_NO_CONTROL");
        sql.append(" WHERE");
        sql.append(" (TABLE_NAME = '" + tableName + "')");
        sql.append(" AND (FIELD_NAME = '" + fieldName + "')");
        
        
        String num = from.execQuerySingle(sql.toString());
        
        sql = new StringBuffer();
        sql.append("UPDATE M_NO_CONTROL");
        sql.append(" SET CONTROL_NO = " + num);
        sql.append(" WHERE");
        sql.append(" (TABLE_NAME = '" + tableName + "')");
        sql.append(" AND (FIELD_NAME = '" + fieldName + "')");
        to.exec(sql.toString());
    }
    
 // 2015/2/2 [H27.4改正対応][Yoichiro Kamei] add - begin
    private void updateSystemInsureValid() throws Exception {
        String sql = "UPDATE PATIENT_NINTEI_HISTORY SET SYSTEM_INSURE_VALID_START = INSURE_VALID_START, SYSTEM_INSURE_VALID_END = INSURE_VALID_END";
        to.exec(sql);
    }
    
    // 地域区分　５級地の２：8⇒５級地：3
    private void updateProviderAreaType() throws Exception {
        String sql = "UPDATE PROVIDER SET PROVIDER_AREA_TYPE = 3 WHERE PROVIDER_AREA_TYPE = 8";
        to.exec(sql);
    }
 // 2015/2/2 [H27.4改正対応][Yoichiro Kamei] add - end
    
    private Set<Integer> getProviderServiceId() throws Exception {
        
        Set<Integer> result = new HashSet<Integer>();
        
        Connection con = from.getConnection();
        Statement stmt = con.createStatement();
        
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT PROVIDER_SERVICE_ID FROM PROVIDER_SERVICE");
        sql.append(" WHERE");
        sql.append(" (SYSTEM_SERVICE_KIND_DETAIL IN (17211))");
        
        ResultSet rs = stmt.executeQuery(sql.toString());
        
        while(rs.next()) {
            result.add(rs.getInt(1));
        }
        
        return result;
    }
    
    
    private Set<Integer> getKohiType() throws Exception {
        
        Set<Integer> result = new HashSet<Integer>();
        
        Connection con = to.getConnection();
        Statement stmt = con.createStatement();
        
        ResultSet rs = stmt.executeQuery("SELECT KOHI_TYPE FROM M_KOHI");
        
        while(rs.next()) {
            result.add(rs.getInt(1));
        }
        
        return result;
    }

    private void setStatus(String title, int value) {
        frame.status.setText(title);
        frame.progress.setValue(value);
    }

}