/**
 * 
 */
package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �K����
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_11111_201504 extends Qkan10011_ServiceUnitGetter {

    public String getServiceName() {
        return "�K����";
    }

    public String getServiceCodeKind() {
        return "11";
    }

    public String getSystemServiceKindDetail() {
        return "11111";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        // ���炩�ɗv���x�����������ꍇ�͋��Ԃ�
        switch (_1) {
        case 1: // ����
        case 3: // �v�x���P
        case 4: // �v�x���Q
        case 10: // ���ƑΏێ�
            return new ArrayList<HashMap<String, String>>();
        }

        // 1110101 �K���� 1-�g�̉�� 2-�������� 3-�g�̐��� 4-�ʉ@��~�
        int _1110101 = getIntValue(map, "1110101");

        // 1110104 �g�̎���
        int _1110104 = getIntValue(map, "1110104", 1);

        // 1110105 ��������
        int _1110105 = getIntValue(map, "1110105", 1);

        // 1110107 �K��l�� 1-1�l 2-2�l
        int _1110107 = getIntValue(map, "1110107");

        // 1110108 ���ԑ� 1-�ʏ� 2-���� 3-��� 4-�[��
        int _1110108 = getIntValue(map, "1110108");

        // 1110109 ���莖�Ə����Z 1-�Ȃ� 2-I�^ 3-II�^ 4-III�^ 5-IV�^
        int _1110109 = getIntValue(map, "1110109");

        // ������Z
        int _1110110 = getIntValue(map, "1110110", 1);

        // �ً}���K������Z
        int _1110111 = getIntValue(map, "1110111", 1);

        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _12 = getIntValue(map, "12", 1);

        // ���R�Ԓn�擙���K�͎��Ə����Z
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 2 ���ʒn����Z
        int _2 = getIntValue(map, "2");

        // 1110113 �T�[�r�X�񋟐ӔC�҂̋��E
        int _1110113 = getIntValue(map, "1110113", 1);

        // 1110112 �����@�\����A�g���Z
        int _1110112 = getIntValue(map, "1110112", 1);
        
        // 1110114	�p��̖K��Ƃ��čs��
        int _1110114 = getIntValue(map, "1110114", 1);

        // 16 ���ꌚ�����Z�҂ւ̃T�[�r�X��
        int _16 = getIntValue(map, "16", 1);
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // ���ԑт�l�ɉ����ă}�X�^�ɍ��킹�ϊ�
        if (_1110108 == 3) {
            _1110108 = 2;
        } else if (_1110108 == 4) {
            _1110108 = 3;
        }

        switch (_1110101) {
        case 3:// �g�̐����I����
               // ���莖�Ə����Z���`�F�b�N����B

            if (_1110105 > 3) {
                _1110105 = 3;
            }
            break;
        case 2:// ���������I����
               // �ꗥ�R���Ԉȏ�Ƃ݂Ȃ�
            if (_1110105 > 3) {
                _1110105 = 3;
            }
            break;
        case 1:// �g�̉��I����
            break;
        }

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �K���� 1-�g�̉�� 2-�������� 3-�g�̐��� 4-�ʉ@��~�
        sb.append(CODE_CHAR[_1110101]);

        // �g�̎���
        sb.append(CODE_CHAR[_1110104]);

        // ��������
        sb.append(CODE_CHAR[_1110105]);

        // �T�[�r�X�񋟐ӔC�҂̋��E
        sb.append(CODE_CHAR[_1110113]);

        // �K��̕K�v��
        sb.append(CODE_CHAR[_16]);

        // �K��l�� 1-1�l 2-2�l
        sb.append(CODE_CHAR[_1110107]);

        // ���ԑ� 1-�ʏ� 2-���� 3-��� 4-�[��
        sb.append(CODE_CHAR[_1110108]);

        // ���莖�Ə����Z 1-�Ȃ� 2-I�^ 3-II�^ 4-III�^ 5-IV�^
        sb.append(CODE_CHAR[_1110109]);
        
        // 	�p��̖K��Ƃ��čs��
        sb.append(CODE_CHAR[_1110114]); //2015.04
        

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        // ���ʒn����Z
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
        }
        
        // �K���쏬�K�͎��Ə����Z
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
        }
        
        // �K���쒆�R�Ԓn�擙�񋟉��Z
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // �ً}���K������Z
        if (_1110111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
        }
        
        // �K���쏉����Z
        if (_1110110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
        }
        
        // �����@�\����A�g���Z
        if (_1110112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
        }
        
        // ���E���������P��ԋp
        switch(_17){
        case 5:
            // �K���쏈�����P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6274");//2015.04
            break;
        case 2:
            // �K���쏈�����P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6271");
            break;
        case 3:
            // �K���쏈�����P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6272");
            break;
        case 4:
            // �K���쏈�����P���ZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
            break;
        }

        return sysSvcCdItems;
    }
}
