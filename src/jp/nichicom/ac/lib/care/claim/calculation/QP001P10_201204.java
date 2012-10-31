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
 * プロセス 施設サービス等介護給付費明細書（介護療養型施設) (001)
 * プログラム 施設サービス等介護給付費明細書（介護療養型施設) (QP001P11)
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
 * 施設サービス等介護給付費明細書（介護療養型施設)(様式第十) -様式第十
 */
public class QP001P10_201204 extends QP001P02_10Event {
    
	/* 
	 * 様式第十 201204以降
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
    public QP001P10_201204() {
    }

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P100_201204.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P100_201204";
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
        //ACChotarouXMLUtilities.addFormat(writer, "QP001P11", "QP001P11.xml");

        // 基本情報レコード
        VRMap baseMap = getBaseMap();
        // 明細情報レコード集合
        VRList detailList = getDetailList();
        // 集計情報レコード
        VRMap typeMap = getTypeMap();

        // 特定診療費情報レコード
        VRList diagnosisList = getDiagnosisList();

        // 特定入所者介護サービス費用情報レコード
        VRList nursingList = getNursingList();
        
        VRMap nursingLast = getLastRecord(nursingList,"801007");
        
        VRMap diagnosisFirstMap = getNominationRecord(diagnosisList,"501007",1);
        VRMap diagnosisLastMap = getLastRecord(diagnosisList,"501007");

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

            // 特定診療費情報レコード
            diagnosisList = getDiagnosisList();
            // 特定入所者介護サービス費用情報レコード
            nursingList = getNursingList();
            
            // ※複数公費の受給を受けている場合は、受給公費分帳票を出力する。
            //特定入所者を印字しない場合があるので、毎回計算する。
            int pageCount = 1;
            int pageTemp = 1;

            // 印刷頁数を算出する。（1頁あたりの明細情報は8件、特定診療費情報は6件、特定入所者介護サービス費情報は4件)
            if (detailList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 8d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if (diagnosisList.getDataSize() > 0) {
                pageTemp = (int) Math
                        .ceil((double) diagnosisList.getDataSize() / 6d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if ((nursingList.getDataSize() > 0) && (nursingCount == kohiCount)) {
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 4d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
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

            // 特定診療費情報レコード
            diagnosisList = getDiagnosisList();
            // 特定入所者介護サービス費用情報レコード
            nursingList = getNursingList();
            
            // ※複数公費の受給を受けている場合は、受給公費分帳票を出力する。
            //特定入所者を印字しない場合があるので、毎回計算する。
            int pageCount = 1;
            int pageTemp = 1;

            // 印刷頁数を算出する。（1頁あたりの明細情報は8件、特定診療費情報は6件、特定入所者介護サービス費情報は4件)
            if (detailList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 8d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if (diagnosisList.getDataSize() > 0) {
                pageTemp = (int) Math
                        .ceil((double) diagnosisList.getDataSize() / 6d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if ((nursingList.getDataSize() > 0) && (nursingCount == kohiCount)) {
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
                
                //入所・退所のデータを設定する。
                setNyusyoDate();
                
                //[ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
                if (QP001Util.TERM_200904_AFFTER <= getTerm()){
                	//入居前の状況を設定する
                	setBeforeHospitalization();
                }
                //[ID:0000447][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
                
                //明細件数分ループする。※8件を超える場合は、次ページに印字
                if(isDetailListShow(kohiCount)){
                	setDetailList(detailList,9,kohiCount);
                }

                if(isDiagnosisListShow(kohiCount,diagnosisLastMap)){
	                // 特定診療費件数分ループする。※6件を超える場合は、次ページに印字
	                for (int j = 1; j < 7; j++) {
	                    if (diagnosisList.getDataSize() == 0)
	                        break;
	                    VRMap diagnosis = (VRMap) diagnosisList.get(0);
	                    // 識別番号を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, diagnosis,
	                            "501009", "shikibetsuno" + j);
	                    // 内容を設定する。※特定診療費マスタ(M_SPECIAL_CLINIC)のSPECIAL_CLINIC_TYPEと結合し、SPECIAL_CLINIC_NAMEを表示。
	                    // setValue(tokuteishinryo(w4,h*), 501009);
	                    //[ID:0000454][Shin Fujihara] 2009/05/01 edit begin 障害対応
	                    /*
	                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
	                            manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009"))));
	                    */
	                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
	                            manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009")),baseMap.get("201003")));
	                    //[ID:0000454][Shin Fujihara] 2009/05/01 edit end 障害対応
	                    // 単位数を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryotani" + j, pad(diagnosis.get("501010"),4));
	                    // 回数を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryotimes" + j, pad(diagnosis.get("501011"),2));
	                    // 保険分単位数を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryohokentani" + j, pad(diagnosis.get("501012"),5));
	                    
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
                }

                // 特定入所者介護サービス件数分ループする。※4件を超える場合は、次ページに印字
                if(nursingCount == kohiCount){
                    for (int j = 1; j < 5; j++) {
                        if (nursingList.getDataSize() == 0)
                            break;
                        VRMap nursing = (VRMap) nursingList.get(0);
                        // サービス内容を設定する。
                        ACChotarouXMLUtilities.setValue(writer, nursing, "801034",
                                "tokuteimeisai.h" + j + ".w2");
                        //サービスコードを設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "tokuteiservicecode" + j, ACCastUtilities
                                        .toString(VRBindPathParser.get("801008",
                                                nursing))
                                        + ACCastUtilities.toString(VRBindPathParser
                                                .get("801009", nursing)));

                        //費用単価を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitani" + j, pad(VRBindPathParser.get("801010", nursing), 4));
                        //負担限度額を設定する。
                        //[ID:0000651][Shin Fujihara] 2011/07/06 add begin 負担限度額0円表示対応
                        //ACChotarouXMLUtilities.setValue(writer, "dokuteilimit" + j, pad(VRBindPathParser.get("801011", nursing), 4));
                        ACChotarouXMLUtilities.setValue(writer, "dokuteilimit" + j, pad0NursingLimit(VRBindPathParser.get("801011", nursing), 4));
                        //[ID:0000651][Shin Fujihara] 2011/07/06 add end 負担限度額0円表示対応
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
                        //[ID:0000449][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
                        //ACChotarouXMLUtilities.setValue(writer, "tokuteiriyosha" + j, pad(VRBindPathParser.get("801021", nursing), 5));
                        ACChotarouXMLUtilities.setValue(writer, "tokuteiriyosha" + j, pad0(VRBindPathParser.get("801021", nursing), 5));
                        //[ID:0000449][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応
                        
                        nursingList.remove(0);
                    }
                }

                //用紙が一枚めの場合
                if (i == 0) {
                    
                	if(isDetailListShow(kohiCount)){
	                    //給付費明細欄の合計を出力==============================
	                    //サービス単位数合計を設定する。　※サービス単位数の合算を設定。
	                    ACChotarouXMLUtilities.setValue(writer,"servicetimetotal",pad(String.valueOf(getServiceUnitTotal()),5));
	                    //公費対象単位数合計を設定する。　※公費対象単位数の合算を設定。
	                    switch(kohiCount){
	                    case 0:
	                        ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal1()),5));
	                        break;
	                    case 1:
	                        ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal2()),5));
	                        break;
	                    case 2:
	                        ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal3()),5));
	                        break;
	                    }
                	}
                	if(isDiagnosisListShow(kohiCount,diagnosisLastMap)){
	                    // 特定診療費情報レコード順次番号が01のレコードの傷病名を設定する。
	                    // 01のレコードがない場合は99のレコードの値を採用する。
	                    ACChotarouXMLUtilities.setValue(writer, diagnosisFirstMap,"501008", "tokuteishinryo.syoubyo.w4");
	                    
	                    //特定診療費の合計欄を出力
	                    if(diagnosisLastMap != null){
	                        //特定診療費の保険分単位数の合計を設定する。 ※特定診療費情報レコード順次番号が99の値を採用する。
	                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryohokentanitotal", pad(diagnosisLastMap.get("501013"),5));
	                        
	                    }
                	}
                    if(isDetailListShow(kohiCount)){
	                    //請求額集計欄　保険分================================
	                    //給付単位数を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "kyufutani", pad(typeMap.get("701014"),6));
	                    //単位数単価を設定する。
	                    ACChotarouXMLUtilities.setValue(writer, "tanisutani", getTanka(typeMap.get("701015")));
	                    
	                    if(kohiCount == 0){
	                        //保険給付率を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "hokenkyufu", pad(baseMap.get("201029"),3));
	                        //保険請求額を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu", pad(typeMap.get("701016"),6));
	                        // 利用者負担額（保険分）を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "hokenriyousyahutan",pad(typeMap.get("701017"),6));
	                    }
	                    
	                    
	                    //請求額集計欄　公費分===============================
	                    switch(kohiCount){
	                    //公費1
	                    case 0:
	                        if(ACCastUtilities.toInt(typeMap.get("701018"),0) != 0){
	                            //公費分単位数を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohibuntani", pad(typeMap.get("701018"),6));
	                            //公費給付率を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201030"),3));
	                            //公費請求額を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701019"),6));
	                            // 利用者負担額（公費分）を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohiriyousyahutan", pad(typeMap.get("701020"),6));
	                        }
	                        break;
	                    //公費2
	                    case 1:
	                        if(ACCastUtilities.toInt(typeMap.get("701021"),0) != 0){
	                            //公費分単位数を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohibuntani", pad(typeMap.get("701021"),6));
	                            //公費給付率を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201031"),3));
	                            //公費請求額を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701022"),6));
	                            // 利用者負担額（公費分）を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohiriyousyahutan", pad(typeMap.get("701023"),6));
	                        }
	                        break;
	                    //公費3
	                    case 2:
	                        if(ACCastUtilities.toInt(typeMap.get("701024"),0) != 0){
	                            //公費分単位数を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohibuntani", pad(typeMap.get("701024"),6));
	                            //公費給付率を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201032"),3));
	                            //公費請求額を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701025"),6));
	                            // 利用者負担額（公費分）を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohiriyousyahutan", pad(typeMap.get("701026"),6));
	                        }
	                        break;
	                    }
                    }
                    if(isDiagnosisListShow(kohiCount,diagnosisLastMap)){
	                    //請求額集計欄　保険分特定診療費======================
	                    if(diagnosisLastMap != null){
	                        //保険分特定診療費の給付単位数を設定する。
	                        ACChotarouXMLUtilities.setValue(writer, "hokentokuteikyufutani", pad(diagnosisLastMap.get("501013"),6));
	                        
	                        if(kohiCount == 0){
	                            //保険分特定診療費給付率を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "hokentokuteikyufu", pad(baseMap.get("201029"),3));
	                            //特定診療費請求額
	                            ACChotarouXMLUtilities.setValue(writer, "hokentokuteiseikyu", pad(baseMap.get("201037"),6));
	                            //特定診療費利用者負担額
	                            ACChotarouXMLUtilities.setValue(writer, "hokentokuteiriyousyafutan", pad(typeMap.get("701029"),6));
	                        }
	                        
	                        switch(kohiCount){
	                        case 0:
	                            //特定診療費の公費分単位数の合計を設定する。　※特定診療費情報レコード順次番号が99の値を採用する。
	                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501016"),5));
	                            //公費分特定診療費の給付単位数を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufutani", pad(diagnosisLastMap.get("501016"),6));
	                            //公費給付率を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufu", pad(baseMap.get("201030"),3));
	                            //公費請求額を設定する。
	                            //ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(baseMap.get("201043"),6));
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701031"),6));
	                            //利用者負担額を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyafutan", pad(typeMap.get("701032"),6));
	                            break;
	                        case 1:
	                            //特定診療費の公費分単位数の合計を設定する。　※特定診療費情報レコード順次番号が99の値を採用する。
	                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501019"),5));
	                            //公費分特定診療費の給付単位数を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufutani", pad(diagnosisLastMap.get("501019"),6));
	                            //公費給付率を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufu", pad(baseMap.get("201031"),3));
	                            //公費請求額を設定する。
	                            //ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(baseMap.get("201049"),6));
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701034"),6));
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyafutan", pad(typeMap.get("701035"),6));
	                            break;
	                        case 2:
	                            //特定診療費の公費分単位数の合計を設定する。　※特定診療費情報レコード順次番号が99の値を採用する。
	                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501022"),5));
	                            //公費分特定診療費の給付単位数を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufutani", pad(diagnosisLastMap.get("501022"),6));
	                            //公費給付率を設定する。
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufu", pad(baseMap.get("201032"),3));
	                            //公費請求額を設定する。
	                            //ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(baseMap.get("201055"),6));
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701037"),6));
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyafutan", pad(typeMap.get("701038"),6));
	                            break;
	                        }
	                    }
                    }
                    if((nursingLast != null) && (nursingCount == kohiCount)){
                        //費用額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyototal",pad(nursingLast.get("801022"),6));
                        //保険者負担額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,"tokuteihokentotal", pad(nursingLast.get("801023"),6));
                        //保険分請求額を設定する。
                        //[ID:0000449][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
                        //ACChotarouXMLUtilities.setValue(writer,"tokuteiriyoshatotal", pad(nursingLast.get("801024"),5));
                        ACChotarouXMLUtilities.setValue(writer,"tokuteiriyoshatotal", pad0(nursingLast.get("801024"),5));
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
                //印刷ページ総数が2枚以上の場合
                //if ((kohiCountTotal * pageCount) > 1) {
                if ((pageCountMax) > 1) {
                    //出力ページ数の総数を設定する。
//                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
//                            ACCastUtilities.toString((kohiCountTotal * pageCount)));
                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
                            ACCastUtilities.toString((pageCountMax)));
                    //現在の出力ページ数を設定する。
//                    ACChotarouXMLUtilities.setValue(writer, "nowpage",
//                            ACCastUtilities.toString(((kohiCount * pageCount) +i + 1)));
                    ACChotarouXMLUtilities.setValue(writer, "nowpage",
                            ACCastUtilities.toString(printPage));
                }

                //ページ終了
                writer.endPageEdit();
            }
        }

        return true;

    }

}
