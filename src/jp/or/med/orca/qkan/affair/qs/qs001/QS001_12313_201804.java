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
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i�F�m�ǎ����j (QS001_12313_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

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
 * �T�[�r�X�p�^�[���Z�������×{���i�F�m�ǎ����j(QS001_12313_201804)
 */
@SuppressWarnings("serial")
public class QS001_12313_201804 extends QS001_12313_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_12313_201804() {
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�{�݋敪", "1230301", "1230301");
        putImportProviderBindPath("�l���z�u�敪", "1230302", "1230302");
        putImportProviderBindPath("���j�b�g�P�A�̐�", "1230315", "1230309");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1230319", "1230351");

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�×{�H", "1230318", "1230307");
        putRestrictProviderBindPath("���j�b�g�P�A�̐�", "1230315", "1230309");
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayDementiaRecuperationInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {

        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        changeState();
    }

    /**
     * �u����f�Ô�̐ݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayDementiaRecuperationSpecificConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {

        // ������f�Ô�̕ҏW
        // ����f�Ô�ҏW���(QS001199_H2104)�𐶐�����B
        // ����f�Ô�{�^���̃f�[�^�������ɐ�����������f�Ô�ҏW���(QS001028)��shoModal�����s����B
        if (new QS001S01_201204().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getShortStayDementiaRecuperationSpecificConsultationFee()
                        .getDataModel())) {
            // ����f�Ô��ύX�����ꍇ
            if (getShortStayDementiaRecuperationSpecificConsultationFee()
                    .getDataModel().isEmpty()) {
                // ����f�Ô�{�^���̃f�[�^����̏ꍇ
                // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
                getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                        .setText("�ݒ�Ȃ�");
            } else {
                // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
                // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
                getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                        .setText("�ݒ肠��");
            }
        }

    }

    /**
     * �u�H���񋟑I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayDementiaRecuperationDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getShortStayDementiaRecuperationDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            setState_NOT_USE_MEAT();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            setState_USE_MEAT();
            // �H����p(shortStayDementiaRecuperationDinnerCost)��ݒ肷��B
            getShortStayDementiaRecuperationDinnerCost().setText(
                    getMeatCost(getShortStayDementiaRecuperationDinnerOffer()
                            .getSelectedIndex()));
        }

    }

    /**
     * �u�a���敪�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayDementiaRecuperationHospitalDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // �a���敪�I���C�x���g
        changeState();
    }

    /**
     * �u�l�����Z�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayDementiaRecuperationPersonSubtractionActionPerformed(
            ActionEvent e) throws Exception {
        // �l�����Z�敪�u�Ō�E���E���������̏ꍇ�v�u���Ŕ䗦��20%�����̏ꍇ�v�u�ƒn�͏o���v��I�������ꍇ
        if (getShortStayDementiaRecuperationPersonSubtraction()
                .getSelectedIndex() == 2
                || getShortStayDementiaRecuperationPersonSubtraction()
                        .getSelectedIndex() == 3
                || getShortStayDementiaRecuperationPersonSubtraction()
                        .getSelectedIndex() == 5) {
            // ��ʏ��ύX����B
            setState_INVALID_STAFF_ASSIGNMENT();
            // �ݒ肠��ɐݒ�
            setStaffAssignmentFlag(true);
        } else {
            setState_VALID_STAFF_ASSIGNMENT();
            // �ݒ�Ȃ��ɐݒ�
            setStaffAssignmentFlag(false);
        }

        changeState();
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_12313_201804.class.getName(),
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
        getShortStayDementiaRecuperationSpecificConsultationFee()
                .clearDataModel();
        // QS001199_H2104(����f�Ô�)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A����f�Ô�{�^���ɐݒ肷��B
        getShortStayDementiaRecuperationSpecificConsultationFee()
                .setBindPathes(
                        QS001S01_201204
                                .getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
        // ���H����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1230347 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1230347",
                QkanCommon.getArrayFromMasterCode(191, "1230347"));
        // ���l�����Z
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F77�i�l�����Z�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1230346 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1230346",
                QkanCommon.getArrayFromMasterCode(66, "1230346"));
        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F273�i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1230352 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1230352",
                QkanCommon.getArrayFromMasterCode(273, "1230352"));
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
        VRBindPathParser.set("1230347", defaultMap, new Integer(1));
        // �l�����Z
        VRBindPathParser.set("1230346", defaultMap, new Integer(1));
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
        setSelectedProvider(provider);

        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();
            // ���ݒ�
            Object obj;

            // �l�����Z
            obj = VRBindPathParser.get("1230306", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                case 2: // ��t�������ꍇ
                    VRBindPathParser.set("1230346", defaultMap, new Integer(1));
                    break;
                case 3: // �Ō�E���������ꍇ
                case 4: // ���E���������ꍇ
                    VRBindPathParser.set("1230346", defaultMap, new Integer(3));
                    break;
                }
            }

            // 2015/03/02 [H27.4�����Ή�][Shinobu Hitaka] edit - begin �̐��������Ă��Ȃ���I������B
            VRBindPathParser.set("6", defaultMap, new Integer(1));
            // ���}
            //obj = VRBindPathParser.get("1230303", provider);
            //if (obj != null) {
            //    switch (ACCastUtilities.toInt(obj)) {
            //    case 2:
            //        // �u����v�̏ꍇ
            //        // ���}�敪(shortStayDementiaRecuperationMeetingAndSendingOff)��3�Ԗڂ̃{�^����I���ɂ���B
            //        defaultMap.setData("6", new Integer(3));
            //        break;
            //    case 1:
            //        // �u�Ȃ��v�̏ꍇ
            //        // ���}�敪(shortStayDementiaRecuperationMeetingAndSendingOff)��1�Ԗڂ̃{�^����I���ɂ���B
            //        defaultMap.setData("6", new Integer(1));
            //        break;
            //    }
            //}
            // 2015/03/02 [H27.4�����Ή�][Shinobu Hitaka] edit - end
            
            // �{�݋敪���F�m�ǎ����^�̏ꍇ�́A�a�@�敪��ݒ�
            if (ACCastUtilities.toInt(VRBindPathParser.get("1230301", provider), 0) == 1) {
                switch (ACCastUtilities.toInt(VRBindPathParser.get("1230302", provider), 0)) {
                case 1: // I�^
                    // �a�@�敪���u��w�a�@�v��
                    defaultMap.setData("1230308", new Integer(1));
                    break;
                case 2: // II�^
                case 3: // III�^
                case 4: // IV�^
                case 5: // V�^
                    // �a�@�敪���u��ʕa�@�v��
                    defaultMap.setData("1230308", new Integer(2));
                    break;
                }
            }
            

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

            if (getShortStayDementiaRecuperationDinnerOffer()
                    .getSelectedIndex() == 0) {
                // �H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getShortStayDementiaRecuperationDinnerOffer().setSelectedIndex(
                        1);
            }

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
        if (getShortStayDementiaRecuperationDinnerOffer().getSelectedIndex() > 0) {
            // �H���񋟁ishortStayDementiaRecuperationDinnerOffer)���u�Ȃ��v�ȊO��I�����Ă���ꍇ
            if (ACTextUtilities
                    .isNullText(getShortStayDementiaRecuperationDinnerCost()
                            .getText())) {
                // �H����p(shortStayDementiaRecuperationDinnerCost)���󗓂̏ꍇ
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
        // �l���z�u�敪���L���ł���ꍇ
        if (getShortStayDementiaRecuperationDivision().isEnabled()) {
            // ���ݑI�𒆂̃{�^���������ł������ꍇ
            if (!getShortStayDementiaRecuperationDivision().getSelectedButton()
                    .isEnabled()) {
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
        if (getTankinyusyoTimeDivision().isEnabled()) {
            // ���ԋ敪�itankinyusyoTimeDivision)���L���ȏꍇ(�V���[�g�X�e�C)
            if (getTankinyusyoTimeDivision().getSelectedIndex() < 0) {
                // ���ԋ敪�itankinyusyoTimeDivision)�����I���̏ꍇ
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
                        VRBindPathParser.get("1230307", getSelectedProvider()),
                        0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1230308", getSelectedProvider()),
                        0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1230309", getSelectedProvider()),
                        0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1230310", getSelectedProvider()),
                        0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1230308", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230309",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1230309", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230310",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1230310", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230308",
                                getSelectedProvider()), 0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
    }

    /**
     * �l���z�u�敪�Ɋւ��鐧����s���܂��B
     */
    public void changeState() throws Exception {
        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getShortStayDementiaRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // �u�F�m�ǎ����^�v�̏ꍇ
            setState_CONVENTIONAL_FORM();
            // �l�����Z���ݒ�ς݂������ꍇ
            if (getStaffAssignmentFlag()) {
                setState_INVALID_STAFF_ASSIGNMENT();
            }
            // ���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
            setState_SHORT_STAY_UNSELECT();
            break;
        case 2:
            // ����j�b�g�^�F�m�ǎ����^��̏ꍇ
            setState_UNIT_FORM();
            // ���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
            setState_SHORT_STAY_UNSELECT();
            break;
        case 3:
            // �u�o�ߌ^�v�̏ꍇ
            setState_PASSAGE_FORM();
            // ���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
            setState_SHORT_STAY_UNSELECT();
            break;
        case 4:
            // ����A��V���[�g�X�e�C�
            setState_SELECT_SHORT_STAY();
            // ���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
            setState_SHORT_STAY_SELECT();
            break;
        }

        // �{�݋敪 �F�m�ǎ����^���I������Ă����ꍇ
        if (getShortStayDementiaRecuperationInstitutionDivisionRadioItem1()
                .isSelected()) {
            // �l���z�u�敪��L���ɂ���B
            setState_VALID_STAFF();
            // ��w�a�@���I������Ă����ꍇ
            // �T�^��\����Ԃɂ���B
            if (getShortStayDementiaRecuperationHospitalDivisionRadioItem1()
                    .isSelected()) {
                setState_SELECT_HOSPITAL();
            } else {
                // �a�@���I������Ă����ꍇ
                // �l�����Z�敪�u�Ō�E���E���������̏ꍇ�v�u���Ŕ䗦��20%�����̏ꍇ�v�u�ƒn�͏o���v���I������Ă��邩�`�F�b�N����B
                if (getStaffAssignmentFlag()) {
                    // �W�E�X�^��I���\�ɂ���B
                    setState_UNSELECT_HOSPITAL();
                } else {
                    // �T�^�ȊO��I���\�ɂ���B
                    setState_INVALID_STAFF_DIVISION1();
                }
            }
        } else {
            // �l���z�u�敪�𖳌��ɂ���B
            setState_INVALID_STAFF();
        }

        resetStateByRestrictBindPath();
    }

    public void binded() throws Exception {
        if (getShortStayDementiaRecuperationSpecificConsultationFee()
                .getDataModel().isEmpty()) {
            // ����f�Ô�{�^���̃f�[�^����̏ꍇ
            // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
            getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                    .setText("�ݒ�Ȃ�");
        } else {
            // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
            // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
            getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                    .setText("�ݒ肠��");
        }
    }

}
