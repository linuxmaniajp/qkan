package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.bridge.sql.BridgeFirebirdDBManager;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * ����f�Ô�̍��Z�P�ʐ������߂�
 * <p>
 * Copyright (c) 2012 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Shin Fujihara
 * @version 1.0 2012/02/01
 */
public class CareServicePrecomputed {
    
    
    private ACDBManager db;
    
    private Map<String, String> ryoyoMap = null;
    private Map<String, String> shinryoMap = null;
    // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/13 add - begin
    private Map<String, String> tokubetuShinryoMap = null;
    // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/13 add - end
    private Map<String, Integer> clinicUnit = null;
    // [ID:0000415][Masahiko.Higuchi] add - begin ��������҂̗����Ǘ��@�\
    private Map<String, String> clinicName = null;
    private Map<String, Map> diagnosisDateMap = null;
    // [ID:0000415][Masahiko.Higuchi] add - end


	/**
     * �S�T�[�r�X�𑖍����A���O�v�Z���s���B<br/>
     * ���O�v�Z���s�����ڂ́A���p�ҕ��S�z�A����f�Ô�E���ʗ×{��E���ʐf�Ô�<br/>
     * ���p�ҕ��S�z�́A��O������Map��[���Ə��ԍ�]-[�V�X�e�����T�[�r�X��ރR�[�h]���L�[��Integer�^�Őݒ�<br/>
     * ����f�Ô�E���ʗ×{��E���ʐf�Ô�́A��l������Map��[���Ə��ԍ�]-[�V�X�e�����T�[�r�X��ރR�[�h]���L�[��Integer�^�Őݒ�<br/>
     * @param db ACDBManager
     * @param serviceList ��͑Ώۂ̃T�[�r�Xmap���܂�list
     * @param regulationMap ���p�ҕ��S�z��ݒ肷��Map
     * @param diagnosisMap ����f�Ô�E���ʗ×{��E���ʐf�Ô��ݒ肷��Map
     * @throws Exception
     */
    public void setPrecomputedResult(ACDBManager db, List serviceList,
            Map<String, Integer> regulationMap, Map<String, Integer> diagnosisMap) throws Exception {
        
        this.db = db;
        
        VRMap row = null;
        
        // [ID:0000415][Masahiko.Higuchi] add - begin ��������҂̗����Ǘ��@�\
        VRArrayList clinicDateList = new VRArrayList();
        Map clinicMap = new VRHashMap();
        diagnosisDateMap = new VRHashMap();
        // [ID:0000415][Masahiko.Higuchi] add - end
        
        Map<String, String> codeMap = null;
        Set<String> ryoyo = createRyoyoSet();
        Set<String> shinryo = createShinryoSet();
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/13 add - begin
        Set<String> tokubetuShinryo = createTokubetuShinryoSet();
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/13 add - end
        
        String systemServiceKindDetail;
        int count = serviceList.size();
        
        for (int i = 0; i < count; i++) {
            row = (VRMap)serviceList.get(i);
            
            //�O���Ȃ�X�L�b�v
            if (CareServiceCommon.isGaihaku(row) == 2){
                continue;
            }
            //30�����ł���΃X�L�b�v
            if(ACCastUtilities.toInt(row.get("5"),0) == 2){
                continue;
            }
            
            
            //�T�[�r�X��ނ��擾
            systemServiceKindDetail = ACCastUtilities.toString(row.get("SYSTEM_SERVICE_KIND_DETAIL"));
            //Map�Ɋi�[����L�[���쐬
            String key = ACCastUtilities.toString(row.get("PROVIDER_ID")) + "-" + systemServiceKindDetail;
            
            //���ȕ��S�z�m�F
            if (row.containsKey("REGULATION_RATE")) {
                int selfpay = ACCastUtilities.toInt(row.get("REGULATION_RATE"), 0);
                
                if (0 < selfpay) {
                    if (regulationMap.containsKey(key)) {
                        regulationMap.put(key, new Integer(regulationMap.get(key).intValue() + selfpay));
                    } else {
                        regulationMap.put(key, new Integer(selfpay));
                    }
                }
            }
            
            
            
            //���ʗ×{��
            if (ryoyo.contains(systemServiceKindDetail)) {
                codeMap = getRyoyoMap();
                
            //����f�Ô�
            } else if (shinryo.contains(systemServiceKindDetail)) {
                codeMap = getShinryoMap();
            // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/13 add - begin
            } else if (tokubetuShinryo.contains(systemServiceKindDetail)) {
                codeMap = getTokubetuShinryoMap();
            // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/13 add - end
                
            //�ΏۊO
            } else {
                continue;
            }
            
            int unit = getTotalUnit(row, codeMap);
            if (unit == 0) {
                continue;
            }
            
            // [ID:0000415][Masahiko.Higuchi] add - begin ��������҂̗����Ǘ��@�\
            Map<String, Map> nameResult = getTotalName(row, codeMap);
            ArrayList<Map> clinicDateAll = new ArrayList<Map>();
            
            if(diagnosisDateMap.containsKey(key)) {
            	clinicMap = diagnosisDateMap.get(key);
            } else {
            	clinicMap = new VRHashMap();
            }
            
            // ���O���L�[�Ƃ��ē��t�����
            for(Entry<String, Map> nameEntry : nameResult.entrySet()) {

            	if(clinicMap.containsKey(nameEntry.getKey())) {
            		// ����
            		clinicDateAll = (ArrayList<Map>)clinicMap.get(nameEntry.getKey());
            		clinicDateAll.add(nameEntry.getValue());
            		clinicMap.put(nameEntry.getKey(), clinicDateAll);
            	} else {
            		// �V�K
            		clinicDateAll = new ArrayList<Map>();
            		clinicDateAll.add(nameEntry.getValue());
            		clinicMap.put(nameEntry.getKey(), clinicDateAll);
            	}
            	
            }
            
            diagnosisDateMap.put(key, clinicMap);
            // [ID:0000415][Masahiko.Higuchi] add - end            
            
            if (diagnosisMap.containsKey(key)) {
                diagnosisMap.put(key, new Integer(diagnosisMap.get(key).intValue() + unit));
            } else {
                diagnosisMap.put(key, new Integer(unit));
            }
            
        }
        
    }
    
    
    // �ݒ肳��Ă������f�Ô�E���ʗ×{��̍��Z���擾
    private int getTotalUnit(VRMap row, Map<String, String> codeMap) throws Exception {
        
        int unit = 0;
        
        for (Entry<String, String> code : codeMap.entrySet()) {
            
            if (!row.containsKey(code.getKey())){
                continue;
            }
            
            unit += getUnit(row, code.getValue(), ACCastUtilities.toInt(row.get(code.getKey()), 0));
            
        }
        
        return unit;
    }
    
    
    // �ݒ肳��Ă������f�Ô�E���ʗ×{��̍��Z���擾
    private int getUnit(VRMap row, String code, int count) throws Exception {

        if (count == 0) {
            return 0;
        }
        
        if (clinicUnit == null) {
            clinicUnit = getClinicUnit(row);
        }
        
        
        if (!clinicUnit.containsKey(code)) {
            return 0;
        }
        
        return clinicUnit.get(code).intValue() * count;
    }
    
    
    // �f�[�^�x�[�X����A����f�Ô�E���ʗ×{��̒P�ʐ��P�����擾
    private Map<String, Integer> getClinicUnit(Map row) throws Exception {
        
        
        Date targetDate = ACCastUtilities.toDate(row.get("SERVICE_DATE"));
        Date targetDateStart = ACDateUtilities.toFirstDayOfMonth(targetDate);
        Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(targetDate);
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT");
        sql.append(" SPECIAL_CLINIC_TYPE || '-' || RECORD_TYPE AS CODE,");
        sql.append(" SPECIAL_CLINIC_UNIT");
        sql.append(" FROM");
        sql.append(" M_SPECIAL_CLINIC");
        sql.append(" WHERE");
        sql.append(" (SPECIAL_CLINIC_VALID_START <= '");
        sql.append(VRDateParser.format(targetDateEnd,"yyyy/MM/dd"));
        sql.append("') AND (SPECIAL_CLINIC_VALID_END >= '");
        sql.append(VRDateParser.format(targetDateStart,"yyyy/MM/dd"));
        sql.append("')");
        
        List list = db.executeQuery(sql.toString());
        Map<String, Integer> result = new HashMap<String, Integer>();
        
        for (int i = 0; i < list.size(); i++) {
            Map m = (Map)list.get(i);
            result.put(ACCastUtilities.toString(m.get("CODE")), ACCastUtilities.toInteger(m.get("SPECIAL_CLINIC_UNIT")));
        }
        
        
        return result;
    }
    
