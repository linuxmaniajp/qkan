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
 * �v���O���� �T�[�r�X�p�^�[���ʏ���� (QS001_11511_201804)
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
 * �T�[�r�X�p�^�[���ʏ����(QS001_11511_201804)
 */
@SuppressWarnings("serial")
public class QS001_11511_201804 extends QS001_11511_201804Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_11511_201804() {
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�����", "1150103", "1150106");
        // 2015.03.02 del putImportProviderBindPath("�h�{���P�̐�", "1150113", "1150116");
        // 2015.03.02 del putImportProviderBindPath("���o�@�\������Z", "1150109", "1150112");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1150114", "1150117");
        
        putImportProviderBindPath("���d�x�҃P�A�̐����Z", "1150117", "1150122");
        putImportProviderBindPath("�������k���z�u�����Z", "1150125", "1150125"); //[H30.4����]
        
        

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�����", "1150103", "1150106");
        putRestrictProviderBindPath("�h�{���P�̐�", "1150113", "1150116");
        putRestrictProviderBindPath("���o�@�\������Z", "1150109", "1150112");
        putRestrictProviderBindPath("��N���F�m�Ǘ��p�Ҏ�����Z", "1150112", "1150115");
        putRestrictProviderBindPath("ADL�ێ������Z", "1150129", "1150127"); //[H30.4����]
        putRestrictProviderBindPath("�������k���z�u�����Z", "1150125", "1150125"); //[H30.4����]
        putRestrictProviderBindPath("�����@�\����A�g���Z", "1150126", "1150126"); //[H30.4����]
        
        putRestrictProviderBindPath("�F�m�ǉ��Z", "1150118", "1150121");
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
//        // �{�݋敪�I�����̏���
//        // �{�݋敪�I����
//        VRMap comboItemMap;
//        switch (getTsuusyoKaigoTimeContenaFacilityDivision().getSelectedIndex()) {
//        case 1:
//            // ���K��
//            setState_STATE_SMALL();
//            comboItemMap = new VRHashMap();
//            // �R�[�h�}�X�^�f�[�^���CODE_ID�F40�i���ԋ敪�j���擾����B
//            // �擾�����l���AcomboItemMap�� KEY : 1150104 �� VALUE �Ƃ��Đݒ肷��B
//            comboItemMap.setData("1150104",
//                    QkanCommon.getArrayFromMasterCode(40, "1150104"));
//            // ���W�J
//            // ���g(this)��comboItemMap�ɐݒ肷��B
//            getThis().setModelSource(comboItemMap);
//            // �R���{�A�C�e����W�J����B
//            getThis().bindModelSource();
//            break;
//        case 2:
//        case 3:
//        case 4:
//            // �ʏ�K�͑I����
//            setState_STATE_NORMAL();
//            comboItemMap = new VRHashMap();
//            // �R�[�h�}�X�^�f�[�^���CODE_ID�F40�i���ԋ敪�j���擾����B
//            // �擾�����l���AcomboItemMap�� KEY : 1150104 �� VALUE �Ƃ��Đݒ肷��B
//            comboItemMap.setData("1150104",
//                    QkanCommon.getArrayFromMasterCode(40, "1150104"));
//            // ���W�J
//            // ���g(this)��comboItemMap�ɐݒ肷��B
//            getThis().setModelSource(comboItemMap);
//            // �R���{�A�C�e����W�J����B
//            getThis().bindModelSource();
//            break;
//        case 5:
//            // �×{�ʏ��I����
//            setState_STATE_RYOYO();
//            comboItemMap = new VRHashMap();
//            // �R�[�h�}�X�^�f�[�^���CODE_ID�F40�i���ԋ敪�j���擾����B
//            // �擾�����l���AcomboItemMap�� KEY : 1150104 �� VALUE �Ƃ��Đݒ肷��B
//            comboItemMap.setData("1150104",
//                    QkanCommon.getArrayFromMasterCode(238, "1150104"));
//            // ���W�J
//            // ���g(this)��comboItemMap�ɐݒ肷��B
//            getThis().setModelSource(comboItemMap);
//            // �R���{�A�C�e����W�J����B
//            getThis().bindModelSource();
//            break;
//        }
//        
//        // ��L�����ŗL���ɂȂ����R���g���[���ł��A���Ə��̐��Ő�����󂯂���̂͏㏑���Ő��䂷��B
//        // 2015/03/09 [H27.4�����Ή�][Shinobu Hitaka] edit - begin 
//        resetStateByRestrictBindPath();
        /*
        VRBindSource provider = getSelectedProvider();
        if (provider != null) {
            Object obj;
            // �h�{���P�̐�
            obj = VRBindPathParser.get("1150113", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��������ꍇ
                    // �����ɂ���B
                    setState_INVALID_NOURISHMENT_MANAGEMENT();
                    break;
                }
            }
            // �ʋ@�\�P���̐��i���Ə��p�l���jKEY�F1150116�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1150116", provider);
            switch (ACCastUtilities.toInt(obj, 0)) {
            // �l�����̂����ꂩ�������ꍇ
            case 2:
                // 2�i���Z�^I�j
            case 3:
                // 3�i���Z�^II�j
                // �Ȃɂ����Ȃ��B
                break;
            default:
                // �l����L�ȊO�������ꍇ
                // �����ɂ���B
                setState_INVALID_FUNCTION_TRAINING();
                break;
            }

            // ���o�@�\����̐��i���Ə��p�l���jKEY�F1150109�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1150109", provider);
            switch (ACCastUtilities.toInt(obj, 0)) {
            // �l�����̂����ꂩ�������ꍇ
            case 2:
                // 2�i����j
                // �Ȃɂ����Ȃ��B
                break;
            default:
                // �l����L�ȊO�������ꍇ
                // �����ɂ���B
                setState_INVALID_MOUTH_FUNCTION();
                break;
            }

            // ��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1150112�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1150112", provider);
            switch (ACCastUtilities.toInt(obj, 0)) {
            // �l�����̂����ꂩ�������ꍇ
            case 2:
                // 2�i����j
                break;
            default:
                // �l����L�ȊO�������ꍇ
                // �����ɂ���B
                setState_INVALID_YOUNG_DEMENTIA_PATINET();
                break;
            }

        }
        */
        // �F�m�ǉ��Z���ݒ肳��Ă����疳���ɂ���B����ȊO�͂Ȃɂ����Ȃ��B
    	if (getDementiaElderlyAccepted().isEnabled() == true && getDementiaElderlyAccepted().getSelectedIndex() == 2) {
    		setState_INVALID_YOUNG_DEMENTIA_PATINET();
    	}
        // 2015/03/09 [H27.4�����Ή�][Shinobu Hitaka] edit - end 

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
        ACFrame.debugStart(new ACAffairInfo(QS001_11511_201804.class.getName(),
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
        // �擾�����l���AcomboItemMap�� KEY : 1150104 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1150104",
                QkanCommon.getArrayFromMasterCode(40, "1150104"));
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
            obj = VRBindPathParser.get("1150115", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj, 1)) {
                case 2: // �ʏ�K�͌^
                    VRBindPathParser.set("1150113", defaultMap, new Integer(1));
                    break;
                case 4: // ��K��I
                    VRBindPathParser.set("1150113", defaultMap, new Integer(2));
                    break;
                case 5: // ��K��II
                    VRBindPathParser.set("1150113", defaultMap, new Integer(3));
                    break;
                }
            }

            // �l�����Z
            obj = VRBindPathParser.get("1150106", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1150108", defaultMap, new Integer(1));
                    break;
                case 2: // ��t�������ꍇ
                case 3: // �Ō�E���������ꍇ
                    VRBindPathParser.set("1150108", defaultMap, new Integer(3));
                    break;
                }
            }

            // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] mod - begin
//            // �ʋ@�\�P���w�����Z
//            switch (ACCastUtilities.toInt(
//                    VRBindPathParser.get("1150116", provider), 1)) {
//            case 2: // I�^
//                VRBindPathParser.set("1150119", defaultMap, new Integer(2));
//                break;
//            case 3: // II�^
//                VRBindPathParser.set("1150120", defaultMap, new Integer(2));
//                break;
//            }
			// �ʋ@�\�P���̐�I
			switch (ACCastUtilities.toInt(VRBindPathParser.get("1150116", provider), 1)) {
			case 2: // I�^
				VRBindPathParser.set("1150119", defaultMap, new Integer(2));
				break;
			default:
				VRBindPathParser.set("1150119", defaultMap, new Integer(1));
			}
			// �ʋ@�\�P���̐�II
			switch (ACCastUtilities.toInt(VRBindPathParser.get("1150127", provider), 1)) {
			case 2: // II�^
				VRBindPathParser.set("1150120", defaultMap, new Integer(2));
				break;
			default:
				VRBindPathParser.set("1150120", defaultMap, new Integer(1));
			}
			// �ʋ@�\�P���̐��I����Ԑݒ�
			setFunctionTraining(provider);
            // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] mod - end
            
            // 2015/03/02 [H27.4�����Ή�][Shinobu Hitaka] edit - begin �̐��������Ă��Ȃ���I������B
            // �h�{���P�̐�
            VRBindPathParser.set("1150116", defaultMap, new Integer(1));
            // ���o�@�\������Z
            VRBindPathParser.set("1150112", defaultMap, new Integer(1));
            // �F�m�ǉ��Z���ݒ肳��Ă����疳���ɂ���B����ȊO�͂Ȃɂ����Ȃ��B
            if (getDementiaElderlyAccepted().isEnabled() == true && getDementiaElderlyAccepted().getSelectedIndex() == 2) {
                setState_INVALID_YOUNG_DEMENTIA_PATINET();
            }
            // 2015/03/02 [H27.4�����Ή�][Shinobu Hitaka] edit - end
            
            
            // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - begin
            // ���Z���̏��Ȃ�����D��
            // �����^�T�[�r�X�̒񋟁i���ی㓙�f�C�T�[�r�X���Ə��j
            obj = VRBindPathParser.get("1150124", provider);
            if (obj != null) {
                // ���Ə��o�^�̐ݒ荀�ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 2: // ���肾�����ꍇ
                    VRBindPathParser.set("22", defaultMap, new Integer(8));
                    break;
                }
            }
            // �����^�T�[�r�X�̒񋟁i�������B�x�����Ə��j
            obj = VRBindPathParser.get("1150123", provider);
            if (obj != null) {
                // ���Ə��o�^�̐ݒ荀�ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 2: // ���肾�����ꍇ
                    VRBindPathParser.set("22", defaultMap, new Integer(7));
                    break;
                }
            }
            // �����^�T�[�r�X�̒񋟁i������쎖�Ə��j
            obj = VRBindPathParser.get("1150121", provider);
            if (obj != null) {
                // ���Ə��o�^�̐ݒ荀�ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 2: // ���肾�����ꍇ
                    VRBindPathParser.set("22", defaultMap, new Integer(5));
                    break;
                }
            }
            // �����^�T�[�r�X�̒񋟁i�����P�����Ə��j
            obj = VRBindPathParser.get("1150122", provider);
            if (obj != null) {
                // ���Ə��o�^�̐ݒ荀�ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 2: // ���肾�����ꍇ
                    VRBindPathParser.set("22", defaultMap, new Integer(6));
                    break;
                }
            }
            // 2018/02/20 [H30.4�����Ή�][Yoichiro Kamei] add - end
            
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
    	// 2016/02/01 [H28.4�����Ή�][Shinobu Hitaka] add - begin H28.4�ȍ~�I��s���ڂ𐧌䂷��B
