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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.vr.text.parsers.VRDateParser;

/**
 * %�����Z�̎Z��N���X
 * 
 * @author Yoichiro Kamei
 *
 */
public class QP001PercentageAdder {
	
	//�ΏۂƂȂ���Z�̎Z��ΏۂƂȂ��{�T�[�r�X���
	private Map<String, Object> serviceUnitMap = new HashMap<String, Object>();

	//�Z��̍ۂɌv�Z�Ɋ܂߂�֘A���Z�̏��
	private Map<Integer, Map<Integer, Map<String, Object>>> relationAddMap 
		= new HashMap<Integer, Map<Integer, Map<String, Object>>>();
	
	private static Integer SERVICE_ADD_FLAG_KYOUSEI = new Integer(5);
	private static Integer SERVICE_ADD_FLAG_SAME_BUILDING = new Integer(7);
	private static Integer SERVICE_ADD_FLAG_TOKUCHI = new Integer(3);
	

	//�Z��ΏۂƂȂ��{�T�[�r�X��KeySet���擾���܂��B
	public Set<String> getKihonKeySet() {
		return serviceUnitMap.keySet();	
	}
	
	protected void parse(Map serviceCode, Object targetServiceDate) throws Exception {
	    
	    String offer = VRDateParser.format(ACCastUtilities.toDate(targetServiceDate), "yyyyMMdd");
	    	    
	    if (CareServiceCommon.isAddPercentageForKyousei(serviceCode)) {
	    	//�����^���Z�̏ꍇ
            Map unitMap = (Map)serviceCode.get("SERVICE_UNIT_MAP_5");
            parseMap(offer, unitMap, serviceUnitMap);
	    } else if (CareServiceCommon.isAddPercentageForDoitu(serviceCode)) {
	    	//���ꌚ�����Z�̏ꍇ
            Map unitMap = (Map)serviceCode.get("SERVICE_UNIT_MAP_7");
            parseMap(offer, unitMap, serviceUnitMap);
            //�֘A���Z�̉��
            parseRelations(serviceCode, offer);
	    } else if (CareServiceCommon.isAddPercentageForSimple(serviceCode)) {
	    	//���ʒn����Z�A���K�͎��Ə����Z�̏ꍇ
            Map unitMap = (Map)serviceCode.get("SERVICE_UNIT_MAP");
            parseMap(offer, unitMap, serviceUnitMap);
            //�֘A���Z�̉��
            parseRelations(serviceCode, offer);
	    } else if (CareServiceCommon.isAddPercentageForArea(serviceCode)) {
	    	//���R�Ԓn�擙�񋟉��Z�̏ꍇ
            Map unitMap = (Map)serviceCode.get("SERVICE_UNIT_MAP");
            parseMap(offer, unitMap, serviceUnitMap);
            //�֘A���Z�̉��
            parseRelations(serviceCode, offer);
	    }
	    
	}
	
