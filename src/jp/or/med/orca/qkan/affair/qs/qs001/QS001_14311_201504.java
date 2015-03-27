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
 * プログラム サービスパターン居宅介護支援 (QS001_14311_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRComboBoxModelAdapter;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * サービスパターン居宅介護支援(QS001_14311_201504)
 */
@SuppressWarnings("serial")
public class QS001_14311_201504 extends QS001_14311_201504Event {
    /**
     * コンストラクタです。
     */
    public QS001_14311_201504() {
        // チェック
        putCheckProviderBindPath("特定事業所加算", "1430104");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("特定事業所加算", "1430104", "1430106");
        putImportProviderBindPath("特定事業所集中減算", "1430102", "1430104");// 2015.03.04 add
        
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

    public void binded() throws Exception {
        super.binded();
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
    }

    /**
     * 「運営環境基準減算選択時」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoSupportManagementBasicRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 運営環境基準減算選択時
        changeState();

    }

    /**
     * 「支援費区分選択時」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoSupportDivisionRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 支援費区分選択時
        changeState();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_14311_201504.class.getName(),
                param));
    }

    // 内部関数

    /**
     * 「初期化」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void initialize() throws Exception {
        // ※画面初期化処理
        // ※コンボアイテムの設定
        // 　※準備
        // 　　コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // 　※設定
        // 　※展開
        // 　　自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // 　　コンボアイテムを展開する。
        getThis().bindModelSource();
        // ※選択項目の初期設定
        // 　※準備
        // 　　初期選択設定用のレコード defaultMap を生成する。
        VRMap defaultMap = new VRHashMap();
        // 　※設定
        // 　※展開
        // 　　自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 　　初期選択項目を展開する。
        getThis().bindSource();

        QkanCommon.selectFirstRadioItem(this);

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

            // 特別地域加算を取得する
            obj = VRBindPathParser.get("SPECIAL_AREA_FLAG", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 1) {
                    setTokuteiAddFlag(false);
                } else if (ACCastUtilities.toInt(obj) == 2) {
                    setTokuteiAddFlag(true);
                }
            }

            // 中山間地域事業所であるかの判定ロジック
            String providerID = ACCastUtilities.toString(
                    ((VRMap) provider).getData("PROVIDER_ID"), "");
            //
            VRList serviceInfo = QkanCommon.getProviderServiceDetail(
                    getDBManager(), providerID,
                    ACCastUtilities.toInt("14311", 0));

            if (serviceInfo != null && serviceInfo.getData(0) instanceof VRMap) {
                VRMap providerServiceInfo = (VRMap) serviceInfo.getData(0);
                // 中山間地域等の小規模事業所である場合
                if (CareServiceCommon.isMountainousArea(providerServiceInfo)) {
                    setIsMountainousAreaProvider(true);
                } else {
                    setIsMountainousAreaProvider(false);
                }
            } else {
                // 中山間地域等の小規模事業所ではない
                setIsMountainousAreaProvider(false);
            }

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 介護支援専門員コンボ
            VRMap sqlParam = new VRHashMap();
            VRBindPathParser.set("PROVIDER_ID", sqlParam,
                    VRBindPathParser.get("PROVIDER_ID", provider));

            VRList staffs = getDBManager().executeQuery(
                    getSQL_GET_CARE_MANAGER(sqlParam));
            Iterator<Map<String, String>> it = staffs.iterator();
            while (it.hasNext()) {
                Map<String, String> staff = it.next();
                staff.put("STAFF_NAME", QkanCommon.toFullName(
                        staff.get("STAFF_FAMILY_NAME"),
                        staff.get("STAFF_FIRST_NAME")));
            }

            getKaigoSupportSpecialMemberName().setModel(staffs);

            if (staffs instanceof VRList) {
                int idx = ACBindUtilities.getMatchIndexFromValue(staffs,
                        "CARE_MANAGER_NO", getKaigoSupportSpecialMemberNumber()
                                .getText());
                if (idx >= 0) {
                    getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
                }
            }

        }
        // 画面状態制御
        changeState();
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
        // 　自身(this)のソースとして生成レコードを設定する。
        getThis().setSource(data);
        // 　自身(this)のapplySourceを呼び出してデータを収集する。
        getThis().applySource();
        // ※返却用レコードから不要なキーを除去
        // ※返却用レコードから不要なキーを除去
        QkanCommon.removeDisabledBindPath(getThis(), data);
        if (ACTextUtilities.isNullText(getKaigoSupportSpecialMemberNumber()
                .getText())) {
            data.remove(getKaigoSupportSpecialMemberNumber().getBindPath());
        }
        // 　問題なければ返却用レコード(data)を返す。
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
     * 画面状態制御を行います。
     * 
     */
    public void changeState() throws Exception {
        if (getKaigoSupportDivisionRadio().getSelectedIndex() == 3) {
            // 運営基準減算
            if (getKaigoSupportManagementBasicRadio().getSelectedIndex() == 2) {
                boolean isSyucyu = false;
                // 月末時点の要介護認定履歴を取得
                Date endDate = ACDateUtilities.toLastDayOfMonth(getCalculater()
                        .getTargetDate());
                VRMap ninteiMap = getCalculater()
                        .getPatientInsureInfoOnTargetDay(endDate);

                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", ninteiMap), 0)) {
                case 12: // 要支援の場合 月初を参考に
                case 13:
                    Date firstDate = ACDateUtilities
                            .toFirstDayOfMonth(getCalculater().getTargetDate());
                    ninteiMap = getCalculater()
                            .getPatientInsureInfoOnTargetDay(firstDate);
                    break;
                }
                // 最終判定処理
                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", ninteiMap), 0)) {
                case 12: // 要支援の場合 月初を参考に
                case 13:
                    break;
                case 21: // 要介護1-2
                case 22:
                    break;
                case 23: // 要介護3-5
                case 24:
                case 25:
                    // 特別地域・中山間地域の場合
                    if (getTokuteiAddFlag() || getIsMountainousAreaProvider()) {
                        isSyucyu = true;
                    } else {
                        // 通常の場合
                        // 中山間地域等でのサービス提供がありの場合
                        if (getProviderAddMountainousAreaRafioRadioGroup()
                                .getSelectedIndex() == 2) {
                            isSyucyu = true;
                        }
                    }
                    break;
                }

                // 集中減算が使えるかいなか
                if (isSyucyu) {
                    setState_PROVIDER_CUT_ON();
                } else {
                    setState_PROVIDER_CUT_OFF();
                }
            } else {
                setState_PROVIDER_CUT_ON();
            }
        } else {
            setState_PROVIDER_CUT_ON();
        }

        // 運営基準減算による初回加算の制御
        switch (getKaigoSupportManagementBasicRadio().getSelectedIndex()) {
        case 1:
            // 退院・退所時加算がなしであれば有効にする
            if (getDischargeAddRadio().getSelectedIndex() == 1) {
                setState_VALID_SYOKAI_ADD();
            }
            break;
        case 2:
        case 3:
            setState_INVALID_SYOKAI_ADD();
            break;
        }

        resetStateByRestrictBindPath();
    }

    /**
     * 退院・退所加算の画面制御処理
     */
    protected void dischargeAddRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        if (getDischargeAddRadio().getSelectedIndex() == 1) {
            // 運営基準減算による初回加算の制御
            if (getKaigoSupportManagementBasicRadio().getSelectedIndex() == 1) {
                setState_VALID_SYOKAI_ADD();
            }
        } else {
            setState_INVALID_SYOKAI_ADD();
        }

    }

    /**
     * 初回加算選択時の画面制御処理
     */
    protected void kaigoSupportStandardRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        if (getKaigoSupportStandardRadio().getSelectedIndex() == 1) {
            setState_VALID_TAIIN_ADD();
        } else {
            setState_INVALID_TAIIN_ADD();
        }

    }

    protected void providerAddMountainousAreaRafioRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 画面状態を制御する。
        changeState();

    }
}
