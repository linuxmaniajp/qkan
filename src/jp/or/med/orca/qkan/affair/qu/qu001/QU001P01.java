
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
 * 作成日: 2005/12/20  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 利用者一覧 (001)
 * プログラム 利用者一覧 (QU00101)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qu.qu001;

import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACNullToBlankFormat;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * 利用者一覧(QU00101) 
 * 帳票定義体ファイル名 ： QU00101.xml
 */
public class QU001P01 extends QU001P01Event {
	
	private static final int jotaiCodeId = 204;
	
  /**
   * コンストラクタです。
   */
  public QU001P01(){
  }

  /**
   * 帳票を生成します。
   * @param writer 印刷管理クラス
   * @param printParam 印刷パラメタ
   * @throws Exception 処理例外
   */
  public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
      final Date MAX_DATE = ACCastUtilities.toDate("9999/12/31", null);
      
  	// 帳票IDを必要に応じて"mainFormat"から適切なものに書き換えること。
    ACChotarouXMLUtilities.addFormat(writer, "QU001P01", "QU001P01.xml");    
    
    // 印刷用情報格納用のVRArrayList printArrayを定義する。
    VRList printArray = new VRArrayList();    
    
    // printArrayに、渡りパラメータの KEY : PARAM の VALUE を設定する。
    // ※以下、printArrayに格納されているレコードを参照する。
    printArray = (VRList)printParam.get("PARAM");

    // 現在の日付を取得する。(システム日付ではない)
    Date nowDate = new Date();

    // 印刷頁数を算出する。（1頁あたりの利用者件数は24件)
    int pages;
    
    if(printArray.size() % 24 == 0){
    	pages = printArray.size() / 24;
    }else{
    	pages = printArray.size() / 24 + 1;
    }
    
    // 出力した利用者データの件数をカウントするカウンタ
    int dataCount = 0;
    // 印刷ページ数をカウントするカウンタ
    int pageCount = 0;
    
