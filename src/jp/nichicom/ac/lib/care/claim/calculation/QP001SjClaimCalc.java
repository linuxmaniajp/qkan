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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjTankaManager;

/**
 * �������� �Ǝ��E�Ǝ��藦�E�Ǝ���z�Z��N���X
 * 
 * �T�[�r�X��ނ��Ƃ̎��Ɣ���z�A������z�A���p�ҕ��S�z�����v�Z���܂�
 * 
 * @author Yoichiro Kamei
 * 
 */
public class QP001SjClaimCalc {

	// ����D�揇�^�C�v
	public enum KohiyusenType {
		NONE, // ����
		KOHI1, // ����P
		KOHI2, // ����Q
		KOHI3 // ����R
	};

	private String skind; // �T�[�r�X��ރR�[�h(2��)

	// �敪�x�����x���P�ʐ��̊i�[���ꂽ�}�b�v
	// �L�[�́A
	// �Ǝ��藦�F�T�[�r�X���-�P�ʐ��P��-���t��
	// �Ǝ���z�F�T�[�r�X���-�P�ʐ��P��-�T�[�r�X���ڃR�[�h
	private Map<String, Integer> sogoLimitOverMap;

	private Integer hokenKyufuritsu = null;// �ی����t��
	private Boolean isSeihotandoku = null; // ���ےP�Ƃ��ǂ���
	private int dokujiTotalSeikyugaku; // �Ǝ��̑S�̂̐����z
	private int dokujiJigyohiSeikyugaku;// �Ǝ��̎��Ɣ���z
	
	private int teiritsuTotalSeikyugaku; // �Ǝ��藦�̑S�̂̐����z
	private int teiritsuJigyohiSeikyugaku; // �Ǝ��藦�̎��Ɣ���z

	private int teigakuTotalSeikyugaku; // �Ǝ���z�̑S�̂̐����z
	private int teigakuRiyoshaFutangaku; // �Ǝ���z�̗��p�ҕ��S�z
	private int teigakuKohi1Seikyugaku; // �Ǝ���z�̌���P�����z
	private int teigakuKohi2Seikyugaku; // �Ǝ���z�̌���Q�����z
	private int teigakuKohi3Seikyugaku; // �Ǝ���z�̌���R�����z

	private static final String SERVICE_ITEM_CODE = "SERVICE_ITEM_CODE"; // �T�[�r�X���ڃR�[�h(4��)
	private static final String TEIGAKU_FUTAN_TANKA = "TEIGAKU_FUTAN_TANKA"; // �Ǝ���z�̒�z���S�P�����z
	private static final String SOGO_KYUFURITSU = "SOGO_KYUFURITSU"; // �Ǝ��藦�̋��t��

	private static final String UNIT = "UNIT"; // �P�ʐ�
	private static final String SERVICE_COUNT = "SERVICE_COUNT"; // ��
	private static final String SERVICE_UNIT = "SERVICE_UNIT"; // �T�[�r�X�P�ʐ�

	private static final String KOHI1_COUNT = "KOHI1_COUNT"; // ����P����
	private static final String KOHI1_SERVICE_UNIT = "KOHI1_SERVICE_UNIT"; // ����P�ΏےP�ʐ�

	private static final String KOHI2_COUNT = "KOHI2_COUNT"; // ����Q����
	private static final String KOHI2_SERVICE_UNIT = "KOHI2_SERVICE_UNIT"; // ����Q�ΏےP�ʐ�

	private static final String KOHI3_COUNT = "KOHI3_COUNT"; // ����R����
	private static final String KOHI3_SERVICE_UNIT = "KOHI3_SERVICE_UNIT"; // ����R�ΏےP�ʐ�

	private Map<Double, List<Map<String, Object>>> dokujiMap = new HashMap<Double, List<Map<String, Object>>>();
	private Map<Double, Map<Integer, List<Map<String, Object>>>> teiritsuMap = new HashMap<Double, Map<Integer, List<Map<String, Object>>>>();
	private Map<Double, List<Map<String, Object>>> teigakuMap = new HashMap<Double, List<Map<String, Object>>>();

	/**
	 * �R���X�g���N�^�B
	 * 
	 * @param skind
	 *            �T�[�r�X��ރR�[�h
	 * @param sogoLimitOverMap
	 *            �敪�x�����P�ʐ��}�b�v
	 */
	public QP001SjClaimCalc(String skind,
			Map sogoLimitOverMap) throws Exception {
		this.skind = skind;
		this.sogoLimitOverMap = sogoLimitOverMap;
	}

