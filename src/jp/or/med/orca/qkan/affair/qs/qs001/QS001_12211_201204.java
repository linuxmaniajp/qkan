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
 * 作成日: 2011/11/15  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン短期入所療養介護(介護老人保健施設) (QS001_12211_201204)
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
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン短期入所療養介護(介護老人保健施設)(QS001_12211_201204)
 */
@SuppressWarnings("serial")
public class QS001_12211_201204 extends QS001_12211_201204Event {
    /**
     * コンストラクタです。
     */
    public QS001_12211_201204() {
        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("施設区分", "1220101", "1220101");
        putImportProviderBindPath("施設区分（体制）", "1220120", "1220120");
        putImportProviderBindPath("人員配置区分（従来）", "1220127", "1220131");
        putImportProviderBindPath("人員配置区分（療養）", "1220130", "1220132");
        putImportProviderBindPath("夜間勤務基準条件", "1220102", "1220104");
        putImportProviderBindPath("リハビリ機能強化", "1220103", "1220105");
        putImportProviderBindPath("療養環境維持特別加算", "1220121", "1220121");
        putImportProviderBindPath("夜勤職員配置加算", "1220122", "1220122");
        putImportProviderBindPath("サービス提供体制強化加算", "1220125", "1220124");
        putImportProviderBindPath("ユニットケアの整備", "1220117", "1220117");

        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("リハビリ機能強化", "1220103", "1220105");
        putRestrictProviderBindPath("療養食", "1220123", "1220110");
        putRestrictProviderBindPath("認知症ケア加算", "1220119", "1220116");
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "1220124", "1220123");
        putRestrictProviderBindPath("ユニットケアの整備", "1220117", "1220117");
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
     * 「特別療養費クリックイベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayRecuperationHealthFacilitySpecialMedicalExpenseActionPerformed(
            ActionEvent e) throws Exception {
        // ※特別療養費の編集
        // 特別療養費編集画面(QS001200)を生成する。
        // 特別療養費ボタンのデータを引数に生成した特別療養費編集画面(QS001200)のshoModalを実行する。
        if (new QS001S02_201204().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
                        .getDataModel())) {
            // 特別療養費を変更した場合
            if (getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
                    .getDataModel().isEmpty()) {
                // 特別療養費ボタンのデータが空の場合
                // 特別療養費ラベルに「設定なし」と表示する。
                getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel()
                        .setText("設定なし");
            } else {
                // 特別療養費ボタンのデータが空ではない場合
                // 特別療養費ラベルに「設定あり」と表示する。
                getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel()
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
     * 「認知症行動・心理症状緊急対応加算選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void dementiaActionAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ※認知症行動・心理症状緊急対応加算と若年性認知症利用者受入加算の排他制御
        // 画面の状態を変更する。
        checkState();
    }

    /**
     * 「若年性認知症利用者受入加算選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void youngDementiaPatinetAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ※認知症行動・心理症状緊急対応加算と若年性認知症利用者受入加算の排他制御
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
        ACFrame.debugStart(new ACAffairInfo(QS001_12211_201204.class.getName(),
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
        // 特別療養費ボタンに設定された値をクリアする
        getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
                .clearDataModel();
        // QS001200(特別療養費)よりサービス種類(SYSTEM_SERVICE_KIND_DETAIL)に応じたbindPath配列を取得し、特別療養費ボタンに設定する。
        getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
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
        // 取得した値を、comboItemMapの KEY : 1220112 の VALUE として設定する。
        comboItemMap.setData("1220112",
                QkanCommon.getArrayFromMasterCode(191, "1220112"));
        // ※時間区分
        // コードマスタデータよりCODE_ID：273（時間区分）を取得する。
        // 取得した値を、comboItemMapの KEY : 1220125 の VALUE として設定する。
        comboItemMap.setData("1220125",
                QkanCommon.getArrayFromMasterCode(273, "1220125"));
        // ※展開
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();
        // ※選択項目の初期設定
        QkanCommon.selectFirstRadioItem(this);
        // ※準備
        // 初期選択設定用のレコード defaultMap を生成する。
        VRMap defaultMap = new VRHashMap();
        // ※設定
        // ※食事提供
        // comboItemMapの KEY : 1220112 の VALUE として1を設定する。
        VRBindPathParser.set("1220112", defaultMap, new Integer(1));
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
            VRMap defaultMap = getImportData();

            // ※設定
            Object obj;

            // 人員減算
            obj = VRBindPathParser.get("1220126", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // なしだった場合
                    VRBindPathParser.set("1220111", defaultMap, new Integer(1));
                    break;
                case 2: // 医師だった場合
                case 3: // 看護職員だった場合
                case 4: // 介護職員だった場合
                case 5: // 理学療法士だった場合
                case 6: // 作業療法士だった場合
                case 7: // 言語聴覚士だった場合
                    VRBindPathParser.set("1220111", defaultMap, new Integer(3));
                    break;
                }
            }

            // 送迎
            obj = VRBindPathParser.get("1220105", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 送迎区分(shortStayRecuperationHealthFacilityMeetingAndSendingOff)の3番目のボタンを選択にする。
                    VRBindPathParser.set("6", defaultMap, new Integer(3));
                    break;
                case 1:
                    // 「なし」の場合
                    // 送迎区分(shortStayRecuperationHealthFacilityMeetingAndSendingOff)の1番目のボタンを選択にする。
                    VRBindPathParser.set("6", defaultMap, new Integer(1));
                    break;
                }
            }

            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();

            if (getShortStayRecuperationHealthFacilityDinnerOffer()
                    .getSelectedIndex() == 0) {
                // 食費なしの場合にのみ朝昼夜にする。
                getShortStayRecuperationHealthFacilityDinnerOffer()
                        .setSelectedIndex(1);
            }

            checkState();
        }

    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        // 施設等の区分（体制）　
        // 日帰りショートステイの場合はエラーにしない
        // if (getShortStayRecuperationHealthFacilityInstitutionDivisionRadio()
        // .getSelectedIndex() != 3
        // && getShortStayRecuperationHealthFacilityDivision()
        // .getSelectedIndex() < 1) {
        // QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
        // return null;
        // }
        // 療養体制維持特別加算
        if (getShortStayRecuperationHealthFacilityRecuperationRadio()
                .getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        if (getShortStayRecuperationHealthFacilityDinnerOffer()
                .getSelectedIndex() > 0) {
            // 食事提供（shortStayRecuperationHealthFacilityDinnerOffer)が「なし」以外を選択している場合
            if (ACTextUtilities
                    .isNullText(getShortStayRecuperationHealthFacilityDinnerCost()
                            .getText())) {
                // 食事費用(shortStayRecuperationHealthFacilityDinnerCost)が空欄の場合
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
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ※開始時刻入力用のコンボを返す。
        // 　関数の返り値として開始時間コンボを返す。
        return null;
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 　関数の返り値として終了時間コンボを返す。
        return null;
    }

    /**
     * 「データバインド後の処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void binded() throws Exception {
        // [ID:0000739][Masahiko.Higuchi] 2012/05 特別療養費項目のクリア処理 del begin
        // if (getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
        // .getDataModel().isEmpty()) {
        // [ID:0000739][Masahiko.Higuchi] del end
        // [ID:0000739][Masahiko.Higuchi] 2012/05 特別療養費項目のクリア処理 add begin
        if (getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
                .getDataModel().isEmpty()
                || !getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
                        .isEnabled()) {
            // バインド時にクリアする
            getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
                    .clearDataModel();
            // [ID:0000739][Masahiko.Higuchi] 2012/05 特別療養費項目のクリア処理 add begin
            // 特別療養費ボタンのデータが空の場合
            // 特別療養費ラベルに「設定なし」と表示する。
            getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel()
                    .setText("設定なし");
        } else {
            // 特別療養費ボタンのデータが空ではない場合
            // 特別療養費ラベルに「設定あり」と表示する。
            getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel()
                    .setText("設定あり");
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
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1220109", getSelectedProvider()),
                        0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1220110", getSelectedProvider()),
                        0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1220111", getSelectedProvider()),
                        0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1220112", getSelectedProvider()),
                        0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1220110", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1220111",
                                getSelectedProvider()), 0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1220111", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1220112",
                                getSelectedProvider()), 0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1220112", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1220110",
                                getSelectedProvider()), 0));
            }
        }
        // 空文字を返す。
        return "";
    }

    /**
     * 「画面状態制御」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * 
     */
    public void checkState() throws Exception {
        // ※画面状態制御処理
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

        // 認定履歴を取得し、要介護度４または５の利用者であるか確認
        boolean overKaigodo4 = false;
        VRList ninteiList = getCalculater().getPatientInsureInfoHistoryList();
        for (int i = 0; i < ninteiList.size(); i++) {
            VRMap nintei = (VRMap) ninteiList.get(i);

            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("JOTAI_CODE", nintei), 0)) {
            case 24: // 要介護４
            case 25: // 要介護５
                overKaigodo4 = true;
                break;
            }
        }

