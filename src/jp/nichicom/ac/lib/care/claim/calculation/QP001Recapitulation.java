
/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKAACHO（JMA care benefit management software）
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
 * 作成日: 2005/12/06  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績確定/請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 摘要欄制御モジュール (QP001Recapitulation)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 摘要欄出力文字列作成クラス
 *
 */
public class QP001Recapitulation {
    
    /**
     * 摘要欄に出力する文字列
     */
    private String tekiyo = null;
    /**
     * 割引率
     */
    private String reductRate = null;
    /**
     * サービス種類コード
     */
    private String serviceCodeKind = null;
    /**
     * サービス項目コード
     */
    private String serviceCodeItem = null;
    /**
     * システム内サービス種類コード
     */
    private String systemServiceKindDetail = null;
    /**
     * システム内サービス項目コード
     */
    private String systemServiceCodeItem = null;
    
    /**
     * 多床室にチェックが付いているかのフラグ
     */
    private boolean multiFloorFoom = false;
    
    /**
     * 本体報酬フラグ(0:本体報酬以外、1:本体報酬)
     */
    private int serviceMainFlag = 0;
    
    /**
     * 摘要記載事項の解析を行う
     * @param serviceDetail
     * @param serviceCode
     * @throws Exception
     */
    public void setRecapitulation(VRMap serviceDetail, VRMap serviceCode,QP001Manager manager) throws Exception {
        
        Date target = ACCastUtilities.toDate(VRBindPathParser.get("SERVICE_DATE",serviceDetail));
        // 事業所番号を取得する。
        String providerId = ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID", serviceDetail),"");
        // サービス種類コード
        serviceCodeKind = ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode),"");
        // サービス項目コード
        serviceCodeItem = ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_ITEM", serviceCode),"");
        //システム内サービス種類コード
        systemServiceKindDetail = ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", serviceCode),"");
        //システム内サービス項目コード
        systemServiceCodeItem = ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM", serviceCode),"");
        //多床室フラグ
        //multiFloorFoom = QP001SpecialCase.isMultiFloorRoom(serviceDetail);
        multiFloorFoom = QP001SpecialCase.isMultiFloorRoom(serviceCode);
        //本体報酬であるかのフラグ
        serviceMainFlag = ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_MAIN_FLAG",serviceDetail), 0);
        
        if(tekiyo != null){
            return;
        }
        
        //[ID:0000721][Shin Fujihara] 2012/04 add start 2012年度対応
        //看取り・ターミナル提供時は摘要欄に日付を登録
        //※2012年4月の法改正時、各所に点在していた処理を一元化
        if (QP001SpecialCase.isMitori(serviceCodeKind, serviceCodeItem)) {
            tekiyo = String.valueOf(VRDateParser.format(target,"yyyyMMdd"));
        }
        //[ID:0000721][Shin Fujihara] 2012/04 add end 2012年度対応
        
        
        /*
         * ■訪問介護
         * ・身体介護４時間以上の場合
         * 計画上の所要単位を分単位で記載すること。
         * 例 260分
         * 単位を省略することも可。
         * 例 260
         * 【備考】
         * 身体介護４時間異常については、１回あたりの点数の根拠を所要時間にて示すこと。
         * 【プログラム中の解釈】
         *         サービス種類コードが'11'
         *         かつ
         *         SYSTEM_SERVICE_CODE_ITEM
         *         の2番目の文字が9以上のものが対象。
         */
        //サービス種類コードが11
        if("11".equals(serviceCodeKind)){
            //システムサービス種類コードの2番目の文字が9以上のもの
            if(systemServiceCodeItem.length() > 2){
                switch(systemServiceCodeItem.toCharArray()[1]){
                //4時間以上4時間半未満
                case '9':
//                    tekiyo = "240";
//                    break;
                //4時間半以上5時間未満
                case 'A':
//                    tekiyo = "270";
//                    break;
                //5時間以上5時間半未満
                case 'B':
//                    tekiyo = "300";
//                    break;
                //5時間半以上6時間未満
                case 'C':
//                    tekiyo = "330";
//                    break;
                //6時間以上6時間半未満
                case 'D':
//                    tekiyo = "360";
//                    break;
                //6時間半以上7時間未満
                case 'E':
//                    tekiyo = "390";
//                    break;
                //7時間以上7時間半未満
                case 'F':
//                    tekiyo = "420";
//                    break;
                //7時間半以上8時間未満
                case 'G':
//                    tekiyo = "450";
//                    break;
                //8時間以上8時間半未満
                case 'H':
//                    tekiyo = "480";
//                    break;
                //8時間半以上9時間未満
                case 'I':
//                    tekiyo = "510";
//                    break;
                //9時間以上9時間半未満
                case 'J':
//                    tekiyo = "540";
//                    break;
                //9時間半以上10時間未満
                case 'K':
//                    tekiyo = "570";
//                    break;
                //10時間以上10時間半未満
                case 'L':
//                    tekiyo = "600";
//                    break;
                //10時間半以上11時間未満
                case 'M':
//                    tekiyo = "630";
//                    break;
                //11時間以上11時間半未満
                case 'N':
//                    tekiyo = "660";
//                    break;
                //11時間半以上12時間未満
                case 'O':
//                    tekiyo = "690";
//                    break;
                //12時間以上12時間半未満
                case 'P':
//                    tekiyo = "720";
//                    break;
                //12時間半以上13時間未満
                case 'Q':
//                    tekiyo = "750";
//                    break;
                //13時間以上13時間半未満
                case 'R':
//                    tekiyo = "780";
//                    break;
                //13時間半以上14時間未満
                case 'S':
//                    tekiyo = "810";
//                    break;
                //14時間以上14時間半未満
                case 'T':
//                    tekiyo = "840";
//                    break;
                //14時間半以上15時間未満
                case 'U':
//                    tekiyo = "870";
//                    break;
                //15時間以上15時間半未満
                case 'V':
//                    tekiyo = "900";
//                    break;
                //15時間半以上16時間未満
                case 'W':
//                    tekiyo = "930";
//                    break;
                //16時間以上16時間半未満
                case 'X':
//                    tekiyo = "960";
//                    break;
                //16時間半以上17時間未満
                case 'Y':
//                    tekiyo = "990";
//                    break;
                //17時間以上17時間半未満
                case 'Z':
//                    tekiyo = "1020";
//                    break;
                //17時間半以上18時間未満
                case 'a':
//                    tekiyo = "1050";
//                    break;
                //18時間以上18時間半未満
                case 'b':
//                    tekiyo = "1080";
//                    break;
                //18時間半以上19時間未満
                case 'c':
//                    tekiyo = "1110";
//                    break;
                //19時間以上19時間半未満
                case 'd':
//                    tekiyo = "1140";
//                    break;
                //19時間半以上20時間未満
                case 'e':
//                    tekiyo = "1170";
//                    break;
                //20時間以上20時間半未満
                case 'f':
//                    tekiyo = "1200";
//                    break;
                //20時間半以上21時間未満
                case 'g':
//                    tekiyo = "1230";
//                    break;
                //21時間以上21時間半未満
                case 'h':
//                    tekiyo = "1260";
//                    break;
                //21時間半以上22時間未満
                case 'i':
//                    tekiyo = "1290";
//                    break;
                //22時間以上22時間半未満
                case 'j':
//                    tekiyo = "1320";
//                    break;
                //22時間半以上23時間未満
                case 'k':
//                    tekiyo = "1350";
//                    break;
                //23時間以上23時間半未満
                case 'l':
//                    tekiyo = "1380";
//                    break;
                //23時間半以上24時間未満
                case 'm':
//                    tekiyo = "1410";
//                    break;
                    Date start = ACCastUtilities.toDate(serviceDetail.get("3"),null);
                    Date end = ACCastUtilities.toDate(serviceDetail.get("4"),null);
                    
                    if((start != null) && (end != null)){
                        int startTime = ACDateUtilities.getHourOfDay(start) * 60 + ACDateUtilities.getMinute(start);
                        int endTime = ACDateUtilities.getHourOfDay(end) * 60 + ACDateUtilities.getMinute(end);
                        if(startTime >= endTime){
                            //時間が逆転している場合は、終了時間を一日進める
                            endTime += 24 * 60;
                        }
                        int outPutTime = endTime - startTime;
                        //出力する値が4時間を越えているか確認する。
                        if(4 * 60 <= outPutTime){
                            tekiyo = String.valueOf(outPutTime);
                        }
                    }
                    break;
                }
            }
        }
        
        
        //訪問看護
        if ("13".equals(serviceCodeKind)) {
            //退院時共同指導加算
            if ("4003".equals(serviceCodeItem)) {
                //[ID:0000737][Shin Fujihara] 2012/05/07 edit begin 平成24年4月法改正対応
                //摘要欄の記載を年月日から月日に変更
                //tekiyo = String.valueOf(VRDateParser.format(target,"yyyyMMdd"));
                tekiyo = String.valueOf(VRDateParser.format(target,"MMdd"));
                //[ID:0000737][Shin Fujihara] 2012/05/07 edit end
            }
        }
        
        
        //福祉用具の適用設定
        if("17".equals(serviceCodeKind) || "67".equals(serviceCodeKind)){
	        if(serviceDetail.containsKey("1170104")){
	            
	            
	            //システム内サービス種類コードが2から始まっている場合は、
	            //特別地域加算のレコード
	        	//[ID:0000447][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
	            //if(systemServiceCodeItem.startsWith("2")){
	        	//判断基準を変更
	        	//サービス項目コードが8で始まっている場合は、特別地域・中山間
	        	if(serviceCodeItem.startsWith("8")){
	            //[ID:0000447][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
	                /*
	                 * ■福祉用具
	                 * ・特別地域加算を算定する場合
	                 * 特別地域加算を算定する場合福祉用具貸与を開始した日付を記載すること。
	                 * 例　6日
	                 * 単位を省略することも可。
	                 * 例　6
	                 * 【プログラム中の解釈】
	                 * サービスコードの特別地域加算を直接参照
	                 */
	                tekiyo = String.valueOf(ACDateUtilities.getDayOfMonth(target));
	            } else {
	                //画面上の福祉用具摘要欄に入力がある場合
	                if(!ACTextUtilities.isNullText(serviceDetail.get("1170104"))){
	                    //摘要欄に福祉用具の摘要欄に入力された値を入力する。
	                    tekiyo = ACCastUtilities.toString(serviceDetail.get("1170104"));
	                }
	            }
	        }
        }
        
        /*
         * ■特定施設入居者生活介護、介護予防特定施設入居者生活介護
         * ・外部サービス利用型における福祉用具貸与、介護予防福祉用具貸与
         * 【プログラム中の解釈】
         * 画面上に入力された値を参照
         */
        //サービス種類コードが33であり
        if("33".equals(serviceCodeKind)){
            //システム内サービス種類コードが27から始まり
            if(systemServiceCodeItem.startsWith("27")){
                //摘要欄に入力されている項目がある場合
                if(serviceDetail.containsKey("1330120")){
                    //摘要欄に外部利用福祉用具の摘要欄に入力された値を設定する。
                    tekiyo = ACCastUtilities.toString(serviceDetail.get("1330120"));
                }
            }
        }
        
        //サービス種類コードが35であり
        if("35".equals(serviceCodeKind)){
            //システム内サービス種類コードが27から始まり
            if(systemServiceCodeItem.startsWith("27")){
                //摘要欄に入力されている項目がある場合
                if(serviceDetail.containsKey("1170104")){
                    //摘要欄に外部利用福祉用具の摘要欄に入力された値を設定する。
                    tekiyo = ACCastUtilities.toString(serviceDetail.get("1170104"));
                }
            }
        }
        
        //[ID:0000737][Shin Fujihara] 2012/05/07 add begin 平成24年4月法改正対応
        //介護保険施設
        if ("52".equals(serviceCodeKind)) {
            //保健施設地域連携診療計画加算１、保健施設地域連携診療計画加算２
            if ("6136".equals(serviceCodeItem)
             || "6137".equals(serviceCodeItem)) {
                tekiyo = String.valueOf(VRDateParser.format(target,"yyyyMMdd"));
            }
        }
        
        //予防訪問看護
        if ("63".equals(serviceCodeKind)) {
            //予防訪問看護退院時共同指導加算
            if ("4003".equals(serviceCodeItem)) {
                tekiyo = String.valueOf(VRDateParser.format(target,"MMdd"));
            }
        }
        //[ID:0000737][Shin Fujihara] 2012/05/07 add end
        
        /*
         * ■介護福祉施設サービス、地域密着介護老人福祉施設サービス
         * ・退所前後訪問相談援助加算
         * 家庭等への訪問日を記載すること
         * 例　20日
         * 単位を省略することも可。
         * 例　20
         * 【プログラム中の解釈】
         * SYSTEM_SERVICE_CODE_ITEMが
         * 'Z6501'のものを計上
         * 
         * ■介護保険施設サービス
         * ・退所前後訪問相談援助加算
         * 家庭等への訪問日を記載すること
         * 例　20日
         * 単位を省略することも可。
         * 例　20
         * 【プログラム中の解釈】
         * SYSTEM_SERVICE_CODE_ITEMが
         * 'Z6501'のものを計上
         */
        //[ID:0000584][Shin Fujihara] 2010/01 del begin 2009年度対応
        /*
        if("Z6501".equals(systemServiceCodeItem)){
            tekiyo = String.valueOf(ACDateUtilities.getDayOfMonth(target));
        }
        */
        //[ID:0000584][Shin Fujihara] 2010/01 del end 2009年度対応
        
        /*
         * ■介護療養施設サービス
         * ・退院前後訪問指導加算
         * 家庭等への訪問日を記載すること
         * 例　20日
         * 単位を省略することも可。
         * 例　20
         * 【プログラム中の解釈】
         * SYSTEM_SERVICE_CODE_ITEMが
         * 'Z2851'
         * 'Z3851'
         * 'Z4851'
         * のものを計上
         */
        //[ID:0000584][Shin Fujihara] 2010/01 del begin 2009年度対応
        /*
        if("Z2851".equals(systemServiceCodeItem)
           || "Z3851".equals(systemServiceCodeItem)
           || "Z4851".equals(systemServiceCodeItem)){
            tekiyo = String.valueOf(ACDateUtilities.getDayOfMonth(target));
        }
        */
        //[ID:0000584][Shin Fujihara] 2010/01 del end 2009年度対応
        
        /* 
         * 2008/01/07 [Masahiko Higuchi] add - begin 小規模多機能の摘要欄対応
         * 1730105
         */
        //サービス種類コードが73(小規模多機能)である
        if("73".equals(serviceCodeKind)){
            // 本体報酬のレコードに摘要欄を記載
            if (serviceMainFlag == 1) {
                // 日付部分を取り出す
                String detailValue = ACCastUtilities.toString(serviceDetail.getData("1730105"),"000000");
                // 0が6桁の場合は無視する
                if(!"000000".equals(detailValue)){
                    tekiyo = detailValue;
                }
            }
            
            //[ID:0000447][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
            if (tekiyo == null){
            	if (ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_ADD_FLAG", serviceCode), 0) == 1) {
                    // 日付部分を取り出す
                    String detailValue = ACCastUtilities.toString(serviceDetail.getData("1730105"),"000000");
                    // 0が6桁の場合は無視する
                    if(!"000000".equals(detailValue)){
                        tekiyo = detailValue;
                    }
            	}
            }
            //[ID:0000447][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
        }
        
        //サービス種類コードが75(予防小規模多機能)である
        if("75".equals(serviceCodeKind)){
            
            // 本体報酬のレコードに摘要欄を記載
            if (serviceMainFlag == 1) {
                // 日付部分を取り出す
                String detailValue = ACCastUtilities.toString(serviceDetail.getData("1750105"),"000000");
                // 0が6桁の場合は無視する
                if(!"000000".equals(detailValue)){
                    tekiyo = detailValue;
                }
            }
            
            //[ID:0000447][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
            if (tekiyo == null){
            	if (ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_ADD_FLAG", serviceCode), 0) == 1) {
                    // 日付部分を取り出す
                    String detailValue = ACCastUtilities.toString(serviceDetail.getData("1750105"),"000000");
                    // 0が6桁の場合は無視する
                    if(!"000000".equals(detailValue)){
                        tekiyo = detailValue;
                    }
            	}
            }
            //[ID:0000447][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
        }
        // 2008/01/07 [Masahiko Higuchi] add - end
        
        
        //[ID:0000737][Shin Fujihara] 2012/05/07 add begin 平成24年4月法改正対応
        //定期巡回・随時対応
        if ("76".equals(serviceCodeKind)) {
            //退院時共同指導加算
            if ("4003".equals(serviceCodeItem)) {
                tekiyo = String.valueOf(VRDateParser.format(target,"MMdd"));
            }
        }
        //[ID:0000737][Shin Fujihara] 2012/05/07 add end
        
        // サービス種類コードが77(複合型)である
        if("77".equals(serviceCodeKind)){
            
            // 本体報酬のレコードに摘要欄を記載
            if (serviceMainFlag == 1) {
                // 日付部分を取り出す
                String detailValue = ACCastUtilities.toString(serviceDetail.getData("1770117"),"00000000");
                // 0が8桁の場合は無視する
                if(!"00000000".equals(detailValue)){
                    tekiyo = detailValue;
                }
            }
            
            // 加算のみ算定の例外処理？　小規模多機能と仕様をそろえておく
            if (tekiyo == null){
                if (ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_ADD_FLAG", serviceCode), 0) == 1) {
                    // 日付部分を取り出す
                    String detailValue = ACCastUtilities.toString(serviceDetail.getData("1770117"),"00000000");
                    // 0が8桁の場合は無視する
                    if(!"00000000".equals(detailValue)){
                        tekiyo = detailValue;
                    }
                }
            }
            
            //[ID:0000737][Shin Fujihara] 2012/05/07 editbegin 平成24年4月法改正対応
            //複合型退院時共同指導加算
            if ("4003".equals(serviceCodeItem)) {
                tekiyo = String.valueOf(VRDateParser.format(target,"MMdd"));
            }
            //[ID:0000737][Shin Fujihara] 2012/05/07 edit end
            
        }
        
        
        //該当サービスの割引率を取得
        //int rate = QP001Manager.getInstance().getReductRate(providerId,serviceCode);
        int rate = manager.getReductRate(providerId,serviceCode);
        //割引率が存在する場合
        if(rate != 0){
            //割引率に取得した値を設定する。
            reductRate = String.valueOf(rate) + "%";
        }
    }
    
    /**
     * 摘要記載事項を取得する。
     * @param realDays サービス実日数リスト
     * @return 作成した摘要欄記載項目
     * @throws Exception
     */
    public String getRecapitulation(VRList realDays	,QP001PatientState patientState) throws Exception {
        String result = "";
        
        
        /*
         * ■訪問リハビリテーション、介護予防訪問リハビリテーション
         * ・短期集中リハビリテーション実施加算を算定する場合
         * 病院若しくは診療所または介護保険施設から退院・退所した年月日又は要介護・要支援認定を
         * 受けた日を記載すること。
         * 例　20060501
         * （退院（所）日が2006年5月1日の場合）
         * 【プログラム中の解釈】
         * サービスコード
         * 145001、145002
         * のものを計上
         */
        //前月の請求の摘要欄に記載がある場合には、それを採用する。
        if("14".equals(serviceCodeKind)){
            if("5001".equals(serviceCodeItem) || "5002".equals(serviceCodeItem)){
            	result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
            }
        }
        if("64".equals(serviceCodeKind)){
        	if("5001".equals(serviceCodeItem)){
        		result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
        	}
        }
        
        
        /*
         * ■通所リハビリテーション
         * ・短期集中リハビリテーション実施加算を算定する場合
         * 病院若しくは診療所または介護保険施設から退院・退所した年月日又は要介護・要支援認定を
         * 受けた日を記載すること。
         * 例　20060501
         * （退院（所）日が2006年5月1日の場合）
         * 【プログラム中の解釈】
         * サービスコードが
         * 165602
         * 165603
         * 165604
         * のものを計上
         * ・重度療養管理加算を算定する場合
         * 165610
         */
        //前月の請求の摘要欄に記載がある場合には、それを採用する。
        if("16".equals(serviceCodeKind)){
            //[CCCX:1616,2096][Shinobu Hitaka] 2014/11/25 add 「5610：重度療養管理加算」を追加
            //if("5602".equals(serviceCodeItem) || "5603".equals(serviceCodeItem) || "5604".equals(serviceCodeItem)){
            // [H27.4改正対応][Shinobu Hitaka] 2015/2/27 edit - begin 廃止＆追加コード対応
            //if("5602".equals(serviceCodeItem) || "5603".equals(serviceCodeItem) || "5604".equals(serviceCodeItem) || "5610".equals(serviceCodeItem)){
            if("5613".equals(serviceCodeItem) || "5610".equals(serviceCodeItem)){
            	result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
            }
        }
        
        //[CCCX:1616,2096][Shinobu Hitaka] 2014/11/25 add begin 「6278：重度療養管理加算1、6279：重度療養管理加算2」を追加
        /*
         * ■短期入所療養介護（老健）
         * ・重度療養管理加算を算定する場合
         * 
         * 利用者（要介護４又は要介護５）の状態（イからリまで）を記載すること。
         */
        //前月の請求の摘要欄に記載がある場合には、それを採用する。
        if("22".equals(serviceCodeKind)){
        	if("6278".equals(serviceCodeItem) || "6279".equals(serviceCodeItem)){
        		//重度療養管理加算１、重度療養管理加算２
        		result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
        	}
        }
        //[CCCX:1616,2096][Shinobu Hitaka] 2014/11/25 add end   「6278：重度療養管理加算1、6279：重度療養管理加算2」を追加
        
        /*
         * ■短期入所生活介護
         * 　予防短期入所生活介護
         * 　短期入所療養介護
         * 　予防短期入所療養介護
         * 　介護福祉施設
         * 　地域密着介護福祉施設
         * 　介護保険施設
         * 　介護療養施設
         * 
         * 多床室のサービスコードの適用理由
         * 適用理由の番号を摘要欄に左詰で記載すること。
         * １　多床室入所
         * ３　感染症等により医師が必要と判断した従来型個室への入所者
         * ４　居住面積が一定以下
         * ５　著しい精神症状等により医師が必要と判断した従来型個室への入所者
         */
        //前月の請求の摘要欄に記載がある場合には、それを採用する。
        if(multiFloorFoom){
        	result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
        }
        
        
        /*
         * ■介護保険施設
         * ・短期集中リハビリテーション実施加算、認知症短期集中リハビリテーション実施加算を算定する場合
         * 
         * 当該施設に入所した日を記載すること。
         * 例　20060501
         * （入所日が2006年5月1日の場合）
         */
        //前月の請求の摘要欄に記載がある場合には、それを採用する。
        if("52".equals(serviceCodeKind)){
        	if("6252".equals(serviceCodeItem) || "6253".equals(serviceCodeItem)){
        		//短期集中リハビリテーション実施加算
        		result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
        	}
        }
        
        //[ID:0000464][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
        /*
         * ■小規模多機能
         * 
         * 事業所開始時加算の摘要欄に事業所の開始日を記載する必要があるが、
         * この項目に関しては前月以前の直近の摘要欄から引継ぎ処理を行う
         */
        //
        if("73".equals(serviceCodeKind) || "75".equals(serviceCodeKind)){
        	//6139:小規模多機能型事業開始支援加算I
        	//6140:小規模多機能型事業開始支援加算II
        	if("6139".equals(serviceCodeItem) || "6140".equals(serviceCodeItem)){
        		result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
        	}
        }
        //[ID:0000464][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
        
        //[ID:0000696][Shin Fujihara] 2012/03 add begin 平成24年4月法改正対応
        /*
         * ■複合型サービス
         * 
         * 事業所開始時加算の摘要欄に事業所の開始日を記載する必要があるが、
         * この項目に関しては前月以前の直近の摘要欄から引継ぎ処理を行う 
         */
        if("77".equals(serviceCodeKind)){
            //6139:複合型事業開始支援加算
            if("6139".equals(serviceCodeItem)){
                result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
            }
        }
        //[ID:0000696][Shin Fujihara] 2012/03 add end 平成24年4月法改正対応
        
        /*
         * ■居宅療養管理指導、介護予防居宅居宅療養管理指導
         * ・算定回数に応じて居宅訪問日等を記載すること（訪問日が複数あるときは「、」で区切る）。
         * 例　6、20日
         * 単位を省略することも可。
         * 例　6、20
         * 【プログラム中の解釈】
         * サービス種類が
         * 31
         * 
         * ■介護療養施設サービス
         * ・他科受診時費用
         * 他科受診を行った日を記載すること（複数日行われたときは「、」で区切る）。
         * 例　6、20日
         * 単位を省略することも可。
         * 例　6、20
         * 【プログラム中の解釈】
         * isTakajyusin関数を使用し、判断
         * 
         */
        boolean daysUniting = false;
        
        //訪問看護
        if("13".equals(serviceCodeKind)){
            //看護・介護職員連携強化加算
            if ("4004".equals(serviceCodeItem)){
                daysUniting = true;
            }
        }
        
        //居宅療養管理指導
        if("31".equals(serviceCodeKind)){
            daysUniting = true;
        }
        //介護予防居宅療養管理指導
        if("34".equals(serviceCodeKind)){
            daysUniting = true;
        }
        //他科受診
        if("53".equals(serviceCodeKind)){
            if("2831".equals(serviceCodeItem)
               || "3831".equals(serviceCodeItem)
               || "4831".equals(serviceCodeItem)){
                daysUniting = true;
            }
        }
        
        
        /* ■介護老人福祉施設、地域密着型介護老人福祉施設
         * 退所前訪問相談援助加算、退所後訪問相談援助加算のチェック
         */
        if ("51".equals(serviceCodeKind)
            || "54".equals(serviceCodeKind)) {
            
            //退所前訪問相談援助加算(6501)、退所後訪問相談援助加算(6504)
            if("6501".equals(serviceCodeItem) || "6504".equals(serviceCodeItem)){
                daysUniting = true;
            }
        }
        
        
        /* ■介護保健施設サービス
         * 退所前訪問指導加算、退所後訪問指導加算のチェック
         */
        if ("52".equals(serviceCodeKind)) {
                
            //保健施設退所前訪問指導加算１(6501)、保健施設退所前訪問指導加算２(6506)
            //保健施設退所後訪問指導加算１(6507)、保健施設退所後訪問指導加算２(6508)
            //保健施設老人訪問看護指示加算(6503)
            if("6501".equals(serviceCodeItem)
                || "6506".equals(serviceCodeItem)
                || "6507".equals(serviceCodeItem)
                || "6508".equals(serviceCodeItem)
                || "6503".equals(serviceCodeItem)){
                daysUniting = true;
            }
        }
        
        /* ■介護療養施設サービス
         * 退院前訪問指導加算、退院後訪問指導加算
         */
        if ("53".equals(serviceCodeKind)) {
            
            //療養型退院前訪問指導加算(2851)、療養型退院後訪問指導加算(2856)
            //診療所型退院前訪問指導加算(3851)、診療所型退院後訪問指導加算(3856)
            //認知症型退院前訪問指導加算(4851)、認知症型退院後訪問指導加算(4856)
            if("2851".equals(serviceCodeItem)
                || "2856".equals(serviceCodeItem)
                || "3851".equals(serviceCodeItem)
                || "3856".equals(serviceCodeItem)
                || "4851".equals(serviceCodeItem)
                || "4856".equals(serviceCodeItem)){
                daysUniting = true;
            }
        }
        
        
        //[ID:0000561][ID:0000591][Shin Fujihara] 2010/01 add begin 2009年度対応
        /* 看護指示加算のチェック
         サービスの提供日を、カンマ区切りで摘要欄に記載する
	     介護療養型医療施設（病院）：療養型老人訪問看護指示加算：Z2853
	     介護療養型医療施設（診療所）：診療所型老人訪問看護指示加算：Z3853
	     介護療養型医療施設（認知症）：認知症型老人訪問看護指示加算：Z4853 
	     */
        //コードはソート済みで宣言する必要あり。
        String[] codes = {"Z2853","Z3853","Z4853"};
        Arrays.sort(codes);
        if (Arrays.binarySearch(codes, systemServiceCodeItem) >= 0) {
        	daysUniting = true;
        }
        //[ID:0000561][ID:0000591][Shin Fujihara] 2010/01 add end 2009年度対応
        
        //居宅療養管理指導または他科受診
        if(daysUniting){
            
            //日付を並べなおす
            ArrayList<Integer> ary = new ArrayList<Integer>();
            for(int i = 0; i < realDays.size(); i++){
                Integer day = new Integer(ACDateUtilities.getDayOfMonth(ACCastUtilities.toDate(realDays.get(i))));
                if(!ary.contains(day)){
                    ary.add(day);
                }
            }
            
            Object[] oa = ary.toArray();
            Arrays.sort(oa);
            StringBuilder tekiyoTemp = new StringBuilder();
            
            for(int i = 0; i < oa.length; i++){
                if(tekiyoTemp.length() != 0){
                    tekiyoTemp.append(",");
                }
                tekiyoTemp.append(String.valueOf(oa[i]));
            }
            tekiyo = tekiyoTemp.toString();
        }
        
        
        if(tekiyo != null){
            result = tekiyo;
        }
        
        if(reductRate != null){
            if(result.length() > 0){
                result += "/";
            }
            result += reductRate;
        }
        
        return result;
    }
    
}
