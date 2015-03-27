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
 * 開発者: 藤原　伸
 * 作成日: 2006/01/24  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 様式抽象クラス (QP001StyleAbstract)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

public abstract class QP001StyleAbstract {

    /**
     * 様式第二　交換識別番号
     */
    protected static final String IDENTIFICATION_NO_2_201204 = "7131";
    /**
     * 様式第二の二　交換識別番号
     */
    protected static final String IDENTIFICATION_NO_2_2_201204 = "7132";
    /**
     * 様式第三 交換識別番号
     */
    protected static final String IDENTIFICATION_NO_3_201204 = "7143";
    /**
     * 様式第三の二　交換識別番号
     */
    protected static final String IDENTIFICATION_NO_3_2_201204 = "7144";
    /**
     * 様式第四 交換識別番号
     */
    protected static final String IDENTIFICATION_NO_4_201204 = "7155";
    /**
     * 様式第四の二 交換識別番号
     */
    protected static final String IDENTIFICATION_NO_4_2_201204 = "7156";
    /**
     * 様式第五 交換識別番号
     */
    protected static final String IDENTIFICATION_NO_5_201204 = "7164";
    /**
     * 様式第五の二 交換識別番号
     */
    protected static final String IDENTIFICATION_NO_5_2_201204 = "7165";
    /**
     * 様式第六　交換識別番号
     */
    protected static final String IDENTIFICATION_NO_6_201204 = "7171";
    /**
     * 様式第六の二　交換識別番号
     */
    protected static final String IDENTIFICATION_NO_6_2_201204 = "7172";
    /**
     * 様式第六の三　交換識別番号
     */
    protected static final String IDENTIFICATION_NO_6_3_201204 = "7173";
    /**
     * 様式第六の四　交換識別番号
     */
    protected static final String IDENTIFICATION_NO_6_4_201204 = "7174";
    /**
     * 様式第六の五　交換識別番号
     */
    protected static final String IDENTIFICATION_NO_6_5_201204 = "7175";
    /**
     * 様式第六の六　交換識別番号
     */
    protected static final String IDENTIFICATION_NO_6_6_201204 = "7176";
    /**
     * 様式第六の七　交換識別番号
     */
    protected static final String IDENTIFICATION_NO_6_7_201204 = "7177";
    /**
     * 様式第七　交換識別番号
     */
    protected static final String IDENTIFICATION_NO_7_201204 = "8124";
    /**
     * 様式第七の二　交換識別番号
     */
    protected static final String IDENTIFICATION_NO_7_2_201204 = "8125";
    /**
     * 様式第八 交換識別番号
     */
    protected static final String IDENTIFICATION_NO_8_201204 = "7183";
    /**
     * 様式第九 交換識別番号
     */
    protected static final String IDENTIFICATION_NO_9_201204 = "7195";
    /**
     * 様式第十 交換識別番号
     */
    protected static final String IDENTIFICATION_NO_10_201204 = "71A3";

    /**
     * 集計した情報の確定処理を行う。
     * 
     * @param patientState
     * @param styles
     * @throws Exception
     */
    abstract public void commitRecords(QP001PatientState patientState,
            VRMap styles, VRMap planUnitMap) throws Exception;

    /**
     * 集計した情報をDB登録用のListに変換する。
     * 
     * @param patient_id
     * @param targetDate
     * @return
     * @throws Exception
     */
    abstract public VRList getRecords(int patient_id, Date targetDate)
            throws Exception;

