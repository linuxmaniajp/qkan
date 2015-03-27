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
 * プログラム サービスパターン地域密着型特定施設入所者生活介護 (QS001_13611_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

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
 * サービスパターン地域密着型特定施設入所者生活介護(QS001_13611_201504)
 */
@SuppressWarnings("serial")
public class QS001_13611_201504 extends QS001_13611_201504Event {
    /**
     * コンストラクタです。
     */
    public QS001_13611_201504() {
        // チェック
        putCheckProviderBindPath("看取り介護", "1360105");

        // 事業所からの値の引き継ぎ
        // 2015.03.02 del putImportProviderBindPath("個別機能訓練指導加算", "1360101", "1360102");
        putImportProviderBindPath("夜間看護体制", "1360103", "1360103");
        // 2015.03.02 del putImportProviderBindPath("認知症専門ケア加算", "1360107", "1360107");
        putImportProviderBindPath("サービス提供体制強化加算", "1360108", "1360108");

        // 事業所の設定により無効にする
        putRestrictProviderBindPath("個別機能訓練指導加算", "1360101", "1360102");
        putRestrictProviderBindPath("看取り介護", "1360105", "1360106");
        putRestrictProviderBindPath("認知症専門ケア加算", "1360107", "1360107");
    }

    // コンポーネントイベント

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_13611_201504.class.getName(),
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
        // 　※準備
        // 　　コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // 　※設定
        // 　※展開
        // 　　自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // 　　コンボアイテムを展開する。
        getThis().bindModelSource();
        // ※選択項目の初期設定
        QkanCommon.selectFirstRadioItem(getThis());
        // 　※準備
        // 　　初期選択設定用のレコード defaultMap を生成する。
        VRMap defaultMap = new VRHashMap();
        // 　※設定
        // 　※展開
        // 　　自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 　　初期選択項目を展開する。
        getThis().bindSource();

    }

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数
        // 　選択事業所情報がnullでない場合
        // 　　※以下の内容詳細項目は、選択事業所の値を設定する。
        // 　　　※準備
        // 　　　　事業所連動用のレコード defaultMap を生成する。
        VRMap defaultMap = getImportData();
        // 　　　※設定
        // 人員減算
        Object obj;
        obj = VRBindPathParser.get("1360102", provider);
        if (obj != null) {
            // 事業所登録の減算項目に合わせ初期値を調整
            switch (ACCastUtilities.toInt(obj)) {
            case 1: // なしだった場合
                VRBindPathParser.set("1360101", defaultMap, new Integer(1));
                break;
            case 2:
            case 3: // 介護従業者だった場合
                VRBindPathParser.set("1360101", defaultMap, new Integer(2));
                break;
            }
        }

        // 　　　※展開
        // 　　　　自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 　　　　初期選択項目を展開する。
        getThis().bindSource();
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
        // 　自身(this)のソースとして生成レコードを設定する。
        getThis().setSource(data);
        // 　自身(this)のapplySourceを呼び出してデータを収集する。
        getThis().applySource();
        // ※返却用レコードから不要なキーを除去
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

}