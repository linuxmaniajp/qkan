
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
 * 作成日: 2008/04/14  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン短期入所療養介護(介護老人保健施設) (QS001110_H2005)
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
 * サービスパターン短期入所療養介護(介護老人保健施設)(QS001110_H2005) 
 */
public class QS001110_H2005 extends QS001110_H2005Event {
  /**
   * コンストラクタです。
   */
  public QS001110_H2005(){
  }

  //コンポーネントイベント

  /**
   * 「施設区分選択時イベント」イベントです。
   * 
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayRecuperationHealthFacilityInstitutionDivisionRadioActionPerformed(
          ActionEvent e) throws Exception {
      // ※「施設区分」選択時の「病室区分」の状態切替
      // 「施設区分」の値をチェックする。
      //認定
      setState_VALID_NINCHI_CARE();
      switch (getShortStayRecuperationHealthFacilityInstitutionDivisionRadio()
              .getSelectedIndex()) {
      case 1:
          // 「介護老人保健施設｣の場合
          // 「病室区分(通常)」を有効にし、「病室区分(ユニット型)」を無効にする。
          setState_CONVENTIONAL_FORM();
          //日帰りショート専用ラジオグループのVisible制御 //20060411
          setState_SHORT_STAY_UNSELECT();
          break;
      case 2:
          // 「ユニット型介護老人保健施設｣の場合
          // 「病室区分(通常)」を無効にし、「病室区分(ユニット型)」を有効にする。
          setState_UNIT_FORM();
          //ユニットケア体制がない場合は再設定
          if(!getUnitCareFlag()){
              setState_INVALID_UNIT_CARE();
          }
          setState_INVALID_NINCHI_CARE();
          //日帰りショート専用ラジオグループのVisible制御 //20060411
          setState_SHORT_STAY_UNSELECT();
          break;
      case 3:
          // ｢日帰りショートステイ｣の場合
          setState_SELECT_SHORT_STAY_STATE();
          //認知症対応ケア加算
          setState_INVALID_NINCHI_CARE();
          //日帰りショート専用ラジオグループのVisible制御 //20060411
          setState_SHORT_STAY_SELECT();
      }
  }

  /**
   * 「食事提供選択」イベントです。
   * 
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayRecuperationHealthFacilityDinnerOfferActionPerformed(
          ActionEvent e) throws Exception {
      // ※「食事提供」選択時に「食費」の状態切替
      if (getShortStayRecuperationHealthFacilityDinnerOffer()
              .getSelectedIndex() < 1) {
          // 「食事提供」が「なし」の場合
          // 食費を無効にする。
          setState_NOT_USE_MEAT();
      } else {
          // 「食事提供」が「なし」以外の場合
          // 食費を有効にする。
          setState_USE_MEAT();
          // 食事費用(shortStayRecuperationHealthFacilityDinnerCost)を設定する。
          getShortStayRecuperationHealthFacilityDinnerCost()
                  .setText(
                          getMeatCost(getShortStayRecuperationHealthFacilityDinnerOffer()
                                  .getSelectedIndex()));
      }

  }

  // コンポーネントイベント

  public static void main(String[] args) {
      // デフォルトデバッグ起動
      ACFrame.getInstance().setFrameEventProcesser(
              new QkanFrameEventProcesser());
      QkanCommon.debugInitialize();
      VRMap param = new VRHashMap();
      // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
      ACFrame.debugStart(new ACAffairInfo(QS001110.class.getName(), param));
  }

  // 内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   * 
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception {
      // ※画面展開時の初期設定
      getShortStayRecuperationHealthFacilitySpecialMedicalExpense().clearDataModel();
      //QS001200(特別療養費)よりサービス種類(SYSTEM_SERVICE_KIND_DETAIL)に応じたbindPath配列を取得し、特別療養費ボタンに設定する。
      getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
              .setBindPathes(QS001200.getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
      // ※コンボアイテムの設定
      // ※準備
      // コンボアイテム設定用のレコード comboItemMap を生成する。
      VRMap comboItemMap = new VRHashMap();
      // ※設定
      // ※食事提供
      // コードマスタデータよりCODE_ID：191（食事提供）を取得する。
      // 取得した値を、comboItemMapの KEY : 1220112 の VALUE として設定する。
      comboItemMap.setData("1220112", QkanCommon.getArrayFromMasterCode(191,
              "1220112"));
      // ※展開
      // 自身(this)にcomboItemMapに設定する。
      getThis().setModelSource(comboItemMap);
      // コンボアイテムを展開する。
      getThis().bindModelSource();
      // ※選択項目の初期設定
      QkanCommon.selectFirstRadioItem(getThis());
      // ※準備
      // 初期選択設定用のレコード defaultMap を生成する。
      VRMap defaultMap = new VRHashMap();
      // 食事提供
      VRBindPathParser.set("1220112",defaultMap,new Integer(1));
      // ※展開
      // 自身(this)にdefaultMapに設定する。
      getThis().setSource(defaultMap);
      // 初期選択項目を展開する。
      getThis().bindSource();

  }

  /**
   * 「事業所コンボ変更時関数」に関する処理を行ないます。
   * 
   * @throws Exception 処理例外
   */
  public void providerSelected(VRMap provider) throws Exception {
      // ※事業所コンボ変更時に呼ぶ関数
      setSelectedProvider(provider);
      // 選択事業所情報がnullでない場合
      if (provider != null) {
          // ※以下の内容詳細項目は、選択事業所の値を設定する。
          // ※準備
          // 事業所連動用のレコード defaultMap を生成する。
          VRMap defaultMap = new VRHashMap();
          // ※設定
          Object obj;
          int index;
          // 施設区分
          obj = VRBindPathParser.get("1220101", provider);
          if (obj != null) {
              VRBindPathParser.set("1220101", defaultMap, obj);
          }
          
          // 施設区分（体制）
          index = ACCastUtilities.toInt(VRBindPathParser.get("1220120", provider),0);
          // そのまま反映する
          VRBindPathParser.set("1220120", defaultMap, new Integer(index));
          
          // 夜間勤務基準条件
          obj = VRBindPathParser.get("1220102", provider);
          if (obj != null) {
              VRBindPathParser.set("1220104", defaultMap, obj);
          }
          // 人員減算
          obj = VRBindPathParser.get("1220108", provider);
          if (obj != null) {
              //事業所登録の減算項目に合わせ初期値を調整
              switch(ACCastUtilities.toInt(obj)){
              case 1: //なしだった場合
                  VRBindPathParser.set("1220111", defaultMap, new Integer(1));
                  break;
              case 2: //医師だった場合
              case 3: //看護職員だった場合
              case 4: //介護職員だった場合
              case 5: //理学療法士だった場合
              case 6: //作業療法士だった場合
                  VRBindPathParser.set("1220111", defaultMap, new Integer(3));
                  break;
              }
          }
          
          // 送迎
          obj = VRBindPathParser.get("1220105", provider);
          if (obj != null) {
              switch (ACCastUtilities.toInt(obj)) {
              case 2:
                  // 「あり」の場合
                  // 送迎区分(shortStayRecuperationHealthFacilityMeetingAndSendingOff)の3番目のボタンを選択にする。
                  VRBindPathParser.set("6", defaultMap, new Integer(3));
                  break;
              case 1:
                  // 「なし」の場合
                  // 送迎区分(shortStayRecuperationHealthFacilityMeetingAndSendingOff)の1番目のボタンを選択にする。
                  VRBindPathParser.set("6", defaultMap, new Integer(1));
                  break;
              }
          }
          // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
          // リハビリ機能強化
          obj = VRBindPathParser.get("1220103", provider);
          if (obj != null) {
              switch (ACCastUtilities.toInt(obj)) {
              case 2:
                  // 「あり」の場合
                  // 有効にする。
                  setState_VALID_REHABILITATION();
                  VRBindPathParser.set("1220105", defaultMap, obj);
                  break;
              case 1:
                  // 「なし」の場合
                  // 無効にする。
                  setState_INVALID_REHABILITATION();
                  VRBindPathParser.set("1220105", defaultMap, obj);
                  break;
              }
          }
          // 栄養管理体制
          obj = VRBindPathParser.get("1220106", provider);
          if (obj != null) {
              if(new Integer(2).equals(ACCastUtilities.toInteger(obj))){
                  VRBindPathParser.set("1220109",defaultMap,new Integer(3));
              }else if(new Integer(3).equals(ACCastUtilities.toInteger(obj))){
                  VRBindPathParser.set("1220109",defaultMap,new Integer(2));
              }
          }
          
          // 療養環境維持特別加算
          index = ACCastUtilities.toInt(VRBindPathParser.get("1220121", provider),0);
          // そのまま反映する
          VRBindPathParser.set("1220121", defaultMap, new Integer(index));
          
          // 療養食
          obj = VRBindPathParser.get("1220107", provider);
          if (obj != null) {
              switch (ACCastUtilities.toInt(obj)) {
              case 2:
                  // 「あり」の場合
                  // 有効にする。
                  setState_VALID_MEDICAL_EXPENSES();
                  VRBindPathParser.set("1220110", defaultMap, obj);
                  break;
              case 1:
                  // 「なし」の場合
                  // 無効にする。
                  setState_INVALID_MEDICAL_EXPENSES();
                  VRBindPathParser.set("1220110", defaultMap, obj);
                  break;
              }
          }
          // ユニットケアの整備
          obj = VRBindPathParser.get("1220117", provider);
          if (obj != null) {
              switch (ACCastUtilities.toInt(obj)) {
              case 1:
                  // なしの場合
                  VRBindPathParser.set("1220117",defaultMap,obj);
                  setState_INVALID_UNIT_CARE();
                  setUnitCareFlag(false);
                  break;
              case 2:
                  // ありの場合
                  VRBindPathParser.set("1220117",defaultMap,obj);
                  setState_VALID_UNIT_CARE();
                  setUnitCareFlag(true);
                  break;
              }

          }else{
              //事業所登録で登録されていなかった場合は一律無効にする。
              setUnitCareFlag(false);
          }
          // 緊急短期入所ネットワーク加算
          obj = VRBindPathParser.get("1220118", provider);
          if (obj != null) {
              switch (ACCastUtilities.toInt(obj)) {
              case 1:
                  // なしだった場合
                  VRBindPathParser.set("1220118", defaultMap, obj);
                  setState_INVALID_SHORT_NETWORK();
                  break;
              case 2:
                  // ありだった場合
//                  VRBindPathParser.set("1220118", defaultMap, obj);
                  setState_VALID_SHORT_NETWORK();
                  break;
              }
          }

          // ※展開
          // 自身(this)にdefaultMapに設定する。
          getThis().setSource(defaultMap);
          // 初期選択項目を展開する。
          getThis().bindSource();

          if(getShortStayRecuperationHealthFacilityDinnerOffer().getSelectedIndex()==0){
              //食費なしの場合にのみ朝昼夜にする。
              getShortStayRecuperationHealthFacilityDinnerOffer().setSelectedIndex(1);
          }
      }
  }

