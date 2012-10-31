package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �K�⃊�n�r���e�[�V����
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_11411_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�K�⃊�n�r���e�[�V����";
    }

    public String getServiceCodeKind() {
        return "14";
    }

    public String getSystemServiceKindDetail() {
        return "11411";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        
        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        // ���炩�ɗv���x�����������ꍇ�͋��Ԃ�
        switch(_1){
        case 1: // ����
        case 3: // �v�x���P
        case 4: // �v�x���Q
            return new ArrayList<HashMap<String, String>>();
        }
        
        // 1140103 �{�݋敪
        int _1140103 = getIntValue(map, "1140103");

        // 1140106 �Z���W�����n�r���e�[�V�������{���Z
        int _1140106 = getIntValue(map, "1140106");

        // 12 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);        
        
        // 1140107 �T�[�r�X�񋟑̐��������Z
        int _1140107 = getIntValue(map, "1140107" ,1);

        // 1140108 �K����A�g���Z
        int _1140108 = getIntValue(map, "1140108", 1);

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);

        // ���Z�̂�(�މ@�������w�����Z�Ή�)
        int _9 = getIntValue(map,"9");
        
        
        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // �K����A�g���Z
            if (_1140108 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
            }
            
            return sysSvcCdItems;
        }
        
        
        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1140103]);
        // ���ꌚ�����Z�҂ւ̃T�[�r�X��
        sb.append(CODE_CHAR[_16]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        
        // 8110 �K�⃊�n���R�Ԓn�擙�񋟉��Z
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // �Z���W�����n�r���e�[�V�������{���Z
        switch(_1140106) {
        // �Z���W�����Z�P
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z5001");
            break;
        // �Z���W�����Z�Q
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
            break;
        }
        
        // �K����A�g���Z
        if (_1140108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
        }
        
        // 6101 �K�⃊�n�T�[�r�X�񋟑̐����Z
        if (_1140107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
        }
        
        
        return sysSvcCdItems;
    }

}
