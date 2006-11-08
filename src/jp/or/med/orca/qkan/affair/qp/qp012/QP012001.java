package jp.or.med.orca.qkan.affair.qp.qp012;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Manager;
import jp.nichicom.ac.lib.care.claim.calculation.QP001PatientState;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style10;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style11;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style13;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style2;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style3;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style4;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style5;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style6;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style7;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style8;
import jp.nichicom.ac.lib.care.claim.calculation.QP001Style9;
import jp.nichicom.ac.lib.care.claim.calculation.QP001StyleAbstract;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceUnitGetter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.splash.ACSplash;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanMessageList;
/**
 * �K��Ō�×{��׏��̎��яW�v�N���X�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/08/29
 */
public class QP012001 {
	    
    // 2006/09/28 add-begin [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
    // ��`
    // �O�񃋁[�v�̐����惂�[�h�i�ی����S���[�h�Gfalse, �ی��O���S���[�h�Ftrue�j
    private boolean beforeIsByPatientSpan = false; // �f�t�H���g�F�ی����S���[�h
    // �d�ǎҊǗ����Z�@1301082
    private int addValues_1301082 = 0; // ��r�p�̒l
    VRMap addFixer_1301082 = null; // �Z������m�肳�����T�[�r�X���уf�[�^
	//24���ԘA���̐����Z�@1301079
    private int addValues_1301079 = 0; // ��r�p�̒l
    VRMap addFixer_1301079 = null; // �Z������m�肳�����T�[�r�X���уf�[�^
	//�މ@�������w�����Z�@1301085
    private int addValues_1301085 = 0; // ��r�p�̒l
    VRMap addFixer_1301085 = null; // �Z������m�肳�����T�[�r�X���уf�[�^
	//���񋟗×{��@1301088
    private int addValues_1301088 = 0; // ��r�p�̒l
    VRMap addFixer_1301088 = null; // �Z������m�肳�����T�[�r�X���уf�[�^
	//�^�[�~�i���P�A�×{��1�@1301091
    private int addValues_1301091 = 0; // ��r�p�̒l
    VRMap addFixer_1301091 = null; // �Z������m�肳�����T�[�r�X���уf�[�^
	//�^�[�~�i���P�A�×{��2�@1301158
    private int addValues_1301158 = 0; // ��r�p�̒l
    VRMap addFixer_1301158 = null; // �Z������m�肳�����T�[�r�X���уf�[�^
    // 2006/09/28 add-end [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
    
    
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP012001() {
        super();
    }

    /**
     * ���т��W�v���ĕԂ��܂��B
     * @param patientID ���p��ID
     * @param billStart �������ԊJ�n
     * @param billEnd �������ԏI��
     * @param dbm DBManager
     * @return ����
     */
    public VRMap calculate(int patientID, Date billStart, Date billEnd, ACDBManager dbm) throws Exception {
    	Date targetDate = ACDateUtilities.toFirstDayOfMonth(billStart);

        // �f�[�^�}�l�[�W���̏�����
        QP001Manager manager = new QP001Manager(dbm, targetDate);
            
//        // �����ɐ\�����̗��������݂���ꍇ�͏W�v�������s��Ȃ��B
//        if (!QkanCommon.isFullDecisionPatientInsureInfo(dbm,targetDate, patientID)) {
//        	//�G���[�̂Ƃ��͋��Map�����^�[������B
//			return new VRHashMap();
//		}
        
        // ���p�ҏ��ڍ׎擾�p��VRArrayList patient �𐶐����A���ʊ֐����g�p���ė��p�ҏ��ڍׂ��擾����B
        VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(dbm, patientID).get(0);

        // �������уf�[�^�ޔ�p�� VRArrayList serviceDetailList
        // �����Ώۂ̗��p�҂̌��������уf�[�^���擾����B
        VRList serviceDetailList = QkanCommon.getServiceDetail(
                dbm, patientID, targetDate,
                QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY.intValue());
        
        //�T�[�r�X�񋟓��ŕ��ёւ�
        Collections.sort(serviceDetailList, new DateComparator());
        
        //�w�肳�ꂽ���̈�Ð���������ԋp����B
        return calculateDetail(billStart, billEnd,patient, serviceDetailList,manager,dbm,targetDate);
    }
    
