
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
 * 作成日: 2006/02/21  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 介護老人福祉施設 (QO004118)
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;

/**
 * 介護老人福祉施設(QO004118) 
 */
public class QO004118 extends QO004118Event {
  /**
   * コンストラクタです。
   */
  public QO004118(){
  }

  //コンポーネントイベント

  /**
   * 「画面状態設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void facilitiesDivisionSelectionChanged(ListSelectionEvent e)
			throws Exception {
		// 画面状態設定
		setState();
	}

  /**
   * 「食費基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void dinnerMorningFocusLost(FocusEvent e) throws Exception{
    // 食費基準額合計表示処理
    // 食費基準額を合計し結果を合計テキストフィールドに代入する
    totalDinnerMoney();

  }

  /**
   * 「食費基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void dinnerNoonFocusLost(FocusEvent e) throws Exception{
    // 食費基準額合計表示処理
    // 食費基準額を合計し結果を合計テキストフィールドに代入する
    totalDinnerMoney();

  }

  /**
   * 「食費基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void dinnerNightFocusLost(FocusEvent e) throws Exception{
    // 食費基準額合計表示処理
    // 食費基準額を合計し結果を合計テキストフィールドに代入する
    totalDinnerMoney();

  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO004118.class.getName(), param));
  }

  //内部関数

  /**
   * 「食費基準額合計表示処理」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void totalDinnerMoney() throws Exception{
    // 食費基準額合計処理
    // 下記のテキストフィールドの入力されている値を合計し dinnerTotal （食費基準額・合計テキストフィールド）に値を代入する。
    // ・dinnerMorning(食費基準額・朝・テキスト)
    // ・dinnerNoon(食費基準額・昼・テキスト)
    // ・dinnerNight(食費基準額・夜・テキスト)
	  
//	if(ACTextUtilities.isNullText(getDinnerTotal().getText())){
//		int valMorning = 0;
//		int valNoon = 0;
//		int valNight = 0;
//		
//		if(!ACTextUtilities.isNullText(getDinnerMorning().getText())){
//			valMorning = ACCastUtilities.toInt(getDinnerMorning().getText());
//		}
//		if(!ACTextUtilities.isNullText(getDinnerNoon().getText())){
//			valNoon = ACCastUtilities.toInt(getDinnerNoon().getText());
//		}
//		if(!ACTextUtilities.isNullText(getDinnerNight().getText())){
//			valNight = ACCastUtilities.toInt(getDinnerNight().getText());
//		}
//		
//		int valTotal = valMorning + valNoon + valNight;
//		
//		if(valTotal == 0){
//			getDinnerTotal().setText("");
//		}else{
//			getDinnerTotal().setText(ACCastUtilities.toString(valTotal));
//		}
//	}
  }

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
    // ※初期化
    // ※初期値設定
    // 割引率テキストに初期値0を代入する。
	// 施設区分の初期値として、「介護福祉施設」を選択する。
	// 夜間勤務条件基準の初期値として、「基準型」を選択する。
	// 個別機能訓練指導体制の初期値として、「なし」を選択する。
	// 常勤専従医師配置の初期値として、「なし」を選択する。
	// 精神科医師定期的療養指導の初期値として、「なし」を選択する。
	// 障害者生活支援体制の初期値として、「なし」を選択する。
	// 栄養管理体制の初期値として、「なし」を選択する。
	// 栄養マネジメント体制の初期値として、「なし」を選択する。
	// 経口移行体制の初期値として、「なし」を選択する。
	// 療養食体制の初期値として、「なし」を選択する。
	// ユニットケアの整備の初期値として、「未整備」を選択する。
	// 準ユニットケア体制の初期値として、「なし」を選択する。
	// 重度化対応体制の初期値として、「なし」を選択する。
	// 身体拘束廃止未実施減算の初期値として、「なし」を選択する。
	// 人員減算の初期値として、「なし」を選択する。

	getReduceRate().setText("0");
//	getFacilitiesDivision().setSelectedIndex(1);
//	getNightWorkDivision().setSelectedIndex(1);
//	getFunctionTrainingGuidanceSystem().setSelectedIndex(1);
//	getStandingDoctorAssignment().setSelectedIndex(1);
//	getPsychiatristGuidance().setSelectedIndex(1);
//	getHandicappedPersonSupport().setSelectedIndex(1);
//	getNourishmentControlAdd().setSelectedIndex(1);
////	getNourishmentManagementAdd().setSelectedIndex(1);
////	getOralSwitch().setSelectedIndex(1);
////	getRecuperatDinner().setSelectedIndex(1);
//	getUnitCareMaintenance().setSelectedIndex(1);
//	getSemiUnitCareMaintenance().setSelectedIndex(1);
//	getHeavilyCorrespondenceAdd().setSelectedIndex(1);
//	getBodyRestraintAbolition().setSelectedIndex(1);
//	getStaffLack().setSelectedIndex(1);
//	getTerminalCare().setSelectedIndex(1);
//	getHomeAndFacility().setSelectedIndex(1);
	QkanCommon.selectFirstRadioItem(getMainGroup());

	// 食費・居住費の取得と表示
	VRMap param = new VRHashMap();
	VRBindPathParser.set("SYSTEM_DATE", param, QkanSystemInformation
			.getInstance().getSystemDate());
	String strSql = getSQL_GET_RESIDENCE_FOOD(param);
	VRList residenceFood = getDBManager().executeQuery(strSql);

	if (residenceFood != null) {
		for (int i = 0; i < residenceFood.size(); i++) {
			VRMap temp = (VRMap) residenceFood.get(i);
			int id = ACCastUtilities.toInt(VRBindPathParser.get(
					"RESIDENCE_FOOD_COST_ID", temp));
			String cost = ACCastUtilities.toString(VRBindPathParser.get(
					"RESIDENCE_FOOD_COST", temp));

			switch (id) {
			// 食費
			case 1:
				getDinnerTotal().setText(cost);
				break;
			// ユニット個室
			case 2:
				getUnitRoom().setText(cost);
				break;
			// ユニット準個室
			case 3:
				getUnitSemiRoom().setText(cost);
				break;
			// 従来型個室
			case 4:
				getNormalRoom().setText(cost);
				break;
			// 多床室
			case 6:
				getTasyouRoom().setText(cost);
				break;
			}

		}
	}	
  }

  /**
   * 「入力チェック」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public boolean isValidInput() throws Exception{
    // ※入力チェック
    // エラーメッセージ文言格納用に errMsg　を作成する。
    String errMsg = null;
    
    // 下記のラジオグループに対して選択チェックを行う。未選択だった場合は errMsg にメッセージを格納する。
    // ・facilitiesDivision（施設区分ラジオグループ）
    // ※ errMsg = 施設区分
    if(!getFacilitiesDivision().isSelected()){
        getTab().setSelectedIndex(0);
    	errMsg = "施設区分";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getFacilitiesDivision().requestFocus();
    	return false;
    }
    
    // ・nightWorkDivision（夜間勤務条件基準ラジオグループ）
    // ※ errMsg = 夜間勤務条件基準
    if(!getNightWorkDivision().isSelected()){
        getTab().setSelectedIndex(0);
    	errMsg = "夜間勤務条件基準";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getNightWorkDivision().requestFocus();
    	return false;
    }
    
    // ・functionTrainingGuidanceSystem（個別機能訓練指導体制ラジオグループ）
    // ※ errMsg = 個別機能訓練指導体制
    if(!getFunctionTrainingGuidanceSystem().isSelected()){
        getTab().setSelectedIndex(0);
    	errMsg = "個別機能訓練指導体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getFunctionTrainingGuidanceSystem().requestFocus();
    	return false;
    }
    
    // ・standingDoctorAssignment（常勤専従医師配置ラジオグループ）
    // ※errMsg = 常勤専従医師配置
    if(!getStandingDoctorAssignment().isSelected()){
        getTab().setSelectedIndex(0);
    	errMsg = "常勤専従医師配置";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getStandingDoctorAssignment().requestFocus();
    	return false;
    }
    
    // ・psychiatristGuidance（精神科医師定期的療養指導ラジオグループ）
    // ※errMsg = 精神科医定期的療養指導
    if(!getPsychiatristGuidance().isSelected()){
        getTab().setSelectedIndex(0);
    	errMsg = "精神科医定期的療養指導";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getPsychiatristGuidance().requestFocus();
    	return false;
    }
    
    // ・handicappedPersonSupport（障害者生活支援体制ラジオグループ）
    // ※errMsg = 障害者生活支援体制
    if(!getHandicappedPersonSupport().isSelected()){
        getTab().setSelectedIndex(0);
    	errMsg = "障害者生活支援体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getHandicappedPersonSupport().requestFocus();
    	return false;
    }
    
    // ・nourishmentControlAdd（栄養管理体制ラジオグループ栄養管理体制ラジオグループ）
    // ※errMsg = 栄養管理体制
    if(!getNourishmentControlAdd().isSelected()){
        getTab().setSelectedIndex(0);
    	errMsg = "栄養管理体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getNourishmentControlAdd().requestFocus();
    	return false;
    }
    
    // ・nourishmentManagementAdd（栄養ケア・マネジメント体制ラジオグループ）
    // ※errMsg = 栄養ケア・マネジメント体制
    if(!getNourishmentManagementAdd().isSelected()){
        getTab().setSelectedIndex(0);
    	errMsg = "栄養ケア・マネジメント体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getNourishmentManagementAdd().requestFocus();
    	return false;
    }
//    
//    // ・oralSwitch（経口移行体制ラジオグループ）
//    // ※errMsg = 経口移行体制
//    if(!getOralSwitch().isSelected()){
//        getTab().setSelectedIndex(0);
//    	errMsg = "経口移行体制";
//    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
//    	getOralSwitch().requestFocus();
//    	return false;
//    }
//    
//    // ・recuperatDinner（療養食体制ラジオグループ）
//    // ※errMsg = 療養食体制
//    if(!getRecuperatDinner().isSelected()){
//        getTab().setSelectedIndex(0);
//    	errMsg = "療養食体制";
//    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
//    	getRecuperatDinner().requestFocus();
//    	return false;
//    }
    
    // ・unitCareMaintenance（ユニットケアの整備ラジオグループ）
    // ※errMsg = ユニットケアの整備
    if(getUnitCareMaintenance().isEnabled()){
	    if(!getUnitCareMaintenance().isSelected()){
	        getTab().setSelectedIndex(0);
	    	errMsg = "ユニットケアの整備";
	    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
	    	getUnitCareMaintenance().requestFocus();
	    	return false;
	    }
    }
    
    // ・semiUnitCareMaintenance（準ユニットケア体制ラジオグループ）
    // ※errMsg = 準ユニットケア体制
    if(!getSemiUnitCareMaintenance().isSelected()){
        getTab().setSelectedIndex(0);
    	errMsg = "準ユニットケア体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getSemiUnitCareMaintenance().requestFocus();
    	return false;
    }
    
    // ・heavilyCorrespondenceAdd（重度化対応体制ラジオグループ）
    // ※errMsg = 重度化対応体制
    if(!getHeavilyCorrespondenceAdd().isSelected()){
        getTab().setSelectedIndex(1);
    	errMsg = "重度化対応体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getHeavilyCorrespondenceAdd().requestFocus();
    	return false;
    }
    
    // ・bodyRestraintAbolition（身体拘束廃止未実施減算ラジオグループ）
    // ※errMsg = 身体拘束廃止未実施減算
    if(!getBodyRestraintAbolition().isSelected()){
        getTab().setSelectedIndex(1);
    	errMsg = "身体拘束廃止未実施減算";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getBodyRestraintAbolition().requestFocus();
    	return false;
    }
    
    // ・staffLack（人員減算ラジオグループ）
    // ※errMsg = 人員減算
    if(!getStaffLack().isSelected()){
        getTab().setSelectedIndex(1);
    	errMsg = "人員減算";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getStaffLack().requestFocus();
    	return false;
    }
    
//    // ・dinnerMorning（食費基準額・朝テキスト）※ errMsg = 食費基準額
//    if(ACTextUtilities.isNullText(getDinnerMorning().getText())){
//        getTab().setSelectedIndex(1);
//    	errMsg = "食費基準額";
//        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//        getDinnerMorning().requestFocus();
//    	return false;
//    }
//
//    // ・dinnerNoon（食費基準額・昼テキスト）※ errMsg = 食費基準額
//    if(ACTextUtilities.isNullText(getDinnerNoon().getText())){
//        getTab().setSelectedIndex(1);
//    	errMsg = "食費基準額";
//        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//        getDinnerNoon().requestFocus();
//    	return false;
//    }
//
//    // ・dinnerNight（食費基準額・夜テキスト）※ errMsg = 食費基準額
//    if(ACTextUtilities.isNullText(getDinnerNight().getText())){
//        getTab().setSelectedIndex(1);
//    	errMsg = "食費基準額";
//        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//        getDinnerNight().requestFocus();
//    	return false;
//    }
//
//    // ・unitRoom※ errMsg = ユニット型個室基準額
//    if(ACTextUtilities.isNullText(getUnitRoom().getText())){
//        getTab().setSelectedIndex(1);
//    	errMsg = "ユニット型個室基準額";
//        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//        getUnitRoom().requestFocus();
//    	return false;
//    }
//
//    // ・unitSemiRoom※ errMsg = ユニット型準個室基準額
//    if(ACTextUtilities.isNullText(getUnitSemiRoom().getText())){
//        getTab().setSelectedIndex(1);
//    	errMsg = "ユニット型準個室基準額";
//        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//        getUnitSemiRoom().requestFocus();
//    	return false;
//    }
//
//    // ・normalRoom※ errMsg = 従来型個室基準額
//    if(ACTextUtilities.isNullText(getNormalRoom().getText())){
//        getTab().setSelectedIndex(1);
//    	errMsg = "従来型個室基準額";
//        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//        getNormalRoom().requestFocus();
//    	return false;
//    }
//
//    // ・tasyouRoom※ errMsg = 多床室基準額
//    if(ACTextUtilities.isNullText(getTasyouRoom().getText())){
//        getTab().setSelectedIndex(1);
//    	errMsg = "多床室基準額";
//        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//        getTasyouRoom().requestFocus();
//    	return false;
//    }

    // 下記のテキストフィールドに対して入力チェックを行う。未入力だった場合は errMsg にメッセージを格納する。
    // ・reduceRate（割引率テキスト）　※errMsg = 割引率
    if(ACTextUtilities.isNullText(getReduceRate().getText())){
        getTab().setSelectedIndex(0);
    	errMsg = "割引率";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
    	getReduceRate().requestFocus();
    	return false;
    }

    // 割引率の値をチェックする。
    int reduceRate = ACCastUtilities.toInt(getReduceRate().getText());
    if(reduceRate > 100){
    	// 100を超える値が入力されていた場合
        getTab().setSelectedIndex(0);
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // エラーが発生したインスタンスにフォーカスを当てる。
    	getReduceRate().requestFocus();
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
	// ※パネル状態制御
	if (state) {
		// 引数としてtrueが渡された場合
		// 状態ID：SET_PANEL_TRUE
		setState_SET_PANEL_TRUE();
		
		setState();
		
	} else {
		// 引数としてfalseが渡された場合
		// 状態ID：SET_PANEL_FALSE
		setState_SET_PANEL_FALSE();
	}
  }

  /**
   * 「パネルデータ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   */
  public void getDetails(VRMap map) throws Exception{
	  // パネルデータ取得
	  
	  getMainGroup().setSource(map);
	  getMainGroup().applySource();
	  
	  // 無効状態のコントロールのデータを削除する。
	  removeInvalidData(map);
	  
  }

