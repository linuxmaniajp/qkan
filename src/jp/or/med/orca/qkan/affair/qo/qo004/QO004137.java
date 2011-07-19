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
 * プログラム 介護予防短期入所生活介護 (QO004137)
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
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 介護予防短期入所生活介護(QO004137)
 */
public class QO004137 extends QO004137Event {
	/**
	 * コンストラクタです。
	 */
	public QO004137() {
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
	protected void facilitiesDivisionSelectionChanged(ListSelectionEvent e) throws Exception {
		// 画面状態設定
		// 施設区分の「単独型」、「併設型」が選択されている場合
		if ((getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_NORMAL_TANDOKU) || (getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_NORMAL_HEISETSU)) {
			setState_FACILITY_TYPE_NORMAL();
			// 状態ID：FACILITY_TYPE_NORMAL
		} else {
			// 施設区分の「単独型」、「併設型」以外が選択されている場合
			setState_FACILITY_TYPE_UNIT();
			// 状態ID：FACILITY_TYPE_UNIT
		}
        // [ID:0000471][Masahiko Higuchi] 2009/04 add begin 空床型対応
        setState();
        // [ID:0000471][Masahiko Higuchi] 2009/04 add end
	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QO004137.class.getName(), param));
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
		// 割引率テキストに初期値0を表示する。
		getReduceRate().setText("0");
		// ラジオの値を初期化する
		QkanCommon.selectFirstRadioItem(getThis());

		// 食費・居住費の取得と表示
		VRMap param = new VRHashMap();
		VRBindPathParser.set("SYSTEM_DATE", param, QkanSystemInformation.getInstance().getSystemDate());
		String strSql = getSQL_GET_RESIDENCE_FOOD(param);
		VRList residenceFood = getDBManager().executeQuery(strSql);

