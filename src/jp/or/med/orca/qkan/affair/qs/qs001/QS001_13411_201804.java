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
 * �v���O���� �T�[�r�X�p�^�[�����\�h����×{�Ǘ��w�� (QS001_13411_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[�����\�h����×{�Ǘ��w��(QS001_13411_201804)
 */
@SuppressWarnings("serial")
public class QS001_13411_201804 extends QS001_13411_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_13411_201804() {
        
        // ���Ə��̐��̃`�F�b�N�A����Ȃ�
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�E���敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void recuperationManagementGuidanceOccupationalCategoryActionPerformed(
            ActionEvent e) throws Exception {

        changeState();

        setTantosha();
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_13411_201804.class.getName(),
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
        QkanCommon.selectFirstRadioItem(getThis());
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();

        // ����
        changeState();

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
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            changeState();
        }

    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if ((!getRecuperationManagementGuidanceBeginTime().isValidDate())
                || (!getRecuperationManagementGuidanceEndTime().isValidDate())) {
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
        return getRecuperationManagementGuidanceBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getRecuperationManagementGuidanceEndTime();
    }

    /**
     * �u���񋟖����{���Z����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void changeState() throws Exception {

        switch (getRecuperationManagementGuidanceOccupationalCategory()
                .getSelectedIndex()) {
        case 1:
        case 8:
            // ��t�I����
            setState_DOCTOR();
            break;
        case 2:
            // ���Ȉ�t�I����
            setState_DENTAL_DOCTOR();
            break;
        case 3:
            // ��܎t�i��Ë@�ցj�I����
            setState_CHEMIST_HOSPITAL();
            break;
        case 4:
            // ��܎t�A�i��ǁj�I����
            setState_CHEMIST_PHARMACY();
            break;
        case 5:
        case 6:
            // �h�{�m�A���ȉq���m�I����
            setState_DIETICIAN();
            break;
        case 7:
            // �Ō�t
            setState_KANGO();
            break;
        }

        // �E�킪��܎t�i��ǁj�������ꍇ
        if (getRecuperationManagementGuidanceOccupationalCategory()
                .getSelectedIndex() == 4) {
            // [ID:0000466][Masahiko Higuchi] 2009/04 edit begin
            // ����21�N4���@�����Ή�
            // V545�o�׌�̒񎦏��ɂ��x��đΉ�
            setState_VALID_GAN_MAKKI();
            // [ID:0000466][Masahiko Higuchi] 2009/04 edit end
        }
        
    }

    /**
   * 
   */
    protected void recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        changeState();

    }

    /**
     * ���ݒn�敪����I�����̏���
     */
    protected void patientRadioGroupSelectionChanged(ListSelectionEvent e)
            throws Exception {
        changeState();

    }
    
    private void setTantosha() throws Exception {
    	
    	getPatientRadioGroup().getParent().setVisible(true);
    	getPatientOldRadioGroup().getParent().setVisible(false);
    	
        switch (getRecuperationManagementGuidanceOccupationalCategory()
                .getSelectedIndex()) {
        case 1:
            // ��t(I)�I����
        	setUnit1("�i34-1111�F�@507�P�ʁj");
        	setUnit2("�i34-1113�F�@483�P�ʁj");
        	setUnit3("�i34-1115�F�@442�P�ʁj");
            break;
        case 8:
            // ��t(II)�I����
        	setUnit1("�i34-1112�F�@294�P�ʁj");
        	setUnit2("�i34-1114�F�@284�P�ʁj");
        	setUnit3("�i34-1116�F�@260�P�ʁj");
            break;
        case 2:
            // ���Ȉ�t�I����
        	setUnit1("�i34-2111�F�@507�P�ʁj");
        	setUnit2("�i34-2112�F�@483�P�ʁj");
        	setUnit3("�i34-2113�F�@442�P�ʁj");
            break;
        case 3:
            // ��܎t�i��Ë@�ցj�I����
        	setUnit1("�i558�P�ʁj");
        	setUnit2("�i414�P�ʁj");
        	setUnit3("�i378�P�ʁj");
            break;
        case 4:
            // ��܎t�A�i��ǁj�I����
        	setUnit1("�i507�P�ʁj");
        	setUnit2("�i376�P�ʁj");
        	setUnit3("�i344�P�ʁj");
            break;
        case 5:
            // �h�{�m�I����
        	setUnit1("�i34-1131�F�@537�P�ʁj");
        	setUnit2("�i34-1132�F�@483�P�ʁj");
        	setUnit3("�i34-1133�F�@442�P�ʁj");
            break;
        case 6:
            // ���ȉq���m�I����
        	setUnit1("�i34-1241�F�@355�P�ʁj");
        	setUnit2("�i34-1242�F�@323�P�ʁj");
        	setUnit3("�i34-1243�F�@295�P�ʁj");
            break;
        case 7:
            // �Ō�t
        	getPatientRadioGroup().getParent().setVisible(false);
        	getPatientOldRadioGroup().getParent().setVisible(true);
            break;
        }
        //���W�I�{�^���A�C�e���̃e�L�X�g�ύX
        getPatientRadioGroup().refreshRadioButton();
    }
    
    private void setUnit1(String unit) {
    	String tmp = "<html>�P�ꌚ�����Z�ҁi1�l�j<br>%unit%<html>";
    	tmp = tmp.replaceAll("%unit%", unit);
    	getPatientLocationRadioItem1().setText(tmp);
    }
    
    private void setUnit2(String unit) {
    	String tmp = "<html>�P�ꌚ�����Z�ҁi2�`9�l�j<br>%unit%<html>";
    	tmp = tmp.replaceAll("%unit%", unit);
    	getPatientLocationRadioItem2().setText(tmp);
    }
    
    private void setUnit3(String unit) {
    	String tmp = "<html>��L�ȊO<br>%unit%<html>";
    	tmp = tmp.replaceAll("%unit%", unit);
    	getPatientLocationRadioItem3().setText(tmp);
    }
    
}
