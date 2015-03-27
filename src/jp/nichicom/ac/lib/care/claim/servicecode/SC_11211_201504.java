package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �K��������
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_11211_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�K��������";
    }

    public String getServiceCodeKind() {
        return "12";
    }

    public String getSystemServiceKindDetail() {
        return "11211";
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
            return new ArrayList<HashMap<String, String>>();
        }

        // 1120103 �K��Ҏ��
        int _1120103 = getIntValue(map, "1120103");
        // 1120104 �������敪
        int _1120104 = getIntValue(map, "1120104");
        // 2 ���ʒn����Z
        int _2 = getIntValue(map, "2");
        // 13 ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə�
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);
        // 12 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);
        // 1120105 �T�[�r�X�񋟑̐��������Z
        int _1120105 = getIntValue(map, "1120105");
        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);

        // 17 �������P���Z
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �K��Ҏ��
        sb.append(CODE_CHAR[_1120103]);
        // �������敪
        sb.append(CODE_CHAR[_1120104]);
        // ���ꌚ�����Z�҂ւ̃T�[�r�X��
        sb.append(CODE_CHAR[_16]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // ���ʒn����Z
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
        }

        // �K��������K�͎��Ə����Z
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
        }

        // �K��������R�Ԓn�擙�񋟉��Z
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }

        // �K������T�[�r�X�񋟑̐����Z
        switch (_1120105) {
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        }
        
        // �������P���Z
        switch(_17){
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        }

        return sysSvcCdItems;
    }

}
