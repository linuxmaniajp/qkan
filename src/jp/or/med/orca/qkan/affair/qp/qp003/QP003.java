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
 * �J����: ��i�@�a�P
 * �쐬��: 2006/02/16  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (003)
 * �v���O���� ���p�Ҍ��������ڍוҏW (QP003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp003;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.text.Format;
import java.util.Date;

import javax.swing.event.ChangeEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * ���p�Ҍ��������ڍוҏW(QP003)
 */
public class QP003 extends QP003Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP003() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * �������������s�Ȃ��܂��B
     * 
     * @param affair �Ɩ����
     * @throws Exception ������O
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        // ���L�̓n��p�����[�^��ޔ�����B
        VRMap params = affair.getParameters();
        // �EpatientId KEY�FPATIENT_ID
        if (VRBindPathParser.has("PATIENT_ID", params)) {
            setPatientId(ACCastUtilities.toInt(params.getData("PATIENT_ID")));
        }
        // �EtargetDate KEY�FTARGET_DATE
        if (VRBindPathParser.has("TARGET_DATE", params)) {
            setTargetDate(ACCastUtilities.toDate(params.getData("TARGET_DATE")));
        }
        // �EclaimDate KEY�FCLAIM_DATE
        if (VRBindPathParser.has("CLAIM_DATE", params)) {
            setClaimDate(ACCastUtilities.toDate(params.getData("CLAIM_DATE")));
        }
        // �ElistIndex KEY�FLIST_INDEX
        if (VRBindPathParser.has("LIST_INDEX", params)) {
            setListIndex(ACCastUtilities.toInt(params.getData("LIST_INDEX")));
        }
        // �EproviderId KEY�FPROVIDER_ID
        if (VRBindPathParser.has("PROVIDER_ID", params)) {
            setProviderId(ACCastUtilities.toString(params
                    .getData("PROVIDER_ID")));
        }
        // �EinsurerId KEY�FINSURER_ID
        if (VRBindPathParser.has("INSURER_ID", params)) {
            setInsurerId(ACCastUtilities.toString(params.getData("INSURER_ID")));
        }
        // �EinsuredId KEY�FINSURED_ID
        if (VRBindPathParser.has("INSURED_ID", params)) {
            setInsuredId(ACCastUtilities.toString(params.getData("INSURED_ID")));
        }

        setPASSIVE_CHECK_KEY(new ACPassiveKey("CLAIM_PATIENT_DETAIL",
                new String[] { "CLAIM_ID" }, new Format[] { null },
                "LAST_TIME", "LAST_TIME"));

        // �R���{���̐ݒ�
        comboInitialize();

        // [V5.3.4�Ή� ���p�Ҍ����̎���] kamitsukasa.kazuyoshi add start
        if(ACDateUtilities.compareOnDay(DATE_20070401, getClaimDate()) > 0){
        	// ����19�N4��1�����ߋ��̓��t�̏ꍇ
        	// ���Ń��x���A�e�L�X�g���\���ɐݒ肷��B
        	setState_INVISIBLE_INNER_TAX();
        	getContentEtcUseTitle().setText("���p��");
        }else{
        	// �����N��(claimDate)���u����19�N4���v�ȍ~�̏ꍇ	
        	// ��������Ńe�L�X�g�ɏ����l�F0��\������B
        	getContentInnerTaxText().setText("0");
        }
        
        // [ID:0000435][Masahiko Higuchi] 2009/07 add begin �J�����_�[�Ɏ��т�ǂݍ��ދ@�\�̊g��
        // �J�����_�[�̏�����
        int dayCount = 1;
        int year = ACDateUtilities.getYear(getTargetDate());
        int month = ACDateUtilities.getMonth(getTargetDate());
        // ��ʏ�Ԃ̕ύX
        int lastDay = ACDateUtilities.getLastDayOfMonth(getTargetDate());
        switch(lastDay) {
        case 28:
            setState_CALENDER_MODE28();
            break;
        case 29:
            setState_CALENDER_MODE29();
            break;
        case 30:
            setState_CALENDER_MODE30();
            break;
        }
        // �R���|�[�l���g��S����
        for (int j = 0; j < getContentCalendar().getComponentCount(); j++) {
            Component cmp = getContentCalendar().getComponent(j);
            // �e�[�u���̏ꍇ�̂ݏ�����
            if (cmp instanceof QP003ResultCalendar) {
                QP003ResultCalendar rc = (QP003ResultCalendar) cmp;
                // �T�[�r�X�}�X�^�̐ݒ�
                // ���t��ݒ�
                rc.setCalenderDate(ACDateUtilities.createDate(year, month,
                        dayCount));
                // ���t��+1
                dayCount++;
            }
        }
        // [ID:0000435][Masahiko Higuchi] 2009/07 add end
        
        // [V5.3.4�Ή� ���p�Ҍ����̎���] kamitsukasa.kazuyoshi add end
        
        // ��Ô�T���z�擾
        doFindKoujo();
        // ��Ô�T����\��
        getKoujoDispCheck().setSelected(true);
        getContentHokenIryoKoujoCheck().setSelected(true);
        setState_KOUJO_ENABLE_TRUE();
        
        // �Ɩ����}�X�^���A�f�[�^���擾����B
        setAffairTitle("QP003", getButtons());
        // �擾�����f�[�^�̃E�B���h�E�^�C�g���iWINDOW_TITLE�j���E�B���h�E�ɐݒ肷��B
        // �擾�����f�[�^�̋Ɩ��^�C�g���iAFFAIR_TITLE�j���Ɩ��{�^���o�[�ɐݒ肷��B
        // DB���f�[�^���擾���A��ʂɓW�J����B
        doFind();

    }

    /**
     * �O��ʑJ�ڏ������s���܂��B 
     */
    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // �X�V�`�F�b�N�i�X�i�b�v�V���b�g�̃`�F�b�N�j���s���B
        // [ID:0000435][Masahiko Higuchi] 2009/07 edit begin �J�����_�[�Ɏ��т�ǂݍ��ދ@�\�̊g��
        if (getSnapshot().isModified() || calenderIsModified()) {
        // [ID:0000435][Masahiko Higuchi] 2009/07 edit end
            // �Ō�ɕۑ�����Ă���A���ځE�e�[�u�����ύX����Ă���ꍇ�ꍇ(not isModified)
            // �m�F���b�Z�[�W��\������B
            int msgID = 0;
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                msgID = QkanMessageList.getInstance()
                        .WARNING_OF_INSERT_ON_MODIFIED();
            } else {
                msgID = QkanMessageList.getInstance()
                        .WARNING_OF_UPDATE_ON_MODIFIED();
            }
            // �E���b�Z�[�WID�FWARNING_OF_UPDATE_ON_MODIFIED
            switch (msgID) {
            // �u�͂��v��I�������ꍇ
            case ACMessageBox.RESULT_YES:
                // �ۑ��������s���B
                if (!doSave()) {
                    // �ۑ�����������I�����Ȃ������ꍇ
                    // �����𒆒f����B(�I��)
                    return false;
                }
                break;
            // ����������I�������ꍇ
            case ACMessageBox.RESULT_NO:
                break;
            // ��L�����Z�����I�������ꍇ
            case ACMessageBox.RESULT_CANCEL:
                return false;
            }
            // �u�͂��v�u�������v�ȊO��I�������ꍇ
            // �����𒆒f����i�������Ȃ��j�B
        }

        // ���L��n��p�����[�^�Ƃ��āA���[(�l��)�E���Ə��I����ʁiQP002�j�ɑJ�ڂ���B
        // �EKEY�FPATIENT_ID VALUE�FpatientId
        // �EKEY�FTARGET_DATE VALUE�FtargetDate
        // �EKEY�FCLAIM_DATE VALUE�FclaimDate
        // �EKEY�FLIST_INDEX VALUE�FlistIndex
        parameters.setData("PATIENT_ID", new Integer(getPatientId()));
        parameters.setData("TARGET_DATE", getTargetDate());
        parameters.setData("CLAIM_DATE", getClaimDate());
        parameters.setData("LIST_INDEX", new Integer(getListIndex()));

        // �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
        return true;

    }

    // �R���|�[�l���g�C�x���g
    /**
     * �I���������s���܂��B
     */
    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // ���X�i�b�v�V���b�g�`�F�b�N
        // �X�i�b�v�V���b�g�̍X�V�`�F�b�N���s���B
        // [ID:0000435][Masahiko Higuchi] 2009/07 edit begin �J�����_�[�Ɏ��т�ǂݍ��ދ@�\�̊g��
        if (!getSnapshot().isModified() || !calenderIsModified()) {
        // [ID:0000435][Masahiko Higuchi] 2009/07 edit end
            // �X�V����Ă��Ȃ��ꍇ
            return true;
            // �V�X�e�����I������B
        }
        // �X�V����Ă���ꍇ
        // �������p������B
        // ���I���m�F
        // �I���m�F�̃��b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_CLOSE_ON_MODIFIED
        int msgID = QkanMessageList.getInstance()
                .WARNING_OF_CLOSE_ON_MODIFIED();
        // �uOK�v�I����
        if (ACMessageBox.RESULT_OK == msgID) {
            // �V�X�e�����I������B
            return true;
        } else {
            // �u�L�����Z���v�I����
            // �����𒆒f����B
            return false;
        }
        // �I����������Ȃ��true��Ԃ��B

    }

    // �R���|�[�l���g�C�x���gk

    /**
     * �uDB�o�^�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // �o�^�������s���B
        if (doSave()) {
            // �o�^����������I�������ꍇ
            // �������b�Z�[�W��\������B
            QkanMessageList.getInstance().INSERT_SUCCESSED();
            // �E���b�Z�[�WID�FINSERT_SUCCESSED
        }
        // �o�^����������I�����Ȃ������ꍇ
        // �����𒆒f����i�I���j

    }

    // �R���|�[�l���g�C�x���g

    /**
     * �uDB�o�^�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {

        // �X�V�������s���B
        if (doSave()) {
            // �X�V����������I�������ꍇ
            // �������b�Z�[�W��\������B
            // �E���b�Z�[�WID�FUPDATE_SUCCESSED
            QkanMessageList.getInstance().UPDATE_SUCCESSED();
        }
        // �X�V����������I�����Ȃ������ꍇ
        // �����𒆒f����B(�I��)

    }

    /**
     * �u���v���z�̌v�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentJikohutanUse1FocusLost(FocusEvent e) throws Exception {
        // ���z�̍��v���Z�o���A�\������B
        calcSum();

    }

    /**
     * �u���v���z�̌v�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentJikohutanUse2FocusLost(FocusEvent e) throws Exception {
        // ���z�̍��v���Z�o���A�\������B
        calcSum();

    }

    /**
     * �u���v���z�̌v�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentJikohutanUse3FocusLost(FocusEvent e) throws Exception {
        // ���z�̍��v���Z�o���A�\������B
        calcSum();

    }

    /**
     * �u���v���z�̌v�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentEtcUse1FocusLost(FocusEvent e) throws Exception {
        // ���z�̍��v���Z�o���A�\������B
        calcSum();

    }

    /**
     * �u���v���z�̌v�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentEtcUse2FocusLost(FocusEvent e) throws Exception {
        // ���z�̍��v���Z�o���A�\������B
        calcSum();

    }

    /**
     * �u���v���z�̌v�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentEtcUse3FocusLost(FocusEvent e) throws Exception {
        // ���z�̍��v���Z�o���A�\������B
        calcSum();

    }

    /**
     * �u���v���z�̌v�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentEtcUse4FocusLost(FocusEvent e) throws Exception {
        // ���z�̍��v���Z�o���A�\������B
        calcSum();

    }

    /**
     * �u���v���z�̌v�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentEtcUse5FocusLost(FocusEvent e) throws Exception {
        // ���z�̍��v���Z�o���A�\������B
        calcSum();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        param.setData("PATIENT_ID", new Integer(1));
        param.setData("CLAIM_DATE", new Date(106, 2, 1));
        param.setData("PROVIDER_ID", "0000000005");
        param.setData("TARGET_DATE", new Date(106, 1, 1));
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QP003.class.getName(), param));
    }

    // �����֐�

    /**
     * �u�f�[�^�擾�A��ʓW�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doFind() throws Exception {
        // �f�[�^�̎擾�A�W�J���s���B
        // ���p�ҏ����擾����B
        VRList patientList = QkanCommon.getPatientInfo(getDBManager(),
                getPatientId());
        // �擾�������p�ҏ����A���L�̒l�𒊏o���ăf�[�^�W�J�pHashMap(sourceMap)�ɐݒ肷��B
        if (!patientList.isEmpty()) {
            VRMap patientMap = (VRMap) patientList.getData(0);
            // �E���p��ID KEY�FPATIENT_ID
            getSourceMap().setData("PATIENT_CODE",
                    patientMap.getData("PATIENT_CODE"));
            // �E���p�Җ� KEY�FPATIENT_NAME
            getSourceMap().setData(
                    "PATIENT_NAME",
                    QkanCommon.toFullName(patientMap
                            .getData("PATIENT_FAMILY_NAME"), patientMap
                            .getData("PATIENT_FIRST_NAME")));
        }
        // ���Ə������擾����B
        VRList providerList = QkanCommon.getProviderInfo(getDBManager(),
                getProviderId());
        // �擾�������Ə������A���L�̒l�𒊏o���ăf�[�^�W�J�pHashMap(sourceMap)�ɐݒ肷��B
        if (!providerList.isEmpty()) {
            VRMap providerMap = (VRMap) providerList.getData(0);
            // �E���Ə�ID KEY�FPROVIDER_ID
            getSourceMap().setData("PROVIDER_ID",
                    providerMap.getData("PROVIDER_ID"));
            // �E���Ə��� KEY�FPROVIDER_NAME
            getSourceMap().setData("PROVIDER_NAME",
                    providerMap.getData("PROVIDER_NAME"));
        }
        // �Ώ۔N���itargetDate�j���f�[�^�W�J�pHashMap(sourceMap)��KEY�FTARGET_DATE�Őݒ肷��B
        getSourceMap().setData("TARGET_DATE", getTargetDate());
        // ���p�Ҍ��������ڍ׏����擾����B
        doFindClaimForPatient();

        VRList claimList = getClaimList();
        // ���p�Ҍ��������ڍ׏��iclaimList�j�̍ŏ��̃��R�[�h���f�[�^�W�J�pHashMap(sourceMap)�ƌ�������B
        if (!claimList.isEmpty()) {
            getSourceMap().putAll((VRMap) claimList.getData(0));
        }
        // �f�[�^�W�J�pHashMap(sourceMap)���u�N���C�A���g�̈�icontents�j�v�ɐݒ肷��B
        getContents().setSource(getSourceMap());

        // [ID:0000435][Masahiko Higuchi] 2009/07 add begin �J�����_�[�Ɏ��т�ǂݍ��ދ@�\�̊g��
        // �쐬�p�̊Ǘ��}�b�v
        VRHashMap dateCreateManager = new VRHashMap();
        if(getClaimList() != null && !getClaimList().isEmpty() && getClaimList().getData(0) instanceof VRMap) {
            VRMap patientData = (VRMap)getClaimList().getData(0);
            // �L�[�ݒ�p�ϐ��𐶐�
            String markServiceName = "";
            String markServiceBitKey = "";
            String[] marks = QkanConstants.CLAIM_PATIENT_DETAIL_SERVICE_MARK;
            // �L���̐����[�v������
            for (int i = 1; i <= 7; i++) {
                markServiceName = "MARK" + ACCastUtilities.toString(i) +"_SERVICE_NAME";
                markServiceBitKey = "MARK" + ACCastUtilities.toString(i) +"_SERVICE_DATE_BIT";
                String markServiceNameVal = ACCastUtilities.toString(patientData.getData(markServiceName),"");
                // ���t���擾
                int bits = ACCastUtilities.toInt(patientData.getData(markServiceBitKey),0);
                // ���̂Ɠ�����񂪐���ȏꍇ�̂ݔ��f����
                if(!"".equals(markServiceNameVal)) {
                    // �񋟓��t��2�i�������o��
                    String dateBit = Integer.toBinaryString(bits);
                    int endIndex = dateBit.length();
                    // �ŏI�����擾���Ă���
                    int lastDay = ACDateUtilities.getLastDayOfMonth(getTargetDate());
                    int dayCount = 1;
                    // �Y�����̓��������[�v���s��
                    for (int j2 = 1; j2 <= lastDay; j2++) {
                        int dayFlag = 0;
                        // bit�̒����𒴂��Ȃ��悤�Ƀ`�F�b�N
                        if(endIndex>0) {
                            dayFlag = ACCastUtilities.toInt(dateBit.substring(endIndex-1,endIndex));
                            endIndex--;
                        }
                        // key�ɂ��邽�߂ɐ��l�𕶎���ɂ��Ă���
                        String dayString = ACCastUtilities.toString(dayCount);
                        // �J�����_�[�ɐݒ肷����̍쐬
                        // �`�F�b�N�{�b�N�X�A�L���A�T�[�r�X����
                        VRMap markRecord = new VRHashMap();
                        markRecord.setData("CHECK",new Boolean((dayFlag==1)));
                        markRecord.setData("MARK",marks[i-1]);
                        // �T�[�r�X����
                        markRecord.setData("SERVICE_NAME_COL",markServiceNameVal);
                        // �Y�����̃f�[�^�����ɍ쐬�ς݂��`�F�b�N
                        if(dateCreateManager.containsKey(dayString)) {
                            // �쐬�ς�
                            VRList calenderList = (VRList)dateCreateManager.getData(dayString);
                            calenderList.add(markRecord);
                            
                        } else {
                            // ���쐬
                            // �V�K�ǉ�
                            VRList newCalenderList = new VRArrayList();
                            newCalenderList.add(markRecord);
                            dateCreateManager.setData(dayString,newCalenderList);
                        }
                        
                        dayCount++;
                    }
                }
            }
        }
        // �R���|�[�l���g��S����
        for(int j=0; j< getContentCalendar().getComponentCount(); j++) {
            Component cmp = getContentCalendar().getComponent(j);
            // �e�[�u���̏ꍇ�̂ݏ�����
            if(cmp instanceof QP003ResultCalendar) {
                QP003ResultCalendar rc = (QP003ResultCalendar)cmp;
                // ���t��ݒ�
                rc.setData(dateCreateManager);
            }
        }
        // [ID:0000435][Masahiko Higuchi] 2009/07 add end
        
        // ��ʂɓW�J����B
        getContents().bindSource();

        // ���z�̍��v���Z�o����B
        calcSum();

        // [ID:0000435][Masahiko Higuchi] 2009/07 add begin �J�����_�[�Ɏ��т�ǂݍ��ދ@�\�̊g��
        // �J�����_�[�̈�̃X�i�b�v�V���b�g�����
        calenderSnapShot();
        // [ID:0000435][Masahiko Higuchi] 2009/07 add end
        // �X�i�b�v�V���b�g�̎B�e�Ώۂ��u�N���C�A���g�̈�icontents�j�v�Ɏw�肷��B
        getSnapshot().setRootContainer(getContents());
        // �X�i�b�v�V���b�g���B�e����B
        getSnapshot().snapshot();

    }

    /**
     * �u���p�Ҍ��������ڍ׏����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doFindClaimForPatient() throws Exception {
        // ���p�Ҍ��������ڍ׏����擾
        // SQL���擾�p��VRMap param�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
        VRMap param = new VRHashMap();
        // �EKEY�FPATIENT_ID VALUE�FpatientId
        // �EKEY�FTARGET_DATE VALUE�FtargetDate
        // �EKEY�FCLAIM_DATE VALUE�FclaimDate
        // �EKEY�FPROVIDER_ID VALUE�FproviderId
        // �EKEY�FCLAIM_STYLE_TYPE VALUE�FclaimDate
        // �EKEY�FCATEGORY_NO VALUE�F
        // �EKEY�FINSURED_ID VALUE�FinsuredId
        param.setData("PATIENT_ID", new Integer(getPatientId()));
        param.setData("TARGET_DATE", getTargetDate());
        param.setData("CLAIM_DATE", getClaimDate());
        param.setData("PROVIDER_ID", getProviderId());
        param.setData("CLAIM_STYLE_TYPE", new Integer(
                STYLE_TYPE_CLAIM_FOR_PATIENT));
        param
                .setData("CATEGORY_NO", new Integer(
                        CATEGORY_NO_CLAIM_FOR_PATIENT));
        param.setData("INSURED_ID", getInsuredId());
        // ���p�Ҍ��������ڍ׏����擾����SQL�����擾����B
        // �擾����SQL�������s���A�f�[�^��claimList�Ɋi�[����B
        setClaimList(getDBManager().executeQuery(
                getSQL_GET_CLAIM_PATIENT_DETAIL(param)));
        // claimList�̌�����0���̏ꍇ
        // if(getClaimList()!=null){
        if (getClaimList().size() <= 0) {
            // processMode �ɋ��ʒ萔��PROCESS_MODE_INSERT��������B
            setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
            // dataFlg ��0��������B
            setDataFlg(0);
            setState_INSERT_STATE();

        } else {
            // claimList�̌�����1���ȏ�̏ꍇ
            // claimList�̍ŏ��̃��R�[�h�����o���B
            VRMap map = (VRMap) getClaimList().getData(0);
            // ���o�������R�[�h��KEY�FCLAIM_ID�̒l��claimId�֑ޔ�����B
            setClaimId(ACCastUtilities.toInt(map.getData("CLAIM_ID")));

            setState_UPDATE_STATE();
            // ���o�������R�[�h��KEY�FDATA_FLAG�̒l���`�F�b�N����B
            if (map.getData("DATA_FLAG") == null) {
                // KEY�FDATA_FLAG�̒l��null �̏ꍇ
                // processMode �ɋ��ʒ萔��PROCESS_MODE_INSERT��������B
                setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
                // dataFlg ��1��������B
                setDataFlg(1);
            } else {
                // KEY�FDATA_FLAG�̒l��null �łȂ��ꍇ
                // processMode �ɋ��ʒ萔��PROCESS_MODE_UPDATE��������B
                setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
                // dataFlg �ɂP��������B
                setDataFlg(1);
            }
        }
        // claimList���p�b�V�u�`�F�b�N�p�ɑޔ�����B
        getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
                getClaimList());

    }

    /**
     * �u���v���z�̌v�Z�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void calcSum() throws Exception {
        // ���v���z�̌v�Z����
        int sum = 0;
        // ���L�̃t�B�[���h�̂����ꂩ�ɒl���\������Ă���ꍇ�A�t�B�[���h�̒l�̍��v���v�Z����B
        // �E�S�z���ȕ��S�����p���P�icontentJikohutanUse1�j
        if (!"".equals(getContentJikohutanUse1().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 �����l�Ή�
            sum += ACCastUtilities.toInt(getContentJikohutanUse1().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // �E�S�z���ȕ��S�����p���Q�icontentJikohutanUse2�j
        if (!"".equals(getContentJikohutanUse2().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 �����l�Ή�
            sum += ACCastUtilities.toInt(getContentJikohutanUse2().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // �E�S�z���ȕ��S�����p���R�icontentJikohutanUse3�j
        if (!"".equals(getContentJikohutanUse3().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 �����l�Ή�
            sum += ACCastUtilities.toInt(getContentJikohutanUse3().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // �v�Z���ʂ�S�z���ȕ��S���v�t�B�[���h�icontentJikohutanSubtotal�j�ɕ\������B
        getContentJikohutanSubtotal().setText(ACCastUtilities.toString(sum));
        // ���L�̃t�B�[���h�̂����ꂩ�ɒl���\������Ă���ꍇ�A�t�B�[���h�̒l�̍��v���v�Z����B
        int etcSum = 0;
        // �E���̑����p���P�icontentEtcUse1�j
        if (!"".equals(getContentEtcUse1().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 �����l�Ή�
            etcSum += ACCastUtilities.toInt(getContentEtcUse1().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // �E���̑����p���Q�icontentEtcUse2�j
        if (!"".equals(getContentEtcUse2().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 �����l�Ή�
            etcSum += ACCastUtilities.toInt(getContentEtcUse2().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // �E���̑����p���R�icontentEtcUse3�j
        if (!"".equals(getContentEtcUse3().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 �����l�Ή�
            etcSum += ACCastUtilities.toInt(getContentEtcUse3().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // �E���̑����p���S�icontentEtcUse4�j
        if (!"".equals(getContentEtcUse4().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 �����l�Ή�
            etcSum += ACCastUtilities.toInt(getContentEtcUse4().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // �E���̑����p���T�icontentEtcUse5�j
        if (!"".equals(getContentEtcUse5().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 �����l�Ή�
            etcSum += ACCastUtilities.toInt(getContentEtcUse5().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // 2007/11/30 [Masahiko Higuchi] add - begin Ver 5.4.1 ���p�Ҍ����������Ή�
        // �E���̑����p���U�icontentEtcUse5�j
        if (!"".equals(getContentEtcUse6().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 �����l�Ή�
            etcSum += ACCastUtilities.toInt(getContentEtcUse6().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }        
        // 2007/11/30 [Masahiko Higuchi] add - end
        
        // �v�Z���ʂ����̑���p���v�t�B�[���h�icontentEtcSubtotal�j�ɕ\������B
        getContentEtcSubtotal().setText(ACCastUtilities.toString(etcSum));
        // ���L�̃t�B�[���h�̒l��sum�����v���A���v�z�icontentTotalText�j�ɕ\������B
        sum = sum + etcSum;
        // �E�S�z���ȕ��S���v�t�B�[���h�icontentJikohutanSubtotal�j
        // �E���̑���p���v�t�B�[���h�icontentEtcSubtotal�j
        getContentTotalText().setText(ACCastUtilities.toString(sum));

        // ��Ô�T���̌v�Z
        calcKoujoPrice();
    }

    /**
     * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean doSave() throws Exception {
        // �ۑ�����
        // �g�����U�N�V�������J�n����B
        try {
            getDBManager().beginTransaction();

            // ��ʏ�̃f�[�^�̃`�F�b�N���s���B
            doCheckInput();

            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // �o�^���[�h�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�̏ꍇ�j
            	// �����p�҂̓����̃f�[�^���쐬����Ă��Ȃ����`�F�b�N����B
            	VRMap param = new VRHashMap();
            	VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));
            	VRBindPathParser.set("TARGET_DATE", param, getTargetDate());
            	VRBindPathParser.set("CLAIM_DATE", param, getClaimDate());
            	VRBindPathParser.set("PROVIDER_ID", param, getProviderId());
            	VRBindPathParser.set("CLAIM_STYLE_TYPE", param, new Integer(STYLE_TYPE_CLAIM_FOR_PATIENT));
            	VRBindPathParser.set("CATEGORY_NO", param, new Integer(CATEGORY_NO_CLAIM_FOR_PATIENT));
            	VRList list = getDBManager().executeQuery(getSQL_GET_NEW_CLAIM_PATIENT_DETAIL(param));
                // [Masahiko Higuchi] edit - begin 2007�N�x�Ή� ���яW�v�ɂđS�z���ȕ��S�쐬���Ƀf�[�^�쐬�̉\�������邽�߃`�F�b�N
            	if(!list.isEmpty()&&getDataFlg()==0){
                // [Masahiko Higuchi] edit - end
                    //�e�[�u�����b�N�����̂��߃��[���o�b�N
                    getDBManager().rollbackTransaction();
                    // �G���[���b�Z�[�W��\������B
                    QkanMessageList.getInstance()
                            .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                    // �E���b�Z�[�WID�FERROR_OF_PASSIVE_CHECK_ON_UPDATE
            		return false;
            	}
                // �i�I���j
            }else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // �X�V���[�h�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�̏ꍇ�j
                // �p�b�V�u�`�F�b�N�̃^�X�N���N���A����B
                // clearPassiveTask();
                getPassiveChecker().clearPassiveTask();
                // �p�b�V�u�`�F�b�N�����L�̃p�b�V�u�L�[�ōs���B
                // addPassiveDeleteTask();
                // �EPASSIVE_CHECK_KEY
                getPassiveChecker()
                        .addPassiveUpdateTask(getPASSIVE_CHECK_KEY());
                // �p�b�V�u�G���[�����������ꍇ
                if (!getPassiveChecker().passiveCheck(getDBManager())) {
                    //�e�[�u�����b�N�����̂��߃��[���o�b�N
                    getDBManager().rollbackTransaction();
                    // �G���[���b�Z�[�W��\������B
                    QkanMessageList.getInstance()
                            .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                    // �E���b�Z�[�WID�FERROR_OF_PASSIVE_CHECK_ON_UPDATE
                    return false;
                    // �i�I���j
                }
            }
            // CLAIM�e�[�u���̍X�V
            // dataFlg ��0�̏ꍇ
            if (getDataFlg() == 0) {
                // �V����CLAIM_ID���擾����B
                // getBookingNumber(CLAIM, CLAIM_ID, 1);
                // �擾����CLAIM_ID��claimId�ɑޔ�����B
                setClaimId(QkanCommon.getBookingNumber(getDBManager(), "CLAIM",
                        "CLAIM_ID", 1));
                // SQL���擾�p��VRMap param�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
                VRMap param = new VRHashMap();
                // �EKEY�FCLAIM_ID VALUE�FclaimId
                // �EKEY�FCLAIM_STYLE_TYPE VALUE�FSTYLE_TYPE_CLAIM_FOR_PATIENT
                // �EKEY�FCATEGORY_NO VALUE�FCATEGORY_NO_CLAIM_FOR_PATIENT
                // �EKEY�FPATIENT_ID VALUE�FpatientId
                // �EKEY�FINSURED_ID VALUE�FinsuredId
                // �EKEY�FTARGET_DATE VALUE�FtargetDate
                // �EKEY�FCLAIM_DATE VALUE�FclaimDate
                // �EKEY�FINSURER_ID VALUE�FinsurerId
                // �EKEY�FPROVIDER_ID VALUE�FproviderId
                // �EKEY�FCLAIM_FINISH_FLAG VALUE�F0
                param.setData("CLAIM_ID", new Integer(getClaimId()));
                param.setData("CLAIM_STYLE_TYPE", new Integer(
                        STYLE_TYPE_CLAIM_FOR_PATIENT));
                param.setData("CATEGORY_NO", new Integer(
                        CATEGORY_NO_CLAIM_FOR_PATIENT));
                param.setData("PATIENT_ID", new Integer(getPatientId()));
                param.setData("INSURED_ID", getInsuredId());
                param.setData("TARGET_DATE", getTargetDate());
                param.setData("CLAIM_DATE", getClaimDate());
                param.setData("INSURER_ID", getInsurerId());
                param.setData("PROVIDER_ID", getProviderId());
                param.setData("CLAIM_FINISH_FLAG", new Integer(0));

                // param�������Ƃ��āASQL�����擾����B
                // SQL�������s����B
                getDBManager().executeUpdate(getSQL_INSERT_CLAIM(param));
            }

            VRMap param = new VRHashMap();
            // PATIENT_CLAIM_DETAIL�e�[�u���̍X�V
            // ��ʏ�̃f�[�^���擾����B
            // applySource(contents);
            getContents().setSource(param);
            getContents().applySource();
            // ��ʏ�̃f�[�^���i�[���Ă���VRMap�i�ȉ��Aparam�j�Ɉȉ���KEY/VALUE��ݒ肷��B;
            // �EKEY�FCLAIM_ID VALUE�FclaimId
            param.setData("CLAIM_ID", new Integer(getClaimId()));
            // �o�^���[�h�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_INSERT�̏ꍇ�j
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // param�������Ƃ��āASQL�����擾����B
                // SQL�������s����B
                getDBManager().executeUpdate(
                        getSQL_INSERT_CLAIM_PATIENT_DETAIL(param));
            } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // �X�V���[�h�̏ꍇ�iprocessMode�����ʒ萔��PROCESS_MODE_UPDATE�̏ꍇ�j
                // param�������Ƃ��āASQL�����擾����B
                // [ID:0000435][Masahiko Higuchi] 2009/07 add begin �J�����_�[�Ɏ��т�ǂݍ��ދ@�\�̊g��
                // �J�����_�[�f�[�^����������
                VRMap dateBitMap = getCalenderBitData();
                if(dateBitMap != null) {
                    param.putAll(dateBitMap);
                }
                // [ID:0000435][Masahiko Higuchi] 2009/07 add end
                // SQL�������s����B
                getDBManager().executeUpdate(
                        getSQL_UPDATE_CLAIM_PATIENT_DETAIL(param));
            }

            // FIXED_FORM�e�[�u���̍X�V
            // ��ʏ�̃f�[�^�̂�o�^�p�ɐU�蕪����B
            // �����ȕ��S���T�[�r�X
            // ��ʏ�̃f�[�^���A�ȉ��̒l���擾���AVRList selfList�ɒǉ�����B
            VRList selfList = new VRArrayList();
            // �ESELF_SERVICE_NO1
            // �ESELF_SERVICE_NO2
            // �ESELF_SERVICE_NO3
            selfList.add(param.getData("SELF_SERVICE_NO1"));
            selfList.add(param.getData("SELF_SERVICE_NO2"));
            selfList.add(param.getData("SELF_SERVICE_NO3"));

            // �����̑����
            // ��ʏ�̃f�[�^���A�ȉ��̒l���擾���AVRList otherList�ɒǉ�����B
            VRList otherList = new VRArrayList();
            // �EOTHER_HIMOKU_NO1
            // �EOTHER_HIMOKU_NO2
            // �EOTHER_HIMOKU_NO3
            // �EOTHER_HIMOKU_NO4
            // �EOTHER_HIMOKU_NO5
            otherList.add(param.getData("OTHER_HIMOKU_NO1"));
            otherList.add(param.getData("OTHER_HIMOKU_NO2"));
            otherList.add(param.getData("OTHER_HIMOKU_NO3"));
            otherList.add(param.getData("OTHER_HIMOKU_NO4"));
            otherList.add(param.getData("OTHER_HIMOKU_NO5"));
            // 2007/11/30 [Masahiko Higuchi] add - begin Ver 5.4.1 ���p�Ҍ����������Ή�
            otherList.add(param.getData("OTHER_HIMOKU_NO6"));
            // 2007/11/30 [Masahiko Higuchi] add - end
            // SQL���擾�p��HashMap param�𐶐�����B
            VRMap params = new VRHashMap();
            // �����ȕ��S�T�[�r�X�̓o�^
            for (int i = 0; i < selfList.size(); i++) {
                // selfList�̌��������[�v����B
                if (!"".equals(selfList.getData(i))) {
                    // param�����������A�ȉ���KEY/VALUE��ݒ肷��B
                    param = new VRHashMap();
                    // �EKEY�FFIXED_FORM_ID VALUE�F1
                    // �EKEY�FCONTENT VALUE�FselfList�̒l
                    param.setData("FIXED_FORM_ID", new Integer(1));
                    param.setData("CONTENT", selfList.getData(i));
                    // �I�����Ƃ��Ċ��Ƀe�[�u���ɑ��݂��邩�ǂ����m�F����SQL�����擾����B
                    // SQL�������s����B
                    VRList countList = getDBManager().executeQuery(
                            getSQL_GET_COUNT_SELF_PAY(param));
                    VRMap map = (VRMap) countList.getData(0);
                    // �擾����������0���̏ꍇ
                    if (ACCastUtilities.toInt(map.getData("CONTENT_SELF_PAY")) == 0) {
                        // param�����������A�ȉ���KEY/VALUE��ݒ肷��B
                        param = new VRHashMap();
                        // �EKEY�FFIXED_FORM_ID VALUE�F1
                        param.setData("FIXED_FORM_ID", new Integer(1));
                        // �o�^�Ɏg�p����CONTENT_KEY���擾���邽�߂�SQL�����擾����B
                        // SQL�������s����B
                        countList = getDBManager().executeQuery(
                                getSQL_GET_NEW_CONTENT_KEY(param));

                        VRMap contentKeyMap = (VRMap) countList.getData(0);
                        // �o�^�Ɏg�p����CONTENT_SORT���擾���邽�߂�SQL�����擾����B
                        // SQL�������s����B
                        countList = getDBManager().executeQuery(
                                getSQL_GET_NEW_CONTENT_SORT(param));
                        VRMap contentSortMap = (VRMap) countList.getData(0);

                        // param�����������A�ȉ���KEY/VALUE��ݒ肷��B
                        // �EKEY�FTABLE_TYPE VALUE�F1
                        // �EKEY�FFIXED_FORM_ID VALUE�F1
                        // �EKEY�FCONTENT_KEY VALUE�F�i�擾�����V����CONTENT_KEY�j
                        // �EKEY�FCONTENT VALUE�F�iselfList�̒l�j
                        // �EKEY�FCONTENT_SORT VALUE�F�i�擾�����V����CONTENT_SORT�j
                        param = new VRHashMap();
                        param.setData("TABLE_TYPE", new Integer(1));
                        param.setData("FIXED_FORM_ID", new Integer(1));
                        param.setData("CONTENT_KEY", contentKeyMap
                                .getData("NEW_CONTENT_KEY"));
                        param.setData("CONTENT", selfList.getData(i));
                        param.setData("CONTENT_SORT", contentSortMap
                                .getData("NEW_CONTENT_SORT"));

                        // ��^���o�^�pSQL�����擾����B
                        // SQL�������s����B
                        getDBManager().executeUpdate(
                                getSQL_INSERT_FIXED_FORM(param));
                    }
                }
            }

            // �����̑���ڂ̓o�^
            // otherList�̌��������[�v����B
            for (int j = 0; j < otherList.size(); j++) {
                if (!"".equals(otherList.getData(j))) {
                    // param�����������A�ȉ���KEY/VALUE��ݒ肷��B
                    // �EKEY�FFIXED_FORM_ID VALUE�F2
                    // �EKEY�FCONTENT VALUE�FotherList�̒l
                    param = new VRHashMap();
                    param.setData("FIXED_FORM_ID", new Integer(2));
                    param.setData("CONTENT", otherList.getData(j));
                    // �I�����Ƃ��Ċ��Ƀe�[�u���ɑ��݂��邩�ǂ����m�F����SQL�����擾����B
                    // SQL�������s����B
                    VRList countList = getDBManager().executeQuery(
                            getSQL_GET_COUNT_SELF_PAY(param));
                    VRMap checkMap = (VRMap) countList.getData(0);
                    // �擾����������0���̏ꍇ
                    if (ACCastUtilities.toInt(checkMap
                            .getData("CONTENT_SELF_PAY")) == 0) {
                        // param�����������A�ȉ���KEY/VALUE��ݒ肷��B
                        param = new VRHashMap();
                        // �EKEY�FFIXED_FORM_ID VALUE�F2
                        param.setData("FIXED_FORM_ID", new Integer(2));
                        // �o�^�Ɏg�p����CONTENT_KEY���擾���邽�߂�SQL�����擾����B
                        // SQL�������s����B
                        VRList contentKeyList = getDBManager().executeQuery(
                                getSQL_GET_NEW_CONTENT_KEY(param));
                        VRMap contentKeyMap = (VRMap) contentKeyList.getData(0);
                        // �o�^�Ɏg�p����CONTENT_SORT���擾���邽�߂�SQL�����擾����B
                        // SQL�������s����B
                        VRList contentSortList = getDBManager().executeQuery(
                                getSQL_GET_NEW_CONTENT_SORT(param));
                        VRMap contentSortMap = (VRMap) contentSortList
                                .getData(0);

                        // param�����������A�ȉ���KEY/VALUE��ݒ肷��B
                        // �EKEY�FTABLE_TYPE VALUE�F1
                        // �EKEY�FFIXED_FORM_ID VALUE�F2
                        // �EKEY�FCONTENT_KEY VALUE�F�i�擾�����V����CONTENT_KEY�j
                        // �EKEY�FCONTENT VALUE�F�iselfList�̒l�j
                        // �EKEY�FCONTENT_SORT VALUE�F�i�擾�����V����CONTENT_SORT�j
                        param = new VRHashMap();
                        param.setData("TABLE_TYPE", new Integer(1));
                        param.setData("FIXED_FORM_ID", new Integer(2));
                        param.setData("CONTENT_KEY", contentKeyMap
                                .getData("NEW_CONTENT_KEY"));
                        param.setData("CONTENT", otherList.getData(j));
                        param.setData("CONTENT_SORT", contentSortMap
                                .getData("NEW_CONTENT_SORT"));
                        // ��^���o�^�pSQL�����擾����B
                        // SQL�������s����B
                        getDBManager().executeUpdate(
                                getSQL_INSERT_FIXED_FORM(param));
                    }
                }
            }
            // �R�~�b�g/���[���o�b�N
            // �X�V�ɐ��������ꍇ
            // �R�~�b�g����B
            getDBManager().commitTransaction();

        } catch (Exception ex) {
            // �X�V�Ɏ��s�����ꍇ
            ex.printStackTrace();
            // ���[���o�b�N���s���B
            getDBManager().rollbackTransaction();
            // ��O�𓊂���B
            throw ex;
            // �i�I���j

        }

        // �R���{���Ď�荞��
        comboInitialize();
        // �ŐV�̃f�[�^���擾���A�p�b�V�u�`�F�b�N�p�ɑޔ�����B
        doFind();
        // ����I��
        return true;

    }

    /**
     * �u��ʃf�[�^�`�F�b�N�E�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doCheckInput() throws Exception {
        // ��ʃf�[�^�`�F�b�N�E�ҏW
        // �S�z���ȕ��S1���
        // �S�z���ȕ��S����ڂP�icontentJikohutanHimoku1�j���󕶎��̏ꍇ
        // �S�z���ȕ��S�����p���P�icontentJikohutanUse1�j���󕶎��łȂ��ꍇ
        // �S�z���ȕ��S�����p���P�icontentJikohutanUse1�j��0��������B
        // �S�z���ȕ��S����ڂP�icontentJikohutanHimoku1�j���󕶎��łȂ��ꍇ
        // �S�z���ȕ��S�����p���P�icontentJikohutanUse1�j���󕶎��̏ꍇ
        // �S�z���ȕ��S����ڂP�icontentJikohutanHimoku1�j���󕶎���������B
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 ���p�Ҍ��������� �ȈՔŔőΉ�
        checkValue(getContentJikohutanHimoku1(), getContentJikohutanUse1(),
                null, null);
        // 2007/11/26 [Masahiko Higuchi] edit - end
        
        // �S�z���ȕ��S2���
        // �S�z���ȕ��S����ڂQ�icontentJikohutanHimoku2�j���󕶎��̏ꍇ
        // �S�z���ȕ��S�����p���Q�icontentJikohutanUse2�j���󕶎��łȂ��ꍇ
        // �S�z���ȕ��S�����p���Q�icontentJikohutanUse2�j��0��������B
        // �S�z���ȕ��S����ڂQ�icontentJikohutanHimoku2�j���󕶎��łȂ��ꍇ
        // �S�z���ȕ��S�����p���Q�icontentJikohutanUse2�j���󕶎��̏ꍇ
        // �S�z���ȕ��S����ڂQ�icontentJikohutanHimoku2�j���󕶎���������B
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 ���p�Ҍ��������� �ȈՔŔőΉ�
        checkValue(getContentJikohutanHimoku2(), getContentJikohutanUse2(),
                null, null);
        // 2007/11/26 [Masahiko Higuchi] edit - end
        
        // �S�z���ȕ��S3���
        // �S�z���ȕ��S����ڂR�icontentJikohutanHimoku3�j���󕶎��̏ꍇ
        // �S�z���ȕ��S�����p���R�icontentJikohutanUse3�j���󕶎��łȂ��ꍇ
        // �S�z���ȕ��S�����p���R�icontentJikohutanUse3�j��0��������B
        // �S�z���ȕ��S����ڂR�icontentJikohutanHimoku3�j���󕶎��łȂ��ꍇ
        // �S�z���ȕ��S�����p���R�icontentJikohutanUse3�j���󕶎��̏ꍇ
        // �S�z���ȕ��S����ڂR�icontentJikohutanHimoku3�j���󕶎���������B
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 ���p�Ҍ��������� �ȈՔŔőΉ�
        checkValue(getContentJikohutanHimoku3(), getContentJikohutanUse3(),
                null, null);
        // 2007/11/26 [Masahiko Higuchi] edit - end
        
        // ���̑����1���
        // ���̑���ڂP�icontentEtcHimoku1�j���󕶎��̏ꍇ
        // ���̑����p���P�icontentEtcUse1�j���󕶎��łȂ��ꍇ
        // ���̑����p���P�icontentEtcUse1�j��0��������B
        // ���̑���ڂP�icontentEtcHimoku1�j���󕶎��łȂ��ꍇ
        // ���̑����p���P�icontentEtcUse1�j���󕶎��̏ꍇ
        // ���̑���ڂP�icontentEtcHimoku1�j���󕶎���������B
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 ���p�Ҍ��������� �ȈՔŔőΉ�
        checkValue(getContentEtcHimoku1(), getContentEtcUse1(),
                getContentEtcUnit1(), getContentEtcCount1());
        // 2007/11/26 [Masahiko Higuchi] edit - end
        
        // ���̑����2���
        // ���̑���ڂQ�icontentEtcHimoku2�j���󕶎��̏ꍇ
        // ���̑����p���Q�icontentEtcUse2�j���󕶎��łȂ��ꍇ
        // ���̑����p���Q�icontentEtcUse2�j��0��������B
        // ���̑���ڂQ�icontentEtcHimoku2�j���󕶎��łȂ��ꍇ
        // ���̑����p���Q�icontentEtcUse2�j���󕶎��̏ꍇ
        // ���̑���ڂQ�icontentEtcHimoku2�j���󕶎���������B
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 ���p�Ҍ��������� �ȈՔŔőΉ�
        checkValue(getContentEtcHimoku2(), getContentEtcUse2(),
                getContentEtcUnit2(), getContentEtcCount2());
        // 2007/11/26 [Masahiko Higuchi] edit - end
        
        // ���̑����3���
        // ���̑���ڂR�icontentEtcHimoku3�j���󕶎��̏ꍇ
        // ���̑����p���R�icontentEtcUse3�j���󕶎��łȂ��ꍇ
        // ���̑����p���R�icontentEtcUse3�j��0��������B
        // ���̑���ڂR�icontentEtcHimoku3�j���󕶎��łȂ��ꍇ
        // ���̑����p���R�icontentEtcUse3�j���󕶎��̏ꍇ
        // ���̑���ڂR�icontentEtcHimoku3�j���󕶎���������B
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 ���p�Ҍ��������� �ȈՔŔőΉ�
        checkValue(getContentEtcHimoku3(), getContentEtcUse3(),
                getContentEtcUnit3(), getContentEtcCount3());
        // 2007/11/26 [Masahiko Higuchi] edit - end
        
        // ���̑����4���
        // ���̑���ڂS�icontentEtcHimoku4�j���󕶎��̏ꍇ
        // ���̑����p���S�icontentEtcUse4�j���󕶎��łȂ��ꍇ
        // ���̑����p���S�icontentEtcUse4�j��0��������B
        // ���̑���ڂS�icontentEtcHimoku4�j���󕶎��łȂ��ꍇ
        // ���̑����p���S�icontentEtcUse4�j���󕶎��̏ꍇ
        // ���̑���ڂS�icontentEtcHimoku4�j���󕶎���������B
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 ���p�Ҍ��������� �ȈՔŔőΉ�
        checkValue(getContentEtcHimoku4(), getContentEtcUse4(),
                getContentEtcUnit4(), getContentEtcCount4());
        // 2007/11/26 [Masahiko Higuchi] edit - end
        
        // ���̑����5���
        // ���̑���ڂT�icontentEtcHimoku5�j���󕶎��̏ꍇ
        // ���̑����p���T�icontentEtcUse5�j���󕶎��łȂ��ꍇ
        // ���̑����p���T�icontentEtcUse5�j��0��������B
        // ���̑���ڂT�icontentEtcHimoku5�j���󕶎��łȂ��ꍇ
        // ���̑����p���T�icontentEtcUse5�j���󕶎��̏ꍇ
        // ���̑���ڂT�icontentEtcHimoku5�j���󕶎���������B
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 ���p�Ҍ��������� �ȈՔŔőΉ�
        checkValue(getContentEtcHimoku5(), getContentEtcUse5(),
                getContentEtcUnit5(), getContentEtcCount5());
        // 2007/11/26 [Masahiko Higuchi] edit - end

        // 2007/11/30 [Masahiko Higuchi] add - begin V5.4.1 ���p�Ҍ��������� �ȈՔŔőΉ�
        // ���̑��@6���
        checkValue(getContentEtcHimoku6(), getContentEtcUse6(),
                getContentEtcUnit6(), getContentEtcCount6());        
        // 2007/11/30 [Masahiko Higuchi] add - end
        
        calcSum();

    }

    /**
     * �R���{�̒l���`�F�b�N���܂��B
     * 
     * @param himokuCombo
     * @param jikohutanText
     * @throws Exception
     * @version V5.4.1 2007/11/26 [Masahiko Higuchi] edit - begin ���p�Ҍ��������� �ȈՔŔőΉ�
     */
    public void checkValue(ACComboBox himokuCombo, ACTextField jikohutanText,ACTextField unitText,ACTextField countText)
            throws Exception {
        
        // 2008/06/09 [Masahiko Higuchi] add - begin V5.4.1 ���p�Ҍ����������Ή�
        // �P�ʐ��Ɖ񐔂����݂��Ȃ��`�F�b�N�̏ꍇ�i�S�z���ȕ��S�p�j
        if(unitText == null || countText == null){
            // ���l�̕s���G���[�΍�
            if("-".equals(jikohutanText.getText())){
                // "-"�݂̂͋����Ȃ�
                jikohutanText.setText("");
            }
            // 2008/06/09 [Masahiko Higuchi] add - end
            // �S�z���ȕ��S�����(himokuCombo)���󕶎��̏ꍇ
            if ("".equals(himokuCombo.getText())) {
                // �S�z���ȕ��S�����p���ijikohutanText�j���󕶎��łȂ��ꍇ
                if (!"".equals(jikohutanText.getText())) {
                    // �S�z���ȕ��S�����p���P�ijikohutanText�j��0��������B
                    jikohutanText.setText("");
                }
            }
            // �S�z���ȕ��S����ځihimokuCombo�j���󕶎��łȂ��ꍇ
            if (!"".equals(himokuCombo.getText())) {
                // �S�z���ȕ��S�����p���ijikohutanText�j���󕶎��̏ꍇ
                if ("".equals(jikohutanText.getText())) {
                    // �S�z���ȕ��S����ڂP�ihimokuCombo�j���󕶎���������B
                    himokuCombo.setText("");
                }
            }
            
        // 2008/06/09 [Masahiko Higuchi] add - begin V5.4.1 ���p�Ҍ����������Ή�
        }else{
            // "-"�݂̂͋����Ȃ�
            if("-".equals(jikohutanText.getText())){
                // ���p�ҕ��S
                jikohutanText.setText("");
            }
            if("-".equals(unitText.getText())){
                // �P�ʐ�
                unitText.setText("");
            }
            if("-".equals(countText.getText())){
                // ��
                countText.setText("");
            }
            // ���̑����p���̃`�F�b�N
            if ("".equals(himokuCombo.getText())) {
                // �S�z���ȕ��S�����p���ijikohutanText�j���󕶎��łȂ��ꍇ
                if (!"".equals(jikohutanText.getText())
                        || !"".equals(unitText.getText())
                        || !"".equals(countText.getText())) {
                    // �S�z���ȕ��S�����p���P�ijikohutanText�j��0��������B
                    jikohutanText.setText("");
                    unitText.setText("");
                    countText.setText("");
                }
            }
            // �S�z���ȕ��S����ځihimokuCombo�j���󕶎��łȂ��ꍇ
            if (!"".equals(himokuCombo.getText())) {
                // �S�z���ȕ��S�����p���ijikohutanText�j���󕶎��̏ꍇ
                // ���z�������S�ċ󔒂̏ꍇ�͍��ږ����N���A����
                if ("".equals(jikohutanText.getText())
                        && "".equals(unitText.getText())
                        && "".equals(countText.getText())) {
                    // �S�z���ȕ��S����ڂP�ihimokuCombo�j���󕶎���������B
                    himokuCombo.setText("");
                }
            }
        }
        // 2008/06/09 [Masahiko Higuchi] add - end

    }

    /**
     * �R���{�̏����ݒ���s���܂��B
     */
    public void comboInitialize() throws Exception {

        // �R���{�̑I���������擾���邽�߂�SQL�����擾����B
        // �R���{�̑I���������擾����
        VRList list = getDBManager()
                .executeQuery(getSQL_GET_COMBO_DETAIL(null));
        // �擾�����f�[�^�̌��������[�v����B
        // VRList fixedForm1List = new VRArrayList();
        // VRList fixedForm2List = new VRArrayList();
        setComboSet1(new VRArrayList());
        setComboSet2(new VRArrayList());
        for (int i = 0; i < list.size(); i++) {
            VRMap map = (VRMap) list.getData(i);
            // ���R�[�h��FIXED_FORM_ID�̒l���A1�̏ꍇ
            if (new Integer(1).equals(map.getData("FIXED_FORM_ID"))) {
                // ���R�[�h��CONTENT�̒l��comboSet1�ɒǉ�����B
                getComboSet1().add(map.getData("CONTENT"));
            } else if (new Integer(2).equals(map.getData("FIXED_FORM_ID"))) {
                // ���R�[�h��FIXED_FORM_ID�̒l���A2�̏ꍇ
                // ���R�[�h��CONTENT�̒l��comboSet2�ɒǉ�����B
                getComboSet2().add(map.getData("CONTENT"));
            }
        }

        // �R���{�̑I���������L��KEY�ŁAmodelMap�ɐݒ肷��B
        VRMap modelMap = new VRHashMap();
        // �EcomboSet1 KEY�FSELF_PAY
        if (getComboSet1() != null) {
            modelMap.setData("SELF_PAY", getComboSet1());
        }

        // �EcomboSet2 KEY�FOTHER
        if (getComboSet2() != null) {
            modelMap.setData("OTHER", getComboSet2());
        }

        setModelMap(modelMap);
        // modelMap���u�N���C�A���g�̈�icontents�j�v�ɐݒ肷��B
        getContents().setModelSource(getModelMap());

        // modelMap����ʂɓW�J����B
        getContents().bindModelSource();

    }

    /**
     * ���p�Ҍ����������O���Ǎ��݂Ɋւ��鏈���ł��B
     */
    protected void openActionPerformed(ActionEvent e) throws Exception {
        // �\�h���Ή�
        // 2006/06/05
        // ���������s�m�F
        // �������s�̊m�F�̂��߁A���b�Z�[�W��\������B�����b�Z�[�WID =
        // QC001_WARNING_ON_READ_OF_MOST_NEW_DATA
        int msgID = QkanMessageList.getInstance()
                .QC001_WARNING_ON_READ_OF_MOST_NEW_DATA();

        // �OK�v�I����
        // �������p������B
        if (msgID == ACMessageBox.RESULT_CANCEL) {
            // �u�L�����Z���v�I����
            // �����𒆒f����B
            return;
        }

        VRMap sqlParam = new VRHashMap();
        // SQL���Ŏg�p����p�����[�^�[���i�[����B
        sqlParam.setData("PATIENT_ID",ACCastUtilities.toInteger(getPatientId()));
        sqlParam.setData("TARGET_DATE",getTargetDate());
        sqlParam.setData("PROVIDER_ID",getProviderId());
        sqlParam.setData("INSURER_ID",getInsurerId());
        sqlParam.setData("INSURED_ID",getInsuredId());
        // �����e�[�u�����ߋ��̒��߂̃f�[�^�� CLAIM_ID ���擾����B
        VRList lastClaimPatientNo = getDBManager().executeQuery(
                getSQL_GET_LAST_CLAIM_NO(sqlParam));
        
        // ���ʂ��Ԃ��Ă����ꍇ
        if(!lastClaimPatientNo.isEmpty()){
            VRMap map = (VRMap)lastClaimPatientNo.getData(0);
            // CLAIM_ID���i�[����B
            String lastClaimId = ACCastUtilities.toString(map
                    .getData("CLAIM_ID"));
            
            sqlParam = new VRHashMap();
            // �擾����CLAIM_ID�� PATIENT_CLAIM_DETAIL�e�[�u�� ����f�[�^���擾����B
            sqlParam.setData("CLAIM_ID",lastClaimId);
            VRList lastClaimPatient =  getDBManager().executeQuery(
                    getSQL_GET_LAST_CLAIM_PATIENT(sqlParam));
            // �ߋ��̃f�[�^���擾�ł����ꍇ
            if(!lastClaimPatient.isEmpty()){
                // �擾�����f�[�^�� contents �ɐݒ肷��B
                getContents().setSource((VRMap)lastClaimPatient.getData(0));
                // �f�[�^�� contents �ɓW�J����B
                getContents().bindSource();
                // �Čv�Z�������s���B
                calcSum();
            }else{
                // ������擾�ł��Ȃ������ꍇ�̏���
                // �f�[�^�����݂��Ȃ��������Ƃ�\�����b�Z�[�W��\��
                QkanMessageList.getInstance().QC001_NOTICE_HAS_NO_LAST_DATA();
                // �������I������B�i�����s��Ȃ��j
                return;
            }
            
        }else{
            // �f�[�^�����݂��Ȃ��������Ƃ�\�����b�Z�[�W��\��
            QkanMessageList.getInstance().QC001_NOTICE_HAS_NO_LAST_DATA();
            // �������I������B�i�����s��Ȃ��j
            return;
        }
        
    }
    /**
     * ���ږ��̌v�Z�����ł��B
     */
    protected void contentEtcUnit1FocusLost(FocusEvent e) throws Exception {
        // ���z�v�Z����
        doCalcUnitPrice(getContentEtcUnit1(), getContentEtcCount1(),
                getContentEtcUse1());
        // ���v�z�̌v�Z����
        calcSum();
        
    }
    /**
     * ���ږ��̌v�Z�����ł��B
     */
    protected void contentEtcCount1FocusLost(FocusEvent e) throws Exception {
        // ���z�v�Z����
        doCalcUnitPrice(getContentEtcUnit1(), getContentEtcCount1(),
                getContentEtcUse1());
        // ���v�z�̌v�Z����
        calcSum();
    }
    /**
     * ���ږ��̌v�Z�����ł��B
     */
    protected void contentEtcUnit2FocusLost(FocusEvent e) throws Exception {
        // ���z�v�Z����
        doCalcUnitPrice(getContentEtcUnit2(), getContentEtcCount2(),
                getContentEtcUse2());
        // ���v�z�̌v�Z����
        calcSum();
    }
    /**
     * ���ږ��̌v�Z�����ł��B
     */
    protected void contentEtcCount2FocusLost(FocusEvent e) throws Exception {
        // ���z�v�Z����
        doCalcUnitPrice(getContentEtcUnit2(), getContentEtcCount2(),
                getContentEtcUse2());
        // ���v�z�̌v�Z����
        calcSum();
    }
    /**
     * ���ږ��̌v�Z�����ł��B
     */
    protected void contentEtcUnit3FocusLost(FocusEvent e) throws Exception {
        // ���z�v�Z����
        doCalcUnitPrice(getContentEtcUnit3(), getContentEtcCount3(),
                getContentEtcUse3());
        // ���v�z�̌v�Z����
        calcSum();
    }
    /**
     * ���ږ��̌v�Z�����ł��B
     */
    protected void contentEtcCount3FocusLost(FocusEvent e) throws Exception {
        // ���z�v�Z����
        doCalcUnitPrice(getContentEtcUnit3(), getContentEtcCount3(),
                getContentEtcUse3());
        // ���v�z�̌v�Z����
        calcSum();
    }
    /**
     * ���ږ��̌v�Z�����ł��B
     */
    protected void contentEtcUnit4FocusLost(FocusEvent e) throws Exception {
        // ���z�v�Z����
        doCalcUnitPrice(getContentEtcUnit4(), getContentEtcCount4(),
                getContentEtcUse4());
        // ���v�z�̌v�Z����
        calcSum();
    }
    /**
     * ���ږ��̌v�Z�����ł��B
     */
    protected void contentEtcCount4FocusLost(FocusEvent e) throws Exception {
        // ���z�v�Z����
        doCalcUnitPrice(getContentEtcUnit4(), getContentEtcCount4(),
                getContentEtcUse4());
        // ���v�z�̌v�Z����
        calcSum();
    }
    /**
     * ���ږ��̌v�Z�����ł��B
     */
    protected void contentEtcUnit5FocusLost(FocusEvent e) throws Exception {
        // ���z�v�Z����
        doCalcUnitPrice(getContentEtcUnit5(), getContentEtcCount5(),
                getContentEtcUse5());
        // ���v�z�̌v�Z����
        calcSum();
    }
    /**
     * ���ږ��̌v�Z�����ł��B
     */
    protected void contentEtcCount5FocusLost(FocusEvent e) throws Exception {
        // ���z�v�Z����
        doCalcUnitPrice(getContentEtcUnit5(), getContentEtcCount5(),
                getContentEtcUse5());
        // ���v�z�̌v�Z����
        calcSum();
    }
    /**
     * �P���Ɛ��ʂɂ��v�Z�������s���܂��B
     * 
     * @param �P�ʐ��e�L�X�g
     * @param ���ʁi�񐔁j�e�L�X�g
     * @param �v�Z���ʊi�[��e�L�X�g
     * @since V5.3.8
     * @author Masahiko Higuchi
     */
    public void doCalcUnitPrice(ACTextField unit, ACTextField count,
            ACTextField price) throws Exception {
        if (ACTextUtilities.isNullText(unit)
                || ACTextUtilities.isNullText(count)) {
            // null�������͋󔒂̏ꍇ�͏����𒆒f
            return;
        }
        // �v�Z���ʂ�ݒ肷��B
        price.setText(ACCastUtilities.toString(ACCastUtilities.toInt(unit
                .getText(),0)
                * ACCastUtilities.toInt(count.getText(),0), ""));

    }
    /**
     * ���v�z�v�Z����
     */
    protected void contentEtcUse6FocusLost(FocusEvent e) throws Exception {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        calcSum();
    }
    /**
     * ���ږ��̌v�Z�����ł��B
     */
    protected void contentEtcUnit6FocusLost(FocusEvent e) throws Exception {
        // ���z�v�Z����
        doCalcUnitPrice(getContentEtcUnit6(), getContentEtcCount6(),
                getContentEtcUse6());
        // ���v�z�̌v�Z����
        calcSum();
        
    }
    /**
     * ���ږ��̌v�Z�����ł��B
     */
    protected void contentEtcCount6FocusLost(FocusEvent e) throws Exception {
        // ���z�v�Z����
        doCalcUnitPrice(getContentEtcUnit6(), getContentEtcCount6(),
                getContentEtcUse6());
        // ���v�z�̌v�Z����
        calcSum();
        
    }

    /**
     * �^�u�I�����̃C�x���g�ł��B
     * 
     * @author Masahiko Higuchi
     * @since V5.4.9
     */
    protected void tabsStateChanged(ChangeEvent e) throws Exception {
        if(getTabs().getSelectedIndex() == 1) {
            // �J�����_�[�^�u�I����
            setState_CALENDER_SELECT();
        } else {
            // �������z�^�u�I����
            setState_CALENDER_UNSELECT();
        }
        
    }

    /**
     * �f�[�^�o�^�p�̌`���Ƀf�[�^�ϊ����擾���܂��B
     * 
     * @author Masahiko Higuchi
     * @since V5.4.9
     * @return �J�����_�[�̃f�[�^
     */
    public VRMap getCalenderBitData() throws Exception {
        // �J�����_�[����o�^���鐔�l�ɕϊ�����B
        VRMap dateManager = new VRHashMap();
        // �R���|�[�l���g��S����
        for(int i=0; i< getContentCalendar().getComponentCount(); i++) {
            Component cmp = getContentCalendar().getComponent(i);
            // �e�[�u���̏ꍇ�̂ݏ�����
            if(cmp instanceof QP003ResultCalendar) {
                QP003ResultCalendar rc = (QP003ResultCalendar)cmp;
                if(rc.getModel().getAdaptee() instanceof VRList) {
                    // �T�[�r�X�}�X�^�̐ݒ�
                    VRList serviceList = (VRList)rc.getModel().getAdaptee();
                    if(!serviceList.isEmpty()) {
                        for(int j=0; j<serviceList.size(); j++) {
                            String markServiceBitKey = "MARK" + ACCastUtilities.toString(j+1) +"_SERVICE_DATE_BIT";
                            StringBuilder sbDateBit = new StringBuilder();
                            // �e�[�u������f�[�^���擾
                            VRMap record = (VRMap)serviceList.getData(j);
                            // �r�b�g���쐬����
                            if(dateManager.containsKey(markServiceBitKey)) {
                                sbDateBit = (StringBuilder)dateManager.getData(markServiceBitKey);
                            }
                            // �`�F�b�N�̒l������Bit�ɕϊ�
                            if(ACCastUtilities.toBoolean(record.getData("CHECK"),false) == true) {
                                sbDateBit.insert(0, "1");
                            } else {
                                sbDateBit.insert(0, "0");
                            }
                            // Bit�`���ňꎟ�쐬
                            dateManager.setData(markServiceBitKey,sbDateBit);
                        }
                    }
                }
            }
        }
        // �t�B�[���h�����[�v
        for (int k = 1; k <= 7; k++) {
            // �o�C���h�p�X 
            String markServiceBitKey = "MARK" + ACCastUtilities.toString(k) +"_SERVICE_DATE_BIT";
            int bit = 0;
            if(dateManager.containsKey(markServiceBitKey)) {
                StringBuilder sbDateBit = (StringBuilder)dateManager.getData(markServiceBitKey);
                int dayIndex = 1;
                // ���t�̃r�b�g�f�[�^�����ɂ��Čv�Z
                for (int l = sbDateBit.length(); l > 0 ; l--) {
                    // bit���Z�œo�^�l���v�Z
                    if("1".equals(sbDateBit.substring(l-1,l))) {
                        bit |= (1 << (dayIndex - 1));
                    }
                    // ���t��i�߂�
                    dayIndex++;
                }
                dateManager.setData(markServiceBitKey,ACCastUtilities.toInteger(bit));
            }
        }
        return dateManager;
    }

    /**
     * �J�����_�[���ɕύX���Ȃ����`�F�b�N���܂��B
     * 
     * @author Masahiko Higuchi
     * @since V5.4.9
     * @return True:�ύX���� False:�ύX�Ȃ�
     */
    public boolean calenderIsModified() throws Exception {
        // �f�[�^���Ȃ��ꍇ�͏��������Ȃ�
        if(getSnapShotMap() == null || getSnapShotMap().isEmpty()) {
            return false;
        }
        // ���݂̃J�����_�[�f�[�^���擾
        VRMap nowCalenderMap = getCalenderBitData();
        if(nowCalenderMap == null || nowCalenderMap.isEmpty()) {
            return true;
        }
        
        // �t�B�[���h�����[�v
        for (int i = 1; i <= 7; i++) {
            String markServiceBitKey = "MARK" + ACCastUtilities.toString(i) +"_SERVICE_DATE_BIT";
            // �L�[�������Ƃ����݂���ꍇ
            if (getSnapShotMap().containsKey(markServiceBitKey)
                    && nowCalenderMap.containsKey(markServiceBitKey)) {
                Integer old = ACCastUtilities.toInteger(getSnapShotMap().getData(markServiceBitKey),0);
                Integer now = ACCastUtilities.toInteger(nowCalenderMap.getData(markServiceBitKey),0); 
                // ���ڂ���v���Ă��邩�`�F�b�N����B
                if (!old.equals(now)) {
                    return true;
                }
            }
        }
        // �Ō�܂ňꏏ�Ȃ�ύX�Ȃ�
        return false;
    }

    /**
     * �J�����_�[�̈�̃X�i�b�v�V���b�g���B�e���܂��B
     * 
     * @author Masahiko Higuchi
     * @since V5.4.9
     */
    public void calenderSnapShot() throws Exception {
        // �f�[�^��ݒ�
        setSnapShotMap(getCalenderBitData());
        
    }

    /**
     * �u��Ô�T���⏕�̐���v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void koujoDispCheckActionPerformed(ActionEvent e) throws Exception {
        if(getKoujoDispCheck().isSelected()) {
            // ��Ô�T���⏕�I����
        	setState_KOUJO_ENABLE_TRUE();
        } else {
            // ��Ô�T���⏕��I����
        	setState_KOUJO_ENABLE_FALSE();
        }
        
    }

    /**
     * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentHokenIryoUseFocusLost(FocusEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentHokenFukushiUseFocusLost(FocusEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentHokenIryoKoujoCheckActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentHokenFukushiKoujoCheckActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentJikohutanKoujoCheck1ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentJikohutanKoujoCheck2ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentJikohutanKoujoCheck3ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentEtcKoujoCheck1ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentEtcKoujoCheck2ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentEtcKoujoCheck3ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentEtcKoujoCheck4ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentEtcKoujoCheck5ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void contentEtcKoujoCheck6ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * �u��Ô�T�����z���f�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void reflectionActionPerformed(ActionEvent e) throws Exception {
        if (ACCastUtilities.toInt(getContentKoujyoText().getText(), 0) > 0) {
            if (QkanMessageList.getInstance()
                    .QP003_WARNING_OF_REPLACE_KOUJO() == ACMessageBox.RESULT_CANCEL) {
                // �u�L�����Z���v�I����
                return;
                }
        }
        getContentKoujyoText().setText(getContentKoujyoText2().getText());
    }

    /**
     * �u��Ô�T���v�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
     *
     * @throws Exception ������O
     *
     */
    public void calcKoujoPrice() throws Exception {
        // ���ی����S�����v���z�̌v�Z����
        int hokenSum = 0;
        // ��Ô�T���Ώۂ��`�F�b�N����Ă���t�B�[���h�̒l�̍��v���v�Z����B
        // �E��Ìn�T�[�r�X
        if (getContentHokenIryoKoujoCheck().isSelected() && !"".equals(getContentHokenIryoUse().getText())) {
        	hokenSum += ACCastUtilities.toInt(getContentHokenIryoUse().getText(),0);
        }
        // �E�����n�T�[�r�X
        if (getContentHokenFukushiKoujoCheck().isSelected() && !"".equals(getContentHokenFukushiUse().getText())) {
        	hokenSum += ACCastUtilities.toInt(getContentHokenFukushiUse().getText(),0);
        }
        
        // �S�z���ȕ��S�����v���z�̌v�Z����
        int sum = 0;
        // �E�S�z���ȕ��S�����p���P
        if (getContentJikohutanKoujoCheck1().isSelected() && !"".equals(getContentJikohutanUse1().getText())) {
            sum += ACCastUtilities.toInt(getContentJikohutanUse1().getText(),0);
        }
        // �E�S�z���ȕ��S�����p���Q
        if (getContentJikohutanKoujoCheck2().isSelected() && !"".equals(getContentJikohutanUse2().getText())) {
            sum += ACCastUtilities.toInt(getContentJikohutanUse2().getText(),0);
        }
        // �E�S�z���ȕ��S�����p���R
        if (getContentJikohutanKoujoCheck3().isSelected() && !"".equals(getContentJikohutanUse3().getText())) {
            sum += ACCastUtilities.toInt(getContentJikohutanUse3().getText(),0);
        }
        // �v�Z���ʂ�S�z���ȕ��S���v�t�B�[���h�ɕ\������B
        getContentJikohutanKoujoSubtotal().setText(ACCastUtilities.toString(sum));
        
        // ���̑����p�����v���z�̌v�Z����
        int etcSum = 0;
        // �E���̑����p���P
        if (getContentEtcKoujoCheck1().isSelected() && !"".equals(getContentEtcUse1().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse1().getText(),0);
        }
        // �E���̑����p���Q
        if (getContentEtcKoujoCheck2().isSelected() && !"".equals(getContentEtcUse2().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse2().getText(),0);
        }
        // �E���̑����p���R
        if (getContentEtcKoujoCheck3().isSelected() && !"".equals(getContentEtcUse3().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse3().getText(),0);
        }
        // �E���̑����p���S
        if (getContentEtcKoujoCheck4().isSelected() && !"".equals(getContentEtcUse4().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse4().getText(),0);
        }
        // �E���̑����p���T
        if (getContentEtcKoujoCheck5().isSelected() && !"".equals(getContentEtcUse5().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse5().getText(),0);
        }
        // �E���̑����p���U
        if (getContentEtcKoujoCheck6().isSelected() && !"".equals(getContentEtcUse6().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse6().getText(),0);
        }        
        // �v�Z���ʂ����̑���p���v�t�B�[���h�ɕ\������B
        getContentEtcKoujoSubtotal().setText(ACCastUtilities.toString(etcSum));

        // ��Ô�T���`�F�b�N���v�ɕ\������B
        sum = hokenSum + sum + etcSum;
        getContentKoujyoText2().setText(ACCastUtilities.toString(sum));

    }
    
    /**
     * �u��Ô�T�������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doFindKoujo() throws Exception {
        // �����ڍ׏��̗��p�ҕ��S�����擾
        // SQL���擾�p��VRMap param�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
        VRMap param = new VRHashMap();
        // �EKEY�FPATIENT_ID VALUE�FpatientId
        // �EKEY�FTARGET_DATE VALUE�FtargetDate
        // �EKEY�FCLAIM_DATE VALUE�FclaimDate
        // �EKEY�FPROVIDER_ID VALUE�FproviderId
        // �EKEY�FINSURED_ID VALUE�FinsuredId
        param.setData("PATIENT_ID", new Integer(getPatientId()));
        param.setData("TARGET_DATE", getTargetDate());
        param.setData("CLAIM_DATE", getClaimDate());
        param.setData("PROVIDER_ID", getProviderId());
        param.setData("INSURED_ID", getInsuredId());
        // SQL�����擾����B
        // �擾����SQL�������s���A�f�[�^��koujoList�Ɋi�[����B
        VRList koujoList = getDBManager().executeQuery(getSQL_GET_RIYOUSYA_UNIT(param));
        int iryoTotal = 0;
        int fukushiTotal = 0;
        int halfTotal = 0;
        for (int i = 0; i < koujoList.size(); i++) {
            VRMap map = (VRMap) koujoList.getData(i);
            // �T�[�r�X��ޖ��Ɉ�Ìn�ƕ����n�̗��p�ҕ��S���v�֐ݒ肷��
            int unit = ACCastUtilities.toInt(map.get("UNIT"), 0);
            String serviceCodeKind = ACCastUtilities.toString(map.get("SERVICE_CODE_KIND"), "");
            int styleType = ACCastUtilities.toInt(map.get("CLAIM_STYLE_TYPE"), 0);
            // ��Ìn�T�[�r�X�i���{�ȊO�j
            if ("13".equals(serviceCodeKind) || "14".equals(serviceCodeKind) || "16".equals(serviceCodeKind)
                || "22".equals(serviceCodeKind) || "23".equals(serviceCodeKind)
                || "25".equals(serviceCodeKind) || "26".equals(serviceCodeKind)
                || "31".equals(serviceCodeKind) || "34".equals(serviceCodeKind)
                || "52".equals(serviceCodeKind) || "53".equals(serviceCodeKind)
                || "63".equals(serviceCodeKind) || "64".equals(serviceCodeKind) || "66".equals(serviceCodeKind)
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_4)  // ��������� �Z���V��
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_4_2)// ��������� �\�h�Z���V��
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_5)  // ��������� �Z���×{
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_5_2)// ��������� �\�h�Z���×{
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_9)  // ��������� �V��
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_10) // ��������� �×{
            	) {
            	iryoTotal = iryoTotal + unit;
            }
            // ��Ìn�T�[�r�X
            // �����{�@�Ō�ɔ��z�ɂ��邽�ߕʏW�v
            if ("51".equals(serviceCodeKind) || "54".equals(serviceCodeKind) 
            	|| ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_8) // ��������� ���{
            ) {
            	halfTotal = halfTotal + unit;
            }
            // �����n�T�[�r�X
            // ���������Ƃ͖K��^�ƒʏ��^�̂݁iA1-A8�j��ΏۂƂ���
            if ("11".equals(serviceCodeKind) || "12".equals(serviceCodeKind) || "15".equals(serviceCodeKind) 
                || "21".equals(serviceCodeKind) || "24".equals(serviceCodeKind)
                || "61".equals(serviceCodeKind) || "62".equals(serviceCodeKind)
                || "65".equals(serviceCodeKind) || "68".equals(serviceCodeKind)
                || "69".equals(serviceCodeKind)
                || "71".equals(serviceCodeKind) || "72".equals(serviceCodeKind)
                || "73".equals(serviceCodeKind) || "74".equals(serviceCodeKind)
                || "75".equals(serviceCodeKind) || "76".equals(serviceCodeKind)
                || "77".equals(serviceCodeKind) || "78".equals(serviceCodeKind)
                || "79".equals(serviceCodeKind)
                || "A1".equals(serviceCodeKind) || "A2".equals(serviceCodeKind)
                || "A3".equals(serviceCodeKind) || "A4".equals(serviceCodeKind)
                || "A5".equals(serviceCodeKind) || "A6".equals(serviceCodeKind)
                || "A7".equals(serviceCodeKind) || "A8".equals(serviceCodeKind)
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_3)   // ��������� �Z������
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_3_2) // ��������� �\�h�Z������
                ) {
            	fukushiTotal = fukushiTotal + unit;
            }
        }
        iryoTotal = iryoTotal + (int)Math.floor(halfTotal / 2.0d);
        getContentHokenIryoUse().setText(ACCastUtilities.toString(iryoTotal));
        getContentHokenFukushiUse().setText(ACCastUtilities.toString(fukushiTotal));
    }


}
