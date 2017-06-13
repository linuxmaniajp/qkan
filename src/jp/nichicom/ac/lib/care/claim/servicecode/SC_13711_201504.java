package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���\�h�F�m�ǑΉ��^�����������(�Z�����p�ȊO)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13711_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "���\�h�F�m�ǑΉ��^�����������(�Z�����p�ȊO)";
    }

    public String getServiceCodeKind() {
        return "37";
    }

    public String getSystemServiceKindDetail() {
        return "13711";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1370101 �������Z�@1-�Ȃ� 2-����
        int _1370101 = getIntValue(map, "1370101", 1);

        // 1370102 �l�����Z�@1-�Ȃ� 2-������� 3-���]�ƈ��̕s��
        int _1370102 = getIntValue(map, "1370102", 1);

        // 1370103 ��ԋΖ�������@1-�������Ă��� 2-�������Ă��Ȃ�
        int _1370103 = getIntValue(map, "1370103", 1);

        // 1370104 ��Ԏx���̐����Z
        int _1370104 = getIntValue(map, "1370104", 1);

        // 1370105 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1370105 = getIntValue(map, "1370105", 1);

        // 1370106 �F�m�ǐ��P�A���Z
        int _1370106 = getIntValue(map, "1370106", 1);

        // 1370108 �ދ������k�������Z
        int _1370108 = getIntValue(map, "1370108", 1);

        // 1370107 �T�[�r�X�񋟑̐��������Z
        int _1370107 = getIntValue(map, "1370107", 1);

        // 1370109 �{�ݓ��̋敪
        int _1370109 = getIntValue(map, "1370109", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        
        // ���Z�̂�(�މ@�������w�����Z�Ή�)
        int _9 = getIntValue(map, "9");
        
        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if (_9 == 2) {
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            
            // �������Z�@1-�Ȃ� 2-����
            if (_1370101 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z1550");
            }

            // �\�F�m�ǑΉ��ދ������k�������Z 2015.04 �ꉞ������
            if (_1370108 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
            }
            
            // ���E���������P��ԋp
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }

            return sysSvcCdItems;
        }
        
        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪
        sb.append(CODE_CHAR[_1370109]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // ��ԋΖ�������@1-�������Ă��� 2-�������Ă��Ȃ�
        sb.append(CODE_CHAR[_1370103]);

        // �l�����Z�@1-�Ȃ� 2-������� 3-���]�ƈ��̕s��
        sb.append(CODE_CHAR[_1370102]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        // �\�F�m�ǑΉ���Ԏx���̐����Z
        if (_1370104 > 1) {
            //�{�݋敪�ɂ�蕪��
            switch (_1370109) {
            case 1: // I�^
                putSystemServiceCodeItem(sysSvcCdItems, "Z6161");//2015.04
                break;
            case 2: // II�^
                putSystemServiceCodeItem(sysSvcCdItems, "Z6171");//2015.04
                break;
            }
        }
        
        // 6109 �\�F�m�ǑΉ���N���F�m�ǎ�����Z
        if (_1370105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // �������Z�@1-�Ȃ� 2-����
        if (_1370101 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z1550");
        }
        
        // 6502 �\�F�m�ǑΉ��ދ������k�������Z
        if (_1370108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
        }
        
        switch (_1370106) {
        case 2:
            // 6133 �\�F�m�ǑΉ��F�m�ǐ��P�A���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // 6134 �\�F�m�ǑΉ��F�m�ǐ��P�A���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }
        
        switch (_1370107) {
        case 5:
            // 6100 �\�F�m�Ή��T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 �\�F�m�Ή��T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 �\�F�m�Ή��T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 �\�F�m�Ή��T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        }

        return sysSvcCdItems;
    }
}
