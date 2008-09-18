
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
 * 開発者: 小笠　貴志
 * 作成日: 2006/02/23  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン特定施設入所者生活介護 (QS001115)
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
 * サービスパターン特定施設入所者生活介護(QS001115) 
 */
public class QS001115 extends QS001115Event {
  /**
   * コンストラクタです。
   */
  public QS001115(){
  }

  //コンポーネントイベント

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QS001115.class.getName(), param));
  }
  
  /**
     * 施設区分選択時のイベント
     */
    protected void facilitiesDivisionRadioActionPerformed(ActionEvent e)
            throws Exception {
        if (getFacilitiesDivisionRadio().getSelectedIndex() == 1) {
            // 特定施設
            setState_SELECT_SPECIAL();
            if(!getFunctionTrainingFlag()){
                setState_INVALID_TRAINING();
            }

        } else if (getFacilitiesDivisionRadio().getSelectedIndex() == 2) {
            // 外部サービス利用型
            setState_SELECT_OUT();
            VRMap comboItemMap = new VRHashMap();
            switch (getOutsideServiceRadio().getSelectedIndex()) {
            case 1:
                // 訪問介護
                setState_SELECT_VISIT();
                
                
                break;
            case 2:
                // 訪問入浴介護
                setState_SELECT_VISIT_BATH();
                break;
            case 3:
                // 訪問看護選択時に｢職員区分｣PT・OT・STが選ばれた場合
                if (getVisitNursingStaffDivisionRadio().getSelectedIndex() == 2) {
                    // ※時間区分
                    // コードマスタデータよりCODE_ID：34 通所リハ（時間区分）を取得する。
                    // 取得した値を、comboItemMapの KEY : 1330112 の VALUE として設定する。
                    comboItemMap.setData("1330112", QkanCommon
                            .getArrayFromMasterCode(34, "1330112"));
                    // ※展開
                    // 自身(this)にcomboItemMapに設定する。
                    getThis().setModelSource(comboItemMap);
                    // コンボアイテムを展開する。
                    getThis().bindModelSource();
                }
                setState_SELECT_VISIT_NURSING();
                break;
            case 4:
                // 訪問リハ
                setState_SELECT_VISIT_REHABILI();
                break;
            case 5:
                // 通所介護
                // 外部サービス利用型が選ばれていた場合
                setState_SELECT_EXPERTPLACE_NURSING();
                break;
            case 6:
                // 通所リハ
                // 外部サービス利用型が選ばれていた場合
                setState_SELECT_EXPERTPLACE_REHABILI();
                break;
            case 7:
                // 福祉用具貸与
                // 外部サービス利用型が選ばれていた場合
                setState_SELECT_WELFARE_TOOLS();
                break;
            case 8:
                //認知症対応型通所介護
                //外部サービス利用型が選ばれていた場合
                setState_SELECT_NINTITUUSHO();
                break;
            case 9:
                //なし
                //外部サービス利用型が選ばれていた場合
                setState_SELECT_ONLY_BASE();
                break;
            }
        }
    }

  /**
     * 外部サービス選択時のイベント
     */
    protected void outsideServiceRadioActionPerformed(ActionEvent e)
            throws Exception {
        VRMap comboItemMap = new VRHashMap();
        switch (getOutsideServiceRadio().getSelectedIndex()) {
        case 1:
            // 訪問介護
            // 外部サービス利用型が選ばれていた場合
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_VISIT();
            }
            break;
        case 2:
            // 訪問入浴介護
            setState_SELECT_VISIT_BATH();
            break;
        case 3:
            // 訪問看護選択時に｢職員区分｣PT・OT・STが選ばれた場合
            // 外部サービス利用型が選ばれていた場合
            if (getOutsideServiceRadio().isEnabled()) {
                if (getVisitNursingStaffDivisionRadio().getSelectedIndex() == 2) {
                    // ※時間区分
                    // コードマスタデータよりCODE_ID：34 通所リハ（時間区分）を取得する。
                    // 取得した値を、comboItemMapの KEY : 1330112 の VALUE として設定する。
                    comboItemMap.setData("1330112", QkanCommon
                            .getArrayFromMasterCode(34, "1330112"));
                    // ※展開
                    // 自身(this)にcomboItemMapに設定する。
                    getThis().setModelSource(comboItemMap);
                    // コンボアイテムを展開する。
                    getThis().bindModelSource();
                }
                setState_SELECT_VISIT_NURSING();
            }
            break;
        case 4:
            // 訪問リハ
            // 外部サービス利用型が選ばれていた場合
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_VISIT_REHABILI();
            }
            break;
        case 5:
            // 通所介護
            // 外部サービス利用型が選ばれていた場合
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_EXPERTPLACE_NURSING();
            }
            break;
        case 6:
            // 通所リハ
            // 外部サービス利用型が選ばれていた場合
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_EXPERTPLACE_REHABILI();
            }
            break;
        case 7:
            // 福祉用具貸与
            // 外部サービス利用型が選ばれていた場合
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_WELFARE_TOOLS();
            }
            break;
        case 8:
            //認知症対応型通所介護
            //外部サービス利用型が選ばれていた場合
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_NINTITUUSHO();
            }
            break;
        case 9:
            //なし
            //外部サービス利用型が選ばれていた場合
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_ONLY_BASE();
            }
            break;
        }

    }
  //内部関数

  /**
     * 「初期化」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void initialize() throws Exception {
        // ※画面展開時の初期設定
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ※時間区分
        // コードマスタデータよりCODE_ID：223 訪問介護（時間区分）を取得する。
        // 取得した値を、comboItemMapの KEY : 1330114 の VALUE として設定する。
        comboItemMap.setData("1330109", QkanCommon.getArrayFromMasterCode(239,
                "1330109"));
        // ※時間区分
        // コードマスタデータよりCODE_ID：207 訪問看護（時間区分）を取得する。
        // 取得した値を、comboItemMapの KEY : 1330112 の VALUE として設定する。
        comboItemMap.setData("1330112", QkanCommon.getArrayFromMasterCode(207,
                "1330112"));
        // ※時間区分
        // コードマスタデータよりCODE_ID：40 通所介護（時間区分）を取得する。
        // 取得した値を、comboItemMapの KEY : 1330115 の VALUE として設定する。
        comboItemMap.setData("1330115", QkanCommon.getArrayFromMasterCode(240,
                "1330115"));
        // ※時間区分
        // コードマスタデータよりCODE_ID：40 通所リハ（時間区分）を取得する。
        // 取得した値を、comboItemMapの KEY : 1330117 の VALUE として設定する。
        comboItemMap.setData("1330117", QkanCommon.getArrayFromMasterCode(241,
                "1330117"));
        // 福祉用具
        comboItemMap.setData("1330118", QkanCommon.getArrayFromMasterCode(47,
                "1330118"));
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
        QkanCommon.selectFirstRadioItem(getThis());
        defaultMap.setData("1330107", new Integer(9));
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
        // 選択事業所情報がnullでない場合
        if (provider != null) {
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = new VRHashMap();
            // ※設定
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            Object obj = VRBindPathParser.get("1330103", provider);
            // 施設区分
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 特定施設
                    defaultMap.setData("1330105", obj);
                    break;
                case 2:
                    // 外部サービス
                    defaultMap.setData("1330105", obj);
                    break;
                }
            }
            // 個別機能訓練指導加算
            obj = VRBindPathParser.get("1330101", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // なし
                    setState_INVALID_TRAINING();
                    setFunctionTrainingFlag(false);
                    defaultMap.setData("1330103", obj);
                    break;
                case 2:
                    // あり
                    //特定施設が選択状態である場合
                    if(getFacilitiesDivisionRadioItem1().isSelected()){
                        setState_VALID_TRAINING();
                        
                    }
                    setFunctionTrainingFlag(true);
                    defaultMap.setData("1330103", obj);
                    break;
                }
            }
            // 夜間看護体制加算
            obj = VRBindPathParser.get("1330104", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // なし
//                    setState_INVALID_NIGHT_NURSING();
                    defaultMap.setData("1330106", obj);
                    break;
                case 2:
                    // あり
                    //特定施設が選択状態である場合
//                    if(getFacilitiesDivisionRadioItem1().isSelected()){
//                        setState_VALID_NIGHT_NURSING();
//                    }
                    defaultMap.setData("1330106", obj);
                    break;
                }
            }
            // 人員減算
            obj = VRBindPathParser.get("1330102", provider);
            if (obj != null) {
               //事業所登録の減算項目に合わせ初期値を調整
                switch(ACCastUtilities.toInt(obj)){
                case 1: //なしだった場合
                    VRBindPathParser.set("1330104", defaultMap, new Integer(1));
                    break;
                case 2: //看護職員だった場合
                case 3: //介護職員だった場合
                    VRBindPathParser.set("1330104", defaultMap, new Integer(2));
                    break;
                }
            }
            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();

        }
    }

  /**
   * 「入力内容の不備を検査」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public VRMap getValidData() throws Exception{
    // ※入力内容に不備がないかをチェックし、サービスデータを返す。
      //開始時刻区分が有効な場合
      if (getSpecificFacilityBeginTime().isEnabled()) {
          //訪問リハ・訪問入浴介護・福祉用具貸与の場合は時間チェックを行わない。
            if (!getOutsideServiceRadioItem4().isSelected()
                    && !getOutsideServiceRadioItem2().isSelected()
                    && !getOutsideServiceRadioItem7().isSelected()
                    &&!getOutsideServiceRadioItem0().isSelected()) {
                if (ACTextUtilities.isNullText(getSpecificFacilityBeginTime()
                        .getText())
                        || ACTextUtilities
                                .isNullText(getSpecificFacilityEndTime()
                                        .getText())
                        || (!getSpecificFacilityBeginTime().isValidDate())
                        || (!getSpecificFacilityEndTime().isValidDate())) {
                    // 開始時刻コンボ(houmonRehabilitationTimeContenaBeginTime)が空欄か不正の場合
                    // もしくは終了時刻コンボ(houmonRehabilitationTimeContenaEndTime)が空欄か不正の場合
                    // 時刻の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_TIME
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
                    // nullを返す。
                    return null;
                }
            }
        }
      //訪問介護施設区分が有効である場合
      if(getVisitCareCombo().isEnabled()){
          //時刻コンボの値をチェックする
          if(!getVisitCareCombo().isSelected()){
              //内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // nullを返す。
              return null;
          }

      }
      //訪問看護　時刻コンボが有効な場合
      if(getVisitNursingFacilitiesDivisionRadio().isEnabled()){
          if(!getVisitNursingCombo().isSelected()){
              //内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // nullを返す。
              return null;
          }
          //職員区分をチェックする。
          if(!getVisitNursingStaffDivisionRadio().getSelectedButton().isEnabled()){
              //内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // nullを返す。
              return null;              
          }
      }
      //通所介護　時刻コンボが有効な場合
      if(getExpertPlaceNursingCombo().isEnabled()){
          if(!getExpertPlaceNursingCombo().isSelected()){
              //内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // nullを返す。
              return null;
          }
      }
      //通所リハ　時刻コンボが有効な場合
      if(getExpertPlaceRehabiliCombo().isEnabled()){
          if(!getExpertPlaceRehabiliCombo().isSelected()){
              //内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // nullを返す。
              return null;
          }
      }
      
      //福祉用具　福祉用具の種類が選択されているかチェックする。
      if(getWelfareToolsCombo().isEnabled()){
          //用具種類が選択されていなかった場合
          if(!getWelfareToolsCombo().isSelected()){
              //内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // nullを返す。
              return null;              
          }
          //単位数が入力されていなかった場合
          if("".equals(getWelfarePointText().getText())){
              //内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // nullを返す。
              return null;
          }
          
      }
      
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
      if(getFacilitiesDivisionRadio().getSelectedIndex() == 1){
          return null;
      }
      //外部利用型だった場合
      // 　関数の返り値として開始時間コンボを返す。
      return getSpecificFacilityBeginTime();
  }

  /**
   * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public ACComboBox getEndTimeCombo() throws Exception{
    // ※終了時刻入力用のコンボを返す。

      if(getFacilitiesDivisionRadio().getSelectedIndex() == 1){
          return null;
      }
      //外部利用型だった場合
      // 　関数の返り値として終了時間コンボを返す。
      return getSpecificFacilityEndTime();
  }

  /**
   * 「時間区分の時間取得」に関する処理を行ないます。
   * 
   * @throws Exception 処理例外
   */
  public int getKangoTime() throws Exception {
      // ※時間区分(VisitCareCombo)の時間を取得
      // 時間区分(VisitCareCombo)の値をチェックする。
      switch (getVisitCareCombo().getSelectedIndex()) {
      case 0:
          // 15分未満の場合
          // 戻り値として180を返す。
          return 15;
      case 1:
          // 30分未満の場合
          // 戻り値として240を返す。
          return 30;
      case 2:
          // 45分未満の場合
          // 戻り値として360を返す。
          return 45;
      case 3:
          // 1時間未満の場合
          // 戻り値として480を返す。
          return 60;
      case 4:
          // 1時間15分未満の場合
          // 戻り値として540を返す。
          return 75;
      case 5:
      case 6:
          // 1時間30分未満の場合
//        1時間30分以上の場合
          // 戻り値として600を返す。
          return 90;
      }
      return 0;
  }
  
  
  /**
   * 「時間区分の時間取得」に関する処理を行ないます。
   * 
   * @throws Exception 処理例外
   */
  public int getTuusyoKaigoTime() throws Exception {
      // ※時間区分(VisitCareCombo)の時間を取得
      // 時間区分(VisitCareCombo)の値をチェックする。
      switch (getExpertPlaceNursingCombo().getSelectedIndex()) {
      case 0:
          // ２時間以上３時間未満の場合
          // 戻り値として180を返す。
          return 180;
      case 1:
          // ３時間以上４時間未満の場合
          // 戻り値として240を返す。
          return 240;
      case 2:
          // ４時間以上６時間未満の場合
          // 戻り値として360を返す。
          return 360;
      case 3:
          // ６時間以上８時間未満の場合
          // 戻り値として480を返す。
          return 480;
      case 4:
          // ８時間以上９時間未満の場合
          // 戻り値として540を返す。
          return 540;
      case 5:
          // ９時間以上１０時間未満の場合
          // 戻り値として600を返す。
          return 600;
      }
      return 0;
  }
  
  /**
   * 「時間区分の時間取得」に関する処理を行ないます。
   * 
   * @throws Exception 処理例外
   */
  public int getTuusyoKaigoTimeSpecial() throws Exception {
      // ※時間区分(VisitCareCombo)の時間を取得
      // 時間区分(VisitCareCombo)の値をチェックする。
      switch (getExpertPlaceNursingCombo().getSelectedIndex()) {
      case 0:
          // 2時間以上6時間未満の場合
          // 戻り値として180を返す。
          return 360;
      case 1:
          // 6時間以上8時間未満の場合
          // 戻り値として240を返す。
          return 480;
      }
      return 0;
  }
  /**
   * 「訪問看護時間区分の時間取得」に関する処理を行ないます。
   * 
   * @throws Exception 処理例外
   */
  public int getHoumonKangoTimeSpecial() throws Exception {
      // ※時間区分(VisitCareCombo)の時間を取得
      // 時間区分(VisitCareCombo)の値をチェックする。
      switch (getVisitNursingCombo().getSelectedIndex()) {
      case 0:
          // 30分未満の場合
          return 30;
      case 1:
          // 1時間半未満の場合
          return 90;
      }
      return 0;
  }
  
  /**
   * 「訪問看護時間区分の時間取得」に関する処理を行ないます。
   * 
   * @throws Exception 処理例外
   */
  public int getHoumonKangoTime() throws Exception {
      // ※時間区分(VisitCareCombo)の時間を取得
      // 時間区分(VisitCareCombo)の値をチェックする。
      switch (getVisitNursingCombo().getSelectedIndex()) {
      case 0:
          // 20分以上の場合
          // 戻り値として180を返す。
          return 20;
      case 1:
          // 30分以上の場合
          // 戻り値として240を返す。
          return 30;
      case 2:
          //1時間以上の場合
          return 60;
      case 3:
          //1時間30分以上の場合
          return 90;
      }
      return 0;
  }
  
  /**
   * 「通所リハ時間区分の時間取得」に関する処理を行ないます。
   * 
   * @throws Exception 処理例外
   */
  public int getTuusyoRihaTime() throws Exception {
      // ※時間区分(VisitCareCombo)の時間を取得
      // 時間区分(VisitCareCombo)の値をチェックする。
      switch (getExpertPlaceRehabiliCombo().getSelectedIndex()) {
      case 0:
          // 3時間未満の場合
          // 戻り値として180を返す。
          return 120;
      case 1:
          // 4時間未満の場合
          // 戻り値として240を返す。
          return 180;
      case 2:
          //4時間以上の場合
          return 240;
      case 3:
          //6時間以上の場合
          return 360;
      }
      return 0;
  }
  
  /**
   * 「認知症対応通所介護の時間区分の時間取得」に関する処理を行います。
   * @return
   * @throws Exception
   */
  public int getNintiTaiouTusyoKaigoTime() throws Exception{
      // ※時間区分(timeDivisionRadio)の時間を取得
      // 時間区分(timeDivisionRadio)の値をチェックする。
      switch (getTimeDivisionRadio().getSelectedIndex()) {
      case 1:
          // 3時間未満の場合
          // 戻り値として180を返す。
          return 180;
      case 2:
          // 4時間未満の場合
          // 戻り値として240を返す。
          return 240;
      case 3:
          //6時間以上の場合
          return 360;
      case 4:
          //8時間以上の場合
          return 480;
      }
      
      
      return 0;
  }
  
  /**
   * 「終了時間のチェック」に関する処理を行ないます。
   * 
   * @throws Exception 処理例外
   */
  public void checkEndTime() throws Exception {
      // ※時間帯変更時、終了時間も変更
      // 開始時間コンボ(houmonRehabilitationTimeContenaBeginTime)の値が空欄および不正でない場合
      // 時間退避用の変数kangoTimeに、時間区分から取得した時間を設定する。

      // 終了時間を「開始時間 + kangoTime(分)」に設定する。
      if (getSpecificFacilityBeginTime().isValidDate()
              && (!ACTextUtilities
                      .isNullText(getSpecificFacilityBeginTime()
                              .getText()))) {
          // 開始時間コンボ(houmonKangoKaigoBeginTime)の値が空欄および不正でない場合
          // 時間退避用の変数kangoTimeに、訪問看護時間区分から取得した時間を設定する。
          int addTime = 0;
          switch(getOutsideServiceRadio().getSelectedIndex()){
          case 1:
              //訪問介護
              addTime = getKangoTime();
              break;
          case 3:
                // 訪問看護
                // 訪問看護ステーションでなおかつPT・OT・STだった場合
                if (getVisitNursingStaffDivisionRadioItem2().isSelected()
                        && getVisitNursingFacilitiesDivisionRadioItem1()
                                .isSelected()) {
                    addTime = getHoumonKangoTimeSpecial();
                } else {
                    addTime = getHoumonKangoTime();
                }
                break;
            case 5:
              //通所介護
                if(getExpertPlaceNursingRadioItem3().isSelected()){
                    addTime = getTuusyoKaigoTimeSpecial();
                }else{
                    addTime = getTuusyoKaigoTime();
                }
              break;
          case 6://通所リハ
              addTime = getTuusyoRihaTime();
              break;
              
          case 8://認知症対応型通所介護
              addTime = getNintiTaiouTusyoKaigoTime();
              break;
              
          default:
                  return;
          }

          // 終了時間を「開始時間 + kangoTime(分)」に設定する。
          getSpecificFacilityEndTime().setDate(
                  ACDateUtilities.addMinute(
                          getSpecificFacilityBeginTime()
                                  .getDate(), addTime));
      }

  }

  /**
   * 時刻コンボ（開始）選択時のイベント
   */
    protected void specificFacilityBeginTimeActionPerformed(ActionEvent e) throws Exception {
        checkEndTime();
    }

    /**
     * 訪問介護　時間区分
     */
    protected void visitCareComboActionPerformed(ActionEvent e) throws Exception {
        checkEndTime();
    }
    /**
     * 訪問看護　時間区分コンボ
     */
    protected void visitNursingComboActionPerformed(ActionEvent e) throws Exception {
        checkEndTime();
        
    }
    /**
     * 通所介護時間区分選択
     */
    protected void expertPlaceNursingComboActionPerformed(ActionEvent e) throws Exception {
        checkEndTime();
    }
    /**
     * 通所リハ時間区分選択
     */
    protected void expertPlaceRehabiliComboActionPerformed(ActionEvent e) throws Exception {
        checkEndTime();
    }

    /**
     * 通所介護施設区分選択
     */
    protected void expertPlaceNursingRadioActionPerformed(ActionEvent e) throws Exception {
        //療養通所が選択されていた場合
        VRMap comboItemMap = new VRHashMap();
        switch(getExpertPlaceNursingRadio().getSelectedIndex()){
        case 1:
            //小規模型通所介護
        case 2:
            //通常規模型通所介護
            // ※時間区分
            // コードマスタデータよりCODE_ID：40　通所介護（時間区分）を取得する。
            // 取得した値を、comboItemMapの KEY : 1330115 の VALUE として設定する。
            comboItemMap.setData("1330115", QkanCommon.getArrayFromMasterCode(240,
                    "1330115"));
            // ※展開
            // 自身(this)にcomboItemMapに設定する。
            getThis().setModelSource(comboItemMap);
            // コンボアイテムを展開する。
            getThis().bindModelSource();
            break;
        case 3:
            //療養通所選択時
            // ※時間区分
            // コードマスタデータよりCODE_ID：40　通所介護（時間区分）を取得する。
            // 取得した値を、comboItemMapの KEY : 1330115 の VALUE として設定する。
            comboItemMap.setData("1330115", QkanCommon.getArrayFromMasterCode(238,
                    "1330115"));
            // ※展開
            // 自身(this)にcomboItemMapに設定する。
            getThis().setModelSource(comboItemMap);
            // コンボアイテムを展開する。
            getThis().bindModelSource();
            break;
        }
        
    }
    
    /**
     * 訪問看護施設区分選択
     */
    protected void visitNursingFacilitiesDivisionRadioActionPerformed(ActionEvent e) throws Exception {
        //訪問看護ステーションが選択されていてなおかつPT・OT・STだった場合
        if(getVisitNursingFacilitiesDivisionRadioItem1().isSelected()){
            if(getVisitNursingStaffDivisionRadioItem2().isSelected()){
                VRMap comboItemMap = new VRHashMap();
                comboItemMap.setData("1330112", QkanCommon
                        .getArrayFromMasterCode(237, "1330112"));
                // ※展開
                // 自身(this)にcomboItemMapに設定する。
                getThis().setModelSource(comboItemMap);
                // コンボアイテムを展開する。
                getThis().bindModelSource();
            }
            //訪問看護が選択されていた場合
            if(getOutsideServiceRadioItem3().isSelected()){
                setState_VALID_STAFF_DIVISION_();
            }
        }else {
            
            VRMap comboItemMap = new VRHashMap();
            comboItemMap.setData("1330112", QkanCommon
                    .getArrayFromMasterCode(207, "1330112"));
            // ※展開
            // 自身(this)にcomboItemMapに設定する。
            getThis().setModelSource(comboItemMap);
            // コンボアイテムを展開する。
            getThis().bindModelSource();
            //訪問看護　病院が選択されていた場合
            if(getVisitNursingFacilitiesDivisionRadioItem2().isSelected()){
                setState_INVALID_STAFF_DIVISION_();
            }
        }
        
    }


    /**
     * 訪問看護職員区分選択
     */
    protected void visitNursingStaffDivisionRadioActionPerformed(ActionEvent e) throws Exception {
        //PT・OT・STだった場合
        if(getVisitNursingStaffDivisionRadioItem2().isSelected()&&getVisitNursingFacilitiesDivisionRadioItem1().isSelected()){
            //訪問看護ステーションが選択されていた場合
                VRMap comboItemMap = new VRHashMap();
                comboItemMap.setData("1330112", QkanCommon
                        .getArrayFromMasterCode(237, "1330112"));
                // ※展開
                // 自身(this)にcomboItemMapに設定する。
                getThis().setModelSource(comboItemMap);
                // コンボアイテムを展開する。
                getThis().bindModelSource();
        }else{

            VRMap comboItemMap = new VRHashMap();
            comboItemMap.setData("1330112", QkanCommon
                    .getArrayFromMasterCode(207, "1330112"));
            // ※展開
            // 自身(this)にcomboItemMapに設定する。
            getThis().setModelSource(comboItemMap);
            // コンボアイテムを展開する。
            getThis().bindModelSource();
        }
        
    }
    
    /**
     * 認知症対応通所介護施設区分選択時
     */
    protected void providerDivisionRadioActionPerformed(ActionEvent e) throws Exception {
        //�U型が選択された場合
        if(getProviderDivisionRadio().getSelectedIndex()==2){
            //施設区分２を無効にする。
            setState_INVALID_NINTI_DIVISION();
        }else{
            //施設区分を選択可能にする。
            //認知症対応通所介護が選択されていた場合のみ
            if(getOutsideServiceRadioItem8().isSelected()){
                setState_VALID_NINTI_DIVISION();
            }
        }
        
        
    }

    /**
     * 認知症対応型通所介護時間区分選択時
     */
    protected void timeDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        checkEndTime();
        
    }

    protected void addWelfareToolsGroup(){
        String osName = System.getProperty("os.name");
        if ((osName != null) && (osName.indexOf("Mac") >= 0)) {
            // Macの場合、段組を調整して画面内に収める
            getWelfareToolsGroup().add(getWelfareToolsComboContainer(),
                    VRLayout.FLOW);
            getWelfareToolsGroup().add(getWelfarePointTextContainer(),
                    VRLayout.FLOW_RETURN);
            getWelfareToolsGroup().add(getWelfareTekiyoTextContainer(),
                    VRLayout.FLOW);
        } else {
            super.addWelfareToolsGroup();
        }
      }

}
