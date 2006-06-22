
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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/01/17  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 訪問看護報告書 (00201)
 * プログラム 訪問看護報告書 (QC00201)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc002;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * 訪問看護報告書(QC00201) 
 * 帳票定義体ファイル名 ： QC00201.xml
 */
public class QC002P01 extends QC002P01Event {
  /**
   * コンストラクタです。
   */
  public QC002P01(){
  }

  /**
   * 帳票を生成します。
   * @param writer 印刷管理クラス
   * @param printParameters 印刷パラメタ
   * @throws Exception 処理例外
   */
  public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
    //必要であれば帳票IDを書き換えること。
    ACChotarouXMLUtilities.addFormat(writer, "QC002P01", "QC002P01.xml");
    //ページ開始
    writer.beginPageEdit("QC002P01");
    
    VRMap printParameters = (VRMap)printParam.getData("HOUKOKUSYO_INFO");
    VRMap printCalendar = (VRMap)printParam.getData("CALENDAR"); 
    
      // 利用者氏名を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParameters, "PATIENT_NAME", "patient.patientName.value");
    Date patientBirthDay = null;
    String era = "";
    // 渡りパラメータprintParamのKEY:PATIENT_BIRTHDAYのVALUEを取得する。
    if(VRBindPathParser.has("PATIENT_BIRTHDAY",printParameters)){
    	patientBirthDay = (Date)VRBindPathParser.get("PATIENT_BIRTHDAY",printParameters);
    	//取得した値を和暦に変換する。
    	era = ACDateUtilities.getEraFull(patientBirthDay);
    }
    // 年号によって分岐する。
    // 　明治の場合
    if("明治".equals(era)){
    	//「大正」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
	    //「昭和」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
	    //「平成」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
	    
    // 　大正の場合
    }else if("大正".equals(era)){
    	//「明治」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
	    //「昭和」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
	    //「平成」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
    
    // 　昭和の場合
    }else if("昭和".equals(era)){
    	//「明治」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
	    //「大正」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
	    //「平成」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
    
    // 　平成の場合
    }else if("平成".equals(era)){
	    //「明治」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
	    //「大正」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
	    //「昭和」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
    } else {
        //「明治」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
        //「大正」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
        //「昭和」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
        //「平成」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
    }
    
    // 年を設定する。
    ACChotarouXMLUtilities.setValue(writer,"patientBirthDay.h1.year",new Integer(ACDateUtilities.getEraYear(patientBirthDay)));
    
    // 月を設定する。
    ACChotarouXMLUtilities.setValue(writer,"patientBirthDay.h1.month",new Integer(ACDateUtilities.getMonth(patientBirthDay)));

    // 日を設定する。
    ACChotarouXMLUtilities.setValue(writer,"patientBirthDay.h1.day",new Integer(ACDateUtilities.getDayOfMonth(patientBirthDay)));

    // 利用者年齢を設定する。
    int patientAge = QkanCommon.calcAge(patientBirthDay);
    ACChotarouXMLUtilities.setValue(writer,"patientBirthDay.h1.age",new Integer(patientAge));
    
    // 要介護度
    int jotaiCode = ACCastUtilities.toInt(printParameters.getData("JOTAI_CODE"), 1);
    
