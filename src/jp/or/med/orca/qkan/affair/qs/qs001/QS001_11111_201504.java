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
 * プログラム サービスパターン訪問介護 (QS001_11111_201504)
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
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン訪問介護(QS001_11111_201504)
 */
@SuppressWarnings("serial")
public class QS001_11111_201504 extends QS001_11111_201504Event {
	
	
    /**
     * コンストラクタです。
     */
    public QS001_11111_201504() {
        // 必須の事業所設定項目
        putCheckProviderBindPath("サービス提供責任者", "1110103");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("サービス提供責任者", "1110103", "1110113");
        putImportProviderBindPath("特定事業所加算", "1110101", "1110109");
        
        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("頻回の訪問として行う", "1110104", "1110114");
    }

    // コンポーネントイベント

    /**
     * 「状態設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKaigoServicePatternActionPerformed(ActionEvent e)
            throws Exception {
        // ※「訪問種別」に応じて、選択可能なインスタンスを設定
        // コンボ候補設定
        checkComboItem();

        // 画面状態制御
        checkState();

    }

    /**
     * 「時間帯変更時」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKaigoTimeZoneActionPerformed(ActionEvent e)
            throws Exception {
        // ※時間帯変更時、開始時間も変更
        // houmonKaigoTimeZoneの値をチェックする。
        switch (getHoumonKaigoTimeZone().getSelectedIndex()) {
        case 1:
            // 通常の場合
            // 開始時間を9:00にする。
            getHoumonKaigoBeginTime().setText("9:00");
            break;
        case 2:
            // 早朝の場合
            // 開始時間を6:00にする。
            getHoumonKaigoBeginTime().setText("6:00");
            break;
        case 3:
            // 夜間の場合
            // 開始時間を18:00にする。
            getHoumonKaigoBeginTime().setText("18:00");
            break;
        case 4:
            // 深夜の場合
            // 開始時間を22:00にする。
            getHoumonKaigoBeginTime().setText("22:00");
            break;
        }
        // 時間帯変更時、終了時間も変更する。
        checkEndTime();

    }

    /**
     * 「身体介護提供時間変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void homonkaigoTeikyoTimeActionPerformed(ActionEvent e)
            throws Exception {
        // ※時間帯変更時、終了時間も変更
        // 時間帯変更時、終了時間も変更する。
        checkEndTime();

// 2015/2/26 [H27.4改正対応][Yoichiro Kamei] add - begin            
        // 画面状態制御
        checkState();
// 2015/2/26 [H27.4改正対応][Yoichiro Kamei] add - end
    }

    /**
     * 「生活援助提供時間変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKaigoInTimeActionPerformed(ActionEvent e)
            throws Exception {
        // ※時間帯変更時、終了時間も変更
        // 時間帯変更時、終了時間も変更する。
        checkEndTime();

    }

    /**
     * 「開始時間変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKaigoBeginTimeActionPerformed(ActionEvent e)
            throws Exception {
        // ※開始時間変更時、終了時間も変更
        // 開始時間変更時、終了時間も変更
        checkEndTime();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_11111_201504.class.getName(),
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
        // ※訪問種別
        // コードマスタデータよりCODE_ID：198（訪問種別）を取得する。
        // 取得した値を、comboItemMapの KEY : 1110101 の VALUE として設定する。
        comboItemMap.setData("1110101",
                QkanCommon.getArrayFromMasterCode(198, "1110101"));
        // ※提供時間
        // コードマスタデータよりCODE_ID：281（うち身体時間）を取得する。
        // 取得した値を、comboItemMapの KEY : 1110104 の VALUE として設定する。
        comboItemMap.setData("1110104",
                QkanCommon.getArrayFromMasterCode(280, "1110104"));
        // コードマスタデータよりCODE_ID：280（提供時間）を取得する。
        // 取得した値を、comboItemMapの KEY : 1110105 の VALUE として設定する。
        comboItemMap.setData("1110105",
                QkanCommon.getArrayFromMasterCode(281, "1110105"));
        // ※うち身体時間
        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
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
        QkanCommon.selectFirstRadioItem(getThis());
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
        // ※事業所コンボ変更時に呼ぶ関数
        // 選択事業所情報がnullでない場合
        if (provider != null) {
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = getImportData();

            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            
            // 画面状態制御
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
        if (!getHoumonKaigoServicePattern().isSelected()) {
            // 訪問種別が未選択の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }

        if (getHoumonKaigoServicePattern().getSelectedIndex() != 3) {
            // 訪問種別が通院乗降解除以外の場合
            switch (getHoumonKaigoServicePattern().getSelectedIndex()) {
            case 0:
                // 訪問種別が身体介護の場合
                if (!getHomonkaigoTeikyoTime().isSelected()) {
                    // 提供時間が未選択の場合
                    // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // nullを返す。
                    return null;
                }
                break;
            case 1:
                // 訪問種別が生活援助の場合
                if (!getHoumonKaigoInTime().isSelected()) {
                    // 提供時間が未選択の場合
                    // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // nullを返す。
                    return null;
                }
                break;
            case 2:
                // 訪問種別が身体生活の場合
                if ((!getHomonkaigoTeikyoTime().isSelected())
                        || (!getHoumonKaigoInTime().isSelected())) {
                    // 提供時間が未選択の場合
                    // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // nullを返す。
                    return null;
                }
                break;
            }

        }

        if (ACTextUtilities.isNullText(getHoumonKaigoBeginTime().getText())
                || ACTextUtilities
                        .isNullText(getHoumonKaigoEndTime().getText())
                || (!getHoumonKaigoBeginTime().isValidDate())
                || (!getHoumonKaigoEndTime().isValidDate())) {
            // 開始時刻コンボ(houmonKaigoBeginTime)と終了時刻コンボ(houmonKaigoEndTime)のいずれかが空欄もしくは不正の場合
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
     * 「提供時間の取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public int getTeikyoTime() throws Exception {
        // ※提供時間コンボより、時間を取得
        int addMinute = 0;
        // 提供時間コンボ(homonkaigoTeikyoTime)の値をチェックする。
        if (getHomonkaigoTeikyoTime().isEnabled()
                && getHomonkaigoTeikyoTime().isSelected()) {
            // ★身体介護
            // [ID:0000706][Shin Fujihara] 2012/03 delete begin 2012年度対応
//            if (getHoumonKaigoServicePattern().getSelectedIndex() == 2) {
//                // (選択番号+1)×30を返す。
//                addMinute += (getHomonkaigoTeikyoTime().getSelectedIndex() + 1) * 30;
//            } else {
//                if (getHomonkaigoTeikyoTime().getSelectedIndex() == 0) {
//                    addMinute += 20;
//                } else {
//                    // (選択番号+1)×30を返す。
//                    addMinute += (getHomonkaigoTeikyoTime().getSelectedIndex()) * 30;
//                }
//            }
            // [ID:0000706][Shin Fujihara] 2012/03 delete end 2012年度対応
            // [ID:0000706][Shin Fujihara] 2012/03 add begin 2012年度対応
            if (getHomonkaigoTeikyoTime().getSelectedIndex() == 0) {
                addMinute += 20;
            } else {
                // (選択番号+1)×30を返す。
                addMinute += (getHomonkaigoTeikyoTime().getSelectedIndex()) * 30;
            }
            // [ID:0000706][Shin Fujihara] 2012/03 add end 2012年度対応
        }
        if (getHoumonKaigoInTime().isEnabled()
                && getHoumonKaigoInTime().isSelected()) {
            if (getHoumonKaigoServicePattern().getSelectedIndex() == 1) {
                // 生活援助の場合
                if (getHoumonKaigoInTime().getSelectedIndex() == 0) {
                    // [ID:0000718][Masahiko.Higuchi] 2012/04 edit begin 2012年度対応
                    addMinute += 45;
                    // [ID:0000718][Masahiko.Higuchi] 2012/04 edit end
                } else {
                    // [ID:0000718][Masahiko.Higuchi] 2012/04 edit begin 2012年度対応
                    addMinute += 70;
                    // [ID:0000718][Masahiko.Higuchi] 2012/04 edit end
                }
            } else {
                // 身体生活
                // [ID:0000705][Shin Fujihara] 2012/03 delete begin 2012年度対応
//                if (getHoumonKaigoInTime().getSelectedIndex() == 0) {
//                    addMinute += 20;
//                } else {
//                    addMinute += 20 + ((getHoumonKaigoInTime()
//                            .getSelectedIndex() * 25));
//                }
                // [ID:0000705][Shin Fujihara] 2012/03 delete end 2012年度対応
                // [ID:0000705][Shin Fujihara] 2012/03 add begin 2012年度対応
                addMinute += 45 + ((getHoumonKaigoInTime().getSelectedIndex() * 25));
                // [ID:0000705][Shin Fujihara] 2012/03 add end 2012年度対応
            }
        }
        return addMinute;
    }

    /**
     * 「終了時間のチェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkEndTime() throws Exception {
        // ※時間帯変更時、終了時間も変更
        if (getHoumonKaigoBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getHoumonKaigoBeginTime()
                        .getText()))) {
            // 開始時刻コンボ(houmonKaigoBeginTime)が入力済みかつ不正でない場合
            // 提供時間コンボから提供分数を取得する。
            // 開始時刻に提供分数を加算した結果を終了時刻コンボ(houmonKaigoEndTime)に設定する。
            getHoumonKaigoEndTime().setDate(
                    ACDateUtilities.addMinute(getHoumonKaigoBeginTime()
                            .getDate(), getTeikyoTime()));
        }

    }

    /**
     * 「コンボ内容変更」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkComboItem() throws Exception {
        // ※コンボ内容変更処理
        // 内部変数 comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // サービスコンボの値をチェックする。
        switch (getHoumonKaigoServicePattern().getSelectedIndex()) {
        case 0: // 身体生活
            // 値が0（身体生活）だった場合
            comboItemMap.setData("1110104",
                    QkanCommon.getArrayFromMasterCode(280, "1110104"));
            // // コードマスタデータよりCODE_ID：282（提供時間・身体介護）を取得する。
            // // 取得した値を、comboItemMapの KEY : 1110105 の VALUE として設定する。
            // comboItemMap.setData("1110105",
            // QkanCommon.getArrayFromMasterCode(282, "1110105"));
            break;

        case 1: // 生活援助
            // 値が1（生活援助）だった場合
            // comboItemMap.setData("1110104",
            // QkanCommon.getArrayFromMasterCode(280, "1110104"));

            // コードマスタデータよりCODE_ID：281（提供時間・生活援助）を取得する。
            // 取得した値を、comboItemMapの KEY : 1110105 の VALUE として設定する。
            comboItemMap.setData("1110105",
                    QkanCommon.getArrayFromMasterCode(281, "1110105"));
            break;

        case 2: // 身体生活
            // 値が2（身体生活）だった場合
            // コードマスタデータよりCODE_ID：285（提供時間・身体生活）を取得する。
            // 取得した値を、comboItemMapの KEY : 1110105 の VALUE として設定する。
            comboItemMap.setData("1110104",
                    QkanCommon.getArrayFromMasterCode(285, "1110104"));

            comboItemMap.setData("1110105",
                    QkanCommon.getArrayFromMasterCode(282, "1110105"));
            break;

        }

        // ※展開
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();

    }

    /**
     * 「バインド処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void binded() throws Exception {
        // ※バインド時の処理
        // 　サービス区分が生活援助で尚且つ生活援助コンボの値が3以上だった場合は一律2を設定状態にする。
        // サービス区分が生活援助だった場合
        if (getHoumonKaigoServicePattern().getSelectedIndex() == 1) {
            // ソースを取得
            VRBindSource src = getHoumonKaigoInTime().getSource();
            if (src != null) {
                // 生活援助コンボの値をチェックする。
                // 要望対応前のデータだった場合
                if (ACCastUtilities.toInt(src.getData("1110105")) >= 3) {
                    getHoumonKaigoInTime().setSelectedIndex(1);
                }
            }
        }
        
// 2015/2/26 [H27.4改正対応][Yoichiro Kamei] add - begin
        // 画面状態制御
        checkState();
// 2015/2/26 [H27.4改正対応][Yoichiro Kamei] add - end
    }

    @Override
    protected void specificProviderAddRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 画面状態制御
        checkState();

    }

    @Override
    public void checkState() throws Exception {
        // 訪問種別の値をチェックする。
        switch (getHoumonKaigoServicePattern().getSelectedIndex()) {
        case 0:
            // 身体介護の場合
            // 身体介護用の状態を設定する。
            setState_SHINTAI_KAIGO();
            break;
        case 1:
            // 生活援助の場合
            // 生活援助用の状態を設定する。
            setState_SEIKATSU_ENJO();
            break;
        case 2:
            // 身体生活の場合
            // 身体生活用の状態を設定する。
            setState_SHINTAI_SEIKATSU();
            break;
        case 3:
            // 通院等乗降介助の場合
            // 通院等乗降介助用の状態を設定する。
            setState_JOKOKAIJO();
            break;
        }
        
        // 特定事業所加算選択時
        if (getSpecificProviderAddRadio().isEnabled()) {
            switch (getSpecificProviderAddRadio().getSelectedIndex()) {
            case 2: // I型
                setState_CLASS2_INVALID();
                break;
            default:
                setState_CLASS2_VALID();
                break;
            }
        }
        
 // 2015/2/4 [H27.4改正対応][Yoichiro Kamei] add - begin
        if (getHomonkaigoTeikyoTime().isEnabled()) {
            switch (getHomonkaigoTeikyoTime().getSelectedIndex()) {
            case 0: // 20分未満選択時
                setState_MORE_TIMES_CHECK_VALID();
                break;
            default:
                setState_MORE_TIMES_CHECK_INVALID();
                break;
            }
        } else {
            setState_MORE_TIMES_CHECK_INVALID();
        }
        
        // 選択事業所の「なし」「あり」によって、無効/有効を切り替える。
        resetStateByRestrictBindPath();
//2015/2/4 [H27.4改正対応][Yoichiro Kamei] add - end
    }

}
