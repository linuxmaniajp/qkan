package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �����^�T�[�r�X�i�Ō쏬�K�͑��@�\�^������E�Z�����p�ȊO�j
 * 
 * @since V7.0.0
 * @author Shinobu Hitaka
 * 
 */
public class SC_17711_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�����^�T�[�r�X(�Ō쏬�K�͑��@�\�^������E�Z�����p�ȊO)";
    }

    public String getServiceCodeKind() {
        return "77";
    }

    public String getSystemServiceKindDetail() {
        return "17711";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        // ���炩�ɗv���x�����������ꍇ�͋��Ԃ�
        switch (_1) {
        case 1: // ����
        case 3: // �v�x���P
        case 4: // �v�x���Q
        case 10: // ���ƑΏێ�
            return new ArrayList<HashMap<String, String>>();
        }

        // 1770101 �l�����Z
        int _1770101 = getIntValue(map, "1770101", 1);

        // 1770102 �ߏ��T�[�r�X�ɑ΂��錸�Z
        int _1770102 = getIntValue(map, "1770102", 1);

        // 1770104 �������Z
        int _1770104 = getIntValue(map, "1770104", 1);

        // 1770105 �F�m�ǉ��Z
        int _1770105 = getIntValue(map, "1770105", 1);

        // 1770106 �މ@�������w�����Z
        int _1770106 = getIntValue(map, "1770106", 1);

        // 1770107 ���ƊJ�n���x�����Z
        int _1770107 = getIntValue(map, "1770107", 1);

        // 1770108 �ً}���K��Ō���Z
        int _1770108 = getIntValue(map, "1770108", 1);

        // 1770109 ���ʊǗ����Z
        int _1770109 = getIntValue(map, "1770109", 1);

        // 1770110 �^�[�~�i���P�A���Z
        int _1770110 = getIntValue(map, "1770110", 1);

        // 1770111 �T�[�r�X�񋟑̐��������Z
        int _1770111 = getIntValue(map, "1770111", 1);

        // 1770112 �����^�s�����Ǝ����Z
        int _1770112 = getIntValue(map, "1770112", 1);

        // 1770113 �K��Ō쌸�Z 1-�Ȃ� 2-����
        int _1770113 = getIntValue(map, "1770113", 1);

        // 1770114 �K��Ō���ʎw�����Z 1-�Ȃ� 2-����
        int _1770114 = getIntValue(map, "1770114", 1);

        // 1770115 �����@1-�����łȂ� 2-�����ł���
        int _1770115 = getIntValue(map, "1770115", 1);
        
        // 1770118 �K��Ō�̐����Z 1-�Ȃ� 2-���� 2015.04
        int _1770118 = getIntValue(map, "1770118", 1);
        
        // 1770119 �K��Ō�̐��������Z 1-�Ȃ� 2-���� 2015.04
        int _1770119 = getIntValue(map, "1770119", 1);

        // 1770120 �����}�l�W�����g�̐��������Z 1-�Ȃ� 2-���� 2015.04
        int _1770120 = getIntValue(map, "1770120", 1);
        
        // 16 ����̌����ɋ��Z���闘�p�� 1-�Ȃ� 2-���� 2015.04
        int _16 = getIntValue(map, "16", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // ���Z�̂�(�މ@�������w�����Z�Ή�)
        int _9 = getIntValue(map, "9");

        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if (_9 == 2) {
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // 1770104 �������Z
            if (_1770104 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
            }

            // �K��Ō���ʎw�����Z 1-�Ȃ� 2-����
            if (_1770114 > 1) {
                // �v���x���m�F
                switch (_1) {
                case 5: // �v���P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6011");
                    break;
                case 6: // �v���Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6012");
                    break;
                case 7: // �v���R
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6013");
                    break;
                case 8: // �v���S
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6014");
                    break;
                case 9: // �v���T
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6015");
                    break;
                }
            }

            // 1770106 �މ@�������w�����Z
            if (_1770106 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
            }

            // 1770110 �^�[�~�i���P�A���Z
            if (_1770110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            }

            // ���E���������P��ԋp
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6114");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6112");
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                break;
            }

            return sysSvcCdItems;
        }

        // �Ǝ��R�[�h����
        // =========================================================================
        StringBuilder sb = new StringBuilder();

        // ����̌����ɋ��Z���闘�p�� 
        sb.append(CODE_CHAR[_16]);        //2015.04

        // �v���x
        sb.append(CODE_CHAR[_1]);
        
        // �ߏ��T�[�r�X�ɑ΂��錸�Z
        sb.append(CODE_CHAR[_1770102]);

        // �l�����Z
        sb.append(CODE_CHAR[_1770101]);

        // ������
        sb.append(CODE_CHAR[_1770115]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
        

        // ���Z
        // =========================================================================

        // �K��Ō���ʎw�����Z 1-�Ȃ� 2-����
        if (_1770114 > 1) {
            // �v���x���m�F
            switch (_1) {
            case 5: // �v���P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6011");
                break;
            case 6: // �v���Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6012");
                break;
            case 7: // �v���R
                putSystemServiceCodeItem(sysSvcCdItems, "Z6013");
                break;
            case 8: // �v���S
                putSystemServiceCodeItem(sysSvcCdItems, "Z6014");
                break;
            case 9: // �v���T
                putSystemServiceCodeItem(sysSvcCdItems, "Z6015");
                break;
            }
        }

        // 1770104 �������Z
        if (_1770104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }

        // 1770105 �F�m�ǉ��Z
        switch (_1770105) {
        // �����^�F�m�ǉ��ZI
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            break;
        // �����^�F�m�ǉ��ZII
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;

        }

        // 1770106 �މ@�������w�����Z
        if (_1770106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
        }

        // 1770107 ���ƊJ�n���x�����Z
        if (_1770107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6139");
        }

        // 1770108 �ً}���K��Ō���Z
        if (_1770108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3100");
        }

        // 1770109 ���ʊǗ����Z
        switch (_1770109) {
        case 2:
            // �����^���ʊǗ����ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
            break;
        case 3:
            // �����^���ʊǗ����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
            break;

        }

        // 1770110 �^�[�~�i���P�A���Z
        if (_1770110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
        }

        // 1770111 �T�[�r�X�񋟑̐��������Z
        switch (_1770111) {
        case 5:
            // �񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");//2015.04
            break;
        case 2:
            // �񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // �񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // �񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // 1770119 �K��Ō�̐��������Z 2015.04
        if (_1770119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4015");//2015.04
        }

        // 1770120 �����}�l�W�����g�̐��������Z 2015.04
        if (_1770120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4010");//2015.04
        }
        
        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6114");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            break;
        }

        // ������ł͂Ȃ��ꍇ
        if (_1770115 == 1) {
            // �K��Ō�̐����Z 2015.04
            if (_1770118 > 1) {
                // �v���x���m�F
                switch (_1) {
                case 5: // �v���P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6021");//2015.04
                    break;
                case 6: // �v���Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6023");//2015.04
                    break;
                case 7: // �v���R
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6025");//2015.04
                    break;
                case 8: // �v���S
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6027");//2015.04
                    break;
                case 9: // �v���T
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6029");//2015.04
                    break;
                }
            }
            
            // �K��Ō쌸�Z
            if (_1770113 > 1) {
                // �v���x���m�F
                switch (_1) {
                case 5: // �v���P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6001");
                    break;
                case 6: // �v���Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
                    break;
                case 7: // �v���R
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6005");
                    break;
                case 8: // �v���S
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6007");
                    break;
                case 9: // �v���T
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6009");
                    break;
                }
            }

            // �����^�s�����Ǝ����Z
            switch (_1770112) {
            case 2:
                // �����^�s�����Ǝ����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z7101");
                break;
            case 3:
                // �����^�s�����Ǝ����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z7103");
                break;
            case 4:
                // �����^�s�����Ǝ����Z�R
                putSystemServiceCodeItem(sysSvcCdItems, "Z7105");
                break;
            case 5:
                // �����^�s�����Ǝ����Z�S
                putSystemServiceCodeItem(sysSvcCdItems, "Z7107");
                break;
            case 6:
                // �����^�s�����Ǝ����Z�T
                putSystemServiceCodeItem(sysSvcCdItems, "Z7109");
                break;
            case 7:
                // �����^�s�����Ǝ����Z�U
                putSystemServiceCodeItem(sysSvcCdItems, "Z7111");
                break;
            case 8:
                // �����^�s�����Ǝ����Z�V
                putSystemServiceCodeItem(sysSvcCdItems, "Z7113");
                break;
            case 9:
                // �����^�s�����Ǝ����Z�W
                putSystemServiceCodeItem(sysSvcCdItems, "Z7115");
                break;
            case 10:
                // �����^�s�����Ǝ����Z�X
                putSystemServiceCodeItem(sysSvcCdItems, "Z7117");
                break;
            case 11:
                // �����^�s�����Ǝ����Z�P�O
                putSystemServiceCodeItem(sysSvcCdItems, "Z7119");
                break;
            case 12:
                // �����^�s�����Ǝ����Z�P�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z7121");
                break;
            case 13:
                // �����^�s�����Ǝ����Z�P�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z7123");
                break;
            case 14:
                // �����^�s�����Ǝ����Z�P�R
                putSystemServiceCodeItem(sysSvcCdItems, "Z7125");
                break;
            case 15:
                // �����^�s�����Ǝ����Z�P�S
                putSystemServiceCodeItem(sysSvcCdItems, "Z7127");
                break;
            case 16:
                // �����^�s�����Ǝ����Z�P�T
                putSystemServiceCodeItem(sysSvcCdItems, "Z7129");
                break;
            case 17:
                // �����^�s�����Ǝ����Z�P�U
                putSystemServiceCodeItem(sysSvcCdItems, "Z7131");
                break;
            case 18:
                // �����^�s�����Ǝ����Z�P�V
                putSystemServiceCodeItem(sysSvcCdItems, "Z7133");
                break;
            case 19:
                // �����^�s�����Ǝ����Z�P�W
                putSystemServiceCodeItem(sysSvcCdItems, "Z7135");
                break;
            case 20:
                // �����^�s�����Ǝ����Z�P�X
                putSystemServiceCodeItem(sysSvcCdItems, "Z7137");
                break;
            case 21:
                // �����^�s�����Ǝ����Z�Q�O
                putSystemServiceCodeItem(sysSvcCdItems, "Z7139");
                break;
            }

            // ������̏ꍇ
        } else {
            // �K��Ō�̐����Z���� 2015.04
            if (_1770118 > 1) {
                // �v���x���m�F
                switch (_1) {
                case 5: // �v���P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6022");//2015.04
                    break;
                case 6: // �v���Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6024");//2015.04
                    break;
                case 7: // �v���R
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6026");//2015.04
                    break;
                case 8: // �v���S
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6028");//2015.04
                    break;
                case 9: // �v���T
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6030");//2015.04
                    break;
                }
            }
            
            // �K��Ō쌸�Z����
            if (_1770113 > 1) {
                // �v���x���m�F
                switch (_1) {
                case 5: // �v���P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6002");
                    break;
                case 6: // �v���Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6004");
                    break;
                case 7: // �v���R
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6006");
                    break;
                case 8: // �v���S
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6008");
                    break;
                case 9: // �v���T
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6010");
                    break;
                }
            }

            // �����^�s�����Ǝ����Z
            switch (_1770112) {
            case 2:
                // �����^�s�����Ǝ����Z�P����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7102");
                break;
            case 3:
                // �����^�s�����Ǝ����Z�Q����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7104");
                break;
            case 4:
                // �����^�s�����Ǝ����Z�R����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7106");
                break;
            case 5:
                // �����^�s�����Ǝ����Z�S����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7108");
                break;
            case 6:
                // �����^�s�����Ǝ����Z�T����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7110");
                break;
            case 7:
                // �����^�s�����Ǝ����Z�U����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7112");
                break;
            case 8:
                // �����^�s�����Ǝ����Z�V����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7114");
                break;
            case 9:
                // �����^�s�����Ǝ����Z�W����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7116");
                break;
            case 10:
                // �����^�s�����Ǝ����Z�X����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7118");
                break;
            case 11:
                // �����^�s�����Ǝ����Z�P�O����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7120");
                break;
            case 12:
                // �����^�s�����Ǝ����Z�P�P����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7122");
                break;
            case 13:
                // �����^�s�����Ǝ����Z�P�Q����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7124");
                break;
            case 14:
                // �����^�s�����Ǝ����Z�P�R����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7126");
                break;
            case 15:
                // �����^�s�����Ǝ����Z�P�S����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7128");
                break;
            case 16:
                // �����^�s�����Ǝ����Z�P�T����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7130");
                break;
            case 17:
                // �����^�s�����Ǝ����Z�P�U����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7132");
                break;
            case 18:
                // �����^�s�����Ǝ����Z�P�V����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7134");
                break;
            case 19:
                // �����^�s�����Ǝ����Z�P�W����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7136");
                break;
            case 20:
                // �����^�s�����Ǝ����Z�P�X����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7138");
                break;
            case 21:
                // �����^�s�����Ǝ����Z�Q�O����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7140");
                break;
            }

        }

        return sysSvcCdItems;
    }
}
