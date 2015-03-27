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
 * �n�斧���^��앟���{��
 * 
 * @since V7.0.0
 * @author Shinobu Hitaka
 * 
 */
public class SC_15411_201504 extends Qkan10011_ServiceUnitGetter {
    private int _1540121 = 0;

    private final String PATH_UNIT_ROOM = "1540121";
    private final String PATH_UNIT_SEMI_ROOM = "1540122";
    private final String PATH_NORMAL_ROOM = "1540123";
    private final String PATH_TASHO_ROOM = "1540124";

    private int byoshitsu = 0;

    public String getServiceName() {
        return "�n�斧���^��앟���{��";
    }

    public String getServiceCodeKind() {
        return "54";
    }

    public String getSystemServiceKindDetail() {
        return "15411 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        // 1540101 �{�݋敪 1-��앟���{�� 3-���j�b�g�^��앟���{��
        int _1540101 = getIntValue(map, "1540101");

        // 1540102 �o�ߓI�n�斧���T�[�r�X
        int _1540102 = getIntValue(map, "1540102");

        // 1540128 ���[�u�����ҋ敪
        int _8 = getIntValue(map, "8");

        // 1540103 �a���敪(�]���^) 1-�]���^�� 2-������
        int _1540103 = getIntValue(map, "1540103");

        // 1540104 �a���敪(���j�b�g�^) 1-���j�b�g�^�� 2-���j�b�g�^����
        int _1540104 = getIntValue(map, "1540104");

        // �a���𔻒�
        if (_1540101 > 1) {
            // ���j�b�g�^
            byoshitsu = convertByoshitsuKbn(_1540104, true);
        } else {
            // �ʏ�
            byoshitsu = convertByoshitsuKbn(_1540103, false);
        }

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1540107 ��ԋΖ������ 1-�������Ă��� 2-�������Ă��Ȃ�
        int _1540107 = getIntValue(map, "1540107");

        // 1540119 �l�����Z 1-�Ȃ� 2-������� 3-�Ō�E���E�����͉��x�������s��
        int _1540119 = getIntValue(map, "1540119");

        // 1540105 ���j�b�g�P�A�̐��� 1-������ 2-����
        int _1540105 = getIntValue(map, "1540105");

        // 1540106 �����j�b�g�P�A���Z 1-�Ȃ� 2-����
        int _1540106 = getIntValue(map, "1540106");

        // 1540108 �ʋ@�\�P���w�����Z 1-�Ȃ� 2-����
        int _1540108 = getIntValue(map, "1540108");

        // 1540109 ��t��Ή��Z 1-�Ȃ� 2-����
        int _1540109 = getIntValue(map, "1540109");

        // 1540110 ���_�Ȉ�w�����Z 1-�Ȃ� 2-����
        int _1540110 = getIntValue(map, "1540110");

        // 1540111 ��Q�Ґ�����������Ή��Z 1-�Ȃ� 2-����
        int _1540111 = getIntValue(map, "1540111");

        // 1540123 �g�̍S���p�~�����{���Z 1-�Ȃ� 2-����
        int _1540123 = getIntValue(map, "1540123");

        // 1540112 �O�����Z 1-�Ȃ� 2-����
        int _1540112 = getIntValue(map, "1540112");

        // 1540113 �������Z 1-�Ȃ� 2-����
        int _1540113 = getIntValue(map, "1540113");

        // 3020102 �ޏ������k�������Z
        int _3020102 = getIntValue(map, "3020102");

        // 3020103 �ޏ��O�A�g���Z
        int _3020103 = getIntValue(map, "3020103");

        // 1540115 �h�{�}�l�W�����g���Z 1-�Ȃ� 2-����
        int _1540115 = getIntValue(map, "1540115");

        // 1540116 �o���ڍs���Z 1-�Ȃ� 2-����
        int _1540116 = getIntValue(map, "1540116");

        // 1540117 �o���ێ����Z�T
        int _1540117 = getIntValue(map, "1540117");

        // 1540141 �o���ێ����Z�U 2015.04
        int _1540141 = getIntValue(map, "1540141");

        // 1540118 �×{�H���Z 1-�Ȃ� 2-����
        int _1540118 = getIntValue(map, "1540118");

        // 1540134 �Ŏ������Z 1-�Ȃ� 2-���S���ȑO4���ȏ�30���ȉ� 3-���S���ȑO2������3�� 4-���S��
        int _1540134 = getIntValue(map, "1540134");

        // 1540125 �ݑ�A�x���@�\���Z 1-�Ȃ� 2-����
        int _1540125 = getIntValue(map, "1540125");

        // 1540126 �ݑ�E�������ݗ��p���Z 1-�Ȃ� 2-����
        int _1540126 = getIntValue(map, "1540126");

        // 1540127 ���K�͋��_�W���^�{�݉��Z 1-�Ȃ� 2-����
        int _1540127 = getIntValue(map, "1540127");

        // 1540120 �H���� 1-�Ȃ� 2-�O�H 3-�� 4-�� 5-�� 6-���� 7-���� 8-�钩
        int _1540120 = getIntValue(map, "1540120");

        // 1540121 �H��
        this._1540121 = getIntValue(map, "1540121");

        // 1540129 ���퐶���p���x�����Z
        int _1540129 = getIntValue(map, "1540129");

        // 1540137 �Ō�̐����Z�T
        int _1540137 = getIntValue(map, "1540137");

        // 1540138 �Ō�̐����Z�U
        int _1540138 = getIntValue(map, "1540138");

        // 1540131 ��ΐE���z�u���Z
        int _1540131 = getIntValue(map, "1540131");

        // 1540132 ��N���F�m�Ǔ����Ҏ�����Z
        int _1540132 = getIntValue(map, "1540132");

        // 1540133 ���o�q���Ǘ����Z
        int _1540133 = getIntValue(map, "1540133");

        // 1540135 �F�m�ǐ��P�A���Z
        int _1540135 = getIntValue(map, "1540135");

        // 1540136 �T�[�r�X�񋟑̐��������Z
        int _1540136 = getIntValue(map, "1540136");

        // 2006/05/15 �\�h���Ή�
        // �P�Ɖ��Z
        int _9 = getIntValue(map, "9");

        // 3020109 �ޏ��O�K��w�����Z
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 �ޏ���K��w�����Z
        int _3020110 = getIntValue(map, "3020110", 1);

        // 1540139 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1540139 = getIntValue(map, "1540139", 1);
        
        // 1540140 ���o�q���Ǘ��̐����Z
        int _1540140 = getIntValue(map, "1540140", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 2006/05/15 �\�h���Ή�
        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if (_9 == 2) {
            
            // �ޏ���K��w�����Z
            if (_3020110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6504");
            }
            
            // �Ō�̐����Z�̕��Z��ƍ��킹�ďC��
            // �Ŏ������Z
            switch (_1540134) {
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6276");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
                break;
            case 4:
                // 6283�@�n�����{�݊Ŏ������Z�R
                putSystemServiceCodeItem(sysSvcCdItems, "Z6283");
                break;
            }
            
            // ���E���������P��ԋp
            switch (_17) {
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

        // �{�݋敪 1-��앟���{�� 3-���j�b�g�^��앟���{��
        sb.append(CODE_CHAR[_1540101]);

        // �o�ߓI�n�斧���T�[�r�X
        sb.append(CODE_CHAR[_1540102]);

        // ���[�u�����ҋ敪
        sb.append(CODE_CHAR[_8]);
        
        // �a���敪(�]���^��/������)
        sb.append(CODE_CHAR[_1540103]);
        
        // �a���敪(���j�b�g�^��/���j�b�g�^����)
        sb.append(CODE_CHAR[_1540104]);
        
        // �v���x
        sb.append(CODE_CHAR[_1]);

        // ��ԋΖ������ 1-�������Ă��� 2-�������Ă��Ȃ�
        sb.append(CODE_CHAR[_1540107]);

        // �l�����Z 1-�Ȃ� 2-������� 3-�Ō�E���E�����͉��x�������s��
        sb.append(CODE_CHAR[_1540119]);

        // ���j�b�g�P�A�̐���
        switch (_1540101) {
        case 1: //��앟���{��
            sb.append(DEFAULT_CHAR);
            break;
        case 2: //���j�b�g�^��앟���{��
            // 1-������ 2-����
            if (_1540105 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        
        // 6132�@�n�����{�ݓ��퐶���p���x�����Z
        if (_1540129 > 1) {
        	
            // �{�ݓ��̋敪
            switch (_1540101) {
            
            // ��앟���{��
            case 1:
                // 6132�@�n�����{�ݓ��퐶���p���x�����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6132");//2015.04
                break;
                
            // ���j�b�g�^��앟���{��
            case 2:
                // 6135�@�n�����{�ݓ��퐶���p���x�����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6135");//2015.04
                break;
            }
        }
        
        // �Ō�̐����Z�T���I������Ă���ꍇ
        if (_1540137 > 1) {
            if (_1540102 == 2) {
                // 6114�@�n�����{�݊Ō�̐����ZI�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6114");
            } else {
                // 6113�@�n�����{�݊Ō�̐����ZI�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
            }
        }
        // �Ō�̐����Z�U���I������Ă���ꍇ
        if (_1540138 > 1) {
            if (_1540102 == 2) {
                // 6116�@�n�����{�݊Ō�̐����ZII�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6116");
            } else {
                // 6115�@�n�����{�݊Ō�̐����ZII�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
            }
        }
        
        // ��ΐE���z�u���Z
        if (_1540131 > 1) {
            
            // �{�ݓ��̋敪
            switch (_1540101) {
            
            // ��앟���{��
            case 1:
                // �o�ߓI�v���
                if (_1540102 == 2) {
                    // 6118�@�n�����{�ݖ�ΐE���z�u���ZI�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6118");
                } else {
                    // 6117�@�n�����{�ݖ�ΐE���z�u���ZI�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
                }
                break;
                
            // ���j�b�g�^��앟���{��
            case 2:
                // �o�ߓI�v���
                if (_1540102 == 2) {
                    // 6120�@�n�����{�ݖ�ΐE���z�u���ZII�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6120");
                } else {
                    // 6119�@�n�����{�ݖ�ΐE���z�u���ZII�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6119");
                }
                break;
            }
        }
        
        // �����j�b�g�P�A���Z 1-�Ȃ� 2-����
        if (_1540106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6002");
        }
        
        // �ʋ@�\�P���w�����Z 1-�Ȃ� 2-����
        if (_1540108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
        }
        
        // 6109�@�n�����{�ݎ�N���F�m�ǎ�����Z
        if (_1540132 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // ��t��Ή��Z 1-�Ȃ� 2-����
        if (_1540109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
        }
        
        // ���_�Ȉ�w�����Z 1-�Ȃ� 2-����
        if (_1540110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6200");
        }
        
        // ��Q�Ґ�����������Ή��Z 1-�Ȃ� 2-����
        if (_1540111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6250");
        }
        
        // �g�̍S���p�~�����{���Z 1-�Ȃ� 2-����
        if (_1540123 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6304");
        }
        
        // �O�����Z 1-�Ȃ� 2-����
        if (_1540112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }
        
        // �������Z 1-�Ȃ� 2-����
        if (_1540113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6400");
        }
        
        // 3020109 �ޏ��O�K��w�����Z
        if (_3020109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6501");
        }
        
        // 3020110 �ޏ���K��w�����Z
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
        
        // �h�{�}�l�W�����g���Z 1-�Ȃ� 2-����
        if (_1540115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
        }
        
        // �o���ڍs���Z 1-�Ȃ� 2-����
        if (_1540116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6274");
        }
        
        // �o���ێ����Z�T�^
        if (_1540117 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6281");
        }
        
        // �o���ێ����Z�U�^
        if (_1540141 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6282");
        }
        
        // ���o�q���Ǘ��̐����Z
        if (_1540140 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6122");
        }
        
        // ���o�q���Ǘ����Z
        if (_1540133 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }
        
        // �×{�H���Z 1-�Ȃ� 2-����
        if (_1540118 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
        }
        
        // �Ŏ������Z 1-�Ȃ� 2-���S���ȑO4���ȏ�30���ȉ� 3-���S���ȑO2������3�� 4-���S��
        switch (_1540134) {
        case 2:
            // �n�����{�݊Ŏ������Z�P
            putSystemServiceCodeItem(sysSvcCdItems, "Z6276");
            break;
        case 3:
            // �n�����{�݊Ŏ������Z�Q
            putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
            break;
        case 4:
            // 6283�@�n�����{�݊Ŏ������Z�R
            putSystemServiceCodeItem(sysSvcCdItems, "Z6283");
            break;
        }
        
        // �ݑ�A�x���@�\���Z 1-�Ȃ� 2-����
        if (_1540125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6278");
        }
        
        // �ݑ�E�������ݗ��p���Z 1-�Ȃ� 2-����
        if (_1540126 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6279");
        }
        
        // ���K�͋��_�W���^�{�݉��Z 1-�Ȃ� 2-����
        if (_1540127 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6280");
        }
        
        switch (_1540135) {
        case 2:
            // 6133�@�n�����{�ݔF�m�ǐ��P�A���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // 6134�@�n�����{�ݔF�m�ǐ��P�A���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }

        // 1540139 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        if (_1540139 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        
        switch (_1540136) {
        case 5:
            // 6104�@�n�����{�݃T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            // 6101�@�n�����{�݃T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102�@�n�����{�݃T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103�@�n�����{�݃T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }


        // ���E���������P��ԋp
        switch (_17) {
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
            // �H���� 1-�Ȃ� 2-�O�H 3-�� 4-�� 5-�� 6-���� 7-���� 8-�钩
            if (_1540120 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // �O�����Z����ł���ꍇ������
            if (_1540112 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // �؍ݔ� --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }

        // �O�������肾�����ꍇ�͈ꗥ�O���̃R�[�h��Ԃ�
        if (_1540112 > 1) {
            // ��������҂ł���ꍇ�͏����������
            if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
                // �����T�[�r�X�R�[�h��������
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // �O���ɂ�����T�[�r�X�R�[�h��ǉ�
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
            
            // ���E���������P��ԋp
            switch (_17) {
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
                if (this._1540121 <= 0) {
                    // �H�0�~�ȉ��̏ꍇ
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                } else {
                    // �H�0�~�ȉ��łȂ��ꍇ
                    // �H����Ɩ�����n���ꂽ�l�ŏ㏑������B
                    mp.put("SERVICE_UNIT", new Integer(this._1540121));
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
