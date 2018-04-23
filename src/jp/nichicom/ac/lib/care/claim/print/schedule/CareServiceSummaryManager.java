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
package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001009Event;

/**
 * �W�v���ו\���f�[�^�Ǘ��N���X
 * 
 * @author Yoichiro Kamei
 * 
 */
public class CareServiceSummaryManager {

	private CareServiceCodeCalcurater calcurater;
	private VRMap patientInsureInfoHeaviest;
	private VRMap masterService;

	// ���̃N���X�Œǉ������P�ʐ����i�[����KEY������
	// �i���ɐݒ�ς݂̃L�[�Əd�����Ȃ��悤�ɃN���X����t���Ă��܂��j
	private static String ADD_UNIT_NAME = CareServiceSummaryManager.class
			.getSimpleName() + "_SERVICE_UNIT";

	// ���̃N���X�ŃT�[�r�X�̒����z��ݒ肵���ۂɁAtrue���i�[����KEY������
	private static String REGULATION_RATE_MODIFIED = CareServiceSummaryManager.class
			.getSimpleName() + "_REGULATION_RATE_MODIFIED";
	
	// ���̃N���X�Ōv��P�ʐ���ݒ肵���ۂɁAtrue���i�[����KEY������
	private static String PLAN_UNIT_SETUPED = CareServiceSummaryManager.class
			.getSimpleName() + "_PLAN_UNIT_SETUPED";
	

	// ���x�z�Ǘ��ΏۊO�̕ʕ\�f�[�^
	private List<Map<String, Object>> gendogaiBeppyoList = new VRArrayList();
	// ���x�z�Ǘ��Ώۂ̕ʕ\�f�[�^
	private Map<String, Map<String, Object>> parsedData = new VRLinkedHashMap();

	// �������� ���x�z���P�ʐݒ�p�̃}�b�v
	private Map<String, VRList> sogoOverAdjustMap = new HashMap<String, VRList>();

	private VRList beppyoList = new VRArrayList(); // �ʕ\�f�[�^�̃��X�g
	private VRList limitList = new VRArrayList(); // ���x�z�Ǘ��Ώۂ̃��X�g
	private VRList gaibuList = new VRArrayList(); // �O�����p�^�̃��X�g

	private int limitUnit = 0; // ���x�z�Ǘ��Ώۂ̒P�ʐ�
	private int adjustUnit = 0; // �����P�ʐ�
	private int afterAdjustUnit = 0; // ������P�ʐ�

	private int gaibuUnit = 0; // �O�����p�^�̒P�ʐ�
	private int gaibuAdjustUnit = 0; // �O�����p�^�̒����P�ʐ�
	private int gaibuAfterAdjustUnit = 0; // �O�����p�^�̒�����P�ʐ�
	
	private int outLimitUnit = 0; // ���t�Ǘ��ΏۊO�̒P�ʐ�
	private int patientCost = 0; // ���p�ҕ��S�z�T�Z

	/**
	 * �R���X�g���N�^�B
	 * 
	 * @param calcurater
	 *            �����A�������ς݂�CareServiceCodeCalcurater
	 * @param patientInsureInfoHeaviest
	 *            �ł��d���v���x�������i�[�p���R�[�h
	 * @param masterService
	 *            �T�[�r�X�}�X�^
	 */
	public CareServiceSummaryManager(CareServiceCodeCalcurater calcurater,
			VRMap patientInsureInfoHeaviest, VRMap masterService)
			throws Exception {
		this.calcurater = calcurater;
		this.patientInsureInfoHeaviest = patientInsureInfoHeaviest;
		this.masterService = masterService;
	}

	
	/**
	 * ���̃N���X�̏������������s���܂��B
	 * �W�v���ׂ̍s�f�[�^���쐬���܂��B
	 * 
	 * @param calcurater
	 * @param services
	 * @throws Exception
	 */
	public void initialize(CareServiceCodeCalcurater calcurater,
			VRList services) throws Exception {

		this.outLimitUnit = 0;
		this.patientCost = 0;
		this.beppyoList.clear();
		
		// �ʕ\�̏W�v���W�b�N��ʂ��āA�ʕ\�ɋL�ڂ���鋋�t�Ǘ��ΏۊO�P�ʐ��Ɨ��p�ҕ��S�z���擾����B
		CareServiceSchedulePrintManager mng = new CareServiceSchedulePrintManager();
		mng.setUltimateDebugFlag(true);
		mng.initialize(calcurater);
		mng.parse(services);
		mng.setBuildDivedProvider(false);

		int lastRow = mng.getUserSubTableRowCount();
		CareServicePrintParameter buildParam = new CareServicePrintParameter();
		buildParam.setPrintParameter(new VRHashMap());
		List list = new ArrayList();
		mng.buildUserSubTable(buildParam, list);
		mng.setUltimateDebugFlag(false);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			Iterator provIt = ((List) it.next()).iterator();
			while (provIt.hasNext()) {
				List ins = (List) provIt.next();
				if (!ins.isEmpty()) {
					Map page = (Map) ins.get(0);
					patientCost += ACCastUtilities.toInt(
							page.get("main.total.x18"), 0)
							+ ACCastUtilities.toInt(page.get("main.total.x19"),
									0);
					Iterator insIt = ins.iterator();
					while (insIt.hasNext()) {
						page = (Map) insIt.next();
						for (int i = 1; i < lastRow; i++) {
							VRMap row = new VRHashMap();

							row.put("PROVIDER_NAME",
									ACCastUtilities.toString(
											page.get("main.y" + i + ".x1"), ""));
							row.put("PROVIDER_ID",
									ACCastUtilities.toString(
											page.get("main.y" + i + ".x2"), ""));

							String serviceName = ACCastUtilities.toString(
									page.get("main.y" + i + ".x3"), "");
							row.put("SERVICE_NAME", serviceName);

							String serviceCode = ACCastUtilities.toString(
									page.get("main.y" + i + ".x4"), "");

							row.put("SERVICE_CODE", serviceCode);

							row.put("UNIT",
									ACCastUtilities.toString(
											page.get("main.y" + i + ".x5"), ""));
							row.put("REDUCE_RATE",
									ACCastUtilities.toString(
											page.get("main.y" + i + ".x6"), ""));
							row.put("REDUCED_UNIT",
									ACCastUtilities.toString(
											page.get("main.y" + i + ".x7"), ""));
							row.put("SERVICE_COUNT",
									ACCastUtilities.toString(
											page.get("main.y" + i + ".x8"), ""));
							String serviceUnit = ACCastUtilities.toString(
									page.get("main.y" + i + ".x9"), "");
							row.put("SERVICE_UNIT", serviceUnit);

							String unit = ACCastUtilities.toString(page
									.get("main.y" + i + ".x12"));
							row.put("OVER_UNIT", unit);

							row.put("IN_UNIT", ACCastUtilities.toString(
									page.get("main.y" + i + ".x13"), ""));

							row.put("UNIT_PRICE", ACCastUtilities.toString(
									page.get("main.y" + i + ".x14"), ""));
							row.put("TOTAL_COST", ACCastUtilities.toString(
									page.get("main.y" + i + ".x15"), ""));
							row.put("PAYMENT_RATE", ACCastUtilities.toString(
									page.get("main.y" + i + ".x16"), ""));
							row.put("HOKEN_COST", ACCastUtilities.toString(
									page.get("main.y" + i + ".x17"), ""));
							row.put("TEIGAKU_FUTAN_TANKA", ACCastUtilities.toString(
									page.get("main.y" + i + ".x20"), ""));
							row.put("FUTAN_HOKEN", ACCastUtilities.toString(
									page.get("main.y" + i + ".x18"), ""));
							row.put("FUTAN_ZENGAKU", ACCastUtilities.toString(
									page.get("main.y" + i + ".x19"), ""));

							row.put("SERVICE_KIND", ACCastUtilities.toString(
									page.get("main.y" + i + ".skind"), ""));
							
							row.put("SOGO_KYUFURITSU", ACCastUtilities.toString(
									page.get("main.y" + i + ".sogokyufuritsu"), ""));

							row.put("LIMIT_AMOUNT_OBJECT", ACCastUtilities.toString(
									page.get("main.y" + i + ".limitAmountObject"), ""));
							
							if (!"".equals(serviceName)) {
								this.beppyoList.add(row);
							}
							
							if (isGendogaiBeppyoRow(row)) {
								if (!"".equals(serviceUnit) 
										&& serviceUnit.charAt(0) == '(') {
									outLimitUnit += ACCastUtilities.toInt(
											serviceUnit.substring(1,
													serviceUnit.length() - 1),
											0);
								}
							}

						}
					}
				}
			}
		}

