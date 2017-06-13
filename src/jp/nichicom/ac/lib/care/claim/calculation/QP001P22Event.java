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
 * 作成日: 2008/02/28  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 介護保険サービス利用請求書 (001)
 * プログラム 介護保険サービス利用請求書 (QP001P23_27_1Event)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;


/**
 * 利用者向け請求書・領収書詳細版印刷クラスの基底クラス
 */
public class QP001P22Event {
    
    ACDateFormat eraFormat = new ACDateFormat("ggg");
    ACDateFormat eraYearFormat = new ACDateFormat("ee");
    ACDateFormat monthFormat = new ACDateFormat("MM");
    ACDateFormat dayFormat = new ACDateFormat("dd");
    private NumberFormat nf = NumberFormat.getInstance();
    
    //印刷クラス
    ACChotarouXMLWriter writer = null;
    //印刷用データ
    VRMap style = null;
    //介護サービス利用
    VRMap serviceDetail = null;
    //請求年月日
    private Date seikyuDate = null;
    //請求対象年月日
    private Date targetDate = null;
    //領収年月日
    Date ryousyuDate = null;
    
    //事業所名称
    VRMap provider = null;
    //居宅介護事業所
    VRMap care_provider = null;
    private String patientName = "";
    VRMap printSetting = null;
    
    //小計・合計を印刷するにチェック
    private boolean isTotalCheck = false;
    
    // 変更する背景色
    String SERVICE_TOTAL_BACK_COLOR = "#E1E1E1";
    
