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
 * 作成日: 2009/07/09  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績データ作成 (P)
 * プロセス 明細書詳細編集 (005)
 * プログラム 特定診療費レコード追加 (QP005001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.util.Date;
import java.util.Map;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 特定診療費レコード追加(QP005001) 
 */
public class QP005001 extends QP005001Event {
	/**
	 * コンストラクタです。
	 */
	public QP005001() {
	}

	//コンポーネントイベント

	/**
	 * 「追加」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void addButtonActionPerformed(ActionEvent e) throws Exception {
		// ※入力チェックを行います。
		// 内部関数を用いて入力チェックを行う。
		if (!checkServiceCode(true)) {
			// 異常の場合
			// エラーメッセージを出力し処理を終了する。
			return;
		}
		
		// 正常の場合
		// 処理を続行する。

		// ※画面の状態を呼び出し元に返す
		// valuesに画面の値を格納する。
		getContents().setSource(getValues());
		getContents().applySource();
		// ※設定済みとして閉じる。
		// 設定ボタンを押したかフラグをtrueにする。
		setIsAdd(true);
		// 画面を閉じる。
		this.dispose();
	}

	/**
	 * 「キャンセル」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void cancelButtonActionPerformed(ActionEvent e) throws Exception {
		// ※値の初期化＋画面を閉じる
		// valuesにnullを格納する。
		setValues(null);
		setIsAdd(false);
		// 画面を閉じる
		this.dispose();
	}

	/**
	 * 「サービスコード変換」イベントです。
	 * @param e イベント情報
	 * @throws Exception 処理例外
	 */
	protected void serviceCodeDetailTextFocusLost(FocusEvent e) throws Exception {
		//サービスコードのチェックを行う
		checkServiceCode(false);
	}

	public static void main(String[] args) {
		//デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		//paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame.debugStart(new ACAffairInfo(QP005001.class.getName(), param));
	}

	//内部関数

	/**
	 * 「初期化」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public void showModal(Date targetDate) throws Exception {
		// ■画面の初期化
		// サービスコードリレーションクラスを生成する。
        setAffairTitle("QP005001");
		// targetDateに引数を設定する。
		//setTargetDate(ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE", params)));
		setTargetDate(targetDate);
		
		// 　内部変数：valuesにダイアログ内のデータを集める
		// 　valuesの値を全て初期化する。
		// 　ダイアログに対してvaluesを設定する。
		getContents().setSource(getValues());
		// 　値をバインドする。（初期化）
		getContents().bindSource();
		
		this.setVisible(true);
	}
	
	
	public boolean checkServiceCode(boolean isMessageShow) throws Exception {
		// 入力チェックを行う。
		if (!isValidData()){
			// 異常の場合
			// サービス名称に空白を設定する。（初期化）
			getServiceNameText().setText("");
			// エラーメッセージを表示する。
			if (isMessageShow) {
				QkanMessageList.getInstance().QP005_ERROR_OF_SERVICE_KIND();
			}
			// 処理を中断する。
			return false;
		}
		// 正常の場合
		// 処理を続行する

		// サービスコード名称置換処理を行う。
		if (!setServiceCode()){
			// 異常の場合
			// エラーメッセージを表示する。
			if (isMessageShow) {
				QkanMessageList.getInstance().QP005_ERROR_OF_SERVICE_NAME();
			}
			// 処理を中断する。
			return false;
		}
		return true;
	}

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public boolean isValidData() throws Exception {
		// ■入力チェックを行います。
		// サービスコード項目番号のチェック
		// 桁数が4桁以外の場合
		// falseを返す。
		
		if (getServiceCodeDetailText().getText().length() != 4){
			return false;
		}
		return true;
	}

	/**
	 * 「サービスコード名称置換処理」に関する処理を行ないます。
	 * @throws Exception 処理例外
	 */
	public boolean setServiceCode() throws Exception {
		// ■サービスコード名称置換処理
		// レコード sqlParam に下記のKEY：VALUEでSQLに渡す変数を設定する。
		VRMap sqlParam = new VRHashMap();

		// KEY：SERVICE_CODE_KIND　VALUE：serviceCodeKindLabelの値
		VRBindPathParser.set("SERVICE_CODE_KIND", sqlParam,
				getServiceCodeKindLabel().getText());

		// KEY：SERVICE_CODE_ITEM　VALUE：serviceCodeDetailTextの値
		VRBindPathParser.set("SERVICE_CODE_ITEM", sqlParam,
				getServiceCodeDetailText().getText());

		// KEY：SERVICE_VALID_START　VALUE：targetDate
		VRBindPathParser.set("TARGET_DATE", sqlParam, getTargetDate());

		// サービスコード名称取得用のSQLを取得する。
		String query = getSQL_GET_SPECIAL_CLINIC_SERVICE_CODE(sqlParam);

		// SQLを発行する。
		// SQLから取得したデータをレコード集合に反映する。
		VRList lastInfoList = getDBManager().executeQuery(query);

		// 取得した結果が一件以上の場合
		if ((lastInfoList != null) && (lastInfoList.size() > 0)) {
			//serviceNameText に取得した名称を設定する。
			String serviceName = ((Map) lastInfoList.get(0)).get("SERVICE_NAME").toString();
			getServiceNameText().setText(serviceName);
			//true を返す。
			return true;
		}

		// 失敗した場合
		// テキスト初期化
		getServiceNameText().setText("");
		// false を返す。
		return false;
	}

}
