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
 * 作成日: 2006/01/13  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 在宅サービス介護給付費明細書（居宅） (001)
 * プログラム 在宅サービス介護給付費明細書（居宅） (QP00103)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Collections;
import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACKanaConvert;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * 印刷イベント<br>
 * <br>
 * 在宅サービス介護給付費明細書（居宅）イベント定義-様式第二 <br>
 * <br>
 * 在宅サービス介護給付費明細書（短期入所生活介護）イベント定義-様式第三<br>
 * <br>
 * 在宅サービス介護給付費明細書（介護老人保健施設）イベント定義-様式第四<br>
 * <br>
 * (在宅サービス介護給付費明細書（病院・診療所における短期入所療養介護）)イベント定義-様式第五<br>
 * <br>
 * (在宅サービス介護給付費明細書（認知症対応型・特定施設入所者）イベント定義-様式第六<br>
 * <br>
 * 施設サービス等介護給付費明細書（介護福祉施設）イベント定義-様式第八<br>
 * <br>
 * 施設サービス等介護給付費明細書（介護老人保健施設）イベント定義-様式第九<br>
 * <br>
 * 施設サービス等介護給付費明細書（介護療養型施設)イベント定義-様式第十<br>
 * <br>
 */
public class QP001P02_10Event extends QP001PrintEvent {

    ACChotarouXMLWriter writer = null;

    int kohiCountTotal = 1;

    ACDateFormat eraFormat = new ACDateFormat("ggg");

    ACDateFormat eraYearFormat = new ACDateFormat("ee");

    ACDateFormat monthFormat = new ACDateFormat("MM");

    ACDateFormat dayFormat = new ACDateFormat("dd");

    // 請求日
    Date seikyuDate = null;

    // 請求情報
    private VRList styleList = null;

    // 利用者情報
    private VRMap patient = null;

    // 事業所情報
    private VRMap providerMap = null;

    private VRMap provider = null;

    // 基本情報レコード
    private VRMap baseMap = null;

    // 明細情報レコード（複数レコード）
    private VRList detailList = null;

    // 緊急時施設療養情報レコード（複数レコード）
    private VRList emergencyList = null;
    
    // 緊急時施設療養・自施設療養費情報レコード（複数レコード）
    private VRList emergencyOwnFacilityList = null;

    // 特定診療費情報レコード（複数レコード）
    private VRList diagnosisList = null;

    // 集計情報レコード（複数レコード）
    private VRList typeList = null;

    // 特定入所者介護サービス費用情報レコード（複数レコード）
    private VRList nursingList = null;

    // 社会福祉法人軽減額情報レコード（複数レコード）
    private VRList reductionList = null;
    
 // 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
 // 明細情報（住所地特例）レコード（複数レコード）
    private VRList detailJushotiTokureiList = null;
 // 2015/1/14 [Yoichiro Kamei] add - end

    // サービス単位数合計
    private int serviceUnitTotal = 0;
    // 公費１単位数合計
    private int kohiTotal1 = 0;
    // 公費２単位数合計
    private int kohiTotal2 = 0;
    // 公費３単位数合計
    private int kohiTotal3 = 0;
    
    //特定入所者を印字する公費カウントを保持
    int nursingCount = 0;
    
    
    //様式番号の印刷
    private boolean yoshikiBango = true;
    
    //[ID:0000449][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
    private boolean printNursingZero = false;
    //[ID:0000449][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
    //[ID:0000651][Shin Fujihara] 2011/07/06 add begin 負担限度額0円表示対応
    private boolean printNursingLimitZero = false;
    //[ID:0000651][Shin Fujihara] 2011/07/06 add end 負担限度額0円表示対応
    
    private VRMap serviceName = null;
    
    QP001Manager manager = null;
    
    //[H20.5 法改正対応] fujihara add start
    private int term = 0;
    //[H20.5 法改正対応] fujihara add end
    
    /**
     * コンストラクタです。
     */
    public QP001P02_10Event() {
    }

