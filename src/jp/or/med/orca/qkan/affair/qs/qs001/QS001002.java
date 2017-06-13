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
 * �J����: �� ����
 * �쐬��: 2006/01/09  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� ���ԕ\ (QS001002)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServicePrecomputed;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServicePrintParameter;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceSchedulePrintManager;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceUnitCalcurateResult;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceManager;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * ���ԕ\(QS001002)
 */
public class QS001002 extends QS001002Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001002() {
        try {
            initAction(null);
        } catch (Exception ex) {
            ACCommon.getInstance().showExceptionMessage(ex);
        }
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
    }

    /**
     * �u��ʓW�J���C�x���g�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param ownerAffair QS001
     * @throws Exception ������O
     */
    public void initialize(QS001 ownerAffair) throws Exception {
        // ����ʓW�J���̏��������s
        setOwnerAffair(ownerAffair);
        setCalcurater(getOwnerAffair().getCalcurater());
        // ��������Ԃ̐ݒ�
        // ��Ԃ̏����ݒ���s���B
        setState_INIT_STATE();
        // �T�[�r�X�\��Ȃ̂��A�T�[�r�X���тȂ̂����`�F�b�N����B

        setProcessType(getOwnerAffair().getProcessType());
        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            // �T�[�r�X�\��̏ꍇ
            // �u�W�v���̈�(sumups)�v��\������B
            setState_SERVICE_PLAN();
        }else if(getProcessType()==QkanConstants.PROCESS_TYPE_RESULT){
            // �T�[�r�X���т̏ꍇ
            // �u�W�v���̈�(sumups)�v���\���ɂ���B
            setState_SERVICE_RESULT();
        }
        // �����p�ҏ��(�v���x���)�̐ݒ�

        // �v���x�������i�[�p�̃��R�[�h�W�� patientInsureInfoHistoryList�𐶐�����B
        VRList patientInsureInfoHistoryList = getPatientInsureInfoHistoryList();
        // �ł��d���v���x�������i�[�p���R�[�h patientInsureInfoHeaviest �𐶐�����B
        VRMap patientInsureInfoHeaviest = QkanCommon
                .getPatientInsureInfoOnMostHeavy(patientInsureInfoHistoryList);
        if (patientInsureInfoHeaviest != null) {
            // patientInsureInfoHeaviest���A�ő�̌��x�z(LIMIT_RATE)���擾����B
            // �擾�������x�z����ʂ́u���x�z(limit)�v�ɐݒ肷��B
            getLimit().setText(
                    ACCastUtilities.toString(patientInsureInfoHeaviest
                            .getData("LIMIT_RATE")));
            
            setPatientInsureInfoHeaviest(patientInsureInfoHeaviest);
        }
        recalcServiceTotal();
        
        getMonthlySchedule().addDroppableListener(getOwnerAffair());

    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void coordinatePrivateExpensesActionPerformed(ActionEvent e)
            throws Exception {
// ���I������Ă���T�[�r�X�ɑ΂��鎩������s��
// ���W�v���Čv�Z
// �T�[�r�X��ނ��Ƃɉ��L�̏��̍ďW�v���s���B
// �Ǘ��Ώۓ�(�T�[�r�X�̂����AM_SERVICE_CODE.LIMIT_AMOUNT_OBJECT = 1�ł���A����30�����łȂ����́j
// ������(�T�[�r�X���ɐݒ肵������E�����P�ʂ̍��v)
//            �W�v�ɂ���Đ􂢏o���ꂽ�e�T�[�r�X���ƂɁA�����㍇�v(�Ǘ��Ώۓ� - ������)�����Ƃ߂�B                   

        if (getSelectedServiceListBox() != null) {
            Date date = getMonthlySchedule().getTargetDate(
                    getSelectedServiceListBox());
            if (date != null) {
                VRMap service = getSelectedServiceListBox().getSelectedService();
                if (service != null) {
                     if(CareServiceCommon.is30DayOver(service)){
                         //30�����̃T�[�r�X�̏ꍇ
                         //30�����̃T�[�r�X�͑S�z������ɂȂ郁�b�Z�[�W��\�����ď������I������B
                         QkanMessageList.getInstance().QS001_ERROR_OF_EDIT_ON_30_DAY_OVER_SERVICE();
                         return;
                     }
                     
                    // 1����1���P�ʂ̎Z�荀�ځi��{��ԑΉ��^�K�����Ȃǁj��������̑Ώ�
                    service.setData("SERVICE_DATE", date);
                    int reductedUnit = getCalcurater().getReductedUnit(service, false, CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE, null);
                    if (reductedUnit > 0) {
                        
                        // ���������
                        // �uQS001029 ����E������ʁv���J��(�_�C�A���O)�B���̍ہA��L�ŏ��������p�����[�^�𑗂�B
                        // �u����E������ʁv�̏I�����@���`�F�b�N����B
                        if (new QS001006().showModal(service, getMonthlySchedule()
                                .getMasterService(),
                                (VRMap) getHashedProviders().get(
                                        service.getData("PROVIDER_ID")),
                                reductedUnit)) {
                            // �u����v�Ŗ߂��Ă����ꍇ
                            // �u�����z�v�u����t���O�v���X�V����B
                            getOwnerAffair().setServiceModify(true);
                        }
                        // �u����v�Ŗ߂��Ă����ꍇ
                        // �������Ȃ��B
                        
                        // 2009/01/13 [Mizuki Tsutsumi] : add begin / ���ȕ��S�z�������A�F�ύX
                        //�ݒ��A�ĕ`���������
                        this.revalidate();
                        // 2009/01/13 [Mizuki Tsutsumi] : end begin
                    }else{
                        QkanMessageList.getInstance().QS001_ERROR_OF_INVALID_UNIT_ADJUST();
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        ACFrame.debugStart(new ACAffairInfo(QS001002.class.getName()));
    }

    // �����֐�

    /**
     * �u���ԕ\�X�V���C�x���g�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void recalcServiceTotal() throws Exception {
        // �����ԕ\�̒l���ύX���ꂽ�ꍇ�̃C�x���g
        // ���\��/���є���
        // �T�[�r�X�\��Ȃ̂��A�T�[�r�X���тȂ̂����`�F�b�N����B
        int useType=0;
        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
        // �T�[�r�X�\��̏ꍇ
        // �擾�Ώۂ����ԗ\��(SERVICE_DETAIL_GET_PLAN)�Ƃ���B
            useType = QkanConstants.SERVICE_DETAIL_GET_PLAN;
        }else if(getProcessType()==QkanConstants.PROCESS_TYPE_RESULT){
        // �T�[�r�X���т̏ꍇ
            //�擾�Ώۂ����Ԏ���(SERVICE_DETAIL_GET_RESULT)�Ƃ���B
            useType = QkanConstants.SERVICE_DETAIL_GET_RESULT;
        }

            // ���W�v���Čv�Z
            // ���L�̏��̍ďW�v���s���B
            // ���x�z(���p�҂̌��x�z)
            // �Ǘ��Ώۓ�(�T�[�r�X�̂����AM_SERVICE_CODE.LIMIT_AMOUNT_OBJECT =
            // 1�ł���A����30�����łȂ����́j
            // ���ߕ�(���x�z���Ǘ����̏ꍇ�A0�B���x�z���Ǘ����̏ꍇ�A�Ǘ����|���x�z)
            // ������(�T�[�r�X���ɐݒ肵������E�����P�ʂ̍��v)
            // �����㍇�v(�Ǘ��Ώۓ� - ������)
        
            // [ID:0000494][Tozo TANAKA] 2009/04/28 replace begin �y�T�[�r�X�\��z�P�ʐ��T�Z�̗��p�[�ʕ\�������Ή�
//            int adjustTotal = 0;
//            int managementTotal = 0;
//            Map[] totalGroupingCache=new Map[]{new HashMap(), new HashMap()};
//            VRList list = getSchedule(useType, false);
//            
//            // 2008/01/07 [Masahiko Higuchi] add - begin �Ή����e
//            // �ďW�v�������p�[�X������ʂ��Ă݂�
//            QkanValidServiceCommon parser = new QkanValidServiceCommon();
//            VRList cloneServices = new VRArrayList();
//            // �f�[�^�̃N���[�����쐬����B
//            cloneServices.addAll(QkanValidServiceCommon.deepCopyVRList(list));
//            list = new VRArrayList();
//            if(cloneServices != null && !cloneServices.isEmpty()){
//                VRMap patientMap = getCalcurater().getPatientInfo();
//                // �Ώۓ��t
//                Date targetDate = getCalcurater().getTargetDate();
//                list = parser.createValidService(QkanValidServiceManager
//                        .QKAN_CLAIM_PARSE_TYPE, getDBManager(), targetDate,
//                        cloneServices,ACCastUtilities.toInt(patientMap.getData("PATIENT_ID"),0));
//            }
//            // 2008/01/07 [Masahiko Higuchi] add - end �Ή����e
//            
//            
//            Iterator it = list.iterator();
//            while (it.hasNext()) {
//                // �T�[�r�X�R�[�h�f�[�^���擾
//                VRMap row = (VRMap) it.next();
//                managementTotal += getCalcurater().getReductedUnit(row, true, CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT,totalGroupingCache);
//                adjustTotal += ACCastUtilities.toInt(row
//                        .getData("REGULATION_RATE"), 0);
//            }

            //�ʕ\�̏W�v���W�b�N��ʂ��āA�ʕ\�ɋL�ڂ���鋋�t�Ǘ��Ώۓ��P�ʐ��ƒ����P�ʐ����擾����B
            CareServiceSchedulePrintManager mng = new CareServiceSchedulePrintManager();
            mng.initialize(getCalcurater());
            // [ID:0000734][Masahiko.Higuchi] 2012/04 30�����������P���Z�Ή� del begin
            //mng.parse(getSchedule(useType, false));
            // [ID:0000734][Masahiko.Higuchi] 2012/04 30�����������P���Z�Ή� del end
            // [ID:0000734][Masahiko.Higuchi] 2012/04 30�����������P���Z�Ή� add begin
            List monthData = getSchedule(useType, false);
            for(int i=monthData.size()-1; i >= 0; i--) {
                // 30�����̏������P���Z�𖳗����ʕ\�ɕ\�����Ă��邽�ߋ����I�ɒ�������B
                VRMap service = (VRMap)monthData.get(i);
                if(CareServiceCommon.is30DayOver(service)) {
                    monthData.remove(i);
                }
            }
            mng.parse(monthData);
            // [ID:0000734][Masahiko.Higuchi] 2012/04 30�����������P���Z�Ή� add end
            mng.setBuildDivedProvider(false);

            CareServicePrintParameter buildParam = new CareServicePrintParameter();
            buildParam.setPrintParameter(new VRHashMap());
            List list=new ArrayList();
            mng.buildUserSubTable(buildParam, list);

            int adjustTotal = 0;
            int managementTotal = 0;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Iterator provIt = ((List) it.next()).iterator();
                while (provIt.hasNext()) {
                    List ins = (List) provIt.next();
                    if (!ins.isEmpty()) {
                        Map page = (Map) ins.get(0);
                        
                        // �敪�x�����x����P�ʐ�
                        managementTotal += ACCastUtilities.toInt(page
                                .get("main.total.x9"), 0);
                        // �敪�x�����x��𒴂���P�ʐ�
                        adjustTotal += ACCastUtilities.toInt(page
                                .get("main.total.x12"), 0);
                    }
                }
            }
                        
            // [ID:0000494][Tozo TANAKA] 2009/04/28 replace end �y�T�[�r�X�\��z�P�ʐ��T�Z�̗��p�[�ʕ\�������Ή�
            
            
            updateTotal(managementTotal, adjustTotal);
    }

    /**
     * �u�W�v���ׂ̕\���X�V�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param managementTotal int
     * @param adjustTotal int
     * @throws Exception ������O
     */
    public void updateTotal(int managementTotal, int adjustTotal)
            throws Exception {
        int limit = ACCastUtilities.toInt(getLimit().getText(), 0);
        getLimitAmount().setText(ACCastUtilities.toString(managementTotal));
        getAdjustment().setText(ACCastUtilities.toString(adjustTotal));
        getAfterAdjustment().setText(
                ACCastUtilities.toString(managementTotal - adjustTotal));
        getOver().setText(
                ACCastUtilities.toString(Math.max(0, managementTotal- adjustTotal - limit)));
    }

    /**
     * �u�Ώ۔N����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void setTargetDate(Date targetDate) throws Exception {
        // �����ԕ\�̑Ώ۔N����ݒ�
        // ���ԕ\�̑Ώ۔N����ݒ肷��B
        getMonthlySchedule().setTargetDate(targetDate);
    }

    /**
     * �u�T�[�r�X�`��p�̃Z�������_���ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param renderer ListCellRenderer
     * @throws Exception ������O
     */
    public void setCellRenderer(ListCellRenderer renderer) throws Exception {
        getMonthlySchedule().setCellRenderer(renderer);
    }

    /**
     * �T�[�r�X�}�X�^ ��ݒ肵�܂��B
     * 
     * @param serviceMaster �T�[�r�X�}�X�^
     */
    public void setMasterService(VRMap serviceMaster) {
        getMonthlySchedule().setMasterService(serviceMaster);
    }

    /**
     * �u�X�P�W���[���S�̂�ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param schedules VRList
     * @throws Exception ������O
     */
    public void setSchedule(VRList schedules) throws Exception {
        getMonthlySchedule().setSchedule(schedules);
        if(getOwnerAffair()!=null){
        getOwnerAffair().setServiceModify(true);
        }
    }

    /**
     * �u�X�P�W���[���S�̂��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param useType int
     * @param includeFreeday boolean
     * @throws Exception ������O
     * @return VRList
     */
    public VRList getSchedule(int useType, boolean includeFreeday) throws Exception {
        return getMonthlySchedule().getSchedule(useType, includeFreeday);
    }

    /**
     * �X�P�W���[���f�[�^������Ԃ��܂��B
     * 
     * @return �X�P�W���[���f�[�^����
     */
    public int getScheduleCount() throws Exception {
        return getMonthlySchedule().getScheduleCount();
    }

    /**
     * �u���X�g�I���C�x���g���X�i��ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param listener ListSelectionListener
     * @throws Exception ������O
     */
    public void addListSelectionListener(ListSelectionListener listener) {
        getMonthlySchedule().addListSelectionListener(listener);
    }

    /**
     * �u���X�g�I���C�x���g���X�i��ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param listener KeyListener
     * @throws Exception ������O
     */
    public void addKeyListener(KeyListener listener) {
        getMonthlySchedule().addKeyListener(listener);
    }

    /**
     * �u�X�P�W���[�����������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void clearSchedule() throws Exception {
        getMonthlySchedule().clearSchedule();
        getOwnerAffair().setServiceModify(true);
    }

    /**
     * �u�X�P�W���[�����������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param clearBegin Date
     * @throws Exception ������O
     */
    public void clearSchedule(Date clearBegin) throws Exception {
        getMonthlySchedule().clearSchedule(clearBegin);
    }

    /**
     * �u�X�P�W���[����ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param schedules VRList
     * @throws Exception ������O
     */
    public void addSchedule(VRList schedules) throws Exception {
        getMonthlySchedule().addSchedule(schedules);
    }

    /**
     * �u�T�[�r�X�̑I���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param service QS001Service
     * @param selectedServiceListBox QS001DaySchedule
     * @throws Exception ������O
     */
    public void setSelectedService(QS001Service service,
            QS001DaySchedule selectedServiceListBox) throws Exception {
        // ���T�[�r�X�̑I����Ԃɉ����ĉ�ʏ�Ԃ�ݒ�
        // �I�����Ă���T�[�r�X�p�l���N���X������ϐ�(selectedServiceClass)�ɑޔ�����B
        setSelectedServiceClass(service);
        // �I�����Ă���T�[�r�X�����L���郊�X�g�{�b�N�X������ϐ�(selectedServiceListBox)�ɑޔ�����B
        setSelectedServiceListBox(selectedServiceListBox);
        if (service != null) {
            // �T�[�r�X���I������Ă���i�T�[�r�X�p�l����null�łȂ��j�ꍇ
            if (getMonthlySchedule().isInCalendarSchedule(
                    getSelectedServiceListBox())) {
                // �I�����Ă���T�[�r�X�����L���郊�X�g�{�b�N�X�����ԕ\�̊J�n�������ł���T�[�r�X�p�̃��X�g�{�b�N�X�̏ꍇ
                // �T�[�r�X��I����Ԃɂ���B
                setState_SERVICE_SELECTED();
            } else {
                // �I�����Ă���T�[�r�X�����L���郊�X�g�{�b�N�X�����ԕ\�̊J�n�������ł���T�[�r�X�p�̃��X�g�{�b�N�X�ł͂Ȃ��ꍇ
                // �T�[�r�X�𖢑I����Ԃɂ���B
                setState_SERVICE_UNSELECTED();
            }
        } else {
            // �T�[�r�X���I������Ă��Ȃ��i�T�[�r�X�p�l����null�j�̏ꍇ
            // �T�[�r�X�𖢑I����Ԃɂ���B
            setState_SERVICE_UNSELECTED();
        }
    }

    /**
     * �u�P�ʏW�v�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void calcurateActionPerformed(ActionEvent e) throws Exception {
        // ���ݒ肳��Ă���T�[�r�X�̒P�ʏW�v
        // �ݒ肳��Ă���T�[�r�X�̒P�ʏW�v���s���B
        recalcServiceTotal();

    }

    /**
     * �u�W�v���ׁv�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void detailsbuttonActionPerformed(ActionEvent e) throws Exception {
        // ���W�v���ׂ�\������
        // ���\��/���є���
        // �T�[�r�X�\��Ȃ̂��A�T�[�r�X���тȂ̂����`�F�b�N����B
        int useType=0;
        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
        // �T�[�r�X�\��̏ꍇ
        // �擾�Ώۂ����ԗ\��(SERVICE_DETAIL_GET_PLAN)�Ƃ���B
            useType = QkanConstants.SERVICE_DETAIL_GET_PLAN;
        }else if(getProcessType()==QkanConstants.PROCESS_TYPE_RESULT){
        // �T�[�r�X���т̏ꍇ
            //�擾�Ώۂ����Ԏ���(SERVICE_DETAIL_GET_RESULT)�Ƃ���B
            useType = QkanConstants.SERVICE_DETAIL_GET_RESULT;
        }

        // ���W�v���Čv�Z
        // �T�[�r�X��ނ��Ƃɉ��L�̏��̍ďW�v���s���B
        // �Ǘ��Ώۓ�(�T�[�r�X�̂����AM_SERVICE_CODE.LIMIT_AMOUNT_OBJECT = 1�ł���A����30�����łȂ����́j
        // ������(�T�[�r�X���ɐݒ肵������E�����P�ʂ̍��v)
        
        VRList list = getSchedule(useType, false);
        
        // 2008/01/07 [Masahiko Higuchi] add - begin �Ή����e
        // �W�v���ׂ��p�[�X������ʂ��Ă݂�
        QkanValidServiceCommon parser = new QkanValidServiceCommon();
        VRList cloneServices = new VRArrayList();
        // �f�[�^�̃N���[�����쐬����B
        cloneServices.addAll(QkanValidServiceCommon.deepCopyVRList(list));
        list = new VRArrayList();
        if(cloneServices != null && !cloneServices.isEmpty()){
            VRMap patientMap = getCalcurater().getPatientInfo();
            // �Ώۓ��t
            Date targetDate = getCalcurater().getTargetDate();
            list = parser.createValidService(getDBManager(), targetDate,
                    cloneServices,ACCastUtilities.toInt(patientMap.getData("PATIENT_ID"),0));
        }
        // 2008/01/07 [Masahiko Higuchi] add - end �Ή����e

        
        CareServiceUnitCalcurateResult inLimitAmout = getCalcurater()
                .getServiceUnitCalcurateResult(list,
                        CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT);

        // �W�v�ɂ���Đ􂢏o���ꂽ�e�T�[�r�X���ƂɁA�����㍇�v(�Ǘ��Ώۓ� - ������)�����Ƃ߂�B
        updateTotal(inLimitAmout.getManagementTotal(), inLimitAmout.getAdjustTotal());

        // ���W�v���׉��
        // �uQS001030 �W�v���׉�ʁv���J��(�_�C�A���O)�B���̍ہA��L�ŏ��������p�����[�^�𑗂�B
        new QS001005().showModal(inLimitAmout, getPatientInsureInfoHeaviest(), getProcessType(), getCalcurater(), list);
    }

    /**
     * �u����\�v���`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return boolean
     */
    public boolean checkPrintable() throws Exception {
        // ������������s�ɕK�v�ȗv���𖞂����Ă��邩���`�F�b�N���A���̌��ʂ�Ԃ��B

        // �����̗v���F�藚���̂����ł��d���v���x�̔F�藚�����擾����B
        VRMap info = QkanCommon
                .getPatientInsureInfoOnMostHeavy(getPatientInsureInfoHistoryList());
        if (info == null) {
            // �F�藚�����擾�ł��Ȃ������ꍇ
            // �F�藚�������݂��Ȃ��G���[��\�����Afalse��Ԃ��B
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_INSURE_INFO();
            return false;
        }

        // ���у��[�h�Ȃ�Ζ�������true��Ԃ��A�֐����I������B
        if (getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
            //���тȂ�Ώ�Ɉ���\
            return true;
        }

        //�ďW�v���W�b�N��ʂ��B
        recalcServiceTotal();
        int limitRate = ACCastUtilities.toInt(getLimit().getText(), 0);
        int managementTotal = ACCastUtilities.toInt(getAfterAdjustment().getText(), 0);

        if (limitRate < managementTotal) {
            // �����ςݒP�ʂ̍��Z���A�����̍ł��d���v���F�藚���̎x�����x�z�𒴂��Ă���ꍇ
            // �x�����x�z�̒��߃G���[��\�����Afalse��Ԃ��B
            QkanMessageList.getInstance().QS001_ERROR_OF_LIMIT_RATE_OVER();
            return false;
        }
        if(managementTotal<0){
            //�����㍇�v��0����
            QkanMessageList.getInstance().QS001_ERROR_OF_MINIMUM_OVER();
            return false;
        }
        // ���Ȃ����true��Ԃ��B
        return true;
    }

    /**
     * �uDB�}�l�[�W���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     *
     * @throws Exception ������O
     * @return ACDBManager
     */
    public ACDBManager getDBManager() throws Exception {
        return getCalcurater().getDBManager();
    }

    /**
     * �u�v���F�藚���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     *
     * @throws Exception ������O
     * @return VRList
     */
    public VRList getPatientInsureInfoHistoryList() throws Exception {
        return getCalcurater().getPatientInsureInfoHistoryList();
    }

    /**
     * �u���Ə����n�b�V���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     *
     * @throws Exception ������O
     * @return VRMap
     */
    public VRMap getHashedProviders() throws Exception {
        return getCalcurater().getHashedProviders();
    }

    /**
     * �u�J�n���̓���ł��Ȃ��T�[�r�X���X�g�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     *
     * @throws Exception ������O
     * @return QS001DaySchedule
     */
    public QS001DaySchedule getDayFreeServices() throws Exception {
        return getMonthlySchedule().getDayFreeServices();
    }

    /**
     * �u�v��P�ʐ��ҏW�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void planUnitActionPerformed(ActionEvent e) throws Exception {
        // ���v��P�ʐ��ҏW��ʂ̕\��
        QS001004 form = new QS001004();
        
        // [H28.4�@�����Ή�][Shinobu Hitaka] 2016/01/29 add begin
        // �Ώ۔N����H28.4�ȑO�̏ꍇ�A�ǉ��T�[�r�X��ޖ���\�����Ȃ�����
        form.setTargetDate(getCalcurater().getTargetDate());
        // [H28.4�@�����Ή�][Shinobu Hitaka] 2016/01/29 add end
        
        // �v��P�ʐ��\����ʂ��u����v�{�^���ŕ����ꍇ
        if (form.showModal(getPlanUnits())) {
            // �ێ����Ă���v��P�ʐ��������ւ���B
            setPlanUnits(form.getAppliedValue());
            getOwnerAffair().setServiceModify(true);
        }
    }

    /**
     * �u�v��P�ʐ����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     *
     * @throws Exception ������O
     * @return VRMap
     */
    public VRMap getServicePlanUnits() throws Exception {
        return getPlanUnits();
    }

    /**
     * �u�v��P�ʐ���ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     *
     * @param services VRMap
     * @throws Exception ������O
     *
     */
    public void setServicePlanUnits(VRMap services) throws Exception {
        setPlanUnits(services);
    }

	@Override
	protected void tokubetuButtonActionPerformed(ActionEvent e)
			throws Exception {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

        int useType=0;
        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
        // �T�[�r�X�\��̏ꍇ
        // �擾�Ώۂ����ԗ\��(SERVICE_DETAIL_GET_PLAN)�Ƃ���B
            useType = QkanConstants.SERVICE_DETAIL_GET_PLAN;
        }else if(getProcessType()==QkanConstants.PROCESS_TYPE_RESULT){
        // �T�[�r�X���т̏ꍇ
            //�擾�Ώۂ����Ԏ���(SERVICE_DETAIL_GET_RESULT)�Ƃ���B
            useType = QkanConstants.SERVICE_DETAIL_GET_RESULT;
        }        
        VRList list = getSchedule(useType, false);
		VRMap regulationMap = new VRHashMap();
		VRMap diagnosisMap = new VRHashMap();
		
        QS001008 form = new QS001008();
        
        // ��͏���
        CareServicePrecomputed mng = new CareServicePrecomputed();
        mng.setPrecomputedResult(getDBManager(), list, regulationMap, diagnosisMap);
        
        // �v��P�ʐ��\����ʂ��u����v�{�^���ŕ����ꍇ
        form.showModal(mng.getDiagnosisDateMap(), getCalcurater().getTargetDate());
		
	}

}
