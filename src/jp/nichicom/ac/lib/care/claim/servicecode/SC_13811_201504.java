package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �F�m�ǑΉ��^�����������(�Z�����p)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13811_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�F�m�ǑΉ��^�����������(�Z�����p)";
    }

    public String getServiceCodeKind() {
        return "38";
    }

    public String getSystemServiceKindDetail() {
        return "13811 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1380102 ��ԋΖ������ 1-�������Ă��� 2-�������Ă��Ȃ�
        int _1380102 = getIntValue(map, "1380102");

        // 1380101 �l�����Z 1-�Ȃ� 2-������� 3-���]�ƈ��s��
        int _1380101 = getIntValue(map, "1380101");

        // 1380103 ��ØA�g�̐����Z 1-�Ȃ� 2-����
        int _1380103 = getIntValue(map, "1380103");

        // 1380104 ��Ԏx���̐����Z
        int _1380104 = getIntValue(map, "1380104");

        // 1380108 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1380108 = getIntValue(map, "1380108");

        // 1380105 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1380105 = getIntValue(map, "1380105");

        // 1380107 �T�[�r�X�񋟑̐��������Z
        int _1380107 = getIntValue(map, "1380107");

        // 1380110 �{�ݓ��̋敪
        int _1380110 = getIntValue(map, "1380110", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪
        sb.append(CODE_CHAR[_1380110]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // ��ԋΖ������ 1-�������Ă��� 2-�������Ă��Ȃ�
        sb.append(CODE_CHAR[_1380102]);

        // �l�����Z 1-�Ȃ� 2-������� 3-���]�ƈ��s��
        sb.append(CODE_CHAR[_1380101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        
        // Z6161 �Z������������Ԏx���̐����Z
        if (_1380104 > 1) {
            // �{�݋敪�ŕ���
            switch (_1380110) {
            case 1: // I�^
                // �Z������������Ԏx���̐����ZI
                putSystemServiceCodeItem(sysSvcCdItems, "Z6161");//2015.04
                break;
            case 2: // II�^
                // �Z������������Ԏx���̐����ZII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6171");//2015.04
                break;
            }
        }
        
        // 6121 �Z�����������F�m�ǋً}�Ή����Z
        if (_1380108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 6109 �Z������������N���F�m�ǎ�����Z
        if (_1380105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // ��ØA�g�̐����Z 1-�Ȃ� 2-����
        if (_1380103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z1600");
        }
        

        switch (_1380107) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 �Z�������T�[�r�X�񋟑̐����ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 �Z�������T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 �Z�������T�[�r�X�񋟑̐����ZIII
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
