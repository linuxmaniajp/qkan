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
 * ���\�h�Z�������������
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12411_201804 extends Qkan10011_ServiceUnitGetter {
    private int _1240110 = 0;

    private final String PATH_UNIT_ROOM = "1240112";
    private final String PATH_UNIT_SEMI_ROOM = "1240113";
    private final String PATH_NORMAL_ROOM = "1240114";
    private final String PATH_TASHO_ROOM = "1240115";

    public String getServiceName() {
        return "���\�h�Z�������������";
    }

    public String getServiceCodeKind() {
        return "24";
    }

    public String getSystemServiceKindDetail() {
        return "12411";
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

        // 1240101 �{�ݓ��̋敪�@1-�P�ƌ^ 2-���݌^ 3-�P�ƌ^���j�b�g�^ 4-���݌^���j�b�g�^
        int _1240101 = getIntValue(map, "1240101", 1);

        // 1240102 �a���敪(�]���^)�@1-�]���^�� 2-������
        // 1240103 �a���敪(���j�b�g�^)�@1-���j�b�g�^�� 2-���j�b�g�^����
        // �ϊ���1-�]���^�� 2-������ 3-���j�b�g�^�� 4-���j�b�g�^����
        int byoshitsuKubun = 0;
        if (_1240101 > 2) {
            // ���j�b�g�^
            byoshitsuKubun = convertByoshitsuKbn(getIntValue(map, "1240103"),
                    true);
        } else {
            // �]���^
            byoshitsuKubun = convertByoshitsuKbn(getIntValue(map, "1240102"),
                    false);
        }

        // 1240104 ��ԋΖ�������@1-��^ 2-���Z�^
        int _1240104 = getIntValue(map, "1240104", 1);

        // 1240105 �@�\�P���̐����Z�@1-�Ȃ� 2-����
        int _1240105 = getIntValue(map, "1240105", 1);

        // 1240107 �×{�H���Z
        int _1240107 = getIntValue(map, "1240107", 1);

        // 1240108 �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E���̕s��
        int _1240108 = getIntValue(map, "1240108", 1);

        // 1240109 �H���񋟁@1-�Ȃ� 2-�O�H 3-�� 4-�� 5-�� 6-���� 7-���� 8-�钩
        int _1240109 = getIntValue(map, "1240109", 1);

        // 1240110 �H����p
        this._1240110 = getIntValue(map, "1240110", 1);

        // 1240114 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1240114 = getIntValue(map, "1240114", 1);

        // 1240112 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1240112 = getIntValue(map, "1240112", 1);

        // 1240113 �T�[�r�X�񋟑̐��������Z
        int _1240113 = getIntValue(map, "1240113", 1);

        // 1240111 ���j�b�g�P�A�̐����@1-������ 2-�����@���ϊ���1-���� 2-������
        int _1240111 = getIntValue(map, "1240111", 1);
        
        // 1240115	�ʋ@�\�P�����Z
        int _1240115 = getIntValue(map, "1240115", 1);

        
        // 22 �����^
        int _22 = getIntValue(map, "22", 1);
        
        // 1240116 �������k���z�u�����Z
        int _1240116 = getIntValue(map, "1240116");
        
        // 1240117 �����@�\����A�g���Z
        int _1240117 = getIntValue(map, "1240117");
        
        // 1240118 �F�m�ǐ��P�A���Z
        int _1240118 = getIntValue(map, "1240118");
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪�@1-�P�ƌ^ 2-���݌^ 3-�P�ƌ^���j�b�g�^ 4-���݌^���j�b�g�^
        sb.append(CODE_CHAR[_1240101]);

        // �a���敪�@�ϊ���1-�]���^�� 2-������ 3-���j�b�g�^�� 4-���j�b�g�^����
        sb.append(CODE_CHAR[byoshitsuKubun]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // ��ԋΖ�������@1-��^ 2-���Z�^
        sb.append(CODE_CHAR[_1240104]);

        // �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E���̕s��
        sb.append(CODE_CHAR[_1240108]);

        // ���j�b�g�P�A�̐���
        switch (_1240101) {
        case 1: //���E������
        case 2:
            sb.append(DEFAULT_CHAR);
            break;
        case 3: //���j�b�g�^
        case 4:
            // 1-������ 2-����
            if (_1240111 > 1) {
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
            putSystemServiceCodeItem(sysSvcCdItems, "Z92002");
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z92001");
            break;
        }

        // 6004 �\�Z�������@�\�P���̐����Z
        if (_1240105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6004");
        }
        
        // 6121 �\�Z�������F�m�ǋً}�Ή����Z
        if (_1240114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 6109 �\�Z��������N���F�m�ǎ�����Z
        if (_1240112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // �×{�H���Z 2018.04
        switch (_1240107) {
        case 2:
            // �R��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        case 3:
            // �Q��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        case 4:
            // �P��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        }
        
        // �ʋ@�\�P�����Z
        if (_1240115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6005");
        }
        
        // �����^ //2018.04
        switch (_22) {
        case 10:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6368");
            break;
        }
        
        // 1240116 �������k���z�u�����Z
        if (_1240116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6350");//2018.04
        }
        
        // 1240117 �����@�\����A�g���Z
        if (_1240117 > 1) {
        	if (_1240115 > 1) { //�ʋ@�\�P�����Z���Z�肵�Ă���ꍇ
        		putSystemServiceCodeItem(sysSvcCdItems, "Z4003"); //2018.04
        	} else {
        		putSystemServiceCodeItem(sysSvcCdItems, "Z4002"); //2018.04
        	}
        }
        
        // 1240118	�F�m�ǐ��P�A���Z
        switch (_1240118) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");//2018.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");//2018.04
            break;
        }

        switch (_1240113) {
        case 5:
            // 6101 �\�Z�������T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            break;
        case 2:
            // 6101 �\�Z�������T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 �\�Z�������T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 �\�Z�������T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        }

        // ���������
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // �H����
            if (_1240109 > 1) {
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
                if (this._1240110 <= 0) {
                    // �H�0�~�ȉ��̏ꍇ
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                } else {
                    // �H�0�~�ȉ��łȂ��ꍇ
                    // �H����Ɩ�����n���ꂽ�l�ŏ㏑������B
                    mp.put("SERVICE_UNIT", new Integer(this._1240110));
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