    /**
     * 印刷します。
     * 
     * @param writer
     *            印刷管理クラス
     * @param printParam
     *            印刷パラメタ
     * @throws Exception
     *             処理例外
     */
    public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam)
            throws Exception {

        //ライターを設定
        this.writer = writer;
        
        //------共通の印刷データを取得する----------------//
        // 印刷情報
        styleList = (VRList) printParam.get("STYLE_DATA");
        // 利用者情報
        patient = (VRMap) printParam.get("PATIENT");
        // 事業者情報
        providerMap = (VRMap) printParam.get("PROVIDERS");
        //サービス名称
        serviceName = (VRMap)printParam.get("SERVICE_NAME");
        
        manager = (QP001Manager)printParam.get("MANAGER");
        // データ解析
        parseStyle();

        //対象月
        seikyuDate = VRDateParser.parse(baseMap.get("201003") + "01");
        // 対象事業者(201004)
        provider = (VRMap) providerMap.get(baseMap.get("201004"));
        
        //[H20.5 法改正対応] fujihara add start
        term = QP001Util.getTerm(seikyuDate);
        //[H20.5 法改正対応] fujihara add end
        
        // 作成事業者(201019)
        // del sta 2006.05.14 shin.fujihara
        //provider_make = (VRMap) providerMap.get(baseMap.get("201020"));
        // del end 2006.05.14 shin.fujihara

        // 公費件数を取得する。
        // 公費2のデータが存在するか。
        if (!ACTextUtilities.isNullText(VRBindPathParser.get("201059",
                getBaseMap()))
                && (!"0".equals(String.valueOf(VRBindPathParser.get("201059", getBaseMap()))))) {
            kohiCountTotal = 2;
            
            //特定入所者印字対応
            //公費の適用がある場合、生保のみ印字を行う
            //[H20.5 法改正対応] fujihara edit start
            //生保、中国残留邦人等公費の場合のみ印字を行うよう修正
            //if("1201".equals(String.valueOf(VRBindPathParser.get("201059", getBaseMap())))){
            String kohiNo = String.valueOf(VRBindPathParser.get("201059", getBaseMap()));
            if("1201,2501".indexOf(kohiNo) != -1){
            //[H20.5 法改正対応] fujihara edit end
                nursingCount = 1;
            }
        }
        // 公費3のデータが存在するか。
        if (!ACTextUtilities.isNullText(VRBindPathParser.get("201060",
                getBaseMap()))
                && (!"0".equals(String.valueOf(VRBindPathParser.get("201060", getBaseMap()))))) {
            kohiCountTotal = 3;
            //特定入所者印字対応
            //公費の適用がある場合、生保のみ印字を行う
            //[H20.5 法改正対応] fujihara edit start
            //生保、中国残留邦人等公費の場合のみ印字を行うよう修正
            //if("1201".equals(String.valueOf(VRBindPathParser.get("201060", getBaseMap())))){
            String kohiNo = String.valueOf(VRBindPathParser.get("201060", getBaseMap()));
            if("1201,2501".indexOf(kohiNo) != -1){
            //[H20.5 法改正対応] fujihara edit end
                nursingCount = 2;
            }
        }
        
        //サービス単位数の合計と公費対象単位数の合計を算出
        for(int i = 0; i < detailList.size(); i++){
            VRMap map = (VRMap)detailList.get(i);
            //サービス単位数
            if(!ACTextUtilities.isNullText(map.get("301014"))){
                serviceUnitTotal += ACCastUtilities.toInt(map.get("301014"));
            }
            //公費１単位数
            if(!ACTextUtilities.isNullText(map.get("301015"))){
                kohiTotal1 += ACCastUtilities.toInt(map.get("301015"));
            }
            //公費２単位数
            if(!ACTextUtilities.isNullText(map.get("301016"))){
                kohiTotal2 += ACCastUtilities.toInt(map.get("301016"));
            }
            //公費３単位数
            if(!ACTextUtilities.isNullText(map.get("301017"))){
                kohiTotal3 += ACCastUtilities.toInt(map.get("301017"));
            }
        }
        
        //様式番号の表示を決定
        if(ACCastUtilities.toInt(printParam.get("YOSHIKI_BANGO"),0) == 0){
            //0なら様式番号を非表示とする。
            yoshikiBango = false;
        }
        
        //[ID:0000449][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
        if(ACCastUtilities.toInt(printParam.get("PRINT_NURSING_ZERO"),0) == 1){
            //1なら特定入所者の利用者負担額が0円の場合に明細書に印字する
        	printNursingZero = true;
        }
        //[ID:0000449][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
        //[ID:0000651][Shin Fujihara] 2011/07/06 add begin 負担限度額0円表示対応
        if(ACCastUtilities.toInt(printParam.get("PRINT_NURSING_LIMIT_ZERO"),0) == 1){
            //1なら特定入所者の負担限度額が0円の場合に明細書に印字する
        	printNursingLimitZero = true;
        }
        //[ID:0000651][Shin Fujihara] 2011/07/06 add end 負担限度額0円表示対応
        
        //帳票定義体IDの設定
        addFormat();
        
        //独自の印刷ロジックを実行し、結果を返却する。
        return doPrintImpl(printParam);
    }

    /**
     * 印刷データの解析を行います。
     * 
     * @throws Exception
     */
    protected void parseStyle() throws Exception {
        if (styleList == null)
            return;

        // 初期化
        detailList = new VRArrayList();
        emergencyList = new VRArrayList();
        emergencyOwnFacilityList = new VRArrayList();
        diagnosisList = new VRArrayList();
        typeList = new VRArrayList();
        nursingList = new VRArrayList();
        reductionList = new VRArrayList();
 // 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
        detailJushotiTokureiList = new VRArrayList();
 // 2015/1/14 [Yoichiro Kamei] add - end

        VRMap map = null;
        int categoryNo = 0;
        // レコードの復元
        for (int i = 0; i < styleList.getDataSize(); i++) {
            map = (VRMap) styleList.get(i);
            categoryNo = ACCastUtilities.toInt(VRBindPathParser.get(
                    "CATEGORY_NO", map));

            switch (categoryNo) {
            // 基本情報レコード
            case 2:
                baseMap = map;
                break;
            // 明細情報レコード
            case 3:
                detailList.add(map);
                break;
            // 緊急時施設療養情報レコード
            case 4:
                //緊急時施設療養情報レコード順次番号でソート
                if(QP001SpecialCase.isValidRecordEmergency(map)){
                	emergencyList.add(map);
                }
                break;
            // 特定診療費情報レコード
            case 5:
                diagnosisList.add(map);
                break;
            // 集計情報レコード
            case 7:
                //サービス種類コード
                typeList.add(map);
                break;
            // 特定入所者介護サービス費用情報レコード
            case 8:
                //レコード順次番号が0のレコードは表示しない。
                if(ACCastUtilities.toInt(map.get("801007"),0) != 0){
                    //サービスコード
                    nursingList.add(map);
                }
                break;
            // 社福減免レコード
            case 9:
                reductionList.add(map);
                break;
                
            // 緊急時施設療養・自施設療養費情報レコード
            case 17:
                if (QP001SpecialCase.isValidRecordEmergencyOwnFacility(map)) {
                    emergencyOwnFacilityList.add(map);
                }
                break;
// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
            // 明細情報レコード
            case 18:
            	detailJushotiTokureiList.add(map);
                break;            
// 2015/1/14 [Yoichiro Kamei] add - end
            }

        }
        
        Collections.sort(detailList,new RecordComparator());
        Collections.sort(emergencyList,new RecordComparator());
        Collections.sort(emergencyOwnFacilityList,new RecordComparator());
        Collections.sort(diagnosisList,new RecordComparator());
        Collections.sort(typeList,new RecordComparator());
        Collections.sort(nursingList,new RecordComparator());
        Collections.sort(reductionList,new RecordComparator());
// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
        Collections.sort(detailJushotiTokureiList,new RecordComparator());
// 2015/1/14 [Yoichiro Kamei] add - end
        

    }

    /**
     * 帳票共通の印刷設定を行います。
     * 
     * @param writer
     * @throws Exception
     */
    protected void setPrintHeader(int kohiCount) throws Exception {

        //様式番号の表示設定
        if(!yoshikiBango){
            ACChotarouXMLUtilities.setInvisible(writer, "header1");
            ACChotarouXMLUtilities.setInvisible(writer, "header2");
        }
        
        switch(kohiCount){
            //公費１印刷時
            case 0:
                // 公費負担者番号を設定する。
                ACChotarouXMLUtilities.setValue(writer, baseMap, "201007","kohifutanno");
                // 公費受給者番号を設定する。
                ACChotarouXMLUtilities.setValue(writer, baseMap, "201008","kohijyukyusyano");
                break;
            //公費２印刷時
            case 1:
                // 公費負担者番号を設定する。
                ACChotarouXMLUtilities.setValue(writer, baseMap, "201009","kohifutanno");
                // 公費受給者番号を設定する。
                ACChotarouXMLUtilities.setValue(writer, baseMap, "201010","kohijyukyusyano");
                break;
            //公費３印刷時
            case 2:
                // 公費負担者番号を設定する。
                ACChotarouXMLUtilities.setValue(writer, baseMap, "201011","kohifutanno");
                // 公費受給者番号を設定する。
                ACChotarouXMLUtilities.setValue(writer, baseMap, "201012","kohijyukyusyano");
                break;
        }
        
        // 請求年月の和暦を設定する。
        ACChotarouXMLUtilities.setValue(writer, "seikyuYMD.h1.w1", eraFormat
                .format(seikyuDate));
        // 請求年月の和暦年(YY形式)を設定する。
        ACChotarouXMLUtilities.setValue(writer, "seikyuyear", eraYearFormat
                .format(seikyuDate));
        // 請求年月の月(MM形式)を設定する。
        ACChotarouXMLUtilities.setValue(writer, "seikymonth", monthFormat
                .format(seikyuDate));

        // 保険者番号を設定する。
        ACChotarouXMLUtilities
                .setValue(writer, baseMap, "201005", "hokensyano");
        // 被保険者番号を設定する。
        ACChotarouXMLUtilities.setValue(writer, baseMap, "201006",
                "hihokensyano");

        // 被保険者のフリガナを設定する。
        ACChotarouXMLUtilities.setValue(writer, "patientNameKn", ACKanaConvert.toKatakana(QkanCommon
                .toFullName(ACCastUtilities.toString(VRBindPathParser.get(
                        "PATIENT_FAMILY_KANA", patient)), ACCastUtilities
                        .toString(VRBindPathParser.get("PATIENT_FIRST_KANA",
                                patient)))));
        // 被保険者の氏名を設定する。
        ACChotarouXMLUtilities.setValue(writer, "patientName", QkanCommon
                .toFullName(ACCastUtilities.toString(VRBindPathParser.get(
                        "PATIENT_FAMILY_NAME", patient)), ACCastUtilities
                        .toString(VRBindPathParser.get("PATIENT_FIRST_NAME",
                                patient))));

        //[ID:0000569][Shin Fujihara] 2010/01 edit begin 2009年度対応
        //CSVファイルの生年月日と一致させるよう修正
        //Date birthDay = ACCastUtilities.toDate(VRBindPathParser.get(
        //        "PATIENT_BIRTHDAY", patient));
        Date birthDay = ACCastUtilities.toDate(VRBindPathParser.get("201013", baseMap));
        //[ID:0000569][Shin Fujihara] 2010/01 edit end 2009年度対応
        // 被保険者生年月日の和暦を取得する。
        String era = eraFormat.format(birthDay);

        // 「明治」の場合
        if ("明治".equals(era)) {
            // 「大正」の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "taisyo");
            // 「昭和」の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "syowa");
        } else if ("大正".equals(era)) {
            // 「明治」の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "meiji");
            // 「昭和」の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "syowa");
        } else if ("昭和".equals(era)) {
            // 「明治」の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "meiji");
            // 「大正」の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "taisyo");
        } else {
            ACChotarouXMLUtilities.setInvisible(writer, "meiji");
            ACChotarouXMLUtilities.setInvisible(writer, "taisyo");
            ACChotarouXMLUtilities.setInvisible(writer, "syowa");
        }

        // 生年月日の和暦年号を設定する。
        ACChotarouXMLUtilities.setValue(writer, "birthyear", eraYearFormat
                .format(birthDay));

        // 生年月日の月(MMフォーマット)を設定する。
        ACChotarouXMLUtilities.setValue(writer, "birthmonth", monthFormat
                .format(birthDay));

        // 生年月日の日(DDフォーマット)を設定する。
        ACChotarouXMLUtilities.setValue(writer, "birthday", dayFormat
                .format(birthDay));

        // 被保険者の性別コードを取得する。
        //[ID:0000569][Shin Fujihara] 2010/01 edit begin 2009年度対応
        //CSVに出力した性別コードと一致するよう修正
        //switch (ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_SEX",
        //        patient))) {
        switch (ACCastUtilities.toInt(VRBindPathParser.get("201014", baseMap))) {
        //[ID:0000569][Shin Fujihara] 2010/01 edit end 2009年度対応
        // 1(男)の場合。
        case 1:
            // 「女」の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "woman");
            break;
        // 2(女)の場合
        case 2:
            // 「男」の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "man");
            break;
        default:
            ACChotarouXMLUtilities.setInvisible(writer, "woman");
            ACChotarouXMLUtilities.setInvisible(writer, "man");
            break;
        }

        // 被保険者の要介護常態区分を取得する。 ※201015より取得
        if(!ACTextUtilities.isNullText(VRBindPathParser.get("201015", baseMap))){
            switch (ACCastUtilities.toInt(VRBindPathParser.get("201015", baseMap))) {
            // 「6-事業対象者」の場合
            case 6:
                // 要支援１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // 要支援２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // 要支援の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
                // 要介護１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                // 要介護２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                // 要介護３の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                // 要介護４の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                // 要介護５の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                break;
                    
            // 「11-要支援(経過的要介護)」の場合
            case 11:
                // 事業対象者の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // 要支援１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // 要支援２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // 要介護１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                // 要介護２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                // 要介護３の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                // 要介護４の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                // 要介護５の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                break;
                
            // 「12-要支援１」の場合
            case 12:
                // 事業対象者の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // 要支援２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // 要支援の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
                // 要介護１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                // 要介護２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                // 要介護３の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                // 要介護４の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                // 要介護５の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                break;
                
            // 「13-要支援２」の場合
            case 13:
                // 事業対象者の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // 要支援１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // 要支援の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
                // 要介護１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                // 要介護２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                // 要介護３の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                // 要介護４の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                // 要介護５の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                break;
    
            // 「21-要介護１」の場合
            case 21:
                // 事業対象者の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // 要支援１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // 要支援２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // 要支援の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
                // 要介護２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                // 要介護３の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                // 要介護４の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                // 要介護５の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                break;
    
            // 「22-要介護２」の場合
            case 22:
                // 事業対象者の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // 要支援１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // 要支援２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // 要支援の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
                // 要介護１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                // 要介護３の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                // 要介護４の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                // 要介護５の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                break;
    
            // 「23-要介護３」の場合
            case 23:
                // 事業対象者の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // 要支援１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // 要支援２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // 要支援の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
                // 要介護１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                // 要介護２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                // 要介護４の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                // 要介護５の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                break;
    
            // 「24-要介護４」の場合
            case 24:
                // 事業対象者の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // 要支援１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // 要支援２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // 要支援の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
                // 要介護１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                // 要介護２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                // 要介護３の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                // 要介護５の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                break;
    
            // 「25-要介護５」の場合
            case 25:
                // 事業対象者の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // 要支援１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // 要支援２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // 要支援の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
                // 要介護１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                // 要介護２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                // 要介護３の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                // 要介護４の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                break;
    
            // 上記以外の場合
            default:
                // 事業対象者の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // 要支援１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // 要支援２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // 要支援の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
                // 要介護１の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                // 要介護２の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                // 要介護３の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                // 要介護４の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                // 要介護５の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                break;
            }
        } else {
            // 事業対象者の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
            // 要支援１の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
            // 要支援２の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
            // 要支援の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "youshien");
            // 要介護１の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
            // 要介護２の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
            // 要介護３の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
            // 要介護４の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
            // 要介護５の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
        }

        // 有効認定期間開始日
//        if (!ACTextUtilities
//                .isNullText(VRBindPathParser.get("201017", baseMap))) {
        if (QP001Util.isDate(baseMap.get("201017"))) {
            Date start = ACCastUtilities.toDate(VRBindPathParser.get("201017",
                    baseMap));
            // 有効認定期間開始日の和暦を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hihokensya.h7.w3",
                    eraFormat.format(start));
            // 有効認定期間開始日の和暦年(YYフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "yukoyear", eraYearFormat
                    .format(start));
            // 有効認定期間開始日の月(MMフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "yukomonth", monthFormat
                    .format(start));
            // 有効認定期間開始日の日(DDフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "yukoday", dayFormat
                    .format(start));

        }

        // 有効認定期間終了日
