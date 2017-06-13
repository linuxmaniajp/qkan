package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���\�h�K����
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_16111_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "���\�h�K����";
    }

    public String getServiceCodeKind() {
        return "61";
    }

    public String getSystemServiceKindDetail() {
        return "16111";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // ���炩�ɗv���x�����������ꍇ�͋��Ԃ�
        switch (_1) {
        case 1: // ����
        case 2: // �o�ߓI�v���
        case 5: // �v���P
        case 6: // �v���Q
        case 7: // �v���R
        case 8: // �v���S
        case 9: // �v���T
        case 10: // ���ƑΏێ�
            return new ArrayList<HashMap<String, String>>();
        }

        // 1610101 �K�����@1-�T�^ 2-�U�^ 3-�V�^
        int _1610101 = getIntValue(map, "1610101", 1);

        // 1610102 �K��҂̋��E�@1-2���ȊO 2-2��
        int _1610102 = getIntValue(map, "1610102", 1);

        // 1610103 �����@1-�����łȂ� 2-�����ł���
        int _1610103 = getIntValue(map, "1610103", 1);

        // 2 ���ʒn����Z
        int _2 = getIntValue(map, "2");

        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // ���R�Ԓn�擙���K�͎��Ə����Z
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 1610104 ������Z
        int _1610104 = getIntValue(map, "1610104", 1);

        // 1610105 ��炵�̋@�\������Z
        int _1610105 = getIntValue(map, "1610105", 1);

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �K�����@1-�T�^ 2-�U�^ 3-�V�^
        sb.append(CODE_CHAR[_1610101]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �T�[�r�X�񋟐ӔC�҂̋��E�@1-2���ȊO 2-2��
        sb.append(CODE_CHAR[_1610102]);

        // �K��̕K�v��
        sb.append(CODE_CHAR[_16]);

        // �����@1-�����łȂ� 2-�����ł���
        sb.append(CODE_CHAR[_1610103]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        
        // 4001 �\�h�K���쏉����Z
        if (_1610104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
        }

        // 1610105 �����@�\����A�g���Z
        if (_1610105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
        }
        
        
        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            // �������P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6269");//2017.04
            break;
        case 5:
            // �������P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6270");//2015.04
            break;
        case 2:
        	// �������P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6271");
            break;
        case 3:
        	// �������P���ZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
            break;
        case 4:
        	// �������P���ZV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        }
        
        
        // ������Ȃ��̌��P�ʐ���
        if (_1610103 == 1) {
            
            // ���ʒn����Z
            if (_2 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
            }
            
            // ���R�Ԓn�擙���K�͎��Ə����Z
            if (_13 > 1) {
                // 8100 �\�h�K���쏬�K�͎��Ə����Z
                putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
            }
            
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
            if (_12 > 1) {
                // 8110 �\�h�K���쒆�R�Ԓn�擙�񋟉��Z
                putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
            }
            
            
        // ������̏ꍇ
        } else {
            // ���ʒn����Z
            if (_2 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8001");
            }
            
            // ���R�Ԓn�擙���K�͎��Ə����Z
            if (_13 > 1) {
                // 8101 �\�h�K���쏬�K�͎��Ə����Z����
                putSystemServiceCodeItem(sysSvcCdItems, "Z8101");
            }
            
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
            if (_12 > 1) {
                // 8111 �\�h�K���쒆�R�Ԓn�擙���Z����
                putSystemServiceCodeItem(sysSvcCdItems, "Z8111");
            }
            
        }
        
        
        return sysSvcCdItems;
    }
}
