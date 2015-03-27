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
 * ���\�h�Z�������×{���(�×{�a����L����a�@)
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12611_201504 extends Qkan10011_ServiceUnitGetter {
    private int _1260112 = 0;

    private final String PATH_UNIT_ROOM = "1260114";
    private final String PATH_UNIT_SEMI_ROOM = "1260115";
    private final String PATH_NORMAL_ROOM = "1260116";
    private final String PATH_TASHO_ROOM = "1260117";

    public String getServiceName() {
        return "���\�h�Z�������×{���(�×{�a����L����a�@)";
    }

    public String getServiceCodeKind() {
        return "26";
    }

    public String getSystemServiceKindDetail() {
        return "12611";
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

        // 1260101 �{�ݓ��̋敪�@1-�a�@ 2-���j�b�g�^�a�@ 3-�o�ߌ^ 4-���j�b�g�^�o�ߌ^
        int _1260101 = getIntValue(map, "1260101", 1);

        // 1260102 �l���z�u�敪
        int _1260102 = getIntValue(map, "1260102", 1);

        // 1260118 �l���z�u�敪�i���j�b�g�^�a�@�×{�^�p�j
        int _1260118 = getIntValue(map, "1260118");

        // 1260119 �l���z�u�敪�i�a�@�o�ߌ^�p�j
        int _1260119 = getIntValue(map, "1260119");
        
        // 1260103 �a���敪(�]���^)�@1-�]���^�� 2-������
        // 1260104 �a���敪(���j�b�g�^)�@1-���j�b�g�^�� 2-���j�b�g�^����
        // �ϊ���1-�]���^�� 2-������ 3-���j�b�g�^�� 4-���j�b�g�^����
        int byoshitsuKubun = 0;
        switch (_1260101) {
        case 1: // �a�@
        case 3: // �o�ߌ^
            // �]���^
            byoshitsuKubun = convertByoshitsuKbn(getIntValue(map, "1260103"), false);
            break;
        case 2: // ���j�b�g�^�a�@
        case 4: // ���j�b�g�^�o�ߌ^
            // ���j�b�g�^
            byoshitsuKubun = convertByoshitsuKbn(getIntValue(map, "1260104"), true);
            break;
        }

        // 1260105 ��ԋΖ�������@1-��^ 2-���Z�^�T 3-���Z�^�U 4-���Z�^�V 5-���Z�^
        int _1260105 = getIntValue(map, "1260105", 1);

        // 1260116 �×{�����Z�@1-��^ 2-���Z�^�T 4-���Z�^�V
        int _1260116 = getIntValue(map, "1260116", 1);

        // 1260107 ��t�̔z�u��@1-� 2-��Ö@�{�s�K����49��K�p
        int _1260107 = getIntValue(map, "1260107", 1);

        // 1260109 �×{�H���Z�@1-�Ȃ� 2-����
        int _1260109 = getIntValue(map, "1260109", 1);

        // 1260110 �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E���̕s�� 4-���Ŕ䗦��20%���� 5-�ƒn�͏o�L 6-�ƒn�͏o��
        int _1260110 = getIntValue(map, "1260110", 1);

        // 1260111 �H���񋟁@1-�Ȃ� 2-�O�H 3-�� 4-�� 5-�� 6-���� 7-���� 8-�钩
        int _1260111 = getIntValue(map, "1260111", 1);

        // 1260112 �H����p
        this._1260112 = getIntValue(map, "1260112");

        // 1260113 ���j�b�g�P�A�̐����@1-������ 2-����
        int _1260113 = getIntValue(map, "1260113");

        // 1260117 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1260117 = getIntValue(map, "1260117");

        // 1260114 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1260114 = getIntValue(map, "1260114");

        // 1260115 �T�[�r�X�񋟑̐��������Z
        int _1260115 = getIntValue(map, "1260115");

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪�@1-�a�@ 2-���j�b�g�^�a�@ 3-�o�ߌ^ 4-���j�b�g�^�o�ߌ^
        sb.append(CODE_CHAR[_1260101]);

        // �l���z�u�敪�@1-�T�^ 2-�U�^ 3-�V�^
        // �l���z�u�敪�P
        if (_1260101 == 1) {
        	 sb.append(CODE_CHAR[_1260102]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �l���z�u�敪�Q
        if (_1260101 == 2) {
        	sb.append(CODE_CHAR[_1260118]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �l���z�u�敪�R
        if (_1260101 == 3) {
        	sb.append(CODE_CHAR[_1260119]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �a���敪�@�ϊ���1-�]���^�� 2-������ 3-���j�b�g�^�� 4-���j�b�g�^����
        sb.append(CODE_CHAR[byoshitsuKubun]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // ��ԋΖ�������@1-��^ 2-���Z�^�T 3-���Z�^�U 4-���Z�^�V 5-���Z�^
        sb.append(CODE_CHAR[_1260105]);

        // �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E���̕s�� 4-���Ŕ䗦��20%���� 5-�ƒn�͏o�L 6-�ƒn�͏o��
        sb.append(CODE_CHAR[_1260110]);

        // ���j�b�g�P�A�̐����@�ϊ���1-���� 2-������
        switch (_1260101) {
        case 1: // �a�@
        case 3: // �o�ߌ^
            sb.append(DEFAULT_CHAR);
            break;
        case 2: // ���j�b�g�^�a�@
        case 4: // ���j�b�g�^�o�ߌ^
            // 1-������ 2-����
            if (_1260113 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        
        // �×{�����Z�@1-��^ 2-���Z�^�T 4-���Z�^�V
        switch (_1260116) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2601");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2603");
            break;
        }
        
        // ��t�̔z�u��@1-� 2-��Ö@�{�s�K����49��K�p
        if (_1260107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2700");
        }
        
        // 2706 �\�a�@�ÒZ�F�m�ǋً}�Ή����Z
        if (_1260117 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2706");
        }
        
        // 2704 �\�a�@�ÒZ��N���F�m�ǎ�����Z
        if (_1260114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2704");
        }
        
        // ���}���Z
        switch (_6) {
        case 3: // ����
            putSystemServiceCodeItem(sysSvcCdItems, "Z29202");
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z29201");
            break;
        }
        
        // �×{�H���Z�@1-�Ȃ� 2-����
        if (_1260109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
        }
        
        switch (_1260115) {
        case 5:
            // 2705 �\�a�@�ÒZ�T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z2705");//TODO:�R�[�h�l�m�F
            break;
        case 2:
            // 2701 �\�a�@�ÒZ�T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z2701");
            break;
        case 3:
            // 2702 �\�a�@�ÒZ�T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z2702");
            break;
        case 4:
            // 2703 �\�a�@�ÒZ�T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z2703");
            break;
        }

        // ���E���������P��ԋp
        switch (_17) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2710");//TODO:�R�[�h�l�m�F
            break;
        case 2:
            // �\�a�@�ÒZ�������P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z2711");
            break;
        case 3:
            // �\�a�@�ÒZ�������P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z2712");
            break;
        case 4:
            // �\�a�@�ÒZ�������P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z2713");
            break;
        }

        // ���������
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // �H����
            if (_1260111 > 1) {
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
                if (this._1260112 <= 0) {
                    // �H�0�~�ȉ��̏ꍇ
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                } else {
                    // �H�0�~�ȉ��łȂ��ꍇ
                    // �H����Ɩ�����n���ꂽ�l�ŏ㏑������B
                    mp.put("SERVICE_UNIT", new Integer(this._1260112));
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
