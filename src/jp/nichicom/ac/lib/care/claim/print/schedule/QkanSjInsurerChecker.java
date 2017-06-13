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
package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.util.VRMap;

/**
 * 総合事業の保険者番号をチェックするためのクラス
 * 
 * @since V7.3.0
 * @author Yoichiro.Kamei
 */
public class QkanSjInsurerChecker {
    
    private ACDBManager dbm;
    private CareServiceCodeCalcurater calcurater;
    private Date targetDate;
    private boolean isTukitotyuJushotiTokurei = false; //月途中住所地特例かどうか

    /**
     * コンストラクタ。
     * 
     * @param calcurater  生成、初期化済みのCareServiceCodeCalcurater
     * @throws Exception
     */
    public QkanSjInsurerChecker(CareServiceCodeCalcurater calcurater) throws Exception {
        this.calcurater = calcurater;
        this.dbm = calcurater.getDBManager();
        this.targetDate = calcurater.getTargetDate();
        
        // 月途中住所地特例かどうか
        // 月途中住所地特例⇒月初と月末の住所地特例の施設所在保険者番号が異なる
        String firstId = calcurater.getJushotiTokureiInsurerId(ACDateUtilities.toFirstDayOfMonth(targetDate));
        String lastId = calcurater.getJushotiTokureiInsurerId(ACDateUtilities.toLastDayOfMonth(targetDate));
        if (!"".equals(firstId) || !"".equals(lastId)) {
            if (!firstId.equals(lastId)) {
                this.isTukitotyuJushotiTokurei = true;
            }
        }
    }
 
    /**
     * 渡されたサービスに含まれるコードが算定可能な総合事業の保険者番号であるかチェックします。
     * 算定出来ない保険者番号がコードに設定されていた場合は、QkanSjInsurerExceptionをスローします。
     * 
     * @param service
     * @throws QkanSjInsurerException 算定出来ない保険者番号がコードに設定されていた場合
     */
    public void checkCodes(VRMap service) throws Exception {
        checkServiceCodeList(calcurater.getServiceCodes(service), service);
    }
    
    /**
     * 渡されたサービスコードのリストが算定可能な総合事業の保険者番号であるかチェックします。
     * 算定出来ない保険者番号がコードに設定されていた場合は、QkanSjInsurerExceptionをスローします。
     * 
     * @param serviceCodeList
     * @param service
     * @throws QkanSjInsurerException 算定出来ない保険者番号がコードに設定されていた場合
     */
    public void checkServiceCodeList(List serviceCodeList, VRMap service) throws Exception {
        Date serviceDate = ACCastUtilities.toDate(service.get("SERVICE_DATE"), null);
        if (serviceDate == null) {
            return;
        }
        Iterator it = serviceCodeList.iterator();
        while (it.hasNext()) {
            Map code = (Map) it.next();
            getSjInsurerIdByCode(serviceDate, code);
        }
    }
    
    /**
     * 渡されたサービスコードが算定可能な総合事業の保険者番号を取得します。
     * 算定出来ない保険者番号がコードに設定されていた場合は、QkanSjInsurerExceptionをスローします。
     * 
     * @param targetServiceDate サービス提供日
     * @param code サービスコード
     * @return 渡されたサービスコードが算定可能な総合事業の保険者番号
     * @throws QkanSjInsurerException 算定出来ない保険者番号がコードに設定されていた場合
     */
    public String getSjInsurerIdByCode(Date targetServiceDate, Map code) throws Exception {
        //コードに保険者番号が設定されていない場合、（総合事業の独自・独自定率・独自定額ではない）
        String insurerId = ACCastUtilities.toString(code.get("INSURER_ID"), "");
        if ("".equals(insurerId)) {
            return "";
        }
        // 対象日に算定可能な総合事業の保険者番号を取得
        String sjInsureId = getSjInsurerIdAtDate(targetServiceDate);;
        
        // 月途中住所地特例の場合
        if (isTukitotyuJushotiTokurei) {
            //月額サービス、月額加算、地域系%加算の場合
            if (ACCastUtilities.toInt(code.get("TOTAL_GROUPING_TYPE"), 0) == 3 //1月につき
                || isPercentageCode(code)) {
                // 月末時点の状況における保険者番号を返す
                sjInsureId = getSjInsurerIdAtDate(ACDateUtilities.toLastDayOfMonth(targetServiceDate));
            }
        }
        // チェックして返す
        return checkAndConvSjInsurerId(sjInsureId, code);
    }
    
    // サービスコードに設定された総合事業の保険者番号をチェックして適切なものに置き換え
    private String checkAndConvSjInsurerId(String sjInsureId, Map code) throws Exception {
        // コードに設定された保険者番号と取得した保険者番号が同じ場合
        String insureId = ACCastUtilities.toString(code.get("INSURER_ID"), "");
        if (sjInsureId.equals(insureId)) {
            // コードの保険者番号を返す。
            return insureId;
        }
        
        String systemServiceKindDetail = ACCastUtilities.toString(code.get("SYSTEM_SERVICE_KIND_DETAIL"));
        // 独自の場合は、算定可能な保険者番号に置き換える
        if (QkanSjServiceCodeManager.dokujiCodes.contains(systemServiceKindDetail)) {
            // ％加算でなければ
            if (!isPercentageCode(code)) {
                // コード検索して単位数を差し替え
                String itemCode = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));
                String sjCodekey = QkanSjServiceCodeManager.createSjServiceCodeKey(sjInsureId, systemServiceKindDetail, itemCode);
                VRMap row = QkanSjServiceCodeManager.getSjServiceCodeByKey(this.dbm , sjCodekey, targetDate);
                if (!row.isEmpty()) {
                    int unit = ACCastUtilities.toInt(row.get("SERVICE_UNIT"), 0);
                    if (unit != 0) {
                        code.put("SERVICE_UNIT", unit);
                    }
                } else {
                    // 置き換え先のコードが登録されていない場合
                    // 算定出来ないのでExceptionをスロー
                    throw new QkanSjInsurerException(sjInsureId, code, isTukitotyuJushotiTokurei);
                }
            }
            // コード中の保険者番号を置き換え
            code.put("INSURER_ID", sjInsureId);
            //置き換えた保険者番号を返す
            return sjInsureId;
        }
        
        // 算定出来ないのでExceptionをスロー
        throw new QkanSjInsurerException(sjInsureId, code, isTukitotyuJushotiTokurei);
    }
    
    
    // 対象日における総合事業の保険者番号を取得
    private String getSjInsurerIdAtDate(Date targetServiceDate) throws Exception {
        // 利用者の対象日の要介護認定履歴から保険者を取得する。
        VRMap map = calcurater.getPatientInsureInfoOnTargetDay(targetServiceDate);
        if (map == null) {
            return "";
        }
        String insurerId = ACCastUtilities.toString(map.get("INSURER_ID"));
        // 対象日時点で住所地特例の場合は、施設所在保険者番号を返す。
        String jushotiTokureiInsurerId = calcurater.getJushotiTokureiInsurerId(targetServiceDate);
        if (!ACTextUtilities.isNullText(jushotiTokureiInsurerId)) {
            insurerId = jushotiTokureiInsurerId;
        }
        return insurerId;
    }
    
    // 指定されたコードが％加算であるかどうかを返す
    private boolean isPercentageCode(Map code) {
        if (ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0) == 3 //％加算(地域系加算)
            || ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0) == 6 //％加算(対象に地域系加算を含む)
            || ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0) == 8) { //処遇改善加算
            return true;
        }
        return false;
    }

}