	/**
	 * �m��ς݂�QP001RecordDetail����͂��܂��B
	 * 
	 * �Ǝ��藦�F�P�ʐ��P���A���t�����ƂɊi�[ �Ǝ���z�F�P�ʐ��P���A�V�X�e���T�[�r�X���ڃR�[�h���ƂɊi�[
	 * 
	 * @param detail
	 *            QP001RecordDetail
	 * @throws Exception
	 */
	public void parseRecordDetail(QP001RecordDetail detail) throws Exception {
		// �ی����t��
		if (hokenKyufuritsu == null) {
			hokenKyufuritsu = ACCastUtilities.toInt(detail.get_301026(), 0);
		}
		// ���ےP�Ƃ��ǂ���
		if (isSeihotandoku == null) {
			String hihoban = ACCastUtilities.toString(detail.get_301006(), "");
			isSeihotandoku = hihoban.startsWith("H");
		}
		// �ی��Ҕԍ�
		String insurerId;
		if (detail instanceof QP001RecordDetailJushotiTokurei) {
			insurerId = ((QP001RecordDetailJushotiTokurei) detail).get_1801018();
		} else {
			insurerId = ACCastUtilities.toString(detail.get_301005());
		}
		
		String systemServiceKindDetail = ACCastUtilities.toString(detail.get_301021());
		// �������Ƃ̒P�ʐ��P��
		Double unitPrice = QkanSjTankaManager.getUnitPrice(insurerId,
				systemServiceKindDetail);

		Integer kyufuritsu = ACCastUtilities.toInteger(detail.get_301028(),
				0);
		Integer teigakuFutan = ACCastUtilities.toInteger(detail.get_301029(),
				0);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(SERVICE_ITEM_CODE, detail.get_301008());
		map.put(SOGO_KYUFURITSU, kyufuritsu);
		map.put(TEIGAKU_FUTAN_TANKA, teigakuFutan);
		map.put(UNIT, detail.get_301009());
		map.put(SERVICE_COUNT, detail.get_301010());
		map.put(SERVICE_UNIT, detail.get_301014());
		map.put(KOHI1_COUNT, detail.get_301011());
		map.put(KOHI1_SERVICE_UNIT, detail.get_301015());
		map.put(KOHI2_COUNT, detail.get_301012());
		map.put(KOHI2_SERVICE_UNIT, detail.get_301016());
		map.put(KOHI3_COUNT, detail.get_301013());
		map.put(KOHI3_SERVICE_UNIT, detail.get_301017());

		// �Ǝ�
		// �P��-���׃��R�[�hList�̊K�w�Ŋi�[
		if (QkanSjServiceCodeManager.dokujiKinds.contains(skind)) {
			addDokujiMap(unitPrice, map);
		}
		
		// �Ǝ��藦
		// �P��-���t��-���׃��R�[�hList�̊K�w�Ŋi�[
		if (QkanSjServiceCodeManager.teiritsuKinds.contains(skind)) {
			addTeiritsuMap(unitPrice, kyufuritsu, map);
		}

		// �Ǝ���z
		// �P��-���׃��R�[�hList�̊K�w�Ŋi�[
		if (QkanSjServiceCodeManager.teigakuKinds.contains(skind)) {
			addTeigakuMap(unitPrice, map);
		}
	}
	
	
	/**
	 * �ďW�v���̖��׃��R�[�h����͂��܂��B
	 * 
	 * �Ǝ��藦�F�P�ʐ��P���A���t�����ƂɊi�[ �Ǝ���z�F�P�ʐ��P���A�V�X�e���T�[�r�X���ڃR�[�h���ƂɊi�[
	 * 
	 * @param detail �ďW�v���̖��׃��R�[�h
	 * @param rate �ی����t��
	 *            
	 * @throws Exception
	 */
	public void parseDetailForReTotal(Map detail, int rate) throws Exception {
		// �ی����t��
		if (hokenKyufuritsu == null) {
			hokenKyufuritsu = rate;
		}
		// ���ےP�Ƃ��ǂ���
		if (isSeihotandoku == null) {
			String hihoban = ACCastUtilities.toString(detail.get("301006"), "");
			isSeihotandoku = hihoban.startsWith("H");
		}
		// �ی��Ҕԍ�
		String insurerId;
		if (detail.get("1801018") != null) {
			insurerId = ACCastUtilities.toString(detail.get("1801018"));
		} else {
			insurerId = ACCastUtilities.toString(detail.get("301005"));
		}
		
		String systemServiceKindDetail = ACCastUtilities.toString(detail.get("301021"));
		// �������Ƃ̒P�ʐ��P��
		Double unitPrice = QkanSjTankaManager.getUnitPrice(insurerId,
				systemServiceKindDetail);

		Integer kyufuritsu = ACCastUtilities.toInteger(detail.get("301028"),
				0);
		Integer teigakuFutan = ACCastUtilities.toInteger(detail.get("301029"),
				0);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(SERVICE_ITEM_CODE, detail.get("301008"));
		map.put(SOGO_KYUFURITSU, kyufuritsu);
		map.put(TEIGAKU_FUTAN_TANKA, teigakuFutan);
		map.put(UNIT, detail.get("301009"));
		map.put(SERVICE_COUNT, detail.get("301010"));
		map.put(SERVICE_UNIT, detail.get("301014"));
		map.put(KOHI1_COUNT, detail.get("301011"));
		map.put(KOHI1_SERVICE_UNIT, detail.get("301015"));
		map.put(KOHI2_COUNT, detail.get("301012"));
		map.put(KOHI2_SERVICE_UNIT, detail.get("301016"));
		map.put(KOHI3_COUNT, detail.get("301013"));
		map.put(KOHI3_SERVICE_UNIT, detail.get("301017"));

		// �Ǝ�
		// �P��-���׃��R�[�hList�̊K�w�Ŋi�[
		if (QkanSjServiceCodeManager.dokujiKinds.contains(skind)) {
			addDokujiMap(unitPrice, map);
		}
		
		// �Ǝ��藦
		// �P��-���t��-���׃��R�[�hList�̊K�w�Ŋi�[
		if (QkanSjServiceCodeManager.teiritsuKinds.contains(skind)) {
			addTeiritsuMap(unitPrice, kyufuritsu, map);
		}

		// �Ǝ���z
		// �P��-���׃��R�[�hList�̊K�w�Ŋi�[
		if (QkanSjServiceCodeManager.teigakuKinds.contains(skind)) {
			addTeigakuMap(unitPrice, map);
		}
	}

