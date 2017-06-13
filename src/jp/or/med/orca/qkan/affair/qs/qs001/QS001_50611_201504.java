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
 * 作成日: 2011/11/16  MIS九州株式会社 亀井　陽一郎 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン通所型サービス(独自) (QS001_50611_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン通所型サービス(独自)(QS001_50611_201504)
 */
@SuppressWarnings("serial")
public class QS001_50611_201504 extends QS001_50611_201504Event {
    /**
     * コンストラクタです。
     */
    public QS001_50611_201504() {

        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("運動機能向上体制", "5060102", "5060106");
        putImportProviderBindPath("栄養改善体制", "5060103", "5060107");
        putImportProviderBindPath("口腔機能向上体制", "5060104", "5060108");
        putImportProviderBindPath("サービス提供体制強化加算", "5060107", "5060111");

        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "5060106", "5060110");
        putRestrictProviderBindPath("運動機能向上体制", "5060102", "5060106");
        putRestrictProviderBindPath("栄養改善体制", "5060103", "5060107");
        putRestrictProviderBindPath("口腔機能向上体制", "5060104", "5060108");
        putRestrictProviderBindPath("選択的サービス複数実施加算", "5060109", "5060113");

    }

    // コンポーネントイベント

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_50611_201504.class.getName(),
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
        // 要介護認定履歴を取得
        VRList ninteiList = getCalculater().getPatientInsureInfoHistoryList();
        setIsPrintCheckShow(false);
        // 同月内に複数履歴存在する場合
        if (ninteiList.size() > 1) {
            VRMap firstHistory = (VRMap) ninteiList.getData(0);
            VRMap secondHistory = (VRMap) ninteiList.getData(1);
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("JOTAI_CODE", firstHistory), 0)) {
            case 12:
                // 要支援１⇒要支援２
                if (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0) == 13) {
                    setIsPrintCheckShow(true);
                    break;
                }
                break;
            case 13:
                // 要支援２⇒要支援１
                if (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0) == 12) {
                    setIsPrintCheckShow(true);
                    break;
                }
                break;
            }

        }
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
		// 保険者コンボ
		VRList insurerList = QkanCommon.getInsurerInfoCareOnly(getDBManager());
		// 保険者番号を総合事業用のバインドパスへコピー
		ACBindUtilities.copyBindPath(insurerList, "INSURER_ID",
				String.valueOf(SJ_HOKENSHA_NO_BIND_PATH));
		VRBindPathParser.set("INSURER", comboItemMap, insurerList);
		
		// パターン１～５
		comboItemMap.setData("5060112", QkanCommon.getArrayFromMasterCode(290, "5060112"));		

		// ※展開
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();
        
		// 保険者コンボの初期値設定
		String insurerId = getInitialInsurerId();

		// 取得した保険者番号に該当する保険者が存在する場合
		VRMap item = (VRMap) getInsurerName().getDataFromBindPath(insurerId);

		// 保険者名コンボの該当保険者を選択状態にする。
		getInsurerName().setSelectedItem(item);
        
        // パターン1を選択状態にする。
		getServicePattern().setSelectedIndex(0);

        // ※選択項目の初期設定
        // ※準備
        // 初期選択設定用のレコード defaultMap を生成する。
        VRMap defaultMap = new VRHashMap();
        // ※設定
        // ラジオの初期選択を行う。※selectFirstRadioItem(getThis())
        QkanCommon.selectFirstRadioItem(getThis());
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();
        // 画面状態を設定する。
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
            // 職員の欠員による減算の状況（事業所パネル）KEY：5060101の値をチェックする。
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("5060101", provider), 0)) {
            case 1:
                // 人員減算が1（なし）だった場合
                // defaultMapに KEY：5060103 VALUE：1（なし）を設定する。
                VRBindPathParser.set("5060103", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
                // 値が2（看護・介護職員が欠員）だった場合
                // defaultMapに KEY：5060103 VALUE：3（看護・介護職員が欠員）を設定する。
                VRBindPathParser.set("5060103", defaultMap, new Integer(3));
                break;
            }

            // 生活機能向上グループ活動加算関連の初期化
            if (ACCastUtilities.toInt(
                    VRBindPathParser.get("5060102", provider), 1) > 1
                    || ACCastUtilities.toInt(
                            VRBindPathParser.get("5060103", provider), 1) > 1
                    || ACCastUtilities.toInt(
                            VRBindPathParser.get("5060104", provider), 1) > 1
                    || ACCastUtilities.toInt(
                            VRBindPathParser.get("5060109", provider), 1) > 1) {
                // サービスの生活機能向上グループ活動加算関連の初期化
                VRBindPathParser.set("5060105", defaultMap, new Integer(1));
            }

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

            // 画面状態を設定する。
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
        // 保険者名のチェック
        // ・kaigoInfoInsurerName（保険者名）
        // 選択されているかどうか
        if (!getInsurerName().isSelected()) {
            // 選択されていない場合
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT("保険者");
            return null;
        }
        // ※時刻コンボチェック
        if (!getHoumonKaigoBeginTime().isValidDate()
                || (!getHoumonKaigoEndTime().isValidDate())) {
            // 開始時刻コンボ(houmonKaigoBeginTime)と終了時刻コンボ(houmonKaigoEndTime)のいずれかが空欄もしくは不正の場合
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
        // 要支援１・２の場合、非活性のためdata設定されない。回数チェックができなくなるのでここで設定をする。
        VRBindPathParser.set("5060101", data, getPreventiveExpertPlaceCareServiceRadio().getSelectedIndex());
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
        return getHoumonKaigoBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return getHoumonKaigoEndTime();
    }

    /**
     * 「画面状態制御」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkState() throws Exception {

        // 日割チェック
        checkOnDayCheckState();

        // 加算関連の制御処理
        // 生活機能向上加算がついた場合
        if (getActivityAddRadio().getSelectedIndex() > 1) {
            setState_INVALID_MOVE_FUNCTION_ADD();
            setState_INVALID_NOURISHMENT_ADD();
            setState_INVALID_MOUTH_ADD();
            setState_INVALID_SENTAKU_ADD();
        } else {
            setState_VALID_MOVE_FUNCTION_ADD();
            setState_VALID_NOURISHMENT_ADD();
            setState_VALID_MOUTH_ADD();
            setState_VALID_SENTAKU_ADD();
        }

        // 運動器機能向上加算・栄養改善加算・口腔機能向上加算のいづれかがついた場合
        if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1
                || getNourishmentImprovementAddRadio().getSelectedIndex() > 1
                || getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1
                || getSentakutekiServiceRadio().getSelectedIndex() > 1) {
            setState_INVALID_ACTIVITY_ADD();
        } else {
            setState_VALID_ACTIVITY_ADD();
        }
        
        // 運動器機能向上加算・栄養改善加算・口腔機能向上加算の組み合わせチェック
        if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1
        		&& getNourishmentImprovementAddRadio().getSelectedIndex() > 1
        		&& getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	// 運動器機能向上加算 + 栄養改善加算 + 口腔機能向上加算：選択的サービス複数実施加算II
        	getSentakutekiServiceRadio().setSelectedIndex(5);
        } else if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1
        		&& getNourishmentImprovementAddRadio().getSelectedIndex() > 1) {
        	// 運動器機能向上加算 + 栄養改善加算：選択的サービス複数実施加算I1
        	getSentakutekiServiceRadio().setSelectedIndex(2);
        } else if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1
        		&& getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	// 運動器機能向上加算 + 口腔機能向上加算：選択的サービス複数実施加算I2
        	getSentakutekiServiceRadio().setSelectedIndex(3);
        } else if (getNourishmentImprovementAddRadio().getSelectedIndex() > 1
        		&& getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	// 栄養改善加算 + 口腔機能向上加算：選択的サービス複数実施加算I3
        	getSentakutekiServiceRadio().setSelectedIndex(4);
        } else {
        	// 選択的サービス複数実施加算：なし
        	getSentakutekiServiceRadio().setSelectedIndex(1);
        }
        
// 2016/7/13 [Yoichiro Kamei] add - begin 総合事業対応
        //要介護認定履歴が１つのみで、要支援１、または要支援２の場合
        //通所型サービス費は選択不可とする
        setState_VALID_SERVICE();
        VRList ninteiList = getCalculater().getPatientInsureInfoHistoryList();
        if (ninteiList.size() == 1) {
            VRMap ninteiHistory = (VRMap) ninteiList.getData(0);
            int jotaiCode = ACCastUtilities.toInt(
                    VRBindPathParser.get("JOTAI_CODE", ninteiHistory), 0);
            if (12 == jotaiCode) {
                getPreventiveExpertPlaceCareServiceRadio().setSelectedIndex(1);
                setState_INVALID_SERVICE();
            } else if (13 == jotaiCode) {
            	getPreventiveExpertPlaceCareServiceRadio().setSelectedIndex(2);
            	setState_INVALID_SERVICE();
            }
        }
// 2016/7/13 [Yoichiro Kamei] add - end

        // 事業所体制と同期
        resetStateByRestrictBindPath();
    }

    /**
     * 値バインド後処理
     * 
     */
    public void binded() throws Exception {
        // サービスパネルデータバインド直後のパネルデータの編集処理
        if (this.getParent() instanceof ACPanel) {
            ACPanel panel = (ACPanel) this.getParent();
            // Mapが取れた場合
            if (panel.getSource() instanceof VRMap) {
                VRMap source = (VRMap) panel.getSource();

                /*
                 * バージョンアップ直後の、本票に印字しないチェックにデータがない場合の処理
                 */
                if (getIsPrintCheckShow() && !source.containsKey("15")
                        && getCrackOnDayCheck().isSelected()) {
                    // 表示されているにも関わらず、KEYがないならば選択状態にする
                    getPrintable().setSelected(true);
                }
            }
        }

        // [ID:0000713][Masahiko.Higuchi] 2012/03 平成24年4月法改正対応 add begin
        // 生活機能向上グループ活動加算がありである場合
        if (getActivityAddRadio().getSelectedIndex() > 1) {
            // なしに戻す
            getMoveFunctionImprovementAddRadio().setSelectedIndex(1);
            getNourishmentImprovementAddRadio().setSelectedIndex(1);
            getMouthFunctionImprovementAddRadio().setSelectedIndex(1);
            getSentakutekiServiceRadio().setSelectedIndex(1);
        }
        // [ID:0000713][Masahiko.Higuchi] 2012/03 平成24年4月法改正対応 add end

        // 画面状態を設定する。
        checkState();
    }

    /**
     * 日割チェック時の画面制御処理です。
     * 
     */
    public void checkOnDayCheckState() throws Exception {
        if (getCrackOnDayCheck().getValue() == 2) {
            // 無効にするのを止める
            setState_DAY_CHECK_ON();
        } else {
            setState_DAY_CHECK_OFF();
        }
    }

    /**
     * 画面状態制御
     * 
     */
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        // 画面状態制御
        checkOnDayCheckState();

    }

    /**
     * 運動器機能向上加算
     */
    protected void moveFunctionImprovementAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 画面状態制御
        checkState();

    }

    /**
     * 栄養改善加算
     */
    protected void nourishmentImprovementAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 画面状態制御
        checkState();

    }

    /**
     * 口腔機能向上加算
     */
    protected void mouthFunctionImprovementAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 画面状態制御
        checkState();

    }

    /**
     * 生活機能向上グループ活動加算
     */
    protected void activityAddRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // 画面状態制御
        checkState();

    }

    /**
     * 選択的サービス複数実施加算
     */
    protected void sentakutekiServiceRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        int idx = getSentakutekiServiceRadio().getSelectedIndex();
        // 画面状態制御
        checkState();
        // 全て「なし」か１つだけ選択の場合は、選択したものに戻す
        int selCnt = 0;
        if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	selCnt = selCnt + 1;
        }
        if (getNourishmentImprovementAddRadio().getSelectedIndex() > 1) {
        	selCnt = selCnt + 1;
        }
        if (getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	selCnt = selCnt + 1;
        }
        if (selCnt == 1 || selCnt == 0) {
        	getSentakutekiServiceRadio().setSelectedIndex(idx);
        }

    }

    /**
     * 回数チェック時の画面制御処理です。
     * 
     */
	@Override
	protected void crackOnCntCheckActionPerformed(ActionEvent e)
			throws Exception {
        if (getCrackOnCntCheck().getValue() == 2) {
            // 回数チェックONのときは日割は無効
            setState_COUNT_CHECK_OFF();
        } else {
        	setState_COUNT_CHECK_ON();
        }
		
	}
}
