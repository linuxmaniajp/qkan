
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
 * 作成日: 2005/12/16  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 在宅療養生活のポイント (005)
 * プログラム 在宅療養生活のポイント (QC00501)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc005;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * 在宅療養生活のポイント(QC00501) 
 * 帳票定義体ファイル名 ： QC00501.xml
 */
public class QC005P01 extends QC005P01Event {
  /**
   * コンストラクタです。
   */
  public QC005P01(){
  }

  /**
   * 帳票を生成します。
   * @param writer 印刷管理クラス
   * @param printParam 印刷パラメタ
   * @throws Exception 処理例外
   */
  public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
    //TODO 帳票IDを必要に応じて"mainFormat"から適切なものに書き換えること。
    ACChotarouXMLUtilities.addFormat(writer, "QC005P01", "QC005P01.xml");
    //ページ開始
    writer.beginPageEdit("QC005P01");
    // ※作成年月を設定する。
    // 　渡りパラメータのKEY : CREATE_DATE_ZAITAKU の VALUE を取得する。(日付型)   
    // 　　取得した日付の和暦の年を設定する。
    //     setValue(createDate.year.h);
    ACChotarouXMLUtilities.setValue(writer, "createDate.h.year",String.valueOf(
    		ACDateUtilities.getEraYear(ACCastUtilities.toDate(
    				VRBindPathParser.get("CREATE_DATE_ZAITAKU",printParam)))));

    // 　　取得した日付の月を設定する。
    //     setValue(createDate.month.h);
    ACChotarouXMLUtilities.setValue(writer, "createDate.h.w3",String.valueOf(
    		ACDateUtilities.getMonth(ACCastUtilities.toDate(
    				VRBindPathParser.get("CREATE_DATE_ZAITAKU",printParam)))));
    
