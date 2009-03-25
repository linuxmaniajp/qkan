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
 * �쐬��: 2009/02/09  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����V�l�����{�� (QS001118_H2104)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
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
import jp.nichicom.ac.component.table.event.*;
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
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * �T�[�r�X�p�^�[�����V�l�����{��(QS001118_H2104)
 */
public class QS001118_H2104 extends QS001118_H2104Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001118_H2104() {
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
        case 2:
            // �u��앟���{�݁v�������́u���K�͉�앟���{�݁v�̏ꍇ
            // �u�a���敪�i��앟���{�݁j�v��L���ɂ��A�u�a���敪�i���j�b�g�^��앟���{�݁j�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            // �����j�b�g�P�A�̐�
            setState_VALID_SUB_UNIT_CARE();
            break;
        case 3:
        case 4:
            // �u���j�b�g�^��앟���{�݁v�������́u���j�b�g�^���K�͉�앟���{�݁v�̏ꍇ
            // �u�a���敪�i���j�b�g�^��앟���{�݁j�v�𖳌��ɂ��A�u�a���敪�i��앟���{�݁j�v��L���ɂ���B
            setState_UNIT_FORM();
            if (!getUnitCareFlag()) {
                setState_INVALID_UNIT_CARE();
            }
            // �����j�b�g�P�A�̐�
            setState_INVALLID_SUB_UNIT_CARE();
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


    /**
     * �u�Ŏ����̗L����ԁv�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoWelfareFacilityTakingCareNursingAddRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // ���Ŏ����̗L����Ԃ�ύX
        // �Ŏ����̗L����Ԃ�ύX����B
        if(getKaigoWelfareFacilityTakingCareNursingAddRadioItem1().isSelected()){
            setState_INVALID_TERMINAL();
        }else{
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
        // �o���ڍs���Z�̏�Ԃ���Ɍo���ێ����Z�̗L����Ԃ�ύX
        if(getKaigoWelfareFacilityOralSwitchRadioItem1().isSelected()){
            setState_VALID_KEEP_NUTRITION();
        }else{
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
        // �o���ێ����Z�̏�Ԃ���Ɍo���ێ����Z�̗L����Ԃ�ύX
        if(getKaigoWelfareFacilityJunOralSwitchRadioItem1().isSelected()){
            setState_VALID_NUTRITION();
        }else{
            setState_INVALID_NUTRITION();
        }

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001118_H2104.class.getName(),
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
        // �H����
        comboItemMap.setData("1510121", QkanCommon.getArrayFromMasterCode(191,
                "1510121"));
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
        VRBindPathParser.set("1510121", defaultMap, new Integer(1));

        // 2006/05/15 �\�h�Ή�(�v�]�j
        // ���[�u�����҃`�F�b�N�̒l��ݒ�
        if (isOldFacilityUser()) {
            VRBindPathParser.set("8", defaultMap, new Integer(2));
        } else {
            VRBindPathParser.set("8", defaultMap, new Integer(1));
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
        // �I�����Ə����null�łȂ��ꍇ
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = new VRHashMap();
            // ���ݒ�
            Object obj;
            // �{�݋敪
            obj = VRBindPathParser.get("1510101", provider);
            if (obj != null) {
                VRBindPathParser.set("1510101", defaultMap, obj);
            }

            // �l�����Z
            obj = VRBindPathParser.get("1510112", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1510120", defaultMap, new Integer(1));
                    break;
                case 2: // �Ō�E���������ꍇ
                case 3: // ���E���������ꍇ
                case 4: // ���x�������̏ꍇ
                    VRBindPathParser.set("1510120", defaultMap, new Integer(3));
                    break;
                }
            }

            // ���j�b�g�P�A�̐���
            obj = VRBindPathParser.get("1510121", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    setState_INVALID_UNIT_CARE();
                    setUnitCareFlag(false);
                    VRBindPathParser.set("1510124", defaultMap, obj);
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    setState_VALID_UNIT_CARE();
                    setUnitCareFlag(true);
                    VRBindPathParser.set("1510124", defaultMap, obj);
                    break;
                }
            } else {
                // ���Ə��o�^�œo�^����Ă��Ȃ������ꍇ�͈ꗥ�����ɂ���B
                setUnitCareFlag(false);
            }

            // �����j�b�g�P�A
            obj = VRBindPathParser.get("1510122", provider);
            if (obj != null) {
                VRBindPathParser.set("1510125", defaultMap, obj);
            }

            // ��Α̐����Z
            obj = VRBindPathParser.get("1510102", provider);
            if (obj != null) {
                VRBindPathParser.set("1510106", defaultMap, obj);
            }
            // �ʋ@�\�P���w�����Z
            obj = VRBindPathParser.get("1510103", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    setState_INVALID_FUNCTION_TRAINING();
                    // ���Ə��̐��𔽉f
                    setFunctionTrainingFlag(false);
                    VRBindPathParser.set("1510107", defaultMap, obj);
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    setState_VALID_FUNCTION_TRAINING();
                    // ���Ə��̐��𔽉f
                    setFunctionTrainingFlag(true);
                    VRBindPathParser.set("1510107", defaultMap, obj);
                    break;
                }
            }
            // ��t��Ή��Z
            obj = VRBindPathParser.get("1510104", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    setState_INVALID_DOCTOR();
                    break;
                case 2:
                    setState_VALID_DOCTOR();
                    break;
                }
                VRBindPathParser.set("1510108", defaultMap, obj);
            }
            // ���_�Ȉ�w�����Z
            obj = VRBindPathParser.get("1510105", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    setState_INVALID_PSYCHIATRIST();
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    setState_VALID_PSYCHIATRIST();
                    break;
                }
                VRBindPathParser.set("1510109", defaultMap, obj);
            }

            // ��Q�Ґ�����������Ή��Z
            obj = VRBindPathParser.get("1510106", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    setState_INVALID_HANDICAPPED();
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    setState_VALID_HANDICAPPED();
                    break;
                }
                VRBindPathParser.set("1510110", defaultMap, obj);
            }

            // �h�{�}�l�W�����g���Z
            obj = VRBindPathParser.get("1510134", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    setState_INVALID_MANAGE();
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    VRBindPathParser.set("1510114", defaultMap, obj);
                    setState_VALID_MANAGE();
                    break;
                }
            }
            // �g�̍S�������{���Z
            obj = VRBindPathParser.get("1510124", provider);
            if (obj != null) {
                // �g�̍S�������{��g�݂Ȃ��������ꍇ
                if (ACCastUtilities.toInt(obj) == 1) {
                    VRBindPathParser.set("1510128", defaultMap, new Integer(2));
                } else if (ACCastUtilities.toInt(obj) == 2) {
                    // �g�̍S�������{��g�݂��肾�����ꍇ
                    VRBindPathParser.set("1510128", defaultMap, new Integer(1));
                }
            }

            // �×{�H���Z
            obj = VRBindPathParser.get("1510131", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    setState_INVALID_MEDICAL_EXPENSES();
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    setState_VALID_MEDICAL_EXPENSES();
                    VRBindPathParser.set("1510116", defaultMap, obj);
                    break;
                }
            }
            
            // ���퐶���p���x�����Z:1510127
            obj = VRBindPathParser.get("1510127", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    VRBindPathParser.set("1510133", defaultMap, new Integer(1));
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    VRBindPathParser.set("1510133", defaultMap, new Integer(2));
                    break;
                }
            }
            
            // �Ō�̐����Z:1510128
            obj = VRBindPathParser.get("1510128", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    VRBindPathParser.set("1510134", defaultMap, new Integer(1));
                    setState_INVALID_NIGHT_NURSE();
                    break;                                        
                case 2:
                    // �̐�����̏ꍇ
                    // ���Ə��ƃT�[�r�X�Ō`���قȂ邽�ߒl�̘A���͍s��Ȃ��B
                    setState_VALID_NIGHT_NURSE();
                    break;                    
                    
                }
            }
            
            // ��ΐE���z�u���Z:1510129
            obj = VRBindPathParser.get("1510129", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    VRBindPathParser.set("1510135", defaultMap, new Integer(1));
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    VRBindPathParser.set("1510135", defaultMap, new Integer(2));
                    break;
                }
            }
              
            // ��N���F�m�Ǔ����Ҏ�����Z:1510130
            obj = VRBindPathParser.get("1510130", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    setState_INVALID_YOUNG_DEMENTIA_PATINET();
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    setState_VALID_YOUNG_DEMENTIA_PATINET();
                    break;
                }
            }
            //���defaultMap�� KEY�F1510137 VALUE�F1�i�Ȃ��j��ݒ肷��B
            VRBindPathParser.set("1510137", defaultMap, new Integer(1));
            
            // �h�{�}�l�W�����g�̐�:1510134
            // ��L�𕜊�
            
            //�F�m�ǐ��P�A���Z�i���Ə��p�l���jKEY�F1510132�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1510132", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            case 2:
                //2�i���ZI�j
            case 3:
                //3�i���ZII�j
                //�L���ɂ���B
                setState_VALID_DEMENTIA_PRO_CARE();
                break;
            default:
                //�l����L�ȊO�������ꍇ
                //�����ɂ���B
                setState_INVALID_DEMENTIA_PRO_CARE();
                break;
            }
            //���defaultMap�� KEY�F1510140 VALUE�F1�i�Ȃ��j��ݒ肷��B
            VRBindPathParser.set("1510140", defaultMap, new Integer(1));   
            
            //�T�[�r�X�񋟑̐��������Z�i���Ə��p�l���jKEY�F1510133�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1510133", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //�l�����̂����ꂩ�������ꍇ
            case 2:
                //2�iI�^�j
            case 3:
                //3�iII�^�j
            case 4:
                //4�iIII�^�j
                //defaultMap�� KEY�F1510141 VALUE�F���Ə��̒l��ݒ肷��B
                VRBindPathParser.set("1510141", defaultMap, obj);   
                break;
            default:
                //�l����L�ȊO�������ꍇ
                //defaultMap�� KEY�F1510141 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1510141", defaultMap, new Integer(1));   
                break;
            }
            
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

            if (getKaigoWelfareFacilityDinnerOffer().getSelectedIndex() == 0) {
                //�H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getKaigoWelfareFacilityDinnerOffer().setSelectedIndex(1);
            }
            
            // �Ō�̐����T�^�A�U�^�̏ꍇ
            switch(getNurseStructuralAddRadioGroup().getSelectedIndex()) {
            case 2:
            case 3:
                setState_VALID_NIGHT_NURSE();
                break;
            default:
                setState_INVALID_NIGHT_NURSE();
                break;
            }
        }

    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
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
        // �@���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
        getThis().setSource(data);
        // �@���g(this)��applySource���Ăяo���ăf�[�^�����W����B
        getThis().applySource();
        // ���ԋp�p���R�[�h����s�v�ȃL�[������
        QkanCommon.removeDisabledBindPath(getThis(), data);
        // �@���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
        return data;
    }

    /**
     * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public boolean isUseProvider() throws Exception {
        // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
        // �@true��Ԃ��B
        return true;
    }

    /**
     * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ���J�n�������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return null;
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
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
                        .get("1510113", getSelectedProvider()), 0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1510114", getSelectedProvider()), 0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1510115", getSelectedProvider()), 0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1510116", getSelectedProvider()), 0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1510114", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1510115",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1510115", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1510116",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1510116", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1510114",
                                getSelectedProvider()), 0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
    }
    
    /**
     * �Ō�̐����Z�̕ύX���̏���
     */
    protected void nurseStructuralAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception {
        // �Ō�̐����T�^�A�U�^�̏ꍇ
        switch(getNurseStructuralAddRadioGroup().getSelectedIndex()) {
        case 2:
        case 3:
            setState_VALID_NIGHT_NURSE();
            break;
        default:
            setState_INVALID_NIGHT_NURSE();
            break;
        }
    }

    /**
     * �u�T�[�r�X�@�����敪�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     *
     * @throws Exception ������O
     * @return int
     */
    public int getServiceLowVersion() throws Exception {
        //�����̃T�[�r�X�p�l���������T�[�r�X�̖@�����敪(M_DETAIL.SYSTEM_BIND_PATH=14)��Ԃ��B 
        //QkanConstants.SERVICE_LOW_VERSION_H2104 ��Ԃ��B
        return QkanConstants.SERVICE_LOW_VERSION_H2104;
    }
}
