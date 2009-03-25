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
 * 開発者: 上司　和善
 * 作成日: 2006/05/02  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 介護予防訪問介護 (QO004130)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 介護予防訪問介護(QO004130)
 */
public class QO004130 extends QO004130Event {
	/**
	 * コンストラクタです。
	 */
	public QO004130() {
	}

	// コンポーネントイベント

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QO004130.class.getName(), param));
	}

	// 内部関数

	/**
	 * 「初期化」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void initialize() throws Exception {
		// ※初期化
		// ※初期値設定
		// 割引率テキストに初期値0を代入する。
		// ・reduceRate
		getReduceRate().setText("0");

        //2009/02/24 [ID:0000440][Tozo TANAKA] add begin - 平成21年4月法改正対応
        //＜平成21年4月法改正対応＞
        //3級ヘルパー体制の初期値として「なし」を選択する。
        getThirdClassHelperRadioGroup().setSelectedIndex(1);
        //中山間地域等における小規模事業所加算（地域に関する状況）の初期値として「非該当」を選択する。
        getProviderAddMountainousAreaRafioRadioGroup().setSelectedIndex(1);
        //中山間地域等における小規模事業所加算（規模に関する状況）の初期値として「非該当」を選択する。
        getProviderAddMountainousAreaScaleRadioGroup().setSelectedIndex(1);
        //2009/02/24 [ID:0000440][Tozo TANAKA] add end - 平成21年4月法改正対応
	}

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean isValidInput() throws Exception {
		// ※入力チェック
		// エラーメッセージ文言格納用に errMsg を作成する。
		String errMsg = null;

		// 下記のテキストフィールドに対して入力チェックを行う。未入力だった場合は errMsg にメッセージを格納する。
		// ・reduceRate（割引率テキスト） ※errMsg = 割引率
		if (ACTextUtilities.isNullText(getReduceRate())) {
			errMsg = "割引率";
			// 入力されていなかった場合
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT 引数 = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
			// エラーが発生したインスタンスにフォーカスを当てる。
			getReduceRate().requestFocus();
			// 処理を抜ける。（中断する）
			return false;
		}

		// 割引率の値をチェックする。
		// 割引率の値が100を超えている場合
		if (ACCastUtilities.toInt(getReduceRate().getText()) > 100) {
			// エラーメッセージを表示する。 ※メッセージID=QO004_ERROR_OF_REDUCT_RATE
			QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
			// エラーが発生したインスタンスにフォーカスを当てる。
			// 処理を抜ける。（中断する）
			getReduceRate().requestFocus();
			return false;
		}
		return true;
	}

	/**
	 * 「パネル状態制御」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void stateManager(boolean state) throws Exception {
		// ※パネル状態制御
		if (state) {
			// 引数としてtrueが渡された場合
			// 状態ID：SET_PANEL_TRUE
			setState_SET_PANEL_TRUE();
		} else {
			// 引数としてfalseが渡された場合
			// 状態ID：SET_PANEL_FALSE
			setState_SET_PANEL_FALSE();
		}
	}

	/**
	 * 「パネルデータ取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void getDetails(VRMap map) throws Exception {
		// ※パネルデータ取得
		// 事業グループのソースとしてVRMap mapを設定する。
		setSource(map);

		// 画面上のデータを取得する。
		applySource();

		// デバッグ用出力
//		System.out.println(map);

	}

}
