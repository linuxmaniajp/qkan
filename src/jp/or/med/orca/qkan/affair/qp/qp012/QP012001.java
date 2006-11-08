package jp.or.med.orca.qkan.affair.qp.qp012;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Manager;
import jp.nichicom.ac.lib.care.claim.calculation.QP001PatientState;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style10;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style11;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style13;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style2;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style3;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style4;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style5;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style6;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style7;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style8;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style9;
import jp.nichicom.ac.lib.care.claim.calculation.QP001StyleAbstract;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceUnitGetter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.splash.ACSplash;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanMessageList;
/**
 * 訪問看護療養費明細書の実績集計クラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/08/29
 */
public class QP012001 {
	    
    // 2006/09/28 add-begin [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
    // 定義
    // 前回ループの請求先モード（保険負担モード；false, 保険外負担モード：true）
    private boolean beforeIsByPatientSpan = false; // デフォルト：保険負担モード
    // 重症者管理加算　1301082
    private int addValues_1301082 = 0; // 比較用の値
    VRMap addFixer_1301082 = null; // 算定日を確定させたサービス実績データ
	//24時間連絡体制加算　1301079
    private int addValues_1301079 = 0; // 比較用の値
    VRMap addFixer_1301079 = null; // 算定日を確定させたサービス実績データ
	//退院時共同指導加算　1301085
    private int addValues_1301085 = 0; // 比較用の値
    VRMap addFixer_1301085 = null; // 算定日を確定させたサービス実績データ
	//情報提供療養費　1301088
    private int addValues_1301088 = 0; // 比較用の値
    VRMap addFixer_1301088 = null; // 算定日を確定させたサービス実績データ
	//ターミナルケア療養費1　1301091
    private int addValues_1301091 = 0; // 比較用の値
    VRMap addFixer_1301091 = null; // 算定日を確定させたサービス実績データ
	//ターミナルケア療養費2　1301158
    private int addValues_1301158 = 0; // 比較用の値
    VRMap addFixer_1301158 = null; // 算定日を確定させたサービス実績データ
    // 2006/09/28 add-end [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
    
    
    /**
     * コンストラクタです。
     */
    public QP012001() {
        super();
    }

    /**
     * 実績を集計して返します。
     * @param patientID 利用者ID
     * @param billStart 請求期間開始
     * @param billEnd 請求期間終了
     * @param dbm DBManager
     * @return 実績
     */
    public VRMap calculate(int patientID, Date billStart, Date billEnd, ACDBManager dbm) throws Exception {
    	Date targetDate = ACDateUtilities.toFirstDayOfMonth(billStart);

        // データマネージャの初期化
        QP001Manager manager = new QP001Manager(dbm, targetDate);
            
//        // 当月に申請中の履歴が存在する場合は集計処理を行わない。
//        if (!QkanCommon.isFullDecisionPatientInsureInfo(dbm,targetDate, patientID)) {
//        	//エラーのときは空のMapをリターンする。
//			return new VRHashMap();
//		}
        
        // 利用者情報詳細取得用にVRArrayList patient を生成し、共通関数を使用して利用者情報詳細を取得する。
        VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(dbm, patientID).get(0);

        // 月次実績データ退避用の VRArrayList serviceDetailList
        // 処理対象の利用者の検索月実績データを取得する。
        VRList serviceDetailList = QkanCommon.getServiceDetail(
                dbm, patientID, targetDate,
                QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY.intValue());
        
        //サービス提供日で並び替え
        Collections.sort(serviceDetailList, new DateComparator());
        
        //指定された月の医療請求書情報を返却する。
        return calculateDetail(billStart, billEnd,patient, serviceDetailList,manager,dbm,targetDate);
    }
    
