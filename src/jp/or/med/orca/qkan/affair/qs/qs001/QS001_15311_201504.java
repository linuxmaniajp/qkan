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
 * プログラム サービスパターン介護療養型医療施設（病院） (QS001_15311_201504)
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
 * サービスパターン介護療養型医療施設（病院）(QS001_15311_201504)
 */
@SuppressWarnings("serial")
public class QS001_15311_201504 extends QS001_15311_201504Event {
    /**
     * コンストラクタです。
     */
    public QS001_15311_201504() {
        
        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");
        
        // 事業所からの値引き継ぎ
        putImportProviderBindPath("人員配置区分（病院療養型用）", "1530129", "1530102");
        putImportProviderBindPath("施設区分", "1530128", "1530162");
        putImportProviderBindPath("夜間勤務条件基準", "1530130", "1530163");
        putImportProviderBindPath("医師の配置基準", "1530105", "1530107");
        putImportProviderBindPath("サービス提供体制強化加算", "1530124", "1530167");
        putImportProviderBindPath("栄養マネジメント加算", "1530126", "1530112");
        putImportProviderBindPath("ユニットケアの整備", "1530131", "1530116");
        putImportProviderBindPath("療養環境基準", "1530127", "1530168");

        putImportProviderBindPath("人員配置区分（ユニット型病院療養型用）", "1530132", "1530121");
        putImportProviderBindPath("人員配置区分（病院経過型用）", "1530133", "1530122");
        
        // 事業所の設定により無効にする
        putRestrictProviderBindPath("若年性認知症患者受入加算", "1530121", "1530164");
        putRestrictProviderBindPath("栄養マネジメント加算", "1530126", "1530112");
        putRestrictProviderBindPath("療養食加算", "1530122", "1530114");
        putRestrictProviderBindPath("認知症専門ケア加算", "1530123", "1530166");
        putRestrictProviderBindPath("ユニットケアの整備", "1530131", "1530116");

    }

    // コンポーネントイベント

