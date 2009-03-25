
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
 * プログラム 短期入所療養介護（診療所療養型） (QO004112)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo004;

import java.awt.event.FocusEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 短期入所療養介護（診療所療養型）(QO004112) 
 */
public class QO004112 extends QO004112Event {
  /**
   * コンストラクタです。
   */
  public QO004112(){
  }

  //コンポーネントイベント

  /**
   * 「画面状態設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void facilitiesDivisionSelectionChanged(ListSelectionEvent e) throws Exception{
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
    ACFrame.debugStart(new ACAffairInfo(QO004112.class.getName(), param));
  }

  //内部関数

  /**
   * 「食費基準額合計表示処理」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void totalDinnerMoney() throws Exception {
		// 食費基準額合計処理
		// 下記のテキストフィールドの入力されている値を合計し dinnerTotal （食費基準額・合計テキストフィールド）に値を代入する。
		// ・dinnerMorning(食費基準額・朝・テキスト)
		// ・dinnerNoon(食費基準額・昼・テキスト)
		// ・dinnerNight(食費基準額・夜・テキスト)

//		if (ACTextUtilities.isNullText(getDinnerTotal().getText())) {
//			int valMorning = 0;
//			int valNoon = 0;
//			int valNight = 0;
//
//			if (!ACTextUtilities.isNullText(getDinnerMorning().getText())) {
//				valMorning = ACCastUtilities
//						.toInt(getDinnerMorning().getText());
//			}
//			if (!ACTextUtilities.isNullText(getDinnerNoon().getText())) {
//				valNoon = ACCastUtilities.toInt(getDinnerNoon().getText());
//			}
//			if (!ACTextUtilities.isNullText(getDinnerNight().getText())) {
//				valNight = ACCastUtilities.toInt(getDinnerNight().getText());
//			}
//
//			int valTotal = valMorning + valNoon + valNight;
//
//			if (valTotal == 0) {
//				getDinnerTotal().setText("");
//			} else {
//				getDinnerTotal().setText(ACCastUtilities.toString(valTotal));
//			}
//		}
	}

  /**
	 * 「初期化」に関する処理を行ないます。
	 * 
	 * @throws Exception 処理例外
	 */
  public void initialize() throws Exception{
    // ※初期化
    // ※初期値設定
    // 割引率テキストに初期値0を表示する。
	// 施設区分の初期値として「診療所」を選択する。
	// 人員配置区分の初期値として「Ⅰ型」を選択する。
	// 療養環境基準の初期値として「基準型」を選択する。
	// 送迎体制の初期値として「なし」を選択する。
	// 栄養管理体制の初期値として「なし」を選択する。
	// 療養食体制の初期値として「なし」を選択する。
	// ユニットケアの整備の初期値として「未整備」を選択する。
	// 緊急短期入所ネットワーク体制の初期値として「なし」を選択する。
	// 人員減算の初期値として「なし」を選択する。

	getReduceRate().setText("0");
	
	//	2008/3/19 H.Tanaka Del Sta H2004設備基準対応
//	getFacilitiesDivision().setSelectedIndex(1);
//	getStaffAssignmentDivision().setSelectedIndex(1);
//	getRecuperationEnvironmental().setSelectedIndex(1);
//	getMeetingAndSendingOffSystem().setSelectedIndex(1);
//	getNourishmentControlAdd().setSelectedIndex(1);
//	getRecuperatDinner().setSelectedIndex(1);
//	getUnitCareMaintenance().setSelectedIndex(1);
//	getEmergencyNetworkAdd().setSelectedIndex(1);
//	getStaffLack().setSelectedIndex(1);
	//	2008/3/19 H.Tanaka Del End 
	
	//	2008/3/19 H.Tanaka Add Sta H2004設備基準対応
	QkanCommon.selectFirstRadioItem(getMainGroup());
	//2008/3/19 H.Tanaka Add End 
	
	
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
    //2009/02/24 [ID:0000440][Tozo TANAKA] add begin - 平成21年4月法改正対応
    //＜平成21年4月法改正対応＞
    //療養食加算の初期値として「なし」を選択する。
    getMedicalFoodAddRadioGroup().setSelectedIndex(1);
    //若年性認知症利用者受入加算の初期値として「なし」を選択する。
    getYoungDementiaPatinetAddRadioGroup().setSelectedIndex(1);
    //サービス提供体制強化加算の初期値として「なし」を選択する。
    getServiceAddProvisionStructuralRadioGroup().setSelectedIndex(1);
    //2009/02/24 [ID:0000440][Tozo TANAKA] add end - 平成21年4月法改正対応
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
    	errMsg = "施設区分";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getFacilitiesDivision().requestFocus();
    	return false;
    }
    
