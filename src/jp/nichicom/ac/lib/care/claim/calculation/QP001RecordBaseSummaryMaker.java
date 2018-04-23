
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

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRMap;

/**
 * 基本摘要情報レコードの作成を行います。
 *
 */
public class QP001RecordBaseSummaryMaker {
	
	private String serialHeader = "";
	private String identificationNo = "";
	private VRMap serviceDetail = null;
	private Date targetDate = null;
	private QP001PatientState patientState = null;
	private VRMap serviceCode = null;
	private Map<String, QP001RecordBaseSummary> baseSummaryMap = null;
    private QP001Manager manager = null;
    
    /**
     * レコードの作成を行うサービスかどうかを返します。
     */
	public static boolean isMakeRecord(String identificationNo,
			VRMap serviceDetail,
			VRMap serviceCode) {
		
        //様式４－３、４－４、９－２でなければ対象外
		if (!identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_4_3_201804)
				&& !identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_4_4_201804)
				&& !identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_9_2_201804)) {
			return false;
		}
		
		// 摘要欄記載必須フラグ<=1の場合、対象外
		int summaryFlg = ACCastUtilities.toInt(serviceCode.get("SUMMARY_FLAG"), 0);
		if (summaryFlg <= 1) {
			return false;
		}
		
		int gaihaku = CareServiceCommon.isGaihaku(serviceDetail);
		// 外泊は対象外
		if (gaihaku == 2) {
			return false;
		}
		
		// 30日超は対象外
		if (ACCastUtilities.toInt(serviceDetail.get("5"), 0) == 2) {
			return false;
		}
				
		return true;		
	}
	
	protected QP001RecordBaseSummaryMaker (
			 String identificationNo,
			 VRMap serviceDetail,
			 Date targetDate,
			 Object targetServiceDate,
			 QP001PatientState patientState,
			 VRMap serviceCode,
			 Map<String, QP001RecordBaseSummary> baseSummaryMap,
             QP001Manager manager) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		//交換識別番号
		sb.append(identificationNo);
		//レコード種別コード2桁
		sb.append(QP001RecordBaseSummary.get_1901002());
		//サービス提供年月6桁(YYYYMM)
		sb.append(VRDateParser.format(targetDate,"yyyyMM"));
		//事業所番号10桁
		sb.append(VRBindPathParser.get("PROVIDER_ID",serviceDetail));
		//証記載保険者番号8桁
		sb.append(patientState.getInsurerId(targetServiceDate));
		//被保険者番号10桁
		sb.append(patientState.getInsuredId(targetServiceDate));
		//システム内サービス種類コード
		sb.append(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", serviceDetail));
		
		//シリアル番号を設定。
		this.serialHeader = sb.toString();
		
		this.identificationNo = identificationNo;
		this.serviceDetail = serviceDetail;
		this.targetDate = targetDate;
		this.patientState = patientState;
		this.serviceCode = serviceCode;
		this.baseSummaryMap = baseSummaryMap;
        this.manager = manager;
	}
	
	// 摘要欄記載必須フラグより、基本摘要情報の種類コードを取得する
	private static List<String> getBaseSummaryKinds(int summaryFlg) {
		List<String> kinds = new ArrayList<String>();		
        switch (summaryFlg) {
        case 2:
        	kinds.add("02");//利用者状態等コード
        	break;
        case 3:
        	kinds.add("01");//DPCコード(6桁)
        	kinds.add("02");//利用者状態等コード
        	break;
        }
		return kinds;
	}
	
	/**
	 * 基本摘要情報レコードを作成します。
	 * @return
	 * @throws Exception
	 */
	protected Map<String, QP001RecordBaseSummary> make() throws Exception {

		int summaryFlg = ACCastUtilities.toInt(serviceCode.get("SUMMARY_FLAG"), 0);
		// 摘要欄記載必須フラグより、基本摘要情報の種類コードを取得する
		List<String> kinds = QP001RecordBaseSummaryMaker.getBaseSummaryKinds(summaryFlg);
		for (String kind : kinds) {
			parseRecord(kind);
		}
		return baseSummaryMap;
	}
	
	private void parseRecord(String baseSummaryKind) throws Exception {
		QP001RecordBaseSummary summary = getRecord(baseSummaryKind);
		summary.parse(serviceDetail, targetDate, patientState, serviceCode, identificationNo, manager, baseSummaryKind);
	}

	private QP001RecordBaseSummary getRecord(String baseSummaryKind) throws Exception {
		QP001RecordBaseSummary summary = null;
		String serial = this.serialHeader + baseSummaryKind;
		if (baseSummaryMap.containsKey(serial)) {
			summary = (QP001RecordBaseSummary) baseSummaryMap.get(serial);
		} else {
			summary = new QP001RecordBaseSummary();
			baseSummaryMap.put(serial, summary);
		}
		return summary;
	}

}
