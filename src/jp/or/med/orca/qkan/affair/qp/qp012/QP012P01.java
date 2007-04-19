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
 * 開発者: 田中　統蔵
 * 作成日: 2006/08/31  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 訪問看護療養費領収書編集 (012)
 * プログラム 訪問看護療養費領収書 (QP012P01)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp012;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * 訪問看護療養費領収書(QP012P01) 帳票定義体ファイル名 ： QP012P01.xml
 */
public class QP012P01 extends QP012P01Event {
    /**
     * コンストラクタです。
     */
    public QP012P01() {
    }

    /**
     * 帳票を生成します。
     * 
     * @param writer 印刷管理クラス
     * @param printParam 印刷パラメタ
     * @throws Exception 処理例外
     */
    public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam)
            throws Exception {

        //帳票定義体名をあらわす文字列変数formatNameを定義し「QP012P01.xml」で初期化する。
        String formatName = "QP012P01.xml";
        
        if(ACCastUtilities.toBoolean(printParam.getData("InnerTaxH1904Mode"), false)){
            //引数printParamのキー「InnerTaxH1904Mode」で真偽時を取得し、値が真(true)の場合
            //formatNameに「QP012P02.xml」を代入する。
            formatName = "QP012P02.xml";
        }
        
        
        // 2006/09/26
        // 金額欄表示変更に伴いフォーマッタを追加
        // Addition - begin [Masahiko Higuchi]
        NumberFormat nf = NumberFormat.getIntegerInstance();
        // Addition - end

        // 印刷ページ数を算出する
        pageCalc(printParam);
        // ページ数分処理をループ
        for (int i = 0; i <= ACCastUtilities.toInt(printParam
                .getData("LAST_PAGE")) - 1; i++) {

            // 必要であれば帳票IDを書き換えること。
            ACChotarouXMLUtilities
                    .addFormat(writer, "QP012P01", formatName);
            // ページ開始
            writer.beginPageEdit("QP012P01");
            // ※印刷処理を行なう。

            // 渡りパラメーターであるDBManagerを取得する。
            if (printParam.getData("DBM") instanceof ACDBManager) {
                ACDBManager dbm = (ACDBManager) printParam.getData("DBM");
                VRMap map = null;
                VRList providerList = QkanCommon.getProviderInfo(dbm,
                        QkanSystemInformation.getInstance()
                                .getLoginProviderID());
                // 事業所情報の取得
                if (!providerList.isEmpty()) {
                    map = (VRMap) providerList.getData(0);
                }
                // 訪問看護医療情報を取得
                VRList serviceList = (VRArrayList) QkanCommon
                        .getProviderServiceDetail(dbm, QkanSystemInformation
                                .getInstance().getLoginProviderID(), 20101);
                if (!serviceList.isEmpty()) {
                    map.putAll((VRMap) serviceList.getData(0));
                    // 1130103 管理者名
                }
                ACChotarouXMLUtilities.setValue(writer, map,
                        "PROVIDER_ADDRESS", "provider.h1.w1");
                ACChotarouXMLUtilities.setValue(writer, map, "PROVIDER_NAME",
                        "provider.h2.w1");
                ACChotarouXMLUtilities.setValue(writer, map, "1130103",
                        "provider.h3.w1");

            }

            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_1
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_2
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_3
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_4
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_5
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_6
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_7
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_8
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_9
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_10
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_11
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_12
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_13
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_14
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_15
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_16
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_17
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_18
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_19
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_20
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_21
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_22
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_23
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_24
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_25
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_26
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_27
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_28
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_29
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_30
            // 内部メソッドに下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String PROVIDE_DAY_31
            for (int j = 1; j <= 31; j++) {
                convertCalenderData(printParam, "PROVIDE_DAY_" + j);
            }

            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX1
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX2
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX3
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX4
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX5
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX6
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX7
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX8
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX9
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX10
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX11
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX12
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX13
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX14
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX15
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX16
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX17
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX18
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX19
            // 内部メソッド(convertTax)に下記の値を引数として渡し印刷用データに変換する。
            // VRMap printParam String BY_PATIENT_USE_TAX20
            for (int k = 1; k <= 20; k++) {
                //replace-begin 2007/03/10 Tozo Tanaka
                //convertTax(printParam, "BY_PATIENT_USE_TAX" + k);
                if (ACCastUtilities.toInt(VRBindPathParser.get(
                        "BY_PATIENT_TAX_TARGET" + k, printParam), 0) != 0) {
                    //課税対象の場合のみ税区分を印字
                    convertTax(printParam, "BY_PATIENT_USE_TAX" + k);
                }
                //replace-end 2007/03/10 Tozo Tanaka
            }

            // 渡りパラメーター printParam
            // KEY：PATIENT_NAME
            ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_NAME",
                    "basicInfo.h2.w4");
            // フォーマット生成
            VRDateFormat vf = new VRDateFormat("ggge年M月d日");
            // 渡りパラメーターprintParam から KEY：BILL_SPAN_STARTのVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, "billSpan.h2.w1", vf
                    .format(ACCastUtilities.toDate(printParam
                            .getData("BILL_SPAN_START"))));
            // 渡りパラメーターprintParam から KEY：BILL_SPAN_ENDのVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, "billSpan.h2.w2", vf
                    .format(ACCastUtilities.toDate(printParam
                            .getData("BILL_SPAN_END"))));
            // 渡りパラメーターprintParam から KEY：BILL_NOのVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam, "BILL_NO",
                    "basicInfo.h2.w1");
            // 渡りパラメーターprintParam から KEY：BILL_PATIENT_CODEのVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "BILL_PATIENT_CODE", "basicInfo.h2.w3");
            // 渡りパラメーターprintParam から KEY：BILL_PRINT_DATEのVALUEを取得し設定する。
            printParam.setData("PRINT_BILL_PRINT_DATE", ACCastUtilities.toDate(
                    printParam.getData("BILL_PRINT_DATE"), null));
            // 日付型が送られてこなかった場合は空白で出力する。
            if (printParam.getData("PRINT_BILL_PRINT_DATE") != null) {
                ACChotarouXMLUtilities.setValue(writer, "billInfo.h2.w1", vf
                        .format(ACCastUtilities.toDate(printParam
                                .getData("PRINT_BILL_PRINT_DATE"))));
            } else {
                ACChotarouXMLUtilities.setValue(writer, "billInfo.h2.w1", "");
            }
            // 渡りパラメーターprintParam から KEY：BY_PATIENT_RATEのVALUEを取得し設定する。
            printParam.setData("PRINT_BY_PATIENT_RATE", ACCastUtilities.toInt(
                    printParam.getData("BY_PATIENT_RATE"), 0)
                    + "割");
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT_BY_PATIENT_RATE", "billInfo.h2.w2");
            // 渡りパラメーターprintParam から KEY：SELF_FLAG のVALUEを取得し設定する。
            if (printParam.getData("SELF_FLAG") instanceof Integer) {
                // 値を文字列に変換する。
                // 1:本人 2:3歳 3:家族
                switch (ACCastUtilities.toInt(printParam.getData("SELF_FLAG"))) {
                case 1:
                    printParam.setData("SELF_VALUE", "本人");
                    break;
                case 2:
                    printParam.setData("SELF_VALUE", "3歳");
                    break;
                case 3:
                    printParam.setData("SELF_VALUE", "家族");
                    break;
                default:
                    printParam.setData("SELF_VALUE", "");
                    break;
                }
            }

            ACChotarouXMLUtilities.setValue(writer, printParam, "SELF_VALUE",
                    "billInfo.h2.w3");
            // 渡りパラメーターprintParam から KEY：BY_PATIENT_RATEのVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "BILL_INSURE_TYPE", "billInfo.h2.w4");
            // 1枚目の場合
            if (i == 0) {

                // 渡りパラメーターprintParam から KEY：BY_INSURER_NAME1のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_PRICE1のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NUMBER1のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_SUM1のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NAME2のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_PRICE2のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NUMBER2のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_SUM2のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NAME3のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_PRICE3のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NUMBER3のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_SUM3のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NAME4のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_PRICE4のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NUMBER4のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_SUM4のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NAME5のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_PRICE5のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NUMBER5のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_SUM5のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NAME6のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_PRICE6のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NUMBER6のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_SUM6のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NAME7のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_PRICE7のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NUMBER7のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_SUM7のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NAME8のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_PRICE8のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NUMBER8のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_SUM8のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NAME9のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_PRICE9のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NUMBER9のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_SUM9のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NAME10のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_PRICE10のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_NUMBER10のVALUEを取得し設定する。
                // 渡りパラメーターprintParam から KEY：BY_INSURER_SUM10のVALUEを取得し設定する。
                int heightCount = 2;
                for (int l = 1; l <= 10; l++) {

                    ACChotarouXMLUtilities.setValue(writer, printParam,
                            "BY_INSURER_NAME" + l, "byInsurer.h" + heightCount
                                    + ".w2");
                    // 2006/09/26
                    // 金額欄表示変更に伴いフォーマッタを追加
                    // Replace - begin [Masahiko Higuchi]
                    // KEYが存在する場合は金額表示
                    if (!"".equals(VRBindPathParser.get("BY_INSURER_NAME" + l,
                            printParam))
                            && VRBindPathParser.get("BY_INSURER_NAME" + l,
                                    printParam) != null) {
                        // 値が入力されているかチェックする。
                        if (!"".equals(VRBindPathParser.get("BY_INSURER_PRICE"
                                + l, printParam))
                                && VRBindPathParser.get("BY_INSURER_PRICE" + l,
                                        printParam) != null) {
                            ACChotarouXMLUtilities.setValue(writer,
                                    "byInsurer.h" + heightCount + ".w3", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_INSURER_PRICE"
                                                                    + l,
                                                            printParam), 0)));
                        }

                        if (!"".equals(VRBindPathParser.get("BY_INSURER_NUMBER"
                                + l, printParam))
                                && VRBindPathParser.get(
                                        "BY_INSURER_NUMBER" + l, printParam) != null) {
                            ACChotarouXMLUtilities.setValue(writer,
                                    "byInsurer.h" + heightCount + ".w4", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_INSURER_NUMBER"
                                                                    + l,
                                                            printParam), 0)));
                        }

                        if (!"".equals(VRBindPathParser.get("BY_INSURER_SUM"
                                + l, printParam))
                                && VRBindPathParser.get("BY_INSURER_SUM" + l,
                                        printParam) != null) {
                            ACChotarouXMLUtilities.setValue(writer,
                                    "byInsurer.h" + heightCount + ".w5", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_INSURER_SUM"
                                                                    + l,
                                                            printParam), 0)));
                        }
                    }
                    // Replace - end [Masahiko Higuchi]

                    // 項目名が未入力の場合は一律印字処理を行わない
                    if (!"".equals(VRBindPathParser.get("BY_PATIENT_NAME" + l,
                            printParam))
                            && VRBindPathParser.get("BY_PATIENT_NAME" + l,
                                    printParam) != null) {
                        // 渡りパラメーターprintParam から
                        // KEY：BY_PATIENT_NAME1のVALUEを取得し設定する。

                        // 2006/09/26
                        // 金額欄表示変更に伴いフォーマッタを追加
                        // Replace - begin [Masahiko Higuchi]

                        ACChotarouXMLUtilities.setValue(writer, printParam,
                                "BY_PATIENT_NAME" + l, "byPatient.h"
                                        + heightCount + ".w2");
                        // 渡りパラメーターprintParam から
                        // KEY：BY_PATIENT_PRICE1のVALUEを取得し設定する。
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_PRICE"
                                + l, printParam))
                                && VRBindPathParser.get("BY_PATIENT_PRICE" + l,
                                        printParam) != null) {
                            // 印字
                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w3", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_PRICE"
                                                                    + l,
                                                            printParam), 0)));
                        }
                        // 渡りパラメーターprintParam から
                        // KEY：BY_PATIENT_NUMBER1のVALUEを取得し設定する。
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_NUMBER"
                                + l, printParam))
                                && VRBindPathParser.get(
                                        "BY_PATIENT_NUMBER" + l, printParam) != null) {

                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w4", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_NUMBER"
                                                                    + l,
                                                            printParam), 0)));
                        }
                        // 渡りパラメーターprintParam から
                        // KEY：BY_PATIENT_SUM1のVALUEを取得し設定する。
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_SUM"
                                + l, printParam))
                                && VRBindPathParser.get("BY_PATIENT_SUM" + l,
                                        printParam) != null) {

                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w5", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_SUM"
                                                                    + l,
                                                            printParam), 0)));
                        // 渡りパラメーターprintParam から
                        // KEY：PRINT_BY_PATIENT_USE_TAX1のVALUEを取得し設定する。
                        ACChotarouXMLUtilities.setValue(writer, printParam,
                                "PRINT_BY_PATIENT_USE_TAX" + l, "byPatient.h"
                                        + heightCount + ".w6");
                        }
                        // 渡りパラメーターprintParam から
                        // KEY：BY_PATIENT_TAX1のVALUEを取得し設定する。
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_TAX"
                                + l, printParam))
                                && VRBindPathParser.get("BY_PATIENT_TAX" + l,
                                        printParam) != null) {

                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w7", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_TAX"
                                                                    + l,
                                                            printParam), 0)));
                        }
                        // Replace - end [Masahiko Higuchi]
                    }
                    heightCount++;
                }

            } else if (i == 1) {

                int heightCount = 2;
                for (int l = 11; l <= 20; l++) {

                    ACChotarouXMLUtilities.setValue(writer, printParam,
                            "BY_INSURER_NAME" + l, "byInsurer.h" + heightCount
                                    + ".w2");
                    // 2006/09/26
                    // 金額欄表示変更に伴いフォーマッタを追加
                    // Replace - begin [Masahiko Higuchi]
                    // 項目未入力なら処理はスキップ
                    if (!"".equals(VRBindPathParser.get("BY_INSURER_NAME" + l,
                            printParam))
                            && VRBindPathParser.get("BY_INSURER_NAME" + l,
                                    printParam) != null) {

                        if (!"".equals(VRBindPathParser.get("BY_INSURER_PRICE"
                                + l, printParam))
                                && VRBindPathParser.get("BY_INSURER_PRICE" + l,
                                        printParam) != null) {

                            ACChotarouXMLUtilities.setValue(writer,
                                    "byInsurer.h" + heightCount + ".w3", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_INSURER_PRICE"
                                                                    + l,
                                                            printParam), 0)));
                        }

                        if (!"".equals(VRBindPathParser.get("BY_INSURER_NUMBER"
                                + l, printParam))
                                && VRBindPathParser.get("BY_INSURER_NUMBER" + l,
                                        printParam) != null) {

                            ACChotarouXMLUtilities.setValue(writer,
                                    "byInsurer.h" + heightCount + ".w4", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_INSURER_NUMBER"
                                                                    + l,
                                                            printParam), 0)));
                        }

                        if (!"".equals(VRBindPathParser.get("BY_INSURER_SUM"
                                + l, printParam))
                                && VRBindPathParser.get("BY_INSURER_SUM" + l,
                                        printParam) != null) {

                            ACChotarouXMLUtilities.setValue(writer,
                                    "byInsurer.h" + heightCount + ".w5", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_INSURER_SUM"
                                                                    + l,
                                                            printParam), 0)));
                        }
                    }
                    // Replace - end [Masahiko Higuchi]

                    // 項目名が未入力の場合は一律印字処理を行わない
                    if (!"".equals(VRBindPathParser.get("BY_PATIENT_NAME" + l,
                            printParam))
                            && VRBindPathParser.get("BY_PATIENT_NAME" + l,
                                    printParam) != null) {
                        // 渡りパラメーターprintParam から
                        // KEY：BY_PATIENT_NAME1のVALUEを取得し設定する。
                        // 2006/09/26
                        // 金額欄表示変更に伴いフォーマッタを追加
                        // Replace - begin [Masahiko Higuchi]

                        ACChotarouXMLUtilities.setValue(writer, printParam,
                                "BY_PATIENT_NAME" + l, "byPatient.h"
                                        + heightCount + ".w2");
                        // 渡りパラメーターprintParam から
                        // KEY：BY_PATIENT_PRICE1のVALUEを取得し設定する。
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_PRICE"
                                + l, printParam))
                                && VRBindPathParser.get("BY_PATIENT_PRICE" + l,
                                        printParam) != null) {

                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w3", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_PRICE"
                                                                    + l,
                                                            printParam), 0)));
                        }
                        // 渡りパラメーターprintParam から
                        // KEY：BY_PATIENT_NUMBER1のVALUEを取得し設定する。
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_NUMBER"
                                + l, printParam))
                                && VRBindPathParser.get(
                                        "BY_PATIENT_NUMBER" + l, printParam) != null) {
                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w4", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_NUMBER"
                                                                    + l,
                                                            printParam), 0)));
                        }
                        // 渡りパラメーターprintParam から
                        // KEY：BY_PATIENT_SUM1のVALUEを取得し設定する。
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_SUM"
                                + l, printParam))
                                && VRBindPathParser.get("BY_PATIENT_SUM" + l,
                                        printParam) != null) {
                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w5", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_SUM"
                                                                    + l,
                                                            printParam), 0)));
                        // 渡りパラメーターprintParam から
                        // KEY：PRINT_BY_PATIENT_USE_TAX1のVALUEを取得し設定する。
                            ACChotarouXMLUtilities.setValue(writer, printParam,
                                    "PRINT_BY_PATIENT_USE_TAX" + l,
                                    "byPatient.h" + heightCount + ".w6");
                        }
                        // 渡りパラメーターprintParam から
                        // KEY：BY_PATIENT_TAX1のVALUEを取得し設定する。
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_TAX"
                                + l, printParam))
                                && VRBindPathParser.get("BY_PATIENT_TAX" + l,
                                        printParam) != null) {
                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w7", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_TAX"
                                                                    + l,
                                                            printParam), 0)));
                        }
                        // Replace - end [Masahiko Higuchi]
                    }
                    heightCount++;
                }

            }
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_1
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_1", "dayMark1.h1.w1");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_2
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_2", "dayMark1.h1.w2");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_3
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_3", "dayMark1.h1.w3");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_4
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_4", "dayMark1.h1.w4");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_5
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_5", "dayMark1.h1.w5");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_6
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_6", "dayMark1.h1.w6");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_7
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_7", "dayMark1.h1.w7");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_8
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_8", "dayMark1.h2.w1");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_9
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_9", "dayMark1.h2.w2");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_10
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_10", "dayMark1.h2.w3");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_11
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_11", "dayMark1.h2.w4");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_12
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_12", "dayMark1.h2.w5");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_13
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_13", "dayMark1.h2.w6");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_14
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_14", "dayMark1.h2.w7");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_15
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_15", "dayMark1.h3.w1");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_16
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_16", "dayMark1.h3.w2");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_17
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_17", "dayMark1.h3.w3");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_18
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_18", "dayMark1.h3.w4");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_19
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_19", "dayMark1.h3.w5");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_20
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_20", "dayMark1.h3.w6");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_21
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_21", "dayMark1.h3.w7");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_22
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_22", "dayMark1.h4.w1");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_23
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_23", "dayMark1.h4.w2");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_24
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_24", "dayMark1.h4.w3");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_25
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_25", "dayMark1.h4.w4");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_26
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_26", "dayMark1.h4.w5");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_27
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_27", "dayMark1.h4.w6");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_28
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_28", "dayMark1.h4.w7");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_29
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_29", "dayMark1.h5.w1");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_30
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_30", "dayMark1.h5.w2");
            // 渡りパラメーターprintParam から KEY：PRINT1_PROVIDER_DAY_31
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_31", "dayMark1.h5.w3");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_1
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_1", "dayMark2.h1.w1");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_2
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_2", "dayMark2.h1.w2");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_3
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_3", "dayMark2.h1.w3");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_4
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_4", "dayMark2.h1.w4");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_5
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_5", "dayMark2.h1.w5");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_6
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_6", "dayMark2.h1.w6");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_7
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_7", "dayMark2.h1.w7");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_8
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_8", "dayMark2.h2.w1");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_9
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_9", "dayMark2.h2.w2");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_10
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_10", "dayMark2.h2.w3");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_11
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_11", "dayMark2.h2.w4");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_12
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_12", "dayMark2.h2.w5");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_13
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_13", "dayMark2.h2.w6");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_14
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_14", "dayMark2.h2.w7");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_15
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_15", "dayMark2.h3.w1");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_16
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_16", "dayMark2.h3.w2");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_17
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_17", "dayMark2.h3.w3");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_18
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_18", "dayMark2.h3.w4");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_19
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_19", "dayMark2.h3.w5");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_20
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_20", "dayMark2.h3.w6");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_21
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_21", "dayMark2.h3.w7");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_22
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_22", "dayMark2.h4.w1");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_23
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_23", "dayMark2.h4.w2");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_24
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_24", "dayMark2.h4.w3");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_25
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_25", "dayMark2.h4.w4");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_26
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_26", "dayMark2.h4.w5");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_27
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_27", "dayMark2.h4.w6");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_28
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_28", "dayMark2.h4.w7");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_29
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_29", "dayMark2.h5.w1");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_30
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_30", "dayMark2.h5.w2");
            // 渡りパラメーターprintParam から KEY：PRINT2_PROVIDER_DAY_31
            // のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_31", "dayMark2.h5.w3");
            // 渡りパラメーターprintParam から KEY：BILL_NOTE のVALUEを取得し設定する。
            ACChotarouXMLUtilities.setValue(writer, printParam, "BILL_NOTE",
                    "note.h2.w1");

            // 2枚目の場合は処理印字しない
            if (i == 0) {
                // 値が0以外だった場合

                // 2006/09/26
                // 金額欄表示変更に伴いフォーマッタを追加
                // Replace - begin [Masahiko Higuchi]
                if (ACCastUtilities.toInt(VRBindPathParser.get(
                        "BILL_NO_TAX_BY_INSURER", printParam), 0) != 0) {
                    // 渡りパラメーターprintParam から KEY：BILL_NO_TAX_BY_INSURER
                    // のVALUEを取得し設定する。
                    ACChotarouXMLUtilities.setValue(writer, "Grid5.h2.w2", nf
                            .format(ACCastUtilities.toInt(VRBindPathParser.get(
                                    "BILL_NO_TAX_BY_INSURER", printParam), 0)));
                }
                // 値が0以外だった場合
                if (ACCastUtilities.toInt(VRBindPathParser.get(
                        "BILL_NO_TAX_BY_PATIENT", printParam), 0) != 0) {
                    // 渡りパラメーターprintParam から KEY：BILL_NO_TAX_BY_PATIENT
                    // のVALUEを取得し設定する。
                    ACChotarouXMLUtilities.setValue(writer, "Grid5.h2.w4", nf
                            .format(ACCastUtilities.toInt(VRBindPathParser.get(
                                    "BILL_NO_TAX_BY_PATIENT", printParam), 0)));
                }
                // 値が0以外だった場合
                if (ACCastUtilities.toLong(VRBindPathParser.get(
                        "BILL_IN_TAX_BY_PATIENT", printParam), 0) != 0) {
                    // 渡りパラメーターprintParam から KEY：BILL_IN_TAX_BY_PATIENT
                    // のVALUEを取得し設定する。
                    ACChotarouXMLUtilities.setValue(writer, "Grid5.h3.w4", nf
                            .format(ACCastUtilities.toInt(VRBindPathParser.get(
                                    "BILL_IN_TAX_BY_PATIENT", printParam), 0)));
                }
                // 値が0以外だった場合
                if (ACCastUtilities.toInt(VRBindPathParser.get(
                        "BILL_FULL_TOTAL", printParam), 0) != 0) {
                    // 渡りパラメーターprintParam から KEY：BILL_FULL_TOTAL
                    // のVALUEを取得し設定する。
                    ACChotarouXMLUtilities.setValue(writer, "Grid5.h4.w4", nf
                            .format(ACCastUtilities.toInt(VRBindPathParser.get(
                                    "BILL_FULL_TOTAL", printParam), 0)));
                }
                // Replace - end [Masahiko Higuchi]

            }
            // 最終日付を取得
            int maxDay = ACDateUtilities.getDayOfMonth(ACDateUtilities
                    .toLastDayOfMonth(ACCastUtilities.toDate(printParam
                            .getData("BILL_SPAN_END"))));
            // 最大日付によって表示を変更
            switch (maxDay) {
            case 28:
                // 日付項目クリア
                ACChotarouXMLUtilities.setValue(writer, "days.h5.w1", "");
                ACChotarouXMLUtilities.setValue(writer, "days.h5.w2", "");
                ACChotarouXMLUtilities.setValue(writer, "days.h5.w3", "");

                ACChotarouXMLUtilities.setValue(writer, "dayMark1.h5.w1", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark1.h5.w2", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark1.h5.w3", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark2.h5.w1", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark2.h5.w2", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark2.h5.w3", "");
                break;
            case 29:
                ACChotarouXMLUtilities.setValue(writer, "days.h5.w2", "");
                ACChotarouXMLUtilities.setValue(writer, "days.h5.w3", "");

                ACChotarouXMLUtilities.setValue(writer, "dayMark1.h5.w2", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark1.h5.w3", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark2.h5.w2", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark2.h5.w3", "");
                break;
            case 30:
                ACChotarouXMLUtilities.setValue(writer, "days.h5.w3", "");

                ACChotarouXMLUtilities.setValue(writer, "dayMark1.h5.w3", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark2.h5.w3", "");
                break;
            }

            // ページ数設定
            ACChotarouXMLUtilities.setValue(writer, "page.h1.w3",
                    ACCastUtilities.toString(i + 1));
            ACChotarouXMLUtilities.setValue(writer, printParam, "LAST_PAGE",
                    "page.h1.w1");

            // ページ終了
            writer.endPageEdit();

        }

        // 印刷を実行したならばtrueを返す。
        return true;

    }

    // 内部関数

    /**
     * 「印刷用にデータを変換します。」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void convertCalenderData(VRMap printParam, String key)
            throws Exception {
        // 渡された値を帳票印字用のデータに変換します。
        // 渡されたパラメーターから指定されたKEYのVALUEを取得する。
        // 取得した値が数値であるかチェックする。
        if (VRBindPathParser.get(key, printParam) instanceof Integer) {
            // 数値である場合
            // 内部変数 mark[] を生成する。
            String mark[] = new String[] { "", "" };
            switch (ACCastUtilities
                    .toInt(VRBindPathParser.get(key, printParam))) {
            // 取得した値をチェックする。
            case 0:
                // 値が0だった場合
                // mark[配列1番目]にVALUEとして定数・NO_MARKを設定する。
                mark[0] = NO_MARK;
                break;
            case 1:
                // 値が1だった場合
                // mark[配列1番目]にVALUEとして定数・CIRCLEを設定する。
                mark[0] = CIRCLE;
                break;
            // 値が2だった場合
            case 2:
                // mark[配列1番目]にVALUEとして定数・TRIANGLEを設定する。
                mark[0] = TRIANGLE;
                break;
            case 3:
                // 値が3だった場合
                // mark[配列1番目]にVALUEとして定数・DOUBLE_CIRCLEを設定する。
                mark[0] = DOUBLE_CIRCLE;
                break;
            case 4:
                // 値が4だった場合
                // mark[配列1番目]にVALUEとして定数・TRIANGLEを設定する。
                // mark[配列2番目]にVALUEとして定数・DOUBLE_CIRCLEを設定する。
                mark[0] = TRIANGLE;
                mark[1] = DOUBLE_CIRCLE;
                break;
            case 5:
                // 値が5だった場合
                // mark[配列1番目]にVALUEとして定数・RHOMBUSを設定する。
                mark[0] = RHOMBUS;
                break;
            case 6:
                // 値が6だった場合
                // mark[配列1番目]にVALUEとして定数・TRIANGLEを設定する。
                // mark[配列2番目]にVALUEとして定数・RHOMBUSを設定する。
                mark[0] = TRIANGLE;
                mark[1] = RHOMBUS;
                break;
            }
            // 渡りパラメーター集合に下記のKEY／VALUEで格納する。
            // KEY：PRINT_ + 指定KEY名 VALUE：mark
            VRBindPathParser.set("PRINT1_" + key, printParam, mark[0]);
            VRBindPathParser.set("PRINT2_" + key, printParam, mark[1]);
        }
        // 数値でない場合
        // 処理を行わない。

    }

    /**
     * 「税の内・外を変換します」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void convertTax(VRMap printParam, String key) throws Exception {
        // 税の内・外を変換します
        // 渡されたパラメーターから指定されたKEYのVALUEを取得する。
        // 取得した値が数値であるかチェックする。
        if (printParam.getData(key) instanceof Integer) {
            // 数値である場合
            // 取得した値をチェックする。
            switch (ACCastUtilities.toInt(printParam.getData(key))) {
            case 0:
                // 値が0だった場合
                // 下記のKEY／VALUEを渡りパラメーターprintParamに格納する。
                // KEY：PRINT_ + 指定KEY名 VALUE："内"
                printParam.setData("PRINT_" + key, "内");
                break;
            case 1:
                // 値が1だった場合
                // 下記のKEY／VALUEを渡りパラメーターprintParamに格納する。
                // KEY：PRINT_ + 指定KEY名 VALUE："外"
                printParam.setData("PRINT_" + key, "外");
                break;
            }
        }

    }

    /**
     * 「ページ数計算」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void pageCalc(VRMap printParam) throws Exception {
        // 印刷ページ数計算に関する処理を行います。
        // 渡されたパラメーターから以下の配列の文字列をKEYとしてprintParamよりVALUEを抜き出し空白かどうかチェックする。
        for (int i = 0; i < CALC_INSURER.length; i++) {
            // KEY 定数：CALC_INSURER
            if (!"".equals(printParam.getData(CALC_INSURER[i]))
                    && printParam.getData(CALC_INSURER[i]) != null) {
                // 何らかの文字列が入っていた場合
                // printPramに以下のKEY/VALUEを設定する。
                // KEY：LAST_PAGE VALUE：2
                printParam.setData("LAST_PAGE", new Integer(2));
                return;
            }
        }

        // KEY 定数：CALC_PATIENT_INSURER
        for (int j = 0; j < CALC_PATIENT_INSURER.length; j++) {
            if (!"".equals(printParam.getData(CALC_PATIENT_INSURER[j]))
                    && printParam.getData(CALC_PATIENT_INSURER[j]) != null) {
                printParam.setData("LAST_PAGE", new Integer(2));
                return;
            }
        }
        // 全て空白だった場合
        // printPramに以下のKEY/VALUEを設定する。
        // KEY：LAST_PAGE VALUE：1
        printParam.setData("LAST_PAGE", new Integer(1));

    }

}