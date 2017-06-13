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
 * �쐬��: 2008/02/28  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X ���ی��T�[�r�X���p������ (001)
 * �v���O���� ���ی��T�[�r�X���p������ (QP001P23_27_1Event)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;


/**
 * ���p�Ҍ����������E�̎����ڍהň���N���X�̊��N���X
 */
public class QP001P22Event {
    
    ACDateFormat eraFormat = new ACDateFormat("ggg");
    ACDateFormat eraYearFormat = new ACDateFormat("ee");
    ACDateFormat monthFormat = new ACDateFormat("MM");
    ACDateFormat dayFormat = new ACDateFormat("dd");
    private NumberFormat nf = NumberFormat.getInstance();
    
    //����N���X
    ACChotarouXMLWriter writer = null;
    //����p�f�[�^
    VRMap style = null;
    //���T�[�r�X���p
    VRMap serviceDetail = null;
    //�����N����
    private Date seikyuDate = null;
    //�����Ώ۔N����
    private Date targetDate = null;
    //�̎��N����
    Date ryousyuDate = null;
    
    //���Ə�����
    VRMap provider = null;
    //�����쎖�Ə�
    VRMap care_provider = null;
    private String patientName = "";
    VRMap printSetting = null;
    
    //���v�E���v���������Ƀ`�F�b�N
    private boolean isTotalCheck = false;
    
    // �ύX����w�i�F
    String SERVICE_TOTAL_BACK_COLOR = "#E1E1E1";
    
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P22Event() {
    }

    /**
     * ������܂��B
     * 
     * @param writer
     *            ����Ǘ��N���X
     * @param printParam
     *            ����p�����^
     * @throws Exception
     *             ������O
     */
    public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception{
        this.writer = writer;
        this.style = (VRMap)printParam.get("STYLE_DATA");
        //���p�Ґ������
        this.serviceDetail = (VRMap)printParam.get("CLAIM_PATIENT_DETAIL");
        this.provider = (VRMap)printParam.get("PROVIDER");
        care_provider = (VRMap)printParam.get("CARE_PROVIDER");
        patientName = ACCastUtilities.toString(printParam.get("PATIENT_NAME"));
        printSetting = (VRMap)printParam.get("PRINT_SETTING");
        
        //�����N����
        if(!ACTextUtilities.isNullText(VRBindPathParser.get("TARGET_DATE",printSetting))){
            seikyuDate = ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE",printSetting),null);
        }
        
        //�����Ώ۔N����
        targetDate = ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE",this.style),null);
        
        //�̎��N����
        if(!ACTextUtilities.isNullText(VRBindPathParser.get("GET_DATE",printSetting))){
            ryousyuDate = ACCastUtilities.toDate(VRBindPathParser.get("GET_DATE",printSetting));
        }
        
        //���v�E���v���������Ƀ`�F�b�N
        if(ACCastUtilities.toInt(VRBindPathParser.get("TOTAL_CHECK",printSetting),0) == 1){
            isTotalCheck = true;
        }
        
        return doPrint();
    }
    
    /**
     * �e���[���ʂ̃f�[�^�ݒ���s���܂��B<br>
     * �e���[�̈Ⴂ<br>
     * QP001P221 - �ʏ험�p������<br>
     * QP001P222 - �ʏ험�p������+�U��������t<br>
     * QP001P223 - �ʏ험�p�̎���(���p�������Ɠ��������قȂ�̂�)<br>
     * QP001P224 - �ʏ험�p�̎���+�U��������t<br>
     * QP001P225 - �ʏ험�p�̎���+�̎��z<br>
     * <br>
     * @throws Exception
     */
    protected void setBasicData() throws Exception {
        
        int riyousya = 0;
        int zengaku = 0;
        int kohi = 0;
        int etc = 0;
        boolean isSyokuhiOnly = true;
        
        //�����������͂���Ă����
        if(seikyuDate != null){
            // �����N�����̘a���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "seikyuDate.h1.w1", eraFormat.format(seikyuDate));
            // �����N�����̘a��N(YY�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "seikyuDate.h1.w2", eraYearFormat.format(seikyuDate));
            // �����N�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "seikyuDate.h1.w4", monthFormat.format(seikyuDate));
            // �����N�����̓�(DD�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "seikyuDate.h1.w6", dayFormat.format(seikyuDate));
        }
        
        if(ryousyuDate != null){
            // �����N�����̘a���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "ryousyuDate.h1.w1", eraFormat.format(ryousyuDate));
            // �����N�����̘a��N(YY�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "ryousyuDate.h1.w2", eraYearFormat.format(ryousyuDate));
            // �����N�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "ryousyuDate.h1.w4", monthFormat.format(ryousyuDate));
            // �����N�����̓�(DD�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "ryousyuDate.h1.w6", dayFormat.format(ryousyuDate));
        }

        // �����̑Ώێ҂�ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "riyosya", patientName);

        //�����̑Ώۓ���ݒ肷��B
        if(targetDate != null){
            //�����Ώ۔N�����̘a���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "targetDate.h1.w2", eraFormat.format(targetDate));
            //�����Ώۂ̘a��N(YY�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "targetDate.h1.w3", eraYearFormat.format(targetDate));
            //�����Ώۂ̘a�(MM�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "targetDate.h1.w5", monthFormat.format(targetDate));
        }
        
        //�T�[�r�X��
        String serviceName = "";
        
        //���p�ҕ��S�̃f�[�^��ݒ�
        //���j�I�w�i�ɂ��A�o�C���h�p�X���A�Ԃł͂Ȃ��̂Œ���
        for (int row = 1,i = 0; row <= 10; row++, i+=2){
        	String row_name = Integer.toString(row);
        	
        	// [2014�N�v�]][Shinobu Hitaka] 2015/04/15 edit begin 
        	//--add begin
        	// ���p�ҕ��S0�~�󎚂̏ꍇ�́A�T�[�r�X��ލ��v���R�[�h�̃T�[�r�X���擪��*���t������Ă���
        	String tmpServiceName = ACCastUtilities.toString(style.getData(Integer.toString(1601001 + i)),"");
        	Boolean totalFlag = false;
        	if (tmpServiceName.length() > 1){
	        	if ("*".equals(tmpServiceName.substring(0, 1))) {
	        		totalFlag = true;
	        		tmpServiceName = tmpServiceName.substring(1);
	        	}
        	}
        	//--add end
        	//--edit begin
            // ���p�ҕ��S����������ꍇ�̓C���f���g�{�w�i�F�ύX
            //if(!"".equals(getFormatData(style, Integer.toString(1601001 + i + 1)))){
            if(!"".equals(getFormatData(style, Integer.toString(1601001 + i + 1))) || totalFlag){
                // �T�[�r�X����ݒ肷��B
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".service",SERVICE_TOTAL_BACK_COLOR);
                // �P�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".unit",SERVICE_TOTAL_BACK_COLOR);
                // �񐔂�ݒ肷��
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".count",SERVICE_TOTAL_BACK_COLOR);
                // ���p�ҕ��S�z��ݒ肷��B
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".futan",SERVICE_TOTAL_BACK_COLOR);
                // �T�[�r�X���ɃC���f���g������
                //serviceName = "�@" + style.getData(Integer.toString(1601001 + i));
                serviceName = "�@" + tmpServiceName;
            } else {
                // �ʏ�
                //ACCastUtilities.toString(style.getData(Integer.toString(1601001 + i)),"");
                serviceName = tmpServiceName;
            }
            //--edit end
        	// [2014�N�v�]][Shinobu Hitaka] 2015/04/15 edit end

            ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".service", serviceName);
            // �P�ʐ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".unit", getFormatData(style, Integer.toString(1601038 + i)));
            // �񐔂�ݒ肷��
            ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".count", getFormatData(style, Integer.toString(1601038 + i + 1)));
            // ���p�ҕ��S�z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".futan", getFormatData(style, Integer.toString(1601001 + i + 1)));
            
            riyousya += ACCastUtilities.toInt(style.get(Integer.toString(1601001 + i + 1)),0);
            isSyokuhiOnly = analizeServiceName(serviceName,isSyokuhiOnly);
        }
        
        //11��ڂ���19��ڂ܂ň�
        for (int row = 11,i = 0; row <= 19; row++, i+=4){
        	String row_name = Integer.toString(row);
        	
        	// [2014�N�v�]][Shinobu Hitaka] 2015/04/15 edit begin 
        	// ���p�ҕ��S0�~�󎚂̏ꍇ�́A�T�[�r�X��ލ��v���R�[�h�̃T�[�r�X���擪��*���t������Ă���
        	//--add begin
        	String tmpServiceName = ACCastUtilities.toString(style.getData(Integer.toString(1601062 + i)),"");
        	Boolean totalFlag = false;
        	if (tmpServiceName.length() > 1){
	        	if ("*".equals(tmpServiceName.substring(0, 1))) {
	        		totalFlag = true;
	        		tmpServiceName = tmpServiceName.substring(1);
	        	}
        	}
        	//--add end
        	//--edit begin
            // ���p�ҕ��S����������ꍇ�̓C���f���g�{�w�i�F�ύX
            if(!"".equals(getFormatData(style, Integer.toString(1601062 + i + 3))) || totalFlag){
                // �T�[�r�X����ݒ肷��B
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".service",SERVICE_TOTAL_BACK_COLOR);
                // �P�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".unit",SERVICE_TOTAL_BACK_COLOR);
                // �񐔂�ݒ肷��
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".count",SERVICE_TOTAL_BACK_COLOR);
                // ���p�ҕ��S�z��ݒ肷��B
                ACChotarouXMLUtilities.setFillColor(writer,"seikyu.r" + row_name + ".futan",SERVICE_TOTAL_BACK_COLOR);
                // �T�[�r�X���ɃC���f���g������
                //serviceName = "�@" + style.getData(Integer.toString(1601062 + i));
                serviceName = "�@" + tmpServiceName;
            } else {
                // �ʏ�
                //ACCastUtilities.toString(style.getData(Integer.toString(1601062 + i)),"");
                serviceName = tmpServiceName;
            }
            //--edit end
        	// [2014�N�v�]][Shinobu Hitaka] 2015/04/15 edit end
            
            ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".service", serviceName);
        	//�P�ʐ�
        	ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".unit", getFormatData(style, Integer.toString(1601062 + i + 1)));
        	//��
        	ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".count", getFormatData(style, Integer.toString(1601062 + i + 2)));
        	//���p�ҕ��S�z
            ACChotarouXMLUtilities.setValue(writer, "seikyu.r" + row_name + ".futan", getFormatData(style, Integer.toString(1601062 + i + 3)));

        	riyousya += ACCastUtilities.toInt(style.get(Integer.toString(1601062 + i + 3)),0);
            isSyokuhiOnly = analizeServiceName(serviceName,isSyokuhiOnly);
        }
        
        if(serviceDetail != null){
            //�S�z���ȕ��S�̃f�[�^��ݒ肷��B�����p�ҕ��S���Ƃ̈Ⴂ�̓s����O���b�h��seikyu�ł͂Ȃ��_�ɒ���
            for (int i = 1; i <= 3; i++){
            	String target_name = Integer.toString(i);
                // �T�[�r�X���P��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
                ACChotarouXMLUtilities.setValue(writer, serviceDetail, "SELF_SERVICE_NO" + target_name,"zengaku.z" + target_name + ".service");
                // ���p�ҕ��S�z�P��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
                ACChotarouXMLUtilities.setValue(writer, "zengaku.z" + target_name + ".futan", getFormatData(serviceDetail, "SELF_PAY_NO" + target_name));
            	zengaku += ACCastUtilities.toInt(serviceDetail.get("SELF_PAY_NO" + target_name),0);
            } 
        }
        
        //����{�l���S�̃f�[�^��ݒ肷��B �����p�ҕ��S���Ƃ̈Ⴂ�̓s����O���b�h��seikyu�ł͂Ȃ��_�ɒ���
        // �T�[�r�X���P��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, style, "1601021","kohi.k1.service");
        // ���p�ҕ��S�z�P��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "kohi.k1.futan", getFormatData(style, "1601022"));
        // �T�[�r�X���Q��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, style, "1601023","kohi.k2.service");
        // ���p�ҕ��S�z�Q��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "kohi.k2.futan", getFormatData(style, "1601024"));
        
        kohi += ACCastUtilities.toInt(style.get("1601022"),0);
        kohi += ACCastUtilities.toInt(style.get("1601024"),0);
        
        if(serviceDetail != null){
            //���̑��̃f�[�^��ݒ肷��B
            for (int i = 1; i <= 6; i++){
            	String target_name = Integer.toString(i);
                // �T�[�r�X����ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, serviceDetail, "OTHER_HIMOKU_NO" + target_name,"seikyuetc.e" + target_name + ".service");
                // �P�ʐ���ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
                ACChotarouXMLUtilities.setValue(writer, "seikyuetc.e" + target_name + ".unit", getFormatData(serviceDetail, "OTHER_UNIT_NO" + target_name));
                // �񐔂�ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
                ACChotarouXMLUtilities.setValue(writer, "seikyuetc.e" + target_name + ".count", getFormatData(serviceDetail, "OTHER_COUNT_NO" + target_name));
                // ���p�ҕ��S�z��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
                ACChotarouXMLUtilities.setValue(writer, "seikyuetc.e" + target_name + ".futan", getFormatData(serviceDetail, "OTHER_PAY_NO" + target_name));
            	etc += ACCastUtilities.toInt(serviceDetail.get("OTHER_PAY_NO" + target_name),0);
            }
        }

        // ���Ə�����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_NAME","jigyosyoname");
        // ���Ə��̏��ݒn��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_ADDRESS","address");
        // ���Ə��̓d�b�ԍ���ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "tel", QkanCommon.toTel(provider.get("PROVIDER_TEL_FIRST"),provider.get("PROVIDER_TEL_SECOND"),provider.get("PROVIDER_TEL_THIRD")));
        // ���Ə��̊Ǘ��Ҏ�����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_OWNER_NAME","kanrisya");
        
        // ���v�E���v���������Ƀ`�F�b�N�����Ă���ꍇ�A
        if(isTotalCheck){
            // ���p�ҕ��S�̗��p�ҕ��S�z���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "seikyu.total1.futan", getFormatData(riyousya));
            // �S�z���ȕ��S�̗��p�ҕ��S�z���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "seikyu.total2.futan", getFormatData(zengaku));
            // ����{�l���S�̖{�l���S�z���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "seikyu.total3.futan", getFormatData(kohi));
            // ���̑��̗��p�����v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "seikyuetc.total4.futan", getFormatData(etc));
            //�����v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "seikyuetc.total5.futan",getFormatData(riyousya + zengaku + kohi + etc));
            // �����z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "seikyutotal", getFormatData(riyousya + zengaku + kohi + etc));
        }
        
        // ���v�E���v���������Ƀ`�F�b�N�����Ă���ꍇ�A
        if(getIsTotalCheck()){
            // �����z��ݒ肷��B
        	if(serviceDetail != null){
        		// ���p�Ҍ����������R�[�h���쐬����Ă���ꍇ
        		// ���[�U�̓��͂ɏ]���󎚂���B��"0"��"0"�Ƃ��Ĉ󎚂���B
        		ACChotarouXMLUtilities.setValue(writer, "innertax", getFormatDataExceptZero(serviceDetail, "INNER_TAX"));
        	}else{
        		// ���p�Ҍ����������R�[�h���쐬����Ă��Ȃ��ꍇ
        		// "0"�������l�Ƃ��Ĉ󎚂���B
        		ACChotarouXMLUtilities.setValue(writer, "innertax", "0");
        	}
        }
        
        printCalendar(riyousya, isSyokuhiOnly);
        
