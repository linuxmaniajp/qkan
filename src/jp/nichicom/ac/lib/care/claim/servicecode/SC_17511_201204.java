package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���\�h���K�͑��@�\�^������
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_17511_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "���\�h���K�͑��@�\�^������";
    }

    public String getServiceCodeKind() {
        return "75";
    }

    public String getSystemServiceKindDetail() {
        return "17511";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1750101 �������Z�@1-�Ȃ� 2-����
        int _1750101 = getIntValue(map, "1750101", 1);

        // 1750102 �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E���̕s��
        int _1750102 = getIntValue(map, "1750102", 1);

        // 1750103 �����@1-�����łȂ� 2-�����ł���
        int _1750103 = getIntValue(map, "1750103", 1);

        // 1750106 �ߏ��T�[�r�X�ɑ΂��錸�Z
        int _1750106 = getIntValue(map, "1750106", 1);

        // 1750107 ���ƊJ�n���x�����Z
        int _1750107 = getIntValue(map, "1750107", 1);

        // 1750108 �T�[�r�X�񋟑̐��������Z
        int _1750108 = getIntValue(map, "1750108", 1);

        // �P�Ɖ��Z
        int _9 = getIntValue(map, "9");

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if (_9 == 2) {
            // �������Z
            if (_1750101 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
            }
            
            // ���E���������P��ԋp
            switch (_17) {
            case 2:
                // �\���K�͑��@�\�������P���ZI
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                // �\���K�͑��@�\�������P���ZII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            case 4:
                // �\���K�͑��@�\�������P���ZIII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                break;
            }

            return sysSvcCdItems;
        }

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �l�����Z�@1-�Ȃ� 2-������� 3-�Ō�E���E���̕s��
        sb.append(CODE_CHAR[_1750102]);

        // ���ꌚ�����Z�҂ւ̃T�[�r�X��
        sb.append(CODE_CHAR[_16]);

        // �ߏ��T�[�r�X�ɑ΂��錸�Z
        sb.append(CODE_CHAR[_1750106]);

        // �����@1-�����łȂ� 2-�����ł���
        sb.append(CODE_CHAR[_1750103]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        // �������Z�@1-�Ȃ� 2-����
        if (_1750101 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }

        // �\�����@�\�^���ƊJ�n�x�����Z
        if (_1750107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6139");
        }
        
        switch (_1750108) {
        case 2:
            // 6101�@�\�����@�\�T�[�r�X�񋟑̐����ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102�@�\�����@�\�T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103�@�\�����@�\�T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // ���E���������P��ԋp
        switch (_17) {
        case 2:
            // �\���K�͑��@�\�������P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            // �\���K�͑��@�\�������P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        case 4:
            // �\���K�͑��@�\�������P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            break;
        }

        return sysSvcCdItems;
    }

}
