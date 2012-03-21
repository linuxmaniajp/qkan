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
 * プログラム サービスパターン介護予防認知症対応型共同生活介護 (QS001_13911_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

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
 * サービスパターン介護予防認知症対応型共同生活介護(QS001_13911_201204)
 */
@SuppressWarnings("serial")
public class QS001_13911_201204 extends QS001_13911_201204Event {
    /**
     * コンストラクタです。
     */
    public QS001_13911_201204() {

        // 必須の事業所設定項目
        putCheckProviderBindPath("施設区分", "1390107");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("施設区分", "1390107", "1390109");
        putImportProviderBindPath("夜間勤務条件基準", "1390101", "1390102");
        putImportProviderBindPath("サービス提供体制強化加算", "1390106", "1390106");
        putImportProviderBindPath("夜間ケア加算", "1390103", "1390103");

        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "1390104", "1390104");

    }

    // コンポーネントイベント

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_14311_201204.class.getName(),
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
        // ※選択項目の初期設定
        QkanCommon.selectFirstRadioItem(getThis());
        // 画面のラジオの初期値を設定する。（selectFirstRadioItem）

    }

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数
        if (provider != null) {
            // 選択事業所情報がnullでない場合
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = getImportData();
            // ※設定

            // ※設定
            // 職員の欠員による減算の状況（事業所パネル）KEY：1390102の値をチェックする。
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1390102", provider), 0)) {
            case 1:
                // 値が1（なし）だった場合
                // defaultMapに KEY：1390101 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1390101", defaultMap, new Integer(1));
                break;
            case 2:
                // 値が2（介護従業者）だった場合
                // defaultMapに KEY：1390101 VALUE：3（介護従業者が欠員）を設定する。
                VRBindPathParser.set("1390101", defaultMap, new Integer(3));
                break;
            }

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

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
        // 関数の返り値として終了時間コンボを返す。
        return null;
    }

    public void changeState() throws Exception {
        // 認知症行動・心理症状緊急対応加算 選択時
        if (getDementiaActionAddRadioGroup().getSelectedIndex() == 2) {
            setState_INVALID_YOUNG_DEMENTIA_PATINET();
        } else {
            setState_VALID_YOUNG_DEMENTIA_PATINET();
        }

        // 若年性認知症利用者受入加算 選択時
        if (getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() == 2) {
            setState_INVALID_NINCHI();
        } else {
            setState_VALID_NINCHI();
        }

        // 事業所体制と同期
        resetStateByRestrictBindPath();

    }

    protected void dementiaActionAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        changeState();

    }

    protected void youngDementiaPatinetAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        changeState();

    }

}
