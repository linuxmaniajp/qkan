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
 * �v���O���� �T�[�r�X�p�^�[���Z������������� (QS001_12111_201804)
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
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���Z�������������(QS001_12111_201804)
 */
@SuppressWarnings("serial")
public class QS001_12111_201804 extends QS001_12111_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_12111_201804() {
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�{�݋敪", "1210101", "1210101");
        putImportProviderBindPath("�@�\�P���ɑ΂���̐����Z", "1210103", "1210106");
        putImportProviderBindPath("��ԋΖ������", "1210102", "1210105");
        putImportProviderBindPath("��ΐE���z�u���Z", "1210121", "1210121");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1210124", "1210123");
        putImportProviderBindPath("���j�b�g�P�A�̐�", "1210116", "1210115");
        
        putImportProviderBindPath("�ʋ@�\�P���̐�", "1210128", "1210127");
        // 2015.03.02 del putImportProviderBindPath("��ØA�g�������Z", "1210129", "1210128");
        
        //putImportProviderBindPath("�����^", "1210130", "22"); //[H30.4����]
        putImportProviderBindPath("�������k���z�u�����Z", "1210131", "1210130"); //[H30.4����]        


        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�@�\�P���ɑ΂���̐����Z", "1210103", "1210106");
        putRestrictProviderBindPath("�×{�H", "1210123", "1210109");
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1210122", "1210122");
        putRestrictProviderBindPath("���j�b�g�P�A�̐�", "1210116", "1210115");
        putRestrictProviderBindPath("�Ō�̐����Z", "1210120", "1210119");
        putRestrictProviderBindPath("�Ō�̐����Z", "1210120", "1210133"); //[H30.4����]       
        putRestrictProviderBindPath("�Ō�̐����Z", "1210133", "1210120");
        putRestrictProviderBindPath("�Ō�̐����Z", "1210133", "1210134"); //[H30.4����]
        putRestrictProviderBindPath("�F�m�ǐ��P�A���Z", "1210135", "1210132"); //[H30.4����]
        putRestrictProviderBindPath("�����@�\����A�g���Z", "1210132", "1210131"); //[H30.4����]
        
        putRestrictProviderBindPath("�ʋ@�\�P���̐�", "1210128", "1210127");
        putRestrictProviderBindPath("��ØA�g�������Z", "1210129", "1210128");
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
        ACFrame.debugStart(new ACAffairInfo(QS001_12111_201804.class.getName(),
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
            // 2015/03/02 [H27.4�����Ή�][Shinobu Hitaka] edit - begin
            // ���Ԃ���o�^����ꍇ���������ߑ̐��������Ă��Ȃ���I������B
            VRBindPathParser.set("6", defaultMap, new Integer(1));
            //obj = VRBindPathParser.get("1210104", provider);
            //if (obj != null) {
            //    switch (ACCastUtilities.toInt(obj)) {
            //    case 1:
            //        // �̐��Ȃ��̏ꍇ
            //        VRBindPathParser.set("6", defaultMap, new Integer(1));
            //        break;
            //    case 2:
            //        // �̐�����̏ꍇ
            //        VRBindPathParser.set("6", defaultMap, new Integer(3));
            //        break;
            //    }
            //}
            // 2015/03/02 [H27.4�����Ή�][Shinobu Hitaka] edit - end
            
            // [ID:0000471][Masahiko Higuchi] 2009/04 add begin �󏰌^�Ή�
            // �T�[�r�X�񋟑̐��������Z�i�P�ƌ^�j��D�悷�邽�ߒl���Ȃ��̏ꍇ�̂ݓK�p
            obj = VRBindPathParser.get("1210124", provider);
            if (ACCastUtilities.toInt(obj, 0) == 1) {
                // 1210125 �T�[�r�X�񋟑̐��������Z(�󏰌^)
                obj = VRBindPathParser.get("1210125", provider);
                if (obj != null) {
                    VRBindPathParser.set("1210123", defaultMap, obj);
                }
            }
            // [ID:0000471][Masahiko Higuchi] 2009/04 add end

            // 2018/03/01 [H30.4�����Ή�][Shinobu Hitaka] add - begin
            // �����^�T�[�r�X�̒�
            obj = VRBindPathParser.get("1210130", provider);
            if (obj != null) {
                // ���Ə��o�^�̐ݒ荀�ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 2: // ���肾�����ꍇ
                    VRBindPathParser.set("22", defaultMap, new Integer(9));
                    break;
                }
            }
            // 2018/03/01 [H30.4�����Ή�][Shinobu Hitaka] add - end
            
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
            // �ً}�Z������������Z(shortStayLifeEmergencyAcceptanceRadioGroup)�𖳌��ɂ���B
            setState_INVALID_EMERGENCY_ACCEPTANCE();
        } else {
            // ��L�ȊO�̏ꍇ
            // ��N���F�m�Ǘ��p�Ҏ�����Z(youngDementiaPatinetAddRadioGroup)��L���ɂ���B
            setState_VALID_YOUNG_DEMENTIA_PATINET();
            // �ً}�Z������������Z(shortStayLifeEmergencyAcceptanceRadioGroup)��L���ɂ���B
            setState_VALID_EMERGENCY_ACCEPTANCE();
        }
        /* 2015/03/13 [H27.4�����Ή�][Shinobu Hitaka] del - begin
        if (getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() == 2) {
            // ��N���F�m�Ǘ��p�Ҏ�����Z(youngDementiaPatinetAddRadioGroup)���u����v�̏ꍇ
            // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z(dementiaActionAddRadioGroup)�𖳌��ɂ���B
            setState_INVALID_DEMENTIA_ACTION();
        } else {
            // ��L�ȊO�̏ꍇ
            // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z(dementiaActionAddRadioGroup)��L���ɂ���B
            setState_VALID_DEMENTIA_ACTION();
        }
        */

        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getShortStayLifeTimeContenaFacilityDivision()
                .getSelectedIndex()) {
        case 1:
            // �u�P�ƌ^�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v��L���ɂ��A�u�a���敪(���j�b�g�^)�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            break;
        case 2:
            // �u���݌^�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v��L���ɂ��A�u�a���敪(���j�b�g�^)�v�𖳌��ɂ���B
            setState_ADJOINING_FORM();
            break;
        case 3:
        case 4:
            // �u�P�ƌ^���j�b�g�^�v�������́u���݌^���j�b�g�^�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v�𖳌��ɂ��A�u�a���敪(���j�b�g�^)�v��L���ɂ���B
            setState_UNIT_FORM();
        }
        
        // 2015/03/02 [H27.4�����Ή�][Shinobu Hitaka] add - begin
        // �Ō�̐����ZII���L�����`�F�b�N����Ă����ꍇ
        boolean b1 = getNurseStructuralAddRadioItem2().isSelected();
        boolean b2 = getNurseStructuralAddRadioItem2().isEnabled();
        
        // �Ō�̐����ZIV���L�����`�F�b�N����Ă����ꍇ add [H30.4����]
        boolean b3 = getNurseStructuralAddRadioItem4().isSelected();
        boolean b4 = getNurseStructuralAddRadioItem4().isEnabled();
        
        if ((b1 && b2) || (b3 && b4)) {
            // ��ØA�g�������Z��L���ɂ��܂��B
            setState_VALID_MEDICAL_STRENGTHEN_COOPERATION();
        } else {
            // ��ØA�g�������Z�𖳌��ɂ��܂��B
            setState_INVALID_MEDICAL_STRENGTHEN_COOPERATION();
        }
        // 2015/03/02 [H27.4�����Ή�][Shinobu Hitaka] add - end
        
        // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - begin
        // �Ō�̐����ZI��III�̔r������
        boolean enabled = true;
        enabled = getNurseStructuralAddRadioItem1().isSelected() 
        		&& getNurseStructuralAddRadioItem1().isEnabled();
        getNurseStructuralAddRadioItem3().setEnabled(!enabled);

        enabled = getNurseStructuralAddRadioItem3().isSelected() 
        		&& getNurseStructuralAddRadioItem3().isEnabled();
        getNurseStructuralAddRadioItem1().setEnabled(!enabled);

        // �Ō�̐����ZII��IV�̔r������
        enabled = getNurseStructuralAddRadioItem2().isSelected() 
        		&& getNurseStructuralAddRadioItem2().isEnabled();
        getNurseStructuralAddRadioItem4().setEnabled(!enabled);
        
        enabled = getNurseStructuralAddRadioItem4().isSelected() 
        		&& getNurseStructuralAddRadioItem4().isEnabled();
        getNurseStructuralAddRadioItem2().setEnabled(!enabled);
        
        // �Ō�̐����ZIII�܂��͊Ō�̐����ZIV�̂Ƃ�����v���L��
        if ((getNurseStructuralAddRadioItem3().isSelected() 
        		&& getNurseStructuralAddRadioItem3().isEnabled())
        		|| (getNurseStructuralAddRadioItem4().isSelected()
        		&& getNurseStructuralAddRadioItem4().isEnabled())) {
            // ����v����L���ɂ��܂��B
            setState_VALID_STAY_PEOPLE_COUNT();
        } else {
            // ����v���𖳌��ɂ��܂��B
            setState_INVALID_STAY_PEOPLE_COUNT();
        }        
        // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - end

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

    /**
     * �u�Ō�̐����ZII�`�F�b�N�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void nurseStructuralAddRadioItem2ActionPerformed(ActionEvent e)
    throws Exception {
    	// ��ʂ̏�Ԃ�ύX����B
        checkState();
    }
    
    /**
     * �u�Ō�̐����ZI�`�F�b�N�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
	@Override
	protected void nurseStructuralAddRadioItem1ActionPerformed(ActionEvent e)
			throws Exception {
    	// ��ʂ̏�Ԃ�ύX����B
        checkState();
	}

    /**
     * �u�Ō�̐����ZIII�`�F�b�N�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
	@Override
	protected void nurseStructuralAddRadioItem3ActionPerformed(ActionEvent e)
			throws Exception {
    	// ��ʂ̏�Ԃ�ύX����B
        checkState();
	}

    /**
     * �u�Ō�̐����ZIV�`�F�b�N�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
	@Override
	protected void nurseStructuralAddRadioItem4ActionPerformed(ActionEvent e)
			throws Exception {
    	// ��ʂ̏�Ԃ�ύX����B
        checkState();
	}

    // 2015/03/09 [H27.4�����Ή�][Shinobu Hitaka] add - begin
    /**
     * �u�o�C���h�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void binded() throws Exception {
        // ���o�C���h���̏���
        // ��ʏ�Ԑ���
        checkState();

    }
	// 2015/03/09 [H27.4�����Ή�][Yoichiro Kamei] add - end




    
}
