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
 * 作成日: 2009/02/10  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防短期入所療養介護（病院） (QS001139_H2104)
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
 * サービスパターン介護予防短期入所療養介護（病院）(QS001139_H2104)
 */
public class QS001139_H2104 extends QS001139_H2104Event {
    /**
     * コンストラクタです。
     */
    public QS001139_H2104() {
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
        // 画面の状態を変更する。
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
            checkDinnerState();
        } else {
            // 「食事提供」が「なし」以外の場合
            // 食費を有効にする。
            checkDinnerState();

            // 食事費用(shortStayRecuperationHealthFacilityDinnerCost)を設定する。
            checkMeatCost();
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
        // 特定診療費ボタンのデータを引数に生成した特定診療費編集画面(QS001199)のshoModalを実行する。
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
        // 画面の状態を変更する。
        checkState();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001139_H2104.class.getName(),
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
        // QS001199_H2104(特定診療費)よりサービス種類(SYSTEM_SERVICE_KIND_DETAIL)に応じたbindPath配列を取得し、特定診療費ボタンに設定する。
        getShortStayHospitalRecuperationSpecificConsultationFee()
                .clearDataModel();
        getShortStayHospitalRecuperationSpecificConsultationFee()
                .setBindPathes(
                        QS001199_H2104
                                .getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // ※食事提供
        // コードマスタデータよりCODE_ID：191（食事提供）を取得する。
        // 取得した値を、comboItemMapの KEY : 1260111 の VALUE として設定する。
        comboItemMap.setData("1260111", QkanCommon.getArrayFromMasterCode(191,
                "1260111"));
        // ※人員減算
        // コードマスタデータよりCODE_ID：66（人員減算）を取得する。
        // 取得した値を、comboItemMapの KEY : 1260110 の VALUE として設定する。
        comboItemMap.setData("1260110", QkanCommon.getArrayFromMasterCode(66,
                "1260110"));
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
        VRBindPathParser.set("1260111", defaultMap, new Integer(1));
        // 人員減算を「なし」にする。
        VRBindPathParser.set("1260110", defaultMap, new Integer(1));
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();
        // 画面の状態を設定する。
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
            // ※事業所連動
            // 施設等の区分（事業所パネル）KEY：1260122の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260122",
                    provider), 0)) {
            case 1:
                // 値が1（病院療養型）だった場合
                // defaultMapに KEY：1260101 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1260101", defaultMap, new Integer(1));
                break;
            case 2:
                // 値が2（ユニット型病院療養型）だった場合
                // defaultMapに KEY：1260101 VALUE：2（あり）を設定する。
                VRBindPathParser.set("1260101", defaultMap, new Integer(2));
                break;
            case 3:
                // 値が3（経過型）だった場合
                // defaultMapに KEY：1260101 VALUE：3を設定する。
                VRBindPathParser.set("1260101", defaultMap, new Integer(3));
                break;
            case 4:
                // 値が4（ユニット型経過型）だった場合
                // defaultMapに KEY：1260101 VALUE：3を設定する。
                VRBindPathParser.set("1260101", defaultMap, new Integer(4));
                break;
            }
            // 人員配置区分（事業所パネル）KEY：1260123の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260123",
                    provider), 0)) {
            case 1:
                // 値が1（Ⅰ）だった場合
                // defaultMapに KEY：1260102 VALUE：1（Ⅰ）を設定する。
                VRBindPathParser.set("1260102", defaultMap, new Integer(1));
                break;
            case 2:
                // 値が2（Ⅱ）だった場合
                // defaultMapに KEY：1260102 VALUE：2（Ⅱ）を設定する。
                VRBindPathParser.set("1260102", defaultMap, new Integer(2));
                break;
            case 3:
                // 値が3（Ⅲ）だった場合
                // defaultMapに KEY：1260102 VALUE：3（Ⅲ）を設定する。
                VRBindPathParser.set("1260102", defaultMap, new Integer(3));
                break;
            }
            // 夜間勤務条件基準（事業所パネル）KEY：1260124の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260124",
                    provider), 0)) {
            case 1:
                // 値が1（基準型）だった場合
                // defaultMapに KEY：1260105 VALUE：1（基準型）を設定する。
                VRBindPathParser.set("1260105", defaultMap, new Integer(1));
                break;
            case 2:
                // 値が2（加算型Ⅰ）だった場合
                // defaultMapに KEY：1260105 VALUE：2（加算型Ⅰ）を設定する。
                VRBindPathParser.set("1260105", defaultMap, new Integer(2));
                break;
            case 3:
                // 値が3（加算型Ⅱ）だった場合
                // defaultMapに KEY：1260105 VALUE：3（加算型Ⅱ）を設定する。
                VRBindPathParser.set("1260105", defaultMap, new Integer(3));
                break;
            case 4:
                // 値が4（加算型Ⅲ）だった場合
                // defaultMapに KEY：1260105 VALUE：4（加算型Ⅲ）を設定する。
                VRBindPathParser.set("1260105", defaultMap, new Integer(4));
                break;
            case 5:
                // 値が5（減算型）だった場合
                // defaultMapに KEY：1260105 VALUE：5（減算型）を設定する。
                VRBindPathParser.set("1260105", defaultMap, new Integer(5));
                break;
            case 6:
                // 値が6（加算型IV）だった場合
                // defaultMapに KEY：1260105 VALUE：6（加算型IV）を設定する。
                VRBindPathParser.set("1260105", defaultMap, new Integer(6));
                break;
            }
            // 職員の欠員による減算の状況（事業所パネル）KEY：1260104の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260104",
                    provider), 0)) {
            case 1:
            case 2:
                // 値が1又は2（なし・医師）だった場合
                // defaultMapに KEY：1260110 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1260110", defaultMap, new Integer(1));
                break;
            case 3:
            case 4:
                // 値が3又は4（看護・介護職員）だった場合
                // defaultMapに KEY：1260110 VALUE：2（あり）を設定する。
                VRBindPathParser.set("1260110", defaultMap, new Integer(3));
                break;
            }
            // ユニットケア体制（事業所パネル）KEY：1260125の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260125",
                    provider), 0)) {
            case 1:
                // 値が1（対応不可）だった場合
                // defaultMapに KEY：1260113 VALUE：1（未整備）を設定する。
                VRBindPathParser.set("1260113", defaultMap, new Integer(1));
                break;
            case 2:
                // 値が2（対応可）だった場合
                // defaultMapに KEY：1260113 VALUE：2（整備）を設定する。
                VRBindPathParser.set("1260113", defaultMap, new Integer(2));
                break;
            }
            // 療養環境基準（事業所パネル）KEY：1260121の値をチェックする。
            // 体制は基準型と減算型だが、算定上取りうる値は基準型と減算型I、減算型III
            // switch (ACCastUtilities.toInt(VRBindPathParser.get("1260121",
            // provider), 0)) {
            // case 1:
            // // 値が1（基準型）だった場合
            // // defaultMapに KEY：1260116 VALUE：1（基準型）を設定する。
            // VRBindPathParser.set("1260116", defaultMap, new Integer(1));
            // break;
            // case 2:
            // // 値が2（減算型）だった場合
            // // defaultMapに KEY：1260116 VALUE：2（減算型）を設定する。
            // VRBindPathParser.set("1260116", defaultMap, new Integer(2));
            // break;
            // }
            // 医師の配置基準（事業所パネル）KEY：1260107の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260107",
                    provider), 0)) {
            case 1:
                // 値が1（医師の配置基準）だった場合
                // defaultMapに KEY：1260107 VALUE：1（医師の配置基準）を設定する。
                VRBindPathParser.set("1260107", defaultMap, new Integer(1));
                break;
            case 2:
                // 値が2（医師法施工規則第49条）だった場合
                // defaultMapに KEY：1260107 VALUE：2（医師法施工規則第49条）を設定する。
                VRBindPathParser.set("1260107", defaultMap, new Integer(2));
                break;
            }
            // 送迎体制（事業所パネル）KEY：1260108の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260108",
                    provider), 0)) {
            case 1:
                // 値が1（対応不可）だった場合
                // defaultMapに KEY：6 VALUE：1（送迎なし）を設定する。
                VRBindPathParser.set("6", defaultMap, new Integer(1));
                break;
            case 2:
                // 値が2（対応可）だった場合
                // defaultMapに KEY：6 VALUE：3（送迎往復）を設定する。
                VRBindPathParser.set("6", defaultMap, new Integer(3));
                break;
            }

            Object obj;
            // 療養食
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260119",
                    provider), 0)) {
            case 2:
                // 「あり」の場合
                // 有効にする。
                setState_VALID_MEDICAL_EXPENSES();
                // [ID:0000481][Tozo TANAKA] 2009/04/08 delete begin 平成21年4月法改正対応(療養食)
//                defaultMap.setData("1260109", new Integer(2));
                // [ID:0000481][Tozo TANAKA] 2009/04/08 delete end
                break;
            default:
                // 「なし」の場合
                // 無効にする。
                setState_INVALID_MEDICAL_EXPENSES();
            // [ID:0000481][Tozo TANAKA] 2009/04/08 delete begin 平成21年4月法改正対応(療養食)
//                defaultMap.setData("1260109", new Integer(1));
            // [ID:0000481][Tozo TANAKA] 2009/04/08 delete end
                break;
            }
            // [ID:0000481][Tozo TANAKA] 2009/04/08 add begin 平成21年4月法改正対応(療養食)
            //常にdefaultMapに KEY：1260109 VALUE：1（なし）を設定する。
            VRBindPathParser.set("1260109", defaultMap, new Integer(1));   
            // [ID:0000481][Tozo TANAKA] 2009/04/08 add end

            // 若年性認知症利用者受入加算（事業所パネル）KEY：1260118の値をチェックする。
            obj = VRBindPathParser.get("1260118", provider);
            switch (ACCastUtilities.toInt(obj, 0)) {
            // 値が次のいずれかだった場合
            case 2:
                // 2（あり）
                // 有効にする。
                setState_VALID_YOUNG_DEMENTIA_PATINET();
                break;
            default:
                // 値が上記以外だった場合
                // 無効にする。
                setState_INVALID_YOUNG_DEMENTIA_PATINET();
                break;
            }
            // 常にdefaultMapに KEY：1260114 VALUE：1（なし）を設定する。
            VRBindPathParser.set("1260114", defaultMap, new Integer(1));

            // サービス提供体制強化加算
            obj = VRBindPathParser.get("1260120", provider);
            if (obj != null) {
                VRBindPathParser.set("1260115", defaultMap, obj);
            }

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 画面の状態を変更する。
            checkState();

            // ※初期設定
            // 食事提供コンボチェック
            if (getShortStayRecuperationHealthFacilityDinnerOffer()
                    .getSelectedIndex() == 0) {
                // 値が1（なし）だった場合
                // 食費コンボの｢朝昼夜｣を選択する。（初期選択）
                getShortStayRecuperationHealthFacilityDinnerOffer()
                        .setSelectedIndex(1);
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
        // ※返却用のレコード(data)を生成
        VRMap data = new VRHashMap();
        // 自身(this)のソースとして生成レコードを設定する。
        getThis().setSource(data);
        // 自身(this)のapplySourceを呼び出してデータを収集する。
        getThis().applySource();
        // ※返却用レコードから不要なキーを除去
        // ※食事テキストチェック
        // 食事提供コンボの値をチェックする。
        if (getShortStayRecuperationHealthFacilityDinnerOffer()
                .getSelectedIndex() > 0) {
            // 値が1（なし）以外だった場合
            // 食事費用(shortStayLifeDinnerCost)の値をチェックする。
            if (ACTextUtilities
                    .isNullText(getShortStayRecuperationHealthFacilityDinnerCost()
                            .getText())) {
                // 値が空白だった場合
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
        }
        // ※人員配置区分チェック
        // 施設区分がユニット型ではなかった場合
        if (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex() == 1) {
            // 人員配置区分の現在選択されているラジオのEnableをチェックする。
            if (!getShortStayHospitalRecuperationDivision().getSelectedButton()
                    .isEnabled()) {
                // Enableがfalse だった場合
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
        }
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
     * 「画面状態制御」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkState() throws Exception {
        // ※画面状態制御
        // 認知症行動・心理症状緊急対応加算 選択時
        if(getDementiaActionAddRadioGroup().getSelectedIndex() == 2) {
            setState_INVALID_YOUNG_DEMENTIA_PATINET();
        } else {
            setState_VALID_YOUNG_DEMENTIA_PATINET();
        }
        
        // 若年性認知症利用者受入加算 選択時
        if(getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() == 2) {
            setState_INVALID_DEMENTIA_ACTION();
        } else {
            setState_VALID_DEMENTIA_ACTION();
        }
        // ※サービス連動
        // 施設等の区分（サービスパネル）の値をチェックする。
        switch (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // 値が1（病院）だった場合
            // 人員減算（サービスパネル）の値をチェックする
            switch (getShortStayHospitalRecuperationPersonSubtraction()
                    .getSelectedIndex()) {
            case 0:
            case 1:
            case 4:
                // 値が1又は2又は5（なし・定員超過・僻地届出有）だった場合
                // 画面の状態を変更する。
                setState_STATE_MODE_1();
                break;
            case 2:
            case 3:
            case 5:
                // 値が3又は4又は6（看護・介護職員の不足・正看比率が20%未満・僻地届出無）だった場合
                // 画面の状態を変更する。
                setState_STATE_MODE_2();
                break;
            }
            break;
        case 2:
            // 値が2（ユニット型病院）だった場合
            // 画面の状態を変更する。
            setState_STATE_MODE_3();
            break;
        case 3:
            // 値が3（経過型）だった場合
            // 人員減算（サービスパネル）の値をチェックする

            switch (getShortStayHospitalRecuperationPersonSubtraction()
                    .getSelectedIndex()) {
            case 0:
            case 1:
            case 4:
                // 値が1又は2又は5（なし・定員超過・僻地届出有）だった場合
                // 画面の状態を変更する。
                setState_STATE_MODE_4();
                break;
            case 2:
            case 3:
            case 5:
                // 値が3又は4又は6（看護・介護職員の不足・正看比率が20%未満・僻地届出無）だった場合
                // 画面の状態を変更する。
                setState_STATE_MODE_6();
                break;
            }

            break;
        case 4:
            // 値が4（ユニット型経過型）だった場合
            // 画面の状態を変更する。
            setState_STATE_MODE_5();
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
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260125",
                    providerInfoMap), 0)) {
            case 1:
                // 値が1（対応不可）だった場合
                // ユニットケアの整備（サービスパネル）のEnableをfalseにする。
                setState_UNIT_CARE_MAINTENANCE_ENABLE_FALSE();
                break;
            case 2:
                // 値が2（対応可）だった場合
                // ユニットケアの整備（サービスパネル）のEnableをtrueにする。
                setState_UNIT_CARE_MAINTENANCE_ENABLE_TRUE();
                break;
            }
            
            Object obj;
            
            //若年性認知症利用者受入加算（事業所パネル）KEY：1260118の値をチェックする。
            obj = VRBindPathParser.get("1260118", providerInfoMap);
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

        // ユニットケア体制のEnable制御
        switch (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {
        // ユニットケアの整備が有効でも施設区分がユニット型でなければユニットケアの整備を無効とするよう、施設区分をチェックする。
        case 2:
            // ユニット型病院の場合
        case 4:
            // ユニット型経過型の場合
            break;
        default:
            // ユニット型以外の場合
            setState_UNIT_CARE_MAINTENANCE_ENABLE_FALSE();
            break;
        }

    }

    /**
     * 「食費テキスト制御」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkDinnerState() throws Exception {
        // ※食費テキストのEnable制御処理
        // 食事提供（shortStayRecuperationHealthFacilityDinnerCost）の値をチェックする。
        if (getShortStayRecuperationHealthFacilityDinnerOffer()
                .getSelectedIndex() == 0) {
            // 値が1だった場合
            // 食事テキストのEnableを false にする。
            setState_DINNER_COST_ENABLE_FALSE();
        } else {
            // 値が1以外だった場合
            // 食事テキストのEnableを true にする。
            setState_DINNER_COST_ENABLE_TRUE();
        }

    }

    /**
     * 「食事費用合計値」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkMeatCost() throws Exception {
        // ※食事時期をもとに選択事業所における食事費用を返す。
        if (getSelectedProvider() != null) {
            // 事業所が未選択（null） ではない場合
            String meat = "";
            switch (getShortStayRecuperationHealthFacilityDinnerOffer()
                    .getSelectedIndex()) {
            case 1:
                // 食事時期が「朝昼夜」の場合
                // 「朝」の食費、「昼」の食費、「夜」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260110", getSelectedProvider()),
                        0));
                break;
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260111", getSelectedProvider()),
                        0));
                break;
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260112", getSelectedProvider()),
                        0));
                break;
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260113", getSelectedProvider()),
                        0));
                break;
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費と「昼」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260111", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260112",
                                getSelectedProvider()), 0));
                break;
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費と「夜」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260112", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260113",
                                getSelectedProvider()), 0));
                break;
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費と「朝」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260113", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260111",
                                getSelectedProvider()), 0));
                break;
            }
            getShortStayRecuperationHealthFacilityDinnerCost().setText(meat);
        } else {
            // 事業所が未選択の場合
            // 空文字を返す。
            getShortStayRecuperationHealthFacilityDinnerCost().setText("");
        }

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
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 　関数の返り値として終了時間コンボを返す。
        return null;
    }

    /**
     * 「データバインド時の処理」に関する処理を行ないます。
     * @throws Exception 処理例外
     */
    public void binded() throws Exception {
        // ※データバインド時の処理
        // 特定診療費ボタンのデータの有無をチェックする。
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

    protected void dementiaActionAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        checkState();

    }

    protected void youngDementiaPatinetAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        checkState();

    }

}
