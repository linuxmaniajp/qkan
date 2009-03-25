
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
 * 作成日: 2009/02/10  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防認知症対応型通所介護 (QS001146_H2104)
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
 * サービスパターン介護予防認知症対応型通所介護(QS001146_H2104) 
 */
public class QS001146_H2104 extends QS001146_H2104Event {
  /**
   * コンストラクタです。
   */
  public QS001146_H2104(){
  }

  //コンポーネントイベント

  /**
   * 「開始時間選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void beginTimeActionPerformed(ActionEvent e) throws Exception{
    // 開始時間選択
    // 　終了時間設定処理
    checkEndTime();


  }

  /**
   * 「時刻区分選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void timeDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception{
    // 時刻区分選択
    // 　終了時間再設定処理
    checkEndTime();


  }

  /**
   * 「施設区分1,2の連動」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void providerDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception{
    // ※施設区分1の状態に応じて施設区分2の有効状態を切り替える。
    // 　施設区分1の状態に応じて施設区分2の有効状態を切り替える。
    checkState();


  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QS001146_H2104.class.getName(), param));
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
      // ※画面展開時の初期設定
      // ※コンボアイテムの設定
      // ※準備
      // コンボアイテム設定用のレコード comboItemMap を生成する。
      VRMap comboItemMap = new VRHashMap();
      // ※設定
      // ※開始時刻
      // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
      // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
      comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "4"));
      // ※終了時刻
      // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
      // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
      comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
      // ※展開
      // 自身(this)にcomboItemMapに設定する。
      getThis().setModelSource(comboItemMap);
      // コンボアイテムを展開する。
      getThis().bindModelSource();
      // ※選択項目の初期設定
      // ※準備
      // 初期選択設定用のレコード defaultMap を生成する。
      VRMap defaultMap = new VRHashMap();
      // ※設定
      // 画面のラジオの初期値を設定する。（selectFirstRadioItem）
      QkanCommon.selectFirstRadioItem(getThis());
      // ※展開
      // 自身(this)にdefaultMapに設定する。
      getThis().setSource(defaultMap);
      // 初期選択項目を展開する。
      getThis().bindSource();
      // 画面状態制御
      checkState();

  }

  /**
   * 「事業所コンボ変更時関数」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void providerSelected(VRMap provider) throws Exception{
      // ※事業所コンボ変更時に呼ぶ関数
      // 選択事業所情報がnullでない場合
      if (provider != null) {
          // ※以下の内容詳細項目は、選択事業所の値を設定する。
          // ※準備
          // 事業所連動用のレコード defaultMap を生成する。
          VRMap defaultMap = new VRHashMap();
          // ※設定
          // 施設等の区分（事業所パネル）KEY：1740101の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740101",
                  provider),0)) {
          case 1:
          // 2008/06/06 [Masahiko Higuchi] del - begin 仕様障害対応（介護と動作に違いがあったため統一）
          //case 3:
          // 2008/06/06 [Masahiko Higuchi] del - end
              // 値が1（単独型）だった場合
              // defaultMapに KEY：1740101 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1740101", defaultMap, new Integer(1));
              break;
          case 2:
          // 2008/06/06 [Masahiko Higuchi] add - begin 仕様障害対応（介護と動作に違いがあったため統一）
          case 3:
          // 2008/06/06 [Masahiko Higuchi] add - end
              // 値が2（併設型）だった場合
              // defaultMapに KEY：1740101 VALUE：2（あり）を設定する。
              VRBindPathParser.set("1740101", defaultMap, new Integer(2));
              break;
          }
          // 職員の欠員による減算の状況（事業所パネル）KEY：1740102の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740102",
                  provider),0)) {
          case 1:
              // 値が1（なし）だった場合
              // defaultMapに KEY：1740104 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1740104", defaultMap, new Integer(1));
              break;
          case 2:
          case 3:
              // 値が2又は3だった場合（看護職員・介護職員）だった場合
              // defaultMapに KEY：1740104 VALUE：3（看護・介護職員が欠員）を設定する。
              VRBindPathParser.set("1740104", defaultMap, new Integer(3));
              break;
          }
          // 個別機能訓練体制（事業所パネル）KEY：1740104の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740104",
                  provider),0)) {
          case 1:
              // 値が1（なし）だった場合
              // defaultMapに KEY：1740106 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1740106", defaultMap, new Integer(1));
              break;
          case 2:
              // 値が2（あり）だった場合
              // defaultMapに KEY：1740106 VALUE：2（あり）を設定する。
              VRBindPathParser.set("1740106", defaultMap, new Integer(2));
              break;
          }
          // 入浴介助加算（事業所パネル）KEY：1740105の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740105",
                  provider),0)) {
          case 1:
              // 値が1（なし）だった場合
              // defaultMapに KEY：1740105 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1740105", defaultMap, new Integer(1));
              break;
          case 2:
              // 値が2（あり）だった場合
              // defaultMapに KEY：1740105 VALUE：2（あり）を設定する。
              VRBindPathParser.set("1740105", defaultMap, new Integer(2));
              break;
          }
          // 栄養改善体制（事業所パネル）KEY：1740106の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740106",
                  provider),0)) {
          case 1:
              // 値が1（なし）だった場合
              // defaultMapに KEY：1740107 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1740107", defaultMap, new Integer(1));
              break;
          case 2:
              // 値が2（あり）だった場合
              // defaultMapに KEY：1740107 VALUE：2（あり）を設定する。
              VRBindPathParser.set("1740107", defaultMap, new Integer(2));
              break;
          }
          // 口腔機能向上体制（事業所パネル）KEY：1740107の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740107",
                  provider),0)) {
          case 1:
              // 値が1（なし）だった場合
              // defaultMapに KEY：1740108 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1740108", defaultMap, new Integer(1));
              break;
          case 2:
              // 値が2（あり）だった場合
              // defaultMapに KEY：1740108 VALUE：2（あり）を設定する。
              VRBindPathParser.set("1740108", defaultMap, new Integer(2));
              break;
          }
          
          Object obj;

          //若年性認知症利用者受入加算（事業所パネル）KEY：1740108の値をチェックする。
          obj = VRBindPathParser.get("1740108", provider);
          switch (ACCastUtilities.toInt(obj,0)) {
          //値が次のいずれかだった場合
          case 2:
              //2（あり）
              //有効にする。
              setState_VALID_YOUNG_DEMENTIA_PATINET();
              break;
          default:
              //値が上記以外だった場合
              //無効にする。
              setState_INVALID_YOUNG_DEMENTIA_PATINET();
              break;
          }
          //常にdefaultMapに KEY：1740109 VALUE：1（なし）を設定する。
          VRBindPathParser.set("1740109", defaultMap, new Integer(1));   

          // サービス提供体制強化加算
          obj = VRBindPathParser.get("1740109", provider);
          if (obj != null) {
              defaultMap.setData("1740110", obj);
          }          
          
          // ※展開
          // 自身(this)にdefaultMapに設定する。
          getThis().setSource(defaultMap);
          // 初期選択項目を展開する。
          getThis().bindSource();
          // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
          // 画面状態制御
          checkState();
      }


  }

  /**
   * 「入力内容の不備を検査」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public VRMap getValidData() throws Exception{
      // ※入力内容に不備がないかをチェックし、サービスデータを返す。
      // ※返却用のレコード(data)を生成
      VRMap data = new VRHashMap();
      // 自身(this)のソースとして生成レコードを設定する。
      getThis().setSource(data);
      // 自身(this)のapplySourceを呼び出してデータを収集する。
      getThis().applySource();
      // ※返却用レコードから不要なキーを除去
      if (ACTextUtilities.isNullText(getBeginTime().getText())
              || ACTextUtilities.isNullText(getEndTime().getText())
              || (!getBeginTime().isValidDate())
              || (!getEndTime().isValidDate())) {
          // 開始時刻コンボ(houmonKangoIryoBeginTime)と終了時刻コンボ(houmonKangoIryoEndTime)のいずれかが空欄か不正の場合
          // 時刻の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_TIME
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
          // nullを返す。
          return null;
      }
      QkanCommon.removeDisabledBindPath(getThis(), data);
      // 問題なければ返却用レコード(data)を返す。
      return data;
  }

  /**
   * 「事業所情報の必要性を取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public boolean isUseProvider() throws Exception{
    // ※事業所情報が必要なサービスであるかを返す。
    // 　trueを返す。
return true;
  }

  /**
   * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public ACComboBox getBeginTimeCombo() throws Exception{
    // ※開始時刻入力用のコンボを返す。
    // 　関数の返り値として開始時間コンボを返す。
return getBeginTime();
  }

  /**
   * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public ACComboBox getEndTimeCombo() throws Exception{
    // ※終了時刻入力用のコンボを返す。
    // 　関数の返り値として終了時間コンボを返す。
return getEndTime();
  }

  /**
   * 「画面状態制御」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void checkState() throws Exception{
      // ※画面状態制御処理
      // ※サービス連動
      // 施設等の区分１（providerDivisionRadio）の値をチェックする。
      switch (getProviderDivisionRadio().getSelectedIndex()) {
      case 1:
          // 値が１（Ⅰ型）だった場合
          // 画面状態を｢画面状態１｣に変更する。
          setState_STATE_MODE_2();
          break;
      case 2:
          // 値が２（Ⅱ型）だった場合
          // 画面の状態を｢画面状態２｣に変更する。
          setState_STATE_MODE_1();
          break;
      }
      // ※事業所連動
      // 内部変数 providerInfoMap を生成する。
      VRMap providerInfoMap = new VRHashMap();
      // 事業所パネル情報を取得し providerInfoMap に格納する。
      // getSelectedProvider();
      providerInfoMap = getSelectedProvider();
      // providerInfoMapが null かチェックする。
      if (providerInfoMap != null) {
          // null（事業所未選択）だった場合
          // 何も行わない。
          // null以外だった場合
          // 個別機能訓練体制（事業所パネル）の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740104",
                  providerInfoMap))) {
          // 値が1（なし）だった場合
          case 1:
              // 個別機能訓練加算（サービスパネル）のEnableをfalseにする。
              setState_FUNCTION_TRAINING_ENABLE_FALSE();
              break;
          // 値が2（あり）だった場合
          case 2:
              // 個別機能訓練加算（サービスパネル）のEnableをtrueにする。
              setState_FUNCTION_TRAINING_ENABLE_TRUE();
              break;
          }
          // 入浴介助体制（事業所パネル）の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740105",
                  providerInfoMap))) {
          case 1:
              // 値が1（なし）だった場合
              // 入浴介助加算（サービスパネル）のEnableをfalseにする。
              setState_BATH_CARE_ENABLE_FALSE();
              break;
          case 2:
              // 値が2（あり）だった場合
              // 入浴介助加算（サービスパネル）のEnableをtrueにする。
              setState_BATH_CARE_ENABLE_TRUE();
              break;
          }
          // 栄養改善体制（事業所パネル）の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740106",
                  providerInfoMap))) {
          case 1:
              // 値が1（なし）だった場合
              // 栄養改善加算（サービスパネル）のEnableをfalseにする。
              setState_NOURISHMENT_MANAGEMENT_ENABLE_FALSE();
              break;
          case 2:
              // 値が2（あり）だった場合
              // 栄養改善加算（サービスパネル）のEnableをtrueにする。
              setState_NOURISHMENT_MANAGEMENT_ENABLE_TRUE();
              break;
          }
          // 口腔機能向上体制（事業所パネル）の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740107",
                  providerInfoMap))) {
          case 1:
              // 値が1（なし）だった場合
              // 口腔機能向上加算（サービスパネル）のEnableをfalseにする。
              setState_ORAL_FUNCTION_ENABLE_FALSE();
              break;
          case 2:
              // 値が2（あり）だった場合
              // 口腔機能向上加算（サービスパネル）のEnableをtrueにする。
              setState_ORAL_FUNCTION_ENABLE_TRUE();
              break;
          }
      }

  }

  /**
   * 「時間区分取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public int getNintiTusyoTime() throws Exception{
      // ※時間区分(gtimeDivisionRadio)の時間を取得
      switch (getTimeDivisionRadio().getSelectedIndex()) {
      // 時間区分(timeDivisionRadio)の値をチェックする。
      case 1:
          // 値が1（２時間以上３時間未満）の場合
          // 戻り値として180を返す。
          return 180;
      case 2:
          // 値が2（３時間以上４時間未満）の場合
          // 戻り値として240を返す。
          return 240;
      case 3:
          // 値が3（４時間以上６時間未満）の場合
          // 戻り値として360を返す。
          return 360;
      case 4:
          // 値が4（６時間以上８時間未満）の場合
          // 戻り値として480を返す。
          return 480;
      case 5:
          // 値が5（８時間以上９時間未満）の場合
          // 戻り値として540を返す。
          return 540;
      case 6:
          // 値が6（９時間以上１０時間未満）の場合
          // 戻り値として600を返す。
          return 600;
      default:
          // 該当項目が存在しない場合
          // 戻り値として0を返す。
          return 0;
      }
  }

  /**
   * 「開始・終了時間設定」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void checkEndTime() throws Exception{
      // ※開始・終了時間再設定
      // 内部変数 kaigoTime を生成する。
      // 開始時間コンボ(beginTime)の値がをチェックする。
      if (getBeginTime().isValidDate()
              && !ACTextUtilities.isNullText(getBeginTime().getText())) {
          // 不正でない場合
          // 時間退避用の変数kaigoTimeに、時間区分から取得した時間を設定する。
          int kaigoTime = getNintiTusyoTime();
          // 終了時間を「開始時間 + kaigoTime(分)」に設定する。
          getEndTime().setDate(
                  ACDateUtilities.addMinute(getBeginTime().getDate(),
                          kaigoTime));
      }
  }
  /**
   * 「サービス法改正区分取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public int getServiceLowVersion() throws Exception {
      //※このサービスパネルが扱うサービスの法改正区分(M_DETAIL.SYSTEM_BIND_PATH=14)を返す。 
      //QkanConstants.SERVICE_LOW_VERSION_H2104 を返す。
      return QkanConstants.SERVICE_LOW_VERSION_H2104;
  }


}
