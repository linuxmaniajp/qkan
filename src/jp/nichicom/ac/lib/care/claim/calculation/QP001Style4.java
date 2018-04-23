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
 * �v���O���� �l����l (QP001Style4)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * �l����l �꒠�[���̏��
 * 
 * @author shin fujihara
 * 
 */
public class QP001Style4 extends QP001StyleAbstract {

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
     * �ً}���{�ݗ×{��񃌃R�[�h
     */
    private QP001RecordEmergency emergency = new QP001RecordEmergency();
    
    /**
     * ���ʗ×{��E���ʐf�Ô��񃌃R�[�h
     */
    private Map<String, QP001RecordDiagnosis> diagnosisMap = new TreeMap<String, QP001RecordDiagnosis>();
    
 // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - begin
    /**
     * ��{�E�v��񃌃R�[�h�W��
     */
    private Map<String, QP001RecordBaseSummary> baseSummaryMap = new TreeMap<String, QP001RecordBaseSummary>();
 // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - end
    
    /**
     * �����l���ԍ�
     */
    private int claimStyleFormat = 0;
    /**
     * �������ʔԍ�
     */
    private String identificationNo = "";
    private QP001Manager manager = null;
    
    public QP001Style4(int claimStyleFormat,QP001Manager manager){
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
        // �ً}�����ÊǗ����Z������ꍇ
        String systemServiceCode = String.valueOf(serviceCode.get("SYSTEM_SERVICE_CODE_ITEM"));
        if("Z9000".equals(systemServiceCode)
                || "Z6000".equals(systemServiceCode)){
            // �ً}�����É��Z���R�[�h��ݒ肷��B
            emergency.parse(serviceDetail, targetDate, patientState,serviceCode,
                    identificationNo,manager);
        }

        //[H20.5 �@�����Ή�] fujihara add start
        /* ���ʗ×{��E���ʐf�Ô��񃌃R�[�h */
        QP001RecordDiagnosisMaker diagnosisMaker = new QP001RecordDiagnosisMaker(
                identificationNo, serviceDetail, targetDate,
                targetServiceDate, patientState, serviceCode, diagnosisMap,manager);
        
        if(firstRecord){
            // ���ʗ×{��E���ʐf�Ô��񃌃R�[�h�̍쐬
        	// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/28 mod - begin
//            diagnosisMap = diagnosisMaker.makeRecuperation();
            switch (claimStyleFormat) {
            case QkanConstants.CLAIM_STYLE_FORMAT_4:
            case QkanConstants.CLAIM_STYLE_FORMAT_4_2:
            	diagnosisMap = diagnosisMaker.makeRecuperation();
                break;
            case QkanConstants.CLAIM_STYLE_FORMAT_4_3:
            case QkanConstants.CLAIM_STYLE_FORMAT_4_4:
            	diagnosisMap = diagnosisMaker.makeTokubetuShinryo();
                break;
            }
            // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/28 mod - end
        }
        //[H20.5 �@�����Ή�] fujihara add end
        
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

        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - begin
        // ��{�E�v���R�[�h
        if (QP001RecordBaseSummaryMaker.isMakeRecord(identificationNo, serviceDetail, serviceCode)) {
        	QP001RecordBaseSummaryMaker summaryMaker = new QP001RecordBaseSummaryMaker(
        			identificationNo, serviceDetail, targetDate,
                    targetServiceDate, patientState, serviceCode, baseSummaryMap, manager);
        	baseSummaryMap = summaryMaker.make();
        }
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - end
    }

    /**
     * �f�[�^�̊m�菈�����s���B
     */
    public void commitRecords(QP001PatientState patientState,VRMap styles, VRMap planUnitMap)
            throws Exception {
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//        VRMap kohiMap;
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
//            count++;
//            if (count > kohiTypes.length - 1)
//                break;
//        }
        
        List<Map> records = new ArrayList<Map>();
        records.add(detailMap);
        records.add(nursingMap);
        records.add(diagnosisMap);
        QP001KohiKey[] kohiTypes = getKohiApplyArray(records);
// 2015/5/12 [Yoichiro Kamei] mod - end
        
        // ���׏�񃌃R�[�h�̊m�菈��
        it = detailMap.keySet().iterator();
        while (it.hasNext()) {
            // �쐬�������׏�񃌃R�[�h�̊m����s���B
            ((QP001RecordDetail) detailMap.get(it.next()))
                    .commitRecord(kohiTypes,patientState);
        }
        
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - begin
        // ��{�E�v���R�[�h�̊m�菈��
        for (QP001RecordBaseSummary summary : baseSummaryMap.values()) {
        	summary.commitRecord(patientState);
        }
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - end

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
//        // ����f�Ô��񃌃R�[�h�̊m�菈��
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
        emergency.commitRecord();
        
        type.parse(emergency,kohiTypes,patientState);

        it = detailMap.keySet().iterator();
        // �W�v��񃌃R�[�h�̍쐬
        while (it.hasNext()) {
            detail = ((QP001RecordDetail) detailMap.get(it.next()));
            type.parse(detail,patientState,manager);
        }
        
        // �W�v��񃌃R�[�h�̊m�菈��
        type.commitRecord(kohiTypes, patientState,styles,planUnitMap);
        //[H20.5 �@�����Ή�] fujihara add start
        //���ȕ��S�z��{�̐������炩���邽�߁Atype.commitRecord�̌�Ɏ��s���Ă��K�p����
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//        if (diagnosis != null) {
//        	//[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
//            //type.parse(diagnosis, kohiTypes,patientState);
//        	type.parse(diagnosis, kohiTypes,patientState, nursingLast);
//            //[ID:0000523][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
//        }
//        //[H20.5 �@�����Ή�] fujihara add end
        it = diagnosisMap.keySet().iterator();
        // �W�v��񃌃R�[�h�̍쐬
        while (it.hasNext()) {
            diagnosis = ((QP001RecordDiagnosis) diagnosisMap.get(it.next()));
            type.parse(diagnosis, kohiTypes,patientState, nursingLast);
        }
// 2015/5/12 [Yoichiro Kamei] mod - end
        
        // ��{��񃌃R�[�h�̊m�菈��
        base.parse(type, patientState,kohiTypes,manager);
        //��������ҏ�����{��񃌃R�[�h�ɐݒ�
        //base.parse(nursing);
        base.parse(nursingLast,patientState,kohiTypes);
        //�ً}�����R�[�h����{��񃌃R�[�h�ɐݒ�
        base.parse(emergency);
        
        //[H20.5 �@�����Ή�] fujihara add start
        //���ʗ×{��E���ʐf�Ô�R�[�h�̊m�菈��
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
        //���ʗ×{��E���ʐf�Ô��񃌃R�[�h
        it = diagnosisMap.keySet().iterator();
        while (it.hasNext()) {
            list.add(((QP001RecordDiagnosis) diagnosisMap.get(it.next()))
                    .getRecord(style));
        }
        //[H20.5 �@�����Ή�] fujihara edit end
        
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - begin
        //��{�E�v��񃌃R�[�h
        for (QP001RecordBaseSummary summary : baseSummaryMap.values()) {
        	list.add(summary.getRecord(style));
        }
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - end
        
        //�Е����ƃ��R�[�h
        list.add(emergency.getRecord(style));

        //�W�v��񃌃R�[�h
        list.add(type.getRecord(style));

        //��{��񃌃R�[�h
        list.add(base.getRecord(style));

        return list;
    }

}
