
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
 * 作成日: 2006/02/10  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 訪問看護 (QO004003)
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
 * 訪問看護(QO004003) 
 */
public class QO004003 extends QO004003Event {
  /**
   * コンストラクタです。
   */
  public QO004003(){
  }

  //コンポーネントイベント

  /**
   * 「訪問看護パネルEnable制御」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void homonkangoFacilitiesDivisionSelectionChanged(ListSelectionEvent e) throws Exception{
	  // ※訪問看護パネルのEnable制御を行う。------------------------------------------------------

	  // homonkangoFacilitiesDivision（施設区分ラジオ）の値をチェックする。
	  if(getHomonkangoFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_STATION){
		  // 値がFACILITY_TYPE_STATION（訪問看護ステーション）だった場合
		  // 画面状態を変更する。※Enable制御を行い編集可能にする。
		  setState_MEDICAL_INSURE_TRUE();
	  }else if(getHomonkangoFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_HOSPITAL){
		  // 値がFACILITY_TYPE_HOSPITAL（病院又は診療所）だった場合
		  // 画面状態を変更する。※Enable制御を行い編集不能にする。
		  setState_MEDICAL_INSURE_FALSE();
	  }
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO004003.class.getName(), param));
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
	  // ※初期化------------------------------------------------------
	  // ※初期値設定------------------------------------------------------
	  // 割引率テキストに初期値0を代入する。
	  // ・homonkangoDiscountRate
	  getHomonkangoDiscountRate().setText("0");

  }

  /**
   * 「入力チェック」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public boolean isValidInput() throws Exception{
    // ※入力チェック------------------------------------------------------
    // エラーメッセージ文言格納用に errMsg　を作成する。
    String errMsg = null;
    
    // 画面上のデータをバインドで取得 ※一部使用するため
    VRMap map = new VRHashMap();
    getHomonkangoGroup().setSource(map);
    getHomonkangoGroup().bindSource();
    
    // 下記のテキストフィールドに対して入力チェックを行う。未入力だった場合は errMsg にメッセージを格納する。
    // ・homonkangoDiscountRate（割引率テキスト）※errMsg = 割引率
    if(ACTextUtilities.isNullText(getHomonkangoDiscountRate().getText())){
    	errMsg = "割引率";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
    	getHomonkangoDiscountRate().requestFocus();
    	return false;
    }

    // 割引率の値をチェックする。
    int reductRate = ACCastUtilities.toInt(getHomonkangoDiscountRate().getText());
    if(reductRate > 100){
    	// 100を超える値が入力されていた場合
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // エラーが発生したインスタンスにフォーカスを当てる。
    	getHomonkangoDiscountRate().requestFocus();
	    return false;    	
    }   
    
    // 下記のラジオグループに対して選択チェックを行う。未選択だった場合は errMsg にメッセージを格納する。
    // ・homonkangoFacilitiesDivision（施設区分ラジオグループ）※ errMsg = 施設区分
    if(!getHomonkangoFacilitiesDivision().isSelected()){
    	errMsg = "施設区分";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getHomonkangoFacilitiesDivision().requestFocus();
        return false;
    }
    
    // ・homonkangoPressingRadio（緊急時訪問看護体制）※ errMsg = 緊急時訪問看護体制
    if(!getHomonkangoPressingRadio().isSelected()){
    	errMsg = "緊急時訪問看護体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getHomonkangoPressingRadio().requestFocus();
        return false;    	
    }
    
    // ・specialManagementSystem（特別管理体制ラジオグループ）※ errMsg = 特別管理体制
    if(!getSpecialManagementSystem().isSelected()){
    	errMsg = "特別管理体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getSpecialManagementSystem().requestFocus();
        return false;
    }

    // ・managerName（管理者氏名）※errMsg = 管理者氏名
    if(ACTextUtilities.isNullText(getManagerName().getText())){
    	errMsg = "管理者氏名";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getManagerName().requestFocus();
    	return false;
    }

//    // 施設区分の値がFACILITY_TYPE_STATIONの場合のみ
//    // ・medicalTreatmentInsuranceStationCode（ステーションコード）※errMsg = ステーションコード
//    if(getHomonkangoFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_STATION){
//	    if(ACTextUtilities.isNullText(getMedicalTreatmentInsuranceStationCode().getText())){
//	    	errMsg = "ステーションコード";
//	        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//	        getMedicalTreatmentInsuranceStationCode().requestFocus();
//	    	return false;
//	    }
//    }
    
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
