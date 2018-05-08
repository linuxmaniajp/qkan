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
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.print.schedule.SelfPaymentNumberCalcurater;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

public abstract class QP001StyleAbstract {

// 2016/7/12 [Yoichiro Kamei] add - begin �������ƑΉ�
    /**
     * �l�����̓�@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_1_2_201504 = "7113";
// 2016/7/12 [Yoichiro Kamei] add - end

    /**
     * �l�����@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_2_201204 = "7131";
    /**
     * �l�����̓�@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_2_2_201204 = "7132";
// [H27.4�����Ή�][Shinobu Hitaka] 2016/7/8 add - begin �������ƑΉ�
    /**
     * �l�����̎O�@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_2_3_201504 = "71R1";
// [H27.4�����Ή�][Shinobu Hitaka] 2016/7/8 add - end
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
    // [H30.4�����Ή�][Shinobu Hitaka] 2018/3/27 add - begin 
    /**
     * �l����l�̎O �������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_4_3_201804 = "7157";
    /**
     * �l����l�̎l �������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_4_4_201804 = "7158";
    // [H30.4�����Ή�][Shinobu Hitaka] 2016/7/8 add - end
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
     * �l���掵�̎O�@�������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_7_3_201504 = "8171";	// 2017.6 add
    /**
     * �l���攪 �������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_8_201204 = "7183";
    /**
     * �l����� �������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_9_201204 = "7195";
    // [H30.4�����Ή�][Shinobu Hitaka] 2018/3/27 add - begin 
    /**
     * �l�����̓� �������ʔԍ�
     */
    protected static final String IDENTIFICATION_NO_9_2_201804 = "7196";
    // [H30.4�����Ή�][Shinobu Hitaka] 2016/7/8 add - end
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
        case QkanConstants.CLAIM_STYLE_FORMAT_2_3:	// [H27.4�����Ή�][Shinobu Hitaka] 2016/7/8 add �������ƑΉ�
            result = IDENTIFICATION_NO_2_3_201504;
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
        case QkanConstants.CLAIM_STYLE_FORMAT_4_3:	// [H30.4�����Ή�][Shinobu Hitaka] 2018/3/27 add
            result = IDENTIFICATION_NO_4_3_201804;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_4_4:	// [H30.4�����Ή�][Shinobu Hitaka] 2018/3/27 add
            result = IDENTIFICATION_NO_4_4_201804;
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
        case QkanConstants.CLAIM_STYLE_FORMAT_7_3:	// 2017/6 add AF�Ή�
            result = IDENTIFICATION_NO_7_3_201504;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_8:
            result = IDENTIFICATION_NO_8_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_9:
            result = IDENTIFICATION_NO_9_201204;
            break;
        case QkanConstants.CLAIM_STYLE_FORMAT_9_2:	// [H30.4�����Ή�][Shinobu Hitaka] 2018/3/27 add
            result = IDENTIFICATION_NO_9_2_201804;
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
            
            // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
            if (detail.isSelfPaymentNumberAddRecord()) {
                if (detail instanceof QP001RecordDetailJushotiTokurei) {
                    detailAdd.put(detail.get_301021() + "_2_jusho", detail);
                } else {
                    detailAdd.put(detail.get_301021() + "_2", detail);
                }
            }
            // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - end
        }
        
        // ���ȕ��S����
        adjustSelfpay(serviceUnits, detailAdd, styles, planUnitMap, patientState);
        
        // 0�P�ʐ����̃��R�[�h���폜����
        removeEmptyDetail(detailMap);
    }
    
    
    public Map<String, QP001RecordDiagnosis> commitTreatmentImprovement(
            VRMap detailMap, Map<String, QP001RecordDiagnosis> diagnosisMap, 
            QP001PatientState patientState, QP001KohiKey[] kohiTypes,
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

            // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
            if (detail.isSelfPaymentNumberAddRecord()) {
            	detailAdd.put(detail.get_301021() + "_2", detail);
            }
            // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - end
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
        
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/11 mod - begin
        //���r������̏ꍇ�Ɍ���ΏےP�ʐ������������ꍇ�����邽�ߏC��
//        target.set_301014(_301014);
//        target.set_301015(_301015);
//        target.set_301016(_301016);
//        target.set_301017(_301017);
        //����Ή��łŌv�Z�����ΏےP�ʐ�����L�v�Z���ʂƓ����ꍇ�́A�����̌v�Z�����Ȃ�
        if (target.getAdditionBasisUnit() == _301014) {
        	target.setSyoguCalcOriginal(false);
        }
        if (target.isSyoguCalcOriginal()) {
            //�������P���R�[�h�ɍ��Z�l��ݒ�
            target.set_301014(_301014);
            target.set_301015(_301015);
            target.set_301016(_301016);
            target.set_301017(_301017);
        }
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/11 mod - begin
    }
    
    private void definitionTreatmentImprovement(QP001RecordDetail target) throws Exception {
        
    	// [H30.4�����Ή�][Yoichiro Kamei] 2018/4/11 mod - begin
        // ���r������̏ꍇ�Ɍ���ΏےP�ʐ������������ꍇ�����邽�ߏC��
        if (target.isSyoguCalcOriginal()) {
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/11 mod - end
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
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/11 mod - begin
        }
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/11 mod - end
        
        //[CCCX:1470][Shinobu Hitaka] 2014/02/10 add - start �V���̈ꕔ����Ώۂ̑Ή�
        //����1�`3�ɘV���̈ꕔ����܂܂�Ă���ꍇ
        //���v�P�ʐ�������1�{2�{3�@�̏ꍇ�Ō�̌���ŒP�ʐ��𒲐�����
        
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//        Iterator itKohi = target.getKohiList().keySet().iterator();
        String[] kohiTypes = new String[3];
//        int count = 0;
//        while(itKohi.hasNext()) {
//            Object kohiKey = itKohi.next();
//            Map kohiData = (Map)target.getKohiList().get(kohiKey);
//            kohiTypes[count] = ACCastUtilities.toString(kohiData.get("KOHI_TYPE"));
//            count++;
//            if (count > kohiTypes.length - 1)
//                break;
//        }
        List<QP001KohiKey> kohiKeyList = new ArrayList(target.getKohiList().keySet());
        //����D�揇�ɕ��ёւ�
        Collections.sort(kohiKeyList);
        int index = 0;
        for (QP001KohiKey kohiKey : kohiKeyList) {
            kohiTypes[index++] = kohiKey.getKohiType();
            //�R�܂�
            if (index == kohiTypes.length) {
                break;
            }
        }
// 2015/5/12 [Yoichiro Kamei] mod - end
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
// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/20 mod - begin
// ���x�z���߂̏ꍇ�A���n���Z�A���R�Ԓn�擙�񋟉��Z�͂��ׂĕی������Ɋ܂߂�
//            //���n���Z���Z�肵�Ă���ꍇ
//            if (detailAdd.containsKey(systemServiceKind + "_3")) {
//                detail = detailAdd.get(systemServiceKind + "_3");
//                
//                selfPay = getSelfpay(styles, patientState, planUnitMap, detail, serviceUnit, selfPay);
//                //���ȕ��S���������Ă��Ȃ��ꍇ�͏����I��
//                if (selfPay == 0) {
//                    continue;
//                }
//                
//                int unit = getSelfpayUnit(detail, selfPay, stackedSelfUnit, serviceUnit);
//                stackedSelfUnit += unit;
//                
//                //���ȕ��S��������
//                removeSelfPay(detail, unit);
//                
//                //����������S�z���ȕ��S��
//                patientState.putAddSelfpay(detail.get_301007(), unit);
//            }
//            
//            
//            //���R�ԉ��Z���Z�肵�Ă���ꍇ
//            if (detailAdd.containsKey(systemServiceKind + "_6")) {
//                detail = detailAdd.get(systemServiceKind + "_6");
//                
//                selfPay = getSelfpay(styles, patientState, planUnitMap, detail, serviceUnit, selfPay);
//                //���ȕ��S���������Ă��Ȃ��ꍇ�͏����I��
//                if (selfPay == 0) {
//                    continue;
//                }
//                
//                int unit = getSelfpayUnit(detail, selfPay, stackedSelfUnit, serviceUnit);
//                stackedSelfUnit += unit;
//                
//                //���ȕ��S��������
//                removeSelfPay(detail, unit);
//                
//                //����������S�z���ȕ��S��
//                patientState.putAddSelfpay(detail.get_301007(), unit);
//            }
// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/20 mod - end
            
            // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
            //���ȕ��S�Ώۂ̉񐔉��Z���Z�肵�Ă���ꍇ
            if (detailAdd.containsKey(systemServiceKind + "_2")) {
                detail = detailAdd.get(systemServiceKind + "_2");
                
                selfPay = getSelfpay(styles, patientState, planUnitMap, detail, serviceUnit, selfPay);
                //���ȕ��S���������Ă��Ȃ��ꍇ�͏����I��
                if (selfPay == 0) {
                    continue;
                }
                stackedSelfUnit += adjustSelfPaymentNumberAddRecord(patientState, detail, selfPay);
            }
            if (detailAdd.containsKey(systemServiceKind + "_2_jusho")) {
                detail = detailAdd.get(systemServiceKind + "_2_jusho");
                
                selfPay = getSelfpay(styles, patientState, planUnitMap, detail, serviceUnit, selfPay);
                //���ȕ��S���������Ă��Ȃ��ꍇ�͏����I��
                if (selfPay == 0) {
                    continue;
                }
                stackedSelfUnit += adjustSelfPaymentNumberAddRecord(patientState, detail, selfPay);
            }
            // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - end
            
            
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
    
 // [H27.4�����Ή�][Yoichiro Kamei] 2015/5/22 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
    private int adjustSelfPaymentNumberAddRecord(QP001PatientState patientState, QP001RecordDetail detail, int selfPay) throws Exception {
        
        SelfPaymentNumberCalcurater calc = patientState.getSelfPaymentNumberCalcurater();
        String providerId = detail.get_301004();
        if (detail instanceof QP001RecordDetailJushotiTokurei) {
            calc.parseServiceCodeForSeikyuJushotiTokurei(detail.getSelfPaymentNumberAddCode(), providerId, selfPay, patientState);
        } else {
            calc.parseServiceCodeForSeikyu(detail.getSelfPaymentNumberAddCode(), providerId, selfPay, patientState);
        }
        
        int unit = calc.getSelfPayUnit();
        int limitInNumber = calc.getLimitInNumber();
        int reductedUnit = calc.getReductedUnit();
        
        //�񐔂��敪�x�����x���Ƃ��Ẳ񐔂ɐݒ�
        detail.set_301010(limitInNumber);
        
        //�����(��L�񐔎��_�̌���K�p�����E�񐔁j

        //����1�Ώۓ����E��2��
        detail.set_301011(detail.getKohiCountAtTime(detail.get_301023(), limitInNumber));
        
        //����2�Ώۓ����E��2��
        detail.set_301012(detail.getKohiCountAtTime(detail.get_301024(), limitInNumber));
        
        //����3�Ώۓ����E��2��
        detail.set_301013(detail.getKohiCountAtTime(detail.get_301025(), limitInNumber));
        
        //����񐔂̒���
        
        //����1�Ώۓ����E��2��
        if (detail.get_301010() < detail.get_301011()) {
            detail.set_301011(detail.get_301010());
        }
        //����2�Ώۓ����E��2��
        if (detail.get_301010() < detail.get_301012()) {
            detail.set_301012(detail.get_301010());
        }
        //����3�Ώۓ����E��2��
        if (detail.get_301010() < detail.get_301013()) {
            detail.set_301013(detail.get_301010());
        }

        //�P�ʐ�
        detail.set_301009(reductedUnit);
        
        //�T�[�r�X�P�ʐ�
        detail.set_301014(detail.get_301009() * detail.get_301010());
        
        //����1�ΏۃT�[�r�X�P�ʐ�6��
        detail.set_301015(detail.get_301009() * detail.get_301011());
        //����2�ΏۃT�[�r�X�P�ʐ�6��
        detail.set_301016(detail.get_301009() * detail.get_301012());
        //����3�ΏۃT�[�r�X�P�ʐ�6��
        detail.set_301017(detail.get_301009() * detail.get_301013());

        
        //����������S�z���ȕ��S��
        patientState.putAddSelfpay(detail.get_301007(), unit);   
        
        return unit;
    }
 // [H27.4�����Ή�][Yoichiro Kamei] 2015/5/22 add - end
    
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
// 2016/7/15 [Yoichiro Kamei] mod - begin �������ƑΉ�
//        // 10 + �T�[�r�X��ރR�[�h�̃L�[�����݂��邩�m�F
//            String key = "10" + detail.get_301007();
            String key = CareServiceCommon.getPlanUnitBindPath(detail.get_301007());
// 2016/7/15 [Yoichiro Kamei] mod - end
            
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
// 2016/10/18 [Yoichiro Kamei] del - begin �������ƑΉ�
// �\��Ǎ����Ɍv��P�ʐ���ݒ肷��悤�ύX�������߁A�\��̃f�[�^�͌��Ȃ�
//        //���ѓo�^��ʂŌv��P�ʐ��̓��͂������ꍇ�A�\��̃f�[�^�����ɍs��
//        
//        if(styles == null) return planUnit;
//        
//        Iterator it = styles.keySet().iterator();
//        while(it.hasNext()){
//            QP001StyleAbstract style = (QP001StyleAbstract)styles.get(it.next());
//            if(style instanceof QP001Style11){
//                QP001Style11 target = (QP001Style11)style;
//                
//                Map supplyMap = (Map)target.getSupplyMap();
//                
//                Iterator supplyIt = supplyMap.keySet().iterator();
//                while(supplyIt.hasNext()){
//                    QP001RecordSupply supply = (QP001RecordSupply)supplyMap.get(supplyIt.next());
//                  //���Ə��ԍ��ƕی��Ҕԍ�,��ی��Ҕԍ��ƃT�[�r�X��ރR�[�h�����������̂�T��
//                  if(String.valueOf(supply.get_1201017()).equals(detail.get_301004())
//                          && (String.valueOf(supply.get_1201003()).equals(detail.get_301005()))
//                          && (String.valueOf(supply.get_1201009()).equals(detail.get_301006()))
//                          && (String.valueOf(supply.get_1201019()).equals(detail.get_301007()))){
//                      planUnit = supply.get_1201020();
//                      break;
//                  }
//                }
//            }
//        }
// 2016/10/18 [Yoichiro Kamei] del - end
        
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
//[CCCX:2815][Yoichiro Kamei] add - begin �񐔒����Ń[���P�ʂƂȂ��������폜
            if (detail.isSelfPaymentNumberAddRecord()) {
                // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/20 mod - begin
                // ���Z�̃R�[�h������č폜����Ă��܂����ߏC��
//                if (detail.get_301014() <= 0) {
                if (detail.get_301014() == 0) {
                // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/20 mod - end
                    removeTarget.add(key);
                }
            }
//[CCCX:2815][Yoichiro Kamei] add - end
        }
        
        for (Object key : removeTarget) {
            detailMap.remove(key);
        }
    }
    //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
    
    //[ID:0000721][Shin Fujihara] 2012/04 add start 2012�N�x�Ή�
    //�Ŏ��E�^�[�~�i�����Z�̓E�v���]�L���l�����Ȃ���̖��׊m�菈��
    //�l����Z�A��Z�̎O�A�攪�A���Ŏg�p
    public void commitDetails(VRMap detailMap, QP001KohiKey[] kohiTypes, QP001PatientState patientState) throws Exception {
        
        Map<String, String> mitoriTekiyo = new HashMap<String, String>();
        Map<String, List<QP001RecordDetail>> copyTarget = new HashMap<String, List<QP001RecordDetail>>();
        
        //�E�v���̃R�s�[�ΏۃT�[�r�X�R�[�h
        Set<String> copyTargetList = new HashSet<String>();
        // [H30.4�����Ή�][Shinobu Hitaka] 2018/4/14 del - begin ���S���ԁE�ꏊ�L�ڂ֕ύX
        //copyTargetList.add("516276"); //�����{�݊Ŏ������Z�P
        //copyTargetList.add("516277"); //�����{�݊Ŏ������Z�Q
        //copyTargetList.add("516284"); //�����{�݊Ŏ������ZII�P // 2018.04 add
        //copyTargetList.add("516285"); //�����{�݊Ŏ������ZII�Q // 2018.04 add
        //copyTargetList.add("546276"); //�n�����{�݊Ŏ������Z�P
        //copyTargetList.add("546277"); //�n�����{�݊Ŏ������Z�Q
        //copyTargetList.add("546284"); //�n�����{�݊Ŏ������ZII�P // 2018.04 add
        //copyTargetList.add("546285"); //�n�����{�݊Ŏ������ZII�Q // 2018.04 add
        // [H30.4�����Ή�][Shinobu Hitaka] 2018/4/14 del - end
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

// 2015/5/12 [Yoichiro Kamei] add - begin ����֘A������
    //����D�揇�ɏ]���A�K�p�Ώۂ̌�����R�܂Ŏ擾
    protected QP001KohiKey[] getKohiApplyArray(List<Map> recordsList) {
        QP001KohiKey[] kohiTypes = new QP001KohiKey[3];
        Map<QP001KohiKey, Object> kohiListAll = new HashMap<QP001KohiKey, Object>();
        
        for (Map records : recordsList) {
            for (Object record : records.values()) {
                //���׏�񃌃R�[�h
                if (record instanceof QP001RecordDetail) {
                    Map kohiListMap = ((QP001RecordDetail) record).getKohiList();
                    kohiListAll.putAll(kohiListMap);
                }
                //��������҃��R�[�h
                else if (record instanceof QP001RecordNursing) {
                    Map kohiListMap = ((QP001RecordNursing) record).getKohiList();
                    kohiListAll.putAll(kohiListMap);
                }
                //����f�Ô�R�[�h
                else if (record instanceof QP001RecordDiagnosis) {
                    Map kohiListMap = ((QP001RecordDiagnosis) record).getKohiList();
                    kohiListAll.putAll(kohiListMap);
                }
            }
        }
        
        List<QP001KohiKey> kohiKeyList = new ArrayList(kohiListAll.keySet());
        //����D�揇�ɕ��ёւ�
        Collections.sort(kohiKeyList);
        int index = 0;
        for (QP001KohiKey kohiKey : kohiKeyList) {
            kohiTypes[index++] = kohiKey;
            //�R�܂�
            if (index == kohiTypes.length) {
                break;
            }
        }
        return kohiTypes;
    }
// 2015/5/12 [Yoichiro Kamei] add - end
    
    // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/10 add - begin
    /**
     * %���Z�E%���Z�̒P�ʐ��m�菈�����s���܂��B�i��Ɍ���ΏےP�ʐ��j
     * @param detailMap
     * @param kohi QP001KohiKey[]
     * @throws Exception
     */
    public void commitParcentageAddRecord(VRMap detailMap, QP001KohiKey[] kohiTypes) throws Exception {
        Map<String, QP001RecordDetail> detailAdd_5 = new HashMap<String, QP001RecordDetail>();
        Map<String, QP001RecordDetail> detailAdd_7 = new HashMap<String, QP001RecordDetail>();
        Map<String, QP001RecordDetail> detailAdd_3 = new HashMap<String, QP001RecordDetail>();
        Map<String, QP001RecordDetail> detailAdd_6 = new HashMap<String, QP001RecordDetail>();
        Map<String, QP001RecordDetail> detailAdd_8 = new HashMap<String, QP001RecordDetail>();
        
        //%���Z�E%���Z�̃T�[�r�X�R�[�h���Ƃɏڍ׃��R�[�h�̉��Z��񃊃X�g��ێ�����}�b�v
        Map<String, List<QP001PercentageAddInfo>> addInfoMap = new HashMap<String, List<QP001PercentageAddInfo>>();
        //���Z��ʂ��Ƃɕ�����
    	Iterator it = detailMap.keySet().iterator();
        while (it.hasNext()) {
        	QP001RecordDetail detail = (QP001RecordDetail) detailMap.get(it.next());
            int serviceAddFlag = detail.getServiceAddFlag();
            String serviceCode = detail.get_301007() + detail.get_301008();
            switch (serviceAddFlag) {
            case 3: //���ʒn����Z
            	detailAdd_3.put(serviceCode, detail);
                break;
            case 6: //���R�Ԓn�擙�񋟉��Z
            	detailAdd_6.put(serviceCode, detail);
                break;
            case 5: //�����^���Z
            	detailAdd_5.put(serviceCode, detail);
                break;
            case 7: //���ꌚ�����Z
            	detailAdd_7.put(serviceCode, detail);
                break;
            case 8: //�������P���Z
            	detailAdd_8.put(serviceCode, detail);
                break;
            default: //�ʏ탌�R�[�h
            	//%���Z�̑ΏۂƂȂ�����擾���āA�T�[�r�X�R�[�h���ƂɊi�[
            	QP001PercentageAddInfo addInfo = detail.getPercentageAddInfo();
            	for (String svCode : addInfo.getHoldSvCodeSet()) {
            		if (!addInfoMap.containsKey(svCode)) {
            			addInfoMap.put(svCode, new ArrayList<QP001PercentageAddInfo>());
            		}
            		addInfoMap.get(svCode).add(addInfo);
            	}
            }
        }
        
        
        //�P�ʐ��̌v�Z
        // �����^���Z
        calcParcentageAddRecord(kohiTypes, addInfoMap, detailAdd_5);
        // ���ꌚ�����Z
        calcParcentageAddRecord(kohiTypes, addInfoMap, detailAdd_7);
        // ���ʒn����Z
        calcParcentageAddRecord(kohiTypes, addInfoMap, detailAdd_3);
        // ���R�Ԓn�擙�񋟉��Z
        calcParcentageAddRecord(kohiTypes, addInfoMap, detailAdd_6);
        // �������P���Z
        calcParcentageAddRecord(kohiTypes, addInfoMap, detailAdd_8);
    }
    
    //%���Z�A%���Z���R�[�h�̌v�Z���s���܂��B
    private void calcParcentageAddRecord(QP001KohiKey[] kohi,
    		Map<String, List<QP001PercentageAddInfo>> addInfoMap,
    		Map<String, QP001RecordDetail> detailAdd) {
    	
        for (String svCode : detailAdd.keySet()) {
        	QP001RecordDetail detail = detailAdd.get(svCode);
        	
        	Map<Integer, Map<Integer, Integer>> baseRelateUnitMap = new HashMap<Integer, Map<Integer, Integer>>();
        	Map<Integer, List<Map<Integer, Integer>>> kohiRelateUnitMap = new HashMap<Integer, List<Map<Integer, Integer>>>();

        	//�ΏۂƂ����{�T�[�r�X�̃��R�[�h���܂킷
        	List<QP001PercentageAddInfo> kihonList = addInfoMap.get(svCode);
        	if (kihonList == null) {
        		continue;
        	}
        	//�֘A���Z���̒P�ʐ����v�Z���đΏےP�ʐ��֔��f
        	int diffUnit = calcRelateAddUnit(svCode, kihonList, baseRelateUnitMap);
        	int totalBaseUnit = diffUnit;
        	for (QP001PercentageAddInfo info : kihonList) {
        		int baseUnit = info.getKasanBaseUnit(svCode);
        		totalBaseUnit += baseUnit;
        	}
        	//���Z�E���Z��
        	int per = detail.getServiceUnit();
        	int addUnit = 0;
        	if (detail.isSyoguRecoed()) {
        		addUnit = CareServiceCommon.calcSyogu(totalBaseUnit, per, detail.getServiceStaffUnit());
        	} else {
        		addUnit = CareServiceCommon.calcPercentageUnit(totalBaseUnit, per);
        	}
        	//%���Z�̑ΏےP�ʐ���ێ��i���x�z�I�[�o�̍ۂ̏������P���Z�̎��ȕ��S�Z�o�p�j
        	detail.setAdditionBasisUnit(totalBaseUnit);
        	
        	//�P�ʐ��A�񐔁A�T�[�r�X�P�ʐ��ݒ�
        	detail.set_301009(addUnit);
        	detail.set_301010(1);
        	detail.set_301014(addUnit);
        	
        	boolean kohiLimit = false; 
        	int totalKohiUnit = 0; //��{�T�[�r�X�̌���ΏےP�ʐ��̐ςݏグ
        	int totalAddKohiUnit = 0; //�v�Z�ς݂̌���ΏےP�ʐ��̐ςݏグ
        	
        	//����P�ΏےP�ʐ�
        	if ((kohi[0] != null) && (!"".equals(kohi[0].getKohiType()))) {
        		int kohiUnit = calcRelateAddKohiUnit(kohi[0], svCode, kihonList, baseRelateUnitMap, kohiRelateUnitMap);
            	for (QP001PercentageAddInfo info : kihonList) {
            		kohiUnit += info.getKasanBaseKohiUnit(svCode, kohi[0]);
            	}
            	totalKohiUnit += kohiUnit;
            	
            	int addKohiUnit = 0;
            	// �T�[�r�X�P�ʐ�������P�ΏےP�ʐ��̏ꍇ
            	if (totalBaseUnit == totalKohiUnit) {
            		// ����P�ΏےP�ʐ��ɃT�[�r�X�P�ʐ����Z�b�g
            		addKohiUnit = detail.get_301014() - totalAddKohiUnit;
            		detail.set_301015(addKohiUnit);
            		detail.set_301011(1);
            		kohiLimit = true;
            	} else if (totalBaseUnit > totalKohiUnit) {
            		// ����P�ΏےP�ʐ����v�Z
            		if (detail.isSyoguRecoed()) {
            			addKohiUnit = CareServiceCommon.calcSyogu(kohiUnit, per, detail.getServiceStaffUnit());
            		} else {
            			addKohiUnit = CareServiceCommon.calcPercentageUnit(kohiUnit, per);
            		}
            		detail.set_301015(addKohiUnit);
            		// 2018/5/2 [CCCX:04849][Yoichiro Kamei] mod - begin
            		//detail.set_301011(1);
            		if (addKohiUnit == 0) {
            			detail.set_301011(0);
            		} else {
            			detail.set_301011(1);
            		}
            		// 2018/5/2 [CCCX:04849][Yoichiro Kamei] mod - end
            		totalAddKohiUnit += addKohiUnit;
            	}
        	}
        	
        	//����Q�ΏےP�ʐ�
        	if ((!kohiLimit) && (kohi[1] != null) && (!"".equals(kohi[1].getKohiType()))) {
        		int kohiUnit = calcRelateAddKohiUnit(kohi[1], svCode, kihonList, baseRelateUnitMap, kohiRelateUnitMap);
            	for (QP001PercentageAddInfo info : kihonList) {
            		kohiUnit += info.getKasanBaseKohiUnit(svCode, kohi[1]);
            	}
            	totalKohiUnit += kohiUnit;
            	
            	int addKohiUnit = 0;
            	// �T�[�r�X�P�ʐ�������ΏےP�ʐ��̐ςݏグ�̏ꍇ
            	if (totalBaseUnit == totalKohiUnit) {
            		// ����Q�ΏےP�ʐ��ɃT�[�r�X�P�ʐ�-�v�Z�ς݂̌���ΏےP�ʐ��̐ςݏグ���Z�b�g
            		addKohiUnit = detail.get_301014() - totalAddKohiUnit;
            		detail.set_301016(addKohiUnit);
            		detail.set_301012(1);
            		kohiLimit = true;
            	} else if (totalBaseUnit > totalKohiUnit) {
            		// ����Q�ΏےP�ʐ����v�Z
            		if (detail.isSyoguRecoed()) {
            			addKohiUnit = CareServiceCommon.calcSyogu(kohiUnit, per, detail.getServiceStaffUnit());
            		} else {
            			addKohiUnit = CareServiceCommon.calcPercentageUnit(kohiUnit, per);
            		}
            		detail.set_301016(addKohiUnit);
            		// 2018/5/2 [CCCX:04849][Yoichiro Kamei] mod - begin
            		//detail.set_301012(1);
            		if (addKohiUnit == 0) {
            			detail.set_301012(0);
            		} else {
            			detail.set_301012(1);
            		}
            		// 2018/5/2 [CCCX:04849][Yoichiro Kamei] mod - end
            		totalAddKohiUnit += addKohiUnit;
            	}
        	}
        	
        	//����R�ΏےP�ʐ�
        	if ((!kohiLimit) && (kohi[2] != null) && (!"".equals(kohi[2].getKohiType()))) {
        		int kohiUnit = calcRelateAddKohiUnit(kohi[2], svCode, kihonList, baseRelateUnitMap, kohiRelateUnitMap);
            	for (QP001PercentageAddInfo info : kihonList) {
            		kohiUnit += info.getKasanBaseKohiUnit(svCode, kohi[2]);
            	}
            	totalKohiUnit += kohiUnit;
            	
            	int addKohiUnit = 0;
            	// �T�[�r�X�P�ʐ�������ΏےP�ʐ��̐ςݏグ�̏ꍇ
            	if (totalBaseUnit == totalKohiUnit) {
            		// ����R�ΏےP�ʐ��ɃT�[�r�X�P�ʐ�-�v�Z�ς݂̌���ΏےP�ʐ��̐ςݏグ���Z�b�g
            		addKohiUnit = detail.get_301014() - totalAddKohiUnit;
            		detail.set_301017(addKohiUnit);
            		detail.set_301013(1);
            		kohiLimit = true;
            	} else if (totalBaseUnit > totalKohiUnit) {
            		// ����R�ΏےP�ʐ����v�Z
            		if (detail.isSyoguRecoed()) {
            			addKohiUnit = CareServiceCommon.calcSyogu(kohiUnit, per, detail.getServiceStaffUnit());
            		} else {
            			addKohiUnit = CareServiceCommon.calcPercentageUnit(kohiUnit, per);
            		}
            		detail.set_301017(addKohiUnit);
            		// 2018/5/2 [CCCX:04849][Yoichiro Kamei] mod - begin
            		//detail.set_301013(1);
            		if (addKohiUnit == 0) {
            			detail.set_301013(0);
            		} else {
            			detail.set_301013(1);
            		}
            		// 2018/5/2 [CCCX:04849][Yoichiro Kamei] mod - end
            		totalAddKohiUnit += addKohiUnit;
            	}
        	}
        	
        	// �����^���Z�A���ꌚ�����Z�̏ꍇ�͒P�ʐ��̋L�ڏȗ�
        	if (detail.getServiceAddFlag() == 5
        			|| detail.getServiceAddFlag() == 7) {
        		detail.set_301009(0);
        	}
        }
    }
    
    //�w�肵��%���Z�̌v�Z�Ɋ܂߂鑼��%���Z�̒P�ʐ����v�Z���܂��B
    private int calcRelateAddUnit(String svCode, List<QP001PercentageAddInfo> kihonList, 
    		Map<Integer, Map<Integer, Integer>> baseRelateUnitMap) {
    	int diffUnit = 0;
    	//�ȉ��̏��Ɍv�Z����
    	//�����^���Z�̕����v�Z
    	diffUnit += calcRelateAddUnitSub(baseRelateUnitMap, diffUnit, QP001PercentageAddInfo.SERVICE_ADD_FLAG_KYOUSEI, svCode, kihonList);
    	//���ꌚ�����Z�̕����v�Z
    	diffUnit += calcRelateAddUnitSub(baseRelateUnitMap, diffUnit, QP001PercentageAddInfo.SERVICE_ADD_FLAG_SAME_BUILDING, svCode, kihonList);
    	//���n�n�̉��Z�̕����v�Z
    	diffUnit += calcRelateAddUnitSub(baseRelateUnitMap, diffUnit, QP001PercentageAddInfo.SERVICE_ADD_FLAG_TOKUCHI, svCode, kihonList);
    	//���R�Ԓn�擙�񋟉��Z�̕����v�Z
    	diffUnit += calcRelateAddUnitSub(baseRelateUnitMap, diffUnit, QP001PercentageAddInfo.SERVICE_ADD_FLAG_CHUSAN, svCode, kihonList);
    	return diffUnit;
    }
    
    //�Ώۂ̌���ɂ��Ďw�肵��%���Z�̌v�Z�Ɋ܂߂鑼��%���Z�̒P�ʐ����v�Z���܂��B
    private int calcRelateAddKohiUnit(QP001KohiKey kohiKey, String svCode, List<QP001PercentageAddInfo> kihonList,
    		Map<Integer, Map<Integer, Integer>> baseRelateUnitMap,
    		Map<Integer, List<Map<Integer, Integer>>> kohiRelateUnitMap
    		) {
    	int diffUnit = 0;
    	//�ȉ��̏��Ɍv�Z����
    	//�����^���Z�̕����v�Z
    	diffUnit += calcRelateAddKohiUnitSub(baseRelateUnitMap, kohiRelateUnitMap, diffUnit, kohiKey, QP001PercentageAddInfo.SERVICE_ADD_FLAG_KYOUSEI, svCode, kihonList);
    	//���ꌚ�����Z�̕����v�Z
    	diffUnit += calcRelateAddKohiUnitSub(baseRelateUnitMap, kohiRelateUnitMap, diffUnit, kohiKey, QP001PercentageAddInfo.SERVICE_ADD_FLAG_SAME_BUILDING, svCode, kihonList);
    	//���n�n�̉��Z�̕����v�Z
    	diffUnit += calcRelateAddKohiUnitSub(baseRelateUnitMap, kohiRelateUnitMap, diffUnit, kohiKey, QP001PercentageAddInfo.SERVICE_ADD_FLAG_TOKUCHI, svCode, kihonList);
    	//���R�Ԓn�擙�񋟉��Z�̕����v�Z
    	diffUnit += calcRelateAddKohiUnitSub(baseRelateUnitMap, kohiRelateUnitMap, diffUnit, kohiKey, QP001PercentageAddInfo.SERVICE_ADD_FLAG_CHUSAN, svCode, kihonList);
    	return diffUnit;
    }
    
    //�Ώۂ̃T�[�r�X���Z�t���O���̊֘A%���Z�̒P�ʐ����v�Z
    private int calcRelateAddUnitSub(Map<Integer, Map<Integer, Integer>> baseRelateUnitMap,
    		int diffUnit, int addFlg, String svCode, List<QP001PercentageAddInfo> kihonList) {
    	int ret = 0;
    	Map<Integer, Integer> sumPerUnitMap = new HashMap<Integer, Integer>();
    	for (QP001PercentageAddInfo info : kihonList) {
    		//�֘A���Z���̉��Z���A�ΏےP�ʐ����擾
    		Map<Integer, Integer> perUnitMap = info.getRelateAddUnit(svCode, addFlg);
    		//���Z�����ƂɏW�v
    		for (int per : perUnitMap.keySet()) {
    			int unit = ACCastUtilities.toInt(perUnitMap.get(per), 0);
    			int nowUnit = 0;
        		if (sumPerUnitMap.containsKey(per)) {
        			nowUnit = ACCastUtilities.toInt(sumPerUnitMap.get(per), 0);
        		}
        		sumPerUnitMap.put(per, unit + nowUnit);
    		}
    	}
    	//���Z�E���Z�̒P�ʐ����v�Z
    	for (int per : sumPerUnitMap.keySet()) {
    		int totalUnit = ACCastUtilities.toInt(sumPerUnitMap.get(per), 0);
    		//����%���Z�Ɋ܂߂�v�Z�ς݂�%���Z�̒P�ʐ��𔽉f
    		totalUnit += diffUnit;
    		sumPerUnitMap.put(per, totalUnit);
    		ret += CareServiceCommon.calcPercentageUnit(totalUnit, per);
    	}
    	if (!sumPerUnitMap.isEmpty()) {
    		baseRelateUnitMap.put(addFlg, sumPerUnitMap);
    	}
    	return ret;
    }
    
    //�Ώۂ̌���ɂ��ăT�[�r�X���Z�t���O���̊֘A%���Z�̒P�ʐ����v�Z
    private int calcRelateAddKohiUnitSub(Map<Integer, Map<Integer, Integer>> baseRelateUnitMap,
    		Map<Integer, List<Map<Integer, Integer>>> kohiRelateUnitMap,
    		int diffUnit, QP001KohiKey kohiKey, int addFlg, String svCode, List<QP001PercentageAddInfo> kihonList) {
    	int ret = 0;
    	Map<Integer, Integer> sumPerUnitMap = new HashMap<Integer, Integer>();
    	for (QP001PercentageAddInfo info : kihonList) {
    		//�֘A���Z���̉��Z���A�ΏےP�ʐ����擾
    		Map<Integer, Integer> perUnitMap = info.getRelateAddKohiUnit(kohiKey, svCode, addFlg);
    		//���Z�����ƂɏW�v
    		for (int per : perUnitMap.keySet()) {
    			int unit = ACCastUtilities.toInt(perUnitMap.get(per), 0);
    			int nowUnit = 0;
        		if (sumPerUnitMap.containsKey(per)) {
        			nowUnit = ACCastUtilities.toInt(sumPerUnitMap.get(per), 0);
        		}
        		sumPerUnitMap.put(per, unit + nowUnit);
    		}
    	}
    	
    	//����܂ł̐ςݏグ�P�ʐ�
    	if (!baseRelateUnitMap.containsKey(addFlg)) {
    		baseRelateUnitMap.put(addFlg, new HashMap<Integer, Integer>());
    	}
    	Map<Integer, Integer> baseRelate = baseRelateUnitMap.get(addFlg);
		if (!kohiRelateUnitMap.containsKey(addFlg)) {
			kohiRelateUnitMap.put(addFlg, new ArrayList<Map<Integer, Integer>>());
		}
    	List<Map<Integer, Integer>> kohiRelateUnitList = kohiRelateUnitMap.get(addFlg);
    	
    	
    	//���Z�E���Z�̒P�ʐ����v�Z
    	for (int per : sumPerUnitMap.keySet()) {
    		int totalUnit = ACCastUtilities.toInt(sumPerUnitMap.get(per), 0);
    		//����%���Z�Ɋ܂߂�v�Z�ς݂�%���Z�̒P�ʐ��𔽉f
    		totalUnit += diffUnit;
    		sumPerUnitMap.put(per, totalUnit);
    		
    		//��{�̒P�ʐ��Ƃ���܂ł̐ςݏグ����������
    		int tBase = ACCastUtilities.toInt(baseRelate.get(per), 0);
    		int tDiff = 0;
    		for (Map<Integer, Integer> kohiUnitMap : kohiRelateUnitList) {
    			tDiff += ACCastUtilities.toInt(kohiUnitMap.get(per), 0);
    		}
    		if (tBase == (tDiff + totalUnit)) {
    			int tDiffUnit = 0;
    			for (Map<Integer, Integer> kohiUnitMap : kohiRelateUnitList) {
    				int unit = ACCastUtilities.toInt(kohiUnitMap.get(per), 0);
    				tDiffUnit += CareServiceCommon.calcPercentageUnit(unit, per);
    			}
    			int tBaseUnit = CareServiceCommon.calcPercentageUnit(tBase, per);
    			ret += (tBaseUnit - tDiffUnit);
    		} else {
        		ret += CareServiceCommon.calcPercentageUnit(totalUnit, per);
    		}
    	}
    	//����ΏےP�ʐ���ޔ�
    	if (!sumPerUnitMap.isEmpty()) {
    		kohiRelateUnitList.add(sumPerUnitMap);
    	}
    	return ret;
    }
    // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/10 add - end
    
}
