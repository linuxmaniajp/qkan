package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �n�斧���^����{�ݓ����Ґ������
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13611_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�n�斧���^����{�ݓ����Ґ������";
    }

    public String getServiceCodeKind() {
        return "36";
    }

    public String getSystemServiceKindDetail() {
        return "13611";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1360102 �ʋ@�\�P���w�����Z 1-�Ȃ� 2-����
        int _1360102 = getIntValue(map, "1360102");

        // 1360101 �l�����Z 1-�Ȃ� 2-�Ō�E���E���s��
        int _1360101 = getIntValue(map, "1360101");

        // 1360103 ��ԊŌ�̐����Z 1-�Ȃ� 2-����
        int _1360103 = getIntValue(map, "1360103");

        // 1360104 ��Ë@�֘A�g���Z
        int _1360104 = getIntValue(map, "1360104");

        // 1360106 �Ŏ������Z
        int _1360106 = getIntValue(map, "1360106");

        // 1360107 �F�m�ǐ��P�A���Z
        int _1360107 = getIntValue(map, "1360107", 1);
        
        // 1360108 �T�[�r�X�񋟑̐��������Z
        int _1360108 = getIntValue(map, "1360108", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �l�����Z 1-�Ȃ� 2-�Ō�E���E���s��
        sb.append(CODE_CHAR[_1360101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // Z6003 �n�����{�݌ʋ@�\�P�����Z
        if (_1360102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
        }
        
        // Z6123 �n�����{�݈�Ë@�֘A�g���Z
        if (_1360104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }
        
        // ��ԊŌ�̐����Z 1-�Ȃ� 2-����
        if (_1360103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2000");
        }
        
        // 1360106 �Ŏ������Z
        switch(_1360106) {
        case 2:
            // �n�����{�݊Ŏ������Z�P
            putSystemServiceCodeItem(sysSvcCdItems, "Z6125");
            break;
        case 3:
            // �n�����{�݊Ŏ������Z�Q
            putSystemServiceCodeItem(sysSvcCdItems, "Z6126");
            break;
        case 4:
            // �n�����{�݊Ŏ������Z�R
            putSystemServiceCodeItem(sysSvcCdItems, "Z6127");
            break;
        }
        
        // 1360107 �F�m�ǐ��P�A���Z
        switch (_1360107) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");//2015.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");//2015.04
            break;
        }
        
        // 1360108 �T�[�r�X�񋟑̐����Z
        switch (_1360108) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//2015.04
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");//2015.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");//2015.04
            break;
        }
        
        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6132");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6131");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
            break;
        }

        return sysSvcCdItems;
    }
}
