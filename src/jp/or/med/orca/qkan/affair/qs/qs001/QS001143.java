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
 * 作成日: 2006/05/10  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防特定施設入居者生活介護 (QS001143)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * サービスパターン介護予防特定施設入居者生活介護(QS001143)
 */
public class QS001143 extends QS001143Event {
	/**
	 * コンストラクタです。
	 */
	public QS001143() {
	}

	// コンポーネントイベント

	/**
	 * 「区分選択」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void outsideServiceRadioActionPerformed(ActionEvent e)
			throws Exception {
		// 区分選択処理
		// 画面状態制御
		checkState();

	}

	/**
	 * 「施設区分選択」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void facilitiesDivisionRadioActionPerformed(ActionEvent e)
			throws Exception {
		// 施設区分選択処理
		// 画面状態制御
		checkState();

	}

	/**
	 * 「開始時刻選択」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void specificFacilityBeginTimeActionPerformed(ActionEvent e)
			throws Exception {
		// 開始時刻選択
		// 終了時間設定
		checkEndTime();

	}

	/**
	 * 「訪問看護時間区分選択」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitNursingComboActionPerformed(ActionEvent e)
			throws Exception {
		// 訪問看護時間区分選択
		// 終了時間設定
		checkEndTime();

	}

	/**
	 * 「訪問看護施設区分選択」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitNursingFacilitiesDivisionRadioActionPerformed(
			ActionEvent e) throws Exception {
		// 訪問看護施設区分選択
		// 画面状態制御
		checkState();

		// コンボ項目再設定
		setComboItem();

	}

	/**
	 * 「訪問看護職員区分選択」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void visitNursingStaffDivisionRadioActionPerformed(ActionEvent e)
			throws Exception {
		// 訪問看護職員区分選択
		// 画面状態制御
		checkState();

		// コンボ項目再設定
		setComboItem();

	}

	/**
	 * 「認知症対応通所介護施設区分」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void providerDivisionRadioActionPerformed(ActionEvent e)
			throws Exception {
		// 認知症対応通所介護施設区分選択
		// 画面状態制御
		checkState();

	}

	/**
	 * 「認知症対応型通所介護時間区分選択」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void timeDivisionRadioSelectionChanged(ListSelectionEvent e)
			throws Exception {
		// 認知症対応型通所介護時間区分選択
		// 終了時間設定
		checkEndTime();

	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QS001143.class.getName(), param));
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
		// ※コンボアイテムの設定
		// ※準備
		// コンボアイテム設定用のレコード comboItemMap を生成する。
		VRMap comboItemMap = new VRHashMap();
		// ※設定
		// ※開始時刻
		// コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
		// 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
		VRBindPathParser.set("3", comboItemMap, QkanCommon
				.getArrayFromMasterCode(23, "3"));
		// ※終了時刻
		// コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
		// 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
		VRBindPathParser.set("4", comboItemMap, QkanCommon
				.getArrayFromMasterCode(23, "4"));
		// ※訪問看護時間区分
		// コードマスタデータよりCODE_ID：207 訪問看護（時間区分）を取得する。
		// 取得した値を、comboItemMapの KEY : 1330112 の VALUE として設定する。
		VRBindPathParser.set("1350109", comboItemMap, QkanCommon
				.getArrayFromMasterCode(207, "1350109"));
		// ※福祉用具
		// コードマスタデータよりCODE_ID：47 福祉用具を取得する。
		// 取得した値を、comboItemMapの KEY : 1350119 の VALUE として設定する。
		VRBindPathParser.set("1350119", comboItemMap, QkanCommon
				.getArrayFromMasterCode(47, "1350119"));
		// ※展開
		// 自身(this)にcomboItemMapに設定する。
		getThis().setModelSource(comboItemMap);
		// コンボアイテムを展開する。
		getThis().bindModelSource();

		// ※選択項目の初期設定
		// ※準備
		// 初期選択設定用のレコード defaultMap を生成する。
		//VRMap defaultMap = new VRHashMap();
		// ※設定
		// 画面のラジオの初期値を設定する。（selectFirstRadioItem）
		QkanCommon.selectFirstRadioItem(getThis());
        // なしを選択状態にする。
        getOutsideServiceRadioItem0().setSelected(true);
		// ※展開
		// 自身(this)にdefaultMapに設定する。
        //getThis().setSource(defaultMap);
		// 初期選択項目を展開する。
        //getThis().bindSource();
		// 画面状態を変更する。
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
		// 選択事業所情報がnullでない場合
		// ※以下の内容詳細項目は、選択事業所の値を設定する。

		// ※準備
		// 事業所連動用のレコード defaultMap を生成する。
		VRMap defaultMap = new VRHashMap();

		// ※設定
		// 内部変数 providerInfoMap を生成する。
		VRMap providerInfoMap = new VRHashMap();
		// 事業所パネル情報を取得し providerInfoMap に格納する。
		// getSelectedProvider();
		providerInfoMap = getSelectedProvider();

		// providerInfoMapが null かチェックする。
		if (providerInfoMap != null) {
			// null以外だった場合
			// 人員配置区分（事業所パネル）KEY：1350102の値をチェックする。
			int valOnProvider;
			valOnProvider = ACCastUtilities.toInt(VRBindPathParser.get(
					"1350102", providerInfoMap),0);
			switch (valOnProvider) {
			case 1:
				// 値が1（一般型）だった場合
				// defaultMapに KEY：1350101 VALUE：1（特定施設入居者）を設定する。
				VRBindPathParser.set("1350101", defaultMap, new Integer(1));
				break;
			case 2:
				// 値が2（外部サービス利用型）だった場合
				// defaultMapに KEY：1350101 VALUE：2（外部サービス利用型）を設定する。
				VRBindPathParser.set("1350101", defaultMap, new Integer(2));
				break;
			}

			// 職員の欠員による減算の状況（事業所パネル）KEY：1350103の値をチェックする。
			valOnProvider = ACCastUtilities.toInt(VRBindPathParser.get(
					"1350103", providerInfoMap),0);
			switch (valOnProvider) {
			case 1:
				// 値が1（なし）だった場合
				// defaultMapに KEY：1350103 VALUE：1（なし）を設定する。
				VRBindPathParser.set("1350103", defaultMap, new Integer(1));
				break;
			case 2:
			case 3:
				// 値が2又は3（看護職員、介護職員）だった場合
				// defaultMapに KEY：1350103 VALUE：2（看護・介護職員が欠員）を設定する。
				VRBindPathParser.set("1350103", defaultMap, new Integer(2));
				break;
			}

			// 個別機能訓練体制（事業所パネル）KEY：1350104の値をチェックする。
			valOnProvider = ACCastUtilities.toInt(VRBindPathParser.get(
					"1350104", providerInfoMap),0);
			switch (valOnProvider) {
			case 1:
				// 値が1（なし）だった場合
				// defaultMapに KEY：1350102 VALUE：1（なし）を設定する。
				VRBindPathParser.set("1350102", defaultMap, new Integer(1));
				break;
			case 2:
				// 値が2（あり）だった場合
				// defaultMapに KEY：1350102 VALUE：2（あり）を設定する。
				VRBindPathParser.set("1350102", defaultMap, new Integer(2));
				break;
			}
		}

		// null（事業所未選択）だった場合
		// 何も行わない。

		// ※展開
		// 自身(this)にdefaultMapに設定する。
		getThis().setSource(defaultMap);
		// 初期選択項目を展開する。
		getThis().bindSource();

		// ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
		// 画面状態を変更する。
		checkState();

	}

	/**
	 * 「入力内容の不備を検査」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public VRMap getValidData() throws Exception {
		// ※入力内容に不備がないかをチェックし、サービスデータを返す。
		// ※返却用のレコード(data)を生成
		VRMap data = new VRHashMap();
		// 自身(this)のソースとして生成レコードを設定する。
		getThis().setSource(data);
		// 自身(this)のapplySourceを呼び出してデータを収集する。
		getThis().applySource();

		// 施設区分
		int valOfFacilityDivision = getFacilitiesDivisionRadio()
				.getSelectedIndex();
		// 外部サービス種類
		int valOfOutsideService = getOutsideServiceRadio().getSelectedIndex();

		// ※返却用レコードから不要なキーを除去
		// 開始時刻区分が有効な場合
		// 【外部サービス】訪問看護・認知症対応型通所介護が選択されていた場合（値が3又は8の場合以外はチェックしない）
		if (getSpecificFacilityBeginTime().isEnabled()) {
			switch(valOfOutsideService){
			case 3:
			case 8:
				if (ACTextUtilities.isNullText(getSpecificFacilityBeginTime()
						.getText())
						|| ACTextUtilities.isNullText(getSpecificFacilityEndTime()
								.getText())
						|| (!getSpecificFacilityBeginTime().isValidDate())
						|| (!getSpecificFacilityEndTime().isValidDate())) {
					// 開始時刻コンボ(specificFacilityBeginTime)が空欄か不正の場合
					// もしくは終了時刻コンボ(specificFacilityEndTime)が空欄か不正の場合
					// 時刻の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_TIME
					QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
					// nullを返す。
					return null;
				}
				break;
			}
		}

		if (valOfFacilityDivision == 2) {
			// 外部サービス利用で訪問看護が選択されているかチェックする。
			switch (valOfOutsideService) {
			case 3:
				// 訪問看護が選択されていた場合
				if (getVisitNursingCombo().isEnabled()) {
					// 訪問看護 時刻コンボが有効な場合
					// 時刻が選択されているかをチェックする。
					if (!getVisitNursingCombo().isSelected()) {
						// 選択されていなかった場合
						// 内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
						QkanMessageList.getInstance()
								.QS001_ERROR_OF_NO_CONTENT();
						// nullを返す。
						return null;
					}
				}

				if (!getVisitNursingStaffDivisionRadio().getSelectedButton()
						.isEnabled()) {
					// 職員区分をチェックする。
					// 職員区分のEnableがfalseだった場合
					// 内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
					QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
					// nullを返す。
					return null;
				}
				break;
			case 7:
				// 外部サービス利用で福祉用具が選択されているかチェックする。
				// 福祉用具が選択されていた場合
				if (!(getWelfareToolsCombo().isSelected())
						|| ACTextUtilities.isNullText(getWelfarePointText()
								.getText())){
					// 用具種類が選択されていなかった場合
					// 内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
					// QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
					// nullを返す。
					// 単位数が入力されていなかった場合
					// 内容の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
					// QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
					QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
					// nullを返す。
					return null;
				}
				break;
			}
		}
		// 問題なければ返却用レコード(data)を返す。
		QkanCommon.removeDisabledBindPath(getThis(), data);
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
		// trueを返す。
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
		return getSpecificFacilityBeginTime();
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
		return getSpecificFacilityEndTime();
	}

	/**
	 * 「画面状態制御」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void checkState() throws Exception {
		// ※画面状態制御
		// ※サービス連動
		// 施設等の区分（サービスパネル）の値をチェックする。
		int valOfFacilityDivision = getFacilitiesDivisionRadio()
				.getSelectedIndex();
		switch (valOfFacilityDivision) {
		case 1:
			// 値が1（特定施設入居者生活）だった場合
			// 画面の状態を｢画面状態1｣に変更する。
			setState_STATE_MODE_1();
			break;
		case 2:
			// 値が2（外部サービス利用）だった場合
			// 外部サービス（outsideServiceRadio）の値をチェックする。
			int valOfOutsideService = getOutsideServiceRadio()
					.getSelectedIndex();
			switch (valOfOutsideService) {
			case 1:
				// 値が1（訪問介護）だった場合
				// 画面の状態を｢画面状態2｣に変更する。
				setState_STATE_MODE_2();
				break;
			case 2:
				// 値が2（訪問入浴介護）だった場合
				// 画面の状態を｢画面状態3｣に変更する。
				setState_STATE_MODE_3();
				break;
			case 3:
				// 値が3（訪問看護）だった場合
				// 施設等の区分（visitNursingFacilitiesDivisionRadio）の値をチェックする。
				int valOfVisitNursingFacilityDivision = getVisitNursingFacilitiesDivisionRadio()
						.getSelectedIndex();
				switch (valOfVisitNursingFacilityDivision) {
				case 1:
					// 値が1（訪問看護ステーション）だった場合
					// 画面の状態を｢画面状態5｣に変更する。
					setState_STATE_MODE_5();
					break;
				case 2:
					// 値が2（病院又は診療所）だった場合
					// 画面の状態を｢画面状態4｣に変更する。
					setState_STATE_MODE_4();
					break;
				}
				break;
			case 4:
				// 値が4（訪問リハ）だった場合
				// 画面の状態を｢画面状態6｣に変更する。
				setState_STATE_MODE_6();
				break;
			case 5:
				// 値が5（通所介護）だった場合
				// 画面の状態を｢画面状態7｣に変更する。
				setState_STATE_MODE_7();
				break;
			case 6:
				// 値が6（通所リハ）だった場合
				// 画面の状態を｢画面状態8｣に変更する。
				setState_STATE_MODE_8();
				break;
			case 7:
				// 値が7（福祉用具貸与）だった場合
				// 画面の状態を｢画面状態9｣に変更する。
				setState_STATE_MODE_9();
				break;
			case 8:
				// 値が8（認知症対応通所介護）だった場合
				// 施設等の区分1（providerDivisionRadio）の値をチェックする。
				int valOfProviderDivision = getProviderDivisionRadio()
						.getSelectedIndex();
				switch (valOfProviderDivision) {
				case 1:
					// 値が1（Ⅰ型）だった場合
					// 画面の状態を｢画面状態10｣に変更する。
					setState_STATE_MODE_10();
					break;
				case 2:
					// 値が2（Ⅱ型）だった場合
					// 画面の状態を｢画面状態11｣に変更する。
					setState_STATE_MODE_11();
					break;
				}
				break;
            case 9:
                // 予防時対応 - 2006/06/05
                // 値が9（なし）基礎単位のみを返す場合
                setState_STATE_MODE_3();
                break;
			}
			break;
		}

		// ※事業所連動
		// 内部変数 providerInfoMap を生成する。
		VRMap providerInfoMap = new VRHashMap();
		// 事業所パネル情報を取得し providerInfoMap に格納する。
		providerInfoMap = getSelectedProvider();

		// providerInfoMapが null かチェックする。
		if (providerInfoMap != null) {
			// null以外だった場合
            // 特定施設入居者の場合 ※個別機能訓練加算の値連動のため
            if(valOfFacilityDivision == 1){
                // 2008/01/07 [Masahiko Higuchi] edit - begin 障害対応
    			// 個別機能訓練体制（事業所パネル）KEY：1350104の値をチェックする。
    			int valOnProvider = ACCastUtilities.toInt(VRBindPathParser.get(
    					"1350104", providerInfoMap),1);
                // 2008/01/07 [Masahiko Higuchi] edit - end
    			switch (valOnProvider) {
    			case 1:
    				// 値が1（なし）だった場合
    				// 個別機能訓練加算（サービスパネル）のEnableをfalseにする。
    				getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
    				break;
    			case 2:
    				// 値が2（あり）だった場合
    				// 個別機能訓練加算（サービスパネル）のEnableをtrueにする。
    				getSpecificFacilityFunctionTrainingRadio().setEnabled(true);
    				break;
    			}
            }
		}
		// null（事業所未選択）だった場合
		// 何も行わない。

	}

	/**
	 * 「終了時間再設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void checkEndTime() throws Exception {
		// ※終了時間再設定
		// ※時間帯変更時、終了時間も変更
		// 開始時間コンボ(houmonRehabilitationTimeContenaBeginTime)の値が空欄および不正でない場合
		if (!(ACTextUtilities.isNullText(getSpecificFacilityBeginTime()
				.getText()))
				&& getSpecificFacilityBeginTime().isValidDate()) {
			// 内部変数 addTime を生成する。
			int addTime = 0;
			// 外部サービス（specificFacilitySubtractionPersonLack）の値をチェックする。
			switch (getOutsideServiceRadio().getSelectedIndex()) {
			case 3:
				// 値が3（訪問看護）だった場合
				if (getVisitNursingFacilitiesDivisionRadio().getSelectedIndex() == 1) {
					if (getVisitNursingStaffDivisionRadio().getSelectedIndex() == 2) {
						// 訪問看護ステーションでなおかつPT・OT・STだった場合
						// 時間退避用の変数 addTimeに、時間区分から取得した時間を設定する。
						addTime = getHoumonKangoTimeSpecial();
					} else {
						// 訪問看護ステーションでなおかつPT・OT・ST以外だった場合
						// 時間退避用の変数 addTimeに、時間区分から取得した時間を設定する。
						addTime = getHoumonKangoTime();
					}
				}else{
					// 病院又は診療所だった場合
					addTime = getHoumonKangoTime();
				}
				break;
			case 8:
				// 値が8（認知症対応型通所介護）だった場合
				// 時間退避用の変数 addTimeに、時間区分から取得した時間を設定する。
				addTime = getTuusyoKaigoTime();
				break;
			default:
				// 値が上記以外の場合
				// 処理を抜ける※return
				return;
			}
			// 終了時間を「開始時間 + kangoTime(分)」に設定する。
			getSpecificFacilityEndTime().setDate(
					ACDateUtilities.addMinute(getSpecificFacilityBeginTime()
							.getDate(), addTime));
		}
	}

	/**
	 * 「訪問看護時間区分値取得（PT・OT）」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public int getHoumonKangoTimeSpecial() throws Exception {
		// ※訪問看護時間区分値取得（PT・OT）
		// ※時間区分(visitNursingCombo)の時間を取得
		// 時間区分(visitNursingCombo)の値をチェックする。
		switch (getVisitNursingCombo().getSelectedIndex()) {
		case 0:
			// 値が0（30分未満）の場合
			// 戻り値として30を返す。
			return 30;
		case 1:
			// 値が1（1時間半未満）の場合
			// 戻り値として90を返す。
			return 90;
		}
		// 上記に該当しない場合
		// 戻り値として0を返す。
		return 0;
	}

	/**
	 * 「訪問看護時間区分値取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public int getHoumonKangoTime() throws Exception {
		// ※訪問看護時間区分値取得
		// ※時間区分(VisitCareCombo)の時間を取得
		// 時間区分(VisitCareCombo)の値をチェックする。
		switch (getVisitNursingCombo().getSelectedIndex()) {
		case 0:
			// 値が0（0分以上）の場合
			// 戻り値として20を返す。
			return 20;
		case 1:
			// 値が1（30分以上）の場合
			// 戻り値として30を返す。
			return 30;
		case 2:
			// 値が2（1時間以上）の場合
			// 戻り値として60を返す。
			return 60;
		case 3:
			// 値が3（1時間30分以上）の場合
			// 戻り値として90を返す。
			return 90;
		}
		// 上記に該当しない場合
		// 戻り値として0を返す。
		return 0;
	}

	/**
	 * 「認知症対応型通所介護時間区分値取得」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public int getTuusyoKaigoTime() throws Exception {
		// ※認知症対応型通所介護時間区分値取得
		// ※時間区分(timeDivisionRadio)の時間を取得
		// 時間区分(timeDivisionRadio)の値をチェックする。
		switch (getTimeDivisionRadio().getSelectedIndex()) {
		case 1:
			// 値が1（3時間未満）の場合
			// 戻り値として180を返す。
			return 180;
		case 2:
			// 値が2（4時間未満）の場合
			// 戻り値として240を返す。
			return 240;
		case 3:
			// 値が3（6時間以上）の場合
			// 戻り値として360を返す。
			return 360;
		case 4:
			// 値が4（8時間以上）の場合
			// 戻り値として480を返す。
			return 480;
		}
		// 上記に該当しない場合
		// 戻り値として0を返す。
		return 0;
	}

	/**
	 * 「コンボ項目変更」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void setComboItem() throws Exception {
		// ※コンボ項目変更
		// 内部変数 comboItemMap を生成する。
		VRMap comboItemMap = new VRHashMap();
		// 訪問看護施設等の区分の値をチェックする。
		switch (getVisitNursingFacilitiesDivisionRadio().getSelectedIndex()) {
		case 1:
			// 値が1（指定訪問看護ステーション）だった場合
			// 職員区分の値をチェックする。
			switch (getVisitNursingStaffDivisionRadio().getSelectedIndex()) {
			case 1:
				// 値が1（なし）だった場合
				// コードマスタデータよりCODE_ID：207 訪問看護（時間区分）を取得する。
				// 取得した値を、comboItemMapの KEY : 1350109 の VALUE として設定する。
				VRBindPathParser.set("1350109", comboItemMap, QkanCommon
						.getArrayFromMasterCode(207, "1350109"));
				break;
			case 2:
				// 値がk2（PT・OT・ST）だった場合
				// コードマスタデータよりCODE_ID：237 訪問看護（時間区分）を取得する。
				// 取得した値を、comboItemMapの KEY : 1350109 の VALUE として設定する。
				VRBindPathParser.set("1350109", comboItemMap, QkanCommon
						.getArrayFromMasterCode(237, "1350109"));
				break;
			}
			break;
		case 2:
			// 値が2（病院又は診療所）だった場合
			// コードマスタデータよりCODE_ID：207 訪問看護（時間区分）を取得する。
			// 取得した値を、comboItemMapの KEY : 1350109 の VALUE として設定する。
			VRBindPathParser.set("1350109", comboItemMap, QkanCommon
					.getArrayFromMasterCode(207, "1350109"));
			break;
		}

		// ※展開
		// 自身(this)にcomboItemMapに設定する。
		getThis().setModelSource(comboItemMap);
		// コンボアイテムを展開する。
		getThis().bindModelSource();

	}

}