    /**
     * コンストラクタです。
     */
    public QP001P22Event() {
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
    public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception{
        this.writer = writer;
        this.style = (VRMap)printParam.get("STYLE_DATA");
        //利用者請求情報
        this.serviceDetail = (VRMap)printParam.get("CLAIM_PATIENT_DETAIL");
        this.provider = (VRMap)printParam.get("PROVIDER");
        care_provider = (VRMap)printParam.get("CARE_PROVIDER");
        patientName = ACCastUtilities.toString(printParam.get("PATIENT_NAME"));
        printSetting = (VRMap)printParam.get("PRINT_SETTING");
        
        //請求年月日
        if(!ACTextUtilities.isNullText(VRBindPathParser.get("TARGET_DATE",printSetting))){
            seikyuDate = ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE",printSetting),null);
        }
        
        //請求対象年月日
        targetDate = ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE",this.style),null);
        
        //領収年月日
        if(!ACTextUtilities.isNullText(VRBindPathParser.get("GET_DATE",printSetting))){
            ryousyuDate = ACCastUtilities.toDate(VRBindPathParser.get("GET_DATE",printSetting));
        }
        
        //小計・合計を印刷するにチェック
        if(ACCastUtilities.toInt(VRBindPathParser.get("TOTAL_CHECK",printSetting),0) == 1){
            isTotalCheck = true;
        }
        
        return doPrint();
    }
    
    /**
     * 各帳票共通のデータ設定を行います。<br>
     * 各帳票の違い<br>
     * QP001P221 - 通常利用請求書<br>
     * QP001P222 - 通常利用請求書+振込先口座付<br>
     * QP001P223 - 通常利用領収書(利用請求書と頭書きが異なるのみ)<br>
     * QP001P224 - 通常利用領収書+振込先口座付<br>
     * QP001P225 - 通常利用領収書+領収額<br>
     * <br>
     * @throws Exception
     */
    protected void setBasicData() throws Exception {
        
        int riyousya = 0;
        int zengaku = 0;
        int kohi = 0;
        int etc = 0;
        boolean isSyokuhiOnly = true;
        
        //請求日が入力されていれば
        if(seikyuDate != null){
            // 請求年月日の和暦を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyuDate.h1.w1", eraFormat.format(seikyuDate));
            // 請求年月日の和暦年(YYフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyuDate.h1.w2", eraYearFormat.format(seikyuDate));
            // 請求年月日の月(MMフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyuDate.h1.w4", monthFormat.format(seikyuDate));
            // 請求年月日の日(DDフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyuDate.h1.w6", dayFormat.format(seikyuDate));
        }
        
        if(ryousyuDate != null){
            // 請求年月日の和暦を設定する。
            ACChotarouXMLUtilities.setValue(writer, "ryousyuDate.h1.w1", eraFormat.format(ryousyuDate));
            // 請求年月日の和暦年(YYフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "ryousyuDate.h1.w2", eraYearFormat.format(ryousyuDate));
            // 請求年月日の月(MMフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "ryousyuDate.h1.w4", monthFormat.format(ryousyuDate));
            // 請求年月日の日(DDフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "ryousyuDate.h1.w6", dayFormat.format(ryousyuDate));
        }

        // 請求の対象者を設定する。
        ACChotarouXMLUtilities.setValue(writer, "riyosya", patientName);

        //請求の対象日を設定する。
        if(targetDate != null){
            //請求対象年月日の和暦を設定する。
            ACChotarouXMLUtilities.setValue(writer, "targetDate.h1.w2", eraFormat.format(targetDate));
            //請求対象の和暦年(YYフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "targetDate.h1.w3", eraYearFormat.format(targetDate));
            //請求対象の和暦月(MMフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "targetDate.h1.w5", monthFormat.format(targetDate));
        }
        
        //サービス名
        String serviceName = "";
        
        //利用者負担のデータを設定
        //歴史的背景により、バインドパスが連番ではないので注意
        for (int row = 1,i = 0; row <= 10; row++, i+=2){
        	String row_name = Integer.toString(row);
        	
        	// [2014年要望][Shinobu Hitaka] 2015/04/15 edit begin 
        	//--add begin
        	// 利用者負担0円印字の場合は、サービス種類合計レコードのサービス名先頭に*が付加されている
        	String tmpServiceName = ACCastUtilities.toString(style.getData(Integer.toString(1601001 + i)),"");
        	Boolean totalFlag = false;
        	if (tmpServiceName.length() > 1){
	        	if ("*".equals(tmpServiceName.substring(0, 1))) {
	        		totalFlag = true;
	        		tmpServiceName = tmpServiceName.substring(1);
	        	}
        	}
        	//--add end
        	//--edit begin
            // 利用者負担が発生する場合はインデント＋背景色変更
            //if(!"".equals(getFormatData(style, Integer.toString(1601001 + i + 1)))){
            if(!"".equals(getFormatData(style, Integer.toString(1601001 + i + 1))) || totalFlag){
                // サービス名を設定する。
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".service",SERVICE_TOTAL_BACK_COLOR);
                // 単位数を設定する。
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".unit",SERVICE_TOTAL_BACK_COLOR);
                // 回数を設定する
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".count",SERVICE_TOTAL_BACK_COLOR);
                // 利用者負担額を設定する。
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".futan",SERVICE_TOTAL_BACK_COLOR);
                // サービス名にインデントを入れる
                //serviceName = "　" + style.getData(Integer.toString(1601001 + i));
                serviceName = "　" + tmpServiceName;
            } else {
                // 通常
                //ACCastUtilities.toString(style.getData(Integer.toString(1601001 + i)),"");
                serviceName = tmpServiceName;
            }
            //--edit end
        	// [2014年要望][Shinobu Hitaka] 2015/04/15 edit end

            ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".service", serviceName);
            // 単位数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".unit", getFormatData(style, Integer.toString(1601038 + i)));
            // 回数を設定する
            ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".count", getFormatData(style, Integer.toString(1601038 + i + 1)));
            // 利用者負担額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".futan", getFormatData(style, Integer.toString(1601001 + i + 1)));
            
            riyousya += ACCastUtilities.toInt(style.get(Integer.toString(1601001 + i + 1)),0);
            isSyokuhiOnly = analizeServiceName(serviceName,isSyokuhiOnly);
        }
        
        //11列目から19列目まで印字
        for (int row = 11,i = 0; row <= 19; row++, i+=4){
        	String row_name = Integer.toString(row);
        	
        	// [2014年要望][Shinobu Hitaka] 2015/04/15 edit begin 
        	// 利用者負担0円印字の場合は、サービス種類合計レコードのサービス名先頭に*が付加されている
        	//--add begin
        	String tmpServiceName = ACCastUtilities.toString(style.getData(Integer.toString(1601062 + i)),"");
        	Boolean totalFlag = false;
        	if (tmpServiceName.length() > 1){
	        	if ("*".equals(tmpServiceName.substring(0, 1))) {
	        		totalFlag = true;
	        		tmpServiceName = tmpServiceName.substring(1);
	        	}
        	}
        	//--add end
        	//--edit begin
            // 利用者負担が発生する場合はインデント＋背景色変更
            if(!"".equals(getFormatData(style, Integer.toString(1601062 + i + 3))) || totalFlag){
                // サービス名を設定する。
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".service",SERVICE_TOTAL_BACK_COLOR);
                // 単位数を設定する。
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".unit",SERVICE_TOTAL_BACK_COLOR);
                // 回数を設定する
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".count",SERVICE_TOTAL_BACK_COLOR);
                // 利用者負担額を設定する。
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".futan",SERVICE_TOTAL_BACK_COLOR);
                // サービス名にインデントを入れる
                //serviceName = "　" + style.getData(Integer.toString(1601062 + i));
                serviceName = "　" + tmpServiceName;
            } else {
                // 通常
                //ACCastUtilities.toString(style.getData(Integer.toString(1601062 + i)),"");
                serviceName = tmpServiceName;
            }
            //--edit end
        	// [2014年要望][Shinobu Hitaka] 2015/04/15 edit end
            
            ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".service", serviceName);
        	//単位数
        	ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".unit", getFormatData(style, Integer.toString(1601062 + i + 1)));
        	//回数
        	ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".count", getFormatData(style, Integer.toString(1601062 + i + 2)));
        	//利用者負担額
            ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".futan", getFormatData(style, Integer.toString(1601062 + i + 3)));

        	riyousya += ACCastUtilities.toInt(style.get(Integer.toString(1601062 + i + 3)),0);
            isSyokuhiOnly = analizeServiceName(serviceName,isSyokuhiOnly);
        }
        
        if(serviceDetail != null){
            //全額自己負担のデータを設定する。※利用者負担欄との違いの都合上グリッドがseikyuではない点に注意
            for (int i = 1; i <= 3; i++){
            	String target_name = Integer.toString(i);
                // サービス名１を設定する。 ※CLAIM_PATIENT_DETAILより取得
                ACChotarouXMLUtilities.setValue(writer, serviceDetail, "SELF_SERVICE_NO" + target_name,"zengaku.z" + target_name + ".service");
                // 利用者負担額１を設定する。 ※CLAIM_PATIENT_DETAILより取得
                ACChotarouXMLUtilities.setValue(writer, "zengaku.z" + target_name + ".futan", getFormatData(serviceDetail, "SELF_PAY_NO" + target_name));
            	zengaku += ACCastUtilities.toInt(serviceDetail.get("SELF_PAY_NO" + target_name),0);
            } 
        }
        
        //公費本人負担のデータを設定する。 ※利用者負担欄との違いの都合上グリッドがseikyuではない点に注意
        // サービス名１を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "1601021","kohi.k1.service");
        // 利用者負担額１を設定する。
        ACChotarouXMLUtilities.setValue(writer, "kohi.k1.futan", getFormatData(style, "1601022"));
        // サービス名２を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "1601023","kohi.k2.service");
        // 利用者負担額２を設定する。
        ACChotarouXMLUtilities.setValue(writer, "kohi.k2.futan", getFormatData(style, "1601024"));
        
        kohi += ACCastUtilities.toInt(style.get("1601022"),0);
        kohi += ACCastUtilities.toInt(style.get("1601024"),0);
        
        if(serviceDetail != null){
            //その他のデータを設定する。
            for (int i = 1; i <= 6; i++){
            	String target_name = Integer.toString(i);
                // サービス名を設定する。
                ACChotarouXMLUtilities.setValue(writer, serviceDetail, "OTHER_HIMOKU_NO" + target_name,"seikyuetc.e" + target_name + ".service");
                // 単位数を設定する。 ※CLAIM_PATIENT_DETAILより取得
                ACChotarouXMLUtilities.setValue(writer, "seikyuetc.e" + target_name + ".unit", getFormatData(serviceDetail, "OTHER_UNIT_NO" + target_name));
                // 回数を設定する。 ※CLAIM_PATIENT_DETAILより取得
                ACChotarouXMLUtilities.setValue(writer, "seikyuetc.e" + target_name + ".count", getFormatData(serviceDetail, "OTHER_COUNT_NO" + target_name));
                // 利用者負担額を設定する。 ※CLAIM_PATIENT_DETAILより取得
                ACChotarouXMLUtilities.setValue(writer, "seikyuetc.e" + target_name + ".futan", getFormatData(serviceDetail, "OTHER_PAY_NO" + target_name));
            	etc += ACCastUtilities.toInt(serviceDetail.get("OTHER_PAY_NO" + target_name),0);
            }
        }

        // 事業所名を設定する。
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_NAME","jigyosyoname");
        // 事業所の所在地を設定する。
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_ADDRESS","address");
        // 事業所の電話番号を設定する。
        ACChotarouXMLUtilities.setValue(writer, "tel", QkanCommon.toTel(provider.get("PROVIDER_TEL_FIRST"),provider.get("PROVIDER_TEL_SECOND"),provider.get("PROVIDER_TEL_THIRD")));
        // 事業所の管理者氏名を設定する。
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_OWNER_NAME","kanrisya");
        
        // 小計・合計を印刷するにチェックがついている場合、
        if(isTotalCheck){
            // 利用者負担の利用者負担額小計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyu.total1.futan", getFormatData(riyousya));
            // 全額自己負担の利用者負担額小計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyu.total2.futan", getFormatData(zengaku));
            // 公費本人負担の本人負担額小計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyu.total3.futan", getFormatData(kohi));
            // その他の利用料小計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyuetc.total4.futan", getFormatData(etc));
            //総合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyuetc.total5.futan",getFormatData(riyousya + zengaku + kohi + etc));
            // 請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyutotal", getFormatData(riyousya + zengaku + kohi + etc));
        }
        
        // 小計・合計を印刷するにチェックがついている場合、
        if(getIsTotalCheck()){
            // 請求額を設定する。
        	if(serviceDetail != null){
        		// 利用者向け請求レコードが作成されている場合
        		// ユーザの入力に従い印字する。※"0"は"0"として印字する。
        		ACChotarouXMLUtilities.setValue(writer, "innertax", getFormatDataExceptZero(serviceDetail, "INNER_TAX"));
        	}else{
        		// 利用者向け請求レコードが作成されていない場合
        		// "0"を初期値として印字する。
        		ACChotarouXMLUtilities.setValue(writer, "innertax", "0");
        	}
        }
        
        printCalendar(riyousya, isSyokuhiOnly);
        
