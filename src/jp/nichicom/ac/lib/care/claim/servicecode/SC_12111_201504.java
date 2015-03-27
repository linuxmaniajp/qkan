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
 * �Z�������������
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12111_201504 extends Qkan10011_ServiceUnitGetter {
    private int shokuhi = 0;

    private final String PATH_UNIT_ROOM = "1210112";
    private final String PATH_UNIT_SEMI_ROOM = "1210113";
    private final String PATH_NORMAL_ROOM = "1210114";
    private final String PATH_TASHO_ROOM = "1210115";

    public String getServiceName() {
        return "�Z�������������";
    }

    public String getServiceCodeKind() {
        return "21";
    }

    public String getSystemServiceKindDetail() {
        return "12111";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1210101 �{�݋敪
        int _1210101 = getIntValue(map, "1210101");

        // 1210103 �a���敪(�]���^���A������)
        int _1210103 = getIntValue(map, "1210103");

        // 1210104 �a���敪(���j�b�g�^���A���j�b�g�^����)
        int _1210104 = getIntValue(map, "1210104");

        // �a���敪
        int byoshitsu = 1;
        switch (_1210101) {
        case 1:
        case 2:
            byoshitsu = convertByoshitsuKbn(_1210103, false);
            break;
        case 3:
        case 4:
            byoshitsu = convertByoshitsuKbn(_1210104, true);
            break;
        }

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1210105 ��ԋΖ������
        int _1210105 = getIntValue(map, "1210105");

        // 1210110 �l�����Z
        int _1210110 = getIntValue(map, "1210110");

        // 1210115 ���j�b�g�P�A�̐���
        int _1210115 = getIntValue(map, "1210115");

        // 1210106 �@�\�P���̐����Z
        int _1210106 = getIntValue(map, "1210106", 1);

        // 6 ���}���Z
        int _6 = getIntValue(map, "6");

        // 1210109 �×{�H���Z
        int _1210109 = getIntValue(map, "1210109");

        // 1210118 �ݑ�d�x���Z
        int _1210118 = getIntValue(map, "1210118");

        // 1210111 �H����
        int _1210111 = getIntValue(map, "1210111");

        // 1210114 �H��
        this.shokuhi = getIntValue(map, "1210114");

        // 1210121 ��ΐE���z�u���Z
        int _1210121 = getIntValue(map, "1210121", 1);

        // 1210124 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1210124 = getIntValue(map, "1210124", 1);

        // 1210122 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1210122 = getIntValue(map, "1210122", 1);

        // 1210119 �Ō�̐� I�^
        int _1210119 = getIntValue(map, "1210119", 1);

        // 1210120 �Ō�̐� II�^
        int _1210120 = getIntValue(map, "1210120", 1);

        // 1210123 �T�[�r�X�񋟑̐��������Z
        int _1210123 = getIntValue(map, "1210123", 1);

        // 1210126 �ً}�Z������������Z
        int _1210126 = getIntValue(map, "1210126", 1);
        
        // 1210127 �ʋ@�\�P�����Z
        int _1210127 = getIntValue(map, "1210127", 1);
        
        // 1210128 ��ØA�g�������Z
        int _1210128 = getIntValue(map, "1210128", 1);
        
        // 1210129 �������p�Ғ񋟌��Z
        int _1210129 = getIntValue(map, "1210129", 1);
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1210101]);

        // �]���^���A������
        sb.append(CODE_CHAR[_1210103]);
        // ���j�b�g�^���A���j�b�g�^����
        sb.append(CODE_CHAR[_1210104]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // ��ԋΖ������
        sb.append(CODE_CHAR[_1210105]);

        // �l�����Z
        sb.append(CODE_CHAR[_1210110]);

        // ���j�b�g�P�A�̖�����
        sb.append(CODE_CHAR[_1210115]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // 6004 �Z�������@�\�P���̐����Z
        if (_1210106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6004");
        }
        
        // 6113 �Z�������Ō�̐����ZI
        if (_1210119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
        }

        // 6115 �Z�������Ō�̐����ZII
        if (_1210120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
        }
        
        // 6117 �Z��������ΐE���z�u���ZI
        // 6119 �Z��������ΐE���z�u���ZII
        if (_1210121 > 1) {
            switch (_1210101) {
            case 1:// �P�ƌ^
            case 2:// ���݌^
                putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
                break;
            case 3:// �P�ƌ^���j�b�g
            case 4:// ���݌^���j�b�g
                putSystemServiceCodeItem(sysSvcCdItems, "Z6119");
                break;
            }
        }
        
        // 6121 �Z�������F�m�ǋً}�Ή����Z
        if (_1210124 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 6109 �Z��������N���F�m�ǎ�����Z
        if (_1210122 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // ���}���Z
        switch (_6) {
        case 3: // ����
            putSystemServiceCodeItem(sysSvcCdItems, "Z92002");
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z92001");
            break;
        }
        
        
        // �ً}�Z������������Z
        if (_1210126 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6282");
        }
        
        // �×{�H���Z
        if (_1210109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
        }
        
        // �ݑ�d�x���Z
        // �Ō�̐����Z���l�������Z�����肷��B
        if (_1210118 > 1) {
            if (_1210119 == 2 && _1210120 == 2) {
                // 6279 �Z�������ݑ�d�x�Ҏ�����Z�R
                putSystemServiceCodeItem(sysSvcCdItems, "Z6279");
            } else if (_1210119 == 2) {
                // 6277 �Z�������ݑ�d�x�Ҏ�����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
            } else if (_1210120 == 2) {
                // 6278 �Z�������ݑ�d�x�Ҏ�����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6278");
            } else {
                // 6280 �Z�������ݑ�d�x�Ҏ�����Z�S
                putSystemServiceCodeItem(sysSvcCdItems, "Z6280");
            }
        }
        
        // 1210127 �ʋ@�\�P�����Z
        if (_1210127 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6005");//2015.04
        }
        
        // 1210128 ��ØA�g�������Z
        if (_1210128 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6116");//2015.04
        }
        
        // 1210129 �������p�Ғ񋟌��Z
        if (_1210129 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6283");//2015.04
        }
        
        
        // �Z�������T�[�r�X�񋟑̐����Z
        switch (_1210123) {
        // �Z�������T�[�r�X�񋟑̐����ZI�C
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        // �Z�������T�[�r�X�񋟑̐����ZI��
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        // �Z�������T�[�r�X�񋟑̐����ZII
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        // �Z�������T�[�r�X�񋟑̐����ZIII
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // ���E���������P��ԋp
        switch(_17){
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
        
        
        // ��������҃`�F�b�N�����Ă����ꍇ�͌��̒P�ʐ���ǉ�
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // �H����
            if (_1210111 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // �؍ݔ� --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
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
