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
 * �v���O���� �T�[�r�X�p�^�[�����\�h���K�͑��@�\������ (QS001_17511_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.ComboBoxModel;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRComboBoxModelAdapter;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[�����\�h���K�͑��@�\������(QS001_17511_201804)
 */
@SuppressWarnings("serial")
public class QS001_17511_201804 extends QS001_17511_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_17511_201804() {
        
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");
        
        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1750102", "1750108");
        putImportProviderBindPath("�����}�l�W�����g�̐��������Z", "1750104", "1750110");
        
        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1750105", "1750111"); //[H30.4����]
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u���x�������ԍ��̕\���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
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

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_17511_201804.class.getName(),
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
        // �v���F�藚�����擾
        VRList ninteiList = getCalculater().getPatientInsureInfoHistoryList();
        setIsPrintCheckShow(false);
        // �������ɕ������𑶍݂���ꍇ
        if (ninteiList.size() > 1) {
            VRMap firstHistory = (VRMap) ninteiList.getData(0);
            VRMap secondHistory = (VRMap) ninteiList.getData(1);
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("JOTAI_CODE", firstHistory), 0)) {

            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                // �v���˗v�x��
                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0)) {
                case 12:
                case 13:
                    setIsPrintCheckShow(true);
                    break;
                }
                break;

            case 12:
            case 13:
                // ����̔F�藚���̕ω��̏ꍇ
                if (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", firstHistory), 0) == ACCastUtilities
                        .toInt(VRBindPathParser
                                .get("JOTAI_CODE", secondHistory), 0)) {
                    setIsPrintCheckShow(false);
                    break;
                }
                // �v�x���P�̗v�x���Q
                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0)) {
                case 12:
                case 13:
                    setIsPrintCheckShow(true);
                    break;
                }
                break;

            }
        }
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
        // �E�v���ݒ�@�\
        // �o�[�W�����A�b�v��ꔭ�ڂ̓o���h�p�X�����݂��Ȃ����ߒl������������B
        getTekiyouText().setText("");
        // ��ʂ̃��W�I�̏����l��ݒ肷��B�iselectFirstRadioItem�j
        QkanCommon.selectFirstRadioItem(getThis());
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();

        checkState();

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
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();
            // �����Ə��A��
            // �E���̌����ɂ�錸�Z�i���Ə��p�l���jKEY�F1750101�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1750101", provider), 0)) {
            // �l��1�i�Ȃ��j�������ꍇ
            case 1:
                // defaultMap�� KEY�F1750102 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1750102", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
                // �l��1�ȊO�i�Ō�E���E���E���j�������ꍇ
                // defaultMap�� KEY�F1750102 VALUE�F3�i�Ō�E���E���������j��ݒ肷��B
                VRBindPathParser.set("1750102", defaultMap, new Integer(3));
                break;
            }
            // �����x�������R���{�ݒ�
            // �����ϐ� sqlParam �𐶐�����B
            VRMap sqlParam = new VRHashMap();
            // sqlParam�ɉ��L�̒l���i�[����B
            // KEY�FPROVIDER__ID VALUE�F�I�����Ə��ԍ�
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
            // staffs �����x�������R���{�ɐݒ肷��B
            getKaigoSupportSpecialMemberName().setModel(staffs);

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

            checkState();

            // staffs �̒��ɉ��x�������ԍ��e�L�X�g�̒l�Ɠ���̂��̂����݂��邩�`�F�b�N����B
            // ACBindUtilities.getMatchIndexFromValue();

            // ��v������̂����݂����ꍇ
            // ��v�������x��������\������B
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
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
        // �E�v���̓��̓`�F�b�N
        if (!"".equals(getTekiyouText().getText())) {
            String val = getTekiyouText().getText();
            // 6���ȊO�̏ꍇ
            if (val != null && val.length() != 6) {
                QkanMessageList.getInstance().QS001_ERROR_OF_TEKIYOU_INPUT();
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
     * �u�o�C���h���̏����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void binded() throws Exception {
        // ���o�C���h���̏���
        ComboBoxModel mdl = getKaigoSupportSpecialMemberName().getModel();
        // �����ϐ� src �𐶐�����B
        VRBindSource src = null;
        // src(VRBindSource);
        if (mdl instanceof VRComboBoxModelAdapter) {
            src = ((VRComboBoxModelAdapter) mdl).getAdaptee();
        }
        // ���x�������R���{�ikaigoSupportSpecialMemberName�j���\�[�X���擾�� src �Ɋi�[����B
        // �擾���� src ��VRList�ł��邩�`�F�b�N����B
        if (src instanceof VRList) {
            // VRList�ł������ꍇ
            // ���͂���Ă�����x�������ԍ��ikaigoSupportSpecialMemberNumber�j�ƈ�v����ԍ��� src
            // ���ɑ��݂��邩�`�F�b�N����B
            // getMatchIndexFromValue(src, "CARE_MANAGER_NO", ���͂���Ă�����x�������ԍ�);
            int idx = ACBindUtilities.getMatchIndexFromValue((VRList) src,
                    "CARE_MANAGER_NO", getKaigoSupportSpecialMemberNumber()
                            .getText());
            // ���݂����ꍇ
            // �����ϐ� idx �Ɉ�v�������X�g���ڂ�Index���i�[����B
            // idx �̒l���`�F�b�N����B
            // �l��1���傫�������ꍇ
            // ���x�������R���{�ikaigoSupportSpecialMemberName�j�� idx �Ɠ����ԍ��őI����Ԃɂ���B
            if (idx >= 0) {
                getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
            }
        }

        // �T�[�r�X�p�l���f�[�^�o�C���h����̃p�l���f�[�^�̕ҏW����
        if (this.getParent() instanceof ACPanel) {
            ACPanel panel = (ACPanel) this.getParent();
            // Map����ꂽ�ꍇ
            if (panel.getSource() instanceof VRMap) {
                VRMap source = (VRMap) panel.getSource();

                /*
                 * �o�[�W�����A�b�v����́A�{�[�Ɉ󎚂��Ȃ��`�F�b�N�Ƀf�[�^���Ȃ��ꍇ�̏���
                 */
                if (getIsPrintCheckShow() && !source.containsKey("15")
                        && getCrackOnDayCheck().isSelected()) {
                    // �\������Ă���ɂ��ւ�炸�AKEY���Ȃ��Ȃ�ΑI����Ԃɂ���
                    getPrintable().setSelected(true);
                }
            }
        }
        checkOnDayCheckState();

    }

    /**
     * �����`�F�b�N���̉�ʐ��䏈���ł��B
     * 
     * @throws Exception
     *             ��O����
     */
    public void checkOnDayCheckState() throws Exception {
        if (getIsPrintCheckShow()) {
            if (getCrackOnDayCheck().getValue() == 2) {
                // �����`�F�b�N���L��̏ꍇ
                setState_DAY_CHECK_ON();
            } else {
                // �����`�F�b�N�������̏ꍇ
                setState_DAY_CHECK_OFF();
            }
        } else {
            setState_DAY_CHECK_OFF();
        }
    }

    /**
     * ��ʏ�Ԑ���
     * 
     * @throws Exception
     *             ��O����
     */
    public void checkState() throws Exception {
        checkOnDayCheckState();

    }

    /**
     * �����`�F�b�N���̏���
     * 
     * @throws Exception
     *             ��O����
     */
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        checkOnDayCheckState();

    }

}
