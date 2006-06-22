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
 * 作成日: 2006/01/17  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン福祉用具 (001)
 * プログラム サービスパターン福祉用具 (QS001010)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

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
 * サービスパターン福祉用具(QS001010)
 */
public class QS001010 extends QS001010Event {
    /**
     * コンストラクタです。
     */
    public QS001010() {
    }

    // コンポーネントイベント

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001010.class.getName(), param));
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
        // ※福祉用具リスト
        // コードマスタデータよりCODE_ID：47(用具）を取得する。
        // 取得した値を、comboItemMapの KEY : 1170101 の VALUE として設定する。
        comboItemMap.setData("1170101", QkanCommon.getArrayFromMasterCode(47,
                "1170101"));
        // ※コンボアイテムの設定
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();

    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        if (!getWelfareTools().isSelected()) {
            // 用具コンボ(welfareTools)が未選択の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
        if (ACTextUtilities.isNullText(getWelfarePoint().getText())) {
            // 単位数テキスト(welfarePoint)が空欄の場合
            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // nullを返す。
            return null;
        }
//        if (ACTextUtilities.isNullText(getWelfareTekiyo().getText())) {
//            // 摘要テキスト(welfareTekiyo)が空欄の場合
//            // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
//            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
//            // nullを返す。
//            return null;
//        }
        // ※返却用のレコード(data)を生成
        VRMap data = new VRHashMap();
        // 自身(this)のソースとして生成レコードを設定する。
        getThis().setSource(data);
        // 自身(this)のapplySourceを呼び出してデータを収集する。
        getThis().applySource();

        // ※返却用レコードから不要なキーを除去
        if (!getWelfareTokuchiPoint().isEnabled()) {
            // 特地加算テキスト(welfareTokuchiPoint)が無効の場合
            // 返却用レコードから、特地加算テキスト(welfareTokuchiPoint)のbindPathを除去する。
            data.remove(getWelfareTokuchiPoint().getBindPath());
        } else {
            String val = getWelfareTokuchiPoint().getText();
            if ("".equals(val) || (ACCastUtilities.toInt(val) == 0)) {
                // 特地加算テキスト(welfareTokuchiPoint)が空欄か値が0の場合
                // 返却用レコードから、特地加算テキスト(welfareTokuchiPoint)のbindPathを除去する。
                data.remove(getWelfareTokuchiPoint().getBindPath());
            }
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
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数
        if (provider != null) {
            Object obj;
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

            // 特別地域加算
            obj = VRBindPathParser.get("SPECIAL_AREA_FLAG", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 1) {
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_ADD_SPECIAL_ARE();
                } else {
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_ADD_SPECIAL_ARE();
                }
            }
        }
    }

    /**
     * 開始時刻入力用のコンボを返します。
     * @return 開始時刻入力用のコンボ
     */
   public ACComboBox getBeginTimeCombo() {
       // ※開始時刻入力用のコンボを返す。
       // 関数の返り値としてnullを返す。
        return null;
    }

   /**
    * 終了時刻入力用のコンボを返します。
    * @return 終了時刻入力用のコンボ
    */
    public ACComboBox getEndTimeCombo() {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値としてnullを返す。
        return null;
    }
}