  /**
   * 「入力内容の不備を検査」に関する処理を行ないます。
   * 
   * @throws Exception 処理例外
   */
  public VRMap getValidData() throws Exception {
      // ※入力内容に不備がないかをチェックし、サービスデータを返す。
      // 施設等の区分（体制）　
      // 日帰りショートステイの場合はエラーにしない
      if (getShortStayRecuperationHealthFacilityInstitutionDivisionRadio()
                .getSelectedIndex() != 3
                && getShortStayRecuperationHealthFacilityDivision()
                        .getSelectedIndex() < 1) {
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
          return null;
      }
      // 療養体制維持特別加算
      if(getShortStayRecuperationHealthFacilityRecuperationRadio().getSelectedIndex() < 1){
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
          return null;
      }
      
      if (getShortStayRecuperationHealthFacilityDinnerOffer()
              .getSelectedIndex() > 0) {
          // 食事提供（shortStayRecuperationHealthFacilityDinnerOffer)が「なし」以外を選択している場合
          if (ACTextUtilities
                  .isNullText(getShortStayRecuperationHealthFacilityDinnerCost()
                          .getText())) {
              // 食事費用(shortStayRecuperationHealthFacilityDinnerCost)が空欄の場合
              // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // nullを返す。
              return null;
          }
      }
      // ※返却用のレコード(data)を生成
      VRMap data = new VRHashMap();
      // 自身(this)のソースとして生成レコードを設定する。
      getThis().setSource(data);
      // 自身(this)のapplySourceを呼び出してデータを収集する。
      getThis().applySource();
      // ※返却用レコードから不要なキーを除去
      QkanCommon.removeDisabledBindPath(getThis(), data);

      // 問題なければ返却用レコード(data)を返す。
      return data;
  }