	// �Ǝ��̖��׃��R�[�h�i�[
	private void addDokujiMap(Double unitPrice, Map<String, Object> detail) {
		// �P��
		List<Map<String, Object>> details;
		if (this.dokujiMap.containsKey(unitPrice)) {
			details = this.dokujiMap.get(unitPrice);
		} else {
			details = new ArrayList<Map<String, Object>>();
			this.dokujiMap.put(unitPrice, details);
		}
		details.add(detail);
	}
	
	// �Ǝ��藦�̖��׃��R�[�h�i�[
	private void addTeiritsuMap(Double unitPrice, Integer kyufuritsu,
			Map<String, Object> detail) {
		// �P��
		Map<Integer, List<Map<String, Object>>> kyufuritsuMap;
		if (this.teiritsuMap.containsKey(unitPrice)) {
			kyufuritsuMap = this.teiritsuMap.get(unitPrice);
		} else {
			kyufuritsuMap = new HashMap<Integer, List<Map<String, Object>>>();
			this.teiritsuMap.put(unitPrice, kyufuritsuMap);
		}
		// ���t��
		List<Map<String, Object>> details;
		if (kyufuritsuMap.containsKey(kyufuritsu)) {
			details = kyufuritsuMap.get(kyufuritsu);
		} else {
			details = new ArrayList<Map<String, Object>>();
			kyufuritsuMap.put(kyufuritsu, details);
		}
		details.add(detail);
	}

	// �Ǝ���z�̖��׃��R�[�h�i�[
	private void addTeigakuMap(Double unitPrice, Map<String, Object> detail) {
		// �P��
		List<Map<String, Object>> details;
		if (this.teigakuMap.containsKey(unitPrice)) {
			details = this.teigakuMap.get(unitPrice);
		} else {
			details = new ArrayList<Map<String, Object>>();
			this.teigakuMap.put(unitPrice, details);
		}
		details.add(detail);
	}

	/**
	 * �T�[�r�X��ނ��Ƃ̎��Ɣ���z�A������z�A���p�ҕ��S�z�����v�Z���܂��B
	 * @throws Exception
	 */
	public void calculate() throws Exception {
		if (!this.dokujiMap.isEmpty()) {
			calcDokuji();
		} else if (!this.teiritsuMap.isEmpty()) {
			calcTeiritsu();
		} else if (!this.teigakuMap.isEmpty()) {
			calcTeigaku();
		}
	}
	
	/**
	 * �Ǝ����v�Z���܂��B
	 * 
	 */
	private void calcDokuji() {
		this.dokujiTotalSeikyugaku = 0;
		this.dokujiJigyohiSeikyugaku = 0;

		// �P�����ƂɑS�̂̐����z���v�Z���č��Z��A�ی����t�����|����
		for (Double unitPrice : this.dokujiMap.keySet()) {
			List<Map<String, Object>> details = dokujiMap.get(unitPrice);
			int serviceUnit = 0;
			for (Map<String, Object> detail : details) {
				serviceUnit += ACCastUtilities.toInt(
						detail.get(SERVICE_UNIT), 0);
			}
			// ���ߕ��̒P�ʐ�������
			int limitOverUnit = getDokujiLimitOverUnit(unitPrice);
			serviceUnit = serviceUnit - limitOverUnit;

			// �ΏےP�ʐ��~�P�ʐ��P��(�����_�ȉ��؎̂�)
			int totalUnit = (int) Math
					.floor((double) (serviceUnit * getUnitPriceMultiplies100(unitPrice)) / 100d);
			this.dokujiTotalSeikyugaku += totalUnit;
		}
		// �ی����t��
		this.dokujiJigyohiSeikyugaku = (int) Math.floor((this.dokujiTotalSeikyugaku * hokenKyufuritsu.intValue()) / 100d);
		// ���ےP�Ƃ̏ꍇ
		if (isSeihotandoku) {
			this.dokujiJigyohiSeikyugaku = 0;
		}
	}
	
	/**
	 * �Ǝ��̑S�̂̐����z���擾���܂��B �icalculate��ɌĂԁj
	 * 
	 * @return �Ǝ��̑S�̂̐����z
	 */
	public int getDokujiTotalSeikyugaku() {
		return dokujiTotalSeikyugaku;
	}

	/**
	 * �Ǝ��̎��Ɣ���z���擾���܂��B �icalculate��ɌĂԁj
	 * 
	 * @return �Ǝ��̎��Ɣ���z
	 */
	public int getDokujiJigyohiSeikyugaku() {
		return dokujiJigyohiSeikyugaku;
	}
	
