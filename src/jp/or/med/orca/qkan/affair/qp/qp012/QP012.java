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
 * �쐬��: 2006/08/22  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �K��Ō�×{��̎����ҏW (012)
 * �v���O���� �K��Ō�×{��̎����ҏW (QP012)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp012;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * �K��Ō�×{��̎����ҏW(QP012)
 */
public class QP012 extends QP012Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP012() {
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
        // ��ʂ����������܂��B
        // ��������`
        // �Ɩ��̃E�B���h�E�^�C�g���E�{�^���o�[�Ƀ^�C�g����ݒ肷��B
        setAffairTitle("QP012");
        // ���p�b�V�u�L�[(BILL_PASSIVE_CHECK_KEY)���`����B
        // �e�[�u���FCLAIM_PATIENT_MEDICAL
        // �L�[�FCLAIM_PATIENT_MEDICAL_ID
        // �t�H�[�}�b�g�F�Ȃ�
        // �N���C�A���g�^�C���t�B�[���h�FLAST_TIME
        // �T�[�o�[�^�C���t�B�[���h�FLAST_TIME
        setBILL_PASSIVE_CHECK_KEY(new ACPassiveKey("CLAIM_PATIENT_MEDICAL",
                new String[] { "CLAIM_PATIENT_MEDICAL_ID" }, "LAST_TIME",
                "LAST_TIME"));
        setByInsurerAndPatientNameCache(new HashSet());
        // �X�i�b�v�V���b�g�̑ΏۂɃN���C�A���g�̈�(contents)�A���O�Ώۂɍ��v�̈�(totalContents)��ݒ肷��B
        getSnapshot().setRootContainer(getContents(),
                new Component[] { getTotalContents() });
        getSnapshot().snapshot();

        // ����^���R���{�̓ǂݍ���
        // ��ʓW�J�p�̃��R�[�hinfo���`�E��������B
        VRMap info = new VRHashMap();
        // SQL�����p�̃��R�[�hsqlParam���`�E��������B
        VRMap sqlParam = new VRHashMap();
        // ���R�[�hsqlParam�ɃL�[�uFIXED_FORM_ID�v�A�l�u1�v��ݒ肷��B
        VRBindPathParser.set("FIXED_FORM_ID", sqlParam, new Integer(1));
        // ��^���e�[�u������A�ی����S���p�̒�^�����擾����B
        VRList pureForms = getDBManager().executeQuery(
                getSQL_SELECT_FIXED_FORM(sqlParam));
        VRList forms = new VRArrayList();
        ACBindUtilities.toListFromSingleRowMap(pureForms, forms);
        // ���R�[�hinfo�ɃL�[�uBY_INSURER_NAME�v�Ŏ擾������^���ꗗ�����蓖�Ă�B
        VRBindPathParser.set("BY_INSURER_NAME", info, forms);
        // ���R�[�hsqlParam�ɃL�[�uFIXED_FORM_ID�v�A�l�u2�v��ݒ肷��B
        VRBindPathParser.set("FIXED_FORM_ID", sqlParam, new Integer(2));
        // ��^���e�[�u������A�ی��O���S���p�̒�^�����擾����B
        pureForms = getDBManager().executeQuery(
                getSQL_SELECT_FIXED_FORM(sqlParam));
        forms = new VRArrayList();
        ACBindUtilities.toListFromSingleRowMap(pureForms, forms);
        // ���R�[�hinfo�ɃL�[�uBY_PATIENT_NAME�v�Ŏ擾������^���ꗗ�����蓖�Ă�B
        VRBindPathParser.set("BY_PATIENT_NAME", info, forms);
        // �N���C�A���g�̈�(contents)�Ƀ��R�[�hinfo�����f�����蓖�āE�W�J����B
        getItemContents().setModelSource(info);
        getItemContents().bindModelSource();

        // ���o�^�E�X�V���[�h�̔���
        if (!VRBindPathParser.has("PATIENT_ID", affair.getParameters())) {
            // �J�ڃp�����^�ɃL�[�uPATIENT_ID�v���Ȃ��ꍇ
            // �v���Z�X���[�h���u�X�V���[�h�v�ɐݒ肷��B
            setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
            // ��ʏ�Ԃ��X�V���[�h(UPDATE_MODE)�ɂ���B
            setState_UPDATE_MODE();
            if (!VRBindPathParser.has("CLAIM_PATIENT_MEDICAL_ID", affair
                    .getParameters())) {
                // �J�ڃp�����^�ɃL�[�uCLAIM_PATIENT_MEDICAL_ID�v���Ȃ��ꍇ
                // �s���ȃp�����^�������͍폜���ꂽ���Ƃ݂Ȃ��A���b�Z�[�W��\������B�����b�Z�[�WID = NOT_FOUND
                QkanMessageList.getInstance().NOT_FOUND("�̎���");
                // �O��ʂɖ߂菈���𒆒f����B
                ACFrame.getInstance().back();
                return;
            }
            // �J�ڃp�����^�������ɁA����SQL���𔭍s����B
            VRList bills = getDBManager().executeQuery(
                    getSQL_SELECT_BILL(affair.getParameters()));
            if (bills.isEmpty()) {
                // �������ʂ����݂��Ȃ��ꍇ
                // �s���ȃp�����^�������͍폜���ꂽ���Ƃ݂Ȃ��A���b�Z�[�W��\������B�����b�Z�[�WID = NOT_FOUND
                QkanMessageList.getInstance().NOT_FOUND("�̎���");
                // �O��ʂɖ߂菈���𒆒f����B
                ACFrame.getInstance().back();
                return;
            }
            VRMap bill = (VRMap) bills.getData();
            // �����ϐ�claimMedicalID�ɑJ�ڃp�����^�̃L�[�uCLAIM_PATIENT_MEDICAL_ID�v�̒l��ޔ�����B
            setClaimMedicalID(ACCastUtilities.toInt(VRBindPathParser.get(
                    "CLAIM_PATIENT_MEDICAL_ID", affair.getParameters()), 0));
            // �����ϐ�patientID�Ɍ������ʂ̃L�[�uPATIENT_ID�v�̒l��ޔ�����B
            setPatientID(ACCastUtilities.toInt(VRBindPathParser.get(
                    "PATIENT_ID", bill), 0));
            // �����ϐ�billStart�Ɍ������ʂ̃L�[�uBILL_SPAN_START�v�̒l��ޔ�����B
            setBillStart(ACCastUtilities.toDate(VRBindPathParser.get(
                    "BILL_SPAN_START", bill), null));
            // �����ϐ�billEnd�Ɍ������ʂ̃L�[�uBILL_SPAN_END�v�̒l��ޔ�����B
            setBillEnd(ACCastUtilities.toDate(VRBindPathParser.get(
                    "BILL_SPAN_END", bill), null));
            // �����ϐ�byPatientRateValue�Ɍ������ʂ̃L�[�uBY_PATIENT_RATE�v�̒l��ޔ�����B
            setByPatientRateValue(ACCastUtilities.toInt(VRBindPathParser.get(
                    "BY_PATIENT_RATE", bill), 0));

            // ����19�N4������(��{����)�Ή������ׂ������肷��B
            checkInnerTaxModeH1804();

            // �������ʂ���ʂɊ��蓖�āE�W�J����B
            getContents().setSource(bill);
            getContents().bindSource();

            // �O�Ń`�F�b�N����я���œ��e�L�X�g�̗L����Ԃ�ݒ肷��B
            ACTextField[] prices = getByPatientPrices();
            ACTextField[] numbers = getByPatientNumbers();
            ACTextField[] sums = getByPatientSums();
            ACIntegerCheckBox[] taxTargets = getByPatientTaxTargets();
            ACIntegerCheckBox[] useTaxs = getByPatientUseTaxs();
            ACTextField[] taxs = getByPatientTaxs();
            int taxEnd = useTaxs.length;
            for (int i = 0; i < taxEnd; i++) {
                getByPatientSumCache().put(sums[i], sums[i].getText());
                doCheckTax(prices[i], numbers[i], sums[i], taxTargets[i],
                        useTaxs[i], taxs[i], false);
            }

            // �������ʂ��p�b�V�u�f�[�^�Ƃ��ēo�^����B
            getPassiveChecker().reservedPassive(getBILL_PASSIVE_CHECK_KEY(),
                    bills);
        } else {
            // �J�ڃp�����^�ɃL�[�uPATIENT_ID�v������ꍇ
            // �v���Z�X���[�h���u�o�^���[�h�v�ɐݒ肷��B
            setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
            // �����ϐ�patientID�ɑJ�ڃp�����^�̃L�[�uPATIENT_ID�v�̒l��ޔ�����B
            setPatientID(ACCastUtilities.toInt(VRBindPathParser.get(
                    "PATIENT_ID", affair.getParameters()), 0));
        }
        // �����p�ҏ��̎擾�E�W�J
        // �����ϐ�patientID���L�[�uPATIENT_ID�v�Ŋi�[�������R�[�h�������ɁA���p�ҏ����擾����B
        VRList patients = QkanCommon.getPatientInfo(getDBManager(),
                getPatientID());
        if (patients.isEmpty()) {
            // ���p�ҏ����擾�ł��Ȃ������ꍇ
            // �s���ȃp�����^�������͍폜���ꂽ���Ƃ݂Ȃ��A���b�Z�[�W��\������B�����b�Z�[�WID = NOT_FOUND
            QkanMessageList.getInstance().NOT_FOUND("���p��");
            // �O��ʂɖ߂菈���𒆒f����B
            ACFrame.getInstance().back();
            return;
        }
        VRMap patient = (VRMap) patients.getData();
        // �擾�������p�҂̎������������Ď���(patientName)�ɐݒ肷��B
        getPatientName().setText(
                QkanCommon.toFullName(VRBindPathParser.get(
                        "PATIENT_FAMILY_NAME", patient), VRBindPathParser.get(
                        "PATIENT_FIRST_NAME", patient)));

        if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
            // �v���Z�X���[�h���u�o�^�v�̏ꍇ
            // ����ʂ̏����ݒ�
            // ��ʏ�Ԃ�o�^���[�h(INSERT_MODE)�ɂ���B
            setState_INSERT_MODE();
            Date start = ACCastUtilities.toDate(VRBindPathParser.get(
                    "BILL_SPAN_START", affair.getParameters()), null);
            Date end = ACCastUtilities.toDate(VRBindPathParser.get(
                    "BILL_SPAN_END", affair.getParameters()), null);
            if ((start == null) || (end == null)) {
                // �J�ڃp�����^�ɃL�[�uBILL_SPAN_START�v��uBILL_SPAN_END�v���Ȃ��ꍇ
                // �s���ȃp�����^�������͍폜���ꂽ���Ƃ݂Ȃ��A���b�Z�[�W��\������B�����b�Z�[�WID = NOT_FOUND
                QkanMessageList.getInstance().NOT_FOUND("��������");
                // �O��ʂɖ߂菈���𒆒f����B
                ACFrame.getInstance().back();
                return;
            }
            // �����ی����̈�(insurerContents)�ɑJ�ڃp�����^�����蓖�āE�W�J����B
            getInsurerContents().setSource(affair.getParameters());
            getInsurerContents().bindSource();
            // �����ϐ�billStart�ɑJ�ڃp�����^�̃L�[�uBILL_SPAN_START�v�̒l��ޔ�����B
            setBillStart(start);
            // �����ϐ�billEnd�ɑJ�ڃp�����^�̃L�[�uBILL_SPAN_END�v�̒l��ޔ�����B
            setBillEnd(end);
            // �ی��O���S�̊O�Ń`�F�b�N�����ׂĕt����B
            ACIntegerCheckBox[] useTaxs = getByPatientUseTaxs();
            int taxEnd = useTaxs.length;
            for (int i = 0; i < taxEnd; i++) {
                useTaxs[i].setSelected(true);
            }

            // ����19�N4������(��{����)�Ή������ׂ������肷��B
            checkInnerTaxModeH1804();

            // ���Ҕԍ�(patientCode)�ɗ��p�҃R�[�h��ݒ肷��B
            getPatientCode().setText(
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "PATIENT_CODE", patient)));
            // ���s��(printDate)�Ƀ��O�C�����t��ݒ肷��B
            getPrintDate().setDate(
                    QkanSystemInformation.getInstance().getSystemDate());
            // ����ŗ�(tax)�Ƀ}�X�^�̏���ŗ���ݒ肷��B
            double val = QkanCommon.getTax(getDBManager());
            if (val >= 0) {
                getTax().setText(ACCastUtilities.toString(val));
            }
            // �����������̕���
            if (VRBindPathParser.has("CLAIM_PATIENT_MEDICAL_ID", affair
                    .getParameters())) {
                // �J�ڃp�����^�ɃL�[�uCLAIM_PATIENT_MEDICAL_ID�v������ꍇ
                // �J�ڃp�����^�������Ƃ��āA�������̗̎����̊��Ҕԍ��E�ی��O���S�E���l���擾����SQL���𔭍s����B
                VRList bills = getDBManager().executeQuery(
                        getSQL_SELECT_COPY_BILL(affair.getParameters()));
                if (!bills.isEmpty()) {
                    // �������̗̎��������擾�ł����ꍇ
                    // �擾����������ʂɓW�J����B
                    getContents().setSource((VRMap) bills.getData());
                    getContents().bindSource();

                    // �O�Ń`�F�b�N���t���Ă���΁A����œ�����L���ɂ���B
                    ACTextField[] taxs = getByPatientTaxs();
                    for (int i = 0; i < taxEnd; i++) {
                        taxs[i].setEnabled(useTaxs[i].isSelected());
                    }

                }
            }
            // �����т̓ǂݍ���
            // �������Ԃ̎��т�ǂݍ���ŉ�ʂɓW�J����B
            if (!doOpenResult(false)) {
                // ���т̓ǂݍ��݂Ɏ��s�����ꍇ
                // �O��ʂɖ߂菈���𒆒f����B
                ACFrame.getInstance().back();
                return;
            }
        }
        // ���񋟓��R���{�̍œK��
        // �f�[�^���W�p�̃��R�[�hinfo���`�E��������B
        info = new VRHashMap();
        // �������ԊJ�n�N����(billSpanStart)�Ƀ��R�[�hinfo�����蓖�āE���W����B
        getBillSpanStart().setSource(info);
        getBillSpanStart().applySource();
        // ���R�[�hinfo�̃L�[�uBILL_SPAN_START�v�̒l��Date�l�ɕϊ����A���������̓��ɂ��ňȉ��̒ʂ蕪�򂷂�B
        switch (ACDateUtilities.getDayOfMonth(ACDateUtilities
                .toLastDayOfMonth(ACCastUtilities.toDate(VRBindPathParser.get(
                        "BILL_SPAN_START", info))))) {
        case 28:
            // ������28���̏ꍇ
            // ��ʏ�Ԃ��ő�񋟓�28��(MAX_DAY_28)�ɂ���B
            setState_MAX_DAY_28();
            break;
        case 29:
            // ������29���̏ꍇ
            // ��ʏ�Ԃ��ő�񋟓�29��(MAX_DAY_29)�ɂ���B
            setState_MAX_DAY_29();
            break;
        case 30:
            // ������30���̏ꍇ
            // ��ʏ�Ԃ��ő�񋟓�30��(MAX_DAY_30)�ɂ���B
            setState_MAX_DAY_30();
            break;
        default:
            // ����ȊO
            // ��ʏ�Ԃ��ő�񋟓�31��(MAX_DAY_31)�ɂ���B
            setState_MAX_DAY_31();
            break;
        }
        // ��ʂ̃X�i�b�v�V���b�g�����B
        getSnapshot().snapshot();

        ACTextField[] sums = getByPatientSums();
        for (int i = 0; i < sums.length; i++) {
            getByPatientSumCache().put(sums[i], sums[i].getText());
        }
        ACComboBox[] names = getByInsurerNamesAndPatientNames();
        for (int i = 0; i < names.length; i++) {
            if (!ACTextUtilities.isNullText(names[i])) {
                getByInsurerAndPatientNameCache().add(names[i]);
            }
        }

    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // �O��ʑJ�ڎ��ɑI�����������n���B
        // ���ύX�`�F�b�N
        if (getSnapshot().isModified()) {
            // �X�i�b�v�V���b�g�ɕω�������ꍇ
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // �v���Z�X���[�h���u�o�^���[�h�v�̏ꍇ
                // �o�^�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_INSERT_ON_MODIFIED
                switch (QkanMessageList.getInstance()
                        .WARNING_OF_INSERT_ON_MODIFIED()) {
                case ACMessageBox.RESULT_YES:
                    // �u�o�^���Ė߂�v������
                    // �ۑ��������s���B
                    if (!doInsert()) {
                        // �ۑ������Ɏ��s�����ꍇ
                        // �O��ʑ@�ۂ��������A�֐��𔲂���B
                        return false;
                    }
                    break;
                case ACMessageBox.RESULT_NO:
                    // �u�j�����Ė߂�v������
                    // �������Ȃ��B
                    break;
                default:
                    // ����ȊO
                    // �O��ʑ@�ۂ��������A�֐��𔲂���B
                    return false;
                }
            } else {
                // �v���Z�X���[�h���u�X�V���[�h�v�̏ꍇ
                // �X�V�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_UPDATE_ON_MODIFIED
                switch (QkanMessageList.getInstance()
                        .WARNING_OF_UPDATE_ON_MODIFIED()) {
                case ACMessageBox.RESULT_YES:
                    // �u�X�V���Ė߂�v������
                    // �ۑ��������s���B
                    if (!doUpdate()) {
                        // �ۑ������Ɏ��s�����ꍇ
                        // �O��ʑ@�ۂ��������A�֐��𔲂���B
                        return false;
                    }
                    break;
                case ACMessageBox.RESULT_NO:
                    // �u�j�����Ė߂�v������
                    // �������Ȃ��B
                    break;
                default:
                    // ����ȊO
                    // �O��ʑ@�ۂ��������A�֐��𔲂���B
                    return false;
                }
            }
        }
        // ���J�ڃp�����^�̐ݒ�
        if (getClaimMedicalID() > 0) {
            // �����ϐ�claimMedicalID��0���傫���ꍇ
            // �J�ڃp�����^�Ɉȉ���ݒ肷��B
            // KEY : CLAIM_PATIENT_MEDICAL_ID, VALUE : �����ϐ�claimMedicalID
            VRBindPathParser.set("CLAIM_PATIENT_MEDICAL_ID", parameters,
                    ACCastUtilities.toInteger(getClaimMedicalID()));
        } else {
            // �����ϐ�claimMedicalID��0���傫���Ȃ��ꍇ
            // �J�ڃp�����^����L�[�uCLAIM_PATIENT_MEDICAL_ID�v���폜����B
            parameters.remove("CLAIM_PATIENT_MEDICAL_ID");
        }

        // �O��ʑJ�ڂ�������B
        return true;
    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // �I�����ɕۑ��m�F���s���B
        if (getSnapshot().isModified()) {
            // �X�i�b�v�V���b�g�ɕω�������ꍇ
            // �I���m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_CLOSE_ON_MODIFIED
            if (QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED() != ACMessageBox.RESULT_OK) {
                // �uOK�v�����ȊO
                // �I�����������A�֐��𔲂���B
                return false;
            }
        }
        // �I����������B
        return true;
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u���ѓǂݍ��݁v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void openActionPerformed(ActionEvent e) throws Exception {
        // ���ѓǂݍ��݂��s���B
        // �ǂݍ��݊m�F�̃��b�Z�[�W��\������B�����b�Z�[�WID = QP012_WARNING_OF_OPEN_RESULT
        if (QkanMessageList.getInstance().QP012_WARNING_OF_OPEN_RESULT() != ACMessageBox.RESULT_OK) {
            // OK�{�^���ȊO���������ꂽ�ꍇ
            // �����𒆒f����B
            return;
        }
        // �������Ԃ̎��т�ǂݍ���ŉ�ʂɓW�J����B
        doOpenResult(true);

    }

    /**
     * �u�o�^�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // ���݂̏���o�^���[�h�ŕۑ�����B
        // �o�^�������s�Ȃ��B
        if (doInsert()) {

            // �o�^�ɐ��������ꍇ
            // �������b�Z�[�W��\������B�����b�Z�[�WID = INSERT_SUCCESSED
            QkanMessageList.getInstance().INSERT_SUCCESSED();
        }
    }

    /**
     * �u�X�V�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {
        // ���݂̏����X�V���[�h�ŕۑ�����B
        // �X�V�������s�Ȃ��B
        if (doUpdate()) {

            // �X�V�ɐ��������ꍇ
            // �������b�Z�[�W��\������B�����b�Z�[�WID = UPDATE_SUCCESSED
            QkanMessageList.getInstance().UPDATE_SUCCESSED();
        }
    }

    /**
     * �u����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void printActionPerformed(ActionEvent e) throws Exception {
        // ������s���B
        if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
            // �o�^���[�h�̏ꍇ
            // �ۑ������m�F�̃��b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_DO_PRINT
            if (QkanMessageList.getInstance().WARNING_OF_DO_PRINT("�o�^",
                    "�K��Ō�×{��̎���") != ACMessageBox.RESULT_OK) {
                // �uOK�v���������Ă��Ȃ��ꍇ
                // �����𒆒f����B
                return;
            }
            // �ۑ��������s���B
            if (!doInsert()) {

                // �ۑ������Ɏ��s�����ꍇ
                // �����𒆒f����B
                return;
            }
        } else if (getSnapshot().isModified()) {
            // �o�^���[�h�ȊO�ŃX�i�b�v�V���b�g�ɕω�������ꍇ
            // �ۑ������m�F�̃��b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_DO_PRINT
            if (QkanMessageList.getInstance().WARNING_OF_DO_PRINT("�X�V",
                    "�K��Ō�×{��̎���") != ACMessageBox.RESULT_OK) {
                // �uOK�v���������Ă��Ȃ��ꍇ
                // �����𒆒f����B
                return;
            }
            // �ۑ��������s���B
            if (!doUpdate()) {
                // �ۑ������Ɏ��s�����ꍇ
                // �����𒆒f����B
                return;
            }
        }
        // ����p�����^������킷���R�[�hparam���`�E��������B
        VRMap param = new VRHashMap();
        // �N���C�A���g�̈�(contents)�Ƀ��R�[�hparam�����蓖�āE���W����B
        getContents().setSource(param);
        getContents().applySource();
        // ���W�����f�[�^�̃o�C���h�p�X���t�B���^�����O����B
        filterBindPath(param);

        // ���R�[�hparam�ɃL�[�uDBM�v��DBManager��ݒ肷��B
        VRBindPathParser.set("DBM", param, getDBManager());
        // ���R�[�hparam�ɃL�[�uInnerTaxH1904Mode�v��InnerTaxH1904Mode��ݒ肷��B
        VRBindPathParser.set("InnerTaxH1904Mode", param, new Boolean(
                getInnerTaxH1904Mode()));

        ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
        writer.beginPrintEdit();
        // ����N���X(QP012P01)�𐶐����A����p�����^�������Ɉ�������s����B
        if (new QP012P01().doPrint(writer, param)) {
            // ����ɐ��������ꍇ
            writer.endPrintEdit();
            ACChotarouXMLUtilities.openPDF(writer);
            // ����ς݂ɂ��邩�̊m�F���b�Z�[�W��\������B�����b�Z�[�WID = QP012_QUESTION_OF_PRINT_COMMIT
            if (QkanMessageList.getInstance().QP012_QUESTION_OF_PRINT_COMMIT() == ACMessageBox.RESULT_OK) {
                // �u�͂��v�����������ꍇ
                // ����ς݃t���O���ς݂ɍX�V����SQL���𔭍s����B���p�b�V�u�`�F�b�N�͍s��Ȃ��B
                VRMap sqlParam = new VRHashMap();
                VRBindPathParser.set("CLAIM_PATIENT_MEDICAL_ID", sqlParam,
                        ACCastUtilities.toInteger(getClaimMedicalID()));
                getDBManager()
                        .executeUpdate(getSQL_UPDATE_TO_PRINTED(sqlParam));
            }
        }
    }

    /**
     * �u�ŗ��ύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void taxChangeActionPerformed(ActionEvent e) throws Exception {
        // �ŗ����Đݒ肵�܂��B
        // �ŗ��ύX�m�F�̃��b�Z�[�W��\������B�����b�Z�[�WID = QP012_QUESTION_OF_TAX_CHANGE
        if (QkanMessageList.getInstance().QP012_QUESTION_OF_TAX_CHANGE() != ACMessageBox.RESULT_OK) {
            // �uOK�v�ȊO���������ꂽ�ꍇ
            // �����𒆒f����B
            return;
        }
        // ����ŗ�(tax)�Ƀ}�X�^�̏���ŗ���ݒ肷��B
        getTax().setText(
                ACCastUtilities.toString(QkanCommon.getTax(getDBManager())));
        // �V�����ŗ��ŁA�ی��O���S�����ڂ̐ŕ��̍Čv�Z�ƁA���v���̍Čv�Z���s���B
        doCalcTax();
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice1FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice1(), getByInsurerNumber1(),
                getByInsurerSum1());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber1FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice1(), getByInsurerNumber1(),
                getByInsurerSum1());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum1FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice2FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice2(), getByInsurerNumber2(),
                getByInsurerSum2());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber2FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice2(), getByInsurerNumber2(),
                getByInsurerSum2());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum2FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice3FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice3(), getByInsurerNumber3(),
                getByInsurerSum3());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber3FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice3(), getByInsurerNumber3(),
                getByInsurerSum3());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum3FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice4FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice4(), getByInsurerNumber4(),
                getByInsurerSum4());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber4FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice4(), getByInsurerNumber4(),
                getByInsurerSum4());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum4FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice5FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice5(), getByInsurerNumber5(),
                getByInsurerSum5());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber5FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice5(), getByInsurerNumber5(),
                getByInsurerSum5());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum5FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice6FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice6(), getByInsurerNumber6(),
                getByInsurerSum6());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber6FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice6(), getByInsurerNumber6(),
                getByInsurerSum6());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum6FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice7FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice7(), getByInsurerNumber7(),
                getByInsurerSum7());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber7FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice7(), getByInsurerNumber7(),
                getByInsurerSum7());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum7FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice8FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice8(), getByInsurerNumber8(),
                getByInsurerSum8());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber8FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice8(), getByInsurerNumber8(),
                getByInsurerSum8());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum8FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice9FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice9(), getByInsurerNumber9(),
                getByInsurerSum9());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber9FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice9(), getByInsurerNumber9(),
                getByInsurerSum9());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum9FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice10FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice10(), getByInsurerNumber10(),
                getByInsurerSum10());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber10FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice10(), getByInsurerNumber10(),
                getByInsurerSum10());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum10FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice1FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice1(), getByPatientNumber1(),
                getByPatientSum1(), getByPatientTaxTarget1(),
                getByPatientUseTax1(), getByPatientTax1(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber1FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice1(), getByPatientNumber1(),
                getByPatientSum1(), getByPatientTaxTarget1(),
                getByPatientUseTax1(), getByPatientTax1(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum1FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum1(), getByPatientTaxTarget1(),
                getByPatientUseTax1(), getByPatientTax1());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget1ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice1(), getByPatientNumber1(),
                getByPatientSum1(), getByPatientTaxTarget1(),
                getByPatientUseTax1(), getByPatientTax1(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax1ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice1(), getByPatientNumber1(),
                getByPatientSum1(), getByPatientTaxTarget1(),
                getByPatientUseTax1(), getByPatientTax1(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax1FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice2FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice2(), getByPatientNumber2(),
                getByPatientSum2(), getByPatientTaxTarget2(),
                getByPatientUseTax2(), getByPatientTax2(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber2FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice2(), getByPatientNumber2(),
                getByPatientSum2(), getByPatientTaxTarget2(),
                getByPatientUseTax2(), getByPatientTax2(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum2FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum2(), getByPatientTaxTarget2(),
                getByPatientUseTax2(), getByPatientTax2());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget2ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice2(), getByPatientNumber2(),
                getByPatientSum2(), getByPatientTaxTarget2(),
                getByPatientUseTax2(), getByPatientTax2(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax2ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice2(), getByPatientNumber2(),
                getByPatientSum2(), getByPatientTaxTarget2(),
                getByPatientUseTax2(), getByPatientTax2(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax2FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice3FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice3(), getByPatientNumber3(),
                getByPatientSum3(), getByPatientTaxTarget3(),
                getByPatientUseTax3(), getByPatientTax3(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber3FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice3(), getByPatientNumber3(),
                getByPatientSum3(), getByPatientTaxTarget3(),
                getByPatientUseTax3(), getByPatientTax3(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum3FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum3(), getByPatientTaxTarget3(),
                getByPatientUseTax3(), getByPatientTax3());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget3ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice3(), getByPatientNumber3(),
                getByPatientSum3(), getByPatientTaxTarget3(),
                getByPatientUseTax3(), getByPatientTax3(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax3ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice3(), getByPatientNumber3(),
                getByPatientSum3(), getByPatientTaxTarget3(),
                getByPatientUseTax3(), getByPatientTax3(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax3FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice4FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice4(), getByPatientNumber4(),
                getByPatientSum4(), getByPatientTaxTarget4(),
                getByPatientUseTax4(), getByPatientTax4(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber4FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice4(), getByPatientNumber4(),
                getByPatientSum4(), getByPatientTaxTarget4(),
                getByPatientUseTax4(), getByPatientTax4(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum4FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum4(), getByPatientTaxTarget4(),
                getByPatientUseTax4(), getByPatientTax4());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget4ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice4(), getByPatientNumber4(),
                getByPatientSum4(), getByPatientTaxTarget4(),
                getByPatientUseTax4(), getByPatientTax4(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax4ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice4(), getByPatientNumber4(),
                getByPatientSum4(), getByPatientTaxTarget4(),
                getByPatientUseTax4(), getByPatientTax4(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax4FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice5FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice5(), getByPatientNumber5(),
                getByPatientSum5(), getByPatientTaxTarget5(),
                getByPatientUseTax5(), getByPatientTax5(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber5FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice5(), getByPatientNumber5(),
                getByPatientSum5(), getByPatientTaxTarget5(),
                getByPatientUseTax5(), getByPatientTax5(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum5FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum5(), getByPatientTaxTarget5(),
                getByPatientUseTax5(), getByPatientTax5());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget5ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice5(), getByPatientNumber5(),
                getByPatientSum5(), getByPatientTaxTarget5(),
                getByPatientUseTax5(), getByPatientTax5(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax5ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice5(), getByPatientNumber5(),
                getByPatientSum5(), getByPatientTaxTarget5(),
                getByPatientUseTax5(), getByPatientTax5(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax5FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice6FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice6(), getByPatientNumber6(),
                getByPatientSum6(), getByPatientTaxTarget6(),
                getByPatientUseTax6(), getByPatientTax6(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber6FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice6(), getByPatientNumber6(),
                getByPatientSum6(), getByPatientTaxTarget6(),
                getByPatientUseTax6(), getByPatientTax6(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum6FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum6(), getByPatientTaxTarget6(),
                getByPatientUseTax6(), getByPatientTax6());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget6ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice6(), getByPatientNumber6(),
                getByPatientSum6(), getByPatientTaxTarget6(),
                getByPatientUseTax6(), getByPatientTax6(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax6ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice6(), getByPatientNumber6(),
                getByPatientSum6(), getByPatientTaxTarget6(),
                getByPatientUseTax6(), getByPatientTax6(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax6FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice7FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice7(), getByPatientNumber7(),
                getByPatientSum7(), getByPatientTaxTarget7(),
                getByPatientUseTax7(), getByPatientTax7(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber7FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice7(), getByPatientNumber7(),
                getByPatientSum7(), getByPatientTaxTarget7(),
                getByPatientUseTax7(), getByPatientTax7(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum7FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum7(), getByPatientTaxTarget7(),
                getByPatientUseTax7(), getByPatientTax7());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget7ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice7(), getByPatientNumber7(),
                getByPatientSum7(), getByPatientTaxTarget7(),
                getByPatientUseTax7(), getByPatientTax7(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax7ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice7(), getByPatientNumber7(),
                getByPatientSum7(), getByPatientTaxTarget7(),
                getByPatientUseTax7(), getByPatientTax7(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax7FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice8FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice8(), getByPatientNumber8(),
                getByPatientSum8(), getByPatientTaxTarget8(),
                getByPatientUseTax8(), getByPatientTax8(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber8FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice8(), getByPatientNumber8(),
                getByPatientSum8(), getByPatientTaxTarget8(),
                getByPatientUseTax8(), getByPatientTax8(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum8FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum8(), getByPatientTaxTarget8(),
                getByPatientUseTax8(), getByPatientTax8());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget8ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice8(), getByPatientNumber8(),
                getByPatientSum8(), getByPatientTaxTarget8(),
                getByPatientUseTax8(), getByPatientTax8(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax8ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice8(), getByPatientNumber8(),
                getByPatientSum8(), getByPatientTaxTarget8(),
                getByPatientUseTax8(), getByPatientTax8(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax8FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice9FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice9(), getByPatientNumber9(),
                getByPatientSum9(), getByPatientTaxTarget9(),
                getByPatientUseTax9(), getByPatientTax9(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber9FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice9(), getByPatientNumber9(),
                getByPatientSum9(), getByPatientTaxTarget9(),
                getByPatientUseTax9(), getByPatientTax9(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum9FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum9(), getByPatientTaxTarget9(),
                getByPatientUseTax9(), getByPatientTax9());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget9ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice9(), getByPatientNumber9(),
                getByPatientSum9(), getByPatientTaxTarget9(),
                getByPatientUseTax9(), getByPatientTax9(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax9ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice9(), getByPatientNumber9(),
                getByPatientSum9(), getByPatientTaxTarget9(),
                getByPatientUseTax9(), getByPatientTax9(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax9FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice10FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice10(), getByPatientNumber10(),
                getByPatientSum10(), getByPatientTaxTarget10(),
                getByPatientUseTax10(), getByPatientTax10(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber10FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice10(), getByPatientNumber10(),
                getByPatientSum10(), getByPatientTaxTarget10(),
                getByPatientUseTax10(), getByPatientTax10(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum10FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum10(), getByPatientTaxTarget10(),
                getByPatientUseTax10(), getByPatientTax10());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget10ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice10(), getByPatientNumber10(),
                getByPatientSum10(), getByPatientTaxTarget10(),
                getByPatientUseTax10(), getByPatientTax10(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax10ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice10(), getByPatientNumber10(),
                getByPatientSum10(), getByPatientTaxTarget10(),
                getByPatientUseTax10(), getByPatientTax10(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax10FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName1FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName1());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName2FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName2());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName3FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName3());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName4FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName4());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName5FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName5());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName6FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName6());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName7FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName7());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName8FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName8());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName9FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName9());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName10FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName10());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName1FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName1());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName2FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName2());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName3FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName3());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName4FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName4());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName5FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName5());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName6FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName6());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName7FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName7());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName8FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName8());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName9FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName9());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName10FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName10());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice11FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice11(), getByInsurerNumber11(),
                getByInsurerSum11());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber11FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice11(), getByInsurerNumber11(),
                getByInsurerSum11());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum11FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice12FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice12(), getByInsurerNumber12(),
                getByInsurerSum12());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber12FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice12(), getByInsurerNumber12(),
                getByInsurerSum12());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum12FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice13FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice13(), getByInsurerNumber13(),
                getByInsurerSum13());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber13FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice13(), getByInsurerNumber13(),
                getByInsurerSum13());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum13FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice14FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice14(), getByInsurerNumber14(),
                getByInsurerSum14());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber14FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice14(), getByInsurerNumber14(),
                getByInsurerSum14());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum14FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice15FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice15(), getByInsurerNumber15(),
                getByInsurerSum15());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber15FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice15(), getByInsurerNumber15(),
                getByInsurerSum15());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum15FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice16FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice16(), getByInsurerNumber16(),
                getByInsurerSum16());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber16FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice16(), getByInsurerNumber16(),
                getByInsurerSum16());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum16FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice17FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice17(), getByInsurerNumber17(),
                getByInsurerSum17());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber17FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice17(), getByInsurerNumber17(),
                getByInsurerSum17());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum17FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice18FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice18(), getByInsurerNumber18(),
                getByInsurerSum18());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber18FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice18(), getByInsurerNumber18(),
                getByInsurerSum18());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum18FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice19FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice19(), getByInsurerNumber19(),
                getByInsurerSum19());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber19FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice19(), getByInsurerNumber19(),
                getByInsurerSum19());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum19FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerPrice20FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice20(), getByInsurerNumber20(),
                getByInsurerSum20());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerNumber20FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByInsurerPrice20(), getByInsurerNumber20(),
                getByInsurerSum20());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerSum20FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice11FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice11(), getByPatientNumber11(),
                getByPatientSum11(), getByPatientTaxTarget11(),
                getByPatientUseTax11(), getByPatientTax11(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber11FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice11(), getByPatientNumber11(),
                getByPatientSum11(), getByPatientTaxTarget11(),
                getByPatientUseTax11(), getByPatientTax11(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum11FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum11(), getByPatientTaxTarget11(),
                getByPatientUseTax11(), getByPatientTax11());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget11ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice11(), getByPatientNumber11(),
                getByPatientSum11(), getByPatientTaxTarget11(),
                getByPatientUseTax11(), getByPatientTax11(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax11ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice11(), getByPatientNumber11(),
                getByPatientSum11(), getByPatientTaxTarget11(),
                getByPatientUseTax11(), getByPatientTax11(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax11FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice12FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice12(), getByPatientNumber12(),
                getByPatientSum12(), getByPatientTaxTarget12(),
                getByPatientUseTax12(), getByPatientTax12(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber12FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice12(), getByPatientNumber12(),
                getByPatientSum12(), getByPatientTaxTarget12(),
                getByPatientUseTax12(), getByPatientTax12(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum12FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum12(), getByPatientTaxTarget12(),
                getByPatientUseTax12(), getByPatientTax12());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget12ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice12(), getByPatientNumber12(),
                getByPatientSum12(), getByPatientTaxTarget12(),
                getByPatientUseTax12(), getByPatientTax12(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax12ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice12(), getByPatientNumber12(),
                getByPatientSum12(), getByPatientTaxTarget12(),
                getByPatientUseTax12(), getByPatientTax12(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax12FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice13FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice13(), getByPatientNumber13(),
                getByPatientSum13(), getByPatientTaxTarget13(),
                getByPatientUseTax13(), getByPatientTax13(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber13FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice13(), getByPatientNumber13(),
                getByPatientSum13(), getByPatientTaxTarget13(),
                getByPatientUseTax13(), getByPatientTax13(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum13FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum13(), getByPatientTaxTarget13(),
                getByPatientUseTax13(), getByPatientTax13());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget13ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice13(), getByPatientNumber13(),
                getByPatientSum13(), getByPatientTaxTarget13(),
                getByPatientUseTax13(), getByPatientTax13(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax13ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice13(), getByPatientNumber13(),
                getByPatientSum13(), getByPatientTaxTarget13(),
                getByPatientUseTax13(), getByPatientTax13(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax13FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice14FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice14(), getByPatientNumber14(),
                getByPatientSum14(), getByPatientTaxTarget14(),
                getByPatientUseTax14(), getByPatientTax14(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber14FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice14(), getByPatientNumber14(),
                getByPatientSum14(), getByPatientTaxTarget14(),
                getByPatientUseTax14(), getByPatientTax14(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum14FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum14(), getByPatientTaxTarget14(),
                getByPatientUseTax14(), getByPatientTax14());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget14ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice14(), getByPatientNumber14(),
                getByPatientSum14(), getByPatientTaxTarget14(),
                getByPatientUseTax14(), getByPatientTax14(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax14ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice14(), getByPatientNumber14(),
                getByPatientSum14(), getByPatientTaxTarget14(),
                getByPatientUseTax14(), getByPatientTax14(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax14FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice15FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice15(), getByPatientNumber15(),
                getByPatientSum15(), getByPatientTaxTarget15(),
                getByPatientUseTax15(), getByPatientTax15(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber15FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice15(), getByPatientNumber15(),
                getByPatientSum15(), getByPatientTaxTarget15(),
                getByPatientUseTax15(), getByPatientTax15(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum15FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum15(), getByPatientTaxTarget15(),
                getByPatientUseTax15(), getByPatientTax15());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax15ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice15(), getByPatientNumber15(),
                getByPatientSum15(), getByPatientTaxTarget15(),
                getByPatientUseTax15(), getByPatientTax15(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget15ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice15(), getByPatientNumber15(),
                getByPatientSum15(), getByPatientTaxTarget15(),
                getByPatientUseTax15(), getByPatientTax15(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax15FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice16FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice16(), getByPatientNumber16(),
                getByPatientSum16(), getByPatientTaxTarget16(),
                getByPatientUseTax16(), getByPatientTax16(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber16FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice16(), getByPatientNumber16(),
                getByPatientSum16(), getByPatientTaxTarget16(),
                getByPatientUseTax16(), getByPatientTax16(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum16FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum16(), getByPatientTaxTarget16(),
                getByPatientUseTax16(), getByPatientTax16());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget16ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice16(), getByPatientNumber16(),
                getByPatientSum16(), getByPatientTaxTarget16(),
                getByPatientUseTax16(), getByPatientTax16(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax16ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice16(), getByPatientNumber16(),
                getByPatientSum16(), getByPatientTaxTarget16(),
                getByPatientUseTax16(), getByPatientTax16(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax16FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice17FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice17(), getByPatientNumber17(),
                getByPatientSum17(), getByPatientTaxTarget17(),
                getByPatientUseTax17(), getByPatientTax17(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber17FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice17(), getByPatientNumber17(),
                getByPatientSum17(), getByPatientTaxTarget17(),
                getByPatientUseTax17(), getByPatientTax17(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum17FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum17(), getByPatientTaxTarget17(),
                getByPatientUseTax17(), getByPatientTax17());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget17ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice17(), getByPatientNumber17(),
                getByPatientSum17(), getByPatientTaxTarget17(),
                getByPatientUseTax17(), getByPatientTax17(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax17ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice17(), getByPatientNumber17(),
                getByPatientSum17(), getByPatientTaxTarget17(),
                getByPatientUseTax17(), getByPatientTax17(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax17FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice18FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice18(), getByPatientNumber18(),
                getByPatientSum18(), getByPatientTaxTarget18(),
                getByPatientUseTax18(), getByPatientTax18(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber18FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice18(), getByPatientNumber18(),
                getByPatientSum18(), getByPatientTaxTarget18(),
                getByPatientUseTax18(), getByPatientTax18(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum18FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum18(), getByPatientTaxTarget18(),
                getByPatientUseTax18(), getByPatientTax18());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget18ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice18(), getByPatientNumber18(),
                getByPatientSum18(), getByPatientTaxTarget18(),
                getByPatientUseTax18(), getByPatientTax18(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax18ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice18(), getByPatientNumber18(),
                getByPatientSum18(), getByPatientTaxTarget18(),
                getByPatientUseTax18(), getByPatientTax18(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax18FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice19FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice19(), getByPatientNumber19(),
                getByPatientSum19(), getByPatientTaxTarget19(),
                getByPatientUseTax19(), getByPatientTax19(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber19FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice19(), getByPatientNumber19(),
                getByPatientSum19(), getByPatientTaxTarget19(),
                getByPatientUseTax19(), getByPatientTax19(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum19FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum19(), getByPatientTaxTarget19(),
                getByPatientUseTax19(), getByPatientTax19());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget19ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice19(), getByPatientNumber19(),
                getByPatientSum19(), getByPatientTaxTarget19(),
                getByPatientUseTax19(), getByPatientTax19(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax19ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice19(), getByPatientNumber19(),
                getByPatientSum19(), getByPatientTaxTarget19(),
                getByPatientUseTax19(), getByPatientTax19(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax19FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientPrice20FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice20(), getByPatientNumber20(),
                getByPatientSum20(), getByPatientTaxTarget20(),
                getByPatientUseTax20(), getByPatientTax20(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientNumber20FocusLost(FocusEvent e) throws Exception {
        // ���s�̋��z��̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientPrice20(), getByPatientNumber20(),
                getByPatientSum20(), getByPatientTaxTarget20(),
                getByPatientUseTax20(), getByPatientTax20(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientSum20FocusLost(FocusEvent e) throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCalcSum(getByPatientSum20(), getByPatientTaxTarget20(),
                getByPatientUseTax20(), getByPatientTax20());

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTaxTarget20ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice20(), getByPatientNumber20(),
                getByPatientSum20(), getByPatientTaxTarget20(),
                getByPatientUseTax20(), getByPatientTax20(), false);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientUseTax20ActionPerformed(ActionEvent e)
            throws Exception {
        // ���s�̐ł̍Čv�Z�ƍ��v���̍Čv�Z���s���B
        doCheckTax(getByPatientPrice20(), getByPatientNumber20(),
                getByPatientSum20(), getByPatientTaxTarget20(),
                getByPatientUseTax20(), getByPatientTax20(), true);

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientTax20FocusLost(FocusEvent e) throws Exception {
        // ���v���̍Čv�Z���s���B
        doCalcTotal();

    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName11FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName11());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName12FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName12());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName13FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName13());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName14FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName14());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName15FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName15());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName16FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName16());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName17FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName17());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName18FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName18());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName19FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName19());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byInsurerName20FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByInsurerName20());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName11FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName11());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName12FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName12());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName13FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName13());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName14FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName14());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName15FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName15());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName16FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName16());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName17FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName17());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName18FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName18());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName19FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName19());
    }

    /**
     * �u�Čv�Z�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void byPatientName20FocusLost(FocusEvent e) throws Exception {
        // ���ږ��̓��͂��Ď����A�K�v�ɉ����č��v�̍Čv�Z���s���B
        doCheckName(getByPatientName20());
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        param.setData("PATIENT_ID", new Integer(7));
        param
                .setData("BILL_SPAN_START", ACDateUtilities.createDate(2007, 4,
                        1));
        param.setData("BILL_SPAN_END", ACDateUtilities.createDate(2007, 4, 31));
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QP012.class.getName(), param));
    }

    // �����֐�

    /**
     * �u���ѓǂݍ��ݏ����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param fullAleart fullAleart
     * @throws Exception ������O
     * @return boolean
     */
    public boolean doOpenResult(boolean fullAleart) throws Exception {
        // ���т�ǂݍ���ŉ�ʂɓW�J����B���т�ǂݍ��߂Ȃ������ꍇ�͋U(false)��Ԃ��B
        // ���������ԃ`�F�b�N
        // �������ԂɗL���ȕی����̎擾
        // �ȉ��̃p�����^�������ɐ������ԂɗL���ȕی������擾����B
        // �E���p��ID(patientID)
        // �E�����J�n�N����(billStart)
        // �E�����I���N����(billEnd)
        VRList insures = QkanCommon.getMedicalInsureInfo(getDBManager(),
                getPatientID(), getBillStart(), getBillEnd());
        boolean fullPatientRate = false;
        // �L���ȕی���񂪑��݂��Ȃ��ꍇ
        if (insures.isEmpty()) {
            if (fullAleart) {
                // �ی���񂪂Ȃ��ꍇ�Ɍx�����o���ꍇ
                // ���b�Z�[�W��\������B�����b�Z�[�WID = QP012_ERROR_OF_INVALID_INSURE_SPAN
                if (QkanMessageList.getInstance()
                        .QP012_WARNING_OF_INVALID_INSURE_SPAN() != ACMessageBox.RESULT_OK) {
                    // OK�ȊO�����������ꍇ
                    // �����𒆒f���A�U(false)��Ԃ��B
                    return false;
                }
            }
            // �S�z���p�ҕ��S�Ƃ���B
            fullPatientRate = true;
        } else if (insures.size() > 1) {
            // 2�̕ی������܂����鐿�����Ԃ��ݒ肳��Ă���ꍇ
            // ���b�Z�[�W��\������B�����b�Z�[�WID = QP012_ERROR_OF_MULTIPLE_INSURE_SPAN
            QkanMessageList.getInstance().QP012_ERROR_OF_MULTIPLE_INSURE_SPAN();
            // �����𒆒f���A�U(false)��Ԃ��B
            return false;
        }

        // �X�v���b�V����\������B
        ACSplashable splash = ACFrame.getInstance().getFrameEventProcesser()
                .createSplash("����");

        // ��ʓW�J�p�̃��R�[�hinfo���`�E��������B
        VRMap info = new VRHashMap();
        // �����S����
        // ���S����������킷����rate��錾���A0�ŏ���������B
        int rate = 0;
        if (fullPatientRate) {
            // �S�z���p�ҕ��S�̏ꍇ
            // ����rate��10��ݒ肷��B
            rate = 10;
            // ���{�l�E�Ƒ�
            // ���R�[�hinfo�ɃL�[�uSELF_FLAG�v��0��ݒ肷��B
            VRBindPathParser.set("SELF_FLAG", info, ACCastUtilities
                    .toInteger(0));
            // ���敪
            // ���R�[�hinfo�ɃL�[�uBILL_INSURE_TYPE�v�ŋ󕶎���ݒ肷��B
            VRBindPathParser.set("BILL_INSURE_TYPE", info, "");
        } else {
            VRMap insure = (VRMap) insures.getData();
            // �ی����̃L�[�uBENEFIT_RATE�v�̒l�ɂ���Ĉȉ��̒ʂ蕪�򂷂�B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("BENEFIT_RATE",
                    insure), 0)) {
            case 2:
                // �l��2�̏ꍇ�F����rate��1��ݒ肷��B
                rate = 1;
                break;
            case 3:
                // �l��3�̏ꍇ�F����rate��2��ݒ肷��B
                rate = 2;
                break;
            case 4:
                // �l��4�̏ꍇ�F����rate��3��ݒ肷��B
                rate = 3;
                break;
            }
            // ���{�l�E�Ƒ�
            // ���R�[�hinfo�ɃL�[�uSELF_FLAG�v�ŕی����̃L�[�uSELF_FLAG�v�̒l��ݒ肷��B
            VRBindPathParser.set("SELF_FLAG", info, VRBindPathParser.get(
                    "SELF_FLAG", insure));
            // ���敪
            // ���R�[�hinfo�ɃL�[�uBILL_INSURE_TYPE�v�ŕی��敪�Z�o�֐��̌Ăяo�����ʂ�ݒ肷��B
            VRBindPathParser.set("BILL_INSURE_TYPE", info,
                    createInsureType(insure));
        }
        // ���p�ҕ��S����(byPatientRateValue)�ɐ���rate��ݒ肷��B
        setByPatientRateValue(rate);
        // ���R�[�hinfo�ɃL�[�uBY_PATIENT_RATE�v�Ő���rate��ݒ肷��B
        VRBindPathParser.set("BY_PATIENT_RATE", info, ACCastUtilities
                .toInteger(rate));

        // ���񋟓��E�ی��K�p���S�̏W�v
        // �W�v�N���X(QP012001)�𐶐����A�ȉ��������Ƃ��ďW�v���ʂ��擾����B
        // �EpatientID�AbillStart�AbillEnd�ADBManager�AbyPatientRateValue
        // ���R�[�hinfo�ɏW�v���ʂ��}�[�W����B
        info.putAll(new QP012001().calculate(getPatientID(), getBillStart(),
                getBillEnd(), getDBManager()));

        // �N���C�A���g�̈�(contents)�Ƀ��R�[�hinfo�����蓖�āE�W�J����B
        getContents().setSource(info);
        getContents().bindSource();

        if (VRBindPathParser.has("BY_PATIENT_NAME1", info)) {
            // �ی��O���S�̃L�[�����݂���ꍇ
            ACCheckBox[] useTaxs = getByPatientUseTaxs();
            ACTextField[] taxs = getByPatientTaxs();
            ACCheckBox[] taxTargets = getByPatientTaxTargets();
            int end = useTaxs.length;
            // ������19�N4������(��{����)�Ή������ׂ������肷��
            if (getInnerTaxH1904Mode()) {
                // innerTaxH1904Mode��true�̏ꍇ

                // �ی��O���S�̉ېŃ`�F�b�N�����ׂĕt�������B
                // �ی��O���S�̊O�Ń`�F�b�N�����ׂĊO�������B
                for (int i = 0; i < end; i++) {
                    useTaxs[i].setSelected(false);
                    taxs[i].setEnabled(true);
                    taxTargets[i].setSelected(true);
                }
            } else {
                // innerTaxH1904Mode��false�̏ꍇ
                // �ی��O���S�̊O�Ń`�F�b�N�����ׂĕt�������B
                for (int i = 0; i < end; i++) {
                    useTaxs[i].setSelected(true);
                    taxs[i].setEnabled(true);
                    taxTargets[i].setSelected(true);
                }
            }
        }

        // �ŕ��ƍ��v���̍Čv�Z���s��
        doCalcTax();

        // �X�v���b�V���������B
        if (splash != null) {
            splash.close();
            splash = null;
        }

        return true;
    }

    /**
     * �u�o�^�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean doInsert() throws Exception {
        // �o�^�ɐ��������ꍇ�A�^(true)��Ԃ��B
        // �����̓`�F�b�N
        if (!isValidInput()) {
            // ���̓`�F�b�N�̌��ʁA��肪�������ꍇ
            // �����𒆒f����B
            return false;
        }
        // ��SQL�̔��s
        // SQL�����p�̃��R�[�hsqlParam���`�E��������B
        VRMap sqlParam = new VRHashMap();
        // �N���C�A���g�̈�(contents)�Ƀ��R�[�hsqlParam�����蓖�āE���W����B
        getContents().setSource(sqlParam);
        getContents().applySource();
        // ���W�����f�[�^�̃o�C���h�p�X���t�B���^�����O����B
        filterBindPath(sqlParam);
        // ���R�[�hsqlPram�Ɉȉ��̒l��ݒ肷��B
        // �E�L�[�FPATIENT_ID�A�l�FpatientID
        VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities
                .toInteger(getPatientID()));
        // �E�L�[�FPROVIDER_ID�A�l�F���O�C�����Ə�ID
        VRBindPathParser.set("PROVIDER_ID", sqlParam, QkanSystemInformation
                .getInstance().getLoginProviderID());
        // �E�L�[�FBILL_SPAN_START�A�l�FbillStart
        VRBindPathParser.set("BILL_SPAN_START", sqlParam, getBillStart());
        // �E�L�[�FBILL_SPAN_END�A�l�FbillEnd
        VRBindPathParser.set("BILL_SPAN_END", sqlParam, getBillEnd());
        // �g�����U�N�V�������J�n����B
        getDBManager().beginTransaction();
        try {
            // ���R�[�hsqlParam�������ɓo�^SQL���𔭍s����B
            getDBManager().executeUpdate(getSQL_INSERT_BILL(sqlParam));
            // �o�^�����̎����́uCLAIM_PATIENT_MEDICAL_ID�v�uBILL_NO�v�uLAST_TIME�v���擾����B
            VRList bills = getDBManager().executeQuery(
                    getSQL_SELECT_INSERTED_BILL(null));
            VRMap bill = (VRMap) bills.getData();
            // �����ϐ�claimMedicalID�Ɍ������ʂ̃L�[�uCLAIM_PATIENT_MEDICAL_ID�v�̒l��ޔ�����B
            setClaimMedicalID(ACCastUtilities.toInt(VRBindPathParser.get(
                    "CLAIM_PATIENT_MEDICAL_ID", bill)));
            // �̎���No.(billNo)�Ɍ������ʂ̃L�[�uBILL_NO�v�̒l��ݒ肷��B
            getBillNo().setText(
                    ACCastUtilities.toString(VRBindPathParser.get("BILL_NO",
                            bill)));
            // �g�����U�N�V�������R�~�b�g����B
            getDBManager().commitTransaction();
            // �������ʂ��p�b�V�u�f�[�^�Ƃ��ēo�^����B
            getPassiveChecker().reservedPassive(getBILL_PASSIVE_CHECK_KEY(),
                    bills);
        } catch (SQLException ex) {
            // ��O�����������ꍇ
            // �g�����U�N�V���������[���o�b�N����B
            getDBManager().rollbackTransaction();
            // ��O����ʂɓ����ď����𒆒f����B
            throw ex;
        }
        // ���X�V���[�h�ɕύX
        // �v���Z�X���[�h���u�X�V���[�h�v�ɐݒ肷��B
        setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
        // ��ʏ�Ԃ��X�V���[�h(UPDATE_MODE)�ɂ���B
        setState_UPDATE_MODE();
        // ����Ԃ̍ċL��
        // ���W�����f�[�^�������Ƃ��āA�V�K�̒�^����ǉ��o�^����B
        insertFixedForm(sqlParam);
        // �X�i�b�v�V���b�g���Ƃ�B
        getSnapshot().snapshot();
        // �^(true)��Ԃ��B
        return true;
    }

    /**
     * �u�X�V�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean doUpdate() throws Exception {
        // �X�V�ɐ��������ꍇ�A�^(true)��Ԃ��B
        // �����̓`�F�b�N
        // ���̓`�F�b�N�̌��ʁA��肪�������ꍇ
        if (!isValidInput()) {
            // �����𒆒f����B
            return false;
        }
        // ��SQL�̔��s
        // SQL�����p�̃��R�[�hsqlParam���`�E��������B
        VRMap sqlParam = new VRHashMap();
        // �N���C�A���g�̈�(contents)�Ƀ��R�[�hsqlParam�����蓖�āE���W����B
        getContents().setSource(sqlParam);
        getContents().applySource();
        // ���W�����f�[�^�̃o�C���h�p�X���t�B���^�����O����B
        filterBindPath(sqlParam);
        // ���R�[�hsqlPram�Ɉȉ��̒l��ݒ肷��B
        // �E�L�[�FCLAIM_PATIENT_MEDICAL_ID�A�l�FclaimMedicalID
        VRBindPathParser.set("CLAIM_PATIENT_MEDICAL_ID", sqlParam,
                ACCastUtilities.toInteger(getClaimMedicalID()));
        // �E�L�[�FPATIENT_ID�A�l�FpatientID
        VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities
                .toInteger(getPatientID()));
        // �E�L�[�FPROVIDER_ID�A�l�F���O�C�����Ə�ID
        VRBindPathParser.set("PROVIDER_ID", sqlParam, QkanSystemInformation
                .getInstance().getLoginProviderID());
        // �E�L�[�FBILL_SPAN_START�A�l�FbillStart
        VRBindPathParser.set("BILL_SPAN_START", sqlParam, getBillStart());
        // �E�L�[�FBILL_SPAN_END�A�l�FbillEnd
        VRBindPathParser.set("BILL_SPAN_END", sqlParam, getBillEnd());
        // �g�����U�N�V�������J�n����B
        getDBManager().beginTransaction();
        try {
            // �X�V�̃p�b�V�u�`�F�b�N�����s����B
            getPassiveChecker().clearPassiveTask();
            getPassiveChecker().addPassiveUpdateTask(
                    getBILL_PASSIVE_CHECK_KEY());
            // �p�b�V�u�`�F�b�N�̌��ʁA�������������ꍇ
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                // �g�����U�N�V���������[���o�b�N����B
                getDBManager().rollbackTransaction();
                // �p�b�V�u�G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // �U(false)��Ԃ��ď����𒆒f����B
                return false;
            }
            // ���R�[�hsqlParam�������ɓo�^SQL���𔭍s����B
            getDBManager().executeUpdate(getSQL_UPDATE_BILL(sqlParam));
            // �o�^�����̎����́uCLAIM_PATIENT_MEDICAL_ID�v�uLAST_TIME�v���擾����B
            VRList bills = getDBManager().executeQuery(
                    getSQL_SELECT_UPDATED_BILL(sqlParam));
            // �g�����U�N�V�������R�~�b�g����B
            getDBManager().commitTransaction();
            // �������ʂ��p�b�V�u�f�[�^�Ƃ��ēo�^����B
            getPassiveChecker().reservedPassive(getBILL_PASSIVE_CHECK_KEY(),
                    bills);
            // ��O�����������ꍇ
        } catch (SQLException ex) {
            // �g�����U�N�V���������[���o�b�N����B
            getDBManager().rollbackTransaction();
            // ��O����ʂɓ����ď����𒆒f����B
            throw ex;
        }
        // ����Ԃ̍ċL��
        // ���W�����f�[�^�������Ƃ��āA�V�K�̒�^����ǉ��o�^����B
        insertFixedForm(sqlParam);
        // �X�i�b�v�V���b�g���Ƃ�B
        getSnapshot().snapshot();
        // �^(true)��Ԃ��B
        return true;
    }

    /**
     * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean isValidInput() throws Exception {
        // ���͍��ڂ��`�F�b�N���A���ׂĕۑ��\�ȏ�Ԃł���ꍇ�A�^(true)��Ԃ��B
        // �̎��z���v�z(totalFull)�̒l��10���ȏ�̏ꍇ
        if (getTotalFull().getText().replaceAll(",", "").length() > 9) {
            // ���v���z��9���܂ł̃G���[���b�Z�[�W��\������B�����b�Z�[�WID =
            // QP012_ERROR_OF_TOTAL_LIMIT_OVER
            QkanMessageList.getInstance().QP012_ERROR_OF_TOTAL_LIMIT_OVER();
            // �U(false)��Ԃ��B
            return false;
        }
        // �^(true)��Ԃ��B
        return true;
    }

    /**
     * �u���ږ��`�F�b�N�ύX�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param name ACComboBox
     * @throws Exception ������O
     */
    public void doCheckName(ACComboBox name) throws Exception {
        // ���ږ��̓��͂��Ď����č��v�ɔ��f����B
        if (ACTextUtilities.isNullText(name.getText())) {
            // ����name���󗓂̏ꍇ
            if (!getByInsurerAndPatientNameCache().contains(name)) {
                // ����name��byInsurerAndPatientNameCache�Ɋ܂܂�Ă��Ȃ��ꍇ(�ȑO�����)
                // �����𒆒f����B
                return;
            }
            // ����name��byInsurerAndPatientNameCache���珜�O����B
            getByInsurerAndPatientNameCache().remove(name);
        } else {
            // ����name���󗓂ł͂Ȃ��ꍇ
            if (getByInsurerAndPatientNameCache().contains(name)) {
                // ����name��byInsurerAndPatientNameCache�Ɋ܂܂�Ă���ꍇ(�ȑO������͍ς�)
                // �����𒆒f����B
                return;
            }
            // ����name��byInsurerAndPatientNameCache�ɒǉ�����B
            getByInsurerAndPatientNameCache().add(name);
        }
        // ���v�����Čv�Z����B
        doCalcTotal();
    }

    /**
     * �u�ی��K�p���S�̋��z�Čv�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doCalcSum(ACTextField price, ACTextField number, ACTextField sum)
            throws Exception {
        // �ی��K�p���S�̋��z���Čv�Z����B
        // ����price��number�̂����ꂩ���󗓂̏ꍇ
        if (ACTextUtilities.isNullText(price)
                || ACTextUtilities.isNullText(number)) {
            // �����𒆒f����B
            return;
        }
        // �u����price�̒l�v�~�u����number�̒l�v������sum�ɐݒ肷��B
        sum.setText(ACCastUtilities.toString(ACCastUtilities.toInt(price
                .getText())
                * ACCastUtilities.toInt(number.getText())));
        // ���v�����Čv�Z����B
        doCalcTotal();

    }

    /**
     * �u�O�Ń`�F�b�N�ύX�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doCheckTax(ACTextField price, ACTextField number,
            ACTextField sum, ACCheckBox taxTarget, ACCheckBox useTax,
            ACTextField tax, boolean mustCalcTax) throws Exception {
        // �O�Ń`�F�b�N��؂�ւ���B
        if (taxTarget.isSelected()) {
            // ����taxTarget�Ƀ`�F�b�N���t���Ă���ꍇ
            // ����useTax��L���ɂ���B
            useTax.setEnabled(true);
            if (getInnerTaxH1904Mode() || useTax.isSelected()) {
                // innerTaxH1904Mode��true������useTax�̃`�F�b�N���t���Ă���ꍇ
                // ����tax��L���ɂ���B
                tax.setEnabled(true);
            } else {
                // innerTaxH1904Mode��false������useTax�̃`�F�b�N���t���Ă��Ȃ��ꍇ
                // ����tax�𖳌��ɂ���B
                tax.setEnabled(false);
            }
        } else {
            // ����taxTarget�Ƀ`�F�b�N���t���Ă��Ȃ��ꍇ
            // ����tax�𖳌��ɂ���B
            tax.setEnabled(false);
            // ����useTax�𖳌��ɂ���B
            useTax.setEnabled(false);
        }

        if (getInnerTaxH1904Mode() && mustCalcTax) {
            // innerTaxH1904Mode��true������calcTax��true�̏ꍇ
            // ����œ��̍Čv�Z���s���B
            getByPatientSumCache().remove(sum);
        }

        // �ی��O���S�̋��z���Čv�Z����B
        doCalcSum(price, number, sum, taxTarget, useTax, tax, false);

    }

    /**
     * �u�ی��O���S�̋��z�Čv�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doCalcSum(ACTextField price, ACTextField number,
            ACTextField sum, ACCheckBox taxTarget, ACCheckBox useTax,
            ACTextField tax, boolean mustCalcSum) throws Exception {
        // �ی��O���S�̋��z���Čv�Z����B
        // ����price��number�̂����ꂩ���󗓂̏ꍇ
        if (ACTextUtilities.isNullText(price)
                || ACTextUtilities.isNullText(number)) {
            // �����𒆒f����B
            return;
        }
        if (mustCalcSum) {
            // �u����mustCalcSum�v��true�̏ꍇ
            // �u����price�̒l�v�~�u����number�̒l�v������sum�ɐݒ肷��B
            sum.setText(ACCastUtilities.toString(ACCastUtilities.toInt(price
                    .getText())
                    * ACCastUtilities.toInt(number.getText())));
        }
        // �ی��O���S�̐ŋ����Čv�Z����B
        doCalcSum(sum, taxTarget, useTax, tax);

    }

    /**
     * �u�ی��O���S�̐ōČv�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doCalcSum(ACTextField sum, ACCheckBox taxTarget,
            ACCheckBox useTax, ACTextField tax) throws Exception {
        // �ی��O���S�̐ŋ����Čv�Z����B
        if (taxTarget.isSelected()
                && (getInnerTaxH1904Mode() || useTax.isSelected())) {
            // ����taxTarget�Ƀ`�F�b�N���t���Ă���A����innerTaxH1904Mode��true������useTax�Ƀ`�F�b�N���t���Ă���ꍇ
            String val = sum.getText();
            if (!val.equals(getByPatientSumCache().get(sum))) {
                // byPatientSumCache�̃L�[��sum���܂܂�Ȃ����A�L�[�ɑΉ�����l�����݂�sum�̒l�ƈقȂ�ꍇ
                // byPatientSumCache��sum���L�[�A�l��sum�̒l�Ƃ��Đݒ肷��B
                getByPatientSumCache().put(sum, val);
                if (ACTextUtilities.isNullText(val)) {
                    // ����sum���󗓂̏ꍇ
                    // ����tax�ɋ󗓂�ݒ肷��B
                    tax.setText("");
                } else {
                    // ����sum���󗓂ł͂Ȃ��ꍇ
                    if (getInnerTaxH1904Mode() && !useTax.isSelected()) {
                        // innerTaxH1904Mode��true������useTax�Ƀ`�F�b�N���t���Ă��Ȃ��ꍇ
                        // ���łƂ��ď���ł��Z�o����B
                        // ��
                        // �u����sum�̒l�v�|�u����sum�̒l�v��(100.0�{�u����ŗ�(tax)�̒l�v�j�~100.0�������_�ȉ��؎̂Ăň���tax�ɐݒ肷��B
                        int sumVal = ACCastUtilities.toInt(val, 0);
                        tax
                                .setText(ACCastUtilities.toString((int) Math
                                        .floor(sumVal
                                                - sumVal
                                                / (100d + ACCastUtilities
                                                        .toDouble(getTax()
                                                                .getText(), 0))
                                                * 100d)));

                    } else {
                        // innerTaxH1904Mode��false�܂��͈���useTax�Ƀ`�F�b�N���t���Ă���ꍇ
                        // �O�łƂ��ď���ł��Z�o����B
                        // ���u����sum�̒l�v�~�u����ŗ�(tax)�̒l�v�������_�ȉ��؎̂Ăň���tax�ɐݒ肷��B
                        tax.setText(ACCastUtilities.toString((int) Math
                                .ceil(ACCastUtilities.toInt(val, 0)
                                        * ACCastUtilities.toDouble(getTax()
                                                .getText(), 0)) / 100));
                    }
                }
            }
        }
        // ���v�����Čv�Z����B
        doCalcTotal();

    }

    /**
     * �u���v���̍Čv�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doCalcTotal() throws Exception {
        // ���v�����Čv�Z����B
        // ��ʓW�J�p�̃��R�[�hinfo���`�E��������B
        VRMap info = new VRHashMap();
        VRMap data = new VRHashMap();
        getItemContents().setSource(data);
        getItemContents().applySource();
        filterBindPath(data);
        // �ی��K�p���S�̋��z(byInsurerSum�`)�̍��v�z�ɗ��p�ҕ��S����(byPatientRateValue)���悶�A
        // �����_�ȉ����l�̌ܓ��������ʂ��A���R�[�hinfo�̃L�[�uBILL_NO_TAX_BY_INSURER�v�Őݒ肷��B
        long noTaxByInsurer = 0;
        for (int i = 1; i <= ROWS_OF_ITEM; i++) {
            noTaxByInsurer += ACCastUtilities.toInt(VRBindPathParser.get(
                    "BY_INSURER_SUM" + i, data), 0);
        }
        noTaxByInsurer = Math.round(noTaxByInsurer / 100.0
                * getByPatientRateValue()) * 10;
        VRBindPathParser.set("BILL_NO_TAX_BY_INSURER", info, new Long(
                noTaxByInsurer));
        // �ی��O���S�̋��z(byPatientSum�`)�̍��v�z�����R�[�hinfo�̃L�[�uBILL_NO_TAX_BY_PATIENT�v�Őݒ肷��B
        long noTaxByPatient = 0;
        for (int i = 1; i <= ROWS_OF_ITEM; i++) {
            noTaxByPatient += ACCastUtilities.toInt(VRBindPathParser.get(
                    "BY_PATIENT_SUM" + i, data), 0);
        }
        VRBindPathParser.set("BILL_NO_TAX_BY_PATIENT", info, new Long(
                noTaxByPatient));

        // �ی��O���S�̏���œ�(byPatientTax�`)�̍��v�z�����R�[�hinfo�̃L�[�uBILL_IN_TAX_BY_PATIENT�v�Őݒ肷��B
        int inTaxByPatient = 0;
        for (int i = 1; i <= ROWS_OF_ITEM; i++) {
            inTaxByPatient += ACCastUtilities.toInt(VRBindPathParser.get(
                    "BY_PATIENT_TAX" + i, data), 0);
        }
        VRBindPathParser.set("BILL_IN_TAX_BY_PATIENT", info, ACCastUtilities
                .toInteger(inTaxByPatient));
        // ��L3���̍��v�z�����R�[�hinfo�̃L�[�uBILL_FULL_TOTAL�v�Őݒ肷��B
        VRBindPathParser.set("BILL_FULL_TOTAL", info, new Long(noTaxByInsurer
                + noTaxByPatient + inTaxByPatient
                             - ACCastUtilities.toInt(VRBindPathParser.get(
                        "BY_PATIENT_TOTAL_INNER_TAX", data), 0)
        
        ));
        
        if(getInnerTaxH1904Mode()){
            //����19�N4������(��{����)�Ή��ł̏ꍇ
            // ���׍��v�ɂ͏���ł��܂񂾒l���󎚂��ׂ��Ƃ̎d�l����A
            // �ی��O���S�̋��z(byPatientSum�`)�̍��v�z�ł��郌�R�[�hinfo�̃L�[�uBILL_NO_TAX_BY_PATIENT�v�̒l�ɁA
            // �̎��z���v����ی��̖��׍��v�z���������l���Đݒ肷��B
            VRBindPathParser.set("BILL_NO_TAX_BY_PATIENT", info, new Long(
                    noTaxByPatient
                            + inTaxByPatient
                            - ACCastUtilities.toInt(VRBindPathParser.get(
                                    "BY_PATIENT_TOTAL_INNER_TAX", data), 0)));
        }

        // ���v�̈�(totalContents)�Ƀ��R�[�hinfo�����蓖�āE�W�J����B
        getTotalContents().setSource(info);
        getTotalContents().bindSource();
    }

    /**
     * �u�ōďW�v�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doCalcTax() throws Exception {
        // �ی��O���S�����ڂ̐ŕ��̍Čv�Z�ƁA���v���̍Čv�Z���s���B
        getByPatientSumCache().clear();
        ACTextField[] sums = getByPatientSums();
        ACCheckBox[] taxTargets = getByPatientTaxTargets();
        ACCheckBox[] useTaxs = getByPatientUseTaxs();
        ACTextField[] taxs = getByPatientTaxs();
        int end = sums.length;
        for (int i = 0; i < end; i++) {
            doCalcSum(sums[i], taxTargets[i], useTaxs[i], taxs[i]);
        }
    }

    /**
     * �u�f�[�^�̃t�B���^�����O�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param data VRMap
     * @throws Exception ������O
     */
    public void filterBindPath(VRMap data) throws Exception {
        // �f�[�^���̃o�C���h�p�X���t�B���^�����O����B

      // ���ł̍��v��\���ϐ�totalInnerTax���`��0�ŏ���������B
      long totalInnerTax = 0;

        for (int i = 1; i <= ROWS_OF_ITEM; i++) {
            // �ی����S���̍��ږ��̒l���󗓂Ȃ�΁u���ږ��v�u�P���v�u���ʁv�u���z�v�̃o�C���h�p�X���폜����B
            if (ACTextUtilities.isNullText(VRBindPathParser.get(
                    "BY_INSURER_NAME" + i, data))) {
                data.remove("BY_INSURER_NAME" + i);
                data.remove("BY_INSURER_PRICE" + i);
                data.remove("BY_INSURER_NUMBER" + i);
                data.remove("BY_INSURER_SUM" + i);
            }
            // �ی��O���S���̍��ږ��̒l���󗓂Ȃ�΁u���ږ��v�u�P���v�u���ʁv�u���z�v�u����œ��v�̃o�C���h�p�X���폜����B
            if (ACTextUtilities.isNullText(VRBindPathParser.get(
                    "BY_PATIENT_NAME" + i, data))) {
                data.remove("BY_PATIENT_NAME" + i);
                data.remove("BY_PATIENT_PRICE" + i);
                data.remove("BY_PATIENT_NUMBER" + i);
                data.remove("BY_PATIENT_SUM" + i);
                if (getInnerTaxH1904Mode()) {
                    // innerTaxH1904Mode �� true �̏ꍇ
                    // �u�O�Łv�̃o�C���h�p�X���폜����B
                    data.remove("BY_PATIENT_USE_TAX" + i);
                } else {
                    // innerTaxH1904Mode �� false �̏ꍇ
                    // �u�O�Łv�̒l��1�Ƃ��A�`�F�b�N���t����Ԃɂ���B
                    VRBindPathParser.set("BY_PATIENT_USE_TAX" + i, data,
                            ACCastUtilities.toInteger(1));
                }
                data.remove("BY_PATIENT_TAX" + i);
                // �u�ېŁv�̒l��1�Ƃ��A�`�F�b�N���t����Ԃɂ���B
                VRBindPathParser.set("BY_PATIENT_TAX_TARGET" + i, data,
                        ACCastUtilities.toInteger(1));
            } else if (ACCastUtilities.toInt(VRBindPathParser.get(
                    "BY_PATIENT_TAX_TARGET" + i, data), -1) == 0) {
                // �ی��O���S���̍��ږ������͍ς݂ł��A�u�ېŁv�̒l��0(�`�F�b�N�Ȃ�)�̏ꍇ�́u����œ��v�̃o�C���h�p�X���폜����B
                data.remove("BY_PATIENT_TAX" + i);
            } else if (ACCastUtilities.toInt(VRBindPathParser.get(
                    "BY_PATIENT_USE_TAX" + i, data), -1) == 0) {
                // �ی��O���S���̍��ږ������͍ς݂ł��A�u�Łv�̒l��0(�`�F�b�N�Ȃ�)�̏ꍇ

                // replace-begin 2007/03/10 Tozo Tanaka
                // // �u����œ��v�̃o�C���h�p�X���폜����B
                // data.remove("BY_PATIENT_TAX" + i);

                if (getInnerTaxH1904Mode()) {
                    // innerTaxH1904Mode �� true �̏ꍇ

                    // �u���z�v�~�u����ŗ�(tax)�̒l�v�������_�ȉ��؎̂Ăē��ł̍��v(totalInnerTax)�ɉ��Z����B
                    totalInnerTax += ACCastUtilities.toInt(VRBindPathParser
                            .get("BY_PATIENT_TAX" + i, data), 0);
                } else {
                    // innerTaxH1904Mode �� false �̏ꍇ
                    // �u����œ��v�̃o�C���h�p�X���폜����B
                    data.remove("BY_PATIENT_TAX" + i);

                }
                // replace-end 2007/03/10 Tozo Tanaka
            }
        }
      // �����udata�v�ɃL�[�uBY_PATIENT_TOTAL_INNER_TAX�v�œ��ł̍��v(totalInnerTax)��ݒ肷��B
      data.put("BY_PATIENT_TOTAL_INNER_TAX", new Long(totalInnerTax));
    }

    /**
     * �u��^���̒ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param data VRMap
     * @throws Exception ������O
     */
    public void insertFixedForm(VRMap data) throws Exception {

        // �ی����S���E�ی��O���S���̍��ږ��Ƃ��āA��^���ɓo�^����Ă��Ȃ����̂�����Β�^���ɒǉ�����B
        // SQL�����p�̃��R�[�hsqlParam���`�E��������B
        VRMap sqlParam = new VRHashMap();
        // �ǉ���^���p�̃Z�b�gforms���`�E��������B
        Set forms = new TreeSet();
        // �g�����U�N�V�������J�n����B
        getDBManager().beginTransaction();
        try {
            // ���R�[�hsqlParam�ɃL�[�uFIXED_FORM_ID�v�A�l�u1�v��ݒ肷��B
            VRBindPathParser.set("FIXED_FORM_ID", sqlParam, ACCastUtilities
                    .toInteger(1));
            // ��^���e�[�u������A�ی����S���p�̒�^�����擾����B
            VRList list = getDBManager().executeQuery(
                    getSQL_SELECT_FIXED_FORM(sqlParam));
            // ����data����A�ی����S���̍��ږ��ɂ�����L�[��S�������A�ȉ��̏����ɍ��v������̂��Z�b�gforms�ɒǉ�����B
            for (int i = 1; i <= ROWS_OF_ITEM; i++) {
                String val = ACCastUtilities.toString(VRBindPathParser.get(
                        "BY_INSURER_NAME" + i, data));
                if (!ACTextUtilities.isNullText(val)) {
                    // �E�擾������^���e�[�u���ɂ͑��݂��Ȃ����ږ��ł��邱�ƁB
                    if (ACBindUtilities.getMatchIndexFromValue(list, "CONTENT",
                            val) < 0) {
                        // �E����ǉ����̒��ŏd�����Ȃ����̂ł��邱�ƁB(�Z�b�gforms�ɒǉ��ς݂łȂ�����)
                        if (!forms.contains(val)) {
                            forms.add(val);
                        }
                    }
                }
            }

            // �Z�b�gforms��S�������A�ȉ��̏������s�Ȃ��B
            Iterator it = forms.iterator();
            while (it.hasNext()) {
                // sqlParam�̃L�[�uCONTENT�v�̒l�Ƃ��āA���������l��ǉ�����B
                VRBindPathParser.set("CONTENT", sqlParam, it.next());
                // ��^���ւ̒ǉ�SQL�𔭍s����B
                getDBManager()
                        .executeUpdate(getSQL_INSERT_FIXED_FORM(sqlParam));
            }
            // �Z�b�gforms���N���A����B
            forms.clear();
            // ���R�[�hsqlParam�ɃL�[�uFIXED_FORM_ID�v�A�l�u2�v��ݒ肷��B
            VRBindPathParser.set("FIXED_FORM_ID", sqlParam, ACCastUtilities
                    .toInteger(2));
            // ��^���e�[�u������A�ی��O���S���p�̒�^�����擾����B
            list = getDBManager().executeQuery(
                    getSQL_SELECT_FIXED_FORM(sqlParam));
            // ����data����A�ی��O���S���̍��ږ��ɂ�����L�[��S�������A�ȉ��̏����ɍ��v������̂����R�[�hforms�̃L�[�Ƃ��Ēǉ�����B
            for (int i = 1; i <= ROWS_OF_ITEM; i++) {
                String val = ACCastUtilities.toString(VRBindPathParser.get(
                        "BY_PATIENT_NAME" + i, data));
                if (!ACTextUtilities.isNullText(val)) {
                    // �E�擾������^���e�[�u���ɂ͑��݂��Ȃ����ږ��ł��邱�ƁB
                    if (ACBindUtilities.getMatchIndexFromValue(list, "CONTENT",
                            val) < 0) {
                        // �E����ǉ����̒��ŏd�����Ȃ����̂ł��邱�ƁB(�Z�b�gforms�ɒǉ��ς݂łȂ�����)
                        if (!forms.contains(val)) {
                            forms.add(val);
                        }
                    }
                }
            }
            // �Z�b�gforms��S�������A�ȉ��̏������s�Ȃ��B
            it = forms.iterator();
            while (it.hasNext()) {
                // sqlParam�̃L�[�uCONTENT�v�̒l�Ƃ��āA���������l��ǉ�����B
                VRBindPathParser.set("CONTENT", sqlParam, it.next());
                // ��^���ւ̒ǉ�SQL�𔭍s����B
                getDBManager()
                        .executeUpdate(getSQL_INSERT_FIXED_FORM(sqlParam));
            }
            // �g�����U�N�V�������R�~�b�g����B
            getDBManager().commitTransaction();
        } catch (SQLException ex) {
            getDBManager().rollbackTransaction();
            throw ex;
        }

    }

    /**
     * �u�ی��敪�̉�́v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public String createInsureType(VRMap insureInfo) throws Exception {
        // ��Õی���񂩂�ی��ҋ敪����͂��ĕԂ��B
        StringBuffer sb = new StringBuffer();

        // ����ی��̐��x���̂�����
        String mainInsure;
        String insurerID = ACCastUtilities.toString(VRBindPathParser.get(
                "MEDICAL_LAW_NO", insureInfo))
                + ACCastUtilities.toString(VRBindPathParser.get(
                        "MEDICAL_INSURER_ID", insureInfo));
        switch (insurerID.length()) {
        case 4:
            // �ی��Ҕԍ���4���̏ꍇ�́u���ǁv��A������B
            mainInsure = "����";
            break;
        case 6:
            // �ی��Ҕԍ���6���̏ꍇ�́u���ہv��A������B
            mainInsure = "����";
            break;
        case 8:
            // �ی��Ҕԍ���8���̏ꍇ�́A�ی�(����)�Z�k���x���t�H�[�}�b�g�̕ϊ����ʂ�A������B
            // replace-begin 2006-10-25 Tozo TANAKA
            // mainInsure =
            // QkanMedicalInsureTypeFormat.getInstance().format(ACCastUtilities.toInteger(insurerID.substring(0,2),0));
            mainInsure = QkanMedicalInsureTypeFormat.getInstance().format(
                    insurerID);
            // replace-end 2006-10-25 Tozo TANAKA
            break;
        default:
            // ������̌����ɂ��Y�����Ȃ��ꍇ�͕ی����(INSURE_TYPE)�̕ϊ����ʂ�A������B
            mainInsure = QkanInsureTypeFormat.getInstance().format(
                    VRBindPathParser.get("INSURE_TYPE", insureInfo));
            break;
        }
        sb.append(mainInsure);

        Set insureSet = new HashSet();
        insureSet.add(mainInsure);

        // ���V�l�敪������
        if (ACCastUtilities.toInt(VRBindPathParser.get("OLD_FLAG", insureInfo),
                0) == 1) {
            // �ی����Ƃ��ĘV�l���I������Ă����ꍇ
            if (!"�V�l".equals(mainInsure)) {
                // ��ی��Ƃ��ĘV�l���w�肳��Ă��Ȃ��ꍇ
                // �u �V�l�v��A������B
                if (sb.length() != 0) {
                    sb.append("�@");
                }
                sb.append("�V�l");
                insureSet.add("�V�l");
            }
            switch (ACCastUtilities.toInt(VRBindPathParser.get("OLD_RATE_FLAG",
                    insureInfo), 0)) {
            case 1:
                // �ی����Ƃ��č���9���I������Ă����ꍇ
                // �u�ꊄ�v��A������B
                sb.append("�ꊄ");
                break;
            case 2:
                // �ی����Ƃ��č���8���I������Ă����ꍇ
                // �u�񊄁v��A������B
                sb.append("��");
                break;
            case 3:
                // �ی����Ƃ��č���7���I������Ă����ꍇ
                // �u�O���v��A������B
                sb.append("�O��");
                break;
            }
        }

        // ������x���̂�����
        // SQL�����p�̃��R�[�hsqlParam���`�E��������B
        VRMap sqlParam = new VRHashMap();

        // ���R�[�hsqlPram�Ɉȉ��̒l��ݒ肷��B
        // �E�L�[�FPATIENT_ID�A�l�FpatientID
        VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities
                .toInteger(getPatientID()));
        // �E�L�[�FBILL_SPAN_START�A�l�FbillStart
        VRBindPathParser.set("BILL_SPAN_START", sqlParam, getBillStart());
        // �E�L�[�FBILL_SPAN_END�A�l�FbillEnd
        VRBindPathParser.set("BILL_SPAN_END", sqlParam, getBillEnd());
        // ���R�[�hsqlParam�������ɐ������Ԃ̌���擾SQL���𔭍s����B
        VRList kohis = getDBManager().executeQuery(
                getSQL_SELECT_BILL_KOHI(sqlParam));

        // �擾��������ꗗ��S�������A�ȉ��̌����������s�Ȃ��B
        boolean blank = sb.length() == 0;
        Iterator it = kohis.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            // ����̖@�ʔԍ�(KOHI_LAW_NO)��ی�(����)�Z�k���x���t�H�[�}�b�g�ŕϊ�����B
            // replace-begin 2006-10-25 Tozo TANAKA
            // String kohiName =
            // QkanMedicalInsureTypeFormat.getInstance().format(
            // ACCastUtilities.toInteger(VRBindPathParser.get(
            // "KOHI_LAW_NO", row),0));
            String kohiName = QkanMedicalInsureTypeFormat.getInstance().format(
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "KOHI_LAW_NO", row))
                            + ACCastUtilities.toString(VRBindPathParser.get(
                                    "INSURER_ID", row)));
            // replace-end 2006-10-25 Tozo TANAKA
            if ((!ACTextUtilities.isNullText(kohiName))
                    && (!insureSet.contains(kohiName))) {
                // �ϊ����ʂ��󕶎��łȂ��V�o�̌���̏ꍇ
                if (blank) {
                    blank = false;
                } else {
                    // �u �v��A������B
                    sb.append("�@");
                }
                // �ϊ���������̒Z�k���x����A������B
                sb.append(kohiName);
                // add-begin 2006-10-25 Tozo TANAKA
                insureSet.add(kohiName);
                // add-end 2006-10-25 Tozo TANAKA
            }
        }

        // �������ʂ�Ԃ��B
        return sb.toString();
    }

    /**
     * �u���ږ��z����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return ACComboBox[]
     */
    public ACComboBox[] getByInsurerNamesAndPatientNames() throws Exception {
        return new ACComboBox[] { getByInsurerName1(), getByInsurerName2(),
                getByInsurerName3(), getByInsurerName4(), getByInsurerName5(),
                getByInsurerName6(), getByInsurerName7(), getByInsurerName8(),
                getByInsurerName9(), getByInsurerName10(),
                getByInsurerName11(), getByInsurerName12(),
                getByInsurerName13(), getByInsurerName14(),
                getByInsurerName15(), getByInsurerName16(),
                getByInsurerName17(), getByInsurerName18(),
                getByInsurerName19(), getByInsurerName20(),
                getByPatientName1(), getByPatientName2(), getByPatientName3(),
                getByPatientName4(), getByPatientName5(), getByPatientName6(),
                getByPatientName7(), getByPatientName8(), getByPatientName9(),
                getByPatientName10(), getByPatientName11(),
                getByPatientName12(), getByPatientName13(),
                getByPatientName14(), getByPatientName15(),
                getByPatientName16(), getByPatientName17(),
                getByPatientName18(), getByPatientName19(),
                getByPatientName20(), };
    }

    /**
     * �u���p�ҕ��S�̒P���z����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return ACTextField[]
     */
    public ACTextField[] getByPatientPrices() throws Exception {
        return new ACTextField[] { getByPatientPrice1(), getByPatientPrice2(),
                getByPatientPrice3(), getByPatientPrice4(),
                getByPatientPrice5(), getByPatientPrice6(),
                getByPatientPrice7(), getByPatientPrice8(),
                getByPatientPrice9(), getByPatientPrice10(),
                getByPatientPrice11(), getByPatientPrice12(),
                getByPatientPrice13(), getByPatientPrice14(),
                getByPatientPrice15(), getByPatientPrice16(),
                getByPatientPrice17(), getByPatientPrice18(),
                getByPatientPrice19(), getByPatientPrice20(), };
    }

    /**
     * �u���p�ҕ��S�̌��z����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return ACTextField[]
     */
    public ACTextField[] getByPatientNumbers() throws Exception {
        return new ACTextField[] { getByPatientNumber1(),
                getByPatientNumber2(), getByPatientNumber3(),
                getByPatientNumber4(), getByPatientNumber5(),
                getByPatientNumber6(), getByPatientNumber7(),
                getByPatientNumber8(), getByPatientNumber9(),
                getByPatientNumber10(), getByPatientNumber11(),
                getByPatientNumber12(), getByPatientNumber13(),
                getByPatientNumber14(), getByPatientNumber15(),
                getByPatientNumber16(), getByPatientNumber17(),
                getByPatientNumber18(), getByPatientNumber19(),
                getByPatientNumber20(), };
    }

    /**
     * �u���p�ҕ��S�̋��z�z����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return ACTextField[]
     */
    public ACTextField[] getByPatientSums() throws Exception {
        return new ACTextField[] { getByPatientSum1(), getByPatientSum2(),
                getByPatientSum3(), getByPatientSum4(), getByPatientSum5(),
                getByPatientSum6(), getByPatientSum7(), getByPatientSum8(),
                getByPatientSum9(), getByPatientSum10(), getByPatientSum11(),
                getByPatientSum12(), getByPatientSum13(), getByPatientSum14(),
                getByPatientSum15(), getByPatientSum16(), getByPatientSum17(),
                getByPatientSum18(), getByPatientSum19(), getByPatientSum20(), };
    }

    /**
     * �u���p�ҕ��S�̐Ŕz����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return ACIntegerCheckBox[]
     */
    public ACIntegerCheckBox[] getByPatientUseTaxs() throws Exception {
        return new ACIntegerCheckBox[] { getByPatientUseTax1(),
                getByPatientUseTax2(), getByPatientUseTax3(),
                getByPatientUseTax4(), getByPatientUseTax5(),
                getByPatientUseTax6(), getByPatientUseTax7(),
                getByPatientUseTax8(), getByPatientUseTax9(),
                getByPatientUseTax10(), getByPatientUseTax11(),
                getByPatientUseTax12(), getByPatientUseTax13(),
                getByPatientUseTax14(), getByPatientUseTax15(),
                getByPatientUseTax16(), getByPatientUseTax17(),
                getByPatientUseTax18(), getByPatientUseTax19(),
                getByPatientUseTax20(), };
    }

    /**
     * �u���p�ҕ��S�̏���œ��z����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return ACTextField[]
     */
    public ACTextField[] getByPatientTaxs() throws Exception {
        return new ACTextField[] { getByPatientTax1(), getByPatientTax2(),
                getByPatientTax3(), getByPatientTax4(), getByPatientTax5(),
                getByPatientTax6(), getByPatientTax7(), getByPatientTax8(),
                getByPatientTax9(), getByPatientTax10(), getByPatientTax11(),
                getByPatientTax12(), getByPatientTax13(), getByPatientTax14(),
                getByPatientTax15(), getByPatientTax16(), getByPatientTax17(),
                getByPatientTax18(), getByPatientTax19(), getByPatientTax20(), };
    }

    /**
     * �u���p�ҕ��S�̉ېőΏ۔z����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return ACIntegerCheckBox[]
     */
    public ACIntegerCheckBox[] getByPatientTaxTargets() throws Exception {
        return new ACIntegerCheckBox[] { getByPatientTaxTarget1(),
                getByPatientTaxTarget2(), getByPatientTaxTarget3(),
                getByPatientTaxTarget4(), getByPatientTaxTarget5(),
                getByPatientTaxTarget6(), getByPatientTaxTarget7(),
                getByPatientTaxTarget8(), getByPatientTaxTarget9(),
                getByPatientTaxTarget10(), getByPatientTaxTarget11(),
                getByPatientTaxTarget12(), getByPatientTaxTarget13(),
                getByPatientTaxTarget14(), getByPatientTaxTarget15(),
                getByPatientTaxTarget16(), getByPatientTaxTarget17(),
                getByPatientTaxTarget18(), getByPatientTaxTarget19(),
                getByPatientTaxTarget20(), };
    }

    /**
     * �u����19�N4������`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkInnerTaxModeH1804() throws Exception {
        // ������19�N4������(��{����)�Ή������ׂ������肷��
        if (
                ACDateUtilities.compareOnDay(getBillStart(), ACDateUtilities
                .createDate(2007, 4, 1)) >= 0) {
            // �������Ԃ̊J�n������19�N4��1���ȍ~�̏ꍇ
            // innerTaxH1904Mode �� true ��������B
            setInnerTaxH1904Mode(true);
            // ��ʏ�Ԃ���{���őΉ�����(VALID_INNER_TAX_H1804)�ɂ���B
            setState_VALID_INNER_TAX_H1804();
            // �ېőΏۊz(totalInTaxTitle)�̃e�L�X�g���u(��������Ŋz)�v�ɂ���B
            getTotalInTaxTitle().setText("(��������Ŋz)");
            // �ی��O���S���O�Ń^�C�g��(byPatientUseTaxTitle)�̃e�L�X�g���u�O�Łv�ɂ���B
            getByPatientUseTaxTitle().setText("�O��");

            // �Ő���(useTaxInfomation)�̃e�L�X�g���ȉ��Ƃ���B
            // �u�ېŁv��Ƀ`�F�b�N������ƁA�ېőΏۂ̍��ڂƂ��ē���/�O�ł̑I�����\�ɂȂ�܂��B
            // �u�O�Łv��Ƀ`�F�b�N������ƁA�O�łƂ��ď���œ���ɑS�z���������͂���܂��B
            // �`�F�b�N���O���ƁA���łƂȂ�܂��B
            getUseTaxInfomation()
                    .setText(
                            "�u�ېŁv��Ƀ`�F�b�N������ƁA�ېőΏۂ̍��ڂƂ��ē���/�O�ł̑I����"
                                    + ACConstants.LINE_SEPARATOR
                                    + "�@�\�ɂȂ�܂��B�`�F�b�N���O���ƁA��ېłƂ��Ĉ����܂��B"
                                    + ACConstants.LINE_SEPARATOR
                                    +"�u�O�Łv��Ƀ`�F�b�N������ƁA����œ���ɊO�Ŋz���������͂���܂��B"
                                    + ACConstants.LINE_SEPARATOR
                                    + "�@�`�F�b�N���͂����ƁA����œ���ɓ��Ŋz���������͂���܂��B");

            // �ی��O���S���O�ł̊e�`�F�b�N�̃e�L�X�g�𔼊p��( )�ɂ���B
            // �ی��O���S�̊O�Ń`�F�b�N�����ׂĊO���B
            // �ی��O���S�̉ېŃ`�F�b�N�����ׂĂ���B
            ACIntegerCheckBox[] useTaxs = getByPatientUseTaxs();
            ACIntegerCheckBox[] taxTargets = getByPatientTaxTargets();
            int end = useTaxs.length;
            for (int i = 0; i < end; i++) {
                useTaxs[i].setText(" ");
                useTaxs[i].setSelected(false);
                taxTargets[i].setSelected(true);
            }

        } else {
            // �������Ԃ̊J�n������19�N4��1�����O�̏ꍇ
            // innerTaxH1904Mode �� false ��������B
            setInnerTaxH1904Mode(false);
            // ��ʏ�Ԃ���{���őΉ��Ȃ�(INVALID_INNER_TAX_H1804)�ɂ���B
            setState_INVALID_INNER_TAX_H1804();

            // �ی��O���S�̉ېŃ`�F�b�N�����ׂĂ���B
            ACIntegerCheckBox[] taxTargets = getByPatientTaxTargets();
            int end = taxTargets.length;
            for (int i = 0; i < end; i++) {
                taxTargets[i].setSelected(true);
            }
        }
    }

}
