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
 * プロセス 在宅サービス介護給付費明細書（短期入所生活介護） (001)
 * プログラム 在宅サービス介護給付費明細書（短期入所生活介護） (QP00104)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 在宅サービス介護給付費明細書（短期入所生活介護）(様式第三) -  帳票定義体ファイル名 ： QP001P03X_YYYYYMM.xml
 */
public class QP001P03_201804 extends QP001P02_10Event {

    /**
     * コンストラクタです。
     */
    public QP001P03_201804() {
    }

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
        // 明細情報レコード集合
        VRList detailList = getDetailList();
        // 集計情報レコード
        VRMap typeMap = getTypeMap();
        // 特定入所者介護サービス情報レコード
        VRList nursingList = getNursingList();
        
        VRMap nursingLast = getLastRecord(nursingList,"801007");
        
        // 社福減免レコード
        VRMap reductionMap = getReductionMap();

        // 印刷用情報格納用のVRArrayList printArrayを定義する。
        // printArrayに、渡りパラメータの KEY : PARAM の VALUE を設定する。
        // ※以下、printArrayに格納されているレコードを参照する。
        // ※複数公費の受給を受けている場合は、受給公費分帳票を出力する。
        
        // 印刷頁数を算出する。（1頁あたりの明細情報は10件、特定入所者介護サービス費情報は4件)
        // 特定入所者を印字しない場合があるので、毎回計算する。
        int pageCountMax = 0;
        int printPage = 1;
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            parseStyle();
            // 明細情報レコード集合
            detailList = getDetailList();
            // 特定入所者介護サービス情報レコード
            nursingList = getNursingList();
            
            int pageTemp = 1;
            int pageCount = 1;
            if (detailList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 10d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if ((nursingList.getDataSize() > 0) && (0 == kohiCount)) {
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 4d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            pageCountMax += pageCount;
        }

        // 公費件数ループ
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            parseStyle();
            // 基本情報レコード
            baseMap = getBaseMap();
            // 明細情報レコード集合
            detailList = getDetailList();
            // 集計情報レコード
            typeMap = getTypeMap();
            // 特定入所者介護サービス情報レコード
            nursingList = getNursingList();
            // 社福減免レコード
            reductionMap = getReductionMap();
            
            
            // 印刷頁数を算出する。（1頁あたりの明細情報は10件、特定入所者介護サービス費情報は4件)
            // 特定入所者を印字しない場合があるので、毎回計算する。
            int pageCount = 1;
            int pageTemp = 1;

            if (detailList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 10d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if ((nursingList.getDataSize() > 0) && (0 == kohiCount)) {
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 4d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
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
                    Date start = ACCastUtilities.toDate(baseMap.get("201024"));
                    // 入所年月日の和暦を設定する。
                    ACChotarouXMLUtilities.setValue(writer,
                            "nyusyodate.h2.w11", eraFormat.format(start));
                    // 入所年月日の和暦年(YYフォーマット)を設定する
                    ACChotarouXMLUtilities.setValue(writer, "nyusyoyear",
                            eraYearFormat.format(start));
                    // 入所年月日の月(MMフォーマット)を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "nyusyomonth",
                            monthFormat.format(start));
                    // 入所年月日の日(DDフォーマット)を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "nyusyoday",
                            dayFormat.format(start));
                }

