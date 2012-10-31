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
 */

package jp.or.med.orca.qkan.affair.qm.qm001;

import java.util.Date;

import sun.nio.cs.HistoricallyNamedCharset;

import com.sun.org.apache.xpath.internal.compiler.OpCodes;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;

/**
 * システムから登録可能なマスタの補正用タスククラス
 * 
 */
public class QM001UpdateMasterTask {
	// マスタバージョン
	public String version = "";

	/**
	 * コンストラクタ
	 */
	public QM001UpdateMasterTask() {
	}

	/**
	 * コンストラクタ
	 */
	public QM001UpdateMasterTask(String version) {
		setVersion(version);
	}

	/**
	 * バージョン補正タスク管理
	 * 
	 * @param dbm
	 * @throws Exception
	 */
	public void adjustTask(ACDBManager dbm) throws Exception {

		try {
			// 予防版タスク
			task1(dbm);
			
			// [ID:0000749][Masahiko.Higuchi] add - begin 2012年度対応 施設情報の履歴管理に関するデータ補正
			task2(dbm);
			// [ID:0000749][Masahiko.Higuchi] add - end
			
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * 郵便番号テーブルのPRIMARY KEY削除
	 * 
	 * @param dbm
	 *            DBManager
	 * @throws Exception
	 */
	public void task1(ACDBManager dbm) throws Exception {

		try {
			QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();

			// 郵便番号テーブルのPRIMARY KEY削除実行
			op.dropPostPrimaryKey(dbm);

			// コミット
			dbm.commitTransaction();

		} catch (Exception ex) {
			dbm.rollbackTransaction();
			throw ex;
		}
	}

	/**
	 * 施設情報履歴管理に伴うデータ補正
	 * 
	 * @param dbm
	 *            DBManager
	 * @throws Exception
	 * @since V6.1.2
	 */
	public void task2(ACDBManager dbm) throws Exception {

		VRList historyList = new VRArrayList();
		QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();

		// 実行判定処理
		try {
			// 不要なレコードの補正削除
			dbm.executeUpdate(op.getSQL_DELETE_SHISETSU_HISTORY());
			// コミット
			dbm.commitTransaction();
			
			historyList = dbm.executeQuery(op.getSQL_GET_SHISETSU_HISTORY());
			// 開始終了の日付がNULLレコードが取得出来ない場合は処理中断
			if (historyList.size() == 0) {
				return;
			}

		} catch (Exception ex) {
			// ロールバック
			dbm.rollbackTransaction();
		}

		// ログインシステム日付を取得
		Date systemDate = QkanSystemInformation.getInstance().getSystemDate();

		int startYear = ACDateUtilities.getYear(systemDate);
		int endYear = ACDateUtilities.getYear(systemDate);

		// 7月を境界にして年度を切り替える
		if (ACDateUtilities.getMonth(systemDate) < 7) {
			// 1～6月
			startYear -= 1;
		} else {
			// 7～12月
			endYear += 1;
		}
		// 開始と終了を生成
		Date validStartDate = ACDateUtilities.createDate(startYear, 7, 1);
		Date validEndTemp = ACDateUtilities.createDate(endYear, 6, 1);
		Date validEndDate = ACDateUtilities.toLastDayOfMonth(validEndTemp);

		// SQLパラメータの設定
		VRMap sqlParam = new VRHashMap();
		sqlParam.setData("SHISETSU_VALID_START", validStartDate);
		sqlParam.setData("SHISETSU_VALID_END", validEndDate);
		try {

			for (int i = 0; i < historyList.size(); i++) {
				VRMap historyData = (VRMap)historyList.get(i);
				sqlParam.setData("SHISETSU_HISTORY_ID",historyData.getData("SHISETSU_HISTORY_ID"));
				sqlParam.setData("PATIENT_ID",historyData.getData("PATIENT_ID"));
				// アップデート処理
				dbm.executeUpdate(op
						.getSQL_UPDATE_SHISETSU_HISTORY_DATE(sqlParam));
			}
			
			// コミット
			dbm.commitTransaction();

		} catch (Exception e) {
			dbm.rollbackTransaction();
			throw e;
		}

	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return this.version;
	}

}
