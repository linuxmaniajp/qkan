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
 * 作成日: 2011/11/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防訪問看護 (QS001_16311_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

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
 * サービスパターン介護予防訪問看護(QS001_16311_201504)
 */
@SuppressWarnings("serial")
public class QS001_16311_201504 extends QS001_16311_201504Event {
    /**
     * コンストラクタです。
     */
    public QS001_16311_201504() {

        // 値を転記する事業所設定項目
        putImportProviderBindPath("施設区分", "1630101", "1630101");
        putImportProviderBindPath("サービス提供体制強化加算", "1630106", "1630109");
        putImportProviderBindPath("看護体制強化加算", "1630107", "1630117");

        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("特別管理加算", "1630103", "1630106");
        putRestrictProviderBindPath("緊急時訪問看護加算体制", "1630102", "1630105");
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
        // 職員区分選択
        // 画面の状態を変更する。
        checkState();

    }

    /**
     * 「時間区分選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKangoKaigoTimeActionPerformed(ActionEvent e)
            throws Exception {
        // 時間区分選択
        // 終了時間再設定
        checkEndTime();
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
        // 終了時間再設定
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
        // ※時間帯変更時、開始時間も変更
        // 時間退避用の変数kangoTimeに、訪問看護時間区分から取得した時間を設定する。
        // 訪問看護介護時間帯(houmonKaigoTimeZone)の値をチェックする。
        switch (getHoumonKangoKaigoTimeZone().getSelectedIndex()) {
        case 1:
            // 値が１（通常）の場合
            // 開始時間を9:00にする。
            getHoumonKangoKaigoBeginTime().setText("09:00");
            break;
        case 2:
            // 値が２（早朝）の場合
            // 開始時間を6:00にする。
            getHoumonKangoKaigoBeginTime().setText("06:00");
            break;
        case 3:
            // 値が３（夜間）の場合
            // 開始時間を18:00にする。
            getHoumonKangoKaigoBeginTime().setText("18:00");
            break;
        case 4:
            // 値が４（深夜）の場合
            // 開始時間を22:00にする。
            getHoumonKangoKaigoBeginTime().setText("22:00");
            break;
        }
        // 終了時間を「開始時間 + 訪問看護時間(分)」に設定する。
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
        // 施設区分変更
        // 画面状態制御処理を呼び出す。
        checkState();

    }

    /**
     * 「特別管理加算選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonKangoKaigoSpecialManageRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 特別管理加算変更
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
        ACFrame.debugStart(new ACAffairInfo(QS001_16311_201504.class.getName(),
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
        // ※開始時刻  2015.04.13[Shinobu Hitaka] 10分単位に変更
        // コードマスタデータよりCODE_ID：289（時刻・曜日の選択 / 時刻(開始)）を取得する。
        //comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(289, "3"));
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        // ※終了時刻  2015.04.13[Shinobu Hitaka] 10分単位に変更
        // コードマスタデータよりCODE_ID：289（時刻・曜日の選択 / 時刻(開始)）を取得する。
        //comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(289, "4"));
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
        // ※展開
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();
        // ※選択項目の初期設定
        // ※準備
        // 初期選択設定用のレコード defaultMap を生成する。
        VRMap defaultMap = new VRHashMap();
        // ※設定
        // 画面のラジオの初期値を設定する。（selectFirstRadioItem）
        QkanCommon.selectFirstRadioItem(getThis());
        // 時間区分初期設定
        defaultMap.setData("1630107", new Integer(3));
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();
        // 画面の状態を制御する。
        checkState();

    }

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数
        if (provider != null) {
            // 選択事業所情報がnullでない場合
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = getImportData();

            // ※設定

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 画面状態を制御する。
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
        // ※返却用のレコード(data)を生成
        VRMap data = new VRHashMap();
        // 自身(this)のソースとして生成レコードを設定する。
        getThis().setSource(data);
        // 自身(this)のapplySourceを呼び出してデータを収集する。
        getThis().applySource();
        // ※返却用レコードから不要なキーを除去
        // ※入力内容に不備がないかをチェックし、サービスデータを返す
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

        // if (!getHoumonKangoKaigoTime().getSelectedButton().isEnabled()) {
        if (getHoumonKangoKaigoTime().isEnabled()) {
            if (!getHoumonKangoKaigoTime().isSelected()
                    || !getHoumonKangoKaigoTime().getButton(
                            getHoumonKangoKaigoTime().getSelectedIndex())
                            .isEnabled()) {
                // 時間区分の有効な項目が選択されていない場合
                // 内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
        }

        if (!getHoumonKangoKaigoTimeZone().getSelectedButton().isEnabled()) {
            // 時間帯区分に不備があった場合
            // 内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
        if (!getHoumonKangoKaigoClass().getSelectedButton().isEnabled()) {
            // 職員区分に不備があった場合
            // 内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
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
        return getHoumonKangoKaigoBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return getHoumonKangoKaigoEndTime();
    }

    /**
     * 「終了時間取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public int checkEndTime() throws Exception {
        // ※開始時間変更時、終了時間も変更
        if (getHoumonKangoKaigoBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getHoumonKangoKaigoBeginTime()
                        .getText()))) {
            // 開始時間コンボ(houmonKangoKaigoBeginTime)の値が空欄および不正でない場合
            // 時間退避用の変数kangoTimeに、訪問看護時間区分から取得した時間を設定する。
            int kangoTime = 0;

            // 正看・准看
            switch (getHoumonKangoKaigoTime().getSelectedIndex()) {
            case 1: // 20分未満
                kangoTime = 20;
                break;
            case 2: // 30分未満の場合
                // 戻り値として30を返す。
                kangoTime = 30;
                break;
            case 3: // 30分以上、一時間未満
                // 戻り値として60を返す。
                kangoTime = 60;
                break;
            case 4: // 1時間以上、1時間半未満
                // 1時間以上、1時間半未満の場合
                // 戻り値として90を返す。
                kangoTime = 90;
                break;
            }

            // 終了時間を「開始時間 + kangoTime(分)」に設定する。
            getHoumonKangoKaigoEndTime().setDate(
                    ACDateUtilities.addMinute(getHoumonKangoKaigoBeginTime()
                            .getDate(), kangoTime));

        }
        return 0;
    }

    /**
     * 「画面の状態を変更する。」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkState() throws Exception {
        // ※画面状態を変更する。
        // ※サービス連動
        // 施設区分の値をチェックする。
        switch (getHoumonKangoKaigoFacilityType().getSelectedIndex()) {
        case 1:
            // 訪問看護ステーションだった場合
            switch (getHoumonKangoKaigoClass().getSelectedIndex()) {
            // 正看又は准看護婦だった場合
            case 1:
            case 2:
                // 時間区分チェック
                switch (getHoumonKangoKaigoTime().getSelectedIndex()) {
                // 20分未満だった場合
                case 1:
                    // 状態2
                    setState_STATE_MODE_2();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    // 20分未満以外だった場合
                    // 状態1
                    setState_STATE_MODE_1();
                    break;
                }
                break;
            case 3:
                // 理学だった場合
                // 状態3
                setState_STATE_MODE_3();
                break;
            }
            break;
        // 医療機関だった場合
        case 2:
            switch (getHoumonKangoKaigoClass().getSelectedIndex()) {
            // 正看又は准看護婦だった場合
            case 1:
            case 2:
                // 時間区分チェック
                switch (getHoumonKangoKaigoTime().getSelectedIndex()) {
                // 20分未満だった場合
                case 1:
                    // 状態5
                    setState_STATE_MODE_5();
                    break;
                // 20分未満以外だった場合
                case 2:
                case 3:
                case 4:
                case 5:
                    // 状態4
                    setState_STATE_MODE_4();
                    break;
                }
                break;
            // 理学療法士だった場合
            case 3:
                // 状態6
                setState_STATE_MODE_6();
                break;
            }
            break;
        }

        // 長時間訪問看護加算の有効是非をチェックする。
        if (getHoumonKangoKaigoTime().isEnabled()
                && getHoumonKangoKaigoTime().getSelectedIndex() == 4
                && getHoumonKangoKaigoTime().getButton(4).isEnabled()
                && getHoumonKangoKaigoSpecialManageRadio().isEnabled()
                && getHoumonKangoKaigoSpecialManageRadio().getSelectedIndex() > 1) {
            // 時間区分が「1時間以上、1時間半未満」で、かつ特別管理加算が有効かつ「あり」の場合
            // 「長時間訪問看護加算・有効」状態にする。(VALID_LONG_TIME)
            setState_VALID_LONG_TIME();
        } else {
            // 上記以外の場合
            // 「長時間訪問看護加算・無効」状態にする。(INVALID_LONG_TIME)
            setState_INVALID_LONG_TIME();
        }

        switch (getHoumonKangoKaigoTime().getSelectedIndex()) {
        case 1:
        case 2:
            // 時間区分が20分未満　30分未満の場合は無効にする
            setState_INVALID_NUMBER_OF_PEOPLE_TIME();
            break;
        case 3:
        case 4:
            if (getVisitPersonAddRadio().getSelectedIndex() == 2) {
                // 訪問人数が2人の場合
                setState_VALID_NUMBER_OF_PEOPLE_TIME();
            } else {
                // 訪問人数が1人の場合
                setState_INVALID_NUMBER_OF_PEOPLE_TIME();
            }
            break;
        }
    }

    /**
     * 2人目の訪問時間　イベント
     */
    protected void visitPersonAddRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        checkState();

    }
}
