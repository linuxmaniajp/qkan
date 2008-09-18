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
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj (QS001122)
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;

/**
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj(QS001122)
 */
public class QS001122 extends QS001122Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001122() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void medicalFacilityCognitiveHospitalInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // �u�F�m�ǎ����^�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v��L���ɂ��A�u�a���敪(���j�b�g�^)�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            if (getUseHumanCostDown()) {
                setState_USE_HUMAN_COST_DOWN();
            } else {
                setState_VALID_HUMAN_TYPE();
            }

            break;
        case 2:
            // �u���j�b�g�^�F�m�ǎ����^�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v�𖳌��ɂ��A�u�a���敪(���j�b�g�^)�v��L���ɂ���B
            setState_UNIT_FORM();
            if (!getInvalidUnitCareProvider()) {
                //�����j�b�g�P�A����
                setState_INVALID_UNIT_CARE();
            } else {
                //�����j�b�g�P�A�L��
                setState_VALID_UNIT_CARE();
            }
            setState_INVALID_HUMAN_TYPE();
            break;
        case 3:
        	// �u�o�ߌ^�v�̏ꍇ
        	setState_PASSAGE_FORM();
        }
        // �l���z�u�敪�𐧌䂷��
        changeState();

    }

    public void binded() throws Exception {
        if (getMedicalFacilityCognitiveHospitalConsultationFee().getDataModel()
                .isEmpty()) {
            // ����f�Ô�{�^���̃f�[�^����̏ꍇ
            // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
            getMedicalFacilityCognitiveHospitalConsultationFeeLabel().setText(
                    "�ݒ�Ȃ�");
        } else {
            // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
            // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
            getMedicalFacilityCognitiveHospitalConsultationFeeLabel().setText(
                    "�ݒ肠��");
        }
    }

    /**
     * �u����f�Ô�̐ݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void medicalFacilityCognitiveHospitalConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {
        // ������f�Ô�̕ҏW
        // ����f�Ô�ҏW���(QS001028)�𐶐�����B
        // ����f�Ô�{�^���̃f�[�^�������ɐ�����������f�Ô�ҏW���(QS001028)��shoModal�����s����B
        if (new QS001199().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getMedicalFacilityCognitiveHospitalConsultationFee()
                        .getDataModel())) {
            // ����f�Ô��ύX�����ꍇ
            if (getMedicalFacilityCognitiveHospitalConsultationFee()
                    .getDataModel().isEmpty()) {
                // ����f�Ô�{�^���̃f�[�^����̏ꍇ
                // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
                getMedicalFacilityCognitiveHospitalConsultationFeeLabel()
                        .setText("�ݒ�Ȃ�");
            } else {
                // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
                // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
                getMedicalFacilityCognitiveHospitalConsultationFeeLabel()
                        .setText("�ݒ肠��");
            }
        }

    }

    /**
     * �u�H���񋟑I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void medicalFacilityCognitiveHospitalDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getMedicalFacilityCognitiveHospitalDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            setState_NOT_USE_MEAT();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            setState_USE_MEAT();
            // �H����p(medicalFacilityCognitiveHospitalDinnerCost)��ݒ肷��B
            getMedicalFacilityCognitiveHospitalDinnerCost()
                    .setText(
                            getMeatCost(getMedicalFacilityCognitiveHospitalDinnerOffer()
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
        ACFrame.debugStart(new ACAffairInfo(QS001122.class.getName(), param));
    }

    // �����֐�

    /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // ����ʓW�J���̏����ݒ�
        getMedicalFacilityCognitiveHospitalConsultationFee().clearDataModel();
        // QS001028(����f�Ô�)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A����f�Ô�{�^���ɐݒ肷��B
        getMedicalFacilityCognitiveHospitalConsultationFee().setBindPathes(
                QS001199.getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
        // �H����
        comboItemMap.setData("1530356", QkanCommon.getArrayFromMasterCode(191,
                "1530356"));
        // �l�����Z
        comboItemMap.setData("1530355", QkanCommon.getArrayFromMasterCode(107,
                "1530355"));
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
        VRBindPathParser.set("1530356", defaultMap, new Integer(1));
        // �l�����Z
        VRBindPathParser.set("1530355", defaultMap, new Integer(1));
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
            // �{�݋敪
            VRBindPathParser.set("1530301", defaultMap, VRBindPathParser.get(
                    "1530301", provider));
            // �l���z�u�敪
            VRBindPathParser.set("1530302", defaultMap, VRBindPathParser.get(
                    "1530302", provider));
            // �a�@�敪
            VRBindPathParser.set("1530316", defaultMap, VRBindPathParser.get(
                    "1530318", provider));
            // ���j�b�g�P�A�̐���
            VRBindPathParser.set("1530313", defaultMap, VRBindPathParser.get(
                    "1530316", provider));
            Object obj;
            // �g�̍S�������{���Z
            obj = VRBindPathParser.get("1530317", provider);            
            if(obj != null){
                //�g�̍S�������{��g�݂Ȃ��������ꍇ
                if(ACCastUtilities.toInt(obj) == 1){
                    defaultMap.setData("1530314", new Integer(2));
                }else if(ACCastUtilities.toInt(obj) == 2){
                    //�g�̍S�������{��g�݂��肾�����ꍇ
                    defaultMap.setData("1530314", new Integer(1));
                }
                
            }

            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // �l�����Z
            obj = VRBindPathParser.get("1530307", provider);
            switch (ACCastUtilities.toInt(obj)) {
            case 1: // �Ȃ��������ꍇ
            case 2: // ��t�������ꍇ
                VRBindPathParser.set("1530355", defaultMap, new Integer(1));
                break;
            case 3: // �Ō�E���������ꍇ
            case 4: // ���E���������ꍇ
                VRBindPathParser.set("1530355", defaultMap, new Integer(3));
                break;
            case 5: // ���x�������������ꍇ
                VRBindPathParser.set("1530355", defaultMap, new Integer(4));
                break;
            }
            // �h�{�Ǘ��̐����Z
            obj = VRBindPathParser.get("1530303", provider);
            if (obj != null) {
                if(new Integer(2).equals(ACCastUtilities.toInteger(obj))){
                    VRBindPathParser.set("1530308",defaultMap,new Integer(3));
                }else if(new Integer(3).equals(ACCastUtilities.toInteger(obj))){
                    VRBindPathParser.set("1530308",defaultMap,new Integer(2));
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
            // �h�{�}�l�W�����g���Z
            obj = VRBindPathParser.get("1530304", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_MANAGE();
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_MANAGE();
                    break;
                }
                VRBindPathParser.set("1530309", defaultMap, obj);
            }
            // �o���ڍs���Z
            obj = VRBindPathParser.get("1530305", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_NUTRITION();
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_NUTRITION();
                    break;
                }
            }
            // �×{�H���Z
            obj = VRBindPathParser.get("1530306", provider);
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
            // ���j�b�g�P�A�̐���
            obj = VRBindPathParser.get("1530316", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    if (getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2()
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
                setInvalidUnitCareProvider(false);
            }
            
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            
            if(getMedicalFacilityCognitiveHospitalDinnerOffer().getSelectedIndex()==0){
                //�H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getMedicalFacilityCognitiveHospitalDinnerOffer().setSelectedIndex(1);
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
        if (getMedicalFacilityCognitiveHospitalHospitalDivision().isEnabled()
                && (!getMedicalFacilityCognitiveHospitalHospitalDivision()
                        .getSelectedButton().isEnabled())) {
            // �l���z�u�敪���L�������l���z�u�敪�̑I���{�^���͖����̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if (getMedicalFacilityCognitiveHospitalDinnerCost().isEnabled()) {
            // �H���񋟁ishortStayStandardRecuperationDinnerOffer)���u�Ȃ��v�ȊO��I�����Ă���ꍇ
            if (ACTextUtilities
                    .isNullText(getMedicalFacilityCognitiveHospitalDinnerCost()
                            .getText())) {
                // �H����p(shortStayStandardRecuperationDinnerCost)���󗓂̏ꍇ
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
                        .get("1530308", getSelectedProvider()), 0));
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1530309", getSelectedProvider()), 0));
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1530310", getSelectedProvider()), 0));
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1530311", getSelectedProvider()), 0));
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1530309", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530310",
                                getSelectedProvider()), 0));
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1530310", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530311",
                                getSelectedProvider()), 0));
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1530311", getSelectedProvider()), 0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1530309",
                                getSelectedProvider()), 0));
            }
        }
        // �󕶎���Ԃ��B
        return "";
    }

    /**
     * �u�l�����Z�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void medicalFacilityCognitiveHospitalSubstractionActionPerformed(
            ActionEvent e) throws Exception {
        // ���l�����Z�̑I����e�ɉ����Đl���z�u�敪�̏�ԕύX
        // �l�����Z�̑I����e�ɉ����Đl���z�u�敪�̏�Ԃ�ύX����B
        switch (getMedicalFacilityCognitiveHospitalSubstraction()
                .getSelectedIndex()) {
        case 2:// �Ō쥉��E��������
        case 4:// ���Ŕ䗦��20%����
        case 6:// �ƒn�͏o�Ȃ�
            setState_USE_HUMAN_COST_DOWN();
            setUseHumanCostDown(true);
            break;
        default:
            // if(getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1().isSelected()){
            // //�F�m�ǌ^�����̏ꍇ
            // setState_VALID_HUMAN_TYPE();
            // }else{
            // setState_INVALID_HUMAN_TYPE();
            // }
            setUseHumanCostDown(false);

        }
        // �l���z�u�敪�𐧌䂷��
        changeState();
    }

    /**
     * �l���z�u�敪�Ɋւ��鐧����s���܂��B
     */
    public void changeState() throws Exception {
        // �{�݋敪 �F�m�ǎ����^���I������Ă����ꍇ
        if (getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1()
                .isSelected()) {
            // �l���z�u�敪��L���ɂ���B
            setState_VALID_HUMAN_TYPE();
            // ��w�a�@���I������Ă����ꍇ
            // �T�^��\����Ԃɂ���B
            if (getHospitalDivisionRadioItem1().isSelected()) {
                setState_USE_HUMAN_COST_DOWN1();
            } else {
                // �a�@���I������Ă����ꍇ
                // �l�����Z�敪�u�Ō�E���E���������̏ꍇ�v�u���Ŕ䗦��20%�����̏ꍇ�v�u�ƒn�͏o���v���I������Ă��邩�`�F�b�N����B
                if (getUseHumanCostDown()) {
                    // �W�E�X�^��I���\�ɂ���B
                    setState_USE_HUMAN_COST_DOWN14_OR_5();
                } else {
                    // �T�^�ȊO��I���\�ɂ���B
                    setState_USE_HUMAN_COST_DOWN_NOT1();
                }
            }
        } else {
            // �l���z�u�敪�𖳌��ɂ���B
            setState_INVALID_HUMAN_TYPE();
        }
    }

    /**
     * �a�@�敪�ύX���̃C�x���g
     */
    protected void hospitalDivisionRadioActionPerformed(ActionEvent e) throws Exception {
        changeState();
        
    }

    /**
     * �u�o���ڍs���Z�̕ύX�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void medicalFacilityCognitiveHospitalOralSwitchRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        //�o���ڍs���Z
        if(getMedicalFacilityCognitiveHospitalOralSwitchRadioItem1().isSelected()){
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
     * �u���Ȏ�M���Z�̕ύX�v�C�x���g�ł�
     */
    protected void medicalFacilityCognitiveHospitalMedicalExaminationRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        //���Ȏ�M���肾�����ꍇ
        if(getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem2().isSelected()){
            setState_INVALID_GAIHAKU_ADD();
            //�O�����Z�Ȃ���I����Ԃɂ���
            getMedicalFacilityCognitiveHospitalStayRadioItem1().setSelected(true);
        }else{
            setState_VALID_GAIHAKU_ADD();
        }
        
    }

    /**
     * �u�O�����Z�̕ύX�v�C�x���g�ł�
     */
    protected void medicalFacilityCognitiveHospitalStayRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        //�O�����Z���肾�����ꍇ
        if(getMedicalFacilityCognitiveHospitalStayRadioItem2().isSelected()){
            setState_INVALID_TAKAJUSIN_ADD();
            //���Ȏ�M�Ȃ���I����Ԃɂ���
            getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem1().setSelected(true);
        }else{
            setState_VALID_TAKAJUSIN_ADD();
        }
        
    }

}
