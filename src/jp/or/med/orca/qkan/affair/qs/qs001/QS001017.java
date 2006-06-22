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
 * 開発者: 小笠　貴志
 * 作成日: 2006/01/18  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン居宅療養管理指導 (001)
 * プログラム サービスパターン居宅療養管理指導 (QS001018)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン居宅療養管理指導(QS001018)
 */
public class QS001017 extends QS001017Event {
    /**
     * コンストラクタです。
     */
    public QS001017() {
    }

    // コンポーネントイベント

    /**
     * 「職種ラジオクリックイベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void recuperationManagementGuidanceOccupationalCategoryActionPerformed(
            ActionEvent e) throws Exception {
        // ※職種ラジオ変更時、画面の状態を変更
        switch (getRecuperationManagementGuidanceOccupationalCategory()
                .getSelectedIndex()) {
        case 1:
            // 医師選択時
            // 医師選択時用の状態を設定する。
            setState_DOCTOR();
            break;
        case 2:
            // 歯科医師選択時
            // 歯科医師選択時用の状態を設定する。
            setState_DENTAL();
            break;
        case 3:
            // 薬剤師（医療機関）選択時
            // 薬剤師（医療機関）選択時用の状態を設定する。
            setState_CHEMIST_HOSPITAL();
            break;
        case 4:
            // 薬剤師（薬局）選択時
            // 薬剤師（薬局）選択時用の状態を設定する。
            setState_CHEMIST_PHARMACY();
            break;
        case 5:
            // 栄養士選択時
            // 栄養士選択時用の状態を設定する。
            setState_DIETICIAN();
            break;
        case 6:
            // 歯科衛生士等選択時
            // 歯科衛生士等選択時用の状態を設定する。
            setState_DENTAL_HYGIENIST();
            break;
        }
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001017.class.getName(), param));
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
        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ※コンボアイテムの設定
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();

        // ※選択項目の初期設定
        // 在総診(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio)の「なし」を選択する。
        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio()
                .setSelectedIndex(1);
        // 特別薬剤(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio)の「なし」を選択する。
        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio()
                .setSelectedIndex(1);
        // 回数(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio)の「1回目」を選択する。
        getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio()
                .setSelectedIndex(1);

    }

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数

    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        if (!getRecuperationManagementGuidanceOccupationalCategory()
                .isSelected()) {
            // 職種ラジオグループ(recuperationManagementGuidanceOccupationalCategory)が未選択の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
        if (ACTextUtilities
                .isNullText(getRecuperationManagementGuidanceBeginTime()
                        .getText())
                || ACTextUtilities
                        .isNullText(getRecuperationManagementGuidanceEndTime()
                                .getText())
                || (!getRecuperationManagementGuidanceBeginTime().isValidDate())
                || (!getRecuperationManagementGuidanceEndTime().isValidDate())) {
            // 開始時刻コンボ(recuperationManagementGuidanceBeginTime)と終了時刻コンボ(recuperationManagementGuidanceEndTime)のいずれかが空欄もしくは不正の場合
            // 時刻の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
            // nullを返す。
            return null;
        }
        // ※返却用のレコード(data)を生成
        VRMap data = new VRHashMap();
        // 自身(this)のソースとして生成レコードを設定する。
        getThis().setSource(data);
        // 自身(this)のapplySourceを呼び出してデータを収集する。
        getThis().applySource();

        // ※返却用レコードから不要なキーを除去
        if (!getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio()
                .isEnabled()) {
            // 在総診(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio)が無効の場合
            // 返却用レコードから、在総診(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio)のbindPathを除去する。
            data
                    .remove(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio()
                            .getBindPath());
        }
        if (!getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio()
                .isEnabled()) {
            // 特別薬剤(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio)が無効の場合
            // 返却用レコードから、特別薬剤(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio)のbindPathを除去する。
            data
                    .remove(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio()
                            .getBindPath());
        }
        if (!getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio()
                .isEnabled()) {
            // 回数(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio)が無効の場合
            // 返却用レコードから、回数(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio)のbindPathを除去する。
            data
                    .remove(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio()
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
     * 開始時刻入力用のコンボを返します。
     * @return 開始時刻入力用のコンボ
     */
   public ACComboBox getBeginTimeCombo() {
       // ※開始時刻入力用のコンボを返す。
       // 関数の返り値として開始時間コンボを返す。
        return getRecuperationManagementGuidanceBeginTime();
    }
   
   

   /**
    * 終了時刻入力用のコンボを返します。
    * @return 終了時刻入力用のコンボ
    */
    public ACComboBox getEndTimeCombo() {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return getRecuperationManagementGuidanceEndTime();
    }

}
