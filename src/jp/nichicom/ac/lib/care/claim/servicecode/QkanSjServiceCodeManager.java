package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 総合事業マスタ(M_SJ_SERVICE_CODE)を取得するためのクラス
 * 
 * @since V7.3.0
 * @author Yoichiro.Kamei
 */
public class QkanSjServiceCodeManager {
	
	// 対象のシステムサービス種類コード（独自）
	public static List<String> dokujiCodes = Arrays.asList(new String[]{
		"50211", "50611" //A2, A6
	});
	
	// 対象のサービス種類コード（独自）
	public static List<String> dokujiKinds  = Arrays.asList(new String[]{
			"A2", "A6"
	});
	
	// 対象のシステムサービス種類コード（介護予防ケアマネジメント）
	public static List<String> afCodes = Arrays.asList(new String[]{
		"51511" //AF
	});
	
	// 対象のサービス種類コード（介護予防ケアマネジメント）
	public static List<String> afKinds  = Arrays.asList(new String[]{
			"AF"
	});
	
	// 対象のシステムサービス種類コード（独自定率）
	public static List<String> teiritsuCodes = Arrays.asList(new String[]{
		  "50311", "50711"   //A3, A7
		, "50911", "51111", "51311" //A9, AB, AD
	});
	
	// 対象のサービス種類コード（独自定率）
	public static List<String> teiritsuKinds = Arrays.asList(new String[]{
		  "A3", "A7", "A9", "AB", "AD"
	});
	
	// 対象のシステムサービス種類コード（独自定額）
	public static List<String> teigakuCodes = Arrays.asList(new String[]{
		  "50411", "50811"  //A4, A8
		, "51011", "51211", "51411" //AA, AC, AE
	});
	
	// 対象のサービス種類コード（独自定額）
	public static List<String> teigakuKinds = Arrays.asList(new String[]{
		  "A4", "A8", "AA", "AC", "AE"
	});
	
	//TODO: 上記コード定義は、可能であれば、初期化時にサービスマスタから設定する。
	
	
	// 対象のシステムサービス種類コード（独自定率、独自定額）
	public static List<String> teiritsuTeigakuCodes = new ArrayList();
	static {
		teiritsuTeigakuCodes.addAll(teiritsuCodes);
		teiritsuTeigakuCodes.addAll(teigakuCodes);
	}
	
	// 対象のサービス種類コード（独自定率、独自定額）
	public static List<String> teiritsuTeigakuKinds = new ArrayList();
	static {
		teiritsuTeigakuKinds.addAll(teiritsuKinds);
		teiritsuTeigakuKinds.addAll(teigakuKinds);
	}
	
	// 対象のシステムサービス種類コード（独自・独自定率、独自定額）
	public static List<String> dokujiTeiritsuTeigakuCodes = new ArrayList();
	static {
		dokujiTeiritsuTeigakuCodes.addAll(dokujiCodes);
		dokujiTeiritsuTeigakuCodes.addAll(teiritsuCodes);
		dokujiTeiritsuTeigakuCodes.addAll(teigakuCodes);
	}
	
	// 対象のサービス種類コード（独自・独自定率、独自定額）
	public static List<String> dokujiTeiritsuTeigakuKinds = new ArrayList();
	static {
		dokujiTeiritsuTeigakuKinds.addAll(dokujiKinds);
		dokujiTeiritsuTeigakuKinds.addAll(teiritsuKinds);
		dokujiTeiritsuTeigakuKinds.addAll(teigakuKinds);
	}
	
	private static String lastUpdateTime; //マスタの最終更新時刻（最大値）
	private static final int serviceCodeCacheLimit = 1000;
	private static HashMap<String, VRMap> serviceCodeCache = new HashMap<String, VRMap>();

	/**
	 * マスタが更新されていればキャッシュをクリアします。
	 * @throws Exception 
	 */
	public static synchronized void clearCacheIfUpdated(ACDBManager dbm) throws Exception {
		String nowLastTime = getLastUpdateTime(dbm);
		if (!nowLastTime.equals(lastUpdateTime)) {
			clearCache();
			lastUpdateTime = nowLastTime;
		}
	}
	
	/**
	 * サービスコードのキャッシュをクリアします。
	 */
	public static synchronized void clearCache() {
		serviceCodeCache.clear();
	}

