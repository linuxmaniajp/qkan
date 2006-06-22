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
 * 作成日: 2006/02/23  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 週間サービス計画表 (QS001P01)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

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
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;

/**
 * 週間サービス計画表(QS001P01) 帳票定義体ファイル名 ： QS001P01.xml
 */
public class QS001P01 extends QS001P01Event {
    /**
     * コンストラクタです。
     */
    public QS001P01() {
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
        // 必要であれば帳票IDを書き換えること。
        ACChotarouXMLUtilities.addFormat(writer, "QS001P01", "QS001P01.xml");
        // ページ開始
        writer.beginPageEdit("QS001P01");
        // ※利用者氏名の設定
        // 利用者氏名を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_NAME",
                "patient.h1.patientName");
        // ※利用者番号の設定
        // 利用者番号を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_CODE",
                "patient.h1.patientID");
        // ※作成年月日の設定
        // 渡りパラメータの KEY : CREATE_DATE の VALUE(日付) を取得する。
        Object obj = printParam.get("CREATE_DATE");
        // 作成年月日の年を設定する。
        // setValue(createYear, (作成年月日の年));

        // 作成年月日の月を設定する。
        // setValue(createMonth, (作成年月日の月));

        // 作成年月日の日を設定する。
        // setValue(createDate, (作成年月日の日));
        if ((!ACTextUtilities.isNullText(obj)) && (obj instanceof Date)) {
            ACChotarouXMLUtilities.setValue(writer, "createDate", "作成年月日： "
                    + ACConstants.FORMAT_FULL_ERA_YMD.format(obj));
        }

        // ※対象年月の設定
        // 渡りパラメータの KEY : TARGET_DATE の VALUE(日付) を取得する。
        obj = printParam.get("TARGET_DATE");
        // 対象年月日の年を設定する。
        // setValue(targetYear, (対象年月の年));

        // 対象年月日の月を設定する。
        // setValue(targetMonth, (対象年月の月));
        // 対象年月日の日を設定する。
        ACChotarouXMLUtilities.setValue(writer, "targetDate",
                ACConstants.FORMAT_FULL_ERA_YM.format(obj));

        obj = printParam.get("M_SERVICE");
        Map hashedServiceName;
        if (obj instanceof Map) {
            hashedServiceName = (Map) obj;
        } else {
            hashedServiceName = new HashMap();
        }

        obj = printParam.get("WEEKLY_SERVICE");
        if (obj instanceof List) {
            // ※週単位のサービス設定の準備
            String[][] serviceNameTable = new String[8][48];
            int[][] serviceCountTable = new int[8][48];
            List list = (List) obj;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Map service = (Map) it.next();
                // 渡りパラメータの KEY : WEEKLY_SERVICE の VALUE(レコード配列)
                // を取得し、レコード配列weeklyServiceArrayに格納する。
                // グリッド上の線を表す数値配列 lineMatrix (384 = 48 × 8)を生成し、0で初期化する。
                // グリッド上の文字を表す文字列配列 captionMatrix (384 = 48 ×
                // 8)を生成し、""(文字なし)で初期化する。
                // weeklyServiceArrayの件数分ループする。
                // サービスが月曜日～日曜日の間のサービスの場合
                // レコードweeklyServiceMapにweeklyServiceArrayのn番目のレコードを格納する。
                // 日付型変数startTimeにweeklyServiceMapの開始時間を格納する。
                // 数値型変数startTimeIndexにstartTimeを日曜日4:00を0とした30分単位の値を設定する。
                // 日単位のインデックス格納用の数値変数 daylyIndex を生成し、開始時間のインデックスを格納する。
                // convertToDaylyIndex((開始時間));

                // startTimeIndex = 曜日 * 48 + idx
                // 日単位のインデックス格納用の数値変数 daylyIndex に、終了時間のインデックスを格納する。
                // convertToDaylyIndex((終了時間));

                // endTimeIndex = 曜日 * 48 + idx - 1
                // サービスが「主な日常生活上の活動」の場合
                // レコードweeklyServiceMapにweeklyServiceArrayのn番目のレコードを格納する。
                // 日付型変数startTimeにweeklyServiceMapの開始時間を格納する。
                // 数値型変数startTimeIndexにstartTimeを日曜日4:00を0とした30分単位の値を設定する。
                // 日単位のインデックス格納用の数値変数 daylyIndex を生成し、開始時間のインデックスを格納する。
                // convertToDaylyIndex((開始時間));

                // startTimeIndex = 7 * 48 + idx
                // 日単位のインデックス格納用の数値変数 daylyIndex に、終了時間のインデックスを格納する。
                // convertToDaylyIndex((終了時間));

                // endTimeIndex = 7 * 48 + idx - 1
                // startTimeIndex から endTimeIndexまでループする。
                // lineMatrix( i )の値を1増やす。
                // captionMatrix( i )をチェックする。
                // 空白の場合
                // captionMatrix( i )にサービス略称を設定する。
                // 空白でない場合
                // captionMatrix( i + 1 )にサービス略称を設定する。ただし、i + 1も空白でない場合は i +
                // 2に、…というふうに、空いている
                // ところにサービス略称を格納する。

                // サービス名称
                String serviceName;
                obj = hashedServiceName.get(service
                        .get("SYSTEM_SERVICE_KIND_DETAIL"));
                if (obj instanceof Map) {
                    serviceName = ACCastUtilities.toString(((Map) obj)
                            .get("SERVICE_CALENDAR_ABBREVIATION"));
                } else {
                    serviceName = "？";
                }

                // 開始・終了時刻
                Date begin = ACCastUtilities.toDate(service.get("3"), null);
                Date end = ACCastUtilities.toDate(service.get("4"), null);
                if (begin == null) {
                    // 開始時刻不詳は0時扱い
                    begin = ACDateUtilities.createTime(0, 0);
                }
                if (end == null) {
                    end = ACDateUtilities.addMinute(begin, 1);
                }
                // 曜日
                int wday;
                if (CareServiceCommon.isDailyAction(service)) {
                    // 主な日常生活上の活動
                    wday = 7;
                } else {
                    wday = ACCastUtilities.toInt(service.get("WEEK_DAY"), 0);
                    if ((wday == QkanConstants.SERVICE_WEEK_DAY_SUNDAY_AM
                            .intValue())
                            || (wday == QkanConstants.SERVICE_WEEK_DAY_SUNDAY_PM
                                    .intValue())) {
                        wday = 0;
                    } else if ((wday == QkanConstants.SERVICE_WEEK_DAY_MONDAY_AM
                            .intValue())
                            || (wday == QkanConstants.SERVICE_WEEK_DAY_MONDAY_PM
                                    .intValue())) {
                        wday = 1;
                    } else if ((wday == QkanConstants.SERVICE_WEEK_DAY_TUESDAY_AM
                            .intValue())
                            || (wday == QkanConstants.SERVICE_WEEK_DAY_TUESDAY_PM
                                    .intValue())) {
                        wday = 2;
                    } else if ((wday == QkanConstants.SERVICE_WEEK_DAY_WEDNESDAY_AM
                            .intValue())
                            || (wday == QkanConstants.SERVICE_WEEK_DAY_WEDNESDAY_PM
                                    .intValue())) {
                        wday = 3;
                    } else if ((wday == QkanConstants.SERVICE_WEEK_DAY_THURSDAY_AM
                            .intValue())
                            || (wday == QkanConstants.SERVICE_WEEK_DAY_THURSDAY_PM
                                    .intValue())) {
                        wday = 4;
                    } else if ((wday == QkanConstants.SERVICE_WEEK_DAY_FRIDAY_AM
                            .intValue())
                            || (wday == QkanConstants.SERVICE_WEEK_DAY_FRIDAY_PM
                                    .intValue())) {
                        wday = 5;
                    } else if ((wday == QkanConstants.SERVICE_WEEK_DAY_SATURDAY_AM
                            .intValue())
                            || (wday == QkanConstants.SERVICE_WEEK_DAY_SATURDAY_PM
                                    .intValue())) {
                        wday = 6;
                    } else {
                        wday = 7;
                    }
                }

                int beginRow = ACDateUtilities.getHourOfDay(begin) * 2
                        + ACDateUtilities.getMinute(begin) / 30;
                int endMinute = ACDateUtilities.getMinute(end);
                int endRow = ACDateUtilities.getHourOfDay(end) * 2
                        + endMinute / 30;
                if(endMinute%30==0){
                    endRow--;
                }

                // サービス提供時間帯の加算
                if (beginRow <= endRow) {
                    for (int i = beginRow; i <= endRow; i++) {
                        serviceCountTable[wday][i]++;
                    }
                } else {
                    // 0時またぎ
                    for (int i = beginRow; i <= 47; i++) {
                        serviceCountTable[wday][i]++;
                    }
                    for (int i = 0; i <= endRow; i++) {
                        serviceCountTable[wday][i]++;
                    }
                }

                String name = serviceNameTable[wday][beginRow];
                if (name == null) {
                    // この時間帯最初のサービス名
                    name = serviceName;
                } else if (name.indexOf(serviceName) < 0) {
                    // この時間帯では新規なサービス名
                    name += "," + serviceName;
                }
                serviceNameTable[wday][beginRow] = name;
            }
            // ※週単位のサービスの設定
            // 週間表の列を表す数値変数 col を定義する。
            // 週間表の行を表す数値変数 row を定義する。
            // 0 から 383 までループする。(カウンタを i とする。383 = 48 × 8 - 1)
            // グリッド上の位置を特定するため、下記の計算を行う。
            // col = i % 48
            // row = i / 48
            // captionMatrix( i )の値をチェックする。ただし、(col)、(row)は下記の文字列とする。
            // (col) : w + colの値
            // (row) : h + rowの値
            // 空白の場合
            // 何もしない。
            // 空白でない場合
            // グリッド上のセルweek.(col).(row)にcaptionMatrix( i )の文字列を設定する。
            // setValue(week.(col).(row), captionMatrix(i));

            // lineMatrix( i )の値に応じて、編集セルの背景色を描画する。ただし、(col)、(row)は下記の文字列とする。
            // (col) : l + colの値
            // (row) : h + rowの値
            // 0の場合
            // 背景色は描画しない。
            // 1の場合
            // 背景色は#ccccccとする。
            // 2の場合
            // 背景色は#999999とする。
            // 3以上の場合
            // 背景色は#666666とする。

            int colEnd = serviceNameTable.length;
            if (colEnd > 0) {
                final String oneColor = "#CCCCCC";
                final String twoColor = "#999999";
                final String manyColor = "#666666";

                int rowEnd = serviceNameTable[0].length;
                for (int col = 0; col < colEnd; col++) {
                    for (int row = 0; row < rowEnd; row++) {
                        if (!ACTextUtilities
                                .isNullText(serviceNameTable[col][row])) {
                            // サービス名が空でない場合
                            ACChotarouXMLUtilities.setValue(writer, "week.h"
                                    + row + ".w" + col,
                                    serviceNameTable[col][row]);
                        }
                        String fillColor;
                        int count = serviceCountTable[col][row];
                        if (count == 1) {
                            // 1の場合
                            // 背景色は#ccccccとする。
                            fillColor = oneColor;
                        } else if (count == 2) {
                            // 2の場合
                            // 背景色は#999999とする。
                            fillColor = twoColor;
                        } else if (count > 2) {
                            // 3以上の場合
                            // 背景色は#666666とする。
                            fillColor = manyColor;
                        } else {
                            continue;
                        }
                        ACChotarouXMLUtilities.setFillColor(writer, "week.h"
                                + row + ".l" + col, fillColor);
                    }
                }
            }
        }

        // ※週単位以外のサービスの設定
        obj = printParam.get("NON_WEEKLY_SERVICE");
        if (obj instanceof List) {
            // 渡りパラメータの KEY : NON_WEEKLY_SERVICE の VALUE(レコード配列)
            // を取得し、レコード配列nonWeeklyServiceArrayに格納する。
            // nonWeeklyServiceArrayの件数分ループする。
            // 下記フォーマットの文字列を生成する。
            // ◎内容<略称> 開始日：<開始日> 終了日：<終了日>
            // <略称>はサービスの略称
            // <開始日>はサービスの開始日(「第○何曜日」や「月初」など)
            // <終了日>はサービスの開始日(「第○何曜日」や「末迄」など)
            // 生成した文字列を「 」(スペース)で連結する。
            // 連結した文字列を表示欄に設定する。
            // setValue(nonWeek.w2.h1, (連結した文字列));
            StringBuffer freedays = new StringBuffer();
            List list = (List) obj;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Map service = (Map) it.next();
                // サービス名称
                String serviceName;
                obj = hashedServiceName.get(service
                        .get("SYSTEM_SERVICE_KIND_DETAIL"));
                if (obj instanceof Map) {
                    serviceName = ACCastUtilities.toString(((Map) obj)
                            .get("SERVICE_CALENDAR_ABBREVIATION"));
                } else {
                    serviceName = "？";
                }

                if (freedays.length() > 0) {
                    //2個目以上
                    freedays.append("　");
                }
                freedays.append("◎内容：");
                freedays.append(serviceName);
                //開始日
                freedays.append(" 開始日：");
                freedays.append(QkanNonWeeklyServiceBeginFormat.getInstance().format(service
                        .get("WEEK_DAY")));
                //期間
                freedays.append(" 期間：");
                freedays.append(QkanNonWeeklyServiceSpanFormat.getInstance().format(service
                        .get(QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN)));
            }

            ACChotarouXMLUtilities.setValue(writer, "nonWeek.h1.w2", freedays
                    .toString());
        }

        // ページ終了
        writer.endPageEdit();
        //  印刷を実行したならばtrueを返す。
        return true;
    }

}
