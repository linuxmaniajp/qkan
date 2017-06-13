package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ��ԑΉ��^�K����
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_17111_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "��ԑΉ��^�K����";
    }

    public String getServiceCodeKind() {
        return "71";
    }

    public String getSystemServiceKindDetail() {
        return "17111";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1710101 �{�݋敪
        int _1710101 = getIntValue(map, "1710101", 1);

        // 1710102 �T�[�r�X�敪
        int _1710102 = getIntValue(map, "1710102", 1);

        // 1710104 �Ή��l��
        int _1710104 = getIntValue(map, "1710104", 1);

        // 1710106 ����
        int _1710106 = getIntValue(map, "1710106", 1);

        // 1710107 24���Ԓʕ�Ή����Z
        int _1710107 = getIntValue(map, "1710107", 1);

        // 1710108 �T�[�r�X�񋟑̐��������Z
        int _1710108 = getIntValue(map, "1710108", 1);

        // 1710109 ��{��ԖK�� I �s�����Ǝ����Z
        int _1710109 = getIntValue(map, "1710109", 1);

        // 1710110 ��ԖK���� II �s�����Ǝ����Z
        int _1710110 = getIntValue(map, "1710110", 1);

        // �Z��敪�@1-�ʏ� 2-���Z�̂� 3-��{�̂�
        int _9 = getIntValue(map, "9", 1);

        // 1710111 �K��̕K�v��
        int _1710111 = getIntValue(map, "1710111", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // ���ʌn�̉��Z����
        // =========================================================================
        // 6136 ��ԖK����Q�S���Ԓʕ�Ή����Z
        if (_1710107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6136");
        }
        
        switch (_1710108) {
        case 4:
            // 6101 ��ԖK��T�[�r�X�񋟑̐����Z�T�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 ��ԖK��T�[�r�X�񋟑̐����Z�T��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 5:
            // 6101 ��ԖK��T�[�r�X�񋟑̐����Z�U�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
            break;
        case 3:
            // 6102 ��ԖK��T�[�r�X�񋟑̐����Z�U��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        }
        
        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            // ��ԖK���쏈�����P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");//2017.04
            break;
        case 5:
            // ��ԖK���쏈�����P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");//2015.04
            break;
        case 2:
            // ��ԖK���쏈�����P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        case 3:
            // ��ԖK���쏈�����P���ZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 4:
            // ��ԖK���쏈�����P���ZV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            break;
        }
        
        
        // ������I����
        if (_1710106 == 2) {
            
            // ��{��ԖK��T�s�����Ǝ����Z
            switch (_1710109) {
            case 1:
                break;
            case 2:
                // ��{��ԖK��T�s�����Ǝ����Z�P����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7202");
                break;
            case 3:
                // ��{��ԖK��T�s�����Ǝ����Z�Q����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7204");
                break;
            case 4:
                // ��{��ԖK��T�s�����Ǝ����Z�R����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7206");
                break;
            case 5:
                // ��{��ԖK��T�s�����Ǝ����Z�S����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7208");
                break;
            case 6:
                // ��{��ԖK��T�s�����Ǝ����Z�T����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7210");
                break;
            case 7:
                // ��{��ԖK��T�s�����Ǝ����Z�U����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7212");
                break;
            }
            
            
            // ��ԖK��U�s�����Ǝ����Z
            switch (_1710110) {
            case 1:
                break;
            case 2:
                // ��ԖK��U�s�����Ǝ����Z�P����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7302");
                break;
            case 3:
                // ��ԖK��U�s�����Ǝ����Z�Q����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7304");
                break;
            case 4:
                // ��ԖK��U�s�����Ǝ����Z�R����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7306");
                break;
            case 5:
                // ��ԖK��U�s�����Ǝ����Z�S����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7308");
                break;
            case 6:
                // ��ԖK��U�s�����Ǝ����Z�T����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7310");
                break;
            case 7:
                // ��ԖK��U�s�����Ǝ����Z�U����
                putSystemServiceCodeItem(sysSvcCdItems, "Z7312");
                break;
            }

            
        // ������ȊO�̒ʏ�
        } else {
            
            // ��{��ԖK��T�s�����Ǝ����Z
            switch (_1710109) {
            case 1:
                break;
            case 2:
                // ��{��ԖK��T�s�����Ǝ����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z7201");
                break;
            case 3:
                // ��{��ԖK��T�s�����Ǝ����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z7203");
                break;
            case 4:
                // ��{��ԖK��T�s�����Ǝ����Z�R
                putSystemServiceCodeItem(sysSvcCdItems, "Z7205");
                break;
            case 5:
                // ��{��ԖK��T�s�����Ǝ����Z�S
                putSystemServiceCodeItem(sysSvcCdItems, "Z7207");
                break;
            case 6:
                // ��{��ԖK��T�s�����Ǝ����Z�T
                putSystemServiceCodeItem(sysSvcCdItems, "Z7209");
                break;
            case 7:
                // ��{��ԖK��T�s�����Ǝ����Z�U
                putSystemServiceCodeItem(sysSvcCdItems, "Z7211");
                break;
            }
            
            
            //  ��ԖK����U�s�����Ǝ����Z
            switch (_1710110) {
            case 1:
                break;
            case 2:
                // ��ԖK����U�s�����Ǝ����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z7301");
                break;
            case 3:
                // ��ԖK����U�s�����Ǝ����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z7303");
                break;
            case 4:
                // ��ԖK����U�s�����Ǝ����Z�R
                putSystemServiceCodeItem(sysSvcCdItems, "Z7305");
                break;
            case 5:
                // ��ԖK����U�s�����Ǝ����Z�S
                putSystemServiceCodeItem(sysSvcCdItems, "Z7307");
                break;
            case 6:
                // ��ԖK����U�s�����Ǝ����Z�T
                putSystemServiceCodeItem(sysSvcCdItems, "Z7309");
                break;
            case 7:
                // ��ԖK����U�s�����Ǝ����Z�U
                putSystemServiceCodeItem(sysSvcCdItems, "Z7311");
                break;
            }
        }
        

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        if (_1710101 == 1) {
            // ��{��
            sb.append(CODE_CHAR[_1710101]); // �{�݋敪
            sb.append(DEFAULT_CHAR); // �T�[�r�X�敪
            sb.append(DEFAULT_CHAR); // �Ή��l��
            sb.append(DEFAULT_CHAR); // �K��̕K�v��
            sb.append(CODE_CHAR[_1710106]); // ����
            sb.append(CODE_CHAR[2]); // ��{�敪
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

            // ==================================
            // ���Z����
            // ==================================
            // �Z��敪���u3-��{�̂݁v�̏ꍇ�̓X�L�b�v����
            if (_9 != 3) {

                // �u�������v�u�����K��T�v�u�����K��U�v�̃R�[�h��
                // �񐔕������R�[�h��ǉ�����B
                sb = new StringBuilder();
                sb.append(CODE_CHAR[_1710101]); // �{�݋敪
                sb.append(CODE_CHAR[_1710102]); // �T�[�r�X�敪
                sb.append(CODE_CHAR[_1710104]); // �Ή��l��
                sb.append(CODE_CHAR[_1710111]); // �K��̕K�v��
                sb.append(DEFAULT_CHAR); // ����
                sb.append(DEFAULT_CHAR); // ��{�敪
                putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

            }
        } else {
            sb.append(CODE_CHAR[_1710101]); // �{�݋敪
            sb.append(CODE_CHAR[_1710102]); // �T�[�r�X�敪
            sb.append(CODE_CHAR[_1710104]); // �Ή��l��
            sb.append(CODE_CHAR[_1710111]); // �K��̕K�v��
            sb.append(CODE_CHAR[_1710106]); // ����
            sb.append(DEFAULT_CHAR); // ��{�敪
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
        }

        return sysSvcCdItems;
    }
}
