package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.util.VRMap;

public class SC_13311_201504 extends Qkan10011_ServiceUnitGetter {
    private int baseUnit = 0;// �����p��P�ʗp�ϐ�
    private int _1330107 = 0;// �T�[�r�X��ފm��p

    public String getServiceName() {
        return "����{�ݓ����Ґ������";
    }

    public String getServiceCodeKind() {
        return "33";
    }

    public String getSystemServiceKindDetail() {
        return "13311";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        // 1330105 �{�݋敪
        int _1330105 = getIntValue(map, "1330105");

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1330104 �l�����Z
        int _1330104 = getIntValue(map, "1330104");

        // 1330103 �ʋ@�\�P���w�����Z
        int _1330103 = getIntValue(map, "1330103", 1);

        // 1330106 ��ԉ��̐����Z
        int _1330106 = getIntValue(map, "1330106", 1);

        // 1330124 ��Ë@�֘A�g���Z
        int _1330124 = getIntValue(map, "1330124", 1);

        // 1330125 ��Q�ғ��x�����Z
        int _1330125 = getIntValue(map, "1330125", 1);

        // 1330107 �O���T�[�r�X
        _1330107 = getIntValue(map, "1330107", 1);

        // 1330128 �Ŏ������Z
        int _1330128 = getIntValue(map, "1330128", 1);
        
        // 1330130 �F�m�ǐ��P�A���Z
        int _1330130 = getIntValue(map, "1330130", 1);
        
        // 1330131 �T�[�r�X�񋟑̐��������Z
        int _1330131 = getIntValue(map, "1330131", 1);

        // �P�Ɖ��Z
        int _9 = getIntValue(map, "9");
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        
        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if (_9 == 2) {
            
            // �Ŏ������Z
            switch (_1330128) {
            case 2: // ����{�݊Ŏ������Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6125");
                break;
            case 3: // ����{�݊Ŏ������Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6126");
                break;
            case 4: // ����{�݊Ŏ������Z�R
                putSystemServiceCodeItem(sysSvcCdItems, "Z6127");
                break;
            }
            
            // ���E���������P��ԋp
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6131");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
                break;
            }

            return sysSvcCdItems;
        }
        
        // ===========================================================================
        // ��b�P�ʂ݂̂�Ԃ�
        // �Ȃ���I�������ꍇ
        if (_1330107 == 9) {
            // �l�����Z�̒l���`�F�b�N
            if (_1330104 == 2) {
                // �l�����Z���肾�����ꍇ
                putSystemServiceCodeItem(sysSvcCdItems, "212");
            } else {
                // �l�����Z�Ȃ��������ꍇ
                putSystemServiceCodeItem(sysSvcCdItems, "211");
            }

            // 6124 ����{�ݏ�Q�ғ��x�����Z
            if (_1330125 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6124");
            }

            // �F�m�ǐ��P�A���Z
            switch (_1330130) {
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6133");//2015.04
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6134");//2015.04
                break;
            }
            
            // �T�[�r�X�񋟑̐����Z
            switch (_1330131) {
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//2015.04
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6102");//2015.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6103");//2015.04
                break;
            }
            
