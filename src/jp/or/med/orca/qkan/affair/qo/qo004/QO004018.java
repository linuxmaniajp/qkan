
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
 * プログラム 介護療養型医療施設（療養型病院） (QO004018)
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
 * 介護療養型医療施設（療養型病院）(QO004018) 
 */
public class QO004018 extends QO004018Event {
  /**
   * コンストラクタです。
   */
  public QO004018(){
  }

  //コンポーネントイベント

  /**
   * 「介護療養型医療施設（療養型病院）食費基準基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyFocusLost(FocusEvent e) throws Exception{
    // 介護療養型医療施設（療養型病院）食費基準額合計表示処理
    // 介護療養型医療施設（療養型病院）食費基準基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  /**
   * 「介護療養型医療施設（療養型病院）食費基準基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyFocusLost(FocusEvent e) throws Exception{
    // 介護療養型医療施設（療養型病院）食費基準額合計表示処理
    // 介護療養型医療施設（療養型病院）食費基準基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  /**
   * 「介護療養型医療施設（療養型病院）食費基準基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyFocusLost(FocusEvent e) throws Exception{
    // 介護療養型医療施設（療養型病院）食費基準額合計表示処理
    // 介護療養型医療施設（療養型病院）食費基準基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO004018.class.getName(), param));
  }

  //内部関数

  /**
   * 「介護療養型医療施設（療養型病院）食費基準基準額合計処理」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // 介護療養型医療施設（療養型病院）食費基準基準額合計処理
    // 下記のテキストフィールドに入力されている値を合計し
	// kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal（食費基準額・合計テキストフィールド）に値を代入する。
	// ・kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney(食費基準額・朝・テキスト)
	// ・kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney(食費基準額・昼・テキスト)
	// ・kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney(食費基準額・夜・テキスト)
	int valMorning = 0;
	int valNoon = 0;
	int valNight = 0;
	
	if(!ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney().getText())){
		valMorning = ACCastUtilities.toInt(getKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney().getText())){
		valNoon = ACCastUtilities.toInt(getKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney().getText())){
		valNight = ACCastUtilities.toInt(getKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney().getText());
	}
	
	int valTotal = valMorning + valNoon + valNight;
	
	if(valTotal == 0){
		getKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal().setText("");
	}else{
		getKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal().setText(ACCastUtilities.toString(valTotal));
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
    // ・kaigoRecuperationMedicalFacilitiesDiscountRate
	getKaigoRecuperationMedicalFacilitiesDiscountRate().setText("0");
	  
    // ※コンボアイテムの設定------------------------------------------------------
    // コードマスタより下記のデータを取得する。
    // CODE_ID = CODE_STAFF_REDUCE
    VRList list = QkanCommon.getArrayFromMasterCode(CODE_STAFF_REDUCE, PATH_STAFF_REDUCE);

    // 人員減算コンボに候補として設定する。
    getStaffReduce().setModel(list);

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
    // ・kaigoRecuperationMedicalFacilitiesDiscountRate（割引率）　※　errMsg = 割引率
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesDiscountRate().getText())){
    	errMsg = "割引率";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesDiscountRate().requestFocus();
    	return false;
    }

    // 割引率の値をチェックする。
    int reductRate = ACCastUtilities.toInt(getKaigoRecuperationMedicalFacilitiesDiscountRate().getText());
    if(reductRate > 100){
    	// 100を超える値が入力されていた場合
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // エラーが発生したインスタンスにフォーカスを当てる。
    	getKaigoRecuperationMedicalFacilitiesDiscountRate().requestFocus();
	    return false;    	
    }   
    
    // 下記のラジオグループに対して選択チェックを行う。未選択だった場合は errMsg にメッセージを格納する。
    // ・InstitutionDivisionRadio（施設区分） ※　errMsg = 施設区分
    if(!getInstitutionDivisionRadio().isSelected()){
    	errMsg = "施設区分";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getInstitutionDivisionRadio().requestFocus();
        return false;
    }
     
    // ・staffAssignmentDivision（人員配置区分ラジオグループ）　※errMsg = 人員配置区分
    if(!getStaffAssignmentDivision().isSelected()){
    	errMsg = "人員配置区分";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getStaffAssignmentDivision().requestFocus();
        return false;
    }
     
    // ・nightShiftCondition（夜間勤務条件基準）　※errMsg = 夜間勤務条件基準
    if(!getNightShiftCondition().isSelected()){
    	errMsg = "夜間勤務条件基準";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getNightShiftCondition().requestFocus();
        return false;
    }
     
    // ・recuperationEnvironmental（療養環境基準ラジオグループ）　※errMsg = 療養環境基準
    if(!getRecuperationEnvironmental().isSelected()){
    	errMsg = "療養環境基準";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getRecuperationEnvironmental().requestFocus();
        return false;
    }
     
    // ・doctorsArrangement（医師の配置基準ラジオグループ）　※errMsg = 医師の配置基準
    if(!getDoctorsArrangement().isSelected()){
    	errMsg = "医師の配置基準";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getDoctorsArrangement().requestFocus();
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
    
    // 下記のコンボの項目が選択されているかチェックを行う。未選択だった場合は errMsg　にメッセージを格納する。
    // ・staffReduce（人員配置区分）　※人員減算
    if(!getStaffReduce().isSelected()){
    	errMsg = "人員減算";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getStaffReduce().requestFocus();
        return false;
    }

    // ・kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney（食費基準額・朝）　※errMsg = 食費基準額
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney().requestFocus();
    	return false;
    }
    
    // ・kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney（食費基準額・昼）　※errMsg = 食費基準額
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney().requestFocus();
    	return false;
    }
    
    // ・kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney（食費基準額・夜）　※errMsg = 食費基準額
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney().requestFocus();
    	return false;
    }
    
    // ・kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText　※ errMsg = ユニット型個室基準額
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText().getText())){
    	errMsg = " ユニット型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText().requestFocus();
    	return false;
    }
    
    // ・kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText　※ errMsg = ユニット型準個室基準額
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText().getText())){
    	errMsg = " ユニット型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText().requestFocus();
    	return false;
    }
    
    // ・kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText　※ errMsg = 従来型個室基準額
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText().getText())){
    	errMsg = " 従来型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText().requestFocus();
    	return false;
    }
    
    // ・kaigoRecuperationMedicalFacilitiesTasyouRoomText　※ errMsg = 多床室基準額
    if(ACTextUtilities.isNullText(getKaigoRecuperationMedicalFacilitiesTasyouRoomText().getText())){
    	errMsg = " 多床室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getKaigoRecuperationMedicalFacilitiesTasyouRoomText().requestFocus();
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
