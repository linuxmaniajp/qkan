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
 * 作成日: 2006/01/10  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問看護（介護) (QS001005)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン訪問看護（介護)(QS001005)
 */
public class QS001005 extends QS001005Event {
    /**
     * コンストラクタです。
     */
    public QS001005() {
    }

    // コンポーネントイベント

    /**
     * 「訪問看護指導書の加算の設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKangoKaigoFacilityTypeActionPerformed(ActionEvent e)
            throws Exception {
        // ※「訪問看護施設種別」に応じて、「理学療法士又は作業療法士」を設定
        // 「訪問看護施設種別」をチェックの値をチェックする。
        switch (getHoumonKangoKaigoClass().getSelectedIndex()) {
        case 1:
            // 「指定訪問看護ステーション」の場合
            // 「理学療法士又は作業療法士」を有効にする。
            setState_VALID_HOMON_KANGO_PTOT();
            break;
        case 2:
            // 「病院又は診療所」の場合
            // 「理学療法士又は作業療法士」を無効にする。
            setState_INVALID_HOMON_KANGO_PTOT();
            break;
        }
    }

    /**
     * 「開始時間変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKangoKaigoBeginTimeActionPerformed(ActionEvent e)
            throws Exception {
        // ※開始時間変更時、終了時間も変更
        // 終了時間を「開始時間 + 訪問看護時間(分)」に設定する。
        checkEndTime();

    }

    /**
     * 「時間帯変更時」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKangoKaigoTimeZoneActionPerformed(ActionEvent e)
            throws Exception {
        // ※時間帯変更時、開始時間も変更
        // // 時間退避用の変数kangoTimeに、訪問看護時間区分から取得した時間を設定する。
        // int kaigoTime = getKaigoTime();

        // 訪問看護介護時間帯(houmonKaigoTimeZone)の値をチェックする。
        switch (getHoumonKangoKaigoTimeZone().getSelectedIndex()) {
        case 1:
            // 通常の場合
            // 開始時間を9:00にする。
            getHoumonKangoKaigoBeginTime().setText("9:00");
            break;
        case 2:
            // 早朝の場合
            // 開始時間を6:00にする。
            getHoumonKangoKaigoBeginTime().setText("6:00");
            break;
        case 3:
            // 夜間の場合
            // 開始時間を18:00にする。
            getHoumonKangoKaigoBeginTime().setText("18:00");
            break;
        case 4:
            // 深夜の場合
            // 開始時間を22:00にする。
            getHoumonKangoKaigoBeginTime().setText("22:00");
            break;
        }
        // 終了時間を「開始時間 + 訪問看護時間(分)」に設定する。
        checkEndTime();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        ACFrame.debugStart(new ACAffairInfo(QS001005.class.getName()));
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
        // 訪問看護職員区分(houmonKangoKaigoClass)の「正看」を選択する。
        getHoumonKangoKaigoClass().setSelectedIndex(1);
        // 訪問看護時間区分(houmonKangoKaigoTime)の「30分以上、1時間未満」を選択する。
        getHoumonKangoKaigoTime().setSelectedIndex(2);
        // 訪問看護介護時間帯(houmonKangoKaigoTimeZone)の「通常」を選択する。
        getHoumonKangoKaigoTimeZone().setSelectedIndex(1);
//        // 理学療法士、作業療法士等による訪問看護指導書の加算(houmonKangoKaigoPTAndOTRadio)の「なし」を選択する。
//        getHoumonKangoKaigoPTAndOTRadio().setSelectedIndex(1);
        // 緊急時訪問看護加算(houmonKangoKaigoUrgentTimeRadio)の「なし」を選択する。
        getHoumonKangoKaigoUrgentTimeRadio().setSelectedIndex(1);
        // 特別管理加算(houmonKangoKaigoSpecialManageRadio)の「なし」を選択する。
        getHoumonKangoKaigoSpecialManageRadio().setSelectedIndex(1);
        // ターミナルケア加算(houmonKangoKaigoTerminalRadio)の「なし」を選択する。
        getHoumonKangoKaigoTerminalRadio().setSelectedIndex(1);

    }

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @param provider VRMap
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数
        if (provider != null) {
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            Object obj;
            // 訪問看護施設種別
            obj = VRBindPathParser.get("1130101", provider);
            if (obj != null) {
                getHoumonKangoKaigoFacilityType().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            //緊急時訪問看護加算
            obj = VRBindPathParser.get("1130104", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 1) {
                    // なし
                    setState_INVALID_URGENT_TIME_RADIO();
                } else {
                    // あり
                    setState_VALID_URGENT_TIME_RADIO();
                }
            }
            // 特別管理体制
            obj = VRBindPathParser.get("1130102", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 1) {
                    // なし
                    setState_INVALID_SPECIAL_MANAGE_RADIO();
                } else {
                    // あり
                    setState_VALID_SPECIAL_MANAGE_RADIO();
                }
            }

        }
    }

    /**
     * 「訪問看護時間の取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public int getKaigoTime() throws Exception {
        // ※訪問看護時間区分より、時間を取得
        // 「訪問看護時間区分(houmonKangoKaigoTime)」の値をチェックする。
        switch (getHoumonKangoKaigoTime().getSelectedIndex()) {
        case 1:
            // 30分未満の場合
            // 戻り値として30を返す。
            return 30;
        case 2:
            // 30分以上、1時間未満の場合
            // 戻り値として60を返す。
            return 60;
        case 3:
            // 1時間以上、1時間半未満の場合
            // 戻り値として90を返す。
            return 90;
        }
        return 0;
    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return VRMap
     */
    public VRMap getValidData() throws Exception {

        if (ACTextUtilities.isNullText(getHoumonKangoKaigoBeginTime().getText())||
                ACTextUtilities.isNullText(getHoumonKangoKaigoEndTime().getText())||
                (!getHoumonKangoKaigoBeginTime().isValidDate())
                || (!getHoumonKangoKaigoEndTime().isValidDate())) {
            // 開始時刻コンボ(houmonKangoKaigoBeginTime)と終了時刻コンボ(houmonKangoKaigoEndTime)のいずれかが空欄か不正の場合
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
        if (!getHoumonKangoKaigoSpecialManageRadio().isEnabled()) {
            // 特別管理体制(houmonKangoKaigoSpecialManageRadio)が無効の場合
            // 返却用レコードから、特別管理体制(houmonKangoKaigoSpecialManageRadio)のbindPathを除去する。
            data.remove(getHoumonKangoKaigoSpecialManageRadio().getBindPath());
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
     * 「訪問看護時間区分変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKangoKaigoTimeActionPerformed(ActionEvent e)
            throws Exception {
        // ※開始時間変更時、終了時間も変更
        // 終了時間を「開始時間 + 訪問看護時間(分)」に設定する。
        checkEndTime();
    }

    /**
     * 「終了時間のチェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkEndTime() throws Exception {
        // ※開始時間変更時、終了時間も変更
        if (getHoumonKangoKaigoBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getHoumonKangoKaigoBeginTime()
                        .getText()))) {
            // 開始時間コンボ(houmonKangoKaigoBeginTime)の値が空欄および不正でない場合
            // 時間退避用の変数kangoTimeに、訪問看護時間区分から取得した時間を設定する。
            int kaigoTime = getKaigoTime();

            // 終了時間を「開始時間 + kangoTime(分)」に設定する。
            getHoumonKangoKaigoEndTime().setDate(
                    ACDateUtilities
                            .addMinute(
                                    getHoumonKangoKaigoBeginTime().getDate(),
                                    kaigoTime));
        }
    }

    /**
     * 開始時刻入力用のコンボを返します。
     * @return 開始時刻入力用のコンボ
     */
   public ACComboBox getBeginTimeCombo() {
       // ※開始時刻入力用のコンボを返す。
       // 関数の返り値として開始時間コンボを返す。
        return getHoumonKangoKaigoBeginTime();
    }

   /**
    * 終了時刻入力用のコンボを返します。
    * @return 終了時刻入力用のコンボ
    */
    public ACComboBox getEndTimeCombo() {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return getHoumonKangoKaigoEndTime();
    }

}