    /**
     * 医療請求書情報に関する処理を行ないます。
     * @param billStart 集計期間開始
     * @param billEnd 集計期間終了
     * @param patient 利用者データ
     * @param serviceDetailList 実績データリスト
     * @param manager マスタデータマネージャ
     * @param dbm
     * @param targetDate
     * @return
     * @throws Exception
     */
    public VRMap calculateDetail(Date billStart, Date billEnd,VRMap patient, VRList serviceDetailList,QP001Manager manager,ACDBManager dbm,Date targetDate) throws Exception {
        
        // 実績データ
        VRMap serviceDetail = null;
        VRMap serviceDetailNext = null;
        
        //暫定集計データ保存用
        VRMap tentativeCalc = new VRHashMap();
        //データ比較用Map
        VRMap omparison = new VRHashMap();
        //期間内有効データ保存用(保険有効期間内用)
        VRMap effectiveValid = new VRHashMap();
        //期間内有効データ保存用(保険有効期間外用)
        VRMap effectiveInvalid = new VRHashMap();
        
        //加算を設定したかのフラグ
        VRList additionFlag = new VRArrayList();
        
        //期間内に該当データが存在したかフラグ
        boolean hitValid = false;
        boolean hitInvalid = false;
        //リターン用
        VRMap result = new VRHashMap();
        
        // 利用者の情報を取得する。
        QP001PatientState patientState = new QP001PatientState(dbm, patient, targetDate);
        
        //全体集計用
        QP001Style13 style13 = new QP001Style13(manager);
        
        // 月次実績データ分ループする。
        for (int i = 0; i < serviceDetailList.getDataSize(); i++) {
            // サービス毎の実績データ退避用の VRHashMap serviceDetail
            // を生成し、データを退避する。
            serviceDetail = (VRMap) serviceDetailList.getData(i);
            
            //医療のサービスではない場合、処理を行わない。
            if (ACCastUtilities.toInt(serviceDetail.getData("SYSTEM_SERVICE_KIND_DETAIL"),0) != QkanConstants.CLAIM_STYLE_VISIT_DETAILED_SOCIAL_INSURANCE){
            	continue;
            }
            
            //実績データがログイン事業所のものであるか確認する。
            if(!QkanSystemInformation.getInstance().getLoginProviderID().equals(String.valueOf(serviceDetail.get("PROVIDER_ID")))){
                continue;
            }

            //2006/09/27 add-begin [Masahiko HIGUCHI]
            //月1回の加算を保険負担分と利用者負担分で分けて管理できるよう、保険負担モードを追加
            //有効期間外の実績であるか
            boolean isByPatientSpan =ACTextUtilities.isNullText(patientState.getMedicalData(serviceDetail.getData("SERVICE_DATE"),"PATIENT_ID"));
            //保険負担モードの変更(有効期間外であれば利用者負担なので、保険負担モード=false)
            style13.setInsurerMode(!isByPatientSpan);
            //2006/09/27 add-end [Masahiko HIGUCHI]
            
            // 訪問看護療養費明細書の解析
            style13.parse(serviceDetail, targetDate, patientState,null, -1);
            
        	//次の実績データの日付と比較
        	serviceDetailNext = null;
        	if((i + 1) < serviceDetailList.getDataSize()){
        		serviceDetailNext = (VRMap) serviceDetailList.getData(i + 1);
        	}
        	if ((serviceDetailNext == null)
					|| (ACDateUtilities.compareOnDay(
							ACCastUtilities.toDate(serviceDetail.getData("SERVICE_DATE")),
							ACCastUtilities.toDate(serviceDetailNext.getData("SERVICE_DATE"))) != 0)) {
        		
                // 暫定的に集計を確定させ、差分を比較する
                style13.commitRecords(patientState,null,null);
                //Map形式でデータを取得
                tentativeCalc = (VRMap)(style13.getRecords(patientState.getPatientId(),targetDate)).getData();
        		
                // 2006/09/28 add-begin [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
                // 月1回算定加算の算定を暫定確定する。
                fixAdd(beforeIsByPatientSpan, isByPatientSpan, tentativeCalc, serviceDetail);
                // 2006/09/28 add-end [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
                
                //期間の重複が無くはない場合（期間の重複がある場合）、期間の集計を行う。
                if(ACDateUtilities.getDuplicateTermCheck(billStart,billEnd,
                		ACCastUtilities.toDate(serviceDetail.getData("SERVICE_DATE")),ACCastUtilities.toDate(serviceDetail.getData("SERVICE_DATE"))) != ACDateUtilities.DUPLICATE_NONE){
                	
                	//保険の有効期間内か？
                	//有効期間外だったら
                	if(isByPatientSpan){
                    	//※比較(差があったところを集計)
                    	setPeriodCalc(tentativeCalc,omparison,effectiveInvalid,null,serviceDetail);
                    	//該当データ有
                    	hitInvalid = true;
                    	
                    //有効期間内だったら
                	} else {
                    	//※比較(差があったところを集計)
                    	setPeriodCalc(tentativeCalc,omparison,effectiveValid,effectiveInvalid,serviceDetail);
                    	//該当データ有
                    	hitValid = true;
                	}
                }
                
                //比較用のデータを最新に更新
                omparison = (VRMap)tentativeCalc.clone();
        		
        	}
        	
            // 2006/09/28 add-begin [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
            // フラグ退避
        	beforeIsByPatientSpan = isByPatientSpan;
            // 2006/09/28 add-end [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
        	
        }

        // 2006/09/28 add-begin [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
        // 確定された月1回算定加算のうち、余分な加算を削除する。
        removeExtraAdd(effectiveValid);
        removeExtraAdd(effectiveInvalid);
        // 2006/09/28 add-end [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
        
        //保険期間内に集計データが存在する場合、リターン用のMapに設定する。
        //if (hitValid){
        	setResult(tentativeCalc,
					 effectiveValid,
					 true,
					 additionFlag,
					 result);
        //}
        //保険期間外に集計データが存在する場合、リターン用のMapに設定する。
        if (hitInvalid){
        	setResult(tentativeCalc,
					 effectiveInvalid,
					 false,
					 additionFlag,
					 result);
        }
        
    	//訪問日の転送
        int start = ACDateUtilities.getDayOfMonth(billStart);
        int end = ACDateUtilities.getDayOfMonth(billEnd);
    	for(int i = 1; i <=  31; i++){
    		//magic no 1301103
    		if((start <= i) && (i <= end)){
        		result.put("PROVIDE_DAY_" + i, ACCastUtilities.toInteger(
        				tentativeCalc.get(ACCastUtilities.toString(1301103 + i)),0));
    		} else {
        		result.put("PROVIDE_DAY_" + i, new Integer(0));
    		}
    	}
        
        //結果セットを生成し、返却する。
        return result;
    }
    
