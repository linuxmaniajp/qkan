
package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �F�m�ǑΉ��^�����������(�Z�����p�ȊO)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13211_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "�F�m�ǑΉ��^�����������(�Z�����p�ȊO)";
    }

    public String getServiceCodeKind() {
        return "32";
    }

    public String getSystemServiceKindDetail() {
        return "13211 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1320106 ��ԋΖ������ 1-�������Ă��� 2-�������Ă��Ȃ�
        int _1320106 = getIntValue(map, "1320106");

        // 1320105 �l�����Z 1-�Ȃ� 2-������� 3-���]�ƈ��̕s��
        int _1320105 = getIntValue(map, "1320105");

        // 1320104 �������Z 1-�Ȃ� 2-����
        int _1320104 = getIntValue(map, "1320104");

        // 1320107 ��ØA�g�̐����Z
        int _1320107 = getIntValue(map, "1320107");

        // 1320108 ��Ԏx���̐����Z
        int _1320108 = getIntValue(map, "1320108");

        // 1320109 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1320109 = getIntValue(map, "1320109");

        // 1320110 �F�m�ǐ��P�A���Z
        int _1320110 = getIntValue(map, "1320110");

        // 1320112 �Ŏ������Z
        int _1320112 = getIntValue(map, "1320112");

        // 1320113 �ދ������k�������Z
        int _1320113 = getIntValue(map, "1320113");

        // 1320111 �T�[�r�X�񋟑̐��������Z
        int _1320111 = getIntValue(map, "1320111");

        // 1320114 �{�ݓ��̋敪
        int _1320114 = getIntValue(map, "1320114", 1);
        
        // 1320116 �g�̍S���p�~�����{���Z
        int _1320116 = getIntValue(map, "1320116", 1);
        
        // 1320117 ���@����p
        int _1320117 = getIntValue(map, "1320117", 1);

        // 1320118 �����@�\����A�g���Z
        int _1320118 = getIntValue(map, "1320118", 1);
        
        // 1320119 ���o�q���Ǘ��̐����Z
        int _1320119 = getIntValue(map, "1320119", 1);
        
        // 1320120 �h�{�X�N���[�j���O���Z
        int _1320120 = getIntValue(map, "1320120", 1);
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
        
        // ���Z�̂�(�މ@�������w�����Z�Ή�)
        int _9 = getIntValue(map, "9");

        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if (_9 == 2) {
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            
            // �������Z 1-�Ȃ� 2-����
            if (_1320104 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z1550");
            }
            
            // 6142 �F�m�ǑΉ��^�Ŏ������Z
            switch(_1320112) {
            case 2:
                // �F�m�ǑΉ��^�Ŏ������Z�P(���S���ȑO4���ȏ�30���ȉ�)
                putSystemServiceCodeItem(sysSvcCdItems, "Z6142");
                break;
            case 3:
                // �F�m�ǑΉ��^�Ŏ������Z�Q(���S���ȑO2������3��)
                putSystemServiceCodeItem(sysSvcCdItems, "Z6143");
                break;
            case 4:
                // �F�m�ǑΉ��^�Ŏ������Z�R(���S��)
                putSystemServiceCodeItem(sysSvcCdItems, "Z6144");
                break;
            }
            

            // ���E���������P��ԋp
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }

            return sysSvcCdItems;
        }

        

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪
        sb.append(CODE_CHAR[_1320114]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // ��ԋΖ������ 1-�������Ă��� 2-�������Ă��Ȃ�
        sb.append(CODE_CHAR[_1320106]);

        // �l�����Z 1-�Ȃ� 2-������� 3-���]�ƈ��̕s��
        sb.append(CODE_CHAR[_1320105]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        // 6161 �F�m�ǑΉ��^��Ԏx���̐����Z
        if (_1320108 > 1) {
            //�{�݋敪�ɂ�蕪��
            switch (_1320114) {
            case 1: // I�^
                putSystemServiceCodeItem(sysSvcCdItems, "Z6161");//2015.04
                break;
            case 2: // II�^
                putSystemServiceCodeItem(sysSvcCdItems, "Z6171");//2015.04
                break;
            }
        }
        
        // 6109 �F�m�ǑΉ��^��N���F�m�ǎ�����Z
        if (_1320109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 6142 �F�m�ǑΉ��^�Ŏ������Z
        switch(_1320112) {
        case 2:
            // �F�m�ǑΉ��^�Ŏ������Z�P(���S���ȑO4���ȏ�30���ȉ�)
            putSystemServiceCodeItem(sysSvcCdItems, "Z6142");
            break;
        case 3:
            // �F�m�ǑΉ��^�Ŏ������Z�Q(���S���ȑO2������3��)
            putSystemServiceCodeItem(sysSvcCdItems, "Z6143");
            break;
        case 4:
            // �F�m�ǑΉ��^�Ŏ������Z�R(���S��)
            putSystemServiceCodeItem(sysSvcCdItems, "Z6144");
            break;
        }
        
        // �������Z 1-�Ȃ� 2-����
        if (_1320104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z1550");
        }

        // ��ØA�g�̐����Z
        switch (_1320107) {
        case 2:
            // ��ØA�g�̐����ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z1600");
            break;
        case 3:
            // ��ØA�g�̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z1601");//2018.04
            break;
        case 4:
            // ��ØA�g�̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z1602");//2018.04
            break;
        }

        // 6502 �F�m�ǑΉ��^�ދ������k�������Z
        if (_1320113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
        }
        
        switch (_1320110) {
        case 2:
            // 6133 �F�m�ǑΉ��^�F�m�ǐ��P�A���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // 6134 �F�m�ǑΉ��^�F�m�ǐ��P�A���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }
        
        // 1320116 �g�̍S���p�~�����{���Z //2018.04
        if (_1320116 > 1) {
            StringBuilder sb1 = new StringBuilder();
            // �v���t�B�b�N�X
            sb1.append(SYSTEM_SERVICE_CODE_PREFIX_SK);
            // �{�ݓ��̋敪
            sb1.append(CODE_CHAR[_1320114]);
            // �v���x
            sb1.append(CODE_CHAR[_1]);
            putSystemServiceCodeItem(sysSvcCdItems, sb1.toString());
        }
        

        // 1320118 �����@�\����A�g���Z
        if (_1320118 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");//2018.04
        }
        
        // 1320119 ���o�q���Ǘ��̐����Z
        if (_1320119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6122");//2018.04
        }
        
        // 1320120 �h�{�X�N���[�j���O���Z
        if (_1320120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6201");//2018.04
        }
        
        
        switch (_1320111) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 �F�m�ǑΉ��T�[�r�X�񋟑̐����ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 �F�m�ǑΉ��T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 �F�m�ǑΉ��T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        }
        
        // 2018/03/01 [H30.4�����Ή�][Yoichiro Kamei] add - begin
        // ���@����p�����肾�����ꍇ�͈ꗥ���@����p�̃R�[�h��Ԃ�
        if (_1320117 > 1) {        
            // �����T�[�r�X�R�[�h��������
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // ���@����p�ɂ�����T�[�r�X�R�[�h��ǉ�
            putSystemServiceCodeItem(sysSvcCdItems, "Z6400");

            // ���E���������P��ԋp
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }
        }
        // 2018/03/01 [H30.4�����Ή�][Yoichiro Kamei] add - end

        return sysSvcCdItems;
    }

}
