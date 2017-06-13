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
 *****************************************************************
 * アプリ: QKANCHO
 * 開発者: 利用者一覧
 * 作成日: 2005/12/06  日本コンピューター株式会社 利用者一覧 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (P)
 * プロセス 利用者一覧 (001)
 * プログラム 利用者一覧 (QP001)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Stack;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;

/**
 * 利用者一覧SQL定義(QP001)
 * 
 * @author shin fujihara
 */
public class QP001SQL extends QP001State {
    
    private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
    
    /**
     * コンストラクタです。
     */
    public QP001SQL() {
    }

    /**
     * 「利用者一覧を取得する」のためのSQLを返します。
     * 
     * @param sqlParam
     *            SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception
     *             処理例外
     * @return SQL文
     */
    public String getSQL_GET_PATIENT(VRMap sqlParam) throws Exception {

        StringBuilder sb = new StringBuilder();

        String startCompDate = "";
        String endCompDate = "";
        String targetDate = "";
        String affair = ACCastUtilities.toString(VRBindPathParser.get("AFFAIR",
                sqlParam));
        Date seikyuDate = null;

        if("01".equals(affair)){
            if (VRBindPathParser.has("TARGET_DATE_VALUE", sqlParam)) {
                targetDate = String.valueOf(VRBindPathParser.get(
                        "TARGET_DATE_VALUE", sqlParam));
                Date targetDateEnd = ACDateUtilities
                        .toLastDayOfMonth(ACCastUtilities.toDate(targetDate));
                startCompDate = "'" + VRDateParser.format(targetDateEnd, "yyyy/MM/dd") + "'";
                endCompDate = "'" + targetDate.substring(0, 4) + "/"
                        + targetDate.substring(4, 6) + "/01'";
                
                targetDate = targetDate.substring(0, 4) + "/"
                        + targetDate.substring(4, 6) + "/"
                        + targetDate.substring(6);
            }
        } else {
            startCompDate = "CLAIM.TARGET_DATE";
            endCompDate = "CLAIM.TARGET_DATE";
        }


        if (VRBindPathParser.has("SEIKYU_DATE", sqlParam)) {
            seikyuDate = ACCastUtilities.toDate(VRBindPathParser.get(
                    "SEIKYU_DATE", sqlParam));
        }

        sb.append("SELECT");
        sb.append(" DISTINCT");

        sb.append(" PATIENT.PATIENT_ID");
        sb.append(",PATIENT.PATIENT_CODE");
        sb.append(",PATIENT.PATIENT_FAMILY_NAME");
        sb.append(",PATIENT.PATIENT_FIRST_NAME");
        sb.append(",PATIENT.PATIENT_FAMILY_KANA");
        sb.append(",PATIENT.PATIENT_FIRST_KANA");
        sb.append(",PATIENT.PATIENT_SEX");
        sb.append(",PATIENT.PATIENT_BIRTHDAY");
        sb.append(",PATIENT.PATIENT_TEL_FIRST");
        sb.append(",PATIENT.PATIENT_TEL_SECOND");
        sb.append(",PATIENT.PATIENT_TEL_THIRD");
        sb.append(",PATIENT.PATIENT_ZIP_FIRST");
        sb.append(",PATIENT.PATIENT_ZIP_SECOND");
        sb.append(",PATIENT.PATIENT_ADDRESS");
        sb.append(",PATIENT.SHOW_FLAG");
        sb.append(",PATIENT.LAST_TIME");
        sb.append(",CAST('FALSE' AS CHAR(5)) AS CHOISE");

        if("01".equals(affair)){
            // 保険者ID取得(サブクエリ)
            sb.append(",(");
            sb.append(" SELECT FIRST 1 PATIENT_NINTEI_HISTORY.INSURER_ID FROM PATIENT_NINTEI_HISTORY");
            sb.append(" WHERE");
            sb.append(" (PATIENT.PATIENT_ID = PATIENT_NINTEI_HISTORY.PATIENT_ID)");
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//            sb.append(" AND (PATIENT_NINTEI_HISTORY.INSURE_VALID_START <= "
//                    + startCompDate + ")");
//            sb.append(" AND (PATIENT_NINTEI_HISTORY.INSURE_VALID_END >= "
//                    + endCompDate + ")");
            sb.append(" AND (PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START <= "
                    + startCompDate + ")");
            sb.append(" AND (PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_END >= "
                    + endCompDate + ")");
// 2014/12/17 [Yoichiro Kamei] mod - end
            sb.append(" AND (PATIENT_NINTEI_HISTORY.CHANGE_CODE = 0)");
            sb.append(" ORDER BY PATIENT_NINTEI_HISTORY.JOTAI_CODE DESC");
            sb.append(") AS INSURER_ID");

            // 保険者名称取得(サブクエリ)
            /* 保険者名称は検索結果取得後にマッチングするよう変更
            sb.append(",(");
            sb.append(" SELECT FIRST 1 INSURER.INSURER_NAME FROM INSURER,PATIENT_NINTEI_HISTORY");
            sb.append(" WHERE");
            sb.append(" (PATIENT.PATIENT_ID = PATIENT_NINTEI_HISTORY.PATIENT_ID)");
            sb.append(" AND (PATIENT_NINTEI_HISTORY.INSURER_ID = INSURER.INSURER_ID)");
            sb.append(" AND (PATIENT_NINTEI_HISTORY.INSURE_VALID_START <= "
                    + startCompDate + ")");
            sb.append(" AND (PATIENT_NINTEI_HISTORY.INSURE_VALID_END >= "
                    + endCompDate + ")");
            sb.append(" AND (PATIENT_NINTEI_HISTORY.CHANGE_CODE = 0)");
            sb.append(" ORDER BY PATIENT_NINTEI_HISTORY.JOTAI_CODE DESC");
            sb.append(" ) AS INSURER_NAME");
            */
        } else {
            //実集計後はCLAIMテーブルから取得
            sb.append(" ,CLAIM.INSURER_ID");
            /* 保険者名称は検索結果取得後にマッチングするよう変更
            sb.append(",(");
            //保険者名称取得(サブクエリ)
            sb.append(" SELECT FIRST 1 INSURER.INSURER_NAME FROM INSURER");
            sb.append(" WHERE");
            sb.append(" (INSURER.INSURER_ID = CLAIM.INSURER_ID)");
            sb.append(" ) AS INSURER_NAME");
            */
        }

        if("01".equals(affair)){
            sb.append(" ,(");
            sb.append(" SELECT FIRST 1 PATIENT_NINTEI_HISTORY.INSURED_ID FROM PATIENT_NINTEI_HISTORY");
            sb.append(" WHERE");
            sb.append(" (PATIENT.PATIENT_ID = PATIENT_NINTEI_HISTORY.PATIENT_ID)");
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//            sb.append(" AND (PATIENT_NINTEI_HISTORY.INSURE_VALID_START <= "
//                    + startCompDate + ")");
//            sb.append(" AND (PATIENT_NINTEI_HISTORY.INSURE_VALID_END >= "
//                    + endCompDate + ")");
            sb.append(" AND (PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START <= "
                    + startCompDate + ")");
            sb.append(" AND (PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_END >= "
                    + endCompDate + ")");
// 2014/12/17 [Yoichiro Kamei] mod - end
            sb.append(" AND (PATIENT_NINTEI_HISTORY.CHANGE_CODE = 0)");
            sb.append(" ORDER BY PATIENT_NINTEI_HISTORY.JOTAI_CODE DESC");
            sb.append(" ) AS INSURED_ID");
            
        //実績確定後はCLAIMテーブルから取得
        } else {
            sb.append(" ,CLAIM.INSURED_ID");
        }
        
        // 要介護度(サブクエリ)
        sb.append(" ,(");
        sb.append(" SELECT FIRST 1 PATIENT_NINTEI_HISTORY.JOTAI_CODE FROM PATIENT_NINTEI_HISTORY");
        sb.append(" WHERE");
        sb.append(" (PATIENT.PATIENT_ID = PATIENT_NINTEI_HISTORY.PATIENT_ID)");
        
        if("01".equals(affair)){
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//            sb.append(" AND (PATIENT_NINTEI_HISTORY.INSURE_VALID_START <= "
//                    + startCompDate + ")");
//            sb.append(" AND (PATIENT_NINTEI_HISTORY.INSURE_VALID_END >= "
//                    + endCompDate + ")");
            sb.append(" AND (PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START <= "
                    + startCompDate + ")");
            sb.append(" AND (PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_END >= "
                    + endCompDate + ")");
// 2014/12/17 [Yoichiro Kamei] mod - end
        } else {
            //がっつり修正
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//            sb.append(" AND(EXTRACT(YEAR FROM PATIENT_NINTEI_HISTORY.INSURE_VALID_START) * 10000 + EXTRACT(MONTH FROM PATIENT_NINTEI_HISTORY.INSURE_VALID_START) * 100 + EXTRACT(DAY FROM PATIENT_NINTEI_HISTORY.INSURE_VALID_START))");
        	sb.append(" AND(EXTRACT(YEAR FROM PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START) * 10000 + EXTRACT(MONTH FROM PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START) * 100 + EXTRACT(DAY FROM PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START))");
// 2014/12/17 [Yoichiro Kamei] mod - end
            sb.append(" <= (EXTRACT(YEAR FROM CLAIM.TARGET_DATE) * 10000 + EXTRACT(MONTH FROM CLAIM.TARGET_DATE) * 100 + 31)");
// 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応           
//            sb.append(" AND(EXTRACT(YEAR FROM PATIENT_NINTEI_HISTORY.INSURE_VALID_END) * 10000 + EXTRACT(MONTH FROM PATIENT_NINTEI_HISTORY.INSURE_VALID_END) * 100 + EXTRACT(DAY FROM PATIENT_NINTEI_HISTORY.INSURE_VALID_END))");
            sb.append(" AND(EXTRACT(YEAR FROM PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_END) * 10000 + EXTRACT(MONTH FROM PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_END) * 100 + EXTRACT(DAY FROM PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_END))");
// 2014/12/17 [Yoichiro Kamei] mod - end
            sb.append(" >= (EXTRACT(YEAR FROM CLAIM.TARGET_DATE) * 10000 + EXTRACT(MONTH FROM CLAIM.TARGET_DATE) * 100 + 1)");
        }        
        
        sb.append(" AND (PATIENT_NINTEI_HISTORY.CHANGE_CODE = 0)");
        sb.append(" ORDER BY PATIENT_NINTEI_HISTORY.JOTAI_CODE DESC");
        sb.append(" ) AS JOTAI_CODE");
        

        if (!"01".equals(affair)) {
            
            sb.append(" ,CLAIM.TARGET_DATE");
            sb.append(" ,CLAIM.CLAIM_DATE");
            //サブクエリに変更
            //sb.append(" ,CLAIM.CLAIM_FINISH_FLAG AS PRINT");
            //利用者一覧と様式第一のときは帳票種類を指定しない。
            if(!"07".equals(affair) && !"08".equals(affair)){
                sb.append(" ,CLAIM.CLAIM_STYLE_TYPE");
            }
        }

        sb.append(" FROM");

        sb.append(" PATIENT");

        //CLAIMテーブルの構造上、一括での取得はムリ
//        sb.append(" LEFT OUTER JOIN CLAIM");
//        sb.append(" ON PATIENT.PATIENT_ID = CLAIM.PATIENT_ID");

        if ("01".equals(affair)) {
            sb.append(",SERVICE");
        } else {
            sb.append(",CLAIM");
        }

        // 表示フラグが1(表示)のもの
        sb.append(" WHERE");
        sb.append(" (PATIENT.SHOW_FLAG = 1)");
        // 削除されていないもの
        sb.append(" AND (PATIENT.DELETE_FLAG = 0)");

        // INSURER_ID(保険者番号)
        if (VRBindPathParser.has("PATIENT_CODE", sqlParam)) {
//            sb.append(" AND (PATIENT.PATIENT_CODE LIKE '"
//                    + VRBindPathParser.get("PATIENT_CODE", sqlParam) + "%')");
            sb.append(" AND (PATIENT.PATIENT_CODE LIKE "
                    + ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_CODE", sqlParam) + "%") + ")");
        }

        //CLAIMテーブルの構造上、一括での取得はムリ
//        // 未出力の利用者だけを表示
//        if (VRBindPathParser.has("OUTPUT_FLG", sqlParam)) {
//            sb.append(" AND (CLAIM_DATE IS NULL)");
//        }

        // 業務毎のオプション
        if (!"01".equals(affair)) {
            //結合条件
            sb.append(" AND (PATIENT.PATIENT_ID = CLAIM.PATIENT_ID)");
            
            // 請求日付
            if (VRBindPathParser.has("SEIKYU_DATE", sqlParam)) {
                sb.append(" AND (CLAIM.CLAIM_DATE = '"
                        + VRDateParser.format(seikyuDate, "yyyy/MM/dd") + "')");
            }
            // 未出力の利用者だけを表示
            // フラグを論理輪保持に変更。ローカルでデータを判断する。
//            if (VRBindPathParser.has("OUTPUT_FLG", sqlParam)) {
//                //sb.append(" AND (CLAIM.CLAIM_FINISH_FLAG = 1)");
//                sb.append(" AND (CLAIM.CLAIM_FINISH_FLAG < " + QkanClaimStateFormat.getPrintedCode(affair) + ")");
//            }
        }

        // 予定・実績のある人のみ表示
        if ("01".equals(affair)) {
            sb.append(" AND (PATIENT.PATIENT_ID = SERVICE.PATIENT_ID)");
            sb.append(" AND (SERVICE.PATIENT_ID IS NOT NULL)");
            sb.append(" AND (SERVICE.SERVICE_USE_TYPE = " + QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY + ")");
            sb.append(" AND (SERVICE.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
            sb.append(" AND (SERVICE.SERVICE_DATE <= ");
            sb.append(startCompDate);
            sb.append(")");
            sb.append(" AND (SERVICE.SERVICE_DATE >= ");
            sb.append(endCompDate);
            sb.append(")");

            // 様式で絞込み
            // 利用者一覧（給付管理票）
        } else if ("02".equals(affair)) {
            sb.append(" AND (CLAIM.CLAIM_STYLE_TYPE IN ("
                    + QkanConstants.CLAIM_STYLE_BENEFIT_MANAGEMENT
                    + "))");
            sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");

            // 利用者一覧（在宅サービス支援事業所請求）
        } else if ("03".equals(affair)) {
            sb.append(" AND (CLAIM.CLAIM_STYLE_TYPE IN ("
                    + QkanConstants.CLAIM_STYLE_FORMAT_7 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_7_2
                    + "))");
            sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");

            // 利用者一覧（在宅サービス提供事業所請求）
        } else if ("04".equals(affair)) {
            sb.append(" AND (CLAIM.CLAIM_STYLE_TYPE IN (");
            
            String seikyuType = "1";
            if (VRBindPathParser.has("SEIKYU_TYPE", sqlParam)) {
                seikyuType = ACCastUtilities.toString(sqlParam.get("SEIKYU_TYPE"));
            }
            if ("1".equals(seikyuType) || "2".equals(seikyuType)) {
                sb.append(
                    + QkanConstants.CLAIM_STYLE_FORMAT_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_2_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_3 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_3_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_4 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_4_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_5 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_5_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_3 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_4 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_5 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_6 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_7 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_8 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_9 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_10
                    );
            }
            if ("1".equals(seikyuType)) {
            	sb.append(",");
            }
            if ("1".equals(seikyuType) || "3".equals(seikyuType)) {
            	sb.append(QkanConstants.CLAIM_STYLE_FORMAT_2_3 );
            }
                    
            sb.append("))");
            sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");

            // 利用者一覧（施設サービス提供事業者請求）※仕様変更に伴い欠番


            // 利用者一覧（医療請求）
        } else if ("06".equals(affair)) {
            sb.append(" AND (CLAIM.CLAIM_STYLE_TYPE IN ("
                        + QkanConstants.CLAIM_STYLE_VISIT_DETAILED_SOCIAL_INSURANCE + ","
                        + QkanConstants.CLAIM_STYLE_VISIT_DETAILE_NATIONAL_INSURANCE + ","
                        + QkanConstants.CLAIM_STYLE_VISIT_BILL_SOCIAL_INSURANCE + ","
                        + QkanConstants.CLAIM_STYLE_VISIT_BILL_NATIONAL_INSURANCE
                        + "))");
            sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");

            // 利用者向け印刷
        } else if ("07".equals(affair)) {
            sb.append(" AND (CLAIM.CLAIM_STYLE_TYPE IN ("
                    + QkanConstants.CLAIM_STYLE_BENEFIT_BILL + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_2_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_2_3 + ","	// 2016.7.8 add
                    + QkanConstants.CLAIM_STYLE_FORMAT_3 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_3_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_4 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_4_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_5 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_5_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_3 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_4 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_5 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_6 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_7 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_7 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_7_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_8 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_9 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_10
                    + "))");
            sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
            
            // 介護給付費明細書印刷
        } else if("08".equals(affair)){
            sb.append(" AND (CLAIM.CLAIM_STYLE_TYPE IN ("
                    + QkanConstants.CLAIM_STYLE_FORMAT_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_2_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_2_3 + ","	// 2016.7.8 add
                    + QkanConstants.CLAIM_STYLE_FORMAT_3 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_3_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_4 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_4_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_5 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_5_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_3 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_4 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_5 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_6 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_6_7 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_7 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_7_2 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_8 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_9 + ","
                    + QkanConstants.CLAIM_STYLE_FORMAT_10
                    + "))");
            sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        }
        
        // 業務毎のオプション
        if (!"01".equals(affair)) {
            sb.append(" ORDER BY");
            sb.append(" CLAIM.TARGET_DATE");
            sb.append(" ,CLAIM.CLAIM_STYLE_TYPE");
            //利用者のカナ氏名順にオーダーを変更
            //sb.append(" ,PATIENT.PATIENT_CODE");
            sb.append(" ,PATIENT.PATIENT_FAMILY_KANA");
            sb.append(" ,PATIENT.PATIENT_FIRST_KANA");
        } else {
            sb.append(" ORDER BY");
            sb.append(" PATIENT.PATIENT_FAMILY_KANA");
            sb.append(" ,PATIENT.PATIENT_FIRST_KANA");
        }

        return sb.toString();
    }

    /**
     * 「計画単位数一覧を取得する」のためのSQLを返します。
     * 
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_PLAN_UNIT(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();
        Date seikyuDate = null;
        
        if (VRBindPathParser.has("SEIKYU_DATE", sqlParam)) {
            seikyuDate = ACCastUtilities.toDate(VRBindPathParser.get(
                    "SEIKYU_DATE", sqlParam));
        } else {
            return sb.toString();
        }
        
        // 2007/01/18 - 年度単位表示への改修
        // Addition - Start Masahiko.Higuchi
        Date fiscalDate = null;
        fiscalDate = ACDateUtilities.addMonth(seikyuDate, -3);
        // Addition - End Masahiko.Higuchi
        
        // 計画単位
        sb.append(" SELECT");
        sb.append(" CLAIM.PATIENT_ID || '-' || CLAIM.INSURED_ID || '-' || CLAIM.CLAIM_STYLE_TYPE || '-' || CLAIM.TARGET_DATE AS CODE,");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM_STYLE_TYPE,");
        //[ID:0000608][Shin Fujihara] 2010/08/18 edit begin Firebird 2.0対応
        //sb.append(" SUM(CLAIM_TEMP.DETAIL_VALUE) AS UNIT");
        sb.append(" SUM(CAST(CLAIM_TEMP.DETAIL_VALUE AS INTEGER)) AS UNIT");
        //[ID:0000608][Shin Fujihara] 2010/08/18 edit end
        sb.append(" FROM");
        sb.append(" CLAIM,");
        //sb.append(" CLAIM_DETAIL_TEXT_" + VRDateParser.format(targetDate, "yyyy") + " CLAIM_TEMP");
        //sb.append(" CLAIM_DETAIL_TEXT_" + VRDateParser.format(seikyuDate, "yyyy") + " CLAIM_TEMP");
        // 2007/01/18 - 年度単位表示への改修
        // Replace - Start Masahiko.Higuchi
        sb.append(" CLAIM_DETAIL_TEXT_" + VRDateParser.format(fiscalDate, "yyyy") + " CLAIM_TEMP");
        // Replace - End Masahiko.Higuchi        
        sb.append(" WHERE");
        sb.append(" (CLAIM.CATEGORY_NO = 7)");
        sb.append(" AND (CLAIM.CLAIM_DATE = '"
                + VRDateParser.format(seikyuDate, "yyyy/MM/dd") + "')");
        
        //[ID:0000619][Shin Fujihara] 2010/08/23 edit begin 事業所の絞込み条件追加
        sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        //[ID:0000619][Shin Fujihara] 2010/08/23 edit end
        
        sb.append(" AND (CLAIM.CLAIM_ID = CLAIM_TEMP.CLAIM_ID)");
        sb.append(" AND (CLAIM_TEMP.SYSTEM_BIND_PATH = '701009')");
        sb.append(" GROUP BY");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM.CLAIM_STYLE_TYPE,");
        sb.append(" CLAIM.TARGET_DATE");

        return sb.toString();
    }

    /**
     * 「サービス単位数を取得する」ためのSQLを返します。
     * TODO
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_SERVICE_UNIT(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();
        Date seikyuDate = null;
        if (VRBindPathParser.has("SEIKYU_DATE", sqlParam)) {
            seikyuDate = ACCastUtilities.toDate(VRBindPathParser.get(
                    "SEIKYU_DATE", sqlParam));
        } else {
            return sb.toString();
        }
        
        // 2007/01/18 - 年度単位表示への改修
        // Addition - Start Masahiko.Higuchi
        Date fiscalDate = null;
        fiscalDate = ACDateUtilities.addMonth(seikyuDate, -3);
        // Addition - End Masahiko.Higuchi
        
        // サービス単位
        sb.append(" SELECT");
        sb.append(" CLAIM.PATIENT_ID || '-' || CLAIM.INSURED_ID || '-' || CLAIM_STYLE_TYPE || '-' || CLAIM.TARGET_DATE AS CODE,");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM_STYLE_TYPE,");
        
        //[ID:0000476][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
        if("03".equals(sqlParam.get("AFFAIR"))){
        	//[ID:0000608][Shin Fujihara] 2010/08/18 edit begin  Firebird 2.0対応
        	//sb.append(" SUM(CLAIM_TEMP.DETAIL_VALUE) AS UNIT");
        	sb.append(" SUM(CAST(CLAIM_TEMP.DETAIL_VALUE AS INTEGER)) AS UNIT");
        	//[ID:0000608][Shin Fujihara] 2010/08/18 edit end
        } else {
        	//[ID:0000620][Shin Fujihara] 2010/08/24 edit begin 総計の考え方を変更
        	//sb.append(" CLAIM_TEMP.DETAIL_VALUE AS UNIT");
        	sb.append(" SUM(CAST(CLAIM_TEMP.DETAIL_VALUE AS INTEGER)) AS UNIT");
        	//[ID:0000620][Shin Fujihara] 2010/08/24 edit begin 総計の考え方を変更
        }
        //[ID:0000476][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
        
        sb.append(" FROM");
        sb.append(" CLAIM,");
        /*
        sb.append(" CLAIM_DETAIL_TEXT_"
                //+ VRDateParser.format(targetDate, "yyyy") + " CLAIM_TEMP");
                + VRDateParser.format(seikyuDate, "yyyy") + " CLAIM_TEMP");
        */
        // 2007/01/18 - 年度単位表示への改修
        // Replace - Start Masahiko.Higuchi
        sb.append(" CLAIM_DETAIL_TEXT_" + VRDateParser.format(fiscalDate, "yyyy") + " CLAIM_TEMP");
        // Replace - End Masahiko.Higuchi  
        
        sb.append(" WHERE");
        sb.append(" (CLAIM.CLAIM_DATE = '"
                + VRDateParser.format(seikyuDate, "yyyy/MM/dd") + "')");
        sb.append(" AND(CLAIM.CLAIM_ID = CLAIM_TEMP.CLAIM_ID)");
        
        //[ID:0000619][Shin Fujihara] 2010/08/23 edit begin 事業所の絞込み条件追加
        sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        //[ID:0000619][Shin Fujihara] 2010/08/23 edit end
        
        //利用者一覧（在宅サービス支援事業所請求）
        if("03".equals(sqlParam.get("AFFAIR"))){
            sb.append(" AND(CLAIM.CATEGORY_NO = 10)");
            sb.append(" AND(CLAIM_TEMP.SYSTEM_BIND_PATH = '1001017')");
            
            //[ID:0000476][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
            sb.append(" GROUP BY");
            sb.append(" CLAIM.PATIENT_ID,");
            sb.append(" CLAIM.INSURED_ID,");
            sb.append(" CLAIM.CLAIM_STYLE_TYPE,");
            sb.append(" CLAIM.TARGET_DATE");
            //[ID:0000476][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
            
        } else {
        	//[ID:0000620][Shin Fujihara] 2010/08/24 edit begin 総計の考え方を変更
            //sb.append(" AND(CLAIM.CATEGORY_NO = 2)");
            //sb.append(" AND(CLAIM_TEMP.SYSTEM_BIND_PATH = '201033')");
            
        	sb.append(" AND (");
        	sb.append("((CLAIM.CATEGORY_NO = 2) AND CLAIM_TEMP.SYSTEM_BIND_PATH IN ('201033'))");
        	
        	//集計情報-(保険分出来高医療費)単位数合計8桁
        	sb.append(" OR ");
        	sb.append("((CLAIM.CATEGORY_NO = 7) AND CLAIM_TEMP.SYSTEM_BIND_PATH IN ('701027'))");
        	sb.append(" )");
        	
            sb.append(" GROUP BY");
            sb.append(" CLAIM.PATIENT_ID,");
            sb.append(" CLAIM.INSURED_ID,");
            sb.append(" CLAIM.CLAIM_STYLE_TYPE,");
            sb.append(" CLAIM.TARGET_DATE");
            //[ID:0000620][Shin Fujihara] 2010/08/24 edit end 総計の考え方を変更
        }


        return sb.toString();
    }

