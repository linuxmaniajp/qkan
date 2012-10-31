package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �ʏ����
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_11511_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�ʏ����";
    }

    public String getServiceCodeKind() {
        return "15";
    }

    public String getSystemServiceKindDetail() {
        return "11511";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1150113 �{�݋敪
        int _1150113 = getIntValue(map, "1150113");

        // 1150104 ���ԋ敪
        int _1150104 = getIntValue(map, "1150104");

        // 1150108 �l�����Z
        int _1150108 = getIntValue(map, "1150108");

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1150119 �ʋ@�\�P���w�����ZI�^
        int _1150119 = getIntValue(map, "1150119");
        
        // 1150120 �ʋ@�\�P���w�����ZII�^
        int _1150120 = getIntValue(map, "1150120");

        // 1150106 �������Z
        int _1150106 = getIntValue(map, "1150106");

        // 1150115 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1150115 = getIntValue(map, "1150115", 1);

        // 1150116 �h�{���P���Z
        int _1150116 = getIntValue(map, "1150116");

        // 1150112 ���o�@�\������Z
        int _1150112 = getIntValue(map, "1150112");

        // 12 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // 1150117 �T�[�r�X�񋟑̐��������Z
        int _1150117 = getIntValue(map, "1150117");

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1150113]);

        // ���ԋ敪
        // �×{�ʏ��̏ꍇ
        if (_1150113 == 5) {
            sb.append(DEFAULT_CHAR);
            sb.append(CODE_CHAR[_1150104]);
        } else {
            sb.append(CODE_CHAR[_1150104]);
            sb.append(DEFAULT_CHAR);
        }

        // �l�����Z
        sb.append(CODE_CHAR[_1150108]);

        // �v���x
        if (_1150113 == 5) {
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
        if (_1150106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        // �ʋ@�\�P���w�����ZI
        if (_1150119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5051");
        }
        
        // �ʋ@�\�P���w�����ZII
        if (_1150120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5052");
        }
        
        // ��N���F�m�Ǘ��p�Ҏ�����Z
        if (_1150115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // �h�{���P���Z
        if (_1150116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5605");
        }
        
        // ���o�@�\������Z
        if (_1150112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // ���ꌚ�����Z�҂ւ̃T�[�r�X��
        if (_16 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }
        
        // �ʏ����T�[�r�X�񋟑̐����Z
        switch (_1150117) {
        // 6101 �ʏ����T�[�r�X�񋟑̐����ZI
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        // 6102 �ʏ����T�[�r�X�񋟑̐����ZII
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        // 6103 �ʏ����T�[�r�X�񋟑̐����ZIII
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // ���E���������P��ԋp
        switch(_17){
        // �ʏ���쏈�����P���ZI
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        // �ʏ���쏈�����P���ZII
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        // �ʏ���쏈�����P���ZIII
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        }

        return sysSvcCdItems;
    }
}
