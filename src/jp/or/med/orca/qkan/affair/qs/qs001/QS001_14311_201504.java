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
 * �v���O���� �T�[�r�X�p�^�[��������x�� (QS001_14311_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRComboBoxModelAdapter;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * �T�[�r�X�p�^�[��������x��(QS001_14311_201504)
 */
@SuppressWarnings("serial")
public class QS001_14311_201504 extends QS001_14311_201504Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_14311_201504() {
        // �`�F�b�N
        putCheckProviderBindPath("���莖�Ə����Z", "1430104");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("���莖�Ə����Z", "1430104", "1430106");
        putImportProviderBindPath("���莖�Ə��W�����Z", "1430102", "1430104");// 2015.03.04 add
        
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u���x�������ԍ��̕\���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoSupportSpecialMemberNameActionPerformed(ActionEvent e)
            throws Exception {
        // �����x�������ԍ��̕\��
        if (getKaigoSupportSpecialMemberName().isSelected()) {
            // �R���{�őI������Ă���f�[�^���擾
            VRMap data = (VRMap) getKaigoSupportSpecialMemberName()
                    .getSelectedModelItem();

            // �擾�f�[�^�����x�������ԍ����擾���A�\��
            getKaigoSupportSpecialMemberNumber().setText(
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "CARE_MANAGER_NO", data)));
        }

    }

    public void binded() throws Exception {
        super.binded();
        ComboBoxModel mdl = getKaigoSupportSpecialMemberName().getModel();
        VRBindSource src = null;
        if (mdl instanceof VRComboBoxModelAdapter) {
            src = ((VRComboBoxModelAdapter) mdl).getAdaptee();
        }
        if (src instanceof VRList) {
            int idx = ACBindUtilities.getMatchIndexFromValue((VRList) src,
                    "CARE_MANAGER_NO", getKaigoSupportSpecialMemberNumber()
                            .getText());
            if (idx >= 0) {
                getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
            }
        }
    }

    /**
     * �u�^�c������Z�I�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoSupportManagementBasicRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // �^�c������Z�I����
        changeState();

    }

    /**
     * �u�x����敪�I�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoSupportDivisionRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // �x����敪�I����
        changeState();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_14311_201504.class.getName(),
                param));
    }

    // �����֐�

    /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // ����ʏ���������
        // ���R���{�A�C�e���̐ݒ�
        // �@������
        // �@�@�R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // �@���ݒ�
        // �@���W�J
        // �@�@���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �@�@�R���{�A�C�e����W�J����B
        getThis().bindModelSource();
        // ���I�����ڂ̏����ݒ�
        // �@������
        // �@�@�����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
        VRMap defaultMap = new VRHashMap();
        // �@���ݒ�
        // �@���W�J
        // �@�@���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �@�@�����I�����ڂ�W�J����B
        getThis().bindSource();

        QkanCommon.selectFirstRadioItem(this);

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        // �I�����Ə����null�łȂ��ꍇ
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();
            // ���ݒ�
            Object obj;

            // ���ʒn����Z���擾����
            obj = VRBindPathParser.get("SPECIAL_AREA_FLAG", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 1) {
                    setTokuteiAddFlag(false);
                } else if (ACCastUtilities.toInt(obj) == 2) {
                    setTokuteiAddFlag(true);
                }
            }

            // ���R�Ԓn�掖�Ə��ł��邩�̔��胍�W�b�N
            String providerID = ACCastUtilities.toString(
                    ((VRMap) provider).getData("PROVIDER_ID"), "");
            //
            VRList serviceInfo = QkanCommon.getProviderServiceDetail(
                    getDBManager(), providerID,
                    ACCastUtilities.toInt("14311", 0));

            if (serviceInfo != null && serviceInfo.getData(0) instanceof VRMap) {
                VRMap providerServiceInfo = (VRMap) serviceInfo.getData(0);
                // ���R�Ԓn�擙�̏��K�͎��Ə��ł���ꍇ
                if (CareServiceCommon.isMountainousArea(providerServiceInfo)) {
                    setIsMountainousAreaProvider(true);
                } else {
                    setIsMountainousAreaProvider(false);
                }
            } else {
                // ���R�Ԓn�擙�̏��K�͎��Ə��ł͂Ȃ�
                setIsMountainousAreaProvider(false);
            }

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // ���x�������R���{
            VRMap sqlParam = new VRHashMap();
            VRBindPathParser.set("PROVIDER_ID", sqlParam,
                    VRBindPathParser.get("PROVIDER_ID", provider));

            VRList staffs = getDBManager().executeQuery(
                    getSQL_GET_CARE_MANAGER(sqlParam));
            Iterator<Map<String, String>> it = staffs.iterator();
            while (it.hasNext()) {
                Map<String, String> staff = it.next();
                staff.put("STAFF_NAME", QkanCommon.toFullName(
                        staff.get("STAFF_FAMILY_NAME"),
                        staff.get("STAFF_FIRST_NAME")));
            }

            getKaigoSupportSpecialMemberName().setModel(staffs);

            if (staffs instanceof VRList) {
                int idx = ACBindUtilities.getMatchIndexFromValue(staffs,
                        "CARE_MANAGER_NO", getKaigoSupportSpecialMemberNumber()
                                .getText());
                if (idx >= 0) {
                    getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
                }
            }

        }
        // ��ʏ�Ԑ���
        changeState();
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
        // �@���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
        getThis().setSource(data);
        // �@���g(this)��applySource���Ăяo���ăf�[�^�����W����B
        getThis().applySource();
        // ���ԋp�p���R�[�h����s�v�ȃL�[������
        // ���ԋp�p���R�[�h����s�v�ȃL�[������
        QkanCommon.removeDisabledBindPath(getThis(), data);
        if (ACTextUtilities.isNullText(getKaigoSupportSpecialMemberNumber()
                .getText())) {
            data.remove(getKaigoSupportSpecialMemberNumber().getBindPath());
        }
        // �@���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
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
     * ��ʏ�Ԑ�����s���܂��B
     * 
     */
    public void changeState() throws Exception {
        if (getKaigoSupportDivisionRadio().getSelectedIndex() == 3) {
            // �^�c����Z
            if (getKaigoSupportManagementBasicRadio().getSelectedIndex() == 2) {
                boolean isSyucyu = false;
                // �������_�̗v���F�藚�����擾
                Date endDate = ACDateUtilities.toLastDayOfMonth(getCalculater()
                        .getTargetDate());
                VRMap ninteiMap = getCalculater()
                        .getPatientInsureInfoOnTargetDay(endDate);

                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", ninteiMap), 0)) {
                case 12: // �v�x���̏ꍇ �������Q�l��
                case 13:
                    Date firstDate = ACDateUtilities
                            .toFirstDayOfMonth(getCalculater().getTargetDate());
                    ninteiMap = getCalculater()
                            .getPatientInsureInfoOnTargetDay(firstDate);
                    break;
                }
                // �ŏI���菈��
                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", ninteiMap), 0)) {
                case 12: // �v�x���̏ꍇ �������Q�l��
                case 13:
                    break;
                case 21: // �v���1-2
                case 22:
                    break;
                case 23: // �v���3-5
                case 24:
                case 25:
                    // ���ʒn��E���R�Ԓn��̏ꍇ
                    if (getTokuteiAddFlag() || getIsMountainousAreaProvider()) {
                        isSyucyu = true;
                    } else {
                        // �ʏ�̏ꍇ
                        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟂�����̏ꍇ
                        if (getProviderAddMountainousAreaRafioRadioGroup()
                                .getSelectedIndex() == 2) {
                            isSyucyu = true;
                        }
                    }
                    break;
                }

                // �W�����Z���g���邩���Ȃ�
                if (isSyucyu) {
                    setState_PROVIDER_CUT_ON();
                } else {
                    setState_PROVIDER_CUT_OFF();
                }
            } else {
                setState_PROVIDER_CUT_ON();
            }
        } else {
            setState_PROVIDER_CUT_ON();
        }

        // �^�c����Z�ɂ�鏉����Z�̐���
        switch (getKaigoSupportManagementBasicRadio().getSelectedIndex()) {
        case 1:
            // �މ@�E�ޏ������Z���Ȃ��ł���ΗL���ɂ���
            if (getDischargeAddRadio().getSelectedIndex() == 1) {
                setState_VALID_SYOKAI_ADD();
            }
            break;
        case 2:
        case 3:
            setState_INVALID_SYOKAI_ADD();
            break;
        }

        resetStateByRestrictBindPath();
    }

    /**
     * �މ@�E�ޏ����Z�̉�ʐ��䏈��
     */
    protected void dischargeAddRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        if (getDischargeAddRadio().getSelectedIndex() == 1) {
            // �^�c����Z�ɂ�鏉����Z�̐���
            if (getKaigoSupportManagementBasicRadio().getSelectedIndex() == 1) {
                setState_VALID_SYOKAI_ADD();
            }
        } else {
            setState_INVALID_SYOKAI_ADD();
        }

    }

    /**
     * ������Z�I�����̉�ʐ��䏈��
     */
    protected void kaigoSupportStandardRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        if (getKaigoSupportStandardRadio().getSelectedIndex() == 1) {
            setState_VALID_TAIIN_ADD();
        } else {
            setState_INVALID_TAIIN_ADD();
        }

    }

    protected void providerAddMountainousAreaRafioRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ��ʏ�Ԃ𐧌䂷��B
        changeState();

    }
}
