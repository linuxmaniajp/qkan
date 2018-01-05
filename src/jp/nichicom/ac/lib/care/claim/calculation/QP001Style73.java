
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
 *****************************************************************
 * �A�v��: QKANCHO
 * �J����: �T��
 * �쐬��: 2017/06/30
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� �l����� (QP001Style73)
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
 * �l����V�|�R�꒠�[���̏��
 * �l���V�|�P�A�V�|�Q�Ƃ̓f�[�^�\�����Ⴄ���ߕʃN���X�Ƃ��č쐬
 */
public class QP001Style73 extends QP001StyleAbstract {

	/**
	 * ���׏�񃌃R�[�h�W��
	 */
	private VRMap detailMap = new VRHashMap();
	/**
	 * �W�v��񃌃R�[�h�W��
	 */
	private Map<String, QP001RecordType> typeMap = new TreeMap<String, QP001RecordType>();
	/**
	 * ��{��񃌃R�[�h(�꒠�[�ɂЂƂ�)
	 */
	private QP001RecordBase base = new QP001RecordBase();

	/**
	 * �����l���ԍ�
	 */
	private int claimStyleFormat = 0;
	/**
	 * �������ʔԍ�
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
		// 201001 ������񎯕ʔԍ�4��
		serial.append(getIdentificationNo(claimStyleFormat, targetDate));
		// �T�[�r�X�񋟔N��6��(YYYYMM)
		serial.append(VRDateParser.format(targetDate, "yyyyMM"));
		// ���Ə��ԍ�10��
		serial.append(VRBindPathParser.get("PROVIDER_ID", serviceDetail));
		// �؋L�ڕی��Ҕԍ�8��
		serial.append(patientState.getInsurerId(VRBindPathParser.get("SERVICE_DATE", serviceDetail)));
		// ��ی��Ҕԍ�10��
		serial.append(patientState.getInsuredId(VRBindPathParser.get("SERVICE_DATE", serviceDetail)));

		return serial.toString();
	}

	/**
	 * �f�[�^�̉�͂����s����B
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

		// �Z���n����̎{�ݏ��ݕی��Ҕԍ�
		String jushotiTokureiInsurerId = getJushotiTokureiInsurerId(targetServiceDate, patientState, serviceCode);

		if (ACTextUtilities.isNullText(jushotiTokureiInsurerId)) {
			// �Z���n����ł͂Ȃ��i�ʏ�̖��׃��R�[�h�j

			// ���׏�񃌃R�[�h���擾
			QP001RecordDetail detail = QP001RecordDetail.getInstance(identificationNo, targetDate, targetServiceDate,
					serviceDetail, serviceCode, patientState, detailMap, manager);

			// ���R�[�h���쐬����Ă����
			if (detail != null) {
				// ���׏��f�[�^���
				detail.parse(serviceDetail, targetDate, patientState, serviceCode, identificationNo, manager);
			}
		} else {
			// �Z���n����̖��׏�񃌃R�[�h���擾
			QP001RecordDetailJushotiTokurei detailJushotiTokurei = QP001RecordDetailJushotiTokurei.getInstance(
					identificationNo, targetDate, targetServiceDate, serviceDetail, serviceCode, patientState,
					detailMap, manager, jushotiTokureiInsurerId);

			// ���R�[�h���쐬����Ă����
			if (detailJushotiTokurei != null) {
				// ���׏��f�[�^���
				detailJushotiTokurei.parse(serviceDetail, targetDate, patientState, serviceCode, identificationNo,
						manager);
			}

		}

	}


	/**
	 * �f�[�^�̊m����s���B
	 */
	public void commitRecords(QP001PatientState patientState, VRMap styles, VRMap planUnitMap) throws Exception {
		String serial = "";
		QP001RecordDetail detail = null;
		Iterator it;

		List<Map> records = new ArrayList<Map>();
		records.add(detailMap);
		QP001KohiKey[] kohiTypes = getKohiApplyArray(records);

		// ���׏�񃌃R�[�h�̊m�菈��
		it = detailMap.keySet().iterator();
		while (it.hasNext()) {
			// �쐬�������׏�񃌃R�[�h�̊m����s���B
			((QP001RecordDetail) detailMap.get(it.next())).commitRecord(kohiTypes, patientState);
		}


		it = detailMap.keySet().iterator();
		// �W�v��񃌃R�[�h�̍쐬
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
		// �W�v��񃌃R�[�h�̊m�菈��
		while (it.hasNext()) {
			type = ((QP001RecordType) typeMap.get(it.next()));
			type.commitRecord(kohiTypes, patientState, styles, planUnitMap);
		}

		it = typeMap.keySet().iterator();
		while (it.hasNext()) {
			base.parse((QP001RecordType) typeMap.get(it.next()), patientState, kohiTypes, manager);
		}

	}

	// ���׏��i�Z���n����j�̑Ώۃ��R�[�h�ł���΁A�{�ݏ��ݕی��Ҕԍ���Ԃ��܂��B
	// �ΏۊO�̏ꍇ�͋󕶎����������܂��B
	private String getJushotiTokureiInsurerId(Object targetServiceDate, QP001PatientState patientState,
			VRMap serviceCode) throws Exception {

		// �Ώۓ����������ɃZ�b�g
		targetServiceDate = ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(targetServiceDate));

		// �Ώۓ����_�̏Z���n����̎{�ݏ��ݕی��Ҕԍ�
		return patientState.getJushotiTokureiInsurerId(targetServiceDate);
	}

	/**
	 * DB�o�^�p�̃��R�[�h�W�����쐬���܂��B
	 * 
	 * @param patient_id
	 * @param targetDate
	 * @return
	 * @throws Exception
	 */
	public VRList getRecords(int patient_id, Date claimDate) throws Exception {
		VRList list = new VRArrayList();
		VRHashMap style = new VRHashMap();

		// �f�[�^������ɐ�������Ă��Ȃ��ꍇ�͏������I������B
		if (ACTextUtilities.isNullText(base.get_201003())) {
			return list;
		}

		// ���[�̗l���ԍ�
		style.put("CLAIM_STYLE_TYPE", ACCastUtilities.toString(claimStyleFormat));
		// ���p�҂h�c
		style.put("PATIENT_ID", Integer.toString(patient_id));
		// ��{��񃌃R�[�h����擾
		// ���p�Ҕԍ�(��ی��Ҕԍ�)
		style.put("INSURED_ID", base.get_201006());
		// �����̑ΏۂƂȂ�N��(�T�[�r�X�񋟔N��)
		style.put("TARGET_DATE", ACCastUtilities.toDate(base.get_201003() + "01"));
		// �������s���N����
		style.put("CLAIM_DATE", claimDate);
		// ���������Ə�
		style.put("PROVIDER_ID", base.get_201004());

		// �ی��Ҕԍ�
		style.put("INSURER_ID", base.get_201005());
		// ��ی��Ҕԍ�
		style.put("INSURED_ID", base.get_201006());

		style.put("CLAIM_FINISH_FLAG", "0");

		// ���׏�񃌃R�[�h
		Iterator it = detailMap.keySet().iterator();
		while (it.hasNext()) {
			list.add(((QP001RecordDetail) detailMap.get(it.next())).getRecord(style));
		}

		// �W�v��񃌃R�[�h
		it = typeMap.keySet().iterator();
		while (it.hasNext()) {
			list.add(((QP001RecordType) typeMap.get(it.next())).getRecord(style));
		}
		list.add(base.getRecord(style));

		return list;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		// ���׏�񃌃R�[�h
		Iterator it = detailMap.keySet().iterator();
		while (it.hasNext()) {
			result.append("Detail\n");
			result.append(((QP001RecordDetail) detailMap.get(it.next())));
		}
		// �W�v��񃌃R�[�h
		it = typeMap.keySet().iterator();
		while (it.hasNext()) {
			result.append("Type\n");
			result.append((QP001RecordType) typeMap.get(it.next()));
		}
		// ��{��񃌃R�[�h
		result.append("Base\n");
		result.append(base);

		return result.toString();
	}

}