    /**
     * 様式番号から交換識別番号を取得する。
     * 
     * @param claimStyleFormat
     *            様式番号
     * @param targetDate
     *            対象年月
     * @return
     */
    protected static String getIdentificationNo(int claimStyleFormat,
            Date targetDate) {
        // int term = QP001Util.getTerm(targetDate);

        String result = "";
        switch (claimStyleFormat) {
        case QkanConstants.CLAIM_STYLE_FORMAT_2:
            result = IDENTIFICATION_NO_2_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_2_2:
            result = IDENTIFICATION_NO_2_2_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_3:
            result = IDENTIFICATION_NO_3_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_3_2:
            result = IDENTIFICATION_NO_3_2_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_4:
            result = IDENTIFICATION_NO_4_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_4_2:
            result = IDENTIFICATION_NO_4_2_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_5:
            result = IDENTIFICATION_NO_5_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_5_2:
            result = IDENTIFICATION_NO_5_2_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_6:
            result = IDENTIFICATION_NO_6_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_6_2:
            result = IDENTIFICATION_NO_6_2_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_6_3:
            result = IDENTIFICATION_NO_6_3_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_6_4:
            result = IDENTIFICATION_NO_6_4_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_6_5:
            result = IDENTIFICATION_NO_6_5_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_6_6:
            result = IDENTIFICATION_NO_6_6_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_6_7:
            result = IDENTIFICATION_NO_6_7_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_7:
            result = IDENTIFICATION_NO_7_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_7_2:
            result = IDENTIFICATION_NO_7_2_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_8:
            result = IDENTIFICATION_NO_8_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_9:
            result = IDENTIFICATION_NO_9_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_10:
            result = IDENTIFICATION_NO_10_201204;
            break;

        }
        return result;
    }
    
    
    //[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
    public void commitTreatmentImprovement(VRMap detailMap, QP001PatientState patientState, VRMap styles,VRMap planUnitMap) throws Exception {
        
        Map<String, Integer> serviceUnits = new HashMap<String, Integer>();
        Map<String, QP001RecordDetail> detailAdd = new HashMap<String, QP001RecordDetail>();
        
        QP001RecordDetail detail = null;
        Iterator it = detailMap.keySet().iterator();
        while(it.hasNext()) {
            Object key = it.next();
            detail = (QP001RecordDetail)detailMap.get(key);
            
            //ここで利用者負担額を求めるための単位数積み上げを行っておく
            //限度額管理対象フラグが1(限度額管理対象)、または3(外部利用型)の場合
            if (detail.get_301020().equals("1") || detail.get_301020().equals("3")) {
                int unit = 0;
                if (serviceUnits.containsKey(detail.get_301021())) {
                    unit = serviceUnits.get(detail.get_301021());
                }
                unit += detail.get_301014();
                serviceUnits.put(detail.get_301021(), unit);
            }
            
            switch (detail.getServiceAddFlag()) {
            case 3: //特地加算
                detailAdd.put(detail.get_301021() + "_3", detail);
                break;
            case 6: //中山間
                detailAdd.put(detail.get_301021() + "_6", detail);
                break;
            case 8: //処遇改善
                //処遇改善レコードなら、別のレコードの値を合算
                calcTreatmentImprovement(detailMap, detail);
                definitionTreatmentImprovement(detail);
                detailAdd.put(detail.get_301021() + "_8", detail);
                break;
            }
        }
        
        // 自己負担調整
        adjustSelfpay(serviceUnits, detailAdd, styles, planUnitMap, patientState);
        
        // 0単位請求のレコードを削除する
        removeEmptyDetail(detailMap);
    }
    
    
    public Map<String, QP001RecordDiagnosis> commitTreatmentImprovement(
            VRMap detailMap, Map<String, QP001RecordDiagnosis> diagnosisMap, 
            QP001PatientState patientState, String[] kohiTypes,
            VRMap styles,VRMap planUnitMap) throws Exception {
        
        Map<String, QP001RecordDiagnosis> diagnosisResult = new TreeMap<String, QP001RecordDiagnosis>();
        Set<String> detailKohiSet = new HashSet<String>();
        
        Map<String, Integer> serviceUnits = new HashMap<String, Integer>();
        Map<String, QP001RecordDetail> detailAdd = new HashMap<String, QP001RecordDetail>();
        
        QP001RecordDetail detail = null;
        Iterator it = detailMap.keySet().iterator();
        while(it.hasNext()) {
            Object key = it.next();
            detail = (QP001RecordDetail)detailMap.get(key);
            
            //明細レコードで使用した公費を退避しておく
            Iterator itKohi = detail.getKohiList().keySet().iterator();
            while(itKohi.hasNext()) {
                Object kohiKey = itKohi.next();
                Map kohiData = (Map)detail.getKohiList().get(kohiKey);
                detailKohiSet.add(ACCastUtilities.toString(kohiData.get("KOHI_TYPE")));
            }
            
            
            //ここで利用者負担額を求めるための単位数積み上げを行っておく
            //限度額管理対象フラグが1(限度額管理対象)の場合
            if (detail.get_301020().equals("1")) {
                int unit = 0;
                if (serviceUnits.containsKey(detail.get_301021())) {
                    unit = serviceUnits.get(detail.get_301021());
                }
                unit += detail.get_301014();
                serviceUnits.put(detail.get_301021(), unit);
            }
            
            switch (detail.getServiceAddFlag()) {
            case 3: //特地加算
                detailAdd.put(detail.get_301021() + "_3", detail);
                break;
            case 6: //中山間
                detailAdd.put(detail.get_301021() + "_6", detail);
                break;
            case 8: //処遇改善
                //処遇改善レコードなら、別のレコードの値を合算
                calcTreatmentImprovement(detailMap, detail);
                detailAdd.put(detail.get_301021() + "_8", detail);
                break;
            }

        }
        
        QP001RecordDiagnosis diagnosis = null; 
        it = diagnosisMap.keySet().iterator();
        
        while (it.hasNext()) {
            diagnosis = diagnosisMap.get(it.next());
            // 作成した特定診療費情報レコードの確定処理を行う。
            diagnosis.commitRecord(kohiTypes, patientState);
            
            // システム内サービス種類コードをキーに処遇改善レコードを検索
            // 処遇改善レコードが存在すれば、値を設定
            if (detailAdd.containsKey(diagnosis.get_501027() + "_8")) {
                
                detail = detailAdd.get(diagnosis.get_501027() + "_8");
                
                //(保険)合計単位数8桁を加える
                detail.set_301014(detail.get_301014() + diagnosis.get_501012());
                
                //明細レコードで適用可能な公費であるか確認しながら単位数を加算
                //公費の比較を撤廃し、特別診療費にかかった公費も処遇改善で請求する
                //(公費1)合計単位数8桁を加える
                detail.set_301015(detail.get_301015() + diagnosis.get_501015());
                //(公費2)合計単位数8桁を加える
                detail.set_301016(detail.get_301016() + diagnosis.get_501018());
                //(公費3)合計単位数8桁を加える
                detail.set_301017(detail.get_301017() + diagnosis.get_501021());
                
                /*
                //公費1の種類を比較
                if (detailKohiSet.contains(detail.get_301023())) {
                    //(公費1)合計単位数8桁を加える
                    detail.set_301015(detail.get_301015() + diagnosis.get_501015());
                }
                
                //公費2の種類を比較
                if (detailKohiSet.contains(detail.get_301024())) {
                    //(公費2)合計単位数8桁を加える
                    detail.set_301016(detail.get_301016() + diagnosis.get_501018());
                }
                
                //公費3の種類を比較
                if (detailKohiSet.contains(detail.get_301025())) {
                    //(公費3)合計単位数8桁を加える
                    detail.set_301017(detail.get_301017() + diagnosis.get_501021());
                }
                */
            }
            
            
            // 識別番号をキーに、Mapを再構成
            if (diagnosisResult.containsKey(diagnosis.get_501009())) {
                // マージ
                diagnosisResult.get(diagnosis.get_501009()).merge(diagnosis);
                
            } else {
                // mapへ設定
                diagnosisResult.put(diagnosis.get_501009(), diagnosis);
            }
        }

        
        
        //システムサービス種類ごとの特定診療費を加味した処遇改善の計算結果を確定
        it = detailAdd.keySet().iterator();
        while (it.hasNext()) {
            String systemServiceKind = (String)it.next();
            //処遇改善加算の場合
            if (systemServiceKind.endsWith("_8")) {
                detail = detailAdd.get(systemServiceKind);
                // 計算結果を確定
                definitionTreatmentImprovement(detail);
            }
        }
        
        // 自己負担調整
        adjustSelfpay(serviceUnits, detailAdd, styles, planUnitMap, patientState);
        
        // 0単位請求のレコードを削除する
        removeEmptyDetail(detailMap);
        
        // 特定診療費情報レコードの確定処理
        it = diagnosisResult.keySet().iterator();
        int recordCount = 1;
        while (it.hasNext()) {
            diagnosis = diagnosisResult.get(it.next());
            // 作成した特定診療費情報レコードの確定処理を行う。
            diagnosis.commitRecord(kohiTypes, recordCount, patientState);
            recordCount++;
        }
        if (diagnosis != null) {
            // 集計を行う。
            diagnosis.commitRecord(diagnosisResult, patientState);
        }
        
        return diagnosisResult;
    }
    
    
    
