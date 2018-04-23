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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;

/**
 * �����^�̌��Z�̒P�ʐ��Z��N���X
 * 
 * [H30.04�����Ή�]
 * ���t���x�z�Ǘ��Ώۂ̐ςݏグ�v�Z��A���S�z�������̒P�ʐ��̊e�T�[�r�X�ւ̊���U��
 * ���s���ۂɓ�����񐔂ł̃T�[�r�X�Z�莞�_�ɑ΂��Č��Z�P�ʐ��̌v�Z���s���B
 * 
 * @author Yoichiro Kamei
 *
 */
public class KyouseiUnitCalcurater {
	
	//���̃N���X�Œǉ����������^�T�[�r�X�̒P�ʐ�
	//�i���ɐݒ�ς݂̃L�[�Əd�����Ȃ��悤�ɃN���X����t���Ă��܂��j
	private static String KYOUSEI_UNIT = KyouseiUnitCalcurater.class.getSimpleName() + "_KYOUSEI_UNIT";
	
	//���̃N���X�Œǉ����������^�T�[�r�X�̃T�[�r�X�R�[�h���i�[����KEY������
	//�i���ɐݒ�ς݂̃L�[�Əd�����Ȃ��悤�ɃN���X����t���Ă��܂��j
	private static String KYOUSEI_SERVICE_CODE = KyouseiUnitCalcurater.class.getSimpleName() + "_KYOUSEI_SERVICE_CODE";
	
	//���̃N���X�Œǉ����������^�T�[�r�X���ΏۂƂ����{�T�[�r�X�P�ʐ����i�[����KEY������
	//�i���ɐݒ�ς݂̃L�[�Əd�����Ȃ��悤�ɃN���X����t���Ă��܂��j
	private static String KYOUSEI_KIHON_UNIT = KyouseiUnitCalcurater.class.getSimpleName() + "_KYOUSEI_KIHON_UNIT";
	
	//<�����^�T�[�r�X�̃T�[�r�X���ڃR�[�h�A�T�[�r�X�R�[�h�}�X�^���>
	private Map<String, Map<String, Object>> kyouseiCodes = new HashMap<String, Map<String, Object>>();
	
	//<�����^�T�[�r�X�̃T�[�r�X���ڃR�[�h�A�v�Z�ς݂̊�{�T�[�r�X�P�ʐ��̍��Z>
	private Map<String, Integer> sumKihonUnitMap = new HashMap<String, Integer>();
	
	//<�����^�T�[�r�X�̃T�[�r�X���ڃR�[�h�A�v�Z�ς݂̋����^���Z�̒P�ʐ��̍��Z>
	private Map<String, Integer> sumKyouseiUnitMap = new HashMap<String, Integer>();
	
	//�����^���Z���Z�肳��Ă���T�[�r�X�̃��X�g�i���n��Ń\�[�g����Ă��邱�Ɓj
	private List<Map<String, Object>> services = new ArrayList<Map<String, Object>>();

	
    /**
     * �w�肵���T�[�r�X�ɋ����^���Z�̑ΏۂƂȂ��{�T�[�r�X�P�ʐ���ݒ肵�܂��B
     */
	public void putKihonUnit(Map<String, Object> service, int unit) {
		service.put(KYOUSEI_KIHON_UNIT, new Integer(unit));
	}
	
