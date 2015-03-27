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
 * �v���O���� �T�[�r�X�p�^�[�����\�h�Z������������� (QS001_12411_201504)
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
 * �T�[�r�X�p�^�[�����\�h�Z�������������(QS001_12411_201504)
 */
@SuppressWarnings("serial")
public class QS001_12411_201504 extends QS001_12411_201504Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_12411_201504() {
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�{�ݓ��̋敪", "1240101", "1240101");
        putImportProviderBindPath("��ԋΖ������", "1240102", "1240104");
        putImportProviderBindPath("���j�b�g�P�A�̐�", "1240104", "1240111");
        putImportProviderBindPath("�@�\�P���w���̐�", "1240105", "1240105");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1240118", "1240113");
        
        putImportProviderBindPath("�ʋ@�\�P���̐�", "1240120", "1240115");

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("���j�b�g�P�A�̐�", "1240104", "1240111");
        putRestrictProviderBindPath("�@�\�P���w���̐�", "1240105", "1240105");
        putRestrictProviderBindPath("�×{�H", "1240117", "1240107");
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1240116", "1240112");
        
        putRestrictProviderBindPath("�ʋ@�\�P���̐�", "1240120", "1240115");
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
        // ��ʂ̏�Ԃ𐧌䂷��B
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
            // �H���e�L�X�g�̏�Ԃ𐧌䂷��B
            checkDinnerState();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            checkDinnerState();

            // �H����p(shortStayLifeDinnerCost)��ݒ肷��B
            checkMeatCost();
        }

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_12411_201504.class.getName(),
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
        // �擾�����l���AcomboItemMap�� KEY : 1240109 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1240109",
                QkanCommon.getArrayFromMasterCode(191, "1240109"));
        // ���W�J
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();
        // ���I�����ڂ̏����ݒ�
        // ������
        // �����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
        VRMap defaultMap = new VRHashMap();
        // ���ݒ�
        // ��ʂ̃��W�I�̏����l��ݒ肷��B�iselectFirstRadioItem�j
        QkanCommon.selectFirstRadioItem(getThis());
        // �H���񋟂��u�Ȃ��v�ɂ���B
        VRBindPathParser.set("1240109", defaultMap, new Integer(1));
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();
        // ��ʂ̏�Ԃ𐧌䂷��B
        checkState();

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        if (provider != null) {
            // �I�����Ə����null�łȂ��ꍇ
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();

            // �E���̌����ɂ�錸�Z�̏󋵁i���Ə��p�l���jKEY�F1240103�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1240103", provider), 0)) {
            case 1:
                // �l��1�i�Ȃ��j�������ꍇ
                // defaultMap�� KEY�F1240108 VALUE�F1�i���}�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1240108", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
                // �l��3�i�Ō�E���E���j�������ꍇ
                // defaultMap�� KEY�F1240108 VALUE�F3�i���}�����j��ݒ肷��B
                VRBindPathParser.set("1240108", defaultMap, new Integer(3));
                break;
            }

            // 2015/03/02 [H27.4�����Ή�][Shinobu Hitaka] edit - begin �̐��������Ă��Ȃ���I������B
            VRBindPathParser.set("6", defaultMap, new Integer(1));
            // ���}�̐��i���Ə��p�l���jKEY�F1240106�̒l���`�F�b�N����B
            //switch (ACCastUtilities.toInt(
            //        VRBindPathParser.get("1240106", provider), 0)) {
            //case 1:
            //    // �l��1�i�Ή��s�j�������ꍇ
            //    // defaultMap�� KEY�F6 VALUE�F1�i�Ȃ��j��ݒ肷��B
            //    VRBindPathParser.set("6", defaultMap, new Integer(1));
            //    break;
            //case 2:
            //    // �l��2�i�Ή��j�������ꍇ
            //    // defaultMap�� KEY�F6 VALUE�F3�i���}�����j��ݒ肷��B
            //    VRBindPathParser.set("6", defaultMap, new Integer(3));
            //    break;
            //}
            // ��N���F�m�Ǘ��p�Ҏ�����Z���Ȃ��ɐݒ肷��B
            VRBindPathParser.set("1240112", defaultMap, new Integer(1));
            // 2015/03/02 [H27.4�����Ή�][Shinobu Hitaka] edit - end

            Object obj;
            // �T�[�r�X�񋟑̐��������Z
            obj = VRBindPathParser.get("1240118", provider);
            // �T�[�r�X�񋟑̐��������Z�i�P�ƌ^�j��D�悷�邽�ߒl���Ȃ��̏ꍇ�̂ݓK�p
            if (ACCastUtilities.toInt(obj, 0) == 1) {
                // 1240119 �T�[�r�X�񋟑̐��������Z(�󏰌^)
                obj = VRBindPathParser.get("1240119", provider);
                if (obj != null) {
                    VRBindPathParser.set("1240113", defaultMap, obj);
                }
            }

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // ��ʂ̏�Ԃ𐧌䂷��B
            checkState();

            if (getShortStayLifeDinnerOffer().getSelectedIndex() == 0) {
                getShortStayLifeDinnerOffer().setSelectedIndex(1);
            }
            // �e�L�X�g�G���A�̐��䂷��B
            checkDinnerState();

            checkMeatCost();
        }

    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        // ���ԋp�p�̃��R�[�h(data)�𐶐�
        VRMap data = new VRHashMap();
        // ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
        getThis().setSource(data);
        // ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
        getThis().applySource();
        // ���ԋp�p���R�[�h����s�v�ȃL�[������
        QkanCommon.removeDisabledBindPath(getThis(), data);

        // �H��R���{�̒l���`�F�b�N����B
        if (getShortStayLifeDinnerOffer().getSelectedIndex() >= 1) {
            // �H��e�L�X�g�������͂������ꍇ
            if (ACTextUtilities.isNullText(getShortStayLifeDinnerCost()
                    .getText())) {
                // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
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
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkState() throws Exception {
        // ����ʏ�Ԃ𐧌䂷��B
        // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z �I����
        if (getDementiaActionAddRadioGroup().getSelectedIndex() == 2) {
            setState_INVALID_YOUNG_DEMENTIA_PATINET();
        } else {
            setState_VALID_YOUNG_DEMENTIA_PATINET();
        }

        // ��N���F�m�Ǘ��p�Ҏ�����Z �I����
        if (getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() == 2) {
            setState_INVALID_DEMENTIA_ACTION();
        } else {
            setState_VALID_DEMENTIA_ACTION();
        }

        // ���T�[�r�X�A��
        // �{�ݓ��̋敪�i�T�[�r�X�p�l���j�̒l���`�F�b�N����B
        switch (getShortStayLifeTimeContenaFacilityDivision()
                .getSelectedIndex()) {
        case 1:
            // �l��1(�P�ƌ^)�̏ꍇ
            setState_SELECT_STAY_SINGLE();
            break;
        case 2:
            // �l��2�i���݌^�j�������ꍇ
            setState_SELECT_STAY_DOUBLE();
            break;
        case 3:
            // �l��3�i�P�ƌ^���j�b�g�^�j�������ꍇ
            setState_SELECT_STAY_SINGLE_UNIT();
            break;
        case 4:
            // �l��4�i���݌^���j�b�g�^�j�������ꍇ
            setState_SELECT_STAY_DOUBLE_UNIT();
            break;
        }

        // ���Ə��̐��Ɠ���
        resetStateByRestrictBindPath();
    }

    /**
     * �u�H���e�L�X�g����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkDinnerState() throws Exception {
        // ���H���e�L�X�g�̐�����s��
        // �H���񋟁ishortStayLifeDinnerOffer�j�̒l���`�F�b�N����B
        if (getShortStayLifeDinnerOffer().getSelectedIndex() == 0) {
            // �l��0�������ꍇ
            // �H���e�L�X�g��Enable�� false �ɂ���B
            setState_DINNER_COST_ENABLE_FALSE();
        } else {
            // �l��1�ȊO�������ꍇ
            // �H���e�L�X�g��Enable�� true �ɂ���B
            setState_DINNER_COST_ENABLE_TRUE();
        }
    }

    /**
     * �u�H��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkMeatCost() throws Exception {
        // ���H�����������ƂɑI�����Ə��ɂ�����H����p��Ԃ��B
        if (getSelectedProvider() != null) {
            // ���Ə������I���inull�j �ł͂Ȃ��ꍇ
            String meat = "";
            switch (getShortStayLifeDinnerOffer().getSelectedIndex()) {
            case 1:
                // �H���������u������v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��A�u��v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240108", getSelectedProvider()),
                        0));
                break;
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240109", getSelectedProvider()),
                        0));
                break;
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240110", getSelectedProvider()),
                        0));
                break;
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240111", getSelectedProvider()),
                        0));
                break;
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��Ɓu���v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240109", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1240110",
                                getSelectedProvider()), 0));
                break;
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��Ɓu��v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240110", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1240111",
                                getSelectedProvider()), 0));
                break;
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��Ɓu���v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240111", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1240109",
                                getSelectedProvider()), 0));
                break;
            }
            getShortStayLifeDinnerCost().setText(meat);
        } else {

            // �@�󕶎���Ԃ��B
            getShortStayLifeDinnerCost().setText("");
        }
    }

    protected void dementiaActionAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        checkState();

    }

    protected void youngDementiaPatinetAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        checkState();

    }
}