    // ・staffAssignmentDivision（人員配置区分ラジオグループ）
    // ※errMsg = 人員配置区分
    if(getStaffAssignmentDivision().isEnabled()){
	    if(!getStaffAssignmentDivision().isSelected()){
	    	errMsg = "人員配置区分";
	    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
	    	getStaffAssignmentDivision().requestFocus();
	    	return false;
	    }
    }
    
    // ・recuperationEnvironmental（療養環境基準ラジオグループ）
    // ※errMsg = 療養環境基準
    if(!getRecuperationEnvironmental().isSelected()){
    	errMsg = "療養環境基準";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getRecuperationEnvironmental().requestFocus();
    	return false;
    }
    
    // ・meetingAndSendingOffSystem（送迎体制ラジオグループ）
    // ※ errMsg = 送迎体制
    if(!getMeetingAndSendingOffSystem().isSelected()){
    	errMsg = "送迎体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getMeetingAndSendingOffSystem().requestFocus();
    	return false;
    }
    
    // ・nourishmentControlAdd（栄養管理体制ラジオグループ）
    // ※ errMsg = 栄養管理体制
    if(!getNourishmentControlAdd().isSelected()){
    	errMsg = "栄養管理体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getNourishmentControlAdd().requestFocus();
    	return false;
    }
    
//    // ・recuperatDinner（療養食体制ラジオグループ）
//    // ※ errMsg = 療養食体制
//    if(!getRecuperatDinner().isSelected()){
//    	errMsg = "療養食体制";
//    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
//    	getRecuperatDinner().requestFocus();
//    	return false;
//    }
    
    // ・unitCareMaintenance（ユニットケアの整備ラジオグループ）
    // ※ errMsg = ユニットケアの整備
    if(getUnitCareMaintenance().isEnabled()){
	    if(!getUnitCareMaintenance().isSelected()){
	    	errMsg = "ユニットケアの整備";
	    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
	    	getUnitCareMaintenance().requestFocus();
	    	return false;
	    }
    }
    
    // ・emergencyNetworkAdd（緊急短期入所ネットワーク体制ラジオグループ）
    // ※ errMsg = 緊急短期入所ネットワーク体制
    if(!getEmergencyNetworkAdd().isSelected()){
    	errMsg = "緊急短期入所ネットワーク体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getEmergencyNetworkAdd().requestFocus();
    	return false;
    }
    
//    // ・staffLack（人員減算ラジオグループ）
//    // ※ errMsg = 人員減算
//    if(!getStaffLack().isSelected()){
//    	errMsg = "人員減算";
//    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
//    	getStaffLack().requestFocus();
//    	return false;
//    }
    
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
    // ・reduceRate（割引率テキスト）※ errMsg = 割引率
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
	  // ・staffAssignmentDivision　削除KEY：1230202
	  // ・unitCareMaintenance　削除KEY：1230216
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
	  
  }
  
  /**
   * 「施設区分による状態制御」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  public void setStateByFacilitiesDivision() throws Exception{

	  // 施設区分の値をチェックする。
	  if(getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_SHINRYOJO){
		// 施設区分の「診療所」が選択されている場合
		  setState_FACILITY_TYPE_NORMAL();
	  }else{
		// 施設区分の「診療所」以外が選択されている場合
		  setState_FACILITY_TYPE_UNIT();
	  }
  }
}