//        if (getCalculater().getTargetDate() != null && 
//                ACDateUtilities.getDifferenceOnDay(QkanConstants.H2804, getCalculater().getTargetDate()) < 1) {
//            // �I��s�F���K�͎��Ə��A�×{�ʏ�
//        	int kubun = getTsuusyoKaigoTimeContenaFacilityDivision().getSelectedIndex();
//            if (kubun == 1 || kubun == 5) {
//                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
//                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
//	            // null��Ԃ��B
//	            return null;
//            }
//        }
        // 2016/02/01 [H28.4�����Ή�][Shinobu Hitaka] add - end
        
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
            kaigoTime = getKaigoTime();
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
            // �R���Ԉȏ�S���Ԗ����̏ꍇ
            // �߂�l�Ƃ���240��Ԃ��B
            return 240;
        case 2:
            // �S���Ԉȏ�T���Ԗ����̏ꍇ
            // �߂�l�Ƃ���300��Ԃ��B
            return 300;
        case 3:
            // �T���Ԉȏ�U���Ԗ����̏ꍇ
            // �߂�l�Ƃ���360��Ԃ��B
            return 360;
        case 4:
            // �U���Ԉȏ�V���Ԗ����̏ꍇ
            // �߂�l�Ƃ���420��Ԃ��B
            return 420;
        case 5:
            // �V���Ԉȏ�W���Ԗ����̏ꍇ
            // �߂�l�Ƃ���48��Ԃ��B
            return 480;
        case 6:
            // �W���Ԉȏ�X���Ԗ����̏ꍇ
            // �߂�l�Ƃ���540��Ԃ��B
            return 540;
        case 7:
            // �X���Ԉȏ�P�O���Ԗ����̏ꍇ
            // �߂�l�Ƃ���600��Ԃ��B
            return 600;
        case 8:
            // �P�O���Ԉȏ�P�P���Ԗ����̏ꍇ
            // �߂�l�Ƃ���660��Ԃ��B
            return 660;
        case 9:
            // �P�P���Ԉȏ�P�Q���Ԗ����̏ꍇ
            // �߂�l�Ƃ���720��Ԃ��B
            return 720;
        case 10:
            // �P�Q���Ԉȏ�P�R���Ԗ����̏ꍇ
            // �߂�l�Ƃ���780��Ԃ��B
            return 780;
        case 11:
            // �P�R���Ԉȏ�P�S���Ԗ����̏ꍇ
            // �߂�l�Ƃ���840��Ԃ��B
            return 840;
        }
        return 0;
    }

    /**
     * �u�ʋ@�\�P���̐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void setFunctionTraining(VRMap provider) throws Exception {
        // �ʋ@�\�P���̐��I��s��
        setState_INVALID_FUNCTION_TRAINING();
		// �ʋ@�\�P���̐�I
        int kinou1 = ACCastUtilities.toInt(VRBindPathParser.get("1150116", provider), 1);
		switch (kinou1) {
		case 2: // I�^
			setState_VALID_FUNCTION_TRAINING1();
			break;
		}
		// �ʋ@�\�P���̐�II
        int kinou2 = ACCastUtilities.toInt(VRBindPathParser.get("1150127", provider), 1);
		switch (kinou2) {
		case 2: // II�^
			setState_VALID_FUNCTION_TRAINING2();
			break;
		}
        // �ʋ@�\�P���̐��I����
		if (kinou1 == 2 && kinou2 == 2) {
			setState_VALID_FUNCTION_TRAINING();
		}
    }

}
