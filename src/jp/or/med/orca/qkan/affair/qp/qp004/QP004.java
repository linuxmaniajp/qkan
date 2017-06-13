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
 * 作成日: 2006/02/06  日本コンピューター株式会社 上司　和善
 * 更新日: 2006/03/09
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (004)
 * プログラム 明細書基本情報編集 (QP004)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp004;

import java.awt.event.ActionEvent;
import java.awt.im.InputSubset;
import java.text.Format;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACTableCellViewerCustomCell;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACCharacterConverter;
import jp.nichicom.ac.text.ACTextFieldDocument;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qp.qp003.QP003;
import jp.or.med.orca.qkan.affair.qp.qp005.QP005;
import jp.or.med.orca.qkan.component.QkanDateTextField;
import jp.or.med.orca.qkan.text.QkanCustomForClaimCodeMasterFormat;

/**
 * 明細書基本情報編集(QP004)
 */
public class QP004 extends QP004Event {
	/**
	 * コンストラクタです。
	 */
	public QP004() {
	}

	public void initAffair(ACAffairInfo affair) throws Exception {
		super.initAffair(affair);
		initAction(affair);
	}

	/**
	 * 初期化処理を行ないます。
	 * 
	 * @param affair
	 *            業務情報
	 * @throws Exception
	 *             処理例外
	 */

	protected void initAction(ACAffairInfo affair) throws Exception {
		// 下記の渡りパラメータを退避する。
		// ・patientId KEY：PATIENT_ID
		// ・claimDate KEY：CLAIM_DATE
		// ・insuredId KEY：INSURED_ID
		// ・providerId KEY：PROVIDER_ID
		// ・listIndex KEY：LIST_INDEX
		// ・targetDate KEY：TARGET_DATE
		// ・claimStyleType KEY：CLAIM_STYLE_TYPE

		VRMap parameters = affair.getParameters();

		if (VRBindPathParser.has("PATIENT_ID", parameters)) {
			setPatientId(ACCastUtilities.toInt(parameters.getData("PATIENT_ID")));
		}

		if (VRBindPathParser.has("CLAIM_DATE", parameters)) {
			setClaimDate(ACCastUtilities.toDate(parameters.getData("CLAIM_DATE")));
		}

		if (VRBindPathParser.has("INSURED_ID", parameters)) {
			setInsuredId(ACCastUtilities.toString(parameters.getData("INSURED_ID")));
		}

		if (VRBindPathParser.has("PROVIDER_ID", parameters)) {
			setProviderId(ACCastUtilities.toString(parameters.getData("PROVIDER_ID")));
		}

		if (VRBindPathParser.has("LIST_INDEX", parameters)) {
			setListIndex(ACCastUtilities.toInt(parameters.getData("LIST_INDEX")));
		}

		if (VRBindPathParser.has("TARGET_DATE", parameters)) {
			setTargetDate(ACCastUtilities.toDate(parameters.getData("TARGET_DATE")));
		}

		if (VRBindPathParser.has("CLAIM_STYLE_TYPE", parameters)) {
			setClaimStyleType(ACCastUtilities.toInt(parameters.getData("CLAIM_STYLE_TYPE")));
		}

		// パッシブチェックのキーを定義する。
		// TABLE：CLAIM
		// キー：CLAIM_ID
		// フォーマット：数値
		// クライアントタイムフィールド：LAST_TIME
		// サーバタイムフィールド：LAST_TIME
		setPASSIVE_CHECK_KEY(new ACPassiveKey("CLAIM", new String[] { "CLAIM_ID" }, new Format[] { null }, "LAST_TIME", "LAST_TIME"));

		// ルーチンテスト用領域
		// スナップショットの撮影対象を「クライアント領域（contents）」に設定する。
		//[ID:0000545][Shin Fujihara] 2009/08 delete begin 2009年度障害対応
		//getSnapshot().setRootContainer(getContents());
		//[ID:0000545][Shin Fujihara] 2009/08 delete end 2009年度障害対応
		// 画面の初期化を行う。
		initialize();

		// 請求データを取得し、画面に展開する。
		doFind();

		// スナップショットを撮影する。
		//[ID:0000545][Shin Fujihara] 2009/08 delete begin 2009年度障害対応
		getSnapshot().snapshot();
		//[ID:0000545][Shin Fujihara] 2009/08 delete end 2009年度障害対応
		
		//[ID:0000545][Shin Fujihara] 2009/08 add begin 2009年度障害対応
		//リストオブジェクトのスナップショット取得
		doSnapList();
		//[ID:0000545][Shin Fujihara] 2009/08 add end 2009年度障害対応

	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		// 変更チェック（スナップショットのチェック、画面テーブルのチェック）
		// 最後に保存されてから、項目・画面テーブルが変更されている場合(下記のいずれかの場合)
		// ・isModified
		// ・tableChangedFlg = 1
		// 確認メッセージを表示する。
		// ・メッセージID：WARNING_OF_UPDATE_ON_MODIFIED
		// 「はい」を選択した場合
		// 入力チェックを行う。
		// 入力エラーがあった場合
		// 処理を中断する。(終了)
		// [ID:0000545][Shin Fujihara] 2009/08 edit begin 2009年度障害対応
		//if (getSnapshot().isModified() || (getTableChangedFlg() == FLAG_ON)) {
		if (isListModified()) {
		//[ID:0000545][Shin Fujihara] 2009/08 edit end 2009年度障害対応
			int selectButton = QkanMessageList.getInstance().WARNING_OF_UPDATE_ON_MODIFIED();
			switch (selectButton) {
				case ACMessageBox.RESULT_YES:
					if (isValidInput() && doSave()) {
						// 保存処理を行う。
					} else {
						// 保存処理が正常終了しなかった場合
						// 処理を中断する。(終了)

						return false;
					}
					break;

				case ACMessageBox.RESULT_CANCEL:
					return false;

				default:
			}
		}
		// 下記を渡りパラメータとして、「QP003 帳票（様式）・事業所選択」画面に遷移する。
		// ・KEY：PATIENT_ID VALUE：patientId
		// ・KEY：CLAIM_DATE VALUE：claimDate
		// ・KEY：LIST_INDEX VALUE：listIndex
		parameters.setData("PATIENT_ID", ACCastUtilities.toInteger(getPatientId()));
		parameters.setData("CLAIM_DATE", getClaimDate());
		parameters.setData("LIST_INDEX", ACCastUtilities.toInteger(getListIndex()));

		// KEY：NEXT_AFFAIR VALUE：QP003
		parameters.setData("NEXT_AFFAIR", "QP003");

		// QP003 帳票（様式）・事業所選択で使用する渡しパラメーターの作成を行う。
		ACAffairInfo affair = new ACAffairInfo(QP003.class.getName(), parameters);
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// 変更チェック（スナップショット、テーブルのチェック）
		// 最後に保存されてから、項目・画面テーブルが変更されている場合(下記のいずれかの場合)
		//[ID:0000545][Shin Fujihara] 2009/08 edit begin 2009年度障害対応
		//if (getSnapshot().isModified() || (getTableChangedFlg() == FLAG_ON)) {
		if (isListModified()) {
		//[ID:0000545][Shin Fujihara] 2009/08 edit end 2009年度障害対応
			if (QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED() == ACMessageBox.RESULT_YES) {
				// ・isModified
				// ・tableChangedFlg = 1
				// 終了確認メッセージを表示する。
				// ・メッセージID：WARNING_OF_CLOSE_ON_MODIFIED
			} else {
				// 「キャンセル」を選択した場合
				// 処理を中断する（何もしない）。
				// システムを終了する。
				return false;
			}
		}
		return true;
	}

	// コンポーネントイベント

