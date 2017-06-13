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
 * ��앟���{��
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_15111_201504 extends Qkan10011_ServiceUnitGetter {
    private int _1510123 = 0;

    private final String PATH_UNIT_ROOM = "1510117";
    private final String PATH_UNIT_SEMI_ROOM = "1510118";
    private final String PATH_NORMAL_ROOM = "1510119";
    private final String PATH_TASHO_ROOM = "1510120";

    public String getServiceName() {
        return "��앟���{��";
    }

    public String getServiceCodeKind() {
        return "51";
    }

    public String getSystemServiceKindDetail() {
        return "15111 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1510101 �{�݋敪
        int _1510101 = getIntValue(map, "1510101");

        // 8 ���[�u������
        int _8 = getIntValue(map, "8");

        // 1510102 �a���敪(�]���^)
        int _1510102 = getIntValue(map, "1510102", 1);

        // 1510103 �a���敪(���j�b�g�^)
        int _1510103 = getIntValue(map, "1510103", 1);

        // �a���敪
        int byoshitsu = 1;
        switch (_1510101) {
        case 1:
        case 2:
            byoshitsu = convertByoshitsuKbn(_1510102, false);
            break;
        case 3:
        case 4:
            byoshitsu = convertByoshitsuKbn(_1510103, true);
            break;
        }

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // �o�ߑ[�u�Ή��p�ɗv�x���P�܂��͗v�x���Q�������ꍇ�͗v���P�Ƃ݂Ȃ�
        if (_1 == 3 || _1 == 4) {
            _1 = 5;
        }

        // 1510106 ��ԋΖ������
        int _1510106 = getIntValue(map, "1510106");

        // 1510120 �l�����Z
        int _1510120 = getIntValue(map, "1510120");

        // 1510124 ���j�b�g�P�A�̐���
        int _1510124 = getIntValue(map, "1510124");

        // 1510125 �����j�b�g�P�A���Z
        int _1510125 = getIntValue(map, "1510125");

        // 1510107 �ʋ@�\�P���w�����Z
        int _1510107 = getIntValue(map, "1510107");

        // 1510108 ��t��Ή��Z
        int _1510108 = getIntValue(map, "1510108");

        // 1510109 ���_�Ȉ�w�����Z
        int _1510109 = getIntValue(map, "1510109");

        // 1510110 ��Q�Ґ�����������Ή��Z
        int _1510110 = getIntValue(map, "1510110");

        // 1510128 �g�̍S���p�~�����{���Z
        int _1510128 = getIntValue(map, "1510128");

        // 1510111 �O�����Z
        int _1510111 = getIntValue(map, "1510111");

        // 1510112 �������Z
        int _1510112 = getIntValue(map, "1510112");

        // 3020102 �ޏ������k�������Z
        int _3020102 = getIntValue(map, "3020102");

        // 3020103 �ޏ��O�A�g���Z
        int _3020103 = getIntValue(map, "3020103");

        // 1510114 �h�{�}�l�W�����g���Z
        int _1510114 = getIntValue(map, "1510114");

        // 1510115 �o���ڍs���Z
        int _1510115 = getIntValue(map, "1510115");

        // 1510126 �o���ێ����ZI
        int _1510126 = getIntValue(map, "1510126");
        
        // 1510146 �o���ێ����ZII
        int _1510146 = getIntValue(map, "1510146");

        // 1510116 �×{�H���Z
        int _1510116 = getIntValue(map, "1510116");

        // 1510130 �ݑ�A�x���@�\���Z
        int _1510130 = getIntValue(map, "1510130");

        // 1510131 �ݑ�E�������ݗ��p���Z
        int _1510131 = getIntValue(map, "1510131");

        // 1510121 �H����
        int _1510121 = getIntValue(map, "1510121");

        // 1510123 �H��
        this._1510123 = getIntValue(map, "1510123");

        // 1510133 ���퐶���p���x�����Z
        int _1510133 = getIntValue(map, "1510133");

        // 1510142 �Ō�̐����Z�T�^
        int _1510142 = getIntValue(map, "1510142");

        // 1510143 �Ō�̐����Z�U�^
        int _1510143 = getIntValue(map, "1510143");

        // 1510135 ��ΐE���z�u���Z
        int _1510135 = getIntValue(map, "1510135");

        // 1510136 �������
        int _1510136 = getIntValue(map, "1510136");

        // 1510137 ��N���F�m�Ǔ����Ҏ�����Z
        int _1510137 = getIntValue(map, "1510137");

        // 1510138 ���o�@�\�ێ��Ǘ����Z
        int _1510138 = getIntValue(map, "1510138");

        // 1510139 �Ŏ������Z
        int _1510139 = getIntValue(map, "1510139");

        // 1510140 �F�m�ǐ��P�A���Z
        int _1510140 = getIntValue(map, "1510140");

        // 1510141 �T�[�r�X�񋟑̐��������Z
        int _1510141 = getIntValue(map, "1510141");

        // �P�Ɖ��Z
        int _9 = getIntValue(map, "9");

        // 3020109 �ޏ��O�K��w�����Z
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 �ޏ���K��w�����Z
        int _3020110 = getIntValue(map, "3020110", 1);

        // 1510144 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1510144 = getIntValue(map, "1510144", 1);

        // 1510145 ���o�@�\�ێ��Ǘ��̐����Z
        int _1510145 = getIntValue(map, "1510145", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if (_9 == 2) {
            // �Ŏ������Z
            switch (_1510139) {
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6276");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
                break;
            case 4:
                // 6283 �����{�݊Ŏ������Z�R
                putSystemServiceCodeItem(sysSvcCdItems, "Z6283");
                break;
            }
            
            // �����{�ݑޏ���K�⑊�k�������Z
            if (_3020110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6504");
            }

            // ���E���������P��ԋp
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
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

            return sysSvcCdItems;
        }

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1510101]);

        // �a���敪(�]���^��/������)
        sb.append(CODE_CHAR[_1510102]);

        // ���[�u������
        sb.append(CODE_CHAR[_8]);

        // �a���敪(���j�b�g�^��/���j�b�g�^����)
        sb.append(CODE_CHAR[_1510103]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // ��ԋΖ������
        sb.append(CODE_CHAR[_1510106]);

        // �l�����Z
        sb.append(CODE_CHAR[_1510120]);

        // ���j�b�g�P�A�̐���
        switch (_1510101) {
        case 1: // ���E������
        case 2:
            sb.append(DEFAULT_CHAR);
            break;
        case 3: // ���j�b�g�^
        case 4:
            // 1-������ 2-����
            if (_1510124 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // Z6132 �����{�ݓ��퐶���p���x�����Z
        if (_1510133 > 1) {
            // �{�݋敪�ɂ�镪��
            switch (_1510101) {
            case 1:
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6132");
                break;
            case 3:
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6135");//2015.04
                break;
            }
        }

        // �����{�݊Ō�̐����Z I�^
        if (_1510142 > 1) {
            // ��������ŕ���
            switch (_1510136) {
            case 1: // 31�l�ȏ�50�l�ȉ�
                // Z6113 �����{�݊Ō�̐����ZI�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
                break;
            case 2: // 30�l����51�l�ȏ�
                // Z6114 �����{�݊Ō�̐����ZI�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6114");
                break;
            }
        }

        // �����{�݊Ō�̐����Z II�^
        if (_1510143 > 1) {
            // ��������ŕ���
            switch (_1510136) {
            case 1: // 31�l�ȏ�50�l�ȉ�
                // Z6115 �����{�݊Ō�̐����ZII�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
                break;
            case 2: // 30�l����51�l�ȏ�
                // Z6116 �����{�݊Ō�̐����ZII�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6116");
                break;
            }
        }

        // ��ΐE���z�u���Z
        if (_1510135 > 1) {
            // �{�݋敪�ɂ�镪��
            switch (_1510101) {
            case 1:
            case 2:
                // ��������ŕ���
                switch (_1510136) {
                case 1: // 31�l�ȏ�50�l�ȉ�
                    // Z6117 �����{�ݖ�ΐE���z�u���ZI�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
                    break;
                case 2: // 30�l����51�l�ȏ�
                    // Z6118 �����{�ݖ�ΐE���z�u���ZI�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6118");
                    break;
                }
                break;
            case 3:
            case 4:
                // ��������ŕ���
                switch (_1510136) {
                case 1: // 31�l�ȏ�50�l�ȉ�
                    // Z6119 �����{�ݖ�ΐE���z�u���ZII�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6119");
                    break;
                case 2: // 30�l����51�l�ȏ�
                    // Z6120 �����{�ݖ�ΐE���z�u���ZII�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6120");
                    break;
                }
                break;
            }

        }

        // �����j�b�g�P�A���Z
        if (_1510125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6002");
        }

        // �ʋ@�\�P���w�����Z
        if (_1510107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
        }

        // Z6109 �����{�ݎ�N���F�m�ǎ�����Z
        if (_1510137 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }

        // ��t��Ή��Z
        if (_1510108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
        }

        // ���_�Ȉ�w�����Z
        if (_1510109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6200");
        }

        // ��Q�Ґ�����������Ή��Z
        if (_1510110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6250");
        }

        // �g�̍S���p�~�����{���Z
        if (_1510128 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6304");
        }

        // �O�����Z
        if (_1510111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }

        // �������Z
        if (_1510112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6400");
        }

        // �ޏ��O�K�⑊�k�������Z
        if (_3020109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6501");
        }

        // �����{�ݑޏ���K�⑊�k�������Z
        if (_3020110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6504");
        }

        // �ޏ������k�������Z
        if (_3020102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
        }

        // �ޏ��O�A�g���Z
        if (_3020103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6503");
        }

        // �h�{�}�l�W�����g���Z
        if (_1510114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
        }

        // �o���ڍs���Z
        if (_1510115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6274");
        }

        // �o���ێ����Z
        if (_1510126 > 1) {
        	// �����{�݌o���ێ����ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6280");
        }
        if (_1510146 > 1) {
        	// �����{�݌o���ێ����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6281");
        }

        // ���o�@�\�ێ��Ǘ��̐����Z
        if (_1510145 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6122");
        }

        // ���o�@�\�ێ��Ǘ����Z
        if (_1510138 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }

        // �×{�H���Z
        if (_1510116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
        }

        // �Ŏ������Z
        switch (_1510139) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6276");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
            break;
        case 4:
            // 6283 �����{�݊Ŏ������Z�R
            putSystemServiceCodeItem(sysSvcCdItems, "Z6283");
            break;
        }

        // �ݑ�A�x���@�\���Z
        if (_1510130 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6278");
        }

        // �ݑ�E�������ݗ��p���Z
        if (_1510131 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6279");
        }

        // �F�m�ǐ��P�A���Z
        switch (_1510140) {
        case 2:
            // Z6133 �����{�ݔF�m�ǐ��P�A���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // Z6134 �����{�ݔF�m�ǐ��P�A���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }

        // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        if (_1510144 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }

        // �����{�݃T�[�r�X�񋟑̐����Z
        switch (_1510141) {
        case 5:
            // Z6107 �����{�݃T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            // Z6101 �����{�݃T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // Z6102 �����{�݃T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // Z6103 �����{�݃T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
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
            if (_1510121 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // ��������҂ŏ����O�����Z�����肾�����ꍇ
            if (_1510111 > 1) {
                // ����������
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // �؍ݔ� --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }// �`�F�b�N�����Ă��Ȃ��ꍇ�͉����Ԃ��Ȃ�

        // �O�������肾�����ꍇ�͈ꗥ�O���̃R�[�h��Ԃ�
        if (_1510111 > 1) {
            if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
                // �����T�[�r�X�R�[�h��������
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // �O���ɂ�����T�[�r�X�R�[�h��ǉ�
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");

            // ���E���������P��ԋp
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
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
                if (this._1510123 <= 0) {
                    // �H�0�~�ȉ��̏ꍇ
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                } else {
                    // �H�0�~�ȉ��łȂ��ꍇ
                    // �H����Ɩ�����n���ꂽ�l�ŏ㏑������B
                    mp.put("SERVICE_UNIT", new Integer(this._1510123));
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
            } else if (SERVICE_CODE_NEW_TASHO_ROOM.equals(val)) {
                // �������i�V�j�̃��R�[�h
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
