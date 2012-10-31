package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �K��Ō�(���ی�)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_11311_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�K��Ō�(���ی�)";
    }

    public String getServiceCodeKind() {
        return "13";
    }

    public String getSystemServiceKindDetail() {
        return "11311";
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

        // 1130103 �{�݋敪
        int _1130103 = getIntValue(map, "1130103");

        // 1130111 ���ԋ敪
        int _1130111 = getIntValue(map, "1130111");

        // 1130104 �E���敪
        int _1130104 = getIntValue(map, "1130104");

        // 1130106 ���ԑ�
        int _1130106 = getIntValue(map, "1130106");

        // 1130114 �����ԖK����Z
        int _1130114 = getIntValue(map, "1130114", 1);

        // 1130112 �K��l��
        int _1130112 = getIntValue(map, "1130112");

        // 2 ���ʒn����Z
        int _2 = getIntValue(map, "2");

        // 1130108 �ً}���K��Ō���Z
        int _1130108 = getIntValue(map, "1130108");

        // 1130122 �ً}���K��Ō���Z�i�������p�j
        int _1130122 = getIntValue(map, "1130122");

        // 1130110 �^�[�~�i���P�A���Z
        int _1130110 = getIntValue(map, "1130110");

        // 13 ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə�
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 12 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // 1130113 �T�[�r�X�񋟑̐��������Z
        int _1130113 = getIntValue(map, "1130113");

        // 1130115 2�l�ڂ̖K�⎞��
        int _1130115 = getIntValue(map, "1130115", 1);

        // 1130116 ���ʊǗ����Z
        int _1130116 = getIntValue(map, "1130116", 1);

        // 1130117 ������Z
        int _1130117 = getIntValue(map, "1130117", 1);

        // 1130118 �މ@�������w�����Z
        int _1130118 = getIntValue(map, "1130118", 1);

        // 1130119 �Ō�E���A�g���Z
        int _1130119 = getIntValue(map, "1130119", 1);

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);

        // 1130120 �K��Ō���ʎw�����Z
        int _1130120 = getIntValue(map, "1130120", 1);

        // 1130121 1����2����z���Ď��{
        int _1130121 = getIntValue(map, "1130121", 1);
        
        // 1130123 ������
        int _1130123 = getIntValue(map, "1130123", 1);
        
        // ���Z�̂�(�މ@�������w�����Z�Ή�)
        int _9 = getIntValue(map,"9");
        
        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // �މ@�������w�����Z
            if (_1130118 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
            }
            
            return sysSvcCdItems;
        }
        

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1130103]);

        // ���ԋ敪
        sb.append(CODE_CHAR[_1130111]);

        // �E���敪
        sb.append(CODE_CHAR[_1130104]);

        // 1����2����z���Ď��{
        sb.append(CODE_CHAR[_1130121]);

        // ���ꌚ�����Z�҂ւ̃T�[�r�X��
        sb.append(CODE_CHAR[_16]);

        // ���ԑ�
        // �R�[�h�}�X�^�ɂ��킹�ϊ�
        if (_1130106 == 3) {
            _1130106 = 2;
        } else if (_1130106 == 4) {
            _1130106 = 3;
        }
        sb.append(CODE_CHAR[_1130106]);

        // �K��l��
        sb.append(CODE_CHAR[_1130112]);

        // 2�l�ڂ̖K�⎞��
        sb.append(CODE_CHAR[_1130115]);

        // �����ԖK��Ō���Z
        sb.append(CODE_CHAR[_1130114]);

        // �v���T�̎҂̏ꍇ
        if (_1 == 9) {
            // ���A�{�݋敪��3-�������̏ꍇ
            if (_1130103 == 3) {
                sb.append(CODE_CHAR[2]);
            } else {
                sb.append(DEFAULT_CHAR);
            }

        } else {
            sb.append(DEFAULT_CHAR);
        }
        
        // ������̏ꍇ
        switch (_1130103) {
        case 1: // �w��K��Ō�X�e�[�V����
        case 2: // �a�@���͐f�Ï�
            // ������R�[�h��
            sb.append(DEFAULT_CHAR);
            break;
        case 3: // �������E�����Ή��^�K����Ō�
            sb.append(CODE_CHAR[_1130123]);
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        // �K��Ō���ʎw�����Z
        if (_1130120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4100");
        }

        // ���ʒn��K��Ō���Z
        if (_2 > 1) {
            // �{�݋敪���Q��
            switch (_1130103) {
            // �C�F�w��K��Ō�X�e�[�V�����܂��̓��F��Ë@�ւ̏ꍇ
            case 1:
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
                break;

            // �n�F�������E�����Ή��T�[�r�X�̏ꍇ
            case 3:
                // ������`�F�b�N�̗L�����m�F
                if (_1130123 == 1) {
                    // ���ʒn��K��Ō���Z�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8001");
                } else {
                    // ���ʒn��K��Ō���Z�Q����
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8002");
                }
                break;

            }
        }

        // 8100 �K��Ō쏬�K�͎��Ə����Z
        if (_13 > 1) {
            // �{�݋敪���Q��
            switch (_1130103) {
            // �C�F�w��K��Ō�X�e�[�V�����܂��̓��F��Ë@�ւ̏ꍇ
            case 1:
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
                break;

            // �n�F�������E�����Ή��T�[�r�X�̏ꍇ
            case 3:
                // ������`�F�b�N�̗L�����m�F
                if (_1130123 == 1) {
                    // �K��Ō쏬�K�͎��Ə����Z�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8101");
                } else {
                    // �K��Ō쏬�K�͎��Ə����Z�Q����
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8102");
                }
                break;

            }
        }

        // 8110 �K��Ō쒆�R�Ԓn�擙�񋟉��Z
        if (_12 > 1) {
            // �{�݋敪���Q��
            switch (_1130103) {
            // �C�F�w��K��Ō�X�e�[�V�����܂��̓��F��Ë@�ւ̏ꍇ
            case 1:
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
                break;

            // �n�F�������E�����Ή��T�[�r�X�̏ꍇ
            case 3:
                // ������`�F�b�N�̗L�����m�F
                if (_1130123 == 1) {
                    // �K��Ō쒆�R�Ԓn�擙�񋟉��Z�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8111");
                } else {
                    // �K��Ō쒆�R�Ԓn�擙���Z�Q����
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8112");
                }
                break;

            }
        }

        // �ً}���K��Ō���Z
        if (_1130108 > 1) {
            // �{�݋敪�m�F
            switch (_1130103) {
            case 1:// �w��K��Ō�X�e�[�V�����������ꍇ
                putSystemServiceCodeItem(sysSvcCdItems, "Z3100");
                break;

            case 2:// ��Ë@��
                putSystemServiceCodeItem(sysSvcCdItems, "Z3200");
                break;
            }
        }

        // �ً}���K��Ō���Z�i��������p�j
        if (_1130103 == 3) {
            switch (_1130122) {
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3100");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3200");
                break;
            }
        }

        // ���ʊǗ����Z
        switch (_1130116) {
        // ���ʊǗ����ZI
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
            break;
        // ���ʊǗ����ZII
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
            break;
        }

        // �^�[�~�i���P�A���Z
        if (_1130110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z7000");
        }

        // ������Z
        if (_1130117 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
        }

        // �މ@�������w�����Z
        if (_1130118 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
        }

        // �Ō�E���A�g���Z
        if (_1130119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4004");
        }

        // 6101 �K��Ō�T�[�r�X�񋟑̐����Z
        if (_1130113 > 1) {
            // �{�݋敪�m�F
            switch (_1130103) {
            case 1:// �w��K��Ō�X�e�[�V�����������ꍇ
            case 2:// ��Ë@��
                putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
                break;
            case 3: // �K��Ō�T�[�r�X�񋟑̐����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
                break;
            }
        }

        return sysSvcCdItems;
    }

}
