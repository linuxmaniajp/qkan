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
 * �J����: �A�� ��C
 * �쐬��: 2006/05/02  ���{�R���s���[�^�[������� �A�� ��C �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� ���\�h�Z�������×{���i�F�m�ǎ����^�j (QO004141)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * ���\�h�Z�������×{���i�F�m�ǎ����^�j(QO004141)
 */
@SuppressWarnings("serial")
public class QO004_12613_201204 extends QO004_12613_201204Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QO004_12613_201204() {
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
        // �u�F�m�ǎ����^�v���I�����ꂽ�ꍇ
        int facilityType = getFacilitiesDivision().getSelectedIndex();
        if (facilityType == FACILITY_TYPE_NINCHISHO) {
            setState_FACILITY_TYPE_NORMAL();
            // ���ID�FFACILITY_TYPE_NORMAL
        } else if (facilityType == FACILITY_TYPE_UNIT) {
            // �u���j�b�g�^�v���I�����ꂽ�ꍇ
            setState_FACILITY_TYPE_UNIT();
            // ���ID�FFACILITY_TYPE_UNIT
        } else {
            // �u�o�ߌ^�v���I�����ꂽ�ꍇ
            setState_FACILITY_TYPE_PASSAGE();
        }
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QO004_12613_201204.class.getName(),
                param));
    }

    // �����֐�

    /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // ��������
        // �������l�ݒ�
        // ���W�I�̒l������������
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
                case 5:
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
        return true;
    }

    /**
     * �u�p�l����Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void stateManager(boolean state) throws Exception {
        // ���p�l����Ԑ���
        // ���p�l����Ԑ���
        if (state) {
            // �����Ƃ���true���n���ꂽ�ꍇ
            // ���ID�FSET_PANEL_TRUE
            setState_SET_PANEL_TRUE();

            // �u�F�m�ǎ����^�v���I�����ꂽ�ꍇ
            int facilityType = getFacilitiesDivision().getSelectedIndex();
            if (facilityType == FACILITY_TYPE_NINCHISHO) {
                setState_FACILITY_TYPE_NORMAL();
                // ���ID�FFACILITY_TYPE_NORMAL
            } else if (facilityType == FACILITY_TYPE_UNIT) {
                // �u���j�b�g�^�v���I�����ꂽ�ꍇ
                setState_FACILITY_TYPE_UNIT();
                // ���ID�FFACILITY_TYPE_UNIT
            } else {
                // �u�o�ߌ^�v���I�����ꂽ�ꍇ
                setState_FACILITY_TYPE_PASSAGE();
            }

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
        // ���p�l���f�[�^�擾
        // ���ƃO���[�v�̃\�[�X�Ƃ���VRMap map��ݒ肷��B
        setSource(map);

        // ��ʏ�̃f�[�^���擾����B
        applySource();

        // ������Ԃ̃R���g���[���̃f�[�^���폜����B
        removeInvalidData(map);

        // �f�o�b�O�p�o��
        // System.out.println(map);

    }

    /**
     * �u�����f�[�^�폜�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void removeInvalidData(VRMap map) throws Exception {
        // �������f�[�^�폜
        QkanCommon.removeDisabledBindPath(getMainGroup(), map);
    }

}
