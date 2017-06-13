package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���\�h�ʏ����
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_16511_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "���\�h�ʏ����";
    }

    public String getServiceCodeKind() {
        return "65";
    }

    public String getSystemServiceKindDetail() {
        return "16511";
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
        case 2: // �o�ߓI�v���
        case 5: // �v���P
        case 6: // �v���Q
        case 7: // �v���R
        case 8: // �v���S
        case 9: // �v���T
        case 10: // ���ƑΏێ�
            return new ArrayList<HashMap<String, String>>();
        }
        
        // 1650101 �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E��������
        int _1650101 = getIntValue(map, "1650101", 1);

        // 1650102 �����@1-�����łȂ� 2-�����ł���
        int _1650102 = getIntValue(map, "1650102", 1);

        // 1650103 �����@�\����O���[�v�������Z�@1-�Ȃ� 2-����
        int _1650103 = getIntValue(map, "1650103", 1);

        // 1650104 �^����@�\������Z�@1-�Ȃ� 2-����
        int _1650104 = getIntValue(map, "1650104", 1);

        // 1650105 �h�{���P���Z�@1-�Ȃ� 2-����
        int _1650105 = getIntValue(map, "1650105", 1);

        // 1650106 ���o�@�\������Z�@1-�Ȃ� 2-����
        int _1650106 = getIntValue(map, "1650106", 1);

        // 1650107 ���Ə��]�����Z�@1-�Ȃ� 2-����
        int _1650107 = getIntValue(map, "1650107", 1);

        // 1650108 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1650108 = getIntValue(map, "1650108", 1);

        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // 1650109 �T�[�r�X�񋟑̐��������Z
        int _1650109 = getIntValue(map, "1650109");

        // [CCCX:03692][Shinobu Hitaka] 2016/12/01 add - begin �ʑI��Ή�
        // 1650111 �I��I�T�[�r�X�������{���Z�@1-�Ȃ� 2-I1 3-I2 4-I3 5-II
        int _1650111 = getIntValue(map, "1650111", 1);

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - begin  ���Z�̂ݑΉ�
        // ���Z�̂�(�^���@��E�h�{���P�E���o�@�\����)
        int _9 = getIntValue(map,"9");

        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            
            // �^����@�\������Z�A�h�{���P���Z�A���o�@�\������Z�A�I��I�T�[�r�X�������{���Z
            setSentakutekiService(_1650111, _1650104, _1650105, _1650106, sysSvcCdItems);
            
            // ���E���������P��ԋp
            switch (_17) {
            case 6:
                // �\�h�ʏ���쏈�����P���ZI
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2017.04
                break;
            case 5:
                // �\�h�ʏ���쏈�����P���ZII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
                break;
            case 2:
                // �\�h�ʏ���쏈�����P���ZIII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                break;
            case 3:
                // �\�h�ʏ���쏈�����P���ZIV
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
                break;
            case 4:
                // �\�h�ʏ���쏈�����P���ZV
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
                break;
            }
            
            return sysSvcCdItems;
        }
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - end

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E��������
        sb.append(CODE_CHAR[_1650101]);

        // �����@1-�����łȂ� 2-�����ł���
        sb.append(CODE_CHAR[_1650102]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        
        // 6109 �\�h�ʏ�����N���F�m�ǎ�����Z
        if (_1650108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂�����̏ꍇ
        if (_16 > 1) {
            
            // �v���x�ŕ���
            switch(_1) {
            // �v�x���P
            case 3:
                // �\�h�ʏ���쑗�}���Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            // �v�x���Q
            case 4:
                // �\�h�ʏ���쑗�}���Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }
            
        }
        
        // �����@�\����O���[�v�������Z�@1-�Ȃ� 2-����
        if (_1650103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5010");
        }
        
        // �^����@�\������Z�A�h�{���P���Z�A���o�@�\������Z�A�I��I�T�[�r�X�������{���Z
        setSentakutekiService(_1650111, _1650104, _1650105, _1650106, sysSvcCdItems);
        
        // ���Ə��]�����Z�@1-�Ȃ� 2-����
        if (_1650107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5005");
        }
        
        switch (_1650109) {
        case 4:
            if (_1 == 3) {
                // �v�x���P�̏ꍇ
                // 6107 �\�h�ʏ��T�[�r�X�񋟑̐����ZI�C�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            } else if (_1 == 4) {
                // �v�x���Q�̏ꍇ
                // 6108 �\�h�ʏ��T�[�r�X�񋟑̐����ZI�C�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            }
            break;
        case 2:
            if (_1 == 3) {
                // �v�x���P�̏ꍇ
                // 6101 �\�h�ʏ��T�[�r�X�񋟑̐����ZI���P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            } else if (_1 == 4) {
                // �v�x���Q�̏ꍇ
                // 6102 �\�h�ʏ��T�[�r�X�񋟑̐����ZI���Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            }
            break;
        case 3:
            if (_1 == 3) {
                // �v�x���P�̏ꍇ
                // 6103 �\�h�ʏ��T�[�r�X�񋟑̐����ZII�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            } else if (_1 == 4) {
                // �v�x���Q�̏ꍇ
                // 6104 �\�h�ʏ��T�[�r�X�񋟑̐����ZII�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            }
            break;
        }
        
        
        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            // �\�h�ʏ���쏈�����P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2017.04
            break;
        case 5:
            // �\�h�ʏ���쏈�����P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
            break;
        case 2:
            // �\�h�ʏ���쏈�����P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
            break;
        case 3:
            // �\�h�ʏ���쏈�����P���ZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
            break;
        case 4:
            // �\�h�ʏ���쏈�����P���ZV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
            break;
        }
        
        
        // ������ł͂Ȃ��ꍇ
        if (_1650102 == 1) {
            
            // 8110 �\�h�ʏ���쒆�R�Ԓn�擙�񋟉��Z
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
            }
            
            
        // ������̏ꍇ
        } else {
            
            // 8111 �\�h�ʏ���쒆�R�Ԓn�擙���Z����
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8111");
            }
        }

        return sysSvcCdItems;
    }
    
    /**
     * �^����@�\������Z�A�h�{���P���Z�A���o�@�\������Z�̑I���󋵂ɂ���ĕ����T�[�r�X���{���Z��ݒ肵�܂��B
	 * @param sentakuteki �����T�[�r�X���{���Z
	 * @param moveFunction �^����@�\������Z
	 * @param nourishment �h�{���P���Z
	 * @param mouthFunction ���o�@�\������Z
	 * @param sysSvcCdItems �T�[�r�X�R�[�hMap
     */
    private void setSentakutekiService(int sentakuteki, 
    		int moveFunction, int nourishment, int mouthFunction, 
    		ArrayList<HashMap<String, String>> sysSvcCdItems) {
    	// �I��I�T�[�r�X�������{���Z�@1-�Ȃ� 2-I1 3-I2 4-I3 5-II
        if (sentakuteki > 1) {
        	switch (sentakuteki) {
            case 2:
                // �����T�[�r�X���{���ZI�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
                break;
            case 3:
            	// �����T�[�r�X���{���ZI�Q
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
                break;
            case 4:
            	// �����T�[�r�X���{���ZI�R
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
                break;
            case 5:
            	// �����T�[�r�X���{���ZII
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
                break;
            }
        } else {
	        // �^����@�\������Z�A�h�{���P���Z�A���o�@�\������Z�̗�O����
	        // 
	        // [�^����@�\������Z�̃t���O][�h�{���P���Z�̃t���O][���o�@�\������Z�̃t���O]
	        // �Ƃ������т�3���̐��l���쐬���ĕ���i�t���O�� 1-�Ȃ� 2-����j
	        int addParam = (moveFunction * 100) + (nourishment * 10) + mouthFunction;
	        
	        switch(addParam) {
	        // �^����@�\������Z
	        case 211:
	            // �^����@�\������Z
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
	            break;
	        // �h�{���P���Z
	        case 121:
	            // �h�{���P���Z
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
	            break;
	        // ���o�@�\������Z
	        case 112:
	            // ���o�@�\������Z
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
	            break;
	        // �^����@�\������Z + �h�{���P���Z
	        case 221:
	            // �����T�[�r�X���{���ZI�P
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
	            break;
	        // �^����@�\������Z + ���o�@�\������Z
	        case 212:
	            // �����T�[�r�X���{���ZI�Q
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
	            break;
	        // �h�{���P���Z + ���o�@�\������Z
	        case 122:
	            // �����T�[�r�X���{���ZI�R
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
	            break;
	        // �^����@�\������Z + �h�{���P���Z + ���o�@�\������Z
	        case 222:
	            // �����T�[�r�X���{���ZII
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
	            break;
	        }
        }
    }
}
