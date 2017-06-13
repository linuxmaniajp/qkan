package jp.nichicom.ac.lib.care.claim.servicecode;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * �T�[�r�X�֘A�̋��ʊ֐��ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class CareServiceCommon {

    /**
     * ���t�Ǘ����x�z�Ώۂł��邱�Ƃ�����킷���t�Ǘ����x�z�Ώے萔�ł��B
     */
    public static final Integer IN_LIMIT_AMOUNT_SERVICE = new Integer(1);
    /**
     * ���t�Ǘ����x�z�ΏۊO�ł��邱�Ƃ�����킷���t�Ǘ����x�z�Ώے萔�ł��B
     */
    public static final Integer OUT_LIMIT_AMOUNT_SERVICE = new Integer(2);
    /**
     * �O�����p�^�ł��邱�Ƃ�����킷���t�Ǘ����x�z�Ώے萔�ł��B
     */
    public static final Integer OUTER_SERVICE_LIMIT_AMOUNT = new Integer(3);

    /**
     * ���t�Ǘ����x�z�Ώۂ̃T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return ���t�Ǘ����x�z�Ώۂ̃T�[�r�X�R�[�h�ł��邩
     */
    public static boolean isInLimitAmount(Map code) {
        // ���t�Ǘ����x�z�Ώۃt���O���擾����B
        // 0�F�H��A�P�ʐ��ŊǗ����Ȃ��T�[�r�X
        // 1�F���t�Ǘ����x�z�Ώ�
        // 2�F���t�Ǘ����x�z�ΏۊO
        return IN_LIMIT_AMOUNT_SERVICE.equals(code.get("LIMIT_AMOUNT_OBJECT"));
    }

    /**
     * ���n���Z(�����p��ݗ^�܂�)�̃T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return ���n���Z(�����p��ݗ^�܂�)�̃T�[�r�X�R�[�h�ł��邩
     */
    public static boolean isAddSpecialArea(Map code) {
    	// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - begin �T�[�r�X�R�[�h�p����
//        switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_KIND"), 0)) {
//        case 11:// �K����
//        case 12:// �K��������
//        case 62:// �\�h�K��������
//        case 63:// �\�h�K��Ō�
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 8000:// ���ʒn����Z
//                return true;
//            }
//            break;
//        case 13:// �K��Ō�
//        case 61:// �\�h�K����
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 8000:// ���ʒn����Z
//            case 8001:// ���ʒn����Z����
//                return true;
//            }
//            break;
//        case 17:// �����p��ݗ^
//        case 67:// �\�h�����p��ݗ^
//            return isAddSpecialAreaOfWelfareEquipment(code);
//        }
        String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "");
        String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"), "");
        if ("11".equals(serviceCodeKind)		// �K����
        	|| "12".equals(serviceCodeKind)		// �K��������
        	|| "62".equals(serviceCodeKind)		// �\�h�K��������
        	|| "63".equals(serviceCodeKind)		// �\�h�K��Ō�
        	) {
        	// ���ʒn����Z
            if ("8000".equals(serviceCodeItem)) {
                return true;
            }
        }
        if ("13".equals(serviceCodeKind)		// �K��Ō�
               	) {
            	// ���ʒn����Z or ���ʒn����Z����
                if ("8000".equals(serviceCodeItem) || "8001".equals(serviceCodeItem) || "8002".equals(serviceCodeItem)) {
                    return true;
                }
            }
        if ("61".equals(serviceCodeKind)		// �\�h�K����
        	|| "76".equals(serviceCodeKind)		// �������E�����Ή��^�K����Ō�
           	) {
        	// ���ʒn����Z or ���ʒn����Z����
            if ("8000".equals(serviceCodeItem) || "8001".equals(serviceCodeItem)) {
                return true;
            }
        }
        if ("17".equals(serviceCodeKind)		// �����p��ݗ^
        	|| "67".equals(serviceCodeKind)		// �\�h�����p��ݗ^
           	) {
        	return isAddSpecialAreaOfWelfareEquipment(code);
        }
        // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - end   �T�[�r�X�R�[�h�p����
        
        return false;
    }

    /**
     * �����p��ݗ^�ɂ�������n���Z�̃T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return �����p��ݗ^�ɂ�������n���Z�̃T�[�r�X�R�[�h�ł��邩
     */
    public static boolean isAddSpecialAreaOfWelfareEquipment(Map code) {
        // ���t�Ǘ��ΏۊO���P�ʉ��Z����P�ʎZ�肩�����p��ݗ^
        if (!isInLimitAmount(code)) {
            if ("2".equals(ACCastUtilities.toString(
                    code.get("SERVICE_ADD_FLAG"), ""))) {
                if ("1".equals(ACCastUtilities.toString(
                        code.get("TOTAL_GROUPING_TYPE"), ""))) {
                	// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - begin �T�[�r�X�R�[�h�p����
//                    switch (ACCastUtilities.toInt(
//                            code.get("SERVICE_CODE_KIND"), 0)) {
//                    case 17:// �����p��ݗ^
//                    case 67:// �\�h�����p��ݗ^
//                        return true;
//                    }
                	// 17:�����p��ݗ^ or 67:�\�h�����p��ݗ^
                	String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "");
                	if ("17".equals(serviceCodeKind) || "67".equals(serviceCodeKind)) {
                		return true;
                	}
                    // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - end   �T�[�r�X�R�[�h�p����
                }
            }
        }
        return false;
        // return (!isInLimitAmount(code))
        // && "2".equals(ACCastUtilities.toString(code
        // .get("SERVICE_ADD_FLAG")))
        // && "1".equals(ACCastUtilities.toString(code
        // .get("TOTAL_GROUPING_TYPE"), ""))
        // && "17".equals(ACCastUtilities.toString(code
        // .get("SERVICE_CODE_KIND"), ""));
    }

    /**
     * %�P�ʉ��Z�̃T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return %�P�ʉ��Z�̃T�[�r�X�R�[�h�ł��邩
     * @throws Exception ������O
     */
    public static boolean isAddPercentage(Map code) throws Exception {
        if (code != null) {
            switch (ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0)) {
            case 3:
                // %���Z
            case 5:
                // %���Z
            case 6:
                // %���Z(�Ώۂɒn��n���Z���܂�)
            case 7:
                // %���Z(�Ώۂɒn��n���Z���܂�)
                // [ID:0000682] 2012/01 start ���E���������P���Z�̒ǉ�����
            case 8:
                // %���Z(���E���������P���Z)
                // [ID:0000682] 2012/01 end
                return true;
            }
        }
        return false;
    }

    // [ID:0000682] 2012/01 start ���E���������P���Z�̒ǉ�����
    /**
     * %�P�ʉ��Z�̂����v�Z�Ώۂŏ������P���Z�̑Ώۂł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return %�P�ʉ��Z�̂����������P���Z�ł��邩��Ԃ��܂�
     * @throws Exception ������O
     */
    public static boolean isAddPercentageForSyogu(Map code) {
        if (code != null) {
            switch (ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0)) {
            case 8:
                return true;
            }
        }
        return false;
    }

    // [ID:0000682] 2012/01 end

    // [ID:0000444][Tozo TANAKA] 2009/03/20 add begin ����21�N4���@�����Ή�
    /**
     * %�P�ʉ��Z�̂����v�Z�Ώۂɒn��n���Z���܂܂Ȃ��T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return %�P�ʉ��Z�̂����Ώۂɒn��n���Z���܂܂Ȃ��T�[�r�X�R�[�h�ł��邩
     * @throws Exception ������O
     */
    public static boolean isAddPercentageForSimple(Map code) throws Exception {
        if (code != null) {
            switch (ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0)) {
            case 3:
                // %���Z
            case 5:
                // %���Z
                return true;
            }
        }
        return false;
    }

    /**
     * %�P�ʉ��Z�̂����v�Z�Ώۂɒn��n���Z���܂ރT�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return %�P�ʉ��Z�̂����Ώۂɒn��n���Z���܂ރT�[�r�X�R�[�h�ł��邩
     * @throws Exception ������O
     */
    public static boolean isAddPercentageForArea(Map code) throws Exception {
        if (code != null) {
            switch (ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0)) {
            case 6:
                // %���Z(�Ώۂɒn��n���Z���܂�)
            case 7:
                // %���Z(�Ώۂɒn��n���Z���܂�)
                return true;
            }
        }
        return false;
    }

    /**
     * %���Z(�Ώۂɒn��n���Z���܂�)�̑ΏۂɂȂ�n��n���Z�T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return %���Z(�Ώۂɒn��n���Z���܂�)�̑ΏۂɂȂ�n��n���Z�T�[�r�X�R�[�h�ł��邩
     * @throws Exception ������O
     */
    public static boolean isAddPercentageForAreaTarget(Map code)
            throws Exception {
        if (code != null) {
            String item = ACCastUtilities.toString(code
                    .get("SYSTEM_SERVICE_CODE_ITEM"));
            if (
            // ���ʒn��
            "Z8000".equals(item)
            // ���ʒn��(����)
                    || "Z8001".equals(item)
                    // ���R�Ԓn�擙�̏��K�͎��Ə�
                    || "Z8100".equals(item)
                    // ���R�Ԓn�擙�̏��K�͎��Ə�(����)
                    || "Z8101".equals(item)) {
                return true;
            }
        }
        return false;
    }

    // [ID:0000444][Tozo TANAKA] 2009/03/20 add end

    /**
     * ��{�I�ȍ����P�ʂ̃T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return ��{�I�ȍ����P�ʂ̃T�[�r�X�R�[�h�ł��邩
     * @throws Exception ������O
     */
    public static boolean isSimpleUnit(Map code) throws Exception {
        // return (code != null)
        // && "1".equals(ACCastUtilities.toString(code
        // .get("SERVICE_ADD_FLAG")));
        // �{�̕�V�t���O���L�� And
        // ���t���x�z�Ǘ��Ώۓ� or �O�����p�^�P�ʐ�
        if (code != null) {
            if ("1".equals(ACCastUtilities.toString(code
                    .get("SERVICE_MAIN_FLAG")))
                    && ("1".equals(ACCastUtilities.toString(code
                            .get("LIMIT_AMOUNT_OBJECT"))) || ("3"
                            .equals(ACCastUtilities.toString(code
                                    .get("LIMIT_AMOUNT_OBJECT")))))) {
                return true;
            }
        }

        return false;

    }

    /**
     * �ً}���K��Ō���Z���Ӗ�����T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return �ً}���K��Ō���Z���Ӗ�����T�[�r�X�R�[�h�ł��邩
     */
    public static boolean isAddEmergencyNursing(Map code) {
    	// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - begin �T�[�r�X�R�[�h�p����
//        switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_KIND"), 0)) {
//        case 13:// �K��Ō�
//        case 63:// �\�h�K��Ō�
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 3100:// �ً}���K��Ō���Z�P
//            case 3200:// �ً}���K��Ō���Z�Q
//                return true;
//            }
//        }
        String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "");
        String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"), "");
        if ("13".equals(serviceCodeKind)		// �K��Ō�
            || "63".equals(serviceCodeKind)		// �\�h�K��Ō�
        	) {
        	//3100:�ً}���K��Ō���Z�P or 3200:�ً}���K��Ō���Z�Q
        	if ("3100".equals(serviceCodeItem) || "3200".equals(serviceCodeItem)) {
                return true;
            }
        }
        // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - end   �T�[�r�X�R�[�h�p����
        
        return false;
    }

    /**
     * ���ʊǗ����Z���Ӗ�����T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return ���ʊǗ����Z���Ӗ�����T�[�r�X�R�[�h�ł��邩
     */
    public static boolean isAddSpecialManagement(Map code) {
    	// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - begin �T�[�r�X�R�[�h�p����
//        switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_KIND"), 0)) {
//        case 13:// �K��Ō�
//        case 63:// �\�h�K��Ō�
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 4000:// ���ʊǗ����Z�P
//            case 4001:// ���ʊǗ����Z�Q
//                return true;
//            }
//        }
        String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "");
        String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"), "");
        if ("13".equals(serviceCodeKind)		// �K��Ō�
            || "63".equals(serviceCodeKind)		// �\�h�K��Ō�
        	) {
        	//4000:���ʊǗ����Z�P or 4001:���ʊǗ����Z�Q
        	if ("4000".equals(serviceCodeItem) || "4001".equals(serviceCodeItem)) {
                return true;
            }
        }
        // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - end   �T�[�r�X�R�[�h�p����
        
        return false;
    }

    /**
     * �ً}�����ÊǗ����Ӗ�����T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return �ً}�����ÊǗ����Ӗ�����T�[�r�X�R�[�h�ł��邩
     */
    public static boolean isAddEmergencyMedicalManagement(Map code) {
    	// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - begin �T�[�r�X�R�[�h�p����
//        switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_KIND"), 0)) {
//        case 22:// �Z������
//        case 25:// �\�h�Z������
//        case 52:// �ی��{��
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 9000:// �ً}�����ÊǗ��P
//            case 6000:// �ً}�����ÊǗ��Q
//                return true;
//            }
//        }
        String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "");
        String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"), "");
        if ("22".equals(serviceCodeKind)		// �Z������
            || "25".equals(serviceCodeKind)		// �\�h�Z������
            || "52".equals(serviceCodeKind)		// �ی��{��
        	) {
        	//9000:�ً}�����ÊǗ��P or 6000:�ً}�����ÊǗ��Q
        	if ("9000".equals(serviceCodeItem) || "6000".equals(serviceCodeItem)) {
                return true;
            }
        }
        // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - end   �T�[�r�X�R�[�h�p����
        
        return false;
    }

    /**
     * �^�[�~�i���P�A���Z���Ӗ�����T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return ���ʊǗ����Z���Ӗ�����T�[�r�X�R�[�h�ł��邩
     */
    public static boolean isAddTerminalCare(Map code) {
    	// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - begin �T�[�r�X�R�[�h�p����
//        switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_KIND"), 0)) {
//        case 13:// �K��Ō�
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 7000:// �^�[�~�i���P�A���Z
//                return true;
//            }
//            break;
//        case 52: // ���×{�^�V�l�ی��{��
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 6600: // �ی��{�݃^�[�~�i���P�A���Z�P�P
//            case 6001: // �ی��{�݃^�[�~�i���P�A���Z�P�Q
//            case 6602: // �ی��{�݃^�[�~�i���P�A���Z�Q�P
//            case 6002: // �ی��{�݃^�[�~�i���P�A���Z�Q�Q
//            case 6603: // �ی��{�݃^�[�~�i���P�A���Z�R�P
//            case 6003: // �ی��{�݃^�[�~�i���P�A���Z�R�Q
//                return true;
//            }
//            break;
//
//        }
        String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "");
        String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"), "");
        // �K��Ō�
        if ("13".equals(serviceCodeKind)) {
        	//7000:�^�[�~�i���P�A���Z
        	if ("7000".equals(serviceCodeItem)) {
                return true;
            }
        }
        // ���×{�^�V�l�ی��{��
        if ("52".equals(serviceCodeKind)) {
            	if ("6600".equals(serviceCodeItem)		//�ی��{�݃^�[�~�i���P�A���Z�P�P
            		|| "6001".equals(serviceCodeItem)	//�ی��{�݃^�[�~�i���P�A���Z�P�Q
            		|| "6602".equals(serviceCodeItem)	//�ی��{�݃^�[�~�i���P�A���Z�Q�P
            		|| "6002".equals(serviceCodeItem)	//�ی��{�݃^�[�~�i���P�A���Z�Q�Q
            		|| "6603".equals(serviceCodeItem)	//�ی��{�݃^�[�~�i���P�A���Z�R�P
            		|| "6003".equals(serviceCodeItem)	//�ی��{�݃^�[�~�i���P�A���Z�R�Q
            		) {
                    return true;
                }
        }
        // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - end   �T�[�r�X�R�[�h�p����
        return false;
    }

    /**
     * ���t�Ǘ����x�z�ΏۊO�̃T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return ���t�Ǘ����x�z�ΏۊO�̃T�[�r�X�R�[�h�ł��邩
     */
    public static boolean isOutLimitAmount(Map code) {
        return OUT_LIMIT_AMOUNT_SERVICE.equals(code.get("LIMIT_AMOUNT_OBJECT"));
    }

    /**
     * �O�����p�^�̃T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return �O�����p�^�̃T�[�r�X�R�[�h�ł��邩
     */
    public static boolean isOuterServiceLimitAmount(Map code) {
        return OUTER_SERVICE_LIMIT_AMOUNT.equals(code
                .get("LIMIT_AMOUNT_OBJECT"));
    }

    /**
     * �ʏ��n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �ʏ��n�T�[�r�X�ł��邩
     */
    public static boolean isFacilityVisit(int systemServiceKindDetail) {
        return isFacilityVisitCare(systemServiceKindDetail)
                || isFacilityVisitRehabilitation(systemServiceKindDetail)
                || isFacilityVisitMultifunction(systemServiceKindDetail);
    }

    /**
     * �ʏ��n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �ʏ��n�T�[�r�X�ł��邩
     */
    public static boolean isFacilityVisit(Map service) {
        return isFacilityVisit(toInt(service));
    }

    /**
     * �ʏ��n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �ʏ��n�T�[�r�X�ł��邩
     */
    public static boolean isFacilityVisit(String systemServiceKindDetail) {
        return isFacilityVisit(toInt(systemServiceKindDetail));
    }

    /**
     * �{�݌n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �{�݌n�T�[�r�X�ł��邩
     */
    public static boolean isFacility(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 15111:// ���V�l�����{��
        case 15211:// ���V�l�ی��{��
        case 15311:// ���×{�^��Î{��(�×{�a����L����a�@)
        case 15312:// ���×{�^��Î{��(�×{�a����L����f�Ï�)
        case 15313:// ���×{�^��Î{��(�V�l���F�m�ǎ����×{�a����L����a�@)
        case 15411:// �n�斧���^��앟���{��
            return true;
        }
        return false;
    }

    /**
     * �F�m�ǑΉ��^�����������������͓���{�ݓ����Ґ������ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �F�m�ǑΉ��^�����������������͓���{�ݓ����Ґ������ł��邩
     */
    public static boolean isLifeCare(int systemServiceKindDetail) {
        return isLifeCareInGroupHome(systemServiceKindDetail)
                || isLifeCareInCareHouse(systemServiceKindDetail);
    }

    /**
     * �F�m�ǑΉ��^�����������������͓���{�ݓ����Ґ������ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �F�m�ǑΉ��^�����������������͓���{�ݓ����Ґ������ł��邩
     */
    public static boolean isLifeCare(Map service) {
        return isLifeCare(toInt(service));
    }

    /**
     * �F�m�ǑΉ��^�����������������͓���{�ݓ����Ґ������ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �F�m�ǑΉ��^�����������������͓���{�ݓ����Ґ������ł��邩
     */
    public static boolean isLifeCare(String systemServiceKindDetail) {
        return isLifeCare(toInt(systemServiceKindDetail));
    }

    /**
     * �F�m�ǑΉ��^�����������ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �F�m�ǑΉ��^�����������ł��邩
     */
    public static boolean isLifeCareInGroupHome(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 13211:// �F�m�ǑΉ��^�����������(�Z�����p�ȊO)
        case 13711: // ���\�h�F�m�ǑΉ��^�����������i�Z�����p�ȊO�j
            return true;
        }
        return false;
    }

    /**
     * �F�m�ǑΉ��^�����������ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �F�m�ǑΉ��^�����������ł��邩
     */
    public static boolean isLifeCareInGroupHome(Map service) {
        return isLifeCareInGroupHome(toInt(service));
    }

    /**
     * �F�m�ǑΉ��^�����������ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �F�m�ǑΉ��^�����������ł��邩
     */
    public static boolean isLifeCareInGroupHome(String systemServiceKindDetail) {
        return isLifeCareInGroupHome(toInt(systemServiceKindDetail));
    }

    /**
     * ����{�ݓ����Ґ������ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ����{�ݓ����Ґ������ł��邩
     */
    public static boolean isLifeCareInCareHouse(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 13311:// ����{�ݓ����Ґ������
        case 13611:// �n�斧���^����{�ݓ����Ґ������
        case 13511: // ���\�h����{�ݓ����Ґ������
            return true;
        }
        return false;
    }

    /**
     * ����{�ݓ����Ґ������ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return ����{�ݓ����Ґ������ł��邩
     */
    public static boolean isLifeCareInCareHouse(Map service) {
        return isLifeCareInCareHouse(toInt(service));
    }

    /**
     * ����{�ݓ����Ґ������ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ����{�ݓ����Ґ������ł��邩
     */
    public static boolean isLifeCareInCareHouse(String systemServiceKindDetail) {
        return isLifeCareInCareHouse(toInt(systemServiceKindDetail));
    }

    /**
     * �K����ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �K����ł��邩
     */
    public static boolean isHomeVisitCare(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 11111:// �K����
        case 17111:// ��ԑΉ��^�K����
        case 16111: // ���\�h�K����
        case 17611: // �������E�����Ή��^�K����Ō�
            return true;
        }
        return false;
    }

    /**
     * �K����ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �K����ł��邩
     */
    public static boolean isHomeVisitCare(Map service) {
        return isHomeVisitCare(toInt(service));
    }

    /**
     * �K����ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �K����ł��邩
     */
    public static boolean isHomeVisitCare(String systemServiceKindDetail) {
        return isHomeVisitCare(toInt(systemServiceKindDetail));
    }

    /**
     * �K��������ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �K��������ł��邩
     */
    public static boolean isHomeVisitBathing(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 11211:// �K��������
        case 16211: // ���\�h�K��������
            return true;
        }
        return false;
    }

    /**
     * �K��������ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �K��������ł��邩
     */
    public static boolean isHomeVisitBathing(Map service) {
        return isHomeVisitBathing(toInt(service));
    }

    /**
     * �K��������ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �K��������ł��邩
     */
    public static boolean isHomeVisitBathing(String systemServiceKindDetail) {
        return isHomeVisitBathing(toInt(systemServiceKindDetail));
    }

    /**
     * �K��Ō�(���ی�)�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �K��Ō�(���ی�)�ł��邩
     */
    public static boolean isHomeVisitNursing(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 11311:// �K��Ō�(���ی�)
        case 16311: // ���\�h�K��Ō�
            return true;
        }
        return false;
    }

    /**
     * �K��Ō�(���ی�)�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �K��Ō�(���ی�)�ł��邩
     */
    public static boolean isHomeVisitNursing(Map service) {
        return isHomeVisitNursing(toInt(service));
    }

    /**
     * �K��Ō�(���ی�)�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �K��Ō�(���ی�)�ł��邩
     */
    public static boolean isHomeVisitNursing(String systemServiceKindDetail) {
        return isHomeVisitNursing(toInt(systemServiceKindDetail));
    }

    /**
     * �K�⃊�n�r���e�[�V�����ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �K�⃊�n�r���e�[�V�����ł��邩
     */
    public static boolean isHomeVisitRehabilitation(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 11411:// �K�⃊�n�r���e�[�V����
        case 16411: // ���\�h�K�⃊�n
            return true;
        }
        return false;
    }

    /**
     * �K�⃊�n�r���e�[�V�����ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �K�⃊�n�r���e�[�V�����ł��邩
     */
    public static boolean isHomeVisitRehabilitation(Map service) {
        return isHomeVisitRehabilitation(toInt(service));
    }

    /**
     * �K�⃊�n�r���e�[�V�����ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �K�⃊�n�r���e�[�V�����ł��邩
     */
    public static boolean isHomeVisitRehabilitation(
            String systemServiceKindDetail) {
        return isHomeVisitRehabilitation(toInt(systemServiceKindDetail));
    }

    /**
     * �ʏ����ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �ʏ����ł��邩
     */
    public static boolean isFacilityVisitCare(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 11511: // �ʏ����
        case 17211: // �F�m�ǑΉ��^�ʏ����
        case 16511: // ���\�h�ʏ����
        case 17411: // ���\�h�F�m�ǑΉ��^�ʏ����
        case 17811: // �n�斧���^�ʏ���� H28.4
            return true;
        }
        return false;
    }

    /**
     * �ʏ����ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �ʏ����ł��邩
     */
    public static boolean isFacilityVisitCare(Map service) {
        return isFacilityVisitCare(toInt(service));
    }

    /**
     * �ʏ����ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �ʏ����ł��邩
     */
    public static boolean isFacilityVisitCare(String systemServiceKindDetail) {
        return isFacilityVisitCare(toInt(systemServiceKindDetail));
    }

    /**
     * �ʏ����n�r���e�[�V�����ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �ʏ����n�r���e�[�V�����ł��邩
     */
    public static boolean isFacilityVisitRehabilitation(
            int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 11611:// �ʏ����n�r���e�[�V����
        case 16611: // ���\�h�ʏ����n
            return true;
        }
        return false;
    }

    /**
     * �ʏ����n�r���e�[�V�����ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �ʏ����n�r���e�[�V�����ł��邩
     */
    public static boolean isFacilityVisitRehabilitation(Map service) {
        return isFacilityVisitRehabilitation(toInt(service));
    }

    /**
     * �ʏ����n�r���e�[�V�����ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �ʏ����n�r���e�[�V�����ł��邩
     */
    public static boolean isFacilityVisitRehabilitation(
            String systemServiceKindDetail) {
        return isFacilityVisitRehabilitation(toInt(systemServiceKindDetail));
    }

    /**
     * �{�݌n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �{�݌n�T�[�r�X�ł��邩
     */
    public static boolean isFacility(Map service) {
        return isFacility(toInt(service));
    }

    /**
     * �{�݌n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �{�݌n�T�[�r�X�ł��邩
     */
    public static boolean isFacility(String systemServiceKindDetail) {
        return isFacility(toInt(systemServiceKindDetail));
    }

    /**
     * ����n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ����n�T�[�r�X�ł��邩
     */
    public static boolean isHome(int systemServiceKindDetail) {
        return isHomeVisit(systemServiceKindDetail)
                || isFacilityVisit(systemServiceKindDetail)
                || isWelfareEquipment(systemServiceKindDetail)
                || isShortStay(systemServiceKindDetail)
                || isLifeCare(systemServiceKindDetail)
                || isCareManagement(systemServiceKindDetail);
    }

    /**
     * ����n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return ����n�T�[�r�X�ł��邩
     */
    public static boolean isHome(Map service) {
        return isHome(toInt(service));
    }

    /**
     * ����n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ����n�T�[�r�X�ł��邩
     */
    public static boolean isHome(String systemServiceKindDetail) {
        return isHome(toInt(systemServiceKindDetail));
    }

    /**
     * �Z�������n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �Z�������n�T�[�r�X�ł��邩
     */
    public static boolean isShortStay(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 12111:// �Z�������������
        case 12211:// �Z�������×{���(�V��)
        case 12311:// �Z�������×{���(�×{�a����L����a�@)
        case 12312:// �Z�������×{���(�×{�a����L����f�Ï�)
        case 12313:// �Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@)
        case 13811:// �F�m�ǑΉ��^�����������(�Z�����p)
        case 12411: // ���\�h�Z�������������
        case 12511: // ���\�h�Z�������×{���i�V���j
        case 12611: // ���\�h�Z�������×{���i�a�@�j
        case 12612: // ���\�h�Z�������×{���i�f�Ï��j
        case 12613: // ���\�h�Z�������×{���i�F�m�ǎ����^�j
        case 13911: // ���\�h�F�m�ǑΉ��^�����������i�Z�����p�j

        case 12711: // ����{�ݓ����Ґ������i�Z�����p�j
        case 12811: // �n�斧���^����{�ݓ����Ґ������i�Z�����p�j
            return true;
        }
        return false;
    }

    /**
     * �Z�������n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �Z�������n�T�[�r�X�ł��邩
     */
    public static boolean isShortStay(Map service) {
        return isShortStay(toInt(service));
    }

    /**
     * �Z�������n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �Z�������n�T�[�r�X�ł��邩
     */
    public static boolean isShortStay(String systemServiceKindDetail) {
        return isShortStay(toInt(systemServiceKindDetail));
    }

    /**
     * �K��n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �K��n�T�[�r�X�ł��邩
     */
    public static boolean isHomeVisit(int systemServiceKindDetail) {
        return isHomeVisitCare(systemServiceKindDetail)
                || isHomeVisitBathing(systemServiceKindDetail)
                || isHomeVisitNursing(systemServiceKindDetail)
                || isHomeVisitRehabilitation(systemServiceKindDetail);
    }

    /**
     * �K��n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �K��n�T�[�r�X�ł��邩
     */
    public static boolean isHomeVisit(Map service) {
        return isHomeVisit(toInt(service));
    }

    /**
     * �K��n�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �K��n�T�[�r�X�ł��邩
     */
    public static boolean isHomeVisit(String systemServiceKindDetail) {
        return isHomeVisit(toInt(systemServiceKindDetail));
    }

    /**
     * �����p��ݗ^�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �����p��ݗ^�T�[�r�X�ł��邩
     */
    public static boolean isWelfareEquipment(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 11711:// �����p��ݗ^
        case 16711: // ���\�h�����p��ݗ^
            return true;
        }
        return false;
    }

    /**
     * �����p��ݗ^�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �����p��ݗ^�T�[�r�X�ł��邩
     */
    public static boolean isWelfareEquipment(Map service) {
        return isWelfareEquipment(toInt(service));
    }

    /**
     * �����p��ݗ^�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �����p��ݗ^�T�[�r�X�ł��邩
     */
    public static boolean isWelfareEquipment(String systemServiceKindDetail) {
        return isWelfareEquipment(toInt(systemServiceKindDetail));
    }

    /**
     * ���K�͑��@�\�^������T�[�r�X�ł��邩��Ԃ��܂��B
     * ��������x�����s���T�[�r�X����ŗ��p���邽�߁A�Z�����p�i68,69,79�͊܂߂Ȃ��j
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ���K�͑��@�\�^������T�[�r�X�ł��邩
     */
    public static boolean isFacilityVisitMultifunction(
            int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 17311:// ���K�͑��@�\�^������
        case 17511: // ���\�h���K�͑��@�\�^������
        case 17711: // �����^�T�[�r�XI
            return true;
        }
        return false;
    }

    /**
     * ���K�͑��@�\�^������T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return ���K�͑��@�\�^������T�[�r�X�ł��邩
     */
    public static boolean isFacilityVisitMultifunction(Map service) {
        return isFacilityVisitMultifunction(toInt(service));
    }

    /**
     * ���K�͑��@�\�^������T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ���K�͑��@�\�^������T�[�r�X�ł��邩
     */
    public static boolean isFacilityVisitMultifunction(
            String systemServiceKindDetail) {
        return isFacilityVisitMultifunction(toInt(systemServiceKindDetail));
    }

    /**
     * ������x���T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ������x���T�[�r�X�ł��邩
     */
    public static boolean isCareManagement(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 14311:// ������x��
        case 14611: // ���\�h�x��
            return true;
        }
        return false;
    }

    /**
     * ������x���T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return ������x���T�[�r�X�ł��邩
     */
    public static boolean isCareManagement(Map service) {
        return isCareManagement(toInt(service));
    }

    /**
     * ������x���T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ������x���T�[�r�X�ł��邩
     */
    public static boolean isCareManagement(String systemServiceKindDetail) {
        return isCareManagement(toInt(systemServiceKindDetail));
    }

    /**
     * ��ȓ��퐶����̊����T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ��ȓ��퐶����̊����T�[�r�X�ł��邩
     */
    public static boolean isDailyAction(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 90201:// ��ȓ��퐶����̊���
        case 90211:// ��ȓ��퐶����̊���
            return true;
        }
        return false;
    }

    /**
     * ��ȓ��퐶����̊����T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return ��ȓ��퐶����̊����T�[�r�X�ł��邩
     */
    public static boolean isDailyAction(Map service) {
        return isDailyAction(toInt(service));
    }

    /**
     * ��ȓ��퐶����̊����T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ��ȓ��퐶����̊����T�[�r�X�ł��邩
     */
    public static boolean isDailyAction(String systemServiceKindDetail) {
        return isDailyAction(toInt(systemServiceKindDetail));
    }

    /**
     * ���̑��̃T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ���̑��̃T�[�r�X�ł��邩
     */
    public static boolean isOtherService(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 90101:// ���̑�
        case 90111:// ���̑�
            return true;
        }
        return false;
    }

    /**
     * ���̑��̃T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return ���̑��̃T�[�r�X�ł��邩
     */
    public static boolean isOtherService(Map service) {
        return isOtherService(toInt(service));
    }

    /**
     * ���̑��̃T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ���̑��̃T�[�r�X�ł��邩
     */
    public static boolean isOtherService(String systemServiceKindDetail) {
        return isOtherService(toInt(systemServiceKindDetail));
    }

    /**
     * �T�ԕ\�ɂ̂ݎg�p�\�ȃT�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �T�ԕ\�ɂ̂ݎg�p�\�ȃT�[�r�X�ł��邩
     */
    public static boolean isOnlyWeekly(int systemServiceKindDetail) {
        return isDailyAction(systemServiceKindDetail)
                || isOtherService(systemServiceKindDetail);
    }

    /**
     * �T�ԕ\�ɂ̂ݎg�p�\�ȃT�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �T�ԕ\�ɂ̂ݎg�p�\�ȃT�[�r�X�ł��邩
     */
    public static boolean isOnlyWeekly(Map service) {
        return isOnlyWeekly(toInt(service));
    }

    /**
     * �T�ԕ\�ɂ̂ݎg�p�\�ȃT�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �T�ԕ\�ɂ̂ݎg�p�\�ȃT�[�r�X�ł��邩
     */
    public static boolean isOnlyWeekly(String systemServiceKindDetail) {
        return isOnlyWeekly(toInt(systemServiceKindDetail));
    }

    /**
     * �T�[�r�X��ނ�Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �T�[�r�X���
     */
    protected static int toInt(Map service) {
        if (service == null) {
            return -1;
        }
        return ACCastUtilities.toInt(service.get("SYSTEM_SERVICE_KIND_DETAIL"),
                -1);
    }

    /**
     * ������\���̃T�[�r�X��ނ�int�ɕϊ����ĕԂ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �T�[�r�X���
     */
    protected static int toInt(String systemServiceKindDetail) {
        return ACCastUtilities.toInt(systemServiceKindDetail, -1);
    }

    /**
     * �R���X�g���N�^�ł��B
     */
    protected CareServiceCommon() {
    }

    /**
     * 30�����̃T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return 30�����̃T�[�r�X�ł��邩
     */
    public static boolean is30DayOver(VRMap service) {
        try {
            return "2".equals(ACCastUtilities.toString(
                    VRBindPathParser.get("5", service), ""));
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * ����×{�Ǘ��w���T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ����×{�Ǘ��w���T�[�r�X�ł��邩
     */
    public static boolean isHomeMedicalAdvice(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 13111:// ����×{�Ǘ��w��
        case 13411: // ���\�h����×{�Ǘ��w��
            return true;
        }
        return false;
    }

    /**
     * ����×{�Ǘ��w���T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return ����×{�Ǘ��w���T�[�r�X�ł��邩
     */
    public static boolean isHomeMedicalAdvice(Map service) {
        return isHomeMedicalAdvice(toInt(service));
    }

    /**
     * ����×{�Ǘ��w���T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ����×{�Ǘ��w���T�[�r�X�ł��邩
     */
    public static boolean isHomeMedicalAdvice(String systemServiceKindDetail) {
        return isHomeMedicalAdvice(toInt(systemServiceKindDetail));
    }

    /**
     * �O���̎��тł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X����
     * @return �O���̎��тł��邩 0:�ΏۊO 1:�O������ 2:�O��
     */
    public static int isGaihaku(VRMap service) {
        int result = 0;
        /*
         * try { // ���s�I�ޏ��T�[�r�X����Q�� if (service.containsKey("1520129")) { result =
         * ACCastUtilities.toInt(service.get("1520129"), 0); } else if
         * (service.containsKey("1530119")) { // 2006/07/11 �×{�^�Ή� // ���s�I�މ@�T�[�r�X��
         * result = ACCastUtilities.toInt(service.get("1530119"), 0); //
         * �O���̃t���O���Q�� } else if (service.containsKey("1510111")) { result =
         * ACCastUtilities.toInt(service.get("1510111"), 0); } else if
         * (service.containsKey("1520107")) { result =
         * ACCastUtilities.toInt(service.get("1520107"), 0); } else if
         * (service.containsKey("1530108")) { result =
         * ACCastUtilities.toInt(service.get("1530108"), 0); } else if
         * (service.containsKey("1530206")) { result =
         * ACCastUtilities.toInt(service.get("1530206"), 0); } else if
         * (service.containsKey("1530305")) { result =
         * ACCastUtilities.toInt(service.get("1530305"), 0); } else if
         * (service.containsKey("1540112")) { result =
         * ACCastUtilities.toInt(service.get("1540112"), 0); // ���Ȏ�f�̃t���O���Q�� }
         * else if (service.containsKey("1530110")) { if
         * (ACCastUtilities.toInt(service.get("1530110"), 0) == 2) { result = 1;
         * } } else if (service.containsKey("1530208")) { if
         * (ACCastUtilities.toInt(service.get("1530208"), 0) == 2) { result = 1;
         * } } else if (service.containsKey("1530307")) { if
         * (ACCastUtilities.toInt(service.get("1530307"), 0) == 2) { result = 1;
         * } } else { // �V���[�g�X�e�C�ΏۂȂ�O�������Ɣ��� if (isShortStay(service)) { result =
         * 1; } else { // �l����Z�̗�O�P�[�X�ɑΉ� switch (ACCastUtilities.toInt(
         * service.get("SYSTEM_SERVICE_KIND_DETAIL"), 0)) { //
         * �F�m�ǑΉ��^�����������(�Z�����p�ȊO) case 13211: // ����{�ݓ����Ґ������ case 13311: //
         * �n�斧���^����{�ݓ����Ґ������ case 13611: // �F�m�ǑΉ��^�����������(�Z�����p) case 13811:
         * 
         * // ���\�h�Ή��J�n // ���\�h�F�m�ǑΉ��^�����������i�Z�����p�ȊO�j case 13711: //
         * ���\�h����{�ݓ����Ґ������ case 13511: // ���\�h�F�m�ǑΉ��^�����������i�Z�����p�j case 13911: //
         * ���\�h�Ή��I�� result = 1; break; }
         * 
         * } } } catch (Exception e) { }
         */

        try {
            // ���s�I�ޏ��T�[�r�X����Q��
            if (service.containsKey("1520129")) {
                result = ACCastUtilities.toInt(service.get("1520129"), 0);
            } else if (service.containsKey("1530119")) {
                // 2006/07/11 �×{�^�Ή� // ���s�I�މ@�T�[�r�X��
                result = ACCastUtilities.toInt(service.get("1530119"), 0);
                // �O���̃t���O���Q��
            } else if (service.containsKey("1510111")) {
                result = ACCastUtilities.toInt(service.get("1510111"), 0);
            } else if (service.containsKey("1520107")) {
                result = ACCastUtilities.toInt(service.get("1520107"), 0);
            } else if (service.containsKey("1530108")) {
                result = ACCastUtilities.toInt(service.get("1530108"), 0);
            } else if (service.containsKey("1530206")) {
                result = ACCastUtilities.toInt(service.get("1530206"), 0);
            } else if (service.containsKey("1530305")) {
                result = ACCastUtilities.toInt(service.get("1530305"), 0);
            } else if (service.containsKey("1540112")) {
                result = ACCastUtilities.toInt(service.get("1540112"), 0);
                // ���Ȏ�f�̃t���O���Q��
            } else if (service.containsKey("1530110")) {
                if (ACCastUtilities.toInt(service.get("1530110"), 0) == 2) {
                    result = 1;
                }
            } else if (service.containsKey("1530208")) {
                if (ACCastUtilities.toInt(service.get("1530208"), 0) == 2) {
                    result = 1;
                }
            } else if (service.containsKey("1530307")) {
                if (ACCastUtilities.toInt(service.get("1530307"), 0) == 2) {
                    result = 1;
                }
            } else {
                // �V���[�g�X�e�C�ΏۂȂ�O�������Ɣ���
                if (isShortStay(service)) {
                    result = 1;
                } else {
                    // �l����Z�̗�O�P�[�X�ɑΉ�
                    switch (ACCastUtilities.toInt(
                            service.get("SYSTEM_SERVICE_KIND_DETAIL"), 0)) {
                    // �F�m�ǑΉ��^�����������(�Z�����p�ȊO)
                    case 13211:
                        // ����{�ݓ����Ґ������
                    case 13311:
                        // �n�斧���^����{�ݓ����Ґ������
                    case 13611:
                        // �F�m�ǑΉ��^�����������(�Z�����p)
                    case 13811:
                        // ���\�h�Ή��J�n
                        // ���\�h�F�m�ǑΉ��^�����������i�Z�����p�ȊO�j
                    case 13711:
                        // ���\�h����{�ݓ����Ґ������
                    case 13511:
                        // ���\�h�F�m�ǑΉ��^�����������i�Z�����p�j
                    case 13911:
                        // ���\�h�Ή��I��
                        result = 1;
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }

        // if (ACCastUtilities.toInt(service.get("SERVICE_ADD_TYPE"), 0) == 1) {
        // result = 1;
        // }

        return result;
    }

    /**
     * �ʕ\�ɉ񐔂��󎚂��Ă悢�T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X�R�[�h
     * @return �ʕ\�ɉ񐔂��󎚂��Ă悢�T�[�r�X�R�[�h�ł��邩
     */
    public static boolean isCountPrintableServiceCode(Map service) {
        try {
            if ("2".equals(ACCastUtilities.toString(
                    service.get("LIMIT_AMOUNT_OBJECT"), ""))) {
                // ���t�Ǘ��ΏۊO
                String addFlag = ACCastUtilities.toString(
                        service.get("SERVICE_ADD_FLAG"), "");
                String totalType = ACCastUtilities.toString(
                        service.get("TOTAL_GROUPING_TYPE"), "");
                if ("2".equals(addFlag) && "3".equals(totalType)) {
                    // �P�ƒP�ʉ��Z�����P�ʎZ��Ȃ�Ή񐔂��󎚂��Ȃ�
                    return false;
                }
                if ("3".equals(addFlag)) {
                    // �P��%���Z�Ȃ�Ή񐔂��󎚂��Ȃ�
                    return false;
                }
                if ("6".equals(addFlag)) {
                    // %���Z(�Ώۂɒn��n���Z���܂�)�Ȃ�Ή񐔂��󎚂��Ȃ�
                    return false;
                }
                // [ID:0000682] 2012/01 start ���E���������P���Z�̒ǉ�����
                if ("8".equals(addFlag)) {
                    // %���Z(���E���������P)
                    return false;
                }
                // [ID:0000682] 2012/01 end
                // �\�h���n���Z�Ή��̂���
                if (isAddSpecialArea(service)) {
                    // ���n���Z�Ȃ�Ή񐔂��󎚂��Ȃ�
                    return false;
                }
            }
        } catch (Exception ex) {
        }
        return true;
    }

    /**
     * �\�h�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �\�h�T�[�r�X�ł��邩
     */
    public static boolean isPreventService(Map service) {
        return isPreventService(toInt(service));
    }

    /**
     * �\�h�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �\�h�T�[�r�X�ł��邩
     */
    public static boolean isPreventService(String systemServiceKindDetail) {
        return isPreventService(toInt(systemServiceKindDetail));
    }

    /**
     * �\�h�T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �\�h�T�[�r�X�ł��邩
     */
    public static boolean isPreventService(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 16111: // ���\�h�K����
        case 16211: // ���\�h�K��������
        case 16311: // ���\�h�K��Ō�
        case 16411: // ���\�h�K�⃊�n
        case 16511: // ���\�h�ʏ����
        case 16611: // ���\�h�ʏ����n
        case 16711: // ���\�h�����p��ݗ^
        case 12411: // ���\�h�Z�������������
        case 12511: // ���\�h�Z�������×{���i�V���j
        case 12611: // ���\�h�Z�������×{���i�a�@�j
        case 12612: // ���\�h�Z�������×{���i�f�Ï��j
        case 12613: // ���\�h�Z�������×{���i�F�m�ǎ����^�j
        case 13411: // ���\�h����×{�Ǘ��w��
        case 13511: // ���\�h����{�ݓ����Ґ������
        case 14611: // ���\�h�x��
        case 17411: // ���\�h�F�m�ǑΉ��^�ʏ����
        case 17511: // ���\�h���K�͑��@�\�^������
        case 16911: // ���\�h���K�͑��@�\�^������i�Z�����p�j[H27.4�����Ή�]
        case 13711: // ���\�h�F�m�ǑΉ��^�����������i�Z�����p�ȊO�j
        case 13911: // ���\�h�F�m�ǑΉ��^�����������i�Z�����p�j
            return true;
        }
        return false;
    }

    /**
     * �\�h�K����̓����łȂ������P�ʂ��Ӗ�����T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return �\�h�K����̓����łȂ������P�ʂ��Ӗ�����T�[�r�X�R�[�h�ł��邩
     */
    public static boolean isAddPreventHomeVisitNotDailyBasicCode(Map code) {
    	// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - begin �T�[�r�X�R�[�h�p�����Ɩ��Ή��R�[�h����ǉ�
//        switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_KIND"), 0)) {
//        case 61:// �\�h�K����
//            switch (ACCastUtilities.toInt(code.get("SERVICE_CODE_ITEM"), 0)) {
//            case 1111:// �\�h�K����T
//            case 1112:// �\�h�K����T�E�R��
//            case 1211:// �\�h�K����U
//            case 1212:// �\�h�K����U�E�R��
//            case 1321:// �\�h�K����V
//            case 1322:// �\�h�K����V�E�R��
//                return true;
//            }
//        }
        String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "");
        String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"), "");
        if ("61".equals(serviceCodeKind)) {	// �\�h�K����
        	if ("1111".equals(serviceCodeItem)		//�\�h�K����P
				|| "1113".equals(serviceCodeItem)	//�\�h�K����P�E���C
				|| "1114".equals(serviceCodeItem)	//�\�h�K����P�E����
				|| "1115".equals(serviceCodeItem)	//�\�h�K����P�E���C�E����
				|| "1211".equals(serviceCodeItem)	//�\�h�K����Q
				|| "1213".equals(serviceCodeItem)	//�\�h�K����Q�E���C
				|| "1214".equals(serviceCodeItem)	//�\�h�K����Q�E����
				|| "1215".equals(serviceCodeItem)	//�\�h�K����Q�E���C�E����
				|| "1321".equals(serviceCodeItem)	//�\�h�K����R
				|| "1323".equals(serviceCodeItem)	//�\�h�K����R�E���C
				|| "1324".equals(serviceCodeItem)	//�\�h�K����R�E����
				|| "1325".equals(serviceCodeItem)	//�\�h�K����R�E���C�E����
        		) {
        		return true;
        	}
        }
        // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - end
        
        return false;
    }

    /**
     * �v��P�ʐ��T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �v��P�ʐ��T�[�r�X�ł��邩
     */
    public static boolean isPlanUnitService(int systemServiceKindDetail) {
        switch (systemServiceKindDetail) {
        case 1:// �v��P�ʐ��T�[�r�X
            return true;
        }
        return false;
    }

    /**
     * �v��P�ʐ��T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �v��P�ʐ��T�[�r�X�ł��邩
     */
    public static boolean isPlanUnitService(Map service) {
        return isPlanUnitService(toInt(service));
    }

    /**
     * �v��P�ʐ��T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �v��P�ʐ��T�[�r�X�ł��邩
     */
    public static boolean isPlanUnitService(String systemServiceKindDetail) {
        return isPlanUnitService(toInt(systemServiceKindDetail));
    }

    /**
     * �v��P�ʐ��̃o�C���h�p�X�z���Ԃ��܂��B
     * [H27.4�����Ή�][Shinobu Hitaka] 2015/03/06 68,69,79�̃T�[�r�X��ޒǉ�
     * [H28.4�����Ή�][Shinobu Hitaka] 2016/01/29 78�̃T�[�r�X��ޒǉ�
     * @return �v��P�ʐ��̃o�C���h�p�X�z��
     */
    public static String[] getPlanUnitBindPathes() {
        return new String[] { 
        		"1011", "1012", "1013", "1014", "1015",
        		"1016", "1017", "1021", "1022", "1023",
        		"1071", "1027", "1072", "1073", "1068",
        		"1038", "1028", "1076", "1077", "1079",
        		"1078",
                "1061", "1062", "1063", "1064", "1065",
                "1066", "1067", "1024", "1025", "1026",
                "1039", "1074", "1075", "1069", };
    };

    /**
     * ���p�[�Ɉ󎚂���T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ���p�[�Ɉ󎚂���T�[�r�X�ł��邩
     */
    public static boolean isServiceUseTablePrintable(int systemServiceKindDetail) {
        // �{�݌n/���{�݌n�T�[�r�X/����×{�Ǘ��w���͕ʕ\�Ɉ󎚂��Ȃ��B
        if (CareServiceCommon.isFacility(systemServiceKindDetail)
                || CareServiceCommon.isLifeCare(systemServiceKindDetail)
                || CareServiceCommon
                        .isHomeMedicalAdvice(systemServiceKindDetail)) {
            return false;
        }
        return true;
    }

    /**
     * ���p�[�Ɉ󎚂���T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return ���p�[�Ɉ󎚂���T�[�r�X�ł��邩
     */
    public static boolean isServiceUseTablePrintable(Map service) {
        return isServiceUseTablePrintable(toInt(service));
    }

    /**
     * ���p�[�Ɉ󎚂���T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ���p�[�Ɉ󎚂���T�[�r�X�ł��邩
     */
    public static boolean isServiceUseTablePrintable(
            String systemServiceKindDetail) {
        return isServiceUseTablePrintable(toInt(systemServiceKindDetail));
    }

    /**
     * ���p�[�{�\�Ɉ󎚂���T�[�r�X�R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return ���p�[�Ɉ󎚂���T�[�r�X�ł��邩
     */
    public static boolean isServiceUseTableMainFormatPrintableCode(Map code) {
        if (isOutLimitAmount(code) || isAddEmergencyNursing(code)
                || isAddSpecialManagement(code) || isAddSpecialArea(code)
                || isAddTerminalCare(code)
                || isAddEmergencyMedicalManagement(code)
                || isAddPercentageForSyogu(code)) {
            // �ً}���K��Ō���Z�A���ʊǗ����Z�A���ʒn����Z�A�^�[�~�i���P�A���Z�A�ً}�����ÊǗ��A���E���������P���Z�͖{�\�Ɉ󎚂��Ȃ�
            return false;
        }

        return true;
    }

    /**
     * �×{�a���L����f�Ï��ɂ�����T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param systemServiceKindDetail �T�[�r�X���
     * @return �×{�a���L����f�Ï��ɂ�����T�[�r�X�ł��邩
     * 
     */
    public static boolean isPracticeToHealthFacilityServices(Map service) {
        // �×{�a���L����f�Ï��ɂ�����T�[�r�X�ł��邩�B
        switch (toInt(service)) {
        case 12312: // �Z�������×{���i�f�Ï��j
        case 15312: // ���×{�^��Î{�݁i�f�Ï��j
        case 12612: // ���\�h�Z�������×{���i�f�Ï��j
            return true;
        }

        return false;
    }

    /**
     * �×{�a����L����V���{�݂ɂ�����T�[�r�X�ł��邩��Ԃ��܂��B
     * 
     * @param service �T�[�r�X���
     * @return
     * 
     */
    public static boolean isElderlyToHealthFacilityServices(Map service) {
        // �V�l�ی��{�݂�L����Z�������×{���
        switch (toInt(service)) {
        // �Z�������×{���(�V���j
        case 12211:
            // ���V�l�ی��{��
        case 15211:
            // ���\�h�Z�������×{���i�V���j
        case 12511:
            return true;
        }

        return false;

    }

    /**
     * ���R�ԓ��n��ɂ����鏬�K�͎��Ə����Z�ł��邩��Ԃ��܂��B
     * 
     * @param provider ���Ə����
     * @return
     * 
     */
    public static boolean isMountainousArea(Map provider) {
        // ���R�ԓ��n��ɂ����鏬�K�͎��Ə����Z�i�n��j�E�i�K�́j���Y���̏ꍇ
        if (provider != null) {
            if ((ACCastUtilities.toInt(provider.get("2"), 0) == 2)
                    && (ACCastUtilities.toInt(provider.get("3"), 0) == 2)) {
                return true;
            }
        }

        return false;
    }

    /**
     * �T�[�r�X�̖@�����敪(M_DETAIL.SYSTEM_BIND_PATH=14)��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �T�[�r�X�̖@�����敪
     */
    public static int getServiceLowVersion(VRMap service) {
        try {
            return ACCastUtilities.toInt(VRBindPathParser
                    .get(QkanConstants.SERVICE_SYSTEM_BIND_PATH_LOW_VERSION,
                            service), 0);
        } catch (ParseException e) {
            return 0;
        }
    }

    /**
     * ���E���������P�̎��Ə��ݒ�l��ԋp���܂��B
     * 
     * @param provider
     * @return // [ID:0000682] 2012/01 start ���E���������P���Z�̒ǉ�����
     */
    public static int getProviderSyogukaizenValue(Map provider) {
        // ���E���������P���Z
        if (provider != null) {
            return ACCastUtilities.toInt(provider.get("4"), 1);

        }

        return 1;
    }

    /**
     * �������P���Z�̒P�ʐ����v�Z���A�ԋp���܂��B
     * 
     * @param totalUnit �������P���Z�Ώۂ̒P�ʐ����v
     * @param serviceUnit ���Z����(��)
     * @param serviceStaffUnit ���Z����(��)
     * @return
     */
    public static int calcSyogu(int totalUnit, int serviceUnit,
            int serviceStaffUnit) {

        // totalUnit * (serviceUnit / 1000) * (serviceStaffUnit / 100)

        // �P�ʐ��͎l�̌ܓ�
        int unit = (int) Math.round((double) (totalUnit * serviceUnit) / 1000d);
        unit = (int) Math.round((double) (unit * serviceStaffUnit) / 100d);

        return unit;
    }

    /**
     * �������P���Z�̒P�ʐ����v�Z���A�ԋp���܂��B
     * 
     * @param totalUnit �������P���Z�Ώۂ̒P�ʐ����v�i���ȕ��S�������܂܂Ȃ��j
     * @param totalRegulation ���ȕ��S���P�ʐ�
     * @param serviceUnit ���Z����(��)
     * @param serviceStaffUnit ���Z����(��)
     * @return
     * [ID:0000728][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add
     */
    public static int calcSyoguPatientSelf(int totalUnit, int totalRegulation,
            int serviceUnit, int serviceStaffUnit) {
        // ���ȕ��S������P�ʐ����Z�o
        int adjustUnit = totalUnit - totalRegulation;

        // �S�̒P�ʐ� - ������P�ʐ�
        int totalAdjust = CareServiceCommon.calcSyogu(adjustUnit, serviceUnit,
                serviceStaffUnit);
        int totalSyogu = CareServiceCommon.calcSyogu(totalUnit, serviceUnit,
                serviceStaffUnit);

        return totalSyogu - totalAdjust;
    }

    /**
     * ���V�l�ی��{�݂ŉ��L����ǂ������肷��
     * 8801:�����a�����΍�A8802:���`������A8701:�L�@�q�f�A6601:�Ζ�
     * @param String serviceCodeKind�F�T�[�r�X��ރR�[�h(SERVICE_CODE_KIND)
     * @param String kohi�F����^�C�v
     * @return �Y������Ftrue�^�Y�����Ȃ��Ffalse
     * [CCCX:1470][Shinobu Hitaka] 2014/02/07 add �V���̈ꕔ����Ώۂ̑Ή�
     */
    public static boolean isKouhiService(String serviceCodeKind, String kohi) {
        boolean bFlg = false;
        
        //���V�l�ی��{��
        if (serviceCodeKind.indexOf("52") != -1) {
            //���8801:�����a�����΍�A8802:���`������A8701:�L�@�q�f�A6601:�Ζȁ@�̏ꍇ
            if ("8801".equals(kohi) || "8802".equals(kohi) || "8701".equals(kohi) || "6601".equals(kohi)) {
                //�ꕔ����K�p�̂��߁A���̌���v�Z���K�v
                bFlg = true;
            }
        }
        return  bFlg;
    }
    
    /**
     * ���V�l�ی��{�݂ŉ��L����ǂ������肷��
     * 8801:�����a�����΍�A8802:���`������A8701:�L�@�q�f�A6601:�Ζ�
     * @param String systemServiceKindDetail�F�V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)
     * @param String kohi�F����^�C�v
     * @return �Y������Ftrue�^�Y�����Ȃ��Ffalse
     * [CCCX:1470][Shinobu Hitaka] 2014/02/10 add �V���̈ꕔ����Ώۂ̑Ή�
     */
    public static boolean isKouhiSystemService(String systemServiceKindDetail, String kohi) {
        boolean bFlg = false;
        
        //���V�l�ی��{��
        if (systemServiceKindDetail.indexOf("15211") != -1) {
            //���8801:�����a�����΍�A8802:���`������A8701:�L�@�q�f�A6601:�Ζȁ@�̏ꍇ
            if ("8801".equals(kohi) || "8802".equals(kohi) || "8701".equals(kohi) || "6601".equals(kohi)) {
                //�ꕔ����K�p�̂��߁A���̌���v�Z���K�v
                bFlg = true;
            }
        }
        return  bFlg;
    }
}