    // 渡りパラメータprintParamののKEY:JOTAI_CODEのVALUEによって分岐する。
    switch(jotaiCode){
    // 　「自立」の場合
    case 1:
	    //「経過的要介護」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
	    //「要介護１」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
	    //「要介護２」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
	    //「要介護３」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
	    //「要介護４」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
	    //「要介護５」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //｢要支援1｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //｢要支援2｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
        break;

	    
    // 　「経過的要介護」の場合
    case 11:
	    //「自立」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
	    //「要介護１」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
	    //「要介護２」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
	    //「要介護３」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
	    //「要介護４」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
	    //「要介護５」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
	    //｢要支援1｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //｢要支援2｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
    	break;

        //｢要支援1」の場合
    case 12:
//      「自立」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
        //｢経過的要介護｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
//      ｢要支援2｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
        //「要介護１」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
        //「要介護２」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
        //「要介護３」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
        //「要介護４」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
        //「要介護５」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //処理を終了する。
        break;
        //｢要支援2｣の場合
    case 13:
//      「自立」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
        //｢経過的要介護｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
//      ｢要支援1｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //「要介護１」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
        //「要介護２」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
        //「要介護３」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
        //「要介護４」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
        //「要介護５」のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //処理を終了する。
        break;

    // 　「要介護１」の場合
    case 21:
	    //「自立」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
	    //「経過的要介護」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
	    //「要介護２」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
	    //「要介護３」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
	    //「要介護４」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
	    //「要介護５」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //｢要支援1｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //｢要支援2｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
        break;

    // 　「要介護２」の場合
    case 22:
	    //「自立」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
	    //「経過的要介護」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
	    //「要介護１」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
	    //「要介護３」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
	    //「要介護４」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
	    //「要介護５」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //｢要支援1｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //｢要支援2｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
        break;

    // 　「要介護３」の場合
    case 23:
	    //「自立」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
	    //「経過的要介護」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
	    //「要介護１」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
	    //「要介護２」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
	    //「要介護４」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
	    //「要介護５」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //｢要支援1｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //｢要支援2｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
        break;

    // 　「要介護４」の場合
    case 24:
	    //「自立」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
	    //「経過的要介護」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
	    //「要介護１」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
	    //「要介護２」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
	    //「要介護３」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
	    //「要介護５」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //｢要支援1｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //｢要支援2｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
        break;
        
    // 　「要介護５」の場合
    case 25:
    	//「自立」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
	    //「経過的要介護」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
	    //「要介護１」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
	    //「要介護２」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
	    //「要介護３」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
	    //「要介護４」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
        //｢要支援1｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //｢要支援2｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
        break;
        
    default:
//    	//「自立」のシェイプを非表示にする。
//	    ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
	    //「経過的要介護」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
	    //「要介護１」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
	    //「要介護２」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
	    //「要介護３」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
	    //「要介護４」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
	    //「要介護５」のシェイプを非表示にする。
	    ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
        //｢要支援1｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
        //｢要支援2｣のシェイプを非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "nursState13");        
        break;

    }
    
    // 利用者住所を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParameters, "PATIENT_ADDRESS", "patient.address.value");
    // 渡りパラメータprintParamのKEY:PRINT_CALENDAR_LEFT_MONTHのVALUEを取得する。
    Date leftDate = (Date)printParameters.getData("PRINT_CALENDAR_LEFT_MONTH");
    // 取得した値を「ggge年M月」(和暦)の形式にする。
    VRDateFormat vf = new VRDateFormat("ggge年M月");
    
    String strLeftDate = vf.format(leftDate);    
    
    // 訪問日(左)年月を設定する。
    //     setValue(visitDateLeft);
    ACChotarouXMLUtilities.setValue(writer,"visitDateLeft",strLeftDate);

    // 渡りパラメータprintParamのKEY:PRINT_CALENDAR_RIGHT_MONTHのVALUEを取得する。
    Date rightDate = (Date)printParameters.getData("PRINT_CALENDAR_RIGHT_MONTH");
    // 取得した値を「ggge年M月」(和暦)の形式にする。
    String strRighrDate = vf.format(rightDate);
    // 訪問日(右)年月を設定する。   
    ACChotarouXMLUtilities.setValue(writer,"visitDateRight",strRighrDate);       
    
    int maxLeftDay = ACDateUtilities.getDayOfMonth(ACDateUtilities.toLastDayOfMonth(leftDate));
    
    switch (maxLeftDay) {
	case 28:
	    // 　　　28日の場合
	    // 　　　　28日用の日付コンボの表示設定を行う。
		 ACChotarouXMLUtilities.setValue(writer,"calendarLeft.h5.w1","");
		 ACChotarouXMLUtilities.setValue(writer,"calendarLeft.h5.w2","");
		 ACChotarouXMLUtilities.setValue(writer,"calendarLeft.h5.w3","");

		break;
    
	case 29:
	    // 　　　29日の場合
	    // 　　　　29日用の日付コンボの表示設定を行う。		
		 ACChotarouXMLUtilities.setValue(writer,"calendarLeft.h5.w2","");
		 ACChotarouXMLUtilities.setValue(writer,"calendarLeft.h5.w3","");
		 
		 break;
	case 30:
	    // 　　　30日の場合
	    // 　　　　30日用の日付コンボの表示設定を行う。
		 ACChotarouXMLUtilities.setValue	(writer,"calendarLeft.h5.w3","");

		 break;
	}
    
    int maxRightDay = ACDateUtilities.getDayOfMonth(ACDateUtilities.toLastDayOfMonth(rightDate));
    
