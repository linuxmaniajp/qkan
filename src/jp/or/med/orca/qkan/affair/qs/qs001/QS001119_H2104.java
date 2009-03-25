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
 * �v���O���� �T�[�r�X�p�^�[�����V�l�ی��{�� (QS001119_H2104)
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
 * �T�[�r�X�p�^�[�����V�l�ی��{��(QS001119_H2104)
 */
public class QS001119_H2104 extends QS001119_H2104Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001119_H2104() {
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
        changeState();

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

    /**
     * �u���ʗ×{��ݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void specialMedicalExpenseActionPerformed(ActionEvent e)
            throws Exception {
        // �����ʗ×{��̕ҏW
        // ���ʗ×{��ҏW���(QS001200)�𐶐�����B
        // ���ʗ×{��{�^���̃f�[�^�������ɐ����������ʗ×{��ҏW���(QS001200)��shoModal�����s����B
        if (new QS001200().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getSpecialMedicalExpense().getDataModel())) {
            // ���ʗ×{���ύX�����ꍇ
            if (getSpecialMedicalExpense().getDataModel().isEmpty()) {
                // ���ʗ×{��{�^���̃f�[�^����̏ꍇ
                // ���ʗ×{��x���Ɂu�ݒ�Ȃ��v�ƕ\������B
                getSpecialMedicalExpenseLabel().setText("�ݒ�Ȃ�");
            } else {
                // ���ʗ×{��{�^���̃f�[�^����ł͂Ȃ��ꍇ
                // ���ʗ×{��x���Ɂu�ݒ肠��v�ƕ\������B
                getSpecialMedicalExpenseLabel().setText("�ݒ肠��");
            }
        }

    }

    /**
     * �u�o���ڍs���Z�̕ύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void kaigoHealthCareOfTheAgedOralSwitchRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // �o���ڍs���Z�̏�Ԃ���Ɍo���ێ����Z�̗L����Ԃ�ύX
        if (getKaigoHealthCareOfTheAgedOralSwitchRadioItem1().isSelected()) {
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
    protected void oralMaintenanceAddRadioSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // �o���ێ����Z�̏�Ԃ���Ɍo���ێ����Z�̗L����Ԃ�ύX
        // �o���ێ����Z
        if (getOralMaintenanceAddRadioItem1().isSelected()) {
            setState_VALID_NUTRITION();
        } else {
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
        ACFrame.debugStart(new ACAffairInfo(QS001119_H2104.class.getName(),
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
        getSpecialMedicalExpense().clearDataModel();
        // QS001200(���ʗ×{��)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A���ʗ×{��{�^���ɐݒ肷��B
        getSpecialMedicalExpense().setBindPathes(
                QS001200.getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
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
            int index;
//            // �{�݋敪
//            obj = VRBindPathParser.get("1520101", provider);
//            if (obj != null) {
//                VRBindPathParser.set("1520101", defaultMap, obj);
//            }
            //�{�݋敪�i���Ə��p�l���jKEY�F1520101�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1520101", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //�l�����̂����ꂩ�������ꍇ
            case 3:
                //3�i���j�b�g�^���ی��{�݁j
            case 4:
                //4�i���j�b�g�^���K�͉��ی��{�݁j
                //defaultMap�� KEY�F1520101 VALUE�F3�i���j�b�g�^���ی��{�݁j��ݒ肷��B
                VRBindPathParser.set("1520101", defaultMap, new Integer(3));   
                break;
            default:
                //�l����L�ȊO�������ꍇ
                //defaultMap�� KEY�F1520101 VALUE�F1�i���ی��{�݁j��ݒ肷��B
                VRBindPathParser.set("1520101", defaultMap, new Integer(1));   
                break;
            }

            // �{�݋敪�i�̐��j
            index = ACCastUtilities.toInt(VRBindPathParser.get("1520122",
                    provider), 0);
            // �ݒ�
            VRBindPathParser.set("1520132", defaultMap, new Integer(index));

            //��ԋΖ�������i���Ə��p�l���jKEY�F1510102�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1510102", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            case 2:
                //�l��2�i���Z�^�j�������ꍇ
                //defaultMap�� KEY�F1520104 VALUE�F2�i���Z�^�j��ݒ肷��B
                VRBindPathParser.set("1520104", defaultMap, new Integer(2));   
                break;
            default:
                //�l��2�i����j�ȊO�������ꍇ
                //defaultMap�� KEY�F1520104 VALUE�F1�i��^�j��ݒ肷��B
                VRBindPathParser.set("1520104", defaultMap, new Integer(1));   
                break;
            }            

            // �l�����Z
            obj = VRBindPathParser.get("1520131", provider);
            if (obj != null) {

                // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch (ACCastUtilities.toInt(obj)) {
                case 1: // �Ȃ��������ꍇ
                    VRBindPathParser.set("1520119", defaultMap, new Integer(1));
                    break;
                case 2: // ��t�������ꍇ
                case 3: // �Ō�E���������ꍇ
                case 4: // ���E���������ꍇ
                case 5: // ���w�Ö@�m�������ꍇ
                case 6: // ��ƗÖ@�m�������ꍇ
                case 7: // ���x�������������ꍇ
                case 8: // ���꒮�o�m�������ꍇ
                    VRBindPathParser.set("1520119", defaultMap, new Integer(3));
                    break;
                }
            }
            // ���W�J

            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
//            // �h�{�Ǘ�
//            obj = VRBindPathParser.get("1520105", provider);
//            if (obj != null) {
//                if (new Integer(2).equals(ACCastUtilities.toInteger(obj))) {
//                    VRBindPathParser.set("1520110", defaultMap, new Integer(3));
//                } else if (new Integer(3)
//                        .equals(ACCastUtilities.toInteger(obj))) {
//                    VRBindPathParser.set("1520110", defaultMap, new Integer(2));
//                }
//            }
            // �h�{�}�l�W�����g
            obj = VRBindPathParser.get("1520130", provider);
            if (obj != null) {
                VRBindPathParser.set("1520111", defaultMap, obj);
            }
            switch (ACCastUtilities.toInt(obj,0)){
            case 2:
                // �u����v�̏ꍇ
                // �L���ɂ���B
                setState_VALID_MANAGE();
                break;
            default:
                // �u�Ȃ��v�̏ꍇ
                // �����ɂ���B
                setState_INVALID_MANAGE();
                break;
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

            // �×{�̐��ێ����ʉ��Z
            index = ACCastUtilities.toInt(VRBindPathParser.get("1520124",
                    provider), 0);
            // �ݒ�
            VRBindPathParser.set("1520134", defaultMap, new Integer(index));


            //�×{�H���Z�i���Ə��p�l���jKEY�F1520125�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1520125", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            case 2:
                //�l��2�i����j�������ꍇ
                // �L���ɂ���B
                setState_VALID_MEDICAL_EXPENSES();
                //defaultMap�� KEY�F1520113 VALUE�F2�i����j��ݒ肷��B
                VRBindPathParser.set("1520113", defaultMap, new Integer(2));   
                break;
            default:
                //�l��2�i����j�ȊO�������ꍇ
                // �����ɂ���B
                setState_INVALID_MEDICAL_EXPENSES();
                //defaultMap�� KEY�F1520113 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1520113", defaultMap, new Integer(1));   
                break;
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
            } else {
                // ���Ə��o�^�œo�^����Ă��Ȃ������ꍇ�͈ꗥ�����ɂ���B
                setUnitCareFlag(false);
            }

            // �g�̍S�������{���Z
            obj = VRBindPathParser.get("1520120", provider);
            if (obj != null) {
                // �g�̍S�������{��g�ݖ����������ꍇ
                if (ACCastUtilities.toInt(obj) == 1) {
                    defaultMap.setData("1520130", new Integer(2));
                } else if (ACCastUtilities.toInt(obj) == 2) {
                    // �g�̍S�������{��g�ݗL�肾�����ꍇ
                    defaultMap.setData("1520130", new Integer(1));
                }
            }
            // ��ΐE���z�u���Z
            index = ACCastUtilities.toInt(VRBindPathParser.get("1520126",
                    provider), 1);
            VRBindPathParser.set("1520136", defaultMap, new Integer(index));

            // ���Ə��̎�N���F�m�Ǔ����Ҏ�����Z�F1520127���`�F�b�N����B
            index = ACCastUtilities.toInt(VRBindPathParser.get("1520127",
                    provider), 1);
            switch(index) {
            case 1:
                setState_INVALID_YOUNG_DEMENTIA_PATINET();
                break;
            case 2:
                setState_VALID_YOUNG_DEMENTIA_PATINET();
                break;
            }
            //���defaultMap�� KEY�F1520138 VALUE�F1�i�Ȃ��j��ݒ肷��B
            VRBindPathParser.set("1520138", defaultMap, new Integer(1));

            // ���Ə��̉h�{�}�l�W�����g���Z�F1520130���h�{�}�l�W�����g���Z�F1520111�ɐݒ肷��B
            index = ACCastUtilities.toInt(VRBindPathParser.get("1520130",
                    provider), 1);
            VRBindPathParser.set("1520111", defaultMap, new Integer(index));

            //�F�m�ǐ��P�A���Z�i���Ə��p�l���jKEY�F1520128�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1520128", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //�l�����̂����ꂩ�������ꍇ
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
            //���defaultMap�� KEY�F1520137 VALUE�F1�i�Ȃ��j��ݒ肷��B
            VRBindPathParser.set("1520137", defaultMap, new Integer(1));   
            
            
            //�F�m�ǃP�A���Z�i���Ə��p�l���jKEY�F1520121�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1520121", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //�l�����̂����ꂩ�������ꍇ
            case 2:
                //2�i����j
                //�L���ɂ���B
                setState_VALID_DEMENTIA_CARE();
                break;
            default:
                //�l����L�ȊO�������ꍇ
                //�����ɂ���B
                setState_INVALID_DEMENTIA_CARE();
                break;
            }
            //���defaultMap�� KEY�F1520128 VALUE�F1�i�Ȃ��j��ݒ肷��B
            VRBindPathParser.set("1520128", defaultMap, new Integer(1));   
            
            
            // �T�[�r�X�񋟑̐��������Z�F1520129���T�[�r�X�񋟑̐��������Z�F1520142�ɐݒ肷��B
            index = ACCastUtilities.toInt(VRBindPathParser.get("1520129",
                    provider), 1);
            VRBindPathParser.set("1520142", defaultMap, new Integer(index));

            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

            if (getKaigoHealthCareOfTheAgedDinnerOffer().getSelectedIndex() == 0) {
                // �H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
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
        // �{�ݓ��̋敪�����I����ԂłȂ����`�F�b�N����B
        if (getKaigoHealthCareOfTheAgedDivisionRadio().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // �{�݋敪�i�̐��j�����I����ԂłȂ������`�F�b�N����B
        if (getKaigoHealthCareOfTheAgedDivision().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // �×{���ێ����ʑ̐������I���ł��Ȃ����`�F�b�N����B
        if (getRecuperationRadio().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // ��ΐE���z�u���Z���W�I�������͂ł��邩�`�F�b�N����B
        if (getNightStaffDispositionAddRadioGroup().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // ��N���F�m�Ǔ����Ҏ�����Z���W�I�������͂ł��邩�`�F�b�N����B
        if (getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // �h�{�}�l�W�����g���Z���W�I�������͂ł��邩�`�F�b�N����B
        if (getKaigoHealthCareOfTheAgedNutritionRadio().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // �F�m�ǐ��P�A���Z���W�I�������͂ł��邩�`�F�b�N����B
        if (getDementiaProfessionalCareAddRadioGroup().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // �T�[�r�X�񋟑̐��������Z���W�I�������͂ł��邩�`�F�b�N����B
        if (getServiceAddProvisionStructuralRadioGroup().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }

        // ���ʗ×{��g�p�s�\�ȏꍇ�͒l���N���A����B
        if(!getSpecialMedicalExpense().isEnabled()) {
            getSpecialMedicalExpense().clearDataModel();
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
     * @throws Exception ������O
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
                        .get("1520111", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520112",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520112", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520113",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1520113", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1520111",
                                getSelectedProvider()), 0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
    }

    /**
     * �u�f�[�^�o�C���h��̏����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public void binded() throws Exception {
        // ���f�[�^�o�C���h��̏���
        if (getSpecialMedicalExpense().getDataModel().isEmpty()) {
            // ���ʗ×{��{�^���̃f�[�^����̏ꍇ
            // ���ʗ×{��x���Ɂu�ݒ�Ȃ��v�ƕ\������B
            getSpecialMedicalExpenseLabel().setText("�ݒ�Ȃ�");
        } else {
            // ���ʗ×{��{�^���̃f�[�^����ł͂Ȃ��ꍇ
            // ���ʗ×{��x���Ɂu�ݒ肠��v�ƕ\������B
            getSpecialMedicalExpenseLabel().setText("�ݒ肠��");
        }

    }

    protected void kaigoHealthCareOfTheAgedDivisionSelectionChanged(ListSelectionEvent e) throws Exception {
        // ��ʏ�Ԑ���
        changeState();
        
    }

    public void changeState() throws Exception {
        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getKaigoHealthCareOfTheAgedDivisionRadio().getSelectedIndex()) {
        case 1:
        case 2:
            // �u���ی��{�݁v�̏ꍇ
            // �u�a���敪�i���V�l�ی��{�݁j�v��L���ɂ��A�u�a���敪�i���j�b�g�^���V�l�ی��{�݁j�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            setState_VALID_DEMENTIA_CARE();
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
            setState_INVALID_DEMENTIA_CARE();
            break;
        }
        
        // �̐��ɂ���Ԑ���i�×{�V���j
        switch(getKaigoHealthCareOfTheAgedDivision().getSelectedIndex()) {
        case 2:
        case 3:
            setState_SELECT_RYOYO_STATE();
            break;
        default:
            setState_UNSELECT_RYOYO_STATE();
        }
        
        //��L�����ŗL���ɂȂ����R���g���[���ł��A���Ə��̐��Ő�����󂯂���̂͏㏑���Ő��䂷��B
        VRBindSource provider = getSelectedProvider();
        if(provider!=null){
            Object obj;
            
            //�F�m�ǃP�A���Z�i���Ə��p�l���jKEY�F1520121�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1520121", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //�l�����̂����ꂩ�������ꍇ
            case 2:
                //2�i����j
                //�������Ȃ��B
                break;
            default:
                //�l����L�ȊO�������ꍇ
                //�����ɂ���B
                setState_INVALID_DEMENTIA_CARE();
                break;
            }

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
