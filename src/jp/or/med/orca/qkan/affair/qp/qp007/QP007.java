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
 * �쐬��: 2006/02/15  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X ���p�Ҍ������ (007)
 * �v���O���� ���p�Ҍ�����������ݒ� (QP007)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp007;

import java.awt.event.*;

import javax.swing.event.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.vr.util.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;

/**
 * ���p�Ҍ�����������ݒ�(QP007)
 */
public class QP007 extends QP007Event {
    
    //�ݒ�l�ԋp�p
    VRMap result = null;
    
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP007() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * �������������s�Ȃ��܂��B
     * 
     * @param affair
     *            �Ɩ����
     * @throws Exception
     *             ������O
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        VRMap affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP007");
        setTitle((String) affairInfoMap.get("WINDOW_TITLE"));
        
        VRMap settings = new VRHashMap();
        settings.put("TARGET_RADIO",new Integer(1));

        // �ݒ�t�@�C����ǂݍ��݁A��ʂ̏�����Ԃ�ݒ肷��B
        if (ACFrame.getInstance().hasProperty("Claim/TargetRadio")) {
            String targetRadio = getProperty("Claim/TargetRadio");
            //�ݒ�t�@�C����Claim-TargetRadio��1�̏ꍇ
            if("1".equals(targetRadio)){
                //�u���������W�I�{�^��(patientBillSetupPapersRadioItem1)�v�Ƀ`�F�b�N��t����B
                settings.put("TARGET_RADIO",new Integer(1));
            //�ݒ�t�@�C����Claim-TargetRadio��2�̏ꍇ
            } else if("2".equals(targetRadio)){
                //�u�̎������W�I�{�^��(patientBillSetupPapersRadioItem2)�v�Ƀ`�F�b�N��t����B
                settings.put("TARGET_RADIO",new Integer(2));
            //�ݒ�t�@�C����Claim-TargetRadio��3�̏ꍇ
            } else if("3".equals(targetRadio)){
                //�u�������E�̎������W�I�{�^��(patientBillSetupPapersRadioItem3)�v�Ƀ`�F�b�N��t����B
                settings.put("TARGET_RADIO",new Integer(3));
            }
        }
        
        if (ACFrame.getInstance().hasProperty("Claim/TotalCheck")) {
            //�ݒ�t�@�C����Claim-TotalCheck��0�̏ꍇ
            //�u���v�E���v���������(patientBillSetupBillAndReceiptDate)�v�̃`�F�b�N���͂����B
            //�ݒ�t�@�C����Claim-TotalCheck��1�̏ꍇ
            //�u���v�E���v���������(patientBillSetupBillAndReceiptDate)�v�̃`�F�b�N��t����B
            settings.put("TOTAL_CHECK",getProperty("Claim/TotalCheck"));
        } else {
            settings.put("TOTAL_CHECK",new Integer(0));
        }
        
        if (ACFrame.getInstance().hasProperty("Claim/PrintCheck")) {
            //�ݒ�t�@�C����Claim-PrintCheck��0�̏ꍇ
            //�u�������ɐU����̘g���������(patientBillSetupUnderPrintOn)�v�̃`�F�b�N���͂����B
            //�ݒ�t�@�C����Claim-PrintCheck��1�̏ꍇ
            //�u�������ɐU����̘g���������(patientBillSetupUnderPrintOn)�v�̃`�F�b�N��t����B
            settings.put("PRINT_CHECK",getProperty("Claim/PrintCheck"));
        } else {
            settings.put("PRINT_CHECK",new Integer(0));
        }
        
        if (ACFrame.getInstance().hasProperty("Claim/StyleCheck")) {
            //�ݒ�t�@�C����Claim-StyleCheck��0�̏ꍇ
            //�u��Ô�T���Ή��łŏo�͂���(patientBillSetupMedicalTreatmentOn)�v�̃`�F�b�N���͂����B
            //�ݒ�t�@�C����Claim-StyleCheck��1�̏ꍇ
            //�u��Ô�T���Ή��łŏo�͂���(patientBillSetupMedicalTreatmentOn)�v�̃`�F�b�N��t����B
            settings.put("STYLE_CHECK",getProperty("Claim/StyleCheck"));
        } else {
            settings.put("STYLE_CHECK",new Integer(0));
        }
        
