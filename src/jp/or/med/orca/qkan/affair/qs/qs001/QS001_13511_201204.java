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
 * �v���O���� �T�[�r�X�p�^�[�����\�h����{�ݓ����Ґ������ (QS001_13511_201204)
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
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[�����\�h����{�ݓ����Ґ������(QS001_13511_201204)
 */
@SuppressWarnings("serial")
public class QS001_13511_201204 extends QS001_13511_201204Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_13511_201204() {
        
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("�{�ݓ��̋敪", "1350101");
        
        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�l���z�u�敪", "1350102", "1350101");
        putImportProviderBindPath("�ʋ@�\�P���̐�", "1350104", "1350102");
        
        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�ʋ@�\�P���̐�", "1350104", "1350102");
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�敪�I���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void outsideServiceRadioActionPerformed(ActionEvent e)
            throws Exception {
        // �敪�I������
        // �@��ʏ�Ԑ���
        checkState();

    }

    /**
     * �u�{�݋敪�I���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void facilitiesDivisionRadioActionPerformed(ActionEvent e)
            throws Exception {
        // �{�݋敪�I������
        // �@��ʏ�Ԑ���
        checkState();

    }

    /**
     * �u�J�n�����I���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void specificFacilityBeginTimeActionPerformed(ActionEvent e)
            throws Exception {
        // �J�n�����I��
        // �@�I�����Ԑݒ�
        checkEndTime();

    }

    /**
     * �u�K��Ō쎞�ԋ敪�I���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void visitNursingComboActionPerformed(ActionEvent e)
            throws Exception {
        // �K��Ō쎞�ԋ敪�I��
        // �@�I�����Ԑݒ�
        checkEndTime();

    }

    /**
     * �u�K��Ō�{�݋敪�I���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void visitNursingFacilitiesDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // �K��Ō�{�݋敪�I��
        // �@��ʏ�Ԑ���
        checkState();

        // �@�R���{���ڍĐݒ�
        setComboItem();

    }

    /**
     * �u�K��Ō�E���敪�I���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void visitNursingStaffDivisionRadioActionPerformed(ActionEvent e)
            throws Exception {
        // �K��Ō�E���敪�I��
        // �@��ʏ�Ԑ���
        checkState();

        // �@�R���{���ڍĐݒ�
        setComboItem();

    }

    /**
     * �u�F�m�ǑΉ��ʏ����{�݋敪�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void providerDivisionRadioActionPerformed(ActionEvent e)
            throws Exception {
        // �F�m�ǑΉ��ʏ����{�݋敪�I��
        // �@��ʏ�Ԑ���
        checkState();

    }

    /**
     * �u�F�m�ǑΉ��^�ʏ���쎞�ԋ敪�I���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void timeDivisionRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // �F�m�ǑΉ��^�ʏ���쎞�ԋ敪�I��
        // �@�I�����Ԑݒ�
        checkEndTime();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_13511_201204.class.getName(),
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
                if (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0) == 13) {
                    setIsPrintCheckShow(true);
                    break;
                }
                break;
            case 13:
                // �v�x���Q�˗v�x���P
                if (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0) == 12) {
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
        // ���J�n����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        VRBindPathParser.set("3", comboItemMap,
                QkanCommon.getArrayFromMasterCode(23, "3"));
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
        VRBindPathParser.set("4", comboItemMap,
                QkanCommon.getArrayFromMasterCode(23, "4"));
        // ���K��Ō쎞�ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F207 �K��Ō�i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1330112 �� VALUE �Ƃ��Đݒ肷��B
        VRBindPathParser.set("1350109", comboItemMap,
                QkanCommon.getArrayFromMasterCode(207, "1350109"));
        // �������p��
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F47 �����p����擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1350119 �� VALUE �Ƃ��Đݒ肷��B
        VRBindPathParser.set("1350119", comboItemMap,
                QkanCommon.getArrayFromMasterCode(47, "1350119"));
        // ���W�J
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();

        // ���I�����ڂ̏����ݒ�
        // ������
        // �����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
        // VRMap defaultMap = new VRHashMap();
        // ���ݒ�
        // ��ʂ̃��W�I�̏����l��ݒ肷��B�iselectFirstRadioItem�j
        QkanCommon.selectFirstRadioItem(getThis());
        // �Ȃ���I����Ԃɂ���B
        getOutsideServiceRadioItem0().setSelected(true);
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        // getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        // getThis().bindSource();
        // ��ʏ�Ԃ�ύX����B
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
        // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B

        // ���ݒ�
        // providerInfoMap�� null ���`�F�b�N����B
        if (provider != null) {
            // null�ȊO�������ꍇ
            int valOnProvider;
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();

            // �E���̌����ɂ�錸�Z�̏󋵁i���Ə��p�l���jKEY�F1350103�̒l���`�F�b�N����B
            valOnProvider = ACCastUtilities.toInt(
                    VRBindPathParser.get("1350103", provider), 0);
            switch (valOnProvider) {
            case 1:
                // �l��1�i�Ȃ��j�������ꍇ
                // defaultMap�� KEY�F1350103 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1350103", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
                // �l��2����3�i�Ō�E���A���E���j�������ꍇ
                // defaultMap�� KEY�F1350103 VALUE�F2�i�Ō�E���E���������j��ݒ肷��B
                VRBindPathParser.set("1350103", defaultMap, new Integer(2));
                break;
            }
            
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            
        }

        // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
        // ��ʏ�Ԃ�ύX����B
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

        // �{�݋敪
        int valOfFacilityDivision = getFacilitiesDivisionRadio()
                .getSelectedIndex();
        // �O���T�[�r�X���
        int valOfOutsideService = getOutsideServiceRadio().getSelectedIndex();

        // ���ԋp�p���R�[�h����s�v�ȃL�[������
        // �J�n�����敪���L���ȏꍇ
        // �y�O���T�[�r�X�z�K��Ō�E�F�m�ǑΉ��^�ʏ���삪�I������Ă����ꍇ�i�l��3����8�̏ꍇ�ȊO�̓`�F�b�N���Ȃ��j
        if (getSpecificFacilityBeginTime().isEnabled()) {
            switch (valOfOutsideService) {
            case 3:
            case 8:
                if (ACTextUtilities.isNullText(getSpecificFacilityBeginTime()
                        .getText())
                        || ACTextUtilities
                                .isNullText(getSpecificFacilityEndTime()
                                        .getText())
                        || (!getSpecificFacilityBeginTime().isValidDate())
                        || (!getSpecificFacilityEndTime().isValidDate())) {
                    // �J�n�����R���{(specificFacilityBeginTime)���󗓂��s���̏ꍇ
                    // �������͏I�������R���{(specificFacilityEndTime)���󗓂��s���̏ꍇ
                    // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
                    // null��Ԃ��B
                    return null;
                }
                break;
            }
        }

        if (valOfFacilityDivision == 2) {
            // �O���T�[�r�X���p�ŖK��Ō삪�I������Ă��邩�`�F�b�N����B
            switch (valOfOutsideService) {
            case 3:
                // �K��Ō삪�I������Ă����ꍇ
                if (getVisitNursingCombo().isEnabled()) {
                    // �K��Ō� �����R���{���L���ȏꍇ
                    // �������I������Ă��邩���`�F�b�N����B
                    if (!getVisitNursingCombo().isSelected()) {
                        // �I������Ă��Ȃ������ꍇ
                        // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                        QkanMessageList.getInstance()
                                .QS001_ERROR_OF_NO_CONTENT();
                        // null��Ԃ��B
                        return null;
                    }
                }

                if (!getVisitNursingStaffDivisionRadio().getSelectedButton()
                        .isEnabled()) {
                    // �E���敪���`�F�b�N����B
                    // �E���敪��Enable��false�������ꍇ
                    // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // null��Ԃ��B
                    return null;
                }
                break;
            case 7:
                // �O���T�[�r�X���p�ŕ����p��I������Ă��邩�`�F�b�N����B
                // �����p��I������Ă����ꍇ
                if (!(getWelfareToolsCombo().isSelected())
                        || ACTextUtilities.isNullText(getWelfarePointText()
                                .getText())) {
                    // �p���ނ��I������Ă��Ȃ������ꍇ
                    // �P�ʐ������͂���Ă��Ȃ������ꍇ
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // null��Ԃ��B
                    return null;
                }
                break;
            }
        }
        // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
        QkanCommon.removeDisabledBindPath(getThis(), data);
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
        // �@true��Ԃ��B
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
        // �@�֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return getSpecificFacilityBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getSpecificFacilityEndTime();
    }

    /**
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void checkState() throws Exception {
        // ����ʏ�Ԑ���
        // ���T�[�r�X�A��
        // �{�ݓ��̋敪�i�T�[�r�X�p�l���j�̒l���`�F�b�N����B
        int valOfFacilityDivision = getFacilitiesDivisionRadio()
                .getSelectedIndex();
        switch (valOfFacilityDivision) {
        case 1:
            // �l��1�i����{�ݓ����Ґ����j�������ꍇ
            // ��ʂ̏�Ԃ��ʏ��1��ɕύX����B
            setState_STATE_MODE_1();
            break;
        case 2:
            // �l��2�i�O���T�[�r�X���p�j�������ꍇ
            // �O���T�[�r�X�ioutsideServiceRadio�j�̒l���`�F�b�N����B
            int valOfOutsideService = getOutsideServiceRadio()
                    .getSelectedIndex();
            switch (valOfOutsideService) {
            case 1:
                // �l��1�i�K����j�������ꍇ
                // ��ʂ̏�Ԃ��ʏ��2��ɕύX����B
                setState_STATE_MODE_2();
                break;
            case 2:
                // �l��2�i�K��������j�������ꍇ
                // ��ʂ̏�Ԃ��ʏ��3��ɕύX����B
                setState_STATE_MODE_3();
                break;
            case 3:
                // �l��3�i�K��Ō�j�������ꍇ
                // �{�ݓ��̋敪�ivisitNursingFacilitiesDivisionRadio�j�̒l���`�F�b�N����B
                int valOfVisitNursingFacilityDivision = getVisitNursingFacilitiesDivisionRadio()
                        .getSelectedIndex();
                switch (valOfVisitNursingFacilityDivision) {
                case 1:
                    // �l��1�i�K��Ō�X�e�[�V�����j�������ꍇ
                    // ��ʂ̏�Ԃ��ʏ��5��ɕύX����B
                    setState_STATE_MODE_5();
                    
                    //�E���敪���APT,ST�̏ꍇ
                    if (getVisitNursingStaffDivisionRadio().getSelectedIndex() == 2) {
                        // 2��ȏ�񋟂��g�p��
                        setState_VALID_TWO_OR_MORE_TIMES();
                    } else {
                        // 2��ȏ�񋟂��g�p�s��
                        setState_INVALID_TWO_OR_MORE_TIMES();
                    }
                    
                    break;
                case 2:
                    // �l��2�i�a�@���͐f�Ï��j�������ꍇ
                    // ��ʂ̏�Ԃ��ʏ��4��ɕύX����B
                    setState_STATE_MODE_4();
                    
                    // 2��ȏ�񋟂��g�p�s��
                    setState_INVALID_TWO_OR_MORE_TIMES();
                    break;
                }
                
                
                break;
            case 4:
                // �l��4�i�K�⃊�n�j�������ꍇ
                // ��ʂ̏�Ԃ��ʏ��6��ɕύX����B
                setState_STATE_MODE_6();
                break;
            case 5:
                // �l��5�i�ʏ����j�������ꍇ
                // ��ʂ̏�Ԃ��ʏ��7��ɕύX����B
                setState_STATE_MODE_7();
                break;
            case 6:
                // �l��6�i�ʏ����n�j�������ꍇ
                // ��ʂ̏�Ԃ��ʏ��8��ɕύX����B
                setState_STATE_MODE_8();
                break;
            case 7:
                // �l��7�i�����p��ݗ^�j�������ꍇ
                // ��ʂ̏�Ԃ��ʏ��9��ɕύX����B
                setState_STATE_MODE_9();
                break;
            case 8:
                // �l��8�i�F�m�ǑΉ��ʏ����j�������ꍇ
                // �{�ݓ��̋敪1�iproviderDivisionRadio�j�̒l���`�F�b�N����B
                int valOfProviderDivision = getProviderDivisionRadio()
                        .getSelectedIndex();
                switch (valOfProviderDivision) {
                case 1:
                    // �l��1�i�T�^�j�������ꍇ
                    // ��ʂ̏�Ԃ��ʏ��10��ɕύX����B
                    setState_STATE_MODE_10();
                    break;
                case 2:
                    // �l��2�i�U�^�j�������ꍇ
                    // ��ʂ̏�Ԃ��ʏ��11��ɕύX����B
                    setState_STATE_MODE_11();
                    break;
                }
                break;
            case 9:
                // �\�h���Ή� - 2006/06/05
                // �l��9�i�Ȃ��j��b�P�ʂ݂̂�Ԃ��ꍇ
                setState_STATE_MODE_3();
                break;
            }
            break;
        }

        checkOnDayCheckState();

        // ���Ə��̐��Ɠ���
        resetStateByRestrictBindPath();
    }

    /**
     * �u�I�����ԍĐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void checkEndTime() throws Exception {
        // ���I�����ԍĐݒ�
        // �����ԑѕύX���A�I�����Ԃ��ύX
        // �J�n���ԃR���{(houmonRehabilitationTimeContenaBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
        if (!(ACTextUtilities.isNullText(getSpecificFacilityBeginTime()
                .getText())) && getSpecificFacilityBeginTime().isValidDate()) {
            // �����ϐ� addTime �𐶐�����B
            int addTime = 0;
            // �O���T�[�r�X�ispecificFacilitySubtractionPersonLack�j�̒l���`�F�b�N����B
            switch (getOutsideServiceRadio().getSelectedIndex()) {
            case 3:
                // �l��3�i�K��Ō�j�������ꍇ
                if (getVisitNursingFacilitiesDivisionRadio().getSelectedIndex() == 1) {
                    if (getVisitNursingStaffDivisionRadio().getSelectedIndex() == 2) {
                        // �K��Ō�X�e�[�V�����łȂ�����PT�EOT�EST�������ꍇ
                        // ���ԑޔ�p�̕ϐ� addTime�ɁA���ԋ敪����擾�������Ԃ�ݒ肷��B
                        addTime = getHoumonKangoTimeSpecial();
                    } else {
                        // �K��Ō�X�e�[�V�����łȂ�����PT�EOT�EST�ȊO�������ꍇ
                        // ���ԑޔ�p�̕ϐ� addTime�ɁA���ԋ敪����擾�������Ԃ�ݒ肷��B
                        addTime = getHoumonKangoTime();
                    }
                } else {
                    // �a�@���͐f�Ï��������ꍇ
                    addTime = getHoumonKangoTime();
                }
                break;
            case 8:
                // �l��8�i�F�m�ǑΉ��^�ʏ����j�������ꍇ
                // ���ԑޔ�p�̕ϐ� addTime�ɁA���ԋ敪����擾�������Ԃ�ݒ肷��B
                addTime = getTuusyoKaigoTime();
                break;
            default:
                // �l����L�ȊO�̏ꍇ
                // �����𔲂��遦return
                return;
            }
            // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
            getSpecificFacilityEndTime().setDate(
                    ACDateUtilities.addMinute(getSpecificFacilityBeginTime()
                            .getDate(), addTime));
        }

    }

    /**
     * �u�K��Ō쎞�ԋ敪�l�擾�iPT�EOT�j�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public int getHoumonKangoTimeSpecial() throws Exception {
        // ���K��Ō쎞�ԋ敪�l�擾�iPT�EOT�j
        // �����ԋ敪(visitNursingCombo)�̎��Ԃ��擾
        // ���ԋ敪(visitNursingCombo)�̒l���`�F�b�N����B
        switch (getVisitNursingCombo().getSelectedIndex()) {
        case 0:
            // �l��0�i30�������j�̏ꍇ
            // �߂�l�Ƃ���30��Ԃ��B
            return 30;
        case 1:
            // �l��1�i1���Ԕ������j�̏ꍇ
            // �߂�l�Ƃ���90��Ԃ��B
            return 90;
        }
        // ��L�ɊY�����Ȃ��ꍇ
        // �߂�l�Ƃ���0��Ԃ��B
        return 0;
    }

    /**
     * �u�K��Ō쎞�ԋ敪�l�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public int getHoumonKangoTime() throws Exception {
        // ���K��Ō쎞�ԋ敪�l�擾
        // �����ԋ敪(VisitCareCombo)�̎��Ԃ��擾
        // ���ԋ敪(VisitCareCombo)�̒l���`�F�b�N����B
        switch (getVisitNursingCombo().getSelectedIndex()) {
        case 0:
            // �l��0�i0���ȏ�j�̏ꍇ
            // �߂�l�Ƃ���20��Ԃ��B
            return 20;
        case 1:
            // �l��1�i30���ȏ�j�̏ꍇ
            // �߂�l�Ƃ���30��Ԃ��B
            return 30;
        case 2:
            // �l��2�i1���Ԉȏ�j�̏ꍇ
            // �߂�l�Ƃ���60��Ԃ��B
            return 60;
        case 3:
            // �l��3�i1����30���ȏ�j�̏ꍇ
            // �߂�l�Ƃ���90��Ԃ��B
            return 90;
        }
        // ��L�ɊY�����Ȃ��ꍇ
        // �߂�l�Ƃ���0��Ԃ��B
        return 0;
    }

    /**
     * �u�F�m�ǑΉ��^�ʏ���쎞�ԋ敪�l�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public int getTuusyoKaigoTime() throws Exception {
        // ���F�m�ǑΉ��^�ʏ���쎞�ԋ敪�l�擾
        // �����ԋ敪(timeDivisionRadio)�̎��Ԃ��擾
        // ���ԋ敪(timeDivisionRadio)�̒l���`�F�b�N����B
        switch (getTimeDivisionRadio().getSelectedIndex()) {
        case 1:
            // �l��1�i3���Ԗ����j�̏ꍇ
            // �߂�l�Ƃ���180��Ԃ��B
            return 180;
        case 2:
            // �l��2�i4���Ԗ����j�̏ꍇ
            // �߂�l�Ƃ���240��Ԃ��B
            return 240;
        case 3:
            // �l��3�i6���Ԉȏ�j�̏ꍇ
            // �߂�l�Ƃ���360��Ԃ��B
            return 360;
        case 4:
            // �l��4�i8���Ԉȏ�j�̏ꍇ
            // �߂�l�Ƃ���480��Ԃ��B
            return 480;
        }
        // ��L�ɊY�����Ȃ��ꍇ
        // �߂�l�Ƃ���0��Ԃ��B
        return 0;
    }

    /**
     * �u�R���{���ڕύX�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void setComboItem() throws Exception {
        // ���R���{���ڕύX
        // �����ϐ� comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // �K��Ō�{�ݓ��̋敪�̒l���`�F�b�N����B
        switch (getVisitNursingFacilitiesDivisionRadio().getSelectedIndex()) {
        case 1:
            // �l��1�i�w��K��Ō�X�e�[�V�����j�������ꍇ
            // �E���敪�̒l���`�F�b�N����B
            switch (getVisitNursingStaffDivisionRadio().getSelectedIndex()) {
            case 1:
                // �l��1�i�Ȃ��j�������ꍇ
                // �R�[�h�}�X�^�f�[�^���CODE_ID�F207 �K��Ō�i���ԋ敪�j���擾����B
                // �擾�����l���AcomboItemMap�� KEY : 1350109 �� VALUE �Ƃ��Đݒ肷��B
                VRBindPathParser.set("1350109", comboItemMap,
                        QkanCommon.getArrayFromMasterCode(207, "1350109"));
                break;
            case 2:
                // �l��k2�iPT�EOT�EST�j�������ꍇ
                // �R�[�h�}�X�^�f�[�^���CODE_ID�F237 �K��Ō�i���ԋ敪�j���擾����B
                // �擾�����l���AcomboItemMap�� KEY : 1350109 �� VALUE �Ƃ��Đݒ肷��B
                VRBindPathParser.set("1350109", comboItemMap,
                        QkanCommon.getArrayFromMasterCode(237, "1350109"));
                break;
            }
            break;
        case 2:
            // �l��2�i�a�@���͐f�Ï��j�������ꍇ
            // �R�[�h�}�X�^�f�[�^���CODE_ID�F207 �K��Ō�i���ԋ敪�j���擾����B
            // �擾�����l���AcomboItemMap�� KEY : 1350109 �� VALUE �Ƃ��Đݒ肷��B
            VRBindPathParser.set("1350109", comboItemMap,
                    QkanCommon.getArrayFromMasterCode(207, "1350109"));
            break;
        }

        // ���W�J
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();

    }

    /**
     * �����`�F�b�N���̉�ʐ��䏈���ł��B
     * 
     * @throws Exception
     *             ������O
     */
    public void checkOnDayCheckState() throws Exception {
        if (getIsPrintCheckShow()) {
            // �K����
            if (getVisitCareCrackOnDayCheck().isEnabled()
                    && getVisitCareCrackOnDayCheck().getValue() == 2) {
                // �����`�F�b�N���L��̏ꍇ
                setState_DAY_CHECK_VISIT_CARE_ON();
            } else {
                // �����`�F�b�N�������̏ꍇ
                setState_DAY_CHECK_VISIT_CARE_OFF();
            }

            // �ʏ����
            if (getExpertPlaceNursingCrackOnDayChaeck().isEnabled()
                    && getExpertPlaceNursingCrackOnDayChaeck().getValue() == 2) {
                // �����`�F�b�N���L��̏ꍇ
                setState_DAY_CHECK_NURSING_ON();
            } else {
                // �����`�F�b�N�������̏ꍇ
                setState_DAY_CHECK_NURSING_OFF();
            }

            // �ʏ����n
            if (getExpertPlaceRehabiliCrackOnDay().isEnabled()
                    && getExpertPlaceRehabiliCrackOnDay().getValue() == 2) {
                // �����`�F�b�N���L��̏ꍇ
                setState_DAY_CHECK_REHABILI_ON();
            } else {
                // �����`�F�b�N�������̏ꍇ
                setState_DAY_CHECK_REHABILI_OFF();
            }
        } else {
            // �񋟓��͑S�Ė���
            setState_DAY_CHECK_VISIT_CARE_OFF();
            setState_DAY_CHECK_NURSING_OFF();
            setState_DAY_CHECK_REHABILI_OFF();
        }

    }

    /**
     * �f�[�^�o�C���h�㏈��
     * 
     * @throws Exception
     *             ������O
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
                if (getIsPrintCheckShow()
                        && !(source.containsKey("1350129")
                                || source.containsKey("1350130") || source
                                    .containsKey("1350131"))) {
                    // �\������Ă���ɂ��ւ�炸�AKEY���Ȃ��Ȃ�ΑI����Ԃɂ���
                    // �K����
                    if (getVisitCareCrackOnDayCheck().isSelected()) {
                        getVisitCarePrintable().setSelected(true);
                    }
                    // �ʏ����
                    if (getExpertPlaceNursingCrackOnDayChaeck().isSelected()) {
                        getExpertPlaceNursingPrintable().setSelected(true);
                    }
                    // �ʏ����n
                    if (getExpertPlaceRehabiliCrackOnDay().isSelected()) {
                        getExpertPlaceRehabiliPrintable().setSelected(true);
                    }

                }
            }
        }
        checkOnDayCheckState();

    }

    /**
     * �ʏ����E�����`�F�b�N���̏���
     * 
     * @throws Exception
     *             ������O
     */
    protected void expertPlaceNursingCrackOnDayChaeckActionPerformed(
            ActionEvent e) throws Exception {
        checkOnDayCheckState();

    }

    /**
     * �ʏ����n�E�����`�F�b�N���̏���
     * 
     * @throws Exception
     *             ������O
     */
    protected void expertPlaceRehabiliCrackOnDayActionPerformed(ActionEvent e)
            throws Exception {
        checkOnDayCheckState();

    }

    /**
     * �K����E�����`�F�b�N���̏���
     * 
     * @throws Exception
     *             ������O
     */
    protected void visitCareCrackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        checkOnDayCheckState();

    }

}