    /**
     * 「サービス合計金額を取得する」ためのSQLを返します。
     * TODO
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_SERVICE_TOTAL(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();
        Date seikyuDate = null;
        if (VRBindPathParser.has("SEIKYU_DATE", sqlParam)) {
            seikyuDate = ACCastUtilities.toDate(VRBindPathParser.get(
                    "SEIKYU_DATE", sqlParam));
        } else {
            return sb.toString();
        }
        
        // 2007/01/18 - 年度単位表示への改修
        // Addition - Start Masahiko.Higuchi
        Date fiscalDate = null;
        fiscalDate = ACDateUtilities.addMonth(seikyuDate, -3);
        // Addition - End Masahiko.Higuchi

        // 合計金額
        sb.append(" SELECT");
        sb.append(" CLAIM.PATIENT_ID || '-' || CLAIM.INSURED_ID || '-' || CLAIM_STYLE_TYPE || '-' || CLAIM.TARGET_DATE AS CODE,");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM_STYLE_TYPE,");
        //[ID:0000608][Shin Fujihara] 2010/08/18 edit begin  Firebird 2.0対応
        //sb.append(" SUM(CLAIM_TEMP.DETAIL_VALUE) AS UNIT");
        sb.append(" SUM(CAST(CLAIM_TEMP.DETAIL_VALUE AS INTEGER)) AS UNIT");
        //[ID:0000608][Shin Fujihara] 2010/08/18 edit end
        sb.append(" FROM");
        sb.append(" CLAIM,");
        
        /*
        sb.append(" CLAIM_DETAIL_TEXT_"
                //+ VRDateParser.format(targetDate, "yyyy") + " CLAIM_TEMP");
                + VRDateParser.format(seikyuDate, "yyyy") + " CLAIM_TEMP");
        */
        // 2007/01/18 - 年度単位表示への改修
        // Replace - Start Masahiko.Higuchi
        sb
                .append(" CLAIM_DETAIL_TEXT_"
                        + VRDateParser.format(fiscalDate, "yyyy")
                        + " CLAIM_TEMP");
        // Replace - End Masahiko.Higuchi
        
