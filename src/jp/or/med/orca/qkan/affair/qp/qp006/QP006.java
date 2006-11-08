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
 * 作成日: 2006/01/18  日本コンピューター株式会社 廣瀬 一海 新規作成
 * 更新日: 2006/03/14
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (006)
 * プログラム 医療明細書詳細編集 (QP006)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp006;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.text.Format;
import java.util.Date;

import javax.swing.event.DocumentEvent;

import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACTimeTextField;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.component.QkanDateTextField;

/**
 * 医療明細書詳細編集(QP006)
 */

public class QP006 extends QP006Event {
	/**
	 * コンストラクタです。
	 */
	public QP006() {
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
		// ・this.patientId ※KEY：PATIENT_ID
		// ・this.targetDate ※KEY：TARGET_DATE
		// ・this.providerId ※KEY：PROVIDER_ID
		// ・this.claimStyleType ※KEY：CLAIM_STYLE_TYPE
		// ・this.listIndex ※KEY：LIST_INDEX

		VRMap parameters = affair.getParameters();

		if (VRBindPathParser.has("PATIENT_ID", parameters)) {
			setPatientId(ACCastUtilities.toInt(parameters.getData("PATIENT_ID")));
		}

		if (VRBindPathParser.has("TARGET_DATE", parameters)) {
			setTargetDate(ACCastUtilities.toDate(parameters.getData("TARGET_DATE")));
		}

		if (VRBindPathParser.has("CLAIM_DATE", parameters)) {
			setClaimDate(ACCastUtilities.toDate(parameters.getData("CLAIM_DATE")));
		}

		if (VRBindPathParser.has("PROVIDER_ID", parameters)) {
			setProviderId(ACCastUtilities.toString(parameters.getData("PROVIDER_ID")));
		}

		if (VRBindPathParser.has("CLAIM_STYLE_TYPE", parameters)) {
			setClaimStyleType(ACCastUtilities.toInt(parameters.getData("CLAIM_STYLE_TYPE")));
		}

		if (VRBindPathParser.has("LIST_INDEX", parameters)) {
			setListIndex(ACCastUtilities.toInt(parameters.getData("LIST_INDEX")));
		}

		if (VRBindPathParser.has("INSURER_ID", parameters)) {
			setInsurerID(ACCastUtilities.toString(VRBindPathParser.get("INSURER_ID", parameters)));
		}

		// パッシブチェックキーをセットする
		setPASSIVE_CHECK_KEY(new ACPassiveKey("CLAIM", new String[] { "CLAIM_ID" }, new Format[] { null }, "LAST_TIME", "LAST_TIME"));

		// スナップショットの撮影対象を「情報領域（infos）」に設定する。
		getSnapshot().setRootContainer(getInfos());

		// コンボの設定を行う。
		// コードマスタデータを取得する。
		VRMap modelMap = new VRHashMap();

		// 取得したコードマスタデータより、CODE_ID：19（職務上の事由）を取得する。
		// 取得したレコード集合（職務上の事由の選択肢）をコンボ設定用HashMap：this.modelMapに以下のKEYで設定する。
		// ・KEY：SHOKUMU_JIYU
		modelMap.setData("SHOKUMU_JIYU", QkanCommon.getArrayFromMasterCode(19, "1301022"));
		modelMap.setData("HOUMON_END_STATE", QkanCommon.getArrayFromMasterCode(9, "1301099"));
		setModelMap(modelMap);

		// this.modelMapを「情報領域（infos）」に設定する。
		getInfos().setModelSource(getModelMap());
		// 画面に展開する。
		getInfos().bindModelSource();
		// データを取得し、画面に展開する。
		doFind();

		// スナップショットを撮影する。
		getSnapshot().snapshot();

        
        String osName = System.getProperty("os.name");
        if ((osName != null) && (osName.indexOf("Mac") >= 0)) {
            //Macの場合、行数等を調整して画面内に収める
            getOfferInfoText().setRows(3);
            getSpecialEtcText().setRows(3);
            getVisitCareDetailedTotalMoneyStanderdEtcText().setColumns(52);
            getVisitCareDetailedTotalMoneyStanderdEtcText().setMaxRows(5);
            getVisitCareDetailedTotalMoneyStanderdEtcText().setRows(6);
            
            getVisitCareDetailedExpenseMoneyText1().setColumns(6);
            getVisitCareDetailedExpenseMoneyText2().setColumns(6);
            getVisitCareDetailedExpenseMoneyText3().setColumns(6);
            getVisitCareDetailedOneshareText().setColumns(6);
            getVisitCareDetailedOneshareTex2().setColumns(6);
            getVisitCareDetailedOneshareTex3().setColumns(6);
        }
	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		// 変更チェック（スナップショットのチェック）
		if (getSnapshot().isModified()) {
			// ・メッセージID：WARNING_OF_UPDATE_ON_MODIFIED
			int buttonStatus = QkanMessageList.getInstance().WARNING_OF_UPDATE_ON_MODIFIED();
			// 最後に保存されてから、項目が変更されている場合（isModified）
			// 確認メッセージを表示する。
			switch (buttonStatus) {
				case ACMessageBox.RESULT_YES:
					// 「はい」を選択した場合
					// 入力チェックを行う。
					if (isValidInput() && doSave()) {
						// 保存処理が正常終了した場合
						// 完了メッセージを表示する。
						// メッセージID：UPDATE_SUCCESSED
						// スナップショットに変更が無かった場合
						// 下記を渡りパラメータとして、「QP003 帳票（様式）・事業所選択」画面に遷移する。
						// ・KEY：PATIENT_ID VALUE：this.patientId
						// ・KEY：TARGET_DATE VALUE：this.targetDate
						// ・KEY：LIST_INDEX VALUE：this.listIndex

						parameters.setData("PATIENT_ID", new Integer(getPatientId()));
						parameters.setData("TARGET_DATE", getTargetDate());
						parameters.setData("LIST_INDEX", new Integer(getListIndex()));
						parameters.setData("QP003", getClass().getName());
						return true;

					} else {
						// 入力エラーがあった場合
						// 処理を中断する。(終了)
						// 保存処理が正常終了しなかった場合
						// 処理を中断する。(終了)
					}
					break;

				case ACMessageBox.RESULT_NO:
					// 「いいえ」を選択した場合
					return true;

				default:
					break;
			}
		} else {
			parameters.setData("PATIENT_ID", new Integer(getPatientId()));
			parameters.setData("TARGET_DATE", getTargetDate());
			parameters.setData("LIST_INDEX", new Integer(getListIndex()));
			parameters.setData("QP003", getClass().getName());
			return true;
		}

		return false;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// 変更チェック（スナップショットのチェック）
		if (!getSnapshot().isModified()) {
			// 最後に保存されてから、項目が変更されていない場合（isModified）
			// システムを終了する。
			return true;
		} else {
			// 最後に保存されてから、項目が変更されている場合（not isModified）
			// 終了確認メッセージを表示する。
			if (QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED() == ACMessageBox.RESULT_OK) {
				// ・メッセージID：WARNING_OF_CLOSE_ON_MODIFIED
				// 「はい」を選択した場合
				// システムを終了する。
				return true;
			} else {
				// 「キャンセル」を選択した場合
				// 処理を中断する（何もしない）。
				return false;
			}
		}
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
		// 入力エラーがあった場合
		// 処理を中断する。(終了)
		if (!isValidInput()) {
			return;
		}
		// 保存処理を行う。
		if (doSave()) {

			// 保存処理が正常終了した場合
			// 完了メッセージを表示する。
			QkanMessageList.getInstance().UPDATE_SUCCESSED();
			// ・メッセージID：UPDATE_SUCCESSED
			// 保存処理が正常終了しなかった場合
		} else {
			// 処理を中断する。(終了)
			return;
		}
		// スナップショットを撮影する。
		getSnapshot().snapshot();
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText1FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText1に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText2に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText1(), getVisitCareDetailedDayText1())) {
			multiPlication(getVisitCareDetailedMoneyText1(), getVisitCareDetailedDayText1(), getVisitCareDetailedMoneyText2());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedDayText1FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText1に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText2に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText1(), getVisitCareDetailedDayText1())) {
			multiPlication(getVisitCareDetailedMoneyText1(), getVisitCareDetailedDayText1(), getVisitCareDetailedMoneyText2());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText2FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText3FocusLost(FocusEvent e) throws Exception {
		// 公費1の請求金額の合計を計算する。
		doCalcTotalKohi1();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText4FocusLost(FocusEvent e) throws Exception {
		// 公費2の請求金額の合計を計算する。
		doCalcTotalKohi2();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText5FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText2に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText6に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText5(), getVisitCareDetailedDayText2())) {
			multiPlication(getVisitCareDetailedMoneyText5(), getVisitCareDetailedDayText2(), getVisitCareDetailedMoneyText6());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedDayText2FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText5に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText6に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText5(), getVisitCareDetailedDayText2())) {
			multiPlication(getVisitCareDetailedMoneyText5(), getVisitCareDetailedDayText2(), getVisitCareDetailedMoneyText6());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText6FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText7FocusLost(FocusEvent e) throws Exception {
		// 公費1の請求金額の合計を計算する。
		doCalcTotalKohi1();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText8FocusLost(FocusEvent e) throws Exception {
		// 公費2の請求金額の合計を計算する。
		doCalcTotalKohi2();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText9FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText3に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText10に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText9(), getVisitCareDetailedDayText3())) {
			multiPlication(getVisitCareDetailedMoneyText9(), getVisitCareDetailedDayText3(), getVisitCareDetailedMoneyText10());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedDayText3FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText9に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText10に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText9(), getVisitCareDetailedDayText3())) {
			multiPlication(getVisitCareDetailedMoneyText9(), getVisitCareDetailedDayText3(), getVisitCareDetailedMoneyText10());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText10FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText11FocusLost(FocusEvent e) throws Exception {
		// 公費1の請求金額の合計を計算する。
		doCalcTotalKohi1();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText12FocusLost(FocusEvent e) throws Exception {
		// 公費2の請求金額の合計を計算する。
		doCalcTotalKohi2();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText13FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText4に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText14に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText13(), getVisitCareDetailedDayText4())) {
			multiPlication(getVisitCareDetailedMoneyText13(), getVisitCareDetailedDayText4(), getVisitCareDetailedMoneyText14());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedDayText4FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText13に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText14に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText13(), getVisitCareDetailedDayText4())) {
			multiPlication(getVisitCareDetailedMoneyText13(), getVisitCareDetailedDayText4(), getVisitCareDetailedMoneyText14());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText14FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText15FocusLost(FocusEvent e) throws Exception {
		// 公費1の請求金額の合計を計算する。
		doCalcTotalKohi1();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText16FocusLost(FocusEvent e) throws Exception {
		// 公費2の請求金額の合計を計算する。
		doCalcTotalKohi2();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText17FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText5に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText18に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText17(), getVisitCareDetailedDayText5())) {
			multiPlication(getVisitCareDetailedMoneyText17(), getVisitCareDetailedDayText5(), getVisitCareDetailedMoneyText18());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedDayText5FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText17に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText18に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText17(), getVisitCareDetailedDayText5())) {
			multiPlication(getVisitCareDetailedMoneyText17(), getVisitCareDetailedDayText5(), getVisitCareDetailedMoneyText18());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText18FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText19FocusLost(FocusEvent e) throws Exception {
		// 公費1の請求金額の合計を計算する。
		doCalcTotalKohi1();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText20FocusLost(FocusEvent e) throws Exception {
		// 公費2の請求金額の合計を計算する。
		doCalcTotalKohi2();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText51FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText8に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText52に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText51(), getVisitCareDetailedDayText8())) {
			multiPlication(getVisitCareDetailedMoneyText51(), getVisitCareDetailedDayText8(), getVisitCareDetailedMoneyText52());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedDayText8FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText51に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText52に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText51(), getVisitCareDetailedDayText8())) {
			multiPlication(getVisitCareDetailedMoneyText51(), getVisitCareDetailedDayText8(), getVisitCareDetailedMoneyText52());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText52FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText53FocusLost(FocusEvent e) throws Exception {
		// 公費1の請求金額の合計を計算する。
		doCalcTotalKohi1();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText54FocusLost(FocusEvent e) throws Exception {
		// 公費2の請求金額の合計を計算する。
		doCalcTotalKohi2();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText21FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText6に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText22に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText21(), getVisitCareDetailedDayText6())) {
			multiPlication(getVisitCareDetailedMoneyText21(), getVisitCareDetailedDayText6(), getVisitCareDetailedMoneyText22());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedDayText6FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText21に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText22に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText21(), getVisitCareDetailedDayText6())) {
			multiPlication(getVisitCareDetailedMoneyText21(), getVisitCareDetailedDayText6(), getVisitCareDetailedMoneyText22());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText22FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText23FocusLost(FocusEvent e) throws Exception {
		// 公費1の請求金額の合計を計算する。
		doCalcTotalKohi1();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText24FocusLost(FocusEvent e) throws Exception {
		// 公費2の請求金額の合計を計算する。
		doCalcTotalKohi2();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText25FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedTimeText1に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText26に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText25(), getVisitCareDetailedTimeText1())) {
			multiPlication(getVisitCareDetailedMoneyText25(), getVisitCareDetailedTimeText1(), getVisitCareDetailedMoneyText26());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedTimeText1FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText25に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText26に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText25(), getVisitCareDetailedTimeText1())) {
			multiPlication(getVisitCareDetailedMoneyText25(), getVisitCareDetailedTimeText1(), getVisitCareDetailedMoneyText26());
		}

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText26FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText27FocusLost(FocusEvent e) throws Exception {
		// 公費1の請求金額の合計を計算する。
		doCalcTotalKohi1();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText28FocusLost(FocusEvent e) throws Exception {
		// 公費2の請求金額の合計を計算する。
		doCalcTotalKohi2();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText29FocusLost(FocusEvent e) throws Exception {
		// 以下のフィールド全てに値が入力されている場合
		// ・visitCareDetailedMoneyText29Insert
		// ・visitCareDetailedDayText7
		if (!ACTextUtilities.isNullText(getVisitCareDetailedMoneyText29Insert().getText()) && !ACTextUtilities.isNullText(getVisitCareDetailedDayText7().getText())) {
			// 以下の計算を行う。
			// （初日の金額） + （2日目以降の金額） × （日数） = （合計金額）
			// 算出した合計金額をvisitCareDetailedMoneyText30に表示する。
			multiPlication(getVisitCareDetailedMoneyText29(), getVisitCareDetailedMoneyText29Insert(), getVisitCareDetailedDayText7(), getVisitCareDetailedMoneyText30());
		} else {
			// 上記以外の場合
			// visitCareDetailedMoneyText29に入力されている値をvisitCareDetailedMoneyText30に表示する。
			getVisitCareDetailedMoneyText30().setText(ACCastUtilities.toString(getVisitCareDetailedMoneyText29().getText()));
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText29InsertFocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText7に値が入力されている場合
		if (!ACTextUtilities.isNullText(getVisitCareDetailedDayText7().getText())) {
			// 以下の計算を行う。
			// （初日の金額） + （2日目以降の金額） × （日数） = （合計金額）
			// 算出した合計金額をvisitCareDetailedMoneyText30に表示する。
			// visitCareDetailedMoneyText29に値が入力されていない場合
			multiPlication(getVisitCareDetailedMoneyText29(), getVisitCareDetailedMoneyText29Insert(), getVisitCareDetailedDayText7(), getVisitCareDetailedMoneyText30());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedDayText7FocusLost(FocusEvent e) throws Exception {
		if (!ACTextUtilities.isNullText(getVisitCareDetailedDayText7().getText())) {
			// visitCareDetailedMoneyText29Insertに値が入力されている場合
			if (!ACTextUtilities.isNullText(getVisitCareDetailedMoneyText29Insert().getText())) {

				// visitCareDetailedMoneyText29に値が入力されている場合
				if (!ACTextUtilities.isNullText(getVisitCareDetailedMoneyText29().getText())) {
					// 以下の計算を行う。
					// （初日の金額） + （2日目以降の金額） × （日数） = （合計金額）
					// 算出した合計金額をvisitCareDetailedMoneyText30に表示する。

					multiPlication(getVisitCareDetailedMoneyText29(), getVisitCareDetailedMoneyText29Insert(), getVisitCareDetailedDayText7(), getVisitCareDetailedMoneyText30());

				} else {
					// visitCareDetailedMoneyText29に値が入力されていない場合
					// 以下の計算を行う。
					// （2日目以降の金額） × （日数） = （2日目以降の合計金額）
					// 2日目以降の合計金額をvisitCareDetailedMoneyText30に表示する。
					multiPlication(getVisitCareDetailedMoneyText29Insert(), getVisitCareDetailedDayText7(), getVisitCareDetailedMoneyText30());
				}
				// visitCareDetailedMoneyText29Insertに値が入力されていない場合
			} else {
				// visitCareDetailedMoneyText29に値が入力されている場合
				// visitCareDetailedMoneyText29に入力されている値をvisitCareDetailedMoneyText30に表示する。
				getVisitCareDetailedMoneyText30().setText(ACCastUtilities.toString(getVisitCareDetailedMoneyText29().getText()));

			}
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText30FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText31FocusLost(FocusEvent e) throws Exception {
		// 公費1の請求金額の合計を計算する。
		doCalcTotalKohi1();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText32FocusLost(FocusEvent e) throws Exception {
		// 公費2の請求金額の合計を計算する。
		doCalcTotalKohi2();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText36FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText37FocusLost(FocusEvent e) throws Exception {
		// 公費1の請求金額の合計を計算する。
		doCalcTotalKohi1();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText38FocusLost(FocusEvent e) throws Exception {
		// 公費2の請求金額の合計を計算する。
		doCalcTotalKohi2();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText39FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText40FocusLost(FocusEvent e) throws Exception {
		// 公費1の請求金額の合計を計算する。
		doCalcTotalKohi1();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText41FocusLost(FocusEvent e) throws Exception {
		// 公費2の請求金額の合計を計算する。
		doCalcTotalKohi2();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText42FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText43FocusLost(FocusEvent e) throws Exception {
		// 公費1の請求金額の合計を計算する。
		doCalcTotalKohi1();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText44FocusLost(FocusEvent e) throws Exception {
		// 公費2の請求金額の合計を計算する。
		doCalcTotalKohi2();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText45FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText46FocusLost(FocusEvent e) throws Exception {
		// 公費1の請求金額の合計を計算する。
		doCalcTotalKohi1();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText47FocusLost(FocusEvent e) throws Exception {
		// 公費2の請求金額の合計を計算する。
		doCalcTotalKohi2();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText48FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText49FocusLost(FocusEvent e) throws Exception {
		// 公費1の請求金額の合計を計算する。
		doCalcTotalKohi1();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText50FocusLost(FocusEvent e) throws Exception {
		// 公費2の請求金額の合計を計算する。
		doCalcTotalKohi2();

	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */

	protected void visitCareDetailedDayText9FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedMoneyText55に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText52に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText55(), getVisitCareDetailedDayText9())) {
			multiPlication(getVisitCareDetailedMoneyText55(), getVisitCareDetailedDayText9(), getVisitCareDetailedMoneyText56());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText55FocusLost(FocusEvent e) throws Exception {
		// visitCareDetailedDayText9に値が入力されている場合
		// 以下の計算を行う。
		// （1日あたりの金額） × （日数） = （合計金額）
		// 算出した合計金額をvisitCareDetailedMoneyText56に表示する。
		if (!checkEmpty(getVisitCareDetailedMoneyText55(), getVisitCareDetailedDayText9())) {
			multiPlication(getVisitCareDetailedMoneyText55(), getVisitCareDetailedDayText9(), getVisitCareDetailedMoneyText56());
		}
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText56FocusLost(FocusEvent e) throws Exception {
		// 請求金額の合計を計算する。
		doCalcTotal();
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText57FocusLost(FocusEvent e) throws Exception {
		doCalcTotalKohi1();
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText58FocusLost(FocusEvent e) throws Exception {
		doCalcTotalKohi2();
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText61FocusLost(FocusEvent e) throws Exception {
		doCalcTotal();
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText62FocusLost(FocusEvent e) throws Exception {
		doCalcTotalKohi1();
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedMoneyText63FocusLost(FocusEvent e) throws Exception {
		doCalcTotalKohi2();
	}

	/**
	 * 「金額計算処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedExpenseMoneyText1FocusLost(FocusEvent e) throws Exception {
		// 負担金額を計算する。
		// 画面上の以下のデータを取得する。
		// ・給付割合
		// ・保険請求円
		doCalcTotal();
	}

	/**
	 * 「Enable制御処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedReductionFocusLost(FocusEvent e) throws Exception {
		// 数値が入力されている場合
		if (!ACTextUtilities.isNullText(getVisitCareDetailedReduction().getText())) {
			// 減額ラジオグループと状態ラジオグループのEnable制御を行う。
			setState_REDUCTION_ENABLE_TRUE();
			// ・状態ID：REDUCTION_ENABLE_TRUE
		} else {
			// 何も入力されていない場合
			// 減額ラジオグループと状態ラジオグループのEnable制御を行う。
			setState_REDUCTION_ENABLE_FALSE();
			// ・状態ID：REDUCTION_ENABLE_FALSE
		}
	}

	/**
	 * 「Enable制御処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitCareDetailedReductionTextChanged(DocumentEvent e) throws Exception {
		// 数値が入力されている場合
		if (!ACTextUtilities.isNullText(getVisitCareDetailedReduction().getText())) {
			// 減額ラジオグループと状態ラジオグループのEnable制御を行う。
			setState_REDUCTION_ENABLE_TRUE();
			// ・状態ID：REDUCTION_ENABLE_TRUE
		} else {
			// 何も入力されていない場合
			// 減額ラジオグループと状態ラジオグループのEnable制御を行う。
			setState_REDUCTION_ENABLE_FALSE();
			// ・状態ID：REDUCTION_ENABLE_FALSE
		}
	}

	// {PATIENT_ID=2, CLAIM_DATE=Thu Jun 01 00:00:00 JST 2006, PROVIDER_ID=9999999999, LIST_INDEX=0, TARGET_DATE=2006-05-01, CLAIM_STYLE_TYPE=20101}
	// public static void main(String[] args) {
	// // デフォルトデバッグ起動
	// ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
	// QkanCommon.debugInitialize();
	// VRMap param = new VRHashMap();
	// param.setData("PATIENT_ID", new Integer(2));
	// param.setData("PROVIDER_ID", "9999999999");
	// param.setData("LIST_INDEX", new Integer(0));
	// param.setData("CLAIM_STYLE_TYPE", new Integer(20101));
	// param.setData("CLAIM_DATE", "2006-06-01");
	// param.setData("TARGET_DATE", "2006-05-01");
	// // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
	// ACFrame.debugStart(new ACAffairInfo(QP006.class.getName(), param));
	// }

	// 内部関数

	/**
	 * 「データ取得・画面展開」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFind() throws Exception {
		// 初期表示処理。
		// 初期表示状態ではFALSEで表示する。
		// setState_REDUCTION_ENABLE_FALSE();

		// 業務情報マスタより、データを取得する。
		// 取得したデータのウィンドウタイトル（WINDOW_TITLE）をウィンドウに設定する。
		// 取得したデータの業務タイトル（AFFAIR_TITLE）を業務ボタンバーに設定する。
		setAffairTitle("QP006", getButtons());
		// 利用者の医療請求データを取得し、this.claimListに格納する。
		doFindClaim();

	}

	/**
	 * 「請求データ取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindClaim() throws Exception {
		// 請求データ取得処理。
		// 請求データ取得用のWHERE句を作成する。
		// WHERE句
		// (PATIENT_ID = this.patientId)
		// AND (TARGET_DATE = this.targetDate)
		// AND (PROVIDER_ID = this.providerId)
		// AND (CLAIM_STYLE_TYPE = this.claimStyleType)
		String whereString = "(PATIENT_ID = " + String.valueOf(getPatientId()) + ") AND (TARGET_DATE = '" + VRDateParser.format(getTargetDate(), "yyyy-MM-dd") + "') AND (PROVIDER_ID = '" + String.valueOf(getProviderId()) + "') AND (CLAIM_STYLE_TYPE = " + String.valueOf(getClaimStyleType()) + ")" + " AND (INSURER_ID = '" + getInsurerID() + "')";

		// 請求データを取得し、this.claimListに格納する。
		// getClaimDetailCustom(String(WHERE句));
		VRList claimDetailCustomList = QkanCommon.getClaimDetailCustom(getDBManager(), getClaimDate(), whereString);
		if (!(claimDetailCustomList == null)) {
			setClaimList(claimDetailCustomList);

			setWindowMap((VRMap) getClaimList().getData(0));

			// 画面表示用にデータを編集する。
			doEditDataForDisplay();
		}

		getInfos().setSource(getWindowMap());

		// 画面に展開する。
		getInfos().bindSource();

		// パッシブチェック用に退避する。
		getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), getClaimList());

	}

	/**
	 * 「表示用に編集」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doEditDataForDisplay() throws Exception {
		// 請求データの編集処理。
		// this.claimListの最初のレコードを画面表示用に編集する。

		// 取得した値の1301141（減額）に値が入っているなら
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301141"))) {
			setState_REDUCTION_ENABLE_TRUE();
		} else {
			setState_REDUCTION_ENABLE_FALSE();
		}

		// 以下のBindpathに関してはDBからnullの取得が可能性としてありえる事を前提に空文字に置換する。
		// 1301003 県番
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301003"))) {
			getWindowMap().setData("1301003", "");
		}
		// 1301004 ステーションコード
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301004"))) {
			getWindowMap().setData("1301004", "");
		}
		// 1301019 氏名
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301019"))) {
			getWindowMap().setData("1301019", "");
		}
		// 1301022 職務上の事由
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301022"))) {
			getWindowMap().setData("1301022", "");
		}
		// 1301023 特記事項
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301023"))) {
			getWindowMap().setData("1301023", "");
		}
		// 1301016 保険者番号
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301016"))) {
			getWindowMap().setData("1301016", "");
		}
		// 1301018 記号番号
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301018"))) {
			getWindowMap().setData("1301018", "");
		}
		// 1301024 訪問看護ステーション
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301024"))) {
			getWindowMap().setData("1301024", "");
		}
		// 1301005 市町村番号
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301005"))) {
			getWindowMap().setData("1301005", "");
		}
		// 1301006 老人受給者番号
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301006"))) {
			getWindowMap().setData("1301006", "");
		}
		// 1301007 公費負担者番号①
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301007"))) {
			getWindowMap().setData("1301007", "");
		}
		// 1301008 公費受給者番号①
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301008"))) {
			getWindowMap().setData("1301008", "");
		}
		// 1301009 公費負担者番号②
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301009"))) {
			getWindowMap().setData("1301009", "");
		}
		// 1301010 公費受給者番号②
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301010"))) {
			getWindowMap().setData("1301010", "");
		}

		// 日付１
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301104"))) {
			getWindowMap().setData("1301104", new Integer(0));
		}
		// 日付２
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301105"))) {
			getWindowMap().setData("1301105", new Integer(0));
		}
		// 日付３
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301106"))) {
			getWindowMap().setData("1301106", new Integer(0));
		}
		// 日付４
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301107"))) {
			getWindowMap().setData("1301107", new Integer(0));
		}
		// 日付５
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301108"))) {
			getWindowMap().setData("1301108", new Integer(0));
		}
		// 日付６
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301109"))) {
			getWindowMap().setData("1301109", new Integer(0));
		}
		// 日付７
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301110"))) {
			getWindowMap().setData("1301110", new Integer(0));
		}
		// 日付８
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301111"))) {
			getWindowMap().setData("1301111", new Integer(0));
		}
		// 日付９
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301112"))) {
			getWindowMap().setData("1301112", new Integer(0));
		}
		// 日付１０
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301113"))) {
			getWindowMap().setData("1301113", new Integer(0));
		}
		// 日付１１
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301114"))) {
			getWindowMap().setData("1301114", new Integer(0));
		}
		// 日付１２
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301115"))) {
			getWindowMap().setData("1301115", new Integer(0));
		}
		// 日付１３
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301116"))) {
			getWindowMap().setData("1301116", new Integer(0));
		}
		// 日付１４
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301117"))) {
			getWindowMap().setData("1301117", new Integer(0));
		}
		// 日付１５
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301118"))) {
			getWindowMap().setData("1301118", new Integer(0));
		}
		// 日付１６
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301119"))) {
			getWindowMap().setData("1301119", new Integer(0));
		}
		// 日付１７
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301120"))) {
			getWindowMap().setData("1301120", new Integer(0));
		}
		// 日付１８
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301121"))) {
			getWindowMap().setData("1301121", new Integer(0));
		}
		// 日付１９
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301122"))) {
			getWindowMap().setData("1301122", new Integer(0));
		}
		// 日付２０
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301123"))) {
			getWindowMap().setData("1301123", new Integer(0));
		}
		// 日付２１
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301124"))) {
			getWindowMap().setData("1301124", new Integer(0));
		}
		// 日付２２
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301125"))) {
			getWindowMap().setData("1301125", new Integer(0));
		}
		// 日付２３
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301126"))) {
			getWindowMap().setData("1301126", new Integer(0));
		}
		// 日付２４
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301127"))) {
			getWindowMap().setData("1301127", new Integer(0));
		}
		// 日付２５
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301128"))) {
			getWindowMap().setData("1301128", new Integer(0));
		}
		// 日付２６
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301129"))) {
			getWindowMap().setData("1301129", new Integer(0));
		}
		// 日付２７
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301130"))) {
			getWindowMap().setData("1301130", new Integer(0));
		}
		// 日付２８
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301131"))) {
			getWindowMap().setData("1301131", new Integer(0));
		}
		// 日付２９
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301132"))) {
			getWindowMap().setData("1301132", new Integer(0));
		}
		// 日付３０
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301133"))) {
			getWindowMap().setData("1301133", new Integer(0));
		}
		// 日付３１
		if (ACTextUtilities.isNullText(getWindowMap().getData("1301134"))) {
			getWindowMap().setData("1301134", new Integer(0));
		}

		// ・性別
		// KEY：1301020の値が1の場合

		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301020"))) {
			if (Male.equals(getWindowMap().getData("1301020"))) {
				// レコードに以下のKEY/VALUEを設定する。
				// ・KEY：SEX VALUE："男"
				getWindowMap().setData("SEX", "男");
			} else if (feMale.equals(getWindowMap().getData("1301020"))) {
				// KEY：1301020の値が2の場合
				// レコードに以下のKEY/VALUEを設定する。
				// ・KEY：SEX VALUE："女"
				getWindowMap().setData("SEX", "女");
			} else {
				// 万が一設定されていなかった場合
				getWindowMap().setData("SEX", "");
			}
		}
		// ・生年月日
		// KEY：1301021の値を和年月日型に変換し、レコードに以下のKEY/VALUEを設定する。
		// ・KEY：BIRTH_DAY VALUE：和年月日型に変換した値
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301021"))) {
			getWindowMap().setData("BIRTH_DAY", VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("1301021")), "gggee年MM月dd日"));
		}
		// ・訪問終了年月日、終了時刻
		// KEY：1301095の値から年月日と時刻を取り出し、レコードに以下のKEY/VALUEを設定する。
		// ・KEY：HOMON_END_DATE VALUE：年月日
		// ・KEY：HOMON_END_TIME VALUE：時刻 ※時分型
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301095"))) {
			getWindowMap().setData("HOMON_END_DATE", VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("1301095")), "gggee年MM月dd日"));
			getWindowMap().setData("HOMON_END_TIME", VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("1301095")), "HH:mm"));
		}
		// ・死亡年月日、死亡時刻
		// KEY：1301101の値から年月日と時刻を取り出し、レコードに以下のKEY/VALUEを設定する。
		// ・KEY：DIE_DATE VALUE：年月日
		// ・KEY：DIE_TIME VALUE：時刻 ※時分型
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301101"))) {
			getWindowMap().setData("DIE_DATE", VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("1301101")), "ggggee年MM月dd日"));
			getWindowMap().setData("DIE_TIME", VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("1301101")), "HH:mm"));
		}

		int type = 0;
		// 1-社保 2-国保 3-公費
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301011"))) {
			type = ACCastUtilities.toInt(getWindowMap().getData("1301011"), 0);
			switch (type) {
				case 1:
					getWindowMap().setData("INS_TYPE1", "社保");
					break;

				case 2:
					getWindowMap().setData("INS_TYPE1", "国保");
					break;

				case 3:
					getWindowMap().setData("INS_TYPE1", "公費");
					break;
				default:
					break;
			}
		}

		// 1-老人 2-退職
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301012"))) {
			type = ACCastUtilities.toInt(getWindowMap().getData("1301012"), 0);
			switch (type) {
				case 1:
					getWindowMap().setData("INS_TYPE2", "老人");
					break;

				case 2:
					getWindowMap().setData("INS_TYPE2", "退職");
					break;

				default:
					break;
			}
		}
		// 1-単独 2-２併 3-３併
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301013"))) {
			type = ACCastUtilities.toInt(getWindowMap().getData("1301013"), 0);
			switch (type) {
				case 1:
					getWindowMap().setData("INS_TYPE3", "単独");
					break;

				case 2:
					getWindowMap().setData("INS_TYPE3", "２併");
					break;

				case 3:
					getWindowMap().setData("INS_TYPE3", "３併");
					break;

				default:
					break;
			}
		}

		// 1-本人 2-三歳 3-家族
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301014"))) {
			type = ACCastUtilities.toInt(getWindowMap().getData("1301014"), 0);
			switch (type) {
				case 1:
					getWindowMap().setData("INS_TYPE4", "本人");
					break;

				case 2:
					getWindowMap().setData("INS_TYPE4", "三歳");
					break;

				case 3:
					getWindowMap().setData("INS_TYPE4", "家族");
					break;

				default:
					break;
			}
		}

		// 1-高齢９ 2-高齢８ 3-高齢７
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301015"))) {
			type = ACCastUtilities.toInt(getWindowMap().getData("1301015"), 0);
			switch (type) {
				case 1:
					getWindowMap().setData("INS_TYPE5", "高齢９");
					break;

				case 2:
					getWindowMap().setData("INS_TYPE5", "高齢８");
					break;

                case 3:
                    getWindowMap().setData("INS_TYPE5", "高齢７");
                    break;

				default:
					break;
			}
		}

		// 1301017 --> BENEFIT_RATE
		// ・KEY：BENEFIT_RATE
		// CONTENT_KEY=1, CONTENT=10
		// CONTENT_KEY=2, CONTENT=9
		// CONTENT_KEY=3, CONTENT=8
		// CONTENT_KEY=4, CONTENT=7
		if (!ACTextUtilities.isNullText(getWindowMap().getData("1301017"))) {
			type = ACCastUtilities.toInt(getWindowMap().getData("1301017"), 0);
			switch (type) {
				case 1:
					getWindowMap().setData("BENEFIT_RATE", "10");
					break;

				case 2:
					getWindowMap().setData("BENEFIT_RATE", "9");
					break;

				case 3:
					getWindowMap().setData("BENEFIT_RATE", "8");
					break;

				case 4:
					getWindowMap().setData("BENEFIT_RATE", "7");
					break;

				default:
					break;
			}
		}
	}

	/**
	 * 「保存処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doSave() throws Exception {
		// 保存処理。
		try {
			// トランザクションを開始する。
			getDBManager().beginTransaction();
			// パッシブタスクをクリアする。
			getPassiveChecker().clearPassiveTask();

			// 全件削除用のパッシブチェックタスクを登録する。
			getPassiveChecker().addPassiveDeleteTask(getPASSIVE_CHECK_KEY());

			// パッシブチェックを行う。
			if (getPassiveChecker().passiveCheck(getDBManager())) {
				// パッシブエラーがない場合

				// 画面のデータを取得する。
				getInfos().setSource(getWindowMap());
				getInfos().applySource();

				// DB更新用にデータを編集する。
				doEditDataForUpdate();

				// 請求データを更新するためのWHERE句を作成する。
				// WHERE句
				// (PATIENT_ID = this.patientId)
				// AND (TARGET_DATE = this.targetDate)
				// AND (PROVIDER_ID = this.providerId)
				// AND (CLAIM_STYLE_TYPE = this.claimStyleType)

				String whereString = "(PATIENT_ID = " + getPatientId() + ") AND (TARGET_DATE = '" + VRDateParser.format(getTargetDate(), "yyyy-MM-dd") + "') AND (PROVIDER_ID = '" + getProviderId() + "') AND (CLAIM_STYLE_TYPE = " + getClaimStyleType() + ")";

				// 請求データを更新する。
				// updateClaimDetailCustom(DBManager, claimList,
				// String(WHERE句));
				// QkanCommon.updateClaimDetailCustom()

				QkanCommon.updateClaimDetailCustom(getDBManager(), getClaimList(), getTargetDate(), whereString);

				// 更新に成功した場合
				// DB処理をコミットする。
				getDBManager().commitTransaction();

			} else {
				// パッシブエラーが発生した場合
				// エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
				// ・メッセージID：ERROR_OF_PASSIVE_CHECK_ON_UPDATE
				// （終了）
				getDBManager().rollbackTransaction();
				return false;
			}

		} catch (Exception ex) {
			// 更新に失敗した場合
			// DB処理をロールバックする。
			getDBManager().rollbackTransaction();
			// 例外を投げる。
			// （終了）
			throw ex;
		}

		// 最新の請求データを取得し、パッシブチェック用に退避する。
		doFindClaim();
		return true;
	}

	/**
	 * 「更新用に編集」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doEditDataForUpdate() throws Exception {
		// 請求データの編集処理。
		// ・訪問終了年月日、終了時刻
		// レコードより、下記のKEYの値を取得する。
		// ・KEY：HOMON_END_DATE
		// ・KEY：HOMON_END_TIME
		// 取得した訪問終了年月日をString型に変換し、半角スペースを挟んで終了時刻と連結する。
		if (!ACTextUtilities.isNullText(getWindowMap().getData("HOMON_END_DATE"))) {
			if (!ACTextUtilities.isNullText(getWindowMap().getData("HOMON_END_TIME"))) {
				String endDate = VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("HOMON_END_DATE")), "yyyy-MM-dd ");
				String endTime = VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("HOMON_END_TIME")), "HH:mm");
				String houmonEndDateAndTime = endDate + endTime;
				// 連結したデータをDate型に変換し、レコードに以下のKEY/VALUEで設定する。
				// ・KEY：1301095 VALUE：連結したデータ
				getWindowMap().setData("1301095", houmonEndDateAndTime);
			}
		}

		// ・死亡年月日、死亡時刻
		// レコードより、下記のKEYの値を取得する。
		// ・KEY：DIE_DATE
		// ・KEY：DIE_TIME
		// 取得した死亡年月日をString型に変換し、半角スペースを挟んで死亡時刻と連結する。
		if (!ACTextUtilities.isNullText(getWindowMap().getData("DIE_DATE"))) {
			if (!ACTextUtilities.isNullText(getWindowMap().getData("DIE_TIME"))) {
				String dieDate = VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("DIE_DATE")), "yyyy-MM-dd ");
				String dieTime = VRDateParser.format(ACCastUtilities.toDate(getWindowMap().getData("DIE_TIME")), "HH:mm");
				String dieDateAndTime = dieDate + dieTime;
				// 連結したデータをDate型に変換し、レコードに以下のKEY/VALUEで設定する。
				// ・KEY：1301101 VALUE：連結したデータ
				getWindowMap().setData("1301101", dieDateAndTime);
			}
		}

		// ・減額（割）/減額（円）
		// 減額ラジオグループのEｎａｂｌｅがFalseの場合
		if (!getVisitCareDetailedReductionRadio().isEnabled()) {
			// 減額ラジオグループが選択されている場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：1301142 VALUE：0
			getWindowMap().setData("1301142", new Integer(0));
		}

		// ・免除/支払猶予
		// 状態ラジオグループのEnableがFalseの場合
		if (!getVisitCareDetailedStateRadio().isEnabled()) {
			// 状態ラジオグループが選択されている場合
			// レコードに以下のKEY/VALUEで設定する。
			// ・KEY：1301143 VALUE：0
			getWindowMap().setData("1301143", new Integer(0));
		}

		// ・性別
		// KEY：1301020の値が1の場合
		if (getWindowMap().getData("1301020").equals(Male)) {
			// レコードに以下のKEY/VALUEを設定する。
			// ・KEY：SEX VALUE："男"
			getWindowMap().setData("SEX", "男");
		}

		if (getWindowMap().getData("1301020").equals(feMale)) {
			// レコードに以下のKEY/VALUEを設定する。
			// ・KEY：SEX VALUE："男"
			getWindowMap().setData("SEX", "男");
		}

	}

	/**
	 * 「請求金額の合計」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doCalcTotal() throws Exception {
		// 以下のフィールドに入力されている値の合計を計算する。
		// ・visitCareDetailedMoneyText2
		// ・visitCareDetailedMoneyText6
		// ・visitCareDetailedMoneyText10
		// ・visitCareDetailedMoneyText14
		// ・visitCareDetailedMoneyText18
		// ・visitCareDetailedMoneyText52
		// ・visitCareDetailedMoneyText22
		// ・visitCareDetailedMoneyText26
		// ・visitCareDetailedMoneyText30
		// ・visitCareDetailedMoneyText36
		// ・visitCareDetailedMoneyText39
		// ・visitCareDetailedMoneyText42
		// ・visitCareDetailedMoneyText45
		// ・visitCareDetailedMoneyText48
		// 算出した合計金額をvisitCareDetailedExpenseMoneyText1に表示する。

		ACTextField sumTextFieldArray[] = { getVisitCareDetailedMoneyText2(), getVisitCareDetailedMoneyText6(), getVisitCareDetailedMoneyText10(), getVisitCareDetailedMoneyText14(), getVisitCareDetailedMoneyText18(), getVisitCareDetailedMoneyText52(), getVisitCareDetailedMoneyText22(), getVisitCareDetailedMoneyText26(), getVisitCareDetailedMoneyText30(), getVisitCareDetailedMoneyText36(), getVisitCareDetailedMoneyText39(), getVisitCareDetailedMoneyText42(), getVisitCareDetailedMoneyText45(),
				getVisitCareDetailedMoneyText48(), getVisitCareDetailedMoneyText56(), getVisitCareDetailedMoneyText61() };

		sumMachine(sumTextFieldArray, getVisitCareDetailedExpenseMoneyText1(), getVisitCareDetailedOneshareText());
	}

	/**
	 * 「公費1請求金額の合計」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doCalcTotalKohi1() throws Exception {
		// 以下のフィールドに入力されている値の合計を計算する。
		// ・visitCareDetailedMoneyText3
		// ・visitCareDetailedMoneyText7
		// ・visitCareDetailedMoneyText11
		// ・visitCareDetailedMoneyText15
		// ・visitCareDetailedMoneyText19
		// ・visitCareDetailedMoneyText53
		// ・visitCareDetailedMoneyText23
		// ・visitCareDetailedMoneyText27
		// ・visitCareDetailedMoneyText31
		// ・visitCareDetailedMoneyText37
		// ・visitCareDetailedMoneyText40
		// ・visitCareDetailedMoneyText43
		// ・visitCareDetailedMoneyText46
		// ・visitCareDetailedMoneyText49
		// 算出した合計金額をvisitCareDetailedExpenseMoneyText2に表示する。

		ACTextField sumTextFieldArray[] = { getVisitCareDetailedMoneyText3(), getVisitCareDetailedMoneyText7(), getVisitCareDetailedMoneyText11(), getVisitCareDetailedMoneyText15(), getVisitCareDetailedMoneyText19(), getVisitCareDetailedMoneyText53(), getVisitCareDetailedMoneyText23(), getVisitCareDetailedMoneyText27(), getVisitCareDetailedMoneyText31(), getVisitCareDetailedMoneyText37(), getVisitCareDetailedMoneyText40(), getVisitCareDetailedMoneyText43(), getVisitCareDetailedMoneyText46(),
				getVisitCareDetailedMoneyText49(), getVisitCareDetailedMoneyText57(), getVisitCareDetailedMoneyText62() };
		sumMachine(sumTextFieldArray, getVisitCareDetailedExpenseMoneyText2(), getVisitCareDetailedOneshareTex2());
	}

	/**
	 * 「公費2請求金額の合計」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doCalcTotalKohi2() throws Exception {
		// 以下のフィールドに入力されている値の合計を計算する。
		// ・visitCareDetailedMoneyText4
		// ・visitCareDetailedMoneyText8
		// ・visitCareDetailedMoneyText12
		// ・visitCareDetailedMoneyText16
		// ・visitCareDetailedMoneyText20
		// ・visitCareDetailedMoneyText54
		// ・visitCareDetailedMoneyText24
		// ・visitCareDetailedMoneyText28
		// ・visitCareDetailedMoneyText32
		// ・visitCareDetailedMoneyText38
		// ・visitCareDetailedMoneyText41
		// ・visitCareDetailedMoneyText44
		// ・visitCareDetailedMoneyText47
		// ・visitCareDetailedMoneyText50
		// 算出した合計金額をvisitCareDetailedExpenseMoneyText3に表示する。

		ACTextField sumTextFieldArray[] = { getVisitCareDetailedMoneyText4(), getVisitCareDetailedMoneyText8(), getVisitCareDetailedMoneyText12(), getVisitCareDetailedMoneyText16(), getVisitCareDetailedMoneyText20(), getVisitCareDetailedMoneyText54(), getVisitCareDetailedMoneyText24(), getVisitCareDetailedMoneyText28(), getVisitCareDetailedMoneyText32(), getVisitCareDetailedMoneyText38(), getVisitCareDetailedMoneyText41(), getVisitCareDetailedMoneyText44(), getVisitCareDetailedMoneyText47(),
				getVisitCareDetailedMoneyText50(), getVisitCareDetailedMoneyText58(), getVisitCareDetailedMoneyText63() };

		sumMachine(sumTextFieldArray, getVisitCareDetailedExpenseMoneyText3(), getVisitCareDetailedOneshareTex3());
	}

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean isValidInput() throws Exception {
		// 入力チェック処理。
		// 以下の日付が入力されている場合、存在しない日付が入力されていないかチェックする。

		// ・指示期間開始（visitCareDetailedInstructDateText1）
		// ※エラーの場合、String：msgParamを宣言し、"指示期間開始日の"を代入する。
		if (checkErrorDate(getVisitCareDetailedInstructDateText1(), "指示期間開始日の")) {
			return false;
		}
		// ・指示期間終了（visitCareDetailedInstructDateText2）
		// ※エラーの場合、String：msgParamを宣言し、"指示期間終了日の"を代入する。
		if (checkErrorDate(getVisitCareDetailedInstructDateText2(), "指示期間終了日の")) {
			return false;
		}
		// ・特別指示期間開始（visitCareDetailedSpecialInstructDateText1）
		// ※エラーの場合、String：msgParamを宣言し、"特別指示期間開始日の"を代入する。
		if (checkErrorDate(getVisitCareDetailedSpecialInstructDateText1(), "特別指示期間開始日の")) {
			return false;
		}
		// ・特別指示期間終了（visitCareDetailedSpecialInstructDateText2）
		// ※エラーの場合、String：msgParamを宣言し、"特別指示期間終了日の"を代入する。
		if (checkErrorDate(getVisitCareDetailedSpecialInstructDateText2(), "特別指示期間終了日の")) {
			return false;
		}
		// ・訪問開始年月日（visitStart）
		// ※エラーの場合、String：msgParamを宣言し、"訪問開始年月日の"を代入する。
		if (checkErrorDate(getVisitStart(), "訪問開始年月日の")) {
			return false;
		}
		// ・訪問終了年月日（visitEnd）
		// ※エラーの場合、String：msgParamを宣言し、"訪問終了年月日の"を代入する。
		if (checkErrorDate(getVisitEnd(), "訪問終了年月日の")) {
			return false;
		}
		// ・死亡年月日（dieDate）
		// ※エラーの場合、String：msgParamを宣言し、"死亡年月日の"を代入する。
		if (checkErrorDate(getDieDate(), "死亡年月日の")) {
			return false;
		}
		// ・主治医への直近報告年月日（mainDoctorInfoDate）
		// ※エラーの場合、String：msgParamを宣言し、"主治医への直近報告年月日の"を代入する。
		if (checkErrorDate(getMainDoctorInfoDate(), "主治医への直近報告年月日の")) {
			return false;
		}

		// 以下の日付が入力されている場合、未来の日付が入力されていないかチェックする。
		// ・指示期間開始（visitCareDetailedInstructDateText1）
		// ※エラーの場合、String：msgParamを宣言し、"指示期間開始日に"を代入する。
		// 未来日のチェックを廃止6月8日
		// if (checkFutureDate(getVisitCareDetailedInstructDateText1(), "指示期間開始日に")) {
		// return false;
		// }

		// ・特別指示期間開始（visitCareDetailedSpecialInstructDateText1）
		// ※エラーの場合、String：msgParamを宣言し、"特別指示期間開始日に"を代入する。
		// 未来日のチェックを廃止6月8日
		// if (checkFutureDate(getVisitCareDetailedSpecialInstructDateText1(), "特別指示期間開始日に")) {
		// return false;
		// }

		// ・訪問開始年月日（visitStart）
		// ※エラーの場合、String：msgParamを宣言し、"訪問開始年月日に"を代入する。
		// 未来日のチェックを廃止6月8日
		// if (checkFutureDate(getVisitStart(), "訪問開始年月日に")) {
		// return false;
		// }

		// ・死亡年月日（dieDate）
		// ※エラーの場合、String：msgParamを宣言し、"死亡年月日に"を代入する。
		// 未来日のチェックを廃止6月8日
		// if (checkFutureDate(getDieDate(), "死亡年月日に")) {
		// return false;
		// }

		// ・主治医への直近報告年月日（mainDoctorInfoDate）
		// ※エラーの場合、String：msgParamを宣言し、"主治医への直近報告年月日に"を代入する。
		// 未来日のチェックを廃止6月8日
		// if (checkFutureDate(getMainDoctorInfoDate(), "主治医への直近報告年月日に")) {
		// return false;
		// }

		// 以下の日付が入力されている場合、開始と終了の前後関係をチェックする。
		// ・指示期間開始（visitCareDetailedInstructDateText1）～指示期間終了（visitCareDetailedInstructDateText2）
		// ※エラーの場合、String：msgParam1を宣言し、"指示期間は"を代入する。
		// ※エラーの場合、String：msgParam2を宣言し、"開始日"を代入する。
		// ※エラーの場合、String：msgParam3を宣言し、"終了日"を代入する。
		if (checkRelationDate(getVisitCareDetailedInstructDateText1(), getVisitCareDetailedInstructDateText2(), "指示期間は", "開始日", "終了日")) {
			return false;
		}
		// ・特別指示期間開始（visitCareDetailedSpecialInstructDateText1）～特別指示期間終了（visitCareDetailedSpecialInstructDateText2）
		// ※エラーの場合、String：msgParam1を宣言し、"特別指示期間は"を代入する。
		// ※エラーの場合、String：msgParam2を宣言し、"開始日"を代入する。
		// ※エラーの場合、String：msgParam3を宣言し、"終了日"を代入する。
		if (checkRelationDate(getVisitCareDetailedSpecialInstructDateText1(), getVisitCareDetailedSpecialInstructDateText2(), "特別指示期間は", "開始日", "終了日")) {
			return false;
		}
		// ・訪問開始年月日（visitStart）～訪問終了年月日（visitEnd）
		// ※エラーの場合、String：msgParam1を宣言し、"訪問期間は"を代入する。
		// ※エラーの場合、String：msgParam2を宣言し、"開始日"を代入する。
		// ※エラーの場合、String：msgParam3を宣言し、"終了日"を代入する。
		if (checkRelationDate(getVisitStart(), getVisitEnd(), "訪問期間は", "開始日", "終了日")) {
			return false;
		}

		// 以下の時刻が入力されている場合、存在しない時刻が入力されていないかチェックする。
		// ・訪問終了時刻（visitEndTime）
		// ※エラーの場合、String：msgParamを宣言し、"訪問終了の"を代入する。
		if (checkErrorTime(getVisitEndTime(), "訪問終了の")) {
			return false;
		}

		// ・死亡時刻（dieTime）
		// ※エラーの場合、String：msgParamを宣言し、"死亡の"を代入する。
		if (checkErrorTime(getDieTime(), "死亡の")) {
			return false;
		}

		return true;
	}

	/**
	 * 「first * second = output」に関する処理を行ないます。 firstとsecondを掛けた値を、第3引数に指定されたACTextFieldオブジェクトに値を反映します。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void multiPlication(ACTextField first, ACTextField second, ACTextField output) throws Exception {
		// firstとsecondがnullで無いか値をチェックする
		if (!(ACTextUtilities.isNullText(first.getText()))) {
			if (!(ACTextUtilities.isNullText(second.getText()))) {
				long total = ACCastUtilities.toLong(first.getText()) * ACCastUtilities.toLong(second.getText());
				output.setText(ACCastUtilities.toString(total));
			}
		}
	}

	/**
	 * 「(second * third) + first = output の計算」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void multiPlication(ACTextField first, ACTextField second, ACTextField third, ACTextField output) throws Exception {
		long total = 0;
		if (!(ACTextUtilities.isNullText(first.getText()))) {
			if (!(ACTextUtilities.isNullText(second.getText()))) {
				if (!(ACTextUtilities.isNullText(third.getText()))) {
					total = ACCastUtilities.toLong(second.getText()) * ACCastUtilities.toLong(third.getText()) + ACCastUtilities.toLong(first.getText());
				}
			}
		} else {
			// FirstがNULLもしくは空文字の場合はsecond+thirdのみを演算して返却する
			if (!(ACTextUtilities.isNullText(second.getText()))) {
				if (!(ACTextUtilities.isNullText(third.getText()))) {
					total = ACCastUtilities.toLong(second.getText()) * ACCastUtilities.toLong(third.getText());
				}
			}
		}
		output.setText(ACCastUtilities.toString(total));
	}

	/**
	 * 「合計」に関する処理を行ないます。 ACTextFieldのオブジェクト配列の値をすべて合算して、outputTextFieldに返します。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void sumMachine(ACTextField sumArray[], ACTextField output, ACTextField oneShare) throws Exception {
		// firstとsecondがnullで無いか値をチェックする
		// null チェックを行いながら、合計を計算していく
		long total = 0;

		for (int i = 0; i < sumArray.length; i++) {
			if (!ACTextUtilities.isNullText(sumArray[i].getText())) {
				total = total + ACCastUtilities.toLong(sumArray[i].getText());
			}
		}
		// 合計欄に値を返す
		output.setText(ACCastUtilities.toString(total));

		if (!ACTextUtilities.isNullText(getVisitCareDetailedRatio().getText())) {
			// 給付金額のうちの負担金額計算を行う
			// 以下の計算を行う。 ※10円未満四捨五入
			// '保険請求円' × （1 - '給付割合'/10） = '負担金額'
			double patientPaymentReal = (total * (1.0 - (ACCastUtilities.toDouble(getVisitCareDetailedRatio().getText()) / 10)));

			// 小数点以下を四捨五入
			long patientPaymentCast = Math.round(patientPaymentReal);

			// 整数1桁で四捨五入を行う
			long patientPayment = ((patientPaymentCast + 5) / 10) * 10;

			// 値を返却する
			oneShare.setText(ACCastUtilities.toString(patientPayment));
		}
	}

	/**
	 * 「妥当な日付の入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkErrorDate(QkanDateTextField dateParam, String errMsg) throws Exception {
		if (!ACTextUtilities.isNullText(dateParam.getText())) {
			if (!dateParam.isValidDate()) {
				// 不正な値の場合
				// インスタンスにフォーカスをあてる。
				dateParam.requestFocus();
				// エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE(errMsg);
				// ・メッセージID：ERROR_OF_WRONG_DATE
				// （終了）
				return true;
			}
		}
		return false;
	}

	/**
	 * 「妥当な時刻の入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkErrorTime(ACTimeTextField timeParam, String errMsg) throws Exception {
		if (!ACTextUtilities.isNullText(timeParam.getText())) {
			if (!timeParam.isValidDate()) {
				// 不正な値の場合
				// インスタンスにフォーカスをあてる。
				timeParam.requestFocus();
				// エラーメッセージを表示する。
				QkanMessageList.getInstance().QP006_ERROR_OF_WRONG_TIME(errMsg);
				// ・メッセージID：ERROR_OF_WRONG_TIME
				// （終了）
				return true;
			}
		}
		return false;
	}

	/**
	 * 「未来日付の入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkFutureDate(QkanDateTextField dateParam, String errMsg) throws Exception {
		if (!ACTextUtilities.isNullText(dateParam.getText())) {
			Date nowDate = QkanSystemInformation.getInstance().getSystemDate();
			if (ACDateUtilities.compareOnDay(nowDate, ACCastUtilities.toDate(dateParam.getText())) < 0) {
				// 不正な値の場合
				// インスタンスにフォーカスをあてる。
				dateParam.requestFocus();
				// エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_FUTURE_DATE(errMsg);
				// ・メッセージID：ERROR_OF_FUTURE_DATE
				// （終了）
				return true;
			}
		}
		return false;
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
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 「空文字チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkEmpty(ACTextField arg1, ACTextField arg2) throws Exception {
		if (ACTextUtilities.isNullText(arg1.getText()) || ACTextUtilities.isNullText(arg2.getText())) {
			return true;
		}
		return false;
	}

	/**
	 * 「空文字チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkEmpty(ACTextField arg1, ACTextField arg2, ACTextField arg3) throws Exception {
		if (ACTextUtilities.isNullText(arg1.getText()) || ACTextUtilities.isNullText(arg2.getText()) || ACTextUtilities.isNullText(arg3.getText())) {
			return true;
		}
		return false;
	}
    
      protected void addVisitCareDetailedReductionContena() {
        String osName = System.getProperty("os.name");
        if ((osName != null) && (osName.indexOf("Mac") >= 0)) {
            //Macの場合、段組を調整して画面内に収める
            getVisitCareDetailedReductionContena().add(
                    getVisitCareDetailedReductionContainer(),
                    VRLayout.FLOW_RETURN);

            getVisitCareDetailedReductionContena().add(
                    getVisitCareDetailedReductionRadioContainer(),
                    VRLayout.FLOW);

            getVisitCareDetailedReductionContena().add(
                    getVisitCareDetailedStateRadioContainer(), VRLayout.FLOW);
        } else {
            super.addVisitCareDetailedReductionContena();
        }

    }
      protected void addVisitCareDetailedContentLeftCenter1() {
        String osName = System.getProperty("os.name");
        if ((osName != null) && (osName.indexOf("Mac") >= 0)) {
            //Macの場合、段組を調整して画面内に収める

            getVisitCareDetailedContentLeftCenter1().add(
                    getVisitCareDetailedNameContainer(), VRLayout.FLOW_RETURN);

            getVisitCareDetailedContentLeftCenter1().add(
                    getVisitCareDetailedSexContenaContainer(),
                    VRLayout.FLOW_INSETLINE);

            getVisitCareDetailedContentLeftCenter1().add(
                    getVisitCareDetailedBirthContainer(),
                    VRLayout.FLOW_INSETLINE_RETURN);

            getVisitCareDetailedContentLeftCenter1().add(
                    getVisitCareDetailedOfficialReasonContainer(),
                    VRLayout.FLOW_INSETLINE_RETURN);
        } else {
            super.addVisitCareDetailedContentLeftCenter1();
        }

    }
      
//      protected void addRealityDate() {
//        String osName = System.getProperty("os.name");
//        if ((osName != null) && (osName.indexOf("Mac") >= 0)) {
//            getRealityDate()
//                    .add(getInsuranceContena(), VRLayout.FLOW_INSETLINE);
//
//            getRealityDate().add(getPublicExpenseContena(),
//                    VRLayout.FLOW_INSETLINE_RETURN);
//
//            getRealityDate().add(getPublicExpense2Contena(),
//                    VRLayout.FLOW_INSETLINE_RETURN);
//        } else {
//            super.addRealityDate();
//        }
//    }
}
