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
 * �쐬��: 2006/02/07  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� ����E������� (QS001029)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.util.Map;

import jp.nichicom.ac.component.event.ACFollowContainerFormatEventListener;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.component.event.VRFormatEvent;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * ����E�������(QS001029)
 */
@SuppressWarnings("serial")
public class QS001006 extends QS001006Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001006() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u����/�����ύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void serviceIndependenceActionPerformed(ActionEvent e)
            throws Exception {
        // ������/�����̕ύX����
        // �u����(serviceIndependence)�v�̒l���`�F�b�N����B
        if (getServiceIndependence().isSelected()) {
            // �`�F�b�N���t���Ă���ꍇ
            // �u�����z�v�Ɂu�P�ʐ��v�̒l��ݒ肷��B
            getServiceAdjustUnit().setText(getServiceUnit().getText());
            //�u������P�ʁv��0��ݒ肷��B
            getServiceResultUnit().setText("0");
            setState_EXPENCE();
            // �u�����z�v�𐳏�F�ɕς���B
            getAdjustUnitBackgroundChanger().changeValidContainer();
        } else {
            // �`�F�b�N���O��Ă���ꍇ
            // �������Ȃ�(�l�̕ύX�͍s��Ȃ�)�B
            setState_ADJUST();
        }
    }

    /**
     * �u�������ʔ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return int
     */
    public int getAdjustResult() {
        int adj = ACCastUtilities.toInt(getServiceAdjustUnit().getText(), -1);
        if (adj >= 0) {
            // �u�����z�v����͂��Ă���ꍇ
            int unit = ACCastUtilities.toInt(getServiceUnit().getText(), 0);
            // �u�P�ʐ��v�Ɓu�����z�v�̒l���`�F�b�N����B
            if (unit < adj) {
                // (�P�ʐ�) < (�����z)�̏ꍇ
                // 1��Ԃ��B
                return 1;
            }
            if (unit > adj) {
                // (�P�ʐ�) > (�����z)�̏ꍇ
                // -1��Ԃ��B
                return -1;
            }
            // 0��Ԃ��B
            return 0;
        }
        // �����z����͂��Ă��Ȃ��ꍇ
        // -2��Ԃ��B
        return -2;
    }

    /**
     * �u�����z�ύX���`�F�b�N�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void serviceAdjustUnitFocusLost(FocusEvent e) throws Exception {
        // �������z�ύX���̓��̓`�F�b�N�A�y�я�Ԑݒ�
        // �����̓`�F�b�N

        // �u�P�ʐ��v�Ɓu�����z�v�̒l���`�F�b�N����B
        switch (getAdjustResult()) {
        case 1:
        // (�P�ʐ�) < (�����z)�̏ꍇ
        case -2:
            // (�����z)�������͂̏ꍇ
            // �����z���G���[�F�ɕς���B
            getAdjustUnitBackgroundChanger().changeInvalidContainer();
            // �����𔲂���B
            return;
        case -1:
            // (�P�ʐ�) > (�����z)�̏ꍇ
            // �u����v�̃`�F�b�N���O���B
            getServiceIndependence().setSelected(false);
            // �������p������B
            break;
        case 0:
            // (�P�ʐ�) = (�����z)�̏ꍇ
            // �u����v�̃`�F�b�N��t����B
            getServiceIndependence().setSelected(true);
            // �������p������B
            break;
        }
        getServiceResultUnit().setText(
                ACCastUtilities.toString(ACCastUtilities.toInt(getServiceUnit()
                        .getText(), 0)
                        - ACCastUtilities.toInt(getServiceAdjustUnit()
                                .getText(), -1)));
        // �����z�𐳏�F�ɕς���B
        getAdjustUnitBackgroundChanger().changeValidContainer();

        // ����/�����ύX���̏�Ԑݒ���s���B
        setExpenceState();
    }

    /**
     * �u���菈���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void submitActionPerformed(ActionEvent e) throws Exception {
        // ���������菈��

        switch (getAdjustResult()) {
        // �u�P�ʐ��v�Ɓu�����z�v�̒l���`�F�b�N����B
        case 1:
            // (�P�ʐ�) < (�����z)�̏ꍇ
            getAdjustUnitBackgroundChanger().changeInvalidContainer();
            // �����ϐ�unitValue�𐶐����A�P�ʐ���ݒ肷��B
            String unitValue = "�P�ʐ�("
                    + ACCastUtilities.toString(ACCastUtilities.toInt(
                            getServiceUnit().getText(), 0)) + ")";
            // �����ϐ�choseiValue�𐶐����A�����z��ݒ肷��B
            String choseiValue = "���p�ҕ��S�P�ʐ�("
                    + ACCastUtilities.toString(ACCastUtilities.toInt(
                            getServiceAdjustUnit().getText(), -1)) + ")";
            // �G���[���b�Z�[�W��\������BID = ERROR_OF_LESSER_DATE_RELATION
            QkanMessageList.getInstance().ERROR_OF_LESSER_DATE_RELATION("",
                    unitValue, choseiValue);
            // serviceAdjustUnit�Ƀt�H�[�J�X�𓖂Ă�B
            getServiceAdjustUnit().requestFocus();
            // �����𔲂���B
            return;
        case -2:
            // �����͂̏ꍇ
            // �G���[���b�Z�[�W��\������BID = QS001_ERROR_OF_BLANK_ADJUST_UNIT
            QkanMessageList.getInstance().QS001_ERROR_OF_BLANK_ADJUST_UNIT();
            // serviceAdjustUnit�Ƀt�H�[�J�X�𓖂Ă�B
            getServiceAdjustUnit().requestFocus();
            // �����𔲂���B
            return;
        case -1:
            // (�P�ʐ�) > (�����z)�̏ꍇ
            // �u����(adjust)�v�̃`�F�b�N���O���B
            getServiceIndependence().setSelected(false);
            // �������p������B
            break;
        case 0:
            // (�P�ʐ�) = (�����z)�̏ꍇ
            // �u����(adjust)�v�̃`�F�b�N��t����B
            getServiceIndependence().setSelected(true);
            // �������p������B
            break;
        }

        // ���_�C�A���O�Ăяo�����ɁA�u�����z�v�u����t���O�v��Ԃ��A�_�C�A���O�����B
        getContents().setSource(getValues());
        getContents().applySource();
        setApplied(true);
        dispose();
    }

    /**
     * �u�L�����Z���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void closeActionPerformed(ActionEvent e) throws Exception {
        // �������L�����Z������
        // ���_�C�A���O�Ăяo�����ɁA�u�����z�v�u����t���O�v�͕Ԃ����A�_�C�A���O�����B
        dispose();
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001006.class.getName(), param));
    }

    // �����֐�

    /**
     * �u�����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param serviceData VRMap
     * @param serviceMaster VRMap
     * @param provider VRMap
     * @param managementTotal int
     * @throws Exception ������O
     * @return boolean
     */
    public boolean showModal(VRMap serviceData, VRMap serviceMaster,
            VRMap provider, int managementTotal) throws Exception {
        // ����ʓW�J���̏����ݒ�
        setAdjustUnitBackgroundChanger(new ACFollowContainerFormatEventListener());
        getAdjustUnitBackgroundChanger().formatValid(
                new VRFormatEvent(getServiceAdjustUnit(), null, null));

        setValues(serviceData);
        // ���n��l�̐ݒ�
        // �n��p�����[�^�����ɁA���L�̒l��ݒ肷��B
        // ���t
        // �J�n����
        // �I������
        // �T�[�r�X����
        // �P�ʐ�
        // �����z
        getContents().setSource(serviceData);
        getContents().bindSource();
        getServiceUnit().setText(ACCastUtilities.toString(managementTotal));
        getServiceDate().setDate(
                ACCastUtilities.toDate(VRBindPathParser.get("SERVICE_DATE",
                        serviceData)));
        if(ACTextUtilities.isNullText(getServiceAdjustUnit().getText())){
            getServiceAdjustUnit().setText("0");
        }

        // ���l�̌v�Z
        // �u������P�ʐ��v�� (�P�ʐ�) - (�����z) ��ݒ肷��B
        // ����Ԑݒ�
        // ������Ԃ̐ݒ���s���B
        setState_INIT_STATE();

        // ���Ə����� providerNames
        if (provider != null) {
            getProviderNames().setText(
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "PROVIDER_NAME", provider)));
        }
        Object obj;
        // �T�[�r�X���� serviceName
        obj = serviceMaster.get(VRBindPathParser.get(
                "SYSTEM_SERVICE_KIND_DETAIL", serviceData));
        if (obj instanceof Map) {
            getServiceName().setText(
                    ACCastUtilities.toString(((Map) obj).get("SERVICE_ABBREVIATION"),
                            ""));
        }

        int reguration = ACCastUtilities.toInt(serviceData
                .getData("REGULATION_RATE"), 0);
        
        // �u�P�ʐ��v�Ɓu�����z�v�̒l���`�F�b�N����B
        if (managementTotal > reguration) {
            // (�P�ʐ�) > (�����z)�̏ꍇ
            // �u����(adjust)�v�̃`�F�b�N���O���B
            getServiceIndependence().setSelected(false);
            getServiceResultUnit().setText(
                    ACCastUtilities.toString(managementTotal - reguration));
        } else {
            // (�P�ʐ�) = (�����z)�̏ꍇ
            // �u����(adjust)�v�̃`�F�b�N��t����B
            getServiceIndependence().setSelected(true);
            getServiceResultUnit().setText("0");
        }
        setExpenceState();

        // ���E�B���h�E�^�C�g���̐ݒ�
        // �Ɩ���񃌃R�[�h���擾����B
        setAffairTitle("QS001006");
        // �E�B���h�E�^�C�g���ɁA�擾���R�[�h��KEY : WINDOW_TITLE��VALUE��ݒ肷��B

        pack();
        setVisible(true);
        return getApplied();
    }

    /**
     * �u����/�����ύX���̏�Ԑݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void setExpenceState() throws Exception {
        // ������/�����ύX���̏�Ԑݒ�
        // �u�P�ʐ��v�Ɓu�����z�v�̒l���`�F�b�N����B
        if (getAdjustResult() == 0) {
            // �������ꍇ
            // ����p�̏�Ԑݒ���s���B
            setState_EXPENCE();
        } else {
            // �������Ȃ��ꍇ
            // �����p�̏�Ԑݒ���s���B
            setState_ADJUST();
        }
    }
}
