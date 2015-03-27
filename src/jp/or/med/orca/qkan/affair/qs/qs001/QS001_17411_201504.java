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
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�F�m�ǑΉ��^�ʏ���� (QS001_17411_201504)
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
 * �T�[�r�X�p�^�[�����\�h�F�m�ǑΉ��^�ʏ����(QS001_17411_201504)
 */
@SuppressWarnings("serial")
public class QS001_17411_201504 extends QS001_17411_201504Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_17411_201504() {
        
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");
        
        // �l��]�L���鎖�Ə��ݒ荀��
        // 2015.03.06 del putImportProviderBindPath("�ʋ@�\�P���̐�", "1740104", "1740106");
        // 2015.03.06 del putImportProviderBindPath("��������Z", "1740105", "1740105");
        // 2015.03.06 del putImportProviderBindPath("�h�{���P�̐�", "1740106", "1740107");
        // 2015.03.06 del putImportProviderBindPath("���o�@�\����̐�", "1740107", "1740108");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1740109", "1740110");
        
        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1740108", "1740109");
        putRestrictProviderBindPath("�ʋ@�\�P���̐�", "1740104", "1740106");
        putRestrictProviderBindPath("������̐�", "1740105", "1740105");
        putRestrictProviderBindPath("�h�{���P�̐�", "1740106", "1740107");
        putRestrictProviderBindPath("���o�@�\����̐�", "1740107", "1740108");
        
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�J�n���ԑI���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void beginTimeActionPerformed(ActionEvent e) throws Exception {
        // �J�n���ԑI��
        // �@�I�����Ԑݒ菈��
        checkEndTime();

    }

    /**
     * �u�����敪�I���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void timeDivisionRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // �����敪�I��
        // �@�I�����ԍĐݒ菈��
        checkEndTime();

    }

    /**
     * �u�{�݋敪1,2�̘A���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void providerDivisionRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ���{�݋敪1�̏�Ԃɉ����Ď{�݋敪2�̗L����Ԃ�؂�ւ���B
        // �@�{�݋敪1�̏�Ԃɉ����Ď{�݋敪2�̗L����Ԃ�؂�ւ���B
        checkState();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_17411_201504.class.getName(),
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
        // ���J�n����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
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
        // ��ʏ�Ԑ���
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
        // �I�����Ə����null�łȂ��ꍇ
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();
            // ���ݒ�
            // �{�ݓ��̋敪�i���Ə��p�l���jKEY�F1740101�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1740101", provider), 0)) {
            case 1:
                // �l��1�i�P�ƌ^�j�������ꍇ
                // defaultMap�� KEY�F1740101 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1740101", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
                // �l��2�i���݌^�j�A3(�O���[�v�z�[�������p�^)�������ꍇ
                // defaultMap�� KEY�F1740101 VALUE�F2�i����j��ݒ肷��B
                VRBindPathParser.set("1740101", defaultMap, new Integer(2));
                break;
            }
            
            // �E���̌����ɂ�錸�Z�̏󋵁i���Ə��p�l���jKEY�F1740102�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1740102", provider), 0)) {
            case 1:
                // �l��1�i�Ȃ��j�������ꍇ
                // defaultMap�� KEY�F1740104 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1740104", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
                // �l��2����3�������ꍇ�i�Ō�E���E���E���j�������ꍇ
                // defaultMap�� KEY�F1740104 VALUE�F3�i�Ō�E���E���������j��ݒ肷��B
                VRBindPathParser.set("1740104", defaultMap, new Integer(3));
                break;
            }

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // ��ʏ�Ԑ���
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
        return getBeginTime();
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
        return getEndTime();
    }

    /**
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void checkState() throws Exception {
        // ����ʏ�Ԑ��䏈��
        // ���T�[�r�X�A��
        // �{�ݓ��̋敪�P�iproviderDivisionRadio�j�̒l���`�F�b�N����B
        switch (getProviderDivisionRadio().getSelectedIndex()) {
        case 1:
            // �l���P�i�T�^�j�������ꍇ
            // ��ʏ�Ԃ��ʏ�ԂP��ɕύX����B
            setState_STATE_MODE_1();
            break;
        case 2:
            // �l���Q�i�U�^�j�������ꍇ
            // ��ʂ̏�Ԃ��ʏ�ԂQ��ɕύX����B
            setState_STATE_MODE_2();
            break;
        }
        
        // ���Ə��̐��Ɠ���
        resetStateByRestrictBindPath();

    }

    /**
     * �u���ԋ敪�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public int getNintiTusyoTime() throws Exception {
        // �����ԋ敪(gtimeDivisionRadio)�̎��Ԃ��擾
        switch (getTimeDivisionRadio().getSelectedIndex()) {
        // ���ԋ敪(timeDivisionRadio)�̒l���`�F�b�N����B
        case 1:
            // �l��1�i2����3���ԁj�̏ꍇ
            return 180;
        case 2:
            // �l��2�i3����5���ԁj�̏ꍇ
            return 300;
        case 3:
            // �l��3�i5����7���ԁj�̏ꍇ
            return 420;
        case 4:
            // �l��4�i7����9���ԁj�̏ꍇ
            return 540;
        case 5:
            // �l��5�i9����10���ԁj�̏ꍇ
            return 600;
        case 6:
            // �l��6�i10����11���ԁj�̏ꍇ
            return 660;
        case 7:
            // �l��7�i11����12���ԁj�̏ꍇ
            return 720;
        case 8:
            // �P�Q���Ԉȏ�P�R���Ԗ����̏ꍇ
            // �߂�l�Ƃ���780��Ԃ��B
            return 780;
        case 9:
            // �P�R���Ԉȏ�P�S���Ԗ����̏ꍇ
            // �߂�l�Ƃ���840��Ԃ��B
            return 840;
        default:
            // �Y�����ڂ����݂��Ȃ��ꍇ
            // �߂�l�Ƃ���0��Ԃ��B
            return 0;
        }
    }

    /**
     * �u�J�n�E�I�����Ԑݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void checkEndTime() throws Exception {
        // ���J�n�E�I�����ԍĐݒ�
        // �����ϐ� kaigoTime �𐶐�����B
        // �J�n���ԃR���{(beginTime)�̒l�����`�F�b�N����B
        if (getBeginTime().isValidDate()
                && !ACTextUtilities.isNullText(getBeginTime().getText())) {
            // �s���łȂ��ꍇ
            // ���ԑޔ�p�̕ϐ�kaigoTime�ɁA���ԋ敪����擾�������Ԃ�ݒ肷��B
            int kaigoTime = getNintiTusyoTime();
            // �I�����Ԃ��u�J�n���� + kaigoTime(��)�v�ɐݒ肷��B
            getEndTime().setDate(
                    ACDateUtilities.addMinute(getBeginTime().getDate(),
                            kaigoTime));
        }
    }

}
