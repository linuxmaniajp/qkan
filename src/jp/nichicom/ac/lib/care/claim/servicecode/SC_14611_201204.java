package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���\�h�x��
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_14611_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "���\�h�x��";
    }

    public String getServiceCodeKind() {
        return "46";
    }

    public String getSystemServiceKindDetail() {
        return "14611";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1460101 ������Z�@1-�Ȃ� 2-����
        int _1460101 = getIntValue(map, "1460101", 1);

        // 1460104 ���\�h���K�͑��@�\�^<���s>�����쎖�Ə��A�g���Z
        int _1460104 = getIntValue(map, "1460104", 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // ��{�T�[�r�X�R�[�h
        sb.append(DEFAULT_CHAR);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // ������Z
        if (_1460101 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
        }

        // 6131 ���\�h�x�����K�͑��@�\�A�g���Z
        if (_1460104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6131");
        }

        return sysSvcCdItems;
    }
}
