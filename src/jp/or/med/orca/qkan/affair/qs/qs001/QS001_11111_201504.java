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
 * �쐬��: 2011/11/15  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K���� (QS001_11111_201504)
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
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���K����(QS001_11111_201504)
 */
@SuppressWarnings("serial")
public class QS001_11111_201504 extends QS001_11111_201504Event {
	
	
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_11111_201504() {
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("�T�[�r�X�񋟐ӔC��", "1110103");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�T�[�r�X�񋟐ӔC��", "1110103", "1110113");
        putImportProviderBindPath("���莖�Ə����Z", "1110101", "1110109");
        
        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�p��̖K��Ƃ��čs��", "1110104", "1110114");
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
        // �R���{���ݒ�
        checkComboItem();

        // ��ʏ�Ԑ���
        checkState();

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

    /**
     * �u�g�̉��񋟎��ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void homonkaigoTeikyoTimeActionPerformed(ActionEvent e)
            throws Exception {
        // �����ԑѕύX���A�I�����Ԃ��ύX
        // ���ԑѕύX���A�I�����Ԃ��ύX����B
        checkEndTime();

// 2015/2/26 [H27.4�����Ή�][Yoichiro Kamei] add - begin            
        // ��ʏ�Ԑ���
        checkState();
// 2015/2/26 [H27.4�����Ή�][Yoichiro Kamei] add - end
    }

    /**
     * �u���������񋟎��ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKaigoInTimeActionPerformed(ActionEvent e)
            throws Exception {
        // �����ԑѕύX���A�I�����Ԃ��ύX
        // ���ԑѕύX���A�I�����Ԃ��ύX����B
        checkEndTime();

    }

    /**
     * �u�J�n���ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKaigoBeginTimeActionPerformed(ActionEvent e)
            throws Exception {
        // ���J�n���ԕύX���A�I�����Ԃ��ύX
        // �J�n���ԕύX���A�I�����Ԃ��ύX
        checkEndTime();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_11111_201504.class.getName(),
                param));
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
        // ���ݒ�
        // ���K����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F198�i�K���ʁj���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1110101 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1110101",
                QkanCommon.getArrayFromMasterCode(198, "1110101"));
        // ���񋟎���
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F281�i�����g�̎��ԁj���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1110104 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1110104",
                QkanCommon.getArrayFromMasterCode(280, "1110104"));
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F280�i�񋟎��ԁj���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1110105 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1110105",
                QkanCommon.getArrayFromMasterCode(281, "1110105"));
        // �������g�̎���
        // ���J�n����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ���W�J
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();
        // ���I�����ڂ̏����ݒ�
        QkanCommon.selectFirstRadioItem(getThis());
        // ������
        // �����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
        VRMap defaultMap = new VRHashMap();
        // ���ݒ�
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        // �I�����Ə����null�łȂ��ꍇ
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();

            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            
            // ��ʏ�Ԑ���
            checkState();
        }
    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
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
            switch (getHoumonKaigoServicePattern().getSelectedIndex()) {
            case 0:
                // �K���ʂ��g�̉��̏ꍇ
                if (!getHomonkaigoTeikyoTime().isSelected()) {
                    // �񋟎��Ԃ����I���̏ꍇ
                    // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // null��Ԃ��B
                    return null;
                }
                break;
            case 1:
                // �K���ʂ����������̏ꍇ
                if (!getHoumonKaigoInTime().isSelected()) {
                    // �񋟎��Ԃ����I���̏ꍇ
                    // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // null��Ԃ��B
                    return null;
                }
                break;
            case 2:
                // �K���ʂ��g�̐����̏ꍇ
                if ((!getHomonkaigoTeikyoTime().isSelected())
                        || (!getHoumonKaigoInTime().isSelected())) {
                    // �񋟎��Ԃ����I���̏ꍇ
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
        QkanCommon.removeDisabledBindPath(getThis(), data);
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
     * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ���J�n�������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return getHoumonKaigoBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getHoumonKaigoEndTime();
    }

    /**
     * �u�񋟎��Ԃ̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getTeikyoTime() throws Exception {
        // ���񋟎��ԃR���{���A���Ԃ��擾
        int addMinute = 0;
        // �񋟎��ԃR���{(homonkaigoTeikyoTime)�̒l���`�F�b�N����B
        if (getHomonkaigoTeikyoTime().isEnabled()
                && getHomonkaigoTeikyoTime().isSelected()) {
            // ���g�̉��
            // [ID:0000706][Shin Fujihara] 2012/03 delete begin 2012�N�x�Ή�
//            if (getHoumonKaigoServicePattern().getSelectedIndex() == 2) {
//                // (�I��ԍ�+1)�~30��Ԃ��B
//                addMinute += (getHomonkaigoTeikyoTime().getSelectedIndex() + 1) * 30;
//            } else {
//                if (getHomonkaigoTeikyoTime().getSelectedIndex() == 0) {
//                    addMinute += 20;
//                } else {
//                    // (�I��ԍ�+1)�~30��Ԃ��B
//                    addMinute += (getHomonkaigoTeikyoTime().getSelectedIndex()) * 30;
//                }
//            }
            // [ID:0000706][Shin Fujihara] 2012/03 delete end 2012�N�x�Ή�
            // [ID:0000706][Shin Fujihara] 2012/03 add begin 2012�N�x�Ή�
            if (getHomonkaigoTeikyoTime().getSelectedIndex() == 0) {
                addMinute += 20;
            } else {
                // (�I��ԍ�+1)�~30��Ԃ��B
                addMinute += (getHomonkaigoTeikyoTime().getSelectedIndex()) * 30;
            }
            // [ID:0000706][Shin Fujihara] 2012/03 add end 2012�N�x�Ή�
        }
        if (getHoumonKaigoInTime().isEnabled()
                && getHoumonKaigoInTime().isSelected()) {
            if (getHoumonKaigoServicePattern().getSelectedIndex() == 1) {
                // ���������̏ꍇ
                if (getHoumonKaigoInTime().getSelectedIndex() == 0) {
                    // [ID:0000718][Masahiko.Higuchi] 2012/04 edit begin 2012�N�x�Ή�
                    addMinute += 45;
                    // [ID:0000718][Masahiko.Higuchi] 2012/04 edit end
                } else {
                    // [ID:0000718][Masahiko.Higuchi] 2012/04 edit begin 2012�N�x�Ή�
                    addMinute += 70;
                    // [ID:0000718][Masahiko.Higuchi] 2012/04 edit end
                }
            } else {
                // �g�̐���
                // [ID:0000705][Shin Fujihara] 2012/03 delete begin 2012�N�x�Ή�
//                if (getHoumonKaigoInTime().getSelectedIndex() == 0) {
//                    addMinute += 20;
//                } else {
//                    addMinute += 20 + ((getHoumonKaigoInTime()
//                            .getSelectedIndex() * 25));
//                }
                // [ID:0000705][Shin Fujihara] 2012/03 delete end 2012�N�x�Ή�
                // [ID:0000705][Shin Fujihara] 2012/03 add begin 2012�N�x�Ή�
                addMinute += 45 + ((getHoumonKaigoInTime().getSelectedIndex() * 25));
                // [ID:0000705][Shin Fujihara] 2012/03 add end 2012�N�x�Ή�
            }
        }
        return addMinute;
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
                    ACDateUtilities.addMinute(getHoumonKaigoBeginTime()
                            .getDate(), getTeikyoTime()));
        }

    }

    /**
     * �u�R���{���e�ύX�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkComboItem() throws Exception {
        // ���R���{���e�ύX����
        // �����ϐ� comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
        // �T�[�r�X�R���{�̒l���`�F�b�N����B
        switch (getHoumonKaigoServicePattern().getSelectedIndex()) {
        case 0: // �g�̐���
            // �l��0�i�g�̐����j�������ꍇ
            comboItemMap.setData("1110104",
                    QkanCommon.getArrayFromMasterCode(280, "1110104"));
            // // �R�[�h�}�X�^�f�[�^���CODE_ID�F282�i�񋟎��ԁE�g�̉��j���擾����B
            // // �擾�����l���AcomboItemMap�� KEY : 1110105 �� VALUE �Ƃ��Đݒ肷��B
            // comboItemMap.setData("1110105",
            // QkanCommon.getArrayFromMasterCode(282, "1110105"));
            break;

        case 1: // ��������
            // �l��1�i���������j�������ꍇ
            // comboItemMap.setData("1110104",
            // QkanCommon.getArrayFromMasterCode(280, "1110104"));

            // �R�[�h�}�X�^�f�[�^���CODE_ID�F281�i�񋟎��ԁE���������j���擾����B
            // �擾�����l���AcomboItemMap�� KEY : 1110105 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1110105",
                    QkanCommon.getArrayFromMasterCode(281, "1110105"));
            break;

        case 2: // �g�̐���
            // �l��2�i�g�̐����j�������ꍇ
            // �R�[�h�}�X�^�f�[�^���CODE_ID�F285�i�񋟎��ԁE�g�̐����j���擾����B
            // �擾�����l���AcomboItemMap�� KEY : 1110105 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1110104",
                    QkanCommon.getArrayFromMasterCode(285, "1110104"));

            comboItemMap.setData("1110105",
                    QkanCommon.getArrayFromMasterCode(282, "1110105"));
            break;

        }

        // ���W�J
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();

    }

    /**
     * �u�o�C���h�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void binded() throws Exception {
        // ���o�C���h���̏���
        // �@�T�[�r�X�敪�����������ŏ������������R���{�̒l��3�ȏゾ�����ꍇ�͈ꗥ2��ݒ��Ԃɂ���B
        // �T�[�r�X�敪�����������������ꍇ
        if (getHoumonKaigoServicePattern().getSelectedIndex() == 1) {
            // �\�[�X���擾
            VRBindSource src = getHoumonKaigoInTime().getSource();
            if (src != null) {
                // ���������R���{�̒l���`�F�b�N����B
                // �v�]�Ή��O�̃f�[�^�������ꍇ
                if (ACCastUtilities.toInt(src.getData("1110105")) >= 3) {
                    getHoumonKaigoInTime().setSelectedIndex(1);
                }
            }
        }
        
// 2015/2/26 [H27.4�����Ή�][Yoichiro Kamei] add - begin
        // ��ʏ�Ԑ���
        checkState();
// 2015/2/26 [H27.4�����Ή�][Yoichiro Kamei] add - end
    }

    @Override
    protected void specificProviderAddRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ��ʏ�Ԑ���
        checkState();

    }

    @Override
    public void checkState() throws Exception {
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
        
        // ���莖�Ə����Z�I����
        if (getSpecificProviderAddRadio().isEnabled()) {
            switch (getSpecificProviderAddRadio().getSelectedIndex()) {
            case 2: // I�^
                setState_CLASS2_INVALID();
                break;
            default:
                setState_CLASS2_VALID();
                break;
            }
        }
        
 // 2015/2/4 [H27.4�����Ή�][Yoichiro Kamei] add - begin
        if (getHomonkaigoTeikyoTime().isEnabled()) {
            switch (getHomonkaigoTeikyoTime().getSelectedIndex()) {
            case 0: // 20�������I����
                setState_MORE_TIMES_CHECK_VALID();
                break;
            default:
                setState_MORE_TIMES_CHECK_INVALID();
                break;
            }
        } else {
            setState_MORE_TIMES_CHECK_INVALID();
        }
        
        // �I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
        resetStateByRestrictBindPath();
//2015/2/4 [H27.4�����Ή�][Yoichiro Kamei] add - end
    }

}
