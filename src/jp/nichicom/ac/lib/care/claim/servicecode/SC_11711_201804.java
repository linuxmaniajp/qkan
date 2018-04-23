package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRMap;

/**
 * �����p��ݗ^
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_11711_201804 extends Qkan10011_ServiceUnitGetter {
    private int baseUnit = 0; // ��{���̒P�ʐ�
    private int tokuchiKasan = 0; // ���Z���̒P�ʐ�
    private int chusankanJigyosyoKasan = 0; // ���Z���̒P�ʐ�
    private int chusankanServiceKasan = 0; // ���Z���̒P�ʐ�
    private boolean isTokuchi = false; // ���͍��ڂ���肷��t���O
    private boolean isChusankan = false; // ���͍��ڂ���肷��t���O
    private boolean isChusankanService = false; // ���͍��ڂ���肷��t���O
    

    public String getServiceName() {
        return "�����p��ݗ^";
    }

    public String getServiceCodeKind() {
        return "17";
    }

    public String getSystemServiceKindDetail() {
        return "11711 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // �p�����[�^���o
        // =========================================================================
        
        // 1 �v���x
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        // ���炩�ɗv���x�����������ꍇ�͋��Ԃ�
        switch(_1){
        case 1: // ����
        case 3: // �v�x���P
        case 4: // �v�x���Q
        case 10: // ���ƑΏێ�
            return new ArrayList<HashMap<String, String>>();
        }
        
        // 1170103 ���n���Z
        int _1170103 = getIntValue(map, "1170103", 0);

        // 1170101 �p��
        int _1170101 = getIntValue(map, "1170101");
        
        // 1170105 ���R�Ԓn�擙���K�͎��Ə����Z
        int _1170105 = getIntValue(map, "1170105", 0);
        
        // 1170106 ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
        int _1170106 = getIntValue(map, "1170106", 0);

        // 1170102 �P�ʐ�
        this.baseUnit = getIntValue(map, "1170102", 0);

        // �Ǝ��R�[�h����
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // ���n���Z
        sb.append(CODE_CHAR[1]);

        // �p��
        sb.append(CODE_CHAR[_1170101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ���Z
        // ============================================================================
        if (_1170103 > 0) {
            // ���n���Z
            sb = new StringBuilder();
            sb.append(CODE_CHAR[2]);
            // �p��
            sb.append(CODE_CHAR[_1170101]);
            this.tokuchiKasan = _1170103; // ���Z���̒P�ʐ��ޔ�
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString()); // ���X�g�ɒǉ�
            // �t���O�ޔ�
            this.isTokuchi = true;
        }
        
        if (_1170105 > 0) {
            // ���R�Ԓn�擙���K�͎��Ə����Z
            sb = new StringBuilder();
            sb.append(CODE_CHAR[3]);
            // �p��
            sb.append(CODE_CHAR[_1170101]);
            // ���Z���̒P�ʐ��ޔ�
            this.chusankanJigyosyoKasan = _1170105;
            // ���X�g�ɒǉ�
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
            // �t���O�ޔ�
            this.isChusankan = true;
        }
        
        if (_1170106 > 0) {
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
            sb = new StringBuilder();
            sb.append(CODE_CHAR[4]);
            // �p��
            sb.append(CODE_CHAR[_1170101]);
            // ���Z���̒P�ʐ��ޔ�
            this.chusankanServiceKasan = _1170106;
            // ���X�g�ɒǉ�
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
            // �t���O�ޔ�
            this.isChusankanService = true;
        }

        return sysSvcCdItems;
    }


    public ArrayList<VRMap> getServiceCode(Map<String, String> map, ACDBManager dbm) {
        ArrayList<VRMap> al = super.getServiceCode(map, dbm);
        Map<String, Integer> mp = null;
        int addCount = 0;
        // ���T�[�r�X�R�[�h�̐����̓s����A���Ԃ������Ɉێ�����_�ɒ��� 
        
        switch (al.size()) {
        case 1: // �{�̕���1�R�[�h�̂�
            mp = (Map<String, Integer>) al.get(addCount);
            mp.put("SERVICE_UNIT", new Integer(this.baseUnit));
            break;

        case 2: // �{�́{���Z�̌v2�R�[�h
            mp = (Map<String, Integer>) al.get(addCount);
            mp.put("SERVICE_UNIT", new Integer(this.baseUnit));
            addCount++;
            // ���ʒn��
            if(isTokuchi && (addCount < 2)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.tokuchiKasan));
                addCount++;                
            }
            // ���R�Ԓn�擙���K�͎��Ə�
            if(isChusankan && (addCount < 2)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanJigyosyoKasan));
                addCount++;                
            }
            // ���R�Ԓn�擙�ɂ�����T�[�r�X��
            if(isChusankanService && (addCount < 2)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanServiceKasan));
                addCount++;                
            }
            break;
        case 3:
            mp = (Map<String, Integer>) al.get(addCount);
            mp.put("SERVICE_UNIT", new Integer(this.baseUnit));
            addCount++;
            // ���ʒn��
            if(isTokuchi && (addCount < 3)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.tokuchiKasan));
                addCount++;                
            }
            // ���R�Ԓn�擙���K�͎��Ə�
            if(isChusankan && (addCount < 3)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanJigyosyoKasan));
                addCount++;                
            }
            // ���R�Ԓn�擙�ɂ�����T�[�r�X��
            if(isChusankanService && (addCount < 3)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanServiceKasan));
                addCount++;                
            }
            break;
        case 4:
            mp = (Map<String, Integer>) al.get(addCount);
            mp.put("SERVICE_UNIT", new Integer(this.baseUnit));
            addCount++;
            // ���ʒn��
            if(isTokuchi && (addCount < 4)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.tokuchiKasan));
                addCount++;                
            }
            // ���R�Ԓn�擙���K�͎��Ə�
            if(isChusankan && (addCount < 4)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanJigyosyoKasan));
                addCount++;                
            }
            // ���R�Ԓn�擙�ɂ�����T�[�r�X��
            if(isChusankanService && (addCount < 4)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanServiceKasan));
                addCount++;                
            }
            break;
        }

        return al;
    }

}
