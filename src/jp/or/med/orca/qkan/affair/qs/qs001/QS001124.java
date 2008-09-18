
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
 * 開発者: 小笠　貴志
 * 作成日: 2006/02/23  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン認知症対応型通所介護 (QS001124)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
 * サービスパターン認知症対応型通所介護(QS001124) 
 */
public class QS001124 extends QS001124Event {
  /**
   * コンストラクタです。
   */
  public QS001124(){
  }

  //コンポーネントイベント

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QS001124.class.getName(), param));
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
    // ※画面展開時の初期設定
    // ※コンボアイテムの設定
    // 　※準備
    // 　　コンボアイテム設定用のレコード comboItemMap を生成する。
    VRMap comboItemMap = new VRHashMap();
    // 　※設定
    // 開始時刻
    comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
    // 終了時刻
    comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
    // 　※展開
    // 　　自身(this)にcomboItemMapに設定する。
    getThis().setModelSource(comboItemMap);
    // 　　コンボアイテムを展開する。
    getThis().bindModelSource();
    // ※選択項目の初期設定
    QkanCommon.selectFirstRadioItem(getThis());
    // 　※準備
    // 　　初期選択設定用のレコード defaultMap を生成する。
    VRMap defaultMap = new VRHashMap();
    // 　※設定
    // 　※展開
    // 　　自身(this)にdefaultMapに設定する。
    getThis().setSource(defaultMap);
    // 　　初期選択項目を展開する。
    getThis().bindSource();

  }

  /**
   * 「事業所コンボ変更時関数」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void providerSelected(VRMap provider) throws Exception{
    // ※事業所コンボ変更時に呼ぶ関数
    // 　選択事業所情報がnullでない場合
    // 　　※以下の内容詳細項目は、選択事業所の値を設定する。
    // 　　　※準備
    // 　　　　事業所連動用のレコード defaultMap を生成する。
    VRMap defaultMap = new VRHashMap();
    // 　　　※設定
    Object obj;
    
    //施設区分1
    //施設区分2
    obj = VRBindPathParser.get("1720101", provider);
    if(obj != null){
       //事業所登録の減算項目に合わせ初期値を調整
        switch(ACCastUtilities.toInt(obj)){
        case 1: //
        	VRBindPathParser.set("1720101", defaultMap, new Integer(1));
        	VRBindPathParser.set("1720102", defaultMap, new Integer(1));
        	break;
        case 2: //
        	VRBindPathParser.set("1720101", defaultMap, new Integer(1));
            VRBindPathParser.set("1720102", defaultMap, new Integer(2));
            break;
        case 3: //
            VRBindPathParser.set("1720101", defaultMap, new Integer(2));
            break;
        }
    }
    
    //人員減算    
    obj = VRBindPathParser.get("1720103", provider);
    // 事業所登録の減算項目に合わせ初期値を調整
    if (obj != null) {
        switch (ACCastUtilities.toInt(obj)) {
        case 1: // なしだった場合
            VRBindPathParser.set("1720104", defaultMap, new Integer(1));
            break;
        case 2: // 看護職員だった場合
        case 3: // 介護職員だった場合
            VRBindPathParser.set("1720104", defaultMap, new Integer(3));
            break;
        }
    }
//    
//    //施設区分2の状態
//    if(getProviderDivisionRadioItem1().isSelected()){
//        setInvalidFaclityState2Provider(false);
//        setState_VALID_FACILITY_STATE2();
//    }else{
//        setInvalidFaclityState2Provider(true);
//        setState_INVALID_FACILITY_STATE2();
//    }

    // 栄養マネジメント加算
    obj = VRBindPathParser.get("1720104", provider);
    if (obj != null) {
        switch (ACCastUtilities.toInt(obj,0)) {
        case 2:
            // 「あり」の場合
            // 有効にする。
            setState_VALID_NUTRITION();
            VRBindPathParser.set("1720105", defaultMap, obj);
            break;
        case 1:
            // 「なし」の場合
            // 無効にする。
            setState_INVALID_NUTRITION();
            VRBindPathParser.set("1720105", defaultMap, obj);
            break;
        }
    }

    // 口腔機能向上加算
    obj = VRBindPathParser.get("1720105", provider);
    if (obj != null) {
        switch (ACCastUtilities.toInt(obj)) {
        case 2:
            // 「あり」の場合
            // 有効にする。
            setState_VALID_ORAL_FUNCTION();
            break;
        case 1:
            // 「なし」の場合
            // 無効にする。
            setState_INVALID_ORAL_FUNCTION();
            break;
        }
        VRBindPathParser.set("1720108", defaultMap, obj);
    }
    
    //個別機能訓練体制
    // 注意：通所介護のSYSTEM_BIND_PATHが混ざっている。
    obj = VRBindPathParser.get("1150102",provider);
    if(obj != null){
        switch(ACCastUtilities.toInt(obj)){
        case 1://なし
            setState_INVALID_FUNCTION_TRAINING_ADD();
            VRBindPathParser.set("1720107",defaultMap,obj);
            break;
        case 2://あり
            setState_VALID_FUNCTION_TRAINING_ADD();
            VRBindPathParser.set("1720107",defaultMap,obj);
            break;
        }
    }
    
    //入浴介助体制
    // 注意：通所介護のSYSTEM_BIND_PATHが混ざっている。
    obj = VRBindPathParser.get("1150103",provider);
    if(obj != null){
        switch(ACCastUtilities.toInt(obj)){
        case 1://なし
            setState_INVALID_BATH_ADD();
            VRBindPathParser.set("1720106",defaultMap,obj);
            break;
        case 2://あり
            setState_VALID_BATH_ADD();
            VRBindPathParser.set("1720106",defaultMap,obj);
            break;
        }
    }
    
    // ※展開
    // 自身(this)にdefaultMapに設定する。
    getThis().setSource(defaultMap);
    // 初期選択項目を展開する。
    getThis().bindSource();
    // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

  }

  /**
   * 「入力内容の不備を検査」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public VRMap getValidData() throws Exception{
    // ※入力内容に不備がないかをチェックし、サービスデータを返す。
      if (ACTextUtilities.isNullText(getBeginTime().getText())
              || ACTextUtilities.isNullText(getEndTime()
                      .getText())
              || (!getBeginTime().isValidDate())
              || (!getEndTime().isValidDate())) {
          // 開始時刻コンボ(houmonKangoIryoBeginTime)と終了時刻コンボ(houmonKangoIryoEndTime)のいずれかが空欄か不正の場合
          // 時刻の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_TIME
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
          // nullを返す。
          return null;
      }
    // ※返却用のレコード(data)を生成
    VRMap data = new VRHashMap();
    // 　自身(this)のソースとして生成レコードを設定する。
    getThis().setSource(data);
    // 　自身(this)のapplySourceを呼び出してデータを収集する。
    getThis().applySource();
    // ※返却用レコードから不要なキーを除去
    QkanCommon.removeDisabledBindPath(getThis(), data);
    // 　問題なければ返却用レコード(data)を返す。
return data;
  }

  /**
   * 「事業所情報の必要性を取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public boolean isUseProvider() throws Exception{
    // ※事業所情報が必要なサービスであるかを返す。
    // 　trueを返す。
return true;
  }

  /**
   * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public ACComboBox getBeginTimeCombo() throws Exception{
    // ※開始時刻入力用のコンボを返す。
    // 　関数の返り値として開始時間コンボを返す。
return getBeginTime();
  }

  /**
   * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public ACComboBox getEndTimeCombo() throws Exception{
    // ※終了時刻入力用のコンボを返す。
    // 　関数の返り値として終了時間コンボを返す。
return getEndTime();
  }

  /**
   * 「施設区分1,2の連動」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
protected void providerDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception {
    switch (getProviderDivisionRadio().getSelectedIndex()) {
		case 1:
			// 施設区分1がI型の場合
			// 施設区分2を有効にする。
			setState_VALID_FACILITY_STATE2();
			break;
		case 2:
			// 施設区分1がII型の場合
			// 施設区分2を無効にする。
			setState_INVALID_FACILITY_STATE2();
			break;
		}
    
}


/**
 * 「終了時間のチェック」に関する処理を行ないます。
 * 
 * @throws Exception
 *             処理例外
 */
