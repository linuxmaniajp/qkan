/*
 * 作成日: 2006/06/08
 *
 * TODO この生成されたファイルのテンプレートを変更するには次へジャンプ:
 * ウィンドウ - 設定 - Java - コード・スタイル - コード・テンプレート
 */
package jp.or.med.orca.qkan.affair.qm.qm001;

import java.util.Iterator;
import java.util.Stack;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * システムから登録可能なマスタの補正用操作クラス
 * @author n0153
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
	 * 利用者公費サービステーブルの補正
	 * @throws Exception
	 */
	protected void adjustPatientKohiService(ACDBManager dbm) throws Exception {

		try {

			// 利用者公費サービステーブルの初期化
			dbm.executeUpdate(getSQL_DELETE_PATIENT_KOHI_SERVICE(null));

			// 利用者の公費親情報の取得（IDの取得）
			VRList patientKohiList = dbm
					.executeQuery(getSQL_GET_PATIENT_KOHI(null));

			// 取得したID情報をループ
			Iterator it = patientKohiList.iterator();
			while (it.hasNext()) {
				VRMap patientKohi = (VRMap) it.next();
				// KOHI_TYPEにより公費の対象サービス情報を取得
				VRList masterKohiServiceList = dbm
						.executeQuery(getSQL_GET_KOHI_SERVICE(patientKohi));
				// 取得した対象サービス情報（複数件）を順に利用者公費サービス情報テーブルへ書き込む
				for (int i = 0; i < masterKohiServiceList.size(); i++) {
					int systemServiceKindDetail = ACCastUtilities
							.toInt(VRBindPathParser.get(
									"SYSTEM_SERVICE_KIND_DETAIL",
									(VRMap) masterKohiServiceList.get(i)));
					VRBindPathParser.set("SYSTEM_SERVICE_KIND_DETAIL",
							patientKohi, new Integer(systemServiceKindDetail));
					dbm
							.executeUpdate(getSQL_INSERT_PATIENT_KOHI_SERVICE(patientKohi));
				}
			}

		} catch (Exception ex) {
			throw ex;
		}

	}

	/**
	 * 事業所メニューテーブルの補正
	 * 特定メニューの追加
	 * @throws Exception
	 */
	protected void adjustProviderMenu(ACDBManager dbm, int menuId)
			throws Exception {

		try {

			// 自事業所番号の取得
			VRList providerList = dbm
					.executeQuery(getSQL_GET_LOGIN_PROVIDER(null));

			// 自事業所番号をループ
			Iterator it = providerList.iterator();
			while (it.hasNext()) {
				VRMap provider = (VRMap) it.next();
				// 情報追加
				VRBindPathParser.set("MENU_ID", provider, new Integer(menuId));
				VRBindPathParser.set("SHOW_FLAG", provider, new Integer(1));
				// 既に登録されていないかチェックする
				VRList count = dbm
						.executeQuery(getSQL_GET_EXISTING_PROVIDER_MENU(provider));
				if (count.size() <= 0) {
					// 自事業所ごとにメニュー追加
					dbm.executeUpdate(getSQL_INSERT_PROVIDER_MENU(provider));
				}
			}

		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * 「給付管理台帳システムの」のためのSQLを返します。
	 * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
	 * @throws Exception 処理例外
	 * @return SQL文
	 */
	public String getSQL_GET_QKAN_VERSION(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("SELECT");

		sb.append(" MASTER_DATA_VERSION");

		sb.append(",SCHEME_VERSION");

		sb.append(" FROM");

		sb.append(" M_QKAN_VERSION");

		return sb.toString();
	}

	/**
	 * 「マスタバージョン更新」のためのSQLを返します。
	 * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
	 * @throws Exception 処理例外
	 * @return SQL文
	 */
	public String getSQL_UPDATE_MASTER_VERSION(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

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
	 * 「利用者公費サービステーブルの初期化」のためのSQLを返します。
	 * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
	 * @throws Exception 処理例外
	 * @return SQL文
	 */
	public String getSQL_DELETE_PATIENT_KOHI_SERVICE(VRMap sqlParam)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("DELETE FROM");

		sb.append(" PATIENT_KOHI_SERVICE");

		return sb.toString();
	}

	/**
	 * 「利用者公費情報の取得」のためのSQLを返します。
	 * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
	 * @throws Exception 処理例外
	 * @return SQL文
	 */
	public String getSQL_GET_PATIENT_KOHI(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("SELECT");

		sb.append(" PATIENT_ID");

		sb.append(",KOHI_ID");

		sb.append(",KOHI_TYPE");

		sb.append(" FROM");

		sb.append(" PATIENT_KOHI");

		return sb.toString();
	}

	/**
	 * 「公費の給付対象サービス情報の取得」のためのSQLを返します。
	 * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
	 * @throws Exception 処理例外
	 * @return SQL文
	 */
	public String getSQL_GET_KOHI_SERVICE(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("SELECT DISTINCT");

		sb.append(" SYSTEM_SERVICE_KIND_DETAIL");

		sb.append(" FROM");

		sb.append(" M_KOHI_SERVICE");

		sb.append(" WHERE");

		sb.append("(");

		sb.append(" KOHI_TYPE");

		sb.append(" =");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("KOHI_TYPE", sqlParam)));

		sb.append(")");

		return sb.toString();
	}

	/**
	 * 「利用者公費サービステーブルへの追加」のためのSQLを返します。
	 * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
	 * @throws Exception 処理例外
	 * @return SQL文
	 */
	public String getSQL_INSERT_PATIENT_KOHI_SERVICE(VRMap sqlParam)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("INSERT INTO");

		sb.append(" PATIENT_KOHI_SERVICE");

		sb.append("(");

		sb.append(" PATIENT_ID");

		sb.append(",KOHI_ID");

		sb.append(",SYSTEM_SERVICE_KIND_DETAIL");

		sb.append(",LAST_TIME");

		sb.append(")VALUES(");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("PATIENT_ID", sqlParam)));

		sb.append(",");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("KOHI_ID", sqlParam)));

		sb.append(",");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam)));

		sb.append(",");

		sb.append(" CURRENT_TIMESTAMP");

		sb.append(")");

		return sb.toString();
	}

	/**
	 * 「自事業所番号の取得」のためのSQLを返します。
	 * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
	 * @throws Exception 処理例外
	 * @return SQL文
	 */
	public String getSQL_GET_LOGIN_PROVIDER(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("SELECT");

		sb.append(" PROVIDER_ID");

		sb.append(" FROM");

		sb.append(" PROVIDER");

		sb.append(" WHERE");

		sb.append("(");

		sb.append(" PROVIDER_JIJIGYOUSHO_TYPE");

		sb.append(" =");

		sb.append(" 1");

		sb.append(")");

		return sb.toString();
	}

	/**
	 * 「メニューの存在確認」のためのSQLを返します。
	 * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
	 * @throws Exception 処理例外
	 * @return SQL文
	 */
	public String getSQL_GET_EXISTING_M_MENU(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("SELECT");

		sb.append(" MENU_ID");

		sb.append(" FROM");

		sb.append(" M_MENU");

		sb.append(" WHERE");

		sb.append("(");

		sb.append(" MENU_ID");

		sb.append(" =");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("MENU_ID", sqlParam)));

		sb.append(")");

		return sb.toString();
	}

	/**
	 * 「メニューの存在確認」のためのSQLを返します。
	 * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
	 * @throws Exception 処理例外
	 * @return SQL文
	 */
	public String getSQL_GET_EXISTING_PROVIDER_MENU(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("SELECT");

		sb.append(" MENU_ID");

		sb.append(" FROM");

		sb.append(" PROVIDER_MENU");

		sb.append(" WHERE");

		sb.append("(");

		sb.append(" MENU_ID");

		sb.append(" =");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("MENU_ID", sqlParam)));

		sb.append(")");

		if(VRBindPathParser.has("PROVIDER_ID", sqlParam)){
			
			sb.append("AND");
	
			sb.append("(");
	
			sb.append(" LOGIN_PROVIDER_ID");
	
			sb.append(" =");
	
			sb.append(ACSQLSafeStringFormat.getInstance().format(
					VRBindPathParser.get("PROVIDER_ID", sqlParam)));
	
			sb.append(")");
			
		}
		
		return sb.toString();
	}

	/**
	 * 「事業所メニューテーブルへの追加」のためのSQLを返します。
	 * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
	 * @throws Exception 処理例外
	 * @return SQL文
	 */
	public String getSQL_INSERT_PROVIDER_MENU(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("INSERT INTO");

		sb.append(" PROVIDER_MENU");

		sb.append("(");

		sb.append(" LOGIN_PROVIDER_ID");

		sb.append(",MENU_ID");

		sb.append(",SHOW_FLAG");

		sb.append(",LAST_TIME");

		sb.append(")VALUES(");

		sb.append(ACSQLSafeStringFormat.getInstance().format(
				VRBindPathParser.get("PROVIDER_ID", sqlParam)));

		sb.append(",");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("MENU_ID", sqlParam)));

		sb.append(",");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("SHOW_FLAG", sqlParam)));

		sb.append(",");

		sb.append(" CURRENT_TIMESTAMP");

		sb.append(")");

		return sb.toString();
	}
    
      /**
       * 「指定サービスの事業所サービス番号を取得します。」のためのSQLを返します。
       * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
       * @throws Exception 処理例外
       * @return SQL文
       * 
       * @author Masahiko_Higuchi
       * @since V540
       */
      public String getSQL_GET_PROVIDER_SERVICE_ID(VRMap sqlParam) throws Exception{
        StringBuffer sb = new StringBuffer();
        Object[] inValues;
        Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
        boolean firstCondition = true, firstConditionOfFrom = true;
        Object obj;

        sb.append("SELECT");

        sb.append(" PROVIDER_SERVICE_ID");

        sb.append(" FROM");

        sb.append(" PROVIDER_SERVICE");

        sb.append(" WHERE");

        sb.append("(");

        sb.append(" SYSTEM_SERVICE_KIND_DETAIL");

        sb.append(" =");

        sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam)));

        sb.append(")");

        return sb.toString();
      }

      /**
       * 「事業所の情報を更新します。」のためのSQLを返します。
       * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
       * @throws Exception 処理例外
       * @return SQL文
       * 
       * @author Masahiko_Higuchi
       * @since V540
       */
      public String getSQL_INSERT_PROVIDER_SERVICE_DETAIL_INTEGER(VRMap sqlParam) throws Exception{
        StringBuffer sb = new StringBuffer();
        Object[] inValues;
        Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
        boolean firstCondition = true, firstConditionOfFrom = true;
        Object obj;

        sb.append("INSERT INTO");

        sb.append(" PROVIDER_SERVICE_DETAIL_INTEGER");

        sb.append("(");

        sb.append(" PROVIDER_SERVICE_ID");

        sb.append(",SYSTEM_BIND_PATH");

        sb.append(",DETAIL_VALUE");

        sb.append(",LAST_TIME");

        sb.append(")VALUES(");

        sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDER_SERVICE_ID", sqlParam)));

        sb.append(",");

        sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SYSTEM_BIND_PATH", sqlParam)));

        sb.append(",");

        sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("DETAIL_VALUE", sqlParam)));

        sb.append(",");

        sb.append(" CURRENT_TIMESTAMP");

        sb.append(")");

        return sb.toString();
      }
      /**
       * 「アップデート対象確認」のためのSQLを返します。
       * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
       * @throws Exception 処理例外
       * @return SQL文
       * 
       * @author Masahiko_Higuchi
       * @since V540
       */
      public String getSQL_GET_PROVIDER_SERVICE_ROUKEN(VRMap sqlParam) throws Exception{
        StringBuffer sb = new StringBuffer();
        Object[] inValues;
        Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
        boolean firstCondition = true, firstConditionOfFrom = true;
        Object obj;

        sb.append("SELECT");

        sb.append(" COUNT(*)");

        sb.append(" FROM");

        sb.append("  PROVIDER_SERVICE_DETAIL_INTEGER");

        sb.append(" WHERE");

        sb.append("(");

        sb.append(" PROVIDER_SERVICE_ID");

        sb.append("  IN");

        sb.append(" (");

        sb.append("SELECT");

        sb.append(" PROVIDER_SERVICE_ID");

        sb.append(" FROM");

        sb.append(" PROVIDER_SERVICE");

        sb.append(" WHERE");

        sb.append("(");

        sb.append(" SYSTEM_SERVICE_KIND_DETAIL");

        sb.append(" IN");

        sb.append(" ('12211','15211','12511')");

        sb.append(")");

        sb.append(")");

        sb.append(")");

        sb.append("AND");

        sb.append("(");

        sb.append(" SYSTEM_BIND_PATH");

        sb.append(" IN");

        sb.append(" ('1220120','1220121','1520122','1520123','1520124','1250116','1250117')");

        sb.append(")");

        return sb.toString();
      }

      /**
       * 「平成21年4月法改正に関するアップデート対象確認」のためのSQLを返します。
       * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
       * @throws Exception 処理例外
       * @return SQL文
       * 
       * @author Tozo TANAKA
       * @since V545
       */
      public String getSQL_GET_PROVIDER_SERVICE_DETAIL_H2104(VRMap sqlParam) throws Exception{
        StringBuffer sb = new StringBuffer();

        sb.append("SELECT");

        sb.append(" COUNT(*) AS COUNTVAL");

        sb.append(" FROM");

        sb.append("  PROVIDER_SERVICE_DETAIL_INTEGER");

        sb.append(" WHERE");

        sb.append("(");

        sb.append(" SYSTEM_BIND_PATH");

        sb.append(" IN");

        sb.append(" ('2','3','1150113','1150115','1150116','1160112','1220126','1230124','1230126','1230127','1330108','1430104','1510134','1520130','1520131','1530126','1530128','1530129','1530131','1530225','1530322','1720109','1540135','1250122','1260122','1260123','1260124','1260125','1230123','1230125','1530127','1530130','1260121')");

        sb.append(")");

        return sb.toString();
      }
      
      //[ID:0000447][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
      /**
       * 変更対象の公費情報を持つ利用者情報取得用SQL
       * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
       * @throws Exception 処理例外
       * @return SQL文
       * 
       * @author Shin Fujihara
       * @since V546
       */
      public String getSQL_GET_PATIENT_KOHI_H2104(VRMap sqlParam) throws Exception{
    	  StringBuffer sb = new StringBuffer();
    	  
    	  sb.append(" SELECT");
    	  sb.append(" k.PATIENT_ID,");
    	  sb.append(" K.KOHI_ID");
    	  sb.append(" FROM PATIENT_KOHI k");
    	  sb.append(" LEFT OUTER JOIN");
    	  sb.append(" PATIENT_KOHI_SERVICE s");
    	  sb.append(" ON");
    	  sb.append(" (k.PATIENT_ID = s.PATIENT_ID)");
    	  sb.append(" AND (k.KOHI_ID = s.KOHI_ID)");
    	  sb.append(" AND (s.SYSTEM_SERVICE_KIND_DETAIL = ");
    	  sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam)));
    	  sb.append(")");
    	  sb.append(" WHERE");
    	  sb.append(" (k.INSURE_TYPE = 1)");
    	  sb.append(" AND (k.KOHI_TYPE = ");
    	  sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("KOHI_TYPE", sqlParam)));
    	  sb.append(")");
    	  sb.append(" AND ('2009-03-31' < k.KOHI_VALID_END)");
    	  sb.append(" AND (s.PATIENT_ID IS NULL)");
    	  
    	  return sb.toString();
      }
      
      /**
       * 利用者の公費情報修正用SQL
       * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
       * @throws Exception 処理例外
       * @return SQL文
       * 
       * @author Shin Fujihara
       * @since V546
       */
      public String getSQL_INSERT_PATIENT_KOHI_H2104(VRMap sqlParam) throws Exception{
    	  StringBuffer sb = new StringBuffer();
    	  
    	  sb.append(" INSERT");
    	  sb.append(" INTO");
    	  sb.append(" PATIENT_KOHI_SERVICE");
    	  sb.append(" (PATIENT_ID,");
    	  sb.append(" KOHI_ID,");
    	  sb.append(" SYSTEM_SERVICE_KIND_DETAIL,");
    	  sb.append(" LAST_TIME)");
    	  sb.append(" VALUES (");
    	  sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));
    	  sb.append(",");
    	  sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("KOHI_ID", sqlParam)));
    	  sb.append(",");
    	  sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam)));
    	  sb.append(",");
    	  sb.append(" CURRENT_TIMESTAMP)");
    	  
    	  return sb.toString();
      }
      //[ID:0000447][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
      
      
      // [ID:0000493][Tozo TANAKA] 2009/04/28 add begin 【DB補正】不正なサービスデータ(特定診療費等)削除対応
      /**
       * 「サービス詳細テーブルの年度期間取得」のためのSQLを返します。
       * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
       * @throws Exception 処理例外
       * @return SQL文
       * 
       * @author Tozo TANAKA
       * @since V547
       */
      public String getSQL_GET_SERVICE_DETAIL_YEAR_RANGE(VRMap sqlParam) throws Exception{
          StringBuffer sb = new StringBuffer();
          
          sb.append("SELECT");
          sb.append(" MINIMUM_YEAR");
          sb.append(",MAXIMUM_YEAR");
          sb.append(" FROM");
          sb.append(" M_DETAIL_CONTROL");
          sb.append(" WHERE");
          sb.append(" TABLE_NAME = 'SERVICE_DETAIL'");
          
          return sb.toString();
      }
      
      /**
       * 「サービス詳細テーブルの存在確認用件数取得」のためのSQLを返します。
       * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
       * @throws Exception 処理例外
       * @return SQL文
       * 
       * @author Tozo TANAKA
       * @since V547
       */
      public String getSQL_GET_SERVICE_DETAIL_TABLE_ROWS(VRMap sqlParam) throws Exception{
          StringBuffer sb = new StringBuffer();
          
          sb.append("SELECT");
          sb.append(" COUNT(*) AS CNT_VAL");
          sb.append(" FROM");
          sb.append(" SERVICE_DETAIL_INTEGER_");
          sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("YEAR", sqlParam)));
          
          return sb.toString();
      }
      
      /**
       * 「サービス詳細テーブルの不正なレコード削除1」のためのSQLを返します。
       * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
       * @throws Exception 処理例外
       * @return SQL文
       * 
       * @author Tozo TANAKA
       * @since V547
       */
      public String getSQL_DELETE_JUNK_SERVICE_DETAIL1(VRMap sqlParam) throws Exception{
          StringBuffer sb = new StringBuffer();
          
          String year = ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("YEAR", sqlParam));
          
          sb.append("DELETE");
          sb.append(" FROM");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year);
          sb.append(" WHERE");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SYSTEM_BIND_PATH = 3010142");
          sb.append(" AND");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SERVICE_ID IN");
          sb.append(" (");
          sb.append("SELECT");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SERVICE_ID");
          sb.append(" FROM");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year);
          sb.append(" WHERE");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SYSTEM_BIND_PATH = 14");
          sb.append(" AND");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".DETAIL_VALUE = 20090401");
          sb.append(")");
          
          return sb.toString();
      }
      /**
       * 「サービス詳細テーブルの不正なレコード削除2」のためのSQLを返します。
       * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
       * @throws Exception 処理例外
       * @return SQL文
       * 
       * @author Tozo TANAKA
       * @since V547
       */
      public String getSQL_DELETE_JUNK_SERVICE_DETAIL2(VRMap sqlParam) throws Exception{
          StringBuffer sb = new StringBuffer();
          
          String year = ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("YEAR", sqlParam));
          
          sb.append("DELETE");
          sb.append(" FROM");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year);
          sb.append(" WHERE");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SYSTEM_BIND_PATH = 3010104");
          sb.append(" AND");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SERVICE_ID IN");
          sb.append(" (");
          sb.append("SELECT");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SERVICE_ID");
          sb.append(" FROM");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+"");
          sb.append(",SERVICE");
          sb.append(" WHERE");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SYSTEM_BIND_PATH = 14");
          sb.append(" AND");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".DETAIL_VALUE = 20090401");
          sb.append(" AND");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SERVICE_ID = SERVICE.SERVICE_ID");
          sb.append(" AND");
          sb.append(" SERVICE.SYSTEM_SERVICE_KIND_DETAIL IN(15311,15312,15313)");
          sb.append(")");
          
          return sb.toString();
      }
      
      // [ID:0000493][Tozo TANAKA] 2009/04/28 add end 【DB補正】不正なサービスデータ(特定診療費等)削除対応
      
      
      
}
