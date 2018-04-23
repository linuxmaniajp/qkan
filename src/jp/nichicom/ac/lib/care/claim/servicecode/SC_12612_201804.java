package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * ���\�h�Z�������×{���(�×{�a����L����f�Ï�)
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12612_201804 extends Qkan10011_ServiceUnitGetter {
    private int _1260210 = 0;

    private final String PATH_UNIT_ROOM = "1260211";
    private final String PATH_UNIT_SEMI_ROOM = "1260212";
    private final String PATH_NORMAL_ROOM = "1260213";
    private final String PATH_TASHO_ROOM = "1260214";

    public String getServiceName() {
        return "���\�h�Z�������×{���(�×{�a����L����f�Ï�)";
    }

    public String getServiceCodeKind() {
        return "26";
    }

    public String getSystemServiceKindDetail() {
        return "12612";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 6 ���}���Z
        int _6 = getIntValue(map, "6");

        // 1260201 �{�ݓ��̋敪�@1-�f�Ï� 2-���j�b�g�^�f�Ï�
        int _1260201 = getIntValue(map, "1260201", 1);

        // 1260202 �l���z�u�敪�@1-�T�^ 2-�U�^
        int _1260202 = getIntValue(map, "1260202", 1);
        
        // 1260217 �l���z�u�敪�i���j�b�g�^�f�Ï��^�p�j
        int _1260217 = getIntValue(map, "1260217");

        // 1260203 �a���敪(�]���^)�@1-�]���^�� 2-������
        // 1260204 �a���敪(���j�b�g�^)�@1-���j�b�g�^�� 2-���j�b�g�^����
        // �ϊ���1-�]���^�� 2-������ 3-���j�b�g�^�� 4-���j�b�g�^����
        int byoshitsuKubun = 0;
        switch (_1260201) {
        case 1: // �f�Ï�
            byoshitsuKubun = convertByoshitsuKbn(getIntValue(map, "1260203"), false);
            break;
        case 2: // ���j�b�g�^�f�Ï�
            byoshitsuKubun = convertByoshitsuKbn(getIntValue(map, "1260204"), true);
            break;
        }

        // 1260207 �×{�H���Z
        int _1260207 = getIntValue(map, "1260207", 1);

        // 1260208 �l�����Z�@1-�Ȃ� 2-�������
        int _1260208 = getIntValue(map, "1260208", 1);

        // 1260209 �H���񋟁@1-�Ȃ� 2-�O�H 3-�� 4-�� 5-�� 6-���� 7-���� 8-�钩
        int _1260209 = getIntValue(map, "1260209", 1);

        // 1260210 �H����p
        this._1260210 = getIntValue(map, "1260210");

        // 1260212 �ݔ�����Z 1-��^ 2-���Z�^
        int _1260212 = getIntValue(map, "1260212", 1);

        // 1260211 ���j�b�g�P�A�̐����@1-������ 2-����
        int _1260211 = getIntValue(map, "1260211", 1);

        // 1260216 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1260216 = getIntValue(map, "1260216", 1);

        // 1260213 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1260213 = getIntValue(map, "1260213", 1);

        // 1260214 �T�[�r�X�񋟑̐��������Z
        int _1260214 = getIntValue(map, "1260214", 1);

        // 1260219 �F�m�ǐ��P�A���Z
        int _1260219 = getIntValue(map, "1260219");
        
        // 1260218 �H���̗L��
        int _1260218 = getIntValue(map, "1260218");
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪�@1-�f�Ï� 2-���j�b�g�^�f�Ï�
        sb.append(CODE_CHAR[_1260201]);
        
        // �l���z�u�敪�P
        if (_1260201 == 1) {
        	 sb.append(CODE_CHAR[_1260202]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �l���z�u�敪�Q
        if (_1260201 == 2) {
        	sb.append(CODE_CHAR[_1260217]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        

        // �a���敪�@�ϊ���1-�]���^�� 2-������ 3-���j�b�g�^�� 4-���j�b�g�^����
        sb.append(CODE_CHAR[byoshitsuKubun]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �l�����Z�@1-�Ȃ� 2-�������
        sb.append(CODE_CHAR[_1260208]);

        // ���j�b�g�P�A�̐����@�ϊ���1-���� 2-������
        switch (_1260201) {
        case 1: // �f�Ï�
            sb.append(DEFAULT_CHAR);
            break;
        case 2: // ���j�b�g�^�f�Ï�
            // 1-������ 2-����
            if (_1260211 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }
        
        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        
        // �ݔ�����Z 1-��^ 2-���Z�^
        if (_1260212 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3600");
        }
        
        // 3706 �\�f�Ï��Z���F�m�ǋً}�Ή����Z
        if (_1260216 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3706");
        }
        
        // 3704 �\�f�Ï��Z����N���F�m�ǎ�����Z
        if (_1260213 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3704");
        }
        
        // ���}���Z
        switch (_6) {
        case 3: // ����
            putSystemServiceCodeItem(sysSvcCdItems, "Z39202");
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z39201");
            break;
        }
        
        // �F�m�ǐ��P�A���Z
        switch (_1260219) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6135");//2018.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6136");//2018.04
            break;
        }
        
        // �×{�H���Z
        switch (_1260207) {
        case 2:
            // �R��
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
            break;
        case 3:
            // �Q��
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
            break;
        case 4:
            // �P��
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
            break;
        }
        
        // �H���̗L��
        if (_1260218 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3610");//2018.04
        }
        
        switch (_1260214) {
        case 5:
            // 3700 �\�f�ÒZ���T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z3700");//2015.04
            break;
        case 2:
            // 3701 �\�f�ÒZ���T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z3701");
            break;
        case 3:
            // 3702 �\�f�ÒZ���T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z3702");
            break;
        case 4:
            // 3703 �\�f�ÒZ���T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z3703");
            break;
        }

        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            // �\�f�Ï��Z���������P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z3709");//2017.04
            break;
        case 5:
            // �\�f�Ï��Z���������P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z3710");//2015.04
            break;
        case 2:
            // �\�f�Ï��Z���������P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z3711");
            break;
        case 3:
            // �\�f�Ï��Z���������P���ZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z3712");
            break;
        case 4:
            // �\�f�Ï��Z���������P���ZV
            putSystemServiceCodeItem(sysSvcCdItems, "Z3713");
            break;
        }

        // ���������
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // �H����
            if (_1260209 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // �؍ݔ� --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsuKubun));
        }
        return sysSvcCdItems;
    }

    public ArrayList<VRMap> getServiceCode(Map<String, String> map,
            ACDBManager dbm) {
        ArrayList<VRMap> al = super.getServiceCode(map, dbm);
        Map<String, Integer> mp = null;
        // ��������҃`�F�b�N�����ĂȂ������ꍇ�͐H����㏑�������ɕԂ�
        //[ID:0000749][Shin Fujihara] 2012/10 edit begin 2012�N�x�Ή� ��������҂̗����Ǘ��@�\
//        if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
//            // �H��͕K�v�Ȃ����߃f�[�^������
//            return al;
//        }
        if (ACCastUtilities.toInt(map.get("7"), 1) != 2) {
        	//�H��͕K�v�Ȃ����߃f�[�^������
        	return al;
        }
        //[ID:0000749][Shin Fujihara] 2012/10 edit end 2012�N�x�Ή� ��������҂̗����Ǘ��@�\

        // ���Ə����̎擾
        VRList temp = new VRArrayList();

        try {
            temp = QkanCommon.getProviderServiceDetail(dbm,
                    ACCastUtilities.toString(map.get("PROVIDER_ID")),
                    ACCastUtilities.toInt(getSystemServiceKindDetail(), 0));
        } catch (Exception e) {
            return al;
        }

        VRMap providerInfo = (VRMap) temp.get(0);

        for (int i = 0; i < al.size(); i++) {
            mp = (Map<String, Integer>) al.get(i);

            String val = ACCastUtilities.toString(
                    mp.get("SYSTEM_SERVICE_CODE_ITEM"), "");
            if (SERVICE_CODE_SHOKUHI.equals(val)) {
                // �H��̃��R�[�h
                if (this._1260210 <= 0) {
                    // �H�0�~�ȉ��̏ꍇ
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                } else {
                    // �H�0�~�ȉ��łȂ��ꍇ
                    // �H����Ɩ�����n���ꂽ�l�ŏ㏑������B
                    mp.put("SERVICE_UNIT", new Integer(this._1260210));
                }
            } else if (SERVICE_CODE_UNIT_ROOM.equals(val)) {
                // ���j�b�g�^���̃��R�[�h
                // ��p�P����0�ȉ��Őݒ肳��Ă���ꍇ�A�߂�l����폜
                // ���j�b�g�^���̔�p�P�����擾
                int unitRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_UNIT_ROOM), 0);
                if (unitRoom <= 0) {
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                }
            } else if (SERVICE_CODE_UNIT_SEMI_ROOM.equals(val)) {
                // ���j�b�g�^�����̃��R�[�h
                // ��p�P����0�ȉ��Őݒ肳��Ă���ꍇ�A�߂�l����폜
                // ���j�b�g�^�����̔�p�P�����擾
                int unitSemiRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_UNIT_SEMI_ROOM), 0);
                if (unitSemiRoom <= 0) {
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                }
            } else if (SERVICE_CODE_NORMAL_ROOM.equals(val)) {
                // �]���^���̃��R�[�h
                // ��p�P����0�ȉ��Őݒ肳��Ă���ꍇ�A�߂�l����폜
                // �]���^���̔�p�P�����擾
                int normalRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_NORMAL_ROOM), 0);
                if (normalRoom <= 0) {
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                }
            } else if (SERVICE_CODE_TASHO_ROOM.equals(val)) {
                // �������̃��R�[�h
                // ��p�P����0�ȉ��Őݒ肳��Ă���ꍇ�A�߂�l����폜
                // �������̔�p�P�����擾
                int tashoRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_TASHO_ROOM), 0);
                if (tashoRoom <= 0) {
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                }
            }
        }

        return al;
    }
}
