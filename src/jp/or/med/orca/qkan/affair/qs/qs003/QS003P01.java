
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
 * 作成日: 2005/12/12  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス 利用票 (003)
 * プログラム 利用票 (QS00301)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs003;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
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

/**
 * 利用票(QS00301) 
 * 帳票定義体ファイル名 ： 
 */
public class QS003P01 extends QS003P01Event {
  /**
   * コンストラクタです。
   */
  public QS003P01(){
  }

  /**
   * 印刷します。
   * @param writer 印刷管理クラス
   * @param printParam 印刷パラメタ
   * @throws Exception 処理例外
   */
  public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
    //呼び出しもとで行なう処理＞＞＞
    //ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
    //pd.addFormat("mainFormat", ACFrame.getInstance().getExeFolderPath() + ACConstants.FILE_SEPARATOR + "format" + ACConstants.FILE_SEPARATOR + "利用票");
    //pd.beginPrintEdit();
    //＜＜＜呼び出しもとで行なう処理
    //TODO ページ開始[beginPageEdit("mainFormat")]も忘れずに。
      // ※予定/実績判定
    // 　渡りパラメータの KEY : PROCESS_TYPE の VALUE をチェックする。
    // 　　PROCESS_TYPE_PLANの場合
    // 　　　以下、「サービス予定」の利用表印刷として処理する。
    // 　　PROCESS_TYPE_RESULTの場合
    // 　　　以下、「サービス実績」の利用表印刷として処理する。
    // ※作成年月日
    // 　表外の作成年月日として、渡りパラメータの KEY : CREATE_DATE_OUTER を設定する。
    // 　　年
    //     setValue(createDateOuterYear, (年));

    // 　　月
    //     setValue(createDateOuterMonth, (月));

    // 　　日
    //     setValue(createDateOuterDay, (日));

    // 　表内の作成年月日として、渡りパラメータの KEY : CREATE_DATE_INNER を設定する。
    // 　　年
    //     setValue(createDateInnerYear, (年));

    // 　　月
    //     setValue(createDateInnerMonth, (月));

    // 　　日
    //     setValue(createDateInnerDay, (日));

    // 　帳票種類判別のため、渡りパラメータの KEY : CHOHYO_TYPE の VALUE をチェックする。
    // 　　FOR_PATIENTの場合
    // 　　　帳票種類として「居宅介護支援事業者→利用者」を設定する。
    //     setValue(chohyoType.w1.h1, "居宅介護支援事業者→利用者");

    // 　　FOR_PROVIDERの場合
    // 　　　帳票種類として「居宅介護支援事業者(控)」を設定する。
    //     setValue(chohyoType.w1.h1, "居宅介護支援事業者(控)");

    // ※支援事業者情報
    // 　事業者の情報を、渡りパラメータ KEY : PROVIDER_ID の VALUE を元に取得する。
    // 　・居宅介護支援事業者名
    // 　　居宅介護支援事業者名を設定する。
    //     setValue(upper.w23.h1, (事業者名));

    // 　・事業者電話番号 / FAX番号
    // 　　事業者電話番号 / FAX番号格納用文字列を生成する。
    //     setValue(upper.w23.h2, (電話番号 / FAX番号));

    // 　　電話番号が設定されている場合、格納用文字列に電話番号(文字列)を追加する。
    // 　　FAX番号が設定されている場合、格納用文字列に" FAX:" + FAX番号(文字列)を設定する。
    // 　　事業者電話番号 / FAX番号を設定する。
    // 　・担当者名
    // 　　担当者名を設定する。
    ACChotarouXMLUtilities.getInstance().setValue(writer, printParam, "PERSON_IN_CHARGE", "upper.w23.h3");
    // ※利用者関連情報の設定
    // 　対象の利用者の情報を、渡りパラメータの KEY : PATIENT_ID の VALUE を元に取得する。
    // 　※保険者情報
    // 　　・保険者番号
    // 　　　保険者番号をseparatorに設定する。ただし、番号は右詰とする。
    //     setValue(insurerNo, (保険者番号));

    // 　　・保険者名
    // 　　　保険者名を設定する。
    //     setValue(upper.w15.h1, (保険者名));