    private void calcTreatmentImprovement(VRMap detailMap, QP001RecordDetail target) {
        
        QP001RecordDetail detail = null;
        int _301014 = 0; //サービス単位数6桁
        int _301015 = 0; //公費1対象サービス単位数6桁
        int _301016 = 0; //公費2対象サービス単位数6桁
        int _301017 = 0; //公費3対象サービス単位数6桁
        
        Iterator it = detailMap.keySet().iterator();
        while(it.hasNext()) {
            detail = (QP001RecordDetail)detailMap.get(it.next());
            
            //システム内サービス種類コードが異なれば処理しない
            if (!detail.get_301021().equals(target.get_301021())) {
                continue;
            }
            
            //処遇改善レコード自身であれば処理しない
            if (detail.isSyoguRecoed()) {
                continue;
            }
            
            //各単位数の合算を取得
            _301014 += detail.get_301014();
            _301015 += detail.get_301015();
            _301016 += detail.get_301016();
            _301017 += detail.get_301017();
        }
        
        //処遇改善レコードに合算値を設定
        target.set_301014(_301014);
        target.set_301015(_301015);
        target.set_301016(_301016);
        target.set_301017(_301017);
    }
    
    private void definitionTreatmentImprovement(QP001RecordDetail target) throws Exception {
        
        //[ID:0000730][Shin Fujihara] add begin  【サービス利用票別表・実績集計】自己負担発生時の％系加算の計算について
        //処遇改善加算の根拠単位数を退避
        target.setAdditionBasisUnit(target.get_301014());
        //[ID:0000730][Shin Fujihara] add end
        
        //サービス単位数6桁
        target.set_301014(CareServiceCommon.calcSyogu(target.get_301014(), target.getServiceUnit(), target.getServiceStaffUnit()));
        //単位数に転記
        target.set_301009(target.get_301014());
        
        //公費1対象サービス単位数6桁
        target.set_301015(CareServiceCommon.calcSyogu(target.get_301015(), target.getServiceUnit(), target.getServiceStaffUnit()));
        
        //公費2対象サービス単位数6桁
        target.set_301016(CareServiceCommon.calcSyogu(target.get_301016(), target.getServiceUnit(), target.getServiceStaffUnit()));
        
        //公費3対象サービス単位数6桁
        target.set_301017(CareServiceCommon.calcSyogu(target.get_301017(), target.getServiceUnit(), target.getServiceStaffUnit()));
        
        //[CCCX:1470][Shinobu Hitaka] 2014/02/10 add - start 老健の一部公費対象の対応
        //公費1～3に老健の一部公費が含まれている場合
        //合計単位数＜公費1＋2＋3　の場合最後の公費で単位数を調整する
        Iterator itKohi = target.getKohiList().keySet().iterator();
        String[] kohiTypes = new String[3];
        int count = 0;
        while(itKohi.hasNext()) {
            Object kohiKey = itKohi.next();
            Map kohiData = (Map)target.getKohiList().get(kohiKey);
            kohiTypes[count] = ACCastUtilities.toString(kohiData.get("KOHI_TYPE"));
            count++;
            if (count > kohiTypes.length - 1)
                break;
        }
        String systemServiceKindDetail = ACCastUtilities.toString(target.get_301021());
        if (CareServiceCommon.isKouhiSystemService(systemServiceKindDetail, kohiTypes[0]) ||
            CareServiceCommon.isKouhiSystemService(systemServiceKindDetail, kohiTypes[1]) ||
            CareServiceCommon.isKouhiSystemService(systemServiceKindDetail, kohiTypes[2])
            ) {
            
            //公費1＝10感染症が適用されている場合、感染症公費以外の単位数を調整する
            if ("1001".equals(target.get_301023()) && target.get_301015() > 0) {
                if (target.get_301017() != 0) {
                    target.set_301017(target.get_301014() - target.get_301016());
                }
            } else {
                if (target.get_301014() < (target.get_301015() + target.get_301016() + target.get_301017())) {
                    if (target.get_301017() != 0) {
                        target.set_301017(target.get_301014() - (target.get_301015() + target.get_301016()));
                    } else if (target.get_301016() != 0) {
                        target.set_301016(target.get_301014() - target.get_301015());
                    } else if (target.get_301015() != 0) {
                        target.set_301015(target.get_301014());
                    }
                }
            }
        }
        //[CCCX:1470][Shinobu Hitaka] 2014/02/10 add - end   老健の一部公費対象の対応
        
        // 公費1回数
        if (0 < target.get_301015()) {
            target.set_301011(1);
        }
        // 公費2回数
        if (0 < target.get_301016()) {
            target.set_301012(1);
        }
        // 公費3回数
        if (0 < target.get_301017()) {
            target.set_301013(1);
        }
        
    }
    
    
    private void adjustSelfpay(Map<String, Integer> serviceUnits, Map<String, QP001RecordDetail> detailAdd, VRMap styles,
            VRMap planUnitMap, QP001PatientState patientState) throws Exception {
        
        QP001RecordDetail detail = null;
        
        Iterator<String> unitIt = serviceUnits.keySet().iterator();
        while(unitIt.hasNext()) {
            String systemServiceKind = unitIt.next();
            
            int serviceUnit = serviceUnits.get(systemServiceKind);
            
            int stackedSelfUnit = 0;
            int selfPay = Integer.MIN_VALUE;
            
            //以下の順番で計算していく
            
            //特地加算を算定している場合
            if (detailAdd.containsKey(systemServiceKind + "_3")) {
                detail = detailAdd.get(systemServiceKind + "_3");
                
                selfPay = getSelfpay(styles, patientState, planUnitMap, detail, serviceUnit, selfPay);
                //自己負担が発生していない場合は処理終了
                if (selfPay == 0) {
                    continue;
                }
                
                int unit = getSelfpayUnit(detail, selfPay, stackedSelfUnit, serviceUnit);
                stackedSelfUnit += unit;
                
                //自己負担分を引く
                removeSelfPay(detail, unit);
                
                //引いた分を全額自己負担へ
                patientState.putAddSelfpay(detail.get_301007(), unit);
            }
            
            
            //中山間加算を算定している場合
            if (detailAdd.containsKey(systemServiceKind + "_6")) {
                detail = detailAdd.get(systemServiceKind + "_6");
                
                selfPay = getSelfpay(styles, patientState, planUnitMap, detail, serviceUnit, selfPay);
                //自己負担が発生していない場合は処理終了
                if (selfPay == 0) {
                    continue;
                }
                
                int unit = getSelfpayUnit(detail, selfPay, stackedSelfUnit, serviceUnit);
                stackedSelfUnit += unit;
                
                //自己負担分を引く
                removeSelfPay(detail, unit);
                
                //引いた分を全額自己負担へ
                patientState.putAddSelfpay(detail.get_301007(), unit);
            }
            
            //処遇改善加算を算定している場合
            if (detailAdd.containsKey(systemServiceKind + "_8")) {
                detail = detailAdd.get(systemServiceKind + "_8");
                
                selfPay = getSelfpay(styles, patientState, planUnitMap, detail, serviceUnit, selfPay);
                //自己負担が発生していない場合は処理終了
                if (selfPay == 0) {
                    continue;
                }
                
                int unit = getSelfpayUnit(detail, selfPay, stackedSelfUnit, serviceUnit);
                stackedSelfUnit += unit;
                
                //自己負担分を引く
                removeSelfPay(detail, unit);
                
                //引いた分を全額自己負担へ
                patientState.putAddSelfpay(detail.get_301007(), unit);
            }
            
        }
    }
    