		//�擾�����ʕ\�f�[�^�̉��
		parseBeppyoData(this.beppyoList);
		//�T�[�r�X�̉��
		parseServices(services);
	}
	
	/**
	 * �ʕ\�f�[�^����͂��āAMap�Ɋi�[����B
	 * 
	 * @param beppyoData
	 *            �ʕ\�f�[�^���i�[���ꂽ���X�g
	 */
	private void parseBeppyoData(List<Map<String, Object>> beppyoData)
			throws Exception {
		for (Map<String, Object> row : beppyoData) {
			if (isGendogaiBeppyoRow(row)) {
				gendogaiBeppyoList.add(row);
				continue;
			}
			if (isOver30DaysBeppyoRow(row)) {
				continue;
			}
			if (isTaishoRow(row)) {
				// ���x�z�Ǘ��Ώۂ̏ꍇ
				// �W�v�L�[���쐬����
				String key = createSummaryKeyFromBeppyoData(row);
				Map<String, Object> parsedRow;
				if (parsedData.containsKey(key)) {
					parsedRow = parsedData.get(key);
				} else {
					parsedRow = new VRHashMap();
					parsedRow.put("KEY", key);
					String providerId = ACCastUtilities.toString(
							row.get("PROVIDER_ID"), "");
					String providerName = ACCastUtilities.toString(
							row.get("PROVIDER_NAME"), "");
					parsedRow.put("PROVIDER_ID", providerId);
					parsedRow.put("PROVIDER_NAME", providerId + " " + providerName);

					String sysKind = ACCastUtilities.toString(
							row.get("SERVICE_KIND"), "");
					parsedRow.put("SERVICE_CODE_KIND",
							getServiceCodeKindFromSystemCode(sysKind));
					parsedRow.put("SERVICE_KIND_NAME",
							createServiceKindNameFromBeppyoData(row));
					parsedRow.put("SOGO_KYUFURITSU", ACCastUtilities.toString(
							row.get("SOGO_KYUFURITSU"), "xxx"));
					parsedRow.put("TEIGAKU_UNIT", ACCastUtilities.toString(
							row.get("UNIT"), "xxx"));
					parsedRow.put("TEIGAKU_FUTAN_TANKA", ACCastUtilities.toString(
							row.get("TEIGAKU_FUTAN_TANKA"), "xxx"));
					parsedRow.put("GAIBU_UNIT", new Integer(0)); // �O�����p�^�̒P�ʐ�
					parsedRow.put("BEPPYO_ROWS", new VRArrayList()); // ��͂����ʕ\���i�[���郊�X�g
					parsedRow.put("WARIFURI_SERVICES", new VRArrayList()); // ���U��Ώۂ̃T�[�r�X���i�[���郊�X�g
					parsedData.put(key, parsedRow);
				}
				// ���x�z�Ǘ��Ώۂ̒P�ʐ���ςݏグ
				int addUnit = ACCastUtilities.toInt(row.get("SERVICE_UNIT"), 0);
				int unit = ACCastUtilities.toInt(parsedRow.get("UNIT"), 0);
				parsedRow.put("UNIT", unit + addUnit);

				// �Ώۂ̕ʕ\�f�[�^���i�[���Ă���
				((List) parsedRow.get("BEPPYO_ROWS")).add(row);
			}
		}
	}

	// �V�X�e���T�[�r�X��ރR�[�h(5��)����T�[�r�X��ރR�[�h���擾����
	private String getServiceCodeKindFromSystemCode(
			String systemServiceKindDetail) throws Exception {
		String kind = "";
		int sysCode = ACCastUtilities.toInt(systemServiceKindDetail, 0);
		VRMap row = (VRMap) masterService.get(sysCode);
		if (row != null) {
			kind = ACCastUtilities.toString(row.get("SERVICE_CODE_KIND"));
		}
		return kind;
	}

	// �V�X�e���T�[�r�X��ރR�[�h(5��)����T�[�r�X��ޖ��̂��擾����
	private String getServiceKindNameFromSystemCode(
			String systemServiceKindDetail) throws Exception {
		String kind = "";
		int sysCode = ACCastUtilities.toInt(systemServiceKindDetail, 0);
		VRMap row = (VRMap) masterService.get(sysCode);
		if (row != null) {
			kind = ACCastUtilities.toString(row.get("SERVICE_KIND_NAME"));
		}
		return kind;
	}

	// �ʕ\�f�[�^����W�v���邽�߂̃L�[���쐬����
	private String createSummaryKeyFromBeppyoData(Map<String, Object> row)
			throws Exception {
		StringBuilder sb = new StringBuilder();
		// ���Ə�
		sb.append(ACCastUtilities.toString(row.get("PROVIDER_ID"), ""));
		sb.append("-");

		// �T�[�r�X���
		String sysKind = ACCastUtilities.toString(row.get("SERVICE_KIND"), "");
		String kind = getServiceCodeKindFromSystemCode(sysKind);
		sb.append(kind);
		sb.append("-");

		// �������Ƃ̓Ǝ��藦�̏ꍇ
		if (QkanSjServiceCodeManager.teiritsuCodes.contains(sysKind)) {
			// ���t��
			sb.append(ACCastUtilities.toString(row.get("SOGO_KYUFURITSU"),
					"xxx"));
			sb.append("-");
		}

		// �������Ƃ̓Ǝ���z�̏ꍇ
		if (QkanSjServiceCodeManager.teigakuCodes.contains(sysKind)) {
			// �T�[�r�X�R�[�h
			sb.append(ACCastUtilities.toString(row.get("SERVICE_CODE"),
					"xxxxxx"));
			sb.append("-");
		}

		return sb.toString();
	}

	// �ʕ\�f�[�^����T�[�r�X��̕\�����e���쐬����
	private String createServiceKindNameFromBeppyoData(Map<String, Object> row)
			throws Exception {
		StringBuilder sb = new StringBuilder();
		// �T�[�r�X��ޖ���
		String sysKind = ACCastUtilities.toString(row.get("SERVICE_KIND"), "");
		String kind = getServiceCodeKindFromSystemCode(sysKind);
		sb.append(kind);
		sb.append(":");
		sb.append(getServiceKindNameFromSystemCode(sysKind));

		// �������Ƃ̓Ǝ��藦�̏ꍇ
		if (QkanSjServiceCodeManager.teiritsuCodes.contains(sysKind)) {
			sb.append(" ");
			// ���t��
			sb.append(ACCastUtilities.toString(row.get("SOGO_KYUFURITSU"),
					"xxx"));
			sb.append("%");
		}

		// �������Ƃ̓Ǝ���z�̏ꍇ
		if (QkanSjServiceCodeManager.teigakuCodes.contains(sysKind)) {
			sb.append(" ");
			// �T�[�r�X�R�[�h
			sb.append(ACCastUtilities.toString(row.get("SERVICE_CODE"), ""));
			sb.append(" ");
			sb.append(ACCastUtilities.toString(row.get("SERVICE_NAME"), ""));
		}

		return sb.toString();
	}

	// �ʕ\�f�[�^�����x�z�Ǘ��ΏۊO���ǂ�����Ԃ�
	private boolean isGendogaiBeppyoRow(Map<String, Object> row) {
		int limitAmountObject = ACCastUtilities.toInt(row.get("LIMIT_AMOUNT_OBJECT"), 0);
		if (CareServiceCommon.OUT_LIMIT_AMOUNT_SERVICE.equals(limitAmountObject)) {
			return true;
		}
		return false;
	}
	
	// �ʕ\�f�[�^����͑Ώۂ��ǂ�����Ԃ�
	private boolean isTaishoRow(Map<String, Object> row) {
		// �R�[�h�������ꍇ�́A�W�v�s�Ȃ̂őΏۊO
		String code = ACCastUtilities.toString(row.get("SERVICE_CODE"), "");
		if ("".equals(code)) {
			return false;
		}
		// ���t�Ǘ����x�z�Ώۂ��O�����p�^�̋��t�Ǘ����x�z�Ώ�
		int limitAmountObject = ACCastUtilities.toInt(row.get("LIMIT_AMOUNT_OBJECT"), 0);
		if (CareServiceCommon.IN_LIMIT_AMOUNT_SERVICE.equals(limitAmountObject)
				|| CareServiceCommon.OUTER_SERVICE_LIMIT_AMOUNT.equals(limitAmountObject)) {
			return true;
		}
		return false;
	}
	
	
	// �ʕ\�f�[�^��30�����̍s���ǂ�����Ԃ�
	private boolean isOver30DaysBeppyoRow(Map<String, Object> row) {
		boolean isOver30Days = ACCastUtilities.toBoolean(row.get("isOver30Days"), false);
		if (isOver30Days) {
			return true;
		}
		return false;
	}

	/**
	 * �T�[�r�X����͂��āAMap�Ɋi�[����B
	 * 
	 * @param services
	 *            �T�[�r�X���i�[���ꂽ���X�g
	 * @throws Exception
	 */
	private void parseServices(List<Map<String, Object>> services)
			throws Exception {
		Map[] totalGroupingCache = new Map[] { new HashMap(), new HashMap() };
		Map[] totalGroupingCacheGaibu = new Map[] { new HashMap(),
				new HashMap() };
		// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 add - begin �����^���Z�Ή�
		KyouseiUnitCalcurater kyouseiCalc = new KyouseiUnitCalcurater();
		// ���n��Ń\�[�g����
		Collections.sort(services, new ServiceDateTimeLineComparator(ADD_UNIT_NAME));
		// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 add - end
		
		for (Map<String, Object> service : services) {
			// ���̃T�[�r�X�̒P�ʐ������߂�
			// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 mod - begin �����^���Z�Ή�
//			int unit = calcurater
//					.getReductedUnit(
//							(VRMap) service,
//							false,
//							CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE,
//							totalGroupingCache);
			int unit = calcurater
					.getReductedUnit(
							(VRMap) service,
							false,
							CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE,
							totalGroupingCache,
							kyouseiCalc);
			// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 mod - end
			// �T�[�r�X�ɒǉ�����
			service.put(ADD_UNIT_NAME, unit);
			if (unit == 0) {
				// ���x�z�Ǘ��Ώۂ̒P�ʐ����Ȃ���΁A�X�L�b�v
				continue;
			}
			// ���x�z�Ǘ��Ώۂ̏ꍇ
			// �W�v�L�[���쐬����
			String key = createSummaryKeyFromServiceData(service);
			Map<String, Object> parsedRow;
			if (parsedData.containsKey(key)) {
				parsedRow = parsedData.get(key);
			} else {
				System.out.println("���蓖�Đ�̕ʕ\�f�[�^������܂���: " + key);
				continue;
			}
			// �����z��ςݏグ
			int regRate = ACCastUtilities.toInt(service.get("REGULATION_RATE"),
					0);
			int adjust = ACCastUtilities.toInt(parsedRow.get("ADJUST"), 0);
			parsedRow.put("ADJUST", regRate + adjust);

			// �O�����p�^�̒P�ʐ������邩�m�F
			// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 mod - begin �����^���Z�Ή�
//			int gaibuUnit = calcurater
//					.getReductedUnit(
//							(VRMap) service,
//							false,
//							CareServiceCodeCalcurater.CALC_MODE_OUTER_SERVICE_LIMIT_AMOUNT,
//							totalGroupingCacheGaibu);
			int gaibuUnit = calcurater
					.getReductedUnit(
							(VRMap) service,
							false,
							CareServiceCodeCalcurater.CALC_MODE_OUTER_SERVICE_LIMIT_AMOUNT,
							totalGroupingCacheGaibu, null);
			// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 mod - end
			if (gaibuUnit != 0) {
				int nowGaibuUnit = ACCastUtilities.toInt(
						parsedRow.get("GAIBU_UNIT"), 0);
				parsedRow.put("GAIBU_UNIT", nowGaibuUnit + gaibuUnit);
			}

			// �Ώۂ̃T�[�r�X���i�[���Ă���
			((List) parsedRow.get("WARIFURI_SERVICES")).add(service);
		}
		// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 mod - begin �����^���Z�Ή�
		// �����^���Z�̌��Z�P�ʐ���ADD_UNIT_NAME�ɕێ����Ă���P�ʐ��֔��f����
		if (kyouseiCalc.hasService()) {
			kyouseiCalc.calcKyouseiUnit(ADD_UNIT_NAME);
			kyouseiCalc.removeServiceKey();
		}
		// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/14 mod - end
		
		// �P�ʐ��̌v�Z
		calcTotalUnit();
	}

	/**
	 * �P�ʐ��̌v�Z���s���܂��B �iparseBeppyoData�AparseServices�̎��s��ɌĂԁj
	 */
	private void calcTotalUnit() {
		// ���ݒl���N���A
		this.limitList.clear();
		this.gaibuList.clear();
		this.limitUnit = 0;
		this.adjustUnit = 0;
		this.afterAdjustUnit = 0;
		this.gaibuUnit = 0;
		this.gaibuAdjustUnit = 0;
		this.gaibuAfterAdjustUnit = 0;

		// ������P�ʐ����Z�o���āA���t�Ǘ��ΏہA�O�����p�^�̃��X�g�ɕ�����
		for (Map<String, Object> parsedRow : parsedData.values()) {
			int unit = ACCastUtilities.toInt(parsedRow.get("UNIT"), 0);
			int adjust = ACCastUtilities.toInt(parsedRow.get("ADJUST"), 0);
			int result = unit - adjust;
			parsedRow.put("UNIT", unit);
			parsedRow.put("ADJUST", adjust);
			parsedRow.put("RESULT", result);
			int gaibuUnit = ACCastUtilities.toInt(parsedRow.get("GAIBU_UNIT"),
					0);
			if (gaibuUnit != 0) {
				this.gaibuUnit += gaibuUnit;
				this.gaibuAdjustUnit += adjust;
				this.gaibuAfterAdjustUnit += result;
				this.gaibuList.add(parsedRow);
			} else {
				this.limitUnit += unit;
				this.adjustUnit += adjust;
				this.afterAdjustUnit += result;
				this.limitList.add(parsedRow);
			}
		}
	}

	// �T�[�r�X�f�[�^����W�v���邽�߂̃L�[���쐬����
	private String createSummaryKeyFromServiceData(Map<String, Object> service)
			throws Exception {
		StringBuilder sb = new StringBuilder();
		// ���Ə�
		sb.append(ACCastUtilities.toString(service.get("PROVIDER_ID"), ""));
		sb.append("-");

		// �T�[�r�X���
		String sysKind = ACCastUtilities.toString(
				service.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
		String sKind = getServiceCodeKindFromSystemCode(sysKind);
		sb.append(sKind);
		sb.append("-");

		// �������Ƃ̓Ǝ��藦�̏ꍇ
		if (QkanSjServiceCodeManager.teiritsuCodes.contains(sysKind)) {
			String codeKey = ACCastUtilities.toString(service.get("501"), "");
			VRMap ret = QkanSjServiceCodeManager.getSjServiceCodeByKey(
					calcurater.getDBManager(), codeKey,
					calcurater.getTargetDate());
			// ���t��
			sb.append(ACCastUtilities.toString(ret.get("KYUFURITSU"), "xxx"));
			sb.append("-");
		}

		// �������Ƃ̓Ǝ���z�̏ꍇ
		if (QkanSjServiceCodeManager.teigakuCodes.contains(sysKind)) {
			String codeKey = ACCastUtilities.toString(service.get("501"), "");
			VRMap ret = QkanSjServiceCodeManager.getSjServiceCodeByKey(
					calcurater.getDBManager(), codeKey,
					calcurater.getTargetDate());

			// �T�[�r�X�R�[�h
			sb.append(ACCastUtilities.toString(ret.get("SERVICE_CODE_KIND"),
					"xx"));
			sb.append(ACCastUtilities.toString(ret.get("SERVICE_CODE_ITEM"),
					"xxxx"));
			sb.append("-");
		}

		return sb.toString();
	}

	/**
	 * �v��P�ʐ�����͂��āA���׍s�ɐݒ肷��B
	 * 
	 * @param planUnits
	 *            �v��P�ʐ����i�[���ꂽ�}�b�v
	 * @throws Exception
	 */
	public void parsePlanUnits(VRMap planUnits) throws Exception {
		if (planUnits.isEmpty()) {
			// �v��P�ʐ����ݒ肳��Ă��Ȃ���΁A�������Ȃ�
			return;
		}
		for (Map<String, Object> parsedRow : parsedData.values()) {
			String providerId = ACCastUtilities.toString(
					parsedRow.get("PROVIDER_ID"), "");
			String kind = ACCastUtilities.toString(
					parsedRow.get("SERVICE_CODE_KIND"), "");
			String path = CareServiceCommon.getPlanUnitBindPath(kind);

			if (planUnits.containsKey(providerId)) {
				VRMap unitMap = (VRMap) planUnits.get(providerId);
				if (unitMap.containsKey(path)) {
					String planUnit = ACCastUtilities.toString(
							unitMap.get(path), "");

					// �v��P�ʐ��̐ݒ肪����ꍇ
					if (!ACTextUtilities.isNullText(planUnit)) {
						parsedRow.put("PLAN_UNIT", planUnit);
						parsedRow.put("PLAN_UNIT_BIND_PATH", path);
					}

				}
			}
		}
	}
	
	
	/**
	 * �����z�����ƂɌv��P�ʐ���ݒ肵�܂��B
	 * �i�\��Ǎ����ɌĂ΂�܂��B�j
	 * 
	 * @param planUnits �ݒ�Ώۂ̌v��P�ʐ�
	 * @throws Exception
	 */
	public void setupPlanUnitsFromAdjusts(VRMap planUnits)  throws Exception {
		// �������Ƃ̓Ǝ��藦�E�Ǝ���z�̃T�[�r�X��ނ��Ƃ̃��X�g���쐬
		createSogoOverAdjustMap();
		
		for (Map<String, Object> parsedRow : parsedData.values()) {
			if (Boolean.TRUE.equals(parsedRow.get(PLAN_UNIT_SETUPED))) {
				continue; //�ݒ�ς݂̍s�̓X�L�b�v
			}
			String providerId = ACCastUtilities.toString(
					parsedRow.get("PROVIDER_ID"), "");
			String kind = ACCastUtilities.toString(
					parsedRow.get("SERVICE_CODE_KIND"), "");
			String path = CareServiceCommon.getPlanUnitBindPath(kind);
			
			// �������Ƃ̓Ǝ��藦�E�Ǝ���z�̏ꍇ
			// �ΏۂƂȂ�T�[�r�X�ɒ����z������U��
			if (parsedRow.containsKey("SOGO_OVER_ADJUST_KEY")) {

				// �L�[���擾
				String adjustKey = ACCastUtilities.toString(
						parsedRow.get("SOGO_OVER_ADJUST_KEY"), "");

				// �P�ʐ��A�����z�̍��v�����߂�
				int totalUnit = 0;
				int totalAdjust = 0;
				VRList list = sogoOverAdjustMap.get(adjustKey);
				for (int index = 0; index < list.size(); index++) {
					Map row = (Map) list.get(index);
					int unit = ACCastUtilities.toInt(row.get("UNIT"), 0);
					int adjust = ACCastUtilities.toInt(row.get("ADJUST"), 0);
					totalUnit += unit;
					totalAdjust += adjust;
					// ���̍s�͐ݒ�ςƂ���
					row.put(PLAN_UNIT_SETUPED, true);
				}
				// �����z���ݒ肳��Ă����
				if (totalAdjust > 0) {
					// �v��P�ʐ���o�^
					int planUnit = totalUnit - totalAdjust;
					setPlanUnit(planUnits, providerId, path, planUnit);
				}
				
			} else {
				// �������Ƃ̓Ǝ��藦�E�Ǝ���z�łȂ����
				int unit = ACCastUtilities.toInt(
						parsedRow.get("UNIT"), 0);
				int adjust = ACCastUtilities.toInt(
						parsedRow.get("ADJUST"), 0);
				// �����z���ݒ肳��Ă����
				if (adjust > 0) {
					int planUnit = unit - adjust;
					// �v��P�ʐ���o�^
					setPlanUnit(planUnits, providerId, path, planUnit);
				}
				// ���̍s�͐ݒ�ςƂ���
				parsedRow.put(PLAN_UNIT_SETUPED, true);
			}
		}
	}
	
	//�p�����[�^�Ŏw�肵�����Ə��A�T�[�r�X��ނɌv��P�ʐ���ݒ�
	private void setPlanUnit(VRMap planUnits, String providerId, String path, int planUnit) {
		if (planUnit > 0) {
			if (planUnits.containsKey(providerId)) {
				// ���Ə��̃f�[�^������΁A���̒��ɒǉ�
				VRMap providerPlanUnits = (VRMap) planUnits.get(providerId);
				providerPlanUnits.put(path, planUnit);
			} else {
				// ���Ə��̃f�[�^������������쐬
				VRMap units = new VRHashMap();
				units.put(path, planUnit);
				units.put("PROVIDER_ID", providerId);
				planUnits.put(providerId, units);
			}
		}
	}

	/**
	 * ���t�Ǘ��Ώۂ̃��X�g��Ԃ��܂��B
	 * 
	 * @return ���t�Ǘ��Ώۂ̃��X�g
	 */
	public VRList getLimitList() {
		return this.limitList;
	}

	/**
	 * �O�����p�^�̃��X�g��Ԃ��܂��B
	 * 
	 * @return �O�����p�^�̃��X�g
	 */
	public VRList getGaibuList() {
		return this.gaibuList;
	}
	
	/**
	 * �ʕ\�f�[�^�̃��X�g��Ԃ��܂��B
	 * 
	 * @return �ʕ\�f�[�^�̃��X�g
	 */
	public VRList getBeppyoList() {
		return this.beppyoList;
	}

	/**
	 * ���͂��ꂽ�����z���T�[�r�X�Ɋ���U��܂��B
	 * 
	 * @param row
	 *            �����z�̕ύX�Ώۍs�f�[�^
	 */
	public void applyAdjustUnit(Map row) {

		String key = ACCastUtilities.toString(row.get("KEY"), "");
		Map<String, Object> parsedRow = parsedData.get(key);
		// ���U��Ώۂ̒����z
		int zan = ACCastUtilities.toInt(row.get("ADJUST"), 0);
		// ���U��Ώۂ̃T�[�r�X
		List<Map<String, Object>> services = (List<Map<String, Object>>) parsedRow
				.get("WARIFURI_SERVICES");

		// ���t�̍Ō�̂��̂��犄�蓖�Ă邽�߂ɋt���ɂ���
		List<Map<String, Object>> list = new ArrayList(services);
		Collections.reverse(list);
		for (Map<String, Object> service : list) {
			if (CareServiceCommon.is30DayOver((VRMap) service)) {
				// 30�����̃T�[�r�X�͑S�z���ȕ��S�Ȃ̂ŁA�X�L�b�v
				continue;
			}
			// �T�[�r�X�Ɋ��U��\�ȒP�ʐ�
			int kano = ACCastUtilities.toInt(service.get(ADD_UNIT_NAME), 0);
			int wariate = 0;
			if (zan <= kano) {
				// ���蓖�Ďc���T�[�r�X�Ɋ��U��\�ȒP�ʐ��������������A�������ꍇ�A�c���S�����蓖��
				wariate = zan;
			} else {
				// ���蓖�Ďc���T�[�r�X�Ɋ��U��\�ȒP�ʐ������傫���ꍇ�A���蓖�ĉ\�ȕ������蓖��
				wariate = kano;
			}
			service.put("REGULATION_RATE", wariate);
			service.put(REGULATION_RATE_MODIFIED, true); // �C���������Ƃ�ݒ�

			// ���蓖�Ă������c�������
			zan = zan - wariate;
		}
	}

	/**
	 * �����z�̐ݒ�l���擾���܂��B
	 * 
	 * @return �X�V�Ώۂ�ID�ƒ����z���i�[���ꂽ�}�b�v
	 */
	public VRMap getAdjustResults() {
		VRMap results = new VRHashMap();
		for (Map<String, Object> parsedRow : parsedData.values()) {
			List<Map<String, Object>> services = (List<Map<String, Object>>) parsedRow
					.get("WARIFURI_SERVICES");
			for (Map<String, Object> service : services) {
				if (Boolean.TRUE.equals(service.get(REGULATION_RATE_MODIFIED))) {
					String id = ACCastUtilities.toString(
							service.get(QS001009Event.QS001009_UPDATE_KEY), "");
					int adjust = ACCastUtilities.toInt(
							service.get("REGULATION_RATE"), 0);
					results.put(id, adjust);
				}
			}
		}
		return results;
	}

	/**
	 * �P�ʐ��̌��ʏ���Ԃ��܂��B
	 * 
	 * @return �P�ʐ��̌��ʏ��
	 */
	public VRMap getUnitInfoResults() {
		VRMap results = new VRHashMap();
		// ���x�z�Ǘ��Ώ�
		int kubunLimit = ACCastUtilities.toInt(
				this.patientInsureInfoHeaviest.get("LIMIT_RATE"), 0);
		results.put("LIMIT_RATE", kubunLimit); // ���x�z
		results.put("LIMIT_AMOUNT", this.limitUnit); // ���t�Ǘ��Ώۂ̒P�ʐ�
		results.put("AFTER_ADJUSTMENT", this.afterAdjustUnit); // ������P�ʐ�
		results.put("ADJUSTMENT", this.adjustUnit); // �����P�ʐ�
		int limitOver = this.afterAdjustUnit - kubunLimit;
		if (limitOver < 0) {
			limitOver = 0;
		}
		results.put("LIMIT_OVER", limitOver); // ���ߒP�ʐ�

		// �O�����p�^
		int gaibuLimit = ACCastUtilities.toInt(
				this.patientInsureInfoHeaviest.get("EXTERNAL_USE_LIMIT"), 0);
		results.put("EXTERNAL_USE_LIMIT", gaibuLimit); // ���x�z
		results.put("OUTER_LIMIT_AMOUNT", this.gaibuUnit); // ���t�Ǘ��Ώۂ̒P�ʐ�
		results.put("OUTER_AFTER_ADJUSTMENT", this.gaibuAfterAdjustUnit); // ������P�ʐ�
		results.put("OUTER_ADJUSTMENT", this.gaibuAdjustUnit); // �����P�ʐ�
		int outerLimitOver = this.gaibuAfterAdjustUnit - gaibuLimit;
		if (outerLimitOver < 0) {
			outerLimitOver = 0;
		}
		results.put("OUTER_LIMIT_OVER", outerLimitOver); // ���ߒP�ʐ�
		
		
		// ���t�Ǘ��ΏۊO
		results.put("OUT_LIMIT_AMOUNT", this.outLimitUnit);
		// ���S�z�T�Z
		results.put("FUTAN_GAKU", this.patientCost);

		return results;
	}

	/**
	 * �w�肵���L�[�̉�͍ς݂̍s�f�[�^��Ԃ��܂��B
	 * 
	 * @return �w�肵���L�[�̉�͍ς݂̍s�f�[�^
	 */
	public VRMap getParsedRowByKey(String key) {
		return (VRMap) this.parsedData.get(key);
	}

	/**
	 * �������� ���x�z���P�ʐݒ�p�̃}�b�v���쐬���܂��B
	 * 
	 */
	public void createSogoOverAdjustMap() {
		sogoOverAdjustMap.clear();
		for (Map<String, Object> parsedRow : parsedData.values()) {
			String providerId = ACCastUtilities.toString(
					parsedRow.get("PROVIDER_ID"), "");
			String kind = ACCastUtilities.toString(
					parsedRow.get("SERVICE_CODE_KIND"), "");
			// �������Ƃ̓Ǝ���z�E�Ǝ��藦�̃T�[�r�X��ނłȂ���΃X�L�b�v
			if (!QkanSjServiceCodeManager.teiritsuTeigakuKinds.contains(kind)) {
				continue;
			}
			// ���Ə��A�T�[�r�X��ޖ��Ƀ��X�g�Ƃ��ĕێ�����
			String key = providerId + "-" + kind;
			parsedRow.put("SOGO_OVER_ADJUST_KEY", key);
			VRList list;
			if (!sogoOverAdjustMap.containsKey(key)) {
				list = new VRArrayList();
				sogoOverAdjustMap.put(key, list);
			} else {
				list = sogoOverAdjustMap.get(key);
			}
			list.add(parsedRow);
		}
	}

	/**
	 * �������� ���x�z���P�ʐݒ�ҏW�p�̃��X�g���擾���܂��B
	 * 
	 * @return �������� ���x�z���P�ʐݒ�ҏW�p�̃��X�g
	 * @throws Exception
	 */
	public VRList getSogoOverAdjustList(VRMap source) throws Exception {
		// �L�[���擾
		String key = ACCastUtilities.toString(
				source.get("SOGO_OVER_ADJUST_KEY"), "");
		// �ҏW�p�Ƀ��X�g�̃R�s�[��Ԃ��B
		VRList clone = new VRArrayList();
		// �f�[�^�̃N���[�����쐬����B
		clone.addAll(QkanValidServiceCommon.deepCopyVRList(sogoOverAdjustMap
				.get(key)));
		return clone;
	}

	/**
	 * ���͂��ꂽ�v��P�ʐ������Ƃɋ敪�x�����P�ʐ���ݒ肵�܂��B
	 * 
	 * @param source
	 *            �����z�̕ύX�Ώۍs�f�[�^
	 * @param planUnit
	 *            �v��P�ʐ�
	 */
	public void applyPlanUnit(Map source, int planUnit) {
		String key = ACCastUtilities.toString(source.get("KEY"), "");
		Map<String, Object> parsedRow = parsedData.get(key);

		// �������Ƃ̓Ǝ��藦�E�Ǝ���z�ȊO�̂Ƃ�
		if (!parsedRow.containsKey("SOGO_OVER_ADJUST_KEY")) {
			int unit = ACCastUtilities.toInt(parsedRow.get("UNIT"), 0);
			int adjust = unit - planUnit;
			if (adjust < 0) {
				adjust = 0;
			}
			//�v��P�ʐ���0�̂Ƃ��͖��ݒ�Ƃ��Ē����z��0�Ƃ���
			if (planUnit == 0) {
				adjust = 0;
			}
			parsedRow.put("ADJUST", adjust);
			
			// �����z���T�[�r�X�Ɋ���U��
			applyAdjustUnit(parsedRow);
			return;
		}
		
		// �������Ƃ̓Ǝ��藦�E�Ǝ���z�̏ꍇ
		// �ΏۂƂȂ�T�[�r�X�ɒ����z������U��
		if (parsedRow.containsKey("SOGO_OVER_ADJUST_KEY")) {

			// �L�[���擾
			String adjustKey = ACCastUtilities.toString(
					parsedRow.get("SOGO_OVER_ADJUST_KEY"), "");

			// �P�ʐ��̍��v�����߂�
			int totalUnit = 0;
			VRList list = sogoOverAdjustMap.get(adjustKey);
			for (int index = 0; index < list.size(); index++) {
				Map row = (Map) list.get(index);
				int unit = ACCastUtilities.toInt(row.get("UNIT"), 0);
				totalUnit += unit;
			}
			// ���U��Ώۂ̒����z
			// �P�ʐ��̍��v����v��P�ʐ�������
			int zan = totalUnit - planUnit;
			if (zan < 0) {
				zan = 0;
			}
			//�v��P�ʐ���0�̂Ƃ��͖��ݒ�Ƃ��Ē����z��0�Ƃ���
			if (planUnit == 0) {
				zan = 0;
			}

			// ���ȕ��S�z�����Ȃ��Ȃ�悤�ɕ��ёւ�
			List<Map<String, Object>> sortedList = new ArrayList(list);
			String kind = ACCastUtilities.toString(
					parsedRow.get("SERVICE_CODE_KIND"), "");
			if (QkanSjServiceCodeManager.teiritsuKinds.contains(kind)) {
				// �Ǝ��藦�̏ꍇ�́A���t���̒Ⴂ���̂�D��
				Collections.sort(sortedList, new SogoKyufuritsuComparator());
			} else if (QkanSjServiceCodeManager.teigakuKinds.contains(kind)) {
				// �Ǝ���z�̏ꍇ�́A�P�P�ʂ�����̗��p�ҕ��S�z���������̂�D��
				Collections.sort(sortedList, new SogoTeigakuComparator());
			}

			for (Map<String, Object> row : sortedList) {
				// �T�[�r�X�Ɋ��U��\�ȒP�ʐ�
				int kano = ACCastUtilities.toInt(row.get("UNIT"), 0);
				int wariate = 0;
				if (zan <= kano) {
					// ���蓖�Ďc���T�[�r�X�Ɋ��U��\�ȒP�ʐ��������������A�������ꍇ�A�c���S�����蓖��
					wariate = zan;
				} else {
					// ���蓖�Ďc���T�[�r�X�Ɋ��U��\�ȒP�ʐ������傫���ꍇ�A���蓖�ĉ\�ȕ������蓖��
					wariate = kano;
				}
				row.put("ADJUST", wariate);

				// ���蓖�Ă������c�������
				zan = zan - wariate;

				// �����z���T�[�r�X�Ɋ���U��
				applyAdjustUnit(row);
			}
		}
	}
	
	/**
	 * �������Ƃ̓Ǝ��T�[�r�X�Ōv��P�ʐ��ƒ����z�ɕs�������Ȃ����`�F�b�N���܂��B
	 * �s�������������ꍇ�́A�Ώۍs�ƌv��P�ʐ��̏���Ԃ��܂��B
	 * 
	 * @return �`�F�b�N����
	 * @throws Exception
	 */
	public List<Map<String, Object>> checkAndAdjustUnits() throws Exception {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		// �������Ƃ̓Ǝ��藦�E�Ǝ���z�̃T�[�r�X��ނ��Ƃ̃��X�g���쐬
		createSogoOverAdjustMap();
		
		for (Map<String, Object> parsedRow : parsedData.values()) {
			
			String kind = ACCastUtilities.toString(parsedRow.get("SERVICE_CODE_KIND"), "");
			if (!QkanSjServiceCodeManager.dokujiTeiritsuTeigakuKinds.contains(kind)) {
				//�Ǝ��E�Ǝ��藦�E��z�łȂ���΃X�L�b�v
				continue;
			}
			if (Boolean.TRUE.equals(parsedRow.get(PLAN_UNIT_SETUPED))) {
				continue; //�`�F�b�N�ς݂̍s�̓X�L�b�v
			}
			
			// �������Ƃ̓Ǝ��藦�E�Ǝ���z�̏ꍇ
			// �ΏۂƂȂ�T�[�r�X�ɒ����z������U��
			if (parsedRow.containsKey("SOGO_OVER_ADJUST_KEY")) {
				// �L�[���擾
				String adjustKey = ACCastUtilities.toString(
						parsedRow.get("SOGO_OVER_ADJUST_KEY"), "");

				int planUnit = ACCastUtilities.toInt(parsedRow.get("PLAN_UNIT"), 0);
				// �P�ʐ��̍��v�����߂�
				int totalUnit = 0;
				int totalAdjust = 0;
				VRList list = sogoOverAdjustMap.get(adjustKey);
				for (int index = 0; index < list.size(); index++) {
					Map row = (Map) list.get(index);
					int unit = ACCastUtilities.toInt(row.get("UNIT"), 0);
					int adjust = ACCastUtilities.toInt(row.get("ADJUST"), 0);
					totalUnit += unit;
					totalAdjust += adjust;
					
					// ���̍s�̓`�F�b�N�ςƂ���
					row.put(PLAN_UNIT_SETUPED, true);
				}
				if (planUnit > 0) {
					if (totalUnit > planUnit) {
						if (totalUnit != (totalAdjust + planUnit)) {
							// �s�����ȑΏۍs�ƌv��P�ʐ���Ԃ�
							Map<String, Object> ret = new HashMap<String, Object>();
							ret.put("PARSED_ROW", parsedRow);
							ret.put("PLAN_UNIT", planUnit);
							results.add(ret);
						}
					}
				} else if (planUnit == 0) {
					// �v��P�ʐ���0���������z�̂ݐݒ肳��Ă���ꍇ
					if (totalAdjust != 0) {
						// �s�����ȑΏۍs�ƌv��P�ʐ���Ԃ�
						Map<String, Object> ret = new HashMap<String, Object>();
						ret.put("PARSED_ROW", parsedRow);
						ret.put("PLAN_UNIT", planUnit);
						results.add(ret);
					}
				}
			} else {
				// �Ǝ��̏ꍇ�A�v��P�ʐ����Đݒ肷�邱�ƂŎ����I�ɒ�������B
				int unit = ACCastUtilities.toInt(parsedRow.get("UNIT"), 0);
				int adjust = ACCastUtilities.toInt(parsedRow.get("ADJUST"), 0);
				int planUnit = ACCastUtilities.toInt(parsedRow.get("PLAN_UNIT"), 0);
				if (planUnit > 0) {
					if (unit > planUnit) {
						if (unit != (adjust + planUnit)) {
							// �v��P�ʐ����璲���z�̍Đݒ�
							applyPlanUnit(parsedRow, planUnit);
						}
					}
				} else if (planUnit == 0) {
					// �v��P�ʐ���0���������z�̂ݐݒ肳��Ă���ꍇ
					if (adjust != 0) {
						// �v��P�ʐ����璲���z�̍Đݒ�
						applyPlanUnit(parsedRow, planUnit);
					}
				}
			}
		}
		return results;
	}

	// ���t���Ń\�[�g����Comparator
	private class SogoKyufuritsuComparator implements
			java.util.Comparator<Map<String, Object>> {
		public int compare(Map<String, Object> object1,
				Map<String, Object> object2) {
			Integer int1 = ACCastUtilities.toInt(
					object1.get("SOGO_KYUFURITSU"), 0);
			Integer int2 = ACCastUtilities.toInt(
					object2.get("SOGO_KYUFURITSU"), 0);
			return int1.compareTo(int2);
		}
	}
	
	// �P�P�ʂ�����̗��p�ҕ��S�z�̍~���Ń\�[�g����Comparator
	private class SogoTeigakuComparator implements
			java.util.Comparator<Map<String, Object>> {
		public int compare(Map<String, Object> object1,
				Map<String, Object> object2) {
			BigDecimal unit1 = new BigDecimal(ACCastUtilities.toInt(
					object1.get("TEIGAKU_UNIT"), 0));
			BigDecimal futan1 = new BigDecimal(ACCastUtilities.toInt(
					object1.get("TEIGAKU_FUTAN_TANKA"), 0));
			BigDecimal cost1 = futan1.divide(unit1, 7, BigDecimal.ROUND_HALF_UP);
			
			BigDecimal unit2 = new BigDecimal(ACCastUtilities.toInt(
					object2.get("TEIGAKU_UNIT"), 0));
			BigDecimal futan2 = new BigDecimal(ACCastUtilities.toInt(
					object2.get("TEIGAKU_FUTAN_TANKA"), 0));
			BigDecimal cost2 = futan2.divide(unit2, 7, BigDecimal.ROUND_HALF_UP);
			
			return cost1.compareTo(cost2) * -1;
		}
	}

}
