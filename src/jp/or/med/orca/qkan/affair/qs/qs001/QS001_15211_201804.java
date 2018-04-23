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
 * プログラム サービスパターン介護老人保健施設 (QS001_15211_201804)
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
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン介護老人保健施設(QS001_15211_201804)
 */
@SuppressWarnings("serial")
public class QS001_15211_201804 extends QS001_15211_201804Event {
    /**
     * コンストラクタです。
     */
    public QS001_15211_201804() {

        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("施設区分", "1520101", "1520101");
        putImportProviderBindPath("施設区分（体制）", "1520122", "1520132");
        putImportProviderBindPath("人員配置区分（従来型）", "1520132", "1520143");
        putImportProviderBindPath("療養体制維持特別加算I", "1520124", "1520134");
        putImportProviderBindPath("療養体制維持特別加算II", "1520136", "1520152"); //[H30.4改正]
        putImportProviderBindPath("夜勤職員配置加算", "1520126", "1520136");
        putImportProviderBindPath("栄養マネジメント加算", "1520130", "1520111");
        putImportProviderBindPath("サービス提供体制強化加算", "1520129", "1520142");
        putImportProviderBindPath("夜間勤務条件基準", "1520102", "1520104");
        putImportProviderBindPath("ユニットケア体制", "1520119", "1520127");

        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("栄養マネジメント", "1520130", "1520111");
        putRestrictProviderBindPath("療養食加算", "1520125", "1520113");
        putRestrictProviderBindPath("若年性認知症入所者受入加算", "1520127", "1520138");
        putRestrictProviderBindPath("ユニットケア体制", "1520119", "1520127");
        putRestrictProviderBindPath("認知症専門ケア加算", "1520128", "1520137");
        putRestrictProviderBindPath("認知症ケア加算", "1520121", "1520128");
        putRestrictProviderBindPath("褥瘡マネジメント加算", "1520135", "1520157"); //[H30.4改正]
        putRestrictProviderBindPath("在宅復帰・在宅療養支援機能加算", "1520133", "1520140"); //[H30.4改正]
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

    
    /**
     * 「栄養マネジメント加算の変更」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoHealthCareOfTheAgedNutritionRadioSelectionChanged(
                ListSelectionEvent e) throws Exception {
        changeState();
    }

    /**
     * 「経口移行加算の変更」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoHealthCareOfTheAgedOralSwitchRadioSelectionChanged(
    	        ListSelectionEvent e) throws Exception {
        changeState();
    }
    /**
     * 「経口維持加算に伴う画面状態設定」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void oralMaintenanceAddSelectionChanged(ListSelectionEvent e) 
            throws Exception {
        changeState();
    }

    /**
     * 「認知症行動・心理症状緊急対応加算選択」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void dementiaEmergencyAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception{
    	changeState();

    }

    /**
     * 「若年性認知症利用者受入加算選択」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void youngDementiaPatinetAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception{
    	changeState();

    }
	
    /**
     * 「外泊加算選択」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
	@Override
	protected void kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioSelectionChanged(ListSelectionEvent e)
			throws Exception {
    	changeState();
	}

    /**
     * 「外泊時在宅サービス利用費用選択」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
	@Override
	protected void homeServiceUsageFeeAtHomeSelectionChanged(
			ListSelectionEvent e) throws Exception {
    	changeState();
	}

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_15211_201804.class.getName(),
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
        // 食事提供
        comboItemMap.setData("1520120",
                QkanCommon.getArrayFromMasterCode(191, "1520120"));
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
            VRMap defaultMap = getImportData();
            // ※設定
            Object obj;

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
            
            // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - begin
            // 在宅復帰・在宅療養支援機能加算
            obj = VRBindPathParser.get("1520133", provider);
            if (obj != null) {
                // 事業所登録の加算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // なしだった場合
                    VRBindPathParser.set("1520140", defaultMap, new Integer(1));
                    break;
                case 2: // I型だった場合
                case 3: // II型だった場合
                    VRBindPathParser.set("1520140", defaultMap, new Integer(2));
                    break;
                }
            }
            // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - end

            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

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
            
            // 若年性認知症利用者受入加算をなしに設定する。
            VRBindPathParser.set("1520138", defaultMap, new Integer(1));

            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();

            if (getKaigoHealthCareOfTheAgedDinnerOffer().getSelectedIndex() == 0) {
                // 食費なしの場合にのみ朝昼夜にする。
                getKaigoHealthCareOfTheAgedDinnerOffer().setSelectedIndex(1);
            }

            changeState();
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

//[H30.4改正]ラジオボタン⇒チェックボックスへ変更によりコメントアウト        
//        // 療養環境維持特別体制が未選択であないかチェックする。
//        if (getRecuperationRadio().getSelectedIndex() < 1) {
//            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
//            return null;
//        }

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
        if (!getSpecialMedicalExpense().isEnabled()) {
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
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1520110", getSelectedProvider()),
                        0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1520111", getSelectedProvider()),
                        0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1520112", getSelectedProvider()),
                        0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1520113", getSelectedProvider()),
                        0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1520111", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520112",
                                getSelectedProvider()), 0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1520112", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520113",
                                getSelectedProvider()), 0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1520113", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520111",
                                getSelectedProvider()), 0));
            }
        }
        // 空文字を返す。
        return "";
    }

    /**
     * 「データバインド後の処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void binded() throws Exception {
        // ※データバインド後の処理
        // [ID:0000739][Masahiko.Higuchi] 2012/05 特別療養費項目のクリア処理 del begin
        // if (getSpecialMedicalExpense().getDataModel().isEmpty()) {
        // [ID:0000739][Masahiko.Higuchi] 2012/05 特別療養費項目のクリア処理 del end
        // [ID:0000739][Masahiko.Higuchi] 2012/05 特別療養費項目のクリア処理 add begin
        if (getSpecialMedicalExpense().getDataModel().isEmpty()
                || !getSpecialMedicalExpense().isEnabled()) {
            getSpecialMedicalExpense().clearDataModel();
            // [ID:0000739][Masahiko.Higuchi] 2012/05 特別療養費項目のクリア処理 add begin
            // 特別療養費ボタンのデータが空の場合
            // 特別療養費ラベルに「設定なし」と表示する。
            getSpecialMedicalExpenseLabel().setText("設定なし");
        } else {
            // 特別療養費ボタンのデータが空ではない場合
            // 特別療養費ラベルに「設定あり」と表示する。
            getSpecialMedicalExpenseLabel().setText("設定あり");
        }

    }

    protected void kaigoHealthCareOfTheAgedDivisionSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 画面状態制御
        changeState();

    }

    public void changeState() throws Exception {
    	
        // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - begin
        // 「特別介護保険施設サービス費」で無効となっている項目があれば有効にしておく
        setState_VALID_SPECIAL();
        // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - end
        
        
        // 「施設区分」の値をチェックする。
        switch (getKaigoHealthCareOfTheAgedDivisionRadio().getSelectedIndex()) {
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
        case 7:
            setState_FACILITY_TYPE_7();
            break;
        case 8:
            setState_FACILITY_TYPE_8();
            break;
        }


        
        // 口腔機能維持管理体制加算
        if (getOralKeepStructureAddRadioGroup().getSelectedIndex() == 1) {
            setState_INVALID_ORAL_CARE();
        } else {
            setState_VALID_ORAL_CARE();
        }

        // 算定区分が、加算のみ算定である場合
        if (getKaigoHealthCareOfTheAgedCalculationDivisionRadio()
                .getSelectedIndex() == 2) {
            // ターミナルケア加算の選択状況による制御
            switch (getTerminalRadio().getSelectedIndex()) {
            case 1: // なし選択時
                setState_INVALID_TERMINAL();
                break;
            case 2:
            case 3:
            case 4:
                setState_VALID_TERMINAL();
                break;
            }
        } else {
            setState_INVALID_TERMINAL();
        }
        
        // 栄養マネジメント加算の状態を基に経口移行加算、経口維持加算の有効状態を変更
        if (getKaigoHealthCareOfTheAgedNutritionRadioItem2().isSelected()) {
            // 経口移行加算の状態を元に制御
            if (getKaigoHealthCareOfTheAgedOralSwitchRadioItem2().isSelected()) {
                setState_INVALID_KEEP_NUTRITION();
            } else {
                setState_VALID_KEEP_NUTRITION();
            }
            
            // 経口維持加算の状態を元に制御
            if (getOralMaintenanceAddItem2().isSelected()) {
                setState_INVALID_NUTRITION();
            } else {
                setState_VALID_NUTRITION();
            }
            
            // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - begin
            // 低栄養リスク改善加算
            // 栄養マネジメント加算を算定している、かつ経口移行加算及び経口維持加算を算定していない
            if (getKaigoHealthCareOfTheAgedOralSwitchRadioItem1().isSelected()
            		&& getOralMaintenanceAddItem1().isSelected()) {
            	// 低栄養リスク改善加算を有効
            	setState_VALID_LOW_NUTRITIONAL();
            } else {
            	// 低栄養リスク改善加算を無効
            	setState_INVALID_LOW_NUTRITIONAL();
            }
            
            // 栄養マネジメント加算を算定している場合、
            // 再入所時栄養連携加算を有効
            setState_VALID_RE_ENTRY_NUTRITION();
            // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - end
        } else {
            setState_INVALID_NUTRITION();
            setState_INVALID_KEEP_NUTRITION();
            // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - begin
            // 栄養マネジメント加算を算定していない場合、
            // 再入所時栄養連携加算を無効
            setState_INVALID_RE_ENTRY_NUTRITION();
        	// 低栄養リスク改善加算を無効
        	setState_INVALID_LOW_NUTRITIONAL();
            // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - end
        }
        
        // 経口維持加算の状態を基に経口維持加算２の有効状態を変更
        if (getKaigoHealthCareOfTheAgedNutritionRadioItem2().isSelected()
                && getOralMaintenanceAddItem2().isSelected()) {
            setState_VALID_ORAL_MAINTENANCE2();
        } else {
        	setState_INVALID_ORAL_MAINTENANCE2();
        }
        
        // 認知症行動・心理症状緊急対応加算と若年性認知症利用者受入加算の排他制御
        if (getDementiaEmergencyAddRadioGroup().getSelectedIndex() == 2) {
            // 認知症行動・心理症状緊急対応加算が「あり」の場合
            // 若年性認知症利用者受入加算を無効にする。
            setState_INVALID_YOUNG_DEMENTIA_PATINET();
        } else {
            // 上記以外の場合
            // 若年性認知症利用者受入加算を有効にする。
            setState_VALID_YOUNG_DEMENTIA_PATINET();
        }
        if (getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() == 2) {
            // 若年性認知症利用者受入加算が「あり」の場合
            // 認知症行動・心理症状緊急対応加算を無効にする。
            setState_INVALID_DEMENTIA_ACTION();
        } else {
            // 上記以外の場合
            // 認知症行動・心理症状緊急対応加算を有効にする。
            setState_VALID_DEMENTIA_ACTION();
        }
        
        // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - begin
        // 外泊時費用と外泊時の在宅サービス費用の排他制御
        // 外泊加算がありの場合
        if (getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2().isSelected()) {
        	// 外泊時の在宅サービス費用を無効にする
            setState_INVALID_HOME_SERVICE_USAGE();
        } else {
        	// 外泊時の在宅サービス費用を有効にする
            setState_VALID_HOME_SERVICE_USAGE();
        }
        // 外泊時の在宅サービス費用がありの場合
        if (getHomeServiceUsageFeeAtHomeItem2().isSelected()) {
        	// 外泊加算を無効にする
            setState_INVALID_GAIHAKU();
        } else {
        	// 外泊加算を有効にする
            setState_VALID_GAIHAKU();
        }
        // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - end
        
        // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - begin
        // 施設区分をチェックする
        switch (getKaigoHealthCareOfTheAgedDivisionRadio().getSelectedIndex()) {
        case 7:
        case 8:
        	// 「特別介護保険施設サービス費」の場合に算定不可となる加算を無効にする
        	setState_INVALID_SPECIAL();
            break;
        }
        // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - end


        // 上記処理で有効になったコントロールでも、事業所体制で制約を受けるものは上書きで制御する。
        resetStateByRestrictBindPath();
    }

    @Override
    protected void kaigoHealthCareOfTheAgedHospitalDivision1ActionPerformed(
            ActionEvent e) throws Exception {
        changeState();
    }

    @Override
    protected void oralKeepStructureAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        changeState();

    }

    @Override
    protected void terminalRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        changeState();
    }

    @Override
    protected void kaigoHealthCareOfTheAgedCalculationDivisionRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        changeState();
    }




    
}