    /**
     * 月一回算定加算の算定日を暫定確定するための処理
     * @param beforeIsByPatientSpan 前回ループの実績が、保険外負担かどうか。（保険外負担：true, 保険負担：false）
     * @param isByPatientSpan 今回ループの実績が、保険外負担かどうか。（保険外負担：true, 保険負担：false）
     * @param tentativeCalc 現時点での集計結果
     * @param serviceDetail 今回ループの実績
     * @throws Exception
     */
    private void fixAdd(boolean beforeIsByPatientSpan, boolean isByPatientSpan, VRMap tentativeCalc, VRMap serviceDetail) throws Exception{

        
        // 2006/09/28 add-begin [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
        // 証明書退避
        if(beforeIsByPatientSpan == isByPatientSpan){
        	// モードが同じ
        	// 値の変化があれば確定
	    	//重症者管理加算　1301082
        	if(addValues_1301082 < ACCastUtilities.toInt(tentativeCalc.getData("1301082"), 0)){
        		addValues_1301082 = ACCastUtilities.toInt(tentativeCalc.getData("1301082"), 0);
        		addFixer_1301082 = serviceDetail;
        	}
	    	//24時間連絡体制加算　1301079
        	if(addValues_1301079 < ACCastUtilities.toInt(tentativeCalc.getData("1301079"), 0)){
        		addValues_1301079 = ACCastUtilities.toInt(tentativeCalc.getData("1301079"), 0);
        		addFixer_1301079 = serviceDetail;
        	}
	    	//退院時共同指導加算　1301085
        	if(addValues_1301085 < ACCastUtilities.toInt(tentativeCalc.getData("1301085"), 0)){
        		addValues_1301085 = ACCastUtilities.toInt(tentativeCalc.getData("1301085"), 0);
        		addFixer_1301085 = serviceDetail;
        	}
	    	//情報提供療養費　1301088
        	if(addValues_1301088 < ACCastUtilities.toInt(tentativeCalc.getData("1301088"), 0)){
        		addValues_1301088 = ACCastUtilities.toInt(tentativeCalc.getData("1301088"), 0);
        		addFixer_1301088 = serviceDetail;
        	}
	    	//ターミナルケア療養費1　1301091
        	if(addValues_1301091 < ACCastUtilities.toInt(tentativeCalc.getData("1301091"), 0)){
        		addValues_1301091 = ACCastUtilities.toInt(tentativeCalc.getData("1301091"), 0);
        		addFixer_1301091 = serviceDetail;
        	}
	    	//ターミナルケア療養費2　1301158
        	if(addValues_1301158 < ACCastUtilities.toInt(tentativeCalc.getData("1301158"), 0)){
        		addValues_1301158 = ACCastUtilities.toInt(tentativeCalc.getData("1301158"), 0);
        		addFixer_1301158 = serviceDetail;
        	}
        }else{
        	// モードが異なる
        	if(beforeIsByPatientSpan){
        		// 前回：利用者負担　今回：保険負担
        		// 外→内のパタン
        		// 同一の月1回加算を保険内で優先して算定する。
        		// 実績があれば確定
        		int val;
				// 重症者管理加算 1301082
    			val = ACCastUtilities.toInt(VRBindPathParser.get("2010109", serviceDetail), 0);
    			if(val > 1){
            		addValues_1301082 = ACCastUtilities.toInt(tentativeCalc.getData("1301082"), 0);
            		addFixer_1301082 = serviceDetail;
    			}
        		// 24時間連絡体制加算 1301079
    			val = ACCastUtilities.toInt(VRBindPathParser.get("2010108", serviceDetail), 0);
    			if(val > 1){
            		addValues_1301079 = ACCastUtilities.toInt(tentativeCalc.getData("1301079"), 0);
            		addFixer_1301079 = serviceDetail;
    			}
				// 退院時共同指導加算 1301085
    			val = ACCastUtilities.toInt(VRBindPathParser.get("2010107", serviceDetail), 0);
    			if(val > 1){
            		addValues_1301085 = ACCastUtilities.toInt(tentativeCalc.getData("1301085"), 0);
            		addFixer_1301085 = serviceDetail;
    			}
				// 情報提供療養費 1301088
    			val = ACCastUtilities.toInt(VRBindPathParser.get("2010110", serviceDetail), 0);
    			if(val > 1){
            		addValues_1301088 = ACCastUtilities.toInt(tentativeCalc.getData("1301088"), 0);
            		addFixer_1301088 = serviceDetail;
    			}
				// ターミナルケア療養費1 1301091
    			val = ACCastUtilities.toInt(VRBindPathParser.get("2010111", serviceDetail), 0);
    			if(val == 2){
            		addValues_1301091 = ACCastUtilities.toInt(tentativeCalc.getData("1301091"), 0);
            		addFixer_1301091 = serviceDetail;
    			}
				// ターミナルケア療養費2 1301158
    			val = ACCastUtilities.toInt(VRBindPathParser.get("2010111", serviceDetail), 0);
    			if(val == 3){
            		addValues_1301158 = ACCastUtilities.toInt(tentativeCalc.getData("1301158"), 0);
            		addFixer_1301158 = serviceDetail;
    			}
            }else{
        		// 前回：保険負担　今回：利用者負担
        		// 内→外のパタン
        		// 前回が0円の場合（一度も確定されていない場合）のみ確定
				// 重症者管理加算 1301082
        		if(ACCastUtilities.toInt(tentativeCalc.getData("1301082"), 0) > 0){
        			if(addValues_1301082 == 0){
                		addValues_1301082 = ACCastUtilities.toInt(tentativeCalc.getData("1301082"), 0);
                		addFixer_1301082 = serviceDetail;
        			}
        		}
        		// 24時間連絡体制加算 1301079
        		if(ACCastUtilities.toInt(tentativeCalc.getData("1301079"), 0) > 0){
        			if(addValues_1301079 == 0){
                		addValues_1301079 = ACCastUtilities.toInt(tentativeCalc.getData("1301079"), 0);
                		addFixer_1301079 = serviceDetail;
        			}
        		}
				// 退院時共同指導加算 1301085
        		if(ACCastUtilities.toInt(tentativeCalc.getData("1301085"), 0) > 0){
        			if(addValues_1301085 == 0){
                		addValues_1301085 = ACCastUtilities.toInt(tentativeCalc.getData("1301085"), 0);
                		addFixer_1301085 = serviceDetail;
        			}
        		}
				// 情報提供療養費 1301088
        		if(ACCastUtilities.toInt(tentativeCalc.getData("1301088"), 0) > 0){
        			if(addValues_1301088 == 0){
                		addValues_1301088 = ACCastUtilities.toInt(tentativeCalc.getData("1301088"), 0);
                		addFixer_1301088 = serviceDetail;
        			}
        		}
				// ターミナルケア療養費1 1301091
        		if(ACCastUtilities.toInt(tentativeCalc.getData("1301091"), 0) > 0){
        			if(addValues_1301091 == 0){
                		addValues_1301091 = ACCastUtilities.toInt(tentativeCalc.getData("1301091"), 0);
                		addFixer_1301091 = serviceDetail;
        			}
        		}
				// ターミナルケア療養費2 1301158
        		if(ACCastUtilities.toInt(tentativeCalc.getData("1301158"), 0) > 0){
        			if(addValues_1301158 == 0){
                		addValues_1301158 = ACCastUtilities.toInt(tentativeCalc.getData("1301158"), 0);
                		addFixer_1301158 = serviceDetail;
        			}
        		}
            }
        }
        // 2006/09/28 add-end [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
        
    }
    