    /**
     * 「施設区分選択時イベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityHospitalInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ※「施設区分」選択時の「病室区分」の状態切替
        // 「施設区分」の値をチェックする。
        switch (getMedicalFacilityHospitalInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // 「病院」の場合
            // 「病室区分(通常)」を有効にし、「病室区分(ユニット型)」を無効にする。
            setState_CONVENTIONAL_FORM();
            break;
        case 2:
            // 「ユニット型病院」の場合
            // 「病室区分(通常)」を無効にし、「病室区分(ユニット型)」を有効にする。
            setState_UNIT_FORM();
            break;
        case 3:
            // 「経過型」の場合
            // 「病室区分(通常)」を有効にし、「病室区分(ユニット型)」を無効にする。
            setState_PASSAGE_FORM();
            break;

        case 4:
            // 「病室区分(通常)」を無効にし、「病室区分(ユニット型)」を有効にする。
            setState_UNIT_FORM();
            // 試行的退所を有効
            setState_VALID_TRIAL_HIJO();
            break;
        }
        // 人員配置区分を制御する
        changeStaffDivisionState();

        // 画面の状態制御
        checkState();
    }

    /**
     * 「人員減算コンボ選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityHospitalSubstractionActionPerformed(
            ActionEvent e) throws Exception {
        // 人員減算コンボ選択
        // ｢看護・看護職員が欠員の場合｣｢正看比率が20%未満の場合｣｢僻地届出無｣
        if (getMedicalFacilityHospitalSubstraction().getSelectedIndex() == 2
                || getMedicalFacilityHospitalSubstraction().getSelectedIndex() == 4
                || getMedicalFacilityHospitalSubstraction().getSelectedIndex() == 6) {
            // 無効にする
            setPersonSubstraction(false);
        } else {
            // 有効にする
            setPersonSubstraction(true);
        }
        // 人員配置区分を制御する
        changeStaffDivisionState();

    }

    /**
     * 「特定診療費の設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityHospitalConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {
        // ※特定診療費の編集
        // 特定診療費編集画面(QS001199_H2104)を生成する。
        // 特定診療費ボタンのデータを引数に生成した特定診療費編集画面(QS001028)のshoModalを実行する。
        if (new QS001S01_201204().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getMedicalFacilityHospitalConsultationFee().getDataModel())) {
            // 特定診療費を変更した場合
            if (getMedicalFacilityHospitalConsultationFee().getDataModel()
                    .isEmpty()) {
                // 特定診療費ボタンのデータが空の場合
                // 特定診療費ラベルに「設定なし」と表示する。
                getMedicalFacilityHospitalConsultationFeeLabel()
                        .setText("設定なし");
            } else {
                // 特定診療費ボタンのデータが空ではない場合
                // 特定診療費ラベルに「設定あり」と表示する。
                getMedicalFacilityHospitalConsultationFeeLabel()
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
    protected void medicalFacilityDinnerOfferActionPerformed(ActionEvent e)
            throws Exception {
        // ※「食事提供」選択時に「食費」の状態切替
        if (getMedicalFacilityDinnerOffer().getSelectedIndex() < 1) {
            // 「食事提供」が「なし」の場合
            // 食費を無効にする。
            setState_NOT_USE_MEAT();
        } else {
            // 「食事提供」が「なし」以外の場合
            // 食費を有効にする。
            setState_USE_MEAT();
            // 食事費用(medicalFacilityDinnerCost)を設定する。
            getMedicalFacilityDinnerCost().setText(
                    getMeatCost(getMedicalFacilityDinnerOffer()
                            .getSelectedIndex()));
        }

    }
    
    /**
     * 「栄養マネジメント加算の変更」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityHospitalNutritionRadioSelectionChanged(
    		ListSelectionEvent e) throws Exception {
    	checkState();
    }

    /**
     * 「経口移行加算の変更」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityHospitalOralSwitchRadioSelectionChanged(
    		ListSelectionEvent e) throws Exception {
    	checkState();
    }

    /**
     * 「経口維持加算に伴う画面状態設定」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void oralMaintenanceAddSelectionChanged(ListSelectionEvent e) 
    		throws Exception {
    	checkState();
    }

    /**
     * 「他科受信の有無」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityHospitalMedicalExaminationRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {

        // 画面制御
        checkState();
    }

    /**
     * 「外泊加算の有無」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityHospitalStayRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {

        // 画面制御
        checkState();
    }

    /**
     * 「試行的退院サービス費の有無」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void trialHijoRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {

        // 画面制御
        checkState();
    }

    /**
     * 「認知症行動・心理症状緊急対応加算選択」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void dementiaEmergencyAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception{
    	checkState();

    }

    /**
     * 「若年性認知症利用者受入加算選択」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void youngDementiaPatinetAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception{
    	checkState();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_15311_201504.class.getName(),
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
        getMedicalFacilityHospitalConsultationFee().clearDataModel();
        // QS001199_H2104(特定診療費)よりサービス種類(SYSTEM_SERVICE_KIND_DETAIL)に応じたbindPath配列を取得し、特定診療費ボタンに設定する。
        getMedicalFacilityHospitalConsultationFee()
                .setBindPathes(
                        QS001S01_201204
                                .getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // 食事提供
        comboItemMap.setData("1530159",
                QkanCommon.getArrayFromMasterCode(191, "1530159"));
        // 人員減算
        comboItemMap.setData("1530158",
                QkanCommon.getArrayFromMasterCode(107, "1530158"));
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
        VRBindPathParser.set("1530159", defaultMap, new Integer(1));
        // 人員減算
        VRBindPathParser.set("1530158", defaultMap, new Integer(1));
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

            // 身体拘束未実施減算
            obj = VRBindPathParser.get("1530120", provider);
            if (obj != null) {
                // 身体拘束未実施取組みなしだった場合
                if (ACCastUtilities.toInt(obj) == 1) {
                    defaultMap.setData("1530117", new Integer(2));
                } else if (ACCastUtilities.toInt(obj) == 2) {
                    // 身体拘束未実施取組みありだった場合
                    defaultMap.setData("1530117", new Integer(1));
                }
            }

            // 人員減算
            obj = VRBindPathParser.get("1530110", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // なしだった場合
                case 2: // 医師だった場合
                    VRBindPathParser.set("1530158", defaultMap, new Integer(1));
                    break;
                case 3: // 看護職員だった場合
                case 4: // 介護職員だった場合
                    VRBindPathParser.set("1530158", defaultMap, new Integer(3));
                    break;
                case 5: // 介護支援専門員だった場合
                    VRBindPathParser.set("1530158", defaultMap, new Integer(4));
                    break;
                }
            }

            // 若年性認知症利用者受入加算をなしに設定する。
            VRBindPathParser.set("1530164", defaultMap, new Integer(1));

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

            if (getMedicalFacilityDinnerOffer().getSelectedIndex() == 0) {
                // 食費なしの場合にのみ朝昼夜にする。
                getMedicalFacilityDinnerOffer().setSelectedIndex(1);
            }

            // 状態制御
            medicalFacilityHospitalInstitutionDivisionRadioActionPerformed(null);
        }
    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        // 人員配置区分が有効でなおかつ選択項目が無効である場合
        if (getMedicalFacilityHospitalInstitutionDivisionRadio()
                .getSelectedIndex() == 1) {
            // 人員配置区分チェック
            if (!getStaffAssignment1Division().getSelectedButton()
                    .isEnabled()) {
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
        }
        if (getMedicalFacilityHospitalInstitutionDivisionRadio()
                .getSelectedIndex() == 3) {
            // 人員配置区分チェック
            if (!getStaffAssignment3Division().getSelectedButton()
                    .isEnabled()) {
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
        // 　関数の返り値として終了時間コンボを返す。
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
                        VRBindPathParser.get("1530111", getSelectedProvider()),
                        0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530112", getSelectedProvider()),
                        0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530113", getSelectedProvider()),
                        0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530114", getSelectedProvider()),
                        0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530112", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530113",
                                getSelectedProvider()), 0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530113", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530114",
                                getSelectedProvider()), 0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530114", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530112",
                                getSelectedProvider()), 0));
            }
        }
        // 空文字を返す。
        return "";
    }

    /**
     * 人員配置の制御処理
     */
    public void changeStaffDivisionState() throws Exception {
        // 施設区分をチェックする
        switch (getMedicalFacilityHospitalInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // 人員減算の値を考慮し状態を変更する。
            if (getPersonSubstraction()) {
                setState_VALID_SUBTRACTION();
            } else {
                setState_INVALID_SUBTRACTION();
            }
            break;
        case 2:
            // ユニット型が選択されていた場合
            setState_UNIT_FORM();
            break;
        case 3:
            // 人員減算の値を考慮し状態を変更する。
            if (getPersonSubstraction()) {
                setState_INVALID_SUBTRACTION_3_ENABLE();
            } else {
                setState_INVALID_SUBTRACTION_1_3_ENABLE();
            }
            break;
        case 4:
        	//ユニット型病院経過型
        	setState_UNIT_PASSAGE_FORM();
        	break;
        }

        // 事業所体制による有効/無効状態の再設定
        resetStateByRestrictBindPath();
    }