    private void removeSelfPay(QP001RecordDetail detail, int unit) throws Exception {
        //サービス単位数を引く
        detail.set_301014(detail.get_301014() - unit);
        //単位数に転記
        detail.set_301009(detail.get_301014());
        
        //公費1対象サービス単位数6桁
        if (detail.get_301009() < detail.get_301015()) {
            detail.set_301015(detail.get_301009());
        }
        //公費2対象サービス単位数6桁
        if (detail.get_301009() < detail.get_301016()) {
            detail.set_301016(detail.get_301009());
        }
        //公費3対象サービス単位数6桁
        if (detail.get_301009() < detail.get_301017()) {
            detail.set_301017(detail.get_301009());
        }
    }
    
    
    private int getSelfpayUnit(QP001RecordDetail detail,int selfPay, int stackedSelfUnit, int serviceUnit) throws Exception {
        
        //[ID:0000730][Shin Fujihara] edit begin  【サービス利用票別表・実績集計】自己負担発生時の％系加算の計算について
        /*
        //自己負担分の単位数
        int unit = 0;
        
        if (detail.isSyoguRecoed()) {
            unit = CareServiceCommon.calcSyogu((selfPay + stackedSelfUnit), detail.getServiceUnit(), detail.getServiceStaffUnit());
        } else {
            unit = (int) Math.round((double) ((selfPay + stackedSelfUnit) * detail.getServiceUnit()) / 100d);
        }
        */
        
        //正しい加算の単位数
        int unit = 0;
        
        if (detail.isSyoguRecoed()) {
            unit = CareServiceCommon.calcSyogu(detail.getAdditionBasisUnit() - selfPay - stackedSelfUnit, detail.getServiceUnit(), detail.getServiceStaffUnit());
        } else {
            unit = (int) Math.round((double) ( (detail.getAdditionBasisUnit() - selfPay - stackedSelfUnit) * detail.getServiceUnit()) / 100d);
        }
        
        return detail.get_301014() - unit;
        //[ID:0000730][Shin Fujihara] edit end
    }
    
    
    /**
     * 自己負担の単位数を取得する
     * @return
     * @throws Exception
     */
    private int getSelfpay(VRMap styles, QP001PatientState patientState, VRMap planUnitMap, QP001RecordDetail detail, int serviceUnit, int selfPay) throws Exception {
        
        if (selfPay != Integer.MIN_VALUE) {
            return selfPay;
        }
        
        int planUnit = 0;
        
        //[様式第六の三]：特定施設入居者生活介護(短期利用以外)、地域密着型特定施設入居者生活介護(短期利用以外)
        //[様式第六の四]：介護予防特定施設入居者生活介護
        if ("13311".equals(detail.get_301021())
            || "13511".equals(detail.get_301021())
            || "13611".equals(detail.get_301021())) {
            planUnit = ACCastUtilities.toInt(patientState.getNinteiDataHeavy(detail.get_301005(),detail.get_301006(),"EXTERNAL_USE_LIMIT"),0);
            
            //自己負担が発生していない場合は処理終了
            if (serviceUnit <= planUnit) {
                return 0;
            } else {
                 return (serviceUnit - planUnit);
            }
        }
        
        
        //実績登録画面で入力された計画単位数を参照する。
        if(planUnitMap != null){
            String key = "10" + detail.get_301007();
            // 10 + サービス種類コードのキーが存在するか確認
            if(planUnitMap.containsKey(key)){
                planUnit = ACCastUtilities.toInt(planUnitMap.get(key),0);
                
                if(planUnit != 0){
                    //自己負担が発生していない場合は処理終了
                    if (serviceUnit <= planUnit) {
                        return 0;
                    } else {
                        return (serviceUnit - planUnit);
                    }
                }
            }
        }
        
        //実績登録画面で計画単位数の入力が無い場合、予定のデータを見に行く
        
        if(styles == null) return planUnit;
        
        Iterator it = styles.keySet().iterator();
        while(it.hasNext()){
            QP001StyleAbstract style = (QP001StyleAbstract)styles.get(it.next());
            if(style instanceof QP001Style11){
                QP001Style11 target = (QP001Style11)style;
                
                Map supplyMap = (Map)target.getSupplyMap();
                
                Iterator supplyIt = supplyMap.keySet().iterator();
                while(supplyIt.hasNext()){
                    QP001RecordSupply supply = (QP001RecordSupply)supplyMap.get(supplyIt.next());
                  //事業所番号と保険者番号,被保険者番号とサービス種類コードが等しいものを探す
                  if(String.valueOf(supply.get_1201017()).equals(detail.get_301004())
                          && (String.valueOf(supply.get_1201003()).equals(detail.get_301005()))
                          && (String.valueOf(supply.get_1201009()).equals(detail.get_301006()))
                          && (String.valueOf(supply.get_1201019()).equals(detail.get_301007()))){
                      planUnit = supply.get_1201020();
                      break;
                  }
                }
            }
        }
        
        //計画単位数が取得できなかった場合は、自己負担発生無し
        if (planUnit == 0) {
            return 0;
        }
        
        //実績と比較し、自己負担が発生していない場合は処理終了
        if (serviceUnit <= planUnit) {
            return 0;
        }
        
        return (serviceUnit - planUnit);
        
    }
    
