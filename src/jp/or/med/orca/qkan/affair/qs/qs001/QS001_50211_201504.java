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
 * 開発者: 日高　しのぶ
 * 作成日: 2016/08/30  MIS九州株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問型サービス(独自) (QS001_50211_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン訪問型サービス(独自)(QS001_50211_201504)
 */
@SuppressWarnings("serial")
public class QS001_50211_201504 extends QS001_50211_201504Event {
    /**
     * コンストラクタです。
     */
    public QS001_50211_201504() {

        // 必須の事業所設定項目
        putCheckProviderBindPath("初任サービス提供責任者", "5020101");

        // 値を転記する事業所設定項目
        putImportProviderBindPath("初任サービス提供責任者", "5020101", "5020102");
    }

    // コンポーネントイベント

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_50211_201504.class.getName(),
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
        // [ID:0000532][Masahiko.Higuchi] 2009/08 add begin 2009年度対応
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
                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0)) {
                case 13:
                    setIsPrintCheckShow(true);
                    break;
                }
                break;

            case 13:
                // 要支援２⇒要支援１
                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0)) {
                case 12:
                    setIsPrintCheckShow(true);
                    break;
                }
                break;
            }

        }
        // [ID:0000532][Masahiko.Higuchi] 2009/08 add end
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
		comboItemMap.setData("5020106", QkanCommon.getArrayFromMasterCode(290, "5020106"));		

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
        // 画面のラジオの初期値を設定する。（selectFirstRadioItem）
        QkanCommon.selectFirstRadioItem(getThis());
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();
        // 画面状態制御
        checkState();

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

            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
        }

        checkState();

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
        // 訪問型サービス費が選択されているかチェックする
        if (!getVisitCareExpenseAddRadio().getSelectedButton().isEnabled()) {
            // 内容詳細の不備メッセージを表示する。
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT("訪問型サービス費");
            // nullを返す。
            return null;
        }
        // ※時刻コンボチェック
        // 開始時刻コンボ(houmonKaigoBeginTime)と終了時刻コンボ(houmonKaigoEndTime)のいずれかが空欄もしくは不正の場合
        if (!getHoumonKaigoBeginTime().isValidDate()
                || !getHoumonKaigoEndTime().isValidDate()) {
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
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ※開始時刻入力用のコンボを返す。
        // 　関数の返り値として開始時間コンボを返す。
        return getHoumonKaigoBeginTime();
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 　関数の返り値として終了時間コンボを返す。
        return getHoumonKaigoEndTime();
    }

    /**
     * 「画面状態制御」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void checkState() throws Exception {
        // 要支援1であるかチェックする。
        boolean isYosien1 = false;
        // 利用者の該当月の要介護認定履歴を取得する。
        VRList list = getCalculater().getPatientInsureInfoHistoryList();

        // 履歴数分ループ処理
        for (int i = 0; i < list.size(); i++) {
            VRMap map = (VRMap) list.getData(i);
            // 要支援1が履歴の中に存在するかチェックする。
            if (ACCastUtilities.toInt(VRBindPathParser.get("JOTAI_CODE", map)) == 12) {
                // 履歴内に要支援1が存在した場合
                isYosien1 = true;
            } else {
                // 履歴内に要支援1以外が存在した場合
                isYosien1 = false;
                // ループを抜ける。
                break;
            }
        }
        // 要支援1があった場合
        if (isYosien1) {
            // 日割をチェックしている場合（1型、2型のみ）
            if (getCrackOnDayCheck().getValue() == 2) {
                setState_SHIEN1_DAY_CHECK_ON();
            } else {
                setState_SHIEN1_DAY_CHECK_OFF();
            }
        } else {
            // 日割をチェックしている場合（1型、2型、3型のみ）
            if (getCrackOnDayCheck().getValue() == 2) {
                setState_OTHER_SHIEN1_DAY_CHECK_ON();
            } else {
                setState_OTHER_SHIEN1_DAY_CHECK_OFF();
            }
        }

    }

    /**
     * 値バインド後処理
     * 
     * @throws Exception 処理例外
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

        checkState();
    }

    /**
     * 日割チェック時の処理
     * 
     * @throws Exception 処理例外
     */
    protected void crackOnDayCheckActionPerformed(ActionEvent e) throws Exception {
        
        checkState();

    }

}
