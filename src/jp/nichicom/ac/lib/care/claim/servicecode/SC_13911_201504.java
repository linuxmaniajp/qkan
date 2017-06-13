package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���\�h�F�m�ǑΉ��^�����������(�Z�����p)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13911_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "���\�h�F�m�ǑΉ��^�����������(�Z�����p)";
    }

    public String getServiceCodeKind() {
        return "39";
    }

    public String getSystemServiceKindDetail() {
        return "13911";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1390101 �l�����Z�@1-�Ȃ� 2-������� 3-���]�ƈ��̕s��
        int _1390101 = getIntValue(map, "1390101", 1);

        // 1390102 ��ԋΖ�������@1-�������Ă��� 2-�������Ă��Ȃ�
        int _1390102 = getIntValue(map, "1390102", 1);

        // 1390103 ��Ԏx���̐����Z
        int _1390103 = getIntValue(map, "1390103", 1);

        // 1390107 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1390107 = getIntValue(map, "1390107", 1);

        // 1390104 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1390104 = getIntValue(map, "1390104", 1);

        // 1390106 �T�[�r�X�񋟑̐��������Z
        int _1390106 = getIntValue(map, "1390106", 1);

        // 1390109 �{�ݓ��̋敪
        int _1390109 = getIntValue(map, "1390109", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪
        sb.append(CODE_CHAR[_1390109]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // ��ԋΖ�������@1-�������Ă��� 2-�������Ă��Ȃ�
        sb.append(CODE_CHAR[_1390102]);

        // �l�����Z�@1-�Ȃ� 2-������� 3-���]�ƈ��̕s��
        sb.append(CODE_CHAR[_1390101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // 6161 �\�F�m�ǑΉ���Ԏx���̐����Z
        if (_1390103 > 1) {
            //�{�݋敪�ɂ�蕪��
            switch (_1390109) {
            case 1: // I�^
                putSystemServiceCodeItem(sysSvcCdItems, "Z6161");//2015.04
                break;
            case 2: // II�^
                putSystemServiceCodeItem(sysSvcCdItems, "Z6171");//2015.04
                break;
            }
        }
        
        // 6121 �\�Z�������F�m�ǋً}�Ή����Z
        if (_1390107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 6109 �\�F�m�ǑΉ���N���F�m�ǎ�����Z
        if (_1390104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        switch (_1390106) {
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
            // �\�Z�����������������P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
            break;
        case 5:
            // �\�Z�����������������P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            // �\�Z�����������������P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            // �\�Z�����������������P���ZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 4:
            // �\�Z�����������������P���ZV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        }

        return sysSvcCdItems;
    }
}
