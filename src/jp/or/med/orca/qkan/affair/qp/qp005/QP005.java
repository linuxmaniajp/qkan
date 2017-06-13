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
 * 作成日: 2006/02/13  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績データ作成 (P)
 * プロセス 確認・修正 (005)
 * プログラム 明細書詳細編集 (QP005)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp005;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.im.InputSubset;
import java.text.Format;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewerCustomCell;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001ReTotal;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjTankaNotFoundException;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACCharacterConverter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 明細書詳細編集(QP005)
 */
public class QP005 extends QP005Event {
	/**
	 * コンストラクタです。
	 */
	public QP005() {
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
		VRMap parameters = affair.getParameters();

		// ・patientId KEY：PATIENT_ID
		if (VRBindPathParser.has("PATIENT_ID", parameters)) {
			setPatientId(ACCastUtilities.toInt(parameters.getData("PATIENT_ID")));
		}
		// ・targetDate KEY：TARGET_DATE
		if (VRBindPathParser.has("TARGET_DATE", parameters)) {
			setTargetDate(ACCastUtilities.toDate(parameters.getData("TARGET_DATE")));
		}
		// ・claimDate KEY：CLAIM_DATE
		if (VRBindPathParser.has("CLAIM_DATE", parameters)) {
			setClaimDate(ACCastUtilities.toDate(parameters.getData("CLAIM_DATE")));
		}

		// ・providerId KEY：PROVIDER_ID
		if (VRBindPathParser.has("PROVIDER_ID", parameters)) {
			setProviderId(ACCastUtilities.toString(parameters.getData("PROVIDER_ID")));
		}
		// ・claimStyleType KEY：CLAIM_STYLE_TYPE
		if (VRBindPathParser.has("CLAIM_STYLE_TYPE", parameters)) {
			setClaimStyleType(ACCastUtilities.toInt(parameters.getData("CLAIM_STYLE_TYPE")));
		}
		// ・listIndex KEY：LIST_INDEX
		if (VRBindPathParser.has("LIST_INDEX", parameters)) {
			setListIndex(ACCastUtilities.toInteger(parameters.getData("LIST_INDEX")));
		}
		// ・insuredId KEY：INSURED_ID
		if (VRBindPathParser.has("INSURED_ID", parameters)) {
			setInsuredId(ACCastUtilities.toString(parameters.getData("INSURED_ID")));
		}
		
		switch (getClaimStyleType()){
			case FORMAT_STYLE4:
			case FORMAT_STYLE42:
			case FORMAT_STYLE9:
				break;
				
			//上記様式以外では、特定療養費タブを消去する。
			default:
			    getEtcInfoTabs().remove(getRecuperationInfos());
			    break;
		}

		//[ID:0000429][Shin Fujihara] 2009/07 add start 2009年度対応
		//サービス追加ボタン制御
		switch (getClaimStyleType()){
		case FORMAT_STYLE3:
		case FORMAT_STYLE32:
		case FORMAT_STYLE4:
		case FORMAT_STYLE42:
		case FORMAT_STYLE5:
		case FORMAT_STYLE52:
		case FORMAT_STYLE8:
		case FORMAT_STYLE9:
		case FORMAT_STYLE10:
			break;
		default:
			setState_TYPE9();
			break;
		}
		
		//2009.8.10 暫定的にボタン非表示で、機能を封印する
		getServiceDelButton().setVisible(false);
		getServiceAddButton().setVisible(false);
		//[ID:0000429][Shin Fujihara] 2009/07 add end 2009年度対応
		
		// パッシブチェックのキーを定義する。
		// TABLE：CLAIM
		// キー：CLAIM_ID
		// フォーマット：数値
		// クライアントタイムフィールド：LAST_TIME
		// サーバタイムフィールド：LAST_TIME
		setPASSIVE_CHECK_KEY(new ACPassiveKey("CLAIM", new String[] { "CLAIM_ID" }, new Format[] { null }, "LAST_TIME", "LAST_TIME"));

		// データを取得し、画面に展開する。
		doFind();
		
		//[ID:0000567][Shin Fujihara] 2009/12/10 add begin 2009年度対応
		if (getTableClaimList2().size() < 2) {
			//削除ボタンを使用不可能にする
			setState_TYPE11();
		} else {
			setState_TYPE10();
		}
		//[ID:0000567][Shin Fujihara] 2009/12/10 add end 2009年度対応
		
// 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
		if (getTableClaimList8().size() < 2) {
			//削除ボタンを使用不可能にする
			setState_TYPE13();
		} else {
			setState_TYPE12();
		}
		// H2704以降でなければ、明細情報（住所地特例）タブを表示しない
		//if (!(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2704,
		//        getTargetDate()) < 1)) {
		//	getEtcInfoTabs().remove(getDetailsJushotiTokureiInfos());
		//}
// 2014/12/24 [Yoichiro Kamei] add - end
		
		//[ID:0000429][Shin Fujihara] 2009/07 add begin 2009年度対応
		//スナップショット取得
		doSnap();
		//[ID:0000429][Shin Fujihara] 2009/07 add end 2009年度対応
	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}
		// 最後に保存されてから、画面テーブルのデータが変更されている場合（tableChangeFlgの値が1の場合）
		// 確認メッセージを表示する。
		//[ID:0000429][Shin Fujihara] 2009/07 edit begin 2009年度対応
		//if (getTableChangeFlg() == ON) {
		if (isModified() ) {
		//[ID:0000429][Shin Fujihara] 2009/07 edit end 2009年度対応
			switch(QkanMessageList.getInstance().WARNING_OF_UPDATE_ON_MODIFIED()){
			case ACMessageBox.RESULT_OK:

				// ・メッセージID：WARNING_OF_UPDATE_ON_MODIFIED
				// 「はい」を選択した場合
				// 保存処理を行う。
				if (doSave()) {
					// 保存処理が正常終了した場合
					// 完了メッセージを表示する。
//					QkanMessageList.getInstance().UPDATE_SUCCESSED();
					// ・メッセージID：UPDATE_SUCCESSED
				} else {
					// 保存処理が正常終了しなかった場合
					// 処理を中断する。(終了)
					return false;
				}
				break;
			case ACMessageBox.RESULT_CANCEL:
				// 「はい」「いいえ」以外を選択した場合
				// 処理を中断する（何もしない）。
				return false;
			}
		}
		// 前画面に遷移する。
		// 当画面に「QP002 帳票(様式)・事業所選択」画面から遷移している場合
		// 以下を渡りパラメータとして「QP002 帳票(様式)・事業所選択」画面に遷移する。
		if (ACFrame.getInstance().getBackAffair().getClassName().equals(QP002)) {
			// ・KEY：PATIENT_ID VALUE：patientId
			parameters.setData("PATIENT_ID", ACCastUtilities.toString(getPatientId()));
			// ・KEY：CLAIM_DATE VALUE：claimDate
			parameters.setData("CLAIM_DATE", getClaimDate());
			// ・KEY：LIST_INDEX VALUE：listIndex
			parameters.setData("LIST_INDEX", getListIndex());
		}