	private void parseRelations(Map serviceCode, String offer) throws Exception {
        //�����^���Z�̊֘A����ێ����Ă���ꍇ
        if (serviceCode.containsKey("SERVICE_UNIT_ADD_MAP_5")) {
        	Map addMap = (Map) serviceCode.get("SERVICE_UNIT_ADD_MAP_5");
        	int addFlg = ACCastUtilities.toInt(addMap.get("SERVICE_ADD_FLAG"), 0);
        	int relateAddRate = ACCastUtilities.toInt(addMap.get("SERVICE_UNIT"), 0);
        	if (addMap.containsKey("SERVICE_UNIT_MAP_5")){
        		Map unitMapKyousei = (Map) addMap.get("SERVICE_UNIT_MAP_5");
        		parseAddMap(offer, unitMapKyousei, addFlg, relateAddRate);
        	}
        }
        //���ꌚ�����Z�̊֘A����ێ����Ă���ꍇ
        if (serviceCode.containsKey("SERVICE_UNIT_ADD_MAP_7")) {
        	Map addMap = (Map) serviceCode.get("SERVICE_UNIT_ADD_MAP_7");
        	int addFlg = ACCastUtilities.toInt(addMap.get("SERVICE_ADD_FLAG"), 0);
        	int relateAddRate = ACCastUtilities.toInt(addMap.get("SERVICE_UNIT"), 0);
        	if (addMap.containsKey("SERVICE_UNIT_MAP_7")){
        		Map unitMapDouitu = (Map) addMap.get("SERVICE_UNIT_MAP_7");
        		parseAddMap(offer, unitMapDouitu, addFlg, relateAddRate);
        	}
        }
        //���ʒn����Z�A���K�͎��Ə����Z�̂̊֘A����ێ����Ă���ꍇ
        if (serviceCode.containsKey("SERVICE_UNIT_ADD_MAP")) {
        	Map addMap = (Map) serviceCode.get("SERVICE_UNIT_ADD_MAP");
        	int addFlg = ACCastUtilities.toInt(addMap.get("SERVICE_ADD_FLAG"), 0);
        	int relateAddRate = ACCastUtilities.toInt(addMap.get("SERVICE_UNIT"), 0);
        	if (addMap.containsKey("SERVICE_UNIT_MAP")){
        		Map unitMap = (Map) addMap.get("SERVICE_UNIT_MAP");
        		parseAddMap(offer, unitMap, addFlg, relateAddRate);
        	}
        }
	}
	
	private void parseAddMap(String offer, Map unitMap, int addFlg, int rate) throws Exception {
		//relationAddMap�͉��Z�t���O�A���Z���Z�����Ƃɏ���ێ�
		if (!relationAddMap.containsKey(addFlg)) {
			relationAddMap.put(addFlg, new HashMap<Integer, Map<String, Object>>());
		}
		Map<Integer, Map<String, Object>> serviceUnitAddRateMap = relationAddMap.get(addFlg);
		if (!serviceUnitAddRateMap.containsKey(rate)) {
			serviceUnitAddRateMap.put(rate, new HashMap<String, Object>());
		}
		Map<String, Object> serviceUnitAddMap = serviceUnitAddRateMap.get(rate);
				
		parseMap(offer, unitMap, serviceUnitAddMap);
	}
	
	private void parseMap(String offer, Map unitMap, Map<String, Object> target) throws Exception {
        Iterator it = unitMap.keySet().iterator();
        String key = "";
        //���R�[�h�m�莞�Ɉꊇ�W�v
        while(it.hasNext()){
            key = String.valueOf(it.next());
            Map map = null;
            Integer times = null;
            Set<String> offerDay = null;
            
            //�o�^�ς݂̃T�[�r�X�̏ꍇ
            if(target.containsKey(key)){
                map = (Map)target.get(key);
                times = (Integer)map.get("TIMES");
                offerDay = (Set)map.get("OFFER");
                
            } else {
                map = new HashMap();
                map.put("UNIT",unitMap.get(key));
                target.put(key,map);
                times = new Integer(0);
                offerDay = new HashSet<String>();
            }
            
            //�O���[�v���t���O���Q��
            //���P��
            if (key.endsWith("2")) {
                //���ɒ񋟍ςł���΃X�L�b�v
                if (offerDay.contains(offer)) {
                    continue;
                }
                
            //���P��
            } else if (key.endsWith("3")) {
                //���ɒ񋟍ςł���΃X�L�b�v
                if (!offerDay.isEmpty()) {
                    continue;
                }
            }
            
            //�񋟓���ݒ�
            offerDay.add(offer);
            times = new Integer(times.intValue() + 1);
            map.put("TIMES",times);
            map.put("OFFER",offerDay);
        }
	}
	
	protected boolean hasData() {
		return !serviceUnitMap.isEmpty();
	}
	
