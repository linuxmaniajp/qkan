
/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKAACHO（JMA care benefit management software）
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKAACHO (JMA care benefit management software)".
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
 *****************************************************************
 * アプリ: QKANCHO
 * 開発者: 藤原　伸
 * 作成日: 2005/12/06  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績確定/請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 利用者詳細データ管理 (QP001PatientState)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.print.schedule.SelfPaymentNumberCalcurater;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACFillZero10LeftFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;

/**
 * 利用者一覧（請求）(QP001)<br> 
 * 利用者の状態を取得・保持します。
 * 
 * @author shin fujihara
 * 
 */
public class QP001PatientState {

	//認定履歴情報
	private VRList ninteiHistory;
	//公費履歴情報
	private VRList kohiHistory;
	//施設履歴情報(V4.5では一件のみ)
	private VRMap shisetsuHistory;
	//異動履歴情報(当月)
	private VRList changesHistory;
    //移動履歴情報（全て）
    private VRList changesHistoryAll;
    
 // 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
    private VRList jushotiTokureiHistory;
 // 2015/1/14 [Yoichiro Kamei] add - end
 		
	//対象の利用者データ
	private VRMap patient;
    //公費自己負担額管理用Map
    private VRMap kohiSelfPay = new VRHashMap();
    
    //前月の集計結果
    VRList claim = null;
    
    //2008/09/03 [Shin Fujihara] add - begin 30日超の単位数をPatientStateに保持するよう変更
    //30日超等、集計に反映されず捨てられた単位
    private VRMap abandonedUnit = new VRHashMap();
    private VRMap abandonedDays = new VRHashMap();
    //2008/09/03 [Shin Fujihara] add - begin 30日超の単位数をPatientStateに保持するよう変更
    
    // [H30.4改正対応][Yoichiro Kamei] 2018/3/23 add - begin
    //30日超の共生型減算の計算用
    //Map<サービス種類コード, Map<サービスコード, QP001PercentageAdder>>
    Map<String, Map<String, QP001PercentageAdder>> kyouseiAdderKindMap 
    	= new HashMap<String, Map<String, QP001PercentageAdder>>();
    //Map<サービスコード, サービスコードマスタ情報>
    Map<String, Map<String, Object>> kyouseiCodes = new HashMap<String, Map<String, Object>>();
    // [H30.4改正対応][Yoichiro Kamei] 2018/3/23 add - end
    
    //[ID:0000734][Shin Fujihara] 2012/04 add start 30日超の処遇改善加算の計算
    private VRMap abandonedUnitAddition = new VRHashMap();
    //[ID:0000734][Shin Fujihara] 2012/04 add end 30日超の処遇改善加算の計算
    
    //[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
    //特地、中山間、処遇改善加算の自己負担額を退避する
    private VRMap addSelfpay = new VRHashMap();
    //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
	
    // [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - begin サービス提供体制加算の自己負担対応
    private SelfPaymentNumberCalcurater selfPaymentNumberCalcurater;
    // [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - end
    
	/**
	 * コンストラクタ<br>
	 * 第二引数patient_idで指定された利用者の第三引数targetDateに指定された月の<br>
	 * 要介護度認定履歴、公費履歴、保険区分履歴を取得し、内部変数に退避します。<br>
	 * 
	 * @param dbm DBコネクション
	 * @param patient_id 検索対象の利用者ID
	 * @param targetDate 対象日付(月まで有効)
	 */
	public QP001PatientState(ACDBManager dbm,VRMap patient, Date targetDate) throws Exception{
		//利用者情報を退避
		this.patient = patient;
		
		int patient_id = getPatientDatatoInt("PATIENT_ID");

		//対象年月のフォーマット
		String target = VRDateParser.format(targetDate,"yyyy/MM");
		
		//認定履歴情報を初期化
		initNinteiHistory(dbm,patient_id,target);
		//公費履歴を初期化
		initKohiHistory(dbm,patient_id,target);
		//施設履歴を初期化
		//[ID:0000749][Shin Fujihara] 2012/09 edit begin 2012年度対応 特定入所者の履歴管理機能
		//initShisetsuHistory(dbm,patient_id);
		initShisetsuHistory(dbm,patient_id, target);
		//[ID:0000749][Shin Fujihara] 2012/09 edit end 2012年度対応 特定入所者の履歴管理機能
		//異動履歴情報を初期化
        initChangeHistory(dbm,patient_id,target);
		
 // 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
        initJushotiTokureiHistory(dbm,patient_id,target);
 // 2015/1/14 [Yoichiro Kamei] add - end

		//摘要欄引継ぎ対応
		//前月分の請求情報を取得
		initLastMonthClaim(dbm,patient_id,targetDate);
	}
	
	protected int getPatientDatatoInt(String key) throws Exception {
		return ACCastUtilities.toInt(VRBindPathParser.get(key,patient));
	}
	protected String getPatientData(String key) throws Exception {
		return ACCastUtilities.toString(VRBindPathParser.get(key,patient));
	}
	
	public int getPatientId() throws Exception {
		return Integer.parseInt(String.valueOf(VRBindPathParser.get("PATIENT_ID",patient)));
	}
	
	/**
	 * 認定履歴情報を初期化します。
	 * @param dbm DBコネクション
	 * @param patient_id 検索対象の利用者ID
	 * @param targetDate 対象日付(月まで有効)
	 */
	private void initNinteiHistory(ACDBManager dbm,int patient_id, String targetDate) throws Exception{
		Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(targetDate + "/01"));
		
		StringBuilder sb = new StringBuilder();

		String valid_start = targetDate + "/01";
		String valid_end = VRDateParser.format(targetDateEnd,"yyyy/MM/dd") ;
		
		sb.append(" SELECT");
		sb.append(" h.PATIENT_ID,");
		sb.append(" h.NINTEI_HISTORY_ID,");
		sb.append(" h.INSURER_ID,");
		sb.append(" h.INSURED_ID,");
		sb.append(" h.INSURE_RATE,");
		sb.append(" h.PLANNER,");
		sb.append(" h.PROVIDER_ID,");
		sb.append(" h.SHUBETSU_CODE,");
		sb.append(" h.CHANGE_CODE,");
		sb.append(" h.JOTAI_CODE,");
		sb.append(" h.SHINSEI_DATE,");
		sb.append(" h.NINTEI_DATE,");
		sb.append(" h.INSURE_VALID_START,");
		sb.append(" h.INSURE_VALID_END,");
// 2014/12/17 [Yoichiro Kamei] add - begin システム有効期間対応
		sb.append(" h.SYSTEM_INSURE_VALID_START,");
		sb.append(" h.SYSTEM_INSURE_VALID_END,");
// 2014/12/17 [Yoichiro Kamei] add - end
		sb.append(" h.STOP_DATE,");
		sb.append(" h.STOP_REASON,");
		sb.append(" h.REPORTED_DATE,");
		sb.append(" h.LIMIT_RATE,");
		sb.append(" h.LAST_TIME,");
// 2016/7/18 [総合事業対応][Yoichiro Kamei] add - begin 事業対象者の限度額変更フラグ
        sb.append(" h.LIMIT_CHANGE_FLAG,");
// 2016/7/18 [総合事業対応][Yoichiro Kamei] add - end
		sb.append(" lrd_ex.LIMIT_RATE_VALUE AS EXTERNAL_USE_LIMIT");
		sb.append(" FROM");
		sb.append(" PATIENT_NINTEI_HISTORY h,");
		sb.append(" M_LIMIT_RATE lr_ex,");
		sb.append(" M_LIMIT_RATE_DETAIL lrd_ex");
		sb.append(" WHERE");
		sb.append(" (h.PATIENT_ID = " + patient_id + ")");
		sb.append(" AND (h.CHANGE_CODE = 0)");
		sb.append(" AND (h.JOTAI_CODE <> 1)");
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//		sb.append(" AND (h.INSURE_VALID_START  <= '" + valid_end + "')");
//		sb.append(" AND (h.INSURE_VALID_END >= '" + valid_start + "')");
		sb.append(" AND (h.SYSTEM_INSURE_VALID_START  <= '" + valid_end + "')");
		sb.append(" AND (h.SYSTEM_INSURE_VALID_END >= '" + valid_start + "')");
// 2014/12/17 [Yoichiro Kamei] mod - end
		sb.append(" AND (lr_ex.LIMIT_RATE_TYPE = lrd_ex.LIMIT_RATE_TYPE)");
		sb.append(" AND (lr_ex.LIMIT_RATE_HISTORY_ID = lrd_ex.LIMIT_RATE_HISTORY_ID)");
		sb.append(" AND (lr_ex.LIMIT_RATE_VALID_START <= '" + valid_end + "')");
		sb.append(" AND (lr_ex.LIMIT_RATE_VALID_END >= '" + valid_start + "')");
		sb.append(" AND (lr_ex.LIMIT_RATE_TYPE = 2)");
		sb.append(" AND (h.JOTAI_CODE = lrd_ex.JOTAI_CODE)");
		sb.append(" ORDER BY h.NINTEI_HISTORY_ID ASC");
		
		ninteiHistory = dbm.executeQuery(sb.toString());
		
