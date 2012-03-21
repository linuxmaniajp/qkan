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
 * プログラム 介護予防短期入所療養介護（認知症疾患型） (QO004141)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 介護予防短期入所療養介護（認知症疾患型）(QO004141)
 */
@SuppressWarnings("serial")
public class QO004_12613_201204 extends QO004_12613_201204Event {
    /**
     * コンストラクタです。
     */
    public QO004_12613_201204() {
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
        // 「認知症疾患型」が選択された場合
        int facilityType = getFacilitiesDivision().getSelectedIndex();
        if (facilityType == FACILITY_TYPE_NINCHISHO) {
            setState_FACILITY_TYPE_NORMAL();
            // 状態ID：FACILITY_TYPE_NORMAL
        } else if (facilityType == FACILITY_TYPE_UNIT) {
            // 「ユニット型」が選択された場合
            setState_FACILITY_TYPE_UNIT();
            // 状態ID：FACILITY_TYPE_UNIT
        } else {
            // 「経過型」が選択された場合
            setState_FACILITY_TYPE_PASSAGE();
        }
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QO004_12613_201204.class.getName(),
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
        // ラジオの値を初期化する
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
                case 5:
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
        return true;
    }

    /**
     * 「パネル状態制御」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void stateManager(boolean state) throws Exception {
        // ※パネル状態制御
        // ※パネル状態制御
        if (state) {
            // 引数としてtrueが渡された場合
            // 状態ID：SET_PANEL_TRUE
            setState_SET_PANEL_TRUE();

            // 「認知症疾患型」が選択された場合
            int facilityType = getFacilitiesDivision().getSelectedIndex();
            if (facilityType == FACILITY_TYPE_NINCHISHO) {
                setState_FACILITY_TYPE_NORMAL();
                // 状態ID：FACILITY_TYPE_NORMAL
            } else if (facilityType == FACILITY_TYPE_UNIT) {
                // 「ユニット型」が選択された場合
                setState_FACILITY_TYPE_UNIT();
                // 状態ID：FACILITY_TYPE_UNIT
            } else {
                // 「経過型」が選択された場合
                setState_FACILITY_TYPE_PASSAGE();
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
        QkanCommon.removeDisabledBindPath(getMainGroup(), map);
    }

}
