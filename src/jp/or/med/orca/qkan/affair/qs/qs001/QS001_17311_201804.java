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
 * プログラム サービスパターン小規模多機能型介護 (QS001_17311_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRComboBoxModelAdapter;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン小規模多機能型介護(QS001_17311_201804)
 */
@SuppressWarnings("serial")
public class QS001_17311_201804 extends QS001_17311_201804Event {
    /**
     * コンストラクタです。
     */
    public QS001_17311_201804() {
        // チェック
        putCheckProviderBindPath("介護職員処遇改善加算", "4");
        
    	// 値を転記する事業所設定項目
        putImportProviderBindPath("看護職員配置加算", "1730102", "1730108");
        putImportProviderBindPath("サービス提供体制強化加算", "1730103", "1730110");
        // 2015.03.06 del putImportProviderBindPath("看取り連携体制加算", "1730106", "1730113");
        putImportProviderBindPath("訪問体制強化加算", "1730107", "1730114");
        putImportProviderBindPath("総合マネジメント体制強化加算", "1730108", "1730115");
        
        
        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "1730109", "1730117"); //[H30.4改正]
    }

    // コンポーネントイベント

    /**
     * 「介護支援専門員番号の表示」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoSupportSpecialMemberNameActionPerformed(ActionEvent e)
            throws Exception {
        // ※介護支援専門員番号の表示
        if (getKaigoSupportSpecialMemberName().isSelected()) {
            // コンボで選択されているデータを取得
            VRMap data = (VRMap) getKaigoSupportSpecialMemberName()
                    .getSelectedModelItem();

            // 取得データより介護支援専門員番号を取得し、表示
            getKaigoSupportSpecialMemberNumber().setText(
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "CARE_MANAGER_NO", data)));
        }

    }

    /**
     * 「算定区分の変更」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void calculationDivisionSelectionChanged(ListSelectionEvent e) throws Exception{
    	checkState();
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_17311_201804.class.getName(),
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
            case 13:

                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0)) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                    // 要支援⇒要介護
                    setIsPrintCheckShow(true);
                }
                break;

            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                // 同一の認定履歴の変化の場合
                if (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", firstHistory), 0) == ACCastUtilities
                        .toInt(VRBindPathParser
                                .get("JOTAI_CODE", secondHistory), 0)) {
                    setIsPrintCheckShow(false);
                    break;
                }
                // 要介護⇒要介護
                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0)) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
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
        // 市町村独自加算
        comboItemMap.setData("1730111",
                QkanCommon.getArrayFromMasterCode(274, "1730111"));
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
        // tekiyouText に ""を設定する。 ※バージョンアップ直後の初期化対策
        getTekiyouText().setText("");
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();

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
            
            // 人員減算
            Object obj;
            obj = VRBindPathParser.get("1730101", provider);
            if (obj != null) {
                // 事業所登録の減算項目に合わせ初期値を調整
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // なしだった場合
                    VRBindPathParser.set("1730102", defaultMap, new Integer(1));
                    break;
                case 2: // 医師だった場合
                case 3: // 看護職員だった場合
                    VRBindPathParser.set("1730102", defaultMap, new Integer(3));
                    break;
                }
            }

            // 市町村独自加算（事業所パネル）KEY：1730104の値をチェックする。
            obj = VRBindPathParser.get("1730104", provider);
            switch (ACCastUtilities.toInt(obj, 0)) {
            // 値が次のいずれかだった場合
            case 2:
                // 2（市町村独自加算１）
            case 3:
                // 3（市町村独自加算２）
            case 4:
                // 4（市町村独自加算３）
            case 5:
                // 5（市町村独自加算４）
            case 6:
                // 6（市町村独自加算５）
            case 7:
                // 7（市町村独自加算６）
            case 8:
                // 8（市町村独自加算７）
            case 9:
                // 9（市町村独自加算８）
            case 10:
                // 10（市町村独自加算９）
            case 11:
                // 11（市町村独自加算１０）
                // defaultMapに KEY：1730111 VALUE：事業所の値を設定する。
                VRBindPathParser.set("1730111", defaultMap, obj);
                break;
            default:
                // 値が上記以外だった場合
                // defaultMapに KEY：1730111 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1730111", defaultMap, new Integer(1));
                break;
            }

            // 介護支援専門員コンボ
            VRMap sqlParam = new VRHashMap();
            VRBindPathParser.set("PROVIDER_ID", sqlParam,
                    VRBindPathParser.get("PROVIDER_ID", provider));

            VRList staffs = getDBManager().executeQuery(
                    getSQL_GET_CARE_MANAGER(sqlParam));
            Iterator it = staffs.iterator();
            while (it.hasNext()) {
                Map staff = (Map) it.next();
                staff.put("STAFF_NAME", QkanCommon.toFullName(
                        staff.get("STAFF_FAMILY_NAME"),
                        staff.get("STAFF_FIRST_NAME")));
            }

            getKaigoSupportSpecialMemberName().setModel(staffs);

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();

            if (staffs instanceof VRList) {
                int idx = ACBindUtilities.getMatchIndexFromValue(staffs,
                        "CARE_MANAGER_NO", getKaigoSupportSpecialMemberNumber()
                                .getText());
                if (idx >= 0) {
                    getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
                }
            }
            // 市町村独自加算が未選択の場合は、最初の項目(なし)を選択する。
            if (getMunicipalityAdd().getSelectedIndex() < 0
                    && getMunicipalityAdd().getItemCount() > 0) {
                getMunicipalityAdd().setSelectedIndex(0);
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
        // 摘要欄の入力チェック
        if (!"".equals(getTekiyouText().getText())) {
            String val = getTekiyouText().getText();
            // 6桁以外の場合
            if (val != null && val.length() != 6) {
                QkanMessageList.getInstance().QS001_ERROR_OF_TEKIYOU_INPUT();
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
        return null;
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return null;
    }

    /**
     * バインド後処理
     */
    public void binded() throws Exception {
        // super.binded();
        ComboBoxModel mdl = getKaigoSupportSpecialMemberName().getModel();
        VRBindSource src = null;
        if (mdl instanceof VRComboBoxModelAdapter) {
            src = ((VRComboBoxModelAdapter) mdl).getAdaptee();
        }
        if (src instanceof VRList) {
            int idx = ACBindUtilities.getMatchIndexFromValue((VRList) src,
                    "CARE_MANAGER_NO", getKaigoSupportSpecialMemberNumber()
                            .getText());
            if (idx >= 0) {
                getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
            }
        }
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
        checkOnDayCheckState();

    }

    /**
     * 日割チェック時の処理
     * 
     * @author Masahiko.Higuchi
     * @since V5.4.9
     */
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        checkOnDayCheckState();

    }

    /**
     * 日割チェック時の画面制御処理です。
     * 
     * @author Masahiko.Higuchi
     * @since V5.4.9
     */
    public void checkOnDayCheckState() throws Exception {
        if (getIsPrintCheckShow()) {
            if (getCrackOnDayCheck().getValue() == 2) {
                // 日割チェックが有りの場合
                setState_DAY_CHECK_ON();
            } else {
                // 日割チェックが無しの場合
                setState_DAY_CHECK_OFF();
            }
        } else {
            setState_DAY_CHECK_OFF();
        }
    }

    /**
     * 画面状態制御
     * 
     * @throws Exception 例外処理
     * @author Masahiko.Higuchi
     * @since V5.4.9
     */
    public void checkState() throws Exception {
    	
    	// 算定区分で「2-加算のみ」が選択されている
    	if (getCalculationDivision().getSelectedIndex() == 2) {
    		setState_VALID_TERMINAL_CARE_INFORMATION();
    		// 看取り連携体制加算が「2-あり」の場合
    		if (getTerminalCareInformationRadioGroup().getSelectedIndex() == 2) {
    			// 看取り連携体制加算日数単位有効
            	setState_VALID_TERMINAL();
    		} else {
    			// 看取り連携体制加算・看取り連携体制加算日数単位無効
            	setState_INVALID_TERMINAL();
    		}
    	} else {
    		// 看取り連携体制加算日数単位無効
    		setState_INVALID_TERMINAL_CARE_INFORMATION();
    		setState_INVALID_TERMINAL();
    	}
    	
    	
        checkOnDayCheckState();
        resetStateByRestrictBindPath();
    }

    /**
     * 「看護職員配置加算選択処理」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
	@Override
    protected void nurseStaffDispositionAddRadioGroupActionPerformed(
    		ActionEvent e) throws Exception{
    	checkState();
    }

    /**
     * 「看取り介護加算の変更」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
	@Override
	protected void terminalCareInformationRadioGroupSelectionChanged(
			ListSelectionEvent e) throws Exception {
		checkState();
	}

}
