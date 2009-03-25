
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
 * プログラム 訪問看護 (QO004103)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo004;

import javax.swing.event.ListSelectionEvent;

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
 * 訪問看護(QO004103) 
 */
public class QO004103 extends QO004103Event {
  /**
   * コンストラクタです。
   */
  public QO004103(){
  }

  //コンポーネントイベント

  /**
   * 「訪問看護パネルEnable制御」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void facilitiesDivisionSelectionChanged(ListSelectionEvent e) throws Exception{
    // ※訪問看護パネルのEnable制御を行う。
	  setState();
	  
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO004103.class.getName(), param));
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
    // ※初期化
    // ※初期値設定
    // 割引率テキストに初期値0を代入する。
	// 施設区分ラジオの初期値として「訪問看護ステーション」を選択する。
	// 緊急時訪問看護体制ラジオの初期値として「なし」を選択する。
	// 特別管理体制ラジオの初期値として「なし」を選択する。
	getReduceRate().setText("0");
    // [ID:0000440][Masahiko Higuchi] add begin
    // ラジオの値を初期化する
    QkanCommon.selectFirstRadioItem(getThis());
    // [ID:0000440][Masahiko Higuchi] add end
	getFacilitiesDivision().setSelectedIndex(FACILITY_TYPE_STATION);
	getHomonkangoPressing().setSelectedIndex(1);
	getSpecialManagementSystem().setSelectedIndex(1);
	getTerminalCare().setSelectedIndex(1);
	getContactAllDay().setSelectedIndex(1);
	getSeriousCaseManagement().setSelectedIndex(1);
	
	//医療系非表示対応 fujihara.shin 2009.1.13 add start
	if (!QkanCommon.isShowOldIryo()){
		setState_VISIBLE_MEDICAL_INSURE_FALSE();
	}
	//医療系非表示対応 fujihara.shin 2009.1.13 add end
	
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
    // ・facilitiesDivision（施設区分ラジオグループ）※ errMsg = 施設区分
    if(!getFacilitiesDivision().isSelected()){
    	errMsg = "施設区分";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getFacilitiesDivision().requestFocus();
    	return false;
    }
    
    // ・homonkangoPressing（緊急時訪問看護加算体制ラジオグループ）※ errMsg = 緊急時訪問看護体制
    if(!getHomonkangoPressing().isSelected()){
    	errMsg = "緊急時訪問看護体制";
    	QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
    	getHomonkangoPressing().requestFocus();
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
//    // ・stationCode（ステーションコード）※errMsg = ステーションコード　
//    if(getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_STATION){
//    	if(ACTextUtilities.isNullText(getStationCode().getText())){
//        	errMsg = "ステーションコード";
//            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
//            getStationCode().requestFocus();
//        	return false;    		
//    	}
//    }

    // 下記のテキストフィールドに対して入力チェックを行う。未入力だった場合は errMsg にメッセージを格納する。
    // ・reduceRate（割引率テキスト）※errMsg = 割引率
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
	  // ・stationCode　　削除KEY：2010101
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

    // facilitiesDivision（施設区分ラジオ）の値をチェックする。
	if (getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_STATION) {
		// 値がFACILITY_TYPE_STATION（訪問看護ステーション）だった場合
		// 画面状態を変更する。※Enable制御を行い編集可能にする。
		setState_MEDICAL_INSURE_TRUE();
	} else if (getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_HOSPITAL) {
		// 値がFACILITY_TYPE_HOSPITAL（病院又は診療所）だった場合
		// 画面状態を変更する。※Enable制御を行い編集不能にする。
		setState_MEDICAL_INSURE_FALSE();
	}

  }
}