    /**
     * 確定された月1回算定加算のうち、退避していた証明用サービス実績とことなる実績により確定された加算を削除する。
     * @param effective 集計後のデータ
     * @throws Exception
     */
    private void removeExtraAdd(VRMap effective) throws Exception{

    	if(effective != null){
	    	
	    	//24時間連絡体制加算　1301079
    		removeExtraAddDetail(effective, "1301079", addFixer_1301079);
	    	
	    	//重症者管理加算　1301082
    		removeExtraAddDetail(effective, "1301082", addFixer_1301082);
	    	
	    	//退院時共同指導加算　1301085
    		removeExtraAddDetail(effective, "1301085", addFixer_1301085);
	    	
	    	//情報提供療養費　1301088
    		removeExtraAddDetail(effective, "1301088", addFixer_1301088);
	    	
	    	//ターミナルケア療養費1　1301091
    		removeExtraAddDetail(effective, "1301091", addFixer_1301091);
	    	
	    	//ターミナルケア療養費2　1301158
    		removeExtraAddDetail(effective, "1301158", addFixer_1301158);
    		
    	}
    }
    
    /**
     * 確定された月1回算定加算のうち、退避していた証明用サービス実績とことなる実績により確定された加算を削除する。
     * @param effective 集計後のデータ
     * @param key 月1回加算のキー
     * @param addFixer 月1回加算を暫定確定した実績データ
     * @throws Exception
     */
    private void removeExtraAddDetail(VRMap effective, String key, Object addFixer) throws Exception{
    	if(addFixer != null){
    		if(!(addFixer.equals(VRBindPathParser.get("FIXED_"+ key , effective)))){
    			// 暫定確定した実績（addFixer）と確定した実績（"FIXED_"+ key）の比較を行い、異なる場合に削除。
    			effective.remove(key);
    		}
    	}
    }
    