        //2014/01/24 [Shinobu Hitaka] add - begin 【2014.4 区分支給限度額改定対応】
        //利用者毎の限度額を、対象年月の厚生労働省規定の区分支給限度額に差し替える
		VRMap map;
        for (int i = 0; i < ninteiHistory.getDataSize(); i++) {
            map = (VRMap) ninteiHistory.getData(i);
            int limitRate = -1;
            
            
// 2016/7/18 [総合事業対応][Yoichiro Kamei] add - begin 事業対象者の限度額変更フラグ
//            // 厚生労働省規定の区分支給限度額を取得する。
//            limitRate = QkanCommon.getOfficialLimitRate(dbm, targetDateEnd, new Integer(1), map.get("JOTAI_CODE").toString());

			// 事業対象者で「要支援１の額を超えてサービスを利用」の場合は、要支援２の限度額を使用
			int jotaiCode = ACCastUtilities.toInt(map.getData("JOTAI_CODE"), 0);
			int limitChangeFlg = ACCastUtilities.toInt(map.getData("LIMIT_CHANGE_FLAG"), 0);
			if (limitChangeFlg == 2) {
			    if (QkanConstants.YOUKAIGODO_JIGYOTAISHO == jotaiCode) {
			        jotaiCode = QkanConstants.YOUKAIGODO_YOUSHIEN2;
			    }
			}
			limitRate = QkanCommon.getOfficialLimitRate(dbm, targetDateEnd, new Integer(1), String.valueOf(jotaiCode));
//2016/7/18 [総合事業対応][Yoichiro Kamei] add - end
            if (limitRate > 0) {
                map.setData("LIMIT_RATE", limitRate);
            }
            // 厚生労働省規定の外部利用型給付上限単位数は、上記のSQLで取得しているので何もしない
        }
        //2014/01/24 [Shinobu Hitaka] add - end 【2014.4 区分支給限度額改定対応】
		
	}
	
	/**
	 * 公費履歴情報を初期化します。
	 * @param dbm DBコネクション
	 * @param patient_id 検索対象の利用者ID
	 * @param targetDate　対象日付(月まで有効)
	 */
	private void initKohiHistory(ACDBManager dbm,int patient_id, String targetDate) throws Exception{
		Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(targetDate + "/01"));
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append(" DISTINCT");
		sb.append(" PATIENT_KOHI.INSURE_TYPE,");
		sb.append(" PATIENT_KOHI.KOHI_TYPE,");
        sb.append(" PATIENT_KOHI.BENEFIT_RATE,");
		sb.append(" PATIENT_KOHI.KOHI_LAW_NO,");
		sb.append(" PATIENT_KOHI.INSURER_ID,");
		sb.append(" KOHI_LAW_NO || INSURER_ID AS KOHI_PAYER_NO,");
		sb.append(" PATIENT_KOHI.KOHI_RECIPIENT_NO,");
		sb.append(" PATIENT_KOHI.KOHI_VALID_START,");
		sb.append(" PATIENT_KOHI.KOHI_VALID_END,");
		sb.append(" PATIENT_KOHI.SELF_PAY,");
        sb.append(" M_KOHI_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");
		sb.append(" FROM");
		sb.append(" PATIENT_KOHI,");
        sb.append(" M_KOHI_SERVICE");
		sb.append(" WHERE");
		sb.append(" (PATIENT_KOHI.PATIENT_ID = " + patient_id + ")");
        sb.append(" AND (PATIENT_KOHI.KOHI_TYPE = M_KOHI_SERVICE.KOHI_TYPE)");
		sb.append(" AND (PATIENT_KOHI.KOHI_VALID_START <= '" + VRDateParser.format(targetDateEnd,"yyyy/MM/dd") + "')");
		sb.append(" AND (PATIENT_KOHI.KOHI_VALID_END >= '" + targetDate + "/01')");
		sb.append(" ORDER BY PATIENT_KOHI.KOHI_ID ASC");
		
		kohiHistory = dbm.executeQuery(sb.toString());
		
	}
	
	/**
	 * 施設情報を初期化します。
	 * @param dbm DBコネクション
	 * @param patient_id 利用者ID
	 * @param targetDate　対象日付(月まで有効)
	 * @throws Exception
	 */
	//[ID:0000749][Shin Fujihara] 2012/09 edit begin 2012年度対応 特定入所者の履歴管理機能
	//private void initShisetsuHistory(ACDBManager dbm,int patient_id) throws Exception {
	private void initShisetsuHistory(ACDBManager dbm,int patient_id, String targetDate) throws Exception {
	//[ID:0000749][Shin Fujihara] 2012/09 edit end 2012年度対応 特定入所者の履歴管理機能
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
//		sb.append(" SHOTOKU_DANKAI");
        sb.append(" TOKUTEI_NYUSHO_FLAG");
		sb.append(" ,LIMIT_SHOKUHI");
		sb.append(" ,LIMIT_UNIT_KOSHITSU");
		sb.append(" ,LIMIT_UNIT_JUNKOSHITSU");
		sb.append(" ,LIMIT_JURAIGATA1");
		sb.append(" ,LIMIT_JURAIGATA2");
		sb.append(" ,LIMIT_TASHOSHITSU");
		// 2015/6/8 [Shinobu Hitaka] add - begin H27.8改正対応　多床室(特養等と老健・療養等)に分けて保持
		sb.append(" ,LIMIT_TASHOSHITSU2");	
		// 2015/6/8 [Shinobu Hitaka] add - end
		sb.append(" ,KYUSOCHI_FLAG");
		sb.append(" ,DISEASE");
		sb.append(" FROM");
		sb.append(" PATIENT_SHISETSU_HISTORY");
		sb.append(" WHERE");
		sb.append(" (PATIENT_ID = " + patient_id + ")");
		
		//[ID:0000749][Shin Fujihara] 2012/09 add begin 2012年度対応 特定入所者の履歴管理機能
		Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(targetDate + "/01"));
		sb.append(" AND (SHISETSU_VALID_START <= '" + VRDateParser.format(targetDateEnd,"yyyy/MM/dd") + "')");
		sb.append(" AND (SHISETSU_VALID_END >= '" + targetDate + "/01')");
		//[ID:0000749][Shin Fujihara] 2012/09 add end 2012年度対応 特定入所者の履歴管理機能
		
		VRList list = dbm.executeQuery(sb.toString());
		
		if(list.getDataSize() > 0){
			shisetsuHistory = (VRMap)list.getData(0);
		} else {
			shisetsuHistory = null;
		}
	}
	
	/**
	 * 異動履歴情報を取得する。
	 * @param dbm コネクション
	 * @param patient_id 利用者ＩＤ
	 * @param targetDate 対象日
	 * @throws Exception
	 */
    private void initChangeHistory(ACDBManager dbm,int patient_id,String targetDate) throws Exception{
        Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(targetDate + "/01"));
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append(" PATIENT_CHANGES_HISTORY.CHANGES_HISTORY_ID");
		sb.append(" ,PATIENT_CHANGES_HISTORY.SYSTEM_SERVICE_KIND_DETAIL");
		sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_CONTENT");
		sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_DATE");
		sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_TIME");
		sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_REASON");
		sb.append(" ,PATIENT_CHANGES_HISTORY.REASON_MEMO");
        sb.append(" ,M_SERVICE.CHANGES_CONTENT_TYPE");
		sb.append(" FROM");
		sb.append(" PATIENT_CHANGES_HISTORY");
        sb.append(" ,M_SERVICE");
		sb.append(" WHERE");
		sb.append(" (PATIENT_CHANGES_HISTORY.PATIENT_ID = " + patient_id + ")");
        sb.append(" AND (PATIENT_CHANGES_HISTORY.SYSTEM_SERVICE_KIND_DETAIL = M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL) ");
        sb.append(" AND (PATIENT_CHANGES_HISTORY.CHANGES_DATE <= '" + VRDateParser.format(targetDateEnd,"yyyy/MM/dd") + "')");
        sb.append(" AND (PATIENT_CHANGES_HISTORY.CHANGES_DATE >= '" + targetDate + "/01')");
        sb.append(" ORDER BY PATIENT_CHANGES_HISTORY.CHANGES_HISTORY_ID DESC");
		
		changesHistory = dbm.executeQuery(sb.toString());
        
        sb = new StringBuilder();
        sb.append(" SELECT");
        sb.append(" PATIENT_CHANGES_HISTORY.CHANGES_HISTORY_ID");
        sb.append(" ,PATIENT_CHANGES_HISTORY.SYSTEM_SERVICE_KIND_DETAIL");
        sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_CONTENT");
        sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_DATE");
        sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_TIME");
        sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_REASON");
        sb.append(" ,PATIENT_CHANGES_HISTORY.REASON_MEMO");
        sb.append(" ,M_SERVICE.CHANGES_CONTENT_TYPE");
        sb.append(" FROM");
        sb.append(" PATIENT_CHANGES_HISTORY");
        sb.append(" ,M_SERVICE");
        sb.append(" WHERE");
        sb.append(" (PATIENT_ID = " + patient_id + ")");
        sb.append(" AND (PATIENT_CHANGES_HISTORY.SYSTEM_SERVICE_KIND_DETAIL = M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL) ");
        changesHistoryAll = dbm.executeQuery(sb.toString());
	}
	
// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
	/**
	 * 住所地特例履歴情報を初期化します。
	 * @param dbm DBコネクション
	 * @param patient_id 検索対象の利用者ID
	 * @param targetDate　対象日付(月まで有効)
	 */
	private void initJushotiTokureiHistory(ACDBManager dbm,int patient_id, String targetDate) throws Exception{
		Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(targetDate + "/01"));
		
		String valid_start = targetDate + "/01";
		String valid_end = VRDateParser.format(targetDateEnd,"yyyy/MM/dd") ;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append(" PATIENT_ID,");
		sb.append(" JUSHOTI_HISTORY_ID,");
		sb.append(" JUSHOTI_VALID_START,");
        sb.append(" JUSHOTI_VALID_END,");
		sb.append(" JUSHOTI_INSURER_ID");
		sb.append(" FROM");
		sb.append(" PATIENT_JUSHOTI_TOKUREI");
		sb.append(" WHERE");
		sb.append(" (PATIENT_ID = " + patient_id + ")");
		sb.append(" AND (JUSHOTI_VALID_START  <= '" + valid_end + "')");
		sb.append(" AND (JUSHOTI_VALID_END >= '" + valid_start + "')");
		sb.append(" ORDER BY JUSHOTI_HISTORY_ID ASC");
		
		jushotiTokureiHistory = dbm.executeQuery(sb.toString());
	}
