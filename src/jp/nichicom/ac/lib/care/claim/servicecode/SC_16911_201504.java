package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ���\�h���K�͑��@�\�^������
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_16911_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "���\�h���K�͑��@�\�^������(�Z�����p)";
    }

    public String getServiceCodeKind() {
        return "69";
    }

    public String getSystemServiceKindDetail() {
        return "16911";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1690101 �l�����Z 1-�Ȃ� 2-������� 3-���]�ƈ��s��
        int _1690101 = getIntValue(map, "1690101");

        // 1690102 �T�[�r�X�񋟑̐��������Z
        int _1690102 = getIntValue(map, "1690102");


        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);



        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();


        // �v���x
        sb.append(CODE_CHAR[_1]);
        // �l�����Z 1-�Ȃ� 2-������� 3-���]�ƈ��s��
        sb.append(CODE_CHAR[_1690101]);

        

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        
        
        switch (_1690102) {
        case 5:
            // Z6100 �����@�\�^�T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 �����@�\�^�T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//2015.04
            break;
        case 3:
            // 6102 �����@�\�^�T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");//2015.04
            break;
        case 4:
            // 6103 �����@�\�^�T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");//2015.04
            break;
        }

        // ���E���������P��ԋp
        switch (_17) {
        case 6:
            // ���K�͑��@�\�^�������P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2017.04
            break;
        case 5:
            // ���K�͑��@�\�^�������P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
            break;
        case 2:
            // ���K�͑��@�\�^�������P���ZIIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");//2015.04
            break;
        case 3:
            // ���K�͑��@�\�^�������P���ZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");//2015.04
            break;
        case 4:
            // ���K�͑��@�\�^�������P���ZV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
            break;
        }

        return sysSvcCdItems;
    }
}
