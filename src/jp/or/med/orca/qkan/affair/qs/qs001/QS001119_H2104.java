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
 * 作成日: 2009/02/09  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護老人保健施設 (QS001119_H2104)
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
 * サービスパターン介護老人保健施設(QS001119_H2104)
 */
public class QS001119_H2104 extends QS001119_H2104Event {
    /**
     * コンストラクタです。
     */
    public QS001119_H2104() {
    }

    // コンポーネントイベント

    /**
     * 「施設区分選択時イベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoHealthCareOfTheAgedDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ※「施設区分」選択時の「病室区分」の状態切替
        changeState();

    }

    /**
     * 「食事提供選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoHealthCareOfTheAgedDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {
        // ※「食事提供」選択時に「食費」の状態切替
        if (getKaigoHealthCareOfTheAgedDinnerOffer().getSelectedIndex() < 1) {
            // 「食事提供」が「なし」の場合
            // 食費を無効にする。
            setState_NOT_USE_MEAT();
        } else {
            // 「食事提供」が「なし」以外の場合
            // 食費を有効にする。
            setState_USE_MEAT();
            // 食事費用(kaigoHealthCareOfTheAgedDinnerCost)を設定する。
            getKaigoHealthCareOfTheAgedDinnerCost().setText(
                    getMeatCost(getKaigoHealthCareOfTheAgedDinnerOffer()
                            .getSelectedIndex()));
        }
    }

    /**
     * 「特別療養費設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void specialMedicalExpenseActionPerformed(ActionEvent e)
            throws Exception {
        // ※特別療養費の編集
        // 特別療養費編集画面(QS001200)を生成する。
        // 特別療養費ボタンのデータを引数に生成した特別療養費編集画面(QS001200)のshoModalを実行する。
        if (new QS001200().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getSpecialMedicalExpense().getDataModel())) {
            // 特別療養費を変更した場合
            if (getSpecialMedicalExpense().getDataModel().isEmpty()) {
                // 特別療養費ボタンのデータが空の場合
                // 特別療養費ラベルに「設定なし」と表示する。
                getSpecialMedicalExpenseLabel().setText("設定なし");
            } else {
                // 特別療養費ボタンのデータが空ではない場合
                // 特別療養費ラベルに「設定あり」と表示する。
                getSpecialMedicalExpenseLabel().setText("設定あり");
            }
        }

    }

    /**
     * 「経口移行加算の変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoHealthCareOfTheAgedOralSwitchRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 経口移行加算の状態を基に経口維持加算の有効状態を変更
        if (getKaigoHealthCareOfTheAgedOralSwitchRadioItem1().isSelected()) {
            setState_VALID_KEEP_NUTRITION();
        } else {
            setState_INVALID_KEEP_NUTRITION();
        }
    }

    /**
     * 「経口維持加算の変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void oralMaintenanceAddRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 経口維持加算の状態を基に経口維持加算の有効状態を変更
        // 経口維持加算
        if (getOralMaintenanceAddRadioItem1().isSelected()) {
            setState_VALID_NUTRITION();
        } else {
            setState_INVALID_NUTRITION();
        }
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001119_H2104.class.getName(),
                param));
    }

    // 内部関数

    /**
     * 「初期化」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void initialize() throws Exception {
        // ※画面展開時の初期設定
        getSpecialMedicalExpense().clearDataModel();
        // QS001200(特別療養費)よりサービス種類(SYSTEM_SERVICE_KIND_DETAIL)に応じたbindPath配列を取得し、特別療養費ボタンに設定する。
        getSpecialMedicalExpense().setBindPathes(
                QS001200.getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // 食事提供
        comboItemMap.setData("1520120", QkanCommon.getArrayFromMasterCode(191,
                "1520120"));
        // ※展開
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();
        // ※選択項目の初期設定
        QkanCommon.selectFirstRadioItem(getThis());
        // ※準備
        // 初期選択設定用のレコード defaultMap を生成する。
        VRMap defaultMap = new VRHashMap();
        // ※設定
        // 食事提供
        VRBindPathParser.set("1520120", defaultMap, new Integer(1));
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
        setSelectedProvider(provider);

        if (provider != null) {
            // 選択事業所情報がnullでない場合
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = new VRHashMap();
            // ※設定
            Object obj;
            int index;
//            // 施設区分
//            obj = VRBindPathParser.get("1520101", provider);
//            if (obj != null) {
//                VRBindPathParser.set("1520101", defaultMap, obj);
//            }
            //施設区分（事業所パネル）KEY：1520101の値をチェックする。
            obj = VRBindPathParser.get("1520101", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //値が次のいずれかだった場合
            case 3:
                //3（ユニット型介護保健施設）
            case 4:
                //4（ユニット型小規模介護保健施設）
                //defaultMapに KEY：1520101 VALUE：3（ユニット型介護保健施設）を設定する。
                VRBindPathParser.set("1520101", defaultMap, new Integer(3));   
                break;
            default:
                //値が上記以外だった場合
                //defaultMapに KEY：1520101 VALUE：1（介護保健施設）を設定する。
                VRBindPathParser.set("1520101", defaultMap, new Integer(1));   
                break;
            }

            // 施設区分（体制）
            index = ACCastUtilities.toInt(VRBindPathParser.get("1520122",
                    provider), 0);
            // 設定
            VRBindPathParser.set("1520132", defaultMap, new Integer(index));

            //夜間勤務条件基準（事業所パネル）KEY：1510102の値をチェックする。
            obj = VRBindPathParser.get("1510102", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            case 2:
                //値が2（減算型）だった場合
                //defaultMapに KEY：1520104 VALUE：2（減算型）を設定する。
                VRBindPathParser.set("1520104", defaultMap, new Integer(2));   
                break;
            default:
                //値が2（あり）以外だった場合
                //defaultMapに KEY：1520104 VALUE：1（基準型）を設定する。
                VRBindPathParser.set("1520104", defaultMap, new Integer(1));   
                break;
            }            

            // 人員減算
            obj = VRBindPathParser.get("1520131", provider);
            if (obj != null) {

                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // なしだった場合
                    VRBindPathParser.set("1520119", defaultMap, new Integer(1));
                    break;
                case 2: // 医師だった場合
                case 3: // 看護職員だった場合
                case 4: // 介護職員だった場合
                case 5: // 理学療法士だった場合
                case 6: // 作業療法士だった場合
                case 7: // 介護支援専門員だった場合
                case 8: // 言語聴覚士だった場合
                    VRBindPathParser.set("1520119", defaultMap, new Integer(3));
                    break;
                }
            }
            // ※展開

            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
//            // 栄養管理
//            obj = VRBindPathParser.get("1520105", provider);
//            if (obj != null) {
//                if (new Integer(2).equals(ACCastUtilities.toInteger(obj))) {
//                    VRBindPathParser.set("1520110", defaultMap, new Integer(3));
//                } else if (new Integer(3)
//                        .equals(ACCastUtilities.toInteger(obj))) {
//                    VRBindPathParser.set("1520110", defaultMap, new Integer(2));
//                }
//            }
            // 栄養マネジメント
            obj = VRBindPathParser.get("1520130", provider);
            if (obj != null) {
                VRBindPathParser.set("1520111", defaultMap, obj);
            }
            switch (ACCastUtilities.toInt(obj,0)){
            case 2:
                // 「あり」の場合
                // 有効にする。
                setState_VALID_MANAGE();
                break;
            default:
                // 「なし」の場合
                // 無効にする。
                setState_INVALID_MANAGE();
                break;
            }
            // 経口移行
            obj = VRBindPathParser.get("1520107", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_NUTRITION();
                } else {
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_NUTRITION();
                }
            }

            // 療養体制維持特別加算
            index = ACCastUtilities.toInt(VRBindPathParser.get("1520124",
                    provider), 0);
            // 設定
            VRBindPathParser.set("1520134", defaultMap, new Integer(index));


            //療養食加算（事業所パネル）KEY：1520125の値をチェックする。
            obj = VRBindPathParser.get("1520125", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            case 2:
                //値が2（あり）だった場合
                // 有効にする。
                setState_VALID_MEDICAL_EXPENSES();
                //defaultMapに KEY：1520113 VALUE：2（あり）を設定する。
                VRBindPathParser.set("1520113", defaultMap, new Integer(2));   
                break;
            default:
                //値が2（あり）以外だった場合
                // 無効にする。
                setState_INVALID_MEDICAL_EXPENSES();
                //defaultMapに KEY：1520113 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1520113", defaultMap, new Integer(1));   
                break;
            }
            
            // ユニットケア体制
            obj = VRBindPathParser.get("1520119", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしの場合
                    defaultMap.setData("1520127", obj);
                    setState_INVALID_UNIT_CARE();
                    setUnitCareFlag(false);
                    break;
                case 2:
                    // 体制ありの場合
                    defaultMap.setData("1520127", obj);
                    setState_VALID_UNIT_CARE();
                    setUnitCareFlag(true);
                    break;
                }
            } else {
                // 事業所登録で登録されていなかった場合は一律無効にする。
                setUnitCareFlag(false);
            }

            // 身体拘束未実施減算
            obj = VRBindPathParser.get("1520120", provider);
            if (obj != null) {
                // 身体拘束未実施取組み無しだった場合
                if (ACCastUtilities.toInt(obj) == 1) {
                    defaultMap.setData("1520130", new Integer(2));
                } else if (ACCastUtilities.toInt(obj) == 2) {
                    // 身体拘束未実施取組み有りだった場合
                    defaultMap.setData("1520130", new Integer(1));
                }
            }
            // 夜勤職員配置加算
            index = ACCastUtilities.toInt(VRBindPathParser.get("1520126",
                    provider), 1);
            VRBindPathParser.set("1520136", defaultMap, new Integer(index));

            // 事業所の若年性認知症入所者受入加算：1520127をチェックする。
            index = ACCastUtilities.toInt(VRBindPathParser.get("1520127",
                    provider), 1);
            switch(index) {
            case 1:
                setState_INVALID_YOUNG_DEMENTIA_PATINET();
                break;
            case 2:
                setState_VALID_YOUNG_DEMENTIA_PATINET();
                break;
            }
            //常にdefaultMapに KEY：1520138 VALUE：1（なし）を設定する。
            VRBindPathParser.set("1520138", defaultMap, new Integer(1));

            // 事業所の栄養マネジメント加算：1520130を栄養マネジメント加算：1520111に設定する。
            index = ACCastUtilities.toInt(VRBindPathParser.get("1520130",
                    provider), 1);
            VRBindPathParser.set("1520111", defaultMap, new Integer(index));

            //認知症専門ケア加算（事業所パネル）KEY：1520128の値をチェックする。
            obj = VRBindPathParser.get("1520128", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //値が次のいずれかだった場合
            case 2:
                //2（加算I）
            case 3:
                //3（加算II）
                //有効にする。
                setState_VALID_DEMENTIA_PRO_CARE();
                break;
            default:
                //値が上記以外だった場合
                //無効にする。
                setState_INVALID_DEMENTIA_PRO_CARE();
                break;
            }
            //常にdefaultMapに KEY：1520137 VALUE：1（なし）を設定する。
            VRBindPathParser.set("1520137", defaultMap, new Integer(1));   
            
            
            //認知症ケア加算（事業所パネル）KEY：1520121の値をチェックする。
            obj = VRBindPathParser.get("1520121", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //値が次のいずれかだった場合
            case 2:
                //2（あり）
                //有効にする。
                setState_VALID_DEMENTIA_CARE();
                break;
            default:
                //値が上記以外だった場合
                //無効にする。
                setState_INVALID_DEMENTIA_CARE();
                break;
            }
            //常にdefaultMapに KEY：1520128 VALUE：1（なし）を設定する。
            VRBindPathParser.set("1520128", defaultMap, new Integer(1));   
            
            
            // サービス提供体制強化加算：1520129をサービス提供体制強化加算：1520142に設定する。
            index = ACCastUtilities.toInt(VRBindPathParser.get("1520129",
                    provider), 1);
            VRBindPathParser.set("1520142", defaultMap, new Integer(index));

            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();

            if (getKaigoHealthCareOfTheAgedDinnerOffer().getSelectedIndex() == 0) {
                // 食費なしの場合にのみ朝昼夜にする。
                getKaigoHealthCareOfTheAgedDinnerOffer().setSelectedIndex(1);
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
        // 施設等の区分が未選択状態でないかチェックする。
        if (getKaigoHealthCareOfTheAgedDivisionRadio().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // 施設区分（体制）が未選択状態でないかをチェックする。
        if (getKaigoHealthCareOfTheAgedDivision().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // 療養環境維持特別体制が未選択であないかチェックする。
        if (getRecuperationRadio().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // 夜勤職員配置加算ラジオが未入力であるかチェックする。
        if (getNightStaffDispositionAddRadioGroup().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // 若年性認知症入所者受入加算ラジオが未入力であるかチェックする。
        if (getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // 栄養マネジメント加算ラジオが未入力であるかチェックする。
        if (getKaigoHealthCareOfTheAgedNutritionRadio().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // 認知症専門ケア加算ラジオが未入力であるかチェックする。
        if (getDementiaProfessionalCareAddRadioGroup().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // サービス提供体制強化加算ラジオが未入力であるかチェックする。
        if (getServiceAddProvisionStructuralRadioGroup().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // 特別療養費が使用不可能な場合は値をクリアする。
        if(!getSpecialMedicalExpense().isEnabled()) {
            getSpecialMedicalExpense().clearDataModel();
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
        return null;
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return null;
    }

    /**
     * 「食事費用を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public String getMeatCost(int meatType) throws Exception {
        // ※食事時期をもとに選択事業所における食事費用を返す。
        if (getSelectedProvider() != null) {
            // 事業所を選択している場合
            switch (meatType) {
            case 1:
                // 食事時期が「朝昼夜」の場合
                // 「朝」の食費、「昼」の食費、「夜」の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520110", getSelectedProvider()), 0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520111", getSelectedProvider()), 0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520112", getSelectedProvider()), 0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520113", getSelectedProvider()), 0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520111", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520112",
                                getSelectedProvider()), 0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520112", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520113",
                                getSelectedProvider()), 0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520113", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520111",
                                getSelectedProvider()), 0));
            }
        }
        // 空文字を返す。
        return "";
    }

    /**
     * 「データバインド後の処理」に関する処理を行ないます。
     * @throws Exception 処理例外
     */
    public void binded() throws Exception {
        // ※データバインド後の処理
        if (getSpecialMedicalExpense().getDataModel().isEmpty()) {
            // 特別療養費ボタンのデータが空の場合
            // 特別療養費ラベルに「設定なし」と表示する。
            getSpecialMedicalExpenseLabel().setText("設定なし");
        } else {
            // 特別療養費ボタンのデータが空ではない場合
            // 特別療養費ラベルに「設定あり」と表示する。
            getSpecialMedicalExpenseLabel().setText("設定あり");
        }

    }

