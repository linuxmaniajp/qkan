package jp.nichicom.ac.lib.care.claim.servicecode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �T�[�r�X�R�[�h�擾�N���X���`
 */
// public class Qkan10011_ServiceUnitGetter {
public abstract class Qkan10011_ServiceUnitGetter {
    private Date sysYmd; // �V�X�e�����t

    public final String[] CODE_CHAR = { "0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
            "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
            "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
            "��", "��", "��", "��", "��", "��", "��", "��", "��" };

    // ����KEY
    public static final String YOKAIGODO = "1";
    public static final String TOKUCHI_KASAN = "2";
    public static final String CHUSANKANCHIIKI_KASAN = "13";
    // [ID:0000682] 2012/01 start ���E���������P���Z�̒ǉ����� TODO
    public static final String SYOGUKAIZEN_KASAN = "17";
    // [ID:0000682] 2012/01 end

 // 2016/8/23 [Yoichiro Kamei] add - begin �������ƑΉ�
    public static  final String SJ_HOKENSHA_NO_BIND_PATH = "500";
    public static  final int SJ_SERVICE_CODE_BIND_PATH_ST = 501;
    public static  final int SJ_SERVICE_CODE_BIND_PATH_ED = 510;
 // 2016/8/23 [Yoichiro Kamei] add - end
    
    // �T�[�r�X�R�[�h�������ڒl �����l
    public static final String DEFAULT_CHAR = "1";

    // �H��E���Z������T�[�r�X�R�[�h
    public static final String SERVICE_CODE_SHOKUHI = "Y100";
    public static final String SERVICE_CODE_NORMAL_ROOM = "Y210";
    public static final String SERVICE_CODE_TASHO_ROOM = "Y220";
    public static final String SERVICE_CODE_UNIT_ROOM = "Y201";
    public static final String SERVICE_CODE_UNIT_SEMI_ROOM = "Y202";
    public static final String SERVICE_CODE_NEW_TASHO_ROOM = "Y220";

    // �T�[�r�X���̎擾
    abstract public String getServiceName();

    // �T�[�r�X��ރR�[�h(2��)�擾
    abstract public String getServiceCodeKind();

    // �V�X�e���T�[�r�X��ރR�[�h(5��)�擾
    abstract public String getSystemServiceKindDetail();

    // �V�X�e���T�[�r�X���ڃR�[�h�擾
    abstract protected ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map);

    // �V�X�e�����t�ݒ�
    public void setSysYmd(Date sysYmd) {
        this.sysYmd = sysYmd;
    }

    // �V�X�e�����t�擾
    public Date getSysYmd() {
        return sysYmd;
    }

    /**
     * map����key��value���擾�Aint�^�̒l�Ƃ��ĕԂ��B key�����݂��Ȃ��ꍇ�A0��Ԃ��B
     * 
     * @param map
     * @param key
     * @return
     */
    protected int getIntValue(Map<String, String> map, String key) {
        if (map.get(key) != null) {
            return Integer.parseInt(String.valueOf(map.get(key)));
        } else {
            return 1;
        }
    }

    /**
     * map����key��value���擾�Aint�^�̒l�Ƃ��ĕԂ��B key�����݂��Ȃ��ꍇ�A�w�肳�ꂽdefaultValue��Ԃ��B
     * 
     * @param map
     * @param key
     * @param defaultValue
     * @return
     */
    protected int getIntValue(Map<String, String> map, String key,
            int defaultValue) {
        if (map.get(key) != null) {
            return Integer.parseInt(String.valueOf(map.get(key)));
        } else {
            return defaultValue;
        }
    }

    /**
     * �i�l�̔��]���K�v�Ȃ��Ȃ������ߍ���͎g�p���Ȃ��j map����key��value���擾�Aint�^�̒l�Ƃ��ĕԂ��B ���j�b�g�P�A�̐�����p�B
     * ���͂́u1:�������A2:�����v�A�o�͂́u1:�����A2:�������v�ł���_�ɒ��ӁB #��ʍ��ڂƁA�T�[�r�X�R�[�h�\�Ƃł͋t�ɂȂ��Ă��邽�߁B
     * 
     * @param map
     * @param keyOfUnitCare ���j�b�g�P�A����(1:������, 2:����)��KEY
     * @param isUnit false:�]���^, true:���j�b�g�^
     * @return ���j�b�g�P�A������(0:�֌W�Ȃ�/�]���^, 1:����, 2:������)
     */
    @Deprecated
    protected int getIntValueUnitCareSeibi(Map<String, String> map,
            String keyOfUnitCare, boolean isUnit) {
        return getIntValue(map, keyOfUnitCare, 1);
    }

    /**
     * �v���x�R�[�h���T�[�r�X�R�[�h�������W�b�N���̗v���x�R�[�h�֕ϊ�
     * 
     * @param yokaigodo
     * @return
     */
    protected int convertYokaigodo(int yokaigodo) {
        int systemYokaigodo = 0;

        switch (yokaigodo) {
        case 1: // ����
            systemYokaigodo = 1;
            break;
            
// 2016/7/5 [Yoichiro Kamei] add - begin �������ƑΉ�
        case 6: // ���ƑΏێ�
            systemYokaigodo = 10;
            break;
// 2016/7/5 [Yoichiro Kamei] add - end
            
        case 11: // �o�ߓI�v���
            systemYokaigodo = 2;
            break;

        case 12: // �v�x���P
            systemYokaigodo = 3;
            break;

        case 13: // �v�x���Q
            systemYokaigodo = 4;
            break;

        case 21: // �v���x�P
            systemYokaigodo = 5;
            break;

        case 22: // �v���x�Q
            systemYokaigodo = 6;
            break;

        case 23: // �v���x�R
            systemYokaigodo = 7;
            break;

        case 24: // �v���x�S
            systemYokaigodo = 8;
            break;

        case 25: // �v���x�T
            systemYokaigodo = 9;
            break;
        }

        return systemYokaigodo;
    }

    /**
     * SYSTEM_SERVICE_CODE_ITEM�i�[�p�̃��X�g�ɒl��ǉ�����
     * 
     * @param sysSvcCdItems
     * @param sysSvcCdItem
     * @return
     */
    protected boolean putSystemServiceCodeItem(
            ArrayList<HashMap<String, String>> sysSvcCdItems,
            String sysSvcCdItem) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("SYSTEM_SERVICE_KIND_DETAIL", getSystemServiceKindDetail());
        map.put("SYSTEM_SERVICE_CODE_ITEM", sysSvcCdItem);
        sysSvcCdItems.add(map);
        return true;
    }

// 2016/8/23 [Yoichiro Kamei] add - begin �������ƑΉ�
    /**
     * SYSTEM_SERVICE_CODE_ITEM�i�[�p�̃��X�g�ɒl��ǉ�����i�������Ƃ̓Ǝ��藦�E�Ǝ���z�Ɏg�p�j
     * 
     * @param sysSvcCdItems �V�X�e���T�[�r�X���ڃR�[�h���i�[���邽�߂̃}�b�v
     * @param codes �T�[�r�X�ɑI�����ꂽ�R�[�h
     */
    protected void putSogoSystemServiceCodeItems(
            ArrayList<HashMap<String, String>> sysSvcCdItems,
            Map codes) {
        for (int key = SJ_SERVICE_CODE_BIND_PATH_ST; key <=SJ_SERVICE_CODE_BIND_PATH_ED; key++) {
            String value = ACCastUtilities.toString(codes.get(String.valueOf(key)), "");
            if ("".equals(value)) {
                break;
            }
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("SYSTEM_SERVICE_KIND_DETAIL", getSystemServiceKindDetail());
            map.put("SYSTEM_SERVICE_CODE_ITEM", value);
            sysSvcCdItems.add(map);
        }
    }
// 2016/8/23 [Yoichiro Kamei] add - end
    
    /**
     * SYSTEM_SERVICE_CODE_ITEM����T�[�r�X�R�[�h���擾����
     * 
     * @param map
     * @param dbm
     * @return
     */
    public ArrayList<VRMap> getServiceCode(Map<String, String> map,
            ACDBManager dbm) {
        ArrayList<VRMap> serviceCode = new ArrayList<VRMap>(); // �T�[�r�X�R�[�h�i�[�p
        ArrayList<HashMap<String, String>> systemServiceCodeItemList = getSystemServiceCodeItem(map); // �Ǝ��R�[�h�擾

        try {
            VRList data = new VRArrayList();

            // sysYMD
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            String sysYmdString = formatter.format(sysYmd);

            int limit = Qkan10011_ServiceCodeManager.getInstance()
                    .getServiceCodeCacheLimit();
            Map<String, VRList> cache = Qkan10011_ServiceCodeManager
                    .getInstance().getServiceCodeCache();
            for (int i = 0; i < systemServiceCodeItemList.size(); i++) {
                HashMap<String, String> systemServiceCodeMap = systemServiceCodeItemList
                        .get(i);
                String systemServiceCodeItem = systemServiceCodeMap.get(
                        "SYSTEM_SERVICE_CODE_ITEM").toString();
                String systemServiceCodeDetail = systemServiceCodeMap.get(
                        "SYSTEM_SERVICE_KIND_DETAIL").toString();
                
             // 2016/8/23 [Yoichiro Kamei] add - begin �������ƑΉ�
                if (QkanSjServiceCodeManager.teiritsuTeigakuCodes.contains(systemServiceCodeDetail)) {
                    VRMap ret = QkanSjServiceCodeManager.getSjServiceCodeByKey(dbm, systemServiceCodeItem, sysYmd);
                    if (!ret.isEmpty()) {
                        serviceCode.add(ret);
                        continue;
                    }
                }
             // 2016/8/23 [Yoichiro Kamei] add - end
                
                // String serviceValidStart =
                // systemServiceCodeMap.get("SERVICE_VALID_START").toString();

                // �u�Ώ۔N��+SYSTEM_SERVICE_CODE_ITEM�v���L�[�ɃL���b�V������T���B
                // String cacheKey = sysYmdString + systemServiceCodeItem;
                String cacheKey = systemServiceCodeItem + "-"
                        + systemServiceCodeDetail + "-" + sysYmdString;
                Object cacheVal = cache.get(cacheKey);
                if (cacheVal == null) {

                    // DB����f�[�^���擾
                    // ====================================================================
                    StringBuilder sb = new StringBuilder();
                    sb.append(" SELECT");
                    sb.append(" SYSTEM_SERVICE_KIND_DETAIL");
                    sb.append(",SYSTEM_SERVICE_CODE_ITEM");
                    sb.append(",SERVICE_VALID_START");
                    sb.append(",SERVICE_VALID_END");
                    sb.append(",SERVICE_CODE_KIND");
                    sb.append(",SERVICE_CODE_ITEM");
                    sb.append(",SERVICE_NAME");
                    sb.append(",SERVICE_UNIT");
                    sb.append(",LIMIT_AMOUNT_OBJECT");
                    sb.append(",SERVICE_ADD_FLAG");
                    sb.append(",TOTAL_GROUPING_TYPE");
                    sb.append(",SERVICE_MAIN_FLAG");
                    sb.append(",ROOM_TYPE");
                    sb.append(",SERVICE_ADD_TYPE");
                    sb.append(",SERVICE_STAFF_UNIT");
                    sb.append(",SUMMARY_FLAG");
                    sb.append(",SUMMARY_MEMO");
                    sb.append(",CLASS_TYPE");
                    sb.append(",CODE_ID");
                    sb.append(",EDITABLE_FLAG");
                    sb.append(",LAST_TIME");
                    sb.append(" FROM");
                    sb.append(" M_SERVICE_CODE");
                    sb.append(" WHERE");
                    sb.append(" SYSTEM_SERVICE_KIND_DETAIL="
                            + getSystemServiceKindDetail());
                    sb.append(" AND SYSTEM_SERVICE_CODE_ITEM='"
                            + systemServiceCodeItem + "'");
                    sb.append(" AND SERVICE_VALID_START<='" + sysYmdString
                            + "'");
                    sb.append(" AND SERVICE_VALID_END>='" + sysYmdString + "'");
                    data = dbm.executeQuery(sb.toString());

                    if (cache.size() > limit) {
                        // �L���b�V�����E�𒴂����炷�ׂăN���A�i��ʌ����΍�j
                        cache.clear();
                    }
                    // �L���b�V���Ɋi�[
                    cache.put(cacheKey, data);
                } else {
                    // �L���b�V�������l���ė��p
                    data = (VRList) cacheVal;
                }
                System.out.print(systemServiceCodeItem + " = ");
                if ((data != null) && (!data.isEmpty())) {
                    VRMap code = (VRMap) data.getData(0);
                    System.out.print(String.valueOf(code
                            .getData("SERVICE_CODE_KIND")));
                    System.out.print(" " + code.getData("SERVICE_CODE_ITEM"));
                    System.out.print(" " + code.getData("SERVICE_NAME"));
                    System.out.print(" " + code.getData("SERVICE_UNIT"));
                    switch (ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"),
                            0)) {
                    case 1:
                        System.out.print("�P��");
                        break;
                    case 2:
                        System.out.print("�P�ʉ��Z");
                        break;
                    case 3:
                        System.out.print("%���Z");
                        break;
                    case 4:
                        System.out.print("�P�ʌ��Z");
                        break;
                    case 5:
                        System.out.print("%���Z");
                        break;
                    case 8:
                        System.out.print("%���Z");
                        break;
                    case 9:
                        System.out.print("�~");
                        break;
                    default:
                        System.out.print("�P��");
                        break;
                    }
                    System.out.print(" �� ");

                }
                System.out.println(data);
                if (data.getDataSize() > 0) {
                    // 2016/8/23 [Yoichiro Kamei] mod - begin �������ƑΉ�
                    //serviceCode.add((VRMap) data.getData(0));
                    VRMap code = (VRMap) data.getData(0);
                    // �Ǝ��̏ꍇ
                    if (QkanSjServiceCodeManager.dokujiCodes.contains(systemServiceCodeDetail)) {
                        String insurerId = map.get(SJ_HOKENSHA_NO_BIND_PATH);
                        // �ی��Ҕԍ����Z�b�g
                        code.put("INSURER_ID", insurerId);
                        // �㏑���Ώۂ������Z�łȂ���΁A�P�ʐ����㏑��
                        if (!(ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0) == 3 //�����Z(�n��n���Z)
                                || ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0) == 6 //�����Z(�Ώۂɒn��n���Z���܂�)
                                || ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0) == 8 //�������P���Z
                            )) {
                            String itemCode = ACCastUtilities.toString(code.getData("SERVICE_CODE_ITEM"));
                            String sjKey = QkanSjServiceCodeManager.createSjServiceCodeKey(insurerId, systemServiceCodeDetail, itemCode);
                            VRMap ret = QkanSjServiceCodeManager.getSjServiceCodeByKey(dbm, sjKey, sysYmd);
                            int unit = ACCastUtilities.toInt(ret.get("SERVICE_UNIT"), 0);
                            if (unit != 0) {
                                code.put("SERVICE_UNIT", unit);
                            }
                        }
                    }
                    serviceCode.add(code);
                    // 2016/8/23 [Yoichiro Kamei] mod - end
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("-----------------------------");

        return serviceCode;
    }

    public static String getSystemServiceCodeOfRoom(int byoshitsu) {
        switch (byoshitsu) {
        case 1:
            // �]���^��
            return SERVICE_CODE_NORMAL_ROOM;
        case 2:
            // ������
            return SERVICE_CODE_TASHO_ROOM;
        case 3:
            // ���j�b�g�^��
            return SERVICE_CODE_UNIT_ROOM;
        case 4:
            // ���j�b�g�^����
            return SERVICE_CODE_UNIT_SEMI_ROOM;
        case 5:
            // �������i�V�j
            return SERVICE_CODE_NEW_TASHO_ROOM;
        }
        return null;
    }

    public static int convertByoshitsuKbn(int byoshitsu, boolean unitRoom) {
        if (unitRoom) {
            switch (byoshitsu) {
            case 1:
                // ���j�b�g�^��
                return 3;
            case 2:
                // ���j�b�g�^����
                return 4;
            }
        } else {
            switch (byoshitsu) {
            case 1:
                // �]���^��
                return 1;
            case 2:
                // ������
                return 2;
            case 3:
                // �������i�V�j
                return 5;
            }
        }
        return 1;
    }
}