    /**
     * ����f�Ô�E���ʗ×{��̖��O���擾���܂��B
     * @param row
     * @return
     * @throws Exception
     * @since V6.1.2
     */
    private Map<String, String> getClinicName(Map row) throws Exception {
        
        
        Date targetDate = ACCastUtilities.toDate(row.get("SERVICE_DATE"));
        Date targetDateStart = ACDateUtilities.toFirstDayOfMonth(targetDate);
        Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(targetDate);
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT");
        sql.append(" SPECIAL_CLINIC_TYPE || '-' || RECORD_TYPE AS CODE,");
        sql.append(" SPECIAL_CLINIC_NAME");
        sql.append(" FROM");
        sql.append(" M_SPECIAL_CLINIC");
        sql.append(" WHERE");
        sql.append(" (SPECIAL_CLINIC_VALID_START <= '");
        sql.append(VRDateParser.format(targetDateEnd,"yyyy/MM/dd"));
        sql.append("') AND (SPECIAL_CLINIC_VALID_END >= '");
        sql.append(VRDateParser.format(targetDateStart,"yyyy/MM/dd"));
        sql.append("')");
        
        List list = db.executeQuery(sql.toString());
        Map<String, String> result = new HashMap<String, String>();
        
        for (int i = 0; i < list.size(); i++) {
            Map m = (Map)list.get(i);
            result.put(ACCastUtilities.toString(m.get("CODE")), ACCastUtilities.toString(m.get("SPECIAL_CLINIC_NAME")));
        }
        
        
        return result;
    }
    
