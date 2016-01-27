/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKANCHO�iJMA care benefit management software�j
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKANCHO (JMA care benefit management software)".
 *
 * This program is distributed in the hope that it will be useful
 * for further advancement in medical care, according to JMA Open
 * Source License, but WITHOUT ANY WARRANTY.
 * Everyone is granted permission to use, copy, modify and
 * redistribute this program, but only under the conditions described
 * in the JMA Open Source License. You should have received a copy of
 * this license along with this program. If not, stop using this
 * program and contact JMA, 2-28-16 Honkomagome, Bunkyo-ku, Tokyo,
 * 113-8621, Japan.
 *****************************************************************
 * �A�v��: QKANCHO
 * �J����: �����@�L
 * �쐬��: 2006/01/24  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� �l����� (QP001Style9)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �l����� �꒠�[���̏��
 * 
 * @author shin fujihara
 * 
 */
public class QP001Style9 extends QP001StyleAbstract {

    /**
     * ��{��񃌃R�[�h(�꒠�[�ɂЂƂ�)
     */
    private QP001RecordBase base = new QP001RecordBase();

    /**
     * ���׏�񃌃R�[�h�W��
     */
    private VRMap detailMap = new VRHashMap();

    /**
     * �W�v��񃌃R�[�h�W��(�꒠�[�ɂЂƂ�)
     */
    private QP001RecordType type = new QP001RecordType();

    /**
     * ��������҉��T�[�r�X��񃌃R�[�h�W��
     */
    private VRMap nursingMap = new VRHashMap();

    /**
     * �ً}���{�ݗ×{�E���{�ݗ×{���񃌃R�[�h
     */
    private QP001RecordEmergencyOwnFacility emergencyOwnFacility = new QP001RecordEmergencyOwnFacility();
    /**
     * ����f�Ô��񃌃R�[�h
     */
    private Map diagnosisMap = new TreeMap();
    
    /**
     * �����l���ԍ�
     */
    private int claimStyleFormat = 0;
    /**
     * �������ʔԍ�
     */
    private String identificationNo = "";
    
    private QP001Manager manager = null;
    

    public QP001Style9(int claimStyleFormat,QP001Manager manager){
        this.claimStyleFormat = claimStyleFormat;
        this.identificationNo = getIdentificationNo(claimStyleFormat,manager.getTargetDate());
        this.manager = manager;
    }

    public static String getSerialId(
            Date targetDate,
            VRMap serviceDetail,
            QP001PatientState patientState,
            int claimStyleFormat) throws Exception {
        StringBuilder serial = new StringBuilder();
        // 201001 ������񎯕ʔԍ�4��
        
        //[H20.4 �@�����Ή�] fujihara edit start
        //serial.append(getIdentificationNo(claimStyleFormat));
        serial.append(getIdentificationNo(claimStyleFormat,targetDate));
        //[H20.4 �@�����Ή�] fujihara edit end
        
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        serial.append(VRDateParser.format(targetDate, "yyyyMM"));
        // ���Ə��ԍ�10��
        serial.append(VRBindPathParser.get("PROVIDER_ID", serviceDetail));
        // �؋L�ڕی��Ҕԍ�8��
        serial.append(patientState.getInsurerId(VRBindPathParser.get(
                "SERVICE_DATE", serviceDetail)));
        // ��ی��Ҕԍ�10��
        serial.append(patientState.getInsuredId(VRBindPathParser.get(
                "SERVICE_DATE", serviceDetail)));

        return serial.toString();
    }

    /**
     * �f�[�^�̉�͂����s����B
     * 
     * @param serviceDetail
     * @param targetDate
     * @param patientState
     * @param serviceCode
     * @throws Exception
     */
    //[H20.5 �@�����Ή�] fujihara edit start
//    public void parse(VRMap serviceDetail, Date targetDate,
//            QP001PatientState patientState, VRMap serviceCode) throws Exception {
    public void parse(VRMap serviceDetail, Date targetDate,
            QP001PatientState patientState, VRMap serviceCode,boolean firstRecord) throws Exception {
    //[H20.5 �@�����Ή�] fujihara edit end

        Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",
                serviceDetail);

        /* ���׏�񃌃R�[�h�W�v���� */
        QP001RecordDetail detail = QP001RecordDetail.getInstance(identificationNo,
                targetDate,
                targetServiceDate,
                serviceDetail,
                serviceCode,
                patientState,
                detailMap,
                manager);
        
        //���R�[�h���쐬����Ă����
        if(detail != null){
            //���׏��f�[�^���
            detail.parse(serviceDetail,targetDate,patientState,serviceCode,identificationNo,manager);
        }

        /* �ً}���ً}���{�ݗ×{���R�[�h */
        // [ID:0000698][Shin Fujihara] 2012/03 add end ����24�N4���@�����Ή�
        // parse���ŁA���R�[�h���쐬���邩���f����悤�ύX
        emergencyOwnFacility.parse(serviceDetail, targetDate, patientState,serviceCode, identificationNo, manager);
        // [ID:0000698][Shin Fujihara] 2012/03 add end ����24�N4���@�����Ή�
        
        
        /* ��������҉��T�[�r�X */
        QP001RecordNursing nursing = QP001RecordNursing.getInstance(identificationNo,
                                                                targetDate,
                                                                targetServiceDate,
                                                                serviceDetail,
                                                                serviceCode,
                                                                patientState,
                                                                nursingMap,
                                                                manager);

        if(nursing != null){
            // ��������҃��R�[�h�̉�͂��s���B
            nursing.parse(serviceDetail, targetDate, patientState, serviceCode,
                    identificationNo,manager);
        }
        
        //[H20.5 �@�����Ή�] fujihara add start
        /* ����f�Ô��񃌃R�[�h */
        QP001RecordDiagnosisMaker diagnosisMaker = new QP001RecordDiagnosisMaker(
                identificationNo, serviceDetail, targetDate,
                targetServiceDate, patientState, serviceCode, diagnosisMap,manager);
        
        if(firstRecord){
            // ����f�Ô��񃌃R�[�h�̍쐬
            diagnosisMap = diagnosisMaker.makeRecuperation();
        }
        //[H20.5 �@�����Ή�] fujihara add end

    }

    /**
     * �f�[�^�̊m�菈�����s���B
     */
    public void commitRecords(QP001PatientState patientState,VRMap styles, VRMap planUnitMap)
            throws Exception {
        VRMap kohiMap;
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//        TreeMap kohiRank = new TreeMap();
        QP001RecordDetail detail = null;
        QP001RecordNursing nursing = null;
        //[H20.5 �@�����Ή�] fujihara edit start
        QP001RecordDiagnosis diagnosis = null;
        //[H20.5 �@�����Ή�] fujihara edit end
        Iterator it;
//        // �{���[�ɂ��������ʂ̊m����s���B
//        // TODO ���������������������肳�������B
//
//        Iterator it = detailMap.keySet().iterator();
//        while (it.hasNext()) {
//            detail = (QP001RecordDetail) detailMap.get(it.next());
//            // �쐬�������׏�񃌃R�[�h�̌���K�p�󋵂��擾����B
//            kohiMap = detail.getKohiList();
//            Iterator itKohi = kohiMap.keySet().iterator();
//            // ����̏��ʂ�o�^����B
//            while (itKohi.hasNext()) {
//                Object key = itKohi.next();
//                if (!kohiRank.containsKey(key)) {
//                    kohiRank.put(key, kohiMap.get(key));
//                }
//            }
//        }
//        it = nursingMap.keySet().iterator();
//        while (it.hasNext()) {
//            nursing = (QP001RecordNursing) nursingMap.get(it.next());
//            // �쐬������������҃��R�[�h�̌���K�p�󋵂��擾����B
//            kohiMap = nursing.getKohiList();
//            Iterator itKohi = kohiMap.keySet().iterator();
//            // ����̏��ʂ�o�^����B
//            while (itKohi.hasNext()) {
//                Object key = itKohi.next();
//                if (!kohiRank.containsKey(key)) {
//                    kohiRank.put(key, kohiMap.get(key));
//                }
//            }
//        }
//        
//        //[H20.5 �@�����Ή�] fujihara edit start
//        it = diagnosisMap.keySet().iterator();
//        while (it.hasNext()) {
//            diagnosis = (QP001RecordDiagnosis) diagnosisMap.get(it.next());
//            // �쐬��������f�Ô�R�[�h�̌���󋵂��擾����B
//            kohiMap = diagnosis.getKohiList();
//            Iterator itKohi = kohiMap.keySet().iterator();
//            // ����̏��ʂ�o�^����B
//            while (itKohi.hasNext()) {
//                Object key = itKohi.next();
//                if (!kohiRank.containsKey(key)) {
//                    kohiRank.put(key, kohiMap.get(key));
//                }
//            }
//        }
//        //[H20.5 �@�����Ή�] fujihara edit end
//        
//        // ����K�p����
//        QP001KohiKey[] kohiTypes = new QP001KohiKey[3];
//        it = kohiRank.keySet().iterator();
//        int count = 0;
//        while (it.hasNext()) {
//            VRMap temp = (VRMap) kohiRank.get(it.next());
//            kohiTypes[count] = new QP001KohiKey(temp);
//            
//            // [CCCX:1470][Shinobu Hitaka] 2014/03/13 add - start �V���̈ꕔ����
//            // �V���̈ꕔ����ΏۂŁA�ً}���{�ݗ×{��E���莾���{�ݗ×{��Ȃ��ꍇ�͌���X�g���珜�O
//            if (CareServiceCommon.isKouhiService("52", kohiTypes[count].getKohiType())) {
//                boolean kohiFlg = false;
//                if (emergencyOwnFacility.get_1701018() == 0 && emergencyOwnFacility.get_1701019() == 0 && 
//                    emergencyOwnFacility.get_1701053() == 0 && emergencyOwnFacility.get_1701054() == 0) {
//                    // (1) �ݒ�Ȃ�
//                    kohiFlg = false;
//                } else {
//                    // (2) �ݒ肠��Ō���r���J�n�E�I���Ŋ��ԊO�i���ׂɌ���K�p���Ȃ��j
//                    // ���ׂ̌���K�p�󋵂��m�F
//                    Iterator itDetail = detailMap.keySet().iterator();
//                    while (itDetail.hasNext()) {
//                        detail = (QP001RecordDetail) detailMap.get(itDetail.next());
//                        // �ً}���{�ݗ×{��E���莾���{�ݗ×{��̏ꍇ
//                        if ("Z6000".equals(detail.get_301022()) || "Z6100".equals(detail.get_301022()) || "Z9000".equals(detail.get_301022()) || "Z9100".equals(detail.get_301022())) {
//                            // ���ׂɓ�������K�p���ꂽ�ꍇ�͑ΏۂƂ���
//                            kohiMap = detail.getKohiList();
//                            Iterator itKohi = kohiMap.keySet().iterator();
//                            while (itKohi.hasNext()) {
//                                Object key = itKohi.next();
//                                VRMap detailKohiMap = (VRMap) kohiMap.get(key);
//                                if (kohiTypes[count].equals(ACCastUtilities.toString(VRBindPathParser.get("KOHI_TYPE", detailKohiMap)))) {
//                                    kohiFlg = true;
//                                    break;
//                                }
//                            }
//                        }
//                        if (kohiFlg) break;
//                    }
//                }
//                // ��v������̂��Ȃ���Ό���X�g���珜�O
//                if (!kohiFlg) {
//                    kohiTypes[count] = null;
//                    continue;
//                }
//            }
//            // [CCCX:1470][Shinobu Hitaka] 2014/03/13 add - end �V���̈ꕔ����
//            
//            count++;
//            if (count > kohiTypes.length - 1)
//                break;
//        }
        
        List<Map> records = new ArrayList<Map>();
        records.add(detailMap);
        records.add(nursingMap);
        records.add(diagnosisMap);
        List kohiTypesList = Arrays.asList(getKohiApplyArray(records));
        // ����K�p����
        QP001KohiKey[] kohiTypes = new QP001KohiKey[3];
        it = kohiTypesList.iterator();
        int count = 0;
        while (it.hasNext()) {
            kohiTypes[count] = (QP001KohiKey) it.next();
            // [CCCX:1470][Shinobu Hitaka] 2014/03/13 add - start �V���̈ꕔ����
            // �V���̈ꕔ����ΏۂŁA�ً}���{�ݗ×{��E���莾���{�ݗ×{��Ȃ��ꍇ�͌���X�g���珜�O
            if (kohiTypes[count] != null && CareServiceCommon.isKouhiService("52", kohiTypes[count].getKohiType())) {
                boolean kohiFlg = false;
                if (emergencyOwnFacility.get_1701018() == 0 && emergencyOwnFacility.get_1701019() == 0 && 
                    emergencyOwnFacility.get_1701053() == 0 && emergencyOwnFacility.get_1701054() == 0) {
                    // (1) �ݒ�Ȃ�
                    kohiFlg = false;
                } else {
                    // (2) �ݒ肠��Ō���r���J�n�E�I���Ŋ��ԊO�i���ׂɌ���K�p���Ȃ��j
                    // ���ׂ̌���K�p�󋵂��m�F
                    Iterator itDetail = detailMap.keySet().iterator();
                    while (itDetail.hasNext()) {
                        detail = (QP001RecordDetail) detailMap.get(itDetail.next());
                        // �ً}���{�ݗ×{��E���莾���{�ݗ×{��̏ꍇ
                        if ("Z6000".equals(detail.get_301022()) || "Z6100".equals(detail.get_301022()) || "Z9000".equals(detail.get_301022()) || "Z9100".equals(detail.get_301022())) {
                            // ���ׂɓ�������K�p���ꂽ�ꍇ�͑ΏۂƂ���
                            kohiMap = detail.getKohiList();
                            Iterator itKohi = kohiMap.keySet().iterator();
                            while (itKohi.hasNext()) {
                                Object key = itKohi.next();
                                VRMap detailKohiMap = (VRMap) kohiMap.get(key);
                                if (kohiTypes[count].getKohiType().equals(ACCastUtilities.toString(VRBindPathParser.get("KOHI_TYPE", detailKohiMap)))) {
                                    kohiFlg = true;
                                    break;
                                }
                            }
                        }
                        if (kohiFlg) break;
                    }
                }
                // ��v������̂��Ȃ���Ό���X�g���珜�O
                if (!kohiFlg) {
                    kohiTypes[count] = null;
                    continue;
                }
            }
            // [CCCX:1470][Shinobu Hitaka] 2014/03/13 add - end �V���̈ꕔ����
            count++;
            if (count > kohiTypes.length - 1)
                break;
        }
// 2015/5/12 [Yoichiro Kamei] mod - end
        // ���׏�񃌃R�[�h�̊m�菈��
        //[ID:0000721][Shin Fujihara] 2012/04 delete start 2012�N�x�Ή�
//        it = detailMap.keySet().iterator();
//        //[ID:0000583][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
//        //�ی��{�݃^�[�~�i���P�A���Z�Q�̓E�v���̓��e��
//        //�ی��{�݃^�[�~�i���P�A���Z�P�ɃR�s�[����
//        boolean isExistPair = false;
//        String _301018 = null;
//        while (it.hasNext()) {
//            // �쐬�������׏�񃌃R�[�h�̊m����s���B
//            detail = (QP001RecordDetail) detailMap.get(it.next());
//            detail.commitRecord(kohiTypes,patientState);
//            
//        	//�ی��{�݃^�[�~�i���P�A���Z�Q�ł���΁A�E�v���̓��e��ޔ����Ă���
//        	if ("Z6602".equals(detail.get_301022())){
//            	if (!ACTextUtilities.isNullText(detail.get_301018())){
//            		_301018 = detail.get_301018();
//            	}
//            	
//            //�ی��{�݃^�[�~�i���P�A���Z�P�̏ꍇ�A�t���O�𗧂ĂĂ���
//        	} else if (!isExistPair){
//        		if ("Z6600".equals(detail.get_301022())) {
//        			isExistPair = true;
//        		}
//        	}
//        }
//        //�E�v�����擾�ł��Ă��āA�����Z�P���Z�肵�Ă���ꍇ
//        if (!ACTextUtilities.isNullText(_301018) && isExistPair) {
//        	it = detailMap.keySet().iterator();
//        	while (it.hasNext()) {
//        		detail = (QP001RecordDetail) detailMap.get(it.next());
//        		if ("Z6600".equals(detail.get_301022())){
//        			detail.set_301018(_301018);
//        		}
//        	}
//        }
//        //[ID:0000583][Shin Fujihara] 2010/01 add end 2009�N�x�Ή�
        //[ID:0000721][Shin Fujihara] 2012/04 delete end 2012�N�x�Ή�
        
        //[ID:0000721][Shin Fujihara] 2012/04 add start 2012�N�x�Ή�
        //�Ŏ��E�^�[�~�i�����Z�̓E�v���]�L���l�����Ȃ���̖��׊m�菈��
        commitDetails(detailMap, kohiTypes, patientState);
        //[ID:0000721][Shin Fujihara] 2012/04 add end 2012�N�x�Ή�

        // ��������҃��R�[�h�̊m�菈��
        //�S�z���p�Ґ����Ή�
        QP001RecordNursing nursingLast = null;
        it = nursingMap.keySet().iterator();
        while (it.hasNext()) {
            nursing = (QP001RecordNursing) nursingMap.get(it.next());
            // �쐬������������҃��R�[�h�̊m�菈�����s���B
            nursing.commitRecord(kohiTypes,patientState,manager);
            //2006.04.28 �S�z���ȕ��S�Ή�
            if((nursing.get_801017() + nursing.get_801018() + nursing.get_801019() + nursing.get_801020()) > 0){
                nursingLast = nursing;
            }
        }
        if (nursingLast != null) {
            // �W�v���s��
            nursingLast.commitRecord(nursingMap);
        }
        
        //[H20.5 �@�����Ή�] fujihara edit start
        // ����f�Ô��񃌃R�[�h�̊m�菈��
//        it = diagnosisMap.keySet().iterator();
//        int recordCount = 1;
//        while (it.hasNext()) {
//            diagnosis = (QP001RecordDiagnosis) diagnosisMap.get(it.next());
//            // �쐬��������f�Ô��񃌃R�[�h�̊m�菈�����s���B
//            diagnosis.commitRecord(kohiTypes, recordCount,patientState);
//            recordCount++;
//        }
//        if (diagnosis != null) {
//            // �W�v���s���B
//            diagnosis.commitRecord(diagnosisMap,patientState);
//        }
        //[H20.5 �@�����Ή�] fujihara edit end
        //[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
        diagnosisMap = commitTreatmentImprovement(detailMap, diagnosisMap, patientState, kohiTypes, styles, planUnitMap);
        //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
        
        // �ً}���̃��R�[�h�̊m�菈��
        emergencyOwnFacility.commitRecord();

        it = detailMap.keySet().iterator();
        // �W�v��񃌃R�[�h�̍쐬
        while (it.hasNext()) {
            detail = ((QP001RecordDetail) detailMap.get(it.next()));
            type.parse(detail,patientState,manager);
        }
        type.parse(emergencyOwnFacility,kohiTypes,patientState);
        
        // �W�v��񃌃R�[�h�̊m�菈��
        type.commitRecord(kohiTypes, patientState,styles,planUnitMap,nursingLast);
        //[H20.5 �@�����Ή�] fujihara add start
        //���ȕ��S�z��{�̐������炩���邽�߁Atype.commitRecord�̌�Ɏ��s���Ă��K�p����
        
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//        if (diagnosis != null) {
//        	//[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
//            //type.parse(diagnosis, kohiTypes,patientState);
//        	type.parse(diagnosis, kohiTypes,patientState, nursingLast);
//            //[ID:0000523][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
//        }
        it = diagnosisMap.keySet().iterator();
        // �W�v��񃌃R�[�h�̍쐬
        while (it.hasNext()) {
            diagnosis = ((QP001RecordDiagnosis) diagnosisMap.get(it.next()));
            type.parse(diagnosis, kohiTypes,patientState, nursingLast);
        }
// 2015/5/12 [Yoichiro Kamei] mod - end

        
        //[H20.5 �@�����Ή�] fujihara add end

        //����f�Ô��񃌃R�[�h����ȕ��S�z�m��
        if(nursing != null){
            nursing.commitRecordKohiSelfPay(kohiTypes,patientState);
        }

        // ��{��񃌃R�[�h�̊m�菈��
        base.parse(type, patientState,kohiTypes,manager);
        //base.parse(nursing);
        base.parse(nursingLast,patientState,kohiTypes);
        //�ً}�����R�[�h����{��񃌃R�[�h�ɐݒ�
        base.parse(emergencyOwnFacility);
        //[H20.5 �@�����Ή�] fujihara add start
        //����f�Ô�R�[�h�̊m�菈��
        base.parse(diagnosis,patientState,kohiTypes);
        //[H20.5 �@�����Ή�] fujihara add end
    }

    /**
     * DB�o�^�p�̃��R�[�h�W�����쐬���܂��B
     * 
     * @param patient_id
     * @param targetDate
     * @return
     * @throws Exception
     */
    public VRList getRecords(int patient_id, Date claimDate)
            throws Exception {
        VRList list = new VRArrayList();
        VRHashMap style = new VRHashMap();

		//�f�[�^������ɐ�������Ă��Ȃ��ꍇ�͏������I������B
		if(ACTextUtilities.isNullText(base.get_201003())){
			return list;
		}
        
        //���[�̗l���ԍ�
        style.put("CLAIM_STYLE_TYPE", ACCastUtilities.toString(claimStyleFormat));
        //���p�҂h�c
        style.put("PATIENT_ID", Integer.toString(patient_id));
        //��{��񃌃R�[�h����擾
        //���p�Ҕԍ�(��ی��Ҕԍ�)
        style.put("INSURED_ID", base.get_201006());
        //�����̑ΏۂƂȂ�N��(�T�[�r�X�񋟔N��)
        style.put("TARGET_DATE", ACCastUtilities.toDate(base.get_201003()
                + "01"));
        //�������s���N����
        style.put("CLAIM_DATE", claimDate);
        //���������Ə�
        style.put("PROVIDER_ID", base.get_201004());
        
        //�ی��Ҕԍ�
        style.put("INSURER_ID",base.get_201005());
        //��ی��Ҕԍ�
        style.put("INSURED_ID",base.get_201006());
        
        style.put("CLAIM_FINISH_FLAG", "0");

        //���׏�񃌃R�[�h
        Iterator it = detailMap.keySet().iterator();
        while (it.hasNext()) {
            list.add(((QP001RecordDetail) detailMap.get(it.next()))
                    .getRecord(style));
        }
        //��������҃��R�[�h
        it = nursingMap.keySet().iterator();
        while (it.hasNext()) {
            list.add(((QP001RecordNursing) nursingMap.get(it.next()))
                    .getRecord(style));
        }
        
        //[H20.5 �@�����Ή�] fujihara edit start
        //����f�Ô��񃌃R�[�h
        it = diagnosisMap.keySet().iterator();
        while (it.hasNext()) {
            list.add(((QP001RecordDiagnosis) diagnosisMap.get(it.next()))
                    .getRecord(style));
        }
        //[H20.5 �@�����Ή�] fujihara edit end
        
        //�Е����ƃ��R�[�h
        list.add(emergencyOwnFacility.getRecord(style));

        //�W�v��񃌃R�[�h
        list.add(type.getRecord(style));

        //��{��񃌃R�[�h
        list.add(base.getRecord(style));

        return list;
    }

}
