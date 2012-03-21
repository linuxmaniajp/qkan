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
 * プログラム サービスパターン通所介護 (QS001_11511_201204)
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
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン通所介護(QS001_11511_201204)
 */
@SuppressWarnings("serial")
public class QS001_11511_201204 extends QS001_11511_201204Event {
    /**
     * コンストラクタです。
     */
    public QS001_11511_201204() {
        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("入浴介助", "1150103", "1150106");
        putImportProviderBindPath("栄養改善体制", "1150113", "1150116");
        putImportProviderBindPath("口腔機能向上加算", "1150109", "1150112");
        putImportProviderBindPath("サービス提供体制強化加算", "1150114", "1150117");

        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("入浴介助", "1150103", "1150106");
        putRestrictProviderBindPath("栄養改善体制", "1150113", "1150116");
        putRestrictProviderBindPath("口腔機能向上加算", "1150109", "1150112");
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "1150112", "1150115");
        putRestrictProviderBindPath("個別機能訓練体制", "1150116", "1150119");
        putRestrictProviderBindPath("個別機能訓練体制", "1150116", "1150120");
    }

    // コンポーネントイベント

    /**
     * 「施設区分選択時」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void tsuusyoKaigoTimeContenaFacilityDivisionActionPerformed(
            ActionEvent e) throws Exception {
        // 施設区分選択時の処理
        // 施設区分選択時
        VRMap comboItemMap;
        switch (getTsuusyoKaigoTimeContenaFacilityDivision().getSelectedIndex()) {
        case 1:
            // 小規模
            setState_STATE_SMALL();
            comboItemMap = new VRHashMap();
            // コードマスタデータよりCODE_ID：40（時間区分）を取得する。
            // 取得した値を、comboItemMapの KEY : 1150104 の VALUE として設定する。
            comboItemMap.setData("1150104",
                    QkanCommon.getArrayFromMasterCode(40, "1150104"));
            // ※展開
            // 自身(this)にcomboItemMapに設定する。
            getThis().setModelSource(comboItemMap);
            // コンボアイテムを展開する。
            getThis().bindModelSource();
            break;
        case 2:
        case 3:
        case 4:
            // 通常規模選択時
            setState_STATE_NORMAL();
            comboItemMap = new VRHashMap();
            // コードマスタデータよりCODE_ID：40（時間区分）を取得する。
            // 取得した値を、comboItemMapの KEY : 1150104 の VALUE として設定する。
            comboItemMap.setData("1150104",
                    QkanCommon.getArrayFromMasterCode(40, "1150104"));
            // ※展開
            // 自身(this)にcomboItemMapに設定する。
            getThis().setModelSource(comboItemMap);
            // コンボアイテムを展開する。
            getThis().bindModelSource();
            break;
        case 5:
            // 療養通所選択時
            setState_STATE_RYOYO();
            comboItemMap = new VRHashMap();
            // コードマスタデータよりCODE_ID：40（時間区分）を取得する。
            // 取得した値を、comboItemMapの KEY : 1150104 の VALUE として設定する。
            comboItemMap.setData("1150104",
                    QkanCommon.getArrayFromMasterCode(238, "1150104"));
            // ※展開
            // 自身(this)にcomboItemMapに設定する。
            getThis().setModelSource(comboItemMap);
            // コンボアイテムを展開する。
            getThis().bindModelSource();
            break;
        }

        // 上記処理で有効になったコントロールでも、事業所体制で制約を受けるものは上書きで制御する。
        VRBindSource provider = getSelectedProvider();
        if (provider != null) {
            Object obj;
            // 栄養改善体制
            obj = VRBindPathParser.get("1150113", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしだった場合
                    // 無効にする。
                    setState_INVALID_NOURISHMENT_MANAGEMENT();
                    break;
                }
            }
            // 個別機能訓練体制（事業所パネル）KEY：1150116の値をチェックする。
            obj = VRBindPathParser.get("1150116", provider);
            switch (ACCastUtilities.toInt(obj, 0)) {
            // 値が次のいずれかだった場合
            case 2:
                // 2（加算型I）
            case 3:
                // 3（加算型II）
                // なにもしない。
                break;
            default:
                // 値が上記以外だった場合
                // 無効にする。
                setState_INVALID_FUNCTION_TRAINING();
                break;
            }

            // 口腔機能向上体制（事業所パネル）KEY：1150109の値をチェックする。
            obj = VRBindPathParser.get("1150109", provider);
            switch (ACCastUtilities.toInt(obj, 0)) {
            // 値が次のいずれかだった場合
            case 2:
                // 2（あり）
                // なにもしない。
                break;
            default:
                // 値が上記以外だった場合
                // 無効にする。
                setState_INVALID_MOUTH_FUNCTION();
                break;
            }

            // 若年性認知症利用者受入加算（事業所パネル）KEY：1150112の値をチェックする。
            obj = VRBindPathParser.get("1150112", provider);
            switch (ACCastUtilities.toInt(obj, 0)) {
            // 値が次のいずれかだった場合
            case 2:
                // 2（あり）
                // なにもしない。
                break;
            default:
                // 値が上記以外だった場合
                // 無効にする。
                setState_INVALID_YOUNG_DEMENTIA_PATINET();
                break;
            }

        }

    }

    /**
     * 「開始時刻選択時」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void tsuusyoKaigoTimeBeginTimeActionPerformed(ActionEvent e)
            throws Exception {
        // 開始時刻を選択した場合の処理
        checkEndTime();

    }

    /**
     * 「時刻区分選択時」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void tsuusyoKaigoTimeDivisionActionPerformed(ActionEvent e)
            throws Exception {
        // 時刻区分選択処理
        checkEndTime();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_11511_201204.class.getName(),
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
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // コードマスタデータよりCODE_ID：40（時間区分）を取得する。
        // 取得した値を、comboItemMapの KEY : 1150104 の VALUE として設定する。
        comboItemMap.setData("1150104",
                QkanCommon.getArrayFromMasterCode(40, "1150104"));
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
        if (provider != null) {
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = getImportData();
            // ※設定
            Object obj;

            // 施設等の区分
            obj = VRBindPathParser.get("1150115", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj, 1)) {
                case 1: // 小規模型
                case 2: // 通常規模型
                    VRBindPathParser.set("1150113", defaultMap,
                            ACCastUtilities.toInt(obj, 1));
                    break;
                case 4: // 大規模I
                    VRBindPathParser.set("1150113", defaultMap, new Integer(3));
                    break;
                case 5: // 大規模II
                    VRBindPathParser.set("1150113", defaultMap, new Integer(4));
                    break;
                case 3: // 療養通所介護
                    VRBindPathParser.set("1150113", defaultMap, new Integer(5));
                    break;
                }
            }

            // 人員減算
            obj = VRBindPathParser.get("1150106", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // なしだった場合
                    VRBindPathParser.set("1150108", defaultMap, new Integer(1));
                    break;
                case 2: // 医師だった場合
                case 3: // 看護職員だった場合
                    VRBindPathParser.set("1150108", defaultMap, new Integer(3));
                    break;
                }
            }

            // 個別機能訓練指導加算
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1150116", provider), 1)) {
            case 2: // I型
                VRBindPathParser.set("1150119", defaultMap, new Integer(2));
                break;
            case 3: // II型
                VRBindPathParser.set("1150120", defaultMap, new Integer(2));
                break;
            }

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

            resetStateByRestrictBindPath();
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
        return getTsuusyoKaigoTimeBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 　関数の返り値として終了時間コンボを返す。
        return getTsuusyoKaigoTimeEndTime();
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
        if (getTsuusyoKaigoTimeBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getTsuusyoKaigoTimeBeginTime()
                        .getText()))) {
            int kaigoTime = 0;
            // 開始時間コンボ(houmonKangoKaigoBeginTime)の値が空欄および不正でない場合
            // 時間退避用の変数kangoTimeに、訪問看護時間区分から取得した時間を設定する。
            if (getTsuusyoKaigoTimeContenaFacilityDivisionItem3().isSelected()) {
                kaigoTime = getRyouyoTuusyoKaigoTime();
            } else {
                kaigoTime = getKaigoTime();
            }
            // 終了時間を「開始時間 + kangoTime(分)」に設定する。
            getTsuusyoKaigoTimeEndTime().setDate(
                    ACDateUtilities.addMinute(getTsuusyoKaigoTimeBeginTime()
                            .getDate(), kaigoTime));
        }

    }

    /**
     * 「時間区分の時間取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public int getKaigoTime() throws Exception {
        // ※時間区分(getTsuusyoKaigoTimeDivision)の時間を取得
        // 時間区分(getTsuusyoKaigoTimeDivision)の値をチェックする。
        switch (getTsuusyoKaigoTimeDivision().getSelectedIndex()) {
        case 0:
            // ２時間以上３時間未満の場合
            // 戻り値として180を返す。
            return 180;
        case 1:
            // ３時間以上４時間未満の場合
            // 戻り値として240を返す。
            return 240;
        case 2:
            // ４時間以上６時間未満の場合
            // 戻り値として360を返す。
            return 360;
        case 3:
            // ６時間以上８時間未満の場合
            // 戻り値として480を返す。
            return 480;
        case 4:
            // ８時間以上９時間未満の場合
            // 戻り値として540を返す。
            return 540;
        case 5:
            // ９時間以上１０時間未満の場合
            // 戻り値として600を返す。
            return 600;
        }
        return 0;
    }

    public int getRyouyoTuusyoKaigoTime() throws Exception {
        // ※時間区分(getTsuusyoKaigoTimeDivision)の時間を取得
        // 時間区分(getTsuusyoKaigoTimeDivision)の値をチェックする。
        switch (getTsuusyoKaigoTimeDivision().getSelectedIndex()) {
        case 0:
            // ３時間以上６時間未満の場合
            // 戻り値として180を返す。
            return 360;
        case 1:
            // ６時間以上８時間未満の場合
            // 戻り値として480を返す。
            return 480;
        }
        return 0;
    }

}