    // �ݒ肳��Ă������f�Ô�E���ʗ×{��̍��Z���擾
    private String getName(VRMap row, String code, String name) throws Exception {

        if ("".equals(name)) {
            return "";
        }
        
        if (clinicName == null) {
        	clinicName = getClinicName(row);
        }
        
        
        if (!clinicName.containsKey(code)) {
            return "";
        }
        
        return clinicName.get(code).toString();
    }
    
    /**
     * ����f�Ô�E���ʗ×{��̖��̂Ɛݒ�����擾
     * 
     * @param row
     * @param codeMap
     * @return
     * @throws Exception
     * @since V6.1.2
     */
    private Map getTotalName(VRMap row, Map<String, String> codeMap) throws Exception {
        
        String name = "";
        VRMap map = new VRHashMap();
        VRMap inMap = new VRHashMap();

        
        for (Entry<String, String> code : codeMap.entrySet()) {
            
            if (!row.containsKey(code.getKey())){
                continue;
            }
            
            // �T�[�r�X���̂��L�[�ɂ��ē��t��ޔ�����
            name = getName(row, code.getValue(), ACCastUtilities.toString(row.get(code.getKey()), ""));
            inMap = new VRHashMap();
            
        	// ���O�E���t�E�񐔂�ݒ�
        	inMap.setData("NAME",name);
        	inMap.setData("SERVICE_DATE",row.getData("SERVICE_DATE"));
        	inMap.setData("COUNT",ACCastUtilities.toInt(row.get(code.getKey()), 0));
        	
        	map.setData(code.getKey(),inMap);
            
        }
        
        return map;
    }
    

    private Map<String, String> getRyoyoMap() {
        
        if (ryoyoMap != null) {
            return ryoyoMap;
        }
        
        
        ryoyoMap = new HashMap<String, String>();
        
        ryoyoMap.put("3010101", "01-2"); //�����΍�w���Ǘ�
        ryoyoMap.put("3010105", "02-2"); //����{�݊Ǘ�
        ryoyoMap.put("3010106", "03-2"); //����{�݊Ǘ������Z
        ryoyoMap.put("3010107", "04-2"); //����{�݊Ǘ��Q�l�������Z
        ryoyoMap.put("3010144", "05-2"); //���������f�ÊǗ�
        ryoyoMap.put("3010108", "06-2"); //�d�ǔ畆��ᇊǗ��w��
        ryoyoMap.put("3010110", "09-2"); //��܊Ǘ��w��
        ryoyoMap.put("3010111", "10-2"); //���ʖ�܊Ǘ��w�����Z
        ryoyoMap.put("3010145", "11-2"); //��w����
        ryoyoMap.put("3010136", "31-2"); //�ېH�@�\�Ö@
        ryoyoMap.put("3010137", "32-2"); //���_�ȍ�ƗÖ@
        ryoyoMap.put("3010149", "33-2"); //�F�m�ǐ��V�l�������_�Ö@
        ryoyoMap.put("3010102", "34-2"); //��጑΍�w���Ǘ�
        ryoyoMap.put("3010104", "35-2"); //�d�v�×{�Ǘ�
        ryoyoMap.put("3010147", "39-2"); //���꒮�o�Ö@
        ryoyoMap.put("3010148", "47-2"); //���꒮�o�Ö@(���Z
        ryoyoMap.put("3010141", "50-2"); //���꒮�o�Ö@���n�r���̐��������Z
        ryoyoMap.put("3010146", "53-2"); //���n�r���e�[�V�����w���Ǘ�
        
        return ryoyoMap;
    }
    
