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

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.util.VRMap;

/**
 * �������Ƃ̕ی��Ҕԍ����`�F�b�N���邽�߂̃N���X
 * 
 * @since V7.3.0
 * @author Yoichiro.Kamei
 */
public class QkanSjInsurerChecker {
    
    private ACDBManager dbm;
    private CareServiceCodeCalcurater calcurater;
    private Date targetDate;
    private boolean isTukitotyuJushotiTokurei = false; //���r���Z���n���Ⴉ�ǂ���

    /**
     * �R���X�g���N�^�B
     * 
     * @param calcurater  �����A�������ς݂�CareServiceCodeCalcurater
     * @throws Exception
     */
    public QkanSjInsurerChecker(CareServiceCodeCalcurater calcurater) throws Exception {
        this.calcurater = calcurater;
        this.dbm = calcurater.getDBManager();
        this.targetDate = calcurater.getTargetDate();
        
        // ���r���Z���n���Ⴉ�ǂ���
        // ���r���Z���n����ˌ����ƌ����̏Z���n����̎{�ݏ��ݕی��Ҕԍ����قȂ�
        String firstId = calcurater.getJushotiTokureiInsurerId(ACDateUtilities.toFirstDayOfMonth(targetDate));
        String lastId = calcurater.getJushotiTokureiInsurerId(ACDateUtilities.toLastDayOfMonth(targetDate));
        if (!"".equals(firstId) || !"".equals(lastId)) {
            if (!firstId.equals(lastId)) {
                this.isTukitotyuJushotiTokurei = true;
            }
        }
    }
 
    /**
     * �n���ꂽ�T�[�r�X�Ɋ܂܂��R�[�h���Z��\�ȑ������Ƃ̕ی��Ҕԍ��ł��邩�`�F�b�N���܂��B
     * �Z��o���Ȃ��ی��Ҕԍ����R�[�h�ɐݒ肳��Ă����ꍇ�́AQkanSjInsurerException���X���[���܂��B
     * 
     * @param service
     * @throws QkanSjInsurerException �Z��o���Ȃ��ی��Ҕԍ����R�[�h�ɐݒ肳��Ă����ꍇ
     */
    public void checkCodes(VRMap service) throws Exception {
        checkServiceCodeList(calcurater.getServiceCodes(service), service);
    }
    
    /**
     * �n���ꂽ�T�[�r�X�R�[�h�̃��X�g���Z��\�ȑ������Ƃ̕ی��Ҕԍ��ł��邩�`�F�b�N���܂��B
     * �Z��o���Ȃ��ی��Ҕԍ����R�[�h�ɐݒ肳��Ă����ꍇ�́AQkanSjInsurerException���X���[���܂��B
     * 
     * @param serviceCodeList
     * @param service
     * @throws QkanSjInsurerException �Z��o���Ȃ��ی��Ҕԍ����R�[�h�ɐݒ肳��Ă����ꍇ
     */
    public void checkServiceCodeList(List serviceCodeList, VRMap service) throws Exception {
        Date serviceDate = ACCastUtilities.toDate(service.get("SERVICE_DATE"), null);
        if (serviceDate == null) {
            return;
        }
        Iterator it = serviceCodeList.iterator();
        while (it.hasNext()) {
            Map code = (Map) it.next();
            getSjInsurerIdByCode(serviceDate, code);
        }
    }
    
    /**
     * �n���ꂽ�T�[�r�X�R�[�h���Z��\�ȑ������Ƃ̕ی��Ҕԍ����擾���܂��B
     * �Z��o���Ȃ��ی��Ҕԍ����R�[�h�ɐݒ肳��Ă����ꍇ�́AQkanSjInsurerException���X���[���܂��B
     * 
     * @param targetServiceDate �T�[�r�X�񋟓�
     * @param code �T�[�r�X�R�[�h
     * @return �n���ꂽ�T�[�r�X�R�[�h���Z��\�ȑ������Ƃ̕ی��Ҕԍ�
     * @throws QkanSjInsurerException �Z��o���Ȃ��ی��Ҕԍ����R�[�h�ɐݒ肳��Ă����ꍇ
     */
    public String getSjInsurerIdByCode(Date targetServiceDate, Map code) throws Exception {
        //�R�[�h�ɕی��Ҕԍ����ݒ肳��Ă��Ȃ��ꍇ�A�i�������Ƃ̓Ǝ��E�Ǝ��藦�E�Ǝ���z�ł͂Ȃ��j
        String insurerId = ACCastUtilities.toString(code.get("INSURER_ID"), "");
        if ("".equals(insurerId)) {
            return "";
        }
        // �Ώۓ��ɎZ��\�ȑ������Ƃ̕ی��Ҕԍ����擾
        String sjInsureId = getSjInsurerIdAtDate(targetServiceDate);;
        
        // ���r���Z���n����̏ꍇ
        if (isTukitotyuJushotiTokurei) {
            //���z�T�[�r�X�A���z���Z�A�n��n%���Z�̏ꍇ
            if (ACCastUtilities.toInt(code.get("TOTAL_GROUPING_TYPE"), 0) == 3 //1���ɂ�
                || isPercentageCode(code)) {
                // �������_�̏󋵂ɂ�����ی��Ҕԍ���Ԃ�
                sjInsureId = getSjInsurerIdAtDate(ACDateUtilities.toLastDayOfMonth(targetServiceDate));
            }
        }
        // �`�F�b�N���ĕԂ�
        return checkAndConvSjInsurerId(sjInsureId, code);
    }
    
