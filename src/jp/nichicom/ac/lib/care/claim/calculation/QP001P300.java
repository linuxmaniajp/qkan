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
 * 開発者: 松本　幸一
 * 作成日: 2010/11/08  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求 (P)
 * プロセス 利用者一覧 (001)
 * プログラム 利用者一覧 (QP001P083)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.text.QkanClaimStyleFormat;
import jp.or.med.orca.qkan.text.QkanJotaiCodeFormat;

/**
 * 利用者一覧 帳票定義体ファイル名 ： QP001P300.xml
 */
public class QP001P300 extends QP001PrintEvent {
	/**
	 * コンストラクタです。
	 */
	public QP001P300() {
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
	public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
		// 必要であれば帳票IDを書き換えること。
		ACChotarouXMLUtilities.addFormat(writer, "QP001P300", "QP001P300.xml");
		// ページ開始
		writer.beginPageEdit("QP001P300");
		
		// 印刷用情報格納用のVRArrayList printArrayを定義する。
		// printArrayに、渡りパラメータの KEY : PARAM の VALUE を設定する。
		// ※以下、printArrayに格納されているレコードを参照する。
		// 現在の日付を取得する。(システム日付ではない)
		// 日付(和暦)の年を設定する。
		// 日付の月を設定する。
		// 日付の日を設定する。
		setPageHeader(writer, printParam);

		// LIST
		VRList list = (VRList) VRBindPathParser.get("LIST", printParam);
		Iterator it = list.iterator();

		VRMap row = null;
		int rowCount = 1;
		
		while (it.hasNext()) {
			
			// 頁あたりの印刷件数が22件になる、もしくは全ての利用者を印刷するまでループする。
			if (23 <= rowCount) {
				// 改ページ処理
				// 一旦ページを確定
				writer.endPageEdit();
				//新しいページを開始
				//[ID:0000735][Shin Fujihara] 2012/05 edit begin 一覧印刷エラー対応
				//writer.beginPageEdit("QP001P083");
				writer.beginPageEdit("QP001P300");
				//[ID:0000735][Shin Fujihara] 2012/05 edit end 一覧印刷エラー対応
				
				// 変数初期化・印刷日設定
				rowCount = 1;
				setPageHeader(writer, printParam);
			}
			
			
			// 印刷する利用者情報(1件分)を、VRHashMap patientMapに退避する。
			row = (VRMap) it.next();
			
			// 提供年月を設定する。
			// setValue(patients.provideDate.h*, (patientMapのPROVIDER_DATE));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "provideDate"), getYMJp(VRBindPathParser.get("TARGET_DATE", row)));

			// 様式を設定する。
			// setValue(patients.style.h*, (patientMapのSTYLE));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "style"), getStyleName(VRBindPathParser.get("CLAIM_STYLE_TYPE", row)));

			// 保険者番号を設定する。
			// setValue(patients.insurerNo.h*, (patientMapのINSURER_NO));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "insurerNo"), VRBindPathParser.get("INSURER_ID", row));

			// 被保険者番号を設定する。
			// setValue(patients.underInsurerNo.h*, (patientMapのUNDER_INSURER_NO));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "underInsurerNo"), VRBindPathParser.get("INSURED_ID", row));

			// 利用者氏名を設定する。
			// setValue(patients.name.h*, (patientMapのNAME));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "name"), VRBindPathParser.get("PATIENT_NAME", row));

			// 性別を設定する。
			// setValue(patients.sex.h*, (patientMapのSEX));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "sex"), getSex(VRBindPathParser.get("PATIENT_SEX", row)));

			// 年齢を設定する。
			// setValue(patients.age.h*, (patientMapのAGE));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "age"), getAge(VRBindPathParser.get("PATIENT_BIRTHDAY", row)));

			// 要介護度を設定する。
			// setValue(patients.yokaigodo.h*, (patientMapのYOKAIGODO));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "yokaigodo"), getJotai(VRBindPathParser.get("JOTAI_CODE", row)));

			// 計画単位を設定する。
			// setValue(patients.planUnit.h*, (patientMapのPLAN_UNIT));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "planUnit"), getNum(VRBindPathParser.get("PLAN_RATE", row)));

			// サービス単位を設定する。
			// setValue(patients.serviceUnit.h*, (patientMapのSERVICE_UNIT));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "serviceUnit"), getNum(VRBindPathParser.get("SERVICE_UNIT", row)));

			// サービス合計金額を設定する。
			// setValue(patients.serviceTotalAmount.h*, (patientMapのSERVICE_TOTAL_AMOUNT));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "serviceTotalAmount"), getNum(VRBindPathParser.get("SERVICE_TOTAL", row)));

			// 保険請求額を設定する。
			// setValue(patients.insurerChargeAmount.h*, (patientMapのINSURER_CHARGE_AMOUNT));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "insurerChargeAmount"), getNum(VRBindPathParser.get("HOKEN", row)));

			// 公費負担額を設定する。
			// setValue(patients.publicExpenseAmount.h*, (patientMapのPUBLIC_EXPENSE_AMOUNT));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "publicExpenseAmount"), getNum(VRBindPathParser.get("KOUHI", row)));

			// 利用者負担額を設定する。
			// setValue(patients.patientChargeAmount.h*, (patientMapのPATIENT_CHARGE_AMOUNT));
			ACChotarouXMLUtilities.setValue(writer, getCol(rowCount, "patientChargeAmount"), getNum(VRBindPathParser.get("RIYOUSYA", row)));
			
			rowCount++;

		}
		
		// ページ終了
		writer.endPageEdit();
		
		// 印刷を実行したならばtrueを返す。
		return true;
	}
	
