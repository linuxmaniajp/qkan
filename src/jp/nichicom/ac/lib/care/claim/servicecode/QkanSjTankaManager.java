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
package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 総合事業の単位数単価を取得するためのクラス
 * 
 * @since V7.3.0
 * @author Yoichiro.Kamei
 */
public class QkanSjTankaManager {
	
	private static boolean initialized = false; //初期化済みかどうか

	private static VRMap tankaMap = new VRHashMap();

	
	/**
	 * 初期化処理を行います。
	 * @throws Exception 
	 */
	public static synchronized void initialize(ACDBManager dbm, Date targetDate) throws Exception {
		tankaMap.clear();
		
		VRList results = getInsurerUnitPrice(dbm, targetDate);
		ACBindUtilities.setHashListFromArray(results, tankaMap, "INSURER_ID");
		
		Iterator it = tankaMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry ent = (Map.Entry) it.next();
			VRMap sMap = new VRHashMap();
			ACBindUtilities.setHashListFromArray((VRList) ent.getValue(), sMap, "SYSTEM_SERVICE_KIND_DETAIL");
			ent.setValue(sMap);
		}
		initialized = true;
	}



	/**
	 * 指定された保険者、サービス種類の単価を取得します。
	 * 
	 * @param insurerId 保険者番号
	 * @param systemServiceKindDetail システムサービス種類コード
	 * @return
	 * @throws Exception
	 */
	public static Double getUnitPrice(String insurerId, String systemServiceKindDetail
			) throws Exception {
		if (!initialized) {
			throw new RuntimeException("初期化されていません。initialzeを呼んでください。");
		}
		if (tankaMap.containsKey(insurerId)) {
			Map insMap = (Map) tankaMap.get(insurerId);
			int kind = ACCastUtilities.toInt(systemServiceKindDetail);
			if (insMap.containsKey(kind)) {
				Object val = insMap.get(kind);
				if ((val instanceof List) && (!((List) val).isEmpty())) {
					Map row = (Map) ((List) val).get(0);
					return ACCastUtilities.toDouble(row.get("UNIT_PRICE_VALUE"), 10.00d);
				}
			}
		}
		String message = "該当する保険者の地域単価が存在しません。[" + insurerId + "-"
				+ systemServiceKindDetail + "]";
		throw new QkanSjTankaNotFoundException(insurerId, systemServiceKindDetail, message);
	}

	/**
	 * 対象年月における総合事業単価取得関数です。
	 * 
	 * @param dbm
	 *            DBManager
	 * @param targetDate
	 *            対象年月        
	 * @return データベースより取得した結果リスト
	 * @throws Exception
	 *             処理例外
	 */
	public static VRList getInsurerUnitPrice(ACDBManager dbm, Date targetDate)
			throws Exception {

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" INSURER_UNIT_PRICE.INSURER_ID");
		sb.append(",INSURER_UNIT_PRICE.UNIT_PRICE_HISTORY_ID");
		sb.append(",INSURER_UNIT_PRICE.UNIT_PRICE_VALID_START");
		sb.append(",INSURER_UNIT_PRICE.UNIT_PRICE_VALID_END");
		sb.append(",INSURER_UNIT_PRICE.UNIT_PRICE_TYPE");
		sb.append(",INSURER_UNIT_PRICE_DETAIL.SYSTEM_SERVICE_KIND_DETAIL");
		sb.append(",INSURER_UNIT_PRICE_DETAIL.UNIT_PRICE_VALUE");
		sb.append(" FROM");
		sb.append(" INSURER_UNIT_PRICE");
		sb.append(" LEFT OUTER JOIN INSURER_UNIT_PRICE_DETAIL");
		sb.append(" ON INSURER_UNIT_PRICE.INSURER_ID = INSURER_UNIT_PRICE_DETAIL.INSURER_ID");
		sb.append(" AND INSURER_UNIT_PRICE.UNIT_PRICE_HISTORY_ID = INSURER_UNIT_PRICE_DETAIL.UNIT_PRICE_HISTORY_ID");
		
		String date = VRDateParser.format(targetDate, "yyyy/MM/dd");
		sb.append(" WHERE");
		sb.append(" (INSURER_UNIT_PRICE.UNIT_PRICE_VALID_START<='" + date + "')");
		sb.append(" AND (INSURER_UNIT_PRICE.UNIT_PRICE_VALID_END>='" + date + "')");
	
		sb.append(" ORDER BY");
		sb.append(" INSURER_UNIT_PRICE.INSURER_ID ASC");
		sb.append(" ,INSURER_UNIT_PRICE_DETAIL.SYSTEM_SERVICE_KIND_DETAIL ASC");
		
		return dbm.executeQuery(sb.toString());
	}
	


}