		if (residenceFood != null) {
			for (int i = 0; i < residenceFood.size(); i++) {
				VRMap temp = (VRMap) residenceFood.get(i);
				int id = ACCastUtilities.toInt(VRBindPathParser.get("RESIDENCE_FOOD_COST_ID", temp));
				String cost = ACCastUtilities.toString(VRBindPathParser.get("RESIDENCE_FOOD_COST", temp));

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
					// [ID:0000644][Shin Fujihara] 2011/04/21 edit begin
					// 金額初期値の分岐誤り
					//case 5:
					case 4:
					// [ID:0000644][Shin Fujihara] 2011/04/21 edit end
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
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_SELECT 引数 = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// エラーが発生したインスタンスにフォーカスを当てる。
			getFacilitiesDivision().requestFocus();
			// 処理を抜ける。（中断する）
			return false;
		}

		// ・nightWorkDivision（夜間勤務条件基準ラジオグループ）※ errMsg = 夜間勤務条件基準
		if (!getNightWorkDivision().isSelected()) {
			errMsg = "夜間勤務条件基準";
			// 未選択だった場合
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_SELECT 引数 = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// エラーが発生したインスタンスにフォーカスを当てる。
			getNightWorkDivision().requestFocus();
			// 処理を抜ける。（中断する）
			return false;

		}

		// ・functionTrainingGuidanceSystem（個別機能訓練指導体制ラジオグループ）※ errMsg = 個別機能訓練指導体制
		if (!getFunctionTrainingGuidanceSystem().isSelected()) {
			errMsg = "個別機能訓練指導体制";
			// 未選択だった場合
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_SELECT 引数 = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// エラーが発生したインスタンスにフォーカスを当てる。
			getFunctionTrainingGuidanceSystem().requestFocus();
			// 処理を抜ける。（中断する）
			return false;

		}

		// ・meetingAndSendingOffSystem（送迎体制ラジオグループ）※ errMsg = 送迎体制
		if (!getMeetingAndSendingOffSystem().isSelected()) {
			errMsg = "送迎体制";
			// 未選択だった場合
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_SELECT 引数 = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// エラーが発生したインスタンスにフォーカスを当てる。
			getMeetingAndSendingOffSystem().requestFocus();
			// 処理を抜ける。（中断する）
			return false;

		}

		// ・nourishmentControlAdd（栄養管理体制ラジオグループ）※ errMsg = 栄養管理体制
		if (!getNourishmentControlAdd().isSelected()) {
			errMsg = "栄養管理体制";
			// 未選択だった場合
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_SELECT 引数 = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// エラーが発生したインスタンスにフォーカスを当てる。
			getNourishmentControlAdd().requestFocus();
			// 処理を抜ける。（中断する）
			return false;

		}

		// ・unitCareMaintenance（ユニットケアの整備ラジオグループ）※ errMsg = ユニットケアの整備 ※Enabled = true の場合のみ
		if (!getUnitCareMaintenance().isSelected()) {
			errMsg = "ユニットケアの整備";
			// 未選択だった場合
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_SELECT 引数 = errMsg
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
			// エラーが発生したインスタンスにフォーカスを当てる。
			getUnitCareMaintenance().requestFocus();
			// 処理を抜ける。（中断する）
			return false;

		}
        
        // [ID:0000471][Masahiko Higuchi] 2009/04 add begin 空床型対応
        // サービス提供体制強化加算
        if (getServiceAddProvisionStructuralRadioGroup().getSelectedIndex() > 1) {
                // サービス提供体制強化加算（空床型）でなし以外が選択されている場合
                if (getServiceAddProvisionStructuralKusyoRadioGroup().isEnabled()
                    && getServiceAddProvisionStructuralKusyoRadioGroup()
                            .getSelectedIndex() > 1) {
                    // エラーメッセージ
                    if (QkanMessageList.getInstance()
                            .QO004_WARNING_OF_DOUBLE_CHECK("サービス提供体制強化加算（単独型・併設型／空床型）の両方") == ACMessageBox.RESULT_CANCEL) {
                        return false;
                    }
                }
            }    
        // [ID:0000471][Masahiko Higuchi] 2009/04 add end
        
		// 下記のテキストフィールドに対して入力チェックを行う。未入力だった場合は errMsg にメッセージを格納する。
		// 割引率の値をチェックする。
		// ・reduceRate（割引率テキスト）※ errMsg = 割引率
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

		// 割引率の値が100を超えている場合
		if (ACCastUtilities.toInt(getReduceRate().getText()) > 100) {
			// エラーメッセージを表示する。 ※メッセージID=QO004_ERROR_OF_REDUCT_RATE
			QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
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
		// 引数としてtrueが渡された場合
		if (state) {
			// 状態ID：SET_PANEL_TRUE
			setState_SET_PANEL_TRUE();

			// 施設区分の「単独型」、「併設型」が選択されている場合
			if ((getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_NORMAL_TANDOKU) || (getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_NORMAL_HEISETSU)) {
				// 状態ID：UNIT_CARE_FALSE
				setState_FACILITY_TYPE_NORMAL();
			} else {
				setState_FACILITY_TYPE_UNIT();
			}
            // [ID:0000471][Masahiko Higuchi] 2009/04 add begin 空床型対応
            setState();
            // [ID:0000471][Masahiko Higuchi] 2009/04 add end
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
//		System.out.println(map);

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
		// ・unitCareMaintenance KEY：1240104
        QkanCommon.removeDisabledBindPath(getMainGroup(), map);

	}

    /**
     * 画面状態制御を行います。
     */
    public void setState() throws Exception {
        // ※サービス提供体制強化加算(空床型)の制御処理
        switch(getFacilitiesDivision().getSelectedIndex()) {
        case 1: // 単独型
        case 3: // 単独型ユニット型
            setState_INVALID_SERVICE_ADD_KUSYO();
            break;
        case 2: // 空床型
        case 4: // ユニット型空床型
            setState_VALID_SERVICE_ADD_KUSYO();
            break;
        }
        
    }

}
