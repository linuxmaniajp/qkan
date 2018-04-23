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
 * 作成日: 2006/01/19  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 施設サービス等介護給付費明細書（介護老人保健施設） (001)
 * プログラム 施設サービス等介護給付費明細書（介護老人保健施設） (QP001P10)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 施設サービス等介護給付費明細書（介護老人保健施設・介護医療院）(様式第九) -様式第九 帳票定義体ファイル名 ： QP001P09X_YYYYMM.xml
 */
public abstract class QP001P09_201804 extends QP001P02_10Event {
    
	/* 
	 * 様式第九 201804以降
	 * 
	 * addFormat()
	 * 設定する帳票定義体を変更
	 * 
	 * getFormatId()
	 * フォーマット番号の変更
	 */
    /**
     * コンストラクタです。
     */
    public QP001P09_201804() {
    }

//    public void addFormat() throws Exception {
//        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P091_201804.xml");
//    }
//
//    public String getFormatId() throws Exception {
//        return "QP001P091_201804";
//    }   
    
    /**
     * 帳票を生成します。
     * 
     * @param writer
     *            印刷管理クラス
     * @param printParam
     *            印刷パラメタ
     * @throws Exception
     *             処理例外
     */
    public boolean doPrintImpl(VRMap printParam) throws Exception {
        // 基本情報レコード
        VRMap baseMap = getBaseMap();
        // 基本摘要情報レコード
        VRList baseSummaryList = getBaseSummaryList(); //[H30.4改正対応][Yoichiro Kamei] 2018/4/2 add
        // 明細情報レコード集合
        VRList detailList = getDetailList();
        // 集計情報レコード
        VRMap typeMap = getTypeMap();

        // 緊急時施設療養・自施設療養費情報レコード
        // [H30.4改正対応][Yoichiro Kamei] 2018/4/11 mod - begin
//        VRMap emergencyOwnFacilityMap = getemErgencyOwnFacilityMap();
        VRMap emergencyOwnFacilityMap = getEmergencyInfo();
        // [H30.4改正対応][Yoichiro Kamei] 2018/4/11 mod - end
        
        // 特定入所者介護サービス費用情報レコード
        VRList nursingList = getNursingList();
        
        //特別療養費情報レコード
        VRList diagnosisList = getDiagnosisList();
        //レコード順次番号が末尾のレコード
        VRMap diagnosisLastMap = getLastRecord(diagnosisList,"501007");
        VRMap diagnosisFirstMap = getNominationRecord(diagnosisList,"501007",1);
        if (diagnosisFirstMap == null) {
            diagnosisFirstMap = diagnosisLastMap;
        }
        
        //[ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
        int detailsRecordCount = 5;
        if (QP001Util.TERM_200904_AFFTER <= getTerm()){
            detailsRecordCount = 4;
        }
        //[ID:0000447][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
        
        VRMap nursingLast = getLastRecord(nursingList,"801007");
        int pageCountMax = 0;
        int printPage = 1;
        // 公費件数ループ
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            // レコードの復元
            parseStyle();
            // 明細情報レコード集合
            detailList = getDetailList();
            // 特定入所者介護サービス費用情報レコード
            nursingList = getNursingList();
            //特別療養費情報レコード
            diagnosisList = getDiagnosisList();
            
            // 印刷頁数を算出する。（1頁あたりの明細情報は8件、特定入所者介護サービス費情報は4件)
            // 特定入所者を印字しない場合があるので、毎回計算する。
            int pageCount = 1;
            int pageTemp = 1;

            if (detailList.getDataSize() > 0) {
                
                //[ID:0000447][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
                //pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 5d);
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / (double)detailsRecordCount);
                //[ID:0000447][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応
                
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if ((nursingList.getDataSize() > 0) && (nursingCount == kohiCount)) {
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 2d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if (diagnosisList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) diagnosisList.getDataSize() / 2d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            //[H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - begin
            if (baseSummaryList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) baseSummaryList.getDataSize() / 2d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            //[H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - end
            pageCountMax += pageCount;
        }

        // 公費件数ループ
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            // レコードの復元
            parseStyle();
            // 基本情報レコード
            baseMap = getBaseMap();
            // 基本摘要情報レコード
            baseSummaryList = getBaseSummaryList(); //[H30.4改正対応][Yoichiro Kamei] 2018/4/2 add           
            // 明細情報レコード集合
            detailList = getDetailList();
            // 集計情報レコード
            typeMap = getTypeMap();

            // 緊急時施設療養・自施設療養費情報レコード
            // [H30.4改正対応][Yoichiro Kamei] 2018/4/11 mod - begin
//            emergencyOwnFacilityMap = getemErgencyOwnFacilityMap();
            emergencyOwnFacilityMap = getEmergencyInfo();
            // [H30.4改正対応][Yoichiro Kamei] 2018/4/11 mod - end
            // 特定入所者介護サービス費用情報レコード
            nursingList = getNursingList();
            //特別治療費情報レコード
            diagnosisList = getDiagnosisList();

            
            // 印刷頁数を算出する。（1頁あたりの明細情報は5件、特定入所者介護サービス費情報は2件、特別治療費は2件)
            // 特定入所者を印字しない場合があるので、毎回計算する。
            int pageCount = 1;
            int pageTemp = 1;

            if (detailList.getDataSize() > 0) {
                
                //[ID:0000447][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
                //pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 5d);
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / (double)detailsRecordCount);
                //[ID:0000447][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応
                
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if ((nursingList.getDataSize() > 0) && (nursingCount == kohiCount)) {
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 2d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            //特定診療費・治療費情報レコード判定
            if (diagnosisList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) diagnosisList.getDataSize() / 2d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
            }
            //[H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - begin
            if (baseSummaryList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) baseSummaryList.getDataSize() / 2d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
            }
            //[H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - end