// 2016/1/28 [2015�N�v�]][Yoichiro Kamei] add - begin ���l���ǉ�
        if(serviceDetail != null){
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "REMARKS","comment");
        }
// 2016/1/28 add - end
    }
    
    /**
     * �񋟓��J�����_�[�̈󎚂��s���B
     * @throws Exception
     */
    private void printCalendar(int riyousya, boolean isSyokuhiOnly) throws Exception {
    	//serviceDetail(�ڍ�)
    	//serviceAbbr(���O����)
    	
    	//�󎚗p�̃f�[�^�擾
    	//�񋟓�
    	int[] offerDays = getOfferDays();
    	//�}�[�N���
    	//String[] marks = new String[]{"��", "��", "��", "��", "��", "��", "��"};
    	String[] marks = QkanConstants.CLAIM_PATIENT_DETAIL_SERVICE_MARK;
    	
    	//�J�����_�[�̐��l�ł��o��
    	int day = 1;
    	int monthEnd = ACDateUtilities.getLastDayOfMonth(targetDate);
    	int startWeek = 0;
    	
    	//�ǂ�����󎚂��J�n���邩����
    	switch(ACDateUtilities.getDayOfWeek(targetDate)){
    	case Calendar.SUNDAY:		startWeek = 1;	break;
    	case Calendar.MONDAY:		startWeek = 2;	break;
    	case Calendar.TUESDAY:		startWeek = 3;	break;
    	case Calendar.WEDNESDAY:	startWeek = 4;	break;
    	case Calendar.THURSDAY:		startWeek = 5;	break;
    	case Calendar.FRIDAY:		startWeek = 6;	break;
    	case Calendar.SATURDAY:		startWeek = 7;	break;
    	}
    	
    	String gridName = getGridName();
    	//�񋟃T�[�r�X�}��o��
    	ACChotarouXMLUtilities.setValue(writer, "serviceMarkComment", getLegend(offerDays, marks, riyousya, isSyokuhiOnly, gridName));
    	
    	
    	//�J�����_�[�������C��
    	end:for (int i = 1; i < 7; i++) {
    		for (int j = startWeek; j < 8; j++) {
    			//���t�o��
    			ACChotarouXMLUtilities.setValue(writer, "days.h" + i + ".w" + j, String.valueOf(day));
    			//�}�[�N�o��serviceMarkSingle
    			String mark = getMarks(offerDays, marks, day);
    			ACChotarouXMLUtilities.setValue(writer, gridName + ".h" + i + ".w" + j, mark);
    			
    			day++;
    			if (day > monthEnd){
    				break end;
    			}
    		}
    		startWeek = 1;
    	}
    }
    
    private String getGridName() throws Exception {
    	
    	String result = "serviceMarkSingle";
    	
    	if (serviceDetail == null) {
    		return result;
    	}
    	
    	
		String key = "MARK2_SERVICE_NAME";
		if (serviceDetail.containsKey(key)){
			if(!"".equals(ACCastUtilities.toString(serviceDetail.get(key), ""))) {
				result = "serviceMarkMulti";
			}
		}
    	
    	return result;
    }
    
    
    /**
     * �Y�����̃}�[�N�𐶐�
     * @param offerDays
     * @param marks
     * @param day
     * @return
     * @throws Exception
     */
    private String getMarks(int[] offerDays, String[] marks, int day) throws Exception {
    	StringBuilder mark = new StringBuilder();
    	
    	for (int i = 0; i < offerDays.length; i++){
    		if (offerDays[i] == 0) continue;
    		
    		int daybit = 1 << (day - 1);
    		if ((offerDays[i] & daybit) == daybit) {
    			mark.append(marks[i]);
    		}
    	}
    	
    	return mark.toString();
    }
    
    /**
     * �񋟓��f�[�^�擾
     * @return
     * @throws Exception
     */
    private int[] getOfferDays() throws Exception {
    	int[] offerDays = new int[]{0, 0, 0, 0, 0, 0, 0};
    	
    	if (serviceDetail == null) {
    		return offerDays;
    	}
    	
    	for (int i = 1; i <= offerDays.length; i++) {
    		String key = "MARK" + i + "_SERVICE_DATE_BIT";
    		if (serviceDetail.containsKey(key)){
    			offerDays[i - 1] = ACCastUtilities.toInt(serviceDetail.get(key), 0);
    		}
    	}
    	
    	return offerDays;
    }
    
    /**
     * �}�ᐶ��
     * @param marks
     * @return
     * @throws Exception
     */
    private String getLegend(int[] offerDays, String[] marks, int riyousya, boolean isSyokuhiOnly, String gridName) throws Exception {
    	StringBuilder legend = new StringBuilder();
    	
    	if (serviceDetail == null) {
    		return "";
    	}
    	
    	/*
		���T�[�r�X�̎�ނ���������ꍇ�i���p�ҕ��S�̔����̗L���͖��Ȃ��j
		�@���T�[�r�X�̖}���\������B
		
		���T�[�r�X�̎�ނ��P��̏ꍇ�i���p�ҕ��S���������ĂȂ��ꍇ�j
		�@���T�[�r�X�̖}���\������B
		
		���T�[�r�X�̎�ނ��P��̏ꍇ�i���p�ҕ��S���������Ă���ꍇ�j
		�@���T�[�r�X�̖}���\�����Ȃ��B
		���������A�H��E���Z��݂̂̏ꍇ�́A�T�[�r�X�̖}���\������B 
    	 */
    	if (("serviceMarkSingle".equals(gridName))
    		&& (riyousya != 0)
    		&& !isSyokuhiOnly) {
    		return "";
    	}
    	
    	for (int i = 1; i <= offerDays.length; i++) {
    		//�񋟂��Ȃ���Ώ������s��Ȃ�
    		if (offerDays[i - 1] == 0) {
    			continue;
    		}
    		
    		String key = "MARK" + i + "_SERVICE_NAME";
    		if (serviceDetail.containsKey(key)){
    			
				if (legend.length() > 0) {
					legend.append(" ");
				}
				legend.append(marks[i - 1]);
				legend.append("�F");
				legend.append(ACCastUtilities.toString(serviceDetail.get(key), ""));
    		}
    	}
    	return legend.toString();
    }
    
    private boolean analizeServiceName(String serviceName, boolean before) throws Exception {
    	
    	if (ACTextUtilities.isNullText(serviceName)) {
    		return before;
    	}
    	
    	if ((serviceName.indexOf("�H��") != -1)
    		|| (serviceName.indexOf("���Z��") != -1)){
    		
    		//�H��E���Z��̃T�[�r�X
    		//����܂ł̉�͂��H��E���Z��̂�
    		return before;
    	}
    	
    	return false;
    	
    }
    
    private String getFormatData(int value) throws Exception {
        if(value == 0) return "";
        return nf.format((double)(value));
    }
    
    
    /**
     * ��������s���܂��B
     * ������s�ɕK�p�ȃf�[�^�͑S�Đe�N���X�ŕێ����Ă��܂��B
     * @return
     * @throws Exception
     */
    public boolean doPrint() throws Exception{
        return false;
    }
    
    public String getFormatDataExceptZero(VRMap style,String key) throws Exception{
        String value = String.valueOf(style.get(key));
        
        // "0"�̏ꍇ��""��ԋp���Ȃ��B
        if(ACTextUtilities.isNullText(value) || value.equalsIgnoreCase("NULL")){
            return "";
        }
        
        return getNf().format(ACCastUtilities.toDouble(value,0));
    }
    
    public String getFormatData(VRMap style,String key) throws Exception{
        String value = String.valueOf(style.get(key));
        
        if(ACTextUtilities.isNullText(value) || "0".equals(value) || value.equalsIgnoreCase("NULL")){
            return "";
        }
        
        return nf.format(ACCastUtilities.toDouble(value,0));
    }

	/**
	 * @return isTotalCheck ��߂��܂��B
	 */
	public boolean getIsTotalCheck() {
		return isTotalCheck;
	}

	/**
	 * @param isTotalCheck isTotalCheck ��ݒ�B
	 */
	public void setIsTotalCheck(boolean isTotalCheck) {
		this.isTotalCheck = isTotalCheck;
	}
	/**
	 * @return nf ��߂��܂��B
	 */
	public NumberFormat getNf() {
		return nf;
	}

	/**
	 * @param nf nf ��ݒ�B
	 */
	public void setNf(NumberFormat nf) {
		this.nf = nf;
	}

}
