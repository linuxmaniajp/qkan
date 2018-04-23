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
 * �v���O���� �T�[�r�X�p�^�[���F�m�ǑΉ������������ (QS001_13211_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * �T�[�r�X�p�^�[���F�m�ǑΉ������������(QS001_13211_201804)
 */
@SuppressWarnings("serial")
public class QS001_13211_201804 extends QS001_13211_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_13211_201804() {
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�{�ݓ��̋敪", "1320110", "1320114");
        putImportProviderBindPath("��ԋΖ������", "1320103", "1320106");
        putImportProviderBindPath("��ØA�g�̐����Z", "1320104", "1320107");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1320108", "1320111");

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1320106", "1320109");
        putRestrictProviderBindPath("�F�m�ǐ��P�A���Z", "1320107", "1320110");

    }

    // �R���|�[�l���g�C�x���g

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_13211_201804.class.getName(),
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

        // �l�����Z
        Object obj;
        obj = VRBindPathParser.get("1320102", provider);
        if (obj != null) {
            // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
            switch (ACCastUtilities.toInt(obj)) {
            case 1: // �Ȃ��������ꍇ
                VRBindPathParser.set("1320105", defaultMap, new Integer(1));
                break;
            case 2: // ���]�Ǝ҂������ꍇ
                VRBindPathParser.set("1320105", defaultMap, new Integer(3));
                break;
            }
        }
        
        // ��Ԏx���̐�
        obj = VRBindPathParser.get("1320105", provider);
        if (obj != null) {
            // ���Ə��o�^�̍��ڂɍ��킹�����l�𒲐�
            switch (ACCastUtilities.toInt(obj)) {
            case 1: // �Ȃ�
                VRBindPathParser.set("1320108", defaultMap, new Integer(1));
                break;
            case 2: // ���ZI
            case 3: // ���ZII
                VRBindPathParser.set("1320108", defaultMap, new Integer(2));
                break;
            }
        }
        
        // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - begin
        // �g�̍S�������{���Z
        obj = VRBindPathParser.get("1320111", provider);
        if (obj != null) {
            // �g�̍S�������{��g�݂Ȃ��������ꍇ
            if (ACCastUtilities.toInt(obj) == 1) {
                VRBindPathParser.set("1320116", defaultMap, new Integer(2));
            } else if (ACCastUtilities.toInt(obj) == 2) {
                // �g�̍S�������{��g�݂��肾�����ꍇ
                VRBindPathParser.set("1320116", defaultMap, new Integer(1));
            }
        }
        // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - end

        // ��ʏ�Ԑ���
        changeState();

        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();
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

    @Override
    protected void kaigoHealthCareOfTheAgedCalculationDivisionRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        changeState();
    }

    @Override
    public void changeState() throws Exception {
        // �Z��敪���A���Z�̂ݎZ��ł���ꍇ
        if (getKaigoHealthCareOfTheAgedCalculationDivisionRadio()
                .getSelectedIndex() == 2) {
            // �Ŏ������Z�̑I���󋵂ɂ�鐧��
            switch (getWatchKaigoAddRadioGroup().getSelectedIndex()) {
            case 1: // �Ȃ��I����
                setState_INVALID_TERMINAL();
                break;
            case 2:
            case 3:
            case 4:
                setState_VALID_TERMINAL();
                break;
            }
        } else {
            setState_INVALID_TERMINAL();
        }

    }

    @Override
    public void binded() throws Exception {
        changeState();
    }

    @Override
    protected void watchKaigoAddRadioGroupSelectionChanged(ListSelectionEvent e)
            throws Exception {
        changeState();
    }

}
