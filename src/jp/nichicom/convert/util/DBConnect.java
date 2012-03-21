package jp.nichicom.convert.util;

import java.sql.*;

/**
 * DB操作クラス<br>
 * プロパティファイルを読み込み、DBへの接続を行う
 * 
 * @version 1.01 2005/10/13
 * @author shin fujihara 1.01 java1.5 に対応
 */
public class DBConnect {

    /**
     * 接続に使用するコネクション
     */
    private Connection con = null;

    // 接続情報
    private XMLDocumentUtil doc = null;
    // データベースパス
    private String path = null;

    /**
     * コンストラクタ<br>
     * コネクションの生成を行う
     */
    public DBConnect(XMLDocumentUtil doc, String path) throws Exception {
        this.doc = doc;
        this.path = path;
        makeConnection();
    }

    /**
     * コネクションの生成を行う
     * 
     */
    private void makeConnection() throws Exception {
        try {
            // 設定ファイルからDB接続情報を取得する。
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
     * SQL文の実行を行う
     * 
     * @param sql
     *            実行するSQL文
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
     * SQL文の実行を行い、データの取得を行う。<BR>
     * 取得したレコードの最初の行の最初の列データを返却する。
     * 
     * @param sql
     *            実行するSQL(select)
     * @return 取得データ
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
     * トランザクションを明示的に開始する
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
     * 現在のトランザクションをコミットする
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
     * 現在のトランザクションをロールバックする
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
     * ファイナライザ<br>
     * トランザクションの終了を行う。
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
