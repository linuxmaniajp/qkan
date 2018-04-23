
/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKANCHO�iJMA care benefit management software�j
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
 * ��{�E�v��񃌃R�[�h�̍쐬���s���܂��B
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
     * ���R�[�h�̍쐬���s���T�[�r�X���ǂ�����Ԃ��܂��B
     */
	public static boolean isMakeRecord(String identificationNo,
			VRMap serviceDetail,
			VRMap serviceCode) {
		
        //�l���S�|�R�A�S�|�S�A�X�|�Q�łȂ���ΑΏۊO
		if (!identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_4_3_201804)
				&& !identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_4_4_201804)
				&& !identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_9_2_201804)) {
			return false;
		}
		
		// �E�v���L�ڕK�{�t���O<=1�̏ꍇ�A�ΏۊO
		int summaryFlg = ACCastUtilities.toInt(serviceCode.get("SUMMARY_FLAG"), 0);
		if (summaryFlg <= 1) {
			return false;
		}
		
		int gaihaku = CareServiceCommon.isGaihaku(serviceDetail);
		// �O���͑ΏۊO
		if (gaihaku == 2) {
			return false;
		}
		
		// 30�����͑ΏۊO
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
		//�������ʔԍ�
		sb.append(identificationNo);
		//���R�[�h��ʃR�[�h2��
		sb.append(QP001RecordBaseSummary.get_1901002());
		//�T�[�r�X�񋟔N��6��(YYYYMM)
		sb.append(VRDateParser.format(targetDate,"yyyyMM"));
		//���Ə��ԍ�10��
		sb.append(VRBindPathParser.get("PROVIDER_ID",serviceDetail));
		//�؋L�ڕی��Ҕԍ�8��
		sb.append(patientState.getInsurerId(targetServiceDate));
		//��ی��Ҕԍ�10��
		sb.append(patientState.getInsuredId(targetServiceDate));
		//�V�X�e�����T�[�r�X��ރR�[�h
		sb.append(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", serviceDetail));
		
		//�V���A���ԍ���ݒ�B
		this.serialHeader = sb.toString();
		
		this.identificationNo = identificationNo;
		this.serviceDetail = serviceDetail;
		this.targetDate = targetDate;
		this.patientState = patientState;
		this.serviceCode = serviceCode;
		this.baseSummaryMap = baseSummaryMap;
        this.manager = manager;
	}
	
	// �E�v���L�ڕK�{�t���O���A��{�E�v���̎�ރR�[�h���擾����
	private static List<String> getBaseSummaryKinds(int summaryFlg) {
		List<String> kinds = new ArrayList<String>();		
        switch (summaryFlg) {
        case 2:
        	kinds.add("02");//���p�ҏ�ԓ��R�[�h
        	break;
        case 3:
        	kinds.add("01");//DPC�R�[�h(6��)
        	kinds.add("02");//���p�ҏ�ԓ��R�[�h
        	break;
        }
		return kinds;
	}
	
	/**
	 * ��{�E�v��񃌃R�[�h���쐬���܂��B
	 * @return
	 * @throws Exception
	 */
	protected Map<String, QP001RecordBaseSummary> make() throws Exception {

		int summaryFlg = ACCastUtilities.toInt(serviceCode.get("SUMMARY_FLAG"), 0);
		// �E�v���L�ڕK�{�t���O���A��{�E�v���̎�ރR�[�h���擾����
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
