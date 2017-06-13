package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �K��^�T�[�r�X�i�Ǝ��^��z�j
 * 
 * @since V7.3.0
 * @author Shinobu.Hitaka
 * 
 */
public class SC_50411_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�K��^�T�[�r�X�i�Ǝ��^��z�j";
    }

    public String getServiceCodeKind() {
        return "A4";
    }

    public String getSystemServiceKindDetail() {
        return "50411";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();
        

        // �p�����[�^���o
        // =========================================================================

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
        
        putSogoSystemServiceCodeItems(sysSvcCdItems, map);
        
        return sysSvcCdItems;
    }
}
