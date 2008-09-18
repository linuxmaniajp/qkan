package jp.nichicom.copaychecker.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DB����N���X<br>
 * �v���p�e�B�t�@�C����ǂݍ��݁ADB�ւ̐ڑ����s��
 * @version 1.01 2005/10/13
 * @author shin fujihara
 * 1.01 java1.5 �ɑΉ�
 */
public class DBConnect {
	
	/**
	 * �ڑ��Ɏg�p����R�l�N�V����
	 */
	private Connection con = null;
	/**
	 * �f�[�^�X�V�Ɏg�p����PreparedStatement
	 */
	private PreparedStatement pstmt = null;
	
    private String server = null;
    private String path = null;
    private String port = null;
    private String id = null;
    private String pass = null;
    private String charSet = null;	
	/**
	 * �R���X�g���N�^<br>
	 * �R�l�N�V�����̐������s��
	 */
	public DBConnect() throws Exception{
		
		//�ݒ�t�@�C���̃��[�h
		loadProperty();
		
		//�R�l�N�V�����쐬
		makeConnection();
	}
	
	public void setCharSet(String charSet){
		this.charSet = charSet;
	}
	
	private void loadProperty() throws Exception {
		try{
			XMLDocumentUtil doc = new XMLDocumentUtil(PropertyUtil.getProperty("property.filename"));
	        //�ݒ�t�@�C������DB�ڑ������擾����B
	        server = doc.getNodeValue("DBConfig","Server");
	        path = doc.getNodeValue("DBConfig","Path");
	        port = doc.getNodeValue("DBConfig","Port");
	        id = doc.getNodeValue("DBConfig","UserName");
	        pass = doc.getNodeValue("DBConfig","Password");
	        
	        charSet = doc.getNodeValue("DBConfig","CharSet");
	        
	        if(charSet == null){
	        	charSet = "";
	        }
	        
		} catch(Exception e){
			Log.warning("loadProperty Error : " + e.getLocalizedMessage());
			throw e;
		}
	}
	
	/**
	 * �R�l�N�V�����̐������s��
	 *
	 */
	public void makeConnection() throws Exception{
		try{
			
			String connect_option = "";
			
	        if(charSet == null){
	        	charSet = "";
	        }
	        if(!"".equals(charSet)){
	        	connect_option = "?lc_ctype=" + charSet;
	        }
	        
			Class.forName("org.firebirdsql.jdbc.FBDriver");
			con = DriverManager.getConnection("jdbc:firebirdsql://" + server + ":" + port + "/" + path + connect_option, id, pass);
			con.setAutoCommit(false);
		} catch(Exception e){
			Log.warning("makeConnection Error : " + e.getLocalizedMessage());
			throw e;
		}
	}
	

	
	/**
	 * SQL���̎��s���s���A�f�[�^�̎擾���s���B<BR>
	 * List���Ƀ��R�[�hMap���߂ĕԋp����
	 * @param sql ���s����SQL(select)
	 * @return �擾�f�[�^
	 */
	public List execQuery(String sql) throws Exception{
		List result = new ArrayList();
		try {
			Log.info("--- start execQuery " + sql + " ---");
			if(con == null){
				Log.warning("Connection is null -- run makeConnection");
				makeConnection();
			}
			Statement stmt = con.createStatement();
			Log.info("createStatement success");
			
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String[] fields = new String[rsmd.getColumnCount()];
			
			for (int i = 0; i < rsmd.getColumnCount(); i++){
				fields[i] = rsmd.getColumnName(i+1);
			}
			
			while(rs.next()){
				Map map = new HashMap();
				
				for(int i = 0; i < fields.length; i++) {
					map.put(fields[i], rs.getString(fields[i]));
				}
				result.add(map);
			}
			
			Log.info("execQuery " + sql + " success");
			
			rs.close();
			stmt.close();
			
		} catch (Exception e) {
			Log.warning("fail execQuery : " + e.getLocalizedMessage() + "\nSQL : " + sql);
			throw e;
		}
		Log.info("--- end execQuery " + sql + " ---");
		return result;
	}
	
	/**
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception{
		Log.info("--- start getConnection ---");
		if(con == null){
			Log.warning("Connection is null -- run makeConnection");
			makeConnection();
		}
		return this.con;
		
	}
	
	
	/**
	 * SQL���̎��s���s��
	 * @param sql ���s����SQL��
	 */
	public void exec(String sql) throws Exception{
		try {
			Log.info("--- start exec " + sql + " ---");
			if(con == null){
				Log.warning("Connection is null -- run makeConnection");
				makeConnection();
			}
			Statement stmt = con.createStatement();
			Log.info("createStatement success");
			
			stmt.execute(sql);
			Log.info("exec " + sql + " success");
			
			stmt.close();
			
		} catch (Exception e) {
			Log.warning("fail exec : " + e.getLocalizedMessage() + "\nSQL : " + sql);
			throw e;
		}
		Log.info("--- end exec " + sql + " ---");
	}
	
