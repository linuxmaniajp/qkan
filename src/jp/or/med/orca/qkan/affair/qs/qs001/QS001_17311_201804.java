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
 * �v���O���� �T�[�r�X�p�^�[�����K�͑��@�\�^��� (QS001_17311_201804)
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
 * �T�[�r�X�p�^�[�����K�͑��@�\�^���(QS001_17311_201804)
 */
@SuppressWarnings("serial")
public class QS001_17311_201804 extends QS001_17311_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_17311_201804() {
        // �`�F�b�N
        putCheckProviderBindPath("���E���������P���Z", "4");
        
    	// �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�Ō�E���z�u���Z", "1730102", "1730108");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1730103", "1730110");
        // 2015.03.06 del putImportProviderBindPath("�Ŏ��A�g�̐����Z", "1730106", "1730113");
        putImportProviderBindPath("�K��̐��������Z", "1730107", "1730114");
        putImportProviderBindPath("�����}�l�W�����g�̐��������Z", "1730108", "1730115");
        
        
        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1730109", "1730117"); //[H30.4����]
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

    /**
     * �u�Z��敪�̕ύX�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void calculationDivisionSelectionChanged(ListSelectionEvent e) throws Exception{
    	checkState();
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_17311_201804.class.getName(),
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
        // �v���F�藚�����擾
        VRList ninteiList = getCalculater().getPatientInsureInfoHistoryList();
        setIsPrintCheckShow(false);
        // �������ɕ������𑶍݂���ꍇ
        if (ninteiList.size() > 1) {
            VRMap firstHistory = (VRMap) ninteiList.getData(0);
            VRMap secondHistory = (VRMap) ninteiList.getData(1);
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("JOTAI_CODE", firstHistory), 0)) {
            case 12:
            case 13:

                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0)) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                    // �v�x���˗v���
                    setIsPrintCheckShow(true);
                }
                break;

            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                // ����̔F�藚���̕ω��̏ꍇ
                if (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", firstHistory), 0) == ACCastUtilities
                        .toInt(VRBindPathParser
                                .get("JOTAI_CODE", secondHistory), 0)) {
                    setIsPrintCheckShow(false);
                    break;
                }
                // �v���˗v���
                switch (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0)) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
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
        // �s�����Ǝ����Z
        comboItemMap.setData("1730111",
                QkanCommon.getArrayFromMasterCode(274, "1730111"));
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
        // tekiyouText �� ""��ݒ肷��B ���o�[�W�����A�b�v����̏������΍�
        getTekiyouText().setText("");
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
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        if (provider != null) {
            // �I�����Ə����null�łȂ��ꍇ
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = getImportData();
            // ���ݒ�
            
            // �l�����Z
            Object obj;
            obj = VRBindPathParser.get("1730101", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1730102", defaultMap, new Integer(1));
                    break;
                case 2: // ��t�������ꍇ
                case 3: // �Ō�E���������ꍇ
                    VRBindPathParser.set("1730102", defaultMap, new Integer(3));
                    break;
                }
            }

            // �s�����Ǝ����Z�i���Ə��p�l���jKEY�F1730104�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1730104", provider);
            switch (ACCastUtilities.toInt(obj, 0)) {
            // �l�����̂����ꂩ�������ꍇ
            case 2:
                // 2�i�s�����Ǝ����Z�P�j
            case 3:
                // 3�i�s�����Ǝ����Z�Q�j
            case 4:
                // 4�i�s�����Ǝ����Z�R�j
            case 5:
                // 5�i�s�����Ǝ����Z�S�j
            case 6:
                // 6�i�s�����Ǝ����Z�T�j
            case 7:
                // 7�i�s�����Ǝ����Z�U�j
            case 8:
                // 8�i�s�����Ǝ����Z�V�j
            case 9:
                // 9�i�s�����Ǝ����Z�W�j
            case 10:
                // 10�i�s�����Ǝ����Z�X�j
            case 11:
                // 11�i�s�����Ǝ����Z�P�O�j
                // defaultMap�� KEY�F1730111 VALUE�F���Ə��̒l��ݒ肷��B
                VRBindPathParser.set("1730111", defaultMap, obj);
                break;
            default:
                // �l����L�ȊO�������ꍇ
                // defaultMap�� KEY�F1730111 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1730111", defaultMap, new Integer(1));
                break;
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

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

            if (staffs instanceof VRList) {
                int idx = ACBindUtilities.getMatchIndexFromValue(staffs,
                        "CARE_MANAGER_NO", getKaigoSupportSpecialMemberNumber()
                                .getText());
                if (idx >= 0) {
                    getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
                }
            }
            // �s�����Ǝ����Z�����I���̏ꍇ�́A�ŏ��̍���(�Ȃ�)��I������B
            if (getMunicipalityAdd().getSelectedIndex() < 0
                    && getMunicipalityAdd().getItemCount() > 0) {
                getMunicipalityAdd().setSelectedIndex(0);
            }

            checkState();

        }
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
     * �o�C���h�㏈��
     */
    public void binded() throws Exception {
        // super.binded();
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
     * �����`�F�b�N���̏���
     * 
     * @author Masahiko.Higuchi
     * @since V5.4.9
     */
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        checkOnDayCheckState();

    }

    /**
     * �����`�F�b�N���̉�ʐ��䏈���ł��B
     * 
     * @author Masahiko.Higuchi
     * @since V5.4.9
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
     * @throws Exception ��O����
     * @author Masahiko.Higuchi
     * @since V5.4.9
     */
    public void checkState() throws Exception {
    	
    	// �Z��敪�Łu2-���Z�̂݁v���I������Ă���
    	if (getCalculationDivision().getSelectedIndex() == 2) {
    		setState_VALID_TERMINAL_CARE_INFORMATION();
    		// �Ŏ��A�g�̐����Z���u2-����v�̏ꍇ
    		if (getTerminalCareInformationRadioGroup().getSelectedIndex() == 2) {
    			// �Ŏ��A�g�̐����Z�����P�ʗL��
            	setState_VALID_TERMINAL();
    		} else {
    			// �Ŏ��A�g�̐����Z�E�Ŏ��A�g�̐����Z�����P�ʖ���
            	setState_INVALID_TERMINAL();
    		}
    	} else {
    		// �Ŏ��A�g�̐����Z�����P�ʖ���
    		setState_INVALID_TERMINAL_CARE_INFORMATION();
    		setState_INVALID_TERMINAL();
    	}
    	
    	
        checkOnDayCheckState();
        resetStateByRestrictBindPath();
    }

    /**
     * �u�Ō�E���z�u���Z�I�������v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
	@Override
    protected void nurseStaffDispositionAddRadioGroupActionPerformed(
    		ActionEvent e) throws Exception{
    	checkState();
    }

    /**
     * �u�Ŏ������Z�̕ύX�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
	@Override
	protected void terminalCareInformationRadioGroupSelectionChanged(
			ListSelectionEvent e) throws Exception {
		checkState();
	}

}