		// 当画面に「QP004 明細書基本情報編集」画面から遷移している場合
		// 以下を渡りパラメータとして「QP004 明細書基本情報編集」画面に遷移する。
		if (ACFrame.getInstance().getBackAffair().getClassName().equals(QP004)) {
			// ・KEY：PATIENT_ID VALUE：patientId
			parameters.setData("PATIENT_ID", ACCastUtilities.toString(getPatientId()));
			// ・KEY：TARGET_DATE VALUE：targetDate
			parameters.setData("TARGET_DATE", getTargetDate());
			// ・KEY：CLAIM_DATE VALUE：claimDate
			parameters.setData("CLAIM_DATE", getClaimDate());
			// ・KEY：PROVIDER_ID VALUE：providerId
			parameters.setData("PROVIDER_ID", getProviderId());
			// ・KEY：CLAIM_STYLE_TYPE VALUE：claimStyleType
			parameters.setData("CLAIM_STYLE_TYPE", ACCastUtilities.toString(getClaimStyleType()));
			// ・KEY：LIST_INDEX VALUE：listIndex
			parameters.setData("LIST_INDEX", getListIndex());
			// ・KEY：INSURED_ID VALUE：insuredId
			parameters.setData("INSURED_ID", getInsuredId());
		}
		return true;
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
		// 最後に保存されてから、画面テーブルのデータが変更されていない場合（tableChangeFlgの値が0の場合）
		//[ID:0000429][Shin Fujihara] 2009/07 edit begin 2009年度対応
		//if (getTableChangeFlg() == OFF) {
		if (!isModified()) {
		//[ID:0000429][Shin Fujihara] 2009/07 edit end 2009年度対応
			// システムを終了する。
			return true;
		}
		// 最後に保存されてから、画面テーブルのデータが変更されている場合（tableChangeFlgの値が1の場合）
		//[ID:0000429][Shin Fujihara] 2009/07 delete begin 2009年度対応
		//if (getTableChangeFlg() == ON) {
		//[ID:0000429][Shin Fujihara] 2009/07 delete end 2009年度対応
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
		//[ID:0000429][Shin Fujihara] 2009/07 delete begin 2009年度対応
		/*
		}
		return false;
		*/
		//[ID:0000429][Shin Fujihara] 2009/07 delete end 2009年度対応
	}

	// コンポーネントイベント

	/**
	 * 「更新処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void renewalActionPerformed(ActionEvent e) throws Exception {
		// 確認メッセージを表示する。
		// ・メッセージID：QP005_WARNING_OF_UPDATE
		if (QkanMessageList.getInstance().QP005_WARNING_OF_UPDATE() == ACMessageBox.RESULT_OK) {
			// 「はい」を選択した場合
			// 保存処理を行う。
			if (doSave()) {
				// 保存処理が正常終了した場合
				// 完了メッセージを表示する。
				QkanMessageList.getInstance().UPDATE_SUCCESSED();
				
				//[ID:0000429][Shin Fujihara] 2009/07 add begin 2009年度対応
				//スナップショット再取得
				doSnap();
				//[ID:0000429][Shin Fujihara] 2009/07 add end 2009年度対応
				
				// ・メッセージID：UPDATE_SUCCESSED
			} else {
				// ・メッセージID：UPDATE_SUCCESSED
				// 保存処理が正常終了しなかった場合
				// 処理を中断する。(終了)
			}
		} else {
			// 「キャンセル」を選択した場合
			// 処理を終了する。
		}
	}

	/**
	 * 「データ表示処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void basicInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// 基本情報テーブルで選択されている行のレコードを詳細テーブルに表示する。
		// ・第一引数："BASIC"
		if (getBasicInfoTable().isSelected()) {
			doShowClaimDetail("BASIC");
		}
	}

	/**
	 * 「データ表示処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void detailsInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// 明細情報テーブルで選択されている行のレコードを詳細テーブルに表示する。
		// ・第一引数："DETAIL
		if (getDetailsInfoTable().isSelected()) {
			doShowClaimDetail("DETAIL");
		}
	}

	/**
	 * 「データ表示処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void kyotakuDetailsInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// 居宅介護支援明細情報テーブルで選択されている行のレコードを詳細テーブルに表示する。
		// ・第一引数："KYOTAKU"
		if (getKyotakuDetailsInfoTable().isSelected()) {
			doShowClaimDetail("KYOTAKU");
		}
	}

	/**
	 * 「データ表示処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void particularInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// 特定治療費情報テーブルで選択されている行のレコードを詳細テーブルに表示する。
		// ・第一引数："PARTICULAR"
		if (getParticularInfoTable().isSelected()) {
			doShowClaimDetail("PARTICULAR");
		}
	}

	/**
	 * 「データ表示処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void specialClinicInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// 特定診療費情報テーブルで選択されている行のレコードを詳細テーブルに表示する。
		// ・第一引数："SPECIAL_CLINIC"
		if (getSpecialClinicInfoTable().isSelected()) {
			doShowClaimDetail("SPECIAL_CLINIC");
		}
	}

	/**
	 * 「データ表示処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void totalInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// 集計情報テーブルで選択されている行のレコードを詳細テーブルに表示する。
		// ・第一引数："TOTAL"
		if (getTotalInfoTable().isSelected()) {
			doShowClaimDetail("TOTAL");
		}
	}

	/**
	 * 「データ表示処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void nyushoInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// 特定入所者介護費情報テーブルで選択されている行のレコードを詳細テーブルに表示する。
		if (getNyushoInfoTable().isSelected()) {
			doShowClaimDetail("NYUSHO");
			//[ID:0000429][Shin Fujihara] 2009/07 edit begin 2009年度対応
			setState_TYPE7();
		} else {
			setState_TYPE8();
		}
		//[ID:0000429][Shin Fujihara] 2009/07 edit end 2009年度対応
		// ・第一引数："NYUSHO"
	}

	/**
	 * 「データ表示処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void shahukuInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {

		// 社会福祉法人軽減額情報テーブルで選択されている行のレコードを詳細テーブルに表示する。
		if (getShahukuInfoTable().isSelected()) {
			doShowClaimDetail("SHAHUKU");
		}
		// ・第一引数："SHAHUKU"
	}

	//[H20.5 法改正対応] fujihara add start
	/**
	 * 「データ表示処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
    protected void recuperationInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// 特定療養費情報テーブルで選択されている行のレコードを詳細テーブルに表示する。
		// ・第一引数："RYOYO"
		if (getRecuperationInfoTable().isSelected()) {
			doShowClaimDetail("RYOYO");
		}
    }
    //[H20.5 法改正対応] fujihara add end/
	
 // 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
    protected void detailsJushotiTokureiInfoTableSelectionChanged(ListSelectionEvent e) throws Exception {
		// 明細情報（住所地特例）テーブルで選択されている行のレコードを詳細テーブルに表示する。
		// ・第一引数："DETAIL_JUSHOTI_TOKUREI"
		if (getDetailsJushotiTokureiInfoTable().isSelected()) {
			doShowClaimDetail("DETAIL_JUSHOTI_TOKUREI");
		}
    }
 // 2014/12/24 [Yoichiro Kamei] add - end
    
	/**
	 * 「データ切り替え処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void basicInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
		if (getBasicInfoRevisionCheck().isSelected()) {
			// 基本情報領域（basicInfos）のEnableがtrueの場合
			if (getBasicInfos().isEnabled()) {
				// ※項目名列の設定
				// columnList1NameをbasicInfoRevisionTablecolumn1に設定する。
				getBasicInfoRevisionTablecolumn1().setCustomCells(getColumnList1Name());

				// ※設定値列の設定
				// columnList1ValueをbasicInfoRevisionTablecolumn2に設定する。
				getBasicInfoRevisionTablecolumn2().setCustomCells(getColumnList1Value());
				// ※コメント列の設定
				// columnList1CommentをbasicInfoRevisionTablecolumn3に設定する。
				getBasicInfoRevisionTablecolumn3().setCustomCells(getColumnList1Comment());

				// 基本情報テーブルでレコードが選択されている場合
				if (getBasicInfoTable().isSelected()) {
					// 基本情報テーブルで選択されているレコードを基本情報詳細テーブルに表示する。
					// ・第一引数："BASIC"
					doShowClaimDetail("BASIC");
				}
			}
			getBasicInfoRevisionCheck().setSelected(true);

			// チェックボックスがオフの場合
		} else {
			// 基本情報領域（basicInfos）のEnableがtrueの場合
			if (getBasicInfos().isEnabled()) {
				// ※項目名列の設定
				// columnList1NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をbasicInfoRevisionTablecolumn1に設定する。
				getBasicInfoRevisionTablecolumn1().setCustomCells(getColumnList1NameSimple());

				// ※設定値列の設定
				// columnList1ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をbasicInfoRevisionTablecolumn2に設定する。
				getBasicInfoRevisionTablecolumn2().setCustomCells(getColumnList1ValueSimple());

				// ※コメント列の設定
				// columnList1CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をbasicInfoRevisionTablecolumn3に設定する。
				getBasicInfoRevisionTablecolumn3().setCustomCells(getColumnList1CommentSimple());

				// 基本情報テーブルでレコードが選択されている場合
				if (getBasicInfoTable().isSelected()) {
					// 基本情報テーブルで選択されているレコードを基本情報詳細テーブルに表示する。
					// ・第一引数："BASIC"
					doShowClaimDetail("BASIC");
				}
			}
			getBasicInfoRevisionCheck().setSelected(false);
		}
		getBasicInfoTable().validate();
		getBasicInfoTable().repaint();
	}

	/**
	 * 「データ切り替え処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void detailsInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
		if (getDetailsInfoRevisionCheck().isSelected()) {
			// 明細情報領域（detailsInfos）のEnableがtrueの場合
			if (getDetailsInfos().isEnabled()) {
				// ※項目名列の設定
				// columnList2NameをdetailsInfoRevisionTablecolumn1に設定する。
				getDetailsInfoRevisionTablecolumn1().setCustomCells(getColumnList2Name());
				// ※設定値列の設定
				// columnList2ValueをdetailsInfoRevisionTablecolumn2に設定する。
				getDetailsInfoRevisionTablecolumn2().setCustomCells(getColumnList2Value());
				// ※コメント列の設定
				// columnList2CommentをdetailsInfoRevisionTablecolumn3に設定する。
				getDetailsInfoRevisionTablecolumn3().setCustomCells(getColumnList2Comment());

				// 明細情報テーブルのVisibleがtrueの場合
				// 明細情報テーブルでレコードが選択されている場合
				if (getDetailsInfoTable().isVisible() && getDetailsInfoTable().isSelected()) {
					// 明細情報テーブルで選択されているレコードを明細情報詳細テーブルに表示する。
					// ・第一引数："DETAIL"
					doShowClaimDetail("DETAIL");
				}

				// 居宅会議支援明細情報テーブルのVisibleがtrueの場合
				// 居宅介護支援明細情報テーブルでレコードが選択されている場合
				if (getKyotakuDetailsInfoTable().isVisible() && getKyotakuDetailsInfoTable().isSelected()) {
					// 居宅介護支援明細情報テーブルで選択されているレコードを明細情報詳細テーブルに表示する。
					// ・第一引数："KYOTAKU"
					doShowClaimDetail("KYOTAKU");
				}
			}
			getDetailsInfoRevisionCheck().setSelected(true);
		} else {
			// チェックボックスがオフの場合
			// 明細情報領域（detailsInfos）のEnableがtrueの場合
			if (getDetailsInfos().isEnabled()) {
				// ※項目名列の設定
				// columnList2NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をdetailsInfoRevisionTablecolumn1に設定する。
				getDetailsInfoRevisionTablecolumn1().setCustomCells(getColumnList2NameSimple());
				// ※設定値列の設定
				// columnList2ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をdetailsInfoRevisionTablecolumn2に設定する。
				getDetailsInfoRevisionTablecolumn2().setCustomCells(getColumnList2ValueSimple());
				// ※コメント列の設定
				// columnList2CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をdetailsInfoRevisionTablecolumn3に設定する。
				getDetailsInfoRevisionTablecolumn3().setCustomCells(getColumnList2CommentSimple());
				// 明細情報テーブルのVisibleがtrueの場合
				// 明細情報テーブルでレコードが選択されている場合
				if (getDetailsInfoTable().isVisible() && getDetailsInfoTable().isSelected()) {
					// 明細情報テーブルで選択されているレコードを明細情報詳細テーブルに表示する。
					// ・第一引数："DETAIL"
					doShowClaimDetail("DETAIL");
				}

				// 居宅介護支援明細情報テーブルのVisibleがtrueの場合
				// 居宅介護支援明細情報テーブルでレコードが選択されている場合
				if (getKyotakuDetailsInfoTable().isVisible() && getKyotakuDetailsInfoTable().isSelected()) {
					// 居宅介護支援明細情報テーブルで選択されているレコードを明細情報詳細テーブルに表示する。
					// ・第一引数："KYOTAKU"
					doShowClaimDetail("KYOTAKU");
				}
			}
			getDetailsInfoRevisionCheck().setSelected(false);
		}
		getDetailsInfoTable().validate();
		getDetailsInfoTable().repaint();
	}

	/**
	 * 「データ切り替え処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void particularInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
		if (getParticularInfoRevisionCheck().isSelected()) {
			// 特定治療・特定診療情報領域（particularInfos）のEnableがtrueの場合
			if (getParticularInfos().isEnabled()) {
				// ※項目名列の設定
				// columnList3NameをparticularInfoRevisionTablecolumn1に設定する。
				getParticularInfoRevisionTablecolumn1().setCustomCells(getColumnList3Name());
				// ※設定値列の設定
				// columnList3ValueをparticularInfoRevisionTablecolumn2に設定する。
				getParticularInfoRevisionTablecolumn2().setCustomCells(getColumnList3Value());
				// ※コメント列の設定
				// columnList3CommentをparticularInfoRevisionTablecolumn3に設定する。
				getParticularInfoRevisionTablecolumn3().setCustomCells(getColumnList3Comment());

				// 特定治療費情報テーブルのVisibleがtrueの場合
				// 特定治療費情報テーブルでレコードが選択されている場合
				if (getParticularInfoTable().isVisible() && getParticularInfoTable().isSelected()) {
					// 特定治療費情報テーブルで選択されているレコードを特定治療費・特定診療費情報詳細テーブルに表示する。
					// ・第一引数："PARTICULAR"
					doShowClaimDetail("PARTICULAR");
				}

				// 特定診療費情報テーブルのVisibleがtrueの場合
				// 特定診療費情報テーブルでレコードが選択されている場合
				if (getSpecialClinicInfoTable().isVisible() && getSpecialClinicInfoTable().isSelected()) {
					// 特定治療費情報テーブルで選択されているレコードを特定治療費・特定診療費情報詳細テーブルに表示する。
					// ・第一引数："SPECIAL_CLINIC"
					doShowClaimDetail("SPECIAL_CLINIC");
				}
			}
			getParticularInfoRevisionCheck().setSelected(true);
		} else {
			// チェックボックスがオフの場合
			// 明細情報領域（detailsInfos）のEnableがtrueの場合
			if (getParticularInfos().isEnabled()) {
				// ※項目名列の設定
				// columnList3NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をparticularInfoRevisionTablecolumn1に設定する。
				getParticularInfoRevisionTablecolumn1().setCustomCells(getColumnList3NameSimple());
				// ※設定値列の設定
				// columnList3ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をparticularInfoRevisionTablecolumn2に設定する。
				getParticularInfoRevisionTablecolumn2().setCustomCells(getColumnList3ValueSimple());
				// ※コメント列の設定
				// columnList3CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をparticularInfoRevisionTablecolumn3に設定する。
				getParticularInfoRevisionTablecolumn3().setCustomCells(getColumnList3CommentSimple());
				// 特定治療費情報テーブルのVisibleがtrueの場合
				// 特定治療費情報テーブルでレコードが選択されている場合
				if (getParticularInfoTable().isVisible() && getParticularInfoTable().isSelected()) {
					// 特定治療費情報テーブルで選択されているレコードを特定治療費・特定診療費情報詳細テーブルに表示する。
					// ・第一引数："PARTICULAR"
					doShowClaimDetail("PARTICULAR");
				}

				// 特定診療費情報テーブルのVisibleがtrueの場合
				// 特定診療費情報テーブルでレコードが選択されている場合
				if (getSpecialClinicInfoTable().isVisible() && getSpecialClinicInfoTable().isSelected()) {
					// 特定治療費情報テーブルで選択されているレコードを特定治療費・特定診療費情報詳細テーブルに表示する。
					// ・第一引数："SPECIAL_CLINIC"
					doShowClaimDetail("SPECIAL_CLINIC");
				}

			}
			getParticularInfoRevisionCheck().setSelected(false);
		}
		getParticularInfoTable().validate();
		getParticularInfoTable().repaint();

	}

	/**
	 * 「データ切り替え処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void totalInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
		if (getTotalInfoRevisionCheck().isSelected()) {
			// 集計情報領域（totalInfos）のEnableがtrueの場合
			if (getTotalInfos().isEnabled()) {
				// ※項目名列の設定
				// columnList4NameをtotalInfoRevisionTablecolumn1に設定する。
				getTotalInfoRevisionTablecolumn1().setCustomCells(getColumnList4Name());
				// ※設定値列の設定
				// columnList4ValueをtotalInfoRevisionTablecolumn2に設定する。
				getTotalInfoRevisionTablecolumn2().setCustomCells(getColumnList4Value());
				// ※コメント列の設定
				// columnList4CommentをtotalInfoRevisionTablecolumn3に設定する。
				getTotalInfoRevisionTablecolumn3().setCustomCells(getColumnList4Comment());

				// 集計情報テーブルでレコードが選択されている場合
				if (getTotalInfoTable().isSelected()) {
					// 集計情報テーブルで選択されているレコードを集計情報詳細テーブルに表示する。
					// ・第一引数："TOTAL"
					doShowClaimDetail("TOTAL");
				}
			}
			getTotalInfoRevisionCheck().setSelected(true);
		} else {
			// チェックボックスがオフの場合
			// 集計情報領域（totalInfos）のEnableがtrueの場合
			if (getTotalInfos().isEnabled()) {
				// ※項目名列の設定
				// columnList4NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をtotalInfoRevisionTablecolumn1に設定する。
				getTotalInfoRevisionTablecolumn1().setCustomCells(getColumnList4NameSimple());
				// ※設定値列の設定
				// columnList4ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をtotalInfoRevisionTablecolumn2に設定する。
				getTotalInfoRevisionTablecolumn2().setCustomCells(getColumnList4ValueSimple());
				// ※コメント列の設定
				// columnList4CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をtotalInfoRevisionTablecolumn3に設定する。
				getTotalInfoRevisionTablecolumn3().setCustomCells(getColumnList4CommentSimple());
				// 集計情報テーブルでレコードが選択されている場合
				if (getTotalInfoTable().isSelected()) {
					// 集計情報テーブルで選択されているレコードを集計情報詳細テーブルに表示する。
					// ・第一引数："TOTAL"
					doShowClaimDetail("TOTAL");
				}
			}
			getTotalInfoRevisionCheck().setSelected(false);

		}
		getTotalInfoTable().validate();
		getTotalInfoTable().repaint();
	}

	/**
	 * 「データ切り替え処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void nyushoInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
		if (getNyushoInfoRevisionCheck().isSelected()) {
			// チェックボックスがオンの場合
			if (getNyushoInfos().isEnabled()) {
				// 特定入所者介護費情報領域（nyushoInfos）のEnableがtrueの場合
				if (getNyushoInfos().isEnabled()) {
					// ※項目名列の設定
					// columnList5NameをnyushoInfoRevisionTablecolumn1に設定する。
					getNyushoInfoRevisionTablecolumn1().setCustomCells(getColumnList5Name());
					// ※設定値列の設定
					// columnList5ValueをnyushoInfoRevisionTablecolumn2に設定する。
					getNyushoInfoRevisionTablecolumn2().setCustomCells(getColumnList5Value());
					// ※コメント列の設定
					// columnList5CommentをnyushoInfoRevisionTablecolumn3に設定する。
					getNyushoInfoRevisionTablecolumn3().setCustomCells(getColumnList5Comment());

					// 特定入所者介護費情報テーブルでレコードが選択されている場合
					if (getNyushoInfoTable().isSelected()) {
						// 特定入所者介護費情報テーブルで選択されているレコードを特定入所者介護費情報詳細テーブルに表示する。
						// ・第一引数："TOTAL"
						doShowClaimDetail("NYUSHO");
					}
				}
			}
			getNyushoInfoRevisionCheck().setSelected(true);
		} else {
			// チェックボックスがオフの場合
			if (getNyushoInfos().isEnabled()) {
				// 特定入所者介護費情報領域（nyushoInfos）のEnableがtrueの場合
				if (getNyushoInfos().isEnabled()) {
					// ※項目名列の設定
					// columnList5NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
					// 取得したレコード集合をnyushoInfoRevisionTablecolumn1に設定する。
					getNyushoInfoRevisionTablecolumn1().setCustomCells(getColumnList5NameSimple());
					// ※設定値列の設定
					// columnList5ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
					// 取得したレコード集合をnyushoInfoRevisionTablecolumn2に設定する。
					getNyushoInfoRevisionTablecolumn2().setCustomCells(getColumnList5ValueSimple());
					// ※コメント列の設定
					// columnList5CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
					// 取得したレコード集合をnyushoInfoRevisionTablecolumn3に設定する。
					getNyushoInfoRevisionTablecolumn3().setCustomCells(getColumnList5CommentSimple());
					// 特定入所者介護費情報テーブルでレコードが選択されている場合
					if (getNyushoInfoTable().isSelected()) {
						// 特定入所者介護費情報テーブルで選択されているレコードを特定入所者介護費情報詳細テーブルに表示する。
						// ・第一引数："TOTAL"
						doShowClaimDetail("NYUSHO");
					}
				}
			}
			getNyushoInfoRevisionCheck().setSelected(false);
		}
		getNyushoInfoTable().validate();
		getNyushoInfoTable().repaint();
	}

	/**
	 * 「データ切り替え処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void shahukuInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
		// チェックボックスがオンの場合
		if (getShahukuInfoRevisionCheck().isSelected()) {
			// 社会福祉法人軽減額情報領域（shahukuInfos）のEnableがtrueの場合
			if (getShahukuInfos().isEnabled()) {
				// ※項目名列の設定
				// columnList6NameをshahukuInfoRevisionTablecolumn1に設定する。
				getShahukuInfoRevisionTablecolumn1().setCustomCells(getColumnList6Name());
				// ※設定値列の設定
				// columnList6ValueをshahukuInfoRevisionTablecolumn2に設定する。
				getShahukuInfoRevisionTablecolumn2().setCustomCells(getColumnList6Value());
				// ※コメント列の設定
				// columnList6CommentをshahukuInfoRevisionTablecolumn3に設定する。
				getShahukuInfoRevisionTablecolumn3().setCustomCells(getColumnList6Comment());

				// 社会福祉法人軽減額情報テーブルでレコードが選択されている場合
				if (getShahukuInfoTable().isSelected()) {
					// 社会福祉法人軽減額情報テーブルで選択されているレコードを社会福祉法人軽減額情報詳細テーブルに表示する。
					// ・第一引数："SHAHUKU"
					doShowClaimDetail("SHAHUKU");
				}
			}
			getShahukuInfoRevisionCheck().setSelected(true);
		} else {
			// チェックボックスがオフの場合
			// 社会福祉法人軽減額情報領域（shahukuInfos）のEnableがtrueの場合
			if (getShahukuInfos().isEnabled()) {
				// ※項目名列の設定
				// columnList6NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をshahukuInfoRevisionTablecolumn1に設定する。
				getShahukuInfoRevisionTablecolumn1().setCustomCells(getColumnList6NameSimple());
				// ※設定値列の設定
				// columnList6ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をshahukuInfoRevisionTablecolumn2に設定する。
				getShahukuInfoRevisionTablecolumn2().setCustomCells(getColumnList6ValueSimple());
				// ※コメント列の設定
				// columnList6CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をshahukuInfoRevisionTablecolumn3に設定する。
				getShahukuInfoRevisionTablecolumn3().setCustomCells(getColumnList6CommentSimple());
				// 社会福祉法人軽減額情報テーブルでレコードが選択されている場合
				if (getShahukuInfoTable().isSelected()) {
					// 社会福祉法人軽減額情報テーブルで選択されているレコードを社会福祉法人軽減額情報詳細テーブルに表示する。
					// ・第一引数："SHAHUKU"
					doShowClaimDetail("SHAHUKU");
				}
			}
			getShahukuInfoRevisionCheck().setSelected(false);
		}
		getShahukuInfoTable().validate();
		getShahukuInfoTable().repaint();
	}
	
	//[H20.5 法改正対応] fujihara add start
	/**
	 * 「データ切り替え処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
    protected void recuperationInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
    	
		if (getRecuperationInfoRevisionCheck().isSelected()) {
			// 特定療養費情報領域（particularInfos）のEnableがtrueの場合
			if (getRecuperationInfos().isEnabled()) {
				// ※項目名列の設定
				// columnList7NameをparticularInfoRevisionTablecolumn1に設定する。
				getRecuperationInfoRevisionTablecolumn1().setCustomCells(getColumnList7Name());

				// ※設定値列の設定
				// columnList7ValueをparticularInfoRevisionTablecolumn2に設定する。
				getRecuperationInfoRevisionTablecolumn2().setCustomCells(getColumnList7Value());
				// ※コメント列の設定
				// columnList7CommentをparticularInfoRevisionTablecolumn3に設定する。
				getRecuperationInfoRevisionTablecolumn3().setCustomCells(getColumnList7Comment());

				// 特定療養費情報テーブルでレコードが選択されている場合
				if (getRecuperationInfoTable().isSelected()) {
					// 特定療養費情報テーブルで選択されているレコードを特定療養費情報詳細テーブルに表示する。
					// ・第一引数："RYOYO"
					doShowClaimDetail("RYOYO");
				}
			}
			getRecuperationInfoRevisionCheck().setSelected(true);

			// チェックボックスがオフの場合
		} else {
			// 特定療養費情報領域（particularInfos）のEnableがtrueの場合
			if (getRecuperationInfos().isEnabled()) {
				// ※項目名列の設定
				// columnList7NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をparticularInfoRevisionTablecolumn1に設定する。
				getRecuperationInfoRevisionTablecolumn1().setCustomCells(getColumnList7NameSimple());

				// ※設定値列の設定
				// columnList7ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をparticularInfoRevisionTablecolumn2に設定する。
				getRecuperationInfoRevisionTablecolumn2().setCustomCells(getColumnList7ValueSimple());

				// ※コメント列の設定
				// columnList7CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をparticularInfoRevisionTablecolumn3に設定する。
				getRecuperationInfoRevisionTablecolumn3().setCustomCells(getColumnList7CommentSimple());

				// 特定療養費情報テーブルでレコードが選択されている場合
				if (getRecuperationInfoTable().isSelected()) {
					// 特定療養費情報テーブルで選択されているレコードを特定療養費情報詳細テーブルに表示する。
					// ・第一引数："RYOYO"
					doShowClaimDetail("RYOYO");
				}
			}
			getRecuperationInfoRevisionCheck().setSelected(false);
		}
		getRecuperationInfoTable().validate();
		getRecuperationInfoTable().repaint();
        
    }
    //[H20.5 法改正対応] fujihara add end

 // 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
	/**
	 * 「データ切り替え処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
    protected void detailsJushotiTokureiInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception {
		if (getDetailsJushotiTokureiInfoRevisionCheck().isSelected()) {
			// 明細情報領域（detailsJushotiTokureiInfos）のEnableがtrueの場合
			if (getDetailsJushotiTokureiInfos().isEnabled()) {
				// ※項目名列の設定
				// columnList8NameをdetailsJushotiTokureiInfoRevisionTablecolumn1に設定する。
				getDetailsJushotiTokureiInfoRevisionTablecolumn1().setCustomCells(getColumnList8Name());
				// ※設定値列の設定
				// columnList8ValueをdetailsJushotiTokureiInfoRevisionTablecolumn2に設定する。
				getDetailsJushotiTokureiInfoRevisionTablecolumn2().setCustomCells(getColumnList8Value());
				// ※コメント列の設定
				// columnList8CommentをdetailsJushotiTokureiInfoRevisionTablecolumn3に設定する。
				getDetailsJushotiTokureiInfoRevisionTablecolumn3().setCustomCells(getColumnList8Comment());

				// 明細情報テーブルのVisibleがtrueの場合
				// 明細情報テーブルでレコードが選択されている場合
				if (getDetailsJushotiTokureiInfoTable().isVisible() && getDetailsJushotiTokureiInfoTable().isSelected()) {
					// 明細情報テーブルで選択されているレコードを明細情報詳細テーブルに表示する。
					// ・第一引数："DETAIL_JUSHOTI_TOKUREI"
					doShowClaimDetail("DETAIL_JUSHOTI_TOKUREI");
				}
			}
			getDetailsJushotiTokureiInfoRevisionCheck().setSelected(true);
		} else {
			// チェックボックスがオフの場合
			// 明細情報領域（detailsInfos）のEnableがtrueの場合
			if (getDetailsJushotiTokureiInfos().isEnabled()) {
				// ※項目名列の設定
				// columnList8NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をdetailsJushotiTokureiInfoRevisionTablecolumn1に設定する。
				getDetailsJushotiTokureiInfoRevisionTablecolumn1().setCustomCells(getColumnList8NameSimple());
				// ※設定値列の設定
				// columnList8ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をdetailsJushotiTokureiInfoRevisionTablecolumn2に設定する。
				getDetailsJushotiTokureiInfoRevisionTablecolumn2().setCustomCells(getColumnList8ValueSimple());
				// ※コメント列の設定
				// columnList8CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
				// 取得したレコード集合をdetailsJushotiTokureiInfoRevisionTablecolumn3に設定する。
				getDetailsJushotiTokureiInfoRevisionTablecolumn3().setCustomCells(getColumnList8CommentSimple());
				// 明細情報テーブルのVisibleがtrueの場合
				// 明細情報テーブルでレコードが選択されている場合
				if (getDetailsJushotiTokureiInfoTable().isVisible() && getDetailsJushotiTokureiInfoTable().isSelected()) {
					// 明細情報テーブルで選択されているレコードを明細情報詳細テーブルに表示する。
					// ・第一引数："DETAIL"
					doShowClaimDetail("DETAIL_JUSHOTI_TOKUREI");
				}
			}
			getDetailsJushotiTokureiInfoRevisionCheck().setSelected(false);
		}
		getDetailsJushotiTokureiInfoTable().validate();
		getDetailsJushotiTokureiInfoTable().repaint();
    }
 // 2014/12/24 [Yoichiro Kamei] add - end
    
	/**
	 * 「データ変更時処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void basicInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception {
		// tableChangeFlgに1を代入する。
		// 基本情報テーブルを再描画する。
		setTableChangeFlg(ON);
	}

	/**
	 * 「データ変更時処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void detailsInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception {
		// tableChangeFlgに1を代入する。
		setTableChangeFlg(ON);
		if (getDetailsInfoTable().isVisible()) {
			// 明細情報テーブルのVisibleがtrueの場合
			// 明細情報テーブルを再描画する。
			getDetailsInfoTable().validate();
			getDetailsInfoTable().repaint();
		}

		if (getKyotakuDetailsInfoTable().isVisible()) {
			// 居宅介護支援明細情報テーブルのVisibleがtrueの場合
			// 居宅介護支援明細情報テーブルを再描画する。
			getKyotakuDetailsInfoTable().validate();
			getKyotakuDetailsInfoTable().repaint();
		}
	}

	/**
	 * 「データ変更時処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void particularInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception {
		// tableChangeFlgに1を代入する。
		setTableChangeFlg(ON);
		// 特定治療費情報テーブルのVisibleがtrueの場合
		if (getParticularInfoTable().isVisible()) {
			// 特定治療費情報テーブルを再描画する。
			getParticularInfoTable().validate();
			getParticularInfoTable().repaint();
		}

		if (getSpecialClinicInfoTable().isVisible()) {
			// 特定診療費情報テーブルのVisibleがtrueの場合
			// 特定診療費情報テーブルを再描画する。
			getSpecialClinicInfoTable().validate();
			getSpecialClinicInfoTable().repaint();
		}
	}

	/**
	 * 「データ変更時処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void totalInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception {
		// tableChangeFlgに1を代入する。
		setTableChangeFlg(ON);
		// 集計情報テーブルを再描画する。
		getTotalInfoTable().validate();
		getTotalInfoTable().repaint();
	}

	/**
	 * 「データ変更時処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void nyushoInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception {
		// tableChangeFlgに1を代入する。
		setTableChangeFlg(ON);
		// 特定入所者介護費情報テーブルを再描画する。
		getNyushoInfoTable().validate();
		getNyushoInfoTable().repaint();
	}

	/**
	 * 「データ変更時処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void shahukuInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception {
		// tableChangeFlgに1を代入する。
		setTableChangeFlg(ON);
		// 社会福祉法人軽減額情報テーブルを再描画する。
		getShahukuInfoTable().validate();
		getShahukuInfoTable().repaint();
	}
	
	//[ID:0000429][Shin Fujihara] 2009/07 add start 2009年度対応
	//特別療養費タブの変更チェック漏れ対応
	/**
	 * 「データ変更時処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void recuperationInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception {
		// tableChangeFlgに1を代入する。
		setTableChangeFlg(ON);
		// 特別療養費情報テーブルを再描画する。
		getRecuperationInfoTable().validate();
		getRecuperationInfoTable().repaint();
		
	}
	//[ID:0000429][Shin Fujihara] 2009/07 add end 2009年度対応

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		
		
		param.setData("PATIENT_ID", new Integer(27));
		param.setData("INSURED_ID", "9000000001");
		param.setData("PROVIDER_ID", "2000000000");
		param.setData("LIST_INDEX", new Integer(1));
		param.setData("INSURER_ID", "111111");
		param.setData("CLAIM_STYLE_TYPE", new Integer(10411));
		param.setData("CLAIM_DATE", jp.nichicom.ac.util.ACDateUtilities.createDate(2009, 8, 1));
		param.setData("TARGET_DATE", jp.nichicom.ac.util.ACDateUtilities.createDate(2009, 7, 1));
		

		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QP005.class.getName(), param));
	}

	// 内部関数

	/**
	 * 「データ取得、画面展開」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFind() throws Exception {
		// データを取得し、画面に展開する処理。
		// 画面展開用VRMap mapを生成する。
		VRMap map = new VRHashMap();
		// SQL渡しパラ
		VRMap param = new VRHashMap();

		// 業務情報マスタより、データを取得する。

		// 取得したデータのウィンドウタイトル（Window_TITLE）をウィンドウに設定する。
		// 取得したデータの業務タイトル（AFFAIR_TITLE）を業務ボタンバーに設定する。
		setAffairTitle("QP005", getButtons());

		// コードマスタのデータを取得し、masterCodeに格納する。
		setMasterCode(QkanSystemInformation.getInstance().getMasterCode());

		// 画面のVisible制御・Enable制御・ラベルのキャプション操作を行う。
		doControlWindow();

		// 項目コメントマスタ（M_DETAIL_COMMENT）TABLEよりデータを取得する。
		doFindComment();

		// 請求データを取得する。
		doFindClaim();

		// 画面テーブルの設定を行う。
		doSetTable();

		// 画面展開用HashMap：WindowMapの設定を行う。

		// 利用者保険情報を取得する。
		// 下記を取得する。
		// ・利用者名
		// toFullName();
		// 下記のデータを結合する。
		// 氏名（姓）（PATIENT_FAMILY_NAME）
		// 氏名（名）（PATIENT_FIRST_NAME）
		VRMap patientInfo = (VRMap) QkanCommon.getPatientInfo(getDBManager(), getPatientId()).getData(0);
		String patientName = QkanCommon.toFullName(patientInfo.getData("PATIENT_FAMILY_NAME"), patientInfo.getData("PATIENT_FIRST_NAME"));

		// ・利用者保険情報の利用者コード（PATIENT_CODE）
		VRList patientInsureInfoList = QkanCommon.getPatientInsureInfoOnEndOfMonth(getDBManager(), getTargetDate(), getPatientId());
		VRMap patientInsureInfoMap = (VRMap) patientInsureInfoList.getData(0);

		// ・利用者保険情報の被保険者番号（INSURED_ID）
		String insuredID = new String();
		if (ACTextUtilities.isNullText(patientInsureInfoMap.getData("INSURED_ID"))) {
			insuredID = "";
		} else {
			insuredID = ACCastUtilities.toString(patientInsureInfoMap.getData("INSURED_ID"));
		}

		String patientCode = new String();
		if (ACTextUtilities.isNullText(patientInfo.getData("PATIENT_CODE"))) {
			patientCode = "コード無し";
		} else {
			patientCode = ACCastUtilities.toString(patientInfo.getData("PATIENT_CODE"));
		}

		// 上記のデータを以下の型に編集する。
		// ・'PATIENT_NAME'（被保険者番号 = 'INSURED_ID'. 利用者CD = 'PATIENT_CODE'）
		String patient = patientName + "（被保険者番号 : " + insuredID + "  利用者コード : " + patientCode + ")";

		// 編集したデータをmapに以下のKEYで設定する。
		// ・KEY：PATIENT_NAME
		map.setData("PATIENT_NAME", patient);

		// 事業所情報を取得する。
		VRList providerIDList = QkanCommon.getProviderInfo(getDBManager(), getProviderId());
		VRMap providerIDMap = (VRMap) providerIDList.getData(0);

		// 取得した事業所情報の事業所名（PROVIDER_NAME）を以下の型に編集する。
		// ・'PROVIDER_NAME'（'providerId'）
		String provider = providerIDMap.getData("PROVIDER_NAME") + "(" + getProviderId() + ")";

		// 編集したデータをmapに以下のKEYで設定する。
		// ・KEY：PROVIDER_NAME
		map.setData("PROVIDER_NAME", provider);

		// 帳票様式名を取得する。
		// 取得したデータをmapに以下のKEYで設定する。
		// ・KEY：CLAIM_STYLE_NAME
		String claimStyle = getClaimStyleName();
		map.setData("CLAIM_STYLE_NAME", claimStyle);

		// targetDateをmapに以下のKEYで設定する。
		// ・KEY：TARGET_DATE
		String dateInfo = VRDateParser.format(getTargetDate(), "gggee年MM月度");
		map.setData("TARGET_DATE", dateInfo);

		// 公費クエリ格納用テンポラリ
		VRList kohiData = new VRArrayList();
		VRMap claimData = new VRHashMap();
		
		ArrayList kohiType = new ArrayList();

		// 公費情報の取得
		// 10701の定数化
		
		// replace begin 2006/09/14 kamitsukasa
		if (!(getClaimStyleType() == FORMAT_STYLE7 || getClaimStyleType() == FORMAT_STYLE72)) {
			if (!getTableClaimList1().isEmpty()) {
				claimData = (VRMap) getTableClaimList1().getData(0);
			}
//		if (!(getClaimStyleType() == 10701)) {
			// replace end 2006/09/14 kamitsukasa
			
			// claimStyleTypeの値が10701以外の場合
			// tableClaimList1の下記の値を取得し、配列にする。
			// ・201058（公費1 公費種類）
			// ・201059（公費2 公費種類）
			// ・201060（公費3 公費種類）

			if (!ACTextUtilities.isNullText(claimData.getData("201058"))) {
				kohiType.add(ACCastUtilities.toInteger(claimData.getData("201058")));
			}

			if (!ACTextUtilities.isNullText(claimData.getData("201059"))) {
				kohiType.add(ACCastUtilities.toInteger(claimData.getData("201059")));
			}

			if (!ACTextUtilities.isNullText(claimData.getData("201060"))) {
				kohiType.add(ACCastUtilities.toInteger(claimData.getData("201060")));
			}

			if (!kohiType.isEmpty()) {
				// 上記の配列をSQL取得用のHashMap：paramに以下のKEYで設定する。
				// ・KEY：KOHI_TYPE
				param.setData("KOHI_TYPE", kohiType.toArray());
				// 公費情報を取得する。
				kohiData = getDBManager().executeQuery(getSQL_GET_KOHI(param));
			}
			
		// replace begin 2006/09/14 kamitsukasa
//		} else if (getClaimStyleType() == 10701) {
		} else {
			if (!getTableClaimList2().isEmpty()) {
				claimData = (VRMap) getTableClaimList2().getData(0);
			}
			// replace end 2006/09/14 kamitsukasa
			
			// claimStyleTypeの値が10711/10712の場合
			// tableClaimList2の下記の値を取得し、配列にする。
			// ・1001019（公費 公費種類）
			if (!ACTextUtilities.isNullText(claimData.getData("1001019"))) {
				kohiType.add(ACCastUtilities.toInteger(claimData.getData("1001019")));
			}

			if (!kohiType.isEmpty()) {
				// 上記の配列をSQL取得用のHashMap：paramに以下のKEYで設定する。
				// ・KEY：KOHI_TYPE
				param.setData("KOHI_TYPE", kohiType.toArray());

				// 公費情報を取得する。
				kohiData = getDBManager().executeQuery(getSQL_GET_KOHI(param));
			}
		}

		// 取得した公費情報から下記の情報を取得する。
		// ・KOHI_ABBREVIATION
		// ・BENEFIT_RATE
		// 取得したデータを以下の型に編集する。
		// ・1. 'KOHI_ABBREVIATION'（'BENEFIT_RATE'%）
		// ※複数の場合、改行をはさみ、複数行の文字列にする。
		// ※頭のNoを繰り上げる。

		String kohiString = "";
		if (!kohiData.isEmpty()) {
			Iterator kohiIterator = kohiData.iterator();

			int i = 0;
			while (kohiIterator.hasNext()) {
				VRMap kohiMap = (VRMap) kohiIterator.next();
				kohiString = kohiString + "公費" + ACCastUtilities.toString(++i) + ":    " + ACCastUtilities.toString(kohiMap.getData("KOHI_ABBREVIATION")) + "(" + ACCastUtilities.toString(kohiMap.getData("BENEFIT_RATE")) + "%)    ";
			}
		} else {
			kohiString = "公費無し";
		}
		// 編集したデータをmapに以下のKEYで設定する。
		// ・KEY：KOHI_NAME
		map.setData("KOHI_NAME", kohiString);

		// mapを「クライアント領域（contents）」のソースとして設定する。
		setSource(map);

		// 画面に展開する。
		bindSource();

	}

	/**
	 * 「帳票様式名の取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public String getClaimStyleName() throws Exception {
		// 帳票様式名を返す処理。
		// claimStyleTypeの値が10211の場合
		// "様式第二"を返す。
		if (getClaimStyleType() == FORMAT_STYLE2) {
			return "様式第二";
		}

		// claimStyleTypeの値が10212の場合
		// "様式第二の二"を返す。	
		if (getClaimStyleType() == FORMAT_STYLE22) {
			return "様式第二の二";
		}
		
		// 2016/7/8 [Shinobu Hitaka] add - begin 総合事業対応
		// claimStyleTypeの値が10213の場合
		// "様式第二の三"を返す。	
		if (getClaimStyleType() == FORMAT_STYLE23) {
			return "様式第二の三";
		}
		// 2016/7/8 [Shinobu Hitaka] add - end
		
		// claimStyleTypeの値が10311の場合
		// "様式第三"を返す。
		if (getClaimStyleType() == FORMAT_STYLE3) {
			return "様式第三";
		}
		
		// claimStyleTypeの値が10312の場合
		// "様式第三"を返す。
		if (getClaimStyleType() == FORMAT_STYLE32) {
			return "様式第三のニ";
		}
		
		// claimStyleTypeの値が10411の場合
		// "様式第四"を返す。
		if (getClaimStyleType() == FORMAT_STYLE4) {
			return "様式第四";
		}

		// claimStyleTypeの値が10412の場合
		// "様式第四"を返す。
		if (getClaimStyleType() == FORMAT_STYLE42) {
			return "様式第四のニ";
		}
		
		// claimStyleTypeの値が10511の場合
		// "様式第五"を返す。
		if (getClaimStyleType() == FORMAT_STYLE5) {
			return "様式第五";
		}

		// claimStyleTypeの値が10512の場合
		// "様式第五"を返す。
		if (getClaimStyleType() == FORMAT_STYLE52) {
			return "様式第五のニ";
		}
		
		// claimStyleTypeの値が10611の場合
		// "様式第六"を返す。
		if (getClaimStyleType() == FORMAT_STYLE6) {
			return "様式第六";
		}

		// claimStyleTypeの値が10612の場合
		// "様式第六の三"を返す。
		if (getClaimStyleType() == FORMAT_STYLE62) {
			return "様式第六のニ";
		}
		
		// claimStyleTypeの値が10613の場合
		// "様式第六の三"を返す。
		if (getClaimStyleType() == FORMAT_STYLE63) {
			return "様式第六の三";
		}

		// claimStyleTypeの値が10614の場合
		// "様式第六の四"を返す。
		if (getClaimStyleType() == FORMAT_STYLE64) {
			return "様式第六の四";
		}
		
		// claimStyleTypeの値が10615の場合
		// "様式第六の五"を返す。
		if (getClaimStyleType() == FORMAT_STYLE65) {
			return "様式第六の五";
		}

		// claimStyleTypeの値が10616の場合
		// "様式第六の六"を返す。
		if (getClaimStyleType() == FORMAT_STYLE66) {
			return "様式第六の六";
		}
		
        // claimStyleTypeの値が10617の場合
        // "様式第六の七"を返す。
        if (getClaimStyleType() == FORMAT_STYLE67) {
            return "様式第六の七";
        }
		
		// claimStyleTypeの値が10711の場合
		// "様式第七"を返す。
		if (getClaimStyleType() == FORMAT_STYLE7) {
			return "様式第七";
		}

		// claimStyleTypeの値が10712の場合
		// "様式第七"を返す。
		if (getClaimStyleType() == FORMAT_STYLE72) {
			return "様式第七のニ";
		}
		
		// claimStyleTypeの値が10811の場合
		// "様式第八"を返す。
		if (getClaimStyleType() == FORMAT_STYLE8) {
			return "様式第八";
		}

		// claimStyleTypeの値が10911の場合
		// "様式第九"を返す。
		if (getClaimStyleType() == FORMAT_STYLE9) {
			return "様式第九";
		}

		// claimStyleTypeの値が11011の場合
		// "様式第十"を返す。
		if (getClaimStyleType() == FORMAT_STYLE10) {
			return "様式第十";
		}
		// 上記のいずれでもなかった場合(原則どれかののはず)
		return "";
	}

	/**
	 * 「画面のVisible制御・Enable制御・キャプション操作」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doControlWindow() throws Exception {
		// 画面のVisible制御・Enable制御・ラベルのキャプション操作を行う処理。

		// claimStyleTypeの値が10211の場合
		// 様式2
		if (getClaimStyleType() == FORMAT_STYLE2) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE1();
			// 状態ID：TYPE1
		}

		// claimStyleTypeの値が10212の場合
		// 様式2の2
		if (getClaimStyleType() == FORMAT_STYLE22) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE1();
			// 状態ID：TYPE1
		}
		
		// 2016/7/8 [Shinobu Hitaka] add - begin 総合事業対応
		// claimStyleTypeの値が10213の場合
		// 様式2の3
		if (getClaimStyleType() == FORMAT_STYLE23) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE1();
			// 状態ID：TYPE1
		}
		// 2016/7/8 [Shinobu Hitaka] add - end
		
		// claimStyleTypeの値が10311の場合
		// 様式3
		if (getClaimStyleType() == FORMAT_STYLE3) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE2();
			// 状態ID：TYPE2
		}

		// claimStyleTypeの値が10312の場合
		// 様式3の2
		if (getClaimStyleType() == FORMAT_STYLE32) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE2();
			// 状態ID：TYPE2
		}

		// claimStyleTypeの値が10411の場合
		// 様式4
		if (getClaimStyleType() == FORMAT_STYLE4) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE3();
			// 状態ID：TYPE3
			// 以下のコントロールのキャプションを"特定治療費"に設定する。
			// ・particularInfos
			getEtcInfoTabs().setTitleAt(2, "特定治療費");
		}

		// claimStyleTypeの値が10412の場合
		// 様式4の2
		if (getClaimStyleType() == FORMAT_STYLE42) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE3();
			// 状態ID：TYPE3
			// 以下のコントロールのキャプションを"特定治療費"に設定する。
			// ・particularInfos
			getEtcInfoTabs().setTitleAt(2, "特定治療費");
		}

		// claimStyleTypeの値が10511の場合
		// 様式5
		if (getClaimStyleType() == FORMAT_STYLE5) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE4();
			// 状態ID：TYPE4
			// 以下のコントロールのキャプションを"特定診療費"に設定する。
			// ・particularInfos
			// ・particularInfoLabel
			// ・particularInfoRevision
			getEtcInfoTabs().setTitleAt(2, "特定診療費");
			getParticularInfoLabel().setText("特定診療費");
			getParticularInfoRevision().setText("特定診療費");
		}

		// claimStyleTypeの値が10512の場合
		// 様式5の2
		if (getClaimStyleType() == FORMAT_STYLE52) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE4();
			// 状態ID：TYPE4
			// 以下のコントロールのキャプションを"特定診療費"に設定する。
			// ・particularInfos
			// ・particularInfoLabel
			// ・particularInfoRevision
			getEtcInfoTabs().setTitleAt(2, "特定診療費");
			getParticularInfoLabel().setText("特定診療費");
			getParticularInfoRevision().setText("特定診療費");
		}

		// claimStyleTypeの値が10611の場合
		// 様式6
		if (getClaimStyleType() == FORMAT_STYLE6) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE5();
			// 状態ID：TYPE5
		}

		// claimStyleTypeの値が10612の場合
		// 様式6の2
		if (getClaimStyleType() == FORMAT_STYLE62) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE5();
			// 状態ID：TYPE5
		}
		
		// claimStyleTypeの値が10613の場合
		// 様式6の3
		if (getClaimStyleType() == FORMAT_STYLE63) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE5();
			// 状態ID：TYPE5
		}
		
		// claimStyleTypeの値が10614の場合
		// 様式6の3
		if (getClaimStyleType() == FORMAT_STYLE64) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE5();
			// 状態ID：TYPE5
		}

		// claimStyleTypeの値が10615の場合
		// 様式6の5
		if (getClaimStyleType() == FORMAT_STYLE65) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE5();
			// 状態ID：TYPE5
		}

		// claimStyleTypeの値が10616の場合
		// 様式6の6
		if (getClaimStyleType() == FORMAT_STYLE66) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE5();
			// 状態ID：TYPE5
		}
		
        // claimStyleTypeの値が10617の場合
        // 様式6の7
        if (getClaimStyleType() == FORMAT_STYLE67) {
            // 画面のVisible制御・Enable制御を行う。
            setState_TYPE5();
            // 状態ID：TYPE5
        }

		
		// claimStyleTypeの値が10711の場合
		// 様式7
		if (getClaimStyleType() == FORMAT_STYLE7) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE6();
			// 状態ID：TYPE6
		}

		// claimStyleTypeの値が10712の場合
		// 様式7
		if (getClaimStyleType() == FORMAT_STYLE72) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE6();
			// 状態ID：TYPE6
		}
		
		// claimStyleTypeの値が10811の場合
		// 様式8
		if (getClaimStyleType() == FORMAT_STYLE8) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE2();
			// 状態ID：TYPE2
		}

		// claimStyleTypeの値が10911の場合
		// 様式9
		if (getClaimStyleType() == FORMAT_STYLE9) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE3();
			// 状態ID：TYPE3
			// 以下のコントロールのキャプションを"特定治療費"に設定する。
			// ・particularInfos
			getEtcInfoTabs().setTitleAt(2, "特定治療費");
		}

		// claimStyleTypeの値が11011の場合
		// 様式10
		if (getClaimStyleType() == FORMAT_STYLE10) {
			// 画面のVisible制御・Enable制御を行う。
			setState_TYPE4();
			// 状態ID：TYPE4
			// 以下のコントロールのキャプションを"特定診療費"に設定する。
			// ・particularInfos
			// ・particularInfoLabel
			// ・particularInfoRevision
			getEtcInfoTabs().setTitleAt(2, "特定診療費");
			getParticularInfoLabel().setText("特定診療費");
			getParticularInfoRevision().setText("特定診療費");
		}
	}

	/**
	 * 「マスタデータ取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindComment() throws Exception {
		// 項目コメントマスタ（M_DETAIL_COMMENT）TABLEよりデータを取得する処理。
		// SQL文取得用VRMap paramを生成し、以下のKEY/VALUEを設定する。
		// ・KEY：TARGET_DATE VALUE：targetDate
		VRMap param = new VRHashMap();
		param.setData("TARGET_DATE", getTargetDate());

		// マスタデータ取得用のSQL文を取得する。
		// ・SQL_ID：GET_DETAIL_COMMENT
		// マスタデータを取得し、detailCommentListに格納する。
		setDetailCommentList(getDBManager().executeQuery(getSQL_GET_DETAIL_COMMENT(param)));
		
		//[ID:0000452][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
		switch (getClaimStyleType()){
		case FORMAT_STYLE2:
		case FORMAT_STYLE22:
		case FORMAT_STYLE23: // 2016.7.22 [Shinobu Hitaka] add 総合事業対応
			Integer categoryNo = new Integer("2");
			Integer commentId = new Integer("22");
			for (int i = 0; i < getDetailCommentList().getDataSize(); i++){
				VRMap map = (VRMap)getDetailCommentList().get(i);
				if (categoryNo.equals(map.get("CATEGORY_NO"))
					&&	commentId.equals(map.get("COMMENT_ID"))){
					// 2016.7.22 [Shinobu Hitaka] edit - begin 総合事業対応
					//map.put("COMMENT", "1:非該当 3:医療機関入院 4:死亡 5:その他 6:介護老人福祉施設入所 7:介護老人保健施設入所 8:介護療養型医療施設入院");
					if (getClaimStyleType() != FORMAT_STYLE23) {
						map.put("COMMENT", "1:非該当 3:医療機関入院 4:死亡 5:その他 6:介護老人福祉施設入所 7:介護老人保健施設入所 8:介護療養型医療施設入院");
					} else {
						map.put("COMMENT", "設定不要です。");
					}
					// 2016.7.22 [Shinobu Hitaka] edit - end
					break;
				}
			}
			break;
		}
		//[ID:0000452][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
	}

	/**
	 * 「請求データ取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFindClaim() throws Exception {
		// 請求データを取得する処理。
		// 請求データを取得するための、WHERE句を作成する。
		// WHERE句
		// (PATIENT_ID = patientId)
		// AND (INSURED_ID = insuredId)
		// AND (TARGET_DATE = targetDate)
		// AND (CLAIM_DATE = claimDate)
		// AND (PROVIDER_ID = providerId)
		// AND (CLAIM_STYLE_TYPE = claimStyleType)
		String whereStr = "(PATIENT_ID = " + getPatientId() + ") " + "AND (INSURED_ID = '" + getInsuredId() + "') " + "AND (TARGET_DATE = '" + VRDateParser.format(getTargetDate(), "yyyy-MM-dd") + "') " + "AND (CLAIM_DATE = '" + VRDateParser.format(getClaimDate(), "yyyy-MM-dd") + "') " + "AND (PROVIDER_ID = '" + getProviderId() + "') " + "AND (CLAIM_STYLE_TYPE = " + getClaimStyleType() + ") ";

		// 請求データを取得し、claimListに格納する。
		// 分割管理テーブルを更新する可能性がある為トランザクション内部で実行する
		try {

			// トランザクションを開始する。
			getDBManager().beginTransaction();

			VRList claimList = QkanCommon.getClaimDetailCustom(getDBManager(), getClaimDate(), whereStr);
			setClaimList(claimList);

			// コミットする
			getDBManager().commitTransaction();

			// パッシブチェック用に退避する。
			getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), getClaimList());

		} catch (Exception ex) {
			// 更新に失敗した場合
			// ロールバックする。
			getDBManager().rollbackTransaction();
			// 例外を投げる。
			// （異常終了）
			throw ex;
		}

	}

	/**
	 * 「画面テーブルの設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doSetTable() throws Exception {
		// 画面のテーブルの設定を行う処理。
		
		// claimListを順に見ていく。（ループ開始）
		Iterator claimListIterator = getClaimList().iterator();
		while (claimListIterator.hasNext()) {
			VRMap claimDataMap = (VRMap) claimListIterator.next();

			// レコードの格納処理、claimDataMapをdoMoveRecordに渡す。
			doMoveRecord(claimDataMap);
		}
		
		switch (getClaimStyleType()) {
			case FORMAT_STYLE2:
				// claimStyleTypeの値が10211の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11001010（2進数表記）
// 2014/12/24 [Yoichiro Kamei] mod - begin 住所地特例対応
//				doSetTableModel(202);
				
				//・第一引数：10011001010（2進数表記）
				doSetTableModel(1226);
// 2014/12/24 [Yoichiro Kamei] mod - end

				// テーブルの各行の設定を行う。
				// ・第一引数：11001010（2進数表記）
// 2014/12/24 [Yoichiro Kamei] mod - begin 住所地特例対応
//				doSetTableRow(202);
				
				//・第一引数：10011001010（2進数表記）
				doSetTableRow(1226);
// 2014/12/24 [Yoichiro Kamei] mod - end

				break;

			case FORMAT_STYLE22:
				// claimStyleTypeの値が10212の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11001010（2進数表記）
// 2014/12/24 [Yoichiro Kamei] mod - begin 住所地特例対応
//				doSetTableModel(202);
				//・第一引数：10011001010（2進数表記）
				doSetTableModel(1226);
// 2014/12/24 [Yoichiro Kamei] mod - end
				
				// テーブルの各行の設定を行う。
				// ・第一引数：11001010（2進数表記）
// 2014/12/24 [Yoichiro Kamei] mod - begin 住所地特例対応
//				doSetTableRow(202);
				//・第一引数：10011001010（2進数表記）
				doSetTableRow(1226);
// 2014/12/24 [Yoichiro Kamei] mod - end
				
				break;

			// 2016/7/8 [Shinobu Hitaka] add - begin 総合事業対応
			case FORMAT_STYLE23:
				// claimStyleTypeの値が10213の場合
				// テーブルモデルの設定を行う。
				//・第一引数：10011001010（2進数表記）
				doSetTableModel(1226);
				
				// テーブルの各行の設定を行う。
				//・第一引数：10011001010（2進数表記）
				doSetTableRow(1226);
				
				break;
			// 2016/7/8 [Shinobu Hitaka] add - end
							
			case FORMAT_STYLE3:
				// claimStyleTypeの値が10311の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11001110（2進数表記）
				doSetTableModel(206);

				// テーブルの各行の設定を行う。
				// ・第一引数：11001110（2進数表記）
				doSetTableRow(206);
				break;

			case FORMAT_STYLE32:
				// claimStyleTypeの値が10312の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11001110（2進数表記）
				doSetTableModel(206);

				// テーブルの各行の設定を行う。
				// ・第一引数：11001110（2進数表記）
				doSetTableRow(206);
				break;

				
			case FORMAT_STYLE4:
				// claimStyleTypeの値が10411の場合
				// テーブルモデルの設定を行う。
				
				//[H20.5 法改正対応] fujihara edit start
				//doSetTableModel(236);
				doSetTableModel(492);
				// ・第一引数：11101100（2進数表記）

				// テーブルの各行の設定を行う。
				//doSetTableRow(236);
				doSetTableRow(492);
				// ・第一引数：11101100（2進数表記）
				//[H20.5 法改正対応] fujihara edit end

				break;

			case FORMAT_STYLE42:
				// claimStyleTypeの値が10412の場合
				// テーブルモデルの設定を行う。
				//[H20.5 法改正対応] fujihara edit start
				//doSetTableModel(236);
				doSetTableModel(492);
				// ・第一引数：11101100（2進数表記）

				// テーブルの各行の設定を行う。
				//doSetTableRow(236);
				doSetTableRow(492);
				// ・第一引数：11101100（2進数表記）
				//[H20.5 法改正対応] fujihara edit end

				break;

				
			case FORMAT_STYLE5:
				// claimStyleTypeの値が10511の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11011100（2進数表記）
				doSetTableModel(220);
				// テーブルの各行の設定を行う。
				// ・第一引数：11011100（2進数表記）
				doSetTableRow(220);
				break;

			case FORMAT_STYLE52:
				// claimStyleTypeの値が10512の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11011100（2進数表記）
				doSetTableModel(220);
				// テーブルの各行の設定を行う。
				// ・第一引数：11011100（2進数表記）
				doSetTableRow(220);
				break;

				
			case FORMAT_STYLE6:
				// claimStyleTypeの値が10611の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11001000（2進数表記）
				doSetTableModel(200);

				// テーブルの各行の設定を行う。
				// ・第一引数：11001000（2進数表記）
				doSetTableRow(200);
				break;

			case FORMAT_STYLE62:
				// claimStyleTypeの値が10612の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11001000（2進数表記）
				doSetTableModel(200);

				// テーブルの各行の設定を行う。
				// ・第一引数：11001000（2進数表記）
				doSetTableRow(200);
				break;

				
			case FORMAT_STYLE63:
				// claimStyleTypeの値が10613の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11001000（2進数表記）
				doSetTableModel(200);

				// テーブルの各行の設定を行う。
				// ・第一引数：11001000（2進数表記）
				doSetTableRow(200);
				break;

			case FORMAT_STYLE64:
				// claimStyleTypeの値が10614の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11001000（2進数表記）
				doSetTableModel(200);

				// テーブルの各行の設定を行う。
				// ・第一引数：11001000（2進数表記）
				doSetTableRow(200);
				break;

				
			case FORMAT_STYLE65:
				// claimStyleTypeの値が10615の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11001000（2進数表記）
				doSetTableModel(200);

				// テーブルの各行の設定を行う。
				// ・第一引数：11001000（2進数表記）
				doSetTableRow(200);
				break;

			case FORMAT_STYLE66:
				// claimStyleTypeの値が10616の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11001000（2進数表記）
				doSetTableModel(200);

				// テーブルの各行の設定を行う。
				// ・第一引数：11001000（2進数表記）
				doSetTableRow(200);
				break;
				
            case FORMAT_STYLE67:
                // claimStyleTypeの値が10617の場合
                // テーブルモデルの設定を行う。
                // ・第一引数：11001000（2進数表記）
                doSetTableModel(200);

                // テーブルの各行の設定を行う。
                // ・第一引数：11001000（2進数表記）
                doSetTableRow(200);
                break;

			case FORMAT_STYLE7:
				// claimStyleTypeの値が10711の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：00000001（2進数表記）
				doSetTableModel(1);

				// テーブルの各行の設定を行う。
				// ・第一引数：00000001（2進数表記）
				doSetTableRow(1);
				break;

			case FORMAT_STYLE72:
				// claimStyleTypeの値が10712の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：00000001（2進数表記）
				doSetTableModel(1);

				// テーブルの各行の設定を行う。
				// ・第一引数：00000001（2進数表記）
				doSetTableRow(1);
				break;

				
			case FORMAT_STYLE8:
				// claimStyleTypeの値が10801の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11001110（2進数表記）
				doSetTableModel(206);

				// テーブルの各行の設定を行う。
				// ・第一引数：11001110（2進数表記）
				doSetTableRow(206);
				break;

			case FORMAT_STYLE9:
				// claimStyleTypeの値が10901の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11101100（2進数表記）
				//[H20.5 法改正対応] fujihara edit start
				//doSetTableModel(236);
				//doSetTableModel(492);
				doSetTableModel(972);

				// テーブルの各行の設定を行う。
				// ・第一引数：11101100（2進数表記）
				//doSetTableRow(236);
				//doSetTableRow(492);
				doSetTableRow(972);
				//[H20.5 法改正対応] fujihara edit end
				break;

			case FORMAT_STYLE10:
				// claimStyleTypeの値が11001の場合
				// テーブルモデルの設定を行う。
				// ・第一引数：11011100（2進数表記）
				doSetTableModel(220);

				// テーブルの各行の設定を行う。
				// ・第一引数：11011100（2進数表記）
				doSetTableRow(220);
				break;

			default:
				break;

		}
		
		// 請求データをテーブルモデルに設定する。
		doSetClaimData();
	}

	/**
	 * 「レコードの格納」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doMoveRecord(VRMap claimDataMap) throws Exception {
		// 請求データを各カテゴリごとに格納する処理。
		// claimDataMapからキー"CATEGORY_NO"を取得する。
		int categoryNo = ACCastUtilities.toInt(claimDataMap.getData("CATEGORY_NO"));

		// 取得した"CATEGORY_NO"によってレコードを判別してテーブルに追加する。
		switch (categoryNo) {
			case 2:
				// categoryNoの値が2の場合
				// tableClaimList1にrecordを追加する。
				getTableClaimList1().addData(claimDataMap);
				break;

			case 3:
				// categoryNoの値が3の場合
				// tableClaimList2にrecordを追加する。
				getTableClaimList2().addData(claimDataMap);
				break;

			case 4:
			case 17:
				// categoryNoの値が4または17の場合
				// tableClaimList3にrecordを追加する。
				getTableClaimList3().addData(claimDataMap);
				break;

			case 5:
				// categoryNoの値が5の場合
				// tableClaimList3にrecordを追加する。
				
				//[H20.5 法改正対応] fujihara edit start
				//様式第四、第四の二、第九の場合は、tableClaimList7に設定する
				switch (getClaimStyleType()){
					case FORMAT_STYLE4:
					case FORMAT_STYLE42:
					case FORMAT_STYLE9:
						getTableClaimList7().addData(claimDataMap);
						break;
					default:
						getTableClaimList3().addData(claimDataMap);
						break;
				
				}
				//[H20.5 法改正対応] fujihara edit start
				break;

			case 7:
				// categoryNoの値が7の場合
				// tableClaimList4にrecordを追加する。
				getTableClaimList4().addData(claimDataMap);
				break;

			case 8:
				// categoryNoの値が8の場合
				// tableClaimList5にrecordを追加する。
				getTableClaimList5().addData(claimDataMap);
				break;

			case 9:
				// categoryNoの値が9の場合
				// tableClaimList6にrecordを追加する。
				getTableClaimList6().addData(claimDataMap);
				break;

			case 10:
				// categoryNoの値が10の場合
				// tableClaimList2にrecordを追加する。
				getTableClaimList2().addData(claimDataMap);
				break;
// 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
			case 18:
				// categoryNoの値が18の場合
				// tableClaimList8にrecordを追加する。
				getTableClaimList8().addData(claimDataMap);
				break;
// 2014/12/24 [Yoichiro Kamei] add - end
			default:
				break;
		}
	}

	/**
	 * 「テーブルモデルの設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doSetTableModel(int firstArg) throws Exception {
		// テーブルモデルの設定を行う処理。
		// 第一引数と10000000（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 128) == 0)) {
			// ※基本情報テーブルと基本情報詳細テーブルのテーブルモデルの設定。
			// tableModelList1を以下のフィールドで設定する。

			String[] tableModelList1 = new String[14];
			tableModelList1[0] = "201005"; // "201005（保険者番号）"
			tableModelList1[1] = "201006"; // "201006（被保険者番号）"
			tableModelList1[2] = "201015"; // "201015（要介護度状態区分コード）"
			tableModelList1[3] = "201017"; // "201017（認定有効期間開始）"
			tableModelList1[4] = "201018"; // "201018（認定有効期間終了）"
			tableModelList1[5] = "201020"; // "201020（居宅サービス計画者事業所番号）"
			tableModelList1[6] = "201057"; // "201057（居宅サービス計画者事業所名）"
			tableModelList1[7] = "201021"; // "201021（開始年月日）"
			tableModelList1[8] = "201022"; // "201022（中止年月日）"
			tableModelList1[9] = "201023"; // "201023（中止理由コード）"
			tableModelList1[10] = "201024"; // "201024（入所（院）年月日）"
			tableModelList1[11] = "201025"; // "201025（退所（院）年月日）"
			tableModelList1[12] = "201026"; // "201026（入所（院）実日数）"
			tableModelList1[13] = "201061"; // "201061（主傷病名）"

			// 格納
			setTableModelList1(new ACTableModelAdapter());
			getTableModelList1().setColumns(tableModelList1);

			// tableModelList1を基本情報テーブル（basicInfoTable）に設定する。
			getBasicInfoTable().setModel(getTableModelList1());

			// tableModelDetail1を以下のフィールドで設定する。
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail1 = new String[3];
			tableModelDetail1[0] = "DETAIL_NAME";
			tableModelDetail1[1] = "DETAIL_VALUE";
			tableModelDetail1[2] = "COMMENT";

			// 格納
			setTableModelDetail1(new ACTableModelAdapter());
			getTableModelDetail1().setColumns(tableModelDetail1);

			// tableModelDetail1を基本情報詳細テーブル（basicInfoRevisionTable）に設定する。
			getBasicInfoRevisionTable().setModel(getTableModelDetail1());

			// ※キャプションの設定
			// 以下のラベルのキャプションに "基本情報" を設定する。
			// etcInfoTabs
			// basicInfoLabel
			// basicInfoRevisionLabel2
			getEtcInfoTabs().setTitleAt(0, "基本情報");
			getBasicInfoLabel().setText("基本情報");
			getBasicInfoRevisionLabel2().setText("基本情報");
		}

		// 第一引数と01000000（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 64) == 0)) {
			// ※明細情報テーブルと明細情報詳細テーブルのテーブルモデルの設定。
			// tableModelList2を以下のフィールドで設定する。

			String[] tableModelList2 = new String[12];
			tableModelList2[0] = "301007+''+301008"; // "301007+301008"
			tableModelList2[1] = "301019"; // "301019（サービス名称）"
			tableModelList2[2] = "301009"; // "301009（単位数）"
			tableModelList2[3] = "301010"; // "301010（日数･回数）"
			tableModelList2[4] = "301011"; // "301011（公費1対象日数・回数）"
			tableModelList2[5] = "301012"; // "301012（公費2対象日数・回数）"
			tableModelList2[6] = "301013"; // "301013（公費3対象日数・回数）"
			tableModelList2[7] = "301014"; // "301014（サービス単位数）"
			tableModelList2[8] = "301015"; // "301015（公費1対象サービス単位数）"
			tableModelList2[9] = "301016"; // "301016（公費2対象サービス単位数）"
			tableModelList2[10] = "301017"; // "301017（公費3対象サービス単位数）"
			tableModelList2[11] = "301018"; // "301018（摘要）"

			// 格納
			setTableModelList2(new ACTableModelAdapter());
			getTableModelList2().setColumns(tableModelList2);

			// tableModelList2を明細情報テーブル（detailsInfoTable）に設定する。
			getDetailsInfoTable().setModel(getTableModelList2());

			// tableModelDetail2を以下のフィールドで設定する。
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail2 = new String[3];
			tableModelDetail2[0] = "DETAIL_NAME";
			tableModelDetail2[1] = "DETAIL_VALUE";
			tableModelDetail2[2] = "COMMENT";

			// 格納
			setTableModelDetail2(new ACTableModelAdapter());
			getTableModelDetail2().setColumns(tableModelDetail2);

			// tableModelDetail2を明細情報詳細テーブル（detailsInfoRevisionTable）に設定する。
			getDetailsInfoRevisionTable().setModel(getTableModelDetail2());

			// ※キャプションの設定
			// 以下のラベルのキャプションに "明細情報" を設定する。
			// detailsInfos
			// detailsInfoLabel
			// detailsInfoRevision
			getEtcInfoTabs().setTitleAt(1, "明細情報");
			getDetailsInfoLabel().setText("明細情報");
			getDetailsInfoRevision().setText("明細情報");

		}

		// 第一引数と00100000（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 32) == 0)) {
			// ※特定治療費情報テーブルと特定治療費・特定診療費情報詳細テーブルのテーブルモデルの設定。
			// tableModelList3を以下のフィールドで設定する。

			String[] tableModelList3 = new String[19];
			tableModelList3[0] = "401004"; // "401004（事業所番号）"
			tableModelList3[1] = "401008"; // "401008（緊急時傷病名1）"
			tableModelList3[2] = "401009"; // "401009（緊急時傷病名2）"
			tableModelList3[3] = "401010"; // "401010（緊急時傷病名3）"
			tableModelList3[4] = "401011"; // "401011（緊急時治療開始年月日1）"
			tableModelList3[5] = "401012"; // "401012（緊急時治療開始年月日2）"
			tableModelList3[6] = "401013"; // "401013（緊急時治療開始年月日3）"
			tableModelList3[7] = "401014"; // "401014（往診日数）"
			tableModelList3[8] = "401015"; // "401015（往診医療機関名）"
			tableModelList3[9] = "401016"; // "401016（通院日数）"
			tableModelList3[10] = "401017"; // "401017（通院医療機関名）"
			tableModelList3[11] = "401018"; // "401018（緊急時治療管理単位数）"
			tableModelList3[12] = "401019"; // "401019（緊急時治療管理日数）"
			tableModelList3[13] = "401020"; // "401020（緊急時治療管理小計）"
			tableModelList3[14] = "401021"; // "401021(リハビリテーション点数）"
			tableModelList3[15] = "401022"; // "401022（処置点数）"
			tableModelList3[16] = "401023"; // "401023（手術点数）"
			tableModelList3[17] = "401024"; // "401024（麻酔点数）"
			tableModelList3[18] = "401025"; // "401025（放射線治療点数）"

			// 格納
			setTableModelList3(new ACTableModelAdapter());
			getTableModelList3().setColumns(tableModelList3);
			// tableModelList3を特定治療費情報テーブル（particularInfoTable）に設定する。
			getParticularInfoTable().setModel(getTableModelList3());

			// tableModelDetail3を以下のフィールドで設定する。
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail3 = new String[3];
			tableModelDetail3[0] = "DETAIL_NAME";
			tableModelDetail3[1] = "DETAIL_VALUE";
			tableModelDetail3[2] = "COMMENT";

			// 格納
			setTableModelDetail3(new ACTableModelAdapter());
			getTableModelDetail3().setColumns(tableModelDetail3);

			// tableModelDetail3を特定治療費・特定診療費情報詳細テーブル（particularInfoRevisionTable）に設定する。
			getParticularInfoRevisionTable().setModel(getTableModelDetail3());

			// ※キャプションの設定
			// 以下のラベルのキャプションに "特定治療費情報" を設定する。
			// particularInfos
			// particularInfoLabel
			// particularInfoRevision
			getEtcInfoTabs().setTitleAt(2, "特定治療費情報");
			getParticularInfoLabel().setText("特定治療費情報");
			getParticularInfoRevision().setText("特定治療費情報");

		}

		// 第一引数と00010000（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 16) == 0)) {
			// ※特定診療費情報テーブルと特定治療費・特定診療費情報詳細テーブルのテーブルモデルの設定。
			// tableModelList3を以下のフィールドで設定する。

			String[] tableModelList3 = new String[12];
			tableModelList3[0] = "501004"; // "501004（事業所番号）"
			tableModelList3[1] = "501007"; // "501007（レコード順次番号）"
			tableModelList3[2] = "501008"; // "501008（傷病名）"
			tableModelList3[3] = "501009"; // "501009（識別番号）"
			tableModelList3[4] = "501010"; // "501010（単位数）"
			tableModelList3[5] = "501011"; // "501011（保険回数）"
			tableModelList3[6] = "501012"; // "501012（保険サービス単位数）"
			tableModelList3[7] = "501013"; // "501013（保険合計単位数）"
			tableModelList3[8] = "501014"; // "501014（公費1回数）"
			tableModelList3[9] = "501017"; // "501017（公費2回数）"
			tableModelList3[10] = "501020"; // "501020（公費3回数）"
			tableModelList3[11] = "501023"; // "501023（摘要）"

			// 格納
			setTableModelList3(new ACTableModelAdapter());
			getTableModelList3().setColumns(tableModelList3);

			// tableModelList3を特定診療費情報テーブル（specialClinicInfoTable）に設定する。
			getSpecialClinicInfoTable().setModel(getTableModelList3());
			// getParticularInfoTable().setModel(getTableModelList3());

			// tableModelDetail3を以下のフィールドで設定する。
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail3 = new String[3];
			tableModelDetail3[0] = "DETAIL_NAME";
			tableModelDetail3[1] = "DETAIL_VALUE";
			tableModelDetail3[2] = "COMMENT";

			// 格納
			setTableModelDetail3(new ACTableModelAdapter());
			getTableModelDetail3().setColumns(tableModelDetail3);

			// tableModelDetail3を特定治療費・特定診療費情報詳細テーブル（particularInfoRevisionTable）に設定する。
			getParticularInfoRevisionTable().setModel(getTableModelDetail3());

			// ※キャプションの設定
			// 以下のラベルのキャプションに "特定診療費情報" を設定する。
			// particularInfos
			// particularInfoLabel
			// particularInfoRevision
			getEtcInfoTabs().setTitleAt(2, "特定診療費情報");
			getParticularInfoLabel().setText("特定診療費情報");
			getParticularInfoRevision().setText("特定診療費情報");

		}

		// 第一引数と00001000（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 8) == 0)) {
			// ※集計情報テーブルと集計情報詳細テーブルのテーブルモデルの設定。
			// tableModelList4を以下のフィールドで設定する。
			String[] tableModelList4 = new String[20];
			tableModelList4[0] = "701007"; // "701007（サービス種類コード）"
			tableModelList4[1] = "701008"; // "701008（サービス実日数）"
			tableModelList4[2] = "701009"; // "701009（計画単位数）"
			tableModelList4[3] = "701010"; // "701010（限度額管理対象単位数）"
			tableModelList4[4] = "701011"; // "701011（限度額管理対象外単位数）"
			tableModelList4[5] = "701012"; // "701012（短期入所計画日数）"
			tableModelList4[6] = "701013"; // "701013（短期入所実日数）"
			tableModelList4[7] = "701014"; // "701014（保険単位数合計）"
			tableModelList4[8] = "701015"; // "701015（保険単位数単価）"
			tableModelList4[9] = "701016"; // "701016（保険請求額）"
			tableModelList4[10] = "701017"; // "701017（保険利用者負担額）"
			tableModelList4[11] = "701019"; // "701019（公費1請求額）"
			tableModelList4[12] = "701020"; // "701020（公費1本人負担額）"
			tableModelList4[13] = "701022"; // "701022（公費2請求額）"
			tableModelList4[14] = "701023"; // "701023（公費2本人負担額）"
			tableModelList4[15] = "701025"; // "701025（公費3請求額）"
			tableModelList4[16] = "701026"; // "701026（公費3本人負担額）"
			tableModelList4[17] = "701027"; // "701027（保険分出来高医療費単位数合計）"
			tableModelList4[18] = "701028"; // "701028（保険分出来高医療費請求額）"
			tableModelList4[19] = "701029"; // "701029（保険分出来高医療費出来高医療費利用者負担額）"

			// 格納
			setTableModelList4(new ACTableModelAdapter());
			getTableModelList4().setColumns(tableModelList4);

			// tableModelList4を集計情報テーブル（totalInfoTable）に設定する。
			getTotalInfoTable().setModel(getTableModelList4());

			// tableModelDetail4を以下のフィールドで設定する。
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail4 = new String[3];
			tableModelDetail4[0] = "DETAIL_NAME";
			tableModelDetail4[1] = "DETAIL_VALUE";
			tableModelDetail4[2] = "COMMENT";

			// 格納
			setTableModelDetail4(new ACTableModelAdapter());
			getTableModelDetail4().setColumns(tableModelDetail4);
			// tableModelDetail4を集計情報詳細テーブル（totalInfoRevisionTable）に設定する。
			getTotalInfoRevisionTable().setModel(getTableModelDetail4());

			// ※キャプションの設定
			// 以下のラベルのキャプションに "集計情報" を設定する。
			// totalInfos
			// totalInfoLabel
			// totalInfoRevision
			getEtcInfoTabs().setTitleAt(3, "集計情報");
			getTotalInfoLabel().setText("集計情報");
			getTotalInfoRevision().setText("集計情報");
		}
		// 第一引数と00000100（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 4) == 0)) {
			// ※特定入所者介護費情報テーブルと特定入所者介護費情報詳細テーブルのテーブルモデルの設定。
			// tableModelList5を以下のフィールドで設定する。
			String[] tableModelList5 = new String[27];
			tableModelList5[0] = "801007"; // "801007（レコード順次番号）"
			tableModelList5[1] = "801008+''+801009"; // "801008+801009"
			tableModelList5[2] = "801034"; // "801034（サービス名称）"
			tableModelList5[3] = "801010"; // "801010（費用単価）"
			tableModelList5[4] = "801011"; // "801011（負担限度額）"
			tableModelList5[5] = "801012"; // "801012（日数）"
			tableModelList5[6] = "801013"; // "801013（公費1日数）"
			tableModelList5[7] = "801014"; // "801014（公費2日数）"
			tableModelList5[8] = "801015"; // "801015（公費3日数）"
			tableModelList5[9] = "801016"; // "801016（費用額）"
			tableModelList5[10] = "801017"; // "801017（保険分請求額）"
			tableModelList5[11] = "801018"; // "801018（公費1負担額明細）"
			tableModelList5[12] = "801019"; // "801019（公費2負担額明細）"
			tableModelList5[13] = "801020"; // "801020（公費3負担額明細）"
			tableModelList5[14] = "801021"; // "801021（利用者負担額）"
			tableModelList5[15] = "801022"; // "801022（費用額合計）"
			tableModelList5[16] = "801023"; // "801023（保険分請求額合計）"
			tableModelList5[17] = "801024"; // "801024（利用者負担額合計）"
			tableModelList5[18] = "801025"; // "801025（公費1負担額合計）"
			tableModelList5[19] = "801026"; // "801026（公費1請求額）"
			tableModelList5[20] = "801027"; // "801027（公費1本人負担月額）"
			tableModelList5[21] = "801028"; // "801028（公費2負担額合計）"
			tableModelList5[22] = "801029"; // "801029（公費2請求額）"
			tableModelList5[23] = "801030"; // "801030（公費2本人負担月額）"
			tableModelList5[24] = "801031"; // "801031（公費3負担額合計）"
			tableModelList5[25] = "801032"; // "801032（公費3請求額）"
			tableModelList5[26] = "801033"; // "801033（公費3本人負担月額）"

			// 格納
			setTableModelList5(new ACTableModelAdapter());
			getTableModelList5().setColumns(tableModelList5);

			// tableModelList5を特定入所者介護費情報テーブル（nyushoInfoTable）に設定する。
			getNyushoInfoTable().setModel(getTableModelList5());

			// tableModelDetail5を以下のフィールドで設定する。
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail5 = new String[3];
			tableModelDetail5[0] = "DETAIL_NAME";
			tableModelDetail5[1] = "DETAIL_VALUE";
			tableModelDetail5[2] = "COMMENT";

			// 格納
			setTableModelDetail5(new ACTableModelAdapter());
			getTableModelDetail5().setColumns(tableModelDetail5);

			// tableModelDetail5を特定入所者介護費情報詳細テーブル（nyushoInfoRevisionTable）に設定する。
			getNyushoInfoRevisionTable().setModel(getTableModelDetail5());

			// ※キャプションの設定
			// 以下のラベルのキャプションに "特定入所者介護費情報" を設定する。
			// nyushoInfos
			// nyushoInfoLabel
			// nyushoInfoRevision
			getEtcInfoTabs().setTitleAt(4, "特定入所者介護費情報");
			getNyushoInfoLabel().setText("特定入所者介護費情報");
			getNyushoInfoRevision().setText("特定入所者介護費情報");
		}

		// 第一引数と00000010（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 2) == 0)) {
			// ※社会福祉法人軽減額情報テーブルと社会福祉法人軽減額情報詳細テーブルのテーブルモデルの設定。
			// tableModelList6を以下のフィールドで設定する。
			String[] tableModelList6 = new String[6];
			tableModelList6[0] = "901007"; // "901007（軽減率）"
			tableModelList6[1] = "901008"; // "901008（サービス種類コード）"
			tableModelList6[2] = "901009"; // "901009（受領すべき利用者負担の総額）"
			tableModelList6[3] = "901010"; // "901010（軽減額）"
			tableModelList6[4] = "901011"; // "901011（軽減後利用者負担額）"
			tableModelList6[5] = "901012"; // "901012（備考）"

			// 格納
			setTableModelList6(new ACTableModelAdapter());
			getTableModelList6().setColumns(tableModelList6);

			// tableModelList6を社会福祉法人軽減額情報テーブル（shahukuInfoTable）に設定する。
			getShahukuInfoTable().setModel(getTableModelList6());

			// tableModelDetail6を以下のフィールドで設定する。
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail6 = new String[3];
			tableModelDetail6[0] = "DETAIL_NAME";
			tableModelDetail6[1] = "DETAIL_VALUE";
			tableModelDetail6[2] = "COMMENT";

			// 格納
			setTableModelDetail6(new ACTableModelAdapter());
			getTableModelDetail6().setColumns(tableModelDetail6);

			// tableModelDetail6を社会福祉法人軽減額情報詳細テーブル（shahukuInfoRevisionTable）に設定する。
			getShahukuInfoRevisionTable().setModel(getTableModelDetail6());

			// ※キャプションの設定
			// 以下のラベルのキャプションに "社会福祉法人軽減情報" を設定する。
			// shahukuInfos
			// shahukuInfoLabel
			// shahukuInfoRevision
			getEtcInfoTabs().setTitleAt(5, "社会福祉法人軽減情報");
			getShahukuInfoLabel().setText("社会福祉法人軽減情報");
			getShahukuInfoRevisionLabel().setText("社会福祉法人軽減情報");
		}

		// 第一引数と00000001（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 1) == 0)) {
			// ※居宅介護支援明細情報テーブルと明細情報詳細テーブルのテーブルモデルの設定。
			// tableModelList2を以下のフィールドで設定する。

			//[ID:0000452][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
			/*
			String[] tableModelList2 = new String[17];
			tableModelList2[0] = "1001002"; // "1001002（事業所番号）"
			tableModelList2[1] = "1001003"; // "1001003（指定/基準該当等事業所区分コード）"
			tableModelList2[2] = "1001004"; // "1001004（サービス提供年月）"
			tableModelList2[3] = "1001005"; // "1001005（保険者番号）"
			tableModelList2[4] = "1001006"; // "1001006（単位数単価）"
			tableModelList2[5] = "1001007"; // "1001007（被保険者番号）"
			tableModelList2[6] = "1001008"; // "1001008（公費負担者番号）"
			tableModelList2[7] = "1001009"; // "1001009（公費受給者番号）"
			tableModelList2[8] = "1001010"; // "1001010（生年月日）"
			tableModelList2[9] = "1001011"; // "1001011（性別コード）"
			tableModelList2[10] = "1001012"; // "1001012（要介護状態区分コード）"
			tableModelList2[11] = "1001013"; // "1001013（認定有効期間開始)"
			tableModelList2[12] = "1001014"; // "1001014（認定有効期間終了)"
			tableModelList2[13] = "1001015"; // "1001015（居宅サービス計画作成依頼届出年月日）"
			tableModelList2[14] = "1001016"; // "1001016（サービスコード）"
			tableModelList2[15] = "1001017"; // "1001017（単位数）"
			tableModelList2[16] = "1001018"; // "1001018（請求金額）"
			*/
			String[] tableModelList2 = new String[10];
			tableModelList2[0] = "1001010"; // "1001010 (生年月日)"
			tableModelList2[1] = "1001011"; // "1001011 (性別コード)"
			tableModelList2[2] = "1001012"; // "1001012 (要介護状態区分コード)"
			tableModelList2[3] = "1001013"; // "1001013 (認定有効期間開始日)"
			tableModelList2[4] = "1001014"; // "1001014 (認定有効期間終了日)"
			tableModelList2[5] = "1001015"; // "1001015 (居宅サービス計画作成依頼届出年月日)"
			tableModelList2[6] = "1001016"; // "1001016 (サービスコード)"
			tableModelList2[7] = "1001028"; // "1001028 (サービス名称)"
			tableModelList2[8] = "1001017"; // "1001017 (単位数)"
			tableModelList2[9] = "1001018"; // "1001018 (請求金額)"
			//[ID:0000452][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応

			// 格納
			setTableModelList2(new ACTableModelAdapter());
			getTableModelList2().setColumns(tableModelList2);

			// tableModelList2を明細情報テーブル（detailsInfoTable）に設定する。
			//[ID:0000452][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
			//設計書の誤りを修正
			//getDetailsInfoTable().setModel(getTableModelList2());
			getKyotakuDetailsInfoTable().setModel(getTableModelList2());
			//[ID:0000452][Shin Fujihara] 2009/02 edit end 平成21年4月法改正対応
			
			// tableModelDetail2を以下のフィールドで設定する。
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail2 = new String[3];
			tableModelDetail2[0] = "DETAIL_NAME";
			tableModelDetail2[1] = "DETAIL_VALUE";
			tableModelDetail2[2] = "COMMENT";

			// 格納
			setTableModelDetail2(new ACTableModelAdapter());
			getTableModelDetail2().setColumns(tableModelDetail2);

			// tableModelDetail2を明細情報詳細テーブル（detailsInfoRevisionTable）に設定する。
			getDetailsInfoRevisionTable().setModel(getTableModelDetail2());

			// ※キャプションの設定
			// 以下のラベルのキャプションに "明細情報" を設定する。
			// detailsInfos
			// detailsInfoLabel
			// detailsInfoRevision
			getEtcInfoTabs().setTitleAt(1, "明細情報");
			getDetailsInfoLabel().setText("明細情報");
			getDetailsInfoRevision().setText("明細情報");

		}
		
		//[H20.5 法改正対応] fujihara add start
		//TODO
		// 第一引数と100000000（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 256) == 0)) {
			// ※特定診療費情報テーブルと特定治療費・特定診療費情報詳細テーブルのテーブルモデルの設定。
			// tableModelList7を以下のフィールドで設定する。

			String[] tableModelList7 = new String[12];
			tableModelList7[0] = "501004"; // "501004（事業所番号）"
			tableModelList7[1] = "501007"; // "501007（レコード順次番号）"
			tableModelList7[2] = "501008"; // "501008（傷病名）"
			tableModelList7[3] = "501009"; // "501009（識別番号）"
			tableModelList7[4] = "501010"; // "501010（単位数）"
			tableModelList7[5] = "501011"; // "501011（保険回数）"
			tableModelList7[6] = "501012"; // "501012（保険サービス単位数）"
			tableModelList7[7] = "501013"; // "501013（保険合計単位数）"
			tableModelList7[8] = "501014"; // "501014（公費1回数）"
			tableModelList7[9] = "501017"; // "501017（公費2回数）"
			tableModelList7[10] = "501020"; // "501020（公費3回数）"
			tableModelList7[11] = "501023"; // "501023（摘要）"

			// 格納
			setTableModelList7(new ACTableModelAdapter());
			getTableModelList7().setColumns(tableModelList7);

			// tableModelList7を特定療養費情報テーブル（recuperationInfoTable）に設定する。
			getRecuperationInfoTable().setModel(getTableModelList7());

			// tableModelDetail3を以下のフィールドで設定する。
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail7 = new String[3];
			tableModelDetail7[0] = "DETAIL_NAME";
			tableModelDetail7[1] = "DETAIL_VALUE";
			tableModelDetail7[2] = "COMMENT";

			// 格納
			setTableModelDetail7(new ACTableModelAdapter());
			getTableModelDetail7().setColumns(tableModelDetail7);

			// tableModelDetail7を特定療養費情報詳細テーブル（recuperationInfoRevisionTable）に設定する。
			getRecuperationInfoRevisionTable().setModel(getTableModelDetail7());

		}
		//[H20.5 法改正対応] fujihara add end
		
		
		
		//緊急時施設療養費・自施設療養費情報レコード
		//※緊急時施設療養費と同じタブに表示する
		if (!((firstArg & 512) == 0)) {
            // 緊急時施設療養費・自施設療養費情報詳細テーブルのテーブルモデルの設定。
            // tableModelList3を以下のフィールドで設定する。

            String[] tableModelList3 = new String[19];
            tableModelList3[0] = "1701004"; // "1701004（事業所番号）"
            tableModelList3[1] = "1701008"; // "1701008（緊急時傷病名1）"
            tableModelList3[2] = "1701009"; // "1701009（緊急時傷病名2）"
            tableModelList3[3] = "1701010"; // "1701010（緊急時傷病名3）"
            tableModelList3[4] = "1701011"; // "1701011（緊急時治療開始年月日1）"
            tableModelList3[5] = "1701012"; // "1701012（緊急時治療開始年月日2）"
            tableModelList3[6] = "1701013"; // "1701013（緊急時治療開始年月日3）"
            tableModelList3[7] = "1701014"; // "1701014（往診日数）"
            tableModelList3[8] = "1701015"; // "1701015（往診医療機関名）"
            tableModelList3[9] = "1701016"; // "1701016（通院日数）"
            tableModelList3[10] = "1701017"; // "1701017（通院医療機関名）"
            tableModelList3[11] = "1701018"; // "1701018（緊急時治療管理単位数）"
            tableModelList3[12] = "1701019"; // "1701019（緊急時治療管理日数）"
            tableModelList3[13] = "1701020"; // "1701020（緊急時治療管理小計）"
            tableModelList3[14] = "1701021"; // "1701021(リハビリテーション点数）"
            tableModelList3[15] = "1701022"; // "1701022（処置点数）"
            tableModelList3[16] = "1701023"; // "1701023（手術点数）"
            tableModelList3[17] = "1701024"; // "1701024（麻酔点数）"
            tableModelList3[18] = "1701025"; // "1701025（放射線治療点数）"

            // 格納
            setTableModelList3(new ACTableModelAdapter());
            getTableModelList3().setColumns(tableModelList3);
            // tableModelList3を特定治療費情報テーブル（particularInfoTable）に設定する。
            getParticularInfoTable().setModel(getTableModelList3());

            // tableModelDetail3を以下のフィールドで設定する。
            // "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
            String[] tableModelDetail3 = new String[3];
            tableModelDetail3[0] = "DETAIL_NAME";
            tableModelDetail3[1] = "DETAIL_VALUE";
            tableModelDetail3[2] = "COMMENT";

            // 格納
            setTableModelDetail3(new ACTableModelAdapter());
            getTableModelDetail3().setColumns(tableModelDetail3);

            // tableModelDetail3を特定治療費・特定診療費情報詳細テーブル（particularInfoRevisionTable）に設定する。
            getParticularInfoRevisionTable().setModel(getTableModelDetail3());

            // ※キャプションの設定
            // 以下のラベルのキャプションに "特定治療費情報" を設定する。
            // particularInfos
            // particularInfoLabel
            // particularInfoRevision
            getEtcInfoTabs().setTitleAt(2, "特定治療費情報");
            getParticularInfoLabel().setText("特定治療費情報");
            getParticularInfoRevision().setText("特定治療費情報");
		}

