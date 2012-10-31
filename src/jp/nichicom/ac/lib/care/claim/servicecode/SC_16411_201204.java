package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���\�h�K�⃊�n�r���e�[�V����
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_16411_201204 extends Qkan10011_ServiceUnitGetter {
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
            return new ArrayList<HashMap<String, String>>();
        }

        // 1640101 �{�ݓ��̋敪�@1-�a�@���͐f�Ï� 2-���V�l�ی��{��
        int _1640101 = getIntValue(map, "1640101", 1);

        // 1640103 �Z���W�����n�r�����{���Z�@1-�Ȃ� 2-����
        int _1640103 = getIntValue(map, "1640103", 1);

        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // 1640104 �T�[�r�X�񋟑̐��������Z
        int _1640104 = getIntValue(map, "1640104");

        // 1640105 �K����A�g���Z
        int _1640105 = getIntValue(map, "1640105", 1);
        
        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);
        
        // ���Z�̂�(�މ@�������w�����Z�Ή�)
        int _9 = getIntValue(map,"9");
        
        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // �K����A�g���Z
            if (_1640105 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
            }
            
            return sysSvcCdItems;
        }
        
        
        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪�@1-�a�@���͐f�Ï� 2-���V�l�ی��{��
        sb.append(CODE_CHAR[_1640101]);
        
        // �K��̕K�v��
        sb.append(CODE_CHAR[_16]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        // 8110 �\�h�K�⃊�n���R�Ԓn�擙�񋟉��Z
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // �Z���W�����n�r�����{���Z�@1-�Ȃ� 2-����
        if (_1640103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5001");
        }

        // �K����A�g���Z
        if (_1640105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
        }

        // 6101 �\�h�K�⃊�n�T�[�r�X�񋟑̐����Z
        if (_1640104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
        }
        

        return sysSvcCdItems;
    }

}
