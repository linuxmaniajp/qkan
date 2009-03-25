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
 * �v���O���� �T�[�r�X�p�^�[���K��Ō�i���) (QS001103_H2104)
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
 * �T�[�r�X�p�^�[���K��Ō�i���)(QS001103_H2104)
 */
public class QS001103_H2104 extends QS001103_H2104Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001103_H2104() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�E���敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoClassSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // �E���敪�I��
        // �E���敪��PT�EOT�EST���I������Ă����ꍇ
        if (getHoumonKangoKaigoClass().getSelectedIndex() == 3) {
            // ���ԋ敪�́u20�������v�Ɓu1���Ԉȏ�A���Ԕ������v�𖳌��ɂ���B
            setState_HOUMONKANGO_KAIGOTIME_ENABLE_FALSE();
        } else {
            // ���ԋ敪��S�ėL���ɂ���B
            setState_HOUMONKANGO_KAIGOTIME_ENABLE_TRUE();
        }
        //��ʏ�Ԑ��䏈�����Ăяo���B
        checkState();

    }

    /**
     * �u���ԋ敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoTimeSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ���ԋ敪�I��
        //�I�����Ԍv�Z�������Ăяo���B
        checkEndTime();
        //��ʏ�Ԑ��䏈�����Ăяo���B
        checkState();

    }

    /**
     * �u�J�n���ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoBeginTimeActionPerformed(ActionEvent e)
            throws Exception {
        // �J�n���ԕύX
        //�I�����Ԍv�Z�������Ăяo���B
        checkEndTime();

    }

    /**
     * �u���ԑѕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoTimeZoneSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ���ԑѕύX
        //�I�����Ԍv�Z�������Ăяo���B
        checkEndTime();

    }

    /**
     * �u�{�݋敪�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoFacilityTypeSelectionChanged(
            ListSelectionEvent e) throws Exception {
        // �{�݋敪�ύX
        // ��Ë@�ւ��I������Ă����ꍇ
        if (getHoumonKangoKaigoMedicalInstitution().isSelected()) {
            //�uINVALID_HOMON_KANGO_PTOT�v��Ԃɂ���B
            setState_INVALID_HOMON_KANGO_PTOT();
        } else {
            //��L�ȊO�̏ꍇ
            //�uVALID_HOMON_KANGO_PTOT�v��Ԃɂ���B
            setState_VALID_HOMON_KANGO_PTOT();
        }

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001103_H2104.class.getName(),
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
        // �����I��
        getHoumonKangoKaigoTime().setSelectedIndex(3);

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
            Object obj;
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = new VRHashMap();
            // ���ݒ�
            // �T�[�r�X�񋟑̐��������Z
            obj = VRBindPathParser.get("1130108", provider);
            if (obj != null) {
                VRBindPathParser.set("1130113", defaultMap, obj);
            }
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // �K��Ō�{�ݎ��
            obj = VRBindPathParser.get("1130101", provider);
            if (obj != null) {
                getHoumonKangoKaigoFacilityType().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // �ً}���K��Ō���Z
            obj = VRBindPathParser.get("1130104", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 1) {
                    // �Ȃ�
                    setState_INVALID_URGENT_TIME_RADIO();
                } else {
                    // ����
                    setState_VALID_URGENT_TIME_RADIO();
                }
            }
            // ���ʊǗ��̐�
            obj = VRBindPathParser.get("1130102", provider);
            if (obj != null) {
                if (ACCastUtilities.toInt(obj) == 1) {
                    // �Ȃ�
                    setState_INVALID_SPECIAL_MANAGE_RADIO();
                } else {
                    // ����
                    setState_VALID_SPECIAL_MANAGE_RADIO();
                }
            }
            
            // ��ʏ�Ԑ���
            checkState();

        }
    }

    /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if (ACTextUtilities
                .isNullText(getHoumonKangoKaigoBeginTime().getText())
                || ACTextUtilities.isNullText(getHoumonKangoKaigoEndTime()
                        .getText())
                || (!getHoumonKangoKaigoBeginTime().isValidDate())
                || (!getHoumonKangoKaigoEndTime().isValidDate())) {
            // �J�n�����R���{(houmonKangoKaigoBeginTime)�ƏI�������R���{(houmonKangoKaigoEndTime)�̂����ꂩ���󗓂��s���̏ꍇ
            // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
            // null��Ԃ��B
            return null;
        }
        if((!getHoumonKangoKaigoTime().isSelected())||
                (!getHoumonKangoKaigoTime().getSelectedButton().isEnabled())){
            //���ԋ敪�̗L���ȍ��ڂ��I������Ă��Ȃ��ꍇ
            //���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        //���ԑы敪�ɕs�����������ꍇ
        if(!getHoumonKangoKaigoTimeZone().getSelectedButton().isEnabled()){
            //���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;            
        }
        
        //�E���敪�ɕs�����������ꍇ
        if(!getHoumonKangoKaigoClass().getSelectedButton().isEnabled()){
            //���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
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
        return getHoumonKangoKaigoBeginTime();
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getHoumonKangoKaigoEndTime();
    }

    /**
     * �u�I�����Ԃ̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkEndTime() throws Exception {
        // ���J�n���ԕύX���A�I�����Ԃ��ύX
        if (getHoumonKangoKaigoBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getHoumonKangoKaigoBeginTime()
                        .getText()))) {
            // �J�n���ԃR���{(houmonKangoKaigoBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
            // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
            int kaigoTime = getKaigoTime();

            // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
            getHoumonKangoKaigoEndTime().setDate(
                    ACDateUtilities.addMinute(getHoumonKangoKaigoBeginTime()
                            .getDate(), kaigoTime));
        }
        
    }
    
    /**
     * �u�K��Ō쎞�Ԃ̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public int getKaigoTime() throws Exception {
        // ���K��Ō쎞�ԋ敪���A���Ԃ��擾
        // �u�K��Ō쎞�ԋ敪(houmonKangoKaigoTime)�v�̒l���`�F�b�N����B
        switch (getHoumonKangoKaigoTime().getSelectedIndex()) {
        case 1: //20������
            return 20;
        case 2: // 30�������̏ꍇ
            // �߂�l�Ƃ���30��Ԃ��B
            return 30;
        case 3:
            // 30���ȏ�A1���Ԗ����̏ꍇ
            // �߂�l�Ƃ���60��Ԃ��B
            return 60;
        case 4:
            // 1���Ԉȏ�A1���Ԕ������̏ꍇ
            // �߂�l�Ƃ���90��Ԃ��B
            return 90;
        }
        return 0;
    }
    
    /**
     * ���ԑы敪�Ɋւ��鐧����s���܂��B
     * 
     * @throws Exception
     */
    public void changeState() throws Exception {
        //���w�Ö@�m���I������Ă��Ȃ����`�F�b�N����
        if(!getHoumonKangoKaigoClass3().isSelected()){
            //20���������I������Ă����ꍇ
            if(getHoumonKangoKaigoTime4().isSelected()){
                setState_TIME_UNDER20_ENABLE_FALSE();
            }else{
                setState_TIME_UNDER20_ENABLE_TRUE();
            }
        }else{
            setState_TIME_UNDER20_ENABLE_TRUE();
        }
        //���ԋ敪��ύX����
        checkEndTime();
        
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
        // ���T�[�r�X�A��
        if (getHoumonKangoKaigoTime().isEnabled()
                && getHoumonKangoKaigoTime().getSelectedIndex() == 4
                && getHoumonKangoKaigoTime().getButton(4).isEnabled()
                && getHoumonKangoKaigoSpecialManageRadio().isEnabled()
                && getHoumonKangoKaigoSpecialManageRadio().getSelectedIndex() == 2) {
            // ���ԋ敪���u1���Ԉȏ�A1���Ԕ������v�ŁA�����ʊǗ����Z���L�����u����v�̏ꍇ
            // �u�����ԖK��Ō���Z�E�L���v��Ԃɂ���B(VALID_LONG_TIME)
            setState_VALID_LONG_TIME();
        } else {
            // ��L�ȊO�̏ꍇ
            // �u�����ԖK��Ō���Z�E�����v��Ԃɂ���B(INVALID_LONG_TIME)
            setState_INVALID_LONG_TIME();
        }
        // ���Ԃ̏�Ԑ���
        changeState();
    }

    /**
     * �u���ʊǗ����Z�I���v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoSpecialManageRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        // ���ʊǗ����Z�ύX
        //��ʏ�Ԑ��䏈�����Ăяo���B
        checkState();
        
    }

}
