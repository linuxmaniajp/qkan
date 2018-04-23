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
 * �Z�������×{���(�×{�a����L����a�@)
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12311_201804 extends Qkan10011_ServiceUnitGetter {
    private int shokuhi = 0;

    private final String PATH_UNIT_ROOM = "1230114";
    private final String PATH_UNIT_SEMI_ROOM = "1230115";
    private final String PATH_NORMAL_ROOM = "1230116";
    private final String PATH_TASHO_ROOM = "1230117";

    public String getServiceName() {
        return "�Z�������×{���(�×{�a����L����a�@)";
    }

    public String getServiceCodeKind() {
        return "23";
    }

    public String getSystemServiceKindDetail() {
        return "12311";
    }

    private boolean isHigaeriShort(int shisetsu) {
        return shisetsu == 5;
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1230101 �{�݋敪
        int _1230101 = getIntValue(map, "1230101");

        // 1230102 �l���z�u�敪
        int _1230102 = getIntValue(map, "1230102");
        
        // 1230122 �l���z�u�敪�i���j�b�g�^�a�@�×{�^�p�j
        int _1230122 = getIntValue(map, "1230122");
        
        // 1230123	�l���z�u�敪�i�a�@�o�ߌ^�p�j
        int _1230123 = getIntValue(map, "1230123");
        

        // 1230103 �a���敪(�]���^)
        int _1230103 = getIntValue(map, "1230103");

        // 1230104 �a���敪(���j�b�g�^)k
        int _1230104 = getIntValue(map, "1230104");

        // �a���敪
        int byoshitsu = 1;
        switch (_1230101) {
        case 1: // �a�@�×{�^
        case 3: // �a�@�o�ߌ^
            byoshitsu = convertByoshitsuKbn(_1230103, false);
            break;
        case 2: // ���j�b�g�^�a�@�×{�^
        case 4: // ���j�b�g�^�a�@�o�ߌ^
            byoshitsu = convertByoshitsuKbn(_1230104, true);
            break;
        case 5: // ���A��V���[�g�X�e�C
            byoshitsu = getIntValue(map, "1230113");
            break;
        }

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1230149 �l�����Z
        int _1230149 = getIntValue(map, "1230149");

        // 1230111 ���j�b�g�P�A�̐���
        int _1230111 = getIntValue(map, "1230111");

        // 1230105 ��ԋΖ�������@1-��^ 2-���Z�^
        int _1230105 = getIntValue(map, "1230105");

        // 1230116 �×{�����Z
        int _1230116 = getIntValue(map, "1230116");

        // 1230107 ��t�̔z�u�
        int _1230107 = getIntValue(map, "1230107");

        // 6 ���}���Z
        int _6 = getIntValue(map, "6");

        // 1230110 �×{�H���Z
        int _1230110 = getIntValue(map, "1230110");

        // 1230150 �H����
        int _1230150 = getIntValue(map, "1230150");

        // 1230153 �H��
        this.shokuhi = getIntValue(map, "1230153");

        // 1230113 ���A��V���[�g�p�a���敪
        int _1230113 = getIntValue(map, "1230113");

        // 1230117 ���ԋ敪
        int _1230117 = getIntValue(map, "1230117");

        // 1230120 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1230120 = getIntValue(map, "1230120", 1);

        // 1230114 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1230114 = getIntValue(map, "1230114", 1);

        // 1230115 �T�[�r�X�񋟑̐��������Z
        int _1230115 = getIntValue(map, "1230115", 1);

        // 1230121 �ً}�Z������������Z
        int _1230121 = getIntValue(map, "1230121", 1);
        
        // 1230124	�F�m�ǐ��P�A���Z
        int _1230124 = getIntValue(map, "1230124");
        
        // 1230125	��ԋΖ����Ō���Z
        int _1230125 = getIntValue(map, "1230125");
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1230101]);

        // �l���z�u�敪�P
        if (_1230101 == 1) {
        	 sb.append(CODE_CHAR[_1230102]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �l���z�u�敪�Q
        if (_1230101 == 2) {
        	sb.append(CODE_CHAR[_1230122]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �l���z�u�敪�R
        if (_1230101 == 3) {
        	sb.append(CODE_CHAR[_1230123]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �]���^��/������
        sb.append(CODE_CHAR[_1230103]);
        
        // ���j�b�g�^��/���j�b�g�^����
        sb.append(CODE_CHAR[_1230104]);
        
        // �v���x
        if (isHigaeriShort(_1230101)) {
            // ���A��V���[�g�̏ꍇ�A�v���x�͗��܂Ȃ�
            sb.append(DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }

        // ���ԋ敪
        sb.append(CODE_CHAR[_1230117]);

        // �l�����Z
        sb.append(CODE_CHAR[_1230149]);
        
        // ���j�b�g�P�A�̐���
        switch (_1230101) {
        case 1: // �a�@�×{�^
        case 3: // �a�@�o�ߌ^
        case 5: // ���A��V���[�g�X�e�C
            sb.append(DEFAULT_CHAR);
            break;
            
        //���j�b�g�^
        case 2: // ���j�b�g�^�a�@�×{�^
        case 4: // ���j�b�g�^�a�@�o�ߌ^
            // �l�𔽓]������
            // �������Ă���ꍇ
            if (_1230111 > 1)  {
                sb.append(DEFAULT_CHAR);
            // �������̏ꍇ
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }
        

        // ��ԋΖ������
        sb.append(CODE_CHAR[_1230105]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // �×{�����Z
        if (_1230116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2601");
        }
        
        // ��t�̔z�u�
        if (_1230107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2700");
        }
        
        // 2706 �a�@�ÒZ�F�m�ǋً}�Ή����Z
        if (_1230120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2706");
        }
        
        // �ً}�Z������������Z
        if (_1230121 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2777");
        }
        
        if (_1230114 > 1) {
            // ���A��V���[�g�̏ꍇ
            if (isHigaeriShort(_1230101)) {
                // 2705 �a�@�ÒZ��N���F�m�ǎ�����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z2705");
            } else {
                // 2704 �a�@�ÒZ��N���F�m�ǎ�����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z2704");
            }
        }
        
        // ���}���Z
        switch (_6) {
        case 3: // ����
            putSystemServiceCodeItem(sysSvcCdItems, "Z29202");
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z29201");
            break;
        }
        
        // 1230125	��ԋΖ����Ō���Z //2018.04
        switch (_1230125) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2591");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2592");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2593");
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2594");
            break;
        }
        
        // 1230124	�F�m�ǐ��P�A���Z
        switch (_1230124) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2714");//2018.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2715");//2018.04
            break;
        }
        
        // �×{�H���Z
        switch (_1230110) {
        case 2:
            // �R��
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
            break;
        case 3:
            // �Q��
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
            break;
        case 4:
            // �P��
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
            break;
        }
        
        // 2707 �a�@�ÒZ�T�[�r�X�񋟑̐����ZI�C
        // 2701 �a�@�ÒZ�T�[�r�X�񋟑̐����ZI��
        // 2702 �a�@�ÒZ�T�[�r�X�񋟑̐����ZII
        // 2703 �a�@�ÒZ�T�[�r�X�񋟑̐����ZIII
        switch (_1230115) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2707");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2701");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2702");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2703");
            break;
        }
        
        
        // ���E���������P��ԋp
        switch(_17){
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2709");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2710");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2711");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2712");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2713");
            break;
        }

        // ��������҃`�F�b�N�����Ă����ꍇ�͌��̒P�ʐ���ǉ�
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // �H����
            if (_1230150 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // �؍ݔ� --------
            if (isHigaeriShort(_1230101)) {
                // ���A��V���[�g�������ꍇ
                // ���A��V���[�g��p�a���敪
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(_1230113));
            } else {
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(byoshitsu));
            }

        }// �`�F�b�N�����Ă��Ȃ��ꍇ�͉����Ԃ��Ȃ�

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
                if (this.shokuhi <= 0) {
                    // �H�0�~�ȉ��̏ꍇ
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                } else {
                    // �H�0�~�ȉ��łȂ��ꍇ
                    // �H����Ɩ�����n���ꂽ�l�ŏ㏑������B
                    mp.put("SERVICE_UNIT", new Integer(this.shokuhi));
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
