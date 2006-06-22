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
 * �쐬��: 2006/01/12  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[���K��Ō�i��Áj (001)
 * �v���O���� �T�[�r�X�p�^�[���K��Ō�i��Áj (QS001006)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���K��Ō�i��Áj(QS001006)
 */
public class QS001006 extends QS001006Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001006() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u��{�×{��敪�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoIryoBasicChargeDivisionActionPerformed(
            ActionEvent e) throws Exception {
        // ���K��Ō�E���敪�A��a�������񐔖K����Z�A�������ԉ��Z�̏�Ԑݒ�
        // �u��{�×{��敪�v�̒l���`�F�b�N����B
        switch (getHoumonKangoIryoBasicChargeDivision().getSelectedIndex()) {
        case 1:
            // �u��{�×{��I�v�̏ꍇ
            // �u��{�×{��I�v�p�̏�Ԃ�ݒ肷��B
            setState_IRYO_BASIC_CHARGE1_SELECTED();
            break;
        case 2:
            // �u��{�×{��II�v�̏ꍇ
            // �u��{�×{��II�v�p�̏�Ԃ�ݒ肷��B
            setState_IRYO_BASIC_CHARGE2_SELECTED();
            break;
        }
        checkGuidanceState();

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
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // ����ʓW�J���̏����ݒ�
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���J�n����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ���R���{�A�C�e���̐ݒ�
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();
        // ���I�����ڂ̏����ݒ�
        // ��{�×{��敪(houmonKangoIryoBasicChargeDivision)�́u��{�×{��I�v��I������B
        getHoumonKangoIryoBasicChargeDivision().setSelectedIndex(1);
        // �K��Ō�E���敪(houmonKangoIryoClass)�́u���œ��v��I������B
        getHoumonKangoIryoClass().setSelectedIndex(1);
        // ��a�������񐔖K����Z(houmonKangoIryoIntractableDiseaseRadio)�́u�Ȃ��v��I������B
        getHoumonKangoIryoIntractableDiseaseRadio().setSelectedIndex(1);
        // �����w�����Z(houmonKangoIryoGuidanceRadio)�́u�Ȃ��v��I������B
        getHoumonKangoIryoGuidanceRadio().setSelectedIndex(1);
        // 24���ԉ��Z(houmonKangoIryo24HoureRadio)�́u�Ȃ��v��I������B
        getHoumonKangoIryo24HoureRadio().setSelectedIndex(1);
        // �d���҉��Z(houmonKangoIryoSeriousIllnessRadio)�́u�Ȃ��v��I������B
        getHoumonKangoIryoSeriousIllnessRadio().setSelectedIndex(1);
        // ���񋟉��Z(houmonKangoIryoInfoRadio)�́u�Ȃ��v��I������B
        getHoumonKangoIryoInfoRadio().setSelectedIndex(1);
        // �^�[�~�i���P�A���Z(houmonKangoIryoTerminalRadio)�́u�Ȃ��v��I������B
        getHoumonKangoIryoTerminalRadio().setSelectedIndex(1);
        // �ً}�K��Ō���Z(houmonKangoIryoEmergencyVisitNursingRadio)�́u�Ȃ��v��I������B
        getHoumonKangoIryoEmergencyVisitNursingRadio().setSelectedIndex(1);
        //�������ԁE�e�L�X�g(houmonKangoIryoExtensionTimeText)���󗓂ɂ���B
        getHoumonKangoIryoExtensionTimeText().setText("");
    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if ( (!getHoumonKangoIryoBeginTime().isValidDate())
                || (!getHoumonKangoIryoEndTime().isValidDate())) {
            // �J�n�����R���{(houmonKangoIryoBeginTime)�ƏI�������R���{(houmonKangoIryoEndTime)�̂����ꂩ���󗓂��s���̏ꍇ
            // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
            // null��Ԃ��B
            return null;
        }
        if (!getHoumonKangoIryoBasicChargeDivision().isSelected()) {
            // ��{�×{��敪(houmonKangoIryoBasicChargeDivision)�����I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if (getHoumonKangoIryoBasicChargeDivision().getSelectedIndex() == 1) {
            // ��{�×{��敪(houmonKangoIryoBasicChargeDivision)�Ɂu��{�×{��I�v���I������Ă���ꍇ
            if (!getHoumonKangoIryoClass().isSelected()) {
                // �K��Ō�E���敪(houmonKangoIryoClass)�����I���̏ꍇ
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
        if (getHoumonKangoIryoExtensionTimeText().isEnabled()
                && (5 < ACCastUtilities.toInt(
                        getHoumonKangoIryoExtensionTimeText().getText(), 0))) {
            // �������ԁE�e�L�X�g(houmonKangoIryoExtensionTimeText)�̒l��8�ȏ�̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_RANGE_OVER
            QkanMessageList.getInstance().QS001_ERROR_OF_RANGE_OVER("��������","5���Ԃ܂�");
            // null��Ԃ��B
            return null;
        }

        // ���ԋp�p�̃��R�[�h(data)�𐶐�
        VRMap data = new VRHashMap();
        // ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
        getThis().setSource(data);
        // ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
        getThis().applySource();
        // ���ԋp�p���R�[�h����s�v�ȃL�[������
        switch (getHoumonKangoIryoBasicChargeDivision().getSelectedIndex()) {
        case 1:
            // ��{�×{��敪(houmonKangoIryoBasicChargeDivision)�Ɂu��{�×{��I�v���I������Ă���ꍇ
            // �ԋp�p���R�[�h����A�������ԁE�e�L�X�g(houmonKangoIryoExtensionTimeText)��bindPath����������B
            data.remove(getHoumonKangoIryoExtensionTimeText().getBindPath());
            break;
        case 2: {
            // ��{�×{��敪(houmonKangoIryoBasicChargeDivision)�Ɂu��{�×{��II�v�����I���̏ꍇ
            // �ԋp�p���R�[�h����A�K��Ō�E���敪(houmonKangoIryoClass)��bindPath����������B
            // �ԋp�p���R�[�h����A��a�������񐔖K����Z(houmonKangoIryoIntractableDiseaseRadio)��bindPath����������B
            data.remove(getHoumonKangoIryoClass().getBindPath());
            data.remove(getHoumonKangoIryoIntractableDiseaseRadio()
                    .getBindPath());

            String val = getHoumonKangoIryoExtensionTimeText().getText();
            if (ACTextUtilities.isNullText(val) || "0".equals(val)
                    || "00".equals(val)) {
                // �������ԁE�e�L�X�g(houmonKangoIryoExtensionTimeText)�̒l���󗓂�0�̏ꍇ
                // �ԋp�p���R�[�h����A�������ԁE�e�L�X�g(houmonKangoIryoExtensionTimeText)��bindPath����������B
                data
                        .remove(getHoumonKangoIryoExtensionTimeText()
                                .getBindPath());
            }
            break;
        }
        }
        // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
        return data;
    }

    /**
     * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean isUseProvider() throws Exception {
        // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
        // true��Ԃ��B
        return true;
    }

    public ACComboBox getBeginTimeCombo() throws Exception {
        return getHoumonKangoIryoBeginTime();
    }

    public ACComboBox getEndTimeCombo() throws Exception {
        return getHoumonKangoIryoEndTime();
    }

    /**
     * �u�E���敪�ύX�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoIryoClassSelectionChanged(ListSelectionEvent e) throws Exception {
        checkGuidanceState();
    }

    /**
     * �u�����w�����Z�̗L����Ԋm�F�v�Ɋւ��鏈�����s�Ȃ��܂��B
     *
     * @throws Exception ������O
     *
     */
    public void checkGuidanceState() throws Exception {
//        // �������w�����Z�̗L����Ԃ��`�F�b�N����B
//        if (getHoumonKangoIryoBasicChargeDivision1().isSelected()
//                && getHoumonKangoIryoClass2().isSelected()) {
//            // ��{�×{��I�Əy�ł��I������Ă���ꍇ
//            // �����w�����Z�𖳌��Ƃ���B
//            setState_INVALID_GUIDANCE();
//        } else {
//            // ����ȊO
//            // �����w�����Z��L���Ƃ���B
//            setState_VALID_GUIDANCE();
//        }
    }


}