    switch (maxRightDay) {
	case 28:
	    // 　　　28日の場合
	    // 　　　　28日用の日付グリッドの表示設定を行う。
		 ACChotarouXMLUtilities.setValue(writer,"calendarRight.h5.w1","");
		 ACChotarouXMLUtilities.setValue(writer,"calendarRight.h5.w2","");
		 ACChotarouXMLUtilities.setValue(writer,"calendarRight.h5.w3","");

		 break;
    
	case 29:
	    // 　　　29日の場合
	    // 　　　　29日用の日付グリッドの表示設定を行う。		
		 ACChotarouXMLUtilities.setValue(writer,"calendarRight.h5.w2","");
		 ACChotarouXMLUtilities.setValue(writer,"calendarRight.h5.w3","");


		 break;
	case 30:
	    // 　　　30日の場合
	    // 　　　　30日用の日付グリッドの表示設定を行う。
		 ACChotarouXMLUtilities.setValue(writer,"calendarRight.h5.w3","");

		 break;
	}
    
    
    
    java.util.Iterator it = printCalendar.entrySet().iterator();
	 //StringのKEY名を格納する変数
	 String strKey = "";
	 
	 //
	 
	 while(it.hasNext()){
		 //キー名を取得
		 Map.Entry key = (Map.Entry)it.next();
		 //KEYをString型で格納
		 strKey = String.valueOf(key.getKey());
		 
		 int intKey = 0;
		 //値が空白もしくはnullだった場合は初期値を設定する
		 if(key.getValue()=="" || key.getValue() == null){
			 intKey = 1;
		 }else{
			 //現在のKEY名の値を取得
			 intKey = Integer.parseInt(String.valueOf(key.getValue()));
		 }

		 //グリッドの行数を格納する変数
		 String gridRow = "";
		 //日付の日に当たる部分を数値として取得する
		 int dayCount = 0;
		 //計算用の値を格納する変数
		 int calcIndex = 0;
		 //カレンダーの種類を格納する
		 String type = "";
		 
		 if(strKey.indexOf("CALENDAR_LEFT_D") == 0){
			 //KEY名から日付の日を取得
			 dayCount = Integer.parseInt(strKey.substring(17,strKey.length()));
			 //カレンダー左である場合
			 type = "Left";
			 
		 }else if(strKey.indexOf("CALENDAR_RIGHT_D") == 0){
			 //KEY名から日付の日を取得
			 dayCount = Integer.parseInt(strKey.substring(18,strKey.length()));
			 //カレンダー（右）である場合
			 type = "Right";

		 }
		 	
		 	 //KEYの日付部分からグリッド（縦）を決定する
			 if(dayCount<8){
				 gridRow = "h1";
				 calcIndex = 0;
			 }else if(dayCount<15){
				 gridRow = "h2";
				 calcIndex = 1;
			 }else if(dayCount<22){
				 gridRow = "h3";
				 calcIndex = 2;
			 }else if(dayCount<29){
				 gridRow = "h4";
				 calcIndex = 3;
			 }else{
				 gridRow = "h5";
				 calcIndex = 4;
			 }
			 
			 //グリッドの位置を格納する変数
			 int gridCol = 0;
			 
			 //割り出したグリッドからセルの位置を割り出す
			 if(calcIndex == 0){
				 gridCol = dayCount;
			 }else{
				 gridCol = dayCount - (7 * calcIndex);
			 }
			 
			 switch(intKey){
			 case 1:
				 ACChotarouXMLUtilities.setValue(writer,"calendar" + type + "Circle." + gridRow + ".w" + gridCol,"");
				 break;
                 
			 //訪問日である場合　○
			 case 2:
				 ACChotarouXMLUtilities.setValue(writer,"calendar" + type + "Circle." + gridRow + ".w" + gridCol,"○");
				break;
                
			 //特別指示による訪問である場合　△
			 case 3:
				 ACChotarouXMLUtilities.setValue(writer,"calendar" + type + "Circle." + gridRow + ".w" + gridCol,"△");
				 break;
                 
		     //緊急時訪問である場合　×
			 case 4:
				 ACChotarouXMLUtilities.setValue(writer,"calendar" + type + "Circle." + gridRow + ".w" + gridCol,"×");			 
				 break;
                 
			 //1日に2回以上の訪問である場合　◎
			 case 5:
				 ACChotarouXMLUtilities.setValue(writer,"calendar" + type + "Circle." + gridRow + ".w" + gridCol,"◎");
				 break;
			 }
				 
		 	
			 

			 
	 }
	 //060323変更
	 // 病状の経過を設定する。
     // 病状を設定する。
     String byojoStateComment = (String) VRBindPathParser.get("BYOJO_STATE",
             printParameters);
     // 取得した備考を４２文字ごとに
     String[] strByojoStateComment = ACTextUtilities.separateLineWrapOnByte(
             byojoStateComment, 84);