	/**
	 * SQL���̎��s���s���A�f�[�^�̎擾���s���B<BR>
	 * �擾�������R�[�h�̍ŏ��̍s�̍ŏ��̗�f�[�^��ԋp����B
	 * @param sql ���s����SQL(select)
	 * @return �擾�f�[�^
	 */
	public String execQuerySingle(String sql) throws Exception{
		String result = null;
		try {
			Log.info("--- start execQuerySingle " + sql + " ---");
			if(con == null){
				Log.warning("Connection is null -- run makeConnection");
				makeConnection();
			}
			Statement stmt = con.createStatement();
			Log.info("createStatement success");
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				result = rs.getString(1);
			}
			Log.info("execQuerySingle " + sql + " success\nreturn data:" + result);
			
			rs.close();
			stmt.close();
			
		} catch (Exception e) {
			Log.warning("fail execQuerySingle : " + e.getLocalizedMessage() + "\nSQL : " + sql);
			throw e;
		}
		Log.info("--- end execQuerySingle " + sql + " ---");
		return result;
	}
	/**
	 * ���s����prepareStatement�̐ݒ���s��<BR>
	 * @param sql ���s����prepareStatement
	 */
	public void setPrepareQuery(String sql) throws Exception{
		try {
			Log.info("--- start setPrepareQuery " + sql + " ---");
			if(con == null){
				Log.warning("Connection is null -- run makeConnection");
				makeConnection();
			}
			pstmt = con.prepareStatement(sql);
			Log.info("setPrepareQuery " + sql + " success");
		} catch (Exception e) {
			Log.warning("fail setPrepareQuery : " + e.getLocalizedMessage() + "\nSQL : " + sql);
			throw e;
		}
		Log.info("--- end setPrepareQuery " + sql + " ---");
	}
	
	/**
	 * �ݒ肵��prepareStatement�̎��s���s��
	 * @param ary prepareStatement�ɐݒ肷��f�[�^
	 */
	public void execPrepareQuery(ArrayList ary) throws Exception{
		Log.fine("--- start execPrepareQuery " + ary.toString() + " ---");
		if(pstmt == null){
			Log.warning("prepareStatement is null -- cancel running");
			return;
		}
		if(ary == null){
			Log.warning("DataArray is null -- cancel running");
			return;
		}
		
		try{
			for(int i = 0; i < ary.size(); i++){
				pstmt.setString(i + 1,ary.get(i).toString());
			}
			pstmt.execute();
		} catch(Exception e){
			Log.warning("fail execPrepareQuery : " + e.getLocalizedMessage() + "\ndata : " + ary.toString());
			throw e;
		}
		Log.fine("--- end execPrepareQuery " + ary.toString() + " ---");
	}
	
	/**
	 * �g�����U�N�V�����𖾎��I�ɊJ�n����
	 */
	public void begin() throws Exception{
		Log.info("--- start begin transactin ---");
		if(con != null){
			Log.info("connection is alive! -- run commit transaction");
			commit();
		}
		makeConnection();
		Log.info("--- end begin transactin ---");
	}
	/**
	 * ���݂̃g�����U�N�V�������R�~�b�g����
	 */
	public void commit(){
		Log.info("--- start commit transactin ---");
		if(con != null){
			try{
				if(!con.isClosed()){
					con.commit();
					con.close();
				}
			} catch(Exception e){
				Log.warning("fail commit transaction : " + e.getLocalizedMessage());
			}
			con = null;
		}
		Log.info("--- end commit transactin ---");
	}
	
	/**
	 * ���݂̃g�����U�N�V���������[���o�b�N����
	 */
	public void rollback(){
		Log.info("--- start rollback transactin ---");
		if(con != null){
			try{
				if(!con.isClosed()){
					con.rollback();
					con.close();
				}
				
			} catch (Exception e){
				Log.warning("fail rollback transaction : " + e.getLocalizedMessage());
			}
			con = null;
		}
		Log.info("--- end rollback transactin ---");
	}
	
	/**
	 * �t�@�C�i���C�U<br>
	 * �g�����U�N�V�����̏I�����s���B
	 */
	protected void finalize(){
		Log.info("--- DBConnect finalize ---");
		commit();
	}
	
	
}

