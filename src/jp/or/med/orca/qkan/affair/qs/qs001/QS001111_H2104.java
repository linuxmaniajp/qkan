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
 * プログラム サービスパターン短期入所療養介護（病院療養） (QS001111_H2104)
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
 * サービスパターン短期入所療養介護（病院療養）(QS001111_H2104)
 */
public class QS001111_H2104 extends QS001111_H2104Event {
    /**
     * コンストラクタです。
     */
    public QS001111_H2104() {
    }

    // コンポーネントイベント

    /**
     * 「施設区分選択時イベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayHospitalRecuperationInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        
        // ※「施設区分」選択時の「病室区分」の状態切替
        //画面の状態を変更する。
        checkState();
    }

    /**
     * 「食事提供選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayRecuperationHealthFacilityDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {
        // ※「食事提供」選択時に「食費」の状態切替
        if (getShortStayRecuperationHealthFacilityDinnerOffer()
                .getSelectedIndex() < 1) {
            // 「食事提供」が「なし」の場合
            // 食費を無効にする。
            setState_NOT_USE_MEAT();
        } else {
            // 「食事提供」が「なし」以外の場合
            // 食費を有効にする。
            setState_USE_MEAT();
            // 食事費用(shortStayRecuperationHealthFacilityDinnerCost)を設定する。
            getShortStayRecuperationHealthFacilityDinnerCost()
                    .setText(
                            getMeatCost(getShortStayRecuperationHealthFacilityDinnerOffer()
                                    .getSelectedIndex()));
        }

    }

    /**
     * 「特定診療費編集」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayHospitalRecuperationSpecificConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {
        // ※特定診療費の編集
        // 特定診療費編集画面(QS001199_H2104)を生成する。
        // 特定診療費ボタンのデータを引数に生成した特定診療費編集画面(QS001028)のshoModalを実行する。
        if (new QS001199_H2104().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getShortStayHospitalRecuperationSpecificConsultationFee()
                        .getDataModel())) {
            // 特定診療費を変更した場合
            if (getShortStayHospitalRecuperationSpecificConsultationFee()
                    .getDataModel().isEmpty()) {
                // 特定診療費ボタンのデータが空の場合
                // 特定診療費ラベルに「設定なし」と表示する。
                getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                        .setText("設定なし");
            } else {
                // 特定診療費ボタンのデータが空ではない場合
                // 特定診療費ラベルに「設定あり」と表示する。
                getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                        .setText("設定あり");
            }
        }


    }

    /**
     * 「人員減算コンボ選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayHospitalRecuperationPersonSubtractionActionPerformed(
            ActionEvent e) throws Exception {
        // 人員減算のコンボ選択処理
        // 人員減算のコンボ選択
        checkState();

    }

    /**
     * 「認知症行動・心理症状緊急対応加算選択」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void dementiaActionAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception {
        //※認知症行動・心理症状緊急対応加算と若年性認知症利用者受入加算の排他制御  
        //画面の状態を変更する。
        checkState();
    }

    /**
     * 「若年性認知症利用者受入加算選択」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void youngDementiaPatinetAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception {
        //※認知症行動・心理症状緊急対応加算と若年性認知症利用者受入加算の排他制御  
        //画面の状態を変更する。
        checkState();
    }
    
    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001111_H2104.class.getName(),
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
        getShortStayHospitalRecuperationSpecificConsultationFee().clearDataModel();
        //QS001199_H2104(特定診療費)よりサービス種類(SYSTEM_SERVICE_KIND_DETAIL)に応じたbindPath配列を取得し、特定診療費ボタンに設定する。
        getShortStayHospitalRecuperationSpecificConsultationFee()
                .setBindPathes(QS001199_H2104.getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // コードマスタデータよりCODE_ID：191（食事提供）を取得する。
        // 取得した値を、comboItemMapの KEY : 1230150 の VALUE として設定する。
        comboItemMap.setData("1230150", QkanCommon.getArrayFromMasterCode(191,
                "1230150"));
        // ※人員減算
        // コードマスタデータよりCODE_ID：66（人員減算）を取得する。
        // 取得した値を、comboItemMapの KEY : 1230149 の VALUE として設定する。
        comboItemMap.setData("1230149", QkanCommon.getArrayFromMasterCode(66,
                "1230149"));
        // ※時間区分
        // コードマスタデータよりCODE_ID：273（時間区分）を取得する。
        // 取得した値を、comboItemMapの KEY : 1220125 の VALUE として設定する。
        comboItemMap.setData("1230117", QkanCommon.getArrayFromMasterCode(273,
                "1230117"));
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
        VRBindPathParser.set("1230150",defaultMap,new Integer(1));
        // 人員減算
        VRBindPathParser.set("1230149",defaultMap,new Integer(1));
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
            //人員減算コンボの初期値を設定
            getShortStayHospitalRecuperationPersonSubtraction().setSelectedIndex(0);
            
            Object obj;
            // 施設区分
            obj = VRBindPathParser.get("1230124", provider);
            if (obj != null) {
                //体制の施設区分は1.病院療養型、2.ユニット型病院療養型、3.病院経過型、4.ユニット型病院経過型であり、
                //日帰りショートステイがない。この空き番を調整する。
                int val = ACCastUtilities.toInt(obj);
                switch(val){
                    case 3:
                        //病院経過型
                        val = 4;
                        break;
                    case 4:
                        //ユニット型病院経過型
                        val = 5;
                        break;
                }
                defaultMap.setData("1230101", new Integer(val));
            }
            // 人員配置区分
            obj = VRBindPathParser.get("1230126", provider);
            switch(ACCastUtilities.toInt(obj,0)){
            case 1:
            case 2:
            case 3:
                defaultMap.setData("1230102", obj);
                break;
            }
            
            // 人員減算
            obj = VRBindPathParser.get("1230109", provider);
            if (obj != null) {
                //事業所登録の減算項目に合わせ初期値を調整
                 switch(ACCastUtilities.toInt(obj)){
                 case 1: //なしだった場合
                 case 2: //医師だった場合
                     VRBindPathParser.set("1230149", defaultMap, new Integer(1));
                     break;
                 case 3: //看護職員だった場合
                 case 4: //介護職員だった場合
                     VRBindPathParser.set("1230149", defaultMap, new Integer(3));
                     break;
                 }
            }
            // 夜間勤務基準条件
            obj = VRBindPathParser.get("1230125", provider);
            if (obj != null) {
                defaultMap.setData("1230105", obj);
                //ショートステイ用
                if(ACCastUtilities.toInt(obj)==5){
                    //減算型
                    VRBindPathParser.set("1230118", defaultMap, new Integer(5));
                }else{
                    //基準型
                    VRBindPathParser.set("1230118", defaultMap, new Integer(1));
                }
            }
            // 療養環境基準
            obj = VRBindPathParser.get("1230123", provider);
            if (obj != null) {
                defaultMap.setData("1230116", obj);
            }
            //医師の配置基準
            obj = VRBindPathParser.get("1230105",provider);
            if(obj != null){
                defaultMap.setData("1230107",obj);
            }
            // 送迎
            obj = VRBindPathParser.get("1230106", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 送迎区分(shortStayHospitalRecuperationMeetingAndSendingOff)の3番目のボタンを選択にする。
                    defaultMap.setData("6", new Integer(3));
                    break;
                case 1:
                    // 「なし」の場合
                    // 送迎区分(shortStayHospitalRecuperationMeetingAndSendingOff)の1番目のボタンを選択にする。
                    defaultMap.setData("6", new Integer(1));
                    break;
                }
            }

            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 療養食
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1230121", provider),0)) {
            case 2:
                // 「あり」の場合
                // 有効にする。
                setState_VALID_MEDICAL_EXPENSES();
                defaultMap.setData("1230110",new Integer(2));
                break;
            default:
                // 「なし」の場合
                // 無効にする。
                setState_INVALID_MEDICAL_EXPENSES();
                defaultMap.setData("1230110",new Integer(1));
                break;
            }

            // ユニットケア加算
            obj = VRBindPathParser.get("1230127", provider);
            switch (ACCastUtilities.toInt(obj, 0)) {
            case 2:
                // 「あり」の場合
                // 有効にする。
                setState_VALID_UNIT_CARE();
                defaultMap.setData("1230111", obj);
                setUnitCareFlag(true);
                break;
            case 1:
                // 「なし」の場合
                // 無効にする。
                setState_INVALID_UNIT_CARE();
                defaultMap.setData("1230111", obj);
                setUnitCareFlag(false);
                break;
            default:
                // 事業所登録で登録されていなかった場合は一律無効にする。
                setUnitCareFlag(false);
                break;
            }
            
            // 緊急短期入所ネットワーク体制
            obj = VRBindPathParser.get("1230119",provider);
            if(obj != null){
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_SHORT_NETWORK();
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_SHORT_NETWORK();
                    defaultMap.setData("1230112",obj);
                    break;
                }
            }
            

            //若年性認知症利用者受入加算（事業所パネル）KEY：1230120の値をチェックする。
            obj = VRBindPathParser.get("1230120", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //値が次のいずれかだった場合
            case 2:
                //2（あり）
                //有効にする。
                setState_VALID_YOUNG_DEMENTIA_PATINET();
                break;
            default:
                //値が上記以外だった場合
                //無効にする。
                setState_INVALID_YOUNG_DEMENTIA_PATINET();
                break;
            }
            //常にdefaultMapに KEY：1230114 VALUE：1（なし）を設定する。
            VRBindPathParser.set("1230114", defaultMap, new Integer(1));   

            //サービス提供体制強化加算
            obj = VRBindPathParser.get("1230122", provider);
            if (obj != null) {
                VRBindPathParser.set("1230115", defaultMap, obj);
            }

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

        
            if(getShortStayRecuperationHealthFacilityDinnerOffer().getSelectedIndex()==0){
                //食費なしの場合にのみ朝昼夜にする。
                getShortStayRecuperationHealthFacilityDinnerOffer().setSelectedIndex(1);
            }
            
            shortStayHospitalRecuperationInstitutionDivisionRadioActionPerformed(null);
        }

    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        if (getShortStayRecuperationHealthFacilityDinnerOffer()
                .getSelectedIndex() > 0) {
            // 食事提供（shortStayRecuperationHealthFacilityDinnerOffer)が「なし」以外を選択している場合
            if (ACTextUtilities
                    .isNullText(getShortStayRecuperationHealthFacilityDinnerCost()
                            .getText())) {
                // 食事費用(shortStayLifeDinnerCost)が空欄の場合
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
        }
        if(getShortStayHospitalRecuperationInstitutionDivisionRadio().getSelectedIndex() == 1){
            //人員配置区分チェック
            if(!getShortStayHospitalRecuperationDivision().getSelectedButton().isEnabled()){    
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
        }
        if (getTankinyusyoTimeDivision().isEnabled()) {
            // 時間区分（tankinyusyoTimeDivision)が有効な場合(ショートステイ)
            if (getTankinyusyoTimeDivision().getSelectedIndex() < 0) {
                // 時間区分（tankinyusyoTimeDivision)が未選択の場合
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
                        .get("1230110", getSelectedProvider()), 0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230111", getSelectedProvider()), 0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230112", getSelectedProvider()), 0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230113", getSelectedProvider()), 0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230111", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230112",
                                getSelectedProvider()), 0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230112", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230113",
                                getSelectedProvider()), 0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230113", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230111",
                                getSelectedProvider()), 0));
            }
        }
        // 空文字を返す。
        return "";
    }

    public void binded() throws Exception{
        if (getShortStayHospitalRecuperationSpecificConsultationFee()
                .getDataModel().isEmpty()) {
            // 特定診療費ボタンのデータが空の場合
            // 特定診療費ラベルに「設定なし」と表示する。
            getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                    .setText("設定なし");
        } else {
            // 特定診療費ボタンのデータが空ではない場合
            // 特定診療費ラベルに「設定あり」と表示する。
            getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                    .setText("設定あり");
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
    


    /**
     * 「画面状態制御」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     *
     */
    public void checkState() throws Exception {
        // ※画面状態制御処理
        
        //看護・介護職員が欠員、正看比率が20%未満、僻地届出なしの場合
        switch(getShortStayHospitalRecuperationPersonSubtraction().getSelectedIndex()){
        case 2:
        case 3:
        case 5:
            //人員配置区分のⅠ型、Ⅱ型を無効にする。
//            setState_INVALID_PERSON_SUBTRACTION();
            setPersonSubtractFlag(false);
            break;
        default:
            //病院以外区分が選択されていた場合は状態を維持
//            if(getShortStayHospitalRecuperationInstitutionDivisionRadio().getSelectedIndex() == 1){
//                setState_VALID_PERSON_SUBTRACTION();
//            }
            setPersonSubtractFlag(true);
            break;
        }
        
        // ※認知症行動・心理症状緊急対応加算と若年性認知症利用者受入加算の排他制御
        if (getDementiaActionAddRadioGroup().getSelectedIndex() == 2) {
            // 認知症行動・心理症状緊急対応加算(dementiaActionAddRadioGroup)が「あり」の場合
            // 若年性認知症利用者受入加算(youngDementiaPatinetAddRadioGroup)を無効にする。
            setState_INVALID_YOUNG_DEMENTIA_PATINET();
        } else {
            // 上記以外の場合
            // 若年性認知症利用者受入加算(youngDementiaPatinetAddRadioGroup)を有効にする。
            setState_VALID_YOUNG_DEMENTIA_PATINET();
        }
        if (getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() == 2) {
            // 若年性認知症利用者受入加算(youngDementiaPatinetAddRadioGroup)が「あり」の場合
            // 認知症行動・心理症状緊急対応加算(dementiaActionAddRadioGroup)を無効にする。
            setState_INVALID_DEMENTIA_ACTION();
        } else {
            // 上記以外の場合
            // 認知症行動・心理症状緊急対応加算(dementiaActionAddRadioGroup)を有効にする。
            setState_VALID_DEMENTIA_ACTION();
        }

        // 「施設区分」の値をチェックする。
        switch (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // 「単独型」もしくは「併設型」の場合
            // 「病室区分(通常)」を有効にし、「病室区分(ユニット型)」を無効にする。
            setState_CONVENTIONAL_FORM();
            //人員減算設定
            if(!getPersonSubtractFlag()){
                setState_INVALID_PERSON_SUBTRACTION();
            }
            //日帰りショート専用ラジオグループのVisible制御 //20060411
            setState_SHORT_STAY_UNSELECT();
            break;
        case 2:
            // 「単独型ユニット型」もしくは「併設型ユニット型」の場合
            // 「病室区分(通常)」を無効にし、「病室区分(ユニット型)」を有効にする。
            setState_UNIT_FORM();
            //ユニットケア体制が無しだった場合
            if(!getUnitCareFlag()){
                setState_INVALID_UNIT_CARE();
            }
            //日帰りショート専用ラジオグループのVisible制御 //20060411
            setState_SHORT_STAY_UNSELECT();
            break;
        case 3:
            // ｢日帰りショートステイ｣の場合
            setState_SELECT_SHORT_STAY_STATE();
            //日帰りショート専用ラジオグループのVisible制御 //20060411
            setState_SHORT_STAY_SELECT();
            //認知症行動・心理症状緊急対応加算(dementiaActionAddRadioGroup)を「なし」にする。
            getDementiaActionAddRadioGroup().setSelectedIndex(1);
            break;
        case 4:
            // 「経過型」の場合
            // 「病室区分(通常)」「病室区分(ユニット型)」を無効にする。
            setState_PASSAGE_FORM();
            //人員減算設定
            if(!getPersonSubtractFlag()){
                setState_INVALID_PERSON_SUBTRACTION_1_3();
            }
            //日帰りショート専用ラジオグループのVisible制御 //20060411
            setState_SHORT_STAY_UNSELECT();
            break;
        case 5:
            // 「ユニット型経過型」の場合
            // 「病室区分(通常)」を無効にし、「病室区分(ユニット型)」を有効にする。
            setState_UNIT_FORM();
            //ユニットケア体制が無しだった場合
            if(!getUnitCareFlag()){
                setState_INVALID_UNIT_CARE();
            }
            //日帰りショート専用ラジオグループのVisible制御 //20060411
            setState_SHORT_STAY_UNSELECT();
            break;
        }


        //上記処理で有効になったコントロールでも、事業所体制で制約を受けるものは上書きで制御する。
        VRBindSource provider = getSelectedProvider();
        if(provider!=null){
            Object obj;
            
            //若年性認知症利用者受入加算（事業所パネル）KEY：1230120の値をチェックする。
            obj = VRBindPathParser.get("1230120", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //値が次のいずれかだった場合
            case 2:
                //2（あり）
                //なにもしない。
                break;
            default:
                //値が上記以外だった場合
                //無効にする。
                setState_INVALID_YOUNG_DEMENTIA_PATINET();
                break;
            }
        }
        
    }    
    
}