//        if (!ACTextUtilities
//                .isNullText(VRBindPathParser.get("201018", baseMap))) {
        if (QP001Util.isDate(baseMap.get("201018"))) {
            Date end = ACCastUtilities.toDate(VRBindPathParser.get("201018",
                    baseMap));
            // 有効認定期間終了日の和暦を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hihokensya.h8.w3",
                    eraFormat.format(end));
            // 有効認定期間終了日の和暦年(YYフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "yukoendyear",
                    eraYearFormat.format(end));
            // 有効認定期間終了日の月(MMフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "yukoendmonth", monthFormat
                    .format(end));
            // 有効認定期間終了日の日(DDフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "yukoendday", dayFormat
                    .format(end));

        }
        // 事業所番号を設定する。
        ACChotarouXMLUtilities.setValue(writer, baseMap, "201004",
                "jigyousyono");
        // 事業所名称を設定する。
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_NAME",
                "providerName");
        // 事業所郵便番号の前半３桁を設定する。
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_ZIP_FIRST",
                "jigyousyozip1");
        // 事業所郵便番号の後半４桁を設定する。
        ACChotarouXMLUtilities.setValue(writer, provider,
                "PROVIDER_ZIP_SECOND", "jigyousyozip2");
        // 事業所の所在地を設定する。
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_ADDRESS",
                "providerAddress");
        // 事業所の電話番号を設定する。
        ACChotarouXMLUtilities.setValue(writer, "jigyousyotel", QkanCommon
                .toTel(ACCastUtilities.toString(VRBindPathParser.get(
                        "PROVIDER_TEL_FIRST", provider)), ACCastUtilities
                        .toString(VRBindPathParser.get("PROVIDER_TEL_SECOND",
                                provider)), ACCastUtilities
                        .toString(VRBindPathParser.get("PROVIDER_TEL_THIRD",
                                provider))));

    }

    protected void setKyotakuData() throws Exception {
        // 在宅サービス計画者を取得する。 201019の情報より取得();
        switch (ACCastUtilities.toInt(VRBindPathParser.get("201019", baseMap))) {
        // 居宅介護支援事業所作成
        case 1:
            // 在宅サービス計画者が在宅介護支援事業者の場合
            // 被保険者自己作成の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jiko");
            // 介護予防支援事業者の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "kaigoshienjigyousya");
            
            // 在宅サービス計画書作成の事業所番号を設定する。
            ACChotarouXMLUtilities.setValue(writer, baseMap, "201020",
                    "kyotakujigyosyono");
            // 在宅サービス計画作成の事業所名称を設定する。
            // edit sta 2006.05.14 shin.fujihara
//            ACChotarouXMLUtilities.setValue(writer, provider_make,
//                    "PROVIDER_NAME", "kyotakuProviderName");
            ACChotarouXMLUtilities.setValue(writer, baseMap,
                    "201057", "kyotakuProviderName");
            // edit end 2006.05.14 shin.fujihara
            break;
        // 自己作成
        case 2:
            // 在宅サービス計画者が被保険者自己作成の場合
            // 在宅介護支援事業者の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shienjigyousya");
            // 介護予防支援事業者の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "kaigoshienjigyousya");
            break;
            
        case 3:
            // 在宅サービス計画者が介護予防支援事業者の場合
            // 在宅介護支援事業者の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shienjigyousya");
            // 被保険者自己作成の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jiko");
            
            // 在宅サービス計画書作成の事業所番号を設定する。
            ACChotarouXMLUtilities.setValue(writer, baseMap, "201020",
                    "kyotakujigyosyono");
            // 在宅サービス計画作成の事業所名称を設定する。
            // edit sta 2006.05.14 shin.fujihara
//            ACChotarouXMLUtilities.setValue(writer, provider_make,
//                    "PROVIDER_NAME", "kyotakuProviderName");
            ACChotarouXMLUtilities.setValue(writer, baseMap,
                    "201057", "kyotakuProviderName");
            // edit end 2006.05.14 shin.fujihara
            
            break;
        default:
            //被保険者自己作成の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jiko");
            //在宅介護支援事業者の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shienjigyousya");
            // 介護予防支援事業者の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "kaigoshienjigyousya");
            break;
        }
    }

    /**
     * 開始年月日等の設定を行います。
     * @throws Exception
     */
    protected void setKaishiDate() throws Exception {
        // 開始年月日の設定
//        if (!ACTextUtilities
//                .isNullText(VRBindPathParser.get("201021", baseMap))) {
        if (QP001Util.isDate(baseMap.get("201021"))) {
            Date start = ACCastUtilities.toDate(VRBindPathParser.get("201021",
                    baseMap));
            // 開始年月日の和暦を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kaishi.h1.w2", eraFormat
                    .format(start));
            // 開始年月日の和暦年(YYフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "stayear", eraYearFormat
                    .format(start));
            // 開始年月日の月(MMフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "stamonth", monthFormat
                    .format(start));
            // 開始年月日の日(DDフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "staday", dayFormat
                    .format(start));

        }

        // 中止年月日の設定
