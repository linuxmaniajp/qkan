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
 * �v���O���� �l�����ۃN���X (QP001StyleAbstract)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

public abstract class QP001StyleAbstract {

    /**
     * �l�����@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_2_201204 = "7131";
    /**
     * �l�����̓�@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_2_2_201204 = "7132";
    /**
     * �l����O �������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_3_201204 = "7143";
    /**
     * �l����O�̓�@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_3_2_201204 = "7144";
    /**
     * �l����l �������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_4_201204 = "7155";
    /**
     * �l����l�̓� �������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_4_2_201204 = "7156";
    /**
     * �l����� �������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_5_201204 = "7164";
    /**
     * �l����܂̓� �������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_5_2_201204 = "7165";
    /**
     * �l����Z�@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_6_201204 = "7171";
    /**
     * �l����Z�̓�@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_6_2_201204 = "7172";
    /**
     * �l����Z�̎O�@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_6_3_201204 = "7173";
    /**
     * �l����Z�̎l�@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_6_4_201204 = "7174";
    /**
     * �l����Z�̌܁@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_6_5_201204 = "7175";
    /**
     * �l����Z�̘Z�@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_6_6_201204 = "7176";
    /**
     * �l����Z�̎��@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_6_7_201204 = "7177";
    /**
     * �l���掵�@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_7_201204 = "8124";
    /**
     * �l���掵�̓�@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_7_2_201204 = "8125";
    /**
     * �l���攪 �������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_8_201204 = "7183";
    /**
     * �l����� �������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_9_201204 = "7195";
    /**
     * �l����\ �������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_10_201204 = "71A3";

    /**
     * �W�v�������̊m�菈�����s���B
     * 
     * @param patientState
     * @param styles
     * @throws Exception
     */
    abstract public void commitRecords(QP001PatientState patientState,
            VRMap styles, VRMap planUnitMap) throws Exception;

    /**
     * �W�v��������DB�o�^�p��List�ɕϊ�����B
     * 
     * @param patient_id
     * @param targetDate
     * @return
     * @throws Exception
     */
    abstract public VRList getRecords(int patient_id, Date targetDate)
            throws Exception;

