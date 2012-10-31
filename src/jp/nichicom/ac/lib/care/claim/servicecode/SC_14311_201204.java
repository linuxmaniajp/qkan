package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ������x��
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_14311_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "������x��";
    }

    public String getServiceCodeKind() {
        return "43";
    }

    public String getSystemServiceKindDetail() {
        return "14311 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1430103 �敪
        int _1430103 = getIntValue(map, "1430103");

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1430101 �^�c����Z
        int _1430101 = getIntValue(map, "1430101", 1);

        // 2 ���ʒn����Z
        int _2 = getIntValue(map, "2", 1);

        // 13 ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə�
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 1430104 ���莖�Ə��W�����Z
        int _1430104 = getIntValue(map, "1430104", 1);

        // 1430108 ������Z
        int _1430108 = getIntValue(map, "1430108", 1);

        // 1430113 �މ@�E�ޏ������Z
        int _1430113 = getIntValue(map, "1430113", 1);

        // 1430106 ���莖�Ə����Z
        int _1430106 = getIntValue(map, "1430106", 1);

        // 1430110 �F�m�ǉ��Z
        int _1430110 = getIntValue(map, "1430110", 1);

        // 1430111 �Ƌ�����҉��Z
        int _1430111 = getIntValue(map, "1430111", 1);

        // 1430112 ���K�͑��@�\�^�����쎖�Ə��A�g���Z
        int _1430112 = getIntValue(map, "1430112", 1);

        // 12 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // 1430114 �ݑ�ҋً}���J���t�@�����X���Z
        int _1430114 = getIntValue(map, "1430114", 1);
        
        // 1430115 ���@�����A�g���Z
        int _1430115 = getIntValue(map, "1430115", 1);
        
        // 1430116 �����^�T�[�r�X���Ə��A�g���Z
        int _1430116 = getIntValue(map, "1430116", 1);
        
        // [ID:0000702][Masahiko.Higuchi] 2012/03 ����24�N4���@�����Ή� add begin
        // �P�Ɖ��Z
        int _9 = getIntValue(map, "9");

        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if (_9 == 2) {
            // ����x���މ@�ޏ����Z
            if (_1430113 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6132");
            }
            
            // �ݑ�ҋً}���J���t�@�����X���Z
            if (_1430114 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            }
            
            return sysSvcCdItems;
        }
        // [ID:0000702][Masahiko.Higuchi] 2012/03 add end
        
        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �敪
        sb.append(CODE_CHAR[_1430103]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �^�c����Z
        sb.append(CODE_CHAR[_1430101]);

        // 1-�Ȃ� 2-���ʒn����Z 3-���R�Ԓn�擙�̏��K�͎��Ə�
        // ���ʒn����Z�`�F�b�N
        if (_2 > 1) {
            // ���ʒn����Z
            sb.append(CODE_CHAR[2]);
            
        } else if (_13 > 1) {
            // ���R�Ԓn�擙�̏��K�͎��Ə�
            sb.append(CODE_CHAR[3]);
            
        } else {
            sb.append(DEFAULT_CHAR);
            
        }

        // 12 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        sb.append(CODE_CHAR[_12]);

        // ���莖�Ə��W�����Z
        sb.append(CODE_CHAR[_1430104]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        switch (_1430108) {
        case 2:
            // ����x��������Z
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
            break;
        }
        
        switch (_1430106) {
        case 2:
            // ����x�����莖�Ə����ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
            break;
        case 3:
            // ����x�����莖�Ə����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
            break;
        }
        
        // ���@�����A�g���Z
        switch(_1430115) {
        case 2: // I�^
            putSystemServiceCodeItem(sysSvcCdItems, "Z6125");
            break;
        case 3: // II�^
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;
        }
        
        // ����x���މ@�ޏ����Z
        if (_1430113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6132");
        }
        
        // ����x���F�m�ǉ��Z
        if (_1430110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
        }
        
        // ����x���Ƌ�����҉��Z
        if (_1430111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
        }
        
        // ����x�����K�͑��@�\�^�A�g���Z
        if (_1430112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6131");
        }
        
        // �����^�T�[�r�X���Ə��A�g���Z
        if (_1430116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
        }
        
        // �ݑ�ҋً}���J���t�@�����X���Z
        if (_1430114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
        }

        return sysSvcCdItems;
    }
}
