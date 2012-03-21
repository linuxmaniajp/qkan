
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
 * 作成日: 2006/03/25  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 居宅療養管理指導書 (005)
 * プログラム 居宅療養管理指導書 (QC005P02)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc005;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * 居宅療養管理指導書(QC005P02) 
 * 帳票定義体ファイル名 ： QC00502.xml
 */
public class QC005P02 extends QC005P02Event {
  /**
   * コンストラクタです。
   */
  public QC005P02(){
  }

  /**
   * 帳票を生成します。
   * @param writer 印刷管理クラス
   * @param printParam 印刷パラメタ
   * @throws Exception 処理例外
   */
  public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
    //必要であれば帳票IDを書き換えること。
    ACChotarouXMLUtilities.addFormat(writer, "QC005P02", "QC005P02.xml");
    //ページ開始
    writer.beginPageEdit("QC005P02");
    
    // ※元号を設定する。
    ACChotarouXMLUtilities.setValue(writer, "createDate.h.gengou",
                ACCastUtilities.toString(ACDateUtilities
                        .getEraFull(ACCastUtilities.toDate(VRBindPathParser
                                .get("CREATE_DATE_KYOTAKU", printParam)))));
    
    // ※作成年月日の設定    
    // 　渡りパラメータから KEY : CREATE_DATE_KYOTAKU の VALUE を取得する。(日付型)
    // 　作成年月日の和暦の年を設定する。
    //     setValue(createDate.year.h, (和暦の年));
    ACChotarouXMLUtilities.setValue(writer, "createDate.h.year", String
            .valueOf(ACDateUtilities.getEraYear(
                    ACCastUtilities.toDate(VRBindPathParser.get(
                            "CREATE_DATE_KYOTAKU", printParam)))));

    // 　作成年月日の月を設定する。
    //     setValue(createDate.month.h, (月));
    ACChotarouXMLUtilities.setValue(writer, "createDate.h.month", String
            .valueOf(ACDateUtilities.getMonth(
                    ACCastUtilities.toDate(VRBindPathParser.get(
                            "CREATE_DATE_KYOTAKU", printParam)))));

    // 　作成年月日の日を設定する。
    //     setValue(createDate.day.h, (日));
    ACChotarouXMLUtilities.setValue(writer, "createDate.h.day", String
            .valueOf(ACDateUtilities.getDayOfMonth(
                    ACCastUtilities.toDate(VRBindPathParser.get(
                            "CREATE_DATE_KYOTAKU", printParam)))));

    // 介護支援専門員を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParam, "SENMONIN", "senmonin");
    // 医療機関名を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_FACILITY_NAME", "medicalFacilityName");
    // 医療機関住所を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_FACILITY_ADDRESS", "medicalFacilityAddress");
    // 医療機関連絡先を設定する。
    // 医療機関電話番号を結合する
    // 医療機関電話番号を設定する。
    String medicalTel = QkanCommon.toTel(VRBindPathParser.get(
                "MEDICAL_FACILITY_TEL_FIRST", printParam), VRBindPathParser
                .get("MEDICAL_FACILITY_TEL_SECOND", printParam),
                VRBindPathParser.get("MEDICAL_FACILITY_TEL_THIRD", printParam));
    //     setValue(medicalFacilityTel);
    ACChotarouXMLUtilities.setValue(writer,"medicalFacilityTel",medicalTel);
    
    // 医療機関医師氏名を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParam, "DOCTOR_NAME", "doctorName");
    // 事業所名を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParam, "PROVIDER_NAME", "providerName");
    // 利用者氏名を設定する。
    ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_NAME", "patientName");
    
