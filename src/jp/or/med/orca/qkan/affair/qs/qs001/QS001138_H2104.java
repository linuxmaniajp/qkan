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
 * �쐬��: 2009/02/10  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�Z�������×{���i���V�l�ی��{�݁j (QS001138_H2104)
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
 * �T�[�r�X�p�^�[�����\�h�Z�������×{���i���V�l�ی��{�݁j(QS001138_H2104)
 */
public class QS001138_H2104 extends QS001138_H2104Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001138_H2104() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayRecuperationHealthFacilityInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        // ��ʂ̏�Ԃ�ύX����B
        checkState();

    }

    /**
     * �u�H���񋟑I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayRecuperationHealthFacilityDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {

        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getShortStayRecuperationHealthFacilityDinnerOffer()
                .getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            checkDinnerState();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            checkDinnerState();

            // �H����p(shortStayLifeDinnerCost)��ݒ肷��B
            checkMeatCost();
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

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001138_H2104.class.getName(),
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
        // ���H����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1250110 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1250110", QkanCommon.getArrayFromMasterCode(191,
                "1250110"));
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
        // ��ʂ̃��W�I�̏����l��ݒ肷��B�iselectFirstRadioItem�j
        QkanCommon.selectFirstRadioItem(getThis());
        // �H���񋟂��u�Ȃ��v�ɂ���B
        VRBindPathParser.set("1250110", defaultMap, new Integer(1));
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();
        // ��ʂ̏�Ԃ𐧌䂷��B
        checkState();

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        if (provider != null) {
            // �I�����Ə����null�łȂ��ꍇ
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = new VRHashMap();
            int index;
            // ���ݒ�
            // �����Ə��A��
            // �{�ݓ��̋敪�i���Ə��p�l���jKEY�F1250101�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1250101",
                    provider), 0)) {
            case 1:
                // �l��1�i���V�l�ی��{�݁j�������ꍇ
                // defaultMap�� KEY�F1250101 VALUE�F1�i���V�l�ی��{�݁j��ݒ肷��B
                VRBindPathParser.set("1250101", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i���j�b�g�^���V�l�ی��{�݁j�������ꍇ
                // defaultMap�� KEY�F1250101 VALUE�F2�i���j�b�g�^���V�l�ی��{�݁j��ݒ肷��B
                VRBindPathParser.set("1250101", defaultMap, new Integer(2));
                break;
            }

            // �{�ݓ��̋敪�i�̐��j
            index = ACCastUtilities.toInt(VRBindPathParser.get("1250116",
                    provider), 0);
            // �ݒ�
            VRBindPathParser.set("1250113", defaultMap, new Integer(index));

            // ��ԋΖ�������i���Ə��p�l���jKEY�F1250102�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1250102",
                    provider), 0)) {
            case 1:
                // �l��1�i��^�j�������ꍇ
                // defaultMap�� KEY�F1250104 VALUE�F1�i��^�j��ݒ肷��B
                VRBindPathParser.set("1250104", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i���Z�^�j�������ꍇ
                // defaultMap�� KEY�F1250104 VALUE�F2�i���Z�^�j��ݒ肷��B
                VRBindPathParser.set("1250104", defaultMap, new Integer(2));
                break;
            }
            // �E���̌����ɂ�錸�Z�̏󋵁i���Ə��p�l���jKEY�F1250122�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1250122",
                    provider), 0)) {
            case 1:
                // �l��1�i�Ȃ��j�������ꍇ
                // defaultMap�� KEY�F1250109 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1250109", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                // �l��2�`7�i��t�E�Ō�E���E���E���EPT�EOT�EST�j�������ꍇ
                // defaultMap�� KEY�F1250109
                // VALUE�F2�i���E�Ō�E�����͈�t�APT�EOT�EST�������j��ݒ肷��B
                VRBindPathParser.set("1250109", defaultMap, new Integer(3));
                break;
            }
            // ���j�b�g�P�A�̐��i���Ə��p�l���jKEY�F1250104�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1250104",
                    provider), 0)) {
            case 1:
                // �l��1�i�Ή��s�j�������ꍇ
                // defaultMap�� KEY�F1250112 VALUE�F1�i�������j��ݒ肷��B
                VRBindPathParser.set("1250112", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i�Ή��j�������ꍇ
                // defaultMap�� KEY�F1250112 VALUE�F2�i�����j��ݒ肷��B
                VRBindPathParser.set("1250112", defaultMap, new Integer(2));
                break;
            }
            // ���n�r���e�[�V�����@�\�����i���Ə��p�l���jKEY�F1250105�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1250105",
                    provider), 0)) {
            case 1:
                // �l��1�i�Ȃ��j�������ꍇ
                // defaultMap�� KEY�F1250105 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1250105", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i����j�������ꍇ
                // defaultMap�� KEY�F1250105 VALUE�F2�i����j��ݒ肷��B
                VRBindPathParser.set("1250105", defaultMap, new Integer(2));
                break;
            }
            // ���}�̐��i���Ə��p�l���jKEY�F1250106�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1250106",
                    provider), 0)) {
            case 1:
                // �l��1�i�Ȃ��j�������ꍇ
                // defaultMap�� KEY�F6 VALUE�F1�i���}�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("6", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i����j�������ꍇ
                // defaultMap�� KEY�F6 VALUE�F3�i���}�����j��ݒ肷��B
                VRBindPathParser.set("6", defaultMap, new Integer(3));
                break;
            }

            // �×{�̐��ێ����ʉ��Z
            index = ACCastUtilities.toInt(VRBindPathParser.get("1250117",
                    provider), 0);
            // �ݒ�
            VRBindPathParser.set("1250114", defaultMap, new Integer(index));

            Object obj;
            // �×{�H
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1250120",
                    provider), 0)) {
            case 2:
                // �u����v�̏ꍇ
                // �L���ɂ���B
                setState_VALID_MEDICAL_EXPENSES();
                VRBindPathParser.set("1250108", defaultMap, new Integer(2));
                break;
            default:
                // �u�Ȃ��v�̏ꍇ
                // �����ɂ���B
                setState_INVALID_MEDICAL_EXPENSES();
                VRBindPathParser.set("1250108", defaultMap, new Integer(1));
                break;
            }
            // ��ΐE���z�u���Z
            obj = VRBindPathParser.get("1250118", provider);
            if (obj != null) {
                VRBindPathParser.set("1250115", defaultMap, obj);
            }
            // ��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1250119�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1250119", provider);
            switch (ACCastUtilities.toInt(obj, 0)) {
            // �l�����̂����ꂩ�������ꍇ
            case 2:
                // 2�i����j
                // �L���ɂ���B
                setState_VALID_YOUNG_DEMENTIA_PATINET();
                break;
            default:
                // �l����L�ȊO�������ꍇ
                // �����ɂ���B
                setState_INVALID_YOUNG_DEMENTIA_PATINET();
                break;
            }
            // ���defaultMap�� KEY�F1250123 VALUE�F1�i�Ȃ��j��ݒ肷��B
            VRBindPathParser.set("1250123", defaultMap, new Integer(1));

            // �T�[�r�X�񋟑̐��������Z
            obj = VRBindPathParser.get("1250121", provider);
            if (obj != null) {
                VRBindPathParser.set("1250117", defaultMap, obj);
            }

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // ��ʂ̏�Ԃ�ύX����B
            checkState();

            // �H���񋟃R���{�̒l���`�F�b�N����B
            if (getShortStayRecuperationHealthFacilityDinnerOffer()
                    .getSelectedIndex() == 0) {
                // �l��1�i�Ȃ��j�������ꍇ
                // �H��R���{�̢�����飂�I������B�i�����I���j
                getShortStayRecuperationHealthFacilityDinnerOffer()
                        .setSelectedIndex(1);
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
        // �{�ݓ��̋敪�i�̐��j�������͂̏ꍇ
        if (getShortStayRecuperationHealthDivision().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }
        // �×{�̐��ێ����ʉ��Z
        if (getRecuperationRadio().getSelectedIndex() < 1) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            return null;
        }
        // ���ԋp�p�̃��R�[�h(data)�𐶐�
        VRMap data = new VRHashMap();
        // ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
        getThis().setSource(data);
        // ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
        getThis().applySource();
        // ���ԋp�p���R�[�h����s�v�ȃL�[������
        // ���H���e�L�X�g�`�F�b�N
        // �H���񋟃R���{�̒l���`�F�b�N����B
        if (getShortStayRecuperationHealthFacilityDinnerOffer()
                .getSelectedIndex() > 0) {
            // �l��1�i�Ȃ��j�ȊO�������ꍇ
            // �H����p(shortStayLifeDinnerCost)�̒l���`�F�b�N����B
            if (ACTextUtilities
                    .isNullText(getShortStayRecuperationHealthFacilityDinnerCost()
                            .getText())) {
                // �l���󔒂������ꍇ
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
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
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkState() throws Exception {
        // ����ʏ�Ԃ̐�����s���܂��B
        // �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z �I����
        if(getDementiaActionAddRadioGroup().getSelectedIndex() == 2) {
            setState_INVALID_YOUNG_DEMENTIA_PATINET();
        } else {
            setState_VALID_YOUNG_DEMENTIA_PATINET();
        }
        
        // ��N���F�m�Ǘ��p�Ҏ�����Z �I����
        if(getYoungDementiaPatinetAddRadioGroup().getSelectedIndex() == 2) {
            setState_INVALID_DEMENTIA_ACTION();
        } else {
            setState_VALID_DEMENTIA_ACTION();
        }
        // ���T�[�r�X�A��
        // �{�ݓ��̋敪�i�T�[�r�X�p�l���j�̒l���`�F�b�N����B
        switch (getShortStayRecuperationHealthFacilityInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // �l��1�i���V�l�ی��{�݁j�������ꍇ
            // �a���敪�i�T�[�r�X�p�l���j��Enable��true�ɂ���B
            setState_HOSPITAL_ROOM_DIVISION_ENABLE_TRUE();
            // �a���敪�i���j�b�g�^�j�i�T�[�r�X�p�l���j��Enable��false�ɂ���B
            setState_UNIT_HOSPITAL_ROOM_DIVISION_ENABEL_FALSE();
            break;
        case 2:
            // �l��2�i���j�b�g�^���V�l�ی��{�݁j�������ꍇ
            // �a���敪�i�T�[�r�X�p�l���j��Enable��false�ɂ���B
            setState_HOSPITAL_ROOM_DIVISION_ENABLE_FALSE();
            // �a���敪�i���j�b�g�^�j�i�T�[�r�X�p�l���j��Enable��true�ɂ���B
            setState_UNIT_HOSPITAL_ROOM_DIVISION_ENABEL_TRUE();
            break;
        }
        // �����Ə��A��
        // �����ϐ� providerInfoMap �𐶐�����B
        VRMap providerInfoMap;
        // ���Ə��p�l�������擾�� providerInfoMap �Ɋi�[����B
        providerInfoMap = getSelectedProvider();

        // providerInfoMap�� null ���`�F�b�N����B
        // null�i���Ə����I���j�������ꍇ
        // �����s��Ȃ��B
        if (providerInfoMap != null) {
            // null�ȊO�������ꍇ
            // ���j�b�g�P�A�̐��i���Ə��p�l���j�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1250104",
                    providerInfoMap), 0)) {
            case 1:
                // �l��1�i�Ȃ��j�������ꍇ
                // ���j�b�g�P�A�̐����i�T�[�r�X�p�l���j��Enable��false�ɂ���B
                setState_UNIT_CARE_ENABLE_FALSE();
                break;
            case 2:
                // �l��2�i����j�������ꍇ
                // ���j�b�g�P�A�̐����i�T�[�r�X�p�l���j��Enable��true�ɂ���B
                setState_UNIT_CARE_ENABLE_TRUE();
            }
            // ���n�r���e�[�V�����@�\�����i���Ə��p�l���j�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1250105",
                    providerInfoMap), 0)) {
            case 1:
                // �l��1�i�Ȃ��j�������ꍇ
                // ���n�r���@�\�������Z�i�T�[�r�X�p�l���j��Enable��false�ɂ���B
                setState_REHABILITATION_ENABLE_FALSE();
                break;
            case 2:
                // �l��2�i����j�������ꍇ
                // ���n�r���@�\�������Z�i�T�[�r�X�p�l���j��Enable��true�ɂ���B
                setState_REHABILITATION_ENABLE_TRUE();
                break;
            }
            
            Object obj;
            
            //��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1250119�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1250119", providerInfoMap);
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

        // ���j�b�g�^�ȊO�̏ꍇ�͈ꗥ���j�b�g�P�A�𖳌��ɂ���B
        switch (getShortStayRecuperationHealthFacilityInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            setState_UNIT_CARE_ENABLE_FALSE();
            break;
        }
    }

    /**
     * �u�H���e�L�X�g����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkDinnerState() throws Exception {
        // ���H���e�L�X�g�̐�����s��
        // �H���񋟁ishortStayRecuperationHealthFacilityDinnerCost�j�̒l���`�F�b�N����B
        if (getShortStayRecuperationHealthFacilityDinnerOffer()
                .getSelectedIndex() == 0) {
            // �l��1�������ꍇ
            // �H���e�L�X�g��Enable�� false �ɂ���B
            setState_DINNER_COST_ENABLE_FALSE();
        } else {
            // �l��1�ȊO�������ꍇ
            // �H���e�L�X�g��Enable�� true �ɂ���B
            setState_DINNER_COST_ENABLE_TRUE();
        }

    }

    /**
     * �u�H����p���v�l�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkMeatCost() throws Exception {
        // ���H�����������ƂɑI�����Ə��ɂ�����H����p��Ԃ��B
        if (getSelectedProvider() != null) {
            // ���Ə������I���inull�j �ł͂Ȃ��ꍇ
            String meat = "";
            switch (getShortStayRecuperationHealthFacilityDinnerOffer()
                    .getSelectedIndex()) {
            case 1:
                // �H���������u������v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��A�u��v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1250108", getSelectedProvider()),
                        0));
                break;
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1250109", getSelectedProvider()),
                        0));
                break;
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1250110", getSelectedProvider()),
                        0));
                break;
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1250111", getSelectedProvider()),
                        0));
                break;
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��Ɓu���v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1250109", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1250110",
                                getSelectedProvider()), 0));
                break;
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��Ɓu��v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1250110", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1250111",
                                getSelectedProvider()), 0));
                break;
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��Ɓu���v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1250111", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1250109",
                                getSelectedProvider()), 0));
                break;
            }
            getShortStayRecuperationHealthFacilityDinnerCost().setText(meat);
        } else {
            // ���Ə������I���̏ꍇ
            // �󕶎���Ԃ��B
            getShortStayRecuperationHealthFacilityDinnerCost().setText("");
        }
    }

    /**
     * �u�f�[�^�o�C���h��̏����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public void binded() throws Exception {
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

    protected void dementiaActionAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        checkState();

    }

    protected void youngDementiaPatinetAddRadioGroupSelectionChanged(
            ListSelectionEvent e) throws Exception {
        checkState();

    }

}
