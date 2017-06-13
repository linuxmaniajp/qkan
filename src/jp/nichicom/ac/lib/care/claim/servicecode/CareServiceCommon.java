package jp.nichicom.ac.lib.care.claim.servicecode;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * サービス関連の共通関数です。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class CareServiceCommon {

    /**
     * 給付管理限度額対象であることをあらわす給付管理限度額対象定数です。
     */
    public static final Integer IN_LIMIT_AMOUNT_SERVICE = new Integer(1);
    /**
     * 給付管理限度額対象外であることをあらわす給付管理限度額対象定数です。
     */
    public static final Integer OUT_LIMIT_AMOUNT_SERVICE = new Integer(2);
    /**
     * 外部利用型であることをあらわす給付管理限度額対象定数です。
     */
    public static final Integer OUTER_SERVICE_LIMIT_AMOUNT = new Integer(3);

    /**
     * 給付管理限度額対象のサービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return 給付管理限度額対象のサービスコードであるか
     */
    public static boolean isInLimitAmount(Map code) {
        // 給付管理限度額対象フラグを取得する。
        // 0：食費等、単位数で管理しないサービス
        // 1：給付管理限度額対象
        // 2：給付管理限度額対象外
        return IN_LIMIT_AMOUNT_SERVICE.equals(code.get("LIMIT_AMOUNT_OBJECT"));
    }

    /**
     * 特地加算(福祉用具貸与含む)のサービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return 特地加算(福祉用具貸与含む)のサービスコードであるか
     */
    public static boolean isAddSpecialArea(Map code) {
    	// [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - begin サービスコード英数化
//        switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_KIND"), 0)) {
//        case 11:// 訪問介護
//        case 12:// 訪問入浴介護
//        case 62:// 予防訪問入浴介護
//        case 63:// 予防訪問看護
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 8000:// 特別地域加算
//                return true;
//            }
//            break;
//        case 13:// 訪問看護
//        case 61:// 予防訪問介護
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 8000:// 特別地域加算
//            case 8001:// 特別地域加算日割
//                return true;
//            }
//            break;
//        case 17:// 福祉用具貸与
//        case 67:// 予防福祉用具貸与
//            return isAddSpecialAreaOfWelfareEquipment(code);
//        }
        String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "");
        String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"), "");
        if ("11".equals(serviceCodeKind)		// 訪問介護
        	|| "12".equals(serviceCodeKind)		// 訪問入浴介護
        	|| "62".equals(serviceCodeKind)		// 予防訪問入浴介護
        	|| "63".equals(serviceCodeKind)		// 予防訪問看護
        	) {
        	// 特別地域加算
            if ("8000".equals(serviceCodeItem)) {
                return true;
            }
        }
        if ("13".equals(serviceCodeKind)		// 訪問看護
               	) {
            	// 特別地域加算 or 特別地域加算日割
                if ("8000".equals(serviceCodeItem) || "8001".equals(serviceCodeItem) || "8002".equals(serviceCodeItem)) {
                    return true;
                }
            }
        if ("61".equals(serviceCodeKind)		// 予防訪問介護
        	|| "76".equals(serviceCodeKind)		// 定期巡回・随時対応型訪問介護看護
           	) {
        	// 特別地域加算 or 特別地域加算日割
            if ("8000".equals(serviceCodeItem) || "8001".equals(serviceCodeItem)) {
                return true;
            }
        }
        if ("17".equals(serviceCodeKind)		// 福祉用具貸与
        	|| "67".equals(serviceCodeKind)		// 予防福祉用具貸与
           	) {
        	return isAddSpecialAreaOfWelfareEquipment(code);
        }
        // [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - end   サービスコード英数化
        
        return false;
    }

    /**
     * 福祉用具貸与における特地加算のサービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return 福祉用具貸与における特地加算のサービスコードであるか
     */
    public static boolean isAddSpecialAreaOfWelfareEquipment(Map code) {
        // 給付管理対象外かつ単位加算かつ回単位算定かつ福祉用具貸与
        if (!isInLimitAmount(code)) {
            if ("2".equals(ACCastUtilities.toString(
                    code.get("SERVICE_ADD_FLAG"), ""))) {
                if ("1".equals(ACCastUtilities.toString(
                        code.get("TOTAL_GROUPING_TYPE"), ""))) {
                	// [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - begin サービスコード英数化
//                    switch (ACCastUtilities.toInt(
//                            code.get("SERVICE_CODE_KIND"), 0)) {
//                    case 17:// 福祉用具貸与
//                    case 67:// 予防福祉用具貸与
//                        return true;
//                    }
                	// 17:福祉用具貸与 or 67:予防福祉用具貸与
                	String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "");
                	if ("17".equals(serviceCodeKind) || "67".equals(serviceCodeKind)) {
                		return true;
                	}
                    // [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - end   サービスコード英数化
                }
            }
        }
        return false;
        // return (!isInLimitAmount(code))
        // && "2".equals(ACCastUtilities.toString(code
        // .get("SERVICE_ADD_FLAG")))
        // && "1".equals(ACCastUtilities.toString(code
        // .get("TOTAL_GROUPING_TYPE"), ""))
        // && "17".equals(ACCastUtilities.toString(code
        // .get("SERVICE_CODE_KIND"), ""));
    }

    /**
     * %単位加算のサービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return %単位加算のサービスコードであるか
     * @throws Exception 処理例外
     */
    public static boolean isAddPercentage(Map code) throws Exception {
        if (code != null) {
            switch (ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0)) {
            case 3:
                // %加算
            case 5:
                // %減算
            case 6:
                // %加算(対象に地域系加算を含む)
            case 7:
                // %減算(対象に地域系加算を含む)
                // [ID:0000682] 2012/01 start 介護職員処遇改善加算の追加処理
            case 8:
                // %加算(介護職員処遇改善加算)
                // [ID:0000682] 2012/01 end
                return true;
            }
        }
        return false;
    }

    // [ID:0000682] 2012/01 start 介護職員処遇改善加算の追加処理
    /**
     * %単位加算のうち計算対象で処遇改善加算の対象であるかを返します。
     * 
     * @param code サービスコード
     * @return %単位加算のうち処遇改善加算であるかを返します
     * @throws Exception 処理例外
     */
    public static boolean isAddPercentageForSyogu(Map code) {
        if (code != null) {
            switch (ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0)) {
            case 8:
                return true;
            }
        }
        return false;
    }

    // [ID:0000682] 2012/01 end

    // [ID:0000444][Tozo TANAKA] 2009/03/20 add begin 平成21年4月法改正対応
    /**
     * %単位加算のうち計算対象に地域系加算を含まないサービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return %単位加算のうち対象に地域系加算を含まないサービスコードであるか
     * @throws Exception 処理例外
     */
    public static boolean isAddPercentageForSimple(Map code) throws Exception {
        if (code != null) {
            switch (ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0)) {
            case 3:
                // %加算
            case 5:
                // %減算
                return true;
            }
        }
        return false;
    }

    /**
     * %単位加算のうち計算対象に地域系加算を含むサービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return %単位加算のうち対象に地域系加算を含むサービスコードであるか
     * @throws Exception 処理例外
     */
    public static boolean isAddPercentageForArea(Map code) throws Exception {
        if (code != null) {
            switch (ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0)) {
            case 6:
                // %加算(対象に地域系加算を含む)
            case 7:
                // %減算(対象に地域系加算を含む)
                return true;
            }
        }
        return false;
    }

    /**
     * %加算(対象に地域系加算を含む)の対象になる地域系加算サービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return %加算(対象に地域系加算を含む)の対象になる地域系加算サービスコードであるか
     * @throws Exception 処理例外
     */
    public static boolean isAddPercentageForAreaTarget(Map code)
            throws Exception {
        if (code != null) {
            String item = ACCastUtilities.toString(code
                    .get("SYSTEM_SERVICE_CODE_ITEM"));
            if (
            // 特別地域
            "Z8000".equals(item)
            // 特別地域(日割)
                    || "Z8001".equals(item)
                    // 中山間地域等の小規模事業所
                    || "Z8100".equals(item)
                    // 中山間地域等の小規模事業所(日割)
                    || "Z8101".equals(item)) {
                return true;
            }
        }
        return false;
    }

    // [ID:0000444][Tozo TANAKA] 2009/03/20 add end

    /**
     * 基本的な合成単位のサービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return 基本的な合成単位のサービスコードであるか
     * @throws Exception 処理例外
     */
    public static boolean isSimpleUnit(Map code) throws Exception {
        // return (code != null)
        // && "1".equals(ACCastUtilities.toString(code
        // .get("SERVICE_ADD_FLAG")));
        // 本体報酬フラグが有効 And
        // 給付限度額管理対象内 or 外部利用型単位数
        if (code != null) {
            if ("1".equals(ACCastUtilities.toString(code
                    .get("SERVICE_MAIN_FLAG")))
                    && ("1".equals(ACCastUtilities.toString(code
                            .get("LIMIT_AMOUNT_OBJECT"))) || ("3"
                            .equals(ACCastUtilities.toString(code
                                    .get("LIMIT_AMOUNT_OBJECT")))))) {
                return true;
            }
        }

        return false;

    }

    /**
     * 緊急時訪問看護加算を意味するサービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return 緊急時訪問看護加算を意味するサービスコードであるか
     */
    public static boolean isAddEmergencyNursing(Map code) {
    	// [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - begin サービスコード英数化
//        switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_KIND"), 0)) {
//        case 13:// 訪問看護
//        case 63:// 予防訪問看護
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 3100:// 緊急時訪問看護加算１
//            case 3200:// 緊急時訪問看護加算２
//                return true;
//            }
//        }
        String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "");
        String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"), "");
        if ("13".equals(serviceCodeKind)		// 訪問看護
            || "63".equals(serviceCodeKind)		// 予防訪問看護
        	) {
        	//3100:緊急時訪問看護加算１ or 3200:緊急時訪問看護加算２
        	if ("3100".equals(serviceCodeItem) || "3200".equals(serviceCodeItem)) {
                return true;
            }
        }
        // [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - end   サービスコード英数化
        
        return false;
    }

    /**
     * 特別管理加算を意味するサービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return 特別管理加算を意味するサービスコードであるか
     */
    public static boolean isAddSpecialManagement(Map code) {
    	// [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - begin サービスコード英数化
//        switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_KIND"), 0)) {
//        case 13:// 訪問看護
//        case 63:// 予防訪問看護
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 4000:// 特別管理加算１
//            case 4001:// 特別管理加算２
//                return true;
//            }
//        }
        String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "");
        String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"), "");
        if ("13".equals(serviceCodeKind)		// 訪問看護
            || "63".equals(serviceCodeKind)		// 予防訪問看護
        	) {
        	//4000:特別管理加算１ or 4001:特別管理加算２
        	if ("4000".equals(serviceCodeItem) || "4001".equals(serviceCodeItem)) {
                return true;
            }
        }
        // [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - end   サービスコード英数化
        
        return false;
    }

    /**
     * 緊急時治療管理を意味するサービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return 緊急時治療管理を意味するサービスコードであるか
     */
    public static boolean isAddEmergencyMedicalManagement(Map code) {
    	// [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - begin サービスコード英数化
//        switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_KIND"), 0)) {
//        case 22:// 短期入所
//        case 25:// 予防短期入所
//        case 52:// 保健施設
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 9000:// 緊急時治療管理１
//            case 6000:// 緊急時治療管理２
//                return true;
//            }
//        }
        String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "");
        String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"), "");
        if ("22".equals(serviceCodeKind)		// 短期入所
            || "25".equals(serviceCodeKind)		// 予防短期入所
            || "52".equals(serviceCodeKind)		// 保健施設
        	) {
        	//9000:緊急時治療管理１ or 6000:緊急時治療管理２
        	if ("9000".equals(serviceCodeItem) || "6000".equals(serviceCodeItem)) {
                return true;
            }
        }
        // [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - end   サービスコード英数化
        
        return false;
    }

    /**
     * ターミナルケア加算を意味するサービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return 特別管理加算を意味するサービスコードであるか
     */
    public static boolean isAddTerminalCare(Map code) {
    	// [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - begin サービスコード英数化
//        switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_KIND"), 0)) {
//        case 13:// 訪問看護
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 7000:// ターミナルケア加算
//                return true;
//            }
//            break;
//        case 52: // 介護療養型老人保健施設
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 6600: // 保健施設ターミナルケア加算１１
//            case 6001: // 保健施設ターミナルケア加算１２
//            case 6602: // 保健施設ターミナルケア加算２１
//            case 6002: // 保健施設ターミナルケア加算２２
//            case 6603: // 保健施設ターミナルケア加算３１
//            case 6003: // 保健施設ターミナルケア加算３２
//                return true;
//            }
//            break;
//
//        }
        String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "");
        String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"), "");
        // 訪問看護
        if ("13".equals(serviceCodeKind)) {
        	//7000:ターミナルケア加算
        	if ("7000".equals(serviceCodeItem)) {
                return true;
            }
        }
        // 介護療養型老人保健施設
        if ("52".equals(serviceCodeKind)) {
            	if ("6600".equals(serviceCodeItem)		//保健施設ターミナルケア加算１１
            		|| "6001".equals(serviceCodeItem)	//保健施設ターミナルケア加算１２
            		|| "6602".equals(serviceCodeItem)	//保健施設ターミナルケア加算２１
            		|| "6002".equals(serviceCodeItem)	//保健施設ターミナルケア加算２２
            		|| "6603".equals(serviceCodeItem)	//保健施設ターミナルケア加算３１
            		|| "6003".equals(serviceCodeItem)	//保健施設ターミナルケア加算３２
            		) {
                    return true;
                }
        }
        // [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - end   サービスコード英数化
        return false;
    }

    /**
     * 給付管理限度額対象外のサービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return 給付管理限度額対象外のサービスコードであるか
     */
    public static boolean isOutLimitAmount(Map code) {
        return OUT_LIMIT_AMOUNT_SERVICE.equals(code.get("LIMIT_AMOUNT_OBJECT"));
    }

    /**
     * 外部利用型のサービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return 外部利用型のサービスコードであるか
     */
    public static boolean isOuterServiceLimitAmount(Map code) {
        return OUTER_SERVICE_LIMIT_AMOUNT.equals(code
                .get("LIMIT_AMOUNT_OBJECT"));
    }

    /**
     * 通所系サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 通所系サービスであるか
     */
    public static boolean isFacilityVisit(int systemServiceKindDetail) {
        return isFacilityVisitCare(systemServiceKindDetail)
                || isFacilityVisitRehabilitation(systemServiceKindDetail)
                || isFacilityVisitMultifunction(systemServiceKindDetail);
    }

    /**
     * 通所系サービスであるかを返します。
     * 
     * @param service サービス
     * @return 通所系サービスであるか
     */
    public static boolean isFacilityVisit(Map service) {
        return isFacilityVisit(toInt(service));
    }

    /**
     * 通所系サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 通所系サービスであるか
     */
    public static boolean isFacilityVisit(String systemServiceKindDetail) {
        return isFacilityVisit(toInt(systemServiceKindDetail));
    }

    /**
     * 施設系サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 施設系サービスであるか
     */
    public static boolean isFacility(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 15111:// 介護老人福祉施設
        case 15211:// 介護老人保健施設
        case 15311:// 介護療養型医療施設(療養病床を有する病院)
        case 15312:// 介護療養型医療施設(療養病床を有する診療所)
        case 15313:// 介護療養型医療施設(老人性認知症疾患療養病棟を有する病院)
        case 15411:// 地域密着型介護福祉施設
            return true;
        }
        return false;
    }

    /**
     * 認知症対応型共同生活介護もしくは特定施設入所者生活介護であるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 認知症対応型共同生活介護もしくは特定施設入所者生活介護であるか
     */
    public static boolean isLifeCare(int systemServiceKindDetail) {
        return isLifeCareInGroupHome(systemServiceKindDetail)
                || isLifeCareInCareHouse(systemServiceKindDetail);
    }

    /**
     * 認知症対応型共同生活介護もしくは特定施設入所者生活介護であるかを返します。
     * 
     * @param service サービス
     * @return 認知症対応型共同生活介護もしくは特定施設入所者生活介護であるか
     */
    public static boolean isLifeCare(Map service) {
        return isLifeCare(toInt(service));
    }

    /**
     * 認知症対応型共同生活介護もしくは特定施設入所者生活介護であるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 認知症対応型共同生活介護もしくは特定施設入所者生活介護であるか
     */
    public static boolean isLifeCare(String systemServiceKindDetail) {
        return isLifeCare(toInt(systemServiceKindDetail));
    }

    /**
     * 認知症対応型共同生活介護であるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 認知症対応型共同生活介護であるか
     */
    public static boolean isLifeCareInGroupHome(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 13211:// 認知症対応型共同生活介護(短期利用以外)
        case 13711: // 介護予防認知症対応型共同生活介護（短期利用以外）
            return true;
        }
        return false;
    }

    /**
     * 認知症対応型共同生活介護であるかを返します。
     * 
     * @param service サービス
     * @return 認知症対応型共同生活介護であるか
     */
    public static boolean isLifeCareInGroupHome(Map service) {
        return isLifeCareInGroupHome(toInt(service));
    }

    /**
     * 認知症対応型共同生活介護であるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 認知症対応型共同生活介護であるか
     */
    public static boolean isLifeCareInGroupHome(String systemServiceKindDetail) {
        return isLifeCareInGroupHome(toInt(systemServiceKindDetail));
    }

    /**
     * 特定施設入所者生活介護であるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 特定施設入所者生活介護であるか
     */
    public static boolean isLifeCareInCareHouse(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 13311:// 特定施設入所者生活介護
        case 13611:// 地域密着型特定施設入居者生活介護
        case 13511: // 介護予防特定施設入居者生活介護
            return true;
        }
        return false;
    }

    /**
     * 特定施設入所者生活介護であるかを返します。
     * 
     * @param service サービス
     * @return 特定施設入所者生活介護であるか
     */
    public static boolean isLifeCareInCareHouse(Map service) {
        return isLifeCareInCareHouse(toInt(service));
    }

    /**
     * 特定施設入所者生活介護であるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 特定施設入所者生活介護であるか
     */
    public static boolean isLifeCareInCareHouse(String systemServiceKindDetail) {
        return isLifeCareInCareHouse(toInt(systemServiceKindDetail));
    }

    /**
     * 訪問介護であるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 訪問介護であるか
     */
    public static boolean isHomeVisitCare(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 11111:// 訪問介護
        case 17111:// 夜間対応型訪問介護
        case 16111: // 介護予防訪問介護
        case 17611: // 定期巡回・随時対応型訪問介護看護
            return true;
        }
        return false;
    }

    /**
     * 訪問介護であるかを返します。
     * 
     * @param service サービス
     * @return 訪問介護であるか
     */
    public static boolean isHomeVisitCare(Map service) {
        return isHomeVisitCare(toInt(service));
    }

    /**
     * 訪問介護であるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 訪問介護であるか
     */
    public static boolean isHomeVisitCare(String systemServiceKindDetail) {
        return isHomeVisitCare(toInt(systemServiceKindDetail));
    }

    /**
     * 訪問入浴介護であるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 訪問入浴介護であるか
     */
    public static boolean isHomeVisitBathing(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 11211:// 訪問入浴介護
        case 16211: // 介護予防訪問入浴介護
            return true;
        }
        return false;
    }

    /**
     * 訪問入浴介護であるかを返します。
     * 
     * @param service サービス
     * @return 訪問入浴介護であるか
     */
    public static boolean isHomeVisitBathing(Map service) {
        return isHomeVisitBathing(toInt(service));
    }

    /**
     * 訪問入浴介護であるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 訪問入浴介護であるか
     */
    public static boolean isHomeVisitBathing(String systemServiceKindDetail) {
        return isHomeVisitBathing(toInt(systemServiceKindDetail));
    }

    /**
     * 訪問看護(介護保険)であるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 訪問看護(介護保険)であるか
     */
    public static boolean isHomeVisitNursing(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 11311:// 訪問看護(介護保険)
        case 16311: // 介護予防訪問看護
            return true;
        }
        return false;
    }

    /**
     * 訪問看護(介護保険)であるかを返します。
     * 
     * @param service サービス
     * @return 訪問看護(介護保険)であるか
     */
    public static boolean isHomeVisitNursing(Map service) {
        return isHomeVisitNursing(toInt(service));
    }

    /**
     * 訪問看護(介護保険)であるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 訪問看護(介護保険)であるか
     */
    public static boolean isHomeVisitNursing(String systemServiceKindDetail) {
        return isHomeVisitNursing(toInt(systemServiceKindDetail));
    }

    /**
     * 訪問リハビリテーションであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 訪問リハビリテーションであるか
     */
    public static boolean isHomeVisitRehabilitation(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 11411:// 訪問リハビリテーション
        case 16411: // 介護予防訪問リハ
            return true;
        }
        return false;
    }

    /**
     * 訪問リハビリテーションであるかを返します。
     * 
     * @param service サービス
     * @return 訪問リハビリテーションであるか
     */
    public static boolean isHomeVisitRehabilitation(Map service) {
        return isHomeVisitRehabilitation(toInt(service));
    }

    /**
     * 訪問リハビリテーションであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 訪問リハビリテーションであるか
     */
    public static boolean isHomeVisitRehabilitation(
            String systemServiceKindDetail) {
        return isHomeVisitRehabilitation(toInt(systemServiceKindDetail));
    }

    /**
     * 通所介護であるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 通所介護であるか
     */
    public static boolean isFacilityVisitCare(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 11511: // 通所介護
        case 17211: // 認知症対応型通所介護
        case 16511: // 介護予防通所介護
        case 17411: // 介護予防認知症対応型通所介護
        case 17811: // 地域密着型通所介護 H28.4
            return true;
        }
        return false;
    }

    /**
     * 通所介護であるかを返します。
     * 
     * @param service サービス
     * @return 通所介護であるか
     */
    public static boolean isFacilityVisitCare(Map service) {
        return isFacilityVisitCare(toInt(service));
    }

    /**
     * 通所介護であるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 通所介護であるか
     */
    public static boolean isFacilityVisitCare(String systemServiceKindDetail) {
        return isFacilityVisitCare(toInt(systemServiceKindDetail));
    }

    /**
     * 通所リハビリテーションであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 通所リハビリテーションであるか
     */
    public static boolean isFacilityVisitRehabilitation(
            int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 11611:// 通所リハビリテーション
        case 16611: // 介護予防通所リハ
            return true;
        }
        return false;
    }

    /**
     * 通所リハビリテーションであるかを返します。
     * 
     * @param service サービス
     * @return 通所リハビリテーションであるか
     */
    public static boolean isFacilityVisitRehabilitation(Map service) {
        return isFacilityVisitRehabilitation(toInt(service));
    }

    /**
     * 通所リハビリテーションであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 通所リハビリテーションであるか
     */
    public static boolean isFacilityVisitRehabilitation(
            String systemServiceKindDetail) {
        return isFacilityVisitRehabilitation(toInt(systemServiceKindDetail));
    }

    /**
     * 施設系サービスであるかを返します。
     * 
     * @param service サービス
     * @return 施設系サービスであるか
     */
    public static boolean isFacility(Map service) {
        return isFacility(toInt(service));
    }

    /**
     * 施設系サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 施設系サービスであるか
     */
    public static boolean isFacility(String systemServiceKindDetail) {
        return isFacility(toInt(systemServiceKindDetail));
    }

    /**
     * 居宅系サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 居宅系サービスであるか
     */
    public static boolean isHome(int systemServiceKindDetail) {
        return isHomeVisit(systemServiceKindDetail)
                || isFacilityVisit(systemServiceKindDetail)
                || isWelfareEquipment(systemServiceKindDetail)
                || isShortStay(systemServiceKindDetail)
                || isLifeCare(systemServiceKindDetail)
                || isCareManagement(systemServiceKindDetail);
    }

    /**
     * 居宅系サービスであるかを返します。
     * 
     * @param service サービス
     * @return 居宅系サービスであるか
     */
    public static boolean isHome(Map service) {
        return isHome(toInt(service));
    }

    /**
     * 居宅系サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 居宅系サービスであるか
     */
    public static boolean isHome(String systemServiceKindDetail) {
        return isHome(toInt(systemServiceKindDetail));
    }

    /**
     * 短期入所系サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 短期入所系サービスであるか
     */
    public static boolean isShortStay(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 12111:// 短期入所生活介護
        case 12211:// 短期入所療養介護(老健)
        case 12311:// 短期入所療養介護(療養病床を有する病院)
        case 12312:// 短期入所療養介護(療養病床を有する診療所)
        case 12313:// 短期入所療養介護(老人性認知症疾患療養病棟を有する病院)
        case 13811:// 認知症対応型共同生活介護(短期利用)
        case 12411: // 介護予防短期入所生活介護
        case 12511: // 介護予防短期入所療養介護（老健）
        case 12611: // 介護予防短期入所療養介護（病院）
        case 12612: // 介護予防短期入所療養介護（診療所）
        case 12613: // 介護予防短期入所療養介護（認知症疾患型）
        case 13911: // 介護予防認知症対応型共同生活介護（短期利用）

        case 12711: // 特定施設入居者生活介護（短期利用）
        case 12811: // 地域密着型特定施設入居者生活介護（短期利用）
            return true;
        }
        return false;
    }

    /**
     * 短期入所系サービスであるかを返します。
     * 
     * @param service サービス
     * @return 短期入所系サービスであるか
     */
    public static boolean isShortStay(Map service) {
        return isShortStay(toInt(service));
    }

    /**
     * 短期入所系サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 短期入所系サービスであるか
     */
    public static boolean isShortStay(String systemServiceKindDetail) {
        return isShortStay(toInt(systemServiceKindDetail));
    }

    /**
     * 訪問系サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 訪問系サービスであるか
     */
    public static boolean isHomeVisit(int systemServiceKindDetail) {
        return isHomeVisitCare(systemServiceKindDetail)
                || isHomeVisitBathing(systemServiceKindDetail)
                || isHomeVisitNursing(systemServiceKindDetail)
                || isHomeVisitRehabilitation(systemServiceKindDetail);
    }

    /**
     * 訪問系サービスであるかを返します。
     * 
     * @param service サービス
     * @return 訪問系サービスであるか
     */
    public static boolean isHomeVisit(Map service) {
        return isHomeVisit(toInt(service));
    }

    /**
     * 訪問系サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 訪問系サービスであるか
     */
    public static boolean isHomeVisit(String systemServiceKindDetail) {
        return isHomeVisit(toInt(systemServiceKindDetail));
    }

    /**
     * 福祉用具貸与サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 福祉用具貸与サービスであるか
     */
    public static boolean isWelfareEquipment(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 11711:// 福祉用具貸与
        case 16711: // 介護予防福祉用具貸与
            return true;
        }
        return false;
    }

    /**
     * 福祉用具貸与サービスであるかを返します。
     * 
     * @param service サービス
     * @return 福祉用具貸与サービスであるか
     */
    public static boolean isWelfareEquipment(Map service) {
        return isWelfareEquipment(toInt(service));
    }

    /**
     * 福祉用具貸与サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 福祉用具貸与サービスであるか
     */
    public static boolean isWelfareEquipment(String systemServiceKindDetail) {
        return isWelfareEquipment(toInt(systemServiceKindDetail));
    }

    /**
     * 小規模多機能型居宅介護サービスであるかを返します。
     * ※居宅介護支援を行うサービス判定で利用するため、短期利用（68,69,79は含めない）
     * @param systemServiceKindDetail サービス種類
     * @return 小規模多機能型居宅介護サービスであるか
     */
    public static boolean isFacilityVisitMultifunction(
            int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 17311:// 小規模多機能型居宅介護
        case 17511: // 介護予防小規模多機能型居宅介護
        case 17711: // 複合型サービスI
            return true;
        }
        return false;
    }

    /**
     * 小規模多機能型居宅介護サービスであるかを返します。
     * 
     * @param service サービス
     * @return 小規模多機能型居宅介護サービスであるか
     */
    public static boolean isFacilityVisitMultifunction(Map service) {
        return isFacilityVisitMultifunction(toInt(service));
    }

    /**
     * 小規模多機能型居宅介護サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 小規模多機能型居宅介護サービスであるか
     */
    public static boolean isFacilityVisitMultifunction(
            String systemServiceKindDetail) {
        return isFacilityVisitMultifunction(toInt(systemServiceKindDetail));
    }

    /**
     * 居宅介護支援サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 居宅介護支援サービスであるか
     */
    public static boolean isCareManagement(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 14311:// 居宅介護支援
        case 14611: // 介護予防支援
            return true;
        }
        return false;
    }

    /**
     * 居宅介護支援サービスであるかを返します。
     * 
     * @param service サービス
     * @return 居宅介護支援サービスであるか
     */
    public static boolean isCareManagement(Map service) {
        return isCareManagement(toInt(service));
    }

    /**
     * 居宅介護支援サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 居宅介護支援サービスであるか
     */
    public static boolean isCareManagement(String systemServiceKindDetail) {
        return isCareManagement(toInt(systemServiceKindDetail));
    }

    /**
     * 主な日常生活上の活動サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 主な日常生活上の活動サービスであるか
     */
    public static boolean isDailyAction(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 90201:// 主な日常生活上の活動
        case 90211:// 主な日常生活上の活動
            return true;
        }
        return false;
    }

    /**
     * 主な日常生活上の活動サービスであるかを返します。
     * 
     * @param service サービス
     * @return 主な日常生活上の活動サービスであるか
     */
    public static boolean isDailyAction(Map service) {
        return isDailyAction(toInt(service));
    }

    /**
     * 主な日常生活上の活動サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 主な日常生活上の活動サービスであるか
     */
    public static boolean isDailyAction(String systemServiceKindDetail) {
        return isDailyAction(toInt(systemServiceKindDetail));
    }

    /**
     * その他のサービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return その他のサービスであるか
     */
    public static boolean isOtherService(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 90101:// その他
        case 90111:// その他
            return true;
        }
        return false;
    }

    /**
     * その他のサービスであるかを返します。
     * 
     * @param service サービス
     * @return その他のサービスであるか
     */
    public static boolean isOtherService(Map service) {
        return isOtherService(toInt(service));
    }

    /**
     * その他のサービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return その他のサービスであるか
     */
    public static boolean isOtherService(String systemServiceKindDetail) {
        return isOtherService(toInt(systemServiceKindDetail));
    }

    /**
     * 週間表にのみ使用可能なサービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 週間表にのみ使用可能なサービスであるか
     */
    public static boolean isOnlyWeekly(int systemServiceKindDetail) {
        return isDailyAction(systemServiceKindDetail)
                || isOtherService(systemServiceKindDetail);
    }

    /**
     * 週間表にのみ使用可能なサービスであるかを返します。
     * 
     * @param service サービス
     * @return 週間表にのみ使用可能なサービスであるか
     */
    public static boolean isOnlyWeekly(Map service) {
        return isOnlyWeekly(toInt(service));
    }

    /**
     * 週間表にのみ使用可能なサービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 週間表にのみ使用可能なサービスであるか
     */
    public static boolean isOnlyWeekly(String systemServiceKindDetail) {
        return isOnlyWeekly(toInt(systemServiceKindDetail));
    }

    /**
     * サービス種類を返します。
     * 
     * @param service サービス
     * @return サービス種類
     */
    protected static int toInt(Map service) {
        if (service == null) {
            return -1;
        }
        return ACCastUtilities.toInt(service.get("SYSTEM_SERVICE_KIND_DETAIL"),
                -1);
    }

    /**
     * 文字列表現のサービス種類をintに変換して返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return サービス種類
     */
    protected static int toInt(String systemServiceKindDetail) {
        return ACCastUtilities.toInt(systemServiceKindDetail, -1);
    }

    /**
     * コンストラクタです。
     */
    protected CareServiceCommon() {
    }

    /**
     * 30日超のサービスであるかを返します。
     * 
     * @param service サービス
     * @return 30日超のサービスであるか
     */
    public static boolean is30DayOver(VRMap service) {
        try {
            return "2".equals(ACCastUtilities.toString(
                    VRBindPathParser.get("5", service), ""));
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * 居宅療養管理指導サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 居宅療養管理指導サービスであるか
     */
    public static boolean isHomeMedicalAdvice(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 13111:// 居宅療養管理指導
        case 13411: // 介護予防居宅療養管理指導
            return true;
        }
        return false;
    }

    /**
     * 居宅療養管理指導サービスであるかを返します。
     * 
     * @param service サービス
     * @return 居宅療養管理指導サービスであるか
     */
    public static boolean isHomeMedicalAdvice(Map service) {
        return isHomeMedicalAdvice(toInt(service));
    }

    /**
     * 居宅療養管理指導サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 居宅療養管理指導サービスであるか
     */
    public static boolean isHomeMedicalAdvice(String systemServiceKindDetail) {
        return isHomeMedicalAdvice(toInt(systemServiceKindDetail));
    }

    /**
     * 外泊の実績であるかを返します。
     * 
     * @param service サービス実績
     * @return 外泊の実績であるか 0:対象外 1:外泊無し 2:外泊
     */
    public static int isGaihaku(VRMap service) {
        int result = 0;
        /*
         * try { // 試行的退所サービス費を参照 if (service.containsKey("1520129")) { result =
         * ACCastUtilities.toInt(service.get("1520129"), 0); } else if
         * (service.containsKey("1530119")) { // 2006/07/11 療養型対応 // 試行的退院サービス費
         * result = ACCastUtilities.toInt(service.get("1530119"), 0); //
         * 外泊のフラグを参照 } else if (service.containsKey("1510111")) { result =
         * ACCastUtilities.toInt(service.get("1510111"), 0); } else if
         * (service.containsKey("1520107")) { result =
         * ACCastUtilities.toInt(service.get("1520107"), 0); } else if
         * (service.containsKey("1530108")) { result =
         * ACCastUtilities.toInt(service.get("1530108"), 0); } else if
         * (service.containsKey("1530206")) { result =
         * ACCastUtilities.toInt(service.get("1530206"), 0); } else if
         * (service.containsKey("1530305")) { result =
         * ACCastUtilities.toInt(service.get("1530305"), 0); } else if
         * (service.containsKey("1540112")) { result =
         * ACCastUtilities.toInt(service.get("1540112"), 0); // 他科受診のフラグを参照 }
         * else if (service.containsKey("1530110")) { if
         * (ACCastUtilities.toInt(service.get("1530110"), 0) == 2) { result = 1;
         * } } else if (service.containsKey("1530208")) { if
         * (ACCastUtilities.toInt(service.get("1530208"), 0) == 2) { result = 1;
         * } } else if (service.containsKey("1530307")) { if
         * (ACCastUtilities.toInt(service.get("1530307"), 0) == 2) { result = 1;
         * } } else { // ショートステイ対象なら外泊無しと判定 if (isShortStay(service)) { result =
         * 1; } else { // 様式第六の例外ケースに対応 switch (ACCastUtilities.toInt(
         * service.get("SYSTEM_SERVICE_KIND_DETAIL"), 0)) { //
         * 認知症対応型共同生活介護(短期利用以外) case 13211: // 特定施設入居者生活介護 case 13311: //
         * 地域密着型特定施設入居者生活介護 case 13611: // 認知症対応型共同生活介護(短期利用) case 13811:
         * 
         * // 介護予防対応開始 // 介護予防認知症対応型共同生活介護（短期利用以外） case 13711: //
         * 介護予防特定施設入居者生活介護 case 13511: // 介護予防認知症対応型共同生活介護（短期利用） case 13911: //
         * 介護予防対応終了 result = 1; break; }
         * 
         * } } } catch (Exception e) { }
         */

        try {
            // 試行的退所サービス費を参照
            if (service.containsKey("1520129")) {
                result = ACCastUtilities.toInt(service.get("1520129"), 0);
            } else if (service.containsKey("1530119")) {
                // 2006/07/11 療養型対応 // 試行的退院サービス費
                result = ACCastUtilities.toInt(service.get("1530119"), 0);
                // 外泊のフラグを参照
            } else if (service.containsKey("1510111")) {
                result = ACCastUtilities.toInt(service.get("1510111"), 0);
            } else if (service.containsKey("1520107")) {
                result = ACCastUtilities.toInt(service.get("1520107"), 0);
            } else if (service.containsKey("1530108")) {
                result = ACCastUtilities.toInt(service.get("1530108"), 0);
            } else if (service.containsKey("1530206")) {
                result = ACCastUtilities.toInt(service.get("1530206"), 0);
            } else if (service.containsKey("1530305")) {
                result = ACCastUtilities.toInt(service.get("1530305"), 0);
            } else if (service.containsKey("1540112")) {
                result = ACCastUtilities.toInt(service.get("1540112"), 0);
                // 他科受診のフラグを参照
            } else if (service.containsKey("1530110")) {
                if (ACCastUtilities.toInt(service.get("1530110"), 0) == 2) {
                    result = 1;
                }
            } else if (service.containsKey("1530208")) {
                if (ACCastUtilities.toInt(service.get("1530208"), 0) == 2) {
                    result = 1;
                }
            } else if (service.containsKey("1530307")) {
                if (ACCastUtilities.toInt(service.get("1530307"), 0) == 2) {
                    result = 1;
                }
            } else {
                // ショートステイ対象なら外泊無しと判定
                if (isShortStay(service)) {
                    result = 1;
                } else {
                    // 様式第六の例外ケースに対応
                    switch (ACCastUtilities.toInt(
                            service.get("SYSTEM_SERVICE_KIND_DETAIL"), 0)) {
                    // 認知症対応型共同生活介護(短期利用以外)
                    case 13211:
                        // 特定施設入居者生活介護
                    case 13311:
                        // 地域密着型特定施設入居者生活介護
                    case 13611:
                        // 認知症対応型共同生活介護(短期利用)
                    case 13811:
                        // 介護予防対応開始
                        // 介護予防認知症対応型共同生活介護（短期利用以外）
                    case 13711:
                        // 介護予防特定施設入居者生活介護
                    case 13511:
                        // 介護予防認知症対応型共同生活介護（短期利用）
                    case 13911:
                        // 介護予防対応終了
                        result = 1;
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }

        // if (ACCastUtilities.toInt(service.get("SERVICE_ADD_TYPE"), 0) == 1) {
        // result = 1;
        // }

        return result;
    }

    /**
     * 別表に回数を印字してよいサービスコードであるかを返します。
     * 
     * @param service サービスコード
     * @return 別表に回数を印字してよいサービスコードであるか
     */
    public static boolean isCountPrintableServiceCode(Map service) {
        try {
            if ("2".equals(ACCastUtilities.toString(
                    service.get("LIMIT_AMOUNT_OBJECT"), ""))) {
                // 給付管理対象外
                String addFlag = ACCastUtilities.toString(
                        service.get("SERVICE_ADD_FLAG"), "");
                String totalType = ACCastUtilities.toString(
                        service.get("TOTAL_GROUPING_TYPE"), "");
                if ("2".equals(addFlag) && "3".equals(totalType)) {
                    // 単独単位加算かつ月単位算定ならば回数を印字しない
                    return false;
                }
                if ("3".equals(addFlag)) {
                    // 単独%加算ならば回数を印字しない
                    return false;
                }
                if ("6".equals(addFlag)) {
                    // %加算(対象に地域系加算を含む)ならば回数を印字しない
                    return false;
                }
                // [ID:0000682] 2012/01 start 介護職員処遇改善加算の追加処理
                if ("8".equals(addFlag)) {
                    // %加算(介護職員処遇改善)
                    return false;
                }
                // [ID:0000682] 2012/01 end
                // 予防特地加算対応のため
                if (isAddSpecialArea(service)) {
                    // 特地加算ならば回数を印字しない
                    return false;
                }
            }
        } catch (Exception ex) {
        }
        return true;
    }

    /**
     * 予防サービスであるかを返します。
     * 
     * @param service サービス
     * @return 予防サービスであるか
     */
    public static boolean isPreventService(Map service) {
        return isPreventService(toInt(service));
    }

    /**
     * 予防サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 予防サービスであるか
     */
    public static boolean isPreventService(String systemServiceKindDetail) {
        return isPreventService(toInt(systemServiceKindDetail));
    }

    /**
     * 予防サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 予防サービスであるか
     */
    public static boolean isPreventService(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 16111: // 介護予防訪問介護
        case 16211: // 介護予防訪問入浴介護
        case 16311: // 介護予防訪問看護
        case 16411: // 介護予防訪問リハ
        case 16511: // 介護予防通所介護
        case 16611: // 介護予防通所リハ
        case 16711: // 介護予防福祉用具貸与
        case 12411: // 介護予防短期入所生活介護
        case 12511: // 介護予防短期入所療養介護（老健）
        case 12611: // 介護予防短期入所療養介護（病院）
        case 12612: // 介護予防短期入所療養介護（診療所）
        case 12613: // 介護予防短期入所療養介護（認知症疾患型）
        case 13411: // 介護予防居宅療養管理指導
        case 13511: // 介護予防特定施設入居者生活介護
        case 14611: // 介護予防支援
        case 17411: // 介護予防認知症対応型通所介護
        case 17511: // 介護予防小規模多機能型居宅介護
        case 16911: // 介護予防小規模多機能型居宅介護（短期利用）[H27.4改正対応]
        case 13711: // 介護予防認知症対応型共同生活介護（短期利用以外）
        case 13911: // 介護予防認知症対応型共同生活介護（短期利用）
            return true;
        }
        return false;
    }

    /**
     * 予防訪問介護の日割でない合成単位を意味するサービスコードであるかを返します。
     * 
     * @param code サービスコード
     * @return 予防訪問介護の日割でない合成単位を意味するサービスコードであるか
     */
    public static boolean isAddPreventHomeVisitNotDailyBasicCode(Map code) {
    	// [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - begin サービスコード英数化と未対応コード判定追加
//        switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_KIND"), 0)) {
//        case 61:// 予防訪問介護
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 1111:// 予防訪問介護Ⅰ
//            case 1112:// 予防訪問介護Ⅰ・３級
//            case 1211:// 予防訪問介護Ⅱ
//            case 1212:// 予防訪問介護Ⅱ・３級
//            case 1321:// 予防訪問介護Ⅲ
//            case 1322:// 予防訪問介護Ⅲ・３級
//                return true;
//            }
//        }
        String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "");
        String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"), "");
        if ("61".equals(serviceCodeKind)) {	// 予防訪問介護
        	if ("1111".equals(serviceCodeItem)		//予防訪問介護１
				|| "1113".equals(serviceCodeItem)	//予防訪問介護１・初任
				|| "1114".equals(serviceCodeItem)	//予防訪問介護１・同一
				|| "1115".equals(serviceCodeItem)	//予防訪問介護１・初任・同一
				|| "1211".equals(serviceCodeItem)	//予防訪問介護２
				|| "1213".equals(serviceCodeItem)	//予防訪問介護２・初任
				|| "1214".equals(serviceCodeItem)	//予防訪問介護２・同一
				|| "1215".equals(serviceCodeItem)	//予防訪問介護２・初任・同一
				|| "1321".equals(serviceCodeItem)	//予防訪問介護３
				|| "1323".equals(serviceCodeItem)	//予防訪問介護３・初任
				|| "1324".equals(serviceCodeItem)	//予防訪問介護３・同一
				|| "1325".equals(serviceCodeItem)	//予防訪問介護３・初任・同一
        		) {
        		return true;
        	}
        }
        // [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - end
        
        return false;
    }

    /**
     * 計画単位数サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 計画単位数サービスであるか
     */
    public static boolean isPlanUnitService(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 1:// 計画単位数サービス
            return true;
        }
        return false;
    }

    /**
     * 計画単位数サービスであるかを返します。
     * 
     * @param service サービス
     * @return 計画単位数サービスであるか
     */
    public static boolean isPlanUnitService(Map service) {
        return isPlanUnitService(toInt(service));
    }

    /**
     * 計画単位数サービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 計画単位数サービスであるか
     */
    public static boolean isPlanUnitService(String systemServiceKindDetail) {
        return isPlanUnitService(toInt(systemServiceKindDetail));
    }

    /**
     * 計画単位数のバインドパス配列を返します。
     * [H27.4改正対応][Shinobu Hitaka] 2015/03/06 68,69,79のサービス種類追加
     * [H28.4改正対応][Shinobu Hitaka] 2016/01/29 78のサービス種類追加
     * @return 計画単位数のバインドパス配列
     */
    public static String[] getPlanUnitBindPathes() {
        return new String[] { 
        		"1011", "1012", "1013", "1014", "1015",
        		"1016", "1017", "1021", "1022", "1023",
        		"1071", "1027", "1072", "1073", "1068",
        		"1038", "1028", "1076", "1077", "1079",
        		"1078",
                "1061", "1062", "1063", "1064", "1065",
                "1066", "1067", "1024", "1025", "1026",
                "1039", "1074", "1075", "1069", };
    };

    /**
     * 利用票に印字するサービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 利用票に印字するサービスであるか
     */
    public static boolean isServiceUseTablePrintable(int systemServiceKindDetail) {
        // 施設系/準施設系サービス/居宅療養管理指導は別表に印字しない。
        if (CareServiceCommon.isFacility(systemServiceKindDetail)
                || CareServiceCommon.isLifeCare(systemServiceKindDetail)
                || CareServiceCommon
                        .isHomeMedicalAdvice(systemServiceKindDetail)) {
            return false;
        }
        return true;
    }

    /**
     * 利用票に印字するサービスであるかを返します。
     * 
     * @param service サービス
     * @return 利用票に印字するサービスであるか
     */
    public static boolean isServiceUseTablePrintable(Map service) {
        return isServiceUseTablePrintable(toInt(service));
    }

    /**
     * 利用票に印字するサービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 利用票に印字するサービスであるか
     */
    public static boolean isServiceUseTablePrintable(
            String systemServiceKindDetail) {
        return isServiceUseTablePrintable(toInt(systemServiceKindDetail));
    }

    /**
     * 利用票本表に印字するサービスコードであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 利用票に印字するサービスであるか
     */
    public static boolean isServiceUseTableMainFormatPrintableCode(Map code) {
        if (isOutLimitAmount(code) || isAddEmergencyNursing(code)
                || isAddSpecialManagement(code) || isAddSpecialArea(code)
                || isAddTerminalCare(code)
                || isAddEmergencyMedicalManagement(code)
                || isAddPercentageForSyogu(code)) {
            // 緊急時訪問看護加算、特別管理加算、特別地域加算、ターミナルケア加算、緊急時治療管理、介護職員処遇改善加算は本表に印字しない
            return false;
        }

        return true;
    }

    /**
     * 療養病床有する診療所におけるサービスであるかを返します。
     * 
     * @param systemServiceKindDetail サービス種類
     * @return 療養病床有する診療所におけるサービスであるか
     * 
     */
    public static boolean isPracticeToHealthFacilityServices(Map service) {
        // 療養病床有する診療所におけるサービスであるか。
        switch (toInt(service)) {
        case 12312: // 短期入所療養介護（診療所）
        case 15312: // 介護療養型医療施設（診療所）
        case 12612: // 介護予防短期入所療養介護（診療所）
            return true;
        }

        return false;
    }

    /**
     * 療養病床を有する老健施設におけるサービスであるかを返します。
     * 
     * @param service サービス種類
     * @return
     * 
     */
    public static boolean isElderlyToHealthFacilityServices(Map service) {
        // 老人保健施設を有する短期入所療養介護
        switch (toInt(service)) {
        // 短期入所療養介護(老健）
        case 12211:
            // 介護老人保健施設
        case 15211:
            // 介護予防短期入所療養介護（老健）
        case 12511:
            return true;
        }

        return false;

    }

    /**
     * 中山間等地域における小規模事業所加算であるかを返します。
     * 
     * @param provider 事業所情報
     * @return
     * 
     */
    public static boolean isMountainousArea(Map provider) {
        // 中山間等地域における小規模事業所加算（地域）・（規模）が該当の場合
        if (provider != null) {
            if ((ACCastUtilities.toInt(provider.get("2"), 0) == 2)
                    && (ACCastUtilities.toInt(provider.get("3"), 0) == 2)) {
                return true;
            }
        }

        return false;
    }

    /**
     * サービスの法改正区分(M_DETAIL.SYSTEM_BIND_PATH=14)を返します。
     * 
     * @param service サービス
     * @return サービスの法改正区分
     */
    public static int getServiceLowVersion(VRMap service) {
        try {
            return ACCastUtilities.toInt(VRBindPathParser
                    .get(QkanConstants.SERVICE_SYSTEM_BIND_PATH_LOW_VERSION,
                            service), 0);
        } catch (ParseException e) {
            return 0;
        }
    }

    /**
     * 介護職員処遇改善の事業所設定値を返却します。
     * 
     * @param provider
     * @return // [ID:0000682] 2012/01 start 介護職員処遇改善加算の追加処理
     */
    public static int getProviderSyogukaizenValue(Map provider) {
        // 介護職員処遇改善加算
        if (provider != null) {
            return ACCastUtilities.toInt(provider.get("4"), 1);

        }

        return 1;
    }

    /**
     * 処遇改善加算の単位数を計算し、返却します。
     * 
     * @param totalUnit 処遇改善加算対象の単位数合計
     * @param serviceUnit 加算割合(‰)
     * @param serviceStaffUnit 減算割合(％)
     * @return
     */
    public static int calcSyogu(int totalUnit, int serviceUnit,
            int serviceStaffUnit) {

        // totalUnit * (serviceUnit / 1000) * (serviceStaffUnit / 100)

        // 単位数は四捨五入
        int unit = (int) Math.round((double) (totalUnit * serviceUnit) / 1000d);
        unit = (int) Math.round((double) (unit * serviceStaffUnit) / 100d);

        return unit;
    }

    /**
     * 処遇改善加算の単位数を計算し、返却します。
     * 
     * @param totalUnit 処遇改善加算対象の単位数合計（自己負担調整を含まない）
     * @param totalRegulation 自己負担分単位数
     * @param serviceUnit 加算割合(‰)
     * @param serviceStaffUnit 減算割合(％)
     * @return
     * [ID:0000728][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add
     */
    public static int calcSyoguPatientSelf(int totalUnit, int totalRegulation,
            int serviceUnit, int serviceStaffUnit) {
        // 自己負担調整後単位数を算出
        int adjustUnit = totalUnit - totalRegulation;

        // 全体単位数 - 調整後単位数
        int totalAdjust = CareServiceCommon.calcSyogu(adjustUnit, serviceUnit,
                serviceStaffUnit);
        int totalSyogu = CareServiceCommon.calcSyogu(totalUnit, serviceUnit,
                serviceStaffUnit);

        return totalSyogu - totalAdjust;
    }

    /**
     * 介護老人保健施設で下記公費かどうか判定する
     * 8801:水俣病総合対策、8802:メチル水銀、8701:有機ヒ素、6601:石綿
     * @param String serviceCodeKind：サービス種類コード(SERVICE_CODE_KIND)
     * @param String kohi：公費タイプ
     * @return 該当する：true／該当しない：false
     * [CCCX:1470][Shinobu Hitaka] 2014/02/07 add 老健の一部公費対象の対応
     */
    public static boolean isKouhiService(String serviceCodeKind, String kohi) {
        boolean bFlg = false;
        
        //介護老人保健施設
        if (serviceCodeKind.indexOf("52") != -1) {
            //公費が8801:水俣病総合対策、8802:メチル水銀、8701:有機ヒ素、6601:石綿　の場合
            if ("8801".equals(kohi) || "8802".equals(kohi) || "8701".equals(kohi) || "6601".equals(kohi)) {
                //一部公費適用のため、次の公費計算が必要
                bFlg = true;
            }
        }
        return  bFlg;
    }
    
    /**
     * 介護老人保健施設で下記公費かどうか判定する
     * 8801:水俣病総合対策、8802:メチル水銀、8701:有機ヒ素、6601:石綿
     * @param String systemServiceKindDetail：システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)
     * @param String kohi：公費タイプ
     * @return 該当する：true／該当しない：false
     * [CCCX:1470][Shinobu Hitaka] 2014/02/10 add 老健の一部公費対象の対応
     */
    public static boolean isKouhiSystemService(String systemServiceKindDetail, String kohi) {
        boolean bFlg = false;
        
        //介護老人保健施設
        if (systemServiceKindDetail.indexOf("15211") != -1) {
            //公費が8801:水俣病総合対策、8802:メチル水銀、8701:有機ヒ素、6601:石綿　の場合
            if ("8801".equals(kohi) || "8802".equals(kohi) || "8701".equals(kohi) || "6601".equals(kohi)) {
                //一部公費適用のため、次の公費計算が必要
                bFlg = true;
            }
        }
        return  bFlg;
    }
}
