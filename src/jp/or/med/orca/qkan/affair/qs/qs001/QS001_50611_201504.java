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
 * �쐬��: 2011/11/16  MIS��B������� �T��@�z��Y �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���ʏ��^�T�[�r�X(�Ǝ�) (QS001_50611_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���ʏ��^�T�[�r�X(�Ǝ�)(QS001_50611_201504)
 */
@SuppressWarnings("serial")
public class QS001_50611_201504 extends QS001_50611_201504Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_50611_201504() {

        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�^���@�\����̐�", "5060102", "5060106");
        putImportProviderBindPath("�h�{���P�̐�", "5060103", "5060107");
        putImportProviderBindPath("���o�@�\����̐�", "5060104", "5060108");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "5060107", "5060111");

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "5060106", "5060110");
        putRestrictProviderBindPath("�^���@�\����̐�", "5060102", "5060106");
        putRestrictProviderBindPath("�h�{���P�̐�", "5060103", "5060107");
        putRestrictProviderBindPath("���o�@�\����̐�", "5060104", "5060108");
        putRestrictProviderBindPath("�I��I�T�[�r�X�������{���Z", "5060109", "5060113");

    }

    // �R���|�[�l���g�C�x���g

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_50611_201504.class.getName(),
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
                // �v�x���P�˗v�x���Q
                if (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0) == 13) {
                    setIsPrintCheckShow(true);
                    break;
                }
                break;
            case 13:
                // �v�x���Q�˗v�x���P
                if (ACCastUtilities.toInt(
                        VRBindPathParser.get("JOTAI_CODE", secondHistory), 0) == 12) {
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
        // ���J�n����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
		// �ی��҃R���{
		VRList insurerList = QkanCommon.getInsurerInfoCareOnly(getDBManager());
		// �ی��Ҕԍ��𑍍����Ɨp�̃o�C���h�p�X�փR�s�[
		ACBindUtilities.copyBindPath(insurerList, "INSURER_ID",
				String.valueOf(SJ_HOKENSHA_NO_BIND_PATH));
		VRBindPathParser.set("INSURER", comboItemMap, insurerList);
		
		// �p�^�[���P�`�T
		comboItemMap.setData("5060112", QkanCommon.getArrayFromMasterCode(290, "5060112"));		

		// ���W�J
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();
        
		// �ی��҃R���{�̏����l�ݒ�
		String insurerId = getInitialInsurerId();

		// �擾�����ی��Ҕԍ��ɊY������ی��҂����݂���ꍇ
		VRMap item = (VRMap) getInsurerName().getDataFromBindPath(insurerId);

		// �ی��Җ��R���{�̊Y���ی��҂�I����Ԃɂ���B
		getInsurerName().setSelectedItem(item);
        
        // �p�^�[��1��I����Ԃɂ���B
		getServicePattern().setSelectedIndex(0);

        // ���I�����ڂ̏����ݒ�
        // ������
        // �����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
        VRMap defaultMap = new VRHashMap();
        // ���ݒ�
        // ���W�I�̏����I�����s���B��selectFirstRadioItem(getThis())
        QkanCommon.selectFirstRadioItem(getThis());
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();
        // ��ʏ�Ԃ�ݒ肷��B
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
            // �E���̌����ɂ�錸�Z�̏󋵁i���Ə��p�l���jKEY�F5060101�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("5060101", provider), 0)) {
            case 1:
                // �l�����Z��1�i�Ȃ��j�������ꍇ
                // defaultMap�� KEY�F5060103 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("5060103", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
                // �l��2�i�Ō�E���E���������j�������ꍇ
                // defaultMap�� KEY�F5060103 VALUE�F3�i�Ō�E���E���������j��ݒ肷��B
                VRBindPathParser.set("5060103", defaultMap, new Integer(3));
                break;
            }

            // �����@�\����O���[�v�������Z�֘A�̏�����
            if (ACCastUtilities.toInt(
                    VRBindPathParser.get("5060102", provider), 1) > 1
                    || ACCastUtilities.toInt(
                            VRBindPathParser.get("5060103", provider), 1) > 1
                    || ACCastUtilities.toInt(
                            VRBindPathParser.get("5060104", provider), 1) > 1
                    || ACCastUtilities.toInt(
                            VRBindPathParser.get("5060109", provider), 1) > 1) {
                // �T�[�r�X�̐����@�\����O���[�v�������Z�֘A�̏�����
                VRBindPathParser.set("5060105", defaultMap, new Integer(1));
            }

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

            // ��ʏ�Ԃ�ݒ肷��B
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
        // �ی��Җ��̃`�F�b�N
        // �EkaigoInfoInsurerName�i�ی��Җ��j
        // �I������Ă��邩�ǂ���
        if (!getInsurerName().isSelected()) {
            // �I������Ă��Ȃ��ꍇ
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT("�ی���");
            return null;
        }
        // �������R���{�`�F�b�N
        if (!getHoumonKaigoBeginTime().isValidDate()
                || (!getHoumonKaigoEndTime().isValidDate())) {
            // �J�n�����R���{(houmonKaigoBeginTime)�ƏI�������R���{(houmonKaigoEndTime)�̂����ꂩ���󗓂������͕s���̏ꍇ
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
        // �v�x���P�E�Q�̏ꍇ�A�񊈐��̂���data�ݒ肳��Ȃ��B�񐔃`�F�b�N���ł��Ȃ��Ȃ�̂ł����Őݒ������B
        VRBindPathParser.set("5060101", data, getPreventiveExpertPlaceCareServiceRadio().getSelectedIndex());
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
        return getHoumonKaigoBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getHoumonKaigoEndTime();
    }

    /**
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkState() throws Exception {

        // �����`�F�b�N
        checkOnDayCheckState();

        // ���Z�֘A�̐��䏈��
        // �����@�\������Z�������ꍇ
        if (getActivityAddRadio().getSelectedIndex() > 1) {
            setState_INVALID_MOVE_FUNCTION_ADD();
            setState_INVALID_NOURISHMENT_ADD();
            setState_INVALID_MOUTH_ADD();
            setState_INVALID_SENTAKU_ADD();
        } else {
            setState_VALID_MOVE_FUNCTION_ADD();
            setState_VALID_NOURISHMENT_ADD();
            setState_VALID_MOUTH_ADD();
            setState_VALID_SENTAKU_ADD();
        }

        // �^����@�\������Z�E�h�{���P���Z�E���o�@�\������Z�̂��Âꂩ�������ꍇ
        if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1
                || getNourishmentImprovementAddRadio().getSelectedIndex() > 1
                || getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1
                || getSentakutekiServiceRadio().getSelectedIndex() > 1) {
            setState_INVALID_ACTIVITY_ADD();
        } else {
            setState_VALID_ACTIVITY_ADD();
        }
        
        // �^����@�\������Z�E�h�{���P���Z�E���o�@�\������Z�̑g�ݍ��킹�`�F�b�N
        if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1
        		&& getNourishmentImprovementAddRadio().getSelectedIndex() > 1
        		&& getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	// �^����@�\������Z + �h�{���P���Z + ���o�@�\������Z�F�I��I�T�[�r�X�������{���ZII
        	getSentakutekiServiceRadio().setSelectedIndex(5);
        } else if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1
        		&& getNourishmentImprovementAddRadio().getSelectedIndex() > 1) {
        	// �^����@�\������Z + �h�{���P���Z�F�I��I�T�[�r�X�������{���ZI1
        	getSentakutekiServiceRadio().setSelectedIndex(2);
        } else if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1
        		&& getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	// �^����@�\������Z + ���o�@�\������Z�F�I��I�T�[�r�X�������{���ZI2
        	getSentakutekiServiceRadio().setSelectedIndex(3);
        } else if (getNourishmentImprovementAddRadio().getSelectedIndex() > 1
        		&& getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	// �h�{���P���Z + ���o�@�\������Z�F�I��I�T�[�r�X�������{���ZI3
        	getSentakutekiServiceRadio().setSelectedIndex(4);
        } else {
        	// �I��I�T�[�r�X�������{���Z�F�Ȃ�
        	getSentakutekiServiceRadio().setSelectedIndex(1);
        }
        
// 2016/7/13 [Yoichiro Kamei] add - begin �������ƑΉ�
        //�v���F�藚�����P�݂̂ŁA�v�x���P�A�܂��͗v�x���Q�̏ꍇ
        //�ʏ��^�T�[�r�X��͑I��s�Ƃ���
        setState_VALID_SERVICE();
        VRList ninteiList = getCalculater().getPatientInsureInfoHistoryList();
        if (ninteiList.size() == 1) {
            VRMap ninteiHistory = (VRMap) ninteiList.getData(0);
            int jotaiCode = ACCastUtilities.toInt(
                    VRBindPathParser.get("JOTAI_CODE", ninteiHistory), 0);
            if (12 == jotaiCode) {
                getPreventiveExpertPlaceCareServiceRadio().setSelectedIndex(1);
                setState_INVALID_SERVICE();
            } else if (13 == jotaiCode) {
            	getPreventiveExpertPlaceCareServiceRadio().setSelectedIndex(2);
            	setState_INVALID_SERVICE();
            }
        }
// 2016/7/13 [Yoichiro Kamei] add - end

        // ���Ə��̐��Ɠ���
        resetStateByRestrictBindPath();
    }

    /**
     * �l�o�C���h�㏈��
     * 
     */
    public void binded() throws Exception {
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

        // [ID:0000713][Masahiko.Higuchi] 2012/03 ����24�N4���@�����Ή� add begin
        // �����@�\����O���[�v�������Z������ł���ꍇ
        if (getActivityAddRadio().getSelectedIndex() > 1) {
            // �Ȃ��ɖ߂�
            getMoveFunctionImprovementAddRadio().setSelectedIndex(1);
            getNourishmentImprovementAddRadio().setSelectedIndex(1);
            getMouthFunctionImprovementAddRadio().setSelectedIndex(1);
            getSentakutekiServiceRadio().setSelectedIndex(1);
        }
        // [ID:0000713][Masahiko.Higuchi] 2012/03 ����24�N4���@�����Ή� add end

        // ��ʏ�Ԃ�ݒ肷��B
        checkState();
    }

    /**
     * �����`�F�b�N���̉�ʐ��䏈���ł��B
     * 
     */
    public void checkOnDayCheckState() throws Exception {
        if (getCrackOnDayCheck().getValue() == 2) {
            // �����ɂ���̂��~�߂�
            setState_DAY_CHECK_ON();
        } else {
            setState_DAY_CHECK_OFF();
        }
    }

    /**
     * ��ʏ�Ԑ���
     * 
     */
    protected void crackOnDayCheckActionPerformed(ActionEvent e)
            throws Exception {
        // ��ʏ�Ԑ���
        checkOnDayCheckState();

    }

    /**
     * �^����@�\������Z
     */
    protected void moveFunctionImprovementAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ��ʏ�Ԑ���
        checkState();

    }

    /**
     * �h�{���P���Z
     */
    protected void nourishmentImprovementAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ��ʏ�Ԑ���
        checkState();

    }

    /**
     * ���o�@�\������Z
     */
    protected void mouthFunctionImprovementAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ��ʏ�Ԑ���
        checkState();

    }

    /**
     * �����@�\����O���[�v�������Z
     */
    protected void activityAddRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ��ʏ�Ԑ���
        checkState();

    }

    /**
     * �I��I�T�[�r�X�������{���Z
     */
    protected void sentakutekiServiceRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        int idx = getSentakutekiServiceRadio().getSelectedIndex();
        // ��ʏ�Ԑ���
        checkState();
        // �S�āu�Ȃ��v���P�����I���̏ꍇ�́A�I���������̂ɖ߂�
        int selCnt = 0;
        if (getMoveFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	selCnt = selCnt + 1;
        }
        if (getNourishmentImprovementAddRadio().getSelectedIndex() > 1) {
        	selCnt = selCnt + 1;
        }
        if (getMouthFunctionImprovementAddRadio().getSelectedIndex() > 1) {
        	selCnt = selCnt + 1;
        }
        if (selCnt == 1 || selCnt == 0) {
        	getSentakutekiServiceRadio().setSelectedIndex(idx);
        }

    }

    /**
     * �񐔃`�F�b�N���̉�ʐ��䏈���ł��B
     * 
     */
	@Override
	protected void crackOnCntCheckActionPerformed(ActionEvent e)
			throws Exception {
        if (getCrackOnCntCheck().getValue() == 2) {
            // �񐔃`�F�b�NON�̂Ƃ��͓����͖���
            setState_COUNT_CHECK_OFF();
        } else {
        	setState_COUNT_CHECK_ON();
        }
		
	}
}
