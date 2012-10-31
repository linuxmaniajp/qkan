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
 * 作成日: 2012/08/07  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定 (S)
 * プロセス カレンダー (001)
 * プログラム 特定診療費・特別療養費集計 (QS001008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * 特定診療費・特別療養費集計(QS001008)
 */
public class QS001008 extends QS001008Event {
	/**
	 * コンストラクタです。
	 */
	public QS001008() {
	}

	// コンポーネントイベント

	/**
	 * 「閉じる」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void closeActionPerformed(ActionEvent e) throws Exception {
		// ■画面を閉じる
		// 　画面を破棄します。
		dispose();
	}

	/**
	 * 「サービス種類コンボ選択」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void serviceComboActionPerformed(ActionEvent e) throws Exception {
		// ■サービス種類コンボ選択
		if (!getServiceCombo().isSelected() || !getProviderCombo().isSelected()) {
			return;
		}

		VRMap providerMap = (VRMap) getProviderCombo().getSelectedModelItem();
		VRMap serviceMap = (VRMap) getServiceCombo().getSelectedModelItem();
		VRList list = new VRArrayList();

		// key情報の生成
		String providerID = ACCastUtilities.toString(
				providerMap.getData("PROVIDER_ID"), "");
		String systemServiceKindDetailValue = ACCastUtilities.toString(
				serviceMap.getData("SYSTEM_SERVICE_KIND_DETAIL"), "");
		String key = providerID + "-" + systemServiceKindDetailValue;

		// キー確認
		if (!getProviderDiagnosis().containsKey(key)) {
			return;
		}

		// リストに取り出し
		list = (VRArrayList) getProviderDiagnosis().getData(key);

		// テーブルセット
		getMainTableModel().setAdaptee(list);

		if (list.size() > 0) {
			getTokubetsuTable().setSelectedSortedFirstRow();
		}

	}

	/**
	 * 「特定診療費テーブル選択」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void tokubetsuTableSelectionChanged(ListSelectionEvent e)
			throws Exception {
		// ■特定診療費テーブル選択
		// 　選択行の特定診療費・特別療養費の内訳を表示します。

		VRMap selectMap = new VRHashMap();

		if (getTokubetsuTable().isSelected()) {
			selectMap = (VRMap) getTokubetsuTable().getSelectedModelRowValue();

			if (selectMap != null) {
				// テーブルに設定
				getDetailTableModel().setAdaptee(
						(VRArrayList) selectMap.getData("DETAIL"));
			}
		}

	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QS001008.class.getName(), param));
	}

	// 内部関数

	/**
	 * 「初期設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void showModal(Map<String, Map> diagnosisDateMap, Date targetDate)
			throws Exception {
		// ■画面展開時の初期設定
		// 　取得した情報をテーブルに設定する。
		// 　※ウィンドウタイトルの設定
		setAffairTitle("QS001008");

		setTargetDate(targetDate);

		VRList service = new VRArrayList();
		VRMap masterService = QkanCommon.getMasterService(getDBManager(),
				getTargetDate());

		String[] cuts = null;
		VRList providerList = new VRArrayList();
		VRMap providerMap = new VRHashMap();
		VRList providerTempList = new VRArrayList();

		for (Entry<String, Map> entry : diagnosisDateMap.entrySet()) {
			// [事業所番号-サービス種類コード]
			String key = entry.getKey();
			cuts = key.split("-");

			if (cuts.length != 2) {
				continue;
			}

			String providerID = cuts[0];
			Integer systemServiceKindDetail = ACCastUtilities.toInteger(
					cuts[1], 0);

			if (!getProviderService().containsKey(providerID)) {
				// 新規
				service = new VRArrayList();
				service.add(masterService.getData(systemServiceKindDetail));
				getProviderService().setData(providerID, service);
				// 事業所の退避
				providerTempList = QkanCommon.getProviderInfo(getDBManager(),
						providerID);
				providerMap = (VRMap) providerTempList.get(0);
				providerList.add(providerMap);

			} else {
				service = (VRArrayList) getProviderService()
						.getData(providerID);
				service.add(masterService.getData(systemServiceKindDetail));
			}

			// テーブル展開情報の設定
			// 特定診療費・特別療養費情報
			Map<String, ArrayList<Map>> tokuteiMap = entry.getValue();
			// 退避
			getProviderDiagnosis().setData(key, calcDiagnosis(tokuteiMap));

		}

		// テーブルモデルを定義する。
		ACTableModelAdapter mainTableModel = new ACTableModelAdapter();
		mainTableModel
				.setColumns(new String[] { "NAME", "NAME", "TOTAL_COUNT" });
		setMainTableModel(mainTableModel);

		// 詳細テーブル
		ACTableModelAdapter detailTableModel = new ACTableModelAdapter();
		detailTableModel.setColumns(new String[] { "SERVICE_DATE",
				"DAY_IN_COUNT" });
		setDetailTableModel(detailTableModel);

		getTokubetsuTable().setModel(getMainTableModel());
		getDayDetailTable().setModel(getDetailTableModel());

		// 画面展開データの設定
		VRMap modelMap = new VRHashMap();

		modelMap.setData("PROVIDER", providerList);
		getContents().setModelSource(modelMap);
		getContents().bindModelSource();

		if (getProviderService().size() > 0) {
			// 1行目の選択
			getProviderCombo().setSelectedIndex(0);
			// 画面状態制御
			setState_ENABLE_DIALOG_TRUE();

		} else {
			// 画面状態制御
			setState_ENABLE_DIALOG_FALSE();

		}

		// 表示
		setVisible(true);

	}

	/**
	 * 「事業所コンボ選択時」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void providerComboActionPerformed(ActionEvent e) throws Exception {

		VRList serviceList = new VRArrayList();
		VRMap modelMap = new VRHashMap();

		if (!getProviderCombo().isSelected()) {
			// 未選択なら処理中断
			return;
		}

		// 選択事業所から対象サービスを取得
		VRMap providerInfo = (VRMap) getProviderCombo().getSelectedModelItem();
		String providerID = ACCastUtilities.toString(
				providerInfo.getData("PROVIDER_ID"), "");

		// 選択されている事業所のサービスリストを設定
		serviceList = (VRArrayList) getProviderService().getData(providerID);

		// 画面展開
		modelMap.setData("SERVICE", serviceList);
		getContents().setModelSource(modelMap);
		getContents().bindModelSource();

		if (serviceList.size() > 0) {
			getServiceCombo().setSelectedIndex(0);
		}

	}

	/**
	 * 「特定診療費・特別療養費計算」に関する処理を行ないます。
	 * 
	 * @param ArrayList
	 *            <Map>> tokuteiMap Map<String,
	 * @throws Exception
	 *             処理例外
	 * @return VRList
	 */
	public VRList calcDiagnosis(Map<String, ArrayList<Map>> tokuteiMap)
			throws Exception {

		VRMap detail = new VRHashMap();

		// メインテーブルデータ
		VRMap resultMap = new VRHashMap();
		VRList resultList = new VRArrayList();
		// 詳細テーブルデータ
		VRMap resultDetailMap = new VRHashMap();
		VRList resultDetailList = new VRArrayList();

		for (Entry<String, ArrayList<Map>> tokuteiEntry : tokuteiMap.entrySet()) {

			String name = "";
			int count = 0;
			resultDetailList = new VRArrayList();

			// 集計結果のループ
			ArrayList<Map> tokuteiList = (ArrayList) tokuteiEntry.getValue();
			for (int i = 0; i < tokuteiList.size(); i++) {
				detail = (VRHashMap) tokuteiList.get(i);
				count += ACCastUtilities.toInt(detail.getData("COUNT"), 0);
				name = ACCastUtilities.toString(detail.getData("NAME"), "");

				// 詳細
				resultDetailMap = new VRHashMap();
				resultDetailMap.setData("SERVICE_DATE",
						detail.getData("SERVICE_DATE"));
				resultDetailMap.setData("DAY_IN_COUNT",
						ACCastUtilities.toInt(detail.getData("COUNT"), 0));
				resultDetailList.add(resultDetailMap);

			}
			// 結果の格納
			resultMap = new VRHashMap();
			resultMap.setData("NAME", name);
			resultMap.setData("TOTAL_COUNT", count);
			resultMap.setData("DETAIL", resultDetailList);

			resultList.add(resultMap);

		}

		return resultList;
	}

}
