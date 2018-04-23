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
 * �v���O���� �T�[�r�X�p�^�[�����\�h�Z�������×{���i�a�@�j (QS001_12611_201804)
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
 * �T�[�r�X�p�^�[�����\�h�Z�������×{���i�a�@�j(QS001_12611_201804)
 */
@SuppressWarnings("serial")
public class QS001_12611_201804 extends QS001_12611_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_12611_201804() {

        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�{�ݓ��̋敪", "1260122", "1260101");
        putImportProviderBindPath("�l���z�u�敪�i�a�@�×{�^�p�j", "1260123", "1260102");
        putImportProviderBindPath("�×{���", "1260121", "1260116"); // 2015.03.06 add
        putImportProviderBindPath("��t�̔z�u�", "1260107", "1260107");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1260120", "1260115");
        putImportProviderBindPath("���j�b�g�P�A�̐�", "1260125", "1260113");
        
        putImportProviderBindPath("�l���z�u�敪�i���j�b�g�^�a�@�×{�^�p�j", "1260126", "1260118");
        putImportProviderBindPath("�l���z�u�敪�i�a�@�o�ߌ^�p�j", "1260127", "1260119");

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�×{�H", "1260119", "1260109");
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1260118", "1260114");
        putRestrictProviderBindPath("���j�b�g�P�A�̐�", "1260125", "1260113");
        putRestrictProviderBindPath("�F�m�ǐ��P�A���Z", "1260128", "1260121"); //[H30.4����]
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
            checkDinnerState();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            checkDinnerState();

            // �H����p(shortStayRecuperationHealthFacilityDinnerCost)��ݒ肷��B
            checkMeatCost();
        }
    }

    /**
     * �u����f�Ô�ҏW�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayHospitalRecuperationSpecificConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {
        // ������f�Ô�̕ҏW
        // ����f�Ô�ҏW���(QS001199_H2104)�𐶐�����B
        // ����f�Ô�{�^���̃f�[�^�������ɐ�����������f�Ô�ҏW���(QS001199)��shoModal�����s����B
        if (new QS001S01_201204().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getShortStayHospitalRecuperationSpecificConsultationFee()
                        .getDataModel())) {
            // ����f�Ô��ύX�����ꍇ
            if (getShortStayHospitalRecuperationSpecificConsultationFee()
                    .getDataModel().isEmpty()) {
                // ����f�Ô�{�^���̃f�[�^����̏ꍇ
                // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
                getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                        .setText("�ݒ�Ȃ�");
            } else {
                // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
                // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
                getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                        .setText("�ݒ肠��");
            }
        }

    }

    /**
     * �u�l�����Z�R���{�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayHospitalRecuperationPersonSubtractionActionPerformed(
            ActionEvent e) throws Exception {
        // �l�����Z�̃R���{�I������
        // ��ʂ̏�Ԃ�ύX����B
        checkState();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_12611_201804.class.getName(),
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
        // QS001199_H2104(����f�Ô�)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A����f�Ô�{�^���ɐݒ肷��B
        getShortStayHospitalRecuperationSpecificConsultationFee()
                .clearDataModel();
        getShortStayHospitalRecuperationSpecificConsultationFee()
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
        // �擾�����l���AcomboItemMap�� KEY : 1260111 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1260111",
                QkanCommon.getArrayFromMasterCode(191, "1260111"));
        // ���l�����Z
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F66�i�l�����Z�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1260110 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1260110",
                QkanCommon.getArrayFromMasterCode(66, "1260110"));
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
        VRBindPathParser.set("1260111", defaultMap, new Integer(1));
        // �l�����Z���u�Ȃ��v�ɂ���B
        VRBindPathParser.set("1260110", defaultMap, new Integer(1));
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();
        // ��ʂ̏�Ԃ�ݒ肷��B
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

            // ���ݒ�
            // �����Ə��A��
            // �E���̌����ɂ�錸�Z�̏󋵁i���Ə��p�l���jKEY�F1260104�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1260104", provider), 0)) {
            case 1:
            case 2:
                // �l��1����2�i�Ȃ��E��t�j�������ꍇ
                // defaultMap�� KEY�F1260110 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1260110", defaultMap, new Integer(1));
                break;
            case 3:
            case 4:
                // �l��3����4�i�Ō�E���E���j�������ꍇ
                // defaultMap�� KEY�F1260110 VALUE�F2�i����j��ݒ肷��B
                VRBindPathParser.set("1260110", defaultMap, new Integer(3));
                break;
            }
            
            // 2018/02/27 [H30.4�����Ή�][Shinobu Hitaka] add - begin
            Object obj;
            // ��ԋΖ������
            obj = VRBindPathParser.get("1260124", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // ��^
                    VRBindPathParser.set("1260105", defaultMap, new Integer(1));
                    break;
                case 2: // ���Z�^I
                    VRBindPathParser.set("1260120", defaultMap, new Integer(2));
                    break;
                case 3: // ���Z�^II
                    VRBindPathParser.set("1260120", defaultMap, new Integer(3));
                    break;
                case 4: // ���Z�^III
                    VRBindPathParser.set("1260120", defaultMap, new Integer(4));
                    break;
                case 6: // ���Z�^IV
                    VRBindPathParser.set("1260120", defaultMap, new Integer(5));
                    break;
                case 5: // ���Z�^
                    VRBindPathParser.set("1260105", defaultMap, new Integer(2));
                    break;
                }
            }   
            //2018/02/27 [H30.4�����Ή�][Shinobu Hitaka] add - end
          
            // 2015/03/02 [H27.4�����Ή�][Shinobu Hitaka] edit - begin �̐��������Ă��Ȃ���I������B
            VRBindPathParser.set("6", defaultMap, new Integer(1));
            // ���}�̐��i���Ə��p�l���jKEY�F1260108�̒l���`�F�b�N����B
            //switch (ACCastUtilities.toInt(
            //        VRBindPathParser.get("1260108", provider), 0)) {
            //case 1:
            //    // �l��1�i�Ή��s�j�������ꍇ
            //    // defaultMap�� KEY�F6 VALUE�F1�i���}�Ȃ��j��ݒ肷��B
            //    VRBindPathParser.set("6", defaultMap, new Integer(1));
            //    break;
            //case 2:
            //    // �l��2�i�Ή��j�������ꍇ
            //    // defaultMap�� KEY�F6 VALUE�F3�i���}�����j��ݒ肷��B
            //    VRBindPathParser.set("6", defaultMap, new Integer(3));
            //    break;
            //}
            // ��N���F�m�Ǘ��p�Ҏ�����Z���Ȃ��ɐݒ肷��B
            VRBindPathParser.set("1260114", defaultMap, new Integer(1));
            // 2015/03/02 [H27.4�����Ή�][Shinobu Hitaka] edit - end

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // ��ʂ̏�Ԃ�ύX����B
            checkState();

            // �������ݒ�
            // �H���񋟃R���{�`�F�b�N
            if (getShortStayRecuperationHealthFacilityDinnerOffer()
                    .getSelectedIndex() == 0) {
                // �l��1�i�Ȃ��j�������ꍇ
                // �H��R���{�̢�����飂�I������B�i�����I���j
                getShortStayRecuperationHealthFacilityDinnerOffer()
                        .setSelectedIndex(1);
            }
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
        // ���H���e�L�X�g�`�F�b�N
        // �H���񋟃R���{�̒l���`�F�b�N����B
        if (getShortStayRecuperationHealthFacilityDinnerOffer()
                .getSelectedIndex() > 0) {
            // �l��1�i�Ȃ��j�ȊO�������ꍇ
            // �H����p(shortStayLifeDinnerCost)�̒l���`�F�b�N����B
            if (ACTextUtilities
                    .isNullText(getShortStayRecuperationHealthFacilityDinnerCost()
                            .getText())) {
                // �l���󔒂������ꍇ
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
        // ���l���z�u�敪�`�F�b�N
        if (getShortStayHospitalRecuperationInstitutionDivisionRadio()
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
        if (getShortStayHospitalRecuperationInstitutionDivisionRadio()
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
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkState() throws Exception {
        // ����ʏ�Ԑ���
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
        switch (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // �l��1�i�a�@�j�������ꍇ
            // �l�����Z�i�T�[�r�X�p�l���j�̒l���`�F�b�N����
            switch (getShortStayHospitalRecuperationPersonSubtraction()
                    .getSelectedIndex()) {
            case 0:
            case 1:
            case 4:
                // �l��1����2����5�i�Ȃ��E������߁E�ƒn�͏o�L�j�������ꍇ
                // ��ʂ̏�Ԃ�ύX����B
                setState_STATE_MODE_1();
                break;
            case 2:
            case 3:
            case 5:
                // �l��3����4����6�i�Ō�E���E���̕s���E���Ŕ䗦��20%�����E�ƒn�͏o���j�������ꍇ
                // ��ʂ̏�Ԃ�ύX����B
                setState_STATE_MODE_2();
                break;
            }
            break;
        case 2:
            // �l��2�i���j�b�g�^�a�@�j�������ꍇ
            // ��ʂ̏�Ԃ�ύX����B
            setState_STATE_MODE_3();
            break;
        case 3:
            // �l��3�i�o�ߌ^�j�������ꍇ
            // �l�����Z�i�T�[�r�X�p�l���j�̒l���`�F�b�N����

            switch (getShortStayHospitalRecuperationPersonSubtraction()
                    .getSelectedIndex()) {
            case 0:
            case 1:
            case 4:
                // �l��1����2����5�i�Ȃ��E������߁E�ƒn�͏o�L�j�������ꍇ
                // ��ʂ̏�Ԃ�ύX����B
                setState_STATE_MODE_4();
                break;
            case 2:
            case 3:
            case 5:
                // �l��3����4����6�i�Ō�E���E���̕s���E���Ŕ䗦��20%�����E�ƒn�͏o���j�������ꍇ
                // ��ʂ̏�Ԃ�ύX����B
                setState_STATE_MODE_5();
                break;
            }

            break;
        case 4:
            // �l��4�i���j�b�g�^�o�ߌ^�j�������ꍇ
            // ��ʂ̏�Ԃ�ύX����B
            setState_STATE_MODE_6();
            break;
        }

        // ���Ə��̐��Ɠ���
        resetStateByRestrictBindPath();

    }

    /**
     * �u�H��e�L�X�g����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkDinnerState() throws Exception {
        // ���H��e�L�X�g��Enable���䏈��
        // �H���񋟁ishortStayRecuperationHealthFacilityDinnerCost�j�̒l���`�F�b�N����B
        if (getShortStayRecuperationHealthFacilityDinnerOffer()
                .getSelectedIndex() == 0) {
            // �l��1�������ꍇ
            // �H���e�L�X�g��Enable�� false �ɂ���B
            setState_DINNER_COST_ENABLE_FALSE();
        } else {
            // �l��1�ȊO�������ꍇ
            // �H���e�L�X�g��Enable�� true �ɂ���B
            setState_DINNER_COST_ENABLE_TRUE();
        }

    }

    /**
     * �u�H����p���v�l�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkMeatCost() throws Exception {
        // ���H�����������ƂɑI�����Ə��ɂ�����H����p��Ԃ��B
        if (getSelectedProvider() != null) {
            // ���Ə������I���inull�j �ł͂Ȃ��ꍇ
            String meat = "";
            switch (getShortStayRecuperationHealthFacilityDinnerOffer()
                    .getSelectedIndex()) {
            case 1:
                // �H���������u������v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��A�u��v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260110", getSelectedProvider()),
                        0));
                break;
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260111", getSelectedProvider()),
                        0));
                break;
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260112", getSelectedProvider()),
                        0));
                break;
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260113", getSelectedProvider()),
                        0));
                break;
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��Ɓu���v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260111", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260112",
                                getSelectedProvider()), 0));
                break;
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��Ɓu��v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260112", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260113",
                                getSelectedProvider()), 0));
                break;
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��Ɓu���v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260113", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260111",
                                getSelectedProvider()), 0));
                break;
            }
            getShortStayRecuperationHealthFacilityDinnerCost().setText(meat);
        } else {
            // ���Ə������I���̏ꍇ
            // �󕶎���Ԃ��B
            getShortStayRecuperationHealthFacilityDinnerCost().setText("");
        }

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
     * �u�f�[�^�o�C���h���̏����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void binded() throws Exception {
        // ���f�[�^�o�C���h���̏���
        // ����f�Ô�{�^���̃f�[�^�̗L�����`�F�b�N����B
        if (getShortStayHospitalRecuperationSpecificConsultationFee()
                .getDataModel().isEmpty()) {
            // ����f�Ô�{�^���̃f�[�^����̏ꍇ
            // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
            getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                    .setText("�ݒ�Ȃ�");
        } else {
            // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
            // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
            getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                    .setText("�ݒ肠��");
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
