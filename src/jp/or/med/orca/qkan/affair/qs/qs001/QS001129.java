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
 * プログラム サービスパターン地域密着型介護福祉施設 (QS001129)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.beans.DefaultPersistenceDelegate;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;

/**
 * サービスパターン地域密着型介護福祉施設(QS001129)
 */
public class QS001129 extends QS001129Event {
    /**
     * コンストラクタです。
     */
    public QS001129() {
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
        // ※「施設区分」選択時の「病室区分」の状態切替
        // 「施設区分」の値をチェックする。
        switch (getKaigoWelfareFacilityInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // 「介護福祉施設」の場合
            // 「病室区分（介護福祉施設）」を有効にし、「病室区分（ユニット型介護福祉施設）」を無効にする。
            setState_CONVENTIONAL_FORM();
            break;
        case 2:
            // 「ユニット型介護福祉施設」の場合
            // 「病室区分（ユニット型介護福祉施設）」を無効にし、「病室区分（介護福祉施設）」を有効にする。
            setState_UNIT_FORM();
            if (getInvalidUnitCareProvider()) {
                setState_VALID_UNIT_CARE();
            }
            break;
        }
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

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001129.class.getName(), param));
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
        comboItemMap.setData("1510120", QkanCommon.getArrayFromMasterCode(191,
                "1540120"));
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
        if(isOldFacilityUser()){
            VRBindPathParser.set("8",defaultMap,new Integer(2));
        } else {
            VRBindPathParser.set("8",defaultMap,new Integer(1));
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
            VRMap defaultMap = new VRHashMap();
            // ※設定
            // 旧措置入所者である場合
            if (isOldFacilityUser()) {
                // サービスコード上経過的チェックは必須のため固めた上でチェック状態にする。
                setState_INVALID_PASSAGE_REGION();
                VRBindPathParser.set("1540102", defaultMap, new Integer(2));
            } else {
                setState_VALID_PASSAGE_REGION();
                // 経過的地域密着
                VRBindPathParser.set("1540102", defaultMap, VRBindPathParser.get(
                        "1540102", provider));
                //旧措置チェックが選択状態だった場合
                if(getKaigoWelfareFacilityOldMeasuresPerson().isSelected()){
                    setState_INVALID_PASSAGE_REGION();
                }
            }
            
            
            // ユニットケアの整備
            VRBindPathParser.set("1540105", defaultMap, VRBindPathParser.get(
                    "1540113", provider));
            // 夜間勤務減算
            VRBindPathParser.set("1540107", defaultMap, VRBindPathParser.get(
                    "1540103", provider));
            // 個別機能訓練指導加算
            VRBindPathParser.set("1540108", defaultMap, VRBindPathParser.get(
                    "1540104", provider));
            // 医師常勤加算
            VRBindPathParser.set("1540109", defaultMap, VRBindPathParser.get(
                    "1540105", provider));
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

            // 重度化対応加算
            VRBindPathParser.set("1540122", defaultMap, VRBindPathParser.get(
                    "1540115", provider));
            
            // 身体拘束未実施減算
            obj = VRBindPathParser.get("1540116", provider);
            if(obj != null){
            	switch(ACCastUtilities.toInt(obj)){
            	case 1:		// 身体拘束廃止取組がない場合
            		VRBindPathParser.set("1540123", defaultMap, new Integer(2));
            		break;
            	case 2:		// 身体拘束廃止取組がある場合
            		VRBindPathParser.set("1540123", defaultMap, new Integer(1));
            		break;
            	}
            }

            // 準ユニットケア
            obj = VRBindPathParser.get("1540114", provider);
            if (obj != null) {
                VRBindPathParser.set("1540106", defaultMap, obj);
            }

            // 栄養管理体制加算
            obj = VRBindPathParser.get("1540108", provider);
            if (obj != null) {
//                if (new Integer(2).equals(ACCastUtilities.toInteger(obj))) {
//                    VRBindPathParser.set("1540114", defaultMap, new Integer(3));
//                } else if (new Integer(3)
//                        .equals(ACCastUtilities.toInteger(obj))) {
//                    VRBindPathParser.set("1540114", defaultMap, new Integer(2));
//                }
                switch (ACCastUtilities.toInt(obj)) {
				case 3:
					// 「管理栄養士」の場合
					VRBindPathParser.set("1540114", defaultMap, new Integer(2));
					break;
				case 2:
					// 「栄養士」の場合
					// 有効にする。
					// setState_VALID_DIETICIAN_MANAGE();
					VRBindPathParser.set("1540114", defaultMap, new Integer(3));
					break;
				case 1:
					// 「なし」の場合
					// 無効にする。
					// setState_INVALID_DIETICIAN_MANAGE();
					VRBindPathParser.set("1540114", defaultMap, new Integer(1));
					break;
				}
            }
            
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // ユニットケアの整備
            obj = VRBindPathParser.get("1540113", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    if (getKaigoWelfareFacilityInstitutionDivisionRadioItem3()
                            .isSelected()) {
                        setState_VALID_UNIT_CARE();
                    }
                    setInvalidUnitCareProvider(true);
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_UNIT_CARE();
                    setInvalidUnitCareProvider(false);
                    break;
                }
            } else {
                // 「なし」の場合
                // 無効にする。
                setState_INVALID_UNIT_CARE();
                setInvalidUnitCareProvider(false);
            }
            // 個別機能訓練指導加算
            obj = VRBindPathParser.get("1540104", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_FUNCTION_TRAINING();
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_FUNCTION_TRAINING();
                    break;
                }
            }
            // 医師常勤加算
            obj = VRBindPathParser.get("1540105", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_DOCTOR();
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_DOCTOR();
                    break;
                }
            }

            // 精神科医指導加算
            obj = VRBindPathParser.get("1540106", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_PSYCHIATRIST();
                    VRBindPathParser.set("1540110", defaultMap, obj);
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_PSYCHIATRIST();
                    VRBindPathParser.set("1540110", defaultMap, obj);	
                    break;
                }
            }

            // 障害者生活援助員常勤加算
            obj = VRBindPathParser.get("1540107", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_HANDICAPPED();
                    VRBindPathParser.set("1540111", defaultMap, obj);	
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_HANDICAPPED();
                    VRBindPathParser.set("1540111", defaultMap, obj);	
                    break;
                }
            }

            // 栄養マネジメント加算
            obj = VRBindPathParser.get("1540109", provider);
            if (obj != null) {
                // VRBindPathParser.set("1540114",defaultMap,obj);
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_NUTRITION();
                    VRBindPathParser.set("1540115", defaultMap, obj);	
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_NUTRITION();
                    VRBindPathParser.set("1540115", defaultMap, obj);	
                    break;
                }
            }

            // 経口移行加算
            obj = VRBindPathParser.get("1540110", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_ORAL_SWITCH();
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_ORAL_SWITCH();
                    break;
                }
            }

            // 療養食加算
            obj = VRBindPathParser.get("1540111", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_MEDICAL_EXPENSES();
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_MEDICAL_EXPENSES();
                    break;
                }
            }

            // 重度化対応加算
            obj = VRBindPathParser.get("1540115", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_HEAVILY();
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_HEAVILY();
                    break;
                }
            }
            
            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();

            if(getKaigoWelfareFacilityDinnerOffer().getSelectedIndex()==0){
                //食費なしの場合にのみ朝昼夜にする。
                getKaigoWelfareFacilityDinnerOffer().setSelectedIndex(1);
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
        if (getKaigoWelfareFacilityTakingCareNursingAddDays().isEnabled()) {
            int days = ACCastUtilities
                    .toInt(getKaigoWelfareFacilityTakingCareNursingAddDays()
                            .getText(), 99);
            if ((days > 30) || (days < 1)) {
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
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1540117", getSelectedProvider()), 0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1540118", getSelectedProvider()), 0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1540119", getSelectedProvider()), 0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1540120", getSelectedProvider()), 0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1540118", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1540119",
                                getSelectedProvider()), 0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1540119", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1540120",
                                getSelectedProvider()), 0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1540120", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1540118",
                                getSelectedProvider()), 0));
            }
        }
        // 空文字を返す。
        return "";
    }

    /**
     * 「看取り介護の有効状態」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoWelfareFacilityTakingCareNursingAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        if (getKaigoWelfareFacilityTakingCareNursingAddRadioItem1()
                .isSelected()) {
            setState_INVALID_TERMINAL();
        } else {
            setState_VALID_TERMINAL();
        }
    }

    /**
     * 「経口移行加算の変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoWelfareFacilityOralSwitchRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 経口移行加算
        if (getKaigoWelfareFacilityOralSwitchRadioItem1().isSelected()) {
            setState_VALID_KEEP_NUTRITION();
        } else {
            setState_INVALID_KEEP_NUTRITION();
        }
    }

    /**
     * 「経口維持加算の変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void kaigoWelfareFacilityJunOralSwitchRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 経口維持加算
        if (getKaigoWelfareFacilityJunOralSwitchRadioItem1().isSelected()) {
            setState_VALID_ORAL_SWITCH();
        } else {
            setState_INVALID_ORAL_SWITCH();
        }
    }

    /**
     * 「旧措置入所者チェック」イベントです。
     */
    protected void kaigoWelfareFacilityOldMeasuresPersonActionPerformed(ActionEvent e) throws Exception {
        //旧措置入所者だった場合
        if(getKaigoWelfareFacilityOldMeasuresPerson().isSelected()){
        //経過的地域密着型サービスの状態をチェックする。
            if(getPassageRegionServiceCheck().isEnabled()){
            //Enableがtrueだった場合
                //画面の状態を変更する。
                setState_INVALID_PASSAGE_REGION();
            }
        }else{
            //画面の状態を変更する。
            setState_VALID_PASSAGE_REGION();
        }
    }

    /**
     * データバインド時の処理
     */
    public void binded() throws Exception {
        //旧措置チェックが選択状態だった場合
        if(getKaigoWelfareFacilityOldMeasuresPerson().isSelected()){
            setState_INVALID_PASSAGE_REGION();
        }else{
            setState_VALID_PASSAGE_REGION();
        }
        
    }
        
}
