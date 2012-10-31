package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���\�h�F�m�ǑΉ��^�ʏ����
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_17411_201204 extends Qkan10011_ServiceUnitGetter {

    public String getServiceName() {
        return "���\�h�F�m�ǑΉ��^�ʏ����";
    }

    public String getServiceCodeKind() {
        return "74";
    }

    public String getSystemServiceKindDetail() {
        return "17411";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1740101 �{�ݓ��̋敪1�@1-�T�^ 2-�U�^
        int _1740101 = getIntValue(map, "1740101", 1);

        // 1740102 �{�ݓ��̋敪2�@1-�P�ƌ^ 2-���݌^
        int _1740102 = getIntValue(map, "1740102", 1);

        // 1740103 ���ԋ敪�@1-2�`3���� 2-3�`4���� 3-4�`6���� 4-6�`8���� 5-8�`9���� 6-9�`10����
        int _1740103 = getIntValue(map, "1740103", 1);

        // 1740104 �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E���̕s��
        int _1740104 = getIntValue(map, "1740104", 1);

        // 1740105 ��������Z�@1-�Ȃ� 2-����
        int _1740105 = getIntValue(map, "1740105", 1);

        // 1740106 �ʋ@�\�P���w�����Z�@1-�Ȃ� 2-����
        int _1740106 = getIntValue(map, "1740106", 1);

        // 1740107 �h�{���P���Z�@1-�Ȃ� 2-����
        int _1740107 = getIntValue(map, "1740107", 1);

        // 1740108 ���o�@�\������Z�@1-�Ȃ� 2-����
        int _1740108 = getIntValue(map, "1740108", 1);

        // 1740109 ��N���F�m�Ǘ��p�Ҏ�����Z�@1-�Ȃ� 2-����
        int _1740109 = getIntValue(map, "1740109", 1);

        // 1740110 �T�[�r�X�񋟑̐��������Z�@1-�Ȃ� 2-I�^ 3-II�^
        int _1740110 = getIntValue(map, "1740110", 1);

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪1�@1-�T�^ 2-�U�^
        sb.append(CODE_CHAR[_1740101]);

        // �{�ݓ��̋敪2�@1-�P�ƌ^ 2-���݌^
        sb.append(CODE_CHAR[_1740102]);

        // ���ԋ敪�@1-2�`3���� 2-3�`4���� 3-4�`6���� 4-6�`8���� 5-8�`9���� 6-9�`10����
        sb.append(CODE_CHAR[_1740103]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E���̕s������
        sb.append(CODE_CHAR[_1740104]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        // ��������Z�@1-�Ȃ� 2-����
        if (_1740105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        // �ʋ@�\�P���w�����Z�@1-�Ȃ� 2-����
        if (_1740106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5050");
        }
        
        // 6109 �\�F�ʏ�����N���F�m�ǎ�����Z
        if (_1740109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // �h�{���P���Z�@1-�Ȃ� 2-����
        if (_1740107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // ���o�@�\������Z�@1-�Ȃ� 2-����
        if (_1740108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5607");
        }
        
        // ���ꌚ�����Z�҂ւ̃T�[�r�X�� 1-�Ȃ� 2-����
        if (_16 > 1) {
            // �\�F�ʏ���쑗�}���Z
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }
        
        switch (_1740110) {
        case 2:
            // 6101 �\�F�ʉ�T�[�r�X�񋟑̐����ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 �\�F�ʉ�T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        }
        
        // ���E���������P��ԋp
        switch (_17) {
        case 2:
            // �\�F�ʏ���쏈�����P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        case 3:
            // �\�F�ʏ���쏈�����P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 4:
            // �\�F�ʏ���쏈�����P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        }

        return sysSvcCdItems;
    }
}
