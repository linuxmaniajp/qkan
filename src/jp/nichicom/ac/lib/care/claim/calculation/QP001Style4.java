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
 * プログラム 様式第四 (QP001Style4)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 様式第四 一帳票分の情報
 * 
 * @author shin fujihara
 * 
 */
public class QP001Style4 extends QP001StyleAbstract {

    /**
     * 基本情報レコード(一帳票にひとつ)
     */
    private QP001RecordBase base = new QP001RecordBase();

    /**
     * 明細情報レコード集合
     */
    private VRMap detailMap = new VRHashMap();

    /**
     * 集計情報レコード集合(一帳票にひとつ)
     */
    private QP001RecordType type = new QP001RecordType();

    /**
     * 特定入所者介護サービス情報レコード集合
     */
    private VRMap nursingMap = new VRHashMap();

    /**
     * 緊急時施設療養情報レコード
     */
    private QP001RecordEmergency emergency = new QP001RecordEmergency();
    
    /**
     * 特別療養費・特別診療費情報レコード
     */
    private Map<String, QP001RecordDiagnosis> diagnosisMap = new TreeMap<String, QP001RecordDiagnosis>();
    
 // [H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - begin
    /**
     * 基本摘要情報レコード集合
     */
    private Map<String, QP001RecordBaseSummary> baseSummaryMap = new TreeMap<String, QP001RecordBaseSummary>();
 // [H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - end
    
    /**
     * 内部様式番号
     */
    private int claimStyleFormat = 0;
    /**
     * 交換識別番号
     */
    private String identificationNo = "";
    private QP001Manager manager = null;
    
    public QP001Style4(int claimStyleFormat,QP001Manager manager){
        this.claimStyleFormat = claimStyleFormat;
        this.identificationNo = getIdentificationNo(claimStyleFormat,manager.getTargetDate());
        this.manager = manager;
    }

    public static String getSerialId(
            Date targetDate,
            VRMap serviceDetail,
            QP001PatientState patientState,
            int claimStyleFormat) throws Exception {
        StringBuilder serial = new StringBuilder();
        // 201001 交換情報識別番号4桁
        
        //[H20.4 法改正対応] fujihara edit start
        //serial.append(getIdentificationNo(claimStyleFormat));
        serial.append(getIdentificationNo(claimStyleFormat,targetDate));
        //[H20.4 法改正対応] fujihara edit end
        
        // サービス提供年月6桁(YYYYMM)
        serial.append(VRDateParser.format(targetDate, "yyyyMM"));
        // 事業所番号10桁
        serial.append(VRBindPathParser.get("PROVIDER_ID", serviceDetail));
        // 証記載保険者番号8桁
        serial.append(patientState.getInsurerId(VRBindPathParser.get(
                "SERVICE_DATE", serviceDetail)));
        // 被保険者番号10桁
        serial.append(patientState.getInsuredId(VRBindPathParser.get(
                "SERVICE_DATE", serviceDetail)));

        return serial.toString();
    }

    /**
     * データの解析を実行する。
     * 
     * @param serviceDetail
     * @param targetDate
     * @param patientState
     * @param serviceCode
     * @throws Exception
     */
    //[H20.5 法改正対応] fujihara edit start
//    public void parse(VRMap serviceDetail, Date targetDate,
//            QP001PatientState patientState, VRMap serviceCode) throws Exception {
    public void parse(VRMap serviceDetail, Date targetDate,
            QP001PatientState patientState, VRMap serviceCode,boolean firstRecord) throws Exception {
    //[H20.5 法改正対応] fujihara edit end

        Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",
                serviceDetail);
        
        /* 明細情報レコード集計処理 */
        QP001RecordDetail detail = QP001RecordDetail.getInstance(identificationNo,
                targetDate,
                targetServiceDate,
                serviceDetail,
                serviceCode,
                patientState,
                detailMap,
                manager);
        
        //レコードが作成されていれば
        if(detail != null){
            //明細情報データ解析
            detail.parse(serviceDetail,targetDate,patientState,serviceCode,identificationNo,manager);
        }

