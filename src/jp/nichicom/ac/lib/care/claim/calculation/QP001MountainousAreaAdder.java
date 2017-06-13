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
 * �J����: �����@�L
 * �쐬��: 2009/03/26  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� ���R�Ԓn����Z�Z��N���X�iQP001MountainousAreaAdder�j
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * ���R�Ԓn����Z�̎Z��N���X
 * 
 * ���������G�Ȃ̂ŁA���̉��Z�̂ݓ��ʂɐ؂�o���ăN���X��
 * 
 * @author Shin Fujihara
 *
 */
public class QP001MountainousAreaAdder {
	
	//�ʏ�̊�{�P�ʑޔ�p
	private VRMap serviceUnitMap = new VRHashMap();
	//���ʒn����Z�Z��p
	private VRMap serviceUnitAddMap = new VRHashMap();
	//���ʒn����Z�̊|����
	private int serviceUnitAddRaito = Integer.MIN_VALUE;
	
	
	protected void parse(VRMap serviceCode, Object targetServiceDate) throws Exception {
	    
	    String offer = VRDateParser.format(ACCastUtilities.toDate(targetServiceDate), "yyyyMMdd");
	    
        //���X�g��ێ����Ă���ꍇ
        if(serviceCode.containsKey("SERVICE_UNIT_MAP")){
            VRMap unitMap = (VRMap)serviceCode.get("SERVICE_UNIT_MAP");
            parseMap(offer, unitMap, serviceUnitMap);
        }
        if (serviceCode.containsKey("SERVICE_UNIT_ADD_MAP")){
        	VRMap addMap = (VRMap)serviceCode.get("SERVICE_UNIT_ADD_MAP");
        	if (serviceUnitAddRaito == Integer.MIN_VALUE){
        		serviceUnitAddRaito = ACCastUtilities.toInt(addMap.get("SERVICE_UNIT"), 0);
        	}
        	
        	if (addMap.containsKey("SERVICE_UNIT_MAP")){
        		VRMap unitMap = (VRMap)serviceCode.get("SERVICE_UNIT_MAP");
        		parseMap(offer, unitMap, serviceUnitAddMap);
        	}
        }
	}
	
	private void parseMap(String offer, VRMap unitMap, VRMap target) throws Exception {
        Iterator it = unitMap.keySet().iterator();
        String key = "";
        //���R�[�h�m�莞�Ɉꊇ�W�v
        while(it.hasNext()){
            key = String.valueOf(it.next());
            VRMap map = null;
            Integer times = null;
            Set<String> offerDay = null;
            
            //�o�^�ς݂̃T�[�r�X�̏ꍇ
            if(target.containsKey(key)){
                map = (VRMap)target.get(key);
                times = (Integer)map.get("TIMES");
                offerDay = (Set)map.get("OFFER");
                
            } else {
                map = new VRHashMap();
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
		int specialUnit = 0;
		
		if (!serviceUnitAddMap.isEmpty()){
			int tmp = getUnitTotal(serviceUnitAddMap);
			specialUnit = (int)Math.round((double)(tmp * serviceUnitAddRaito) / 100d);
		}
		
		return (baseUnit + specialUnit);
	}
	
	private int getUnitTotal(VRMap target) throws Exception {
		int totalUnit = 0;
		
        Iterator it = target.keySet().iterator();
        while(it.hasNext()){
            String key = String.valueOf(it.next());
            //�P�ʐ�-��
            VRMap map = (VRMap)target.get(key);
            Integer unit = (Integer)map.get("UNIT");
            Integer times = (Integer)map.get("TIMES");
            totalUnit += unit.intValue() * times.intValue();
        }
        return totalUnit;
	}
	
// 2016/7/21 [Yoichiro Kamei] add - begin �������ƑΉ�
	/**
	 * �ێ����Ă���T�[�r�X����key�Ɏw�肵���T�[�r�X�����O���܂��B
	 * 
	 * key�͈ȉ��̌���������ƂȂ�܂��B
	 * "SYSTEM_SERVICE_KIND_DETAIL"-"SYSTEM_SERVICE_CODE_ITEM"-"TOTAL_GROUPING_TYPE"
	 * �������Ƃ̓Ǝ��̏ꍇ�́A
	 * "INSURER_ID-SYSTEM_SERVICE_KIND_DETAIL"-"SYSTEM_SERVICE_CODE_ITEM"-"TOTAL_GROUPING_TYPE"
	 */
	public void removeService(String key) {
		if (!serviceUnitAddMap.isEmpty()){
			serviceUnitAddMap.remove(key);
		}
		if (!serviceUnitMap.isEmpty()){
			serviceUnitMap.remove(key);
		}
	}
// 2016/7/21 [Yoichiro Kamei] add - end

}