    /**
     * ��Ð��������Ɋւ��鏈�����s�Ȃ��܂��B
     * @param billStart �W�v���ԊJ�n
     * @param billEnd �W�v���ԏI��
     * @param patient ���p�҃f�[�^
     * @param serviceDetailList ���уf�[�^���X�g
     * @param manager �}�X�^�f�[�^�}�l�[�W��
     * @param dbm
     * @param targetDate
     * @return
     * @throws Exception
     */
    public VRMap calculateDetail(Date billStart, Date billEnd,VRMap patient, VRList serviceDetailList,QP001Manager manager,ACDBManager dbm,Date targetDate) throws Exception {
        
        // ���уf�[�^
        VRMap serviceDetail = null;
        VRMap serviceDetailNext = null;
        
        //�b��W�v�f�[�^�ۑ��p
        VRMap tentativeCalc = new VRHashMap();
        //�f�[�^��r�pMap
        VRMap omparison = new VRHashMap();
        //���ԓ��L���f�[�^�ۑ��p(�ی��L�����ԓ��p)
        VRMap effectiveValid = new VRHashMap();
        //���ԓ��L���f�[�^�ۑ��p(�ی��L�����ԊO�p)
        VRMap effectiveInvalid = new VRHashMap();
        
        //���Z��ݒ肵�����̃t���O
        VRList additionFlag = new VRArrayList();
        
        //���ԓ��ɊY���f�[�^�����݂������t���O
        boolean hitValid = false;
        boolean hitInvalid = false;
        //���^�[���p
        VRMap result = new VRHashMap();
        
        // ���p�҂̏����擾����B
        QP001PatientState patientState = new QP001PatientState(dbm, patient, targetDate);
        
        //�S�̏W�v�p
        QP001Style13 style13 = new QP001Style13(manager);
        
        // �������уf�[�^�����[�v����B
        for (int i = 0; i < serviceDetailList.getDataSize(); i++) {
            // �T�[�r�X���̎��уf�[�^�ޔ�p�� VRHashMap serviceDetail
            // �𐶐����A�f�[�^��ޔ�����B
            serviceDetail = (VRMap) serviceDetailList.getData(i);
            
            //��ẪT�[�r�X�ł͂Ȃ��ꍇ�A�������s��Ȃ��B
            if (ACCastUtilities.toInt(serviceDetail.getData("SYSTEM_SERVICE_KIND_DETAIL"),0) != QkanConstants.CLAIM_STYLE_VISIT_DETAILED_SOCIAL_INSURANCE){
            	continue;
            }
            
            //���уf�[�^�����O�C�����Ə��̂��̂ł��邩�m�F����B
            if(!QkanSystemInformation.getInstance().getLoginProviderID().equals(String.valueOf(serviceDetail.get("PROVIDER_ID")))){
                continue;
            }

            //2006/09/27 add-begin [Masahiko HIGUCHI]
            //��1��̉��Z��ی����S���Ɨ��p�ҕ��S���ŕ����ĊǗ��ł���悤�A�ی����S���[�h��ǉ�
            //�L�����ԊO�̎��тł��邩
            boolean isByPatientSpan =ACTextUtilities.isNullText(patientState.getMedicalData(serviceDetail.getData("SERVICE_DATE"),"PATIENT_ID"));
            //�ی����S���[�h�̕ύX(�L�����ԊO�ł���Η��p�ҕ��S�Ȃ̂ŁA�ی����S���[�h=false)
            style13.setInsurerMode(!isByPatientSpan);
            //2006/09/27 add-end [Masahiko HIGUCHI]
            
            // �K��Ō�×{��׏��̉��
            style13.parse(serviceDetail, targetDate, patientState,null, -1);
            
        	//���̎��уf�[�^�̓��t�Ɣ�r
        	serviceDetailNext = null;
        	if((i + 1) < serviceDetailList.getDataSize()){
        		serviceDetailNext = (VRMap) serviceDetailList.getData(i + 1);
        	}
        	if ((serviceDetailNext == null)
					|| (ACDateUtilities.compareOnDay(
							ACCastUtilities.toDate(serviceDetail.getData("SERVICE_DATE")),
							ACCastUtilities.toDate(serviceDetailNext.getData("SERVICE_DATE"))) != 0)) {
        		
                // �b��I�ɏW�v���m�肳���A�������r����
                style13.commitRecords(patientState,null,null);
                //Map�`���Ńf�[�^���擾
                tentativeCalc = (VRMap)(style13.getRecords(patientState.getPatientId(),targetDate)).getData();
        		
                // 2006/09/28 add-begin [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
                // ��1��Z����Z�̎Z����b��m�肷��B
                fixAdd(beforeIsByPatientSpan, isByPatientSpan, tentativeCalc, serviceDetail);
                // 2006/09/28 add-end [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
                
                //���Ԃ̏d���������͂Ȃ��ꍇ�i���Ԃ̏d��������ꍇ�j�A���Ԃ̏W�v���s���B
                if(ACDateUtilities.getDuplicateTermCheck(billStart,billEnd,
                		ACCastUtilities.toDate(serviceDetail.getData("SERVICE_DATE")),ACCastUtilities.toDate(serviceDetail.getData("SERVICE_DATE"))) != ACDateUtilities.DUPLICATE_NONE){
                	
                	//�ی��̗L�����ԓ����H
                	//�L�����ԊO��������
                	if(isByPatientSpan){
                    	//����r(�����������Ƃ�����W�v)
                    	setPeriodCalc(tentativeCalc,omparison,effectiveInvalid,null,serviceDetail);
                    	//�Y���f�[�^�L
                    	hitInvalid = true;
                    	
                    //�L�����ԓ���������
                	} else {
                    	//����r(�����������Ƃ�����W�v)
                    	setPeriodCalc(tentativeCalc,omparison,effectiveValid,effectiveInvalid,serviceDetail);
                    	//�Y���f�[�^�L
                    	hitValid = true;
                	}
                }
                
                //��r�p�̃f�[�^���ŐV�ɍX�V
                omparison = (VRMap)tentativeCalc.clone();
        		
        	}
        	
            // 2006/09/28 add-begin [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
            // �t���O�ޔ�
        	beforeIsByPatientSpan = isByPatientSpan;
            // 2006/09/28 add-end [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
        	
        }

        // 2006/09/28 add-begin [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
        // �m�肳�ꂽ��1��Z����Z�̂����A�]���ȉ��Z���폜����B
        removeExtraAdd(effectiveValid);
        removeExtraAdd(effectiveInvalid);
        // 2006/09/28 add-end [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
        
        //�ی����ԓ��ɏW�v�f�[�^�����݂���ꍇ�A���^�[���p��Map�ɐݒ肷��B
        //if (hitValid){
        	setResult(tentativeCalc,
					 effectiveValid,
					 true,
					 additionFlag,
					 result);
        //}
        //�ی����ԊO�ɏW�v�f�[�^�����݂���ꍇ�A���^�[���p��Map�ɐݒ肷��B
        if (hitInvalid){
        	setResult(tentativeCalc,
					 effectiveInvalid,
					 false,
					 additionFlag,
					 result);
        }
        
    	//�K����̓]��
        int start = ACDateUtilities.getDayOfMonth(billStart);
        int end = ACDateUtilities.getDayOfMonth(billEnd);
    	for(int i = 1; i <=  31; i++){
    		//magic no 1301103
    		if((start <= i) && (i <= end)){
        		result.put("PROVIDE_DAY_" + i, ACCastUtilities.toInteger(
        				tentativeCalc.get(ACCastUtilities.toString(1301103 + i)),0));
    		} else {
        		result.put("PROVIDE_DAY_" + i, new Integer(0));
    		}
    	}
        
        //���ʃZ�b�g�𐶐����A�ԋp����B
        return result;
    }
    