    /**
     * �l���ԍ�����������ʔԍ����擾����B
     * 
     * @param claimStyleFormat
     *            �l���ԍ�
     * @param targetDate
     *            �Ώ۔N��
     * @return
     */
    protected static String getIdentificationNo(int claimStyleFormat,
            Date targetDate) {
        // int term = QP001Util.getTerm(targetDate);

        String result = "";
        switch (claimStyleFormat) {
        case QkanConstants.CLAIM_STYLE_FORMAT_2:
            result = IDENTIFICATION_NO_2_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_2_2:
            result = IDENTIFICATION_NO_2_2_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_3:
            result = IDENTIFICATION_NO_3_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_3_2:
            result = IDENTIFICATION_NO_3_2_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_4:
            result = IDENTIFICATION_NO_4_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_4_2:
            result = IDENTIFICATION_NO_4_2_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_5:
            result = IDENTIFICATION_NO_5_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_5_2:
            result = IDENTIFICATION_NO_5_2_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_6:
            result = IDENTIFICATION_NO_6_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_6_2:
            result = IDENTIFICATION_NO_6_2_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_6_3:
            result = IDENTIFICATION_NO_6_3_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_6_4:
            result = IDENTIFICATION_NO_6_4_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_6_5:
            result = IDENTIFICATION_NO_6_5_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_6_6:
            result = IDENTIFICATION_NO_6_6_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_6_7:
            result = IDENTIFICATION_NO_6_7_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_7:
            result = IDENTIFICATION_NO_7_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_7_2:
            result = IDENTIFICATION_NO_7_2_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_8:
            result = IDENTIFICATION_NO_8_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_9:
            result = IDENTIFICATION_NO_9_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_10:
            result = IDENTIFICATION_NO_10_201204;
            break;

        }
        return result;
    }
    
    
    //[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
    public void commitTreatmentImprovement(VRMap detailMap, QP001PatientState patientState, VRMap styles,VRMap planUnitMap) throws Exception {
        
        Map<String, Integer> serviceUnits = new HashMap<String, Integer>();
        Map<String, QP001RecordDetail> detailAdd = new HashMap<String, QP001RecordDetail>();
        
        QP001RecordDetail detail = null;
        Iterator it = detailMap.keySet().iterator();
        while(it.hasNext()) {
            Object key = it.next();
            detail = (QP001RecordDetail)detailMap.get(key);
            
            //�����ŗ��p�ҕ��S�z�����߂邽�߂̒P�ʐ��ςݏグ���s���Ă���
            //���x�z�Ǘ��Ώۃt���O��1(���x�z�Ǘ��Ώ�)�A�܂���3(�O�����p�^)�̏ꍇ
            if (detail.get_301020().equals("1") || detail.get_301020().equals("3")) {
                int unit = 0;
                if (serviceUnits.containsKey(detail.get_301021())) {
                    unit = serviceUnits.get(detail.get_301021());
                }
                unit += detail.get_301014();
                serviceUnits.put(detail.get_301021(), unit);
            }
            
            switch (detail.getServiceAddFlag()) {
            case 3: //���n���Z
                detailAdd.put(detail.get_301021() + "_3", detail);
                break;
            case 6: //���R��
                detailAdd.put(detail.get_301021() + "_6", detail);
                break;
            case 8: //�������P
                //�������P���R�[�h�Ȃ�A�ʂ̃��R�[�h�̒l�����Z
                calcTreatmentImprovement(detailMap, detail);
                definitionTreatmentImprovement(detail);
                detailAdd.put(detail.get_301021() + "_8", detail);
                break;
            }
        }
        
        // ���ȕ��S����
        adjustSelfpay(serviceUnits, detailAdd, styles, planUnitMap, patientState);
        
        // 0�P�ʐ����̃��R�[�h���폜����
        removeEmptyDetail(detailMap);
    }
    
    
    public Map<String, QP001RecordDiagnosis> commitTreatmentImprovement(
            VRMap detailMap, Map<String, QP001RecordDiagnosis> diagnosisMap, 
            QP001PatientState patientState, String[] kohiTypes,
            VRMap styles,VRMap planUnitMap) throws Exception {
        
        Map<String, QP001RecordDiagnosis> diagnosisResult = new TreeMap<String, QP001RecordDiagnosis>();
        Set<String> detailKohiSet = new HashSet<String>();
        
        Map<String, Integer> serviceUnits = new HashMap<String, Integer>();
        Map<String, QP001RecordDetail> detailAdd = new HashMap<String, QP001RecordDetail>();
        
        QP001RecordDetail detail = null;
        Iterator it = detailMap.keySet().iterator();
        while(it.hasNext()) {
            Object key = it.next();
            detail = (QP001RecordDetail)detailMap.get(key);
            
            //���׃��R�[�h�Ŏg�p���������ޔ����Ă���
            Iterator itKohi = detail.getKohiList().keySet().iterator();
            while(itKohi.hasNext()) {
                Object kohiKey = itKohi.next();
                Map kohiData = (Map)detail.getKohiList().get(kohiKey);
                detailKohiSet.add(ACCastUtilities.toString(kohiData.get("KOHI_TYPE")));
            }
            
            
            //�����ŗ��p�ҕ��S�z�����߂邽�߂̒P�ʐ��ςݏグ���s���Ă���
            //���x�z�Ǘ��Ώۃt���O��1(���x�z�Ǘ��Ώ�)�̏ꍇ
            if (detail.get_301020().equals("1")) {
                int unit = 0;
                if (serviceUnits.containsKey(detail.get_301021())) {
                    unit = serviceUnits.get(detail.get_301021());
                }
                unit += detail.get_301014();
                serviceUnits.put(detail.get_301021(), unit);
            }
            
            switch (detail.getServiceAddFlag()) {
            case 3: //���n���Z
                detailAdd.put(detail.get_301021() + "_3", detail);
                break;
            case 6: //���R��
                detailAdd.put(detail.get_301021() + "_6", detail);
                break;
            case 8: //�������P
                //�������P���R�[�h�Ȃ�A�ʂ̃��R�[�h�̒l�����Z
                calcTreatmentImprovement(detailMap, detail);
                detailAdd.put(detail.get_301021() + "_8", detail);
                break;
            }

        }
        
        QP001RecordDiagnosis diagnosis = null; 
        it = diagnosisMap.keySet().iterator();
        
        while (it.hasNext()) {
            diagnosis = diagnosisMap.get(it.next());
            // �쐬��������f�Ô��񃌃R�[�h�̊m�菈�����s���B
            diagnosis.commitRecord(kohiTypes, patientState);
            
            // �V�X�e�����T�[�r�X��ރR�[�h���L�[�ɏ������P���R�[�h������
            // �������P���R�[�h�����݂���΁A�l��ݒ�
            if (detailAdd.containsKey(diagnosis.get_501027() + "_8")) {
                
                detail = detailAdd.get(diagnosis.get_501027() + "_8");
                
                //(�ی�)���v�P�ʐ�8����������
                detail.set_301014(detail.get_301014() + diagnosis.get_501012());
                
                //���׃��R�[�h�œK�p�\�Ȍ���ł��邩�m�F���Ȃ���P�ʐ������Z
                //����̔�r��P�p���A���ʐf�Ô�ɂ�������������������P�Ő�������
                //(����1)���v�P�ʐ�8����������
                detail.set_301015(detail.get_301015() + diagnosis.get_501015());
                //(����2)���v�P�ʐ�8����������
                detail.set_301016(detail.get_301016() + diagnosis.get_501018());
                //(����3)���v�P�ʐ�8����������
                detail.set_301017(detail.get_301017() + diagnosis.get_501021());
                
                /*
                //����1�̎�ނ��r
                if (detailKohiSet.contains(detail.get_301023())) {
                    //(����1)���v�P�ʐ�8����������
                    detail.set_301015(detail.get_301015() + diagnosis.get_501015());
                }
                
                //����2�̎�ނ��r
                if (detailKohiSet.contains(detail.get_301024())) {
                    //(����2)���v�P�ʐ�8����������
                    detail.set_301016(detail.get_301016() + diagnosis.get_501018());
                }
                
                //����3�̎�ނ��r
                if (detailKohiSet.contains(detail.get_301025())) {
                    //(����3)���v�P�ʐ�8����������
                    detail.set_301017(detail.get_301017() + diagnosis.get_501021());
                }
                */
            }
            
            
            // ���ʔԍ����L�[�ɁAMap���č\��
            if (diagnosisResult.containsKey(diagnosis.get_501009())) {
                // �}�[�W
                diagnosisResult.get(diagnosis.get_501009()).merge(diagnosis);
                
            } else {
                // map�֐ݒ�
                diagnosisResult.put(diagnosis.get_501009(), diagnosis);
            }
        }

        
        
        //�V�X�e���T�[�r�X��ނ��Ƃ̓���f�Ô�����������������P�̌v�Z���ʂ��m��
        it = detailAdd.keySet().iterator();
        while (it.hasNext()) {
            String systemServiceKind = (String)it.next();
            //�������P���Z�̏ꍇ
            if (systemServiceKind.endsWith("_8")) {
                detail = detailAdd.get(systemServiceKind);
                // �v�Z���ʂ��m��
                definitionTreatmentImprovement(detail);
            }
        }
        
        // ���ȕ��S����
        adjustSelfpay(serviceUnits, detailAdd, styles, planUnitMap, patientState);
        
        // 0�P�ʐ����̃��R�[�h���폜����
        removeEmptyDetail(detailMap);
        
        // ����f�Ô��񃌃R�[�h�̊m�菈��
        it = diagnosisResult.keySet().iterator();
        int recordCount = 1;
        while (it.hasNext()) {
            diagnosis = diagnosisResult.get(it.next());
            // �쐬��������f�Ô��񃌃R�[�h�̊m�菈�����s���B
            diagnosis.commitRecord(kohiTypes, recordCount, patientState);
            recordCount++;
        }
        if (diagnosis != null) {
            // �W�v���s���B
            diagnosis.commitRecord(diagnosisResult, patientState);
        }
        
        return diagnosisResult;
    }
    
    
    
