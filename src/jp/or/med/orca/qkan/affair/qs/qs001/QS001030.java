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
 * �J����: �c���@����
 * �쐬��: 2006/02/15  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �W�v���׉�� (QS001030)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServicePrintParameter;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceSchedulePrintManager;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceUnitCalcurateResult;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * �W�v���׉��(QS001030)
 */
public class QS001030 extends QS001030Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001030() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void closeActionPerformed(ActionEvent e) throws Exception {
        // ����ʂ����
        // ��ʂ�j�����܂��B
        dispose();
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001030.class.getName(), param));
    }

    // �����֐�

    /**
     * �u�����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param inLimitAmout CareServiceUnitCalcurateResult
     * @param insureInfo VRMap
     * @param procesType int
     * @throws Exception ������O
     */
    public void showModal(CareServiceUnitCalcurateResult inLimitAmout,
            VRMap insureInfo, int processType,
            CareServiceCodeCalcurater calcurater, VRList services)
            throws Exception {
        // ����ʓW�J���̏����ݒ�
        CareServiceUnitCalcurateResult outerService = calcurater
        .getServiceUnitCalcurateResult(services,
                CareServiceCodeCalcurater.CALC_MODE_OUTER_SERVICE_LIMIT_AMOUNT);

        
        // �����������Ƀe�[�u�����f�����쐬���A�W�v���׃e�[�u��(detailsTable)�ɐݒ肷��B
        getDetailsTable().setModel(
                new ACTableModelAdapter(inLimitAmout, new String[] {
                        "SYSTEM_SERVICE_KIND_DETAIL", "UNIT", "ADJUST",
                        "RESULT", }));
        getOuterTable().setModel(
                new ACTableModelAdapter(outerService, new String[] {
                        "SYSTEM_SERVICE_KIND_DETAIL", "UNIT", "ADJUST",
                        "RESULT", }));
        getContents().setSource(insureInfo);
        getContents().bindSource();

        // �����p�ҕ��S�z�T�Z���Z�o���Z�o����B
        checkInLimitAmount(calcurater, services, inLimitAmout, outerService);

        // ���E�B���h�E�^�C�g���̐ݒ�
        // �Ɩ���񃌃R�[�h���擾����B
        // �E�B���h�E�^�C�g���ɁA�擾���R�[�h��KEY : WINDOW_TITLE��VALUE��ݒ肷��B
        setAffairTitle("QS001030");

        if (processType == QkanConstants.PROCESS_TYPE_PLAN) {
            setState_PROCESS_TYPE_PLAN();
        } else {
            setState_PROCESS_TYPE_RESULT();
        }

        setVisible(true);
    }


    /**
     * �u���t�Ǘ��ΏۊT�Z�Z�o�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param calcurater CareServiceCodeCalcurater
     * @param services VRList
     * @throws Exception ������O
     */
    public void checkInLimitAmount(CareServiceCodeCalcurater calcurater,
            VRList services,CareServiceUnitCalcurateResult inLimitAmout,CareServiceUnitCalcurateResult outLimitAmout)
            throws Exception {

        
        // �����p�ҕ��S�z�T�Z���Z�o
        
        //���ʕ\�ɋL�ڂ��Ȃ����t�Ǘ��ΏۊO�P�ʐ��̌v�Z
        // ���Z�p�̐�����錾���A0�ŏ���������B
        int total = 0;
        // �W�v�P�ʌv�Z�p�̃}�b�v�z��(Map[])��v�f��2�̐錾���������Ő�������B
        Map[] totalGroupingCache = new Map[] { new HashMap(), new HashMap() };
        Iterator it = services.iterator();
        while (it.hasNext()) {
            // �T�[�r�X��S��������B
            VRMap service = (VRMap) it.next();
            if (CareServiceCommon.isLifeCare(service)||CareServiceCommon.isHomeMedicalAdvice(service)) {
                //�ʕ\�ɋL�ڂ���Ȃ��������/����×{�Ǘ��w���T�[�r�X�̒P�ʐ������Z����B
                // �����ςݒP�ʐ����v�Z���A���Z�ɉ��Z����B
                total += calcurater.getReductedUnit(service, true,
                        CareServiceCodeCalcurater.CALC_MODE_OUT_LIMIT_AMOUNT,
                        totalGroupingCache);
            }
        }
        
        //�ʕ\�̏W�v���W�b�N��ʂ��āA�ʕ\�ɋL�ڂ���鋋�t�Ǘ��ΏۊO�P�ʐ��Ɨ��p�ҕ��S�z���擾����B
        CareServiceSchedulePrintManager mng = new CareServiceSchedulePrintManager();
        mng.initialize(calcurater);
        mng.parse(services);
        mng.setBuildDivedProvider(false);

        int lastRow = mng.getUserSubTableRowCount();
        CareServicePrintParameter buildParam = new CareServicePrintParameter();
        buildParam.setPrintParameter(new VRHashMap());
        List list=new ArrayList();
        mng.buildUserSubTable(buildParam, list);
        int patientCost = 0;
        int outLimitUnit = 0;
        it = list.iterator();
        while (it.hasNext()) {
            Iterator provIt = ((List) it.next()).iterator();
            while (provIt.hasNext()) {
                List ins = (List) provIt.next();
                if (!ins.isEmpty()) {
                    Map page = (Map) ins.get(0);
                    patientCost += ACCastUtilities.toInt(page
                            .get("main.total.x18"), 0)
                            + ACCastUtilities.toInt(page.get("main.total.x19"),
                                    0);
                    Iterator insIt = ins.iterator();
                    while (insIt.hasNext()) {
                        page = (Map) insIt.next();
                        for (int i = 1; i < lastRow; i++) {
                            String unit = ACCastUtilities.toString(page
                                    .get("main.y" + i + ".x12"));
                            if (!ACTextUtilities.isNullText(unit)) {
                                if (unit.charAt(0) == '(') {
                                    outLimitUnit += ACCastUtilities
                                            .toInt(unit.substring(1, unit
                                                    .length() - 2), 0);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        //�ʕ\�ɋL�ڂ��ꂽ���p�ҕ��S�z�Ɛ������/����×{�Ǘ��w���T�[�r�X�̒P�ʐ�(=�T�Z)�̍��Z�𕉒S�z�T�Z(aboutCalc)�̒l�Ƃ��ĕ\������B
        getAboutCalc().setText(ACCastUtilities.toString(patientCost+total));
        //�ʕ\�ɋL�ڂ��ꂽ���t�Ǘ��ΏۊO�P�ʐ��Ɛ������/����×{�Ǘ��w���T�[�r�X�̒P�ʐ��̍��Z�����t�Ǘ��ΏۊO�P�ʐ�(homeMedicalAdvice)�̒l�Ƃ��ĕ\������B
        getHomeMedicalAdvice().setText(ACCastUtilities.toString(outLimitUnit+total));

        
        // �����t�Ǘ��Ώۓ��T�[�r�X���Z�o
        int adj = inLimitAmout.getAdjustTotal();
        int adjusted = inLimitAmout.getManagementTotal() - adj;
        int limit = ACCastUtilities.toInt(getInLimitAmountLimit().getText(), 0);

        //������P�ʐ��Ǝx�����x�z�̂ǂ��炩�Ⴂ�ق������x���P�ʐ��Ƃ��ĕ\������B
        getInLimitAmountValue().setText(
                ACCastUtilities.toString(Math.min(adjusted, limit)));
        
        
    }

}