// 2016/1/28 [2015年要望][Yoichiro Kamei] add - begin 備考欄追加
        if(serviceDetail != null){
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "REMARKS","comment");
        }
// 2016/1/28 add - end
    }
    
    /**
     * 提供日カレンダーの印字を行う。
     * @throws Exception
     */
    private void printCalendar(int riyousya, boolean isSyokuhiOnly) throws Exception {
    	//serviceDetail(詳細)
    	//serviceAbbr(名前解決)
    	
    	//印字用のデータ取得
    	//提供日
    	int[] offerDays = getOfferDays();
    	//マーク種類
    	//String[] marks = new String[]{"○", "◎", "□", "△", "◇", "▽", "☆"};
    	String[] marks = QkanConstants.CLAIM_PATIENT_DETAIL_SERVICE_MARK;
    	
    	//カレンダーの数値打ち出し
    	int day = 1;
    	int monthEnd = ACDateUtilities.getLastDayOfMonth(targetDate);
    	int startWeek = 0;
    	
    	//どこから印字を開始するか判定
    	switch(ACDateUtilities.getDayOfWeek(targetDate)){
    	case Calendar.SUNDAY:		startWeek = 1;	break;
    	case Calendar.MONDAY:		startWeek = 2;	break;
    	case Calendar.TUESDAY:		startWeek = 3;	break;
    	case Calendar.WEDNESDAY:	startWeek = 4;	break;
    	case Calendar.THURSDAY:		startWeek = 5;	break;
    	case Calendar.FRIDAY:		startWeek = 6;	break;
    	case Calendar.SATURDAY:		startWeek = 7;	break;
    	}
    	
    	String gridName = getGridName();
    	//提供サービス凡例出力
    	ACChotarouXMLUtilities.setValue(writer, "serviceMarkComment", getLegend(offerDays, marks, riyousya, isSyokuhiOnly, gridName));
    	
    	
    	//カレンダー生成メイン
    	end:for (int i = 1; i < 7; i++) {
    		for (int j = startWeek; j < 8; j++) {
    			//日付出力
    			ACChotarouXMLUtilities.setValue(writer, "days.h" + i + ".w" + j, String.valueOf(day));
    			//マーク出力serviceMarkSingle
    			String mark = getMarks(offerDays, marks, day);
    			ACChotarouXMLUtilities.setValue(writer, gridName + ".h" + i + ".w" + j, mark);
    			
    			day++;
    			if (day > monthEnd){
    				break end;
    			}
    		}
    		startWeek = 1;
    	}
    }
    
    private String getGridName() throws Exception {
    	
    	String result = "serviceMarkSingle";
    	
    	if (serviceDetail == null) {
    		return result;
    	}
    	
    	
		String key = "MARK2_SERVICE_NAME";
		if (serviceDetail.containsKey(key)){
			if(!"".equals(ACCastUtilities.toString(serviceDetail.get(key), ""))) {
				result = "serviceMarkMulti";
			}
		}
    	
    	return result;
    }
    
    
    /**
     * 該当日のマークを生成
     * @param offerDays
     * @param marks
     * @param day
     * @return
     * @throws Exception
     */
    private String getMarks(int[] offerDays, String[] marks, int day) throws Exception {
    	StringBuilder mark = new StringBuilder();
    	
    	for (int i = 0; i < offerDays.length; i++){
    		if (offerDays[i] == 0) continue;
    		
    		int daybit = 1 << (day - 1);
    		if ((offerDays[i] & daybit) == daybit) {
    			mark.append(marks[i]);
    		}
    	}
    	
    	return mark.toString();
    }
    
    /**
     * 提供日データ取得
     * @return
     * @throws Exception
     */
    private int[] getOfferDays() throws Exception {
    	int[] offerDays = new int[]{0, 0, 0, 0, 0, 0, 0};
    	
    	if (serviceDetail == null) {
    		return offerDays;
    	}
    	
    	for (int i = 1; i <= offerDays.length; i++) {
    		String key = "MARK" + i + "_SERVICE_DATE_BIT";
    		if (serviceDetail.containsKey(key)){
    			offerDays[i - 1] = ACCastUtilities.toInt(serviceDetail.get(key), 0);
    		}
    	}
    	
    	return offerDays;
    }
    
    /**
     * 凡例生成
     * @param marks
     * @return
     * @throws Exception
     */
    private String getLegend(int[] offerDays, String[] marks, int riyousya, boolean isSyokuhiOnly, String gridName) throws Exception {
    	StringBuilder legend = new StringBuilder();
    	
    	if (serviceDetail == null) {
    		return "";
    	}
    	
    	/*
		●サービスの種類が複数ある場合（利用者負担の発生の有無は問わない）
		　→サービスの凡例を表示する。
		
		●サービスの種類が単一の場合（利用者負担が発生してない場合）
		　→サービスの凡例を表示する。
		
		●サービスの種類が単一の場合（利用者負担が発生している場合）
		　→サービスの凡例を表示しない。
		※ただし、食費・居住費のみの場合は、サービスの凡例を表示する。 
    	 */
    	if (("serviceMarkSingle".equals(gridName))
    		&& (riyousya != 0)
    		&& !isSyokuhiOnly) {
    		return "";
    	}
    	
    	for (int i = 1; i <= offerDays.length; i++) {
    		//提供がなければ処理を行わない
    		if (offerDays[i - 1] == 0) {
    			continue;
    		}
    		
    		String key = "MARK" + i + "_SERVICE_NAME";
    		if (serviceDetail.containsKey(key)){
    			
				if (legend.length() > 0) {
					legend.append(" ");
				}
				legend.append(marks[i - 1]);
				legend.append("：");
				legend.append(ACCastUtilities.toString(serviceDetail.get(key), ""));
    		}
    	}
    	return legend.toString();
    }
    
    private boolean analizeServiceName(String serviceName, boolean before) throws Exception {
    	
    	if (ACTextUtilities.isNullText(serviceName)) {
    		return before;
    	}
    	
    	if ((serviceName.indexOf("食費") != -1)
    		|| (serviceName.indexOf("居住費") != -1)){
    		
    		//食費・居住費のサービス
    		//これまでの解析も食費・居住費のみ
    		return before;
    	}
    	
    	return false;
    	
    }
    
    private String getFormatData(int value) throws Exception {
        if(value == 0) return "";
        return nf.format((double)(value));
    }
    
    
    /**
     * 印刷を実行します。
     * 印刷実行に必用なデータは全て親クラスで保持しています。
     * @return
     * @throws Exception
     */
    public boolean doPrint() throws Exception{
        return false;
    }
    
    public String getFormatDataExceptZero(VRMap style,String key) throws Exception{
        String value = String.valueOf(style.get(key));
        
        // "0"の場合は""を返却しない。
        if(ACTextUtilities.isNullText(value) || value.equalsIgnoreCase("NULL")){
            return "";
        }
        
        return getNf().format(ACCastUtilities.toDouble(value,0));
    }
    
    public String getFormatData(VRMap style,String key) throws Exception{
        String value = String.valueOf(style.get(key));
        
        if(ACTextUtilities.isNullText(value) || "0".equals(value) || value.equalsIgnoreCase("NULL")){
            return "";
        }
        
        return nf.format(ACCastUtilities.toDouble(value,0));
    }

	/**
	 * @return isTotalCheck を戻します。
	 */
	public boolean getIsTotalCheck() {
		return isTotalCheck;
	}

	/**
	 * @param isTotalCheck isTotalCheck を設定。
	 */
	public void setIsTotalCheck(boolean isTotalCheck) {
		this.isTotalCheck = isTotalCheck;
	}
	/**
	 * @return nf を戻します。
	 */
	public NumberFormat getNf() {
		return nf;
	}

	/**
	 * @param nf nf を設定。
	 */
	public void setNf(NumberFormat nf) {
		this.nf = nf;
	}

}
