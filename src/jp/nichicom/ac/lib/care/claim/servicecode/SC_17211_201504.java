package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SC_17211_201504 extends Qkan10011_ServiceUnitGetter {

    public String getServiceName() {
        return "�F�m�ǑΉ��^�ʏ����";
    }

    public String getServiceCodeKind() {
        return "72";
    }

    public String getSystemServiceKindDetail() {
        return "17211";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1720101 �{�݋敪
        int _1720101 = getIntValue(map, "1720101");

        // 1720102 �敪
        int _1720102 = getIntValue(map, "1720102");

        // 1720103 ���ԋ敪
        int _1720103 = getIntValue(map, "1720103");

        // 1720104 �l�����Z
        int _1720104 = getIntValue(map, "1720104");

        // 1720107 �ʋ@�\�P���w�����Z
        int _1720107 = getIntValue(map, "1720107");

        // 1720106 ��������Z
        int _1720106 = getIntValue(map, "1720106");

        // 1720105 �h�{���P���Z
        int _1720105 = getIntValue(map, "1720105");

        // 1720108 ���o�@�\������Z
        int _1720108 = getIntValue(map, "1720108");

        // 1720109 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1720109 = getIntValue(map, "1720109");

        // 1720110 �T�[�r�X�񋟑̐��������Z
        int _1720110 = getIntValue(map, "1720110");

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16");
        
        // 18 ���}���Z
        int _18 = getIntValue(map, "18");

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1720101]);

        // �敪
        sb.append(CODE_CHAR[_1720102]);

        // ���ԋ敪
        sb.append(CODE_CHAR[_1720103]);

        // �l�����Z
        sb.append(CODE_CHAR[_1720104]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        // ��������Z
        if (_1720106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        // �ʋ@�\�P���w�����Z
        if (_1720107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5050");
        }
        
        // 6109 �\�F�ʏ�����N���F�m�ǎ�����Z
        if (_1720109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }

        // �h�{���P���Z
        if (_1720105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // ���o�@�\������Z
        if (_1720108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5607");
        }

        // �F�m�ʏ���쑗�}���Z(���ꌚ�����Z�҂ւ̃T�[�r�X��)
        if (_16 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }

        // ���}���Z
        switch (_18) {
        case 3: // ����
            putSystemServiceCodeItem(sysSvcCdItems, "Z56122");//2015.04
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z56121");//2015.04
            break;
        }
        
        switch (_1720110) {
        case 4:
            // 6100 �\�F�ʉ�T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 �\�F�ʉ�T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 �\�F�ʉ�T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        }

        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        }

        return sysSvcCdItems;
    }

}
