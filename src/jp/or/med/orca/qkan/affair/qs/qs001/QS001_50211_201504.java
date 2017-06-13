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
 * �J����: �����@���̂�
 * �쐬��: 2016/08/30  MIS��B������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K��^�T�[�r�X(�Ǝ�) (QS001_50211_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���K��^�T�[�r�X(�Ǝ�)(QS001_50211_201504)
 */
@SuppressWarnings("serial")
public class QS001_50211_201504 extends QS001_50211_201504Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_50211_201504() {

        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���C�T�[�r�X�񋟐ӔC��", "5020101");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("���C�T�[�r�X�񋟐ӔC��", "5020101", "5020102");
    }

    // �R���|�[�l���g�C�x���g

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_50211_201504.class.getName(),
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
        // [ID:0000532][Masahiko.Higuchi] 2009/08 add begin 2009�N�x�Ή�
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
        // [ID:0000532][Masahiko.Higuchi] 2009/08 add end
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
        
		// �ی��҃R���{
		VRList insurerList = QkanCommon.getInsurerInfoCareOnly(getDBManager());
		// �ی��Ҕԍ��𑍍����Ɨp�̃o�C���h�p�X�փR�s�[
		ACBindUtilities.copyBindPath(insurerList, "INSURER_ID",
				String.valueOf(SJ_HOKENSHA_NO_BIND_PATH));
		VRBindPathParser.set("INSURER", comboItemMap, insurerList);
		
		// �p�^�[���P�`�T
		comboItemMap.setData("5020106", QkanCommon.getArrayFromMasterCode(290, "5020106"));		

		// ���W�J
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();
        
		// �ی��҃R���{�̏����l�ݒ�
		String insurerId = getInitialInsurerId();

		// �擾�����ی��Ҕԍ��ɊY������ی��҂����݂���ꍇ
		VRMap item = (VRMap) getInsurerName().getDataFromBindPath(insurerId);

		// �ی��Җ��R���{�̊Y���ی��҂�I����Ԃɂ���B
		getInsurerName().setSelectedItem(item);
        
        // �p�^�[��1��I����Ԃɂ���B
		getServicePattern().setSelectedIndex(0);
		
        // ���I�����ڂ̏����ݒ�
        // ������
        // �����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
        VRMap defaultMap = new VRHashMap();
        // ���ݒ�
        // ��ʂ̃��W�I�̏����l��ݒ肷��B�iselectFirstRadioItem�j
        QkanCommon.selectFirstRadioItem(getThis());
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();
        // ��ʏ�Ԑ���
        checkState();

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
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();
            // ���ݒ�

            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
        }

        checkState();

    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        // �ی��Җ��̃`�F�b�N
        // �EkaigoInfoInsurerName�i�ی��Җ��j
        // �I������Ă��邩�ǂ���
        if (!getInsurerName().isSelected()) {
            // �I������Ă��Ȃ��ꍇ
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT("�ی���");
            return null;
        }
        // �K��^�T�[�r�X��I������Ă��邩�`�F�b�N����
        if (!getVisitCareExpenseAddRadio().getSelectedButton().isEnabled()) {
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT("�K��^�T�[�r�X��");
            // null��Ԃ��B
            return null;
        }
        // �������R���{�`�F�b�N
        // �J�n�����R���{(houmonKaigoBeginTime)�ƏI�������R���{(houmonKaigoEndTime)�̂����ꂩ���󗓂������͕s���̏ꍇ
        if (!getHoumonKaigoBeginTime().isValidDate()
                || !getHoumonKaigoEndTime().isValidDate()) {
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
        return getHoumonKaigoBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getHoumonKaigoEndTime();
    }

    /**
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkState() throws Exception {
        // �v�x��1�ł��邩�`�F�b�N����B
        boolean isYosien1 = false;
        // ���p�҂̊Y�����̗v���F�藚�����擾����B
        VRList list = getCalculater().getPatientInsureInfoHistoryList();

        // ���𐔕����[�v����
        for (int i = 0; i < list.size(); i++) {
            VRMap map = (VRMap) list.getData(i);
            // �v�x��1�������̒��ɑ��݂��邩�`�F�b�N����B
            if (ACCastUtilities.toInt(VRBindPathParser.get("JOTAI_CODE", map)) == 12) {
                // ������ɗv�x��1�����݂����ꍇ
                isYosien1 = true;
            } else {
                // ������ɗv�x��1�ȊO�����݂����ꍇ
                isYosien1 = false;
                // ���[�v�𔲂���B
                break;
            }
        }
        // �v�x��1���������ꍇ
        if (isYosien1) {
            // �������`�F�b�N���Ă���ꍇ�i1�^�A2�^�̂݁j
            if (getCrackOnDayCheck().getValue() == 2) {
                setState_SHIEN1_DAY_CHECK_ON();
            } else {
                setState_SHIEN1_DAY_CHECK_OFF();
            }
        } else {
            // �������`�F�b�N���Ă���ꍇ�i1�^�A2�^�A3�^�̂݁j
            if (getCrackOnDayCheck().getValue() == 2) {
                setState_OTHER_SHIEN1_DAY_CHECK_ON();
            } else {
                setState_OTHER_SHIEN1_DAY_CHECK_OFF();
            }
        }

    }

    /**
     * �l�o�C���h�㏈��
     * 
     * @throws Exception ������O
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

        checkState();
    }

    /**
     * �����`�F�b�N���̏���
     * 
     * @throws Exception ������O
     */
    protected void crackOnDayCheckActionPerformed(ActionEvent e) throws Exception {
        
        checkState();

    }

}
