
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
 * プログラム 居宅介護支援 (QO004117)
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
 * 居宅介護支援(QO004117) 
 */
public class QO004117 extends QO004117Event {
  /**
   * コンストラクタです。
   */
  public QO004117(){
  }

  //コンポーネントイベント

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO004117.class.getName(), param));
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception {
		// ※初期化
		// 区分の初期値として、「�T型」を選択する。
		// 特定事業所集中減算の初期値として、「なし」を選択する。
		// 特定事業所体制の初期値として、「なし」を選択する。

//		getJotaiDivision().setSelectedIndex(1);
//		getSpecificProviderConcentration().setSelectedIndex(1);
		getSpecificProviderAdd().setSelectedIndex(1);

	}

  /**
   * 「入力チェック」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public boolean isValidInput() throws Exception{
    // ※入力チェック
    // エラーメッセージ文言格納用に errMsg　を作成する。
    String errMsg = null;
    
//    // 下記のラジオグループに対して選択チェックを行う。未選択だった場合は errMsg にメッセージを格納する。
//    // ・jotaiDivision（区分ラジオグループ）
//    // ※ errMsg = 要介護度区分
//    if(!getJotaiDivision().isSelected()){
//    	errMsg = "要介護度区分";
//    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
//    	getJotaiDivision().requestFocus();
//    	return false;
//    }
//    
//    // ・specificProviderConcentration（特定事業所集中減算ラジオグループ）
//    // ※ errMsg = 特定事業所集中減算
//    if(!getSpecificProviderConcentration().isSelected()){
//    	errMsg = "特定事業所集中減算";
//    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
//    	getSpecificProviderConcentration().requestFocus();
//    	return false;
//    }
    
    // ・specificProviderAdd（特定事業所体制ラジオグループ）
    // ※ errMsg = 特定事業所体制
    if(!getSpecificProviderAdd().isSelected()){
    	errMsg = "特定事業所体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getSpecificProviderAdd().requestFocus();
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
	  
  }

}