    protected void kaigoHealthCareOfTheAgedDivisionSelectionChanged(ListSelectionEvent e) throws Exception {
        // 画面状態制御
        changeState();
        
    }

    public void changeState() throws Exception {
        // 「施設区分」の値をチェックする。
        switch (getKaigoHealthCareOfTheAgedDivisionRadio().getSelectedIndex()) {
        case 1:
        case 2:
            // 「介護保険施設」の場合
            // 「病室区分（介護老人保健施設）」を有効にし、「病室区分（ユニット型介護老人保健施設）」を無効にする。
            setState_CONVENTIONAL_FORM();
            setState_VALID_DEMENTIA_CARE();
            break;
        case 3:
        case 4:
            // 「ユニット型介護保険施設」の場合
            // 「病室区分（介護老人保健施設）」を無効にし、「病室区分（ユニット型介護老人保健施設）」を有効にする。
            setState_UNIT_FORM();
            // ユニットケア体制がなしだった場合は無効にする
            if (!getUnitCareFlag()) {
                setState_INVALID_UNIT_CARE();
            }
            setState_INVALID_DEMENTIA_CARE();
            break;
        }
        
        // 体制による状態制御（療養老健）
        switch(getKaigoHealthCareOfTheAgedDivision().getSelectedIndex()) {
        case 2:
        case 3:
            setState_SELECT_RYOYO_STATE();
            break;
        default:
            setState_UNSELECT_RYOYO_STATE();
        }
        
        //上記処理で有効になったコントロールでも、事業所体制で制約を受けるものは上書きで制御する。
        VRBindSource provider = getSelectedProvider();
        if(provider!=null){
            Object obj;
            
            //認知症ケア加算（事業所パネル）KEY：1520121の値をチェックする。
            obj = VRBindPathParser.get("1520121", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //値が次のいずれかだった場合
            case 2:
                //2（あり）
                //何もしない。
                break;
            default:
                //値が上記以外だった場合
                //無効にする。
                setState_INVALID_DEMENTIA_CARE();
                break;
            }

        }
        
        
    }

    /**
     * 「サービス法改正区分取得」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     * @return int
     */
    public int getServiceLowVersion() throws Exception {
        //※このサービスパネルが扱うサービスの法改正区分(M_DETAIL.SYSTEM_BIND_PATH=14)を返す。 
        //QkanConstants.SERVICE_LOW_VERSION_H2104 を返す。
        return QkanConstants.SERVICE_LOW_VERSION_H2104;
    }
}
