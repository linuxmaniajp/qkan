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
 * �J����: ��i�a�P
 * �쐬��: 2011/12/12  ���{�R���s���[�^�[������� ��i�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Ō쏬�K�͑��@�\�^������ (QS001_17711_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ComboBoxModel;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
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
 * �T�[�r�X�p�^�[�������^�T�[�r�X�i�Ō쏬�K�͑��@�\�^������E�Z�����p�ȊO�j(QS001_17711_201804)
 */
public class QS001_17711_201804 extends QS001_17711_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_17711_201804() {
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("�E���̌����ɂ�錸�Z�̏�", "1770101");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�T�[�r�X�񋟋������Z", "1770104", "1770111");
        putImportProviderBindPath("�K��Ō�̐����Z", "1770106", "1770118");
        putImportProviderBindPath("�K��Ō�̐��������Z", "1770107", "1770119");
        putImportProviderBindPath("�����}�l�W�����g�̐��������Z", "1770108", "1770120");
        putImportProviderBindPath("�T�e���C�g�̐�", "1770110", "1770121"); //[H30.4����]
        putImportProviderBindPath("�K��̐��������Z", "1770112", "1770124"); //[H30.4����]

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("���ʊǗ��̐�", "1770102", "1770109");
        putRestrictProviderBindPath("�^�[�~�i���P�A�̐�", "1770103", "1770110");
        putRestrictProviderBindPath("�ً}���K��Ō���Z", "1770105", "1770108");
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1770111", "1770122"); //[H30.4����]
    }

    // �R���|�[�l���g�C�x���g

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_17711_201804.class.getName(),
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
        // �s�����Ǝ����Z
        comboItemMap.setData("1770112",
                QkanCommon.getArrayFromMasterCode(284, "1770112"));
        
        // ���J�n����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
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
        
        if (provider == null) {
            return;
        }

        Object obj;
        VRMap defaultMap = getImportData();

        // �l�����Z
        obj = VRBindPathParser.get("1770101", provider);
        if (obj != null) {
            switch (ACCastUtilities.toInt(obj)) {
            case 1: // �Ȃ�
                VRBindPathParser.set("1770101", defaultMap, new Integer(1));
                break;
            case 2: // �Ō�E��
            case 3: // ���E��
                VRBindPathParser.set("1770101", defaultMap, new Integer(3));
                break;
            }
        }
        
        if (VRBindPathParser.get("1770112", provider) == null) {
            VRBindPathParser.set("1770112", defaultMap, new Integer(1));
        }

        // ���x�������R���{
        VRMap sqlParam = new VRHashMap();
        VRBindPathParser.set("PROVIDER_ID", sqlParam,
                VRBindPathParser.get("PROVIDER_ID", provider));

        VRList staffs = getDBManager().executeQuery(
                getSQL_GET_CARE_MANAGER(sqlParam));
        Iterator it = staffs.iterator();
        while (it.hasNext()) {
            Map staff = (Map) it.next();
            staff.put("STAFF_NAME", QkanCommon.toFullName(
                    staff.get("STAFF_FAMILY_NAME"),
                    staff.get("STAFF_FIRST_NAME")));
        }

        getKaigoSupportSpecialMemberName().setModel(staffs);
        
        // �W�J
        getThis().setSource(defaultMap);
        getThis().bindSource();
        
        if (staffs instanceof VRList) {
            int idx = ACBindUtilities.getMatchIndexFromValue(staffs,
                    "CARE_MANAGER_NO", getKaigoSupportSpecialMemberNumber()
                            .getText());
            if (idx >= 0) {
                getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
            }
        }
        
        checkOnDayCheckState();
        
    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        // �E�v���̓��̓`�F�b�N
        if (!"".equals(getTekiyouText().getText())) {
            String val = getTekiyouText().getText();
            // 8���ȊO�̏ꍇ
            if (val != null && val.length() != 8) {
                QkanMessageList.getInstance().QS001_ERROR_OF_TEKIYOU_INPUT_8();
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
        return getHomonNyuyokuBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getHomonNyuyokuEndTime();
    }

    @Override
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        checkOnDayCheckState();
    }
    
    /**
     * �l���o�C���h�����ۂ̏����ł��B
     * 
     * @exception Exception ������O
     */
    public void binded() throws Exception {
        
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
        
        // ��ʏ�Ԑ���
        checkOnDayCheckState();
        
    }
    
    

    @Override
    public void checkOnDayCheckState() throws Exception {
        if (getCrackOnDayCheck().isEnabled()
                && getCrackOnDayCheck().isSelected()) {
            // �����`�F�b�N���L��̏ꍇ
            setState_DAY_CHECK_ON();
        } else {
            // �����`�F�b�N�������̏ꍇ
            setState_DAY_CHECK_OFF();
        }
    }

    /**
     * �u���x�������ԍ��̕\���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    @Override
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

}
