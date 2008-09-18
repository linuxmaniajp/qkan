
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
 * 作成日: 2006/02/13  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 短期入所療養介護（基準適合診療所型） (QO004013)
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
import jp.or.med.orca.qkan.lib.*;

/**
 * 短期入所療養介護（基準適合診療所型）(QO004013) 
 */
public class QO004013 extends QO004013Event {
  /**
   * コンストラクタです。
   */
  public QO004013(){
  }

  //コンポーネントイベント

  /**
   * 「短期入所療養介護（基準適合診療所）食費基準額合計表示処理処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayRecuperateCareStandardMorningDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（基準適合診療所）食費基準額合計表示処理処理
    // 短期入所療養介護（基準適合診療所）食費基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  /**
   * 「短期入所療養介護（基準適合診療所）食費基準額合計表示処理処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayRecuperateCareStandardNoonDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（基準適合診療所）食費基準額合計表示処理処理
    // 短期入所療養介護（基準適合診療所）食費基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  /**
   * 「短期入所療養介護（基準適合診療所）食費基準額合計表示処理処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayRecuperateCareStandardNightDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（基準適合診療所）食費基準額合計表示処理処理
    // 短期入所療養介護（基準適合診療所）食費基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO004013.class.getName(), param));
  }

  //内部関数

  /**
   * 「短期入所療養介護（基準適合診療所型）食費基準合計処理」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // 短期入所療養介護（基準適合診療所型）食費基準合計処理
    // 下記のテキストフィールドに入力されている値を合計しshortStayRecuperateCareStandardDinnerStandeirdMoneyTotal（食費基準額・合計テキストフィールド）に値を代入する。
    // ・shortStayRecuperateCareStandardMorningDinnerStandeirdMoney(食費基準額・朝・テキスト)
    // ・shortStayRecuperateCareStandardNoonDinnerStandeirdMoney(食費基準額・昼・テキスト)
    // ・shortStayRecuperateCareStandardNightDinnerStandeirdMoney(食費基準額・夜・テキスト)
	int valMorning = 0;
	int valNoon = 0;
	int valNight = 0;
	
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareStandardMorningDinnerStandeirdMoney().getText())){
		valMorning = ACCastUtilities.toInt(getShortStayRecuperateCareStandardMorningDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareStandardNoonDinnerStandeirdMoney().getText())){
		valNoon = ACCastUtilities.toInt(getShortStayRecuperateCareStandardNoonDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareStandardNightDinnerStandeirdMoney().getText())){
		valNoon = ACCastUtilities.toInt(getShortStayRecuperateCareStandardNightDinnerStandeirdMoney().getText());
	}
	
	int valTotal = valMorning + valNoon + valNight;
	
	if(valTotal == 0){
		getShortStayRecuperateCareStandardDinnerStandeirdMoneyTotal().setText("");
	}else{
		getShortStayRecuperateCareStandardDinnerStandeirdMoneyTotal().setText(ACCastUtilities.toString(valTotal));
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
	getShortStayStandardAgreementRecuperationDiscountRate().setText("0");

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
    // ・shortStayStandardAgreementRecuperationDiscountRate（割引率）　※errMsg = 割引率
    if(ACTextUtilities.isNullText(getShortStayStandardAgreementRecuperationDiscountRate().getText())){
    	errMsg = "割引率";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayStandardAgreementRecuperationDiscountRate().requestFocus();
    	return false;
    }

    // 割引率の値をチェックする。
    int reductRate = ACCastUtilities.toInt(getShortStayStandardAgreementRecuperationDiscountRate().getText());
    if(reductRate > 100){
    	// 100を超える値が入力されていた場合
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // エラーが発生したインスタンスにフォーカスを当てる。
    	getShortStayStandardAgreementRecuperationDiscountRate().requestFocus();
	    return false;    	
    }   
    
    // 下記のラジオグループに対して選択チェックを行う。未選択だった場合は errMsg にメッセージを格納する。
    // ・shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem（送迎体制ラジオグループ）　※errMsg = 送迎体制
    if(!getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem().isSelected()){
    	errMsg = "送迎体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem().requestFocus();
        return false;
    }
        
    // ・shortStayStandardAgreementRecuperationNutritionManageRadio（栄養管理体制ラジオグループ）　※errMsg = 栄養管理体制
    if(!getShortStayStandardAgreementRecuperationNutritionManageRadio().isSelected()){
    	errMsg = "栄養管理体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayStandardAgreementRecuperationNutritionManageRadio().requestFocus();
        return false;
    }
        
    // ・shortStayStandardAgreementRecuperationRecuperateRadio（療養食体制ラジオグループ）　※errMsg = 療養食体制
    if(!getShortStayStandardAgreementRecuperationRecuperateRadio().isSelected()){
    	errMsg = "療養食体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayStandardAgreementRecuperationRecuperateRadio().requestFocus();
        return false;
    }
        
    // ・shortStayStandardAgreementRecuperationStaffReduceRadio（人員減算ラジオグループ）　※errMsg = 人員減算
    if(!getShortStayStandardAgreementRecuperationStaffReduceRadio().isSelected()){
    	errMsg = "人員減算";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayStandardAgreementRecuperationStaffReduceRadio().requestFocus();
        return false;
    }

    // ・shortStayRecuperateCareStandardMorningDinnerStandeirdMoney（食費基準額・朝）　※errMsg = 食費基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareStandardMorningDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareStandardMorningDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareStandardNoonDinnerStandeirdMoney（食費基準額・昼）　※errMsg = 食費基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareStandardNoonDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareStandardNoonDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareStandardNightDinnerStandeirdMoney（食費基準額・夜）　※errMsg = 食費基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareStandardNightDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareStandardNightDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText　※ errMsg = ユニット型個室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyText().getText())){
    	errMsg = "ユニット型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText　※ errMsg = ユニット型準個室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText().getText())){
    	errMsg = "ユニット型準個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText　※ errMsg = 従来型個室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyText().getText())){
    	errMsg = "従来型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareStandardTasyouRoomText　※ errMsg = 多床室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareStandardTasyouRoomText().getText())){
    	errMsg = "多床室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareStandardTasyouRoomText().requestFocus();
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
