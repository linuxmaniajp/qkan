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
 * �J����: ���}�@�M�u
 * �쐬��: 2006/01/10  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����̑����e�ڍ� (QS001029)
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
import jp.nichicom.vr.bind.event.VRBindEventListener;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[����ȓ��퐶����̊���(QS001027)
 */
public class QS001027 extends QS001027Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001027() {
    }

    // �R���|�[�l���g�C�x���g

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        ACFrame.debugStart(new ACAffairInfo(QS001027.class.getName()));
    }

    // �����֐�

    /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // ����ʓW�J���̏����ݒ�
        getEtcContentDetailIList().setBindPathes(
                new String[] { "9020102", "9020103", "9020104", "9020105",
                        "9020106", "9020107", "9020108", "9020109", "9020110",
                        "9020111" });

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
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return VRMap
     */
    public VRMap getValidData() throws Exception {
        if (ACTextUtilities.isNullText(getEtcContentDetailInput().getText())) {
            // ���e�ڍ׃e�L�X�g(etcContentDetailInput)�̓��͓��e����̏ꍇ
            // ���e�ڍׂɕs��������|�̃��b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if ((!getEtcContentDetailBeginTime().isValidDate())
                || (!getEtcContentDetailEndTime().isValidDate())) {
            // �J�n�����R���{(etcContentDetailBeginTime)�ƏI�������R���{(etcContentDetailEndTime)�̂����ꂩ���s���̏ꍇ
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
        if (ACTextUtilities
                .isNullText(getEtcContentDetailBeginTime().getText())) {
            // �J�n�����R���{(etcContentDetailBeginTime)���󗓂̏ꍇ
            // �ԋp�p���R�[�h����A�J�n�����R���{(etcContentDetailBeginTime)��bindPath����������B

            data.remove(getEtcContentDetailBeginTime().getBindPath());
        }
        if (ACTextUtilities.isNullText(getEtcContentDetailEndTime().getText())) {
            // �I�������R���{(etcContentDetailEndTime)���󗓂̏ꍇ
            // �ԋp�p���R�[�h����A�I�������R���{(etcContentDetailEndTime)��bindPath����������B
            data.remove(getEtcContentDetailEndTime().getBindPath());
        }
        // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
        return data;
    }

    /**
     * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
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
        return getEtcContentDetailBeginTime();
    }

    /**
     * �I���������͗p�̃R���{��Ԃ��܂��B
     * 
     * @return �I���������͗p�̃R���{
     */
    public ACComboBox getEndTimeCombo() {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getEtcContentDetailEndTime();
    }

    /**
     * �u�ǉ��{�^���̃N���b�N�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void etcContentInsertButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ���I����e�����X�g�ɒǉ�����B
        if (ACTextUtilities.isNullText(getEtcContentDetailInput().getText())) {
            // �I����e���󗓂̏ꍇ
            // �󗓃G���[���b�Z�[�W��\�����ď������I������B
            QkanMessageList.getInstance().QS001_ERROR_OF_BLANK_TEXT();
            return;
        }
        // �I����e�����X�g�ɒǉ�����B
        getEtcContentDetailIList()
                .addItem(getEtcContentDetailInput().getText());
        // �ǉ��{�^���̗L����Ԃ��`�F�b�N����B
        checkAddCondition();
        
        //�I����e�e�L�X�g�Ƀt�H�[�J�X���ڂ��B
        getEtcContentDetailInput().requestFocus();
    }

    /**
     * �u�ҏW�{�^���̃N���b�N�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void etcContentFindButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ���I����e�Ń��X�g�̑I�����ڂ��㏑������B
        if (ACTextUtilities.isNullText(getEtcContentDetailInput().getText())) {
            // �I����e���󗓂̏ꍇ
            // �󗓃G���[���b�Z�[�W��\�����ď������I������B
            QkanMessageList.getInstance().QS001_ERROR_OF_BLANK_TEXT();
            return;
        }

        // �I����e�Ń��X�g�̑I�����ڂ��㏑������B
        if (getEtcContentDetailIList().isSelected()) {
            VRBindSource src = getEtcContentDetailIList()
                    .getModelAtBindSource();
            if (src != null) {
                src.setData(getEtcContentDetailIList().getSelectedIndex(),
                        getEtcContentDetailInput().getText());
            }
        }
        //�I����e�e�L�X�g�Ƀt�H�[�J�X���ڂ��B
        getEtcContentDetailInput().requestFocus();
    }

    /**
     * �u�폜�{�^���̃N���b�N�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void etcContentDeleteButtonActionPerformed(ActionEvent e)
            throws Exception {
        // �����X�g���̑I�����ڂ��폜����B
        // ���X�g���̑I�����ڂ��폜����B
        if (getEtcContentDetailIList().isSelected()) {
            int idx=getEtcContentDetailIList().getSelectedIndex();
            getEtcContentDetailIList().removeItemAt(idx);
            getEtcContentDetailIList().setSelectedIndexOnAfterDelete(idx);
            setState_VALID_ADD();
        }
    }

    /**
     * �u���X�g�̑I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void etcContentDetailIListSelectionChanged(ListSelectionEvent e)
            throws Exception {
        if (e.getValueIsAdjusting()) {
            return;
        }
        // �����X�g�̑I���󋵂ɉ����ă{�^���̗L��������ύX����B
        if (getEtcContentDetailIList().isSelected()) {
            // ���X�g��I�����Ă���ꍇ
            getEtcContentDetailInput().setText(ACCastUtilities.toString(getEtcContentDetailIList().getSelectedValue()));
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
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void etcContentDetailIListBindSource(VRBindEvent e)
            throws Exception {
        // ���ǉ��{�^���̗L����Ԃ��`�F�b�N����B
        // �ǉ��{�^���̗L����Ԃ��`�F�b�N����B
        checkAddCondition();
    }

    /**
     * �u�ǉ��{�^���̗L����ԃ`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkAddCondition() throws Exception {
        // ���ǉ��{�^���̗L����Ԃ��`�F�b�N����B
        if (getEtcContentDetailIList().getItemCount() < 10) {
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
