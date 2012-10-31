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
 * 作成日: 2006/01/17  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 在宅サービス介護給付費明細書（介護老人保健施設） (001)
 * プログラム 在宅サービス介護給付費明細書（介護老人保健施設） (QP00105)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 在宅サービス介護給付費明細書（介護老人保健施設）(様式第四) - 帳票定義体ファイル名 ： QP001P04X_YYYYMM.xml
 */
public class QP001P04_201204 extends QP001P02_10Event {

    /**
     * コンストラクタです。
     */
    public QP001P04_201204() {
    }

    /**
     * H20.5以降の帳票レイアウトに対応した印刷メソッド
     * @param printParam
     * @return
     * @throws Exception
     */
    public boolean doPrintImpl(VRMap printParam) throws Exception {

        // 基本情報レコード
        VRMap baseMap = getBaseMap();
        // 明細情報レコード集合
        VRList detailList = getDetailList();
        // 集計情報レコード
        VRMap typeMap = getTypeMap();

        // 緊急時施設療養情報レコード
        VRMap emergencyMap = getemErgencyMap();
        // 特定入所者介護サービス費用情報レコード
        VRList nursingList = getNursingList();

        VRMap nursingLast = getLastRecord(nursingList, "801007");
        
        VRList diagnosisList = getDiagnosisList();
        //レコード順次番号が末尾のレコード
        VRMap diagnosisLastMap = getLastRecord(diagnosisList,"501007");
        VRMap diagnosisFirstMap = getNominationRecord(diagnosisList,"501007",1);
        if (diagnosisFirstMap == null) {
            diagnosisFirstMap = diagnosisLastMap;
        }

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
            // 特定診療費情報レコード
            diagnosisList = getDiagnosisList();

            // 印刷頁数を算出する。（1頁あたりの明細情報は4件、特定入所者介護サービス費情報は2件、特別治療費は2件)
            // ※複数公費の受給を受けている場合は、受給公費分帳票を出力する。
            // 特定入所者を印字しない場合があるので、毎回計算する。
            int pageCount = 1;
            int pageTemp = 1;

            //明細情報レコード判定
            if (detailList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 4d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
            }
            //特定入所者介護サービス費情報レコード判定
            if ((nursingList.getDataSize() > 0) && (0 == kohiCount)) {
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 2d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
            }
            //特定診療費・治療費情報レコード判定
            if (diagnosisList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) diagnosisList.getDataSize() / 2d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
            }
            pageCountMax += pageCount;
        }

        // 公費件数ループ
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            // レコードの復元
            parseStyle();
            // 基本情報レコード
            baseMap = getBaseMap();
            // 明細情報レコード集合
            detailList = getDetailList();
            // 集計情報レコード
            typeMap = getTypeMap();

            // 緊急時施設療養情報レコード
            emergencyMap = getemErgencyMap();
            // 特定入所者介護サービス費用情報レコード
            nursingList = getNursingList();
            // 特定診療費情報レコード
            diagnosisList = getDiagnosisList();

            // 印刷頁数を算出する。（1頁あたりの明細情報は7件、特定入所者介護サービス費情報は4件)
            // ※複数公費の受給を受けている場合は、受給公費分帳票を出力する。
            // 特定入所者を印字しない場合があるので、毎回計算する。
            int pageCount = 1;
            int pageTemp = 1;

            if (detailList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 4d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
            }
            if ((nursingList.getDataSize() > 0) && (0 == kohiCount)) {
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 2d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
            }
            //特定診療費・治療費情報レコード判定
            if (diagnosisList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) diagnosisList.getDataSize() / 2d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
            }

            // 印刷ループ
            for (int i = 0; i < pageCount; i++,printPage++) {
                // ページ開始
                writer.beginPageEdit(getFormatId());

                // 帳票共通情報を設定
                setPrintHeader(kohiCount);

                // 居宅サービス状況を設定
                setKyotakuData();

                // 入所年月日の設定
                if (QP001Util.isDate(baseMap.get("201024"))) {
                    Date start = ACCastUtilities.toDate(VRBindPathParser.get("201024", baseMap));
                    // 入所年月日の和暦を設定する。
                    ACChotarouXMLUtilities.setValue(writer,"nyusyodate.h2.w11", eraFormat.format(start));
                    // 入所年月日の和暦年(YYフォーマット)を設定する
                    ACChotarouXMLUtilities.setValue(writer, "nyusyoyear",eraYearFormat.format(start));
                    // 入所年月日の月(MMフォーマット)を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "nyusyomonth",monthFormat.format(start));
                    // 入所年月日の日(DDフォーマット)を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "nyusyoday",dayFormat.format(start));
                }

                // 退所年月日の設定
                if (QP001Util.isDate(baseMap.get("201025"))) {
                    Date end = ACCastUtilities.toDate(VRBindPathParser.get("201025", baseMap));
                    // 退所年月日の和暦を設定する。
                    ACChotarouXMLUtilities.setValue(writer,"taisyodate.h2.w11", eraFormat.format(end));
                    // 退所年月日の年(YYフォーマット)を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "taisyoyear",eraYearFormat.format(end));
                    // 退所年月日の月(MMフォーマット)を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "taisyomonth",monthFormat.format(end));
                    // 退所年月日の日(DDフォーマット)を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "taisyoday",dayFormat.format(end));

                }
                // 短期入所の実日数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "tankijitsu", pad(typeMap.get("701013"), 2));

                // 明細件数分ループする。※7件を超える場合は、次ページに印字
                setDetailList(detailList, 5, kohiCount);

                // 特定療養費件数分ループする。※2件を超える場合は、次ページに印字
                for (int j = 1; j < 3; j++) {
                    if (diagnosisList.getDataSize() == 0){
                        break;
                    }
                    VRMap diagnosis = (VRMap) diagnosisList.get(0);
                    // 識別番号を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "shikibetsuno" + j, pad(diagnosis.get("501009"),2));
                    // 内容を設定する。※特定診療費マスタ(M_SPECIAL_CLINIC)のSPECIAL_CLINIC_TYPEと結合し、SPECIAL_CLINIC_NAMEを表示。
                    //[ID:0000454][Shin Fujihara] 2009/05/01 edit begin 障害対応
                    /*
                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
                            manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009")),2));
                    */
                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
                            manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009")),2,baseMap.get("201003")));
                    //[ID:0000454][Shin Fujihara] 2009/05/01 edit end 障害対応
                    // 単位数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryotani" + j, pad(diagnosis.get("501010"),4));
                    // 回数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryotimes" + j, pad(diagnosis.get("501011"),2));
                    // 保険分単位数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryohokentani" + j, pad(diagnosis.get("501012"),5) );
                    
                    switch(kohiCount){
                    case 0:
                        // 公費分回数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitimes" + j, pad(diagnosis.get("501014"),2));
                        // 公費分単位数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitani" + j, pad(diagnosis.get("501015"),5));
                        break;
                    case 1:
                        // 公費分回数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitimes" + j, pad(diagnosis.get("501017"),2));
                        // 公費分単位数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitani" + j, pad(diagnosis.get("501018"),5));
                        break;
                    case 2:
                        // 公費分回数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitimes" + j, pad(diagnosis.get("501020"),2));
                        // 公費分単位数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitani" + j, pad(diagnosis.get("501021"),5));
                        break;
                    }
                    
                    // 摘要を設定する。
                    ACChotarouXMLUtilities.setValue(writer, diagnosis,
                            "501023", "tokuteishinryo.h" + j + ".tekiyo");
                    
                    diagnosisList.remove(0);
                }
                
                // 特定入所者介護サービス件数分ループする。※2件を超える場合は、次ページに印字
                if (0 == kohiCount) {
                    for (int j = 1; j < 3; j++) {
                        if (nursingList.getDataSize() == 0)
                            break;
                        VRMap nursing = (VRMap) nursingList.get(0);
                        // サービス内容を設定する。
                        ACChotarouXMLUtilities.setValue(writer, nursing,
                                "801034", "tokuteimeisai.h" + j + ".w2");
                        // サービスコードを設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "tokuteiservicecode" + j, ACCastUtilities
                                        .toString(VRBindPathParser.get(
                                                "801008", nursing))
                                        + ACCastUtilities
                                                .toString(VRBindPathParser.get(
                                                        "801009", nursing)));

                        // 費用単価を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitani"
                                + j, pad(VRBindPathParser
                                .get("801010", nursing), 4));
                        // 負担限度額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "dokuteilimit"
                        		//[ID:0000651][Shin Fujihara] 2011/07/06 add begin 負担限度額0円表示対応
                                //+ j, pad(VRBindPathParser
                        		+ j, pad0NursingLimit(VRBindPathParser
                        		//[ID:0000651][Shin Fujihara] 2011/07/06 add end 負担限度額0円表示対応
                                .get("801011", nursing), 4));
                        // 日数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitimes"
                                + j, pad(VRBindPathParser
                                .get("801012", nursing), 2));
                        // 費用額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyo"
                                + j, pad(VRBindPathParser
                                .get("801016", nursing), 6));
                        // 保険分金額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihoken"
                                + j, pad(VRBindPathParser
                                .get("801017", nursing), 6));
                        // 利用者負担額を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                        		//[ID:0000449][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
                                //"tokuteiriyosha" + j, pad(VRBindPathParser.get(
                        		"tokuteiriyosha" + j, pad0(VRBindPathParser.get(
                                //[ID:0000449][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応
                                        "801021", nursing), 5));

                        nursingList.remove(0);
                    }
                }

                // 1ページ目のみ印字する
                if (i == 0) {
                    // サービス単位数合計を設定する。 ※サービス単位数の合算を設定。
                    // setValue(servicetimetotal);
                    ACChotarouXMLUtilities.setValue(writer, "servicetimetotal",
                            pad(String.valueOf(getServiceUnitTotal()), 5));
                    // 公費対象単位数合計を設定する。 ※公費対象単位数の合算を設定。
                    switch (kohiCount) {
                    case 0:
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohitanitotal", pad(String
                                        .valueOf(getKohiTotal1()), 5));
                        break;
                    case 1:
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohitanitotal", pad(String
                                        .valueOf(getKohiTotal2()), 5));
                        break;
                    case 2:
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohitanitotal", pad(String
                                        .valueOf(getKohiTotal3()), 5));
                        break;
                    }

                    /* ============================================================================= */
                    /* 緊急時施設療養費 */
                    /* ============================================================================= */
                    if(emergencyMap != null){
	                    // 緊急時傷病名１を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, emergencyMap,
	                            "401008", "emergency.s1.syoubyo");
	                    // 緊急時傷病名２を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, emergencyMap,
	                            "401009", "emergency.s2.syoubyo");
	                    // 緊急時傷病名３を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, emergencyMap,
	                            "401010", "emergency.s3.syoubyo");
	
	                    // 緊急時治療開始開始年月日１
	                    if (QP001Util.isDate(VRBindPathParser.get("401011",
	                            emergencyMap))) {
	                        Date start = ACCastUtilities.toDate(VRBindPathParser
	                                .get("401011", emergencyMap));
	                        // 緊急時治療開始年月日１の和暦を設定する。
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergency.s1.emergencydate", eraFormat
	                                        .format(start));
	                        // 緊急時治療開始年月日１の和暦年を設定する。
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencyyear1", eraYearFormat.format(start));
	                        // 緊急時治療開始年月日１の月を設定する。
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencymonth1", monthFormat.format(start));
	                        // 緊急時治療開始年月日１の日を設定する。
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencyday1", dayFormat.format(start));
	                    }
	
	                    // 緊急時治療開始年月日２
	                    if (QP001Util.isDate(VRBindPathParser.get("401012",
	                            emergencyMap))) {
	                        Date start = ACCastUtilities.toDate(VRBindPathParser
	                                .get("401012", emergencyMap));
	                        // 緊急時治療開始年月日２の和暦を設定する。
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergency.s2.emergencydate", eraFormat
	                                        .format(start));
	                        // 緊急時治療開始年月日２の和暦年を設定する。
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencyyear2", eraYearFormat.format(start));
	                        // 緊急時治療開始年月日２の月を設定する。
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencymonth2", monthFormat.format(start));
	                        // 緊急時治療開始年月日２の日を設定する。
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencyday2", dayFormat.format(start));
	                    }
	
	                    // 緊急時治療開始年月日３
	                    if (QP001Util.isDate(VRBindPathParser.get("401013",
	                            emergencyMap))) {
	                        Date start = ACCastUtilities.toDate(VRBindPathParser
	                                .get("401013", emergencyMap));
	                        // 緊急時治療開始年月日３の和暦を設定する。
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergency.s3.emergencydate", eraFormat
	                                        .format(start));
	                        // 緊急時治療開始年月日３の和暦年を設定する。
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencyyear3", eraYearFormat.format(start));
	                        // 緊急時治療開始年月日３の月を設定する。
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencymonth3", monthFormat.format(start));
	                        // 緊急時治療開始年月日３の日を設定する。
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencyday3", dayFormat.format(start));
	                    }
	
	                    // 緊急時治療管理(再掲)を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h8.w4",
	                            pad(emergencyMap.get("401020"), 0));
	                    // 緊急時治療管理単位数を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h8.w10",
	                            pad(emergencyMap.get("401018"), 0));
	                    // 緊急時治療管理日数を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "tani", pad(
	                            emergencyMap.get("401019"), 2));
	
	                    // リハビリテーション点数を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h7.w4",
	                            pad(emergencyMap.get("401021"), 0));
	                    // 処置点数を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h6.w4",
	                            pad(emergencyMap.get("401022"), 0));
	                    // 手術点数を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h5.w4",
	                            pad(emergencyMap.get("401023"), 0));
	                    // 麻酔点数を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h4.w4",
	                            pad(emergencyMap.get("401024"), 0));
	                    // 放射線治療点数を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h3.w4",
	                            pad(emergencyMap.get("401025"), 0));
	                    // 合計を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h1.w4",
	                            pad(emergencyMap.get("401046"), 0));
	
	                    // 摘要を設定する。※摘要１～摘要２０までを「／」で連結し、出力。
	                    StringBuilder tekiyo = new StringBuilder();
	                    for (int j = 401026; j < 401046; j++) {
	                        if (!ACTextUtilities.isNullText(VRBindPathParser.get(
	                                ACCastUtilities.toString(j), emergencyMap))) {
	                            tekiyo.append(VRBindPathParser.get(ACCastUtilities
	                                    .toString(j), emergencyMap));
	                            tekiyo.append("／");
	                        }
	                    }
	                    if (tekiyo.length() > 0) {
	                        tekiyo.deleteCharAt(tekiyo.length() - 1);
	                    }
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h6.w10",
	                            tekiyo.toString());
	                    // 往診日数を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "oushintimes", pad(
	                            emergencyMap.get("401014"), 2));
	                    // 往診医療機関名を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, emergencyMap,
	                            "401015", "emergency.h2.w3");
	                    // 通院日数を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "tuuintimes", pad(
	                            emergencyMap.get("401016"), 2));
	                    // 通院医療機関を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, emergencyMap,
	                            "401017", "emergency.h2.w16");
	                
                    }

                    // 特定診療費情報レコード順次番号が01のレコードの傷病名を設定する。
                    // 01のレコードがない場合は99のレコードの値を採用する。
                    ACChotarouXMLUtilities.setValue(writer, diagnosisFirstMap, "501008", "tokuteishinryo.syoubyo.w4");
                    
                    if(diagnosisLastMap != null){ 
                        //特定診療費の保険分単位数の合計を設定する。 ※特定診療費情報レコード順次番号が99の値を採用する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryohokentanitotal", pad(diagnosisLastMap.get("501013"),5));
                        
                        switch(kohiCount){
                        case 0:
                            //特定診療費の公費分単位数の合計を設定する。　※特定診療費情報レコード順次番号が99の値を採用する。
                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501016"),5));
                            break;
                        case 1:
                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501019"),5));
                            break;
                        case 2:
                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501022"),5));
                            break;
                        }
                    }
                    
                    /* ============================================================================= */
                    /* 請求額集計欄 */
                    /* ============================================================================= */

                    // 保険分
                    // 計画単位数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "plantani", pad(
                            typeMap.get("701009"), 6));
                    // 限度額管理対象単位数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "limitin", pad(
                            typeMap.get("701010"), 6));
                    // 限度額管理対象外単位数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "limitout", pad(
                            typeMap.get("701011"), 6));
                    // 給付点数・単位数（保険分）を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "hokentani", pad(
                            typeMap.get("701014"), 6));
                    // 点数・単位数単価を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "tanka",
                            getTanka(typeMap.get("701015")));

                    if (kohiCount == 0) {
                        // 給付率（保険分）を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "hokenkyuhu",
                                pad(baseMap.get("201029"), 3));
                        // 保険請求額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu",
                                pad(typeMap.get("701016"), 6));
                        // 保険利用者負担額を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "hokenriyosyafutan", pad(typeMap.get("701017"),
                                        6));
                    }

                    // 公費分
                    switch (kohiCount) {
                    case 0:
                        // 公費サービス単位数
                        ACChotarouXMLUtilities.setValue(writer, "kohitani",
                                pad(typeMap.get("701018"), 6));
                        // 給付点数・単位数（公費分）を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohikyufu",
                                pad(baseMap.get("201030"), 3));
                        // 公費請求額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu",
                                pad(typeMap.get("701019"), 6));
                        // 公費利用者負担額を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohiriyosyafutan", pad(typeMap.get("701020"),
                                        6));
                        break;
                    case 1:
                        // 公費サービス単位数
                        ACChotarouXMLUtilities.setValue(writer, "kohitani",
                                pad(typeMap.get("701021"), 6));
                        // 給付点数・単位数（公費分）を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohikyufu",
                                pad(baseMap.get("201031"), 3));
                        // 公費請求額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu",
                                pad(typeMap.get("701022"), 6));
                        // 公費利用者負担額を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohiriyosyafutan", pad(typeMap.get("701023"),
                                        6));
                        break;
                    case 2:
                        //公費サービス単位数
                        ACChotarouXMLUtilities.setValue(writer, "kohitani",
                                pad(typeMap.get("701024"), 6));
                        //給付点数・単位数（公費分）を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohikyufu",
                                pad(baseMap.get("201032"), 3));
                        //公費請求額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu",
                                pad(typeMap.get("701025"), 6));
                        //公費利用者負担額を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohiriyosyafutan", pad(typeMap.get("201053"),
                                        6));
                        break;
                    }

                    //請求額集計欄 保険分特定治療====================================
                    if (ACCastUtilities.toInt(typeMap.get("701027"), 0) != 0) {
                        // 給付点数・単位数（保険分特定治療）を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "hokentokuteitani", pad(typeMap.get("701027"),
                                        6));

                        if (kohiCount == 0) {
                            // 給付率（保険分）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "hokentokuteikyuhu", pad(baseMap
                                            .get("201029"), 3));
                            // 請求額（保険分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "hokentokuteiseikyu", pad(typeMap
                                            .get("701028"), 6));
                            // 本人負担額（保険分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "hokentokuteiriyousyahutan", pad(typeMap
                                            .get("701029"), 6));
                        }
                    }

                    //請求額集計欄 公費分特定治療====================================
                    switch (kohiCount) {
                    case 0:
                        if (ACCastUtilities.toInt(typeMap.get("701030"), 0) != 0) {
                            // 給付点数・単位数（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteitani", pad(typeMap
                                            .get("701030"), 6));
                            //給付率（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteikyuhu", pad(baseMap
                                            .get("201030"), 3));
                            // 請求額（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteiseikyu", pad(typeMap
                                            .get("701031"), 6));
                            // 利用者負担額（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteiriyousyahutan", pad(typeMap
                                            .get("701032"), 6));
                        }
                        break;
                    case 1:
                        if (ACCastUtilities.toInt(typeMap.get("701033"), 0) != 0) {
                            // 給付点数・単位数（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteitani", pad(typeMap
                                            .get("701033"), 6));
                            //給付率（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteikyuhu", pad(baseMap
                                            .get("201031"), 3));
                            // 請求額（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteiseikyu", pad(typeMap
                                            .get("701034"), 6));
                            // 利用者負担額（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteiriyousyahutan", pad(typeMap
                                            .get("701035"), 6));
                        }
                        break;
                    case 2:
                        if (ACCastUtilities.toInt(typeMap.get("701033"), 0) != 0) {
                            // 給付点数・単位数（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteitani", pad(typeMap
                                            .get("701036"), 6));
                            //給付率（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteikyuhu", pad(baseMap
                                            .get("201032"), 3));
                            // 請求額（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteiseikyu", pad(typeMap
                                            .get("701037"), 6));
                            // 利用者負担額（公費分特定治療）を設定する。
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteiriyousyahutan", pad(typeMap
                                            .get("701038"), 6));
                        }
                        break;
                    }

                    //特定入所者の合計を設定する。
                    if ((nursingLast != null) && (0 == kohiCount)) {
                        //費用額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "tokuteihiyototal", pad(nursingLast
                                        .get("801022"), 6));
                        //保険者負担額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "tokuteihokentotal", pad(nursingLast
                                        .get("801023"), 6));
                        //保険分請求額を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                        		//[ID:0000449][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
                                //"tokuteiriyoshatotal", pad(nursingLast
                        		"tokuteiriyoshatotal", pad0(nursingLast
                        		//[ID:0000449][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応
                                        .get("801024"), 5));
                    }
                    
                    
                    
                    //保険分特定診療費
                    
                    
                }
                

                //印刷ページ総数が2枚以上の場合
                //if ((kohiCountTotal * pageCount) > 1) {
                if ((pageCountMax) > 1) {
                    //出力ページ数の総数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
                            ACCastUtilities
                                    .toString((pageCountMax)));
                    //現在の出力ページ数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "nowpage",
                            ACCastUtilities.toString(printPage));
                }
                //ページ終了
                writer.endPageEdit();
            }
        }

        //印刷を実行したならばtrueを返す。
        return true;
    }
    //[H20.5 法改正対応] fujihara add end


}
