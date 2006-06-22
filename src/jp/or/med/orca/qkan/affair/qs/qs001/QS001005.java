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
 * �J����: �� ����
 * �쐬��: 2006/01/10  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K��Ō�i���) (QS001005)
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
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���K��Ō�i���)(QS001005)
 */
public class QS001005 extends QS001005Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001005() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�K��Ō�w�����̉��Z�̐ݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoFacilityTypeActionPerformed(ActionEvent e)
            throws Exception {
        // ���u�K��Ō�{�ݎ�ʁv�ɉ����āA�u���w�Ö@�m���͍�ƗÖ@�m�v��ݒ�
        // �u�K��Ō�{�ݎ�ʁv���`�F�b�N�̒l���`�F�b�N����B
        switch (getHoumonKangoKaigoClass().getSelectedIndex()) {
        case 1:
            // �u�w��K��Ō�X�e�[�V�����v�̏ꍇ
            // �u���w�Ö@�m���͍�ƗÖ@�m�v��L���ɂ���B
            setState_VALID_HOMON_KANGO_PTOT();
            break;
        case 2:
            // �u�a�@���͐f�Ï��v�̏ꍇ
            // �u���w�Ö@�m���͍�ƗÖ@�m�v�𖳌��ɂ���B
            setState_INVALID_HOMON_KANGO_PTOT();
            break;
        }
    }

    /**
     * �u�J�n���ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoBeginTimeActionPerformed(ActionEvent e)
            throws Exception {
        // ���J�n���ԕύX���A�I�����Ԃ��ύX
        // �I�����Ԃ��u�J�n���� + �K��Ō쎞��(��)�v�ɐݒ肷��B
        checkEndTime();

    }

    /**
     * �u���ԑѕύX���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoTimeZoneActionPerformed(ActionEvent e)
            throws Exception {
        // �����ԑѕύX���A�J�n���Ԃ��ύX
        // // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
        // int kaigoTime = getKaigoTime();

        // �K��Ō��쎞�ԑ�(houmonKaigoTimeZone)�̒l���`�F�b�N����B
        switch (getHoumonKangoKaigoTimeZone().getSelectedIndex()) {
        case 1:
            // �ʏ�̏ꍇ
            // �J�n���Ԃ�9:00�ɂ���B
            getHoumonKangoKaigoBeginTime().setText("9:00");
            break;
        case 2:
            // �����̏ꍇ
            // �J�n���Ԃ�6:00�ɂ���B
            getHoumonKangoKaigoBeginTime().setText("6:00");
            break;
        case 3:
            // ��Ԃ̏ꍇ
            // �J�n���Ԃ�18:00�ɂ���B
            getHoumonKangoKaigoBeginTime().setText("18:00");
            break;
        case 4:
            // �[��̏ꍇ
            // �J�n���Ԃ�22:00�ɂ���B
            getHoumonKangoKaigoBeginTime().setText("22:00");
            break;
        }
        // �I�����Ԃ��u�J�n���� + �K��Ō쎞��(��)�v�ɐݒ肷��B
        checkEndTime();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        ACFrame.debugStart(new ACAffairInfo(QS001005.class.getName()));
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

        // ���J�n����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ���R���{�A�C�e���̐ݒ�
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();

        // ���I�����ڂ̏����ݒ�
        // �K��Ō�E���敪(houmonKangoKaigoClass)�́u���Łv��I������B
        getHoumonKangoKaigoClass().setSelectedIndex(1);
        // �K��Ō쎞�ԋ敪(houmonKangoKaigoTime)�́u30���ȏ�A1���Ԗ����v��I������B
        getHoumonKangoKaigoTime().setSelectedIndex(2);
        // �K��Ō��쎞�ԑ�(houmonKangoKaigoTimeZone)�́u�ʏ�v��I������B
        getHoumonKangoKaigoTimeZone().setSelectedIndex(1);
//        // ���w�Ö@�m�A��ƗÖ@�m���ɂ��K��Ō�w�����̉��Z(houmonKangoKaigoPTAndOTRadio)�́u�Ȃ��v��I������B
//        getHoumonKangoKaigoPTAndOTRadio().setSelectedIndex(1);
        // �ً}���K��Ō���Z(houmonKangoKaigoUrgentTimeRadio)�́u�Ȃ��v��I������B
        getHoumonKangoKaigoUrgentTimeRadio().setSelectedIndex(1);
        // ���ʊǗ����Z(houmonKangoKaigoSpecialManageRadio)�́u�Ȃ��v��I������B
        getHoumonKangoKaigoSpecialManageRadio().setSelectedIndex(1);
        // �^�[�~�i���P�A���Z(houmonKangoKaigoTerminalRadio)�́u�Ȃ��v��I������B
        getHoumonKangoKaigoTerminalRadio().setSelectedIndex(1);

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param provider VRMap
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            Object obj;
            // �K��Ō�{�ݎ��
            obj = VRBindPathParser.get("1130101", provider);
            if (obj != null) {
                getHoumonKangoKaigoFacilityType().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            //�ً}���K��Ō���Z
            obj = VRBindPathParser.get("1130104", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 1) {
                    // �Ȃ�
                    setState_INVALID_URGENT_TIME_RADIO();
                } else {
                    // ����
                    setState_VALID_URGENT_TIME_RADIO();
                }
            }
            // ���ʊǗ��̐�
            obj = VRBindPathParser.get("1130102", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 1) {
                    // �Ȃ�
                    setState_INVALID_SPECIAL_MANAGE_RADIO();
                } else {
                    // ����
                    setState_VALID_SPECIAL_MANAGE_RADIO();
                }
            }

        }
    }

    /**
     * �u�K��Ō쎞�Ԃ̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getKaigoTime() throws Exception {
        // ���K��Ō쎞�ԋ敪���A���Ԃ��擾
        // �u�K��Ō쎞�ԋ敪(houmonKangoKaigoTime)�v�̒l���`�F�b�N����B
        switch (getHoumonKangoKaigoTime().getSelectedIndex()) {
        case 1:
            // 30�������̏ꍇ
            // �߂�l�Ƃ���30��Ԃ��B
            return 30;
        case 2:
            // 30���ȏ�A1���Ԗ����̏ꍇ
            // �߂�l�Ƃ���60��Ԃ��B
            return 60;
        case 3:
            // 1���Ԉȏ�A1���Ԕ������̏ꍇ
            // �߂�l�Ƃ���90��Ԃ��B
            return 90;
        }
        return 0;
    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return VRMap
     */
    public VRMap getValidData() throws Exception {

        if (ACTextUtilities.isNullText(getHoumonKangoKaigoBeginTime().getText())||
                ACTextUtilities.isNullText(getHoumonKangoKaigoEndTime().getText())||
                (!getHoumonKangoKaigoBeginTime().isValidDate())
                || (!getHoumonKangoKaigoEndTime().isValidDate())) {
            // �J�n�����R���{(houmonKangoKaigoBeginTime)�ƏI�������R���{(houmonKangoKaigoEndTime)�̂����ꂩ���󗓂��s���̏ꍇ
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
        if (!getHoumonKangoKaigoSpecialManageRadio().isEnabled()) {
            // ���ʊǗ��̐�(houmonKangoKaigoSpecialManageRadio)�������̏ꍇ
            // �ԋp�p���R�[�h����A���ʊǗ��̐�(houmonKangoKaigoSpecialManageRadio)��bindPath����������B
            data.remove(getHoumonKangoKaigoSpecialManageRadio().getBindPath());
        }

        // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
        return data;

    }

    /**
     * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return boolean
     */
    public boolean isUseProvider() throws Exception {
        // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
        // true��Ԃ��B
        return true;
    }

    /**
     * �u�K��Ō쎞�ԋ敪�ύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoTimeActionPerformed(ActionEvent e)
            throws Exception {
        // ���J�n���ԕύX���A�I�����Ԃ��ύX
        // �I�����Ԃ��u�J�n���� + �K��Ō쎞��(��)�v�ɐݒ肷��B
        checkEndTime();
    }

    /**
     * �u�I�����Ԃ̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkEndTime() throws Exception {
        // ���J�n���ԕύX���A�I�����Ԃ��ύX
        if (getHoumonKangoKaigoBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getHoumonKangoKaigoBeginTime()
                        .getText()))) {
            // �J�n���ԃR���{(houmonKangoKaigoBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
            // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
            int kaigoTime = getKaigoTime();

            // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
            getHoumonKangoKaigoEndTime().setDate(
                    ACDateUtilities
                            .addMinute(
                                    getHoumonKangoKaigoBeginTime().getDate(),
                                    kaigoTime));
        }
    }

    /**
     * �J�n�������͗p�̃R���{��Ԃ��܂��B
     * @return �J�n�������͗p�̃R���{
     */
   public ACComboBox getBeginTimeCombo() {
       // ���J�n�������͗p�̃R���{��Ԃ��B
       // �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return getHoumonKangoKaigoBeginTime();
    }

   /**
    * �I���������͗p�̃R���{��Ԃ��܂��B
    * @return �I���������͗p�̃R���{
    */
    public ACComboBox getEndTimeCombo() {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getHoumonKangoKaigoEndTime();
    }

}