    /**
     * �����Z����Z�̎Z������b��m�肷�邽�߂̏���
     * @param beforeIsByPatientSpan �O�񃋁[�v�̎��т��A�ی��O���S���ǂ����B�i�ی��O���S�Ftrue, �ی����S�Ffalse�j
     * @param isByPatientSpan ���񃋁[�v�̎��т��A�ی��O���S���ǂ����B�i�ی��O���S�Ftrue, �ی����S�Ffalse�j
     * @param tentativeCalc �����_�ł̏W�v����
     * @param serviceDetail ���񃋁[�v�̎���
     * @throws Exception
     */
    private void fixAdd(boolean beforeIsByPatientSpan, boolean isByPatientSpan, VRMap tentativeCalc, VRMap serviceDetail) throws Exception{

        
        // 2006/09/28 add-begin [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
        // �ؖ����ޔ�
        if(beforeIsByPatientSpan == isByPatientSpan){
        	// ���[�h������
        	// �l�̕ω�������Ίm��
	    	//�d�ǎҊǗ����Z�@1301082
        	if(addValues_1301082 < ACCastUtilities.toInt(tentativeCalc.getData("1301082"), 0)){
        		addValues_1301082 = ACCastUtilities.toInt(tentativeCalc.getData("1301082"), 0);
        		addFixer_1301082 = serviceDetail;
        	}
	    	//24���ԘA���̐����Z�@1301079
        	if(addValues_1301079 < ACCastUtilities.toInt(tentativeCalc.getData("1301079"), 0)){
        		addValues_1301079 = ACCastUtilities.toInt(tentativeCalc.getData("1301079"), 0);
        		addFixer_1301079 = serviceDetail;
        	}
	    	//�މ@�������w�����Z�@1301085
        	if(addValues_1301085 < ACCastUtilities.toInt(tentativeCalc.getData("1301085"), 0)){
        		addValues_1301085 = ACCastUtilities.toInt(tentativeCalc.getData("1301085"), 0);
        		addFixer_1301085 = serviceDetail;
        	}
	    	//���񋟗×{��@1301088
        	if(addValues_1301088 < ACCastUtilities.toInt(tentativeCalc.getData("1301088"), 0)){
        		addValues_1301088 = ACCastUtilities.toInt(tentativeCalc.getData("1301088"), 0);
        		addFixer_1301088 = serviceDetail;
        	}
	    	//�^�[�~�i���P�A�×{��1�@1301091
        	if(addValues_1301091 < ACCastUtilities.toInt(tentativeCalc.getData("1301091"), 0)){
        		addValues_1301091 = ACCastUtilities.toInt(tentativeCalc.getData("1301091"), 0);
        		addFixer_1301091 = serviceDetail;
        	}
	    	//�^�[�~�i���P�A�×{��2�@1301158
        	if(addValues_1301158 < ACCastUtilities.toInt(tentativeCalc.getData("1301158"), 0)){
        		addValues_1301158 = ACCastUtilities.toInt(tentativeCalc.getData("1301158"), 0);
        		addFixer_1301158 = serviceDetail;
        	}
        }else{
        	// ���[�h���قȂ�
        	if(beforeIsByPatientSpan){
        		// �O��F���p�ҕ��S�@����F�ی����S
        		// �O�����̃p�^��
        		// ����̌�1����Z��ی����ŗD�悵�ĎZ�肷��B
        		// ���т�����Ίm��
        		int val;
				// �d�ǎҊǗ����Z 1301082
    			val = ACCastUtilities.toInt(VRBindPathParser.get("2010109", serviceDetail), 0);
    			if(val > 1){
            		addValues_1301082 = ACCastUtilities.toInt(tentativeCalc.getData("1301082"), 0);
            		addFixer_1301082 = serviceDetail;
    			}
        		// 24���ԘA���̐����Z 1301079
    			val = ACCastUtilities.toInt(VRBindPathParser.get("2010108", serviceDetail), 0);
    			if(val > 1){
            		addValues_1301079 = ACCastUtilities.toInt(tentativeCalc.getData("1301079"), 0);
            		addFixer_1301079 = serviceDetail;
    			}
				// �މ@�������w�����Z 1301085
    			val = ACCastUtilities.toInt(VRBindPathParser.get("2010107", serviceDetail), 0);
    			if(val > 1){
            		addValues_1301085 = ACCastUtilities.toInt(tentativeCalc.getData("1301085"), 0);
            		addFixer_1301085 = serviceDetail;
    			}
				// ���񋟗×{�� 1301088
    			val = ACCastUtilities.toInt(VRBindPathParser.get("2010110", serviceDetail), 0);
    			if(val > 1){
            		addValues_1301088 = ACCastUtilities.toInt(tentativeCalc.getData("1301088"), 0);
            		addFixer_1301088 = serviceDetail;
    			}
				// �^�[�~�i���P�A�×{��1 1301091
    			val = ACCastUtilities.toInt(VRBindPathParser.get("2010111", serviceDetail), 0);
    			if(val == 2){
            		addValues_1301091 = ACCastUtilities.toInt(tentativeCalc.getData("1301091"), 0);
            		addFixer_1301091 = serviceDetail;
    			}
				// �^�[�~�i���P�A�×{��2 1301158
    			val = ACCastUtilities.toInt(VRBindPathParser.get("2010111", serviceDetail), 0);
    			if(val == 3){
            		addValues_1301158 = ACCastUtilities.toInt(tentativeCalc.getData("1301158"), 0);
            		addFixer_1301158 = serviceDetail;
    			}
            }else{
        		// �O��F�ی����S�@����F���p�ҕ��S
        		// �����O�̃p�^��
        		// �O��0�~�̏ꍇ�i��x���m�肳��Ă��Ȃ��ꍇ�j�̂݊m��
				// �d�ǎҊǗ����Z 1301082
        		if(ACCastUtilities.toInt(tentativeCalc.getData("1301082"), 0) > 0){
        			if(addValues_1301082 == 0){
                		addValues_1301082 = ACCastUtilities.toInt(tentativeCalc.getData("1301082"), 0);
                		addFixer_1301082 = serviceDetail;
        			}
        		}
        		// 24���ԘA���̐����Z 1301079
        		if(ACCastUtilities.toInt(tentativeCalc.getData("1301079"), 0) > 0){
        			if(addValues_1301079 == 0){
                		addValues_1301079 = ACCastUtilities.toInt(tentativeCalc.getData("1301079"), 0);
                		addFixer_1301079 = serviceDetail;
        			}
        		}
				// �މ@�������w�����Z 1301085
        		if(ACCastUtilities.toInt(tentativeCalc.getData("1301085"), 0) > 0){
        			if(addValues_1301085 == 0){
                		addValues_1301085 = ACCastUtilities.toInt(tentativeCalc.getData("1301085"), 0);
                		addFixer_1301085 = serviceDetail;
        			}
        		}
				// ���񋟗×{�� 1301088
        		if(ACCastUtilities.toInt(tentativeCalc.getData("1301088"), 0) > 0){
        			if(addValues_1301088 == 0){
                		addValues_1301088 = ACCastUtilities.toInt(tentativeCalc.getData("1301088"), 0);
                		addFixer_1301088 = serviceDetail;
        			}
        		}
				// �^�[�~�i���P�A�×{��1 1301091
        		if(ACCastUtilities.toInt(tentativeCalc.getData("1301091"), 0) > 0){
        			if(addValues_1301091 == 0){
                		addValues_1301091 = ACCastUtilities.toInt(tentativeCalc.getData("1301091"), 0);
                		addFixer_1301091 = serviceDetail;
        			}
        		}
				// �^�[�~�i���P�A�×{��2 1301158
        		if(ACCastUtilities.toInt(tentativeCalc.getData("1301158"), 0) > 0){
        			if(addValues_1301158 == 0){
                		addValues_1301158 = ACCastUtilities.toInt(tentativeCalc.getData("1301158"), 0);
                		addFixer_1301158 = serviceDetail;
        			}
        		}
            }
        }
        // 2006/09/28 add-end [Kazuyoshi Kamitsukasa & Masahiko Higuchi]
        
    }
    
