
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
 * 開発者: 亀井
 * 作成日: 2017/06/30
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 様式第二 (QP001Style73)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 様式第７－３一帳票分の情報
 * 様式７－１、７－２とはデータ構造が違うため別クラスとして作成
 */
public class QP001Style73 extends QP001StyleAbstract {

	/**
	 * 明細情報レコード集合
	 */
	private VRMap detailMap = new VRHashMap();
	/**
	 * 集計情報レコード集合
	 */
	private Map<String, QP001RecordType> typeMap = new TreeMap<String, QP001RecordType>();
	/**
	 * 基本情報レコード(一帳票にひとつ)
	 */
	private QP001RecordBase base = new QP001RecordBase();

	/**
	 * 内部様式番号
	 */
	private int claimStyleFormat = 0;
	/**
	 * 交換識別番号
	 */
	private String identificationNo = "";

	private QP001Manager manager = null;

	public QP001Style73(int claimStyleFormat,QP001Manager manager){
        this.claimStyleFormat = claimStyleFormat;
        this.identificationNo = getIdentificationNo(claimStyleFormat,manager.getTargetDate());
        this.manager = manager;
    }

	public static String getSerialId(Date targetDate, VRMap serviceDetail, QP001PatientState patientState,
			int claimStyleFormat) throws Exception {
		StringBuilder serial = new StringBuilder();
		// 201001 交換情報識別番号4桁
		serial.append(getIdentificationNo(claimStyleFormat, targetDate));
		// サービス提供年月6桁(YYYYMM)
		serial.append(VRDateParser.format(targetDate, "yyyyMM"));
		// 事業所番号10桁
		serial.append(VRBindPathParser.get("PROVIDER_ID", serviceDetail));
		// 証記載保険者番号8桁
		serial.append(patientState.getInsurerId(VRBindPathParser.get("SERVICE_DATE", serviceDetail)));
		// 被保険者番号10桁
		serial.append(patientState.getInsuredId(VRBindPathParser.get("SERVICE_DATE", serviceDetail)));

		return serial.toString();
	}

	/**
	 * データの解析を実行する。
	 * 
	 * @param serviceDetail
	 * @param targetDate
	 * @param patientState
	 * @param serviceCode
	 * @throws Exception
	 */
	public void parse(VRMap serviceDetail, Date targetDate, QP001PatientState patientState, VRMap serviceCode)
			throws Exception {

		Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE", serviceDetail);

		// 住所地特例の施設所在保険者番号
		String jushotiTokureiInsurerId = getJushotiTokureiInsurerId(targetServiceDate, patientState, serviceCode);

		if (ACTextUtilities.isNullText(jushotiTokureiInsurerId)) {
			// 住所地特例ではない（通常の明細レコード）

			// 明細情報レコードを取得
			QP001RecordDetail detail = QP001RecordDetail.getInstance(identificationNo, targetDate, targetServiceDate,
					serviceDetail, serviceCode, patientState, detailMap, manager);

			// レコードが作成されていれば
			if (detail != null) {
				// 明細情報データ解析
				detail.parse(serviceDetail, targetDate, patientState, serviceCode, identificationNo, manager);
			}
		} else {
			// 住所地特例の明細情報レコードを取得
			QP001RecordDetailJushotiTokurei detailJushotiTokurei = QP001RecordDetailJushotiTokurei.getInstance(
					identificationNo, targetDate, targetServiceDate, serviceDetail, serviceCode, patientState,
					detailMap, manager, jushotiTokureiInsurerId);

			// レコードが作成されていれば
			if (detailJushotiTokurei != null) {
				// 明細情報データ解析
				detailJushotiTokurei.parse(serviceDetail, targetDate, patientState, serviceCode, identificationNo,
						manager);
			}

		}

	}