    private void calcTreatmentImprovement(VRMap detailMap, QP001RecordDetail target) {
        
        QP001RecordDetail detail = null;
        int _301014 = 0; //�T�[�r�X�P�ʐ�6��
        int _301015 = 0; //����1�ΏۃT�[�r�X�P�ʐ�6��
        int _301016 = 0; //����2�ΏۃT�[�r�X�P�ʐ�6��
        int _301017 = 0; //����3�ΏۃT�[�r�X�P�ʐ�6��
        
        Iterator it = detailMap.keySet().iterator();
        while(it.hasNext()) {
            detail = (QP001RecordDetail)detailMap.get(it.next());
            
            //�V�X�e�����T�[�r�X��ރR�[�h���قȂ�Ώ������Ȃ�
            if (!detail.get_301021().equals(target.get_301021())) {
                continue;
            }
            
            //�������P���R�[�h���g�ł���Ώ������Ȃ�
            if (detail.isSyoguRecoed()) {
                continue;
            }
            
            //�e�P�ʐ��̍��Z���擾
            _301014 += detail.get_301014();
            _301015 += detail.get_301015();
            _301016 += detail.get_301016();
            _301017 += detail.get_301017();
        }
        
        //�������P���R�[�h�ɍ��Z�l��ݒ�
        target.set_301014(_301014);
        target.set_301015(_301015);
        target.set_301016(_301016);
        target.set_301017(_301017);
    }
    
