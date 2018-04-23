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
 * �J����: 
 * �쐬��: 
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i����É@�j(QS001_204211_201804)
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
 * �T�[�r�X�p�^�[���Z�������×{���i����É@�j(QS001_204211_201804)
 */
@SuppressWarnings("serial")
public class QS001_204211_201804 extends QS001_204211_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_204211_201804() {
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�{�݋敪", "20420101", "20420101");
        putImportProviderBindPath("�l���z�u�敪�iI�^�j", "20420102", "20420102");
        putImportProviderBindPath("�l���z�u�敪�iII�^�j", "20420103", "20420103");
        putImportProviderBindPath("�l���z�u�敪�i���ʌ^�j", "20420104", "20420104");
        
        putImportProviderBindPath("���j�b�g�P�A�̐�", "20420107", "20420109");        
        putImportProviderBindPath("�×{����i�L���j", "20420108", "20420111");
        putImportProviderBindPath("�×{����i�×{���j", "20420109", "20420112");  
        
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "20420115", "20420122");
        
        


        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�×{�H", "20420112", "20420118");
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "20420110", "20420117");
        putRestrictProviderBindPath("���j�b�g�P�A�̐�", "20420107", "20420109");
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayHospitalRecuperationInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {

        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        // ��ʂ̏�Ԃ�ύX����B
        checkState();
    }

    /**
     * �u�H���񋟑I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayRecuperationHealthFacilityDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getShortStayRecuperationHealthFacilityDinnerOffer()
                .getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            setState_NOT_USE_MEAT();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            setState_USE_MEAT();
            // �H����p(shortStayRecuperationHealthFacilityDinnerCost)��ݒ肷��B
            getShortStayRecuperationHealthFacilityDinnerCost()
                    .setText(
                            getMeatCost(getShortStayRecuperationHealthFacilityDinnerOffer()
                                    .getSelectedIndex()));
        }

    }

    /**
     * �u���ʐf�Ô�ҏW�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayHospitalRecuperationSpecificConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {
        // �����ʐf�Ô�̕ҏW
        // ���ʐf�Ô�ҏW���(QS001S03_201804)�𐶐�����B
        // ���ʐf�Ô�{�^���̃f�[�^�������ɐ����������ʐf�Ô�ҏW���(QS001S03_201804)��shoModal�����s����B
        if (new QS001S03_201804().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getShortStayHospitalRecuperationSpecificConsultationFee()
                        .getDataModel())) {
            // ���ʐf�Ô��ύX�����ꍇ
            if (getShortStayHospitalRecuperationSpecificConsultationFee()
                    .getDataModel().isEmpty()) {
                // ���ʐf�Ô�{�^���̃f�[�^����̏ꍇ
                // ���ʐf�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
                getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                        .setText("�ݒ�Ȃ�");
            } else {
                // ���ʐf�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
                // ���ʐf�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
                getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                        .setText("�ݒ肠��");
            }
        }

    }

    
    /**
     * �u�l�����Z�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
	@Override
	protected void medicalFacilityHospitalSubstractionSelectionChanged(
			ListSelectionEvent e) throws Exception {
        // �l�����Z�̑I������
        checkState();
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
    
    /**
     * �u��ԋΖ�������I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
	@Override
	protected void shortStayHospitalRecuperationTypeSelectionChanged(
			ListSelectionEvent e) throws Exception {
        // ��Ԑ���
        checkState();
	}
	

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_12311_201804.class.getName(),
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
        getShortStayHospitalRecuperationSpecificConsultationFee()
                .clearDataModel();
        // (���ʐf�Ô�)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A���ʐf�Ô�{�^���ɐݒ肷��B
        getShortStayHospitalRecuperationSpecificConsultationFee()
                .setBindPathes(
                        QS001S03_201804
                                .getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1230150 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("20420123",
                QkanCommon.getArrayFromMasterCode(191, "20420123"));

        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F273�i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 20420108 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("20420108",
                QkanCommon.getArrayFromMasterCode(273, "20420108"));
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
        VRBindPathParser.set("20420123", defaultMap, new Integer(1));

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
            obj = VRBindPathParser.get("20420106", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("20420114", defaultMap, new Integer(1));
                    break;
                case 2: // ��t�������ꍇ
                case 3: // ��܎t�������ꍇ
                case 4: // �Ō�E���������ꍇ
                case 5: // ���E���������ꍇ
                    VRBindPathParser.set("20420114", defaultMap, new Integer(3));
                    break;
                }
            }

            // ��ԋΖ������
            obj = VRBindPathParser.get("20420105", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // ��^
                    VRBindPathParser.set("20420113", defaultMap, new Integer(1));
                    break;
                case 2: // ���Z�^I
                    VRBindPathParser.set("20420110", defaultMap, new Integer(2));
                    break;
                case 3: // ���Z�^II
                    VRBindPathParser.set("20420110", defaultMap, new Integer(3));
                    break;
                case 4: // ���Z�^III
                    VRBindPathParser.set("20420110", defaultMap, new Integer(4));
                    break;
                case 5: // ���Z�^IV
                    VRBindPathParser.set("20420110", defaultMap, new Integer(5));
                    break;
                case 6: // ���Z�^
                    VRBindPathParser.set("20420113", defaultMap, new Integer(2));
                    break;
                }
            }   
            

            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

            if (getShortStayRecuperationHealthFacilityDinnerOffer()
                    .getSelectedIndex() == 0) {
                // �H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getShortStayRecuperationHealthFacilityDinnerOffer()
                        .setSelectedIndex(1);
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
        if (getShortStayRecuperationHealthFacilityDinnerOffer()
                .getSelectedIndex() > 0) {
            // �H���񋟁ishortStayRecuperationHealthFacilityDinnerOffer)���u�Ȃ��v�ȊO��I�����Ă���ꍇ
            if (ACTextUtilities
                    .isNullText(getShortStayRecuperationHealthFacilityDinnerCost()
                            .getText())) {
                // �H����p(shortStayLifeDinnerCost)���󗓂̏ꍇ
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
        

        // �l�����Z�`�F�b�N
        if (!getMedicalFacilityHospitalSubstraction().getSelectedButton()
                .isEnabled()) {
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        
        if (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex() == 1
                || getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex() == 4) {
            // �l���z�u�敪�`�F�b�N
            if (!getStaffAssignment1Division().getSelectedButton()
                    .isEnabled()) {
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
        if (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex() == 2) {
            // �l���z�u�敪�`�F�b�N
            if (!getStaffAssignment2Division().getSelectedButton()
                    .isEnabled()) {
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
        if (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex() == 3
                || getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex() == 6) {
            // �l���z�u�敪�`�F�b�N
            if (!getStaffAssignment3Division().getSelectedButton()
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
                        VRBindPathParser.get("20420116", getSelectedProvider()),
                        0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("20420117", getSelectedProvider()),
                        0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("20420118", getSelectedProvider()),
                        0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("20420119", getSelectedProvider()),
                        0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("20420117", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("20420118",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("20420118", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("20420119",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("20420119", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("20420117",
                                getSelectedProvider()), 0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
    }

    public void binded() throws Exception {
        if (getShortStayHospitalRecuperationSpecificConsultationFee()
                .getDataModel().isEmpty()) {
            // ���ʐf�Ô�{�^���̃f�[�^����̏ꍇ
            // ���ʐf�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
            getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                    .setText("�ݒ�Ȃ�");
        } else {
            // ���ʐf�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
            // ���ʐf�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
            getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                    .setText("�ݒ肠��");
        }
    }

    /**
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * 
     */
    public void checkState() throws Exception {
        // ����ʏ�Ԑ��䏈��


        // ����Ŕ䗦��20%�����̏ꍇ�
        if (getMedicalFacilityHospitalSubstraction().getSelectedIndex() == 4) {
            // �����ɂ���
        	setPersonSubtractFlag(false);
        } else {
            // �L���ɂ���
        	setPersonSubtractFlag(true);
        }

        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // �uI�^�v�̏ꍇ
            setState_FACILITY_TYPE_NORMAL();
            break;
        case 2:
            // �uII�^�v�v�̏ꍇ
            setState_FACILITY_TYPE_NORMAL2();
            break;
        case 3:
            // �u���ʌ^�v�̏ꍇ
            setState_FACILITY_TYPE_SPECIAL();
            break;

        case 4:
        	// �u���j�b�g�^I�^�v�̏ꍇ
            setState_FACILITY_TYPE_UNIT();
            break;
        case 5:
        	// �u���j�b�g�^II�^�v�̏ꍇ
            setState_FACILITY_TYPE_UNIT2();
            break;
        case 6:
        	// �u���j�b�g�^���ʌ^�v�̏ꍇ
            setState_FACILITY_TYPE_UNIT_SPECIAL();
            break;
        case 7:
            // ����A��V���[�g�X�e�C��̏ꍇ
            setState_FACILITY_TYPE_SHORT_STAY();
            break;
        }
        
        // �l�����Z�ɂ��l���z�u�敪�̐���
        // �{�݋敪���`�F�b�N����
        switch (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {

        case 1:
        case 2:
        case 3:
        case 6:
        	// �uI�^�v�̏ꍇ
        	// �u���ʉ���É@�v�̏ꍇ
        	// �u���j�b�g�^���ʉ���É@�v�̏ꍇ
        	// �l�����Z�̒l���l������Ԃ�ύX����B
            if (getPersonSubtractFlag()) {
                setState_VALID_PERSON_SUBTRACTION();
            } else {
                setState_INVALID_PERSON_SUBTRACTION();
            }
            break;
        case 4:
            // �u���j�b�g�^I�^�v�̏ꍇ
            // �l�����Z�̒l���l������Ԃ�ύX����B
            if (!getPersonSubtractFlag()) {
                setState_INVALID_PERSON_SUBTRACTION_UNIT();
            }
            break;
        }
        

        // ���F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�Ǝ�N���F�m�Ǘ��p�Ҏ�����Z�̔r������
        if (getDementiaActionAddRadioGroup().getSelectedIndex() == 2) {
            // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z(dementiaActionAddRadioGroup)���u����v�̏ꍇ
            // ��N���F�m�Ǘ��p�Ҏ�����Z(youngDementiaPatinetAddRadioGroup)�𖳌��ɂ���B
            setState_INVALID_YOUNG_DEMENTIA_PATINET();
            // �ً}�Z������������Z(emergencyAcceptanceRadioGroup)�𖳌��ɂ���B
            setState_INVALID_EMERGENCY_ACCEPTANCE();
        } else {
            // ��L�ȊO�̏ꍇ
            // ��N���F�m�Ǘ��p�Ҏ�����Z(youngDementiaPatinetAddRadioGroup)��L���ɂ���B
            setState_VALID_YOUNG_DEMENTIA_PATINET();
            // �ً}�Z������������Z(emergencyAcceptanceRadioGroup)��L���ɂ���B
            setState_VALID_EMERGENCY_ACCEPTANCE();
        }
        
        // ��ԋΖ�������ɂ���ԋΖ����Ō���Z����
        if (getShortStayHospitalRecuperationTypeNone().isSelected()) {
            setState_INVALID_HOSPITAL_RECUPERATION();
        } else {
            setState_VALID_HOSPITAL_RECUPERATION();
        }


        resetStateByRestrictBindPath();
    }




}
