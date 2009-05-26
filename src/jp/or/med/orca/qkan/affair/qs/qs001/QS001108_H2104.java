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
 * 作成日: 2009/02/09  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン通所リハ (QS001108_H2104)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
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
import jp.nichicom.ac.component.table.event.*;
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
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * サービスパターン通所リハ(QS001108_H2104)
 */
public class QS001108_H2104 extends QS001108_H2104Event {
    /**
     * コンストラクタです。
     */
    public QS001108_H2104() {
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

    /**
     * 「リハビリ訪問指導等加算の有効チェック」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void houmonRehabilitationTimeContenaFacilityDivisionSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // 施設等の区分変更時の処理
        // 施設等の区分に応じてリハビリ訪問指導等加算の有効チェックを変更する。
        // TODO　事業所の扱いを確認

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001108_H2104.class.getName(),
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
        // ※時間区分
        // コードマスタデータよりCODE_ID：275（時間区分）を取得する。
        // 取得した値を、comboItemMapの KEY : 1160104 の VALUE として設定する。
        comboItemMap.setData("1160104", QkanCommon.getArrayFromMasterCode(275,
                "1160104"));
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
            VRMap defaultMap = new VRHashMap();
            // ※設定
            Object obj;
            // 施設区分
            obj = VRBindPathParser.get("1160112", provider);
            if (obj != null) {
                VRBindPathParser.set("1160116", defaultMap, obj);
            }
            // 入浴加算
            obj = VRBindPathParser.get("1160102", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // 「あり」の場合
                    // houmonRehabilitationBathRadioの2番目のボタンを取得し、有効にする。
                    setState_VALID_ADD_BATH();
                    VRBindPathParser.set("1160105", defaultMap, obj);
                } else {
                    // 「なし」の場合
                    // houmonRehabilitationBathRadioの2番目のボタンを取得し、無効にする。
                    setState_INVALID_ADD_BATH();
                    VRBindPathParser.set("1160105", defaultMap, obj);
                }
            }
            // リハビリ・マネジメント加算
            obj = VRBindPathParser.get("1160107", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしの場合
                    setState_INVALID_REHABILITATION_MANAGEMENT_ADD();
                    break;
                case 2:
                    // 体制ありの場合
                    setState_VALID_REHABILITATION_MANAGEMENT_ADD();
                    VRBindPathParser.set("1160111", defaultMap, obj);
                    break;
                }
            }
            // 栄養マネジメント体制
            obj = VRBindPathParser.get("1160116", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしの場合
                    setState_INVALID_NOURISHMENT_MANAGEMENT();
                    break;
                case 2:
                    // 体制ありの場合
                    setState_VALID_NOURISHMENT_MANAGEMENT();
                    break;
                }
                VRBindPathParser.set("1160114", defaultMap, obj);
            }
            // 口腔機能向上体制
            obj = VRBindPathParser.get("1160109", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // 体制なしの場合
                    setState_INVALID_MOUTH_FUNCTION();
                    break;
                case 2:
                    // 体制ありの場合
                    setState_VALID_MOUTH_FUNCTION();
                    break;
                }
                VRBindPathParser.set("1160115", defaultMap, obj);
            }
            // 人員減算
            obj = VRBindPathParser.get("1160105", provider);
            if (obj != null) {
                //事業所登録の減算項目に合わせ初期値を調整
                switch(ACCastUtilities.toInt(obj)){
                case 1: //なしだった場合
                    VRBindPathParser.set("1160109", defaultMap, new Integer(1));
                    break;
                case 2: //医師だった場合
                case 3: //看護職員だった場合
                case 4: //介護職員だった場合
                case 5: //理学療法士だった場合
                case 6: //作業療法士だった場合
                case 7: //言語聴覚士だった場合
                    VRBindPathParser.set("1160109", defaultMap, new Integer(3));
                    break;
                }
            }
            
            // 認知症短期集中リハビリテーション加算
            obj = VRBindPathParser.get("1160113", provider);
            if (obj != null) {
                VRBindPathParser.set("1160120", defaultMap, obj);
            }
            
            // 若年性認知症利用者
            obj = VRBindPathParser.get("1160114", provider);
            if (obj != null) {
                VRBindPathParser.set("1160121", defaultMap, obj);
            }
            
            // サービス提供体制強化加算
            obj = VRBindPathParser.get("1160115", provider);
            if (obj != null) {
                VRBindPathParser.set("1160122", defaultMap, obj);
            }



            //若年性認知症利用者受入加算（事業所パネル）KEY：1160114の値をチェックする。
            obj = VRBindPathParser.get("1160114", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //値が次のいずれかだった場合
            case 2:
                //2（あり）
                //有効にする。
                setState_VALID_YOUNG_DEMENTIA_PATINET();
                break;
            default:
                //値が上記以外だった場合
                //無効にする。
                setState_INVALID_YOUNG_DEMENTIA_PATINET();
                break;
            }
            //常にdefaultMapに KEY：1160121 VALUE：1（なし）を設定する。
            VRBindPathParser.set("1160121", defaultMap, new Integer(1));   

            
            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            
            // [ID:0000500][Masahiko Higuchi] 2009/05/01 del begin 【サービス予定】通所リハの時間区分を非選択
            // 初期選択
//            if (getHoumonRehabilitationTimeDivision().getItemCount() > 0
//                    && getHoumonRehabilitationTimeDivision().getSelectedIndex() < 0) {
//                getHoumonRehabilitationTimeDivision().setSelectedIndex(0);
//            }
            // [ID:0000500][Masahiko Higuchi] 2009/05/01 del end
            
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
     * @throws Exception 処理例外
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ※開始時刻入力用のコンボを返す。
        // 　関数の返り値として開始時間コンボを返す。
        return getHoumonRehabilitationTimeContenaBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 　関数の返り値として終了時間コンボを返す。
        return getHoumonRehabilitationTimeContenaEndTime();
    }

    public void changeState() throws Exception {
        int idx = getHoumonRehabilitationTimeDivision().getSelectedIndex();
        // 時間区分による画面制御処理
        switch(idx) {
        case 0: // 1～2の場合
            setState_VALID_BODY_WORK();
            setState_VALID_PHYSIOTHERAPIST_STRENGTHENED();
            // [ID:0000496][Tozo TANAKA] 2009/04/28 delete begin 【サービス予定】通所リハの個別リハビリ実施加算の不活性化解除(時間区分1から2時間のとき)
            //setState_INVALID_OPEN_STOCK_REHABILITATION();
            // [ID:0000496][Tozo TANAKA] 2009/04/28 delete end 【サービス予定】通所リハの個別リハビリ実施加算の不活性化解除(時間区分1から2時間のとき)
            break;
        default:// 上記以外
            setState_INVALID_BODY_WORK();
            setState_INVALID_PHYSIOTHERAPIST_STRENGTHENED();
            // [ID:0000496][Tozo TANAKA] 2009/04/28 delete begin 【サービス予定】通所リハの個別リハビリ実施加算の不活性化解除(時間区分1から2時間のとき)
            //setState_VALID_OPEN_STOCK_REHABILITATION();
            // [ID:0000496][Tozo TANAKA] 2009/04/28 delete end 【サービス予定】通所リハの個別リハビリ実施加算の不活性化解除(時間区分1から2時間のとき)
            break;
        }
        
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
        }
        return 0;
    }

    /**
     * 「サービス法改正区分取得」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     * @return int
     */
    public int getServiceLowVersion() throws Exception {
        //※このサービスパネルが扱うサービスの法改正区分(M_DETAIL.SYSTEM_BIND_PATH=14)を返す。 
        //QkanConstants.SERVICE_LOW_VERSION_H2104 を返す。
        return QkanConstants.SERVICE_LOW_VERSION_H2104;
    }
}