    private void definitionTreatmentImprovement(QP001RecordDetail target) throws Exception {
        
        //[ID:0000730][Shin Fujihara] add begin  �y�T�[�r�X���p�[�ʕ\�E���яW�v�z���ȕ��S�������́��n���Z�̌v�Z�ɂ���
        //�������P���Z�̍����P�ʐ���ޔ�
        target.setAdditionBasisUnit(target.get_301014());
        //[ID:0000730][Shin Fujihara] add end
        
        //�T�[�r�X�P�ʐ�6��
        target.set_301014(CareServiceCommon.calcSyogu(target.get_301014(), target.getServiceUnit(), target.getServiceStaffUnit()));
        //�P�ʐ��ɓ]�L
        target.set_301009(target.get_301014());
        
        //����1�ΏۃT�[�r�X�P�ʐ�6��
        target.set_301015(CareServiceCommon.calcSyogu(target.get_301015(), target.getServiceUnit(), target.getServiceStaffUnit()));
        
        //����2�ΏۃT�[�r�X�P�ʐ�6��
        target.set_301016(CareServiceCommon.calcSyogu(target.get_301016(), target.getServiceUnit(), target.getServiceStaffUnit()));
        
        //����3�ΏۃT�[�r�X�P�ʐ�6��
        target.set_301017(CareServiceCommon.calcSyogu(target.get_301017(), target.getServiceUnit(), target.getServiceStaffUnit()));
        
        //[CCCX:1470][Shinobu Hitaka] 2014/02/10 add - start �V���̈ꕔ����Ώۂ̑Ή�
        //����1�`3�ɘV���̈ꕔ����܂܂�Ă���ꍇ
        //���v�P�ʐ�������1�{2�{3�@�̏ꍇ�Ō�̌���ŒP�ʐ��𒲐�����
        Iterator itKohi = target.getKohiList().keySet().iterator();
        String[] kohiTypes = new String[3];
        int count = 0;
        while(itKohi.hasNext()) {
            Object kohiKey = itKohi.next();
            Map kohiData = (Map)target.getKohiList().get(kohiKey);
            kohiTypes[count] = ACCastUtilities.toString(kohiData.get("KOHI_TYPE"));
            count++;
            if (count > kohiTypes.length - 1)
                break;
        }
        String systemServiceKindDetail = ACCastUtilities.toString(target.get_301021());
        if (CareServiceCommon.isKouhiSystemService(systemServiceKindDetail, kohiTypes[0]) ||
            CareServiceCommon.isKouhiSystemService(systemServiceKindDetail, kohiTypes[1]) ||
            CareServiceCommon.isKouhiSystemService(systemServiceKindDetail, kohiTypes[2])
            ) {
            
            //����1��10�����ǂ��K�p����Ă���ꍇ�A�����ǌ���ȊO�̒P�ʐ��𒲐�����
            if ("1001".equals(target.get_301023()) && target.get_301015() > 0) {
                if (target.get_301017() != 0) {
                    target.set_301017(target.get_301014() - target.get_301016());
                }
            } else {
                if (target.get_301014() < (target.get_301015() + target.get_301016() + target.get_301017())) {
                    if (target.get_301017() != 0) {
                        target.set_301017(target.get_301014() - (target.get_301015() + target.get_301016()));
                    } else if (target.get_301016() != 0) {
                        target.set_301016(target.get_301014() - target.get_301015());
                    } else if (target.get_301015() != 0) {
                        target.set_301015(target.get_301014());
                    }
                }
            }
        }
        //[CCCX:1470][Shinobu Hitaka] 2014/02/10 add - end   �V���̈ꕔ����Ώۂ̑Ή�
        
        // ����1��
        if (0 < target.get_301015()) {
            target.set_301011(1);
        }
        // ����2��
        if (0 < target.get_301016()) {
            target.set_301012(1);
        }
        // ����3��
        if (0 < target.get_301017()) {
            target.set_301013(1);
        }
        
    }
    
    
    private void adjustSelfpay(Map<String, Integer> serviceUnits, Map<String, QP001RecordDetail> detailAdd, VRMap styles,
            VRMap planUnitMap, QP001PatientState patientState) throws Exception {
        
        QP001RecordDetail detail = null;
        
        Iterator<String> unitIt = serviceUnits.keySet().iterator();
        while(unitIt.hasNext()) {
            String systemServiceKind = unitIt.next();
            
            int serviceUnit = serviceUnits.get(systemServiceKind);
            
            int stackedSelfUnit = 0;
            int selfPay = Integer.MIN_VALUE;
            
            //�ȉ��̏��ԂŌv�Z���Ă���
            
            //���n���Z���Z�肵�Ă���ꍇ
            if (detailAdd.containsKey(systemServiceKind + "_3")) {
                detail = detailAdd.get(systemServiceKind + "_3");
                
                selfPay = getSelfpay(styles, patientState, planUnitMap, detail, serviceUnit, selfPay);
                //���ȕ��S���������Ă��Ȃ��ꍇ�͏����I��
                if (selfPay == 0) {
                    continue;
                }
                
                int unit = getSelfpayUnit(detail, selfPay, stackedSelfUnit, serviceUnit);
                stackedSelfUnit += unit;
                
                //���ȕ��S��������
                removeSelfPay(detail, unit);
                
                //����������S�z���ȕ��S��
                patientState.putAddSelfpay(detail.get_301007(), unit);
            }
            
            
            //���R�ԉ��Z���Z�肵�Ă���ꍇ
            if (detailAdd.containsKey(systemServiceKind + "_6")) {
                detail = detailAdd.get(systemServiceKind + "_6");
                
                selfPay = getSelfpay(styles, patientState, planUnitMap, detail, serviceUnit, selfPay);
                //���ȕ��S���������Ă��Ȃ��ꍇ�͏����I��
                if (selfPay == 0) {
                    continue;
                }
                
                int unit = getSelfpayUnit(detail, selfPay, stackedSelfUnit, serviceUnit);
                stackedSelfUnit += unit;
                
                //���ȕ��S��������
                removeSelfPay(detail, unit);
                
                //����������S�z���ȕ��S��
                patientState.putAddSelfpay(detail.get_301007(), unit);
            }
            
            //�������P���Z���Z�肵�Ă���ꍇ
            if (detailAdd.containsKey(systemServiceKind + "_8")) {
                detail = detailAdd.get(systemServiceKind + "_8");
                
                selfPay = getSelfpay(styles, patientState, planUnitMap, detail, serviceUnit, selfPay);
                //���ȕ��S���������Ă��Ȃ��ꍇ�͏����I��
                if (selfPay == 0) {
                    continue;
                }
                
                int unit = getSelfpayUnit(detail, selfPay, stackedSelfUnit, serviceUnit);
                stackedSelfUnit += unit;
                
                //���ȕ��S��������
                removeSelfPay(detail, unit);
                
                //����������S�z���ȕ��S��
                patientState.putAddSelfpay(detail.get_301007(), unit);
            }
            
        }
    }
    
