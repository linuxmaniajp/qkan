
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
 * プログラム サービスパターン介護予防通所リハビリテーション (QS001136_H2104)
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
 * サービスパターン介護予防通所リハビリテーション(QS001136_H2104) 
 */
public class QS001136_H2104 extends QS001136_H2104Event {
  /**
   * コンストラクタです。
   */
  public QS001136_H2104(){
  }

  //コンポーネントイベント

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QS001136_H2104.class.getName(), param));
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
      // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
      // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
      comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
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
      // 画面状態を設定する。
      checkState();

      // ※展開
      // 自身(this)にdefaultMapに設定する。
      getThis().setSource(defaultMap);
      // 初期選択項目を展開する。
      getThis().bindSource();
      // 　　画面のラジオの初期値を設定する。（selectFirstRadioItem）
      QkanCommon.selectFirstRadioItem(getThis());

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
          // 職員の欠員による減算の状況（事業所パネル）KEY：1660101の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660101",
                  provider), 0)) {
          case 1:
              // 値が1（なし）だった場合
              // defaultMapに KEY：1660101 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1660101", defaultMap, new Integer(1));
              break;
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
              // 値が2（医師・看護職員・介護職員・PT・OT・ST）だった場合
              // defaultMapに KEY：1660101 VALUE：3（医師・PT・OT・ST・看護・介護職員が欠員）を設定する。
              VRBindPathParser.set("1660101", defaultMap, new Integer(3));
              break;
          }
          // 運動器機能向上体制（事業所パネル）KEY：1660102の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660102",
                  provider), 0)) {
          case 1:
              // 値が1（なし）だった場合
              // defaultMapに KEY：1660103 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1660103", defaultMap, new Integer(1));
              break;
          case 2:
              // 値が2（あり）だった場合
              // defaultMapに KEY：1660103 VALUE：2（あり）を設定する。
              VRBindPathParser.set("1660103", defaultMap, new Integer(2));
              break;
          }
          // 栄養改善体制（事業所パネル）KEY：1660103の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660103",
                  provider), 0)) {
          case 1:
              // 値が1（なし）だった場合
              // defaultMapに KEY：1660104 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1660104", defaultMap, new Integer(1));
              break;
          case 2:
              // 値が2（あり）だった場合
              // defaultMapに KEY：1660104 VALUE：2（あり）を設定する。
              VRBindPathParser.set("1660104", defaultMap, new Integer(2));
              break;
          }
          // 口腔機能向上体制（事業所パネル）KEY：1660104の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660104",
                  provider), 0)) {
          case 1:
              // 値が1（なし）だった場合
              // defaultMapに KEY：1660105 VALUE：1（なし）を設定する。
              VRBindPathParser.set("1660105", defaultMap, new Integer(1));
              break;
          case 2:
              // 値が2（あり）だった場合
              // defaultMapに KEY：1660105 VALUE：2（あり）を設定する。
              VRBindPathParser.set("1660105", defaultMap, new Integer(2));
              break;
          }
          // 事業所評価加算の有無（事業所パネル）KEY：1660105の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660105",
                  provider), 0)) {
          case 1:
              // 　　　　　値が1（なし）だった場合
              // 　　　　　　defaultMapに KEY：1660106　VALUE：1（なし）を設定する。
              VRBindPathParser.set("1660106", defaultMap, new Integer(1));
              break;
          case 2:
              // 　　　　　値が2（あり）だった場合
              // 　　　　　　defaultMapに KEY：1660106　VALUE：2（あり）を設定する。
              VRBindPathParser.set("1660106", defaultMap, new Integer(2));
              break;
          }
          
          Object obj;
          
          //若年性認知症利用者受入加算（事業所パネル）KEY：1660106の値をチェックする。
          obj = VRBindPathParser.get("1660106", provider);
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
          //常にdefaultMapに KEY：1660107 VALUE：1（なし）を設定する。
          VRBindPathParser.set("1660107", defaultMap, new Integer(1));   
          
          
          //サービス提供体制強化加算　事業所の[1660107]をサービスパネルの[1660108]に設定する。
          VRBindPathParser.set("1660108", defaultMap, VRBindPathParser.get("1660107", provider));
          
          
          // 　　　※展開
          // 　　　　自身(this)にdefaultMapを設定する。
          getThis().setSource(defaultMap);
          // 　　　　初期選択項目を展開する。
          getThis().bindSource();
          // 　　※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
          // 　　　画面の状態を変更する。
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
          // 　　nullを返す。
          return null;
      }
      QkanCommon.removeDisabledBindPath(getThis(), data);
      // 　問題なければ返却用レコード(data)を返す。
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
      // 　関数の返り値として終了時間コンボを返す。
      return getHoumonKaigoEndTime();
  }

  /**
   * 「画面状態制御」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void checkState() throws Exception{
      // ※画面状態制御を行います。
      // ※無効項目の設定を行う。
      // 内部変数 providerInfoMap を生成する。
      VRMap providerInfoMap;
      // 事業所パネル情報を取得し providerInfoMap に格納する。
      providerInfoMap = getSelectedProvider();

      // providerInfoMapが null かチェックする。
      // null（事業所未選択）だった場合
      // 何も行わない。
      if (providerInfoMap != null) {
          // null以外だった場合
          // 運動器機能向上体制（事業所パネル）の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660102",
                  providerInfoMap), 0)) {
          case 1:
              // 値が1（なし）だった場合
              // 運動器機能向上加算（サービスパネル）のEnableをfalseにする。
              setState_MOVE_FUNCTION_IMPROVEMENT_ENABLE_FALSE();
              break;
          case 2:
              // 値が2（あり）だった場合
              // 運動器機能向上加算（サービスパネル）のEnableをtrueにする。
              setState_MOVE_FUNCTION_IMPROVEMENT_ENABLE_TRUE();
              break;
          }
          // 栄養改善体制（事業所パネル）の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660103",
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
          // 口腔機能向上体制（事業所パネル）の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660104",
                  providerInfoMap), 0)) {
          case 1:
              // 値が1（なし）だった場合
              // 口腔機能向上加算（サービスパネル）のEnableをfalseにする。
              setState_MOUTH_FUNCTION_IMPROVEMENT_ENABLE_FALSE();
              break;
          case 2:
              // 値が2（あり）だった場合
              // 口腔機能向上加算（サービスパネル）のEnableをtrueにする。
              setState_MOUTH_FUNCTION_IMPROVEMENT_ENABLE_TRUE();
              break;
          }
          // 事業所評価加算の有無（事業所パネル）の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660105",
                  providerInfoMap), 0)) {
          case 1:
              // 　　　　　値が1（なし）だった場合
              // 　　　　　　事業所評価加算（サービスパネル）のEnableをfalseにする。
              setState_OFFICE_EVALUATION_ENABLE_FALSE();
              break;
          case 2:
              // 　　　　　値が2（あり）だった場合
              // 　　　　　　事業所評価加算（サービスパネル）のEnableをtrueにする。
              setState_OFFICE_EVALUATION_ENABLE_TRUE();
              break;
          }
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
