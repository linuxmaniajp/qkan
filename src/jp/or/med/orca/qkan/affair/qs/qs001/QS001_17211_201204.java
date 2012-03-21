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
 * �J����: ��� ��F
 * �쐬��: 2011/11/15  ���{�R���s���[�^�[������� ��� ��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���F�m�ǑΉ��^�ʏ���� (QS001_17211_201204)
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
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���F�m�ǑΉ��^�ʏ����(QS001_17211_201204)
 */
@SuppressWarnings("serial")
public class QS001_17211_201204 extends QS001_17211_201204Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_17211_201204() {
        // �`�F�b�N
        putCheckProviderBindPath("���E���������P���Z", "4");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�h�{���P���Z", "1720109", "1720105");
        putImportProviderBindPath("���o�@�\������Z", "1720105", "1720108");
        putImportProviderBindPath("�ʋ@�\�P���̐�", "1720110", "1720107");
        putImportProviderBindPath("������̐�", "1720111", "1720106");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1720108", "1720110");

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�h�{���P���Z", "1720109", "1720105");
        putRestrictProviderBindPath("���o�@�\������Z", "1720105", "1720108");
        putRestrictProviderBindPath("�ʋ@�\�P���̐�", "1720110", "1720107");
        putRestrictProviderBindPath("������̐�", "1720111", "1720106");
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1720107", "1720109");
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�J�n���ԑI���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void beginTimeActionPerformed(ActionEvent e) throws Exception {
        // �J�n���ԑI��
        checkEndTime();

    }

    /**
     * �u�����敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void timeDivisionRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // �����敪�I��
        checkEndTime();

    }

    /**
     * �u�{�݋敪1,2�̘A���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void providerDivisionRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        switch (getProviderDivisionRadio().getSelectedIndex()) {
        case 1:
            // �{�݋敪1��I�^�̏ꍇ
            // �{�݋敪2��L���ɂ���B
            setState_VALID_FACILITY_STATE2();
            break;
        case 2:
            // �{�݋敪1��II�^�̏ꍇ
            // �{�݋敪2�𖳌��ɂ���B
            setState_INVALID_FACILITY_STATE2();
            break;
        }

        // ���Ə��̐��ɂ��L��/�����̍Đݒ�
        resetStateByRestrictBindPath();
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_17211_201204.class.getName(),
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
        // �J�n����
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // �I������
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
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
        // �I�����Ə����null�łȂ��ꍇ
        // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
        // ������
        // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
        VRMap defaultMap = getImportData();
        // ���ݒ�
        Object obj;

        // �{�݋敪1
        // �{�݋敪2
        obj = VRBindPathParser.get("1720101", provider);
        if (obj != null) {
            // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
            switch (ACCastUtilities.toInt(obj)) {
            case 1: //
                VRBindPathParser.set("1720101", defaultMap, new Integer(1));
                VRBindPathParser.set("1720102", defaultMap, new Integer(1));
                break;
            case 2: //
                VRBindPathParser.set("1720101", defaultMap, new Integer(1));
                VRBindPathParser.set("1720102", defaultMap, new Integer(2));
                break;
            case 3: //
                VRBindPathParser.set("1720101", defaultMap, new Integer(2));
                break;
            }
        }

        // �l�����Z
        obj = VRBindPathParser.get("1720103", provider);
        // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
        if (obj != null) {
            switch (ACCastUtilities.toInt(obj)) {
            case 1: // �Ȃ��������ꍇ
                VRBindPathParser.set("1720104", defaultMap, new Integer(1));
                break;
            case 2: // �Ō�E���������ꍇ
            case 3: // ���E���������ꍇ
                VRBindPathParser.set("1720104", defaultMap, new Integer(3));
                break;
            }
        }

        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();

        providerDivisionRadioSelectionChanged(null);
    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if (ACTextUtilities.isNullText(getBeginTime().getText())
                || ACTextUtilities.isNullText(getEndTime().getText())
                || (!getBeginTime().isValidDate())
                || (!getEndTime().isValidDate())) {
            // �J�n�����R���{(houmonKangoIryoBeginTime)�ƏI�������R���{(houmonKangoIryoEndTime)�̂����ꂩ���󗓂��s���̏ꍇ
            // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
            // null��Ԃ��B
            return null;
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
        return getBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getEndTime();
    }

    /**
     * �u�I�����Ԃ̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkEndTime() throws Exception {
        // �����ԑѕύX���A�I�����Ԃ��ύX
        if (getBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getBeginTime().getText()))) {
            // �J�n���ԃR���{(houmonKangoKaigoBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
            int kaigoTime = 0;
            // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
            kaigoTime = getNintiTuusho();

            // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
            getEndTime().setDate(
                    ACDateUtilities.addMinute(getBeginTime().getDate(),
                            kaigoTime));
        }

    }

    /**
     * �u���ԋ敪�̎��Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getNintiTuusho() throws Exception {
        // �����ԋ敪(getTsuusyoKaigoTimeDivision)�̎��Ԃ��擾
        // ���ԋ敪(getTsuusyoKaigoTimeDivision)�̒l���`�F�b�N����B
        switch (getTimeDivisionRadio().getSelectedIndex()) {
        case 1:
            // �Q���Ԉȏ�R���Ԗ����̏ꍇ
            // �߂�l�Ƃ���180��Ԃ��B
            return 180;
        case 2:
            // �R���Ԉȏ�T���Ԗ����̏ꍇ
            // �߂�l�Ƃ���300��Ԃ��B
            return 300;
        case 3:
            // �T���Ԉȏ�V���Ԗ����̏ꍇ
            // �߂�l�Ƃ���420��Ԃ��B
            return 420;
        case 4:
            // �V���Ԉȏ�X���Ԗ����̏ꍇ
            // �߂�l�Ƃ���540��Ԃ��B
            return 540;
        case 5:
            // �X���Ԉȏ�P�O���Ԗ����̏ꍇ
            // �߂�l�Ƃ���600��Ԃ��B
            return 600;
        case 6:
            // �P�O���Ԉȏ�P�P���Ԗ����̏ꍇ
            // �߂�l�Ƃ���660��Ԃ��B
            return 660;
        case 7:
            // �P�P���Ԉȏ�P�Q���Ԗ����̏ꍇ
            // �߂�l�Ƃ���720��Ԃ��B
            return 720;

        }
        return 0;
    }

}
