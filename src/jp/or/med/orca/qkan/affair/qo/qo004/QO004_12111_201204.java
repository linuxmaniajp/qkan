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
 * �쐬��: 2006/02/21  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� �Z������������� (QO004109)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo004;

import java.awt.event.FocusEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �Z�������������(QO004_12111_201204)
 */
@SuppressWarnings("serial")
public class QO004_12111_201204 extends QO004_12111_201204Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QO004_12111_201204() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u��ʏ�Ԑݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void facilitiesDivisionSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ��ʏ�Ԑݒ�
        setState();

    }

    /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // ��������
        // �������l�ݒ�
        // �������e�L�X�g�ɏ����l0��������B
        getReduceRate().setText("0");

        // ���W�I�̏����l��I������
        QkanCommon.selectFirstRadioItem(getThis());

        // �H��E���Z��̎擾�ƕ\��
        VRMap param = new VRHashMap();
        VRBindPathParser.set("SYSTEM_DATE", param, QkanSystemInformation
                .getInstance().getSystemDate());
        String strSql = getSQL_GET_RESIDENCE_FOOD(param);
        VRList residenceFood = getDBManager().executeQuery(strSql);

        if (residenceFood != null) {
            for (int i = 0; i < residenceFood.size(); i++) {
                VRMap temp = (VRMap) residenceFood.get(i);
                int id = ACCastUtilities.toInt(VRBindPathParser.get(
                        "RESIDENCE_FOOD_COST_ID", temp));
                String cost = ACCastUtilities.toString(VRBindPathParser.get(
                        "RESIDENCE_FOOD_COST", temp));

                switch (id) {
                // �H��
                case 1:
                    getDinnerTotal().setText(cost);
                    break;
                // ���j�b�g��
                case 2:
                    getUnitRoom().setText(cost);
                    break;
                // ���j�b�g����
                case 3:
                    getUnitSemiRoom().setText(cost);
                    break;
                // �]���^��
                case 4:
                    getNormalRoom().setText(cost);
                    break;
                // ������
                case 6:
                    getTasyouRoom().setText(cost);
                    break;
                }

            }
        }

    }

    /**
     * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean isValidInput() throws Exception {
        // �����̓`�F�b�N
        // �G���[���b�Z�[�W�����i�[�p�� errMsg�@���쐬����B
        String errMsg = null;

        // ���L�̃��W�I�O���[�v�ɑ΂��đI���`�F�b�N���s���B���I���������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
        // �󏰌^�Ή�
        // �T�[�r�X�񋟑̐��������Z
        if (getServiceAddProvisionStructuralRadioGroup().getSelectedIndex() > 1) {
            // �T�[�r�X�񋟑̐��������Z�i�󏰌^�j�łȂ��ȊO���I������Ă���ꍇ
            if (getServiceAddProvisionStructuralKusyoRadioGroup().isEnabled()
                    && getServiceAddProvisionStructuralKusyoRadioGroup()
                            .getSelectedIndex() > 1) {
                // �G���[���b�Z�[�W
                if (QkanMessageList.getInstance()
                        .QO004_WARNING_OF_DOUBLE_CHECK(
                                "�T�[�r�X�񋟑̐��������Z�i�P�ƌ^�E���݌^�^�󏰌^�j�̗���") == ACMessageBox.RESULT_CANCEL) {
                    return false;
                }
            }
        }

        // ���L�̃e�L�X�g�t�B�[���h�ɑ΂��ē��̓`�F�b�N���s���B�����͂������ꍇ�� errMsg �Ƀ��b�Z�[�W���i�[����B
        // �EreduceRate�i�������e�L�X�g�j�� errMsg = ������
        if (ACTextUtilities.isNullText(getReduceRate().getText())) {
            errMsg = "������";
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
            getReduceRate().requestFocus();
            return false;
        }

        // �������̒l���`�F�b�N����B
        int reduceRate = ACCastUtilities.toInt(getReduceRate().getText());
        if (reduceRate > 100) {
            // 100�𒴂���l�����͂���Ă����ꍇ
            QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
            // �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�B
            getReduceRate().requestFocus();
            return false;
        }

        return true;

    }

    /**
     * �u�p�l����Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void stateManager(boolean state) throws Exception {
        // ���p�l����Ԑ���
        if (state) {
            // �����Ƃ���true���n���ꂽ�ꍇ
            // ���ID�FSET_PANEL_TRUE
            setState_SET_PANEL_TRUE();

            setState();

        } else {
            // �����Ƃ���false���n���ꂽ�ꍇ
            // ���ID�FSET_PANEL_FALSE
            setState_SET_PANEL_FALSE();
        }
    }

    /**
     * �u�p�l���f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void getDetails(VRMap map) throws Exception {
        // �p�l���f�[�^�擾

        getMainGroup().setSource(map);
        getMainGroup().applySource();

        // ������Ԃ̃R���g���[���̃f�[�^���폜����B
        removeInvalidData(map);

    }

    /**
     * �u�����f�[�^�폜�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param map VRMap
     * @throws Exception ������O
     */
    public void removeInvalidData(VRMap map) throws Exception {
        // �����f�[�^�폜
        QkanCommon.removeDisabledBindPath(getMainGroup(), map);

    }

    /**
     * �u��Ԑ���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    public void setState() throws Exception {

        // ��ʂ̏�Ԃ𐧌䂷��B
        setStateByFacilitiesDivision();

    }

    /**
     * �u�{�݋敪�ɂ���Ԑ���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    public void setStateByFacilitiesDivision() throws Exception {

        // �{�݋敪�̒l���`�F�b�N����B
        if (getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_NORMAL_TANDOKU
                || getFacilitiesDivision().getSelectedIndex() == FACILITY_TYPE_NORMAL_HEISETSU) {
            // �{�݋敪�́u�P�ƌ^�v�A�u���݌^�v���I������Ă���ꍇ
            setState_FACILITY_TYPE_NORMAL();
        } else {
            // �{�݋敪�́u�P�ƌ^�v�A�u���݌^�v�ȊO���I������Ă���ꍇ
            setState_FACILITY_TYPE_UNIT();
        }

        // �󏰌^�Ή�
        switch (getFacilitiesDivision().getSelectedIndex()) {
        case 1: // �P�ƌ^
        case 3: // �P�ƌ^���j�b�g�^
            setState_INVALID_SERVICE_ADD_KUSYO();
            break;
        case 2: // �󏰌^
        case 4: // ���j�b�g�^�󏰌^
            setState_VALID_SERVICE_ADD_KUSYO();
            break;
        }

    }

}
