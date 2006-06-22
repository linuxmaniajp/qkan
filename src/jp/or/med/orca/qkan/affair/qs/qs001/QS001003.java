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
 * �쐬��: 2006/01/08  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K���� (QS001003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���K����(QS001003)
 */
public class QS001003 extends QS001003Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001003() {
    }

    /**
     * �������������s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // ����ʓW�J���̏����ݒ�
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();

        // ���K����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F198�i�K���ʁj���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1110101 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1110101", QkanCommon.getArrayFromMasterCode(198,
                "1110101"));
        // ���񋟎���
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F26�i�񋟎��ԁj���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1110105 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1110105", QkanCommon.getArrayFromMasterCode(26,
                "1110105"));
        // �������g�̎���
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F26�i�����g�̎��ԁj���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1110104 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1110104", QkanCommon.getArrayFromMasterCode(26,
                "1110104"));
        // ���J�n����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ���R���{�A�C�e���̐ݒ�
        // �u���g(this)�v��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();

        // ���I�����ڂ̏����ݒ�
        // �K��҂̋��E���W�I�O���[�v(houmonKaigoClass)�́u3���ȊO�v��I������B
        getHoumonKaigoClass().setSelectedIndex(1);
        // �K��l�����W�I�O���[�v(houmonKaigoNumberOfPeople)�́u1�l�v��I������B
        getHoumonKaigoNumberOfPeople().setSelectedIndex(1);
        // ���ԑу��W�I�O���[�v(houmonKaigoTimeZone)�́u�ʏ�v��I������B
        getHoumonKaigoTimeZone().setSelectedIndex(1);

    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u��Ԑݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKaigoServicePatternActionPerformed(ActionEvent e)
            throws Exception {
        // ���u�K���ʁv�ɉ����āA�I���\�ȃC���X�^���X��ݒ�
        // �K���ʂ̒l���`�F�b�N����B
        switch (getHoumonKaigoServicePattern().getSelectedIndex()) {
        case 0:
            // �g�̉��̏ꍇ
            // �g�̉��p�̏�Ԃ�ݒ肷��B
            setState_SHINTAI_KAIGO();
            break;
        case 1:
            // ���������̏ꍇ
            // ���������p�̏�Ԃ�ݒ肷��B
            setState_SEIKATSU_ENJO();
            break;
        case 2:
            // �g�̐����̏ꍇ
            // �g�̐����p�̏�Ԃ�ݒ肷��B
            setState_SHINTAI_SEIKATSU();
            break;
        case 3:
            // �ʉ@����~��̏ꍇ
            // �ʉ@����~��p�̏�Ԃ�ݒ肷��B
            setState_JOKOKAIJO();
            break;
        }
    }

    /**
     * �u���ԑѕύX���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKaigoTimeZoneActionPerformed(ActionEvent e)
            throws Exception {
        // �����ԑѕύX���A�J�n���Ԃ��ύX
        // houmonKaigoTimeZone�̒l���`�F�b�N����B
        switch (getHoumonKaigoTimeZone().getSelectedIndex()) {
        case 1:
            // �ʏ�̏ꍇ
            // �J�n���Ԃ�9:00�ɂ���B
            getHoumonKaigoBeginTime().setText("9:00");
            break;
        case 2:
            // �����̏ꍇ
            // �J�n���Ԃ�6:00�ɂ���B
            getHoumonKaigoBeginTime().setText("6:00");
            break;
        case 3:
            // ��Ԃ̏ꍇ
            // �J�n���Ԃ�18:00�ɂ���B
            getHoumonKaigoBeginTime().setText("18:00");
            break;
        case 4:
            // �[��̏ꍇ
            // �J�n���Ԃ�22:00�ɂ���B
            getHoumonKaigoBeginTime().setText("22:00");
            break;
        }
        // ���ԑѕύX���A�I�����Ԃ��ύX����B
        checkEndTime();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        ACFrame.debugStart(new ACAffairInfo(QS001003.class.getName()));
    }

    // �����֐�

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param provider VRMap
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {

    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return VRMap
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if (!getHoumonKaigoServicePattern().isSelected()) {
            // �K���ʂ����I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }

        if (getHoumonKaigoServicePattern().getSelectedIndex() != 3) {
            // �K���ʂ��ʉ@��~�����ȊO�̏ꍇ
            if (!getHomonkaigoTeikyoTime().isSelected()) {
                // �񋟎��Ԃ����I���̏ꍇ
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }

            switch (getHoumonKaigoServicePattern().getSelectedIndex()) {
            case 1:
                // �K���ʂ����������̏ꍇ
                if (getHomonkaigoTeikyoTime().getSelectedIndex() < 1) {
                    // �񋟎��ԃR���{(homonkaigoTeikyoTime)��30�������̏ꍇ
                    // ���������̒񋟎��Ԃ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_LIFE_ASSIST_TIME
                    QkanMessageList.getInstance()
                            .QS001_ERROR_OF_LIFE_ASSIST_TIME();
                    // null��Ԃ��B
                    return null;
                }
                break;
            case 2:
                // �K���ʂ��g�̐����̏ꍇ
                if (!getHoumonKaigoInTime().isSelected()) {
                    // �����g�̎��Ԃ����I���̏ꍇ
                    // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // null��Ԃ��B
                    return null;
                }

                if (getHomonkaigoTeikyoTime().getSelectedIndex() < getHoumonKaigoInTime()
                        .getSelectedIndex()) {
                    // �񋟎��Ԃ��������g�̎��Ԃ̂ق����傫���ꍇ
                    // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // null��Ԃ��B
                    return null;
                }
                break;
            }

        }

        if (ACTextUtilities.isNullText(getHoumonKaigoBeginTime().getText())
                || ACTextUtilities
                        .isNullText(getHoumonKaigoEndTime().getText())
                || (!getHoumonKaigoBeginTime().isValidDate())
                || (!getHoumonKaigoEndTime().isValidDate())) {
            // �J�n�����R���{(houmonKaigoBeginTime)�ƏI�������R���{(houmonKaigoEndTime)�̂����ꂩ���󗓂������͕s���̏ꍇ
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
        if (!getHomonkaigoTeikyoTime().isEnabled()) {
            // �񋟎���(homonkaigoTeikyoTime)�������̏ꍇ
            // �ԋp�p���R�[�h����A�񋟎���(homonkaigoTeikyoTime)��bindPath����������B
            data.remove(getHomonkaigoTeikyoTime().getBindPath());
        }
        if (!getHoumonKaigoInTime().isEnabled()) {
            // �����g�̎���(houmonKaigoInTime)�������̏ꍇ
            // �ԋp�p���R�[�h����A�����g�̎���(houmonKaigoInTime)��bindPath����������B
            data.remove(getHoumonKaigoInTime().getBindPath());
        }
        if (!getHoumonKaigoNumberOfPeople().isEnabled()) {
            // �K��l��(houmonKaigoNumberOfPeople)�������̏ꍇ
            // �ԋp�p���R�[�h����A�K��l��(houmonKaigoNumberOfPeople)��bindPath����������B
            data.remove(getHoumonKaigoNumberOfPeople().getBindPath());
        }
        if (!getHoumonKaigoBeginTime().isEnabled()) {
            // �J�n�����R���{(houmonKaigoBeginTime)�������ȏꍇ
            // �ԋp�p���R�[�h����A�K��l��(houmonKaigoBeginTime)��bindPath����������B
            // �ԋp�p���R�[�h����A�K��l��(houmonKaigoEndTime)��bindPath����������B
            data.remove(getHoumonKaigoBeginTime().getBindPath());
            data.remove(getHoumonKaigoEndTime().getBindPath());

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
        // true��Ԃ��B
        return true;
    }

    /**
     * �u�񋟎��ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void homonkaigoTeikyoTimeActionPerformed(ActionEvent e)
            throws Exception {
        // �����ԑѕύX���A�I�����Ԃ��ύX
        // ���ԑѕύX���A�I�����Ԃ��ύX����B
        checkEndTime();
    }

    /**
     * �u�񋟎��Ԃ̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return int
     */
    public int getTeikyoTime() throws Exception {
        // ���񋟎��ԃR���{���A���Ԃ��擾
        // �񋟎��ԃR���{(homonkaigoTeikyoTime)�̒l���`�F�b�N����B
        if (getHomonkaigoTeikyoTime().isSelected()) {
            // (�I��ԍ�+1)�~30��Ԃ��B
            return (getHomonkaigoTeikyoTime().getSelectedIndex() + 1) * 30;
        }
        return 0;
    }

    /**
     * �u�I�����Ԃ̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkEndTime() throws Exception {
        // �����ԑѕύX���A�I�����Ԃ��ύX
        if (getHoumonKaigoBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getHoumonKaigoBeginTime()
                        .getText()))) {
            // �J�n�����R���{(houmonKaigoBeginTime)�����͍ς݂��s���łȂ��ꍇ
            // �񋟎��ԃR���{����񋟕������擾����B
            // �J�n�����ɒ񋟕��������Z�������ʂ��I�������R���{(houmonKaigoEndTime)�ɐݒ肷��B
            getHoumonKaigoEndTime().setDate(
                    ACDateUtilities.addMinute(
                            getHoumonKaigoBeginTime().getDate(),
                            getTeikyoTime()));
        }

    }

    /**
     * �J�n�������͗p�̃R���{��Ԃ��܂��B
     * @return �J�n�������͗p�̃R���{
     */
   public ACComboBox getBeginTimeCombo() {
       // ���J�n�������͗p�̃R���{��Ԃ��B
       // �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return getHoumonKaigoBeginTime();
    }
   
   

   /**
    * �I���������͗p�̃R���{��Ԃ��܂��B
    * @return �I���������͗p�̃R���{
    */
    public ACComboBox getEndTimeCombo() {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getHoumonKaigoEndTime();
    }
}
