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
 * プログラム サービスパターン短期入所生活介護 (QS001_12111_201804)
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
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン短期入所生活介護(QS001_12111_201804)
 */
@SuppressWarnings("serial")
public class QS001_12111_201804 extends QS001_12111_201804Event {
    /**
     * コンストラクタです。
     */
    public QS001_12111_201804() {
        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("施設区分", "1210101", "1210101");
        putImportProviderBindPath("機能訓練に対する体制加算", "1210103", "1210106");
        putImportProviderBindPath("夜間勤務基準条件", "1210102", "1210105");
        putImportProviderBindPath("夜勤職員配置加算", "1210121", "1210121");
        putImportProviderBindPath("サービス提供体制強化加算", "1210124", "1210123");
        putImportProviderBindPath("ユニットケア体制", "1210116", "1210115");
        
        putImportProviderBindPath("個別機能訓練体制", "1210128", "1210127");
        // 2015.03.02 del putImportProviderBindPath("医療連携強化加算", "1210129", "1210128");
        
        //putImportProviderBindPath("共生型", "1210130", "22"); //[H30.4改正]
        putImportProviderBindPath("生活相談員配置等加算", "1210131", "1210130"); //[H30.4改正]        


        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("機能訓練に対する体制加算", "1210103", "1210106");
        putRestrictProviderBindPath("療養食", "1210123", "1210109");
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "1210122", "1210122");
        putRestrictProviderBindPath("ユニットケア体制", "1210116", "1210115");
        putRestrictProviderBindPath("看護体制加算", "1210120", "1210119");
        putRestrictProviderBindPath("看護体制加算", "1210120", "1210133"); //[H30.4改正]       
        putRestrictProviderBindPath("看護体制加算", "1210133", "1210120");
        putRestrictProviderBindPath("看護体制加算", "1210133", "1210134"); //[H30.4改正]
        putRestrictProviderBindPath("認知症専門ケア加算", "1210135", "1210132"); //[H30.4改正]
        putRestrictProviderBindPath("生活機能向上連携加算", "1210132", "1210131"); //[H30.4改正]
        
