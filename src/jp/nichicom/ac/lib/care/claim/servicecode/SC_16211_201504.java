package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SC_16211_201504 extends Qkan10011_ServiceUnitGetter {

    public String getServiceName() {
        return "���\�h�K��������";
    }

    public String getServiceCodeKind() {
        return "62";
    }

    public String getSystemServiceKindDetail() {
        return "16211";
    }

    protected ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // ���炩�ɗv���x�����������ꍇ�͋��Ԃ�
        switch (_1) {
        case 1: // ����
        case 2: // �o�ߓI�v���
        case 5: // �v���P
        case 6: // �v���Q
        case 7: // �v���R
        case 8: // �v���S
        case 9: // �v���T
        case 10: // ���ƑΏێ�
            return new ArrayList<HashMap<String, String>>();
        }

        // 1620101 �K��҂̐l���@1-�Ō�E��1�l�y�щ��E��1�l 2-���E��2�l
        int _1620101 = getIntValue(map, "1620101", 1);

        // 1620102 �������敪�@1-�Ȃ� 2-�������E���@�̂�
        int _1620102 = getIntValue(map, "1620102", 1);

        // 2 ���ʒn����Z
        int _2 = getIntValue(map, "2");

        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // ���R�Ԓn�擙���K�͎��Ə����Z
        int chusankantiikiJigyosyo = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 1620103 �T�[�r�X�񋟑̐��������Z
        int _1620103 = getIntValue(map, "1620103");

        // 16 �K��̕K�v��
        int _16 = getIntValue(map, "16", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �K��҂̐l���@1-�Ō�E��1�l�y�щ��E��1�l 2-���E��2�l
        sb.append(CODE_CHAR[_1620101]);

        // �������敪�@1-�Ȃ� 2-�������E���@�̂�
        sb.append(CODE_CHAR[_1620102]);

        // �K��̕K�v��
        sb.append(CODE_CHAR[_16]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // ���ʒn����Z
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
        }

        // 8100 �\�h�K��������K�͎��Ə����Z
        if (chusankantiikiJigyosyo > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
        }

        // 8110 �\�h�K��������R�Ԓn�擙�񋟉��Z
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }

        // 6101 �\�h�K������T�[�r�X�񋟑̐����Z
        switch (_1620103) {
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//TODO:�R�[�h�l�m�F
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//TODO:�R�[�h�l�m�F
            break;
        }

        // ���E���������P��ԋp
        switch (_17) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");//TODO:�R�[�h�l�m�F
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