            // 印刷ループ
            for (int i = 0; i < pageCount; i++,printPage++) {
                // ページ開始
                //[ID:0000447][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
                //writer.beginPageEdit("QP001P10_2");
                writer.beginPageEdit(getFormatId());
                //[ID:0000447][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応

                // 帳票共通情報を設定
                setPrintHeader(kohiCount);
                
                setNyusyoDate();
                
                //[ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
                if (QP001Util.TERM_200904_AFFTER <= getTerm()){
                    //入居前の状況を設定する
                    setBeforeHospitalization();
                }
                //[ID:0000447][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
                
                // [H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - begin
                setBaseSummaryList(baseSummaryList, 3);
                // [H30.4改正対応][Yoichiro Kamei] 2018/4/2 add - end
                
                //明細件数分ループする。※5件を超える場合は、次ページに印字
                //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - start 老健の一部公費対象の対応
                //共通関数から一部公費チェックを行う独自関数の呼び出しへ変更
                //if(isDetailListShow(kohiCount)){
                if(isDetailListShowStyle9(kohiCount,baseMap)){
                //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - start 老健の一部公費対象の対応
                    
                    //[ID:0000447][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
                    //setDetailList(detailList,6,kohiCount);
                	
                	//[H30.04改正対応][Shinobu Hitaka] 2018/03/18 edit - start 様式変更対応
                    //setDetailList(detailList, detailsRecordCount + 1, kohiCount);
                    setDetailList(detailList, detailsRecordCount + 1, kohiCount, 6);
                    //[H30.04改正対応][Shinobu Hitaka] 2014/02/12 edit - end
                    
                    //[ID:0000447][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応
                }
                
                //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - start 老健の一部公費対象の対応
                //共通関数から一部公費チェックを行う独自関数の呼び出しへ変更
                //if(isDiagnosisListShow(kohiCount,diagnosisLastMap)){
                if(isDiagnosisListShowStyle9(kohiCount,diagnosisLastMap,baseMap)){
                //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - end   老健の一部公費対象の対応
                    
                    // 特定診療費件数分ループする。※2件を超える場合は、次ページに印字
                    for (int j = 1; j < 3; j++) {
                        if (diagnosisList.getDataSize() == 0)
                            break;
                        VRMap diagnosis = (VRMap) diagnosisList.get(0);
                        // 識別番号を設定する。
                        ACChotarouXMLUtilities.setValue(writer, diagnosis,
                                "501009", "shikibetsuno" + j);
                        // [H30.4改正対応][Yoichiro Kamei] 2018/3/28 mod - begin
//                        // 内容を設定する。※特定診療費マスタ(M_SPECIAL_CLINIC)のSPECIAL_CLINIC_TYPEと結合し、SPECIAL_CLINIC_NAMEを表示。
//                        //[ID:0000454][Shin Fujihara] 2009/05/01 edit begin 障害対応
//                        /*
//                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
//                                manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009")),2));
//                        */
//                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
//                                manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009")),2, baseMap.get("201003")));
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
                                manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009"))
                                		, getSpecialClinicRecordType(), baseMap.get("201003")));
                        // [H30.4改正対応][Yoichiro Kamei] 2018/3/28 mod - end
                        //[ID:0000454][Shin Fujihara] 2009/05/01 edit end 障害対応
                        // 単位数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryotani" + j, pad(diagnosis.get("501010"),4));
                        // 回数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryotimes" + j, pad(diagnosis.get("501011"),2));
                        // 保険分単位数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryohokentani" + j, pad(diagnosis.get("501012"),6));
                        
                        switch(kohiCount){
                            case 0:
                                // 公費分回数を設定する。
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitimes" + j, pad(diagnosis.get("501014"),2));
                                // 公費分単位数を設定する。
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitani" + j, pad(diagnosis.get("501015"),6));
                                break;
                            case 1:
                                // 公費分回数を設定する。
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitimes" + j, pad(diagnosis.get("501017"),2));
                                // 公費分単位数を設定する。
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitani" + j, pad(diagnosis.get("501018"),6));
                                break;
                            case 2:
                                // 公費分回数を設定する。
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitimes" + j, pad(diagnosis.get("501020"),2));
                                // 公費分単位数を設定する。
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitani" + j, pad(diagnosis.get("501021"),6));
                                break;
                        }
                        
                        // 摘要を設定する。
                        ACChotarouXMLUtilities.setValue(writer, diagnosis,
                                "501023", "tokuteishinryo.h" + j + ".tekiyo");
                        
                        diagnosisList.remove(0);
                    }
                }

                // 特定入所者介護サービス件数分ループする。※2件を超える場合は、次ページに印字
                if(nursingCount == kohiCount){
                    for (int j = 1; j < 3; j++) {
                        if (nursingList.getDataSize() == 0)
                            break;
                        VRMap nursing = (VRMap) nursingList.get(0);
                        // サービス内容を設定する。
                        ACChotarouXMLUtilities.setValue(writer, nursing, "801034", "tokuteimeisai.h" + j + ".w2");
                        // サービスコードを設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "tokuteiservicecode" + j, ACCastUtilities
                                        .toString(VRBindPathParser.get("801008",
                                                nursing))
                                        + ACCastUtilities.toString(VRBindPathParser
                                                .get("801009", nursing)));

                        // 費用単価を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitani" + j, pad(VRBindPathParser.get("801010", nursing), 4));
                        // 負担限度額を設定する。
                        //[ID:0000651][Shin Fujihara] 2011/07/06 add begin 負担限度額0円表示対応
                        //ACChotarouXMLUtilities.setValue(writer, "dokuteilimit" + j, pad(VRBindPathParser.get("801011", nursing), 4));
                        ACChotarouXMLUtilities.setValue(writer, "dokuteilimit" + j, pad0NursingLimit(VRBindPathParser.get("801011", nursing), 4));
                        //[ID:0000651][Shin Fujihara] 2011/07/06 add end 負担限度額0円表示対応
                        // 日数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitimes" + j, pad(VRBindPathParser.get("801012", nursing), 2));
                        // 費用額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyo" + j, pad(VRBindPathParser.get("801016", nursing), 6));
                        // 保険分金額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihoken" + j, pad(VRBindPathParser.get("801017", nursing), 6));
                        
                        switch(kohiCount){
                        case 0:
                            //公費日数を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohitimes" + j, pad(VRBindPathParser.get("801013", nursing), 2));
                            //公費分費用を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohi" + j, pad(VRBindPathParser.get("801018", nursing), 6));
                            break;
                        case 1:
                            //公費日数を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohitimes" + j, pad(VRBindPathParser.get("801014", nursing), 2));
                            //公費分費用を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohi" + j, pad(VRBindPathParser.get("801019", nursing), 6));
                            break;
                        case 2:
                            //公費日数を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohitimes" + j, pad(VRBindPathParser.get("801015", nursing), 2));
                            //公費分費用を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohi" + j, pad(VRBindPathParser.get("801020", nursing), 6));
                            break;
                        }
                        
                        // 利用者負担額を設定する。
                        //[ID:0000449][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
                        //ACChotarouXMLUtilities.setValue(writer, "tokuteiriyosha" + j, pad(VRBindPathParser.get("801021", nursing), 5));
                        ACChotarouXMLUtilities.setValue(writer, "tokuteiriyosha" + j, pad0(VRBindPathParser.get("801021", nursing), 5));
                        //[ID:0000449][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応
                        
                        nursingList.remove(0);
                    }
                }


                // 1ページ目のみ印字する
                if (i == 0) {
                    //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - start 老健の一部公費対象の対応
                    //共通関数から一部公費チェックを行う独自関数の呼び出しへ変更
                    //if(isDetailListShow(kohiCount)){
                    if(isDetailListShowStyle9(kohiCount,baseMap)){
                    //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - start 老健の一部公費対象の対応
                            
                        //サービス単位数合計を設定する。　※サービス単位数の合算を設定。
                        ACChotarouXMLUtilities.setValue(writer,"servicetimetotal",pad(String.valueOf(getServiceUnitTotal()),6));
                        //公費対象単位数合計を設定する。　※公費対象単位数の合算を設定。
                        switch(kohiCount){
                        case 0:
                            ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal1()),6));
                            break;
                        case 1:
                            ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal2()),6));
                            break;
                        case 2:
                            ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal3()),6));
                            break;
                        }
                    }
                    
                    // 緊急時施設治療費===================================
