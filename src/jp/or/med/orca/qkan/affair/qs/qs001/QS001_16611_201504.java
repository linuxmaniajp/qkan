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
 * 開発者: 樋口雅彦
 * 作成日: 2011/11/16  日本コンピューター株式会社 樋口雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防通所リハビリテーション (QS001_16611_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン介護予防通所リハビリテーション(QS001_16611_201504)
 */
@SuppressWarnings("serial")
public class QS001_16611_201504 extends QS001_16611_201504Event {
    /**
     * コンストラクタです。
     */
    public QS001_16611_201504() {

        // 必須の事業所設定項目
        putCheckProviderBindPath("施設区分", "1660108");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("施設区分", "1660108", "1660110");
        putImportProviderBindPath("運動器機能向上体制", "1660102", "1660103");
        putImportProviderBindPath("栄養改善体制", "1660103", "1660104");
        putImportProviderBindPath("口腔機能向上体制", "1660104", "1660105");
        putImportProviderBindPath("事業所評価加算の有無", "1660105", "1660106");
        putImportProviderBindPath("サービス提供体制強化加算", "1660107", "1660108");

        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "1660106", "1660107");
        putRestrictProviderBindPath("運動器機能向上体制", "1660102", "1660103");
        putRestrictProviderBindPath("栄養改善体制", "1660103", "1660104");
        putRestrictProviderBindPath("口腔機能向上体制", "1660104", "1660105");
        putRestrictProviderBindPath("選択的サービス複数実施加算", "1660109", "1660111");
        putRestrictProviderBindPath("事業所評価加算の有無", "1660105", "1660106");

    }

    // コンポーネントイベント

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_16611_201504.class.getName(),
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
        // 要介護認定履歴を取得
        VRList ninteiList = getCalculater().getPatientInsureInfoHistoryList();
        setIsPrintCheckShow(false);
        // 同月内に複数履歴存在する場合
        if (ninteiList.size() > 1) {
            VRMap firstHistory = (VRMap) ninteiList.getData(0);
            VRMap secondHistory = (VRMap) ninteiList.getData(1);
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("JOTAI_CODE", firstHistory), 0)) {
            case 12:
                // 要支援１⇒要支援２
                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0)) {
                case 13:
                    setIsPrintCheckShow(true);
                    break;
                }
                break;

            case 13:
                // 要支援２⇒要支援１
                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0)) {
                case 12:
                    setIsPrintCheckShow(true);
                    break;
                }
                break;

            }

        }
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
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
        // 画面状態を設定する。
        checkState();

        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();
        // 画面のラジオの初期値を設定する。（selectFirstRadioItem）
        QkanCommon.selectFirstRadioItem(getThis());

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
            // 職員の欠員による減算の状況（事業所パネル）KEY：1660101の値をチェックする。
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1660101", provider), 0)) {
            case 1:
                // 値が1（なし）だった場合
                // defaultMapに KEY：1660101 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1660101", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                // 値が2（医師・看護職員・介護職員・PT・OT・ST）だった場合
                // defaultMapに KEY：1660101 VALUE：3（医師・PT・OT・ST・看護・介護職員が欠員）を設定する。
                VRBindPathParser.set("1660101", defaultMap, new Integer(3));
                break;
            }

            // ※展開
            // 自身(this)にdefaultMapを設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 画面の状態を変更する。
            checkState();
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
        // ※時刻コンボチェック
        if (!getHoumonKaigoBeginTime().isValidDate()
                || (!getHoumonKaigoEndTime().isValidDate())) {
            // 開始時刻コンボ(houmonKaigoBeginTime)と終了時刻コンボ(houmonKaigoEndTime)のいずれかが空欄もしくは不正の場合
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
        return getHoumonKaigoBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return getHoumonKaigoEndTime();
    }

    /**
     * 「画面状態制御」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkState() throws Exception {

        // 日割りチェックの制御
        checkOnDayCheckState();

        // 運動器機能向上加算・栄養改善加算・口腔機能向上加算の組み合わせチェック
        if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1
        		&& getNourishmentImprovementAddRadio().getSelectedIndex() > 1
        		&& getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	// 運動器機能向上加算 + 栄養改善加算 + 口腔機能向上加算：選択的サービス複数実施加算II
        	getSentakutekiServiceRadio().setSelectedIndex(5);
        } else if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1
        		&& getNourishmentImprovementAddRadio().getSelectedIndex() > 1) {
        	// 運動器機能向上加算 + 栄養改善加算：選択的サービス複数実施加算I1
        	getSentakutekiServiceRadio().setSelectedIndex(2);
        } else if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1
        		&& getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	// 運動器機能向上加算 + 口腔機能向上加算：選択的サービス複数実施加算I2
        	getSentakutekiServiceRadio().setSelectedIndex(3);
        } else if (getNourishmentImprovementAddRadio().getSelectedIndex() > 1
        		&& getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	// 栄養改善加算 + 口腔機能向上加算：選択的サービス複数実施加算I3
        	getSentakutekiServiceRadio().setSelectedIndex(4);
        } else {
        	// 選択的サービス複数実施加算：なし
        	getSentakutekiServiceRadio().setSelectedIndex(1);
        }

        // 事業所体制と同期
        resetStateByRestrictBindPath();

    }

    /**
     * 値バインド後処理
     * 
     */
    public void binded() throws Exception {
        // サービスパネルデータバインド直後のパネルデータの編集処理
        if (this.getParent() instanceof ACPanel) {
            ACPanel panel = (ACPanel) this.getParent();
            // Mapが取れた場合
            if (panel.getSource() instanceof VRMap) {
                VRMap source = (VRMap) panel.getSource();

                /*
                 * バージョンアップ直後の、本票に印字しないチェックにデータがない場合の処理
                 */
                if (getIsPrintCheckShow() && !source.containsKey("15")
                        && getCrackOnDayCheck().isSelected()) {
                    // 表示されているにも関わらず、KEYがないならば選択状態にする
                    getPrintable().setSelected(true);
                }
            }
        }
        checkOnDayCheckState();
    }

    /**
     * 日割チェック時の画面制御処理です。
     * 
     */
    public void checkOnDayCheckState() throws Exception {
        if (getCrackOnDayCheck().getValue() == 2) {
            // 無効にするのを止める
            setState_DAY_CHECK_ON();
        } else {
            setState_DAY_CHECK_OFF();
        }
    }

    /**
     * 日割チェック時の処理
     * 
     */
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        checkOnDayCheckState();

    }
    
    /**
     * 運動器機能向上加算
     */
    protected void moveFunctionImprovementAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 画面状態制御
        checkState();

    }

    /**
     * 栄養改善加算
     */
    protected void nourishmentImprovementAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 画面状態制御
        checkState();

    }

    /**
     * 口腔機能向上加算
     */
    protected void mouthFunctionImprovementAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 画面状態制御
        checkState();

    }

    /**
     * 選択的サービス複数実施加算
     */
    protected void sentakutekiServiceRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        int idx = getSentakutekiServiceRadio().getSelectedIndex();
        // 画面状態制御
        checkState();
        // 全て「なし」か１つだけ選択の場合は、選択したものに戻す
        int selCnt = 0;
        if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	selCnt = selCnt + 1;
        }
        if (getNourishmentImprovementAddRadio().getSelectedIndex() > 1) {
        	selCnt = selCnt + 1;
        }
        if (getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	selCnt = selCnt + 1;
        }
        if (selCnt == 1 || selCnt == 0) {
        	getSentakutekiServiceRadio().setSelectedIndex(idx);
        }

    }

}