    /**
     * �w�肵���T�[�r�X�ɋ����^���Z�̃T�[�r�X���ڃR�[�h��ݒ肵�܂��B
     * @throws Exception 
     */
	public void putKyouseiCode(Map<String, Object> service, Map<String, Object> code) throws Exception {
		String kyouseiKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"));
		String kyouseiItemCode = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));
		String svCode = kyouseiKind + kyouseiItemCode;
		service.put(KYOUSEI_SERVICE_CODE, svCode);
		//�v�Z�p�Ƀ}�X�^�����i�[
		if (!kyouseiCodes.containsKey(svCode)) {
			kyouseiCodes.put(svCode, code);			
		}
	}
	
    /**
     * �w�肵���T�[�r�X�����̃N���X�ł̌v�Z�ΏۂƂȂ邩�ǂ�����Ԃ��܂��B
     * �i�����^���Z�̃T�[�r�X���ڃR�[�h�Ɛ��^���Z�̑ΏۂƂȂ��{�T�[�r�X�P�ʐ������̃N���X�ɂ��ݒ肳��Ă��邩�ǂ����j
     */
	public boolean isKyouseiCalcService(Map<String, Object> service) {
		return service.containsKey(KYOUSEI_KIHON_UNIT) && service.containsKey(KYOUSEI_SERVICE_CODE);
	}
	
    /**
     * ���̃N���X�ł̌v�Z�ΏۂƂȂ�T�[�r�X��ێ����Ă��邩�ǂ�����Ԃ��܂��B
     */
	public boolean hasService() {
		return !services.isEmpty();
	}
	
    /**
     * �����^���Z�̌v�Z�ΏۂƂȂ�T�[�r�X��ǉ����܂��B
     */
	public void addKyouseiService(Map<String, Object> service) {
		services.add(service);
	}
	
    /**
     * �����^���Z�̌v�Z���s���܂��B
     * @throws Exception 
     */
	public void calcKyouseiUnit() throws Exception {
		calcKyouseiUnit(null);
	}
	
    /**
     * �����^���Z�̌v�Z���s���܂��B
     * @param serviceUnitKey �T�[�r�X�ɕێ����Ă���P�ʐ��Ɍ��Z�𔽉f����ꍇ�ɂ���KEY���w�肷��
     * @throws Exception 
     */
	public void calcKyouseiUnit(String serviceUnitKey) throws Exception {
		for (Map<String, Object> service : services) {
			String svCode = ACCastUtilities.toString(service.get(KYOUSEI_SERVICE_CODE), "");
			int kihonUnit = ACCastUtilities.toInt(service.get(KYOUSEI_KIHON_UNIT), 0);
			int sumKyouseiUnit = ACCastUtilities.toInt(sumKyouseiUnitMap.get(svCode), 0);
			int sumKihonUnit = ACCastUtilities.toInt(sumKihonUnitMap.get(svCode), 0);
			
			if (kihonUnit == 0 || "".equals(svCode)) {
				continue;
			}
			
			//�����^���Z�̃T�[�r�X�R�[�h�}�X�^���
			Map<String, Object> kyouseiCode = kyouseiCodes.get(svCode);			
			int per = ACCastUtilities.toInt(kyouseiCode.get("SERVICE_UNIT"), 0);//���Z��
			
			//���̃T�[�r�X�Z�莞�_�ł̋����^���Z�̒P�ʐ�
			int nowKihonUnit = sumKihonUnit + kihonUnit;
			int nowKyouseiUnit = CareServiceCommon.calcPercentageUnit(nowKihonUnit, per);
			int diffKyouseiUnit = nowKyouseiUnit - sumKyouseiUnit;
			//�����^���Z�P�ʐ��̑O��l�Ƃ̍��������Z�P�ʐ��Ƃ��ăT�[�r�X�ɐݒ�
			service.put(KYOUSEI_UNIT, diffKyouseiUnit);
			
			//serviceUnitKey���w�肳��Ă���ꍇ�A����KEY�Ɍ��Z�P�ʐ��𔽉f����
			if (serviceUnitKey != null && !"".equals(serviceUnitKey)) {
				if (service.containsKey(serviceUnitKey)) {
					int nowUnit = ACCastUtilities.toInt(service.get(serviceUnitKey), 0);
					service.put(serviceUnitKey, nowUnit + diffKyouseiUnit);
				} else {
					service.put(serviceUnitKey, diffKyouseiUnit);
				}
			}
			
			//���Z�l�̍X�V
			sumKyouseiUnitMap.put(svCode, nowKyouseiUnit);
			sumKihonUnitMap.put(svCode, nowKihonUnit);
		}
	}
	
    /**
     * ���̃N���X�Ōv�Z�p�ɒǉ������T�[�r�X�̃}�b�vKEY���폜���܂��B
     * �i���̃N���X�Ōv�Z���������^���Z�̒P�ʐ����g�p������A�T�[�r�X�ɕs�v��KEY���c���Ă���ƕs�s��������ꍇ�ɌĂԁj
     */
	public void removeServiceKey() {
		for (Map<String, Object> service : services) {
			service.remove(KYOUSEI_UNIT);
			service.remove(KYOUSEI_SERVICE_CODE);
			service.remove(KYOUSEI_KIHON_UNIT);
		}
	}

}
