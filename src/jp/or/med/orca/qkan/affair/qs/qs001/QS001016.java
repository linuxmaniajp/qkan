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
 * 作成日: 2006/01/18  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン短期入所療養介護（基準適合診療所） (001)
 * プログラム サービスパターン短期入所療養介護（基準適合診療所） (QS001017)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン短期入所療養介護（基準適合診療所）(QS001017)
 */
public class QS001016 extends QS001016Event {
    /**
     * コンストラクタです。
     */
    public QS001016() {
    }

    // コンポーネントイベント

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001016.class.getName(), param));
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
        // ※食事提供
        // コードマスタデータよりCODE_ID：191（食事提供）を取得する。
        // 取得した値を、comboItemMapの KEY : 1230406 の VALUE として設定する。
        comboItemMap.setData("1230406", QkanCommon.getArrayFromMasterCode(191,
                "1230406"));
        // ※コンボアイテムの設定
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();
        // ※選択項目の初期設定
        // 栄養管理体制加算(shortStayStandardRecuperationDieticianManageRadio)の「なし」を選択する。
        getShortStayStandardRecuperationDieticianManageRadio()
                .setSelectedIndex(1);
        // 療養食加算(shortStayStandardRecuperationMedicalExpensesRadio)の「なし」を選択する。
        getShortStayStandardRecuperationMedicalExpensesRadio()
                .setSelectedIndex(1);

        // 食事提供(shortStayStandardRecuperationDinnerOffer)の「なし」を選択する。
        getShortStayStandardRecuperationDinnerOffer().setSelectedIndex(0);

    }

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数
        //選択している事業所情報(selectedProvider)を退避する。
        setSelectedProvider(provider);
        if (provider != null) {
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            Object obj;
            // 人員減算
            obj = VRBindPathParser.get("1230404", provider);
            if (obj != null) {
                getShortStayStandardRecuperationEtcShiftSubtractionRadio()
                        .setSelectedIndex(ACCastUtilities.toInt(obj));
            }
            // 送迎
            obj = VRBindPathParser.get("1230401", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 送迎区分(shortStayStandardRecuperationMeetingAndSendingOff)の3番目のボタンを選択にする。
                    getShortStayStandardRecuperationMeetingAndSendingOff()
                            .setSelectedIndex(3);
                    break;
                case 1:
                    // 「なし」の場合
                    // 送迎区分(shortStayStandardRecuperationMeetingAndSendingOff)の1番目のボタンを選択にする。
                    getShortStayStandardRecuperationMeetingAndSendingOff()
                            .setSelectedIndex(1);
                    break;
                }
            }
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 栄養管理体制
            obj = VRBindPathParser.get("1230402", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_DIETICIAN_MANAGE();
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_DIETICIAN_MANAGE();
                    break;
                }
            }
            // 療養食
            obj = VRBindPathParser.get("1230403", provider);
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
        }
    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        if (!getShortStayStandardRecuperationHospitalRoomDivisionRadio()
                .isSelected()) {
            // 病室区分(shortStayStandardRecuperationHospitalRoomDivisionRadio)が未選択の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }

        if (getShortStayStandardRecuperationDinnerOffer().getSelectedIndex() > 0) {
            // 食事提供（shortStayStandardRecuperationDinnerOffer)が「なし」以外を選択している場合
            if (ACTextUtilities
                    .isNullText(getShortStayStandardRecuperationDinnerCost().getText())) {
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
        if (!getShortStayStandardRecuperationMeetingAndSendingOff().isEnabled()) {
            // 送迎区分(shortStayStandardRecuperationMeetingAndSendingOff)が無効の場合
            // 返却用レコードから、送迎区分(shortStayStandardRecuperationMeetingAndSendingOff)のbindPathを除去する。
            data.remove(getShortStayStandardRecuperationMeetingAndSendingOff()
                    .getBindPath());
        }
        if (!getShortStayStandardRecuperationDieticianManageRadio().isEnabled()) {
            // 栄養管理体制加算(shortStayStandardRecuperationDieticianManageRadio)が無効の場合
            // 返却用レコードから、栄養管理体制加算(shortStayStandardRecuperationDieticianManageRadio)のbindPathを除去する。
            data.remove(getShortStayStandardRecuperationDieticianManageRadio()
                    .getBindPath());
        }
        if (!getShortStayStandardRecuperationMedicalExpensesRadio().isEnabled()) {
            // 療養食加算(shortStayStandardRecuperationMedicalExpensesRadio)が無効の場合
            // 療養食加算(shortStayStandardRecuperationMedicalExpensesRadio)のbindPathを除去する。
            data.remove(getShortStayStandardRecuperationMedicalExpensesRadio()
                    .getBindPath());
        }
        if (!getShortStayStandardRecuperationDinnerCost().isEnabled()){
            // 食事費用(shortStayStandardRecuperationDinnerCost)が無効の場合
            // 返却用レコードから、食事費用(shortStayStandardRecuperationDinnerCost)のbindPathを除去する。
            data.remove(getShortStayStandardRecuperationDinnerCost()
                    .getBindPath());
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
     * 「食事提供選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayStandardRecuperationDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {
        // ※「食事提供」選択時に「食費」の状態切替
        if (getShortStayStandardRecuperationDinnerOffer().getSelectedIndex() < 1) {
            // 「食事提供」が「なし」の場合
            // 食費を無効にする。
            setState_NOT_USE_MEAT();
        } else {
            // 「食事提供」が「なし」以外の場合
            // 食費を有効にする。
            setState_USE_MEAT();
                // 食事費用(shortStayStandardRecuperationDinnerCost)を設定する。
                getShortStayStandardRecuperationDinnerCost().setText(
                        getMeatCost(getShortStayStandardRecuperationDinnerOffer()
                                .getSelectedIndex()));
        }

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
                        .get("1230405", getSelectedProvider()),0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230406", getSelectedProvider()),0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230407", getSelectedProvider()),0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230408", getSelectedProvider()),0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230406", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230407",
                                getSelectedProvider()),0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230407", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230408",
                                getSelectedProvider()),0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230408", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230406",
                                getSelectedProvider()),0));
            }
        }
        // 空文字を返す。
        return "";
    }
    /**
     * 開始時刻入力用のコンボを返します。
     * 
     * @return 開始時刻入力用のコンボ
     */
    public ACComboBox getBeginTimeCombo() {
        // ※開始時刻入力用のコンボを返す。
        // 関数の返り値としてnullを返す。
        return null;
    }

    /**
     * 終了時刻入力用のコンボを返します。
     * 
     * @return 終了時刻入力用のコンボ
     */
    public ACComboBox getEndTimeCombo() {
        // ※終了時刻入力用のコンボを返す。
        //    関数の返り値としてnullを返す。
        return null;
    }

}