	// 列名・印刷行番号から位置名称を作成する
	private String getCol(int rowCount, String ColName) {
		return "patients.h" + rowCount + "." + ColName;
	}
	
	// 和暦年月に変換
	private String getYMJp(Object date) throws Exception {
		return VRDateParser.format((Date)date,"ggge年MM月");
	}
	
	// 様式番号から様式名称に変換
	private String getStyleName(Object style) {
		return QkanClaimStyleFormat.getInstance().format(style);
	}
	
	// コードから性別名称に変換
	private String getSex(Object sex) {
		return QkanConstants.FORMAT_SEX.format(sex);
	}
	
	// 生年月日から年齢に変換
	private String getAge(Object birthday) {
		return QkanConstants.FORMAT_NOW_AGE.format(birthday) + "歳";
	}
	
	// 状態コードから要介護度名称に変換
	private String getJotai(Object code) {
		return QkanJotaiCodeFormat.getInstance().format(code);
	}
	
	// 数値をカンマ区切りのフォーマットに変換
	private String getNum(Object num) {
		return NumberFormat.getInstance().format(num);
	}
	
	//全てのページで共通の領域を印字する
	private void setPageHeader(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
		//印刷日
		ACChotarouXMLUtilities.setValue(writer, "Date", VRBindPathParser.get("DATE", printParam));
		
		//合計単位数
		ACChotarouXMLUtilities.setValue(writer, "total.h1.w2", VRBindPathParser.get("SERVICE_UNIT", printParam));
		//合計金額
		ACChotarouXMLUtilities.setValue(writer, "total.h1.w4", VRBindPathParser.get("SERVICE_TOTAL", printParam));
		//保険請求額
		ACChotarouXMLUtilities.setValue(writer, "total.h2.w2", VRBindPathParser.get("HOKEN", printParam));
		//合計件数
		ACChotarouXMLUtilities.setValue(writer, "total.h2.w4", VRBindPathParser.get("SERVICE_COUNT", printParam));
		//利用請求額
		ACChotarouXMLUtilities.setValue(writer, "total.h3.w2", VRBindPathParser.get("RIYOUSYA", printParam));
		//公費請求額
		ACChotarouXMLUtilities.setValue(writer, "total.h3.w4", VRBindPathParser.get("KOUHI", printParam));
	}

}
