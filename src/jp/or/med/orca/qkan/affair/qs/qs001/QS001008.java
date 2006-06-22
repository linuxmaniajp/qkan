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
 * �v���Z�X �T�[�r�X�p�^�[���ʏ���� (001)
 * �v���O���� �T�[�r�X�p�^�[���ʏ���� (QS001008)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���ʏ����(QS001008)
 */
public class QS001008 extends QS001008Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001008() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�I�����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void tsuusyoKaigoTimeBeginTimeActionPerformed(ActionEvent e)
            throws Exception {
        // ���J�n���ԕύX���A�I�����Ԃ��ύX
        if (getTsuusyoKaigoTimeBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getTsuusyoKaigoTimeBeginTime()
                        .getText()))) {
            // ���ԑޔ�p�̕ϐ�kangoTime�ɁA���ԋ敪����擾�������Ԃ�ݒ肷��B
            int kangoTime = getKaigoTime();

            // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
            getTsuusyoKaigoTimeEndTime().setDate(
                    ACDateUtilities.addMinute(
                                    getTsuusyoKaigoTimeBeginTime().getDate(),
                                    kangoTime));
        }
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001008.class.getName(), param));
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
        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F40�i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1150104 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1150104", QkanCommon.getArrayFromMasterCode(40,
                "1150104"));
        // ���R���{�A�C�e���̐ݒ�
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();
        // ���I�����ڂ̏����ݒ�
