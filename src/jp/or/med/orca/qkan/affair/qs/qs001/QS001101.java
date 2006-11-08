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
 * �쐬��: 2006/02/23  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K���� (QS001101)
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
 * �T�[�r�X�p�^�[���K����(QS001101)
 */
public class QS001101 extends QS001101Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001101() {
    }

    // �R���|�[�l���g�C�x���g

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001101.class.getName(), param));
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
        // ���K����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F198�i�K���ʁj���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1110101 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1110101", QkanCommon.getArrayFromMasterCode(198,
                "1110101"));
        // ���񋟎���
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F26�i�񋟎��ԁj���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1110105 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1110105", QkanCommon.getArrayFromMasterCode(26,
                "1110105"));
        // �������g�̎���
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F26�i�����g�̎��ԁj���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1110104 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1110104", QkanCommon.getArrayFromMasterCode(26,
                "1110104"));
        // ���J�n����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
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
        // ���W�J
        // �K��҂̋��E���W�I�O���[�v(houmonKaigoClass)�́u3���ȊO�v��I������B
        VRBindPathParser.set("1110106", defaultMap, new Integer(1));
        // �K��l�����W�I�O���[�v(houmonKaigoNumberOfPeople)�́u1�l�v��I������B
        VRBindPathParser.set("1110107", defaultMap, new Integer(1));
        // ���ԑу��W�I�O���[�v(houmonKaigoTimeZone)�́u�ʏ�v��I������B
        VRBindPathParser.set("1110108", defaultMap, new Integer(1));
        // ���莖�Ə��̐��̒l��ݒ肷��B
        VRBindPathParser.set("1110109", defaultMap, new Integer(1));
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u��Ԑݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKaigoServicePatternActionPerformed(ActionEvent e)
            throws Exception {
        // ���u�K���ʁv�ɉ����āA�I���\�ȃC���X�^���X��ݒ�
        // �R���{����ݒ肷��B
        checkComboItem();
        // �K���ʂ̒l���`�F�b�N����B
        switch (getHoumonKaigoServicePattern().getSelectedIndex()) {
        case 0:
            // �g�̉��̏ꍇ
            // �g�̉��p�̏�Ԃ�ݒ肷��B
            setState_SHINTAI_KAIGO();
            break;
        case 1:
            // ���������̏ꍇ
            // ���������p�̏�Ԃ�ݒ肷��B
            setState_SEIKATSU_ENJO();
            break;
        case 2:
            // �g�̐����̏ꍇ
            // �g�̐����p�̏�Ԃ�ݒ肷��B
            setState_SHINTAI_SEIKATSU();
            break;
        case 3:
            // �ʉ@����~��̏ꍇ
            // �ʉ@����~��p�̏�Ԃ�ݒ肷��B
            setState_JOKOKAIJO();
            break;
        }
    }
    /**
     * �u���ԑѕύX���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKaigoTimeZoneActionPerformed(ActionEvent e)
            throws Exception {
        // �����ԑѕύX���A�J�n���Ԃ��ύX
        // houmonKaigoTimeZone�̒l���`�F�b�N����B
        switch (getHoumonKaigoTimeZone().getSelectedIndex()) {
        case 1:
            // �ʏ�̏ꍇ
            // �J�n���Ԃ�9:00�ɂ���B
            getHoumonKaigoBeginTime().setText("9:00");
            break;
        case 2:
            // �����̏ꍇ
            // �J�n���Ԃ�6:00�ɂ���B
            getHoumonKaigoBeginTime().setText("6:00");
            break;
        case 3:
            // ��Ԃ̏ꍇ
            // �J�n���Ԃ�18:00�ɂ���B
            getHoumonKaigoBeginTime().setText("18:00");
            break;
        case 4:
            // �[��̏ꍇ
            // �J�n���Ԃ�22:00�ɂ���B
            getHoumonKaigoBeginTime().setText("22:00");
            break;
        }
        // ���ԑѕύX���A�I�����Ԃ��ύX����B
        checkEndTime();

    }

    /**
     * �u�g�̉��񋟎��ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void homonkaigoTeikyoTimeActionPerformed(ActionEvent e)
            throws Exception {
        // �����ԑѕύX���A�I�����Ԃ��ύX
        // ���ԑѕύX���A�I�����Ԃ��ύX����B
        checkEndTime();
    }
    
    /**
     * �u���������񋟎��ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKaigoInTimeActionPerformed(ActionEvent e)
            throws Exception {
        // �����ԑѕύX���A�I�����Ԃ��ύX
        // ���ԑѕύX���A�I�����Ԃ��ύX����B
        checkEndTime();
    }
    
    /**
     * �u�I�����Ԃ̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkEndTime() throws Exception {
        // �����ԑѕύX���A�I�����Ԃ��ύX
        if (getHoumonKaigoBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getHoumonKaigoBeginTime()
                        .getText()))) {
            // �J�n�����R���{(houmonKaigoBeginTime)�����͍ς݂��s���łȂ��ꍇ
            // �񋟎��ԃR���{����񋟕������擾����B
            // �J�n�����ɒ񋟕��������Z�������ʂ��I�������R���{(houmonKaigoEndTime)�ɐݒ肷��B
            getHoumonKaigoEndTime().setDate(
                    ACDateUtilities.addMinute(
                            getHoumonKaigoBeginTime().getDate(),
                            getTeikyoTime()));
        }

    }
    
    /**
     * �u�񋟎��Ԃ̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return int
     */
    public int getTeikyoTime() throws Exception {
        // ���񋟎��ԃR���{���A���Ԃ��擾
        int addMinute = 0;
        // �񋟎��ԃR���{(homonkaigoTeikyoTime)�̒l���`�F�b�N����B
        if (getHomonkaigoTeikyoTime().isEnabled()&& getHomonkaigoTeikyoTime().isSelected()) {
            // (�I��ԍ�+1)�~30��Ԃ��B
            addMinute+= (getHomonkaigoTeikyoTime().getSelectedIndex() + 1) * 30;
        }
        if (getHoumonKaigoInTime().isEnabled()&& getHoumonKaigoInTime().isSelected()) {
            // (�I��ԍ�+1)�~30��Ԃ��B
            addMinute+= (getHoumonKaigoInTime().getSelectedIndex() + 1) * 30;
        }
        return addMinute;
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
            // ���W�J
            Object obj;
            // ���莖�Ə��̐��̒l��ݒ肷��B
            obj = VRBindPathParser.get("1110101", provider);
            if (obj != null) {
                VRBindPathParser.set("1110109", defaultMap, obj);
            }
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
        }
        // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if (!getHoumonKaigoServicePattern().isSelected()) {
            // �K���ʂ����I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }

        if (getHoumonKaigoServicePattern().getSelectedIndex() != 3) {
            // �K���ʂ��ʉ@��~�����ȊO�̏ꍇ
            switch (getHoumonKaigoServicePattern().getSelectedIndex()) {
            case 0:
                // �K���ʂ��g�̉��̏ꍇ
                if (!getHomonkaigoTeikyoTime().isSelected()) {
                    // �񋟎��Ԃ����I���̏ꍇ
                    // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // null��Ԃ��B
                    return null;
                }
                break;
            case 1:
                // �K���ʂ����������̏ꍇ
                if (!getHoumonKaigoInTime().isSelected()) {
                    // �񋟎��Ԃ����I���̏ꍇ
                    // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // null��Ԃ��B
                    return null;
                }
//                if (getHoumonKaigoInTime().getSelectedIndex() < 1) {
//                    // �񋟎��ԃR���{(homonkaigoTeikyoTime)��30�������̏ꍇ
//                    // ���������̒񋟎��Ԃ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_LIFE_ASSIST_TIME
//                    QkanMessageList.getInstance()
//                            .QS001_ERROR_OF_LIFE_ASSIST_TIME();
//                    getHoumonKaigoInTime().setSelectedIndex(1);
//                    // null��Ԃ��B
//                    return null;
//                }
                break;
            case 2:
                // �K���ʂ��g�̐����̏ꍇ
                if ((!getHomonkaigoTeikyoTime().isSelected())||(!getHoumonKaigoInTime().isSelected())) {
                    // �񋟎��Ԃ����I���̏ꍇ
                    // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                    // null��Ԃ��B
                    return null;
                }
                break;
            }

        }

        if (ACTextUtilities.isNullText(getHoumonKaigoBeginTime().getText())
                || ACTextUtilities
                        .isNullText(getHoumonKaigoEndTime().getText())
                || (!getHoumonKaigoBeginTime().isValidDate())
                || (!getHoumonKaigoEndTime().isValidDate())) {
            // �J�n�����R���{(houmonKaigoBeginTime)�ƏI�������R���{(houmonKaigoEndTime)�̂����ꂩ���󗓂������͕s���̏ꍇ
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
        return getHoumonKaigoBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getHoumonKaigoEndTime();
    }

    /**
     * �K��Ō�̋��E�𐧌䂷��
     */
    protected void specificProviderAddRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        //���莖�Ə����Z���T�^�E�U�^���I�����ꂽ�ꍇ
       if(getSpecificProviderAddRadioItem2().isSelected()||getSpecificProviderAddRadioItem3().isSelected()){
           //���E�O���[�v�𖳌��ɂ���
           setState_INVALID_KYUSYOKU();
       }else{
           //���E�O���[�v��L���ɂ���
           setState_VALID_KYUSYOKU();
       }
    }

    /**
     * �R���{���ݒ�
     */
    public void checkComboItem() throws Exception {
        //���ݒ�
        VRMap comboItemMap = new VRHashMap();
        //�T�[�r�X�R���{�̒l���`�F�b�N����B
        if(getHoumonKaigoServicePattern().getSelectedIndex() == 1){
            //�l��2�i���������j�������ꍇ
            //�R�[�h�}�X�^�f�[�^���CODE_ID�F269�i�񋟎��ԁE���������j���擾����B
            //�擾�����l���AcomboItemMap�� KEY : 1110105 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1110104", QkanCommon.getArrayFromMasterCode(269,
            "1110105"));
        }else{
            //�l��2�ȊO�i�g�̉��A�g�̐����j�������ꍇ
            //�R�[�h�}�X�^�f�[�^���CODE_ID�F26�i�񋟎��ԁE�g�̉��j���擾����B
            //�擾�����l���AcomboItemMap�� KEY : 1110105 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1110104", QkanCommon.getArrayFromMasterCode(26,
            "1110105"));
        }
        //���W�J
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();
        
    }

    /**
     * �f�[�^�o�C���h���̏���
     */
    public void binded() throws Exception {
        // �\�h�Ή���(�v�]�Ή�)
        // �T�[�r�X�敪�����������������ꍇ
        if (getHoumonKaigoServicePattern().getSelectedIndex()==1){
            // �\�[�X���擾
            VRBindSource src = getHoumonKaigoInTime().getSource();
            if(src != null){
                // ���������R���{�̒l���`�F�b�N����B
                // �v�]�Ή��O�̃f�[�^�������ꍇ
                if(ACCastUtilities.toInt(src.getData("1110105")) >= 3){
                    getHoumonKaigoInTime().setSelectedIndex(1);
                }
            }
        }
    }
}