    /**
     * 差分を抜き出し、集計する。
     * @param tentativeCalc 集計後のデータ
     * @param omparison 直前の集計データ
     * @param effective 期間内集計退避用
     * @throws Exception
     */
    private void setPeriodCalc(VRMap tentativeCalc,VRMap omparison,VRMap effective,VRMap effectiveInValid,VRMap serviceDetail) throws Exception {
    	
    	//各項目において、日数が変更されているか確認する。
    	//変更されていれば、期間内に発生した請求とみなす。
    	
    	//基本療養費(I)(11)保健師、助産師、看護師、理学療法士、作業療法士 -日数(1つ目)
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301034");
    	
    	//基本療養費(I)(11)保健師、助産師、看護師、理学療法士、作業療法士 -日数(2つ目)
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301039");
    	
    	//基本療養費(I)(12)准看護師 -日数(1つ目)
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301044");
    	
    	//基本療養費(I)(12)准看護師 -日数(2つ目)
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301049");
    	
    	//基本療養費(I)(13)難病等複数回訪問加算(1日2回) -日数
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301054");
    	
    	//基本療養費(I)(13)難病等複数回訪問加算(1日3回以上) -日数
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301059");
    	
    	//基本療養費(II)(15)保健師、看護師、作業療法士 -日数
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301064");
    	
    	//基本療養費(II)(16)延長時間加算 -時間数
    	//※ここは時間で判断
    	if(tentativeCalc.get("1301069") != null){
			if(!tentativeCalc.get("1301069").equals(omparison.get("1301069"))){
				effective.put("1301069", new Integer(
						ACCastUtilities.toInt(effective.get("1301069"),0)
						+ (ACCastUtilities.toInt(tentativeCalc.get("1301069"),0) - ACCastUtilities.toInt(omparison.get("1301069"),0))
													 ));
			}
    	}
    	
    	//管理療養費 初日の金額
    	setPeriodCalcDetailDiff(tentativeCalc,omparison,effective,"1301073",null,null,null);
    	
    	//管理療養費 日数
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301075");
    	
    	//基本療養費(I)(14)緊急訪問看護加算 -日数
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301154");
    	
    	//24時間連絡体制加算
    	setPeriodCalcDetailDiff(tentativeCalc,omparison,effective,"1301079",effectiveInValid,serviceDetail,addFixer_1301079);
    	
    	//重症者管理加算
    	setPeriodCalcDetailDiff(tentativeCalc,omparison,effective,"1301082",effectiveInValid,serviceDetail,addFixer_1301082);
    	
    	//退院時共同指導加算 合計
    	setPeriodCalcDetailDiff(tentativeCalc,omparison,effective,"1301085",effectiveInValid,serviceDetail,addFixer_1301085);
    	
    	//情報提供療養費
    	setPeriodCalcDetailDiff(tentativeCalc,omparison,effective,"1301088",effectiveInValid,serviceDetail,addFixer_1301088);
    	
    	//ターミナルケア療養費1
    	setPeriodCalcDetailDiff(tentativeCalc,omparison,effective,"1301091",effectiveInValid,serviceDetail,addFixer_1301091);
    	
    	//ターミナルケア療養費2
    	setPeriodCalcDetailDiff(tentativeCalc,omparison,effective,"1301158",effectiveInValid,serviceDetail,addFixer_1301158);
    	
    	
    }
    