  /**
   * 「事業所情報の必要性を取得」に関する処理を行ないます。
   * 
   * @throws Exception 処理例外
   */
  public boolean isUseProvider() throws Exception {
      // ※事業所情報が必要なサービスであるかを返す。
      // trueを返す。
      return true;
  }

  /**
   * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
   * 
   * @throws Exception 処理例外
   */
  public ACComboBox getBeginTimeCombo() throws Exception {
      // ※開始時刻入力用のコンボを返す。
      // 関数の返り値として開始時間コンボを返す。
      return null;
  }

  /**
   * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
   * 
   * @throws Exception 処理例外
   */
  public ACComboBox getEndTimeCombo() throws Exception {
      // ※終了時刻入力用のコンボを返す。
      // 関数の返り値として終了時間コンボを返す。
      return null;
  }

  /**
   * 「食事費用を取得」に関する処理を行ないます。
   * 
   * @param meatType int
   * @throws Exception 処理例外
   * @return String
   */
  public String getMeatCost(int meatType) throws Exception {
      // ※食事時期をもとに選択事業所における食事費用を返す。
      if (getSelectedProvider() != null) {
          // 事業所を選択している場合
          switch (meatType) {
          case 1:
              // 食事時期が「朝昼夜」の場合
              // 「朝」の食費、「昼」の食費、「夜」の食費の合算を返す。
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1220109", getSelectedProvider()), 0));
          case 2:
              // 食事時期が「朝のみ」の場合
              // 「朝」の食費を返す。
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1220110", getSelectedProvider()), 0));
          case 3:
              // 食事時期が「昼のみ」の場合
              // 「昼」の食費を返す。
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1220111", getSelectedProvider()), 0));
          case 4:
              // 食事時期が「夜のみ」の場合
              // 「夜」の食費を返す。
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1220112", getSelectedProvider()), 0));
          case 5:
              // 食事時期が「朝昼」の場合
              // 「朝」の食費、「昼」の食費の食費の合算を返す。
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1220110", getSelectedProvider()),0)
                      + ACCastUtilities.toInt(VRBindPathParser.get("1220111",
                              getSelectedProvider()), 0));
          case 6:
              // 食事時期が「昼夜」の場合
              // 「昼」の食費、「夜」の食費の食費の合算を返す。
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1220111", getSelectedProvider()),0)
                      + ACCastUtilities.toInt(VRBindPathParser.get("1220112",
                              getSelectedProvider()), 0));
          case 7:
              // 食事時期が「夜朝」の場合
              // 「夜」の食費、「朝」の食費の食費の合算を返す。
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1220112", getSelectedProvider()),0)
                      + ACCastUtilities.toInt(VRBindPathParser.get("1220110",
                              getSelectedProvider()), 0));
          }
      }
      // 空文字を返す。
      return "";
  }

    protected void shortStayRecuperationHealthFacilitySpecialMedicalExpenseActionPerformed(
            ActionEvent e) throws Exception {
        // ※特別療養費の編集
        // 特別療養費編集画面(QS001200)を生成する。
        // 特別療養費ボタンのデータを引数に生成した特別療養費編集画面(QS001200)のshoModalを実行する。
        if (new QS001200().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
                        .getDataModel())) {
            // 特別療養費を変更した場合
            if (getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
                    .getDataModel().isEmpty()) {
                // 特別療養費ボタンのデータが空の場合
                // 特別療養費ラベルに「設定なし」と表示する。
                getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel()
                        .setText("設定なし");
            } else {
                // 特別療養費ボタンのデータが空ではない場合
                // 特別療養費ラベルに「設定あり」と表示する。
                getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel()
                        .setText("設定あり");
            }
        }

    }
    
    public void binded() throws Exception{
        if (getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
                .getDataModel().isEmpty()) {
            // 特別療養費ボタンのデータが空の場合
            // 特別療養費ラベルに「設定なし」と表示する。
            getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel()
                    .setText("設定なし");
        } else {
            // 特別療養費ボタンのデータが空ではない場合
            // 特別療養費ラベルに「設定あり」と表示する。
            getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel()
                    .setText("設定あり");
        }
    }

}