// 2015/1/14 [Yoichiro Kamei] add - end
	
	/**
	 * 利用者の先月分の請求情報を取得する。
	 * @param dbm DB操作クラス
	 * @param patient_id 利用者のID
	 * @param targetDate 今回の請求対象日付
	 * @throws Exception
	 */
	private void initLastMonthClaim(ACDBManager dbm,int patient_id, Date targetDate) throws Exception {
        
        // 請求詳細情報を取得し、VRArrayList claimList に格納する。
        StringBuilder sb = new StringBuilder();
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        cal.add(Calendar.MONTH, -1);
        
        //先月の請求月を取得
        sb.append(" SELECT");
        sb.append(" DISTINCT");
        sb.append(" CLAIM_DATE");
        sb.append(" FROM");
        sb.append(" CLAIM");
        sb.append(" WHERE");
        sb.append(" (CLAIM.PATIENT_ID = " + patient_id + ")");
        sb.append(" AND (CLAIM.TARGET_DATE = '" + VRDateParser.format(cal.getTime(),"yyyy/MM/dd") + "')");
        sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        
        VRList list = dbm.executeQuery(sb.toString());
        
        if((list == null) || (list.size() == 0)){
        	return;
        }
        
        Date claimDate = ACCastUtilities.toDate(((VRMap)list.get(0)).get("CLAIM_DATE"),null);
        
        if(claimDate == null){
        	return;
        }
        
        sb = new StringBuilder();
        
        sb.append(" AND(CLAIM.TARGET_DATE = '" + VRDateParser.format(cal.getTime(),"yyyy/MM/dd") + "')");
        sb.append(" AND(CLAIM.PATIENT_ID = " + patient_id + ")");
        sb.append(" AND(CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        
        // [H30.4改正対応][Yoichiro Kamei] 2018/4/2 mod - begin
        // 基本摘要も取得
//        //履歴は、明細情報と特定診療費、訪問看護医療のみでよい
//        //[ID:0000447][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
//        //sb.append(" AND (CLAIM.CATEGORY_NO IN (3,5,13))");
//        //中止理由・入所（院）前の状況コードの引継ぎ仕様追加に伴い、
//        //基本情報レコードも退避
//        sb.append(" AND (CLAIM.CATEGORY_NO IN (2,3,5,13))");
//        //[ID:0000447][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応
//        //必要であれば、さらに条件を絞る(例：明細情報レコードのみ etc...)   
        sb.append(" AND (CLAIM.CATEGORY_NO IN (2,3,5,13,19))");
        // [H30.4改正対応][Yoichiro Kamei] 2018/4/2 mod - end
        
        //先月分の請求情報を退避
        claim = QkanCommon.getClaimDetailCustom(dbm, claimDate, sb.toString());
	}
	
	
	/**
	 * 指定された日付の保険者番号を取得する。
	 * @param targetDate
	 * @return
	 * @throws Exception
	 */
	protected String getInsurerId(Object targetDate) throws Exception{
		return getNinteiData(targetDate,"INSURER_ID");
	}
	
	/**
	 * 指定された日付の要介護状態区分を取得する。
	 * @param targetDate
	 * @return
	 */
	public String getJotaiCode(Object targetDate) throws Exception{
		return getNinteiData(targetDate,"JOTAI_CODE");
	}
	
    /**
     * 指定された日付時点で生保単独受給者であるかを返却する。
     * @param targetDate
     * @return
     * @throws Exception
     */
    protected boolean isSeihoOnly(Object targetDate) throws Exception {
        //被保険者番号がHで始まっているかで判断
        return QP001SpecialCase.isSeihoOnly(getInsuredId(targetDate));
    }
    
	/**
	 * 指定された日付の被保険者番号を取得する。
	 * @param targetDate
	 * @return
	 * @throws Exception
	 */
	protected String getInsuredId(Object targetDate) throws Exception {
		return getNinteiData(targetDate,"INSURED_ID");
	}
	
// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
	/**
	 * 指定された日付の住所地特例の施設所在保険者番号を取得する。
	 * データが存在しない場合は、空文字を返す。
	 * @param targetDate
	 * @return
	 * @throws Exception
	 */
	public String getJushotiTokureiInsurerId(Object targetDate) throws Exception{
		return getJushotiTokureiData(targetDate,"JUSHOTI_INSURER_ID");
	}
// 2015/1/14 [Yoichiro Kamei] add - end
	
	/**
	 * 指定された日付の社会福祉減免の割合を取得する。
	 * 指定日が対象外の場合は、0を返却する。
     * 社福減免の割合のみ小数点以下が入力可能であるため、10倍した値を返却する。
     * 計算時に切り捨てる。
	 * @param targetDate
	 * @param serviceCode
	 * @return
	 */
	protected int getReductionRatio(Object targetDate,String systemServiceKindDetail) throws Exception {
		VRList list = getKohiData(targetDate,3,systemServiceKindDetail);
		VRMap map;

		for(int i = 0; i < list.getDataSize(); i++){
			map = (VRMap)list.getData(i);
            String kohi_type = String.valueOf(map.get("KOHI_TYPE"));
			if(kohi_type.equals("7701") || kohi_type.equals("7702")){
                return ACCastUtilities.toInt(map.get("BENEFIT_RATE"));
			}
		}
		
		return 0;
	}
	
	/**
	 * 指定された日付の公費割合を取得する。
	 * @param targetDate
	 * @param serviceCodes
	 * @return
	 * @throws Exception
	 */
	protected int getKohiRatio(Object targetDate, String systemServiceKindDetail,String applicationType,int insureType,int medicalFlag,QP001Manager manager) throws Exception{
		VRList list = getKohiDataFromServiceKind(targetDate,systemServiceKindDetail,applicationType,insureType,medicalFlag,manager);
		int result = 0;
		
		VRMap map;
		int temp = 0;
		for(int i = 0; i < list.getDataSize(); i++){
			map = (VRMap)list.getData(i);
			//temp = ACCastUtilities.toInt(VRBindPathParser.get("BENEFIT_RATE",map));
			QP001KohiKey kohiKey = new QP001KohiKey(map);
            temp = ACCastUtilities.toInt(getKohiData(kohiKey,"BENEFIT_RATE",insureType),0);
			if(temp > result) result = temp;
			
			if(result == 100) break;
		}
		
		return result;
	}
	
	
	/**
	 * 対象日にシステム内サービスコードのサービスが該当する公費の一覧を取得する。
	 * @param targetDate 対象日
	 * @param systemServiceKindDetail システム内サービスコード
	 * @param applicationType 適用タイプ	1:サービス提供費 
	 * 																		2:緊急時施設療養管理
	 *																		3:特定診療費
	 *																		4:食事提供費
	 *																		5:利用者負担
	 * @return
	 * @throws Exception
	 */
	protected VRList getKohiDataFromServiceKind(Object targetDate, String systemServiceKindDetail,String applicationType,int insureType,int medicalFlag,QP001Manager manager) throws Exception {
		VRList result = new VRArrayList();
		//指定された日付に該当する公費情報を取得
		VRList list = getKohiData(targetDate,insureType,systemServiceKindDetail);
		
		VRMap map;
		VRMap kohiTemp;
		String kohiType;
		
		//対象日に適用対象の公費を参照する。
		for(int i = 0; i < list.getDataSize(); i++){
			map = (VRMap)list.getData(i);
			kohiType = ACCastUtilities.toString(VRBindPathParser.get("KOHI_TYPE",map));
			//kohiTemp = QP001Manager.getInstance().getKohiMatchData(kohiType,systemServiceKindDetail,applicationType);
            kohiTemp = manager.getKohiMatchData(kohiType,systemServiceKindDetail,applicationType);
			if(kohiTemp != null){
                
                /* 判定を行わないよう変更
                //BY_MEDICAL_FLAGが1の場合
                if(String.valueOf(kohiTemp.get("BY_MEDICAL_FLAG")).equals("1")){
                    //医療機関フラグが1でない場合
                    if(medicalFlag != 1){
                        continue;
                    }
                }
                */
// 2015/5/12 [Yoichiro Kamei] add - begin 公費関連見直し
			    kohiTemp.setData("SERVICE_DATE", targetDate);
			    kohiTemp.setData("KOHI_LAW_NO", map.getData("KOHI_LAW_NO"));
			    kohiTemp.setData("INSURER_ID", map.getData("INSURER_ID"));
			    kohiTemp.setData("KOHI_RECIPIENT_NO", map.getData("KOHI_RECIPIENT_NO"));
// 2015/5/12 [Yoichiro Kamei] add - end
				result.add(kohiTemp);
//				//給付率が100ならリストへの追加を打ち切る(それ以降の公費は適用されないため。)
//				if(ACCastUtilities.toString(VRBindPathParser.get("BENEFIT_RATE",kohiTemp)).equals("100"))break;
			}
		}
		return result;
	}
	
	/**
	 * 施設情報を取得する。
	 * @param key
	 * @return
	 * @throws Exception
	 */
    public String getShisetsuData(String key) throws Exception {
    	//[ID:0000749][Shin Fujihara] 2012/09 edit begin 2012年度対応 特定入所者の履歴管理機能
    	//互換のため、"TOKUTEI_NYUSHO_FLAG"、"KYUSOCHI_FLAG"が指定された時は"1"を返す
		//if (shisetsuHistory == null) return "";
    	if (shisetsuHistory == null) {
    		if ("TOKUTEI_NYUSHO_FLAG".equals(key) || "KYUSOCHI_FLAG".equals(key)) {
    			return "1";
    		}
    		return "";
    	}
		//[ID:0000749][Shin Fujihara] 2012/09 edit end 2012年度対応 特定入所者の履歴管理機能
		
		return ACCastUtilities.toString(VRBindPathParser.get(key,shisetsuHistory));
	}
	
	/**
	 * 指定された日付に該当する公費情報の取得を行います。
	 * @param targetDate 対象の日付
	 * @param kohiTypes 取得する公費対象の公費タイプ カンマ区切りで複数指定可能
	 * @return 取得データ
	 * @throws Exception
	 */
	protected VRList getKohiData(Object targetDate,int insureType,String system_service_kind_detail) throws Exception{
		VRList result = new VRArrayList();
		String target = toDateString(targetDate);
		if(target == null) return result;
		
		if(kohiHistory == null) return result;
		
		int startYMD = 0;
		int endYMD = 0;
		VRMap map = null;		
		int targetDateTemp = Integer.parseInt(target);
		
        //公費の認定履歴を検索し、指定された日付と合致するレコードを退避する。
		for(int i = 0; i < kohiHistory.getDataSize(); i++){
			map = (VRMap)kohiHistory.getData(i);
			startYMD = getInt("KOHI_VALID_START",map);
			endYMD = getInt("KOHI_VALID_END",map);
			
            //保険種類が指定されたものか確認する。
			if(ACCastUtilities.toInt(VRBindPathParser.get("INSURE_TYPE",map)) != insureType){
				continue;
			}
            //
            if(!ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",map)).equals(system_service_kind_detail)){
                continue;
            }
			
			if((startYMD <= targetDateTemp) && (targetDateTemp <= endYMD)){
				result.add(map);
			}
		}
		return result;
	}
    
	/**
	 * 公費情報を取得する。
	 * @param kohiType
	 * @param key
	 * @return
	 * @throws Exception
	 */
	protected String getKohiData(QP001KohiKey kohiKey, String key,int insureType) throws Exception {
		String result = "";

		if(kohiHistory == null) return result;
// 2015/5/12 [Yoichiro Kamei] add - begin 公費関連見直し
		if (kohiKey == null
		    || ACTextUtilities.isNullText(kohiKey.getKohiLawNo())
		    || ACTextUtilities.isNullText(kohiKey.getInsurerId())
		    || ACTextUtilities.isNullText(kohiKey.getKohiRecipientNo())) {
		    return result;
		}
// 2015/5/12 [Yoichiro Kamei] add - end
		
		VRMap map;
		for(int i = 0; i < kohiHistory.getDataSize(); i++){
			map = (VRMap)kohiHistory.getData(i);
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//	         if(ACCastUtilities.toString(VRBindPathParser.get("KOHI_TYPE",map)).equals(kohiType)
//	                    && ACCastUtilities.toInt(VRBindPathParser.get("INSURE_TYPE",map)) == insureType){
			if(ACCastUtilities.toString(VRBindPathParser.get("KOHI_LAW_NO",map)).equals(kohiKey.getKohiLawNo())
			    && ACCastUtilities.toString(VRBindPathParser.get("INSURER_ID",map)).equals(kohiKey.getInsurerId())
			    && ACCastUtilities.toString(VRBindPathParser.get("KOHI_RECIPIENT_NO",map)).equals(kohiKey.getKohiRecipientNo())
                && ACCastUtilities.toInt(VRBindPathParser.get("INSURE_TYPE",map)) == insureType
			){
// 2015/5/12 [Yoichiro Kamei] mod - end
				result = ACCastUtilities.toString(VRBindPathParser.get(key,map));
				break;
			}
		}
		return result;
	}
	
    /**
     * 公費自己負担額を取得する。
     * @param kohiType
     * @param insureType
     * @return
     * @throws Exception
     */
    protected int getKohiSelfPay(QP001KohiKey kohiKey, int insureType) throws Exception {
        int result = 0;
        //取得済みの公費自己負担額の存在チェック
        if(kohiSelfPay.containsKey(kohiKey)){
            //取得済みの公費自己負担額を取得
            result = ((Integer)kohiSelfPay.get(kohiKey)).intValue();
            
        //公費自己負担額が未取得の場合
        } else {
            //公費の履歴情報から自己負担額を取得する。
            String selfPayTemp = getKohiData(kohiKey, "SELF_PAY", insureType);
            if (!ACTextUtilities.isNullText(selfPayTemp)) {
                result = ACCastUtilities.toInt(selfPayTemp);
                //取得済み公費自己負担額として登録する。
                kohiSelfPay.put(kohiKey, new Integer(result));
            }
        }
        
        return result;
    }
    
    /**
     * 使用した公費自己負担額を設定する。
     * @param kohiType
     * @param use
     * @throws Exception
     */
    protected void setKohiSelfPayUse(QP001KohiKey kohiKey, int use) throws Exception {
        if(kohiSelfPay.containsKey(kohiKey)){
            int value = ((Integer)kohiSelfPay.get(kohiKey)).intValue();
            value -= use;
            kohiSelfPay.put(kohiKey,new Integer(value));
        }
    }
	
    /**
     * 保険者番号、被保険者番号をキーに当月最後の認定履歴情報を取得する。
     * ※自立のデータは除外する。
     * @param insurer_id 保険者番号
     * @param insured_id 被保険者番号
     * @param key 取得するキー
     * @return 取得したデータ
     * @throws Exception 実行時エラー
     */
    protected String getNinteiDataLast(String insurer_id, String insured_id,
            String key) throws Exception {
        
        String result = "";

        if (ninteiHistory == null)
            return result;

        VRMap resultMap = null;

        for (int i = 0; i < ninteiHistory.getDataSize(); i++) {
            VRMap map = (VRMap) ninteiHistory.getData(i);

            if ((String.valueOf(map.get("INSURER_ID")).equals(insurer_id))
                    && (String.valueOf(map.get("INSURED_ID")).equals(insured_id))) {
                //要介護度区分が自立なら処理を行わない
                if(ACCastUtilities.toInt(map.get("JOTAI_CODE"),1) == 1){
                    continue;
                }
                
                if(resultMap == null){
                    resultMap = (VRMap) ninteiHistory.getData(i);
                } else {
                    
                    //有効期間開始を比較する。
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//                    if (ACDateUtilities.compareOnDay(ACCastUtilities.toDate(resultMap.get("INSURE_VALID_START")),
//                            ACCastUtilities.toDate(map.get("INSURE_VALID_START"))) < 0) {
                    if (ACDateUtilities.compareOnDay(ACCastUtilities.toDate(resultMap.get("SYSTEM_INSURE_VALID_START")),
                            ACCastUtilities.toDate(map.get("SYSTEM_INSURE_VALID_START"))) < 0) {
// 2014/12/17 [Yoichiro Kamei] mod - end
                        resultMap = (VRMap) ninteiHistory.getData(i);
                    }
                }
            }
        }
        
        if(resultMap != null){
            result = String.valueOf(resultMap.get(key));
        }
        
// 2016/7/21 [SHinobu Hitaka] add - begin 事業対象者は前にゼロをつけて"06"を返す
        if ("JOTAI_CODE".equals(key) && result.length() == 1) {
            result = "0" + result;
        }
// 2016/7/21 [SHinobu Hitaka] add - end

        return result;
    }
    
    /**
     * 保険者番号、被保険者番号をキーに当月でもっとも重い認定の認定履歴情報を取得する。
     * ※自立のデータは除外する。
     * @param insurer_id 保険者番号
     * @param insured_id 被保険者番号
     * @param key 取得するキー
     * @return 取得したデータ
     * @throws Exception 実行時エラー
     */
    protected String getNinteiDataHeavy (String insurer_id, String insured_id,
            String key) throws Exception {
        
        String result = "";

        if (ninteiHistory == null)
            return result;

        VRMap resultMap = null;

        for (int i = 0; i < ninteiHistory.getDataSize(); i++) {
            VRMap map = (VRMap) ninteiHistory.getData(i);

            if ((String.valueOf(map.get("INSURER_ID")).equals(insurer_id))
                    && (String.valueOf(map.get("INSURED_ID")).equals(insured_id))) {
                //要介護度区分が自立なら処理を行わない
                if(ACCastUtilities.toInt(map.get("JOTAI_CODE"),1) == 1){
                    continue;
                }
                
                if(resultMap == null){
                    resultMap = (VRMap) ninteiHistory.getData(i);
                } else {
                    //要介護度区分を比較する。
//                    if (ACCastUtilities.toInt(resultMap.get("JOTAI_CODE"),1) <
//                            ACCastUtilities.toInt(map.get("JOTAI_CODE"),1)) {
//                        resultMap = (VRMap) ninteiHistory.getData(i);
//                    }
                    //支給限度額を比較する。
                    if (ACCastUtilities.toInt(resultMap.get("LIMIT_RATE"),0) <
                            ACCastUtilities.toInt(map.get("LIMIT_RATE"),0)) {
                        resultMap = (VRMap) ninteiHistory.getData(i);
                    }
                }
            }
        }
        
        if(resultMap != null){
            result = String.valueOf(resultMap.get(key));
        }

// 2016/7/21 [SHinobu Hitaka] add - begin 事業対象者は前にゼロをつけて"06"を返す
        if ("JOTAI_CODE".equals(key) && result.length() == 1) {
            result = "0" + result;
        }
// 2016/7/21 [SHinobu Hitaka] add - end

        return result;
    }
    
    
	/**
	 * 指定された日付に該当する認定履歴情報の取得を行います。
	 * @param targetDate 対象の日付
	 * @param key 取得するキー
	 * @return 取得データ
	 * @throws Exception
	 */
	public String getNinteiData(Object targetDate,String key) throws Exception{
		targetDate = toDateString(targetDate);
		
		String result = "";
		String target = toDateString(String.valueOf(targetDate));
		if(target == null) return result;
		
		if(ninteiHistory == null) return result;
		int startYMD = 0;
		int endYMD = 0;
		VRMap map = null;		
		int targetDateTemp = Integer.parseInt(target);
// 2017/1/20 [Yoichiro Kamei] add - begin [CCCX: 03393]対応
		VRMap targetMap = null;
// 2017/1/20 [Yoichiro Kamei] add - end
		
		for(int i = 0; i < ninteiHistory.getDataSize(); i++){
			map = (VRMap)ninteiHistory.getData(i);
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//			startYMD = getInt("INSURE_VALID_START",map);
//			endYMD = getInt("INSURE_VALID_END",map);
			startYMD = getInt("SYSTEM_INSURE_VALID_START",map);
			endYMD = getInt("SYSTEM_INSURE_VALID_END",map);
// 2014/12/17 [Yoichiro Kamei] mod - end
			if((startYMD <= targetDateTemp) && (targetDateTemp <= endYMD)){
				// 2017/1/20 [Yoichiro Kamei] add - begin [CCCX: 03393]対応
				targetMap = map;
				// 2017/1/20 [Yoichiro Kamei] add - end
				break;
			}
		}
		// 2017/1/20 [Yoichiro Kamei] mod - begin [CCCX: 03393]対応
//		if(map == null) return result;
//		
//		result = String.valueOf(VRBindPathParser.get(key,map));
		if (targetMap == null) {
			return result;
		}
		result = String.valueOf(VRBindPathParser.get(key, targetMap));
		// 2017/1/20 [Yoichiro Kamei] mod - end
		
		return result;
	}
	
	protected int getChangeDatatoInt(String systemServiceKindDetail,String chargeContent,String key,String changesContentType) throws Exception {
		int result = 0;
		try{
			result = ACCastUtilities.toInt(getChangeData(systemServiceKindDetail,chargeContent,key,changesContentType));
		} catch(Exception e){}
		return result;
		
	}
	
// 2016/8/15 [Shinobu Hitaka] add - begin 総合事業対応
    /**
     * 保険者番号、被保険者番号をキーに当月最後の要支援または事業対象者の認定履歴情報を取得する。
     * @param insurer_id 保険者番号
     * @param insured_id 被保険者番号
     * @return 取得した認定履歴情報Mapデータ
     * @throws Exception 実行時エラー
     */
    protected VRMap getNinteiDataLastShien(String insurer_id, String insured_id) throws Exception {
        
        VRMap resultMap = null;

        if (ninteiHistory == null)
            return resultMap;

        for (int i = 0; i < ninteiHistory.getDataSize(); i++) {
            VRMap map = (VRMap) ninteiHistory.getData(i);

            if ((String.valueOf(map.get("INSURER_ID")).equals(insurer_id))
                    && (String.valueOf(map.get("INSURED_ID")).equals(insured_id))) {
                //要介護度区分が要支援・事業対象者以外なら処理を行わない
            	int jotaiCode = ACCastUtilities.toInt(map.get("JOTAI_CODE"),1);
                if (jotaiCode != QkanConstants.YOUKAIGODO_JIGYOTAISHO && 
    	            jotaiCode != QkanConstants.YOUKAIGODO_YOUSHIEN1 && 
    	            jotaiCode != QkanConstants.YOUKAIGODO_YOUSHIEN2){
                    continue;
                }
                
                if (resultMap == null) {
                    resultMap = (VRMap) ninteiHistory.getData(i);
                } else {
                    
                    //有効期間開始を比較する。
                    if (ACDateUtilities.compareOnDay(ACCastUtilities.toDate(resultMap.get("SYSTEM_INSURE_VALID_START")),
                            ACCastUtilities.toDate(map.get("SYSTEM_INSURE_VALID_START"))) < 0) {
                        resultMap = (VRMap) ninteiHistory.getData(i);
                    }
                }
            }
        }
        
        if (resultMap != null) {
        	String result = String.valueOf(resultMap.get("JOTAI_CODE"));
            if (result.length() == 1) {
                result = "0" + result;
                resultMap.setData("JOTAI_CODE", result);
            }
        }

        return resultMap;
    }
// 2016/8/15 [Shinobu Hitaka] add - end 総合事業対応

// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
	/**
	 * 指定された日付に該当する住所地特例情報の取得を行います。
	 * @param targetDate 対象の日付
	 * @param key 取得するキー
	 * @return 取得データ
	 * @throws Exception
	 */
	public String getJushotiTokureiData(Object targetDate,String key) throws Exception{
		targetDate = toDateString(targetDate);
		
		String result = "";
		String target = toDateString(String.valueOf(targetDate));
		if(target == null) return result;
		
		if(jushotiTokureiHistory == null) return result;
		int startYMD = 0;
		int endYMD = 0;
		VRMap map = null;		
		int targetDateTemp = Integer.parseInt(target);
		
		for(int i = 0; i < jushotiTokureiHistory.getDataSize(); i++){
			map = (VRMap)jushotiTokureiHistory.getData(i);
			startYMD = getInt("JUSHOTI_VALID_START",map);
			endYMD = getInt("JUSHOTI_VALID_END",map);

			if((startYMD <= targetDateTemp) && (targetDateTemp <= endYMD)){
				//指定された日付で有効な住所地特例情報が見つかった場合
				result = String.valueOf(VRBindPathParser.get(key,map)); 
				break;
			}
		}
		return result;
	}
// 2015/1/14 [Yoichiro Kamei] add - end
	
	/**
	 * 異動履歴情報を取得する。
	 * @param systemServiceKindDetail システム内サービスコード
	 * @param chargeContent 異動事由
	 * @param key 取得するデータ
	 * @return
	 * @throws Exception
	 */
	protected String getChangeData(String systemServiceKindDetail,String chargeContent,String key,String changesContentType) throws Exception {
    
		String result = "";
		if(changesHistory == null) return result;
		
        String[] changesContentTypes = changesContentType.split(",");
        
		VRMap map = null;
        
		lbl:for(int i = 0; i < changesHistory.getDataSize(); i++){
			map = (VRMap)changesHistory.getData(i);
            //if(String.valueOf(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",map)).equals(systemServiceKindDetail) &&
            if(systemServiceKindDetail.indexOf(String.valueOf(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",map))) != -1 &&
                    String.valueOf(VRBindPathParser.get("CHANGES_CONTENT",map)).equals(chargeContent)){
                for(int j = 0; j < changesContentTypes.length; j++){
                    if(String.valueOf(VRBindPathParser.get("CHANGES_CONTENT_TYPE",map)).equals(changesContentTypes[j])){
                        result = ACCastUtilities.toString(VRBindPathParser.get(key,map));
                        break lbl;
                    }
                }
            }
		}
		return result;
	}
    
    /**
     * 異動履歴情報を取得する。
     * @param systemServiceKindDetail システム内サービスコード
     * @param chargeContent 異動事由
     * @param key 取得するデータ
     * @return
     * @throws Exception
     */
    protected String getChangeDataAll(String systemServiceKindDetail,String chargeContent,String key) throws Exception {
        String result = "";
        if(changesHistoryAll == null) return result;
        
        VRMap map = null;
        String sysData = "";
        String contentData = "";
        
        for(int i = 0; i < changesHistoryAll.getDataSize(); i++){
            map = (VRMap)changesHistoryAll.getData(i);
            sysData = String.valueOf(map.get("SYSTEM_SERVICE_KIND_DETAIL"));
            contentData = String.valueOf(map.get("CHANGES_CONTENT"));
            
            if(sysData.equals(systemServiceKindDetail) && contentData.equals(chargeContent)){
                result = ACCastUtilities.toString(VRBindPathParser.get(key,map));
                break;
            }
        }
        return result;
    }
    
    //[ID:0000750][Shin Fujihara] 2012/09 edit begin 2012年度対応 異動情報から入・退院日の取得方法変更
//    /**
//     * 利用者の異動履歴全体から入所日のデータを検索する。
//     * @param systemServiceKindDetail システム内サービスコード
//     * @param chargeContent 移動事由 1-開始・入所・入院・訪問開始    2-終了・退所・退院・訪問終了
//     * @param changesContentType 1-居宅系　2-施設系1　3-施設系2 4-医療看護 5-入居系
//     * @param target 検索対象日付
//     * @return 取得したCHANGES_DATE
//     * @throws Exception
//     */
//    //[ID:0000572][Shin Fujihara] 2010/01 edit begin 2009年度対応
//    // 戻り値をVRMapに変更
//    //全体的に変更しているので、差分はCVS参照
//    //protected String getChangeDataAll(String systemServiceKindDetail,String chargeContent,String changesContentType,String target) throws Exception {
//    protected VRMap getChangeDataAll(String systemServiceKindDetail,String chargeContent,String changesContentType,String target) throws Exception {
//        
//        VRMap result = null;
//        
//        if(changesHistoryAll == null) return result;
//        
//        Date candidateDate = null;
//        Date lastDate = null;
//        Date targetDate = null;
//        
//        //比較対象の日付をDateに変換する。
//        try{
//            if(target.length() == 6){
//                targetDate = ACCastUtilities.toDate(target + "01");
//            } else {
//                targetDate = ACCastUtilities.toDate(target);
//            }
//        } catch(Exception e){}
//        
//        if(targetDate == null){
//            return result;
//        }
//        
//        VRMap map = null;
//        
//        //履歴データを全走査
//        String[] changesContentTypes = changesContentType.split(",");
//        
//        for(int i = 0; i < changesHistoryAll.getDataSize(); i++){
//            map = (VRMap)changesHistoryAll.getData(i);
//            
//            //if(String.valueOf(map.get("SYSTEM_SERVICE_KIND_DETAIL")).equals(systemServiceKindDetail) &&
//            if(systemServiceKindDetail.indexOf(String.valueOf(map.get("SYSTEM_SERVICE_KIND_DETAIL"))) != -1 &&
//                    String.valueOf(map.get("CHANGES_CONTENT")).equals(chargeContent)){
//                
//                for(int j = 0; j < changesContentTypes.length; j++){
//                    if(String.valueOf(map.get("CHANGES_CONTENT_TYPE")).equals(changesContentTypes[j])){
//                        
//                        candidateDate = ACCastUtilities.toDate(map.get("CHANGES_DATE"));
//                        
//                        //取得した日付が対象月以前か確認（対象月を含む）
//                        if(ACDateUtilities.compareOnMonth(candidateDate,targetDate) <= 0){
//                            //比較対象の日付が既に存在する場合
//                            if(lastDate != null){
//                                if(ACDateUtilities.compareOnDay(lastDate,candidateDate) < 0){
//                                    lastDate = ACCastUtilities.toDate(map.get("CHANGES_DATE"));
//                                    result = map;
//                                }
//                            } else {
//                                lastDate = ACCastUtilities.toDate(map.get("CHANGES_DATE"));
//                                result = map;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        /*
//        if(lastDate != null){
//            result = String.valueOf(lastDate);
//        }
//        */
//        
//        return result;
//    }
//    //[ID:0000572][Shin Fujihara] 2010/01 edit end 2009年度対応
//    
//    /**
//     * 利用者の異動履歴全体から退所日のデータを検索する。
//     * @param systemServiceKindDetail システム内サービスコード
//     * @param chargeContent 移動事由 1-開始・入所・入院・訪問開始    2-終了・退所・退院・訪問終了
//     * @param changesContentType 1-居宅系　2-施設系1　3-施設系2 4-医療看護 5-入居系
//     * @param target 検索対象日付
//     * @return 取得したCHANGES_DATE
//     * @throws Exception
//     */
//    protected VRMap getChangeDataAllLeaving(String systemServiceKindDetail,String chargeContent,String changesContentType) throws Exception {
//        
//        VRMap result = null;
//        
//        if(changesHistoryAll == null) return result;
//        
//        Date lastDate = null;
//        int changesHistoryId = 0;
//        VRMap map = null;
//        
//        //履歴データを全走査
//        String[] changesContentTypes = changesContentType.split(",");
//        
//        for(int i = 0; i < changesHistoryAll.getDataSize(); i++){
//            map = (VRMap)changesHistoryAll.getData(i);
//            
//            //if(String.valueOf(map.get("SYSTEM_SERVICE_KIND_DETAIL")).equals(systemServiceKindDetail) &&
//            if(systemServiceKindDetail.indexOf(String.valueOf(map.get("SYSTEM_SERVICE_KIND_DETAIL"))) != -1 &&
//                    String.valueOf(map.get("CHANGES_CONTENT")).equals(chargeContent)){
//                
//                for(int j = 0; j < changesContentTypes.length; j++){
//                    if(String.valueOf(map.get("CHANGES_CONTENT_TYPE")).equals(changesContentTypes[j])){
//                        //比較対象の日付が既に存在する場合
//                        if(lastDate != null){
//                            //履歴番号を比較
//                            if(changesHistoryId < ACCastUtilities.toInt(map.get("CHANGES_HISTORY_ID"))){
//                                lastDate = ACCastUtilities.toDate(map.get("CHANGES_DATE"));
//                                changesHistoryId = ACCastUtilities.toInt(map.get("CHANGES_HISTORY_ID"),0);
//                                result = map;
//                            }
//                        } else {
//                            lastDate = ACCastUtilities.toDate(map.get("CHANGES_DATE"));
//                            changesHistoryId = ACCastUtilities.toInt(map.get("CHANGES_HISTORY_ID"),0);
//                            result = map;
//                        }
//                    }
//                }
//            }
//        }
//        
//        return result;
//    }
    
    /**
     * 利用者の異動履歴全体から入・退所日のデータを検索する。
     * @param systemServiceKindDetail システム内サービスコード
     * @param chargeContent 移動事由 1-開始・入所・入院・訪問開始    2-終了・退所・退院・訪問終了
     * @param changesContentType 1-居宅系　2-施設系1　3-施設系2 4-医療看護 5-入居系
     * @param target 検索対象日付
     * @return 取得したCHANGES_DATE
     * @throws Exception
     */
    protected VRMap getChangeDataAll(String systemServiceKindDetail, String target) throws Exception {
    	
    	VRMap result = new VRHashMap();
    	VRMap in = null; //入所レコード
    	VRMap out = null; //退所レコード
    	
    	if (changesHistoryAll == null) {
    		return result;
    	}
    	
        //比較対象の日付をDateに変換する。
    	if(target.length() == 6){
    		target += "01";
    	}
    	
    	Date targetDate = ACCastUtilities.toDate(target, null);
        if(targetDate == null){
            return result;
        }
        
        
        //yyyyMMdd(異動年月日) - 異動事由 - 履歴番号をキーにTreeMapへ格納
        Map<String, VRMap> history = new TreeMap<String, VRMap>();
        
        //必要な異動事由のタイプ
        Set<String> changesContentType = new HashSet<String>();
        changesContentType.add("2"); //施設系1
        changesContentType.add("3"); //施設系2
        changesContentType.add("5"); //入居系
        
        VRMap map = null;
        StringBuilder key = null;
        
        for(int i = 0; i < changesHistoryAll.getDataSize(); i++){
        	map = (VRMap)changesHistoryAll.getData(i);
        	
        	//サービス種類コードを確認　対象サービスでなければ読み飛ばし
        	if(systemServiceKindDetail.indexOf(String.valueOf(map.get("SYSTEM_SERVICE_KIND_DETAIL"))) == -1) {
        		continue;
        	}
        	
        	//異動事由のコードを確認　対象でなければ読み飛ばし
        	if (!changesContentType.contains(String.valueOf(map.get("CHANGES_CONTENT_TYPE")))) {
        		continue;
        	}
        	
        	//取得した日付が対象月以前か確認（対象月を含む）
        	//対象月以降であれば無視
        	Date candidateDate = ACCastUtilities.toDate(map.get("CHANGES_DATE"));
        	if(ACDateUtilities.compareOnMonth(targetDate, candidateDate) < 0){
        		continue;
        	}
        	
        	//ソート用のキーを作成し、TreeMapへ設定
        	key = new StringBuilder();
        	key.append(VRDateParser.format(candidateDate, "yyyyMMdd")); //異動日
        	key.append("-");
        	key.append(map.get("CHANGES_CONTENT"));	//異動事由
        	key.append("-");
        	key.append(ACFillZero10LeftFormat.getInstance().format(map.get("CHANGES_HISTORY_ID")));
        	
        	history.put(key.toString(), map);
        }
        
        
        //入所日、退所日を確定する
        map = null;
        for (VRMap row : history.values()) {
        	int cr = ACCastUtilities.toInt(row.get("CHANGES_CONTENT"), 0);
        	
        	//初回ループ
        	if (map == null) {
        		//入所
        		if (cr == 1) {
        			in = row;
        		//退所
        		} else if (cr == 2) {
        			out = row;
        		}
        		map = row;
        		continue;
        	}
        	
        	int cm = ACCastUtilities.toInt(map.get("CHANGES_CONTENT"), 0);
        	Date dm = ACCastUtilities.toDate(map.get("CHANGES_DATE"));
        	Date dr = ACCastUtilities.toDate(row.get("CHANGES_DATE"));
        	
        	//同じ月の場合targetDate
        	if ((ACDateUtilities.compareOnMonth(dm, dr) == 0) &&
        			(ACDateUtilities.compareOnMonth(dm, targetDate) == 0)){
        		
        		if (cm == 1) {
        			//同月に入所履歴が連続 => 退所を無効化
        			if (cr == 1) {
        				out = null;
        				
        			//入所の後の退所は採用
        			} else if (cr == 2){
        				out = row;
        			}
        			
        		} else if (cm == 2) {
        			//同月に退所 => 入所の場合は、退所を無効化
        			if (cr == 1) {
        				out = null;
        				
        			//退所の後の退所は、後の方の退所を採用
        			} else if (cr == 2){
        				out = row;
        			}
        		}
        		
        	} else {
        		//入所
        		if (cr == 1) {
        			in = row;
        		//退所
        		} else if (cr == 2) {
        			out = row;
        		}
        		map = row;
        	}
        	
        }
    	
    	result.put("IN", in);
    	result.put("OUT", out);
    	
    	return result;
    }
    
    //[ID:0000750][Shin Fujihara] 2012/09 edit end 2012年度対応 異動情報から入・退院日の取得方法変更
    
    //=================================================================================================
    // 利用者の前月実績に記載されている適用欄の内容取得
    //=================================================================================================
    
    /**
     * 指定したサービスコード、カテゴリの前月分集計に記載されている摘要欄（割引率を除く）を取得する
     * @param serviceCode サービスコード
     * @return 取得した摘要欄記載事項（割引率を除く）
     * @throws Exception
     */
    protected String getLastRecapitulationCategory3(String serviceCode) throws Exception {
    	String result = "";
    	if((claim == null) || (claim.size() == 0)){
    		return result;
    	}
    	
    	for(int i = 0; i < claim.size(); i++){
    		VRMap map = (VRMap)claim.get(i);
    		String lastServiceCode = "";
    		int categoryNo = ACCastUtilities.toInt(map.get("CATEGORY_NO"),0);
    		
    		//レコード種別が3(明細情報)以外のレコードは読み飛ばす
    		if(categoryNo != 3){
    			continue;
    		}
    		lastServiceCode = ACCastUtilities.toString(map.get("301007"),"") + ACCastUtilities.toString(map.get("301008"),"");
    		
    		//サービスコードが指定以外であれば、読み飛ばす
    		if(!serviceCode.equals(lastServiceCode)){
    			continue;
    		}

    		//摘要欄を取得
    		// 2015/4/24 [H27.4改正対応][Shinobu Hitaka] edit - begin 複数摘要がある場合の対応
//    		if(!ACTextUtilities.isNullText(ACCastUtilities.toString(map.get("301018"),""))){
//    			String[] temp = ACCastUtilities.toString(map.get("301018"),"").split("/");
//    			if(!temp[0].endsWith("%")){
//    				result = temp[0];
//    			}
//    			break;
//    		}
    		if(!ACTextUtilities.isNullText(ACCastUtilities.toString(map.get("301018"),""))){
    			String[] temp = ACCastUtilities.toString(map.get("301018"),"").split("/");
    			for ( int j = 0; j < temp.length; j++ ) {
    				if(!temp[j].endsWith("%")){
    					if (result.length() > 0) {
    						result += "/";
    					}
    					result += temp[j];
    				}
    			}
    			break;
    		}
    		// 2015/4/24 [H27.4改正対応][Shinobu Hitaka] edit - end 
    	}
    	
    	return result;
    }
    
    
    /**
     * 特定診療費レコードから傷病名を取得し、返却する。
     * @param styleIdentificationNo 交換識別番号
     * @return 取得した傷病名
     * @throws Exception
     */
    protected String getLastRecapitulationCategory5(String styleIdentificationNo) throws Exception {
    	String result = "";
    	if((claim == null) || (claim.size() == 0)){
    		return result;
    	}
    	
    	for(int i = 0; i < claim.size(); i++){
    		VRMap map = (VRMap)claim.get(i);
    		String lastStyleIdentificationNo = "";
    		int categoryNo = ACCastUtilities.toInt(map.get("CATEGORY_NO"),0);
    		
    		//レコード種別が5(特定診療費)以外のレコードは読み飛ばす
    		if(categoryNo != 5){
    			continue;
    		}
    		//交換識別番号
    		lastStyleIdentificationNo = ACCastUtilities.toString(map.get("501001"),"");
    		
    		if(!lastStyleIdentificationNo.equals(styleIdentificationNo)){
    			continue;
    		}
    		
    		//傷病名を取得
    		if(!ACTextUtilities.isNullText(ACCastUtilities.toString(map.get("501008"),""))){
    			result = ACCastUtilities.toString(map.get("501008"),"");
    			break;
    		}
    	}
    	
    	return result;
    }
    
    /**
     * 指定したサービスコード、カテゴリの前月分集計に記載されている摘要欄（割引率を除く）を取得する
     * @param serviceCode サービスコード
     * @return 取得した摘要欄記載事項（割引率を除く）
     * @throws Exception
     */
    protected String getLastRecapitulationCategory5(String styleIdentificationNo,String consultationIdentificationNo) throws Exception {
    	String result = "";
    	if((claim == null) || (claim.size() == 0)){
    		return result;
    	}
    	
    	for(int i = 0; i < claim.size(); i++){
    		VRMap map = (VRMap)claim.get(i);
    		String lastStyleIdentificationNo = "";
    		String lastConsultationIdentificationNo = "";
    		int categoryNo = ACCastUtilities.toInt(map.get("CATEGORY_NO"),0);
    		
    		//レコード種別が5(特定診療費)以外のレコードは読み飛ばす
    		if(categoryNo != 5){
    			continue;
    		}
    		//交換識別番号
    		lastStyleIdentificationNo = ACCastUtilities.toString(map.get("501001"),"");
    		
    		if(!lastStyleIdentificationNo.equals(styleIdentificationNo)){
    			continue;
    		}
    		
    		//診療識別番号
    		lastConsultationIdentificationNo = ACCastUtilities.toString(map.get("501009"),"");
    		
    		if(!lastConsultationIdentificationNo.equals(consultationIdentificationNo)){
    			continue;
    		}

    		//摘要欄を取得
    		if(!ACTextUtilities.isNullText(ACCastUtilities.toString(map.get("501023"),""))){
    			result = ACCastUtilities.toString(map.get("501023"),"");
    			break;
    		}
    	}
    	
    	return result;
    }
    
 // [H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - begin
	/**
	 * 指定した交換識別番号、摘要種類コードの前月分の基本摘要情報の摘要欄を取得する
	 * 
	 * @param styleIdentificationNo
	 *            交換識別番号
	 * @param baseSummariKind
	 *            摘要種類コード
	 * @return 取得した基本摘要欄記載事項
	 * @throws Exception
	 */
	protected String getLastRecapitulationCategory19(String styleIdentificationNo, String baseSummariKind)
			throws Exception {
		String result = "";
		if ((claim == null) || (claim.size() == 0)) {
			return result;
		}

		for (int i = 0; i < claim.size(); i++) {
			VRMap map = (VRMap) claim.get(i);
			String lastStyleIdentificationNo = "";
			String lastBaseSummariKind = "";
			int categoryNo = ACCastUtilities.toInt(map.get("CATEGORY_NO"), 0);

			// レコード種別が19(基本摘要レコード)以外のレコードは読み飛ばす
			if (categoryNo != 19) {
				continue;
			}
			// 交換識別番号
			lastStyleIdentificationNo = ACCastUtilities.toString(map.get("1901001"), "");

			if (!lastStyleIdentificationNo.equals(styleIdentificationNo)) {
				continue;
			}

			// 摘要種類コード
			lastBaseSummariKind = ACCastUtilities.toString(map.get("1901007"), "");

			if (!lastBaseSummariKind.equals(baseSummariKind)) {
				continue;
			}

			// 摘要欄を取得
			if (!ACTextUtilities.isNullText(ACCastUtilities.toString(map.get("1901008"), ""))) {
				result = ACCastUtilities.toString(map.get("1901008"), "");
				break;
			}
		}

		return result;
	}
 // [H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - end
    
    /**
     * 指定したバインドパスの訪問看護医療前月分の情報を取得する。
     * @param systemBindPath 取得対象のバインドパス
     * @return 取得した内容
     * @throws Exception
     */
    protected Object getLastDataCategory13(String systemBindPath) throws Exception {
    	Object result = null;
    	if((claim == null) || (claim.size() == 0)){
    		return result;
    	}
    	
    	for(int i = 0; i < claim.size(); i++){
    		VRMap map = (VRMap)claim.get(i);
    		int categoryNo = ACCastUtilities.toInt(map.get("CATEGORY_NO"),0);
    		
    		//レコード種別が13(訪問看護医療)以外のレコードは読み飛ばす
    		if(categoryNo != 13){
    			continue;
    		}

    		//摘要欄を取得
    		if(!ACTextUtilities.isNullText(ACCastUtilities.toString(map.get(systemBindPath),""))){
    			result = map.get(systemBindPath);
    			break;
    		}
    	}
    	
    	return result;
    }
    
    //[ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
    /**
     * 指定したバインドパスの基本情報レコードの先月請求情報を取得する。
     * @param _201001 交換識別番号
     * @param systemBindPath 取得対象のバインドパス
     * @return 取得した内容
     * @throws Exception
     */
    protected Object getLastDataCategory2(String _201001, String systemBindPath) throws Exception {
    	Object result = null;
    	if((claim == null) || (claim.size() == 0)){
    		return result;
    	}
    	
    	for(int i = 0; i < claim.size(); i++){
    		VRMap map = (VRMap)claim.get(i);
    		int categoryNo = ACCastUtilities.toInt(map.get("CATEGORY_NO"),0);
    		
    		//レコード種別が2(基本情報レコード)以外のレコードは読み飛ばす
    		if(categoryNo != 2){
    			continue;
    		}
    		
    		//交換識別番号
    		String style_id = ACCastUtilities.toString(map.get("201001"),"");
    		
    		if (!style_id.equals(_201001)){
    			continue;
    		}

    		//摘要欄を取得
    		if(!ACTextUtilities.isNullText(ACCastUtilities.toString(map.get(systemBindPath),""))){
    			result = map.get(systemBindPath);
    			break;
    		}
    	}
    	return result;
    }
    //[ID:0000447][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
    
    
    //2008/09/03 [Shin Fujihara] add - begin 30日超の単位数をPatientStateに保持するよう変更
    /**
     * 指定されたサービス種類コードで集計で無視された単位数を設定
     * @param serviceDetail サービス詳細
     * @param serviceCode サービスコード
     * @throws 
     */
    protected void putAbandonedUnit(VRMap serviceDetail,VRMap serviceCode) throws Exception {
    	
        String serviceCodeKind = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"));
        String key = serviceCodeKind + ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_ITEM"));
        int unit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"), 0);
        
        //[ID:0000717][Shin Fujihara] 2012/04 add start 平成24年4月法改正対応
        //既存障害修正
        //レコード種別が 3-特別地域 6-中山間 8-処遇改善の場合は、全額自己負担として
        //積み上げを行わないよう修正
        switch (ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0)) {
        case 3: //特別地域
        case 6: //中山間
        case 8: //処遇改善
            //[ID:0000734][Shin Fujihara] 2012/04 add start 30日超の処遇改善加算の計算
            //30日超の単位数にも、特別地域、中山間、処遇改善加算を適用する
            abandonedUnitAddition.put(serviceCodeKind + "_" + serviceCode.get("SERVICE_ADD_FLAG"), serviceCode);
            //[ID:0000734][Shin Fujihara] 2012/04 add end 30日超の処遇改善加算の計算
            return;
        }
        //[ID:0000717][Shin Fujihara] 2012/04 add end 平成24年4月法改正対応
        
        // [H30.4改正対応][Yoichiro Kamei] 2018/3/23 add - begin
        // 共生型減算のサービスコードの場合
        if (CareServiceCommon.isAddPercentageForKyousei(serviceCode)) {        	
        	//サービスコードを保持（後で計算に使用）
        	if (!kyouseiCodes.containsKey(key)) {
        		kyouseiCodes.put(key, serviceCode);
        	}
        	if (!kyouseiAdderKindMap.containsKey(serviceCodeKind)) {
        		kyouseiAdderKindMap.put(serviceCodeKind, new HashMap<String, QP001PercentageAdder>());
        	}
        	Map<String, QP001PercentageAdder> kyouseiAdderMap = kyouseiAdderKindMap.get(serviceCodeKind);
        	//共生型減算の対象となる基本サービスの単位数を保持        	
        	if (!kyouseiAdderMap.containsKey(key)) {
        		kyouseiAdderMap.put(key, new QP001PercentageAdder());
        	}
        	QP001PercentageAdder kyouseiAdder = kyouseiAdderMap.get(key);
        	Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE", serviceDetail);
        	kyouseiAdder.parse(serviceCode, targetServiceDate);
        	
        	//以降の処理は行わずリターンする
        	return;
        }        
        // [H30.4改正対応][Yoichiro Kamei] 2018/3/23 add - end
        
    	switch(ACCastUtilities.toInt(serviceCode.get("TOTAL_GROUPING_TYPE"),0)){
    	//2-日単位
    	case 2:
    		Object serviceDate = serviceDetail.get("SERVICE_DATE");
    		//既に加算したかチェックする
    		if (abandonedDays.containsKey(key)){
    			VRList days = (VRList)abandonedDays.get(key);
    			if (days.contains(serviceDate)) {
    				return;
    			}
    			days.add(serviceDate);
    		} else {
    			VRList days = new VRArrayList();
    			days.add(serviceDate);
    			abandonedDays.put(key, days);
    		}
    		break;
    	}
        
    	int total_unit = 0;
    	if (abandonedUnit.containsKey(serviceCodeKind)) {
    		total_unit = ACCastUtilities.toInt(abandonedUnit.get(serviceCodeKind), 0);
    	}
    	abandonedUnit.put(serviceCodeKind, new Integer(total_unit + unit));
    }
    /**
     * 指定されたサービス種類コードで集計で無視された単位数を取得する
     * @param serviceCodeKind サービス種類コード
     * @return 単位数
     * @throws
     */
    protected int getAbandonedUnit(String serviceCodeKind) throws Exception {
    	int result = 0;
    	if (abandonedUnit.containsKey(serviceCodeKind)){
    		result = ACCastUtilities.toInt(abandonedUnit.get(serviceCodeKind) ,0);
    	}
    	
    	//[ID:0000734][Shin Fujihara] 2012/04 add start 30日超の処遇改善加算の計算
    	//取り出した単位数が0なら処理終了
    	if (result == 0) {
    	    return result;
    	}
    	
    	VRMap serviceCode = null;
    	String key;
    	int unit = 0;
    	//加算のチェック
    	// [H30.4改正対応][Yoichiro Kamei] 2018/3/23 mod - begin　処遇改善加算以外の％減算はすべて保険請求とするよう変更
//    	//特別地域
//    	key = serviceCodeKind + "_3";
//    	if (abandonedUnitAddition.containsKey(key)) {
//    	    serviceCode = (VRMap)abandonedUnitAddition.get(key);
//    	    unit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"), 0);
//    	    result += (int) Math.round((double) ( result * unit) / 100d);
//    	}
//    	
//    	//中山間
//    	key = serviceCodeKind + "_6";
//        if (abandonedUnitAddition.containsKey(key)) {
//            serviceCode = (VRMap)abandonedUnitAddition.get(key);
//            unit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"), 0);
//            result += (int) Math.round((double) ( result * unit) / 100d);
//        }
    	// [H30.4改正対応][Yoichiro Kamei] 2018/3/23 mod - end
    	
    	// [H30.4改正対応][Yoichiro Kamei] 2018/3/23 add - begin
    	// 共生型減算の反映
    	if (kyouseiAdderKindMap.containsKey(serviceCodeKind)) {
    		Map<String, QP001PercentageAdder> kyouseiAdderMap = kyouseiAdderKindMap.get(serviceCodeKind);
        	int kyouseiUnit = 0;
        	for (String svCode : kyouseiAdderMap.keySet()) {
        		QP001PercentageAdder kyouseiAdder = kyouseiAdderMap.get(svCode);
        		Map code = kyouseiCodes.get(svCode);
        		//減算率
        		int per = ACCastUtilities.toInt(code.get("SERVICE_UNIT"), 0);
        		int totalUnit = kyouseiAdder.getUnit();
        		kyouseiUnit += CareServiceCommon.calcPercentageUnit(totalUnit, per);
        	}
        	result += kyouseiUnit;
    	}
    	// [H30.4改正対応][Yoichiro Kamei] 2018/3/23 add - end
    	
        //処遇改善
        key = serviceCodeKind + "_8";
        if (abandonedUnitAddition.containsKey(key)) {
            serviceCode = (VRMap)abandonedUnitAddition.get(key);
            unit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"), 0);
            
            int staffUnit = ACCastUtilities.toInt(serviceCode.get("SERVICE_STAFF_UNIT"), 0);
            result += CareServiceCommon.calcSyogu(result, unit, staffUnit);
        }
    	//[ID:0000734][Shin Fujihara] 2012/04 add end 30日超の処遇改善加算の計算
    	
    	return result;
    }
    //2008/09/03 [Shin Fujihara] add - end 30日超の単位数をPatientStateに保持するよう変更
    
	/**
	 * 強制的にintに変換する。
	 * @param key
	 * @param map
	 * @return
	 * @throws Exception
	 */
	private int getInt(String key,VRMap map) throws Exception {
		String target = String.valueOf(VRBindPathParser.get(key,map));
		target = target.replaceAll("-|/","");
		
		return Integer.parseInt(target);
	}
	
    /**
     * 日付に変換可能な文字列へ変更する。
     * @param value
     * @return
     * @throws Exception
     */
	private String toDateString(Object value) throws Exception {
		if(value instanceof Date){
			return toDateString((Date)value);
		} else {
			return toDateString(ACCastUtilities.toString(value));
		}
	}
	
    /**
     * yyyyMMdd型式の文字列に変換する。
     * @param value
     * @return
     * @throws Exception
     */
	private String toDateString(Date value) throws Exception {
		return toDateString(VRDateParser.format(value,"yyyyMMdd"));
	}
	
	/**
	 * 強制的に日付文字列に変換する。
	 * @param value
	 * @return
	 */
	private String toDateString(String value){
		if((value == null) || value.length() < 8) return null;
		
		StringBuilder esc = new StringBuilder();
		char[] data = value.toCharArray();
		
		for(int i = 0; i < data.length; i++){
			if("0123456789".indexOf(data[i]) != -1){
				esc.append(data[i]);
				if(esc.length() == 8) break;
			}
		}
		if(esc.length() == 8) {
			return esc.toString();
		} else {
			return null;
		}
	}
	
	
	//[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
    /**
     * 指定されたサービス種類コードで集計で無視された単位数を設定
     * @param serviceCodeKind サービス種類コード
     * @param unit 追加する単位数
     * @throws 
     */
    protected void putAddSelfpay(String serviceCodeKind, int unit) throws Exception {
        
        int total_unit = 0;
        if (addSelfpay.containsKey(serviceCodeKind)) {
            total_unit = ACCastUtilities.toInt(addSelfpay.get(serviceCodeKind), 0);
        }
        addSelfpay.put(serviceCodeKind, new Integer(total_unit + unit));
    }
    
    protected int getAddSelfpay(String serviceCodeKind) throws Exception {
        
        int result = 0;
        if (addSelfpay.containsKey(serviceCodeKind)) {
            result = ACCastUtilities.toInt(addSelfpay.get(serviceCodeKind), 0);
        }
        return result;
    }
	//[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
    
    
    //[CCCX:1653][Shinobu Hitaka] 2014/03/19 add - start 処遇改善有＋公費自己負担有の再集計
    /**
     * 公費自己負担額を設定する。
     * setKohiSelfPay->未使用化, clearKohiSelfPay->追加 2015/06/05
     * @param kohiKey
     * @param pay
     * @throws Exception
     */
    protected void setKohiSelfPay(QP001KohiKey kohiKey, int pay) throws Exception {
        if(kohiSelfPay.containsKey(kohiKey)){
            int value = ((Integer)kohiSelfPay.get(kohiKey)).intValue();
            value = pay;
            kohiSelfPay.put(kohiKey,new Integer(value));
        }
    }
    
    protected void clearKohiSelfPay() throws Exception {
    	kohiSelfPay.clear();
    }
    //[CCCX:1653][Shinobu Hitaka] 2014/03/19 add - end   処遇改善有＋公費自己負担有の再集計
    
	// [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - begin サービス提供体制加算の自己負担対応
	public SelfPaymentNumberCalcurater getSelfPaymentNumberCalcurater() {
		return selfPaymentNumberCalcurater;
	}

	public void setSelfPaymentNumberCalcurater(
			SelfPaymentNumberCalcurater selfPaymentNumberCalcurater) {
		this.selfPaymentNumberCalcurater = selfPaymentNumberCalcurater;
	}
	// [H27.4改正対応][Yoichiro Kamei] 2015/4/3 add - end
}
