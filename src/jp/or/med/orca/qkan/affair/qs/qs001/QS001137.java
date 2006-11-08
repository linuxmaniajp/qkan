
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
 * 作成日: 2006/05/07  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防短期入所生活介護 (QS001137)
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
import jp.nichicom.ac.component.table.event.*;
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
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * サービスパターン介護予防短期入所生活介護(QS001137) 
 */
public class QS001137 extends QS001137Event {
  /**
   * コンストラクタです。
   */
  public QS001137(){
  }

  //コンポーネントイベント

  /**
   * 「施設区分選択時イベント」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayLifeTimeContenaFacilityDivisionActionPerformed(ActionEvent e) throws Exception{
    // ※「施設区分」選択時の「病室区分」の状態切替
    // 　画面の状態を制御する。
    checkState();


  }

  /**
     * 「食事提供選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayLifeDinnerOfferActionPerformed(ActionEvent e)
            throws Exception {
        // ※「食事提供」選択時に「食費」の状態切替
        if (getShortStayLifeDinnerOffer().getSelectedIndex() < 1) {
            // 「食事提供」が「なし」の場合
            // 食事テキストの状態を制御する。
            checkDinnerState();
        } else {
            // 「食事提供」が「なし」以外の場合
            // 食費を有効にする。
            checkDinnerState();

            // 食事費用(shortStayLifeDinnerCost)を設定する。
            checkMeatCost();
        }

    }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QS001137.class.getName(), param));
  }

  //内部関数

  /**
     * 「初期化」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void initialize() throws Exception {
        // ※画面展開時の初期設定
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // ※食事提供
        // コードマスタデータよりCODE_ID：191（食事提供）を取得する。
        // 取得した値を、comboItemMapの KEY : 1240109 の VALUE として設定する。
        comboItemMap.setData("1240109", QkanCommon.getArrayFromMasterCode(191,
                "1240109"));
        // ※展開
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();
        // ※選択項目の初期設定
        // ※準備
        // 初期選択設定用のレコード defaultMap を生成する。
        VRMap defaultMap = new VRHashMap();
        // ※設定
        // 画面のラジオの初期値を設定する。（selectFirstRadioItem）
        QkanCommon.selectFirstRadioItem(getThis());
        // 食事提供を「なし」にする。
        VRBindPathParser.set("1240109", defaultMap, new Integer(1));
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 　　初期選択項目を展開する。
        getThis().bindSource();
        // 　　画面の状態を制御する。
        checkState();

    }

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数
        if (provider != null) {
            // 選択事業所情報がnullでない場合
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = new VRHashMap();
            // ※設定
            // 施設等の区分（事業所パネル）KEY：1240101の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240101",
                    provider), 0)) {
            case 1:
                // 値が1（単独型）だった場合
                // defaultMapに KEY：1240101 VALUE：1（単独型）を設定する。
                VRBindPathParser.set("1240101", defaultMap, new Integer(1));
                break;
            case 2:
                // 値が2（併設型）だった場合
                // defaultMapに KEY：1240101 VALUE：2（併設型）を設定する。
                VRBindPathParser.set("1240101", defaultMap, new Integer(2));
                break;
            case 3:
                // 値が3（単独型・ユニット型）だった場合
                // defaultMapに KEY：1240101 VALUE：3（単独型・ユニット型）を設定する。
                VRBindPathParser.set("1240101", defaultMap, new Integer(3));
                break;
            case 4:
                // 値が4（併設型・ユニット型）だった場合
                // defaultMapに KEY：1240101 VALUE：4（併設型・ユニット型）を設定する。
                VRBindPathParser.set("1240101", defaultMap, new Integer(4));
                break;
            }
            // 夜間勤務条件基準（事業所パネル）KEY：1240102の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240102",
                    provider), 0)) {
            case 1:
                // 値が1（基準型）だった場合
                // defaultMapに KEY：1240104 VALUE：1（基準型）を設定する。
                VRBindPathParser.set("1240104", defaultMap, new Integer(1));
                break;
            case 2:
                // 値が2（減算型）だった場合
                // defaultMapに KEY：1240104 VALUE：2（減算型）を設定する。
                VRBindPathParser.set("1240104", defaultMap, new Integer(2));
                break;
            }
            // 職員の欠員による減算の状況（事業所パネル）KEY：1240103の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240103",
                    provider), 0)) {
            case 1:
                // 値が1（なし）だった場合
                // defaultMapに KEY：1240108 VALUE：1（送迎なし）を設定する。
                VRBindPathParser.set("1240108", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
                // 値が3（看護・介護職員）だった場合
                // defaultMapに KEY：1240108 VALUE：3（送迎往復）を設定する。
                VRBindPathParser.set("1240108", defaultMap, new Integer(3));
                break;
            }
            // ユニットケア体制（事業所パネル）KEY：1240104の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240104",
                    provider), 0)) {
            case 1:
                // 値が1（対応不可）だった場合
                // defaultMapに KEY：1240111 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1240111", defaultMap, new Integer(1));
                break;
            case 2:
                // 値が2（対応可）だった場合
                // defaultMapに KEY：1240111 VALUE：2（あり）を設定する。
                VRBindPathParser.set("1240111", defaultMap, new Integer(2));
                break;
            }
            // 機能訓練指導体制（事業所パネル）KEY：1240105の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240105",
                    provider), 0)) {
            case 1:
                // 値が1（なし）だった場合
                // defaultMapに KEY：1240105 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1240105", defaultMap, new Integer(1));
                break;
            case 2:
                // 値が2（あり）だった場合
                // defaultMapに KEY：1240105 VALUE：2（あり）を設定する。
                VRBindPathParser.set("1240105", defaultMap, new Integer(2));
                break;
            }
            // 送迎体制（事業所パネル）KEY：1240106の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240106",
                    provider), 0)) {
            case 1:
                // 値が1（対応不可）だった場合
                // defaultMapに KEY：6 VALUE：1（なし）を設定する。
                VRBindPathParser.set("6", defaultMap, new Integer(1));
                break;
            case 2:
                // 値が2（対応可）だった場合
                // defaultMapに KEY：6 VALUE：3（送迎往復）を設定する。
                VRBindPathParser.set("6", defaultMap, new Integer(3));
                break;
            }
            // 栄養管理の評価（事業所パネル）KEY：1240107の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240107",
                    provider), 0)) {
            case 1:
                // 　　　　　　　値が1（なし）だった場合
                // 　　　　　　　　defaultMapに KEY：1240106　VALUE：1（なし）を設定する。
                VRBindPathParser.set("1240106", defaultMap, new Integer(1));
                break;
            case 2:
                // 　　　　　　　値が2（栄養士）だった場合
                // 　　　　　　　　defaultMapに KEY：1240106　VALUE：3（栄養士）を設定する。
                VRBindPathParser.set("1240106", defaultMap, new Integer(3));
                break;
            case 3:
                // 　　　　　　　値が3（管理栄養士）だった場合
                // 　　　　　　　　defaultMapに KEY：1240106　VALUE：2（管理栄養士）を設定する。
                VRBindPathParser.set("1240106", defaultMap, new Integer(2));
                break;
            }
            // 　　　※展開
            // 　　　　自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 　　　　初期選択項目を展開する。
            getThis().bindSource();
            // 　　※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 　　　画面の状態を制御する。
            checkState();
            
            if(getShortStayLifeDinnerOffer().getSelectedIndex() == 0){
                getShortStayLifeDinnerOffer().setSelectedIndex(1);
            }
            // 　　　テキストエリアの制御する。
            checkDinnerState();
            
            checkMeatCost();
        }

    }

  /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        // ※返却用のレコード(data)を生成
        VRMap data = new VRHashMap();
        // 自身(this)のソースとして生成レコードを設定する。
        getThis().setSource(data);
        // 自身(this)のapplySourceを呼び出してデータを収集する。
        getThis().applySource();
        // ※返却用レコードから不要なキーを除去
        QkanCommon.removeDisabledBindPath(getThis(), data);

        // 食費コンボの値をチェックする。
        if(getShortStayLifeDinnerOffer().getSelectedIndex()>=1){
            // 食費テキストが未入力だった場合
            if (ACTextUtilities.isNullText(getShortStayLifeDinnerCost().getText())){
                // 内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
        }
        // 問題なければ返却用レコード(data)を返す。
        return data;
    }

    /**
     * 「事業所情報の必要性を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean isUseProvider() throws Exception {
        // ※事業所情報が必要なサービスであるかを返す。
        // trueを返す。
        return true;
    }

    /**
     * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ※開始時刻入力用のコンボを返す。
        // 関数の返り値として開始時間コンボを返す。
        return null;
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 　関数の返り値として終了時間コンボを返す。
        return null;
    }

  /**
     * 「画面状態制御」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkState() throws Exception {
        // ※画面状態を制御する。
        // ※サービス連動
        // 施設等の区分（サービスパネル）の値をチェックする。
        switch (getShortStayLifeTimeContenaFacilityDivision()
                .getSelectedIndex()) {
        case 1:
        case 2:
            // 値が1又は2（単独型及び併設型）だった場合
            // ユニット型個室及びユニット型準個室（サービスパネル）のEnableをfalseにする。
            setState_UNIT_HOSPITAL_ROOM_DIVISION_ENABLE_FALSE();
            // 従来型個室及び多床室を（サービスパネル）のEnableをtrueにする。
            setState_HOSPITAL_ROOM_DIVISION_ENABLE_TRUE();
            break;
        case 3:
        case 4:
            // 値が3又は4（単独型ユニット型・併設型ユニット型）だった場合
            // 従来型個室及び多床室を（サービスパネル）のEnableをfalseにする。
            setState_HOSPITAL_ROOM_DIVISION_ENABLE_FALSE();
            // ユニット型個室及びユニット型準個室（サービスパネル）のEnableをtrueにする。
            setState_UNIT_HOSPITAL_ROOM_DIVISION_ENABLE_TRUE();
            break;
        }
        // ※事業所連動
        // 内部変数 providerInfoMap を生成する。
        VRMap providerInfoMap;
        // 事業所パネル情報を取得し providerInfoMap に格納する。
        providerInfoMap = getSelectedProvider();
        // providerInfoMapが null かチェックする。
        // null（事業所未選択）だった場合
        // 何も行わない。
        if (providerInfoMap != null) {
            // null以外だった場合
            // ユニットケア体制（事業所パネル）の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240104",
                    providerInfoMap), 0)) {
            case 1:
                // 値が1（なし）だった場合
                // ユニットケアの整備（サービスパネル）のEnableをfalseにする。
                setState_UNIT_CARE_ENABLE_FALSE();
                break;
            case 2:
                // 値が2（あり）だった場合
                // ユニットケアの整備（サービスパネル）のEnableをtrueにする。
                setState_UNIT_CARE_ENABLE_TRUE();
                break;
            }
            // 機能訓練指導体制（事業所パネル）の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240105",
                    providerInfoMap), 0)) {
            case 1:
                // 　　　　　値が1（なし）だった場合
                // 　　　　　　機能訓練加算（サービスパネル）のEnableをfalseにする。
                setState_ADDITION_FUNCTION_TRAINING_ENABLE_FALSE();
                break;
            case 2:
                // 　　　　　値が2（あり）だった場合
                // 　　　　　　機能訓練加算（サービスパネル）のEnableをtrueにする。
                setState_ADDITION_FUNCTION_TRAINING_ENABLE_TRUE();
                break;
            }
        }
        // ユニット型以外の場合は一律Enableをfalseにする。
        switch(getShortStayLifeTimeContenaFacilityDivision().getSelectedIndex()){
        case 1:
        case 2:
        // ユニットケアの整備（サービスパネル）のEnableをfalseにする。
            setState_UNIT_CARE_ENABLE_FALSE();
            break;
        }
    }

  /**
   * 「食事テキスト制御」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void checkDinnerState() throws Exception{
    // ※食事テキストの制御を行う
        // 食事提供（shortStayLifeDinnerOffer）の値をチェックする。
        if (getShortStayLifeDinnerOffer().getSelectedIndex() == 0) {
            // 値が0だった場合
            // 食事テキストのEnableを false にする。
            setState_DINNER_COST_ENABLE_FALSE();
        } else {
            // 値が1以外だった場合
            // 食事テキストのEnableを true にする。
            setState_DINNER_COST_ENABLE_TRUE();
        }
  }

  /**
     * 「食費取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkMeatCost() throws Exception {
        // ※食事時期をもとに選択事業所における食事費用を返す。
        if (getSelectedProvider() != null) {
            // 事業所が未選択（null） ではない場合
            String meat = "";
            switch (getShortStayLifeDinnerOffer().getSelectedIndex()) {
            case 1:
                // 食事時期が「朝昼夜」の場合
                // 「朝」の食費、「昼」の食費、「夜」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240108", getSelectedProvider()),
                        0));
                break;
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240109", getSelectedProvider()),
                        0));
                break;
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240110", getSelectedProvider()),
                        0));
                break;
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240111", getSelectedProvider()),
                        0));
                break;
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費と「昼」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240109", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1240110",
                                getSelectedProvider()), 0));
                break;
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費と「夜」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240110", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1240111",
                                getSelectedProvider()), 0));
                break;
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費と「朝」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240111", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1240109",
                                getSelectedProvider()), 0));
                break;
            }
            getShortStayLifeDinnerCost().setText(meat);
        } else {

            // 　空文字を返す。
            getShortStayLifeDinnerCost().setText("");
        }
    }

}