// 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
		// 第一引数と10000000000（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 1024) == 0)) {
			// ※明細情報テーブルと明細情報詳細テーブルのテーブルモデルの設定。
			// tableModelList8を以下のフィールドで設定する。

			String[] tableModelList8 = new String[13];
			tableModelList8[0] = "1801007+''+1801008"; // "1801007+1801008"
			tableModelList8[1] = "1801020"; // "1801020（サービス名称）"
			tableModelList8[2] = "1801009"; // "1801009（単位数）"
			tableModelList8[3] = "1801010"; // "1801010（日数･回数）"
			tableModelList8[4] = "1801011"; // "1801011（公費1対象日数・回数）"
			tableModelList8[5] = "1801012"; // "1801012（公費2対象日数・回数）"
			tableModelList8[6] = "1801013"; // "1801013（公費3対象日数・回数）"
			tableModelList8[7] = "1801014"; // "1801014（サービス単位数）"
			tableModelList8[8] = "1801015"; // "1801015（公費1対象サービス単位数）"
			tableModelList8[9] = "1801016"; // "1801016（公費2対象サービス単位数）"
			tableModelList8[10] = "1801017"; // "1801017（公費3対象サービス単位数）"
			tableModelList8[11] = "1801018"; // "1801018（施設所在保険者番号）"
			tableModelList8[12] = "1801019"; // "1801019（摘要）"

			// 格納
			setTableModelList8(new ACTableModelAdapter());
			getTableModelList8().setColumns(tableModelList8);

			// tableModelList8を明細情報テーブル（detailsJushotiTokureiInfoTable）に設定する。
			getDetailsJushotiTokureiInfoTable().setModel(getTableModelList8());

			// tableModelDetail8を以下のフィールドで設定する。
			// "DETAIL_NAME" "DETAIL_VALUE" "COMMENT"
			String[] tableModelDetail8 = new String[3];
			tableModelDetail8[0] = "DETAIL_NAME";
			tableModelDetail8[1] = "DETAIL_VALUE";
			tableModelDetail8[2] = "COMMENT";

			// 格納
			setTableModelDetail8(new ACTableModelAdapter());
			getTableModelDetail8().setColumns(tableModelDetail8);

			// tableModelDetail8を明細情報詳細テーブル（detailsInfoRevisionTable）に設定する。
			getDetailsJushotiTokureiInfoRevisionTable().setModel(getTableModelDetail8());

			// ※キャプションの設定
			// 以下のラベルのキャプションに "明細情報" を設定する。
			// detailsInfos
			// detailsInfoLabel
			// detailsInfoRevision
			getEtcInfoTabs().setTitleAt(6, "明細情報（住所地特例）");
			getDetailsJushotiTokureiLabel().setText("明細情報（住所地特例）");
			getDetailsJushotiTokureiInfoRevision().setText("明細情報（住所地特例）");
		}
