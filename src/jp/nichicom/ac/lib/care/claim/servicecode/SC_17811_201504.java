package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �n�斧���^�ʏ����
 * 
 * @since V7.2.0
 * @author S.Hitaka
 * 
 */
public class SC_17811_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�n�斧���^�ʏ����";
    }

    public String getServiceCodeKind() {
        return "78";
    }

    public String getSystemServiceKindDetail() {
        return "17811";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1780101 �{�݋敪
        int _1780101 = getIntValue(map, "1780101");

        // 1780102 ���ԋ敪
        int _1780102 = getIntValue(map, "1780102");

        // 1780103 �l�����Z
        int _1780103 = getIntValue(map, "1780103");

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 12 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // 1780104 �������Z
        int _1780104 = getIntValue(map, "1780104");

        // 1780105 ���d�x�҃P�A�̐����Z
        int _1780105 = getIntValue(map, "1780105");

        // 1780106 �ʋ@�\�P���w�����ZI�^
        int _1780106 = getIntValue(map, "1780106");

        // 1780107 �ʋ@�\�P���w�����ZII�^
        int _1780107 = getIntValue(map, "1780107");

        // 1780108 �F�m�ǉ��Z
        int _1780108 = getIntValue(map, "1780108");

        // 1780109 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1780109 = getIntValue(map, "1780109", 1);

        // 1780110 �h�{���P���Z
        int _1780110 = getIntValue(map, "1780110");

        // 1780111 ���o�@�\������Z
        int _1780111 = getIntValue(map, "1780111");

        // 1780112 �ʑ��}�̐��������Z
        int _1780112 = getIntValue(map, "1780112");

        // 1780113 ������̐��������Z
        int _1780113 = getIntValue(map, "1780113");

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);

        // 18 ���}���Z
        int _18 = getIntValue(map, "18");

        // 1780114 �T�[�r�X�񋟑̐��������Z
        int _1780114 = getIntValue(map, "1780114");

        // 17 ���E���������P���Z
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1780101]);

        // ���ԋ敪
        // �×{�ʏ��̏ꍇ
        if (_1780101 == 2) {
            sb.append(DEFAULT_CHAR);
            sb.append(CODE_CHAR[_1780102]);
        } else {
            sb.append(CODE_CHAR[_1780102]);
            sb.append(DEFAULT_CHAR);
        }

        // �l�����Z
        sb.append(CODE_CHAR[_1780103]);

        // �v���x
        if (_1780101 == 2) {
            // �×{�ʏ��̏ꍇ�A�v���x�͖��֌W
            sb.append(Qkan10011_ServiceUnitGetter.DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // 8110 �ʏ���쒆�R�Ԓn�擙�񋟉��Z
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // �������Z
        if (_1780104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        // ���d�x�҃P�A�̐����Z
        if (_1780105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5306");
        }
        
        // �ʋ@�\�P���w�����ZI
        if (_1780106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5051");
        }
        
        // �ʋ@�\�P���w�����ZII
        if (_1780107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5052");
        }
        
        // �F�m�ǉ��Z
        if (_1780108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5305");
        }
        
        // ��N���F�m�Ǘ��p�Ҏ�����Z
        if (_1780109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // �h�{���P���Z
        if (_1780110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5605");
        }
        
        // ���o�@�\������Z
        if (_1780111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // �ʑ��}�̐��������Z
        if (_1780112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5613");
        }
        
        // ������̐��������Z
        if (_1780113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5614");
        }
        
        // ���ꌚ�����Z�҂ւ̃T�[�r�X��
        if (_16 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }
        
        // ���}���Z
        switch (_18) {
        case 3: // ����
            putSystemServiceCodeItem(sysSvcCdItems, "Z56122");
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z56121");
            break;
        }
        
        
        // �T�[�r�X�񋟑̐����Z
        switch (_1780114) {
        // �T�[�r�X�񋟑̐����ZI�C
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            break;
        // �T�[�r�X�񋟑̐����ZI��
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        // �T�[�r�X�񋟑̐����ZII
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        // �T�[�r�X�񋟑̐����ZIII
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // ���E���������P��ԋp
        switch(_17){
        // �������P���ZI
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
            break;
        // �������P���ZII
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            break;
        // �������P���ZIII
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        // �������P���ZIV
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        // �������P���ZV
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        }

        return sysSvcCdItems;
    }
}
