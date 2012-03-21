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
 * プログラム サービスパターン介護療養型医療施設（診療所） (QS001_15312_201204)
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

/**
 * サービスパターン介護療養型医療施設（診療所）(QS001_15312_201204)
 */
@SuppressWarnings("serial")
public class QS001_15312_201204 extends QS001_15312_201204Event {
    /**
     * コンストラクタです。
     */
    public QS001_15312_201204() {
        
        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");

        // 事業所からの値引き継ぎ
        putImportProviderBindPath("施設区分", "1530201", "1530201");
        putImportProviderBindPath("人員配置区分", "1530202", "1530202");
        putImportProviderBindPath("栄養マネジメント加算", "1530225", "1530210");
        putImportProviderBindPath("設備基準", "1530219", "1530260");
        putImportProviderBindPath("ユニットケアの整備", "1530217", "1530214");
        putImportProviderBindPath("サービス提供体制強化加算", "1530223", "1530264");

        // 事業所の設定により無効にする
        putRestrictProviderBindPath("栄養マネジメント加算", "1530225", "1530210");
        putRestrictProviderBindPath("療養食加算", "1530221", "1530212");
        putRestrictProviderBindPath("若年性認知症患者受入加算", "1530220", "1530262");
        putRestrictProviderBindPath("ユニットケアの整備", "1530217", "1530214");
        putRestrictProviderBindPath("認知症専門ケア加算", "1530222", "1530263");

    }

    // コンポーネントイベント

