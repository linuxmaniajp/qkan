package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �ʏ��^�T�[�r�X(�Ǝ�)
 * 
 * @since V7.3.0
 * @author Shinobu.Hitaka
 * 
 */
public class SC_50611_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�ʏ��^�T�[�r�X(�Ǝ�)";
    }

    public String getServiceCodeKind() {
        return "A6";
    }

    public String getSystemServiceKindDetail() {
        return "50611";
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
            return new ArrayList<HashMap<String, String>>();
        }
        
        // 5060112 �p�^�[���@1,2,3,4,5
        int _5060112 = getIntValue(map, "5060112", 1);

        // �ʏ��^�T�[�r�X��@1-�P 2-�Q
        int _5060101 = getIntValue(map, "5060101", 1);
        
        // ���ƑΏێ҂ł͂Ȃ��Ƃ��A�v���x�ɂ���Ēʏ��^�T�[�r�X������
        if (_1 == 3) {
            // �v�x���P�̏ꍇ
        	_5060101 = 1; //�ʏ��^�T�[�r�X�P
        } else if (_1 == 4) {
            // �v�x���Q�̏ꍇ
        	_5060101 = 2; //�ʏ��^�T�[�r�X�Q
        }
        
        // �񐔁@1-�񐔂łȂ� 2-�񐔂ł���
        int _5060102 = getIntValue(map, "5060102", 1);
        
        // 5060103 �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E��������
        int _5060103 = getIntValue(map, "5060103", 1);

        // 5060104 �����@1-�����łȂ� 2-�����ł���
        int _5060104 = getIntValue(map, "5060104", 1);

        // 5060105 �����@�\����O���[�v�������Z�@1-�Ȃ� 2-����
        int _5060105 = getIntValue(map, "5060105", 1);

        // 5060106 �^����@�\������Z�@1-�Ȃ� 2-����
        int _5060106 = getIntValue(map, "5060106", 1);

        // 5060107 �h�{���P���Z�@1-�Ȃ� 2-����
        int _5060107 = getIntValue(map, "5060107", 1);

        // 5060108 ���o�@�\������Z�@1-�Ȃ� 2-����
        int _5060108 = getIntValue(map, "5060108", 1);

        // 5060109 ���Ə��]�����Z�@1-�Ȃ� 2-����
        int _5060109 = getIntValue(map, "5060109", 1);

        // 5060110 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _5060110 = getIntValue(map, "5060110", 1);

        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // 5060111 �T�[�r�X�񋟑̐��������Z
        int _5060111 = getIntValue(map, "5060111");

        // [CCCX:03692][Shinobu Hitaka] 2016/12/01 add - begin �ʑI��Ή�
        // 5060113 �I��I�T�[�r�X�������{���Z�@1-�Ȃ� 2-I1 3-I2 4-I3 5-II
        int _5060113 = getIntValue(map, "5060113", 1);

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

            // ���Z
            setKasanServiceByPattern(_5060110, _16, _5060101, _5060105, _5060109, sysSvcCdItems, _5060112);
            
            // �^����@�\������Z�A�h�{���P���Z�A���o�@�\������Z�A�I��I�T�[�r�X�������{���Z
            setSentakutekiServiceByPattern(_5060113, _5060106, _5060107, _5060108, sysSvcCdItems, _5060112);
            
            // �T�[�r�X�񋟑̐��������Z
            setServiceTeikyoKasanByPattern(_5060101, _5060111, sysSvcCdItems, _5060112);
            
            // ���E���������P��ԋp
            switch (_17) {
            case 6:
                // �ʏ��^�T�[�r�X�������P���ZI
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2017.04
                break;
            case 5:
                // �ʏ��^�T�[�r�X�������P���ZII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
                break;
            case 2:
                // �ʏ��^�T�[�r�X�������P���ZIII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                break;
            case 3:
                // �ʏ��^�T�[�r�X�������P���ZIV
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
                break;
            case 4:
                // �ʏ��^�T�[�r�X�������P���ZV
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
                break;
            }
            
            return sysSvcCdItems;
        }
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - end

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �ʏ��^�T�[�r�X��
        sb.append(CODE_CHAR[_5060101]);
        
        // �v���x
        sb.append(CODE_CHAR[_1]);
        
        // ��
        sb.append(CODE_CHAR[_5060102]);

        // �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E��������
        sb.append(CODE_CHAR[_5060103]);

        // �����@1-�����łȂ� 2-�����ł���
        sb.append(CODE_CHAR[_5060104]);

        // �p�^�[���@1,2,3,4,5
        sb.append(CODE_CHAR[_5060112]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        setKasanServiceByPattern(_5060110, _16, _5060101, _5060105, _5060109, sysSvcCdItems, _5060112);
        
        // �^����@�\������Z�A�h�{���P���Z�A���o�@�\������Z�A�I��I�T�[�r�X�������{���Z
        setSentakutekiServiceByPattern(_5060113, _5060106, _5060107, _5060108, sysSvcCdItems, _5060112);
        
        // �T�[�r�X�񋟑̐��������Z
        setServiceTeikyoKasanByPattern(_5060101, _5060111, sysSvcCdItems, _5060112);
        
        
        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            // �ʏ��^�T�[�r�X�������P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2017.04
            break;
        case 5:
            // �ʏ��^�T�[�r�X�������P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
            break;
        case 2:
            // �ʏ��^�T�[�r�X�������P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
            break;
        case 3:
            // �ʏ��^�T�[�r�X�������P���ZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
            break;
        case 4:
            // �ʏ��^�T�[�r�X�������P���ZV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
            break;
        }
        
        
        // ������ł͂Ȃ��ꍇ
        if (_5060104 == 1) {
            
            // ���P�ʃT�[�r�X�̏ꍇ
            if (_5060102 == 1) {
                // 8110 �ʏ��^�T�[�r�X���R�Ԓn�擙�񋟉��Z
                if (_12 > 1) {
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
                }
                
            // �񐔒P�ʃT�[�r�X�̏ꍇ
            } else if (_5060102 == 2) {
                // 8112 �ʏ��^�T�[�r�X���R�Ԓn�擙���Z��
                if (_12 > 1) {
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8112");
                }
            }
            
        // ������̏ꍇ
        } else {
            
            // 8111 �ʏ��^�T�[�r�X���R�Ԓn�擙���Z����
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
	 * @param pattern �p�^�[��
     */
    private void setSentakutekiServiceByPattern(int sentakuteki, 
    		int moveFunction, int nourishment, int mouthFunction, 
    		ArrayList<HashMap<String, String>> sysSvcCdItems,
    		int pattern) {
    	// �I��I�T�[�r�X�������{���Z�@1-�Ȃ� 2-I1 3-I2 4-I3 5-II
        if (sentakuteki > 1) {
        	switch (sentakuteki) {
            case 2:
                // �����T�[�r�X���{���ZI�P
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5016");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5026");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5036");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5046");
	        		break;
	        	}
                break;
            case 3:
            	// �����T�[�r�X���{���ZI�Q
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5017");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5027");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5037");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5047");
	        		break;
	        	}
	            break;
            case 4:
            	// �����T�[�r�X���{���ZI�R
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5018");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5028");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5038");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5048");
	        		break;
	        	}
                break;
            case 5:
            	// �����T�[�r�X���{���ZII
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5019");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5029");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5039");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5049");
	        		break;
	        	}
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
	            // �ʏ��^�T�[�r�X�^����@�\������Z
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5012");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5022");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5032");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5042");
	        		break;
	        	}
	            break;
	        // �h�{���P���Z
	        case 121:
	            // �ʏ��^�T�[�r�X�h�{���P���Z
	        	switch (pattern) {
	        	case 1:
		            putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
		    		break;
		    	case 2:
		    		putSystemServiceCodeItem(sysSvcCdItems, "Z5013");
		    		break;
		    	case 3:
		    		putSystemServiceCodeItem(sysSvcCdItems, "Z5023");
		    		break;
		    	case 4:
		    		putSystemServiceCodeItem(sysSvcCdItems, "Z5033");
		    		break;
		    	case 5:
		    		putSystemServiceCodeItem(sysSvcCdItems, "Z5043");
		    		break;
		    	}
	            break;
	        // ���o�@�\������Z
	        case 112:
	            // �ʏ��^�T�[�r�X���o�@�\������Z
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5014");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5024");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5034");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5044");
	        		break;
	        	}
	            break;
	        // �^����@�\������Z + �h�{���P���Z
	        case 221:
	            // �ʏ��^�����T�[�r�X���{���ZI�P
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5016");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5026");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5036");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5046");
	        		break;
	        	}
	            break;
	        // �^����@�\������Z + ���o�@�\������Z
	        case 212:
	            // �ʏ��^�����T�[�r�X���{���ZI�Q
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5017");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5027");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5037");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5047");
	        		break;
	        	}
	            break;
	        // �h�{���P���Z + ���o�@�\������Z
	        case 122:
	            // �ʏ��^�����T�[�r�X���{���ZI�R
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5018");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5028");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5038");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5048");
	        		break;
	        	}
	            break;
	        // �^����@�\������Z + �h�{���P���Z + ���o�@�\������Z
	        case 222:
	            // �ʏ��^�����T�[�r�X���{���ZII
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5019");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5029");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5039");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5049");
	        		break;
	        	}
	            break;
	        }
        }
    }

    /**
     * �p�^�[���ɂ��������Z��ݒ肵�܂��B
	 * @param _5060110 �ʏ��^�T�[�r�X��N���F�m�ǎ�����Z
	 * @param _16      �ʏ��^�T�[�r�X���ꌚ�����Z
	 * @param _5060101 �ʏ��^�T�[�r�X��@1-�P 2-�Q
	 * @param _5060105 �����@�\����O���[�v�������Z
	 * @param _5060109 ���Ə��]�����Z
	 * @param sysSvcCdItems �T�[�r�X�R�[�hMap
	 * @param pattern �p�^�[��
     */
    private void setKasanServiceByPattern(int _5060110, int _16, int _5060101, int _5060105, int _5060109,
    		ArrayList<HashMap<String, String>> sysSvcCdItems,
    		int pattern) {
        // �ʏ��^�T�[�r�X��N���F�m�ǎ�����Z
        if (_5060110 > 1) {
        	switch (pattern) {
        	case 1:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        		break;
        	case 2:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
        		break;
        	case 3:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z6139");
        		break;
        	case 4:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z6149");
        		break;
        	case 5:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z6159");
        		break;
        	}
        }
        
        // ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂�����̏ꍇ
        if (_16 > 1) {
            
            // �ʏ��^�T�[�r�X��ŕ���
            switch(_5060101) {
            // �ʏ��^�T�[�r�X�P
            case 1:
                // �ʏ��^�T�[�r�X���ꌚ�����Z�P
            	switch (pattern) {
            	case 1:
	                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6125");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6135");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6145");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6155");
	        		break;
            	}
                break;
            // �ʏ��^�T�[�r�X�Q
            case 2:
                // �ʏ��^�T�[�r�X���ꌚ�����Z�Q
            	switch (pattern) {
            	case 1:
	                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6126");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6136");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6146");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6156");
	        		break;
            	}
                break;
            }
            
        }
        
        // �����@�\����O���[�v�������Z�@1-�Ȃ� 2-����
        if (_5060105 > 1) {
        	switch (pattern) {
        	case 1:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5010");
        		break;
        	case 2:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5020");
        		break;
        	case 3:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5030");
        		break;
        	case 4:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5040");
        		break;
        	case 5:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5050");
        		break;
        	}
        }
        
        // ���Ə��]�����Z�@1-�Ȃ� 2-����
        if (_5060109 > 1) {
        	switch (pattern) {
        	case 1:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5005");
        		break;
        	case 2:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5015");
        		break;
        	case 3:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5025");
        		break;
        	case 4:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5035");
        		break;
        	case 5:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5045");
        		break;
        	}
        }

    }
    
    /**
     * �T�[�r�X�񋟑̐��������Z��ݒ肵�܂��B
	 * @param kihon �ʏ��^�T�[�r�X��@1-�P 2-�Q
	 * @param teikyokasan �T�[�r�X�񋟑̐��������Z
	 * @param sysSvcCdItems �T�[�r�X�R�[�hMap
	 * @param pattern �p�^�[��
     */
    private void setServiceTeikyoKasanByPattern(int kihon, int teikyokasan,
    		ArrayList<HashMap<String, String>> sysSvcCdItems,
    		int pattern){
        switch (teikyokasan) {
        case 4:
            if (kihon == 1) {
                // �ʏ��^�T�[�r�X�P�̏ꍇ
                // 6101 �ʏ��^�T�[�r�X�񋟑̐����ZI�C�P
            	switch (pattern) {
            	case 1:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            		break;
            	case 2:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6127");
            		break;
            	case 3:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6137");
            		break;
            	case 4:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6147");
            		break;
            	case 5:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6157");
            		break;
            	}
            } else if (kihon == 2) {
                // �ʏ��^�T�[�r�X�Q�̏ꍇ
                // 6102 �ʏ��^�T�[�r�X�񋟑̐����ZI�C�Q
            	switch (pattern) {
            	case 1:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            		break;
            	case 2:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            		break;
            	case 3:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6138");
            		break;
            	case 4:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6148");
            		break;
            	case 5:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6158");
            		break;
            	}
            }
            break;
        case 2:
            if (kihon == 1) {
                // �ʏ��^�T�[�r�X�P�̏ꍇ
                // 6101 �ʏ��^�T�[�r�X�񋟑̐����ZI���P
            	switch (pattern) {
            	case 1:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            		break;
            	case 2:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
            		break;
            	case 3:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6131");
            		break;
            	case 4:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6141");
            		break;
            	case 5:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6151");
            		break;
            	}
            } else if (kihon == 2) {
                // �ʏ��^�T�[�r�X�Q�̏ꍇ
                // 6102 �ʏ��^�T�[�r�X�񋟑̐����ZI���Q
            	switch (pattern) {
            	case 1:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            		break;
            	case 2:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6122");
            		break;
            	case 3:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6132");
            		break;
            	case 4:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6142");
            		break;
            	case 5:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6152");
            		break;
            	}
            }
            break;
        case 3:
            if (kihon == 1) {
                // �ʏ��^�T�[�r�X�P�̏ꍇ
                // 6103 �ʏ��^�T�[�r�X�񋟑̐����ZII�P
            	switch (pattern) {
            	case 1:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            		break;
            	case 2:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
            		break;
            	case 3:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            		break;
            	case 4:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6143");
            		break;
            	case 5:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6153");
            		break;
            	}
            } else if (kihon == 2) {
                // �ʏ��^�T�[�r�X�Q�̏ꍇ
                // 6104 �ʏ��^�T�[�r�X�񋟑̐����ZII�Q
            	switch (pattern) {
            	case 1:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            		break;
            	case 2:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6124");
            		break;
            	case 3:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            		break;
            	case 4:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6144");
            		break;
            	case 5:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6154");
            		break;
            	}
            }
            break;
        }
    }
}