    private Map<String, String> getShinryoMap() {
        
        if (shinryoMap != null) {
            return shinryoMap;
        }
        
        
        shinryoMap = new HashMap<String, String>();
        
        shinryoMap.put("3010101", "01-1"); //�����΍�w���Ǘ�
        shinryoMap.put("3010102", "34-1"); //��጑΍�w���Ǘ�
        shinryoMap.put("3010103", "05-1"); //�������@�f�ÊǗ�
        shinryoMap.put("3010104", "35-1"); //�d�v�×{�Ǘ�
        shinryoMap.put("3010105", "02-1"); //����{�݊Ǘ�
        shinryoMap.put("3010106", "03-1"); //����{�݊Ǘ������Z
        shinryoMap.put("3010107", "04-1"); //����{�݊Ǘ��Q�l�������Z
        shinryoMap.put("3010108", "06-1"); //�d�ǔ畆��ᇊǗ��w��
        shinryoMap.put("3010110", "09-1"); //��܊Ǘ��w��
        shinryoMap.put("3010111", "10-1"); //���ʖ�܊Ǘ��w�����Z
        shinryoMap.put("3010112", "11-1"); //��w����(�T
        shinryoMap.put("3010113", "12-1"); //��w����(�U
        shinryoMap.put("3010114", "14-1"); //���w�Ö@(�T
        shinryoMap.put("3010115", "16-1"); //���w�Ö@(�U
        shinryoMap.put("3010116", "18-1"); //���w�Ö@(�V
        shinryoMap.put("3010117", "19-1"); //���w�Ö@(�W
        shinryoMap.put("3010118", "40-1"); //���w�Ö@(�T
        shinryoMap.put("3010119", "41-1"); //���w�Ö@(�U
        shinryoMap.put("3010120", "42-1"); //���w�Ö@(�V
        shinryoMap.put("3010121", "43-1"); //���w�Ö@(�W
        shinryoMap.put("3010122", "36-1"); //���w�Ö@���퐶�������P�����Z��-0�E1�E2�E3
        shinryoMap.put("3010123", "20-1"); //���w�Ö@���n�r���v����Z
        shinryoMap.put("3010124", "22-1"); //���w�Ö@���퓮��P���w�����Z
        shinryoMap.put("3010125", "23-1"); //��ƗÖ@(�T
        shinryoMap.put("3010126", "25-1"); //��ƗÖ@(�U
        shinryoMap.put("3010127", "44-1"); //��ƗÖ@(�T
        shinryoMap.put("3010128", "45-1"); //��ƗÖ@(�U
        shinryoMap.put("3010129", "37-1"); //��ƗÖ@���퐶�������P�����Z��-0�E1�E2�E3
        shinryoMap.put("3010130", "27-1"); //��ƗÖ@���n�r���v����Z
        shinryoMap.put("3010131", "29-1"); //��ƗÖ@���퓮��P���w�����Z
        shinryoMap.put("3010132", "38-1"); //���꒮�o�Ö@(�T
        shinryoMap.put("3010133", "39-1"); //���꒮�o�Ö@(�U
        shinryoMap.put("3010134", "46-1"); //���꒮�o�Ö@(�T
        shinryoMap.put("3010135", "47-1"); //���꒮�o�Ö@(�U
        shinryoMap.put("3010136", "31-1"); //�ېH�@�\�Ö@
        shinryoMap.put("3010137", "32-1"); //���_�ȍ�ƗÖ@
        shinryoMap.put("3010138", "33-1"); //�F�m�ǐ��V�l���@���_�Ö@
        shinryoMap.put("3010139", "48-1"); //���w�Ö@���n�r���̐��������Z
        shinryoMap.put("3010140", "49-1"); //��ƗÖ@���n�r���̐��������Z
        shinryoMap.put("3010141", "50-1"); //���꒮�o�Ö@���n�r���̐��������Z
        shinryoMap.put("3010142", "51-1"); //���n�r���}�l�W�����g���Z
        shinryoMap.put("3010143", "52-1"); //�Z���W�����n�r�����Z
        shinryoMap.put("3010150", "54-1"); //�W�c�R�~���j�P�[�V�����Ö@
        shinryoMap.put("3010151", "55-1"); //�F�m�ǒZ���W�����n�r�����Z
       
        return shinryoMap;

    }
    
    
    // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/13 add - begin
    private Map<String, String> getTokubetuShinryoMap() {
        
        if (tokubetuShinryoMap != null) {
            return tokubetuShinryoMap;
        }
        
        
        tokubetuShinryoMap = new HashMap<String, String>();
        
        tokubetuShinryoMap.put("3010101", "01-3"); //�����΍�w���Ǘ�
        tokubetuShinryoMap.put("3010102", "34-3"); //��ጊǗ�
        tokubetuShinryoMap.put("3010103", "05-3"); //���������f�ÊǗ�
        tokubetuShinryoMap.put("3010104", "35-3"); //�d�v�×{�Ǘ�
        tokubetuShinryoMap.put("3010105", "02-3"); //����{�݊Ǘ�
        tokubetuShinryoMap.put("3010106", "03-3"); //����{�݊Ǘ������Z
        tokubetuShinryoMap.put("3010107", "04-3"); //����{�݊Ǘ��Q�l�������Z
        tokubetuShinryoMap.put("3010108", "06-3"); //�d�ǔ畆��ᇊǗ��w��
        tokubetuShinryoMap.put("3010110", "09-3"); //��܊Ǘ��w��
        tokubetuShinryoMap.put("3010111", "10-3"); //���ʖ�܊Ǘ��w�����Z
        tokubetuShinryoMap.put("3010112", "11-3"); //��w����(�T
        tokubetuShinryoMap.put("3010113", "12-3"); //��w����(�U
        tokubetuShinryoMap.put("3010114", "14-3"); //���w�Ö@(�T
        tokubetuShinryoMap.put("3010115", "16-3"); //���w�Ö@(�U
        tokubetuShinryoMap.put("3010116", "18-3"); //���w�Ö@(�V
        tokubetuShinryoMap.put("3010117", "19-3"); //���w�Ö@(�W
        tokubetuShinryoMap.put("3010118", "40-3"); //���w�Ö@(�T
        tokubetuShinryoMap.put("3010119", "41-3"); //���w�Ö@(�U
        tokubetuShinryoMap.put("3010120", "42-3"); //���w�Ö@(�V
        tokubetuShinryoMap.put("3010121", "43-3"); //���w�Ö@(�W
        tokubetuShinryoMap.put("3010122", "36-3"); //���w�Ö@���퐶�������P�����Z��-0�E1�E2�E3
        tokubetuShinryoMap.put("3010123", "20-3"); //���w�Ö@���n�r���v����Z
        tokubetuShinryoMap.put("3010124", "22-3"); //���w�Ö@���퓮��P���w�����Z
        tokubetuShinryoMap.put("3010125", "23-3"); //��ƗÖ@(�T
        tokubetuShinryoMap.put("3010126", "25-3"); //��ƗÖ@(�U
        tokubetuShinryoMap.put("3010127", "44-3"); //��ƗÖ@(�T
        tokubetuShinryoMap.put("3010128", "45-3"); //��ƗÖ@(�U
        tokubetuShinryoMap.put("3010129", "37-3"); //��ƗÖ@���퐶�������P�����Z��-0�E1�E2�E3
        tokubetuShinryoMap.put("3010130", "27-3"); //��ƗÖ@���n�r���v����Z
        tokubetuShinryoMap.put("3010131", "29-3"); //��ƗÖ@���퓮��P���w�����Z
        tokubetuShinryoMap.put("3010132", "38-3"); //���꒮�o�Ö@(�T
        tokubetuShinryoMap.put("3010133", "39-3"); //���꒮�o�Ö@(�U
        tokubetuShinryoMap.put("3010134", "46-3"); //���꒮�o�Ö@(�T
        tokubetuShinryoMap.put("3010135", "47-3"); //���꒮�o�Ö@(�U
        tokubetuShinryoMap.put("3010136", "31-3"); //�ېH�@�\�Ö@
        tokubetuShinryoMap.put("3010137", "32-3"); //���_�ȍ�ƗÖ@
        tokubetuShinryoMap.put("3010138", "33-3"); //�F�m�Ǔ������_�Ö@
        tokubetuShinryoMap.put("3010139", "48-3"); //���w�Ö@���n�r���̐��������Z
        tokubetuShinryoMap.put("3010140", "49-3"); //��ƗÖ@���n�r���̐��������Z
        tokubetuShinryoMap.put("3010141", "50-3"); //���꒮�o�Ö@���n�r���̐��������Z
        tokubetuShinryoMap.put("3010142", "51-3"); //���n�r���}�l�W�����g���Z
        tokubetuShinryoMap.put("3010143", "52-3"); //�Z���W�����n�r�����Z
        tokubetuShinryoMap.put("3010150", "54-3"); //�W�c�R�~���j�P�[�V�����Ö@
        tokubetuShinryoMap.put("3010151", "55-3"); //�F�m�ǒZ���W�����n�r�����Z
       
        return tokubetuShinryoMap;

    }
    // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/13 add - end
    
    
    
    
    //���ʗ×{��̃R�[�h�Z�b�g���쐬
    private Set<String> createRyoyoSet() {
        Set<String> set = new HashSet<String>();
        
        //�Z�������×{���i�V���j
        set.add("12211");
        //�\�h�Z�������×{���i�V���j
        set.add("12511");
        //���V�l�ی��{��
        set.add("15211");
        
        return set;
    }
    
