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
      
}
