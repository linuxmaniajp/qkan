package jp.nichicom.convert.util;

import java.sql.*;

/**
 * DB����N���X<br>
 * �v���p�e�B�t�@�C����ǂݍ��݁ADB�ւ̐ڑ����s��
 * 
 * @version 1.01 2005/10/13
 * @author shin fujihara 1.01 java1.5 �ɑΉ�
 */
public class DBConnect {

    /**
     * �ڑ��Ɏg�p����R�l�N�V����
     */
    private Connection con = null;

    // �ڑ����
    private XMLDocumentUtil doc = null;
    // �f�[�^�x�[�X�p�X
    private String path = null;

    /**
     * �R���X�g���N�^<br>
     * �R�l�N�V�����̐������s��
     */
    public DBConnect(XMLDocumentUtil doc, String path) throws Exception {
        this.doc = doc;
        this.path = path;
        makeConnection();
    }

    /**
     * �R�l�N�V�����̐������s��
     * 
     */
    private void makeConnection() throws Exception {
        try {
            // �ݒ�t�@�C������DB�ڑ������擾����B
            String server ="localhost";
            String port = "3050";
            String id = "SYSDBA";
            String pass = "masterkey";
            String charSet = "?lc_ctype=SJIS_0208";
            
            if (doc != null) {
                server = doc.getNodeValue("DBConfig", "Server");
                port = doc.getNodeValue("DBConfig", "Port");
                id = doc.getNodeValue("DBConfig", "UserName");
                pass = doc.getNodeValue("DBConfig", "Password");
            }

            Class.forName("org.firebirdsql.jdbc.FBDriver");
            con = DriverManager.getConnection("jdbc:firebirdsql://" + server
                    + ":" + port + "/" + path + charSet, id, pass);
            con.setAutoCommit(false);
        } catch (Exception e) {
            Log.warning("makeConnection Error : " + e.getLocalizedMessage());
            throw e;
        }
    }

    /**
     * SQL���̎��s���s��
     * 
     * @param sql
     *            ���s����SQL��
     */
    public void exec(String sql) throws Exception {
        try {
            Log.info("--- start exec " + sql + " ---");
            if (con == null) {
                Log.warning("Connection is null -- run makeConnection");
                makeConnection();
            }
            Statement stmt = con.createStatement();
            Log.info("createStatement success");

            stmt.execute(sql);
            Log.info("exec " + sql + " success");

            stmt.close();

        } catch (Exception e) {
            Log.warning("fail exec : " + e.getLocalizedMessage() + "\nSQL : "
                    + sql);
            throw e;
        }
        Log.info("--- end exec " + sql + " ---");
    }

    /**
     * SQL���̎��s���s���A�f�[�^�̎擾���s���B<BR>
     * �擾�������R�[�h�̍ŏ��̍s�̍ŏ��̗�f�[�^��ԋp����B
     * 
     * @param sql
     *            ���s����SQL(select)
     * @return �擾�f�[�^
     */
    public String execQuerySingle(String sql) throws Exception {
        String result = null;
        try {
            Log.info("--- start execQuerySingle " + sql + " ---");
            if (con == null) {
                Log.warning("Connection is null -- run makeConnection");
                makeConnection();
            }
            Statement stmt = con.createStatement();
            Log.info("createStatement success");

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                result = rs.getString(1);
            }
            Log.info("execQuerySingle " + sql + " success\nreturn data:"
                    + result);

            rs.close();
            stmt.close();

        } catch (Exception e) {
            Log.warning("fail execQuerySingle : " + e.getLocalizedMessage()
                    + "\nSQL : " + sql);
            throw e;
        }
        Log.info("--- end execQuerySingle " + sql + " ---");
        return result;
    }



    /**
     * �g�����U�N�V�����𖾎��I�ɊJ�n����
     */
    public void begin() throws Exception {
        Log.info("--- start begin transactin ---");
        if (con != null) {
            Log.info("connection is alive! -- run commit transaction");
            commit();
        }
        makeConnection();
        Log.info("--- end begin transactin ---");
    }

    /**
     * ���݂̃g�����U�N�V�������R�~�b�g����
     */
    public void commit() {
        Log.info("--- start commit transactin ---");
        if (con != null) {
            try {
                if (!con.isClosed()) {
                    con.commit();
                    con.close();
                }
            } catch (Exception e) {
                Log.warning("fail commit transaction : "
                        + e.getLocalizedMessage());
            }
            con = null;
        }
        Log.info("--- end commit transactin ---");
    }

    /**
     * ���݂̃g�����U�N�V���������[���o�b�N����
     */
    public void rollback() {
        Log.info("--- start rollback transactin ---");
        if (con != null) {
            try {
                if (!con.isClosed()) {
                    con.rollback();
                    con.close();
                }

            } catch (Exception e) {
                Log.warning("fail rollback transaction : "
                        + e.getLocalizedMessage());
            }
            con = null;
        }
        Log.info("--- end rollback transactin ---");
    }

    /**
     * �t�@�C�i���C�U<br>
     * �g�����U�N�V�����̏I�����s���B
     */
    protected void finalize() {
        Log.info("--- DBConnect finalize ---");
        commit();
    }
    
    public Connection getConnection() throws Exception {
        if (con == null) {
            makeConnection();
        }
        return con;
    }

}