	/**
	 * 「DB登録」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void updateActionPerformed(ActionEvent e) throws Exception {
		// 入力チェックを行う。
		if (isValidInput()) {
			// 保存処理を行う。
			if (doSave()) {
				// 保存処理が正常終了した場合
				// changedFlgに0（変更なし）を代入する。
				setTableChangedFlg(FLAG_OFF);
				// 完了メッセージを表示する。
				QkanMessageList.getInstance().UPDATE_SUCCESSED();
				// ・メッセージID：UPDATE_SUCCESSED
			} else {
				// 保存処理が正常終了しなかった場合
				// 処理を中断する。(終了)
			}
		}
		// 入力エラーがあった場合
		// 処理を中断する。(終了)
	}

	/**
	 * 「詳細」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void detailActionPerformed(ActionEvent e) throws Exception {
		// 変更チェック（スナップショットのチェック、画面テーブルのチェック）
		// 最後に保存されてから、項目・画面テーブルが変更されている場合(下記のいずれかの場合)
		// ・isModified
		// ・tableChangedFlg = 1
		// 確認メッセージを表示する。
		// ・メッセージID：WARNING_OF_UPDATE_ON_MODIFIED
		// 「はい」を選択した場合
		// 入力チェックを行う。
		// 入力エラーがあった場合
		// 処理を中断する。(終了)
		//[ID:0000545][Shin Fujihara] 2009/08 edit begin 2009年度障害対応
		//if (getSnapshot().isModified() || (getTableChangedFlg() == FLAG_ON)) {
		if (isListModified()) {
		//[ID:0000545][Shin Fujihara] 2009/08 edit end 2009年度障害対応
			int selectButton = ACMessageBox.showYesNoCancel("変更されています。" + ACConstants.LINE_SEPARATOR + "更新しますか？", "更新して進む(U)", 'U', "破棄して進む(R)", 'R', ACMessageBox.FOCUS_CANCEL);
			switch (selectButton) {
				case ACMessageBox.RESULT_YES:
					if (isValidInput() && doSave()) {
						// 保存処理を行う。
					} else {
						// 保存処理が正常終了しなかった場合
						// 処理を中断する。(終了)
						return;
					}
					break;

				case ACMessageBox.RESULT_CANCEL:
					return;

				default:

			}
		}

		// 詳細に受け渡すパラメータを格納、作成する。
		VRMap parameters = new VRHashMap();
		parameters.setData("PATIENT_ID", ACCastUtilities.toInteger(getPatientId()));
		parameters.setData("CLAIM_DATE", getClaimDate());
		parameters.setData("INSURED_ID", getInsuredId());
		parameters.setData("PROVIDER_ID", getProviderId());
		parameters.setData("LIST_INDEX", ACCastUtilities.toInteger(getListIndex()));
		parameters.setData("TARGET_DATE", getTargetDate());
		parameters.setData("CLAIM_STYLE_TYPE", ACCastUtilities.toInteger(getClaimStyleType()));

		// QP005 介護明細書詳細編集で使用する渡しパラメーターの作成を行う。
		ACAffairInfo affair = new ACAffairInfo(QP005.class.getName(), parameters);
		ACFrame.getInstance().next(affair);
	}

	/**
	 * 「摘要欄説明を表示」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void tekiyoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		if (getTekiyoTable().isSelected()) {
			// 選択されている場合
			// 選択されているレコードのDETAIL_SUMMARY_MEMOを、摘要欄記載事項テキスト（tekiyoText）に表示する。
			VRMap selectedRowValueMap = (VRMap) getTekiyoTable().getSelectedModelRowValue();
			getTekiyoText().setText(ACCastUtilities.toString(selectedRowValueMap.getData("DETAIL_SUMMARY_MEMO")));
		} else {
			// 選択されていない場合
			// FIRST_SUMMARY_MEMOを摘要欄記載事項テキスト（tekiyoText）に表示する。
			getTekiyoText().setText(FIRST_SUMMARY_MEMO);
		}
	}

	/**
	 * 「摘要欄説明を表示」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void sinryoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		if (getSinryoTable().isSelected()) {
			// 選択されている場合
			// 選択されているレコードのSPECIAL_CLINIC_SUMMARY_MEMOを、特定診療費テキスト（shinryoText）に表示する。
			VRMap selectedRowValueMap = (VRMap) getSinryoTable().getSelectedModelRowValue();
			getShinryoText().setText(ACCastUtilities.toString(selectedRowValueMap.getData("SPECIAL_CLINIC_SUMMARY_MEMO")));
		} else {
			// 選択されていない場合
			// FIRST_SUMMARY_MEMOを摘要欄記載事項テキスト（tekiyoText）に表示する。
			getTekiyoText().setText(FIRST_SUMMARY_MEMO);
		}

	}

	/**
	 * 「変更フラグを立てる」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void tekiyoTekiyoColumnCellEditing(ChangeEvent e) throws Exception {
		// tableChangedFlgに1（変更あり）を代入する。
		setTableChangedFlg(FLAG_ON);
	}

	/**
	 * 「変更フラグを立てる」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void sinryoTekiyoColumnCellEditing(ChangeEvent e) throws Exception {
		// tableChangedFlgに1（変更あり）を代入する。
		setTableChangedFlg(FLAG_ON);
	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();

		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		param.setData("PATIENT_ID", new Integer(8));
		param.setData("CLAIM_DATE", ACDateUtilities.createDate(2008, 6, 1));
		param.setData("INSURED_ID", "8888888888");
		param.setData("PROVIDER_ID", "2000000000");
		param.setData("LIST_INDEX", new Integer(0));
		param.setData("TARGET_DATE", ACDateUtilities.createDate(2008, 5, 1));
		param.setData("INSURER_ID", "111111");
		param.setData("CLAIM_STYLE_TYPE", new Integer(10411));
		ACFrame.debugStart(new ACAffairInfo(QP004.class.getName(), param));
	}

	// 内部関数

	/**
	 * 「データの取得・画面設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFind() throws Exception {
		// データの取得・画面設定
		// 請求データを取得するためのwhere句を用意する。
		// WHERE句
		
// 2015/1/14 [Yoichiro Kamei] mod - begin 住所地特例対応
//		String whereStr = "(PATIENT_ID = " + getPatientId() + ") " + "AND (INSURED_ID = '" + getInsuredId() + "') " + "AND (TARGET_DATE = '" + VRDateParser.format(getTargetDate(), "yyyy-MM-dd") + "') " + "AND (CLAIM_DATE = '" + VRDateParser.format(getClaimDate(), "yyyy-MM-dd") + "') " + "AND (PROVIDER_ID = '" + getProviderId() + "') " + "AND (CLAIM_STYLE_TYPE = " + getClaimStyleType() + ") " + "AND (CATEGORY_NO IN (2, 3, 5, 7))";
		String whereStr = "(PATIENT_ID = " + getPatientId() + ") " + "AND (INSURED_ID = '" + getInsuredId() + "') " + "AND (TARGET_DATE = '" + VRDateParser.format(getTargetDate(), "yyyy-MM-dd") + "') " + "AND (CLAIM_DATE = '" + VRDateParser.format(getClaimDate(), "yyyy-MM-dd") + "') " + "AND (PROVIDER_ID = '" + getProviderId() + "') " + "AND (CLAIM_STYLE_TYPE = " + getClaimStyleType() + ") " + "AND (CATEGORY_NO IN (2, 3, 5, 7, 18))";
// 2015/1/14 [Yoichiro Kamei] mod - end
		
		try {
			// トランザクションを開始する。
			getDBManager().beginTransaction();
			// 請求データを取得し、VRList dataListに格納する。
			VRList dataList = QkanCommon.getClaimDetailCustom(getDBManager(), getClaimDate(), whereStr);

			// コミットする。
			getDBManager().commitTransaction();

			// パッシブチェック用にlistを退避する。
			getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), dataList);

			// dataListから基本情報、明細情報、特定治療費、特定診療費、集計情報をそれぞれ抽出する。
			doFindCategory(dataList);

		} catch (Exception ex) {
			// SQL文実行処理でエラーが発生した場合
			// 処理をロールバックする。
			getDBManager().rollbackTransaction();
			// 例外エラーを投げる。
			// 処理を抜ける。（異常終了）
			throw ex;
		}

		// 基本情報レコードをsetSourceする
		if (!(getClaimListBasic() == null || getClaimListBasic().isEmpty())) {
			VRMap map = (VRMap) getClaimListBasic().getData(0);
			// 短期入所系の場合
			if (getClaimStyleType() == CLAIM_STYLE_TYPE31
			        || getClaimStyleType() == CLAIM_STYLE_TYPE32
			        || getClaimStyleType() == CLAIM_STYLE_TYPE41
			        || getClaimStyleType() == CLAIM_STYLE_TYPE42
			        || getClaimStyleType() == CLAIM_STYLE_TYPE51
			        || getClaimStyleType() == CLAIM_STYLE_TYPE52
			        || getClaimStyleType() == CLAIM_STYLE_TYPE65
			        || getClaimStyleType() == CLAIM_STYLE_TYPE66
			        || getClaimStyleType() == CLAIM_STYLE_TYPE67) {

				if (!(getClaimListTotal() == null || getClaimListTotal().isEmpty())) {
					VRMap temp = (VRMap) getClaimListTotal().getData(0);
					if (temp != null) {
						Object obj = VRBindPathParser.get("701008", temp);
						VRBindPathParser.set("701008", map, obj);
					}
				}
			}
			setSource(map);
		}

		// 明細情報レコード集合がnullでない場合
		// 明細情報レコード集合をtableModelDetailに設定する。

		if (!(getClaimListDetail() == null || getClaimListDetail().isEmpty())) {
			getTableModelDetail().setAdaptee(getClaimListDetail());
			getTekiyoTable().setSelectedSortedFirstRow();
		}

		// 特定診療費レコード集合がnullでない場合
		// 特定診療費レコード集合をtableModelSpecialClinicに設定する。
		if (!(getClaimListSpecialClinic() == null || getClaimListSpecialClinic().isEmpty())) {
			getTableModelSpecialClinic().setAdaptee(getClaimListSpecialClinic());
			getSinryoTable().setSelectedSortedFirstRow();
		}

		// mapを「クライアント領域（contents）」に設定する。
		// 画面に展開する。
		bindSource();

	}

	/**
	 * 「各レコード集合の抽出」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindCategory(VRList claimDataList) throws Exception {

		// CATEGORY_NOが5であるmapを抽出してcategoryList5に格納する
		List categoryList5 = ACBindUtilities.getMatchListFromValue(claimDataList, "CATEGORY_NO", new Integer(CATEGORY_NO5));

		// 各レコード集合の抽出
		// 請求データ（claimDataList）を順に見ていく。（ループ開始）
		Iterator claimDataListIterator = claimDataList.iterator();
		while (claimDataListIterator.hasNext()) {
			VRMap claimDataMap = (VRMap) claimDataListIterator.next();

			// 基本情報レコードの場合（CATEGORY_NO = 2）
			if (new Integer(CATEGORY_NO2).equals(claimDataMap.getData("CATEGORY_NO"))) {
				// 基本情報レコードをclaimListBasicに追加する。
				getClaimListBasic().addData(claimDataMap);
			}

// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
			// 明細情報（住所地特例）のバインドパスを明細情報のパスにコピーして、明細情報として処理させる
			QkanCommon.convertPathJushotiTokureiToDetail(claimDataMap);
// 2015/1/14 [Yoichiro Kamei] add - end
			
			// 明細情報レコードの場合（CATEGORY_NO = 3）
// 2015/1/14 [Yoichiro Kamei] mod - begin 住所地特例対応
//			if (new Integer(CATEGORY_NO3).equals(claimDataMap.getData("CATEGORY_NO"))) {
			if (new Integer(CATEGORY_NO3).equals(claimDataMap.getData("CATEGORY_NO")) ||
				new Integer(CATEGORY_NO18).equals(claimDataMap.getData("CATEGORY_NO"))) {
// 2015/1/14 [Yoichiro Kamei] mod - end
				
				// 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
				VRMap firstServiceCodeMaster;
				String systemServiceKindCode = ACCastUtilities.toString(claimDataMap.getData(SYSTEM_SERVICE_KIND_CODE));
				String sjCodeKey = ACCastUtilities.toString(claimDataMap.getData(SYSTEM_SERVICE_ITEM_CODE));
				if (QkanSjServiceCodeManager.teiritsuTeigakuCodes.contains(systemServiceKindCode)) {
					firstServiceCodeMaster = QkanSjServiceCodeManager.getSjServiceCodeByKey(getDBManager(), sjCodeKey, getTargetDate());
				} else {
				// 2016/10/11 [Yoichiro Kamei] add - end
					// SQL文取得用のHashMap：paramを生成し、システムサービス種類コード（KEY：301021）、システムサービス項目コード（KEY：301022）を
					VRMap param = new VRHashMap();
					// 取り出し、下記のKEY/VALUEで設定する。
					// ・KEY：SYSTEM_SERVICE_KIND_DETAIL VALUE：取り出したシステムサービス種類コード
					// ・KEY：SYSTEM_SERVICE_CODE_ITEM VALUE：取り出したシステムサービス項目コード
					// ・KEY：TARGET_DATE VALUE：targetDate

					param.setData("SYSTEM_SERVICE_KIND_DETAIL", claimDataMap.getData(SYSTEM_SERVICE_KIND_CODE));
					param.setData("SYSTEM_SERVICE_CODE_ITEM", claimDataMap.getData(SYSTEM_SERVICE_ITEM_CODE));
					param.setData("TARGET_DATE", getTargetDate());

					// DB（M_SERVICE_CODE）より該当するサービス名称、摘要欄記載必須フラグ、摘要欄説明、クラス種類、コードIDを取得する。
					VRList serviceCodeMaster = getDBManager().executeQuery(getSQL_GET_SERVICE_NAME(param));
					
					// DBより取得したデータの最初のレコードの摘要欄記載必須フラグ（SUMMARY_FLAG）が0の場合
					// 2016/10/11 [Yoichiro Kamei] mod - begin 総合事業対応
					//VRMap firstServiceCodeMaster = (VRMap) serviceCodeMaster.getData(0);
					firstServiceCodeMaster = (VRMap) serviceCodeMaster.getData(0);
				}
				// 2016/10/11 [Yoichiro Kamei] mod - end

				if (new Integer(FLAG_OFF).equals(firstServiceCodeMaster.getData("SUMMARY_FLAG"))) {
					// 明細情報レコードをclaimListHideDetail（表示しない明細情報レコード）に追加する。
					// ループ開始へ戻る。
					getClaimListHideDetail().addData(claimDataMap);
				} else if (new Integer(FLAG_ON).equals(firstServiceCodeMaster.getData("SUMMARY_FLAG"))) {
					// DBより取得したデータの最初のレコードの摘要欄記載必須フラグ（SUMMARY_FLAG）が1の場合
					// DBより取得したデータの最初のレコードのデータを、明細情報レコードに下記のKEY/VALUEで設定する。
					// ・KEY：SERVICE_NAME VALUE：SERVICE_NAME（DBより取得したサービス名称）
					// ・KEY：DETAIL_SUMMARY_MEMO
					// VALUE：SUMMARY_MEMO（DBより取得した摘要欄説明）
					// ・KEY：CLASS_TYPE VALUE：CLASS_TYPE（DBより取得したクラス種類）
					// ・KEY：CODE_ID VALUE：CODE_ID（DBより取得したコードID）

					claimDataMap.setData("SERVICE_NAME", firstServiceCodeMaster.getData("SERVICE_NAME"));
					claimDataMap.setData("DETAIL_SUMMARY_MEMO", firstServiceCodeMaster.getData("SUMMARY_MEMO"));
					claimDataMap.setData("CLASS_TYPE", firstServiceCodeMaster.getData("CLASS_TYPE"));
					claimDataMap.setData("CODE_ID", firstServiceCodeMaster.getData("CODE_ID"));
					
					//[ID:0000737][Shin Fujihara] 2012/05 add begin 重度療養管理加算のコード変換
					doChangeTekiyoForDisplayCategory3(claimDataMap);
					//[ID:0000737][Shin Fujihara] 2012/05 add end

					// 摘要欄記載事項一覧テーブルの行のコンポーネントの設定を行う。
					// ・第一引数：HashMap（明細情報レコード）
					// ・第ニ引数：columnListDetail
					doSetTableRow(claimDataMap, getColumnListDetail(), ACCastUtilities.toInt(claimDataMap.getData("CATEGORY_NO")));

					// 明細情報レコードをclaimListDetailに追加する。
					getClaimListDetail().addData(claimDataMap);
				}
			}

			if (new Integer(CATEGORY_NO5).equals(claimDataMap.getData("CATEGORY_NO"))) {

				// KEY：501007（レコード順次番号）の値が1の場合
				// レコードに特定診療費傷病名テキストの以下のKEYに値を設定する。
				// ・KEY：501008（傷病名）
				if (categoryList5.size() == 1) {
					if (FLAG_END.equals(ACCastUtilities.toInteger(claimDataMap.getData("501007")))) {
						if (!ACTextUtilities.isNullText(claimDataMap.getData("501008"))) {
							getShinryoDeseaseText().setText(ACCastUtilities.toString(claimDataMap.getData("501008")));
						}
					}
				} else if (categoryList5.size() > 1) {
					if (FLAG_START.equals(ACCastUtilities.toInteger(claimDataMap.getData("501007")))) {
						if (!ACTextUtilities.isNullText(claimDataMap.getData("501008"))) {
							getShinryoDeseaseText().setText(ACCastUtilities.toString(claimDataMap.getData("501008")));
						}
					}
				}
				// 特定診療費情報レコードの場合（CATEGORY_NO = 5）
				// SQL文取得用のHashMap：paramを生成し、識別番号（KEY：501009）を取得し、下記のKEY/VALUEで設定する。
				// ・KEY：SPECIAL_CLINIC_TYPE VALUE：取得した識別番号
				// ・KEY：TARGET_DATE VALUE：targetDate
				VRMap param = new VRHashMap();
				param.setData("SPECIAL_CLINIC_TYPE", claimDataMap.getData(SPECIAL_CLINIC_FLAG_CODE));
				param.setData("TARGET_DATE", getTargetDate());
				//[H20.5 法改正対応] fujihara add start
				param.setData("RECORD_TYPE", "1");
				switch (getClaimStyleType()){
					case CLAIM_STYLE_TYPE41:
					case CLAIM_STYLE_TYPE42:
					case CLAIM_STYLE_TYPE9:
						param.setData("RECORD_TYPE", "2");
						break;
				}
				//[H20.5 法改正対応] fujihara add end

				// DBより特定診療費名、摘要欄説明、クラス種類、コードIDを取得する。
				VRList serviceCodeMaster = getDBManager().executeQuery(getSQL_GET_SPECIAL_CLINIC_NAME(param));
				VRMap firstServiceCodeMaster = (VRMap) serviceCodeMaster.getData(0);

				// DBより取得したレコードより特定診療費名と適用欄説明を取得し、特定診療費レコードに下記のKEY/VALUEで設定する。
				// ・KEY：SPECIAL_CLINIC_NAME VALUE：取得した特定診療費名
				// ・KEY：SPECIAL_CLINIC_SUMMARY_MEMO VALUE：取得した摘要欄説明
				// ・KEY： VALUE：（DBより取得したクラス種類）
				// ・KEY：CODE_ID VALUE：CODE_ID（DBより取得したコードID）

				claimDataMap.setData("SPECIAL_CLINIC_NAME", firstServiceCodeMaster.getData("SPECIAL_CLINIC_NAME"));
				claimDataMap.setData("SPECIAL_CLINIC_SUMMARY_MEMO", firstServiceCodeMaster.getData("SUMMARY_MEMO"));
				claimDataMap.setData("CLASS_TYPE", firstServiceCodeMaster.getData("CLASS_TYPE"));
				claimDataMap.setData("CODE_ID", firstServiceCodeMaster.getData("CODE_ID"));
				
				//[ID:0000737][Shin Fujihara] 2012/05 add begin 短期入所療養介護で重度療養管理(35)の場合は、摘要欄を変更
                switch (getClaimStyleType()){
                case CLAIM_STYLE_TYPE41:
                case CLAIM_STYLE_TYPE42:
                    if ("35".equals(ACCastUtilities.toString(claimDataMap.getData(SPECIAL_CLINIC_FLAG_CODE), ""))) {
                        claimDataMap.setData("CODE_ID", new Integer(286));
                    }
                    break;
                }
				//[ID:0000737][Shin Fujihara] 2012/05 add end

				// 画面表示用にデータを変換する。
				doChangeTekiyoForDisplay(claimDataMap);
				// ・第一引数：HashMap（特定診療費レコード）

				// 特定診療費一覧テーブルの行のコンポーネントの設定を行う。
				doSetTableRow(claimDataMap, getColumnListSpecialClinic(), ACCastUtilities.toInt(claimDataMap.getData("CATEGORY_NO")));
				// ・第一引数：HashMap（特定診療費レコード）
				// ・第ニ引数：columnListSpecialClinic
				// 特定診療費レコードをclaimListSpecialClinicに追加する。
				getClaimListSpecialClinic().addData(claimDataMap);

			}

			// 集計情報レコードの場合（CATEGORY_NO = 7）
			if (new Integer(CATEGORY_NO7).equals(claimDataMap.getData("CATEGORY_NO"))) {
				// 基本情報レコードをclaimListBasicに追加する。
				getClaimListTotal().addData(claimDataMap);
			}

		}
		// columnListDetailを摘要欄記載事項一覧テーブルの「摘要」列に設定する。
		// columnListSpecialClinicを特定診療費一覧テーブルの「摘要」列に設定する。
		getTekiyoTekiyoColumn().setCustomCells(getColumnListDetail());
		getSinryoTekiyoColumn().setCustomCells(getColumnListSpecialClinic());
	}

	/**
	 * 「画面の状態設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doControlState() throws Exception {
		
		// 画面の状態設定
		// 帳票様式第2の場合（claimStyleType = 2）
		// 画面のVisible制御を行う。
		if (getClaimStyleType() == CLAIM_STYLE_TYPE21 || getClaimStyleType() == CLAIM_STYLE_TYPE22) {
			setState_STATE_TYPE_2();
			// ・状態ID：STATE_TYPE_2
			setState_STATE_NYUSYO_HIDE();
		}

		// 帳票様式第2の3の場合（claimStyleType = 23）
		// 画面のVisible制御を行う。
		if (getClaimStyleType() == CLAIM_STYLE_TYPE23) {
			setState_STATE_TYPE_23();
			// ・状態ID：STATE_TYPE_2
			setState_STATE_NYUSYO_HIDE();
		}

		// 帳票様式第3の場合（claimStyleType = 3）
		// 画面のVisible制御を行う。
		if (getClaimStyleType() == CLAIM_STYLE_TYPE31 || getClaimStyleType() == CLAIM_STYLE_TYPE32) {
			setState_STATE_TYPE_3();
			// ・状態ID：STATE_TYPE_3
			setState_STATE_NYUSYO_HIDE();
		}

		// 帳票様式第4の場合（claimStyleType = 4）
		// 画面のVisible制御を行う。
		if (getClaimStyleType() == CLAIM_STYLE_TYPE41 || getClaimStyleType() == CLAIM_STYLE_TYPE42) {
			setState_STATE_TYPE_4();
			// ・状態ID：STATE_TYPE_4
            getShinryos().setVisible(true);
            getShinryos().setText("特別療養費");
            
            setState_STATE_NYUSYO_HIDE();
		}

		// 帳票様式第5の場合（claimStyleType = 5）
		// 画面のVisible制御を行う。
		if (getClaimStyleType() == CLAIM_STYLE_TYPE51 || getClaimStyleType() == CLAIM_STYLE_TYPE52) {
			setState_STATE_TYPE_5();
			// ・状態ID：STATE_TYPE_5
			setState_STATE_NYUSYO_HIDE();
		}

		// 帳票様式第6の場合（claimStyleType = 6）
		// 画面のVisible制御を行う。
		if (getClaimStyleType() == CLAIM_STYLE_TYPE61 || getClaimStyleType() == CLAIM_STYLE_TYPE62 || getClaimStyleType() == CLAIM_STYLE_TYPE63 || getClaimStyleType() == CLAIM_STYLE_TYPE64) {
			setState_STATE_TYPE_6();
			// ・状態ID：STATE_TYPE_6
			setState_STATE_NYUSYO_SHOW();
		}

		// 帳票様式第6の5と6の6の場合（claimStyleType = 65と66）
		// 画面のVisible制御を行う。
		if (getClaimStyleType() == CLAIM_STYLE_TYPE65 || getClaimStyleType() == CLAIM_STYLE_TYPE66 || getClaimStyleType() == CLAIM_STYLE_TYPE67) {
			setState_STATE_TYPE_65();
			// ・状態ID：STATE_TYPE_65
			setState_STATE_NYUSYO_HIDE();
		}

		// 帳票様式第8の場合（claimStyleType = 8）
		// 画面のVisible制御を行う。
		if (getClaimStyleType() == CLAIM_STYLE_TYPE8) {
			setState_STATE_TYPE_8();
			// ・状態ID：STATE_TYPE_8
			setState_STATE_NYUSYO_SHOW();
		}

		if (getClaimStyleType() == CLAIM_STYLE_TYPE9) {
			// 帳票様式第9の場合（claimStyleType = 9）
			// 画面のVisible制御を行う。
			setState_STATE_TYPE_9();
			// ・状態ID：STATE_TYPE_9
            getShinryos().setVisible(true);
            getShinryos().setText("特別療養費");
            
            setState_STATE_NYUSYO_SHOW();
		}

		if (getClaimStyleType() == CLAIM_STYLE_TYPE10) {
			// 帳票様式第10の場合（claimStyleType = 10）
			// 画面のVisible制御を行う。
			setState_STATE_TYPE_10();
			// ・状態ID：STATE_TYPE_10
			setState_STATE_NYUSYO_SHOW();
		}
		
	}

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean isValidInput() throws Exception {
		// 入力チェック
		// 下記のフィールドのVisibleがTrueで、かつ入力されている場合、存在する日付かどうかチェックする。

		// ・開始年月日（contentsStartDate）
		// ※エラーの場合、String：msgParamを宣言し、"開始年月日の"を代入する。
		if (!checkValidDate(getContentsStartDate(), "開始年月日の")) {
			return false;
		}

		// ・終了年月日（contentsStopDate）
		// ※エラーの場合、String：msgParamを宣言し、"終了年月日の"を代入する。
		if (!checkValidDate(getContentsStopDate(), "終了年月日の")) {
			return false;
		}

		// ・入所（院）年月日（contentsNyushoDate）
		// ※エラーの場合、String：msgParamを宣言し、"入所（院）年月日の"を代入する。
		if (!checkValidDate(getContentsNyushoDate(), "入所（院）年月日の")) {
			return false;
		}

		// ・退所（院）年月日（contentsTaishoDate）
		// ※エラーの場合、String：msgParamを宣言し、"退所（院）年月日の"を代入する。
		if (!checkValidDate(getContentsTaishoDate(), "退所（院）年月日の")) {
			return false;
		}

		// 不正な値の場合
		// エラーメッセージを表示する。
		// ・メッセージID：ERROR_OF_WRONG_DATE
		// エラーが発生したインスタンスにフォーカスを当てる。
		// (処理を抜ける)

		// 下記のフィールドのVisibleがTrueで、かつ入力されている場合、未来の日付が入力されていないかチェックする。
		// ・開始年月日（contentsStartDate）
		// ※エラーの場合、String：msgParamを宣言し、"開始年月日に"を代入する。

		// ここから 日付関係から未来日の制限を解除 2006/05/19日 廣瀬
		// 	
		/*
		if (!checkFutureDate(getContentsStartDate(), "開始年月日に")) {
			return false;
		}

		// ・終了年月日（contentsStopDate）
		// ※エラーの場合、String：msgParamを宣言し、"終了年月日に"を代入する。
		if (!checkFutureDate(getContentsStopDate(), "終了年月日に")) {
			return false;
		}

		// ・入所（院）年月日（contentsNyushoDate）
		// ※エラーの場合、String：msgParamを宣言し、"入所（院）年月日に"を代入する。
		if (!checkFutureDate(getContentsNyushoDate(), "入所（院）年月日に")) {
			return false;
		}

		// ・退所（院）年月日（contentsTaishoDate）
		// ※エラーの場合、String：msgParamを宣言し、"退所（院）年月日に"を代入する。
		if (!checkFutureDate(getContentsTaishoDate(), "退所（院）年月日に")) {
			return false;
		}
		*/
		// ここまで 日付関係から未来日の制限を解除 2006/05/19日 廣瀬		
		
