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
 * 開発者: 樋口　雅彦
 * 作成日: 2006/01/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 訪問看護記録書Ⅰ (004)
 * プログラム 訪問看護記録書Ⅰ NO.1 (QC00401)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc004;

import java.beans.FeatureDescriptor;
import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;

/**
 * 訪問看護記録書Ⅰ NO.1(QC00401) 帳票定義体ファイル名 ： QC00401.xml
 */
public class QC004P01 extends QC004P01Event {
	/**
	 * コンストラクタです。
	 */
	public QC004P01() {
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
		ACChotarouXMLUtilities.addFormat(writer, "QC004P01", "QC004P01.xml");

		// ページ開始
		writer.beginPageEdit("QC004P01");

		// 氏名の姓名を結合しpatientFullNameに格納する。
		// toFullName(PATIENT_FAMILY_NAME, PATIENT_FIRST_NAME);
		// String patientFullName = QkanCommon.toFullName(String.valueOf(printParam.getData("PATIENT_FAMILY_NAME")), String.valueOf(printParam.getData("PATIENT_FIRST_NAME")));

		// 患者氏名を設定する。
		// setValue(kirokushoGrid1(w2.h1), patientFullName);
		ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_NAME", "kirokushoGrid1.h1.w2");

		// PATIENT_SEXの値をチェックする。
		if (printParam.getData("PATIENT_SEX").equals(new Integer(MALE))) {
			// 値が1だった場合
			// 女のシェイプを非表示にする。
			ACChotarouXMLUtilities.setInvisible(writer, "patientSex2");
		} else if(printParam.getData("PATIENT_SEX").equals(new Integer(FEMALE))) {

			// 値が2だった場合
			// 男のシェイプを非表示にする。
			ACChotarouXMLUtilities.setInvisible(writer, "patientSex1");
		}else {
			ACChotarouXMLUtilities.setInvisible(writer, "patientSex1");
			ACChotarouXMLUtilities.setInvisible(writer, "patientSex2");
		}

		// 渡りパラメーター：PATIENT_BIRTHDAYを取得する。
		// patientBirthday(String型）にPATIENT_BIRRHDAYを 「ggge年M月d日」 の書式で変換し格納する。
		Date patientBirthday = ACCastUtilities.toDate(printParam.getData("PATIENT_BIRTHDAY"));

		// patientBirthdayから「ggg（元号）」を取り出し、patientBirthdayRekiに格納する。
		String patientBirthdayReki = ACDateUtilities.getEraFull(patientBirthday);

		// patientBirthdayから「e（年）」を取り出し、patientBirthdayYearに格納する。
		Integer patientBirthdayYear = new Integer(ACDateUtilities.getEraYear(patientBirthday));

		// patientBirthdayから「M（月）」を取り出し、patientBirthdayMonthに格納する。
		Integer patientBirthdayMonth = new Integer(ACDateUtilities.getMonth(patientBirthday));

		// patientBirthdayから「d（日）」を取り出し、patientBirthdayDayに格納する。
		Integer patientBirthdayDay = new Integer(ACDateUtilities.getDayOfMonth(patientBirthday));

		// システム日付を取得し、変数systemDateに格納する。
		Date systemDate = QkanSystemInformation.getInstance().getSystemDate();

		// 年齢を取得し、変数patientAgeに格納する。
		Integer patientAge = new Integer(QkanCommon.calcAge(patientBirthday, systemDate));

		// 元号を設定する。
		ACChotarouXMLUtilities.setValue(writer, "kirokushoGrid1.h1.w13", patientBirthdayReki);

		// 日付（年）を設定する。
		ACChotarouXMLUtilities.setValue(writer, "kirokushoGrid1.h1.w12", patientBirthdayYear);

		// 日付（月）を設定する。
		ACChotarouXMLUtilities.setValue(writer, "kirokushoGrid1.h1.w10", patientBirthdayMonth);

		// 日付（日）を設定する。
		ACChotarouXMLUtilities.setValue(writer, "kirokushoGrid1.h1.w8", patientBirthdayDay);

		// 年齢を設定する。
		ACChotarouXMLUtilities.setValue(writer, "kirokushoGrid1.h1.w6", patientAge);

		// 住所を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_ADDRESS", "patientAddress");

		// PATIENT_TEL_FIRSTの値をチェックする。
		// 空白だった場合
		// PATIENT_TEL_SECONDの値をチェックする。
		// 空白だった場合
		// PATIENT_TEL_THIRDの値をチェックする。
		// 空白だった場合
		// 処理を抜ける。
		// 空白ではなかった場合
		// 次処理へ。
		// 空白ではなかった場合
		// 次処理へ。
		// 空白ではなかった場合
		// 次処理へ。
		// 電話番号を結合し、変数patientTelに格納する。
		// toTel(PATIENT_TEL_FIRST, PATIENT_TEL_SECOND, PATIENT_TEL_THIRD);
		String patientTel = QkanCommon.toTel(String.valueOf(printParam.getData("PATIENT_TEL_FIRST")), String.valueOf(printParam.getData("PATIENT_TEL_SECOND")), String.valueOf(printParam.getData("PATIENT_TEL_THIRD")));

		// 結合した電話番号を設定する。
		ACChotarouXMLUtilities.setValue(writer, "kirokushoGrid1.h2.w13", patientTel);

		// 看護師氏名を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "NURSE_NAME", "kirokushoGrid2.h1.w2");

		// 変数firstVisitDate(String型）を生成する。

		// kirokushoMapのKEY：FIRST_VISIT_DATEのVALUEをチェックする。
		if (!ACTextUtilities.isNullText(printParam.getData("FIRST_VISIT_DATE"))) {
			// VALUEが空文字ではなかった場合
			// 取得した値を gge年M月d日（E） の形式に変換する。
			// VALUEをfirstVisitDateに格納する。
			// firstVisitDateの値を設定する。
			Date visitDate = ACCastUtilities.toDate(printParam.getData("FIRST_VISIT_DATE"));
			String firstVisitDate = VRDateParser.format(visitDate, "gggee年MM月dd日");
			firstVisitDate += "（" + ACDateUtilities.getDayOfWeekShort(visitDate) + "）";
			ACChotarouXMLUtilities.setValue(writer, "firstVisitDate", firstVisitDate);
		}

		// KEY：FIRST_VISIT_DATE_STARTのVALUEをチェックする。
		if (ACTextUtilities.isNullText(printParam.getData("FIRST_VISIT_DATE_START"))) {
			// 空白だった場合
			// 「～（firstVisitDateFrom）」を非表示にする。
			ACChotarouXMLUtilities.setInvisible(writer, "firstVisitDateFrom");

		} else {
			// 空白ではなかった場合
			// firstVisitDateStartの値を設定する。
			String firstVisitDateStart = VRDateParser.format(ACCastUtilities.toDate(printParam.getData("FIRST_VISIT_DATE_START")), "HH時mm分");
			ACChotarouXMLUtilities.setValue(writer, "firstVisitDateStart", firstVisitDateStart);

			// KEY：FIRST_VISIT_DATE_ENDのVALUEをェックする。
			if (ACTextUtilities.isNullText(printParam.getData("FIRST_VISIT_DATE_END"))) {
				// 空白だった場合
				// 「～（firstVisitDateFrom）」を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "firstVisitDateFrom");
			} else {
				// 空白ではなかった場合
				// firstVisitDateEndの値を設定する。
				String firstVisitDateEnd = VRDateParser.format(ACCastUtilities.toDate(printParam.getData("FIRST_VISIT_DATE_END")), "HH時mm分");
				ACChotarouXMLUtilities.setValue(writer, "firstVisitDateEnd", firstVisitDateEnd);
			}
		}

		// 下記の条件で、主たる傷病名を設定する。
		// ・1行に印刷する文字数は、全角37文字とする。
		// ・総行数は4行とする。
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "DISEASE", "kirokushoGrid2.h3.w2", 74);

