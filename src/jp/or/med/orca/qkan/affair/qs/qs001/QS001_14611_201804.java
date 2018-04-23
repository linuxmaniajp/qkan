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
 * プログラム サービスパターン介護予防支援費 (QS001_14611_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.ComboBoxModel;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRComboBoxModelAdapter;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン介護予防支援費(QS001_14611_201804)
 */
@SuppressWarnings("serial")
public class QS001_14611_201804 extends QS001_14611_201804Event {
    /**
     * コンストラクタです。
     */
    public QS001_14611_201804() {
        // 設定なし
    }

    // コンポーネントイベント

    /**
     * 「介護支援専門員番号（予防支援）取得」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void careManagerNameComboActionPerformed(ActionEvent e)
            throws Exception {
        // ※介護支援専門員番号（予防支援）取得
        if (getCareManagerNameCombo().isSelected()
                && !ACTextUtilities.isNullText(getCareManagerNameCombo()
                        .getText())) {
            // 介護支援専門員名コンボ（予防支援）で選択されているデータを取得
            VRMap data = (VRMap) getCareManagerNameCombo()
                    .getSelectedModelItem();
            // 取得データより介護支援専門員番号を取得し、表示
            getCareManagerNoText().setText(
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "CARE_MANAGER_NO", data)));
        }

    }

    /**
     * 「支援事業所（委託先）選択」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void consignmentProviderActionPerformed(ActionEvent e)
            throws Exception {

        // ※支援事業所（委託先）選択
        checkState();
        // 値をクリア
        getConsignmentCareManagerNoText().setText("");
        if (getConsignmentProvider().isSelected()
                && !ACTextUtilities.isNullText(getConsignmentProvider()
                        .getText())) {
            // 内部変数 sqlParam を生成する。
            VRMap sqlParam = new VRHashMap();
            // sqlParamに下記の値を格納する。
            // KEY：PROVIDER__ID VALUE：選択されている事業所番号（委託先）
            sqlParam.put("PROVIDER_ID", VRBindPathParser.get("PROVIDER_ID",
                    (VRMap) getConsignmentProvider().getSelectedModelItem()));

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
                // KEY：CONSIGNMENT_STAFF_NAME
                VRBindPathParser.set("CONSIGNMENT_STAFF_NAME", row, QkanCommon
                        .toFullName(
                                VRBindPathParser.get("STAFF_FAMILY_NAME", row),
                                VRBindPathParser.get("STAFF_FIRST_NAME", row)));
            }
            // staffs を介護支援専門員コンボ（委託先事業所）に設定する。
            getConsignmentCareManagerNameCombo().setModel(staffs);
        } else {
            VRList staffs = new VRArrayList();
            getConsignmentCareManagerNameCombo().setModel(staffs);
        }
    }

    /**
     * 「介護支援専門員番号（委託先）取得」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void consignmentCareManagerNameComboActionPerformed(ActionEvent e)
            throws Exception {
        // ※介護支援専門員番号（委託先）取得
        if (getConsignmentCareManagerNameCombo().isSelected()
                && !ACTextUtilities
                        .isNullText(getConsignmentCareManagerNameCombo()
                                .getText())) {
            // 介護支援専門員名コンボ（委託先）で選択されているデータを取得
            VRMap data = (VRMap) getConsignmentCareManagerNameCombo()
                    .getSelectedModelItem();
            // 取得データより介護支援専門員番号を取得し、表示
            getConsignmentCareManagerNoText().setText(
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
        ACFrame.debugStart(new ACAffairInfo(QS001_14611_201804.class.getName(),
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

        // ※委託先事業情報設定
        // 共通関数 getProviderInfo
        // を使用し居宅介護支援事業所、小規模多機能居宅介護支援事業所、介護予防支援、介護予防小規模多機能型居宅介護支援を提供している事業所を取得する。
        // getProviderInfo(数値配列 14311,17311,14611,17511);
        // バインドパスPROVIDER_ID を 1460102 に振りなおす
        // [ID:0000724][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 del begin
        //VRList list = (VRList) QkanCommon.getProviderInfo(getDBManager(),
        //        new int[] { 14311, 17311, 14611, 17511 });
        // [ID:0000724][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 del end
        // [ID:0000724][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
        VRList list = (VRList) QkanCommon.getProviderInfo(getDBManager(),
                new int[] { 14311, 17311, 14611, 17511, 17711 });
        // [ID:0000724][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add end

        ACBindUtilities.copyBindPath(list, "PROVIDER_ID", "1460102");
        // 委託先事業所を設定
        getConsignmentProvider().setModel(list);
        // 空白を設定
        getConsignmentProvider().setSelectedIndex(0);

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
            // 介護支援専門員番号を空白にする。
            getCareManagerNoText().setText("");
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = new VRHashMap();
            // ※設定
            // ※介護支援専門員コンボ設定
            // 内部変数 sqlParam を生成する。
            VRMap sqlParam = new VRHashMap();
            // sqlParamに下記の値を格納する。
            // KEY：PROVIDER_ID VALUE：介護予防選択事業所番号
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
            // staffs を介護支援専門員コンボ（介護予防支援事業所）に設定する。
            getCareManagerNameCombo().setModel(staffs);
            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
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
        QkanCommon.removeDisabledBindPath(getThis(), data);
        // ※介護支援専門員番号をチェックする。
        // ※委託先介護支援専門員番号と委託先介護支援事業所の値をチェックする。
        if (getConsignmentCareManagerNoText().isEnabled()) {
            if (ACTextUtilities.isNullText(getConsignmentCareManagerNoText()
                    .getText())) {
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                // 問題なければ返却用レコード(data)を返す。
                return null;
            }
        } else {
            // 委託先事業所が未選択の場合
            // 委託先事業所のキーをデータから除外する。
            data.remove(getConsignmentProvider().getBindPath());
        }
        // 片方だけ未入力だった場合 ※両方とも未入力の場合は問題ない
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
     * 「データバインド時」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void binded() throws Exception {
        // ※データバインド時
        ComboBoxModel mdl = getCareManagerNameCombo().getModel();
        // 内部変数 src を生成する。
        // src(VRBindSource);
        VRBindSource src = null;
        // 内部変数 idx を生成する。
        int idx = 0;
        // ※予防支援介護支援専門員名選択処理
        if (mdl instanceof VRComboBoxModelAdapter) {
            src = ((VRComboBoxModelAdapter) mdl).getAdaptee();
        }
        // 介護支援専門員コンボ（careManagerNameCombo）よりソースを取得し src に格納する。
        // 取得した src がVRListであるかチェックする。
        if (src instanceof VRList) {
            // VRListであった場合
            // 入力されている介護支援専門員番号（careManagerNoText）と一致する番号が src 内に存在するかチェックする。
            // getMatchIndexFromValue(src, "CARE_MANAGER_NO", 入力されている介護支援専門員番号);
            idx = ACBindUtilities.getMatchIndexFromValue((VRList) src,
                    "CARE_MANAGER_NO", getCareManagerNoText().getText());
            // 存在した場合
            // 内部変数 idx に一致したリスト項目のIndexを格納する。
            // idx の値をチェックする。
            // 値が1より大きかった場合
            // 介護支援専門員コンボ（kaigoSupportSpecialMemberName）の idx と同じ番号で選択状態にする。
            if (idx >= 0) {
                getCareManagerNameCombo().setSelectedIndex(idx + 1);
            }
        }

        // ※委託先介護支援専門員名選択処理
        // src を初期化する。
        idx = 0;
        src = null;
        mdl = getConsignmentCareManagerNameCombo().getModel();
        // 介護支援専門員コンボ（consignmentProvider）よりソースを取得し src に格納する。
        if (mdl instanceof VRComboBoxModelAdapter) {
            src = ((VRComboBoxModelAdapter) mdl).getAdaptee();
        }
        // 取得した src がVRListであるかチェックする。
        if (src instanceof VRList) {
            // VRListであった場合
            // 入力されている介護支援専門員番号（consignmentCareManagerNoText）と一致する番号が src
            // 内に存在するかチェックする。
            // getMatchIndexFromValue(src, "CARE_MANAGER_NO", 入力されている介護支援専門員番号);
            idx = ACBindUtilities.getMatchIndexFromValue((VRList) src,
                    "CARE_MANAGER_NO", getConsignmentCareManagerNoText()
                            .getText());
            // 存在した場合
            // 内部変数 idx に一致したリスト項目のIndexを格納する。
            // idx の値をチェックする。
            // 値が1より大きかった場合
            // 介護支援専門員コンボ（kaigoSupportSpecialMemberName）の idx+1(空白分があるので+1）
            // と同じ番号で選択状態にする。
            if (idx >= 0) {
                getConsignmentCareManagerNameCombo().setSelectedIndex(idx + 1);
            }
        }

    }

    /**
     * 「画面状態制御」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void checkState() throws Exception {
        // 委託先事業所コンボの値をチェックする。
        // 委託先事業所コンボで空白が選択されていた場合
        if (getConsignmentProvider().getSelectedIndex() == 0) {
            // 画面状態1
            setState_STATE_MODE_1();
        } else {
            // 画面状態2
            setState_STATE_MODE_2();
        }
    }

}