		// 不正な値の場合
		// エラーメッセージを表示する。
		// ・メッセージID：ERROR_OF_FUTURE_DATE
		// エラーが発生したインスタンスにフォーカスを当てる。
		// (処理を抜ける)

		// 下記のフィールドのVisibleがTrueで、かつ入力されている場合、日付の前後関係をチェックする。
		// ・開始年月日（contentsStartDate）
		// 終了年月日（contentsStopDate）
		// ※エラーの場合、String：msgParam1を宣言し、"開始年月日/終了年月日は"を代入する。
		// ※エラーの場合、String：msgParam2を宣言し、"開始年月日"を代入する。
		// ※エラーの場合、String：msgParam3を宣言し、"終了年月日"を代入する。
		if (!checkRelationDate(getContentsStartDate(), getContentsStopDate(), "開始年月日/終了年月日は", "開始年月日", "終了年月日")) {
			return false;
		}

		// ・入所（院）年月日（contentsNyushoDate）
		// 退所（院）年月日（contentsTaishoDate）
		// ※エラーの場合、String：msgParam1を宣言し、"入所（院）年月日/退所（院）年月日は"を代入する。
		// ※エラーの場合、String：msgParam2を宣言し、"入所（院）年月日"を代入する。
		// ※エラーの場合、String：msgParam3を宣言し、"退所（院）年月日"を代入する。
		// 不正な値の場合
		// エラーメッセージを表示する。

