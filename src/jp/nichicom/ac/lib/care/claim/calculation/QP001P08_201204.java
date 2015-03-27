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
 * プロセス 施設サービス等介護給付費明細書（介護福祉施設） (001)
 * プログラム 施設サービス等介護給付費明細書（介護福祉施設） (QP001P09)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 施設サービス等介護給付費明細書（介護福祉施設）(様式第八) - 帳票定義体ファイル名 ： QP001P080_YYYYMM.xml
 */
public class QP001P08_201204 extends QP001P02_10Event {
    
	/* 
	 * 様式第八 201204以降
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
    public QP001P08_201204() {
    }
    
    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P080_201204.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P080_201204";
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
        // 必要であれば帳票IDを書き換えること。
        //ACChotarouXMLUtilities.addFormat(writer, "QP001P09", "QP001P09.xml");

        // 基本情報レコード
        VRMap baseMap = getBaseMap();
        // 明細情報レコード集合
        VRList detailList = getDetailList();
        // 集計情報レコード
        VRMap typeMap = getTypeMap();
        // 特定入所者介護サービス情報レコード
        VRList nursingList = getNursingList();
        
        int detailsRecordCount = 10;
        
        VRMap nursingLast = getLastRecord(nursingList,"801007");
        // 社福減免レコード
        VRList reductionList = getReductionList();
        int pageCountMax = 0;
        int printPage = 1;
        // 公費件数ループ
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            parseStyle();
            // 明細情報レコード集合
            detailList = getDetailList();
            // 特定入所者介護サービス情報レコード
            nursingList = getNursingList();
            
            // 印刷頁数を算出する。（1頁あたりの明細情報は11件、特定入所者介護サービス費情報は4件)
            //特定入所者を印字しない場合があるので、毎回計算する。
            int pageCount = 1;
            int pageTemp = 1;

            if (detailList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / (double)detailsRecordCount);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if ((nursingList.getDataSize() > 0) && (nursingCount == kohiCount)){
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
            reductionList = getReductionList();
            
            // 印刷頁数を算出する。（1頁あたりの明細情報は11件、特定入所者介護サービス費情報は4件)
            //特定入所者を印字しない場合があるので、毎回計算する。
            int pageCount = 1;
            int pageTemp = 1;

            if (detailList.getDataSize() > 0) {
            	pageTemp = (int) Math.ceil((double) detailList.getDataSize() / (double)detailsRecordCount);
            	
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if ((nursingList.getDataSize() > 0) && (nursingCount == kohiCount)){
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 4d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }

            // 印刷ページ数分、ループする
            for (int i = 0; i < pageCount; i++,printPage++) {
                // ページ開始
                writer.beginPageEdit(getFormatId());

                // 帳票共通情報を設定
                setPrintHeader(kohiCount);
                
                setNyusyoDate();
                
                //入居前の状況を設定する
                setBeforeHospitalization();

                //旧措置入所
                switch(ACCastUtilities.toInt(baseMap.get("201016"),0)){
                    //旧措置なし
                    case 1:
                        ACChotarouXMLUtilities.setInvisible(writer,"kyusohciari");
                        break;
                    //旧措置あり
                    case 2:
                        ACChotarouXMLUtilities.setInvisible(writer,"kyusohcinashi");
                        break;
                    default:
                        ACChotarouXMLUtilities.setInvisible(writer,"kyusohcinashi");
                        ACChotarouXMLUtilities.setInvisible(writer,"kyusohciari");
                        break;
                }
                if(isDetailListShow(kohiCount)){
                	setDetailList(detailList, detailsRecordCount + 1, kohiCount);
                }


                // 特定入所者介護サービス件数分ループする。※4件を超える場合は、次ページに印字
                if(nursingCount == kohiCount){
                    for (int j = 1; j < 5; j++) {
                        if (nursingList.getDataSize() == 0) break;
                        
                        VRMap nursing = (VRMap) nursingList.get(0);
                        // サービス内容を設定する。
                        ACChotarouXMLUtilities.setValue(writer, nursing, "801034","tokuteimeisai.h" + j + ".w2");
                        // サービスコードを設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "tokuteiservicecode" + j, ACCastUtilities
                                        .toString(VRBindPathParser.get("801008",
                                                nursing))
                                        + ACCastUtilities.toString(VRBindPathParser
                                                .get("801009", nursing)));

                        //費用単価を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitani" + j, pad(VRBindPathParser.get("801010", nursing), 4));
                        //負担限度額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "dokuteilimit" + j, pad0NursingLimit(VRBindPathParser.get("801011", nursing), 4));
                        //日数を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitimes" + j, pad(VRBindPathParser.get("801012", nursing), 2));
                        //費用額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyo" + j, pad(VRBindPathParser.get("801016", nursing), 6));
                        //保険分金額を設定する。
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

                        
                        //利用者負担額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteiriyosha" + j, pad0(VRBindPathParser.get("801021", nursing), 5));
                        
                        nursingList.remove(0);
                    }
                }


                if (i == 0) {
                	if(isDetailListShow(kohiCount)){
	                    //サービス単位数の合計を設定する。(サービス単位数の合算)
	                    ACChotarouXMLUtilities.setValue(writer, "servicetimetotal",pad(String.valueOf(getServiceUnitTotal()),5));
	                    //公費対象単位数の合計を設定する。(公費対象単位数の合計)
	                    switch(kohiCount){
	                    case 0:
	                        ACChotarouXMLUtilities.setValue(writer, "kohitanitotal", pad(String.valueOf(getKohiTotal1()),5));
	                        //公費分単位数を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "kohibuntani", pad(typeMap.get("701018"),6));
	                        //公費請求額を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701019"),6));
	                        //公費分本人負担額を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "kohihonnin", pad(typeMap.get("701020"),6));
	                        break;
	                    case 1:
	                        ACChotarouXMLUtilities.setValue(writer, "kohitanitotal", pad(String.valueOf(getKohiTotal2()),5));
	                        //公費分単位数を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "kohibuntani", pad(typeMap.get("701021"),6));
	                        //公費請求額を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701022"),6));
	                        //公費分本人負担額を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "kohihonnin", pad(typeMap.get("701023"),6));
	                        break;
	                    case 2:
	                        ACChotarouXMLUtilities.setValue(writer, "kohitanitotal", pad(String.valueOf(getKohiTotal3()),5));
	                        //公費分単位数を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "kohibuntani", pad(typeMap.get("701024"),6));
	                        //公費請求額を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701025"),6));
	                        //公費分本人負担額を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "kohihonnin", pad(typeMap.get("7010246"),6));
	                        break;
	                    }
                    
	                    //給付単位数を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "kyufutani", pad(typeMap.get("701014"),6));
	                    
	                    //単位数単価を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "tanisutani", getTanka(typeMap.get("701015")));
	                    
	                    //公費給付率を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201030"),3));
	                    
	                    if(kohiCount == 0){
	                        //保険給付率を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "hokenkyufu", pad(baseMap.get("201029"),3));
	                        //保険請求額を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu", pad(typeMap.get("701016"),6));
	                        //利用者負担額を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "riyosyafutan", pad(typeMap.get("701017"),6));
	                    }
                	}
                    
                    if((nursingLast != null) && (nursingCount == kohiCount)){
                        //費用額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyototal",pad(nursingLast.get("801022"),6));
                        
                        //保険者負担額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,"tokuteihokentotal", pad(nursingLast.get("801023"),6));
                        //保険分請求額を設定する。
                        ACChotarouXMLUtilities.setValue(writer,"tokuteiriyoshatotal", pad0(nursingLast.get("801024"),5));
                        
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

                    //社福減免
                    if ((reductionList != null) && (reductionList.getDataSize() > 0)) {
                        
                        //軽減率を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "keigenritsu",
                                pad(VRBindPathParser.get("901007",(VRMap) reductionList.getData(0)), 4));
                        
                        for (int j = 0; j < reductionList.getDataSize(); j++) {
                            VRMap reduction = (VRMap) reductionList.getData(j);
                            // [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - begin サービスコード英数化
//                            switch (ACCastUtilities.toInt(VRBindPathParser.get(
//                                    "901008", reduction))) {
//                            case 51:
//                                //施設介護サービス費の利用者負担額の総額を設定する。 ※サービス種類レコード(901008)が51のレコードが対象
//                                ACChotarouXMLUtilities.setValue(writer, "jyuryo51",pad(reduction.get("901009"),6));
//                                //施設介護サービス費の軽減額を設定する。 ※サービス種類レコード(901008)が51のレコードが対象
//                                ACChotarouXMLUtilities.setValue(writer, "keigen51", pad(reduction.get("901010"),6));
//                                //施設介護サービス費の軽減後利用者負担額を設定する。 ※サービス種類レコード(901008)が51のレコードが対象
//                                ACChotarouXMLUtilities.setValue(writer, "keigengo51", pad(reduction.get("901011"),6));
//                                //施設介護サービス費の備考を設定する。 ※サービス種類レコード(901008)が21のレコードが対象
//                                ACChotarouXMLUtilities.setValue(writer, "syafuku.h2.w27", pad(reduction.get("901012"),6));
//                                break;
//                            case 54:
//                                //施設介護サービス費の利用者負担額の総額を設定する。 ※サービス種類レコード(901008)が51のレコードが対象
//                                ACChotarouXMLUtilities.setValue(writer, "jyuryo54",pad(reduction.get("901009"),6));
//                                //施設介護サービス費の軽減額を設定する。 ※サービス種類レコード(901008)が51のレコードが対象
//                                ACChotarouXMLUtilities.setValue(writer, "keigen54", pad(reduction.get("901010"),6));
//                                //施設介護サービス費の軽減後利用者負担額を設定する。 ※サービス種類レコード(901008)が51のレコードが対象
//                                ACChotarouXMLUtilities.setValue(writer, "keigengo54", pad(reduction.get("901011"),6));
//                                //施設介護サービス費の備考を設定する。 ※サービス種類レコード(901008)が21のレコードが対象
//                                ACChotarouXMLUtilities.setValue(writer, "syafuku.h3.w27", pad(reduction.get("901012"),6));
//                                break;
//                            }
                            String serviceCodeKind = ACCastUtilities.toString(VRBindPathParser.get("901008", reduction));
                        	if ("51".equals(serviceCodeKind)) {
								//施設介護サービス費の利用者負担額の総額を設定する。 ※サービス種類レコード(901008)が51のレコードが対象
								ACChotarouXMLUtilities.setValue(writer, "jyuryo51",pad(reduction.get("901009"),6));
								//施設介護サービス費の軽減額を設定する。 ※サービス種類レコード(901008)が51のレコードが対象
								ACChotarouXMLUtilities.setValue(writer, "keigen51", pad(reduction.get("901010"),6));
								//施設介護サービス費の軽減後利用者負担額を設定する。 ※サービス種類レコード(901008)が51のレコードが対象
								ACChotarouXMLUtilities.setValue(writer, "keigengo51", pad(reduction.get("901011"),6));
								//施設介護サービス費の備考を設定する。 ※サービス種類レコード(901008)が21のレコードが対象
								ACChotarouXMLUtilities.setValue(writer, "syafuku.h2.w27", pad(reduction.get("901012"),6));
                        	}
                        	if ("54".equals(serviceCodeKind)) {
	                            //施設介護サービス費の利用者負担額の総額を設定する。 ※サービス種類レコード(901008)が51のレコードが対象
	                            ACChotarouXMLUtilities.setValue(writer, "jyuryo54",pad(reduction.get("901009"),6));
	                            //施設介護サービス費の軽減額を設定する。 ※サービス種類レコード(901008)が51のレコードが対象
	                            ACChotarouXMLUtilities.setValue(writer, "keigen54", pad(reduction.get("901010"),6));
	                            //施設介護サービス費の軽減後利用者負担額を設定する。 ※サービス種類レコード(901008)が51のレコードが対象
	                            ACChotarouXMLUtilities.setValue(writer, "keigengo54", pad(reduction.get("901011"),6));
	                            //施設介護サービス費の備考を設定する。 ※サービス種類レコード(901008)が21のレコードが対象
	                            ACChotarouXMLUtilities.setValue(writer, "syafuku.h3.w27", pad(reduction.get("901012"),6));
                        	}
                            // [H27.4改正対応][Shinobu Hitaka] 2015/1/22 edit - end   サービスコード英数化
                            
                        }
                        

                    }
                }

                //印刷ページ総数が2枚以上の場合
                //if ((kohiCountTotal * pageCount) > 1) {
                if ((pageCountMax) > 1) {
                    //出力ページ数の総数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
                            ACCastUtilities.toString((pageCountMax)));
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

}
