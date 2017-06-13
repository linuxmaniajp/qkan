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
 * �쐬��: 2006/02/17  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (002)
 * �v���O���� ���[(�l��)�E���Ə��I�� (QP002)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp002;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qp.qp003.QP003;
import jp.or.med.orca.qkan.affair.qp.qp004.QP004;
import jp.or.med.orca.qkan.affair.qp.qp005.QP005;
import jp.or.med.orca.qkan.text.QkanClaimStyleFormat;
import jp.or.med.orca.qkan.text.QkanInsureTypeDivision;

/**
 * ���[(�l��)�E���Ə��I��(QP002)
 */
public class QP002 extends QP002Event {

	/**
     * �R���X�g���N�^�ł��B
     */
    public QP002() {
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
        VRMap parameters = affair.getParameters();
        
        // �Ethis.patientId KEY�FPATIENT_ID
        if(VRBindPathParser.has("PATIENT_ID", parameters)){
        	setPatientId(ACCastUtilities.toInt(parameters.getData("PATIENT_ID")));
        }
        // �Ethis.claimDate KEY�FCLAIM_DATE
        if(VRBindPathParser.has("CLAIM_DATE", parameters)){
        	setClaimDate(ACCastUtilities.toDate(parameters.getData("CLAIM_DATE")));
        }
        // �Ethis.listIndex KEY�FLIST_INDEX
        if(VRBindPathParser.has("LIST_INDEX", parameters)){
        	setListIndex(ACCastUtilities.toInt(parameters.getData("LIST_INDEX")));
        }else{
        	setListIndex(-1);
        }
        
        // �Ɩ����}�X�^���A�f�[�^���擾����B
        // QkanCommon.getAffairInfo(getDBManager(), "QP002");
        // �擾�����f�[�^�̃E�B���h�E�^�C�g���iWINDOW_TITLE�j���E�B���h�E�ɐݒ肷��B
        // �擾�����f�[�^�̋Ɩ��^�C�g���iAFFAIR_TITLE�j���Ɩ��{�^���o�[�ɐݒ肷��B
        setAffairTitle("QP002", getButtons());
        // ���p�Ҋ�{�����擾����B
        VRList patientList = QkanCommon.getPatientInfo(getDBManager(),
                getPatientId());
        VRMap patientMap = (VRMap) patientList.getData(0);
        // �擾�������p�Ҋ�{���̒l���Athis.sourceMap�ɐݒ肷��B
        // �EPATIENT_CODE���AKEY�FPATIENT_CODE�Őݒ肷��B
        // �EPATIENT_FAMILY_NAME��PATIENT_FIRST_NAME�̕�������������AKEY�FPATIENT_NAME�Őݒ肷��B
        // toFullName();
        getSourceMap().setData("PATIENT_CODE",
                patientMap.getData("PATIENT_CODE"));
        getSourceMap().setData(
                "PATIENT_NAME",
                QkanCommon.toFullName(
                        patientMap.getData("PATIENT_FAMILY_NAME"), patientMap
                                .getData("PATIENT_FIRST_NAME")));
        // this.sourceMap���u�N���C�A���g�̈�icontents�j�v�̃\�[�X�Ƃ��Đݒ肷��B
        // setSource(contents, sourceMap);
        getContents().setSource(getSourceMap());
        // ��ʂɓW�J����B
        // bindSource(contents);
        getContents().bindSource();

        doFind();

    }
    
    private void doFind() throws Exception {
        // ���p�҂̐����f�[�^���擾����B
        // SQL���擾���邽�߂�HashMap�Fparam�𐶐����A���L��KEY/VALUE��ݒ肷��B
        VRMap param = new VRHashMap();
        // �EKEY�FPATIENT_ID VALUE�Fthis.patientId
        // �EKEY�FTARGET_DATE VALUE�Fthis.targetDate
        // �EKEY�FCLAIM_STYLE_TYPE VALUE�FCLAIM_STYLE_TYPE
        // �EKEY�FLOGIN_PROVIDER_ID VALUE�F���O�C�����Ə��ԍ�
        param.setData("PATIENT_ID", new Integer(getPatientId()));
        param.setData("CLAIM_DATE", getClaimDate());
        param.setData("LOGIN_PROVIDER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
        // �����f�[�^���擾���Athis.claimList�Ɋi�[����B
        // getSql(GET_CLAIM, param);
        setClaimList(getDBManager().executeQuery(getSQL_GET_CLAIM(param)));
        

        // �擾�����f�[�^����ʕ\���p�ɕҏW����B
        editRecord();

        ACTableModelAdapter providerTableModel = new ACTableModelAdapter();
        String[] ada = { "NO", "DELETE", "TARGET_DATE", "INSURER_ID", "UNIT_INSURED_ID" 
                        , "PROVIDER_ID", "PROVIDER_NAME", "INSURED_ID", "CLAIM_STYLE_TYPE"};
        
        getProviderTableColumn6().setFormat(QkanClaimStyleFormat.getInstance());
        getProviderTableColumn5().setFormat(new QkanInsureTypeDivision());
        
        providerTableModel.setColumns(ada);

        setTableModel(providerTableModel);

        // ���Ə��ꗗ�e�[�u���iproviderTable�j��this.tableModel��ݒ肷��B
        getProviderTable().setModel(getTableModel());
        // �������R�[�h�W���ithis.claimList�j��this.tableModel�ɐݒ肷��B
        getTableModel().setAdaptee(getClaimList());

        if (getListIndex() == -1) {
            // ���Ə��ꗗ�e�[�u���iproviderTable�j�̈�s�ڂ�I��������Ԃɂ���B
            getProviderTable().setSelectedSortedFirstRow();
            
        } else {
            // ���p�҈ꗗ�i�����j�iQP001�j�ȊO����J�ڂ��Ă����ꍇ
            // ���Ə��ꗗ�e�[�u���iproviderTable�j�̑J�ڑO�ɑI������Ă����s�ithis.listIndex�j��I��������Ԃɂ���B
            getProviderTable().setSelectedModelRow(getListIndex());
            getProviderTable().scrollSelectedToVisible();
        }
        
        // ��ʏ�Ԑ���
        checkState();

    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // ���L��n��p�����[�^�Ƃ��āA���p�҈ꗗ�i�����j��ʁiQP001�j�ɑJ�ڂ���B
        // �EKEY�FPATIENT_ID VALUE�Fthis.patientId
        // �EKEY�FCLAIM_DATE VALUE�Fthis.targetDate
        parameters.setData("PATIENT_ID", new Integer(getPatientId()));
        parameters.setData("CLAIM_DATE", getClaimDate());
        

        // TODO �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
        return true;
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u���p�Ҍ��������ڍוҏW��ʂɑJ�ځv�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void seikyuActionPerformed(ActionEvent e) throws Exception {
        // ���L��n��p�����[�^�Ƃ��āA���p�Ҍ��������ڍוҏW��ʁiQP003�j�ɑJ�ڂ���B
        VRMap param = new VRHashMap();
        // �EKEY�FPATIENT_ID VALUE�Fthis.patientId
        // �EKEY�FCLAIM_DATE VALUE�Fthis.claimDate
        // �EKEY�FTARGET_DATE VALUE�F�I������Ă��郌�R�[�h�̑Ώ۔N��
        // �EKEY�FLIST_INDEX VALUE�F�I������Ă��郌�R�[�h�̃C���f�b�N�X
        // �EKEY�FPROVIDER_ID VALUE�F�I������Ă��郌�R�[�h�̎��Ə�ID
        // �EKEY�FINSURED_ID VALUE�F�I������Ă��郌�R�[�h�̔�ی��Ҕԍ�
        // �EKEY�FINSURER_ID VALUE�F�I������Ă��郌�R�[�h�̕ی��Ҕԍ�
        if (getProviderTable().getSelectedRow() == -1) {
            return;
        }

        VRMap map = new VRHashMap();
        if (getProviderTable().getSelectedModelRowValue() instanceof VRMap) {
            map = (VRMap) getProviderTable().getSelectedModelRowValue();

        } else {
            return;

        }
        param.setData("PATIENT_ID", new Integer(getPatientId()));
        param.setData("CLAIM_DATE", getClaimDate());
        param.setData("TARGET_DATE", map.getData("TARGET_DATE"));
        param.setData("LIST_INDEX", new Integer(getProviderTable()
                .getSelectedModelRow()));
        param.setData("PROVIDER_ID", map.getData("PROVIDER_ID"));
        param.setData("INSURER_ID", map.getData("INSURER_ID"));
        
        //�J�������ʂŗp�����p�����[�^�[���ēx����
        String findInsurer = ACCastUtilities.toString(map.getData("INSURED_ID"));
        //����
        String[] findCut = findInsurer.split("-");
        if(findCut != null){
            if(findCut.length > 0){
                findInsurer = findCut[0];
            }
        }
        param.setData("INSURED_ID", findInsurer);
//        param.setData("INSURED_ID", map.getData("INSURED_ID"));

        ACAffairInfo affair = new ACAffairInfo(QP003.class.getName(), param);

        ACFrame.getInstance().next(affair);

    }

    /**
     * �u��ʑJ�ڏ����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void selectActionPerformed(ActionEvent e) throws Exception {
        transferAffair();
    }

    /**
     * �u��ʑJ�ڏ����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void providerTableMouseClicked(MouseEvent e) throws Exception {
        // �I���{�^���iselect�j�N���b�N���Ɠ��l�̏������s���B
        transferAffair();
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        param.setData("PATIENT_ID", new Integer(1));
        param.setData("DEBUG_BACK", QP001.class.getName());
        param.setData("CLAIM_DATE", new Date(106, 2, 1));
        param.setData("PROVIDER_ID", "0000000005");
        param.setData("TARGET_DATE", new Date(106, 1, 1));
        param.setData("LIST_INDEX", new Integer(0));
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QP002.class.getName(), param));
    }

    // �����֐�

    /**
     * �u���R�[�h�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void editRecord() throws Exception {
        // �������R�[�h�W���ithis.claimList�j�����Ɍ��Ă����B�i���[�v�J�n�j
        VRList claimList = getClaimList();


    }
    
    /**
     * ��ʑJ�ڏ������s���܂��B
     * @throws Exception
     */
    public void transferAffair() throws Exception {

        VRMap map = new VRHashMap();
        if (getProviderTable().isSelected()) {
            if (getProviderTable().getSelectedModelRowValue() instanceof VRMap) {
                map = (VRMap) getProviderTable().getSelectedModelRowValue();

            } else {
                return;

            }
            // ���Ə��ꗗ�e�[�u���ŁA�I������Ă��郌�R�[�h����쐿���̃��R�[�h�̏ꍇ�i(CLAIM_STYLE_TYPE <> 20101)
            // AND
            // (CLAIM_STYLE_TYPE <> 20102)�j
            if (!new Integer(20101).equals(map.getData("CLAIM_STYLE_TYPE"))
                    && !new Integer(20102).equals((map
                            .getData("CLAIM_STYLE_TYPE")))) {
                VRMap param = new VRHashMap();
                // ���L��n��p�����[�^�Ƃ��āA���׏���{���ҏW��ʁiQP004�j�ɑJ�ڂ���B
                // �EKEY�FPATIENT_ID VALUE�Fthis.patientId
                // �EKEY�FCLAIM_DATE VALUE�Fthis.claimDate
                // �EKEY�FTARGET_DATE VALUE�F�I������Ă��郌�R�[�h�̑Ώ۔N��
                // �EKEY�FLIST_INDEX VALUE�F�I������Ă��郌�R�[�h�̃C���f�b�N�X
                // �EKEY�FPROVIDER_ID VALUE�F�I������Ă��郌�R�[�h�̎��Ə�ID
                // �EKEY�FCLAIM_STYLE_TYPE VALUE�F�I������Ă��郌�R�[�h�̐������[�l��
                // �EKEY�FINSURED_ID VALUE�F�I������Ă��郌�R�[�h�̔�ی��Ҕԍ�
                param.setData("PATIENT_ID", new Integer(getPatientId()));
                param.setData("CLAIM_DATE", getClaimDate());
                param.setData("TARGET_DATE", map.getData("TARGET_DATE"));
                param.setData("LIST_INDEX", new Integer(getProviderTable()
                        .getSelectedModelRow()));
                param.setData("PROVIDER_ID", map.getData("PROVIDER_ID"));
                param.setData("INSURER_ID", map.getData("INSURER_ID"));
                
                //�J�������ʂŗp�����p�����[�^�[���ēx����
                String findInsurer = ACCastUtilities.toString(map.getData("INSURED_ID"));
                //����
                String[] findCut = findInsurer.split("-");
                if(findCut != null){
                    if(findCut.length > 0){
                        findInsurer = findCut[0];
                    }
                }
                param.setData("INSURED_ID", findInsurer);
                param.setData("CLAIM_STYLE_TYPE", map
                        .getData("CLAIM_STYLE_TYPE"));
                // ACAffairInfo affair = new ACAffairInfo(QP004.class.getName(),
                // param);

                
                // ����x���̏ꍇ����ʂ̑J�ڂ͊�{QP004�ł͖���QP005�̏ڍוҏW��ʂɑJ�ڂ���
                // ����\�h�x���̏ꍇ����ʂ̑J�ڂ͊�{QP004�ł͖���QP005�̏ڍוҏW��ʂɑJ�ڂ��� 
                ACAffairInfo affair;
                if(new Integer(10711).equals(map.getData("CLAIM_STYLE_TYPE"))
                		|| new Integer(10712).equals(map.getData("CLAIM_STYLE_TYPE"))){
                	affair = new ACAffairInfo(QP005.class.getName(), param);
                }else{                
                	affair = new ACAffairInfo(QP004.class.getName(), param);
                }
                	
                ACFrame.getInstance().next(affair);

            }

        }
    }

    /**
     * �e�[�u���I�����̃C�x���g
     */
    protected void providerTableSelectionChanged(ListSelectionEvent e) throws Exception {
        //��ʏ�Ԃ��`�F�b�N����B
        checkState();
    }

    /**
     * ��ʏ�Ԑ���
     */
    public void checkState() throws Exception {
        //�e�[�u�����I������Ă��邩�`�F�b�N����B
        if (getProviderTable().getSelectedModelRow() == -1){
            //�I������Ă��Ȃ������ꍇ
            setState_AFFAIR_BUTTON_ENABLE_FALSE();
        }else{
            //�I������Ă����ꍇ
            setState_AFFAIR_BUTTON_ENABLE_TRUE();
        }
    }

 // 2016/2/3 [2015�N�v�]][Yoichiro Kamei] add - begin �폜�@�\�ǉ�
    /**
     * �u�����f�[�^�폜�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void deleteActionPerformed(ActionEvent e) throws Exception {
        // �폜�m�F���b�Z�[�W��\������B
        if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() != ACMessageBox.RESULT_OK) {
            return;
        }
        // �I�����ꂽ�l���̏W�v�f�[�^���폜����B
        for (int i = 0; i < getClaimList().getDataSize(); i++) {
            VRMap map = (VRMap) getClaimList().get(i);
            String choise = String.valueOf(VRBindPathParser.get("DELETE", map));
            // �I������Ă���΍폜���s
            if ("TRUE".equalsIgnoreCase(choise)) {
                // ����
                String condition = createCondition(map, QkanSystemInformation.getInstance().getLoginProviderID(), getPatientId());
                Date targetDate = ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE",map));
                try {
                    getDBManager().beginTransaction();
                    QkanCommon.updateClaimDetailCustom(getDBManager(), new VRArrayList(), targetDate, condition);
                    getDBManager().commitTransaction();
                } catch (Exception e1) {
                    getDBManager().rollbackTransaction();
                    throw e1;
                }
            }
        }
        // �Č���
        doFind();
    }
    
    //�폜�����\�z
    private String createCondition(VRMap param, String providerId, int patientID) throws Exception {
        String styleType = ACCastUtilities.toString(VRBindPathParser.get("CLAIM_STYLE_TYPE",param));
        String insurerId = ACCastUtilities.toString(VRBindPathParser.get("INSURER_ID",param));
        String insuredId = ACCastUtilities.toString(VRBindPathParser.get("UNIT_INSURED_ID",param));
        Date targetDate = ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE",param));
        Date claimDate = ACCastUtilities.toDate(VRBindPathParser.get("CLAIM_DATE",param));
        
        StringBuilder sb = new StringBuilder();
        sb.append(" (CLAIM.CLAIM_DATE = '" + VRDateParser.format(claimDate, "yyyy-MM-dd") + "')");
        sb.append(" AND(CLAIM.PATIENT_ID = " + patientID + ")");
        if (!ACTextUtilities.isNullText(insuredId)) {
            sb.append(" AND(CLAIM.INSURED_ID = '" + insuredId + "')");
        }
        sb.append(" AND(CLAIM.TARGET_DATE = '" + VRDateParser.format(targetDate, "yyyy-MM-dd") + "')");
        if (!ACTextUtilities.isNullText(providerId)) {
            sb.append(" AND(CLAIM.PROVIDER_ID = '" + providerId + "')");
        }
        sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = " + styleType + ")");
        if (!ACTextUtilities.isNullText(insurerId)) {
            sb.append(" AND(CLAIM.INSURER_ID = '" + insurerId + "')");
        }
        return sb.toString();
    }
    
    /**
     * �u�I�𑀍상�j���[�N���b�N�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void providerTableColumn9CheckMenuActionPerformed(ActionEvent e)
            throws Exception {
        if(getClaimList() == null) return;
        String choise;
        for (int i = 0; i < getClaimList().getDataSize(); i++) {
            choise = String.valueOf(VRBindPathParser.get("DELETE",
                    (VRLinkedHashMap) getClaimList().get(i)));
            // �I������Ă���Ή����\
            if ("TRUE".equalsIgnoreCase(choise)) {
                getDelete().setEnabled(true);
                return;
            }
        }
        getDelete().setEnabled(false);
        
    }
 // 2016/2/3 add - end
    
}
