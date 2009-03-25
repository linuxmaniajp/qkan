
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
 * プログラム 認知症対応型共同生活介護（短期利用） (QO004127)
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
 * 認知症対応型共同生活介護（短期利用）(QO004127) 
 */
public class QO004127 extends QO004127Event {
  /**
   * コンストラクタです。
   */
  public QO004127(){
  }

  //コンポーネントイベント

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO004127.class.getName(), param));
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
    // ※初期化
    // ※初期値設定
    // 割引率テキストに初期値0を表示する。
	// 夜間勤務条件基準の初期値として、「基準型」を選択する。
	// 医療連携体制の初期値として、「なし」を選択する。
	// 人員減算の初期値として、「なし」を選択する。
	  
	getReduceRate().setText("0");
	getNightWorkDivision().setSelectedIndex(1);
	getMedicalCooperationSystemAdd().setSelectedIndex(1);
	getStaffLack().setSelectedIndex(1);
    
    //2009/02/24 [ID:0000440][Tozo TANAKA] add begin - 平成21年4月法改正対応
    //＜平成21年4月法改正対応＞
    //夜間ケア加算の初期値として「なし」を選択する。
    getNightCareAddRadioGroup().setSelectedIndex(1);
    //若年性認知症利用者受入加算の初期値として「なし」を選択する。
    getYoungDementiaPatinetAddRadioGroup().setSelectedIndex(1);
    //認知症専門ケア加算の初期値として「なし」を選択する。
    getDementiaProfessionalCareAddRadioGroup().setSelectedIndex(1);
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
    // ・nightWorkDivision（夜間勤務条件基準ラジオグループ）
    // ※ errMsg = 夜間勤務条件基準
    if(!getNightWorkDivision().isSelected()){
    	errMsg = "夜間勤務条件基準";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getNightWorkDivision().requestFocus();
    	return false;
    }
    
    // ・medicalCooperationSystemAdd（医療連携体制ラジオグループ）
    // ※ errMsg = 医療連携体制
    if(!getMedicalCooperationSystemAdd().isSelected()){
    	errMsg = "医療連携体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getMedicalCooperationSystemAdd().requestFocus();
    	return false;
    }
    
    // ・staffLack（人員減算ラジオグループ）
    // ※ errMsg = 人員減算
    if(!getStaffLack().isSelected()){
    	errMsg = "人員減算";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getStaffLack().requestFocus();
    	return false;
    }

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
