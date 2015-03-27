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
 * ���×{�^��Î{��(�×{�a����L����f�Ï�)
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_15312_201504 extends Qkan10011_ServiceUnitGetter {
    private int _1530259 = 0;

    private final String PATH_UNIT_ROOM = "1530213";
    private final String PATH_UNIT_SEMI_ROOM = "1530214";
    private final String PATH_NORMAL_ROOM = "1530215";
    private final String PATH_TASHO_ROOM = "1530216";

    public String getServiceName() {
        return "���×{�^��Î{��(�×{�a����L����f�Ï�)";
    }

    public String getServiceCodeKind() {
        return "53";
    }

    public String getSystemServiceKindDetail() {
        return "15312";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1530201 �{�݋敪
        int _1530201 = getIntValue(map, "1530201");

        // 1530202 �l���z�u�敪
        int _1530202 = getIntValue(map, "1530202");
        
        // 1530218 �l���z�u�敪�i���j�b�g�^�a�@�×{�^�p�j
        int _1530218 = getIntValue(map, "1530218");

        // 1530203 �a���敪(�]���^)
        int _1530203 = getIntValue(map, "1530203");

        // 1530204 �a���敪(���j�b�g�^)
        int _1530204 = getIntValue(map, "1530204");

        // �a���敪
        int byoshitsu = 1;
        switch (_1530201) {
        case 1:
            byoshitsu = convertByoshitsuKbn(_1530203, false);
            break;
        case 2:
            byoshitsu = convertByoshitsuKbn(_1530204, true);
            break;
        }

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1530256 �l�����Z
        int _1530256 = getIntValue(map, "1530256");

        // 1530214 ���j�b�g�P�A�̐���
        int _1530214 = getIntValue(map, "1530214");

        // 1530205 �×{�����Z
        int _1530205 = getIntValue(map, "1530205");

        // 1530215 �g�̍S���p�~�����{���Z
        int _1530215 = getIntValue(map, "1530215");

        // 1530206 �O�����Z
        int _1530206 = getIntValue(map, "1530206");

        // 1530208 ���Ȏ�f���Z
        int _1530208 = getIntValue(map, "1530208");

        // 1530207 �������Z
        int _1530207 = getIntValue(map, "1530207");

        // 3020105 �ޏ����w�����Z
        int _3020105 = getIntValue(map, "3020105");

        // 3020106 �ޏ������񋟉��Z
        int _3020106 = getIntValue(map, "3020106");

        // 3020107 �ޏ��O�A�g���Z
        int _3020107 = getIntValue(map, "3020107");

        // 3020108 �V�l�K��Ō�w�����Z
        int _3020108 = getIntValue(map, "3020108");

        // 1530210 �h�{�}�l�W�����g���Z
        int _1530210 = getIntValue(map, "1530210");

        // 1530211 �o���ڍs���Z
        int _1530211 = getIntValue(map, "1530211");

        // 1530213 �o���ێ����ZI
        int _1530213 = getIntValue(map, "1530213");
        
        // 1530217 �o���ێ����ZII
        int _1530217 = getIntValue(map, "1530217");

        // 1530212 �×{�H���Z
        int _1530212 = getIntValue(map, "1530212");

        // 1530216 �ݑ�A�x���@�\���Z
        int _1530216 = getIntValue(map, "1530216");

        // 1530257 �H����
        int _1530257 = getIntValue(map, "1530257");

        // 1530259 �H��
        this._1530259 = getIntValue(map, "1530259");

        // 1530260 �ݔ�����Z 1-��^ 2-���Z�^
        int _1530260 = getIntValue(map, "1530260", 1);

        // 1530261 ���o�@�\�ێ��Ǘ����Z
        int _1530261 = getIntValue(map, "1530261", 1);

        // 1530262 ��N���F�m�Ǌ��Ҏ�����Z
        int _1530262 = getIntValue(map, "1530262", 1);

        // 1530263 �F�m�ǐ��P�A���Z
        int _1530263 = getIntValue(map, "1530263", 1);

        // 1530264 �T�[�r�X�񋟑̐��������Z
        int _1530264 = getIntValue(map, "1530264", 1);

        // �P�Ɖ��Z
        int _9 = getIntValue(map, "9");

        // 3020109 �ޏ�(�@)�O�K��w�����Z
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 �ޏ�(�@)��K��w�����Z
        int _3020110 = getIntValue(map, "3020110", 1);

        // 1530265 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1530265 = getIntValue(map, "1530265", 1);

        // 1530266 ���o�@�\�ێ��Ǘ��̐����Z
        int _1530266 = getIntValue(map, "1530266", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if (_9 == 2) {

            // �ޏ�(�@)��K��w�����Z
            if (_3020110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z3856");
            }

            // ���E���������P��ԋp
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3714");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3711");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3712");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3713");
                break;
            }

            return sysSvcCdItems;
        }
        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1530201]);

        // �l���z�u�敪�P
        if (_1530201 == 1) {
        	 sb.append(CODE_CHAR[_1530202]);
        } else {
            sb.append(DEFAULT_CHAR);
        }
        
        // �l���z�u�敪�Q
        if (_1530201 == 2) {
        	sb.append(CODE_CHAR[_1530218]);
        } else {
            sb.append(DEFAULT_CHAR);
        }

        // �a���敪(�]���^��/������)
        sb.append(CODE_CHAR[_1530203]);

        // �a�@�敪(���j�b�g�^��/���j�b�g�^����)
        sb.append(CODE_CHAR[_1530204]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �l�����Z
        sb.append(CODE_CHAR[_1530256]);

        // ���j�b�g�P�A�̐���
        switch (_1530201) {
        case 1: // �f�Ï�
            sb.append(DEFAULT_CHAR);
            break;
        case 2: // ���j�b�g�^
            if (_1530214 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // �ݔ�����Z
        if (_1530260 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3600");
        }

        // �×{�����Z
        if (_1530205 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3602");
        }

        // Z3704 �f�Ï��^��N���F�m�ǎ�����Z
        if (_1530262 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3704");
        }

        // �g�̍S���p�~�����{���Z
        if (_1530215 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3834");
        }

        // �O�����Z
        if (_1530206 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3830");
        }

        // ���Ȏ�f���Z
        if (_1530208 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3831");
        }

        // �������Z
        if (_1530207 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3840");
        }

        // �ޏ�(�@)�O�K��w�����Z
        if (_3020109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3851");
        }

        // �ޏ�(�@)��K��w�����Z
        if (_3020110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3856");
        }

        // �ޏ����w�����Z
        if (_3020105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3852");
        }

        // �ޏ������񋟉��Z
        if (_3020106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3854");
        }

        // �ޏ��O�A�g���Z
        if (_3020107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3855");
        }

        // �V�l�K��Ō�w�����Z
        if (_3020108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3853");
        }

        // �h�{�}�l�W�����g���Z
        if (_1530210 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3773");
        }

        // �o���ڍs���Z
        if (_1530211 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3774");
        }

        // �o���ێ����Z
        if (_1530213 > 1) {
            // �o���ێ����ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z3780");
        }
        if (_1530217 > 1) {
            // �o���ێ����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z3781");
        }
        
        // Z3707 ���o�@�\�ێ��Ǘ��̐����Z
        if (_1530266 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3707");
        }

        // Z3710 ���o�@�\�ێ��Ǘ����Z
        if (_1530261 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3710");
        }

        // �×{�H���Z
        if (_1530212 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
        }

        // �ݑ�A�x���@�\���Z
        if (_1530216 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3778");
        }

        switch (_1530263) {
        case 2:
            // Z3708 �f�Ï��^�F�m�ǐ��P�A���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z3708");
            break;
        case 3:
            // Z3709 �f�Ï��^�F�m�ǐ��P�A���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z3709");
            break;
        }

        // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        if (_1530265 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3779");
        }

        switch (_1530264) {
        case 5:
            // Z3705 �f�Ï��^�T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z3705");//2015.04
            break;
        case 2:
            // Z3701 �f�Ï��^�T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z3701");
            break;
        case 3:
            // Z3702 �f�Ï��^�T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z3702");
            break;
        case 4:
            // Z3703 �f�Ï��^�T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z3703");
            break;
        }

        // ���E���������P��ԋp
        switch (_17) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3714");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3711");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3712");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3713");
            break;
        }

        // ��������҃`�F�b�N�����Ă����ꍇ�͌��̒P�ʐ���ǉ�
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // �H����
            if (_1530257 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // �O�����Z�������ꍇ�͏���������
            if (_1530206 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // �؍ݔ� --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }// �`�F�b�N�����Ă��Ȃ��ꍇ�͉����Ԃ��Ȃ�

        // ���Ȏ�M���������ꍇ�͈ꗥ���Ȏ�M�̃R�[�h��Ԃ�
        // �O�̂��ߊO�����D�悷��B
        if (_1530208 > 1) {
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
                if (!"Z3771".equals(tempItem) && !"Z3772".equals(tempItem)
                        && !"Z3773".equals(tempItem)
                        && !SERVICE_CODE_SHOKUHI.equals(tempItem)
                        && !SERVICE_CODE_NORMAL_ROOM.equals(tempItem)
                        && !SERVICE_CODE_TASHO_ROOM.equals(tempItem)
                        && !SERVICE_CODE_UNIT_ROOM.equals(tempItem)
                        && !SERVICE_CODE_UNIT_SEMI_ROOM.equals(tempItem)
                        && !"Z3774".equals(tempItem)
                        && !"Z3775".equals(tempItem)
                        && !"Z3780".equals(tempItem)
                        && !"Z3781".equals(tempItem)) {
                    sysSvcCdItems.remove(i);
                }
            }

            // ���Ȏ�M�ɂ�����T�[�r�X�R�[�h��ǉ�
            putSystemServiceCodeItem(sysSvcCdItems, "Z3831");

            // ���E���������P��ԋp
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3714");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3711");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3712");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3713");
                break;
            }

            // �l��Ԃ�
            return sysSvcCdItems;

        }

        // �O�������肾�����ꍇ�͈ꗥ�O���̃R�[�h��Ԃ�
        if (_1530206 > 1) {
            // ����{�ݓ����ȊO�̏ꍇ�͏���������
            if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
                // �����T�[�r�X�R�[�h��������
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // �O���ɂ�����T�[�r�X�R�[�h��ǉ�
            putSystemServiceCodeItem(sysSvcCdItems, "Z3830");

            // ���E���������P��ԋp
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3714");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3711");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3712");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3713");
                break;
            }

            // �l��Ԃ�
            return sysSvcCdItems;
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
                if (this._1530259 <= 0) {
                    // �H�0�~�ȉ��̏ꍇ
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                } else {
                    // �H�0�~�ȉ��łȂ��ꍇ
                    // �H����Ɩ�����n���ꂽ�l�ŏ㏑������B
                    mp.put("SERVICE_UNIT", new Integer(this._1530259));
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
