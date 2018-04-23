package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ����{�ݓ����Ґ������i�Z�����p�j
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12711_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "����{�ݓ����Ґ������(�Z�����p)";
    }

    public String getServiceCodeKind() {
        return "27";
    }

    public String getSystemServiceKindDetail() {
        return "12711";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        
        // 1270101 �l�����Z
        int _1270101 = getIntValue(map, "1270101");

        // 1270102 ��ԊŌ�̐����Z
        int _1270102 = getIntValue(map, "1270102");
        
        // 1270104 ��N���F�m�ǎ�����Z
        int _1270104 = getIntValue(map, "1270104");        
        
        // 1270103 �T�[�r�X�񋟑̐��������Z
        int _1270103 = getIntValue(map, "1270103", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // =========================================================================
        StringBuilder sb = new StringBuilder();
        
        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �l�����Z
        sb.append(CODE_CHAR[_1270101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // =========================================================================
        // ��ԊŌ�̐����Z
        if (_1270102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z1160");
        }
        
        // 1270104 ��N���F�m�ǎ�����Z
        if (_1270104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");//2018.04
        }
        
        // �T�[�r�X�񋟑̐����Z
        switch (_1270103) {
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
