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
 * 開発者: 廣瀬 一海
 * 作成日: 2006/05/02  日本コンピューター株式会社 廣瀬 一海 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 介護予防特定施設入所者介護 (QO004143)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 介護予防特定施設入所者介護(QO004143)
 */
@SuppressWarnings("serial")
public class QO004_13511_201504 extends QO004_13511_201504Event {
    /**
     * コンストラクタです。
     */
    public QO004_13511_201504() {
    }

    // コンポーネントイベント

    /**
     * 「画面状態設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void staffAssignmentDivisionSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 画面状態設定
        // 人員配置区分の値を確認
        // 「一般型」が選択された場合
        if (getStaffAssignmentDivision().getSelectedIndex() == STAFF_ASSIGNMENT_NORMAL) {
            setState_STAFF_ASSIGNMENT_TYPE_NORMAL();
            // 状態ID：FACILITY_TYPE_NORMAL
        } else {
            // 「一般型」以外が選択された場合
            setState_STAFF_ASSIGNMENT_TYPE_OUTSIDE_SERVICE();
            // 状態ID：FACILITY_TYPE_OUTSIDE_SERVICE
        }
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QO004_13511_201504.class.getName(),
                param));
    }

    // 内部関数

    /**
     * 「初期化」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void initialize() throws Exception {
        // ※初期化
        // ※初期値設定
        // 割引率テキストに初期値0を代入する。
        getReduceRate().setText("0");
        // ラジオの値を初期化する
        QkanCommon.selectFirstRadioItem(getThis());
    }

    /**
     * 「入力チェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean isValidInput() throws Exception {
        // ※入力チェック
        // エラーメッセージ文言格納用に errMsg を作成する。
        String errMsg = null;

        // 下記のテキストフィールドに対して入力チェックを行う。未入力だった場合は errMsg にメッセージを格納する。
        if (ACTextUtilities.isNullText(getReduceRate())) {
            // ・reduceRate（割引率テキスト）※ errMsg = 割引率
            errMsg = "割引率";
            // 未入力だった場合
            // エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT 引数 =
            // errMsg
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
            // エラーが発生したインスタンスにフォーカスを当てる。
            getReduceRate().requestFocus();
            // 処理を抜ける。（中断する）
            return false;
        }

        // 割引率の値をチェックする。
        // 割引率の値が100を超えている場合
        if (ACCastUtilities.toInt(getReduceRate().getText()) > 100) {
            // エラーメッセージを表示する。 ※メッセージID=QO004_ERROR_OF_REDUCT_RATE
            QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
            // エラーが発生したインスタンスにフォーカスを当てる。
            getReduceRate().requestFocus();
            // 処理を抜ける。（中断する）
            return false;
        }
        return true;
    }

    /**
     * 「パネル状態制御」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void stateManager(boolean state) throws Exception {
        // ※パネル状態制御
        // 引数としてtrueが渡された場合
        // 状態ID：SET_PANEL_TRUE
        if (state) {
            setState_SET_PANEL_TRUE();

            // 人員配置区分の値を確認
            // 「一般型」が選択された場合
            if (getStaffAssignmentDivision().getSelectedIndex() == STAFF_ASSIGNMENT_NORMAL) {
                setState_STAFF_ASSIGNMENT_TYPE_NORMAL();
                // 状態ID：FACILITY_TYPE_NORMAL
            } else {
                // 「一般型」以外が選択された場合
                setState_STAFF_ASSIGNMENT_TYPE_OUTSIDE_SERVICE();
                // 状態ID：FACILITY_TYPE_OUTSIDE_SERVICE
            }
        } else {
            // 引数としてfalseが渡された場合
            // 状態ID：SET_PANEL_FALSE
            setState_SET_PANEL_FALSE();
        }
    }

    /**
     * 「パネルデータ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void getDetails(VRMap map) throws Exception {
        // ※パネルデータ取得
        // 事業グループのソースとしてVRMap mapを設定する。
        setSource(map);

        // 画面上のデータを取得する。
        applySource();

        // 無効状態のコントロールのデータを削除する。
        removeInvalidData(map);

        // デバッグ用出力
        // System.out.println(map);

    }

    /**
     * 「無効データ削除」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void removeInvalidData(VRMap map) throws Exception {
        // ※無効データ削除
        // 以下のコントロールが無効状態の場合、以下のKEYをmapより削除する。
        // ・staffLack 削除KEY：1350103
        // ・functionTrainingGuidanceSystem 削除KEY：1350104
        QkanCommon.removeDisabledBindPath(getMainGroup(), map);

    }

}
