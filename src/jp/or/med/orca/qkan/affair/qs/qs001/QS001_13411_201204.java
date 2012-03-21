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
 * �v���O���� �T�[�r�X�p�^�[�����\�h����×{�Ǘ��w�� (QS001_13411_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[�����\�h����×{�Ǘ��w��(QS001_13411_201204)
 */
@SuppressWarnings("serial")
public class QS001_13411_201204 extends QS001_13411_201204Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_13411_201204() {
        
        // ���Ə��̐��̃`�F�b�N�A����Ȃ�
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�E���敪�I���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    @Override
    protected void chargeClassificationRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // �ݑ��f�I��
        // ��ʂ̏�Ԃ�ύX����
        checkState();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_13411_201204.class.getName(),
                param));
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
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
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
        // ������
        // �����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
        VRMap defaultMap = new VRHashMap();
        // ���ݒ�
        // ���W�I�̏����l��I����Ԃɂ���B��selectFirstRadioItem(getThis)
        QkanCommon.selectFirstRadioItem(getThis());
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();
        // ��ʂ̏�Ԃ�ύX����B
        checkState();

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        // �I�����Ə����null�łȂ��ꍇ
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();
            // ���ݒ�
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
        }
        // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
        // ��ʂ̏�Ԃ�ύX����B
        checkState();

    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
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
        if (!getRecuperationManagementGuidanceBeginTime().isValidDate()
                || (!getRecuperationManagementGuidanceEndTime().isValidDate())) {
            // �J�n�����R���{(recuperationManagementGuidanceBeginTime)�ƏI�������R���{(recuperationManagementGuidanceEndTime)�̂����ꂩ���󗓂��s���̏ꍇ
            // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
            // null��Ԃ��B
            return null;
        }
        QkanCommon.removeDisabledBindPath(getThis(), data);
        // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
        return data;
    }

    /**
     * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public boolean isUseProvider() throws Exception {
        // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
        // true��Ԃ��B
        return true;
    }

    /**
     * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ���J�n�������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return getRecuperationManagementGuidanceBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getRecuperationManagementGuidanceEndTime();
    }

    /**
     * �u���񋟖����{���Z����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void checkState() throws Exception {
        // ���񋟖����{���Z����Ɋւ��鏈��
        // �S���ҋ敪���̒l���`�F�b�N����B
        switch (getChargeClassificationRadioGroup().getSelectedIndex()) {
        case 1:
            // �l��1(��t)���I�����ꂽ�ꍇ
            // ��ʏ�Ԃ��ʏ��-��t�I��ɕύX����B
            setState_STATE_MODE_1();
            break;
        case 2:
            // �l��2(���Ȉ�t)���I�����ꂽ�ꍇ
            // ��ʏ�Ԃ��ʏ��-���Ȉ�t�I��ɕύX����B
            setState_STATE_MODE_2();
            break;
        case 3:
            // �l��3(��܎t�i��Ë@�ցj)���I�����ꂽ�ꍇ
            // ��ʏ�Ԃ��ʏ��-��܎t�i��Ë@�ցj�I��ɕύX����B
            setState_STATE_MODE_3();
            break;
        case 4:
            // �l��4(��܎t�i��ǁj)���I�����ꂽ�ꍇ
            // ��ʏ�Ԃ��ʏ��-��܎t�i��ǁj�I��ɕύX����B
            setState_STATE_MODE_4();
            break;
        case 5:
            // �l��5(�Ǘ��h�{�m)���I�����ꂽ�ꍇ
            // ��ʏ�Ԃ��ʏ��-�Ǘ��h�{�m�I��ɕύX����B
            setState_STATE_MODE_5();
            break;
        case 6:
            // �l��6(���ȉq���m��)���I�����ꂽ�ꍇ
            // ��ʏ�Ԃ��ʏ��-���ȉq���m���I��ɕύX����B
            setState_STATE_MODE_6();
            break;
        case 7:
            // �l��7(�Ō�E��)���I�����ꂽ�ꍇ
            // ��ʏ�Ԃ��ʏ��-�Ō�E���I��ɕύX����B
            setState_STATE_MODE_7();
            break;
        }

    }

    /**
     * �E���敪�I����
     */
    protected void recuperationManagementGuidanceOccupationalCategorySelectionChanged(
            ListSelectionEvent e) throws Exception {
        checkState();

    }

    protected void patientDivisionRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ��ʏ�Ԑ���
        checkState();

    }

}
