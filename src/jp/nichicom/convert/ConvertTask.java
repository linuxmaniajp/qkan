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
 * ���ǒ� V5 => V6 �R���o�[�g�^�X�N
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
        
        // �P���ڍs����e�[�u�����X�g
        Map<String, String> tableListSimple = new LinkedHashMap<String, String>();
        
        tableListSimple.put("FIXED_FORM", "��^��");
        tableListSimple.put("INSURER", "�ی���");
//        tableListSimple.put("INSURER_LIMIT_RATE", "�ی��ҒP��");
//        tableListSimple.put("INSURER_LIMIT_RATE_DETAIL", "�ی��ҒP���ڍ�");
        
        tableListSimple.put("PATIENT", "���p��");
        tableListSimple.put("PATIENT_CHANGES_HISTORY", "���p�ҕύX����");
        tableListSimple.put("PATIENT_NINTEI_HISTORY", "���p�ҔF�藚��");
        tableListSimple.put("PATIENT_SHISETSU_HISTORY", "���p�Ҏ{�ݗ���");
        
        tableListSimple.put("PROVIDER", "���Ə�");
        tableListSimple.put("PROVIDER_MENU", "���Ə����j���[");
        tableListSimple.put("PROVIDER_SERVICE", "���Ə��񋟃T�[�r�X");
        tableListSimple.put("STAFF", "�X�^�b�t");
        tableListSimple.put("MEDICAL_FACILITY", "��Ë@�֏��");
        
        tableListSimple.put("HOMONKANGO_JOHO_TEIKYOSHO", "�K��Ō�̏��񋟏�");
        tableListSimple.put("HOMONKANGO_KIROKUSHO", "�K��Ō�L�^���h");
        tableListSimple.put("HOMONKANGO_PLAN", "�K��Ō�v�揑");
        tableListSimple.put("HOMONKANGO_PLAN_NOTE", "�K��Ō�v�揑�ڍ�");
        tableListSimple.put("HOMONKANGO_RESULT", "�K��Ō�񍐏�");
        tableListSimple.put("HOMONKANGO_RESULT_CALENDAR", "�K��Ō�񍐏��ڍ�");
        tableListSimple.put("KYOTAKU_RYOYO", "����×{�Ǘ��w����");
        
        // ���Ə��̃o�C���h�p�X��ϊ����Ȃ���ڍs����e�[�u��
        Map<String, String> tableListProviderDetail = new LinkedHashMap<String, String>();
        tableListProviderDetail.put("PROVIDER_SERVICE_DETAIL_DATE", "���Ə��񋟃T�[�r�X�ڍׂP");
        tableListProviderDetail.put("PROVIDER_SERVICE_DETAIL_TEXT", "���Ə��񋟃T�[�r�X�ڍׂQ");
        tableListProviderDetail.put("PROVIDER_SERVICE_DETAIL_INTEGER", "���Ə��񋟃T�[�r�X�ڍׂR");
        
        
        // ���ݗL���Ȍ�����݈̂ڍs����e�[�u��
        Map<String, String> tableListKohi = new LinkedHashMap<String, String>();
        tableListKohi.put("PATIENT_KOHI", "���p�Ҍ���");
        
        
        Exception runException = null;
        
        int state = 5;
        
        try {
            
            try {
                to.begin();
                
                
                //���̂܂܃R�s�[���s
                for (Entry<String, String> table : tableListSimple.entrySet()) {
                    setStatus(table.getValue() + "�����ڍs��...", state);
                    copyTable(table.getKey());
                    state += 4;
                }
                
                //BIND_PATH��ϊ����Ȃ�����s
                for (Entry<String, String> table : tableListProviderDetail.entrySet()) {
                    setStatus(table.getValue() + "�����ڍs��...", state);
                    copyTableConvertBindPath(table.getKey());
                    state += 4;
                }
                
                //M_KOHI�̒l���`�F�b�N���Ȃ���R�s�[���s
                for (Entry<String, String> table : tableListKohi.entrySet()) {
                    setStatus(table.getValue() + "�����ڍs��...", state);
                    copyTableCheckKohi(table.getKey());
                    state += 5;
                }
                

                // �Ō��M_NO_CONTROL��PROVIDER_SERVICE���ڍs
                copyNoControl("PROVIDER_SERVICE", "PROVIDER_SERVICE_ID");
                
// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] add - begin
                //���ی����̃V�X�e���K�p���Ԃ�ݒ�
                updateSystemInsureValid();
                
                //�n��敪�@�T���n�̂Q�˂T���n
                updateProviderAreaType();
// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] add - end
                
                setStatus("�I�����������s��...", 100);
                
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
        
        // �e�[�u���̗�����擾
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
            
            //�K���ȃ^�C�~���O�Ńo�b�`���N���A
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
        
        // �e�[�u���̗�����擾
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
            
            // providerServiceId�̃`�F�b�N(�F�m�ǑΉ��^�ʏ����̏��ł��邩)
            if (providerServiceId.contains(rs_from.getInt("PROVIDER_SERVICE_ID"))) {
                
                switch (systemBindPath) {
                case 1150102:
                    systemBindPath = 1720110;
                    Log.info("�ϊ��F" + rs_from.getString("PROVIDER_SERVICE_ID") + ":1150102->1720110:" + rs_from.getString("DETAIL_VALUE"));
                    break;
                case 1150103:
                    systemBindPath = 1720111;
                    Log.info("�ϊ��F" + rs_from.getString("PROVIDER_SERVICE_ID") + ":1150103->1720111:" + rs_from.getString("DETAIL_VALUE"));
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
            
            //�K���ȃ^�C�~���O�Ńo�b�`���N���A
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
        
        // �e�[�u���̗�����擾
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
            
            // SYSTEM_BIND_PATH�̃`�F�b�N
            if (!kohiType.contains(rs_from.getInt("KOHI_TYPE"))) {
                StringBuffer logInfo = new StringBuffer();
                logInfo.append("������F");
                logInfo.append(rs_from.getInt("KOHI_TYPE"));
                logInfo.append("�̌���͈ڍs���܂���ł����B");
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
            
            //�K���ȃ^�C�~���O�Ńo�b�`���N���A
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
    
 // 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] add - begin
    private void updateSystemInsureValid() throws Exception {
        String sql = "UPDATE PATIENT_NINTEI_HISTORY SET SYSTEM_INSURE_VALID_START = INSURE_VALID_START, SYSTEM_INSURE_VALID_END = INSURE_VALID_END";
        to.exec(sql);
    }
    
    // �n��敪�@�T���n�̂Q�F8�˂T���n�F3
    private void updateProviderAreaType() throws Exception {
        String sql = "UPDATE PROVIDER SET PROVIDER_AREA_TYPE = 3 WHERE PROVIDER_AREA_TYPE = 8";
        to.exec(sql);
    }
 // 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] add - end
    
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