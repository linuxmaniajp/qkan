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
 * プログラム サービスパターン介護療養型医療施設（認知症） (QS001122)
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
 * サービスパターン介護療養型医療施設（認知症）(QS001122)
 */
public class QS001122 extends QS001122Event {
    /**
     * コンストラクタです。
     */
    public QS001122() {
    }

    // コンポーネントイベント

    /**
     * 「施設区分選択時イベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityCognitiveHospitalInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ※「施設区分」選択時の「病室区分」の状態切替
        // 「施設区分」の値をチェックする。
        switch (getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // 「認知症疾患型」の場合
            // 「病室区分(通常)」を有効にし、「病室区分(ユニット型)」を無効にする。
            setState_CONVENTIONAL_FORM();
            if (getUseHumanCostDown()) {
                setState_USE_HUMAN_COST_DOWN();
            } else {
                setState_VALID_HUMAN_TYPE();
            }

            break;
        case 2:
            // 「ユニット型認知症疾患型」の場合
            // 「病室区分(通常)」を無効にし、「病室区分(ユニット型)」を有効にする。
            setState_UNIT_FORM();
            if (!getInvalidUnitCareProvider()) {
                //※ユニットケア無効
                setState_INVALID_UNIT_CARE();
            } else {
                //※ユニットケア有効
                setState_VALID_UNIT_CARE();
            }
            setState_INVALID_HUMAN_TYPE();
            break;
        case 3:
        	// 「経過型」の場合
        	setState_PASSAGE_FORM();
        }
        // 人員配置区分を制御する
        changeState();

    }

    public void binded() throws Exception {
        if (getMedicalFacilityCognitiveHospitalConsultationFee().getDataModel()
                .isEmpty()) {
            // 特定診療費ボタンのデータが空の場合
            // 特定診療費ラベルに「設定なし」と表示する。
            getMedicalFacilityCognitiveHospitalConsultationFeeLabel().setText(
                    "設定なし");
        } else {
            // 特定診療費ボタンのデータが空ではない場合
            // 特定診療費ラベルに「設定あり」と表示する。
            getMedicalFacilityCognitiveHospitalConsultationFeeLabel().setText(
                    "設定あり");
        }
    }

    /**
     * 「特定診療費の設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityCognitiveHospitalConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {
        // ※特定診療費の編集
        // 特定診療費編集画面(QS001028)を生成する。
        // 特定診療費ボタンのデータを引数に生成した特定診療費編集画面(QS001028)のshoModalを実行する。
        if (new QS001199().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getMedicalFacilityCognitiveHospitalConsultationFee()
                        .getDataModel())) {
            // 特定診療費を変更した場合
            if (getMedicalFacilityCognitiveHospitalConsultationFee()
                    .getDataModel().isEmpty()) {
                // 特定診療費ボタンのデータが空の場合
                // 特定診療費ラベルに「設定なし」と表示する。
                getMedicalFacilityCognitiveHospitalConsultationFeeLabel()
                        .setText("設定なし");
            } else {
                // 特定診療費ボタンのデータが空ではない場合
                // 特定診療費ラベルに「設定あり」と表示する。
                getMedicalFacilityCognitiveHospitalConsultationFeeLabel()
                        .setText("設定あり");
            }
        }

    }

    /**
     * 「食事提供選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityCognitiveHospitalDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {
        // ※「食事提供」選択時に「食費」の状態切替
        if (getMedicalFacilityCognitiveHospitalDinnerOffer().getSelectedIndex() < 1) {
            // 「食事提供」が「なし」の場合
            // 食費を無効にする。
            setState_NOT_USE_MEAT();
        } else {
            // 「食事提供」が「なし」以外の場合
            // 食費を有効にする。
            setState_USE_MEAT();
            // 食事費用(medicalFacilityCognitiveHospitalDinnerCost)を設定する。
            getMedicalFacilityCognitiveHospitalDinnerCost()
                    .setText(
                            getMeatCost(getMedicalFacilityCognitiveHospitalDinnerOffer()
                                    .getSelectedIndex()));
        }

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001122.class.getName(), param));
    }

    // 内部関数

    /**
     * 「初期化」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void initialize() throws Exception {
        // ※画面展開時の初期設定
        getMedicalFacilityCognitiveHospitalConsultationFee().clearDataModel();
        // QS001028(特定診療費)よりサービス種類(SYSTEM_SERVICE_KIND_DETAIL)に応じたbindPath配列を取得し、特定診療費ボタンに設定する。
        getMedicalFacilityCognitiveHospitalConsultationFee().setBindPathes(
                QS001199.getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // 食事提供
        comboItemMap.setData("1530356", QkanCommon.getArrayFromMasterCode(191,
                "1530356"));
        // 人員減算
        comboItemMap.setData("1530355", QkanCommon.getArrayFromMasterCode(107,
                "1530355"));
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
        VRBindPathParser.set("1530356", defaultMap, new Integer(1));
        // 人員減算
        VRBindPathParser.set("1530355", defaultMap, new Integer(1));
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
            // 施設区分
            VRBindPathParser.set("1530301", defaultMap, VRBindPathParser.get(
                    "1530301", provider));
            // 人員配置区分
            VRBindPathParser.set("1530302", defaultMap, VRBindPathParser.get(
                    "1530302", provider));
            // 病院区分
            VRBindPathParser.set("1530316", defaultMap, VRBindPathParser.get(
                    "1530318", provider));
            // ユニットケアの整備
            VRBindPathParser.set("1530313", defaultMap, VRBindPathParser.get(
                    "1530316", provider));
            Object obj;
            // 身体拘束未実施減算
            obj = VRBindPathParser.get("1530317", provider);            
            if(obj != null){
                //身体拘束未実施取組みなしだった場合
                if(ACCastUtilities.toInt(obj) == 1){
                    defaultMap.setData("1530314", new Integer(2));
                }else if(ACCastUtilities.toInt(obj) == 2){
                    //身体拘束未実施取組みありだった場合
                    defaultMap.setData("1530314", new Integer(1));
                }
                
            }

            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 人員減算
            obj = VRBindPathParser.get("1530307", provider);
            switch (ACCastUtilities.toInt(obj)) {
            case 1: // なしだった場合
            case 2: // 医師だった場合
                VRBindPathParser.set("1530355", defaultMap, new Integer(1));
                break;
            case 3: // 看護職員だった場合
            case 4: // 介護職員だった場合
                VRBindPathParser.set("1530355", defaultMap, new Integer(3));
                break;
            case 5: // 介護支援専門員だった場合
                VRBindPathParser.set("1530355", defaultMap, new Integer(4));
                break;
            }
            // 栄養管理体制加算
            obj = VRBindPathParser.get("1530303", provider);
            if (obj != null) {
                if(new Integer(2).equals(ACCastUtilities.toInteger(obj))){
                    VRBindPathParser.set("1530308",defaultMap,new Integer(3));
                }else if(new Integer(3).equals(ACCastUtilities.toInteger(obj))){
                    VRBindPathParser.set("1530308",defaultMap,new Integer(2));
                }
//                switch (ACCastUtilities.toInt(obj)) {
//                case 4:
//                case 3:
//                    //「管理栄養士」の場合
//                    // 有効にする。
//                    setState_VALID_DIETICIAN_MANAGE();
//                    break;
//                case 2:
//                    // 「栄養士」の場合
//                    // 有効にする。
//                    setState_VALID_DIETICIAN_MANAGE();
//                    break;
//                case 1:
//                    // 「なし」の場合
//                    // 無効にする。
//                    setState_INVALID_DIETICIAN_MANAGE();
//                    break;
//                }
            }
            // 栄養マネジメント加算
            obj = VRBindPathParser.get("1530304", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_MANAGE();
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_MANAGE();
                    break;
                }
                VRBindPathParser.set("1530309", defaultMap, obj);
            }
            // 経口移行加算
            obj = VRBindPathParser.get("1530305", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_NUTRITION();
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_NUTRITION();
                    break;
                }
            }
            // 療養食加算
            obj = VRBindPathParser.get("1530306", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_MEDICAL_EXPENSES();
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_MEDICAL_EXPENSES();
                    break;
                }
            }
            // ユニットケアの整備
            obj = VRBindPathParser.get("1530316", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    if (getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2()
                            .isSelected()) {
                        setState_VALID_UNIT_CARE();
                    }
                    setInvalidUnitCareProvider(true);
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_UNIT_CARE();
                    setInvalidUnitCareProvider(false);
                    break;
                }
            } else {
                // 「なし」の場合
                // 無効にする。
                setInvalidUnitCareProvider(false);
            }
            
            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            
            if(getMedicalFacilityCognitiveHospitalDinnerOffer().getSelectedIndex()==0){
                //食費なしの場合にのみ朝昼夜にする。
                getMedicalFacilityCognitiveHospitalDinnerOffer().setSelectedIndex(1);
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
        if (getMedicalFacilityCognitiveHospitalHospitalDivision().isEnabled()
                && (!getMedicalFacilityCognitiveHospitalHospitalDivision()
                        .getSelectedButton().isEnabled())) {
            // 人員配置区分が有効だが人員配置区分の選択ボタンは無効の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
        if (getMedicalFacilityCognitiveHospitalDinnerCost().isEnabled()) {
            // 食事提供（shortStayStandardRecuperationDinnerOffer)が「なし」以外を選択している場合
            if (ACTextUtilities
                    .isNullText(getMedicalFacilityCognitiveHospitalDinnerCost()
                            .getText())) {
                // 食事費用(shortStayStandardRecuperationDinnerCost)が空欄の場合
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
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
                        .get("1530308", getSelectedProvider()), 0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1530309", getSelectedProvider()), 0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1530310", getSelectedProvider()), 0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1530311", getSelectedProvider()), 0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1530309", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530310",
                                getSelectedProvider()), 0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1530310", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530311",
                                getSelectedProvider()), 0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1530311", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530309",
                                getSelectedProvider()), 0));
            }
        }
        // 空文字を返す。
        return "";
    }

    /**
     * 「人員減算選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityCognitiveHospitalSubstractionActionPerformed(
            ActionEvent e) throws Exception {
        // ※人員減算の選択内容に応じて人員配置区分の状態変更
        // 人員減算の選択内容に応じて人員配置区分の状態を変更する。
        switch (getMedicalFacilityCognitiveHospitalSubstraction()
                .getSelectedIndex()) {
        case 2:// 看護･介護職員が欠員
        case 4:// 正看比率が20%未満
        case 6:// 僻地届出なし
            setState_USE_HUMAN_COST_DOWN();
            setUseHumanCostDown(true);
            break;
        default:
            // if(getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1().isSelected()){
            // //認知症型疾患の場合
            // setState_VALID_HUMAN_TYPE();
            // }else{
            // setState_INVALID_HUMAN_TYPE();
            // }
            setUseHumanCostDown(false);

        }
        // 人員配置区分を制御する
        changeState();
    }

    /**
     * 人員配置区分に関する制御を行います。
     */
    public void changeState() throws Exception {
        // 施設区分 認知症疾患型が選択されていた場合
        if (getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1()
                .isSelected()) {
            // 人員配置区分を有効にする。
            setState_VALID_HUMAN_TYPE();
            // 大学病院が選択されていた場合
            // Ⅰ型を表示状態にする。
            if (getHospitalDivisionRadioItem1().isSelected()) {
                setState_USE_HUMAN_COST_DOWN1();
            } else {
                // 病院が選択されていた場合
                // 人員減算区分「看護・介護職員が欠員の場合」「正看比率が20%未満の場合」「僻地届出無」が選択されているかチェックする。
                if (getUseHumanCostDown()) {
                    // Ⅳ・Ⅴ型を選択可能にする。
                    setState_USE_HUMAN_COST_DOWN14_OR_5();
                } else {
                    // Ⅰ型以外を選択可能にする。
                    setState_USE_HUMAN_COST_DOWN_NOT1();
                }
            }
        } else {
            // 人員配置区分を無効にする。
            setState_INVALID_HUMAN_TYPE();
        }
    }

