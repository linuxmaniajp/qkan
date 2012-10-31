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
 * �쐬��: 2006/02/06  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X ���ی��T�[�r�X���p������ (001)
 * �v���O���� ���ی��T�[�r�X���p������ (QP001P15)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.text.NumberFormat;
import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;


/**
 * ���ی��T�[�r�X���p�������C�x���g��`(QP001P201) ���[��`�̃t�@�C���� �F QP001P201.xml
 * ���ی��T�[�r�X���p�������C�x���g��`(�U������������)(QP001P202) ���[��`�̃t�@�C���� �F QP001P202.xml
 * ���ی��T�[�r�X���p�̎����C�x���g��`(QP001P203) ���[��`�̃t�@�C���� �F QP001P203.xml
 * ���ی��T�[�r�X���p�̎����C�x���g��`(�U������������)(QP001P204) ���[��`�̃t�@�C���� �F QP001P204.xml
 * ���ی��T�[�r�X���p�̎����C�x���g��`�i�̎�������j(QP001P205) ���[��`�̃t�@�C���� �F QP001P205.xml
 */
public class QP001P20Event {
    
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
    
    
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P20Event() {
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
     * QP001P201 - �ʏ험�p������<br>
     * QP001P202 - �ʏ험�p������+�U��������t<br>
     * QP001P203 - �ʏ험�p�̎���(���p�������Ɠ��������قȂ�̂�)<br>
     * QP001P204 - �ʏ험�p�̎���+�U��������t<br>
     * QP001P205 - �ʏ험�p�̎���+�̎��z<br>
     * <br>
     * @throws Exception
     */
    protected void setBasicData() throws Exception {
        
        int riyousya = 0;
        int zengaku = 0;
        int kohi = 0;
        int etc = 0;
        
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
        
        //���p�ҕ��S�̃f�[�^��ݒ�
        // �T�[�r�X���P��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, style, "1601001","seikyu.r1.service");
        // ���p�ҕ��S�z�P��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r1.futan", getFormatData(style, "1601002"));
        // �T�[�r�X���Q��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, style, "1601003","seikyu.r2.service");
        // ���p�ҕ��S�z�Q��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r2.futan", getFormatData(style, "1601004"));
        // �T�[�r�X���R��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, style, "1601005","seikyu.r3.service");
        // ���p�ҕ��S�z�R��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r3.futan", getFormatData(style, "1601006"));
        // �T�[�r�X���S��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, style, "1601007","seikyu.r4.service");
        // ���p�ҕ��S�z�S��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r4.futan", getFormatData(style, "1601008"));
        // �T�[�r�X���T��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, style, "1601009","seikyu.r5.service");
        // ���p�ҕ��S�z�T��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r5.futan", getFormatData(style, "1601010"));
        // �T�[�r�X���U��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, style, "1601011","seikyu.r6.service");
        // ���p�ҕ��S�z�U��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r6.futan", getFormatData(style, "1601012"));
        // �T�[�r�X���V��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, style, "1601013","seikyu.r7.service");
        // ���p�ҕ��S�z�V��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r7.futan", getFormatData(style, "1601014"));
        // �T�[�r�X���W��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, style, "1601015","seikyu.r8.service");
        // ���p�ҕ��S�z�W��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r8.futan", getFormatData(style, "1601016"));
        // �T�[�r�X���X��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, style, "1601017","seikyu.r9.service");
        // ���p�ҕ��S�z�X��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r9.futan", getFormatData(style, "1601018"));
        // �T�[�r�X���P�O��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, style, "1601019","seikyu.r10.service");
        // ���p�ҕ��S�z�P�O��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r10.futan", getFormatData(style, "1601020"));
        
        // �P�ʐ��P��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r1.unit", getFormatData(style, "1601038"));
        // �񐔂P��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r1.count", getFormatData(style, "1601039"));
        // �P�ʐ��Q��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r2.unit", getFormatData(style, "1601040"));
        // �񐔂Q��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r2.count", getFormatData(style, "1601041"));
        // �P�ʐ��R��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r3.unit", getFormatData(style, "1601042"));
        // �񐔂R��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r3.count", getFormatData(style, "1601043"));
        // �P�ʐ��S��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r4.unit", getFormatData(style, "1601044"));
        // �񐔂S��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r4.count", getFormatData(style, "1601045"));
        // �P�ʐ��T��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r5.unit", getFormatData(style, "1601046"));
        // �񐔂T��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r5.count", getFormatData(style, "1601047"));
        // �P�ʐ��U��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r6.unit", getFormatData(style, "1601048"));
        // �񐔂U��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r6.count", getFormatData(style, "1601049"));
        // �P�ʐ��V��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r7.unit", getFormatData(style, "1601050"));
        // �񐔂V��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r7.count", getFormatData(style, "1601051"));
        // �P�ʐ��W��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r8.unit", getFormatData(style, "1601052"));
        // �񐔂W��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r8.count", getFormatData(style, "1601053"));
        // �P�ʐ��X��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r9.unit", getFormatData(style, "1601054"));
        // �񐔂X��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r9.count", getFormatData(style, "1601055"));
        // �P�ʐ��P�O��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r10.unit", getFormatData(style, "1601056"));
        // �񐔂P�O��ݒ肷��
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r10.count", getFormatData(style, "1601057"));
        
        
        riyousya += ACCastUtilities.toInt(style.get("1601002"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601004"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601006"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601008"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601010"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601012"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601014"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601016"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601018"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601020"),0);
        
        
        if(serviceDetail != null){
            //�S�z���ȕ��S�̃f�[�^��ݒ肷��B
            // �T�[�r�X���P��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "SELF_SERVICE_NO1","zengaku.z1.service");
            // ���p�ҕ��S�z�P��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "zengaku.z1.futan", getFormatData(serviceDetail, "SELF_PAY_NO1"));
            // �T�[�r�X���Q��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "SELF_SERVICE_NO2","zengaku.z2.service");
            // ���p�ҕ��S�z�Q��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "zengaku.z2.futan", getFormatData(serviceDetail, "SELF_PAY_NO2"));
            // �T�[�r�X���R��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "SELF_SERVICE_NO3","zengaku.z3.service");
            // ���p�ҕ��S�z�R��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "zengaku.z3.futan", getFormatData(serviceDetail, "SELF_PAY_NO3"));

            zengaku += ACCastUtilities.toInt(serviceDetail.get("SELF_PAY_NO1"),0);
            zengaku += ACCastUtilities.toInt(serviceDetail.get("SELF_PAY_NO2"),0);
            zengaku += ACCastUtilities.toInt(serviceDetail.get("SELF_PAY_NO3"),0);
        }
        
        //����{�l���S�̃f�[�^��ݒ肷��B
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
            // �T�[�r�X���P��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "OTHER_HIMOKU_NO1","seikyu.e1.service");
            // ���p�ҕ��S�z�P��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e1.futan", getFormatData(serviceDetail, "OTHER_PAY_NO1"));
            // �T�[�r�X���Q��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "OTHER_HIMOKU_NO2","seikyu.e2.service");
            // ���p�ҕ��S�z�Q��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e2.futan", getFormatData(serviceDetail, "OTHER_PAY_NO2"));
            // �T�[�r�X���R��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "OTHER_HIMOKU_NO3","seikyu.e3.service");
            // ���p�ҕ��S�z�R��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e3.futan", getFormatData(serviceDetail, "OTHER_PAY_NO3"));
            // �T�[�r�X���S��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "OTHER_HIMOKU_NO4","seikyu.e4.service");
            // ���p�ҕ��S�z�S��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e4.futan", getFormatData(serviceDetail, "OTHER_PAY_NO4"));
            // �T�[�r�X���T��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "OTHER_HIMOKU_NO5","seikyu.e5.service");
            // ���p�ҕ��S�z�T��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e5.futan", getFormatData(serviceDetail, "OTHER_PAY_NO5"));

            // �P�ʐ��P��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e1.unit", getFormatData(serviceDetail, "OTHER_UNIT_NO1"));
            // �񐔂P��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e1.count", getFormatData(serviceDetail, "OTHER_COUNT_NO1"));
            // �P�ʐ��Q��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e2.unit", getFormatData(serviceDetail, "OTHER_UNIT_NO2"));
            // �񐔂Q��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e2.count", getFormatData(serviceDetail, "OTHER_COUNT_NO2"));
            // �P�ʐ��R��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e3.unit", getFormatData(serviceDetail, "OTHER_UNIT_NO3"));
            // �񐔂R��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e3.count", getFormatData(serviceDetail, "OTHER_COUNT_NO3"));
            // �P�ʐ��S��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e4.unit", getFormatData(serviceDetail, "OTHER_UNIT_NO4"));
            // �񐔂S��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e4.count", getFormatData(serviceDetail, "OTHER_COUNT_NO4"));
            // �P�ʐ��T��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e5.unit", getFormatData(serviceDetail, "OTHER_UNIT_NO5"));
            // �񐔂T��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e5.count", getFormatData(serviceDetail, "OTHER_COUNT_NO5"));
            // �T�[�r�X���U��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "OTHER_HIMOKU_NO6","seikyu.e6.service");
            // �P�ʐ��T��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e6.unit", getFormatData(serviceDetail, "OTHER_UNIT_NO6"));
            // �񐔂T��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e6.count", getFormatData(serviceDetail, "OTHER_COUNT_NO6"));
            // ���p�ҕ��S�z�T��ݒ肷��B ��CLAIM_PATIENT_DETAIL���擾
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e6.futan", getFormatData(serviceDetail, "OTHER_PAY_NO6"));
            
            etc += ACCastUtilities.toInt(serviceDetail.get("OTHER_PAY_NO1"),0);
            etc += ACCastUtilities.toInt(serviceDetail.get("OTHER_PAY_NO2"),0);
            etc += ACCastUtilities.toInt(serviceDetail.get("OTHER_PAY_NO3"),0);
            etc += ACCastUtilities.toInt(serviceDetail.get("OTHER_PAY_NO4"),0);
            etc += ACCastUtilities.toInt(serviceDetail.get("OTHER_PAY_NO5"),0);
            etc += ACCastUtilities.toInt(serviceDetail.get("OTHER_PAY_NO6"),0);
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
            ACChotarouXMLUtilities.setValue(writer, "seikyu.total4.futan", getFormatData(etc));
            //�����v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "seikyu.total5.futan",getFormatData(riyousya + zengaku + kohi + etc));
            // �����z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "seikyutotal", getFormatData(riyousya + zengaku + kohi + etc));
            
        }

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
