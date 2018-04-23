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
 * �쐬��: 2011/11/16  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����̑����e�ڍ� (QS001_90101_201204)
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
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.bind.event.VRBindEvent;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[�����̑����e�ڍ�(QS001_90101_201204)
 */
@SuppressWarnings("serial")
public class QS001_90101_201804 extends QS001_90101_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_90101_201804() {
    }

    // �R���|�[�l���g�C�x���g

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        ACFrame.debugStart(new ACAffairInfo(QS001_90201_201804.class.getName()));
    }

    // �����֐�

    /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void initialize() throws Exception {
        // ����ʓW�J���̏����ݒ�
        getDailyLifeActivitList().setBindPathes(
                new String[] { "9010102", "9010103", "9010104", "9010105",
                        "9010106", "9010107", "9010108", "9010109", "9010110",
                        "9010111" });
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
        // ���g(this)�̃��f���\�[�X�Ƃ���comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�

    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     * @return VRMap
     */
    public VRMap getValidData() throws Exception {
        if (ACTextUtilities.isNullText(getDailyLifeActivitySelect().getText())) {
            // ���e�ڍ׃e�L�X�g(dailyLifeActivitySelect)�̓��͓��e����̏ꍇ
            // ���e�ڍׂɕs��������|�̃��b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if ((!getDailyLifeActivityBeginTime().isValidDate())
                || (!getDailyLifeActivityTimeContenaEndTime().isValidDate())) {
            // �J�n�����R���{(dailyLifeActivityBeginTime)�ƏI�������R���{(dailyLifeActivityTimeContenaEndTime)�̂����ꂩ���s���̏ꍇ
            // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
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
        if (ACTextUtilities.isNullText(getDailyLifeActivityBeginTime()
                .getText())) {
            // �J�n�����R���{(dailyLifeActivityBeginTime)���󗓂̏ꍇ
            // �ԋp�p���R�[�h����A�J�n�����R���{(dailyLifeActivityBeginTime)��bindPath����������B
            data.remove(getDailyLifeActivityBeginTime().getBindPath());
        }
        if (ACTextUtilities.isNullText(getDailyLifeActivityTimeContenaEndTime()
                .getText())) {
            // �I�������R���{(dailyLifeActivityTimeContenaEndTime)���󗓂̏ꍇ
            // �ԋp�p���R�[�h����A�I�������R���{(dailyLifeActivityTimeContenaEndTime)��bindPath����������B
            data.remove(getDailyLifeActivityTimeContenaEndTime().getBindPath());
        }
        // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
        return data;
    }

    /**
     * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     * @return boolean
     */
    public boolean isUseProvider() throws Exception {
        // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
        // false��Ԃ��B
        return false;
    }

    /**
     * �J�n�������͗p�̃R���{��Ԃ��܂��B
     * 
     * @return �J�n�������͗p�̃R���{
     */
    public ACComboBox getBeginTimeCombo() {
        // ���J�n�������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return getDailyLifeActivityBeginTime();
    }

    /**
     * �I���������͗p�̃R���{��Ԃ��܂��B
     * 
     * @return �I���������͗p�̃R���{
     */
    public ACComboBox getEndTimeCombo() {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getDailyLifeActivityTimeContenaEndTime();
    }

    /**
     * �u�ǉ��{�^���̃N���b�N�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void dailyLifeActivitInsertButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ���I����e�����X�g�ɒǉ�����B
        if (ACTextUtilities.isNullText(getDailyLifeActivitySelect().getText())) {
            // �I����e���󗓂̏ꍇ
            // �󗓃G���[���b�Z�[�W��\�����ď������I������B
            QkanMessageList.getInstance().QS001_ERROR_OF_BLANK_TEXT();
            return;
        }
        // �I����e�����X�g�ɒǉ�����B
        getDailyLifeActivitList().addItem(
                getDailyLifeActivitySelect().getText());
        // �ǉ��{�^���̗L����Ԃ��`�F�b�N����B
        checkAddCondition();

        // �I����e�e�L�X�g�Ƀt�H�[�J�X���ڂ��B
        getDailyLifeActivitySelect().requestFocus();

    }

    /**
     * �u�ҏW�{�^���̃N���b�N�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void dailyLifeActivitFindButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ���I����e�Ń��X�g�̑I�����ڂ��㏑������B
        if (ACTextUtilities.isNullText(getDailyLifeActivitySelect().getText())) {
            // �I����e���󗓂̏ꍇ
            // �󗓃G���[���b�Z�[�W��\�����ď������I������B
            QkanMessageList.getInstance().QS001_ERROR_OF_BLANK_TEXT();
            return;
        }

        // �I����e�Ń��X�g�̑I�����ڂ��㏑������B
        if (getDailyLifeActivitList().isSelected()) {
            VRBindSource src = getDailyLifeActivitList().getModelAtBindSource();
            if (src != null) {
                src.setData(getDailyLifeActivitList().getSelectedIndex(),
                        getDailyLifeActivitySelect().getText());
            }
        }
        // �I����e�e�L�X�g�Ƀt�H�[�J�X���ڂ��B
        getDailyLifeActivitySelect().requestFocus();

    }

    /**
     * �u�폜�{�^���̃N���b�N�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void dailyLifeActivitDeleteButtonActionPerformed(ActionEvent e)
            throws Exception {
        // �����X�g���̑I�����ڂ��폜����B
        // ���X�g���̑I�����ڂ��폜����B
        if (getDailyLifeActivitList().isSelected()) {
            int idx = getDailyLifeActivitList().getSelectedIndex();
            getDailyLifeActivitList().removeItemAt(idx);
            getDailyLifeActivitList().setSelectedIndexOnAfterDelete(idx);
            setState_VALID_ADD();
        }
    }

    /**
     * �u���X�g�̑I���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void dailyLifeActivitListSelectionChanged(ListSelectionEvent e)
            throws Exception {
        if (e.getValueIsAdjusting()) {
            return;
        }
        // �����X�g�̑I���󋵂ɉ����ă{�^���̗L��������ύX����B
        if (getDailyLifeActivitList().isSelected()) {
            // ���X�g��I�����Ă���ꍇ
            getDailyLifeActivitySelect().setText(
                    ACCastUtilities.toString(getDailyLifeActivitList()
                            .getSelectedValue()));
            // �ҏW�L����Ԃɂ���B
            setState_VALID_EDIT();
        } else {
            // ���X�g��I�����Ă��Ȃ��ꍇ
            // �ҏW������Ԃɂ���B
            setState_INVALID_EDIT();
        }
    }

    /**
     * �u���X�g�ւ̃o�C���h�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void dailyLifeActivitListBindSource(VRBindEvent e)
            throws Exception {
        // ���ǉ��{�^���̗L����Ԃ��`�F�b�N����B
        // �ǉ��{�^���̗L����Ԃ��`�F�b�N����B
        checkAddCondition();
    }

    /**
     * �u�ǉ��{�^���̗L����ԃ`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void checkAddCondition() throws Exception {
        // ���ǉ��{�^���̗L����Ԃ��`�F�b�N����B
        if (getDailyLifeActivitList().getItemCount() < 10) {
            // ���X�g��10���ȏ㍀�ڂ����݂���ꍇ
            // �ǉ�������Ԃɂ���B
            setState_VALID_ADD();
        } else {
            // ���X�g�̍��ڂ�10���ȏ�ł͂Ȃ��ꍇ
            // �ǉ��L����Ԃɂ���B
            setState_INVALID_ADD();
        }
    }

}