    /**
     * �m�肳�ꂽ��1��Z����Z�̂����A�ޔ����Ă����ؖ��p�T�[�r�X���тƂ��ƂȂ���тɂ��m�肳�ꂽ���Z���폜����B
     * @param effective �W�v��̃f�[�^
     * @throws Exception
     */
    private void removeExtraAdd(VRMap effective) throws Exception{

    	if(effective != null){
	    	
	    	//24���ԘA���̐����Z�@1301079
    		removeExtraAddDetail(effective, "1301079", addFixer_1301079);
	    	
	    	//�d�ǎҊǗ����Z�@1301082
    		removeExtraAddDetail(effective, "1301082", addFixer_1301082);
	    	
	    	//�މ@�������w�����Z�@1301085
    		removeExtraAddDetail(effective, "1301085", addFixer_1301085);
	    	
	    	//���񋟗×{��@1301088
    		removeExtraAddDetail(effective, "1301088", addFixer_1301088);
	    	
	    	//�^�[�~�i���P�A�×{��1�@1301091
    		removeExtraAddDetail(effective, "1301091", addFixer_1301091);
	    	
	    	//�^�[�~�i���P�A�×{��2�@1301158
    		removeExtraAddDetail(effective, "1301158", addFixer_1301158);
    		
    	}
    }
    