		// 下記の条件で、病状・治療状態等を設定する。
		// ・1行に印刷する文字数は、全角37文字とする。
		// ・総行数は8行とする。
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "BYOJO_CHIYU_JOTAI", "kirokushoGrid2.h4.w2", 74);
		
		// 下記の条件で、現病歴を設定する。
		// ・1行に印刷する文字数は、全角37文字とする。
		// ・総行数は7行とする。
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "GENBYOREKI", "kirokushoGrid2.h5.w2", 74);
		
		// 下記の条件で、既往歴を設定する。
		// ・1行に印刷する文字数は、全角37文字とする。
		// ・総行数は7行とする。
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "KIOREKI", "kirokushoGrid2.h6.w2", 74);

		// 下記の条件で、生活歴を設定する。
		// ・1行に印刷する文字数は、全角37文字とする。
		// ・総行数は7行とする。
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "SEIKATSUREKI", "kirokushoGrid2.h7.w2", 74);

		// 家族構成1 氏名を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_NAME1", "kirokushoGrid3.h2.w2");

		// 家族構成1 年齢を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_AGE1", "kirokushoGrid3.h2.w3");

		// 家族構成1 続柄を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_RELATION1", "kirokushoGrid3.h2.w4");

		// 家族構成1 職業を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_JOB1", "kirokushoGrid3.h2.w5");

		// 家族構成1 特記すべき事項を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_COMMENT1", "kirokushoGrid3.h2.w6");

		// 家族構成2 氏名を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_NAME2", "kirokushoGrid3.h3.w2");

		// 家族構成2 年齢を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_AGE2", "kirokushoGrid3.h3.w3");

		// 家族構成2 続柄を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_RELATION2", "kirokushoGrid3.h3.w4");

		// 家族構成2 職業を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_JOB2", "kirokushoGrid3.h3.w5");

		// 家族構成2 特記すべき事項を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_COMMENT2", "kirokushoGrid3.h3.w6");

		// 家族構成3 氏名を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_NAME3", "kirokushoGrid3.h4.w2");

		// 家族構成3 年齢を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_AGE3", "kirokushoGrid3.h4.w3");

		// 家族構成3 続柄を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_RELATION3", "kirokushoGrid3.h4.w4");

		// 家族構成3 職業を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_JOB3", "kirokushoGrid3.h4.w5");

		// 家族構成3 特記すべき事項を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_COMMENT3", "kirokushoGrid3.h4.w6");

		// 家族構成4 氏名を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_NAME4", "kirokushoGrid3.h5.w2");

		// 家族構成4 年齢を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_AGE4", "kirokushoGrid3.h5.w3");

		// 家族構成4 続柄を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_RELATION4", "kirokushoGrid3.h5.w4");

		// 家族構成4 職業を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_JOB4", "kirokushoGrid3.h5.w5");

		// 家族構成4 特記すべき事項を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_COMMENT4", "kirokushoGrid3.h5.w6");

		// 家族構成5 氏名を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_NAME5", "kirokushoGrid3.h6.w2");

		// 家族構成5 年齢を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_AGE5", "kirokushoGrid3.h6.w3");

		// 家族構成5 続柄を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_RELATION5", "kirokushoGrid3.h6.w4");

		// 家族構成5 職業を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_JOB5", "kirokushoGrid3.h6.w5");

		// 家族構成5 特記すべき事項を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_COMMENT5", "kirokushoGrid3.h6.w6");

		// 家族構成6 氏名を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_NAME6", "kirokushoGrid3.h7.w2");

		// 家族構成6 年齢を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_AGE6", "kirokushoGrid3.h7.w3");

		// 家族構成6 続柄を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_RELATION6", "kirokushoGrid3.h7.w4");

		// 家族構成6 職業を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_JOB6", "kirokushoGrid3.h7.w5");

		// 家族構成6 特記すべき事項を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "FAMILY_COMMENT6", "kirokushoGrid3.h7.w6");

		// 下記の条件で、主な介護者を設定する。
		// 1行に印刷する文字数は全角37文字とする。
		// 総行数は3行とする。
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "CAREGIVER", "kirokushoGrid4.h1.w2", 74);
		
		// 下記の条件で、住環境を設定する。
		// 1行に印刷する文字数は全角37文字とする。
		// 総行数は4行とする。
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "HOUSE", "kirokushoGrid4.h2.w2", 74);

		// ページ終了
		writer.endPageEdit();
		return true;
	}

}