    /**
     * 「施設区分選択時イベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityClinicInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ※「施設区分」選択時の「病室区分」の状態切替
        // 「施設区分」の値をチェックする。
        switch (getMedicalFacilityClinicInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // 「単独型」もしくは「併設型」の場合
            // 「病室区分(通常)」を有効にし、「病室区分(ユニット型)」を無効にする。
            setState_CONVENTIONAL_FORM();
            break;
        case 2:
            // 「単独型ユニット型」もしくは「併設型ユニット型」の場合
            // 「病室区分(通常)」を無効にし、「病室区分(ユニット型)」を有効にする。
            setState_UNIT_FORM();
            break;
        }

        // 事業所体制による有効/無効の再設定
        resetStateByRestrictBindPath();
    }

    public void binded() throws Exception {
        // ※特定診療費の編集
        if (getMedicalFacilityClinicConsultationFee().getDataModel().isEmpty()) {
            // 特定診療費ボタンのデータが空の場合
            // 特定診療費ラベルに「設定なし」と表示する。
            getMedicalFacilityClinicConsultationFeeLabel().setText("設定なし");
        } else {
            // 特定診療費ボタンのデータが空ではない場合
            // 特定診療費ラベルに「設定あり」と表示する。
            getMedicalFacilityClinicConsultationFeeLabel().setText("設定あり");
        }
    }

    /**
     * 「特定診療費の設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityClinicConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {
        // ※特定診療費の編集
        // 特定診療費編集画面(QS001199_H2104)を生成する。
        // 特定診療費ボタンのデータを引数に生成した特定診療費編集画面(QS001028)のshoModalを実行する。
        if (new QS001S01_201204().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getMedicalFacilityClinicConsultationFee().getDataModel())) {
            // 特定診療費を変更した場合
            if (getMedicalFacilityClinicConsultationFee().getDataModel()
                    .isEmpty()) {
                // 特定診療費ボタンのデータが空の場合
                // 特定診療費ラベルに「設定なし」と表示する。
                getMedicalFacilityClinicConsultationFeeLabel().setText("設定なし");
            } else {
                // 特定診療費ボタンのデータが空ではない場合
                // 特定診療費ラベルに「設定あり」と表示する。
                getMedicalFacilityClinicConsultationFeeLabel().setText("設定あり");
            }
        }
    }

    /**
     * 「食事提供選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityClinicDinnerOfferActionPerformed(ActionEvent e)
            throws Exception {
        // ※「食事提供」選択時に「食費」の状態切替
        if (getMedicalFacilityClinicDinnerOffer().getSelectedIndex() < 1) {
            // 「食事提供」が「なし」の場合
            // 食費を無効にする。
            setState_NOT_USE_MEAT();
        } else {
            // 「食事提供」が「なし」以外の場合
            // 食費を有効にする。
            setState_USE_MEAT();
            // 食事費用(medicalFacilityClinicDinnerCost)を設定する。
            getMedicalFacilityClinicDinnerCost().setText(
                    getMeatCost(getMedicalFacilityClinicDinnerOffer()
                            .getSelectedIndex()));
        }

    }

    /**
     * 「経口移行加算の変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityClinicOralSwitchRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 経口移行加算の状態を基に経口維持加算の有効状態を変更
        if (getMedicalFacilityClinicOralSwitchRadioItem1().isSelected()) {
            setState_VALID_KEEP_NUTRITION();
        } else {
            setState_INVALID_KEEP_NUTRITION();
        }
    }

    /**
     * 「経口維持加算の変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void oralMaintenanceAddRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 経口維持加算の状態を基に経口維持加算の有効状態を変更
        if (getOralMaintenanceAddRadioItem1().isSelected()) {
            setState_VALID_NUTRITION();
        } else {
            setState_INVALID_NUTRITION();
        }
    }

    /**
     * 「他科受信加算の変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityClinicMedicalExaminationRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 他科受信加算の変更
        if (getMedicalFacilityClinicMedicalExaminationRadioItem2().isSelected()) {
            // 外泊加算無効
            setState_INVALID_GAIHAKU_ADD();
            // 外泊加算なしを選択状態にする。
            getMedicalFacilityClinicStayRadioItem1().setSelected(true);
        } else {
            // 外泊加算を有効にする
            setState_VALID_GAIHAKU_ADD();
        }
    }

    /**
     * 「外泊加算の変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void medicalFacilityClinicStayRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 外泊加算の有無を変更
        if (getMedicalFacilityClinicStayRadioItem2().isSelected()) {
            // 他科受信加算
            setState_INVALID_TAKAJUSIN();
        } else {
            setState_VALID_TAKAJUSIN();
        }
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_15312_201204.class.getName(),
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
        getMedicalFacilityClinicConsultationFee().clearDataModel();
        // QS001199_H2104(特定診療費)よりサービス種類(SYSTEM_SERVICE_KIND_DETAIL)に応じたbindPath配列を取得し、特定診療費ボタンに設定する。
        getMedicalFacilityClinicConsultationFee()
                .setBindPathes(
                        QS001S01_201204
                                .getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // 食事提供
        comboItemMap.setData("1530257",
                QkanCommon.getArrayFromMasterCode(191, "1530257"));
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
        VRBindPathParser.set("1530257", defaultMap, new Integer(1));
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
        if (provider != null) {
            // 選択事業所情報がnullでない場合
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = getImportData();
            // ※設定
            Object obj;

            // 身体拘束未実施減算
            obj = VRBindPathParser.get("1530218", provider);
            if (obj != null) {
                // 身体拘束未実施取組みなしだった場合
                if (ACCastUtilities.toInt(obj) == 1) {
                    defaultMap.setData("1530215", new Integer(2));
                } else if (ACCastUtilities.toInt(obj) == 2) {
                    // 身体拘束未実施取組みありだった場合
                    defaultMap.setData("1530215", new Integer(1));
                }
            }

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();

            if (getMedicalFacilityClinicDinnerOffer().getSelectedIndex() == 0) {
                // 食費なしの場合にのみ朝昼夜にする。
                getMedicalFacilityClinicDinnerOffer().setSelectedIndex(1);
            }

            medicalFacilityClinicInstitutionDivisionRadioActionPerformed(null);
            
            // 口腔機能維持管理体制加算の制御
            oralKeepStructureAddRadioGroupSelectionChanged(null);
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
                        VRBindPathParser.get("1530209", getSelectedProvider()),
                        0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530210", getSelectedProvider()),
                        0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530211", getSelectedProvider()),
                        0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530212", getSelectedProvider()),
                        0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530210", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530211",
                                getSelectedProvider()), 0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530211", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530212",
                                getSelectedProvider()), 0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530212", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530210",
                                getSelectedProvider()), 0));
            }
        }
        // 空文字を返す。
        return "";
    }

    @Override
    protected void oralKeepStructureAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 口腔機能管理体制加算の制御
        if (getOralKeepStructureAddRadioGroup().getSelectedIndex() == 1) {
            setState_INVALID_ORAL_CARE();
        } else {
            setState_VALID_ORAL_CARE();
        }

    }

}