    /**
     * �m�肳�ꂽ��1��Z����Z�̂����A�ޔ����Ă����ؖ��p�T�[�r�X���тƂ��ƂȂ���тɂ��m�肳�ꂽ���Z���폜����B
     * @param effective �W�v��̃f�[�^
     * @param key ��1����Z�̃L�[
     * @param addFixer ��1����Z���b��m�肵�����уf�[�^
     * @throws Exception
     */
    private void removeExtraAddDetail(VRMap effective, String key, Object addFixer) throws Exception{
    	if(addFixer != null){
    		if(!(addFixer.equals(VRBindPathParser.get("FIXED_"+ key , effective)))){
    			// �b��m�肵�����сiaddFixer�j�Ɗm�肵�����сi"FIXED_"+ key�j�̔�r���s���A�قȂ�ꍇ�ɍ폜�B
    			effective.remove(key);
    		}
    	}
    }
    
    /**
     * �����𔲂��o���A�W�v����B
     * @param tentativeCalc �W�v��̃f�[�^
     * @param omparison ���O�̏W�v�f�[�^
     * @param effective ���ԓ��W�v�ޔ�p
     * @throws Exception
     */
    private void setPeriodCalc(VRMap tentativeCalc,VRMap omparison,VRMap effective,VRMap effectiveInValid,VRMap serviceDetail) throws Exception {
    	
    	//�e���ڂɂ����āA�������ύX����Ă��邩�m�F����B
    	//�ύX����Ă���΁A���ԓ��ɔ������������Ƃ݂Ȃ��B
    	
    	//��{�×{��(I)(11)�ی��t�A���Y�t�A�Ō�t�A���w�Ö@�m�A��ƗÖ@�m -����(1��)
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301034");
    	
    	//��{�×{��(I)(11)�ی��t�A���Y�t�A�Ō�t�A���w�Ö@�m�A��ƗÖ@�m -����(2��)
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301039");
    	
    	//��{�×{��(I)(12)�y�Ō�t -����(1��)
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301044");
    	
    	//��{�×{��(I)(12)�y�Ō�t -����(2��)
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301049");
    	
    	//��{�×{��(I)(13)��a��������K����Z(1��2��) -����
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301054");
    	
    	//��{�×{��(I)(13)��a��������K����Z(1��3��ȏ�) -����
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301059");
    	
    	//��{�×{��(II)(15)�ی��t�A�Ō�t�A��ƗÖ@�m -����
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301064");
    	
    	//��{�×{��(II)(16)�������ԉ��Z -���Ԑ�
    	//�������͎��ԂŔ��f
    	if(tentativeCalc.get("1301069") != null){
			if(!tentativeCalc.get("1301069").equals(omparison.get("1301069"))){
				effective.put("1301069", new Integer(
						ACCastUtilities.toInt(effective.get("1301069"),0)
						+ (ACCastUtilities.toInt(tentativeCalc.get("1301069"),0) - ACCastUtilities.toInt(omparison.get("1301069"),0))
													 ));
			}
    	}
    	
    	//�Ǘ��×{�� �����̋��z
    	setPeriodCalcDetailDiff(tentativeCalc,omparison,effective,"1301073",null,null,null);
    	
    	//�Ǘ��×{�� ����
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301075");
    	
    	//��{�×{��(I)(14)�ً}�K��Ō���Z -����
    	setPeriodCalcDetailDay(tentativeCalc,omparison,effective,"1301154");
    	
    	//24���ԘA���̐����Z
    	setPeriodCalcDetailDiff(tentativeCalc,omparison,effective,"1301079",effectiveInValid,serviceDetail,addFixer_1301079);
    	
    	//�d�ǎҊǗ����Z
    	setPeriodCalcDetailDiff(tentativeCalc,omparison,effective,"1301082",effectiveInValid,serviceDetail,addFixer_1301082);
    	
    	//�މ@�������w�����Z ���v
    	setPeriodCalcDetailDiff(tentativeCalc,omparison,effective,"1301085",effectiveInValid,serviceDetail,addFixer_1301085);
    	
    	//���񋟗×{��
    	setPeriodCalcDetailDiff(tentativeCalc,omparison,effective,"1301088",effectiveInValid,serviceDetail,addFixer_1301088);
    	
    	//�^�[�~�i���P�A�×{��1
    	setPeriodCalcDetailDiff(tentativeCalc,omparison,effective,"1301091",effectiveInValid,serviceDetail,addFixer_1301091);
    	
    	//�^�[�~�i���P�A�×{��2
    	setPeriodCalcDetailDiff(tentativeCalc,omparison,effective,"1301158",effectiveInValid,serviceDetail,addFixer_1301158);
    	
    	
    }
    
