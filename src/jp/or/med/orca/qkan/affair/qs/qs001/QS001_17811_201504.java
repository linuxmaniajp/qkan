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
 * �J����: �����@���̂�
 * �쐬��: 2016/01/27  MIS��B������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���n�斧���^�ʏ���� (QS001_17811_201504)
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
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���n�斧���^�ʏ����(QS001_17811_201504)
 */
@SuppressWarnings("serial")
public class QS001_17811_201504 extends QS001_17811_201504Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_17811_201504() {
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�����", "1780104", "1780104");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1780113", "1780114");
        putImportProviderBindPath("���d�x�҃P�A�̐����Z", "1780105", "1780105");
        

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�����", "1780104", "1780104");
        putRestrictProviderBindPath("�h�{���P�̐�", "1780109", "1780110");
        putRestrictProviderBindPath("���o�@�\������Z", "1780110", "1780111");
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1780108", "1780109");
        putRestrictProviderBindPath("�ʋ@�\�P���̐�", "1780106", "1780106");
        putRestrictProviderBindPath("�ʋ@�\�P���̐�", "1780106", "1780107");
        putRestrictProviderBindPath("�F�m�ǉ��Z", "1780107", "1780108");
        putRestrictProviderBindPath("�ʑ��}�̐��������Z", "1780111", "1780112");
        putRestrictProviderBindPath("������̐��������Z", "1780112", "1780113");
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void tsuusyoKaigoTimeContenaFacilityDivisionActionPerformed(
            ActionEvent e) throws Exception {
        // �{�݋敪�I�����̏���
        // �{�݋敪�I����
        VRMap comboItemMap;
        switch (getTsuusyoKaigoTimeContenaFacilityDivision().getSelectedIndex()) {
        case 1:
            // �n�斧���^
            setState_STATE_SMALL();
            comboItemMap = new VRHashMap();
            // �R�[�h�}�X�^�f�[�^���CODE_ID�F40�i���ԋ敪�j���擾����B
            // �擾�����l���AcomboItemMap�� KEY : 1780102 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1780102",
                    QkanCommon.getArrayFromMasterCode(40, "1780102"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();
            break;
        case 2:
            // �×{�ʏ��I����
            setState_STATE_RYOYO();
            comboItemMap = new VRHashMap();
            // �R�[�h�}�X�^�f�[�^���CODE_ID�F40�i���ԋ敪�j���擾����B
            // �擾�����l���AcomboItemMap�� KEY : 1780102 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1780102",
                    QkanCommon.getArrayFromMasterCode(238, "1780102"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();
            break;
        }
        
        // ��L�����ŗL���ɂȂ����R���g���[���ł��A���Ə��̐��Ő�����󂯂���̂͏㏑���Ő��䂷��B
        resetStateByRestrictBindPath();

        // �F�m�ǉ��Z���ݒ肳��Ă����疳���ɂ���B����ȊO�͂Ȃɂ����Ȃ��B
    	if (getDementiaElderlyAccepted().isEnabled() == true && getDementiaElderlyAccepted().getSelectedIndex() == 2) {
    		setState_INVALID_YOUNG_DEMENTIA_PATINET();
    	}

    }

    /**
     * �u�J�n�����I�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void tsuusyoKaigoTimeBeginTimeActionPerformed(ActionEvent e)
            throws Exception {
        // �J�n������I�������ꍇ�̏���
        checkEndTime();

    }

    /**
     * �u�����敪�I�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void tsuusyoKaigoTimeDivisionActionPerformed(ActionEvent e)
            throws Exception {
        // �����敪�I������
        checkEndTime();

    }

    /**
     * �u�F�m�ǉ��Z�I�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void dementiaElderlyAcceptedActionPerformed(
            ActionEvent e) throws Exception {
    	// �F�m�ǉ��Z����̏ꍇ�A��N���F�m�Ǘ��p�Ҏ�����Z�͎Z��s��
    	if (getDementiaElderlyAccepted().getSelectedIndex() == 2) {
    		setState_INVALID_YOUNG_DEMENTIA_PATINET();
    	} else {
    		setState_VALID_YOUNG_DEMENTIA_PATINET();
    	}
    }
    
    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_17811_201504.class.getName(),
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
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F40�i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1780102 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1780102",
                QkanCommon.getArrayFromMasterCode(40, "1780102"));
        // ���W�J
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();
        // ���I�����ڂ̏����ݒ�
        QkanCommon.selectFirstRadioItem(this);
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
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();
            // ���ݒ�
            Object obj;

            // �{�ݓ��̋敪
            obj = VRBindPathParser.get("1780101", provider);
            if (obj != null) {
            	VRBindPathParser.set("1780101", defaultMap, ACCastUtilities.toInt(obj, 1));
            }

            // �l�����Z
            obj = VRBindPathParser.get("1780102", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1780103", defaultMap, new Integer(1));
                    break;
                case 2: // ��t�������ꍇ
                case 3: // �Ō�E���������ꍇ
                    VRBindPathParser.set("1780103", defaultMap, new Integer(3));
                    break;
                }
            }

            // �ʋ@�\�P���w�����Z
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1780106", provider), 1)) {
            case 2: // I�^
                VRBindPathParser.set("1780106", defaultMap, new Integer(2));
                break;
            case 3: // II�^
                VRBindPathParser.set("1780107", defaultMap, new Integer(2));
                break;
            }
            
            // �̐��������Ă��Ȃ���I������B
            // �h�{���P�̐�
            VRBindPathParser.set("1780110", defaultMap, new Integer(1));
            // ���o�@�\������Z
            VRBindPathParser.set("1780111", defaultMap, new Integer(1));
            // �F�m�ǉ��Z���ݒ肳��Ă����疳���ɂ���B����ȊO�͂Ȃɂ����Ȃ��B
            if (getDementiaElderlyAccepted().isEnabled() == true && getDementiaElderlyAccepted().getSelectedIndex() == 2) {
                setState_INVALID_YOUNG_DEMENTIA_PATINET();
            }
            
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

            resetStateByRestrictBindPath();
        }

    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if (!getTsuusyoKaigoTimeDivision().isSelected()) {
            // ���ԋ敪(tsuusyoKaigoTimeDivision)�����I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if (ACTextUtilities
                .isNullText(getTsuusyoKaigoTimeBeginTime().getText())
                || ACTextUtilities.isNullText(getTsuusyoKaigoTimeEndTime()
                        .getText())
                || (!getTsuusyoKaigoTimeBeginTime().isValidDate())
                || (!getTsuusyoKaigoTimeEndTime().isValidDate())) {
            // �J�n�����R���{(tsuusyoKaigoTimeBeginTime)�ƏI�������R���{(tsuusyoKaigoTimeEndTime)�̂����ꂩ���󗓂������͕s���̏ꍇ
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
        return getTsuusyoKaigoTimeBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getTsuusyoKaigoTimeEndTime();
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
        if (getTsuusyoKaigoTimeBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getTsuusyoKaigoTimeBeginTime()
                        .getText()))) {
            int kaigoTime = 0;
            // �J�n���ԃR���{(houmonKangoKaigoBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
            // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
            if (getTsuusyoKaigoTimeContenaFacilityDivisionItem2().isSelected()) {
                kaigoTime = getRyouyoTuusyoKaigoTime();
            } else {
                kaigoTime = getKaigoTime();
            }
            // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
            getTsuusyoKaigoTimeEndTime().setDate(
                    ACDateUtilities.addMinute(getTsuusyoKaigoTimeBeginTime()
                            .getDate(), kaigoTime));
        }

    }

    /**
     * �u���ԋ敪�̎��Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getKaigoTime() throws Exception {
        // �����ԋ敪(getTsuusyoKaigoTimeDivision)�̎��Ԃ��擾
        // ���ԋ敪(getTsuusyoKaigoTimeDivision)�̒l���`�F�b�N����B
        switch (getTsuusyoKaigoTimeDivision().getSelectedIndex()) {
        case 0:
            // �Q���Ԉȏ�R���Ԗ����̏ꍇ
            // �߂�l�Ƃ���180��Ԃ��B
            return 180;
        case 1:
            // �R���Ԉȏ�T���Ԗ����̏ꍇ
            // �߂�l�Ƃ���300��Ԃ��B
            return 300;
        case 2:
            // �T���Ԉȏ�V���Ԗ����̏ꍇ
            // �߂�l�Ƃ���420��Ԃ��B
            return 420;
        case 3:
            // �V���Ԉȏ�X���Ԗ����̏ꍇ
            // �߂�l�Ƃ���540��Ԃ��B
            return 540;
        case 4:
            // �X���Ԉȏ�P�O���Ԗ����̏ꍇ
            // �߂�l�Ƃ���600��Ԃ��B
            return 600;
        case 5:
            // �P�O���Ԉȏ�P�P���Ԗ����̏ꍇ
            // �߂�l�Ƃ���660��Ԃ��B
            return 660;
        case 6:
            // �P�P���Ԉȏ�P�Q���Ԗ����̏ꍇ
            // �߂�l�Ƃ���720��Ԃ��B
            return 720;
        case 7:
            // �P�Q���Ԉȏ�P�R���Ԗ����̏ꍇ
            // �߂�l�Ƃ���780��Ԃ��B
            return 780;
        case 8:
            // �P�R���Ԉȏ�P�S���Ԗ����̏ꍇ
            // �߂�l�Ƃ���840��Ԃ��B
            return 840;
        }
        return 0;
    }

    public int getRyouyoTuusyoKaigoTime() throws Exception {
        // �����ԋ敪(getTsuusyoKaigoTimeDivision)�̎��Ԃ��擾
        // ���ԋ敪(getTsuusyoKaigoTimeDivision)�̒l���`�F�b�N����B
        switch (getTsuusyoKaigoTimeDivision().getSelectedIndex()) {
        case 0:
            // �R���Ԉȏ�U���Ԗ����̏ꍇ
            // �߂�l�Ƃ���180��Ԃ��B
            return 360;
        case 1:
            // �U���Ԉȏ�W���Ԗ����̏ꍇ
            // �߂�l�Ƃ���480��Ԃ��B
            return 480;
        }
        return 0;
    }

}
