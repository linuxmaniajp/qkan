
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
 * プログラム 通所リハ (QO004108)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo004;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 通所リハ(QO004108) 
 */
public class QO004108 extends QO004108Event {
  /**
   * コンストラクタです。
   */
  public QO004108(){
  }

  //コンポーネントイベント

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO004108.class.getName(), param));
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception {
	// ※初期化
	// ※初期値設定
	// 割引率テキストに初期値0を代入する。
	// 施設区分の初期値として「通常規模の医療機関」を選択する。
	// リハビリ・マネジメント体制の初期値として「なし」を選択する。
	// 入浴介助体制の初期値として「なし」を選択する。
	// 栄養マネジメント体制の初期値として「なし」を選択する。
	// 口腔機能向上体制の初期値として「なし」を選択する。
	// 人員減算の初期値として「なし」を選択する。

	getReduceRate().setText("0");
	getFacilitiesDivision().setSelectedIndex(1);
	getBathingHelpSystem().setSelectedIndex(1);
	getNourishmentManagementAdd().setSelectedIndex(1);
	getMouthImprovementAdd().setSelectedIndex(1);
	getStaffLack().setSelectedIndex(1);
	getExtendTime().setSelectedIndex(1);
	getDementiaCare().setSelectedIndex(1);

    //2009/02/24 [ID:0000440][Tozo TANAKA] add begin - 平成21年4月法改正対応
    //＜平成21年4月法改正対応＞
    //施設区分の初期値として「通常規模の事業所」を選択する。
    getFacilitiesDivisionAfterH2104RadioGroup().setSelectedIndex(1);
    //認知症短期集中リハビリテーション加算の初期値として「なし」を選択する。
    getDementiaRihaAddRadioGroup().setSelectedIndex(1);
    //若年性認知症利用者受入加算の初期値として「なし」を選択する。
    getYoungDementiaPatinetAddRadioGroup().setSelectedIndex(1);
    //サービス提供体制強化加算の初期値として「なし」を選択する。
    getServiceAddProvisionStructuralRadioGroup().setSelectedIndex(1);
    //栄養改善体制の初期値として「なし」を選択する。
    getNourishmentImprovement().setSelectedIndex(1);
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
    
//    // ・rehabilitationManagementAdd（リハビリ・マネジメント体制ラジオグループ）
//    // ※ errMsg = リハビリ・マネジメント体制
//    if(!getRehabilitationManagementAdd().isSelected()){
//    	errMsg = "リハビリ・マネジメント体制";
//    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
//    	getRehabilitationManagementAdd().requestFocus();
//    	return false;
//    }
    
    // ・bathingHelpSystem（入浴介助体制ラジオグループ）
    // ※ errMsg = 入浴介助体制
    if(!getBathingHelpSystem().isSelected()){
    	errMsg = "入浴介助体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getBathingHelpSystem().requestFocus();
    	return false;
    }
    
    // ・nourishmentManagementAdd（栄養マネジメント体制ラジオグループ）
    // ※ errMsg = 栄養マネジメント体制
    if(!getNourishmentManagementAdd().isSelected()){
    	errMsg = "栄養マネジメント体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getNourishmentManagementAdd().requestFocus();
    	return false;
    }
    
    // ・mouthImprovementAdd（口腔機能向上体制ラジオグループ）
    // ※ errMsg = 口腔機能向上体制
    if(!getMouthImprovementAdd().isSelected()){
    	errMsg = "口腔機能向上体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getMouthImprovementAdd().requestFocus();
    	return false;
    }
    
    // ・staffLack（人員減算ラジオグループ）
    // ※ errMsg = 人員減算
    if(!getStaffLack().isSelected()){
    	errMsg = "口腔機能向上体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getStaffLack().requestFocus();
    	return false;
    }

    // 下記のテキストフィールドに対して入力チェックを行う。未入力だった場合は errMsg にメッセージを格納する。
    // ・reduceRate（割引率テキスト）
    // ※ errMsg = 割引率
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
	} else {
		// 引数としてfalseが渡された場合
		// 状態ID：SET_PANEL_FALSE
		setState_SET_PANEL_FALSE();
	}
  }

  /**
   * 「パネルデータ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外   * @return VRMap
   */
  public void getDetails(VRMap map) throws Exception{
	  // パネルデータ取得
	  
	  getMainGroup().setSource(map);
	  getMainGroup().applySource();
	  
  }
}