            // ���E���������P��ԋp
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6131");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
                break;
            }
            return sysSvcCdItems;

        }

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1330105]);

        if (_1330105 == 1) { // ����{�ݓ����Ґ�������
            // �v���x
            sb.append(CODE_CHAR[_1]);

        } else { // �O���T�[�r�X���p�^����{�ݓ����Ґ�������
            // �v���x
            sb.append(DEFAULT_CHAR);

        }

        // �l�����Z
        sb.append(CODE_CHAR[_1330104]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        // 6003 ����{�݌ʋ@�\�P�����Z
        if (_1330103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
        }

        // ��ԉ��̐����Z
        if (_1330106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z1160");
        }

        // 6123 ����{�݈�Ë@�֘A�g���Z
        if (_1330124 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }

        // �Ŏ������Z
        switch (_1330128) {
        case 2: // ����{�݊Ŏ������Z�P
            putSystemServiceCodeItem(sysSvcCdItems, "Z6125");
            break;
        case 3: // ����{�݊Ŏ������Z�Q
            putSystemServiceCodeItem(sysSvcCdItems, "Z6126");
            break;
        case 4: // ����{�݊Ŏ������Z�R
            putSystemServiceCodeItem(sysSvcCdItems, "Z6127");
            break;
        }

        // �F�m�ǐ��P�A���Z
        switch (_1330130) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");//2015.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");//2015.04
            break;
        }
        
        // �T�[�r�X�񋟑̐����Z
        switch (_1330131) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//2015.04
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");//2015.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");//2015.04
            break;
        }
        
        // 6124 ����{�ݏ�Q�ғ��x�����Z
        if (_1330125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6124");
        }

        // ���E���������P��ԋp
        switch (_17) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6131");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
            break;
        }

        // �O���T�[�r�X
        // ==================================================================
        if (_1330105 == 2) {
            switch (_1330107) {
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
        // 1330105 �{�݋敪
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 �O���T�[�r�X
        int _1330107 = getIntValue(map, "1330107");

        // 1330108 �K����-���
        int _1330108 = getIntValue(map, "1330108");

        // 1330109 �K����-���ԋ敪
        int _1330109 = getIntValue(map, "1330109");

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1330105]);

        // �O���T�[�r�X
        sb.append(CODE_CHAR[_1330107]);

        // �K����-���
        sb.append(CODE_CHAR[_1330108]);

        // �K����-���ԋ敪
        // ��ʂ��ʉ@����~��������ꍇ
        // ���ԋ敪�����O�����`�ŕԂ�
        if (_1330108 == 3) {
            sb.append(DEFAULT_CHAR);

        } else if (_1330108 == 2) {
            // ���������������ꍇ
            // ���ԋ敪��1���Ԉȏ�30�����������傫���l��I�����Ă����ꍇ
            if (_1330109 > 6) {
                // 1����15���ȏ�(index:6)�̑I���Ƃ���
                sb.append(CODE_CHAR[6]);
            } else {
                // �ǉ�����B
                sb.append(CODE_CHAR[_1330109]);
            }
        } else {
            sb.append(CODE_CHAR[_1330109]);
        }
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
        // 1330105 �{�݋敪
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 �O���T�[�r�X
        int _1330107 = getIntValue(map, "1330107");

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();
        // �{�݋敪
        sb.append(CODE_CHAR[_1330105]);

        // �O���T�[�r�X
        sb.append(CODE_CHAR[_1330107]);

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
        // 1330105 �{�݋敪
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 �O���T�[�r�X
        int _1330107 = getIntValue(map, "1330107");

        // 1330110 �K��Ō�-�{�݋敪 1-�K��Ō�X�e�[�V���� 2-�a�@���͐f�Ï�
        int _1330110 = getIntValue(map, "1330110");

        // 1330112 �K��Ō�-���ԋ敪 1-30������ 2-30���ȏ�1���Ԗ���
        int _1330112 = getIntValue(map, "1330112");

        // 1330111 �K��Ō�-�E���敪 1-�Ȃ� 2-PT�AOT�AST
        int _1330111 = getIntValue(map, "1330111");

        // 1330129 1����2����z���Ď��{ 1-�Ȃ� 2-����
        int _1330129 = getIntValue(map, "1330129");
        
        // 1330132 �Ō�E���敪
        int _1330132 = getIntValue(map, "1330132", 1);//2015.04

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1330105]);

        // �O���T�[�r�X
        sb.append(CODE_CHAR[_1330107]);

        // �K��Ō�-�{�݋敪 1-�K��Ō�X�e�[�V���� 2-�a�@���͐f�Ï�
        sb.append(CODE_CHAR[_1330110]);

        // �K��Ō�-���ԋ敪
        sb.append(CODE_CHAR[_1330112]);

        // �K��Ō�-�E���敪 1-�Ȃ� 2-PT�AOT�AST
        sb.append(CODE_CHAR[_1330111]);

        // 1����2����z���Ď��{ 1-�Ȃ� 2-����
        sb.append(CODE_CHAR[_1330129]);
        
        // �K��Ō�-�Ō�E���敪�@1-���œ� 2-�y��
        sb.append(CODE_CHAR[_1330132]); //2015.04

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
        // 1330105 �{�݋敪
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 �O���T�[�r�X
        int _1330107 = getIntValue(map, "1330107");

        // 1330113 �K�⃊�n-�{�݋敪
        int _1330113 = getIntValue(map, "1330113");

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1330105]);

        // �O���T�[�r�X
        sb.append(CODE_CHAR[_1330107]);

        // �K�⃊�n-�{�݋敪
        sb.append(CODE_CHAR[_1330113]);

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
        // 1330105 �{�݋敪
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 �O���T�[�r�X
        int _1330107 = getIntValue(map, "1330107");

        // 1330126 �ʏ����-�{�݋敪 1-���K�͎��Ə� 2-�ʏ�K�͎��Ə� 3-��K�͎��Ə� I 4-��K�͎��Ə� II 5-�×{�ʏ�
        int _1330126 = getIntValue(map, "1330126");

        // 1330115 �ʏ����-���ԋ敪
        int _1330115 = getIntValue(map, "1330115");

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1330105]);

        // �O���T�[�r�X
        sb.append(CODE_CHAR[_1330107]);

        // �ʏ����-�{�݋敪 1-���K�͎��Ə� 2-�ʏ�K�͎��Ə� 3-��K�͎��Ə� I 4-��K�͎��Ə� II 5-�×{�ʏ�
        sb.append(CODE_CHAR[_1330126]);

        // �ʏ����-���ԋ敪
        // �×{�ʏ��̏ꍇ
        if (_1330126 == 5) {
            sb.append(DEFAULT_CHAR);
            sb.append(CODE_CHAR[_1330115]);
        } else {
            sb.append(CODE_CHAR[_1330115]);
            sb.append(DEFAULT_CHAR);
        }

        // �v���x
        if (_1330126 == 5) {
            // �×{�ʏ��̏ꍇ�A�v���x�͗��܂Ȃ�
            sb.append(DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

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
        // 1330105 �{�݋敪
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 �O���T�[�r�X
        int _1330107 = getIntValue(map, "1330107");

        // 1330127 �ʏ����n-�{�݋敪 1-�ʏ�K�͎��Ə� 2-��K�͎��Ə� I 3-��K�͎��Ə� II
        int _1330127 = getIntValue(map, "1330127");

        // 1330117 �ʏ����n-���ԋ敪
        int _1330117 = getIntValue(map, "1330117");

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1330105]);

        // �O���T�[�r�X
        sb.append(CODE_CHAR[_1330107]);

        // �ʏ����n-�{�݋敪 1-�ʏ�K�͎��Ə� 2-��K�͎��Ə� I 3-��K�͎��Ə� II
        sb.append(CODE_CHAR[_1330127]);

        // �ʏ����n-���ԋ敪
        sb.append(CODE_CHAR[_1330117]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

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
        // 1330105 �{�݋敪
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 �O���T�[�r�X
        int _1330107 = getIntValue(map, "1330107");

        // 1330118 �����p��ݗ^-�p��
        int _1330118 = getIntValue(map, "1330118");

        try {
            baseUnit = getIntValue(map, "1330119");
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

        // �{�݋敪
        sb.append(CODE_CHAR[_1330105]);

        // �O���T�[�r�X
        sb.append(CODE_CHAR[_1330107]);

        // �����p��ݗ^-�p��
        sb.append(CODE_CHAR[_1330118]);

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
        // 1330105 �{�݋敪
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 �O���T�[�r�X
        int _1330107 = getIntValue(map, "1330107");

        // 1330121 �{�ݓ��̋敪�@1-�T�^ 2-�U�^
        int _1330121 = getIntValue(map, "1330121");

        // 1330122 �敪�@1-�P�ƌ^ 2-���݌^
        int _1330122 = getIntValue(map, "1330122");

        // 1330123 ���ԋ敪�@1-2�`3���� 2-3�`4���� 3-4�`6���� 4-6�`8����
        int _1330123 = getIntValue(map, "1330123");

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1330105]);

        // �O���T�[�r�X
        sb.append(CODE_CHAR[_1330107]);

        // �{�ݓ��̋敪�@1-�T�^ 2-�U�^
        sb.append(CODE_CHAR[_1330121]);

        // �敪�@1-�P�ƌ^ 2-���݌^
        sb.append(CODE_CHAR[_1330122]);

        // ���ԋ敪�@1-2�`3���� 2-3�`4���� 3-4�`6���� 4-6�`8����
        sb.append(CODE_CHAR[_1330123]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        return sysSvcCdItems;
    }

    /**
     * �����p��̒P�ʐ���Ԃ�
     */
    public ArrayList<VRMap> getServiceCode(Map<String, String> map,
            ACDBManager dbm) {
        ArrayList<VRMap> al = super.getServiceCode(map, dbm);
        if (_1330107 == 7) {
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
