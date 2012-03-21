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
 * 開発者: 上司　和善
 * 作成日: 2006/02/21  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 短期入所生活介護 (QO004109)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo004;

import java.awt.event.FocusEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 短期入所生活介護(QO004_12111_201204)
 */
@SuppressWarnings("serial")
public class QO004_12111_201204 extends QO004_12111_201204Event {
    /**
     * コンストラクタです。
     */
    public QO004_12111_201204() {
    }

    // コンポーネントイベント

    /**
     * 「画面状態設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void facilitiesDivisionSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 画面状態設定
        setState();

    }

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

        // ラジオの初期値を選択する
        QkanCommon.selectFirstRadioItem(getThis());

        // 食費・居住費の取得と表示
        VRMap param = new VRHashMap();
        VRBindPathParser.set("SYSTEM_DATE", param, QkanSystemInformation
                .getInstance().getSystemDate());
        String strSql = getSQL_GET_RESIDENCE_FOOD(param);
        VRList residenceFood = getDBManager().executeQuery(strSql);

        if (residenceFood != null) {
            for (int i = 0; i < residenceFood.size(); i++) {
                VRMap temp = (VRMap) residenceFood.get(i);
                int id = ACCastUtilities.toInt(VRBindPathParser.get(
                        "RESIDENCE_FOOD_COST_ID", temp));
                String cost = ACCastUtilities.toString(VRBindPathParser.get(
                        "RESIDENCE_FOOD_COST", temp));

                switch (id) {
                // 食費
                case 1:
                    getDinnerTotal().setText(cost);
                    break;
                // ユニット個室
                case 2:
                    getUnitRoom().setText(cost);
                    break;
                // ユニット準個室
                case 3:
                    getUnitSemiRoom().setText(cost);
                    break;
                // 従来型個室
                case 4:
                    getNormalRoom().setText(cost);
                    break;
                // 多床室
                case 6:
                    getTasyouRoom().setText(cost);
                    break;
                }

            }
        }

    }

    /**
     * 「入力チェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean isValidInput() throws Exception {
        // ※入力チェック
        // エラーメッセージ文言格納用に errMsg　を作成する。
        String errMsg = null;

        // 下記のラジオグループに対して選択チェックを行う。未選択だった場合は errMsg にメッセージを格納する。
        // 空床型対応
        // サービス提供体制強化加算
        if (getServiceAddProvisionStructuralRadioGroup().getSelectedIndex() > 1) {
            // サービス提供体制強化加算（空床型）でなし以外が選択されている場合
            if (getServiceAddProvisionStructuralKusyoRadioGroup().isEnabled()
                    && getServiceAddProvisionStructuralKusyoRadioGroup()
                            .getSelectedIndex() > 1) {
                // エラーメッセージ
                if (QkanMessageList.getInstance()
                        .QO004_WARNING_OF_DOUBLE_CHECK(
                                "サービス提供体制強化加算（単独型・併設型／空床型）の両方") == ACMessageBox.RESULT_CANCEL) {
                    return false;
                }
            }
        }

        // 下記のテキストフィールドに対して入力チェックを行う。未入力だった場合は errMsg にメッセージを格納する。
        // ・reduceRate（割引率テキスト）※ errMsg = 割引率
        if (ACTextUtilities.isNullText(getReduceRate().getText())) {
            errMsg = "割引率";
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
            getReduceRate().requestFocus();
            return false;
        }

        // 割引率の値をチェックする。
        int reduceRate = ACCastUtilities.toInt(getReduceRate().getText());
        if (reduceRate > 100) {
            // 100を超える値が入力されていた場合
            QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
            // エラーが発生したインスタンスにフォーカスを当てる。
            getReduceRate().requestFocus();
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
        if (state) {
            // 引数としてtrueが渡された場合
            // 状態ID：SET_PANEL_TRUE
            setState_SET_PANEL_TRUE();

            setState();

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
        // パネルデータ取得

        getMainGroup().setSource(map);
        getMainGroup().applySource();

        // 無効状態のコントロールのデータを削除する。
        removeInvalidData(map);

    }

    /**
     * 「無効データ削除」に関する処理を行ないます。
     * 
     * @param map VRMap
     * @throws Exception 処理例外
     */
    public void removeInvalidData(VRMap map) throws Exception {
        // 無効データ削除
        QkanCommon.removeDisabledBindPath(getMainGroup(), map);

    }

    /**
     * 「状態制御」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    public void setState() throws Exception {

        // 画面の状態を制御する。
        setStateByFacilitiesDivision();

    }

    /**
     * 「施設区分による状態制御」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    public void setStateByFacilitiesDivision() throws Exception {

        // 施設区分の値をチェックする。
        if (getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_NORMAL_TANDOKU
                || getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_NORMAL_HEISETSU) {
            // 施設区分の「単独型」、「併設型」が選択されている場合
            setState_FACILITY_TYPE_NORMAL();
        } else {
            // 施設区分の「単独型」、「併設型」以外が選択されている場合
            setState_FACILITY_TYPE_UNIT();
        }

        // 空床型対応
        switch (getFacilitiesDivision().getSelectedIndex()) {
        case 1: // 単独型
        case 3: // 単独型ユニット型
            setState_INVALID_SERVICE_ADD_KUSYO();
            break;
        case 2: // 空床型
        case 4: // ユニット型空床型
            setState_VALID_SERVICE_ADD_KUSYO();
            break;
        }

    }

}
