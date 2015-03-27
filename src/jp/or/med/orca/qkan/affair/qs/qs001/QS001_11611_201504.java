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
 * プログラム サービスパターン通所リハ (QS001_11611_201504)
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
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン通所リハ(QS001_11611_201504)
 */
@SuppressWarnings("serial")
public class QS001_11611_201504 extends QS001_11611_201504Event {
    /**
     * コンストラクタです。
     */
    public QS001_11611_201504() {
        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("施設区分", "1160112", "1160116");
        // 2015.03.02 del putImportProviderBindPath("入浴加算", "1160102", "1160105");
        // 2015.03.02 del putImportProviderBindPath("栄養改善体制", "1160116", "1160114");
        // 2015.03.02 del putImportProviderBindPath("口腔機能向上体制", "1160109", "1160115");
        putImportProviderBindPath("認知症短期集中リハビリテーション加算", "1160113", "1160120");
        putImportProviderBindPath("サービス提供体制強化加算", "1160115", "1160122");
        putImportProviderBindPath("中重度者ケア体制加算", "1160124", "1160125");
        putImportProviderBindPath("社会参加支援加算", "1160125", "1160126");
        
        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("入浴加算", "1160102", "1160105");
        putRestrictProviderBindPath("栄養改善体制", "1160116", "1160114");
        putRestrictProviderBindPath("口腔機能向上体制", "1160109", "1160115");
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "1160114", "1160121");
        
