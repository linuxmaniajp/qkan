
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
 * 作成日: 2005/12/15  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス 利用票別表 (003)
 * プログラム 利用票別表 (QS00302)
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
 * 利用票別表(QS00302) 
 * 帳票定義体ファイル名 ： QS00302.xml
 */
public class QS003P02 extends QS003P02Event {
  /**
   * コンストラクタです。
   */
  public QS003P02(){
  }

  /**
   * 帳票を生成します。
   * @param writer 印刷管理クラス
   * @param printParam 印刷パラメタ
   * @throws Exception 処理例外
   */
  public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
    //TODO 帳票IDを必要に応じて"mainFormat"から適切なものに書き換えること。
    ACChotarouXMLUtilities.getInstance().addFormat(writer, "mainFormat", "QS00302.xml");
    //ページ開始
    writer.beginPageEdit("mainFormat");
      // ※作成年月日
    // 　作成年月日として、渡りパラメータの KEY : CREATE_DATE_OUTER の VALUE を設定する。
    // 　　年
    //     setValue(createDateOuterYear, (年));

    // 　　月
    //     setValue(createDateOuterMonth, (月));

    // 　　日
    //     setValue(createDateOuterDay, (日));

    // ※利用者情報
    // 　渡りパラメータの KEY : PATIENT_ID の VALUE を元に、利用者情報を取得する。
    // 　利用者の姓・名より、被保険者氏名を取得する。
    //     toFullName((姓), (名));

    // 　利用者氏名を設定する。
    //     setValue(insured.insuredName.h1, (被保険者氏名));

    // 　被保険者番号を設定する。
    //     setValue(insured.insuredID.h1, INSURED_ID);

    // ※対象年月
    // 　対象年月として、渡りパラメータの KEY : TARGET_DATE の VALUE を設定する。
    // 　　年
    //     setValue(targetDateYear, (年));

    // 　　月
    //     setValue(targetDateMonth, (月));

    // ※区分支給限度管理・利用者負担計算
    // 　※集計作業
    // 　　表内データ格納用のレコード集合 serviceData を生成する。
    VRList serviceData = new VRArrayList();
    // 　　serviceDataに、渡りパラメータの KEY : SERVICE_DATA の VALUE を設定する。
    // 　　表内データの集計処理を行う。
    tabulation(serviceData, getPrintList(), getFooterMap());

    // 　※表内情報の設定（printListの値を設定)
    // 　　データの件数分ループする。
    // 　　　※事業所名
    //     setValue(main.x1.y1, PROVIDER_NAME);

    // 　　　※事業所番号
    //     setValue(main.x2.y1, PROVIDER_ID);

    // 　　　※サービス内容/種類
    //     setValue(main.x3.y1, SERVICE_NAME);

    // 　　　※サービスコード
    //     setValue(main.x4.y1, SERVICE_CODE);

    // 　　　※単位
    //     setValue(main.x5.y1, UNIT);

    // 　　　※割引後(率%)
    //     setValue(main.x6.y1, REDUCTION_RATE);

    // 　　　※割引後(単位数)
    //     setValue(main.x7.y1, REDUCTION_UNIT);

    // 　　　※回数
    //     setValue(main.x8.y1, COUNT);

    // 　　　※サービス単位/金額
    //     setValue(main.x9.y1, SERVICE_UNIT_COST);

    // 　　　※区分支給限度基準を超える単位数
    //     setValue(main.x12.y1, KUBUN_LIMIT_OVER);

    // 　　　※区分支給限度基準内単位数
    //     setValue(main.x13.y1, KUBUN_LIMIT_UNDER);

    // 　　　※単位数単価
    //     setValue(main.x14.y1, YEN_PER_UNIT);

    // 　　　※費用総額(保険対象分)
    //     setValue(main.x15.y1, INSURANCE_FEE);

    // 　　　※給付率(%)
    //     setValue(main.x16.y1, BENEFIT_RATE);

    // 　　　※保険給付額
    //     setValue(main.x17.y1, BENEFIT);

