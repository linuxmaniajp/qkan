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
 * �J����: �����F
 * �쐬��: 2011/11/16  ���{�R���s���[�^�[������� �����F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�ʏ����n�r���e�[�V���� (QS001_16611_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[�����\�h�ʏ����n�r���e�[�V����(QS001_16611_201504)
 */
@SuppressWarnings("serial")
public class QS001_16611_201504 extends QS001_16611_201504Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_16611_201504() {

        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("�{�݋敪", "1660108");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�{�݋敪", "1660108", "1660110");
        putImportProviderBindPath("�^����@�\����̐�", "1660102", "1660103");
        putImportProviderBindPath("�h�{���P�̐�", "1660103", "1660104");
        putImportProviderBindPath("���o�@�\����̐�", "1660104", "1660105");
        putImportProviderBindPath("���Ə��]�����Z�̗L��", "1660105", "1660106");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1660107", "1660108");

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1660106", "1660107");
        putRestrictProviderBindPath("�^����@�\����̐�", "1660102", "1660103");
        putRestrictProviderBindPath("�h�{���P�̐�", "1660103", "1660104");
        putRestrictProviderBindPath("���o�@�\����̐�", "1660104", "1660105");
        putRestrictProviderBindPath("�I��I�T�[�r�X�������{���Z", "1660109", "1660111");
        putRestrictProviderBindPath("���Ə��]�����Z�̗L��", "1660105", "1660106");

    }

    // �R���|�[�l���g�C�x���g

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_16611_201504.class.getName(),
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
        // �v���F�藚�����擾
        VRList ninteiList = getCalculater().getPatientInsureInfoHistoryList();
        setIsPrintCheckShow(false);
        // �������ɕ������𑶍݂���ꍇ
        if (ninteiList.size() > 1) {
            VRMap firstHistory = (VRMap) ninteiList.getData(0);
            VRMap secondHistory = (VRMap) ninteiList.getData(1);
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("JOTAI_CODE", firstHistory), 0)) {
            case 12:
                // �v�x���P�˗v�x���Q
                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0)) {
                case 13:
                    setIsPrintCheckShow(true);
                    break;
                }
                break;

            case 13:
                // �v�x���Q�˗v�x���P
                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0)) {
                case 12:
                    setIsPrintCheckShow(true);
                    break;
                }
                break;

            }

        }
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
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
        // ��ʏ�Ԃ�ݒ肷��B
        checkState();

        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();
        // ��ʂ̃��W�I�̏����l��ݒ肷��B�iselectFirstRadioItem�j
        QkanCommon.selectFirstRadioItem(getThis());

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        if (provider != null) {
            // �I�����Ə����null�łȂ��ꍇ
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();
            // ���ݒ�
            // �E���̌����ɂ�錸�Z�̏󋵁i���Ə��p�l���jKEY�F1660101�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1660101", provider), 0)) {
            case 1:
                // �l��1�i�Ȃ��j�������ꍇ
                // defaultMap�� KEY�F1660101 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1660101", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                // �l��2�i��t�E�Ō�E���E���E���EPT�EOT�EST�j�������ꍇ
                // defaultMap�� KEY�F1660101 VALUE�F3�i��t�EPT�EOT�EST�E�Ō�E���E���������j��ݒ肷��B
                VRBindPathParser.set("1660101", defaultMap, new Integer(3));
                break;
            }

            // ���W�J
            // ���g(this)��defaultMap��ݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // ��ʂ̏�Ԃ�ύX����B
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
        // ���ԋp�p�̃��R�[�h(data)�𐶐�
        VRMap data = new VRHashMap();
        // ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
        getThis().setSource(data);
        // ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
        getThis().applySource();
        // ���ԋp�p���R�[�h����s�v�ȃL�[������
        // �������R���{�`�F�b�N
        if (!getHoumonKaigoBeginTime().isValidDate()
                || (!getHoumonKaigoEndTime().isValidDate())) {
            // �J�n�����R���{(houmonKaigoBeginTime)�ƏI�������R���{(houmonKaigoEndTime)�̂����ꂩ���󗓂������͕s���̏ꍇ
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
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkState() throws Exception {

        // ������`�F�b�N�̐���
        checkOnDayCheckState();

        // �^����@�\������Z�E�h�{���P���Z�E���o�@�\������Z�̑g�ݍ��킹�`�F�b�N
        if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1
        		&& getNourishmentImprovementAddRadio().getSelectedIndex() > 1
        		&& getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	// �^����@�\������Z + �h�{���P���Z + ���o�@�\������Z�F�I��I�T�[�r�X�������{���ZII
        	getSentakutekiServiceRadio().setSelectedIndex(5);
        } else if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1
        		&& getNourishmentImprovementAddRadio().getSelectedIndex() > 1) {
        	// �^����@�\������Z + �h�{���P���Z�F�I��I�T�[�r�X�������{���ZI1
        	getSentakutekiServiceRadio().setSelectedIndex(2);
        } else if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1
        		&& getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	// �^����@�\������Z + ���o�@�\������Z�F�I��I�T�[�r�X�������{���ZI2
        	getSentakutekiServiceRadio().setSelectedIndex(3);
        } else if (getNourishmentImprovementAddRadio().getSelectedIndex() > 1
        		&& getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	// �h�{���P���Z + ���o�@�\������Z�F�I��I�T�[�r�X�������{���ZI3
        	getSentakutekiServiceRadio().setSelectedIndex(4);
        } else {
        	// �I��I�T�[�r�X�������{���Z�F�Ȃ�
        	getSentakutekiServiceRadio().setSelectedIndex(1);
        }

        // ���Ə��̐��Ɠ���
        resetStateByRestrictBindPath();

    }

    /**
     * �l�o�C���h�㏈��
     * 
     */
    public void binded() throws Exception {
        // �T�[�r�X�p�l���f�[�^�o�C���h����̃p�l���f�[�^�̕ҏW����
        if (this.getParent() instanceof ACPanel) {
            ACPanel panel = (ACPanel) this.getParent();
            // Map����ꂽ�ꍇ
            if (panel.getSource() instanceof VRMap) {
                VRMap source = (VRMap) panel.getSource();

                /*
                 * �o�[�W�����A�b�v����́A�{�[�Ɉ󎚂��Ȃ��`�F�b�N�Ƀf�[�^���Ȃ��ꍇ�̏���
                 */
                if (getIsPrintCheckShow() && !source.containsKey("15")
                        && getCrackOnDayCheck().isSelected()) {
                    // �\������Ă���ɂ��ւ�炸�AKEY���Ȃ��Ȃ�ΑI����Ԃɂ���
                    getPrintable().setSelected(true);
                }
            }
        }
        checkOnDayCheckState();
    }

    /**
     * �����`�F�b�N���̉�ʐ��䏈���ł��B
     * 
     */
    public void checkOnDayCheckState() throws Exception {
        if (getCrackOnDayCheck().getValue() == 2) {
            // �����ɂ���̂��~�߂�
            setState_DAY_CHECK_ON();
        } else {
            setState_DAY_CHECK_OFF();
        }
    }

    /**
     * �����`�F�b�N���̏���
     * 
     */
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        checkOnDayCheckState();

    }
    
    /**
     * �^����@�\������Z
     */
    protected void moveFunctionImprovementAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ��ʏ�Ԑ���
        checkState();

    }

    /**
     * �h�{���P���Z
     */
    protected void nourishmentImprovementAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ��ʏ�Ԑ���
        checkState();

    }

    /**
     * ���o�@�\������Z
     */
    protected void mouthFunctionImprovementAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ��ʏ�Ԑ���
        checkState();

    }

    /**
     * �I��I�T�[�r�X�������{���Z
     */
    protected void sentakutekiServiceRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        int idx = getSentakutekiServiceRadio().getSelectedIndex();
        // ��ʏ�Ԑ���
        checkState();
        // �S�āu�Ȃ��v���P�����I���̏ꍇ�́A�I���������̂ɖ߂�
        int selCnt = 0;
        if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	selCnt = selCnt + 1;
        }
        if (getNourishmentImprovementAddRadio().getSelectedIndex() > 1) {
        	selCnt = selCnt + 1;
        }
        if (getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	selCnt = selCnt + 1;
        }
        if (selCnt == 1 || selCnt == 0) {
        	getSentakutekiServiceRadio().setSelectedIndex(idx);
        }

    }

}
