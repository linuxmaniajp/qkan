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
 * 作成日: 2011/11/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防認知症対応型通所介護 (QS001_17411_201504)
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
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン介護予防認知症対応型通所介護(QS001_17411_201504)
 */
@SuppressWarnings("serial")
public class QS001_17411_201504 extends QS001_17411_201504Event {
    /**
     * コンストラクタです。
     */
    public QS001_17411_201504() {
        
        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");
        
        // 値を転記する事業所設定項目
        // 2015.03.06 del putImportProviderBindPath("個別機能訓練体制", "1740104", "1740106");
        // 2015.03.06 del putImportProviderBindPath("入浴介助加算", "1740105", "1740105");
        // 2015.03.06 del putImportProviderBindPath("栄養改善体制", "1740106", "1740107");
        // 2015.03.06 del putImportProviderBindPath("口腔機能向上体制", "1740107", "1740108");
        putImportProviderBindPath("サービス提供体制強化加算", "1740109", "1740110");
        
        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "1740108", "1740109");
        putRestrictProviderBindPath("個別機能訓練体制", "1740104", "1740106");
        putRestrictProviderBindPath("入浴介助体制", "1740105", "1740105");
        putRestrictProviderBindPath("栄養改善体制", "1740106", "1740107");
        putRestrictProviderBindPath("口腔機能向上体制", "1740107", "1740108");
        
    }

    // コンポーネントイベント

    /**
     * 「開始時間選択」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void beginTimeActionPerformed(ActionEvent e) throws Exception {
        // 開始時間選択
        // 　終了時間設定処理
        checkEndTime();

    }

    /**
     * 「時刻区分選択」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void timeDivisionRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 時刻区分選択
        // 　終了時間再設定処理
        checkEndTime();

    }

    /**
     * 「施設区分1,2の連動」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void providerDivisionRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ※施設区分1の状態に応じて施設区分2の有効状態を切り替える。
        // 　施設区分1の状態に応じて施設区分2の有効状態を切り替える。
        checkState();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_17411_201504.class.getName(),
                param));
    }

    // 内部関数

    /**
     * 「初期化」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
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
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ※展開
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();
        // ※選択項目の初期設定
        // ※準備
        // 初期選択設定用のレコード defaultMap を生成する。
        VRMap defaultMap = new VRHashMap();
        // ※設定
        // 画面のラジオの初期値を設定する。（selectFirstRadioItem）
        QkanCommon.selectFirstRadioItem(getThis());
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();
        // 画面状態制御
        checkState();

    }

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
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
            // 施設等の区分（事業所パネル）KEY：1740101の値をチェックする。
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1740101", provider), 0)) {
            case 1:
                // 値が1（単独型）だった場合
                // defaultMapに KEY：1740101 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1740101", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
                // 値が2（併設型）、3(グループホーム等活用型)だった場合
                // defaultMapに KEY：1740101 VALUE：2（あり）を設定する。
                VRBindPathParser.set("1740101", defaultMap, new Integer(2));
                break;
            }
            
            // 職員の欠員による減算の状況（事業所パネル）KEY：1740102の値をチェックする。
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1740102", provider), 0)) {
            case 1:
                // 値が1（なし）だった場合
                // defaultMapに KEY：1740104 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1740104", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
                // 値が2又は3だった場合（看護職員・介護職員）だった場合
                // defaultMapに KEY：1740104 VALUE：3（看護・介護職員が欠員）を設定する。
                VRBindPathParser.set("1740104", defaultMap, new Integer(3));
                break;
            }

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 画面状態制御
            checkState();
        }

    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
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
        if (ACTextUtilities.isNullText(getBeginTime().getText())
                || ACTextUtilities.isNullText(getEndTime().getText())
                || (!getBeginTime().isValidDate())
                || (!getEndTime().isValidDate())) {
            // 開始時刻コンボ(houmonKangoIryoBeginTime)と終了時刻コンボ(houmonKangoIryoEndTime)のいずれかが空欄か不正の場合
            // 時刻の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
            // nullを返す。
            return null;
        }
        QkanCommon.removeDisabledBindPath(getThis(), data);
        // 問題なければ返却用レコード(data)を返す。
        return data;
    }

    /**
     * 「事業所情報の必要性を取得」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public boolean isUseProvider() throws Exception {
        // ※事業所情報が必要なサービスであるかを返す。
        // 　trueを返す。
        return true;
    }

    /**
     * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ※開始時刻入力用のコンボを返す。
        // 　関数の返り値として開始時間コンボを返す。
        return getBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 　関数の返り値として終了時間コンボを返す。
        return getEndTime();
    }

    /**
     * 「画面状態制御」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void checkState() throws Exception {
        // ※画面状態制御処理
        // ※サービス連動
        // 施設等の区分１（providerDivisionRadio）の値をチェックする。
        switch (getProviderDivisionRadio().getSelectedIndex()) {
        case 1:
            // 値が１（Ⅰ型）だった場合
            // 画面状態を｢画面状態１｣に変更する。
            setState_STATE_MODE_1();
            break;
        case 2:
            // 値が２（Ⅱ型）だった場合
            // 画面の状態を｢画面状態２｣に変更する。
            setState_STATE_MODE_2();
            break;
        }
        
        // 事業所体制と同期
        resetStateByRestrictBindPath();

    }

    /**
     * 「時間区分取得」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public int getNintiTusyoTime() throws Exception {
        // ※時間区分(gtimeDivisionRadio)の時間を取得
        switch (getTimeDivisionRadio().getSelectedIndex()) {
        // 時間区分(timeDivisionRadio)の値をチェックする。
        case 1:
            // 値が1（2から3時間）の場合
            return 180;
        case 2:
            // 値が2（3から5時間）の場合
            return 300;
        case 3:
            // 値が3（5から7時間）の場合
            return 420;
        case 4:
            // 値が4（7から9時間）の場合
            return 540;
        case 5:
            // 値が5（9から10時間）の場合
            return 600;
        case 6:
            // 値が6（10から11時間）の場合
            return 660;
        case 7:
            // 値が7（11から12時間）の場合
            return 720;
        case 8:
            // １２時間以上１３時間未満の場合
            // 戻り値として780を返す。
            return 780;
        case 9:
            // １３時間以上１４時間未満の場合
            // 戻り値として840を返す。
            return 840;
        default:
            // 該当項目が存在しない場合
            // 戻り値として0を返す。
            return 0;
        }
    }

    /**
     * 「開始・終了時間設定」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void checkEndTime() throws Exception {
        // ※開始・終了時間再設定
        // 内部変数 kaigoTime を生成する。
        // 開始時間コンボ(beginTime)の値がをチェックする。
        if (getBeginTime().isValidDate()
                && !ACTextUtilities.isNullText(getBeginTime().getText())) {
            // 不正でない場合
            // 時間退避用の変数kaigoTimeに、時間区分から取得した時間を設定する。
            int kaigoTime = getNintiTusyoTime();
            // 終了時間を「開始時間 + kaigoTime(分)」に設定する。
            getEndTime().setDate(
                    ACDateUtilities.addMinute(getBeginTime().getDate(),
                            kaigoTime));
        }
    }

}
