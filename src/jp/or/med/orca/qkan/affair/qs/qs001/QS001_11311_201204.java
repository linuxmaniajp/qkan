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
 * �v���O���� �T�[�r�X�p�^�[���K��Ō�i���) (QS001_11311_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACRadioButtonItem;
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
 * �T�[�r�X�p�^�[���K��Ō�i���)(QS001_11311_201204)
 */
@SuppressWarnings("serial")
public class QS001_11311_201204 extends QS001_11311_201204Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_11311_201204() {
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���ꌚ�����Z�҂ւ̃T�[�r�X��", "5");
        
        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�{�ݓ��̋敪", "1130101", "1130103");
        putImportProviderBindPath("���ʊǗ����Z", "1130102", "1130116");

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�ً}���K��Ō���Z", "1130104", "1130108");
        putRestrictProviderBindPath("�ً}���K��Ō���Z", "1130104", "1130122");
        putRestrictProviderBindPath("���ʊǗ��̐�", "1130102", "1130116");
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�E���敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoClassSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ��ʏ�Ԑ��䏈�����Ăяo���B
        checkState();

    }

    /**
     * �u���ԋ敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoTimeSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ���ԋ敪�I��
        // �I�����Ԍv�Z�������Ăяo���B
        checkEndTime();
        // ��ʏ�Ԑ��䏈�����Ăяo���B
        checkState();

    }

    /**
     * �u�J�n���ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoBeginTimeActionPerformed(ActionEvent e)
            throws Exception {
        // �J�n���ԕύX
        // �I�����Ԍv�Z�������Ăяo���B
        checkEndTime();

    }

    /**
     * �u���ԑѕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoTimeZoneSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ���ԑѕύX
        // �K��Ō��쎞�ԑ�(houmonKaigoTimeZone)�̒l���`�F�b�N����B
        switch (getHoumonKangoKaigoTimeZone().getSelectedIndex()) {
        case 1:
            // �ʏ�̏ꍇ
            // �J�n���Ԃ�9:00�ɂ���B
            getHoumonKangoKaigoBeginTime().setText("9:00");
            break;
        case 2:
            // �����̏ꍇ
            // �J�n���Ԃ�6:00�ɂ���B
            getHoumonKangoKaigoBeginTime().setText("6:00");
            break;
        case 3:
            // ��Ԃ̏ꍇ
            // �J�n���Ԃ�18:00�ɂ���B
            getHoumonKangoKaigoBeginTime().setText("18:00");
            break;
        case 4:
            // �[��̏ꍇ
            // �J�n���Ԃ�22:00�ɂ���B
            getHoumonKangoKaigoBeginTime().setText("22:00");
            break;
        }
        // �I�����Ԍv�Z�������Ăяo���B
        checkEndTime();

    }

    /**
     * �u�{�݋敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoFacilityTypeSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ��ʏ�Ԑ��䏈�����Ăяo���B
        checkState();
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_11311_201204.class.getName(),
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
        QkanCommon.selectFirstRadioItem(this);
        // ������
        // �����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
        VRMap defaultMap = new VRHashMap();
        // ���ݒ�
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();
        // �����I��
        getHoumonKangoKaigoTime().setSelectedIndex(3);

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        // �I�����Ə����null�łȂ��ꍇ
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();

            // �T�[�r�X�񋟑̐����Z�͐���
            Object obj;
            obj = VRBindPathParser.get("1130108", provider);
            if (ACCastUtilities.toInt(obj, 0) >= 2) {
                VRBindPathParser.set("1130113", defaultMap, new Integer(2));
            }

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
        if (ACTextUtilities
                .isNullText(getHoumonKangoKaigoBeginTime().getText())
                || ACTextUtilities.isNullText(getHoumonKangoKaigoEndTime()
                        .getText())
                || (!getHoumonKangoKaigoBeginTime().isValidDate())
                || (!getHoumonKangoKaigoEndTime().isValidDate())) {
            // �J�n�����R���{(houmonKangoKaigoBeginTime)�ƏI�������R���{(houmonKangoKaigoEndTime)�̂����ꂩ���󗓂��s���̏ꍇ
            // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
            // null��Ԃ��B
            return null;
        }
        if (getHoumonKangoKaigoTime().isEnabled()
                && !getHoumonKangoKaigoTime().getSelectedButton().isEnabled()) {
            // ���ԋ敪�̗L���ȍ��ڂ��I������Ă��Ȃ��ꍇ
            // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        // ���ԑы敪�ɕs�����������ꍇ
        if (getHoumonKangoKaigoTimeZone().isEnabled()
                && !getHoumonKangoKaigoTimeZone().getSelectedButton()
                        .isEnabled()) {
            // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }

        // �E���敪�ɕs�����������ꍇ
        if (!getHoumonKangoKaigoClass().getSelectedButton().isEnabled()) {
            // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
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
        // �@true��Ԃ��B
        return true;
    }

    /**
     * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ���J�n�������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return getHoumonKangoKaigoBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getHoumonKangoKaigoEndTime();
    }

    /**
     * �u�I�����Ԃ̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkEndTime() throws Exception {
        // ���J�n���ԕύX���A�I�����Ԃ��ύX
        if (getHoumonKangoKaigoBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getHoumonKangoKaigoBeginTime()
                        .getText()))) {
            // �J�n���ԃR���{(houmonKangoKaigoBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
            // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
            int kaigoTime = getKaigoTime();

            // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
            getHoumonKangoKaigoEndTime().setDate(
                    ACDateUtilities.addMinute(getHoumonKangoKaigoBeginTime()
                            .getDate(), kaigoTime));
        }

    }

    /**
     * �u�K��Ō쎞�Ԃ̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getKaigoTime() throws Exception {
        // ���K��Ō쎞�ԋ敪���A���Ԃ��擾
        // �u�K��Ō쎞�ԋ敪(houmonKangoKaigoTime)�v�̒l���`�F�b�N����B
        switch (getHoumonKangoKaigoTime().getSelectedIndex()) {
        case 1: // 20������
            return 20;
        case 2: // 30�������̏ꍇ
            // �߂�l�Ƃ���30��Ԃ��B
            return 30;
        case 3:
            // 30���ȏ�A1���Ԗ����̏ꍇ
            // �߂�l�Ƃ���60��Ԃ��B
            return 60;
        case 4:
            // 1���Ԉȏ�A1���Ԕ������̏ꍇ
            // �߂�l�Ƃ���90��Ԃ��B
            return 90;
        }
        return 0;
    }

    private boolean isEnabledAndSelected(ACRadioButtonItem item) {
        return item.isEnabled() && item.isSelected();
    }

    /**
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * 
     */
    public void checkState() throws Exception {
        // ����ʏ�Ԑ��䏈��

        // �{�݋敪
        int shisetsu = getHoumonKangoKaigoFacilityType().getSelectedIndex();
        switch (shisetsu) {
        case 1: // �K��Ō�X�e�[�V����
            setState_TYPE_STATION();
            break;
        case 2: // ��Ë@��
            setState_TYPE_HOSPITAL();
            break;
        case 3: // �������
            setState_TYPE_TEIKIJUNKAI();
            
            // ������ƒ񋟓��̘A��
            if (getCrackOnDayCheck().isSelected()) {
                setState_DAY_CHECK_ON();
            } else {
                setState_DAY_CHECK_OFF();
            }
            break;
        }

        // �{�݋敪���u�������v�ȊO�̏ꍇ
        if (shisetsu != 3) {

            // �E���敪�ɂ�鎞�ԋ敪�̐���
            if (isEnabledAndSelected(getHoumonKangoKaigoClass3())) {
                // �E���敪���u���w�Ö@�m�v�̏ꍇ
                setState_WORKER_IS_PTOT();
            } else {
                // �E���敪���u���w�Ö@�m�v�ȊO�̏ꍇ
                setState_WORKER_IS_NOT_PTOT();
            }

            // ���ԋ敪�ɂ��2�l�ڂ̎��Ԃ̐���
            if (isEnabledAndSelected(getHoumonKangoKaigoTime1())
                    || isEnabledAndSelected(getHoumonKangoKaigoTime2())) {
                // ���ԋ敪���u20�������v�������́u30�������v�ł���ꍇ
                setState_INVALID_NUMBER_OF_PEOPLE_TIME();
            } else {
                if (isEnabledAndSelected(getHoumonKangoNumberOfPeople2())) {
                    // �K��l����2�l�ł���ꍇ
                    setState_VALID_NUMBER_OF_PEOPLE_TIME();
                } else {
                    // �K��l����1�l�ł���ꍇ
                    setState_INVALID_NUMBER_OF_PEOPLE_TIME();
                }

            }

            // �����ԖK��Ō���Z�̐���
            if (isEnabledAndSelected(getHoumonKangoKaigoTime4())
                    && (isEnabledAndSelected(getSpecialManagementRadioItem2()) || isEnabledAndSelected(getSpecialManagementRadioItem3()))) {
                // ���ԋ敪���u1���Ԉȏ�A1���Ԕ������v�ŁA�����ʊǗ����Z���L�����uI�^�v�uII�^�v�̏ꍇ
                setState_VALID_LONG_TIME();
            } else {
                setState_INVALID_LONG_TIME();
            }
        }

        // ���ԋ敪��ύX����
        checkEndTime();
    }

    /**
     * �u���ʊǗ����Z�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void specialManagementRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ���ʊǗ����Z�ύX
        // ��ʏ�Ԑ��䏈�����Ăяo���B
        checkState();

    }

    /**
     * 2�l�ڂ̖K�⎞�ԑI���@�C�x���g�ł�
     */
    protected void houmonKangoNumberOfPeopleSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ��ʏ�Ԑ���
        checkState();

    }

    /**
     * ������`�F�b�N���̃C�x���g�ł�
     */
    @Override
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        // ��ʏ�Ԑ���
        checkState(); 
        
    }

    /**
     * �o�C���h�㏈��
     * [ID:0000708][Masahiko.Higuchi] 2012/03
     */
    public void binded() throws Exception {
        // ��ʏ�Ԃ��Đ���
        checkState();
        
    }

}
