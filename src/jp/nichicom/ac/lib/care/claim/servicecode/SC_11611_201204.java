package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �ʏ����n�r���e�[�V����
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_11611_201204 extends Qkan10011_ServiceUnitGetter {
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

        // 1160107 ���n�r���K��w�����Z
        int _1160107 = getIntValue(map, "1160107" ,1);

        // 1160111 ���n�r���e�[�V�����E�}�l�W�����g���Z
        int _1160111 = getIntValue(map, "1160111" ,1);

        // 1160112 �Z���W�����n�r���e�[�V�������{���Z
        int _1160112 = getIntValue(map, "1160112" ,1);

        // 1160114 �h�{���P���Z
        int _1160114 = getIntValue(map, "1160114" ,1);

        // 1160115 ���o�@�\������Z
        int _1160115 = getIntValue(map, "1160115" ,1);
        
        // 1160118 �ʃ��n�r�����{���Z
        int _1160118 = getIntValue(map, "1160118" , 1);
        
        // 1160119 ���w�Ö@�m���̐��������Z
        int _1160119 = getIntValue(map, "1160119" , 1);
        
        // 1160120 �F�m�ǒZ���W�����n�r�����{���Z
        int _1160120 = getIntValue(map, "1160120" , 1);
        
        // 1160121 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1160121 = getIntValue(map, "1160121" , 1);
        
        // 12 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);
        
        // 1160122 �T�[�r�X�񋟑̐��������Z
        int _1160122 = getIntValue(map, "1160122" ,1);
        
        // 1160123 �d�x�×{�Ǘ����Z
        int _1160123 = getIntValue(map, "1160123", 1);

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
 
        // �K��Ō�×{��̎����Ή�
        // �P�Ɖ��Z
        int _9 = getIntValue(map,"9");
 
        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // ���n�r���K��w�����Z
            if (_1160107 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5400");
            }
            
            // [ID:0000710][Shin Fujihara] 2010/11 add begin 2012�N�x�Ή�
            // 6111 �ʏ����n�ʃ��n�r�����Z
            if (_1160118 > 1) {
                // �񋟎��Ԃŕ���
                // �P���Ԉȏ�Q���Ԗ����̏ꍇ
                if (_1160104 == 1) {
                    // �ʏ����n�ʃ��n�r�����Z�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                    
                // �Q���Ԉȏ�̏ꍇ
                } else  {
                    // �ʏ����n�ʃ��n�r�����Z�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6112");
                }
            }
            //[ID:0000710][Shin Fujihara] 2010/11 add end 2012�N�x�Ή�
            
            // ���E���������P��ԋp
            switch(_17){
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
        
        // ���n�r���K��w�����Z
        if (_1160107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5400");
        }
        
        // ���n�r���e�[�V�����E�}�l�W�����g���Z
        if (_1160111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5601");
        }
        
        // �Z���W�����n�r���e�[�V�������{���Z
        switch (_1160112) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z5602");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z5603");
            break;
        }
        
        // 6111 �ʏ����n�ʃ��n�r�����Z
        if (_1160118 > 1) {
            // �񋟎��Ԃŕ���
            // �P���Ԉȏ�Q���Ԗ����̏ꍇ
            if (_1160104 == 1) {
                // �ʏ����n�ʃ��n�r�����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                
            // �Q���Ԉȏ�̏ꍇ
            } else  {
                // �ʏ����n�ʃ��n�r�����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6112");
            }
        }
        
        // 6253 �ʏ����n�F�m�ǒZ���W�����n���Z
        if (_1160120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6253");
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
        
        // �ʏ����n�T�[�r�X�񋟑̐����Z
        switch (_1160122) {
        // �ʏ����n�T�[�r�X�񋟑̐����ZI
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
