
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
 * プログラム 短期入所療養介護（認知症疾患型） (QO004012)
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
 * 短期入所療養介護（認知症疾患型）(QO004012) 
 */
public class QO004012 extends QO004012Event {
  /**
   * コンストラクタです。
   */
  public QO004012(){
  }

  //コンポーネントイベント

  /**
   * 「短期入所療養介護（認知症疾患型）食費基準合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（認知症疾患型）食費基準合計表示処理
    // 短期入所療養介護（認知症疾患型）食費基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  /**
   * 「短期入所療養介護（認知症疾患型）食費基準合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（認知症疾患型）食費基準合計表示処理
    // 短期入所療養介護（認知症疾患型）食費基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  /**
   * 「短期入所療養介護（認知症疾患型）食費基準合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayRecuperateCareCognitiveNightDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（認知症疾患型）食費基準合計表示処理
    // 短期入所療養介護（認知症疾患型）食費基準額を合計し結果を合計テキストフィールドに代入する
    dinnerStandeirdMoneyTotal();

  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO004012.class.getName(), param));
  }

  //内部関数

  /**
   * 「短期入所療養介護（認知症疾患型）食費基準合計処理」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // 短期入所療養介護（認知症疾患型）食費基準合計処理
    // 下記のテキストフィールドに入力されている値を合計し shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal（食費基準額・合計テキストフィールド）に値を代入する。
    // ・shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney(食費基準額・朝・テキスト)
    // ・shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney(食費基準額・昼・テキスト)
    // ・shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney(食費基準額・夜・テキスト)
	int valMorning = 0;
	int valNoon = 0;
	int valNight = 0;
	
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney().getText())){
		valMorning = ACCastUtilities.toInt(getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney().getText())){
		valNoon = ACCastUtilities.toInt(getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney().getText());
	}
	if(!ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney().getText())){
		valNight = ACCastUtilities.toInt(getShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney().getText());
	}
	
	int valTotal = valMorning + valNoon + valNight;
	
	if(valTotal == 0){
		getShortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal().setText("");
	}else{
		getShortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal().setText(ACCastUtilities.toString(valTotal));
	}

  }

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
    // ※初期化------------------------------------------------------
    // ※初期値設定------------------------------------------------------
    // ソースを生成し、パネル全体に設定する。
    // 画面に展開し、初期値を表示する。
	// 割引率テキストに初期値0を表示する。
	getShortStayDementiaDiseaseRecuperationDiscountRate().setText("0");
	
    // ※コンボアイテムの設定------------------------------------------------------
    // コードマスタより下記のデータを取得し、人員減算コンボの候補として設定する。
    // CODE_ID = 173
    VRList list = QkanCommon.getArrayFromMasterCode(CODE_STAFF_REDUCE, PATH_STAFF_REDUCE);
    getShortStayDementiaDiseaseRecuperationStaffReduce().setModel(list);
    
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
    // ・shortStayDementiaDiseaseRecuperationDiscountRate（割引率テキスト）　※errMsg = 割引率
    if(ACTextUtilities.isNullText(getShortStayDementiaDiseaseRecuperationDiscountRate().getText())){
    	errMsg = "割引率";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayDementiaDiseaseRecuperationDiscountRate().requestFocus();
    	return false;
    }

    // 割引率の値をチェックする。
    int reductRate = ACCastUtilities.toInt(getShortStayDementiaDiseaseRecuperationDiscountRate().getText());
    if(reductRate > 100){
    	// 100を超える値が入力されていた場合
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // エラーが発生したインスタンスにフォーカスを当てる。
    	getShortStayDementiaDiseaseRecuperationDiscountRate().requestFocus();
	    return false;    	
    }   
    
    // 下記のラジオグループに対して選択チェックを行う。未選択だった場合は errMsg にメッセージを格納する。
    // ・shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio（施設区分ラジオグループ）　※errMsg = 施設区分
    if(!getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio().isSelected()){
    	errMsg = "施設区分";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio().requestFocus();
        return false;
    }
        
    // ・shortStayDementiaDiseaseRecuperationStaffAssignmentDivision（人員配置区分ラジオグループ）　※errMsg = 人員配置区分
    if(!getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision().isSelected()){
    	errMsg = "人員配置区分";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision().requestFocus();
        return false;
    }
        
    // ・shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem（送迎体制ラジオグループ）　※errMsg = 送迎体制
    if(!getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem().isSelected()){
    	errMsg = "送迎体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem().requestFocus();
        return false;
    }
        
    // ・shortStayDementiaDiseaseRecuperationNutritionManageRadio（栄養管理体制ラジオグループ）　※errMsg = 栄養管理体制
    if(!getShortStayDementiaDiseaseRecuperationNutritionManageRadio().isSelected()){
    	errMsg = "栄養管理体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayDementiaDiseaseRecuperationNutritionManageRadio().requestFocus();
        return false;
    }
        
    // ・shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio（療養食体制ラジオグループ）　※errMsg = 療養食体制
    if(!getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio().isSelected()){
    	errMsg = "療養食体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio().requestFocus();
        return false;
    }
    
    // ・shortStayDementiaDiseaseRecuperationStaffReduce（人員減算コンボ）　※errMsg = 人員減算
    if(!getShortStayDementiaDiseaseRecuperationStaffReduce().isSelected()){
    	errMsg = "人員減算";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayDementiaDiseaseRecuperationStaffReduce().requestFocus();
        return false;
    }

    // ・shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney（食費基準額･朝）
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney（食費基準額・昼）
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney（食費基準額・夜）
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText　※ errMsg = ユニット型個室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText().getText())){
    	errMsg = "ユニット型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText　※ errMsg = ユニット型準個室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText().getText())){
    	errMsg = " ユニット型準個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText　※ errMsg = 従来型個室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText().getText())){
    	errMsg = " 従来型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText().requestFocus();
    	return false;
    }
    
    // ・shortStayRecuperateCareCognitiveTasyouRoomText　※ errMsg = 多床室基準額
    if(ACTextUtilities.isNullText(getShortStayRecuperateCareCognitiveTasyouRoomText().getText())){
    	errMsg = " 多床室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayRecuperateCareCognitiveTasyouRoomText().requestFocus();
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
