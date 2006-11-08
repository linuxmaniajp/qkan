
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
 * 作成日: 2006/02/10  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 通所リハ (QO004006)
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
 * 通所リハ(QO004006) 
 */
public class QO004006 extends QO004006Event {
  /**
   * コンストラクタです。
   */
  public QO004006(){
  }

  //コンポーネントイベント

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO004006.class.getName(), param));
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
    // ・tsuusyorehabilitationDiscountRate
	getTsuusyorehabilitationDiscountRate().setText("0");

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
    // ・tsuusyorehabilitationDiscountRate（割引率テキスト）※ errMsg = 割引率
    if(ACTextUtilities.isNullText(getTsuusyorehabilitationDiscountRate().getText())){
	    // 入力されていなかった場合
	    // エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT　引数 = errMsg
    	errMsg = "割引率";
	    QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
	    // エラーが発生したインスタンスにフォーカスを当てる。
	    getTsuusyorehabilitationDiscountRate().requestFocus();
	    return false;
    }

    // 割引率の値をチェックする。
    int reductRate = ACCastUtilities.toInt(getTsuusyorehabilitationDiscountRate().getText());
    if(reductRate > 100){
    	// 100を超える値が入力されていた場合
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // エラーが発生したインスタンスにフォーカスを当てる。
    	getTsuusyorehabilitationDiscountRate().requestFocus();
	    return false;    	
    }   
    
    // 下記のラジオグループに対して選択チェックを行う。未選択だった場合は errMsg にメッセージを格納する。
    // ・tsuusyorehabilitationFacilitiesDivision（施設区分ラジオグループ）※ errMsg = 施設区分
    if(!getTsuusyorehabilitationFacilitiesDivision().isSelected()){
    	errMsg = "施設区分";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getTsuusyorehabilitationFacilitiesDivision().requestFocus();
        return false;
    }
    
    // ・tsuusyorehabilitationBathingHelpSystem（入浴介助体制ラジオグループ）※ errMsg = 入浴介助体制
    if(!getTsuusyorehabilitationBathingHelpSystem().isSelected()){
    	errMsg = "入浴介助体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getTsuusyorehabilitationBathingHelpSystem().requestFocus();
        return false;
    }
    
    // ・tsuusyorehabilitationSpecialBathingHelpSystem（特別入浴介助体制ラジオグループ）※ errMsg = 特別入浴介助体制
    if(!getTsuusyorehabilitationSpecialBathingHelpSystem().isSelected()){
    	errMsg = "特別入浴介助体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getTsuusyorehabilitationSpecialBathingHelpSystem().requestFocus();
        return false;
    }
    
    // ・tsuusyorehabilitationMeetingAndSendingOffSystem（送迎体制ラジオグループ）※ errMsg = 送迎体制
    if(!getTsuusyorehabilitationMeetingAndSendingOffSystem().isSelected()){
    	errMsg = "送迎体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getTsuusyorehabilitationMeetingAndSendingOffSystem().requestFocus();
        return false;
    }
    
    // ・tsuusyorehabilitationStaffReduce（人員減算ラジオグループ）※ errMsg = 人員減算
    if(!getTsuusyorehabilitationStaffReduce().isSelected()){
    	errMsg = "人員減算";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getTsuusyorehabilitationStaffReduce().requestFocus();
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
