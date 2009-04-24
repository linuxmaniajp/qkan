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
 * �v���O���� �T�[�r�X�p�^�[���Z������������� (QS001109_H2104)
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
 * �T�[�r�X�p�^�[���Z�������������(QS001109_H2104)
 */
public class QS001109_H2104 extends QS001109_H2104Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001109_H2104() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayLifeTimeContenaFacilityDivisionActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getShortStayLifeTimeContenaFacilityDivision()
                .getSelectedIndex()) {
        case 1:
        case 2:
            // �u�P�ƌ^�v�������́u���݌^�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v��L���ɂ��A�u�a���敪(���j�b�g�^)�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            break;
        case 3:
        case 4:
            // �u�P�ƌ^���j�b�g�^�v�������́u���݌^���j�b�g�^�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v�𖳌��ɂ��A�u�a���敪(���j�b�g�^)�v��L���ɂ���B
            setState_UNIT_FORM();
            // ���j�b�g�P�A�̑̐����Ȃ��ꍇ�͖����ɂ���B
            if (!getUnitCareFlag()) {
                setState_INVALID_UNIT_CARE();
            }
        }

    }

    /**
     * �u�H���񋟑I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayLifeDinnerOfferActionPerformed(ActionEvent e)
            throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getShortStayLifeDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            setState_NOT_USE_MEAT();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            setState_USE_MEAT();
            // �H����p(shortStayLifeDinnerCost)��ݒ肷��B
            getShortStayLifeDinnerCost().setText(
                    getMeatCost(getShortStayLifeDinnerOffer()
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
        ACFrame.debugStart(new ACAffairInfo(QS001109_H2104.class.getName(),
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
        // ���H����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1210111 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1210111", QkanCommon.getArrayFromMasterCode(191,
                "1210111"));
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
        //���H����
        //comboItemMap�� KEY : 1210111 �� VALUE �Ƃ���1��ݒ肷��B
        VRBindPathParser.set("1210111", defaultMap, new Integer(1));
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
            obj = VRBindPathParser.get("1210101", provider);
            if (obj != null) {
                VRBindPathParser.set("1210101", defaultMap, obj);
            }
            // �l�����Z
            obj = VRBindPathParser.get("1210107", provider);
            if (obj != null) {
                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1210110", defaultMap, new Integer(1));
                    break;
                case 2: // �Ō�E���������ꍇ
                case 3: // ���E���������ꍇ
                    VRBindPathParser.set("1210110", defaultMap, new Integer(3));
                    break;
                }
            }

            // �@�\�P���ɑ΂���̐����Z
            obj = VRBindPathParser.get("1210103", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    VRBindPathParser.set("1210106", defaultMap, obj);
                    setState_VALID_FUNCTION_TRAINING();
                } else if (ACCastUtilities.toInt(obj) == 1) {
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    VRBindPathParser.set("1210106", defaultMap, obj);
                    setState_INVALID_FUNCTION_TRAINING();
                }
            }
            // ��ԋΖ������
            obj = VRBindPathParser.get("1210102", provider);
            if (obj != null) {
                VRBindPathParser.set("1210105", defaultMap, obj);
            }
            // �×{�H
            if (ACCastUtilities.toInt(VRBindPathParser.get("1210123", provider),0) == 2) {
                // �u����v�̏ꍇ
                // �L���ɂ���B
                setState_VALID_MEDICAL_EXPENSES();
                // [ID:0000481][Tozo TANAKA] 2009/04/08 delete begin ����21�N4���@�����Ή�(�×{�H)
                //VRBindPathParser.set("1210109", defaultMap, new Integer(2));
                // [ID:0000481][Tozo TANAKA] 2009/04/08 delete end
            } else {
                // �u�Ȃ��v�̏ꍇ
                // �����ɂ���B
                setState_INVALID_MEDICAL_EXPENSES();
                // [ID:0000481][Tozo TANAKA] 2009/04/08 delete begin ����21�N4���@�����Ή�(�×{�H)
                //VRBindPathParser.set("1210109", defaultMap, new Integer(1));
                // [ID:0000481][Tozo TANAKA] 2009/04/08 delete end
            }
            // [ID:0000481][Tozo TANAKA] 2009/04/08 add begin ����21�N4���@�����Ή�(�×{�H)
            //���defaultMap�� KEY�F1210109 VALUE�F1�i�Ȃ��j��ݒ肷��B
            VRBindPathParser.set("1210109", defaultMap, new Integer(1));   
            // [ID:0000481][Tozo TANAKA] 2009/04/08 add end
            
            // �l�b�g���[�N���Z
            obj = VRBindPathParser.get("1210117", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 1) {
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_SHORT_NETWORK();
                    VRBindPathParser.set("1210116", defaultMap, obj);
                } else {
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_SHORT_NETWORK();
                    // VRBindPathParser.set("1210116",defaultMap,obj);
                }
            }
            // �ݑ�d�x���Z
            obj = VRBindPathParser.get("1210119", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // ���Ə��o�^���Ƀ`�F�b�N�Ȃ��̏ꍇ
                    VRBindPathParser.set("1210118", defaultMap, new Integer(1));
                    break;
                case 2:
                    // ���Ə��o�^���Ƀ`�F�b�N����̏ꍇ
                    VRBindPathParser.set("1210118", defaultMap, new Integer(2));
                    break;
                }
            }
            // ���j�b�g�P�A�̐�
            obj = VRBindPathParser.get("1210116", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                // �̐��Ȃ��̏ꍇ
                case 1:
                    setState_INVALID_UNIT_CARE();
                    VRBindPathParser.set("1210115", defaultMap, obj);
                    setUnitCareFlag(false);
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    setState_VALID_UNIT_CARE();
                    VRBindPathParser.set("1210115", defaultMap, obj);
                    setUnitCareFlag(true);
                    break;
                }
            } else {
                //���Ə��o�^�œo�^����Ă��Ȃ������ꍇ�͈ꗥ�����ɂ���B
                setUnitCareFlag(false);
            }
            //���}�̐�
            obj = VRBindPathParser.get("1210104", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    //�̐��Ȃ��̏ꍇ
                    VRBindPathParser.set("6", defaultMap, new Integer(1));
                    break;
                case 2:
                    //�̐�����̏ꍇ
                    VRBindPathParser.set("6", defaultMap, new Integer(3));
                    break;
                }
            }
//            //�Ō�̐����Z
//            obj = VRBindPathParser.get("1210120", provider);
//            if (obj != null) {
//                //�Ō�̐���(I)��(II)������A���Ə��̂���E�Ȃ��̓]�L�ɂ͂�����Ȃ�
//
//            }
            //��ΐE���z�u���Z
            obj = VRBindPathParser.get("1210121", provider);
            if (obj != null) {
                VRBindPathParser.set("1210121", defaultMap, obj);
            }
            //��N���F�m�Ǘ��p�Ҏ�����Z
            obj = VRBindPathParser.get("1210122", provider);
            if (obj != null) {
                VRBindPathParser.set("1210122", defaultMap, obj);
            }
            //�T�[�r�X�񋟑̐��������Z
            obj = VRBindPathParser.get("1210124", provider);
            if (obj != null) {
                VRBindPathParser.set("1210123", defaultMap, obj);
            }
            
            // [ID:0000471][Masahiko Higuchi] 2009/04 add begin �󏰌^�Ή�
            // �T�[�r�X�񋟑̐��������Z�i�P�ƌ^�j��D�悷�邽�ߒl���Ȃ��̏ꍇ�̂ݓK�p
            if(ACCastUtilities.toInt(obj , 0) == 1) {
                // 1210125 �T�[�r�X�񋟑̐��������Z(�󏰌^)
                obj = VRBindPathParser.get("1210125", provider);
                if (obj != null) {
                    VRBindPathParser.set("1210123", defaultMap, obj);
                }
            }
            // [ID:0000471][Masahiko Higuchi] 2009/04 add end
            

            //��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1210122�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1210122", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //�l�����̂����ꂩ�������ꍇ
            case 2:
                //2�i����j
                //�L���ɂ���B
                setState_VALID_YOUNG_DEMENTIA_PATINET();
                break;
            default:
                //�l����L�ȊO�������ꍇ
                //�����ɂ���B
                setState_INVALID_YOUNG_DEMENTIA_PATINET();
                break;
            }
            //���defaultMap�� KEY�F1210122 VALUE�F1�i�Ȃ��j��ݒ肷��B
            VRBindPathParser.set("1210122", defaultMap, new Integer(1));   


            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            
            if(getShortStayLifeDinnerOffer().getSelectedIndex()==0){
                //�H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getShortStayLifeDinnerOffer().setSelectedIndex(1);
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
        if (getShortStayLifeDinnerOffer()
                .getSelectedIndex() > 0) {
            // �H���񋟁igetShortStayLifeDinnerOffer)���u�Ȃ��v�ȊO��I�����Ă���ꍇ
            if (ACTextUtilities
                    .isNullText(getShortStayLifeDinnerCost()
                            .getText())) {
                // �H����p(getShortStayLifeDinnerCost)���󗓂̏ꍇ
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
                        .get("1210108", getSelectedProvider()), 0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1210109", getSelectedProvider()), 0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1210110", getSelectedProvider()), 0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1210111", getSelectedProvider()), 0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1210109", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1210110",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1210110", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1210111",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1210111", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1210109",
                                getSelectedProvider()), 0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
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

    /**
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     *
     * @throws Exception ������O
     *
     */
    public void checkState() throws Exception {
        // ����ʏ�Ԑ��䏈��
        // ���F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�Ǝ�N���F�m�Ǘ��p�Ҏ�����Z�̔r������
        if (getDementiaActionAddRadioGroup().getSelectedIndex() == 2) {
            // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z(dementiaActionAddRadioGroup)���u����v�̏ꍇ
            // ��N���F�m�Ǘ��p�Ҏ�����Z(youngDementiaPatinetAddRadioGroup)�𖳌��ɂ���B
            setState_INVALID_YOUNG_DEMENTIA_PATINET();
        } else {
            // ��L�ȊO�̏ꍇ
            // ��N���F�m�Ǘ��p�Ҏ�����Z(youngDementiaPatinetAddRadioGroup)��L���ɂ���B
            setState_VALID_YOUNG_DEMENTIA_PATINET();
        }
        if (getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() == 2) {
            // ��N���F�m�Ǘ��p�Ҏ�����Z(youngDementiaPatinetAddRadioGroup)���u����v�̏ꍇ
            // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z(dementiaActionAddRadioGroup)�𖳌��ɂ���B
            setState_INVALID_DEMENTIA_ACTION();
        } else {
            // ��L�ȊO�̏ꍇ
            // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z(dementiaActionAddRadioGroup)��L���ɂ���B
            setState_VALID_DEMENTIA_ACTION();
        }
        
        
        //��L�����ŗL���ɂȂ����R���g���[���ł��A���Ə��̐��Ő�����󂯂���̂͏㏑���Ő��䂷��B
        VRBindSource provider = getSelectedProvider();
        if(provider!=null){
            Object obj;

            //��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1210122�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1210122", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //�l�����̂����ꂩ�������ꍇ
            case 2:
                //2�i����j
                //�Ȃɂ����Ȃ��B
                break;
            default:
                //�l����L�ȊO�������ꍇ
                //�����ɂ���B
                setState_INVALID_YOUNG_DEMENTIA_PATINET();
                break;
            }

        }
        
    }

    /**
     * �u�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�I���v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void dementiaActionAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception {
        //���F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�Ǝ�N���F�m�Ǘ��p�Ҏ�����Z�̔r������  
        //��ʂ̏�Ԃ�ύX����B
        checkState();
    }

    /**
     * �u��N���F�m�Ǘ��p�Ҏ�����Z�I���v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void youngDementiaPatinetAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception {
        //���F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�Ǝ�N���F�m�Ǘ��p�Ҏ�����Z�̔r������  
        //��ʂ̏�Ԃ�ύX����B
        checkState();
    }
}