    //����f�Ô�̃R�[�h�Z�b�g���쐬
    private Set<String> createShinryoSet() {
        Set<String> set = new HashSet<String>();
        
        //�Z�������×{���i�a�@�j
        set.add("12311");
        //�Z�������×{���i�f�Ï��j
        set.add("12312");
        //�Z�������×{���i�F�m�ǁj
        set.add("12313");
        //�\�h�Z�������×{���i�a�@�j
        set.add("12611");
        //�\�h�Z�������×{���i�f�Ï��j
        set.add("12612");
        //�\�h�Z�������×{���i�F�m�ǁj
        set.add("12613");
        //���×{�^��Î{�݁i�a�@�j
        set.add("15311");
        //���×{�^��Î{�݁i�f�Ï��j
        set.add("15312");
        //���×{�^��Î{�݁i�F�m�ǁj
        set.add("15313");
        
        return set;
    }
    
    // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/13 add - begin
    //���ʐf�Ô�̃R�[�h�Z�b�g���쐬
    private Set<String> createTokubetuShinryoSet() {
        Set<String> set = new HashSet<String>();
        
        //����É@
        set.add("15511");
        //�Z�������×{���(����É@)
        set.add("204211");
        //���\�h�Z�������×{���(����É@)
        set.add("204311");
        
        return set;
    }
    // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/13 add - end
    
