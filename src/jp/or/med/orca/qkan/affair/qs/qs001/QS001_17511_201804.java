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
 * プログラム サービスパターン介護予防小規模多機能居宅介護 (QS001_17511_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.ComboBoxModel;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRComboBoxModelAdapter;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン介護予防小規模多機能居宅介護(QS001_17511_201804)
 */
@SuppressWarnings("serial")
public class QS001_17511_201804 extends QS001_17511_201804Event {
    /**
     * コンストラクタです。
     */
    public QS001_17511_201804() {
        
        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");
        
        // 値を転記する事業所設定項目
        putImportProviderBindPath("サービス提供体制強化加算", "1750102", "1750108");
        putImportProviderBindPath("総合マネジメント体制強化加算", "1750104", "1750110");
        
        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "1750105", "1750111"); //[H30.4改正]
    }

    // コンポーネントイベント

    /**
     * 「介護支援専門員番号の表示」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void kaigoSupportSpecialMemberNameActionPerformed(ActionEvent e)
            throws Exception {

        // ※介護支援専門員番号の表示
        if (getKaigoSupportSpecialMemberName().isSelected()) {
            // コンボで選択されているデータを取得
            VRMap data = (VRMap) getKaigoSupportSpecialMemberName()
                    .getSelectedModelItem();
            // 取得データより介護支援専門員番号を取得し、表示
            getKaigoSupportSpecialMemberNumber().setText(
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "CARE_MANAGER_NO", data)));
        }
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_17511_201804.class.getName(),
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
        // 要介護認定履歴を取得
        VRList ninteiList = getCalculater().getPatientInsureInfoHistoryList();
        setIsPrintCheckShow(false);
        // 同月内に複数履歴存在する場合
        if (ninteiList.size() > 1) {
            VRMap firstHistory = (VRMap) ninteiList.getData(0);
            VRMap secondHistory = (VRMap) ninteiList.getData(1);
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("JOTAI_CODE", firstHistory), 0)) {

            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                // 要介護⇒要支援
                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0)) {
                case 12:
                case 13:
                    setIsPrintCheckShow(true);
                    break;
                }
                break;

            case 12:
            case 13:
                // 同一の認定履歴の変化の場合
                if (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", firstHistory), 0) == ACCastUtilities
                        .toInt(VRBindPathParser
                                .get("JOTAI_CODE", secondHistory), 0)) {
                    setIsPrintCheckShow(false);
                    break;
                }
                // 要支援１⇔要支援２
                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0)) {
                case 12:
                case 13:
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
        // 摘要欄設定機能
        // バージョンアップ後一発目はバンドパスが存在しないため値を初期化する。
        getTekiyouText().setText("");
        // 画面のラジオの初期値を設定する。（selectFirstRadioItem）
        QkanCommon.selectFirstRadioItem(getThis());
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();

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
        if (provider != null) {
            // 選択事業所情報がnullでない場合
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = getImportData();
            // ※事業所連動
            // 職員の欠員による減算（事業所パネル）KEY：1750101の値をチェックする。
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1750101", provider), 0)) {
            // 値が1（なし）だった場合
            case 1:
                // defaultMapに KEY：1750102 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1750102", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
                // 値が1以外（看護職員・介護職員）だった場合
                // defaultMapに KEY：1750102 VALUE：3（看護・介護職員が欠員）を設定する。
                VRBindPathParser.set("1750102", defaultMap, new Integer(3));
                break;
            }
            // ※介護支援専門員コンボ設定
            // 内部変数 sqlParam を生成する。
            VRMap sqlParam = new VRHashMap();
            // sqlParamに下記の値を格納する。
            // KEY：PROVIDER__ID VALUE：選択事業所番号
            sqlParam.put("PROVIDER_ID",
                    VRBindPathParser.get("PROVIDER_ID", provider));
            // 内部変数 staffs を生成する。
            VRList staffs;
            // 介護支援専門員取得用のSQLを取得する。
            String sql = getSQL_GET_CARE_MANAGER(sqlParam);
            // staffs に取得したSQLを実行した結果を格納する。
            staffs = getDBManager().executeQuery(sql);
            // 取得したVRListの中身をループしながら姓名を結合する。
            Iterator it = staffs.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                // 結合した値を下記のKEYで格納する。
                // KEY：STAFF_NAME
                VRBindPathParser.set("STAFF_NAME", row, QkanCommon.toFullName(
                        VRBindPathParser.get("STAFF_FAMILY_NAME", row),
                        VRBindPathParser.get("STAFF_FIRST_NAME", row)));
            }
            // staffs を介護支援専門員コンボに設定する。
            getKaigoSupportSpecialMemberName().setModel(staffs);

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();

            checkState();

            // staffs の中に介護支援専門員番号テキストの値と同一のものが存在するかチェックする。
            // ACBindUtilities.getMatchIndexFromValue();

            // 一致するものが存在した場合
            // 一致した介護支援専門員を表示する。
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
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
        // 摘要欄の入力チェック
        if (!"".equals(getTekiyouText().getText())) {
            String val = getTekiyouText().getText();
            // 6桁以外の場合
            if (val != null && val.length() != 6) {
                QkanMessageList.getInstance().QS001_ERROR_OF_TEKIYOU_INPUT();
                return null;
            }
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
        return null;
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
        return null;
    }

    /**
     * 「バインド時の処理」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void binded() throws Exception {
        // ※バインド時の処理
        ComboBoxModel mdl = getKaigoSupportSpecialMemberName().getModel();
        // 内部変数 src を生成する。
        VRBindSource src = null;
        // src(VRBindSource);
        if (mdl instanceof VRComboBoxModelAdapter) {
            src = ((VRComboBoxModelAdapter) mdl).getAdaptee();
        }
        // 介護支援専門員コンボ（kaigoSupportSpecialMemberName）よりソースを取得し src に格納する。
        // 取得した src がVRListであるかチェックする。
        if (src instanceof VRList) {
            // VRListであった場合
            // 入力されている介護支援専門員番号（kaigoSupportSpecialMemberNumber）と一致する番号が src
            // 内に存在するかチェックする。
            // getMatchIndexFromValue(src, "CARE_MANAGER_NO", 入力されている介護支援専門員番号);
            int idx = ACBindUtilities.getMatchIndexFromValue((VRList) src,
                    "CARE_MANAGER_NO", getKaigoSupportSpecialMemberNumber()
                            .getText());
            // 存在した場合
            // 内部変数 idx に一致したリスト項目のIndexを格納する。
            // idx の値をチェックする。
            // 値が1より大きかった場合
            // 介護支援専門員コンボ（kaigoSupportSpecialMemberName）の idx と同じ番号で選択状態にする。
            if (idx >= 0) {
                getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
            }
        }

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
     * @throws Exception
     *             例外処理
     */
    public void checkOnDayCheckState() throws Exception {
        if (getIsPrintCheckShow()) {
            if (getCrackOnDayCheck().getValue() == 2) {
                // 日割チェックが有りの場合
                setState_DAY_CHECK_ON();
            } else {
                // 日割チェックが無しの場合
                setState_DAY_CHECK_OFF();
            }
        } else {
            setState_DAY_CHECK_OFF();
        }
    }

    /**
     * 画面状態制御
     * 
     * @throws Exception
     *             例外処理
     */
    public void checkState() throws Exception {
        checkOnDayCheckState();

    }

    /**
     * 日割チェック時の処理
     * 
     * @throws Exception
     *             例外処理
     */
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        checkOnDayCheckState();

    }

}