        /* 緊急時緊急時施設療養レコード */
        // 緊急時治療管理加算がある場合
        String systemServiceCode = String.valueOf(serviceCode.get("SYSTEM_SERVICE_CODE_ITEM"));
        if("Z9000".equals(systemServiceCode)
                || "Z6000".equals(systemServiceCode)){
            // 緊急時治療加算レコードを設定する。
            emergency.parse(serviceDetail, targetDate, patientState,serviceCode,
                    identificationNo,manager);
        }

        //[H20.5 法改正対応] fujihara add start
        /* 特別療養費・特別診療費情報レコード */
        QP001RecordDiagnosisMaker diagnosisMaker = new QP001RecordDiagnosisMaker(
                identificationNo, serviceDetail, targetDate,
                targetServiceDate, patientState, serviceCode, diagnosisMap,manager);
        
        if(firstRecord){
            // 特別療養費・特別診療費情報レコードの作成
        	// [H30.4改正対応][Yoichiro Kamei] 2018/3/28 mod - begin
//            diagnosisMap = diagnosisMaker.makeRecuperation();
            switch (claimStyleFormat) {
            case QkanConstants.CLAIM_STYLE_FORMAT_4:
            case QkanConstants.CLAIM_STYLE_FORMAT_4_2:
            	diagnosisMap = diagnosisMaker.makeRecuperation();
                break;
            case QkanConstants.CLAIM_STYLE_FORMAT_4_3:
            case QkanConstants.CLAIM_STYLE_FORMAT_4_4:
            	diagnosisMap = diagnosisMaker.makeTokubetuShinryo();
                break;
            }
            // [H30.4改正対応][Yoichiro Kamei] 2018/3/28 mod - end
        }
        //[H20.5 法改正対応] fujihara add end
        
        /* 特定入所者介護サービス */
        QP001RecordNursing nursing = QP001RecordNursing.getInstance(identificationNo,
                                                                targetDate,
                                                                targetServiceDate,
                                                                serviceDetail,
                                                                serviceCode,
                                                                patientState,
                                                                nursingMap,
                                                                manager);

        if(nursing != null){
            // 特定入所者レコードの解析を行う。
            nursing.parse(serviceDetail, targetDate, patientState, serviceCode,
                    identificationNo,manager);
        }

