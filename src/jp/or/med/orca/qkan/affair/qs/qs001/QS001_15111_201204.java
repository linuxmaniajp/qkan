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
 * �v���O���� �T�[�r�X�p�^�[�����V�l�����{�� (QS001_15111_201204)
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
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[�����V�l�����{��(QS001_15111_201204)
 */
@SuppressWarnings("serial")
public class QS001_15111_201204 extends QS001_15111_201204Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_15111_201204() {
        
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // ���Ə�����̒l�����p��
        putImportProviderBindPath("�{�݋敪", "1510101", "1510101");
        putImportProviderBindPath("��Α̐����Z", "1510102", "1510106");
        putImportProviderBindPath("��t��Ή��Z", "1510104", "1510108");
        putImportProviderBindPath("���_�Ȉ�w�����Z", "1510105", "1510109");
        putImportProviderBindPath("��Q�Ґ�����������Ή��Z", "1510106", "1510110");
        putImportProviderBindPath("�h�{�}�l�W�����g���Z", "1510134", "1510114");
        putImportProviderBindPath("�ʋ@�\�P���w�����Z", "1510103", "1510107");
        putImportProviderBindPath("���j�b�g�P�A�̐���", "1510121", "1510124");
        putImportProviderBindPath("���퐶���p���x�����Z", "1510127", "1510133");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1510133", "1510141");

        // ���Ə��̐ݒ�ɂ�薳���ɂ���
        putRestrictProviderBindPath("��t��Ή��Z", "1510104", "1510108");
        putRestrictProviderBindPath("���_�Ȉ�w�����Z", "1510105", "1510109");
        putRestrictProviderBindPath("��Q�Ґ�����������Ή��Z", "1510106", "1510110");
        putRestrictProviderBindPath("�h�{�}�l�W�����g���Z", "1510134", "1510114");
        putRestrictProviderBindPath("�×{�H���Z", "1510131", "1510116");
        putRestrictProviderBindPath("��ΐE���z�u���Z", "1510129", "1510135");
        putRestrictProviderBindPath("��N���F�m�Ǔ����Ҏ�����Z", "1510130", "1510137");
        putRestrictProviderBindPath("�ʋ@�\�P���w�����Z", "1510103", "1510107");
        putRestrictProviderBindPath("���j�b�g�P�A�̐���", "1510121", "1510124");
        putRestrictProviderBindPath("�Ō�̐����Z", "1510128", "1510142");
        putRestrictProviderBindPath("�Ō�̐����Z", "1510128", "1510143");
        putRestrictProviderBindPath("�F�m�ǐ��P�A���Z", "1510132", "1510140");

    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoWelfareFacilityInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        changeState();
    }

    /**
     * �u�H���񋟑I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoWelfareFacilityDinnerOfferActionPerformed(ActionEvent e)
            throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getKaigoWelfareFacilityDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            setState_NOT_USE_MEAT();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            setState_USE_MEAT();
            // �H����p(kaigoWelfareFacilityDinnerCost)��ݒ肷��B
            getKaigoWelfareFacilityDinnerCost().setText(
                    getMeatCost(getKaigoWelfareFacilityDinnerOffer()
                            .getSelectedIndex()));
        }

    }

    /**
     * �u�Ŏ����̗L����ԁv�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoWelfareFacilityTakingCareNursingAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ���Ŏ����̗L����Ԃ�ύX
        changeState();
    }

    /**
     * �u�o���ڍs���Z�̕ύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoWelfareFacilityOralSwitchRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // �o���ڍs���Z�̏�Ԃ���Ɍo���ێ����Z�̗L����Ԃ�ύX
        if (getKaigoWelfareFacilityOralSwitchRadioItem1().isSelected()) {
            setState_VALID_KEEP_NUTRITION();
        } else {
            setState_INVALID_KEEP_NUTRITION();
        }
    }

    /**
     * �u�o���ێ����Z�̕ύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoWelfareFacilityJunOralSwitchRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // �o���ێ����Z�̏�Ԃ���Ɍo���ێ����Z�̗L����Ԃ�ύX
        if (getKaigoWelfareFacilityJunOralSwitchRadioItem1().isSelected()) {
            setState_VALID_NUTRITION();
        } else {
            setState_INVALID_NUTRITION();
        }

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_15111_201204.class.getName(),
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
        // �H����
        comboItemMap.setData("1510121",
                QkanCommon.getArrayFromMasterCode(191, "1510121"));
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
        // �H����
        VRBindPathParser.set("1510121", defaultMap, new Integer(1));

        // ���[�u�����҃`�F�b�N�̒l��ݒ�
        if (isOldFacilityUser()) {
            VRBindPathParser.set("8", defaultMap, new Integer(2));
        } else {
            VRBindPathParser.set("8", defaultMap, new Integer(1));
        }

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
        setSelectedProvider(provider);
        // �I�����Ə����null�łȂ��ꍇ
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();
            // ���ݒ�
            Object obj;

            // �l�����Z
            obj = VRBindPathParser.get("1510112", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1510120", defaultMap, new Integer(1));
                    break;
                case 2: // �Ō�E���������ꍇ
                case 3: // ���E���������ꍇ
                case 4: // ���x�������̏ꍇ
                    VRBindPathParser.set("1510120", defaultMap, new Integer(3));
                    break;
                }
            }

            // �g�̍S�������{���Z
            obj = VRBindPathParser.get("1510124", provider);
            if (obj != null) {
                // �g�̍S�������{��g�݂Ȃ��������ꍇ
                if (ACCastUtilities.toInt(obj) == 1) {
                    VRBindPathParser.set("1510128", defaultMap, new Integer(2));
                } else if (ACCastUtilities.toInt(obj) == 2) {
                    // �g�̍S�������{��g�݂��肾�����ꍇ
                    VRBindPathParser.set("1510128", defaultMap, new Integer(1));
                }
            }

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

            if (getKaigoWelfareFacilityDinnerOffer().getSelectedIndex() == 0) {
                // �H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getKaigoWelfareFacilityDinnerOffer().setSelectedIndex(1);
            }

            // �Ō�̐��̕��Z��Ή�
            changeState();
        }

    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if (getKaigoWelfareFacilityTakingCareNursingAddDays().isEnabled()) {
            int days = ACCastUtilities
                    .toInt(getKaigoWelfareFacilityTakingCareNursingAddDays()
                            .getText(), 99);
            if ((days > 30) || (days < 1)) {
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
        // ���ԋp�p�̃��R�[�h(data)�𐶐�
        VRMap data = new VRHashMap();
        // �@���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
        getThis().setSource(data);
        // �@���g(this)��applySource���Ăяo���ăf�[�^�����W����B
        getThis().applySource();
        // ���ԋp�p���R�[�h����s�v�ȃL�[������
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
        return null;
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return null;
    }

    /**
     * �u�H����p���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param meatType int
     * @throws Exception ������O
     * @return String
     */
    public String getMeatCost(int meatType) throws Exception {
        // ���H�����������ƂɑI�����Ə��ɂ�����H����p��Ԃ��B
        if (getSelectedProvider() != null) {
            // ���Ə���I�����Ă���ꍇ
            switch (meatType) {
            case 1:
                // �H���������u������v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��A�u��v�̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1510113", getSelectedProvider()),
                        0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1510114", getSelectedProvider()),
                        0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1510115", getSelectedProvider()),
                        0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1510116", getSelectedProvider()),
                        0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1510114", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1510115",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1510115", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1510116",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1510116", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1510114",
                                getSelectedProvider()), 0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
    }

    /**
     * �Ō�̐����Z�T�I����
     */
    protected void nurseStructuralAddCheckItem1ActionPerformed(ActionEvent e)
            throws Exception {
        // ��ʏ�Ԑ���
        changeState();
    }

    /**
     * �Ō�̐����Z�U�I����
     */
    protected void nurseStructuralAddCheckItem2ActionPerformed(ActionEvent e)
            throws Exception {
        // ��ʏ�Ԑ���
        changeState();
    }

    /**
     * �f�[�^�o�C���h��̏��� [ID:0000468][Masahiko Higuchi] 2009/04 add begin �Ō�̐��̕��Z��Ή�
     */
    public void binded() throws Exception {
        // ��ʏ�Ԑ���
        changeState();
    }

    /**
     * ��ʏ�Ԑ�����s���܂��B
     */
    public void changeState() throws Exception {
        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getKaigoWelfareFacilityInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
        case 2:
            // �u��앟���{�݁v�������́u���K�͉�앟���{�݁v�̏ꍇ
            // �u�a���敪�i��앟���{�݁j�v��L���ɂ��A�u�a���敪�i���j�b�g�^��앟���{�݁j�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            // �����j�b�g�P�A�̐�
            setState_VALID_SUB_UNIT_CARE();
            break;
        case 3:
        case 4:
            // �u���j�b�g�^��앟���{�݁v�������́u���j�b�g�^���K�͉�앟���{�݁v�̏ꍇ
            // �u�a���敪�i���j�b�g�^��앟���{�݁j�v�𖳌��ɂ��A�u�a���敪�i��앟���{�݁j�v��L���ɂ���B
            setState_UNIT_FORM();
            // �����j�b�g�P�A�̐�
            setState_INVALLID_SUB_UNIT_CARE();
            break;
        }

        // �Z��敪���A���Z�̂ݎZ��ł���ꍇ
        if (getKaigoWelfareFacilityCalculationDivisionRadilo()
                .getSelectedIndex() == 2) {
            // �Ŏ������Z�̑I���󋵂ɂ�鐧��
            switch (getKaigoWelfareFacilityTakingCareNursingAddRadio()
                    .getSelectedIndex()) {
            case 1: // �Ȃ��I����
                setState_INVALID_TERMINAL();
                break;
            case 2:
            case 3:
            case 4:
                setState_VALID_TERMINAL();
                break;
            }
        } else {
            setState_INVALID_TERMINAL();
        }

        // ���o�@�\�ێ��Ǘ��̐����Z����̐���
        if (getOralKeepStructureAddRadioGroup().getSelectedIndex() == 1) {
            setState_INVALID_ORAL_CARE();
        } else {
            setState_VALID_ORAL_CARE();
        }

        resetStateByRestrictBindPath();
    }

    /**
     * �Z��敪�I���� �C�x���g
     */
    protected void kaigoWelfareFacilityCalculationDivisionRadiloSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ��ʏ�Ԃ𐧌䂷��B
        changeState();
    }

    @Override
    protected void oralKeepStructureAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        changeState();

    }
}
