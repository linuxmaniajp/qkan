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
 * 作成日: 2006/02/23  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問介護 (QS001101)
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
import jp.or.med.orca.qkan.text.*;

/**
 * サービスパターン訪問介護(QS001101)
 */
public class QS001101 extends QS001101Event {
    /**
     * コンストラクタです。
     */
    public QS001101() {
    }

    // コンポーネントイベント

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001101.class.getName(), param));
    }

    // 内部関数

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
        // ※訪問種別
        // コードマスタデータよりCODE_ID：198（訪問種別）を取得する。
        // 取得した値を、comboItemMapの KEY : 1110101 の VALUE として設定する。
        comboItemMap.setData("1110101", QkanCommon.getArrayFromMasterCode(198,
                "1110101"));
        // ※提供時間
        // コードマスタデータよりCODE_ID：26（提供時間）を取得する。
        // 取得した値を、comboItemMapの KEY : 1110105 の VALUE として設定する。
        comboItemMap.setData("1110105", QkanCommon.getArrayFromMasterCode(26,
                "1110105"));
        // ※うち身体時間
        // コードマスタデータよりCODE_ID：26（うち身体時間）を取得する。
        // 取得した値を、comboItemMapの KEY : 1110104 の VALUE として設定する。
        comboItemMap.setData("1110104", QkanCommon.getArrayFromMasterCode(26,
                "1110104"));
        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
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
        // ※展開
        // 訪問者の級職ラジオグループ(houmonKaigoClass)の「3級以外」を選択する。
        VRBindPathParser.set("1110106", defaultMap, new Integer(1));
        // 訪問人数ラジオグループ(houmonKaigoNumberOfPeople)の「1人」を選択する。
        VRBindPathParser.set("1110107", defaultMap, new Integer(1));
        // 時間帯ラジオグループ(houmonKaigoTimeZone)の「通常」を選択する。
        VRBindPathParser.set("1110108", defaultMap, new Integer(1));
        // 特定事業所体制の値を設定する。
        VRBindPathParser.set("1110109", defaultMap, new Integer(1));
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();
    }

    // コンポーネントイベント

    /**
     * 「状態設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKaigoServicePatternActionPerformed(ActionEvent e)
            throws Exception {
        // ※「訪問種別」に応じて、選択可能なインスタンスを設定
        // コンボ候補を設定する。
        checkComboItem();
        // 訪問種別の値をチェックする。
        switch (getHoumonKaigoServicePattern().getSelectedIndex()) {
        case 0:
            // 身体介護の場合
            // 身体介護用の状態を設定する。
            setState_SHINTAI_KAIGO();
            break;
        case 1:
            // 生活援助の場合
            // 生活援助用の状態を設定する。
            setState_SEIKATSU_ENJO();
            break;
        case 2:
            // 身体生活の場合
            // 身体生活用の状態を設定する。
            setState_SHINTAI_SEIKATSU();
            break;
        case 3:
            // 通院等乗降介助の場合
            // 通院等乗降介助用の状態を設定する。
            setState_JOKOKAIJO();
            break;
        }
    }
    /**
     * 「時間帯変更時」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKaigoTimeZoneActionPerformed(ActionEvent e)
            throws Exception {
        // ※時間帯変更時、開始時間も変更
        // houmonKaigoTimeZoneの値をチェックする。
        switch (getHoumonKaigoTimeZone().getSelectedIndex()) {
        case 1:
            // 通常の場合
            // 開始時間を9:00にする。
            getHoumonKaigoBeginTime().setText("9:00");
            break;
        case 2:
            // 早朝の場合
            // 開始時間を6:00にする。
            getHoumonKaigoBeginTime().setText("6:00");
            break;
        case 3:
            // 夜間の場合
            // 開始時間を18:00にする。
            getHoumonKaigoBeginTime().setText("18:00");
            break;
        case 4:
            // 深夜の場合
            // 開始時間を22:00にする。
            getHoumonKaigoBeginTime().setText("22:00");
            break;
        }
        // 時間帯変更時、終了時間も変更する。
        checkEndTime();

    }

    /**
     * 「身体介護提供時間変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void homonkaigoTeikyoTimeActionPerformed(ActionEvent e)
            throws Exception {
        // ※時間帯変更時、終了時間も変更
        // 時間帯変更時、終了時間も変更する。
        checkEndTime();
    }
    
    /**
     * 「生活援助提供時間変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKaigoInTimeActionPerformed(ActionEvent e)
            throws Exception {
        // ※時間帯変更時、終了時間も変更
        // 時間帯変更時、終了時間も変更する。
        checkEndTime();
    }
    
    /**
     * 「終了時間のチェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkEndTime() throws Exception {
        // ※時間帯変更時、終了時間も変更
        if (getHoumonKaigoBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getHoumonKaigoBeginTime()
                        .getText()))) {
            // 開始時刻コンボ(houmonKaigoBeginTime)が入力済みかつ不正でない場合
            // 提供時間コンボから提供分数を取得する。
            // 開始時刻に提供分数を加算した結果を終了時刻コンボ(houmonKaigoEndTime)に設定する。
            getHoumonKaigoEndTime().setDate(
                    ACDateUtilities.addMinute(
                            getHoumonKaigoBeginTime().getDate(),
                            getTeikyoTime()));
        }

    }
    
    /**
     * 「提供時間の取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return int
     */
    public int getTeikyoTime() throws Exception {
        // ※提供時間コンボより、時間を取得
        int addMinute = 0;
        // 提供時間コンボ(homonkaigoTeikyoTime)の値をチェックする。
        if (getHomonkaigoTeikyoTime().isEnabled()&& getHomonkaigoTeikyoTime().isSelected()) {
            // (選択番号+1)×30を返す。
            addMinute+= (getHomonkaigoTeikyoTime().getSelectedIndex() + 1) * 30;
        }
        if (getHoumonKaigoInTime().isEnabled()&& getHoumonKaigoInTime().isSelected()) {
            // (選択番号+1)×30を返す。
            addMinute+= (getHoumonKaigoInTime().getSelectedIndex() + 1) * 30;
        }
        return addMinute;
    }
    
    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数
        // 選択事業所情報がnullでない場合
        if (provider != null) {
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = new VRHashMap();
            // ※設定
            // ※展開
            Object obj;
            // 特定事業所体制の値を設定する。
            obj = VRBindPathParser.get("1110101", provider);
            if (obj != null) {
                VRBindPathParser.set("1110109", defaultMap, obj);
            }
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
        }
        // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        if (!getHoumonKaigoServicePattern().isSelected()) {
            // 訪問種別が未選択の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }

        if (getHoumonKaigoServicePattern().getSelectedIndex() != 3) {
            // 訪問種別が通院乗降解除以外の場合
            switch (getHoumonKaigoServicePattern().getSelectedIndex()) {
            case 0:
                // 訪問種別が身体介護の場合
                if (!getHomonkaigoTeikyoTime().isSelected()) {
                    // 提供時間が未選択の場合
                    // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // nullを返す。
                    return null;
                }
                break;
            case 1:
                // 訪問種別が生活援助の場合
                if (!getHoumonKaigoInTime().isSelected()) {
                    // 提供時間が未選択の場合
                    // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // nullを返す。
                    return null;
                }
//                if (getHoumonKaigoInTime().getSelectedIndex() < 1) {
//                    // 提供時間コンボ(homonkaigoTeikyoTime)が30分未満の場合
//                    // 生活援助の提供時間の不備メッセージを表示する。※ID=QS001_ERROR_OF_LIFE_ASSIST_TIME
//                    QkanMessageList.getInstance()
//                            .QS001_ERROR_OF_LIFE_ASSIST_TIME();
//                    getHoumonKaigoInTime().setSelectedIndex(1);
//                    // nullを返す。
//                    return null;
//                }
                break;
            case 2:
                // 訪問種別が身体生活の場合
                if ((!getHomonkaigoTeikyoTime().isSelected())||(!getHoumonKaigoInTime().isSelected())) {
                    // 提供時間が未選択の場合
                    // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // nullを返す。
                    return null;
                }
                break;
            }

        }

        if (ACTextUtilities.isNullText(getHoumonKaigoBeginTime().getText())
                || ACTextUtilities
                        .isNullText(getHoumonKaigoEndTime().getText())
                || (!getHoumonKaigoBeginTime().isValidDate())
                || (!getHoumonKaigoEndTime().isValidDate())) {
            // 開始時刻コンボ(houmonKaigoBeginTime)と終了時刻コンボ(houmonKaigoEndTime)のいずれかが空欄もしくは不正の場合
            // 時刻の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
            // nullを返す。
            return null;
        }
        
        
        // ※返却用のレコード(data)を生成
        VRMap data = new VRHashMap();
        // 自身(this)のソースとして生成レコードを設定する。
        getThis().setSource(data);
        // 自身(this)のapplySourceを呼び出してデータを収集する。
        getThis().applySource();
        // ※返却用レコードから不要なキーを除去
        QkanCommon.removeDisabledBindPath(getThis(), data);
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
        return getHoumonKaigoBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return getHoumonKaigoEndTime();
    }

    /**
     * 訪問看護の級職を制御する
     */
    protected void specificProviderAddRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        //特定事業所加算がⅠ型・Ⅱ型が選択された場合
       if(getSpecificProviderAddRadioItem2().isSelected()||getSpecificProviderAddRadioItem3().isSelected()){
           //級職グループを無効にする
           setState_INVALID_KYUSYOKU();
       }else{
           //級職グループを有効にする
           setState_VALID_KYUSYOKU();
       }
    }

    /**
     * コンボ候補設定
     */
    public void checkComboItem() throws Exception {
        //※設定
        VRMap comboItemMap = new VRHashMap();
        //サービスコンボの値をチェックする。
        if(getHoumonKaigoServicePattern().getSelectedIndex() == 1){
            //値が2（生活援助）だった場合
            //コードマスタデータよりCODE_ID：269（提供時間・生活援助）を取得する。
            //取得した値を、comboItemMapの KEY : 1110105 の VALUE として設定する。
            comboItemMap.setData("1110104", QkanCommon.getArrayFromMasterCode(269,
            "1110105"));
        }else{
            //値が2以外（身体介護、身体生活）だった場合
            //コードマスタデータよりCODE_ID：26（提供時間・身体介護）を取得する。
            //取得した値を、comboItemMapの KEY : 1110105 の VALUE として設定する。
            comboItemMap.setData("1110104", QkanCommon.getArrayFromMasterCode(26,
            "1110105"));
        }
        //※展開
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();
        
    }

    /**
     * データバインド時の処理
     */
    public void binded() throws Exception {
        // 予防対応時(要望対応)
        // サービス区分が生活援助だった場合
        if (getHoumonKaigoServicePattern().getSelectedIndex()==1){
            // ソースを取得
            VRBindSource src = getHoumonKaigoInTime().getSource();
            if(src != null){
                // 生活援助コンボの値をチェックする。
                // 要望対応前のデータだった場合
                if(ACCastUtilities.toInt(src.getData("1110105")) >= 3){
                    getHoumonKaigoInTime().setSelectedIndex(1);
                }
            }
        }
    }
}