	/**
	 * �Ǝ��̌�����z���v�Z���ĕԂ��܂��B
	 * 
	 * @param type
	 *            ����D�揇�^�C�v
	 * @param hokenUnit
	 *            �ی��ΏےP�ʐ� (701014)
	 * @param kohiUnit
	 *            ����ΏےP�ʐ�
	 * @param ratio
	 *            ����t���i��F95-100)
	 * @param reduction
	 *            ��ʗD�揇�̌�����z�Ƃ��Čv��ς̋��z
	 * @param usedRate
	 *            ��ʗD�揇�̌���t��
	 * @param tumiageUnit
	 *            ��ʗD�揇�̌���ΏےP�ʐ��Ƃ��Čv��ς̒P�ʐ�
	 * 
	 * @return �Ǝ��藦�̌�����z
	 */
	public int calcDokujiKohiSeikyugaku(KohiyusenType type, int hokenUnit,
			int kohiUnit, int ratio, int reduction, int usedRate,
			int tumiageUnit) {
		// ����t����100%�Ō���ΏےP�ʐ����ی��P�ʐ��̏ꍇ
		// �܂��́A����t����100%�Ō���ΏےP�ʐ���ςݏグ�����ʂ��T�[�r�X�P�ʐ��Ɠ������ꍇ
		if (((ratio == 100) && (hokenUnit == kohiUnit))
				|| ((ratio == 100) && (hokenUnit == (kohiUnit + tumiageUnit)))) {
			// �S�̂̐����z���玖�Ɣ���z������������
			return this.dokujiTotalSeikyugaku
					- this.dokujiJigyohiSeikyugaku - reduction;
		} else {
			return calcDokujiKohiSeikyugaku(type, ratio,
					usedRate);
		}
	}
	
	/**
	 * �Ǝ��̌�����z���v�Z���ĕԂ��܂��B ��ʗD�揇�̌���t�����g�p
	 * 
	 * @param type
	 *            ����D�揇�^�C�v
	 * @param ratio
	 *            ����t���i��F95-100)
	 * @param usedRate
	 *            ��ʗD�揇�̌���t��
	 * 
	 * @return �Ǝ��̌�����z
	 */
	private int calcDokujiKohiSeikyugaku(KohiyusenType type,
			int ratio, int usedRate) {
		String unitKey = getKohiUnitKeyFromType(type);
		// usedRate���g�p����
		// �P�����ƂɌv�Z���āA���Z
		int totalUnit = 0;
		for (Double unitPrice : this.dokujiMap.keySet()) {
			List<Map<String, Object>> details = dokujiMap.get(unitPrice);

			int serviceUnit = 0;
			int kohiUnit = 0;
			for (Map<String, Object> detail : details) {
				serviceUnit += ACCastUtilities.toInt(detail.get(SERVICE_UNIT), 0);
				kohiUnit += ACCastUtilities.toInt(detail.get(unitKey), 0);
			}
			// ���ߕ��̒P�ʐ�������
			int limitOverUnit = getDokujiLimitOverUnit(unitPrice);
			serviceUnit = serviceUnit - limitOverUnit;
			if (serviceUnit < 0) {
				serviceUnit = 0;
			}
			// ����ΏےP�ʐ��̒����i���ߕ��̒P�ʐ��̂͂ݏo�����������j
			if (kohiUnit > serviceUnit) {
				kohiUnit = serviceUnit;
			}
			
			// ����ΏےP�ʐ��~�P�ʐ��P��(�����_�ȉ��؎̂�)
			totalUnit += (int) Math
					.floor((double) (kohiUnit * getUnitPriceMultiplies100(unitPrice)) / 100d);
		}
		// �~�i����t�� - ���t���j
		return (int) Math.floor((totalUnit * (ratio - usedRate)) / 100d);
	}
	
	
	/**
	 * �Ǝ��藦���v�Z���܂��B
	 * 
	 */
	private void calcTeiritsu() {
		this.teiritsuTotalSeikyugaku = 0;
		this.teiritsuJigyohiSeikyugaku = 0;

		// �P���A���t�����ƂɌv�Z���āA���Z
		for (Double unitPrice : this.teiritsuMap.keySet()) {
			Map<Integer, List<Map<String, Object>>> kyufuritsuMap = this.teiritsuMap
					.get(unitPrice);
			for (Integer kyufuritsu : kyufuritsuMap.keySet()) {
				List<Map<String, Object>> details = kyufuritsuMap
						.get(kyufuritsu);
				int serviceUnit = 0;
				for (Map<String, Object> detail : details) {
					serviceUnit += ACCastUtilities.toInt(
							detail.get(SERVICE_UNIT), 0);
				}
				// ���ߕ��̒P�ʐ�������
				int limitOverUnit = getTeiritsuLimitOverUnit(unitPrice,
						kyufuritsu);
				serviceUnit = serviceUnit - limitOverUnit;

				// �ΏےP�ʐ��~�P�ʐ��P��(�����_�ȉ��؎̂�)
				int totalUnit = (int) Math
						.floor((double) (serviceUnit * getUnitPriceMultiplies100(unitPrice)) / 100d);
				this.teiritsuTotalSeikyugaku += totalUnit;
				// �ی����t��
				totalUnit = (int) Math.floor((totalUnit * kyufuritsu) / 100d);
				this.teiritsuJigyohiSeikyugaku += totalUnit;
			}
		}
		// ���ےP�Ƃ̏ꍇ
		if (isSeihotandoku) {
			this.teiritsuJigyohiSeikyugaku = 0;
		}
	}

