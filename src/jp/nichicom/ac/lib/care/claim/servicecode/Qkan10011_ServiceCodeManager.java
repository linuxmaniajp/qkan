package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.core.ACDBManagerCreatable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * �T�[�r�X�R�[�h�������W�b�N
 */
public class Qkan10011_ServiceCodeManager {
                                           
    private static Qkan10011_ServiceCodeManager singleton;

    public static Qkan10011_ServiceCodeManager getInstance() {
        if (singleton == null) {
            singleton = new Qkan10011_ServiceCodeManager();
        }

        return singleton;
    }

    private int serviceCodeCacheLimit = 1000;
    private HashMap<String, VRList> serviceCodeCache = new HashMap<String, VRList>();
    private HashMap<String, Object> unitGetterCache = new HashMap<String, Object>();
    private ACDBManager dbManager = null;

    /**
     * ACDBManager��ԋp���܂��B
     * 
     * @return dbManager
     */
    public ACDBManager getDBManager() throws Exception {
        if (dbManager == null) {
            dbManager = ((ACDBManagerCreatable) ACFrame.getInstance()
                    .getFrameEventProcesser()).createDBManager();
        }
        return dbManager;
    }

    public Qkan10011_ServiceUnitGetter getService(String serviceCodeKind,
            Date targetDate) {

        try {
            Object obj = unitGetterCache.get(serviceCodeKind);
            if (obj == null) {
                obj = getUnitGetter(Integer.parseInt(serviceCodeKind),
                        targetDate);
            }
            return (Qkan10011_ServiceUnitGetter) obj;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    protected Qkan10011_ServiceCodeManager() {
    }

    public String getServiceName() {
        return "";
    }

    public String getServiceName(String serviceCodeKind, Date targetDate) {
        try {
            Object obj = unitGetterCache.get(serviceCodeKind);
            if (obj == null) {
                obj = getUnitGetter(Integer.parseInt(serviceCodeKind),
                        targetDate);
            }
            return ((Qkan10011_ServiceUnitGetter) obj).getServiceName();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public String getServiceCodeKind() {
        return "";
    }

    public String getServiceCodeKind(String serviceCodeKind, Date targetDate) {
        try {
            Object obj = unitGetterCache.get(serviceCodeKind);
            if (obj == null) {

                obj = getUnitGetter(Integer.parseInt(serviceCodeKind),
                        targetDate);
            }
            return ((Qkan10011_ServiceUnitGetter) obj).getServiceCodeKind();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public String getSystemServiceKindDetail() {
        return "";

    }

    public String getSystemServiceKindDetail(String serviceCodeKind,
            Date targetDate) {
        try {
            Object obj = unitGetterCache.get(serviceCodeKind);
            if (obj == null) {
                obj = getUnitGetter(Integer.parseInt(serviceCodeKind),
                        targetDate);
            }
            return ((Qkan10011_ServiceUnitGetter) obj)
                    .getSystemServiceKindDetail();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    protected ArrayList getSystemServiceCodeItem(Map map) {
        return new ArrayList();
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            String serviceCodeKind, HashMap<String, String> map, Date targetDate) {
        try {
            Object obj = unitGetterCache.get(serviceCodeKind);
            if (obj == null) {
                obj = getUnitGetter(Integer.parseInt(serviceCodeKind),
                        targetDate);
            }
            return ((Qkan10011_ServiceUnitGetter) obj)
                    .getSystemServiceCodeItem(map);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<HashMap<String, String>>();
    }

    /**
     * �T�[�r�X�R�[�h�W����Ԃ��܂��B
     * 
     * @param systemServiceKindDetail
     *            �T�[�r�X��ރR�[�h
     * @param map
     *            �Z�荀��
     * @param targetDate
     *            �Ώ۔N���i�L�����Ԃ̃L�[�j
     * @param dbm
     *            DB�}�l�[�W��
     * @return �T�[�r�X�R�[�h�W��
     */
    public ArrayList<VRMap> getServiceCode(String systemServiceKindDetail,
            HashMap<String, String> map, Date targetDate, ACDBManager dbm) {
        try {
            Qkan10011_ServiceUnitGetter ug = getUnitGetter(
                    Integer.parseInt(systemServiceKindDetail), targetDate);
            if (ug == null) {
                return new ArrayList<VRMap>();
            }
            ug.setSysYmd(targetDate);
            return ug.getServiceCode(map, dbm);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<VRMap>();
        }
    }

    /**
     * �T�[�r�X�R�[�h�������W�b�N�N���X���擾���܂��B
     * 
     * @param serviceTypeCode
     * @param targetDate
     * @return
     */
    @SuppressWarnings("unchecked")
    private Qkan10011_ServiceUnitGetter getUnitGetter(int serviceTypeCode,
            Date targetDate) {

        Qkan10011_ServiceUnitGetter unitGetter = null;
        StringBuilder sb = new StringBuilder();
        String serviceTypeCodeVal = "";
        Class<Qkan10011_ServiceUnitGetter> serviceClass = null;

        try {
            serviceTypeCodeVal = ACCastUtilities.toString(serviceTypeCode);

            // �N���X�����\�z����
            sb.append("jp.nichicom.ac.lib.care.claim.servicecode.");
            sb.append("SC_");
            sb.append(serviceTypeCodeVal);
            sb.append("_");
            sb.append(QkanCommon.getServiceLowVersion(serviceTypeCodeVal,
                    targetDate, getDBManager()));
            // �N���X����
            serviceClass = (Class<Qkan10011_ServiceUnitGetter>) Class
                    .forName(sb.toString());

            if (serviceClass != null) {
                unitGetter = (Qkan10011_ServiceUnitGetter) serviceClass
                        .newInstance();
            }

        } catch (ClassNotFoundException e) { // by Class.forName
            // �w�肵�����̂̃N���X���݂��Ȃ������ꍇ
            e.printStackTrace();

        } catch (InstantiationException e) { // by newInstance()
            // �C���X�^���X�쐬�s�̏ꍇ�i�p�����[�^�Ȃ��̃R���X�g���N�^���݂��Ȃ��ꍇ - new Xxxx()�ŃG���[�̏ꍇ�j
            e.printStackTrace();

        } catch (IllegalAccessException e) { // by newInstance()
            // �����͂Ȃ��Ƃ�
            e.printStackTrace();

        } catch (Exception e) {
            // ��O�G���[

        }

        return unitGetter;
    }

    /**
     * �T�[�r�X�R�[�h�̃L���b�V�����N���A���܂��B
     */
    public void clearServiceCodeCache() {
        getServiceCodeCache().clear();
    }

    /**
     * �T�[�r�X�R�[�h�̃L���b�V���}�b�v ��Ԃ��܂��B
     * 
     * @return �T�[�r�X�R�[�h�̃L���b�V���}�b�v
     */
    public HashMap<String, VRList> getServiceCodeCache() {
        return serviceCodeCache;
    }

    /**
     * �T�[�r�X�R�[�h�̃L���b�V���}�b�v ��ݒ肵�܂��B
     * 
     * @param serviceCodeCache
     *            �T�[�r�X�R�[�h�̃L���b�V���}�b�v
     */
    protected void setServiceCodeCache(HashMap<String, VRList> serviceCodeCache) {
        this.serviceCodeCache = serviceCodeCache;
    }

    /**
     * �T�[�r�X�R�[�h�̃L���b�V�����E�� ��Ԃ��܂��B
     * 
     * @return �T�[�r�X�R�[�h�̃L���b�V�����E��
     */
    public int getServiceCodeCacheLimit() {
        return serviceCodeCacheLimit;
    }

    /**
     * �T�[�r�X�R�[�h�̃L���b�V�����E�� ��ݒ肵�܂��B
     * 
     * @param serviceCodeCacheLimit
     *            �T�[�r�X�R�[�h�̃L���b�V�����E��
     */
    public void setServiceCodeCacheLimit(int serviceCodeCacheLimit) {
        this.serviceCodeCacheLimit = serviceCodeCacheLimit;
    }
}