// [H30.4改正対応][Yoichiro Kamei] 2018/4/11 mod - begin
//                    if(emergencyOwnFacilityMap != null){
//                        
//                        // 特定疾患施設療養費 傷病名１
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701047", "emergency1.h1.w8");
//                        // 特定疾患施設療養費 傷病名２
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701048", "emergency1.h2.w8");
//                        // 特定疾患施設療養費 傷病名３
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701049", "emergency1.h3.w8");
//                        // 特定疾患施設療養費開始年月日１
//                        if (QP001Util.isDate(VRBindPathParser.get("1701050", emergencyOwnFacilityMap))) {
//                            Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701050", emergencyOwnFacilityMap));
//                            // 特定疾患施設療養費開始年月日１の和暦を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergency1.h1.w19", eraFormat.format(start));
//                            // 特定疾患施設療養費開始年月日１の和暦年を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "ownyear1", eraYearFormat.format(start));
//                            // 特定疾患施設療養費開始年月日１の月を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "ownmonth1", monthFormat.format(start));
//                            // 特定疾患施設療養費開始年月日１の日を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "ownday1", dayFormat.format(start));
//                        }
//                        // 特定疾患施設療養費開始年月日２
//                        if (QP001Util.isDate(VRBindPathParser.get("1701051", emergencyOwnFacilityMap))) {
//                            Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701051", emergencyOwnFacilityMap));
//                            // 特定疾患施設療養費開始年月日２の和暦を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergency1.h2.w19", eraFormat.format(start));
//                            // 特定疾患施設療養費開始年月日２の和暦年を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "ownyear2", eraYearFormat.format(start));
//                            // 特定疾患施設療養費開始年月日２の月を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "ownmonth2", monthFormat.format(start));
//                            // 特定疾患施設療養費開始年月日２の日を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "ownday2", dayFormat.format(start));
//                        }
//                        // 特定疾患施設療養費開始年月日３
//                        if (QP001Util.isDate(VRBindPathParser.get("1701052", emergencyOwnFacilityMap))) {
//                            Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701052", emergencyOwnFacilityMap));
//                            // 特定疾患施設療養費開始年月日３の和暦を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergency1.h3.w19", eraFormat.format(start));
//                            // 特定疾患施設療養費開始年月日３の和暦年を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "ownyear3", eraYearFormat.format(start));
//                            // 特定疾患施設療養費開始年月日３の月を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "ownmonth3", monthFormat.format(start));
//                            // 特定疾患施設療養費開始年月日３の日を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "ownday3", dayFormat.format(start));
//                        }
//                        // 特定疾患施設療養費(再掲)を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, "emergency1.h4.w7", pad(emergencyOwnFacilityMap.get("1701055"),0));
//                        // 特定疾患施設療養費単位数を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, "emergency1.h4.w10", pad(emergencyOwnFacilityMap.get("1701053"),0));
//                        // 特定疾患施設療養費日数を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, "owntani", pad(emergencyOwnFacilityMap.get("1701054"),2));
//                        
//                        
//                        // 緊急時傷病名１を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701008", "emergency1.h5.w8");
//                        // 緊急時傷病名２を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701009", "emergency1.h6.w8");
//                        // 緊急時傷病名３を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701010", "emergency1.h7.w8");
//    
//                        // 緊急時治療開始開始年月日１
//                        if (QP001Util.isDate(VRBindPathParser.get("1701011", emergencyOwnFacilityMap))) {
//                            Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701011", emergencyOwnFacilityMap));
//                            // 緊急時治療開始年月日１の和暦を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergency1.h5.w19", eraFormat.format(start));
//                            // 緊急時治療開始年月日１の和暦年を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergencyyear1", eraYearFormat.format(start));
//                            // 緊急時治療開始年月日１の月を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergencymonth1", monthFormat.format(start));
//                            // 緊急時治療開始年月日１の日を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergencyday1", dayFormat.format(start));
//                        }
//    
//                        // 緊急時治療開始年月日２
//                        if (QP001Util.isDate(VRBindPathParser.get("1701012", emergencyOwnFacilityMap))) {
//                            Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701012", emergencyOwnFacilityMap));
//                            // 緊急時治療開始年月日２の和暦を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergency1.h6.w19", eraFormat.format(start));
//                            // 緊急時治療開始年月日２の和暦年を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergencyyear2", eraYearFormat.format(start));
//                            // 緊急時治療開始年月日２の月を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergencymonth2", monthFormat.format(start));
//                            // 緊急時治療開始年月日２の日を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergencyday2", dayFormat.format(start));
//                        }
//    
//                        // 緊急時治療開始年月日３
//                        if (QP001Util.isDate(VRBindPathParser.get("1701013", emergencyOwnFacilityMap))) {
//                            Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701013", emergencyOwnFacilityMap));
//                            // 緊急時治療開始年月日３の和暦を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergency1.h7.w19", eraFormat.format(start));
//                            // 緊急時治療開始年月日３の和暦年を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergencyyear3", eraYearFormat.format(start));
//                            // 緊急時治療開始年月日３の月を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergencymonth3", monthFormat.format(start));
//                            // 緊急時治療開始年月日３の日を設定する。
//                            ACChotarouXMLUtilities.setValue(writer, "emergencyday3", dayFormat.format(start));
//                        }
//    
//                        // 緊急時治療管理(再掲)を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, "emergency1.h8.w7", pad(emergencyOwnFacilityMap.get("1701020"),0));
//                        // 緊急時治療管理単位数を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, "emergency1.h8.w10", pad(emergencyOwnFacilityMap.get("1701018"),0));
//                        // 緊急時治療管理日数を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, "emergencytani", pad(emergencyOwnFacilityMap.get("1701019"),2));
//    
//                        // リハビリテーション点数を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, "emergency2.h9.w6", pad(emergencyOwnFacilityMap.get("1701021"),0));
//                        // 処置点数を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, "emergency2.h10.w6", pad(emergencyOwnFacilityMap.get("1701022"),0));
//                        // 手術点数を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, "emergency2.h11.w6", pad(emergencyOwnFacilityMap.get("1701023"),0));
//                        // 麻酔点数を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, "emergency2.h12.w6", pad(emergencyOwnFacilityMap.get("1701024"),0));
//                        // 放射線治療点数を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, "emergency2.h13.w6", pad(emergencyOwnFacilityMap.get("1701025"),0));
//                        // 合計点数を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, "emergency2.h14.w6", pad(emergencyOwnFacilityMap.get("1701046"),0));
//                        
//                        // 摘要を設定する。※摘要１～摘要２０までを「／」で連結し、出力。
//                        StringBuilder tekiyo = new StringBuilder();
//                        for (int j = 1701026; j < 1701046; j++) {
//                            if (!ACTextUtilities.isNullText(VRBindPathParser.get(ACCastUtilities.toString(j), emergencyOwnFacilityMap))) {
//                                tekiyo.append(VRBindPathParser.get(ACCastUtilities.toString(j), emergencyOwnFacilityMap));
//                                tekiyo.append("／");
//                            }
//                        }
//                        if (tekiyo.length() > 0) {
//                            tekiyo.deleteCharAt(tekiyo.length() - 1);
//                        }
//                        ACChotarouXMLUtilities.setValue(writer, "emergency2.h10.w10",tekiyo.toString());
//                        
//                        // 往診日数を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, "oushintimes", pad(emergencyOwnFacilityMap.get("1701014"),2));
//                        // 往診医療機関名を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap,"1701015", "emergency3.h15.w8");
//                        
//                        // 通院日数を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, "tuuintimes", pad(emergencyOwnFacilityMap.get("1701016"),2));
//                        // 通院医療機関を設定する。
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701017","emergency3.h15.w21");
//                    }
                    writeEmergency();
