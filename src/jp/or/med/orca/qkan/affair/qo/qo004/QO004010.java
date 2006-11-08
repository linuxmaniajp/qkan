
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
 * 開発者: 上司　和善
 * 作成日: 2006/02/13  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 短期入所療養介護（病院療養型） (QO004010)
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
 * 短期入所療養介護（病院療養型）(QO004010) 
 */
public class QO004010 extends QO004010Event {
  /**
   * コンストラクタです。
   */
  public QO004010(){
  }

  //コンポーネントイベント

  /**
   * 「短期入所療養介護（療養型病院）食費基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（療養型病院）食費基準額合計表示処理
    // 短期入所療養介護（療養型病院）食費基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  /**
   * 「短期入所療養介護（療養型病院）食費基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（療養型病院）食費基準額合計表示処理
    // 短期入所療養介護（療養型病院）食費基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  /**
   * 「短期入所療養介護（療養型病院）食費基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayRecuperateCareHospitalNightDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（療養型病院）食費基準額合計表示処理
    // 短期入所療養介護（療養型病院）食費基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO004010.class.getName(), param));
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
    // ※初期化------------------------------------------------------
    // ※初期値設定------------------------------------------------------
	getShortStayHospitalRecuperationDiscountRate().setText("0");

    // ※コンボアイテムの設定------------------------------------------------------
    // コードマスタより下記のデータを取得し、人員減算コンボの候補として設定する。
    // CODE_ID = CODE_STAFF_REDUCE
    VRList list = QkanCommon.getArrayFromMasterCode(CODE_STAFF_REDUCE, PATH_STAFF_REDUCE);
    getShortStayHospitalRecuperationStaffReduce().setModel(list);
    
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
    // ・shortStayHospitalRecuperationDiscountRate（割引率）※ errMsg = 割引率
    if(ACTextUtilities.isNullText(getShortStayHospitalRecuperationDiscountRate().getText())){
    	errMsg = "割引率";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayHospitalRecuperationDiscountRate().requestFocus();
    	return false;
    }

    // 割引率の値をチェックする。
    int reductRate = ACCastUtilities.toInt(getShortStayHospitalRecuperationDiscountRate().getText());
    if(reductRate > 100){
    	// 100を超える値が入力されていた場合
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // エラーが発生したインスタンスにフォーカスを当てる。
    	getShortStayHospitalRecuperationDiscountRate().requestFocus();
	    return false;    	
    }   
    
    // 下記のラジオグループに対して選択チェックを行う。未選択だった場合は errMsg にメッセージを格納する。
    // ・shortStayHospitalRecuperationInstitutionDivisionRadio（施設区分ラジオグループ）　※errMsg = 施設区分
    if(!getShortStayHospitalRecuperationInstitutionDivisionRadio().isSelected()){
    	errMsg = "施設区分";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationInstitutionDivisionRadio().requestFocus();
        return false;
    }
    
    // ・shortStayHospitalRecuperationStaffAssignmentDivision（人員配置区分ラジオグループ）　※errMsg = 人員配置区分
    if(!getShortStayHospitalRecuperationStaffAssignmentDivision().isSelected()){
    	errMsg = "人員配置区分";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationStaffAssignmentDivision().requestFocus();
        return false;
    }
    
    // ・shortStayHospitalRecuperationNightShiftCondition（夜間勤務条件基準ラジオグループ）　※errMsg = 夜間勤務条件基準
    if(!getShortStayHospitalRecuperationNightShiftCondition().isSelected()){
    	errMsg = "夜間勤務条件基準";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationNightShiftCondition().requestFocus();
        return false;
    }
    
    // ・shortStayHospitalRecuperationRecuperationEnvironmental（療養環境基準ラジオグループ　※errMsg = 療養環境基準
    if(!getShortStayHospitalRecuperationRecuperationEnvironmental().isSelected()){
    	errMsg = "療養環境基準";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationRecuperationEnvironmental().requestFocus();
        return false;
    }
    
    // ・shortStayHospitalRecuperationDoctorsArrangement（医師の配置基準ラジオグループ）　※errMsg = 医師の配置基準
    if(!getShortStayHospitalRecuperationDoctorsArrangement().isSelected()){
    	errMsg = "医師の配置基準";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationDoctorsArrangement().requestFocus();
        return false;
    }
    
    // ・shortStayHospitalRecuperationMeetingAndSendingOffSystem（送迎体制ラジオグループ）　※errMsg = 送迎体制
    if(!getShortStayHospitalRecuperationMeetingAndSendingOffSystem().isSelected()){
    	errMsg = "送迎体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationMeetingAndSendingOffSystem().requestFocus();
        return false;
    }
    
    // ・shortStayHospitalRecuperationNutritionManageRadio（栄養管理体制ラジオグループ）　※errMsg = 栄養管理体制
    if(!getShortStayHospitalRecuperationNutritionManageRadio().isSelected()){
    	errMsg = "栄養管理体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationNutritionManageRadio().requestFocus();
        return false;
    }
    
    // ・shortStayHospitalRecuperationRecuperationRadio（療養食体制ラジオグループ）　※errMsg = 療養食体制
    if(!getShortStayHospitalRecuperationRecuperationRadio().isSelected()){
    	errMsg = "療養食体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationRecuperationRadio().requestFocus();
        return false;
    }
    
    // 下記のコンボの項目が選択されているかチェックを行う。未選択だった場合は errMsg　にメッセージを格納する。
    // ・shortStayHospitalRecuperationStaffReduce（人員減算コンボ）※ errMsg = 人員減算
    if(!getShortStayHospitalRecuperationStaffReduce().isSelected()){
    	errMsg = "人員減算";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayHospitalRecuperationStaffReduce().requestFocus();
        return false;
    }

    // ・shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney（食費基準額・朝）※ errMsg = 食費基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney（食費基準額・昼）※ errMsg = 食費基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney().requestFocus();
    	return false;
    }
	    
    // ・shortStayRecuperateCareHospitalNightDinnerStandeirdMoney（食費基準額・夜）※ errMsg =　食費基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalNightDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareHospitalNightDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText　※ errMsg = ユニット型個室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText().getText())){
    	errMsg = "ユニット型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText　※ errMsg = ユニット型準個室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText().getText())){
    	errMsg = "ユニット型準個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText　※ errMsg = 従来型個室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText().getText())){
    	errMsg = "従来型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareHospitalTasyouRoomText　※ errMsg = 多床室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalTasyouRoomText().getText())){
    	errMsg = "多床室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareHospitalTasyouRoomText().requestFocus();
    	return false;
    }
    
    return true;
    
  }

  /**
   * 「食費基準額合計処理」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // 食費基準額合計処理
    // 下記のテキストフィールドの入力されている値を合計し shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal（食費基準額・合計テキストフィールド）に値を代入する。
    // ・shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney(食費基準額・朝・テキスト)
    // ・shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney(食費基準額・昼・テキスト)
    // ・shortStayRecuperateCareHospitalNightDinnerStandeirdMoney(食費基準額・夜・テキスト)
	int valMorning = 0;
	int valNoon = 0;
	int valNight = 0;
	
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney().getText())){
		valMorning = ACCastUtilities.toInt(getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalNoonDinnerStandeirdMoney().getText())){
		valNoon = ACCastUtilities.toInt(getShortStayRecuperateCareHospitalNoonDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareHospitalNightDinnerStandeirdMoney().getText())){
    	valNight = ACCastUtilities.toInt(getShortStayRecuperateCareHospitalNightDinnerStandeirdMoney().getText());
	}
    
    int valTotal = valMorning + valNoon + valNight;
    
    if(valTotal == 0){
    	getShortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal().setText("");
    }else{
    	getShortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal().setText(ACCastUtilities.toString(valTotal));
    }
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
