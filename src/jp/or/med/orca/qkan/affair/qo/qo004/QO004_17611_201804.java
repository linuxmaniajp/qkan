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
 * 開発者: 樋口雅彦
 * 作成日: 2011/12/08  日本コンピューター株式会社 樋口雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 定期巡回・随時対応型訪問介護看護 (QO004_17611_201804)
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
 * 定期巡回・随時対応型訪問介護看護(QO004_17611_201804)
 */
public class QO004_17611_201804 extends QO004_17611_201804Event {
	/**
	 * コンストラクタです。
	 */
	public QO004_17611_201804() {
	}

	// コンポーネントイベント

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QO004_17611_201804.class.getName(),
				param));
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
		
		// 割引率テキストに初期値0を代入する。
        getReduceRate().setText("0");
		// ラジオの初期値を設定する。
        QkanCommon.selectFirstRadioItem(getMainGroup());

	}

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean isValidInput() throws Exception {
		// ※入力チェック
		// エラーメッセージ文言格納用に errMsgを作成する。
		String errMsg = null;

        // 下記のテキストフィールドに対して入力チェックを行う。未入力だった場合は errMsg にメッセージを格納する。
        // ・reduceRate（割引率テキスト）※ errMsg = 割引率
        if (ACTextUtilities.isNullText(getReduceRate().getText())) {
            errMsg = "割引率";
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
            getReduceRate().requestFocus();
            return false;
        }

        // 割引率の値をチェックする。
        int reduceRate = ACCastUtilities.toInt(getReduceRate().getText());
        if (reduceRate > 100) {
            // 100を超える値が入力されていた場合
            QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
            // エラーが発生したインスタンスにフォーカスを当てる。
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
        // パネルデータ取得

        getMainGroup().setSource(map);
        getMainGroup().applySource();

	}

}