    private void removeSelfPay(QP001RecordDetail detail, int unit) throws Exception {
        //�T�[�r�X�P�ʐ�������
        detail.set_301014(detail.get_301014() - unit);
        //�P�ʐ��ɓ]�L
        detail.set_301009(detail.get_301014());
        
        //����1�ΏۃT�[�r�X�P�ʐ�6��
        if (detail.get_301009() < detail.get_301015()) {
            detail.set_301015(detail.get_301009());
        }
        //����2�ΏۃT�[�r�X�P�ʐ�6��
        if (detail.get_301009() < detail.get_301016()) {
            detail.set_301016(detail.get_301009());
        }
        //����3�ΏۃT�[�r�X�P�ʐ�6��
        if (detail.get_301009() < detail.get_301017()) {
            detail.set_301017(detail.get_301009());
        }
    }
    
    
    private int getSelfpayUnit(QP001RecordDetail detail,int selfPay, int stackedSelfUnit, int serviceUnit) throws Exception {
        
        //[ID:0000730][Shin Fujihara] edit begin  �y�T�[�r�X���p�[�ʕ\�E���яW�v�z���ȕ��S�������́��n���Z�̌v�Z�ɂ���
        /*
        //���ȕ��S���̒P�ʐ�
        int unit = 0;
        
        if (detail.isSyoguRecoed()) {
            unit = CareServiceCommon.calcSyogu((selfPay + stackedSelfUnit), detail.getServiceUnit(), detail.getServiceStaffUnit());
        } else {
            unit = (int) Math.round((double) ((selfPay + stackedSelfUnit) * detail.getServiceUnit()) / 100d);
        }
        */
        
        //���������Z�̒P�ʐ�
        int unit = 0;
        
        if (detail.isSyoguRecoed()) {
            unit = CareServiceCommon.calcSyogu(detail.getAdditionBasisUnit() - selfPay - stackedSelfUnit, detail.getServiceUnit(), detail.getServiceStaffUnit());
        } else {
            unit = (int) Math.round((double) ( (detail.getAdditionBasisUnit() - selfPay - stackedSelfUnit) * detail.getServiceUnit()) / 100d);
        }
        
        return detail.get_301014() - unit;
        //[ID:0000730][Shin Fujihara] edit end
    }
    
    
    /**
     * ���ȕ��S�̒P�ʐ����擾����
     * @return
     * @throws Exception
     */
    private int getSelfpay(VRMap styles, QP001PatientState patientState, VRMap planUnitMap, QP001RecordDetail detail, int serviceUnit, int selfPay) throws Exception {
        
        if (selfPay != Integer.MIN_VALUE) {
            return selfPay;
        }
        
        int planUnit = 0;
        
        //[�l����Z�̎O]�F����{�ݓ����Ґ������(�Z�����p�ȊO)�A�n�斧���^����{�ݓ����Ґ������(�Z�����p�ȊO)
        //[�l����Z�̎l]�F���\�h����{�ݓ����Ґ������
        if ("13311".equals(detail.get_301021())
            || "13511".equals(detail.get_301021())
            || "13611".equals(detail.get_301021())) {
            planUnit = ACCastUtilities.toInt(patientState.getNinteiDataHeavy(detail.get_301005(),detail.get_301006(),"EXTERNAL_USE_LIMIT"),0);
            
            //���ȕ��S���������Ă��Ȃ��ꍇ�͏����I��
            if (serviceUnit <= planUnit) {
                return 0;
            } else {
                 return (serviceUnit - planUnit);
            }
        }
        
        
        //���ѓo�^��ʂœ��͂��ꂽ�v��P�ʐ����Q�Ƃ���B
        if(planUnitMap != null){
            String key = "10" + detail.get_301007();
            // 10 + �T�[�r�X��ރR�[�h�̃L�[�����݂��邩�m�F
            if(planUnitMap.containsKey(key)){
                planUnit = ACCastUtilities.toInt(planUnitMap.get(key),0);
                
                if(planUnit != 0){
                    //���ȕ��S���������Ă��Ȃ��ꍇ�͏����I��
                    if (serviceUnit <= planUnit) {
                        return 0;
                    } else {
                        return (serviceUnit - planUnit);
                    }
                }
            }
        }
        
        //���ѓo�^��ʂŌv��P�ʐ��̓��͂������ꍇ�A�\��̃f�[�^�����ɍs��
        
        if(styles == null) return planUnit;
        
        Iterator it = styles.keySet().iterator();
        while(it.hasNext()){
            QP001StyleAbstract style = (QP001StyleAbstract)styles.get(it.next());
            if(style instanceof QP001Style11){
                QP001Style11 target = (QP001Style11)style;
                
                Map supplyMap = (Map)target.getSupplyMap();
                
                Iterator supplyIt = supplyMap.keySet().iterator();
                while(supplyIt.hasNext()){
                    QP001RecordSupply supply = (QP001RecordSupply)supplyMap.get(supplyIt.next());
                  //���Ə��ԍ��ƕی��Ҕԍ�,��ی��Ҕԍ��ƃT�[�r�X��ރR�[�h�����������̂�T��
                  if(String.valueOf(supply.get_1201017()).equals(detail.get_301004())
                          && (String.valueOf(supply.get_1201003()).equals(detail.get_301005()))
                          && (String.valueOf(supply.get_1201009()).equals(detail.get_301006()))
                          && (String.valueOf(supply.get_1201019()).equals(detail.get_301007()))){
                      planUnit = supply.get_1201020();
                      break;
                  }
                }
            }
        }
        
        //�v��P�ʐ����擾�ł��Ȃ������ꍇ�́A���ȕ��S��������
        if (planUnit == 0) {
            return 0;
        }
        
        //���тƔ�r���A���ȕ��S���������Ă��Ȃ��ꍇ�͏����I��
        if (serviceUnit <= planUnit) {
            return 0;
        }
        
        return (serviceUnit - planUnit);
        
    }
    
