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
 * �쐬��: 2011/12/12  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���������E�����Ή��^�K����Ō� (QS001_17611_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���������E�����Ή��^�K����Ō�(QS001_17611_201804)
 */
@SuppressWarnings("serial")
public class QS001_17611_201804 extends QS001_17611_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_17611_201804() {
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("�{�ݓ��̋敪", "1760105");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�{�ݓ��̋敪", "1760105", "1760101");
        putImportProviderBindPath("�T�[�r�X�񋟋������Z", "1760104", "1760108");
        putImportProviderBindPath("�����}�l�W�����g�̐��������Z", "1760106", "1760112");

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�^�[�~�i���P�A�̐�", "1760103", "1760107");
        putRestrictProviderBindPath("���ʊǗ��̐�", "1760101", "1760106");
        putRestrictProviderBindPath("�ً}���K��Ō���Z", "1760102", "1760105");
        putRestrictProviderBindPath("�����}�l�W�����g�̐��������Z", "1760106", "1760112");
    }

    // �R���|�[�l���g�C�x���g

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_17611_201804.class.getName(),
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

        // �s�����Ǝ����Z
        comboItemMap.setData("1760109",
                QkanCommon.getArrayFromMasterCode(283, "1760109"));

        // ���J�n����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
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
        // ��ʂ̃��W�I�̏����l��ݒ肷��B�iselectFirstRadioItem�j
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
        // �I�����Ə����null�łȂ��ꍇ
        if (provider == null) {
            return;
        }

        // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
        // ������
        // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
        VRMap defaultMap = getImportData();

        if (VRBindPathParser.get("1760109", provider) == null) {
            VRBindPathParser.set("1760109", defaultMap, new Integer(1));
        }

        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();

        // ��ʏ�Ԑ���
        checkState();

    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        // ���ԋp�p�̃��R�[�h(data)�𐶐�
        VRMap data = new VRHashMap();
        // ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
        getThis().setSource(data);
        // ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
        getThis().applySource();
        // ���ԋp�p���R�[�h����s�v�ȃL�[������
        // �������R���{�`�F�b�N
        if (!getHomonNyuyokuBeginTime().isValidDate()
                || (!getHomonNyuyokuEndTime().isValidDate())) {
            // �J�n�����R���{(homonNyuyokuBeginTime)�ƏI�������R���{(homonNyuyokuEndTime)�̂����ꂩ���󗓂������͕s���̏ꍇ
            // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
            // null��Ԃ��B
            return null;
        }
        QkanCommon.removeDisabledBindPath(getThis(), data);
        // �@���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
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
        return getHomonNyuyokuBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getHomonNyuyokuEndTime();
    }

    /**
     * �T�[�r�X�񋟑I����
     */
    protected void divisionRadioGroupSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ��ʏ�Ԑ���
        checkState();

    }

    /**
     * �K��Ō�w�����̒�
     */
    protected void sijishoOfferRadioGroupSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ��ʏ�Ԑ���
        checkState();

    }

    @Override
    public void checkState() throws Exception {

        if (getDivisionRadioGroup().getSelectedIndex() == 1) {
            // ��̌^�������
            if (getSijishoOfferRadioGroup().getSelectedIndex() == 1) {
                // �w�����󂯂Ȃ��ꍇ
                setState_DIVISION_STATE_1();
            } else {
                // �w�����󂯂�ꍇ
                setState_DIVISION_STATE_2();
            }

        } else {
            // �A�g�^�������
            setState_DIVISION_STATE_3();
        }

        checkOnDayCheckState();

        // ���Ə�����ŗD��
        resetStateByRestrictBindPath();

    }

    @Override
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        checkOnDayCheckState();
    }

    @Override
    public void checkOnDayCheckState() throws Exception {
        if (getCrackOnDayCheck().isEnabled()
                && getCrackOnDayCheck().getValue() == 2) {
            // �����`�F�b�N���L��̏ꍇ
            setState_DAY_CHECK_ON();
        } else {
            // �����`�F�b�N�������̏ꍇ
            setState_DAY_CHECK_OFF();
        }
    }

    @Override
    public void binded() throws Exception {
        // ��ʏ�Ԑ���
        checkState();
    }

}