		if (!checkRelationDate(getContentsNyushoDate(), getContentsTaishoDate(), "入所（院）年月日/退所（院）年月日は", "入所（院）年月日", "退所（院）年月日")) {
			return false;
		}

		// 不正な値の場合
		// インスタンスにフォーカスをあてる。
		// ・メッセージID：ERROR_OF_GREATER_DATE_RELATION
		// エラーが発生したインスタンスにフォーカスを当てる。
		// (処理を抜ける)

		// 正常な値の場合trueを返す
		return true;
	}

	/**
	 * 「保存処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doSave() throws Exception {
		// 保存処理
		try {
			// トランザクションを開始する。
			getDBManager().beginTransaction();
			// パッシブチェックのタスクをクリアする。
			getPassiveChecker().clearPassiveTask();

			// 請求データ登録（DELETE, INSERT）のためのパッシブチェックを、下記のパッシブキーで行う。
			getPassiveChecker().addPassiveDeleteTask(getPASSIVE_CHECK_KEY());

			// ・PASSIVE_CHECK_KEY
			// パッシブチェックを行う。
			if (getPassiveChecker().passiveCheck(getDBManager())) {

				// 画面上のデータを取得する。
				// パネルから基本情報レコードを取得する
				VRMap saveMap = (VRMap) getClaimListBasic().getData(0);
				getContents().setSource(saveMap);
				getContents().applySource();

				// 基本情報レコード集合の下記のデータの型をDate型からString型（yyyyMMdd）に変換する。
				// ・KEY：201021（開始年月日）
				// ・KEY：201022（中止年月日）
				// ・KEY：201024（入所（院）年月日）
				// ・KEY：201025（退所（院）年月日）

				if (!ACTextUtilities.isNullText(saveMap.getData("201021"))) {
					saveMap.setData("201021", ACCastUtilities.toString(VRDateParser.format(ACCastUtilities.toDate(saveMap.getData("201021")), "yyyyMMdd")));
				}
				if (!ACTextUtilities.isNullText(saveMap.getData("201022"))) {
					saveMap.setData("201022", ACCastUtilities.toString(VRDateParser.format(ACCastUtilities.toDate(saveMap.getData("201022")), "yyyyMMdd")));
				}
				if (!ACTextUtilities.isNullText(saveMap.get("201024"))) {
					saveMap.setData("201024", ACCastUtilities.toString(VRDateParser.format(ACCastUtilities.toDate(saveMap.getData("201024")), "yyyyMMdd")));
				}
				if (!ACTextUtilities.isNullText(saveMap.getData("201025"))) {
					saveMap.setData("201025", ACCastUtilities.toString(VRDateParser.format(ACCastUtilities.toDate(saveMap.getData("201025")), "yyyyMMdd")));
				}

				// 短期入所系の場合
				if (getClaimStyleType() == CLAIM_STYLE_TYPE31
				        || getClaimStyleType() == CLAIM_STYLE_TYPE32
				        || getClaimStyleType() == CLAIM_STYLE_TYPE41
				        || getClaimStyleType() == CLAIM_STYLE_TYPE42
				        || getClaimStyleType() == CLAIM_STYLE_TYPE51
				        || getClaimStyleType() == CLAIM_STYLE_TYPE52
				        || getClaimStyleType() == CLAIM_STYLE_TYPE65 
				        || getClaimStyleType() == CLAIM_STYLE_TYPE66
				        || getClaimStyleType() == CLAIM_STYLE_TYPE67) {

					Object obj = VRBindPathParser.get("701008", saveMap);
					VRMap temp = (VRMap) getClaimListTotal().getData(0);
					if (temp != null) {
						VRBindPathParser.set("701008", temp, obj);
					}
					saveMap.remove("701008");
				}
				
		        //[ID:0000737][Shin Fujihara] 2012/05 add begin 重度療養管理加算のコード変換
		        //明細情報レコードがnulではない場合
		        if (!(getClaimListDetail() == null || getClaimListDetail().isEmpty())) {
		        	Iterator detailsIterator = getClaimListDetail().listIterator();
		        	
		        	while (detailsIterator.hasNext()) {
		        		VRMap row = (VRMap) detailsIterator.next();
		        		doChangeTekiyoForUpdateCategory3(row);
		        	}
		        }
		        //[ID:0000737][Shin Fujihara] 2012/05 add end

				// 特定診療費情報レコードがnullでない場合
				if (!(getClaimListSpecialClinic() == null || getClaimListSpecialClinic().isEmpty())) {
					Iterator specialClinicIterator = getClaimListSpecialClinic().listIterator();

					while (specialClinicIterator.hasNext()) {
						VRMap specialClinicRecord = (VRMap) specialClinicIterator.next();
						// 特定診療費情報レコード集合を順に見ていく。（ループ開始）
						// KEY：501009（識別番号）の値が35（重度療養管理）の場合
						if (new Integer(HEAVY_RECUPERATION_MANAGEMENT).equals(ACCastUtilities.toInteger(specialClinicRecord.getData("501009")))) {
							// DB更新用にデータを変換する。
							doChangeTekiyoForUpdate(specialClinicRecord);
							// ・引数：HashMap（特定診療費レコード）
						}
						if (getClaimListSpecialClinic().size() > 1) {
							if (FLAG_START.equals(ACCastUtilities.toInteger(specialClinicRecord.getData("501007")))) {
								// KEY：501007（レコード順次番号）の値が1の場合
								// レコードに特定診療費傷病名テキストの値を以下のKEYで設定する。
								// ・KEY：501008（傷病名）
								specialClinicRecord.setData("501008", getShinryoDeseaseText().getText());
							}
						} else if (getClaimListSpecialClinic().size() == 1) {
							if (FLAG_END.equals(ACCastUtilities.toInteger(specialClinicRecord.getData("501007")))) {
								specialClinicRecord.setData("501008", getShinryoDeseaseText().getText());
							}
						}
					}
				}

// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
		        //明細情報レコードがnulではない場合
		        if (!(getClaimListDetail() == null || getClaimListDetail().isEmpty())) {
		        	Iterator detailsIterator = getClaimListDetail().listIterator();
		        	
		        	while (detailsIterator.hasNext()) {
		        		VRMap claimDataMap = (VRMap) detailsIterator.next();
		        		//明細情報（住所地特例）レコードについて、変換しているバインドパスを元に戻す
		        		QkanCommon.convertPathJushotiTokureiToOriginal(claimDataMap);
		        	}
		        }
// 2015/1/14 [Yoichiro Kamei] add - end
				
				// 明細書情報レコードを取得する

				// 基本情報レコード集合・明細情報レコード集合・表示しない明細情報レコード集合・特定診療費レコード集合を1つのレコード集合にまとめる。
				VRList allList = new VRArrayList();

				allList.addAll(getClaimListBasic());
				allList.addAll(getClaimListDetail());
				allList.addAll(getClaimListHideDetail());
				allList.addAll(getClaimListSpecialClinic());
				allList.addAll(getClaimListTotal());

				// データ登録のためのWHERE句を作成する。
				// WHERE句
				
// 2015/1/14 [Yoichiro Kamei] mod - begin 住所地特例対応
//				String whereStr = "(PATIENT_ID = " + getPatientId() + ") " + "AND (INSURED_ID = '" + getInsuredId() + "') " + "AND (TARGET_DATE = '" + VRDateParser.format(getTargetDate(), "yyyy-MM-dd") + "') " + "AND (CLAIM_DATE = '" + VRDateParser.format(getClaimDate(), "yyyy-MM-dd") + "') " + "AND (PROVIDER_ID = '" + getProviderId() + "') " + "AND (CLAIM_STYLE_TYPE = " + getClaimStyleType() + ") " + "AND (CATEGORY_NO IN (2, 3, 5, 7))";
				String whereStr = "(PATIENT_ID = " + getPatientId() + ") " + "AND (INSURED_ID = '" + getInsuredId() + "') " + "AND (TARGET_DATE = '" + VRDateParser.format(getTargetDate(), "yyyy-MM-dd") + "') " + "AND (CLAIM_DATE = '" + VRDateParser.format(getClaimDate(), "yyyy-MM-dd") + "') " + "AND (PROVIDER_ID = '" + getProviderId() + "') " + "AND (CLAIM_STYLE_TYPE = " + getClaimStyleType() + ") " + "AND (CATEGORY_NO IN (2, 3, 5, 7, 18))";
// 2015/1/14 [Yoichiro Kamei] mod - end
				
				// まとめたレコード集合でDBを更新する。
				QkanCommon.updateClaimDetailCustom(getDBManager(), allList, getTargetDate(), whereStr);

				// 更新に成功した場合
				// コミットする。
				getDBManager().commitTransaction();

				// 最新のデータを取得し、VRList listに格納する。
				VRList dataList = QkanCommon.getClaimDetailCustom(getDBManager(), getClaimDate(), whereStr);
				
				// add start 2006.06.06 shin.fujihara [QKAN500:0000152]最新データを画面に反映するよう修整//
				//保持しているデータを一旦消去
				getClaimListBasic().clear();
				getClaimListDetail().clear();
				getClaimListHideDetail().clear();
				getClaimListSpecialClinic().clear();
				getClaimListTotal().clear();
				
				//DBから取得した最新情報を再設定する
				doFindCategory(dataList);
				// add end 2006.06.06 shin.fujihara
				
				// パッシブチェック用にlistを退避する。
				getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), dataList);

				// スナップショットを撮影する。
				getSnapshot().snapshot();
				
				//[ID:0000545][Shin Fujihara] 2009/08 add begin 2009年度障害対応
				//リストオブジェクトのスナップショット取得
				doSnapList();
				//[ID:0000545][Shin Fujihara] 2009/08 add end 2009年度障害対応

				return true;

			} else {
				// パッシブエラーが発生した場合
				// エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
				// ・メッセージID：ERROR_OF_PASSIVE_CHECK_ON_UPDATE
				// （終了）
				// パッシブチェックをミスった場合、Saveを行わない
				getDBManager().beginTransaction();
				return false;
			}
		} catch (Exception ex) {
			// SQL文実行処理でエラーが発生した場合
			// 処理をロールバックする。
			getDBManager().rollbackTransaction();
			// 例外エラーを投げる。
			// 処理を抜ける。（異常終了）
			throw ex;
		}
	}

	/**
	 * 「画面表示用にデータ変換」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public VRMap doChangeTekiyoForDisplay(VRMap claimDataMap) throws Exception {
		// 画面表示用にデータ変換
		// 画面表示用にレコードの値を変換する。
		if (("イ").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// レコードのKEY：501023の値が"イ"の場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：501023 VALUE：1
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(1));
		} else if (("ロ").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// レコードのKEY：501023の値が"ロ"の場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：501023 VALUE：2
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(2));
		} else if (("ハ").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// レコードのKEY：501023の値が"ハ"の場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：501023 VALUE：3
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(3));
		} else if (("ニ").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// レコードのKEY：501023の値が"ニ"の場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：501023 VALUE：4
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(4));
		} else if (("ホ").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// レコードのKEY：501023の値が"ホ"の場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：501023 VALUE：5
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(5));
		} else if (("ヘ").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// レコードのKEY：501023の値が"ヘ"の場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：501023 VALUE：6
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(6));
		//[ID:0000737][Shin Fujihara] 2012/05 add begin 短期入所療養介護で重度療養管理(35)の場合は、摘要欄を変更
		} else if (("ト").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
		    claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(7));
        } else if (("チ").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
            claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(8));
        } else if (("リ").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
            claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(9));
		//[ID:0000737][Shin Fujihara] 2012/05 add end
		} else if (("").equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// レコードのKEY：501023の値が""（空文字）の場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：501023 VALUE：0
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, new Integer(0));
		}
		return claimDataMap;
	}

	/**
	 * 「DB更新用にデータ変換」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public VRMap doChangeTekiyoForUpdate(VRMap claimDataMap) throws Exception {
		// DB更新用にデータ変換
		// DB更新用にレコードの値を変換する。
		if (new Integer(1).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// レコードのKEY：501023の値が"1"の場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：501023 VALUE："イ"
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, "イ");
		} else if (new Integer(2).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// レコードのKEY：501023の値が"2"の場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：501023 VALUE："ロ"
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, "ロ");
		} else if (new Integer(3).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// レコードのKEY：501023の値が"3"の場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：501023 VALUE："ハ"
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, "ハ");
		} else if (new Integer(4).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// レコードのKEY：501023の値が"4"の場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：501023 VALUE："ニ"
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, "ニ");
		} else if (new Integer(5).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// レコードのKEY：501023の値が"5"の場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：501023 VALUE："ホ"
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, "ホ");
		} else if (new Integer(6).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// レコードのKEY：501023の値が"6"の場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：501023 VALUE："ヘ"
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, "ヘ");
			
		//[ID:0000737][Shin Fujihara] 2012/05 add begin 短期入所療養介護で重度療養管理(35)の場合は、摘要欄を変更
		} else if (new Integer(7).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
		    claimDataMap.setData(TEKIYOU100_FLAG_CODE, "ト");
        } else if (new Integer(8).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
            claimDataMap.setData(TEKIYOU100_FLAG_CODE, "チ");
        } else if (new Integer(9).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
            claimDataMap.setData(TEKIYOU100_FLAG_CODE, "リ");
		//[ID:0000737][Shin Fujihara] 2012/05 add end
		} else if (new Integer(0).equals(claimDataMap.getData(TEKIYOU100_FLAG_CODE))) {
			// レコードのKEY：501023の値が"0"の場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：501023 VALUE：""（空文字）
			claimDataMap.setData(TEKIYOU100_FLAG_CODE, "");
		}
		return claimDataMap;
	}

	/**
	 * 「摘要欄記載事項一覧テーブルの各行の設定処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doSetTableRow(VRMap claimDataMap, VRList colomListDetail, int categoryType) throws Exception {

		// NCTableCellViewerCustomCellを生成する。（以下、cellとする）
		ACTableCellViewerCustomCell cell = new ACTableCellViewerCustomCell();

		switch (categoryType) {
			case CATEGORY_NO3:
// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
			case CATEGORY_NO18:
// 2015/1/14 [Yoichiro Kamei] add - end
				// 通常の明細書摘要欄の場合

				// 摘要欄記載事項一覧テーブルの各行の設定処理
				// 以下、渡された引数を下記のとおりに呼ぶ。
				// ・第一引数：レコード
				// ・第ニ引数：columnList

				// レコードのCLASS_TYPEが1（テキスト）の場合
				if (new Integer(TEXT).equals(claimDataMap.getData("CLASS_TYPE"))) {
					// テキストを生成する。
					ACTextField cellTextField = new ACTextField();
					// cellのeditorに生成したテキストを追加する。
					cell.setEditor(cellTextField);
					cellTextField.setMaxLength(20);
					cellTextField.setByteMaxLength(true);
					cellTextField.setBindPath("301018");
					// cellのeditableにtrueを設定する。
					cell.setEditable(true);
				} else if (new Integer(COMBO).equals(claimDataMap.getData("CLASS_TYPE"))) {
					// レコードのCLASS_TYPEが2（コンボ）の場合
					// コンボを生成する。
					ACComboBox cellComboBox = new ACComboBox();
					cellComboBox.setEditable(false);

					// レコードのCODE_IDを用いて、masterCodeより以下の情報を持つArrayList（コンボの選択肢）を取得する。
					// ・CONTENT_KEY
					// ・CONTENT
					int id = ACCastUtilities.toInt(claimDataMap.getData("CODE_ID"));
					VRList masterCodeData = QkanCommon.getArrayFromMasterCode(id, "301018");

					boolean isEndOfKey = false;
					String endOfKey = "";

					// コンボ候補の編集
					String temp = ACCastUtilities.toString(VRBindPathParser.get("301018", claimDataMap));
					if (!("".equals(temp) || temp == null)) {
						// 「/」を持っているかどうか
						int number = temp.indexOf("/");
						if (number < 0) {
							// 「/」を持っていない場合
							try {
								ACCastUtilities.toInt(temp);
							} catch (Exception e) {
								endOfKey = temp;
								isEndOfKey = true;
							}
						} else {
							// 「/」を持っている場合
							String[] ary = temp.split("/", 2);
							endOfKey = ary[1];
							isEndOfKey = true;
						}
					}

					VRList newList = new VRArrayList();
					// コンボ候補に付加
					if (isEndOfKey) {
						for (int i = 0; i < masterCodeData.size(); i++) {
							VRMap codeMap = (VRMap) masterCodeData.get(i);
							codeMap = (VRMap) codeMap.clone();
							String target = ACCastUtilities.toString(VRBindPathParser.get("301018", codeMap));
							VRBindPathParser.set("301018", codeMap, target + "/" + endOfKey);
							newList.add(codeMap);
						}
						masterCodeData = newList;
					} else {
						for (int i = 0; i < masterCodeData.size(); i++) {
							VRMap codeMap = (VRMap) masterCodeData.get(i);
							codeMap = (VRMap) codeMap.clone();
							String newKey = ACCastUtilities.toString(VRBindPathParser.get("301018", codeMap));
							VRBindPathParser.set("301018", codeMap, newKey);
							newList.add(codeMap);
						}
						masterCodeData = newList;
					}

					ACLabel cellLabel = new ACLabel();
					cellLabel.setFormat(new QkanCustomForClaimCodeMasterFormat(id));
					cell.setRenderer(cellLabel);

					// bindPathを"CONTENT"で設定する。
					// renderBindPathを"CONTENT"で設定する。
					cellComboBox.setBindPath("301018");
					cellComboBox.setFormat(new QkanCustomForClaimCodeMasterFormat(id));
					cellComboBox.setRenderBindPath("CONTENT");

					// 取得したArrayListをコンボの選択肢として設定する。
					cellComboBox.setModel(masterCodeData);

					// cellのeditorに生成したコンボを追加する。
					cell.setEditor(cellComboBox);

					// cellのeditableにtrueを設定する。
					cell.setEditable(true);

				}

				// cellをcolumnListに追加する。
				colomListDetail.add(cell);

				break;

			case CATEGORY_NO5:

				// 通常の特定診療費摘要欄の場合

				// 摘要欄記載事項一覧テーブルの各行の設定処理
				// 以下、渡された引数を下記のとおりに呼ぶ。
				// ・第一引数：レコード
				// ・第ニ引数：columnList

				// レコードのCLASS_TYPEが1（テキスト）の場合
				if (new Integer(TEXT).equals(claimDataMap.getData("CLASS_TYPE"))) {
					// テキストを生成する。
					ACTextField cellTextField = new ACTextField();
					// cellのeditorに生成したテキストを追加する。
					cell.setEditor(cellTextField);

					// V4.5.8対応 全角文字のみ許可
                    //[ID:0000551][Tozo TANAKA] 2009/08 replace begin 
//					cellTextField.setConvertToCharacter(ACCharacterConverter.TO_WIDE_CHAR);
//					cellTextField.setIMEMode(InputSubset.KANJI);
                    if(!(cellTextField.getDocument() instanceof ACTextFieldDocument)){
                        //念のため、強制的にACTextFieldDocumentを設定する。
                        cellTextField.setDocument(new ACTextFieldDocument(cellTextField));
                    }
                    ((ACTextFieldDocument) cellTextField.getDocument())
                        .setCharacterConverter(new QP004WideCommaCharacterConverter());
                    cellTextField.setConvertToCharacter(ACCharacterConverter.TO_WIDE_CHAR);
                    cellTextField.setIMEMode(InputSubset.LATIN);
                    //[ID:0000551][Tozo TANAKA] 2009/08 replace end 
					cellTextField.setMaxLength(100);
					cellTextField.setByteMaxLength(true);
					cellTextField.setBindPath("501023");

					// cellのeditableにtrueを設定する。
					cell.setEditable(true);
				} else if (new Integer(COMBO).equals(claimDataMap.getData("CLASS_TYPE"))) {
					// レコードのCLASS_TYPEが2（コンボ）の場合
					// コンボを生成する。
					ACComboBox cellComboBox = new ACComboBox();
					cellComboBox.setEditable(false);

					// レコードのCODE_IDを用いて、masterCodeより以下の情報を持つArrayList（コンボの選択肢）を取得する。
					// ・CONTENT_KEY
					// ・CONTENT
					int id = ACCastUtilities.toInt(claimDataMap.getData("CODE_ID"));
					VRList masterCodeData = QkanCommon.getArrayFromMasterCode(id, "501023");

					// コンボ候補の編集
					String temp = ACCastUtilities.toString(VRBindPathParser.get("501023", claimDataMap));
					if (!("".equals(temp) || temp == null)) {
						// 「/」を持っているかどうか
						boolean isEndOfKey = false;
						int number = temp.indexOf("/");
						String endOfKey = "";
						if (number < 0) {
							// 「/」を持っていない場合
							try {
								ACCastUtilities.toInt(temp);
							} catch (Exception e) {
								endOfKey = temp;
								isEndOfKey = true;
							}
						} else {
							// 「/」を持っている場合
							String[] ary = temp.split("/", 2);
							endOfKey = ary[1];
							isEndOfKey = true;
						}
						VRList newList = new VRArrayList();
						// コンボ候補に付加
						if (isEndOfKey) {
							for (int i = 0; i < masterCodeData.size(); i++) {
								VRMap codeMap = (VRMap) masterCodeData.get(i);
								codeMap = (VRMap) codeMap.clone();
								String target = ACCastUtilities.toString(VRBindPathParser.get("501023", codeMap));
								VRBindPathParser.set("501023", codeMap, target + "/" + endOfKey);
								newList.add(codeMap);
							}
							masterCodeData = newList;
						}
					}
					ACLabel cellLabel = new ACLabel();
					cellLabel.setFormat(new QkanCustomForClaimCodeMasterFormat(id));
					cell.setRenderer(cellLabel);

					// bindPathを"CONTENT"で設定する。
					// renderBindPathを"CONTENT"で設定する。
					cellComboBox.setBindPath("501023");
					cellComboBox.setFormat(new QkanCustomForClaimCodeMasterFormat(id));
					cellComboBox.setRenderBindPath("CONTENT");

					// 取得したArrayListをコンボの選択肢として設定する。
					cellComboBox.setModel(masterCodeData);

					// cellのeditorに生成したコンボを追加する。
					cell.setEditor(cellComboBox);

					// cellのeditableにtrueを設定する。
					cell.setEditable(true);

				}

				// cellをcolumnListに追加する。
				colomListDetail.add(cell);

				break;

			default:
				// 何もしない
				break;
		}
	}

	/**
	 * 「初期化」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void initialize() throws Exception {
		// 画面初期化。
		// 業務情報マスタよりデータを取得し、ウィンドウタイトル、業務ボタンバーに設定する。
		setAffairTitle("QP004", getButtons());
		// コードマスタデータを取得し、masterCodeDataに格納する。
		setMasterCodeData(QkanSystemInformation.getInstance().getMasterCode());

		// テーブルモデルの設定。
		// tableModelDetailを、下記のフィールドで生成する。
		// "301007+301008（サービスコード）" "SERVICE_NAME" "301010（日数・回数）"
		// "301014（サービス単位数）" "301018（摘要）"

		String[] tableDetailColums = new String[5];
		tableDetailColums[0] = "301007+''+301008"; // サービスコード
		tableDetailColums[1] = "SERVICE_NAME"; // サービス名称
		tableDetailColums[2] = "301010"; // 日数・回数
		tableDetailColums[3] = "301014"; // サービス単位数
		tableDetailColums[4] = "301018"; // 摘要

		// 初期化した後に格納
		setTableModelDetail(new ACTableModelAdapter());
		getTableModelDetail().setColumns(tableDetailColums);

		// tableModelSpecialClinicを、下記のフィールドで生成する。
		// "501009（識別番号）" "SPECIAL_CLINIC_NAME" "501011（回数）" "501012（単位数）"
		// "501023（摘要）"
		String[] tableSpecialClinicColums = new String[5];
		tableSpecialClinicColums[0] = "501009"; // 識別番号
		tableSpecialClinicColums[1] = "SPECIAL_CLINIC_NAME";// 特定医療機関名称
		tableSpecialClinicColums[2] = "501011"; // 回数
		tableSpecialClinicColums[3] = "501012"; // 単位数
		tableSpecialClinicColums[4] = "501023"; // 摘要

		// 初期化した後に格納
		setTableModelSpecialClinic(new ACTableModelAdapter());
		getTableModelSpecialClinic().setColumns(tableSpecialClinicColums);

		// テーブルモデルを各画面テーブルに設定する。
		// ・tableModelDetail 摘要記載事項一覧テーブル（tekiyoTable）
		getTekiyoTable().setModel(getTableModelDetail());
		// ・tableModelSpecialClinic 特定診療費一覧テーブル（sinryoTable）
		getSinryoTable().setModel(getTableModelSpecialClinic());

		// 摘要欄説明（定数文字列：FIRST_SUMMARY_MEMO）を下記のテキストフィールドに表示する。
		// ・摘要欄記載事項（tekiyoText）
		// ・特定診療費（shinryoText）
		getTekiyoText().setText(FIRST_SUMMARY_MEMO);
		getShinryoText().setText(FIRST_SUMMARY_MEMO);

		// 画面のVisible制御を行う。
		doControlState();

		VRList patientList = QkanCommon.getPatientInfo(getDBManager(), getPatientId());
		if (!patientList.isEmpty()) {
			VRMap patientMap = (VRMap) patientList.getData();
			patientMap.setData("PATIENT_NAME", QkanCommon.toFullName(patientMap.getData("PATIENT_FAMILY_NAME"), patientMap.getData("PATIENT_FIRST_NAME")));
			getPatientNames().setSource(patientMap);
			getPatientNames().bindSource();
		}
	}

	/**
	 * 「妥当な日付の入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkValidDate(QkanDateTextField dateParam, String errMsg) throws Exception {
		if (!ACTextUtilities.isNullText(dateParam.getText())) {
			if (!dateParam.isValidDate()) {
				// 不正な値の場合
				// インスタンスにフォーカスをあてる。
				dateParam.requestFocus();
				// エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(errMsg);
				// ・メッセージID：ERROR_OF_WRONG_DATE
				// （終了）
				return false;
			}
		}
		return true;
	}

	/**
	 * 「未来日付の入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkFutureDate(QkanDateTextField dateParam, String errMsg) throws Exception {

		if (!ACTextUtilities.isNullText(dateParam.getText())) {
			Date systemDate = QkanSystemInformation.getInstance().getSystemDate();
			if (ACDateUtilities.compareOnDay(systemDate, ACCastUtilities.toDate(dateParam.getText())) < 0) {
				// 不正な値の場合
				// インスタンスにフォーカスをあてる。
				dateParam.requestFocus();
				// エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_FUTURE_DATE(errMsg);
				// ・メッセージID：ERROR_OF_FUTURE_DATE
				// （終了）
				return false;
			}
		}
		return true;
	}

	/**
	 * 「日付の開始日と終了日のチェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkRelationDate(QkanDateTextField firstDateParam, QkanDateTextField secondDateParam, String errMsg1, String errMsg2, String errMsg3) throws Exception {
		if (!ACTextUtilities.isNullText(firstDateParam.getText())) {
			if (!ACTextUtilities.isNullText(secondDateParam.getText())) {
				if (ACDateUtilities.compareOnDay(ACCastUtilities.toDate(firstDateParam.getText()), ACCastUtilities.toDate(secondDateParam.getText())) > 0) {
					// 不正な値の場合
					// インスタンスにフォーカスをあてる。
					firstDateParam.requestFocus();
					// エラーメッセージを表示する。
					QkanMessageList.getInstance().ERROR_OF_GREATER_DATE_RELATION(errMsg1, errMsg2, errMsg3);

					// ・メッセージID：ERROR_OF_GREATER_DATE_RELATION
					// （終了）
					return false;
				}
			}
		}
		return true;
	}
	
	//[ID:0000545][Shin Fujihara] 2009/08 edit begin 2009年度障害対応
	/**
	 * リストオブジェクトのスナップショット取得
	 * @throws Exception
	 */
	private void doSnapList() throws Exception {
		VRList list = getOrderList();
		VRList snap = new VRArrayList();
		
		for (int i = 0; i < list.size(); i++) {
			VRMap rec = (VRMap)list.get(i);
			VRMap map = new VRHashMap();
			Iterator it = rec.keySet().iterator();
			
			while(it.hasNext()) {
				Object key = it.next();
				map.put(key, rec.get(key));
			}
			snap.add(map);
		}
		setSnapList(snap);
	}
	
	/**
	 * リストオブジェクトの変更チェック
	 * @return
	 * @throws Exception
	 */
	private boolean isListModified() throws Exception {
		VRList list = getOrderList();
		VRList snap = getSnapList();
		
		for (int i = 0; i < list.size(); i++) {
			if (snap.size() <= i) {
				return true;
			}
			VRMap rec1 = (VRMap)list.get(i);
			VRMap rec2 = (VRMap)snap.get(i);
			
			Iterator it = rec1.keySet().iterator();
			
			while(it.hasNext()) {
				Object key = it.next();
				
				if (!rec2.containsKey(key)) {
					return true;
				}
				
				String v1 = ACCastUtilities.toString(rec1.get(key), "");
				String v2 = ACCastUtilities.toString(rec2.get(key), "");
				
				if (!v1.equals(v2)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * 所定の順番で並び替えたリストを取得
	 * @return
	 * @throws Exception
	 */
	private VRList getOrderList() throws Exception {
		// 画面上のデータを取得する。
		// パネルから基本情報レコードを取得する
		VRMap saveMap = (VRMap) getClaimListBasic().getData(0);
		getContents().setSource(saveMap);
		getContents().applySource();

		// 基本情報レコード集合の下記のデータの型をDate型からString型（yyyyMMdd）に変換する。
		// ・KEY：201021（開始年月日）
		// ・KEY：201022（中止年月日）
		// ・KEY：201024（入所（院）年月日）
		// ・KEY：201025（退所（院）年月日）

		if (!ACTextUtilities.isNullText(saveMap.getData("201021"))) {
			saveMap.setData("201021", ACCastUtilities.toString(VRDateParser.format(ACCastUtilities.toDate(saveMap.getData("201021")), "yyyyMMdd")));
		}
		if (!ACTextUtilities.isNullText(saveMap.getData("201022"))) {
			saveMap.setData("201022", ACCastUtilities.toString(VRDateParser.format(ACCastUtilities.toDate(saveMap.getData("201022")), "yyyyMMdd")));
		}
		if (!ACTextUtilities.isNullText(saveMap.get("201024"))) {
			saveMap.setData("201024", ACCastUtilities.toString(VRDateParser.format(ACCastUtilities.toDate(saveMap.getData("201024")), "yyyyMMdd")));
		}
		if (!ACTextUtilities.isNullText(saveMap.getData("201025"))) {
			saveMap.setData("201025", ACCastUtilities.toString(VRDateParser.format(ACCastUtilities.toDate(saveMap.getData("201025")), "yyyyMMdd")));
		}

		// 短期入所系の場合
		if (getClaimStyleType() == CLAIM_STYLE_TYPE31
		        || getClaimStyleType() == CLAIM_STYLE_TYPE32
		        || getClaimStyleType() == CLAIM_STYLE_TYPE41
		        || getClaimStyleType() == CLAIM_STYLE_TYPE42
		        || getClaimStyleType() == CLAIM_STYLE_TYPE51
		        || getClaimStyleType() == CLAIM_STYLE_TYPE52
		        || getClaimStyleType() == CLAIM_STYLE_TYPE65
		        || getClaimStyleType() == CLAIM_STYLE_TYPE66
		        || getClaimStyleType() == CLAIM_STYLE_TYPE67) {

			Object obj = VRBindPathParser.get("701008", saveMap);
			VRMap temp = (VRMap) getClaimListTotal().getData(0);
			if (temp != null) {
				VRBindPathParser.set("701008", temp, obj);
			}
			saveMap.remove("701008");
		}
        
        /*
         * スナップショットに使用するデータは全てディープコピーしたリストにする。
         */
        VRList copyClaimListBasic =  QkanValidServiceCommon.deepCopyVRList(getClaimListBasic());
        VRList copyClaimListHideDetail =  QkanValidServiceCommon.deepCopyVRList(getClaimListHideDetail());
        VRList copyClaimListDetail =  QkanValidServiceCommon.deepCopyVRList(getClaimListDetail());
        VRList copyClaimListSpecialClinic = QkanValidServiceCommon.deepCopyVRList(getClaimListSpecialClinic());
        VRList copyClaimListTotal = QkanValidServiceCommon.deepCopyVRList(getClaimListTotal());
        
        //[ID:0000737][Shin Fujihara] 2012/05 add begin 重度療養管理加算のコード変換
        //明細情報レコードがnulではない場合
        if (!(copyClaimListDetail == null || copyClaimListDetail.isEmpty())) {
        	Iterator detailsIterator = copyClaimListDetail.listIterator();
        	
        	while (detailsIterator.hasNext()) {
        		VRMap row = (VRMap) detailsIterator.next();
        		doChangeTekiyoForUpdateCategory3(row);
        	}
        }
        //[ID:0000737][Shin Fujihara] 2012/05 add end
        
		// 特定診療費情報レコードがnullでない場合
		if (!(copyClaimListSpecialClinic == null || copyClaimListSpecialClinic.isEmpty())) {
			Iterator specialClinicIterator = copyClaimListSpecialClinic.listIterator();

			while (specialClinicIterator.hasNext()) {
				VRMap specialClinicRecord = (VRMap) specialClinicIterator.next();
				// 特定診療費情報レコード集合を順に見ていく。（ループ開始）
				// KEY：501009（識別番号）の値が35（重度療養管理）の場合
				if (new Integer(HEAVY_RECUPERATION_MANAGEMENT).equals(ACCastUtilities.toInteger(specialClinicRecord.getData("501009")))) {
					// DB更新用にデータを変換する。
					doChangeTekiyoForUpdate(specialClinicRecord);
					// ・引数：HashMap（特定診療費レコード）
				}
				if (copyClaimListSpecialClinic.size() > 1) {
					if (FLAG_START.equals(ACCastUtilities.toInteger(specialClinicRecord.getData("501007")))) {
						// KEY：501007（レコード順次番号）の値が1の場合
						// レコードに特定診療費傷病名テキストの値を以下のKEYで設定する。
						// ・KEY：501008（傷病名）
						specialClinicRecord.setData("501008", getShinryoDeseaseText().getText());
					}
				} else if (copyClaimListSpecialClinic.size() == 1) {
					if (FLAG_END.equals(ACCastUtilities.toInteger(specialClinicRecord.getData("501007")))) {
						specialClinicRecord.setData("501008", getShinryoDeseaseText().getText());
					}
				}
			}
		}
		
		VRList list = new VRArrayList();
		
		list.addAll(copyClaimListBasic);
		list.addAll(copyClaimListHideDetail);
		list.addAll(copyClaimListDetail);
		list.addAll(copyClaimListSpecialClinic);
		list.addAll(copyClaimListTotal);
		
		return list;
	}
	//[ID:0000545][Shin Fujihara] 2009/08 edit end 2009年度障害対応
	
	
	//[ID:0000737][Shin Fujihara] 2012/05 add begin 重度療養管理加算のコード変換
	/**
	 * 「画面表示用にデータ変換」に関する処理を行ないます。
	 * ※明細情報レコードの重度療養管理加算用
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public VRMap doChangeTekiyoForDisplayCategory3(VRMap claimDataMap) throws Exception {
		// 画面表示用にデータ変換
		
		//重度療養管理加算の時のみ変換を行う
		// [H27.4改正対応][Shinobu Hitaka] 2015/3/23 edit - begin 287(医療連携強化加算),288(療養施設の患者状態)も追加
		//if (ACCastUtilities.toInt(claimDataMap.get("CODE_ID"), 0) != 286) {
		//	return claimDataMap;
		//}
		if (ACCastUtilities.toInt(claimDataMap.get("CODE_ID"), 0) != 286
				&& ACCastUtilities.toInt(claimDataMap.get("CODE_ID"), 0) != 287
				&& ACCastUtilities.toInt(claimDataMap.get("CODE_ID"), 0) != 288
				) {
			return claimDataMap;
		}
		
		String _301018 = ACCastUtilities.toString(claimDataMap.get("301018"), "");
		
		if (ACTextUtilities.isNullText(_301018)) {
			return claimDataMap;
		}
		
		if (ACCastUtilities.toInt(claimDataMap.get("CODE_ID"), 0) == 286
				|| ACCastUtilities.toInt(claimDataMap.get("CODE_ID"), 0) == 287) {
			
			// [H27.4改正対応][Shinobu Hitaka] 2015/5/7 edit - begin 重度療養管理加算は割引率がないので摘要1文字でなければ抜ける
			//if (_301018.length() != 1) {
			//	return claimDataMap;
			//}
			if (_301018.length() != 1 && ACCastUtilities.toInt(claimDataMap.get("CODE_ID"), 0) == 286) {
				return claimDataMap;
			}
			// [H27.4改正対応][Shinobu Hitaka] 2015/5/7 edit - end
			
			//画面表示用に値を変換
			switch(_301018.charAt(0)) {
			case 'ｲ':
				claimDataMap.setData("301018", "1");
				break;
			case 'ﾛ':
				claimDataMap.setData("301018", "2");
				break;
			case 'ﾊ':
				claimDataMap.setData("301018", "3");
				break;
			case 'ﾆ':
				claimDataMap.setData("301018", "4");
				break;
			case 'ﾎ':
				claimDataMap.setData("301018", "5");
				break;
			case 'ﾍ':
				claimDataMap.setData("301018", "6");
				break;
			case 'ﾄ':
				claimDataMap.setData("301018", "7");
				break;
			case 'ﾁ':
				claimDataMap.setData("301018", "8");
				break;
			case 'ﾘ':
				claimDataMap.setData("301018", "9");
				break;
			default:
				claimDataMap.setData("301018", "");
				break;
			}
		} else {
			//CODE_ID=288(療養施設の患者状態)の場合
			if (_301018.length() > 2) {
				return claimDataMap;
			}
			
			//画面表示用に値を変換
			switch(_301018.charAt(0)) {
			case 'ｲ':
				claimDataMap.setData("301018", "1");
				break;
			case 'ﾛ':
				claimDataMap.setData("301018", "2");
				break;
			case 'ﾊ':
				switch (_301018.charAt(1) ) {
				case 'A':
					claimDataMap.setData("301018", "3");
					break;
				case 'B':
					claimDataMap.setData("301018", "4");
					break;
				case 'C':
					claimDataMap.setData("301018", "5");
					break;
				case 'D':
					claimDataMap.setData("301018", "6");
					break;
				}
				break;
			case 'ﾆ':
				claimDataMap.setData("301018", "7");
				break;
			case 'ﾎ':
				claimDataMap.setData("301018", "8");
				break;
			case 'ﾍ':
				claimDataMap.setData("301018", "9");
				break;
			case 'ﾄ':
				claimDataMap.setData("301018", "10");
				break;
			case 'ﾁ':
				claimDataMap.setData("301018", "11");
				break;
			case 'ﾘ':
				switch (_301018.charAt(1) ) {
				case 'A':
					claimDataMap.setData("301018", "12");
					break;
				case 'B':
					claimDataMap.setData("301018", "13");
					break;
				case 'C':
					claimDataMap.setData("301018", "14");
					break;
				case 'D':
					claimDataMap.setData("301018", "15");
					break;
				case 'E':
					claimDataMap.setData("301018", "16");
					break;
				case 'F':
					claimDataMap.setData("301018", "17");
					break;
				case 'G':
					claimDataMap.setData("301018", "18");
					break;
				case 'H':
					claimDataMap.setData("301018", "19");
					break;
				}
				break;
			case 'ﾇ':
				claimDataMap.setData("301018", "20");
				break;
			default:
				claimDataMap.setData("301018", "");
				break;
			}
		}
		
		return claimDataMap;
		// [H27.4改正対応][Shinobu Hitaka] 2015/3/23 edit - end
	}

	/**
	 * 「DB更新用にデータ変換」に関する処理を行ないます。
	 * ※明細情報レコードの重度療養管理加算用
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public VRMap doChangeTekiyoForUpdateCategory3(VRMap claimDataMap) throws Exception {
		// DB更新用にデータ変換
		
		//重度療養管理加算の時のみ変換を行う
		// [H27.4改正対応][Shinobu Hitaka] 2015/3/23 edit - begin 287(医療連携強化加算),288(療養施設の患者状態)も追加
		//if (ACCastUtilities.toInt(claimDataMap.get("CODE_ID"), 0) != 286) {
		//	return claimDataMap;
		//}
		if (ACCastUtilities.toInt(claimDataMap.get("CODE_ID"), 0) != 286 
				&& ACCastUtilities.toInt(claimDataMap.get("CODE_ID"), 0) != 287
				&& ACCastUtilities.toInt(claimDataMap.get("CODE_ID"), 0) != 288
				) {
			return claimDataMap;
		}
		
		int selectedCode = ACCastUtilities.toInt(claimDataMap.get("301018"), 0); 
		String value = "";
		
		if (ACCastUtilities.toInt(claimDataMap.get("CODE_ID"), 0) == 286
				|| ACCastUtilities.toInt(claimDataMap.get("CODE_ID"), 0) == 287) {
			switch(selectedCode) {
			case 1:
				value = "ｲ";
				break;
			case 2:
				value = "ﾛ";
				break;
			case 3:
				value = "ﾊ";
				break;
			case 4:
				value = "ﾆ";
				break;
			case 5:
				value = "ﾎ";
				break;
			case 6:
				value = "ﾍ";
				break;
			case 7:
				value = "ﾄ";
				break;
			case 8:
				value = "ﾁ";
				break;
			case 9:
				value = "ﾘ";
				break;
			}
		} else {
			switch(selectedCode) {
			case 1:
				value = "ｲ";
				break;
			case 2:
				value = "ﾛ";
				break;
			case 3:
				value = "ﾊA";
				break;
			case 4:
				value = "ﾊB";
				break;
			case 5:
				value = "ﾊC";
				break;
			case 6:
				value = "ﾊD";
				break;
			case 7:
				value = "ﾆ";
				break;
			case 8:
				value = "ﾎ";
				break;
			case 9:
				value = "ﾍ";
				break;
			case 10:
				value = "ﾄ";
				break;
			case 11:
				value = "ﾁ";
				break;
			case 12:
				value = "ﾘA";
				break;
			case 13:
				value = "ﾘB";
				break;
			case 14:
				value = "ﾘC";
				break;
			case 15:
				value = "ﾘD";
				break;
			case 16:
				value = "ﾘE";
				break;
			case 17:
				value = "ﾘF";
				break;
			case 18:
				value = "ﾘG";
				break;
			case 19:
				value = "ﾘH";
				break;
			case 20:
				value = "ﾇ";
				break;
			}
		}
		
		claimDataMap.setData("301018", value);
		
		return claimDataMap;
		// [H27.4改正対応][Shinobu Hitaka] 2015/3/23 edit - end
	}
	//[ID:0000737][Shin Fujihara] 2012/05 add end
}
