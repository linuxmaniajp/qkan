package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �K�⃊�n�r���e�[�V����
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_11411_201804 extends Qkan10011_ServiceUnitGetter {
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
        case 10: // ���ƑΏێ�
            return new ArrayList<HashMap<String, String>>();
        }
        
        // 1140103 �{�݋敪
        int _1140103 = getIntValue(map, "1140103");

        // 1140106 �Z���W�����n�r���e�[�V�������{���Z
        int _1140106 = getIntValue(map, "1140106");

        // 12 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);   
        
        // ���R�Ԓn�擙���K�͎��Ə����Z
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 2 ���ʒn����Z
        int _2 = getIntValue(map, "2");
        
        // 1140113 �v��f�Ö����{���Z
        int _1140113 = getIntValue(map, "1140113");
        
        // 1140107 �T�[�r�X�񋟑̐��������Z
        int _1140107 = getIntValue(map, "1140107" ,1);

        // 23 ���ꌚ�����Z
        int _23 = getIntValue(map, "23", 1);

        // ���n�r���e�[�V�����E�}�l�W�����g���Z
        int _1140110 = getIntValue(map, "1140110");
        
        // �Љ�Q���x�����Z
        int _1140112 = getIntValue(map, "1140112", 1);
        
        // ���Z�̂�
        int _9 = getIntValue(map,"9");
        
        
        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // ���n�r���e�[�V�����E�}�l�W�����g���Z
            switch (_1140110) {
            // II�^
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z5005");//2015.04
                break;
            // III�^
    		case 4:
    			putSystemServiceCodeItem(sysSvcCdItems, "Z5006");// 2018.04
    			break;
    		// IV�^
    		case 5:
    			putSystemServiceCodeItem(sysSvcCdItems, "Z5007");// 2018.04
    			break;
            }
            return sysSvcCdItems;
        }
        
        
        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1140103]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        
        // ���ʒn����Z
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");//2018.04
        }
        
        // �K���쏬�K�͎��Ə����Z
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");//2018.04
        }
        
        // 8110 �K�⃊�n���R�Ԓn�擙�񋟉��Z
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // �Z���W�����n�r���e�[�V�������{���Z
        if (_1140106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5003");//2015.04
        }
        
        
        // 6101 �K�⃊�n�T�[�r�X�񋟑̐����Z
        if (_1140107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
        }
        
        // ���n�r���e�[�V�����E�}�l�W�����g���Z
        switch (_1140110) {
        // I�^
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z5004");//2015.04
            break;
        // II�^
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z5005");//2015.04
            break;
		// III�^
		case 4:
			putSystemServiceCodeItem(sysSvcCdItems, "Z5006");// 2018.04
			break;
		// IV�^
		case 5:
			putSystemServiceCodeItem(sysSvcCdItems, "Z5007");// 2018.04
			break;
		}
        
        // �Љ�Q���x�����Z
        if (_1140112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
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
        
        // �v��f�Ö����{���Z
        if (_1140113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5010");// 2018.04
        }
        
        return sysSvcCdItems;
    }

}