    /**
     * �f�[�^���ύX����Ă��邩��r���A�ύX����Ă���Αޔ�p��Map�̃J�E���g��������
     * @param tentativeCalc �W�v��̃f�[�^
     * @param omparison ���O�̏W�v�f�[�^
     * @param effective ���ԓ��W�v�ޔ�p
     * @param key �Y���f�[�^�̃L�[
     * @throws Exception
     */
    private void setPeriodCalcDetailDay(VRMap tentativeCalc,VRMap omparison,VRMap effective,String key) throws Exception {
    	if(tentativeCalc.get(key) == null){
    		return;
    	}
    	
    	if(!tentativeCalc.get(key).equals(omparison.get(key))){
    		//���������Z
    		effective.put(key, new Integer(ACCastUtilities.toInt(effective.get(key),0) + 1));
    	}
    }
    
    /**
     * �f�[�^���ύX����Ă��邩��r���A�ύX����Ă���Αޔ�p��Map�̒l��ύX����B
     * @param tentativeCalc �W�v��̃f�[�^
     * @param omparison ���O�̏W�v�f�[�^
     * @param effective ���ԓ��W�v�ޔ�p
     * @param key �Y���f�[�^�̃L�[
     * @throws Exception
     */
    private void setPeriodCalcDetailDiff(VRMap tentativeCalc,VRMap omparison,VRMap effective,String key,VRMap effectiveInValid, VRMap serviceDetail, VRMap addFixer) throws Exception {
    	if(tentativeCalc.get(key) != null){
    		if(serviceDetail == null && addFixer == null){
    			// �Ǘ��×{��̏ꍇ�i������т��n����Ȃ��A���ޔ����т��n����Ȃ��j
            	if(!tentativeCalc.get(key).equals(omparison.get(key))){
            		effective.put(key,tentativeCalc.get(key));
            	}
    		}else{
    			// ��1��Z����Z���b��m�肳��Ă���ꍇ�ɁA�m�菈�����s���B
    			if(serviceDetail.equals(addFixer)){
    				effective.put(key,tentativeCalc.get(key));
    				effective.put("FIXED_" + key,serviceDetail);
    			}
    		}
    	}
    }
    
    
    /**
     * �W�v���ʂ�ҏW���A�ԋp����B
     * @param tentativeCalc �P�������̑S�W�v����
     * @param effective �w��͈͓��̊e���ڂ̓���
     * @param rate ���p�ҕ��S����
     * @param additionFlag ���Z��ݒ肵�����m�F�p�̃t���O
     * @param result �ҏW�������ʃZ�b�g
     * @throws Exception
     */
    private void setResult(VRMap tentativeCalc, VRMap effective,
			boolean valid, VRList additionFlag,VRMap result) throws Exception {
    	
    	int increment = 1;
    	//�ݒ�m�F�p
    	int changeConfirmation = 0;
    	String prefix = "";
    	if (valid) {
    		//�ی��K�p��p�Ƃ��Čv��
    		prefix = "BY_INSURER_";
    	} else {
    		prefix = "BY_PATIENT_";
    	}
    	
    	//��{�×{��(I)(11)�ی��t�A���Y�t�A�Ō�t�A���w�Ö@�m�A��ƗÖ@�m -����(1��)
        // 2006/10/11
        // �������ύX
        // Replace - begin [Masahiko Higuchi]
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"��{�×{��I (���œ�)","1301033","1301034");
    	
