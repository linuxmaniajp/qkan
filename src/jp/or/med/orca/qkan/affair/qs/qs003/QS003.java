
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
 * 作成日: 2005/12/22  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス 利用・提供票印刷 (003)
 * プログラム 利用・提供票印刷 (QS003)
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
 * 利用・提供票印刷(QS003) 
 */
public class QS003 extends QS003Event {
  /**
   * コンストラクタです。
   */
  public QS003(){
  }
  public void initAffair(ACAffairInfo affair) throws Exception  {
    super.initAffair(affair);
    initAction(affair);
  }
  /**
   * 初期化処理を行ないます。
   * @param affair 業務情報
   * @throws Exception 処理例外
   */
  protected void initAction(ACAffairInfo affair) throws Exception {
    // ■各種初期値・初期状態を設定する
    // ※渡りパラメータの退避
    // 　patientIDに、渡りパラメータの KEY : PATIENT_ID の VALUE を設定する。
    // 　targetDateSourceに、渡りパラメータの KEY : TARGET_DATE の VALUE を設定する。
    // 　serviceDataに、渡りパラメータの KEY : SERVICE_DATA の VALUE を設定する。
    // 　渡りパラメータの KEY : PROCESS_TYPE の VALUE をチェックする。
    // 　　PROCESS_TYPE_PLANの場合
    // 　　　processTypeに数値定数PROCESS_TYPE_PLANを設定する。
    // 　　PROCESS_TYPE_RESULTの場合
    // 　　　processTypeに数値定数PROCESS_TYPE_RESULTを設定する。
    // ※初期値の設定
    // 　画面の初期値を設定する。
    setInitValue();

    // ※初期状態の設定
    // 　画面の初期状態を設定する。
    setInitState();


  }

  //コンポーネントイベント

