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
 * プログラム サービスパターン短期入所療養介護（認知症疾患） (QS001_12313_201804)
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
 * サービスパターン短期入所療養介護（認知症疾患）(QS001_12313_201804)
 */
@SuppressWarnings("serial")
public class QS001_12313_201804 extends QS001_12313_201804Event {
    /**
     * コンストラクタです。
     */
    public QS001_12313_201804() {
        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("施設区分", "1230301", "1230301");
        putImportProviderBindPath("人員配置区分", "1230302", "1230302");
        putImportProviderBindPath("ユニットケア体制", "1230315", "1230309");
        putImportProviderBindPath("サービス提供体制強化加算", "1230319", "1230351");

        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("療養食", "1230318", "1230307");
        putRestrictProviderBindPath("ユニットケア体制", "1230315", "1230309");
    }

    // コンポーネントイベント

    /**
     * 「施設区分選択時イベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayDementiaRecuperationInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {

        // ※「施設区分」選択時の「病室区分」の状態切替
        changeState();
    }

    /**
     * 「特定診療費の設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayDementiaRecuperationSpecificConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {

        // ※特定診療費の編集
        // 特定診療費編集画面(QS001199_H2104)を生成する。
        // 特定診療費ボタンのデータを引数に生成した特定診療費編集画面(QS001028)のshoModalを実行する。
        if (new QS001S01_201204().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getShortStayDementiaRecuperationSpecificConsultationFee()
                        .getDataModel())) {
            // 特定診療費を変更した場合
            if (getShortStayDementiaRecuperationSpecificConsultationFee()
                    .getDataModel().isEmpty()) {
                // 特定診療費ボタンのデータが空の場合
                // 特定診療費ラベルに「設定なし」と表示する。
                getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                        .setText("設定なし");
            } else {
                // 特定診療費ボタンのデータが空ではない場合
                // 特定診療費ラベルに「設定あり」と表示する。
                getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
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
    protected void shortStayDementiaRecuperationDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {
        // ※「食事提供」選択時に「食費」の状態切替
        if (getShortStayDementiaRecuperationDinnerOffer().getSelectedIndex() < 1) {
            // 「食事提供」が「なし」の場合
            // 食費を無効にする。
            setState_NOT_USE_MEAT();
        } else {
            // 「食事提供」が「なし」以外の場合
            // 食費を有効にする。
            setState_USE_MEAT();
            // 食事費用(shortStayDementiaRecuperationDinnerCost)を設定する。
            getShortStayDementiaRecuperationDinnerCost().setText(
                    getMeatCost(getShortStayDementiaRecuperationDinnerOffer()
                            .getSelectedIndex()));
        }

    }

    /**
     * 「病室区分」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayDementiaRecuperationHospitalDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // 病室区分選択イベント
        changeState();
    }

    /**
     * 「人員減算選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayDementiaRecuperationPersonSubtractionActionPerformed(
            ActionEvent e) throws Exception {
        // 人員減算区分「看護・介護職員が欠員の場合」「正看比率が20%未満の場合」「僻地届出無」を選択した場合
        if (getShortStayDementiaRecuperationPersonSubtraction()
                .getSelectedIndex() == 2
                || getShortStayDementiaRecuperationPersonSubtraction()
                        .getSelectedIndex() == 3
                || getShortStayDementiaRecuperationPersonSubtraction()
                        .getSelectedIndex() == 5) {
            // 画面上を変更する。
            setState_INVALID_STAFF_ASSIGNMENT();
            // 設定ありに設定
            setStaffAssignmentFlag(true);
        } else {
            setState_VALID_STAFF_ASSIGNMENT();
            // 設定なしに設定
            setStaffAssignmentFlag(false);
        }

        changeState();
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_12313_201804.class.getName(),
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
        getShortStayDementiaRecuperationSpecificConsultationFee()
                .clearDataModel();
        // QS001199_H2104(特定診療費)よりサービス種類(SYSTEM_SERVICE_KIND_DETAIL)に応じたbindPath配列を取得し、特定診療費ボタンに設定する。
        getShortStayDementiaRecuperationSpecificConsultationFee()
                .setBindPathes(
                        QS001S01_201204
                                .getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // ※食事提供
        // コードマスタデータよりCODE_ID：191（食事提供）を取得する。
        // 取得した値を、comboItemMapの KEY : 1230347 の VALUE として設定する。
        comboItemMap.setData("1230347",
                QkanCommon.getArrayFromMasterCode(191, "1230347"));
        // ※人員減算
        // コードマスタデータよりCODE_ID：77（人員減算）を取得する。
        // 取得した値を、comboItemMapの KEY : 1230346 の VALUE として設定する。
        comboItemMap.setData("1230346",
                QkanCommon.getArrayFromMasterCode(66, "1230346"));
        // ※時間区分
        // コードマスタデータよりCODE_ID：273（時間区分）を取得する。
        // 取得した値を、comboItemMapの KEY : 1230352 の VALUE として設定する。
        comboItemMap.setData("1230352",
                QkanCommon.getArrayFromMasterCode(273, "1230352"));
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
        VRBindPathParser.set("1230347", defaultMap, new Integer(1));
        // 人員減算
        VRBindPathParser.set("1230346", defaultMap, new Integer(1));
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
        // 選択事業所情報がnullでない場合
        setSelectedProvider(provider);

        if (provider != null) {
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = getImportData();
            // ※設定
            Object obj;

            // 人員減算
            obj = VRBindPathParser.get("1230306", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // なしだった場合
                case 2: // 医師だった場合
                    VRBindPathParser.set("1230346", defaultMap, new Integer(1));
                    break;
                case 3: // 看護職員だった場合
                case 4: // 介護職員だった場合
                    VRBindPathParser.set("1230346", defaultMap, new Integer(3));
                    break;
                }
            }

            // 2015/03/02 [H27.4改正対応][Shinobu Hitaka] edit - begin 体制があってもなしを選択する。
            VRBindPathParser.set("6", defaultMap, new Integer(1));
            // 送迎
            //obj = VRBindPathParser.get("1230303", provider);
            //if (obj != null) {
            //    switch (ACCastUtilities.toInt(obj)) {
            //    case 2:
            //        // 「あり」の場合
            //        // 送迎区分(shortStayDementiaRecuperationMeetingAndSendingOff)の3番目のボタンを選択にする。
            //        defaultMap.setData("6", new Integer(3));
            //        break;
            //    case 1:
            //        // 「なし」の場合
            //        // 送迎区分(shortStayDementiaRecuperationMeetingAndSendingOff)の1番目のボタンを選択にする。
            //        defaultMap.setData("6", new Integer(1));
            //        break;
            //    }
            //}
            // 2015/03/02 [H27.4改正対応][Shinobu Hitaka] edit - end
            
            // 施設区分が認知症疾患型の場合は、病院区分を設定
            if (ACCastUtilities.toInt(VRBindPathParser.get("1230301", provider), 0) == 1) {
                switch (ACCastUtilities.toInt(VRBindPathParser.get("1230302", provider), 0)) {
                case 1: // I型
                    // 病院区分を「大学病院」に
                    defaultMap.setData("1230308", new Integer(1));
                    break;
                case 2: // II型
                case 3: // III型
                case 4: // IV型
                case 5: // V型
                    // 病院区分を「一般病院」に
                    defaultMap.setData("1230308", new Integer(2));
                    break;
                }
            }
            

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();

            if (getShortStayDementiaRecuperationDinnerOffer()
                    .getSelectedIndex() == 0) {
                // 食費なしの場合にのみ朝昼夜にする。
                getShortStayDementiaRecuperationDinnerOffer().setSelectedIndex(
                        1);
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
        if (getShortStayDementiaRecuperationDinnerOffer().getSelectedIndex() > 0) {
            // 食事提供（shortStayDementiaRecuperationDinnerOffer)が「なし」以外を選択している場合
            if (ACTextUtilities
                    .isNullText(getShortStayDementiaRecuperationDinnerCost()
                            .getText())) {
                // 食事費用(shortStayDementiaRecuperationDinnerCost)が空欄の場合
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
        }
        // 人員配置区分が有効である場合
        if (getShortStayDementiaRecuperationDivision().isEnabled()) {
            // 現在選択中のボタンが無効であった場合
            if (!getShortStayDementiaRecuperationDivision().getSelectedButton()
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
                        VRBindPathParser.get("1230307", getSelectedProvider()),
                        0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1230308", getSelectedProvider()),
                        0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1230309", getSelectedProvider()),
                        0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1230310", getSelectedProvider()),
                        0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1230308", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230309",
                                getSelectedProvider()), 0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1230309", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230310",
                                getSelectedProvider()), 0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1230310", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230308",
                                getSelectedProvider()), 0));
            }
        }
        // 空文字を返す。
        return "";
    }

    /**
     * 人員配置区分に関する制御を行います。
     */
    public void changeState() throws Exception {
        // 「施設区分」の値をチェックする。
        switch (getShortStayDementiaRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // 「認知症疾患型」の場合
            setState_CONVENTIONAL_FORM();
            // 人員減算が設定済みだった場合
            if (getStaffAssignmentFlag()) {
                setState_INVALID_STAFF_ASSIGNMENT();
            }
            // 日帰りショート専用ラジオグループのVisible制御 //20060411
            setState_SHORT_STAY_UNSELECT();
            break;
        case 2:
            // ｢ユニット型認知症疾患型｣の場合
            setState_UNIT_FORM();
            // 日帰りショート専用ラジオグループのVisible制御 //20060411
            setState_SHORT_STAY_UNSELECT();
            break;
        case 3:
            // 「経過型」の場合
            setState_PASSAGE_FORM();
            // 日帰りショート専用ラジオグループのVisible制御 //20060411
            setState_SHORT_STAY_UNSELECT();
            break;
        case 4:
            // ｢日帰りショートステイ｣
            setState_SELECT_SHORT_STAY();
            // 日帰りショート専用ラジオグループのVisible制御 //20060411
            setState_SHORT_STAY_SELECT();
            break;
        }

        // 施設区分 認知症疾患型が選択されていた場合
        if (getShortStayDementiaRecuperationInstitutionDivisionRadioItem1()
                .isSelected()) {
            // 人員配置区分を有効にする。
            setState_VALID_STAFF();
            // 大学病院が選択されていた場合
            // Ⅰ型を表示状態にする。
            if (getShortStayDementiaRecuperationHospitalDivisionRadioItem1()
                    .isSelected()) {
                setState_SELECT_HOSPITAL();
            } else {
                // 病院が選択されていた場合
                // 人員減算区分「看護・介護職員が欠員の場合」「正看比率が20%未満の場合」「僻地届出無」が選択されているかチェックする。
                if (getStaffAssignmentFlag()) {
                    // Ⅳ・Ⅴ型を選択可能にする。
                    setState_UNSELECT_HOSPITAL();
                } else {
                    // Ⅰ型以外を選択可能にする。
                    setState_INVALID_STAFF_DIVISION1();
                }
            }
        } else {
            // 人員配置区分を無効にする。
            setState_INVALID_STAFF();
        }

        resetStateByRestrictBindPath();
    }

    public void binded() throws Exception {
        if (getShortStayDementiaRecuperationSpecificConsultationFee()
                .getDataModel().isEmpty()) {
            // 特定診療費ボタンのデータが空の場合
            // 特定診療費ラベルに「設定なし」と表示する。
            getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                    .setText("設定なし");
        } else {
            // 特定診療費ボタンのデータが空ではない場合
            // 特定診療費ラベルに「設定あり」と表示する。
            getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                    .setText("設定あり");
        }
    }

}
