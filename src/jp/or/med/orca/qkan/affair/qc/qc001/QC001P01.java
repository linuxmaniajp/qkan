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
 * 作成日: 2005/12/19  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 訪問看護計画書 (00101)
 * プログラム 訪問看護計画書 (QC00101)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc001;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 訪問看護計画書(QC00101) 帳票定義体ファイル名 ： QC00101.xml
 * 
 * [ID:0000758][Shin Fujihara] 2012/09 edit 2012年度対応 評価項目の追加
 * 大幅に修正したため、履歴コメントは残していません。
 * CVSの履歴を参照してください。
 */
public class QC001P01 extends QC001P01Event {
    /**
     * コンストラクタです。
     */
    public QC001P01() {
    }

    public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam)
            throws Exception {

        VRList list = null;

        // 問題点・解決策テーブルの情報を取得
        if (VRBindPathParser.has("PLAN_NOTE", printParam)) {
            list = (VRList) VRBindPathParser.get("PLAN_NOTE", printParam);
        }

        // 印刷するページ数と項目を算出
        VRList printNoteDataList = calcPagePrint(list);

        // 印刷するデータ格納用変数
        VRList printList = new VRArrayList();

        ACChotarouXMLUtilities.addFormat(writer, "homonkangoKeikakusyo",
                "QC001P01.xml");

        int allPage = printNoteDataList.size();
        // 合計ページ数設定
        printParam.setData("ALL_PAGE", new Integer(allPage));

        // 印刷するページ数分ループ処理
        for (int i = 0; i < printNoteDataList.size(); i++) {

            // 1ページ分のデータを取得
            printList = (VRList) printNoteDataList.getData(i);

            // 現在のページ数を設定
            printParam.setData("NOW_PAGE", new Integer(i + 1));

            // 1ページ分印字
            doPrint(writer, printParam, printList);

        }

        return true;
    }

    /**
     * 帳票を生成します。
     * 
     * @param writer 印刷管理クラス
     * @param printParam 印刷パラメタ
     * @throws Exception 処理例外
     */
    public void doPrint(ACChotarouXMLWriter writer, VRMap printParam,
            VRList printList) throws Exception {
        // TODO 帳票IDを必要に応じて"mainFormat"から適切なものに書き換えること。

        // ページ開始
        writer.beginPageEdit("homonkangoKeikakusyo");
        // 利用者氏名を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_NAME",
                "patient1.h2.patientName");
        // 渡りパラメータprintParamの KEY:PATIENT_BIRTHDAYのVALUEを取得する。
        Date pd = new Date();
        if (VRBindPathParser.has("PATIENT_BIRTHDAY", printParam)) {

            // 利用者誕生日を取得
            pd = (Date) VRBindPathParser.get("PATIENT_BIRTHDAY", printParam);

        }
        String wareki = VRDateParser.getEra(pd).getAbbreviation(3);
        // 取得した値を和暦に変換する。
        if ("明治".equals(VRDateParser.getEra(pd).getAbbreviation(3))) {
            // 年号によって分岐する。
            // 明治の場合
            // 「大正」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
            // 「昭和」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
            // 「平成」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
            // 大正の場合
        } else if ("大正".equals(VRDateParser.getEra(pd).getAbbreviation(3))) {
            // 「明治」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
            // 「昭和」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
            // 「平成」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
            // 昭和の場合
        } else if ("昭和".equals(VRDateParser.getEra(pd).getAbbreviation(3))) {
            // 「明治」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
            // 「大正」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
            // 「平成」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
            // 平成の場合
        } else if ("平成".equals(VRDateParser.getEra(pd).getAbbreviation(3))) {
            // 「明治」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
            // 「大正」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
            // 「昭和」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
        } else {
            // 「明治」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
            // 「大正」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
            // 「昭和」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
            // 「平成」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
        }
        // 年を設定する。
        ACChotarouXMLUtilities.setValue(writer, "patient1.h2.year",
                new Integer(ACDateUtilities.getEraYear(pd)));

        // 月を設定する。
        ACChotarouXMLUtilities.setValue(writer, "patient1.h2.month",
                new Integer(ACDateUtilities.getMonth(pd)));
        // setValue(patient1.month.h);

        // 日を設定する。
        ACChotarouXMLUtilities.setValue(writer, "patient1.h2.day", new Integer(
                ACDateUtilities.getDayOfMonth(pd)));
        // setValue(patient1.day.h);

        // 利用者年齢を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_AGE",
                "patientAge.h1.w4");
        
        // 要介護度
        int jotaiCode = ACCastUtilities.toInt(VRBindPathParser.get("JOTAI_CODE", printParam), 1);        	
        
        switch (jotaiCode) {
        // 渡りパラメータprintParamのKEY:JOTAI_CODEのVALUEによって分岐する。
        // 「自立」の場合
        case 1:
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // ｢要支援1｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ｢要支援2｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        case 11:
            // 「要支援」の場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // ｢要支援1｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ｢要支援2｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        case 12:
            // 「要支援1」の場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // ｢経過的要介護｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // ｢要支援2｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // 処理終了
            break;
        case 13:
            // ｢要支援2｣の場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // ｢経過的要介護｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // ｢要支援1｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // 処理を終了する。
            break;

        // 「要介護１」の場合
        case 21:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // ｢要支援1｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ｢要支援2｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        // 「要介護２」の場合
        case 22:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // ｢要支援1｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ｢要支援2｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        // 「要介護３」の場合
        case 23:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // ｢要支援1｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ｢要支援2｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        // 「要介護４」の場合
        case 24:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // ｢要支援1｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ｢要支援2｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        // 「要介護５」の場合
        case 25:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // ｢要支援1｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ｢要支援2｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        default:
//            // 「自立」のシェイプを非表示にする。
//            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // ｢要支援1｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ｢要支援2｣のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        }
        
        // 利用者住所を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_ADDRESS",
                "patient2.h1.w3");

        // 看護・リハビリテーションの目的を設定する。
        String purpose = (String) VRBindPathParser.get("PLAN_PURPOSE",
                printParam);

        // 43文字ごとに区切った配列を取得する
        String[] strPurpose = ACTextUtilities.separateLineWrapOnByte(purpose,
                88);
        // 行数ごとのリスト形式に変換する
        List listPurpose = Arrays.asList(strPurpose);

        StringBuilder sb = new StringBuilder();

        // 行数分ループする
        for (int i = 0; i < listPurpose.size(); i++) {
            sb.append(listPurpose.get(i));
            // 最終行のみ改行を追加しない
            if (i != listPurpose.size() - 1) {
                sb.append(ACConstants.LINE_SEPARATOR);
            }
        }

        purpose = sb.toString();
        // 目標を印字する
        ACChotarouXMLUtilities.setValue(writer, "planPurpose", purpose);

        // 備考を設定する。
        String planComment = (String) VRBindPathParser.get("PLAN_COMMENT",
                printParam);
        // 取得した備考を４３文字ごとに
        String[] strPlanComment = ACTextUtilities.separateLineWrapOnByte(
                planComment, 86);

        List listPlanComment = Arrays.asList(strPlanComment);
        // 初期化
        sb = new StringBuilder();

        for (int i = 0; i < listPlanComment.size(); i++) {
            sb.append(listPlanComment.get(i));
            // 最終行である場合は追加しない
            if (i != listPlanComment.size() - 1) {
                sb.append(ACConstants.LINE_SEPARATOR);
            }
        }

        planComment = sb.toString();

        ACChotarouXMLUtilities.setValue(writer, "planComment.h2.w2",
                planComment);

        // 渡りパラメータprintParamのKEY:PLAN_NOTESのVALUE (レコード配列)を取得する。
        // 取得したレコード配列を設定する。ただし、印刷の条件は下記のとおりとする。
        // ・
        // ・
        // ・
        // ・
        // は設定しない。
        // ・
        // 次頁に設定する。(例えば、残り2行分の空きしかないところに、3行の「問題点・解決策」を設定する場合、その頁の2行は空行として、
        // 次頁に改めて「問題点・解決策」を設定する。)
        // ・

        // 渡りパラメータprintParamのKEY:CREATE_DATEのVALUEを取得する。
        for (int i = 0; i < printList.size(); i++) {
        	
        	String rowHeader = "note.note" + (i + 2) + ".";
        	
            // クラスから取り出したデータを格納する。
        	PrintDataRow prinData = (PrintDataRow) printList.getData(i);
            // 日付を取得する
            Date noteDate = prinData.getNoteDate();
            
            // 日付がnullでない場合は、印字する
            if (noteDate != null) {
                VRDateFormat vf = new VRDateFormat("ggge年MM月dd日");
                ACChotarouXMLUtilities.setValue(writer, rowHeader + "ymd", vf.format(noteDate));
            }
            
            // 問題点・解決策がnullでなければ印字する
            if (prinData.getNoteComment() != null) {
            	ACChotarouXMLUtilities.setValue(writer, rowHeader + "comment", prinData.getNoteComment());
            }
        	
            // 評価がnullでなければ印字する
            if (prinData.getNoteAssessment() != null) {
            	ACChotarouXMLUtilities.setValue(writer, rowHeader + "assessment", prinData.getNoteAssessment());
            }
        }
        

        // 取得した値を和暦に変換する。

        Date createDate = (Date) printParam.getData("CREATE_DATE");

        // 年を設定する。
        ACChotarouXMLUtilities.setValue(writer, "createDate.h1.w2",
                new Integer(ACDateUtilities.getEraYear(createDate)));
        // setValue(createDate.year.h1);
        // 月を設定する。
        ACChotarouXMLUtilities.setValue(writer, "createDate.h1.w4",
                new Integer(ACDateUtilities.getMonth(createDate)));
        // setValue(createDate.month.h1);

        // 日を設定する。
        ACChotarouXMLUtilities.setValue(writer, "createDate.h1.w6",
                new Integer(ACDateUtilities.getDayOfMonth(createDate)));
        // setValue(createDate.day.h1);

        // ステーション名を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "PROVIDER_NAME",
                "station.stationName.value");
        // 管理者氏名を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam,
                "ADMINISTRATOR_NAME", "station.administratorName.value");
        // 主治医氏名を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "DOCTOR_NAME",
                "doctor.doctorName.value");

        // 合計ページ数を印字
        ACChotarouXMLUtilities.setValue(writer, printParam, "ALL_PAGE",
                "grdPage.h1.max");
        // 現在のページ数を印字
        ACChotarouXMLUtilities.setValue(writer, printParam, "NOW_PAGE",
                "grdPage.h1.now");

        // ページ終了
        writer.endPageEdit();
        // TODO 印刷を実行したならばtrueを返す。

        // }

    }
    
    @SuppressWarnings("unchecked")
    private VRList calcPagePrint(VRList list) throws Exception {
    	
    	// 戻り値を格納する
    	VRList result = new VRArrayList();
    	// 1ページ分のコメントデータ
    	VRList pageList = new VRArrayList();
    	
    	// 初期ページを設定
    	result.add(pageList);
    	
    	//listが設定されていない場合は処理終了
    	if (list == null) {
    		return result;
    	}
    	
    	//一旦、改ページを加味しないリストを作成
    	for (int i = 0; i < list.size(); i++) {
    		VRMap map = (VRMap) list.getData(i);
    		
    		pageList = splitComments(result, pageList, map);
    	}
    	
    	return result;

    }
    
    private VRList splitComments(VRList result, VRList pageList, VRMap map) throws Exception {
    	
    	PrintDataRow row = new PrintDataRow();
    	
		//問題点・解決策の日付を取得する
		row.setNoteDate((Date) VRBindPathParser.get("NOTE_DATE", map));
		pageList = addPageList(result, pageList, row);
		
		String[] comments = new String[]{};
		String[] assessments = new String[]{};
		
		if (VRBindPathParser.get("NOTE_COMMENT",map) != null) {
			String comment = String.valueOf(VRBindPathParser.get("NOTE_COMMENT",map));
			comments = ACTextUtilities.separateLineWrapOnByte(comment, 68);
		}
		if (VRBindPathParser.get("NOTE_ASSESSMENT",map) != null) {
			String assessment = String.valueOf(VRBindPathParser.get("NOTE_ASSESSMENT",map));
			assessments = ACTextUtilities.separateLineWrapOnByte(assessment, 20);
		}
		
		int commentCount = comments.length;
		int assessmentCount = assessments.length;
		
		int maxLength = Math.max(commentCount, assessmentCount);
		
		for (int i = 0; i < maxLength; i++) {
			
			if (i != 0) {
				row = new PrintDataRow();
				pageList = addPageList(result, pageList, row);
			}
			
			if (i < commentCount) {
				row.setNoteComment(comments[i]);
			}
			
			if (i < assessmentCount) {
				row.setNoteAssessment(assessments[i]);
			}
		}
		
		return pageList;
    }
    
    @SuppressWarnings("unchecked")
    private VRList addPageList(VRList result, VRList pageList, PrintDataRow row) {
    	
    	// 1ページ11行とし、ページ単位のリストに分割
		if (11 <= pageList.size()) {
			pageList = new VRArrayList();
			result.add(pageList);
		}
    	
    	pageList.add(row);
    	
    	return pageList;
    }

    protected class PrintDataRow {

        // 評価の日付
        private Date noteDate = null;
        // 問題点・解決策の一行分
        private String noteComment = null;
        // 評価の一行分
        private String noteAssessment = null;

        Date getNoteDate() {
            return noteDate;
        }

        void setNoteDate(Date noteDate) {
            this.noteDate = noteDate;
        }

        String getNoteComment() {
            return noteComment;
        }

        void setNoteComment(String noteComment) {
            this.noteComment = noteComment;
        }
        
        String getNoteAssessment() {
        	return noteAssessment;
        }
        
        void setNoteAssessment(String noteAssessment) {
        	this.noteAssessment = noteAssessment;
        }
        
    }

}