    public void binded() throws Exception {
        if (getMedicalFacilityHospitalConsultationFee().getDataModel()
                .isEmpty()) {
            // 特定診療費ボタンのデータが空の場合
            // 特定診療費ラベルに「設定なし」と表示する。
            getMedicalFacilityHospitalConsultationFeeLabel().setText("設定なし");
        } else {
            // 特定診療費ボタンのデータが空ではない場合
            // 特定診療費ラベルに「設定あり」と表示する。
            getMedicalFacilityHospitalConsultationFeeLabel().setText("設定あり");
        }

    }

    @Override
    public void checkState() throws Exception {

        // 口腔機能管理体制加算の制御
        if (getOralKeepStructureAddRadioGroup().getSelectedIndex() == 1) {
            setState_INVALID_ORAL_CARE();
        } else {
            setState_VALID_ORAL_CARE();
        }
        
        // 栄養マネジメント加算の状態を基に経口移行加算、経口維持加算の有効状態を変更
        if (getMedicalFacilityHospitalNutritionRadioItem2().isSelected()) {
            // 経口移行加算の状態を元に制御
            if (getMedicalFacilityHospitalOralSwitchRadioItem2().isSelected()) {
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
        } else {
            setState_INVALID_NUTRITION();
            setState_INVALID_KEEP_NUTRITION();
        }
        
        // 経口維持加算の状態を基に経口維持加算２の有効状態を変更
        if (getMedicalFacilityHospitalNutritionRadioItem2().isSelected()
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

        // 他科受信の有無選択時
        int facilityDivision = getMedicalFacilityHospitalInstitutionDivisionRadio()
                .getSelectedIndex();

        // 試行的退所サービスを使用できるか
        boolean isValidTrialHijo = true;

        // 他科受診がありの場合
        if (getMedicalFacilityHospitalMedicalExaminationRadioItem2()
                .isSelected()) {
            // 外泊を無効にする
            setState_INVALID_GAIHAKU();
            // 外泊のなしを選択状態にする
            getMedicalFacilityHospitalStayRadioItem1().setSelected(true);

            isValidTrialHijo = false;

        } else {
            // 外泊を有効にする
            setState_VALID_GAIHAKU();
        }

        // 外泊がありの場合
        if (getMedicalFacilityHospitalStayRadioItem2().isSelected()) {
            // 他科受信を無効にする
            setState_INVALID_TAKAJYUSIN();
            // 他科受信のなしを選択状態にする
            getMedicalFacilityHospitalMedicalExaminationRadioItem1()
                    .setSelected(true);

            isValidTrialHijo = false;

        } else {
            // 他科受信を有効にする
            setState_VALID_TAKAJYUSIN();
        }

        // 体制による制限
        switch (facilityDivision) {
        case 1: // 経過型以外は、無条件に試行的退所サービス費は算定不可
        case 2:
            isValidTrialHijo = false;
            break;
        }

        // 試行的退所サービス費が算定できない場合
        if (!isValidTrialHijo) {
            // 試行的退院サービス費を無効にする。
            setState_INVALID_TRIAL_HIJO();
            // 試行的退院サービス費のなしを選択状態にする。
            getTrialHijoRadioItem1().setSelected(true);

        } else {

	        // 試行的退院サービス費を有効にする。
	        setState_VALID_TRIAL_HIJO();
	
	        // 試行的退院サービス費がありの場合
	        if (getTrialHijoRadioItem2().isSelected()) {
	            // 他科受信を無効にする
	            setState_INVALID_TAKAJYUSIN();
	            // 他科受信のなしを選択状態にする
	            getMedicalFacilityHospitalMedicalExaminationRadioItem1()
	                    .setSelected(true);
	            // 外泊を無効にする
	            setState_INVALID_GAIHAKU();
	            // 外泊のなしを選択状態にする
	            getMedicalFacilityHospitalStayRadioItem1().setSelected(true);
	        } else {
	            // 他科受信を有効にする
	            setState_VALID_TAKAJYUSIN();
	            // 外泊を有効にする
	            setState_VALID_GAIHAKU();
	        }
        }
        
        // 上記処理で有効になったコントロールでも、事業所体制で制約を受けるものは上書きで制御する。
        resetStateByRestrictBindPath();
    }

    @Override
    protected void oralKeepStructureAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 状態制御
        checkState();

    }
    
}
