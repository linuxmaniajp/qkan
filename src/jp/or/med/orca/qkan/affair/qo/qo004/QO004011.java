
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
 * 開発者: 
 * 作成日: 2006/02/13  日本コンピューター株式会社  新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 短期入所療養介護（診療所療養型） (QO004011)
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
 * 短期入所療養介護（診療所療養型）(QO004011) 
 */
public class QO004011 extends QO004011Event {
  /**
   * コンストラクタです。
   */
  public QO004011(){
  }

  //コンポーネントイベント

  /**
   * 「短期入所療養介護（診療所療養型）食費基準合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayRecuperateCareClinicMorningDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（診療所療養型）食費基準合計表示処理
    // 短期入所療養介護（診療所療養型）食費基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();
  }

  /**
   * 「短期入所療養介護（診療所療養型）食費基準合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayRecuperateCareClinicNoonDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（診療所療養型）食費基準合計表示処理
    // 短期入所療養介護（診療所療養型）食費基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();
  }

  /**
   * 「短期入所療養介護（診療所療養型）食費基準合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayRecuperateCareClinicNightDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（診療所療養型）食費基準合計表示処理
    // 短期入所療養介護（診療所療養型）食費基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO004011.class.getName(), param));
  }

  //内部関数

  /**
   * 「短期入所療養介護（診療所療養型）食費基準合計処理」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // 短期入所療養介護（診療所療養型）食費基準合計処理
    // 下記のテキストフィールドに入力されている値を合計し shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal
	// （食費基準額・合計テキストフィールド）に値を代入する。
	// ・shortStayRecuperateCareClinicMorningDinnerStandeirdMoney(食費基準額・朝・テキスト)
	// ・shortStayRecuperateCareClinicNoonDinnerStandeirdMoney(食費基準額・昼・テキスト)
	// ・shortStayRecuperateCareClinicNightDinnerStandeirdMoney(食費基準額・夜・テキスト)
	int valMorning = 0;
	int valNoon = 0;
	int valNight = 0;
	
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareClinicMorningDinnerStandeirdMoney().getText())){
		valMorning = ACCastUtilities.toInt(getShortStayRecuperateCareClinicMorningDinnerStandeirdMoney().getText()); 
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareClinicNoonDinnerStandeirdMoney().getText())){
		valNoon = ACCastUtilities.toInt(getShortStayRecuperateCareClinicNoonDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareClinicNightDinnerStandeirdMoney().getText())){
		valNight = ACCastUtilities.toInt(getShortStayRecuperateCareClinicNightDinnerStandeirdMoney().getText());
	}
	
	int valTotal = valMorning + valNoon + valNight;
	
	if(valTotal == 0){
		getShortStayRecuperateCareClinicDinnerStandeirdMoneyTotal().setText("");
	}else{
		getShortStayRecuperateCareClinicDinnerStandeirdMoneyTotal().setText(ACCastUtilities.toString(valTotal));
	}

  }

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
    // ※初期化------------------------------------------------------
    // ※初期値設定------------------------------------------------------
	// 割引率テキストに初期値0を表示する。
	getShortStayClinicRecuperationDiscountRate().setText("0");

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
    // ・shortStayClinicRecuperationDiscountRate（割引率）　※errMsg = 割引率
    if(ACTextUtilities.isNullText(getShortStayClinicRecuperationDiscountRate().getText())){
    	errMsg = "割引率";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayClinicRecuperationDiscountRate().requestFocus();
    	return false;
    }

    // 割引率の値をチェックする。
    int reductRate = ACCastUtilities.toInt(getShortStayClinicRecuperationDiscountRate().getText());
    if(reductRate > 100){
    	// 100を超える値が入力されていた場合
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // エラーが発生したインスタンスにフォーカスを当てる。
    	getShortStayClinicRecuperationDiscountRate().requestFocus();
	    return false;    	
    }   
    
    // 下記のラジオグループに対して選択チェックを行う。未選択だった場合は errMsg にメッセージを格納する。
    // ・shortStayInstitutionDivisionRadio（施設区分ラジオグループ）　※errMsg = 施設区分
    if(!getShortStayInstitutionDivisionRadio().isSelected()){
    	errMsg = "施設区分";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayInstitutionDivisionRadio().requestFocus();
        return false;
    }
        
    // ・shortStayStaffAssignmentDivision（人員配置区分ラジオグループ）　※errMsg = 人員配置区分
    if(!getShortStayStaffAssignmentDivision().isSelected()){
    	errMsg = "人員配置区分";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayStaffAssignmentDivision().requestFocus();
        return false;
    }
        
    // ・shortStayRecuperationEnvironmental（療養環境基準ラジオグループ）　※errMsg = 療養環境基準
    if(!getShortStayRecuperationEnvironmental().isSelected()){
    	errMsg = "療養環境基準";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayRecuperationEnvironmental().requestFocus();
        return false;
    }
        
    // ・shortStayMeetingAndSendingOffSystem（送迎体制ラジオグループ）※ errMsg = 送迎体制
    if(!getShortStayMeetingAndSendingOffSystem().isSelected()){
    	errMsg = "送迎体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayMeetingAndSendingOffSystem().requestFocus();
        return false;
    }
        
    // ・shortStayNutritionManageRadio（栄養管理体制ラジオグループ）　※errMsg = 栄養管理体制
    if(!getShortStayNutritionManageRadio().isSelected()){
    	errMsg = "栄養管理体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayNutritionManageRadio().requestFocus();
        return false;
    }
        
    // ・shortStayRecuperateDinnerRadio（療養食体制ラジオグループ）　※errMsg = 療養食体制
    if(!getShortStayRecuperateDinnerRadio().isSelected()){
    	errMsg = "療養食体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayRecuperateDinnerRadio().requestFocus();
        return false;
    }
     
    // ・shortStayStaffReduce（人員減算ラジオグループ）　※errMsg = 人員減算
    if(!getShortStayStaffReduce().isSelected()){
    	errMsg = "人員減算";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayStaffReduce().requestFocus();
        return false;
    }

    // ・shortStayRecuperateCareClinicMorningDinnerStandeirdMoney（食費基準額・朝）
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareClinicMorningDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareClinicMorningDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareClinicNoonDinnerStandeirdMoney（食費基準額・昼）
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareClinicNoonDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareClinicNoonDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareClinicNightDinnerStandeirdMoney（食費基準額・夜）
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareClinicNightDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareClinicNightDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText　※ errMsg = ユニット型個室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyText().getText())){
    	errMsg = "ユニット型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText　※ errMsg = ユニット型準個室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText().getText())){
    	errMsg = "ユニット型準個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText　※ errMsg = 従来型個室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyText().getText())){
    	errMsg = "従来型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareClinicTasyouRoomText　※ errMsg = 多床室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareClinicTasyouRoomText().getText())){
    	errMsg = "多床室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareClinicTasyouRoomText().requestFocus();
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
