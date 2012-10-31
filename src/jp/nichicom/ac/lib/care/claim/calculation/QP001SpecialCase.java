
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
 * �v���O���� ���������Ꮘ���N���X (QP001SpecialCase)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

public class QP001SpecialCase {
    
    //���ی��x�z
    private static final int SEIHO_SELF_PAY = 15000;
    
    //���׏�񃌃R�[�h�V���A���ԍ�
    private static int DETAIL_SERIAL = 0;
    
    /**
     * �w�肳�ꂽ���ʔԍ����{�݌n�̐����ł��邩���ʂ���B
     * @param discriminationNo �l�����ʔԍ�
     * @return true:�{�݌n�ł���(�l���攪�A���A��\) false:�{�݌n�ł͂Ȃ�
     * @throws Exception
     */
    public static boolean isShisetsuDiscriminationNo(String discriminationNo) throws Exception {
        //�ȉ��̂����ꂩ�̌������ʔԍ����܂܂�Ă���΁A�{�݌n�̐����Ƃ݂Ȃ��B
        if (QP001StyleAbstract.IDENTIFICATION_NO_8_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        
        return false;
    }
    
    /**
     * �w�肳�ꂽ���ʔԍ��̒��[�ɋ���T�[�r�X�v��쐬�敪���K�v�ł��邩�B
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isServicePlanMakerLiving(String discriminationNo) throws Exception {
        //7171,7173,7183,7193,71A3(�l����Z�A�Z�̎O�A���A��A�\�̏ꍇ)�́A
        //����T�[�r�X�v��쐬�敪�͕K�v�Ȃ��B
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_201204.equals(discriminationNo)) {
            return false;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(discriminationNo)) {
            return false;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_8_201204.equals(discriminationNo)) {
            return false;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return false;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        
        return true;
    	
    }
    
    
    /**
     * �w�肳�ꂽ���ʔԍ��͓���(�@)�O�̏�ԃR�[�h�̑O������p�����s����
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isAdmissionStatusCodeTakeover(String discriminationNo) throws Exception {
        //�l������Z�`�Z�̎l�A���A��A�\�Ɍ���
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_8_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        
        return false;
    }
    
    
    /**
     * �w�肳�ꂽ���ʔԍ��́A����f�Ô���܂ނ�
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isIncludingDiagnosis(String discriminationNo) throws Exception {
        //�l������l�A�l�̓�A�܁A�܂̓�A��A�\�̏ꍇ
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        return false;
    }
    
    /**
     * �w�肳�ꂽ���ʔԍ��́A�V���[�g�X�e�C�ł��邩
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isShortStay(String discriminationNo) throws Exception {
        //���l����O�A��l�A��܁A��Z�̌܁A�Z�̘Z�A�Z�̎��̏ꍇ
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_7_201204.equals(discriminationNo)) {
            return true;
        }
        
        return false;
    }
    
    /**
     * �w�肳�ꂽ���ʔԍ��́A�{�݂ł��邩
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isLongStay(String discriminationNo) throws Exception {
        //���l����Z�Ƒ�Z�̎O�A�l��������\�̏ꍇ
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_8_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        
        return false;
    }
    
    
    /**
     * �l����񂩂�l����\�̎��ʔԍ���Ԃ�
     * @return
     */
    public static String getPerformanceCodes() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_3_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_4_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_5_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_5_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_6_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_7_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_7_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_7_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_8_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_9_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_10_201204);
        