    /**
     * 病院区分変更時のイベント
     */
    protected void hospitalDivisionRadioActionPerformed(ActionEvent e) throws Exception {
        changeState();
        
    }

    /**
     * 「経口移行加算の変更」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityCognitiveHospitalOralSwitchRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        //経口移行加算
        if(getMedicalFacilityCognitiveHospitalOralSwitchRadioItem1().isSelected()){
            setState_VALID_KEEP_NUTRITION();
        }else{
            setState_INVALID_KEEP_NUTRITION();
        }
    }

    /**
     * 「経口維持加算の変更」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void oralMaintenanceAddRadioSelectionChanged(ListSelectionEvent e) throws Exception {
//      経口維持加算
        if(getOralMaintenanceAddRadioItem1().isSelected()){
            setState_VALID_NUTRITION();
        }else{
            setState_INVALID_NUTRITION();
        }
    }

    /**
     * 「他科受信加算の変更」イベントです
     */
    protected void medicalFacilityCognitiveHospitalMedicalExaminationRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        //他科受信ありだった場合
        if(getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem2().isSelected()){
            setState_INVALID_GAIHAKU_ADD();
            //外泊加算なしを選択状態にする
            getMedicalFacilityCognitiveHospitalStayRadioItem1().setSelected(true);
        }else{
            setState_VALID_GAIHAKU_ADD();
        }
        
    }

    /**
     * 「外泊加算の変更」イベントです
     */
    protected void medicalFacilityCognitiveHospitalStayRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        //外泊加算ありだった場合
        if(getMedicalFacilityCognitiveHospitalStayRadioItem2().isSelected()){
            setState_INVALID_TAKAJUSIN_ADD();
            //他科受信なしを選択状態にする
            getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem1().setSelected(true);
        }else{
            setState_VALID_TAKAJUSIN_ADD();
        }
        
    }

}
