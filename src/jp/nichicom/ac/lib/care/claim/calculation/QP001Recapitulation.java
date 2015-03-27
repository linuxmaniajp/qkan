
/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKAACHO�iJMA care benefit management software�j
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
 * �쐬��: 2005/12/06  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���ъm��/�������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� �E�v�����䃂�W���[�� (QP001Recapitulation)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �E�v���o�͕�����쐬�N���X
 *
 */
public class QP001Recapitulation {
    
    /**
     * �E�v���ɏo�͂��镶����
     */
    private String tekiyo = null;
    /**
     * ������
     */
    private String reductRate = null;
    /**
     * �T�[�r�X��ރR�[�h
     */
    private String serviceCodeKind = null;
    /**
     * �T�[�r�X���ڃR�[�h
     */
    private String serviceCodeItem = null;
    /**
     * �V�X�e�����T�[�r�X��ރR�[�h
     */
    private String systemServiceKindDetail = null;
    /**
     * �V�X�e�����T�[�r�X���ڃR�[�h
     */
    private String systemServiceCodeItem = null;
    
    /**
     * �������Ƀ`�F�b�N���t���Ă��邩�̃t���O
     */
    private boolean multiFloorFoom = false;
    
    /**
     * �{�̕�V�t���O(0:�{�̕�V�ȊO�A1:�{�̕�V)
     */
    private int serviceMainFlag = 0;
    
    /**
     * �E�v�L�ڎ����̉�͂��s��
     * @param serviceDetail
     * @param serviceCode
     * @throws Exception
     */
    public void setRecapitulation(VRMap serviceDetail, VRMap serviceCode,QP001Manager manager) throws Exception {
        
        Date target = ACCastUtilities.toDate(VRBindPathParser.get("SERVICE_DATE",serviceDetail));
        // ���Ə��ԍ����擾����B
        String providerId = ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID", serviceDetail),"");
        // �T�[�r�X��ރR�[�h
        serviceCodeKind = ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode),"");
        // �T�[�r�X���ڃR�[�h
        serviceCodeItem = ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_ITEM", serviceCode),"");
        //�V�X�e�����T�[�r�X��ރR�[�h
        systemServiceKindDetail = ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", serviceCode),"");
        //�V�X�e�����T�[�r�X���ڃR�[�h
        systemServiceCodeItem = ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM", serviceCode),"");
        //�������t���O
        //multiFloorFoom = QP001SpecialCase.isMultiFloorRoom(serviceDetail);
        multiFloorFoom = QP001SpecialCase.isMultiFloorRoom(serviceCode);
        //�{�̕�V�ł��邩�̃t���O
        serviceMainFlag = ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_MAIN_FLAG",serviceDetail), 0);
        
        if(tekiyo != null){
            return;
        }
        
        //[ID:0000721][Shin Fujihara] 2012/04 add start 2012�N�x�Ή�
        //�Ŏ��E�^�[�~�i���񋟎��͓E�v���ɓ��t��o�^
        //��2012�N4���̖@�������A�e���ɓ_�݂��Ă����������ꌳ��
        if (QP001SpecialCase.isMitori(serviceCodeKind, serviceCodeItem)) {
            tekiyo = String.valueOf(VRDateParser.format(target,"yyyyMMdd"));
        }
        //[ID:0000721][Shin Fujihara] 2012/04 add end 2012�N�x�Ή�
        
        
        /*
         * ���K����
         * �E�g�̉��S���Ԉȏ�̏ꍇ
         * �v���̏��v�P�ʂ𕪒P�ʂŋL�ڂ��邱�ƁB
         * �� 260��
         * �P�ʂ��ȗ����邱�Ƃ��B
         * �� 260
         * �y���l�z
         * �g�̉��S���Ԉُ�ɂ��ẮA�P�񂠂���̓_���̍��������v���ԂɂĎ������ƁB
         * �y�v���O�������̉��߁z
         *         �T�[�r�X��ރR�[�h��'11'
         *         ����
         *         SYSTEM_SERVICE_CODE_ITEM
         *         ��2�Ԗڂ̕�����9�ȏ�̂��̂��ΏہB
         */
        //�T�[�r�X��ރR�[�h��11
        if("11".equals(serviceCodeKind)){
            //�V�X�e���T�[�r�X��ރR�[�h��2�Ԗڂ̕�����9�ȏ�̂���
            if(systemServiceCodeItem.length() > 2){
                switch(systemServiceCodeItem.toCharArray()[1]){
                //4���Ԉȏ�4���Ԕ�����
                case '9':
//                    tekiyo = "240";
//                    break;
                //4���Ԕ��ȏ�5���Ԗ���
                case 'A':
//                    tekiyo = "270";
//                    break;
                //5���Ԉȏ�5���Ԕ�����
                case 'B':
//                    tekiyo = "300";
//                    break;
                //5���Ԕ��ȏ�6���Ԗ���
                case 'C':
//                    tekiyo = "330";
//                    break;
                //6���Ԉȏ�6���Ԕ�����
                case 'D':
//                    tekiyo = "360";
//                    break;
                //6���Ԕ��ȏ�7���Ԗ���
                case 'E':
//                    tekiyo = "390";
//                    break;
                //7���Ԉȏ�7���Ԕ�����
                case 'F':
//                    tekiyo = "420";
//                    break;
                //7���Ԕ��ȏ�8���Ԗ���
                case 'G':
//                    tekiyo = "450";
//                    break;
                //8���Ԉȏ�8���Ԕ�����
                case 'H':
//                    tekiyo = "480";
//                    break;
                //8���Ԕ��ȏ�9���Ԗ���
                case 'I':
//                    tekiyo = "510";
//                    break;
                //9���Ԉȏ�9���Ԕ�����
                case 'J':
//                    tekiyo = "540";
//                    break;
                //9���Ԕ��ȏ�10���Ԗ���
                case 'K':
//                    tekiyo = "570";
//                    break;
                //10���Ԉȏ�10���Ԕ�����
                case 'L':
//                    tekiyo = "600";
//                    break;
                //10���Ԕ��ȏ�11���Ԗ���
                case 'M':
//                    tekiyo = "630";
//                    break;
                //11���Ԉȏ�11���Ԕ�����
                case 'N':
//                    tekiyo = "660";
//                    break;
                //11���Ԕ��ȏ�12���Ԗ���
                case 'O':
//                    tekiyo = "690";
//                    break;
                //12���Ԉȏ�12���Ԕ�����
                case 'P':
//                    tekiyo = "720";
//                    break;
                //12���Ԕ��ȏ�13���Ԗ���
                case 'Q':
//                    tekiyo = "750";
//                    break;
                //13���Ԉȏ�13���Ԕ�����
                case 'R':
//                    tekiyo = "780";
//                    break;
                //13���Ԕ��ȏ�14���Ԗ���
                case 'S':
//                    tekiyo = "810";
//                    break;
                //14���Ԉȏ�14���Ԕ�����
                case 'T':
//                    tekiyo = "840";
//                    break;
                //14���Ԕ��ȏ�15���Ԗ���
                case 'U':
//                    tekiyo = "870";
//                    break;
                //15���Ԉȏ�15���Ԕ�����
                case 'V':
//                    tekiyo = "900";
//                    break;
                //15���Ԕ��ȏ�16���Ԗ���
                case 'W':
//                    tekiyo = "930";
//                    break;
                //16���Ԉȏ�16���Ԕ�����
                case 'X':
//                    tekiyo = "960";
//                    break;
                //16���Ԕ��ȏ�17���Ԗ���
                case 'Y':
//                    tekiyo = "990";
//                    break;
                //17���Ԉȏ�17���Ԕ�����
                case 'Z':
//                    tekiyo = "1020";
//                    break;
                //17���Ԕ��ȏ�18���Ԗ���
                case 'a':
//                    tekiyo = "1050";
//                    break;
                //18���Ԉȏ�18���Ԕ�����
                case 'b':
//                    tekiyo = "1080";
//                    break;
                //18���Ԕ��ȏ�19���Ԗ���
                case 'c':
//                    tekiyo = "1110";
//                    break;
                //19���Ԉȏ�19���Ԕ�����
                case 'd':
//                    tekiyo = "1140";
//                    break;
                //19���Ԕ��ȏ�20���Ԗ���
                case 'e':
//                    tekiyo = "1170";
//                    break;
                //20���Ԉȏ�20���Ԕ�����
                case 'f':
//                    tekiyo = "1200";
//                    break;
                //20���Ԕ��ȏ�21���Ԗ���
                case 'g':
//                    tekiyo = "1230";
//                    break;
                //21���Ԉȏ�21���Ԕ�����
                case 'h':
//                    tekiyo = "1260";
//                    break;
                //21���Ԕ��ȏ�22���Ԗ���
                case 'i':
//                    tekiyo = "1290";
//                    break;
                //22���Ԉȏ�22���Ԕ�����
                case 'j':
//                    tekiyo = "1320";
//                    break;
                //22���Ԕ��ȏ�23���Ԗ���
                case 'k':
//                    tekiyo = "1350";
//                    break;
                //23���Ԉȏ�23���Ԕ�����
                case 'l':
//                    tekiyo = "1380";
//                    break;
                //23���Ԕ��ȏ�24���Ԗ���
                case 'm':
//                    tekiyo = "1410";
//                    break;
                    Date start = ACCastUtilities.toDate(serviceDetail.get("3"),null);
                    Date end = ACCastUtilities.toDate(serviceDetail.get("4"),null);
                    
                    if((start != null) && (end != null)){
                        int startTime = ACDateUtilities.getHourOfDay(start) * 60 + ACDateUtilities.getMinute(start);
                        int endTime = ACDateUtilities.getHourOfDay(end) * 60 + ACDateUtilities.getMinute(end);
                        if(startTime >= endTime){
                            //���Ԃ��t�]���Ă���ꍇ�́A�I�����Ԃ�����i�߂�
                            endTime += 24 * 60;
                        }
                        int outPutTime = endTime - startTime;
                        //�o�͂���l��4���Ԃ��z���Ă��邩�m�F����B
                        if(4 * 60 <= outPutTime){
                            tekiyo = String.valueOf(outPutTime);
                        }
                    }
                    break;
                }
            }
        }
        
        
        //�K��Ō�
        if ("13".equals(serviceCodeKind)) {
            //�މ@�������w�����Z
            if ("4003".equals(serviceCodeItem)) {
                //[ID:0000737][Shin Fujihara] 2012/05/07 edit begin ����24�N4���@�����Ή�
                //�E�v���̋L�ڂ�N�������猎���ɕύX
                //tekiyo = String.valueOf(VRDateParser.format(target,"yyyyMMdd"));
                tekiyo = String.valueOf(VRDateParser.format(target,"MMdd"));
                //[ID:0000737][Shin Fujihara] 2012/05/07 edit end
            }
        }
        
        
        //�����p��̓K�p�ݒ�
        if("17".equals(serviceCodeKind) || "67".equals(serviceCodeKind)){
	        if(serviceDetail.containsKey("1170104")){
	            
	            
	            //�V�X�e�����T�[�r�X��ރR�[�h��2����n�܂��Ă���ꍇ�́A
	            //���ʒn����Z�̃��R�[�h
	        	//[ID:0000447][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
	            //if(systemServiceCodeItem.startsWith("2")){
	        	//���f���ύX
	        	//�T�[�r�X���ڃR�[�h��8�Ŏn�܂��Ă���ꍇ�́A���ʒn��E���R��
	        	if(serviceCodeItem.startsWith("8")){
	            //[ID:0000447][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
	                /*
	                 * �������p��
	                 * �E���ʒn����Z���Z�肷��ꍇ
	                 * ���ʒn����Z���Z�肷��ꍇ�����p��ݗ^���J�n�������t���L�ڂ��邱�ƁB
	                 * ��@6��
	                 * �P�ʂ��ȗ����邱�Ƃ��B
	                 * ��@6
	                 * �y�v���O�������̉��߁z
	                 * �T�[�r�X�R�[�h�̓��ʒn����Z�𒼐ڎQ��
	                 */
	                tekiyo = String.valueOf(ACDateUtilities.getDayOfMonth(target));
	            } else {
	                //��ʏ�̕����p��E�v���ɓ��͂�����ꍇ
	                if(!ACTextUtilities.isNullText(serviceDetail.get("1170104"))){
	                    //�E�v���ɕ����p��̓E�v���ɓ��͂��ꂽ�l����͂���B
	                    tekiyo = ACCastUtilities.toString(serviceDetail.get("1170104"));
	                }
	            }
	        }
        }
        
        /*
         * ������{�ݓ����Ґ������A���\�h����{�ݓ����Ґ������
         * �E�O���T�[�r�X���p�^�ɂ����镟���p��ݗ^�A���\�h�����p��ݗ^
         * �y�v���O�������̉��߁z
         * ��ʏ�ɓ��͂��ꂽ�l���Q��
         */
        //�T�[�r�X��ރR�[�h��33�ł���
        if("33".equals(serviceCodeKind)){
            //�V�X�e�����T�[�r�X��ރR�[�h��27����n�܂�
            if(systemServiceCodeItem.startsWith("27")){
                //�E�v���ɓ��͂���Ă��鍀�ڂ�����ꍇ
                if(serviceDetail.containsKey("1330120")){
                    //�E�v���ɊO�����p�����p��̓E�v���ɓ��͂��ꂽ�l��ݒ肷��B
                    tekiyo = ACCastUtilities.toString(serviceDetail.get("1330120"));
                }
            }
        }
        
        //�T�[�r�X��ރR�[�h��35�ł���
        if("35".equals(serviceCodeKind)){
            //�V�X�e�����T�[�r�X��ރR�[�h��27����n�܂�
            if(systemServiceCodeItem.startsWith("27")){
                //�E�v���ɓ��͂���Ă��鍀�ڂ�����ꍇ
                if(serviceDetail.containsKey("1170104")){
                    //�E�v���ɊO�����p�����p��̓E�v���ɓ��͂��ꂽ�l��ݒ肷��B
                    tekiyo = ACCastUtilities.toString(serviceDetail.get("1170104"));
                }
            }
        }
        
        //[ID:0000737][Shin Fujihara] 2012/05/07 add begin ����24�N4���@�����Ή�
        //���ی��{��
        if ("52".equals(serviceCodeKind)) {
            //�ی��{�ݒn��A�g�f�Ìv����Z�P�A�ی��{�ݒn��A�g�f�Ìv����Z�Q
            if ("6136".equals(serviceCodeItem)
             || "6137".equals(serviceCodeItem)) {
                tekiyo = String.valueOf(VRDateParser.format(target,"yyyyMMdd"));
            }
        }
        
        //�\�h�K��Ō�
        if ("63".equals(serviceCodeKind)) {
            //�\�h�K��Ō�މ@�������w�����Z
            if ("4003".equals(serviceCodeItem)) {
                tekiyo = String.valueOf(VRDateParser.format(target,"MMdd"));
            }
        }
        //[ID:0000737][Shin Fujihara] 2012/05/07 add end
        
        /*
         * ����앟���{�݃T�[�r�X�A�n�斧�����V�l�����{�݃T�[�r�X
         * �E�ޏ��O��K�⑊�k�������Z
         * �ƒ듙�ւ̖K������L�ڂ��邱��
         * ��@20��
         * �P�ʂ��ȗ����邱�Ƃ��B
         * ��@20
         * �y�v���O�������̉��߁z
         * SYSTEM_SERVICE_CODE_ITEM��
         * 'Z6501'�̂��̂��v��
         * 
         * �����ی��{�݃T�[�r�X
         * �E�ޏ��O��K�⑊�k�������Z
         * �ƒ듙�ւ̖K������L�ڂ��邱��
         * ��@20��
         * �P�ʂ��ȗ����邱�Ƃ��B
         * ��@20
         * �y�v���O�������̉��߁z
         * SYSTEM_SERVICE_CODE_ITEM��
         * 'Z6501'�̂��̂��v��
         */
        //[ID:0000584][Shin Fujihara] 2010/01 del begin 2009�N�x�Ή�
        /*
        if("Z6501".equals(systemServiceCodeItem)){
            tekiyo = String.valueOf(ACDateUtilities.getDayOfMonth(target));
        }
        */
        //[ID:0000584][Shin Fujihara] 2010/01 del end 2009�N�x�Ή�
        
        /*
         * �����×{�{�݃T�[�r�X
         * �E�މ@�O��K��w�����Z
         * �ƒ듙�ւ̖K������L�ڂ��邱��
         * ��@20��
         * �P�ʂ��ȗ����邱�Ƃ��B
         * ��@20
         * �y�v���O�������̉��߁z
         * SYSTEM_SERVICE_CODE_ITEM��
         * 'Z2851'
         * 'Z3851'
         * 'Z4851'
         * �̂��̂��v��
         */
        //[ID:0000584][Shin Fujihara] 2010/01 del begin 2009�N�x�Ή�
        /*
        if("Z2851".equals(systemServiceCodeItem)
           || "Z3851".equals(systemServiceCodeItem)
           || "Z4851".equals(systemServiceCodeItem)){
            tekiyo = String.valueOf(ACDateUtilities.getDayOfMonth(target));
        }
        */
        //[ID:0000584][Shin Fujihara] 2010/01 del end 2009�N�x�Ή�
        
        /* 
         * 2008/01/07 [Masahiko Higuchi] add - begin ���K�͑��@�\�̓E�v���Ή�
         * 1730105
         */
        //�T�[�r�X��ރR�[�h��73(���K�͑��@�\)�ł���
        if("73".equals(serviceCodeKind)){
            // �{�̕�V�̃��R�[�h�ɓE�v�����L��
            if (serviceMainFlag == 1) {
                // ���t���������o��
                String detailValue = ACCastUtilities.toString(serviceDetail.getData("1730105"),"000000");
                // 0��6���̏ꍇ�͖�������
                if(!"000000".equals(detailValue)){
                    tekiyo = detailValue;
                }
            }
            
            //[ID:0000447][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
            if (tekiyo == null){
            	if (ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_ADD_FLAG", serviceCode), 0) == 1) {
                    // ���t���������o��
                    String detailValue = ACCastUtilities.toString(serviceDetail.getData("1730105"),"000000");
                    // 0��6���̏ꍇ�͖�������
                    if(!"000000".equals(detailValue)){
                        tekiyo = detailValue;
                    }
            	}
            }
            //[ID:0000447][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
        }
        
        //�T�[�r�X��ރR�[�h��75(�\�h���K�͑��@�\)�ł���
        if("75".equals(serviceCodeKind)){
            
            // �{�̕�V�̃��R�[�h�ɓE�v�����L��
            if (serviceMainFlag == 1) {
                // ���t���������o��
                String detailValue = ACCastUtilities.toString(serviceDetail.getData("1750105"),"000000");
                // 0��6���̏ꍇ�͖�������
                if(!"000000".equals(detailValue)){
                    tekiyo = detailValue;
                }
            }
            
            //[ID:0000447][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
            if (tekiyo == null){
            	if (ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_ADD_FLAG", serviceCode), 0) == 1) {
                    // ���t���������o��
                    String detailValue = ACCastUtilities.toString(serviceDetail.getData("1750105"),"000000");
                    // 0��6���̏ꍇ�͖�������
                    if(!"000000".equals(detailValue)){
                        tekiyo = detailValue;
                    }
            	}
            }
            //[ID:0000447][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
        }
        // 2008/01/07 [Masahiko Higuchi] add - end
        
        
        //[ID:0000737][Shin Fujihara] 2012/05/07 add begin ����24�N4���@�����Ή�
        //�������E�����Ή�
        if ("76".equals(serviceCodeKind)) {
            //�މ@�������w�����Z
            if ("4003".equals(serviceCodeItem)) {
                tekiyo = String.valueOf(VRDateParser.format(target,"MMdd"));
            }
        }
        //[ID:0000737][Shin Fujihara] 2012/05/07 add end
        
        // �T�[�r�X��ރR�[�h��77(�����^)�ł���
        if("77".equals(serviceCodeKind)){
            
            // �{�̕�V�̃��R�[�h�ɓE�v�����L��
            if (serviceMainFlag == 1) {
                // ���t���������o��
                String detailValue = ACCastUtilities.toString(serviceDetail.getData("1770117"),"00000000");
                // 0��8���̏ꍇ�͖�������
                if(!"00000000".equals(detailValue)){
                    tekiyo = detailValue;
                }
            }
            
            // ���Z�̂ݎZ��̗�O�����H�@���K�͑��@�\�Ǝd�l�����낦�Ă���
            if (tekiyo == null){
                if (ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_ADD_FLAG", serviceCode), 0) == 1) {
                    // ���t���������o��
                    String detailValue = ACCastUtilities.toString(serviceDetail.getData("1770117"),"00000000");
                    // 0��8���̏ꍇ�͖�������
                    if(!"00000000".equals(detailValue)){
                        tekiyo = detailValue;
                    }
                }
            }
            
            //[ID:0000737][Shin Fujihara] 2012/05/07 editbegin ����24�N4���@�����Ή�
            //�����^�މ@�������w�����Z
            if ("4003".equals(serviceCodeItem)) {
                tekiyo = String.valueOf(VRDateParser.format(target,"MMdd"));
            }
            //[ID:0000737][Shin Fujihara] 2012/05/07 edit end
            
        }
        
        
        //�Y���T�[�r�X�̊��������擾
        //int rate = QP001Manager.getInstance().getReductRate(providerId,serviceCode);
        int rate = manager.getReductRate(providerId,serviceCode);
        //�����������݂���ꍇ
        if(rate != 0){
            //�������Ɏ擾�����l��ݒ肷��B
            reductRate = String.valueOf(rate) + "%";
        }
    }
    
    /**
     * �E�v�L�ڎ������擾����B
     * @param realDays �T�[�r�X���������X�g
     * @return �쐬�����E�v���L�ڍ���
     * @throws Exception
     */
    public String getRecapitulation(VRList realDays	,QP001PatientState patientState) throws Exception {
        String result = "";
        
        
        /*
         * ���K�⃊�n�r���e�[�V�����A���\�h�K�⃊�n�r���e�[�V����
         * �E�Z���W�����n�r���e�[�V�������{���Z���Z�肷��ꍇ
         * �a�@�Ⴕ���͐f�Ï��܂��͉��ی��{�݂���މ@�E�ޏ������N�������͗v���E�v�x���F���
         * �󂯂������L�ڂ��邱�ƁB
         * ��@20060501
         * �i�މ@�i���j����2006�N5��1���̏ꍇ�j
         * �y�v���O�������̉��߁z
         * �T�[�r�X�R�[�h
         * 145001�A145002
         * �̂��̂��v��
         */
        //�O���̐����̓E�v���ɋL�ڂ�����ꍇ�ɂ́A������̗p����B
        if("14".equals(serviceCodeKind)){
            if("5001".equals(serviceCodeItem) || "5002".equals(serviceCodeItem)){
            	result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
            }
        }
        if("64".equals(serviceCodeKind)){
        	if("5001".equals(serviceCodeItem)){
        		result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
        	}
        }
        
        
        /*
         * ���ʏ����n�r���e�[�V����
         * �E�Z���W�����n�r���e�[�V�������{���Z���Z�肷��ꍇ
         * �a�@�Ⴕ���͐f�Ï��܂��͉��ی��{�݂���މ@�E�ޏ������N�������͗v���E�v�x���F���
         * �󂯂������L�ڂ��邱�ƁB
         * ��@20060501
         * �i�މ@�i���j����2006�N5��1���̏ꍇ�j
         * �y�v���O�������̉��߁z
         * �T�[�r�X�R�[�h��
         * 165602
         * 165603
         * 165604
         * �̂��̂��v��
         * �E�d�x�×{�Ǘ����Z���Z�肷��ꍇ
         * 165610
         */
        //�O���̐����̓E�v���ɋL�ڂ�����ꍇ�ɂ́A������̗p����B
        if("16".equals(serviceCodeKind)){
            //[CCCX:1616,2096][Shinobu Hitaka] 2014/11/25 add �u5610�F�d�x�×{�Ǘ����Z�v��ǉ�
            //if("5602".equals(serviceCodeItem) || "5603".equals(serviceCodeItem) || "5604".equals(serviceCodeItem)){
            // [H27.4�����Ή�][Shinobu Hitaka] 2015/2/27 edit - begin �p�~���ǉ��R�[�h�Ή�
            //if("5602".equals(serviceCodeItem) || "5603".equals(serviceCodeItem) || "5604".equals(serviceCodeItem) || "5610".equals(serviceCodeItem)){
            if("5613".equals(serviceCodeItem) || "5610".equals(serviceCodeItem)){
            	result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
            }
        }
        
        //[CCCX:1616,2096][Shinobu Hitaka] 2014/11/25 add begin �u6278�F�d�x�×{�Ǘ����Z1�A6279�F�d�x�×{�Ǘ����Z2�v��ǉ�
        /*
         * ���Z�������×{���i�V���j
         * �E�d�x�×{�Ǘ����Z���Z�肷��ꍇ
         * 
         * ���p�ҁi�v���S���͗v���T�j�̏�ԁi�C���烊�܂Łj���L�ڂ��邱�ƁB
         */
        //�O���̐����̓E�v���ɋL�ڂ�����ꍇ�ɂ́A������̗p����B
        if("22".equals(serviceCodeKind)){
        	if("6278".equals(serviceCodeItem) || "6279".equals(serviceCodeItem)){
        		//�d�x�×{�Ǘ����Z�P�A�d�x�×{�Ǘ����Z�Q
        		result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
        	}
        }
        //[CCCX:1616,2096][Shinobu Hitaka] 2014/11/25 add end   �u6278�F�d�x�×{�Ǘ����Z1�A6279�F�d�x�×{�Ǘ����Z2�v��ǉ�
        
        /*
         * ���Z�������������
         * �@�\�h�Z�������������
         * �@�Z�������×{���
         * �@�\�h�Z�������×{���
         * �@��앟���{��
         * �@�n�斧����앟���{��
         * �@���ی��{��
         * �@���×{�{��
         * 
         * �������̃T�[�r�X�R�[�h�̓K�p���R
         * �K�p���R�̔ԍ���E�v���ɍ��l�ŋL�ڂ��邱�ƁB
         * �P�@����������
         * �R�@�����Ǔ��ɂ���t���K�v�Ɣ��f�����]���^���ւ̓�����
         * �S�@���Z�ʐς����ȉ�
         * �T�@���������_�Ǐ󓙂ɂ���t���K�v�Ɣ��f�����]���^���ւ̓�����
         */
        //�O���̐����̓E�v���ɋL�ڂ�����ꍇ�ɂ́A������̗p����B
        if(multiFloorFoom){
        	result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
        }
        
        
        /*
         * �����ی��{��
         * �E�Z���W�����n�r���e�[�V�������{���Z�A�F�m�ǒZ���W�����n�r���e�[�V�������{���Z���Z�肷��ꍇ
         * 
         * ���Y�{�݂ɓ������������L�ڂ��邱�ƁB
         * ��@20060501
         * �i��������2006�N5��1���̏ꍇ�j
         */
        //�O���̐����̓E�v���ɋL�ڂ�����ꍇ�ɂ́A������̗p����B
        if("52".equals(serviceCodeKind)){
        	if("6252".equals(serviceCodeItem) || "6253".equals(serviceCodeItem)){
        		//�Z���W�����n�r���e�[�V�������{���Z
        		result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
        	}
        }
        
        //[ID:0000464][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
        /*
         * �����K�͑��@�\
         * 
         * ���Ə��J�n�����Z�̓E�v���Ɏ��Ə��̊J�n�����L�ڂ���K�v�����邪�A
         * ���̍��ڂɊւ��Ă͑O���ȑO�̒��߂̓E�v��������p���������s��
         */
        //
        if("73".equals(serviceCodeKind) || "75".equals(serviceCodeKind)){
        	//6139:���K�͑��@�\�^���ƊJ�n�x�����ZI
        	//6140:���K�͑��@�\�^���ƊJ�n�x�����ZII
        	if("6139".equals(serviceCodeItem) || "6140".equals(serviceCodeItem)){
        		result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
        	}
        }
        //[ID:0000464][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
        
        //[ID:0000696][Shin Fujihara] 2012/03 add begin ����24�N4���@�����Ή�
        /*
         * �������^�T�[�r�X
         * 
         * ���Ə��J�n�����Z�̓E�v���Ɏ��Ə��̊J�n�����L�ڂ���K�v�����邪�A
         * ���̍��ڂɊւ��Ă͑O���ȑO�̒��߂̓E�v��������p���������s�� 
         */
        if("77".equals(serviceCodeKind)){
            //6139:�����^���ƊJ�n�x�����Z
            if("6139".equals(serviceCodeItem)){
                result = patientState.getLastRecapitulationCategory3(serviceCodeKind + serviceCodeItem);
            }
        }
        //[ID:0000696][Shin Fujihara] 2012/03 add end ����24�N4���@�����Ή�
        
        /*
         * ������×{�Ǘ��w���A���\�h�����×{�Ǘ��w��
         * �E�Z��񐔂ɉ����ċ���K��������L�ڂ��邱�Ɓi�K�������������Ƃ��́u�A�v�ŋ�؂�j�B
         * ��@6�A20��
         * �P�ʂ��ȗ����邱�Ƃ��B
         * ��@6�A20
         * �y�v���O�������̉��߁z
         * �T�[�r�X��ނ�
         * 31
         * 
         * �����×{�{�݃T�[�r�X
         * �E���Ȏ�f����p
         * ���Ȏ�f���s���������L�ڂ��邱�Ɓi�������s��ꂽ�Ƃ��́u�A�v�ŋ�؂�j�B
         * ��@6�A20��
         * �P�ʂ��ȗ����邱�Ƃ��B
         * ��@6�A20
         * �y�v���O�������̉��߁z
         * isTakajyusin�֐����g�p���A���f
         * 
         */
        boolean daysUniting = false;
        
        //�K��Ō�
        if("13".equals(serviceCodeKind)){
            //�Ō�E���E���A�g�������Z
            if ("4004".equals(serviceCodeItem)){
                daysUniting = true;
            }
        }
        
        //����×{�Ǘ��w��
        if("31".equals(serviceCodeKind)){
            daysUniting = true;
        }
        //���\�h����×{�Ǘ��w��
        if("34".equals(serviceCodeKind)){
            daysUniting = true;
        }
        //���Ȏ�f
        if("53".equals(serviceCodeKind)){
            if("2831".equals(serviceCodeItem)
               || "3831".equals(serviceCodeItem)
               || "4831".equals(serviceCodeItem)){
                daysUniting = true;
            }
        }
        
        
        /* �����V�l�����{�݁A�n�斧���^���V�l�����{��
         * �ޏ��O�K�⑊�k�������Z�A�ޏ���K�⑊�k�������Z�̃`�F�b�N
         */
        if ("51".equals(serviceCodeKind)
            || "54".equals(serviceCodeKind)) {
            
            //�ޏ��O�K�⑊�k�������Z(6501)�A�ޏ���K�⑊�k�������Z(6504)
            if("6501".equals(serviceCodeItem) || "6504".equals(serviceCodeItem)){
                daysUniting = true;
            }
        }
        
        
        /* �����ی��{�݃T�[�r�X
         * �ޏ��O�K��w�����Z�A�ޏ���K��w�����Z�̃`�F�b�N
         */
        if ("52".equals(serviceCodeKind)) {
                
            //�ی��{�ݑޏ��O�K��w�����Z�P(6501)�A�ی��{�ݑޏ��O�K��w�����Z�Q(6506)
            //�ی��{�ݑޏ���K��w�����Z�P(6507)�A�ی��{�ݑޏ���K��w�����Z�Q(6508)
            //�ی��{�ݘV�l�K��Ō�w�����Z(6503)
            if("6501".equals(serviceCodeItem)
                || "6506".equals(serviceCodeItem)
                || "6507".equals(serviceCodeItem)
                || "6508".equals(serviceCodeItem)
                || "6503".equals(serviceCodeItem)){
                daysUniting = true;
            }
        }
        
        /* �����×{�{�݃T�[�r�X
         * �މ@�O�K��w�����Z�A�މ@��K��w�����Z
         */
        if ("53".equals(serviceCodeKind)) {
            
            //�×{�^�މ@�O�K��w�����Z(2851)�A�×{�^�މ@��K��w�����Z(2856)
            //�f�Ï��^�މ@�O�K��w�����Z(3851)�A�f�Ï��^�މ@��K��w�����Z(3856)
            //�F�m�ǌ^�މ@�O�K��w�����Z(4851)�A�F�m�ǌ^�މ@��K��w�����Z(4856)
            if("2851".equals(serviceCodeItem)
                || "2856".equals(serviceCodeItem)
                || "3851".equals(serviceCodeItem)
                || "3856".equals(serviceCodeItem)
                || "4851".equals(serviceCodeItem)
                || "4856".equals(serviceCodeItem)){
                daysUniting = true;
            }
        }
        
        
        //[ID:0000561][ID:0000591][Shin Fujihara] 2010/01 add begin 2009�N�x�Ή�
        /* �Ō�w�����Z�̃`�F�b�N
         �T�[�r�X�̒񋟓����A�J���}��؂�œE�v���ɋL�ڂ���
	     ���×{�^��Î{�݁i�a�@�j�F�×{�^�V�l�K��Ō�w�����Z�FZ2853
	     ���×{�^��Î{�݁i�f�Ï��j�F�f�Ï��^�V�l�K��Ō�w�����Z�FZ3853
	     ���×{�^��Î{�݁i�F�m�ǁj�F�F�m�ǌ^�V�l�K��Ō�w�����Z�FZ4853 
	     */
        //�R�[�h�̓\�[�g�ς݂Ő錾����K�v����B
        String[] codes = {"Z2853","Z3853","Z4853"};
        Arrays.sort(codes);
        if (Arrays.binarySearch(codes, systemServiceCodeItem) >= 0) {
        	daysUniting = true;
        }
        //[ID:0000561][ID:0000591][Shin Fujihara] 2010/01 add end 2009�N�x�Ή�
        
        //����×{�Ǘ��w���܂��͑��Ȏ�f
        if(daysUniting){
            
            //���t����ׂȂ���
            ArrayList<Integer> ary = new ArrayList<Integer>();
            for(int i = 0; i < realDays.size(); i++){
                Integer day = new Integer(ACDateUtilities.getDayOfMonth(ACCastUtilities.toDate(realDays.get(i))));
                if(!ary.contains(day)){
                    ary.add(day);
                }
            }
            
            Object[] oa = ary.toArray();
            Arrays.sort(oa);
            StringBuilder tekiyoTemp = new StringBuilder();
            
            for(int i = 0; i < oa.length; i++){
                if(tekiyoTemp.length() != 0){
                    tekiyoTemp.append(",");
                }
                tekiyoTemp.append(String.valueOf(oa[i]));
            }
            tekiyo = tekiyoTemp.toString();
        }
        
        
        if(tekiyo != null){
            result = tekiyo;
        }
        
        if(reductRate != null){
            if(result.length() > 0){
                result += "/";
            }
            result += reductRate;
        }
        
        return result;
    }
    
}
