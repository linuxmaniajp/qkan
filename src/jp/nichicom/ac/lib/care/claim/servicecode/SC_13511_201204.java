package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.util.VRMap;

/**
 * ���\�h����{�ݓ����Ґ������
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13511_201204 extends Qkan10011_ServiceUnitGetter {
    private int _1350101 = 0;// �{�ݓ��̋敪
    private int _1 = 0;// �v���x
    private int baseUnit = 0;// �����p��P�ʗp�ϐ�
    private int _1350104 = 0;// �T�[�r�X��ފm��p

    public String getServiceName() {
        return "���\�h����{�ݓ����Ґ������";
    }

    public String getServiceCodeKind() {
        return "35";
    }

    public String getSystemServiceKindDetail() {
        return "13511";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        // 1350101 �{�ݓ��̋敪�@1-����{�ݓ����� 2-�O���T�[�r�X���p�^
        _1350101 = getIntValue(map, "1350101", 1);

        // 1350102 �ʋ@�\�P���w�����Z�@1-�Ȃ� 2-����
        int _1350102 = getIntValue(map, "1350102", 1);

        // 1350103 �l�����Z�@1-�Ȃ� 2-�Ō�E���E���̕s��
        int _1350103 = getIntValue(map, "1350103", 1);

        // 1350104 �O���T�[�r�X�@1-�K���� 2-�K�������� 3-�K��Ō� 4-�K�⃊�n 5-�ʏ���� 6-�ʏ����n 7-�����p��ݗ^
        // 8-�F�m�ǑΉ��^�ʏ����
        _1350104 = getIntValue(map, "1350104", 1);

        // 1 �v���x
        _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1350127 ��Ë@�֘A�g���Z
        int _1350127 = getIntValue(map, "1350127", 1);

        // 1350128 ��Q�ғ��x�����Z
        int _1350128 = getIntValue(map, "1350128", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
        // ===========================================================================
        // ��b�P�ʂ݂̂�Ԃ�
        // �Ȃ���I�������ꍇ
        if (_1350104 == 9) {
            // �l�����Z�̒l���`�F�b�N
            if (_1350103 == 2) {
                // �l�����Z���肾�����ꍇ
                putSystemServiceCodeItem(sysSvcCdItems, "212");
            } else {
                // �l�����Z�Ȃ��������ꍇ
                putSystemServiceCodeItem(sysSvcCdItems, "211");
            }

            // 6124 �\�h����{�ݏ�Q�ғ��x�����Z
            if (_1350128 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6124");
            }
            
            // ���E���������P��ԋp
            switch (_17) {
            case 2:
                // �\�h����{�ݏ������P���ZI
                putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
                break;
            case 3:
                // �\�h����{�ݏ������P���ZII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
                break;
            case 4:
                // �\�h����{�ݏ������P���ZIII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
                break;
            }
            
            return sysSvcCdItems;
        }

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪�@1-����{�ݓ����� 2-�O���T�[�r�X���p�^
        sb.append(CODE_CHAR[_1350101]);

        if (_1350101 == 1) { // ����{�ݓ����Ґ�������
            // �v���x
            sb.append(CODE_CHAR[_1]);
            
        } else { // �O���T�[�r�X���p�^����{�ݓ����Ґ�������
            // �v���x
            sb.append(DEFAULT_CHAR);
            
        }

        // �l�����Z�@1-�Ȃ� 2-�Ō�E���E���̕s��
        sb.append(CODE_CHAR[_1350103]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        
        // 6003 �\�h����{�݌ʋ@�\�P�����Z
        if (_1350102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
        }
        
        // 6123 �\�h����{�݈�Ë@�֘A�g���Z
        if (_1350127 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }
        
        // 6124 �\�h����{�ݏ�Q�ғ��x�����Z
        if (_1350128 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6124");
        }
        
        // ���E���������P��ԋp
        switch (_17) {
        case 2:
            // �\�h����{�ݏ������P���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            break;
        case 3:
            // �\�h����{�ݏ������P���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;
        case 4:
            // �\�h����{�ݏ������P���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
            break;
        }

        // �O���T�[�r�X
        // ============================================================================
        // �O���T�[�r�X�@1-�K���� 2-�K�������� 3-�K��Ō� 4-�K�⃊�n 5-�ʏ���� 6-�ʏ����n 7-�����p��ݗ^
        // 8-�F�m�ǑΉ��^�ʏ����
        if (_1350101 == 2) {
            switch (_1350104) {
            case 1: // �K����
                getSystemServiceCodeItemHomonKaigo(map, sysSvcCdItems);
                break;
            case 2: // �K��������
                getSystemServiceCodeItemHomonNyuyokuKaigo(map, sysSvcCdItems);
                break;
            case 3: // �K��Ō�
                getSystemServiceCodeItemHomonKango(map, sysSvcCdItems);
                break;
            case 4: // �K�⃊�n�r���e�[�V����
                getSystemServiceCodeItemHomonReha(map, sysSvcCdItems);
                break;
            case 5: // �ʏ����
                getSystemServiceCodeItemTushoKaigo(map, sysSvcCdItems);
                break;
            case 6: // �ʏ����n�r���e�[�V����
                getSystemServiceCodeItemTushoReha(map, sysSvcCdItems);
                break;
            case 7: // �����p��ݗ^
                getSystemServiceCodeItemFukushiYoguTaiyo(map, sysSvcCdItems);
                break;
            case 8: // �F�m�ǑΉ��^�ʏ����
                getSystemServiceCodeItemNinchishoTaiogataTushoKaigo(map,
                        sysSvcCdItems);
                break;
            }
        }

        return sysSvcCdItems;
    }

    /**
     * �O���T�[�r�X�E�K����
     * 
     * @param map
     * @param sysSvcCdItems
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemHomonKaigo(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // �p�����[�^���o
        // =========================================================================

        // 1350105 �K����-��ʁ@1-�T�^ 2-�U�^ 3-�V�^
        int _1350105 = getIntValue(map, "1350105", 1);

        // 1350106 �K����-�����@1-�����łȂ� 2-�����ł���
        int _1350106 = getIntValue(map, "1350106", 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪
        sb.append(CODE_CHAR[_1350101]);

        // �O���T�[�r�X���
        sb.append(CODE_CHAR[_1350104]);

        // �K����-��ʁ@1-�T�^ 2-�U�^ 3-�V�^
        sb.append(CODE_CHAR[_1350105]);

        // �K����-�����@1-�����łȂ� 2-�����ł���
        sb.append(CODE_CHAR[_1350106]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        return sysSvcCdItems;
    }

    /**
     * �O���T�[�r�X�E�K��������
     * 
     * @param map
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemHomonNyuyokuKaigo(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // �p�����[�^���o
        // =========================================================================

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪
        sb.append(CODE_CHAR[_1350101]);

        // �O���T�[�r�X���
        sb.append(CODE_CHAR[_1350104]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        return sysSvcCdItems;
    }

    /**
     * �O���T�[�r�X�E�K��Ō�
     * 
     * @param map
     * @param sysSvcCdItems
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemHomonKango(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // �p�����[�^���o
        // =========================================================================

        // 1350107 �K��Ō�-�{�ݓ��̋敪�@1-�K��Ō�X�e�[�V���� 2-�a�@���͐f�Ï�
        int _1350107 = getIntValue(map, "1350107", 1);

        // 1350108 �K��Ō�-�E���敪�@1-�Ȃ� 2-PT�AOT�AST
        int _1350108 = getIntValue(map, "1350108", 1);

        // 1350109 �K��Ō�-���ԋ敪�@1-20������ 2-30������ 3-30���ȏ�1���Ԗ���
        // 4-1���Ԉȏ�1����30�������i1-30������ 2-30���ȏ�1���Ԗ����j
        int _1350109 = getIntValue(map, "1350109", 1);
        
        // 1350132 1����2����z���Ď��{ 1-�Ȃ� 2-����
        int _1350132 = getIntValue(map, "1350132", 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪
        sb.append(CODE_CHAR[_1350101]);

        // �O���T�[�r�X
        sb.append(CODE_CHAR[_1350104]);

        // �K��Ō�-�{�ݓ��̋敪�@1-�K��Ō�X�e�[�V���� 2-�a�@���͐f�Ï�
        sb.append(CODE_CHAR[_1350107]);

        // �K��Ō�-�E���敪�@1-�Ȃ� 2-PT�AOT�AST
        sb.append(CODE_CHAR[_1350108]);

        // �K��Ō�-���ԋ敪�@1-20������ 2-30������ 3-30���ȏ�1���Ԗ��� 4-1���Ԉȏ�1����30�������i1-30������
        // 2-30���ȏ�1���Ԗ����j
        sb.append(CODE_CHAR[_1350109]);
        
        // 1����2����z���Ď��{
        sb.append(CODE_CHAR[_1350132]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        return sysSvcCdItems;
    }

    /**
     * �O���T�[�r�X�E�K�⃊�n
     * 
     * @param map
     * @param sysSvcCdItems
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemHomonReha(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // �p�����[�^���o
        // =========================================================================

        // 1350110 �K�⃊�n-�{�ݓ��̋敪�@1-�a�@���͐f�Ï� 2-���V�l�ی��{��
        int _1350110 = getIntValue(map, "1350110", 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪
        sb.append(CODE_CHAR[_1350101]);

        // �O���T�[�r�X
        sb.append(CODE_CHAR[_1350104]);

        // �K�⃊�n-�{�ݓ��̋敪�@1-�a�@���͐f�Ï� 2-���V�l�ی��{��
        sb.append(CODE_CHAR[_1350110]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        return sysSvcCdItems;
    }

    /**
     * �ʏ����
     * 
     * @param map
     * @param sysSvcCdItems
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemTushoKaigo(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // �p�����[�^���o
        // =========================================================================

        // 1350111 �ʏ����-�����@1-�����łȂ� 2-�����ł���
        int _1350111 = getIntValue(map, "1350111", 1);

        // 1350112 �ʏ����-�^���@�\������Z�@1-�Ȃ� 2-����
        int _1350112 = getIntValue(map, "1350112", 1);

        // 1350113 �ʏ����-�h�{���P���Z�@1-�Ȃ� 2-����
        int _1350113 = getIntValue(map, "1350113", 1);

        // 1350114 �ʏ����-���o�@�\������Z�@1-�Ȃ� 2-����
        int _1350114 = getIntValue(map, "1350114", 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1350101]);

        // �O���T�[�r�X
        sb.append(CODE_CHAR[_1350104]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �ʏ����-�����@1-�����łȂ� 2-�����ł���
        sb.append(CODE_CHAR[_1350111]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ===========================================================================
        
        // [�^���@�\������Z][�h�{���P���Z][���o�@�\������Z]��3���̐��l�ɕϊ�
        int addParam = (_1350112 * 100) + (_1350113 * 10) + _1350114;
        
        switch(addParam) {
        // �^����@�\������Z
        case 211:
            // �\�h�O���ʏ����^������Z
            putSystemServiceCodeItem(sysSvcCdItems, "Z1722");
            break;
        // �h�{���P���Z
        case 121:
            // �\�h�O���ʏ����h�{���P���Z
            putSystemServiceCodeItem(sysSvcCdItems, "Z1723");
            break;
        // ���o�@�\������Z
        case 112:
            // �\�h�O���ʏ������o�@�\���Z
            putSystemServiceCodeItem(sysSvcCdItems, "Z1724");
            break;
        // �^����@�\������Z + �h�{���P���Z
        case 221:
            // �\�h�O���ʉ���T�[�r�X���ZI�P
            putSystemServiceCodeItem(sysSvcCdItems, "Z1725");
            break;
        // �^����@�\������Z + ���o�@�\������Z
        case 212:
            // �\�h�O���ʉ���T�[�r�X���ZI�Q
            putSystemServiceCodeItem(sysSvcCdItems, "Z1726");
            break;
        // �h�{���P���Z + ���o�@�\������Z
        case 122:
            // �\�h�O���ʉ���T�[�r�X���ZI�R
            putSystemServiceCodeItem(sysSvcCdItems, "Z1727");
            break;
        // �^����@�\������Z + �h�{���P���Z + ���o�@�\������Z
        case 222:
            // �\�h�O���ʉ���T�[�r�X���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z1728");
            break;
        }
        
        
        return sysSvcCdItems;
    }

    /**
     * �ʏ����n
     * 
     * @param map
     * @param sysSvcCdItems
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemTushoReha(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // �p�����[�^���o
        // =========================================================================

        // 1350115 �ʏ����n-�����@1-�����łȂ� 2-�����ł���
        int _1350115 = getIntValue(map, "1350115", 1);

        // 1350116 �ʏ����n-�^���@�\������Z�@1-�Ȃ� 2-����
        int _1350116 = getIntValue(map, "1350116", 1);

        // 1350117 �ʏ����n-�h�{���P���Z�@1-�Ȃ� 2-����
        int _1350117 = getIntValue(map, "1350117", 1);

        // 1350118 �ʏ����n-���o�@�\������Z�@1-�Ȃ� 2-����
        int _1350118 = getIntValue(map, "1350118", 1);
        
        // 1350133 �{�ݓ��̋敪 1-�a�@���͐f�Ï� 2-���V�l�ی��{��
        int _1350133 = getIntValue(map, "1350133", 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪
        sb.append(CODE_CHAR[_1350101]);

        // �O���T�[�r�X
        sb.append(CODE_CHAR[_1350104]);
        
        // �{�ݓ��̋敪
        sb.append(CODE_CHAR[_1350133]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // �ʏ����n-�����@1-�����łȂ� 2-�����ł���
        sb.append(CODE_CHAR[_1350115]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ===========================================================================
        // [�^���@�\������Z][�h�{���P���Z][���o�@�\������Z]��3���̐��l�ɕϊ�
        int addParam = (_1350116 * 100) + (_1350117 * 10) + _1350118;
        
        switch(addParam) {
        // �^����@�\������Z
        case 211:
            // �\�h�O���ʏ����^������Z
            putSystemServiceCodeItem(sysSvcCdItems, "Z1821");
            break;
        // �h�{���P���Z
        case 121:
            // �\�h�O���ʏ����h�{���P���Z
            putSystemServiceCodeItem(sysSvcCdItems, "Z1822");
            break;
        // ���o�@�\������Z
        case 112:
            // �\�h�O���ʏ������o�@�\���Z
            putSystemServiceCodeItem(sysSvcCdItems, "Z1823");
            break;
        // �^����@�\������Z + �h�{���P���Z
        case 221:
            // �\�h�O���ʉ���T�[�r�X���ZI�P
            putSystemServiceCodeItem(sysSvcCdItems, "Z1824");
            break;
        // �^����@�\������Z + ���o�@�\������Z
        case 212:
            // �\�h�O���ʉ���T�[�r�X���ZI�Q
            putSystemServiceCodeItem(sysSvcCdItems, "Z1825");
            break;
        // �h�{���P���Z + ���o�@�\������Z
        case 122:
            // �\�h�O���ʉ���T�[�r�X���ZI�R
            putSystemServiceCodeItem(sysSvcCdItems, "Z1826");
            break;
        // �^����@�\������Z + �h�{���P���Z + ���o�@�\������Z
        case 222:
            // �\�h�O���ʉ���T�[�r�X���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z1827");
            break;
        }

        return sysSvcCdItems;
    }

    /**
     * �O���T�[�r�X�E�����p��ݗ^
     * 
     * @param map
     * @param sysSvcCdItems
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemFukushiYoguTaiyo(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // �p�����[�^���o
        // =========================================================================

        // 1350119 �����p��ݗ^-�p��
        int yoguYogu = getIntValue(map, "1350119", 1);

        // 1350120 �����p��ݗ^-�P�ʐ�
        try {
            baseUnit = getIntValue(map, "1350120");
        } catch (Exception ex) {
            // ���͐����R�ꂪ���������W���[���ō쐬�����f�[�^�ւ̗�O�Ή�
            ACMessageBox
                    .show("����{�ݓ����Ґ������̊O���T�[�r�X���p�^(�����p��ݗ^)�̒P�ʐ��ɐ����ȊO�����͂���Ă��܂��B"
                            + ACConstants.LINE_SEPARATOR
                            + "�s���ȒP�ʐ��̃f�[�^�͌v�Z����܂���B");
            return sysSvcCdItems;
        }

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪
        sb.append(CODE_CHAR[_1350101]);

        // �O���T�[�r�X���
        sb.append(CODE_CHAR[_1350104]);

        // �����p��ݗ^-�p��
        sb.append(CODE_CHAR[yoguYogu]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        return sysSvcCdItems;
    }

    /**
     * �O���T�[�r�X�E�F�m�ǑΉ��^�ʏ����
     * 
     * @param map
     * @param sysSvcCdItems
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemNinchishoTaiogataTushoKaigo(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // �p�����[�^���o
        // =========================================================================

        // 1350121 �F�m�ǑΉ��^�ʏ����-�{�ݓ��̋敪1�@1-�T�^ 2-�U�^
        int _1350121 = getIntValue(map, "1350121", 1);

        // 1350122 �F�m�ǑΉ��^�ʏ����-�{�ݓ��̋敪2�@1-�P�ƌ^ 2-���݌^
        int _1350122 = getIntValue(map, "1350122", 1);

        // 1350123 �F�m�ǑΉ��^�ʏ����-���ԋ敪�@1-2�`3���� 2-3�`4���� 3-4�`6���� 4-6�`8����
        int _1350123 = getIntValue(map, "1350123", 1);

        // 1350124 �F�m�ǑΉ��^�ʏ����-�ʋ@�\�P�����Z�@1-�Ȃ� 2-����
        int _1350124 = getIntValue(map, "1350124", 1);

        // 1350125 �F�m�ǑΉ��^�ʏ����-�h�{���P���Z�@1-�Ȃ� 2-����
        int _1350125 = getIntValue(map, "1350125", 1);

        // 1350126 �F�m�ǑΉ��^�ʏ����-���o�@�\������Z�@1-�Ȃ� 2-����
        int _1350126 = getIntValue(map, "1350126", 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�ݓ��̋敪
        sb.append(CODE_CHAR[_1350101]);

        // �O���T�[�r�X���
        sb.append(CODE_CHAR[_1350104]);

        // �F�m�ǑΉ��^�ʏ����-�{�ݓ��̋敪1�@1-�T�^ 2-�U�^
        sb.append(CODE_CHAR[_1350121]);

        // �F�m�ǑΉ��^�ʏ����-�{�ݓ��̋敪2�@1-�P�ƌ^ 2-���݌^
        sb.append(CODE_CHAR[_1350122]);

        // �F�m�ǑΉ��^�ʏ����-���ԋ敪�@1-2�`3���� 2-3�`4���� 3-4�`6���� 4-6�`8����
        sb.append(CODE_CHAR[_1350123]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ===========================================================================

        // �F�m�ǑΉ��^�ʏ����-�ʋ@�\�P�����Z�@1-�Ȃ� 2-����
        if (_1350124 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2141");
        }

        // �F�m�ǑΉ��^�ʏ����-�h�{���P���Z�@1-�Ȃ� 2-����
        if (_1350125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2142");
        }

        // �F�m�ǑΉ��^�ʏ����-���o�@�\������Z�@1-�Ȃ� 2-����
        if (_1350126 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2143");
        }
        
        return sysSvcCdItems;
    }

    /**
     * �����p��̒P�ʐ���Ԃ�
     */
    public ArrayList<VRMap> getServiceCode(Map<String, String> map,
            ACDBManager dbm) {
        ArrayList<VRMap> al = super.getServiceCode(map, dbm);
        if (_1350104 == 7) {
            Map<String, Integer> mp = null;
            // �㏑���p�̃��R�[�h�����݂����ꍇ�͏㏑�����s���B
            if (al.size() > 1) {
                mp = (Map<String, Integer>) al.get(al.size() - 1);
                mp.put("SERVICE_UNIT", new Integer(this.baseUnit));
            }
        }
        return al;
    }
}
