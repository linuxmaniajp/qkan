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
 * ����É@
 * 
 * @since V8.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_15511_201804 extends Qkan10011_ServiceUnitGetter {
    private int _1550137 = 0;

    private final String PATH_UNIT_ROOM = "1550122";
    private final String PATH_UNIT_SEMI_ROOM = "1550123";
    private final String PATH_NORMAL_ROOM = "1550124";
    private final String PATH_TASHO_ROOM = "1550125";

    public String getServiceName() {
        return "����É@";
    }

    public String getServiceCodeKind() {
        return "55";
    }

    public String getSystemServiceKindDetail() {
        return "15511";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        
        
        // 1550101 �{�݋敪
        int _1550101 = getIntValue(map, "1550101");

        // 1550102 �l���z�u�敪�iI�^�j
        int _1550102 = getIntValue(map, "1550102", 1);
        
        // 1550103 �l���z�u�敪�iII�^�j
        int _1550103 = getIntValue(map, "1550103");
        
        // 1550104 �l���z�u�敪�i���ʁj
        int _1550104 = getIntValue(map, "1550104");
        

        // 1550105 �a���敪(�]���^)
        int _1550105 = getIntValue(map, "1550105");

        // 1550106 �a���敪(���j�b�g�^)
        int _1550106 = getIntValue(map, "1550106");

        // �a���敪
        int byoshitsu = 1;
        switch (_1550101) {
        case 1:
        case 2:
        case 3:
            byoshitsu = convertByoshitsuKbn(_1550105, false);
            break;
        case 4:
        case 5:
        case 6:
            byoshitsu = convertByoshitsuKbn(_1550106, true);
            break;
        }

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1550107 ��ԋΖ������
        int _1550107 = getIntValue(map, "1550107");

        // 1550128 �l�����Z
        int _1550128 = getIntValue(map, "1550128");

        // 1550108 ���j�b�g�P�A�̐���
        int _1550108 = getIntValue(map, "1550108");
        
        // 1550109 �g�̍S���p�~�����{���Z
        int _1550109 = getIntValue(map, "1550109");

        // 1550110 �×{�����Z�i�L���j
        int _1550110 = getIntValue(map, "1550110");
        
        // 1550111 �×{�����Z�i�×{���j
        int _1550111 = getIntValue(map, "1550111");

        // 1550112 ��ԋΖ����Ō���Z
        int _1550112 = getIntValue(map, "1550112");

        // 1550113 ��N���F�m�Ǌ��Ҏ�����Z
        int _1550113 = getIntValue(map, "1550113");

        // 1550114 �O�����Z
        int _1550114 = getIntValue(map, "1550114");
        
        // 1550115 ���s�I�ޏ��T�[�r�X��
        int _1550115 = getIntValue(map, "1550115");

        // 1550116 ���Ȏ�f���Z
        int _1550116 = getIntValue(map, "1550116");

        // 1550117 �������Z
        int _1550117 = getIntValue(map, "1550117");
        
        // 1550118 �ē������h�{�A�g���Z
        int _1550118 = getIntValue(map, "1550118");
        
        // 1550119 �h�{�}�l�W�����g���Z
        int _1550119 = getIntValue(map, "1550119");
        
        // 1550120 ��h�{���X�N���P���Z
        int _1550120 = getIntValue(map, "1550120");
        
        // 1550121 �o���ڍs���Z
        int _1550121 = getIntValue(map, "1550121");

        // 1550122 �o���ێ����ZI
        int _1550122 = getIntValue(map, "1550122");
        
        // 1550123 �o���ێ����ZII
        int _1550123 = getIntValue(map, "1550123");
        
        // 1550124 ���o�q���Ǘ��̐����Z
        int _1550124 = getIntValue(map, "1550124", 1);

        // 1550125 ���o�q���Ǘ����Z
        int _1550125 = getIntValue(map, "1550125");
        
        // 1550126 �×{�H���Z
        int _1550126 = getIntValue(map, "1550126");
        
        // 1550127 �ݑ�A�x���@�\���Z
        int _1550127 = getIntValue(map, "1550127");
        
        // 3020109 �ޏ�(�@)�O�K��w�����Z
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 �ޏ�(�@)��K��w�����Z
        int _3020110 = getIntValue(map, "3020110", 1);
        
        // 3020105 �ޏ����w�����Z
        int _3020105 = getIntValue(map, "3020105");

        // 3020106 �ޏ������񋟉��Z
        int _3020106 = getIntValue(map, "3020106");

        // 3020107 �ޏ��O�A�g���Z
        int _3020107 = getIntValue(map, "3020107");

        // 3020108 �K��Ō�w�����Z
        int _3020108 = getIntValue(map, "3020108");

        // 1550129 �ً}�����ÊǗ�
        int _1550129 = getIntValue(map, "1550129");

        // 1550130 �F�m�ǐ��P�A���Z
        int _1550130 = getIntValue(map, "1550130");

        // 1550131 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1550131 = getIntValue(map, "1550131", 1);
        
        // 1550132 �d�x�F�m�ǎ����×{�̐����Z
        int _1550132 = getIntValue(map, "1550132");
        
        // 1550133 �ڍs�蒅�x�����Z
        int _1550133 = getIntValue(map, "1550133");
        
        // 1550134 �r���x�����Z
        int _1550134 = getIntValue(map, "1550134");
        
        // 1550135 �T�[�r�X�񋟑̐��������Z
        int _1550135 = getIntValue(map, "1550135");
        
        // 1550136 �H����
        int _1550136 = getIntValue(map, "1550136");

        // 1550137 �H��
        this._1550137 = getIntValue(map, "1550137");


        // �P�Ɖ��Z
        int _9 = getIntValue(map, "9");

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if (_9 == 2) {

            // �ޏ�(�@)��K��w�����Z
            if (_3020110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6507");
            }

            // ���E���������P��ԋp
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                break;
            }

            return sysSvcCdItems;
        }

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1550101]);

        // �l���z�u�敪�iI�^�j
        if (_1550101 == 1 || _1550101 == 4 || _1550101 == 5) {
        	 sb.append(CODE_CHAR[_1550102]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �l���z�u�敪�iII�^�j
        if (_1550101 == 2) {
        	sb.append(CODE_CHAR[_1550103]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �l���z�u�敪�i���ʁj
        if (_1550101 == 3 || _1550101 == 6) {
        	sb.append(CODE_CHAR[_1550104]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �a���敪(�]���^��/)
        sb.append(CODE_CHAR[_1550105]);

        // �a���敪(���j�b�g�^��/���j�b�g�^���I������)
        sb.append(CODE_CHAR[_1550106]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // ��ԋΖ������
        sb.append(CODE_CHAR[_1550107]);

        // �l�����Z
        sb.append(CODE_CHAR[_1550128]);

        // ���j�b�g�P�A�̐���
        switch (_1550101) {
        case 1: // ���E������
        case 2:
        case 3:
            sb.append(DEFAULT_CHAR);
            break;
        case 4: // ���j�b�g�^
        case 5:
        case 6:
            // 1-������ 2-����
            if (_1550108 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        
        // �g�̍S���p�~�����{���Z
        if (_1550109 > 1) {
            StringBuilder sb1 = new StringBuilder();
            // �v���t�B�b�N�X
            sb1.append(SYSTEM_SERVICE_CODE_PREFIX_SK);
            // �{�݋敪
            sb1.append(CODE_CHAR[_1550101]);
            // �l���z�u�敪�iI�^�j
            if (_1550101 == 1 || _1550101 == 4 || _1550101 == 5) {
            	 sb1.append(CODE_CHAR[_1550102]);
            } else {
            	sb1.append(DEFAULT_CHAR);
            }
            // �l���z�u�敪�iII�^�j
            if (_1550101 == 2) {
            	sb1.append(CODE_CHAR[_1550103]);
            } else {
            	sb1.append(DEFAULT_CHAR);
            }
            // �l���z�u�敪�i���ʁj
            if (_1550101 == 3 || _1550101 == 6) {
            	sb1.append(CODE_CHAR[_1550104]);
            } else {
            	sb1.append(DEFAULT_CHAR);
            }
            // �a���敪(�]���^��/������)
            sb1.append(CODE_CHAR[_1550105]);
            // �a���敪(���j�b�g�^��/���j�b�g�^���I������)
            sb1.append(CODE_CHAR[_1550106]);
            // �v���x
            sb1.append(CODE_CHAR[_1]);
            putSystemServiceCodeItem(sysSvcCdItems, sb1.toString());
        }
        
        // �×{�����Z�i�L���j
        switch (_1550110) {
        // �×{�^�×{�����Z�P
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6601");
            break;
        }
        
        // �×{�����Z�i�×{���j
        switch (_1550111) {
        // �×{�^�×{�����Z�Q
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6603");
            break;
        }

        // ��ԋΖ����Ō���Z
        switch (_1550112) {
        case 2:
            // ��ԋΖ����Ō���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6371");
            break;
        case 3:
            // ��ԋΖ����Ō���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6372");
            break;
        case 4:
            // ��ԋΖ����Ō���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6373");
            break;
        case 5:
        	// ��ԋΖ����Ō���ZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6374");
            break;
        }
        
        // ��N���F�m�Ǔ����Ҏ�����Z
        if (_1550113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }

        // �O�����Z
        if (_1550114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }

        // ���Ȏ�f���Z
        if (_1550116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6831");
        }

        // �������Z
        if (_1550117 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6400");
        }

        // �ē������h�{�A�g���Z
        if (_1550118 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6453");
        }
        
        // �h�{�}�l�W�����g���Z
        if (_1550119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
        }
                
        // ��h�{���X�N���P���Z
        if (_1550120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6854");
        }

        // �o���ڍs���Z
        if (_1550121 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6274");
        }
        
        // �o���ێ����Z
        if (_1550122 > 1) {
        	// �o���ێ����ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6280");
        }
        if (_1550123 > 1) {
        	// �o���ێ����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6281");
        }
        
        // ���o�q���Ǘ��̐����Z
        if (_1550124 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6122");
        }
        
        // ���o�q���Ǘ����Z
        if (_1550125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }
        
        // �×{�H���Z
        switch (_1550126) {
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
        
        // �ݑ�A�x���@�\���Z
        if (_1550127 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6278");
        }
        
        
        // �ޏ�(�@)�O�K��w�����Z
        if (_3020109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6501");
        }

        // �ޏ�(�@)��K��w�����Z
        if (_3020110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6507");
        }

        // �ޏ����w�����Z
        if (_3020105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
        }

        // �ޏ������񋟉��Z
        if (_3020106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6504");
        }

        // �ޏ��O�A�g���Z
        if (_3020107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6505");
        }

        // �K��Ō�w�����Z
        if (_3020108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6503");
        }

        // �ً}�����ÊǗ�
        if (_1550129 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6000");
        }

        switch (_1550130) {
        case 2:
            // �F�m�ǐ��P�A���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // �F�m�ǐ��P�A���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }

        // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        if (_1550131 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // �d�x�F�m�ǎ����×{�̐����Z        
        switch (_1550132) {
        case 2:
            if (_1 == 5 || _1 == 6) { // �v���1,2
                // �d�x�F�m�ǎ����×{�̐����ZI�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6351");
            } else if (_1 == 7 || _1 == 8 || _1 == 9) { // �v���3,4,5
                // �d�x�F�m�ǎ����×{�̐����ZI�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6352");
            }
            break;
        case 3:
            if (_1 == 5 || _1 == 6) { // �v���1,2
                // �d�x�F�m�ǎ����×{�̐����ZII�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6353");
            } else if (_1 == 7 || _1 == 8 || _1 == 9) { // �v���3,4,5
                // �d�x�F�m�ǎ����×{�̐����ZII�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6354");
            }
            break;
        }

        // �ڍs�蒅�x�����Z
        if (_1550133 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6451");
        }
        
        // �r���x�����Z
        if (_1550134 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6357");
        }
        
        
        switch (_1550135) {
        case 5:
        	// �T�[�r�X�񋟑̐����ZI�C�^
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            break;
        case 2:
            // �T�[�r�X�񋟑̐����ZI���^
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // �T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // �T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            break;
        }

        // ��������҃`�F�b�N�����Ă����ꍇ�͌��̒P�ʐ���ǉ�
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {

            // 2006/07/14 �×{�^�Ή�
            // ���s�I�މ@�T�[�r�X�̏ꍇ�͐H����Z��
            if (_1550115 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }

            // �H����
            if (_1550136 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }

            // �O�����Z
            if (_1550114 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // �؍ݔ� --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }// �`�F�b�N�����Ă��Ȃ��ꍇ�͉����Ԃ��Ȃ�

        // ���Ȏ�f���������ꍇ�͈ꗥ���Ȏ�M�̃R�[�h��Ԃ�
        // �O�̂��ߊO�����D�悷��B
        if (_1550116 > 1) {
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
                if (!"Z6273".equals(tempItem)
                        && !SERVICE_CODE_SHOKUHI.equals(tempItem)
                        && !SERVICE_CODE_NORMAL_ROOM.equals(tempItem)
                        && !SERVICE_CODE_TASHO_ROOM.equals(tempItem)
                        && !SERVICE_CODE_UNIT_ROOM.equals(tempItem)
                        && !SERVICE_CODE_UNIT_SEMI_ROOM.equals(tempItem)
                        && !"Z6274".equals(tempItem)
                        && !"Z6275".equals(tempItem)
                        && !"Z6280".equals(tempItem)
                        && !"Z6281".equals(tempItem)) {
                    sysSvcCdItems.remove(i);
                }
            }

            // ���Ȏ�f�ɂ�����T�[�r�X�R�[�h��ǉ�
            putSystemServiceCodeItem(sysSvcCdItems, "Z6831");

            // ���E���������P��ԋp
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                break;
            }

            // �l��Ԃ�
            return sysSvcCdItems;

        }

        // �O�������肾�����ꍇ�͈ꗥ�O���̃R�[�h��Ԃ�
        if (_1550114 > 1) {
            // ��������҂ł���ꍇ�̓z�e���R�X�g��ǉ�����
            if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
                // �����T�[�r�X�R�[�h��������
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // �O���ɂ�����T�[�r�X�R�[�h��ǉ�
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");

            // ���E���������P��ԋp
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                break;
            }

            // �l��Ԃ�
            return sysSvcCdItems;
        }

        // 2006/07/05 �×{�^�Ή�
        // 1530119 ���s�I�މ@�T�[�r�X��
        // ���s�I�މ@�����肾�����ꍇ�͈ꗥ���s�I�މ@�̃R�[�h��Ԃ�
        if (_1550115 > 1) {
            // ��������҂ł���ꍇ�͏��������s��Ȃ��@���؍ݔ��Ԃ��K�v�����邽��
            if ("1".equals(map.get("7")) || new Integer(1).equals(map.get("7"))) {
                // �����T�[�r�X�R�[�h��������
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // ���s�I�މ@�ɂ�����R�[�h��ǉ�
            putSystemServiceCodeItem(sysSvcCdItems, "Z6358");

            // ���E���������P��ԋp
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
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
                if (this._1550137 <= 0) {
                    // �H�0�~�ȉ��̏ꍇ
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                } else {
                    // �H�0�~�ȉ��łȂ��ꍇ
                    // �H����Ɩ�����n���ꂽ�l�ŏ㏑������B
                    mp.put("SERVICE_UNIT", new Integer(this._1550137));
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
