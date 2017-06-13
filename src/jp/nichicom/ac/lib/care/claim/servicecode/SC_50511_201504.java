package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �ʏ��^�T�[�r�X(�݂Ȃ�)
 * 
 * @since V7.2.1
 * @author Yoichiro.Kamei
 * 
 */
public class SC_50511_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�ʏ��^�T�[�r�X(�݂Ȃ�)";
    }

    public String getServiceCodeKind() {
        return "A5";
    }

    public String getSystemServiceKindDetail() {
        return "50511";
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
        
        // �ʏ��^�T�[�r�X��@1-�P 2-�Q
        int _5050101 = getIntValue(map, "5050101", 1);
        
        // ���ƑΏێ҂ł͂Ȃ��Ƃ��A�v���x�ɂ���Ēʏ��^�T�[�r�X������
        if (_1 == 3) {
            // �v�x���P�̏ꍇ
        	_5050101 = 1; //�ʏ��^�T�[�r�X�P
        } else if (_1 == 4) {
            // �v�x���Q�̏ꍇ
        	_5050101 = 2; //�ʏ��^�T�[�r�X�Q
        }
        
        // �񐔁@1-�񐔂łȂ� 2-�񐔂ł���
        int _5050102 = getIntValue(map, "5050102", 1);
        
        // 5050103 �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E��������
        int _5050103 = getIntValue(map, "5050103", 1);

        // 5050104 �����@1-�����łȂ� 2-�����ł���
        int _5050104 = getIntValue(map, "5050104", 1);

        // 5050105 �����@�\����O���[�v�������Z�@1-�Ȃ� 2-����
        int _5050105 = getIntValue(map, "5050105", 1);

        // 5050106 �^����@�\������Z�@1-�Ȃ� 2-����
        int _5050106 = getIntValue(map, "5050106", 1);

        // 5050107 �h�{���P���Z�@1-�Ȃ� 2-����
        int _5050107 = getIntValue(map, "5050107", 1);

        // 5050108 ���o�@�\������Z�@1-�Ȃ� 2-����
        int _5050108 = getIntValue(map, "5050108", 1);

        // 5050109 ���Ə��]�����Z�@1-�Ȃ� 2-����
        int _5050109 = getIntValue(map, "5050109", 1);

        // 5050110 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _5050110 = getIntValue(map, "5050110", 1);

        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // 5050111 �T�[�r�X�񋟑̐��������Z
        int _5050111 = getIntValue(map, "5050111");

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
            // 5050106 �^����@�\������Z�@1-�Ȃ� 2-����
            if (_5050106 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
            }
            
            // 5050107 �h�{���P���Z�@1-�Ȃ� 2-����
            if (_5050107 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
            }
            
            // 5050108 ���o�@�\������Z�@1-�Ȃ� 2-����
            if (_5050108 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
            }
            
            // ���E���������P��ԋp
            switch (_17) {
            case 5:
                // �ʏ��^�T�[�r�X�������P���ZI
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
                break;
            case 2:
                // �ʏ��^�T�[�r�X�������P���ZI
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                break;
            case 3:
                // �ʏ��^�T�[�r�X�������P���ZII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
                break;
            case 4:
                // �ʏ��^�T�[�r�X�������P���ZIII
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
        sb.append(CODE_CHAR[_5050101]);
        
        // �v���x
        sb.append(CODE_CHAR[_1]);
        
        // ��
        sb.append(CODE_CHAR[_5050102]);

        // �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E��������
        sb.append(CODE_CHAR[_5050103]);

        // �����@1-�����łȂ� 2-�����ł���
        sb.append(CODE_CHAR[_5050104]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        
        // 6109 �ʏ��^�T�[�r�X��N���F�m�ǎ�����Z
        if (_5050110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂�����̏ꍇ
        if (_16 > 1) {
            
            // �ʏ��^�T�[�r�X��ŕ���
            switch(_5050101) {
            // �ʏ��^�T�[�r�X�P
            case 1:
                // �ʏ��^�T�[�r�X���ꌚ�����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            // �ʏ��^�T�[�r�X�Q
            case 2:
                // �ʏ��^�T�[�r�X���ꌚ�����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }
            
        }
        
        // �����@�\����O���[�v�������Z�@1-�Ȃ� 2-����
        if (_5050105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5010");
        }
        
        // �^����@�\������Z�A�h�{���P���Z�A���o�@�\������Z�̗�O����
        // 
        // [�^����@�\������Z�̃t���O][�h�{���P���Z�̃t���O][���o�@�\������Z�̃t���O]
        // �Ƃ������т�3���̐��l���쐬���ĕ���i�t���O�� 1-�Ȃ� 2-����j
        int addParam = (_5050106 * 100) + (_5050107 * 10) + _5050108;
        
        switch(addParam) {
        // �^����@�\������Z
        case 211:
            // �ʏ��^�T�[�r�X�^����@�\������Z
            putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
            break;
        // �h�{���P���Z
        case 121:
            // �ʏ��^�T�[�r�X�h�{���P���Z
            putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
            break;
        // ���o�@�\������Z
        case 112:
            // �ʏ��^�T�[�r�X���o�@�\������Z
            putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
            break;
        // �^����@�\������Z + �h�{���P���Z
        case 221:
            // �ʏ��^�����T�[�r�X���{���ZI�P
            putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
            break;
        // �^����@�\������Z + ���o�@�\������Z
        case 212:
            // �ʏ��^�����T�[�r�X���{���ZI�Q
            putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
            break;
        // �h�{���P���Z + ���o�@�\������Z
        case 122:
            // �ʏ��^�����T�[�r�X���{���ZI�R
            putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
            break;
        // �^����@�\������Z + �h�{���P���Z + ���o�@�\������Z
        case 222:
            // �ʏ��^�����T�[�r�X���{���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
            break;
        }
        
        // ���Ə��]�����Z�@1-�Ȃ� 2-����
        if (_5050109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5005");
        }
        
        switch (_5050111) {
        case 4:
            if (_5050101 == 1) {
                // �ʏ��^�T�[�r�X�P�̏ꍇ
                // 6101 �ʏ��^�T�[�r�X�񋟑̐����ZI�C�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            } else if (_5050101 == 2) {
                // �ʏ��^�T�[�r�X�Q�̏ꍇ
                // 6102 �ʏ��^�T�[�r�X�񋟑̐����ZI�C�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            }
            break;
        case 2:
            if (_5050101 == 1) {
                // �ʏ��^�T�[�r�X�P�̏ꍇ
                // 6101 �ʏ��^�T�[�r�X�񋟑̐����ZI���P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            } else if (_5050101 == 2) {
                // �ʏ��^�T�[�r�X�Q�̏ꍇ
                // 6102 �ʏ��^�T�[�r�X�񋟑̐����ZI���Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            }
            break;
        case 3:
            if (_5050101 == 1) {
                // �ʏ��^�T�[�r�X�P�̏ꍇ
                // 6103 �ʏ��^�T�[�r�X�񋟑̐����ZII�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            } else if (_5050101 == 2) {
                // �ʏ��^�T�[�r�X�Q�̏ꍇ
                // 6104 �ʏ��^�T�[�r�X�񋟑̐����ZII�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            }
            break;
        }
        
        
        // ���E���������P��ԋp
        switch (_17) {
        case 5:
            // �ʏ��^�T�[�r�X�������P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
            break;
        case 2:
            // �ʏ��^�T�[�r�X�������P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
            break;
        case 3:
            // �ʏ��^�T�[�r�X�������P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
            break;
        case 4:
            // �ʏ��^�T�[�r�X�������P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
            break;
        }
        
        
        // ������ł͂Ȃ��ꍇ
        if (_5050104 == 1) {
            
            // ���P�ʃT�[�r�X�̏ꍇ
            if (_5050102 == 1) {
                // 8110 �ʏ��^�T�[�r�X���R�Ԓn�擙�񋟉��Z
                if (_12 > 1) {
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
                }
                
            // �񐔒P�ʃT�[�r�X�̏ꍇ
            } else if (_5050102 == 2) {
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

}
