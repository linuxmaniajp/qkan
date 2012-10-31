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
 * �Z�������×{���(�V��)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_12211_201204 extends Qkan10011_ServiceUnitGetter {
    private int shokuhi = 0;

    private final String PATH_UNIT_ROOM = "1220113";
    private final String PATH_UNIT_SEMI_ROOM = "1220114";
    private final String PATH_NORMAL_ROOM = "1220115";
    private final String PATH_TASHO_ROOM = "1220116";

    public String getServiceName() {
        return "�Z�������×{���(�V��)";
    }

    public String getServiceCodeKind() {
        return "22";
    }

    public String getSystemServiceKindDetail() {
        return "12211";
    }

    private boolean isHigaeriShort(int shisetsu) {
        return shisetsu == 7;
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1220101 �{�݋敪
        int _1220101 = getIntValue(map, "1220101");

        // 1220102 �a���敪(�]���^)
        int _1220102 = getIntValue(map, "1220102");

        // 1220103 �a���敪(���j�b�g�^)
        int _1220103 = getIntValue(map, "1220103");

        // �a���敪
        int byoshitsu = 1;
        switch (_1220101) {
        //�]���^
        case 1:
        case 3:
        case 5:
            byoshitsu = convertByoshitsuKbn(_1220102, false);
            break;
            
        //���j�b�g�^
        case 2:
        case 4:
        case 6:
            byoshitsu = convertByoshitsuKbn(_1220103, true);
            break;
            
        //
        case 7:
            byoshitsu = getIntValue(map, "1220119", 0);
            break;
        }

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1220104 ��ԋΖ������
        int _1220104 = getIntValue(map, "1220104");

        // 1220111 �l�����Z
        int _1220111 = getIntValue(map, "1220111");

        // 1220117 ���j�b�g�P�A�̐���
        int _1220117 = getIntValue(map, "1220117");

        // 1220105 ���n�r���@�\�������Z
        int _1220105 = getIntValue(map, "1220105", 1);

        // 1220116 �F�m�ǃP�A���Z
        int _1220116 = getIntValue(map, "1220116", 1);

        // 6 ���}���Z
        int _6 = getIntValue(map, "6");

        // 1220121 �×{�̐��ێ����ʉ��Z
        int _1220121 = getIntValue(map, "1220121");

        // 1220110 �×{�H���Z
        int _1220110 = getIntValue(map, "1220110");

        // 1220108 �ً}�����ÊǗ����Z
        int _1220108 = getIntValue(map, "1220108");

        // 1220112 �H����
        int _1220112 = getIntValue(map, "1220112");

        // 1210114 �H��
        this.shokuhi = getIntValue(map, "1220115");

        // 1220119 ���A��V���[�g�p�a���敪
        int _1220119 = getIntValue(map, "1220119");

        // 1220125 ���ԋ敪
        int _1220125 = getIntValue(map, "1220125");

        // 1220122 ��ΐE���z�u���Z
        int _1220122 = getIntValue(map, "1220122");

        // 1220126 �ʃ��n�r�����{���Z
        int _1220126 = getIntValue(map, "1220126");

        // 1220127 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1220127 = getIntValue(map, "1220127");

        // 1220123 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1220123 = getIntValue(map, "1220123");

        // 1220124 �T�[�r�X�񋟑̐��������Z
        int _1220124 = getIntValue(map, "1220124", 1);

        // 1220130 �ً}�Z������������Z
        int _1220130 = getIntValue(map, "1220130", 1);

        // 1220129 �d�x�×{�Ǘ����Z
        int _1220129 = getIntValue(map, "1220129", 1);
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
        // 1520143 �l���z�u�敪
        int _1220131 = getIntValue(map, "1220131", 1);
        
        // 1520149 �l���z�u�敪�i�×{�^�j
        int _1220132 = getIntValue(map, "1220132", 1);
        

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1220101]);
        
        // �]���^/�ݑ���^
        sb.append(CODE_CHAR[_1220131]);
        
        // �×{�^/�×{�����^
        sb.append(CODE_CHAR[_1220132]);
        
        // �]���^��/������
        sb.append(CODE_CHAR[_1220102]);
        
        // ���j�b�g�^��/���j�b�g�^����
        sb.append(CODE_CHAR[_1220103]);
        
        // �v���x
        if (isHigaeriShort(_1220101)) {
            // ���A��V���[�g�̏ꍇ�A�v���x�͗��܂Ȃ�
            sb.append(DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }
        
        // ��ԋΖ������
        sb.append(CODE_CHAR[_1220104]);
        
        // �l�����Z
        sb.append(CODE_CHAR[_1220111]);
        
        // ���j�b�g�P�A�̐���
        switch (_1220101) {
        //�]���^�A���A��V���[�g
        case 1:
        case 3:
        case 5:
        case 7:
            sb.append(DEFAULT_CHAR);
            break;
            
        //���j�b�g�^
        case 2:
        case 4:
        case 6:
            // �l�𔽓]������
            // �������Ă���ꍇ
            if (_1220117 > 1)  {
                sb.append(DEFAULT_CHAR);
            // �������̏ꍇ
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }
        
        
        // ���ԋ敪
        sb.append(CODE_CHAR[_1220125]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // 6117 �V�Z��ΐE���z�u���Z
        if (_1220122 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
        }
        
        // 6250 �V�Z���n�r���@�\�������Z
        if (_1220105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6250");
        }
        
        // 6111 �V�Z�ʃ��n�r�����Z
        if (_1220126 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
        }
        
        // 6254 �V�Z�F�m�ǃP�A���Z
        if (_1220116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6254");
        }
        
        // 6121 �V�Z�F�m�ǋً}�Ή����Z
        if (_1220127 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // �ً}�Z������������Z
        if (_1220130 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
        }
        
        // �V�Z��N���F�m�ǎ�����Z
        if (_1220123 > 1) {
            if (isHigaeriShort(_1220101)) {
                // 6110 �V�Z��N���F�m�ǎ�����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
            } else {
                // 6109 �V�Z��N���F�m�ǎ�����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
            }
        }
        
        // �d�x�×{�Ǘ����Z
        if (_1220129 > 1) {
            if (isHigaeriShort(_1220101)) {
                // 6279 �V�Z�d�x�×{�Ǘ����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6279");
            } else {
                // 6278 �V�Z�d�x�×{�Ǘ����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6278");
            }
        }
        
        // ���}���Z
        switch (_6) {
        case 3: // ����
            putSystemServiceCodeItem(sysSvcCdItems, "Z19202");
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z19201");
            break;
        }
        
        // �×{�̐��ێ����ʉ��Z
        if (_1220121 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6601");
        }
        
        // �×{�H���Z
        if (_1220110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
        }
        
        // �ً}�����ÊǗ����Z
        if (_1220108 > 1) {
            
            switch (_1220101) {
            // �×{�^�V���ȊO�̏ꍇ
            case 1: //���V�l�ی��{�݁iI�j
            case 2: //���j�b�g�^���V�l�ی��{�݁iI�j
            case 7: //���A��V���[�g�X�e�C
                putSystemServiceCodeItem(sysSvcCdItems, "Z9000");
                break;
                
           // �×{�^�V���̏ꍇ
            case 3: //���V�l�ی��{�݁iII�j
            case 4: //���j�b�g�^���V�l�ی��{�݁iII�j
            case 5: //���V�l�ی��{�݁iIII�j
            case 6: //���j�b�g�^���V�l�ی��{�݁iIII�j
                putSystemServiceCodeItem(sysSvcCdItems, "Z6000");
                break;
            }
        }
        
        // �V�Z�T�[�r�X�񋟑̐����Z
        switch(_1220124) {
        // �V�Z�T�[�r�X�񋟑̐����ZI
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        // �V�Z�T�[�r�X�񋟑̐����ZII
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        // �V�Z�T�[�r�X�񋟑̐����ZIII
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // �������P�𖳗���荬����
        switch(_17){
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
            if (_1220112 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // �؍ݔ� --------
            if (isHigaeriShort(_1220101)) {
                // ���A��V���[�g�I����
                // ���A��V���[�g��p�a���敪
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(_1220119));
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
