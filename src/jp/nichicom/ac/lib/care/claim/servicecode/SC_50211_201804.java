package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �K��^�T�[�r�X(�Ǝ�)
 * 
 * @since V7.3.0
 * @author Shinobu.Hitaka
 * 
 */
public class SC_50211_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�K��^�T�[�r�X(�Ǝ�)";
    }

    public String getServiceCodeKind() {
        return "A2";
    }

    public String getSystemServiceKindDetail() {
        return "50211";
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

        // 5020106 �p�^�[���@1,2,3,4,5
        int _5020106 = getIntValue(map, "5020106", 1);

        // 5020101 �K�����@1-�T�^ 2-�U�^ 3-�V�^ 4-�W�^ 5-�X�^ 6-�Y�^ 7-�Z���Ԍ^
        int _5020101 = getIntValue(map, "5020101", 1);

        // 5020102 �T�[�r�X�񋟐ӔC�҂̋��E�@1-���C�ȊO 2-���C
        int _5020102 = getIntValue(map, "5020102", 1);

        // 5020103 �����@1-�����łȂ� 2-�����ł���
        int _5020103 = getIntValue(map, "5020103", 1);

        // 2 ���ʒn����Z
        int _2 = getIntValue(map, "2");

        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // ���R�Ԓn�擙���K�͎��Ə����Z
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 5020104 ������Z
        int _5020104 = getIntValue(map, "5020104", 1);

        // 5020105 �����@�\����A�g���Z
        int _5020105 = getIntValue(map, "5020105", 1);

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // [CCCX:04029][Shinobu Hitaka] 2017/06/20 add - begin  ���Z�̂ݑΉ�
        int _9 = getIntValue(map,"9");
        
        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if(_9 == 2){
        	setKasanServiceByPattern(_5020104, _5020105, sysSvcCdItems, _5020106);
        	return sysSvcCdItems;
        }
        // [CCCX:04029][Shinobu Hitaka] 2017/06/20 add - end
        
        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �K�����@1-�T�^ 2-�U�^ 3-�V�^ 4-�W�^ 5-�X�^ 6-�Y�^ 7-�Z���Ԍ^
        sb.append(CODE_CHAR[_5020101]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �T�[�r�X�񋟐ӔC�҂̋��E�@1-���C�ȊO 2-���C
        sb.append(CODE_CHAR[_5020102]);

        // ���ꌚ�����Z�҂ւ̃T�[�r�X��
        sb.append(CODE_CHAR[_16]);

        // �����@1-�����łȂ� 2-�����ł���
        sb.append(CODE_CHAR[_5020103]);

        // �p�^�[���@1,2,3,4,5
        sb.append(CODE_CHAR[_5020106]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // [CCCX:04029][Shinobu Hitaka] 2017/06/20 ���Z�̂ݑΉ�
        setKasanServiceByPattern(_5020104, _5020105, sysSvcCdItems, _5020106);
        
        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            // �������P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6269");//2017.04
            break;
        case 5:
            // �������P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6270");
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
        
        
        // ������Ȃ��̏ꍇ
        if (_5020103 == 1) {
        	// ���P�ʃT�[�r�X�̏ꍇ
        	if (_5020101 < 4) {
        		
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
    
    /**
     * �p�^�[���ɂ�����������Z�A�����@�\����A�g���Z��ݒ肵�܂��B
	 * @param _5020104 ������Z
	 * @param _5020105 �����@�\����A�g���Z
	 * @param sysSvcCdItems �T�[�r�X�R�[�hMap
	 * @param pattern �p�^�[��
     */
    private void setKasanServiceByPattern(int _5020104, int _5020105, 
    		ArrayList<HashMap<String, String>> sysSvcCdItems,
    		int pattern) {
	    // ������Z
	    if (_5020104 > 1) {
	    	switch (pattern) {
	    	case 1:
	            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
	            break;
	    	case 2:
	            putSystemServiceCodeItem(sysSvcCdItems, "Z4011");
	            break;
	    	case 3:
	            putSystemServiceCodeItem(sysSvcCdItems, "Z4021");
	            break;
	    	case 4:
	            putSystemServiceCodeItem(sysSvcCdItems, "Z4031");
	            break;
	    	case 5:
	            putSystemServiceCodeItem(sysSvcCdItems, "Z4041");
	            break;
	    	}
	    }
	
	    // �����@�\����A�g���Z
	    if (_5020105 > 1) {
	    	switch (pattern) {
	    	case 1:
	            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
	            break;
	    	case 2:
	            putSystemServiceCodeItem(sysSvcCdItems, "Z4012");
	            break;
	    	case 3:
	            putSystemServiceCodeItem(sysSvcCdItems, "Z4022");
	            break;
	    	case 4:
	            putSystemServiceCodeItem(sysSvcCdItems, "Z4032");
	            break;
	    	case 5:
	            putSystemServiceCodeItem(sysSvcCdItems, "Z4042");
	            break;
	    	}
	    }
    }
}
