package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �K��^�T�[�r�X(�݂Ȃ�)
 * 
 * @since V7.2.1
 * @author Yoichiro.Kamei
 * 
 */
public class SC_50111_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�K��^�T�[�r�X(�݂Ȃ�)";
    }

    public String getServiceCodeKind() {
        return "A1";
    }

    public String getSystemServiceKindDetail() {
        return "50111";
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
            return new ArrayList<HashMap<String, String>>();
        }

        // 5010101 �K�����@1-�T�^ 2-�U�^ 3-�V�^ 4-�W�^ 5-�X�^ 6-�Y�^ 7-�Z���Ԍ^
        int _5010101 = getIntValue(map, "5010101", 1);

        // 5010102 �T�[�r�X�񋟐ӔC�҂̋��E�@1-���C�ȊO 2-���C
        int _5010102 = getIntValue(map, "5010102", 1);

        // 5010103 �����@1-�����łȂ� 2-�����ł���
        int _5010103 = getIntValue(map, "5010103", 1);

        // 2 ���ʒn����Z
        int _2 = getIntValue(map, "2");

        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // ���R�Ԓn�擙���K�͎��Ə����Z
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 5010104 ������Z
        int _5010104 = getIntValue(map, "5010104", 1);

        // 5010105 �����@�\����A�g���Z
        int _5010105 = getIntValue(map, "5010105", 1);

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �K�����@1-�T�^ 2-�U�^ 3-�V�^ 4-�W�^ 5-�X�^ 6-�Y�^ 7-�Z���Ԍ^
        sb.append(CODE_CHAR[_5010101]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �T�[�r�X�񋟐ӔC�҂̋��E�@1-���C�ȊO 2-���C
        sb.append(CODE_CHAR[_5010102]);

        // ���ꌚ�����Z�҂ւ̃T�[�r�X��
        sb.append(CODE_CHAR[_16]);

        // �����@1-�����łȂ� 2-�����ł���
        sb.append(CODE_CHAR[_5010103]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        
        // ������Z
        if (_5010104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
        }

        // �����@�\����A�g���Z
        if (_5010105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
        }
        
        
        // ���E���������P��ԋp
        switch (_17) {
        case 5:
            // �������P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6270");
            break;
        case 2:
        	// �������P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6271");
            break;
        case 3:
        	// �������P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
            break;
        case 4:
        	// �������P���ZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        }
        
        
        // ������Ȃ��̏ꍇ
        if (_5010103 == 1) {
            
        	
        	// ���P�ʃT�[�r�X�̏ꍇ
        	if (_5010101 < 4) {
        		
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
                
            // �񐔒P�ʃT�[�r�X�̏ꍇ
        	} else {
        		
                // ���ʒn����Z
                if (_2 > 1) {
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8002");
                }
                
                // ���R�Ԓn�擙���K�͎��Ə����Z
                if (_13 > 1) {
                    // 8100 �\�h�K���쏬�K�͎��Ə����Z
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8102");
                }
                
                // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
                if (_12 > 1) {
                    // 8110 �\�h�K���쒆�R�Ԓn�擙�񋟉��Z
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8112");
                }
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
