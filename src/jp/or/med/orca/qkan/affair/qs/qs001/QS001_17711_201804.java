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
 * 開発者: 上司和善
 * 作成日: 2011/12/12  日本コンピューター株式会社 上司和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン看護小規模多機能型居宅介護 (QS001_17711_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ComboBoxModel;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
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
 * サービスパターン複合型サービス（看護小規模多機能型居宅介護・短期利用以外）(QS001_17711_201804)
 */
public class QS001_17711_201804 extends QS001_17711_201804Event {
    /**
     * コンストラクタです。
     */
    public QS001_17711_201804() {
        // 必須の事業所設定項目
        putCheckProviderBindPath("職員の欠員による減算の状況", "1770101");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("サービス提供強化加算", "1770104", "1770111");
        putImportProviderBindPath("訪問看護体制減算", "1770106", "1770118");
        putImportProviderBindPath("訪問看護体制強化加算", "1770107", "1770119");
        putImportProviderBindPath("総合マネジメント体制強化加算", "1770108", "1770120");
        putImportProviderBindPath("サテライト体制", "1770110", "1770121"); //[H30.4改正]
        putImportProviderBindPath("訪問体制強化加算", "1770112", "1770124"); //[H30.4改正]

        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("特別管理体制", "1770102", "1770109");
        putRestrictProviderBindPath("ターミナルケア体制", "1770103", "1770110");
        putRestrictProviderBindPath("緊急時訪問看護加算", "1770105", "1770108");
        putRestrictProviderBindPath("若年性認知症利用者受入加算", "1770111", "1770122"); //[H30.4改正]
    }

    // コンポーネントイベント

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_17711_201804.class.getName(),
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
        // 市町村独自加算
        comboItemMap.setData("1770112",
                QkanCommon.getArrayFromMasterCode(284, "1770112"));
        
        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
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
        // ※以下の内容詳細項目は、選択事業所の値を設定する。
        
        if (provider == null) {
            return;
        }

        Object obj;
        VRMap defaultMap = getImportData();

        // 人員減算
        obj = VRBindPathParser.get("1770101", provider);
        if (obj != null) {
            switch (ACCastUtilities.toInt(obj)) {
            case 1: // なし
                VRBindPathParser.set("1770101", defaultMap, new Integer(1));
                break;
            case 2: // 看護職員
            case 3: // 介護職員
                VRBindPathParser.set("1770101", defaultMap, new Integer(3));
                break;
            }
        }
        
        if (VRBindPathParser.get("1770112", provider) == null) {
            VRBindPathParser.set("1770112", defaultMap, new Integer(1));
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
        
        // 展開
        getThis().setSource(defaultMap);
        getThis().bindSource();
        
        if (staffs instanceof VRList) {
            int idx = ACBindUtilities.getMatchIndexFromValue(staffs,
                    "CARE_MANAGER_NO", getKaigoSupportSpecialMemberNumber()
                            .getText());
            if (idx >= 0) {
                getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
            }
        }
        
        checkOnDayCheckState();
        
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
            // 8桁以外の場合
            if (val != null && val.length() != 8) {
                QkanMessageList.getInstance().QS001_ERROR_OF_TEKIYOU_INPUT_8();
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
        return getHomonNyuyokuBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return getHomonNyuyokuEndTime();
    }

    @Override
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        checkOnDayCheckState();
    }
    
    /**
     * 値をバインドした際の処理です。
     * 
     * @exception Exception 処理例外
     */
    public void binded() throws Exception {
        
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
        
        // 画面状態制御
        checkOnDayCheckState();
        
    }
    
    

    @Override
    public void checkOnDayCheckState() throws Exception {
        if (getCrackOnDayCheck().isEnabled()
                && getCrackOnDayCheck().isSelected()) {
            // 日割チェックが有りの場合
            setState_DAY_CHECK_ON();
        } else {
            // 日割チェックが無しの場合
            setState_DAY_CHECK_OFF();
        }
    }

    /**
     * 「介護支援専門員番号の表示」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    @Override
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

}
