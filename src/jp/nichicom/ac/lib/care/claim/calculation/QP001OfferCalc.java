/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKAACHO�iJMA care benefit management software�j
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
 * �쐬��: 2009/07/24  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���ъm��/�������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� ���p�҈ꗗ�i�����j (QP001)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.text.QkanWelfareToolFormat;

/**
 * 
 * �񋟓�����N���X
 * [ID:0000435][Shin Fujihara] 2009/07 2009�N�x�Ή�
 *
 */
public class QP001OfferCalc {

	private Map offer = new TreeMap();
	private Map serviceNameYogu = new VRHashMap();
	
	/**
	 * �񋟓��̉�͂����s����
	 * @param serviceDetail�@�T�[�r�X�񋟏ڍ�
	 * @param serviceCode�@���������T�[�r�X�R�[�h
	 * @throws Exception
	 */
	public void analize(VRMap serviceDetail, VRMap serviceCode) throws Exception {
		//�񋟓�
		Date serviceDate = ACCastUtilities.toDate(serviceDetail.get("SERVICE_DATE"), null);
		//�T�[�r�X��ރR�[�h
		String serviceKind = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"), null);
		//�擾�ł��Ȃ���΁A�������f
		if ((serviceDate == null) || (serviceKind == null)) {
			return;
		}
		
		//�����I�ɓW�J���ꂽ������f�[�^�̏ꍇ�́A�v�サ�Ȃ�
		//[ID:0000586][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
		//if (!QP001SpecialCase.isRealDay(serviceDetail)){
		if (!QP001SpecialCase.isRealDay(serviceDetail, serviceCode)){
		//[ID:0000586][Shin Fujihara] 2010/01 edit end 2009�N�x�Ή�
			return;
		}
		
		//���O�������������ꍇ�ɂ�CareServiceCommon.isGaihaku(serviceDetail)���g�p����
		
		int offerDays = 0;
		StringBuilder key = new StringBuilder(serviceKind);;
		
		//�K�����O����
		if ("11".equals(serviceKind)) {
			//�g�̉��A���������A�g�̐����A��~��ɕ��ނ���
			key.append(ACCastUtilities.toString(serviceDetail.get("1110101"), ""));
		
		//�����p���O����
		} else if ("17".equals(serviceKind)) {
			//�����p��́A�p��̕\���{����ʂ��Ē񋟂Ƃ���
			key.append(ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_ITEM"), ""));
			offerDays = 0xFFFFFFFF;
			
			//�p��̃L���b�V��
			serviceNameYogu.put(key.toString(), QkanWelfareToolFormat.getInstance().format(serviceDetail.get("1170101")));
			
		//�\�h�����p���O����
		} else if ("67".equals(serviceKind)) {
			//�����p��́A�p��̕\���{����ʂ��Ē񋟂Ƃ���
			key.append(ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_ITEM"), ""));
			offerDays = 0xFFFFFFFF;
			
			//�p��̃L���b�V��
			serviceNameYogu.put(key.toString(), QkanWelfareToolFormat.getInstance().format(serviceDetail.get("1670101")));
		}
		
		if (offerDays == 0) {
			int day = ACDateUtilities.getDayOfMonth(serviceDate);
			offerDays = getOfferDays(key.toString());
			offerDays |= (1 << (day - 1));
		}
		
		offer.put(key.toString(), new Integer(offerDays));
	}
	
	private int getOfferDays(String serviceKind) throws Exception {
		Integer offerDays = new Integer(0);
		if (offer.containsKey(serviceKind)){
			offerDays = (Integer)offer.get(serviceKind);
		}
		return offerDays.intValue();
	}
	
	/**
	 * �o�^�p�̃f�[�^�ɑ΂��A�m�肵���f�[�^��ǉ�����
	 * @param patientClaimMap
	 * @throws Exception
	 */
	public void marge(ACDBManager dbm, Date targetDate, VRMap patientClaimMap) throws Exception {
		
		//�T�[�r�X���̖|��擾
		VRMap serviceName = getMasterServiceAbbreviation(dbm, targetDate);
		
		//���Ɨ\�h�̃T�[�r�X��񋟂��Ă���i���r���v���x�ύX�j�̏ꍇ��
		//���T�[�r�X�̖��̂Ɋ񂹂�
		String[][] rule = new String[][]{
				{"11","61"},
				{"12","62"},
				{"13","63"},
				{"14","64"},
				{"15","65"},
				{"16","66"},
				{"171001","671001"},
				{"171002","671002"},
				{"171003","671003"},
				{"171004","671004"},
				{"171005","671005"},
				{"171006","671006"},
				{"171007","671007"},
				{"171008","671008"},
				{"171009","671009"},
				{"171010","671010"},
				{"171011","671011"},
				{"171012","671012"},
				{"21","24"},
				{"22","25"},
				{"23","26"},
				{"31","34"},
				{"33","35"},
				{"43","46"},
				{"72","74"},
				{"73","75"},
				{"32","37"},
				{"38","39"}
				};
		
		VRList margedKind = new VRArrayList();
		
		for (int i = 0; i < rule.length; i++) {
			String[] keys = rule[i];
			
			//���E�\�h�̃T�[�r�X���󋋂��Ă��邩�m�F
			if (!offer.containsKey(keys[0])
				|| !offer.containsKey(keys[1])){
				continue;
			}
			
			int kaigo = getOfferDays(keys[0]);
			int yobo = getOfferDays(keys[1]);
			
			kaigo |= yobo;
			offer.put(keys[0], new Integer(kaigo));
			offer.remove(keys[1]);
			
			margedKind.add(keys[0]);
		}
		
		int count = 1;
		int etcDays = 0;
		boolean etcMarged = false;
		
		Iterator it = offer.keySet().iterator();
		while(it.hasNext()) {
			String num = String.valueOf(count);
			String kind = it.next().toString();
			int days = getOfferDays(kind);
			
			//[ID:0000589][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
			//�T�[�r�X���̂̃}�X�^�ɓo�^����Ă��Ȃ��T�[�r�X��ރR�[�h�̏ꍇ��
			//�񋟓��Ƃ��ĎZ�肵�Ȃ��B
			//��������҉��T�[�r�X��̑Ή�
			if (!serviceName.containsKey(kind)) {
				continue;
			}
			//[ID:0000589][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
			
			//8�ȏ�T�[�r�X���󋋂��Ă���ꍇ�́A
			//7�߈ȏ���u���̑��v�Ƃ��Ă܂Ƃ߂�
			if (6 < count){
				num = "7";
				if (etcDays != 0) {
					kind = String.valueOf(Integer.MAX_VALUE);
				}
				if (!etcMarged) {
					etcMarged = margedKind.contains(kind);
				}
				etcDays |= days;
				days = etcDays;
			}
			patientClaimMap.put("MARK" + num + "_SERVICE_DATE_BIT", String.valueOf(days));
			
			if (etcMarged || margedKind.contains(kind)) {
				patientClaimMap.put("MARK" + num + "_SERVICE_NAME", serviceName.get(kind) + "(�\�h)");
			} else {
				patientClaimMap.put("MARK" + num + "_SERVICE_NAME", serviceName.get(kind));
			}

			count++;
		}
		
		//�T�[�r�X����7�����̏ꍇ�A�󔒖���
		for (int i = count; i <= 7; i++) {
			patientClaimMap.put("MARK" + i + "SERVICE_NAME", null);
			patientClaimMap.put("MARK" + i + "_SERVICE_DATE_BIT", null);
		}
	}
	
    /**
     * �T�[�r�X���i���́j���擾����B
     * @param targetDate �T�[�r�X�񋟓��t
     * @return VRMap
     */
    private VRMap getMasterServiceAbbreviation(ACDBManager dbm, Date targetDate) throws Exception {
    	VRMap result = new VRHashMap();
    	VRMap master = QkanCommon.getMasterService(dbm, targetDate);
    	Iterator it = master.keySet().iterator();
    	while(it.hasNext()) {
    		VRMap map = (VRMap)master.get(it.next());
    		String key = ACCastUtilities.toString(map.get("SERVICE_CODE_KIND"), "");
    		if (!result.containsKey(key)) {
    			result.put(map.get("SERVICE_CODE_KIND"), map.get("SERVICE_CALENDAR_ABBREVIATION"));
    		}
    	}
    	
    	//�T�[�r�X���̗�O�����Ή�
    	result.put("13", "�K��");
    	result.put("31", "����×{");
    	result.put("63", "�\�K�� ");
    	
    	result.put("111", "�g�̉��");
    	result.put("112", "��������");
    	result.put("113", "�g�̐���");
    	result.put("114", "��~�");
    	
    	result.put(String.valueOf(Integer.MAX_VALUE), "���̑�");
    	
    	it = serviceNameYogu.keySet().iterator();
    	while(it.hasNext()) {
    		String key = it.next().toString();
    		String kind = key.substring(0, 2);
    		result.put(key, result.get(kind) + " " + serviceNameYogu.get(key));
    	}
    	
    	return result;
    }
    
    
    //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
    /**
     * �W�v���ʏ����擾����
     * @return Map
     */
    public VRList getOfferServiceList(ACDBManager dbm, Date targetDate) throws Exception {
    	VRList result = new VRArrayList();
		VRMap serviceName = getMasterServiceAbbreviation(dbm, targetDate);
    	
    	Iterator it = offer.keySet().iterator();
    	lbl:while(it.hasNext()) {
    		String kind = it.next().toString();
			
			//�T�[�r�X���̂̃}�X�^�ɓo�^����Ă��Ȃ��T�[�r�X��ރR�[�h�̏ꍇ�͒񋟓��Ƃ��ĎZ�肵�Ȃ��B
			//��������҉��T�[�r�X��̑Ή�
			if (!serviceName.containsKey(kind)) {
				continue;
			}
    		
			int days = getOfferDays(kind);
			
			VRMap map = getSameKindRecord(kind, result);
			
			//�擾����map�̒��ŁA�񋟓��f�[�^�𓱓��\�Ȉʒu��T��
			for (int i = 1; i <= 7; i++) {
				if (map.get("MARK" + i + "_SERVICE_NAME") == null) {
					map.put("MARK" + i + "_SERVICE_NAME", serviceName.get(kind));
					map.put("MARK" + i + "_SERVICE_DATE_BIT", String.valueOf(days));
					continue lbl;
				}
			}
			
			//��L���[�v��continue����̂ŁA�����ɓ��B�����Ƃ���7�܂Ńf�[�^���[�U����Ă���
			//�T�[�r�X���̂����̑��ɕύX
			map.put("MARK7_SERVICE_NAME", serviceName.get(String.valueOf(Integer.MAX_VALUE)));
			//�񋟓��t���}�[�W
			int etcDays = ACCastUtilities.toInt(map.get("MARK7_SERVICE_DATE_BIT"), 0);
			map.put("MARK7_SERVICE_DATE_BIT", String.valueOf(etcDays | days));
			
    	}
    	
    	return result;
    }
    
    
    private VRMap getSameKindRecord(String kind, VRList list) {
    	VRMap map = null;
    	kind = kind.substring(0, 2);
    	
    	for (int i = 0; i < list.size(); i++) {
    		map = (VRMap)list.get(i);
    		if (kind.equals(ACCastUtilities.toString(map.get("SERVICE_CODE_KIND"), ""))) {
    			return map;
    		}
    	}
    	
    	map = getEmptyRecord();
    	map.put("SERVICE_CODE_KIND", kind);
    	list.add(map);
    	
    	return map;
    }
    
    //CLAIM_PATIENT_DETAIL�ɑΉ�����󃌃R�[�h�𐶐�����
    private VRMap getEmptyRecord() {
    	VRMap map = new VRHashMap();
    	
    	//���ȕ��S�p
    	for (int i = 1; i <= 3; i++) {
    		map.put("SELF_SERVICE_NO" + i, null);
    		map.put("SELF_PAY_NO" + i, null);
    	}
    	
    	//�񋟓��p
		for (int i = 1; i <= 7; i++) {
			map.put("MARK" + i + "_SERVICE_NAME", null);
			map.put("MARK" + i + "_SERVICE_DATE_BIT", null);
		}
    	
    	return map;
    }
    //[ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�
}