// [H30.4改正対応][Yoichiro Kamei] 2018/4/11 mod - end
                    
                    //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - start 老健の一部公費対象の対応
                    //共通関数から一部公費チェックを行う独自関数の呼び出しへ変更
                    //if(isDiagnosisListShow(kohiCount,diagnosisLastMap)){
                    if(isDiagnosisListShowStyle9(kohiCount,diagnosisLastMap,baseMap)){
                    //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - end   老健の一部公費対象の対応
                        
                        // 特定診療費情報レコード順次番号が01のレコードの傷病名を設定する。
                        // 01のレコードがない場合は99のレコードの値を採用する。
                        ACChotarouXMLUtilities.setValue(writer, diagnosisFirstMap,"501008", "tokuteishinryo.syoubyo.w4");
                        
                        //特定診療費の合計欄を出力
                        if(diagnosisLastMap != null){
                            //特定診療費の保険分単位数の合計を設定する。 ※特定診療費情報レコード順次番号が99の値を採用する。
                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryohokentanitotal", pad(diagnosisLastMap.get("501013"),6));
                            
                            switch(kohiCount){
                            case 0:
                                //特定診療費の公費分単位数の合計を設定する。　※特定診療費情報レコード順次番号が99の値を採用する。
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501016"),6));
                                break;
                            case 1:
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501019"),6));
                                break;
                            case 2:
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501022"),6));
                                break;
                            }
                            
                        }
                    }
                    
                    //[CCCX:1470][Shinobu Hitaka] 2014/03/13 edit - start 老健の一部公費対象の対応
                    //共通関数から一部公費チェックを行う独自関数の呼び出しへ変更
                    //if(isDetailListShow(kohiCount)){
                    if(isDetailListShowStyle9(kohiCount,baseMap)){
                    //[CCCX:1470][Shinobu Hitaka] 2014/03/13 edit - start 老健の一部公費対象の対応
                        
                        //請求額集計欄 保険分====================================
                        // 給付点数・単位数（保険分）を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "hokentani", pad(typeMap.get("701014"),6));
                        // 点数・単位数単価を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tanka", getTanka(typeMap.get("701015")));
                        
                        if(kohiCount == 0){
                            // 給付率（保険分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "hokenkyuhu", pad(baseMap.get("201029"),3));
                            // 請求額（保険分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu", pad(typeMap.get("701016"),6));
                            // 利用者負担額（保険分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "hokenriyousyahutan",pad(typeMap.get("701017"),6));
                        }
                        
                        //請求額集計欄 公費分====================================
                        switch(kohiCount){
                        case 0:
                            // 給付点数・単位数（公費分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitani", pad(typeMap.get("701018"),6));
                            // 給付率（公費分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohikyuhu", pad(baseMap.get("201030"),3));
                            // 請求額（公費分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701019"),6));
                            // 利用者負担額（公費分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohiriyousyahutan", pad(typeMap.get("701020"),6));
                            break;
                        case 1:
                            // 給付点数・単位数（公費分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitani", pad(typeMap.get("701021"),6));
                            // 給付率（公費分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohikyuhu", pad(baseMap.get("201031"),3));
                            // 請求額（公費分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701022"),6));
                            // 利用者負担額（公費分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohiriyousyahutan", pad(typeMap.get("701023"),6));
                            break;
                        case 2:
                            // 給付点数・単位数（公費分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitani", pad(typeMap.get("701024"),6));
                            // 給付率（公費分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohikyuhu", pad(baseMap.get("201032"),3));
                            // 請求額（公費分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701025"),6));
                            // 利用者負担額（公費分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohiriyousyahutan", pad(typeMap.get("701026"),6));
                            break;
                        }
                    }
                    
                    //請求額集計欄 保険分特定治療・特定療養費====================================
                    if(ACCastUtilities.toInt(typeMap.get("701027"),0) != 0){
                        
                        ACChotarouXMLUtilities.setValue(writer, "hokentokuteitani", pad(typeMap.get("701027"),6));
                        if(kohiCount == 0){
                            // 給付率（保険分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "hokentokuteikyuhu", pad(baseMap.get("201029"),3));
                            // 請求額（保険分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "hokentokuteiseikyu", pad(typeMap.get("701028"),6));
                            // 本人負担額（保険分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "hokentokuteiriyousyahutan", pad(typeMap.get("701029"),6));
                        }
                        
                    }
                    
                    //請求額集計欄 公費分特定治療====================================
                    switch(kohiCount){
                    case 0:
                        if(ACCastUtilities.toInt(typeMap.get("701030"),0) != 0){
                            // 給付点数・単位数（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteitani", pad(typeMap.get("701030"),6));
                            //給付率（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyuhu", pad(baseMap.get("201030"),3));
                            // 請求額（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701031"),6));
                            // 利用者負担額（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyahutan", pad(typeMap.get("701032"),6));
                        }
                        break;
                    case 1:
                        if(ACCastUtilities.toInt(typeMap.get("701033"),0) != 0){
                            // 給付点数・単位数（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteitani", pad(typeMap.get("701033"),6));
                            //給付率（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyuhu", pad(baseMap.get("201031"),3));
                            // 請求額（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701034"),6));
                            // 利用者負担額（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyahutan", pad(typeMap.get("701035"),6));
                        }
                        break;
                    case 2:
                        if(ACCastUtilities.toInt(typeMap.get("701036"),0) != 0){
                            // 給付点数・単位数（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteitani", pad(typeMap.get("701036"),6));
                            //給付率（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyuhu", pad(baseMap.get("201032"),3));
                            // 請求額（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701037"),6));
                            // 利用者負担額（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyahutan", pad(typeMap.get("701038"),6));
                        }
                        break;
                    }

                    
                    if((nursingLast != null) && (nursingCount == kohiCount)){
                        //費用額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyototal",pad(nursingLast.get("801022"),6));
                        
                        //保険者負担額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,"tokuteihokentotal", pad(nursingLast.get("801023"),6));
                        //保険分請求額を設定する。
                        //[ID:0000449][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
                        //ACChotarouXMLUtilities.setValue(writer,"tokuteiriyoshatotal", pad(nursingLast.get("801024"),5));
                        ACChotarouXMLUtilities.setValue(writer,"tokuteiriyoshatotal", pad0(nursingLast.get("801024"),6));
                        //[ID:0000449][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応
                        
                        switch(kohiCount){
                        case 0:
                            //公費分合計を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitotal1",pad(nursingLast.get("801025"),6));
                            //公費分請求額を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitotal2",pad(nursingLast.get("801026"),6));
                            //公費分本人負担額を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohihonninmonth",pad(nursingLast.get("801027"),5));
                            break;
                        case 1:
                            //公費分合計を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitotal1",pad(nursingLast.get("801028"),6));
                            //公費分請求額を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitotal2",pad(nursingLast.get("801029"),6));
                            //公費分本人負担額を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohihonninmonth",pad(nursingLast.get("801030"),5));
                            break;
                        case 2:
                            //公費分合計を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitotal1",pad(nursingLast.get("801031"),6));
                            //公費分請求額を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "kohitotal2",pad(nursingLast.get("801032"),6));
                            //公費分本人負担額を設定する。
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohihonninmonth",pad(nursingLast.get("801033"),5));
                            break;
                        }
                    }

                }
                // 印刷ページ総数が2枚以上の場合
                if ((pageCountMax) > 1) {
                    // 出力ページ数の総数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
                            ACCastUtilities.toString((pageCountMax)));
                    // 現在の出力ページ数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "nowpage",
                            ACCastUtilities.toString(printPage));
                }
                // ページ終了
                writer.endPageEdit();
            }
        }

        // 印刷を実行したならばtrueを返す。
        return true;
    }
    
    /**
     * 給付費明細欄を表示するかのフラグを返却します。<br>
     * 老健専用
     * @param kohiCount
     * @return
     * @throws Exception
     */
    protected boolean isDetailListShowStyle9(int kohiCount, VRMap baseMap) throws Exception {
        
        switch(kohiCount){
            //公費１印刷時
            case 0:
                // 公費負担者番号を確認
                //公費負担者番号が存在し
                if(!ACTextUtilities.isNullText(baseMap.get("201007"))){
                    if(ACCastUtilities.toString(baseMap.get("201007")).startsWith("10")){
                        return true;
                    }
                    
                    //公費が8801:水俣病総合対策、8802:メチル水銀、8701:有機ヒ素、6601:石綿　の場合
                    //一部公費適用のため、公費総計がなくても表示する
                    if (ACCastUtilities.toString(baseMap.get("201007")).startsWith("88") ||
                            ACCastUtilities.toString(baseMap.get("201007")).startsWith("87") || 
                            ACCastUtilities.toString(baseMap.get("201007")).startsWith("66")) {
                        return true;
                    }
                    
                    //公費総計が0の場合は表示を中断する。
                    if(getKohiTotal1() == 0){
                        return false;
                    }
                }
                break;
            //公費２印刷時
            case 1:
                if(!ACTextUtilities.isNullText(baseMap.get("201009"))){
                    if(ACCastUtilities.toString(baseMap.get("201009")).startsWith("10")){
                        return true;
                    }
                    
                    //公費が8801:水俣病総合対策、8802:メチル水銀、8701:有機ヒ素、6601:石綿　の場合
                    //一部公費適用のため、公費総計がなくても表示する
                    if (ACCastUtilities.toString(baseMap.get("201009")).startsWith("88") ||
                            ACCastUtilities.toString(baseMap.get("201009")).startsWith("87") || 
                            ACCastUtilities.toString(baseMap.get("201009")).startsWith("66")) {
                        return true;
                    }
                    
                    //公費総計が0の場合は表示を中断する。
                    if(getKohiTotal2() == 0){
                        return false;
                    }
                }
                break;
            //公費３印刷時
            case 2:
                if(!ACTextUtilities.isNullText(baseMap.get("201011"))){
                    if(ACCastUtilities.toString(baseMap.get("201011")).startsWith("10")){
                        return true;
                    }
                    
                    //公費が8801:水俣病総合対策、8802:メチル水銀、8701:有機ヒ素、6601:石綿　の場合
                    //一部公費適用のため、公費総計がなくても表示する
                    if (ACCastUtilities.toString(baseMap.get("201011")).startsWith("88") ||
                            ACCastUtilities.toString(baseMap.get("201011")).startsWith("87") || 
                            ACCastUtilities.toString(baseMap.get("201011")).startsWith("66")) {
                        return true;
                    }

                    //公費総計が0の場合は表示を中断する。
                    if(getKohiTotal3() == 0){
                        return false;
                    }
                }
                break;
        }
        return true;
    }
    
    /**
     * 特定診療費明細欄を表示するかのフラグを返却します。
     * 老健専用
     * @param kohiCount
     * @param diagnosisLastMap
     * @return
     * @throws Exception
     */
    protected boolean isDiagnosisListShowStyle9(int kohiCount,VRMap diagnosisLastMap, VRMap baseMap) throws Exception {
        
        if(diagnosisLastMap == null){
            return true;
        }
        switch(kohiCount){
            //公費１印刷時
            case 0:
                // 公費負担者番号を確認
                //公費負担者番号が存在し
                if(!ACTextUtilities.isNullText(baseMap.get("201007"))){
                    if(ACCastUtilities.toString(baseMap.get("201007")).startsWith("10")){
                        return true;
                    }

                    //公費が8801:水俣病総合対策、8802:メチル水銀、8701:有機ヒ素、6601:石綿　の場合
                    //一部公費適用のため、公費総計がなくても表示する
                    if (ACCastUtilities.toString(baseMap.get("201007")).startsWith("88") ||
                            ACCastUtilities.toString(baseMap.get("201007")).startsWith("87") || 
                            ACCastUtilities.toString(baseMap.get("201007")).startsWith("66")) {
                        return true;
                    }
                    
                    //公費総計が0の場合は表示を中断する。
                    if(ACCastUtilities.toInt(diagnosisLastMap.get("501016"),0) == 0){
                        return false;
                    }
                }
                break;
            //公費２印刷時
            case 1:
                if(!ACTextUtilities.isNullText(baseMap.get("201009"))){
                    if(ACCastUtilities.toString(baseMap.get("201009")).startsWith("10")){
                        return true;
                    }
                    
                    //公費が8801:水俣病総合対策、8802:メチル水銀、8701:有機ヒ素、6601:石綿　の場合
                    //一部公費適用のため、公費総計がなくても表示する
                    if (ACCastUtilities.toString(baseMap.get("201009")).startsWith("88") ||
                            ACCastUtilities.toString(baseMap.get("201009")).startsWith("87") || 
                            ACCastUtilities.toString(baseMap.get("201009")).startsWith("66")) {
                        return true;
                    }
                    
                    //公費総計が0の場合は表示を中断する。
                    if(ACCastUtilities.toInt(diagnosisLastMap.get("501019"),0) == 0){
                        return false;
                    }
                }
                break;
            //公費３印刷時
            case 2:
                if(!ACTextUtilities.isNullText(baseMap.get("201011"))){
                    if(ACCastUtilities.toString(baseMap.get("201011")).startsWith("10")){
                        return true;
                    }
                    
                    //公費が8801:水俣病総合対策、8802:メチル水銀、8701:有機ヒ素、6601:石綿　の場合
                    //一部公費適用のため、公費総計がなくても表示する
                    if (ACCastUtilities.toString(baseMap.get("201011")).startsWith("88") ||
                            ACCastUtilities.toString(baseMap.get("201011")).startsWith("87") || 
                            ACCastUtilities.toString(baseMap.get("201011")).startsWith("66")) {
                        return true;
                    }
                    
                    //公費総計が0の場合は表示を中断する。
                    if(ACCastUtilities.toInt(diagnosisLastMap.get("501022"),0) == 0){
                        return false;
                    }
                }
                break;
        }
        return true;
    }

    // [H30.4改正対応][Yoichiro Kamei] 2018/3/28 add - begin
    // 特別療養費または特別診療費のレコードタイプを取得します。（子クラスで実装）
    protected abstract int getSpecialClinicRecordType();
    
    // 緊急時施設療養・緊急時施設診療情報または、所定疾患施設療養費等情報を出力します。（子クラスで実装）
    protected abstract VRMap getEmergencyInfo();
    protected abstract void writeEmergency() throws Exception;
    // [H30.4改正対応][Yoichiro Kamei] 2018/3/28 add - end
}