	protected int getUnit() throws Exception {
		
		int baseUnit = getUnitTotal(serviceUnitMap);
		int diffUnit = 0;
		
		//�֘A���Z�̒P�ʐ����v�Z���đΏےP�ʐ��ɔ��f
		if (!relationAddMap.isEmpty()) {
			Map<Integer, Map<String, Object>> serviceUnitAddRateMap;
			//�����^���Z�̌v�Z
			int kyouseiUnit = 0;
			if (relationAddMap.containsKey(SERVICE_ADD_FLAG_KYOUSEI)) {
				serviceUnitAddRateMap = relationAddMap.get(SERVICE_ADD_FLAG_KYOUSEI);
				for (int rate : serviceUnitAddRateMap.keySet()) {
					Map<String, Object> serviceUnitAddMap = serviceUnitAddRateMap.get(rate);
					int tmp = getUnitTotal(serviceUnitAddMap);
					kyouseiUnit += CareServiceCommon.calcPercentageUnit(tmp, rate);
				}
				diffUnit += kyouseiUnit;
			}
			//���ꌚ�����Z�̌v�Z
			int douituUnit = 0;
			if (relationAddMap.containsKey(SERVICE_ADD_FLAG_SAME_BUILDING)) {
				serviceUnitAddRateMap = relationAddMap.get(SERVICE_ADD_FLAG_SAME_BUILDING);
				for (int rate : serviceUnitAddRateMap.keySet()) {
					Map<String, Object> serviceUnitAddMap = serviceUnitAddRateMap.get(rate);
					int tmp = getUnitTotal(serviceUnitAddMap);
					douituUnit += CareServiceCommon.calcPercentageUnit(tmp + diffUnit, rate);
				}
				diffUnit += douituUnit;
			}
			//���ʒn����Z�A���K�͎��Ə����Z�̌v�Z
			int areaUnit = 0;
			if (relationAddMap.containsKey(SERVICE_ADD_FLAG_TOKUCHI)) {
				serviceUnitAddRateMap = relationAddMap.get(SERVICE_ADD_FLAG_TOKUCHI);
				for (int rate : serviceUnitAddRateMap.keySet()) {
					Map<String, Object> serviceUnitAddMap = serviceUnitAddRateMap.get(rate);
					int tmp = getUnitTotal(serviceUnitAddMap);
					areaUnit += CareServiceCommon.calcPercentageUnit(tmp + diffUnit, rate);
				}
				diffUnit += areaUnit;
			}
		}
		
		return (baseUnit + diffUnit);
	}
	
	private int getUnitTotal(Map<String, Object> target) throws Exception {
		int totalUnit = 0;
		for (String key : target.keySet()) {
            //�P�ʐ�-��
            Map map = (Map) target.get(key);
            Integer unit = (Integer) map.get("UNIT");
            Integer times = (Integer) map.get("TIMES");
            totalUnit += unit.intValue() * times.intValue();
		}
        return totalUnit;
	}
	

	/**
	 * �ێ����Ă���T�[�r�X����key�Ɏw�肵���T�[�r�X�����O���܂��B
	 * 
	 * key�͈ȉ��̌���������ƂȂ�܂��B
	 * "SYSTEM_SERVICE_KIND_DETAIL"-"SYSTEM_SERVICE_CODE_ITEM"-"TOTAL_GROUPING_TYPE"
	 * �������Ƃ̓Ǝ��̏ꍇ�́A
	 * "INSURER_ID-SYSTEM_SERVICE_KIND_DETAIL"-"SYSTEM_SERVICE_CODE_ITEM"-"TOTAL_GROUPING_TYPE"
	 */
	public void removeService(String key) {
		if (!relationAddMap.isEmpty()) {
			for (Map<Integer, Map<String, Object>> serviceUnitAddRateMap : relationAddMap.values()) {
				for (Map<String, Object> serviceUnitAddMap : serviceUnitAddRateMap.values()) {
					serviceUnitAddMap.remove(key);
				}
			}
		}
		if (!serviceUnitMap.isEmpty()) {
			serviceUnitMap.remove(key);
		}
	}


}
