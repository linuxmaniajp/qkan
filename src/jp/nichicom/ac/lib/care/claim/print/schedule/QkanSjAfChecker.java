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

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.vr.util.VRMap;

/**
 * �������Ƃ̉��\�h�P�A�}�l�W�����g�iAF�j�֘A���`�F�b�N���邽�߂̃N���X
 * 
 * @since V7.3.2
 * @author Yoichiro.Kamei
 */
public class QkanSjAfChecker {
    
	public enum Mode {
		SERVICE_UPDATE, //�T�[�r�X�o�^��
		SEIKYU_DATA //�����f�[�^�쐬��
	};
	private Mode mode = Mode.SERVICE_UPDATE;
    private CareServiceCodeCalcurater calcurater;

    /**
     * �R���X�g���N�^�B
     * 
     * @param calcurater  �����A�������ς݂�CareServiceCodeCalcurater
     * @throws Exception
     */
    public QkanSjAfChecker(CareServiceCodeCalcurater calcurater, Mode mode) throws Exception {
        this.calcurater = calcurater;
        this.mode = mode;
    }
 
    /**
     * �n���ꂽ�T�[�r�X�Ɋ܂܂��R�[�h��AF�Ɠ����ɎZ��\�ȃR�[�h�ł��邩�`�F�b�N���܂��B
     * �Z��o���Ȃ��R�[�h���ݒ肳��Ă����ꍇ�́AQkanSjAfException���X���[���܂��B
     * 
     * @param service
     * @throws QkanSjAfException �Z��o���Ȃ��T�[�r�X�R�[�h���ݒ肳��Ă����ꍇ
     */
    public void checkCodes(VRMap service) throws Exception {
        checkServiceCodeList(calcurater.getServiceCodes(service));
    }
    
    /**
     * �n���ꂽ�T�[�r�X�Ɋ܂܂��R�[�h��AF�Ɠ����ɎZ��\�ȃR�[�h�ł��邩�`�F�b�N���܂��B
     * �Z��o���Ȃ��R�[�h���ݒ肳��Ă����ꍇ�́AQkanSjAfException���X���[���܂��B
     * 
     * @param serviceCodeList
     * @throws QkanSjAfException �Z��o���Ȃ��T�[�r�X�R�[�h���ݒ肳��Ă����ꍇ
     */
    public void checkServiceCodeList(List serviceCodeList) throws Exception {
        Iterator it = serviceCodeList.iterator();	
        while (it.hasNext()) {
            Map code = (Map) it.next();
            checkCode(code);
        }
    }
    
    /**
     * �n���ꂽ�R�[�h��AF�Ɠ����ɎZ��\�ȃR�[�h�ł��邩�`�F�b�N���܂��B
     * �Z��o���Ȃ��R�[�h���ݒ肳��Ă����ꍇ�́AQkanSjAfException���X���[���܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @throws QkanSjAfException �Z��o���Ȃ��T�[�r�X�R�[�h���ݒ肳��Ă����ꍇ
     */
    public void checkCode(Map code) throws Exception {
    	//�T�[�r�X�o�^���̃`�F�b�N
    	if (Mode.SERVICE_UPDATE.equals(this.mode) ) {
            if (CareServiceCommon.isPreventService(code)) {
            	if (CareServiceCommon.isInLimitAmount(code)) {
            		//�\�h�Ō��x�z�Ǘ��Ώۂ̃T�[�r�X�̏ꍇ
            		throw new QkanSjAfException(code, QkanSjAfException.Type.YOBO_GENDOGAKU_SV);
            	}
            }
    	}
        //���\�h�x���̏ꍇ
        if (CareServiceCommon.isPreventService(code)) {
        	CareServiceCommon.isCareManagement(code);
        	throw new QkanSjAfException(code, QkanSjAfException.Type.YOBO_SHIEN_SV);
        }
    }

}
