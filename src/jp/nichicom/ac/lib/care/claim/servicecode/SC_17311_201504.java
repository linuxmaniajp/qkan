package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���K�͑��@�\�^������
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_17311_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "���K�͑��@�\�^������(�Z�����p�ȊO)";
    }

    public String getServiceCodeKind() {
        return "73";
    }

    public String getSystemServiceKindDetail() {
        return "17311";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1730102 �l�����Z 1-�Ȃ� 2-������� 3-���]�ƈ��s��
        int _1730102 = getIntValue(map, "1730102");

        // 1730103 ����
        int _1730103 = getIntValue(map, "1730103");

        // 1730101 �������Z 1-�Ȃ� 2-����
        int _1730101 = getIntValue(map, "1730101");

        // 1730106 �ߏ��T�[�r�X�ɑ΂��錸�Z
        int _1730106 = getIntValue(map, "1730106");

        // 1730107 �F�m�ǉ��Z
        int _1730107 = getIntValue(map, "1730107");

        // 1730108 �Ō�E���z�u���Z
        int _1730108 = getIntValue(map, "1730108");

        // 1730110 �T�[�r�X�񋟑̐��������Z
        int _1730110 = getIntValue(map, "1730110");

        // 1730111 �s�����Ǝ����Z
        int _1730111 = getIntValue(map, "1730111");
        
        // 1730113 �Ŏ��A�g�̐����Z
        int _1730113 = getIntValue(map, "1730113");

        // 1730114 �K��̐��������Z
        int _1730114 = getIntValue(map, "1730114");
        
        // 1730115	�����}�l�W�����g�̐��������Z
        int _1730115 = getIntValue(map, "1730115");
        
        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);
        
        // �P�Ɖ��Z
        int _9 = getIntValue(map, "9");

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if (_9 == 2) {
            // �������Z
            if (_1730101 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
            }
            
            // �Ŏ��A�g�̐����Z
            if (_1730113 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4000");//2015.04
            }

            // ���E���������P��ԋp
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
                break;
            case 2:
                // ���K�͑��@�\�^�������P���ZI����
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                // ���K�͑��@�\�^�������P���ZII����
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            case 4:
                // ���K�͑��@�\�^�������P���ZIII����
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                break;
            }

            return sysSvcCdItems;
        }

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // ���ꌚ�����Z�҂ւ̃T�[�r�X��
        sb.append(CODE_CHAR[_16]); //2015.04
        // �v���x
        sb.append(CODE_CHAR[_1]);
        // �l�����Z 1-�Ȃ� 2-������� 3-���]�ƈ��s��
        sb.append(CODE_CHAR[_1730102]);
        // �ߏ��T�[�r�X�ɑ΂��錸�Z
        sb.append(CODE_CHAR[_1730106]);
        // ����
        sb.append(CODE_CHAR[_1730103]);
        

        

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        // �������Z 1-�Ȃ� 2-����
        if (_1730101 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }

        switch (_1730107) {
        case 2:
            // 6128 ���K�͑��@�\�^�F�m�ǉ��ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            break;
        case 3:
            // 6129 ���K�͑��@�\�^�F�m�ǉ��ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;
        }

        switch (_1730108) {
        case 2:
            // 6137 ���K�͑��@�\�^�Ō�E���z�u���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6137");
            break;
        case 3:
            // 6138 ���K�͑��@�\�^�Ō�E���z�u���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6138");
            break;
        case 4:
        	// 6141 ���K�͑��@�\�^�Ō�E���z�u���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6141");//2015.04
            break;
        }

        // 1730113 �Ŏ��A�g�̐����Z
        if (_1730113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");//2015.04
        }

        // 1730114 �K��̐��������Z
        if (_1730114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4005");//2015.04
        }

        // 1730115 �����}�l�W�����g�̐��������Z
        if (_1730115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4010");//2015.04
        }
        
        
        switch (_1730110) {
        case 5:
            //  �����@�\�^�T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 �����@�\�^�T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 �����@�\�^�T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 �����@�\�^�T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // ���E���������P��ԋp
        switch (_17) {
            // ���K�͑��@�\�^�������P���ZI
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
            break;
        case 2:
            // ���K�͑��@�\�^�������P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            // ���K�͑��@�\�^�������P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        case 4:
            // ���K�͑��@�\�^�������P���ZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            break;
        }

        // ������̏ꍇ
        if (_1730103 == 2) {

            switch (_1730111) {
            case 2:
                // �����@�\�s�����Ǝ����Z�P����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7102");
                break;
            case 3:
                // �����@�\�s�����Ǝ����Z�Q����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7104");
                break;
            case 4:
                // �����@�\�s�����Ǝ����Z�R����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7106");
                break;
            case 5:
                // �����@�\�s�����Ǝ����Z�S����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7108");
                break;
            case 6:
                // �����@�\�s�����Ǝ����Z�T����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7110");
                break;
            case 7:
                // �����@�\�s�����Ǝ����Z�U����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7112");
                break;
            case 8:
                // �����@�\�s�����Ǝ����Z�V����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7114");
                break;
            case 9:
                // �����@�\�s�����Ǝ����Z�W����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7116");
                break;
            case 10:
                // �����@�\�s�����Ǝ����Z�X����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7118");
                break;
            case 11:
                // �����@�\�s�����Ǝ����Z�P�O����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7120");
                break;

            case 12:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�P����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7122");
                break;
            case 13:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�Q����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7124");
                break;
            case 14:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�R����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7126");
                break;
            case 15:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�S����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7128");
                break;
            case 16:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�T����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7130");
                break;
            case 17:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�U����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7132");
                break;
            case 18:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�V����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7134");
                break;
            case 19:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�W����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7136");
                break;
            case 20:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�X����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7138");
                break;
            case 21:
                // ���K�͑��@�\�^�s�����Ǝ����Z�Q�O����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7140");
                break;

            }
            
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z����
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6311");//2015.04
            }
            
        } else {

            switch (_1730111) {
            case 2:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z7101");
                break;
            case 3:
                // ���K�͑��@�\�^�s�����Ǝ����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z7103");
                break;
            case 4:
                // ���K�͑��@�\�^�s�����Ǝ����Z�R
                putSystemServiceCodeItem(sysSvcCdItems, "Z7105");
                break;
            case 5:
                // ���K�͑��@�\�^�s�����Ǝ����Z�S
                putSystemServiceCodeItem(sysSvcCdItems, "Z7107");
                break;
            case 6:
                // ���K�͑��@�\�^�s�����Ǝ����Z�T
                putSystemServiceCodeItem(sysSvcCdItems, "Z7109");
                break;
            case 7:
                // ���K�͑��@�\�^�s�����Ǝ����Z�U
                putSystemServiceCodeItem(sysSvcCdItems, "Z7111");
                break;
            case 8:
                // ���K�͑��@�\�^�s�����Ǝ����Z�V
                putSystemServiceCodeItem(sysSvcCdItems, "Z7113");
                break;
            case 9:
                // ���K�͑��@�\�^�s�����Ǝ����Z�W
                putSystemServiceCodeItem(sysSvcCdItems, "Z7115");
                break;
            case 10:
                // ���K�͑��@�\�^�s�����Ǝ����Z�X
                putSystemServiceCodeItem(sysSvcCdItems, "Z7117");
                break;
            case 11:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�O
                putSystemServiceCodeItem(sysSvcCdItems, "Z7119");
                break;

            case 12:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z7121");
                break;
            case 13:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z7123");
                break;
            case 14:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�R
                putSystemServiceCodeItem(sysSvcCdItems, "Z7125");
                break;
            case 15:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�S
                putSystemServiceCodeItem(sysSvcCdItems, "Z7127");
                break;
            case 16:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�T
                putSystemServiceCodeItem(sysSvcCdItems, "Z7129");
                break;
            case 17:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�U
                putSystemServiceCodeItem(sysSvcCdItems, "Z7131");
                break;
            case 18:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�V
                putSystemServiceCodeItem(sysSvcCdItems, "Z7133");
                break;
            case 19:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�W
                putSystemServiceCodeItem(sysSvcCdItems, "Z7135");
                break;
            case 20:
                // ���K�͑��@�\�^�s�����Ǝ����Z�P�X
                putSystemServiceCodeItem(sysSvcCdItems, "Z7137");
                break;
            case 21:
                // ���K�͑��@�\�^�s�����Ǝ����Z�Q�O
                putSystemServiceCodeItem(sysSvcCdItems, "Z7139");
                break;
            }
            
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6310");//2015.04
            }

        }

        return sysSvcCdItems;
    }
}