//      �@�\�P���w�����Z(tsuusyoKaigoAdditionFunctionTrainingRadio)�́u�Ȃ��v��I������B
        getTsuusyoKaigoAdditionFunctionTrainingRadio().setSelectedIndex(1);

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            Object obj;
            // �{�݋敪
            obj = VRBindPathParser.get("1150101", provider);
            if (obj != null) {
                getTsuusyoKaigoTimeContenaFacilityDivision().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // �l�����Z
            obj = VRBindPathParser.get("1150106", provider);
            if (obj != null) {
                getTsuusyoKaigoSubtraction().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // ���}
            obj = VRBindPathParser.get("1150105", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // ���}�敪(tsuusyoKaigoMeetingAndSendingOff)��3�Ԗڂ̃{�^����I���ɂ���B
                    getTsuusyoKaigoMeetingAndSendingOff().setSelectedIndex(3);
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // ���}�敪(tsuusyoKaigoMeetingAndSendingOff)��1�Ԗڂ̃{�^����I���ɂ���B
                    getTsuusyoKaigoMeetingAndSendingOff().setSelectedIndex(1);
                    break;
                }
            }

            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // �@�\�P���ɑ΂���̐����Z
            obj = VRBindPathParser.get("1150102", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_FUNCTION_TRAINING();
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_FUNCTION_TRAINING();
                    break;
                }
            }
            // �������Z
            obj = VRBindPathParser.get("1150103", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // tsuusyoKaigoAdditionFunctionBathRadio��2�Ԗڂ̃{�^�����擾���A�L���ɂ���B
                    setState_VALID_ADD_BATH();
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // tsuusyoKaigoAdditionFunctionBathRadio��2�Ԗڂ̃{�^�����擾���A�����ɂ���B
                    setState_INVALID_ADD_BATH();
                    break;
                }
            }
            // ���ʓ������Z
            obj = VRBindPathParser.get("1150104", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // tsuusyoKaigoAdditionFunctionBathRadio��3�Ԗڂ̃{�^�����擾���A�L���ɂ���B
                    setState_VALID_ADD_SPECIAL_BATH();
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // tsuusyoKaigoAdditionFunctionBathRadio��3�Ԗڂ̃{�^�����擾���A�����ɂ���B
                    setState_INVALID_ADD_SPECIAL_BATH();
                    break;
                }
            }
            getTsuusyoKaigoAdditionFunctionBathRadio().setSelectedIndex(1);
        }
    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if (!getTsuusyoKaigoTimeDivision().isSelected()) {
            // ���ԋ敪(tsuusyoKaigoTimeDivision)�����I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if (ACTextUtilities
                .isNullText(getTsuusyoKaigoTimeBeginTime().getText())
                || ACTextUtilities.isNullText(getTsuusyoKaigoTimeEndTime()
                        .getText())
                || (!getTsuusyoKaigoTimeBeginTime().isValidDate())
                || (!getTsuusyoKaigoTimeEndTime().isValidDate())) {
            // �J�n�����R���{(tsuusyoKaigoTimeBeginTime)�ƏI�������R���{(tsuusyoKaigoTimeEndTime)�̂����ꂩ���󗓂������͕s���̏ꍇ
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
        if (!getTsuusyoKaigoAdditionFunctionTrainingRadio().isEnabled()) {
            // �@�\�P��(tsuusyoKaigoAdditionFunctionTrainingRadio)�������̏ꍇ
            // �ԋp�p���R�[�h����A�@�\�P��(tsuusyoKaigoAdditionFunctionTrainingRadio)��bindPath����������B
            data.remove(getTsuusyoKaigoAdditionFunctionTrainingRadio()
                    .getBindPath());
        }
        if ((getTsuusyoKaigoAdditionFunctionTrainingRadio().getSelectedButton() != null)
                && (!getTsuusyoKaigoAdditionFunctionTrainingRadio()
                        .getSelectedButton().isEnabled())) {
            // �������Z(tsuusyoKaigoAdditionFunctionBathRadio)�̑I�����ڂ������̏ꍇ
            // �ԋp�p���R�[�h����A�������Z(tsuusyoKaigoAdditionFunctionBathRadio)��bindPath����������B
            data.remove(getTsuusyoKaigoAdditionFunctionTrainingRadio()
                    .getBindPath());
        }
        if (!getTsuusyoKaigoMeetingAndSendingOff().isEnabled()) {
            // ���}(tsuusyoKaigoMeetingAndSendingOff)�������̏ꍇ
            // �ԋp�p���R�[�h����A���}(tsuusyoKaigoMeetingAndSendingOff)��bindPath����������B
            data.remove(getTsuusyoKaigoMeetingAndSendingOff().getBindPath());
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

    /**
     * �u���ԋ敪�̎��Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getKaigoTime() throws Exception {
        // �����ԋ敪(tsuusyoKaigoTimeDivision)�̎��Ԃ��擾
        // ���ԋ敪(tsuusyoKaigoTimeDivision)�̒l���`�F�b�N����B
        switch (getTsuusyoKaigoTimeDivision().getSelectedIndex()) {
        case 1:
            // �Q���Ԉȏ�R���Ԗ����̏ꍇ
            // �߂�l�Ƃ���180��Ԃ��B
            return 180;
        case 2:
            // �R���Ԉȏ�S���Ԗ����̏ꍇ
            // �߂�l�Ƃ���240��Ԃ��B
            return 240;
        case 3:
            // �S���Ԉȏ�U���Ԗ����̏ꍇ
            // �߂�l�Ƃ���360��Ԃ��B
            return 360;
        case 4:
            // �U���Ԉȏ�W���Ԗ����̏ꍇ
            // �߂�l�Ƃ���480��Ԃ��B
            return 480;
        case 5:
            // �W���Ԉȏ�X���Ԗ����̏ꍇ
            // �߂�l�Ƃ���540��Ԃ��B
            return 540;
        case 6:
            // �X���Ԉȏ�P�O���Ԗ����̏ꍇ
            // �߂�l�Ƃ���600��Ԃ��B
            return 600;
        }
        return 0;

    }


    /**
     * �J�n�������͗p�̃R���{��Ԃ��܂��B
     * @return �J�n�������͗p�̃R���{
     */
   public ACComboBox getBeginTimeCombo() {
       // ���J�n�������͗p�̃R���{��Ԃ��B
       // �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return getTsuusyoKaigoTimeBeginTime();
    }
   
   

   /**
    * �I���������͗p�̃R���{��Ԃ��܂��B
    * @return �I���������͗p�̃R���{
    */
    public ACComboBox getEndTimeCombo() {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getTsuusyoKaigoTimeEndTime();
    }

}