	/**
	 * �Ǝ��藦�̑S�̂̐����z���擾���܂��B �icalcTeiritsu��ɌĂԁj
	 * 
	 * @return �Ǝ��藦�̑S�̂̐����z
	 */
	public int getTeiritsuTotalSeikyugaku() {
		return teiritsuTotalSeikyugaku;
	}

	/**
	 * �Ǝ��藦�̎��Ɣ���z���擾���܂��B �icalcTeiritsu��ɌĂԁj
	 * 
	 * @return �Ǝ��藦�̎��Ɣ���z
	 */
	public int getTeiritsuJigyohiSeikyugaku() {
		return teiritsuJigyohiSeikyugaku;
	}

	/**
	 * �Ǝ��藦�̌�����z���v�Z���ĕԂ��܂��B
	 * 
	 * @param type
	 *            ����D�揇�^�C�v
	 * @param hokenUnit
	 *            �ی��ΏےP�ʐ� (701014)
	 * @param kohiUnit
	 *            ����ΏےP�ʐ�
	 * @param ratio
	 *            ����t���i��F95-100)
	 * @param reduction
	 *            ��ʗD�揇�̌�����z�Ƃ��Čv��ς̋��z
	 * @param usedRate
	 *            ��ʗD�揇�̌���t��
	 * @param tumiageUnit
	 *            ��ʗD�揇�̌���ΏےP�ʐ��Ƃ��Čv��ς̒P�ʐ�
	 * 
	 * @return �Ǝ��藦�̌�����z
	 */
	public int calcTeiritsuKohiSeikyugaku(KohiyusenType type, int hokenUnit,
			int kohiUnit, int ratio, int reduction, int usedRate,
			int tumiageUnit) {
		// ����t����100%�Ō���ΏےP�ʐ����ی��P�ʐ��̏ꍇ
		// �܂��́A����t����100%�Ō���ΏےP�ʐ���ςݏグ�����ʂ��T�[�r�X�P�ʐ��Ɠ������ꍇ
		if (((ratio == 100) && (hokenUnit == kohiUnit))
				|| ((ratio == 100) && (hokenUnit == (kohiUnit + tumiageUnit)))) {
			// �S�̂̐����z���玖�Ɣ���z������������
			return this.teiritsuTotalSeikyugaku
					- this.teiritsuJigyohiSeikyugaku - reduction;
		} else {
			if ((usedRate == -1) || (usedRate == 100)) {
				return calcTeiritsuKohiSeikyugakuByServiceRate(type, ratio);
			} else {
				return calcTeiritsuKohiSeikyugakuByUsedRate(type, ratio,
						usedRate);
			}
		}
	}

	// ����D�揇�^�C�v�ɑΉ��������ΏےP�ʐ��̃L�[���擾���܂��B
	private String getKohiUnitKeyFromType(KohiyusenType type) {
		String unitKey;
		if (KohiyusenType.KOHI1.equals(type)) {
			unitKey = KOHI1_SERVICE_UNIT;
		} else if (KohiyusenType.KOHI2.equals(type)) {
			unitKey = KOHI2_SERVICE_UNIT;
		} else if (KohiyusenType.KOHI3.equals(type)) {
			unitKey = KOHI3_SERVICE_UNIT;
		} else {
			throw new RuntimeException("KohiyusenType�̎w�肪����������܂���B:" + type);
		}
		return unitKey;
	}

	/**
	 * �Ǝ��藦�̌�����z���v�Z���ĕԂ��܂��B �T�[�r�X�R�[�h�̋��t�����g�p
	 * 
	 * @param type
	 *            ����D�揇�^�C�v
	 * @param ratio
	 *            ����t���i��F95-100)
	 * 
	 * @return �Ǝ��藦�̌�����z
	 */
	private int calcTeiritsuKohiSeikyugakuByServiceRate(KohiyusenType type,
			int ratio) {
		int result = 0;
		String unitKey = getKohiUnitKeyFromType(type);
		// �T�[�r�X�R�[�h�̋��t�����g�p����
		// �P���A���t�����ƂɌv�Z���āA���Z
		for (Double unitPrice : this.teiritsuMap.keySet()) {
			Map<Integer, List<Map<String, Object>>> kyufuritsuMap = this.teiritsuMap
					.get(unitPrice);
			for (Integer kyufuritsu : kyufuritsuMap.keySet()) {
				List<Map<String, Object>> details = kyufuritsuMap
						.get(kyufuritsu);
				
				int serviceUnit = 0;
				int kohiUnit = 0;
				for (Map<String, Object> detail : details) {
					serviceUnit += ACCastUtilities.toInt(detail.get(SERVICE_UNIT), 0);
					kohiUnit += ACCastUtilities.toInt(detail.get(unitKey), 0);
				}
				// ���ߕ��̒P�ʐ�������
				int limitOverUnit = getTeiritsuLimitOverUnit(unitPrice,
						kyufuritsu);
				serviceUnit = serviceUnit - limitOverUnit;
				if (serviceUnit < 0) {
					serviceUnit = 0;
				}
				// ����ΏےP�ʐ��̒����i���ߕ��̒P�ʐ��̂͂ݏo�����������j
				if (kohiUnit > serviceUnit) {
					kohiUnit = serviceUnit;
				}
				// ����ΏےP�ʐ��~�P�ʐ��P��(�����_�ȉ��؎̂�)
				int totalUnit = (int) Math
						.floor((double) (kohiUnit * getUnitPriceMultiplies100(unitPrice)) / 100d);
				// �~�i����t�� - ���t���j
				totalUnit = (int) Math
						.floor((totalUnit * (ratio - kyufuritsu)) / 100d);
				result += totalUnit;
			}
		}
		return result;
	}

