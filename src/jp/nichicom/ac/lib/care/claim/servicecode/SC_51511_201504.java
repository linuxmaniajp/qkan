package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���\�h�P�A�}�l�W�����g
 * 
 * @since V7.3
 * @author Yoichiro.Kamei
 * 
 */
public class SC_51511_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "���\�h�P�A�}�l�W�����g";
    }

    public String getServiceCodeKind() {
        return "AF";
    }

    public String getSystemServiceKindDetail() {
        return "51511";
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