  /**
   * 「居宅サービス作成者変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void planManufacturerActionPerformed(ActionEvent e) throws Exception{
    // ■居宅サービス作成者変更時、居宅介護支援事業者事業所欄の有効/無効を切り替える
    // 　居宅介護支援事業者事業所欄の有効/無効を設定する。
    setProviderComponentState();


  }

  /**
   * 「事業所名変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void supportProviderNameActionPerformed(ActionEvent e) throws Exception{
    // ■居宅介護支援事業者事業所名変更時、事業所番号、及び担当者を切り替える
    // ※事業所番号の変更
    // 　事業者番号ラベル(supportProviderCd)の値として、選択された事業所の事業所番号を設定する。(事業所名未選択等の理由により
    // 　事業所番号を取得できなかった場合、事業所番号は未選択とする)
    // ※担当者コンボのアイテム変更
    // 　担当者コンボ(personInCharge)のアイテムとして、選択された事業所に登録されている担当者を設定する。(事業所名未選択等の理由
    // 　により事業所番号を取得できなかった場合、担当者コンボのアイテムはなしとする)
    // ※担当者コンボの初期選択
    // 　選択された事業所で、最優先の担当者を選択する（事業所一覧画面で表示される担当者と同じ）。(設定できない場合は未選択とする)

  }

  /**
   * 「利用票/提供票の印刷」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void printActionPerformed(ActionEvent e) throws Exception{
    // ■利用票(別表)/提供票(別表)の印刷を行う。
    // 　渡りパラメータ printParam (レコード)を生成し、下記の値を設定する。
    VRMap printParam = new VRHashMap();
    // 　　KEY : PATIENT_ID, VALUE : (利用者ID)
    // 　　KEY : TARGET_DATE, VALUE : (対象年月)
    // 　　KEY : SERVICE_DATA, VALUE : (月間表情報のレコード集合)
    // 　　KEY : PROCESS_TYPE, VALUE : (内部変数processTypeの値)
    // 　　KEY : SHORT_STAR_USE_DAY, VALUE : (前月までの短期入所利用回数)
    // 　　KEY : CREATE_DATE_OUTER, VALUE : (枠外の作成年月日)
    // 　　KEY : CREATE_DATE_INNER, VALUE : (枠内の作成年月日)
    // ※印刷帳票の判別
    // 　印刷フラグの初期化のため、printParamに下記の値を設定する。
    // 　　KEY : PRINT_MODE_USE, VALUE : 0
    // 　　KEY : PRINT_MODE_USE_ANOTHER, VALUE : 0
    // 　　KEY : PRINT_MODE_OFFER VALUE : 0
    // 　　KEY : PRINT_MODE_OFFER_ANOTHER VALUE : 0
    // 　「印刷する帳票の選択」の値をチェックする。
    // 　　「利用票・別表」の場合
    // 　　　printParamに下記の値を設定する。
    // 　　　　KEY : PRINT_MODE_USE, VALUE : 1
    // 　　　　KEY : PRINT_MODE_USE_ANOTHER, VALUE : 1
    // 　　「提供票・別表」の場合
    // 　　　printParamに下記の値を設定する。
    // 　　　　KEY : PRINT_MODE_OFFER VALUE : 1
    // 　　　　KEY : PRINT_MODE_OFFER_ANOTHER VALUE : 1
    // 　　「利用票」の場合
    // 　　　printParamに下記の値を設定する。
    // 　　　　KEY : PRINT_MODE_USE, VALUE : 1
    // 　　「提供票」の場合
    // 　　　printParamに下記の値を設定する。
    // 　　　　KEY : PRINT_MODE_OFFER VALUE : 1
    // 　　「別表」の場合
    // 　　　「帳票種別選択」の値をチェックする。
    // 　　　　「利用票」の場合
    // 　　　　　printParamに下記の値を設定する。
    // 　　　　　　KEY : PRINT_MODE_USE_ANOTHER, VALUE : 1
    // 　　　　「提供票」の場合
    // 　　　　　printParamに下記の値を設定する。
    // 　　　　　　KEY : PRINT_MODE_OFFER_ANOTHER VALUE : 1
    // ※集計・印刷クラスへの値渡し
    // 　月間表情報を集計し、印刷を実行するためのクラスへ値を渡し、印刷を開始する。

  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    ACFrame.debugStart(new ACAffairInfo(QS003.class.getName()));
  }

  //内部関数

  /**
   * 「初期値設定」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void setInitValue() throws Exception{
    // ■初期値設定
    // ※下準備
    // 　要介護度履歴情報格納用のレコード集合 patientInsureInfoHistoryListを生成する。
    VRList patientInsureInfoHistoryList = new VRArrayList();
    // 　月初の要介護度履歴情報格納用レコード patientInsureInfoFirst を生成する。
    VRMap patientInsureInfoFirst = new VRHashMap();
    // 　月末の要介護度履歴情報格納用レコード patientInsureInfoLast を生成する。
    VRMap patientInsureInfoLast = new VRHashMap();
    // 　最も重い要介護度履歴情報格納用レコード patientInsureInfoHeaviest を生成する。
    VRMap patientInsureInfoHeaviest = new VRHashMap();
    // 　対象年月内の利用者要介護度認定履歴レコード集合を取得し、patientInsureInfoHistoryListに設定する。
    //     atientInsurerInfoHistory(DBManager, targetDateSource, patinetID);

    // 　patientInsureInfoFirstに、patientInsureInfoHistoryListの最初のレコードを設定する。
    // 　patientInsureInfoLastに、patientInsureInfoHistoryListの最後のレコードを設定する。
    // 　patientInsureInfoHeaviestに、最も重い要介護度履歴情報を設定する。
    QkanCommon.getPatientInsureInfoOnTargetDay(patientInsureInfoHistoryList, getTargetDateSource());
    // ※ウィンドウタイトルの設定
    // 　業務情報レコードを取得する。
    QkanCommon.getAffairInfo(getDBManager(), "QS003", "0");
    // 　ウィンドウタイトルに、取得レコードのKEY : WINDOW_TITLEのVALUEを設定する。
    // ※居宅サービス提供者
    // 　コンボのアイテムとして、居宅介護支援事業者を設定する。
    // 　コンボの選択項目として、利用者情報より取得した「居宅サービス提供者」を設定する。
    // ※居宅介護支援事業者事業所名
    // 　未選択とする。
    // ※作成年月日(枠外/別表)
    // 　システム日付を設定する。
    // ※作成年月日
    // 　システム日付を設定する。
    // ※届出年月日
    // 　初期値は設定しない。
    // ※要介護状態区分
    // 　patientInsureInfoFirstより「要介護状態区分」情報を取得し、画面のyouKaigodoType1に設定する。
    // 　patientInsureInfoFirstより「要介護状態区分」情報を取得し、画面のyouKaigodoType2に設定する。
    // ※支給限度基準額
    // 　patientInsureInfoHeaviestより「支給限度基準額」情報を取得し、設定する。
    // ※限度額適用期間
    // 　patientInsureInfoHeaviestより「限度額適用期間」情報を取得し、設定する。
    // ※前月までの短期入所利用日数(要介護度認定期間中の前月までの短期入所系サービス実績回数をカウント)
    // 　※要介護度の有効期間を取得する。
    // 　　有効期間開始日格納用の内部変数 insureValidStart を生成する。
    Date insureValidStart = null;
    // 　　有効期間終了日格納用の内部変数 insureValidEnd を生成する。
    Date insureValidEnd = null;
    // 　　patientInsureInfoFirstから有効期間開始(KEY : INSURE_VALID_START)を取得し、insureValidStartに設定する。
    // 　　insureInvalidEndに、対象年月の前月末日を設定する。(末日 = 年月:targetDateの一日(ついたち) マイナス 1日など)
    // 　※有効期間内のサービス実績情報を取得する。
    // 　　サービス詳細情報取得関数への渡りパラメータ params(文字列)を生成し、下記の値を設定する。
    String params = null;
    // 　　　params =
    // 　　　"PATIENT_ID=" + patientID +
    // 　　　"SERVICE_DATE>=" + insureValidStart +
    // 　　　"SERVICE_DATE<=" + insureValidEnd
    // 　　　"SERVICE_USE_TYPE=6"        //開始日○な実績
    // 　　有効期間内のサービス実績情報を取得する。
    QkanCommon.getServiceDetailCustom(getDBManager(), params);
    // 　※前月までの短期入所利用日数の集計
    // 　　取得した実績情報から、短期入所利用日数をカウントする。
    // 　　　・サービス種類が21、22、23のサービスをカウント対象とする
    // 　　　・「30日超」が設定されているものはカウントしない
    // 　　　・同日中に2つ以上のサービス実績があっても、「1日」としてカウントする
    // 　　　例)
    // 　　　　提供日格納用のレコード集合 offerDates を生成する。
    // 　　　　実績情報レコード集合のn番目のレコード退避用のレコード recを生成する。
    // 　　　　「30日超」チェック用の数値 over30 を生成する。
    // 　　　　チェック対象のサービス実績提供日格納用の日付 serviceDateを生成する。
    // 　　　　利用日数格納用の数値 usedDayCountを生成し、0で初期化する。
    // 　　　　取得した実績情報分ループする。
    // 　　　　　実績情報レコード集合のn番目のレコードを rec に退避する。
    // 　　　　　※サービス種類のチェック / 「30日超」チェック
    // 　　　　　　rec の KEY : SYSTEM_SERVICE_KIND_DETAIL の VALUE で分岐する。
    // 　　　　　　　12101
    // 　　　　　　　　over30に、rec の KEY : 1210113 の VALUE を設定する。
    // 　　　　　　　12201
    // 　　　　　　　　over30に、rec の KEY : 1220114 の VALUE を設定する。
    // 　　　　　　　12301
    // 　　　　　　　　over30に、rec の KEY : 1230152 の VALUE を設定する。
    // 　　　　　　　12302
    // 　　　　　　　　over30に、rec の KEY : 1230250 の VALUE を設定する。
    // 　　　　　　　12303
    // 　　　　　　　　over30に、rec の KEY : 1230349 の VALUE を設定する。
    // 　　　　　　　12304
    // 　　　　　　　　over30に、rec の KEY : 1230408 の VALUE を設定する。
    // 　　　　　　　上記以外の場合
    // 　　　　　　　　次のループへ飛ぶ。
    // 　　　　　　over30の値をチェックする。
    // 　　　　　　　0(30日超でない)の場合
    // 　　　　　　　　処理を継続する。
    // 　　　　　　　1(30日超である)の場合
    // 　　　　　　　　次のループへ飛ぶ。
    // 　　　　　※カウント処理
    // 　　　　　　serviceDateにrecの KEY : SERVICE_DATE の VALUE を設定する。
    // 　　　　　　既にカウントした日付かどうかチェックするために、offerDatesの件数分ループする。
    // 　　　　　　　serviceDateとofferDatesのn番目の日付とを比較する。
    // 　　　　　　　　等しい場合
    // 　　　　　　　　　次のrecのループへ飛ぶ。
    // 　　　　　　　　等しくない場合
    // 　　　　　　　　　offerDatesのループを継続する。
    // 　　　　　　どのofferDatesとも重複せずにループを抜けたserviceDateに関して、下記の処理を行う。
    // 　　　　　　　usedDayCountを1増やす。
    // 　　　　　　　offerDatesにserviceDateを追加する。
    // 　　取得したサービス利用日数を画面の「短記入所利用日数(shortStayUseDay)」に設定する。
    // ※公費も含んだ給付率で別表を作成
    // 　未選択とする。
    // ※帳票種別選択
    // ※印刷する帳票の種類

  }

  /**
   * 「画面の初期状態の設定」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void setInitState() throws Exception{
    // ■画面の初期状態を設定
    // ※居宅介護支援事業者事業所欄の有効/無効設定
    // 　居宅介護支援事業者事業所欄の有効/無効を設定する。
    setProviderComponentState();

    // ※予定印刷なのか、実績印刷なのかによって、状態を設定
    // 　processTypeの値をチェックする。
    // 　　PROCESS_TYPE_PLANの場合
    // 　　　「公費も含んだ給付率で別表を作成」チェックボックス、「帳票種類」グループを表示する。
    setState_PROCESS_TYPE_PLAN();
    // 　　PROCESS_TYPE_RESULTの場合
    // 　　　「公費も含んだ給付率で別表を作成」チェックボックス、「帳票種類」グループを非表示にする。
    setState_PROCESS_TYPE_RESULT();

  }

  /**
   * 「居宅介護支援事業者事業所欄の状態設定」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void setProviderComponentState() throws Exception{
    // ■居宅介護支援事業者事業所欄の有効/無効の切替
    // ※居宅介護支援事業者事業所欄の有効/無効設定
    // 　planManufacturerの値をチェックする。
    // 　　「居宅介護支援事業者」が選択されている場合
    // 　　　居宅介護支援事業者事業所欄を有効にする。
    setState_PROVIDER_MADE();
    // 　　「居宅介護支援事業者」が選択されていない場合
    // 　　　居宅介護支援事業者事業所欄を無効にする。
    setState_SELF_MADE();

  }

}