    // �P�ʐ����ݒ肳��Ă���A�����ɗL���ȃ��R�[�h�ł��邩���肷��
    // [ID:0000715]�Ή�
    private void removeEmptyDetail(VRMap detailMap) throws Exception {
        
        List<Object> removeTarget = new ArrayList<Object>();
        
        QP001RecordDetail detail = null;
        Iterator it = detailMap.keySet().iterator();
        while(it.hasNext()) {
            Object key = it.next();
            detail = (QP001RecordDetail)detailMap.get(key);
            
            switch (detail.getServiceAddFlag()) {
            case 3: //���n���Z
            case 6: //���R��
            case 8: //�������P
                if (detail.get_301014() <= 0) {
                    removeTarget.add(key);
                }
                break;
            }
        }
        
        for (Object key : removeTarget) {
            detailMap.remove(key);
        }
    }
    //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
    
    //[ID:0000721][Shin Fujihara] 2012/04 add start 2012�N�x�Ή�
    //�Ŏ��E�^�[�~�i�����Z�̓E�v���]�L���l�����Ȃ���̖��׊m�菈��
    //�l����Z�A��Z�̎O�A�攪�A���Ŏg�p
    public void commitDetails(VRMap detailMap, String[] kohiTypes, QP001PatientState patientState) throws Exception {
        
        Map<String, String> mitoriTekiyo = new HashMap<String, String>();
        Map<String, List<QP001RecordDetail>> copyTarget = new HashMap<String, List<QP001RecordDetail>>();
        
        //�E�v���̃R�s�[�ΏۃT�[�r�X�R�[�h
        Set<String> copyTargetList = new HashSet<String>();
        copyTargetList.add("516276"); //�����{�݊Ŏ������Z�P
        copyTargetList.add("516277"); //�����{�݊Ŏ������Z�Q
        copyTargetList.add("546276"); //�n�����{�݊Ŏ������Z�P
        copyTargetList.add("546277"); //�n�����{�݊Ŏ������Z�Q
        copyTargetList.add("526600"); //�ی��{�݃^�[�~�i���P�A���Z�P�P
        copyTargetList.add("526001"); //�ی��{�݃^�[�~�i���P�A���Z�P�Q
        copyTargetList.add("526602"); //�ی��{�݃^�[�~�i���P�A���Z�Q�P
        copyTargetList.add("526002"); //�ی��{�݃^�[�~�i���P�A���Z�Q�Q
        copyTargetList.add("326142"); //�F�m�ǑΉ��^�Ŏ������Z�P
        copyTargetList.add("326143"); //�F�m�ǑΉ��^�Ŏ������Z�Q
        copyTargetList.add("336125"); //����{�݊Ŏ������Z�P
        copyTargetList.add("336126"); //����{�݊Ŏ������Z�Q
        copyTargetList.add("366125"); //�n�����{�݊Ŏ������Z�P
        copyTargetList.add("366126"); //�n�����{�݊Ŏ������Z�Q 
        
        QP001RecordDetail detail = null;
        // ���׏�񃌃R�[�h�̊m�菈��
        Iterator it = detailMap.keySet().iterator();
        
        while (it.hasNext()) {
            // �쐬�������׏�񃌃R�[�h�̊m����s���B
            detail = (QP001RecordDetail) detailMap.get(it.next());
            detail.commitRecord(kohiTypes,patientState);
            
            
            
            //�E�v���Ɏ��S�����ݒ肳��Ă���T�[�r�X�R�[�h�ł��邩�m�F
            if (QP001SpecialCase.isMitori(detail.get_301007(), detail.get_301008())) {
                //�Y���R�[�h�ł���΁A�T�[�r�X��ރR�[�h���L�[�ɁA�E�v���̓��e��ޔ����Ă���
                if (!ACTextUtilities.isNullText(detail.get_301018())){
                    mitoriTekiyo.put(detail.get_301007(), detail.get_301018());
                }
            }
            
            //�]�L�Ώۂ̃��R�[�h�ł���΁A�ޔ����Ă���
            String serviceCode = detail.get_301007() + detail.get_301008();
            if (copyTargetList.contains(serviceCode)) {
                List<QP001RecordDetail> detailList = null;
                if (copyTarget.containsKey(detail.get_301007())) {
                    detailList = copyTarget.get(detail.get_301007());
                } else {
                    detailList = new ArrayList<QP001RecordDetail>();
                    copyTarget.put(detail.get_301007(), detailList);
                }
                detailList.add(detail);
            }
        }
        
        it = mitoriTekiyo.keySet().iterator();
        while(it.hasNext()) {
            String key = (String)it.next();
            
            if (!copyTarget.containsKey(key)) {
                continue;
            }
            
            String tekiyo = mitoriTekiyo.get(key);
            List<QP001RecordDetail> list = copyTarget.get(key);
            for (QP001RecordDetail row : list) {
                row.set_301018(tekiyo);
            }
            
        }
    }
    //[ID:0000721][Shin Fujihara] 2012/04 add end 2012�N�x�Ή�

}
