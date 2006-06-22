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
 * 作成日: 2006/01/12  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン通所介護 (001)
 * プログラム サービスパターン通所介護 (QS001008)
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
 * サービスパターン通所介護(QS001008)
 */
public class QS001008 extends QS001008Event {
    /**
     * コンストラクタです。
     */
    public QS001008() {
    }

    // コンポーネントイベント

    /**
     * 「終了時間変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void tsuusyoKaigoTimeBeginTimeActionPerformed(ActionEvent e)
            throws Exception {
        // ※開始時間変更時、終了時間も変更
        if (getTsuusyoKaigoTimeBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getTsuusyoKaigoTimeBeginTime()
                        .getText()))) {
            // 時間退避用の変数kangoTimeに、時間区分から取得した時間を設定する。
            int kangoTime = getKaigoTime();

            // 終了時間を「開始時間 + kangoTime(分)」に設定する。
            getTsuusyoKaigoTimeEndTime().setDate(
                    ACDateUtilities.addMinute(
                                    getTsuusyoKaigoTimeBeginTime().getDate(),
                                    kangoTime));
        }
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001008.class.getName(), param));
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
        // 取得した値を、comboItemMapの KEY : 1150104 の VALUE として設定する。
        comboItemMap.setData("1150104", QkanCommon.getArrayFromMasterCode(40,
                "1150104"));
        // ※コンボアイテムの設定
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();
        // ※選択項目の初期設定
//      機能訓練指導加算(tsuusyoKaigoAdditionFunctionTrainingRadio)の「なし」を選択する。
        getTsuusyoKaigoAdditionFunctionTrainingRadio().setSelectedIndex(1);

    }

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数
        if (provider != null) {
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            Object obj;
            // 施設区分
            obj = VRBindPathParser.get("1150101", provider);
            if (obj != null) {
                getTsuusyoKaigoTimeContenaFacilityDivision().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // 人員減算
            obj = VRBindPathParser.get("1150106", provider);
            if (obj != null) {
                getTsuusyoKaigoSubtraction().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // 送迎
            obj = VRBindPathParser.get("1150105", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 送迎区分(tsuusyoKaigoMeetingAndSendingOff)の3番目のボタンを選択にする。
                    getTsuusyoKaigoMeetingAndSendingOff().setSelectedIndex(3);
                    break;
                case 1:
                    // 「なし」の場合
                    // 送迎区分(tsuusyoKaigoMeetingAndSendingOff)の1番目のボタンを選択にする。
                    getTsuusyoKaigoMeetingAndSendingOff().setSelectedIndex(1);
                    break;
                }
            }

            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 機能訓練に対する体制加算
            obj = VRBindPathParser.get("1150102", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_FUNCTION_TRAINING();
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_FUNCTION_TRAINING();
                    break;
                }
            }
            // 入浴加算
            obj = VRBindPathParser.get("1150103", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // tsuusyoKaigoAdditionFunctionBathRadioの2番目のボタンを取得し、有効にする。
                    setState_VALID_ADD_BATH();
                    break;
                case 1:
                    // 「なし」の場合
                    // tsuusyoKaigoAdditionFunctionBathRadioの2番目のボタンを取得し、無効にする。
                    setState_INVALID_ADD_BATH();
                    break;
                }
            }
            // 特別入浴加算
            obj = VRBindPathParser.get("1150104", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // tsuusyoKaigoAdditionFunctionBathRadioの3番目のボタンを取得し、有効にする。
                    setState_VALID_ADD_SPECIAL_BATH();
                    break;
                case 1:
                    // 「なし」の場合
                    // tsuusyoKaigoAdditionFunctionBathRadioの3番目のボタンを取得し、無効にする。
                    setState_INVALID_ADD_SPECIAL_BATH();
                    break;
                }
            }
            getTsuusyoKaigoAdditionFunctionBathRadio().setSelectedIndex(1);
        }
    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        if (!getTsuusyoKaigoTimeDivision().isSelected()) {
            // 時間区分(tsuusyoKaigoTimeDivision)が未選択の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
        if (ACTextUtilities
                .isNullText(getTsuusyoKaigoTimeBeginTime().getText())
                || ACTextUtilities.isNullText(getTsuusyoKaigoTimeEndTime()
                        .getText())
                || (!getTsuusyoKaigoTimeBeginTime().isValidDate())
                || (!getTsuusyoKaigoTimeEndTime().isValidDate())) {
            // 開始時刻コンボ(tsuusyoKaigoTimeBeginTime)と終了時刻コンボ(tsuusyoKaigoTimeEndTime)のいずれかが空欄もしくは不正の場合
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
        if (!getTsuusyoKaigoAdditionFunctionTrainingRadio().isEnabled()) {
            // 機能訓練(tsuusyoKaigoAdditionFunctionTrainingRadio)が無効の場合
            // 返却用レコードから、機能訓練(tsuusyoKaigoAdditionFunctionTrainingRadio)のbindPathを除去する。
            data.remove(getTsuusyoKaigoAdditionFunctionTrainingRadio()
                    .getBindPath());
        }
        if ((getTsuusyoKaigoAdditionFunctionTrainingRadio().getSelectedButton() != null)
                && (!getTsuusyoKaigoAdditionFunctionTrainingRadio()
                        .getSelectedButton().isEnabled())) {
            // 入浴加算(tsuusyoKaigoAdditionFunctionBathRadio)の選択項目が無効の場合
            // 返却用レコードから、入浴加算(tsuusyoKaigoAdditionFunctionBathRadio)のbindPathを除去する。
            data.remove(getTsuusyoKaigoAdditionFunctionTrainingRadio()
                    .getBindPath());
        }
        if (!getTsuusyoKaigoMeetingAndSendingOff().isEnabled()) {
            // 送迎(tsuusyoKaigoMeetingAndSendingOff)が無効の場合
            // 返却用レコードから、送迎(tsuusyoKaigoMeetingAndSendingOff)のbindPathを除去する。
            data.remove(getTsuusyoKaigoMeetingAndSendingOff().getBindPath());
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
     * 「時間区分の時間取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public int getKaigoTime() throws Exception {
        // ※時間区分(tsuusyoKaigoTimeDivision)の時間を取得
        // 時間区分(tsuusyoKaigoTimeDivision)の値をチェックする。
        switch (getTsuusyoKaigoTimeDivision().getSelectedIndex()) {
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
     * 開始時刻入力用のコンボを返します。
     * @return 開始時刻入力用のコンボ
     */
   public ACComboBox getBeginTimeCombo() {
       // ※開始時刻入力用のコンボを返す。
       // 関数の返り値として開始時間コンボを返す。
        return getTsuusyoKaigoTimeBeginTime();
    }
   
   

   /**
    * 終了時刻入力用のコンボを返します。
    * @return 終了時刻入力用のコンボ
    */
    public ACComboBox getEndTimeCombo() {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return getTsuusyoKaigoTimeEndTime();
    }

}
