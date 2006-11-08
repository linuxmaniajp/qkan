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
 * 開発者: 廣瀬 一海
 * 作成日: 2006/05/02  日本コンピューター株式会社 廣瀬 一海 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 介護予防短期入所療養介護（認知症疾患型） (QO004141)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;

import java.awt.event.FocusEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 介護予防短期入所療養介護（認知症疾患型）(QO004141)
 */
public class QO004141 extends QO004141Event {
	/**
	 * コンストラクタです。
	 */
	public QO004141() {
	}

	// コンポーネントイベント

	/**
	 * 「画面状態設定」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void facilitiesDivisionSelectionChanged(ListSelectionEvent e)
			throws Exception {
		// 画面状態設定
		// 「認知症疾患型」が選択された場合
		int facilityType = getFacilitiesDivision().getSelectedIndex();
		if (facilityType == FACILITY_TYPE_NINCHISHO) {
			setState_FACILITY_TYPE_NORMAL();
			// 状態ID：FACILITY_TYPE_NORMAL
		} else if (facilityType == FACILITY_TYPE_UNIT) {
			// 「ユニット型」が選択された場合
			setState_FACILITY_TYPE_UNIT();
			// 状態ID：FACILITY_TYPE_UNIT
		} else {
			// 「経過型」が選択された場合
			setState_FACILITY_TYPE_PASSAGE();
		}
	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QO004141.class.getName(), param));
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
		// ラジオの値を初期化する
		QkanCommon.selectFirstRadioItem(getThis());

		// 割引率の初期設定
		getReduceRate().setText("0");

		// 食費・居住費の取得と表示
		VRMap param = new VRHashMap();
		VRBindPathParser.set("SYSTEM_DATE", param, QkanSystemInformation
				.getInstance().getSystemDate());
		String strSql = getSQL_GET_RESIDENCE_FOOD(param);
		VRList residenceFood = getDBManager().executeQuery(strSql);

		if (residenceFood != null) {
			for (int i = 0; i < residenceFood.size(); i++) {
				VRMap temp = (VRMap) residenceFood.get(i);
				int id = ACCastUtilities.toInt(VRBindPathParser.get(
						"RESIDENCE_FOOD_COST_ID", temp));
				String cost = ACCastUtilities.toString(VRBindPathParser.get(
						"RESIDENCE_FOOD_COST", temp));

				switch (id) {
				// 食費
				case 1:
					getDinnerTotal().setText(cost);
					break;
				// ユニット個室
				case 2:
					getUnitRoom().setText(cost);
					break;
				// ユニット準個室
				case 3:
					getUnitSemiRoom().setText(cost);
					break;
				// 従来型個室
				case 5:
					getNormalRoom().setText(cost);
					break;
				// 多床室
				case 6:
					getTasyouRoom().setText(cost);
					break;
				}

			}
		}
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
		// 下記のラジオグループに対して選択チェックを行う。未選択だった場合は errMsg にメッセージを格納する。
		// ・facilitiesDivision（施設区分ラジオグループ）※ errMsg = 施設区分
		if (!getFacilitiesDivision().isSelected()) {
			errMsg = "施設区分";
			// 未選択だった場合
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_SELECT 引数 =
			// errMsg
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// エラーが発生したインスタンスにフォーカスを当てる。
			getFacilitiesDivision().requestFocus();
			// 処理を抜ける。（中断する）
			return false;
		}

		// ・staffAssignmentDivision（人員配置区分ラジオグループ） ※errMsg = 人員配置区分
		if (getStaffAssignmentDivision().isEnabled()) {
			if (!getStaffAssignmentDivision().isSelected()) {
				errMsg = "人員配置区分";
				// 未選択だった場合
				// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_SELECT 引数 =
				// errMsg
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
						errMsg);
				// エラーが発生したインスタンスにフォーカスを当てる。
				getStaffAssignmentDivision().requestFocus();
				// 処理を抜ける。（中断する）
				return false;
			}
		}

		// ・staffLack（人員減算コンボ） ※errMsg = 人員減算
		if (!getStaffLack().isSelected()) {
			errMsg = "人員減算";
			// 未選択だった場合
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_SELECT 引数 =
			// errMsg
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// エラーが発生したインスタンスにフォーカスを当てる。
			getStaffLack().requestFocus();
			// 処理を抜ける。（中断する）
			return false;
		}

		// ・unitCareMaintenance（ユニットケアの整備ラジオグループ） ※errMsg = ユニットケアの整備
		if (getUnitCareMaintenance().isEnabled()) {
			if (!getUnitCareMaintenance().isSelected()) {
				errMsg = "ユニットケアの整備";
				// 未選択だった場合
				// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_SELECT 引数 =
				// errMsg
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(
						errMsg);
				// エラーが発生したインスタンスにフォーカスを当てる。
				getUnitCareMaintenance().requestFocus();
				// 処理を抜ける。（中断する）
				return false;
			}
		}

		// ・meetingAndSendingOffSystem（送迎体制ラジオグループ） ※errMsg = 送迎体制
		if (!getMeetingAndSendingOffSystem().isSelected()) {
			errMsg = "送迎体制";
			// 未選択だった場合
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_SELECT 引数 =
			// errMsg
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// エラーが発生したインスタンスにフォーカスを当てる。
			getMeetingAndSendingOffSystem().requestFocus();
			// 処理を抜ける。（中断する）
			return false;
		}

		// ・nourishmentControlAdd（栄養管理体制ラジオグループ） ※errMsg = 栄養管理体制
		if (!getNourishmentControlAdd().isSelected()) {
			errMsg = "栄養管理体制";
			// 未選択だった場合
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_SELECT 引数 =
			// errMsg
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// エラーが発生したインスタンスにフォーカスを当てる。
			getNourishmentControlAdd().requestFocus();
			// 処理を抜ける。（中断する）
			return false;

		}

		// 割引率の値をチェックする。
		// 割引率の値が100を超えている場合
		if (ACCastUtilities.toInt(getReduceRate().getText()) > 100) {
			// エラーメッセージを表示する。 ※メッセージID=QO004_ERROR_OF_REDUCT_RATE
			QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
			// エラーが発生したインスタンスにフォーカスを当てる。
			getReduceRate().requestFocus();
			// 処理を抜ける。（中断する）
			return false;
		}

		// 下記のテキストフィールドに対して入力チェックを行う。未入力だった場合は errMsg にメッセージを格納する。
		if (ACTextUtilities.isNullText(getReduceRate())) {
			// ・reduceRate（割引率テキスト）※ errMsg = 割引率
			errMsg = "割引率";
			// 未入力だった場合
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT 引数 =
			// errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
			// エラーが発生したインスタンスにフォーカスを当てる。
			getReduceRate().requestFocus();
			// 処理を抜ける。（中断する）
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
		// ※パネル状態制御
		if (state) {
			// 引数としてtrueが渡された場合
			// 状態ID：SET_PANEL_TRUE
			setState_SET_PANEL_TRUE();

			// 「認知症疾患型」が選択された場合
			int facilityType = getFacilitiesDivision().getSelectedIndex();
			if (facilityType == FACILITY_TYPE_NINCHISHO) {
				setState_FACILITY_TYPE_NORMAL();
				// 状態ID：FACILITY_TYPE_NORMAL
			} else if (facilityType == FACILITY_TYPE_UNIT) {
				// 「ユニット型」が選択された場合
				setState_FACILITY_TYPE_UNIT();
				// 状態ID：FACILITY_TYPE_UNIT
			} else {
				// 「経過型」が選択された場合
				setState_FACILITY_TYPE_PASSAGE();
			}

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

		// 無効状態のコントロールのデータを削除する。
		removeInvalidData(map);

		// デバッグ用出力
		// System.out.println(map);

	}

	/**
	 * 「無効データ削除」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void removeInvalidData(VRMap map) throws Exception {
		// ※無効データ削除
		// 以下のコントロールが無効状態の場合、以下のKEYをmapより削除する。
		// ・staffAssignmentDivision 削除KEY：1260302
		if (!getStaffAssignmentDivision().isEnabled()) {
			map.removeData("1260302");
		}

		// ・unitCareMaintenance 削除KEY：1260304
		if (!getUnitCareMaintenance().isEnabled()) {
			map.removeData("1260304");
		}
	}

}
