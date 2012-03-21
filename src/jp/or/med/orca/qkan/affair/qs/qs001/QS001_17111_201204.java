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
 * プログラム サービスパターン夜間対応型訪問介護 (QS001_17111_201204)
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
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * サービスパターン夜間対応型訪問介護(QS001_17111_201204)
 */
@SuppressWarnings("serial")
public class QS001_17111_201204 extends QS001_17111_201204Event {
    /**
     * コンストラクタです。
     */
    public QS001_17111_201204() {
        // チェック
        putCheckProviderBindPath("介護職員処遇改善加算", "4");
        
    	// 値を転記する事業所設定項目
        putImportProviderBindPath("施設区分", "1710101", "1710101");
        putImportProviderBindPath("24時間通報対応加算", "1710103", "1710107");
        putImportProviderBindPath("サービス提供体制強化加算", "1710104", "1710108");

        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("24時間通報対応加算", "1710103", "1710107");
    }

    // コンポーネントイベント

    /**
     * 「施設区分への連動」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void providerDivisionRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ※施設区分の状態に応じてその他の項目の有効状態を切り替える。
        switch (getProviderDivisionRadio().getSelectedIndex()) {
        case 1:
            // I型
            setState_FACILITY_STATE_1();
            // 定期巡回型だった場合は対応人数を無効にする。
            if (getServiceDivisionRadioItem1().isSelected()) {
                setState_INVALID_PERSONS();
            }
            break;
        case 2:
            // II型
            setState_FACILITY_STATE_2();
            break;
        }

        checkState();

    }

    /**
     * 「サービス区分への連動」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void serviceDivisionRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ※サービス区分の状態に応じて対応人数の有効状態を切り替える。
        switch (getServiceDivisionRadio().getSelectedIndex()) {
        case 1:
            // 定期巡回型
            setState_INVALID_PERSONS();
            break;
        case 2:
            // 随時対応型
            setState_VALID_PERSONS();
            break;
        }

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_17111_201204.class.getName(),
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
        // 市町村独自加算I
        comboItemMap.setData("1710109",
                QkanCommon.getArrayFromMasterCode(276, "1710109"));
        // 市町村独自加算II
        comboItemMap.setData("1710110",
                QkanCommon.getArrayFromMasterCode(277, "1710110"));
        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
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

        checkState();

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
        Object obj;

        // 市町村独自加算I（事業所パネル）KEY：1710105の値をチェックする。
        obj = VRBindPathParser.get("1710105", provider);
        switch (ACCastUtilities.toInt(obj, 0)) {
        // 値が次のいずれかだった場合
        case 2:
            // 2（市町村独自加算１）
        case 3:
            // 3（市町村独自加算２）
        case 4:
            // 4（市町村独自加算３）
        case 5:
            // 5（市町村独自加算４）
        case 6:
            // 6（市町村独自加算５）
        case 7:
            // 7（市町村独自加算６）
            // defaultMapに KEY：1710109 VALUE：事業所の値を設定する。
            VRBindPathParser.set("1710109", defaultMap, obj);
            break;
        default:
            // 値が上記以外だった場合
            // defaultMapに KEY：1710109 VALUE：1（なし）を設定する。
            VRBindPathParser.set("1710109", defaultMap, new Integer(1));
            break;
        }

        // 市町村独自加算II（事業所パネル）KEY：1710106の値をチェックする。
        obj = VRBindPathParser.get("1710106", provider);
        switch (ACCastUtilities.toInt(obj, 0)) {
        // 値が次のいずれかだった場合
        case 2:
            // 2（市町村独自加算１）
        case 3:
            // 3（市町村独自加算２）
        case 4:
            // 4（市町村独自加算３）
        case 5:
            // 5（市町村独自加算４）
        case 6:
            // 6（市町村独自加算５）
        case 7:
            // 7（市町村独自加算６）
            // defaultMapに KEY：1710110 VALUE：事業所の値を設定する。
            VRBindPathParser.set("1710110", defaultMap, obj);
            break;
        default:
            // 値が上記以外だった場合
            // defaultMapに KEY：1710110 VALUE：1（なし）を設定する。
            VRBindPathParser.set("1710110", defaultMap, new Integer(1));
            break;
        }

        // 　　　※展開
        // 　　　　自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 　　　　初期選択項目を展開する。
        getThis().bindSource();
        // 　　※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

        // 基本夜間訪問 I 市町村独自加算が未選択の場合は、最初の項目(なし)を選択する。
        if (getBaseMunicipalityAdd().getSelectedIndex() < 0
                && getBaseMunicipalityAdd().getItemCount() > 0) {
            getBaseMunicipalityAdd().setSelectedIndex(0);
        }
        // 基本夜間訪問 II 市町村独自加算が未選択の場合は、最初の項目(なし)を選択する。
        if (getServiceMunicipalityAdd().getSelectedIndex() < 0
                && getServiceMunicipalityAdd().getItemCount() > 0) {
            getServiceMunicipalityAdd().setSelectedIndex(0);
        }

        providerDivisionRadioSelectionChanged(null);
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
        return getYakanHoumonKaigoBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 　関数の返り値として終了時間コンボを返す。
        return getYakanHoumonKaigoEndTime();
    }

    /**
     * 日割チェック時の画面制御処理です。
     * 
     * @throws Exception 例外処理
     * @author Masahiko.Higuchi
     * @since V5.4.9
     */
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

    /**
     * 画面状態制御
     * 
     * @throws Exception 例外処理
     * @author Masahiko.Higuchi
     * @since V5.4.9
     */
    public void checkState() throws Exception {
        checkOnDayCheckState();
        resetStateByRestrictBindPath();
    }

    /**
     * データバインド後の処理
     * 
     * @throws Exception 例外処理
     * @author Masahiko.Higuchi
     * @since V5.4.9
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
                if (!source.containsKey("15")
                        && getCrackOnDayCheck().isSelected()) {
                    // 表示されているにも関わらず、KEYがないならば選択状態にする
                    getPrintable().setSelected(true);
                }
            }
        }
        // 画面状態制御
        checkOnDayCheckState();

    }

    /**
     * 日割チェック時の処理
     * 
     * @throws Exception 例外処理
     * @author Masahiko.Higuchi
     * @since V5.4.9
     */
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        checkOnDayCheckState();

    }

}
