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
 * 作成日: 2006/05/11  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防小規模多機能居宅介護 (QS001147)
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
 * サービスパターン介護予防小規模多機能居宅介護(QS001147)
 */
public class QS001147 extends QS001147Event {
    /**
     * コンストラクタです。
     */
    public QS001147() {
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

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001147.class.getName(), param));
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
        if (provider != null) {
            // 選択事業所情報がnullでない場合
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = new VRHashMap();
            // ※事業所連動
            // 職員の欠員による減算（事業所パネル）KEY：1750101の値をチェックする。
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1750101",
                    provider),0)) {
            // 値が1（なし）だった場合
            case 1:
                // defaultMapに KEY：1750102 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1750102", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
                // 値が1以外（看護職員・介護職員）だった場合
                // defaultMapに KEY：1750102 VALUE：3（看護・介護職員が欠員）を設定する。
                VRBindPathParser.set("1750102", defaultMap, new Integer(3));
                break;
            }
            // ※介護支援専門員コンボ設定
            // 内部変数 sqlParam を生成する。
            VRMap sqlParam = new VRHashMap();
            // sqlParamに下記の値を格納する。
            // KEY：PROVIDER__ID VALUE：選択事業所番号
            sqlParam.put("PROVIDER_ID", VRBindPathParser.get("PROVIDER_ID",
                    provider));
            // 内部変数 staffs を生成する。
            VRList staffs;
            // 介護支援専門員取得用のSQLを取得する。
            String sql = getSQL_GET_CARE_MANAGER(sqlParam);
            // staffs に取得したSQLを実行した結果を格納する。
            staffs = getDBManager().executeQuery(sql);
            // 取得したVRListの中身をループしながら姓名を結合する。
            Iterator it = staffs.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                // 結合した値を下記のKEYで格納する。
                // KEY：STAFF_NAME
                VRBindPathParser.set("STAFF_NAME", row, QkanCommon.toFullName(
                        VRBindPathParser.get("STAFF_FAMILY_NAME", row),
                        VRBindPathParser.get("STAFF_FIRST_NAME", row)));
            }
            // staffs を介護支援専門員コンボに設定する。
            getKaigoSupportSpecialMemberName().setModel(staffs);
            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // staffs の中に介護支援専門員番号テキストの値と同一のものが存在するかチェックする。
            // ACBindUtilities.getMatchIndexFromValue();

            // 一致するものが存在した場合
            // 一致した介護支援専門員を表示する。
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
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
     * 「バインド時の処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void binded() throws Exception {
        // ※バインド時の処理
        ComboBoxModel mdl = getKaigoSupportSpecialMemberName().getModel();
        // 内部変数 src を生成する。
        VRBindSource src = null;
        // src(VRBindSource);
        if (mdl instanceof VRComboBoxModelAdapter) {
            src = ((VRComboBoxModelAdapter) mdl).getAdaptee();
        }
        // 介護支援専門員コンボ（kaigoSupportSpecialMemberName）よりソースを取得し src に格納する。
        // 取得した src がVRListであるかチェックする。
        if (src instanceof VRList) {
            // VRListであった場合
            // 入力されている介護支援専門員番号（kaigoSupportSpecialMemberNumber）と一致する番号が src
            // 内に存在するかチェックする。
            // getMatchIndexFromValue(src, "CARE_MANAGER_NO", 入力されている介護支援専門員番号);
            int idx = ACBindUtilities.getMatchIndexFromValue((VRList) src,
                    "CARE_MANAGER_NO", getKaigoSupportSpecialMemberNumber()
                            .getText());
            // 存在した場合
            // 内部変数 idx に一致したリスト項目のIndexを格納する。
            // idx の値をチェックする。
            // 値が1より大きかった場合
            // 介護支援専門員コンボ（kaigoSupportSpecialMemberName）の idx と同じ番号で選択状態にする。
            if (idx >= 0) {
                getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
            }
        }
    }

}
