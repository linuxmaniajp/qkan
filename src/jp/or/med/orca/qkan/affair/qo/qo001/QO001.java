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
 * �J����: ����@��F
 * �쐬��: 2006/01/22  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X �ی��ҊǗ� (001)
 * �v���O���� �ی��҈ꗗ (QO001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo001;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qo.qo002.QO002;

/**
 * �ی��҈ꗗ(QO001)
 */
public class QO001 extends QO001Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QO001() {
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
        // ��ʂ̏����\�����s������
        // �擾�����f�[�^�̃E�B���h�E�^�C�g���iWINDOW_TITLE�j���E�B���h�E�ɐݒ肷��B
        // �擾�����f�[�^�̋Ɩ��^�C�g���iAFFAIR_TITLE�j���Ɩ��{�^���o�[�ɐݒ肷��B
        VRMap params = affair.getParameters();
        setAffairTitle("QO001", getButtons());

        setINSURER_INFO_PASSIVE_CHECK_KEY(new ACPassiveKey("INSURER",
                new String[] { "INSURER_ID" }, new boolean[] { true },
                "LAST_TIME", "LAST_TIME"));

        // �e�[�u�����f�������L�̉�ʂ̃e�[�u���ɐݒ肷��B
        // �E�ی��ҏ��e�[�u���iinsurerInfoTable) �e�[�u�����f���FinsurerTableModel
        ACTableModelAdapter insurerInfoTableModel = new ACTableModelAdapter();

        // �e�[�u�����f�����`
        insurerInfoTableModel
                .setColumns(new String[] { "INSURER_ID", "INSURER_NAME",
                        "INSURER_TYPE",
                        "INSURER_ZIP_FIRST+'-'+INSURER_ZIP_SECOND",
                        "INSURER_ADDRESS",
                        "INSURER_TEL_FIRST+'-'+INSURER_TEL_SECOND+'-'+INSURER_TEL_THIRD" });

        // ��`�����e�[�u�����f�����i�[
        setInsurerInfoTableModel(insurerInfoTableModel);

        // �e�[�u�����f�����e�[�u���ɃZ�b�g
        getInsurerInfoTable().setModel(getInsurerInfoTableModel());

        // DB��背�R�[�h���擾���A��ʂɓW�J����B
        doFind();

        // ����params��null�̏ꍇ�������I������
        if (params == null) {
            return;
        }

        // �n��p�����[�^�[�̒��ɑO��ʂ̕ی���ID�����邩�`�F�b�N����
        if (VRBindPathParser.has("INSURER_ID", params)) {

            // �ڍ׉�ʂőI������Ă����ی��҂ƍ��v���郌�R�[�h��index���擾����B
            int index = ACCommon.getInstance().getMatchIndexFromValue(
                    getInsurerInfoList(), "INSURER_ID",
                    String.valueOf(params.getData("INSURER_ID")));

            // ��v����
            if (index != -1) {
                // �ڍׂ���̕ی��҂�I����Ԃɂ���
                getInsurerInfoTable().setSelectedModelRow(index);

            } else {
                // ���R�[�h��1�s�ڂ�I����Ԃɂ���B
                getInsurerInfoTable().setSelectedSortedFirstRow();

            }
            // 2�d�g�p��h�����ߏ����l�ɖ߂�
//             setInsurerId("");

        } else {
            // ���R�[�h��1�s�ڂ�I����Ԃɂ���B
            getInsurerInfoTable().setSelectedSortedFirstRow();

        }
        //�I�𗘗p�҂ɃX�N���[������
        getInsurerInfoTable().scrollSelectedToVisible();
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
     * �u���������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void findActionPerformed(ActionEvent e) throws Exception {
        // �������s������
        // �������s���B
        doFindData();

    }

    /**
     * �u�ی��ғo�^��ʂɑJ�ځi�X�V�j�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void detailActionPerformed(ActionEvent e) throws Exception {
        // �ی��ҏ��o�^��ʂɍX�V���[�h�őJ�ڂ��鏈��
        // ��ʂ̢�ی��҈ꗗ����I������Ă��邩�`�F�b�N����B
        if (getInsurerInfoTable().isSelected()) {
            // �I������Ă����ꍇ
            // �I��ی��҂h�c��insurerId�Ɋi�[����B
            VRMap rec = (VRMap) getInsurerInfoTable()
                    .getSelectedModelRowValue();

            // VPMap�Fparam�𐶐������L�̃p�����[�^�[���i�[����B
            VRMap param = new VRHashMap();
            // KEY�FPROCESS_MODE VALUE�F���ʒ萔�iPROCESS_MODE_UPDATE(3)�j
            // KEY�FINSURER_ID VALUE�FinsurerId
            param.setData("INSURER_ID", rec.getData("INSURER_ID"));
            param.setData("PROCESS_MODE", new Integer(
                    QkanConstants.PROCESS_MODE_UPDATE));

            // ����ʑJ�ڂ̂��߂̃p�����[�^�[NCAffairInfo affair���`����B
            ACAffairInfo affair = null;

            affair = new ACAffairInfo(QO002.class.getName(), param);

            // �QU002�i�ی��ғo�^�j��ɑJ�ڂ���B
            ACFrame.getInstance().next(affair);

        }

    }

    /**
     * �u�ی��ғo�^��ʂɑJ�ځi�V�K�j�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // �ی��ҏ��o�^��ʂɐV�K�o�^���[�h�őJ�ڂ��鏈��
        // VRMap�Fparam�𐶐������L�̃p�����[�^�[���i�[����B
        VRMap param = new VRHashMap();
        // KEY�FPROCESS_MODE VALUE�F���ʒ萔�iPROCESS_MODE_INSERT(4)�j
        param.setData("PROCESS_MODE", new Integer(
                QkanConstants.PROCESS_MODE_INSERT));

        // ����ʑJ�ڂ̂��߂̃p�����[�^�[NCAffairInfo affair���`����B
        ACAffairInfo affair = null;
        // ���L�̃p�����[�^�[��affair�𐶐�����B
        // className�FQO002.class.getName() parameters:param
        affair = new ACAffairInfo(QO002.class.getName(), param);

        // �QU002�i�ی��ғo�^�j��ɑJ�ڂ���B
        // NEXT(affair);
        ACFrame.getInstance().next(affair);

    }

    /**
     * �u�폜�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void deleteActionPerformed(ActionEvent e) throws Exception {

        if (getInsurerInfoTable().isSelected()) {
            // ��ʂ̢�ی��҈ꗗ��̍s���I������Ă��邩�`�F�b�N����B
            // �I������Ă���ꍇ
            // �I���s�̕ی���ID��insurerId�Ɋi�[����B
            VRMap tableData = (VRMap) getInsurerInfoTable()
                    .getSelectedModelRowValue();
            setInsurerId((String.valueOf(tableData.getData("INSURER_ID"))));

            // �I��ی��҂����ɓo�^����Ă���ی��҂��ǂ����`�F�b�N����B
            if (!checkInsurerId()) {
                // ���ɓo�^����Ă���ی��҂������ꍇ
                // �G���[���b�Z�[�W��\������B �����b�Z�[�WID = ERROR_OF_DELETE_INSURER
                QkanMessageList.getInstance().ERROR_OF_DELETE_USED("���p�҂̏��");
                // �����𔲂���B�i�����𒆒f����j
                return;

            } else {
                // �o�^����Ă��Ȃ��ی��҂������ꍇ
                // �폜�m�F���b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_DELETE
                int msgID = QkanMessageList.getInstance().WARNING_OF_DELETE(
                        "�I�𒆂̕ی��ҏ��");

                // ��͂��������
                if (msgID == ACMessageBox.RESULT_YES) {

                    // ���݂̑I���s��ޔ�����
                    int sel = getInsurerInfoTable().getSelectedModelRow();

                    // �폜�������s���B
                    if (!doDelete()) {
                        // ���炩�̃G���[�����������ꍇ�����𒆒f����
                        return;
                    }

                    // �폜��̗��z�ƂȂ�s�ԍ���ݒ肷��
                    getInsurerInfoTable()
                            .setSelectedSortedRowOnAfterDelete(sel);

                }

                // ��������������
                // �����𔲂���B�i�������s��Ȃ��j
                return;
            }
        }
    }

    /**
     * �u��ʐ���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void insurerInfoTableSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ����ʂ̐���
        if (!getInsurerInfoTable().isSelected()) {
            // �I������Ă��Ȃ��ꍇ
            // �Ɩ��{�^���̏�Ԃ�ύX����B
            setState_UNSELECTED();
            // �E���ID�FUNSELECTED
        } else {
            // �I������Ă���ꍇ
            // �Ɩ��{�^���̏�Ԃ�ύX����B
            setState_SELECTED();
            // �E���ID�FSELECTED
        }
    }

    /**
     * �u��ʑJ�ڏ����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void insurerInfoTableMouseClicked(MouseEvent e) throws Exception {
        // ���I�����ꂽ�ی��҂̏��ŁA����ʂɑJ��
        // ��ʂ́u�ی��҈ꗗ�v�̍s���I������Ă��邩�ǂ����`�F�b�N����B
        VRMap param = new VRHashMap();

        if (getInsurerInfoTable().isSelected()) {
            // �I������Ă���ꍇ
            // �I������Ă��闘�p�҂́u�ی��Ҕԍ��v���擾����B
            param = (VRMap) getInsurerInfoTable().getSelectedModelRowValue();
            // [ID:0000520][Masahiko Higuchi] 2009/07 add begin �ی��҃}�X�^���ی��Ҕԍ��̃G���[�`�F�b�N�@�\��ǉ�
            param.setData("PROCESS_MODE", new Integer(
                    QkanConstants.PROCESS_MODE_UPDATE));
            // [ID:0000520][Masahiko Higuchi] 2009/07 add end
        } else {
            // �I������Ă��Ȃ��ꍇ
            // �����𒆒f����B
            // [ID:0000520][Masahiko Higuchi] 2009/07 add begin �ی��҃}�X�^���ی��Ҕԍ��̃G���[�`�F�b�N�@�\��ǉ�
            return;
            // [ID:0000520][Masahiko Higuchi] 2009/07 add end

        }

        // ���J�ڏ���
        ACAffairInfo affair = null;
        affair = new ACAffairInfo(QO002.class.getName(), param);
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
        ACFrame.debugStart(new ACAffairInfo(QO001.class.getName(), param));
    }

    // �����֐�

    /**
     * �u���R�[�h���擾����ʂɐݒ肷��B�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doFind() throws Exception {
        // ��ʓW�J�p�̏����擾���鏈��
        // �ی��ҏ��TABLE�ɑ��݂���A�S�ی��ҏ����擾����B
        doFindInsurerInfo();

        if (!getInsurerInfoList().isEmpty()) {
            // �擾�����S�ی��ҏ��iinsurerInfoList�j��insurerTableModel�ɐݒ肷��B
            getInsurerInfoTableModel().setAdaptee(getInsurerInfoList());

            // insurerInfoTable�̃��R�[�h��1���ȏ�̏ꍇ

        } else {
            // ��񂪎擾�ł��Ȃ������ꍇ
            getInsurerInfoList().clearData();
            getInsurerInfoTableModel().setAdaptee(getInsurerInfoList());

            // ��ʏ�Ԃ�ύX����
            setState_UNSELECTED();
        }

        // �X�i�b�v�V���b�g���B�e����B
        getSnapshot().snapshot();

    }

    /**
     * �u�S�ی��ҏ��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doFindInsurerInfo() throws Exception {
        // �S�ی��ҏ����擾���鏈��
        // �S�ی��ҏ����擾���邽�߂�SQL�����擾����B
        // �擾����SQL�������s����B
        VRList allInsurerInfoList = getDBManager().executeQuery(
                getSQL_GET_INSURER_INFO(null));

        // ���R�[�h���擾�ł����ꍇ
        if (!allInsurerInfoList.isEmpty()) {
            // �擾�������R�[�h�z���insurerInfoList�Ɋi�[����B
            setInsurerInfoList(allInsurerInfoList);

            // �ی��ҏ��TABLE�p�b�V�u�`�F�b�N�p�Ƀf�[�^��o�^����B
            getPassiveChecker().reservedPassive(
                    getINSURER_INFO_PASSIVE_CHECK_KEY(), getInsurerInfoList());

        } else {

            allInsurerInfoList.clearData();
            setInsurerInfoList(allInsurerInfoList);

        }

    }

    /**
     * �u�I��ی��ҍ폜�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean doDelete() throws Exception {
        // �ی��ҏ����폜���鏈��
        try {
            // �g�����U�N�V�������J�n����B
            getDBManager().beginTransaction();
            // �p�b�V�u�^�X�N���N���A����B
            getPassiveChecker().clearPassiveTask();
            // �p�b�V�u�^�X�N��ǉ�����B�i�ی��ҏ��폜�p�j
            getPassiveChecker().addPassiveUpdateTask(
                    getINSURER_INFO_PASSIVE_CHECK_KEY());

            // �p�b�V�u�`�F�b�N�����s����B
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                //�e�[�u�����b�N�����̂��߃��[���o�b�N
                getDBManager().rollbackTransaction();
                // �p�b�V�u�G���[������ꍇ
                // �G���[���b�Z�[�W��\������B
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // �����𔲂���B�i�����𒆒f����j
                return false;
            }

            // �p�b�V�u�G���[���Ȃ��ꍇ
            // �ی��ҏ��폜�p��SQL�����擾����B
            // SQL���擾�̂���VRMap�Fparam���쐬���A���L�̃p�����[�^�[��ݒ肷��B
            VRMap param = new VRHashMap();
            // KEY�FINSURER_ID VALUE�FinsurerId
            param.setData("INSURER_ID", getInsurerId());

            // �ی��ҏ��폜�p��SQL�����擾����
            // �擾����SQL�������s����B
            getDBManager().executeUpdate(getSQL_UPDATE_TO_DELETE_INSURER(param));
            // ��������SQL���̎��s����1���G���[���������Ȃ������ꍇ
            // �R�~�b�g����B
            getDBManager().commitTransaction();
            // �ی��Ҋ֘A�����擾���p�b�V�u�`�F�b�N�p�ɑޔ�����B
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
     * �u�����������s���B�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doFindData() throws Exception {
        // �ی��Ҍ����������s���B
        // ��ی��Җ��̃e�L�X�g�iinsurerName�j��̒l���擾����B
        if (!"".equals(getInsurerName().getText())) {
            //�l���擾�ł����ꍇ
            //SQL���擾�̂���VRMap�Fparam���쐬���A���L��KEY/VALUE�Őݒ肷��B
            VRMap param = new VRHashMap();
            //KEY�FINSURER_NAME_FIND�@VALUE�F�擾�����l
            param.setData("INSURER_NAME_FIND", getInsurerName().getText());

            //SQL�����擾����B
            //SQL�������s����B
            VRList list = getDBManager().executeQuery(
                    getSQL_FIND_INSURER_NAME(param));

            if (list.size() > 0) {
                //���R�[�h��1���ȏ�擾�ł����ꍇ
                //�擾�������R�[�h��insurerInfoList�Ɋi�[����B
                setInsurerInfoList(list);

            } else {
                //���R�[�h��1�����擾�ł��Ȃ������ꍇ
                //��̃��X�g�𐶐�����B
                VRList initList = new VRArrayList();
                setInsurerInfoList(initList);
            }

            //�擾�����������ʁiinsurerInfoList�j��insurerInfoTableModel�ɐݒ肷��B
            getInsurerInfoTableModel().setAdaptee(getInsurerInfoList());

            //���R�[�h��1�s�ڂ�I����Ԃɂ���B
            getInsurerInfoTable().setSelectedSortedFirstRow();
        } else {
            //�l���擾�ł��Ȃ������ꍇ�i�e�L�X�g���󔒂������ꍇ�j
            //�o�^����Ă���ی��҂̈ꗗ��\������B
            doFind();

            //���R�[�h��1�s�ڂ�I����Ԃɂ���B
            getInsurerInfoTable().setSelectedSortedFirstRow();
        }

    }

    /**
     * �u�ی��Ҕԍ����g�p����Ă��邩�`�F�b�N����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public boolean checkInsurerId() throws Exception {
        //���p�ҏ��Ƃ��ĕی��Ҕԍ����g�p����Ă��邩�`�F�b�N���鏈��
        //�����ϐ� sqlParam�𐶐������L��KEY/VALUE��ݒ肷��B
        VRMap sqlParam = new VRHashMap();
        //KEY�FINSURER_ID�@VALUE�FinsurerId
        sqlParam.setData("INSURER_ID", getInsurerId());

        //�ی��Ҕԍ��擾�̂��߂�SQL�����擾����B    
        //�擾����SQL�������s����B
        VRList list = getDBManager().executeQuery(
                getSQL_GET_INSURER_ID(sqlParam));

        if (list.size() > 0) {
            //���R�[�h��1���ȏ�擾�ł����ꍇ
            //�폜�s�\�Ƃ��ď�����Ԃ�(false)
            return false;
        } else {
            //���R�[�h���擾�ł��Ȃ������ꍇ
            //�폜�\�Ƃ��ď�����Ԃ�(true)
            return true;
        }
    }

}
