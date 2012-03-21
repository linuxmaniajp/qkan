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
 * �v���O���� �T�[�r�X�p�^�[���n�斧���^��앟���{�� (QS001_15411_201204)
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
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���n�斧���^��앟���{��(QS001_15411_201204)
 */
@SuppressWarnings("serial")
public class QS001_15411_201204 extends QS001_15411_201204Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_15411_201204() {

        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // ���Ə�����̒l�����p��
        putImportProviderBindPath("���j�b�g�P�A�̐���", "1540113", "1540105");
        putImportProviderBindPath("��ԋΖ����Z", "1540103", "1540107");
        putImportProviderBindPath("�ʋ@�\�P���w�����Z", "1540104", "1540108");
        putImportProviderBindPath("��t��Ή��Z", "1540105", "1540109");
        putImportProviderBindPath("�����j�b�g�P�A", "1540114", "1540106");
        putImportProviderBindPath("���_�Ȉ�w�����Z", "1540106", "1540110");
        putImportProviderBindPath("��Q�Ґ�����������Ή��Z", "1540107", "1540111");
        putImportProviderBindPath("�h�{�}�l�W�����g���Z", "1540135", "1540115");
        putImportProviderBindPath("���퐶���p���x�����Z", "1540128", "1540129");
        putImportProviderBindPath("��ΐE���z�u���Z", "1540130", "1540131");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1540134", "1540136");

        // ���Ə��̐ݒ�ɂ�薳���ɂ���
        putRestrictProviderBindPath("�ʋ@�\�P���w�����Z", "1540104", "1540108");
        putRestrictProviderBindPath("��t��Ή��Z", "1540105", "1540109");
        putRestrictProviderBindPath("���_�Ȉ�w�����Z", "1540106", "1540110");
        putRestrictProviderBindPath("��Q�Ґ�����������Ή��Z", "1540107", "1540111");
        putRestrictProviderBindPath("�h�{�}�l�W�����g���Z", "1540135", "1540115");
        putRestrictProviderBindPath("�×{�H���Z", "1540132", "1540118");
        putRestrictProviderBindPath("���K�͋��_�W���̐�", "1540127", "1540127");
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1540131", "1540132");
        putRestrictProviderBindPath("�Ō�̐����Z", "1540129", "1540137");
        putRestrictProviderBindPath("�Ō�̐����Z", "1540129", "1540138");
        putRestrictProviderBindPath("���j�b�g�P�A�̐���", "1540113", "1540105");
        putRestrictProviderBindPath("�F�m�ǐ��P�A���Z", "1540133", "1540135");
        putRestrictProviderBindPath("�Ŏ����̐�", "1540125", "1540134");
        putRestrictProviderBindPath("�ݑ�E�������ݗ��p���Z", "1540126", "1540126");

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

        checkState();
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
     * �u�o���ڍs���Z�̕ύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoWelfareFacilityOralSwitchRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // �o���ڍs���Z
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
        // �o���ێ����Z
        if (getKaigoWelfareFacilityJunOralSwitchRadioItem1().isSelected()) {
            setState_VALID_ORAL_SWITCH();
        } else {
            setState_INVALID_ORAL_SWITCH();
        }

    }

    /**
     * �u���[�u�����҃`�F�b�N�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoWelfareFacilityOldMeasuresPersonActionPerformed(
            ActionEvent e) throws Exception {
        checkState();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_15411_201204.class.getName(),
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
        // ���H����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1510120 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1510120",
                QkanCommon.getArrayFromMasterCode(191, "1540120"));
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
        // �H���񋟂́u�Ȃ��v��I������B
        defaultMap.setData("1540120", new Integer(1));

        // 2006/05/15 �\�h�Ή�(�v�]�j
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
        if (provider != null) {
            // �I�����Ə����null�łȂ��ꍇ
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();
            // ���ݒ�
            // ���[�u�����҂ł���ꍇ
            if (isOldFacilityUser()) {
                // �T�[�r�X�R�[�h��o�ߓI�`�F�b�N�͕K�{�̂��ߌł߂���Ń`�F�b�N��Ԃɂ���B
                setState_INVALID_PASSAGE_REGION();
                VRBindPathParser.set("1540102", defaultMap, new Integer(2));
            } else {
                setState_VALID_PASSAGE_REGION();
                // �o�ߓI�n�斧��
                VRBindPathParser.set("1540102", defaultMap,
                        VRBindPathParser.get("1540102", provider));
                // ���[�u�`�F�b�N���I����Ԃ������ꍇ
                if (getKaigoWelfareFacilityOldMeasuresPerson().isSelected()) {
                    setState_INVALID_PASSAGE_REGION();
                }
            }

            // �l�����Z
            Object obj;

            // �{�݋敪
            obj = VRBindPathParser.get("1540101", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: //
                case 2: //
                    VRBindPathParser.set("1540101", defaultMap, new Integer(1));
                    break;
                case 3: //
                case 4: //
                    VRBindPathParser.set("1540101", defaultMap, new Integer(2));
                    break;
                }
            }

            obj = VRBindPathParser.get("1540112", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1540119", defaultMap, new Integer(1));
                    break;
                case 2: // �Ō�E���������ꍇ
                case 3: // ���E���������ꍇ
                case 4: // ���x�������������ꍇ
                    VRBindPathParser.set("1540119", defaultMap, new Integer(3));
                    break;
                }
            }

            // �g�̍S�������{���Z
            obj = VRBindPathParser.get("1540116", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �g�̍S���p�~��g���Ȃ��ꍇ
                    VRBindPathParser.set("1540123", defaultMap, new Integer(2));
                    break;
                case 2: // �g�̍S���p�~��g������ꍇ
                    VRBindPathParser.set("1540123", defaultMap, new Integer(1));
                    break;
                }
            }

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

            if (getKaigoWelfareFacilityDinnerOffer().getSelectedIndex() == 0) {
                // �H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getKaigoWelfareFacilityDinnerOffer().setSelectedIndex(1);
            }

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
        if (!getKaigoWelfareFacilityInstitutionDivisionRadio().isSelected()) {
            // �{�݋敪�R���{(kaigoWelfareFacilityInstitutionDivisionRadio)�����I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }

        if ((getKaigoWelfareFacilityHospitalRoomDivisionRadio().isEnabled() && (!getKaigoWelfareFacilityHospitalRoomDivisionRadio()
                .isSelected()))
                || (getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio()
                        .isEnabled() && (!getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio()
                        .isSelected()))) {
            // �a���敪�i��앟���{�݁j(kaigoWelfareFacilityHospitalRoomDivisionRadio)���L���ł����I���̏ꍇ
            // �������͕a���敪�i���j�b�g�^��앟���{�݁j(kaigoWelfareFacilityUnitHospitalRoomDivisionRadio)���L���ł����I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if (getKaigoWelfareFacilityDinnerCost().isEnabled()
                && ACTextUtilities
                        .isNullText(getKaigoWelfareFacilityDinnerCost()
                                .getText())) {
            // �H����p(kaigoWelfareFacilityDinnerCost)���L���ł��󗓂̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
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
     * @throws Exception ������O
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
                        VRBindPathParser.get("1540117", getSelectedProvider()),
                        0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1540118", getSelectedProvider()),
                        0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1540119", getSelectedProvider()),
                        0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1540120", getSelectedProvider()),
                        0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1540118", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1540119",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1540119", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1540120",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1540120", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1540118",
                                getSelectedProvider()), 0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
    }

    /**
     * �u�f�[�^�o�C���h���̏����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void binded() throws Exception {
        // ���[�u�`�F�b�N���I����Ԃ������ꍇ
        if (getKaigoWelfareFacilityOldMeasuresPerson().isSelected()) {
            setState_INVALID_PASSAGE_REGION();
        } else {
            setState_VALID_PASSAGE_REGION();
        }

    }

    /**
     * �Ŏ��Ō���Z�I����
     */
    @Override
    protected void kaigoWelfareFacilityTakingCareNursingAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {

        checkState();
    }

    /**
     * �Z��敪�I����
     */
    @Override
    protected void kaigoWelfareFacilityCalculationDivisionRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {

        checkState();
    }

    // ��ʂ̏�Ԑ���
    private void checkState() throws Exception {

        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getKaigoWelfareFacilityInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // �u��앟���{�݁v�̏ꍇ
            // �u�a���敪�i��앟���{�݁j�v��L���ɂ��A�u�a���敪�i���j�b�g�^��앟���{�݁j�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            setState_VALID_SUB_UNIT_CARE();
            break;
        case 2:
            // �u���j�b�g�^��앟���{�݁v�̏ꍇ
            // �u�a���敪�i���j�b�g�^��앟���{�݁j�v�𖳌��ɂ��A�u�a���敪�i��앟���{�݁j�v��L���ɂ���B
            setState_UNIT_FORM();
            setState_INVALLID_SUB_UNIT_CARE();
            break;
        }

        // ���o�@�\�Ǘ��̐����Z������̏ꍇ
        if (getOralKeepStructureAddRadioGroup().getSelectedIndex() == 1) {
            setState_INVALID_ORAL_CARE();
        } else {
            setState_VALID_ORAL_CARE();
        }

        // ���[�u�����҂������ꍇ
        if (getKaigoWelfareFacilityOldMeasuresPerson().isSelected()) {
            // �o�ߓI�n�斧���^�T�[�r�X�̏�Ԃ��`�F�b�N����B
            if (getPassageRegionServiceCheck().isEnabled()) {
                // Enable��true�������ꍇ
                // ��ʂ̏�Ԃ�ύX����B
                setState_INVALID_PASSAGE_REGION();
            }
        } else {
            // ��ʂ̏�Ԃ�ύX����B
            setState_VALID_PASSAGE_REGION();
        }

        // �Z��敪�Łu2-���Z�̂݁v���I������Ă���
        // ���A�Ŏ������Z���u1-�Ȃ��v�ȊO�̏ꍇ
        if ((getKaigoWelfareFacilityCalculationDivisionRadio()
                .getSelectedIndex() == 2)
                && (getKaigoWelfareFacilityTakingCareNursingAddRadio()
                        .getSelectedIndex() != 1)) {

            // �Ŏ������Z�����P�ʗL��
            setState_VALID_TERMINAL();

        } else {
            // �Ŏ������Z�����P�ʖ���
            setState_INVALID_TERMINAL();

        }

        // ���Ə��̐��ɂ��L��/�������Đݒ�
        resetStateByRestrictBindPath();
    }

    @Override
    protected void oralKeepStructureAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ��ʏ�Ԑ���
        checkState();

    }

}
