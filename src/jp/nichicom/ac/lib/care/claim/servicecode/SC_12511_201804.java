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
 * ���\�h�Z�������×{���(�V��)
 * 
 * @since V7.0.0
 * @author Kamei.Yoichiro
 * 
 */
public class SC_12511_201804 extends Qkan10011_ServiceUnitGetter {
    private int _1250111 = 0;

    private final String PATH_UNIT_ROOM = "1250112";
    private final String PATH_UNIT_SEMI_ROOM = "1250113";
    private final String PATH_NORMAL_ROOM = "1250114";
    private final String PATH_TASHO_ROOM = "1250115";

    public String getServiceName() {
        return "���\�h�Z�������×{���(�V��)";
    }

    public String getServiceCodeKind() {
        return "25";
    }

    public String getSystemServiceKindDetail() {
        return "12511";
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

        // 1250101 �{�ݓ��̋敪
        // 1-���V�l�ی��{�݁iI�j 2-���j�b�g�^���V�l�ی��{�݁iI�j 3-���V�l�ی��{�݁iII�j
        // 4-���j�b�g�^���V�l�ی��{�݁iII�j 5-���V�l�ی��{�݁iIII�j 6-���j�b�g�^���V�l�ی��{�݁iIII�j
        int _1250101 = getIntValue(map, "1250101", 1);

        // 1250102 �a���敪(�]���^)�@1-�]���^�� 2-������
        int _1250102 = getIntValue(map, "1250102", 1);
        
        // 1250103 �a���敪(���j�b�g�^)�@1-���j�b�g�^�� 2-���j�b�g�^����
        int _1250103 = getIntValue(map, "1250103", 1);
        
        // �ϊ�
        int byoshitsuKubun = 0;
        switch (_1250101) {
        case 1: // 1-���V�l�ی��{�݁iI�j
        case 3: // 3-���V�l�ی��{�݁iII�j
        case 5: // 5-���V�l�ی��{�݁iIII�j
        case 7: // 5-���V�l�ی��{�݁iIV�j2018.04
            // �]���^
            byoshitsuKubun = convertByoshitsuKbn(_1250102, false);
            break;
        case 2: // 2-���j�b�g�^���V�l�ی��{�݁iI�j
        case 4: // 4-���j�b�g�^���V�l�ی��{�݁iII�j
        case 6: // 6-���j�b�g�^���V�l�ی��{�݁iIII�j
        case 8: // 6-���j�b�g�^���V�l�ی��{�݁iIV�j2018.04
            // ���j�b�g�^
            byoshitsuKubun = convertByoshitsuKbn(_1250103, true);
            break;
        }
        
        // 1250104 ��ԋΖ�������@1-��^ 2-���Z�^
        int _1250104 = getIntValue(map, "1250104", 1);

        // 1250106 �ً}�����ÊǗ����Z�@1-�Ȃ� 2-����
        int _1250106 = getIntValue(map, "1250106", 1);

        // 1250114�@�×{�̐��ێ����ʉ��ZI
        int _1250114 = getIntValue(map, "1250114", 1);

        // 1250126 �×{�̐��ێ����ʉ��ZII 2018.04
        int _1250126 = getIntValue(map, "1250126");

        // 1250108 �×{�H���Z
        int _1250108 = getIntValue(map, "1250108", 1);

        // 1250109 �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E�����͈�t�EPT�EOT�̕s��
        int _1250109 = getIntValue(map, "1250109", 1);

        // 1250110 �H���񋟁@1-�Ȃ� 2-�O�H 3-�� 4-�� 5-�� 6-���� 7-���� 8-�钩
        int _1250110 = getIntValue(map, "1250110", 1);

        // 1250111 �H����p
        this._1250111 = getIntValue(map, "1250111");

        // 1250120 ��ΐE���z�u���Z
        int _1250120 = getIntValue(map, "1250120");

        // 1250121 �ʃ��n�r�����{���Z
        int _1250121 = getIntValue(map, "1250121");

        // 1250122 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1250122 = getIntValue(map, "1250122");

        // 1250123 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1250123 = getIntValue(map, "1250123");

        // 1250117 �T�[�r�X�񋟑̐��������Z
        int _1250117 = getIntValue(map, "1250117");

        // 1250112 ���j�b�g�P�A�̐����@1-������ 2-����
        int _1250112 = getIntValue(map, "1250112", 1);
        
        // 1250124 �l���z�u�敪 1-��{�^ 2-�ݑ���^
        int _1250124 = getIntValue(map, "1250124", 1);
        
        // 1250127 �ݑ�A�E�ݑ�×{�x���@�\���Z 2018.04
        int _1250127 = getIntValue(map, "1250127");
        
        // 1250128 �F�m�ǐ��P�A���Z 2018.04
        int _1250128 = getIntValue(map, "1250128");

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪
        sb.append(CODE_CHAR[_1250101]);
        
        // �a���敪(�]���^���A������)
        sb.append(CODE_CHAR[_1250102]);
        
        // �a���敪(���j�b�g�^���A���j�b�g�^����)
        sb.append(CODE_CHAR[_1250103]);
        
        // �l���z�u�敪
        sb.append(CODE_CHAR[_1250124]);
        
        // �v���x
        sb.append(CODE_CHAR[_1]);
        
        // ��ԋΖ�������@1-��^ 2-���Z�^
        sb.append(CODE_CHAR[_1250104]);

        // �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E�����͈�t�EPT�EOT�̕s��
        sb.append(CODE_CHAR[_1250109]);

        // ���j�b�g�P�A�̐���
        switch (_1250101) {
        case 1: // 1-���V�l�ی��{�݁iI�j
        case 3: // 3-���V�l�ی��{�݁iII�j
        case 5: // 5-���V�l�ی��{�݁iIII�j
        case 7: // 7-���V�l�ی��{�݁iIV�j
            // �]���^
            sb.append(DEFAULT_CHAR);
            break;
        case 2: // 2-���j�b�g�^���V�l�ی��{�݁iI�j
        case 4: // 4-���j�b�g�^���V�l�ی��{�݁iII�j
        case 6: // 6-���j�b�g�^���V�l�ی��{�݁iIII�j
        case 8: // 8-���j�b�g�^���V�l�ی��{�݁iIV�j
            // ���j�b�g�^
            // 1-������ 2-����
            if (_1250112 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        
        // 6117 �\�V�Z��ΐE���z�u���Z
        if (_1250120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
        }
        
        
        // 6111 �\�V�Z�ʃ��n�r�����Z
        if (_1250121 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
        }
        
        // 6121 �\�V�Z�F�m�ǋً}�Ή����Z
        if (_1250122 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 6109 �\�V�Z��N���F�m�ǎ�����Z
        if (_1250123 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // ���}���Z
        switch (_6) {
        case 3: // ����
            putSystemServiceCodeItem(sysSvcCdItems, "Z19202");
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z19201");
            break;
        }
        
        // �×{�̐��ێ����ʉ��ZI
        if (_1250114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6601");
        }
        
        // �×{�̐��ێ����ʉ��ZII
        if (_1250126 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6602");//2018.04
        }
        
        // 1250127	�ݑ�A�E�ݑ�×{�x���@�\���Z
        if (_1250127 > 1) {
            switch (_1250124) { // �l���z�u�敪
            case 1: // ��{�^
                putSystemServiceCodeItem(sysSvcCdItems, "Z6280");//2018.04
                break;
            case 2: // �ݑ���^
                putSystemServiceCodeItem(sysSvcCdItems, "Z6281");//2018.04
                break;
            }
        }        
        
        // 1250128	�F�m�ǐ��P�A���Z
        switch (_1250128) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");//2018.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");//2018.04
            break;
        }
        
        // �×{�H���Z
        switch (_1250108) {
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
        // �ً}�����ÊǗ����Z�@1-�Ȃ� 2-����
        if (_1250106 > 1) {
            
            //�{�݋敪�ŕ���
            switch(_1250101) {
            //�×{�^�ȊO
            case 1: // 1-���V�l�ی��{�݁iI�j
            case 2: // 2-���j�b�g�^���V�l�ی��{�݁iI�j
            case 7: // 1-���V�l�ی��{�݁iIV�j
            case 8: // 2-���j�b�g�^���V�l�ی��{�݁iIV�j
                // �\�V�Z�ً}�����ÊǗ��P
                putSystemServiceCodeItem(sysSvcCdItems, "Z9000");
                break;

            //�×{�^
            case 3: // 3-���V�l�ی��{�݁iII�j
            case 4: // 4-���j�b�g�^���V�l�ی��{�݁iII�j
            case 5: // 5-���V�l�ی��{�݁iIII�j
            case 6: // 6-���j�b�g�^���V�l�ی��{�݁iIII�j
                // �\�V�Z�ً}�����ÊǗ��Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6000");
                break;
            }
            
        }
        
        switch (_1250117) {
        case 5:
            // 6100 �\�V�Z�T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            break;
        case 2:
            // 6101 �\�V�Z�T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 �\�V�Z�T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 �\�V�Z�T�[�r�X�񋟑̐����ZIII
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
            if (_1250110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // �؍ݔ� --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsuKubun));
        }

        return sysSvcCdItems;
    }

    public ArrayList getServiceCode(Map map, ACDBManager dbm) {
        ArrayList al = super.getServiceCode(map, dbm);
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
                if (this._1250111 <= 0) {
                    // �H�0�~�ȉ��̏ꍇ
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                } else {
                    // �H�0�~�ȉ��łȂ��ꍇ
                    // �H����Ɩ�����n���ꂽ�l�ŏ㏑������B
                    mp.put("SERVICE_UNIT", new Integer(this._1250111));
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
