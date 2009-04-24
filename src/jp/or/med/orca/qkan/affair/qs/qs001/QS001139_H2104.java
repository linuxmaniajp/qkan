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
 * �v���O���� �T�[�r�X�p�^�[�����\�h�Z�������×{���i�a�@�j (QS001139_H2104)
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
 * �T�[�r�X�p�^�[�����\�h�Z�������×{���i�a�@�j(QS001139_H2104)
 */
public class QS001139_H2104 extends QS001139_H2104Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001139_H2104() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayHospitalRecuperationInstitutionDivisionRadioActionPerformed(
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

            // �H����p(shortStayRecuperationHealthFacilityDinnerCost)��ݒ肷��B
            checkMeatCost();
        }
    }

    /**
     * �u����f�Ô�ҏW�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayHospitalRecuperationSpecificConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {
        // ������f�Ô�̕ҏW
        // ����f�Ô�ҏW���(QS001199_H2104)�𐶐�����B
        // ����f�Ô�{�^���̃f�[�^�������ɐ�����������f�Ô�ҏW���(QS001199)��shoModal�����s����B
        if (new QS001199_H2104().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getShortStayHospitalRecuperationSpecificConsultationFee()
                        .getDataModel())) {
            // ����f�Ô��ύX�����ꍇ
            if (getShortStayHospitalRecuperationSpecificConsultationFee()
                    .getDataModel().isEmpty()) {
                // ����f�Ô�{�^���̃f�[�^����̏ꍇ
                // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
                getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                        .setText("�ݒ�Ȃ�");
            } else {
                // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
                // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
                getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                        .setText("�ݒ肠��");
            }
        }

    }

    /**
     * �u�l�����Z�R���{�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayHospitalRecuperationPersonSubtractionActionPerformed(
            ActionEvent e) throws Exception {
        // �l�����Z�̃R���{�I������
        // ��ʂ̏�Ԃ�ύX����B
        checkState();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001139_H2104.class.getName(),
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
        // QS001199_H2104(����f�Ô�)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A����f�Ô�{�^���ɐݒ肷��B
        getShortStayHospitalRecuperationSpecificConsultationFee()
                .clearDataModel();
        getShortStayHospitalRecuperationSpecificConsultationFee()
                .setBindPathes(
                        QS001199_H2104
                                .getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
        // ���H����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1260111 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1260111", QkanCommon.getArrayFromMasterCode(191,
                "1260111"));
        // ���l�����Z
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F66�i�l�����Z�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1260110 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1260110", QkanCommon.getArrayFromMasterCode(66,
                "1260110"));
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
        VRBindPathParser.set("1260111", defaultMap, new Integer(1));
        // �l�����Z���u�Ȃ��v�ɂ���B
        VRBindPathParser.set("1260110", defaultMap, new Integer(1));
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();
        // ��ʂ̏�Ԃ�ݒ肷��B
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
            // ���ݒ�
            // �����Ə��A��
            // �{�ݓ��̋敪�i���Ə��p�l���jKEY�F1260122�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260122",
                    provider), 0)) {
            case 1:
                // �l��1�i�a�@�×{�^�j�������ꍇ
                // defaultMap�� KEY�F1260101 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1260101", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i���j�b�g�^�a�@�×{�^�j�������ꍇ
                // defaultMap�� KEY�F1260101 VALUE�F2�i����j��ݒ肷��B
                VRBindPathParser.set("1260101", defaultMap, new Integer(2));
                break;
            case 3:
                // �l��3�i�o�ߌ^�j�������ꍇ
                // defaultMap�� KEY�F1260101 VALUE�F3��ݒ肷��B
                VRBindPathParser.set("1260101", defaultMap, new Integer(3));
                break;
            case 4:
                // �l��4�i���j�b�g�^�o�ߌ^�j�������ꍇ
                // defaultMap�� KEY�F1260101 VALUE�F3��ݒ肷��B
                VRBindPathParser.set("1260101", defaultMap, new Integer(4));
                break;
            }
            // �l���z�u�敪�i���Ə��p�l���jKEY�F1260123�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260123",
                    provider), 0)) {
            case 1:
                // �l��1�i�T�j�������ꍇ
                // defaultMap�� KEY�F1260102 VALUE�F1�i�T�j��ݒ肷��B
                VRBindPathParser.set("1260102", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i�U�j�������ꍇ
                // defaultMap�� KEY�F1260102 VALUE�F2�i�U�j��ݒ肷��B
                VRBindPathParser.set("1260102", defaultMap, new Integer(2));
                break;
            case 3:
                // �l��3�i�V�j�������ꍇ
                // defaultMap�� KEY�F1260102 VALUE�F3�i�V�j��ݒ肷��B
                VRBindPathParser.set("1260102", defaultMap, new Integer(3));
                break;
            }
            // ��ԋΖ�������i���Ə��p�l���jKEY�F1260124�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260124",
                    provider), 0)) {
            case 1:
                // �l��1�i��^�j�������ꍇ
                // defaultMap�� KEY�F1260105 VALUE�F1�i��^�j��ݒ肷��B
                VRBindPathParser.set("1260105", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i���Z�^�T�j�������ꍇ
                // defaultMap�� KEY�F1260105 VALUE�F2�i���Z�^�T�j��ݒ肷��B
                VRBindPathParser.set("1260105", defaultMap, new Integer(2));
                break;
            case 3:
                // �l��3�i���Z�^�U�j�������ꍇ
                // defaultMap�� KEY�F1260105 VALUE�F3�i���Z�^�U�j��ݒ肷��B
                VRBindPathParser.set("1260105", defaultMap, new Integer(3));
                break;
            case 4:
                // �l��4�i���Z�^�V�j�������ꍇ
                // defaultMap�� KEY�F1260105 VALUE�F4�i���Z�^�V�j��ݒ肷��B
                VRBindPathParser.set("1260105", defaultMap, new Integer(4));
                break;
            case 5:
                // �l��5�i���Z�^�j�������ꍇ
                // defaultMap�� KEY�F1260105 VALUE�F5�i���Z�^�j��ݒ肷��B
                VRBindPathParser.set("1260105", defaultMap, new Integer(5));
                break;
            case 6:
                // �l��6�i���Z�^IV�j�������ꍇ
                // defaultMap�� KEY�F1260105 VALUE�F6�i���Z�^IV�j��ݒ肷��B
                VRBindPathParser.set("1260105", defaultMap, new Integer(6));
                break;
            }
            // �E���̌����ɂ�錸�Z�̏󋵁i���Ə��p�l���jKEY�F1260104�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260104",
                    provider), 0)) {
            case 1:
            case 2:
                // �l��1����2�i�Ȃ��E��t�j�������ꍇ
                // defaultMap�� KEY�F1260110 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1260110", defaultMap, new Integer(1));
                break;
            case 3:
            case 4:
                // �l��3����4�i�Ō�E���E���j�������ꍇ
                // defaultMap�� KEY�F1260110 VALUE�F2�i����j��ݒ肷��B
                VRBindPathParser.set("1260110", defaultMap, new Integer(3));
                break;
            }
            // ���j�b�g�P�A�̐��i���Ə��p�l���jKEY�F1260125�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260125",
                    provider), 0)) {
            case 1:
                // �l��1�i�Ή��s�j�������ꍇ
                // defaultMap�� KEY�F1260113 VALUE�F1�i�������j��ݒ肷��B
                VRBindPathParser.set("1260113", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i�Ή��j�������ꍇ
                // defaultMap�� KEY�F1260113 VALUE�F2�i�����j��ݒ肷��B
                VRBindPathParser.set("1260113", defaultMap, new Integer(2));
                break;
            }
            // �×{����i���Ə��p�l���jKEY�F1260121�̒l���`�F�b�N����B
            // �̐��͊�^�ƌ��Z�^�����A�Z����肤��l�͊�^�ƌ��Z�^I�A���Z�^III
            // switch (ACCastUtilities.toInt(VRBindPathParser.get("1260121",
            // provider), 0)) {
            // case 1:
            // // �l��1�i��^�j�������ꍇ
            // // defaultMap�� KEY�F1260116 VALUE�F1�i��^�j��ݒ肷��B
            // VRBindPathParser.set("1260116", defaultMap, new Integer(1));
            // break;
            // case 2:
            // // �l��2�i���Z�^�j�������ꍇ
            // // defaultMap�� KEY�F1260116 VALUE�F2�i���Z�^�j��ݒ肷��B
            // VRBindPathParser.set("1260116", defaultMap, new Integer(2));
            // break;
            // }
            // ��t�̔z�u��i���Ə��p�l���jKEY�F1260107�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260107",
                    provider), 0)) {
            case 1:
                // �l��1�i��t�̔z�u��j�������ꍇ
                // defaultMap�� KEY�F1260107 VALUE�F1�i��t�̔z�u��j��ݒ肷��B
                VRBindPathParser.set("1260107", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i��t�@�{�H�K����49���j�������ꍇ
                // defaultMap�� KEY�F1260107 VALUE�F2�i��t�@�{�H�K����49���j��ݒ肷��B
                VRBindPathParser.set("1260107", defaultMap, new Integer(2));
                break;
            }
            // ���}�̐��i���Ə��p�l���jKEY�F1260108�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260108",
                    provider), 0)) {
            case 1:
                // �l��1�i�Ή��s�j�������ꍇ
                // defaultMap�� KEY�F6 VALUE�F1�i���}�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("6", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i�Ή��j�������ꍇ
                // defaultMap�� KEY�F6 VALUE�F3�i���}�����j��ݒ肷��B
                VRBindPathParser.set("6", defaultMap, new Integer(3));
                break;
            }

            Object obj;
            // �×{�H
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260119",
                    provider), 0)) {
            case 2:
                // �u����v�̏ꍇ
                // �L���ɂ���B
                setState_VALID_MEDICAL_EXPENSES();
                // [ID:0000481][Tozo TANAKA] 2009/04/08 delete begin ����21�N4���@�����Ή�(�×{�H)
//                defaultMap.setData("1260109", new Integer(2));
                // [ID:0000481][Tozo TANAKA] 2009/04/08 delete end
                break;
            default:
                // �u�Ȃ��v�̏ꍇ
                // �����ɂ���B
                setState_INVALID_MEDICAL_EXPENSES();
            // [ID:0000481][Tozo TANAKA] 2009/04/08 delete begin ����21�N4���@�����Ή�(�×{�H)
//                defaultMap.setData("1260109", new Integer(1));
            // [ID:0000481][Tozo TANAKA] 2009/04/08 delete end
                break;
            }
            // [ID:0000481][Tozo TANAKA] 2009/04/08 add begin ����21�N4���@�����Ή�(�×{�H)
            //���defaultMap�� KEY�F1260109 VALUE�F1�i�Ȃ��j��ݒ肷��B
            VRBindPathParser.set("1260109", defaultMap, new Integer(1));   
            // [ID:0000481][Tozo TANAKA] 2009/04/08 add end

            // ��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1260118�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1260118", provider);
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
            // ���defaultMap�� KEY�F1260114 VALUE�F1�i�Ȃ��j��ݒ肷��B
            VRBindPathParser.set("1260114", defaultMap, new Integer(1));

            // �T�[�r�X�񋟑̐��������Z
            obj = VRBindPathParser.get("1260120", provider);
            if (obj != null) {
                VRBindPathParser.set("1260115", defaultMap, obj);
            }

            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // ��ʂ̏�Ԃ�ύX����B
            checkState();

            // �������ݒ�
            // �H���񋟃R���{�`�F�b�N
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
        // ���l���z�u�敪�`�F�b�N
        // �{�݋敪�����j�b�g�^�ł͂Ȃ������ꍇ
        if (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex() == 1) {
            // �l���z�u�敪�̌��ݑI������Ă��郉�W�I��Enable���`�F�b�N����B
            if (!getShortStayHospitalRecuperationDivision().getSelectedButton()
                    .isEnabled()) {
                // Enable��false �������ꍇ
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
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkState() throws Exception {
        // ����ʏ�Ԑ���
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
        switch (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // �l��1�i�a�@�j�������ꍇ
            // �l�����Z�i�T�[�r�X�p�l���j�̒l���`�F�b�N����
            switch (getShortStayHospitalRecuperationPersonSubtraction()
                    .getSelectedIndex()) {
            case 0:
            case 1:
            case 4:
                // �l��1����2����5�i�Ȃ��E������߁E�ƒn�͏o�L�j�������ꍇ
                // ��ʂ̏�Ԃ�ύX����B
                setState_STATE_MODE_1();
                break;
            case 2:
            case 3:
            case 5:
                // �l��3����4����6�i�Ō�E���E���̕s���E���Ŕ䗦��20%�����E�ƒn�͏o���j�������ꍇ
                // ��ʂ̏�Ԃ�ύX����B
                setState_STATE_MODE_2();
                break;
            }
            break;
        case 2:
            // �l��2�i���j�b�g�^�a�@�j�������ꍇ
            // ��ʂ̏�Ԃ�ύX����B
            setState_STATE_MODE_3();
            break;
        case 3:
            // �l��3�i�o�ߌ^�j�������ꍇ
            // �l�����Z�i�T�[�r�X�p�l���j�̒l���`�F�b�N����

            switch (getShortStayHospitalRecuperationPersonSubtraction()
                    .getSelectedIndex()) {
            case 0:
            case 1:
            case 4:
                // �l��1����2����5�i�Ȃ��E������߁E�ƒn�͏o�L�j�������ꍇ
                // ��ʂ̏�Ԃ�ύX����B
                setState_STATE_MODE_4();
                break;
            case 2:
            case 3:
            case 5:
                // �l��3����4����6�i�Ō�E���E���̕s���E���Ŕ䗦��20%�����E�ƒn�͏o���j�������ꍇ
                // ��ʂ̏�Ԃ�ύX����B
                setState_STATE_MODE_6();
                break;
            }

            break;
        case 4:
            // �l��4�i���j�b�g�^�o�ߌ^�j�������ꍇ
            // ��ʂ̏�Ԃ�ύX����B
            setState_STATE_MODE_5();
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
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260125",
                    providerInfoMap), 0)) {
            case 1:
                // �l��1�i�Ή��s�j�������ꍇ
                // ���j�b�g�P�A�̐����i�T�[�r�X�p�l���j��Enable��false�ɂ���B
                setState_UNIT_CARE_MAINTENANCE_ENABLE_FALSE();
                break;
            case 2:
                // �l��2�i�Ή��j�������ꍇ
                // ���j�b�g�P�A�̐����i�T�[�r�X�p�l���j��Enable��true�ɂ���B
                setState_UNIT_CARE_MAINTENANCE_ENABLE_TRUE();
                break;
            }
            
            Object obj;
            
            //��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1260118�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1260118", providerInfoMap);
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

        // ���j�b�g�P�A�̐���Enable����
        switch (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {
        // ���j�b�g�P�A�̐������L���ł��{�݋敪�����j�b�g�^�łȂ���΃��j�b�g�P�A�̐����𖳌��Ƃ���悤�A�{�݋敪���`�F�b�N����B
        case 2:
            // ���j�b�g�^�a�@�̏ꍇ
        case 4:
            // ���j�b�g�^�o�ߌ^�̏ꍇ
            break;
        default:
            // ���j�b�g�^�ȊO�̏ꍇ
            setState_UNIT_CARE_MAINTENANCE_ENABLE_FALSE();
            break;
        }

    }

    /**
     * �u�H��e�L�X�g����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkDinnerState() throws Exception {
        // ���H��e�L�X�g��Enable���䏈��
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
                        VRBindPathParser.get("1260110", getSelectedProvider()),
                        0));
                break;
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260111", getSelectedProvider()),
                        0));
                break;
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260112", getSelectedProvider()),
                        0));
                break;
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260113", getSelectedProvider()),
                        0));
                break;
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��Ɓu���v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260111", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260112",
                                getSelectedProvider()), 0));
                break;
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��Ɓu��v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260112", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260113",
                                getSelectedProvider()), 0));
                break;
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��Ɓu���v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260113", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260111",
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
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return null;
    }

    /**
     * �u�f�[�^�o�C���h���̏����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public void binded() throws Exception {
        // ���f�[�^�o�C���h���̏���
        // ����f�Ô�{�^���̃f�[�^�̗L�����`�F�b�N����B
        if (getShortStayHospitalRecuperationSpecificConsultationFee()
                .getDataModel().isEmpty()) {
            // ����f�Ô�{�^���̃f�[�^����̏ꍇ
            // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
            getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                    .setText("�ݒ�Ȃ�");
        } else {
            // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
            // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
            getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                    .setText("�ݒ肠��");
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
