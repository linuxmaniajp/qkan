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
 * ���×{�^��Î{��(�×{�a����L����a�@)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_15311_201204 extends Qkan10011_ServiceUnitGetter {
    private int _1530161 = 0;

    private final String PATH_UNIT_ROOM = "1530115";
    private final String PATH_UNIT_SEMI_ROOM = "1530116";
    private final String PATH_NORMAL_ROOM = "1530117";
    private final String PATH_TASHO_ROOM = "1530118";

    public String getServiceName() {
        return "���×{�^��Î{��(�×{�a����L����a�@)";
    }

    public String getServiceCodeKind() {
        return "53";
    }

    public String getSystemServiceKindDetail() {
        return "15311";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1530162 �{�݋敪
        int _1530162 = getIntValue(map, "1530162");

        // 1530102 �l���z�u�敪
        int _1530102 = getIntValue(map, "1530102", 1);

        // 1530103 �a���敪(�]���^)
        int _1530103 = getIntValue(map, "1530103");

        // 1530104 �a���敪(���j�b�g�^)
        int _1530104 = getIntValue(map, "1530104");

        // �a���敪
        int byoshitsu = 1;
        switch (_1530162) {
        case 1:
        case 3:
            byoshitsu = convertByoshitsuKbn(_1530103, false);
            break;
        case 2:
        case 4:
            byoshitsu = convertByoshitsuKbn(_1530104, true);
            break;
        }

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1530163 ��ԋΖ������
        int _1530163 = getIntValue(map, "1530163");

        // 1530158 �l�����Z
        int _1530158 = getIntValue(map, "1530158");

        // 1530116 ���j�b�g�P�A�̐���
        int _1530116 = getIntValue(map, "1530116");

        // 1530168 �×{�����Z
        int _1530168 = getIntValue(map, "1530168");

        // 1530107 ��t�̔z�u�
        int _1530107 = getIntValue(map, "1530107");

        // 1530117 �g�̍S���p�~�����{���Z
        int _1530117 = getIntValue(map, "1530117");

        // 1530108 �O�����Z
        int _1530108 = getIntValue(map, "1530108");

        // 1530110 ���Ȏ�f���Z
        int _1530110 = getIntValue(map, "1530110");

        // 1530109 �������Z
        int _1530109 = getIntValue(map, "1530109");

        // 3020105 �ޏ����w�����Z
        int _3020105 = getIntValue(map, "3020105");

        // 3020106 �ޏ������񋟉��Z
        int _3020106 = getIntValue(map, "3020106");

        // 3020107 �ޏ��O�A�g���Z
        int _3020107 = getIntValue(map, "3020107");

        // 3020108 �V�l�K��Ō�w�����Z
        int _3020108 = getIntValue(map, "3020108");

        // 1530112 �h�{�}�l�W�����g���Z
        int _1530112 = getIntValue(map, "1530112");

        // 1530113 �o���ڍs���Z
        int _1530113 = getIntValue(map, "1530113");

        // 1530115 �o���ێ����Z
        int _1530115 = getIntValue(map, "1530115");

        // 1530114 �×{�H���Z
        int _1530114 = getIntValue(map, "1530114");

        // 1530118 �ݑ�A�x���@�\���Z
        int _1530118 = getIntValue(map, "1530118");

        // 1530159 �H����
        int _1530159 = getIntValue(map, "1530159");

        // 1530161 �H��
        this._1530161 = getIntValue(map, "1530161");

        // 1530119 ���s�I�މ@�T�[�r�X��
        int _1530119 = getIntValue(map, "1530119");

        // 1530164 ��N���F�m�Ǌ��Ҏ�����Z
        int _1530164 = getIntValue(map, "1530164");

        // 1530165 ���o�@�\�ێ��Ǘ����Z
        int _1530165 = getIntValue(map, "1530165");

        // 1530166 �F�m�ǐ��P�A���Z
        int _1530166 = getIntValue(map, "1530166");

        // 1530167 �T�[�r�X�񋟑̐��������Z
        int _1530167 = getIntValue(map, "1530167");

        // �P�Ɖ��Z
        int _9 = getIntValue(map, "9");

        // 3020109 �ޏ�(�@)�O�K��w�����Z
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 �ޏ�(�@)��K��w�����Z
        int _3020110 = getIntValue(map, "3020110", 1);

        // 1530169 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1530169 = getIntValue(map, "1530169", 1);

        // 1530170 ���o�@�\�ێ��Ǘ��̐����Z
        int _1530170 = getIntValue(map, "1530170", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if (_9 == 2) {

            // �ޏ�(�@)��K��w�����Z
            if (_3020110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z2856");
            }

            // ���E���������P��ԋp
            switch (_17) {
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

            return sysSvcCdItems;
        }

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1530162]);

        // �l���z�u�敪
        sb.append(CODE_CHAR[_1530102]);

        // �a���敪(�]���^��/)
        sb.append(CODE_CHAR[_1530103]);

        // �a���敪(���j�b�g�^��/���j�b�g�^����)
        sb.append(CODE_CHAR[_1530104]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // ��ԋΖ������
        sb.append(CODE_CHAR[_1530163]);

        // �l�����Z
        sb.append(CODE_CHAR[_1530158]);

        // ���j�b�g�P�A�̐���
        switch (_1530162) {
        case 1: // ���E������
        case 3:
            sb.append(DEFAULT_CHAR);
            break;
        case 2: // ���j�b�g�^
        case 4:
            // 1-������ 2-����
            if (_1530116 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // �×{�����Z
        switch (_1530168) {
        // �×{�^�×{�����Z
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2601");
            break;
        // �×{�^�×{�����ZIII
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2603");
            break;
        }

        // ��t�̔z�u�
        if (_1530107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2700");
        }

        // Z2704 �×{�^��N���F�m�ǎ�����Z
        if (_1530164 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2704");
        }

        // �g�̍S���p�~�����{���Z
        if (_1530117 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2834");
        }

        // �O�����Z
        if (_1530108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2830");
        }

        // ���Ȏ�f���Z
        if (_1530110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2831");
        }

        // �������Z
        if (_1530109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2840");
        }

        // �ޏ�(�@)�O�K��w�����Z
        if (_3020109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2851");
        }

        // �ޏ�(�@)��K��w�����Z
        if (_3020110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2856");
        }

        // �ޏ����w�����Z
        if (_3020105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2852");
        }

        // �ޏ������񋟉��Z
        if (_3020106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2854");
        }

        // �ޏ��O�A�g���Z
        if (_3020107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2855");
        }

        // �V�l�K��Ō�w�����Z
        if (_3020108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2853");
        }

        // �h�{�}�l�W�����g���Z
        if (_1530112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2773");
        }

        // �o���ڍs���Z
        if (_1530113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2774");
        }

        // �o���ێ����Z
        switch (_1530115) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2780");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2781");
            break;
        }

        // Z2707 ���o�@�\�ێ��Ǘ��̐����Z
        if (_1530170 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2707");
        }

        // Z2710 �×{�^���o�@�\�ێ��Ǘ����Z
        if (_1530165 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2710");
        }

        // �×{�H���Z
        if (_1530114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
        }

        // �ݑ�A�x���@�\���Z
        if (_1530118 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2778");
        }

        switch (_1530166) {
        case 2:
            // Z2708 �×{�^�F�m�ǐ��P�A���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z2708");
            break;
        case 3:
            // Z2709 �×{�^�F�m�ǐ��P�A���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z2709");
            break;
        }

        // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        if (_1530169 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2779");
        }

        switch (_1530167) {
        case 2:
            // Z2701 �×{�^�T�[�r�X�񋟑̐����ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z2701");
            break;
        case 3:
            // Z2702 �×{�^�T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z2702");
            break;
        case 4:
            // Z2703 �×{�^�T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z2703");
            break;
        }

        // ���E���������P��ԋp
        switch (_17) {
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

            // 2006/07/14 �×{�^�Ή�
            // ���s�I�މ@�T�[�r�X�̏ꍇ�͐H����Z��
            if (_1530119 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }

            // �H����
            if (_1530159 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }

            // �O�����Z
            if (_1530108 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // �؍ݔ� --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }// �`�F�b�N�����Ă��Ȃ��ꍇ�͉����Ԃ��Ȃ�

        // ���Ȏ�f���������ꍇ�͈ꗥ���Ȏ�M�̃R�[�h��Ԃ�
        // �O�̂��ߊO�����D�悷��B
        if (_1530110 > 1) {
            // �����T�[�r�X�R�[�h��������
            // �h�{�}�l�W�����g���Z�E�h�{�Ǘ��̐����Z�E�H��E�z�e���R�X�g�ȊO�͍폜����B
            for (int i = sysSvcCdItems.size() - 1; i >= 0; i--) {
                Map<String, String> serviceMap = new HashMap<String, String>();
                // ���R�[�h�擾
                serviceMap = sysSvcCdItems.get(i);
                // �Z��\�ȃ��R�[�h�ł���ꍇ�͍폜���Ȃ�
                // ���Ȏ�f���Z�Z�莞�ɍ폜�ΏۊO�Ƃ�����Z�ɁA�o���ڍs���Z�E�×{�H���Z�E�o���ێ����Z��ǉ�����B
                String tempItem = ACCastUtilities.toString(
                        serviceMap.get("SYSTEM_SERVICE_CODE_ITEM"), "");
                if (!"Z2773".equals(tempItem) && !"Z2771".equals(tempItem)
                        && !"Z2772".equals(tempItem)
                        && !SERVICE_CODE_SHOKUHI.equals(tempItem)
                        && !SERVICE_CODE_NORMAL_ROOM.equals(tempItem)
                        && !SERVICE_CODE_TASHO_ROOM.equals(tempItem)
                        && !SERVICE_CODE_UNIT_ROOM.equals(tempItem)
                        && !SERVICE_CODE_UNIT_SEMI_ROOM.equals(tempItem)
                        && !"Z2774".equals(tempItem)
                        && !"Z2775".equals(tempItem)
                        && !"Z2780".equals(tempItem)
                        && !"Z2781".equals(tempItem)) {
                    sysSvcCdItems.remove(i);
                }
            }

            // ���Ȏ�f�ɂ�����T�[�r�X�R�[�h��ǉ�
            putSystemServiceCodeItem(sysSvcCdItems, "Z2831");

            // ���E���������P��ԋp
            switch (_17) {
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

            // �l��Ԃ�
            return sysSvcCdItems;

        }

        // �O�������肾�����ꍇ�͈ꗥ�O���̃R�[�h��Ԃ�
        if (_1530108 > 1) {
            // ��������҂ł���ꍇ�̓z�e���R�X�g��ǉ�����
            if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
                // �����T�[�r�X�R�[�h��������
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // �O���ɂ�����T�[�r�X�R�[�h��ǉ�
            putSystemServiceCodeItem(sysSvcCdItems, "Z2830");

            // ���E���������P��ԋp
            switch (_17) {
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

            // �l��Ԃ�
            return sysSvcCdItems;
        }

        // 2006/07/05 �×{�^�Ή�
        // 1530119 ���s�I�މ@�T�[�r�X��
        // ���s�I�މ@�����肾�����ꍇ�͈ꗥ���s�I�މ@�̃R�[�h��Ԃ�
        if (_1530119 > 1) {
            // ��������҂ł���ꍇ�͏��������s��Ȃ��@���؍ݔ��Ԃ��K�v�����邽��
            if ("1".equals(map.get("7")) || new Integer(1).equals(map.get("7"))) {
                // �����T�[�r�X�R�[�h��������
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // ���s�I�މ@�ɂ�����R�[�h��ǉ�
            putSystemServiceCodeItem(sysSvcCdItems, "Z5258");

            // ���E���������P��ԋp
            switch (_17) {
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
                if (this._1530161 <= 0) {
                    // �H�0�~�ȉ��̏ꍇ
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                } else {
                    // �H�0�~�ȉ��łȂ��ꍇ
                    // �H����Ɩ�����n���ꂽ�l�ŏ㏑������B
                    mp.put("SERVICE_UNIT", new Integer(this._1530161));
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
