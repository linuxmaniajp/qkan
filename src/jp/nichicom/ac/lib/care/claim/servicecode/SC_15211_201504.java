package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * ���ی��{��
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_15211_201504 extends Qkan10011_ServiceUnitGetter {
    private int _1520122 = 0;

    private final String PATH_UNIT_ROOM = "1520114";
    private final String PATH_UNIT_SEMI_ROOM = "1520115";
    private final String PATH_NORMAL_ROOM = "1520116";
    private final String PATH_TASHO_ROOM = "1520117";

    public String getServiceName() {
        return "���ی��{��";
    }

    public String getServiceCodeKind() {
        return "52";
    }

    public String getSystemServiceKindDetail() {
        return "15211";
    }

    private boolean isRyoyoType(int _1520101) {
        boolean ret = true;
        switch (_1520101) {
        case 1: // ���V�l�ی��{�݁iI�j
        case 2: // ���j�b�g�^���V�l�ی��{�݁iI�j
            ret = false;
            break;
        }
        return ret;
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        // 1520101 �{�݋敪
        int _1520101 = getIntValue(map, "1520101");

        // 1520102 �a���敪(�]���^)
        int _1520102 = getIntValue(map, "1520102");

        // 1520103 �a���敪(���j�b�g�^)
        int _1520103 = getIntValue(map, "1520103");

        // �a���敪
        int byoshitsu = 1;
        switch (_1520101) {
        case 1:
        case 3:
        case 5:
            byoshitsu = convertByoshitsuKbn(_1520102, false);
            break;
        case 2:
        case 4:
        case 6:
            byoshitsu = convertByoshitsuKbn(_1520103, true);
            break;
        }

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // �o�ߑ[�u�Ή��p�ɗv�x���P�܂��͗v�x���Q�������ꍇ�͗v���P�Ƃ݂Ȃ�
        if (_1 == 3 || _1 == 4) {
            _1 = 5;
        }

        // 1520104 ��ԋΖ������
        int _1520104 = getIntValue(map, "1520104");

        // 1520119 �l�����Z
        int _1520119 = getIntValue(map, "1520119");

        // 1520127 ���j�b�g�P�A�̐���
        int _1520127 = getIntValue(map, "1520127");

        // 1520124 �Z���W�����n�r���e�[�V�������Z
        int _1520124 = getIntValue(map, "1520124");

        // 1520125 �F�m�Ǎ����
        int _1520125 = getIntValue(map, "1520125");

        // 1520128 �ӎv�a�ʍ���P�A���Z
        int _1520128 = getIntValue(map, "1520128");

        // 1520130 �g�̍S���p�~�����{���Z
        int _1520130 = getIntValue(map, "1520130");

        // 1520107 �O�����Z
        int _1520107 = getIntValue(map, "1520107");

        // 1520108 �������Z
        int _1520108 = getIntValue(map, "1520108");

        // 3020105 �ޏ����w�����Z
        int _3020105 = getIntValue(map, "3020105");

        // 3020106 �ޏ������񋟉��Z
        int _3020106 = getIntValue(map, "3020106");

        // 3020107 �ޏ��O�A�g���Z
        int _3020107 = getIntValue(map, "3020107");

        // 3020108 �V�l�K��Ō�w�����Z
        int _3020108 = getIntValue(map, "3020108");

        // 1520111 �h�{�}�l�W�����g���Z
        int _1520111 = getIntValue(map, "1520111");

        // 1520112 �o���ڍs���Z
        int _1520112 = getIntValue(map, "1520112");

        // 1520126 �o���ێ����ZI
        int _1520126 = getIntValue(map, "1520126");
        
        // 1520151 �o���ێ����ZII
        int _1520151 = getIntValue(map, "1520151");

        // 1520134 �×{�̐��ێ����ʉ��Z
        int _1520134 = getIntValue(map, "1520134");

        // 1520113 �×{�H���Z
        int _1520113 = getIntValue(map, "1520113");

        // 1520133 �^�[�~�i���P�A���Z
        int _1520141 = getIntValue(map, "1520141");

        // 1520109 �ً}�����ÊǗ����Z
        int _1520109 = getIntValue(map, "1520109");

        // 1520120 �H����
        int _1520120 = getIntValue(map, "1520120");

        // 1520122 �H��
        this._1520122 = getIntValue(map, "1520122");

        // 1520135 ���o�@�\�ێ��Ǘ����Z
        int _1520135 = getIntValue(map, "1520135");

        // 1520136 ��ΐE���z�u���Z
        int _1520136 = getIntValue(map, "1520136");

        // 1520137 �F�m�ǐ��P�A���Z
        int _1520137 = getIntValue(map, "1520137");

        // 1520138 ��N���F�m�Ǔ����Ҏ�����Z
        int _1520138 = getIntValue(map, "1520138");

        // 1520139 �F�m�Ǐ��񋟉��Z
        int _1520139 = getIntValue(map, "1520139");

        // 1520142 �T�[�r�X�񋟑̐��������Z
        int _1520142 = getIntValue(map, "1520142");

        // �P�Ɖ��Z
        int _9 = getIntValue(map, "9");

        // 1520143 �l���z�u�敪
        int _1520143 = getIntValue(map, "1520143", 1);

        // 3020109 �ޏ�(�@)�O�K��w�����Z
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 �ޏ�(�@)��K��w�����Z
        int _3020110 = getIntValue(map, "3020110", 1);

        // 1520146 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1520146 = getIntValue(map, "1520146", 1);

        // 1520144 �����O��K��w�����Z
        int _1520144 = getIntValue(map, "1520144", 1);

        // 1520145 ���莾���{�ݗ×{��
        int _1520145 = getIntValue(map, "1520145", 1);

        // 1520147 �n��A�g�f�Ìv����񋟉��Z
        int _1520147 = getIntValue(map, "1520147", 1);

        // 1520149 �l���z�u�敪�i�×{�^�j
        int _1520149 = getIntValue(map, "1520149", 1);

        // 1520140 �ݑ�A�ݑ�×{�x�����Z
        int _1520140 = getIntValue(map, "1520140", 1);

        // 1510145 ���o�@�\�ێ��Ǘ��̐����Z
        int _1510145 = getIntValue(map, "1510145", 1);

        // 1520148 �ݑ�A�x���@�\���Z
        int _1520148 = getIntValue(map, "1520148", 1);

        // 17 ���E���������P���Z
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �P�Ɖ��Z�̂�---------------------------------------------------------------
        // �P�Ɖ��Z�T�[�r�X
        if (_9 == 2) {

            // �ޏ���K��w�����Z
            if (_3020110 > 1) {

                // �×{�^�ȊO�̏ꍇ�́A�]���^/�ݑ���^���`�F�b�N
                if (!isRyoyoType(_1520101)) {
                    // �ݑ���^
                    if (_1520143 == 2) {
                        // �ی��{�ݑޏ���K��w�����Z�P
                        putSystemServiceCodeItem(sysSvcCdItems, "Z6507");

                        // �ݑ���^�ȊO
                    } else {
                        // �ی��{�ݑޏ���K��w�����Z�Q
                        putSystemServiceCodeItem(sysSvcCdItems, "Z6508");
                    }

                    // �×{�^�̏ꍇ�́A�×{�^/�×{�����^���`�F�b�N
                } else {
                    // �×{�����^
                    if (_1520149 == 2) {
                        // �ی��{�ݑޏ���K��w�����Z�P
                        putSystemServiceCodeItem(sysSvcCdItems, "Z6507");

                        // �×{�����^�ȊO
                    } else {
                        // �ی��{�ݑޏ���K��w�����Z�Q
                        putSystemServiceCodeItem(sysSvcCdItems, "Z6508");
                    }
                }
            }

            // �^�[�~�i���P�A���Z
            switch (_1520141) {
            // ���S���ȑO4���ȏ�30���ȉ�
            case 2:
                // �×{�^�ȊO
                if (!isRyoyoType(_1520101)) {
                    // �ی��{�݃^�[�~�i���P�A���Z�P�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6600");

                    // �×{�^
                } else {
                    // �ی��{�݃^�[�~�i���P�A���Z�P�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6001");
                }
                break;

            // ���S���ȑO2������3��
            case 3:
                // �×{�^�ȊO
                if (!isRyoyoType(_1520101)) {
                    // �ی��{�݃^�[�~�i���P�A���Z�Q�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6602");

                    // �×{�^
                } else {
                    // �ی��{�݃^�[�~�i���P�A���Z�Q�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6002");
                }
                break;

            // ���S��
            case 4:
                // �×{�^�ȊO
                if (!isRyoyoType(_1520101)) {
                    // �ی��{�݃^�[�~�i���P�A���Z�R�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6603");

                    // �×{�^
                } else {
                    // �ی��{�݃^�[�~�i���P�A���Z�R�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
                }
                break;
            }

            // ���E���������P��ԋp
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
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

        // �{�݋敪
        sb.append(CODE_CHAR[_1520101]);

        // �a���敪(�]���^��/������)
        sb.append(CODE_CHAR[_1520102]);

        // �a���敪(���j�b�g�^��/���j�b�g�^����)
        sb.append(CODE_CHAR[_1520103]);

        // �l���z�u�敪(�]���^/�ݑ���^)
        sb.append(CODE_CHAR[_1520143]);

        // �l���z�u�敪(�×{�^/�×{�����^)
        sb.append(CODE_CHAR[_1520149]);

        // �v���x
        sb.append(CODE_CHAR[_1]);

        // ��ԋΖ������
        sb.append(CODE_CHAR[_1520104]);

        // �l�����Z
        sb.append(CODE_CHAR[_1520119]);

        // ���j�b�g�P�A�̐���
        switch (_1520101) {
        case 1: // ���E������
        case 3:
        case 5:
            sb.append(DEFAULT_CHAR);
            break;
        case 2: // ���j�b�g�^
        case 4:
        case 6:
            // 1-������ 2-����
            if (_1520127 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        // Z6117 �ی��{�ݖ�ΐE���z�u���Z
        if (_1520136 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
        }

        // �Z���W�����n�r���e�[�V�������Z
        if (_1520124 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6252");
        }

        // �F�m�Ǎ����(�F�m�ǒZ���W�����n���Z)
        if (_1520125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6253");
        }

        // �F�m�ǃP�A���Z
        if (_1520128 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6254");
        }

        // Z6109 �ی��{�ݎ�N���F�m�ǎ�����Z
        if (_1520138 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }

        // �ݑ�A�ݑ�×{�x�����Z
        if (_1520140 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
        }

        // �g�̍S���p�~�����{���Z
        if (_1520130 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6304");
        }

        // �O�����Z
        if (_1520107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }

        // �^�[�~�i���P�A���Z
        switch (_1520141) {
        // ���S���ȑO4���ȏ�30���ȉ�
        case 2:
            // �×{�^�ȊO
            if (!isRyoyoType(_1520101)) {
                // �ی��{�݃^�[�~�i���P�A���Z�P�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6600");

                // �×{�^
            } else {
                // �ی��{�݃^�[�~�i���P�A���Z�P�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6001");
            }
            break;

        // ���S���ȑO2������3��
        case 3:
            // �×{�^�ȊO
            if (!isRyoyoType(_1520101)) {
                // �ی��{�݃^�[�~�i���P�A���Z�Q�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6602");

                // �×{�^
            } else {
                // �ی��{�݃^�[�~�i���P�A���Z�Q�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6002");
            }
            break;

        // ���S��
        case 4:
            // �×{�^�ȊO
            if (!isRyoyoType(_1520101)) {
                // �ی��{�݃^�[�~�i���P�A���Z�R�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6603");

                // �×{�^
            } else {
                // �ی��{�݃^�[�~�i���P�A���Z�R�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
            }
            break;
        }

        // �×{�̐��ێ����ʉ��Z
        if (_1520134 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6601");
        }

        // �������Z
        if (_1520108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6400");
        }

        // �����O��K��w�����Z
        switch(_1520144) {
        case 2:
            // �×{�^�ȊO�̏ꍇ�́A�]���^/�ݑ���^���`�F�b�N
            if (!isRyoyoType(_1520101)) {
                // �ݑ���^
                if (_1520143 == 2) {
                    // �ی��{�ݓ����O��K��w�����ZI�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6401");

                    // �ݑ���^�ȊO
                } else {
                    // �ی��{�ݓ����O��K��w�����ZI�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6402");
                }

                // �×{�^�̏ꍇ�́A�×{�^/�×{�����^���`�F�b�N
            } else {
                // �×{�����^
                if (_1520149 == 2) {
                    // �ی��{�ݓ����O��K��w�����ZI�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6401");

                    // �×{�����^�ȊO
                } else {
                    // �ی��{�ݓ����O��K��w�����ZI�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6402");
                }
            }
            break;
        case 3:
            // �×{�^�ȊO�̏ꍇ�́A�]���^/�ݑ���^���`�F�b�N
            if (!isRyoyoType(_1520101)) {
                // �ݑ���^
                if (_1520143 == 2) {
                    // �ی��{�ݓ����O��K��w�����ZII�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6403");//2015.04

                    // �ݑ���^�ȊO
                } else {
                    // �ی��{�ݓ����O��K��w�����ZII�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6404");//2015.04
                }

                // �×{�^�̏ꍇ�́A�×{�^/�×{�����^���`�F�b�N
            } else {
                // �×{�����^
                if (_1520149 == 2) {
                    // �ی��{�ݓ����O��K��w�����ZII�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6403");//2015.04

                    // �×{�����^�ȊO
                } else {
                    // �ی��{�ݓ����O��K��w�����ZII�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6404");//2015.04
                }
            }
        	break;
        }

        // �ޏ��O�K��w�����Z
        if (_3020109 > 1) {

            // �×{�^�ȊO�̏ꍇ�́A�]���^/�ݑ���^���`�F�b�N
            if (!isRyoyoType(_1520101)) {
                // �ݑ���^
                if (_1520143 == 2) {
                    // �ی��{�ݑޏ��O�K��w�����Z�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6501");

                    // �ݑ���^�ȊO
                } else {
                    // �ی��{�ݑޏ��O�K��w�����Z�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6506");
                }

                // �×{�^�̏ꍇ�́A�×{�^/�×{�����^���`�F�b�N
            } else {
                // �×{�����^
                if (_1520149 == 2) {
                    // �ی��{�ݑޏ��O�K��w�����Z�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6501");

                    // �×{�����^�ȊO
                } else {
                    // �ی��{�ݑޏ��O�K��w�����Z�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6506");
                }
            }
        }

        // �ޏ���K��w�����Z
        if (_3020110 > 1) {

            // �×{�^�ȊO�̏ꍇ�́A�]���^/�ݑ���^���`�F�b�N
            if (!isRyoyoType(_1520101)) {
                // �ݑ���^
                if (_1520143 == 2) {
                    // �ی��{�ݑޏ���K��w�����Z�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6507");

                    // �ݑ���^�ȊO
                } else {
                    // �ی��{�ݑޏ���K��w�����Z�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6508");
                }

                // �×{�^�̏ꍇ�́A�×{�^/�×{�����^���`�F�b�N
            } else {
                // �×{�����^
                if (_1520149 == 2) {
                    // �ی��{�ݑޏ���K��w�����Z�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6507");

                    // �×{�����^�ȊO
                } else {
                    // �ی��{�ݑޏ���K��w�����Z�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6508");
                }
            }
        }

        // �ޏ����w�����Z
        if (_3020105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
        }

        // �ޏ������񋟉��Z
        if (_3020106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6504");
        }

        // �ޏ��O�A�g���Z
        if (_3020107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6505");
        }

        // �V�l�K��Ō�w�����Z
        if (_3020108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6503");
        }

        // �h�{�}�l�W�����g���Z
        if (_1520111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
        }

        // �o���ڍs���Z
        if (_1520112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6274");
        }

        // �o���ێ����Z
        if (_1520126 > 1) {
        	// �o���ێ����ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6280");
        }
        if (_1520151 > 1) {
        	// �ێ����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6281");
        }
        

        // ���o�@�\�ێ��Ǘ��̐����Z
        if (_1510145 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6122");
        }

        // ���o�@�\�ێ��Ǘ����Z
        if (_1520135 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }

        // �×{�H���Z
        if (_1520113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
        }

        // �ݑ�A�x���@�\���Z
        if (_1520148 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6279");
        }

        // �ً}�����ÊǗ����Z
        if (_1520109 > 1) {
            // �×{�^�ȊO
            if (!isRyoyoType(_1520101)) {
                // �ً}�����ÊǗ��P
                putSystemServiceCodeItem(sysSvcCdItems, "Z9000");

                // �×{�^
            } else {
                // �ً}�����ÊǗ��Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6000");
            }
        }

        // ���莾���{�ݗ×{��
        if (_1520145 > 1) {
            // �×{�^�ȊO
            if (!isRyoyoType(_1520101)) {
                // �ً}�����ÊǗ��P
                putSystemServiceCodeItem(sysSvcCdItems, "Z9100");

                // �×{�^
            } else {
                // �ً}�����ÊǗ��Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            }
        }

        // �F�m�ǐ��P�A���Z
        switch (_1520137) {
        case 2:
            // Z6133 �ی��{�ݔF�m�ǐ��P�A���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // Z6134 �ی��{�ݔF�m�ǐ��P�A���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }

        // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        if (_1520146 > 1) {
            // �×{�^�ȊO
            if (!isRyoyoType(_1520101)) {
                // �ی��{�ݔF�m�ǋً}�Ή����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6121");

                // �×{�^
            } else {
                // �ی��{�ݔF�m�ǋً}�Ή����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6004");
            }
        }

        // Z6135 �ی��{�ݔF�m�Ǐ��񋟉��Z
        if (_1520139 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6135");
        }

        // �n��A�g�f�Ìv����񋟉��Z
        if (_1520147 > 1) {

            // �×{�^�ȊO�̏ꍇ�́A�]���^/�ݑ���^���`�F�b�N
            if (!isRyoyoType(_1520101)) {
                // �ݑ���^
                if (_1520143 == 2) {
                    // �ی��{�ݒn��A�g�f�Ìv����Z�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6136");

                    // �ݑ���^�ȊO
                } else {
                    // �ی��{�ݒn��A�g�f�Ìv����Z�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6137");
                }

                // �×{�^�̏ꍇ�́A�×{�^/�×{�����^���`�F�b�N
            } else {
                // �×{�����^
                if (_1520149 == 2) {
                    // �ی��{�ݒn��A�g�f�Ìv����Z�P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6136");

                    // �×{�����^�ȊO
                } else {
                    // �ی��{�ݒn��A�g�f�Ìv����Z�Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6137");
                }
            }
        }

        switch (_1520142) {
        case 5:
            // Z6107 �ی��{�݃T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            // Z6101 �ی��{�݃T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // Z6102 �ی��{�݃T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // Z6103 �ی��{�݃T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // ���E���������P��ԋp
        switch (_17) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
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

        // ��������҃`�F�b�N�����Ă����ꍇ�͌��̒P�ʐ���ǉ�
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // �H����
            if (_1520120 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 2006/07/14 �×{�^�Ή�
            // �O�����Z�ł������ꍇ����������
            if (_1520107 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // �؍ݔ� --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }// �`�F�b�N�����Ă��Ȃ��ꍇ�͉����Ԃ��Ȃ�

        // �O�������肾�����ꍇ�͈ꗥ�O���̃R�[�h��Ԃ�
        if (_1520107 > 1) {
            // �O���������͎��s�I�ޏ����s���Ă���ꍇ�͏������������s��Ȃ�
            if ("1".equals(map.get("7")) || new Integer(1).equals(map.get("7"))) {
                // �����T�[�r�X�R�[�h��������
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // �O���ɂ�����T�[�r�X�R�[�h��ǉ�
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");

            // ���E���������P��ԋp
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
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

        return sysSvcCdItems;
    }

    public ArrayList<VRMap> getServiceCode(Map<String, String> map,
            ACDBManager dbm) {
        ArrayList<VRMap> al = super.getServiceCode(map, dbm);
        Map<String, Integer> mp = null;
        // ��������҃`�F�b�N�����ĂȂ������ꍇ�͐H����㏑�������ɕԂ�
        //[ID:0000749][Shin Fujihara] 2012/10 edit begin 2012�N�x�Ή� ��������҂̗����Ǘ��@�\
//        if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
//            // �H��͕K�v�Ȃ����߃f�[�^������
//            return al;
//        }
        if (ACCastUtilities.toInt(map.get("7"), 1) != 2) {
        	//�H��͕K�v�Ȃ����߃f�[�^������
        	return al;
        }
        //[ID:0000749][Shin Fujihara] 2012/10 edit end 2012�N�x�Ή� ��������҂̗����Ǘ��@�\

        // ���Ə����̎擾
        VRList temp = new VRArrayList();

        try {
            temp = QkanCommon.getProviderServiceDetail(dbm,
                    ACCastUtilities.toString(map.get("PROVIDER_ID")),
                    ACCastUtilities.toInt(getSystemServiceKindDetail(), 0));
        } catch (Exception e) {
            return al;
        }

        VRMap providerInfo = (VRMap) temp.get(0);

        for (int i = 0; i < al.size(); i++) {
            mp = (Map<String, Integer>) al.get(i);

            String val = ACCastUtilities.toString(
                    mp.get("SYSTEM_SERVICE_CODE_ITEM"), "");
            if (SERVICE_CODE_SHOKUHI.equals(val)) {
                // �H��̃��R�[�h
                if (this._1520122 <= 0) {
                    // �H�0�~�ȉ��̏ꍇ
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                } else {
                    // �H�0�~�ȉ��łȂ��ꍇ
                    // �H����Ɩ�����n���ꂽ�l�ŏ㏑������B
                    mp.put("SERVICE_UNIT", new Integer(this._1520122));
                }
            } else if (SERVICE_CODE_UNIT_ROOM.equals(val)) {
                // ���j�b�g�^���̃��R�[�h
                // ��p�P����0�ȉ��Őݒ肳��Ă���ꍇ�A�߂�l����폜
                // ���j�b�g�^���̔�p�P�����擾
                int unitRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_UNIT_ROOM), 0);
                if (unitRoom <= 0) {
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                }
            } else if (SERVICE_CODE_UNIT_SEMI_ROOM.equals(val)) {
                // ���j�b�g�^�����̃��R�[�h
                // ��p�P����0�ȉ��Őݒ肳��Ă���ꍇ�A�߂�l����폜
                // ���j�b�g�^�����̔�p�P�����擾
                int unitSemiRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_UNIT_SEMI_ROOM), 0);
                if (unitSemiRoom <= 0) {
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                }
            } else if (SERVICE_CODE_NORMAL_ROOM.equals(val)) {
                // �]���^���̃��R�[�h
                // ��p�P����0�ȉ��Őݒ肳��Ă���ꍇ�A�߂�l����폜
                // �]���^���̔�p�P�����擾
                int normalRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_NORMAL_ROOM), 0);
                if (normalRoom <= 0) {
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                }
            } else if (SERVICE_CODE_TASHO_ROOM.equals(val)) {
                // �������̃��R�[�h
                // ��p�P����0�ȉ��Őݒ肳��Ă���ꍇ�A�߂�l����폜
                // �������̔�p�P�����擾
                int tashoRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_TASHO_ROOM), 0);
                if (tashoRoom <= 0) {
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                }
            }
        }

        return al;
    }
}
