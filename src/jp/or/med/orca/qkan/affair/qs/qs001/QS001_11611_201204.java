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
 * �v���O���� �T�[�r�X�p�^�[���ʏ����n (QS001_11611_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���ʏ����n(QS001_11611_201204)
 */
@SuppressWarnings("serial")
public class QS001_11611_201204 extends QS001_11611_201204Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_11611_201204() {
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�{�݋敪", "1160112", "1160116");
        putImportProviderBindPath("�������Z", "1160102", "1160105");
        putImportProviderBindPath("�h�{�}�l�W�����g�̐�", "1160116", "1160114");
        putImportProviderBindPath("���o�@�\����̐�", "1160109", "1160115");
        putImportProviderBindPath("�F�m�ǒZ���W�����n�r���e�[�V�������Z", "1160113", "1160120");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1160115", "1160122");

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�������Z", "1160102", "1160105");
        putRestrictProviderBindPath("�h�{�}�l�W�����g�̐�", "1160116", "1160114");
        putRestrictProviderBindPath("���o�@�\����̐�", "1160109", "1160115");
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1160114", "1160121");
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�J�n���ԁv�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonRehabilitationTimeContenaBeginTimeActionPerformed(
            ActionEvent e) throws Exception {
        // �T�[�r�X�񋟎��ԁi�J�n�j�̎��ԋ敪�ύX���̏���
        // �T�[�r�X�񋟎��ԁi�J�n�j�̎��ԋ敪�ύX��
        checkEndTime();

    }

    /**
     * �u�I�����ԁv�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonRehabilitationTimeDivisionActionPerformed(ActionEvent e)
            throws Exception {
        // �T�[�r�X�񋟎��ԁi�I���j�̎��ԋ敪�ύX���̏���
        // �����ԋ敪�ύX���A�I�����Ԃ��ύX
        changeState();
        // �T�[�r�X�񋟎��ԁi�I���j�̎��ԋ敪�ύX��
        checkEndTime();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_11611_201204.class.getName(),
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
        // ���J�n����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F275�i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1160104 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1160104",
                QkanCommon.getArrayFromMasterCode(275, "1160104"));
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
        QkanCommon.selectFirstRadioItem(this);
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
        // �I�����Ə����null�łȂ��ꍇ
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();
            // ���ݒ�
            Object obj;

            // �l�����Z
            obj = VRBindPathParser.get("1160105", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1160109", defaultMap, new Integer(1));
                    break;
                case 2: // ��t�������ꍇ
                case 3: // �Ō�E���������ꍇ
                case 4: // ���E���������ꍇ
                case 5: // ���w�Ö@�m�������ꍇ
                case 6: // ��ƗÖ@�m�������ꍇ
                case 7: // ���꒮�o�m�������ꍇ
                    VRBindPathParser.set("1160109", defaultMap, new Integer(3));
                    break;
                }
            }

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

        }

        // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
        changeState();
    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if (!getHoumonRehabilitationTimeDivision().isSelected()) {
            // ���ԋ�(houmonRehabilitationTimeDivision)�������I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }

        if (ACTextUtilities
                .isNullText(getHoumonRehabilitationTimeContenaBeginTime()
                        .getText())
                || ACTextUtilities
                        .isNullText(getHoumonRehabilitationTimeContenaEndTime()
                                .getText())
                || (!getHoumonRehabilitationTimeContenaBeginTime()
                        .isValidDate())
                || (!getHoumonRehabilitationTimeContenaEndTime().isValidDate())) {
            // �J�n�����R���{(houmonRehabilitationTimeContenaBeginTime)���󗓂��s���̏ꍇ
            // �������͏I�������R���{(houmonRehabilitationTimeContenaEndTime)���󗓂��s���̏ꍇ
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
        return getHoumonRehabilitationTimeContenaBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getHoumonRehabilitationTimeContenaEndTime();
    }

    public void changeState() throws Exception {
        int timeIndex = getHoumonRehabilitationTimeDivision()
                .getSelectedIndex();
        // ���ԋ敪�ɂ���ʐ��䏈��
        switch (timeIndex) {
        case 0: // 1�`2�̏ꍇ
            setState_VALID_PHYSIOTHERAPIST_STRENGTHENED();
            break;
        default:// ��L�ȊO
            setState_INVALID_PHYSIOTHERAPIST_STRENGTHENED();
            break;
        }

        // �F�藚�����擾���A�v���x�S�܂��͂T�̗��p�҂ł��邩�m�F
        boolean overKaigodo4 = false;
        VRList ninteiList = getCalculater().getPatientInsureInfoHistoryList();
        for (int i = 0; i < ninteiList.size(); i++) {
            VRMap nintei = (VRMap) ninteiList.get(i);

            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("JOTAI_CODE", nintei), 0)) {
            case 24: // �v�x���S
            case 25: // �v�x���T
                overKaigodo4 = true;
                break;
            }
        }

        if (overKaigodo4) {
            // �v���x���S�E�T�̏ꍇ�́A�d�x�×{�Ǘ����Z�L�� ����
            // 1�`2���Ԃ̏ꍇ�̂ݗL��
            setState_INVALID_ADD_MEDICAL_MANAGEMENT();
            if (timeIndex >= 1) {
                setState_VALID_ADD_MEDICAL_MANAGEMENT();
            }
        } else {
            // ��L�ȊO�́A�d�x�×{�Ǘ����Z����
            setState_INVALID_ADD_MEDICAL_MANAGEMENT();
        }
    }

    /**
     * �u�I�����Ԃ̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkEndTime() throws Exception {
        // �����ԑѕύX���A�I�����Ԃ��ύX
        // �J�n���ԃR���{(houmonRehabilitationTimeContenaBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
        // ���ԑޔ�p�̕ϐ�kangoTime�ɁA���ԋ敪����擾�������Ԃ�ݒ肷��B

        // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
        if (getHoumonRehabilitationTimeContenaBeginTime().isValidDate()
                && (!ACTextUtilities
                        .isNullText(getHoumonRehabilitationTimeContenaBeginTime()
                                .getText()))) {
            // �J�n���ԃR���{(houmonKangoKaigoBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
            // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
            int kaigoTime = getKaigoTime();

            // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
            getHoumonRehabilitationTimeContenaEndTime().setDate(
                    ACDateUtilities.addMinute(
                            getHoumonRehabilitationTimeContenaBeginTime()
                                    .getDate(), kaigoTime));
        }

    }

    /**
     * �u���ԋ敪�̎��Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getKaigoTime() throws Exception {
        // �����ԋ敪(houmonRehabilitationTimeDivision)�̎��Ԃ��擾
        // ���ԋ敪(houmonRehabilitationTimeDivision)�̒l���`�F�b�N����B
        switch (getHoumonRehabilitationTimeDivision().getSelectedIndex()) {
        case 0:
            // �P���Ԉȏ�Q���Ԗ����̏ꍇ
            // �߂�l�Ƃ���120��Ԃ��B
            return 120;
        case 1:
            // �Q���Ԉȏ�R���Ԗ����̏ꍇ
            // �߂�l�Ƃ���180��Ԃ��B
            return 180;
        case 2:
            // �R���Ԉȏ�S���Ԗ����̏ꍇ
            // �߂�l�Ƃ���240��Ԃ��B
            return 240;
        case 3:
            // �S���Ԉȏ�U���Ԗ����̏ꍇ
            // �߂�l�Ƃ���360��Ԃ��B
            return 360;
        case 4:
            // �U���Ԉȏ�W���Ԗ����̏ꍇ
            // �߂�l�Ƃ���480��Ԃ��B
            return 480;
        case 5:
            // �W���Ԉȏ�X���Ԗ����̏ꍇ
            // �߂�l�Ƃ���540��Ԃ��B
            return 540;
        case 6:
            // �X���Ԉȏ�P�O���Ԗ����̏ꍇ
            // �߂�l�Ƃ���600��Ԃ��B
            return 600;
        }
        return 0;
    }

}
