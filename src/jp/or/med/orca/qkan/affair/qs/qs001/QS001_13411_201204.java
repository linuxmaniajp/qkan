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
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防居宅療養管理指導 (QS001_13411_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン介護予防居宅療養管理指導(QS001_13411_201204)
 */
@SuppressWarnings("serial")
public class QS001_13411_201204 extends QS001_13411_201204Event {
    /**
     * コンストラクタです。
     */
    public QS001_13411_201204() {
        
        // 事業所体制のチェック、制御なし
    }

    // コンポーネントイベント

    /**
     * 「職員区分選択」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    @Override
    protected void chargeClassificationRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 在総診選択
        // 画面の状態を変更する
        checkState();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_13411_201204.class.getName(),
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
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
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
        // ラジオの初期値を選択状態にする。※selectFirstRadioItem(getThis)
        QkanCommon.selectFirstRadioItem(getThis());
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();
        // 画面の状態を変更する。
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
            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
        }
        // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
        // 画面の状態を変更する。
        checkState();

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
        if (!getRecuperationManagementGuidanceBeginTime().isValidDate()
                || (!getRecuperationManagementGuidanceEndTime().isValidDate())) {
            // 開始時刻コンボ(recuperationManagementGuidanceBeginTime)と終了時刻コンボ(recuperationManagementGuidanceEndTime)のいずれかが空欄か不正の場合
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
        // trueを返す。
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
        // 関数の返り値として開始時間コンボを返す。
        return getRecuperationManagementGuidanceBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return getRecuperationManagementGuidanceEndTime();
    }

    /**
     * 「情報提供未実施加算制御」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void checkState() throws Exception {
        // 情報提供未実施加算制御に関する処理
        // 担当者区分をの値をチェックする。
        switch (getChargeClassificationRadioGroup().getSelectedIndex()) {
        case 1:
            // 値が1(医師)が選択された場合
            // 画面状態を｢画面状態-医師選択｣に変更する。
            setState_STATE_MODE_1();
            break;
        case 2:
            // 値が2(歯科医師)が選択された場合
            // 画面状態を｢画面状態-歯科医師選択｣に変更する。
            setState_STATE_MODE_2();
            break;
        case 3:
            // 値が3(薬剤師（医療機関）)が選択された場合
            // 画面状態を｢画面状態-薬剤師（医療機関）選択｣に変更する。
            setState_STATE_MODE_3();
            break;
        case 4:
            // 値が4(薬剤師（薬局）)が選択された場合
            // 画面状態を｢画面状態-薬剤師（薬局）選択｣に変更する。
            setState_STATE_MODE_4();
            break;
        case 5:
            // 値が5(管理栄養士)が選択された場合
            // 画面状態を｢画面状態-管理栄養士選択｣に変更する。
            setState_STATE_MODE_5();
            break;
        case 6:
            // 値が6(歯科衛生士等)が選択された場合
            // 画面状態を｢画面状態-歯科衛生士等選択｣に変更する。
            setState_STATE_MODE_6();
            break;
        case 7:
            // 値が7(看護職員)が選択された場合
            // 画面状態を｢画面状態-看護職員選択｣に変更する。
            setState_STATE_MODE_7();
            break;
        }

    }

    /**
     * 職員区分選択時
     */
    protected void recuperationManagementGuidanceOccupationalCategorySelectionChanged(
            ListSelectionEvent e) throws Exception {
        checkState();

    }

    protected void patientDivisionRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 画面状態制御
        checkState();

    }

}
