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
 * 作成日: 2006/01/17  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン通所リハ (001)
 * プログラム サービスパターン通所リハ (QS001009)
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
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン通所リハ(QS001009)
 */
public class QS001009 extends QS001009Event {
    /**
     * コンストラクタです。
     */
    public QS001009() {
    }

    // コンポーネントイベント

    /**
     * 「開始時間変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonRehabilitationTimeContenaBeginTimeActionPerformed(
            ActionEvent e) throws Exception {
        // ※開始時間変更時、終了時間も変更
        // 時間帯変更時、終了時間も変更する。
        checkEndTime();

    }

    /**
     * 「時間区分変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonRehabilitationTimeDivisionActionPerformed(ActionEvent e)
            throws Exception {
        // ※時間区分変更時、終了時間も変更
        // 時間区分変更時、終了時間も変更する。
        checkEndTime();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001009.class.getName(), param));
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
        // ※時間区分
        // コードマスタデータよりCODE_ID：40（時間区分）を取得する。
        // 取得した値を、comboItemMapの KEY : 1160104 の VALUE として設定する。
        comboItemMap.setData("1160104", QkanCommon.getArrayFromMasterCode(40,
                "1160104"));
        // ※コンボアイテムの設定
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();

        // ※選択項目の初期設定
        // 個別リハ(houmonRehabilitationIndividualRadio)の「なし」を選択する。
        getHoumonRehabilitationIndividualRadio().setSelectedIndex(1);
        // リハビリ訪問指導加算(houmonRehabilitationAdditionTreatmentPersonRadio)の「なし」を選択する。
        getHoumonRehabilitationAdditionTreatmentPersonRadio().setSelectedIndex(
                1);
        //入浴加算(houmonRehabilitationBathRadio)の「なし」を選択する。
        getHoumonRehabilitationBathRadio().setSelectedIndex(1);
        //人員減算(houmonRehabilitationSubtraction)の「なし」を選択する。
        getHoumonRehabilitationSubtraction().setSelectedIndex(1);
    }

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数
        if (provider != null) {
            Object obj;
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // 施設区分
            obj = VRBindPathParser.get("1160101", provider);
            if (obj != null) {
                getHoumonRehabilitationTimeContenaFacilityDivision()
                        .setSelectedIndex(ACCastUtilities.toInt(obj));
            }
            // 人員減算
            obj = VRBindPathParser.get("1160105", provider);
            if (obj != null) {
                getHoumonRehabilitationSubtraction().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // 送迎
            obj = VRBindPathParser.get("1160104", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 送迎区分(houmonRehabilitationMeetingAndSendingOff)の3番目のボタンを選択にする。
                    getHoumonRehabilitationMeetingAndSendingOff()
                            .setSelectedIndex(3);
                    break;
                case 1:
                    // 「なし」の場合
                    // 送迎区分(houmonRehabilitationMeetingAndSendingOff)の1番目のボタンを選択にする。
                    getHoumonRehabilitationMeetingAndSendingOff()
                            .setSelectedIndex(1);
                    break;
                }
            }
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 入浴加算
            obj = VRBindPathParser.get("1160102", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // 「あり」の場合
                    // houmonRehabilitationBathRadioの2番目のボタンを取得し、有効にする。
                    setState_VALID_ADD_BATH();
                } else {
                    // 「なし」の場合
                    // houmonRehabilitationBathRadioの2番目のボタンを取得し、無効にする。
                    setState_INVALID_ADD_BATH();
                }
            }
            // 特別入浴加算
            obj = VRBindPathParser.get("1160103", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // 「あり」の場合
                    // houmonRehabilitationBathRadioの3番目のボタンを取得し、有効にする。
                    setState_VALID_ADD_SPECIAL_BATH();
                } else {
                    // 「なし」の場合
                    // houmonRehabilitationBathRadioの3番目のボタンを取得し、無効にする。
                    setState_INVALID_ADD_SPECIAL_BATH();
                }
            }
            //入浴加算の「なし」を選択する。
            getHoumonRehabilitationBathRadio().setSelectedIndex(1);
        }
    }

    /**
     * 「時間区分の時間取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public int getKaigoTime() throws Exception {
        // ※時間区分(houmonRehabilitationTimeDivision)の時間を取得
        // 時間区分(houmonRehabilitationTimeDivision)の値をチェックする。
        switch (getHoumonRehabilitationTimeDivision().getSelectedIndex()) {
        case 1:
            // ２時間以上３時間未満の場合
            // 戻り値として180を返す。
            return 180;
        case 2:
            // ３時間以上４時間未満の場合
            // 戻り値として240を返す。
            return 240;
        case 3:
            // ４時間以上６時間未満の場合
            // 戻り値として360を返す。
            return 360;
        case 4:
            // ６時間以上８時間未満の場合
            // 戻り値として480を返す。
            return 480;
        case 5:
            // ８時間以上９時間未満の場合
            // 戻り値として540を返す。
            return 540;
        case 6:
            // ９時間以上１０時間未満の場合
            // 戻り値として600を返す。
            return 600;
        }
        return 0;
    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。

        if (!getHoumonRehabilitationTimeDivision().isSelected()) {
            // 時間区(houmonRehabilitationTimeDivision)分が未選択の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }

        if (ACTextUtilities
                .isNullText(getHoumonRehabilitationTimeContenaBeginTime()
                        .getText())
                || ACTextUtilities
                        .isNullText(getHoumonRehabilitationTimeContenaEndTime()
                                .getText())
                || (!getHoumonRehabilitationTimeContenaBeginTime()
                        .isValidDate())
                || (!getHoumonRehabilitationTimeContenaEndTime().isValidDate())) {
            // 開始時刻コンボ(houmonRehabilitationTimeContenaBeginTime)が空欄か不正の場合
            // もしくは終了時刻コンボ(houmonRehabilitationTimeContenaEndTime)が空欄か不正の場合
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
        if ((getHoumonRehabilitationBathRadio().getSelectedButton() != null)
                && (!getHoumonRehabilitationBathRadio().getSelectedButton()
                        .isEnabled())) {
            // 入浴加算(houmonRehabilitationBathRadio)の選択項目が無効の場合
            // 返却用レコードから、入浴加算(houmonRehabilitationBathRadio)のbindPathを除去する。
            data.remove(getHoumonRehabilitationBathRadio().getBindPath());
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
     * 「終了時間のチェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkEndTime() throws Exception {
        // ※時間帯変更時、終了時間も変更
        // 開始時間コンボ(houmonRehabilitationTimeContenaBeginTime)の値が空欄および不正でない場合
        // 時間退避用の変数kangoTimeに、時間区分から取得した時間を設定する。

        // 終了時間を「開始時間 + kangoTime(分)」に設定する。
        if (getHoumonRehabilitationTimeContenaBeginTime().isValidDate()
                && (!ACTextUtilities
                        .isNullText(getHoumonRehabilitationTimeContenaBeginTime()
                                .getText()))) {
            // 開始時間コンボ(houmonKangoKaigoBeginTime)の値が空欄および不正でない場合
            // 時間退避用の変数kangoTimeに、訪問看護時間区分から取得した時間を設定する。
            int kaigoTime = getKaigoTime();

            // 終了時間を「開始時間 + kangoTime(分)」に設定する。
            getHoumonRehabilitationTimeContenaEndTime().setDate(
                    ACDateUtilities.getInstance().addMinute(
                            getHoumonRehabilitationTimeContenaBeginTime()
                                    .getDate(), kaigoTime));
        }

    }

    /**
     * 「施設区分変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonRehabilitationTimeContenaFacilityDivisionActionPerformed(
            ActionEvent e) throws Exception {
        // ※施設区分変更時、リハビリ訪問指導加算も変更
        if (getHoumonRehabilitationTimeContenaFacilityDivision()
                .getSelectedIndex() == 3) {
            // 施設区分(houmonRehabilitationTimeContenaFacilityDivision)に「介護老人保健施設」を選択した場合
            // リハビリ訪問指導加算(houmonRehabilitationAdditionTreatmentPersonRadio)を有効にする。
            setState_VALID_ADD_REHA_TREATMENT();
        } else {
            // 施設区分(houmonRehabilitationTimeContenaFacilityDivision)に「介護老人保健施設」以外を選択した場合
            // リハビリ訪問指導加算(houmonRehabilitationAdditionTreatmentPersonRadio)を無効にする。
            setState_INVALID_ADD_REHA_TREATMENT();
        }
    }


    /**
     * 開始時刻入力用のコンボを返します。
     * @return 開始時刻入力用のコンボ
     */
   public ACComboBox getBeginTimeCombo() {
       // ※開始時刻入力用のコンボを返す。
       // 関数の返り値として開始時間コンボを返す。
        return getHoumonRehabilitationTimeContenaBeginTime();
    }
   
   

   /**
    * 終了時刻入力用のコンボを返します。
    * @return 終了時刻入力用のコンボ
    */
    public ACComboBox getEndTimeCombo() {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return getHoumonRehabilitationTimeContenaEndTime();
    }

}