        sb.append(" WHERE");
        sb.append(" (CLAIM.CLAIM_DATE = '"
                + VRDateParser.format(seikyuDate, "yyyy/MM/dd") + "')");
        sb.append(" AND(CLAIM.CLAIM_ID = CLAIM_TEMP.CLAIM_ID)");
        
        //[ID:0000619][Shin Fujihara] 2010/08/23 edit begin 事業所の絞込み条件追加
        sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        //[ID:0000619][Shin Fujihara] 2010/08/23 edit end
        
        //様式第七の金額を取得
        if("03".equals(sqlParam.get("AFFAIR"))){
            sb.append(" AND(CLAIM.CATEGORY_NO = 10)");
            sb.append(" AND(CLAIM_TEMP.SYSTEM_BIND_PATH = '1001018')");
            
        //医療の請求金額を取得
        } else if("06".equals(sqlParam.get("AFFAIR"))){
            sb.append(" AND(CLAIM.CATEGORY_NO = 13)");
            sb.append(" AND(CLAIM_TEMP.SYSTEM_BIND_PATH = '1301139')");
        } else {
        	//[ID:0000620][Shin Fujihara] 2010/08/24 edit begin 総計の考え方を変更
            //sb.append(" AND(CLAIM.CATEGORY_NO = 2)");
            //sb.append(" AND(CLAIM_TEMP.SYSTEM_BIND_PATH IN ('201034','201035','201040','201046','201052'))");
        	
        	//基本情報レコード
        	sb.append(" AND (");
        	sb.append("((CLAIM.CATEGORY_NO = 2) AND CLAIM_TEMP.SYSTEM_BIND_PATH IN (");

            sb.append("'201034'");
            sb.append(",'201037'");
            sb.append(",'201036'");
            sb.append(",'201038'");

            sb.append(",'201040'");
            sb.append(",'201046'");
            sb.append(",'201052'");
            
            //特定診療費・特別療養費
            sb.append(",'201043'"); //(合計情報 公費1)特定診療費請求額8桁
            sb.append(",'201049'"); //(合計情報 公費2)特定診療費請求額8桁
            sb.append(",'201055'"); //(合計情報 公費3)特定診療費請求額8桁 
            
            //緊急時施設療養費
            sb.append(",'201042'"); //(合計情報 公費1)緊急時施設療養費請求額8桁
            sb.append(",'201048'"); //(合計情報 公費2)緊急時施設療養費請求額8桁
            sb.append(",'201054'"); //(合計情報 公費3)緊急時施設療養費請求額8桁
            
            //特定入所者介護サービス費
            sb.append(",'201044'"); //(合計情報 公費1)特定入所者介護サービス費等請求額8桁
            sb.append(",'201050'"); //(合計情報 公費2)特定入所者介護サービス費等請求額8桁
            sb.append(",'201056'"); //(合計情報 公費3)特定入所者介護サービス費等請求額8桁

        	sb.append(",'201035'"); //(合計情報 保険)利用者負担額8桁
        	sb.append(",'201041'"); //(合計情報 公費1)本人負担額8桁
        	sb.append(",'201047'"); //(合計情報 公費2)本人負担額8桁
        	sb.append(",'201053'"); //(合計情報 公費3)本人負担額8桁
        	sb.append("))");
        	
        	//集計情報レコード
        	sb.append(" OR ");
        	sb.append("((CLAIM.CATEGORY_NO = 7) AND CLAIM_TEMP.SYSTEM_BIND_PATH IN (");
        	
        	//緊急時施設療養費＋特定診療費・特別療養費
        	sb.append("'701029'"); //(保険分出来高医療費)出来高医療費利用者負担額8桁
        	sb.append(",'701032'"); //(公費1分出来高医療費)出来高医療費本人負担額8桁
        	sb.append(",'701035'"); //(公費2分出来高医療費)出来高医療費本人負担額8桁
        	sb.append(",'701038'"); //(公費3分出来高医療費)出来高医療費本人負担額8桁
        	
        	sb.append("))");
        	
        	//特定入所者レコード
        	sb.append(" OR ");
        	sb.append("((CLAIM.CATEGORY_NO = 8) AND CLAIM_TEMP.SYSTEM_BIND_PATH IN (");
        	
        	//特定入所者介護サービス費
        	sb.append("'801024'"); //(特定入所者)利用者負担額合計6桁
        	sb.append(",'801027'"); //(特定入所者　公費1)本人負担月額5桁
        	sb.append(",'801030'"); //(特定入所者　公費2)本人負担月額5桁
        	sb.append(",'801033'"); //(特定入所者　公費3)本人負担月額5桁
        	
        	sb.append(")))");
        	//[ID:0000620][Shin Fujihara] 2010/08/24 edit end 総計の考え方を変更
        }

