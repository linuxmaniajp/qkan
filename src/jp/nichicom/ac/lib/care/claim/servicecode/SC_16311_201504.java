package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���\�h�K��Ō�
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_16311_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "���\�h�K��Ō�";
    }

    public String getServiceCodeKind() {
        return "63";
    }

    public String getSystemServiceKindDetail() {
        return "16311";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
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

        // 1630101 �{�ݓ��̋敪�@1-�w��K��Ō�X�e�[�V���� 2-�a�@���͐f�Ï�
        int _1630101 = getIntValue(map, "1630101", 1);

        // 1630102 �E���敪�@1-���œ� 2-�y�� 3-PT�AOT�AST
        int _1630102 = getIntValue(map, "1630102", 1);

        // 1630107 ���ԋ敪�@1-20������ 2-30������ 3-30���ȏ�A1���Ԗ��� 4-1���Ԉȏ�A1���Ԕ�����
        int _1630107 = getIntValue(map, "1630107", 1);

        // 1630110 �����ԖK��Ō���Z
        int _1630110 = getIntValue(map, "1630110", 1);

        // 1630104 ���ԑс@1-�ʏ� 2-���� 3-��� 4-�[��
        // �ϊ���1-�ʏ� 2-��ԑ��� 3-�[��
        int _1630104 = getIntValue(map, "1630104", 1);
        // �}�X�^�ɍ��킹�A�l��ϊ�
        switch (_1630104) {
        case 1: // 1-�ʏ� => 1-�ʏ�
            _1630104 = 1;
            break;
        case 2: // 2-���� => 2-��ԑ��� 
            _1630104 = 2;
            break;
        case 3: // 3-��� => 2-��ԑ���
            _1630104 = 2;
            break;
        case 4: // 4-�[�� => 3-�[��
            _1630104 = 3;
            break;
        }

        // 1630105 �ً}���K��Ō���Z�@1-�Ȃ� 2-����
        int _1630105 = getIntValue(map, "1630105", 1);

        // 1630106 ���ʊǗ����Z�@1-�Ȃ� 2-����
        int _1630106 = getIntValue(map, "1630106", 1);

        // 2 ���ʒn����Z
        int _2 = getIntValue(map, "2");

        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // ���R�Ԓn�擙���K�͎��Ə����Z
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 1630108 �K��҂̐l��
        int _1630108 = getIntValue(map, "1630108");
        
        // 1630109 �T�[�r�X�񋟑̐��������Z
        int _1630109 = getIntValue(map, "1630109");

        // 1630111 2�l�ڂ̖K�⎞��
        int _1630111 = getIntValue(map, "1630111", 1);
        

        // 1630112 ������Z
        int _1630112 = getIntValue(map, "1630112", 1);

        // 1630113 �މ@�������w�����Z
        int _1630113 = getIntValue(map, "1630113", 1);
        
        // 1630116 1����2����z���Ď��{
        int _1630116 = getIntValue(map, "1630116", 1);
        
        // �Ō�̐��������Z
        int _1630117 = getIntValue(map, "1630117", 1);
        
        
        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);
        
        // ���Z�̂�(�މ@�������w�����Z�Ή�)
        int _9 = getIntValue(map,"9");
        
        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // �\�h�K��Ō�މ@�������w�����Z
            if (_1630113 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
            }
            
            return sysSvcCdItems;
        }


        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪�@1-�w��K��Ō�X�e�[�V���� 2-�a�@���͐f�Ï�
        sb.append(CODE_CHAR[_1630101]);

        // ���ԋ敪�@1-20������ 2-30������ 3-30���ȏ�A1���Ԗ��� 4-1���Ԉȏ�A1���Ԕ�����
        sb.append(CODE_CHAR[_1630107]);

        // �E���敪�@1-���œ� 2-�y�� 3-PT�AOT�AST
        sb.append(CODE_CHAR[_1630102]);
        
        // ���ꌚ�����Z�҂ւ̃T�[�r�X��
        sb.append(CODE_CHAR[_16]);
        
        // ���ԑс@�ϊ���1-��ԑ��� 2-�[�� 3-�ʏ�
        sb.append(CODE_CHAR[_1630104]);
        
        // �K��҂̐l��
        sb.append(CODE_CHAR[_1630108]);
        
        // 2�l�ڂ̖K�⎞��
        sb.append(CODE_CHAR[_1630111]);
        
        // 1630110 �����ԖK��Ō���Z
        sb.append(CODE_CHAR[_1630110]);
        
        // 1����2����z���Ď��{
        sb.append(CODE_CHAR[_1630116]);
        
        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        // ���ʒn����Z
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
        }
        
        // 8100 �\�h�K��Ō쏬�K�͎��Ə����Z
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
        }
        
        // 8110 �\�h�K��Ō쒆�R�Ԓn�擙�񋟉��Z
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // �ً}���K��Ō���Z�@1-�Ȃ� 2-����
        if (_1630105 > 1) {
            switch (_1630101) {
            case 1: // �w��K��Ō�X�e�[�V����
                putSystemServiceCodeItem(sysSvcCdItems, "Z3100");
                break;
            case 2: // �a�@���͐f�Ï�
                putSystemServiceCodeItem(sysSvcCdItems, "Z3200");
                break;
            default:
                break;
            }
        }
        
        // ���ʊǗ����Z
        switch(_1630106) {
        case 2:
            // �\�h�K��Ō���ʊǗ����ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
            break;
        case 3:
            // �\�h�K��Ō���ʊǗ����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
            break;
        }

        // ������Z
        if (_1630112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
        }

        // �\�h�K��Ō�މ@�������w�����Z
        if (_1630113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
        }
        
        // �Ō�̐��������Z
        if (_1630117 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4005");//TODO:�R�[�h�l�m�F
        }
        
        // 6101 �\�h�K��Ō�T�[�r�X�񋟑̐����Z
        if (_1630109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
        }
        
        
        return sysSvcCdItems;
    }
}
