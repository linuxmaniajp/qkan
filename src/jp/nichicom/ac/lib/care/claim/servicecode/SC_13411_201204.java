
package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���\�h����×{�Ǘ��w��
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13411_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "���\�h����×{�Ǘ��w��";
    }

    public String getServiceCodeKind() {
        return "34";
    }

    public String getSystemServiceKindDetail() {
        return "13411";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
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

        // 1340108 �S���ҋ敪�@1-��t 2-���Ȉ�t 3-��܎t(��Ë@��) 4-��܎t(���) 5-�Ǘ��h�{�m 6-���ȉq���m��
        // 7-�Ō�t
        int _1340108 = getIntValue(map, "1340108", 1);

        // 1340102 �ݑ��w�����Ǘ����@1-�Ȃ� 2-����
        int _1340102 = getIntValue(map, "1340102", 1);

        // 1340103 ���ʖ�܁@1-�Ȃ� 2-����
        int _1340103 = getIntValue(map, "1340103", 1);

        // 1340107 ���񖖊��@1-���񖖊��łȂ� 2-���񖖊��łȂ�
        int _1340107 = getIntValue(map, "1340107", 1);

        // 1340109 �Ō�E���敪 1-���œ� 2-�y��
        int _1340109 = getIntValue(map, "1340109", 1);

        // 16 ���ݒn�敪
        int _16 = getIntValue(map, "16", 1);


        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �S���ҋ敪�@1-��t 2-���Ȉ�t 3-��܎t(��Ë@��) 4-��܎t(���) 5-�Ǘ��h�{�m 6-���ȉq���m�� 7-�Ō�t
        sb.append(CODE_CHAR[_1340108]);

        // �ݑ��w�����Ǘ����@1-�Ȃ� 2-����
        sb.append(CODE_CHAR[_1340102]);

        // ���ݒn�敪
        sb.append(CODE_CHAR[_16]);

        // ���񖖊��@1-���񖖊��łȂ� 2-���񖖊��łȂ�
        sb.append(CODE_CHAR[_1340107]);

        // ���ʖ�܁@1-�Ȃ� 2-����
        sb.append(CODE_CHAR[_1340103]);

        // �Ō�E���敪
        sb.append(CODE_CHAR[_1340109]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        return sysSvcCdItems;
    }
}
