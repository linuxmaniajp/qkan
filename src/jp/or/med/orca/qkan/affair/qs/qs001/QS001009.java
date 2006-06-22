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
 * �쐬��: 2006/01/17  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[���ʏ����n (001)
 * �v���O���� �T�[�r�X�p�^�[���ʏ����n (QS001009)
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
 * �T�[�r�X�p�^�[���ʏ����n(QS001009)
 */
public class QS001009 extends QS001009Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001009() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�J�n���ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonRehabilitationTimeContenaBeginTimeActionPerformed(
            ActionEvent e) throws Exception {
        // ���J�n���ԕύX���A�I�����Ԃ��ύX
        // ���ԑѕύX���A�I�����Ԃ��ύX����B
        checkEndTime();

    }

    /**
     * �u���ԋ敪�ύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonRehabilitationTimeDivisionActionPerformed(ActionEvent e)
            throws Exception {
        // �����ԋ敪�ύX���A�I�����Ԃ��ύX
        // ���ԋ敪�ύX���A�I�����Ԃ��ύX����B
        checkEndTime();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001009.class.getName(), param));
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
        // �擾�����l���AcomboItemMap�� KEY : 1160104 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1160104", QkanCommon.getArrayFromMasterCode(40,
                "1160104"));
        // ���R���{�A�C�e���̐ݒ�
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();

        // ���I�����ڂ̏����ݒ�
        // �ʃ��n(houmonRehabilitationIndividualRadio)�́u�Ȃ��v��I������B
        getHoumonRehabilitationIndividualRadio().setSelectedIndex(1);
        // ���n�r���K��w�����Z(houmonRehabilitationAdditionTreatmentPersonRadio)�́u�Ȃ��v��I������B
        getHoumonRehabilitationAdditionTreatmentPersonRadio().setSelectedIndex(
                1);
        //�������Z(houmonRehabilitationBathRadio)�́u�Ȃ��v��I������B
        getHoumonRehabilitationBathRadio().setSelectedIndex(1);
        //�l�����Z(houmonRehabilitationSubtraction)�́u�Ȃ��v��I������B
        getHoumonRehabilitationSubtraction().setSelectedIndex(1);
    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        if (provider != null) {
            Object obj;
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // �{�݋敪
            obj = VRBindPathParser.get("1160101", provider);
            if (obj != null) {
                getHoumonRehabilitationTimeContenaFacilityDivision()
                        .setSelectedIndex(ACCastUtilities.toInt(obj));
            }
            // �l�����Z
            obj = VRBindPathParser.get("1160105", provider);
            if (obj != null) {
                getHoumonRehabilitationSubtraction().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // ���}
            obj = VRBindPathParser.get("1160104", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // ���}�敪(houmonRehabilitationMeetingAndSendingOff)��3�Ԗڂ̃{�^����I���ɂ���B
                    getHoumonRehabilitationMeetingAndSendingOff()
                            .setSelectedIndex(3);
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // ���}�敪(houmonRehabilitationMeetingAndSendingOff)��1�Ԗڂ̃{�^����I���ɂ���B
                    getHoumonRehabilitationMeetingAndSendingOff()
                            .setSelectedIndex(1);
                    break;
                }
            }
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // �������Z
            obj = VRBindPathParser.get("1160102", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // houmonRehabilitationBathRadio��2�Ԗڂ̃{�^�����擾���A�L���ɂ���B
                    setState_VALID_ADD_BATH();
                } else {
                    // �u�Ȃ��v�̏ꍇ
                    // houmonRehabilitationBathRadio��2�Ԗڂ̃{�^�����擾���A�����ɂ���B
                    setState_INVALID_ADD_BATH();
                }
            }
            // ���ʓ������Z
            obj = VRBindPathParser.get("1160103", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // houmonRehabilitationBathRadio��3�Ԗڂ̃{�^�����擾���A�L���ɂ���B
                    setState_VALID_ADD_SPECIAL_BATH();
                } else {
                    // �u�Ȃ��v�̏ꍇ
                    // houmonRehabilitationBathRadio��3�Ԗڂ̃{�^�����擾���A�����ɂ���B
                    setState_INVALID_ADD_SPECIAL_BATH();
                }
            }
            //�������Z�́u�Ȃ��v��I������B
            getHoumonRehabilitationBathRadio().setSelectedIndex(1);
        }
    }

    /**
     * �u���ԋ敪�̎��Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getKaigoTime() throws Exception {
        // �����ԋ敪(houmonRehabilitationTimeDivision)�̎��Ԃ��擾
        // ���ԋ敪(houmonRehabilitationTimeDivision)�̒l���`�F�b�N����B
        switch (getHoumonRehabilitationTimeDivision().getSelectedIndex()) {
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
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B

        if (!getHoumonRehabilitationTimeDivision().isSelected()) {
            // ���ԋ�(houmonRehabilitationTimeDivision)�������I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }

        if (ACTextUtilities
                .isNullText(getHoumonRehabilitationTimeContenaBeginTime()
                        .getText())
                || ACTextUtilities
                        .isNullText(getHoumonRehabilitationTimeContenaEndTime()
                                .getText())
                || (!getHoumonRehabilitationTimeContenaBeginTime()
                        .isValidDate())
                || (!getHoumonRehabilitationTimeContenaEndTime().isValidDate())) {
            // �J�n�����R���{(houmonRehabilitationTimeContenaBeginTime)���󗓂��s���̏ꍇ
            // �������͏I�������R���{(houmonRehabilitationTimeContenaEndTime)���󗓂��s���̏ꍇ
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
        if ((getHoumonRehabilitationBathRadio().getSelectedButton() != null)
                && (!getHoumonRehabilitationBathRadio().getSelectedButton()
                        .isEnabled())) {
            // �������Z(houmonRehabilitationBathRadio)�̑I�����ڂ������̏ꍇ
            // �ԋp�p���R�[�h����A�������Z(houmonRehabilitationBathRadio)��bindPath����������B
            data.remove(getHoumonRehabilitationBathRadio().getBindPath());
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
     * �u�I�����Ԃ̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkEndTime() throws Exception {
        // �����ԑѕύX���A�I�����Ԃ��ύX
        // �J�n���ԃR���{(houmonRehabilitationTimeContenaBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
        // ���ԑޔ�p�̕ϐ�kangoTime�ɁA���ԋ敪����擾�������Ԃ�ݒ肷��B

        // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
        if (getHoumonRehabilitationTimeContenaBeginTime().isValidDate()
                && (!ACTextUtilities
                        .isNullText(getHoumonRehabilitationTimeContenaBeginTime()
                                .getText()))) {
            // �J�n���ԃR���{(houmonKangoKaigoBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
            // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
            int kaigoTime = getKaigoTime();

            // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
            getHoumonRehabilitationTimeContenaEndTime().setDate(
                    ACDateUtilities.getInstance().addMinute(
                            getHoumonRehabilitationTimeContenaBeginTime()
                                    .getDate(), kaigoTime));
        }

    }

    /**
     * �u�{�݋敪�ύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonRehabilitationTimeContenaFacilityDivisionActionPerformed(
            ActionEvent e) throws Exception {
        // ���{�݋敪�ύX���A���n�r���K��w�����Z���ύX
        if (getHoumonRehabilitationTimeContenaFacilityDivision()
                .getSelectedIndex() == 3) {
            // �{�݋敪(houmonRehabilitationTimeContenaFacilityDivision)�Ɂu���V�l�ی��{�݁v��I�������ꍇ
            // ���n�r���K��w�����Z(houmonRehabilitationAdditionTreatmentPersonRadio)��L���ɂ���B
            setState_VALID_ADD_REHA_TREATMENT();
        } else {
            // �{�݋敪(houmonRehabilitationTimeContenaFacilityDivision)�Ɂu���V�l�ی��{�݁v�ȊO��I�������ꍇ
            // ���n�r���K��w�����Z(houmonRehabilitationAdditionTreatmentPersonRadio)�𖳌��ɂ���B
            setState_INVALID_ADD_REHA_TREATMENT();
        }
    }


    /**
     * �J�n�������͗p�̃R���{��Ԃ��܂��B
     * @return �J�n�������͗p�̃R���{
     */
   public ACComboBox getBeginTimeCombo() {
       // ���J�n�������͗p�̃R���{��Ԃ��B
       // �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return getHoumonRehabilitationTimeContenaBeginTime();
    }
   
   

   /**
    * �I���������͗p�̃R���{��Ԃ��܂��B
    * @return �I���������͗p�̃R���{
    */
    public ACComboBox getEndTimeCombo() {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getHoumonRehabilitationTimeContenaEndTime();
    }

}
