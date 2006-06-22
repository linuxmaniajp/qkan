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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/02/23  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン居宅介護支援 (QS001117)
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
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRComboBoxModelAdapter;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * サービスパターン居宅介護支援(QS001117)
 */
public class QS001117 extends QS001117Event {
    /**
     * コンストラクタです。
     */
    public QS001117() {
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

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001117.class.getName(), param));
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
        // 食事提供
        VRBindPathParser.set("1230406", defaultMap, new Integer(1));
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();

        getKaigoSupportSpecialMemberNumber().setText("");
    }
    
    public void binded()throws Exception{
        super.binded();
        ComboBoxModel mdl = getKaigoSupportSpecialMemberName().getModel();
        VRBindSource src=null;
        if(mdl instanceof VRComboBoxModelAdapter){
            src = ((VRComboBoxModelAdapter)mdl).getAdaptee();
        }
        if (src instanceof VRList) {
            int idx = ACBindUtilities.getMatchIndexFromValue(
                    (VRList)src, "CARE_MANAGER_NO",
                    getKaigoSupportSpecialMemberNumber().getText());
            if(idx>=0){
                getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
            }
        }
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
            VRMap defaultMap = new VRHashMap();
            // ※設定
            Object obj;
            // 区分
            obj = VRBindPathParser.get("1430101", provider);
            if (obj != null) {
                VRBindPathParser.set("1430103", defaultMap, obj);
            }
            // 特定事業所集中減算
            obj = VRBindPathParser.get("1430102", provider);
            if (obj != null) {
                VRBindPathParser.set("1430104", defaultMap, obj);
            }
            // 特定事業所加算
            obj = VRBindPathParser.get("1430103", provider);
            if (obj != null) {
                VRBindPathParser.set("1430106", defaultMap, obj);
                if(ACCastUtilities.toInt(obj)==1){
                    setTokuteiAddFlag(false);
                }else if(ACCastUtilities.toInt(obj)==2){
                    setTokuteiAddFlag(true);
                }
            }

            // 介護支援専門員コンボ
            VRMap sqlParam = new VRHashMap();
            VRBindPathParser.set("PROVIDER_ID", sqlParam, VRBindPathParser.get(
                    "PROVIDER_ID", provider));

            VRList staffs =getDBManager().executeQuery(
                    getSQL_GET_CARE_MANAGER(sqlParam)); 
            Iterator it=staffs.iterator();
            while(it.hasNext()){
                Map staff=(Map)it.next();
                staff.put("STAFF_NAME", QkanCommon.toFullName(staff
                        .get("STAFF_FAMILY_NAME"), staff
                        .get("STAFF_FIRST_NAME")));
            }
            
            getKaigoSupportSpecialMemberName().setModel(
                    staffs);
            // 担当者姓(STAFF_FAMILY_NAME)と担当者名(STAFF_FIRST_NAME)を結合し、コンボに表示する。

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。


            
            if (staffs instanceof VRList) {
                int idx = ACBindUtilities.getMatchIndexFromValue(
                        staffs, "CARE_MANAGER_NO",
                        getKaigoSupportSpecialMemberNumber().getText());
                if(idx>=0){
                    getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
                }
            }
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
        QkanCommon.removeDisabledBindPath(getThis(), data);
        if (ACTextUtilities.isNullText(getKaigoSupportSpecialMemberNumber()
                .getText())) {
            data.remove(getKaigoSupportSpecialMemberNumber().getBindPath());
        }
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
     * 特定施設集中減算ラジオ選択時
     */
    protected void kaigoSupportSpecificProviderSubtractionRadioActionPerformed(
            ActionEvent e) throws Exception {
        changeState();
    }

    /**
     * 特定事業所加算ラジオ選択時
     */
    protected void kaigoSupportSpecificStandardRadioActionPerformed(
            ActionEvent e) throws Exception {
        changeState();
    }

    /**
     * 運営環境基準減算選択時
     */
    protected void kaigoSupportManagementBasicRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        changeState();
    }
    
    /**
     * 支援費区分選択時
     */
    protected void kaigoSupportDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception {     
        changeState();
    }
    
    /**
     * 画面状態の制御に関する処理
     * @throws Exception
     */
    protected void changeState()throws Exception{
        //支援費区分に関わる画面制御
        switch(getKaigoSupportDivisionRadio().getSelectedIndex()){
        case 2://II型
        case 3://III型
            //環境減算がなし以外だった場合
            if (getKaigoSupportManagementBasicRadio().getSelectedIndex() == 2
                    || getKaigoSupportManagementBasicRadio()
                            .getSelectedIndex() == 3) {
                setState_STATE_MODE1();
            }else{
                setState_STATE_MODE2();

            }
            break;
        case 1://I型
        case 4://経過的要介護
            //環境減算がなし以外だった場合
            if (getKaigoSupportManagementBasicRadio().getSelectedIndex() == 2
                    || getKaigoSupportManagementBasicRadio()
                            .getSelectedIndex() == 3) {
                setState_STATE_MODE1();
            }else{
                //事業所集中減算なしだった場合
                if(getKaigoSupportSpecificProviderSubtractionRadioItem1().isSelected()){
                    //特定事業所加算ありだった場合
                    if(getKaigoSupportSpecificStandardRadioItem2().isSelected()){
                        setState_STATE_MODE4();
                    }else{
                        setState_STATE_MODE5();
                    }
                }else{
                    setState_STATE_MODE2();
                }
            }            
            break;
        }
        //特定事業所加算体制がない場合は一律無効にする
        if(!getTokuteiAddFlag()){
            setState_PROVIDER_ADD_OFF();
        }
    }

    
}