    do{
    
    	// ページ開始
	    writer.beginPageEdit("QU001P01");    	
	    
	    // 印刷日付を印字する。
	    ACChotarouXMLUtilities.setValue(
	    		writer, 
				"Date", 
				VRDateParser.format(nowDate, "ggge年MM月dd日"));
	    
	    // 1頁あたりの印刷件数が24件になる、もしくは全ての利用者を印刷するまでループする。
    	for(int j = 0; j < 24; j++){
    		
    		// 利用者のデータがない場合終了。
    		if(dataCount >= printArray.size()){
    			break;
    		}
    		
	    	// 印刷する利用者情報(1件分)を、VRHashMap patientMapに退避する。
	    	VRMap patientMap = (VRMap)printArray.get(dataCount);
    	
	    	// 利用者コードを設定する。
	    	if(VRBindPathParser.has("PATIENT_CODE", patientMap)){
		    	ACChotarouXMLUtilities.setValue(
		    			writer, 
						patientMap, 
						"PATIENT_CODE", 
						"patients.h" + (j + 1) + ".patientCd");
	    	}
	    	
		    // 被保険者番号を設定する。
	    	if(VRBindPathParser.has("INSURED_ID", patientMap)){
		    	ACChotarouXMLUtilities.setValue(
		    			writer, 
						patientMap, 
						"INSURED_ID", 
						"patients.h" + (j + 1) + ".patientInsuredId");
	    	}

		    // 氏名を設定する。	
	    	String familyName = ACCastUtilities.toString(VRBindPathParser.get("PATIENT_FAMILY_NAME", patientMap));
	    	String firstName = ACCastUtilities.toString(VRBindPathParser.get("PATIENT_FIRST_NAME", patientMap));
	    	
	    	ACChotarouXMLUtilities.setValue(
	    			writer, 
					"patients.h" + (j + 1) + ".patientName", 
					QkanCommon.toFullName(familyName, firstName));

	    	// 性別を設定する。patientMapのKEY : SEX の VALUE で設定する文字列を変更する。	    		
    		if(VRBindPathParser.get("PATIENT_SEX", patientMap) instanceof Integer){
    		
	    		int sex = ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_SEX", patientMap));
	    		    		
		    	if(sex == 1){
		    		// 1(男)の場合
			    	// 「男」を設定する。
		    		ACChotarouXMLUtilities.setValue(
			    			writer, 
							"patients.h" + (j + 1) + ".patientSex", 
							"男");
		    	}else{
				    // 2(女)の場合
				    // 「女」を設定する。
		    		ACChotarouXMLUtilities.setValue(
			    			writer, 
							"patients.h" + (j + 1) + ".patientSex", 
							"女");
		    	}			    	
    		}
	    	
	    	//生年月日を取得する。
	    	Date birthDay = null;
	    	
    		if(VRBindPathParser.get("PATIENT_BIRTHDAY", patientMap) instanceof Date){
    		
	    		birthDay = ACCastUtilities.toDate(VRBindPathParser
	    				.get("PATIENT_BIRTHDAY", patientMap));
	    	
		    	// 年齢を計算する。
		    	int age = QkanCommon.calcAge(birthDay, nowDate);
		    	
			    // 年齢を設定する。
		    	ACChotarouXMLUtilities.setValue(
		    			writer, 
						"patients.h" + (j + 1) + ".patientAge",
						new Integer(age));
    		}
		    	
		    // patientMapの KEY : JOTAI_CODE の VALUE を、要介護度を表す文字列に変換する。
	    	if(VRBindPathParser.has("JOTAI_CODE", patientMap)){
			    String yokaigodo = QkanCommon.getContentFromMasterCode(
			    		jotaiCodeId, 
						ACCastUtilities.toInt(VRBindPathParser.get("JOTAI_CODE", patientMap)));
			    
			    // 変換した文字列を設定する。
			    ACChotarouXMLUtilities.setValue(
		    			writer, 
						"patients.h" + (j + 1) + ".yokaigodo",
						yokaigodo);
	    	}
			    
		    // 有効期限を設定する。
	    	if(VRBindPathParser.get("INSURE_VALID_END", patientMap) instanceof Date){
    	
	    		Date insureValidEnd = ACCastUtilities.toDate(VRBindPathParser.get("INSURE_VALID_END", patientMap));

			    // 有効期限が9999/12/31の場合印字しない。※要介護度が「非該当」の場合
			    if(ACDateUtilities.getDifferenceOnTotalDay(insureValidEnd, MAX_DATE) != 0){
			    		
		    		ACChotarouXMLUtilities.setValue(
			    			writer, 
							"patients.h" + (j + 1) + ".validDate",
							VRDateParser.format(insureValidEnd, "ggge年MM月dd日"));
			    }
		    		
	    	}

		    // 有効期限開始を設定する。
	    	if(VRBindPathParser.get("INSURE_VALID_START", patientMap) instanceof Date){
    	
	    		Date insureValidStart = ACCastUtilities.toDate(VRBindPathParser.get("INSURE_VALID_START", patientMap));

			    // 有効期限が9999/12/31の場合印字しない。※要介護度が「非該当」の場合
			    if(ACDateUtilities.getDifferenceOnTotalDay(insureValidStart, MAX_DATE) != 0){
			    		
		    		ACChotarouXMLUtilities.setValue(
			    			writer, 
							"patients.h" + (j + 1) + ".validDateStart",
							VRDateParser.format(insureValidStart, "ggge年MM月dd日"));
			    }
		    		
	    	}
	    	
		    // 住所を設定する。
	    	if(VRBindPathParser.has("PATIENT_ADDRESS", patientMap)){
			    ACChotarouXMLUtilities.setValue(
		    			writer, 
						patientMap, 
						"PATIENT_ADDRESS", 
						"patients.h" + (j + 1) + ".patientAddress");
	    	}

		    // 変数telFirst(String型)を生成し、patientMapの KEY : PATIENT_TEL_FIRST の VALUE を設定する。
		    // 変数telSecond(String型)を生成し、patientMapの KEY : PATIENT_TEL_SECOND の VALUE を設定する。
		    // 変数telThird(String型)を生成し、patientMapの KEY : PATIENT_TEL_THIRD の VALUE を設定する。
		    String telFirst = ACCastUtilities.toString(VRBindPathParser.get("PATIENT_TEL_FIRST", patientMap));
		    String telSecond = ACCastUtilities.toString(VRBindPathParser.get("PATIENT_TEL_SECOND", patientMap));
		    String telThird = ACCastUtilities.toString(VRBindPathParser.get("PATIENT_TEL_THIRD", patientMap));

		    // 電話番号として、telの値を設定する。
		    ACChotarouXMLUtilities.setValue(
	    			writer, 
					"patients.h" + (j + 1) + ".patientTel",
					QkanCommon.toTel(telFirst, telSecond, telThird));

		    // 居宅支援事業所名を設定する。
		    ACChotarouXMLUtilities.setValue(
	    			writer, 
					patientMap, 
					"PROVIDER_NAME", 
					"patients.h" + (j + 1) + ".providerName");

		    // 有効期限を取得する。(patientMapのKEY : INSURE_VALID_END の VALUE)
		    if(VRBindPathParser.get("INSURE_VALID_END", patientMap) instanceof Date){
		    
			    Date insureValidEnd = ACCastUtilities.toDate(VRBindPathParser
			    		.get("INSURE_VALID_END", patientMap));
		    
			    // 現在日付+二ヶ月
			    Date addDate = ACDateUtilities.addDay(nowDate, 59);
			    
			    // 値をチェックする。
			    // 現在日付+二ヶ月よりも前の日付の場合
			    if(ACDateUtilities.getDifferenceOnTotalDay(insureValidEnd, addDate) < 0){
			    	
				    // その他に「*」を設定する。
			    	ACChotarouXMLUtilities.setValue(
			    			writer, 
							"patients.h" + (j + 1) + ".extra",
							"*");
			    	
			    }			    
		    }
		    
		    //データカウントに1加算する。
		    dataCount += 1;

    	}
    	
	    //ページ生成終了
	    writer.endPageEdit();
	    //ページカウントに1加算する。
	    pageCount += 1;
    
    }while(pageCount < pages);		//ページカウントが出力予定のページ数を超えた場合
    
    // 印刷を実行したならばtrueを返す。
    return true;
    
  }
}