	/**
	 * �Ǝ��藦�̌�����z���v�Z���ĕԂ��܂��B ��ʗD�揇�̌���t�����g�p
	 * 
	 * @param type
	 *            ����D�揇�^�C�v
	 * @param ratio
	 *            ����t���i��F95-100)
	 * @param usedRate
	 *            ��ʗD�揇�̌���t��
	 * 
	 * @return �Ǝ��藦�̌�����z
	 */
	private int calcTeiritsuKohiSeikyugakuByUsedRate(KohiyusenType type,
			int ratio, int usedRate) {
		int result = 0;
		String unitKey = getKohiUnitKeyFromType(type);
		// usedRate���g�p����
		// �P�����ƂɌv�Z���āA���Z
		for (Double unitPrice : this.teiritsuMap.keySet()) {
			Map<Integer, List<Map<String, Object>>> kyufuritsuMap = this.teiritsuMap
					.get(unitPrice);

			int kohiUnitTotal = 0;
			for (Integer kyufuritsu : kyufuritsuMap.keySet()) {
				List<Map<String, Object>> details = kyufuritsuMap
						.get(kyufuritsu);
				
				int serviceUnit = 0;
				int kohiUnit = 0;
				for (Map<String, Object> detail : details) {
					serviceUnit += ACCastUtilities.toInt(detail.get(SERVICE_UNIT), 0);
					kohiUnit += ACCastUtilities.toInt(detail.get(unitKey), 0);
				}
				// ���ߕ��̒P�ʐ�������
				int limitOverUnit = getTeiritsuLimitOverUnit(unitPrice,
						kyufuritsu);
				serviceUnit = serviceUnit - limitOverUnit;
				if (serviceUnit < 0) {
					serviceUnit = 0;
				}
				// ����ΏےP�ʐ��̒����i���ߕ��̒P�ʐ��̂͂ݏo�����������j
				if (kohiUnit > serviceUnit) {
					kohiUnit = serviceUnit;
				}
				kohiUnitTotal += kohiUnit;
			}
			// ����ΏےP�ʐ��~�P�ʐ��P��(�����_�ȉ��؎̂�)
			int totalUnit = (int) Math
					.floor((double) (kohiUnitTotal * getUnitPriceMultiplies100(unitPrice)) / 100d);
			// �~�i����t�� - ���t���j
			totalUnit = (int) Math
					.floor((totalUnit * (ratio - usedRate)) / 100d);
			result += totalUnit;
		}
		return result;
	}

