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
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[������{�ݓ����Ґ������ (QS001_13311_201504)
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
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[������{�ݓ����Ґ������(QS001_13311_201504)
 */
@SuppressWarnings("serial")
public class QS001_13311_201504 extends QS001_13311_201504Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_13311_201504() {
        // �K�{�̎��Ə��ݒ荀��
        putCheckProviderBindPath("���E���������P���Z", "4");

        // �l��]�L���鎖�Ə��ݒ荀��
        putImportProviderBindPath("�l���z�u�敪", "1330103", "1330105");
        // 2015.03.02 del putImportProviderBindPath("�ʋ@�\�P���w�����Z", "1330101", "1330103");
        putImportProviderBindPath("��ԊŌ�̐����Z", "1330104", "1330106");
        putImportProviderBindPath("�T�[�r�X�񋟑̐��������Z", "1330111", "1330131");

        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("�ʋ@�\�P���w�����Z", "1330101", "1330103");
        putRestrictProviderBindPath("��ԊŌ�̐����Z", "1330104", "1330106");
        putRestrictProviderBindPath("�Ŏ������Z", "1330109", "1330128");
        putRestrictProviderBindPath("�F�m�ǐ��P�A���Z", "1330110", "1330130");
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void outsideServiceRadioActionPerformed(ActionEvent e)
            throws Exception {
        // �敪�I������
        VRMap comboItemMap = new VRHashMap();
        switch (getOutsideServiceRadio().getSelectedIndex()) {
        case 1:
            // �K����
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_VISIT();
                checkState();
            }
            break;
        case 2:
            // �K��������
            setState_SELECT_VISIT_BATH();
            break;
        case 3:
            // �K��Ō�I�����ɢ�E���敪�PT�EOT�EST���I�΂ꂽ�ꍇ
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_VISIT_NURSING();

                if (getVisitNursingStaffDivisionRadio().getSelectedIndex() == 2) {
                    // �����ԋ敪
                    // �R�[�h�}�X�^�f�[�^���CODE_ID�F34 �ʏ����n�i���ԋ敪�j���擾����B
                    // �擾�����l���AcomboItemMap�� KEY : 1330112 �� VALUE �Ƃ��Đݒ肷��B
                    comboItemMap.setData("1330112",
                            QkanCommon.getArrayFromMasterCode(34, "1330112"));
                    // ���W�J
                    // ���g(this)��comboItemMap�ɐݒ肷��B
                    getThis().setModelSource(comboItemMap);
                    // �R���{�A�C�e����W�J����B
                    getThis().bindModelSource();

                    setState_VALID_TWO_OR_MORE_TIMES();
                    
                    // �Ō�E���敪���g�p�s��
                	setState_INVALID_NURSE_STAFF_DIVISION();
                } else {
                    setState_INVALID_TWO_OR_MORE_TIMES();
                    
                    //20�������̏ꍇ
                    if (getHoumonKangoTime() == 20) {
                    	// �Ō�E���敪���g�p��
                    	setState_VALID_NURSE_STAFF_DIVISION();
                    } else {
                    	// �Ō�E���敪���g�p�s��
                    	setState_INVALID_NURSE_STAFF_DIVISION();
                    }
                }
            } else {
                setState_INVALID_TWO_OR_MORE_TIMES();
            }
            break;
        case 4:
            // �K�⃊�n
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_VISIT_REHABILI();
            }
            break;
        case 5:
            // �ʏ����
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_EXPERTPLACE_NURSING();
            }
            break;
        case 6:
            // �ʏ����n
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_EXPERTPLACE_REHABILI();
            }
            break;
        case 7:
            // �����p��ݗ^
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_WELFARE_TOOLS();
            }
            break;
        case 8:
            // �F�m�ǑΉ��^�ʏ����
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_NINTITUUSHO();
            }
            break;
        case 10:
            // �n�斧���^�ʏ����
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
            	setState_SELECT_CHIKI_DAYCARE();
            }
            break;
        case 9:
            // �Ȃ�
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_ONLY_BASE();
            }
            break;
        }
        // 2016/01/19 [H28.4�����Ή�][Shinobu Hitaka] add - begin H28.4�ȍ~�I��s���ڂ𐧌䂷��B
        checkShokiboHaishi();
        // 2016/01/19 [H28.4�����Ή�][Shinobu Hitaka] add - end

    }

    /**
     * �u�{�݋敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void facilitiesDivisionRadioActionPerformed(ActionEvent e)
            throws Exception {
        // �{�݋敪�I������
        if (getFacilitiesDivisionRadio().getSelectedIndex() == 1) {
            // ����{��
            setState_SELECT_SPECIAL();

        } else if (getFacilitiesDivisionRadio().getSelectedIndex() == 2) {
            // �O���T�[�r�X���p�^
            setState_SELECT_OUT();
            VRMap comboItemMap = new VRHashMap();
            switch (getOutsideServiceRadio().getSelectedIndex()) {
            case 1:
                // �K����
                setState_SELECT_VISIT();
                checkState();
                break;
            case 2:
                // �K��������
                setState_SELECT_VISIT_BATH();
                break;
            case 3:
                // �K��Ō�I�����ɢ�E���敪�PT�EOT�EST���I�΂ꂽ�ꍇ
                if (getVisitNursingStaffDivisionRadio().getSelectedIndex() == 2) {
                    // �����ԋ敪
                    // �R�[�h�}�X�^�f�[�^���CODE_ID�F34 �ʏ����n�i���ԋ敪�j���擾����B
                    // �擾�����l���AcomboItemMap�� KEY : 1330112 �� VALUE �Ƃ��Đݒ肷��B
                    comboItemMap.setData("1330112",
                            QkanCommon.getArrayFromMasterCode(34, "1330112"));
                    // ���W�J
                    // ���g(this)��comboItemMap�ɐݒ肷��B
                    getThis().setModelSource(comboItemMap);
                    // �R���{�A�C�e����W�J����B
                    getThis().bindModelSource();
                }
                setState_SELECT_VISIT_NURSING();
                break;
            case 4:
                // �K�⃊�n
                setState_SELECT_VISIT_REHABILI();
                break;
            case 5:
                // �ʏ����
                // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
                setState_SELECT_EXPERTPLACE_NURSING();
                break;
            case 6:
                // �ʏ����n
                // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
                setState_SELECT_EXPERTPLACE_REHABILI();
                break;
            case 7:
                // �����p��ݗ^
                // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
                setState_SELECT_WELFARE_TOOLS();
                break;
            case 8:
                // �F�m�ǑΉ��^�ʏ����
                // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
                setState_SELECT_NINTITUUSHO();
                break;
            case 10:
                // �n�斧���^�ʏ����
                // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            	setState_SELECT_CHIKI_DAYCARE();
                break;
            case 9:
                // �Ȃ�
                // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
                setState_SELECT_ONLY_BASE();
                break;
            }
            
            // 2016/01/19 [H28.4�����Ή�][Shinobu Hitaka] add - begin H28.4�ȍ~�I��s���ڂ𐧌䂷��B
            checkShokiboHaishi();
            // 2016/01/19 [H28.4�����Ή�][Shinobu Hitaka] add - end
        }

        // ��L�����ŗL���ɂȂ����R���g���[���ł��A���Ə��̐��Ő�����󂯂���̂͏㏑���Ő��䂷��B
        resetStateByRestrictBindPath();
    }

    /**
     * �u�J�n�����I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void specificFacilityBeginTimeActionPerformed(ActionEvent e)
            throws Exception {
        // �J�n�����I��
        checkEndTime();

    }

    /**
     * �u�K���쎞�ԋ敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void visitCareComboActionPerformed(ActionEvent e)
            throws Exception {
        // �K���쎞�ԋ敪�I��
        checkEndTime();

    }

    /**
     * �u�K��Ō쎞�ԋ敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void visitNursingComboActionPerformed(ActionEvent e)
            throws Exception {
        // �K��Ō쎞�ԋ敪�I��
        checkEndTime();

        //20�������̏ꍇ
        if (getHoumonKangoTime() == 20) {
        	// �Ō�E���敪���g�p��
        	setState_VALID_NURSE_STAFF_DIVISION();
        } else {
        	// �Ō�E���敪���g�p�s��
        	setState_INVALID_NURSE_STAFF_DIVISION();
        }
    }

    /**
     * �u�ʏ���쎞�ԋ敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void expertPlaceNursingComboActionPerformed(ActionEvent e)
            throws Exception {
        // �ʏ���쎞�ԋ敪�I��
        checkEndTime();

    }

    /**
     * �u�ʏ����n���ԋ敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void expertPlaceRehabiliComboActionPerformed(ActionEvent e)
            throws Exception {
        // �ʏ����n���ԋ敪�I��
        checkEndTime();

    }

    /**
     * �u�n�斧���^�ʏ���쎞�ԋ敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void chiikiDayCareComboActionPerformed(ActionEvent e)
            throws Exception {
        // �ʏ���쎞�ԋ敪�I��
        checkEndTime();

    }

    /**
     * �u�K��Ō�{�݋敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void visitNursingFacilitiesDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // �K��Ō�{�݋敪�I��
        // �K��Ō�X�e�[�V�������I������Ă��ĂȂ�����PT�EOT�EST�������ꍇ
        if (getVisitNursingFacilitiesDivisionRadioItem1().isSelected()) {
            if (getVisitNursingStaffDivisionRadioItem2().isSelected()) {
                VRMap comboItemMap = new VRHashMap();
                comboItemMap.setData("1330112",
                        QkanCommon.getArrayFromMasterCode(237, "1330112"));
                // ���W�J
                // ���g(this)��comboItemMap�ɐݒ肷��B
                getThis().setModelSource(comboItemMap);
                // �R���{�A�C�e����W�J����B
                getThis().bindModelSource();

                setState_VALID_TWO_OR_MORE_TIMES();

            } else {
                setState_INVALID_TWO_OR_MORE_TIMES();
            }

            // �K��Ō삪�I������Ă����ꍇ
            if (getOutsideServiceRadioItem3().isSelected()) {
                setState_VALID_STAFF_DIVISION_();
            }
        } else {

            VRMap comboItemMap = new VRHashMap();
            comboItemMap.setData("1330112",
                    QkanCommon.getArrayFromMasterCode(207, "1330112"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();
            // �K��Ō� �a�@���I������Ă����ꍇ
            if (getVisitNursingFacilitiesDivisionRadioItem2().isSelected()) {
                setState_INVALID_STAFF_DIVISION_();
            }

            setState_INVALID_TWO_OR_MORE_TIMES();
        }

    }

    /**
     * �u�K��Ō�E���敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void visitNursingStaffDivisionRadioActionPerformed(ActionEvent e)
            throws Exception {
        // �K��Ō�E���敪�I��
        // PT�EOT�EST�������ꍇ
        if (getVisitNursingStaffDivisionRadioItem2().isSelected()
                && getVisitNursingFacilitiesDivisionRadioItem1().isSelected()) {
            // �K��Ō�X�e�[�V�������I������Ă����ꍇ
            VRMap comboItemMap = new VRHashMap();
            comboItemMap.setData("1330112",
                    QkanCommon.getArrayFromMasterCode(237, "1330112"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();

            setState_VALID_TWO_OR_MORE_TIMES();
            
            // �Ō�E���敪���g�p�s��
        	setState_INVALID_NURSE_STAFF_DIVISION();
        } else {

            VRMap comboItemMap = new VRHashMap();
            comboItemMap.setData("1330112",
                    QkanCommon.getArrayFromMasterCode(207, "1330112"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();

            setState_INVALID_TWO_OR_MORE_TIMES();
            
            //20�������̏ꍇ
            if (getHoumonKangoTime() == 20) {
            	// �Ō�E���敪���g�p��
            	setState_VALID_NURSE_STAFF_DIVISION();
            } else {
            	// �Ō�E���敪���g�p�s��
            	setState_INVALID_NURSE_STAFF_DIVISION();
            }
        }

    }

    /**
     * �u�ʏ����{�݋敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void expertPlaceNursingRadioActionPerformed(ActionEvent e)
            throws Exception {
        // �ʏ����{�݋敪�I��
        // �×{�ʏ����I������Ă����ꍇ
        VRMap comboItemMap = new VRHashMap();
        switch (getExpertPlaceNursingRadio().getSelectedIndex()) {
        case 1: // ���K�͌^�ʏ����
        case 2: // �ʏ�K�͌^�ʏ����
        case 3: // ��K�͎��Ə� I
        case 4: // ��K�͎��Ə� II
            // �����ԋ敪
            // �R�[�h�}�X�^�f�[�^���CODE_ID�F40 �ʏ����i���ԋ敪�j���擾����B
            // �擾�����l���AcomboItemMap�� KEY : 1330115 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1330115",
                    QkanCommon.getArrayFromMasterCode(240, "1330115"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();
            break;
        case 5:
            // �×{�ʏ��I����
            // �����ԋ敪
            // �R�[�h�}�X�^�f�[�^���CODE_ID�F40 �ʏ����i���ԋ敪�j���擾����B
            // �擾�����l���AcomboItemMap�� KEY : 1330115 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1330115",
                    QkanCommon.getArrayFromMasterCode(238, "1330115"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();
            break;
        }

    }
    
    // 2016/02/01 [H28.4�����Ή�][Shinobu Hitaka] add - begin H28.4�ȍ~�I��s���ڂ𐧌䂷��B
    private void checkShokiboHaishi() throws Exception {
        // H28.4�ȍ~
        if (getCalculater().getTargetDate() != null && 
                ACDateUtilities.getDifferenceOnDay(QkanConstants.H2804, getCalculater().getTargetDate()) < 1) {
            // �I��s�F���K�͎��Ə��A�×{�ʏ�
        	getExpertPlaceNursingRadioItem1().setEnabled(false);
        	getExpertPlaceNursingRadioItem5().setEnabled(false);
        	getOutsideServiceRadioItem9().setEnabled(true);
        } else {
        	if (getOutsideServiceRadioItem5().isSelected()) {
	        	// �I���F���K�͎��Ə��A�×{�ʏ�
	        	getExpertPlaceNursingRadioItem1().setEnabled(true);
	        	getExpertPlaceNursingRadioItem5().setEnabled(true);
        	}
        	getOutsideServiceRadioItem9().setEnabled(false);
        	getChiikiDayCareGroup().setEnabled(false);
        }
    }
    // 2016/02/01 [H28.4�����Ή�][Shinobu Hitaka] add - end

    /**
     * �u�F�m�ǑΉ��ʏ����{�݋敪�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void providerDivisionRadioActionPerformed(ActionEvent e)
            throws Exception {
        // �F�m�ǑΉ��ʏ����{�݋敪�I��
        // �U�^���I�����ꂽ�ꍇ
        if (getProviderDivisionRadio().getSelectedIndex() == 2) {
            // �{�݋敪�Q�𖳌��ɂ���B
            setState_INVALID_NINTI_DIVISION();
        } else {
            // �{�݋敪��I���\�ɂ���B
            // �F�m�ǑΉ��ʏ���삪�I������Ă����ꍇ�̂�
            if (getOutsideServiceRadioItem8().isSelected()) {
                setState_VALID_NINTI_DIVISION();
            }
        }

    }

    /**
     * �u�F�m�ǑΉ��^�ʏ���쎞�ԋ敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void timeDivisionRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // �F�m�ǑΉ��^�ʏ���쎞�ԋ敪�I��
        // �F�m�ǑΉ��^�ʏ���쎞�ԋ敪
        checkEndTime();

    }

    /**
     * �u�n�斧���^�ʏ����{�݋敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void chiikiDayCareRadioActionPerformed(ActionEvent e)
            throws Exception {
        // �n�斧���^�ʏ����{�݋敪�I��
        // �×{�ʏ����I������Ă����ꍇ
        VRMap comboItemMap = new VRHashMap();
        switch (getChiikiDayCareRadio().getSelectedIndex()) {
        case 1: // �n�斧���^�ʏ����
            // �����ԋ敪
            // �R�[�h�}�X�^�f�[�^���CODE_ID�F40 �n�斧���^�ʏ����i���ԋ敪�j���擾����B
            // �擾�����l���AcomboItemMap�� KEY : 1330135 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1330135",
                    QkanCommon.getArrayFromMasterCode(240, "1330135"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();
            break;
        case 2:
            // �×{�ʏ��I����
            // �����ԋ敪
            // �R�[�h�}�X�^�f�[�^���CODE_ID�F40 �n�斧���^�ʏ����i���ԋ敪�j���擾����B
            // �擾�����l���AcomboItemMap�� KEY : 1330135 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1330135",
                    QkanCommon.getArrayFromMasterCode(238, "1330135"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();
            break;
        }
    }

    /**
     * �u�Ŏ������Z�̕ύX�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
	protected void terminalCareAddRadioGroupSelectionChanged(
			ListSelectionEvent e) throws Exception {
		checkState();
	}

	  /**
	   * �u�Z��敪�̕ύX�v�C�x���g�ł��B
	   * @param e �C�x���g���
	   * @throws Exception ������O
	   */
	protected void calculationDivisionRadioSelectionChanged(ListSelectionEvent e)
			throws Exception {
		checkState();
	}
	
    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_13311_201504.class.getName(),
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
        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F223 �K����i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1330114 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1330109",
                QkanCommon.getArrayFromMasterCode(239, "1330109"));
        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F207 �K��Ō�i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1330112 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1330112",
                QkanCommon.getArrayFromMasterCode(207, "1330112"));
        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F240 �ʏ����i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1330115 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1330115",
                QkanCommon.getArrayFromMasterCode(240, "1330115"));
        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F279 �ʏ����n�i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1330117 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1330117",
                QkanCommon.getArrayFromMasterCode(279, "1330117"));
        // �����p��
        comboItemMap.setData("1330118",
                QkanCommon.getArrayFromMasterCode(47, "1330118"));
        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F240 �n�斧���^�ʏ����i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1330135 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1330135",
                QkanCommon.getArrayFromMasterCode(240, "1330135"));
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
        defaultMap.setData("1330107", new Integer(9));
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
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            Object obj = VRBindPathParser.get("1330103", provider);

            // �l�����Z
            obj = VRBindPathParser.get("1330102", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1330104", defaultMap, new Integer(1));
                    break;
                case 2: // �Ō�E���������ꍇ
                case 3: // ���E���������ꍇ
                    VRBindPathParser.set("1330104", defaultMap, new Integer(2));
                    break;
                }
            }

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

            facilitiesDivisionRadioActionPerformed(null);
            
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
        // �J�n�����敪���L���ȏꍇ
        if (getSpecificFacilityBeginTime().isEnabled()) {
            // �K�⃊�n�E�K��������E�����p��ݗ^�̏ꍇ�͎��ԃ`�F�b�N���s��Ȃ��B
            if (!getOutsideServiceRadioItem4().isSelected()
                    && !getOutsideServiceRadioItem2().isSelected()
                    && !getOutsideServiceRadioItem7().isSelected()
                    && !getOutsideServiceRadioItem0().isSelected()) {
                if (ACTextUtilities.isNullText(getSpecificFacilityBeginTime()
                        .getText())
                        || ACTextUtilities
                                .isNullText(getSpecificFacilityEndTime()
                                        .getText())
                        || (!getSpecificFacilityBeginTime().isValidDate())
                        || (!getSpecificFacilityEndTime().isValidDate())) {
                    // �J�n�����R���{(houmonRehabilitationTimeContenaBeginTime)���󗓂��s���̏ꍇ
                    // �������͏I�������R���{(houmonRehabilitationTimeContenaEndTime)���󗓂��s���̏ꍇ
                    // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
                    // null��Ԃ��B
                    return null;
                }
            }
        }
        // �K����{�݋敪���L���ł���ꍇ
        if (getVisitCareCombo().isEnabled()) {
            // �����R���{�̒l���`�F�b�N����
            if (!getVisitCareCombo().isSelected()) {
                // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }

        }
        // �K��Ō� �����R���{���L���ȏꍇ
        if (getVisitNursingFacilitiesDivisionRadio().isEnabled()) {
            if (getVisitNursingCombo().isEnabled()
                    && !getVisitNursingCombo().isSelected()) {
                // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
            // �E���敪���`�F�b�N����B
            if (!getVisitNursingStaffDivisionRadio().getSelectedButton()
                    .isEnabled()) {
                // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
        // �ʏ���� �����R���{���L���ȏꍇ
        if (getExpertPlaceNursingCombo().isEnabled()) {
        	// 2016/02/01 [H28.4�����Ή�][Shinobu Hitaka] add - begin H28.4�ȍ~�I��s���ڂ𐧌䂷��B
            if (getCalculater().getTargetDate() != null && 
                    ACDateUtilities.getDifferenceOnDay(QkanConstants.H2804, getCalculater().getTargetDate()) < 1) {
                // �I��s�F���K�͎��Ə��A�×{�ʏ�
            	int kubun = getExpertPlaceNursingRadio().getSelectedIndex();
                if (kubun == 1 || kubun == 5) {
                    // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
    	            // null��Ԃ��B
    	            return null;
                }
            }
            // 2016/02/01 [H28.4�����Ή�][Shinobu Hitaka] add - end
            
            if (!getExpertPlaceNursingCombo().isSelected()) {
                // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
        // �ʏ����n �����R���{���L���ȏꍇ
        if (getExpertPlaceRehabiliCombo().isEnabled()) {
            if (!getExpertPlaceRehabiliCombo().isSelected()) {
                // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }

        // �����p�� �����p��̎�ނ��I������Ă��邩�`�F�b�N����B
        if (getWelfareToolsCombo().isEnabled()) {
            // �p���ނ��I������Ă��Ȃ������ꍇ
            if (!getWelfareToolsCombo().isSelected()) {
                // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
            // �P�ʐ������͂���Ă��Ȃ������ꍇ
            if ("".equals(getWelfarePointText().getText())) {
                // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }

        }
        
        // 2016/02/01 [H28.4�����Ή�][Shinobu Hitaka] add - begin H28.3�ȑO�I��s���ڂ𐧌䂷��B
        // �n�斧���^�ʏ���� �����R���{���L���ȏꍇ
        if (getChiikiDayCareCombo().isEnabled()) {
            if (!getChiikiDayCareCombo().isSelected()) {
                // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
        // �n�斧���^�ʏ���� H28.4���O�͑I��s��
        if (getCalculater().getTargetDate() != null && 
                ACDateUtilities.getDifferenceOnDay(QkanConstants.H2804, getCalculater().getTargetDate()) > 0) {
            if (getOutsideServiceRadioItem9().isSelected() == true) {
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
	            // null��Ԃ��B
	            return null;
            }
        }
        // 2016/02/01 [H28.4�����Ή�][Shinobu Hitaka] add - end
        
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
        if (getFacilitiesDivisionRadio().getSelectedIndex() == 1) {
            return null;
        }
        // �O�����p�^�������ꍇ
        // �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return getSpecificFacilityBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        if (getFacilitiesDivisionRadio().getSelectedIndex() == 1) {
            return null;
        }
        // �O�����p�^�������ꍇ
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getSpecificFacilityEndTime();
    }

    /**
     * �u�I�����Ԑݒ菈���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkEndTime() throws Exception {
        // ���I�����Ԑݒ�Ɋւ���A������
        // �����ԑѕύX���A�I�����Ԃ��ύX
        // �J�n���ԃR���{(houmonRehabilitationTimeContenaBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
        // ���ԑޔ�p�̕ϐ�kangoTime�ɁA���ԋ敪����擾�������Ԃ�ݒ肷��B

        // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
        if (getSpecificFacilityBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getSpecificFacilityBeginTime()
                        .getText()))) {
            // �J�n���ԃR���{(houmonKangoKaigoBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
            // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
            int addTime = 0;
            switch (getOutsideServiceRadio().getSelectedIndex()) {
            case 1:
                // �K����
                addTime = getKangoTime();
                break;
            case 3:
                // �K��Ō�
                // �K��Ō�X�e�[�V�����łȂ�����PT�EOT�EST�������ꍇ
                //if (getVisitNursingStaffDivisionRadioItem2().isSelected()
                //        && getVisitNursingFacilitiesDivisionRadioItem1()
                //                .isSelected()) {
                //    addTime = getHoumonKangoTimeSpecial();
                //} else {
                    addTime = getHoumonKangoTime();
                //}
                break;
            case 5:
                // �ʏ����
                if (getExpertPlaceNursingRadioItem5().isSelected()) {
                    addTime = getTuusyoKaigoTimeSpecial();
                } else {
                    addTime = getTuusyoKaigoTime();
                }
                break;
            case 6:// �ʏ����n
                addTime = getTuusyoRihaTime();
                break;

            case 8:// �F�m�ǑΉ��^�ʏ����
                addTime = getNintiTaiouTusyoKaigoTime();
                break;

            case 10:
                // �n�斧���^�ʏ����
                if (getChiikiDayCareRadioItem2().isSelected()) {
                    addTime = getChiikiDayCareTimeSpecial();
                } else {
                    addTime = getChiikiDayCareTime();
                }
                break;
                
            default:
                return;
            }

            // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
            getSpecificFacilityEndTime().setDate(
                    ACDateUtilities.addMinute(getSpecificFacilityBeginTime()
                            .getDate(), addTime));
        }
    }

    /**
     * �u�K��Ō쎞�Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getHoumonKangoTime() throws Exception {
        // ���K��Ō쎞�ԋ敪�擾
        // �����ԋ敪(VisitCareCombo)�̎��Ԃ��擾
        // ���ԋ敪(VisitCareCombo)�̒l���`�F�b�N����B
        switch (getVisitNursingCombo().getSelectedIndex()) {
        case 0:
            // 20���ȏ�̏ꍇ
            return 20;
        case 1:
            // 30���ȏ�̏ꍇ
            return 30;
        case 2:
            // 1���Ԉȏ�̏ꍇ
            return 60;
        case 3:
            // 1����30���ȏ�̏ꍇ
            return 90;
        }
        return 0;
    }

    /**
     * �u�K��Ō쎞�Ԏ擾_�w��K��Ō�X�e�[�V�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getHoumonKangoTimeSpecial() throws Exception {
        // ���K��Ō쎞�Ԏ擾_�w��K��Ō�X�e�[�V����
        // �����ԋ敪(VisitCareCombo)�̎��Ԃ��擾
        // ���ԋ敪(VisitCareCombo)�̒l���`�F�b�N����B
        switch (getVisitNursingCombo().getSelectedIndex()) {
        case 0:
            // 30�������̏ꍇ
            return 30;
        case 1:
            // 1���Ԕ������̏ꍇ
            return 90;
        }
        return 0;
    }

    /**
     * �u�K���쎞�Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getKangoTime() throws Exception {
        // ���K���쎞�Ԏ擾
        // �����ԋ敪(VisitCareCombo)�̎��Ԃ��擾
        // ���ԋ敪(VisitCareCombo)�̒l���`�F�b�N����B
        int addMinute = 0;
        if (getVisitCareCombo().isEnabled()
                && getVisitCareCombo().isSelected()) {
        	addMinute = (getVisitCareCombo().getSelectedIndex()) * 15 + 15;
        }
        return addMinute;
    }

    /**
     * �u�F�m�ǑΉ��^�ʏ���쎞�Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getNintiTaiouTusyoKaigoTime() throws Exception {
        // ���F�m�ǑΉ��^�ʏ���쎞�Ԏ擾
        // �����ԋ敪(timeDivisionRadio)�̎��Ԃ��擾
        // ���ԋ敪(timeDivisionRadio)�̒l���`�F�b�N����B
        switch (getTimeDivisionRadio().getSelectedIndex()) {
        case 1:
            // �Q���Ԉȏ�R���Ԗ����̏ꍇ
            return 180;
        case 2:
            // �R���Ԉȏ�T���Ԗ����̏ꍇ
            return 300;
        case 3:
            // �T���Ԉȏ�V���Ԗ����̏ꍇ
            return 420;
        case 4:
            // �V���Ԉȏ�X���Ԗ����̏ꍇ
            return 540;
        }

        return 0;
    }

    /**
     * �u�ʏ���쎞�Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getTuusyoKaigoTime() throws Exception {
        // ���ʏ���쎞�Ԏ擾
        // �����ԋ敪(VisitCareCombo)�̎��Ԃ��擾
        // ���ԋ敪(VisitCareCombo)�̒l���`�F�b�N����B
        switch (getExpertPlaceNursingCombo().getSelectedIndex()) {
        case 0:
            // �Q���Ԉȏ�R���Ԗ����̏ꍇ
            return 180;
        case 1:
            // �R���Ԉȏ�T���Ԗ����̏ꍇ
            return 300;
        case 2:
            // �T���Ԉȏ�V���Ԗ����̏ꍇ
            return 420;
        case 3:
            // �V���Ԉȏ�X���Ԗ����̏ꍇ
            return 540;
        }
        return 0;
    }

    /**
     * �u�ʏ���쎞�Ԏ擾_�×{�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getTuusyoKaigoTimeSpecial() throws Exception {
        // ���ʏ���쎞�Ԏ擾_�×{
        // �����ԋ敪(VisitCareCombo)�̎��Ԃ��擾
        // ���ԋ敪(VisitCareCombo)�̒l���`�F�b�N����B
        switch (getExpertPlaceNursingCombo().getSelectedIndex()) {
        case 0:
            // 3���Ԉȏ�6���Ԗ����̏ꍇ
            return 360;
        case 1:
            // 6���Ԉȏ�8���Ԗ����̏ꍇ
            return 480;
        }
        return 0;
    }

    /**
     * �u�ʏ����n���Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getTuusyoRihaTime() throws Exception {
        // �����ԋ敪(VisitCareCombo)�̎��Ԃ��擾
        // ���ԋ敪(VisitCareCombo)�̒l���`�F�b�N����B
        switch (getExpertPlaceRehabiliCombo().getSelectedIndex()) {
        case 0:
            // 2���Ԗ����̏ꍇ
            return 120;
        case 1:
            // 3���Ԗ����̏ꍇ
            return 180;
        case 2:
            // 4���Ԉȏ�̏ꍇ
            return 240;
        case 3:
            // 6���Ԉȏ�̏ꍇ
            return 360;
        case 4:
            // 8���Ԗ���
            return 480;
        }
        return 0;
    }

    /**
     * �u�n�斧���^�ʏ���쎞�Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getChiikiDayCareTime() throws Exception {
        // ���n�斧���^�ʏ���쎞�Ԏ擾
        // �����ԋ敪(ChiikiDayCareCombo)�̎��Ԃ��擾
        // ���ԋ敪(ChiikiDayCareCombo)�̒l���`�F�b�N����B
        switch (getChiikiDayCareCombo().getSelectedIndex()) {
        case 0:
            // �Q���Ԉȏ�R���Ԗ����̏ꍇ
            // �߂�l�Ƃ���180��Ԃ��B
            return 180;
        case 1:
            // �R���Ԉȏ�T���Ԗ����̏ꍇ
            // �߂�l�Ƃ���300��Ԃ��B
            return 300;
        case 2:
            // �S���Ԉȏ�V���Ԗ����̏ꍇ
            // �߂�l�Ƃ���420��Ԃ��B
            return 420;
        case 3:
            // �U���Ԉȏ�X���Ԗ����̏ꍇ
            // �߂�l�Ƃ���540��Ԃ��B
            return 540;
        }
        return 0;
    }

    /**
     * �u�n�斧���^�ʏ���쎞�Ԏ擾_�×{�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getChiikiDayCareTimeSpecial() throws Exception {
        // ���n�斧���^�ʏ���쎞�Ԏ擾_�×{
        // �����ԋ敪(ChiikiDayCareCombo)�̎��Ԃ��擾
        // ���ԋ敪(ChiikiDayCareCombo)�̒l���`�F�b�N����B
        switch (getChiikiDayCareCombo().getSelectedIndex()) {
        case 0:
            // 2���Ԉȏ�6���Ԗ����̏ꍇ
            // �߂�l�Ƃ���360��Ԃ��B
            return 360;
        case 1:
            // 6���Ԉȏ�8���Ԗ����̏ꍇ
            // �߂�l�Ƃ���480��Ԃ��B
            return 480;
        }
        return 0;
    }

    protected void addWelfareToolsGroup() {
        String osName = System.getProperty("os.name");
        if ((osName != null) && (osName.indexOf("Mac") >= 0)) {
            // Mac�̏ꍇ�A�i�g�𒲐����ĉ�ʓ��Ɏ��߂�
            getWelfareToolsGroup().add(getWelfareToolsComboContainer(),
                    VRLayout.FLOW);
            getWelfareToolsGroup().add(getWelfarePointTextContainer(),
                    VRLayout.FLOW_RETURN);
            getWelfareToolsGroup().add(getWelfareTekiyoTextContainer(),
                    VRLayout.FLOW);
        } else {
            super.addWelfareToolsGroup();
        }
    }

    @Override
    protected void visitCareRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        checkState();

    }

    @Override
    public void checkState() throws Exception {

        // �O���T�[�r�X���p�^�̖K���삪�I�΂�Ă����ꍇ
        if (getOutsideServiceRadio().isEnabled() 
        		&& getOutsideServiceRadio().getSelectedIndex() == 1) {
            // �ʉ@����~��I�����́A���ԋ敪�R���{�g�p�s��
            if (getVisitCareRadio().getSelectedIndex() == 3) {
                setState_INVALID_VISIT_CARE_COMBO();
            } else {
                setState_VALID_VISIT_CARE_COMBO();
            }
        }

        
        // �Z��敪�Łu2-���Z�̂݁v���I������Ă���
        // ���A�Ŏ������Z���L�����A�u1-�Ȃ��v�ȊO�̏ꍇ
        if ((getCalculationDivisionRadio().getSelectedIndex() == 2)
                && (getTerminalCareAddRadioGroup().isEnabled()) 
                && (getTerminalCareAddRadioGroup().getSelectedIndex() != 1)) {

            // �Ŏ������Z�����P�ʗL��
            setState_VALID_TERMINAL();

        } else {
            // �Ŏ������Z�����P�ʖ���
            setState_INVALID_TERMINAL();

        }
    }
    
    @Override
    public void binded() throws Exception {
    	checkState();
    }



}