public void checkEndTime() throws Exception {
    // ※時間帯変更時、終了時間も変更
    // 開始時間コンボ(houmonRehabilitationTimeContenaBeginTime)の値が空欄および不正でない場合
    // 時間退避用の変数kangoTimeに、時間区分から取得した時間を設定する。
    // 終了時間を「開始時間 + kangoTime(分)」に設定する。
    if (getBeginTime().isValidDate()
            && (!ACTextUtilities
                    .isNullText(getBeginTime()
                            .getText()))) {
        int kaigoTime = 0;
        // 開始時間コンボ(houmonKangoKaigoBeginTime)の値が空欄および不正でない場合
        // 時間退避用の変数kangoTimeに、訪問看護時間区分から取得した時間を設定する。
        kaigoTime = getNintiTuusho();

        // 終了時間を「開始時間 + kangoTime(分)」に設定する。
        getEndTime().setDate(
                ACDateUtilities.addMinute(
                        getBeginTime()
                                .getDate(), kaigoTime));
    }

}

/**
 * 「時間区分の時間取得」に関する処理を行ないます。
 * 
 * @throws Exception 処理例外
 */
public int getNintiTuusho() throws Exception {
    // ※時間区分(getTsuusyoKaigoTimeDivision)の時間を取得
    // 時間区分(getTsuusyoKaigoTimeDivision)の値をチェックする。
    switch (getTimeDivisionRadio().getSelectedIndex()) {
    case 1:
        // ２時間以上３時間未満の場合
        // 戻り値として180を返す。
        return 180;
    case 2:
        // ３時間以上４時間未満の場合
        // 戻り値として240を返す。
        return 240;
    case 3:
        // ４時間以上６時間未満の場合
        // 戻り値として360を返す。
        return 360;
    case 4:
        // ６時間以上８時間未満の場合
        // 戻り値として480を返す。
        return 480;
    case 5:
        // ８時間以上９時間未満の場合
        // 戻り値として540を返す。
        return 540;
    case 6:
        // ９時間以上１０時間未満の場合
        // 戻り値として600を返す。
        return 600;
    }
    return 0;
}

/**
 * 開始時間選択処理
 */
protected void beginTimeActionPerformed(ActionEvent e) throws Exception {
    checkEndTime();
    
}

/**
 * 時刻区分選択イベント 
 */
protected void timeDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception {
    checkEndTime();
    
}

}