//        if (!ACTextUtilities
//                .isNullText(VRBindPathParser.get("201022", baseMap))) {
        if (QP001Util.isDate(baseMap.get("201022"))) {
            Date end = ACCastUtilities.toDate(VRBindPathParser.get("201022",
                    baseMap));
            // 中止年月日の和暦を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kaishi.h1.w10", eraFormat
                    .format(end));
            // 中止年月日の和暦年(YYフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "endyear", eraYearFormat
                    .format(end));
            // 中止年月日の月(MMフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "endmonth", monthFormat
                    .format(end));
            // 中止年月日の日(DDフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "endday", dayFormat
                    .format(end));
        }

        // 中止理由の設定
        if (!ACTextUtilities
                .isNullText(VRBindPathParser.get("201023", baseMap))) {
            // 中止理由を取得する。(201023より取得)
            switch (ACCastUtilities.toInt(VRBindPathParser.get("201023",
                    baseMap))) {
            // 中止理由が「非該当」の場合
            case 1:
                //医療機関入院の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //死亡の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //その他の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //介護老人福祉施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //介護老人保険施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                //介護療養型医療機関入所
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;

            // 中止理由が「介護保険施設」の場合
            // ※新様式では廃止
            case 2:
                // 非該当の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //医療機関入院の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //死亡の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //その他の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //介護老人福祉施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //介護老人保険施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                //介護療養型医療機関入所
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;

            // 中止理由が「医療機関入院」の場合
            case 3:
                // 非該当の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //死亡の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //その他の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //介護老人福祉施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //介護老人保険施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                //介護療養型医療機関入所
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;

            // 中止理由が「死亡」の場合
            case 4:
                // 非該当の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //医療機関入院の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //その他の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //介護老人福祉施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //介護老人保険施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                //介護療養型医療機関入所
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;

            // 中止理由が「その他」の場合
            case 5:
                // 非該当の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //医療機関入院の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //死亡の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //介護老人福祉施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //介護老人保険施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                //介護療養型医療機関入所
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;
                
            // 中止理由が「介護老人福祉施設入所」の場合
            case 6:
                // 非該当の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //医療機関入院の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //死亡の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //その他の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //介護老人保険施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                //介護療養型医療機関入所
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;
                
            // 中止理由が「介護老人保険施設入所」の場合
            case 7:
                // 非該当の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //医療機関入院の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //死亡の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //その他の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //介護老人福祉施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //介護療養型医療機関入所
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;

            // 中止理由が「介護老人保険施設入所」の場合
            case 8:
                // 非該当の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //医療機関入院の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //死亡の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //その他の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //介護老人福祉施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //介護老人保険施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                break;
                
            // 上記以外
            default:
                // 非該当の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //医療機関入院の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //死亡の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //その他の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //介護老人福祉施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //介護老人保険施設入所の○を非表示にする。
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                //介護療養型医療機関入所
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;

            }
        } else {
            // 非該当の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "higaito");
            //医療機関入院の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
            //死亡の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shibou");
            //その他の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "etc");
            //介護老人福祉施設入所の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
            //介護老人保険施設入所の○を非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
            //介護療養型医療機関入所
            ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
        }
    }
    
    /**
     * 入所年月日等の設定を行います。
     * (様式八から十用)
     * @throws Exception
     */
    protected void setNyusyoDate() throws Exception {
        //入院（入所）日の設定
//        if (!ACTextUtilities.isNullText(VRBindPathParser.get("201024", baseMap))) {
        if (QP001Util.isDate(baseMap.get("201024"))) {
            Date start = ACCastUtilities.toDate(VRBindPathParser.get("201024",baseMap));
            // 入院（入所）月日の和暦を設定する。
            ACChotarouXMLUtilities.setValue(writer, "nyusyodate.h1.w2", eraFormat.format(start));
            // 入院（入所）年月日の和暦年(YYフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "nyusyoyear", eraYearFormat.format(start));
            // 入院（入所）年月日の月(MMフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "nyusyomonth", monthFormat.format(start));
            // 入院（入所）年月日の日(DDフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "nyusyoday", dayFormat.format(start));

        }

        // 退所年月日の設定
//        if (!ACTextUtilities
//                .isNullText(VRBindPathParser.get("201025", baseMap))) {
        if (QP001Util.isDate(baseMap.get("201025"))) {
            Date end = ACCastUtilities.toDate(VRBindPathParser.get("201025",baseMap));
            // 退所年月日の和暦を設定する。
            ACChotarouXMLUtilities.setValue(writer, "taisyodate.h1.w2", eraFormat.format(end));
            // 退所年月日の和暦年(YYフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "taisyoyear", eraYearFormat.format(end));
            // 退所年月日の月(MMフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "taisyomonth", monthFormat.format(end));
            // 退所年月日の日(DDフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "taisyoday", dayFormat.format(end));
        }
        

        // 短期入所の実日数を設定する。
        ACChotarouXMLUtilities.setValue(writer, "tankijitsu", pad(VRBindPathParser.get("201026", baseMap), 2));
        // 外泊の日数を設定する。
        ACChotarouXMLUtilities.setValue(writer, "gaihaku", pad(VRBindPathParser.get("201027", baseMap), 2));
        // 主傷病名を設定する。
        ACChotarouXMLUtilities.setValue(writer, baseMap, "201061","syusyoubyou.h1.w2");
        
        //退院後の状況
        switch(ACCastUtilities.toInt(baseMap.get("201028"),0)){
            //1-居宅
            case 1:
                ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan");
                ACChotarouXMLUtilities.setInvisible(writer,"shibou");
                ACChotarouXMLUtilities.setInvisible(writer,"etc");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo");
                break;
            //2-介護施設(平成18年4月以降廃止)-defaultへ
            //3-医療機関入院
            case 3:
                ACChotarouXMLUtilities.setInvisible(writer,"higaito");
                ACChotarouXMLUtilities.setInvisible(writer,"shibou");
                ACChotarouXMLUtilities.setInvisible(writer,"etc");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo");
                break;
            //4-死亡
            case 4:
                ACChotarouXMLUtilities.setInvisible(writer,"higaito");
                ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan");
                ACChotarouXMLUtilities.setInvisible(writer,"etc");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo");
                break;
            //5-その他
            case 5:
                ACChotarouXMLUtilities.setInvisible(writer,"higaito");
                ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan");
                ACChotarouXMLUtilities.setInvisible(writer,"shibou");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo");
                break;
            //6-介護老人福祉施設入所
            case 6:
                ACChotarouXMLUtilities.setInvisible(writer,"higaito");
                ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan");
                ACChotarouXMLUtilities.setInvisible(writer,"shibou");
                ACChotarouXMLUtilities.setInvisible(writer,"etc");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo");
                break;
            //7-介護老人保健施設入所
            case 7:
                ACChotarouXMLUtilities.setInvisible(writer,"higaito");
                ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan");
                ACChotarouXMLUtilities.setInvisible(writer,"shibou");
                ACChotarouXMLUtilities.setInvisible(writer,"etc");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo");
                break;
            //8-介護療養型医療施設入院
            case 8:
                ACChotarouXMLUtilities.setInvisible(writer,"higaito");
                ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan");
                ACChotarouXMLUtilities.setInvisible(writer,"shibou");
                ACChotarouXMLUtilities.setInvisible(writer,"etc");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken");
                break;
            default:
                ACChotarouXMLUtilities.setInvisible(writer,"higaito");
                ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan");
                ACChotarouXMLUtilities.setInvisible(writer,"shibou");
                ACChotarouXMLUtilities.setInvisible(writer,"etc");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo");
                break;
        }
        
        
    }
    
    /**
     * 明細情報を設定する。
     * @param detailList
     * @param loopCount
     * @param kohiCount
     * @throws Exception
     */
    protected void setDetailList(VRList detailList,int loopCount,int kohiCount) throws Exception {
        // 明細件数分ループする。
        for (int j = 1; j < loopCount; j++) {
            if (detailList.getDataSize() == 0)
                break;
            VRMap detail = (VRMap) detailList.get(0);
            // サービス内容を設定する。
            ACChotarouXMLUtilities.setValue(writer, detail, "301019",
                    "meisai.h" + j + ".w2");
            // サービスコードを設定する。
            ACChotarouXMLUtilities.setValue(writer, "servicecode" + j,
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "301007", detail))
                            + ACCastUtilities.toString(VRBindPathParser
                                    .get("301008", detail)));

            //単位数を表示するサービスでなければ単位数単価を表示する。
            // [総合事業独自対応][Shinobu Hitaka] 2016/09/30 mod 算定単位パラメータ追加
            // if(!QP001SpecialCase.isUnitNotShowService(String.valueOf(detail.get("301007")),String.valueOf(detail.get("301008")))){
            if(!QP001SpecialCase.isUnitNotShowService(String.valueOf(detail.get("301007")),String.valueOf(detail.get("301008")),
            		ACCastUtilities.toInt(detail.get("301027"), 0))){
                // 単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "tani" + j, pad(
                        VRBindPathParser.get("301009", detail), 4));
            }

            // 日数・回数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "times" + j, pad(
                    VRBindPathParser.get("301010", detail), 2));
            
            // サービス単位数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "servicetime" + j,
                    pad(VRBindPathParser.get("301014", detail), 5));

            
            switch (kohiCount) {
            // 公費1
            case 0:
                // 公費分回数を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "kohitimes" + j, pad(VRBindPathParser.get(
                                "301011", detail), 2));
                
                // 公費対象単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohitani" + j,
                        pad(VRBindPathParser.get("301015", detail), 5));

                break;
            // 公費2
            case 1:
                // 公費分回数を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "kohitimes" + j, pad(VRBindPathParser.get(
                                "301012", detail), 2));
                
                // 公費対象単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohitani" + j,
                        pad(VRBindPathParser.get("301016", detail), 5));

                break;
            // 公費3
            case 2:
                // 公費分回数を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "kohitimes" + j, pad(VRBindPathParser.get(
                                "301013", detail), 2));

                // 公費対象単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohitani" + j,
                        pad(VRBindPathParser.get("301017", detail), 5));

                break;
            }

            // 摘要を設定する。
            ACChotarouXMLUtilities.setValue(writer, detail, "301018",
                    "meisai.h" + j + ".tekiyo");
            detailList.remove(0);
        }
    }

