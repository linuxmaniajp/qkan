package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import jp.nichicom.ac.core.ACDBManagerCreatable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * <p>
 * �T�[�r�X�p�l���f�[�^�t�����N���X�Ǘ��p�̃N���X�ł��B
 * </p>
 * QkanValidServiceManager�ł��B
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Masahiko Higuchi
 * @version 1.0 2008/01/11
 * @since version 5.4.1
 */
public class QkanValidServiceManager {

    private static QkanValidServiceManager singleton;

    // �V�X�e�����t
    private Date sysYmd;

    // �v�x�����v���
    public static final Integer YOSHIEN_TO_YOKAIGO = new Integer(1020);
    // �v��쁨�v���
    public static final Integer YOKAIGO_TO_YOKAIGO = new Integer(2020);
    // �v��쁨�v�x��
    public static final Integer YOKAIGO_TO_YOSHIEN = new Integer(2010);
    // �v�x�����v�x��
    public static final Integer YOSHIEN_TO_YOSHIEN = new Integer(1010);
    
    
    private Map<String, AbstractQkanValidServiceGetter> validService = null;
    
    private int[] historyPatterns;
    private int facilityOfferPattern;
    private Integer changeMode;

    /**
     * ��͑Ώۂ̔N��
     * @param sysYmd
     */
    public void setSysYmd(Date sysYmd) {
        this.sysYmd = sysYmd;
        
        // ���̃^�C�~���O�ŃL���b�V����������
        validService = new HashMap<String, AbstractQkanValidServiceGetter>();
    }
    
    /**
     * �v���F�藚��ω��̃p�^�[���o�^
     * @param historyPattern
     */
    public void setHistoryPatterns(int[] historyPatterns) {
        this.historyPatterns = historyPatterns;
    }
    
    /**
     * �{�݌n�T�[�r�X�񋟓��̃p�^�[���o�^
     * @param facilityOfferPattern
     */
    public void setFacilityOfferPattern(int facilityOfferPattern) {
        this.facilityOfferPattern = facilityOfferPattern;
    }
    
    /**
     * �v���x�̕ω��p�^�[��
     * @param changeMode
     */
    public void setChangeMode(Integer changeMode) {
        this.changeMode = changeMode;
    }

    /**
     * �_�~�[�T�[�r�X�R�[�h�����N���X���擾���܂��B
     * 
     * @return
     */
    public static QkanValidServiceManager getInstance() {
        if (singleton == null) {
            singleton = new QkanValidServiceManager();
        }

        return singleton;
    }
    
    
    /**
     * ������ɂ��ׂ��Ȃ̂ɁA������ƂȂ��Ă��Ȃ��T�[�r�X�ł��邩
     * @param service �p�l���f�[�^
     * @return true:���X�g����폜 false:���X�g�ɕێ�
     * @throws Exception
     */
    public boolean checkDeleteService(VRMap service) throws Exception {
        
        String serviceKindDetail = ACCastUtilities.toString(service.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
        String providerId = ACCastUtilities.toString(service.get("PROVIDER_ID"), "");
        
        // ���Ə��ԍ� - �T�[�r�X��ނ��L�[�Ƃ���
        String key = providerId + "-" + serviceKindDetail;
        AbstractQkanValidServiceGetter getter = null;
        
        if (validService.containsKey(key)) {
            getter = validService.get(key);
            
        } else {
            getter = getValidServiceGetter(serviceKindDetail, sysYmd);
            if (getter == null) {
                return false;
            }
            
            // �F�藚���̃p�^�[����ݒ�
            getter.setHistoryPatterns(historyPatterns, facilityOfferPattern);
            validService.put(key, getter);
        }
        
        // ������W�J���s���ׂ��v���ω��łȂ��ꍇ�́A�������L�����Z��
        if (!getter.isValidDataCreateService(changeMode)) {
            return false;
        }
        
        return getter.checkDeleteService(service);
    }
    
    
    /**
     * ����������W�J�����f�[�^���X�g��Ԃ�
     * @return
     * @throws Exception
     */
    public VRList getProRatedList() throws Exception {
        
        VRList list = new VRArrayList();
        
        for (Entry<String, AbstractQkanValidServiceGetter> entry : validService.entrySet()) {
            list.addAll(entry.getValue().getProRatedList());
        }
        
        return list;
    }

    
    
    /**
     * �����V�X�e���T�[�r�X��ރR�[�h�ɉ����ă_�~�[�ϊ��p�̃}�l�[�W���[�𐶐����܂��B
     * 
     * @param serviceTypeCode
     * @param targetDate
     * @return
     * 
     */
    private AbstractQkanValidServiceGetter getValidServiceGetter(String systemServiceCodeKind, Date targetDate) {
        AbstractQkanValidServiceGetter serviceGetter = null;

        StringBuilder sb = new StringBuilder();
        Class<AbstractQkanValidServiceGetter> svClass = null;

        try {
            // �N�x�ɑΉ������N���X�𕶎��񂩂琶������
            sb.append("jp.nichicom.ac.lib.care.claim.servicecode.");
            sb.append("SV_");
            sb.append(systemServiceCodeKind);
            sb.append("_");
            sb.append(QkanCommon.getServiceLowVersion(systemServiceCodeKind,
                    targetDate, ((ACDBManagerCreatable) ACFrame.getInstance()
                            .getFrameEventProcesser()).createDBManager()));
            // �N���X����
            svClass = (Class<AbstractQkanValidServiceGetter>) Class.forName(sb
                    .toString());

            if (svClass != null) {
                serviceGetter = (AbstractQkanValidServiceGetter) svClass
                        .newInstance();
            }

        } catch (ClassNotFoundException e) { // by Class.forName
            // �w�肵�����̂̃N���X���݂��Ȃ������ꍇ
            //e.printStackTrace();
            serviceGetter = null;

        } catch (InstantiationException e) { // by newInstance()
            // �C���X�^���X�쐬�s�̏ꍇ�i�p�����[�^�Ȃ��̃R���X�g���N�^���݂��Ȃ��ꍇ - new Xxxx()�ŃG���[�̏ꍇ�j
            e.printStackTrace();

        } catch (IllegalAccessException e) { // by newInstance()
            // �����͂Ȃ��Ƃ�
            e.printStackTrace();

        } catch (Exception e) {
            // ��O�G���[

        }

        return serviceGetter;
    }
    
    
}