    // 利用者性別を設定する。
    if (ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_SEX",
            printParam)) == 1) {
        ACChotarouXMLUtilities.setInvisible(writer, "patientSex2");
    } else if(ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_SEX",
            printParam)) == 2){
        ACChotarouXMLUtilities.setInvisible(writer, "patientSex1");
    }else{
        //非表示にする。
        ACChotarouXMLUtilities.setInvisible(writer, "patientSex1");
        ACChotarouXMLUtilities.setInvisible(writer, "patientSex2");
    }
    // ※利用者生年月日の設定
        // 渡りパラメータから KEY : PATIENT_BIRTHDAY の VALUE を取得する。(日付型)
        // 取得した日付の年号を取得する。
        // 「明治」の場合
        if (ACDateUtilities.getEraFull(
                ACCastUtilities.toDate(VRBindPathParser.get("PATIENT_BIRTHDAY",
                        printParam))).equals("明治")) {
            // 「大正」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
            // 「昭和」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
        } else if (ACDateUtilities.getEraFull(
                ACCastUtilities.toDate(VRBindPathParser.get("PATIENT_BIRTHDAY",
                        printParam))).equals("大正")) {
            // 「大正」の場合
            // 「明治」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
            // 「昭和」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
        } else if (ACDateUtilities.getEraFull(
                ACCastUtilities.toDate(VRBindPathParser.get("PATIENT_BIRTHDAY",
                        printParam))).equals("昭和")) {
            // 「昭和」の場合
            // 「明治」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
            // 「大正」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
        } else {
            // 「明治」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
            // 「大正」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
            // 「昭和」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
        }
        // 生年月日の和暦の年を設定する。
        // setValue(patientBirth.year.h);
        ACChotarouXMLUtilities.setValue(writer, "patientBirth.h.year", String
                .valueOf(ACDateUtilities.getEraYear(
                        ACCastUtilities.toDate(VRBindPathParser.get(
                                "PATIENT_BIRTHDAY", printParam)))));

        // 生年月日の月を設定する。
        // setValue(patientBirth.month.h);
        ACChotarouXMLUtilities.setValue(writer, "patientBirth.h.month", String
                .valueOf(ACDateUtilities.getMonth(
                        ACCastUtilities.toDate(VRBindPathParser.get(
                                "PATIENT_BIRTHDAY", printParam)))));

        // 生年月日の日を設定する。
        // setValue(patientBirth.day.h);
        ACChotarouXMLUtilities.setValue(writer, "patientBirth.h.day", String
                .valueOf(ACDateUtilities.getDayOfMonth(
                        ACCastUtilities.toDate(VRBindPathParser.get(
                                "PATIENT_BIRTHDAY", printParam)))));

    // ※要介護度の設定
    // 　渡りパラメータから KEY : JOTAI_CODE の VALUE を取得する。(文字)
    // 　取得した文字列をチェックする。
        switch (ACCastUtilities.toInt(VRBindPathParser.get("JOTAI_CODE",
                printParam))) {
        case 12:
            // 「要支援1」の場合
            // 「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // 「経過的要介護」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        case 13:
            // 「要支援2」の場合
            // 「要支援1」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // 「経過的要介護」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        case 11:
            // 「経過的要介護」の場合
            // 「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // 「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        case 21:
            // 「要介護１」の場合
            // 「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // 「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // 「経過的要介護」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        case 22:
            // 「要介護２」の場合
            // 「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // 「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // 「経過的要介護」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        case 23:
            // 「要介護３」の場合
            // 「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // 「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // 「経過的要介護」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        case 24:
            // 「要介護４」の場合
            // 「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // 「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // 「経過的要介護」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        case 25:
            // 「要介護５」の場合
            // 「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // 「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // 「経過的要介護」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            break;
        case 1:
            // 「自立」の場合
            // 「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode12");
            // 「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode13");
            // 「経過的要介護」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode11");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "jotaiCode25");
            break;
        }
    // ※障害老人日常生活自立度の設定
        // 渡りパラメータから KEY : SHOGAI_JIRITSUDO の VALUE を取得する。(数値)
        // 取得した値をチェックする。
        switch (ACCastUtilities.toInt(VRBindPathParser.get("SHOGAI_JIRITSUDO",
                printParam))) {
        case 1:
            // 1の場合
            // 「Ｊ」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo2");
            // 「Ａ」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo3");
            // 「B」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo4");
            // 「C」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo5");
            break;
        case 2:
            // 2の場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo1");
            // 「Ａ」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo3");
            // 「B」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo4");
            // 「C」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo5");
            break;
        case 3:
            // 3の場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo1");
            // 「Ｊ」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo2");
            // 「Ｂ」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo4");
            // 「C」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo5");
            break;
        case 4:
            // 4の場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo1");
            // 「Ｊ」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo2");
            // 「Ａ」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo3");
            // 「C」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo5");
            break;
        case 5:
            // 5の場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo1");
            // 「Ｊ」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo2");
            // 「Ａ」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo3");
            // 「B」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo4");
            break;
        case 0:
            // 0の場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo1");
            // 「Ｊ」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo2");
            // 「Ａ」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo3");
            // 「B」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo4");
            // 「C」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "shogaiJiritsudo5");
            break;
        }
    // ※認知症老人日常生活自立度の設定
        // 渡りパラメータから KEY : NINCHISHO_JIRITSUDO の VALUE を取得する。(数値)
        // 取得した値をチェックする。
        switch (ACCastUtilities.toInt(VRBindPathParser.get(
                "NINCHISHO_JIRITSUDO", printParam))) {
        case 1:
            // 1の場合
            // 「I」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo2");
            // 「II」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo3");
            // 「III」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo4");
            // 「IV」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo5");
            // 「M」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo6");
            break;
        case 2:
            // 2の場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo1");
            // 「II」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo3");
            // 「III」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo4");
            // 「IV」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo5");
            // 「M」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo6");
            break;
        case 3:
            // 3の場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo1");
            // 「I」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo2");
            // 「III」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo4");
            // 「IV」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo5");
            // 「M」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo6");
            break;
        case 4:
            // 4の場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo1");
            // 「I」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo2");
            // 「III」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo3");
            // 「IV」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo5");
            // 「M」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo6");
            break;
        case 5:
            // 5の場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo1");
            // 「I」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo2");
            // 「II」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo3");
            // 「III」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo4");
            // 「M」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo6");
            break;
        case 6:
            // 6の場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo1");
            // 「I」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo2");
            // 「II」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo3");
            // 「III」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo4");
            // 「IV」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo5");
            break;
        case 0:
            // 0の場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo1");
            // 「I」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo2");
            // 「II」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo3");
            // 「III」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo4");
            // 「IV」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo5");
            // 「Ｍ」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "ninchishoJiritsudo6");
            break;
        }
        
        String[] slCharacter = ACTextUtilities.separateLineWrapOnByte(
                ACCastUtilities.toString(VRBindPathParser.get(
                        "PATIENT_ADDRESS", printParam)), 80);
    // 利用者住所を設定する
    // 利用者住所を45文字単位で分割する
    // 利用者住所を設定する(45文字分）
    //     setValue(patientAddress1);
    // 利用者住所を設定する(残り45文字）
    //     setValue(patientAddress2);
        if(slCharacter != null){
            int end=Math.min(slCharacter.length, 2);
            for(int i = 0; i < end; i++){
                int index = i + 1;
                ACChotarouXMLUtilities.setValue(writer,"patientAddress"+index ,slCharacter[i]);
            }
        }
    // 利用者連絡先を設定する。
    // 利用者電話番号を結合する
    // 結合した電話番号を設定する。
        String patientTel = QkanCommon.toTel(VRBindPathParser.get(
                "PATIENT_TEL_FIRST", printParam), VRBindPathParser
                .get("PATIENT_TEL_SECOND", printParam),
                VRBindPathParser.get("PATIENT_TEL_THIRD", printParam));
    //     setValue(medicalFacilityTel);
    ACChotarouXMLUtilities.setValue(writer,"patientTel",patientTel);
    //     setValue(patientTel);

    // ※病状の設定
    // 　渡りパラメータから KEY : CONDITION　の VALUE を取得する。(文字列）
    // 　病状を45文字（９０バイト）で分割する
    // 　病状を設定する。
    //     setValue(CONDITION);
    ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam,
                "CONDITION", "condition", 90);

    // ※病状経過等の設定
    // 　渡りパラメータから KEY : CONDITION_PASSAGE の VALUE を取得する。(文字列）
    // 　病状経過を45文字（９０バイト）で分割する
    // 　病状経過等を設定する。
    //     setValue(CONDITION_PASSAGE);
    ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam,
            "CONDITION_PASSAGE", "conditionPassage", 90);
    // ※介護サービスを利用する上での留意点・介護方法等の設定
    // 　渡りパラメータから KEY : NOTE_OF_KAIGO_SERVICE の VALUE を取得する。(文字列）
    // 　介護サービスを利用する上での留意点・介護方法等を45文字（９０バイト）で分割する
    // 　介護サービスを利用する上での留意点・介護方法等を設定する。
    //     setValue(NOTE_OF_KAIGO_SERVICE);
    ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam,
            "NOTE_OF_KAIGO_SERVICE", "noteOfKaigoService", 90);
    // ※利用者の日常生活上の留意点の設定
    // 　渡りパラメータから KEY : NOTE_OF_DAILY_LIFE の VALUE を取得する。(文字列）
    // 　利用者の日常生活上の留意点を45文字（９０バイト）で分割する
    // 　利用者の日常生活上の留意点を設定する。
    //     setValue(NOTE_OF_DAILY_LIFE);
    ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam,
            "NOTE_OF_DAILY_LIFE", "noteOfDailyLife", 90);
    // ※備考の設定
    // 　渡りパラメータから KEY : REMARKS の VALUE を取得する。(文字列）
    // 　備考を45文字（９０バイト）で分割する
    // 　備考の留意点を設定する。
    //     setValue(REMARKS);
    ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam,
            "REMARKS", "remarks", 90);
    //ページ終了
    writer.endPageEdit();
    //TODO 印刷を実行したならばtrueを返す。
    return true;
  }
  
  /**
   * 指定された文字数で改行した文字列を返します。
   * @param chr 改行対象となる文字列
   * @param byteIndex 改行基準バイト数
   * @return 改行文字を挿入した文字列
   */
  public String getInsertionLineSeparatorToStringOnByte(String chr, int byteIndex){
      String[] slCharacter = ACTextUtilities.separateLineWrapOnByte(chr,byteIndex);
      
      StringBuilder sbCharacter = new StringBuilder();

      for (int i = 0; i < slCharacter.length; i++) {
          sbCharacter.append(slCharacter[i]);
          //最終行である場合は改行コードを追加しない
          if (i != slCharacter.length - 1) {
              //改行コードを追加する
              sbCharacter.append(ACConstants.LINE_SEPARATOR);
          }
      }

      String insertionLineSeparatorString = sbCharacter.toString();
      
      return insertionLineSeparatorString;
  }
  

}
