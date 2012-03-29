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
 * プログラム サービスパターン訪問看護（介護) (QS001_11311_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACRadioButtonItem;
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
 * サービスパターン訪問看護（介護)(QS001_11311_201204)
 */
@SuppressWarnings("serial")
public class QS001_11311_201204 extends QS001_11311_201204Event {
    /**
     * コンストラクタです。
     */
    public QS001_11311_201204() {
        // 必須の事業所設定項目
        putCheckProviderBindPath("同一建物居住者へのサービス提供", "5");
        
        // 値を転記する事業所設定項目
        putImportProviderBindPath("施設等の区分", "1130101", "1130103");
        putImportProviderBindPath("特別管理加算", "1130102", "1130116");

        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("緊急時訪問看護加算", "1130104", "1130108");
        putRestrictProviderBindPath("緊急時訪問看護加算", "1130104", "1130122");
        putRestrictProviderBindPath("特別管理体制", "1130102", "1130116");
    }

    // コンポーネントイベント

    /**
     * 「職員区分選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKangoKaigoClassSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 画面状態制御処理を呼び出す。
        checkState();

    }

    /**
     * 「時間区分選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKangoKaigoTimeSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 時間区分選択
        // 終了時間計算処理を呼び出す。
        checkEndTime();
        // 画面状態制御処理を呼び出す。
        checkState();

    }

    /**
     * 「開始時間変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKangoKaigoBeginTimeActionPerformed(ActionEvent e)
            throws Exception {
        // 開始時間変更
        // 終了時間計算処理を呼び出す。
        checkEndTime();

    }

    /**
     * 「時間帯変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKangoKaigoTimeZoneSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 時間帯変更
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
        // 終了時間計算処理を呼び出す。
        checkEndTime();

    }

    /**
     * 「施設区分選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKangoKaigoFacilityTypeSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 画面状態制御処理を呼び出す。
        checkState();
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_11311_201204.class.getName(),
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
        QkanCommon.selectFirstRadioItem(this);
        // ※準備
        // 初期選択設定用のレコード defaultMap を生成する。
        VRMap defaultMap = new VRHashMap();
        // ※設定
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();
        // 初期選択
        getHoumonKangoKaigoTime().setSelectedIndex(3);

    }

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数
        // 選択事業所情報がnullでない場合
        if (provider != null) {
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = getImportData();

            // サービス提供体制加算は制御
            Object obj;
            obj = VRBindPathParser.get("1130108", provider);
            if (ACCastUtilities.toInt(obj, 0) >= 2) {
                VRBindPathParser.set("1130113", defaultMap, new Integer(2));
            }

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
        if (ACTextUtilities
                .isNullText(getHoumonKangoKaigoBeginTime().getText())
                || ACTextUtilities.isNullText(getHoumonKangoKaigoEndTime()
                        .getText())
                || (!getHoumonKangoKaigoBeginTime().isValidDate())
                || (!getHoumonKangoKaigoEndTime().isValidDate())) {
            // 開始時刻コンボ(houmonKangoKaigoBeginTime)と終了時刻コンボ(houmonKangoKaigoEndTime)のいずれかが空欄か不正の場合
            // 時刻の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
            // nullを返す。
            return null;
        }
        if (getHoumonKangoKaigoTime().isEnabled()
                && !getHoumonKangoKaigoTime().getSelectedButton().isEnabled()) {
            // 時間区分の有効な項目が選択されていない場合
            // 内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
        // 時間帯区分に不備があった場合
        if (getHoumonKangoKaigoTimeZone().isEnabled()
                && !getHoumonKangoKaigoTimeZone().getSelectedButton()
                        .isEnabled()) {
            // 内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }

        // 職員区分に不備があった場合
        if (!getHoumonKangoKaigoClass().getSelectedButton().isEnabled()) {
            // 内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
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
        // 　trueを返す。
        return true;
    }

    /**
     * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ※開始時刻入力用のコンボを返す。
        // 　関数の返り値として開始時間コンボを返す。
        return getHoumonKangoKaigoBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 　関数の返り値として終了時間コンボを返す。
        return getHoumonKangoKaigoEndTime();
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
                    ACDateUtilities.addMinute(getHoumonKangoKaigoBeginTime()
                            .getDate(), kaigoTime));
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
        case 1: // 20分未満
            return 20;
        case 2: // 30分未満の場合
            // 戻り値として30を返す。
            return 30;
        case 3:
            // 30分以上、1時間未満の場合
            // 戻り値として60を返す。
            return 60;
        case 4:
            // 1時間以上、1時間半未満の場合
            // 戻り値として90を返す。
            return 90;
        }
        return 0;
    }

    private boolean isEnabledAndSelected(ACRadioButtonItem item) {
        return item.isEnabled() && item.isSelected();
    }

    /**
     * 「画面状態制御」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * 
     */
    public void checkState() throws Exception {
        // ※画面状態制御処理

        // 施設区分
        int shisetsu = getHoumonKangoKaigoFacilityType().getSelectedIndex();
        switch (shisetsu) {
        case 1: // 訪問看護ステーション
            setState_TYPE_STATION();
            break;
        case 2: // 医療機関
            setState_TYPE_HOSPITAL();
            break;
        case 3: // 定期巡回
            setState_TYPE_TEIKIJUNKAI();
            
            // 日割りと提供日の連動
            if (getCrackOnDayCheck().isSelected()) {
                setState_DAY_CHECK_ON();
            } else {
                setState_DAY_CHECK_OFF();
            }
            break;
        }

        // 施設区分が「定期巡回」以外の場合
        if (shisetsu != 3) {

            // 職員区分による時間区分の制御
            if (isEnabledAndSelected(getHoumonKangoKaigoClass3())) {
                // 職員区分が「理学療法士」の場合
                setState_WORKER_IS_PTOT();
            } else {
                // 職員区分が「理学療法士」以外の場合
                setState_WORKER_IS_NOT_PTOT();
            }

            // 時間区分による2人目の時間の制御
            if (isEnabledAndSelected(getHoumonKangoKaigoTime1())
                    || isEnabledAndSelected(getHoumonKangoKaigoTime2())) {
                // 時間区分が「20分未満」もしくは「30分未満」である場合
                setState_INVALID_NUMBER_OF_PEOPLE_TIME();
            } else {
                if (isEnabledAndSelected(getHoumonKangoNumberOfPeople2())) {
                    // 訪問人数が2人である場合
                    setState_VALID_NUMBER_OF_PEOPLE_TIME();
                } else {
                    // 訪問人数が1人である場合
                    setState_INVALID_NUMBER_OF_PEOPLE_TIME();
                }

            }

            // 長時間訪問看護加算の制御
            if (isEnabledAndSelected(getHoumonKangoKaigoTime4())
                    && (isEnabledAndSelected(getSpecialManagementRadioItem2()) || isEnabledAndSelected(getSpecialManagementRadioItem3()))) {
                // 時間区分が「1時間以上、1時間半未満」で、かつ特別管理加算が有効かつ「I型」「II型」の場合
                setState_VALID_LONG_TIME();
            } else {
                setState_INVALID_LONG_TIME();
            }
        }

        // 時間区分を変更する
        checkEndTime();
    }

    /**
     * 「特別管理加算選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void specialManagementRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 特別管理加算変更
        // 画面状態制御処理を呼び出す。
        checkState();

    }

    /**
     * 2人目の訪問時間選択　イベントです
     */
    protected void houmonKangoNumberOfPeopleSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 画面状態制御
        checkState();

    }

    /**
     * 日割りチェック時のイベントです
     */
    @Override
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        // 画面状態制御
        checkState(); 
        
    }

    /**
     * バインド後処理
     * [ID:0000708][Masahiko.Higuchi] 2012/03
     */
    public void binded() throws Exception {
        // 画面状態を再制御
        checkState();
        
    }

}
