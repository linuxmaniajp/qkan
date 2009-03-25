
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
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防通所介護 (QS001135_H2104)
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
 * サービスパターン介護予防通所介護(QS001135_H2104) 
 */
public class QS001135_H2104 extends QS001135_H2104Event {
  /**
   * コンストラクタです。
   */
  public QS001135_H2104(){
  }

  //コンポーネントイベント

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QS001135_H2104.class.getName(), param));
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
      comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
      // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
      // ※終了時刻
      // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
      comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
      // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
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
      // ラジオの初期選択を行う。※selectFirstRadioItem(getThis())
      QkanCommon.selectFirstRadioItem(getThis());
      // ※展開
      // 自身(this)にdefaultMapに設定する。
      getThis().setSource(defaultMap);
      // 初期選択項目を展開する。
      getThis().bindSource();
      // 画面状態を設定する。
      checkState();


  }

  /**
   * 「事業所コンボ変更時関数」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void providerSelected(VRMap provider) throws Exception{
      // ※事業所コンボ変更時に呼ぶ関数
      if (provider != null) {
          // 選択事業所情報がnullでない場合
          // ※以下の内容詳細項目は、選択事業所の値を設定する。
          // ※準備
          // 事業所連動用のレコード defaultMap を生成する。
          VRMap defaultMap = new VRHashMap();
          // ※設定
          // 画面のラジオの初期値を設定する。（selectFirstRadioItem）
          // 画面状態を設定する。
          checkState();

          // 職員の欠員による減算の状況（事業所パネル）KEY：1650101の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1650101",
                  provider), 0)) {
          case 1:
              // 人員減算が1（なし）だった場合
              // defaultMapに KEY：1650101 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1650101", defaultMap, new Integer(1));
              break;
          case 2:
          case 3:
              // 値が2（看護・介護職員が欠員）だった場合
              // defaultMapに KEY：1650101 VALUE：3（看護・介護職員が欠員）を設定する。
              VRBindPathParser.set("1650101", defaultMap, new Integer(3));
              break;
          }
          // 運動機能向上体制（事業所パネル）KEY：1650102の値を取得する。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1650102",
                  provider), 0)) {
          case 1:
              // 値が1（なし）だった場合
              // defaultMapに KEY：1650104 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1650104", defaultMap, new Integer(1));
              break;
          case 2:
              // 値が2だった場合
              // defaultMapに KEY：1650104 VALUE：2（あり）を設定する。
              VRBindPathParser.set("1650104", defaultMap, new Integer(2));
              break;
          }
          // 栄養改善体制（事業所パネル）KEY：1650103の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1650103",
                  provider), 0)) {
          case 1:
              // 値が1（なし）だった場合
              // defaultMapに KEY：1650105 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1650105", defaultMap, new Integer(1));
              break;
          case 2:
              // 値が2（あり）だった場合
              // defaultMapに KEY：1650105 VALUE：2（あり）を設定する。
              VRBindPathParser.set("1650105", defaultMap, new Integer(2));
              break;
          }
          // 口腔機能向上体制（事業所パネル）KEY：1650104の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1650104",
                  provider), 0)) {
          case 1:
              // 値が1（なし）だった場合
              // defaultMapに KEY：1650106 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1650106", defaultMap, new Integer(1));
              break;
          case 2:
              // 値が2（あり）だった場合
              // defaultMapに KEY：1650106 VALUE：2（あり）を設定する。
              VRBindPathParser.set("1650106", defaultMap, new Integer(2));
              break;
          }
          // 事業所評価加算の有無（事業所パネル）KEY：1650105の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1650105",
                  provider), 0)) {
          case 1:
              // 値が1（なし）だった場合
              // defaultMapに KEY：1650107 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1650107", defaultMap, new Integer(1));
              break;
          case 2:
              // 値が2（あり）だった場合
              // defaultMapに KEY：1650107 VALUE：2（あり）を設定する。
              VRBindPathParser.set("1650107", defaultMap, new Integer(2));
              break;
          }
          
          //サービス提供体制強化加算　事業所の[1650107]をサービスパネルの[1650109]に設定する。
          VRBindPathParser.set("1650109", defaultMap, VRBindPathParser.get("1650107", provider));

          Object obj;

          //若年性認知症利用者受入加算（事業所パネル）KEY：1650106の値をチェックする。
          obj = VRBindPathParser.get("1650106", provider);
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
          //常にdefaultMapに KEY：1650108 VALUE：1（なし）を設定する。
          VRBindPathParser.set("1650108", defaultMap, new Integer(1));   
          
          
          // ※展開
          // 自身(this)にdefaultMapに設定する。
          getThis().setSource(defaultMap);
          // 初期選択項目を展開する。
          getThis().bindSource();
          // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
          // 画面状態を設定する。
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
      // ※時刻コンボチェック
      if (!getHoumonKaigoBeginTime().isValidDate()
              || (!getHoumonKaigoEndTime().isValidDate())) {
          // 開始時刻コンボ(houmonKaigoBeginTime)と終了時刻コンボ(houmonKaigoEndTime)のいずれかが空欄もしくは不正の場合
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
      // trueを返す。
      return true;
  }

  /**
   * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public ACComboBox getBeginTimeCombo() throws Exception{
      // ※開始時刻入力用のコンボを返す。
      // 関数の返り値として開始時間コンボを返す。
      return getHoumonKaigoBeginTime();
  }

  /**
   * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public ACComboBox getEndTimeCombo() throws Exception{
      // ※終了時刻入力用のコンボを返す。
      // 関数の返り値として終了時間コンボを返す。
      return getHoumonKaigoEndTime();
  }

  /**
   * 「画面状態制御」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void checkState() throws Exception{
      // ※画面状態制御処理を行います。
      // 内部変数 providerInfoMap を生成する。
      VRMap providerInfoMap;
      // 事業所パネル情報を取得し providerInfoMap に格納する。
      providerInfoMap = getSelectedProvider();
      // providerInfoMapが null かチェックする。
      // null（事業所未選択）だった場合
      // 何も行わない。
      if (providerInfoMap != null) {
          // null以外だった場合
          // 運動機能向上体制（事業所パネル）KEY：1650102の値を取得する。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1650102",
                  providerInfoMap), 0)) {
          case 1:
              // 値が1（なし）だった場合
              // 運動機能向上加算（サービスパネル）のEnableを false にする。
              setState_MOVE_FUNCTION_IMPROVEMENT_ENABLE_FALSE();
              break;
          case 2:
              // 値が2だった場合
              // 運動機能向上加算（サービスパネル）のEnableを true にする。
              setState_MOVE_FUNCTION_IMPROVEMENT_ENABLE_TRUE();
              break;
          }
          // 栄養改善体制（事業所パネル）の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1650103",
                  providerInfoMap), 0)) {
          case 1:
              // 値が1（なし）だった場合
              // 栄養改善加算（サービスパネル）のEnableをfalseにする。
              setState_NOURISHMENT_IMPROVEMENT_ENABLE_FALSE();
              break;
          case 2:
              // 値が2（あり）だった場合
              // 栄養改善加算（サービスパネル）のEnableをtrueにする。
              setState_NOURISHMENT_IMPROVEMENT_ENABLE_TRUE();
              break;
          }
          // 口腔機能向上体制（事業所パネル）KEY：1650104の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1650104",
                  providerInfoMap), 0)) {
          case 1:
              // 値が1（なし）だった場合
              // 口腔機能向上体制加算（サービスパネル）のEnableをfalseにする。
              setState_MOUTH_FUNCTION_IMPROVEMENT_ENABLE_FALSE();
              break;
          case 2:
              // 値が2（あり）だった場合
              // 口腔機能向上体制加算（サービスパネル）のEnableをtrueにする。
              setState_MOUTH_FUNCTION_IMPROVEMENT_ENABLE_TRUE();
              break;
          }
          // 事業所評価加算の有無（事業所パネル）KEY：1650105の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1650105",
                  providerInfoMap), 0)) {
          case 1:
              // 値が1（なし）だった場合
              // 事業所評価加算（サービスパネル）のEnableをfalseにする。
              setState_OFFICE_EVALUATION_ENABLE_FALSE();
              break;
          case 2:
              // 値が2（あり）だった場合
              // 事業所評価加算（サービスパネル）のEnableをtrueにする。
              setState_OFFICE_EVALUATION_ENABLE_TRUE();
              break;
          }
      }
  }

  /**
   * 「運動器機能向上加算選択時」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void moveFunctionImprovementAddRadioSelectionChanged(ListSelectionEvent e) throws Exception{
    // ※運動器機能向上加算選択時
    // 　画面の状態を変更する。
    checkActivityState();


  }

  /**
   * 「栄養改善加算選択時」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void nourishmentImprovementAddRadioSelectionChanged(ListSelectionEvent e) throws Exception{
    // ※栄養改善加算選択時
    // 　画面の状態を変更する。
    checkActivityState();


  }

  /**
   * 「口腔機能向上加算選択時」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void mouthFunctionImprovementAddRadioSelectionChanged(ListSelectionEvent e) throws Exception{
    // ※口腔機能向上加算選択時
    // 　画面の状態を変更する。
    checkActivityState();


  }
  
  /**
   * 「アクティビティ加算状態制御」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void checkActivityState() throws Exception{
      // 運動器機能向上加算
      if(getMoveFunctionImprovementAddRadio().isEnabled()){
          // ありだった場合
         if(getMoveFunctionImprovementAddRadio().getSelectedIndex() == 2){
             // アクティビティ加算を無効にする。
             setState_ACTIVITY_ENABLE_FALSE();
             return;
         }
      }
      
      // 栄養改善加算
      if(getNourishmentImprovementAddRadio().isEnabled()){
          // ありだった場合
          if(getNourishmentImprovementAddRadio().getSelectedIndex() == 2){
              // アクティビティ加算を無効にする。
              setState_ACTIVITY_ENABLE_FALSE();                
              return;
          }
      }
      
      // 口腔機能向上加算
      if(getMouthFunctionImprovementAddRadio().isEnabled()){
          // ありだった場合
          if(getMouthFunctionImprovementAddRadio().getSelectedIndex() == 2){
              // アクティビティ加算を無効にする。
              setState_ACTIVITY_ENABLE_FALSE();                
              return;                
          }
      }
      
      // 上記全てに該当しなかった場合
      // アクティビティ加算有効
      setState_ACTIVITY_ENABLE_TRUE();

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
