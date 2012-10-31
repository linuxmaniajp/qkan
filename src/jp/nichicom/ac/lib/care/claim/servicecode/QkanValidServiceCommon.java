package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * 
 * �T�[�r�X��́E�t�����p�̋��ʃ��\�b�h�Q�ł��B
 * 
 * QkanValidServiceCommon�ł��B
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2007/12/19
 * @since version 5.4.1
 */
public class QkanValidServiceCommon{    


    /**
     * �K�؂ȃT�[�r�X����͂��Đ������܂��B
     * 
     * @param addType �������[�h
     * @param dbm
     * @param targetDate �Ώ۔N��
     * @param serviceList ��͑ΏۃT�[�r�X�Q
     * @param patientID ���p��ID
     * @return
     * @throws Exception
     */
    public VRList createValidService(ACDBManager dbm, Date targetDate,
            VRList serviceList, int patientID) throws Exception {
        
        VRList patientInsureInfoHistory = null;
        // �v���F�藚���̎擾
        patientInsureInfoHistory = QkanCommon.getPatientInsureInfoHistory(dbm,
                targetDate, patientID);
        // �������ɕ������𑶍݂��Ȃ��ꍇ�͏����I��
        if (patientInsureInfoHistory.size() <= 1) {
            return serviceList;
        }
        
        // ------------------- ��������ύX -----------------------
        
        int jyotaiCodeBefore = 0;
        boolean isCreate = false;
        //�v���F�藚��
        int historyPatterns[] = new int[patientInsureInfoHistory.size()];
        Integer changeMode = null;
        
        for(int i =0;i<patientInsureInfoHistory.size();i++){
            // �������擾����
            VRMap history = (VRMap)patientInsureInfoHistory.getData(i);
            int jyotaiCode = ACCastUtilities.toInt(history.getData("JOTAI_CODE"), 0);
            
            // �����̕ω���Ԃ��`�F�b�N����B(����͎̂Ă�)
            if(isCreateValidService(jyotaiCodeBefore, jyotaiCode)){
                changeMode = getPatientInsurerChangeMode(jyotaiCodeBefore, jyotaiCode);
                // ��͊J�n
                isCreate = true;
            }
            
            jyotaiCodeBefore = jyotaiCode;
            
            
            // �F����Ԃ�ϊ�
            Date dayStart = ACCastUtilities.toDate(history.getData("INSURE_VALID_START"));
            Date dayEnd = ACCastUtilities.toDate(history.getData("INSURE_VALID_END"));
            
            int start = 0;
            int end = 0;
            historyPatterns[i] = 0;
            
            // �J�n���������ł���΁A�J�n���͔F�藚���J�n��
            if (ACDateUtilities.getDifferenceOnMonth(targetDate, dayStart) == 0){
                start = ACDateUtilities.getDayOfMonth(dayStart);
            } else {
                // ��L�ȊO�͌���
                start = ACDateUtilities.getFirstDayOfMonth(targetDate);
            }
            
            // �I�����������ł���΁A�I������ύX
            if (ACDateUtilities.getDifferenceOnMonth(targetDate, dayEnd) == 0){
                end = ACDateUtilities.getDayOfMonth(dayEnd);
            } else {
                // ��L�ȊO�͌���
                end = ACDateUtilities.getLastDayOfMonth(targetDate);
            }
            
            for (int j = start-1; j < end; j++) {
                historyPatterns[i] += (1 << j);
            }
        }
        
        // ������Ԃŉ�͑ΏۊO�͏I��
        if(!isCreate) return serviceList;
        
        
        
        // �Q�Ɗ֌W�̂Ȃ��f�[�^���쐬����
        VRList cloneServiceList = deepCopyVRList(serviceList);
        // �T�[�r�X����U�\�[�g����
        Collections.sort(cloneServiceList, new DateComparator());
        
        //�{�݌n�̃T�[�r�X��񋟂�����
        int facilityOfferPattern = 0;
        
        //�{�݌n�̃T�[�r�X��񋟂�������T���A�o���Ă���
        for (int i = 0; i < cloneServiceList.size(); i++) {
            
            VRMap service = (VRMap)cloneServiceList.get(i);
            
            //�{�݌n�̃T�[�r�X�񋟓��ł���ꍇ
            if (CareServiceCommon.isFacility(service)
                    || CareServiceCommon.isLifeCare(service)
                    || CareServiceCommon.isShortStay(service)) {
                
                Date serviceDate = ACCastUtilities.toDate(service.get("SERVICE_DATE"));
                int day = ACDateUtilities.getDayOfMonth(serviceDate) - 1;
                facilityOfferPattern |= (1 << day);
            }
            
        }
        
        
        // �Ώ۔N���̐ݒ�
        QkanValidServiceManager.getInstance().setSysYmd(targetDate);
        // �v���x�ύX�̃p�^�[���o�^
        QkanValidServiceManager.getInstance().setHistoryPatterns(historyPatterns);
        // �{�݌n�T�[�r�X�̒񋟓��ݒ�
        QkanValidServiceManager.getInstance().setFacilityOfferPattern(facilityOfferPattern);
        // �v���x�ω��p�^�[��
        QkanValidServiceManager.getInstance().setChangeMode(changeMode);
        
        // �񋟃T�[�r�X�����[�v
        for (int i = 0; i < cloneServiceList.size(); i++) {
            
            VRMap service = (VRMap)cloneServiceList.get(i);
            
            // ���X�g����폜���ׂ����`�F�b�N
            if (QkanValidServiceManager.getInstance().checkDeleteService(service)) {
                // �폜�Ώۂł���΁A���X�g���甲��
                cloneServiceList.remove(i);
                i--;
            }
        }
        
        
        // ��͌�̓�����f�[�^�𓊓�
        cloneServiceList.addAll(QkanValidServiceManager.getInstance().getProRatedList());
        
        
        return cloneServiceList;
        
    }
    
    
 
    /**
     * �f�B�[�v�R�s�[���s���܂��B
     * �f�[�^�Q����VRMap�AVRList�����݂���ꍇ�́A�����ăR�s�[���܂��B
     * 
     * @param �R�s�[�Ώۂ̃��R�[�h�Q
     * @return
     * @throws Exception
     */
    public static VRList deepCopyVRList(VRList copyTarget) throws Exception{
        
        VRList deepCopyList = new VRArrayList();
        
        for(int i=0; i < copyTarget.size();i++){
            Object obj = copyTarget.getData(i);
            // �C���X�^���X�ɂ�鏈������
            if(obj instanceof VRMap){
                // VRList �� VRMap �̏ꍇ
                // �f�B�[�v�R�s�[�̃}�b�v�ł��g�p����
                deepCopyList.add(deepCopyVRMap((VRMap)obj));
            }else if(obj instanceof VRList){
                // VRList �� VRLst �̏ꍇ
                // �ċA�������s��
                deepCopyList.add(deepCopyVRList((VRList)obj));
            }else{
                // �����ύX�����Ŋi�[����
                deepCopyList.add(obj);
                
            }
        }        
        return deepCopyList;
    }
    
    /**
     * �f�B�[�v�R�s�[���s���܂��B
     * �f�[�^�Q����VRMap�AVRList�����݂���ꍇ�́A�����ăR�s�[���܂��B
     * 
     * @param �R�s�[�Ώۂ̃��R�[�h
     * @return
     * @throws Exception
     */
    public static VRMap deepCopyVRMap(VRMap copyTarget) throws Exception{
        VRMap deepCopyResult = new VRHashMap();
        
        Set setKey = copyTarget.keySet();
        Iterator it = setKey.iterator();
        
        while(it.hasNext()){
            // �L�[�����o��
            String key = ACCastUtilities.toString(it.next());
            Object obj = copyTarget.get(key);
            // �C���X�^���X�ɂ�鏈������
            if(obj instanceof VRList){
                // VRList�̉�͔�
                deepCopyResult.setData(key,deepCopyVRList((VRList)obj));
            }else if (obj instanceof VRMap){
                // �ċA����
                deepCopyResult.setData(key,deepCopyVRMap((VRMap)obj));
            }else{
                // �R�s�[����
                deepCopyResult.setData(key,copyTarget.get(key));
            }
        }
        
        return deepCopyResult;
        
    }
    
    /**
     * �v���F�藚���̕ω���Ԃ��擾���܂��B
     * 
     * @param beforeHistoryCode
     * @param afterHistoryCode
     * @return
     * @throws Exception
     */
    public Integer getPatientInsurerChangeMode(int beforeHistoryCode,
            int afterHistoryCode) throws Exception {
        // ���݂��Ȃ��R�[�h�̓��^�[��
        if(beforeHistoryCode == 0 || afterHistoryCode==0){
            return new Integer(0);
        }

        // 2�����
        switch (beforeHistoryCode) {
        case 12: // �v�x���P
        case 13: // �v�x���Q

            switch (afterHistoryCode) {
            case 12: // �v�x���P
            case 13: // �v�x���Q
                // �v�x�����v�x��
                return QkanValidServiceManager.YOSHIEN_TO_YOSHIEN;
                
            case 11:// �o�ߓI�v���
            case 21:// �v���
            case 22:
            case 23:
            case 24:
            case 25:
                // �v�x�����v���
                return QkanValidServiceManager.YOSHIEN_TO_YOKAIGO;
                
            default:
                return new Integer(0);
            }
            
        case 11:// �o�ߓI�v���
        case 21:// �v���
        case 22:
        case 23:
        case 24:
        case 25:

            switch (afterHistoryCode) {
            case 12: // �v�x���P
            case 13: // �v�x���Q
                // �v��쁨�v�x��
                return QkanValidServiceManager.YOKAIGO_TO_YOSHIEN;

            case 11:// �o�ߓI�v���
            case 21:// �v���
            case 22:
            case 23:
            case 24:
            case 25:
                // �v��쁨�v���
                return QkanValidServiceManager.YOKAIGO_TO_YOKAIGO;
                
            default:

                return new Integer(0);
            }

        default:
            return new Integer(0);
            
        }

    }
    /**
     * ��z��V�T�[�r�X�̓����ϊ����\�ł��邩�B
     * 
     * @return
     * @throws Exception
     */
    public boolean isCreateValidService(int beforeHistoryCode ,int afterHistoryCode) throws Exception{
        // ��͌�̗������擾
        Integer result = getPatientInsurerChangeMode(beforeHistoryCode,afterHistoryCode);
        
        // �v���˗v�x��
        if(QkanValidServiceManager.YOKAIGO_TO_YOSHIEN.equals(result)){
            return true;
        }
        // �v�x���˗v���
        if(QkanValidServiceManager.YOSHIEN_TO_YOKAIGO.equals(result)){
            return true;
        }
        
        return false;
    }
    
    
    /**
     * ���t�Ŏ��т��\�[�g����B
     */
    private class DateComparator implements java.util.Comparator<Map<String, Object>> {
        public int compare(Map<String, Object> object1, Map<String, Object> object2) {
            // ���t�ŕ��ёւ���N���X
            Date date1 = ACCastUtilities.toDate(object1.get("SERVICE_DATE"), null);
            Date date2 = ACCastUtilities.toDate(object2.get("SERVICE_DATE"), null);
            if(date1==null){
                if(date2==null){
                    return 0;
                }
                return -1;
            }else if(date2==null){
                return 1;
            }
            return date1.compareTo(date2);
        }
    }
    

}
