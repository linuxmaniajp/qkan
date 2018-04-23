package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���̑��̐����x���T�[�r�X�i�����^��z�j
 * 
 * @since V7.3.0
 * @author Shinobu.Hitaka
 * 
 */
public class SC_51211_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "���̑��̐����x���T�[�r�X�i�����^��z�j";
    }

    public String getServiceCodeKind() {
        return "AC";
    }

    public String getSystemServiceKindDetail() {
        return "51211";
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
