
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
 * プログラム サービスパターン介護予防訪問リハビリテーション (QS001133_H2104)
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
 * サービスパターン介護予防訪問リハビリテーション(QS001133_H2104) 
 */
public class QS001133_H2104 extends QS001133_H2104Event {
  /**
   * コンストラクタです。
   */
  public QS001133_H2104(){
  }

  //コンポーネントイベント

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QS001133_H2104.class.getName(), param));
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
      // 画面のラジオの初期値を設定する。（selectFirstRadioItem）
      QkanCommon.selectFirstRadioItem(getThis());
      // ※展開
      // 自身(this)にdefaultMapに設定する。
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
      if (provider != null) {
          // 選択事業所情報がnullでない場合
          // ※以下の内容詳細項目は、選択事業所の値を設定する。
          // ※準備
          // 事業所連動用のレコード defaultMap を生成する。
          VRMap defaultMap = new VRHashMap();
          // ※設定
          // 施設区分（事業所パネル）KEY：1640101の値をチェックする。
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1640101",
                  provider), 0)) {
          case 1:
              // 値が1（病院又は診療所）KEY：1640101だった場合
              // 施設区分（サービスパネル）の病院又は診療所を選択状態にする。
              VRBindPathParser.set("1640101", defaultMap, new Integer(1));
              break;
          case 2:
              // 値が2（介護老人保健施設）だった場合
              // 施設区分（サービスパネル）の介護老人保健施設を選択状態にする。
              VRBindPathParser.set("1640101", defaultMap, new Integer(2));
              break;
          }
          
          //サービス提供体制強化加算
          VRBindPathParser.set("1640104", defaultMap, VRBindPathParser.get("1640102", provider));
          
          // 　　　※展開
          // 　　　　自身(this)にdefaultMapに設定する。
          getThis().setSource(defaultMap);
          // 　　　　初期選択項目を展開する。
          getThis().bindSource();
          // 　　※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
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
      // ※入力内容に不備がないかをチェックし、サービスデータを返す
      if (!getHoumonRehabilitationBeginTime().isValidDate()
              || (!getHoumonRehabilitationEndTime().isValidDate())) {
          // 開始時刻コンボ(houmonRehabilitationBeginTime)と終了時刻コンボ(houmonRehabilitationEndTime)のいずれかが空欄か不正の場合
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
      return getHoumonRehabilitationBeginTime();
  }

  /**
   * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public ACComboBox getEndTimeCombo() throws Exception{
      // ※終了時刻入力用のコンボを返す。
      // 　関数の返り値として終了時間コンボを返す。
      return getHoumonRehabilitationEndTime();
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
