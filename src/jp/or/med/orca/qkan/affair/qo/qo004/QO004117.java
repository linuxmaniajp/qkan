
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

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

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
		// 区分の初期値として、「Ⅰ型」を選択する。
		// 特定事業所集中減算の初期値として、「なし」を選択する。
		// 特定事業所体制の初期値として、「なし」を選択する。

//		getJotaiDivision().setSelectedIndex(1);
//		getSpecificProviderConcentration().setSelectedIndex(1);
		getSpecificProviderAdd().setSelectedIndex(1);

        //2009/02/24 [ID:0000440][Tozo TANAKA] add begin - 平成21年4月法改正対応
        //＜平成21年4月法改正対応＞
        // 特定体制整備事業所加算の有無の初期値としてなしを選択する。
        getSpecificProviderAddH2103Before().setSelectedIndex(1);
        //中山間地域等における小規模事業所加算（地域に関する状況）の初期値として「非該当」を選択する。
        getProviderAddMountainousAreaRafioRadioGroup().setSelectedIndex(1);
        //中山間地域等における小規模事業所加算（規模に関する状況）の初期値として「非該当」を選択する。
        getProviderAddMountainousAreaScaleRadioGroup().setSelectedIndex(1);
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
