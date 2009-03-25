
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
 * プログラム 介護療養型医療施設（認知症疾患型） (QO004122)
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
 * 介護療養型医療施設（認知症疾患型）(QO004122) 
 */
public class QO004122 extends QO004122Event {
  /**
   * コンストラクタです。
   */
  public QO004122(){
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
   * 「画面状態設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void hospitalDivisionSelectionChanged(ListSelectionEvent e) throws Exception{
		// 画面状態設定
		setState();
	  
  	}

  /**
   * 「画面状態設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void staffLackActionPerformed(ActionEvent e) throws Exception {
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
    ACFrame.debugStart(new ACAffairInfo(QO004122.class.getName(), param));
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

//	    // ※コンボアイテムの設定
//	    // コードマスタより下記のデータを取得する。
//	    // CODE_ID = CODE_STAFF_REDUCE
//	    VRList list = QkanCommon.getArrayFromMasterCode(CODE_STAFF_REDUCE, PATH_STAFF_REDUCE);
//	    
//	    // 取得したデータを人員減算コンボの候補として設定する。
//	    getStaffLack().setModel(list);

    // ※初期値設定
    // 割引率テキストに初期値0を代入する。
	// 施設区分の初期値として、「認知症疾患型」を選択する。
	// 病院区分の初期値として、「大学病院」を選択する。
	// 人員配置区分の初期値として、「�T型」を選択する。
	// 栄養管理体制の初期値として、「なし」を選択する。
	// 栄養マネジメント体制の初期値として、「なし」を選択する。
	// 経口移行体制の初期値として、「なし」を選択する。
	// 療養食体制の初期値として、「なし」を選択する。
	// ユニットケアの整備の初期値として、「未整備」を選択する。
	// 身体拘束廃止未実施減算の初期値として、「なし」を選択する。
	// 人員減算の初期値として、「なし」を選択する。

	getReduceRate().setText("0");
//	getFacilitiesDivision().setSelectedIndex(1);
//	getHospitalDivision().setSelectedIndex(1);
//	getStaffAssignmentDivision().setSelectedIndex(1);
//	getNourishmentControlAdd().setSelectedIndex(1);
//	getNourishmentManagementAdd().setSelectedIndex(1);
//	getOralSwitch().setSelectedIndex(1);
//	getRecuperatDinner().setSelectedIndex(1);
//	getUnitCareMaintenance().setSelectedIndex(1);
//	getBodyRestraintAbolition().setSelectedIndex(1);
//	getStaffLack().setSelectedIndex(0);
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
			case 5:
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
    // ・facilitiesDivision（施設区分） 
    // ※errMsg = 施設区分
    if(!getFacilitiesDivision().isSelected()){
    	errMsg = "施設区分";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getFacilitiesDivision().requestFocus();
    	return false;
    }
    
//    // ・hospitalDivision（病院区分ラジオグループ）
//    // ※errMsg = 病院区分
//    if(getHospitalDivision().isEnabled()){
//	    if(!getHospitalDivision().isSelected()){
//	    	errMsg = "病院区分";
//	    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
//	    	getHospitalDivision().requestFocus();
//	    	return false;
//	    }
//    }
    
    // ・staffAssignmentDivision（人員配置区分ラジオグループ）
    // ※errMsg = 人員配置区分
    if(getStaffAssignmentDivision().isEnabled()){
	    if(!getStaffAssignmentDivision().isSelected()){
	    	errMsg = "人員配置区分";
	    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
	    	getStaffAssignmentDivision().requestFocus();
	    	return false;
	    }
		// 選択されている項目が無効状態の場合、選択していないとみなす。
	    if(!(getStaffAssignmentDivision().getSelectedButton()).isEnabled()){
			errMsg = "人員配置区分";
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			getStaffAssignmentDivision().requestFocus();
			return false;			
		}
    }
    
    // ・nourishmentControlAdd（栄養管理体制ラジオグループ栄養管理体制ラジオグループ）
    // ※errMsg = 栄養管理体制
    if(!getNourishmentControlAdd().isSelected()){
    	errMsg = "栄養管理体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getNourishmentControlAdd().requestFocus();
    	return false;
    }
    
    // ・nourishmentManagementAdd（栄養ケア・マネジメント体制ラジオグループ）
    // ※errMsg = 栄養ケア・マネジメント体制
    if(!getNourishmentManagementAdd().isSelected()){
    	errMsg = "栄養ケア・マネジメント体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getNourishmentManagementAdd().requestFocus();
    	return false;
    }
//    
//    // ・oralSwitch（経口移行体制ラジオグループ）
//    // ※errMsg = 経口移行体制
//    if(!getOralSwitch().isSelected()){
//    	errMsg = "経口移行体制";
//    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
//    	getOralSwitch().requestFocus();
//    	return false;
//    }
//    
//    // ・recuperatDinner（療養食体制ラジオグループ）
//    // ※errMsg = 療養食体制
//    if(!getRecuperatDinner().isSelected()){
//    	errMsg = "療養食体制";
//    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
//    	getRecuperatDinner().requestFocus();
//    	return false;
//    }
    
    // ・unitCareMaintenance（ユニットケアの整備ラジオグループ）
    // ※errMsg = ユニットケアの整備
    if(getUnitCareMaintenance().isEnabled()){
	    if(!getUnitCareMaintenance().isSelected()){
	    	errMsg = "ユニットケアの整備";
	    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
	    	getUnitCareMaintenance().requestFocus();
	    	return false;
	    }
    }
    
    // ・bodyRestraintAbolition（身体拘束廃止未実施減算ラジオグループ）
    // ※errMsg = 身体拘束廃止未実施減算
    if(!getBodyRestraintAbolition().isSelected()){
    	errMsg = "身体拘束廃止未実施減算";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getBodyRestraintAbolition().requestFocus();
    	return false;
    }
    
    // 下記のコンボに対して選択チェックを行う。未選択だった場合は errMsg にメッセージを格納する。
    // ・staffLack（人員減算コンボ）※errMsg = 人員減算
    if(!getStaffLack().isSelected()){
    	errMsg = "人員減算";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getStaffLack().requestFocus();
    	return false;
    }
    
//    // ・dinnerMorning（食費基準額・朝テキスト）※ errMsg = 食費基準額
//    if(ACTextUtilities.isNullText(getDinnerMorning().getText())){
//    	errMsg = "食費基準額";
//        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//        getDinnerMorning().requestFocus();
//    	return false;
//    }
//
//    // ・dinnerNoon（食費基準額・昼テキスト）※ errMsg = 食費基準額
//    if(ACTextUtilities.isNullText(getDinnerNoon().getText())){
//    	errMsg = "食費基準額";
//        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//        getDinnerNoon().requestFocus();
//    	return false;
//    }
//
//    // ・dinnerNight（食費基準額・夜テキスト）※ errMsg = 食費基準額
//    if(ACTextUtilities.isNullText(getDinnerNight().getText())){
//    	errMsg = "食費基準額";
//        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//        getDinnerNight().requestFocus();
//    	return false;
//    }
//
//    // ・unitRoom※ errMsg = ユニット型個室基準額
//    if(ACTextUtilities.isNullText(getUnitRoom().getText())){
//    	errMsg = "ユニット型個室基準額";
//        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//        getUnitRoom().requestFocus();
//    	return false;
//    }
//
//    // ・unitSemiRoom※ errMsg = ユニット型準個室基準額
//    if(ACTextUtilities.isNullText(getUnitSemiRoom().getText())){
//    	errMsg = "ユニット型準個室基準額";
//        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//        getUnitSemiRoom().requestFocus();
//    	return false;
//    }
//
//    // ・normalRoom※ errMsg = 従来型個室基準額
//    if(ACTextUtilities.isNullText(getNormalRoom().getText())){
//    	errMsg = "従来型個室基準額";
//        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//        getNormalRoom().requestFocus();
//    	return false;
//    }
//
//    // ・tasyouRoom※ errMsg = 多床室基準額
//    if(ACTextUtilities.isNullText(getTasyouRoom().getText())){
//    	errMsg = "多床室基準額";
//        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//        getTasyouRoom().requestFocus();
//    	return false;
//    }

    // 下記のテキストフィールドに対して入力チェックを行う。未入力だった場合は errMsg にメッセージを格納する。
    // ・reduceRate（割引率テキスト）　※errMsg = 割引率
    if(ACTextUtilities.isNullText(getReduceRate().getText())){
    	errMsg = "割引率";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
    	getReduceRate().requestFocus();
    	return false;
    }

    // 割引率の値をチェックする。
    int reduceRate = ACCastUtilities.toInt(getReduceRate().getText());
    if(reduceRate > 100){
    	// 100を超える値が入力されていた場合
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
	  // ・hospitalDivision 削除KEY：1530318
	  // ・staffAssignmentDivision 削除KEY：1530302
	  // ・unitCareMaintenance 削除KEY：1530316
//	  if(!getHospitalDivision().isEnabled()){
//		  map.removeData("1530318");
//	  }
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
//	  setStateByHospitalDivision();
//	  setStateByStaffLack();
	  
  }
  
  /**
   * 「施設区分による状態制御」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  public void setStateByFacilitiesDivision() throws Exception {

		// 施設区分の値をチェックする。
	  	int facilityType =getFacilitiesDivision().getSelectedIndex(); 
		if (facilityType == FACILITY_TYPE_NINCHISHO) {
			// 「認知症疾患型」が選択された場合
			setState_FACILITY_TYPE_NORMAL();			
		} else if(facilityType == FACILITY_TYPE_UNIT){
			// 「ユニット型」が選択された場合
			setState_FACILITY_TYPE_UNIT();
		}else{
			// 「経過型」が選択された場合
			setState_FACILITY_TYPE_PASSAGE();
		}
	}

//  /**
//   * 「病院区分による状態制御」イベントです。
//   * @param e イベント情報
//   * @throws Exception 処理例外
//   */
//  public void setStateByHospitalDivision() throws Exception {
//
//		// 施設区分において、病院以外が選択されている場合
//		if (getFacilitiesDivision().getSelectedIndex() != FACILITY_TYPE_NINCHISHO) {
//			return;
//		}
//
//		// 病院区分の値をチェックする。
//		if (getHospitalDivision().getSelectedIndex() == HOSPITAL_TYPE_UNIVERSITY) {
//			// 「大学病院」が選択された場合
//			setState_UNIVERSITY_HOSPITAL();
//		} else {
//			// 「大学病院」以外が選択された場合
//			setState_NORMAL_HOSPITAL();
//		} 			
//			  
//  }
  
//  /**
//   * 「人員減算による状態制御」イベントです。
//   * @param e イベント情報
//   * @throws Exception 処理例外
//   */
//  public void setStateByStaffLack() throws Exception {
//
//		// 施設区分において、認知症疾患型以外が選択されている場合
//		if (getFacilitiesDivision().getSelectedIndex() != FACILITY_TYPE_NINCHISHO) {
//			return;
//		}
//
//		// 病院区分において、大学病院が選択されている場合
//		if(getHospitalDivision().getSelectedIndex() == HOSPITAL_TYPE_UNIVERSITY){
//			return;
//		}
//		
//		// 人員減算の値をチェックする。
//		if (getStaffLack().getSelectedIndex() == STAFF_LACK_KANGO_KAIGO
//				|| getStaffLack().getSelectedIndex() == STAFF_LACK_SEIKAN
//				|| getStaffLack().getSelectedIndex() == STAFF_LACK_HEKICHI) {
//			// 以下の項目が選択された場合
//			// 「看護・介護職員が欠員の場合」
//			// 「正看比率が20%未満の場合」
//			// 「僻地の医師確保計画を届け出ているもの以外の病院の医師数が必要の60%未満の場合」
//			setState_STAFF_ASSIGNMENT_TYPE2();
//		} else {
//			// 上記以外の場合
//			setState_STAFF_ASSIGNMENT_TYPE1();
//		}
//
//	}
}
