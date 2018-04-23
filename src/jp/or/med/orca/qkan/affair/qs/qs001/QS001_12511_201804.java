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
 * 作成日: 2011/11/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防短期入所療養介護（介護老人保健施設） (QS001_12511_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

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
 * サービスパターン介護予防短期入所療養介護（介護老人保健施設）(QS001_12511_201804)
 */
@SuppressWarnings("serial")
public class QS001_12511_201804 extends QS001_12511_201804Event {
    /**
     * コンストラクタです。
     */
    public QS001_12511_201804() {
        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("施設等の区分", "1250101", "1250101");
        putImportProviderBindPath("人員配置区分（従来型）", "1250123", "1250124");
        putImportProviderBindPath("夜間勤務条件基準", "1250102", "1250104");
        putImportProviderBindPath("療養体制維持特別加算I", "1250117", "1250114");
        putImportProviderBindPath("療養体制維持特別加算II", "1250127", "1250126"); //[H30.4改正]
        putImportProviderBindPath("夜勤職員配置加算", "1250118", "1250120");
        putImportProviderBindPath("サービス提供体制強化加算", "1250121", "1250117");
        putImportProviderBindPath("ユニットケア体制", "1250104", "1250112");

        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("療養食", "1250120", "1250108");
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "1250119", "1250123");
        putRestrictProviderBindPath("ユニットケア体制", "1250104", "1250112");
        putRestrictProviderBindPath("認知症専門ケア加算", "1250126", "1250128"); //[H30.4改正]
        putRestrictProviderBindPath("在宅復帰・在宅療養支援機能加算", "1250125", "1250127"); //[H30.4改正]
    }

    // コンポーネントイベント

    /**
     * 「施設区分選択時イベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayRecuperationHealthFacilityInstitutionDivisionRadioActionPerformed(
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

            // 食事費用(shortStayLifeDinnerCost)を設定する。
            checkMeatCost();
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
        if (new QS001S02_201204().showModal(SYSTEM_SERVICE_KIND_DETAIL,
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

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_12511_201804.class.getName(),
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
        getSpecialMedicalExpense()
                .setBindPathes(
                        QS001S02_201204
                                .getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // ※食事提供
        // コードマスタデータよりCODE_ID：191（食事提供）を取得する。
        // 取得した値を、comboItemMapの KEY : 1250110 の VALUE として設定する。
        comboItemMap.setData("1250110",
                QkanCommon.getArrayFromMasterCode(191, "1250110"));
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
        VRBindPathParser.set("1250110", defaultMap, new Integer(1));
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();
        // 画面の状態を制御する。
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
            VRMap defaultMap = getImportData();

            // ※設定
            Object obj;
            
            // ※事業所連動
            // 職員の欠員による減算の状況（事業所パネル）KEY：1250122の値をチェックする。
            obj = VRBindPathParser.get("1250122", provider);
            switch (ACCastUtilities.toInt(obj, 0)) {
            case 1:
                // 値が1（なし）だった場合
                // defaultMapに KEY：1250109 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1250109", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                // 値が2～7（医師・看護職員・介護職員・PT・OT・ST）だった場合
                // defaultMapに KEY：1250109
                // VALUE：2（介護・看護職員又は医師、PT・OT・STが欠員）を設定する。
                VRBindPathParser.set("1250109", defaultMap, new Integer(3));
                break;
            }
            
            // 2018/02/26 [H30.4改正対応][Shinobu Hitaka] add - begin
            // 在宅復帰・在宅療養支援機能加算
            obj = VRBindPathParser.get("1250125", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // なしだった場合
                    VRBindPathParser.set("1250127", defaultMap, new Integer(1));
                    break;
                case 2: // I型だった場合
                case 3: // II型だった場合
                    VRBindPathParser.set("1250127", defaultMap, new Integer(2));
                    break;
                }
            }
            // 2018/02/26 [H30.4改正対応][Shinobu Hitaka] add - end

            // 2015/03/02 [H27.4改正対応][Shinobu Hitaka] edit - begin 体制があってもなしを選択する。
            VRBindPathParser.set("6", defaultMap, new Integer(1));
            // 送迎体制（事業所パネル）KEY：1250106の値をチェックする。
            //switch (ACCastUtilities.toInt(
            //        VRBindPathParser.get("1250106", provider), 0)) {
            //case 1:
            //    // 値が1（なし）だった場合
            //    // defaultMapに KEY：6 VALUE：1（送迎なし）を設定する。
            //    VRBindPathParser.set("6", defaultMap, new Integer(1));
            //    break;
            //case 2:
            //    // 値が2（あり）だった場合
            //    // defaultMapに KEY：6 VALUE：3（送迎往復）を設定する。
            //    VRBindPathParser.set("6", defaultMap, new Integer(3));
            //    break;
            //}
            // 若年性認知症利用者受入加算をなしに設定する。
            VRBindPathParser.set("1250123", defaultMap, new Integer(1));
            // 2015/03/02 [H27.4改正対応][Shinobu Hitaka] edit - end

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 画面の状態を変更する。
            checkState();

            // 食事提供コンボの値をチェックする。
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
        // 施設等の区分（体制）が未入力の場合
        if (getShortStayRecuperationHealthFacilityInstitutionDivisionRadio()
                .getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }
        
//[H30.4改正]ラジオボタン⇒チェックボックスへ変更によりコメントアウト
//        // 療養体制維持特別加算
//        if (getRecuperationRadio().getSelectedIndex() < 1) {
//            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
//            return null;
//        }
        
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
     * 「画面状態制御」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkState() throws Exception {
        // ※画面状態の制御を行います。
        // 認知症行動・心理症状緊急対応加算 選択時
        if (getDementiaActionAddRadioGroup().getSelectedIndex() == 2) {
            setState_INVALID_YOUNG_DEMENTIA_PATINET();
        } else {
            setState_VALID_YOUNG_DEMENTIA_PATINET();
        }

        // 若年性認知症利用者受入加算 選択時
        if (getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() == 2) {
            setState_INVALID_DEMENTIA_ACTION();
        } else {
            setState_VALID_DEMENTIA_ACTION();
        }
        // ※サービス連動
        // 施設等の区分（サービスパネル）の値をチェックする。
        switch (getShortStayRecuperationHealthFacilityInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            setState_FACILITY_TYPE_1();
            break;
        case 2:
            setState_FACILITY_TYPE_2();
            break;
        case 3:
            setState_FACILITY_TYPE_3();
            break;
        case 4:
            setState_FACILITY_TYPE_4();
            break;
        case 5:
            setState_FACILITY_TYPE_5();
            break;
        case 6:
            setState_FACILITY_TYPE_6();
            break;
        case 7://[H30.4改正] 追加
            setState_FACILITY_TYPE_7();
            break;
        case 8://[H30.4改正] 追加
            setState_FACILITY_TYPE_8();
            break;
        }

        // 事業所体制と同期
        resetStateByRestrictBindPath();
    }

    /**
     * 「食事テキスト制御」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkDinnerState() throws Exception {
        // ※食事テキストの制御を行う
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
                        VRBindPathParser.get("1250108", getSelectedProvider()),
                        0));
                break;
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1250109", getSelectedProvider()),
                        0));
                break;
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1250110", getSelectedProvider()),
                        0));
                break;
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1250111", getSelectedProvider()),
                        0));
                break;
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費と「昼」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1250109", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1250110",
                                getSelectedProvider()), 0));
                break;
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費と「夜」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1250110", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1250111",
                                getSelectedProvider()), 0));
                break;
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費と「朝」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1250111", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1250109",
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
     * 「データバインド後の処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void binded() throws Exception {
        // [ID:0000739][Masahiko.Higuchi] 2012/05 特別療養費項目のクリア処理 del begin
        // if (getSpecialMedicalExpense().getDataModel().isEmpty()) {
        // [ID:0000739][Masahiko.Higuchi] 2012/05 特別療養費項目のクリア処理 del end
        // [ID:0000739][Masahiko.Higuchi] 2012/05 特別療養費項目のクリア処理 add begin
        if (getSpecialMedicalExpense().getDataModel().isEmpty()
                || !getSpecialMedicalExpense().isEnabled()) {
            getSpecialMedicalExpense().clearDataModel();
            // [ID:0000739][Masahiko.Higuchi] 2012/05 特別療養費項目のクリア処理 add end
            // 特別療養費ボタンのデータが空の場合
            // 特別療養費ラベルに「設定なし」と表示する。
            getSpecialMedicalExpenseLabel().setText("設定なし");
        } else {
            // 特別療養費ボタンのデータが空ではない場合
            // 特別療養費ラベルに「設定あり」と表示する。
            getSpecialMedicalExpenseLabel().setText("設定あり");
        }
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