    // 「あなたの主治医は、私、○○です。」を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParam, "DOCTOR_NAME", "yourDoctor");
    // ※今月の訪問日(6つ)の設定
    // 　「今月の訪問日」格納用のレコード配列 visitThisMonthArrayを生成する。
    // 　以下の処理を渡りパラメータ VISIT_THIS_MONTH_NO1 から VISIT_THIS_MONTH_NO6 の6つ分繰り返す。
    // 　　渡りパラメータ KEY : VISIT_THIS_MONTH_NO* の VALUEをチェックする。
    // 　　　値が存在する場合
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_THIS_MONTH_NO1",printParam))){
    // 　　　　visitThisMonthArrayに KEY : VISIT_THIS_MONTH_NO* の VALUEを設定する。
        // 　visitThisMonthArrayの件数分繰り返す。
        // 　　「今月の訪問日」の n日目にvisitThisMonthArrayの n個目の値を設定する。
        //     setValue(visit.day*.this, VISIT_THIS_MONTH_NO*);
        ACChotarouXMLUtilities.setValue(writer, "visit.this.day1"
        		,VRBindPathParser.get("VISIT_THIS_MONTH_NO1",printParam));
    }
    // 　　　値が存在しない場合
    // 　　　　何もしない。

    // 　残りの「今月の訪問日」の個数分繰り返す。
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_THIS_MONTH_NO2",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.this.day2"
        		,VRBindPathParser.get("VISIT_THIS_MONTH_NO2",printParam));     	
    }else{
//    　　「今月の訪問日」の n日目のキャプション「日」を消す。
//      setValue(visit.unit*.this, "");
    	ACChotarouXMLUtilities.setValue(writer, "visit.this.unit2","");
    }
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_THIS_MONTH_NO3",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.this.day3"
        		,VRBindPathParser.get("VISIT_THIS_MONTH_NO3",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.this.unit3","");
    }    
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_THIS_MONTH_NO4",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.this.day4"
        		,VRBindPathParser.get("VISIT_THIS_MONTH_NO4",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.this.unit4","");
    }        
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_THIS_MONTH_NO5",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.this.day5"
        		,VRBindPathParser.get("VISIT_THIS_MONTH_NO5",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.this.unit5","");
    }            
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_THIS_MONTH_NO6",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.this.day6"
        		,VRBindPathParser.get("VISIT_THIS_MONTH_NO6",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.this.unit6","");
    }            
    // ※来月の訪問予定(6つ)の設定
    // 　「来月の訪問予定」格納用のレコード配列 visitNextMonthArrayを生成する。
    // 　以下の処理を渡りパラメータ VISIT_NEXT_MONTH_NO1 から VISIT_NEXT_MONTH_NO6 の6つ分繰り返す。
    // 　　渡りパラメータ KEY : VISIT_NEXT_MONTH_NO* の VALUEをチェックする。
    // 　　　値が存在する場合
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_NEXT_MONTH_NO1",printParam))){
    // 　　　　visitNextMonthArrayに KEY : VISIT_NEXT_MONTH_NO* の VALUEを設定する。
    // 　　　値が存在しない場合
    // 　　　　何もしない。
    // 　visitNextMonthArrayの件数分繰り返す。
    // 　　「来月の訪問予定」の n日目にvisitNextMonthArrayの n個目の値を設定する。
    //     setValue(visit.day*.next, VISIT_NEXT_MONTH_NO*);
        ACChotarouXMLUtilities.setValue(writer, "visit.next.day1"
        		,VRBindPathParser.get("VISIT_NEXT_MONTH_NO1",printParam));
    }
    
    // 　残りの「来月の訪問予定」の個数分繰り返す。
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_NEXT_MONTH_NO2",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.next.day2"
        		,VRBindPathParser.get("VISIT_NEXT_MONTH_NO2",printParam));     	
    }else{
        // 　　「来月の訪問予定」の n日目のキャプション「日」を消す。
        //     setValue(visit.unit*.next, "");    	
    	ACChotarouXMLUtilities.setValue(writer, "visit.next.unit2","");
    }
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_NEXT_MONTH_NO3",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.next.day3"
        		,VRBindPathParser.get("VISIT_NEXT_MONTH_NO3",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.next.unit3","");
    }
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_NEXT_MONTH_NO4",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.next.day4"
        		,VRBindPathParser.get("VISIT_NEXT_MONTH_NO4",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.next.unit4","");
    }    
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_NEXT_MONTH_NO5",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.next.day5"
        		,VRBindPathParser.get("VISIT_NEXT_MONTH_NO5",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.next.unit5","");
    }    
    if(!ACTextUtilities.isNullText(VRBindPathParser.get("VISIT_NEXT_MONTH_NO6",printParam))){
        ACChotarouXMLUtilities.setValue(writer, "visit.next.day6"
        		,VRBindPathParser.get("VISIT_NEXT_MONTH_NO6",printParam));     	
    }else{
    	ACChotarouXMLUtilities.setValue(writer, "visit.next.unit6","");
    }   
    
    // ○月のアドバイスを設定する。
    ACChotarouXMLUtilities.setValue(writer, printParam, "ADVICE_MONTH", "adviceMonth");
    // アドバイス・本文を設定する。
    ACChotarouXMLUtilities.setTextOfLineWrapOnByte( writer, printParam, "ADVICE", "advice", 96);
//    ACChotarouXMLUtilities.setValue(writer, printParam, "ADVICE", "advice");
    // 医療機関名を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_FACILITY_NAME", "medicalInstitusion");
    // 担当医氏名を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParam, "DOCTOR_NAME", "doctorName");
    // 連絡先を設定する。
    String medicalTel = QkanCommon.toTel(VRBindPathParser.get(
            "MEDICAL_FACILITY_TEL_FIRST", printParam), VRBindPathParser
            .get("MEDICAL_FACILITY_TEL_SECOND", printParam),
            VRBindPathParser.get("MEDICAL_FACILITY_TEL_THIRD", printParam));
    
    ACChotarouXMLUtilities.setValue(writer,"renrakusaki",medicalTel);

    //利用社名を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_NAME", "patientName");
    
    
    
    //ページ終了
    writer.endPageEdit();
    //TODO 印刷を実行したならばtrueを返す。
    return true;
  }

}