        // [H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - begin
        // 基本摘要レコード
        if (QP001RecordBaseSummaryMaker.isMakeRecord(identificationNo, serviceDetail, serviceCode)) {
        	QP001RecordBaseSummaryMaker summaryMaker = new QP001RecordBaseSummaryMaker(
        			identificationNo, serviceDetail, targetDate,
                    targetServiceDate, patientState, serviceCode, baseSummaryMap, manager);
        	baseSummaryMap = summaryMaker.make();
        }
        // [H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - end
    }

    /**
     * データの確定処理を行う。
     */
    public void commitRecords(QP001PatientState patientState,VRMap styles, VRMap planUnitMap)
            throws Exception {
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//        VRMap kohiMap;
//        TreeMap kohiRank = new TreeMap();
        QP001RecordDetail detail = null;
        QP001RecordNursing nursing = null;
        //[H20.5 法改正対応] fujihara edit start
        QP001RecordDiagnosis diagnosis = null;
        //[H20.5 法改正対応] fujihara edit end
        Iterator it;

//        // 本帳票における公費順位の確定を行う。
//        // TODO もう少し処理をすっきりさせたい。
//
//        Iterator it = detailMap.keySet().iterator();
//        while (it.hasNext()) {
//            detail = (QP001RecordDetail) detailMap.get(it.next());
//            // 作成した明細情報レコードの公費適用状況を取得する。
//            kohiMap = detail.getKohiList();
//            Iterator itKohi = kohiMap.keySet().iterator();
//            // 公費の順位を登録する。
//            while (itKohi.hasNext()) {
//                Object key = itKohi.next();
//                if (!kohiRank.containsKey(key)) {
//                    kohiRank.put(key, kohiMap.get(key));
//                }
//            }
//        }
//        it = nursingMap.keySet().iterator();
//        while (it.hasNext()) {
//            nursing = (QP001RecordNursing) nursingMap.get(it.next());
//            // 作成した特定入所者レコードの公費適用状況を取得する。
//            kohiMap = nursing.getKohiList();
//            Iterator itKohi = kohiMap.keySet().iterator();
//            // 公費の順位を登録する。
//            while (itKohi.hasNext()) {
//                Object key = itKohi.next();
//                if (!kohiRank.containsKey(key)) {
//                    kohiRank.put(key, kohiMap.get(key));
//                }
//            }
//        }
//        
//        //[H20.5 法改正対応] fujihara edit start
//        it = diagnosisMap.keySet().iterator();
//        while (it.hasNext()) {
//            diagnosis = (QP001RecordDiagnosis) diagnosisMap.get(it.next());
//            // 作成した特定診療費レコードの公費状況を取得する。
//            kohiMap = diagnosis.getKohiList();
//            Iterator itKohi = kohiMap.keySet().iterator();
//            // 公費の順位を登録する。
//            while (itKohi.hasNext()) {
//                Object key = itKohi.next();
//                if (!kohiRank.containsKey(key)) {
//                    kohiRank.put(key, kohiMap.get(key));
//                }
//            }
//        }
//        //[H20.5 法改正対応] fujihara edit end
//        
//        // 公費適用順位
//        QP001KohiKey[] kohiTypes = new QP001KohiKey[3];
//        it = kohiRank.keySet().iterator();
//        int count = 0;
//        while (it.hasNext()) {
//            VRMap temp = (VRMap) kohiRank.get(it.next());
//            kohiTypes[count] = new QP001KohiKey(temp);
//            count++;
//            if (count > kohiTypes.length - 1)
//                break;
//        }
        
        List<Map> records = new ArrayList<Map>();
        records.add(detailMap);
        records.add(nursingMap);
        records.add(diagnosisMap);
        QP001KohiKey[] kohiTypes = getKohiApplyArray(records);
// 2015/5/12 [Yoichiro Kamei] mod - end
        
        // 明細情報レコードの確定処理
        it = detailMap.keySet().iterator();
        while (it.hasNext()) {
            // 作成した明細情報レコードの確定を行う。
            ((QP001RecordDetail) detailMap.get(it.next()))
                    .commitRecord(kohiTypes,patientState);
        }
        
        // [H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - begin
        // 基本摘要レコードの確定処理
        for (QP001RecordBaseSummary summary : baseSummaryMap.values()) {
        	summary.commitRecord(patientState);
        }
        // [H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - end

        // 特定入所者レコードの確定処理
        //全額利用者請求対応
        QP001RecordNursing nursingLast = null;
        it = nursingMap.keySet().iterator();
        while (it.hasNext()) {
            nursing = (QP001RecordNursing) nursingMap.get(it.next());
            // 作成した特定入所者レコードの確定処理を行う。
            nursing.commitRecord(kohiTypes,patientState,manager);
            
            //2006.04.28 全額自己負担対応
            if((nursing.get_801017() + nursing.get_801018() + nursing.get_801019() + nursing.get_801020()) > 0){
                nursingLast = nursing;
            }
        }
        if (nursingLast != null) {
            // 集計を行う
            nursingLast.commitRecord(nursingMap);
        }
        
        //[H20.5 法改正対応] fujihara edit start
//        // 特定診療費情報レコードの確定処理
//        it = diagnosisMap.keySet().iterator();
//        int recordCount = 1;
//        while (it.hasNext()) {
//            diagnosis = (QP001RecordDiagnosis) diagnosisMap.get(it.next());
//            // 作成した特定診療費情報レコードの確定処理を行う。
//            diagnosis.commitRecord(kohiTypes, recordCount,patientState);
//            recordCount++;
//        }
//        if (diagnosis != null) {
//            // 集計を行う。
//            diagnosis.commitRecord(diagnosisMap,patientState);
//        }
        //[H20.5 法改正対応] fujihara edit end
        //[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
        diagnosisMap = commitTreatmentImprovement(detailMap, diagnosisMap, patientState, kohiTypes, styles, planUnitMap);
        //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算
        
        // 緊急時のレコードの確定処理
        emergency.commitRecord();
        
        type.parse(emergency,kohiTypes,patientState);

        it = detailMap.keySet().iterator();
        // 集計情報レコードの作成
        while (it.hasNext()) {
            detail = ((QP001RecordDetail) detailMap.get(it.next()));
            type.parse(detail,patientState,manager);
        }
        
        // 集計情報レコードの確定処理
        type.commitRecord(kohiTypes, patientState,styles,planUnitMap);
        //[H20.5 法改正対応] fujihara add start
        //自己負担額を本体請求からかけるため、type.commitRecordの後に実行してやる必用あり
// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し
//        if (diagnosis != null) {
//        	//[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009年度対応
//            //type.parse(diagnosis, kohiTypes,patientState);
//        	type.parse(diagnosis, kohiTypes,patientState, nursingLast);
//            //[ID:0000523][Shin Fujihara] 2009/07 edit end 2009年度対応
//        }
//        //[H20.5 法改正対応] fujihara add end
        it = diagnosisMap.keySet().iterator();
        // 集計情報レコードの作成
        while (it.hasNext()) {
            diagnosis = ((QP001RecordDiagnosis) diagnosisMap.get(it.next()));
            type.parse(diagnosis, kohiTypes,patientState, nursingLast);
        }
// 2015/5/12 [Yoichiro Kamei] mod - end
        
        // 基本情報レコードの確定処理
        base.parse(type, patientState,kohiTypes,manager);
        //特定入所者情報を基本情報レコードに設定
        //base.parse(nursing);
        base.parse(nursingLast,patientState,kohiTypes);
        //緊急時レコードを基本情報レコードに設定
        base.parse(emergency);
        
        //[H20.5 法改正対応] fujihara add start
        //特別療養費・特別診療費レコードの確定処理
        base.parse(diagnosis,patientState,kohiTypes);
        //[H20.5 法改正対応] fujihara add end
    }

    /**
     * DB登録用のレコード集合を作成します。
     * 
     * @param patient_id
     * @param targetDate
     * @return
     * @throws Exception
     */
    public VRList getRecords(int patient_id, Date claimDate)
            throws Exception {
        VRList list = new VRArrayList();
        VRHashMap style = new VRHashMap();
        
		//データが正常に生成されていない場合は処理を終了する。
		if(ACTextUtilities.isNullText(base.get_201003())){
			return list;
		}

        //帳票の様式番号
        style.put("CLAIM_STYLE_TYPE", ACCastUtilities.toString(claimStyleFormat));
        //利用者ＩＤ
        style.put("PATIENT_ID", Integer.toString(patient_id));
        //基本情報レコードから取得
        //利用者番号(被保険者番号)
        style.put("INSURED_ID", base.get_201006());
        //請求の対象となる年月(サービス提供年月)
        style.put("TARGET_DATE", ACCastUtilities.toDate(base.get_201003()
                + "01"));
        //請求を行う年月日
        style.put("CLAIM_DATE", claimDate);
        //請求元事業所
        style.put("PROVIDER_ID", base.get_201004());
        
        //保険者番号
        style.put("INSURER_ID",base.get_201005());
        //被保険者番号
        style.put("INSURED_ID",base.get_201006());

        style.put("CLAIM_FINISH_FLAG", "0");

        //明細情報レコード
        Iterator it = detailMap.keySet().iterator();
        while (it.hasNext()) {
            list.add(((QP001RecordDetail) detailMap.get(it.next()))
                    .getRecord(style));
        }
        //特定入所者レコード
        it = nursingMap.keySet().iterator();
        while (it.hasNext()) {
            list.add(((QP001RecordNursing) nursingMap.get(it.next()))
                    .getRecord(style));
        }

        //[H20.5 法改正対応] fujihara edit start
        //特別療養費・特別診療費情報レコード
        it = diagnosisMap.keySet().iterator();
        while (it.hasNext()) {
            list.add(((QP001RecordDiagnosis) diagnosisMap.get(it.next()))
                    .getRecord(style));
        }
        //[H20.5 法改正対応] fujihara edit end
        
        // [H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - begin
        //基本摘要情報レコード
        for (QP001RecordBaseSummary summary : baseSummaryMap.values()) {
        	list.add(summary.getRecord(style));
        }
        // [H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - end
        
        //社福減免レコード
        list.add(emergency.getRecord(style));

        //集計情報レコード
        list.add(type.getRecord(style));

        //基本情報レコード
        list.add(base.getRecord(style));

        return list;
    }

}