    // �T�[�r�X�R�[�h�ɐݒ肳�ꂽ�������Ƃ̕ی��Ҕԍ����`�F�b�N���ēK�؂Ȃ��̂ɒu������
    private String checkAndConvSjInsurerId(String sjInsureId, Map code) throws Exception {
        // �R�[�h�ɐݒ肳�ꂽ�ی��Ҕԍ��Ǝ擾�����ی��Ҕԍ��������ꍇ
        String insureId = ACCastUtilities.toString(code.get("INSURER_ID"), "");
        if (sjInsureId.equals(insureId)) {
            // �R�[�h�̕ی��Ҕԍ���Ԃ��B
            return insureId;
        }
        
        String systemServiceKindDetail = ACCastUtilities.toString(code.get("SYSTEM_SERVICE_KIND_DETAIL"));
        // �Ǝ��̏ꍇ�́A�Z��\�ȕی��Ҕԍ��ɒu��������
        if (QkanSjServiceCodeManager.dokujiCodes.contains(systemServiceKindDetail)) {
            // �����Z�łȂ����
            if (!isPercentageCode(code)) {
                // �R�[�h�������ĒP�ʐ��������ւ�
                String itemCode = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));
                String sjCodekey = QkanSjServiceCodeManager.createSjServiceCodeKey(sjInsureId, systemServiceKindDetail, itemCode);
                VRMap row = QkanSjServiceCodeManager.getSjServiceCodeByKey(this.dbm , sjCodekey, targetDate);
                if (!row.isEmpty()) {
                    int unit = ACCastUtilities.toInt(row.get("SERVICE_UNIT"), 0);
                    if (unit != 0) {
                        code.put("SERVICE_UNIT", unit);
                    }
                } else {
                    // �u��������̃R�[�h���o�^����Ă��Ȃ��ꍇ
                    // �Z��o���Ȃ��̂�Exception���X���[
                    throw new QkanSjInsurerException(sjInsureId, code, isTukitotyuJushotiTokurei);
                }
            }
            // �R�[�h���̕ی��Ҕԍ���u������
            code.put("INSURER_ID", sjInsureId);
            //�u���������ی��Ҕԍ���Ԃ�
            return sjInsureId;
        }
        
        // �Z��o���Ȃ��̂�Exception���X���[
        throw new QkanSjInsurerException(sjInsureId, code, isTukitotyuJushotiTokurei);
    }
    
    
    // �Ώۓ��ɂ����鑍�����Ƃ̕ی��Ҕԍ����擾
    private String getSjInsurerIdAtDate(Date targetServiceDate) throws Exception {
        // ���p�҂̑Ώۓ��̗v���F�藚������ی��҂��擾����B
        VRMap map = calcurater.getPatientInsureInfoOnTargetDay(targetServiceDate);
        if (map == null) {
            return "";
        }
        String insurerId = ACCastUtilities.toString(map.get("INSURER_ID"));
        // �Ώۓ����_�ŏZ���n����̏ꍇ�́A�{�ݏ��ݕی��Ҕԍ���Ԃ��B
        String jushotiTokureiInsurerId = calcurater.getJushotiTokureiInsurerId(targetServiceDate);
        if (!ACTextUtilities.isNullText(jushotiTokureiInsurerId)) {
            insurerId = jushotiTokureiInsurerId;
        }
        return insurerId;
    }
    
    // �w�肳�ꂽ�R�[�h�������Z�ł��邩�ǂ�����Ԃ�
    private boolean isPercentageCode(Map code) {
        if (ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0) == 3 //�����Z(�n��n���Z)
            || ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0) == 6 //�����Z(�Ώۂɒn��n���Z���܂�)
            || ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0) == 8) { //�������P���Z
            return true;
        }
        return false;
    }

}
