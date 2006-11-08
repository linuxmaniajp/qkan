
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
 * 作成日: 2006/02/14  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 介護老人福祉施設 (QO004016)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo004;

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

/**
 * 介護老人福祉施設(QO004016) 
 */
public class QO004016 extends QO004016Event {
  /**
   * コンストラクタです。
   */
  public QO004016(){
  }

  //コンポーネントイベント

  /**
   * 「介護老人福祉施設食費基準基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 介護老人福祉施設食費基準基準額合計表示処理
    // 介護老人福祉施設食費基準基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  /**
   * 「介護老人福祉施設食費基準基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 介護老人福祉施設食費基準基準額合計表示処理
    // 介護老人福祉施設食費基準基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  /**
   * 「介護老人福祉施設食費基準基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void careOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 介護老人福祉施設食費基準基準額合計表示処理
    // 介護老人福祉施設食費基準基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO004016.class.getName(), param));
  }

  //内部関数

  /**
   * 「介護老人福祉施設食費基準基準額合計処理」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // 介護老人福祉施設食費基準基準額合計処理
    // 下記のテキストフィールドに入力されている値を合計しcareOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal（食費基準額・合計テキストフィールド）に値を代入する。
    // ・careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney(食費基準額・朝・テキスト)
    // ・careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney(食費基準額・昼・テキスト)
    // ・careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney(食費基準額・夜・テキスト)
	int valMorning = 0;
	int valNoon = 0;
	int valNight = 0;
	
	if(!ACTextUtilities.isNullText(getCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney().getText())){
		valMorning = ACCastUtilities.toInt(getCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney().getText())){
		valNoon = ACCastUtilities.toInt(getCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoney().getText())){
		valNight = ACCastUtilities.toInt(getCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoney().getText());
	}
	
	int valTotal = valMorning + valNoon + valNight;
	
	if(valTotal == 0){
		getCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal().setText("");
	}else{
		getCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal().setText(ACCastUtilities.toString(valTotal));
	}

  }

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
    // ※初期化------------------------------------------------------
    // ※初期値設定------------------------------------------------------
    // 割引率テキストに初期値0を代入する。
    // ・agedPeopleWelfareFacilityDiscountRate
	getAgedPeopleWelfareFacilityDiscountRate().setText("0");

  }

  /**
   * 「入力チェック」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public boolean isValidInput() throws Exception{
    // ※入力チェック------------------------------------------------------
    // エラーメッセージ文言格納用に errMsg　を作成する。
    String errMsg = null;
    
    // 下記のテキストフィールドに対して入力チェックを行う。未入力だった場合は errMsg にメッセージを格納する。
    // ・agedPeopleWelfareFacilityDiscountRate（割引率テキスト）　※errMsg = 割引率
    if(ACTextUtilities.isNullText(getAgedPeopleWelfareFacilityDiscountRate().getText())){
    	errMsg = "割引率";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getAgedPeopleWelfareFacilityDiscountRate().requestFocus();
    	return false;
    }

    // 割引率の値をチェックする。
    int reductRate = ACCastUtilities.toInt(getAgedPeopleWelfareFacilityDiscountRate().getText());
    if(reductRate > 100){
    	// 100を超える値が入力されていた場合
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // エラーが発生したインスタンスにフォーカスを当てる。
    	getAgedPeopleWelfareFacilityDiscountRate().requestFocus();
	    return false;    	
    }   
    
    // 下記のラジオグループに対して選択チェックを行う。未選択だった場合は errMsg にメッセージを格納する。
    // ・agedPeopleWelfareFacilitiesDivision（施設区分ラジオグループ）　※errMsg = 施設区分
    if(!getAgedPeopleWelfareFacilitiesDivision().isSelected()){
    	errMsg = "施設区分";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getAgedPeopleWelfareFacilitiesDivision().requestFocus();
        return false;
    }
        
    // ・nightShiftCondition（夜間勤務条件基準）　※errMsg = 夜間勤務条件基準
    if(!getNightShiftCondition().isSelected()){
    	errMsg = "夜間勤務条件基準";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getNightShiftCondition().requestFocus();
        return false;
    }
        
    // ・functionTrainingGuidanceSystem（機能訓練指導体制ラジオグループ）　※errMsg = 機能訓練
    if(!getFunctionTrainingGuidanceSystem().isSelected()){
    	errMsg = "機能訓練";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getFunctionTrainingGuidanceSystem().requestFocus();
        return false;
    }
        
    // ・standingDoctorArrangement（常勤専従医師配置ラジオグループ）　※errMsg = 常勤専従医師配置
    if(!getStandingDoctorArrangement().isSelected()){
    	errMsg = "常勤専従医師配置";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getStandingDoctorArrangement().requestFocus();
        return false;
    }
        
    // ・psychiatristMaster（精神科医師定期的療養指導ラジオグループ）　※errMsg = 精神科医定期的療養指導
    if(!getPsychiatristMaster().isSelected()){
    	errMsg = "精神科医定期的療養指導";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getPsychiatristMaster().requestFocus();
        return false;
    }
        
    // ・handicappedPersonSupport（障害者生活支援体制ラジオグループ）　※errMsg = 障害者生活支援体制
    if(!getHandicappedPersonSupport().isSelected()){
    	errMsg = "障害者生活支援体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getHandicappedPersonSupport().requestFocus();
        return false;
    }
        
    // ・nutritionManageRadio（栄養管理体制ラジオグループ栄養管理体制ラジオグループ）　※errMsg = 栄養管理体制
    if(!getNutritionManageRadio().isSelected()){
    	errMsg = "栄養管理体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getNutritionManageRadio().requestFocus();
        return false;
    }
        
    // ・nutritionRadio（栄養マネジメント体制ラジオグループ）　※errMsg =　栄養マネジメント体制
    if(!getNutritionRadio().isSelected()){
    	errMsg = "栄養マネジメント体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getNutritionRadio().requestFocus();
        return false;
    }
        
    // ・oralSwitchRadio（経口移行体制ラジオグループ）　※errMsg = 経口移行体制
    if(!getOralSwitchRadio().isSelected()){
    	errMsg = "経口移行体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getOralSwitchRadio().requestFocus();
        return false;
    }
        
    // ・recuperateDinnerRadio（療養食体制ラジオグループ）  ※療養食体制
    if(!getRecuperateDinnerRadio().isSelected()){
    	errMsg = "療養食体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getRecuperateDinnerRadio().requestFocus();
        return false;
    }
        
    // staffLack（人員減算ラジオグループ）
    if(!getStaffLack().isSelected()){
    	errMsg = "人員減算";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getStaffLack().requestFocus();
        return false;
    }

    // ・careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney（食費基準・朝）　※errMsg = 食費基準額
    if(ACTextUtilities.isNullText(getCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // ・careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney（食費基準・昼）　※errMsg = 食費基準額
    if(ACTextUtilities.isNullText(getCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // ・careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney（食費基準・朝）　※errMsg = 食費基準額
    if(ACTextUtilities.isNullText(getCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // ・careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText　※ errMsg = ユニット型個室基準額
    if(ACTextUtilities.isNullText(getCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText().getText())){
    	errMsg = "ユニット型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText　※ errMsg = ユニット型準個室基準額
    if(ACTextUtilities.isNullText(getCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText().getText())){
    	errMsg = "ユニット型準個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText　※ errMsg = 従来型個室基準額
    if(ACTextUtilities.isNullText(getCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText().getText())){
    	errMsg = "従来型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・careOldPepleWelfareFacilitiesTasyouRoomText　※ errMsg = 多床室基準額
    if(ACTextUtilities.isNullText(getCareOldPepleWelfareFacilitiesTasyouRoomText().getText())){
    	errMsg = "多床室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getCareOldPepleWelfareFacilitiesTasyouRoomText().requestFocus();
    	return false;
    }
    
    return true;
    
  }

  /**
	 * 「パネル状態制御」に関する処理を行ないます。
	 * 
	 * @throws Exception 処理例外
	 */
  public void stateManager(boolean state) throws Exception {
	
  }

  /**
   * 「パネルデータ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public void getDetails(VRMap map) throws Exception{
	  
  }

}
