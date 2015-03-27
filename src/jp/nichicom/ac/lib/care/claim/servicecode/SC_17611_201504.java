/**
 * 
 */
package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �������E�����Ή��^�K����Ō��
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_17611_201504 extends Qkan10011_ServiceUnitGetter {

    public String getServiceName() {
        return "�������E�����Ή�����";
    }

    public String getServiceCodeKind() {
        return "76";
    }

    public String getSystemServiceKindDetail() {
        return "17611";
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
            return new ArrayList<HashMap<String, String>>();
        }

        // 1760101 �T�[�r�X��
        int _1760101 = getIntValue(map, "1760101", 1);

        // 1760102 �K��Ō�T�[�r�X�̒�
        int _1760102 = getIntValue(map, "1760102", 1);

        // 1760103 �Ō�E���敪
        int _1760103 = getIntValue(map, "1760103", 1);

        // 1760104 �������Z
        int _1760104 = getIntValue(map, "1760104", 1);

        // 1760105 �ً}���K��Ō���Z
        int _1760105 = getIntValue(map, "1760105", 1);

        // 1760106 ���ʊǗ����Z
        int _1760106 = getIntValue(map, "1760106", 1);

        // 3020111 �މ@�������w�����Z
        int _3020111 = getIntValue(map, "3020111", 1);

        // 1760107 �^�[�~�i���P�A���Z
        int _1760107 = getIntValue(map, "1760107", 1);

        // 1760108 �T�[�r�X�񋟑̐��������Z
        int _1760108 = getIntValue(map, "1760108", 1);
        
        // 1760109 �������s�����Ǝ����Z
        int _1760109 = getIntValue(map, "1760109", 1);
        
        // 1760110 �ʏ����p���Z
        int _1760110 = getIntValue(map, "1760110", 1);
        
        // 1760111 ����
        int _1760111 = getIntValue(map, "1760111", 1);
        
        // 1760112 �����}�l�W�����g�̐��������Z
        int _1760112 = getIntValue(map, "1760112", 1);

        // 12 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // 13 ���R�Ԓn�擙���K�͎��Ə����Z
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 2 ����n����Z
        int _2 = getIntValue(map, "2", 1);
        
        // 16 �W���Z��ɋ��Z���闘�p�҂̌��Z
        int _16 = getIntValue(map, "16", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // ���Z�̂�(�މ@�������w�����Z�Ή�)
        int _9 = getIntValue(map,"9");
        
        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // 3020111 �މ@�������w�����Z
            if (_3020111 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
            }

            // 1760107 �^�[�~�i���P�A���Z
            if (_1760107 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            }
            
            // [ID:0000768][Masahiko.Higuchi] add - begin �������Z�̉��Z�̂ݑΉ�
            // 1760104 �������Z
            if (_1760104 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
            }
            // [ID:0000768][Masahiko.Higuchi] add - end

            // ���E���������P��ԋp
            switch (_17) {
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
            
            return sysSvcCdItems;
        }
        
        
        // �Ǝ��R�[�h����
        // =========================================================================
        StringBuilder sb = new StringBuilder();

        // 1760101 �T�[�r�X��
        sb.append(CODE_CHAR[_1760101]);
        // 1760102 �K��Ō�w�����̒�
        sb.append(CODE_CHAR[_1760102]);
        // 1 �v���x
        sb.append(CODE_CHAR[_1]);
        // 1760103 �Ō�E���敪
        sb.append(CODE_CHAR[_1760103]);
        // ������
        sb.append(CODE_CHAR[_1760111]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // =========================================================================
        
        // 1760110 �ʏ����p���Z
        if (_1760110 > 1) {
            
            // �C(2)[��̌^�������A�K��Ō�T�[�r�X�񋟂���]
            if ((_1760101 == 1) && (_1760102 == 2)) {
                
                // �v���x����
                switch (_1) {
                case 5: // �v���x�P
                    // �������ʏ����p���Z�Q�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4106");
                    break;

                case 6: // �v���x�Q
                    // �������ʏ����p���Z�Q�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4107");
                    break;

                case 7: // �v���x�R
                    // �������ʏ����p���Z�Q�R
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4108");
                    break;

                case 8: // �v���x�S
                    // �������ʏ����p���Z�Q�S
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4109");
                    break;

                case 9: // �v���x�T
                    // �������ʏ����p���Z�Q�T
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4110");
                    break;
                }
                
                
            // �C(1)[��̌^�������A�K��Ō�T�[�r�X�񋟂Ȃ�]�A�܂��͘A�g�^�������
            } else {
                
                // �v���x����
                switch (_1) {
                case 5: // �v���x�P
                    // �������ʏ����p���Z�P�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4101");
                    break;

                case 6: // �v���x�Q
                    // �������ʏ����p���Z�P�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4102");
                    break;

                case 7: // �v���x�R
                    // �������ʏ����p���Z�P�R
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4103");
                    break;

                case 8: // �v���x�S
                    // �������ʏ����p���Z�P�S
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4104");
                    break;

                case 9: // �v���x�T
                    // �������ʏ����p���Z�P�T
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4105");
                    break;
                }
            }
            
        }
        
        // 1760105 �ً}���K��Ō���Z
        if (_1760105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3100");
        }
        
        // 1760106 ���ʊǗ����Z
        switch(_1760106) {
        // ���������ʊǗ����ZI
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
            break;
            
        // ���������ʊǗ����ZII
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
            break;
        }
        
        // 1760107 �^�[�~�i���P�A���Z
        if (_1760107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
        }
        
        // 1760104 �������Z
        if (_1760104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
        }
        
        // 3020111 �މ@�������w�����Z
        if (_3020111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
        }
        
        // 1760112 �����}�l�W�����g�̐��������Z
        if (_1760112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4010");//2015.04
        }
        
        
        // 1760108 �T�[�r�X�񋟑̐��������Z
        switch(_1760108) {
        // �������T�[�r�X�񋟑̐����ZI�C
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");//2015.04
            break;
        // �������T�[�r�X�񋟑̐����ZI��
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
            
        // �������T�[�r�X�񋟑̐����ZII
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
            
        // �������T�[�r�X�񋟑̐����ZIII
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        
        // ���E���������P��ԋp
        switch (_17) {
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
        
        // ������Ȃ�
        if (_1760111 == 1) {
        
            // ���ꌚ�����Z
            if (_16 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4111");//2015.04
            }
            
            // ���������ʒn��K��Ō���Z
            if (_2 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
            }
            
            // ������񏬋K�͎��Ə����Z
            if (_13 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
            }
            
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
            }
            
            
            // �������s�����Ǝ����Z �P�`�P�O(�R�[�h�I�ɂ�2�`11)
            switch(_1760109) {
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7101");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7103");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7105");
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7107");
                break;
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7109");
                break;
            case 7:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7111");
                break;
            case 8:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7113");
                break;
            case 9:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7115");
                break;
            case 10:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7117");
                break;
            case 11:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7119");
                break;
            }
        
        
        // �����肠��
        } else {
            
            // ���ꌚ�����Z����
            if (_16 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4112");//2015.04
            }
            
            // ���ʒn��K��Ō���Z����
            if (_2 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8001");
            }
            
            // ���K�͎��Ə����Z����
            if (_13 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8101");
            }
            
            // ���R�Ԓn�擙�񋟉��Z����
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8111");
            }
            
            // �������s�����Ǝ����Z �P�`�P�O(�R�[�h�I�ɂ�2�`11)
            switch(_1760109) {
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7102");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7104");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7106");
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7108");
                break;
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7110");
                break;
            case 7:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7112");
                break;
            case 8:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7114");
                break;
            case 9:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7116");
                break;
            case 10:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7118");
                break;
            case 11:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7120");
                break;
            }
        }
        
        
        return sysSvcCdItems;
    }
}
