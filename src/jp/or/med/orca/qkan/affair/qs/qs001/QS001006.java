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
 * 作成日: 2006/01/12  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン訪問看護（医療） (001)
 * プログラム サービスパターン訪問看護（医療） (QS001006)
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
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン訪問看護（医療）(QS001006)
 */
public class QS001006 extends QS001006Event {
    /**
     * コンストラクタです。
     */
    public QS001006() {
    }

    // コンポーネントイベント

    /**
     * 「基本療養費区分」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKangoIryoBasicChargeDivisionActionPerformed(
            ActionEvent e) throws Exception {
        // ※訪問看護職員区分、難病等複数回数訪問加算、延長時間加算の状態設定
        // 「基本療養費区分」の値をチェックする。
        switch (getHoumonKangoIryoBasicChargeDivision().getSelectedIndex()) {
        case 1:
            // 「基本療養費I」の場合
            // 「基本療養費I」用の状態を設定する。
            setState_IRYO_BASIC_CHARGE1_SELECTED();
            break;
        case 2:
            // 「基本療養費II」の場合
            // 「基本療養費II」用の状態を設定する。
            setState_IRYO_BASIC_CHARGE2_SELECTED();
            break;
        }
        checkGuidanceState();

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
        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ※コンボアイテムの設定
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();
        // ※選択項目の初期設定
        // 基本療養費区分(houmonKangoIryoBasicChargeDivision)の「基本療養費I」を選択する。
        getHoumonKangoIryoBasicChargeDivision().setSelectedIndex(1);
        // 訪問看護職員区分(houmonKangoIryoClass)の「正看等」を選択する。
        getHoumonKangoIryoClass().setSelectedIndex(1);
        // 難病等複数回数訪問加算(houmonKangoIryoIntractableDiseaseRadio)の「なし」を選択する。
        getHoumonKangoIryoIntractableDiseaseRadio().setSelectedIndex(1);
        // 共同指導加算(houmonKangoIryoGuidanceRadio)の「なし」を選択する。
        getHoumonKangoIryoGuidanceRadio().setSelectedIndex(1);
        // 24時間加算(houmonKangoIryo24HoureRadio)の「なし」を選択する。
        getHoumonKangoIryo24HoureRadio().setSelectedIndex(1);
        // 重傷者加算(houmonKangoIryoSeriousIllnessRadio)の「なし」を選択する。
        getHoumonKangoIryoSeriousIllnessRadio().setSelectedIndex(1);
        // 情報提供加算(houmonKangoIryoInfoRadio)の「なし」を選択する。
        getHoumonKangoIryoInfoRadio().setSelectedIndex(1);
        // ターミナルケア加算(houmonKangoIryoTerminalRadio)の「なし」を選択する。
        getHoumonKangoIryoTerminalRadio().setSelectedIndex(1);
        // 緊急訪問看護加算(houmonKangoIryoEmergencyVisitNursingRadio)の「なし」を選択する。
        getHoumonKangoIryoEmergencyVisitNursingRadio().setSelectedIndex(1);
        //延長時間・テキスト(houmonKangoIryoExtensionTimeText)を空欄にする。
        getHoumonKangoIryoExtensionTimeText().setText("");
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
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        if ( (!getHoumonKangoIryoBeginTime().isValidDate())
                || (!getHoumonKangoIryoEndTime().isValidDate())) {
            // 開始時刻コンボ(houmonKangoIryoBeginTime)と終了時刻コンボ(houmonKangoIryoEndTime)のいずれかが空欄か不正の場合
            // 時刻の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
            // nullを返す。
            return null;
        }
        if (!getHoumonKangoIryoBasicChargeDivision().isSelected()) {
            // 基本療養費区分(houmonKangoIryoBasicChargeDivision)が未選択の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
        if (getHoumonKangoIryoBasicChargeDivision().getSelectedIndex() == 1) {
            // 基本療養費区分(houmonKangoIryoBasicChargeDivision)に「基本療養費I」が選択されている場合
            if (!getHoumonKangoIryoClass().isSelected()) {
                // 訪問看護職員区分(houmonKangoIryoClass)が未選択の場合
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
        }
        if (getHoumonKangoIryoExtensionTimeText().isEnabled()
                && (5 < ACCastUtilities.toInt(
                        getHoumonKangoIryoExtensionTimeText().getText(), 0))) {
            // 延長時間・テキスト(houmonKangoIryoExtensionTimeText)の値が8以上の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_RANGE_OVER
            QkanMessageList.getInstance().QS001_ERROR_OF_RANGE_OVER("延長時間","5時間まで");
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
        switch (getHoumonKangoIryoBasicChargeDivision().getSelectedIndex()) {
        case 1:
            // 基本療養費区分(houmonKangoIryoBasicChargeDivision)に「基本療養費I」が選択されている場合
            // 返却用レコードから、延長時間・テキスト(houmonKangoIryoExtensionTimeText)のbindPathを除去する。
            data.remove(getHoumonKangoIryoExtensionTimeText().getBindPath());
            break;
        case 2: {
            // 基本療養費区分(houmonKangoIryoBasicChargeDivision)に「基本療養費II」が未選択の場合
            // 返却用レコードから、訪問看護職員区分(houmonKangoIryoClass)のbindPathを除去する。
            // 返却用レコードから、難病等複数回数訪問加算(houmonKangoIryoIntractableDiseaseRadio)のbindPathを除去する。
            data.remove(getHoumonKangoIryoClass().getBindPath());
            data.remove(getHoumonKangoIryoIntractableDiseaseRadio()
                    .getBindPath());

            String val = getHoumonKangoIryoExtensionTimeText().getText();
            if (ACTextUtilities.isNullText(val) || "0".equals(val)
                    || "00".equals(val)) {
                // 延長時間・テキスト(houmonKangoIryoExtensionTimeText)の値が空欄か0の場合
                // 返却用レコードから、延長時間・テキスト(houmonKangoIryoExtensionTimeText)のbindPathを除去する。
                data
                        .remove(getHoumonKangoIryoExtensionTimeText()
                                .getBindPath());
            }
            break;
        }
        }
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

    public ACComboBox getBeginTimeCombo() throws Exception {
        return getHoumonKangoIryoBeginTime();
    }

    public ACComboBox getEndTimeCombo() throws Exception {
        return getHoumonKangoIryoEndTime();
    }

    /**
     * 「職員区分変更」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKangoIryoClassSelectionChanged(ListSelectionEvent e) throws Exception {
        checkGuidanceState();
    }

    /**
     * 「共同指導加算の有効状態確認」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     *
     */
    public void checkGuidanceState() throws Exception {
//        // ※共同指導加算の有効状態をチェックする。
//        if (getHoumonKangoIryoBasicChargeDivision1().isSelected()
//                && getHoumonKangoIryoClass2().isSelected()) {
//            // 基本療養費Iと准看が選択されている場合
//            // 共同指導加算を無効とする。
//            setState_INVALID_GUIDANCE();
//        } else {
//            // それ以外
//            // 共同指導加算を有効とする。
//            setState_VALID_GUIDANCE();
//        }
    }


}
