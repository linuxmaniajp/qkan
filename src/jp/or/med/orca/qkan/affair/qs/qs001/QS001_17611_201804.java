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
 * 作成日: 2011/12/12  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン定期巡回・随時対応型訪問介護看護 (QS001_17611_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン定期巡回・随時対応型訪問介護看護(QS001_17611_201804)
 */
@SuppressWarnings("serial")
public class QS001_17611_201804 extends QS001_17611_201804Event {
    /**
     * コンストラクタです。
     */
    public QS001_17611_201804() {
        // 必須の事業所設定項目
        putCheckProviderBindPath("施設等の区分", "1760105");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("施設等の区分", "1760105", "1760101");
        putImportProviderBindPath("サービス提供強化加算", "1760104", "1760108");
        putImportProviderBindPath("総合マネジメント体制強化加算", "1760106", "1760112");

        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("ターミナルケア体制", "1760103", "1760107");
        putRestrictProviderBindPath("特別管理体制", "1760101", "1760106");
        putRestrictProviderBindPath("緊急時訪問看護加算", "1760102", "1760105");
        putRestrictProviderBindPath("総合マネジメント体制強化加算", "1760106", "1760112");
    }

    // コンポーネントイベント

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_17611_201804.class.getName(),
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

        // 市町村独自加算
        comboItemMap.setData("1760109",
                QkanCommon.getArrayFromMasterCode(283, "1760109"));

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
        QkanCommon.selectFirstRadioItem(this);

        // ※準備
        // 初期選択設定用のレコード defaultMap を生成する。
        VRMap defaultMap = new VRHashMap();
        // ※設定
        // 画面のラジオの初期値を設定する。（selectFirstRadioItem）
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
        if (provider == null) {
            return;
        }

        // ※以下の内容詳細項目は、選択事業所の値を設定する。
        // ※準備
        // 事業所連動用のレコード defaultMap を生成する。
        VRMap defaultMap = getImportData();

        if (VRBindPathParser.get("1760109", provider) == null) {
            VRBindPathParser.set("1760109", defaultMap, new Integer(1));
        }

        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();

        // 画面状態制御
        checkState();

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
        // ※時刻コンボチェック
        if (!getHomonNyuyokuBeginTime().isValidDate()
                || (!getHomonNyuyokuEndTime().isValidDate())) {
            // 開始時刻コンボ(homonNyuyokuBeginTime)と終了時刻コンボ(homonNyuyokuEndTime)のいずれかが空欄もしくは不正の場合
            // 時刻の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
            // nullを返す。
            return null;
        }
        QkanCommon.removeDisabledBindPath(getThis(), data);
        // 　問題なければ返却用レコード(data)を返す。
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
        return getHomonNyuyokuBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 　関数の返り値として終了時間コンボを返す。
        return getHomonNyuyokuEndTime();
    }

    /**
     * サービス提供選択時
     */
    protected void divisionRadioGroupSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 画面状態制御
        checkState();

    }

    /**
     * 訪問看護指示書の提供
     */
    protected void sijishoOfferRadioGroupSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 画面状態制御
        checkState();

    }

    @Override
    public void checkState() throws Exception {

        if (getDivisionRadioGroup().getSelectedIndex() == 1) {
            // 一体型定期巡回
            if (getSijishoOfferRadioGroup().getSelectedIndex() == 1) {
                // 指示を受けない場合
                setState_DIVISION_STATE_1();
            } else {
                // 指示を受ける場合
                setState_DIVISION_STATE_2();
            }

        } else {
            // 連携型定期巡回
            setState_DIVISION_STATE_3();
        }

        checkOnDayCheckState();

        // 事業所制御最優先
        resetStateByRestrictBindPath();

    }

    @Override
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        checkOnDayCheckState();
    }

    @Override
    public void checkOnDayCheckState() throws Exception {
        if (getCrackOnDayCheck().isEnabled()
                && getCrackOnDayCheck().getValue() == 2) {
            // 日割チェックが有りの場合
            setState_DAY_CHECK_ON();
        } else {
            // 日割チェックが無しの場合
            setState_DAY_CHECK_OFF();
        }
    }

    @Override
    public void binded() throws Exception {
        // 画面状態制御
        checkState();
    }

}
