package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRMap;

/**
 * ���\�h�����p��ݗ^
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_16711_201204 extends Qkan10011_ServiceUnitGetter {
    private int _1670102 = 0; // ��{���̒P�ʐ�
    private int tokuchiKasan = 0; // ���Z���̒P�ʐ�
    private int chusankanJigyosyoKasan = 0; // ���Z���̒P�ʐ�
    private int chusankanServiceKasan = 0; // ���Z���̒P�ʐ�
    private boolean isTokuchi = false; // ���͍��ڂ���肷��t���O
    private boolean isChusankan = false; // ���͍��ڂ���肷��t���O
    private boolean isChusankanService = false; // ���͍��ڂ���肷��t���O

    public String getServiceName() {
        return "���\�h�����p��ݗ^";
    }

    public String getServiceCodeKind() {
        return "67";
    }

    public String getSystemServiceKindDetail() {
        return "16711";
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
        case 2: // �o�ߓI�v���
        case 5: // �v���P
        case 6: // �v���Q
        case 7: // �v���R
        case 8: // �v���S
        case 9: // �v���T
            return new ArrayList<HashMap<String, String>>();
        }

        // 1670101 �p��
        int _1670101 = getIntValue(map, "1670101");

        // 1670102 �P�ʐ�
        this._1670102 = getIntValue(map, "1670102", 0);

        // 1670103 ���n���Z
        int _1670103 = getIntValue(map, "1670103", 0);

        // 1670104 ���R�Ԓn�擙���K�͎��Ə����Z
        int _1670104 = getIntValue(map, "1670104", 0);

        // 1670105 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _1670105 = getIntValue(map, "1670105", 0);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // �����p��ݗ^��
        sb.append(CODE_CHAR[1]);

        // �p��
        sb.append(CODE_CHAR[_1670101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================

        if (_1670103 > 0) {
            sb = new StringBuilder();
            // ���n���Z
            sb.append(CODE_CHAR[2]);
            // �p��
            sb.append(CODE_CHAR[_1670101]);
            this.tokuchiKasan = _1670103; // ���Z���̒P�ʐ��ޔ�
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString()); // ���X�g�ɒǉ�
            // �t���O�ޔ�
            this.isTokuchi = true;
        }

        if (_1670104 > 0) {
            // ���R�Ԓn�擙���K�͎��Ə����Z
            sb = new StringBuilder();
            sb.append(CODE_CHAR[3]);
            // �p��
            sb.append(CODE_CHAR[_1670101]);
            // ���Z���̒P�ʐ��ޔ�
            this.chusankanJigyosyoKasan = _1670104;
            // ���X�g�ɒǉ�
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
            // �t���O�ޔ�
            this.isChusankan = true;
        }

        if (_1670105 > 0) {
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
            sb = new StringBuilder();
            sb.append(CODE_CHAR[4]);
            // �p��
            sb.append(CODE_CHAR[_1670101]);
            // ���Z���̒P�ʐ��ޔ�
            this.chusankanServiceKasan = _1670105;
            // ���X�g�ɒǉ�
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
            // �t���O�ޔ�
            this.isChusankanService = true;
        }

        return sysSvcCdItems;
    }

    public ArrayList<VRMap> getServiceCode(Map<String, String> map,
            ACDBManager dbm) {
        ArrayList<VRMap> al = super.getServiceCode(map, dbm);
        Map<String, Integer> mp = null;
        int addCount = 0;
        // ���T�[�r�X�R�[�h�̐����̓s����A���Ԃ������Ɉێ�����_�ɒ���

        switch (al.size()) {
        case 1: // �{�̕���1�R�[�h�̂�
            mp = (Map<String, Integer>) al.get(addCount);
            mp.put("SERVICE_UNIT", new Integer(this._1670102));
            break;

        case 2: // �{�́{���Z�̌v2�R�[�h
            mp = (Map<String, Integer>) al.get(addCount);
            mp.put("SERVICE_UNIT", new Integer(this._1670102));
            addCount++;
            // ���ʒn��
            if (isTokuchi && (addCount < 2)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.tokuchiKasan));
                addCount++;
            }
            // ���R�Ԓn�擙���K�͎��Ə�
            if (isChusankan && (addCount < 2)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanJigyosyoKasan));
                addCount++;
            }
            // ���R�Ԓn�擙�ɂ�����T�[�r�X��
            if (isChusankanService && (addCount < 2)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanServiceKasan));
                addCount++;
            }
            break;
        case 3:
            mp = (Map<String, Integer>) al.get(addCount);
            mp.put("SERVICE_UNIT", new Integer(this._1670102));
            addCount++;
            // ���ʒn��
            if (isTokuchi && (addCount < 3)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.tokuchiKasan));
                addCount++;
            }
            // ���R�Ԓn�擙���K�͎��Ə�
            if (isChusankan && (addCount < 3)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanJigyosyoKasan));
                addCount++;
            }
            // ���R�Ԓn�擙�ɂ�����T�[�r�X��
            if (isChusankanService && (addCount < 3)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanServiceKasan));
                addCount++;
            }
            break;
        case 4:
            mp = (Map<String, Integer>) al.get(addCount);
            mp.put("SERVICE_UNIT", new Integer(this._1670102));
            addCount++;
            // ���ʒn��
            if (isTokuchi && (addCount < 4)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.tokuchiKasan));
                addCount++;
            }
            // ���R�Ԓn�擙���K�͎��Ə�
            if (isChusankan && (addCount < 4)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanJigyosyoKasan));
                addCount++;
            }
            // ���R�Ԓn�擙�ɂ�����T�[�r�X��
            if (isChusankanService && (addCount < 4)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanServiceKasan));
                addCount++;
            }
            break;
        }

        return al;
    }

}