    // 　※被保険者(利用者)情報
    // 　　・認定済/申請中
    // 　　　要介護申請の状態をチェックする。
    // 　　　　「認定済」の場合
    // 　　　　　「申請中」のシェイプを非表示にする。
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "requesting");
    // 　　　　「申請中」の場合
    // 　　　　　「認定済」のシェイプを非表示にする。
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "authorized");
    // 　　・被保険者番号
    // 　　　被保険者番号をseparatorに設定する。ただし、右詰とする。
    //     setValue(insuredNo, (被保険者番号));

    // 　　・被保険者フリガナ
    // 　　　被保険者フリガナを設定する。ただし、フリガナは半角カナとする。
    //     setValue(upper.w15.h4, (フリガナ));

    // 　　・被保険者氏名
    // 　　　被保険者氏名を設定する。
    //     setValue(upper.w15.h5, (被保険者氏名));

    // 　　・届出年月日
    // 　　　渡りパラメータの KEY : NOTIFICATION_DATE の VALUE を取得する。
    // 　　　年号(文字列) 年
    //     setValue(notificationYear, (年号 年));

    // 　　　月
    //     setValue(notificationMonth, (月));

    // 　　　日
    //     setValue(notificationDay, (日));

    // 　　・利用者生年月日
    // 　　　年号(文字列)
    //     setValue(patientBirthDayEra, (年号));

    // 　　　年
    //     setValue(patientBirthDayYear, (年));

    // 　　　月
    //     setValue(patientBirthDayMonth, (月));

    // 　　　日
    //     setValue(patientBirthDayDay, (日));

    // 　　・利用者性別
    // 　　　性別(文字列)
    //     setValue(upper.w12.h6, (性別));

    // 　※利用者・要介護度情報
    // 　　※要介護状態区分
    // 　　　要介護状態区分を設定する。(要介護度を表す文字列を設定する)
    //     setValue(upper.w15.h6, (要介護状態区分));

    // 　　※変更後要介護状態区分
    // 　　　月内で要介護度が変更された場合のみ行う。
    // 　　　　変更後の要介護状態区分をチェックし、該当するもの以外のシェイプを非表示にする。
    // 　　　　　要支援
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "yokaigodo11");
    // 　　　　　要介護１
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "yokaigodo21");
    // 　　　　　要介護２
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "yokaigodo22");
    // 　　　　　要介護３
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "yokaigodo23");
    // 　　　　　要介護４
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "yokaigodo24");
    // 　　　　　要介護５
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "yokaigodo25");
    // 　　※要介護状態区分変更日
    // 　　　要介護状態区分の変更日を設定する。
    // 　　　　年号 年
    //     setValue(yokaigodoChangeYear, (年号 年));

    // 　　　　月
    //     setValue(yokaigodoChangeMonth, (月));

    // 　　　　日
    //     setValue(yokaigodoChangeDate, (日));

    // 　　※区分支給限度基準額
    // 　　　区分支給限度基準額を設定する。ただし、桁区切りの「,」を入れること。
    ACChotarouXMLUtilities.getInstance().setValue(writer, printParam, "LIMIT_AMOUNT_CONTENT", "limitAmountContent");
    // 　　※限度額適用期間(開始)
    // 　　　限度額適用期間(開始)を設定する。
    // 　　　　年号 年
    //     setValue(applicationPeriodBeginYear, 年号 年);

    // 　　　　月
    //     setValue(applicationPeriodBeginMonth, 月);

    // 　　※限度額適用期間(終了)
    // 　　　限度額適用期間(終了)を設定する。
    // 　　　　年号 年
    //     setValue(applicationPeriodEndYear, 年号 年);

    // 　　　　月
    //     setValue(applicationPeriodEndMonth, 月);

    // ※前日までの短期入所利用回数
    // 　「前日までの短期入所利用回数」を設定する。
    // 　対象年月として、渡りパラメータの KEY : TARGET_DATE の VALUE を取得する。
    ACChotarouXMLUtilities.getInstance().setValue(writer, printParam, "SHORT_STAR_USE_DAY", "shortStayUseDay");
    // ※表の曜日
    // 　月初から月の最終日までの曜日を設定する。
    //     setValue((lowerValue.xN.y), (日数));

    // 　日曜日以外の○(シェイプ)を非表示にする。
    //     addAttribute(sundayN);

    // ※提供情報
    // 　表内のデータ格納用のレコード集合 serviceDataを生成する。
    VRList serviceData = null;
    // 　serviceDataに、渡りパラメータprintParamの KEY : SERVICE_DATA　の VALUE を格納する。
    // 　serviceDataの件数分ループする。
    // 　　・提供時間帯
    // 　　　提供時間帯(開始)を設定する。
    //     setValue((lowerHeader.time.row1Upper), (提供時間帯(開始)));

    // 　　　提供時間帯(終了)を設定する。
    //     setValue((lowerHeader.time.row1Lower), (提供時間帯(終了)));

    // 　　・サービス内容
    // 　　　サービス内容を設定する。
    //     setValue((lowerHeader.service.row1Upper), (サービス内容));

    // 　　・サービス事業者事業者名
    // 　　　サービス事業者事業者名を設定する。
    //     setValue((lowerHeader.provider.row1Upper), (サービス事業者事業者名));

    // 　　月初から月の最終日までループする。
    // 　　　・月間サービス計画及び実績の記録
    // 　　　　予定の場合
    // 　　　　　該当サービスの該当日の提供回数を設定する。
    //     setValue((lowerValue.x1.y1), (回数));

    // 　　　　実績の場合
    // 　　　　　該当サービスの該当日の提供回数を設定する。
    //     setValue((lowerValue.x1.j1), (回数));

    // 　　　・自費(△)
    // 　　　　予定の場合
    // 　　　　　該当日の該当サービスが自費の場合、「△」をつける。
    //     setValue((lowerValueTriangle.x1.y1), "△");

    // 　　　　実績の場合
    // 　　　　　該当日の該当サービスが自費の場合、「△」をつける。
    //     setValue((lowerValueTriangle.x1.j1), "△");

    // 　　・合計回数
    // 　　　予定の場合
    // 　　　　該当サービスの提供回数合計を設定する。
    //     setValue((lowerValueTriangle.x1.y1), (合計));

    // 　　　実績の場合
    // 　　　　該当サービスの提供回数合計を設定する。
    //     setValue((lowerValueTriangle.x1.j1), (合計));


    //TODO ページ終了[endPageEdit()]も忘れずに。
    //呼び出しもとで行なう処理＞＞＞
    //writer.endPrintEdit();
    //ACCommon.getInstance().openPDF(writer);
    //＜＜＜呼び出しもとで行なう処理
    //TODO 印刷を実行したならばtrueを返す。
    return true;
  }

}