        putRestrictProviderBindPath("個別機能訓練体制", "1210128", "1210127");
        putRestrictProviderBindPath("医療連携強化加算", "1210129", "1210128");
    }

    // コンポーネントイベント

    /**
     * 「施設区分選択時イベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayLifeTimeContenaFacilityDivisionActionPerformed(
            ActionEvent e) throws Exception {
        // ※「施設区分」選択時の「病室区分」の状態切替
        checkState();
    }

    /**
     * 「食事提供選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayLifeDinnerOfferActionPerformed(ActionEvent e)
            throws Exception {
        // ※「食事提供」選択時に「食費」の状態切替
        if (getShortStayLifeDinnerOffer().getSelectedIndex() < 1) {
            // 「食事提供」が「なし」の場合
            // 食費を無効にする。
            setState_NOT_USE_MEAT();
        } else {
            // 「食事提供」が「なし」以外の場合
            // 食費を有効にする。
            setState_USE_MEAT();
            // 食事費用(shortStayLifeDinnerCost)を設定する。
            getShortStayLifeDinnerCost().setText(
                    getMeatCost(getShortStayLifeDinnerOffer()
                            .getSelectedIndex()));
        }

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_12111_201804.class.getName(),
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
        // 取得した値を、comboItemMapの KEY : 1210111 の VALUE として設定する。
        comboItemMap.setData("1210111",
                QkanCommon.getArrayFromMasterCode(191, "1210111"));
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
        // ※食事提供
        // comboItemMapの KEY : 1210111 の VALUE として1を設定する。
        VRBindPathParser.set("1210111", defaultMap, new Integer(1));
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
        // 選択事業所情報がnullでない場合
        if (provider != null) {
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = getImportData();
            // ※設定
            Object obj;

            // 人員減算
            obj = VRBindPathParser.get("1210107", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // なしだった場合
                    VRBindPathParser.set("1210110", defaultMap, new Integer(1));
                    break;
                case 2: // 看護職員だった場合
                case 3: // 介護職員だった場合
                    VRBindPathParser.set("1210110", defaultMap, new Integer(3));
                    break;
                }
            }

            // 送迎体制
            // 2015/03/02 [H27.4改正対応][Shinobu Hitaka] edit - begin
            // 月間から登録する場合が多いため体制があってもなしを選択する。
            VRBindPathParser.set("6", defaultMap, new Integer(1));
            //obj = VRBindPathParser.get("1210104", provider);
            //if (obj != null) {
            //    switch (ACCastUtilities.toInt(obj)) {
            //    case 1:
            //        // 体制なしの場合
            //        VRBindPathParser.set("6", defaultMap, new Integer(1));
            //        break;
            //    case 2:
            //        // 体制ありの場合
            //        VRBindPathParser.set("6", defaultMap, new Integer(3));
            //        break;
            //    }
            //}
            // 2015/03/02 [H27.4改正対応][Shinobu Hitaka] edit - end
            
            // [ID:0000471][Masahiko Higuchi] 2009/04 add begin 空床型対応
            // サービス提供体制強化加算（単独型）を優先するため値がなしの場合のみ適用
            obj = VRBindPathParser.get("1210124", provider);
            if (ACCastUtilities.toInt(obj, 0) == 1) {
                // 1210125 サービス提供体制強化加算(空床型)
                obj = VRBindPathParser.get("1210125", provider);
                if (obj != null) {
                    VRBindPathParser.set("1210123", defaultMap, obj);
                }
            }
            // [ID:0000471][Masahiko Higuchi] 2009/04 add end

            // 2018/03/01 [H30.4改正対応][Shinobu Hitaka] add - begin
            // 共生型サービスの提供
            obj = VRBindPathParser.get("1210130", provider);
            if (obj != null) {
                // 事業所登録の設定項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 2: // ありだった場合
                    VRBindPathParser.set("22", defaultMap, new Integer(9));
                    break;
                }
            }
            // 2018/03/01 [H30.4改正対応][Shinobu Hitaka] add - end
            
            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();

            if (getShortStayLifeDinnerOffer().getSelectedIndex() == 0) {
                // 食費なしの場合にのみ朝昼夜にする。
                getShortStayLifeDinnerOffer().setSelectedIndex(1);
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
        if (getShortStayLifeDinnerOffer().getSelectedIndex() > 0) {
            // 食事提供（getShortStayLifeDinnerOffer)が「なし」以外を選択している場合
            if (ACTextUtilities.isNullText(getShortStayLifeDinnerCost()
                    .getText())) {
                // 食事費用(getShortStayLifeDinnerCost)が空欄の場合
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
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
     * @param meatType int
     * @throws Exception 処理例外
     * @return String
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
                        VRBindPathParser.get("1210108", getSelectedProvider()),
                        0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1210109", getSelectedProvider()),
                        0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1210110", getSelectedProvider()),
                        0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1210111", getSelectedProvider()),
                        0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1210109", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1210110",
                                getSelectedProvider()), 0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1210110", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1210111",
                                getSelectedProvider()), 0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1210111", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1210109",
                                getSelectedProvider()), 0));
            }
        }
        // 空文字を返す。
        return "";
    }

    /**
     * 「画面状態制御」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * 
     */
    public void checkState() throws Exception {
        // ※画面状態制御処理
        // ※認知症行動・心理症状緊急対応加算と若年性認知症利用者受入加算の排他制御
        if (getDementiaActionAddRadioGroup().getSelectedIndex() == 2) {
            // 認知症行動・心理症状緊急対応加算(dementiaActionAddRadioGroup)が「あり」の場合
            // 若年性認知症利用者受入加算(youngDementiaPatinetAddRadioGroup)を無効にする。
            setState_INVALID_YOUNG_DEMENTIA_PATINET();
            // 緊急短期入所受入加算(shortStayLifeEmergencyAcceptanceRadioGroup)を無効にする。
            setState_INVALID_EMERGENCY_ACCEPTANCE();
        } else {
            // 上記以外の場合
            // 若年性認知症利用者受入加算(youngDementiaPatinetAddRadioGroup)を有効にする。
            setState_VALID_YOUNG_DEMENTIA_PATINET();
            // 緊急短期入所受入加算(shortStayLifeEmergencyAcceptanceRadioGroup)を有効にする。
            setState_VALID_EMERGENCY_ACCEPTANCE();
        }
        /* 2015/03/13 [H27.4改正対応][Shinobu Hitaka] del - begin
        if (getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() == 2) {
            // 若年性認知症利用者受入加算(youngDementiaPatinetAddRadioGroup)が「あり」の場合
            // 認知症行動・心理症状緊急対応加算(dementiaActionAddRadioGroup)を無効にする。
            setState_INVALID_DEMENTIA_ACTION();
        } else {
            // 上記以外の場合
            // 認知症行動・心理症状緊急対応加算(dementiaActionAddRadioGroup)を有効にする。
            setState_VALID_DEMENTIA_ACTION();
        }
        */

        // 「施設区分」の値をチェックする。
        switch (getShortStayLifeTimeContenaFacilityDivision()
                .getSelectedIndex()) {
        case 1:
            // 「単独型」の場合
            // 「病室区分(通常)」を有効にし、「病室区分(ユニット型)」を無効にする。
            setState_CONVENTIONAL_FORM();
            break;
        case 2:
            // 「併設型」の場合
            // 「病室区分(通常)」を有効にし、「病室区分(ユニット型)」を無効にする。
            setState_ADJOINING_FORM();
            break;
        case 3:
        case 4:
            // 「単独型ユニット型」もしくは「併設型ユニット型」の場合
            // 「病室区分(通常)」を無効にし、「病室区分(ユニット型)」を有効にする。
            setState_UNIT_FORM();
        }
        
        // 2015/03/02 [H27.4改正対応][Shinobu Hitaka] add - begin
        // 看護体制加算IIが有効かつチェックされていた場合
        boolean b1 = getNurseStructuralAddRadioItem2().isSelected();
        boolean b2 = getNurseStructuralAddRadioItem2().isEnabled();
        
        // 看護体制加算IVが有効かつチェックされていた場合 add [H30.4改正]
        boolean b3 = getNurseStructuralAddRadioItem4().isSelected();
        boolean b4 = getNurseStructuralAddRadioItem4().isEnabled();
        
        if ((b1 && b2) || (b3 && b4)) {
            // 医療連携強化加算を有効にします。
            setState_VALID_MEDICAL_STRENGTHEN_COOPERATION();
        } else {
            // 医療連携強化加算を無効にします。
            setState_INVALID_MEDICAL_STRENGTHEN_COOPERATION();
        }
        // 2015/03/02 [H27.4改正対応][Shinobu Hitaka] add - end
        
        // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - begin
        // 看護体制加算IとIIIの排他制御
        boolean enabled = true;
        enabled = getNurseStructuralAddRadioItem1().isSelected() 
        		&& getNurseStructuralAddRadioItem1().isEnabled();
        getNurseStructuralAddRadioItem3().setEnabled(!enabled);

        enabled = getNurseStructuralAddRadioItem3().isSelected() 
        		&& getNurseStructuralAddRadioItem3().isEnabled();
        getNurseStructuralAddRadioItem1().setEnabled(!enabled);

        // 看護体制加算IIとIVの排他制御
        enabled = getNurseStructuralAddRadioItem2().isSelected() 
        		&& getNurseStructuralAddRadioItem2().isEnabled();
        getNurseStructuralAddRadioItem4().setEnabled(!enabled);
        
        enabled = getNurseStructuralAddRadioItem4().isSelected() 
        		&& getNurseStructuralAddRadioItem4().isEnabled();
        getNurseStructuralAddRadioItem2().setEnabled(!enabled);
        
        // 看護体制加算IIIまたは看護体制加算IVのとき定員要件有効
        if ((getNurseStructuralAddRadioItem3().isSelected() 
        		&& getNurseStructuralAddRadioItem3().isEnabled())
        		|| (getNurseStructuralAddRadioItem4().isSelected()
        		&& getNurseStructuralAddRadioItem4().isEnabled())) {
            // 定員要件を有効にします。
            setState_VALID_STAY_PEOPLE_COUNT();
        } else {
            // 定員要件を無効にします。
            setState_INVALID_STAY_PEOPLE_COUNT();
        }        
        // 2018/02/20 [H30.4改正対応][Yoichiro Kamei] add - end

        // 上記処理で有効になったコントロールでも、事業所体制で制約を受けるものは上書きで制御する。
        resetStateByRestrictBindPath();

    }

    /**
     * 「認知症行動・心理症状緊急対応加算選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void dementiaActionAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ※認知症行動・心理症状緊急対応加算と若年性認知症利用者受入加算の排他制御
        // 画面の状態を変更する。
        checkState();
    }

    /**
     * 「若年性認知症利用者受入加算選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void youngDementiaPatinetAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ※認知症行動・心理症状緊急対応加算と若年性認知症利用者受入加算の排他制御
        // 画面の状態を変更する。
        checkState();
    }

    /**
     * 「看護体制加算IIチェック」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void nurseStructuralAddRadioItem2ActionPerformed(ActionEvent e)
    throws Exception {
    	// 画面の状態を変更する。
        checkState();
    }
    
    /**
     * 「看護体制加算Iチェック」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
	@Override
	protected void nurseStructuralAddRadioItem1ActionPerformed(ActionEvent e)
			throws Exception {
    	// 画面の状態を変更する。
        checkState();
	}

    /**
     * 「看護体制加算IIIチェック」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
	@Override
	protected void nurseStructuralAddRadioItem3ActionPerformed(ActionEvent e)
			throws Exception {
    	// 画面の状態を変更する。
        checkState();
	}

    /**
     * 「看護体制加算IVチェック」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
	@Override
	protected void nurseStructuralAddRadioItem4ActionPerformed(ActionEvent e)
			throws Exception {
    	// 画面の状態を変更する。
        checkState();
	}

    // 2015/03/09 [H27.4改正対応][Shinobu Hitaka] add - begin
    /**
     * 「バインド処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void binded() throws Exception {
        // ※バインド時の処理
        // 画面状態制御
        checkState();

    }
	// 2015/03/09 [H27.4改正対応][Yoichiro Kamei] add - end




    
}