    /**
     * データが変更されているか比較し、変更されていれば退避用のMapのカウントをあげる
     * @param tentativeCalc 集計後のデータ
     * @param omparison 直前の集計データ
     * @param effective 期間内集計退避用
     * @param key 該当データのキー
     * @throws Exception
     */
    private void setPeriodCalcDetailDay(VRMap tentativeCalc,VRMap omparison,VRMap effective,String key) throws Exception {
    	if(tentativeCalc.get(key) == null){
    		return;
    	}
    	
    	if(!tentativeCalc.get(key).equals(omparison.get(key))){
    		//日数を加算
    		effective.put(key, new Integer(ACCastUtilities.toInt(effective.get(key),0) + 1));
    	}
    }
    
    /**
     * データが変更されているか比較し、変更されていれば退避用のMapの値を変更する。
     * @param tentativeCalc 集計後のデータ
     * @param omparison 直前の集計データ
     * @param effective 期間内集計退避用
     * @param key 該当データのキー
     * @throws Exception
     */
    private void setPeriodCalcDetailDiff(VRMap tentativeCalc,VRMap omparison,VRMap effective,String key,VRMap effectiveInValid, VRMap serviceDetail, VRMap addFixer) throws Exception {
    	if(tentativeCalc.get(key) != null){
    		if(serviceDetail == null && addFixer == null){
    			// 管理療養費の場合（今回実績が渡されない、かつ退避実績が渡されない）
            	if(!tentativeCalc.get(key).equals(omparison.get(key))){
            		effective.put(key,tentativeCalc.get(key));
            	}
    		}else{
    			// 月1回算定加算が暫定確定されている場合に、確定処理を行う。
    			if(serviceDetail.equals(addFixer)){
    				effective.put(key,tentativeCalc.get(key));
    				effective.put("FIXED_" + key,serviceDetail);
    			}
    		}
    	}
    }
    
    
    /**
     * 集計結果を編集し、返却する。
     * @param tentativeCalc １ヶ月分の全集計結果
     * @param effective 指定範囲内の各項目の日数
     * @param rate 利用者負担割合
     * @param additionFlag 加算を設定したか確認用のフラグ
     * @param result 編集した結果セット
     * @throws Exception
     */
    private void setResult(VRMap tentativeCalc, VRMap effective,
			boolean valid, VRList additionFlag,VRMap result) throws Exception {
    	
    	int increment = 1;
    	//設定確認用
    	int changeConfirmation = 0;
    	String prefix = "";
    	if (valid) {
    		//保険適用費用として計上
    		prefix = "BY_INSURER_";
    	} else {
    		prefix = "BY_PATIENT_";
    	}
    	
    	//基本療養費(I)(11)保健師、助産師、看護師、理学療法士、作業療法士 -日数(1つ目)
        // 2006/10/11
        // 文字列を変更
        // Replace - begin [Masahiko Higuchi]
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"基本療養費I (正看等)","1301033","1301034");
    	
