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
 * 開発者: 小笠　貴志
 * 作成日: 2006/01/10  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターンその他内容詳細 (QS001029)
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
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.bind.event.VRBindEvent;
import jp.nichicom.vr.bind.event.VRBindEventListener;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン主な日常生活上の活動(QS001027)
 */
public class QS001027 extends QS001027Event {
    /**
     * コンストラクタです。
     */
    public QS001027() {
    }

    // コンポーネントイベント

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        ACFrame.debugStart(new ACAffairInfo(QS001027.class.getName()));
    }

    // 内部関数

    /**
     * 「初期化」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void initialize() throws Exception {
        // ※画面展開時の初期設定
        getEtcContentDetailIList().setBindPathes(
                new String[] { "9020102", "9020103", "9020104", "9020105",
                        "9020106", "9020107", "9020108", "9020109", "9020110",
                        "9020111" });

        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ※コンボアイテムの設定
        // 自身(this)のモデルソースとしてcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();

    }

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数
    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return VRMap
     */
    public VRMap getValidData() throws Exception {
        if (ACTextUtilities.isNullText(getEtcContentDetailInput().getText())) {
            // 内容詳細テキスト(etcContentDetailInput)の入力内容が空の場合
            // 内容詳細に不備がある旨のメッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
        if ((!getEtcContentDetailBeginTime().isValidDate())
                || (!getEtcContentDetailEndTime().isValidDate())) {
            // 開始時刻コンボ(etcContentDetailBeginTime)と終了時刻コンボ(etcContentDetailEndTime)のいずれかが不正の場合
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
        if (ACTextUtilities
                .isNullText(getEtcContentDetailBeginTime().getText())) {
            // 開始時刻コンボ(etcContentDetailBeginTime)が空欄の場合
            // 返却用レコードから、開始時刻コンボ(etcContentDetailBeginTime)のbindPathを除去する。

            data.remove(getEtcContentDetailBeginTime().getBindPath());
        }
        if (ACTextUtilities.isNullText(getEtcContentDetailEndTime().getText())) {
            // 終了時刻コンボ(etcContentDetailEndTime)が空欄の場合
            // 返却用レコードから、終了時刻コンボ(etcContentDetailEndTime)のbindPathを除去する。
            data.remove(getEtcContentDetailEndTime().getBindPath());
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
        // falseを返す。
        return false;
    }

    /**
     * 開始時刻入力用のコンボを返します。
     * 
     * @return 開始時刻入力用のコンボ
     */
    public ACComboBox getBeginTimeCombo() {
        // ※開始時刻入力用のコンボを返す。
        // 関数の返り値として開始時間コンボを返す。
        return getEtcContentDetailBeginTime();
    }

    /**
     * 終了時刻入力用のコンボを返します。
     * 
     * @return 終了時刻入力用のコンボ
     */
    public ACComboBox getEndTimeCombo() {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return getEtcContentDetailEndTime();
    }

    /**
     * 「追加ボタンのクリック」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void etcContentInsertButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ※選択内容をリストに追加する。
        if (ACTextUtilities.isNullText(getEtcContentDetailInput().getText())) {
            // 選択内容が空欄の場合
            // 空欄エラーメッセージを表示して処理を終了する。
            QkanMessageList.getInstance().QS001_ERROR_OF_BLANK_TEXT();
            return;
        }
        // 選択内容をリストに追加する。
        getEtcContentDetailIList()
                .addItem(getEtcContentDetailInput().getText());
        // 追加ボタンの有効状態をチェックする。
        checkAddCondition();
        
        //選択内容テキストにフォーカスを移す。
        getEtcContentDetailInput().requestFocus();
    }

    /**
     * 「編集ボタンのクリック」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void etcContentFindButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ※選択内容でリストの選択項目を上書きする。
        if (ACTextUtilities.isNullText(getEtcContentDetailInput().getText())) {
            // 選択内容が空欄の場合
            // 空欄エラーメッセージを表示して処理を終了する。
            QkanMessageList.getInstance().QS001_ERROR_OF_BLANK_TEXT();
            return;
        }

        // 選択内容でリストの選択項目を上書きする。
        if (getEtcContentDetailIList().isSelected()) {
            VRBindSource src = getEtcContentDetailIList()
                    .getModelAtBindSource();
            if (src != null) {
                src.setData(getEtcContentDetailIList().getSelectedIndex(),
                        getEtcContentDetailInput().getText());
            }
        }
        //選択内容テキストにフォーカスを移す。
        getEtcContentDetailInput().requestFocus();
    }

    /**
     * 「削除ボタンのクリック」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void etcContentDeleteButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ※リスト中の選択項目を削除する。
        // リスト中の選択項目を削除する。
        if (getEtcContentDetailIList().isSelected()) {
            int idx=getEtcContentDetailIList().getSelectedIndex();
            getEtcContentDetailIList().removeItemAt(idx);
            getEtcContentDetailIList().setSelectedIndexOnAfterDelete(idx);
            setState_VALID_ADD();
        }
    }

    /**
     * 「リストの選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void etcContentDetailIListSelectionChanged(ListSelectionEvent e)
            throws Exception {
        if (e.getValueIsAdjusting()) {
            return;
        }
        // ※リストの選択状況に応じてボタンの有効無効を変更する。
        if (getEtcContentDetailIList().isSelected()) {
            // リストを選択している場合
            getEtcContentDetailInput().setText(ACCastUtilities.toString(getEtcContentDetailIList().getSelectedValue()));
            // 編集有効状態にする。
            setState_VALID_EDIT();
        } else {
            // リストを選択していない場合
            // 編集無効状態にする。
            setState_INVALID_EDIT();
        }
    }

    /**
     * 「リストへのバインド」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void etcContentDetailIListBindSource(VRBindEvent e)
            throws Exception {
        // ※追加ボタンの有効状態をチェックする。
        // 追加ボタンの有効状態をチェックする。
        checkAddCondition();
    }

    /**
     * 「追加ボタンの有効状態チェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkAddCondition() throws Exception {
        // ※追加ボタンの有効状態をチェックする。
        if (getEtcContentDetailIList().getItemCount() < 10) {
            // リストに10件以上項目が存在する場合
            // 追加無効状態にする。
            setState_VALID_ADD();
        } else {
            // リストの項目が10件以上ではない場合
            // 追加有効状態にする。
            setState_INVALID_ADD();
        }
    }

}