        // 「施設区分」の値をチェックする。
        // 認定
        switch (getShortStayRecuperationHealthFacilityInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            setState_STATE_MODE_1();
            if (overKaigodo4) {
                setState_VALID_MEDICAL_MANAGEMENT();
            } else {
                setState_INVALID_MEDICAL_MANAGEMENT();
            }
            break;
        case 2:
            setState_STATE_MODE_2();
            if (overKaigodo4) {
                setState_VALID_MEDICAL_MANAGEMENT();
            } else {
                setState_INVALID_MEDICAL_MANAGEMENT();
            }
            break;
        case 3:
            setState_STATE_MODE_3();
            setState_INVALID_MEDICAL_MANAGEMENT();
            break;
        case 4:
            setState_STATE_MODE_4();
            setState_INVALID_MEDICAL_MANAGEMENT();
            break;
        case 5:
            setState_STATE_MODE_5();
            setState_INVALID_MEDICAL_MANAGEMENT();
            break;
        case 6:
            setState_STATE_MODE_6();
            setState_INVALID_MEDICAL_MANAGEMENT();
            break;
        case 7:
            setState_STATE_MODE_7();
            if (overKaigodo4) {
                setState_VALID_MEDICAL_MANAGEMENT();
            } else {
                setState_INVALID_MEDICAL_MANAGEMENT();
            }
            break;
        }

        // 上記処理で有効になったコントロールでも、事業所体制で制約を受けるものは上書きで制御する。
        resetStateByRestrictBindPath();
    }
}