     List listByojoStateComment = Arrays.asList(strByojoStateComment);
     // 初期化
     StringBuffer sb = new StringBuffer();

     for (int i = 0; i < listByojoStateComment.size(); i++) {
         sb.append(listByojoStateComment.get(i));
         // 最終行である場合は追加しない
         if (i != listByojoStateComment.size() - 1) {
             //改行コード追加
             sb.append(ACConstants.LINE_SEPARATOR);
         }
     }
    ACChotarouXMLUtilities.setValue(writer, "patient.byojoComments.value",sb.toString());
    
    //060323変更
    // 看護・リハビリテーションの内容を設定する。
    String kangoRiha = (String) VRBindPathParser.get("KANGO_REHA_NAIYO",
            printParameters);
    // 取得した備考を４２文字ごとに
    String[] strKangoRiha = ACTextUtilities.separateLineWrapOnByte(
            kangoRiha, 84);

    List listKangoRiha = Arrays.asList(strKangoRiha);
    // 初期化
    sb = new StringBuffer();

    for (int i = 0; i < listKangoRiha.size(); i++) {
        sb.append(listKangoRiha.get(i));
        // 最終行である場合は追加しない
        if (i != listKangoRiha.size() - 1) {
            //改行コード追加
            sb.append(ACConstants.LINE_SEPARATOR);
        }
    }
    
    ACChotarouXMLUtilities.setValue(writer,"patient.kangoRehaComments.value",sb.toString());
    //060323変更
    // 家庭での療養・介護の状況を設定する。
    String ryoyouKaigo = (String) VRBindPathParser.get("RYOYO_KAIGO_STATE",
            printParameters);
    // 取得した備考を４２文字ごとに
    String[] strRyoyouKaigo = ACTextUtilities.separateLineWrapOnByte(
            ryoyouKaigo, 84);

    List listRyoyouKaigo = Arrays.asList(strRyoyouKaigo);
    // 初期化
    sb = new StringBuffer();

    for (int i = 0; i < listRyoyouKaigo.size(); i++) {
        sb.append(listRyoyouKaigo.get(i));
        // 最終行である場合は追加しない
        if (i != listRyoyouKaigo.size() - 1) {
            //改行コード追加
            sb.append(ACConstants.LINE_SEPARATOR);
        }
    }
    
    ACChotarouXMLUtilities.setValue(writer,"patient.ryoyoStateComments.value" ,sb.toString());
    
    //060323変更
    // 特記すべき事項を設定する。
    String reportComment = (String) VRBindPathParser.get("REPORT_COMMENT",
            printParameters);
    // 取得した備考を48文字ごとに
    String[] strReportComment = ACTextUtilities.separateLineWrapOnByte(
            reportComment, 96);

    List listReportComment = Arrays.asList(strReportComment);
    // 初期化
    sb = new StringBuffer();

    for (int i = 0; i < listReportComment.size(); i++) {
        sb.append(listReportComment.get(i));
        // 最終行である場合は追加しない
        if (i != listReportComment.size() - 1) {
            //改行コード追加
            sb.append(ACConstants.LINE_SEPARATOR);
        }
    }
    ACChotarouXMLUtilities.setValue(writer,"patient.specialComments.header",sb.toString());
    
    // 渡りパラメータprintParamのKEY:CREATE_DATEのVALUEを取得する。
    Date createDate = (Date)printParameters.getData("CREATE_DATE");
    // 取得した値を「ggge年M月d日」(和暦)に変換する。
    VRDateFormat fr = new VRDateFormat("ggge年M月d日");
    
    String strCreateDate = fr.format(createDate);
    
    // 作成年月日を設定する。
    ACChotarouXMLUtilities.setValue(writer,"createDate", strCreateDate);
    // ステーション名を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParameters, "PROVIDER_NAME", "station.stationName.value");
    // 管理者氏名を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParameters, "ADMINISTRATOR_NAME", "station.administratorName.value");
    // 主治医氏名を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParameters, "DOCTOR_NAME", "doctor.doctorName.value");

    //ページ終了
    writer.endPageEdit();
    //TODO 印刷を実行したならばtrueを返す。
  
	    return true;
  	}   

  
  }
