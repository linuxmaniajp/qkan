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
 * 作成日: 2006/02/07  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 自費・調整画面 (QS001029)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.util.Map;

import jp.nichicom.ac.component.event.ACFollowContainerFormatEventListener;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.component.event.VRFormatEvent;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 自費・調整画面(QS001029)
 */
@SuppressWarnings("serial")
public class QS001006 extends QS001006Event {
    /**
     * コンストラクタです。
     */
    public QS001006() {
    }

    // コンポーネントイベント

    /**
     * 「自費/調整変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void serviceIndependenceActionPerformed(ActionEvent e)
            throws Exception {
        // ■自費/調整の変更処理
        // 「自費(serviceIndependence)」の値をチェックする。
        if (getServiceIndependence().isSelected()) {
            // チェックが付いている場合
            // 「調整額」に「単位数」の値を設定する。
            getServiceAdjustUnit().setText(getServiceUnit().getText());
            //「調整後単位」に0を設定する。
            getServiceResultUnit().setText("0");
            setState_EXPENCE();
            // 「調整額」を正常色に変える。
            getAdjustUnitBackgroundChanger().changeValidContainer();
        } else {
            // チェックが外れている場合
            // 何もしない(値の変更は行わない)。
            setState_ADJUST();
        }
    }

    /**
     * 「調整結果判定」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return int
     */
    public int getAdjustResult() {
        int adj = ACCastUtilities.toInt(getServiceAdjustUnit().getText(), -1);
        if (adj >= 0) {
            // 「調整額」を入力している場合
            int unit = ACCastUtilities.toInt(getServiceUnit().getText(), 0);
            // 「単位数」と「調整額」の値をチェックする。
            if (unit < adj) {
                // (単位数) < (調整額)の場合
                // 1を返す。
                return 1;
            }
            if (unit > adj) {
                // (単位数) > (調整額)の場合
                // -1を返す。
                return -1;
            }
            // 0を返す。
            return 0;
        }
        // 調整額を入力していない場合
        // -2を返す。
        return -2;
    }