        return sb.toString();
    }
    
    /**
     * �l����\��̎��ʔԍ���Ԃ�
     * @return
     */
    public static String getBenefitManagementCodes() {
        return "8222,8221";
    }
    
    /**
     * �w�肳�ꂽ���ʔԍ��́A�T�[�r�X���������o�͂��邩
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isOutRealDay(String discriminationNo) throws Exception {
        //�l�����A���̓�A��O�A��O�̓�A��l�A��l�̓�A��܁A��܂̓�A��Z�̌܁A��Z�̘Z
        //return ("7131,7132,7143,7144,7153,7154,7164,7165,7175,7176,7155,7156".indexOf(discriminationNo) != -1);
        if (QP001StyleAbstract.IDENTIFICATION_NO_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_7_201204.equals(discriminationNo)) {
            return true;
        }
        return false;
    }
    
    
    /**
     * �w�肳�ꂽ���ʔԍ��́A���x�z�Ǘ��ΏۊO�P�ʐ����o�͂��邩
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isOutLimitUncontrolledUnit(String discriminationNo) throws Exception {
        //�l�����A��̓�A�O�A�O�̓�A�l�A�l�̓�A�܁A�܂̓�
        //return ("7131,7132,7143,7144,7153,7154,7164,7165,7155,7156".indexOf(discriminationNo) != -1);
        if (QP001StyleAbstract.IDENTIFICATION_NO_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204.equals(discriminationNo)) {
            return true;
        }
        
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_7_201204.equals(discriminationNo)) {
            return true;
        }
        return false;
    }
    
    
    /**
     * �����Ɏw�肳�ꂽ��ی��Ҕԍ����琶�ےP�Ǝ󋋎҂ł��邩���f����B
     * @param insurerdNo ��ی��Ҕԍ�
     * @return true:���ےP�� false:���ےP�Ƃł͂Ȃ�
     * @throws Exception
     */
    public static boolean isSeihoOnly(String insurerdNo) throws Exception {
        if(insurerdNo == null){
            return false;
        }
        //��ی��Ҕԍ���H����n�܂��Ă���ΐ��ےP�ƂƂ݂Ȃ��B
        return insurerdNo.toUpperCase().startsWith("H");
        
    }
    
    /**
     * �T�[�r�X�̎�ނ𔻒f����B
     * @param serviceCode�@�T�[�r�X�R�[�h
     * @return
     * 1:�H��<br>
     * 2:���j�b�g�^��<br>
     * 3:���j�b�g�^����<br>
     * 4:�]���^��(���{��)<br>
     * 5:�]���^��(�V���E�×{��)<br>
     * 6:������
     * @throws Exception
     */
    public static int getServiceKind(VRMap serviceCode) throws Exception {
        int result = 0;
        
        if(serviceCode == null){
            return result;
        }
        
        //�a���敪
        
        //���Z��ʂŕ���
        switch(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_TYPE"), 0)) {
        //�H��
        case 2:
            result = 1;
            break;
            
        //���Z��
        case 3:
            //���Z��̏ꍇ�́A�a���敪���擾
            switch(ACCastUtilities.toInt(serviceCode.get("ROOM_TYPE"), 0)) {
            case 1: // 1-�]���^���i���{���j
                result = 4;
                break;
            case 2: // 2-�]���^���i�V���E�×{���j
                result = 5;
                break;
            case 3: // 3-������
                result = 6;
                break;
            case 4: // 4-���j�b�g�^��
                result = 2;
                break;
            case 5: // 5-���j�b�g�^����
                result = 3;
                break;
            }
            
            break;
        
        }
        
        return result;
    }
    
    /**
     * �T�[�r�X�̎�ނ𔻒f����B
     * @param serviceCodeItem 
     * @return
     * 1:�H��<br>
     * 2:���j�b�g�^��<br>
     * 3:���j�b�g�^����<br>
     * 4:�]���^��(���{��)<br>
     * 5:�]���^��(�V���E�×{��)<br>
     * 6:������
     * @throws Exception
     */
    /*
    public static int getServiceKind(int serviceCodeItem) throws Exception {
        int result = 0;
        //�T�[�r�X�R�[�h��ނőΏۃT�[�r�X�𔻒肷��B
        switch(serviceCodeItem){
            //�H��
            case 2111:
            case 2211:
            case 2311:
            case 5111:
            case 5211:
            case 5311:
            case 5411:
            //�\�h�Ή��J�n
            case 2411:
            case 2511:
            case 2611:
            //�\�h�Ή��I��
                result = 1;
                break;
                
            //���j�b�g�^��
            case 2121:
            case 2221:
            case 2321:
            case 5121:
            case 5221:
            case 5321:
            case 5421:
            //�\�h�Ή��J�n
            case 2421:
            case 2521:
            case 2621:
            //�\�h�Ή��I��
                result = 2;
                break;
                
            //���j�b�g�^����
            case 2122:
            case 2222:
            case 2322:
            case 5122:
            case 5222:
            case 5322:
            case 5422:
            //�\�h�Ή��J�n
            case 2422:
            case 2522:
            case 2622:
            //�\�h�Ή��I��
                result = 3;
                break;
                
            //�]���^��(���{��)
            case 2123:
            case 5123:
            //[ID:0000645][Shin Fujihara] 2011/04/20 add begin 2010�N�x�Ή�
            //�n�斧���^��앟���{��-�]���^����
            //�]���^��(�V���E�×{��)����]���^��(���{��)�ֈړ�
            case 5423:
            //[ID:0000645][Shin Fujihara] 2011/04/20 add end 2010�N�x�Ή�
            //�\�h�Ή��J�n
            case 2423:
            //�\�h�Ή��I��
                result = 4;
                break;
                
            //�]���^��(�V���E�×{��)
            case 2223:
            case 2323:
            case 5223:
            case 5323:
            //[ID:0000645][Shin Fujihara] 2011/04/20 edit begin 2010�N�x�Ή�
            //�n�斧���^��앟���{��-�]���^���͏]���^��(���{��)��������
            //case 5423:
            //[ID:0000645][Shin Fujihara] 2011/04/20 edit end 2010�N�x�Ή�
            //�\�h�Ή��J�n
            case 2523:
            case 2623:
            //�\�h�Ή��I��
                result = 5;
                break;
            //������
            case 2124:
            case 2224:
            case 2324:
            case 5124:
            case 5224:
            case 5324:
            case 5424:
            //�\�h�Ή��J�n
            case 2424:
            case 2524:
            case 2624:
            //�\�h�Ή��I��
                result = 6;
                break;
        }
        
        return result;
    }
    */
    
    /**
     * ����ȕ��S�z�Ŏ��ۂɎg�p�\�ȋ��z���擾����B<BR>
     * <br>
     * �{�݌n�T�[�r�X�̏ꍇ�A��ی��҂ł����ی�҂ɂ������쌔�ɂ��{�l�x���z�́A<br>
     * 15,000�܂ł�{�̕�V�ɂ��������{�l���S�z�ɏ[�����A�c�z������ꍇ�ɂ͂��̊z����������<br>
     * ���T�[�r�X��ɂ��������{�l���S�z�ɏ[������B<br>
     * �Ȃ��A�����ی�P�Ǝ󋋎҂ɂ����ẮA���ی��{�݂̓�������҉��T�[�r�X��́A<br>
     * �S�z����S�ƂȂ�B<br>
     * �i�������A���Z��ɂ������������҉��T�[�r�X��́A�����敪���������̂ݑΏۂƂȂ�j
     * 
     * @param discriminationNo ���ʔԍ�
     * @param insurerdNo ��ی��Ҕԍ�
     * @param selfPay ����ȕ��S�z
     * @return �g�p�\�Ȏ��ȕ��S�z
     * @throws Exception
     */
    public static int convertSelfPay(String discriminationNo,String insurerdNo,int selfPay,String kohi,int kohiCost) throws Exception {
        //�l���攪�A���A��\�łȂ���Ό���ȕ��S�z��ԋp����B
        if(!isShisetsuDiscriminationNo(discriminationNo)){
            return selfPay;
        }
        //���ےP�Ƃł���Ό���ȕ��S�z��ԋp����B
        if(isSeihoOnly(insurerdNo)){
            return selfPay;
        }
        //add start 2006.9.12 fujihara shin
        /* 
         * > Sent: Monday, September 11, 2006 2:07 PM
         * > Subject: Re: �y���ǒ��z����{�l���S�ɏ����݂���@�߂ɂ���
         * 
         * > �@���ےP�Ƃ̏ꍇ(��ی��Ҕԍ���H����n�܂�ꍇ)
         * > �@�������݂��Ȃ�
         * 
         * ��肠��܂���B
         * 
         * > �A�{�݌n�T�[�r�X�ȊO�̏ꍇ
         * > �@�������݂��Ȃ�
         * 
         * ��肠��܂���B
         * 
         * > �B����Ƃ��Đ��ۂ��܂܂�Ȃ��ꍇ
         * > �@�������݂��Ȃ�
         * 
         * ��{�I�ɂ͐��ێ󋋎҂̂ݓK�p�ɂȂ�悤�ł��B
         * �������A���̎󋋎҂œ��l�̎戵�����Ă��A���ɕԖ߂ɂ͂Ȃ�Ȃ��悤�ł��B
         * �Ƃ肠�����A�u���ہv�̂�15000�~�̏����݂���`�����ǒ��ł�
         * �̗p���A�ҏW�������ꍇ�́u���׏����ҏW��ʁv�ŏC�������Ă��炤
         * �Ƃ������@�ɂ��܂��傤�B
         * 
         * > �C��L3���ɊY����������������҉��T�[�r�X�������ꍇ
         * > �@�����15,000�~��݂���
         * 
         * ����͋�̓I�ɂ͂ǂ��������Ƃł��傤���B
         * 
         * �ʌ��ɂȂ邩�Ǝv���܂����A���ێ󋋎҂œ�������҉��T�[�r�X�
         * ������Ȃ��ꍇ�ɂ��Ă͏����݂��Ȃ��Ƃ������ł��肢���܂��B 
         */
        if((kohi != null) && (kohi.startsWith("12"))){
        	//����p�󋋎�
        	//��������҉��T�[�r�X�������ꍇ
        	if(kohiCost > 0){
                //�ⓚ���p��15000��ԋp����B
                if(selfPay > SEIHO_SELF_PAY){
                    return SEIHO_SELF_PAY;
                }
        	}
        }
        //add end 2006.9.12 fujihara shin
        
//        //�ⓚ���p��15000��ԋp����B
//        if(selfPay < SEIHO_SELF_PAY){
//            return selfPay;
//        }
//        return SEIHO_SELF_PAY;
        return selfPay;
    }
    
    /**
     * �P�ʐ����v�サ�Ȃ��T�[�r�X�ł��邩�m�F����B
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isUnitNoCountService(String serviceCodeKind, String serviceCodeItem) throws Exception {
        int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        int item = ACCastUtilities.toInt(serviceCodeItem,0);
        return isUnitNoCountService(kind,item);
    }
    
    /**
     * �P�ʐ����v�サ�Ȃ��T�[�r�X�ł��邩�m�F����B
     * @param serviceCodeKind �T�[�r�X�R�[�h���
     * @param serviceCodeItem �T�[�r�X�R�[�h����
     * @return true : �P�ʐ����L�ڂ��Ȃ� false : �P�ʐ����L�ڂ���
     * @throws Exception
     */
    public static boolean isUnitNoCountService(int kind, int item) throws Exception {
        
        //[ID:0000714] ����24�N4���@�����ɔ����A�S�C��
        
        boolean result = false;
        
        switch(kind){
        case 13: //�K��Ō�
            switch(item){
            case 3111: //�������K��
            case 3113: //�������K�ŁE�y�P
            case 3115: //�������K�ŁE��T
            case 3117: //�������K�ŁE�y�P�E��T
            case 6102: //�K��Ō�T�[�r�X�񋟑̐����Z�Q
            case 8001: //���ʒn��K��Ō���Z�Q
            case 8101: //�K��Ō쏬�K�͎��Ə����Z�Q
            case 8111: //�K��Ō쒆�R�Ԓn�擙�񋟉��Z�Q
                result = true;
                break;
            }
            break;
            
        case 17: //�����p��ݗ^
            //�����p��n��͈ꗥ�P�ʐ����o�͂��Ȃ��B
            result = true;
            break;
            
        case 33: //����{�ݓ����Ґ������
            switch(item){
            case 2001: //�O���Ԃ����ݗ^
            case 2002: //�O���Ԃ����t���i�ݗ^
            case 2003: //�O������Q��ݗ^
            case 2004: //�O������Q��t���i�ݗ^
            case 2005: //�O��������h�~�p��ݗ^
            case 2006: //�O���̈ʕϊ���ݗ^
            case 2007: //�O���肷��ݗ^
            case 2008: //�O���X���[�v�ݗ^
            case 2009: //�O�����s��ݗ^
            case 2010: //�O�����s�⏕���ݗ^
            case 2011: //�O���p�j���m�@��ݗ^
            case 2012: //�O���ړ��p���t�g�ݗ^
            case 2013: //�O�������r���������u�ݗ^
                result = true;
                break;
            }
            break;
            
        case 35: //���\�h����{�ݓ����Ґ������
            switch(item){
            case 1311: //�\�h�O���K����T
            case 1321: //�\�h�O���K����U
            case 1332: //�\�h�O���K����V
            case 1711: //�\�h�O���ʏ����P
            case 1712: //�\�h�O���ʏ����Q
            case 1722: //�\�h�O���ʏ����^������Z
            case 1723: //�\�h�O���ʏ����h�{���P���Z
            case 1724: //�\�h�O���ʏ������o�@�\���Z
            case 1725: //�\�h�O���ʉ���T�[�r�X���Z�T�P
            case 1726: //�\�h�O���ʉ���T�[�r�X���Z�T�Q
            case 1727: //�\�h�O���ʉ���T�[�r�X���Z�T�R
            case 1728: //�\�h�O���ʉ���T�[�r�X���Z�U
            case 1811: //�\�h�O���ʏ����n�P�P
            case 1812: //�\�h�O���ʏ����n�P�Q
            case 1821: //�\�h�O���ʏ����n�^������Z
            case 1822: //�\�h�O���ʏ����n�h�{���P���Z
            case 1823: //�\�h�O���ʏ����n���o�@�\���Z
            case 1824: //�\�h�O���ʃ������T�[�r�X���Z�T�P
            case 1825: //�\�h�O���ʃ������T�[�r�X���Z�T�Q
            case 1826: //�\�h�O���ʃ������T�[�r�X���Z�T�R
            case 1827: //�\�h�O���ʃ������T�[�r�X���Z�U
            case 1831: //�\�h�O���ʏ����n�Q�P
            case 1832: //�\�h�O���ʏ����n�Q�Q
            case 1901: //�\�h�O���Ԃ����ݗ^
            case 1902: //�\�h�O���Ԃ����t���i�ݗ^
            case 1903: //�\�h�O������Q��ݗ^
            case 1904: //�\�h�O������Q��t���i�ݗ^
            case 1905: //�\�h�O��������h�~�p��ݗ^
            case 1906: //�\�h�O���̈ʕϊ���ݗ^
            case 1907: //�\�h�O���肷��ݗ^
            case 1908: //�\�h�O���X���[�v�ݗ^
            case 1909: //�\�h�O�����s��ݗ^
            case 1910: //�\�h�O�����s�⏕���ݗ^
            case 1911: //�\�h�O���p�j���m�@��ݗ^
            case 1912: //�\�h�O���ړ��p���t�g�ݗ^
            case 1913: //�\�h�O�������r���������u�ݗ^
                result = true;
                break;
            }
            break;
            
        case 46: //���\�h�x��
            result = true;
            break;
            
        case 61: //���\�h�K��Ō�
            switch(item){
            case 1111: //�\�h�K����T
            case 1113: //�\�h�K����T�E�Q��
            case 1114: //�\�h�K����T�E����
            case 1115: //�\�h�K����T�E�Q���E����
            case 1211: //�\�h�K����U
            case 1213: //�\�h�K����U�E�Q��
            case 1214: //�\�h�K����U�E����
            case 1215: //�\�h�K����U�E�Q���E����
            case 1321: //�\�h�K����V
            case 1323: //�\�h�K����V�E�Q��
            case 1324: //�\�h�K����V�E����
            case 1325: //�\�h�K����V�E�Q���E����
            case 4001: //�\�h�K���쏉����Z
            case 4002: //�\�h�K���쐶���@�\������Z
            case 8000: //�\�h���ʒn��K������Z
            case 8100: //�\�h�K���쏬�K�͎��Ə����Z
            case 8110: //�\�h�K���쒆�R�Ԓn�擙�񋟉��Z
                result = true;
                break;
            }
            break;
            
        case 65: //���\�h�ʏ����
            switch(item){
            case 1111: //�\�h�ʏ����P
            case 1121: //�\�h�ʏ����Q
            case 5002: //�\�h�ʏ����^����@�\������Z
            case 5003: //�\�h�ʏ����h�{���P���Z
            case 5004: //�\�h�ʏ������o�@�\������Z
            case 5005: //�\�h�ʏ���쎖�Ə��]�����Z
            case 5006: //�\�h�ʉ���T�[�r�X���{���Z�T�P
            case 5007: //�\�h�ʉ���T�[�r�X���{���Z�T�Q
            case 5008: //�\�h�ʉ���T�[�r�X���{���Z�T�R
            case 5009: //�\�h�ʉ���T�[�r�X���{���Z�U
            case 5010: //�\�h�ʉ������O���[�v�������Z
            case 6101: //�\�h�ʏ��T�[�r�X�񋟑̐����Z�T�P
            case 6102: //�\�h�ʏ��T�[�r�X�񋟑̐����Z�T�Q
            case 6103: //�\�h�ʏ��T�[�r�X�񋟑̐����Z�U�P
            case 6104: //�\�h�ʏ��T�[�r�X�񋟑̐����Z�U�Q
            case 6105: //�\�h�ʏ���쑗�}���Z�P
            case 6106: //�\�h�ʏ���쑗�}���Z�Q
            case 6109: //�\�h�ʏ�����N���F�m�ǎ�����Z
            case 8001: //�\�h�ʏ����P�E�蒴
            case 8011: //�\�h�ʏ����Q�E�蒴
            case 8110: //�\�h�ʏ���쒆�R�Ԓn�擙�񋟉��Z
            case 9001: //�\�h�ʏ����P�E�l��
            case 9011: //�\�h�ʏ����Q�E�l��
                result = true;
                break;
            }
            break;
            
        case 66: //���\�h�ʏ����n�r���e�[�V����
            switch(item){
            case 1111: //�\�h�ʏ����n�r���P�P
            case 1121: //�\�h�ʏ����n�r���P�Q
            case 2111: //�\�h�ʏ����n�r���Q�P
            case 2121: //�\�h�ʏ����n�r���Q�Q
            case 5002: //�\�h�ʏ����n�^����@�\������Z
            case 5003: //�\�h�ʏ����n�h�{���P���Z
            case 5004: //�\�h�ʏ����n���o�@�\������Z
            case 5005: //�\�h�ʏ����n���Ə��]�����Z
            case 5006: //�\�ʃ��n�����T�[�r�X���{���Z�T�P
            case 5007: //�\�ʃ��n�����T�[�r�X���{���Z�T�Q
            case 5008: //�\�ʃ��n�����T�[�r�X���{���Z�T�R
            case 5009: //�\�ʃ��n�����T�[�r�X���{���Z�U
            case 6101: //�\�ʃ��n�T�[�r�X�񋟑̐����Z�T�P
            case 6102: //�\�ʃ��n�T�[�r�X�񋟑̐����Z�T�Q
            case 6103: //�\�ʃ��n�T�[�r�X�񋟑̐����Z�U�P
            case 6104: //�\�ʃ��n�T�[�r�X�񋟑̐����Z�U�Q
            case 6105: //�\�h�ʏ����n���}���Z�P�P
            case 6106: //�\�h�ʏ����n���}���Z�P�Q
            case 6107: //�\�h�ʏ����n���}���Z�Q�P
            case 6108: //�\�h�ʏ����n���}���Z�Q�Q
            case 6109: //�\�h�ʏ����n��N���F�m�ǎ�����Z
            case 8001: //�\�h�ʏ����n�r���P�P�E�蒴
            case 8011: //�\�h�ʏ����n�r���P�Q�E�蒴
            case 8110: //�\�h�ʏ����n���R�Ԓn�擙�񋟉��Z
            case 8201: //�\�h�ʏ����n�r���Q�P�E�蒴
            case 8211: //�\�h�ʏ����n�r���Q�Q�E�蒴
            case 9001: //�\�h�ʏ����n�r���P�P�E�l��
            case 9011: //�\�h�ʏ����n�r���P�Q�E�l��
            case 9201: //�\�h�ʏ����n�r���Q�P�E�l��
            case 9211: //�\�h�ʏ����n�r���Q�Q�E�l��
                result = true;
                break;
            }
            break;
            
        case 67: //���\�h�����p��ݗ^
            result = true;
            break;
            
        case 71: //��ԑΉ��^�K����T�[�r�X
            switch(item){
            case 1111: //��ԖK����T��{
            case 2111: //��ԖK����U
            case 2113: //��ԖK����U�E����
            case 6102: //��ԖK��T�[�r�X�񋟑̐����Z�U
            case 6136: //��ԖK����Q�S���Ԓʕ�Ή����Z
            case 7201: //��{��ԖK��T�s�����Ǝ����Z�P
            case 7203: //��{��ԖK��T�s�����Ǝ����Z�Q
            case 7205: //��{��ԖK��T�s�����Ǝ����Z�R
            case 7207: //��{��ԖK��T�s�����Ǝ����Z�S
            case 7209: //��{��ԖK��T�s�����Ǝ����Z�T
            case 7211: //��{��ԖK��T�s�����Ǝ����Z�U
            case 7301: //��ԖK����U�s�����Ǝ����Z�P
            case 7303: //��ԖK����U�s�����Ǝ����Z�Q
            case 7305: //��ԖK����U�s�����Ǝ����Z�R
            case 7307: //��ԖK����U�s�����Ǝ����Z�S
            case 7309: //��ԖK����U�s�����Ǝ����Z�T
            case 7311: //��ԖK����U�s�����Ǝ����Z�U
                result = true;
                break;
            }
            break;
            
        case 73: //���K�͑��@�\�^������
            switch(item){
            case 1111: //���K�͑��@�\�P
            case 1113: //���K�͑��@�\�P�E�ߏ�
            case 1115: //���K�͑��@�\�P�E����
            case 1117: //���K�͑��@�\�P�E����E�ߏ�
            case 1121: //���K�͑��@�\�Q
            case 1123: //���K�͑��@�\�Q�E�ߏ�
            case 1125: //���K�͑��@�\�Q�E����
            case 1127: //���K�͑��@�\�Q�E����E�ߏ�
            case 1131: //���K�͑��@�\�R
            case 1133: //���K�͑��@�\�R�E�ߏ�
            case 1135: //���K�͑��@�\�R�E����
            case 1137: //���K�͑��@�\�R�E����E�ߏ�
            case 1141: //���K�͑��@�\�S
            case 1143: //���K�͑��@�\�S�E�ߏ�
            case 1145: //���K�͑��@�\�S�E����
            case 1147: //���K�͑��@�\�S�E����E�ߏ�
            case 1151: //���K�͑��@�\�T
            case 1153: //���K�͑��@�\�T�E�ߏ�
            case 1155: //���K�͑��@�\�T�E����
            case 1157: //���K�͑��@�\�T�E����E�ߏ�
            case 6101: //�����@�\�^�T�[�r�X�񋟑̐����Z�T
            case 6102: //�����@�\�^�T�[�r�X�񋟑̐����Z�U
            case 6103: //�����@�\�^�T�[�r�X�񋟑̐����Z�V
            case 6128: //���K�͑��@�\�^�F�m�ǉ��Z�T
            case 6129: //���K�͑��@�\�^�F�m�ǉ��Z�U
            case 6137: //���K�͑��@�\�^�Ō�E���z�u���Z�T
            case 6138: //���K�͑��@�\�^�Ō�E���z�u���Z�U
            case 6139: //���K�͑��@�\�^���ƊJ�n�x�����Z
            case 7101: //���K�͑��@�\�^�s�����Ǝ����Z�P
            case 7103: //���K�͑��@�\�^�s�����Ǝ����Z�Q
            case 7105: //���K�͑��@�\�^�s�����Ǝ����Z�R
            case 7107: //���K�͑��@�\�^�s�����Ǝ����Z�S
            case 7109: //���K�͑��@�\�^�s�����Ǝ����Z�T
            case 7111: //���K�͑��@�\�^�s�����Ǝ����Z�U
            case 7113: //���K�͑��@�\�^�s�����Ǝ����Z�V
            case 7115: //���K�͑��@�\�^�s�����Ǝ����Z�W
            case 7117: //���K�͑��@�\�^�s�����Ǝ����Z�X
            case 7119: //���K�͑��@�\�^�s�����Ǝ����Z�P�O
            case 7121: //���K�͑��@�\�^�s�����Ǝ����Z�P�P
            case 7123: //���K�͑��@�\�^�s�����Ǝ����Z�P�Q
            case 7125: //���K�͑��@�\�^�s�����Ǝ����Z�P�R
            case 7127: //���K�͑��@�\�^�s�����Ǝ����Z�P�S
            case 7129: //���K�͑��@�\�^�s�����Ǝ����Z�P�T
            case 7131: //���K�͑��@�\�^�s�����Ǝ����Z�P�U
            case 7133: //���K�͑��@�\�^�s�����Ǝ����Z�P�V
            case 7135: //���K�͑��@�\�^�s�����Ǝ����Z�P�W
            case 7137: //���K�͑��@�\�^�s�����Ǝ����Z�P�X
            case 7139: //���K�͑��@�\�^�s�����Ǝ����Z�Q�O
            case 8011: //���K�͑��@�\�P�E�蒴
            case 8013: //���K�͑��@�\�P�E�蒴�E�ߏ�
            case 8015: //���K�͑��@�\�P�E�蒴�E����
            case 8017: //���K�͑��@�\�P�E�蒴�E����E�ߏ�
            case 8021: //���K�͑��@�\�Q�E�蒴
            case 8023: //���K�͑��@�\�Q�E�蒴�E�ߏ�
            case 8025: //���K�͑��@�\�Q�E�蒴�E����
            case 8027: //���K�͑��@�\�Q�E�蒴�E����E�ߏ�
            case 8031: //���K�͑��@�\�R�E�蒴
            case 8033: //���K�͑��@�\�R�E�蒴�E�ߏ�
            case 8035: //���K�͑��@�\�R�E�蒴�E����
            case 8037: //���K�͑��@�\�R�E�蒴�E����E�ߏ�
            case 8041: //���K�͑��@�\�S�E�蒴
            case 8043: //���K�͑��@�\�S�E�蒴�E�ߏ�
            case 8045: //���K�͑��@�\�S�E�蒴�E����
            case 8047: //���K�͑��@�\�S�E�蒴�E����E�ߏ�
            case 8051: //���K�͑��@�\�T�E�蒴
            case 8053: //���K�͑��@�\�T�E�蒴�E�ߏ�
            case 8055: //���K�͑��@�\�T�E�蒴�E����
            case 8057: //���K�͑��@�\�T�E�蒴�E����E�ߏ�
            case 9011: //���K�͑��@�\�P�E�l��
            case 9013: //���K�͑��@�\�P�E�l���E�ߏ�
            case 9015: //���K�͑��@�\�P�E�l���E����
            case 9017: //���K�͑��@�\�P�E�l���E����E�ߏ�
            case 9021: //���K�͑��@�\�Q�E�l��
            case 9023: //���K�͑��@�\�Q�E�l���E�ߏ�
            case 9025: //���K�͑��@�\�Q�E�l���E����
            case 9027: //���K�͑��@�\�Q�E�l���E����E�ߏ�
            case 9031: //���K�͑��@�\�R�E�l��
            case 9033: //���K�͑��@�\�R�E�l���E�ߏ�
            case 9035: //���K�͑��@�\�R�E�l���E����
            case 9037: //���K�͑��@�\�R�E�l���E����E�ߏ�
            case 9041: //���K�͑��@�\�S�E�l��
            case 9043: //���K�͑��@�\�S�E�l���E�ߏ�
            case 9045: //���K�͑��@�\�S�E�l���E����
            case 9047: //���K�͑��@�\�S�E�l���E����E�ߏ�
            case 9051: //���K�͑��@�\�T�E�l��
            case 9053: //���K�͑��@�\�T�E�l���E�ߏ�
            case 9055: //���K�͑��@�\�T�E�l���E����
            case 9057: //���K�͑��@�\�T�E�l���E����E�ߏ�
                result = true;
                break;
            }
            break;
            
        case 75: //���\�h���K�͑��@�\�^������
            switch(item){
            case 1111: //�\���K�͑��@�\�P
            case 1113: //�\���K�͑��@�\�P�E�ߏ�
            case 1115: //�\���K�͑��@�\�P�E����
            case 1117: //�\���K�͑��@�\�P�E����E�ߏ�
            case 1121: //�\���K�͑��@�\�Q
            case 1123: //�\���K�͑��@�\�Q�E�ߏ�
            case 1125: //�\���K�͑��@�\�Q�E����
            case 1127: //�\���K�͑��@�\�Q�E����E�ߏ�
            case 6101: //�\�����@�\�T�[�r�X�񋟑̐����Z�T
            case 6102: //�\�����@�\�T�[�r�X�񋟑̐����Z�U
            case 6103: //�\�����@�\�T�[�r�X�񋟑̐����Z�V
            case 6139: //�\�����@�\�^���ƊJ�n�x�����Z
            case 8011: //�\���K�͑��@�\�P�E��
            case 8013: //�\���K�͑��@�\�P�E���E�ߏ�
            case 8015: //�\���K�͑��@�\�P�E���E����
            case 8017: //�\���K�͑��@�\�P�E���E����E�ߏ�
            case 8021: //�\���K�͑��@�\�Q�E��
            case 8023: //�\���K�͑��@�\�Q�E���E�ߏ�
            case 8025: //�\���K�͑��@�\�Q�E���E����
            case 8027: //�\���K�͑��@�\�Q�E���E����E�ߏ�
            case 9011: //�\���K�͑��@�\�P�E��
            case 9013: //�\���K�͑��@�\�P�E���E�ߏ�
            case 9015: //�\���K�͑��@�\�P�E���E����
            case 9017: //�\���K�͑��@�\�P�E���E����E�ߏ�
            case 9021: //�\���K�͑��@�\�Q�E��
            case 9023: //�\���K�͑��@�\�Q�E���E�ߏ�
            case 9025: //�\���K�͑��@�\�Q�E���E����
            case 9027: //�\���K�͑��@�\�Q�E���E����E�ߏ�
                result = true;
                break;
            }
            break;
            
        case 76: //�������E�����Ή��^�K��Ō���
            switch(item){
            case 1111: //������񐏎��T�P�P
            case 1121: //������񐏎��T�P�Q
            case 1131: //������񐏎��T�P�R
            case 1141: //������񐏎��T�P�S
            case 1151: //������񐏎��T�P�T
            case 1211: //������񐏎��T�Q�P
            case 1213: //������񐏎��T�Q�P�E�y��
            case 1221: //������񐏎��T�Q�Q
            case 1223: //������񐏎��T�Q�Q�E�y��
            case 1231: //������񐏎��T�Q�R
            case 1233: //������񐏎��T�Q�R�E�y��
            case 1241: //������񐏎��T�Q�S
            case 1243: //������񐏎��T�Q�S�E�y��
            case 1251: //������񐏎��T�Q�T
            case 1253: //������񐏎��T�Q�T�E�y��
            case 2111: //������񐏎��U�P
            case 2121: //������񐏎��U�Q
            case 2131: //������񐏎��U�R
            case 2141: //������񐏎��U�S
            case 2151: //������񐏎��U�T
            case 3100: //�������ً}���K��Ō���Z
            case 4000: //���������ʊǗ����Z�T
            case 4001: //���������ʊǗ����Z�U
            case 6100: //�������^�[�~�i���P�A���Z
            case 6101: //�������T�[�r�X�񋟑̐����Z�T
            case 6102: //�������T�[�r�X�񋟑̐����Z�U
            case 6103: //�������T�[�r�X�񋟑̐����Z�V
            case 7101: //�������s�����Ǝ����Z�P
            case 7103: //�������s�����Ǝ����Z�Q
            case 7105: //�������s�����Ǝ����Z�R
            case 7107: //�������s�����Ǝ����Z�S
            case 7109: //�������s�����Ǝ����Z�T
            case 7111: //�������s�����Ǝ����Z�U
            case 7113: //�������s�����Ǝ����Z�V
            case 7115: //�������s�����Ǝ����Z�W
            case 7117: //�������s�����Ǝ����Z�X
            case 7119: //�������s�����Ǝ����Z�P�O
            case 8000: //���������ʒn��K��Ō���Z
            case 8100: //������񏬋K�͎��Ə����Z
            case 8110: //������񒆎R�Ԓn�擙�񋟉��Z
                result = true;
                break;
            }
            break;
            
        case 77: //�����^�T�[�r�X
            switch(item){
            case 1111: //�����^�T�[�r�X�P
            case 1113: //�����^�T�[�r�X�P�E�ߏ�
            case 1121: //�����^�T�[�r�X�Q
            case 1123: //�����^�T�[�r�X�Q�E�ߏ�
            case 1131: //�����^�T�[�r�X�R
            case 1133: //�����^�T�[�r�X�R�E�ߏ�
            case 1141: //�����^�T�[�r�X�S
            case 1143: //�����^�T�[�r�X�S�E�ߏ�
            case 1151: //�����^�T�[�r�X�T
            case 1153: //�����^�T�[�r�X�T�E�ߏ�
            case 3100: //�����^�ً}���K��Ō���Z
            case 4000: //�����^���ʊǗ����Z�T
            case 4001: //�����^���ʊǗ����Z�U
            case 6001: //�����^��ÖK��Ō쌸�Z�P
            case 6003: //�����^��ÖK��Ō쌸�Z�Q
            case 6005: //�����^��ÖK��Ō쌸�Z�R
            case 6007: //�����^��ÖK��Ō쌸�Z�S
            case 6009: //�����^��ÖK��Ō쌸�Z�T
            case 6100: //�����^�^�[�~�i���P�A���Z
            case 6101: //�����^�T�[�r�X�񋟑̐����Z�T
            case 6102: //�����^�T�[�r�X�񋟑̐����Z�U
            case 6103: //�����^�T�[�r�X�񋟑̐����Z�V
            case 6128: //�����^�F�m�ǉ��Z�T
            case 6129: //�����^�F�m�ǉ��Z�U
            case 6139: //�����^���ƊJ�n�x�����Z
            case 7101: //�����^�s�����Ǝ����Z�P
            case 7103: //�����^�s�����Ǝ����Z�Q
            case 7105: //�����^�s�����Ǝ����Z�R
            case 7107: //�����^�s�����Ǝ����Z�S
            case 7109: //�����^�s�����Ǝ����Z�T
            case 7111: //�����^�s�����Ǝ����Z�U
            case 7113: //�����^�s�����Ǝ����Z�V
            case 7115: //�����^�s�����Ǝ����Z�W
            case 7117: //�����^�s�����Ǝ����Z�X
            case 7119: //�����^�s�����Ǝ����Z�P�O
            case 7121: //�����^�s�����Ǝ����Z�P�P
            case 7123: //�����^�s�����Ǝ����Z�P�Q
            case 7125: //�����^�s�����Ǝ����Z�P�R
            case 7127: //�����^�s�����Ǝ����Z�P�S
            case 7129: //�����^�s�����Ǝ����Z�P�T
            case 7131: //�����^�s�����Ǝ����Z�P�U
            case 7133: //�����^�s�����Ǝ����Z�P�V
            case 7135: //�����^�s�����Ǝ����Z�P�W
            case 7137: //�����^�s�����Ǝ����Z�P�X
            case 7139: //�����^�s�����Ǝ����Z�Q�O
            case 8011: //�����^�T�[�r�X�P�E�蒴
            case 8013: //�����^�T�[�r�X�P�E�蒴�E�ߏ�
            case 8021: //�����^�T�[�r�X�Q�E�蒴
            case 8023: //�����^�T�[�r�X�Q�E�蒴�E�ߏ�
            case 8031: //�����^�T�[�r�X�R�E�蒴
            case 8033: //�����^�T�[�r�X�R�E�蒴�E�ߏ�
            case 8041: //�����^�T�[�r�X�S�E�蒴
            case 8043: //�����^�T�[�r�X�S�E�蒴�E�ߏ�
            case 8051: //�����^�T�[�r�X�T�E�蒴
            case 8053: //�����^�T�[�r�X�T�E�蒴�E�ߏ�
            case 9011: //�����^�T�[�r�X�P�E�l��
            case 9013: //�����^�T�[�r�X�P�E�l���E�ߏ�
            case 9021: //�����^�T�[�r�X�Q�E�l��
            case 9023: //�����^�T�[�r�X�Q�E�l���E�ߏ�
            case 9031: //�����^�T�[�r�X�R�E�l��
            case 9033: //�����^�T�[�r�X�R�E�l���E�ߏ�
            case 9041: //�����^�T�[�r�X�S�E�l��
            case 9043: //�����^�T�[�r�X�S�E�l���E�ߏ�
            case 9051: //�����^�T�[�r�X�T�E�l��
            case 9053: //�����^�T�[�r�X�T�E�l���E�ߏ�
                result = true;
                break;
            }
            break;
        }
        
        return result;
    }
    
    /**
     * �P�ʐ��𒠕[�ɋL�ڂ��Ȃ��T�[�r�X�ł��邩�m�F����B
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isUnitNotShowService(String serviceCodeKind, String serviceCodeItem) throws Exception {
        int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        int item = ACCastUtilities.toInt(serviceCodeItem,0);
        boolean result = false;
        
        switch(kind){
        //��ԑΉ��^�K����
        case 71:
            switch(item){
            //��ԖK����P��{
            case 1111:
            //��ԖK����Q
            case 2111:
                result = true;
                break;
            }
            break;
            
        //�����p��
        case 17:
            result = true;
            break;
        default:
            result = isUnitNoCountService(kind,item);
            break;
        }
        
        return result;
    }
    
    
    /**
     * �񋟉񐔂�1��Ƃ��Čv�シ��T�[�r�X�ł��邩�m�F����B
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isSingleCountService(String serviceCodeKind, String serviceCodeItem) throws Exception {
        int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        int item = ACCastUtilities.toInt(serviceCodeItem,0);
        return isSingleNoCountService(kind,item);
    }
    
    /**
     * �񋟉񐔂�1��Ƃ��Čv�シ��T�[�r�X�ł��邩�m�F����B
     * @param serviceCodeKind �T�[�r�X�R�[�h���
     * @param serviceCodeItem �T�[�r�X�R�[�h����
     * @return true : �񋟉񐔂�1��Ƃ��Čv�シ�� false : �񋟉񐔂��v�シ��
     * @throws Exception
     */
    public static boolean isSingleNoCountService(int kind, int item) throws Exception {
        
        boolean result = false;
        
        switch(kind){
    	//�����p��ݗ^
    	case 17:
    	//���\�h�����p��ݗ^
    	case 67:
    		switch(item){
    		//�Ԃ��������p��ݗ^���n���Z
    		case 8001:
    		//�Ԃ����t���i�ݗ^���n���Z
    		case 8002:
    		//����Q��ݗ^���n���Z
    		case 8003:
    		//����Q��t���i�ݗ^���n���Z
    		case 8004:
    		//������h�~�p��ݗ^���n���Z
    		case 8005:
    		//�̈ʕϊ���ݗ^���n���Z
    		case 8006:
    		//�肷��ݗ^���n���Z
    		case 8007:
    		//�X���[�v�ݗ^���n���Z
    		case 8008:
    		//���s��ݗ^���n���Z
    		case 8009:
    		//���s�⏕���ݗ^���n���Z
    		case 8010:
    		//�p�j���m�@��ݗ^���n���Z
    		case 8011:
    		//�ړ��p���t�g�ݗ^���n���Z
    		case 8012:
            //[ID:0000714][Shin Fujihara] 2012/03 add begin ����24�N4���@�����Ή�
            //�����r���������u�ݗ^���n���Z
            case 8013:
            //[ID:0000714][Shin Fujihara] 2012/03 add end ����24�N4���@�����Ή�
			//[ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
			//�Ԃ����ݗ^���K�͉��Z
    		case 8101:
			//�Ԃ����t���i�ݗ^���K�͉��Z
    		case 8102:
			//����Q��ݗ^���K�͉��Z
    		case 8103:
			//����Q��t���i�ݗ^���K�͉��Z
    		case 8104:
			//������h�~�p��ݗ^���K�͉��Z
    		case 8105:
			//�̈ʕϊ���ݗ^���K�͉��Z
    		case 8106:
			//�肷��ݗ^���K�͉��Z
    		case 8107:
			//�X���[�v�ݗ^���K�͉��Z
    		case 8108:
			//���s��ݗ^���K�͉��Z
    		case 8109:
			//���s�⏕���ݗ^���K�͉��Z
    		case 8110:
			//�p�j���m�@��ݗ^���K�͉��Z
    		case 8111:
			//�ړ��p���t�g�ݗ^���K�͉��Z
    		case 8112:
			//�Ԃ����ݗ^���R�Ԓn����Z
    		case 8201:
			//�Ԃ����t���i�ݗ^���R�Ԓn����Z
    		case 8202:
			//����Q��ݗ^���R�Ԓn����Z
    		case 8203:
			//����Q��t���i�ݗ^���R�Ԓn����Z
    		case 8204:
			//������h�~�p��ݗ^���R�Ԓn����Z
    		case 8205:
			//�̈ʕϊ���ݗ^���R�Ԓn����Z
    		case 8206:
			//�肷��ݗ^���R�Ԓn����Z
    		case 8207:
			//�X���[�v�ݗ^���R�Ԓn����Z
    		case 8208:
			//���s��ݗ^���R�Ԓn����Z
    		case 8209:
			//���s�⏕���ݗ^���R�Ԓn����Z
    		case 8210:
			//�p�j���m�@��ݗ^���R�Ԓn����Z
    		case 8211:
			//�ړ��p���t�g�ݗ^���R�Ԓn����Z
    		case 8212:
			//[ID:0000447][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
    		//[ID:0000714][Shin Fujihara] 2012/03 add begin ����24�N4���@�����Ή�
    		//�����r�����u�ݗ^���R�Ԓn����Z
    		case 8213:
    		//[ID:0000714][Shin Fujihara] 2012/03 add end ����24�N4���@�����Ή�
    			result = true;
    			break;
    		}
    		break;
        
        
        //���K�͑��@�\�^������
        case 73:
            switch(item){
            //���K�͑��@�\�^������o
            case 1101:
            //���K�͑��@�\�^������P
            case 1111:
            //���K�͑��@�\�^������Q
            case 1121:
            //���K�͑��@�\�^������R
            case 1131:
            //���K�͑��@�\�^������S
            case 1141:
            //���K�͑��@�\�^������T
            case 1151:
            //�����@�\�^������o�E�蒴
            case 8001:
            //�����@�\�^�����P�E�蒴
            case 8011:
            //�����@�\�^�����Q�E�蒴
            case 8021:
            //�����@�\�^�����R�E�蒴
            case 8031:
            //�����@�\�^�����S�E�蒴
            case 8041:
            //�����@�\�^�����T�E�蒴
            case 8051:
            //�����@�\�^������o�E�l��
            case 9001:
            //�����@�\�^������P�E�l��
            case 9011:
            //�����@�\�^������Q�E�l��
            case 9021:
            //�����@�\�^������R�E�l��
            case 9031:
            //�����@�\�^������S�E�l��
            case 9041:
            //�����@�\�^������T�E�l��
            case 9051:
            	
        	//[ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
        	//���K�͑��@�\�^������P�E�ߏ�
        	case 1113:
        	//���K�͑��@�\�^������Q�E�ߏ�
        	case 1123:
        	//���K�͑��@�\�^������R�E�ߏ�
        	case 1133:
        	//���K�͑��@�\�^������S�E�ߏ�
        	case 1143:
        	//���K�͑��@�\�^������T�E�ߏ�
        	case 1153:
        	//�����@�\�^������P�E�蒴�E�ߏ�
        	case 8013:
        	//�����@�\�^������Q�E�蒴�E�ߏ�
        	case 8023:
        	//�����@�\�^������R�E�蒴�E�ߏ�
        	case 8033:
        	//�����@�\�^������S�E�蒴�E�ߏ�
        	case 8043:
        	//�����@�\�^������T�E�蒴�E�ߏ�
        	case 8053:
        	//�����@�\�^������P�E�l���E�ߏ�
        	case 9013:
        	//�����@�\�^������Q�E�l���E�ߏ�
        	case 9023:
        	//�����@�\�^������R�E�l���E�ߏ�
        	case 9033:
        	//�����@�\�^������S�E�l���E�ߏ�
        	case 9043:
        	//�����@�\�^������T�E�l���E�ߏ�
        	case 9053:
        	//[ID:0000447][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
        		
                result = true;
                break;
            }
            break;
        //���\�h���K�͑��@�\�^������
        case 75:
        	switch(item){
        	//�\�h�����@�\�^������P
        	case 1111:
        	//�\�h�����@�\�^������Q
        	case 1121:
        	//�\�����@�\�^����P�E�蒴
        	case 8011:
        	//�\�����@�\�^����Q�E�蒴
        	case 8021:
        	//�\�����@�\�^����P�E�l��
        	case 9011:
        	//�\�����@�\�^����Q�E�l��
        	case 9021:
        		
    		//[ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
    		//�\�h�����@�\�^������P�E�ߏ�
        	case 1113:
    		//�\�h�����@�\�^������Q�E�ߏ�
        	case 1123:
    		//�\�����@�\�^���ƊJ�n�x�����Z�T
        	case 6139:
    		//�\�����@�\�^���ƊJ�n�x�����Z�U
        	case 6140:
    		//�\�����@�\�T�[�r�X�񋟑̐����Z�T
        	case 6101:
    		//�\�����@�\�T�[�r�X�񋟑̐����Z�U
        	case 6102:
    		//�\�����@�\�T�[�r�X�񋟑̐����Z�V
        	case 6103:
    		//�\�����@�\�^����P�E�蒴�E�ߏ�k
        	case 8013:
    		//�\�����@�\�^����Q�E�蒴�E�ߏ�
        	case 8023:
    		//�\�����@�\�^����P�E�l���E�ߏ�
        	case 9013:
    		//�\�����@�\�^����Q�E�l���E�ߏ�
        	case 9023:
    		//[ID:0000447][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
        		
        		result = true;
        		break;
        	}
        	break;
        }
        
        return result;
    }
    
    /**
     * �T�[�r�X�񐔂����̓����ɕύX����T�[�r�X���m�F����B
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isMaxCountService(String serviceCodeKind, String serviceCodeItem) throws Exception {
        int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        int item = ACCastUtilities.toInt(serviceCodeItem,0);
        return isMaxCountService(kind,item);
    }
    
    /**
     * �T�[�r�X�񐔂����̓����ɕύX����T�[�r�X���m�F����B
     * @param serviceCodeKind �T�[�r�X�R�[�h���
     * @param serviceCodeItem �T�[�r�X�R�[�h����
     * @return true : �P�ʐ����L�ڂ��Ȃ� false : �P�ʐ����L�ڂ���
     * @throws Exception
     */
    public static boolean isMaxCountService(int kind, int item) throws Exception {
        
        boolean result = false;
        
        switch(kind){
        //����{�ݓ����Ґ������
        case 33:
            switch(item){
            //�O���Ԉ֎q�ݗ^
            case 2001:
            //�O���Ԉ֎q�t���i�ݗ^
            case 2002:
            //�O������Q��ݗ^
            case 2003:
            //�O������Q��t���i�ݗ^
            case 2004:
            //�O��������h�~�p��ݗ^
            case 2005:
            //�O���̈ʕϊ��@�ݗ^
            case 2006:
            //�O���肷��ݗ^
            case 2007:
            //�O���X���[�v�ݗ^
            case 2008:
            //�O�����s��ݗ^
            case 2009:
            //�O�����s�⏕���ݗ^
            case 2010:
            //�O���o�~���m��ݗ^
            case 2011:
            //�O���ړ��p���t�g�ݗ^
            case 2012:
            //[ID:0000711][Shin Fujihara] 2012/03 add begin ����24�N4���@�����Ή�
            //�O�������r�����u�ݗ^
            case 2013:
            //[ID:0000711][Shin Fujihara] 2012/03 add end ����24�N4���@�����Ή�
                result = true;
                break;
            }
            break;
        //�����p��ݗ^
        case 17:
            //�����p��n��͈ꗥ�P�ʐ����o�͂��Ȃ��B
            switch(item){
            //�Ԉ֎q�ݗ^
            case 1001:
            //�Ԉ֎q�t���i�ݗ^
            case 1002:
            //����Q��ݗ^
            case 1003:
            //����Q��t���i�ݗ^
            case 1004:
            //������h�~�p��ݗ^
            case 1005:
            //�̈ʕϊ��@�ݗ^
            case 1006:
            //�肷��ݗ^
            case 1007:
            //�X���[�v�ݗ^
            case 1008:
            //���s��ݗ^
            case 1009:
            //���s�⏕���ݗ^
            case 1010:
            //�p�j�T�m�@�ݗ^
            case 1011:
            //�ړ��p���t�g�ݗ^
            case 1012:
            //[ID:0000711][Shin Fujihara] 2012/03 add begin ����24�N4���@�����Ή�
            //�����r�����u�ݗ^
            case 1013:
            //[ID:0000711][Shin Fujihara] 2012/03 add end ����24�N4���@�����Ή�
                result = true;
                break;
            }
            break;
            
        //���\�h�����p��ݗ^
        case 67:
        	//�����p��n��͈ꗥ�P�ʐ����o�͂��Ȃ��B
        	switch(item){
            //�\�h�Ԉ֎q�ݗ^
            case 1001:
            //�\�h�Ԉ֎q�t���i�ݗ^
            case 1002:
            //�\�h����Q��ݗ^
            case 1003:
            //�\�h����Q��t���i�ݗ^
            case 1004:
            //�\�h������h�~�p��ݗ^
            case 1005:
            //�\�h�̈ʕϊ��@�ݗ^
            case 1006:
            //�\�h�肷��ݗ^
            case 1007:
            //�\�h�X���[�v�ݗ^
            case 1008:
            //�\�h���s��ݗ^
            case 1009:
            //�\�h���s�⏕���ݗ^
            case 1010:
            //�\�h�p�j�T�m�@�ݗ^
            case 1011:
            //�\�h�ړ��p���t�g�ݗ^
            case 1012:
            //[ID:0000711][Shin Fujihara] 2012/03 add begin ����24�N4���@�����Ή�
            //�\�h�����r�����u�ݗ^
            case 1013:
            //[ID:0000711][Shin Fujihara] 2012/03 add end ����24�N4���@�����Ή�
                result = true;
                break;
        	}
        	break;
            
        //���K�͑��@�\�^������
        case 73:
            switch(item){
            //���K�͑��@�\�^������o
            case 1101:
            //���K�͑��@�\�^������P
            case 1111:
            //���K�͑��@�\�^������Q
            case 1121:
            //���K�͑��@�\�^������R
            case 1131:
            //���K�͑��@�\�^������S
            case 1141:
            //���K�͑��@�\�^������T
            case 1151:
            //�����@�\�^������o�E�蒴
            case 8001:
            //�����@�\�^�����P�E�蒴
            case 8011:
            //�����@�\�^�����Q�E�蒴
            case 8021:
            //�����@�\�^�����R�E�蒴
            case 8031:
            //�����@�\�^�����S�E�蒴
            case 8041:
            //�����@�\�^�����T�E�蒴
            case 8051:
            //�����@�\�^������o�E�l��
            case 9001:
            //�����@�\�^������P�E�l��
            case 9011:
            //�����@�\�^������Q�E�l��
            case 9021:
            //�����@�\�^������R�E�l��
            case 9031:
            //�����@�\�^������S�E�l��
            case 9041:
            //�����@�\�^������T�E�l��
            case 9051:
            
            //[ID:0000497][Shin Fujihara] 2009/04/28 add begin ��Q�Ή�
            /*
        	//[ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
        	//���K�͑��@�\�^�F�m�ǉ��Z�T
        	case 6128:
        	//���K�͑��@�\�^�F�m�ǉ��Z�U
        	case 6129:
        	//���K�͑��@�\�^�Ō�E���z�u���Z�T
        	case 6137:
        	//���K�͑��@�\�^�Ō�E���z�u���Z�U
        	case 6138:
        	//���K�͑��@�\�^���ƊJ�n�x�����Z�T
        	case 6139:
        	//���K�͑��@�\�^���ƊJ�n�x�����Z�U
        	case 6140:
        	//�����@�\�^�T�[�r�X�񋟑̐����Z�T
        	case 6101:
        	//�����@�\�^�T�[�r�X�񋟑̐����Z�U
        	case 6102:
        	//�����@�\�^�T�[�r�X�񋟑̐����Z�V
        	case 6103:
        	//���K�͑��@�\�^�s�����Ǝ����Z�P
        	case 7001:
        	//���K�͑��@�\�^�s�����Ǝ����Z�Q
        	case 7002:
        	//���K�͑��@�\�^�s�����Ǝ����Z�R
        	case 7003:
        	//���K�͑��@�\�^�s�����Ǝ����Z�S
        	case 7004:
        	//���K�͑��@�\�^�s�����Ǝ����Z�T
        	case 7005:
        	//���K�͑��@�\�^�s�����Ǝ����Z�U
        	case 7006:
        	//���K�͑��@�\�^�s�����Ǝ����Z�V
        	case 7007:
        	//���K�͑��@�\�^�s�����Ǝ����Z�W
        	case 7008:
        	//���K�͑��@�\�^�s�����Ǝ����Z�X
        	case 7009:
        	//���K�͑��@�\�^�s�����Ǝ����Z�P�O
        	case 7010:
        	//[ID:0000447][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
            */
            //[ID:0000497][Shin Fujihara] 2009/04/28 add end ��Q�Ή�
                result = true;
                break;
            }
            break;
            
        //���\�h����{�ݓ����Ґ������
        case 35:
        	switch(item){
        	//�\�h�O���Ԃ����ݗ^
        	case 1901:
        	//�\�h�O���Ԃ����t���i�ݗ^
        	case 1902:
        	//�\�h�O������Q��ݗ^
        	case 1903:
        	//�\�h�O������Q��t���i�ݗ^
        	case 1904:
        	//�\�h�O��������h�~�p��ݗ^
        	case 1905:
        	//�\�h�O���̈ʕϊ���ݗ^
        	case 1906:
        	//�\�h�O���肷��ݗ^
        	case 1907:
        	//�\�h�O���X���[�v�ݗ^
        	case 1908:
        	//�\�h�O�����s��ݗ^
        	case 1909:
        	//�\�h�O�����s�⏕���ݗ^
        	case 1910:
        	//�\�h�O���p�j���m�@��ݗ^
        	case 1911:
        	//�\�h�O���ړ��p���t�g�ݗ^
        	case 1912:
            //[ID:0000711][Shin Fujihara] 2012/03 add begin ����24�N4���@�����Ή�
            //�\�h�O�������r�����u�ݗ^
            case 1913:
            //[ID:0000711][Shin Fujihara] 2012/03 add end ����24�N4���@�����Ή�
        		result = true;
        		break;
        	}
        	break;
        	
//        //���\�h���K�͑��@�\�^������
//        case 75:
//        	switch(item){
//        	//�\�h���K�͑��@�\�^������P
//        	case 1111:
//        	//�\�h���K�͑��@�\�^������Q
//        	case 1121:
//        	//�\���K�͑��@�\�^����P�E�蒴
//        	case 8011:
//        	//�\���K�͑��@�\�^����Q�E�蒴
//        	case 8021:
//        	//�\���K�͑��@�\�^����P�E�l��
//        	case 9011:
//        	//�\���K�͑��@�\�^����Q�E�l��
//        	case 9021:
//        		result = true;
//        		break;
//        	}
//        	break;
        }
        
        return result;
    }
    
    /**
     * ���p�ҕ��S�z���擾����B
     * @param serviceCode
     * @param patientState
     * @return
     * @throws Exception
     */
    public static int getRiyosyaFutan(VRMap serviceCode, QP001PatientState patientState) throws Exception {
        Object unit = null;
        
        switch(QP001SpecialCase.getServiceKind(serviceCode)){
        //�H��
        case 1:
            unit = patientState.getShisetsuData("LIMIT_SHOKUHI");
            break;
        //���j�b�g�^��
        case 2:
            unit = patientState.getShisetsuData("LIMIT_UNIT_KOSHITSU");
            break;
        //���j�b�g�^����
        case 3:
            unit = patientState.getShisetsuData("LIMIT_UNIT_JUNKOSHITSU");
            break;
        //�]���^��(���{��)
        case 4:
            unit = patientState.getShisetsuData("LIMIT_JURAIGATA1");
            break;
        //�]���^��(�V���E�×{��)
        case 5:
            unit = patientState.getShisetsuData("LIMIT_JURAIGATA2");
            break;
        //������
        case 6:
            unit = patientState.getShisetsuData("LIMIT_TASHOSHITSU");
            break;
        }
        
        return ACCastUtilities.toInt(unit,0);
    }
    
    /**
     * �P�����擾����B
     * @param serviceDetail
     * @param serviceCode
     * @return
     * @throws Exception
     */
    public static int getUnit(VRMap serviceDetail, VRMap serviceCode,QP001Manager manager) throws Exception {
        int unit = 0;
        //[ID:0000641][Shin Fujihara] 2011/04/14 add begin
        int defaultUnit = Integer.MIN_VALUE;
        //[ID:0000641][Shin Fujihara] 2011/04/14 add end
        
        //�T�[�r�X�̎�ʂ𔻒肷��
        //�H��̏ꍇ�́A�T�[�r�X�R�[�h�ɐݒ肳��Ă���P����ԋp����B
        if(QP001SpecialCase.getServiceKind(serviceCode) == 1){
            unit = ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_UNIT",serviceCode),0);
            
            //[ID:0000641][Shin Fujihara] 2011/04/14 add begin
            //�}�X�^����H��̊�z���擾
            defaultUnit = manager.getDefaultFoodCost();
            //[ID:0000641][Shin Fujihara] 2011/04/14 add end
            
        //�z�e���R�X�g�͎��Ə��ɓo�^����Ă�l���擾����B
        } else {
            unit = manager.getHotelUnit(String.valueOf(serviceDetail.get("PROVIDER_ID")),String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),String.valueOf(serviceCode.get("SERVICE_CODE_ITEM")));
            
            // [ID:0000641][Shin Fujihara] 2011/04/13 edit begin
            // ��z�Ǝ��Ə��ڍדo�^��ʂœ��͂��ꂽ���z���r���A���z�̒Ⴂ�ق����̗p����悤�C���B
            defaultUnit = ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_UNIT",serviceCode),0);
            
//            if(unit == Integer.MIN_VALUE){
//                unit = ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_UNIT",serviceCode),0);
//            }
            // [ID:0000641][Shin Fujihara] 2011/04/13 edit end

        }
        
        //[ID:0000641][Shin Fujihara] 2011/04/14 add begin
        //��z�ȏ�̒l���ݒ肳��Ă���΁A��z�ɖ߂�
        if((unit == Integer.MIN_VALUE) || (defaultUnit < unit)) {
            unit = defaultUnit;
        }
        //[ID:0000641][Shin Fujihara] 2011/04/14 add end
        
        return unit;
    }
    
    /**
     * �n�斧���^�T�[�r�X�ł��邩���擾����B
     * @param serviceCodeKind
     * @return
     * @throws Exception
     */
    public static boolean isRegionStickingService(String serviceCodeKind) throws Exception {
        int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        return isRegionStickingService(kind);
    }
    /**
     * �n�斧���^�T�[�r�X�ł��邩���擾����B
     * @param kind
     * @return
     * @throws Exception
     */
    public static boolean isRegionStickingService(int kind) throws Exception {
        boolean result = false;
        
        switch(kind){
        //�F�m�ǑΉ��^
        case 32:
        //�n�����{��
        case 36:
        //�\�h�F�m��
        case 37:
        //�F�m�ǒZ��
        case 38:
        //�\�h�F�m�Z��
        case 39:
        //�n�敟���{��
        case 54:
        //��ԖK����
        case 71:
        //�F�m�ǒʏ�
        case 72:
        //���K�͑��@�\
        case 73:
        //�\�h�F�m�ʏ�
        case 74:
        //�\�h���K��
        case 75:
            result = true;
            break;
        }
        return result;
    }
    
    //[ID:0000523][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
    /**
     * 
     * @param discriminationNo
     * @param insurerdNo
     * @param selfPay
     * @param usedSelfPay
     * @param kohi
     * @param nursing
     * @return
     * @throws Exception
     */
    public static int getApplicationIndividualPayment(
    		String discriminationNo,
    		String insurerdNo,
    		int selfPay,
    		int usedSelfPay,
    		String kohi,
    		QP001RecordNursing nursing) throws Exception {
    	
    	
    	int nursingKohiCost = 0;
    	
    	if ((nursing != null)
    		&& (nursing.get_801007() == 99)){
    		nursingKohiCost = nursing.get_801026();
    	}
    	
    	
    	return getApplicationIndividualPayment(discriminationNo, insurerdNo, selfPay, usedSelfPay, kohi, nursingKohiCost);
    }

    /**
     * 
     * @param discriminationNo
     * @param insurerdNo
     * @param selfPay
     * @param usedSelfPay
     * @param kohi
     * @param nursing
     * @return
     * @throws Exception
     */
    public static int getApplicationIndividualPayment(
    		String discriminationNo,
    		String insurerdNo,
    		int selfPay,
    		int usedSelfPay,
    		String kohi,
    		VRMap nursing) throws Exception {
    	
    	
    	int nursingKohiCost = 0;
    	
    	if ((nursing != null)
        	&& (ACCastUtilities.toInt(nursing.get("801007"), 0) == 99)){
        	nursingKohiCost = ACCastUtilities.toInt(nursing.get("801026"), 0);
        }
    	
    	return getApplicationIndividualPayment(discriminationNo, insurerdNo, selfPay, usedSelfPay, kohi, nursingKohiCost);
    }
    //[ID:0000523][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
    
    /**
     * ����f�Ô�ւ̌���ȕ��S�z���擾����B
     * @param discriminationNo �l���ԍ�
     * @param insurerdNo ��ی��Ҕԍ� 
     * @param selfPay ���ȕ��S�z
     * @param usedSelfPay ���Ɏg�p�ς݂̌���ȕ��S�z
     * @return ����f�Ô�ɓK�p�\�Ȍ���ȕ��S�z
     * @throws Exception
     */
    //[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
    //public static int getApplicationIndividualPayment(String discriminationNo,String insurerdNo,int selfPay,int usedSelfPay, String kohi) throws Exception {
    public static int getApplicationIndividualPayment(String discriminationNo,String insurerdNo,int selfPay,int usedSelfPay, String kohi, int nursingKohiCost) throws Exception {
    //[ID:0000523][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
        //�l���攪�A���A��\�łȂ���ΓK�p�\
        if(!isShisetsuDiscriminationNo(discriminationNo)){
            return selfPay;
        }
        //���ےP�Ƃł���ΓK�p�\
        if(isSeihoOnly(insurerdNo)){
            return selfPay;
        }
        
        //[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
        /*
        if(SEIHO_SELF_PAY < (selfPay + usedSelfPay)){
            return SEIHO_SELF_PAY - usedSelfPay;
        }
        */
        if((kohi != null) && (kohi.startsWith("12"))){
        	
        	if (nursingKohiCost > 0) {
	            if(SEIHO_SELF_PAY < (selfPay + usedSelfPay)){
	                return SEIHO_SELF_PAY - usedSelfPay;
	            }
        	}
        }
        //[ID:0000523][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
        
        return selfPay;
    }

    // add sta 2006.05.20 fujihara.shin
    /**
     * �ً}�����Ï�񃌃R�[�h�̒l�Ƃ��đÓ��ł��邩���肷��B
     * @param map ���؂��s���f�[�^
     * @return true:�Ó��ł���@false:�Ó��łȂ�
     * @throws Exception
     */
    public static boolean isValidRecordEmergency(VRMap map) throws Exception {
    	
    	if(map == null){
    		return false;
    	}
    	
    	//���K�{���ځ�
    	//���Âꂩ�ЂƂł����͂���Ă����OK
    	//�ً}�����a��1 40��
    	if(!ACTextUtilities.isNullText(map.get("401008"))){
    		return true;
    	}
    	//�ً}�����a��2 40��
    	if(!ACTextUtilities.isNullText(map.get("401009"))){
    		return true;
    	}
    	//�ً}�����a��3 40��
    	if(!ACTextUtilities.isNullText(map.get("401010"))){
    		return true;
    	}
    	//�ً}�����ÊJ�n�N����1 8��(YYYYMMDD)
    	if(!ACTextUtilities.isNullText(map.get("401011"))){
    		return true;
    	}
    	//�ً}�����ÊJ�n�N����2 8��(YYYYMMDD)
    	if(!ACTextUtilities.isNullText(map.get("401012"))){
    		return true;
    	}
    	//�ً}�����ÊJ�n�N����3 8��(YYYYMMDD)
    	if(!ACTextUtilities.isNullText(map.get("401013"))){
    		return true;
    	}
    	//�E�v1 64��
    	if(!ACTextUtilities.isNullText(map.get("401026"))){
    		return true;
    	}
    	//�E�v2 64��
    	if(!ACTextUtilities.isNullText(map.get("401027"))){
    		return true;
    	}
    	//�E�v3 64��
    	if(!ACTextUtilities.isNullText(map.get("401028"))){
    		return true;
    	}
    	//�E�v4 64��
    	if(!ACTextUtilities.isNullText(map.get("401029"))){
    		return true;
    	}
    	//�E�v5 64��
    	if(!ACTextUtilities.isNullText(map.get("401030"))){
    		return true;
    	}
    	//�E�v6 64��
    	if(!ACTextUtilities.isNullText(map.get("401031"))){
    		return true;
    	}
    	//�E�v7 64��
    	if(!ACTextUtilities.isNullText(map.get("401032"))){
    		return true;
    	}
    	//�E�v8 64��
    	if(!ACTextUtilities.isNullText(map.get("401033"))){
    		return true;
    	}
    	//�E�v9 64��
    	if(!ACTextUtilities.isNullText(map.get("401034"))){
    		return true;
    	}
    	//�E�v10 64��
    	if(!ACTextUtilities.isNullText(map.get("401035"))){
    		return true;
    	}
    	//�E�v11 64��
    	if(!ACTextUtilities.isNullText(map.get("401036"))){
    		return true;
    	}
    	//�E�v12 64��
    	if(!ACTextUtilities.isNullText(map.get("401037"))){
    		return true;
    	}
    	//�E�v13 64��
    	if(!ACTextUtilities.isNullText(map.get("401038"))){
    		return true;
    	}
    	//�E�v14 64��
    	if(!ACTextUtilities.isNullText(map.get("401039"))){
    		return true;
    	}
    	//�E�v15 64��
    	if(!ACTextUtilities.isNullText(map.get("401040"))){
    		return true;
    	}
    	//�E�v16 64��
    	if(!ACTextUtilities.isNullText(map.get("401041"))){
    		return true;
    	}
    	//�E�v17 64��
    	if(!ACTextUtilities.isNullText(map.get("401042"))){
    		return true;
    	}
    	//�E�v18 64��
    	if(!ACTextUtilities.isNullText(map.get("401043"))){
    		return true;
    	}
    	//�E�v19 64��
    	if(!ACTextUtilities.isNullText(map.get("401044"))){
    		return true;
    	}
    	//�E�v20 64��
    	if(!ACTextUtilities.isNullText(map.get("401045"))){
    		return true;
    	}
    	
    	//���y�A�ŕK�{�ȍ��ځ�
    	//���f����2�� - ���f��Ë@�֖�40��
    	if((ACCastUtilities.toInt(map.get("401014"),0) != 0) &&  !ACTextUtilities.isNullText(map.get("401015"))){
    		return true;
    	}
    	//�ʉ@����2�� -�ʉ@��Ë@�֖�40�� 
    	if((ACCastUtilities.toInt(map.get("401016"),0) != 0) &&  !ACTextUtilities.isNullText(map.get("401017"))){
    		return true;
    	}
    	
    	return false;
    }
    // add end 2006.05.20 fujihara.shin
    
    
    /**
     * �ً}�����Ï�񃌃R�[�h�̒l�Ƃ��đÓ��ł��邩���肷��B
     * @param map ���؂��s���f�[�^
     * @return true:�Ó��ł���@false:�Ó��łȂ�
     * @throws Exception
     */
    public static boolean isValidRecordEmergencyOwnFacility(VRMap map) throws Exception {
        
        if(map == null){
            return false;
        }
        
        //���K�{���ځ�
        //���Âꂩ�ЂƂł����͂���Ă����OK
        String[] needsList = new String[]{
                "1701008",        //�ً}�����a��1 40��
                "1701009",        //�ً}�����a��2 40��
                "1701010",        //�ً}�����a��3 40��
                "1701011",        //�ً}�����ÊJ�n�N����1 8��(YYYYMMDD)
                "1701012",        //�ً}�����ÊJ�n�N����2 8��(YYYYMMDD)
                "1701013",        //�ً}�����ÊJ�n�N����3 8��(YYYYMMDD)
                "1701026",        //�E�v1 64��
                "1701027",        //�E�v2 64��
                "1701028",        //�E�v3 64��
                "1701029",        //�E�v4 64��
                "1701030",        //�E�v5 64��
                "1701031",        //�E�v6 64��
                "1701032",        //�E�v7 64��
                "1701033",        //�E�v8 64��
                "1701034",        //�E�v9 64��
                "1701035",        //�E�v10 64��
                "1701036",        //�E�v11 64��
                "1701037",        //�E�v12 64��
                "1701038",        //�E�v13 64��
                "1701039",        //�E�v14 64��
                "1701040",        //�E�v15 64��
                "1701041",        //�E�v16 64��
                "1701042",        //�E�v17 64��
                "1701043",        //�E�v18 64��
                "1701044",        //�E�v19 64��
                "1701045",        //�E�v20 64��
                "1701047",        //���{�ݗ×{��a��1 40��
                "1701048",        //���{�ݗ×{��a��2 40��
                "1701049",        //���{�ݗ×{��a��3 40��
                "1701050",        //���{�ݗ×{��J�n�N����1 8��(YYYYMMDD)
                "1701051",        //���{�ݗ×{��J�n�N����2 8��(YYYYMMDD)
                "1701052"        //���{�ݗ×{��J�n�N����3 8��(YYYYMMDD)
                };
        
        for (String needs : needsList) {
            if(!ACTextUtilities.isNullText(map.get(needs))){
                return true;
            }
        }
        
        //���y�A�ŕK�{�ȍ��ځ�
        //���f����2�� - ���f��Ë@�֖�40��
        if((ACCastUtilities.toInt(map.get("1701014"),0) != 0) &&  !ACTextUtilities.isNullText(map.get("1701015"))){
            return true;
        }
        //�ʉ@����2�� -�ʉ@��Ë@�֖�40�� 
        if((ACCastUtilities.toInt(map.get("1701016"),0) != 0) &&  !ACTextUtilities.isNullText(map.get("1701017"))){
            return true;
        }
        
        return false;
    }
    
    /**
     * �Y���̃T�[�r�X�̑������Ƀ`�F�b�N���t���Ă��邩���肷��B
     * @return
     * @throws Exception
     */
    public static boolean isMultiFloorRoom(VRMap serviceCode) throws Exception {
    	boolean result = false;
    	/*
    	if (serviceDetail.containsKey("1210103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1210103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1220102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1220102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1220119")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1220119"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230113")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230113"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230203")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230203"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230212")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230212"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230303")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230303"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230311")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230311"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230401")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230401"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230411")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230411"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1240102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1240102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1250102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1250102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1260103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1260103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1260203")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1260203"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1260304")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1260304"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1260401")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1260401"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1510102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1510102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1520102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1520102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1530103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1530103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1530203")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1530203"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1530303")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1530303"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1540103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1540103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1590102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1590102"), 0) == 5) {
				result = true;
			}
		}
		*/
    	if (ACCastUtilities.toInt(serviceCode.get("ROOM_TYPE"), 0) == 3) {
    	    result = true;
    	}
    	return result;
    }
    
    /**
     * ���׏�񃌃R�[�h�̃V���A���ԍ��ɕt������l���擾����B
     * @param serviceDetail
     * @param serviceCode
     * @return
     * @throws Exception
     */
    public static String getDetailSerial(VRMap serviceDetail,VRMap serviceCode) throws Exception {
    	
    	String result = "";
    	
        // �T�[�r�X��ރR�[�h
        String serviceCodeKind = ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode),"");
        //�V�X�e�����T�[�r�X���ڃR�[�h
        String systemServiceCodeItem = ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM", serviceCode),"");
        
        //�����p��̓K�p�ݒ�
        if("17".equals(serviceCodeKind) || "67".equals(serviceCodeKind)){
	        if(serviceDetail.containsKey("1170104")){
	            //�V�X�e�����T�[�r�X��ރR�[�h��2����n�܂��Ă���ꍇ�́A
	            //���ʒn����Z�̃��R�[�h
	        	//[ID:0000447][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
	            //if(!systemServiceCodeItem.startsWith("2")){
	        	//���f���ύX
	        	//�T�[�r�X���ڃR�[�h��8�Ŏn�܂��Ă���΁A���ʒn��E���R�Ԃ̉��Z
	        	//if(!systemServiceCodeItem.startsWith("2")){
	        	String serviceCodeItem = ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_ITEM", serviceCode),"");
	        	if(!serviceCodeItem.startsWith("8")){
	            //[ID:0000447][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
	                //��ʏ�̕����p��E�v���ɓ��͂�����ꍇ
	                if(!ACTextUtilities.isNullText(serviceDetail.get("1170104"))){
	                    //�E�v���ɕ����p��̓E�v���ɓ��͂��ꂽ�l����͂���B
	                	result = String.valueOf(DETAIL_SERIAL++);
	                }
	            }
	        }
        }
        
        /*
         * ������{�ݓ����Ґ������A���\�h����{�ݓ����Ґ������
         * �E�O���T�[�r�X���p�^�ɂ����镟���p��ݗ^�A���\�h�����p��ݗ^
         * �y�v���O�������̉��߁z
         * ��ʏ�ɓ��͂��ꂽ�l���Q��
         * 
         * ���������Ӂ�����
         * �V�X�e�����T�[�r�X��ރR�[�h���g�p���āA���肵�Ă��܂��B
         */
        //�T�[�r�X��ރR�[�h��33�ł���
        if("33".equals(serviceCodeKind)){
            //�V�X�e�����T�[�r�X��ރR�[�h��27����n�܂�
            if(systemServiceCodeItem.startsWith("27")){
                //�E�v���ɓ��͂���Ă��鍀�ڂ�����ꍇ
                if(serviceDetail.containsKey("1330120")){
                    //�E�v���ɊO�����p�����p��̓E�v���ɓ��͂��ꂽ�l��ݒ肷��B
                	result = String.valueOf(DETAIL_SERIAL++);
                }
            }
        }
        
        //���������Ӂ�����
        //�V�X�e�����T�[�r�X��ރR�[�h���g�p���āA���肵�Ă��܂��B
        
        //�T�[�r�X��ރR�[�h��35�ł���
        if("35".equals(serviceCodeKind)){
            //�V�X�e�����T�[�r�X��ރR�[�h��27����n�܂�
            if(systemServiceCodeItem.startsWith("27")){
                //�E�v���ɓ��͂���Ă��鍀�ڂ�����ꍇ
                if(serviceDetail.containsKey("1170104")){
                    //�E�v���ɊO�����p�����p��̓E�v���ɓ��͂��ꂽ�l��ݒ肷��B
                	result = String.valueOf(DETAIL_SERIAL++);
                }
            }
        }
        
        return result;
    }
    
    /**
     * �l�����̓�ɂ����āA�\�h�K����P�Ɨ\�h�K����P�E�R�����T�[�r�X�ɓo�^����Ă���<br>
     * �ꍇ�A�\�h�K����P�E�R���̂ݐ������s�Ȃ��B<br>
     * ���\�h�K��Ō�T�[�r�X�i�����������j�ł���΁Atrue��ԋp����B
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isArrangementData(String serviceCodeKind, String serviceCodeItem) throws Exception {
    	boolean result = false;
    	int kind = ACCastUtilities.toInt(serviceCodeKind,0);
    	int item = ACCastUtilities.toInt(serviceCodeItem,0);
    	
		//�T�[�r�X��ރR�[�h�̊m�F
		if(kind == 61){
			switch(item){
			//�\�h�K����P
			case 1111:
			//�\�h�K����P�E�R��
			case 1112:
			//�\�h�K����Q
			case 1211:
			//�\�h�K����Q�E�R��
			case 1212:
			//�\�h�K����R
			case 1321:
			//�\�h�K����R�E�R��
			case 1322:
				result = true;
				break;
			}
		}
		return result;
    }
    
    //[ID:0000529][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
    /**
     * �Ώۂ̃T�[�r�X���������Ƃ��Čv�シ�ׂ������肷��
     * @param serviceDetail
     * @param serviceCode
     * @return
     * @throws Exception
     */
    //[ID:0000586][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
    //public static boolean isRealDay(VRMap serviceDetail) throws Exception {
    public static boolean isRealDay(VRMap serviceDetail, VRMap serviceCode) throws Exception {
    //[ID:0000586][Shin Fujihara] 2010/01 edit end 2009�N�x�Ή�
    	if (serviceDetail.containsKey("DUMMY")) {
    		return false;
    	}
    	
    	// �{�[�Ɉ󎚂���̃L�[���Ȃ��ꍇ�̓T�[�r�X�񋟃f�[�^�Ƃ��Ĉ���
    	// �\�h��������Ґ������݈̂قȂ�o�C���h�p�X
    	String[] checkBindPath = { "15", "1350129", "1350130", "1350131" };

    	for (int i = 0; i < checkBindPath.length; i++) {
    	    // �{�[�Ɉ󎚂���`�F�b�N�����݂���ꍇ
    	    if (ACCastUtilities.toInt(serviceDetail.getData(checkBindPath[i]), 0) == 1) {
    	        // �`�F�b�N���Ȃ��ꍇ�̂ݒ񋟓��ȊO�̃f�[�^�Ƃ���
    	        return false;
    	    }
    	}
    	
    	//[ID:0000586][Shin Fujihara] 2010/01 add begin 2009�N�x�Ή�
    	String systemServiceKindDetail = ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", serviceCode),"");
    	//���K�͑��@�\�^������A�܂��͗\�h���K�͑��@�\�^������ł���ꍇ
    	if ("17311".equals(systemServiceKindDetail) || "17511".equals(systemServiceKindDetail)) {
    		//�������Z�����Z�݂̂ŎZ�肳��Ă���ꍇ�́A�������Ƃ��Čv�サ�Ȃ�
    		if (serviceDetail.containsKey("9")) {
    			if (ACCastUtilities.toInt(serviceDetail.get("9"), 0) == 2) {
    				return false;
    			}
    		}
    	}
    	//[ID:0000586][Shin Fujihara] 2010/01 add end 2009�N�x�Ή�
    	
    	return true;
    }
    //[ID:0000529][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
    
    //[ID:0000720][Shin Fujihara] 2012/04 add start 2012�N�x�Ή�
    // QP001RecordDetail�̏������ړ�
    /**
     * �T�[�r�X�̒񋟉񐔂��擾����(�Ŏ��Ō�Ή�)
     * @param serviceCodeKind �T�[�r�X��ރR�[�h
     * @param serviceCodeItem �T�[�r�X���ڃR�[�h
     * @param serviceDetail �T�[�r�X�ڍ�
     * @return �񋟉�
     * @throws Exception
     */
    public static int getServiceCount(String serviceCodeKind, String serviceCodeItem, VRMap serviceDetail) throws Exception {
        
        int count = 1;
        
        
        //�F�m�ǑΉ��^�����������i�Z�����p�ȊO�j
        if ("32".equals(serviceCodeKind)) {
            
            //6142:�F�m�ǑΉ��^�Ŏ��Ō���Z�P 6143:�F�m�ǑΉ��^�Ŏ��Ō���Z�Q
            if("6142".equals(serviceCodeItem) || "6143".equals(serviceCodeItem)){
                count = ACCastUtilities.toInt(serviceDetail.get("1320115"),1);
            }
            
        
        //��앟���{��
        } else if ("51".equals(serviceCodeKind)) {
            
            //6276:�����{�݊Ŏ������Z�P 6277:�����{�݊Ŏ������Z�Q
            if("6276".equals(serviceCodeItem) || "6277".equals(serviceCodeItem)){
                count = ACCastUtilities.toInt(serviceDetail.get("1510132"),1);
            }
            
            
        //���ی��{��
        } else if ("52".equals(serviceCodeKind)) {
            
            //6600:�ی��{�݃^�[�~�i���P�A���Z�P�P 6001:�ی��{�݃^�[�~�i���P�A���Z�P�Q
            //6602:�ی��{�݃^�[�~�i���P�A���Z�Q�P 6002:�ی��{�݃^�[�~�i���P�A���Z�Q�Q
            if ("6600".equals(serviceCodeItem)
                || "6001".equals(serviceCodeItem)
                || "6602".equals(serviceCodeItem)
                || "6002".equals(serviceCodeItem)){
                count = ACCastUtilities.toInt(serviceDetail.get("1520150"),1);
            }
            
            
        //�n�斧���^��앟���{��
        } else if ("54".equals(serviceCodeKind)) {
            
            //6276:�n�����{�݊Ŏ������Z�P 6277:�n�����{�݊Ŏ������Z�Q
            if("6276".equals(serviceCodeItem) || "6277".equals(serviceCodeItem)){
                count = ACCastUtilities.toInt(serviceDetail.get("1540128"),1);
            }
        }
        
        return count;
    }
    //[ID:0000720][Shin Fujihara] 2012/04 add end 2012�N�x�Ή�
    
    //[ID:0000720][Shin Fujihara] 2012/04 add start 2012�N�x�Ή�
    /**
     * �Ŏ��Ō�E�^�[�~�i���P�A���Z�Ŏ��S��������킷�R�[�h�ł��邩
     * @param serviceCodeKind �T�[�r�X��ރR�[�h
     * @param serviceCodeItem �T�[�r�X���ڃR�[�h
     * @return true:���S���̉��Z false:�ʏ�̃T�[�r�X�R�[�h
     * @throws Exception
     */
    public static boolean isMitori(String serviceCodeKind, String serviceCodeItem) throws Exception {
        
        //�K��Ō�
        if ("13".equals(serviceCodeKind)) {
            //�K��Ō�^�[�~�i���P�A���Z
            if ("7000".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //�����{��
        if ("51".equals(serviceCodeKind)) {
            //�����{�݊Ŏ������Z�R
            if ("6283".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //�n�����{
        if ("54".equals(serviceCodeKind)) {
            //�n�����{�݊Ŏ������Z�R
            if ("6283".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //�ی��{��
        if ("52".equals(serviceCodeKind)) {
            //�ی��{�݃^�[�~�i���P�A���Z�R�P�A�ی��{�݃^�[�~�i���P�A���Z�R�Q
            if ("6603".equals(serviceCodeItem)
             || "6003".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //�F�m�ǑΉ��^
        if ("32".equals(serviceCodeKind)) {
            //�F�m�ǑΉ��^�Ŏ������Z�R
            if ("6144".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //����{��
        if ("33".equals(serviceCodeKind)) {
            //����{�݊Ŏ������Z�R
            if ("6127".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //�n�����{��
        if ("36".equals(serviceCodeKind)) {
            //�n�����{�݊Ŏ������Z�R
            if ("6127".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //�������
        if ("76".equals(serviceCodeKind)) {
            //�������^�[�~�i���P�A���Z
            if ("6100".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //�����^
        if ("77".equals(serviceCodeKind)) {
            //�����^�^�[�~�i���P�A���Z
            if ("6100".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        return false;
    }
    //[ID:0000720][Shin Fujihara] 2012/04 add end 2012�N�x�Ή�
    
}
