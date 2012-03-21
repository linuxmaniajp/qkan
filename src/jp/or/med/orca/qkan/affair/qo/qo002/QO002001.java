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
 * �쐬��: 2009/07/09  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �ی��ҊǗ� (O)
 * �v���Z�X �ی��ғo�^ (002)
 * �v���O���� �ی��҈ꗗ (QO002001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo002;

import java.awt.event.ActionEvent;

import javax.swing.event.DocumentEvent;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * �ی��҈ꗗ(QO002001)
 */
public class QO002001 extends QO002001Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QO002001() {
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
        // selectInsurerData��Null��ݒ肷��B
        setSelectInsurerData(null);
        // ��ʂ�j�����܂��B
        dispose();

    }

    /**
     * �u�e�L�X�g�ύX�ɔ��������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void insurerTextTextChanged(DocumentEvent e) throws Exception {
        if(!getInsurerText().hasFocus()){return;}
        
        // �����A���^�C����������
        String findInsurer = getInsurerText().getText();
        if ("".equals(findInsurer)) {
            VRList empty = new VRArrayList();
            // �@�e�[�u���Ɍ��ʂ𔽉f����B
            getInsurerTableModel().setAdaptee(empty);
            return;
        }
        // �����������s���B
        findData();
        
    }

    /**
     * �u���f�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void applyActionPerformed(ActionEvent e) throws Exception {
        // �I�����ꂽ�f�[�^�𔽉f����B
        // ���ݑI�𒆂̃��R�[�h��selectInsurerData�Ɋi�[����B
        VRMap selectMap = new VRHashMap();
        if(getDetailsTable().isSelected()) {
            selectMap = (VRMap)getDetailsTable().getSelectedModelRowValue();
            // �ی��Ҕԍ��̌����`�F�b�N
            String insurerNo = ACCastUtilities.toString(selectMap
                    .getData("INSURER_NO"),"");
            // �{���ɂU���̒l�ł���ꍇ�̂ݍ̗p����B
            if(insurerNo.length() == 6) {
                setSelectInsurerData(selectMap);
            }
        }
        // ��ʂ�j������B
        dispose();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QO002001.class.getName(), param));
    }

    // �����֐�

    /**
     * �u�����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap showModal(ACDBManager dbm) throws Exception {
        // ����ʓW�J���̏����ݒ�
        // �E�B���h�E�^�C�g���̐ݒ�
        // �Ɩ����}�X�^���A�f�[�^���擾����B
        setAffairTitle("QO002001");
        setInsurerDBManager(dbm);
        // �e�[�u�����f�����쐬���A�ی��҃e�[�u��(detailsTable)�ɐݒ肷��B
        // �e�[�u�����f�����`����B
        ACTableModelAdapter model = new ACTableModelAdapter();
        model.setColumns(new String[] { "INSURER_NO", "INSURER_NO",
                "INSURER_NAME"

        });
        setInsurerTableModel(model);
        getDetailsTable().setModel(getInsurerTableModel());
        // �f�[�^��ݒ肷��B
        getInsurerTableModel().setAdaptee(getMasterInsurerList());
        // �P�s�ڂ�I��
        getDetailsTable().setSelectedSortedFirstRow();
        // �����͔�I��
        setState_INVALID_APPLY();
        // pack();
        setVisible(true);

        // selectInsurerData��ԋp����B
        return getSelectInsurerData();
    }

    /**
     * �u�f�[�^�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void findData() throws Exception {
        // ���f�[�^��������
        // insurerText�����͕���������o���B
        String findInsurer = getInsurerText().getText();
        // ���R�[�hsqlParam��KEY�FFIND_INSURER_NAME VALUE�F��L�Ŏ��o�����l��ݒ肷��B
        VRMap sqlParam = new VRHashMap();
        sqlParam.setData("FIND_INSURER_NAME", findInsurer);
        // �@�ی��҃}�X�^�S�����p��SQL�����擾����B
        // �@SQL���𔭍s����B
        VRList result = getInsurerDBManager().executeQuery(
                getSQL_GET_FIND_M_INSURER_INFO(sqlParam));
        // �@�e�[�u���Ɍ��ʂ𔽉f����B
        getInsurerTableModel().setAdaptee(result);
        // �P�s�ڂ�I��
        getDetailsTable().setSelectedSortedFirstRow();
        
    }

    /**
     * �e�[�u���I���Ɋւ��鏈�����s���܂��B
     */
    protected void detailsTableSelectionChanged(ListSelectionEvent e) throws Exception {
        // �e�[�u�����I������Ă��邩�`�F�b�N����B
        if(getDetailsTable().isSelected()) {
            // �I������Ă���ꍇ
            setState_VALID_APPLY();
        } else {
            // �I������Ă��Ȃ��ꍇ
            setState_INVALID_APPLY();
        }
    }

}