        sb.append(" GROUP BY");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM_STYLE_TYPE,");
        sb.append(" CLAIM.TARGET_DATE");

        return sb.toString();
    }

    /**
     * 「保険請求額を取得する」ためのSQLを返します。
     * TODO
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_HOKEN_UNIT(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();
        Date seikyuDate = null;
        if (VRBindPathParser.has("SEIKYU_DATE", sqlParam)) {
            seikyuDate = ACCastUtilities.toDate(VRBindPathParser.get(
                    "SEIKYU_DATE", sqlParam));
        } else {
            return sb.toString();
        }
        
        // 2007/01/18 - 年度単位表示への改修
        // Addition - Start Masahiko.Higuchi
        Date fiscalDate = null;
        fiscalDate = ACDateUtilities.addMonth(seikyuDate, -3);
        // Addition - End Masahiko.Higuchi

        // 保険請求額
        sb.append(" SELECT");
        sb
                .append(" CLAIM.PATIENT_ID || '-' || CLAIM.INSURED_ID || '-' || CLAIM_STYLE_TYPE || '-' || CLAIM.TARGET_DATE AS CODE,");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM_STYLE_TYPE,");
        //[ID:0000620][Shin Fujihara] 2010/08/24 edit begin 総計の考え方を変更
        //sb.append(" CLAIM_TEMP.DETAIL_VALUE AS UNIT");
        sb.append(" SUM(CAST(CLAIM_TEMP.DETAIL_VALUE AS INTEGER)) AS UNIT");
        //[ID:0000620][Shin Fujihara] 2010/08/24 edit end 総計の考え方を変更
        sb.append(" FROM");
        sb.append(" CLAIM,");
        
        /*
        sb.append(" CLAIM_DETAIL_TEXT_"
//                + VRDateParser.format(targetDate, "yyyy") + " CLAIM_TEMP");
                + VRDateParser.format(seikyuDate, "yyyy") + " CLAIM_TEMP");
        */
        
        // 2007/01/18 - 年度単位表示への改修
        // Replace - Start Masahiko.Higuchi
        sb.append(" CLAIM_DETAIL_TEXT_" + VRDateParser.format(fiscalDate, "yyyy") + " CLAIM_TEMP");
        // Replace - End Masahiko.Higuchi
        
        sb.append(" WHERE");
        sb.append(" (CLAIM.CATEGORY_NO = 2)");
        sb.append(" AND(CLAIM.CLAIM_DATE = '"
                + VRDateParser.format(seikyuDate, "yyyy/MM/dd") + "')");
        sb.append(" AND(CLAIM.CLAIM_ID = CLAIM_TEMP.CLAIM_ID)");
        
        //[ID:0000620][Shin Fujihara] 2010/08/24 edit begin 総計の考え方を変更
        //sb.append(" AND(CLAIM_TEMP.SYSTEM_BIND_PATH = '201034')");
        /*
         特定診療費・特別療養費
         201037：(合計情報 保険)特定診療費請求額9桁
         
         緊急時施設療養費
         201036：(合計情報 保険)緊急時施設療養費請求額9桁
         
         特定入所者介護サービス費
         201038：(合計情報 保険)特定入所者介護サービス費等請求額8桁
         */
        sb.append(" AND(CLAIM_TEMP.SYSTEM_BIND_PATH IN ('201034','201037','201036','201038'))");
        //[ID:0000620][Shin Fujihara] 2010/08/24 edit end 総計の考え方を変更
        
        //[ID:0000619][Shin Fujihara] 2010/08/23 edit begin 事業所の絞込み条件追加
        sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        //[ID:0000619][Shin Fujihara] 2010/08/23 edit end
        
        
        //[ID:0000620][Shin Fujihara] 2010/08/24 edit start 総計の考え方を変更
        sb.append(" GROUP BY");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM_STYLE_TYPE,");
        sb.append(" CLAIM.TARGET_DATE");
        //[ID:0000620][Shin Fujihara] 2010/08/24 edit end 総計の考え方を変更
        
        return sb.toString();
    }

    /**
     * 「公費合計金額を取得する」ためのSQLを返します。
     * TODO
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_KOHI_UNIT(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();
        Date seikyuDate = null;
        if (VRBindPathParser.has("SEIKYU_DATE", sqlParam)) {
            seikyuDate = ACCastUtilities.toDate(VRBindPathParser.get(
                    "SEIKYU_DATE", sqlParam));
        } else {
            return sb.toString();
        }

        // 2007/01/18 - 年度単位表示への改修
        // Addition - Start Masahiko.Higuchi
        Date fiscalDate = null;
        fiscalDate = ACDateUtilities.addMonth(seikyuDate, -3);
        // Addition - End Masahiko.Higuchi
        
        // 公費請求
        sb.append(" SELECT");
        sb
                .append(" CLAIM.PATIENT_ID || '-' || CLAIM.INSURED_ID || '-' || CLAIM_STYLE_TYPE || '-' || CLAIM.TARGET_DATE AS CODE,");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM_STYLE_TYPE,");
        //[ID:0000608][Shin Fujihara] 2010/08/18 edit begin  Firebird 2.0対応
        //sb.append(" SUM(CLAIM_TEMP.DETAIL_VALUE) AS UNIT");
        sb.append(" SUM(CAST(CLAIM_TEMP.DETAIL_VALUE AS INTEGER)) AS UNIT");
        //[ID:0000608][Shin Fujihara] 2010/08/18 edit end
        sb.append(" FROM");
        sb.append(" CLAIM,");
        
        /*
        sb.append(" CLAIM_DETAIL_TEXT_"
                //+ VRDateParser.format(targetDate, "yyyy") + " CLAIM_TEMP");
                + VRDateParser.format(seikyuDate, "yyyy") + " CLAIM_TEMP");
        */

        // 2007/01/18 - 年度単位表示への改修
        // Replace - Start Masahiko.Higuchi
        sb.append(" CLAIM_DETAIL_TEXT_" + VRDateParser.format(fiscalDate, "yyyy") + " CLAIM_TEMP");
        // Replace - End Masahiko.Higuchi
        
        sb.append(" WHERE");
        sb.append(" (CLAIM.CATEGORY_NO = 2)");
        sb.append(" AND(CLAIM.CLAIM_DATE = '"
                + VRDateParser.format(seikyuDate, "yyyy/MM/dd") + "')");
        
        //[ID:0000619][Shin Fujihara] 2010/08/23 edit begin 事業所の絞込み条件追加
        sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        //[ID:0000619][Shin Fujihara] 2010/08/23 edit end
        
        sb.append(" AND(CLAIM.CLAIM_ID = CLAIM_TEMP.CLAIM_ID)");
        
        //[ID:0000620][Shin Fujihara] 2010/08/24 edit begin 総計の考え方を変更
        //sb.append(" AND(CLAIM_TEMP.SYSTEM_BIND_PATH IN ('201040','201046','201052'))");
        sb.append(" AND(CLAIM_TEMP.SYSTEM_BIND_PATH IN (");
        sb.append("'201040'");
        sb.append(",'201046'");
        sb.append(",'201052'");
        
        //特定診療費・特別療養費
        sb.append(",'201043'"); //(合計情報 公費1)特定診療費請求額8桁
        sb.append(",'201049'"); //(合計情報 公費2)特定診療費請求額8桁
        sb.append(",'201055'"); //(合計情報 公費3)特定診療費請求額8桁 
        
        //緊急時施設療養費
        sb.append(",'201042'"); //(合計情報 公費1)緊急時施設療養費請求額8桁
        sb.append(",'201048'"); //(合計情報 公費2)緊急時施設療養費請求額8桁
        sb.append(",'201054'"); //(合計情報 公費3)緊急時施設療養費請求額8桁
        
        //特定入所者介護サービス費
        sb.append(",'201044'"); //(合計情報 公費1)特定入所者介護サービス費等請求額8桁
        sb.append(",'201050'"); //(合計情報 公費2)特定入所者介護サービス費等請求額8桁
        sb.append(",'201056'"); //(合計情報 公費3)特定入所者介護サービス費等請求額8桁
        
        sb.append("))");
        //[ID:0000620][Shin Fujihara] 2010/08/24 edit end 総計の考え方を変更
        
        sb.append(" GROUP BY");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM_STYLE_TYPE,");
        sb.append(" CLAIM.TARGET_DATE");

        return sb.toString();
    }

    /**
     * 「利用者負担額を取得する」ためのSQLを返します。 TODO
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_RIYOUSYA_UNIT(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();
        Date seikyuDate = null;
        if (VRBindPathParser.has("SEIKYU_DATE", sqlParam)) {
            seikyuDate = ACCastUtilities.toDate(VRBindPathParser.get(
                    "SEIKYU_DATE", sqlParam));
        } else {
            return sb.toString();
        }
        
        // 2007/01/18 - 年度単位表示への改修
        // Addition - Start Masahiko.Higuchi
        Date fiscalDate = null;
        fiscalDate = ACDateUtilities.addMonth(seikyuDate, -3);
        // Addition - End Masahiko.Higuchi

        // 利用者負担額
        sb.append(" SELECT");
        sb.append(" CLAIM.PATIENT_ID || '-' || CLAIM.INSURED_ID || '-' || CLAIM_STYLE_TYPE || '-' || CLAIM.TARGET_DATE AS CODE,");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM_STYLE_TYPE,");
        //[ID:0000620][Shin Fujihara] 2010/08/24 edit begin 総計の考え方を変更
        //sb.append(" CLAIM_TEMP.DETAIL_VALUE AS UNIT");
        sb.append(" SUM(CAST(CLAIM_TEMP.DETAIL_VALUE AS INTEGER)) AS UNIT");
        //[ID:0000620][Shin Fujihara] 2010/08/24 edit end 総計の考え方を変更
        sb.append(" FROM");
        sb.append(" CLAIM,");
        
        /*
        sb.append(" CLAIM_DETAIL_TEXT_"
                //+ VRDateParser.format(targetDate, "yyyy") + " CLAIM_TEMP");
                + VRDateParser.format(seikyuDate, "yyyy") + " CLAIM_TEMP");
        */
        
        // 2007/01/18 - 年度単位表示への改修
        // Replace - Start Masahiko.Higuchi
        sb.append(" CLAIM_DETAIL_TEXT_" + VRDateParser.format(fiscalDate, "yyyy") + " CLAIM_TEMP");
        // Replace - End Masahiko.Higuchi
        
        sb.append(" WHERE");
        sb.append(" (CLAIM.CLAIM_DATE = '"
                + VRDateParser.format(seikyuDate, "yyyy/MM/dd") + "')");
        sb.append(" AND(CLAIM.CLAIM_ID = CLAIM_TEMP.CLAIM_ID)");
        
        //[ID:0000619][Shin Fujihara] 2010/08/23 edit begin 事業所の絞込み条件追加
        sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        //[ID:0000619][Shin Fujihara] 2010/08/23 edit end
        
        if("06".equals(sqlParam.get("AFFAIR"))){
            sb.append(" AND(CLAIM.CATEGORY_NO = 13)");
            sb.append(" AND(CLAIM_TEMP.SYSTEM_BIND_PATH = '1301140')");
        } else {
        	//[ID:0000620][Shin Fujihara] 2010/08/24 edit begin 総計の考え方を変更
            //sb.append(" AND(CLAIM.CATEGORY_NO = 2)");
            //sb.append(" AND(CLAIM_TEMP.SYSTEM_BIND_PATH = '201035')");
        	
        	//基本情報レコード
        	sb.append(" AND (");
        	sb.append("((CLAIM.CATEGORY_NO = 2) AND CLAIM_TEMP.SYSTEM_BIND_PATH IN (");
        	sb.append("'201035'"); //(合計情報 保険)利用者負担額8桁
        	sb.append(",'201041'"); //(合計情報 公費1)本人負担額8桁
        	sb.append(",'201047'"); //(合計情報 公費2)本人負担額8桁
        	sb.append(",'201053'"); //(合計情報 公費3)本人負担額8桁
        	sb.append("))");
        	
        	//集計情報レコード
        	sb.append(" OR ");
        	sb.append("((CLAIM.CATEGORY_NO = 7) AND CLAIM_TEMP.SYSTEM_BIND_PATH IN (");
        	
        	//緊急時施設療養費＋特定診療費・特別療養費
        	sb.append("'701029'"); //(保険分出来高医療費)出来高医療費利用者負担額8桁
        	sb.append(",'701032'"); //(公費1分出来高医療費)出来高医療費本人負担額8桁
        	sb.append(",'701035'"); //(公費2分出来高医療費)出来高医療費本人負担額8桁
        	sb.append(",'701038'"); //(公費3分出来高医療費)出来高医療費本人負担額8桁
        	
        	sb.append("))");
        	
        	//特定入所者レコード
        	sb.append(" OR ");
        	sb.append("((CLAIM.CATEGORY_NO = 8) AND CLAIM_TEMP.SYSTEM_BIND_PATH IN (");
        	
        	//特定入所者介護サービス費
        	sb.append("'801024'"); //(特定入所者)利用者負担額合計6桁
        	sb.append(",'801027'"); //(特定入所者　公費1)本人負担月額5桁
        	sb.append(",'801030'"); //(特定入所者　公費2)本人負担月額5桁
        	sb.append(",'801033'"); //(特定入所者　公費3)本人負担月額5桁
        	
        	sb.append(")))");
        	
            //[ID:0000620][Shin Fujihara] 2010/08/24 edit end 総計の考え方を変更
        }
        
        //[ID:0000620][Shin Fujihara] 2010/08/24 edit begin 総計の考え方を変更
        sb.append(" GROUP BY");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM_STYLE_TYPE,");
        sb.append(" CLAIM.TARGET_DATE");
        //[ID:0000620][Shin Fujihara] 2010/08/24 edit end 総計の考え方を変更

        return sb.toString();
    }

    /**
     * 「保険区分を取得する」ためのSQLを返します。
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_INSURE_TYPE(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();
        Date seikyuDate = null;
        if (VRBindPathParser.has("SEIKYU_DATE", sqlParam)) {
            seikyuDate = ACCastUtilities.toDate(VRBindPathParser.get(
                    "SEIKYU_DATE", sqlParam));
        } else {
            return sb.toString();
        }

        // 2007/01/18 - 年度単位表示への改修
        // Addition - Start Masahiko.Higuchi
        Date fiscalDate = null;
        fiscalDate = ACDateUtilities.addMonth(seikyuDate, -3);
        // Addition - End Masahiko.Higuchi
        
        // 利用者負担額
        sb.append(" SELECT");
        sb.append(" CLAIM.PATIENT_ID || '-' || CLAIM.INSURED_ID || '-' || CLAIM_STYLE_TYPE || '-' || CLAIM.TARGET_DATE AS CODE,");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM_STYLE_TYPE,");
        sb.append(" CLAIM_TEMP.DETAIL_VALUE AS INSURE_TYPE");
        sb.append(" FROM");
        sb.append(" CLAIM,");

        /* 2007/01/08 - Delete
         * MasaHiko.Higuchi
        sb.append(" CLAIM_DETAIL_INTEGER_"
                + VRDateParser.format(seikyuDate, "yyyy") + " CLAIM_TEMP");
        */
        // 2007/01/18 - 年度単位表示への改修
        // Replace - Start Masahiko.Higuchi
        sb.append(" CLAIM_DETAIL_TEXT_" + VRDateParser.format(fiscalDate, "yyyy") + " CLAIM_TEMP");
        // Replace - End Masahiko.Higuchi
        
        sb.append(" WHERE");
        sb.append(" (CLAIM.CLAIM_DATE = '"
                + VRDateParser.format(seikyuDate, "yyyy/MM/dd") + "')");
        
        //[ID:0000619][Shin Fujihara] 2010/08/23 edit begin 事業所の絞込み条件追加
        sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        //[ID:0000619][Shin Fujihara] 2010/08/23 edit end
        
        sb.append(" AND(CLAIM.CLAIM_ID = CLAIM_TEMP.CLAIM_ID)");
        sb.append(" AND(CLAIM.CATEGORY_NO = 13)");
        sb.append(" AND(CLAIM_TEMP.SYSTEM_BIND_PATH = '1301011')");

        return sb.toString();
    }
    
    /**
     * 印刷進捗フラグを更新するためのSQL文を取得します。
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_UPDATE_CLAIMSTATE(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        Date targetDate = ACCastUtilities.toDate(VRBindPathParser.get(
                "TARGET_DATE", sqlParam));

        sb.append(" UPDATE");
        sb.append(" CLAIM");
        sb.append(" SET CLAIM_FINISH_FLAG = "
                + VRBindPathParser.get("PRINT", sqlParam));
        sb.append(" WHERE");
        
        sb.append(" (PATIENT_ID = "
                + VRBindPathParser.get("PATIENT_ID", sqlParam) + ")");
        
        if(sqlParam.get("PROVIDER_ID") != null){
            sb.append(" AND (PROVIDER_ID = '"
                    + VRBindPathParser.get("PROVIDER_ID", sqlParam) + "')");
        }
        
        if(sqlParam.get("CLAIM_STYLE_TYPE") != null){
            sb.append(" AND (CLAIM_STYLE_TYPE = "
                    + VRBindPathParser.get("CLAIM_STYLE_TYPE", sqlParam) + ")");
        }

        
        if(targetDate != null){
            sb.append(" AND (TARGET_DATE = '"
                    + VRDateParser.format(targetDate, "yyyy/MM/dd") + "')");
        }
        
        if(sqlParam.get("INSURED_ID") != null){
            sb.append(" AND (INSURED_ID = '"
                    + VRBindPathParser.get("INSURED_ID", sqlParam) + "')");
        }
        
        if(sqlParam.get("INSURER_ID") != null){
            sb.append(" AND (INSURER_ID = '"
                    + VRBindPathParser.get("INSURER_ID", sqlParam) + "')");
        }
        
        return sb.toString();
    }
    
    /**
     * 印刷進捗フラグの更新対象となるデータの取得を行うSQL文を取得します。
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_UPDATE_TARGET_CLAIMSTATE(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        Date targetDate = ACCastUtilities.toDate(VRBindPathParser.get(
                "TARGET_DATE", sqlParam));

        //sb.append(" SELECT * FROM");
        sb.append(" SELECT DISTINCT PATIENT_ID,CLAIM_STYLE_TYPE,TARGET_DATE,INSURED_ID,INSURER_ID,CLAIM_FINISH_FLAG FROM");
        sb.append(" CLAIM");
        sb.append(" WHERE");
        
        sb.append(" (PATIENT_ID = "
                + VRBindPathParser.get("PATIENT_ID", sqlParam) + ")");
        
        if(sqlParam.get("CLAIM_STYLE_TYPE") != null){
            sb.append(" AND (CLAIM_STYLE_TYPE = "
                    + VRBindPathParser.get("CLAIM_STYLE_TYPE", sqlParam) + ")");
        }

        
        if(targetDate != null){
            sb.append(" AND (TARGET_DATE = '"
                    + VRDateParser.format(targetDate, "yyyy/MM/dd") + "')");
        }
        
        if(sqlParam.get("INSURED_ID") != null){
            sb.append(" AND (INSURED_ID = '"
                    + VRBindPathParser.get("INSURED_ID", sqlParam) + "')");
        }
        
        if(sqlParam.get("INSURER_ID") != null){
            sb.append(" AND (INSURER_ID = '"
                    + VRBindPathParser.get("INSURER_ID", sqlParam) + "')");
        }
        
        return sb.toString();
    }
    
    /**
     * 利用者請求　利用者負担額等を取得するためのSQLを取得します。
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_CLAIM_DETAIL_PATIENT(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT");
        sb.append(" CLAIM.TARGET_DATE,");
        sb.append(" CLAIM_PATIENT_DETAIL.*");
        sb.append(" FROM");
        sb.append(" CLAIM,");
        sb.append(" CLAIM_PATIENT_DETAIL");
        sb.append(" WHERE");
        sb.append(" (CLAIM.CLAIM_ID = CLAIM_PATIENT_DETAIL.CLAIM_ID)");
        sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = 30101)");
        sb.append(" AND(CLAIM.CATEGORY_NO = 16)");
        
        sb.append(" AND(CLAIM.PATIENT_ID = " + sqlParam.get("PATIENT_ID") + ")");
        sb.append(" AND(CLAIM.CLAIM_DATE = '" + sqlParam.get("CLAIM_DATE") + "')");
        sb.append(" AND(CLAIM.PROVIDER_ID = '" + sqlParam.get("PROVIDER_ID") + "')");
        
        return sb.toString();
    }
    
    /**
     * 印刷進捗フラグを取得するためのSQLを取得します。
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_CLAIM(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();
        
        String affair = ACCastUtilities.toString(sqlParam.get("AFFAIR"));
        
        sb.append(" SELECT DISTINCT");
        
        if("01".equals(affair)){
            sb.append(" CLAIM.PATIENT_ID || '-' || CLAIM.PROVIDER_ID || '-' || CLAIM.TARGET_DATE AS CODE,");
        } else if ("07".equals(affair) || "08".equals(affair)){
            //sb.append(" CLAIM.PATIENT_ID || '-' || CLAIM.PROVIDER_ID || '-' || CLAIM.CLAIM_DATE AS CODE,");
            sb.append(" CLAIM.PATIENT_ID || '-' || CLAIM.PROVIDER_ID || '-' || CLAIM.TARGET_DATE  || '-' || CLAIM.INSURER_ID || '-' || CLAIM.INSURED_ID AS CODE,");
        } else {
            //sb.append(" CLAIM.PATIENT_ID || '-' || CLAIM.PROVIDER_ID || '-' || CLAIM.CLAIM_DATE || '-' || CLAIM.CLAIM_STYLE_TYPE AS CODE,");
            sb.append(" CLAIM.PATIENT_ID || '-' || CLAIM.PROVIDER_ID || '-' || CLAIM.TARGET_DATE || '-' || CLAIM.INSURER_ID || '-' || CLAIM.INSURED_ID || '-' || CLAIM.CLAIM_STYLE_TYPE AS CODE,");
        }
        
        sb.append(" CLAIM.TARGET_DATE,");
        sb.append(" CLAIM.CLAIM_FINISH_FLAG,");
        sb.append(" CLAIM.CLAIM_DATE");
        sb.append(" FROM CLAIM");
        sb.append(" WHERE");
        if("01".equals(affair)){
            Date targetDate = ACCastUtilities.toDate(sqlParam.get("TARGET_DATE_VALUE"));
            sb.append(" CLAIM.TARGET_DATE = '" + VRDateParser.format(targetDate, "yyyy/MM/dd") + "'");
            sb.append(" AND (CLAIM.CATEGORY_NO != 16)");
        } else {
            Date targetDate = ACCastUtilities.toDate(sqlParam.get("CLAIM_DATE"));
            sb.append(" CLAIM.CLAIM_DATE = '" + VRDateParser.format(targetDate, "yyyy/MM/dd") + "'");
        }
        
        sb.append(" ORDER BY");
        sb.append(" CLAIM.CLAIM_FINISH_FLAG");
        
        return sb.toString();
    }
    
    /**
     * 利用者の居宅介護支援事業所IDを取得する。
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_CARE_PROVIDER(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();
        
        Date target = ACCastUtilities.toDate(sqlParam.get("CLAIM_DATE"),null);
        
        sb.append(" SELECT PROVIDER_ID FROM PATIENT_NINTEI_HISTORY");
        sb.append(" WHERE");
        sb.append(" (PATIENT_ID = " + sqlParam.get("PATIENT_ID") + ")");
        if(target != null){
 // 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
//            sb.append(" AND(INSURE_VALID_START <= '" + VRDateParser.format(ACDateUtilities.toLastDayOfMonth(target),"yyyy/MM/dd") + "')");
//            sb.append(" AND(INSURE_VALID_END >= '" + VRDateParser.format(ACDateUtilities.toFirstDayOfMonth(target),"yyyy/MM/dd") + "')");
            sb.append(" AND(SYSTEM_INSURE_VALID_START <= '" + VRDateParser.format(ACDateUtilities.toLastDayOfMonth(target),"yyyy/MM/dd") + "')");
            sb.append(" AND(SYSTEM_INSURE_VALID_END >= '" + VRDateParser.format(ACDateUtilities.toFirstDayOfMonth(target),"yyyy/MM/dd") + "')");
 // 2014/12/17 [Yoichiro Kamei] mod - end
        }
 // 2014/12/17 [Yoichiro Kamei] mod - begin システム有効期間対応
 //       sb.append(" ORDER BY INSURE_VALID_END DESC");
        sb.append(" ORDER BY SYSTEM_INSURE_VALID_END DESC");
 // 2014/12/17 [Yoichiro Kamei] mod - end
        return sb.toString();
    }
    
    // 2008/08/07 [Masahiko Higuchi] Add - begin 集計障害対応（V5.4.2）    
    /**
     * 「登録パッシブチェック用」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_GET_NEW_CLAIM_PATIENT_DETAIL(VRMap sqlParam) throws Exception{
      StringBuilder sb = new StringBuilder();
      Object[] inValues;
      Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
      boolean firstCondition = true, firstConditionOfFrom = true;
      Object obj;

      sb.append("SELECT");

      sb.append(" CLAIM.CLAIM_ID");

      sb.append(" FROM");

      sb.append(" CLAIM");

      sb.append(" WHERE");

      sb.append("(");

      sb.append(" CLAIM.PATIENT_ID");

      sb.append(" =");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

      sb.append(")");

      sb.append("AND");

      sb.append("(");

      sb.append(" CLAIM.TARGET_DATE");

      sb.append(" =");

      sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

      sb.append(")");

      sb.append("AND");

      sb.append("(");

      sb.append(" CLAIM.CLAIM_DATE");

      sb.append(" =");

      sb.append(dateFormat.format(VRBindPathParser.get("CLAIM_DATE", sqlParam), "yyyy-MM-dd"));

      sb.append(")");

      sb.append("AND");

      sb.append("(");

      sb.append(" CLAIM.PROVIDER_ID");

      sb.append(" =");

      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

      sb.append(")");

      sb.append("AND");

      sb.append("(");

      sb.append(" CLAIM.CLAIM_STYLE_TYPE");

      sb.append(" =");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_STYLE_TYPE", sqlParam)));

      sb.append(")");

      sb.append("AND");

      sb.append("(");

      sb.append(" CLAIM.CATEGORY_NO");

      sb.append(" =");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CATEGORY_NO", sqlParam)));

      sb.append(")");

      return sb.toString();
    }

    /**
     * 「請求情報を登録する。」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_INSERT_CLAIM(VRMap sqlParam) throws Exception{
      StringBuilder sb = new StringBuilder();
      Object[] inValues;
      Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
      boolean firstCondition = true, firstConditionOfFrom = true;
      Object obj;

      sb.append("INSERT INTO");

      sb.append(" CLAIM");

      sb.append("(");

      sb.append(" CLAIM_ID");

      sb.append(",CLAIM_STYLE_TYPE");

      sb.append(",CATEGORY_NO");

      sb.append(",PATIENT_ID");

      sb.append(",INSURED_ID");

      sb.append(",TARGET_DATE");

      sb.append(",CLAIM_DATE");

      sb.append(",INSURER_ID");

      sb.append(",PROVIDER_ID");

      sb.append(",CLAIM_FINISH_FLAG");

      sb.append(",LAST_TIME");

      sb.append(")VALUES(");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_STYLE_TYPE", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CATEGORY_NO", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURED_ID", sqlParam)));

      sb.append(",");

      sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

      sb.append(",");

      sb.append(dateFormat.format(VRBindPathParser.get("CLAIM_DATE", sqlParam), "yyyy-MM-dd"));

      sb.append(",");

      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_FINISH_FLAG", sqlParam)));

      sb.append(",");

      sb.append(" CURRENT_TIMESTAMP");

      sb.append(")");

      return sb.toString();
    }

    /**
     * 「利用者向け請求書データが存在しているかチェックします。」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_GET_CLAIM_PATIENT_TARGET_DATA_COUNT(VRMap sqlParam) throws Exception{
      StringBuilder sb = new StringBuilder();
      Object[] inValues;
      Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
      boolean firstCondition = true, firstConditionOfFrom = true;
      Object obj;

      sb.append("SELECT");

      sb.append(" CLAIM_ID");

      sb.append(" FROM");

      sb.append(" CLAIM_PATIENT_DETAIL");

      sb.append(" WHERE");

      sb.append("(");

      sb.append(" CLAIM_ID");

      sb.append(" =");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

      sb.append(")");

      return sb.toString();
    }

    /**
     * 「全額自己負担項目のみ登録用SQL」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_INSERT_CLAIM_PATIENT_DETAIL_ONLY_SELF(VRMap sqlParam) throws Exception{
      StringBuilder sb = new StringBuilder();
      Object[] inValues;
      Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
      boolean firstCondition = true, firstConditionOfFrom = true;
      Object obj;

      sb.append("INSERT INTO");

      sb.append(" CLAIM_PATIENT_DETAIL");

      sb.append("(");

      sb.append(" CLAIM_ID");

      sb.append(",SELF_SERVICE_NO1");

      sb.append(",SELF_PAY_NO1");

      sb.append(",SELF_SERVICE_NO2");

      sb.append(",SELF_PAY_NO2");

      sb.append(",SELF_SERVICE_NO3");

      sb.append(",SELF_PAY_NO3");
      
      //[ID:0000435][Shin Fujihara] 2009/07 add begin 2009年度対応
      sb.append(",MARK1_SERVICE_NAME");
      sb.append(",MARK1_SERVICE_DATE_BIT");
      sb.append(",MARK2_SERVICE_NAME");
      sb.append(",MARK2_SERVICE_DATE_BIT");
      sb.append(",MARK3_SERVICE_NAME");
      sb.append(",MARK3_SERVICE_DATE_BIT");
      sb.append(",MARK4_SERVICE_NAME");
      sb.append(",MARK4_SERVICE_DATE_BIT");
      sb.append(",MARK5_SERVICE_NAME");
      sb.append(",MARK5_SERVICE_DATE_BIT");
      sb.append(",MARK6_SERVICE_NAME");
      sb.append(",MARK6_SERVICE_DATE_BIT");
      sb.append(",MARK7_SERVICE_NAME");
      sb.append(",MARK7_SERVICE_DATE_BIT");
      //[ID:0000435][Shin Fujihara] 2009/07 add end 2009年度対応
      
      //[ID:0000588][Shin Fujihara] 2010/01 add begin 2009年度対応
      //「内消費税」に初期値0を与える
      sb.append(",INNER_TAX");
      //[ID:0000588][Shin Fujihara] 2010/01 add begin 2009年度対応
      
      //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
      //サービス種類コードを追加
      //FIXME [0000612]
      //sb.append(",SERVICE_CODE_KIND");
      //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応

      sb.append(",LAST_TIME");

      sb.append(")VALUES(");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO1", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO1", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO2", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO2", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO3", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO3", sqlParam)));

      sb.append(",");
      
      //[ID:0000435][Shin Fujihara] 2009/07 add begin 2009年度対応
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MARK1_SERVICE_NAME", sqlParam)));
      sb.append(",");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK1_SERVICE_DATE_BIT", sqlParam)));
      sb.append(",");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MARK2_SERVICE_NAME", sqlParam)));
      sb.append(",");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK2_SERVICE_DATE_BIT", sqlParam)));
      sb.append(",");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MARK3_SERVICE_NAME", sqlParam)));
      sb.append(",");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK3_SERVICE_DATE_BIT", sqlParam)));
      sb.append(",");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MARK4_SERVICE_NAME", sqlParam)));
      sb.append(",");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK4_SERVICE_DATE_BIT", sqlParam)));
      sb.append(",");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MARK5_SERVICE_NAME", sqlParam)));
      sb.append(",");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK5_SERVICE_DATE_BIT", sqlParam)));
      sb.append(",");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MARK6_SERVICE_NAME", sqlParam)));
      sb.append(",");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK6_SERVICE_DATE_BIT", sqlParam)));
      sb.append(",");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MARK7_SERVICE_NAME", sqlParam)));
      sb.append(",");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK7_SERVICE_DATE_BIT", sqlParam)));
      sb.append(",");
      //[ID:0000435][Shin Fujihara] 2009/07 add end 2009年度対応
      
      //[ID:0000588][Shin Fujihara] 2010/01 add begin 2009年度対応
      //「内消費税」に初期値0を与える
      sb.append(" 0,");
      //[ID:0000588][Shin Fujihara] 2010/01 add begin 2009年度対応
      
      //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
      //サービス種類コードを追加
      /* FIXME [0000612]
      if (sqlParam.containsKey("SERVICE_CODE_KIND")) {
    	  sb.append(" '");
    	  sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SERVICE_CODE_KIND", sqlParam)));
    	  sb.append("',");
      } else {
    	  sb.append(" '00',");
      }
      */
      //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
      
      sb.append(" CURRENT_TIMESTAMP");

      sb.append(")");

      return sb.toString();
    }

    /**
     * 「全額自己負担項目のみ更新用SQL」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_UPDATE_CLAIM_PATIENT_DETAIL_ONLY_SELF(VRMap sqlParam) throws Exception{
      StringBuilder sb = new StringBuilder();
      Object[] inValues;
      Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
      boolean firstCondition = true, firstConditionOfFrom = true;
      Object obj;

      sb.append("UPDATE");

      sb.append(" CLAIM_PATIENT_DETAIL");

      sb.append(" SET");

      sb.append(" CLAIM_ID");

      sb.append(" =");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

      sb.append(",");

      sb.append(" SELF_SERVICE_NO1");

      sb.append(" =");

      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO1", sqlParam)));

      sb.append(",");

      sb.append(" SELF_PAY_NO1");

      sb.append(" =");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO1", sqlParam)));

      sb.append(",");

      sb.append(" SELF_SERVICE_NO2");

      sb.append(" =");

      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO2", sqlParam)));

      sb.append(",");

      sb.append(" SELF_PAY_NO2");

      sb.append(" =");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO2", sqlParam)));

      sb.append(",");

      sb.append(" SELF_SERVICE_NO3");

      sb.append(" =");

      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO3", sqlParam)));

      sb.append(",");

      sb.append(" SELF_PAY_NO3");

      sb.append(" =");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO3", sqlParam)));

      sb.append(",");

      //[ID:0000435][Shin Fujihara] 2009/07 add begin 2009年度対応
      sb.append(" MARK1_SERVICE_NAME");
      sb.append(" =");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MARK1_SERVICE_NAME", sqlParam)));
      sb.append(",");

      sb.append(" MARK1_SERVICE_DATE_BIT");
      sb.append(" =");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK1_SERVICE_DATE_BIT", sqlParam)));
      sb.append(",");
      
      sb.append(" MARK2_SERVICE_NAME");
      sb.append(" =");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MARK2_SERVICE_NAME", sqlParam)));
      sb.append(",");

      sb.append(" MARK2_SERVICE_DATE_BIT");
      sb.append(" =");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK2_SERVICE_DATE_BIT", sqlParam)));
      sb.append(",");
      
      sb.append(" MARK3_SERVICE_NAME");
      sb.append(" =");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MARK3_SERVICE_NAME", sqlParam)));
      sb.append(",");

      sb.append(" MARK3_SERVICE_DATE_BIT");
      sb.append(" =");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK3_SERVICE_DATE_BIT", sqlParam)));
      sb.append(",");
      
      sb.append(" MARK4_SERVICE_NAME");
      sb.append(" =");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MARK4_SERVICE_NAME", sqlParam)));
      sb.append(",");

      sb.append(" MARK4_SERVICE_DATE_BIT");
      sb.append(" =");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK4_SERVICE_DATE_BIT", sqlParam)));
      sb.append(",");
      
      sb.append(" MARK5_SERVICE_NAME");
      sb.append(" =");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MARK5_SERVICE_NAME", sqlParam)));
      sb.append(",");

      sb.append(" MARK5_SERVICE_DATE_BIT");
      sb.append(" =");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK5_SERVICE_DATE_BIT", sqlParam)));
      sb.append(",");
      
      sb.append(" MARK6_SERVICE_NAME");
      sb.append(" =");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MARK6_SERVICE_NAME", sqlParam)));
      sb.append(",");

      sb.append(" MARK6_SERVICE_DATE_BIT");
      sb.append(" =");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK6_SERVICE_DATE_BIT", sqlParam)));
      sb.append(",");

      sb.append(" MARK7_SERVICE_NAME");
      sb.append(" =");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MARK7_SERVICE_NAME", sqlParam)));
      sb.append(",");

      sb.append(" MARK7_SERVICE_DATE_BIT");
      sb.append(" =");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK7_SERVICE_DATE_BIT", sqlParam)));
      sb.append(",");
      //[ID:0000435][Shin Fujihara] 2009/07 add end 2009年度対応
      
      sb.append(" LAST_TIME");

      sb.append(" =");

      sb.append(" CURRENT_TIMESTAMP");

      sb.append(" WHERE");

      sb.append("(");

      sb.append(" CLAIM_ID");

      sb.append(" =");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

      sb.append(")");
      
      //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
      /*FIXME [0000612]
      if (sqlParam.containsKey("SERVICE_CODE_KIND")) {
          sb.append(" AND (");
          sb.append(" SERVICE_CODE_KIND");
          sb.append(" ='");
          sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SERVICE_CODE_KIND", sqlParam)));
          sb.append("')");
      }
      */
      //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応

      return sb.toString();
    }

    /**
     * 「選択肢として既に登録されているか確認する。」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_GET_COUNT_SELF_PAY(VRMap sqlParam) throws Exception{
      StringBuilder sb = new StringBuilder();
      Object[] inValues;
      Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
      boolean firstCondition = true, firstConditionOfFrom = true;
      Object obj;

      sb.append("SELECT");

      sb.append(" CASE");

      sb.append(" WHEN");

      sb.append(" MAX(CONTENT_KEY) IS NULL THEN 0 ELSE MAX(CONTENT_KEY + 1) END AS CONTENT_SELF_PAY");

      sb.append(" FROM");

      sb.append(" FIXED_FORM");

      sb.append(" WHERE");

      sb.append("(");

      sb.append(" TABLE_TYPE");

      sb.append(" =");

      sb.append(" 1");

      sb.append(")");

      sb.append("AND");

      sb.append("(");

      sb.append(" FIXED_FORM_ID");

      sb.append(" =");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FIXED_FORM_ID", sqlParam)));

      sb.append(")");

      sb.append("AND");

      sb.append("(");

      sb.append(" CONTENT");

      sb.append(" =");

      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CONTENT", sqlParam)));

      sb.append(")");

      return sb.toString();
    }

    /**
     * 「CONTENT_KEYの最大値+1の値を取得する。」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_GET_NEW_CONTENT_KEY(VRMap sqlParam) throws Exception{
      StringBuilder sb = new StringBuilder();
      Object[] inValues;
      Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
      boolean firstCondition = true, firstConditionOfFrom = true;
      Object obj;

      sb.append("SELECT");

      sb.append(" CASE");

      sb.append(" WHEN");

      sb.append(" MAX(CONTENT_KEY)  IS NULL THEN 0 ELSE MAX(CONTENT_KEY + 1) END AS NEW_CONTENT_KEY");

      sb.append(" FROM");

      sb.append(" FIXED_FORM");

      sb.append(" WHERE");

      sb.append("(");

      sb.append(" TABLE_TYPE");

      sb.append(" =");

      sb.append(" 1");

      sb.append(")");

      sb.append("AND");

      sb.append("(");

      sb.append(" FIXED_FORM_ID");

      sb.append(" =");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FIXED_FORM_ID", sqlParam)));

      sb.append(")");

      return sb.toString();
    }

    /**
     * 「新たにCONTENT_SORTを取得する。」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_GET_NEW_CONTENT_SORT(VRMap sqlParam) throws Exception{
      StringBuilder sb = new StringBuilder();
      Object[] inValues;
      Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
      boolean firstCondition = true, firstConditionOfFrom = true;
      Object obj;

      sb.append("SELECT");

      sb.append(" CASE");

      sb.append(" WHEN");

      sb.append(" MAX(CONTENT_SORT)  IS NULL THEN 0 ELSE MAX(CONTENT_SORT + 1) END AS NEW_CONTENT_SORT");

      sb.append(" FROM");

      sb.append(" FIXED_FORM");

      sb.append(" WHERE");

      sb.append("(");

      sb.append(" TABLE_TYPE");

      sb.append(" =");

      sb.append(" 1");

      sb.append(")");

      sb.append("AND");

      sb.append("(");

      sb.append(" FIXED_FORM_ID");

      sb.append(" =");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FIXED_FORM_ID", sqlParam)));

      sb.append(")");

      return sb.toString();
    }

    /**
     * 「定型文テーブルに追加する。」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_INSERT_FIXED_FORM(VRMap sqlParam) throws Exception{
      StringBuilder sb = new StringBuilder();
      Object[] inValues;
      Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
      boolean firstCondition = true, firstConditionOfFrom = true;
      Object obj;

      sb.append("INSERT INTO");

      sb.append(" FIXED_FORM");

      sb.append("(");

      sb.append(" TABLE_TYPE");

      sb.append(",FIXED_FORM_ID");

      sb.append(",CONTENT_KEY");

      sb.append(",CONTENT");

      sb.append(",CONTENT_SORT");

      sb.append(",LAST_TIME");

      sb.append(")VALUES(");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("TABLE_TYPE", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FIXED_FORM_ID", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CONTENT_KEY", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CONTENT", sqlParam)));

      sb.append(",");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CONTENT_SORT", sqlParam)));

      sb.append(",");

      sb.append(" CURRENT_TIMESTAMP");

      sb.append(")");

      return sb.toString();
    }
    // 2008/08/07 [Masahiko Higuchi] Add - end
    
    
    
    //[ID:0000455][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
    /**
     * 「40件以上プランを作成したスタッフ情報を取得する。」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_MAKE_OVER_40_PLAN_STAFF(VRMap sqlParam) throws Exception{
      StringBuilder sb = new StringBuilder();
      Object[] inValues;
      Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
      boolean firstCondition = true, firstConditionOfFrom = true;
      Object obj;
      
      String year = ACCastUtilities.toString(sqlParam.get("YEAR"));
      String start = ACCastUtilities.toString(sqlParam.get("START"));
      String end = ACCastUtilities.toString(sqlParam.get("END"));

      sb.append("SELECT DISTINCT");

      sb.append(" SERVICE.PROVIDER_ID,");
      sb.append(" SERVICE_DETAIL_TEXT_");
      sb.append(year);
      sb.append(".DETAIL_VALUE AS CARE_MANAGER_NO,");
      sb.append(" STAFF.STAFF_FAMILY_NAME,");
      sb.append(" STAFF.STAFF_FIRST_NAME,");
      sb.append(" COUNT(SERVICE.PATIENT_ID) AS PLAN_COUNT");
      
      sb.append(" FROM");
      sb.append(" SERVICE");
      
      sb.append(" LEFT JOIN");
      sb.append(" SERVICE_DETAIL_TEXT_");
      sb.append(year);
      sb.append(" ON");
      sb.append(" (SERVICE.SERVICE_ID = SERVICE_DETAIL_TEXT_");
      sb.append(year);
      sb.append(".SERVICE_ID) AND");
      sb.append(" (SERVICE_DETAIL_TEXT_");
      sb.append(year);
      sb.append(".SYSTEM_BIND_PATH = 1430107)");
      
      sb.append(" LEFT JOIN");
      sb.append(" SERVICE_DETAIL_INTEGER_");
      sb.append(year);
      sb.append(" ON");
      sb.append(" (SERVICE.SERVICE_ID = SERVICE_DETAIL_INTEGER_");
      sb.append(year);
      sb.append(".SERVICE_ID) AND");
      sb.append(" (SERVICE_DETAIL_INTEGER_");
      sb.append(year);
      sb.append(".SYSTEM_BIND_PATH = 1430103)");
      
      sb.append(" LEFT JOIN");
      sb.append(" STAFF");
      sb.append(" ON");
      sb.append(" (SERVICE.PROVIDER_ID = STAFF.PROVIDER_ID) AND");
      sb.append(" (SERVICE_DETAIL_TEXT_");
      sb.append(year);
      sb.append(".DETAIL_VALUE = STAFF.CARE_MANAGER_NO)");
      
      sb.append(" WHERE");
      sb.append(" (SERVICE.SERVICE_DATE >= '");
      sb.append(start);
      sb.append("') AND");
      sb.append(" (SERVICE.SERVICE_DATE <= '");
      sb.append(end);
      sb.append("') AND");
      sb.append(" (SERVICE.SERVICE_USE_TYPE = 6) AND");
      sb.append(" (SERVICE.SYSTEM_SERVICE_KIND_DETAIL = 14311) AND");
      sb.append(" (SERVICE_DETAIL_INTEGER_");
      sb.append(year);
      sb.append(".DETAIL_VALUE = 1)");
      
      sb.append(" GROUP BY");
      sb.append(" SERVICE.PROVIDER_ID,");
      sb.append(" SERVICE_DETAIL_TEXT_");
      sb.append(year);
      sb.append(".DETAIL_VALUE,");
      sb.append(" STAFF.STAFF_FAMILY_NAME,");
      sb.append(" STAFF.STAFF_FIRST_NAME");

      sb.append(" HAVING");
      sb.append(" COUNT(SERVICE.PATIENT_ID) >= 40");

      return sb.toString();
    }
    //[ID:0000455][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
    
    //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
    /**
     * 「利用者向け請求書データ削除用」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_GET_CLAIM_PATIENT_DETAIL_DELETE(VRMap sqlParam) throws Exception{
      StringBuilder sb = new StringBuilder();
      String deleteMode = ACCastUtilities.toString(VRBindPathParser.get("MODE", sqlParam));

      sb.append("DELETE");
      sb.append(" FROM");
      sb.append(" CLAIM_PATIENT_DETAIL");
      sb.append(" WHERE");
      sb.append("(");
      sb.append(" CLAIM_ID");
      sb.append(" =");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));
      sb.append(")");
      
      //00レコードのみ
      if ("SINGLE".equals(deleteMode)) {
    	  sb.append(" AND(");
    	  sb.append(" SERVICE_CODE_KIND = '00'");
    	  sb.append(")");
      //00レコード以外
      } else if ("MULTI".equals(deleteMode)) {
    	  sb.append(" AND(");
    	  sb.append(" SERVICE_CODE_KIND <> '00'");
    	  sb.append(")");
      }
      //上記以外の場合は全て削除

      return sb.toString();
    }
    
    
    /**
     * 「利用者向け請求書データが存在しているかチェックします。」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_GET_CLAIM_PATIENT_TARGET_DATA_KIND(VRMap sqlParam) throws Exception{
      StringBuilder sb = new StringBuilder();

      sb.append("SELECT");

      sb.append(" SERVICE_CODE_KIND");

      sb.append(" FROM");

      sb.append(" CLAIM_PATIENT_DETAIL");

      sb.append(" WHERE");

      sb.append("(");

      sb.append(" CLAIM_ID");

      sb.append(" =");

      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

      sb.append(")");

      return sb.toString();
    }
    
    /**
     * 「CLAIM_ID取得」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_GET_CLAIM_ID(VRMap sqlParam) throws Exception{
      StringBuilder sb = new StringBuilder();
      
      sb.append("SELECT");
      sb.append(" CLAIM.CLAIM_ID");
      sb.append(" FROM");
      sb.append(" CLAIM");
      sb.append(" WHERE ");
      
      sb.append(" (CLAIM.TARGET_DATE >= ");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("TARGET_DATE_START", sqlParam)));
      sb.append(")");
      
      sb.append(" AND(CLAIM.TARGET_DATE <= ");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("TARGET_DATE_END", sqlParam)));
      sb.append(")");
      
      sb.append(" AND(CLAIM.PATIENT_ID = ");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));
      sb.append(")");
      
      sb.append(" AND(CLAIM.PROVIDER_ID = ");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));
      sb.append(")");
      
      sb.append(" AND CLAIM.CATEGORY_NO = 16");

      return sb.toString();
    }
    
    /**
     * 「CLAIMデータ削除」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_DELETE_CLAIM(VRMap sqlParam) throws Exception{
      StringBuilder sb = new StringBuilder();
      
      sb.append("DELETE");
      sb.append(" FROM");
      sb.append(" CLAIM");
      sb.append(" WHERE ");
      
      sb.append(" (CLAIM.CLAIM_ID = ");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));
      sb.append(")");

      return sb.toString();
    }
    //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
    
    //[CCCX:03616][Shinobu Hitaka] 2016.12.03 add begin 負担割合表示
    /**
     * 「給付率を取得する」ためのSQLを返します。利用者向け請求一覧（AFFAIR：07）の場合のみ使用する。
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_MAX_KYUFURITSU(VRMap sqlParam) throws Exception {
        String affair = ACCastUtilities.toString(VRBindPathParser.get("AFFAIR", sqlParam));
        StringBuilder sb = new StringBuilder();
        Date seikyuDate = null;
        if (VRBindPathParser.has("SEIKYU_DATE", sqlParam)) {
            seikyuDate = ACCastUtilities.toDate(VRBindPathParser.get(
                    "SEIKYU_DATE", sqlParam));
        } else {
            return sb.toString();
        }
        
        Date fiscalDate = null;
        fiscalDate = ACDateUtilities.addMonth(seikyuDate, -3);

        // 給付率（保険給付、公費１、公費２、公費３のうち最大値）
        sb.append(" SELECT");
        sb.append(" CLAIM.PATIENT_ID || '-' || CLAIM.INSURED_ID || '--' || CLAIM.TARGET_DATE AS CODE,");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" MAX(CAST(CLAIM_TEMP.DETAIL_VALUE AS INTEGER)) AS KYUFURITSU");
        sb.append(" FROM");
        sb.append(" CLAIM,");
        sb.append(" CLAIM_DETAIL_TEXT_" + VRDateParser.format(fiscalDate, "yyyy") + " CLAIM_TEMP");
        sb.append(" WHERE");
        sb.append(" (CLAIM.CATEGORY_NO = 2)");
        sb.append(" AND(CLAIM.CLAIM_DATE = '" + VRDateParser.format(seikyuDate, "yyyy/MM/dd") + "')");
        sb.append(" AND(CLAIM.CLAIM_ID = CLAIM_TEMP.CLAIM_ID)");
        sb.append(" AND(CLAIM_TEMP.SYSTEM_BIND_PATH IN ('201029','201030','201031','201032'))");
        sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        sb.append(" GROUP BY");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM.TARGET_DATE");
        
        return sb.toString();
    }
    //[CCCX:03616][Shinobu Hitaka] 2016.12.03 add end

}
