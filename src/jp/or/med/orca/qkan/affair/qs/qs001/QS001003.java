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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/01/08  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問介護 (QS001003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン訪問介護(QS001003)
 */
public class QS001003 extends QS001003Event {
    /**
     * コンストラクタです。
     */
    public QS001003() {
    }

    /**
     * 初期化処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void initialize() throws Exception {
        // ※画面展開時の初期設定
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();

        // ※訪問種別
        // コードマスタデータよりCODE_ID：198（訪問種別）を取得する。
        // 取得した値を、comboItemMapの KEY : 1110101 の VALUE として設定する。
        comboItemMap.setData("1110101", QkanCommon.getArrayFromMasterCode(198,
                "1110101"));
        // ※提供時間
        // コードマスタデータよりCODE_ID：26（提供時間）を取得する。
        // 取得した値を、comboItemMapの KEY : 1110105 の VALUE として設定する。
        comboItemMap.setData("1110105", QkanCommon.getArrayFromMasterCode(26,
                "1110105"));
        // ※うち身体時間
        // コードマスタデータよりCODE_ID：26（うち身体時間）を取得する。
        // 取得した値を、comboItemMapの KEY : 1110104 の VALUE として設定する。
        comboItemMap.setData("1110104", QkanCommon.getArrayFromMasterCode(26,
                "1110104"));
        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ※コンボアイテムの設定
        // 「自身(this)」にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();

        // ※選択項目の初期設定
        // 訪問者の級職ラジオグループ(houmonKaigoClass)の「3級以外」を選択する。
        getHoumonKaigoClass().setSelectedIndex(1);
        // 訪問人数ラジオグループ(houmonKaigoNumberOfPeople)の「1人」を選択する。
        getHoumonKaigoNumberOfPeople().setSelectedIndex(1);
        // 時間帯ラジオグループ(houmonKaigoTimeZone)の「通常」を選択する。
        getHoumonKaigoTimeZone().setSelectedIndex(1);

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

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        ACFrame.debugStart(new ACAffairInfo(QS001003.class.getName()));
    }

    // 内部関数

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @param provider VRMap
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {

    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return VRMap
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
            if (!getHomonkaigoTeikyoTime().isSelected()) {
                // 提供時間が未選択の場合
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }

            switch (getHoumonKaigoServicePattern().getSelectedIndex()) {
            case 1:
                // 訪問種別が生活援助の場合
                if (getHomonkaigoTeikyoTime().getSelectedIndex() < 1) {
                    // 提供時間コンボ(homonkaigoTeikyoTime)が30分未満の場合
                    // 生活援助の提供時間の不備メッセージを表示する。※ID=QS001_ERROR_OF_LIFE_ASSIST_TIME
                    QkanMessageList.getInstance()
                            .QS001_ERROR_OF_LIFE_ASSIST_TIME();
                    // nullを返す。
                    return null;
                }
                break;
            case 2:
                // 訪問種別が身体生活の場合
                if (!getHoumonKaigoInTime().isSelected()) {
                    // うち身体時間が未選択の場合
                    // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // nullを返す。
                    return null;
                }

                if (getHomonkaigoTeikyoTime().getSelectedIndex() < getHoumonKaigoInTime()
                        .getSelectedIndex()) {
                    // 提供時間よりもうち身体時間のほうが大きい場合
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
        if (!getHomonkaigoTeikyoTime().isEnabled()) {
            // 提供時間(homonkaigoTeikyoTime)が無効の場合
            // 返却用レコードから、提供時間(homonkaigoTeikyoTime)のbindPathを除去する。
            data.remove(getHomonkaigoTeikyoTime().getBindPath());
        }
        if (!getHoumonKaigoInTime().isEnabled()) {
            // うち身体時間(houmonKaigoInTime)が無効の場合
            // 返却用レコードから、うち身体時間(houmonKaigoInTime)のbindPathを除去する。
            data.remove(getHoumonKaigoInTime().getBindPath());
        }
        if (!getHoumonKaigoNumberOfPeople().isEnabled()) {
            // 訪問人数(houmonKaigoNumberOfPeople)が無効の場合
            // 返却用レコードから、訪問人数(houmonKaigoNumberOfPeople)のbindPathを除去する。
            data.remove(getHoumonKaigoNumberOfPeople().getBindPath());
        }
        if (!getHoumonKaigoBeginTime().isEnabled()) {
            // 開始時刻コンボ(houmonKaigoBeginTime)が無効な場合
            // 返却用レコードから、訪問人数(houmonKaigoBeginTime)のbindPathを除去する。
            // 返却用レコードから、訪問人数(houmonKaigoEndTime)のbindPathを除去する。
            data.remove(getHoumonKaigoBeginTime().getBindPath());
            data.remove(getHoumonKaigoEndTime().getBindPath());

        }
        // 問題なければ返却用レコード(data)を返す。
        return data;
    }

    /**
     * 「事業所情報の必要性を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return boolean
     */
    public boolean isUseProvider() throws Exception {
        // ※事業所情報が必要なサービスであるかを返す。
        // trueを返す。
        return true;
    }

    /**
     * 「提供時間変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void homonkaigoTeikyoTimeActionPerformed(ActionEvent e)
            throws Exception {
        // ※時間帯変更時、終了時間も変更
        // 時間帯変更時、終了時間も変更する。
        checkEndTime();
    }

    /**
     * 「提供時間の取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return int
     */
    public int getTeikyoTime() throws Exception {
        // ※提供時間コンボより、時間を取得
        // 提供時間コンボ(homonkaigoTeikyoTime)の値をチェックする。
        if (getHomonkaigoTeikyoTime().isSelected()) {
            // (選択番号+1)×30を返す。
            return (getHomonkaigoTeikyoTime().getSelectedIndex() + 1) * 30;
        }
        return 0;
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
                    ACDateUtilities.addMinute(
                            getHoumonKaigoBeginTime().getDate(),
                            getTeikyoTime()));
        }

    }

    /**
     * 開始時刻入力用のコンボを返します。
     * @return 開始時刻入力用のコンボ
     */
   public ACComboBox getBeginTimeCombo() {
       // ※開始時刻入力用のコンボを返す。
       // 関数の返り値として開始時間コンボを返す。
        return getHoumonKaigoBeginTime();
    }
   
   

   /**
    * 終了時刻入力用のコンボを返します。
    * @return 終了時刻入力用のコンボ
    */
    public ACComboBox getEndTimeCombo() {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return getHoumonKaigoEndTime();
    }
}
