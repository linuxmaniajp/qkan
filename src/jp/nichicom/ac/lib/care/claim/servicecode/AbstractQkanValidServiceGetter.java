package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * 
 * AbstractQkanValidServiceGetter�ł��B
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2007/12/19
 * @since version 5.4.1
 */
public abstract class AbstractQkanValidServiceGetter {
    
    private static String HISTORY_PATTERN = "__HISTORY_PATTERN__";
    private static String OFFER_PATTERN = "__OFFER_PATTERN__";
    private static String OFFER_BIND_PATH = "__OFFER_BIND_PATH__";
    
    private int[] historyPatterns;
    private int facilityOfferPattern;
    
    public void setHistoryPatterns(int[] historyPatterns, int facilityOfferPattern) {
        this.historyPatterns = historyPatterns;
        this.facilityOfferPattern = facilityOfferPattern;
    }
    
    protected int getHistoryPattern(VRMap service) throws Exception {
        
        int target = getTarget(service);
        
        for (int i = 0; i < historyPatterns.length; i++) {
            // �p�^�[���Ƀ}�b�`������ԋp
            if ((historyPatterns[i] & target) == target) {
                return historyPatterns[i];
            }
        }
        
        // ������Ȃ���΁A�F����ԊO�ɒu���ꂽ�T�[�r�X
        return 0;
    }
    
    protected VRMap createBaseMap(VRMap service, String hiwariBindPath, String offerBindPath) throws Exception {
        
        int history = getHistoryPattern(service);
        // �F����ԊO�ɒu���ꂽ�T�[�r�X�ł���Ε��u
        if (history == 0) {
            return null;
        }
        
        VRMap panelData = QkanValidServiceCommon.deepCopyVRMap(service);
        // ������`�F�b�N��ON
        VRBindPathParser.set(hiwariBindPath, panelData, new Integer(2));
        // �񋟓��`�F�b�N��OFF
        VRBindPathParser.set(offerBindPath, panelData, new Integer(1));
        // ���p�ҕ��S�z��0��
        VRBindPathParser.set("REGULATION_RATE", panelData, new Integer(0));
        // �Y���̒񋟓������Ă���
        VRBindPathParser.set(HISTORY_PATTERN, panelData, new Integer(history));
        // ���񋟓���͗p
        VRBindPathParser.set(OFFER_PATTERN, panelData, new Integer(0));
        // �񋟓��`�F�b�N�̃o�C���h�p�X���o���Ă���
        VRBindPathParser.set(OFFER_BIND_PATH, panelData, offerBindPath);
        
        return panelData;
    }
    
    
    protected List<VRMap> createProRatedList(VRMap panelData) throws Exception {
        
        List<VRMap> list = new ArrayList<VRMap>();
        
        if (panelData == null) {
            return list;
        }
        
        
        int history = ACCastUtilities.toInt(panelData.get(HISTORY_PATTERN));
        int offer = ACCastUtilities.toInt(panelData.get(OFFER_PATTERN));
        String offerBindPath = ACCastUtilities.toString(panelData.get(OFFER_BIND_PATH));
        
        panelData.remove(HISTORY_PATTERN);
        panelData.remove(OFFER_PATTERN);
        panelData.remove(OFFER_BIND_PATH);
        
        
        if (history == 0) {
            return list;
        }
        
        for (int i = 0; i < 31; i++) {
            
            // �{�݌n�T�[�r�X��񋟂��Ă�����A�����W�J���L�����Z��
            if (((facilityOfferPattern >> i) & 1) == 1) {
                continue;
            } 
            
            // ������W�J�͈͓��ł��邩�m�F
            if (((history >> i) & 1) != 1) {
                continue;
            }
            
            // �_�~�[�f�[�^���K�v�ȏꍇ������f�[�^�p�̃R�s�[���擾
            VRMap service = QkanValidServiceCommon.deepCopyVRMap(panelData);
            
            // ���t���Y�����ɕύX
            Date serviceDate = ACCastUtilities.toDate(service.get("SERVICE_DATE"));
            VRBindPathParser.set("SERVICE_DATE", service, ACDateUtilities.setDayOfMonth(serviceDate, i + 1));
            
            // ������ł͖�����ԂŃp�l�����z�u����Ă����ꍇ�́ADUMMY�t���O��t���Ȃ�(�񋟓�����)
            // �v���O�������Ő��������ꍇ�́ADUMMY�t���O��t����
            if (((offer >> i) & 1) != 1) {
                VRBindPathParser.set("DUMMY", service, new Boolean(true));
            } else {
                //�񋟓��Ƃ��Ĉ����̂ŁA�񋟓��`�F�b�N��ON�ɂ���
                VRBindPathParser.set(offerBindPath, service, new Integer(2));
            }
            list.add(service);
        }
        
        return list;
    }
    
    
    protected void deleteHistory(VRMap dummy, VRMap service) throws Exception {
        
        int history = ACCastUtilities.toInt(dummy.get(HISTORY_PATTERN), 0);
        int target = getTarget(service);
        
        // �w��ʒu�̃t���O���m�F
        if ((history & target) == target) {
            history ^= target;
        }
        
        VRBindPathParser.set(HISTORY_PATTERN, dummy, new Integer(history));
        
    }
    
    protected void deleteFacilityOffer(VRMap service) throws Exception {
        int target = getTarget(service);
        // �w��ʒu�̃t���O��OFF��
        if ((facilityOfferPattern  & target) == target) {
            facilityOfferPattern ^= target;
        }
    }
    
    
    protected void addOffer(VRMap dummy, VRMap service) throws Exception {
        
        int offer = ACCastUtilities.toInt(dummy.get(OFFER_PATTERN), 0);
        int target = getTarget(service);
        
        VRBindPathParser.set(OFFER_PATTERN, dummy, new Integer(offer | target));
        
    }
    
    private int getTarget(VRMap service) throws Exception {
        Date serviceDate = ACCastUtilities.toDate(service.get("SERVICE_DATE"));
        int targetDay = ACDateUtilities.getDayOfMonth(serviceDate) - 1;
        return (1 << targetDay);
    }
    
    // �����莩���W�J�̑ΏۂƂ��邩
    protected boolean isValidDataCreateService(Integer changeMode) {
        return true;
    }
    
    abstract protected boolean checkDeleteService(VRMap service) throws Exception;
    
    abstract protected List<VRMap> getProRatedList() throws Exception;
    
}