// 2014/12/24 [Yoichiro Kamei] add - end 
		
	}

	/**
	 * 「テーブルの各行の設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doSetTableRow(int firstArg) throws Exception {
		// 詳細テーブルの各行の設定を行う処理。
		// 第一引数と10000000（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 128) == 0)) {
			// ※基本情報詳細テーブルの各行の設定。
			// 各行のコンポーネントを生成し、引数のArrayListに格納する。
			// doMakeComponent();
			// ・第一引数：2
			// ・第二引数：detailList1
			// ・第三引数：columnList1Name
			// ・第四引数：columnList1Value
			// ・第五引数：columnList1Comment
			setDetailList1(new VRArrayList());
			setColumnList1Name(new VRArrayList());
			setColumnList1Value(new VRArrayList());
			setColumnList1Comment(new VRArrayList());
			setColumnList1NameSimple(new VRArrayList());
			setColumnList1ValueSimple(new VRArrayList());
			setColumnList1CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO2, getDetailList1(), getColumnList1Name(), getColumnList1Value(), getColumnList1Comment(), getColumnList1NameSimple(), getColumnList1ValueSimple(), getColumnList1CommentSimple());

			// ※項目名列の設定
			// columnList1NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をbasicInfoRevisionTablecolumn1に設定する。
			getBasicInfoRevisionTablecolumn1().setCustomCells(getColumnList1NameSimple());

			// ※設定値列の設定
			// columnList1ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をbasicInfoRevisionTablecolumn2に設定する。
			getBasicInfoRevisionTablecolumn2().setCustomCells(getColumnList1ValueSimple());
			// ※コメント列の設定
			// columnList1CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をbasicInfoRevisionTablecolumn3に設定する。
			getBasicInfoRevisionTablecolumn3().setCustomCells(getColumnList1CommentSimple());

		}

		// 第一引数と01000000（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 64) == 0)) {
			// ※明細情報詳細テーブルの各行の設定。
			// 各行のコンポーネントを生成し、引数のArrayListに格納する。
			// doMakeComponent();
			// ・第一引数：3
			// ・第二引数：detailList2
			// ・第三引数：columnList2Name
			// ・第四引数：columnList2Value
			// ・第五引数：columnList2Comment
			setDetailList2(new VRArrayList());
			setColumnList2Name(new VRArrayList());
			setColumnList2Value(new VRArrayList());
			setColumnList2Comment(new VRArrayList());
			setColumnList2NameSimple(new VRArrayList());
			setColumnList2ValueSimple(new VRArrayList());
			setColumnList2CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO3, getDetailList2(), getColumnList2Name(), getColumnList2Value(), getColumnList2Comment(), getColumnList2NameSimple(), getColumnList2ValueSimple(), getColumnList2CommentSimple());

			// ※項目名列の設定
			// columnList2NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をdetailsInfoRevisionTablecolumn1に設定する。
			getDetailsInfoRevisionTablecolumn1().setCustomCells(getColumnList2NameSimple());

			// ※設定値列の設定
			// columnList2ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をdetailsInfoRevisionTablecolumn2に設定する。
			getDetailsInfoRevisionTablecolumn2().setCustomCells(getColumnList2ValueSimple());

			// ※コメント列の設定
			// columnList2CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をdetailsInfoRevisionTablecolumn3に設定する。
			getDetailsInfoRevisionTablecolumn3().setCustomCells(getColumnList2CommentSimple());
		}

		// 第一引数と00100000（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 32) == 0)) {
			// ※特定治療費・特定診療費情報詳細テーブルの各行の設定。
			// 各行のコンポーネントを生成し、引数のArrayListに格納する。
			// doMakeComponent();
			// ・第一引数：4
			// ・第二引数：detailList3
			// ・第三引数：columnList3Name
			// ・第四引数：columnList3Value
			// ・第五引数：columnList3Comment
			setDetailList3(new VRArrayList());
			setColumnList3Name(new VRArrayList());
			setColumnList3Value(new VRArrayList());
			setColumnList3Comment(new VRArrayList());
			setColumnList3NameSimple(new VRArrayList());
			setColumnList3ValueSimple(new VRArrayList());
			setColumnList3CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO4, getDetailList3(), getColumnList3Name(), getColumnList3Value(), getColumnList3Comment(), getColumnList3NameSimple(), getColumnList3ValueSimple(), getColumnList3CommentSimple());

			// ※項目名列の設定
			// columnList3NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をparticularInfoRevisionTablecolumn1に設定する。
			getParticularInfoRevisionTablecolumn1().setCustomCells(getColumnList3NameSimple());

			// ※設定値列の設定
			// columnList3ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をparticularInfoRevisionTablecolumn2に設定する。
			getParticularInfoRevisionTablecolumn2().setCustomCells(getColumnList3ValueSimple());

			// ※コメント列の設定
			// columnList3CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をparticularInfoRevisionTablecolumn3に設定する。
			getParticularInfoRevisionTablecolumn3().setCustomCells(getColumnList3CommentSimple());
		}

		// 第一引数と00010000（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 16) == 0)) {
			// ※特定治療費・特定診療費情報詳細テーブルの各行の設定。
			// 各行のコンポーネントを生成し、引数のArrayListに格納する。
			// doMakeComponent();
			// ・第一引数：5
			// ・第二引数：detailList3
			// ・第三引数：columnList3Name
			// ・第四引数：columnList3Value
			// ・第五引数：columnList3Comment
			setDetailList3(new VRArrayList());
			setColumnList3Name(new VRArrayList());
			setColumnList3Value(new VRArrayList());
			setColumnList3Comment(new VRArrayList());
			setColumnList3NameSimple(new VRArrayList());
			setColumnList3ValueSimple(new VRArrayList());
			setColumnList3CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO5, getDetailList3(), getColumnList3Name(), getColumnList3Value(), getColumnList3Comment(), getColumnList3NameSimple(), getColumnList3ValueSimple(), getColumnList3CommentSimple());

			// ※項目名列の設定
			// columnList3NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をparticularInfoRevisionTablecolumn1に設定する。
			getParticularInfoRevisionTablecolumn1().setCustomCells(getColumnList3NameSimple());

			// ※設定値列の設定
			// columnList3ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をparticularInfoRevisionTablecolumn2に設定する。
			getParticularInfoRevisionTablecolumn2().setCustomCells(getColumnList3ValueSimple());

			// ※コメント列の設定
			// columnList3CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をparticularInfoRevisionTablecolumn3に設定する。
			getParticularInfoRevisionTablecolumn3().setCustomCells(getColumnList3CommentSimple());
		}

		// 第一引数と00001000（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 8) == 0)) {
			// ※集計情報詳細テーブルの各行の設定。
			// 各行のコンポーネントを生成し、引数のArrayListに格納する。
			// doMakeComponent();
			// ・第一引数：7
			// ・第二引数：detailList4
			// ・第三引数：columnList4Name
			// ・第四引数：columnList4Value
			// ・第五引数：columnList4Comment
			setDetailList4(new VRArrayList());
			setColumnList4Name(new VRArrayList());
			setColumnList4Value(new VRArrayList());
			setColumnList4Comment(new VRArrayList());
			setColumnList4NameSimple(new VRArrayList());
			setColumnList4ValueSimple(new VRArrayList());
			setColumnList4CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO7, getDetailList4(), getColumnList4Name(), getColumnList4Value(), getColumnList4Comment(), getColumnList4NameSimple(), getColumnList4ValueSimple(), getColumnList4CommentSimple());

			// ※項目名列の設定
			// columnList4NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をtotalInfoRevisionTablecolumn1に設定する。
			getTotalInfoRevisionTablecolumn1().setCustomCells(getColumnList4NameSimple());

			// ※設定値列の設定
			// columnList4ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をtotalInfoRevisionTablecolumn2に設定する。
			getTotalInfoRevisionTablecolumn2().setCustomCells(getColumnList4ValueSimple());

			// ※コメント列の設定
			// columnList4CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をtotalInfoRevisionTablecolumn3に設定する。
			getTotalInfoRevisionTablecolumn3().setCustomCells(getColumnList4CommentSimple());
		}

		// 第一引数と00000100（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 4) == 0)) {
			// ※特定入所者介護費情報詳細テーブルの各行の設定。
			// 各行のコンポーネントを生成し、引数のArrayListに格納する。
			// doMakeComponent();
			// ・第一引数：8
			// ・第二引数：detailList5
			// ・第三引数：columnList5Name
			// ・第四引数：columnList5Value
			// ・第五引数：columnList5Comment
			setDetailList5(new VRArrayList());
			setColumnList5Name(new VRArrayList());
			setColumnList5Value(new VRArrayList());
			setColumnList5Comment(new VRArrayList());
			setColumnList5NameSimple(new VRArrayList());
			setColumnList5ValueSimple(new VRArrayList());
			setColumnList5CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO8, getDetailList5(), getColumnList5Name(), getColumnList5Value(), getColumnList5Comment(), getColumnList5NameSimple(), getColumnList5ValueSimple(), getColumnList5CommentSimple());

			// ※項目名列の設定
			// columnList5NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をnyushoInfoRevisionTablecolumn1に設定する。
			getNyushoInfoRevisionTablecolumn1().setCustomCells(getColumnList5NameSimple());

			// ※設定値列の設定
			// columnList5ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をnyushoInfoRevisionTablecolumn2に設定する。
			getNyushoInfoRevisionTablecolumn2().setCustomCells(getColumnList5ValueSimple());

			// ※コメント列の設定
			// columnList5CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をnyushoInfoRevisionTablecolumn3に設定する。
			getNyushoInfoRevisionTablecolumn3().setCustomCells(getColumnList5CommentSimple());
		}

		// 第一引数と00000010（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 2) == 0)) {
			// ※社会福祉法人軽減額情報詳細テーブルの各行の設定。
			// 各行のコンポーネントを生成し、引数のArrayListに格納する。
			// doMakeComponent();
			// ・第一引数：9
			// ・第二引数：detailList6
			// ・第三引数：columnList6Name
			// ・第四引数：columnList6Value
			// ・第五引数：columnList6Comment
			setDetailList6(new VRArrayList());
			setColumnList6Name(new VRArrayList());
			setColumnList6Value(new VRArrayList());
			setColumnList6Comment(new VRArrayList());
			setColumnList6NameSimple(new VRArrayList());
			setColumnList6ValueSimple(new VRArrayList());
			setColumnList6CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO9, getDetailList6(), getColumnList6Name(), getColumnList6Value(), getColumnList6Comment(), getColumnList6NameSimple(), getColumnList6ValueSimple(), getColumnList6CommentSimple());

			// ※項目名列の設定
			// columnList6NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をshahukuInfoRevisionTablecolumn1に設定する。
			getShahukuInfoRevisionTablecolumn1().setCustomCells(getColumnList6NameSimple());

			// ※設定値列の設定
			// columnList6ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をshahukuInfoRevisionTablecolumn2に設定する。
			getShahukuInfoRevisionTablecolumn2().setCustomCells(getColumnList6ValueSimple());

			// ※コメント列の設定
			// columnList6CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をshahukuInfoRevisionTablecolumn3に設定する。
			getShahukuInfoRevisionTablecolumn3().setCustomCells(getColumnList6CommentSimple());
		}

		// 第一引数と00000001（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 1) == 0)) {
			// ※明細情報詳細テーブルの各行の設定。
			// 各行のコンポーネントを生成し、引数のArrayListに格納する。
			// doMakeComponent();
			// ・第一引数：10
			// ・第二引数：detailList2
			// ・第三引数：columnList2Name
			// ・第四引数：columnList2Value
			// ・第五引数：columnList2Comment
			setDetailList2(new VRArrayList());
			setColumnList2Name(new VRArrayList());
			setColumnList2Value(new VRArrayList());
			setColumnList2Comment(new VRArrayList());
			setColumnList2NameSimple(new VRArrayList());
			setColumnList2ValueSimple(new VRArrayList());
			setColumnList2CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO10, getDetailList2(), getColumnList2Name(), getColumnList2Value(), getColumnList2Comment(), getColumnList2NameSimple(), getColumnList2ValueSimple(), getColumnList2CommentSimple());

			// ※項目名列の設定
			// columnList2NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をdetailsInfoRevisionTablecolumn1に設定する。
			getDetailsInfoRevisionTablecolumn1().setCustomCells(getColumnList2NameSimple());

			// ※設定値列の設定
			// columnList2ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をdetailsInfoRevisionTablecolumn2に設定する。
			getDetailsInfoRevisionTablecolumn2().setCustomCells(getColumnList2ValueSimple());

			// ※コメント列の設定
			// columnList2CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をdetailsInfoRevisionTablecolumn3に設定する。
			getDetailsInfoRevisionTablecolumn3().setCustomCells(getColumnList2CommentSimple());
		}
		
		
		//[H20.5 法改正対応] fujihara add start
		// 第一引数と100000000（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 256) == 0)) {
			// ※特定治療費・特定診療費情報詳細テーブルの各行の設定。
			// 各行のコンポーネントを生成し、引数のArrayListに格納する。
			// doMakeComponent();
			// ・第一引数：5
			// ・第二引数：detailList7
			// ・第三引数：columnList7Name
			// ・第四引数：columnList7Value
			// ・第五引数：columnList7Comment
			setDetailList7(new VRArrayList());
			setColumnList7Name(new VRArrayList());
			setColumnList7Value(new VRArrayList());
			setColumnList7Comment(new VRArrayList());
			setColumnList7NameSimple(new VRArrayList());
			setColumnList7ValueSimple(new VRArrayList());
			setColumnList7CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO5, getDetailList7(), getColumnList7Name(), getColumnList7Value(), getColumnList7Comment(), getColumnList7NameSimple(), getColumnList7ValueSimple(), getColumnList7CommentSimple());

			// ※項目名列の設定
			// columnList7NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をrecuperationInfoRevisionTablecolumn1に設定する。
			getRecuperationInfoRevisionTablecolumn1().setCustomCells(getColumnList7NameSimple());

			// ※設定値列の設定
			// columnList7ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をparticularInfoRevisionTablecolumn2に設定する。
			getRecuperationInfoRevisionTablecolumn2().setCustomCells(getColumnList7ValueSimple());

			// ※コメント列の設定
			// columnList3CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をparticularInfoRevisionTablecolumn3に設定する。
			getRecuperationInfoRevisionTablecolumn3().setCustomCells(getColumnList7CommentSimple());
		}
		//[H20.5 法改正対応] fujihara add end
		
		
	      // 第一引数と1000000000（2進数表記）の論理積の値が0でない場合
        if (!((firstArg & 512) == 0)) {
            // ※緊急時施設療養・自施設療養費情報詳細テーブルの各行の設定。
            // 各行のコンポーネントを生成し、引数のArrayListに格納する。
            // doMakeComponent();
            // ・第一引数：17
            // ・第二引数：detailList3
            // ・第三引数：columnList3Name
            // ・第四引数：columnList3Value
            // ・第五引数：columnList3Comment
            setDetailList3(new VRArrayList());
            setColumnList3Name(new VRArrayList());
            setColumnList3Value(new VRArrayList());
            setColumnList3Comment(new VRArrayList());
            setColumnList3NameSimple(new VRArrayList());
            setColumnList3ValueSimple(new VRArrayList());
            setColumnList3CommentSimple(new VRArrayList());

            doMakeComponent(CATEGORY_NO17, getDetailList3(), getColumnList3Name(), getColumnList3Value(), getColumnList3Comment(), getColumnList3NameSimple(), getColumnList3ValueSimple(), getColumnList3CommentSimple());

            // ※項目名列の設定
            // columnList3NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
            // 取得したレコード集合をparticularInfoRevisionTablecolumn1に設定する。
            getParticularInfoRevisionTablecolumn1().setCustomCells(getColumnList3NameSimple());

            // ※設定値列の設定
            // columnList3ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
            // 取得したレコード集合をparticularInfoRevisionTablecolumn2に設定する。
            getParticularInfoRevisionTablecolumn2().setCustomCells(getColumnList3ValueSimple());

            // ※コメント列の設定
            // columnList3CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
            // 取得したレコード集合をparticularInfoRevisionTablecolumn3に設定する。
            getParticularInfoRevisionTablecolumn3().setCustomCells(getColumnList3CommentSimple());
        }
		
 // 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
     	// 第一引数と10000000000（2進数表記）の論理積の値が0でない場合
		if (!((firstArg & 1024) == 0)) {
			// ※明細情報詳細テーブルの各行の設定。
			// 各行のコンポーネントを生成し、引数のArrayListに格納する。
			// doMakeComponent();
			// ・第一引数：3
			// ・第二引数：detailList8
			// ・第三引数：columnList8Name
			// ・第四引数：columnList8Value
			// ・第五引数：columnList8Comment
			setDetailList8(new VRArrayList());
			setColumnList8Name(new VRArrayList());
			setColumnList8Value(new VRArrayList());
			setColumnList8Comment(new VRArrayList());
			setColumnList8NameSimple(new VRArrayList());
			setColumnList8ValueSimple(new VRArrayList());
			setColumnList8CommentSimple(new VRArrayList());

			doMakeComponent(CATEGORY_NO18, getDetailList8(), getColumnList8Name(), getColumnList8Value(), getColumnList8Comment(), getColumnList8NameSimple(), getColumnList8ValueSimple(), getColumnList8CommentSimple());

			// ※項目名列の設定
			// columnList2NameよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をdetailsJushotiTokureiInfoRevisionTablecolumn1に設定する。
			getDetailsJushotiTokureiInfoRevisionTablecolumn1().setCustomCells(getColumnList8NameSimple());

			// ※設定値列の設定
			// columnList2ValueよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をdetailsJushotiTokureiInfoRevisionTablecolumn2に設定する。
			getDetailsJushotiTokureiInfoRevisionTablecolumn2().setCustomCells(getColumnList8ValueSimple());

			// ※コメント列の設定
			// columnList2CommentよりKEY：SHOW_FLAGの値が1のレコードを取得する。
			// 取得したレコード集合をdetailsJushotiTokureiInfoRevisionTablecolumn3に設定する。
			getDetailsJushotiTokureiInfoRevisionTablecolumn3().setCustomCells(getColumnList8CommentSimple());
		}
// 2014/12/24 [Yoichiro Kamei] add - end
		
	}

	/**
	 * 「各行のコンポーネントを生成」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doMakeComponent(int categoryNo, VRList detailList, VRList columnListName, VRList columnListValue, VRList columnListComment, VRList columnListNameSimple, VRList columnListValueSimple, VRList columnListCommentSimple) throws Exception {
		// 詳細テーブルの各行のコンポーネントを生成して追加する処理。
		// 以下、引数を下記の名前で呼ぶ。
		// ・第一引数：categoryNo
		// ・第ニ引数：detailList
		// ・第三引数：columnListName
		// ・第四引数：columnListValue
		// ・第五引数：columnListComment
		// ・第六引数：columnListNameSimple
		// ・第七引数：columnListValueSimple
		// ・第八引数：columnListCommentSimple

		// detailCommentListを順に見ていく。（ループ開始）
		Iterator detaiDataListIterator = getDetailCommentList().iterator();
		while (detaiDataListIterator.hasNext()) {
			VRMap detailDataMap = (VRMap) detaiDataListIterator.next();
			detailDataMap = new DetailValueAdapter(detailDataMap);

			if (new Integer(categoryNo).equals(detailDataMap.getData("CATEGORY_NO"))) {
				// レコードのCATEGORY_NOの値がcategoryNoと等しい場合
				// ACTableCellViewerCustomCellを生成する。（以下、cellNameとする）
				// ACTableCellViewerCustomCellを生成する。（以下、cellValueとする）
				// ACTableCellViewerCustomCellを生成する。（以下、cellCommentとする）
				ACTableCellViewerCustomCell cellName = new ACTableCellViewerCustomCell();
				ACTableCellViewerCustomCell cellValue = new ACTableCellViewerCustomCell();
				ACTableCellViewerCustomCell cellComment = new ACTableCellViewerCustomCell();

				if (new Integer(OFF).equals(detailDataMap.getData("EDITABLE_FLAG"))) {
					// レコードのEDITABLE_FLAGが0（編集不可）の場合
					// ラベルを生成する。
					// ラベルの背景色を灰色に設定する。
					ACLabel grayLabel = new ACLabel();
					grayLabel.setBackground(Color.lightGray);

					// cellNameのrendererに生成したラベルを設定する。
					cellName.setRenderer(grayLabel);

					// cellValueのrendererに生成したラベルを設定する。
					cellValue.setRenderer(grayLabel);

					// cellCommentのrendererに生成したラベルを設定する。
					cellComment.setRenderer(grayLabel);

					// cellNameのIgnoreSelectColorにtrueを設定する。
					cellName.setIgnoreSelectColor(true);

					// cellValueのIgnoreSelectColorにtrueを設定する。
					cellValue.setIgnoreSelectColor(true);

					// cellCommentのIgnoreSelectColorにtrueを設定する。
					cellComment.setIgnoreSelectColor(true);

				} else if (new Integer(ON).equals(detailDataMap.getData("EDITABLE_FLAG"))) {

					// レコードのEDITABLE_FLAGが1（編集可）の場合
					// cellValueのeditableにtrueを設定する。
					cellValue.setEditable(true);

					// テキストを生成する。
					ACTextField valueTextField = new ACTextField();
					ACLabel valueLabel = new ACLabel();

					// 最大桁数をレコードのMAX_LENGTHの値に設定する。
					valueTextField.setMaxLength(ACCastUtilities.toInt(detailDataMap.getData("MAX_LENGTH")));
					valueTextField.setByteMaxLength(true);
					
					switch (ACCastUtilities.toInt(detailDataMap.getData("CHAR_TYPE"))) {
						// レコードのCHAR_TYPEの値が1の場合
						// 半角数字のみ入力可能に設定する。
						case 1:
							valueTextField.setCharType(VRCharType.ONLY_DIGIT);
							break;

						// レコードのCHAR_TYPEの値が2の場合
						// 半角数字のみ（負値含む）入力可能に設定する。
						case 2:
							valueTextField.setCharType(VRCharType.ONLY_NUMBER);
							break;
						// レコードのCHAR_TYPEの値が3の場合
						// 半角英数字のみ入力可能に設定する。

						case 3:
							valueTextField.setCharType(VRCharType.ONLY_ALNUM);
							break;

						// レコードのCHAR_TYPEが4の場合
						// 小数も入力可能に設定する。
						case 4:
							valueTextField.setCharType(VRCharType.ONLY_FLOAT);
							break;

						// レコードのCHAR_TYPEが5の場合
						// IMEモードをKANJIに設定する。
						case 5:
							valueTextField.setIMEMode(InputSubset.KANJI);
							break;

						default:
							break;
					}

					int commentAlignment = ACCastUtilities.toInt(detailDataMap.getData("ALIGNMENT"));
					switch (commentAlignment) {
						// レコードのALIGNMENTの値が1の場合
						// アライメントを左寄せに設定する。
						case 1:

							valueTextField.setHorizontalAlignment(SwingConstants.LEFT);
							valueLabel.setHorizontalAlignment(SwingConstants.LEFT);
							break;
						// レコードのALIGNMENTの値が2の場合
						// アライメントを右寄せに設定する。
						case 2:
							valueTextField.setHorizontalAlignment(SwingConstants.RIGHT);
							valueLabel.setHorizontalAlignment(SwingConstants.RIGHT);
							break;
						default:
							break;
					}

					// V4.5.8対応
					int commentId = ACCastUtilities.toInt(detailDataMap.getData("COMMENT_ID"));
					switch(categoryNo){
					case 4:
						switch(commentId){
						case 6://緊急時傷病名１
						case 7://緊急時傷病名２
						case 8://緊急時傷病名３
						case 13://往診医療機関
						case 15://通院医療機関
						case 24://摘要欄（緊急時）
						case 25://摘要欄（緊急時）
						case 26://摘要欄（緊急時）
						case 27://摘要欄（緊急時）
						case 28://摘要欄（緊急時）
						case 29://摘要欄（緊急時）
						case 30://摘要欄（緊急時）
						case 31://摘要欄（緊急時）
						case 32://摘要欄（緊急時）
						case 33://摘要欄（緊急時）
						case 34://摘要欄（緊急時）
						case 35://摘要欄（緊急時）
						case 36://摘要欄（緊急時）
						case 37://摘要欄（緊急時）
						case 38://摘要欄（緊急時）
						case 39://摘要欄（緊急時）
						case 40://摘要欄（緊急時）
						case 41://摘要欄（緊急時）
						case 42://摘要欄（緊急時）
						case 43://摘要欄（緊急時）
							valueTextField.setConvertToCharacter(ACCharacterConverter.TO_WIDE_CHAR);
							valueTextField.setIMEMode(InputSubset.KANJI);
							break;
						}
						break;
					case 5:
						switch(commentId){
						case 6://傷病名（特定診療費）
						case 21://摘要欄（特定診療費）
							valueTextField.setConvertToCharacter(ACCharacterConverter.TO_WIDE_CHAR);
							valueTextField.setIMEMode(InputSubset.KANJI);
							break;
						}
						break;
					case 9:
						switch(commentId){
						case 10://備考（社福）
							valueTextField.setCharType(VRCharType.ONLY_HALF_CHAR);
							valueTextField.setConvertToCharacter(ACCharacterConverter.TO_HALF_CHAR|ACCharacterConverter.TO_HALF_KATAKANA);
							valueTextField.setIMEMode(InputSubset.KANJI);
							break;
						}
						break;
					}
					
					// cellValueのeditorに生成したテキストを設定する。
					cellValue.setEditor(valueTextField);
					cellValue.setRenderer(valueLabel);
				}
				
				// detailListにレコードを追加する。
				detailList.add(detailDataMap);

				if (new Integer(ON).equals(detailDataMap.getData("SHOW_FLAG"))) {
					// cellNameをcolumnListNameSimpleに追加する。
					columnListNameSimple.add(cellName);
					// cellValueをcolumnListValueSimpleに追加する。
					columnListValueSimple.add(cellValue);
					// cellCommentをcolumnListCommentSimpleに追加する。
					columnListCommentSimple.add(cellComment);
				}
				// cellNameをcolumnListNameに追加する。
				columnListName.add(cellName);
				// cellValueをcolumnListValueに追加する。
				columnListValue.add(cellValue);
				// cellCommentをcolumnListCommentに追加する。
				columnListComment.add(cellComment);
			}
		}
	}

	/**
	 * 「請求データを画面テーブルに設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doSetClaimData() throws Exception {

		if (!getTableClaimList1().isEmpty()) {
			// tableClaimList1がnullでない場合
			// ソートする。
			// 201017 認定有効期間開始年月日
			String[] keys = new String[]{"201017"};
			setTableClaimList1(getSortedData(getTableClaimList1(), keys));
			// tableClaimList1をtableModelList1に設定する
			getTableModelList1().setAdaptee(getTableClaimList1());
			// バインド先のBasicInfoTableの1行目を選択した状態にする。
			getBasicInfoTable().setSelectedSortedFirstRow();
		}

		if (!getTableClaimList2().isEmpty()) {
			// tableClaimList2がnullでない場合
			// ソートする。
			switch(getClaimStyleType()){
			case FORMAT_STYLE7:
			case FORMAT_STYLE72:
				break;
			default:
				// 301007 サービス種類コード + 301008 サービス項目コード
				String[] keys = new String[]{"301007", "301008", "301009", "301014"};
				int[] digits = new int[]{0, 0, 4, 6};
				setTableClaimList2(getSortedData(getTableClaimList2(), keys, digits));
				break;
			}
			// tableClaimList2をtableModelList2に設定する。
			getTableModelList2().setAdaptee(getTableClaimList2());
			// バインド先のDetailsInfoTableの1行目を選択した状態にする。
			getDetailsInfoTable().setSelectedSortedFirstRow();
			getKyotakuDetailsInfoTable().setSelectedSortedFirstRow();
		}

		if (!getTableClaimList3().isEmpty()) {
			// tableClaimList3がnullでない場合
			// ソートする。
			switch(getClaimStyleType()){
			case FORMAT_STYLE4:
			case FORMAT_STYLE42:
			case FORMAT_STYLE9:
				break;
			case FORMAT_STYLE5:
			case FORMAT_STYLE52:
			case FORMAT_STYLE10:
				// 501007 特定診療費情報レコード順次番号2桁
				String[] keys = new String[]{"501007"};
				int[] digits = new int[]{2};
				setTableClaimList3(getSortedData(getTableClaimList3(), keys, digits));
				break;
			}
			// tableClaimList3をtableModelList3に設定する。
			getTableModelList3().setAdaptee(getTableClaimList3());
			// バインド先のParticularInfoTableの1行目を選択した状態にする。
			getParticularInfoTable().setSelectedSortedFirstRow();
			getSpecialClinicInfoTable().setSelectedSortedFirstRow();
		}

		if (!getTableClaimList4().isEmpty()) {
			// tableClaimList4がnullでない場合 
			// ソートする。
			// 701007 サービス種類コード
			String[] keys = new String[]{"701007"};
			setTableClaimList4(getSortedData(getTableClaimList4(), keys));
			// tableClaimList4をtableModelList4に設定する。
			getTableModelList4().setAdaptee(getTableClaimList4());
			// バインド先のTotalInfoTableの1行目を選択した状態にする。
			getTotalInfoTable().setSelectedSortedFirstRow();
		}

		if (!getTableClaimList5().isEmpty()) {
			// tableClaimList5がnullでない場合
			// ソートする。
			// 801007 特定入所者介護サービス費用情報レコード順次番号2桁
			String[] keys = new String[]{"801007"};
			int[] digits = new int[]{2};
			setTableClaimList5(getSortedData(getTableClaimList5(), keys, digits));
			// tableClaimList5をtableModelList5に設定する。
			getTableModelList5().setAdaptee(getTableClaimList5());
			// バインド先のNyushoInfoTableの1行目を選択した状態にする。
			getNyushoInfoTable().setSelectedSortedFirstRow();
		}

		if (!getTableClaimList6().isEmpty()) {
			// tableClaimList6がnullでない場合
			// ソートする。
			// 901008 サービス種類コード2桁
			String[] keys = new String[]{"901008"};
			setTableClaimList6(getSortedData(getTableClaimList6(), keys));
			// tableClaimList6をtableModelList6に設定する。
			getTableModelList6().setAdaptee(getTableClaimList6());
			// バインド先のShahukuInfoTableの1行目を選択した状態にする。
			getShahukuInfoTable().setSelectedSortedFirstRow();
		}
		
		//[H20.5 法改正対応] fujihara add start
		if (!getTableClaimList7().isEmpty()) {
			// tableClaimList7がnullでない場合
			// ソートする。
			// 501007 特定療養費情報レコード順次番号2桁
			String[] keys = new String[]{"501007"};
			int[] digits = new int[]{2};
			setTableClaimList7(getSortedData(getTableClaimList7(), keys, digits));
			
			// tableClaimList7をtableModelList7に設定する。
			getTableModelList7().setAdaptee(getTableClaimList7());
			// バインド先のParticularInfoTableの1行目を選択した状態にする。
			getParticularInfoTable().setSelectedSortedFirstRow();
			//[ID:0000429][Shin Fujihara] 2009/07 add begin 2009年度対応
			//既存障害　先頭行を表示する
			getRecuperationInfoTable().setSelectedSortedFirstRow();
			//[ID:0000429][Shin Fujihara] 2009/07 add end 2009年度対応
			getRecuperationInfoRevisionTable().setSelectedSortedFirstRow();
		}
		//[H20.5 法改正対応] fujihara add end

// 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
		if (!getTableClaimList8().isEmpty()) {
			// tableClaimList8がnullでない場合
			// ソートする。
			switch(getClaimStyleType()){
			case FORMAT_STYLE7:
			case FORMAT_STYLE72:
				break;
			default:
				// 301007 サービス種類コード + 301008 サービス項目コード
				String[] keys = new String[]{"1801007", "1801008", "1801009", "1801014"};
				int[] digits = new int[]{0, 0, 4, 6};
				setTableClaimList8(getSortedData(getTableClaimList8(), keys, digits));
				break;
			}
			// tableClaimList8をtableModelList8に設定する。
			getTableModelList8().setAdaptee(getTableClaimList8());
			// バインド先のDetailsJushotiTokureiInfoTableの1行目を選択した状態にする。
			getDetailsJushotiTokureiInfoTable().setSelectedSortedFirstRow();
		}
// 2014/12/24 [Yoichiro Kamei] add - end
	}

	/**
	 * 「請求データのソート」に関する処理を行います。
	 * @param list 対象レコード集合
	 * @param keys ソートキー
	 * @return ソートされたレコード集合
	 * @throws Exception
	 */
	public VRList getSortedData(VRList list, String[] keys) throws Exception {
		
		int num = keys.length;
		int[] digits = new int[num];
		
		for(int i = 0; i < num; i++){
			digits[i] = 0;
		}
		
		return getSortedData(list, keys, digits);
		
	}

	/**
	 * 「請求データのソート」に関する処理を行います。
	 * @param list 対象レコード集合
	 * @param keys ソートキー
	 * @param digits 指定桁数
	 * @return ソートされたレコード集合
	 * @throws Exception
	 */
	public VRList getSortedData(VRList list, String[] keys, int[] digits) throws Exception {
		
		// VRList resultを生成する。
		VRList result = new VRArrayList();
		// TreeMap map を生成する。
		TreeMap map = new TreeMap();
		// 渡されたlistをループする。（以下、各要素をrecordとする。）
		for(int i = 0; i < list.size(); i++){
			VRMap record = (VRMap)list.get(i);
			// String newKeyを生成する。
			String newKey = "";
			// 渡されたkeysをループする。（以下、各要素をkeyとする。）
			for(int j = 0; j < keys.length; j++){
				// recordより、KEY：keyの値を取り出し、Stringに変換する。
				String temp = ACCastUtilities.toString(VRBindPathParser.get(keys[j], record));
				// newKeyの末尾に追加する。
				newKey += getStringOnSpecifiedDigit(temp, digits[j]);
			}
			// recordをKEY：newKeyとして、mapに追加する。
			//del start 2006.6.14 fujihara.shin
			//map.put(newKey, record);
			//del end 2006.6.14 fujihara.shin
			//add start 2006.6.14 fujihara.shin
			int esc = 0;
			while(true){
				if(!map.containsKey(newKey + esc)){
					map.put(newKey + esc, record);
					break;
				}
				esc++;
			}
			//add end 2006.6.14 fujihara.shin
		}
		// mapをlistに戻す。
		result.addAll(map.values());
		return result;
		
	}
	
	/**
	 * 指定桁数まで0埋めする関数
	 * @param temp 対象文字列
	 * @param digit 指定桁数
	 * @return 0埋めされた文字列
	 */
	public String getStringOnSpecifiedDigit(String temp, int digit){
		
		if(digit <= 0){
			return temp;
		}
		
		String head = "";
		int num = digit - temp.length();
		
		for(int i = 0; i < num; i++){
			head += "0";
		}
		
		return head + temp;
		
	}
	
	/**
	 * 「詳細テーブル表示用データ作成」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doMakeDetailTableList(VRMap claimData, VRList detailList) throws Exception {
		// 以下、渡された引数を下記の名前で呼ぶ。
		// ・第一引数：claimData
		// ・第二引数：detailList

		// detailListを順に見ていく。（ループ開始）
		Iterator detailListIterator = detailList.iterator();
		while (detailListIterator.hasNext()) {
			// detailListのレコードのSYSTEM_BIND_PATHをKEYとする値をclaimDataから取得する。
			VRMap detailMap = (VRMap) detailListIterator.next();
			// 取得したデータを以下のKEYでdetailListのレコードに追加する。
			// ・KEY：DETAIL_VALUE

			// TODO 参照転記用のパス設定
			if (detailMap instanceof DetailValueAdapter) {
				((DetailValueAdapter) detailMap).setAdaptee(claimData);
				((DetailValueAdapter) detailMap).setPath(ACCastUtilities.toString(detailMap.getData("SYSTEM_BIND_PATH")));
			}

			// if(("null").equals(claimData.getData(ACCastUtilities.toString(detailMap.getData("SYSTEM_BIND_PATH"))))){
			// detailMap.setData("DETAIL_VALUE", "");
			// }

			if (ACTextUtilities.isNullText(claimData.getData(ACCastUtilities.toString(detailMap.getData("SYSTEM_BIND_PATH"))))) {
				detailMap.setData("DETAIL_VALUE", "");
			} else {
				detailMap.setData("DETAIL_VALUE", claimData.getData(ACCastUtilities.toString(detailMap.getData("SYSTEM_BIND_PATH"))));
			}
		}
	}

	private class DetailValueAdapter extends VRHashMap {
		// TODO 詳細と本体の相互参照用アダプタマップクラス
		public Object put(Object key, Object value) {
			if ((adaptee != null) && (path != null)) {
				try {
					if ("DETAIL_VALUE".equals(ACCastUtilities.toString(key))) {
						adaptee.put(path, value);
					}
				} catch (Exception ex) {
				}
			}

			return super.put(key, value);
		}

		private String path;

		private Map adaptee;

		public DetailValueAdapter(Map adaptee) {
			super(adaptee);
			this.adaptee = adaptee;
		}

		public DetailValueAdapter(Map adaptee, String path) {
			this(adaptee);
			this.path = path;
		}

		/**
		 * path を返します。
		 * 
		 * @return path
		 */
		public String getPath() {
			return path;
		}

		/**
		 * path を設定します。
		 * 
		 * @param path
		 *            path
		 */
		public void setPath(String path) {
			this.path = path;
		}

		/**
		 * adaptee を返します。
		 * 
		 * @return adaptee
		 */
		public Map getAdaptee() {
			return adaptee;
		}

		/**
		 * adaptee を設定します。
		 * 
		 * @param adaptee
		 *            adaptee
		 */
		public void setAdaptee(Map adaptee) {
			this.adaptee = adaptee;
		}
	}

	/**
	 * 「詳細テーブル表示」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doShowClaimDetail(String recordDataType) throws Exception {
		// 渡された引数の値が"BASIC"の場合
		if (recordDataType.equals("BASIC")) {
			// 基本情報テーブルで選択されている行のレコード（以下、選択レコード）を取得する。
			if (getBasicInfoRevisionCheck().isSelected()) {
				// 全ての情報を表示チェックボックス（basicInfoRevisionCheck）がオンになっている場合
				// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
				if (!(getDetailList1().isEmpty())) {
					doMakeDetailTableList((VRMap) getBasicInfoTable().getSelectedModelRowValue(), getDetailList1());
					// ・第一引数：選択レコード
					// ・第二引数：detailList1

					// detailList1をテーブルモデル（tableModelDetail1）に設定する。
					getTableModelDetail1().setAdaptee(getDetailList1());
				}
			} else {
				// 全ての情報を表示チェックボックス（basicInfoRevisionCheck）がオフになっている場合
				// detailList1よりKEY：SHOW_FLAGの値が1のレコードを取得する。（以下、tempList）
				if (!(getDetailList1().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList1(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
					doMakeDetailTableList((VRMap) getBasicInfoTable().getSelectedModelRowValue(), tempList);
					// ・第一引数：選択レコード
					// ・第二引数：tempList

					// tempListをテーブルモデル（tableModelDetail1）に設定する。
					getTableModelDetail1().setAdaptee(tempList);
				}
			}
		}

		// 渡された引数の値が"DETAIL"の場合
		if (recordDataType.equals("DETAIL")) {
			// 明細情報テーブルで選択されている行のレコード（以下、選択レコード）を取得する。
			if (getDetailsInfoRevisionCheck().isSelected()) {
				// 全ての情報を表示チェックボックス（detailsInfoRevisionCheck）がオンになっている場合
				// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
				if (!(getDetailList2().isEmpty())) {
					doMakeDetailTableList((VRMap) getDetailsInfoTable().getSelectedModelRowValue(), getDetailList2());
					// ・第一引数：選択レコード
					// ・第二引数：detailList2

					// detailList2をテーブルモデル（tableModelDetail2）に設定する。
					getTableModelDetail2().setAdaptee(getDetailList2());
				}

			} else {
				// 全ての情報を表示チェックボックス（detailsInfoRevisionCheck）がオフになっている場合
				// detailList2よりKEY：SHOW_FLAGの値が1のレコードを取得する。（以下、tempList）
				if (!(getDetailList2().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList2(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
					doMakeDetailTableList((VRMap) getDetailsInfoTable().getSelectedModelRowValue(), tempList);
					// ・第一引数：選択レコード
					// ・第二引数：tempList

					// tempListをテーブルモデル（tableModelDetail2）に設定する。
					getTableModelDetail2().setAdaptee(tempList);
				}
			}
		}

		// 渡された引数の値が"KYOTAKU"の場合
		if (recordDataType.equals("KYOTAKU")) {
			// 居宅介護支援明細情報テーブルで選択されている行のレコード（以下、選択レコード）を取得する。
			if (getDetailsInfoRevisionCheck().isSelected()) {
				// 全ての情報を表示チェックボックス（detailsInfoRevisionCheck）がオンになっている場合
				// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
				if (!(getDetailList2().isEmpty())) {
					doMakeDetailTableList((VRMap) getKyotakuDetailsInfoTable().getSelectedModelRowValue(), getDetailList2());
					// ・第一引数：選択レコード
					// ・第二引数：detailList2

					// detailList2をテーブルモデル（tableModelDetail2）に設定する。
					getTableModelDetail2().setAdaptee(getDetailList2());
				}
				// setAdaptee();
			} else {
				// 全ての情報を表示チェックボックス（detailsInfoRevisionCheck）がオフになっている場合
				// detailList2よりKEY：SHOW_FLAGの値が1のレコードを取得する。（以下、tempList）
				if (!(getDetailList2().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList2(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
					doMakeDetailTableList((VRMap) getKyotakuDetailsInfoTable().getSelectedModelRowValue(), tempList);
					// ・第一引数：選択レコード
					// ・第二引数：tempList

					// tempListをテーブルモデル（tableModelDetail2）に設定する。
					getTableModelDetail2().setAdaptee(tempList);
				}
			}
		}

		// 渡された引数の値が"PARTICULAR"の場合
		if (recordDataType.equals("PARTICULAR")) {
			// 特定治療費情報テーブルで選択されている行のレコード（以下、選択レコード）を取得する。
			if (getParticularInfoRevisionCheck().isSelected()) {
				// 全ての情報を表示チェックボックス（particularInfoRevisionCheck）がオンになっている場合
				// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
				if (!(getDetailList3().isEmpty())) {
					doMakeDetailTableList((VRMap) getParticularInfoTable().getSelectedModelRowValue(), getDetailList3());
					// ・第一引数：選択レコード
					// ・第二引数：detailList3

					// detailList3をテーブルモデル（tableModelDetail3）に設定する。
					getTableModelDetail3().setAdaptee(getDetailList3());
				}
			} else {
				// 全ての情報を表示チェックボックス（particularInfoRevisionCheck）がオフになっている場合
				// detailList3よりKEY：SHOW_FLAGの値が1のレコードを取得する。（以下、tempList）
				if (!(getDetailList3().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList3(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
					doMakeDetailTableList((VRMap) getParticularInfoTable().getSelectedModelRowValue(), tempList);
					// ・第一引数：選択レコード
					// ・第二引数：tempList

					// tempListをテーブルモデル（tableModelDetail3）に設定する。
					getTableModelDetail3().setAdaptee(tempList);
				}
			}
		}

		// 渡された引数の値が"SPECIAL_CLINIC"の場合
		if (recordDataType.equals("SPECIAL_CLINIC")) {
			// 特定診療費情報テーブルで選択されている行のレコード（以下、選択レコード）を取得する。
			if (getParticularInfoRevisionCheck().isSelected()) {
				// 全ての情報を表示チェックボックス（particularInfoRevisionCheck）がオンになっている場合
				// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
				if (!(getDetailList3().isEmpty())) {
					doMakeDetailTableList((VRMap) getSpecialClinicInfoTable().getSelectedModelRowValue(), getDetailList3());
					// ・第一引数：選択レコード
					// ・第二引数：detailList3

					// detailList3をテーブルモデル（tableModelDetail3）に設定する。
					getTableModelDetail3().setAdaptee(getDetailList3());
				}

			} else {
				// 全ての情報を表示チェックボックス（particularInfoRevisionCheck）がオフになっている場合
				// detailList3よりKEY：SHOW_FLAGの値が1のレコードを取得する。（以下、tempList）
				if (!(getDetailList3().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList3(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
					doMakeDetailTableList((VRMap) getSpecialClinicInfoTable().getSelectedModelRowValue(), tempList);
					// ・第一引数：選択レコード
					// ・第二引数：tempList

					// tempListをテーブルモデル（tableModelDetail3）に設定する。
					getTableModelDetail3().setAdaptee(tempList);
				}
			}
		}

		// 渡された引数の値が"TOTAL"の場合
		if (recordDataType.equals("TOTAL")) {
			// 集計情報テーブルで選択されている行のレコード（以下、選択レコード）を取得する。
			if (getTotalInfoRevisionCheck().isSelected()) {
				// 全ての情報を表示チェックボックス（totalInfoRevisionCheck）がオンになっている場合
				// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
				if (!(getDetailList4().isEmpty())) {
					doMakeDetailTableList((VRMap) getTotalInfoTable().getSelectedModelRowValue(), getDetailList4());
					// ・第一引数：選択レコード
					// ・第二引数：detailList4

					// detailList4をテーブルモデル（tableModelDetail4）に設定する。
					getTableModelDetail4().setAdaptee(getDetailList4());
				}
			} else {
				// 全ての情報を表示チェックボックス（totalInfoRevisionCheck）がオフになっている場合
				// detailList4よりKEY：SHOW_FLAGの値が1のレコードを取得する。（以下、tempList）
				if (!(getDetailList4().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList4(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
					doMakeDetailTableList((VRMap) getTotalInfoTable().getSelectedModelRowValue(), tempList);
					// ・第一引数：選択レコード
					// ・第二引数：tempList

					// tempListをテーブルモデル（tableModelDetail4）に設定する。
					getTableModelDetail4().setAdaptee(tempList);
				}
			}
		}

		// 渡された引数の値が"NYUSHO"の場合
		if (recordDataType.equals("NYUSHO")) {
			// 特定入所者介護費情報テーブルで選択されている行のレコード（以下、選択レコード）を取得する。
			if (getNyushoInfoRevisionCheck().isSelected()) {
				// 全ての情報を表示チェックボックス（nyushoInfoRevisionCheck）がオンになっている場合
				// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
				if (!(getDetailList5().isEmpty())) {
					doMakeDetailTableList((VRMap) getNyushoInfoTable().getSelectedModelRowValue(), getDetailList5());
					// ・第一引数：選択レコード
					// ・第二引数：detailList5

					// detailList5をテーブルモデル（tableModelDetail5）に設定する。
					getTableModelDetail5().setAdaptee(getDetailList5());
				}
			} else {
				// 全ての情報を表示チェックボックス（nyushoInfoRevisionCheck）がオフになっている場合
				// detailList5よりKEY：SHOW_FLAGの値が1のレコードを取得する。（以下、tempList）
				if (!(getDetailList5().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList5(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
					doMakeDetailTableList((VRMap) getNyushoInfoTable().getSelectedModelRowValue(), tempList);
					// ・第一引数：選択レコード
					// ・第二引数：tempList

					// tempListをテーブルモデル（tableModelDetail5）に設定する。
					getTableModelDetail5().setAdaptee(tempList);
				}
			}
		}

		// 渡された引数の値が"SHAHUKU"の場合
		if (recordDataType.equals("SHAHUKU")) {
			// 社会福祉法人軽減額情報テーブルで選択されている行のレコード（以下、選択レコード）を取得する。
			if (getShahukuInfoRevisionCheck().isSelected()) {
				if (!(getDetailList6().isEmpty())) {
					// 全ての情報を表示チェックボックス（shahukuInfoRevisionCheck）がオンになっている場合
					// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
					doMakeDetailTableList((VRMap) getShahukuInfoTable().getSelectedModelRowValue(), getDetailList6());
					// ・第一引数：選択レコード
					// ・第二引数：detailList6

					// detailList6をテーブルモデル（tableModelDetail6）に設定する。
					getTableModelDetail6().setAdaptee(getDetailList6());
				}
			} else {
				// 全ての情報を表示チェックボックス（shahukuInfoRevisionCheck）がオフになっている場合
				// detailList6よりKEY：SHOW_FLAGの値が1のレコードを取得する。（以下、tempList）
				if (!(getDetailList6().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList6(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
					doMakeDetailTableList((VRMap) getShahukuInfoTable().getSelectedModelRowValue(), tempList);
					// ・第一引数：選択レコード
					// ・第二引数：tempList

					// tempListをテーブルモデル（tableModelDetail6）に設定する。
					getTableModelDetail6().setAdaptee(tempList);
				}
			}
		}
		
		//[H20.5 法改正対応] fujihara add start
		// 渡された引数の値が"RYOYO"の場合
		if (recordDataType.equals("RYOYO")) {
			// 特定療養費情報テーブルで選択されている行のレコード（以下、選択レコード）を取得する。
			if (getRecuperationInfoRevisionCheck().isSelected()) {
				// 全ての情報を表示チェックボックス（recuperationInfoRevisionCheck）がオンになっている場合
				// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
				if (!(getDetailList7().isEmpty())) {
					doMakeDetailTableList((VRMap) getRecuperationInfoTable().getSelectedModelRowValue(), getDetailList7());
					// ・第一引数：選択レコード
					// ・第二引数：detailList7

					// detailList7をテーブルモデル（tableModelDetail7）に設定する。
					getTableModelDetail7().setAdaptee(getDetailList7());
				}
			} else {
				// 全ての情報を表示チェックボックス（recuperationInfoRevisionCheck）がオフになっている場合
				// detailList1よりKEY：SHOW_FLAGの値が1のレコードを取得する。（以下、tempList）
				if (!(getDetailList7().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList7(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
					doMakeDetailTableList((VRMap) getRecuperationInfoTable().getSelectedModelRowValue(), tempList);
					// ・第一引数：選択レコード
					// ・第二引数：tempList

					// tempListをテーブルモデル（tableModelDetail7）に設定する。
					getTableModelDetail7().setAdaptee(tempList);
				}
			}
		}
		//[H20.5 法改正対応] fujihara add end

// 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
		// 渡された引数の値が"DETAIL_JUSHOTI_TOKUREI"の場合
		if (recordDataType.equals("DETAIL_JUSHOTI_TOKUREI")) {
			// 明細情報テーブルで選択されている行のレコード（以下、選択レコード）を取得する。
			
			if (getDetailsJushotiTokureiInfoRevisionCheck().isSelected()) {
				// 全ての情報を表示チェックボックス（detailsJushotiTokureiInfoRevisionCheck）がオンになっている場合
				// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
				if (!(getDetailList8().isEmpty())) {
					
					doMakeDetailTableList((VRMap) getDetailsJushotiTokureiInfoTable().getSelectedModelRowValue(), getDetailList8());
					// ・第一引数：選択レコード
					// ・第二引数：detailList8

					// detailList8をテーブルモデル（tableModelDetail8）に設定する。
					getTableModelDetail8().setAdaptee(getDetailList8());
				}

			} else {
				// 全ての情報を表示チェックボックス（detailsJushotiTokureiInfoRevisionCheck）がオフになっている場合
				// detailList8よりKEY：SHOW_FLAGの値が1のレコードを取得する。（以下、tempList）
				if (!(getDetailList8().isEmpty())) {
					VRList tempList = (VRList) ACBindUtilities.getMatchListFromValue(getDetailList8(), "SHOW_FLAG", ACCastUtilities.toInteger(ON));
					// 詳細テーブルに表示するために、詳細テーブル表示用のデータを作成する。
					doMakeDetailTableList((VRMap) getDetailsJushotiTokureiInfoTable().getSelectedModelRowValue(), tempList);
					// ・第一引数：選択レコード
					// ・第二引数：tempList

					// tempListをテーブルモデル（tableModelDetail8）に設定する。
					getTableModelDetail8().setAdaptee(tempList);
				}
			}
		}
// 2014/12/24 [Yoichiro Kamei] add - end
	}

	/**
	 * 「保存処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doSave() throws Exception {
		// DBへ保存を行う処理。
		try {
			// トランザクションを開始する。
			getDBManager().beginTransaction();
			// パッシブチェックのタスクをクリアする。
			getPassiveChecker().clearPassiveTask();

			// 全件削除用のパッシブチェックのタスクを追加する。
			getPassiveChecker().addPassiveDeleteTask(getPASSIVE_CHECK_KEY());

			// ・パッシブキー：PASSIVE_CHECK_KEY
			// パッシブチェックを行う。
			if (getPassiveChecker().passiveCheck(getDBManager())) {

				// 分割したテーブルをすべてひとつのListに固める
				VRList allList = new VRArrayList();
				allList.addAll(getTableClaimList1());
				allList.addAll(getTableClaimList2());
				allList.addAll(getTableClaimList3());
				allList.addAll(getTableClaimList4());
				allList.addAll(getTableClaimList5());
				allList.addAll(getTableClaimList6());
				//[H20.5 法改正対応] fujihara add start
				allList.addAll(getTableClaimList7());
				//[H20.5 法改正対応] fujihara add end

// 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
				allList.addAll(getTableClaimList8());
// 2014/12/24 [Yoichiro Kamei] add - end
				
				// DBを更新するためのWHERE句を作成する。
				// WHERE句
				String whereStr = "(PATIENT_ID = " + getPatientId() + ") AND (INSURED_ID = '" + getInsuredId() + "') AND (TARGET_DATE = '" + VRDateParser.format(getTargetDate(), "yyyy-MM-dd") + "') AND (CLAIM_DATE = '" + VRDateParser.format(getClaimDate(), "yyyy-MM-dd") + "') AND (PROVIDER_ID = '" + getProviderId() + "') AND (CLAIM_STYLE_TYPE =" + getClaimStyleType() + ")";

				// 請求データ（allList）でDBを更新する。
				QkanCommon.updateClaimDetailCustom(getDBManager(), allList, getTargetDate(), whereStr);

				// 更新に成功した場合
				// コミットする。
				getDBManager().commitTransaction();

				// 下記のフラグを初期化する。
				// ・tableChangeFlg
				setTableChangeFlg(OFF);

				// 最新の請求データを取得し、パッシブチェック用に退避する。
				doFindClaim();
				return true;

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
			// ロールバックする。
			getDBManager().rollbackTransaction();
			// 例外を投げる。
			// （異常終了）
			throw ex;
		}
	}

	
	
	/*=================================================================
	 * [ID:0000429][Shin Fujihara] 2009/07 add begin 2009年度対応
	 =================================================================*/
	
	/**
	 * 再集計ボタン押下時の処理
	 */
	protected void retotalActionPerformed(ActionEvent e) throws Exception {
		
		//確認メッセージを表示
		if (QkanMessageList.getInstance().QP005_WARNING_OF_RETOTAL() != ACMessageBox.RESULT_OK){
			return;
		}
		//再集計実行
		doRecount(false);
		
		QkanMessageList.getInstance().QP005_RETOTAL_SUCCESSED();
	}
	
	
	private void doRecount(boolean isPlanOverwrite) throws Exception {
// 2014/12/24 [Yoichiro Kamei] mod - begin 住所地特例対応
//		VRList[] list = new VRArrayList[7];
		VRList[] list = new VRArrayList[8];
// 2014/12/24 [Yoichiro Kamei] mod - end
		list[0] = getTableClaimList1();
		list[1] = getTableClaimList2();
		list[2] = getTableClaimList3();
		list[3] = getTableClaimList4();
		list[4] = getTableClaimList5();
		list[5] = getTableClaimList6();
		list[6] = getTableClaimList7();
// 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
		list[7] = getTableClaimList8();
// 2014/12/24 [Yoichiro Kamei] add - end
		dump(list, "before.txt");
		
		//再集計実行！
		QP001ReTotal qp001retotal = new QP001ReTotal();
// 2016/10/13 [Yoichiro Kamei] mod - begin 総合事業対応
//		qp001retotal.calc(list, getDBManager(), getPatientId(), isPlanOverwrite);
		try {
			qp001retotal.calc(list, getDBManager(), getPatientId(), isPlanOverwrite);
		} catch (QkanSjTankaNotFoundException e) {
			QkanMessageList.getInstance().QS001_SJ_TANKA_NOT_FOUND();
		}
// 2016/10/13 [Yoichiro Kamei] mod - end
		
		dump(list, "after.txt");
		
		//全テーブル再描画
		repaintTable(getBasicInfoTable(), "BASIC", getTableClaimList1());
		repaintTable(getDetailsInfoTable(), "DETAIL", getTableClaimList2());
		repaintTable(getKyotakuDetailsInfoTable(), "KYOTAKU", getTableClaimList2());
		repaintTable(getParticularInfoTable(), "PARTICULAR", getTableClaimList3());
		repaintTable(getSpecialClinicInfoTable(), "SPECIAL_CLINIC", getTableClaimList3());
		repaintTable(getTotalInfoTable(), "TOTAL", getTableClaimList4());
		repaintTable(getNyushoInfoTable(), "NYUSHO", getTableClaimList5());
		repaintTable(getShahukuInfoTable(), "SHAHUKU", getTableClaimList6());
		repaintTable(getRecuperationInfoTable(), "RYOYO", getTableClaimList7());
// 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
		repaintTable(getDetailsJushotiTokureiInfoTable(), "DETAIL_JUSHOTI_TOKUREI", getTableClaimList8());
// 2014/12/24 [Yoichiro Kamei] add - end
		
		repaintTable(getTableModelList1());
		repaintTable(getTableModelList2());
		repaintTable(getTableModelList3());
		repaintTable(getTableModelList4());
		repaintTable(getTableModelList5());
		repaintTable(getTableModelList6());
		repaintTable(getTableModelList7());
// 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
		repaintTable(getTableModelList8());
// 2014/12/24 [Yoichiro Kamei] add - end
	}
	
	private void repaintTable(ACTableModelAdapter ta) throws Exception {
		if ((ta != null) && (ta.getTable() != null)) {
			ta.getTable().repaint();
		}
	}
	
	private void repaintTable(ACTable table, String key, VRList list) throws Exception {
		if ((list == null) || (list.size() <= 0)) {
			return;
		}
		
		if (table.isVisible() && (table.getRowCount() > 0)){
			if (!table.isSelected()){
				table.setSelectedSortedFirstRow();
			}
			doShowClaimDetail(key);
		}
	}
	
	/**
	 * サービス追加ボタン押下時の処理
	 */
	protected void serviceAddButtonActionPerformed(ActionEvent e) throws Exception {
		QP005001 qp005001 = new QP005001();
		qp005001.showModal(getTargetDate());
		
		//キャンセルされたか確認する
		if (!qp005001.getIsAdd()) {
			return;
		}
		//入力された値を取得
		VRMap map = qp005001.getValues();
		
		//レコードに必須の情報を設定
		//CATEGORY_NO
		map.put("CATEGORY_NO", "8");
		//レコード種別コード2桁(11を設定)
		map.put("801002", "11");
		
		//基本情報レコードから値をコピー
		if (getTableClaimList1().size() <= 0) {
			return;
		}
		
		int claim_id = QkanCommon.getBookingNumber(getDBManager(), "CLAIM","CLAIM_ID", 1);
		
		String[] copyKeys = new String[]
		{"PATIENT_ID",
		 "LAST_TIME",
		 "CLAIM_DATE",
		 "PROVIDER_ID",
		 "INSURER_ID",
		 "CLAIM_STYLE_TYPE",
		 "TARGET_DATE",
		 "INSURED_ID",
		 "CLAIM_FINISH_FLAG"};
		
		String[] copyKeysNum = new String[]
		{"01001", "01003", "01004", "01005", "01006"};
		
		VRMap base = (VRMap)getTableClaimList1().get(0);
		
		for (int i = 0; i < copyKeys.length; i++) {
			map.put(copyKeys[i], base.get(copyKeys[i]));
		}
		for (int i = 0; i < copyKeysNum.length; i++) {
			map.put("8" + copyKeysNum[i], base.get("2" + copyKeysNum[i]));
		}
		
		//CLAIM_ID
		map.put("CLAIM_ID", String.valueOf(claim_id));
		
		//とりあえず値を設定
		//特定入所者介護サービス費用情報レコード順次番号2桁
		map.put("801007", "0");
		//公費1日数2桁
		map.put("801013", "0");
		//公費2日数2桁
		map.put("801014", "0");
		//公費3日数2桁
		map.put("801015", "0");
		//費用額6桁
		map.put("801016", "0");
		//保険分請求額6桁
		map.put("801017", "0");
		//公費1負担額(明細)6桁
		map.put("801018", "0");
		//公費2負担額(明細)6桁
		map.put("801019", "0");
		//公費3負担額(明細)6桁
		map.put("801020", "0");
		//利用者負担額5桁
		map.put("801021", "0");
		//費用額合計6桁
		map.put("801022", "0");
		//保険分請求額合計6桁
		map.put("801023", "0");
		//利用者負担額合計6桁
		map.put("801024", "0");
		//(公費1)負担額合計6桁
		map.put("801025", "0");
		//(公費1)請求額6桁
		map.put("801026", "0");
		//(公費1)本人負担月額5桁
		map.put("801027", "0");
		//(公費2)負担額合計6桁
		map.put("801028", "0");
		//(公費2)請求額6桁
		map.put("801029", "0");
		//(公費2)本人負担月額5桁
		map.put("801030", "0");
		//(公費3)負担額合計6桁
		map.put("801031", "0");
		//(公費3)請求額6桁
		map.put("801032", "0");
		//(公費3)本人負担月額5桁
		map.put("801033", "0");
		
		getTableClaimList5().addData(map);
		
		getTableModelList5().setAdaptee(getTableClaimList5());
		repaintTable(getNyushoInfoTable(), "NYUSHO", getTableClaimList5());
		repaintTable(getTableModelList5());
		
		//最終行を選択状態にする。
		getNyushoInfoTable().setSelectedSortedLastRow();
	}
	/**
	 * サービス削除ボタン押下時の処理
	 */
	protected void serviceDelButtonActionPerformed(ActionEvent e) throws Exception {
		if (!getNyushoInfoTable().isSelected()) {
			return;
		}
		if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() != ACMessageBox.RESULT_OK){
			return;
		}
		VRMap map = (VRMap) getNyushoInfoTable().getSelectedModelRowValue();
		
		getTableClaimList5().remove(map);
		
		//データがなくなったら、詳細テーブルを非表示にする
		if (getTableClaimList5().size() <= 0) {
			getTableModelDetail5().setAdaptee(new VRArrayList());
		} else {
			//一行目を選択状態にする
			getNyushoInfoTable().setSelectedSortedFirstRow();
		}
	}
	
	/**
	 * スナップショット取得
	 * @throws Exception
	 */
	private void doSnap() throws Exception {
		VRList list = new VRArrayList();
		
		list.add(deepCopy(getTableClaimList1()));
		list.add(deepCopy(getTableClaimList2()));
		list.add(deepCopy(getTableClaimList3()));
		list.add(deepCopy(getTableClaimList4()));
		list.add(deepCopy(getTableClaimList5()));
		list.add(deepCopy(getTableClaimList6()));
		list.add(deepCopy(getTableClaimList7()));
// 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
		list.add(deepCopy(getTableClaimList8()));
// 2014/12/24 [Yoichiro Kamei] add - end
		
		setSnapList(list);
	}
	
	private VRList deepCopy(VRList list) throws Exception {
		
		VRList r = new VRArrayList();
		
		for (int i = 0; i < list.size(); i++) {
			VRMap rm = new VRHashMap();
			VRMap map = (VRMap)list.get(i);
			
			Iterator it = map.keySet().iterator();
			
			while(it.hasNext()) {
				String key = it.next().toString();
				rm.put(key, map.get(key));
			}
			
			r.add(rm);
		}
		
		return r;
	}
	
	/**
	 * スナップショットチェック
	 * @return
	 * @throws Exception
	 */
	private boolean isModified() throws Exception {
		VRList list = new VRArrayList();
		
		list.add(getTableClaimList1());
		list.add(getTableClaimList2());
		list.add(getTableClaimList3());
		list.add(getTableClaimList4());
		list.add(getTableClaimList5());
		list.add(getTableClaimList6());
		list.add(getTableClaimList7());
// 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
		list.add(getTableClaimList8());
// 2014/12/24 [Yoichiro Kamei] add - end
				
		if (getSnapList().size() != list.size()) {
			return true;
		}
		
		for (int i = 0; i < list.size(); i++) {
			VRList l1 = (VRList)getSnapList().get(i);
			VRList l2 = (VRList)list.get(i);
			
			if (l1.size() != l2.size()){
				return true;
			}
			
			for (int j = 0; j < l2.size(); j++) {
				VRMap m1 = (VRMap)l1.get(j);
				VRMap m2 = (VRMap)l2.get(j);
				
				Iterator it = m1.keySet().iterator();
				
				while(it.hasNext()) {
					String key = it.next().toString();
					if (!m2.containsKey(key)) {
						return true;
					}
					
					String v1 = ACCastUtilities.toString(m1.get(key), ""); 
					String v2 = ACCastUtilities.toString(m2.get(key), "");
					
					if (!v1.equals(v2)) {
						return true;
					}
				}
			}
		}
		
		
		return false;
	}
	
	private void dump(VRList[] lists, String fileName) {
		
		try {
		
			if (!isDebugMode()) {
				return;
			}
			
			java.io.FileOutputStream fos = new java.io.FileOutputStream(fileName);
			java.io.OutputStreamWriter osw = new java.io.OutputStreamWriter(fos , "MS932");
			java.io.BufferedWriter bw = new java.io.BufferedWriter(osw);
	
			for (int i = 0; i < lists.length; i++ ){
				for (int j = 0; j < lists[i].size(); j++) {
					VRMap map = (VRMap)lists[i].get(j);
					
					Iterator it = map.keySet().iterator();
					while(it.hasNext()) {
						String key = it.next().toString();
						bw.write(key);
						bw.write(",");
						bw.write(ACCastUtilities.toString(map.get(key), ""));
						bw.write("\r\n");
					}
					
					
				}
			}
			bw.close();
			osw.close();
			fos.close();
		
		} catch (Exception e){
			e.printStackTrace();
		}
	}
    public boolean isDebugMode() {
		try {
			if (ACFrame.getInstance().hasProperty("ReTotalDump")
					&& "true".equalsIgnoreCase(ACCastUtilities.toString(ACFrame
							.getInstance().getProperty("ReTotalDump")))) {
				return true;
			}
		} catch (Exception ex) {
		}
		return false;
	}
	/*
	 * =================================================================
	 * [ID:0000429][Shin Fujihara] 2009/07 add end 2009年度対応
	 * =================================================================
	 */

	/*=================================================================
	 * [ID:0000563][ID:0000576][Shin Fujihara] 2009/12 add begin 2009年度対応
	 =================================================================*/
    
	protected void detailsDelButtonActionPerformed(ActionEvent e) throws Exception {
		if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() != ACMessageBox.RESULT_OK){
			return;
		}
		
		int deleteRow = getDetailsInfoTable().getSelectedRow();
		VRMap map = (VRMap) getDetailsInfoTable().getSelectedModelRowValue();
		
		getTableClaimList2().remove(map);
		//削除行の一行上を選択状態にする
		getDetailsInfoTable().setSelectedSortedRowOnAfterDelete(deleteRow);
		
		if (getTableClaimList2().size() < 2) {
			//削除ボタンを使用不可能にする
			setState_TYPE11();
		}
		
		//[ID:0000576]サービス削除後、再集計を実行する
		//このときの再集計では、計画単位数を上書きする
		doRecount(true);
		
	}
	/*
	 * =================================================================
	 * [ID:0000563][ID:0000576][Shin Fujihara] 2009/07 add end 2009年度対応
	 * =================================================================
	 */
	
// 2014/12/26 [Yoichiro Kamei] mod - begin 住所地特例対応
	protected void detailsJushotiTokureiDelButtonActionPerformed(ActionEvent e) throws Exception {
		if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() != ACMessageBox.RESULT_OK){
			return;
		}
		
		int deleteRow = getDetailsJushotiTokureiInfoTable().getSelectedRow();
		VRMap map = (VRMap) getDetailsJushotiTokureiInfoTable().getSelectedModelRowValue();
		
		getTableClaimList8().remove(map);
		//削除行の一行上を選択状態にする
		getDetailsJushotiTokureiInfoTable().setSelectedSortedRowOnAfterDelete(deleteRow);
		
		if (getTableClaimList8().size() < 2) {
			//削除ボタンを使用不可能にする
			setState_TYPE13();
		}
		
		//[ID:0000576]サービス削除後、再集計を実行する
		//このときの再集計では、計画単位数を上書きする
		doRecount(true);
		
	}
// 2014/12/26 [Yoichiro Kamei] mod - end

}
