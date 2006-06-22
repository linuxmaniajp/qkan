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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 訪問看護計画書(QC00101) 帳票定義体ファイル名 ： QC00101.xml
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

        StringBuffer sb = new StringBuffer();

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
        sb = new StringBuffer();

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
        VRList chotaList = null;
        chotaList = new VRArrayList();

        int k = 2;
        chotaList = printList;

        // ページ単位のデータから1クラス取り出す
        for (int j = 0; j < chotaList.size(); j++) {

            // クラスから取り出したデータを格納する。
            PrintData prinData = (PrintData) chotaList.getData(j);

            // 日付を取得する
            Date noteDate = prinData.getNoteDate();

            // 表示用日付格納用変数
            String formatNoteDate = "";

            // 日付がnullでないかチェックする
            if (null != noteDate) {
                VRDateFormat vf = new VRDateFormat("ggge年MM月dd日");

                formatNoteDate = vf.format(noteDate);
            }

            // 複数行のコメントを取得する
            List recordList = prinData.getNoteComment();

            // リスト状のコメントを取得する
            // List commentList = (List)recordList.get(0);

            // 日付印字
            ACChotarouXMLUtilities.setValue(writer, "note.note" + k + ".ymd",
                    formatNoteDate);

            for (int i = 0; i < recordList.size(); i++) {
                // 行数分印字
                ACChotarouXMLUtilities.setValue(writer, "note.note" + k
                        + ".comment", recordList.get(i));

                // 帳票太郎の印刷行数のカウントを＋１
                k++;
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

    private VRList calcPagePrint(VRList list) throws Exception {

        // 戻り値を格納する
        VRList result = new VRArrayList();
        // 1ページ分
        VRList pageList = new VRArrayList();
        // 1レコードを表すクラス
        PrintData pdClass = new PrintData();
        // 日付を格納する変数
        Date noteDate = new Date();
        // コメントを格納する変数
        String comment = new String();
        // 行数ごとに分割した文字列を保存する配列
        String[] slComment = null;
        // 1枚目かどうかを判別するフラグ
        boolean gyouCheckFlag = true;
        // 合計行数を記録する変数
        int currentCount = 0;
        // 11行であるか判別する 11行であった場合はtrue
        boolean countOver11 = false;
        // 最終ページの行数が11行調度であるか判別する 11行であった場合はtrue
        boolean lastPageGyou = false;

        if (list != null) {

            for (int i = 0; i < list.size(); i++) {
                // 1レコード分データを取得する
                VRMap record = (VRMap) list.getData(i);
                // 問題点・解決策のデータを取得する
                comment = String.valueOf(VRBindPathParser.get("NOTE_COMMENT",
                        record));
                // 問題点・解決策の日付を取得する
                noteDate = (Date) VRBindPathParser.get("NOTE_DATE", record);
                // 改行、規定文字数で区切った配列を取得する。
                slComment = ACTextUtilities.separateLineWrapOnByte(comment, 86);

                List sList = Arrays.asList(slComment);

                // コメントの行数
                int len = sList.size();
                // 最終追加時判断用
                // 初期化
                countOver11 = false;
                // 自分自身が11行以上の場合
                if (len >= 11) {
                    // 1枚目以外であった場合
                    if (!gyouCheckFlag) {
                        // 11行であった場合
                        if (!lastPageGyou) {
                            result.add(pageList);
                        }
                    }

                    lastPageGyou = false;

                    int end = len / 11;
                    int lastCount = 0;
                    currentCount = 0;

                    // クラスに追加
                    pdClass.setNoteDate(noteDate);

                    // 11行単位で分割
                    for (int j = 0; j < end; j += 1) {
                        // 新規頁生成
                        pageList = new VRArrayList();
                        // 新たに追加する行数を保持
                        lastCount += 11;
                        // クラスに追加
                        pdClass
                                .setNoteComment(sList
                                        .subList(j * 11, lastCount));
                        // 新規頁Arrayに追加
                        pageList.add(pdClass);
                        // 11件追加
                        result.add(pageList);
                        // 新規頁生成
                        pageList = new VRArrayList();
                        // クラス初期化
                        pdClass = new PrintData();

                    }
                    if (len % 11 != 0) {
                        // 11行追加した後の処理
                        // 残り行数を追加
                        pdClass.setNoteComment(sList.subList(lastCount, len));
                        // クラスに追加 (1ページ分のデータは保持する）
                        pageList.add(pdClass);
                        // 追加した行数を保持(全件数-件数)
                        currentCount = len - lastCount;
                        // クラス初期化
                        pdClass = new PrintData();
                        lastCount = 0;

                    } else {
                        // 合計が11行になった場合
                        countOver11 = true;
                        lastPageGyou = true;

                    }
                    // 自分自身が11行以内の場合
                } else {

                    // 追加行数が11行以内であれば追加
                    if (currentCount + len < 11) {
                        pdClass = new PrintData();
                        // クラスに追加
                        pdClass.setNoteComment(sList);
                        pdClass.setNoteDate(noteDate);
                        // 1ページ分のデータに追加
                        pageList.add(pdClass);
                        // クラス初期化
                        pdClass = new PrintData();
                        // 件数を保持
                        currentCount += len;
                        // 11行以外
                        lastPageGyou = false;

                    } else if (currentCount + len == 11) {
                        // クラス追加
                        pdClass.setNoteComment(sList.subList(0, len));
                        pdClass.setNoteDate(noteDate);
                        // 1ページ分追加
                        pageList.add(pdClass);
                        // 11行追加
                        result.add(pageList);
                        // 新規頁生成
                        pageList = new VRArrayList();
                        pdClass = new PrintData();
                        // 初期化
                        currentCount = 0;
                        // 11行以上を保持
                        // 最終追加時に使用
                        countOver11 = true;
                        lastPageGyou = true;

                        // 追加行数が11行以上の場合は、11行になるよう追加
                    } else {
                        // int check = currentCount;
                        // クラスの追加
                        pdClass.setNoteComment(sList.subList(0,
                                11 - currentCount));
                        pdClass.setNoteDate(noteDate);

                        pageList.add(pdClass);
                        // 11行追加
                        result.add(pageList);
                        // 新規頁生成
                        pageList = new VRArrayList();
                        pdClass = new PrintData();
                        // 追加行数の算出
                        int addLen = 11 - currentCount;
                        // 残りの行数を追加
                        pdClass.setNoteComment(sList.subList(addLen, len));
                        // ページに追加
                        pageList.add(pdClass);
                        // クラス初期化
                        pdClass = new PrintData();
                        // 追加行数
                        int nokori = len - addLen;
                        currentCount = nokori;

                    }
                    // 追加した行数が11行であった場合は追加させない
                    if (!lastPageGyou) {
                        gyouCheckFlag = false;
                    }
                }
                // 追加した行数が11行であった場合は追加させない
                if (!lastPageGyou) {
                    gyouCheckFlag = false;
                }

            }

            // 最終ページ追加
            // 追加行数が11行である場合は追加しない
            if (!countOver11) {
                // 初期化
                countOver11 = false;
                // 戻り値として追加
                result.add(pageList);
            }
        }
        return result;
    }

    protected class PrintData {

        // コメントの日付
        private Date noteDate;
        // 複数行の文字列
        private List noteComment;

        Date getNoteDate() {
            return noteDate;
        }

        void setNoteDate(Date noteDate) {
            this.noteDate = noteDate;
        }

        List getNoteComment() {
            return noteComment;
        }

        void setNoteComment(List noteComment) {
            this.noteComment = noteComment;
        }

    }

}