    /**
     * ��͌�̓���f�Ô�E���ʗ×{��̐ݒ胊�X�g���擾���܂��B
     * 
     * @return
     */
    public Map<String, Map> getDiagnosisDateMap() {
    	if(diagnosisDateMap == null) {
    		return new VRHashMap();
    	}
		return diagnosisDateMap;
	}
    
    
    //�e�X�g�R�[�h
    public static void main(String[] args) throws Exception {
        
        String server = "172.23.25.91";
        int port = 3050;
        String userName = "SYSDBA";
        String pass = "masterkey";
        String path = "C:\\database\\qkan.fdb";
        int loginTimeOut = 1;
        int maxPoolSize = 500;
        String charSet = "MS932";
        String encoding = "SJIS_0208";
        
        CareServicePrecomputed t = new CareServicePrecomputed();
        BridgeFirebirdDBManager fdb = new BridgeFirebirdDBManager(server, port, userName, pass, path, loginTimeOut, maxPoolSize, charSet, encoding);
        
        
        VRList serviceList = QkanCommon.getServiceDetail(
                fdb, 9, ACCastUtilities.toDate("20120401"),
                QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY.intValue());
        
        Map<String, Integer> u = new HashMap<String, Integer>();
        Map<String, Integer> d = new HashMap<String, Integer>();
        
        t.setPrecomputedResult(fdb, serviceList, u, d);
        
        System.out.println("--------------------");
        for (Entry<String, Integer> key: u.entrySet()) {
            System.out.println(key.getKey());
            System.out.println(key.getValue());
        }
        System.out.println("--------------------");
        for (Entry<String, Integer> key: d.entrySet()) {
            System.out.println(key.getKey());
            System.out.println(key.getValue());
        }
        System.out.println("--------------------");
    }
    
    
}