	/**
	 * データの確定を行う。
	 */
	public void commitRecords(QP001PatientState patientState, VRMap styles, VRMap planUnitMap) throws Exception {
		String serial = "";
		QP001RecordDetail detail = null;
		Iterator it;

		List<Map> records = new ArrayList<Map>();
		records.add(detailMap);
		QP001KohiKey[] kohiTypes = getKohiApplyArray(records);

		// 明細情報レコードの確定処理
		it = detailMap.keySet().iterator();
		while (it.hasNext()) {
			// 作成した明細情報レコードの確定を行う。
			((QP001RecordDetail) detailMap.get(it.next())).commitRecord(kohiTypes, patientState);
		}


		it = detailMap.keySet().iterator();
		// 集計情報レコードの作成
		while (it.hasNext()) {
			detail = ((QP001RecordDetail) detailMap.get(it.next()));
			serial = QP001RecordType.getSerialId(detail);
			QP001RecordType type = null;
			if (!typeMap.containsKey(serial)) {
				type = new QP001RecordType();
				typeMap.put(serial, type);
			} else {
				type = (QP001RecordType) typeMap.get(serial);
			}
			type.parse(detail, patientState, manager);
		}

		it = typeMap.keySet().iterator();
		QP001RecordType type;
		// 集計情報レコードの確定処理
		while (it.hasNext()) {
			type = ((QP001RecordType) typeMap.get(it.next()));
			type.commitRecord(kohiTypes, patientState, styles, planUnitMap);
		}

		it = typeMap.keySet().iterator();
		while (it.hasNext()) {
			base.parse((QP001RecordType) typeMap.get(it.next()), patientState, kohiTypes, manager);
		}

	}

	// 明細情報（住所地特例）の対象レコードであれば、施設所在保険者番号を返します。
	// 対象外の場合は空文字をかえします。
	private String getJushotiTokureiInsurerId(Object targetServiceDate, QP001PatientState patientState,
			VRMap serviceCode) throws Exception {

		// 対象日を月末日にセット
		targetServiceDate = ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(targetServiceDate));

		// 対象日時点の住所地特例の施設所在保険者番号
		return patientState.getJushotiTokureiInsurerId(targetServiceDate);
	}

	/**
	 * DB登録用のレコード集合を作成します。
	 * 
	 * @param patient_id
	 * @param targetDate
	 * @return
	 * @throws Exception
	 */
	public VRList getRecords(int patient_id, Date claimDate) throws Exception {
		VRList list = new VRArrayList();
		VRHashMap style = new VRHashMap();

		// データが正常に生成されていない場合は処理を終了する。
		if (ACTextUtilities.isNullText(base.get_201003())) {
			return list;
		}

		// 帳票の様式番号
		style.put("CLAIM_STYLE_TYPE", ACCastUtilities.toString(claimStyleFormat));
		// 利用者ＩＤ
		style.put("PATIENT_ID", Integer.toString(patient_id));
		// 基本情報レコードから取得
		// 利用者番号(被保険者番号)
		style.put("INSURED_ID", base.get_201006());
		// 請求の対象となる年月(サービス提供年月)
		style.put("TARGET_DATE", ACCastUtilities.toDate(base.get_201003() + "01"));
		// 請求を行う年月日
		style.put("CLAIM_DATE", claimDate);
		// 請求元事業所
		style.put("PROVIDER_ID", base.get_201004());

		// 保険者番号
		style.put("INSURER_ID", base.get_201005());
		// 被保険者番号
		style.put("INSURED_ID", base.get_201006());

		style.put("CLAIM_FINISH_FLAG", "0");

		// 明細情報レコード
		Iterator it = detailMap.keySet().iterator();
		while (it.hasNext()) {
			list.add(((QP001RecordDetail) detailMap.get(it.next())).getRecord(style));
		}

		// 集計情報レコード
		it = typeMap.keySet().iterator();
		while (it.hasNext()) {
			list.add(((QP001RecordType) typeMap.get(it.next())).getRecord(style));
		}
		list.add(base.getRecord(style));

		return list;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		// 明細情報レコード
		Iterator it = detailMap.keySet().iterator();
		while (it.hasNext()) {
			result.append("Detail\n");
			result.append(((QP001RecordDetail) detailMap.get(it.next())));
		}
		// 集計情報レコード
		it = typeMap.keySet().iterator();
		while (it.hasNext()) {
			result.append("Type\n");
			result.append((QP001RecordType) typeMap.get(it.next()));
		}
		// 基本情報レコード
		result.append("Base\n");
		result.append(base);

		return result.toString();
	}

}
