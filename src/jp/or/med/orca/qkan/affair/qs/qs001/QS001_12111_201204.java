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
 * �v���O���� �T�[�r�X�p�^�[���Z������������� (QS001_12111_201204)
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
 * �T�[�r�X�p�^�[���Z�������������(QS001_12111_201204)
 */
@SuppressWarnings("serial")
public class QS001_12111_201204 extends QS001_12111_201204Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_12111_201204() {
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�{�݋敪", "1210101", "1210101");
        putImportProviderBindPath("�@�\�P���ɑ΂���̐����Z", "1210103", "1210106");
        putImportProviderBindPath("��ԋΖ������", "1210102", "1210105");
        putImportProviderBindPath("��ΐE���z�u���Z", "1210121", "1210121");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1210124", "1210123");
        putImportProviderBindPath("�ً}�Z�������̐��m�ۉ��Z", "1210126", "1210125");
        putImportProviderBindPath("���j�b�g�P�A�̐�", "1210116", "1210115");

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�@�\�P���ɑ΂���̐����Z", "1210103", "1210106");
        putRestrictProviderBindPath("�×{�H", "1210123", "1210109");
        putRestrictProviderBindPath("�ً}�Z�������̐��m�ۉ��Z", "1210126", "1210125");
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1210122", "1210122");
        putRestrictProviderBindPath("���j�b�g�P�A�̐�", "1210116", "1210115");
        putRestrictProviderBindPath("�Ō�̐����Z", "1210120", "1210119");
        putRestrictProviderBindPath("�Ō�̐����Z", "1210120", "1210120");
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayLifeTimeContenaFacilityDivisionActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        checkState();
    }

    /**
     * �u�H���񋟑I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayLifeDinnerOfferActionPerformed(ActionEvent e)
            throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getShortStayLifeDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            setState_NOT_USE_MEAT();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            setState_USE_MEAT();
            // �H����p(shortStayLifeDinnerCost)��ݒ肷��B
            getShortStayLifeDinnerCost().setText(
                    getMeatCost(getShortStayLifeDinnerOffer()
                            .getSelectedIndex()));
        }

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_12111_201204.class.getName(),
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
        // �擾�����l���AcomboItemMap�� KEY : 1210111 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1210111",
                QkanCommon.getArrayFromMasterCode(191, "1210111"));
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
        // ���H����
        // comboItemMap�� KEY : 1210111 �� VALUE �Ƃ���1��ݒ肷��B
        VRBindPathParser.set("1210111", defaultMap, new Integer(1));
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
            obj = VRBindPathParser.get("1210107", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1210110", defaultMap, new Integer(1));
                    break;
                case 2: // �Ō�E���������ꍇ
                case 3: // ���E���������ꍇ
                    VRBindPathParser.set("1210110", defaultMap, new Integer(3));
                    break;
                }
            }

            // ���}�̐�
            obj = VRBindPathParser.get("1210104", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    VRBindPathParser.set("6", defaultMap, new Integer(1));
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    VRBindPathParser.set("6", defaultMap, new Integer(3));
                    break;
                }
            }

            // [ID:0000471][Masahiko Higuchi] 2009/04 add begin �󏰌^�Ή�
            // �T�[�r�X�񋟑̐��������Z�i�P�ƌ^�j��D�悷�邽�ߒl���Ȃ��̏ꍇ�̂ݓK�p
            if (ACCastUtilities.toInt(obj, 0) == 1) {
                // 1210125 �T�[�r�X�񋟑̐��������Z(�󏰌^)
                obj = VRBindPathParser.get("1210125", provider);
                if (obj != null) {
                    VRBindPathParser.set("1210123", defaultMap, obj);
                }
            }
            // [ID:0000471][Masahiko Higuchi] 2009/04 add end

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

            if (getShortStayLifeDinnerOffer().getSelectedIndex() == 0) {
                // �H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getShortStayLifeDinnerOffer().setSelectedIndex(1);
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
        if (getShortStayLifeDinnerOffer().getSelectedIndex() > 0) {
            // �H���񋟁igetShortStayLifeDinnerOffer)���u�Ȃ��v�ȊO��I�����Ă���ꍇ
            if (ACTextUtilities.isNullText(getShortStayLifeDinnerCost()
                    .getText())) {
                // �H����p(getShortStayLifeDinnerCost)���󗓂̏ꍇ
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
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
                        VRBindPathParser.get("1210108", getSelectedProvider()),
                        0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1210109", getSelectedProvider()),
                        0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1210110", getSelectedProvider()),
                        0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1210111", getSelectedProvider()),
                        0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1210109", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1210110",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1210110", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1210111",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1210111", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1210109",
                                getSelectedProvider()), 0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
    }

    /**
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * 
     */
    public void checkState() throws Exception {
        // ����ʏ�Ԑ��䏈��
        // ���F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�Ǝ�N���F�m�Ǘ��p�Ҏ�����Z�̔r������
        if (getDementiaActionAddRadioGroup().getSelectedIndex() == 2) {
            // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z(dementiaActionAddRadioGroup)���u����v�̏ꍇ
            // ��N���F�m�Ǘ��p�Ҏ�����Z(youngDementiaPatinetAddRadioGroup)�𖳌��ɂ���B
            setState_INVALID_YOUNG_DEMENTIA_PATINET();
        } else {
            // ��L�ȊO�̏ꍇ
            // ��N���F�m�Ǘ��p�Ҏ�����Z(youngDementiaPatinetAddRadioGroup)��L���ɂ���B
            setState_VALID_YOUNG_DEMENTIA_PATINET();
        }
        if (getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() == 2) {
            // ��N���F�m�Ǘ��p�Ҏ�����Z(youngDementiaPatinetAddRadioGroup)���u����v�̏ꍇ
            // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z(dementiaActionAddRadioGroup)�𖳌��ɂ���B
            setState_INVALID_DEMENTIA_ACTION();
        } else {
            // ��L�ȊO�̏ꍇ
            // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z(dementiaActionAddRadioGroup)��L���ɂ���B
            setState_VALID_DEMENTIA_ACTION();
        }

        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getShortStayLifeTimeContenaFacilityDivision()
                .getSelectedIndex()) {
        case 1:
        case 2:
            // �u�P�ƌ^�v�������́u���݌^�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v��L���ɂ��A�u�a���敪(���j�b�g�^)�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            break;
        case 3:
        case 4:
            // �u�P�ƌ^���j�b�g�^�v�������́u���݌^���j�b�g�^�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v�𖳌��ɂ��A�u�a���敪(���j�b�g�^)�v��L���ɂ���B
            setState_UNIT_FORM();
        }

        // ��L�����ŗL���ɂȂ����R���g���[���ł��A���Ə��̐��Ő�����󂯂���̂͏㏑���Ő��䂷��B
        resetStateByRestrictBindPath();
    }

    /**
     * �u�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void dementiaActionAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ���F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�Ǝ�N���F�m�Ǘ��p�Ҏ�����Z�̔r������
        // ��ʂ̏�Ԃ�ύX����B
        checkState();
    }

    /**
     * �u��N���F�m�Ǘ��p�Ҏ�����Z�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void youngDementiaPatinetAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ���F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�Ǝ�N���F�m�Ǘ��p�Ҏ�����Z�̔r������
        // ��ʂ̏�Ԃ�ύX����B
        checkState();
    }
}
