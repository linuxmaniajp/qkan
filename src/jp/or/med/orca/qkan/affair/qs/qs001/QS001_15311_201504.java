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
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�a�@�j (QS001_15311_201504)
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
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�a�@�j(QS001_15311_201504)
 */
@SuppressWarnings("serial")
public class QS001_15311_201504 extends QS001_15311_201504Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_15311_201504() {
        
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");
        
        // ���Ə�����̒l�����p��
        putImportProviderBindPath("�l���z�u�敪�i�a�@�×{�^�p�j", "1530129", "1530102");
        putImportProviderBindPath("�{�݋敪", "1530128", "1530162");
        putImportProviderBindPath("��ԋΖ������", "1530130", "1530163");
        putImportProviderBindPath("��t�̔z�u�", "1530105", "1530107");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1530124", "1530167");
        putImportProviderBindPath("�h�{�}�l�W�����g���Z", "1530126", "1530112");
        putImportProviderBindPath("���j�b�g�P�A�̐���", "1530131", "1530116");
        putImportProviderBindPath("�×{���", "1530127", "1530168");

        putImportProviderBindPath("�l���z�u�敪�i���j�b�g�^�a�@�×{�^�p�j", "1530132", "1530121");
        putImportProviderBindPath("�l���z�u�敪�i�a�@�o�ߌ^�p�j", "1530133", "1530122");
        
        // ���Ə��̐ݒ�ɂ�薳���ɂ���
        putRestrictProviderBindPath("��N���F�m�Ǌ��Ҏ�����Z", "1530121", "1530164");
        putRestrictProviderBindPath("�h�{�}�l�W�����g���Z", "1530126", "1530112");
        putRestrictProviderBindPath("�×{�H���Z", "1530122", "1530114");
        putRestrictProviderBindPath("�F�m�ǐ��P�A���Z", "1530123", "1530166");
        putRestrictProviderBindPath("���j�b�g�P�A�̐���", "1530131", "1530116");

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
            // �u�a�@�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v��L���ɂ��A�u�a���敪(���j�b�g�^)�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            break;
        case 2:
            // �u���j�b�g�^�a�@�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v�𖳌��ɂ��A�u�a���敪(���j�b�g�^)�v��L���ɂ���B
            setState_UNIT_FORM();
            break;
        case 3:
            // �u�o�ߌ^�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v��L���ɂ��A�u�a���敪(���j�b�g�^)�v�𖳌��ɂ���B
            setState_PASSAGE_FORM();
            break;

