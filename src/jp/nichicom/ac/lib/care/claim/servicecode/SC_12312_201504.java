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
 * �Z�������×{���(�×{�a����L����f�Ï�)
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12312_201504 extends Qkan10011_ServiceUnitGetter {
    private int shokuhi = 0;

    private final String PATH_UNIT_ROOM = "1230212";
    private final String PATH_UNIT_SEMI_ROOM = "1230213";
    private final String PATH_NORMAL_ROOM = "1230214";
    private final String PATH_TASHO_ROOM = "1230215";

    public String getServiceName() {
        return "�Z�������×{���(�×{�a����L����f�Ï�)";
    }

    public String getServiceCodeKind() {
        return "23";
    }

    public String getSystemServiceKindDetail() {
        return "12312";
    }

    private boolean isHigaeriShort(int shisetsu) {
        return shisetsu == 3;
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================

        // 1230201 �{�݋敪
        int _1230201 = getIntValue(map, "1230201");

        // 1230202 �l���z�u�敪
        int _1230202 = getIntValue(map, "1230202");

        // 1230214	�l���z�u�敪�i���j�b�g�^�f�Ï��^�p�j
        int _1230214 = getIntValue(map, "1230214");
        
        // 1230203 �a���敪(�]���^)
        int _1230203 = getIntValue(map, "1230203");

        // 1230204 �a���敪(���j�b�g�^)
        int _1230204 = getIntValue(map, "1230204");

        // �a���敪
        int byoshitsu = 1;
        switch (_1230201) {
        case 1:
            byoshitsu = convertByoshitsuKbn(_1230203, false);
            break;
        case 2:
            byoshitsu = convertByoshitsuKbn(_1230204, true);
            break;
        }

        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1230209 �l�����Z
        int _1230209 = getIntValue(map, "1230209");

        // 1230210 ���j�b�g�P�A�̐���
        int _1230210 = getIntValue(map, "1230210");

        // 1230254 �×{�����Z
        int _1230254 = getIntValue(map, "1230254");

        // 6 ���}���Z
        int _6 = getIntValue(map, "6");

        // 1230208 �×{�H���Z
        int _1230208 = getIntValue(map, "1230208");

        // 1230249 �H����
        int _1230249 = getIntValue(map, "1230249");

        // 1230251 �H��
        this.shokuhi = getIntValue(map, "1230251");

        // 1230212 ���A��V���[�g�p�a���敪
        int _1230212 = getIntValue(map, "1230212");

        // 1230252 �ݔ�����Z
        int _1230252 = getIntValue(map, "1230252");

        // 1230255 ���ԋ敪
        int _1230255 = getIntValue(map, "1230255", 1);

        // 1230256 �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
        int _1230256 = getIntValue(map, "1230256", 1);

        // 1230257 ��N���F�m�Ǘ��p�Ҏ�����Z
        int _1230257 = getIntValue(map, "1230257", 1);

        // 1230253 �T�[�r�X�񋟑̐��������Z
        int _1230253 = getIntValue(map, "1230253", 1);

        // 1230213 �ً}�Z������������Z
        int _1230213 = getIntValue(map, "1230213", 1);
        
        // 17 ���E���������P���Z
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �{�݋敪
        sb.append(CODE_CHAR[_1230201]);
        
        // �l���z�u�敪�P
        if (_1230201 == 1) {
        	 sb.append(CODE_CHAR[_1230202]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �l���z�u�敪�Q
        if (_1230201 == 2) {
        	sb.append(CODE_CHAR[_1230214]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // �]���^��/������
        sb.append(CODE_CHAR[_1230203]);
        // ���j�b�g�^��/���j�b�g�^����
        sb.append(CODE_CHAR[_1230204]);

        // ���ԋ敪
        sb.append(CODE_CHAR[_1230255]);
        
        // �v���x
        if (isHigaeriShort(_1230201)) {
            // ���A��V���[�g�̏ꍇ�A�v���x�͗��܂Ȃ�
            sb.append(DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }

        // �l�����Z
        sb.append(CODE_CHAR[_1230209]);

        // ���j�b�g�P�A�̐���
        switch (_1230201) {
        //�f�Ï��A���A��V���[�g
        case 1:
        case 3:
            sb.append(DEFAULT_CHAR);
            break;
            
        //���j�b�g�^
        case 2:
            // �l�𔽓]������
            // �������Ă���ꍇ
            if (_1230210 > 1)  {
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
        // �ݔ�����Z
        switch (_1230252) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3600");
            break;
        }
        // �×{�����Z
        switch (_1230254) {
        // �×{�����Z�̇T�^�͔p�~����U�^�̂ݐ����\�Ƃ���
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3602");
            break;
        }
        
        // 3706 �f�Ï��Z���F�m�ǋً}�Ή����Z
        if (_1230256 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3706");
        }
        
        // �ً}�Z������������Z
        if (_1230213 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3751");
        }
        
        if (_1230257 > 1) {
            if (isHigaeriShort(_1230201)) {
                // 3705 �f�Ï��Z����N���F�m�ǎ�����Z�Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z3705");
            } else {
                // 3704 �f�Ï��Z����N���F�m�ǎ�����Z�P
                putSystemServiceCodeItem(sysSvcCdItems, "Z3704");
            }
        }
        
        // ���}���Z
        switch (_6) {
        case 3: // ����
            putSystemServiceCodeItem(sysSvcCdItems, "Z39202");
        case 2: // �Г�
            putSystemServiceCodeItem(sysSvcCdItems, "Z39201");
            break;
        }
        
        // �×{�H���Z
        if (_1230208 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
        }
        
        // �f�Ï��Z���T�[�r�X�񋟑̐����Z
        switch (_1230253) {
        case 5:
            // 3707 �f�Ï��Z���T�[�r�X�񋟑̐����ZI�C
            putSystemServiceCodeItem(sysSvcCdItems, "Z3700");
            break;
        case 2:
            // 3701 �f�Ï��Z���T�[�r�X�񋟑̐����ZI��
            putSystemServiceCodeItem(sysSvcCdItems, "Z3701");
            break;
        case 3:
            // 3702 �f�Ï��Z���T�[�r�X�񋟑̐����ZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z3702");
            break;
        case 4:
            // 3703 �f�Ï��Z���T�[�r�X�񋟑̐����ZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z3703");
            break;
        }
        
        // ���E���������P��ԋp
        switch(_17){
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3709");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3710");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3711");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3712");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3713");
            break;
        }

        // ��������҃`�F�b�N�����Ă����ꍇ�͌��̒P�ʐ���ǉ�
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // �H����
            if (_1230249 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // �؍ݔ� --------
            if (isHigaeriShort(_1230201)) {
                // ���A��V���[�g�������ꍇ
                // ���A��V���[�g��p�a���敪
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(_1230212));
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
