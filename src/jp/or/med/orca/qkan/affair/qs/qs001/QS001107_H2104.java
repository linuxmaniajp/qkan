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
 * �v���O���� �T�[�r�X�p�^�[���ʏ���� (QS001107_H2104)
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
 * �T�[�r�X�p�^�[���ʏ����(QS001107_H2104)
 */
public class QS001107_H2104 extends QS001107_H2104Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001107_H2104() {
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
        // �{�݋敪�I�����̏���
        // �{�݋敪�I����
        VRMap comboItemMap;
        switch (getTsuusyoKaigoTimeContenaFacilityDivision().getSelectedIndex()) {
        case 1:
            // ���K��
            setState_STATE_SMALL();
            comboItemMap = new VRHashMap();
            // �R�[�h�}�X�^�f�[�^���CODE_ID�F40�i���ԋ敪�j���擾����B
            // �擾�����l���AcomboItemMap�� KEY : 1150104 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1150104", QkanCommon.getArrayFromMasterCode(
                    40, "1150104"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();
            break;
        case 2:
        case 3:
        case 4:
            // �ʏ�K�͑I����
            setState_STATE_NORMAL();
            comboItemMap = new VRHashMap();
            // �R�[�h�}�X�^�f�[�^���CODE_ID�F40�i���ԋ敪�j���擾����B
            // �擾�����l���AcomboItemMap�� KEY : 1150104 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1150104", QkanCommon.getArrayFromMasterCode(
                    40, "1150104"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();
            break;
        case 5:
            // �×{�ʏ��I����
            setState_STATE_RYOYO();
            comboItemMap = new VRHashMap();
            // �R�[�h�}�X�^�f�[�^���CODE_ID�F40�i���ԋ敪�j���擾����B
            // �擾�����l���AcomboItemMap�� KEY : 1150104 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1150104", QkanCommon.getArrayFromMasterCode(
                    238, "1150104"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();
            break;
        }
        
        //��L�����ŗL���ɂȂ����R���g���[���ł��A���Ə��̐��Ő�����󂯂���̂͏㏑���Ő��䂷��B
        VRBindSource provider = getSelectedProvider();
        if(provider!=null){
            Object obj;
            // �h�{���P�̐�
            obj = VRBindPathParser.get("1150113", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��������ꍇ
                    //�����ɂ���B
                    setState_INVALID_NOURISHMENT_MANAGEMENT();
                    break;
                }
            }
            //�ʋ@�\�P���̐��i���Ə��p�l���jKEY�F1150116�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1150116", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //�l�����̂����ꂩ�������ꍇ
            case 2:
                //2�i���Z�^I�j
            case 3:
                //3�i���Z�^II�j
                //�Ȃɂ����Ȃ��B
                break;
            default:
                //�l����L�ȊO�������ꍇ
                //�����ɂ���B
                setState_INVALID_FUNCTION_TRAINING();
                break;
            }
            
            //���o�@�\����̐��i���Ə��p�l���jKEY�F1150109�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1150109", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //�l�����̂����ꂩ�������ꍇ
            case 2:
                //2�i����j
                //�Ȃɂ����Ȃ��B
                break;
            default:
                //�l����L�ȊO�������ꍇ
                //�����ɂ���B
                setState_INVALID_MOUTH_FUNCTION();
                break;
            }
            
            //��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1150112�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1150112", provider);
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

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001107_H2104.class.getName(),
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
        comboItemMap.setData("1150104", QkanCommon.getArrayFromMasterCode(40,
                "1150104"));
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
            VRMap defaultMap = new VRHashMap();
            // ���ݒ�
            Object obj;
            Object oldObj;
            // �{�݋敪
            obj = VRBindPathParser.get("1150115", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                case 2:
                    VRBindPathParser.set("1150113", defaultMap, obj);
                    break;
                case 3:
                    VRBindPathParser.set("1150113", defaultMap, new Integer(5));
                    break;
                case 4:
                    VRBindPathParser.set("1150113", defaultMap, new Integer(3));
                    break;
                case 5:
                    VRBindPathParser.set("1150113", defaultMap, new Integer(4));
                    break;
                }

            }
            
//            // �o�[�W�����A�b�v�O���Ə��Ƃ̊֘A�`�F�b�N
//            //��K�͎��Ə��`�F�b�N
//            obj = VRBindPathParser.get("1150107",provider);
//            if (obj != null) {
//                oldObj = VRBindPathParser.get("1150101", provider);
//                // �����Ə����
//                switch (ACCastUtilities.toInt(obj)) {
//                case 1: // ���K��
//                    VRBindPathParser.set("1150113", defaultMap, new Integer(1));
//                    break;
//                case 2: // �ʏ�K��
//                    if(ACCastUtilities.toInt(obj,0) == 2) {
//                        VRBindPathParser.set("1150113", defaultMap, new Integer(2));
//                    } else {
//                        // ��K�̓`�F�b�N�L�Ȃ̂�
//                        VRBindPathParser.set("1150113", defaultMap, new Integer(4));
//                    }
//                    
//                    break;
//                case 3: // �×{
//                    VRBindPathParser.set("1150113", defaultMap, new Integer(5));
//                    break;
//                }
//            }
            
            // �����
            obj = VRBindPathParser.get("1150103", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��������ꍇ
                    setState_INVALID_ADD_BATH();
                    break;
                case 2:
                    // �̐����肾�����ꍇ
                    setState_VALID_ADD_BATH();
                    VRBindPathParser.set("1150106", defaultMap, obj);
                    break;
                }
            }
            // �h�{���P�̐�
            obj = VRBindPathParser.get("1150113", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��������ꍇ
                    setState_INVALID_NOURISHMENT_MANAGEMENT();
                    break;
                case 2:
                    // �̐����肾�����ꍇ
                    setState_VALID_NOURISHMENT_MANAGEMENT();
                    VRBindPathParser.set("1150116", defaultMap, obj);
                    break;
                }
            }
            //���o�@�\������Z�i���Ə��p�l���jKEY�F1150109�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1150109", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //�l�����̂����ꂩ�������ꍇ
            case 2:
                //2�i����j
                //�L���ɂ���B
                setState_VALID_MOUTH_FUNCTION();
                //defaultMap�� KEY�F1150112 VALUE�F���Ə��̒l��ݒ肷��B
                VRBindPathParser.set("1150112", defaultMap, obj);   
                break;
            default:
                //�l����L�ȊO�������ꍇ
                //�����ɂ���B
                setState_INVALID_MOUTH_FUNCTION();
                //defaultMap�� KEY�F1150112 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1150112", defaultMap, new Integer(1));   
                break;
            }       
            
            // �l�����Z
            obj = VRBindPathParser.get("1150106", provider);
            if (obj != null) {
                //���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch(ACCastUtilities.toInt(obj)){
                case 1: //�Ȃ��������ꍇ
                    VRBindPathParser.set("1150108", defaultMap, new Integer(1));
                    break;
                case 2: //��t�������ꍇ
                case 3: //�Ō�E���������ꍇ
                    VRBindPathParser.set("1150108", defaultMap, new Integer(3));
                    break;
                }
            }
            
            // �T�[�r�X�񋟑̐��������Z
            obj = VRBindPathParser.get("1150114", provider);
            if (obj != null) {
                VRBindPathParser.set("1150117", defaultMap, obj);
            }
            
            //�ʋ@�\�P���̐��i���Ə��p�l���jKEY�F1150116�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1150116", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //�l�����̂����ꂩ�������ꍇ
            case 2:
                //2�i���Z�^I�j
            case 3:
                //3�i���Z�^II�j
                //�L���ɂ���B
                setState_VALID_FUNCTION_TRAINING();
                //defaultMap�� KEY�F1150114 VALUE�F���Ə��̒l��ݒ肷��B
                VRBindPathParser.set("1150114", defaultMap, obj);   
                break;
            default:
                //�l����L�ȊO�������ꍇ
                //�����ɂ���B
                setState_INVALID_FUNCTION_TRAINING();
                //defaultMap�� KEY�F1150114 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1150114", defaultMap, new Integer(1));   
                break;
            }

            //��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1150112�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1150112", provider);
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
            //���defaultMap�� KEY�F1150115 VALUE�F1�i�Ȃ��j��ݒ肷��B
            VRBindPathParser.set("1150115", defaultMap, new Integer(1));   

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
        }

    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
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
     * @throws Exception ������O
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ���J�n�������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return getTsuusyoKaigoTimeBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
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
                && (!ACTextUtilities
                        .isNullText(getTsuusyoKaigoTimeBeginTime()
                                .getText()))) {
            int kaigoTime = 0;
            // �J�n���ԃR���{(houmonKangoKaigoBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
            // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
            if(getTsuusyoKaigoTimeContenaFacilityDivisionItem3().isSelected()){
                kaigoTime = getRyouyoTuusyoKaigoTime();
            }else{
                kaigoTime = getKaigoTime();
            }
            // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
            getTsuusyoKaigoTimeEndTime().setDate(
                    ACDateUtilities.addMinute(
                            getTsuusyoKaigoTimeBeginTime()
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
            // �S���Ԉȏ�U���Ԗ����̏ꍇ
            // �߂�l�Ƃ���360��Ԃ��B
            return 360;
        case 3:
            // �U���Ԉȏ�W���Ԗ����̏ꍇ
            // �߂�l�Ƃ���480��Ԃ��B
            return 480;
        case 4:
            // �W���Ԉȏ�X���Ԗ����̏ꍇ
            // �߂�l�Ƃ���540��Ԃ��B
            return 540;
        case 5:
            // �X���Ԉȏ�P�O���Ԗ����̏ꍇ
            // �߂�l�Ƃ���600��Ԃ��B
            return 600;
        }
        return 0;
    }

    public int getRyouyoTuusyoKaigoTime() throws Exception {
        // �����ԋ敪(getTsuusyoKaigoTimeDivision)�̎��Ԃ��擾
        // ���ԋ敪(getTsuusyoKaigoTimeDivision)�̒l���`�F�b�N����B
        switch (getTsuusyoKaigoTimeDivision().getSelectedIndex()) {
        case 0:
            // �R���Ԉȏ�U���Ԗ����̏ꍇ
            // �߂�l�Ƃ���180��Ԃ��B
            return 360;
        case 1:
            // �U���Ԉȏ�W���Ԗ����̏ꍇ
            // �߂�l�Ƃ���480��Ԃ��B
            return 480;
        }
        return 0;
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