	/**
	 * 総合事業サービスコードマスタのキーを生成します。
	 * 
	 * @param insurerId
	 *            保険者番号
	 * @param systemServiceKindDetail
	 *            システムサービス種類コード
	 * @param itemCode
	 *            サービス項目コード
	 * @return 総合事業サービスコードマスタのキー
	 */
	public static String createSjServiceCodeKey(String insurerId,
			String systemServiceKindDetail, String itemCode) {
		StringBuilder sb = new StringBuilder();
		sb.append(insurerId);
		sb.append(systemServiceKindDetail);
		sb.append(itemCode);
		return sb.toString();
	}

	/**
	 * 対象年月における総合事業サービスコードマスタをキーより１件取得します。
	 * 
	 * @param dbm
	 * @param key
	 * @param targetDate
	 * @return
	 * @throws Exception
	 */
	public static VRMap getSjServiceCodeByKey(ACDBManager dbm, String key,
			Date targetDate) throws Exception {

		// キャッシュにあればキャッシュから取得
		String cacheKey = key + "-"
				+ VRDateParser.format(targetDate, "yyyy/MM/dd");
		if (serviceCodeCache.containsKey(cacheKey)) {
			return serviceCodeCache.get(cacheKey);
		}

		VRMap param = new VRHashMap();
		param.put("SYSTEM_SERVICE_CODE_ITEM", key);
		VRList list = getSjServiceCode(dbm, targetDate, param);
		if (list.size() > 0) {
			VRMap data = (VRMap) list.get(0);
			if (serviceCodeCache.size() > serviceCodeCacheLimit) {
				// キャッシュ限界を超えたらすべてクリア（大量件数対策）
				serviceCodeCache.clear();
			}
			
			convertServiceCodeColumn(data);
			
			// キャッシュに格納
			serviceCodeCache.put(cacheKey, data);
			return data;
		}
		
		// 2017/6/21 [Yoichiro Kamei] add - begin 介護予防ケアマネジメント対応
		if (key == null || "".equals(key)) {
			return new VRHashMap();
		}
		// サービス種類がAFの場合
		// 保険者独自のマスタが取得できなければ国基準のマスタから取得する
		String insurerId = key.substring(0, 6);
		String kind = key.substring(6, 11);
		String item = key.substring(11, 15);		
		if (QkanSjServiceCodeManager.afCodes.contains(kind)) {	
			param = new VRHashMap();			
			param.put("INSURER_ID", insurerId);
			param.put("SYSTEM_SERVICE_KIND_DETAIL", kind);
			param.put("SERVICE_CODE_ITEM", item);
			list = getAfServiceCode(dbm, targetDate, param);
			if (list.size() > 0) {
				VRMap data = (VRMap) list.get(0);
				if (serviceCodeCache.size() > serviceCodeCacheLimit) {
					// キャッシュ限界を超えたらすべてクリア（大量件数対策）
					serviceCodeCache.clear();
				}
				
				// キャッシュに格納
				serviceCodeCache.put(cacheKey, data);
				return data;
			}		
		}
		// 2017/6/21 [Yoichiro Kamei] add - end

		return new VRHashMap();
	}
	
	//総合事業サービスコードマスタよりサービスコードマスタの項目値に変換する。
	//変換出来ないものは、固定値をセット
	private static void convertServiceCodeColumn(VRMap data) {
		// 給付管理限度額対象フラグ
		String gendoKbn = ACCastUtilities.toString(data.get("SHIKYU_GENDOGAKU_TAISHO_KBN"), "");
		if ("3".equals(gendoKbn)) {
			data.put("LIMIT_AMOUNT_OBJECT", 1); // 給付管理限度額対象
		} else {
			data.put("LIMIT_AMOUNT_OBJECT", 2); // 給付管理限度額対象外
		}
		
		// サービス加算フラグ
		data.put("SERVICE_ADD_FLAG", 1); //単位
		
		// 集計集合化区分
		String santeiTani = ACCastUtilities.toString(data.get("SANTEI_TANI"), "");
		if ("01".equals(santeiTani)) {
			data.put("TOTAL_GROUPING_TYPE", 1);
		} else if ("02".equals(santeiTani)) {
			data.put("TOTAL_GROUPING_TYPE", 2);
		} else if ("03".equals(santeiTani)) {
			data.put("TOTAL_GROUPING_TYPE", 3);
		} else if ("05".equals(santeiTani)) {//1週間につきは、日単位に変換
			data.put("TOTAL_GROUPING_TYPE", 2);
		}

		// 本体報酬フラグ
		data.put("SERVICE_MAIN_FLAG", 1); //本体報酬
		// 病室区分
		data.put("ROOM_TYPE", 0);
		// 加算種別
		data.put("SERVICE_ADD_TYPE", 0);
		// 処遇改善割合
		data.put("SERVICE_STAFF_UNIT", 0);
		// 摘要欄記載必須フラグ
		data.put("SUMMARY_FLAG", 0);
		// 摘要欄説明
		data.put("SUMMARY_MEMO", "0");
		// クラス種類
		data.put("CLASS_TYPE", 0);
		// コードID
		data.put("CODE_ID", 0);
		// 編集可能フラグ
		data.put("EDITABLE_FLAG", 0);
	}

