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
 * 作成日: 2006/02/15  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: 2014/10/23  MIS九州株式会社 日高 しのぶ
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定・実績 (001)
 * プログラム 利用・提供票印刷 (QS001003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServicePrintParameter;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceSchedulePrintManager;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.text.QkanJotaiCodeUnapplicableFormat;

/**
 * 利用・提供票印刷(QS001031)
 */
@SuppressWarnings("serial")
public class QS001003 extends QS001003Event {
	/**
	 * コンストラクタです。
	 */
	public QS001003() {
	}

	// コンポーネントイベント

	/**
	 * 「居宅サービス作成者変更」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void planManufacturerActionPerformed(ActionEvent e)
			throws Exception {
		// ■居宅サービス作成者変更時、居宅介護支援事業者事業所欄の有効/無効を切り替える
		// 居宅介護支援事業者事業所欄の有効/無効を設定する。
		setProviderComponentState();
	}

	/**
	 * 「事業所名変更」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void supportProviderNameActionPerformed(ActionEvent e)
			throws Exception {
		// ■居宅介護支援事業者事業所名変更時、事業所番号、及び担当者を切り替える
		// ※事業所番号の変更
		Object obj = getSupportProviderName().getSelectedItem();
		if (obj instanceof VRMap) {
			// 事業者番号ラベル(supportProviderCd)の値として、選択された事業所の事業所番号を設定する。(事業所名未選択等の理由により
			getSupportProviderCd().setText(
					ACCastUtilities.toString(
							VRBindPathParser.get("PROVIDER_ID", (VRMap) obj),
							""));
			// ※担当者コンボのアイテム変更
			// 担当者コンボ(personInCharge)のアイテムとして、選択された事業所に登録されている担当者を設定する。(事業所名未選択等の理由
			// により事業所番号を取得できなかった場合、担当者コンボのアイテムはなしとする)
			VRList staffs = getDBManager().executeQuery(
					getSQL_GET_STAFF((VRMap) obj));
			Iterator it = staffs.iterator();
			while (it.hasNext()) {
				Map staff = (Map) it.next();
				staff.put("STAFF_NAME", QkanCommon.toFullName(
						staff.get("STAFF_FAMILY_NAME"),
						staff.get("STAFF_FIRST_NAME")));
			}
			setSupporters(staffs);
			getPersonInCharge().setModel(getSupporters());
			// ※担当者コンボの初期選択
			// 選択された事業所で、最優先の担当者を選択する（事業所一覧画面で表示される担当者と同じ）。(設定できない場合は未選択とする)
			if (getPersonInCharge().getItemCount() > 0) {
				getPersonInCharge().setSelectedIndex(0);
			}
		} else {
			// 事業所番号を取得できなかった場合、事業所番号は未選択とする)
			getSupportProviderCd().setText("");
			setSupporters(new VRArrayList(
					java.util.Arrays.asList(new Object[] {})));
			getPersonInCharge().setModel(getSupporters());
		}
	}

	/**
	 * 「利用票/提供票の印刷」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void printActionPerformed(ActionEvent e) throws Exception {
		// ■利用票(別表)/提供票(別表)の印刷を行う。
		// 渡りパラメータ printParam (レコード)を生成し、下記の値を設定する。
		VRMap printParam = new VRHashMap();
		// KEY : PATIENT_ID, VALUE : (利用者ID)
		// KEY : TARGET_DATE, VALUE : (対象年月)
		// KEY : SERVICE_DATA, VALUE : (月間表情報のレコード集合)
		// KEY : PROCESS_TYPE, VALUE : (内部変数processTypeの値)
		// KEY : SHORT_STAR_USE_DAY, VALUE : (前月までの短期入所利用回数)
		// KEY : CREATE_DATE_OUTER, VALUE : (枠外の作成年月日)
		// KEY : CREATE_DATE_INNER, VALUE : (枠内の作成年月日)
		// ※印刷帳票の判別
		// 印刷フラグの初期化のため、printParamに下記の値を設定する。
		// KEY : PRINT_MODE_USE, VALUE : 0
		// KEY : PRINT_MODE_USE_ANOTHER, VALUE : 0
		// KEY : PRINT_MODE_OFFER VALUE : 0
		// KEY : PRINT_MODE_OFFER_ANOTHER VALUE : 0
		// 「印刷する帳票の選択」の値をチェックする。
		// 「利用票・別表」の場合
		// printParamに下記の値を設定する。
		// KEY : PRINT_MODE_USE, VALUE : 1
		// KEY : PRINT_MODE_USE_ANOTHER, VALUE : 1
		// 「提供票・別表」の場合
		// printParamに下記の値を設定する。
		// KEY : PRINT_MODE_OFFER VALUE : 1
		// KEY : PRINT_MODE_OFFER_ANOTHER VALUE : 1
		// 「利用票」の場合
		// printParamに下記の値を設定する。
		// KEY : PRINT_MODE_USE, VALUE : 1
		// 「提供票」の場合
		// printParamに下記の値を設定する。
		// KEY : PRINT_MODE_OFFER VALUE : 1
		// 「別表」の場合
		// 「帳票種別選択」の値をチェックする。
		// 「利用票」の場合
		// printParamに下記の値を設定する。
		// KEY : PRINT_MODE_USE_ANOTHER, VALUE : 1
		// 「提供票」の場合
		// printParamに下記の値を設定する。
		// KEY : PRINT_MODE_OFFER_ANOTHER VALUE : 1
		// ※集計・印刷クラスへの値渡し
		// 月間表情報を集計し、印刷を実行するためのクラスへ値を渡し、印刷を開始する。

		// 追加情報を収集
		getContents().setSource(printParam);
		getContents().applySource();
		if (getSupportProvider().isSelected()
				|| getPreventSupportProvider().isSelected()) {
			// 介護支援専門員がケアプランを作成した場合
			printParam.remove(getDateOfWrittenReport().getBindPath());
		} else {
			// 被保険者自身でケアプランを作成した場合
			printParam.remove(getSupportProviderName().getBindPath());
			printParam.remove(getPersonInCharge().getBindPath());
		}

		// 印刷オプションをチェック
		String mainFormat, subFormat;
		boolean printMain, printSub, printBackup, divedProvider;

		switch (getSlitType().getSelectedIndex()) {
		case 1:// 利用票
			mainFormat = "QS001P02";
			subFormat = "QS001P03";
			printBackup = true;
			divedProvider = false;
			break;
		default: // 提供票
			mainFormat = "QS001P04";
			subFormat = "QS001P05";
			printBackup = false;
			divedProvider = true;
			break;
		}

		if (getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
			// 予定の場合
			// 本票
			printMain = true;
			printSub = false;
		} else {
			switch (getSlitKind().getSelectedIndex()) {
			case 1: // 本票と別表
				printMain = true;
				printSub = true;
				break;
			case 2: // 本票
				printMain = true;
				printSub = false;
				break;
			default: // 別表
				printMain = false;
				printSub = true;
				break;
			}
		}

		CareServiceSchedulePrintManager mng = new CareServiceSchedulePrintManager();
		mng.initialize(getCalcurater());
		mng.parse(getServiceData());
		mng.setBuildDivedProvider(divedProvider);
		
		// [2014年要望][Shinobu Hitaka] 2014/10/23 add begin 敬称表示
		switch (getSlitKeisyo().getSelectedIndex()) {
		case 1:
		    mng.setPrintKeisyo("　様");
		    break;
		case 2:
		    mng.setPrintKeisyo("　殿");
		    break;
		default:
		    mng.setPrintKeisyo("");
		    break;
		}
		setProperty("PrintConfig/KeishoRadio", String.valueOf(getSlitKeisyo().getSelectedIndex()));
		saveProperty();
		// [2014年要望][Shinobu Hitaka] 2014/10/23 add end   敬称表示

		CareServicePrintParameter buildParam = new CareServicePrintParameter();
		buildParam.setPrintParameter(printParam);

		boolean exists = false;
		List mainInsuredPages = null, subInsuredPages = null;
		ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
		writer.beginPrintEdit();
		if (printMain) {
			// 本票情報を構築

			if (getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
				// 実績モードならば当月の予定も本票に並べる
				VRList list = QkanCommon.getServiceDetail(getDBManager(),
						getPatientID(), getTargetDateSource(),
						QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY);
				mng.addParse(list, false);
			}

			mainInsuredPages = new ArrayList();
			exists |= mng.buildUserMainTable(buildParam, mainInsuredPages);

			ACChotarouXMLUtilities.addFormat(writer, mainFormat, mainFormat
					+ ".xml");

		}

		if (printSub) {
			// 別表印刷
			subInsuredPages = new ArrayList();
			ACChotarouXMLUtilities.addFormat(writer, subFormat, subFormat
					+ ".xml");
			exists |= mng.buildUserSubTable(buildParam, subInsuredPages);

		}

		if (!exists) {
			// 空帳票
			if (buildParam.getPages() == null) {
				QkanMessageList.getInstance().QS001_ERROR_OF_EMPTY_PRINT();
				dispose();
				return;
			}
			if (QkanMessageList.getInstance().QS001_WARNING_OF_BLANK_PAGE() != ACMessageBox.RESULT_OK) {
				dispose();
				return;
			}
		}

		print(writer, buildParam, printMain, mainFormat, mainInsuredPages,
				new HashMap(), printSub, subFormat, subInsuredPages);

		if (printBackup && printMain) {
			// 控も印字

			// 本票印刷
			HashMap allTexts = new HashMap();
			allTexts.put("chohyoType.h1.w1", "居宅介護支援事業者(控)");

			print(writer, buildParam, printMain, mainFormat, mainInsuredPages,
					allTexts, printSub, subFormat, subInsuredPages);

		}

		writer.endPrintEdit();

		ACChotarouXMLUtilities.openPDF(writer);

		// 印刷後も閉じない場合はコメントアウト
		// dispose();
	}

	/**
	 * 「印刷」に関する処理を行ないます。
	 * 
	 * @param writer
	 *            ACChotarouXMLWriter
	 * @param buildParam
	 *            QS001ServicePrintParameter
	 * @param printMain
	 *            , String mainFormat, List mainInsuredPages boolean
	 * @param allTexts
	 *            HashMap
	 * @param printSub
	 *            , String subFormat, List subInsuredPages boolean
	 * @throws Exception
	 *             処理例外
	 * 
	 */
	public void print(ACChotarouXMLWriter writer,
			CareServicePrintParameter buildParam, boolean printMain,
			String mainFormat, List mainInsuredPages, HashMap allTexts,
			boolean printSub, String subFormat, List subInsuredPages)
			throws Exception {
		if (printMain) {
			if (printSub) {
				// 本表と別表
				int end = Math.min(mainInsuredPages.size(),
						subInsuredPages.size());
				for (int i = 0; i < end; i++) {
					List mainPages = (List) mainInsuredPages.get(i);
					List subPages = (List) subInsuredPages.get(i);
					Iterator subIt = subPages.iterator();
					while (subIt.hasNext()) {
						// メイン事業所単位
						// 本票印刷
						printMainTable(writer, mainFormat, mainPages,
								buildParam.getInvisibles(), allTexts);

						// 別表印刷
						List prov = (List) subIt.next();
						printSubTable(writer, subFormat, prov);
					}
				}
			} else {
				// 本表のみ
				int end = mainInsuredPages.size();
				for (int i = 0; i < end; i++) {
					List mainPages = (List) mainInsuredPages.get(i);

					printMainTable(writer, mainFormat, mainPages,
							buildParam.getInvisibles(), allTexts);
				}
			}
		} else if (printSub) {
			// 別表のみ
			int end = subInsuredPages.size();
			for (int i = 0; i < end; i++) {
				List subPages = (List) subInsuredPages.get(i);
				// 別表印刷
				Iterator subIt = subPages.iterator();
				while (subIt.hasNext()) {
					// メイン事業所単位
					List prov = (List) subIt.next();
					printSubTable(writer, subFormat, prov);
				}
			}
		}
	}

	/**
	 * 「別表印刷」に関する処理を行ないます。
	 * 
	 * @param writer
	 *            ACChotarouXMLWriter
	 * @param mng
	 *            QS001ServicePrintTableManager
	 * @param subFormat
	 *            String
	 * @param pages
	 *            List
	 * @throws Exception
	 *             処理例外
	 */
	public void printSubTable(ACChotarouXMLWriter writer, String subFormat,
			List pages) throws Exception {
		// ■別表を印刷します。

		Iterator it = pages.iterator();
		while (it.hasNext()) {
			// ページ出力を開始する。
			writer.beginPageEdit(subFormat);

			// ページ単位で印字内容が変更される項目を出力する。
			Map texts = (Map) it.next();
			Iterator it2 = texts.entrySet().iterator();
			while (it2.hasNext()) {
				Map.Entry ent = (Map.Entry) it2.next();
				ACChotarouXMLUtilities.setValue(writer,
						ACCastUtilities.toString(ent.getKey()),
						ACCastUtilities.toString(ent.getValue()));

			}
			// ページ出力を終了する。
			writer.endPageEdit();
		}
	}

	/**
	 * 「本票印刷」に関する処理を行ないます。
	 * 
	 * @param writer
	 *            ACChotarouXMLWriter
	 * @param mng
	 *            QS001ServicePrintTableManager
	 * @param mainFormat
	 *            String
	 * @param pages
	 *            List
	 * @param invisibles
	 *            , Map allTexts List
	 * @throws Exception
	 *             処理例外
	 */
	public void printMainTable(ACChotarouXMLWriter writer, String mainFormat,
			List pages, List invisibles, Map allTexts) throws Exception {
		// ■本票を印刷します。

		Iterator it = pages.iterator();
		while (it.hasNext()) {
			// ページ出力を開始する。
			writer.beginPageEdit(mainFormat);

			// 全ページ非表示にする項目を処理する。
			Iterator it2 = invisibles.iterator();
			while (it2.hasNext()) {
				ACChotarouXMLUtilities.setInvisible(writer,
						ACCastUtilities.toString(it2.next()));
			}

			// ページ単位で印字内容が変更される項目を出力する。
			Map texts = (Map) it.next();
			it2 = texts.entrySet().iterator();
			while (it2.hasNext()) {
				Map.Entry ent = (Map.Entry) it2.next();
				ACChotarouXMLUtilities.setValue(writer,
						ACCastUtilities.toString(ent.getKey()),
						ACCastUtilities.toString(ent.getValue()));

			}

			// 全ページ印字する項目を出力する。
			it2 = allTexts.entrySet().iterator();
			while (it2.hasNext()) {
				Map.Entry ent = (Map.Entry) it2.next();
				ACChotarouXMLUtilities.setValue(writer,
						ACCastUtilities.toString(ent.getKey()),
						ACCastUtilities.toString(ent.getValue()));
			}

			// ページ出力を終了する。
			writer.endPageEdit();
		}
	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QS001003.class.getName(), param));
	}

	// 内部関数

	/**
	 * 「画面展開時イベント」に関する処理を行ないます。
	 * 
	 * @param patientID
	 *            int
	 * @param targetDate
	 *            Date
	 * @param serviceData
	 *            VRList
	 * @param processType
	 *            int
	 * @param patientInsureInfoHistoryList
	 *            VRList
	 * @param inSpecialFacilityFlag
	 *            int
	 * @throws Exception
	 *             処理例外
	 */
	public void showModal(CareServiceCodeCalcurater calcurater,
			VRList serviceData, int processType) throws Exception {
		// ■各種初期値・初期状態を設定する
		// ※渡りパラメータの退避
		// calcuraterに、渡りパラメータの calcurater を設定する。
		setCalcurater(calcurater);
		// serviceDataに、渡りパラメータの serviceData を設定する。
		setServiceData(serviceData);
		// processTypeに、渡りパラメータの processType を設定する。
		setProcessType(processType);

		// 利用者氏名
		getPatentName().setText(calcurater.getPatientFullName());
		// 対象年月
		getServiceYearMonth().setText(calcurater.getTextOfTargetYearMonth());

		// ※初期値の設定
		// 画面の初期値を設定する。
		setInitValue();

		// ※初期状態の設定
		// 画面の初期状態を設定する。
		setInitState();

		setVisible(true);
	}

	/**
	 * 「初期値設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void setInitValue() throws Exception {
		// ■初期値設定
		// ※下準備
		// 月初の要介護度履歴情報格納用レコード patientInsureInfoFirst を生成する。
		VRMap patientInsureInfoFirst = null;
		// 月末の要介護度履歴情報格納用レコード patientInsureInfoLast を生成する。
		VRMap patientInsureInfoLast = null;
		// 最も重い要介護度履歴情報格納用レコード patientInsureInfoHeaviest を生成する。
		VRMap patientInsureInfoHeaviest = null;

		if (!getPatientInsureInfoHistoryList().isEmpty()) {
			// patientInsureInfoFirstに、patientInsureInfoHistoryListの最初のレコードを設定する。
			patientInsureInfoFirst = (VRMap) getPatientInsureInfoHistoryList()
					.get(0);
			// patientInsureInfoLastに、patientInsureInfoHistoryListの最後のレコードを設定する。
			patientInsureInfoLast = (VRMap) getPatientInsureInfoHistoryList()
					.get(getPatientInsureInfoHistoryList().size() - 1);
			// patientInsureInfoHeaviestに、最も重い要介護度履歴情報を設定する。
			patientInsureInfoHeaviest = QkanCommon
					.getPatientInsureInfoOnMostHeavy(getPatientInsureInfoHistoryList());
		}
		// ※ウィンドウタイトルの設定
		// 業務情報レコードを取得する。
		// ウィンドウタイトルに、取得レコードのKEY : WINDOW_TITLEのVALUEを設定する。
		setAffairTitle("QS001003");
		// ※居宅サービス提供者
		// コンボのアイテムとして、居宅介護支援事業者を設定する。
		// [ID:0000724][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 del begin
		// setSupportProviders(QkanCommon.getProviderInfo(getDBManager(), new
		// int[]{14311, 17311}));
		// [ID:0000724][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 del end
		// [ID:0000724][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add begin
		setSupportProviders(QkanCommon.getProviderInfo(getDBManager(),
				new int[] { 14311, 17311, 17711 }));
		// [ID:0000724][Masahiko.Higuchi] 2012/04 平成24年4月法改正対応 add end
		// 2016/8/3 [総合事業対応][Shinobu Hitaka] mod - begin AF:予防ケアマネジメントを追加
		//setPreventSupportProviders(QkanCommon.getProviderInfo(getDBManager(),
		//		new int[] { 14611, 17511 }));
		setPreventSupportProviders(QkanCommon.getProviderInfo(getDBManager(),
				new int[] { 14611, 17511, 51511 }));
		// 2016/8/3 [総合事業対応][Shinobu Hitaka] mod - end

		getSupportProviderName().setModel(getSupportProviders());
		// コンボの選択項目として、利用者情報より取得した「居宅サービス提供者」を設定する。

		VRMap defaultInsurer = patientInsureInfoLast;
		if (defaultInsurer == null) {
			defaultInsurer = patientInsureInfoFirst;
		}

		int planner = 2;
		Object defaultProvider = null;
		if (defaultInsurer != null) {
			defaultProvider = defaultInsurer.get("PROVIDER_ID");
			planner = ACCastUtilities.toInt(defaultInsurer.get("PLANNER"), 2);
			if (planner <= 0) {
				planner = 2;
			}
		}

		// 居宅介護支援系サービスを抽出する
		VRMap careManagementService = null;
		Object supporterID = null;
		Iterator it = getServiceData().iterator();
		while (it.hasNext()) {
			VRMap row = (VRMap) it.next();
			if (CareServiceCommon.isCareManagement(row)
					|| CareServiceCommon.isFacilityVisitMultifunction(row)) {
				// 居宅介護支援サービスを更新する
				careManagementService = row;
			}
		}
		// 居宅介護支援あり
		if (careManagementService != null) {
			defaultProvider = VRBindPathParser.get("PROVIDER_ID",
					careManagementService);
			if (CareServiceCommon.isPreventService(careManagementService)) {
				// 予防サービスの場合
				planner = 3;
				if (CareServiceCommon
						.isFacilityVisitMultifunction(careManagementService)) {
					// 介護予防小規模多機能型居宅介護
					supporterID = VRBindPathParser.get("1750104",
							careManagementService);
				} else {
					// 介護予防支援費
					if (VRBindPathParser.has("1460103", careManagementService)) {
						// 委託先専門員番号が定義されている場合
						supporterID = VRBindPathParser.get("1460103",
								careManagementService);
					} else {
						supporterID = VRBindPathParser.get("1430107",
								careManagementService);
					}
					if (VRBindPathParser.has("1460102", careManagementService)) {
						// 委託先事業所が定義されている場合
						Object provID = VRBindPathParser.get("1460102",
								careManagementService);
						if (!ACTextUtilities.isNullText(provID)) {
							defaultProvider = provID;
						}
					}
				}
			} else {
				// 予防サービスではない場合
				planner = 1;
				if (CareServiceCommon
						.isFacilityVisitMultifunction(careManagementService)) {
					// 小規模多機能型
					supporterID = VRBindPathParser.get("1730104",
							careManagementService);
				} else {
					// 居宅介護支援
					supporterID = VRBindPathParser.get("1430107",
							careManagementService);
				}
			}
		}

		getPlanManufacturer().setSelectedIndex(planner);
		if (getPatent().isSelected()) {
			// 被保険者自身でケアプランを作成した場合
			// 月末の要介護認定履歴から届出日を取得
			VRMap history;
			if (patientInsureInfoLast != null) {
				history = patientInsureInfoLast;
			} else {
				history = patientInsureInfoFirst;
			}
			if (history != null) {
				Date reportDay = ACCastUtilities.toDate(
						history.get("REPORTED_DATE"), null);
				if (reportDay != null) {
					// 届出日が設定されていれば転記
					getDateOfWrittenReport().setDate(reportDay);
				}
			}
			if (getSupportProviderName().getItemCount() > 0) {
				getSupportProviderName().setSelectedIndex(0);
			}
		}

		if (defaultProvider != null) {
			VRList providers;
			if (getPreventSupportProvider().isSelected()) {
				// 予防居宅介護支援
				providers = getPreventSupportProviders();
			} else {
				// 居宅介護支援
				providers = getSupportProviders();
			}
			int index = ACBindUtilities.getMatchIndexFromValue(providers,
					"PROVIDER_ID", defaultProvider);
			getSupportProviderName().setSelectedIndex(index);

			if ((supporterID != null) && (getSupporters() != null)) {
				// 介護支援専門員番号あり
				index = ACBindUtilities.getMatchIndexFromValue(getSupporters(),
						"CARE_MANAGER_NO", supporterID);
				if (index > 0) {
					getPersonInCharge().setSelectedIndex(index);
				}
			}
		}

		// ※居宅介護支援事業者事業所名
		// 未選択とする。
		// ※作成年月日(枠外/別表)
		// システム日付を設定する。
		getDateOfMakingOutsideFrame().setDate(
				QkanSystemInformation.getInstance().getSystemDate());
		// ※作成年月日
		// システム日付を設定する。
		getDateOfMaking().setDate(
				QkanSystemInformation.getInstance().getSystemDate());
		// ※届出年月日
		// 初期値は設定しない。

//2015/4/15 [H27.04改正対応][Yoichiro Kamei] mod - begin 短期入所日数の初期値対応
        boolean isShortStayCountZero = false;//短期入所日数0と表示するかどうか
        
        Date first = ACCastUtilities.toDate(
                patientInsureInfoFirst.get("INSURE_VALID_START"), null);
        Date last = ACCastUtilities.toDate(
                patientInsureInfoLast.get("INSURE_VALID_START"), null);
        
        // ※要介護状態区分
        // patientInsureInfoFirstより「要介護状態区分」情報を取得し、画面のyouKaigodoType1に設定する。
        Object firstCode = patientInsureInfoFirst.get("JOTAI_CODE");
        getYouKaigodoType1().setText(
                        QkanJotaiCodeUnapplicableFormat.getInstance().format(firstCode));
        
        //対象月に複数の介護保険情報の登録がある場合
        if (patientInsureInfoFirst != patientInsureInfoLast) {
            Object lastCode = patientInsureInfoLast.get("JOTAI_CODE");
            // patientInsureInfoLastより「要介護状態区分」情報を取得し、画面のyouKaigodoType2に設定する。
            if ((firstCode == null) || (!firstCode.equals(lastCode))) {
                getYouKaigodoType2().setText(
                        QkanJotaiCodeUnapplicableFormat.getInstance().format(lastCode));
                // 要介護度が切り替わる場合の短期入所日数は0
                isShortStayCountZero = true;
            }
            // 認定有効期間(開始)が変わる場合も短期入所日数は0
            if (first != null && last != null) {
               if (ACDateUtilities.compareOnDay(first, last) != 0) {
                   isShortStayCountZero = true;
               }
            }
        }
        
        int shortStayCount = 0;
        //対象月で最新の介護保険情報について、短期入所日数の初期値を取得
        if (!isShortStayCountZero && last != null) {
            // 認定の有効期間開始から対象年月前月いっぱいまでの短期入所サービス
            VRMap param = new VRHashMap();
            param.setData("TARGET_DATE", getTargetDateSource());
            param.setData("INSURE_VALID_START", last);
            param.setData("PATIENT_ID", new Integer(getPatientID()));
            shortStayCount = getPreviewShortStay(param);

            int initShortStayCount = ACCastUtilities.toInt(
                    patientInsureInfoLast.get("SHORTSTAY_USE_INIT_COUNT"), 0);
            if (initShortStayCount > 0) {
                //備考として出力
                String biko = " （初期値：" + String.valueOf(initShortStayCount)
                            + " ＋ 実績値：" + String.valueOf(shortStayCount) + "）";
                getShortStayUseDayBiko().setText(biko);
                //実績値に初期値を足す
                shortStayCount += initShortStayCount;
            }
        }
//2015/4/15 [H27.04改正対応][Yoichiro Kamei] mod - end
		getShortStayUseDay().setText(String.valueOf(shortStayCount));

		// ※支給限度基準額
		// patientInsureInfoHeaviestより「支給限度基準額」情報を取得し、設定する。
		getLimitAmountContent().setText(
				ACCastUtilities.toString(
						patientInsureInfoHeaviest.get("LIMIT_RATE"), ""));
		// ※限度額適用期間
		// patientInsureInfoHeaviestより「限度額適用期間」情報を取得し、設定する。
		ACBorderBlankDateFormat yearMonthFormat = new ACBorderBlankDateFormat(
				"ggge年MM月");
		getApplicationPeriodBegin().setText(
				yearMonthFormat.format(ACCastUtilities.toDate(
						patientInsureInfoHeaviest.get("INSURE_VALID_START"),
						null)));
		
		
// 2016/7/19 [総合事業対応][Yoichiro Kamei] mod - begin
//		getApplicationPeriodEnd()
//		.setText(
//				yearMonthFormat.format(ACCastUtilities.toDate(
//						patientInsureInfoHeaviest
//								.get("INSURE_VALID_END"), null)));
		Date endDate = ACCastUtilities.toDate(
				patientInsureInfoHeaviest
				.get("INSURE_VALID_END"), null);
		
	    // 9999-12-31のときは空欄を表示
		if (ACCastUtilities.toDate("9999/12/31").equals(endDate)) {
			getApplicationPeriodEnd().setText("");
		} else {
			getApplicationPeriodEnd().setText(yearMonthFormat.format(endDate));
		}
// 2016/7/19 [総合事業対応][Yoichiro Kamei] mod - end

		// ※前月までの短期入所利用日数(要介護度認定期間中の前月までの短期入所系サービス実績回数をカウント)
		// ※要介護度の有効期間を取得する。
		// 有効期間開始日格納用の内部変数 insureValidStart を生成する。
		Date insureValidStart = null;
		// 有効期間終了日格納用の内部変数 insureValidEnd を生成する。
		Date insureValidEnd = null;
		// patientInsureInfoFirstから有効期間開始(KEY :
		// INSURE_VALID_START)を取得し、insureValidStartに設定する。
		// insureInvalidEndに、対象年月の前月末日を設定する。(末日 = 年月:targetDateの一日(ついたち) マイナス
		// 1日など)
		// ※有効期間内のサービス実績情報を取得する。
		// サービス詳細情報取得関数への渡りパラメータ params(文字列)を生成し、下記の値を設定する。
		String params = null;
		// params =
		// "PATIENT_ID=" + patientID +
		// "SERVICE_DATE>=" + insureValidStart +
		// "SERVICE_DATE<=" + insureValidEnd
		// "SERVICE_USE_TYPE=6" //開始日○な実績
		// 有効期間内のサービス実績情報を取得する。
		// QkanCommon.getServiceDetailCustom(getDBManager(), params);
		// ※前月までの短期入所利用日数の集計
		// 取得した実績情報から、短期入所利用日数をカウントする。
		// ・サービス種類が21、22、23のサービスをカウント対象とする
		// ・「30日超」が設定されているものはカウントしない
		// ・同日中に2つ以上のサービス実績があっても、「1日」としてカウントする
		// 例)
		// 提供日格納用のレコード集合 offerDates を生成する。
		// 実績情報レコード集合のn番目のレコード退避用のレコード recを生成する。
		// 「30日超」チェック用の数値 over30 を生成する。
		// チェック対象のサービス実績提供日格納用の日付 serviceDateを生成する。
		// 利用日数格納用の数値 usedDayCountを生成し、0で初期化する。
		// 取得した実績情報分ループする。
		// 実績情報レコード集合のn番目のレコードを rec に退避する。
		// ※サービス種類のチェック / 「30日超」チェック
		// rec の KEY : SYSTEM_SERVICE_KIND_DETAIL の VALUE で分岐する。
		// 12101
		// over30に、rec の KEY : 1210113 の VALUE を設定する。
		// 12201
		// over30に、rec の KEY : 1220114 の VALUE を設定する。
		// 12301
		// over30に、rec の KEY : 1230152 の VALUE を設定する。
		// 12302
		// over30に、rec の KEY : 1230250 の VALUE を設定する。
		// 12303
		// over30に、rec の KEY : 1230349 の VALUE を設定する。
		// 12304
		// over30に、rec の KEY : 1230408 の VALUE を設定する。
		// 上記以外の場合
		// 次のループへ飛ぶ。
		// over30の値をチェックする。
		// 0(30日超でない)の場合
		// 処理を継続する。
		// 1(30日超である)の場合
		// 次のループへ飛ぶ。
		// ※カウント処理
		// serviceDateにrecの KEY : SERVICE_DATE の VALUE を設定する。
		// 既にカウントした日付かどうかチェックするために、offerDatesの件数分ループする。
		// serviceDateとofferDatesのn番目の日付とを比較する。
		// 等しい場合
		// 次のrecのループへ飛ぶ。
		// 等しくない場合
		// offerDatesのループを継続する。
		// どのofferDatesとも重複せずにループを抜けたserviceDateに関して、下記の処理を行う。
		// usedDayCountを1増やす。
		// offerDatesにserviceDateを追加する。
		// 取得したサービス利用日数を画面の「短記入所利用日数(shortStayUseDay)」に設定する。
		// ※公費も含んだ給付率で別表を作成
		// 未選択とする。
		// ※帳票種別選択
		// ※印刷する帳票の種類
		getSlitType().setSelectedIndex(1);
		getSlitKind().setSelectedIndex(1);
		
		//[2014年要望][Shinobu Hitaka] 2014/10/23 add begin 敬称を印字する
		// 設定ファイルのPrintConfig-KeishoRadioが1の場合
		int keisyoIndex = 1;
		if (ACFrame.getInstance().hasProperty("PrintConfig/KeishoRadio")) {
			String strKeisyo = getProperty("PrintConfig/KeishoRadio");
			if ("2".equals(strKeisyo)) {
				keisyoIndex = 2;
			} else if ("3".equals(strKeisyo)) {
				keisyoIndex = 3;
			}
		}
		getSlitKeisyo().setSelectedIndex(keisyoIndex);
		//getKeisyo().setVisible(false);
		//[2014年要望][Shinobu Hitaka] 2014/10/23 add end   敬称を印字する

	}

	/**
	 * 「画面の初期状態の設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void setInitState() throws Exception {
		// ■画面の初期状態を設定
		// ※居宅介護支援事業者事業所欄の有効/無効設定
		// 居宅介護支援事業者事業所欄の有効/無効を設定する。
		// setProviderComponentState();

		// ※予定印刷なのか、実績印刷なのかによって、状態を設定
		// processTypeの値をチェックする。
		if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
			// PROCESS_TYPE_PLANの場合
			// 「公費も含んだ給付率で別表を作成」チェックボックス、「帳票種類」グループを表示する。
			setState_PROCESS_TYPE_PLAN();
		} else {
			// PROCESS_TYPE_RESULTの場合
			// 「公費も含んだ給付率で別表を作成」チェックボックス、「帳票種類」グループを非表示にする。
			setState_PROCESS_TYPE_RESULT();
		}

	}

	/**
	 * 「居宅介護支援事業者事業所欄の状態設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void setProviderComponentState() throws Exception {
		// ■居宅介護支援事業者事業所欄の有効/無効の切替
		// ※居宅介護支援事業者事業所欄の有効/無効設定
		// planManufacturerの値をチェックする。
		switch (getPlanManufacturer().getSelectedIndex()) {
		case 1:
			// 「居宅介護支援事業者」が選択されている場合
			// 居宅介護支援事業者事業所欄を有効にする。
			setState_PROVIDER_MADE();
			// 居宅介護支援事業者事業所の候補を居宅介護支援を提供している事業所に変更する。
			getSupportProviderName().setModel(getSupportProviders());
			if (getSupportProviderName().getItemCount() > 0) {
				getSupportProviderName().setSelectedIndex(0);
			} else {
				getSupportProviderName().setSelectedIndex(-1);
			}
			break;
		case 3:
			// 「予防居宅介護支援事業者」が選択されている場合
			// 居宅介護支援事業者事業所欄を有効にする。
			setState_PROVIDER_MADE();
			// 居宅介護支援事業者事業所の候補を予防居宅介護支援を提供している事業所に変更する。
			getSupportProviderName().setModel(getPreventSupportProviders());
			if (getSupportProviderName().getItemCount() > 0) {
				getSupportProviderName().setSelectedIndex(0);
			} else {
				getSupportProviderName().setSelectedIndex(-1);
			}
			break;
		default:
			// 「居宅介護支援事業者」が選択されていない場合
			// 居宅介護支援事業者事業所欄を無効にする。
			setState_SELF_MADE();
			break;
		}

	}

	/**
	 * 「閉じる」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void endActionPerformed(ActionEvent e) throws Exception {
		dispose();
	}

	/**
	 * 「利用者ID取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @return int
	 */
	public int getPatientID() throws Exception {
		return getCalcurater().getPatientID();
	}

	/**
	 * 「特定入居者フラグを取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @return int
	 */
	public int getInSpecialFacilityFlag() throws Exception {
		return getCalcurater().getInSpecialFacilityFlag();
	}

	/**
	 * 「対象年月取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @return Date
	 */
	public Date getTargetDateSource() throws Exception {
		return getCalcurater().getTargetDate();
	}

	/**
	 * 「要介護認定履歴取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @return VRList
	 */
	public VRList getPatientInsureInfoHistoryList() throws Exception {
		return getCalcurater().getPatientInsureInfoHistoryList();
	}

	/**
	 * 「サービス種類集合取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @return VRList
	 */
	public VRList getServiceKindsList() throws Exception {
		return getCalcurater().getServiceKindsList();
	}

	/**
	 * 「事業所情報ハッシュ取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 * @return VRMap
	 */
	public VRMap getHashedProviders() throws Exception {
		return getCalcurater().getHashedProviders();
	}

	/**
	 * 前月までの短期入所利用日数を実績情報より取得します。
	 * ※ただし、30日超のサービスについては含まない。
	 * 
	 * @author n0158 Masahiko.Higuchi
	 * @since V6.1.4
	 * [ID:0000764] 30日超サービス別表印字障害対応（あわせて修正）
	 */
	public int getPreviewShortStay(VRMap sqlParam) throws Exception {

		ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
		// 年度判定
		Date startDate = ACCastUtilities.toDate(sqlParam.getData("INSURE_VALID_START"));
		Date endDate = ACCastUtilities.toDate(sqlParam.getData("TARGET_DATE"));
		int startMonth = ACDateUtilities.getMonth(startDate);
		int endMonth = ACDateUtilities.getMonth(endDate);
		int startYear = ACDateUtilities.getYear(startDate);
		int endYear = ACDateUtilities.getYear(endDate);
		int rtnCount = 0;
		// 4月より前なら年度を戻す
		if (startMonth < 4) {
			startYear -= 1;
		}
		if (endMonth < 4) {
			endYear -= 1;
		}
		
		do {
			String tableName = "SERVICE_DETAIL_INTEGER_" + startYear;
			StringBuilder sb = new StringBuilder();
			
			sb.append("SELECT");
			sb.append(" DISTINCT(SERVICE_DATE)");
			sb.append(" FROM ");
			sb.append(tableName + ",");
			sb.append(" SERVICE");
			sb.append(" WHERE");
			sb.append("(");
			sb.append(" SERVICE.SERVICE_ID ");
			sb.append(" = ");
			sb.append(tableName + ".SERVICE_ID");
			sb.append(")");
			sb.append(" AND");
			sb.append(" (");
			sb.append(tableName + ".SYSTEM_BIND_PATH");
			sb.append(" = 5");
			sb.append(")");
			sb.append(" AND");
			sb.append(" (");
			sb.append(tableName + ".DETAIL_VALUE");
			sb.append(" <> 2");
			sb.append(")");
			sb.append(" AND");
			sb.append(" (");
		    sb.append(" SERVICE.PATIENT_ID");
		    sb.append(" =");
		    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));
		    sb.append(")");
		    sb.append("AND");
		    sb.append("(");
		    sb.append(" SERVICE.SERVICE_USE_TYPE");
		    sb.append(" =");
		    sb.append(" 6");
		    sb.append(")");
		    sb.append("AND");
		    sb.append("(");
		    sb.append(" SERVICE.SYSTEM_SERVICE_KIND_DETAIL");
		    sb.append(" >=");
		    sb.append(" 12000");
		    sb.append(")");
		    sb.append("AND");
		    sb.append("(");
		    sb.append(" SERVICE.SYSTEM_SERVICE_KIND_DETAIL");
		    sb.append(" <=");
		    sb.append(" 12999");
		    sb.append(")");
		    sb.append("AND");
		    sb.append("(");
		    sb.append(" SERVICE.SERVICE_DATE");
		    sb.append(" <");
		    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-01"));
		    sb.append(")");
		    sb.append("AND");
		    sb.append("(");
		    sb.append(" SERVICE.SERVICE_DATE");
		    sb.append(" >=");
		    sb.append(dateFormat.format(VRBindPathParser.get("INSURE_VALID_START", sqlParam), "yyyy-MM-dd"));
		    sb.append(")");
			
		    try {
		    	VRList result =  getDBManager().executeQuery(sb.toString());
			    
		    	rtnCount += result.size();
			} catch (Exception e) {
				// テーブルが無い場合のエラーはスルー
			}
		    
			startYear ++;
		}while(startYear <= endYear);

		return rtnCount;
	}



}
