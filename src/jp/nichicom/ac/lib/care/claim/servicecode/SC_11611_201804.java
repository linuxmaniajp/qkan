package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �ʏ����n�r���e�[�V����
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_11611_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�ʏ����n�r���e�[�V����";
    }

    public String getServiceCodeKind() {
        return "16";
    }

    public String getSystemServiceKindDetail() {
        return "11611";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1160116 �{�݋敪
        int _1160116 = getIntValue(map, "1160116" ,1);

        // 1160104 ���ԋ敪
        int _1160104 = getIntValue(map, "1160104" ,1);

        // 1160109 �l�����Z
        int _1160109 = getIntValue(map, "1160109" ,1);

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1160105 �������Z
        int _1160105 = getIntValue(map, "1160105" ,1);

        // 1160111 ���n�r���e�[�V�����E�}�l�W�����g���Z
        int _1160111 = getIntValue(map, "1160111" ,1);

        // 1160112 �Z���W���ʃ��n�r�����{���Z
        int _1160112 = getIntValue(map, "1160112" ,1);

        // 1160114 �h�{���P���Z
        int _1160114 = getIntValue(map, "1160114" ,1);

        // 1160115 ���o�@�\������Z
        int _1160115 = getIntValue(map, "1160115" ,1);
        
        
        // 1160119 ���w�Ö@�m���̐��������Z
        int _1160119 = getIntValue(map, "1160119" , 1);
        
        // 1160120 �F�m�ǒZ���W�����n�r�����{���ZI�^
        int _1160120 = getIntValue(map, "1160120" , 1);
        
        // 1160121 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1160121 = getIntValue(map, "1160121" , 1);
        
        // 12 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);
        
        // 1160122 �T�[�r�X�񋟑̐��������Z
        int _1160122 = getIntValue(map, "1160122" ,1);
        
        // 1160123 �d�x�×{�Ǘ����Z
        int _1160123 = getIntValue(map, "1160123", 1);
        
        // 1160124 �����s�׌��ナ�n�r�����{���Z�@1-�Ȃ� 2-3���ȓ� 3-3����6���ȓ�
        int _1160124 = getIntValue(map, "1160124", 1);
        
        // 1160127 �����s�׌��ナ�n�r����̌p�����Z�@1-�Ȃ� 2-����
        int _1160127 = getIntValue(map, "1160127", 1);
        
        // 1160125 ���d�x�҃P�A�̐����Z 1-�Ȃ� 2-����
        int _1160125 = getIntValue(map, "1160125", 1);
        
        // 1160126 �Љ�Q���x�����Z�@1-�Ȃ� 2-����
        int _1160126 = getIntValue(map, "1160126", 1);

        
        // 1160128	���n�r���e�[�V�����񋟑̐����Z
        int _1160128 = getIntValue(map, "1160128");
        
        // 1160129	�h�{�X�N���[�j���O���Z
        int _1160129 = getIntValue(map, "1160129");

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);
        
        // 18 ���}���Z
        int _18 = getIntValue(map, "18");
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
 
        // �K��Ō�×{��̎����Ή�
        // �P�Ɖ��Z
        int _9 = getIntValue(map,"9");
 
        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            
            if (_1160111 == 3) {
                // �ʏ����n�}�l�W�����g���Z�U�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z5608");//2015.04
            } else if (_1160111 == 4) {
                // �ʏ����n�}�l�W�����g���Z�U�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z5609");//2015.04
            } else if (_1160111 == 5) {
                // �ʏ����n�}�l�W�����g���ZIII1
                putSystemServiceCodeItem(sysSvcCdItems, "Z5615");//2018.04
            } else if (_1160111 == 6) {
                // �ʏ����n�}�l�W�����g���ZIII�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z5616");//2018.04
            } else if (_1160111 == 7) {
                // �ʏ����n�}�l�W�����g���ZIV1
                putSystemServiceCodeItem(sysSvcCdItems, "Z5617");//2018.04
            } else if (_1160111 == 8) {
                // �ʏ����n�}�l�W�����g���ZIV2
                putSystemServiceCodeItem(sysSvcCdItems, "Z5618");//2018.04
            }
            
            // ���E���������P��ԋp
            switch(_17){
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            }
            
            return sysSvcCdItems;
        }
        
        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();
        
        // �{�݋敪�����P �ʏ�K�́A��K�͎��Ə�I�A��K�͎��Ə�II
        int sisetuKubun1 = 1;
        switch (_1160116) {
        // �ʏ�K��(�a�@�E�f�Ï�)
        case 1:
        // �ʏ�K��(�V���{��)
        case 2:
        // �ʏ�K��(����É@)
        case 7:
            sisetuKubun1 = 1;
            break;
        // ��K��I(�a�@�E�f�Ï�)
        case 3:
        // ��K��I(�V���{��)
        case 4:
        // ��K��I(����É@)
        case 8:
            sisetuKubun1 = 2;
            break;
        // ��K��II(�a�@�E�f�Ï�)
        case 5:
        // ��K��II(�V���{��)
        case 6:
        // ��K��II(����É@)
        case 9:
            sisetuKubun1 = 3;
            break;
        }
        
        // �{�݋敪�����Q �a�@���͐f�Ï��A���V�l�ی��{��
        int sisetuKubun2 = 1;
        switch (_1160116) {
        // �ʏ�K��(�a�@�E�f�Ï�)
        case 1:
        // ��K��I(�a�@�E�f�Ï�)
        case 3:
        // ��K��II(�a�@�E�f�Ï�)
        case 5:
            sisetuKubun2 = 1;
            break;
        // �ʏ�K��(�V���{��)
        case 2:
        // ��K��I(�V���{��)
        case 4:
        // ��K��II(�V���{��)
        case 6:
            sisetuKubun2 = 2;
            break;
        // �ʏ�K��(����É@)
        case 7:
        // ��K��I(����É@)
        case 8:
        // ��K��II(����É@)
        case 9:
            sisetuKubun2 = 3;
            break;
        }
        
        // �{�݋敪(�K��)
        sb.append(CODE_CHAR[sisetuKubun1]);
        // �{�݋敪(�`��)
        sb.append(CODE_CHAR[sisetuKubun2]);

        // ���ԋ敪
        sb.append(CODE_CHAR[_1160104]);

        // �l�����Z
        sb.append(CODE_CHAR[_1160109]);
        
        // �����s�׌��ナ�n�r����̌p�����Z //2015.04
        sb.append(CODE_CHAR[_1160127]);
        
        // �v���x
        sb.append(CODE_CHAR[_1]);
        


        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // 6143 �ʏ����n���w�Ö@�m���̐��������Z
        if (_1160119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6143");
        }
        
        // 8110 �ʏ����n���R�Ԓn�擙�񋟉��Z
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // �������Z
        if (_1160105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        
        // ���n�r���e�[�V�����E�}�l�W�����g���Z
        switch (_1160111) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z5601");
            break;
        case 3:
            // �ʏ����n�}�l�W�����g���Z�U�P
            putSystemServiceCodeItem(sysSvcCdItems, "Z5608");//2015.04
            break;
        case 4:
            // �ʏ����n�}�l�W�����g���Z�U�Q
            putSystemServiceCodeItem(sysSvcCdItems, "Z5609");//2015.04
            break;
        case 5:
            // �ʏ����n�}�l�W�����g���ZIII�P
            putSystemServiceCodeItem(sysSvcCdItems, "Z5615");//2018.04
            break;
        case 6:
            // �ʏ����n�}�l�W�����g���ZIII�Q
            putSystemServiceCodeItem(sysSvcCdItems, "Z5616");//2018.04
            break;
        case 7:
            // �ʏ����n�}�l�W�����g���ZIV�P
            putSystemServiceCodeItem(sysSvcCdItems, "Z5617");//2018.04
            break;
        case 8:
            // �ʏ����n�}�l�W�����g���ZIV�Q
            putSystemServiceCodeItem(sysSvcCdItems, "Z5618");//2018.04
            break;
        }
        
        // �Z���W���ʃ��n�r�����{���Z
        if (_1160112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5613");//2015.04
        }
        
        
        // 6253 �ʏ����n�F�m�ǒZ���W�����n���Z
        switch (_1160120) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6253");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6254");//2015.04
            break;
        }
        
        // 1160124 �����s�׌��ナ�n�r�����{���Z
        switch (_1160124) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6255");//2015.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6256");//2015.04
            break;
        }
        
        
        // 6109 �ʏ����n��N���F�m�ǎ�����Z
        if (_1160121 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // �h�{���P���Z
        if (_1160114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5605");
        }
        
        // ���o�@�\������Z
        if (_1160115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // �d�x�×{�Ǘ����Z
        if (_1160123 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5610");
        }
        
        // ���ꌚ�����Z
        if (_16 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }
        
        // 1160125 ���d�x�҃P�A�̐����Z
        if (_1160125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5614");//2015.04
        }
        
        // 1160126 �Љ�Q���x�����Z
        if (_1160126 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
        }
        
        // 1160128	���n�r���e�[�V�����񋟑̐����Z //2018.04
        if (_1160128 > 1) {
        	if (_1160104 == 3) {
                // ���n�r���񋟑̐����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6144");
            } else if (_1160104 == 4) {
                // ���n�r���񋟑̐����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6145");
            } else if (_1160104 == 5) {
                // ���n�r���񋟑̐����Z�R
                putSystemServiceCodeItem(sysSvcCdItems, "Z6146");
            } else if (_1160104 == 6) {
                // ���n�r���񋟑̐����Z�S
                putSystemServiceCodeItem(sysSvcCdItems, "Z6147");
            } else if (_1160104 >= 7) {
                // ���n�r���񋟑̐����Z�T
                putSystemServiceCodeItem(sysSvcCdItems, "Z6148");
            } 
        }
        
        // 1160129	�h�{�X�N���[�j���O���Z
        if (_1160129 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6201");//2018.04
        }

        
        // ���}���Z
        switch (_18) {
        case 3: // ����
            putSystemServiceCodeItem(sysSvcCdItems, "Z56122");//2015.04
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z56121");//2015.04
            break;
        }

        
        // �ʏ����n�T�[�r�X�񋟑̐����Z
        switch (_1160122) {
        // �ʏ����n�T�[�r�X�񋟑̐����ZI�C
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        // �ʏ����n�T�[�r�X�񋟑̐����ZI��
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        // �ʏ����n�T�[�r�X�񋟑̐����ZII
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        }
        
        // ���E���������P��ԋp
        switch(_17){
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        }
        
        return sysSvcCdItems;
    }
}
