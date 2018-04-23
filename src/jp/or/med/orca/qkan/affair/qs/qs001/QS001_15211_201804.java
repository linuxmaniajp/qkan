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
 * �v���O���� �T�[�r�X�p�^�[�����V�l�ی��{�� (QS001_15211_201804)
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
 * �T�[�r�X�p�^�[�����V�l�ی��{��(QS001_15211_201804)
 */
@SuppressWarnings("serial")
public class QS001_15211_201804 extends QS001_15211_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_15211_201804() {

        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�{�݋敪", "1520101", "1520101");
        putImportProviderBindPath("�{�݋敪�i�̐��j", "1520122", "1520132");
        putImportProviderBindPath("�l���z�u�敪�i�]���^�j", "1520132", "1520143");
        putImportProviderBindPath("�×{�̐��ێ����ʉ��ZI", "1520124", "1520134");
        putImportProviderBindPath("�×{�̐��ێ����ʉ��ZII", "1520136", "1520152"); //[H30.4����]
        putImportProviderBindPath("��ΐE���z�u���Z", "1520126", "1520136");
        putImportProviderBindPath("�h�{�}�l�W�����g���Z", "1520130", "1520111");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1520129", "1520142");
        putImportProviderBindPath("��ԋΖ������", "1520102", "1520104");
        putImportProviderBindPath("���j�b�g�P�A�̐�", "1520119", "1520127");

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�h�{�}�l�W�����g", "1520130", "1520111");
        putRestrictProviderBindPath("�×{�H���Z", "1520125", "1520113");
        putRestrictProviderBindPath("��N���F�m�Ǔ����Ҏ�����Z", "1520127", "1520138");
        putRestrictProviderBindPath("���j�b�g�P�A�̐�", "1520119", "1520127");
        putRestrictProviderBindPath("�F�m�ǐ��P�A���Z", "1520128", "1520137");
        putRestrictProviderBindPath("�F�m�ǃP�A���Z", "1520121", "1520128");
        putRestrictProviderBindPath("��ጃ}�l�W�����g���Z", "1520135", "1520157"); //[H30.4����]
        putRestrictProviderBindPath("�ݑ�A�E�ݑ�×{�x���@�\���Z", "1520133", "1520140"); //[H30.4����]
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoHealthCareOfTheAgedDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        changeState();

    }

    /**
     * �u�H���񋟑I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoHealthCareOfTheAgedDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getKaigoHealthCareOfTheAgedDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            setState_NOT_USE_MEAT();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            setState_USE_MEAT();
            // �H����p(kaigoHealthCareOfTheAgedDinnerCost)��ݒ肷��B
            getKaigoHealthCareOfTheAgedDinnerCost().setText(
                    getMeatCost(getKaigoHealthCareOfTheAgedDinnerOffer()
                            .getSelectedIndex()));
        }
    }

    /**
     * �u���ʗ×{��ݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void specialMedicalExpenseActionPerformed(ActionEvent e)
            throws Exception {
        // �����ʗ×{��̕ҏW
        // ���ʗ×{��ҏW���(QS001200)�𐶐�����B
        // ���ʗ×{��{�^���̃f�[�^�������ɐ����������ʗ×{��ҏW���(QS001200)��shoModal�����s����B
        if (new QS001S02_201204().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getSpecialMedicalExpense().getDataModel())) {
            // ���ʗ×{���ύX�����ꍇ
            if (getSpecialMedicalExpense().getDataModel().isEmpty()) {
                // ���ʗ×{��{�^���̃f�[�^����̏ꍇ
                // ���ʗ×{��x���Ɂu�ݒ�Ȃ��v�ƕ\������B
                getSpecialMedicalExpenseLabel().setText("�ݒ�Ȃ�");
            } else {
                // ���ʗ×{��{�^���̃f�[�^����ł͂Ȃ��ꍇ
                // ���ʗ×{��x���Ɂu�ݒ肠��v�ƕ\������B
                getSpecialMedicalExpenseLabel().setText("�ݒ肠��");
            }
        }

    }

    
    /**
     * �u�h�{�}�l�W�����g���Z�̕ύX�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoHealthCareOfTheAgedNutritionRadioSelectionChanged(
                ListSelectionEvent e) throws Exception {
        changeState();
    }

    /**
     * �u�o���ڍs���Z�̕ύX�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoHealthCareOfTheAgedOralSwitchRadioSelectionChanged(
    	        ListSelectionEvent e) throws Exception {
        changeState();
    }
    /**
     * �u�o���ێ����Z�ɔ�����ʏ�Ԑݒ�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void oralMaintenanceAddSelectionChanged(ListSelectionEvent e) 
            throws Exception {
        changeState();
    }

    /**
     * �u�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�I���v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void dementiaEmergencyAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception{
    	changeState();

    }

    /**
     * �u��N���F�m�Ǘ��p�Ҏ�����Z�I���v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void youngDementiaPatinetAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception{
    	changeState();

    }
	
    /**
     * �u�O�����Z�I���v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
	@Override
	protected void kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioSelectionChanged(ListSelectionEvent e)
			throws Exception {
    	changeState();
	}

    /**
     * �u�O�����ݑ�T�[�r�X���p��p�I���v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
	@Override
	protected void homeServiceUsageFeeAtHomeSelectionChanged(
			ListSelectionEvent e) throws Exception {
    	changeState();
	}

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_15211_201804.class.getName(),
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
        getSpecialMedicalExpense().clearDataModel();
        // QS001200(���ʗ×{��)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A���ʗ×{��{�^���ɐݒ肷��B
        getSpecialMedicalExpense()
                .setBindPathes(
                        QS001S02_201204
                                .getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
        // �H����
        comboItemMap.setData("1520120",
                QkanCommon.getArrayFromMasterCode(191, "1520120"));
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
        VRBindPathParser.set("1520120", defaultMap, new Integer(1));
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
            Object obj;

            // �l�����Z
            obj = VRBindPathParser.get("1520131", provider);
            if (obj != null) {

                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1520119", defaultMap, new Integer(1));
                    break;
                case 2: // ��t�������ꍇ
                case 3: // �Ō�E���������ꍇ
                case 4: // ���E���������ꍇ
                case 5: // ���w�Ö@�m�������ꍇ
                case 6: // ��ƗÖ@�m�������ꍇ
                case 7: // ���x�������������ꍇ
                case 8: // ���꒮�o�m�������ꍇ
                    VRBindPathParser.set("1520119", defaultMap, new Integer(3));
                    break;
                }
            }
            
            // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - begin
            // �ݑ�A�E�ݑ�×{�x���@�\���Z
            obj = VRBindPathParser.get("1520133", provider);
            if (obj != null) {
                // ���Ə��o�^�̉��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1520140", defaultMap, new Integer(1));
                    break;
                case 2: // I�^�������ꍇ
                case 3: // II�^�������ꍇ
                    VRBindPathParser.set("1520140", defaultMap, new Integer(2));
                    break;
                }
            }
            // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - end

            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

            // �g�̍S�������{���Z
            obj = VRBindPathParser.get("1520120", provider);
            if (obj != null) {
                // �g�̍S�������{��g�ݖ����������ꍇ
                if (ACCastUtilities.toInt(obj) == 1) {
                    defaultMap.setData("1520130", new Integer(2));
                } else if (ACCastUtilities.toInt(obj) == 2) {
                    // �g�̍S�������{��g�ݗL�肾�����ꍇ
                    defaultMap.setData("1520130", new Integer(1));
                }
            }
            
            // ��N���F�m�Ǘ��p�Ҏ�����Z���Ȃ��ɐݒ肷��B
            VRBindPathParser.set("1520138", defaultMap, new Integer(1));

            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

            if (getKaigoHealthCareOfTheAgedDinnerOffer().getSelectedIndex() == 0) {
                // �H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getKaigoHealthCareOfTheAgedDinnerOffer().setSelectedIndex(1);
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
        // �{�ݓ��̋敪�����I����ԂłȂ����`�F�b�N����B
        if (getKaigoHealthCareOfTheAgedDivisionRadio().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

//[H30.4����]���W�I�{�^���˃`�F�b�N�{�b�N�X�֕ύX�ɂ��R�����g�A�E�g        
//        // �×{���ێ����ʑ̐������I���ł��Ȃ����`�F�b�N����B
//        if (getRecuperationRadio().getSelectedIndex() < 1) {
//            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
//            return null;
//        }

        // ��ΐE���z�u���Z���W�I�������͂ł��邩�`�F�b�N����B
        if (getNightStaffDispositionAddRadioGroup().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // ��N���F�m�Ǔ����Ҏ�����Z���W�I�������͂ł��邩�`�F�b�N����B
        if (getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // �h�{�}�l�W�����g���Z���W�I�������͂ł��邩�`�F�b�N����B
        if (getKaigoHealthCareOfTheAgedNutritionRadio().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // �F�m�ǐ��P�A���Z���W�I�������͂ł��邩�`�F�b�N����B
        if (getDementiaProfessionalCareAddRadioGroup().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // �T�[�r�X�񋟑̐��������Z���W�I�������͂ł��邩�`�F�b�N����B
        if (getServiceAddProvisionStructuralRadioGroup().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // ���ʗ×{��g�p�s�\�ȏꍇ�͒l���N���A����B
        if (!getSpecialMedicalExpense().isEnabled()) {
            getSpecialMedicalExpense().clearDataModel();
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
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
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
                        VRBindPathParser.get("1520110", getSelectedProvider()),
                        0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1520111", getSelectedProvider()),
                        0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1520112", getSelectedProvider()),
                        0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1520113", getSelectedProvider()),
                        0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1520111", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520112",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1520112", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520113",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(
                        VRBindPathParser.get("1520113", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520111",
                                getSelectedProvider()), 0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
    }

    /**
     * �u�f�[�^�o�C���h��̏����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void binded() throws Exception {
        // ���f�[�^�o�C���h��̏���
        // [ID:0000739][Masahiko.Higuchi] 2012/05 ���ʗ×{��ڂ̃N���A���� del begin
        // if (getSpecialMedicalExpense().getDataModel().isEmpty()) {
        // [ID:0000739][Masahiko.Higuchi] 2012/05 ���ʗ×{��ڂ̃N���A���� del end
        // [ID:0000739][Masahiko.Higuchi] 2012/05 ���ʗ×{��ڂ̃N���A���� add begin
        if (getSpecialMedicalExpense().getDataModel().isEmpty()
                || !getSpecialMedicalExpense().isEnabled()) {
            getSpecialMedicalExpense().clearDataModel();
            // [ID:0000739][Masahiko.Higuchi] 2012/05 ���ʗ×{��ڂ̃N���A���� add begin
            // ���ʗ×{��{�^���̃f�[�^����̏ꍇ
            // ���ʗ×{��x���Ɂu�ݒ�Ȃ��v�ƕ\������B
            getSpecialMedicalExpenseLabel().setText("�ݒ�Ȃ�");
        } else {
            // ���ʗ×{��{�^���̃f�[�^����ł͂Ȃ��ꍇ
            // ���ʗ×{��x���Ɂu�ݒ肠��v�ƕ\������B
            getSpecialMedicalExpenseLabel().setText("�ݒ肠��");
        }

    }

    protected void kaigoHealthCareOfTheAgedDivisionSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ��ʏ�Ԑ���
        changeState();

    }

    public void changeState() throws Exception {
    	
        // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - begin
        // �u���ʉ��ی��{�݃T�[�r�X��v�Ŗ����ƂȂ��Ă��鍀�ڂ�����ΗL���ɂ��Ă���
        setState_VALID_SPECIAL();
        // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - end
        
        
        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getKaigoHealthCareOfTheAgedDivisionRadio().getSelectedIndex()) {
        case 1:
            setState_FACILITY_TYPE_1();
            break;
        case 2:
            setState_FACILITY_TYPE_2();
            break;
        case 3:
            setState_FACILITY_TYPE_3();
            break;
        case 4:
            setState_FACILITY_TYPE_4();
            break;
        case 5:
            setState_FACILITY_TYPE_5();
            break;
        case 6:
            setState_FACILITY_TYPE_6();
            break;
        case 7:
            setState_FACILITY_TYPE_7();
            break;
        case 8:
            setState_FACILITY_TYPE_8();
            break;
        }


        
        // ���o�@�\�ێ��Ǘ��̐����Z
        if (getOralKeepStructureAddRadioGroup().getSelectedIndex() == 1) {
            setState_INVALID_ORAL_CARE();
        } else {
            setState_VALID_ORAL_CARE();
        }

        // �Z��敪���A���Z�̂ݎZ��ł���ꍇ
        if (getKaigoHealthCareOfTheAgedCalculationDivisionRadio()
                .getSelectedIndex() == 2) {
            // �^�[�~�i���P�A���Z�̑I���󋵂ɂ�鐧��
            switch (getTerminalRadio().getSelectedIndex()) {
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
        
        // �h�{�}�l�W�����g���Z�̏�Ԃ���Ɍo���ڍs���Z�A�o���ێ����Z�̗L����Ԃ�ύX
        if (getKaigoHealthCareOfTheAgedNutritionRadioItem2().isSelected()) {
            // �o���ڍs���Z�̏�Ԃ����ɐ���
            if (getKaigoHealthCareOfTheAgedOralSwitchRadioItem2().isSelected()) {
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
            if (getKaigoHealthCareOfTheAgedOralSwitchRadioItem1().isSelected()
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
            // �h�{�}�l�W�����g���Z���Z�肵�Ă��Ȃ��ꍇ�A
            // �ē������h�{�A�g���Z�𖳌�
            setState_INVALID_RE_ENTRY_NUTRITION();
        	// ��h�{���X�N���P���Z�𖳌�
        	setState_INVALID_LOW_NUTRITIONAL();
            // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - end
        }
        
        // �o���ێ����Z�̏�Ԃ���Ɍo���ێ����Z�Q�̗L����Ԃ�ύX
        if (getKaigoHealthCareOfTheAgedNutritionRadioItem2().isSelected()
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
        
        // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - begin
        // �O������p�ƊO�����̍ݑ�T�[�r�X��p�̔r������
        // �O�����Z������̏ꍇ
        if (getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2().isSelected()) {
        	// �O�����̍ݑ�T�[�r�X��p�𖳌��ɂ���
            setState_INVALID_HOME_SERVICE_USAGE();
        } else {
        	// �O�����̍ݑ�T�[�r�X��p��L���ɂ���
            setState_VALID_HOME_SERVICE_USAGE();
        }
        // �O�����̍ݑ�T�[�r�X��p������̏ꍇ
        if (getHomeServiceUsageFeeAtHomeItem2().isSelected()) {
        	// �O�����Z�𖳌��ɂ���
            setState_INVALID_GAIHAKU();
        } else {
        	// �O�����Z��L���ɂ���
            setState_VALID_GAIHAKU();
        }
        // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - end
        
        // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - begin
        // �{�݋敪���`�F�b�N����
        switch (getKaigoHealthCareOfTheAgedDivisionRadio().getSelectedIndex()) {
        case 7:
        case 8:
        	// �u���ʉ��ی��{�݃T�[�r�X��v�̏ꍇ�ɎZ��s�ƂȂ���Z�𖳌��ɂ���
        	setState_INVALID_SPECIAL();
            break;
        }
        // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - end


        // ��L�����ŗL���ɂȂ����R���g���[���ł��A���Ə��̐��Ő�����󂯂���̂͏㏑���Ő��䂷��B
        resetStateByRestrictBindPath();
    }

    @Override
    protected void kaigoHealthCareOfTheAgedHospitalDivision1ActionPerformed(
            ActionEvent e) throws Exception {
        changeState();
    }

    @Override
    protected void oralKeepStructureAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        changeState();

    }

    @Override
    protected void terminalRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        changeState();
    }

    @Override
    protected void kaigoHealthCareOfTheAgedCalculationDivisionRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        changeState();
    }




    
}