	/**
	 * 対象年月における総合事業サービスコードマスタ取得関数です。
	 * 
	 * @param dbm
	 *            DBManager
	 * @param targetDate
	 *            対象年月
	 * @return データベースより取得した結果リスト
	 * @throws Exception
	 *             処理例外
	 */
	public static VRList getSjServiceCode(ACDBManager dbm, Date targetDate, VRMap param)
			throws Exception {

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" M_SJ_SERVICE_CODE.SYSTEM_SERVICE_CODE_ITEM,");
		sb.append(" M_SJ_SERVICE_CODE.INSURER_ID,");
		sb.append(" M_SJ_SERVICE_CODE.SYSTEM_SERVICE_KIND_DETAIL,");
		sb.append(" M_SJ_SERVICE_CODE.TEKIYO_ST_DATE,");
		sb.append(" M_SJ_SERVICE_CODE.TEKIYO_ED_DATE,");
		sb.append(" M_SJ_SERVICE_CODE.SERVICE_CODE_KIND,");
		sb.append(" M_SJ_SERVICE_CODE.SERVICE_CODE_ITEM,");
		sb.append(" M_SJ_SERVICE_CODE.SERVICE_NAME,");
		sb.append(" M_SJ_SERVICE_CODE.SERVICE_UNIT,");
		sb.append(" M_SJ_SERVICE_CODE.SANTEI_TANI,");
		sb.append(" M_SJ_SERVICE_CODE.SEIGEN_NISSU_KAISU,");
		sb.append(" M_SJ_SERVICE_CODE.SANTEI_KAISU_SEIGEN_KIKAN,");
		sb.append(" M_SJ_SERVICE_CODE.SHIKYU_GENDOGAKU_TAISHO_KBN,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI,");
		sb.append(" M_SJ_SERVICE_CODE.KYUFURITSU,");
		sb.append(" M_SJ_SERVICE_CODE.FUTANGAKU,");
		sb.append(" M_SJ_SERVICE_CODE.JIGYO_TAISHOSHA_JISSHI_KBN,");
		sb.append(" M_SJ_SERVICE_CODE.YOSHIEN1_JUKYUSHA_JISSHI_KBN,");
		sb.append(" M_SJ_SERVICE_CODE.YOSHIEN2_JUKYUSHA_JISSHI_KBN,");
		sb.append(" M_SJ_SERVICE_CODE.KOKUHO_ITAKU_KBN,");
		sb.append(" M_SJ_SERVICE_CODE.SAKUSEI_DATE,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_2,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_3,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_4,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_5,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_6,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_7,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_8,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_9,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_10");
		sb.append(" FROM");
		sb.append(" M_SJ_SERVICE_CODE");
		sb.append(" WHERE");
		
		String key = ACCastUtilities.toString(param.get("SYSTEM_SERVICE_CODE_ITEM"), "");
		if (!"".equals(key)) {
			sb.append(" (M_SJ_SERVICE_CODE.SYSTEM_SERVICE_CODE_ITEM='" + key + "')");
		} else {
			//キーの指定が無い場合は、各種条件指定
			String insurerId = ACCastUtilities.toString(param.get("INSURER_ID"), "");
			if (!"".equals(insurerId)) {
				sb.append(" (M_SJ_SERVICE_CODE.INSURER_ID='" + insurerId + "')");
			}
			
			String systemKind = ACCastUtilities.toString(param.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
			if (!"".equals(systemKind)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.SYSTEM_SERVICE_KIND_DETAIL='" + systemKind + "')");
			}
			
			String itemCode = ACCastUtilities.toString(param.get("SERVICE_CODE_ITEM"), "");
			if (!"".equals(itemCode)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.SERVICE_CODE_ITEM='" + itemCode + "')");
			}
			