	/**
	 * �Ǝ���z���v�Z���܂��B
	 * 
	 * @throws Exception
	 */
	private void calcTeigaku() throws Exception {
		this.teigakuTotalSeikyugaku = 0;
		this.teigakuRiyoshaFutangaku = 0;
		this.teigakuKohi1Seikyugaku = 0;
		this.teigakuKohi2Seikyugaku = 0;
		this.teigakuKohi3Seikyugaku = 0;

		for (Double unitPrice : this.teigakuMap.keySet()) {
			List<Map<String, Object>> details = teigakuMap.get(unitPrice);
			int totalServiceUnit = 0;
			for (Map<String, Object> detail : details) {
				
				int serviceUnit = ACCastUtilities.toInt(
						detail.get(SERVICE_UNIT), 0);
				

				int futan = ACCastUtilities.toInt(
						detail.get(TEIGAKU_FUTAN_TANKA), 0);
				int kohi1Count = ACCastUtilities.toInt(detail.get(KOHI1_COUNT),
						0);
				int kohi1Unit = ACCastUtilities.toInt(
						detail.get(KOHI1_SERVICE_UNIT), 0);

				int kohi2Count = ACCastUtilities.toInt(detail.get(KOHI2_COUNT),
						0);
				int kohi2Unit = ACCastUtilities.toInt(
						detail.get(KOHI2_SERVICE_UNIT), 0);

				int kohi3Count = ACCastUtilities.toInt(detail.get(KOHI3_COUNT),
						0);
				int kohi3Unit = ACCastUtilities.toInt(
						detail.get(KOHI3_SERVICE_UNIT), 0);

				// ������z�����߂�
				int tmpKohiSeikyugaku = 0;
				// ���t���̍l�����ł͂Ȃ��̂ŁA���p�͂��Ȃ��B
				// ����񐔁E�E����P�A����Q�A����R�Ə��Ɍ��āA�ŏ��ɐݒ肳��Ă���񐔂̌�����v�Z�ΏۂƂ���
				KohiyusenType type = KohiyusenType.NONE;
				int useKohiCount = 0;
				int useKohiUnit = 0;
				if (kohi1Count > 0) {
					useKohiCount = kohi1Count;
					useKohiUnit = kohi1Unit;
					type = KohiyusenType.KOHI1;
				} else if (kohi2Count > 0) {
					useKohiCount = kohi2Count;
					useKohiUnit = kohi2Unit;
					type = KohiyusenType.KOHI2;
				} else if (kohi3Count > 0) {
					useKohiCount = kohi3Count;
					useKohiUnit = kohi3Unit;
					type = KohiyusenType.KOHI3;
				}

				String itemCode = ACCastUtilities.toString(detail
						.get(SERVICE_ITEM_CODE));
				int limitOverUnit = getTeigakuLimitOverUnit(unitPrice, itemCode);
				// ���ߕ��̒P�ʐ�������ꍇ
				if (limitOverUnit > 0) {
					//�T�[�r�X�P�ʐ��������
					serviceUnit = serviceUnit - limitOverUnit;
					if (serviceUnit < 0) {
						serviceUnit = 0;
					}
					//����ΏےP�ʐ��̒����i���ߕ��̒P�ʐ��̂͂ݏo�����������j
					if (useKohiUnit > serviceUnit) {
						useKohiUnit = serviceUnit;
					}
					
					// �P�P�ʂ�����̗��p�ҕ��S�z�����߂�
					// �P�P�ʂ�����̗��p�ҕ��S�z�����p�ҕ��S�P�����z�^�P�񂠂���̒P�ʐ�
					int unit = ACCastUtilities.toInt(detail.get(UNIT), 0);
					if (unit == 0) {
						// ���z�T�[�r�X�̎��͋L�ڏȗ��̂��߂O�ɂȂ��Ă���̂ŁA�T�[�r�X�P�ʐ�������
						unit = ACCastUtilities.toInt(detail.get(SERVICE_UNIT), 0);
					}
					BigDecimal unitBig = new BigDecimal(unit);
					BigDecimal futanBig = new BigDecimal(futan);
					// ������z������ΏےP�ʐ��~�P�P�ʂ�����̗��p�ҕ��S�z
					tmpKohiSeikyugaku = new BigDecimal(useKohiUnit).multiply(futanBig)
							.divide(unitBig, 0, BigDecimal.ROUND_DOWN)
							.intValue();
					// ���p�ҕ��S�z��(�T�[�r�X�P�ʐ� - ����ΏےP�ʐ�)�~�P�P�ʂ�����̗��p�ҕ��S�z
					this.teigakuRiyoshaFutangaku += new BigDecimal(
							serviceUnit - useKohiUnit)
							.multiply(futanBig)
							.divide(unitBig, 0, BigDecimal.ROUND_DOWN)
							.intValue();
				} else {
					// ���ߕ��̒P�ʐ��������ꍇ
					// ������z�����p�ҕ��S�P�����z�~�����
					tmpKohiSeikyugaku = futan * useKohiCount;
					// ���p�ҕ��S�z�����p�ҕ��S�P�����z�~�i�� - ����񐔁j
					int serviceCount = ACCastUtilities.toInt(
							detail.get(SERVICE_COUNT), 0);
					this.teigakuRiyoshaFutangaku += futan
							* (serviceCount - useKohiCount);
				}

				if (KohiyusenType.KOHI1.equals(type)) {
					this.teigakuKohi1Seikyugaku += tmpKohiSeikyugaku;
				} else if (KohiyusenType.KOHI2.equals(type)) {
					this.teigakuKohi2Seikyugaku += tmpKohiSeikyugaku;
				} else if (KohiyusenType.KOHI3.equals(type)) {
					this.teigakuKohi3Seikyugaku += tmpKohiSeikyugaku;
				}
				
				// �T�[�r�X�P�ʐ��̐ςݏグ
				totalServiceUnit += serviceUnit;
			}
			// �ΏےP�ʐ��~�P�ʐ��P��(�����_�ȉ��؎̂�)
			int totalUnit = (int) Math
					.floor((double) (totalServiceUnit * getUnitPriceMultiplies100(unitPrice)) / 100d);
			this.teigakuTotalSeikyugaku += totalUnit;
		}
		// ���ےP�Ƃ̏ꍇ
		if (isSeihotandoku) {
			// ����p������P���S�ɂ���
			this.teigakuKohi1Seikyugaku = this.teigakuTotalSeikyugaku;
			this.teigakuKohi2Seikyugaku = 0;
			this.teigakuKohi3Seikyugaku = 0;
			this.teigakuRiyoshaFutangaku = 0;
		}
	}

	/**
	 * �Ǝ���z�̌���P�����z���擾���܂��B �icalcTeigaku��ɌĂԁj
	 * 
	 * @return �Ǝ���z�̌���P�����z
	 */
	public int getTeigakuKohi1Seikyugaku() {
		return teigakuKohi1Seikyugaku;
	}