    // 　　　※利用者負担(保険対象分)
    //     setValue(main.x18.y1, INSURED_INSURANCE_COST);

    // 　　　※利用者負担(全額負担分)
    //     setValue(main.x19.y1, INSURED_TOTAL_COST);

    // 　※フッターの設定(footerMapの値を設定)
    // 　　※区分支給限度基準額(単位)
    //     setValue(main.x5.total, UNIT_LIMIT);

    // 　　※合計(サービス単位/金額)
    //     setValue(main.x9.total, SERVICE_UNIT_COST);

    // 　　※合計(区分支給限度基準を超える単位数)
    //     setValue(main.x12.total, KUBUN_LIMIT_OVER);

    // 　　※合計(区分支給限度基準内単位数)
    //     setValue(main.x13.total, KUBUN_LIMIT_UNDER);

    // 　　※合計(費用総額(保険対象分))
    //     setValue(main.x15.total, INSURANCE_FEE);

    // 　　※合計(保険給付額)
    //     setValue(main.x17.total, BENEFIT);

    // 　　※合計(利用者負担(保険対象分))
    //     setValue(main.x18.total, INSURED_INSURANCE_COST);

    // 　　※合計(利用者負担(全額負担分))
    //     setValue(main.x19.total, INSURED_TOTAL_COST);

    // ※要介護認定期間中の短期入所利用日数(渡りパラメータの値を設定)
    // 　※前月までの利用日数
    //     setValue(shortStay.pastMonth.h2, SHORT_STAY_PAST_MONTH);

    // 　※当月の計画利用日数
    //     setValue(shortStay.thisMonth.h2, SHORT_STAY_THIS_MONTH);

    // 　※累積利用日数
    //     setValue(shortStay.totalDays.h2, SHORT_STAY_TOTAL_DAYS);


