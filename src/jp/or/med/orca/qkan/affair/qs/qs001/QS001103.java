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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/02/23  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問看護（介護) (QS001103)
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
 * サービスパターン訪問看護（介護)(QS001103)
 */
public class QS001103 extends QS001103Event {
    /**
     * コンストラクタです。
     */
    public QS001103() {
    }


    /**
     * 「終了時間のチェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkEndTime() throws Exception {
        // ※開始時間変更時、終了時間も変更
        if (getHoumonKangoKaigoBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getHoumonKangoKaigoBeginTime()
                        .getText()))) {
            // 開始時間コンボ(houmonKangoKaigoBeginTime)の値が空欄および不正でない場合
            // 時間退避用の変数kangoTimeに、訪問看護時間区分から取得した時間を設定する。
            int kaigoTime = getKaigoTime();

            // 終了時間を「開始時間 + kangoTime(分)」に設定する。
            getHoumonKangoKaigoEndTime().setDate(
                    ACDateUtilities.addMinute(getHoumonKangoKaigoBeginTime()
                            .getDate(), kaigoTime));
        }
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001103.class.getName(), param));
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
        // ※設定
        // ※展開
        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();
        // ※選択項目の初期設定
        // ※準備
        // 初期選択設定用のレコード defaultMap を生成する。
        VRMap defaultMap = new VRHashMap();
        // ※設定
        // 訪問看護施設種別を設定する。
        VRBindPathParser.set("1130103", defaultMap, new Integer(1));
        // 訪問看護職員区分(houmonKangoKaigoClass)の「正看」を選択する。
        VRBindPathParser.set("1130104", defaultMap, new Integer(1));
        // 訪問看護時間区分(houmonKangoKaigoTime)の「30分以上、1時間未満」を選択する。
        VRBindPathParser.set("1130105", defaultMap, new Integer(3));
        // 訪問看護介護時間帯(houmonKangoKaigoTimeZone)の「通常」を選択する。
        VRBindPathParser.set("1130106", defaultMap, new Integer(1));
        // 緊急時訪問看護加算(houmonKangoKaigoUrgentTimeRadio)の「なし」を選択する。
        VRBindPathParser.set("1130108", defaultMap, new Integer(1));
        // 特別管理加算(houmonKangoKaigoSpecialManageRadio)の「なし」を選択する。
        VRBindPathParser.set("1130109", defaultMap, new Integer(1));
        // ターミナルケア加算(houmonKangoKaigoTerminalRadio)の「なし」を選択する。
        VRBindPathParser.set("1130110", defaultMap, new Integer(1));
        // ※展開
        QkanCommon.selectFirstRadioItem(getThis());
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();

    }

    /**
     * 「訪問看護時間の取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public int getKaigoTime() throws Exception {
        // ※訪問看護時間区分より、時間を取得
        // 「訪問看護時間区分(houmonKangoKaigoTime)」の値をチェックする。
        switch (getHoumonKangoKaigoTime().getSelectedIndex()) {
        case 1: //20分未満
            return 20;
        case 2: // 30分未満の場合
            // 戻り値として30を返す。
            return 30;
        case 3:
            // 30分以上、1時間未満の場合
            // 戻り値として60を返す。
            return 60;
        case 4:
            // 1時間以上、1時間半未満の場合
            // 戻り値として90を返す。
            return 90;
        }
        return 0;
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
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();

            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            Object obj;
            // 訪問看護施設種別
            obj = VRBindPathParser.get("1130101", provider);
            if (obj != null) {
                getHoumonKangoKaigoFacilityType().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 緊急時訪問看護加算
            obj = VRBindPathParser.get("1130104", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 1) {
                    // なし
                    setState_INVALID_URGENT_TIME_RADIO();
                } else {
                    // あり
                    setState_VALID_URGENT_TIME_RADIO();
                }
            }
            // 特別管理体制
            obj = VRBindPathParser.get("1130102", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 1) {
                    // なし
                    setState_INVALID_SPECIAL_MANAGE_RADIO();
                } else {
                    // あり
                    setState_VALID_SPECIAL_MANAGE_RADIO();
                }
            }

        }
    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        if (ACTextUtilities
                .isNullText(getHoumonKangoKaigoBeginTime().getText())
                || ACTextUtilities.isNullText(getHoumonKangoKaigoEndTime()
                        .getText())
                || (!getHoumonKangoKaigoBeginTime().isValidDate())
                || (!getHoumonKangoKaigoEndTime().isValidDate())) {
            // 開始時刻コンボ(houmonKangoKaigoBeginTime)と終了時刻コンボ(houmonKangoKaigoEndTime)のいずれかが空欄か不正の場合
            // 時刻の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
            // nullを返す。
            return null;
        }
        if((!getHoumonKangoKaigoTime().isSelected())||
                (!getHoumonKangoKaigoTime().getSelectedButton().isEnabled())){
            //時間区分の有効な項目が選択されていない場合
            //内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
        //時間帯区分に不備があった場合
        if(!getHoumonKangoKaigoTimeZone().getSelectedButton().isEnabled()){
            //内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;            
        }
        
        //職員区分に不備があった場合
        if(!getHoumonKangoKaigoClass().getSelectedButton().isEnabled()){
            //内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
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
        return getHoumonKangoKaigoBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return getHoumonKangoKaigoEndTime();
    }

    /**
     * 職員区分選択時
     */
    protected void houmonKangoKaigoClassSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 職員区分がPT・OT・STが選択されていた場合
        if (getHoumonKangoKaigoClass().getSelectedIndex() == 3) {
            // 時間区分の「20分未満」と「1時間以上、時間半未満」を無効にする。
            setState_HOUMONKANGO_KAIGOTIME_ENABLE_FALSE();
        } else {
            // 時間区分を全て有効にする。
            setState_HOUMONKANGO_KAIGOTIME_ENABLE_TRUE();
        }
        changeState();
    }

    /**
     * 時間区分選択時
     */
    protected void houmonKangoKaigoTimeSelectionChanged(ListSelectionEvent e) throws Exception {
        changeState();
        
    }
    
    /**
     * 時間帯区分に関する制御を行います。
     * @throws Exception
     */
    public void changeState() throws Exception{
        //理学療法士が選択されていないかチェックする
        if(!getHoumonKangoKaigoClass3().isSelected()){
            //20分未満が選択されていた場合
            if(getHoumonKangoKaigoTime4().isSelected()){
                setState_TIME_UNDER20_ENABLE_FALSE();
            }else{
                setState_TIME_UNDER20_ENABLE_TRUE();
            }
        }else{
            setState_TIME_UNDER20_ENABLE_TRUE();
        }
        //時間区分を変更する
        checkEndTime();
    }
    /**
     * 開始時間変更
     */
    protected void houmonKangoKaigoTimeContenaActionPerformed(ActionEvent e) throws Exception {
        //開始時間変更
        checkEndTime();
        
    }

    /**
     * 時間帯変更
     */
    protected void houmonKangoKaigoTimeZoneSelectionChanged(ListSelectionEvent e) throws Exception {
        // ※時間帯変更時、開始時間も変更
        // // 時間退避用の変数kangoTimeに、訪問看護時間区分から取得した時間を設定する。
        // int kaigoTime = getKaigoTime();

        // 訪問看護介護時間帯(houmonKaigoTimeZone)の値をチェックする。
        switch (getHoumonKangoKaigoTimeZone().getSelectedIndex()) {
        case 1:
            // 通常の場合
            // 開始時間を9:00にする。
            getHoumonKangoKaigoBeginTime().setText("9:00");
            break;
        case 2:
            // 早朝の場合
            // 開始時間を6:00にする。
            getHoumonKangoKaigoBeginTime().setText("6:00");
            break;
        case 3:
            // 夜間の場合
            // 開始時間を18:00にする。
            getHoumonKangoKaigoBeginTime().setText("18:00");
            break;
        case 4:
            // 深夜の場合
            // 開始時間を22:00にする。
            getHoumonKangoKaigoBeginTime().setText("22:00");
            break;
        }
        // 終了時間を「開始時間 + 訪問看護時間(分)」に設定する。
        checkEndTime();
    }

    /**
     * 
     */
    protected void houmonKangoKaigoBeginTimeActionPerformed(ActionEvent e) throws Exception {
        checkEndTime();
        
    }

    /**
     * 施設区分変更に関する処理
     */
    protected void houmonKangoKaigoFacilityTypeSelectionChanged(ListSelectionEvent e) throws Exception {
        //医療機関が選択されていた場合
        if(getHoumonKangoKaigoMedicalInstitution().isSelected()){
            setState_INVALID_HOMON_KANGO_PTOT();
        }else {
            setState_VALID_HOMON_KANGO_PTOT();
        }
    }

    
}
