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
 * 作成日: 2016/09/08 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターンその他の生活支援サービス(見守り定額) (QS001_51211_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターンその他の生活支援サービス(見守り定額)(QS001_51211_201804)
 */
public class QS001_51211_201804 extends QS001_51211_201804Event {
	/**
	 * コンストラクタです。
	 */
	public QS001_51211_201804() {
	}

	// コンポーネントイベント

	/**
	 * 「コードを一覧へ追加ボタンのクリック」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void addCodeToListButtonActionPerformed(ActionEvent e)
			throws Exception {
		// 保険者名のチェック
		// 選択されているかどうか
		if (!getInsurerName().isSelected()) {
			// 選択されていない場合
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT("保険者");
			return;
		}
		// コードのチェック
		if (ACTextUtilities.isNullText(getItemCodeText())) {
			// 選択されていない場合
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("コード");
			return;
		}
		// コードの桁数チェック
		String itemCode = getItemCodeText().getText();
		if (4 != itemCode.length()) {
			QkanMessageList.getInstance().ERROR_OF_LENGTH("コード", 4);
			return;
		}

		// コードからマスタを参照し、一覧へ追加
		VRMap map = (VRMap) getInsurerName().getSelectedItem();
		String insurerId = ACCastUtilities.toString(map.get("INSURER_ID"));
		if (findCodeToList(insurerId, itemCode)) {
			if (getSvCodeList().size() > 1){
				getSvCodeList().remove(0);
			}
			getItemCodeText().setText("");
			getSvCodeTable().requestFocusInWindow();
			getSvCodeTable().setSelectedSortedLastRow();
		}

	}

	/**
	 * 「コード選択ボタンのクリック」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void codeFindButtonActionPerformed(ActionEvent e)
			throws Exception {
		// ※コード一覧ダイアログを起動する。選択内容をリストに追加する。
		VRMap map = (VRMap) getInsurerName().getSelectedItem();
		String insurerId = ACCastUtilities.toString(map.get("INSURER_ID"));
		if (selectCodeToList(insurerId)) {
			if (getSvCodeList().size() > 1){
				getSvCodeList().remove(0);
			}
			getItemCodeText().setText("");
			getSvCodeTable().requestFocusInWindow();
			getSvCodeTable().setSelectedSortedLastRow();
		}
	}

	/**
	 * 「コード削除ボタンのクリック」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void deleteCodeButtonActionPerformed(ActionEvent e)
			throws Exception {
		// レコードが0件だった場合
		// 選択されているレコードの画面上のインデックス
		int sortedRow = getSvCodeTable().getSelectedSortedRow();

		// 選択されているレコードを削除する。
		getSvCodeList().remove(getSvCodeTable().getSelectedModelRow());

		// 削除された行の1行上を選択する。
		getSvCodeTable().setSelectedSortedRowOnAfterDelete(sortedRow);

		// 画面状態制御
		checkState();
	}

	/**
	 * 「コード一覧の選択」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void svCodeTableSelectionChanged(ListSelectionEvent e)
			throws Exception {
		// 画面状態制御
		checkState();
	}

	/**
	 * 「保険者の選択」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insurerNameActionPerformed(ActionEvent e) throws Exception {
		// 保険者コンボクリックの場合にチェックする。
		if ( e.getModifiers() == MouseEvent.BUTTON1_MASK ){
			// サービスコード一覧に追加されていたらクリア確認メッセージを表示する。
			if (getSvCodeList().size() != 0 && getInsurerName().getSelectedIndex() != getNowInsurerSelectedIndex()) {
	            int msgID = QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_SVCODELIST();
	            if (msgID == ACMessageBox.RESULT_OK) {
	                // 「OK」選択時、クリアする。
	            	getSvCodeList().clear();
	            	getItemCodeText().setText("");
	            } else {
	                // 「キャンセル」選択時、変更をしない。
	            	getInsurerName().setSelectedIndex(getNowInsurerSelectedIndex());
	            }
			}
		}
		// 保険者コンボのインデックスを保持する。
		setNowInsurerSelectedIndex(getInsurerName().getSelectedIndex());
	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QS001_51211_201804.class.getName(),
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
		// ※画面展開時の初期設定

		// テーブルモデルを下記の画面のテーブルに設定する。
		ACTableModelAdapter tableModel = new ACTableModelAdapter();

		// テーブルモデルを定義
		tableModel.setColumns(new String[] {
				"SERVICE_CODE_KIND+'-'+SERVICE_CODE_ITEM", "SERVICE_NAME",
				"SERVICE_UNIT", "FUTANGAKU", "INSURER_ID" });

		setSvCodeTableModel(tableModel);
		// テーブルモデルをテーブルにセット
		getSvCodeTable().setModel(tableModel);

		// ※コンボアイテムの設定
		// ※準備
		// コンボアイテム設定用のレコード comboItemMap を生成する。
		VRMap comboItemMap = new VRHashMap();
		// ※開始時刻
		// コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
		// 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
		comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
		// ※終了時刻
		// コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
		// 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
		comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));

		// 保険者コンボ
		VRList insurerList = QkanCommon.getInsurerInfoCareOnly(getDBManager());
		// 保険者番号を総合事業用のバインドパスへコピー
		ACBindUtilities.copyBindPath(insurerList, "INSURER_ID",
				String.valueOf(SJ_HOKENSHA_NO_BIND_PATH));
		VRBindPathParser.set("INSURER", comboItemMap, insurerList);

		// ※コンボアイテムの設定
		// 自身(this)のモデルソースとしてcomboItemMapに設定する。
		getThis().setModelSource(comboItemMap);
		// コンボアイテムを展開する。
		getThis().bindModelSource();

		// 保険者コンボの初期値設定
		String insurerId = getInitialInsurerId();

		// 取得した保険者番号に該当する保険者が存在する場合
		VRMap item = (VRMap) getInsurerName().getDataFromBindPath(insurerId);

		// 保険者名コンボの該当保険者を選択状態にする。
		getInsurerName().setSelectedItem(item);

		// 保険者名コンボのインデックスを初期化する。
		if (getNowInsurerSelectedIndex() < 0) {
			setNowInsurerSelectedIndex(getInsurerName().getSelectedIndex());
		}

		// 画面状態制御
		checkState();
	}

	/**
	 * 「事業所コンボ変更時関数」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void providerSelected(VRMap provider) throws Exception {
		// ※事業所コンボ変更時に呼ぶ関数

	}

	/**
	 * 「入力内容の不備を検査」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public VRMap getValidData() throws Exception {
		// 保険者名のチェック
		// ・kaigoInfoInsurerName（保険者名）
		// 選択されているかどうか
		if (!getInsurerName().isSelected()) {
			// 選択されていない場合
			QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
			return null;
		}

		// 登録件数のチェック
		if (getSvCodeList().size() == 0) {
			// コードが選択されていない場合
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
					"サービスコード");
			return null;
		}

		if ((!getSoACBeginTime().isValidDate())
				|| (!getSoACEndTime().isValidDate())) {
			// 開始時刻コンボと終了時刻コンボのいずれかが不正の場合
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
		if (ACTextUtilities.isNullText(getSoACBeginTime().getText())) {
			// 開始時刻コンボが空欄の場合
			// 返却用レコードから、開始時刻コンボのbindPathを除去する。
			data.remove(getSoACBeginTime().getBindPath());
		}
		if (ACTextUtilities.isNullText(getSoACEndTime().getText())) {
			// 終了時刻コンボが空欄の場合
			// 返却用レコードから、終了時刻コンボのbindPathを除去する。
			data.remove(getSoACEndTime().getBindPath());
		}
		// サービス一覧のデータを追加
		addSvCodeToData(data);

		// 問題なければ返却用レコード(data)を返す。
		return data;
	}

	/**
	 * 「事業所情報の必要性を取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean isUseProvider() throws Exception {
		// ※事業所情報が必要なサービスであるかを返す。
		// 　trueを返す。
		return true;
	}

	/**
	 * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public ACComboBox getBeginTimeCombo() throws Exception {
		// ※開始時刻入力用のコンボを返す。
		// 関数の返り値として開始時間コンボを返す。
		return getSoACBeginTime();
	}

	/**
	 * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public ACComboBox getEndTimeCombo() throws Exception {
		// ※終了時刻入力用のコンボを返す。
		// 関数の返り値として終了時間コンボを返す。
		return getSoACEndTime();
	}

	/**
	 * 「画面状態制御」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	protected void checkState() throws Exception {
		if (getSvCodeTable().isSelected()) {
			setState_VALID_EDIT();
		} else {
			setState_INVALID_EDIT();
		}
		if (getSvCodeList().size() >= DOKUJI_TEIRITSU_SVCODE_SELECT_MAX) {
			setState_INVALID_ADD();
		} else {
			setState_VALID_ADD();
		}
	}

}
