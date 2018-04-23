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
 * �Z�������×{���(����É@)
 * 
 * @since V8.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_204211_201804 extends Qkan10011_ServiceUnitGetter {
    private int shokuhi = 0;

    private final String PATH_UNIT_ROOM = "20420120";
    private final String PATH_UNIT_SEMI_ROOM = "20420121";
    private final String PATH_NORMAL_ROOM = "20420122";
    private final String PATH_TASHO_ROOM = "20420123";

    public String getServiceName() {
        return "�Z�������×{���(����É@)";
    }

    public String getServiceCodeKind() {
        return "2A";
    }

    public String getSystemServiceKindDetail() {
        return "204211";
    }

    private boolean isHigaeriShort(int shisetsu) {
        return shisetsu == 7;
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        
        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        
        // 20420101 �{�݋敪
        int _20420101 = getIntValue(map, "20420101");

        // 20420102 �l���z�u�敪�iI�^�j
        int _20420102 = getIntValue(map, "20420102");
        
        // 20420103 �l���z�u�敪�iII�^�j
        int _20420103 = getIntValue(map, "20420103");
        
        // 20420104	�l���z�u�敪�i���ʌ^�j
        int _20420104 = getIntValue(map, "20420104");
        
        // 20420105 �a���敪(�]���^)
        int _20420105 = getIntValue(map, "20420105");

        // 20420106 �a���敪(���j�b�g�^)
        int _20420106 = getIntValue(map, "20420106");

        // �a���敪
        int byoshitsu = 1;
        switch (_20420101) {
        case 1: // I�^
        case 2: // II�^
        case 3: // ���ʌ^
            byoshitsu = convertByoshitsuKbn(_20420105, false);
            break;
        case 4: // ���j�b�g�^I�^
        case 5: // ���j�b�g�^II�^
        case 6: // ���j�b�g�^���ʌ^
            byoshitsu = convertByoshitsuKbn(_20420106, true);
            break;
        case 7: // ���A��V���[�g�X�e�C
            byoshitsu = getIntValue(map, "20420107");
            break;
        }

        // 20420108 ���ԋ敪
        int _20420108 = getIntValue(map, "20420108");
        
        // 20420109 ���j�b�g�P�A�̐���
        int _20420109 = getIntValue(map, "20420109");

        // 20420110 ��ԋΖ����Ō���Z
        int _20420110 = getIntValue(map, "20420110");

        // 20420111 �×{�����Z�i�L���j
        int _20420111 = getIntValue(map, "20420111");
        
        // 20420112 �×{�����Z�i�×{���j
        int _20420112 = getIntValue(map, "20420112");
        
        // 20420113 ��ԋΖ������
        int _20420113 = getIntValue(map, "20420113");
        
        // 20420114 �l�����Z
        int _20420114 = getIntValue(map, "20420114");

        // 20420115 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _20420115 = getIntValue(map, "20420115", 1);

        // 20420116 �ً}�Z������������Z
        int _20420116 = getIntValue(map, "20420116", 1);

        // 20420117 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _20420117 = getIntValue(map, "20420117", 1);

        // 6 ���}���Z
        int _6 = getIntValue(map, "6");

        // 20420118 �×{�H���Z
        int _20420118 = getIntValue(map, "20420118");

        // 20420119 �ً}�����ÊǗ�
        int _20420119 = getIntValue(map, "20420119");

        // 20420120 �F�m�ǐ��P�A���Z
        int _20420120 = getIntValue(map, "20420120");

        // 20420121 �d�x�F�m�ǎ����×{�̐����Z
        int _20420121 = getIntValue(map, "20420121");

        // 20420122 �T�[�r�X�񋟑̐��������Z
        int _20420122 = getIntValue(map, "20420122", 1);

        // 20420123 �H����
        int _20420123 = getIntValue(map, "20420123");

        // 20420124 �H��
        this.shokuhi = getIntValue(map, "20420124");

        // 20420107 ���A��V���[�g�p�a���敪
        int _20420107 = getIntValue(map, "20420107");
        
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_20420101]);

        // �l���z�u�敪�iI�^�j
        if (_20420101 == 1 || _20420101 == 4 || _20420101 == 5) {
        	 sb.append(CODE_CHAR[_20420102]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �l���z�u�敪(II�^)
        if (_20420101 == 2) {
        	sb.append(CODE_CHAR[_20420103]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �l���z�u�敪(���ʌ^)
        if (_20420101 == 3 || _20420101 == 6) {
        	sb.append(CODE_CHAR[_20420104]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �]���^��/������
        sb.append(CODE_CHAR[_20420105]);
        
        // ���j�b�g�^��/���j�b�g�^���I������
        sb.append(CODE_CHAR[_20420106]);
        
        // �v���x
        if (isHigaeriShort(_20420101)) {
            // ���A��V���[�g�̏ꍇ�A�v���x�͗��܂Ȃ�
            sb.append(DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }

        // ���ԋ敪
        sb.append(CODE_CHAR[_20420108]);

        // ��ԋΖ������
        sb.append(CODE_CHAR[_20420113]);
        
        // �l�����Z
        sb.append(CODE_CHAR[_20420114]);
        
        // ���j�b�g�P�A�̐���
        switch (_20420101) {
        case 1: // I�^
        case 2: // II�^
        case 3: // ���ʌ^
        case 7: // ���A��V���[�g�X�e�C
            sb.append(DEFAULT_CHAR);
            break;
            
        //���j�b�g�^
        case 4: // ���j�b�g�^I�^
        case 5: // ���j�b�g�^II�^
        case 6: // ���j�b�g�^���ʌ^
            // �l�𔽓]������
            // �������Ă���ꍇ
            if (_20420109 > 1)  {
                sb.append(DEFAULT_CHAR);
            // �������̏ꍇ
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }


        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
        

        // ���Z
        // ============================================================================
        
        // ��ԋΖ����Ō���Z
        switch (_20420110) {
        case 2:
            // ��ԋΖ����Ō���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6371");
            break;
        case 3:
            // ��ԋΖ����Ō���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6372");
            break;
        case 4:
            // ��ԋΖ����Ō���ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6373");
            break;
        case 5:
        	// ��ԋΖ����Ō���ZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6374");
            break;
        }
        
        
        // �×{�����Z�i�L���j
        if (_20420111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6601");
        }
        
        // �×{�����Z�i�×{���j
        if (_20420112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6603");
        }

        // �F�m�ǋً}�Ή����Z
        if (_20420115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // �ً}�Z������������Z
        if (_20420116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
        }
        
        // ��N���F�m�ǎ�����Z
        if (_20420117 > 1) {
            // ���A��V���[�g�̏ꍇ
            if (isHigaeriShort(_20420101)) {
                // ��N���F�m�ǎ�����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
            } else {
                // ��N���F�m�ǎ�����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
            }
        }
        
        // ���}���Z
        switch (_6) {
        case 3: // ����
            putSystemServiceCodeItem(sysSvcCdItems, "Z69202");
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z69201");
            break;
        }
        
        // �×{�H���Z
        switch (_20420118) {
        case 2:
            // �R��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        case 3:
            // �Q��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        case 4:
            // �P��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        }
        
        // �ً}�����ÊǗ�
        if (_20420119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6000");
        }

        // �F�m�ǐ��P�A���Z
        switch (_20420120) {
        case 2:
            // �F�m�ǐ��P�A���ZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // �F�m�ǐ��P�A���ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }
        
        // �d�x�F�m�ǎ����×{�̐����Z
        switch (_20420121) {
        case 2:
        	if (_1 == 5 || _1 == 6) { // �v���1,2
	            // �d�x�F�m�ǎ����×{�̐����ZI�P
	            putSystemServiceCodeItem(sysSvcCdItems, "Z6351");
        	} else if (_1 == 7 || _1 == 8 || _1 == 9) { // �v���3,4,5
	            // �d�x�F�m�ǎ����×{�̐����ZI�Q
	            putSystemServiceCodeItem(sysSvcCdItems, "Z6352");
        	}
            break;
        case 3:
        	if (_1 == 5 || _1 == 6) { // �v���1,2
	            // �d�x�F�m�ǎ����×{�̐����ZII�P
	            putSystemServiceCodeItem(sysSvcCdItems, "Z6353");
        	} else if (_1 == 7 || _1 == 8 || _1 == 9) { // �v���3,4,5
	            // �d�x�F�m�ǎ����×{�̐����ZII�Q
	            putSystemServiceCodeItem(sysSvcCdItems, "Z6354");
        	}
            break;
        }
        
        // �T�[�r�X�񋟑̐����Z
        switch (_20420122) {
        case 5:
        	// �T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            break;
        case 2:
        	// �T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
        	// �T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
        	// �T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        
        // ���E���������P��ԋp
        switch(_17){
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            break;
        }

        // ��������҃`�F�b�N�����Ă����ꍇ�͌��̒P�ʐ���ǉ�
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // �H����
            if (_20420123 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // �؍ݔ� --------
            if (isHigaeriShort(_20420101)) {
                // ���A��V���[�g�������ꍇ
                // ���A��V���[�g��p�a���敪
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(_20420107));
            } else {
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(byoshitsu));
            }

        }// �`�F�b�N�����Ă��Ȃ��ꍇ�͉����Ԃ��Ȃ�

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
                if (this.shokuhi <= 0) {
                    // �H�0�~�ȉ��̏ꍇ
                    // �Y�����R�[�h���폜����B
                    al.remove(i);
                    // �폜�������߃C���f�b�N�X��1�߂��B
                    i--;
                } else {
                    // �H�0�~�ȉ��łȂ��ꍇ
                    // �H����Ɩ�����n���ꂽ�l�ŏ㏑������B
                    mp.put("SERVICE_UNIT", new Integer(this.shokuhi));
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
