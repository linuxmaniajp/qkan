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
 * プログラム サービスパターン通所介護 (QS001107)
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
 * サービスパターン通所介護(QS001107)
 */
public class QS001107 extends QS001107Event {
    /**
     * コンストラクタです。
     */
    public QS001107() {
    }

    // コンポーネントイベント

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001107.class.getName(), param));
    }

    // 内部関数

    /**
     * 「初期化」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */;
    public void initialize() throws Exception {
        // ※画面展開時の初期設定
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ※時間区分
        // コードマスタデータよりCODE_ID：40（時間区分）を取得する。
        // 取得した値を、comboItemMapの KEY : 1150104 の VALUE として設定する。
        comboItemMap.setData("1150104", QkanCommon.getArrayFromMasterCode(40,
                "1150104"));
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
        QkanCommon.selectFirstRadioItem(getThis());
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();

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
            Object obj;
            // 施設区分
            obj = VRBindPathParser.get("1150101", provider);
            if (obj != null) {
                VRBindPathParser.set("1150103", defaultMap, obj);
            }
            // 個別機能訓練指導体制
            obj = VRBindPathParser.get("1150102", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしだった場合
                    setState_INVALID_FUNCTION_TRAINING();
                    break;
                case 2:
                    // 体制ありだった場合
                    setState_VALID_FUNCTION_TRAINING();
                    // Mapに設定
                    VRBindPathParser.set("1150105", defaultMap, obj);
                    break;
                }

            }
            // 入浴介助
            obj = VRBindPathParser.get("1150103", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしだった場合
                    setState_INVALID_ADD_BATH();
                    break;
                case 2:
                    // 体制ありだった場合
                    setState_VALID_ADD_BATH();
                    VRBindPathParser.set("1150106", defaultMap, obj);
                    break;
                }
            }
            // 栄養マネジメント
            obj = VRBindPathParser.get("1150108", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしだった場合
                    setState_INVALID_NOURISHMENT_MANAGEMENT();
                    break;
                case 2:
                    // 体制ありだった場合
                    setState_VALID_NOURISHMENT_MANAGEMENT();
                    VRBindPathParser.set("1150111", defaultMap, obj);
                    break;
                }
            }
            // 口腔機能向上体制
            obj = VRBindPathParser.get("1150109", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしだった場合
                    setState_INVALID_MOUTH_FUNCTION();
                    break;
                case 2:
                    // 体制ありだった場合
                    setState_VALID_MOUTH_FUNCTION();
                    VRBindPathParser.set("1150112", defaultMap, obj);
                    break;
                }
            }
            // 人員減算
            obj = VRBindPathParser.get("1150106", provider);
            if (obj != null) {
                //事業所登録の減算項目に合わせ初期値を調整
                switch(ACCastUtilities.toInt(obj)){
                case 1: //なしだった場合
                    VRBindPathParser.set("1150108", defaultMap, new Integer(1));
                    break;
                case 2: //医師だった場合
                case 3: //看護職員だった場合
                    VRBindPathParser.set("1150108", defaultMap, new Integer(3));
                    break;
                }
            }
            
            //大規模事業所チェック
            obj = VRBindPathParser.get("1150107",provider);
            if (obj != null) {
                VRBindPathParser.set("1150109", defaultMap, obj);
            }
            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

        }
    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        if (!getTsuusyoKaigoTimeDivision().isSelected()) {
            // 時間区分(tsuusyoKaigoTimeDivision)が未選択の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
        if (ACTextUtilities
                .isNullText(getTsuusyoKaigoTimeBeginTime().getText())
                || ACTextUtilities.isNullText(getTsuusyoKaigoTimeEndTime()
                        .getText())
                || (!getTsuusyoKaigoTimeBeginTime().isValidDate())
                || (!getTsuusyoKaigoTimeEndTime().isValidDate())) {
            // 開始時刻コンボ(tsuusyoKaigoTimeBeginTime)と終了時刻コンボ(tsuusyoKaigoTimeEndTime)のいずれかが空欄もしくは不正の場合
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
        return getTsuusyoKaigoTimeBeginTime();

    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return getTsuusyoKaigoTimeEndTime();
    }

    /**
     * 
     */
    protected void tsuusyoKaigoTimeContenaFacilityDivisionActionPerformed(
            ActionEvent e) throws Exception {
        // 施設区分選択時
        VRMap comboItemMap;
        switch (getTsuusyoKaigoTimeContenaFacilityDivision().getSelectedIndex()) {
        case 1:
            //小規模
            setState_INVALID_DEMENTIA_LARGE();
            comboItemMap = new VRHashMap();
            // コードマスタデータよりCODE_ID：40（時間区分）を取得する。
            // 取得した値を、comboItemMapの KEY : 1150104 の VALUE として設定する。
            comboItemMap.setData("1150104", QkanCommon.getArrayFromMasterCode(40,
                    "1150104"));
            // ※展開
            // 自身(this)にcomboItemMapに設定する。
            getThis().setModelSource(comboItemMap);
            // コンボアイテムを展開する。
            getThis().bindModelSource();
            break;
        case 2:
//          通常規模選択時
            setState_VALID_DEMENTIA_LARGE();
            comboItemMap = new VRHashMap();
            // コードマスタデータよりCODE_ID：40（時間区分）を取得する。
            // 取得した値を、comboItemMapの KEY : 1150104 の VALUE として設定する。
            comboItemMap.setData("1150104", QkanCommon.getArrayFromMasterCode(40,
                    "1150104"));
            // ※展開
            // 自身(this)にcomboItemMapに設定する。
            getThis().setModelSource(comboItemMap);
            // コンボアイテムを展開する。
            getThis().bindModelSource();
            break;
        case 3:
            // 療養通所選択時
            setState_INVALID_DEMENTIA_LARGE();
            comboItemMap = new VRHashMap();
            // コードマスタデータよりCODE_ID：40（時間区分）を取得する。
            // 取得した値を、comboItemMapの KEY : 1150104 の VALUE として設定する。
            comboItemMap.setData("1150104", QkanCommon.getArrayFromMasterCode(238,
                    "1150104"));
            // ※展開
            // 自身(this)にcomboItemMapに設定する。
            getThis().setModelSource(comboItemMap);
            // コンボアイテムを展開する。
            getThis().bindModelSource();
            break;
        }
    }
    
    /**
     * 「終了時間のチェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkEndTime() throws Exception {
        // ※時間帯変更時、終了時間も変更
        // 開始時間コンボ(houmonRehabilitationTimeContenaBeginTime)の値が空欄および不正でない場合
        // 時間退避用の変数kangoTimeに、時間区分から取得した時間を設定する。
        // 終了時間を「開始時間 + kangoTime(分)」に設定する。
        if (getTsuusyoKaigoTimeBeginTime().isValidDate()
                && (!ACTextUtilities
                        .isNullText(getTsuusyoKaigoTimeBeginTime()
                                .getText()))) {
            int kaigoTime = 0;
            // 開始時間コンボ(houmonKangoKaigoBeginTime)の値が空欄および不正でない場合
            // 時間退避用の変数kangoTimeに、訪問看護時間区分から取得した時間を設定する。
            if(getTsuusyoKaigoTimeContenaFacilityDivisionItem3().isSelected()){
                kaigoTime = getRyouyoTuusyoKaigoTime();
            }else{
                kaigoTime = getKaigoTime();
            }
            // 終了時間を「開始時間 + kangoTime(分)」に設定する。
            getTsuusyoKaigoTimeEndTime().setDate(
                    ACDateUtilities.addMinute(
                            getTsuusyoKaigoTimeBeginTime()
                                    .getDate(), kaigoTime));
        }

    }
    /**
     * 「時間区分の時間取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public int getKaigoTime() throws Exception {
        // ※時間区分(getTsuusyoKaigoTimeDivision)の時間を取得
        // 時間区分(getTsuusyoKaigoTimeDivision)の値をチェックする。
        switch (getTsuusyoKaigoTimeDivision().getSelectedIndex()) {
        case 0:
            // ２時間以上３時間未満の場合
            // 戻り値として180を返す。
            return 180;
        case 1:
            // ３時間以上４時間未満の場合
            // 戻り値として240を返す。
            return 240;
        case 2:
            // ４時間以上６時間未満の場合
            // 戻り値として360を返す。
            return 360;
        case 3:
            // ６時間以上８時間未満の場合
            // 戻り値として480を返す。
            return 480;
        case 4:
            // ８時間以上９時間未満の場合
            // 戻り値として540を返す。
            return 540;
        case 5:
            // ９時間以上１０時間未満の場合
            // 戻り値として600を返す。
            return 600;
        }
        return 0;
    }
    
    /**
     * 「時間区分(療養通所)の時間取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public int getRyouyoTuusyoKaigoTime() throws Exception {
        // ※時間区分(getTsuusyoKaigoTimeDivision)の時間を取得
        // 時間区分(getTsuusyoKaigoTimeDivision)の値をチェックする。
        switch (getTsuusyoKaigoTimeDivision().getSelectedIndex()) {
        case 0:
            // ３時間以上６時間未満の場合
            // 戻り値として180を返す。
            return 360;
        case 1:
            // ６時間以上８時間未満の場合
            // 戻り値として480を返す。
            return 480;
        }
        return 0;
    }

    protected void tsuusyoKaigoTimeBeginTimeActionPerformed(ActionEvent e) throws Exception {
        checkEndTime();
        
    }

    protected void tsuusyoKaigoTimeDivisionActionPerformed(ActionEvent e) throws Exception {
        checkEndTime();
        
    }

}
