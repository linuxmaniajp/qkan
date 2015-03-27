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
 * ���\�h�Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@)
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12613_201504 extends Qkan10011_ServiceUnitGetter {
    private int _1260310 = 0;

    private final String PATH_UNIT_ROOM = "1260311";
    private final String PATH_UNIT_SEMI_ROOM = "1260312";
    private final String PATH_NORMAL_ROOM = "1260313";
    private final String PATH_TASHO_ROOM = "1260314";

    public String getServiceName() {
        return "���\�h�Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@)";
    }

    public String getServiceCodeKind() {
        return "26";
    }

    public String getSystemServiceKindDetail() {
        return "12613";
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

        // 1260301 �{�ݓ��̋敪�@1-�F�m�ǎ����^ 2-���j�b�g�^�F�m�ǎ����^ 3-�o�ߌ^
        int _1260301 = getIntValue(map, "1260301", 1);

        // 1260302 �a�@�敪�@1-��w�a�@�� 2-��ʕa�@
        int _1260302 = getIntValue(map, "1260302", 1);

        // 1260303 �l���z�u�敪�@1-�T�^ 2-�U�^ 3-�V�^ 4-�W�^ 5-�X�^
        int _1260303 = getIntValue(map, "1260303", 1);

        // 1260304 �a���敪(�]���^)�@1-�]���^�� 2-������
        // 1260305 �a���敪(���j�b�g�^)�@1-���j�b�g�^�� 2-���j�b�g�^����
        // �ϊ���1-�]���^�� 2-������ 3-���j�b�g�^�� 4-���j�b�g�^����
        int byoshitsuKubun = 0;
        switch (_1260301) {
        case 1: // �F�m�ǎ����^
        case 3: // �o�ߌ^
            byoshitsuKubun = convertByoshitsuKbn(getIntValue(map, "1260304"), false);
            break;
        case 2: // ���j�b�g�^�F�m�ǎ����^
            byoshitsuKubun = convertByoshitsuKbn(getIntValue(map, "1260305"), true);
            break;
        }

        // 1260307 �×{�H���Z�@1-�Ȃ� 2-����
        int _1260307 = getIntValue(map, "1260307", 1);

        // 1260308 �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E���̕s�� 4-���Ŕ䗦��20%���� 5-�ƒn�͏o�L 6-�ƒn�͏o��
        int _1260308 = getIntValue(map, "1260308", 1);

        // 1260309 �H���񋟁@1-�Ȃ� 2-�O�H 3-�� 4-�� 5-�� 6-���� 7-���� 8-�钩
        int _1260309 = getIntValue(map, "1260309", 1);

        // 1260310 �H����p
        this._1260310 = getIntValue(map, "1260310");

        // 1260311 ���j�b�g�P�A�̐����@1-������ 2-����
        int _1260311 = getIntValue(map, "1260311", 1);

        // 1260312 �T�[�r�X�񋟑̐��������Z
        int _1260312 = getIntValue(map, "1260312", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪�@1-�F�m�ǎ����^ 2-���j�b�g�^�F�m�ǎ����^ 3-�o�ߌ^
        sb.append(CODE_CHAR[_1260301]);

        // �a�@�敪�@1-��w�a�@�� 2-��ʕa�@
        sb.append(CODE_CHAR[_1260302]);

        // �l���z�u�敪�@1-�T�^ 2-�U�^ 3-�V�^ 4-�W�^ 5-�X�^
        sb.append(CODE_CHAR[_1260303]);

        // �a���敪�@�ϊ���1-�]���^�� 2-������ 3-���j�b�g�^�� 4-���j�b�g�^����
        sb.append(CODE_CHAR[byoshitsuKubun]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E���̕s�� 4-���Ŕ䗦��20%���� 5-�ƒn�͏o�L 6-�ƒn�͏o��
        sb.append(CODE_CHAR[_1260308]);

        // ���j�b�g�P�A�̐����@�ϊ���1-���� 2-������
        switch (_1260301) {
        case 1: // �F�m�ǎ����^
        case 3: // �o�ߌ^
            sb.append(DEFAULT_CHAR);
            break;
        case 2: // ���j�b�g�^�F�m�ǎ����^
            // 1-������ 2-����
            if (_1260311 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // ���}���Z
        switch (_6) {
        case 3: // ����
            putSystemServiceCodeItem(sysSvcCdItems, "Z49202");
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z49201");
            break;
        }
        
        // �×{�H���Z�@1-�Ȃ� 2-����
        if (_1260307 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4775");
        }
        
        
        // �\�F�m�Z���T�[�r�X�񋟑̐����Z
        switch (_1260312) {
        case 5:
            // 4700 �\�F�m�Z���T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z4700");//TODO:�R�[�h�l�m�F
            break;
        case 2:
            // 4701 �\�F�m�Z���T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z4701");
            break;
        case 3:
            // 4702 �\�F�m�Z���T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z4702");
            break;
        case 4:
            // 4703 �\�F�m�Z���T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z4703");
            break;
        }
        
        // ���E���������P��ԋp
        switch (_17) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4710");//TODO:�R�[�h�l�m�F
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4711");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4712");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4713");
            break;
        }

        // ���������
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // �H����
            if (_1260309 > 1) {
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
                if (this._1260310 <= 0) {
                    // �H�0�~�ȉ��̏ꍇ
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                } else {
                    // �H�0�~�ȉ��łȂ��ꍇ
                    // �H����Ɩ�����n���ꂽ�l�ŏ㏑������B
                    mp.put("SERVICE_UNIT", new Integer(this._1260310));
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
