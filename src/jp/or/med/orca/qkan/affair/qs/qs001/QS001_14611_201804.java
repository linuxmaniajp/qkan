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
 * �v���O���� �T�[�r�X�p�^�[�����\�h�x���� (QS001_14611_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.ComboBoxModel;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRComboBoxModelAdapter;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[�����\�h�x����(QS001_14611_201804)
 */
@SuppressWarnings("serial")
public class QS001_14611_201804 extends QS001_14611_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_14611_201804() {
        // �ݒ�Ȃ�
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u���x�������ԍ��i�\�h�x���j�擾�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void careManagerNameComboActionPerformed(ActionEvent e)
            throws Exception {
        // �����x�������ԍ��i�\�h�x���j�擾
        if (getCareManagerNameCombo().isSelected()
                && !ACTextUtilities.isNullText(getCareManagerNameCombo()
                        .getText())) {
            // ���x���������R���{�i�\�h�x���j�őI������Ă���f�[�^���擾
            VRMap data = (VRMap) getCareManagerNameCombo()
                    .getSelectedModelItem();
            // �擾�f�[�^�����x�������ԍ����擾���A�\��
            getCareManagerNoText().setText(
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "CARE_MANAGER_NO", data)));
        }

    }

    /**
     * �u�x�����Ə��i�ϑ���j�I���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void consignmentProviderActionPerformed(ActionEvent e)
            throws Exception {

        // ���x�����Ə��i�ϑ���j�I��
        checkState();
        // �l���N���A
        getConsignmentCareManagerNoText().setText("");
        if (getConsignmentProvider().isSelected()
                && !ACTextUtilities.isNullText(getConsignmentProvider()
                        .getText())) {
            // �����ϐ� sqlParam �𐶐�����B
            VRMap sqlParam = new VRHashMap();
            // sqlParam�ɉ��L�̒l���i�[����B
            // KEY�FPROVIDER__ID VALUE�F�I������Ă��鎖�Ə��ԍ��i�ϑ���j
            sqlParam.put("PROVIDER_ID", VRBindPathParser.get("PROVIDER_ID",
                    (VRMap) getConsignmentProvider().getSelectedModelItem()));

            // �����ϐ� staffs �𐶐�����B
            VRList staffs;
            // ���x�������擾�p��SQL���擾����B
            String sql = getSQL_GET_CARE_MANAGER(sqlParam);
            // staffs �Ɏ擾����SQL�����s�������ʂ��i�[����B
            staffs = getDBManager().executeQuery(sql);
            // �擾����VRList�̒��g�����[�v���Ȃ��琩������������B
            Iterator it = staffs.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                // ���������l�����L��KEY�Ŋi�[����B
                // KEY�FCONSIGNMENT_STAFF_NAME
                VRBindPathParser.set("CONSIGNMENT_STAFF_NAME", row, QkanCommon
                        .toFullName(
                                VRBindPathParser.get("STAFF_FAMILY_NAME", row),
                                VRBindPathParser.get("STAFF_FIRST_NAME", row)));
            }
            // staffs �����x�������R���{�i�ϑ��掖�Ə��j�ɐݒ肷��B
            getConsignmentCareManagerNameCombo().setModel(staffs);
        } else {
            VRList staffs = new VRArrayList();
            getConsignmentCareManagerNameCombo().setModel(staffs);
        }
    }

    /**
     * �u���x�������ԍ��i�ϑ���j�擾�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void consignmentCareManagerNameComboActionPerformed(ActionEvent e)
            throws Exception {
        // �����x�������ԍ��i�ϑ���j�擾
        if (getConsignmentCareManagerNameCombo().isSelected()
                && !ACTextUtilities
                        .isNullText(getConsignmentCareManagerNameCombo()
                                .getText())) {
            // ���x���������R���{�i�ϑ���j�őI������Ă���f�[�^���擾
            VRMap data = (VRMap) getConsignmentCareManagerNameCombo()
                    .getSelectedModelItem();
            // �擾�f�[�^�����x�������ԍ����擾���A�\��
            getConsignmentCareManagerNoText().setText(
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "CARE_MANAGER_NO", data)));
        }
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_14611_201804.class.getName(),
                param));
    }

    // �����֐�

    /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void initialize() throws Exception {
        // ����ʓW�J���̏����ݒ�
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
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
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();

        // ���ϑ��掖�Ə��ݒ�
        // ���ʊ֐� getProviderInfo
        // ���g�p��������x�����Ə��A���K�͑��@�\������x�����Ə��A���\�h�x���A���\�h���K�͑��@�\�^������x����񋟂��Ă��鎖�Ə����擾����B
        // getProviderInfo(���l�z�� 14311,17311,14611,17511);
        // �o�C���h�p�XPROVIDER_ID �� 1460102 �ɐU��Ȃ���
        // [ID:0000724][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� del begin
        //VRList list = (VRList) QkanCommon.getProviderInfo(getDBManager(),
        //        new int[] { 14311, 17311, 14611, 17511 });
        // [ID:0000724][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� del end
        // [ID:0000724][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
        VRList list = (VRList) QkanCommon.getProviderInfo(getDBManager(),
                new int[] { 14311, 17311, 14611, 17511, 17711 });
        // [ID:0000724][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add end

        ACBindUtilities.copyBindPath(list, "PROVIDER_ID", "1460102");
        // �ϑ��掖�Ə���ݒ�
        getConsignmentProvider().setModel(list);
        // �󔒂�ݒ�
        getConsignmentProvider().setSelectedIndex(0);

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        if (provider != null) {
            // �I�����Ə����null�łȂ��ꍇ
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���x�������ԍ����󔒂ɂ���B
            getCareManagerNoText().setText("");
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = new VRHashMap();
            // ���ݒ�
            // �����x�������R���{�ݒ�
            // �����ϐ� sqlParam �𐶐�����B
            VRMap sqlParam = new VRHashMap();
            // sqlParam�ɉ��L�̒l���i�[����B
            // KEY�FPROVIDER_ID VALUE�F���\�h�I�����Ə��ԍ�
            sqlParam.put("PROVIDER_ID",
                    VRBindPathParser.get("PROVIDER_ID", provider));
            // �����ϐ� staffs �𐶐�����B
            VRList staffs;
            // ���x�������擾�p��SQL���擾����B
            String sql = getSQL_GET_CARE_MANAGER(sqlParam);
            // staffs �Ɏ擾����SQL�����s�������ʂ��i�[����B
            staffs = getDBManager().executeQuery(sql);
            // �擾����VRList�̒��g�����[�v���Ȃ��琩������������B
            Iterator it = staffs.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                // ���������l�����L��KEY�Ŋi�[����B
                // KEY�FSTAFF_NAME
                VRBindPathParser.set("STAFF_NAME", row, QkanCommon.toFullName(
                        VRBindPathParser.get("STAFF_FAMILY_NAME", row),
                        VRBindPathParser.get("STAFF_FIRST_NAME", row)));
            }
            // staffs �����x�������R���{�i���\�h�x�����Ə��j�ɐݒ肷��B
            getCareManagerNameCombo().setModel(staffs);
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            checkState();
        }
    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
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
        // �����x�������ԍ����`�F�b�N����B
        // ���ϑ�����x�������ԍ��ƈϑ�����x�����Ə��̒l���`�F�b�N����B
        if (getConsignmentCareManagerNoText().isEnabled()) {
            if (ACTextUtilities.isNullText(getConsignmentCareManagerNoText()
                    .getText())) {
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
                return null;
            }
        } else {
            // �ϑ��掖�Ə������I���̏ꍇ
            // �ϑ��掖�Ə��̃L�[���f�[�^���珜�O����B
            data.remove(getConsignmentProvider().getBindPath());
        }
        // �Е����������͂������ꍇ �������Ƃ������͂̏ꍇ�͖��Ȃ�
        return data;
    }

    /**
     * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public boolean isUseProvider() throws Exception {
        // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
        // �@true��Ԃ��B
        return true;
    }

    /**
     * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ���J�n�������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return null;
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return null;
    }

    /**
     * �u�f�[�^�o�C���h���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void binded() throws Exception {
        // ���f�[�^�o�C���h��
        ComboBoxModel mdl = getCareManagerNameCombo().getModel();
        // �����ϐ� src �𐶐�����B
        // src(VRBindSource);
        VRBindSource src = null;
        // �����ϐ� idx �𐶐�����B
        int idx = 0;
        // ���\�h�x�����x���������I������
        if (mdl instanceof VRComboBoxModelAdapter) {
            src = ((VRComboBoxModelAdapter) mdl).getAdaptee();
        }
        // ���x�������R���{�icareManagerNameCombo�j���\�[�X���擾�� src �Ɋi�[����B
        // �擾���� src ��VRList�ł��邩�`�F�b�N����B
        if (src instanceof VRList) {
            // VRList�ł������ꍇ
            // ���͂���Ă�����x�������ԍ��icareManagerNoText�j�ƈ�v����ԍ��� src ���ɑ��݂��邩�`�F�b�N����B
            // getMatchIndexFromValue(src, "CARE_MANAGER_NO", ���͂���Ă�����x�������ԍ�);
            idx = ACBindUtilities.getMatchIndexFromValue((VRList) src,
                    "CARE_MANAGER_NO", getCareManagerNoText().getText());
            // ���݂����ꍇ
            // �����ϐ� idx �Ɉ�v�������X�g���ڂ�Index���i�[����B
            // idx �̒l���`�F�b�N����B
            // �l��1���傫�������ꍇ
            // ���x�������R���{�ikaigoSupportSpecialMemberName�j�� idx �Ɠ����ԍ��őI����Ԃɂ���B
            if (idx >= 0) {
                getCareManagerNameCombo().setSelectedIndex(idx + 1);
            }
        }

        // ���ϑ�����x���������I������
        // src ������������B
        idx = 0;
        src = null;
        mdl = getConsignmentCareManagerNameCombo().getModel();
        // ���x�������R���{�iconsignmentProvider�j���\�[�X���擾�� src �Ɋi�[����B
        if (mdl instanceof VRComboBoxModelAdapter) {
            src = ((VRComboBoxModelAdapter) mdl).getAdaptee();
        }
        // �擾���� src ��VRList�ł��邩�`�F�b�N����B
        if (src instanceof VRList) {
            // VRList�ł������ꍇ
            // ���͂���Ă�����x�������ԍ��iconsignmentCareManagerNoText�j�ƈ�v����ԍ��� src
            // ���ɑ��݂��邩�`�F�b�N����B
            // getMatchIndexFromValue(src, "CARE_MANAGER_NO", ���͂���Ă�����x�������ԍ�);
            idx = ACBindUtilities.getMatchIndexFromValue((VRList) src,
                    "CARE_MANAGER_NO", getConsignmentCareManagerNoText()
                            .getText());
            // ���݂����ꍇ
            // �����ϐ� idx �Ɉ�v�������X�g���ڂ�Index���i�[����B
            // idx �̒l���`�F�b�N����B
            // �l��1���傫�������ꍇ
            // ���x�������R���{�ikaigoSupportSpecialMemberName�j�� idx+1(�󔒕�������̂�+1�j
            // �Ɠ����ԍ��őI����Ԃɂ���B
            if (idx >= 0) {
                getConsignmentCareManagerNameCombo().setSelectedIndex(idx + 1);
            }
        }

    }

    /**
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void checkState() throws Exception {
        // �ϑ��掖�Ə��R���{�̒l���`�F�b�N����B
        // �ϑ��掖�Ə��R���{�ŋ󔒂��I������Ă����ꍇ
        if (getConsignmentProvider().getSelectedIndex() == 0) {
            // ��ʏ��1
            setState_STATE_MODE_1();
        } else {
            // ��ʏ��2
            setState_STATE_MODE_2();
        }
    }

}