    	//��{�×{��(I)(11)�ی��t�A���Y�t�A�Ō�t�A���w�Ö@�m�A��ƗÖ@�m -����(2��)
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"��{�×{��I (���œ�/�T4���ڈȍ~)","1301038","1301039");
    	
    	//��{�×{��(I)(12)�y�Ō�t -����(1��)
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"��{�×{��I (�y��)","1301043","1301044");
    	
    	//��{�×{��(I)(12)�y�Ō�t -����(2��)
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"��{�×{��I (�y��/�T4���ڈȍ~)","1301048","1301049");
    	
    	//��{�×{��(I)(13)��a��������K����Z(1��2��) -����
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"��a��������K����Z (1��2��܂�)","1301053","1301054");
    	
    	//��{�×{��(I)(13)��a��������K����Z(1��3��ȏ�) -����
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"��a��������K����Z (1��3��ȏ�)","1301058","1301059");
        // Replace - end [Masahiko Higuchi]
        
    	//��{�×{��(I)(14)�ً}�K��Ō���Z -����
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"�ً}�K��Ō���Z","1301153","1301154");
    	
    	//��{�×{��(II)(15)�ی��t�A�Ō�t�A��ƗÖ@�m -1��������̋��z
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"��{�×{��II","1301063","1301064");
    	
    	//��{�×{��(II)(16)�������ԉ��Z -���Ԑ�
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"�������ԉ��Z","1301068","1301069");
    	
    	//�Ǘ��×{�� �����̋��z
    	//�����������ʐݒ�
        
        //��{�×{��(I)(11)�ی��t�A���Y�t�A�Ō�t�A���w�Ö@�m�A��ƗÖ@�m -����(1��)
        // 2006/10/11
        // �������ύX
        // Replace - begin [Masahiko Higuchi]
    	increment = setResult(effective,result,prefix,increment,
    			"�Ǘ��×{�� (1����)","1301073");
    	
    	//�Ǘ��×{�� ����
    	increment = setResult(tentativeCalc,effective,result,prefix,increment,
    			"�Ǘ��×{�� (2���ڈȍ~)","1301074","1301075");
        // Replace - end [Masahiko Higuchi]
    	
    	//------------�ی��Ōv�サ�Ă���ꍇ�A���p�ґS�z���S�ł͌v�サ�Ȃ�
    	//24���ԘA���̐����Z
    	if(!additionFlag.contains("1301079")){
    		changeConfirmation = increment; 
        	increment = setResult(effective,result,prefix,increment,
        			"24���ԘA���̐����Z","1301079");
        	
        	if(increment != changeConfirmation){
        		additionFlag.add("1301079");
        	}
    	}
    	
    	//�d�ǎҊǗ����Z
    	if(!additionFlag.contains("1301082")){
    		changeConfirmation = increment;
	    	increment = setResult(effective,result,prefix,increment,
	    			"�d�ǎҊǗ����Z","1301082");
	    	
        	if(increment != changeConfirmation){
        		additionFlag.add("1301082");
        	}
    	}
    	//�މ@�������w�����Z ���v
    	if(!additionFlag.contains("1301085")){
    		changeConfirmation = increment;
	    	increment = setResult(effective,result,prefix,increment,
	    			"�n��A�g�މ@�������w�����Z","1301085");
	    	
        	if(increment != changeConfirmation){
        		additionFlag.add("1301085");
        	}
    	}
    	
    	//���񋟗×{��
    	if(!additionFlag.contains("1301088")){
    		changeConfirmation = increment;
	    	increment = setResult(effective,result,prefix,increment,
	    			"���񋟗×{��","1301088");
	    	
        	if(increment != changeConfirmation){
        		additionFlag.add("1301088");
        	}
    	}
    	
        
    	//�^�[�~�i���P�A�×{��1
        
        //��{�×{��(I)(11)�ی��t�A���Y�t�A�Ō�t�A���w�Ö@�m�A��ƗÖ@�m -����(1��)
        // 2006/10/11
        // �������ύX
        // Replace - begin [Masahiko Higuchi]
    	if(!additionFlag.contains("1301091")){
    		changeConfirmation = increment;
	    	increment = setResult(effective,result,prefix,increment,
	    			"�^�[�~�i���P�A�×{��I","1301091");
	    	
        	if(increment != changeConfirmation){
        		additionFlag.add("1301091");
        	}
    	}
    	
    	//�^�[�~�i���P�A�×{��2
    	if(!additionFlag.contains("1301158")){
    		changeConfirmation = increment;
	    	increment = setResult(effective,result,prefix,increment,
	    			"�^�[�~�i���P�A�×{��II","1301158");
	    	
        	if(increment != changeConfirmation){
        		additionFlag.add("1301158");
        	}
    	}
        // Replace - end [Masahiko Higuchi]
        
        // 2006/09/19
        // Addition - begin [Masahiko Higuchi]
        // ���݂��Ȃ����ڂ�KEY�݂̂�Ԃ��B
        for(int i = increment ; i <= 20 ;i++){
            result.put(prefix + "NAME" + increment,"");
            //�P��
            result.put(prefix + "PRICE" + increment,"");
            //����
            result.put(prefix + "NUMBER" + increment,"");
            //���v
            result.put(prefix + "SUM" + increment,"");
            
            increment++;
            
        }
        // Addition - end
        
    	//------------------------------------------------------------------
    }
    
    private int setResult(VRMap tentativeCalc, VRMap effective,VRMap result,
    		String prefix,int increment,String title, String priceKey,String dayKey) throws Exception {    
    	
    	if(ACCastUtilities.toInt(effective.get(dayKey),0) == 0){
    		return increment;
    	}
    	
		//���ږ�
		result.put(prefix + "NAME" + increment,title);
		//�P��
		result.put(prefix + "PRICE" + increment,tentativeCalc.get(priceKey));
		//����
		result.put(prefix + "NUMBER" + increment,effective.get(dayKey));
		//���v
		result.put(prefix + "SUM" + increment,new Integer(ACCastUtilities.toInt(tentativeCalc.get(priceKey),0)
												 * ACCastUtilities.toInt(effective.get(dayKey),0)));
		
    	return increment + 1;
    }
    
    private int setResult(VRMap period,VRMap result,
    		String prefix,int increment,String title, String priceKey) throws Exception {
    	
    	if (ACTextUtilities.isNullText(period.get(priceKey))) {
    		return increment;
    	}
		//���ږ�
		result.put(prefix + "NAME" + increment,title);
		//�P��
		result.put(prefix + "PRICE" + increment,period.get(priceKey));
		//����
		result.put(prefix + "NUMBER" + increment, "1");
		//���v
		result.put(prefix + "SUM" + increment, period.get(priceKey));
    	
    	return increment + 1;
    }
    
    
    /**
     * ���t�Ŏ��т��\�[�g����B
     */
    private class DateComparator implements java.util.Comparator {
        public int compare(Object object1, Object object2) {
            //���t�ŕ��ёւ���N���X
            Date date1 = ACCastUtilities.toDate(((Map)object1).get("SERVICE_DATE"), null);
            Date date2 = ACCastUtilities.toDate(((Map)object2).get("SERVICE_DATE"), null);
            if(date1==null){
                if(date2==null){
                    return 0;
                }
                return -1;
            }else if(date2==null){
                return 1;
            }
            return date1.compareTo(date2);
        }
    }
}
