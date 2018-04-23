package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���\�h�K�⃊�n�r���e�[�V����
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_16411_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "���\�h�K�⃊�n�r���e�[�V����";
    }

    public String getServiceCodeKind() {
        return "64";
    }

    public String getSystemServiceKindDetail() {
        return "16411";
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
        case 2: // �o�ߓI�v���
        case 5: // �v���P
        case 6: // �v���Q
        case 7: // �v���R
        case 8: // �v���S
        case 9: // �v���T
        case 10: // ���ƑΏێ�
            return new ArrayList<HashMap<String, String>>();
        }

        // 1640101 �{�ݓ��̋敪�@1-�a�@���͐f�Ï� 2-���V�l�ی��{�� 3-����É@
        int _1640101 = getIntValue(map, "1640101", 1);

        // 1640103 �Z���W���ʃ��n�r���e�[�V�������{���Z�@1-�Ȃ� 2-����
        int _1640103 = getIntValue(map, "1640103", 1);

        // 12 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // 13 ���R�Ԓn�擙���K�͎��Ə����Z
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 2 ���ʒn����Z
        int _2 = getIntValue(map, "2");
        
        // 1640107 �v��f�Ö����{���Z
        int _1640107 = getIntValue(map, "1640107");
        
        // 23 ���ꌚ�����Z
        int _23 = getIntValue(map, "23", 1);

        // ���n�r���e�[�V�����E�}�l�W�����g���Z
        int _1640102 = getIntValue(map, "1640102");
        
        // 1640104 �T�[�r�X�񋟑̐��������Z
        int _1640104 = getIntValue(map, "1640104", 1);

        // 1640108 ���Ə��]�����Z
        int _1640108 = getIntValue(map, "1640108", 1);
        
        
        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪�@1-�a�@���͐f�Ï� 2-���V�l�ی��{�� 3-����É@
        sb.append(CODE_CHAR[_1640101]);
        
        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        // 2 ���ʒn����Z
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");//2018.04
        }
        
        // 13 �K���쏬�K�͎��Ə����Z
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");//2018.04
        }
        
        // 8110 �\�h�K�⃊�n���R�Ԓn�擙�񋟉��Z
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // 5001 �Z���W���ʃ��n�r���e�[�V�������{���Z
        if (_1640103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5001");
        }

        // 5005 ���Ə��]�����Z
        if (_1640108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5005");//2018.04
        }

        // 6101 �\�h�K�⃊�n�T�[�r�X�񋟑̐����Z
        if (_1640104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
        }
        
        // ���ꌚ�����Z //2018.04
        switch (_23) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4111");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4112");
            break;
        }
        
        // 5010 �v��f�Ö����{���Z
        if (_1640107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5010");//2018.04
        }
        
        // 5615 ���n�r���e�[�V�����E�}�l�W�����g���Z
        if (_1640102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5615");//2018.04
        }
        

        return sysSvcCdItems;
    }

}
