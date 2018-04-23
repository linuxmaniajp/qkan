package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ����×{�Ǘ��w��
 * 
 * @since V7.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13111_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "����×{�Ǘ��w��";
    }

    public String getServiceCodeKind() {
        return "31";
    }

    public String getSystemServiceKindDetail() {
        return "13111";
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
        case 10: // ���ƑΏێ�
            return new ArrayList<HashMap<String, String>>();
        }

        // 12 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);   
        
        // ���R�Ԓn�擙���K�͎��Ə����Z
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 2 ���ʒn����Z
        int _2 = getIntValue(map, "2");
        
        // 1310111 �E���敪
        int _1310111 = getIntValue(map, "1310111");

        // 1310104 �ݑ��f
        int _1310104 = getIntValue(map, "1310104");

        // 1310110 ���񖖊�
        int _1310110 = getIntValue(map, "1310110");

        // 1310105 ���ʖ��
        int _1310105 = getIntValue(map, "1310105");

        // 1310112 �Ō�E���敪
        int _1310112 = getIntValue(map, "1310112");

        // 16 ���ݒn�敪(���j
        int _16 = getIntValue(map, "16");
        
        // 1310113 ���ݒn�敪
        int _1310113 = getIntValue(map, "1310113");

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �E���敪
        sb.append(CODE_CHAR[_1310111]);

        // �ݑ��f
//        sb.append(CODE_CHAR[_1310104]);

        // ���ݒn�敪
//        sb.append(CODE_CHAR[_16]);
        if (_1310111 == 7) {
        	// �E���敪���u�Ō�E���v�̏ꍇ
        	if (_16 == 2) {
        		sb.append("5"); // ���ꌚ��
        	} else {
        		sb.append("4"); // ���ꌚ���ȊO
        	}
        } else {
        	sb.append(CODE_CHAR[_1310113]);
        }

        // ���񖖊�
        sb.append(CODE_CHAR[_1310110]);

        // ���ʖ��
        sb.append(CODE_CHAR[_1310105]);

        // �Ō�E���敪
        sb.append(CODE_CHAR[_1310112]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // ���ʒn����Z
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");//2018.04
        }
        
        // ���K�͎��Ə����Z
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");//2018.04
        }
        
        // ���R�Ԓn�擙�񋟉��Z
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");//2018.04
        }
        
        return sysSvcCdItems;
    }
}