    //ページ終了
    writer.endPageEdit();
    //TODO 印刷を実行したならばtrueを返す。
    return true;
  }

  //内部関数

  /**
   * 「表内データ集計関数」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public VRList tabulation(VRList serviceData, VRList printList, VRMap footerMap) throws Exception{
    // ■集計クラスから送られてきた集計後データを印刷用に集計
    // ※内部変数定義
    // 　ループ中、1つ前に処理したレコード。
    VRMap recordOld = new VRHashMap();
    // 　ループ中、今回処理するデータ。
    VRMap recordNow = new VRHashMap();
    // 　小計値を蓄積するためのレコード。
    VRMap subTotal = new VRHashMap();
    // 　提供票別表で、対象の事業所以外の事業所のレコードの値を蓄積するためのレコード。
    VRMap anotherProvider = new VRHashMap();
    // 　限度管理対象外のレコード情報を蓄積するためのレコード集合。
    VRList excludeLimit = new VRArrayList();
    // 　サービスマスタ格納用。
    VRList masterService = new VRArrayList();
    // ※サービスマスタ取得
    // 　masterServiceに、システムから取得したサービスマスタを設定する。
//    QkanSystemInformation.getInstance().getMasterService();
    // ※集計準備
    // 　小計用レコード subTotal を初期化する。
    initializeRecord(subTotal);

    // 　過去レコード recordOld に元レコード集合 serviceDataの最初のレコードを上書する。
    // ※集計処理
    // 　元レコード集合 serviceData の件数分ループする。
    // 　　現レコード recordNow に元レコード集合 serivceData のN番目のレコードを上書する。
    // 　　サービスが管理対象内かチェックするため、現レコード recordNow のKEY : LIMIT_AMOUNT_OBJECT の VALUE をチェックする。
    // 　　　1(対象内)の場合
    // 　　　　現レコード recordNow と過去レコード recordOld の KEY : PROVIDER_ID の VALUE を比較する。
    // 　　　　　異なる場合
    // 　　　　　　小計清算処理を行う。
    addSubTotalToPrintList(getPrintList(), getFooterMap(), subTotal, recordNow);

    // 　　　　　　小計初期値設定処理を行う。
    setInitValueToSubTotal(subTotal, recordNow, masterService);

    // 　　　　　同じ場合
    // 　　　　　　現レコード recordNow と過去レコード recordOld の KEY : SERVICE_CODE_KIND の VALUE を比較する。
    // 　　　　　　　異なる場合
    // 　　　　　　　　小計清算処理を行う。
    addSubTotalToPrintList(getPrintList(), getFooterMap(), subTotal, recordNow);

    // 　　　　　　　　小計初期値設定処理を行う。
    setInitValueToSubTotal(subTotal, recordNow, masterService);

    // 　　　　　小計加算処理を行う。
    addRecordValueToSubTotal(subTotal, recordNow);

    // 　　　　　印刷用レコード集合 printList に現レコード recordNow を追加する。(パターンA)
    addRecordToPrintListPatternA(getPrintList(), recordNow);

    // 　　　2(対象外)の場合
    // 　　　　対象外用レコード集合 excludeLimit に現レコード recordNow を追加する。
    // 　　過去レコード recordOld に現レコード recordNow を上書する。
    // 小計清算処理を行う。
    addSubTotalToPrintList(getPrintList(), getFooterMap(), subTotal, recordNow);

    // 印刷用レコード集合 printList に対象外レコード集合 excludeList を追加。(パターンE)
    addRecordToPrintListPatternE(getPrintList(), excludeLimit);

    // フッターレコード footerMap に 対象外レコード集合 excludeList を加算する。
    addExcludeValueToFooter(getFooterMap(), excludeLimit);

return null;
  }

  /**
   * 「レコード初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initializeRecord(VRMap rec) throws Exception{
    // ■レコード初期化
    // 　recの KEY / VALUE を全てremoveする。
    // 　recに下記の値を設定する。
    // 　　KEY : PROVIDER_NAME          , VALUE : ""
    // 　　KEY : PROVIDER_ID            , VALUE : ""
    // 　　KEY : SERVICE_NAME           , VALUE : ""
    // 　　KEY : SERVICE_CODE           , VALUE : ""
    // 　　KEY : UNIT                   , VALUE : 0
    // 　　KEY : REDUCTION_RATE         , VALUE : 0
    // 　　KEY : REDUCTION_UNIT         , VALUE : 0
    // 　　KEY : COUNT                  , VALUE : 0
    // 　　KEY : SERVICE_UNIT_COST      , VALUE : 0
    // 　　KEY : KUBUN_LIMIT_OVER       , VALUE : 0
    // 　　KEY : KUBUN_LIMIT_UNDER      , VALUE : 0
    // 　　KEY : YEN_PER_UNIT           , VALUE : 0
    // 　　KEY : INSURANCE_FEE          , VALUE : 0
    // 　　KEY : BENEFIT_RATE           , VALUE : 0
    // 　　KEY : BENEFIT                , VALUE : 0
    // 　　KEY : INSURED_INSURANCE_COST , VALUE : 0
    // 　　KEY : INSURED_TOTAL_COST     , VALUE : 0
    // 　　KEY : SERVICE_CODE_KIND, VALUE : ""

  }

  /**
   * 「小計初期値設定」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void setInitValueToSubTotal(VRMap subTotal, VRMap recNow, VRList masterService) throws Exception{
    // ■小計初期値設定
    // 　subTotalを初期化する。
    initializeRecord(subTotal);

    // 　サービス種類コード格納用の文字列 serviceCodeKind を生成する。
    String serviceCodeKind = null;
    // 　サービス種類名格納用の文字列 serviceKindName を生成する。
    String serviceKindName = null;
    // 　serviceCodeKind に recNow の KEY : SERVICE_CODE_KIND の VALUE を設定する。
    // 　serviceKindName に サービス種類コードから取得したサービス種類名を設定する。
    getServiceKindName(masterService, serviceCodeKind);

    // 　subTotal に recNow の下記 KEY の VALUE を設定する。
    // 　　PROVIDER_NAME
    // 　　PROVIDER_ID
    // 　　YEN_PER_UNIT
    // 　　BENEFIT_RATE
    // 　　SERVICE_CODE_KIND
    // 　subTotal に 下記の値を設定する。
    // 　　KEY : SERVICE_NAME, VALUE : (serviceKindName + "計")
    // 　　KEY : INIT, VALUE : 1

  }

  /**
   * 「小計加算処理」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void addRecordValueToSubTotal(VRMap subTotal, VRMap recNow) throws Exception{
    // ■小計加算処理
    // 　subTotal に recNow の下記 KEY の VALUE を加算する。(VALUE 同士を数値にキャストして足し算する。)
    // 　　SERVICE_UNIT_COST
    // 　　KUBUN_LIMIT_OVER
    // 　　KUBUN_LIMIT_UNDER
    // 　　INSURANCE_FEE
    // 　　BENEFIT
    // 　　INSURED_INSURANCE_COST
    // 　　INSURED_TOTAL_COST
    // 　subTotal に 下記の値を設定する。
    // 　　KEY : INIT, VALUE : 0

  }

  /**
   * 「フッター加算処理」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void addRecordValueToFooter(VRMap footerMap, VRMap rec) throws Exception{
    // ■フッターに値を加算する。
    // 　footerMap に recNow の下記 KEY の VALUE を加算する。(VALUE 同士を数値にキャストして足し算する。)
    // 　　SERVICE_UNIT_COST
    // 　　KUBUN_LIMIT_OVER
    // 　　KUBUN_LIMIT_UNDER
    // 　　INSURANCE_FEE
    // 　　BENEFIT
    // 　　INSURED_INSURANCE_COST
    // 　　INSURED_TOTAL_COST

  }

  /**
   * 「フッター加算処理」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void addExcludeValueToFooter(VRMap footerMap, VRList list) throws Exception{
    // ■フッターに限度額管理対象外分の値を足す(サービス単位/金額、区分支給限度基準内単位数は足さない)
    // 　list の任意のレコード格納用のレコード rec を生成する。
    VRMap rec = new VRHashMap();
    // 　list の件数分ループする。
    // 　　rec に list のn番目のレコードを設定する。
    // 　　footerMap に rec の下記 KEY の VALUE を加算する。(VALUE 同士を数値にキャストして足し算する。)
    // 　　　INSURANCE_FEE
    // 　　　BENEFIT
    // 　　　INSURED_INSURANCE_COST

  }

  /**
   * 「小計清算処理」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void addSubTotalToPrintList(VRList printList, VRMap footerMap, VRMap subTotal, VRMap recNow) throws Exception{
    // ■小計清算処理
    // 　subTotal の KEY : INIT の VALUE をチェックする。
    // 　　0の場合
    // 　　　処理を継続する。
    // 　　1の場合
    // 　　　処理を中断する。
    // 　subTotal の件数をチェックする。
    // 　　1件のみの場合
    // 　　　printList に subTotal を追加する。(追加パターンC)
    addRecordToPrintListPatternC(getPrintList(), subTotal);

    // 　　　footerMap に subTotal を加算する。
    addRecordValueToFooter(getFooterMap(), subTotal);

    // 　　複数件ある場合
    // 　　　printList に recNow を追加する。(追加パターンB)
    addRecordToPrintListPatternB(getPrintList(), recNow);

    // 　　　footerMap に recNow を加算する。
    addRecordValueToFooter(getFooterMap(), recNow);


  }

  /**
   * 「印刷用レコード集合へのレコード追加」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void addRecordToPrintListPatternA(VRList printList, VRMap rec) throws Exception{
    // ■印刷用レコード集合に現レコードを追加
    // 　変換後印刷データ格納用レコードとして printMap を生成する。
    VRMap printMap = new VRHashMap();
    // 　printMapに下記の値を設定する。
    // 　　KEY : PROVIDER_NAME          , VALUE : (rec の KEY : PROVIDER_NAME の VALUE)
    // 　　KEY : PROVIDER_ID            , VALUE :  (rec の KEY : PROVIDER_ID の VALUE)
    // 　　KEY : SERVICE_NAME           , VALUE :  (rec の KEY : SERVICE_NAME の VALUE)
    // 　　KEY : SERVICE_CODE           , VALUE :  (rec の KEY : SERVICE_CODE の VALUE)
    // 　　KEY : UNIT                   , VALUE : (rec の KEY : UNIT の VALUE)
    // 　　KEY : REDUCTION_RATE         , VALUE : (rec の KEY : REDUCTION_RATE の VALUE。ただし、0なら空白)
    // 　　KEY : REDUCTION_UNIT         , VALUE : (rec の KEY : REDUCTION_UNIT の VALUE。ただし、0なら空白)
    // 　　KEY : COUNT                  , VALUE : (rec の KEY : COUNT の VALUE)
    // 　　KEY : SERVICE_UNIT_COST      , VALUE : (rec の KEY : SERVICE_UNIT_COST の VALUE)
    // 　　KEY : KUBUN_LIMIT_OVER       , VALUE : ""
    // 　　KEY : KUBUN_LIMIT_UNDER      , VALUE : ""
    // 　　KEY : YEN_PER_UNIT           , VALUE : ""
    // 　　KEY : INSURANCE_FEE          , VALUE : ""
    // 　　KEY : BENEFIT_RATE           , VALUE : ""
    // 　　KEY : BENEFIT                , VALUE : ""
    // 　　KEY : INSURED_INSURANCE_COST , VALUE : ""
    // 　　KEY : INSURED_TOTAL_COST     , VALUE : ""
    // 　printList に printMap を追加する。

  }

  /**
   * 「印刷用レコード集合へのレコード追加」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void addRecordToPrintListPatternB(VRList printList, VRMap rec) throws Exception{
    // ■印刷用レコード集合に現レコードを追加
    // 　変換後印刷データ格納用レコードとして printMap を生成する。
    VRMap printMap = new VRHashMap();
    // 　printMapに下記の値を設定する。
    // 　　KEY : PROVIDER_NAME          , VALUE : (rec の KEY : PROVIDER_NAME の VALUE)
    // 　　KEY : PROVIDER_ID            , VALUE :  (rec の KEY : PROVIDER_ID の VALUE)
    // 　　KEY : SERVICE_NAME           , VALUE :  (rec の KEY : SERVICE_NAME の VALUE)
    // 　　KEY : SERVICE_CODE           , VALUE :  (rec の KEY : SERVICE_CODE の VALUE)
    // 　　KEY : UNIT                   , VALUE : (rec の KEY : UNIT の VALUE)
    // 　　KEY : REDUCTION_RATE         , VALUE : (rec の KEY : REDUCTION_RATE の VALUE。ただし、0なら空白)
    // 　　KEY : REDUCTION_UNIT         , VALUE : (rec の KEY : REDUCTION_UNIT の VALUE。ただし、0なら空白)
    // 　　KEY : COUNT                  , VALUE : (rec の KEY : COUNT の VALUE)
    // 　　KEY : SERVICE_UNIT_COST      , VALUE :  (rec の KEY : SERVICE_UNIT_COST の VALUE)
    // 　　KEY : KUBUN_LIMIT_OVER       , VALUE : (rec の KEY : KUBUN_LIMIT_OVER の VALUE。ただし、0なら空白)
    // 　　KEY : KUBUN_LIMIT_UNDER      , VALUE : (rec の KEY : KUBUN_LIMIT_UNDER の VALUE)
    // 　　KEY : YEN_PER_UNIT           , VALUE : (rec の KEY : YEN_PER_UNIT の VALUE)
    // 　　KEY : INSURANCE_FEE          , VALUE : (rec の KEY : INSURANCE_FEE の VALUE)
    // 　　KEY : BENEFIT_RATE           , VALUE : (rec の KEY : BENEFIT_RATE の VALUE)
    // 　　KEY : BENEFIT                , VALUE : (rec の KEY : BENEFIT の VALUE)
    // 　　KEY : INSURED_INSURANCE_COST , VALUE : (rec の KEY : INSURED_INSURANCE_COST の VALUE)
    // 　　KEY : INSURED_TOTAL_COST     , VALUE : (rec の KEY : INSURED_TOTAL_COST の VALUE。ただし、0なら空白)
    // 　printList に printMap を追加する。

  }

  /**
   * 「印刷用レコード集合へのレコード追加」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void addRecordToPrintListPatternC(VRList printList, VRMap rec) throws Exception{
    // ■印刷用レコード集合に小計用レコードを追加
    // 　変換後印刷データ格納用レコードとして printMap を生成する。
    VRMap printMap = new VRHashMap();
    // 　printMapに下記の値を設定する。
    // 　　KEY : PROVIDER_NAME          , VALUE : (rec の KEY : PROVIDER_NAME の VALUE)
    // 　　KEY : PROVIDER_ID            , VALUE :  (rec の KEY : PROVIDER_ID の VALUE)
    // 　　KEY : SERVICE_NAME           , VALUE : (rec の KEY : SERVICE_NAME の VALUE)
    // 　　KEY : SERVICE_CODE           , VALUE :  ""
    // 　　KEY : UNIT                   , VALUE : ""
    // 　　KEY : REDUCTION_RATE         , VALUE : ""
    // 　　KEY : REDUCTION_UNIT         , VALUE : ""
    // 　　KEY : COUNT                  , VALUE : ""
    // 　　KEY : SERVICE_UNIT_COST      , VALUE :  (rec の KEY : SERVICE_UNIT_COST の VALUE)
    // 　　KEY : KUBUN_LIMIT_OVER       , VALUE : (rec の KEY : KUBUN_LIMIT_OVER の VALUE。ただし、0なら空白)
    // 　　KEY : KUBUN_LIMIT_UNDER      , VALUE : (rec の KEY : KUBUN_LIMIT_UNDER の VALUE)
    // 　　KEY : YEN_PER_UNIT           , VALUE : (rec の KEY : YEN_PER_UNIT の VALUE)
    // 　　KEY : INSURANCE_FEE          , VALUE : (rec の KEY : INSURANCE_FEE の VALUE)
    // 　　KEY : BENEFIT_RATE           , VALUE : (rec の KEY : BENEFIT_RATE の VALUE)
    // 　　KEY : BENEFIT                , VALUE : (rec の KEY : BENEFIT の VALUE)
    // 　　KEY : INSURED_INSURANCE_COST , VALUE : (rec の KEY : INSURED_INSURANCE_COST の VALUE)
    // 　　KEY : INSURED_TOTAL_COST     , VALUE : (rec の KEY : INSURED_TOTAL_COST の VALUE。ただし、0なら空白)
    // 　printList に printMap を追加する。

  }

  /**
   * 「印刷用レコード集合へのレコード追加」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void addRecordToPrintListPatternD(VRList printList, VRMap rec) throws Exception{
    // ■印刷用レコード集合にその他事業所レコードを追加
    // 　変換後印刷データ格納用レコードとして printMap を生成する。
    VRMap printMap = new VRHashMap();
    // 　printMapに下記の値を設定する。
    // 　　KEY : PROVIDER_NAME          , VALUE : "他事業所"
    // 　　KEY : PROVIDER_ID            , VALUE :  ""
    // 　　KEY : SERVICE_NAME           , VALUE :  "他事業所計"
    // 　　KEY : SERVICE_CODE           , VALUE :  ""
    // 　　KEY : UNIT                   , VALUE : ""
    // 　　KEY : REDUCTION_RATE         , VALUE : ""
    // 　　KEY : REDUCTION_UNIT         , VALUE : ""
    // 　　KEY : COUNT                  , VALUE : ""
    // 　　KEY : SERVICE_UNIT_COST      , VALUE : "(" + (rec の KEY : SERVICE_UNIT_COST の VALUE) + ")"
    // 　　KEY : KUBUN_LIMIT_OVER       , VALUE : (rec の KEY : KUBUN_LIMIT_OVER の VALUE。ただし、0なら空白)
    // 　　KEY : KUBUN_LIMIT_UNDER      , VALUE : (rec の KEY : KUBUN_LIMIT_UNDER の VALUE)
    // 　　KEY : YEN_PER_UNIT           , VALUE : ""
    // 　　KEY : INSURANCE_FEE          , VALUE : (rec の KEY : INSURANCE_FEE の VALUE)
    // 　　KEY : BENEFIT_RATE           , VALUE : ""
    // 　　KEY : BENEFIT                , VALUE : (rec の KEY : BENEFIT の VALUE)
    // 　　KEY : INSURED_INSURANCE_COST , VALUE : (rec の KEY : INSURED_INSURANCE_COST の VALUE)
    // 　　KEY : INSURED_TOTAL_COST     , VALUE : (rec の KEY : INSURED_TOTAL_COST の VALUE。ただし、0なら空白)
    // 　printList に printMap を追加する。

  }

  /**
   * 「印刷用レコード集合へのレコード追加」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void addRecordToPrintListPatternE(VRList printList, VRList recList) throws Exception{
    // ■印刷用レコード集合に対象外用レコード集合を追加
    // 　変換後印刷データ格納用レコードとして printMap を生成する。
    VRMap printMap = new VRHashMap();
    // 　recList のn番目のレコード格納用のレコード rec を生成する。
    VRMap rec = new VRHashMap();
    // 　recList の件数分ループする。
    // 　　rec に recList のn番目のレコードを設定する。
    // 　　printMapに下記の値を設定する。
    // 　　　KEY : PROVIDER_NAME          , VALUE : (rec の KEY : PROVIDER_NAME の VALUE)
    // 　　　KEY : PROVIDER_ID            , VALUE :  (rec の KEY : PROVIDER_ID の VALUE)
    // 　　　KEY : SERVICE_NAME           , VALUE :  (rec の KEY : SERVICE_NAME の VALUE)
    // 　　　KEY : SERVICE_CODE           , VALUE :  (rec の KEY : SERVICE_CODE の VALUE)
    // 　　　KEY : UNIT                   , VALUE : (rec の KEY : UNIT の VALUE)
    // 　　　KEY : REDUCTION_RATE         , VALUE : ""
    // 　　　KEY : REDUCTION_UNIT         , VALUE : ""
    // 　　　KEY : COUNT                  , VALUE : ""
    // 　　　KEY : SERVICE_UNIT_COST      , VALUE : "(" + (rec の KEY : SERVICE_UNIT_COST の VALUE) + ")"
    // 　　　KEY : KUBUN_LIMIT_OVER       , VALUE : ""
    // 　　　KEY : KUBUN_LIMIT_UNDER      , VALUE : "(" + (rec の KEY : KUBUN_LIMIT_UNDER の VALUE) + ")"
    // 　　　KEY : YEN_PER_UNIT           , VALUE : ""
    // 　　　KEY : INSURANCE_FEE          , VALUE : (rec の KEY : INSURANCE_FEE の VALUE)
    // 　　　KEY : BENEFIT_RATE           , VALUE : ""
    // 　　　KEY : BENEFIT                , VALUE : (rec の KEY : BENEFIT の VALUE)
    // 　　　KEY : INSURED_INSURANCE_COST , VALUE : (rec の KEY : INSURED_INSURANCE_COST の VALUE)
    // 　　　KEY : INSURED_TOTAL_COST     , VALUE : (rec の KEY : INSURED_TOTAL_COST の VALUE。ただし、0なら空白)
    // 　　printList に printMap を追加する。

  }

  /**
   * 「サービス種類名取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public String getServiceKindName(VRList masterService, String kindCode) throws Exception{
    // ■サービス種類コードからサービス種類名を取得
    // 　masterService の任意の1レコード格納用の mSvcMap を生成する。
    VRMap mSvcMap = new VRHashMap();
    // 　masterServiceの件数分ループする。
    // 　　mSvcMap に masterService のn番目のレコードを設定する。
    // 　　kindCode と mSvcMap の KEY : SERVICE_CODE_KIND の VALUE を比較する。
    // 　　　等しい場合
    // 　　　　mSvcMap の KEY : SERIVCE_KIND_NAME の VALUE を戻り値として返す。
    // 　　　等しくない場合
    // 　　　　ループを継続する。
    // 　戻り値として空白("")を返す。
return null;
  }

}
