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
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�a�@�j (QS001_15311_201804)
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
 * �T�[�r�X�p�^�[������É@(QS001_15511_201804)
 */
@SuppressWarnings("serial")
public class QS001_15511_201804 extends QS001_15511_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_15511_201804() {
        
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");
        
        // ���Ə�����̒l�����p��       
        putImportProviderBindPath("�{�݋敪", "1550101", "1550101");
        
        putImportProviderBindPath("�l���z�u�敪�iI�^�j", "1550102", "1550102");
        putImportProviderBindPath("�l���z�u�敪�iII�^�j", "1550103", "1550103");
        putImportProviderBindPath("�l���z�u�敪�i���ʌ^�j", "1550104", "1550104");
        
        putImportProviderBindPath("���j�b�g�P�A�̐���", "1550107", "1550108");
        putImportProviderBindPath("�×{����i�L���j", "1550109", "1550110");
        putImportProviderBindPath("�×{����i�×{���j", "1550110", "1550111");      
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1550117", "1550135");
        putImportProviderBindPath("�h�{�}�l�W�����g���Z", "1550112", "1550119");
        
        
        // ���Ə��̐ݒ�ɂ�薳���ɂ���
        putRestrictProviderBindPath("��N���F�m�Ǔ����Ҏ�����Z", "1550111", "1550113");
        putRestrictProviderBindPath("�h�{�}�l�W�����g���Z", "1550112", "1550119");
        putRestrictProviderBindPath("�×{�H���Z", "1550113", "1550126");
        putRestrictProviderBindPath("�F�m�ǐ��P�A���Z", "1550114", "1550130");
        putRestrictProviderBindPath("���j�b�g�P�A�̐���", "1550107", "1550108");

    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void medicalFacilityHospitalInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getMedicalFacilityHospitalInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // �uI�^�v�̏ꍇ
            setState_CONVENTIONAL_FORM();
            break;
        case 2:
            // �uII�^�v�v�̏ꍇ
            setState_CONVENTIONAL_FORM2();
            break;
        case 3:
            // �u���ʌ^�v�̏ꍇ
            setState_SPECIAL_FORM();
            break;

        case 4:
        	// �u���j�b�g�^I�^�v�̏ꍇ
            setState_UNIT_FORM();
            break;
        case 5:
        	// �u���j�b�g�^II�^�v�̏ꍇ
            setState_UNIT_FORM2();
            break;
        case 6:
        	// �u���j�b�g�^���ʌ^�v�̏ꍇ
            setState_UNIT_SPECIAL_FORM();
            break;
        }
        // �l���z�u�敪�𐧌䂷��
        changeStaffDivisionState();

        // ��ʂ̏�Ԑ���
        checkState();
    }
    
    /**
     * �u�l�����Z���W�I�{�^���I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
	@Override
	protected void medicalFacilityHospitalSubstractionSelectionChanged(ListSelectionEvent e) throws Exception {
        // �l�����Z�I��
        // ����Ŕ䗦��20%�����̏ꍇ�
        if (getMedicalFacilityHospitalSubstraction().getSelectedIndex() == 4) {
            // �����ɂ���
            setPersonSubstraction(false);
        } else {
            // �L���ɂ���
            setPersonSubstraction(true);
        }
        // �l���z�u�敪�𐧌䂷��
        changeStaffDivisionState();
		
	}

    /**
     * �u���ʐf�Ô�̐ݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void medicalFacilityHospitalConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {
        // �����ʐf�Ô�̕ҏW
        // ���ʐf�Ô�ҏW���(QS001S03_201804)�𐶐�����B
        // ���ʐf�Ô�{�^���̃f�[�^�������ɐ����������ʐf�Ô�ҏW���(QS001S03_201804)��shoModal�����s����B
        if (new QS001S03_201804().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getMedicalFacilityHospitalConsultationFee().getDataModel())) {
            // ���ʐf�Ô��ύX�����ꍇ
            if (getMedicalFacilityHospitalConsultationFee().getDataModel()
                    .isEmpty()) {
                // ���ʐf�Ô�{�^���̃f�[�^����̏ꍇ
                // ���ʐf�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
                getMedicalFacilityHospitalConsultationFeeLabel()
                        .setText("�ݒ�Ȃ�");
            } else {
                // ���ʐf�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
                // ���ʐf�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
                getMedicalFacilityHospitalConsultationFeeLabel()
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
    protected void medicalFacilityDinnerOfferActionPerformed(ActionEvent e)
            throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getMedicalFacilityDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            setState_NOT_USE_MEAT();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            setState_USE_MEAT();
            // �H����p(medicalFacilityDinnerCost)��ݒ肷��B
            getMedicalFacilityDinnerCost().setText(
                    getMeatCost(getMedicalFacilityDinnerOffer()
                            .getSelectedIndex()));
        }

    }
    
    /**
     * �u�h�{�}�l�W�����g���Z�̕ύX�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void medicalFacilityHospitalNutritionRadioSelectionChanged(
    		ListSelectionEvent e) throws Exception {
    	checkState();
    }

    /**
     * �u�o���ڍs���Z�̕ύX�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void medicalFacilityHospitalOralSwitchRadioSelectionChanged(
    		ListSelectionEvent e) throws Exception {
    	checkState();
    }

    /**
     * �u�o���ێ����Z�ɔ�����ʏ�Ԑݒ�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void oralMaintenanceAddSelectionChanged(ListSelectionEvent e) 
    		throws Exception {
    	checkState();
    }

    /**
     * �u���Ȏ�M�̗L���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void medicalFacilityHospitalMedicalExaminationRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {

        // ��ʐ���
        checkState();
    }

    /**
     * �u�O�����Z�̗L���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void medicalFacilityHospitalStayRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {

        // ��ʐ���
        checkState();
    }

    /**
     * �u���s�I�މ@�T�[�r�X��̗L���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void trialHijoRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {

        // ��ʐ���
        checkState();
    }

    /**
     * �u�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�I���v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void dementiaEmergencyAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception{
    	checkState();

    }

    /**
     * �u��N���F�m�Ǘ��p�Ҏ�����Z�I���v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void youngDementiaPatinetAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception{
    	checkState();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_15311_201804.class.getName(),
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
        getMedicalFacilityHospitalConsultationFee().clearDataModel();
        // (���ʐf�Ô�)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A���ʐf�Ô�{�^���ɐݒ肷��B
        getMedicalFacilityHospitalConsultationFee()
                .setBindPathes(
                		QS001S03_201804
                                .getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
        // �H����
        comboItemMap.setData("1550136",
                QkanCommon.getArrayFromMasterCode(191, "1550136"));

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
        VRBindPathParser.set("1550136", defaultMap, new Integer(1));

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

            // �g�̍S�������{���Z
            obj = VRBindPathParser.get("1550108", provider);
            if (obj != null) {
                // �g�̍S�������{��g�݂Ȃ��������ꍇ
                if (ACCastUtilities.toInt(obj) == 1) {
                    defaultMap.setData("1550109", new Integer(2));
                } else if (ACCastUtilities.toInt(obj) == 2) {
                    // �g�̍S�������{��g�݂��肾�����ꍇ
                    defaultMap.setData("1550109", new Integer(1));
                }
            }

            // �l�����Z
            obj = VRBindPathParser.get("1550106", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1550128", defaultMap, new Integer(1));
                    break;
                case 2: // ��t�������ꍇ
                case 3: // ��܎t�������ꍇ
                case 4: // �Ō�E���������ꍇ
                case 5: // ���E���������ꍇ
                    VRBindPathParser.set("1550128", defaultMap, new Integer(3));
                    break;
                }
            }
            
            // ��ԋΖ������
            obj = VRBindPathParser.get("1550105", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // ��^
                    VRBindPathParser.set("1550107", defaultMap, new Integer(1));
                    break;
                case 2: // ���Z�^I
                    VRBindPathParser.set("1550112", defaultMap, new Integer(2));
                    break;
                case 3: // ���Z�^II
                    VRBindPathParser.set("1550112", defaultMap, new Integer(3));
                    break;
                case 4: // ���Z�^III
                    VRBindPathParser.set("1550112", defaultMap, new Integer(4));
                    break;
                case 5: // ���Z�^IV
                    VRBindPathParser.set("1550112", defaultMap, new Integer(5));
                    break;
                case 6: // ���Z�^
                    VRBindPathParser.set("1550107", defaultMap, new Integer(2));
                    break;
                }
            }            

            // ��N���F�m�Ǘ��p�Ҏ�����Z���Ȃ��ɐݒ肷��B
            VRBindPathParser.set("1550113", defaultMap, new Integer(1));

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

            if (getMedicalFacilityDinnerOffer().getSelectedIndex() == 0) {
                // �H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getMedicalFacilityDinnerOffer().setSelectedIndex(1);
            }

            // ��Ԑ���
            medicalFacilityHospitalInstitutionDivisionRadioActionPerformed(null);
        }
    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        // �l���z�u�敪���L���łȂ����I�����ڂ������ł���ꍇ
        if (getMedicalFacilityHospitalInstitutionDivisionRadio()
                .getSelectedIndex() == 1
                || getMedicalFacilityHospitalInstitutionDivisionRadio()
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
        if (getMedicalFacilityHospitalInstitutionDivisionRadio()
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
        if (getMedicalFacilityHospitalInstitutionDivisionRadio()
                .getSelectedIndex() == 3
                || getMedicalFacilityHospitalInstitutionDivisionRadio()
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
                        VRBindPathParser.get("1550118", getSelectedProvider()),
                        0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1550119", getSelectedProvider()),
                        0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1550120", getSelectedProvider()),
                        0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1550121", getSelectedProvider()),
                        0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1550119", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1550120",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1550120", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1550121",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1550121", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1550119",
                                getSelectedProvider()), 0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
    }

    /**
     * �l���z�u�̐��䏈��
     */
    public void changeStaffDivisionState() throws Exception {
    	

        
        // �{�݋敪���`�F�b�N����
        switch (getMedicalFacilityHospitalInstitutionDivisionRadio()
                .getSelectedIndex()) {

        case 1:
        case 2:
        case 3:
        case 6:
        	// �uI�^�v�̏ꍇ
        	// �u���ʉ���É@�v�̏ꍇ
        	// �u���j�b�g�^���ʉ���É@�v�̏ꍇ
        	// �l�����Z�̒l���l������Ԃ�ύX����B
            if (getPersonSubstraction()) {
                setState_VALID_SUBTRACTION();
            } else {
                setState_INVALID_SUBTRACTION();
            }
            break;
        case 4:
            // �u���j�b�g�^I�^�v�̏ꍇ
            // �l�����Z�̒l���l������Ԃ�ύX����B
            if (!getPersonSubstraction()) {
                setState_INVALID_SUBTRACTION_UNIT_ENABLE();
            }
            break;
        }

        // ���Ə��̐��ɂ��L��/������Ԃ̍Đݒ�
        resetStateByRestrictBindPath();
    }

    public void binded() throws Exception {
        if (getMedicalFacilityHospitalConsultationFee().getDataModel()
                .isEmpty()) {
            // ���ʐf�Ô�{�^���̃f�[�^����̏ꍇ
            // ���ʐf�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
            getMedicalFacilityHospitalConsultationFeeLabel().setText("�ݒ�Ȃ�");
        } else {
            // ���ʐf�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
            // ���ʐf�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
            getMedicalFacilityHospitalConsultationFeeLabel().setText("�ݒ肠��");
        }

    }

    @Override
    public void checkState() throws Exception {

        // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - begin
        // �u���ʌ^�v�A�u���ʉ���É@�v�Ŗ����ƂȂ��Ă��鍀�ڂ�����ΗL���ɂ��Ă���
        setState_VALID_SPECIAL();
        // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - end
    	
        // ���o�@�\�Ǘ��̐����Z�̐���
        if (getOralKeepStructureAddRadioGroup().getSelectedIndex() == 1) {
            setState_INVALID_ORAL_CARE();
        } else {
            setState_VALID_ORAL_CARE();
        }
        
        // �h�{�}�l�W�����g���Z�̏�Ԃ���Ɍo���ڍs���Z�A�o���ێ����Z�̗L����Ԃ�ύX
        if (getMedicalFacilityHospitalNutritionRadioItem2().isSelected()) {
            // �o���ڍs���Z�̏�Ԃ����ɐ���
            if (getMedicalFacilityHospitalOralSwitchRadioItem2().isSelected()) {
                setState_INVALID_KEEP_NUTRITION();
            } else {
                setState_VALID_KEEP_NUTRITION();
            }
            
            // �o���ێ����Z�̏�Ԃ����ɐ���
            if (getOralMaintenanceAddItem2().isSelected()) {
                setState_INVALID_NUTRITION();
            } else {
                setState_VALID_NUTRITION();
            }
            
            // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - begin
            // ��h�{���X�N���P���Z
            // �h�{�}�l�W�����g���Z���Z�肵�Ă���A���o���ڍs���Z�y�ьo���ێ����Z���Z�肵�Ă��Ȃ�
            if (getMedicalFacilityHospitalOralSwitchRadioItem1().isSelected()
            		&& getOralMaintenanceAddItem1().isSelected()) {
            	// ��h�{���X�N���P���Z��L��
            	setState_VALID_LOW_NUTRITIONAL();
            } else {
            	// ��h�{���X�N���P���Z�𖳌�
            	setState_INVALID_LOW_NUTRITIONAL();
            }
            
            // �h�{�}�l�W�����g���Z���Z�肵�Ă���ꍇ�A
            // �ē������h�{�A�g���Z��L��
            setState_VALID_RE_ENTRY_NUTRITION();
            // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - end
        } else {
            setState_INVALID_NUTRITION();
            setState_INVALID_KEEP_NUTRITION();
            // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - begin
            // �h�{�}�l�W�����g���Z���Z�肵�Ă��Ȃ��ꍇ
            // �ē������h�{�A�g���Z�𖳌�
            setState_INVALID_RE_ENTRY_NUTRITION();
        	// ��h�{���X�N���P���Z�𖳌�
        	setState_INVALID_LOW_NUTRITIONAL();
            // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - end
        }
        
        // �o���ێ����Z�̏�Ԃ���Ɍo���ێ����Z�Q�̗L����Ԃ�ύX
        if (getMedicalFacilityHospitalNutritionRadioItem2().isSelected()
                && getOralMaintenanceAddItem2().isSelected()) {
            setState_VALID_ORAL_MAINTENANCE2();
        } else {
        	setState_INVALID_ORAL_MAINTENANCE2();
        }

        // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�Ǝ�N���F�m�Ǘ��p�Ҏ�����Z�̔r������
        if (getDementiaEmergencyAddRadioGroup().getSelectedIndex() == 2) {
            // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���u����v�̏ꍇ
            // ��N���F�m�Ǘ��p�Ҏ�����Z�𖳌��ɂ���B
            setState_INVALID_YOUNG_DEMENTIA_PATINET();
        } else {
            // ��L�ȊO�̏ꍇ
            // ��N���F�m�Ǘ��p�Ҏ�����Z��L���ɂ���B
            setState_VALID_YOUNG_DEMENTIA_PATINET();
        }
        if (getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() == 2) {
            // ��N���F�m�Ǘ��p�Ҏ�����Z���u����v�̏ꍇ
            // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�𖳌��ɂ���B
            setState_INVALID_DEMENTIA_ACTION();
        } else {
            // ��L�ȊO�̏ꍇ
            // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z��L���ɂ���B
            setState_VALID_DEMENTIA_ACTION();
        }

        


        // ���Ȏ�f������̏ꍇ
        if (getMedicalFacilityHospitalMedicalExaminationRadioItem2()
                .isSelected()) {
            // �O���𖳌��ɂ���
            setState_INVALID_GAIHAKU();
            // �O���̂Ȃ���I����Ԃɂ���
            getMedicalFacilityHospitalStayRadioItem1().setSelected(true);

        } else {
            // �O����L���ɂ���
            setState_VALID_GAIHAKU();
        }

        // �O��������̏ꍇ
        if (getMedicalFacilityHospitalStayRadioItem2().isSelected()) {
            // ���Ȏ�M�𖳌��ɂ���
            setState_INVALID_TAKAJYUSIN();
            // ���Ȏ�M�̂Ȃ���I����Ԃɂ���
            getMedicalFacilityHospitalMedicalExaminationRadioItem1()
                    .setSelected(true);

        } else {
            // ���Ȏ�M��L���ɂ���
            setState_VALID_TAKAJYUSIN();
        }

        // ���s�I�މ@�T�[�r�X�����̏ꍇ
        if (getTrialHijoRadioItem2().isSelected()) {
            // ���Ȏ�M�𖳌��ɂ���
            setState_INVALID_TAKAJYUSIN();
            // ���Ȏ�M�̂Ȃ���I����Ԃɂ���
            getMedicalFacilityHospitalMedicalExaminationRadioItem1()
                    .setSelected(true);
            // �O���𖳌��ɂ���
            setState_INVALID_GAIHAKU();
            // �O���̂Ȃ���I����Ԃɂ���
            getMedicalFacilityHospitalStayRadioItem1().setSelected(true);
        } else {
            // ���Ȏ�M��L���ɂ���
            setState_VALID_TAKAJYUSIN();
            // �O����L���ɂ���
            setState_VALID_GAIHAKU();
        }

        
        // ��ԋΖ�������ɂ���ԋΖ����Ō���Z����
        if (getMedicalFacilityHospitalNightShiftSubtractionRadioItem2().isSelected()) {
            setState_INVALID_HOSPITAL_RECUPERATION();
        } else {
            setState_VALID_HOSPITAL_RECUPERATION();
        }

        // �{�݋敪���`�F�b�N����
        switch (getMedicalFacilityHospitalInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 3:
        case 6:
        	// �u���ʌ^�v�̏ꍇ
        	// �u���ʉ���É@�v�̏ꍇ
        	setState_INVALID_SPECIAL();
            break;
        }
        
        
        // ��L�����ŗL���ɂȂ����R���g���[���ł��A���Ə��̐��Ő�����󂯂���̂͏㏑���Ő��䂷��B
        resetStateByRestrictBindPath();
    }

    @Override
    protected void oralKeepStructureAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ��Ԑ���
        checkState();

    }

	@Override
	protected void medicalFacilityHospitalNightShiftSubtractionRadioSelectionChanged(ListSelectionEvent e)
			throws Exception {
        // ��Ԑ���
        checkState();
	}


    
}