	/**
	 * �Ǝ���z�̌���Q�����z���擾���܂��B �icalcTeigaku��ɌĂԁj
	 * 
	 * @return �Ǝ���z�̌���Q�����z
	 */
	public int getTeigakuKohi2Seikyugaku() {
		return teigakuKohi2Seikyugaku;
	}

	/**
	 * �Ǝ���z�̌���R�����z���擾���܂��B �icalcTeigaku��ɌĂԁj
	 * 
	 * @return �Ǝ���z�̌���R�����z
	 */
	public int getTeigakuKohi3Seikyugaku() {
		return teigakuKohi3Seikyugaku;
	}

	/**
	 * �Ǝ���z�̎��Ɣ���z���擾���܂��B �icalcTeigaku��ɌĂԁj
	 * 
	 * @param kohiSeikyugaku
	 *            ������z�i�P�`�R�̍��Z�j
	 * @param kohiFutan
	 *            ����ȕ��S�z�i�P�`�R�̍��Z�j
	 * @return �Ǝ���z�̎��Ɣ���z
	 */
	public int getTeigakuJigyohiSeikyugaku(int kohiSeikyugaku, int kohiFutan) {
		return this.teigakuTotalSeikyugaku - this.teigakuRiyoshaFutangaku
				- kohiSeikyugaku - kohiFutan;
	}
	
	/**
	 * �Ǝ���z�̗��p�ҕ��S�z���擾���܂��B �icalcTeigaku��ɌĂԁj
	 * 
	 * @return �Ǝ���z�̗��p�ҕ��S�z
	 */
	public int getTeigakuRiyoshaFutangaku() {
		return this.teigakuRiyoshaFutangaku;
	}
	
	/**
	 * �������Ƃ̒P�ʐ��P�����擾���܂��B
	 * �����̏ꍇ�́A�ő�̒P����Ԃ��܂��B
	 * 
	 * @return �������Ƃ̒P�ʐ��P��
	 */
	public double getUnitPrice() {
		if (!this.dokujiMap.isEmpty()) {
			return Collections.max(this.dokujiMap.keySet());
		} else if (!this.teiritsuMap.isEmpty()) {
			return Collections.max(this.teiritsuMap.keySet());
		} else if (!this.teigakuMap.isEmpty()) {
			return Collections.max(this.teigakuMap.keySet());
		}
		return 10.0d;
	}
	
	/**
	 * �敪�x�����x���P�ʐ���DB�i�[�p�̕��������擾���܂��B
	 * @return �敪�x�����x���P�ʐ���DB�i�[�p�̕������
	 */
	public String getSogoLimitOverInfo() {
		if (this.sogoLimitOverMap.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		//�}�b�v�̃L�[���l�̃J���}��؂�Ŋi�[����
		for (String key : this.sogoLimitOverMap.keySet()) {
			// �Ώۂ̃T�[�r�X��ނ̂��̂����i�[
			if (key.startsWith(this.skind)) {
				if (!first) {
					sb.append(",");
				}
				sb.append(key);
				sb.append("=");
				sb.append(this.sogoLimitOverMap.get(key));
				first = false;
			}
		}
		return sb.toString();
	}
	
	/**
	 * �敪�x�����x���P�ʐ��̍��v�l���擾���܂��B
	 * 
	 * @return �敪�x�����x���P�ʐ��̍��v�l
	 */
	public int getTotalLimitOverUnit() {
		int result = 0;
		if (this.sogoLimitOverMap.isEmpty()) {
			return result;
		}
		for (String key : this.sogoLimitOverMap.keySet()) {
			// �Ώۂ̃T�[�r�X��ނ̂��̂������v
			if (key.startsWith(this.skind)) {
				result += ACCastUtilities.toInt(this.sogoLimitOverMap.get(key), 0);
			}
		}
		return result;
	}
	
	// �Ǝ��̋敪�x�����P�ʐ����擾���܂�
	private int getDokujiLimitOverUnit(Double unitPrice) {
		String key = QP001Manager.getDokujiLimitOverUnitKey(skind, unitPrice);
		return ACCastUtilities.toInt(this.sogoLimitOverMap.get(key),
				0);
	}
	
	// �Ǝ��藦�̋敪�x�����P�ʐ����擾���܂�
	private int getTeiritsuLimitOverUnit(Double unitPrice, int kyufuritsu) {
		String key = QP001Manager.getTeiritsuLimitOverUnitKey(skind, unitPrice, kyufuritsu);
		return ACCastUtilities.toInt(this.sogoLimitOverMap.get(key),
				0);
	}

	// �Ǝ���z�̋敪�x�����P�ʐ����擾���܂�
	private int getTeigakuLimitOverUnit(Double unitPrice, String itemCode) {
		String key = QP001Manager.getTeigakuLimitOverUnitKey(skind, unitPrice, itemCode);
		return ACCastUtilities.toInt(this.sogoLimitOverMap.get(key),
				0);
	}

	// �P�ʐ��P���~100���擾���܂��B
	private int getUnitPriceMultiplies100(Double unitPrice) {
		BigDecimal temp = new BigDecimal(String.valueOf(unitPrice));
		temp = temp.multiply(new BigDecimal("100"));
		return temp.intValue();
	}

}