// 2015/1/26 [H27.4改正対応][Yoichiro Kamei] add - begin
    public VRMap getServiceName() {
        return serviceName;
    }
// 2015/1/26 [H27.4改正対応][Yoichiro Kamei] add - end
    
    protected void setTypeList(VRList typeList,int loopCount,int kohiCount) throws Exception {
        for (int j = 1; j < loopCount; j++) {
            if (typeList.getDataSize() == 0)
                break;
            VRMap type = (VRMap) typeList.get(0);
            // サービス種類コードを設定する。
            ACChotarouXMLUtilities.setValue(writer, type, "701007",
                    "servicekindcode" + j);
            
//            // サービス名称を設定する。
//            ACChotarouXMLUtilities.setValue(writer, type, "701039",
//                    "seikyumeisai.h1.w" + ((j * 3) + 1));
            
            
            VRMap service = (VRMap)serviceName.get(type.get("701007"));
            // サービス名称を設定する。
//            ACChotarouXMLUtilities.setValue(writer, service, "SERVICE_NAME",
//                    "seikyumeisai.h1.w" + ((j * 3) + 1));
//            ACChotarouXMLUtilities.setValue(writer, service, "SERVICE_KIND_NAME",
//                    "seikyumeisai.h1.w" + ((j * 3) + 1));
            //予防対応
            ACChotarouXMLUtilities.setValue(writer, service, "SERVICE_KIND_NAME",
                    "seviceName" + j);
            
            // サービス実日数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "servicerealdate"
                    + j, pad(VRBindPathParser.get("701008", type), 2));
            // 計画単位数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "plantani" + j,
                    pad(VRBindPathParser.get("701009", type), 6));
            // 限度額管理対象単位数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "limitin" + j, pad(
                    VRBindPathParser.get("701010", type), 6));
            // 限度額管理対象外単位数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "limitout" + j,
                    pad(VRBindPathParser.get("701011", type), 6));
            // 給付単位数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kyufutani" + j,
                    pad(VRBindPathParser.get("701014", type), 6));

            // 単位数単価を設定する。
            ACChotarouXMLUtilities.setValue(writer, "tanisutani" + j,
                    getTanka(VRBindPathParser.get("701015", type)));

            if(kohiCount == 0){
                // 保険請求額を設定する。
                ACChotarouXMLUtilities.setValue(writer, "hokenseikyu" + j,
                        pad(VRBindPathParser.get("701016", type), 6));
                // 利用者負担額を設定する。
                ACChotarouXMLUtilities.setValue(writer, "riyosyafutan" + j,
                        pad(VRBindPathParser.get("701017", type), 6));
            }

            switch (kohiCount) {
            // 公費1
            case 0:
                // 公費分単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohibuntani"
                        + j, pad(VRBindPathParser.get("701018", type),
                        6));
                // 公費請求額を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohiseikyu"
                        + j, pad(VRBindPathParser.get("701019", type),
                        6));
                // 公費分本人負担額を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohihonnin"
                        + j, pad(VRBindPathParser.get("701020", type),
                        6));
                break;
            // 公費2
            case 1:
                // 公費分単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohibuntani"
                        + j, pad(VRBindPathParser.get("701021", type),
                        6));
                // 公費請求額を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohiseikyu"
                        + j, pad(VRBindPathParser.get("701022", type),
                        6));
                // 公費分本人負担額を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohihonnin"
                        + j, pad(VRBindPathParser.get("701023", type),
                        6));
                break;
            // 公費3
            case 2:
                // 公費分単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohibuntani"
                        + j, pad(VRBindPathParser.get("701024", type),
                        6));
                // 公費請求額を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohiseikyu"
                        + j, pad(VRBindPathParser.get("701025", type),
                        6));
                // 公費分本人負担額を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohihonnin"
                        + j, pad(VRBindPathParser.get("701026", type),
                        6));
                break;
            }

            typeList.remove(0);
        }
    }
    
    //[ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
    /**
     * 入居（入院）前の状態を帳票に設定します。
     * @param typeList
     * @param loopCount
     * @param kohiCount
     * @throws Exception
     */
    protected void setBeforeHospitalization() throws Exception {
        //入居（入院）前の状態[中止理由コード]
        switch(ACCastUtilities.toInt(baseMap.get("201023"),0)){
	        // 1:居宅
	        case 1:
	        	ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;
	        	
	        // 2:医療機関
	        case 2:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;
	        	
	        // 3:介護老人福祉施設
	        case 3:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;
	        	
	        // 4:介護老人保健施設
	        case 4:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;
	        	
	        // 5:介護療養型医療施設
	        case 5:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;
	        	
	        // 6:認知賞対応型共生活介護
	        case 6:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;
	        	
	        // 7:特定施設入居者生活介護
	        case 7:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;
	        	
	        // 8:その他
	        case 8:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
	        	break;
	        	
	        default:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
		        ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
		        ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
		        ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
		        ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
		        ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
		        ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
		        ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;

        }
    }
    //[ID:0000447][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
    
    /**
     * 給付費明細欄を表示するかのフラグを返却します。<br>
     * 公費負担者番号が設定されており、
     * @param kohiCount
     * @return
     * @throws Exception
     */
    protected boolean isDetailListShow(int kohiCount) throws Exception {
    	
        switch(kohiCount){
	        //公費１印刷時
	        case 0:
	            // 公費負担者番号を確認
	        	//公費負担者番号が存在し
	        	if(!ACTextUtilities.isNullText(baseMap.get("201007"))){
	        		if(ACCastUtilities.toString(baseMap.get("201007")).startsWith("10")){
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
     * @param kohiCount
     * @param diagnosisLastMap
     * @return
     * @throws Exception
     */
    protected boolean isDiagnosisListShow(int kohiCount,VRMap diagnosisLastMap) throws Exception {
    	
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
	        		
	        		//公費総計が0の場合は表示を中断する。
	        		if(ACCastUtilities.toInt(diagnosisLastMap.get("501022"),0) == 0){
	        			return false;
	        		}
	        	}
	            break;
        }
    	return true;
    }
    
    /**
     * レコード順次番号が99のハッシュマップを返却します。
     * @param list 検索対象のリスト
     * @param key レコード順次番号のキー
     * @return 取得したハッシュマップ
     * @throws Exception
     */
    protected VRMap getLastRecord(VRList list, String key) throws Exception {
        return getNominationRecord(list,key,99);
    }
    
    protected VRMap getNominationRecord(VRList list, String key,int recordNo) throws Exception {
        if(list == null) return null;
        
        if(list.size() == 1){
            return (VRMap)list.get(0);
        }
        
        for(int i =0; i < list.size(); i++){
            VRMap map = (VRMap)list.get(i);
            if((ACCastUtilities.toInt(map.get(key))) == recordNo){
                return map;
            }
        }
        return null;
    }

    /**
     * 基本情報レコードを取得します。
     * @return
     */
    protected VRMap getBaseMap() {
        return baseMap;
    }

    /**
     * 明細情報レコードリストを取得します。
     * @return
     */
    protected VRList getDetailList() {
        return getStyleList(detailList);
    }
// 2015/1/26 [H27.4改正対応][Yoichiro Kamei] add - begin 住所地特例対応
    /**
     * 明細情報（住所地特例）レコードリストを取得します。
     * @return
     */
    protected VRList getDetailJushotiTokureiList() {
        return getStyleList(detailJushotiTokureiList);
    }
// 2015/1/26 [H27.4改正対応][Yoichiro Kamei] add - end
    /**
     * 明細情報レコードを取得します。
     * @return
     */
    protected VRMap getDetailMap() {
        return getStyleMap(detailList);
    }

    /**
     * 緊急時施設療養情報レコードリストを取得します。
     * @return
     */
    protected VRList getEmergencyList() {
        return getStyleList(emergencyList);
    }

    /**
     * 緊急時施設療養情報レコードを取得します。
     * @return
     */
    protected VRMap getemErgencyMap() {
        return getStyleMap(emergencyList);
    }
    
    
    /**
     * 緊急時施設療養・自施設療養費情報レコードリストを取得します。
     * @return
     */
    protected VRList getEmergencyOwnFacilityList() {
        return getStyleList(emergencyOwnFacilityList);
    }

    /**
     * 緊急時施設療養・自施設療養費情報レコードを取得します。
     * @return
     */
    protected VRMap getemErgencyOwnFacilityMap() {
        return getStyleMap(emergencyOwnFacilityList);
    }

    /**
     * 特定診療費情報レコードリストを取得します。
     * @return
     */
    protected VRList getDiagnosisList() {
        return getStyleList(diagnosisList);
    }

    /**
     * 特定診療費情報レコードを取得します。
     * @return
     */
    protected VRMap getDiagnosisMap() {
        return getStyleMap(diagnosisList);
    }

    /**
     * 集計情報レコードリストを取得します。
     * @return
     */
    protected VRList getTypeList() {
        return getStyleList(typeList);
    }

    /**
     * 集計情報レコードを取得します。
     * @return
     */
    protected VRMap getTypeMap() {
        return getStyleMap(typeList);
    }

    /**
     * 特定入所者介護サービス費用情報レコードリストを取得します。
     * @return
     */
    protected VRList getNursingList() {
        return getStyleList(nursingList);
    }

    /**
     * 特定入所者介護サービス費用情報レコードを取得します。
     * @return
     */
    protected VRMap getNursingMap() {
        return getStyleMap(nursingList);
    }

    /**
     * 社会福祉法人軽減額情報レコードリストを取得します。
     * @return
     */
    protected VRList getReductionList() {
        return getStyleList(reductionList);
    }

    /**
     * 社会福祉法人軽減額情報レコードを取得します。
     * @return
     */
    protected VRMap getReductionMap() {
        return getStyleMap(reductionList);
    }
    
    /**
     * サービス単位数合計を取得します。
     * @return
     */
    protected int getServiceUnitTotal() {
        return serviceUnitTotal;
    }
    
    /**
     * 公費１単位数合計を取得します。
     * @return
     */
    protected int getKohiTotal1() {
        return kohiTotal1;
    }
    
    /**
     * 公費２単位数合計を取得します。
     * @return
     */
    protected int getKohiTotal2() {
        return kohiTotal2;
    }
    
    /**
     * 公費３単位数合計を取得します。
     * @return
     */
    protected int getKohiTotal3() {
        return kohiTotal3;
    }

    private VRList getStyleList(VRList value) {
        if (value == null)
            return new VRArrayList();

        return value;
    }

    private VRMap getStyleMap(VRList value) {
        if ((value == null) || (value.getDataSize() == 0))
            return null;

        return (VRMap) value.get(0);
    }

    /**
     * 12.34型式の値の.を抜いて、1234に変更します。
     * 5.67型式の場合は先頭に空白をいれて567を返却します。
     * @param value
     * @return
     * @throws Exception
     */
    protected String getTanka(Object value) throws Exception {
        if (ACTextUtilities.isNullText(value))
            return "";
        String[] temp = ACCastUtilities.toString(value).split("\\.");
        temp[0] = pad(temp[0], 2);
        if (temp.length == 1){
            return temp[0] + "00";
        } else if(temp.length == 2){
            if((temp[1] == null) || (temp[1].length() == 0)){
                temp[1] = "00";
            } else if(temp[1].length() == 1){
                temp[1] += "0";
            }
        }

        return temp[0] + temp[1];

    }

    /**
     * 文字列の先頭に空白文字を挿入し、引数で指定された文字数にして返却します。
     * 引数が0の場合は空白に置換されます。
     * @param value 対象文字列
     * @param pad 求める文字数
     * @return 空白を挿入した文字列
     * @throws Exception
     */
    protected String pad(Object value, int pad) throws Exception {
        if (ACTextUtilities.isNullText(value))
            return "";
        //String temp = ACCastUtilities.toString(value);
        String temp = ACTextUtilities.trim(ACCastUtilities.toString(value));
        if ("0".equals(temp))
            return "";
        StringBuilder padString = new StringBuilder();
        for (int i = 0; i < pad - temp.length(); i++) {
        	//全角に変更
            //padString.append(" ");
        	padString.append("　");
        }
        return padString.toString() + temp;
    }
    
    //[ID:0000449][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
    /**
     * 文字列の先頭に空白文字を挿入し、引数で指定された文字数にして返却します。
     * 引数が0の場合、設定変更メンテナンスで
     * 「特定入所者の利用者負担額が0円の場合に明細書に印字する」
     * にチェックがついているばあいは0、チェックが付いていない場合は空白を返却します。
     * @param value 対象文字列
     * @param pad 求める文字数
     * @return 空白を挿入した文字列
     * @throws Exception
     */
    protected String pad0(Object value, int pad) throws Exception {
    	if (this.printNursingZero){
            if ("0".equals(ACTextUtilities.trim(ACCastUtilities.toString(value)))) {
            	StringBuilder padString = new StringBuilder();
            	for (int i = 0; i < pad - 1; i++){
            		padString.append("　");
            	}
            	padString.append("0");
                return padString.toString();
            }
    	}
        return pad(value, pad);
    }
    //[ID:0000449][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応

    //[ID:0000651][Shin Fujihara] 2011/07/06 add begin 負担限度額0円表示対応
    //良い修正方法ではないことを承知で上記pad0メソッドをコピペ
    //もう一つ0円でも出力するパターンが追加されたときは、ロジックを統合する
    /**
     * 文字列の先頭に空白文字を挿入し、引数で指定された文字数にして返却します。
     * 引数が0の場合、設定変更メンテナンスで
     * 「特定入所者の利用者負担額が0円の場合に明細書に印字する」
     * にチェックがついているばあいは0、チェックが付いていない場合は空白を返却します。
     * @param value 対象文字列
     * @param pad 求める文字数
     * @return 空白を挿入した文字列
     * @throws Exception
     */
    protected String pad0NursingLimit(Object value, int pad) throws Exception {
    	if (this.printNursingLimitZero){
            if ("0".equals(ACTextUtilities.trim(ACCastUtilities.toString(value)))) {
            	StringBuilder padString = new StringBuilder();
            	for (int i = 0; i < pad - 1; i++){
            		padString.append("　");
            	}
            	padString.append("0");
                return padString.toString();
            }
    	}
        return pad(value, pad);
    }
    //[ID:0000651][Shin Fujihara] 2011/07/06 add end 負担限度額0円表示対応

    
    
    /**
     * 印刷します。
     * @param writer 印刷管理クラス
     * @param printParam 印刷パラメタ
     * @throws Exception 処理例外
     */
    public boolean doPrintImpl(VRMap printParam) throws Exception{
        return false;
    }
    
    /**
     * 帳票IDを設定する。
     * @throws Exception
     */
    public void addFormat() throws Exception{
        
    }
    
    /**
     * 設定した帳票IDを取得する。
     * @return
     * @throws Exception
     */
    public String getFormatId() throws Exception{
        return "";
    }

    // 2008/05/27 [Masahiko_Higuchi] edit - start 2007年度対応 外部アクセス許可
    public class RecordComparator implements java.util.Comparator {
    // 2008/05/27 [Masahiko_Higuchi] edit - end
        public int compare(Object object1, Object object2) {
            String[] values = new String[]{"",""};
            try{
            	VRMap[] maps = new VRMap[2];
            	maps[0] = (VRMap)object1;
            	maps[1] = (VRMap)object2;
            	
            	for(int i = 0; i < maps.length; i++){
                    int categoryNo = ACCastUtilities.toInt(VRBindPathParser.get("CATEGORY_NO", maps[i]));

                    switch (categoryNo) {
                    // 基本情報レコード
                    case 2:
                        break;
                    // 明細情報レコード
                    case 3:
                        //サービスコードでソート
                    	values[i] = String.valueOf(maps[i].get("301007")) + "-"
                                + String.valueOf(maps[i].get("301008")) + "-"
                                + String.valueOf(maps[i].get("301009")) + "-"
                                + String.valueOf(maps[i].get("301014")) + "-"
                                + String.valueOf(maps[i].get("301018"));
                        break;
                    // 緊急時施設療養情報レコード
                    case 4:
                        //緊急時施設療養情報レコード順次番号でソート
                    	values[i] = String.valueOf(maps[i].get("401007"));
                        break;
                    // 特定診療費情報レコード
                    case 5:
                        //特定診療費情報レコード識別番号
                    	values[i] = String.valueOf(maps[i].get("501009"));
                        break;
                    // 集計情報レコード
                    case 7:
                        //サービス種類コード
                    	values[i] = String.valueOf(maps[i].get("701007"));
                        break;
                    // 特定入所者介護サービス費用情報レコード
                    case 8:
                    	//レコード順次番号
                    	values[i] = String.valueOf(maps[i].get("801008")) + String.valueOf(maps[i].get("801009") + String.valueOf(maps[i].get("801010")));
                        break;
                    // 社福減免レコード
                    case 9:
                    	values[i] = String.valueOf(maps[i].get("901008"));
                        break;
                    // 緊急時施設療養・自施設療養費情報レコード
                    case 17:
                        //緊急時施設療養情報レコード順次番号でソート
                        values[i] = String.valueOf(maps[i].get("1701007"));
                        break;
// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
                    // 明細情報（住所地特例）レコード
                    case 18:
                        //サービスコードでソート
                    	values[i] = String.valueOf(maps[i].get("1801007")) + "-"
                                + String.valueOf(maps[i].get("1801008")) + "-"
                                + String.valueOf(maps[i].get("1801009")) + "-"
                                + String.valueOf(maps[i].get("1801014")) + "-"
                                + String.valueOf(maps[i].get("1801019"));
                        break;
// 2015/1/14 [Yoichiro Kamei] add - end
                    }
            	}
            } catch(Exception e){
                VRLogger.warning(e);
            }
            
            return values[0].compareTo(values[1]);
        }
    }
    
    //[H20.5 法改正対応] fujihara add start
    public int getTerm() {
    	return this.term;
    }
    //[H20.5 法改正対応] fujihara add end
    
    //変数定義

    //getter/setter

}
