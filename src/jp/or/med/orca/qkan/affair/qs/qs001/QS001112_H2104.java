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
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i�f�Ï��×{�j (QS001112_H2104)
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
 * �T�[�r�X�p�^�[���Z�������×{���i�f�Ï��×{�j(QS001112_H2104)
 */
public class QS001112_H2104 extends QS001112_H2104Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001112_H2104() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayClinicRecuperationInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        //��ʂ̏�Ԃ�ύX����B
        checkState();
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
    
    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001112.class.getName(), param));
    }

    // �����֐�

    /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // ����ʓW�J���̏����ݒ�
        getShortStayClinicRecuperationSpecificConsultationFee().clearDataModel();
        //QS001199_H2104(����f�Ô�)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A����f�Ô�{�^���ɐݒ肷��B
        getShortStayClinicRecuperationSpecificConsultationFee()
                .setBindPathes(QS001199_H2104.getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
        // ���H����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1230249 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1230249", QkanCommon.getArrayFromMasterCode(191,
                "1230249"));
        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F273�i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1230255 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1230255", QkanCommon.getArrayFromMasterCode(273,
                "1230255"));
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
        VRBindPathParser.set("1230249",defaultMap,new Integer(1));
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
            obj = VRBindPathParser.get("1230201", provider);
            if (obj != null) {
                defaultMap.setData("1230201", obj);
            }
            // �l���z�u
            obj = VRBindPathParser.get("1230202", provider);
            if (obj != null) {
                defaultMap.setData("1230202", obj);
            }
            // �×{���
            obj = VRBindPathParser.get("1230123", provider);
            if (obj != null) {
                defaultMap.setData("1230254", obj);
            }
            // �ݔ������Z
            obj = VRBindPathParser.get("1230218", provider);
            if (obj != null) {
                defaultMap.setData("1230252", obj);
            }
            // �l�����Z
            obj = VRBindPathParser.get("1230207", provider);
            if (obj != null) {
                defaultMap.setData("1230209", obj);
            }
            // ���}
            obj = VRBindPathParser.get("1230204", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // ���}�敪(shortStayClinicRecuperationMeetingAndSendingOff)��3�Ԗڂ̃{�^����I���ɂ���B
                    defaultMap.setData("6", new Integer(3));
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // ���}�敪(shortStayClinicRecuperationMeetingAndSendingOff)��1�Ԗڂ̃{�^����I���ɂ���B
                    defaultMap.setData("6", new Integer(1));
                    break;
                }
            }
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

            // �×{�H
            obj = VRBindPathParser.get("1230220", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            case 2:
                // �u����v�̏ꍇ
                // �L���ɂ���B
                setState_VALID_MEDICAL_EXPENSES();
                // [ID:0000481][Tozo TANAKA] 2009/04/08 delete begin ����21�N4���@�����Ή�(�×{�H)
//                defaultMap.setData("1230208",new Integer(2));
                // [ID:0000481][Tozo TANAKA] 2009/04/08 delete end
                break;
            default:
                // �u�Ȃ��v�̏ꍇ
                // �����ɂ���B
                setState_INVALID_MEDICAL_EXPENSES();
                // [ID:0000481][Tozo TANAKA] 2009/04/08 delete begin ����21�N4���@�����Ή�(�×{�H)
//                defaultMap.setData("1230208",new Integer(1));
                // [ID:0000481][Tozo TANAKA] 2009/04/08 delete end
                break;
            }
            // [ID:0000481][Tozo TANAKA] 2009/04/08 add begin ����21�N4���@�����Ή�(�×{�H)
            //���defaultMap�� KEY�F1230208 VALUE�F1�i�Ȃ��j��ݒ肷��B
            VRBindPathParser.set("1230208", defaultMap, new Integer(1));   
            // [ID:0000481][Tozo TANAKA] 2009/04/08 add end
            
            // ���j�b�g�P�A�̐���
            obj = VRBindPathParser.get("1230216", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    defaultMap.setData("1230210", new Integer(2));
                    setState_VALID_UNIT_CARE();
                    setUnitCareFlag(true);
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    defaultMap.setData("1230210", new Integer(1));
                    setState_INVALID_UNIT_CARE();
                    setUnitCareFlag(false);
                    break;
                }
            }else{
                //���Ə��o�^�œo�^����Ă��Ȃ������ꍇ�͈ꗥ�����ɂ���B
                setUnitCareFlag(false);
            }
            
            // �ً}�Z�������l�b�g���[�N���Z
            obj = VRBindPathParser.get("1230217", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_NETWORK_ADD();
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    defaultMap.setData("1230211", new Integer(1));
                    setState_INVALID_NETWORK_ADD();
                    break;
                }
            }

            //��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1230219�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1230219", provider);
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
            //���defaultMap�� KEY�F1230257 VALUE�F1�i�Ȃ��j��ݒ肷��B
            VRBindPathParser.set("1230257", defaultMap, new Integer(1));   

            
            //�T�[�r�X�񋟑̐��������Z�i���Ə��p�l���jKEY�F1230221�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1230221", provider);
            switch (ACCastUtilities.toInt(obj,0)) {
            //�l�����̂����ꂩ�������ꍇ
            case 2:
                //2�iI�^�j
            case 3:
                //3�iII�^�j
            case 4:
                //4�iIII�^�j
                //defaultMap�� KEY�F1230253 VALUE�F���Ə��̒l��ݒ肷��B
                VRBindPathParser.set("1230253", defaultMap, obj);   
                break;
            default:
                //�l����L�ȊO�������ꍇ
                //defaultMap�� KEY�F1230253 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1230253", defaultMap, new Integer(1));   
                break;
            }
            
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

        
            if(getShortStayClinicRecuperationDinnerOffer().getSelectedIndex()==0){
                //�H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getShortStayClinicRecuperationDinnerOffer().setSelectedIndex(1);
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
        if (getShortStayClinicRecuperationDinnerOffer().getSelectedIndex() > 0) {
            // �H���񋟁ishortStayClinicRecuperationDinnerOffer)���u�Ȃ��v�ȊO��I�����Ă���ꍇ
            if (ACTextUtilities
                    .isNullText(getShortStayClinicRecuperationDinnerCost()
                            .getText())) {
                // �H����p(shortStayClinicRecuperationDinnerCost)���󗓂̏ꍇ
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
        // �ݔ�����Z�����炩�̗��R�Őݒ肳��Ă��Ȃ��ꍇ
        if(getShortStayClinicRecuperationProvisionBase().getSelectedIndex() < 1) {
            // ���e�ڍׂ̕s����ʒm
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // �G���[�Ƃ��ď���
            return null;
        }
        // �×{������Z���ݒ肳��Ă��Ȃ��ꍇ
        if(getShortStayClinicRecuperationSubtractionType().getSelectedIndex() < 1){
            // ���e�ڍׂ̕s����ʒm
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }
        if (getTankinyusyoTimeDivision().isEnabled()) {
            // ���ԋ敪�itankinyusyoTimeDivision)���L���ȏꍇ(�V���[�g�X�e�C)
            if (getTankinyusyoTimeDivision().getSelectedIndex() < 0) {
                // ���ԋ敪�itankinyusyoTimeDivision)�����I���̏ꍇ
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
                        .get("1230208", getSelectedProvider()), 0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230209", getSelectedProvider()), 0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230210", getSelectedProvider()), 0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230211", getSelectedProvider()), 0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230209", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230210",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230210", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230211",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230211", getSelectedProvider()),0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230209",
                                getSelectedProvider()), 0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
    }

    /**
     * �u�H���񋟑I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayClinicRecuperationDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getShortStayClinicRecuperationDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            setState_NOT_USE_MEAT();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            setState_USE_MEAT();
            // �H����p(shortStayClinicRecuperationDinnerCost)��ݒ肷��B
            getShortStayClinicRecuperationDinnerCost().setText(
                    getMeatCost(getShortStayClinicRecuperationDinnerOffer()
                            .getSelectedIndex()));
        }

    }

    public void binded() throws Exception{
        if (getShortStayClinicRecuperationSpecificConsultationFee()
                .getDataModel().isEmpty()) {
            // ����f�Ô�{�^���̃f�[�^����̏ꍇ
            // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
            getShortStayClinicRecuperationSpecificConsultationFeeOutline()
                    .setText("�ݒ�Ȃ�");
        } else {
            // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
            // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
            getShortStayClinicRecuperationSpecificConsultationFeeOutline()
                    .setText("�ݒ肠��");
        }
    }
    /**
     * �u����f�Ô�ҏW�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayClinicRecuperationSpecificConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {
        // ������f�Ô�̕ҏW
        // ����f�Ô�ҏW���(QS001199_H2104)�𐶐�����B
        // ����f�Ô�{�^���̃f�[�^�������ɐ�����������f�Ô�ҏW���(QS001028)��shoModal�����s����B
        if (new QS001199_H2104().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getShortStayClinicRecuperationSpecificConsultationFee()
                        .getDataModel())) {
            // ����f�Ô��ύX�����ꍇ
            if (getShortStayClinicRecuperationSpecificConsultationFee()
                    .getDataModel().isEmpty()) {
                // ����f�Ô�{�^���̃f�[�^����̏ꍇ
                // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
                getShortStayClinicRecuperationSpecificConsultationFeeOutline()
                        .setText("�ݒ�Ȃ�");
            } else {
                // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
                // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
                getShortStayClinicRecuperationSpecificConsultationFeeOutline()
                        .setText("�ݒ肠��");
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

        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getShortStayClinicRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // �u�f�Ï��v��I�������ꍇ
            // �u�a���敪(�ʏ�)�v��L���ɂ��A�u�a���敪(���j�b�g�^)�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            //���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
            setState_SHORT_STAY_UNSELECT();
            break;
        case 2:
            // �u���j�b�g�^�f�Ï��v��I�������ꍇ
            // �u�a���敪(�ʏ�)�v�𖳌��ɂ��A�u�a���敪(���j�b�g�^)�v��L���ɂ���B
            //���j�b�g�P�A�̐�������ꍇ�͕ύX����B
            setState_UNIT_FORM();
            if(!getUnitCareFlag()){
                setState_INVALID_UNIT_CARE();
            }
            //���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
            setState_SHORT_STAY_UNSELECT();
            break;
        case 3:
            // �u���A��V���[�g�X�e�C�v�̏ꍇ
            // �u�a���敪�v�𖳌��ɂ��A�u�l���z�u�敪�v�𖳌��ɂ���B
            setState_SELECT_SHORT_STAY_STATE();
            //���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
            setState_SHORT_STAY_SELECT();
            //�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z(dementiaActionAddRadioGroup)���u�Ȃ��v�ɂ���B
            getDementiaActionAddRadioGroup().setSelectedIndex(1);
            break;
        }


        //��L�����ŗL���ɂȂ����R���g���[���ł��A���Ə��̐��Ő�����󂯂���̂͏㏑���Ő��䂷��B
        VRBindSource provider = getSelectedProvider();
        if(provider!=null){
            Object obj;
            
            //��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1230219�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1230219", provider);
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

}
