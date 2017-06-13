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
 * 開発者: 日高　しのぶ
 * 作成日: 2016/01/27  MIS九州株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン地域密着型通所介護 (QS001_17811_201504)
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
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン地域密着型通所介護(QS001_17811_201504)
 */
@SuppressWarnings("serial")
public class QS001_17811_201504 extends QS001_17811_201504Event {
    /**
     * コンストラクタです。
     */
    public QS001_17811_201504() {
        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("入浴介助", "1780104", "1780104");
        putImportProviderBindPath("サービス提供体制強化加算", "1780113", "1780114");
        putImportProviderBindPath("中重度者ケア体制加算", "1780105", "1780105");
        

        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("入浴介助", "1780104", "1780104");
        putRestrictProviderBindPath("栄養改善体制", "1780109", "1780110");
        putRestrictProviderBindPath("口腔機能向上加算", "1780110", "1780111");
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "1780108", "1780109");
        putRestrictProviderBindPath("個別機能訓練体制", "1780106", "1780106");
        putRestrictProviderBindPath("個別機能訓練体制", "1780106", "1780107");
        putRestrictProviderBindPath("認知症加算", "1780107", "1780108");
        putRestrictProviderBindPath("個別送迎体制強化加算", "1780111", "1780112");
        putRestrictProviderBindPath("入浴介助体制強化加算", "1780112", "1780113");
    }

    // コンポーネントイベント

    /**
     * 「施設区分選択時」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void tsuusyoKaigoTimeContenaFacilityDivisionActionPerformed(
            ActionEvent e) throws Exception {
        // 施設区分選択時の処理
        // 施設区分選択時
        VRMap comboItemMap;
        switch (getTsuusyoKaigoTimeContenaFacilityDivision().getSelectedIndex()) {
        case 1:
            // 地域密着型
            setState_STATE_SMALL();
            comboItemMap = new VRHashMap();
            // コードマスタデータよりCODE_ID：40（時間区分）を取得する。
            // 取得した値を、comboItemMapの KEY : 1780102 の VALUE として設定する。
            comboItemMap.setData("1780102",
                    QkanCommon.getArrayFromMasterCode(40, "1780102"));
            // ※展開
            // 自身(this)にcomboItemMapに設定する。
            getThis().setModelSource(comboItemMap);
            // コンボアイテムを展開する。
            getThis().bindModelSource();
            break;
        case 2:
            // 療養通所選択時
            setState_STATE_RYOYO();
            comboItemMap = new VRHashMap();
            // コードマスタデータよりCODE_ID：40（時間区分）を取得する。
            // 取得した値を、comboItemMapの KEY : 1780102 の VALUE として設定する。
            comboItemMap.setData("1780102",
                    QkanCommon.getArrayFromMasterCode(238, "1780102"));
            // ※展開
            // 自身(this)にcomboItemMapに設定する。
            getThis().setModelSource(comboItemMap);
            // コンボアイテムを展開する。
            getThis().bindModelSource();
            break;
        }
        
        // 上記処理で有効になったコントロールでも、事業所体制で制約を受けるものは上書きで制御する。
        resetStateByRestrictBindPath();

        // 認知症加算が設定されていたら無効にする。それ以外はなにもしない。
    	if (getDementiaElderlyAccepted().isEnabled() == true && getDementiaElderlyAccepted().getSelectedIndex() == 2) {
    		setState_INVALID_YOUNG_DEMENTIA_PATINET();
    	}

    }

    /**
     * 「開始時刻選択時」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void tsuusyoKaigoTimeBeginTimeActionPerformed(ActionEvent e)
            throws Exception {
        // 開始時刻を選択した場合の処理
        checkEndTime();

    }

    /**
     * 「時刻区分選択時」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void tsuusyoKaigoTimeDivisionActionPerformed(ActionEvent e)
            throws Exception {
        // 時刻区分選択処理
        checkEndTime();

    }

    /**
     * 「認知症加算選択時」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void dementiaElderlyAcceptedActionPerformed(
            ActionEvent e) throws Exception {
    	// 認知症加算ありの場合、若年性認知症利用者受入加算は算定不可
    	if (getDementiaElderlyAccepted().getSelectedIndex() == 2) {
    		setState_INVALID_YOUNG_DEMENTIA_PATINET();
    	} else {
    		setState_VALID_YOUNG_DEMENTIA_PATINET();
    	}
    }
    
    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_17811_201504.class.getName(),
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
        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // コードマスタデータよりCODE_ID：40（時間区分）を取得する。
        // 取得した値を、comboItemMapの KEY : 1780102 の VALUE として設定する。
        comboItemMap.setData("1780102",
                QkanCommon.getArrayFromMasterCode(40, "1780102"));
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
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = getImportData();
            // ※設定
            Object obj;

            // 施設等の区分
            obj = VRBindPathParser.get("1780101", provider);
            if (obj != null) {
            	VRBindPathParser.set("1780101", defaultMap, ACCastUtilities.toInt(obj, 1));
            }

            // 人員減算
            obj = VRBindPathParser.get("1780102", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // なしだった場合
                    VRBindPathParser.set("1780103", defaultMap, new Integer(1));
                    break;
                case 2: // 医師だった場合
                case 3: // 看護職員だった場合
                    VRBindPathParser.set("1780103", defaultMap, new Integer(3));
                    break;
                }
            }

            // 個別機能訓練指導加算
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1780106", provider), 1)) {
            case 2: // I型
                VRBindPathParser.set("1780106", defaultMap, new Integer(2));
                break;
            case 3: // II型
                VRBindPathParser.set("1780107", defaultMap, new Integer(2));
                break;
            }
            
            // 体制があってもなしを選択する。
            // 栄養改善体制
            VRBindPathParser.set("1780110", defaultMap, new Integer(1));
            // 口腔機能向上加算
            VRBindPathParser.set("1780111", defaultMap, new Integer(1));
            // 認知症加算が設定されていたら無効にする。それ以外はなにもしない。
            if (getDementiaElderlyAccepted().isEnabled() == true && getDementiaElderlyAccepted().getSelectedIndex() == 2) {
                setState_INVALID_YOUNG_DEMENTIA_PATINET();
            }
            
            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

            resetStateByRestrictBindPath();
        }

    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        if (!getTsuusyoKaigoTimeDivision().isSelected()) {
            // 時間区分(tsuusyoKaigoTimeDivision)が未選択の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
        if (ACTextUtilities
                .isNullText(getTsuusyoKaigoTimeBeginTime().getText())
                || ACTextUtilities.isNullText(getTsuusyoKaigoTimeEndTime()
                        .getText())
                || (!getTsuusyoKaigoTimeBeginTime().isValidDate())
                || (!getTsuusyoKaigoTimeEndTime().isValidDate())) {
            // 開始時刻コンボ(tsuusyoKaigoTimeBeginTime)と終了時刻コンボ(tsuusyoKaigoTimeEndTime)のいずれかが空欄もしくは不正の場合
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
        return getTsuusyoKaigoTimeBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 　関数の返り値として終了時間コンボを返す。
        return getTsuusyoKaigoTimeEndTime();
    }

    /**
     * 「終了時間のチェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkEndTime() throws Exception {
        // ※時間帯変更時、終了時間も変更
        // 開始時間コンボ(houmonRehabilitationTimeContenaBeginTime)の値が空欄および不正でない場合
        // 時間退避用の変数kangoTimeに、時間区分から取得した時間を設定する。
        // 終了時間を「開始時間 + kangoTime(分)」に設定する。
        if (getTsuusyoKaigoTimeBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getTsuusyoKaigoTimeBeginTime()
                        .getText()))) {
            int kaigoTime = 0;
            // 開始時間コンボ(houmonKangoKaigoBeginTime)の値が空欄および不正でない場合
            // 時間退避用の変数kangoTimeに、訪問看護時間区分から取得した時間を設定する。
            if (getTsuusyoKaigoTimeContenaFacilityDivisionItem2().isSelected()) {
                kaigoTime = getRyouyoTuusyoKaigoTime();
            } else {
                kaigoTime = getKaigoTime();
            }
            // 終了時間を「開始時間 + kangoTime(分)」に設定する。
            getTsuusyoKaigoTimeEndTime().setDate(
                    ACDateUtilities.addMinute(getTsuusyoKaigoTimeBeginTime()
                            .getDate(), kaigoTime));
        }

    }

    /**
     * 「時間区分の時間取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public int getKaigoTime() throws Exception {
        // ※時間区分(getTsuusyoKaigoTimeDivision)の時間を取得
        // 時間区分(getTsuusyoKaigoTimeDivision)の値をチェックする。
        switch (getTsuusyoKaigoTimeDivision().getSelectedIndex()) {
        case 0:
            // ２時間以上３時間未満の場合
            // 戻り値として180を返す。
            return 180;
        case 1:
            // ３時間以上５時間未満の場合
            // 戻り値として300を返す。
            return 300;
        case 2:
            // ５時間以上７時間未満の場合
            // 戻り値として420を返す。
            return 420;
        case 3:
            // ７時間以上９時間未満の場合
            // 戻り値として540を返す。
            return 540;
        case 4:
            // ９時間以上１０時間未満の場合
            // 戻り値として600を返す。
            return 600;
        case 5:
            // １０時間以上１１時間未満の場合
            // 戻り値として660を返す。
            return 660;
        case 6:
            // １１時間以上１２時間未満の場合
            // 戻り値として720を返す。
            return 720;
        case 7:
            // １２時間以上１３時間未満の場合
            // 戻り値として780を返す。
            return 780;
        case 8:
            // １３時間以上１４時間未満の場合
            // 戻り値として840を返す。
            return 840;
        }
        return 0;
    }

    public int getRyouyoTuusyoKaigoTime() throws Exception {
        // ※時間区分(getTsuusyoKaigoTimeDivision)の時間を取得
        // 時間区分(getTsuusyoKaigoTimeDivision)の値をチェックする。
        switch (getTsuusyoKaigoTimeDivision().getSelectedIndex()) {
        case 0:
            // ３時間以上６時間未満の場合
            // 戻り値として180を返す。
            return 360;
        case 1:
            // ６時間以上８時間未満の場合
            // 戻り値として480を返す。
            return 480;
        }
        return 0;
    }

}
