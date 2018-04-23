package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SC_16611_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "���\�h�ʏ����n";
    }

    public String getServiceCodeKind() {
        return "66";
    }

    public String getSystemServiceKindDetail() {
        return "16611";
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
        
        // 1660101 �l�����Z�@1-�Ȃ� 2-������� 3-��t�APT�EOT�EST�A�Ō�E���E���̌���
        int _1660101 = getIntValue(map, "1660101", 1);

        // 1660102 �����@1-�����łȂ� 2-�����ł���
        int _1660102 = getIntValue(map, "1660102", 1);

        // 1660103 �^����@�\������Z�@1-�Ȃ� 2-����
        int _1660103 = getIntValue(map, "1660103", 1);

        // 1660104 �h�{���P���Z�@1-�Ȃ� 2-����
        int _1660104 = getIntValue(map, "1660104", 1);

        // 1660105 ���o�@�\������Z�@1-�Ȃ� 2-����
        int _1660105 = getIntValue(map, "1660105", 1);

        // 1660106 ���Ə��]�����Z�@1-�Ȃ� 2-����
        int _1660106 = getIntValue(map, "1660106", 1);

        // 1660107 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1660107 = getIntValue(map, "1660107", 1);

        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // 1660108 �T�[�r�X�񋟑̐��������Z
        int _1660108 = getIntValue(map, "1660108", 1);

        // 1660110 �{�݋敪���W�I�O���[�v
        int _1660110 = getIntValue(map, "1660110", 1);

        // [CCCX:03692][Shinobu Hitaka] 2016/12/01 add - begin �ʑI��Ή�
        // 1660111 �I��I�T�[�r�X�������{���Z�@1-�Ȃ� 2-I1 3-I2 4-I3 5-II
        int _1660111 = getIntValue(map, "1660111", 1);
        
        // 1660113 ���n�r���e�[�V�����E�}�l�W�����g���Z
        int _1660113 = getIntValue(map, "1660113" ,1);

        // 1660114 �����s�׌��ナ�n�r�����{���Z�@1-�Ȃ� 2-3���ȓ� 3-3����6���ȓ�
        int _1660114 = getIntValue(map, "1660114", 1);
        
        // 1660115 �����s�׌��ナ�n�r����̌p�����Z�@1-�Ȃ� 2-����
        int _1660115 = getIntValue(map, "1660115", 1);
        
        // 1660112	�h�{�X�N���[�j���O���Z
        int _1660112 = getIntValue(map, "1660112");

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
            setSentakutekiService(_1660111, _1660103, _1660104, _1660105, sysSvcCdItems);
                        
            // ���E���������P��ԋp
            switch (_17) {
            case 6:
                // �\�h�ʏ����n�������P���ZI
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2017.04
                break;
            case 5:
                // �\�h�ʏ����n�������P���ZII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
                break;
            case 2:
                // �\�h�ʏ����n�������P���ZIII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                break;
            case 3:
                // �\�h�ʏ����n�������P���ZIV
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
                break;
            case 4:
                // �\�h�ʏ����n�������P���ZV
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
                break;
            }
            
            return sysSvcCdItems;
        }
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - end
        
        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪 1-�a�@���͐f�Ï��@2-���V�l�ی��{��
        sb.append(CODE_CHAR[_1660110]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �l�����Z�@1-�Ȃ� 2-������� 3-��t�APT�EOT�EST�A�Ō�E���E���̌���
        sb.append(CODE_CHAR[_1660101]);

        // �����s�׌��ナ�n�r����̌p�����Z //2018.04
        sb.append(CODE_CHAR[_1660115]);
        
        // �����@1-�����łȂ� 2-�����ł���
        sb.append(CODE_CHAR[_1660102]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        // 6109 �\�h�ʏ����n��N���F�m�ǎ�����Z
        if (_1660107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂�����̏ꍇ
        if (_16 > 1) {
            
            //�{�݋敪���m�F
            switch (_1660110) {
            case 1: // �a�@���͐f�Ï�
                // �v���x
                switch(_1) {
                case 3: // �v�x���P
                    // �\�h�ʏ����n���}���Z�P�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                    break;
                case 4: // �v�x���Q
                    // �\�h�ʏ����n���}���Z�P�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                    break;
                }
                break;
            case 2: // ���V�l�ی��{��
                // �v���x
                switch(_1) {
                case 3: // �v�x���P
                    // �\�h�ʏ����n���}���Z�Q�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
                    break;
                case 4: // �v�x���Q
                    // �\�h�ʏ����n���}���Z�Q�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                    break;
                }
                break;
            case 3: // ����É@
                // �v���x
                switch(_1) {
                case 3: // �v�x���P
                    // �\�h�ʏ����n���}���Z�R�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6119");//2018.04
                    break;
                case 4: // �v�x���Q
                    // �\�h�ʏ����n���}���Z�R�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6120");//2018.04
                    break;
                }
                break;
            }
        }
        
        // �^����@�\������Z�A�h�{���P���Z�A���o�@�\������Z�A�I��I�T�[�r�X�������{���Z
        setSentakutekiService(_1660111, _1660103, _1660104, _1660105, sysSvcCdItems);
        
        // ���Ə��]�����Z�@1-�Ȃ� 2-����
        if (_1660106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5005");
        }
        
        // ���n�}�l�W�����g���Z
        if (_1660113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5615");//2018.04
        }
        
        // 1160124 �����s�׌��ナ�n�r�����{���Z
        switch (_1660114) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6255");//2018.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6256");//2018.04
            break;
        }
        
        // 1160129	�h�{�X�N���[�j���O���Z
        if (_1660112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6201");//2018.04
        }
        
        // �T�[�r�X�񋟑̐��������Z
        switch (_1660108) {
        case 4: // I�C�^
            // �v���x
            switch (_1) {
            case 3: // �v�x���P
                // �\�ʃ��n�T�[�r�X�񋟑̐����ZI�C�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
                break;
            case 4: // �v�x���Q
                // �\�ʃ��n�T�[�r�X�񋟑̐����ZI�C�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6118");
                break;
            }
            break;
        case 2: // I���^
            // �v���x
            switch (_1) {
            case 3: // �v�x���P
                // �\�ʃ��n�T�[�r�X�񋟑̐����ZI���P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
                break;
            case 4: // �v�x���Q
                // �\�ʃ��n�T�[�r�X�񋟑̐����ZI���Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
                break;
            }
            break;
            
        case 3: // II�^
            // �v���x
            switch (_1) {
            case 3: // �v�x���P
                // �\�ʃ��n�T�[�r�X�񋟑̐����ZII�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
                break;
            case 4: // �v�x���Q
                // �\�ʃ��n�T�[�r�X�񋟑̐����ZII�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            }
            break;
        }
        
        
        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            // �\�h�ʏ����n�������P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2017.04
            break;
        case 5:
            // �\�h�ʏ����n�������P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
            break;
        case 2:
            // �\�h�ʏ����n�������P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
            break;
        case 3:
            // �\�h�ʏ����n�������P���ZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
            break;
        case 4:
            // �\�h�ʏ����n�������P���ZV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
            break;
        }
        
        
        // ������ł͂Ȃ��ꍇ
        if (_1660102 == 1) {
            
            if (_12 > 1) {
                // 8110 �\�h�ʏ����n���R�Ԓn�擙�񋟉��Z
                putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
            }
            
            
        // ������̏ꍇ
        } else {
            
            if (_12 > 1) {
                // 8111 �\�h�ʏ����n���R�Ԓn�擙���Z����
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