    // 単位数が設定されている、請求に有効なレコードであるか判定する
    // [ID:0000715]対応
    private void removeEmptyDetail(VRMap detailMap) throws Exception {
        
        List<Object> removeTarget = new ArrayList<Object>();
        
        QP001RecordDetail detail = null;
        Iterator it = detailMap.keySet().iterator();
        while(it.hasNext()) {
            Object key = it.next();
            detail = (QP001RecordDetail)detailMap.get(key);
            
            switch (detail.getServiceAddFlag()) {
            case 3: //特地加算
            case 6: //中山間
            case 8: //処遇改善
                if (detail.get_301014() <= 0) {
                    removeTarget.add(key);
                }
                break;
            }
        }
        
        for (Object key : removeTarget) {
            detailMap.remove(key);
        }
    }
    //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
    
    //[ID:0000721][Shin Fujihara] 2012/04 add start 2012年度対応
    //看取り・ターミナル加算の摘要欄転記を考慮しながらの明細確定処理
    //様式第六、第六の三、第八、第九で使用
    public void commitDetails(VRMap detailMap, String[] kohiTypes, QP001PatientState patientState) throws Exception {
        
        Map<String, String> mitoriTekiyo = new HashMap<String, String>();
        Map<String, List<QP001RecordDetail>> copyTarget = new HashMap<String, List<QP001RecordDetail>>();
        
        //摘要欄のコピー対象サービスコード
        Set<String> copyTargetList = new HashSet<String>();
        copyTargetList.add("516276"); //福祉施設看取り介護加算１
        copyTargetList.add("516277"); //福祉施設看取り介護加算２
        copyTargetList.add("546276"); //地福祉施設看取り介護加算１
        copyTargetList.add("546277"); //地福祉施設看取り介護加算２
        copyTargetList.add("526600"); //保健施設ターミナルケア加算１１
        copyTargetList.add("526001"); //保健施設ターミナルケア加算１２
        copyTargetList.add("526602"); //保健施設ターミナルケア加算２１
        copyTargetList.add("526002"); //保健施設ターミナルケア加算２２
        copyTargetList.add("326142"); //認知症対応型看取り介護加算１
        copyTargetList.add("326143"); //認知症対応型看取り介護加算２
        copyTargetList.add("336125"); //特定施設看取り介護加算１
        copyTargetList.add("336126"); //特定施設看取り介護加算２
        copyTargetList.add("366125"); //地域特定施設看取り介護加算１
        copyTargetList.add("366126"); //地域特定施設看取り介護加算２ 
        
        QP001RecordDetail detail = null;
        // 明細情報レコードの確定処理
        Iterator it = detailMap.keySet().iterator();
        
        while (it.hasNext()) {
            // 作成した明細情報レコードの確定を行う。
            detail = (QP001RecordDetail) detailMap.get(it.next());
            detail.commitRecord(kohiTypes,patientState);
            
            
            
            //摘要欄に死亡日が設定されているサービスコードであるか確認
            if (QP001SpecialCase.isMitori(detail.get_301007(), detail.get_301008())) {
                //該当コードであれば、サービス種類コードをキーに、摘要欄の内容を退避しておく
                if (!ACTextUtilities.isNullText(detail.get_301018())){
                    mitoriTekiyo.put(detail.get_301007(), detail.get_301018());
                }
            }
            
            //転記対象のレコードであれば、退避しておく
            String serviceCode = detail.get_301007() + detail.get_301008();
            if (copyTargetList.contains(serviceCode)) {
                List<QP001RecordDetail> detailList = null;
                if (copyTarget.containsKey(detail.get_301007())) {
                    detailList = copyTarget.get(detail.get_301007());
                } else {
                    detailList = new ArrayList<QP001RecordDetail>();
                    copyTarget.put(detail.get_301007(), detailList);
                }
                detailList.add(detail);
            }
        }
        
        it = mitoriTekiyo.keySet().iterator();
        while(it.hasNext()) {
            String key = (String)it.next();
            
            if (!copyTarget.containsKey(key)) {
                continue;
            }
            
            String tekiyo = mitoriTekiyo.get(key);
            List<QP001RecordDetail> list = copyTarget.get(key);
            for (QP001RecordDetail row : list) {
                row.set_301018(tekiyo);
            }
            
        }
    }
    //[ID:0000721][Shin Fujihara] 2012/04 add end 2012年度対応

}