			String name = ACCastUtilities.toString(param.get("SERVICE_NAME"), "");
			if (!"".equals(name)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.SERVICE_NAME like '%" + name + "%')");
			}
			
			String kyufu = ACCastUtilities.toString(param.get("KYUFURITSU"), "");
			if (!"".equals(kyufu)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.KYUFURITSU='" + kyufu + "')");
			}
			
			String futan = ACCastUtilities.toString(param.get("FUTANGAKU"), "");
			if (!"".equals(futan)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.FUTANGAKU='" + futan + "')");
			}
			
			String jigyoJisshiKbn = ACCastUtilities.toString(param.get("JIGYO_TAISHOSHA_JISSHI_KBN"), "");
			if (!"".equals(jigyoJisshiKbn)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.JIGYO_TAISHOSHA_JISSHI_KBN='" + jigyoJisshiKbn + "')");
			}
			
			String shien1JisshiKbn = ACCastUtilities.toString(param.get("YOSHIEN1_JUKYUSHA_JISSHI_KBN"), "");
			if (!"".equals(shien1JisshiKbn)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.YOSHIEN1_JUKYUSHA_JISSHI_KBN='" + shien1JisshiKbn + "')");
			}
			
			String shien2JisshiKbn = ACCastUtilities.toString(param.get("YOSHIEN2_JUKYUSHA_JISSHI_KBN"), "");
			if (!"".equals(shien2JisshiKbn)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.YOSHIEN2_JUKYUSHA_JISSHI_KBN='" + shien2JisshiKbn + "')");
			}
		}
		
		String date = VRDateParser.format(targetDate, "yyyy/MM/dd");
		sb.append(" AND (M_SJ_SERVICE_CODE.TEKIYO_ST_DATE<='" + date + "')");
		sb.append(" AND (M_SJ_SERVICE_CODE.TEKIYO_ED_DATE>='" + date + "')");
		sb.append(" AND (M_SJ_SERVICE_CODE.DELETE_FLG=0)");
		sb.append(" ORDER BY");
		sb.append(" M_SJ_SERVICE_CODE.SYSTEM_SERVICE_CODE_ITEM ASC");
		
		return dbm.executeQuery(sb.toString());
	}
	
	// 2017/6/21 [Yoichiro Kamei] add - begin 介護予防ケアマネジメント対応
	/**
	 * 対象年月における国基準の介護予防ケアマネジメントのサービスコードマスタ取得関数です。
	 * 
	 * @param dbm
	 *            DBManager
	 * @param targetDate
	 *            対象年月
	 * @return データベースより取得した結果リスト
	 * @throws Exception
	 *             処理例外
	 */
	public static VRList getAfServiceCode(ACDBManager dbm, Date targetDate, VRMap param)
			throws Exception {
		
		//保険者独自のAFコード有無を確認
		VRMap spParam = new VRHashMap();
		spParam.put("INSURER_ID", param.get("INSURER_ID"));
		spParam.put("SYSTEM_SERVICE_KIND_DETAIL", param.get("SYSTEM_SERVICE_KIND_DETAIL"));
		VRList spList = QkanSjServiceCodeManager.getSjServiceCode(dbm, targetDate, spParam);
		if (spList.size() > 0) {
			//保険者独自のAFコードが１件でも存在する場合、国基準のコードは参照しない
			//空のリストを返す（取得データなしとする）
			return new VRArrayList();
		}
		
		//保険者独自のAFコードが存在しない場合は、国基準のコードを参照する
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
        sb.append(" SYSTEM_SERVICE_KIND_DETAIL");
		//システムサービス項目コードは総合事業サービスコードマスタに合わせる（国基準コード判別のため保険者番号はオール０としておく）
		sb.append(",'000000' || SYSTEM_SERVICE_KIND_DETAIL || SERVICE_CODE_ITEM AS SYSTEM_SERVICE_CODE_ITEM");		
        sb.append(",SERVICE_VALID_START");
        sb.append(",SERVICE_VALID_END");
        sb.append(",SERVICE_CODE_KIND");
        sb.append(",SERVICE_CODE_ITEM");
        sb.append(",SERVICE_NAME");
        sb.append(",SERVICE_UNIT");
        sb.append(",LIMIT_AMOUNT_OBJECT");
        sb.append(",SERVICE_ADD_FLAG");
        sb.append(",TOTAL_GROUPING_TYPE");
        sb.append(",SERVICE_MAIN_FLAG");
        sb.append(",ROOM_TYPE");
        sb.append(",SERVICE_ADD_TYPE");
        sb.append(",SERVICE_STAFF_UNIT");
        sb.append(",SUMMARY_FLAG");
        sb.append(",SUMMARY_MEMO");
        sb.append(",CLASS_TYPE");
        sb.append(",CODE_ID");
        sb.append(",EDITABLE_FLAG");
        sb.append(",LAST_TIME");
		sb.append(" FROM");
		sb.append(" M_SERVICE_CODE");
		sb.append(" WHERE");
		
		String systemKind = ACCastUtilities.toString(param.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
		if (!"".equals(systemKind)) {
			sb.append(" (SYSTEM_SERVICE_KIND_DETAIL='" + systemKind + "')");
		}
		
		String itemCode = ACCastUtilities.toString(param.get("SERVICE_CODE_ITEM"), "");
		if (!"".equals(itemCode)) {
			sb.append(" AND (SERVICE_CODE_ITEM='" + itemCode + "')");
		}
		
		String name = ACCastUtilities.toString(param.get("SERVICE_NAME"), "");
		if (!"".equals(name)) {
			sb.append(" AND (SERVICE_NAME like '%" + name + "%')");
		}
		
		String date = VRDateParser.format(targetDate, "yyyy/MM/dd");
		sb.append(" AND (SERVICE_VALID_START<='" + date + "')");
		sb.append(" AND (SERVICE_VALID_END>='" + date + "')");
		sb.append(" ORDER BY");
		sb.append(" SERVICE_CODE_ITEM ASC");
		
		return dbm.executeQuery(sb.toString());
	}
	// 2017/6/21 [Yoichiro Kamei] add - end 介護予防ケアマネジメント対応
	
	// マスタの最終更新時刻を取得します。
	private static String getLastUpdateTime(ACDBManager dbm) throws Exception {
		String sql = "SELECT MAX(LAST_TIME) AS LAST_TIME FROM M_SJ_SERVICE_CODE";
		VRList list =  dbm.executeQuery(sql);
		VRMap ret = (VRMap) list.get(0);
		Date date = ACCastUtilities.toDate(ret.get("LAST_TIME"), null);
		if (date == null) {
			return "";
		}
		String lastTime = VRDateParser.format(date, "yyyy/MM/dd HH:mm:ss");
		return lastTime;
	}

	/**
	 * 総合事業のサービス種類取得関数です。
	 * <p>
	 * 対象年月を渡した場合：ある期間において有効な総合事業のサービス種類を取得します。<br/>
	 * 対象年月を省略した場合：期間に関係なく全てのサービス種類を取得します。
	 * </p>
	 * 
	 * @param dbm DBManager
	 * @param targetDate 対象年月
	 * @return サービス種類をキー、サービス定義情報集合を値にしたマップ
	 * @throws Exception 処理例外
	 */
	public static VRList getMasterServiceSogojigyo(ACDBManager dbm, Date targetDate)
			throws Exception {
		StringBuilder sb;

		sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" M_SERVICE.SERVICE_CODE_KIND,");
		sb.append(" M_SERVICE.SERVICE_CODE_KIND || '：' || M_SERVICE.SERVICE_NAME AS SERVICE_NAME");
		sb.append(" FROM");
		sb.append(" M_SERVICE");
		sb.append(" WHERE");
		sb.append(" (M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL IN(");
		sb.append(" SELECT DISTINCT");
		sb.append(" M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");
		sb.append(" FROM");
		sb.append(" M_SERVICE");
		sb.append(" WHERE");
		sb.append(" M_SERVICE.CLAIM_LAYER = 1301");
		if (targetDate != null) {
			String date = VRDateParser.format(targetDate, "yyyy/MM/dd");
			sb.append(" AND");
			sb.append(" (M_SERVICE.SERVICE_VALID_START<='" + date + "')");
			sb.append(" AND (M_SERVICE.SERVICE_VALID_END>='" + date + "')");
		}
		sb.append(" AND M_SERVICE.SERVICE_CODE_KIND NOT IN ('A1', 'A5')");
		sb.append(" )");
		sb.append(" )");
		sb.append(" ORDER BY");
		sb.append(" M_SERVICE.SERVICE_SORT ASC");

		VRList list = null;
		if (dbm != null) {
			list = dbm.executeQuery(sb.toString());
		}
		return list;
	}

}