        // [���p�Ҍ����������E�̎����@�ڍהőΉ�] fujihara add start
        if (ACFrame.getInstance().hasProperty("Claim/DetailsCheck")) {
			//�ݒ�t�@�C����Claim-DetailsCheck��0�̏ꍇ	
			//�u�ڍהłň������(patientBillSetupDetailsPrintOn)�v�̃`�F�b�N���͂����B
			//�ݒ�t�@�C����Claim-DetailsCheck��0�̏ꍇ	
			//�u�ڍהłň������(patientBillSetupDetailsPrintOn)�v�̃`�F�b�N��t����B
            settings.put("DETAILS_CHECK",getProperty("Claim/DetailsCheck"));
        } else {
            settings.put("DETAILS_CHECK",new Integer(0));
        }
        // [���p�Ҍ����������E�̎����@�ڍהőΉ�] fujihara add end
        
        
        // �u���������t(patientBillSetupBillDate)�v�Ƀ��O�C�����t��ݒ肷��B
        settings.put("TARGET_DATE",QkanSystemInformation.getInstance().getSystemDate());
        // �u�̎������t(patientBillSetupReceiptDate)�v�Ƀ��O�C�����t��ݒ肷��B
        settings.put("GET_DATE",QkanSystemInformation.getInstance().getSystemDate());
        getContents().setSource(settings);
        getContents().bindSource();
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�������Enabled�ύX�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void patientBillSetupPapersRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        
        //������I�v�V�����`�F�b�N�̕ύX����
        switch(getPatientBillSetupPapersRadio().getSelectedIndex()){
            //���������I������Ă���ꍇ
            case 1:
                //�u��Ô�T���Ή��łŏo��(patientBillSetupMedicalTreatmentOn)�v�̃`�F�b�N���͂����B
                getPatientBillSetupMedicalTreatmentOn().setValue(0);
                // ���������W�I�{�^���N���b�N���̉�ʐݒ���s���B
                setState_RADIO_1();
                break;
            //�̎������I������Ă���ꍇ
            case 2:
                //�u�������ɐU����̘g���������(patientBillSetupUnderPrintOn)�v�̃`�F�b�N���͂����B
                getPatientBillSetupUnderPrintOn().setValue(0);
                // �̎������W�I�{�^���N���b�N���̉�ʐݒ���s���B
                setState_RADIO_2();
                break;
                
            //�������E�̎������I������Ă���ꍇ
            case 3:
                // �������E�̎������W�I�{�^���N���b�N���̉�ʐݒ���s���B
                setState_RADIO_3();
                break;
        }
    }

    /**
     * �u����������̏����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void printActionPerformed(ActionEvent e) throws Exception {
        VRMap settings = new VRHashMap();
        // contents�̃o�C���h�\�[�X�Ƃ���settings���w�肷��B
        getContents().setSource(settings);
        // ��ʂ̏���settings�Ɋi�[����B
        getContents().applySource();
        
        
        // ���ݑI������Ă���l��ݒ�t�@�C���ɕۑ�����B
        // �u���������W�I�{�^��(patientBillSetupPapersRadioItem1)�v�Ƀ`�F�b�N���t���Ă���ꍇ�B
        // �ݒ�t�@�C����Claim-TargetRadio��1��ݒ肷��B
        // �u�̎������W�I�{�^��(patientBillSetupPapersRadioItem2)�v�Ƀ`�F�b�N���t���Ă���ꍇ�B
        // �ݒ�t�@�C����Claim-TargetRadio��2��ݒ肷��B
        // �u�������E�̎������W�I�{�^��(patientBillSetupPapersRadioItem3)�v�Ƀ`�F�b�N���t���Ă���ꍇ�B
        // �ݒ�t�@�C����Claim-TargetRadio��3��ݒ肷��B
        setProperty("Claim/TargetRadio", String.valueOf(settings.getData("TARGET_RADIO")));
        
        setProperty("Claim/TotalCheck",String.valueOf(settings.getData("TOTAL_CHECK")));
        
        // �u�������ɐU����̘g���������(patientBillSetupUnderPrintOn)�v���`�F�b�N����Ă��Ȃ��ꍇ�B
        // �ݒ�t�@�C����Claim-PrintCheck��0��ݒ肷��B
        // �u�������ɐU����̘g���������(patientBillSetupUnderPrintOn)�v���`�F�b�N����Ă���ꍇ�B
        // �ݒ�t�@�C����Claim-PrintCheck��1��ݒ肷��B
        setProperty("Claim/PrintCheck", String.valueOf(settings.getData("PRINT_CHECK")));
        
        // �u��Ô�T���Ή��łŏo�͂���(patientBillSetupMedicalTreatmentOn)�v���`�F�b�N����Ă��Ȃ��ꍇ�B
        // �ݒ�t�@�C����Claim-StyleCheck��0��ݒ肷��B
        // �u��Ô�T���Ή��łŏo�͂���(patientBillSetupMedicalTreatmentOn)�v���`�F�b�N����Ă���ꍇ�B
        // �ݒ�t�@�C����Claim-StyleCheck��1��ݒ肷��B
        setProperty("Claim/StyleCheck", String.valueOf(settings.getData("STYLE_CHECK")));
        
        // [���p�Ҍ����������E�̎����@�ڍהőΉ�] fujihara add start
        //�u�ڍהłň������(patientBillSetupDetailsPrintOn)�v���`�F�b�N����Ă��Ȃ��ꍇ�B	
        //�ݒ�t�@�C����Claim-DetailsCheck��0�ɐݒ肷��B
        //�u�ڍהłň������(patientBillSetupDetailsPrintOn)�v���`�F�b�N����Ă���ꍇ�B	
        //�ݒ�t�@�C����Claim-DetailsCheck��1�ɐݒ肷��B
        setProperty("Claim/DetailsCheck", String.valueOf(settings.getData("DETAILS_CHECK")));
        // [���p�Ҍ����������E�̎����@�ڍהőΉ�] fujihara add end
        
        saveProperty();
        
        // ���_�C�A���O�Ăяo�����ɁA�u����Ώہv�u���������t�v�u�̎������t�v�u���v�E���v���������v�u�������ɐU����̘g���������v
        // �u��Ô�T���Ή��łŏo�́v�ɐݒ肳�ꂽ�l��Ԃ��A�_�C�A���O�����B
        
        result = settings;
        result.put("PRINT","TRUE");
        //�E�C���h�E�����B
        dispose();
    }

    /**
     * �u���鉟�����̏����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void closeActionPerformed(ActionEvent e) throws Exception {
        result = null;
        // ���_�C�A���O�Ăяo�����ɒl�͕Ԃ����A�_�C�A���O�����B
        dispose();
    }
    
    public VRMap getResult() throws Exception {
        return result;
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QP007.class.getName(), param));
    }

}
