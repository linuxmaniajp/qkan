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
 * �v���O���� �T�[�r�X�p�^�[�����V�l�ی��{�� (QS001119)
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

/**
 * �T�[�r�X�p�^�[�����V�l�ی��{��(QS001119)
 */
public class QS001119 extends QS001119Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001119() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoHealthCareOfTheAgedDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getKaigoHealthCareOfTheAgedDivisionRadio().getSelectedIndex()) {
        case 1:
        case 2:
            // �u���ی��{�݁v�̏ꍇ
            // �u�a���敪�i���V�l�ی��{�݁j�v��L���ɂ��A�u�a���敪�i���j�b�g�^���V�l�ی��{�݁j�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            break;
        case 3:
        case 4:
            // �u���j�b�g�^���ی��{�݁v�̏ꍇ
            // �u�a���敪�i���V�l�ی��{�݁j�v�𖳌��ɂ��A�u�a���敪�i���j�b�g�^���V�l�ی��{�݁j�v��L���ɂ���B
            setState_UNIT_FORM();
            // ���j�b�g�P�A�̐����Ȃ��������ꍇ�͖����ɂ���
            if (!getUnitCareFlag()) {
                setState_INVALID_UNIT_CARE();
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
    protected void kaigoHealthCareOfTheAgedDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getKaigoHealthCareOfTheAgedDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            setState_NOT_USE_MEAT();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            setState_USE_MEAT();
            // �H����p(kaigoHealthCareOfTheAgedDinnerCost)��ݒ肷��B
            getKaigoHealthCareOfTheAgedDinnerCost().setText(
                    getMeatCost(getKaigoHealthCareOfTheAgedDinnerOffer()
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
        ACFrame.debugStart(new ACAffairInfo(QS001119.class.getName(), param));
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
        comboItemMap.setData("1520120", QkanCommon.getArrayFromMasterCode(191,
                "1520120"));
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
        VRBindPathParser.set("1520120", defaultMap, new Integer(1));
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
            Object obj;
            // �{�݋敪
            obj = VRBindPathParser.get("1520101", provider);
            if (obj != null) {
                VRBindPathParser.set("1520101", defaultMap, obj);
            }
            // ��ԋΖ������
            obj = VRBindPathParser.get("1520102", provider);
            if (obj != null) {
                VRBindPathParser.set("1520104", defaultMap, obj);
            }
            // �l�����Z
            obj = VRBindPathParser.get("1520109", provider);
            if (obj != null) {
                
                //���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch(ACCastUtilities.toInt(obj)){
                case 1: //�Ȃ��������ꍇ
                    VRBindPathParser.set("1520119", defaultMap, new Integer(1));
                    break;
                case 2: //��t�������ꍇ
                case 3: //�Ō�E���������ꍇ
                case 4: //���E���������ꍇ
                case 5: //���w�Ö@�m�������ꍇ
                case 6: //��ƗÖ@�m�������ꍇ
                case 7: //���x�������������ꍇ
                    VRBindPathParser.set("1520119", defaultMap, new Integer(3));
                    break;
                }
            }
            // ���W�J

            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // �h�{�Ǘ�
            obj = VRBindPathParser.get("1520105", provider);
            if (obj != null) {
                if(new Integer(2).equals(ACCastUtilities.toInteger(obj))){
                    VRBindPathParser.set("1520110",defaultMap,new Integer(3));
                }else if(new Integer(3).equals(ACCastUtilities.toInteger(obj))){
                    VRBindPathParser.set("1520110",defaultMap,new Integer(2));
                }
//                switch (ACCastUtilities.toInt(obj)) {
//                case 4:
//                case 3:
//                    //�u�Ǘ��h�{�m�v�̏ꍇ
//                    // �L���ɂ���B
//                    setState_VALID_DIETICIAN_MANAGE();
//                    break;
//                case 2:
//                    // �u�h�{�m�v�̏ꍇ
//                    // �L���ɂ���B
//                    setState_VALID_DIETICIAN_MANAGE();
//                    break;
//                case 1:
//                    // �u�Ȃ��v�̏ꍇ
//                    // �����ɂ���B
//                    setState_INVALID_DIETICIAN_MANAGE();
//                    break;
//                }
            }
            // �h�{�}�l�W�����g
            obj = VRBindPathParser.get("1520106", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_MANAGE();
                } else {
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_MANAGE();
                }
                VRBindPathParser.set("1520111", defaultMap, obj);
            }
            // �o���ڍs
            obj = VRBindPathParser.get("1520107", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_NUTRITION();
                } else {
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_NUTRITION();
                }
            }
            // �×{�H
            obj = VRBindPathParser.get("1520108", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_MEDICAL_EXPENSES();
                } else {
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_MEDICAL_EXPENSES();
                }
            }
            // ���j�b�g�P�A�̐�
            obj = VRBindPathParser.get("1520119", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    defaultMap.setData("1520127", obj);
                    setState_INVALID_UNIT_CARE();
                    setUnitCareFlag(false);
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    defaultMap.setData("1520127", obj);
                    setState_VALID_UNIT_CARE();
                    setUnitCareFlag(true);
                    break;
                }
            }else{
                //���Ə��o�^�œo�^����Ă��Ȃ������ꍇ�͈ꗥ�����ɂ���B
                setUnitCareFlag(false);
            }
            
            // ���n�r���}�l�W�����g���Z
            obj = VRBindPathParser.get("1520118", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    defaultMap.setData("1520123", obj);
                    setState_INVALID_REHABILI_MANAGWE();
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    defaultMap.setData("1520123", obj);
                    setState_VALID_REHABILI_MANAGWE();
                    break;
                }
            }
            
            //�g�̍S�������{���Z
            obj = VRBindPathParser.get("1520120",provider);
            if(obj != null){
                //�g�̍S�������{��g�ݖ����������ꍇ
                if(ACCastUtilities.toInt(obj) == 1){
                    defaultMap.setData("1520130",new Integer(2));
                }else if(ACCastUtilities.toInt(obj) == 2){
                    //�g�̍S�������{��g�ݗL�肾�����ꍇ
                    defaultMap.setData("1520130",new Integer(1));
                }
            }

            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

            if(getKaigoHealthCareOfTheAgedDinnerOffer().getSelectedIndex()==0){
                //�H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getKaigoHealthCareOfTheAgedDinnerOffer().setSelectedIndex(1);
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
                        .get("1520110", getSelectedProvider()), 0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520111", getSelectedProvider()), 0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520112", getSelectedProvider()), 0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520113", getSelectedProvider()), 0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520111", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520112",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520112", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520113",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520113", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520111",
                                getSelectedProvider()), 0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
    }

    /**
     * �u�o���ڍs���Z�̕ύX�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoHealthCareOfTheAgedOralSwitchRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        //�o���ڍs���Z
        if(getKaigoHealthCareOfTheAgedOralSwitchRadioItem1().isSelected()){
            setState_VALID_KEEP_NUTRITION();
        }else{
            setState_INVALID_KEEP_NUTRITION();
        }      
    }

    /**
     * �u�o���ێ����Z�̕ύX�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void oralMaintenanceAddRadioSelectionChanged(ListSelectionEvent e) throws Exception {
//      �o���ێ����Z
        if(getOralMaintenanceAddRadioItem1().isSelected()){
            setState_VALID_NUTRITION();
        }else{
            setState_INVALID_NUTRITION();
        }
    }

    /**
     * �O�����Z
     */
    protected void kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        //�O�����Z���肾�����΂���
        if(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2().isSelected()){
            setState_INVALID_TRIAL_HIJO();
            getTrialHijoRadioItem1().setSelected(true);
        }else{
            setState_VALID_TRIAL_HIJO();
        }
        
    }

    /**
     * ���s�I�ޏ�
     */
    protected void trialHijoRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        //���s�I�ޏ������肾�����ꍇ
        if(getTrialHijoRadioItem2().isSelected()){
            setState_INVALID_GAIHAKU();
            //�O�����Z�Ȃ��������I��
            getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1().setSelected(true);
        }else{
            setState_VALID_GAIHAKU();
        }
        
        
    }
}
