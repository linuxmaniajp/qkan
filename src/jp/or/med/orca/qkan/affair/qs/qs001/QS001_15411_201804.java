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
 * プログラム サービスパターン地域密着型介護福祉施設 (QS001_15411_201804)
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
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン地域密着型介護福祉施設(QS001_15411_201804)
 */
@SuppressWarnings("serial")
public class QS001_15411_201804 extends QS001_15411_201804Event {
    /**
     * コンストラクタです。
     */
    public QS001_15411_201804() {

        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");

        // 事業所からの値引き継ぎ
        putImportProviderBindPath("ユニットケアの整備", "1540113", "1540105");
        putImportProviderBindPath("夜間勤務減算", "1540103", "1540107");
        // 2015.03.04 del putImportProviderBindPath("個別機能訓練指導加算", "1540104", "1540108");
        putImportProviderBindPath("医師常勤加算", "1540105", "1540109");
        putImportProviderBindPath("準ユニットケア", "1540114", "1540106");
        putImportProviderBindPath("精神科医指導加算", "1540106", "1540110");
        putImportProviderBindPath("障害者生活支援体制加算", "1540107", "1540111");
        putImportProviderBindPath("栄養マネジメント加算", "1540135", "1540115");
        putImportProviderBindPath("日常生活継続支援加算", "1540128", "1540129");
        putImportProviderBindPath("夜勤職員配置加算", "1540130", "1540131");
        putImportProviderBindPath("サービス提供体制強化加算", "1540134", "1540136");

        // 事業所の設定により無効にする
        putRestrictProviderBindPath("個別機能訓練指導加算", "1540104", "1540108");
        putRestrictProviderBindPath("医師常勤加算", "1540105", "1540109");
        putRestrictProviderBindPath("精神科医指導加算", "1540106", "1540110");
        putRestrictProviderBindPath("障害者生活支援体制加算", "1540107", "1540111");
        putRestrictProviderBindPath("栄養マネジメント加算", "1540135", "1540115");
        putRestrictProviderBindPath("療養食加算", "1540132", "1540118");
        putRestrictProviderBindPath("小規模拠点集合体制", "1540127", "1540127");
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "1540131", "1540132");
        putRestrictProviderBindPath("看護体制加算I", "1540129", "1540137");
        putRestrictProviderBindPath("看護体制加算II", "1540139", "1540138"); //[H30.4改正]
        putRestrictProviderBindPath("ユニットケアの整備", "1540113", "1540105");
        putRestrictProviderBindPath("認知症専門ケア加算", "1540133", "1540135");
        putRestrictProviderBindPath("看取り介護体制", "1540125", "1540142");
        putRestrictProviderBindPath("在宅・入所相互利用加算", "1540126", "1540126");
        putRestrictProviderBindPath("生活機能向上連携加算", "1540140", "1540143"); //[H30.4改正]
        putRestrictProviderBindPath("配置医師緊急時対応加算", "1540137", "1540147"); //[H30.4改正]
        putRestrictProviderBindPath("褥瘡マネジメント加算", "1540138", "1540148"); //[H30.4改正]

    }

    // コンポーネントイベント

    /**
     * 「施設区分選択時イベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoWelfareFacilityInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {

        checkState();
    }

    /**
     * 「食事提供選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoWelfareFacilityDinnerOfferActionPerformed(ActionEvent e)
            throws Exception {
        // ※「食事提供」選択時に「食費」の状態切替
        if (getKaigoWelfareFacilityDinnerOffer().getSelectedIndex() < 1) {
            // 「食事提供」が「なし」の場合
            // 食費を無効にする。
            setState_NOT_USE_MEAT();
        } else {
            // 「食事提供」が「なし」以外の場合
            // 食費を有効にする。
            setState_USE_MEAT();
            // 食事費用(kaigoWelfareFacilityDinnerCost)を設定する。
            getKaigoWelfareFacilityDinnerCost().setText(
                    getMeatCost(getKaigoWelfareFacilityDinnerOffer()
                            .getSelectedIndex()));
        }

    }

    /**
     * 「栄養マネジメント加算の変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoWelfareFacilityNutritionRadioSelectionChanged(ListSelectionEvent e) throws Exception{
        // 画面状態制御
        checkState();
    }
    
    /**
     * 「経口移行加算の変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoWelfareFacilityOralSwitchRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 画面状態制御
        checkState();
    }

    /**
     * 「経口維持加算Iの変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void oralMaintenanceAddActionPerformed(
    		ActionEvent e) throws Exception {
        // 画面状態制御
        checkState();
    }

    /**
     * 「経口維持加算IIの変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void oralMaintenanceAddItem3ActionPerformed(
    		ActionEvent e) throws Exception {
        // 画面状態制御
        checkState();
    }

    /**
     * 「旧措置入所者チェック」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoWelfareFacilityOldMeasuresPersonActionPerformed(
            ActionEvent e) throws Exception {
        checkState();

    }

    /**
     * 「認知症行動・心理症状緊急対応加算選択」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void dementiaEmergencyAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception{
    	// 画面状態制御
    	checkState();

    }

    /**
     * 「若年性認知症利用者受入加算選択」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void youngDementiaPatinetAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception{
    	// 画面状態制御
    	checkState();

    }
    
    /**
     * 「外泊加算選択」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
	@Override
	protected void kaigoWelfareFacilityStayingOutOvernightCostRadioSelectionChanged(
			ListSelectionEvent e)
			throws Exception {
        // 画面状態制御
        checkState();
	}

    /**
     * 「外泊時在宅サービス利用費用選択」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
	@Override
	protected void homeServiceUsageFeeAtHomeSelectionChanged(
			ListSelectionEvent e) throws Exception {
        // 画面状態制御
        checkState();
	}

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_15411_201804.class.getName(),
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
        // ※食事提供
        // コードマスタデータよりCODE_ID：191（食事提供）を取得する。
        // 取得した値を、comboItemMapの KEY : 1510120 の VALUE として設定する。
        comboItemMap.setData("1510120",
                QkanCommon.getArrayFromMasterCode(191, "1540120"));
        // ※展開
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();
        // ※選択項目の初期設定
        QkanCommon.selectFirstRadioItem(getThis());
        // ※準備
        // 初期選択設定用のレコード defaultMap を生成する。
        VRMap defaultMap = new VRHashMap();
        // ※設定
        // 食事提供の「なし」を選択する。
        defaultMap.setData("1540120", new Integer(1));

        // 2006/05/15 予防対応(要望）
        // 旧措置入所者チェックの値を設定
        if (isOldFacilityUser()) {
            VRBindPathParser.set("8", defaultMap, new Integer(2));
        } else {
            VRBindPathParser.set("8", defaultMap, new Integer(1));
        }

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
        setSelectedProvider(provider);
        if (provider != null) {
            // 選択事業所情報がnullでない場合
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = getImportData();
            // ※設定
            
            // 経過的地域密着
            VRBindPathParser.set("1540102", defaultMap,
                    VRBindPathParser.get("1540102", provider));

            // 人員減算
            Object obj;

            // 施設区分
            obj = VRBindPathParser.get("1540101", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: //
                case 2: //
                    VRBindPathParser.set("1540101", defaultMap, new Integer(1));
                    break;
                case 3: //
                case 4: //
                    VRBindPathParser.set("1540101", defaultMap, new Integer(2));
                    break;
                }
            }

            obj = VRBindPathParser.get("1540112", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // なしだった場合
                    VRBindPathParser.set("1540119", defaultMap, new Integer(1));
                    break;
                case 2: // 看護職員だった場合
                case 3: // 介護職員だった場合
                case 4: // 介護支援専門員だった場合
                    VRBindPathParser.set("1540119", defaultMap, new Integer(3));
                    break;
                }
            }

            // 身体拘束未実施減算
            obj = VRBindPathParser.get("1540116", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // 身体拘束廃止取組がない場合
                    VRBindPathParser.set("1540123", defaultMap, new Integer(2));
                    break;
                case 2: // 身体拘束廃止取組がある場合
                    VRBindPathParser.set("1540123", defaultMap, new Integer(1));
                    break;
                }
            }

            // 若年性認知症利用者受入加算をなしに設定する。
            VRBindPathParser.set("1540132", defaultMap, new Integer(1));
            
            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();

            if (getKaigoWelfareFacilityDinnerOffer().getSelectedIndex() == 0) {
                // 食費なしの場合にのみ朝昼夜にする。
                getKaigoWelfareFacilityDinnerOffer().setSelectedIndex(1);
            }

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
        if (!getKaigoWelfareFacilityInstitutionDivisionRadio().isSelected()) {
            // 施設区分コンボ(kaigoWelfareFacilityInstitutionDivisionRadio)が未選択の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }

        if ((getKaigoWelfareFacilityHospitalRoomDivisionRadio().isEnabled() && (!getKaigoWelfareFacilityHospitalRoomDivisionRadio()
                .isSelected()))
                || (getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio()
                        .isEnabled() && (!getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio()
                        .isSelected()))) {
            // 病室区分（介護福祉施設）(kaigoWelfareFacilityHospitalRoomDivisionRadio)が有効でかつ未選択の場合
            // もしくは病室区分（ユニット型介護福祉施設）(kaigoWelfareFacilityUnitHospitalRoomDivisionRadio)が有効でかつ未選択の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
        if (getKaigoWelfareFacilityDinnerCost().isEnabled()
                && ACTextUtilities
                        .isNullText(getKaigoWelfareFacilityDinnerCost()
                                .getText())) {
            // 食事費用(kaigoWelfareFacilityDinnerCost)が有効でかつ空欄の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
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
        return null;
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 　関数の返り値として終了時間コンボを返す。
        return null;
    }

    /**
     * 「食事費用を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public String getMeatCost(int meatType) throws Exception {
        // ※食事時期をもとに選択事業所における食事費用を返す。
        if (getSelectedProvider() != null) {
            // 事業所を選択している場合
            switch (meatType) {
            case 1:
                // 食事時期が「朝昼夜」の場合
                // 「朝」の食費、「昼」の食費、「夜」の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1540117", getSelectedProvider()),
                        0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1540118", getSelectedProvider()),
                        0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1540119", getSelectedProvider()),
                        0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1540120", getSelectedProvider()),
                        0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1540118", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1540119",
                                getSelectedProvider()), 0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1540119", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1540120",
                                getSelectedProvider()), 0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1540120", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1540118",
                                getSelectedProvider()), 0));
            }
        }
        // 空文字を返す。
        return "";
    }

    /**
     * 「データバインド時の処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void binded() throws Exception {


    }

    /**
     * 看取り看護加算選択時
     */
	@Override
	protected void kaigoWelfareFacilityTakingCareNursingPtnSelectionChanged(ListSelectionEvent e) throws Exception {
		
        checkState();
	}
	
    /**
     * 算定区分選択時
     */
    @Override
    protected void kaigoWelfareFacilityCalculationDivisionRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {

        checkState();
    }

    // 画面の状態制御
    private void checkState() throws Exception {

        // ※「施設区分」選択時の「病室区分」の状態切替
        // 「施設区分」の値をチェックする。
        switch (getKaigoWelfareFacilityInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // 「介護福祉施設」の場合
            // 「病室区分（介護福祉施設）」を有効にし、「病室区分（ユニット型介護福祉施設）」を無効にする。
            setState_CONVENTIONAL_FORM();
            setState_VALID_SUB_UNIT_CARE();
            break;
        case 2:
            // 「ユニット型介護福祉施設」の場合
            // 「病室区分（ユニット型介護福祉施設）」を無効にし、「病室区分（介護福祉施設）」を有効にする。
            setState_UNIT_FORM();
            setState_INVALLID_SUB_UNIT_CARE();
            break;
        }

        // 口腔機能管理体制加算がありの場合
        if (getOralKeepStructureAddRadioGroup().getSelectedIndex() == 1) {
            setState_INVALID_ORAL_CARE();
        } else {
            setState_VALID_ORAL_CARE();
        }

        // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - begin
        // 51:介護福祉施設サービスと同様の処理とする
        // 栄養マネジメント加算の状態を基に経口移行加算、経口維持加算の有効状態を変更
        if (getKaigoWelfareFacilityNutritionRadioItem2().isSelected()) {
            // 経口移行加算の状態を元に制御
            if (getKaigoWelfareFacilityOralSwitchRadioItem2().isSelected()) {
                setState_INVALID_KEEP_NUTRITION();
            } else {
                setState_VALID_KEEP_NUTRITION();
            }
            
            // 経口維持加算の状態を元に制御
            if (getOralMaintenanceAddItem2().isSelected()) {
            	setState_INVALID_ORAL_SWITCH();
            } else {
            	setState_VALID_ORAL_SWITCH();
            }
            
            // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - begin
            // 低栄養リスク改善加算
            // 栄養マネジメント加算を算定している、かつ経口移行加算及び経口維持加算を算定していない
            if (getKaigoWelfareFacilityOralSwitchRadioItem1().isSelected()
            		&& getOralMaintenanceAddItem1().isSelected()) {
            	// 低栄養リスク改善加算を有効
            	setState_VALID_LOW_NUTRITIONAL();
            } else {
            	// 低栄養リスク改善加算を無効
            	setState_INVALID_LOW_NUTRITIONAL();
            }
            
            // 栄養マネジメント加算を算定している場合、
            // 再入所時栄養連携加算を有効
            setState_VALID_RE_ENTRY_NUTRITION();
            // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - end
            
        } else {
        	setState_INVALID_ORAL_SWITCH();
            setState_INVALID_KEEP_NUTRITION();
            // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - begin
            // 栄養マネジメント加算を算定していない場合、
            // 再入所時栄養連携加算を無効
            setState_INVALID_RE_ENTRY_NUTRITION();
        	// 低栄養リスク改善加算を無効
        	setState_INVALID_LOW_NUTRITIONAL();
            // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - end
        }
        
        // 経口維持加算の状態を基に経口維持加算２の有効状態を変更
        if (getKaigoWelfareFacilityNutritionRadioItem2().isSelected()
                && getOralMaintenanceAddItem2().isSelected()) {
            setState_VALID_ORAL_MAINTENANCE2();
        } else {
            setState_INVALID_ORAL_MAINTENANCE2();
        }
        // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - end

        // 算定区分で「2-加算のみ」が選択されている
        // かつ、看取り介護加算が「1-なし」以外の場合
        if ((getKaigoWelfareFacilityCalculationDivisionRadio()
                .getSelectedIndex() == 2)) {

            // 看取り介護加算の選択状況による制御
            switch (getKaigoWelfareFacilityTakingCareNursingPtn()
                    .getSelectedIndex()) {
            case 1: // なし選択時
                setState_INVALID_TERMINAL_DAYS();
                break;
            case 2:
            case 3:
                setState_VALID_TERMINAL_DAYS();
                break;
            }

        } else {
            // 看取り介護加算日数単位無効
            setState_INVALID_TERMINAL_DAYS();

        }
        
        // 看取り介護加算の選択状況による制御
        switch (getKaigoWelfareFacilityTakingCareNursingPtn()
                .getSelectedIndex()) {
        case 1: // なし選択時
            setState_INVALID_TERMINAL();
            break;
        case 2:
        case 3:
            setState_VALID_TERMINAL();
            break;
        }
        
        // 認知症行動・心理症状緊急対応加算と若年性認知症利用者受入加算の排他制御
        if (getDementiaEmergencyAddRadioGroup().getSelectedIndex() == 2) {
            // 認知症行動・心理症状緊急対応加算が「あり」の場合
            // 若年性認知症利用者受入加算を無効にする。
            setState_INVALID_YOUNG_DEMENTIA_PATINET();
        } else {
            // 上記以外の場合
            // 若年性認知症利用者受入加算を有効にする。
            setState_VALID_YOUNG_DEMENTIA_PATINET();
        }
        if (getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() == 2) {
            // 若年性認知症利用者受入加算が「あり」の場合
            // 認知症行動・心理症状緊急対応加算を無効にする。
            setState_INVALID_DEMENTIA_ACTION();
        } else {
            // 上記以外の場合
            // 認知症行動・心理症状緊急対応加算を有効にする。
            setState_VALID_DEMENTIA_ACTION();
        }

        // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - begin
        // 外泊時費用と外泊時の在宅サービス費用の排他制御
        // 外泊加算がありの場合
        if (getKaigoWelfareFacilityStayingOutOvernightCostRadioItem2().isSelected()) {
        	// 外泊時の在宅サービス費用を無効にする
            setState_INVALID_HOME_SERVICE_USAGE();
        } else {
        	// 外泊時の在宅サービス費用を有効にする
            setState_VALID_HOME_SERVICE_USAGE();
        }
        // 外泊時の在宅サービス費用がありの場合
        if (getHomeServiceUsageFeeAtHomeItem2().isSelected()) {
        	// 外泊加算を無効にする
            setState_INVALID_OUT_OVERNIGHT_COST();
        } else {
        	// 外泊加算を有効にする
            setState_VALID_OUT_OVERNIGHT_COST();
        }
        // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - end
        
        // 事業所体制による有効/無効を再設定
        resetStateByRestrictBindPath();
    }

    @Override
    protected void oralKeepStructureAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 画面状態制御
        checkState();

    }




    
}
