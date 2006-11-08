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
 * 作成日: 2006/06/01  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所一覧 (003)
 * プログラム 事業所一覧 (QO003P01)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo003;

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
import java.util.Iterator;

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

/**
 * 事業所一覧(QO003P01) 帳票定義体ファイル名 ： QO003P01.xml
 */
public class QO003P01 {//extends QO003P01Event {
    /**
     * コンストラクタです。
     */
    public QO003P01() {
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

        // 印刷処理
        // ※印刷パラメタをローカル変数に展開
        // 事業所一覧をレコード集合として宣言し、印刷パラメタのキー[PROVIDERS]の値を格納する。
        VRList providerList = new VRArrayList();
        if (VRBindPathParser.has("PROVIDERS", printParam)) {
            providerList = (VRList) VRBindPathParser.get("PROVIDERS",
                    printParam);
            if (providerList.size() < 1) {
                // 印刷不可
                return false;
            }
        } else {
            // 万が一パラメータがこなかった場合
            return false;
        }
        // DBマネージャを宣言し、印刷パラメタのキー[DBM]の値を格納する。
        ACDBManager dbm = (ACDBManager) VRBindPathParser.get("DBM", printParam);
        // ※サービスマスタの取得
        // サービスマスタとしてレコードを宣言し、共通関数で対象年月を指定せずにサービスマスタを取得した結果を格納する。
//        VRMap services = QkanCommon.getMasterService(dbm);
        // ※印刷
        // 印刷処理クラスにフォーマット(QO003P01.xml)を定義する。
        ACChotarouXMLUtilities.addFormat(writer, "QO003P01", "QO003P01.xml");
        // 印刷対象行をあらわす整数カウンタを初期値1で宣言する。
        int nowPrintLineNo = 1;
        // ページ定義を開始したことをあらわすページ開始済みフラグを真偽値で宣言し、falseで初期化する。
        boolean isPrintStart = false;
        // 全ての事業所を印刷するまで以下の処理を繰り返す。
        Iterator it = providerList.iterator();
        while (it.hasNext()) {
            if (nowPrintLineNo <= 1) {
                // 印刷対象行が1以下の場合
                // 印刷処理クラスにページの開始を定義する。
                writer.beginPageEdit("QO003P01");
                // ページ開始済みフラグをtrueにする。
                isPrintStart = true;
                // 現在日時を定義体項目[Date]として印字する。
                ACChotarouXMLUtilities.setValue(writer, "Date", VRDateParser
                        .format(new Date(), "ggge年MM月dd日"));
            }
            // 印刷対象の事業所をあらわすレコードを宣言し、繰り返し処理における現在の処理対象の事業所を格納する。
            VRMap nowPrintProvider = (VRMap) it.next();
            // ＜事業所番号、事業所名、事業所住所＞
            // 以下のキーに対応するレコードの値を印字する。（◇は印刷対象行）
            // キー：PROVIDER_ID 定義体項目：providers.h◇.PROVIDER_ID
            // キー：PROVIDER_NAME 定義体項目：providers.h◇.PROVIDER_NAME
            // キー：PROVIDER_ADDRESS 定義体項目：providers.h◇.PROVIDER_ADDRESS
            ACChotarouXMLUtilities.setValue(writer, nowPrintProvider,
                    "PROVIDER_ID", "providers.h" + nowPrintLineNo
                            + ".PROVIDER_ID");
            ACChotarouXMLUtilities.setValue(writer, nowPrintProvider,
                    "PROVIDER_NAME", "providers.h" + nowPrintLineNo
                            + ".PROVIDER_NAME");
            ACChotarouXMLUtilities.setValue(writer, nowPrintProvider,
                    "PROVIDER_ADDRESS", "providers.h" + nowPrintLineNo
                            + ".PROVIDER_ADDRESS");
            // ＜事業所郵便番号＞
            // 以下のキーの値を共通関数で結合して定義体項目[providers.h◇.PROVIDER_ZIP]に印字する。（◇は印刷対象行）
            // キー：PROVIDER_ZIP_FIRST、PROVIDER_ZIP_SECOND
            ACChotarouXMLUtilities.setValue(writer, "providers.h"
                    + nowPrintLineNo + ".PROVIDER_ZIP", QkanCommon.toZip(
                    VRBindPathParser
                            .get("PROVIDER_ZIP_FIRST", nowPrintProvider),
                    VRBindPathParser.get("PROVIDER_ZIP_SECOND",
                            nowPrintProvider)));
            // ＜事業所電話番号＞
            // 以下のキーの値を共通関数で結合して定義体項目[providers.h◇.PROVIDER_TEL]に印字する。（◇は印刷対象行）
            // キー：PROVIDER_TEL_FIRST、PROVIDER_TEL_SECOND、PROVIDER_TEL_THIRD
            ACChotarouXMLUtilities.setValue(writer, "providers.h"
                    + nowPrintLineNo + ".PROVIDER_TEL", QkanCommon.toTel(
                    VRBindPathParser
                            .get("PROVIDER_TEL_FIRST", nowPrintProvider),
                    VRBindPathParser.get("PROVIDER_TEL_SECOND",
                            nowPrintProvider), VRBindPathParser.get(
                            "PROVIDER_TEL_THIRD", nowPrintProvider)));
            // ＜事業所FAX番号＞
            // 以下のキーの値を共通関数で結合して定義体項目[providers.h◇.PROVIDER_FAX]に印字する。（◇は印刷対象行）
            // キー：PROVIDER_FAX_FIRST、PROVIDER_FAX_SECOND、PROVIDER_FAX_THIRD
            ACChotarouXMLUtilities.setValue(writer, "providers.h"
                    + nowPrintLineNo + ".PROVIDER_FAX", QkanCommon.toTel(
                    VRBindPathParser
                            .get("PROVIDER_FAX_FIRST", nowPrintProvider),
                    VRBindPathParser.get("PROVIDER_FAX_SECOND",
                            nowPrintProvider), VRBindPathParser.get(
                            "PROVIDER_FAX_THIRD", nowPrintProvider)));
            // ＜事業所事業区分＞
            // キー[PROVIDER_JIGYOU_TYPE]の値をフォーマットQkanProviderJigyoTypeFormatで変換する。
            // 変換結果を定義体項目[providers.h◇.PROVIDER_JIGYOU_TYPE]に印字する。（◇は印刷対象行）
            ACChotarouXMLUtilities
                    .setValue(
                            writer,
                            "providers.h" + nowPrintLineNo
                                    + ".PROVIDER_JIGYOU_TYPE",
                            QkanProviderJigyoTypeFormat
                                    .getInstance()
                                    .format(VRBindPathParser
                                                            .get(
                                                                    "PROVIDER_JIGYOU_TYPE",
                                                                    nowPrintProvider)));
            // ＜事業所地域区分＞
            // キー[PROVIDER_AREA_TYPE]の値をフォーマットQkanProviderAreaTypeFormatで変換する。
            // 変換結果を定義体項目[providers.h◇.PROVIDER_AREA_TYPE]に印字する。（◇は印刷対象行）
            ACChotarouXMLUtilities.setValue(writer, "providers.h"
                    + nowPrintLineNo + ".PROVIDER_AREA_TYPE",
                    QkanProviderAreaTypeFormat.getInstance().format(VRBindPathParser.get(
                                    "PROVIDER_AREA_TYPE", nowPrintProvider)));
            // ＜提供サービス＞
            // 共通関数で対象事業所の提供サービスを取得する。
            VRList providerDetail = dbm
                    .executeQuery(getSQL_GET_SERVICE_CALENDAR_NAME(nowPrintProvider));
            if (!providerDetail.isEmpty()) {
                // 提供サービスが1個以上ある場合
                // 提供サービス結合結果をあらわす文字列を宣言する。
                StringBuffer sb = new StringBuffer();
                // 提供サービス結合結果に、サービスマスタをもとに1つめの提供サービスの略称を格納する。
                VRMap map = (VRMap) providerDetail.getData(0);
                sb.append(VRBindPathParser.get("SERVICE_CALENDAR_ABBREVIATION",
                        map));

                // 2つめから5つめまでの提供サービスを対象に以下の処理を繰り返す。
                int end = Math.min(5, providerDetail.size());
                for (int i = 1; i < end; i++) {
                    map = (VRMap) providerDetail.getData(i);
                    // 提供サービス結合結果に、読点「、」を結合する。
                    sb.append("、");
                    // 提供サービス結合結果に、サービスマスタをもとに対象提供サービスの略称を結合する。
                    sb.append(VRBindPathParser.get(
                            "SERVICE_CALENDAR_ABBREVIATION", map));
                }

                if (providerDetail.size() >= 6) {
                    // 提供サービスが6つ以上ある場合
                    // 提供サービス結合結果に、「、他」を結合する。
                    sb.append("、他");
                }
                // 提供サービス結合結果を定義体項目[providers.h◇.PROVIDER_SERVICE]に印字する。（◇は印刷対象行）
                ACChotarouXMLUtilities.setValue(writer, "providers.h"
                        + nowPrintLineNo + ".PROVIDER_SERVICE", sb.toString());
            }
            


            if (nowPrintLineNo < 24) {
                // 印刷対象行が24未満の場合
                // 印刷対象行に1加算する。
                nowPrintLineNo++;
            } else {
                // 印刷対象行が24以上の場合
                // 印刷処理クラスにページの終了を定義する。
                writer.endPageEdit();
                // 印刷対象行を1にする。
                nowPrintLineNo = 1;
                // ページ開始済みフラグをfalseにする。
                isPrintStart = false;
            }
        }
        // ページ開始済みフラグがtrueの場合
        if (isPrintStart) {
            // 印刷処理クラスにページの終了を定義する。
            writer.endPageEdit();
        }
        // TODO 印刷を実行したならばtrueを返す。
        return true;

    }

    /**
     * 「サービスカレンダー名を取得する。」のためのSQLを返します。
     * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
     * @throws Exception 処理例外
     * @return SQL文
     */
    public String getSQL_GET_SERVICE_CALENDAR_NAME(VRMap sqlParam) throws Exception{
      StringBuffer sb = new StringBuffer();
      Object[] inValues;
      Stack conditionStack = new Stack();
      boolean firstCondition = true;
      Object obj;

      sb.append("SELECT");

      sb.append(" DISTINCT");

      sb.append(" M_SERVICE.SERVICE_CALENDAR_ABBREVIATION");

      sb.append(" FROM");

      sb.append(" PROVIDER_SERVICE");

      sb.append(",M_SERVICE");

      sb.append(" WHERE");

      sb.append("(");

      sb.append(" PROVIDER_SERVICE.PROVIDER_ID");

      sb.append(" =");

      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

      sb.append(")");

      sb.append("AND");

      sb.append("(");

      sb.append(" PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

      sb.append(" =");

      sb.append(" M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

      sb.append(")");

      sb.append(" ORDER BY");

      sb.append(" SERVICE_SORT");

      sb.append(" ASC");

      return sb.toString();
    }
}
