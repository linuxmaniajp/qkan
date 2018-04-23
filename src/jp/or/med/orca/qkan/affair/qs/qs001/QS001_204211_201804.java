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
 * 開発者: 
 * 作成日: 
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン短期入所療養介護（介護医療院）(QS001_204211_201804)
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
 * サービスパターン短期入所療養介護（介護医療院）(QS001_204211_201804)
 */
@SuppressWarnings("serial")
public class QS001_204211_201804 extends QS001_204211_201804Event {
    /**
     * コンストラクタです。
     */
    public QS001_204211_201804() {
        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("施設区分", "20420101", "20420101");
        putImportProviderBindPath("人員配置区分（I型）", "20420102", "20420102");
        putImportProviderBindPath("人員配置区分（II型）", "20420103", "20420103");
        putImportProviderBindPath("人員配置区分（特別型）", "20420104", "20420104");
        
        putImportProviderBindPath("ユニットケア体制", "20420107", "20420109");        
        putImportProviderBindPath("療養環境基準（廊下）", "20420108", "20420111");
        putImportProviderBindPath("療養環境基準（療養室）", "20420109", "20420112");  
        
        putImportProviderBindPath("サービス提供体制強化加算", "20420115", "20420122");
        
        


        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("療養食", "20420112", "20420118");
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "20420110", "20420117");
        putRestrictProviderBindPath("ユニットケア体制", "20420107", "20420109");
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
     * 「特別診療費編集」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayHospitalRecuperationSpecificConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {
        // ※特別診療費の編集
        // 特別診療費編集画面(QS001S03_201804)を生成する。
        // 特別診療費ボタンのデータを引数に生成した特別診療費編集画面(QS001S03_201804)のshoModalを実行する。
        if (new QS001S03_201804().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getShortStayHospitalRecuperationSpecificConsultationFee()
                        .getDataModel())) {
            // 特別診療費を変更した場合
            if (getShortStayHospitalRecuperationSpecificConsultationFee()
                    .getDataModel().isEmpty()) {
                // 特別診療費ボタンのデータが空の場合
                // 特別診療費ラベルに「設定なし」と表示する。
                getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                        .setText("設定なし");
            } else {
                // 特別診療費ボタンのデータが空ではない場合
                // 特別診療費ラベルに「設定あり」と表示する。
                getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                        .setText("設定あり");
            }
        }

    }

    
    /**
     * 「人員減算選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
	@Override
	protected void medicalFacilityHospitalSubstractionSelectionChanged(
			ListSelectionEvent e) throws Exception {
        // 人員減算の選択処理
        checkState();
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
    
    /**
     * 「夜間勤務条件基準選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
	@Override
	protected void shortStayHospitalRecuperationTypeSelectionChanged(
			ListSelectionEvent e) throws Exception {
        // 状態制御
        checkState();
	}
	

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_12311_201804.class.getName(),
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
        getShortStayHospitalRecuperationSpecificConsultationFee()
                .clearDataModel();
        // (特別診療費)よりサービス種類(SYSTEM_SERVICE_KIND_DETAIL)に応じたbindPath配列を取得し、特別診療費ボタンに設定する。
        getShortStayHospitalRecuperationSpecificConsultationFee()
                .setBindPathes(
                        QS001S03_201804
                                .getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // コードマスタデータよりCODE_ID：191（食事提供）を取得する。
        // 取得した値を、comboItemMapの KEY : 1230150 の VALUE として設定する。
        comboItemMap.setData("20420123",
                QkanCommon.getArrayFromMasterCode(191, "20420123"));

        // ※時間区分
        // コードマスタデータよりCODE_ID：273（時間区分）を取得する。
        // 取得した値を、comboItemMapの KEY : 20420108 の VALUE として設定する。
        comboItemMap.setData("20420108",
                QkanCommon.getArrayFromMasterCode(273, "20420108"));
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
        VRBindPathParser.set("20420123", defaultMap, new Integer(1));

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
            obj = VRBindPathParser.get("20420106", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // なしだった場合
                    VRBindPathParser.set("20420114", defaultMap, new Integer(1));
                    break;
                case 2: // 医師だった場合
                case 3: // 薬剤師だった場合
                case 4: // 看護職員だった場合
                case 5: // 介護職員だった場合
                    VRBindPathParser.set("20420114", defaultMap, new Integer(3));
                    break;
                }
            }

            // 夜間勤務条件基準
            obj = VRBindPathParser.get("20420105", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // 基準型
                    VRBindPathParser.set("20420113", defaultMap, new Integer(1));
                    break;
                case 2: // 加算型I
                    VRBindPathParser.set("20420110", defaultMap, new Integer(2));
                    break;
                case 3: // 加算型II
                    VRBindPathParser.set("20420110", defaultMap, new Integer(3));
                    break;
                case 4: // 加算型III
                    VRBindPathParser.set("20420110", defaultMap, new Integer(4));
                    break;
                case 5: // 加算型IV
                    VRBindPathParser.set("20420110", defaultMap, new Integer(5));
                    break;
                case 6: // 減算型
                    VRBindPathParser.set("20420113", defaultMap, new Integer(2));
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
        

        // 人員減算チェック
        if (!getMedicalFacilityHospitalSubstraction().getSelectedButton()
                .isEnabled()) {
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
        
        if (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex() == 1
                || getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex() == 4) {
            // 人員配置区分チェック
            if (!getStaffAssignment1Division().getSelectedButton()
                    .isEnabled()) {
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
        }
        if (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex() == 2) {
            // 人員配置区分チェック
            if (!getStaffAssignment2Division().getSelectedButton()
                    .isEnabled()) {
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
        }
        if (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex() == 3
                || getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex() == 6) {
            // 人員配置区分チェック
            if (!getStaffAssignment3Division().getSelectedButton()
                    .isEnabled()) {
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
                        VRBindPathParser.get("20420116", getSelectedProvider()),
                        0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("20420117", getSelectedProvider()),
                        0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("20420118", getSelectedProvider()),
                        0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("20420119", getSelectedProvider()),
                        0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("20420117", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("20420118",
                                getSelectedProvider()), 0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("20420118", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("20420119",
                                getSelectedProvider()), 0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("20420119", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("20420117",
                                getSelectedProvider()), 0));
            }
        }
        // 空文字を返す。
        return "";
    }

    public void binded() throws Exception {
        if (getShortStayHospitalRecuperationSpecificConsultationFee()
                .getDataModel().isEmpty()) {
            // 特別診療費ボタンのデータが空の場合
            // 特別診療費ラベルに「設定なし」と表示する。
            getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                    .setText("設定なし");
        } else {
            // 特別診療費ボタンのデータが空ではない場合
            // 特別診療費ラベルに「設定あり」と表示する。
            getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                    .setText("設定あり");
        }
    }

    /**
     * 「画面状態制御」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * 
     */
    public void checkState() throws Exception {
        // ※画面状態制御処理


        // ｢正看比率が20%未満の場合｣
        if (getMedicalFacilityHospitalSubstraction().getSelectedIndex() == 4) {
            // 無効にする
        	setPersonSubtractFlag(false);
        } else {
            // 有効にする
        	setPersonSubtractFlag(true);
        }

        // 「施設区分」の値をチェックする。
        switch (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // 「I型」の場合
            setState_FACILITY_TYPE_NORMAL();
            break;
        case 2:
            // 「II型」」の場合
            setState_FACILITY_TYPE_NORMAL2();
            break;
        case 3:
            // 「特別型」の場合
            setState_FACILITY_TYPE_SPECIAL();
            break;

        case 4:
        	// 「ユニット型I型」の場合
            setState_FACILITY_TYPE_UNIT();
            break;
        case 5:
        	// 「ユニット型II型」の場合
            setState_FACILITY_TYPE_UNIT2();
            break;
        case 6:
        	// 「ユニット型特別型」の場合
            setState_FACILITY_TYPE_UNIT_SPECIAL();
            break;
        case 7:
            // ｢日帰りショートステイ｣の場合
            setState_FACILITY_TYPE_SHORT_STAY();
            break;
        }
        
        // 人員減算による人員配置区分の制御
        // 施設区分をチェックする
        switch (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {

        case 1:
        case 2:
        case 3:
        case 6:
        	// 「I型」の場合
        	// 「特別介護医療院」の場合
        	// 「ユニット型特別介護医療院」の場合
        	// 人員減算の値を考慮し状態を変更する。
            if (getPersonSubtractFlag()) {
                setState_VALID_PERSON_SUBTRACTION();
            } else {
                setState_INVALID_PERSON_SUBTRACTION();
            }
            break;
        case 4:
            // 「ユニット型I型」の場合
            // 人員減算の値を考慮し状態を変更する。
            if (!getPersonSubtractFlag()) {
                setState_INVALID_PERSON_SUBTRACTION_UNIT();
            }
            break;
        }
        

        // ※認知症行動・心理症状緊急対応加算と若年性認知症利用者受入加算の排他制御
        if (getDementiaActionAddRadioGroup().getSelectedIndex() == 2) {
            // 認知症行動・心理症状緊急対応加算(dementiaActionAddRadioGroup)が「あり」の場合
            // 若年性認知症利用者受入加算(youngDementiaPatinetAddRadioGroup)を無効にする。
            setState_INVALID_YOUNG_DEMENTIA_PATINET();
            // 緊急短期入所受入加算(emergencyAcceptanceRadioGroup)を無効にする。
            setState_INVALID_EMERGENCY_ACCEPTANCE();
        } else {
            // 上記以外の場合
            // 若年性認知症利用者受入加算(youngDementiaPatinetAddRadioGroup)を有効にする。
            setState_VALID_YOUNG_DEMENTIA_PATINET();
            // 緊急短期入所受入加算(emergencyAcceptanceRadioGroup)を有効にする。
            setState_VALID_EMERGENCY_ACCEPTANCE();
        }
        
        // 夜間勤務条件基準により夜間勤務等看護加算制御
        if (getShortStayHospitalRecuperationTypeNone().isSelected()) {
            setState_INVALID_HOSPITAL_RECUPERATION();
        } else {
            setState_VALID_HOSPITAL_RECUPERATION();
        }


        resetStateByRestrictBindPath();
    }




}