        putRestrictProviderBindPath("中重度者ケア体制加算", "1160124", "1160125");
        putRestrictProviderBindPath("社会参加支援加算", "1160125", "1160126");
    }

    // コンポーネントイベント

    /**
     * 「開始時間」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonRehabilitationTimeContenaBeginTimeActionPerformed(
            ActionEvent e) throws Exception {
        // サービス提供時間（開始）の時間区分変更時の処理
        // サービス提供時間（開始）の時間区分変更時
        checkEndTime();

    }

    /**
     * 「終了時間」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonRehabilitationTimeDivisionActionPerformed(ActionEvent e)
            throws Exception {
        // サービス提供時間（終了）の時間区分変更時の処理
        // ※時間区分変更時、終了時間も変更
        changeState();
        // サービス提供時間（終了）の時間区分変更時
        checkEndTime();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_11611_201504.class.getName(),
                param));
    }

    /**
     * 「リハビリテーションマネジメント加算選択時」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonRehabilitationManagementAddRadioActionPerformed(ActionEvent e) throws Exception{
        // リハビリテーションマネジメント加算なし選択
        if (getHoumonRehabilitationManagementAddRadio().getSelectedIndex() == 1) {
        	setState_INVALID_HOUMON_REHABILITATION_MANAGEMENT();
        } else {
        	setState_VALID_HOUMON_REHABILITATION_MANAGEMENT();
        	checkRehabilitationState();
        }
    }

    /**
     * 「短期集中個別リハビリ実施加算選択時」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonRehabilitationShortConcentrationAddRadioActionPerformed(ActionEvent e) throws Exception{
    	checkRehabilitationState();

    }

    /**
     * 「認知症短期集中リハビリ実施加算選択時」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void dementiaRehabilitationShortConcentrationAddRadioActionPerformed(ActionEvent e) throws Exception{
    	checkRehabilitationState();

    }

    /**
     * 「生活行為向上リハビリ実施加算選択時」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void lifeActsImproveRehabilitationRadioGroupActionPerformed(ActionEvent e) throws Exception{
    	checkRehabilitationState();
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
        // ※時間区分
        // コードマスタデータよりCODE_ID：275（時間区分）を取得する。
        // 取得した値を、comboItemMapの KEY : 1160104 の VALUE として設定する。
        comboItemMap.setData("1160104",
                QkanCommon.getArrayFromMasterCode(275, "1160104"));
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
        QkanCommon.selectFirstRadioItem(this);
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
        // 選択事業所情報がnullでない場合
        if (provider != null) {
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = getImportData();
            // ※設定
            Object obj;

            // 人員減算
            obj = VRBindPathParser.get("1160105", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // なしだった場合
                    VRBindPathParser.set("1160109", defaultMap, new Integer(1));
                    break;
                case 2: // 医師だった場合
                case 3: // 看護職員だった場合
                case 4: // 介護職員だった場合
                case 5: // 理学療法士だった場合
                case 6: // 作業療法士だった場合
                case 7: // 言語聴覚士だった場合
                    VRBindPathParser.set("1160109", defaultMap, new Integer(3));
                    break;
                }
            }
            
            // 2015/03/02 [H27.4改正対応][Shinobu Hitaka] edit - begin 体制があってもなしを選択する。
            // 入浴加算
            VRBindPathParser.set("1160105", defaultMap, new Integer(1));
            // 栄養改善体制加算
            VRBindPathParser.set("1160114", defaultMap, new Integer(1));
            // 口腔機能向上加算
            VRBindPathParser.set("1160115", defaultMap, new Integer(1));
            // 社会参加支援加算 2016.4.1以前は算定できないため選択不可
            if (getCalculater().getTargetDate() != null && 
                    ACDateUtilities.getDifferenceOnDay(ACDateUtilities.createDate(2016, 4, 1), getCalculater().getTargetDate()) > 0) {
            	getRegionalServiceRadioGroupContainer().setEnabled(false);
            }
            // リハビリテーションマネジメント加算なし選択
            if (getHoumonRehabilitationManagementAddRadio().getSelectedIndex() == 1) {
            	setState_INVALID_HOUMON_REHABILITATION_MANAGEMENT();
            }
            // 2015/03/02 [H27.4改正対応][Shinobu Hitaka] edit - end

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

        }

        // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
        changeState();
    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        if (!getHoumonRehabilitationTimeDivision().isSelected()) {
            // 時間区(houmonRehabilitationTimeDivision)分が未選択の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }

        if (ACTextUtilities
                .isNullText(getHoumonRehabilitationTimeContenaBeginTime()
                        .getText())
                || ACTextUtilities
                        .isNullText(getHoumonRehabilitationTimeContenaEndTime()
                                .getText())
                || (!getHoumonRehabilitationTimeContenaBeginTime()
                        .isValidDate())
                || (!getHoumonRehabilitationTimeContenaEndTime().isValidDate())) {
            // 開始時刻コンボ(houmonRehabilitationTimeContenaBeginTime)が空欄か不正の場合
            // もしくは終了時刻コンボ(houmonRehabilitationTimeContenaEndTime)が空欄か不正の場合
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
        return getHoumonRehabilitationTimeContenaBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 　関数の返り値として終了時間コンボを返す。
        return getHoumonRehabilitationTimeContenaEndTime();
    }

    public void changeState() throws Exception {
        int timeIndex = getHoumonRehabilitationTimeDivision()
                .getSelectedIndex();
        // 時間区分による画面制御処理
        switch (timeIndex) {
        case 0: // 1～2の場合
            setState_VALID_PHYSIOTHERAPIST_STRENGTHENED();
            break;
        default:// 上記以外
            setState_INVALID_PHYSIOTHERAPIST_STRENGTHENED();
            break;
        }

        // 認定履歴を取得し、要介護度３または要介護度４または５の利用者であるか確認
        boolean overKaigodo3 = false;
        VRList ninteiList = getCalculater().getPatientInsureInfoHistoryList();
        for (int i = 0; i < ninteiList.size(); i++) {
            VRMap nintei = (VRMap) ninteiList.get(i);

            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("JOTAI_CODE", nintei), 0)) {
            case 23: // 要介護３
            case 24: // 要支援４
            case 25: // 要支援５
                overKaigodo3 = true;
                break;
            }
        }

        if (overKaigodo3) {
            // 要介護度が３・４・５の場合は、重度療養管理加算有効 かつ
            // 1～2時間の場合のみ有効
            setState_INVALID_ADD_MEDICAL_MANAGEMENT();
            if (timeIndex >= 1) {
                setState_VALID_ADD_MEDICAL_MANAGEMENT();
            }
        } else {
            // 上記以外は、重度療養管理加算無効
            setState_INVALID_ADD_MEDICAL_MANAGEMENT();
        }
        
        // リハビリテーション実施加算の併用チェック
        checkRehabilitationState();
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
        if (getHoumonRehabilitationTimeContenaBeginTime().isValidDate()
                && (!ACTextUtilities
                        .isNullText(getHoumonRehabilitationTimeContenaBeginTime()
                                .getText()))) {
            // 開始時間コンボ(houmonKangoKaigoBeginTime)の値が空欄および不正でない場合
            // 時間退避用の変数kangoTimeに、訪問看護時間区分から取得した時間を設定する。
            int kaigoTime = getKaigoTime();

            // 終了時間を「開始時間 + kangoTime(分)」に設定する。
            getHoumonRehabilitationTimeContenaEndTime().setDate(
                    ACDateUtilities.addMinute(
                            getHoumonRehabilitationTimeContenaBeginTime()
                                    .getDate(), kaigoTime));
        }

    }

    /**
     * 「時間区分の時間取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public int getKaigoTime() throws Exception {
        // ※時間区分(houmonRehabilitationTimeDivision)の時間を取得
        // 時間区分(houmonRehabilitationTimeDivision)の値をチェックする。
        switch (getHoumonRehabilitationTimeDivision().getSelectedIndex()) {
        case 0:
            // １時間以上２時間未満の場合
            // 戻り値として120を返す。
            return 120;
        case 1:
            // ２時間以上３時間未満の場合
            // 戻り値として180を返す。
            return 180;
        case 2:
            // ３時間以上４時間未満の場合
            // 戻り値として240を返す。
            return 240;
        case 3:
            // ４時間以上６時間未満の場合
            // 戻り値として360を返す。
            return 360;
        case 4:
            // ６時間以上８時間未満の場合
            // 戻り値として480を返す。
            return 480;
        case 5:
            // ８時間以上９時間未満の場合
            // 戻り値として540を返す。
            return 540;
        case 6:
            // ９時間以上１０時間未満の場合
            // 戻り値として600を返す。
            return 600;
        case 7:
            // １０時間以上１１時間未満の場合
            // 戻り値として660を返す。
            return 660;
        case 8:
            // １１時間以上１２時間未満の場合
            // 戻り値として720を返す。
            return 720;
        case 9:
            // １２時間以上１３時間未満の場合
            // 戻り値として780を返す。
            return 780;
        case 10:
            // １３時間以上１４時間未満の場合
            // 戻り値として840を返す。
            return 840;
        }
        return 0;
    }

    /**
     * 短期集中リハビリテーション実施加算、認知症短期集中リハビリテーション実施加算、生活行為向上リハビリテーション実施加算選択時の画面制御処理です。
     * 
     * @author Shinobu.Hitaka
     * @since V7.0.0
     */
    public void checkRehabilitationState() throws Exception {
    	// 下記リハビリテーション実施加算は、いずれか１つのみ有効
    	// 短期集中リハビリテーション実施加算
    	if (getHoumonRehabilitationShortConcentrationAddRadio().isEnabled()) {
	    	if (getHoumonRehabilitationShortConcentrationAddRadio().getSelectedIndex() == 2) {
	    		setState_INVALID_DEMENTIA_REHABILITATION_SHORT_CONCENTRATION();
	    		setState_INVALID_LIFE_ACTSIMPROVE_REHABILITATION();
	    	} else {
	    		setState_VALID_DEMENTIA_REHABILITATION_SHORT_CONCENTRATION();
	    		setState_VALID_LIFE_ACTSIMPROVE_REHABILITATION();
	    	}
    	}
    	// 認知症短期集中リハビリテーション実施加算
    	if (getDementiaRehabilitationShortConcentrationAddRadio().isEnabled()) {
	    	if (getDementiaRehabilitationShortConcentrationAddRadio().getSelectedIndex() != 1) {
	    		setState_INVALID_HOUMON_REHABILITATION_SHORT_CONCENTRATION();
	    		setState_INVALID_LIFE_ACTSIMPROVE_REHABILITATION();
	    	} else {
	    		setState_VALID_HOUMON_REHABILITATION_SHORT_CONCENTRATION();
	    		setState_VALID_LIFE_ACTSIMPROVE_REHABILITATION();
	    	}
    	}
    	// 生活行為向上リハビリテーション実施加算
    	if (getLifeActsImproveRehabilitationRadioGroup().isEnabled()) {
	    	if (getLifeActsImproveRehabilitationRadioGroup().getSelectedIndex() != 1) {
	    		setState_INVALID_HOUMON_REHABILITATION_SHORT_CONCENTRATION();
	    		setState_INVALID_DEMENTIA_REHABILITATION_SHORT_CONCENTRATION();
	    	} else {
	    		setState_VALID_HOUMON_REHABILITATION_SHORT_CONCENTRATION();
	    		setState_VALID_DEMENTIA_REHABILITATION_SHORT_CONCENTRATION();
	    	}
    	}
    }

}
