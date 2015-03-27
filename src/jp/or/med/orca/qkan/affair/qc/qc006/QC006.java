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
 * �J����: �����@���̂�
 * �쐬��: 2014/12/02  MIS��B������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X ����×{�Ǘ��w���� (006)
 * �v���O���� ����×{�Ǘ��w�����ꗗ (QC006)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc006;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.util.Date;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACCommon;
//import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
//import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.text.parsers.VRDateParser;
//import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qc.qc005.QC005;
import jp.or.med.orca.qkan.text.QkanPatientListDataTypeFormat;

/**
 * ����×{�Ǘ��w�����ꗗ(QC006)
 */
public class QC006 extends QC006Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QC006() {
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
        // ��ʂ̏����\�����s������
        // �擾�����f�[�^�̃E�B���h�E�^�C�g���iWINDOW_TITLE�j���E�B���h�E�ɐݒ肷��B
        // �擾�����f�[�^�̋Ɩ��^�C�g���iAFFAIR_TITLE�j���Ɩ��{�^���o�[�ɐݒ肷��B
        // �n��f�[�^�̎擾/�O��ʁu���p�҈ꗗ�v����n���ꂽ�p�����[�^��ޔ�����B
        // this.patientID = PATIENT_ID(���p��ID)
        // this.targetDate = TARGET_DATE(�Ώ۔N��)
        VRMap params = affair.getParameters();

        // �f�[�^�����݂��Ă��邩���`�F�b�N
        if (VRBindPathParser.has("PATIENT_ID", params)
                && VRBindPathParser.has("TARGET_DATE", params)) {

            // int�^�Ɍ^�ϊ������p��ID��ޔ�
            setPatientID(Integer.parseInt(String.valueOf(VRBindPathParser.get(
                    "PATIENT_ID", params))));
            // Date�^�Ɍ^�ϊ����Ώ۔N����ޔ�
            setTargetDate((Date) VRBindPathParser.get("TARGET_DATE", params));

        }

        setAffairTitle("QC006", getButtons());

        setPASSIVE_CHECK_KEY(new ACPassiveKey("KYOTAKU_RYOYO", new String[] {
                "PATIENT_ID", "TARGET_DATE" }, new Format[] { null,
                new ACSQLSafeDateFormat("yyyy/M/d") }, "LAST_TIME", "LAST_TIME"));

        // �e�[�u�����f�������L�̉�ʂ̃e�[�u���ɐݒ肷��B
        // �E�ی��ҏ��e�[�u���iinsurerInfoTable) �e�[�u�����f���FinsurerTableModel
        ACTableModelAdapter kyotakuTableModel = new ACTableModelAdapter();

        // �e�[�u�����f�����`
        kyotakuTableModel
                .setColumns(new String[] { "PATIENT_ID", "TARGET_DATE",
                        "MEDICAL_FACILITY_NAME", "DOCTOR_NAME",
                        "CREATE_DATE_KYOTAKU", "SENMONIN", "PROVIDER_NAME",
                        "CONDITION", "FINISH_FLAG" });

        // ��`�����e�[�u�����f�����i�[
        setKyotakuTableModel(kyotakuTableModel);

        // �e�[�u�����f�����e�[�u���ɃZ�b�g
        getKyotakuTable().setModel(getKyotakuTableModel());

        // ��ʏ����\��
        // �E�Ώ۔N����\������
        getTargetDateLabel().setText(
                VRDateParser.format(getTargetDate(), "ggge�NM��"));

        // �E���p�Җ��A���p�҃R�[�h��\������
        // �@���p��ID(patientID) �����ɁA���p�҂̊�{�����擾����B
        VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(
                getDBManager(), getPatientID()).get(0);
        if (patient.isEmpty()) {
            // ���p�ҏ�񂪑��݂��Ȃ��ꍇ
            // �߂�
            ACFrame.getInstance().back();
            return;
        }
        getPatientName().setText(
                QkanCommon.toFullName(
                        VRBindPathParser.get("PATIENT_FAMILY_NAME", patient),
                        VRBindPathParser.get("PATIENT_FIRST_NAME", patient)));
        getPatientNo().setText(
                ACCastUtilities.toString(VRBindPathParser.get("PATIENT_CODE",
                        patient)));

        // ����u1:�ρv���u0:�󔒁v�ŕ\������
        getKyotakuTableColumn2().setFormat(
				new QkanPatientListDataTypeFormat("QC006"));

        // DB��背�R�[�h���擾���A��ʂɓW�J����B
        doFind();

        // ����params��null�̏ꍇ�������I������
        if (params == null) {
            return;
        }

        // providerList�̃��R�[�h��1���ȏ�̏ꍇ
        if (getKyotakuList().size() > 0) {
        	
        	// ���p��ID�ƑΏ۔N������I����Ԃɂ���
        	int index = ACCommon.getInstance().getMatchIndexFromValue(
        			getKyotakuList(), "TARGET_DATE",
					getTargetDate());
        	
        	if (index == -1) {
	            // ���R�[�h��1�s�ڂ�I����Ԃɂ���B
	            getKyotakuTable().setSelectedSortedFirstRow();
        	} else {
        		// �Y�����闘�p�҂������ꍇ�A�Y�����p�҂�I������B
        		getKyotakuTable().setSelectedModelRow(index);
                // �I�𗘗p�҂ɃX�N���[������
                getKyotakuTable().scrollSelectedToVisible();
        	}
        }
        
        // �Ɩ��{�^���̏�Ԃ�ύX����
        setState();

        params.clear();
    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // �O��ʂɑJ�ڂ��鏈��
        // �Ɩ���ՂɋL������Ă���O��ʂɑJ�ڂ���B

        // TODO �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
        return true;
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u����×{�Ǘ��w������ʂɑJ�ځi�X�V�j�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void detailActionPerformed(ActionEvent e) throws Exception {
        // ����×{�Ǘ��w������ʂɍX�V���[�h�őJ�ڂ��鏈��
        
        // ��ʂ́u����×{�Ǘ��w�����ꗗ�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
        VRMap param = new VRHashMap();

        if (getKyotakuTable().isSelected()) {
            // �I������Ă���ꍇ
            // �I������Ă��闘�p�҂́u���p��ID�ƑΏ۔N�����v���擾����B
            param = (VRMap) getKyotakuTable().getSelectedModelRowValue();
            param.setData("PROCESS_MODE", new Integer(
                    QkanConstants.PROCESS_MODE_UPDATE));
        } else {
            // �I������Ă��Ȃ��ꍇ
            // �����𒆒f����B
            return;

        }

        // ���J�ڏ���
        ACAffairInfo affair = null;
        affair = new ACAffairInfo(QC005.class.getName(), param);
        // ����ʂɑJ�ڂ���B
        ACFrame.getInstance().next(affair);

    }

    /**
     * �u����×{�Ǘ��w������ʂɑJ�ځi�V�K�j�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // ����×{�Ǘ��w������ʂɐV�K�o�^���[�h�őJ�ڂ��鏈��
        // VRMap�Fparam�𐶐������L�̃p�����[�^�[���i�[����B
        // �QC005�i����×{�Ǘ��w�����j��ɑJ�ڂ���B

        // �n���p�����[�^�[���쐬����B
        VRMap param = new VRHashMap();
        param.setData("PATIENT_ID", getPatientID());
        
        // �o�^����Ă��Ȃ����t���擾����B
        int maxDay = ACDateUtilities.getDayOfMonth(ACDateUtilities.toLastDayOfMonth(getTargetDate()));
        int targetDay = 1;
        int cnt = 0;
        
        // �Ώ۔N�����̍ő�{�P���擾����
    	for (int j = 0; j < getKyotakuList().size(); j++) {
            int listDay = ACDateUtilities.getDayOfMonth(
                    ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE", (VRMap) getKyotakuList().getData(j))));
            if (listDay > targetDay) {
            	targetDay = listDay;
            }
        }
    	targetDay = targetDay + 1;
    	
    	// �����𒴂�����r���̓o�^����Ă��Ȃ�����T��
    	if (targetDay > maxDay) {
	    	targetDay = 1;
	    	cnt = 0;
	        for (cnt = 1; cnt <= maxDay; cnt++) {
	        	boolean findFlg = false;
	        	for (int j = 0; j < getKyotakuList().size(); j++) {
	                int listDay = ACDateUtilities.getDayOfMonth(
	                        ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE", (VRMap) getKyotakuList().getData(j))));
	                if (listDay == cnt) {
	                	findFlg = true;
	                    break;
	                }
	            }
	        	if (!findFlg) {
	        		break;
	        	}
	        }
	        targetDay = cnt;
    	}
        
        // �Ώی��̓��������ő�o�^�\�����Ƃ��邽�߁A����ȏ�͐V�K�o�^�ł��Ȃ��B
        if (targetDay > maxDay) {
            return;
        }
        
        Date addDate = ACDateUtilities.createDate(
                ACDateUtilities.getYear(getTargetDate()), ACDateUtilities.getMonth(getTargetDate()), targetDay);
        param.setData("TARGET_DATE", addDate);
        param.setData("PROCESS_MODE", new Integer(
                QkanConstants.PROCESS_MODE_INSERT));

        // ���J�ڏ���
        ACAffairInfo affair = null;
        affair = new ACAffairInfo(QC005.class.getName(), param);
        // ����ʂɑJ�ڂ���B
        ACFrame.getInstance().next(affair);

    }

    /**
     * �u�폜�����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void deleteActionPerformed(ActionEvent e) throws Exception {

        // ��ʂ̢����×{�Ǘ��w�����ꗗ��̍s���I������Ă��邩�`�F�b�N����B
        if (getKyotakuTable().isSelected()) {
            // �I������Ă���ꍇ

            // �폜�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_DELETE
            int msgID = QkanMessageList.getInstance().WARNING_OF_DELETE(
                    "�I�𒆂̋���×{�Ǘ��w�������");

            // ��͂��������
            if (msgID == ACMessageBox.RESULT_YES) {

                // ���݂̑I���s��ޔ�����
                int sel = getKyotakuTable().getSelectedModelRow();

                // �폜�������s���B
                if (!doDelete()) {
                    // ���炩�̃G���[�����������ꍇ�����𒆒f����
                    return;
                }

                // �폜��̗��z�ƂȂ�s�ԍ���ݒ肷��
                getKyotakuTable().setSelectedSortedRowOnAfterDelete(sel);

            }

            // ��������������
            // �����𔲂���B�i�������s��Ȃ��j
            return;

        }

    }

    /**
     * �u��ʐ���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void kyotakuTableSelectionChanged(ListSelectionEvent e)
            throws Exception {

        // �Ɩ��{�^���̏�Ԃ�ύX����
        setState();

    }

    /**
     * �u��ʑJ�ڏ����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void kyotakuTableMouseClicked(MouseEvent e) throws Exception {
        // ���I�����ꂽ����×{�Ǘ��w�����̏��ŁA����ʂɑJ��
        // �@��ʂ́u����×{�Ǘ��w�����ꗗ�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
        VRMap param = new VRHashMap();

        if (getKyotakuTable().isSelected()) {
            // �I������Ă���ꍇ
            // �I������Ă��闘�p�҂́u���p��ID�ƑΏ۔N�����v���擾����B
            param = (VRMap) getKyotakuTable().getSelectedModelRowValue();
            param.setData("PROCESS_MODE", new Integer(
                    QkanConstants.PROCESS_MODE_UPDATE));
        } else {
            // �I������Ă��Ȃ��ꍇ
            // �����𒆒f����B
            return;

        }

        // ���J�ڏ���
        ACAffairInfo affair = null;
        affair = new ACAffairInfo(QC005.class.getName(), param);
        // ����ʂɑJ�ڂ���B
        ACFrame.getInstance().next(affair);

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QC006.class.getName(), param));
    }

    // �����֐�

    /**
     * �u���R�[�h���擾����ʂɐݒ肷��B�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void doFind() throws Exception {
        // ��ʓW�J�p�̏����擾���鏈��
        // ����×{�Ǘ��w�������TABLE�ɑ��݂���A�w�藘�p�҂̎w��N����������擾����B
        doFindKyotaku();

        if (!getKyotakuList().isEmpty()) {
            // �擾�����S�ی��ҏ��iinsurerInfoList�j��insurerTableModel�ɐݒ肷��B
            getKyotakuTableModel().setAdaptee(getKyotakuList());
            
        } else {
            // ��񂪎擾�ł��Ȃ������ꍇ
            getKyotakuList().clearData();
            getKyotakuTableModel().setAdaptee(getKyotakuList());
        }
        
        // �Ɩ��{�^���̏�Ԃ�ύX����
        setState();

        // �X�i�b�v�V���b�g���B�e����B
        getSnapshot().snapshot();

    }

    /**
     * �u����×{�Ǘ��w�������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void doFindKyotaku() throws Exception {
        // ����×{�Ǘ��w���������擾���s���B

        // �擾�̂��߂�HashMap�Fparam�𐶐����A�ȉ���KEY/VALUE��ݒ肷��B
        VRMap sqlParam = new VRHashMap();

        // KEY�FPATIENT_ID�@VALUE�FpatientId
        VRBindPathParser.set("PATIENT_ID", sqlParam,
                new Integer(getPatientID()));
        // KEY�FTARGET_DATE_START VALUE�FtargetDate �̌���
        sqlParam.setData("TARGET_DATE_START",
                ACDateUtilities.toFirstDayOfMonth(getTargetDate()));
        // KEY�FTARGET_DATE_START VALUE�FtargetDate �̌���
        sqlParam.setData("TARGET_DATE_END",
                ACDateUtilities.toLastDayOfMonth(getTargetDate()));

        // ����×{�Ǘ��w�����������擾���AkyotakuTableList�Ɋi�[����B
        String strSql = getSQL_GET_KYOTAKU_RYOYO(sqlParam);
        VRList kh = getDBManager().executeQuery(strSql);
        if (kh.size() > 0) {
            getKyotakuList().clearData();
            setKyotakuList(kh);

            // ����×{�Ǘ��w���������TABLE�p�b�V�u�`�F�b�N�p�Ƀf�[�^��o�^����B
            getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
                    getKyotakuList());

        } else {
            getKyotakuList().clearData();
            setKyotakuList(kh);
        }

    }

    /**
     * �u�I������×{�Ǘ��w�����폜�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public boolean doDelete() throws Exception {
        // ����×{�Ǘ��w���������폜���鏈��

        // �I������Ă��郌�R�[�h�̃��f���̃C���f�b�N�X���i�[����modelRow���`����B
        int modelRow;
        modelRow = getKyotakuTable().getSelectedModelRow();

        try {

            // �g�����U�N�V�������J�n����B
            getDBManager().beginTransaction();
            // �p�b�V�u�^�X�N���N���A����B
            getPassiveChecker().clearPassiveTask();
            // �p�b�V�u�^�X�N��ǉ�����B�i����×{�Ǘ��w�������폜�p�j
            getPassiveChecker().addPassiveUpdateTask(getPASSIVE_CHECK_KEY(),
                    modelRow);

            // �p�b�V�u�`�F�b�N�����s����B
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                // �e�[�u�����b�N�����̂��߃��[���o�b�N
                getDBManager().rollbackTransaction();
                // �p�b�V�u�G���[������ꍇ
                // �G���[���b�Z�[�W��\������B
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // �����𔲂���B�i�����𒆒f����j
                return false;
            }

            // �p�b�V�u�G���[���Ȃ��ꍇ
            // ����×{�Ǘ��w�������폜�p��SQL�����擾����B
            // SQL���擾�̂���VRMap�Fparam���쐬���A���L�̃p�����[�^�[��ݒ肷��B
            VRMap param = new VRHashMap();
            // KEY�FPATIENT_ID VALUE�FpatientId
            // KEY�FTARGET_DATE VALUE�FtargetDate
            param = (VRMap) getKyotakuTable().getSelectedModelRowValue();

            // ����×{�Ǘ��w�������폜�p��SQL�����擾����
            // �擾����SQL�������s����B
            getDBManager().executeUpdate(getSQL_DELETE_KYOTAKU_RYOYO(param));
            // ��������SQL���̎��s����1���G���[���������Ȃ������ꍇ
            // �R�~�b�g����B
            getDBManager().commitTransaction();
            // ����×{�Ǘ��w���������擾���p�b�V�u�`�F�b�N�p�ɑޔ�����B
            doFind();
            // ����I��
            return true;
        } catch (Exception sqlEx) {
            // ��������SQL���̎��s����1�ł��G���[�����������ꍇ
            // ���������[���o�b�N����B
            getDBManager().rollbackTransaction();
            // �����𔲂���B�i�����𒆒f����j
            throw sqlEx;
        }
    }
    
    /**
     * �u�Ɩ��{�^���̏�ԁv��ݒ肷�鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void setState() throws Exception {
        
        // �ő�o�^���͑Ώ۔N���̓����Ƃ���
        int maxDay = ACDateUtilities.getDayOfMonth(ACDateUtilities.toLastDayOfMonth(getTargetDate()));
        
        // ����ʂ̐���
        if (getKyotakuList().size() > 0) {
            
            if (getKyotakuList().size() < maxDay) {

                if (getKyotakuTable().isSelected()) {
                    // �V�K�E�X�V
                    setState_SELECTED();

                } else {
                    // �V�K�̂�
                    setState_NEWSELECTED();
                }
                
            } else {
            	
            	if (getKyotakuTable().isSelected()) {
	                // �X�V�̂݁i�V�K�Ȃ��j
	                setState_NEWUNSELECTED();
	                
            	} else {
                    // �I���Ȃ�
            		setState_UNSELECTED();
                }
            }
            
        } else {
            // �V�K�̂�
            setState_NEWSELECTED();
        }
    }

}