        case 4:
            // �u�a���敪(�ʏ�)�v�𖳌��ɂ��A�u�a���敪(���j�b�g�^)�v��L���ɂ���B
            setState_UNIT_FORM();
            // ���s�I�ޏ���L��
            setState_VALID_TRIAL_HIJO();
            break;
        }
        // �l���z�u�敪�𐧌䂷��
        changeStaffDivisionState();

        // ��ʂ̏�Ԑ���
        checkState();
    }

    /**
     * �u�l�����Z�R���{�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void medicalFacilityHospitalSubstractionActionPerformed(
            ActionEvent e) throws Exception {
        // �l�����Z�R���{�I��
        // ��Ō�E�Ō�E���������̏ꍇ�����Ŕ䗦��20%�����̏ꍇ���ƒn�͏o���
        if (getMedicalFacilityHospitalSubstraction().getSelectedIndex() == 2
                || getMedicalFacilityHospitalSubstraction().getSelectedIndex() == 4
                || getMedicalFacilityHospitalSubstraction().getSelectedIndex() == 6) {
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
     * �u����f�Ô�̐ݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void medicalFacilityHospitalConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {
        // ������f�Ô�̕ҏW
        // ����f�Ô�ҏW���(QS001199_H2104)�𐶐�����B
        // ����f�Ô�{�^���̃f�[�^�������ɐ�����������f�Ô�ҏW���(QS001028)��shoModal�����s����B
        if (new QS001S01_201204().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getMedicalFacilityHospitalConsultationFee().getDataModel())) {
            // ����f�Ô��ύX�����ꍇ
            if (getMedicalFacilityHospitalConsultationFee().getDataModel()
                    .isEmpty()) {
                // ����f�Ô�{�^���̃f�[�^����̏ꍇ
                // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
                getMedicalFacilityHospitalConsultationFeeLabel()
                        .setText("�ݒ�Ȃ�");
            } else {
                // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
                // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
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
        ACFrame.debugStart(new ACAffairInfo(QS001_15311_201504.class.getName(),
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
        // QS001199_H2104(����f�Ô�)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A����f�Ô�{�^���ɐݒ肷��B
        getMedicalFacilityHospitalConsultationFee()
                .setBindPathes(
                        QS001S01_201204
                                .getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
        // �H����
        comboItemMap.setData("1530159",
                QkanCommon.getArrayFromMasterCode(191, "1530159"));
        // �l�����Z
        comboItemMap.setData("1530158",
                QkanCommon.getArrayFromMasterCode(107, "1530158"));
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
        VRBindPathParser.set("1530159", defaultMap, new Integer(1));
        // �l�����Z
        VRBindPathParser.set("1530158", defaultMap, new Integer(1));
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
            obj = VRBindPathParser.get("1530120", provider);
            if (obj != null) {
                // �g�̍S�������{��g�݂Ȃ��������ꍇ
                if (ACCastUtilities.toInt(obj) == 1) {
                    defaultMap.setData("1530117", new Integer(2));
                } else if (ACCastUtilities.toInt(obj) == 2) {
                    // �g�̍S�������{��g�݂��肾�����ꍇ
                    defaultMap.setData("1530117", new Integer(1));
                }
            }

            // �l�����Z
            obj = VRBindPathParser.get("1530110", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                case 2: // ��t�������ꍇ
                    VRBindPathParser.set("1530158", defaultMap, new Integer(1));
                    break;
                case 3: // �Ō�E���������ꍇ
                case 4: // ���E���������ꍇ
                    VRBindPathParser.set("1530158", defaultMap, new Integer(3));
                    break;
                case 5: // ���x�������������ꍇ
                    VRBindPathParser.set("1530158", defaultMap, new Integer(4));
                    break;
                }
            }

            // ��N���F�m�Ǘ��p�Ҏ�����Z���Ȃ��ɐݒ肷��B
            VRBindPathParser.set("1530164", defaultMap, new Integer(1));

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
                .getSelectedIndex() == 1) {
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
                .getSelectedIndex() == 3) {
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
                        VRBindPathParser.get("1530111", getSelectedProvider()),
                        0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530112", getSelectedProvider()),
                        0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530113", getSelectedProvider()),
                        0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530114", getSelectedProvider()),
                        0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530112", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530113",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530113", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530114",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1530114", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530112",
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
            // �l�����Z�̒l���l������Ԃ�ύX����B
            if (getPersonSubstraction()) {
                setState_VALID_SUBTRACTION();
            } else {
                setState_INVALID_SUBTRACTION();
            }
            break;
        case 2:
            // ���j�b�g�^���I������Ă����ꍇ
            setState_UNIT_FORM();
            break;
        case 3:
            // �l�����Z�̒l���l������Ԃ�ύX����B
            if (getPersonSubstraction()) {
                setState_INVALID_SUBTRACTION_3_ENABLE();
            } else {
                setState_INVALID_SUBTRACTION_1_3_ENABLE();
            }
            break;
        case 4:
        	//���j�b�g�^�a�@�o�ߌ^
        	setState_UNIT_PASSAGE_FORM();
        	break;
        }

        // ���Ə��̐��ɂ��L��/������Ԃ̍Đݒ�
        resetStateByRestrictBindPath();
    }

    public void binded() throws Exception {
        if (getMedicalFacilityHospitalConsultationFee().getDataModel()
                .isEmpty()) {
            // ����f�Ô�{�^���̃f�[�^����̏ꍇ
            // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
            getMedicalFacilityHospitalConsultationFeeLabel().setText("�ݒ�Ȃ�");
        } else {
            // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
            // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
            getMedicalFacilityHospitalConsultationFeeLabel().setText("�ݒ肠��");
        }

    }

    @Override
    public void checkState() throws Exception {

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
        } else {
            setState_INVALID_NUTRITION();
            setState_INVALID_KEEP_NUTRITION();
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

        // ���Ȏ�M�̗L���I����
        int facilityDivision = getMedicalFacilityHospitalInstitutionDivisionRadio()
                .getSelectedIndex();

        // ���s�I�ޏ��T�[�r�X���g�p�ł��邩
        boolean isValidTrialHijo = true;

        // ���Ȏ�f������̏ꍇ
        if (getMedicalFacilityHospitalMedicalExaminationRadioItem2()
                .isSelected()) {
            // �O���𖳌��ɂ���
            setState_INVALID_GAIHAKU();
            // �O���̂Ȃ���I����Ԃɂ���
            getMedicalFacilityHospitalStayRadioItem1().setSelected(true);

            isValidTrialHijo = false;

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

            isValidTrialHijo = false;

        } else {
            // ���Ȏ�M��L���ɂ���
            setState_VALID_TAKAJYUSIN();
        }

        // �̐��ɂ�鐧��
        switch (facilityDivision) {
        case 1: // �o�ߌ^�ȊO�́A�������Ɏ��s�I�ޏ��T�[�r�X��͎Z��s��
        case 2:
            isValidTrialHijo = false;
            break;
        }

        // ���s�I�ޏ��T�[�r�X��Z��ł��Ȃ��ꍇ
        if (!isValidTrialHijo) {
            // ���s�I�މ@�T�[�r�X��𖳌��ɂ���B
            setState_INVALID_TRIAL_HIJO();
            // ���s�I�މ@�T�[�r�X��̂Ȃ���I����Ԃɂ���B
            getTrialHijoRadioItem1().setSelected(true);

        } else {

	        // ���s�I�މ@�T�[�r�X���L���ɂ���B
	        setState_VALID_TRIAL_HIJO();
	
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
    
}
