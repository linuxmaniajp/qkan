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
 * �쐬��: 2006/02/23  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[��������x�� (QS001117)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRComboBoxModelAdapter;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * �T�[�r�X�p�^�[��������x��(QS001117)
 */
public class QS001117 extends QS001117Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001117() {
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
        ACFrame.debugStart(new ACAffairInfo(QS001117.class.getName(), param));
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
        // �H����
        VRBindPathParser.set("1230406", defaultMap, new Integer(1));
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();

        getKaigoSupportSpecialMemberNumber().setText("");
    }
    
    public void binded()throws Exception{
        super.binded();
        ComboBoxModel mdl = getKaigoSupportSpecialMemberName().getModel();
        VRBindSource src=null;
        if(mdl instanceof VRComboBoxModelAdapter){
            src = ((VRComboBoxModelAdapter)mdl).getAdaptee();
        }
        if (src instanceof VRList) {
            int idx = ACBindUtilities.getMatchIndexFromValue(
                    (VRList)src, "CARE_MANAGER_NO",
                    getKaigoSupportSpecialMemberNumber().getText());
            if(idx>=0){
                getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
            }
        }
    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        if (provider != null) {
            // �I�����Ə����null�łȂ��ꍇ
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = new VRHashMap();
            // ���ݒ�
            Object obj;
            // �敪
            obj = VRBindPathParser.get("1430101", provider);
            if (obj != null) {
                VRBindPathParser.set("1430103", defaultMap, obj);
            }
            // ���莖�Ə��W�����Z
            obj = VRBindPathParser.get("1430102", provider);
            if (obj != null) {
                VRBindPathParser.set("1430104", defaultMap, obj);
            }
            // ���莖�Ə����Z
            obj = VRBindPathParser.get("1430103", provider);
            if (obj != null) {
                VRBindPathParser.set("1430106", defaultMap, obj);
                if(ACCastUtilities.toInt(obj)==1){
                    setTokuteiAddFlag(false);
                }else if(ACCastUtilities.toInt(obj)==2){
                    setTokuteiAddFlag(true);
                }
            }

            // ���x�������R���{
            VRMap sqlParam = new VRHashMap();
            VRBindPathParser.set("PROVIDER_ID", sqlParam, VRBindPathParser.get(
                    "PROVIDER_ID", provider));

            VRList staffs =getDBManager().executeQuery(
                    getSQL_GET_CARE_MANAGER(sqlParam)); 
            Iterator it=staffs.iterator();
            while(it.hasNext()){
                Map staff=(Map)it.next();
                staff.put("STAFF_NAME", QkanCommon.toFullName(staff
                        .get("STAFF_FAMILY_NAME"), staff
                        .get("STAFF_FIRST_NAME")));
            }
            
            getKaigoSupportSpecialMemberName().setModel(
                    staffs);
            // �S���Ґ�(STAFF_FAMILY_NAME)�ƒS���Җ�(STAFF_FIRST_NAME)���������A�R���{�ɕ\������B

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B


            
            if (staffs instanceof VRList) {
                int idx = ACBindUtilities.getMatchIndexFromValue(
                        staffs, "CARE_MANAGER_NO",
                        getKaigoSupportSpecialMemberNumber().getText());
                if(idx>=0){
                    getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
                }
            }
        }
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
        if (ACTextUtilities.isNullText(getKaigoSupportSpecialMemberNumber()
                .getText())) {
            data.remove(getKaigoSupportSpecialMemberNumber().getBindPath());
        }
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
        return null;
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return null;
    }

    /**
     * ����{�ݏW�����Z���W�I�I����
     */
    protected void kaigoSupportSpecificProviderSubtractionRadioActionPerformed(
            ActionEvent e) throws Exception {
        changeState();
    }

    /**
     * ���莖�Ə����Z���W�I�I����
     */
    protected void kaigoSupportSpecificStandardRadioActionPerformed(
            ActionEvent e) throws Exception {
        changeState();
    }

    /**
     * �^�c������Z�I����
     */
    protected void kaigoSupportManagementBasicRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        changeState();
    }
    
    /**
     * �x����敪�I����
     */
    protected void kaigoSupportDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception {     
        changeState();
    }
    
    /**
     * ��ʏ�Ԃ̐���Ɋւ��鏈��
     * @throws Exception
     */
    protected void changeState()throws Exception{
        //�x����敪�Ɋւ���ʐ���
        switch(getKaigoSupportDivisionRadio().getSelectedIndex()){
        case 2://II�^
        case 3://III�^
            //�����Z���Ȃ��ȊO�������ꍇ
            if (getKaigoSupportManagementBasicRadio().getSelectedIndex() == 2
                    || getKaigoSupportManagementBasicRadio()
                            .getSelectedIndex() == 3) {
                setState_STATE_MODE1();
            }else{
                setState_STATE_MODE2();

            }
            break;
        case 1://I�^
        case 4://�o�ߓI�v���
            //�����Z���Ȃ��ȊO�������ꍇ
            if (getKaigoSupportManagementBasicRadio().getSelectedIndex() == 2
                    || getKaigoSupportManagementBasicRadio()
                            .getSelectedIndex() == 3) {
                setState_STATE_MODE1();
            }else{
                //���Ə��W�����Z�Ȃ��������ꍇ
                if(getKaigoSupportSpecificProviderSubtractionRadioItem1().isSelected()){
                    //���莖�Ə����Z���肾�����ꍇ
                    if(getKaigoSupportSpecificStandardRadioItem2().isSelected()){
                        setState_STATE_MODE4();
                    }else{
                        setState_STATE_MODE5();
                    }
                }else{
                    setState_STATE_MODE2();
                }
            }            
            break;
        }
        //���莖�Ə����Z�̐����Ȃ��ꍇ�͈ꗥ�����ɂ���
        if(!getTokuteiAddFlag()){
            setState_PROVIDER_ADD_OFF();
        }
    }

    
}
