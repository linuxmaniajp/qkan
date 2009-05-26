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
 * �v���O���� �T�[�r�X�p�^�[���ʏ����n (QS001108_H2104)
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
 * �T�[�r�X�p�^�[���ʏ����n(QS001108_H2104)
 */
public class QS001108_H2104 extends QS001108_H2104Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001108_H2104() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�J�n���ԁv�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonRehabilitationTimeContenaBeginTimeActionPerformed(
            ActionEvent e) throws Exception {
        // �T�[�r�X�񋟎��ԁi�J�n�j�̎��ԋ敪�ύX���̏���
        // �T�[�r�X�񋟎��ԁi�J�n�j�̎��ԋ敪�ύX��
        checkEndTime();

    }

    /**
     * �u�I�����ԁv�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonRehabilitationTimeDivisionActionPerformed(ActionEvent e)
            throws Exception {
        // �T�[�r�X�񋟎��ԁi�I���j�̎��ԋ敪�ύX���̏���
        // �����ԋ敪�ύX���A�I�����Ԃ��ύX
        changeState();
        // �T�[�r�X�񋟎��ԁi�I���j�̎��ԋ敪�ύX��
        checkEndTime();

    }

    /**
     * �u���n�r���K��w�������Z�̗L���`�F�b�N�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonRehabilitationTimeContenaFacilityDivisionSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // �{�ݓ��̋敪�ύX���̏���
        // �{�ݓ��̋敪�ɉ����ă��n�r���K��w�������Z�̗L���`�F�b�N��ύX����B
        // TODO�@���Ə��̈������m�F

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001108_H2104.class.getName(),
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
        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F275�i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1160104 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1160104", QkanCommon.getArrayFromMasterCode(275,
                "1160104"));
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
        QkanCommon.selectFirstRadioItem(this);
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
        // �I�����Ə����null�łȂ��ꍇ
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = new VRHashMap();
            // ���ݒ�
            Object obj;
            // �{�݋敪
            obj = VRBindPathParser.get("1160112", provider);
            if (obj != null) {
                VRBindPathParser.set("1160116", defaultMap, obj);
            }
            // �������Z
            obj = VRBindPathParser.get("1160102", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 2) {
                    // �u����v�̏ꍇ
                    // houmonRehabilitationBathRadio��2�Ԗڂ̃{�^�����擾���A�L���ɂ���B
                    setState_VALID_ADD_BATH();
                    VRBindPathParser.set("1160105", defaultMap, obj);
                } else {
                    // �u�Ȃ��v�̏ꍇ
                    // houmonRehabilitationBathRadio��2�Ԗڂ̃{�^�����擾���A�����ɂ���B
                    setState_INVALID_ADD_BATH();
                    VRBindPathParser.set("1160105", defaultMap, obj);
                }
            }
            // ���n�r���E�}�l�W�����g���Z
            obj = VRBindPathParser.get("1160107", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    setState_INVALID_REHABILITATION_MANAGEMENT_ADD();
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    setState_VALID_REHABILITATION_MANAGEMENT_ADD();
                    VRBindPathParser.set("1160111", defaultMap, obj);
                    break;
                }
            }
            // �h�{�}�l�W�����g�̐�
            obj = VRBindPathParser.get("1160116", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    setState_INVALID_NOURISHMENT_MANAGEMENT();
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    setState_VALID_NOURISHMENT_MANAGEMENT();
                    break;
                }
                VRBindPathParser.set("1160114", defaultMap, obj);
            }
            // ���o�@�\����̐�
            obj = VRBindPathParser.get("1160109", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��̏ꍇ
                    setState_INVALID_MOUTH_FUNCTION();
                    break;
                case 2:
                    // �̐�����̏ꍇ
                    setState_VALID_MOUTH_FUNCTION();
                    break;
                }
                VRBindPathParser.set("1160115", defaultMap, obj);
            }
            // �l�����Z
            obj = VRBindPathParser.get("1160105", provider);
            if (obj != null) {
                //���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch(ACCastUtilities.toInt(obj)){
                case 1: //�Ȃ��������ꍇ
                    VRBindPathParser.set("1160109", defaultMap, new Integer(1));
                    break;
                case 2: //��t�������ꍇ
                case 3: //�Ō�E���������ꍇ
                case 4: //���E���������ꍇ
                case 5: //���w�Ö@�m�������ꍇ
                case 6: //��ƗÖ@�m�������ꍇ
                case 7: //���꒮�o�m�������ꍇ
                    VRBindPathParser.set("1160109", defaultMap, new Integer(3));
                    break;
                }
            }
            
            // �F�m�ǒZ���W�����n�r���e�[�V�������Z
            obj = VRBindPathParser.get("1160113", provider);
            if (obj != null) {
                VRBindPathParser.set("1160120", defaultMap, obj);
            }
            
            // ��N���F�m�Ǘ��p��
            obj = VRBindPathParser.get("1160114", provider);
            if (obj != null) {
                VRBindPathParser.set("1160121", defaultMap, obj);
            }
            
            // �T�[�r�X�񋟑̐��������Z
            obj = VRBindPathParser.get("1160115", provider);
            if (obj != null) {
                VRBindPathParser.set("1160122", defaultMap, obj);
            }



            //��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1160114�̒l���`�F�b�N����B
            obj = VRBindPathParser.get("1160114", provider);
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
            //���defaultMap�� KEY�F1160121 VALUE�F1�i�Ȃ��j��ݒ肷��B
            VRBindPathParser.set("1160121", defaultMap, new Integer(1));   

            
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            
            // [ID:0000500][Masahiko Higuchi] 2009/05/01 del begin �y�T�[�r�X�\��z�ʏ����n�̎��ԋ敪���I��
            // �����I��
//            if (getHoumonRehabilitationTimeDivision().getItemCount() > 0
//                    && getHoumonRehabilitationTimeDivision().getSelectedIndex() < 0) {
//                getHoumonRehabilitationTimeDivision().setSelectedIndex(0);
//            }
            // [ID:0000500][Masahiko Higuchi] 2009/05/01 del end
            
        }

        // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
        changeState();
    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if (!getHoumonRehabilitationTimeDivision().isSelected()) {
            // ���ԋ�(houmonRehabilitationTimeDivision)�������I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }

        if (ACTextUtilities
                .isNullText(getHoumonRehabilitationTimeContenaBeginTime()
                        .getText())
                || ACTextUtilities
                        .isNullText(getHoumonRehabilitationTimeContenaEndTime()
                                .getText())
                || (!getHoumonRehabilitationTimeContenaBeginTime()
                        .isValidDate())
                || (!getHoumonRehabilitationTimeContenaEndTime().isValidDate())) {
            // �J�n�����R���{(houmonRehabilitationTimeContenaBeginTime)���󗓂��s���̏ꍇ
            // �������͏I�������R���{(houmonRehabilitationTimeContenaEndTime)���󗓂��s���̏ꍇ
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
        return getHoumonRehabilitationTimeContenaBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getHoumonRehabilitationTimeContenaEndTime();
    }

    public void changeState() throws Exception {
        int idx = getHoumonRehabilitationTimeDivision().getSelectedIndex();
        // ���ԋ敪�ɂ���ʐ��䏈��
        switch(idx) {
        case 0: // 1�`2�̏ꍇ
            setState_VALID_BODY_WORK();
            setState_VALID_PHYSIOTHERAPIST_STRENGTHENED();
            // [ID:0000496][Tozo TANAKA] 2009/04/28 delete begin �y�T�[�r�X�\��z�ʏ����n�̌ʃ��n�r�����{���Z�̕s����������(���ԋ敪1����2���Ԃ̂Ƃ�)
            //setState_INVALID_OPEN_STOCK_REHABILITATION();
            // [ID:0000496][Tozo TANAKA] 2009/04/28 delete end �y�T�[�r�X�\��z�ʏ����n�̌ʃ��n�r�����{���Z�̕s����������(���ԋ敪1����2���Ԃ̂Ƃ�)
            break;
        default:// ��L�ȊO
            setState_INVALID_BODY_WORK();
            setState_INVALID_PHYSIOTHERAPIST_STRENGTHENED();
            // [ID:0000496][Tozo TANAKA] 2009/04/28 delete begin �y�T�[�r�X�\��z�ʏ����n�̌ʃ��n�r�����{���Z�̕s����������(���ԋ敪1����2���Ԃ̂Ƃ�)
            //setState_VALID_OPEN_STOCK_REHABILITATION();
            // [ID:0000496][Tozo TANAKA] 2009/04/28 delete end �y�T�[�r�X�\��z�ʏ����n�̌ʃ��n�r�����{���Z�̕s����������(���ԋ敪1����2���Ԃ̂Ƃ�)
            break;
        }
        
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
        if (getHoumonRehabilitationTimeContenaBeginTime().isValidDate()
                && (!ACTextUtilities
                        .isNullText(getHoumonRehabilitationTimeContenaBeginTime()
                                .getText()))) {
            // �J�n���ԃR���{(houmonKangoKaigoBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
            // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
            int kaigoTime = getKaigoTime();

            // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
            getHoumonRehabilitationTimeContenaEndTime().setDate(
                    ACDateUtilities.addMinute(
                            getHoumonRehabilitationTimeContenaBeginTime()
                                    .getDate(), kaigoTime));
        }

    }

    /**
     * �u���ԋ敪�̎��Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getKaigoTime() throws Exception {
        // �����ԋ敪(houmonRehabilitationTimeDivision)�̎��Ԃ��擾
        // ���ԋ敪(houmonRehabilitationTimeDivision)�̒l���`�F�b�N����B
        switch (getHoumonRehabilitationTimeDivision().getSelectedIndex()) {
        case 0:
            // �P���Ԉȏ�Q���Ԗ����̏ꍇ
            // �߂�l�Ƃ���120��Ԃ��B            
            return 120;
        case 1:
            // �Q���Ԉȏ�R���Ԗ����̏ꍇ
            // �߂�l�Ƃ���180��Ԃ��B
            return 180;
        case 2:
            // �R���Ԉȏ�S���Ԗ����̏ꍇ
            // �߂�l�Ƃ���240��Ԃ��B
            return 240;
        case 3:
            // �S���Ԉȏ�U���Ԗ����̏ꍇ
            // �߂�l�Ƃ���360��Ԃ��B
            return 360;
        case 4:
            // �U���Ԉȏ�W���Ԗ����̏ꍇ
            // �߂�l�Ƃ���480��Ԃ��B
            return 480;
        case 5:
            // �W���Ԉȏ�X���Ԗ����̏ꍇ
            // �߂�l�Ƃ���540��Ԃ��B
            return 540;
        case 6:
            // �X���Ԉȏ�P�O���Ԗ����̏ꍇ
            // �߂�l�Ƃ���600��Ԃ��B
            return 600;
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
