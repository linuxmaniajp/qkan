
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
 * 作成日: 2009/02/09  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン夜間対応型訪問介護 (QS001123_H2104)
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
 * サービスパターン夜間対応型訪問介護(QS001123_H2104) 
 */
public class QS001123_H2104 extends QS001123_H2104Event {
  /**
   * コンストラクタです。
   */
  public QS001123_H2104(){
  }

  //コンポーネントイベント

  /**
   * 「施設区分への連動」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void providerDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception{
    // ※施設区分の状態に応じてその他の項目の有効状態を切り替える。
      switch(getProviderDivisionRadio().getSelectedIndex()){
      case 1:
          //I型
          setState_FACILITY_STATE_1();
          //定期巡回型だった場合は対応人数を無効にする。
          if(getServiceDivisionRadioItem1().isSelected()){
              setState_INVALID_PERSONS();
          }
          break;
      case 2:
          //II型
          setState_FACILITY_STATE_2();
          break;
      }

  }

  /**
   * 「サービス区分への連動」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void serviceDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception{
    // ※サービス区分の状態に応じて対応人数の有効状態を切り替える。
      switch(getServiceDivisionRadio().getSelectedIndex()){
      case 1:
          //定期巡回型
          setState_INVALID_PERSONS();
          break;
      case 2:
          //随時対応型
          setState_VALID_PERSONS();
          break;
      }
      
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QS001123_H2104.class.getName(), param));
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
    // ※画面展開時の初期設定
    // ※コンボアイテムの設定
    // 　※準備
    // 　　コンボアイテム設定用のレコード comboItemMap を生成する。
    VRMap comboItemMap = new VRHashMap();
    // 　※設定
    // 市町村独自加算I
    comboItemMap.setData("1710109", QkanCommon.getArrayFromMasterCode(276,
            "1710109"));
    // 市町村独自加算II
    comboItemMap.setData("1710110", QkanCommon.getArrayFromMasterCode(277,
            "1710110"));
    // ※開始時刻
    // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
    // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
    comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
    // ※終了時刻
    // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
    // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
    comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
    // 　※展開
    // 　　自身(this)にcomboItemMapに設定する。
    getThis().setModelSource(comboItemMap);
    // 　　コンボアイテムを展開する。
    getThis().bindModelSource();
    // ※選択項目の初期設定
    QkanCommon.selectFirstRadioItem(getThis());
    // 　※準備
    // 　　初期選択設定用のレコード defaultMap を生成する。
    VRMap defaultMap = new VRHashMap();
    // 　※設定
    // 　※展開
    // 　　自身(this)にdefaultMapに設定する。
    getThis().setSource(defaultMap);
    // 　　初期選択項目を展開する。
    getThis().bindSource();

  }

  /**
   * 「事業所コンボ変更時関数」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void providerSelected(VRMap provider) throws Exception{
      // ※事業所コンボ変更時に呼ぶ関数
      // 　選択事業所情報がnullでない場合
      // 　　※以下の内容詳細項目は、選択事業所の値を設定する。
      // 　　　※準備
      // 　　　　事業所連動用のレコード defaultMap を生成する。
      VRMap defaultMap = new VRHashMap();
      // 　　　※設定
      //施設区分
      VRBindPathParser.set("1710101", defaultMap,VRBindPathParser.get("1710101", provider));
      
      Object obj;
      


      // 24時間通報対応加算
      switch (ACCastUtilities.toInt(VRBindPathParser.get("1710103", provider), 0)) {
      case 2:
          // 「あり」の場合
          // 有効にする。
          setState_VALID_24MESSAGE();
          VRBindPathParser.set("1710107", defaultMap, new Integer(2));
          break;
      default:
          // 「なし」の場合
          // 無効にする。
          setState_INVALID_24MESSAGE();
          VRBindPathParser.set("1710107", defaultMap, new Integer(1));
          break;
      }
      
      //サービス提供体制強化加算
      obj = VRBindPathParser.get("1710104", provider);
      if (obj != null) {
          VRBindPathParser.set("1710108", defaultMap, obj);
      }
      
      //市町村独自加算I（事業所パネル）KEY：1710105の値をチェックする。
      obj = VRBindPathParser.get("1710105", provider);
      switch (ACCastUtilities.toInt(obj,0)) {
      //値が次のいずれかだった場合
      case 2:
          //2（市町村独自加算１）
      case 3:
          //3（市町村独自加算２）
      case 4:
          //4（市町村独自加算３）
      case 5:
          //5（市町村独自加算４）
      case 6:
          //6（市町村独自加算５）
      case 7:
          //7（市町村独自加算６）
          //defaultMapに KEY：1710109 VALUE：事業所の値を設定する。
          VRBindPathParser.set("1710109", defaultMap, obj);   
          break;
      default:
          //値が上記以外だった場合
          //defaultMapに KEY：1710109 VALUE：1（なし）を設定する。
          VRBindPathParser.set("1710109", defaultMap, new Integer(1));   
          break;
      }

      //市町村独自加算II（事業所パネル）KEY：1710106の値をチェックする。
      obj = VRBindPathParser.get("1710106", provider);
      switch (ACCastUtilities.toInt(obj,0)) {
      //値が次のいずれかだった場合
      case 2:
          //2（市町村独自加算１）
      case 3:
          //3（市町村独自加算２）
      case 4:
          //4（市町村独自加算３）
      case 5:
          //5（市町村独自加算４）
      case 6:
          //6（市町村独自加算５）
      case 7:
          //7（市町村独自加算６）
          //defaultMapに KEY：1710110 VALUE：事業所の値を設定する。
          VRBindPathParser.set("1710110", defaultMap, obj);   
          break;
      default:
          //値が上記以外だった場合
          //defaultMapに KEY：1710110 VALUE：1（なし）を設定する。
          VRBindPathParser.set("1710110", defaultMap, new Integer(1));   
          break;
      }
      
       // 　　　※展開
      // 　　　　自身(this)にdefaultMapに設定する。
      getThis().setSource(defaultMap);
      // 　　　　初期選択項目を展開する。
      getThis().bindSource();
      // 　　※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

      //基本夜間訪問 I 市町村独自加算が未選択の場合は、最初の項目(なし)を選択する。
      if(getBaseMunicipalityAdd().getSelectedIndex()<0 && getBaseMunicipalityAdd().getItemCount()>0){
          getBaseMunicipalityAdd().setSelectedIndex(0);
      }
      //基本夜間訪問 II 市町村独自加算が未選択の場合は、最初の項目(なし)を選択する。
      if(getServiceMunicipalityAdd().getSelectedIndex()<0 && getServiceMunicipalityAdd().getItemCount()>0){
          getServiceMunicipalityAdd().setSelectedIndex(0);
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
      // 　自身(this)のソースとして生成レコードを設定する。
      getThis().setSource(data);
      // 　自身(this)のapplySourceを呼び出してデータを収集する。
      getThis().applySource();
      // ※返却用レコードから不要なキーを除去
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
return getYakanHoumonKaigoBeginTime();
  }

  /**
   * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public ACComboBox getEndTimeCombo() throws Exception{
    // ※終了時刻入力用のコンボを返す。
    // 　関数の返り値として終了時間コンボを返す。
return getYakanHoumonKaigoEndTime();
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