  /**
   * 「無効データ削除」に関する処理を行ないます。
   *
   * @param map VRMap
   * @throws Exception 処理例外
   */
  public void removeInvalidData(VRMap map) throws Exception{
	  // 無効データ削除
	  
	  // 以下のコントロールが無効状態の場合、以下のKEYをmapより削除する。
	  // ・unitCareMaintenance 削除KEY：1510121
      QkanCommon.removeDisabledBindPath(getMainGroup(), map);
	  	  
  }

  /**
   * 「状態制御」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  public void setState() throws Exception {
	  
	  // 画面の状態を制御する。
	  setStateByFacilitiesDivision();
	  
      nurseStructuralAddRadioGroupSelectionChanged(null);
  }
  
  /**
   * 「施設区分による状態制御」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  public void setStateByFacilitiesDivision() throws Exception {

		// 施設区分の値をチェックする。
		if (getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_FUKUSHI
				|| getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_SHOKIBO_FUKUSHI) {
			// 「介護老人福祉施設」「小規模介護老人福祉施設」が選択された場合
			setState_FACILITY_TYPE_NORMAL();
		} else {
			// 「介護老人福祉施設」「小規模介護老人福祉施設」以外が選択された場合
			setState_FACILITY_TYPE_UNIT();
		}
	}

  /**
   * 「看護体制加算に伴う画面状態設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void nurseStructuralAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 看護体制加算に伴う画面状態設定処理
        switch (getNurseStructuralAddRadioGroup().getSelectedIndex()) {
        case 2:
            // 「あり」が選択された場合
            // 状態ID：VALID_NIGHT_NURSE
            setState_VALID_NIGHT_NURSE();
            break;
        default:
            // 「あり」以外が選択された場合
            // 状態ID：INVALID_NIGHT_NURSE
            setState_INVALID_NIGHT_NURSE();
        }
    }

}
