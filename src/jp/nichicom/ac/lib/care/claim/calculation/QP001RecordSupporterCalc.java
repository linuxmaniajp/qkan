
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
 * �쐬��: 2006/01/24  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X ��������(001)
 * �v���O���� ����ʊm��v�Z�N���X(QP001RecordSupporterCalc)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Iterator;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * ���R�[�h�ɕt���̌v�Z�Ɋւ��镔���i��Ɍ���j��S�����܂��B
 * 
 */
public class QP001RecordSupporterCalc {
	
	//�T�[�r�X�P�ʐ�
	private int service_unit = 0;
	//�K�p��
	private int times = 0;
	
	/**
	 * ������ŗL�̂h�c��ԋp���܂��B
	 * @param list
	 * @return
	 * @throws Exception
	 */
	protected static String getSerialId(VRList list,QP001PatientState patientState,Object tatgetDate,int insureType) throws Exception {
		StringBuilder serial = new StringBuilder();
		TreeMap treeMap = new TreeMap();
		
		if((list == null) || (list.getDataSize() <= 0)){
			//����K�p�Ȃ��p�^�[��
			return "NONE";
		}
		
		VRMap map;
		for(int i = 0; i < list.getDataSize(); i++){
			map = (VRMap)list.getData(i);
			treeMap.put(VRBindPathParser.get("KOHI_SORT",map),VRBindPathParser.get("KOHI_TYPE",map) + "-" + patientState.getKohiData(String.valueOf(map.get("KOHI_TYPE")),"BENEFIT_RATE",insureType));
            //���t����100�𒴂����ꍇ�͌���Ώۂ���͂���
		}
		
		Iterator it = treeMap.keySet().iterator();
		
		while(it.hasNext()){
            String[] datas = ACCastUtilities.toString(treeMap.get(it.next())).split("-");
			serial.append(datas[0]);
			serial.append("-");
            if(ACCastUtilities.toInt(datas[1]) >= 100){
                break;
            }
		}
		
		return serial.toString();
	}
	
	/**
	 * �R���X�g���N�^
	 * @param service_unit
	 */
	protected QP001RecordSupporterCalc(int service_unit){
		this.service_unit = service_unit;
	}
    
    protected void replaceServiceUnit(int service_unit){
        this.service_unit = service_unit;
    }
    
	/**
	 * �񐔂̉��Z���s���B
	 *
	 */
	protected void addTime(VRMap serviceDetail,VRMap serviceCode) throws Exception {
        //�����Ō���Z�Ή�
        String systemServiceCodeItem = String.valueOf(serviceCode.get("SYSTEM_SERVICE_CODE_ITEM"));
        String serviceCodeKind = String.valueOf(serviceCode.get("SERVICE_CODE_KIND"));
        if("Z6276".equals(systemServiceCodeItem) || "Z6277".equals(systemServiceCodeItem)){
            if("51".equals(serviceCodeKind)){
                this.times += ACCastUtilities.toInt(serviceDetail.get("1510132"),1);
            } else if("54".equals(serviceCodeKind)){
                this.times += ACCastUtilities.toInt(serviceDetail.get("1540128"),1);
            } else {
                //�ʏ�̃T�[�r�X
                this.times++;
            }
        } else {
            //�ʏ�̃T�[�r�X
            this.times++;
        }
        
//		this.times++;
	}
	
	protected int getServiceUnitTotal(){
		return service_unit * times;
	}
	
	public String toString(){
		return "[SERVICE_UNIT=" + service_unit + "][SERVICE_TIMES=" + times + "]";
	}
	
}