    /**
     * 「調整額変更時チェック」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void serviceAdjustUnitFocusLost(FocusEvent e) throws Exception {
        // ■調整額変更時の入力チェック、及び状態設定
        // ※入力チェック

        // 「単位数」と「調整額」の値をチェックする。
        switch (getAdjustResult()) {
        case 1:
        // (単位数) < (調整額)の場合
        case -2:
            // (調整額)が未入力の場合
            // 調整額をエラー色に変える。
            getAdjustUnitBackgroundChanger().changeInvalidContainer();
            // 処理を抜ける。
            return;
        case -1:
            // (単位数) > (調整額)の場合
            // 「自費」のチェックを外す。
            getServiceIndependence().setSelected(false);
            // 処理を継続する。
            break;
        case 0:
            // (単位数) = (調整額)の場合
            // 「自費」のチェックを付ける。
            getServiceIndependence().setSelected(true);
            // 処理を継続する。
            break;
        }
        getServiceResultUnit().setText(
                ACCastUtilities.toString(ACCastUtilities.toInt(getServiceUnit()
                        .getText(), 0)
                        - ACCastUtilities.toInt(getServiceAdjustUnit()
                                .getText(), -1)));
        // 調整額を正常色に変える。
        getAdjustUnitBackgroundChanger().changeValidContainer();

        // 自費/調整変更時の状態設定を行う。
        setExpenceState();
    }

    /**
     * 「決定処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void submitActionPerformed(ActionEvent e) throws Exception {
        // ■調整決定処理

        switch (getAdjustResult()) {
        // 「単位数」と「調整額」の値をチェックする。
        case 1:
            // (単位数) < (調整額)の場合
            getAdjustUnitBackgroundChanger().changeInvalidContainer();
            // 内部変数unitValueを生成し、単位数を設定する。
            String unitValue = "単位数("
                    + ACCastUtilities.toString(ACCastUtilities.toInt(
                            getServiceUnit().getText(), 0)) + ")";
            // 内部変数choseiValueを生成し、調整額を設定する。
            String choseiValue = "利用者負担単位数("
                    + ACCastUtilities.toString(ACCastUtilities.toInt(
                            getServiceAdjustUnit().getText(), -1)) + ")";
            // エラーメッセージを表示する。ID = ERROR_OF_LESSER_DATE_RELATION
            QkanMessageList.getInstance().ERROR_OF_LESSER_DATE_RELATION("",
                    unitValue, choseiValue);
            // serviceAdjustUnitにフォーカスを当てる。
            getServiceAdjustUnit().requestFocus();
            // 処理を抜ける。
            return;
        case -2:
            // 未入力の場合
            // エラーメッセージを表示する。ID = QS001_ERROR_OF_BLANK_ADJUST_UNIT
            QkanMessageList.getInstance().QS001_ERROR_OF_BLANK_ADJUST_UNIT();
            // serviceAdjustUnitにフォーカスを当てる。
            getServiceAdjustUnit().requestFocus();
            // 処理を抜ける。
            return;
        case -1:
            // (単位数) > (調整額)の場合
            // 「自費(adjust)」のチェックを外す。
            getServiceIndependence().setSelected(false);
            // 処理を継続する。
            break;
        case 0:
            // (単位数) = (調整額)の場合
            // 「自費(adjust)」のチェックを付ける。
            getServiceIndependence().setSelected(true);
            // 処理を継続する。
            break;
        }

        // 当ダイアログ呼び出し元に、「調整額」「自費フラグ」を返し、ダイアログを閉じる。
        getContents().setSource(getValues());
        getContents().applySource();
        setApplied(true);
        dispose();
    }

    /**
     * 「キャンセル」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void closeActionPerformed(ActionEvent e) throws Exception {
        // ■調整キャンセル処理
        // 当ダイアログ呼び出し元に、「調整額」「自費フラグ」は返さず、ダイアログを閉じる。
        dispose();
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001006.class.getName(), param));
    }

    // 内部関数

    /**
     * 「初期設定」に関する処理を行ないます。
     * 
     * @param serviceData VRMap
     * @param serviceMaster VRMap
     * @param provider VRMap
     * @param managementTotal int
     * @throws Exception 処理例外
     * @return boolean
     */
    public boolean showModal(VRMap serviceData, VRMap serviceMaster,
            VRMap provider, int managementTotal) throws Exception {
        // ■画面展開時の初期設定
        setAdjustUnitBackgroundChanger(new ACFollowContainerFormatEventListener());
        getAdjustUnitBackgroundChanger().formatValid(
                new VRFormatEvent(getServiceAdjustUnit(), null, null));

        setValues(serviceData);
        // ※渡り値の設定
        // 渡りパラメータを元に、下記の値を設定する。
        // 日付
        // 開始時刻
        // 終了時刻
        // サービス名称
        // 単位数
        // 調整額
        getContents().setSource(serviceData);
        getContents().bindSource();
        getServiceUnit().setText(ACCastUtilities.toString(managementTotal));
        getServiceDate().setDate(
                ACCastUtilities.toDate(VRBindPathParser.get("SERVICE_DATE",
                        serviceData)));
        if(ACTextUtilities.isNullText(getServiceAdjustUnit().getText())){
            getServiceAdjustUnit().setText("0");
        }

        // ※値の計算
        // 「調整後単位数」に (単位数) - (調整額) を設定する。
        // ※状態設定
        // 初期状態の設定を行う。
        setState_INIT_STATE();

        // 事業所名称 providerNames
        if (provider != null) {
            getProviderNames().setText(
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "PROVIDER_NAME", provider)));
        }
        Object obj;
        // サービス名称 serviceName
        obj = serviceMaster.get(VRBindPathParser.get(
                "SYSTEM_SERVICE_KIND_DETAIL", serviceData));
        if (obj instanceof Map) {
            getServiceName().setText(
                    ACCastUtilities.toString(((Map) obj).get("SERVICE_ABBREVIATION"),
                            ""));
        }

        int reguration = ACCastUtilities.toInt(serviceData
                .getData("REGULATION_RATE"), 0);
        
        // 「単位数」と「調整額」の値をチェックする。
        if (managementTotal > reguration) {
            // (単位数) > (調整額)の場合
            // 「自費(adjust)」のチェックを外す。
            getServiceIndependence().setSelected(false);
            getServiceResultUnit().setText(
                    ACCastUtilities.toString(managementTotal - reguration));
        } else {
            // (単位数) = (調整額)の場合
            // 「自費(adjust)」のチェックを付ける。
            getServiceIndependence().setSelected(true);
            getServiceResultUnit().setText("0");
        }
        setExpenceState();

        // ※ウィンドウタイトルの設定
        // 業務情報レコードを取得する。
        setAffairTitle("QS001006");
        // ウィンドウタイトルに、取得レコードのKEY : WINDOW_TITLEのVALUEを設定する。

        pack();
        setVisible(true);
        return getApplied();
    }

    /**
     * 「自費/調整変更時の状態設定」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void setExpenceState() throws Exception {
        // ■自費/調整変更時の状態設定
        // 「単位数」と「調整額」の値をチェックする。
        if (getAdjustResult() == 0) {
            // 等しい場合
            // 自費用の状態設定を行う。
            setState_EXPENCE();
        } else {
            // 等しくない場合
            // 調整用の状態設定を行う。
            setState_ADJUST();
        }
    }
}
