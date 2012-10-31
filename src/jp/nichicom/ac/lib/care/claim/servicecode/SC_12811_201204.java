package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �n�斧���^����{�ݓ����Ґ������i�Z�����p�j
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_12811_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�n�斧���^����{�ݓ����Ґ������(�Z�����p)";
    }

    public String getServiceCodeKind() {
        return "28";
    }

    public String getSystemServiceKindDetail() {
        return "12811";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1280101 �l�����Z
        int _1280101 = getIntValue(map, "1280101");

        // 1280102 ��ԊŌ�̐����Z
        int _1280102 = getIntValue(map, "1280102");

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // =========================================================================
        StringBuilder sb = new StringBuilder();

        // �v���x
        sb.append(CODE_CHAR[_1]);
        // �l�����Z
        sb.append(CODE_CHAR[_1280101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // =========================================================================
        // ��ԊŌ�̐����Z
        if (_1280102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2000");
        }

        // ���E���������P��ԋp
        switch (_17) {
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
