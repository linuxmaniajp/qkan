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
 * �쐬��: 2009/03/04  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X ���t�Ǘ��[ (001)
 * �v���O���� ���t�Ǘ��[�G���[�Ǘ� (QP001ErrorControl)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Iterator;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanMessageList;

public class QP001ErrorControl {
	
	//�o�͂���G���[���b�Z�[�W�̓��e
	private StringBuilder errorMessage = new StringBuilder();
	//�`�F�b�N�����f�[�^�̌���
	private int checkCount = 0;
	//�G���[�f�[�^�̌���
	private int errorCount = 0;
	
	/**
	 * �l����\��i���t�Ǘ��[�j�f�[�^�̑Ó��������؂���B
	 * @param claimList
	 * @param patient
	 * @return
	 * @throws Exception
	 */
    public boolean isValidBenefitManagement(VRList claimList, VRMap patient) throws Exception {
        int totalUnitList = 0;
        int totalUnitMap = 0;
        VRMap claimMap = new VRHashMap();
        
        //�����������J�E���g�A�b�v
        checkCount++;
        
        // ���t�v��P�ʐ����v
        for(int i = 0; i < claimList.size(); i++){
            VRMap map = (VRMap)claimList.get(i);
            //99���R�[�h�͔���
            if(ACTextUtilities.isNullText(map.get("1201019"))){
                continue;
            }
            totalUnitList += ACCastUtilities.toInt(map.get("1201020"));
            claimMap.put(String.valueOf(map.get("1201019")) + "-" + String.valueOf(map.get("1201017")),map);
        }
        
        //�O�̂��߁A�l����\��ōs�Ȃ��Ă���̂Ɠ���̌v�Z�����{����
        Iterator it = claimMap.keySet().iterator();
        while(it.hasNext()){
        	VRMap map = (VRMap)claimMap.get(it.next());
        	totalUnitMap += ACCastUtilities.toInt(map.get("1201020"));
        }
        
        //���Z�s��v�G���[�̏ꍇ
        if (totalUnitList != totalUnitMap) {
        	//�G���[�������J�E���g�A�b�v
        	errorCount++;
        	//�ΏێҖ��̂�ޔ�
        	errorMessage.append(patient.get("PATIENT_FAMILY_NAME"));
        	errorMessage.append("�@");
        	errorMessage.append(patient.get("PATIENT_FIRST_NAME"));
        	errorMessage.append("\n");
        	return false;
        }
        
    	return true;
    }
    
    /**
     * isValidBenefitManagement�ŃG���[���������Ă���ꍇ�A
     * �G���[���b�Z�[�W��\������B
     *
     */
    public void showBenefitManagementError() throws Exception {
    	if(errorCount != 0){
    		QkanMessageList.getInstance().QP001_WARNING_BENEFIT_MANAGEMENT(errorMessage.toString());
    	}
    }
    
    /**
     * �S�Ă̌��؂��G���[�ł��邩���m�F����
     * @return true:�S�Č��؃G���[ false:����ʉ߂���
     * @throws Exception
     */
    public boolean isAllError() throws Exception {
    	return (checkCount == errorCount);
    }
    
}