    	//基本療養費(I)(11)保健師、助産師、看護師、理学療法士、作業療法士 -日数(2つ目)
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"基本療養費I (正看等/週4日目以降)","1301038","1301039");
    	
    	//基本療養費(I)(12)准看護師 -日数(1つ目)
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"基本療養費I (准看)","1301043","1301044");
    	
    	//基本療養費(I)(12)准看護師 -日数(2つ目)
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"基本療養費I (准看/週4日目以降)","1301048","1301049");
    	
    	//基本療養費(I)(13)難病等複数回訪問加算(1日2回) -日数
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"難病等複数回訪問加算 (1日2回まで)","1301053","1301054");
    	
    	//基本療養費(I)(13)難病等複数回訪問加算(1日3回以上) -日数
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"難病等複数回訪問加算 (1日3回以上)","1301058","1301059");
        // Replace - end [Masahiko Higuchi]
        
    	//基本療養費(I)(14)緊急訪問看護加算 -日数
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"緊急訪問看護加算","1301153","1301154");
    	
    	//基本療養費(II)(15)保健師、看護師、作業療法士 -1日あたりの金額
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"基本療養費II","1301063","1301064");
    	
    	//基本療養費(II)(16)延長時間加算 -時間数
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"延長時間加算","1301068","1301069");
    	
    	//管理療養費 初日の金額
    	//※ここだけ個別設定
        
        //基本療養費(I)(11)保健師、助産師、看護師、理学療法士、作業療法士 -日数(1つ目)
        // 2006/10/11
        // 文字列を変更
        // Replace - begin [Masahiko Higuchi]
    	increment = setResult(effective,result,prefix,increment,
    			"管理療養費 (1日目)","1301073");
    	
    	//管理療養費 日数
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"管理療養費 (2日目以降)","1301074","1301075");
        // Replace - end [Masahiko Higuchi]
    	
    	//------------保険で計上している場合、利用者全額負担では計上しない
    	//24時間連絡体制加算
    	if(!additionFlag.contains("1301079")){
    		changeConfirmation = increment; 
        	increment = setResult(effective,result,prefix,increment,
        			"24時間連絡体制加算","1301079");
        	
        	if(increment != changeConfirmation){
        		additionFlag.add("1301079");
        	}
    	}
    	
    	//重症者管理加算
    	if(!additionFlag.contains("1301082")){
    		changeConfirmation = increment;
	    	increment = setResult(effective,result,prefix,increment,
	    			"重症者管理加算","1301082");
	    	
        	if(increment != changeConfirmation){
        		additionFlag.add("1301082");
        	}
    	}
    	//退院時共同指導加算 合計
    	if(!additionFlag.contains("1301085")){
    		changeConfirmation = increment;
	    	increment = setResult(effective,result,prefix,increment,
	    			"地域連携退院時共同指導加算","1301085");
	    	
        	if(increment != changeConfirmation){
        		additionFlag.add("1301085");
        	}
    	}
    	
    	//情報提供療養費
    	if(!additionFlag.contains("1301088")){
    		changeConfirmation = increment;
	    	increment = setResult(effective,result,prefix,increment,
	    			"情報提供療養費","1301088");
	    	
        	if(increment != changeConfirmation){
        		additionFlag.add("1301088");
        	}
    	}
    	
        
    	//ターミナルケア療養費1
        
        //基本療養費(I)(11)保健師、助産師、看護師、理学療法士、作業療法士 -日数(1つ目)
        // 2006/10/11
        // 文字列を変更
        // Replace - begin [Masahiko Higuchi]
    	if(!additionFlag.contains("1301091")){
    		changeConfirmation = increment;
	    	increment = setResult(effective,result,prefix,increment,
	    			"ターミナルケア療養費I","1301091");
	    	
        	if(increment != changeConfirmation){
        		additionFlag.add("1301091");
        	}
    	}
    	
    	//ターミナルケア療養費2
    	if(!additionFlag.contains("1301158")){
    		changeConfirmation = increment;
	    	increment = setResult(effective,result,prefix,increment,
	    			"ターミナルケア療養費II","1301158");
	    	
        	if(increment != changeConfirmation){
        		additionFlag.add("1301158");
        	}
    	}
        // Replace - end [Masahiko Higuchi]
        
        // 2006/09/19
        // Addition - begin [Masahiko Higuchi]
        // 存在しない項目はKEYのみを返す。
        for(int i = increment ; i <= 20 ;i++){
            result.put(prefix + "NAME" + increment,"");
            //単価
            result.put(prefix + "PRICE" + increment,"");
            //日数
            result.put(prefix + "NUMBER" + increment,"");
            //合計
            result.put(prefix + "SUM" + increment,"");
            
            increment++;
            
        }
        // Addition - end
        
    	//------------------------------------------------------------------
    }
    
    private int setResult(VRMap tentativeCalc, VRMap effective,VRMap result,
    		String prefix,int increment,String title, String priceKey,String dayKey) throws Exception {    
    	
    	if(ACCastUtilities.toInt(effective.get(dayKey),0) == 0){
    		return increment;
    	}
    	
		//項目名
		result.put(prefix + "NAME" + increment,title);
		//単価
		result.put(prefix + "PRICE" + increment,tentativeCalc.get(priceKey));
		//日数
		result.put(prefix + "NUMBER" + increment,effective.get(dayKey));
		//合計
		result.put(prefix + "SUM" + increment,new Integer(ACCastUtilities.toInt(tentativeCalc.get(priceKey),0)
												 * ACCastUtilities.toInt(effective.get(dayKey),0)));
		
    	return increment + 1;
    }
    
    private int setResult(VRMap period,VRMap result,
    		String prefix,int increment,String title, String priceKey) throws Exception {
    	
    	if (ACTextUtilities.isNullText(period.get(priceKey))) {
    		return increment;
    	}
		//項目名
		result.put(prefix + "NAME" + increment,title);
		//単価
		result.put(prefix + "PRICE" + increment,period.get(priceKey));
		//日数
		result.put(prefix + "NUMBER" + increment, "1");
		//合計
		result.put(prefix + "SUM" + increment, period.get(priceKey));
    	
    	return increment + 1;
    }
    
    
    /**
     * 日付で実績をソートする。
     */
    private class DateComparator implements java.util.Comparator {
        public int compare(Object object1, Object object2) {
            //日付で並び替えるクラス
            Date date1 = ACCastUtilities.toDate(((Map)object1).get("SERVICE_DATE"), null);
            Date date2 = ACCastUtilities.toDate(((Map)object2).get("SERVICE_DATE"), null);
            if(date1==null){
                if(date2==null){
                    return 0;
                }
                return -1;
            }else if(date2==null){
                return 1;
            }
            return date1.compareTo(date2);
        }
    }
}
