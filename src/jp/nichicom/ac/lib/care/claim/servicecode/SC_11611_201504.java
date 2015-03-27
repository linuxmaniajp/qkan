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
public class SC_11611_201504 extends Qkan10011_ServiceUnitGetter {
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
            
            if (_1160111 == 2) {
                // �ʏ����n�}�l�W�����g���Z�T
                putSystemServiceCodeItem(sysSvcCdItems, "Z5601");//TODO:H27�����P�Ɖ��Z
            } else if (_1160111 == 3) {
                // �ʏ����n�}�l�W�����g���Z�U�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z5608");//TODO:�R�[�h�l�m�F
            } else if (_1160111 == 4) {
                // �ʏ����n�}�l�W�����g���Z�U�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z5609");//TODO:�R�[�h�l�m�F
            }
            
            // ���E���������P��ԋp
            switch(_17){
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");//TODO:�R�[�h�l�m�F
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
            sisetuKubun1 = 1;
            break;
        // ��K��I(�a�@�E�f�Ï�)
        case 3:
        // ��K��I(�V���{��)
        case 4:
            sisetuKubun1 = 2;
            break;
        // ��K��II(�a�@�E�f�Ï�)
        case 5:
        // ��K��II(�V���{��)
        case 6:
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
            putSystemServiceCodeItem(sysSvcCdItems, "Z5608");//TODO:�R�[�h�l�m�F
            break;
        case 4:
            // �ʏ����n�}�l�W�����g���Z�U�Q
            putSystemServiceCodeItem(sysSvcCdItems, "Z5609");//TODO:�R�[�h�l�m�F
            break;
        }
        
        // �Z���W���ʃ��n�r�����{���Z
        if (_1160112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5613");//TODO:�R�[�h�l�m�F
        }
        
        
        // 6253 �ʏ����n�F�m�ǒZ���W�����n���Z
        switch (_1160120) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6253");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6254");//TODO:�R�[�h�l�m�F
            break;
        }
        
        // 1160124 �����s�׌��ナ�n�r�����{���Z
        switch (_1160124) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6255");//TODO:�R�[�h�l�m�F
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6256");//TODO:�R�[�h�l�m�F
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
        
        // �ʏ����n���}���Z
        if (_16 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }
        
        // 1160125 ���d�x�҃P�A�̐����Z
        if (_1160125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5614");//TODO:�R�[�h�l�m�F
        }
        
        // 1160126 �Љ�Q���x�����Z
        if (_1160126 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//TODO:�R�[�h�l�m�F
        }
        
        // ���}���Z
        switch (_18) {
        case 3: // ����
            putSystemServiceCodeItem(sysSvcCdItems, "Z56122");//TODO:�R�[�h�l�m�F
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z56121");//TODO:�R�[�h�l�m�F
            break;
        }

        
        // �ʏ����n�T�[�r�X�񋟑̐����Z
        switch (_1160122) {
        // �ʏ����n�T�[�r�X�񋟑̐����ZI�C
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//TODO:�R�[�h�l�m�F
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
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");//TODO:�R�[�h�l�m�F
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