                // 退所年月日の設定
                if (QP001Util.isDate(baseMap.get("201025"))) {
                    Date end = ACCastUtilities.toDate(baseMap.get("201025"));
                    // 退所年月日の和暦を設定する。
                    ACChotarouXMLUtilities.setValue(writer,
                            "taisyodate.h2.w11", eraFormat.format(end));
                    // 退所年月日の年(YYフォーマット)を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "taisyoyear",
                            eraYearFormat.format(end));
                    // 退所年月日の月(MMフォーマット)を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "taisyomonth",
                            monthFormat.format(end));
                    // 退所年月日の日(DDフォーマット)を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "taisyoday", dayFormat
                            .format(end));

                }
                // 短期入所の実日数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "tankijitsu", pad(typeMap.get("701013"), 2));

                //明細件数分ループする。※10件を超える場合は、次ページに印字
                setDetailList(detailList,11,kohiCount);

                
                // 特定入所者介護サービス件数分ループする。※4件を超える場合は、次ページに印字
                if(0 == kohiCount){
                    for (int j = 1; j < 5; j++) {
                        if (nursingList.getDataSize() == 0)
                            break;
                        VRMap nursing = (VRMap) nursingList.get(0);
                        // サービス内容を設定する。
                        ACChotarouXMLUtilities.setValue(writer, nursing, "801034",
                                "tokuteimeisai.h" + j + ".w2");
                        // サービスコードを設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "tokuteiservicecode" + j, ACCastUtilities
                                        .toString(VRBindPathParser.get("801008",
                                                nursing))
                                        + ACCastUtilities.toString(VRBindPathParser
                                                .get("801009", nursing)));

                        // 費用単価を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitani" + j,
                                pad(VRBindPathParser.get("801010", nursing), 4));
                        // 負担限度額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "dokuteilimit" + j,
                        		pad0NursingLimit(VRBindPathParser.get("801011", nursing), 4));
                        // 日数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitimes" + j,
                                pad(VRBindPathParser.get("801012", nursing), 2));
                        // 費用額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyo" + j,
                                pad(VRBindPathParser.get("801016", nursing), 6));
                        // 保険分金額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihoken" + j,
                                pad(VRBindPathParser.get("801017", nursing), 6));
                        // 利用者負担額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteiriyosha"
                                + j,
                                pad0(VRBindPathParser.get("801021", nursing), 5));

                        nursingList.remove(0);
                    }
                }

                // 用紙が一枚めの場合
                if (i == 0) {
                    
                    // サービス単位数の合計を設定する。(サービス単位数の合算)
                    ACChotarouXMLUtilities.setValue(writer, "servicetimetotal",
                            pad(String.valueOf(getServiceUnitTotal()), 5));
                    // 公費対象単位数の合計を設定する。(公費対象単位数の合計)
                    switch (kohiCount) {
                    case 0:
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohitanitotal", pad(String.valueOf(getKohiTotal1()), 5));
                        break;
                    case 1:
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohitanitotal", pad(String.valueOf(getKohiTotal2()), 5));
                        break;
                    case 2:
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohitanitotal", pad(String.valueOf(getKohiTotal3()), 5));
                        break;
                    }

                    // 計画単位数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "plantani", pad(
                            typeMap.get("701009"), 6));

                    // 限度額管理対象単位数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "limitin", pad(
                            typeMap.get("701010"), 6));
                    // 限度額管理対象外単位数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "limitout", pad(
                            typeMap.get("701011"), 6));
                    // 給付単位数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "kyufutani", pad(
                            typeMap.get("701014"), 6));

                    // 単位数単価を設定する。
                    // getTanka(VRBindPathParser.get("701015",type)
                    ACChotarouXMLUtilities.setValue(writer, "tanisutani",
                            getTanka(typeMap.get("701015")));
                    
                    if(kohiCount == 0){
                        // 保険給付率を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "hokenkyufu", pad(
                                baseMap.get("201029"), 3));
                        // 保険請求額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu", pad(
                                typeMap.get("701016"), 6));
                        // 利用者負担額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "riyosyafutan",
                                pad(typeMap.get("701017"), 6));
                    }


                    // 公費項番により分岐
                    switch (kohiCount) {
                    // 公費1
                    case 0:
                        //公費分単位数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohibuntani",
                                pad(typeMap.get("701018"), 6));
                        //公費給付率を設定する。
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201030",
                                                baseMap), 3));
                        //公費請求額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201040", baseMap), 6));
                        //公費分本人負担の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201041", baseMap), 6));
                        break;
                    //公費2
                    case 1:
                        //公費分単位数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohibuntani",
                                pad(typeMap.get("701021"), 6));
                        //公費給付率を設定する。
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201031",
                                                baseMap), 3));
                        //公費請求額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201046", baseMap), 6));
                        //公費分本人負担の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201047", baseMap), 6));
                        break;
                    //公費3
                    case 2:
                        //公費分単位数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohibuntani",
                                pad(typeMap.get("701024"), 6));
                        //公費給付率を設定する。
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201032",
                                                baseMap), 3));
                        //公費請求額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201052", baseMap), 6));
                        //公費分本人負担の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201053", baseMap), 6));
                        break;
                    }
                    
                    if((nursingLast != null) && (0 == kohiCount)){
                        //費用額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyototal",pad(nursingLast.get("801022"),6));
                        //保険者負担額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,"tokuteihokentotal", pad(nursingLast.get("801023"),6));
                        //保険分請求額を設定する。
                        ACChotarouXMLUtilities.setValue(writer,"tokuteiriyoshatotal", pad0(nursingLast.get("801024"),5));
                    }

                    //社福減免の情報を設定する。
                    doPrintReductionList(reductionMap);
                }
                //印刷ページ総数が2枚以上の場合
                if(pageCountMax > 1){
                    //出力ページ数の総数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
                            ACCastUtilities.toString((pageCountMax)));
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
    /**
     * 様式第四と様式第四の二の差分を補完する
     * @param printParam
     * @param reductionList
     * @throws Exception
     */
    public void doPrintReductionList(VRMap reductionMap) throws Exception{
        
    }

    public void addFormat() throws Exception {
        // TODO 自動生成されたメソッド・スタブ
        
    }

    public String getFormatId() throws Exception {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }
}
