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
 * �v���O���� �T�[�r�X�p�^�[���n�斧���^��앟���{�� (QS001129)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.beans.DefaultPersistenceDelegate;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;

/**
 * �T�[�r�X�p�^�[���n�斧���^��앟���{��(QS001129)
 */
public class QS001129 extends QS001129Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001129() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoWelfareFacilityInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getKaigoWelfareFacilityInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // �u��앟���{�݁v�̏ꍇ
            // �u�a���敪�i��앟���{�݁j�v��L���ɂ��A�u�a���敪�i���j�b�g�^��앟���{�݁j�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            break;
        case 2:
            // �u���j�b�g�^��앟���{�݁v�̏ꍇ
            // �u�a���敪�i���j�b�g�^��앟���{�݁j�v�𖳌��ɂ��A�u�a���敪�i��앟���{�݁j�v��L���ɂ���B
            setState_UNIT_FORM();
            if (getInvalidUnitCareProvider()) {
                setState_VALID_UNIT_CARE();
            }
            break;
        }
    }

    /**
     * �u�H���񋟑I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoWelfareFacilityDinnerOfferActionPerformed(ActionEvent e)
            throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getKaigoWelfareFacilityDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            setState_NOT_USE_MEAT();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            setState_USE_MEAT();
            // �H����p(kaigoWelfareFacilityDinnerCost)��ݒ肷��B
            getKaigoWelfareFacilityDinnerCost().setText(
                    getMeatCost(getKaigoWelfareFacilityDinnerOffer()
                            .getSelectedIndex()));
        }

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001129.class.getName(), param));
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
        // ���H����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1510120 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1510120", QkanCommon.getArrayFromMasterCode(191,
                "1540120"));
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
        // �H���񋟂́u�Ȃ��v��I������B
        defaultMap.setData("1540120", new Integer(1));
        
        // 2006/05/15 �\�h�Ή�(�v�]�j
        // ���[�u�����҃`�F�b�N�̒l��ݒ�
        if(isOldFacilityUser()){
            VRBindPathParser.set("8",defaultMap,new Integer(2));
        } else {
            VRBindPathParser.set("8",defaultMap,new Integer(1));
        }
        
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
        setSelectedProvider(provider);
        if (provider != null) {
            // �I�����Ə����null�łȂ��ꍇ
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = new VRHashMap();
            // ���ݒ�
            // ���[�u�����҂ł���ꍇ
            if (isOldFacilityUser()) {
                // �T�[�r�X�R�[�h��o�ߓI�`�F�b�N�͕K�{�̂��ߌł߂���Ń`�F�b�N��Ԃɂ���B
                setState_INVALID_PASSAGE_REGION();
                VRBindPathParser.set("1540102", defaultMap, new Integer(2));
            } else {
                setState_VALID_PASSAGE_REGION();
                // �o�ߓI�n�斧��
                VRBindPathParser.set("1540102", defaultMap, VRBindPathParser.get(
                        "1540102", provider));
                //���[�u�`�F�b�N���I����Ԃ������ꍇ
                if(getKaigoWelfareFacilityOldMeasuresPerson().isSelected()){
                    setState_INVALID_PASSAGE_REGION();
                }
            }
            
            
            // ���j�b�g�P�A�̐���
            VRBindPathParser.set("1540105", defaultMap, VRBindPathParser.get(
                    "1540113", provider));
            // ��ԋΖ����Z
            VRBindPathParser.set("1540107", defaultMap, VRBindPathParser.get(
                    "1540103", provider));
            // �ʋ@�\�P���w�����Z
            VRBindPathParser.set("1540108", defaultMap, VRBindPathParser.get(
                    "1540104", provider));
            // ��t��Ή��Z
            VRBindPathParser.set("1540109", defaultMap, VRBindPathParser.get(
                    "1540105", provider));
            // �l�����Z
            Object obj;
            // �{�݋敪
            obj = VRBindPathParser.get("1540101", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: //
                case 2: //
                    VRBindPathParser.set("1540101", defaultMap, new Integer(1));
                    break;
                case 3: //
                case 4: //
                    VRBindPathParser.set("1540101", defaultMap, new Integer(2));
                    break;
                }
            }
            obj = VRBindPathParser.get("1540112", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1540119", defaultMap, new Integer(1));
                    break;
                case 2: // �Ō�E���������ꍇ
                case 3: // ���E���������ꍇ
                case 4: // ���x�������������ꍇ
                    VRBindPathParser.set("1540119", defaultMap, new Integer(3));
                    break;
                }
            }

            // �d�x���Ή����Z
            VRBindPathParser.set("1540122", defaultMap, VRBindPathParser.get(
                    "1540115", provider));
            
            // �g�̍S�������{���Z
            obj = VRBindPathParser.get("1540116", provider);
            if(obj != null){
            	switch(ACCastUtilities.toInt(obj)){
            	case 1:		// �g�̍S���p�~��g���Ȃ��ꍇ
            		VRBindPathParser.set("1540123", defaultMap, new Integer(2));
            		break;
            	case 2:		// �g�̍S���p�~��g������ꍇ
            		VRBindPathParser.set("1540123", defaultMap, new Integer(1));
            		break;
            	}
            }

            // �����j�b�g�P�A
            obj = VRBindPathParser.get("1540114", provider);
            if (obj != null) {
                VRBindPathParser.set("1540106", defaultMap, obj);
            }

            // �h�{�Ǘ��̐����Z
            obj = VRBindPathParser.get("1540108", provider);
            if (obj != null) {
//                if (new Integer(2).equals(ACCastUtilities.toInteger(obj))) {
//                    VRBindPathParser.set("1540114", defaultMap, new Integer(3));
//                } else if (new Integer(3)
//                        .equals(ACCastUtilities.toInteger(obj))) {
//                    VRBindPathParser.set("1540114", defaultMap, new Integer(2));
//                }
                switch (ACCastUtilities.toInt(obj)) {
				case 3:
					// �u�Ǘ��h�{�m�v�̏ꍇ
					VRBindPathParser.set("1540114", defaultMap, new Integer(2));
					break;
				case 2:
					// �u�h�{�m�v�̏ꍇ
					// �L���ɂ���B
					// setState_VALID_DIETICIAN_MANAGE();
					VRBindPathParser.set("1540114", defaultMap, new Integer(3));
					break;
				case 1:
					// �u�Ȃ��v�̏ꍇ
					// �����ɂ���B
					// setState_INVALID_DIETICIAN_MANAGE();
					VRBindPathParser.set("1540114", defaultMap, new Integer(1));
					break;
				}
            }
            
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // ���j�b�g�P�A�̐���
            obj = VRBindPathParser.get("1540113", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    if (getKaigoWelfareFacilityInstitutionDivisionRadioItem3()
                            .isSelected()) {
                        setState_VALID_UNIT_CARE();
                    }
                    setInvalidUnitCareProvider(true);
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_UNIT_CARE();
                    setInvalidUnitCareProvider(false);
                    break;
                }
            } else {
                // �u�Ȃ��v�̏ꍇ
                // �����ɂ���B
                setState_INVALID_UNIT_CARE();
                setInvalidUnitCareProvider(false);
            }
            // �ʋ@�\�P���w�����Z
            obj = VRBindPathParser.get("1540104", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_FUNCTION_TRAINING();
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_FUNCTION_TRAINING();
                    break;
                }
            }
            // ��t��Ή��Z
            obj = VRBindPathParser.get("1540105", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_DOCTOR();
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_DOCTOR();
                    break;
                }
            }

            // ���_�Ȉ�w�����Z
            obj = VRBindPathParser.get("1540106", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_PSYCHIATRIST();
                    VRBindPathParser.set("1540110", defaultMap, obj);
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_PSYCHIATRIST();
                    VRBindPathParser.set("1540110", defaultMap, obj);	
                    break;
                }
            }

            // ��Q�Ґ�����������Ή��Z
            obj = VRBindPathParser.get("1540107", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_HANDICAPPED();
                    VRBindPathParser.set("1540111", defaultMap, obj);	
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_HANDICAPPED();
                    VRBindPathParser.set("1540111", defaultMap, obj);	
                    break;
                }
            }

            // �h�{�}�l�W�����g���Z
            obj = VRBindPathParser.get("1540109", provider);
            if (obj != null) {
                // VRBindPathParser.set("1540114",defaultMap,obj);
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_NUTRITION();
                    VRBindPathParser.set("1540115", defaultMap, obj);	
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_NUTRITION();
                    VRBindPathParser.set("1540115", defaultMap, obj);	
                    break;
                }
            }

            // �o���ڍs���Z
            obj = VRBindPathParser.get("1540110", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_ORAL_SWITCH();
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_ORAL_SWITCH();
                    break;
                }
            }

            // �×{�H���Z
            obj = VRBindPathParser.get("1540111", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_MEDICAL_EXPENSES();
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_MEDICAL_EXPENSES();
                    break;
                }
            }

            // �d�x���Ή����Z
            obj = VRBindPathParser.get("1540115", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_HEAVILY();
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_HEAVILY();
                    break;
                }
            }
            
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

            if(getKaigoWelfareFacilityDinnerOffer().getSelectedIndex()==0){
                //�H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getKaigoWelfareFacilityDinnerOffer().setSelectedIndex(1);
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
        if (!getKaigoWelfareFacilityInstitutionDivisionRadio().isSelected()) {
            // �{�݋敪�R���{(kaigoWelfareFacilityInstitutionDivisionRadio)�����I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }

        if ((getKaigoWelfareFacilityHospitalRoomDivisionRadio().isEnabled() && (!getKaigoWelfareFacilityHospitalRoomDivisionRadio()
                .isSelected()))
                || (getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio()
                        .isEnabled() && (!getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio()
                        .isSelected()))) {
            // �a���敪�i��앟���{�݁j(kaigoWelfareFacilityHospitalRoomDivisionRadio)���L���ł����I���̏ꍇ
            // �������͕a���敪�i���j�b�g�^��앟���{�݁j(kaigoWelfareFacilityUnitHospitalRoomDivisionRadio)���L���ł����I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if (getKaigoWelfareFacilityDinnerCost().isEnabled()
                && ACTextUtilities
                        .isNullText(getKaigoWelfareFacilityDinnerCost()
                                .getText())) {
            // �H����p(kaigoWelfareFacilityDinnerCost)���L���ł��󗓂̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if (getKaigoWelfareFacilityTakingCareNursingAddDays().isEnabled()) {
            int days = ACCastUtilities
                    .toInt(getKaigoWelfareFacilityTakingCareNursingAddDays()
                            .getText(), 99);
            if ((days > 30) || (days < 1)) {
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
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
     * �u�H����p���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param meatType int
     * @throws Exception ������O
     * @return String
     */
    public String getMeatCost(int meatType) throws Exception {
        // ���H�����������ƂɑI�����Ə��ɂ�����H����p��Ԃ��B
        if (getSelectedProvider() != null) {
            // ���Ə���I�����Ă���ꍇ
            switch (meatType) {
            case 1:
                // �H���������u������v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��A�u��v�̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1540117", getSelectedProvider()), 0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1540118", getSelectedProvider()), 0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1540119", getSelectedProvider()), 0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1540120", getSelectedProvider()), 0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1540118", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1540119",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1540119", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1540120",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1540120", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1540118",
                                getSelectedProvider()), 0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
    }

    /**
     * �u�Ŏ����̗L����ԁv�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoWelfareFacilityTakingCareNursingAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        if (getKaigoWelfareFacilityTakingCareNursingAddRadioItem1()
                .isSelected()) {
            setState_INVALID_TERMINAL();
        } else {
            setState_VALID_TERMINAL();
        }
    }

    /**
     * �u�o���ڍs���Z�̕ύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoWelfareFacilityOralSwitchRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // �o���ڍs���Z
        if (getKaigoWelfareFacilityOralSwitchRadioItem1().isSelected()) {
            setState_VALID_KEEP_NUTRITION();
        } else {
            setState_INVALID_KEEP_NUTRITION();
        }
    }

    /**
     * �u�o���ێ����Z�̕ύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoWelfareFacilityJunOralSwitchRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // �o���ێ����Z
        if (getKaigoWelfareFacilityJunOralSwitchRadioItem1().isSelected()) {
            setState_VALID_ORAL_SWITCH();
        } else {
            setState_INVALID_ORAL_SWITCH();
        }
    }

    /**
     * �u���[�u�����҃`�F�b�N�v�C�x���g�ł��B
     */
    protected void kaigoWelfareFacilityOldMeasuresPersonActionPerformed(ActionEvent e) throws Exception {
        //���[�u�����҂������ꍇ
        if(getKaigoWelfareFacilityOldMeasuresPerson().isSelected()){
        //�o�ߓI�n�斧���^�T�[�r�X�̏�Ԃ��`�F�b�N����B
            if(getPassageRegionServiceCheck().isEnabled()){
            //Enable��true�������ꍇ
                //��ʂ̏�Ԃ�ύX����B
                setState_INVALID_PASSAGE_REGION();
            }
        }else{
            //��ʂ̏�Ԃ�ύX����B
            setState_VALID_PASSAGE_REGION();
        }
    }

    /**
     * �f�[�^�o�C���h���̏���
     */
    public void binded() throws Exception {
        //���[�u�`�F�b�N���I����Ԃ������ꍇ
        if(getKaigoWelfareFacilityOldMeasuresPerson().isSelected()){
            setState_INVALID_PASSAGE_REGION();
        }else{
            setState_VALID_PASSAGE_REGION();
        }
        
    }
        
}
