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
 * �Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@)
 * 
 * @since V7.0.0
 * @author Yoiciro.Kamei
 * 
 */
public class SC_12313_201804 extends Qkan10011_ServiceUnitGetter {
    private int shokuhi = 0;

    private final String PATH_UNIT_ROOM = "1230311";
    private final String PATH_UNIT_SEMI_ROOM = "1230312";
    private final String PATH_NORMAL_ROOM = "1230313";
    private final String PATH_TASHO_ROOM = "1230314";

    public String getServiceName() {
        return "�Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@)";
    }

    public String getServiceCodeKind() {
        return "23";
    }

    public String getSystemServiceKindDetail() {
        return "12313";
    }

    private boolean isHigaeriShort(int shisetsu) {
        return shisetsu == 4;
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1230301 �{�݋敪
        int _1230301 = getIntValue(map, "1230301");

        // 1230308 �a�@�敪
        int _1230308 = getIntValue(map, "1230308");

        // 1230302 �l���z�u�敪
        int _1230302 = getIntValue(map, "1230302");

        // 1230303 �a���敪(�]���^)
        int _1230303 = getIntValue(map, "1230303");

        // 1230304 �a���敪(���j�b�g�^)
        int _1230304 = getIntValue(map, "1230304");

        // �a���敪
        int byoshitsu = 1;
        switch (_1230301) {
        case 1: // �F�m�ǎ����^
        case 3: // �o�ߌ^
            byoshitsu = convertByoshitsuKbn(_1230303, false);
            break;
        case 2: // ���j�b�g�^�F�m�ǎ����^
            byoshitsu = convertByoshitsuKbn(_1230304, true);
            break;
        case 4: // ���A��V���[�g�X�e�C
            byoshitsu = getIntValue(map, "1230311");
            break;
        }

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1230346 �l�����Z
        int _1230346 = getIntValue(map, "1230346");

        // 1230309 ���j�b�g�P�A�̐���
        int _1230309 = getIntValue(map, "1230309");

        // 6 ���}���Z
        int _6 = getIntValue(map, "6");

        // 1230307 �×{�H���Z
        int _1230307 = getIntValue(map, "1230307");

        // 1230347 �H����
        int _1230347 = getIntValue(map, "1230347");

        // 1230350 �H��
        this.shokuhi = getIntValue(map, "1230350");

        // 1230311 ���A��V���[�g�p�a���敪
        int _1230311 = getIntValue(map, "1230311");

        // 1230352 ���ԋ敪
        int _1230352 = getIntValue(map, "1230352");

        // 1230351 �T�[�r�X�񋟑̐��������Z
        int _1230351 = getIntValue(map, "1230351");

        // 1230312 �ً}�Z������������Z
        int _1230312 = getIntValue(map, "1230312", 1);
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1230301]);

        // �a�@�敪
        sb.append(CODE_CHAR[_1230308]);

        // �l���z�u�敪
        sb.append(CODE_CHAR[_1230302]);
        
        // �]���^��/������
        sb.append(CODE_CHAR[_1230303]);
        
        // ���j�b�g�^��/���j�b�g�^����
        sb.append(CODE_CHAR[_1230304]);

        // ���ԋ敪
        sb.append(CODE_CHAR[_1230352]);

        // �v���x
        if (isHigaeriShort(_1230301)) {
            // ���A��V���[�g�̏ꍇ�A�v���x�͗��܂Ȃ�
            sb.append(DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }

        // �l�����Z
        sb.append(CODE_CHAR[_1230346]);

        // ���j�b�g�P�A�̐���
        switch (_1230301) {
        //�f�Ï��A���A��V���[�g
        case 1: // �F�m�ǎ����^
        case 3: // �o�ߌ^
        case 4: // ���A��V���[�g�X�e�C
            sb.append(DEFAULT_CHAR);
            break;
            
        //���j�b�g�^
        case 2:
            // �l�𔽓]������
            // �������Ă���ꍇ
            if (_1230309 > 1)  {
                sb.append(DEFAULT_CHAR);
            // �������̏ꍇ
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // �ً}�Z������������Z
        if (_1230312 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4751");
        }
        
        // ���}���Z
        switch (_6) {
        case 3: // ����
            putSystemServiceCodeItem(sysSvcCdItems, "Z49202");
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z49201");
            break;
        }

        // �×{�H���Z
        switch (_1230307) {
        case 2:
            // �R��
            putSystemServiceCodeItem(sysSvcCdItems, "Z4775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z4775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z4775");
            break;
        case 3:
            // �Q��
            putSystemServiceCodeItem(sysSvcCdItems, "Z4775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z4775");
            break;
        case 4:
            // �P��
            putSystemServiceCodeItem(sysSvcCdItems, "Z4775");
            break;
        }
        
        // �F�m�ǒZ���T�[�r�X�񋟑̐����Z
        switch (_1230351) {
        case 5:
            // 4700 �F�m�ǒZ���T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z4700");//2015.04
            break;
        case 2:
            // 4701 �F�m�ǒZ���T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z4701");
            break;
        case 3:
            // 4702 �F�m�ǒZ���T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z4702");
            break;
        case 4:
            // 4703 �F�m�ǒZ���T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z4703");
            break;
        }
        
        // ���E���������P��ԋp
        switch(_17){
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4709");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4710");//2015.04
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

        // ��������҃`�F�b�N�����Ă����ꍇ�͌��̒P�ʐ���ǉ�
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // �H����
            if (_1230347 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // �؍ݔ� --------
            if (isHigaeriShort(_1230301)) {
                // ���A��V���[�g�������ꍇ
                // ���A��V���[�g��p�a���敪
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(_1230311));
            } else {
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(byoshitsu));
            }
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
