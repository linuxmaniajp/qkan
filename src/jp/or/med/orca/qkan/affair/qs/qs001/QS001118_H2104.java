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
 * プログラム サービスパターン介護老人福祉施設 (QS001118_H2104)
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
 * サービスパターン介護老人福祉施設(QS001118_H2104)
 */
public class QS001118_H2104 extends QS001118_H2104Event {
    /**
     * コンストラクタです。
     */
    public QS001118_H2104() {
    }

    // コンポーネントイベント

    /**
     * 「施設区分選択時イベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoWelfareFacilityInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ※「施設区分」選択時の「病室区分」の状態切替
        // 「施設区分」の値をチェックする。
        switch (getKaigoWelfareFacilityInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
        case 2:
            // 「介護福祉施設」もしくは「小規模介護福祉施設」の場合
            // 「病室区分（介護福祉施設）」を有効にし、「病室区分（ユニット型介護福祉施設）」を無効にする。
            setState_CONVENTIONAL_FORM();
            // 準ユニットケア体制
            setState_VALID_SUB_UNIT_CARE();
            break;
        case 3:
        case 4:
            // 「ユニット型介護福祉施設」もしくは「ユニット型小規模介護福祉施設」の場合
            // 「病室区分（ユニット型介護福祉施設）」を無効にし、「病室区分（介護福祉施設）」を有効にする。
            setState_UNIT_FORM();
            if (!getUnitCareFlag()) {
                setState_INVALID_UNIT_CARE();
            }
            // 準ユニットケア体制
            setState_INVALLID_SUB_UNIT_CARE();
            break;
        }

    }

    /**
     * 「食事提供選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoWelfareFacilityDinnerOfferActionPerformed(ActionEvent e)
            throws Exception {
        // ※「食事提供」選択時に「食費」の状態切替
        if (getKaigoWelfareFacilityDinnerOffer().getSelectedIndex() < 1) {
            // 「食事提供」が「なし」の場合
            // 食費を無効にする。
            setState_NOT_USE_MEAT();
        } else {
            // 「食事提供」が「なし」以外の場合
            // 食費を有効にする。
            setState_USE_MEAT();
            // 食事費用(kaigoWelfareFacilityDinnerCost)を設定する。
            getKaigoWelfareFacilityDinnerCost().setText(
                    getMeatCost(getKaigoWelfareFacilityDinnerOffer()
                            .getSelectedIndex()));
        }

    }


    /**
     * 「看取り介護の有効状態」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoWelfareFacilityTakingCareNursingAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ※看取り介護の有効状態を変更
        // 看取り介護の有効状態を変更する。
        if(getKaigoWelfareFacilityTakingCareNursingAddRadioItem1().isSelected()){
            setState_INVALID_TERMINAL();
        }else{
            setState_VALID_TERMINAL();
        }
    }

    /**
     * 「経口移行加算の変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoWelfareFacilityOralSwitchRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 経口移行加算の状態を基に経口維持加算の有効状態を変更
        if(getKaigoWelfareFacilityOralSwitchRadioItem1().isSelected()){
            setState_VALID_KEEP_NUTRITION();
        }else{
            setState_INVALID_KEEP_NUTRITION();
        }
    }

    /**
     * 「経口維持加算の変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoWelfareFacilityJunOralSwitchRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 経口維持加算の状態を基に経口維持加算の有効状態を変更
        if(getKaigoWelfareFacilityJunOralSwitchRadioItem1().isSelected()){
            setState_VALID_NUTRITION();
        }else{
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
        ACFrame.debugStart(new ACAffairInfo(QS001118_H2104.class.getName(),
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
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // 食事提供
        comboItemMap.setData("1510121", QkanCommon.getArrayFromMasterCode(191,
                "1510121"));
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
        VRBindPathParser.set("1510121", defaultMap, new Integer(1));

        // 2006/05/15 予防対応(要望）
        // 旧措置入所者チェックの値を設定
        if (isOldFacilityUser()) {
            VRBindPathParser.set("8", defaultMap, new Integer(2));
        } else {
            VRBindPathParser.set("8", defaultMap, new Integer(1));
        }

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
        // 選択事業所情報がnullでない場合
        if (provider != null) {
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = new VRHashMap();
            // ※設定
            Object obj;
            // 施設区分
            obj = VRBindPathParser.get("1510101", provider);
            if (obj != null) {
                VRBindPathParser.set("1510101", defaultMap, obj);
            }

            // 人員減算
            obj = VRBindPathParser.get("1510112", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // なしだった場合
                    VRBindPathParser.set("1510120", defaultMap, new Integer(1));
                    break;
                case 2: // 看護職員だった場合
                case 3: // 介護職員だった場合
                case 4: // 介護支援専門員の場合
                    VRBindPathParser.set("1510120", defaultMap, new Integer(3));
                    break;
                }
            }

            // ユニットケアの整備
            obj = VRBindPathParser.get("1510121", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしの場合
                    setState_INVALID_UNIT_CARE();
                    setUnitCareFlag(false);
                    VRBindPathParser.set("1510124", defaultMap, obj);
                    break;
                case 2:
                    // 体制ありの場合
                    setState_VALID_UNIT_CARE();
                    setUnitCareFlag(true);
                    VRBindPathParser.set("1510124", defaultMap, obj);
                    break;
                }
            } else {
                // 事業所登録で登録されていなかった場合は一律無効にする。
                setUnitCareFlag(false);
            }

            // 準ユニットケア
            obj = VRBindPathParser.get("1510122", provider);
            if (obj != null) {
                VRBindPathParser.set("1510125", defaultMap, obj);
            }

            // 夜勤体制減算
            obj = VRBindPathParser.get("1510102", provider);
            if (obj != null) {
                VRBindPathParser.set("1510106", defaultMap, obj);
            }
            // 個別機能訓練指導加算
            obj = VRBindPathParser.get("1510103", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしの場合
                    setState_INVALID_FUNCTION_TRAINING();
                    // 事業所体制を反映
                    setFunctionTrainingFlag(false);
                    VRBindPathParser.set("1510107", defaultMap, obj);
                    break;
                case 2:
                    // 体制ありの場合
                    setState_VALID_FUNCTION_TRAINING();
                    // 事業所体制を反映
                    setFunctionTrainingFlag(true);
                    VRBindPathParser.set("1510107", defaultMap, obj);
                    break;
                }
            }
            // 医師常勤加算
            obj = VRBindPathParser.get("1510104", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    setState_INVALID_DOCTOR();
                    break;
                case 2:
                    setState_VALID_DOCTOR();
                    break;
                }
                VRBindPathParser.set("1510108", defaultMap, obj);
            }
            // 精神科医指導加算
            obj = VRBindPathParser.get("1510105", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしの場合
                    setState_INVALID_PSYCHIATRIST();
                    break;
                case 2:
                    // 体制ありの場合
                    setState_VALID_PSYCHIATRIST();
                    break;
                }
                VRBindPathParser.set("1510109", defaultMap, obj);
            }

            // 障害者生活援助員常勤加算
            obj = VRBindPathParser.get("1510106", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしの場合
                    setState_INVALID_HANDICAPPED();
                    break;
                case 2:
                    // 体制ありの場合
                    setState_VALID_HANDICAPPED();
                    break;
                }
                VRBindPathParser.set("1510110", defaultMap, obj);
            }

            // 栄養マネジメント加算
            obj = VRBindPathParser.get("1510134", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしの場合
                    setState_INVALID_MANAGE();
                    break;
                case 2:
                    // 体制ありの場合
                    VRBindPathParser.set("1510114", defaultMap, obj);
                    setState_VALID_MANAGE();
                    break;
                }
            }
            // 身体拘束未実施減算
            obj = VRBindPathParser.get("1510124", provider);
            if (obj != null) {
                // 身体拘束未実施取組みなしだった場合
                if (ACCastUtilities.toInt(obj) == 1) {
                    VRBindPathParser.set("1510128", defaultMap, new Integer(2));
                } else if (ACCastUtilities.toInt(obj) == 2) {
                    // 身体拘束未実施取組みありだった場合
                    VRBindPathParser.set("1510128", defaultMap, new Integer(1));
                }
            }

            // 療養食加算
            obj = VRBindPathParser.get("1510131", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしの場合
                    setState_INVALID_MEDICAL_EXPENSES();
                    break;
                case 2:
                    // 体制ありの場合
                    setState_VALID_MEDICAL_EXPENSES();
                    VRBindPathParser.set("1510116", defaultMap, obj);
                    break;
                }
            }
            
            // 日常生活継続支援加算:1510127
            obj = VRBindPathParser.get("1510127", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしの場合
                    VRBindPathParser.set("1510133", defaultMap, new Integer(1));
                    break;
                case 2:
                    // 体制ありの場合
                    VRBindPathParser.set("1510133", defaultMap, new Integer(2));
                    break;
                }
            }
            
            // 看護体制加算:1510128
            obj = VRBindPathParser.get("1510128", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしの場合
                    VRBindPathParser.set("1510134", defaultMap, new Integer(1));
                    setState_INVALID_NIGHT_NURSE();
                    break;                                        
                case 2:
                    // 体制ありの場合
                    // 事業所とサービスで形が異なるため値の連動は行わない。
                    setState_VALID_NIGHT_NURSE();
                    break;                    
                    
                }
            }
            
            // 夜勤職員配置加算:1510129
            obj = VRBindPathParser.get("1510129", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしの場合
                    VRBindPathParser.set("1510135", defaultMap, new Integer(1));
                    break;
                case 2:
                    // 体制ありの場合
                    VRBindPathParser.set("1510135", defaultMap, new Integer(2));
                    break;
                }
            }
              
            // 若年性認知症入所者受入加算:1510130
            obj = VRBindPathParser.get("1510130", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしの場合
                    setState_INVALID_YOUNG_DEMENTIA_PATINET();
                    break;
                case 2:
                    // 体制ありの場合
                    setState_VALID_YOUNG_DEMENTIA_PATINET();
                    break;
                }
            }
            //常にdefaultMapに KEY：1510137 VALUE：1（なし）を設定する。
            VRBindPathParser.set("1510137", defaultMap, new Integer(1));
            
            // 栄養マネジメント体制:1510134
            // 上記を復活
            
            //認知症専門ケア加算（事業所パネル）KEY：1510132の値をチェックする。
            obj = VRBindPathParser.get("1510132", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
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
            //常にdefaultMapに KEY：1510140 VALUE：1（なし）を設定する。
            VRBindPathParser.set("1510140", defaultMap, new Integer(1));   
            
            //サービス提供体制強化加算（事業所パネル）KEY：1510133の値をチェックする。
            obj = VRBindPathParser.get("1510133", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //値が次のいずれかだった場合
            case 2:
                //2（I型）
            case 3:
                //3（II型）
            case 4:
                //4（III型）
                //defaultMapに KEY：1510141 VALUE：事業所の値を設定する。
                VRBindPathParser.set("1510141", defaultMap, obj);   
                break;
            default:
                //値が上記以外だった場合
                //defaultMapに KEY：1510141 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1510141", defaultMap, new Integer(1));   
                break;
            }
            
            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

            if (getKaigoWelfareFacilityDinnerOffer().getSelectedIndex() == 0) {
                //食費なしの場合にのみ朝昼夜にする。
                getKaigoWelfareFacilityDinnerOffer().setSelectedIndex(1);
            }
            
            // 看護体制がⅠ型、Ⅱ型の場合
            switch(getNurseStructuralAddRadioGroup().getSelectedIndex()) {
            case 2:
            case 3:
                setState_VALID_NIGHT_NURSE();
                break;
            default:
                setState_INVALID_NIGHT_NURSE();
                break;
            }
        }

    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        if (getKaigoWelfareFacilityTakingCareNursingAddDays().isEnabled()) {
            int days = ACCastUtilities
                    .toInt(getKaigoWelfareFacilityTakingCareNursingAddDays()
                            .getText(), 99);
            if ((days > 30) || (days < 1)) {
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
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
    public boolean isUseProvider() throws Exception {
        // ※事業所情報が必要なサービスであるかを返す。
        // 　trueを返す。
        return true;
    }

    /**
     * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
     * @throws Exception 処理例外
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ※開始時刻入力用のコンボを返す。
        // 　関数の返り値として開始時間コンボを返す。
        return null;
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 　関数の返り値として終了時間コンボを返す。
        return null;
    }

    /**
     * 「食事費用を取得」に関する処理を行ないます。
     * 
     * @param meatType int
     * @throws Exception 処理例外
     * @return String
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
                        .get("1510113", getSelectedProvider()), 0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1510114", getSelectedProvider()), 0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1510115", getSelectedProvider()), 0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1510116", getSelectedProvider()), 0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1510114", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1510115",
                                getSelectedProvider()), 0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1510115", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1510116",
                                getSelectedProvider()), 0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1510116", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1510114",
                                getSelectedProvider()), 0));
            }
        }
        // 空文字を返す。
        return "";
    }
    
    /**
     * 看護体制加算の変更時の処理
     */
    protected void nurseStructuralAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception {
        // 看護体制がⅠ型、Ⅱ型の場合
        switch(getNurseStructuralAddRadioGroup().getSelectedIndex()) {
        case 2:
        case 3:
            setState_VALID_NIGHT_NURSE();
            break;
        default:
            setState_INVALID_NIGHT_NURSE();
            break;
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
