package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �����^�T�[�r�X�i�Ō쏬�K�͑��@�\�^������E�Z�����p�j
 * 
 * @since V7.0.0
 * @author Shinobu Hitaka
 * 
 */
public class SC_17911_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�����^�T�[�r�X(�Ō쏬�K�͑��@�\�^������E�Z�����p)";
    }

    public String getServiceCodeKind() {
        return "79";
    }

    public String getSystemServiceKindDetail() {
        return "17911";
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
        case 3: // �v�x���P
        case 4: // �v�x���Q
        case 10: // ���ƑΏێ�
            return new ArrayList<HashMap<String, String>>();
        }

        // 1790101 �l�����Z
        int _1790101 = getIntValue(map, "1790101", 1);

        // 1790102 �T�[�r�X�񋟑̐��������Z
        int _1790102 = getIntValue(map, "1790102", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �Ȃ�

        // �Ǝ��R�[�h����
        // =========================================================================
        StringBuilder sb = new StringBuilder();

        // �v���x
        sb.append(CODE_CHAR[_1]);
        
        // �l�����Z
        sb.append(CODE_CHAR[_1790101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
        

        // ���Z
        // =========================================================================

        // 1790102 �T�[�r�X�񋟑̐��������Z
        switch (_1790102) {
        case 5:
            // �����^�T�[�r�X�i�Ō쏬�K�͑��@�\�^������E�Z�����p�j�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");//2015.04
            break;
        case 2:
            // �����^�T�[�r�X�i�Ō쏬�K�͑��@�\�^������E�Z�����p�j�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//2015.04
            break;
        case 3:
            // �����^�T�[�r�X�i�Ō쏬�K�͑��@�\�^������E�Z�����p�j�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");//2015.04
            break;
        case 4:
            // �����^�T�[�r�X�i�Ō쏬�K�͑��@�\�^������E�Z�����p�j�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");//2015.04
            break;
        }

        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6114");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");//2015.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");//2015.04
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
            break;
        }

        return sysSvcCdItems;
    }
}
