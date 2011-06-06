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
 * �J����: ��i�@�a�P
 * �쐬��: 2006/02/18  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ��^���ҏW (008)
 * �v���O���� ��^���ҏW (QO008)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo008;

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

import com.lowagie.text.Table;
import com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator;

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
 * ��^���ҏW(QO008)
 */
public class QO008 extends QO008Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QO008() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * �������������s�Ȃ��܂��B
     * 
     * @param affair �Ɩ����
     * @throws Exception ������O
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        // ��ʏ��������s���B
        initialize();

        // �f�[�^���������A��ʂɓW�J����B
        doFind();
        
        //������
        setDataChangeFlag(0);

    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }

        // �Ō�ɕۑ�����Ă���ύX����Ă���ꍇ�idataChangeFlag == 1�j
        if (getDataChangeFlag() == 1) {
            // �m�F���b�Z�[�W��\������B
            // �E���b�Z�[�WID�FWARNING_OF_UPDATE_ON_MODIFIED
            int msgID = QkanMessageList.getInstance()
                    .WARNING_OF_UPDATE_ON_MODIFIED();
            // �u�͂��v��I�������ꍇ
            switch (msgID) {
            case ACMessageBox.RESULT_YES:
                // �ۑ��������s���B
                if (!doSave()) {
                    // �ۑ�����������I�����Ȃ������ꍇ
                    // �����𒆒f����B(�I��)
                    return false;

                }
                return true;
                
            //�������I����
            case ACMessageBox.RESULT_NO:
                //�O��ʂɑJ�ڂ���
                return true;
                
            //�L�����Z���I����
            case ACMessageBox.RESULT_CANCEL:
                // �����𒆒f����i�������Ȃ��j�B
                return false;

            }

        }

        // �uQM002 ���C�����j���[�v��ʂɑJ�ڂ���B
        return true;
    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        
        // �Ō�ɕۑ�����Ă���ύX����Ă��邩�ǂ����`�F�b�N����B
        if (getDataChangeFlag() == 1) {
            // �Ō�ɕۑ�����Ă���ύX����Ă���ꍇ�idataChangeFlag == 1�j
            // �I���m�F���b�Z�[�W��\������B
            int msgID = QkanMessageList.getInstance()
                    .WARNING_OF_CLOSE_ON_MODIFIED();
            // �E���b�Z�[�WID�FWARNING_OF_CLOSE_ON_MODIFIED
            if (msgID == ACMessageBox.RESULT_OK) {
                // �u�͂��v�I���ȊO�̏ꍇ
                return true;
            } else {
                return false;
            }
            // �����𒆒f����i�������Ȃ��j�B
            // �V�X�e�����I������B
        }
        
        return true;
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�X�V�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {
        int fixedRow = -1;
        int fixedItemRow = -1;
        // ���ڃe�[�u���̃��R�[�h���I������Ă����ꍇ
        if (getFixedFormTable().getSelectedModelRow() != -1) {
            // �I������Ă��郌�R�[�h���擾����B
            fixedRow = getFixedFormTable().getSelectedModelRow();
        }

        // �ڍ׍��ڃe�[�u���̃��R�[�h���I������Ă����ꍇ
        if (getFixedFormEditItemTable().getSelectedModelRow() != -1) {
            // �I������Ă��郌�R�[�h�����擾����B
            fixedItemRow = getFixedFormEditItemTable().getSelectedModelRow();
        }
        // �ۑ��������s���B
        if (!doSave()) {
            // �ۑ�����������I�����Ȃ������ꍇ
            // �����𒆒f����B(�I��)
            return;
        }

        // �ۑ�����������I�������ꍇ
        // �ŐV�̃f�[�^���擾����B
        doFind();

        if (fixedRow != -1) {
            getFixedFormTable().setSelectedModelRow(fixedRow);
        }

        // �ۑ��O�ɑI������Ă����s��I����Ԃɂ���B
        if (fixedItemRow != -1) {
            getFixedFormEditItemTable().setSelectedModelRow(fixedItemRow);

        }

        // ���������ʒm���b�Z�[�W��\������B
        QkanMessageList.getInstance().UPDATE_SUCCESSED();
        // �E���b�Z�[�WID�FUPDATE_SUCCESSED

        // dataChangeFlag��0��������B
        setDataChangeFlag(0);
    }

    /**
     * �u�\���f�[�^�؂�ւ������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void fixedFormTableSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // VRList list�𐶐�����B
        VRList list = new VRArrayList();
        // �I������Ă��Ȃ��ꍇ
        if (getFixedFormTable().getSelectedModelRow() == -1) {
            // fixedFormTableModel��list��ݒ肷��B
//            getFixedFormTableModel().setAdaptee(list);

            // ��ʂ̏�Ԃ�ݒ肷��B
            // �E���ID�FUNEDITABLE
            setState_UNEDITABLE();
        } else {
            // �I������Ă���ꍇ
            // �I�����R�[�h���FIXED_FORM_ID���擾���AfixedFormId�Ɋi�[����B

            VRMap map = (VRMap) getFixedFormTable().getSelectedModelRowValue();
            setFixedFormId(ACCastUtilities.toInt(map.getData("FIXED_FORM_ID")));
            setTableType(ACCastUtilities.toInt(map.getData("TABLE_TYPE")));
            
            //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
            setSelectedKey(getTableType()+"-"+getFixedFormId());
            //[ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�
            
            // ���ݑI�𒆂̕��ނɕR�Â��ڍ׍��ڌQ���擾����B
            if (getListGroupMap() != null) {
            	//[ID:0000612][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
                //list = (VRList) getListGroupMap().getData(getTableType()+"-"+getFixedFormId());
            	list = (VRList) getListGroupMap().getData(getSelectedKey());
                //[ID:0000612][Shin Fujihara] 2010/11 edit end 2010�N�x�Ή�
            }
            // fixedFormTableModel��list��ݒ肷��B
            if(list.size() >= 0){
                getFixedFormTableModel().setAdaptee(list);
            }
            
            //[ID:0000612][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
            /*
            // ��ʂ̏�Ԃ�ݒ肷��B
            setState_EDITABLE();
            // �E���ID�FEDITABLE
            // list�̌�����0���̏ꍇ
            if (list.size() <= 0) {
                // �{�^���̏�Ԑݒ���s���B
                // �E���ID�FITEM_UNSELECTED
            	setState_ITEM_UNSELECTED();
            } else {
                // list�̌�����1���ȏ�̏ꍇ
                // fixedFormEditItemTable��1�s�ڂ�I��������Ԃɐݒ肷��B
            	getFixedFormEditItemTable().setSelectedSortedFirstRow();
            }
            */
            
            // ��ʂ̏�Ԃ�ݒ肷��B
            // list�̌�����0���̏ꍇ
            if (list.size() <= 0) {
            	if (PRINT_PROVIDER.equals(getSelectedKey())) {
            		setState_UNEDITABLE();
            	} else {
            		setState_ITEM_UNSELECTED();
            	}
            	
            } else {
                // list�̌�����1���ȏ�̏ꍇ
                // fixedFormEditItemTable��1�s�ڂ�I��������Ԃɐݒ肷��B
            	getFixedFormEditItemTable().setSelectedSortedFirstRow();
            	
            	if (PRINT_PROVIDER.equals(getSelectedKey())) {
            		setState_ITEM_SELECTED_PROVIDER();
            	} else {
            		setState_EDITABLE();
            	}
            }
            //[ID:0000612][Shin Fujihara] 2010/11 edit end 2010�N�x�Ή�
        }
    }

    /**
     * �u��^���\�������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void fixedFormEditItemTableSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // VRMap map�𐶐�����B
        VRMap map = new VRHashMap();
        // �I������Ă��Ȃ��ꍇ
        if (getFixedFormEditItemTable().getSelectedModelRow() == -1) {
            // �{�^���̏�Ԑݒ���s���B
        	//[ID:0000612][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
        	if (PRINT_PROVIDER.equals(getSelectedKey())) {
        		setState_UNEDITABLE();
        	} else {
        		setState_ITEM_UNSELECTED();
        	}
            //[ID:0000612][Shin Fujihara] 2010/11 edit end 2010�N�x�Ή�
            // �E���ID�FITEM_UNSELECTED
            // �u���́E�ҏW�e�L�X�g�{�b�N�X�̈�ifixedFormEditInputCaptions�j�v�̃\�[�X�𐶐����Amap�Ɋi�[����B
            map = (VRMap) getFixedFormEditInputCaptions().createSource();
        } else {
            // �I������Ă���ꍇ
            // �{�^���̏�Ԑݒ���s���B
        	//[ID:0000612][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
        	if (PRINT_PROVIDER.equals(getSelectedKey())) {
        		setState_ITEM_SELECTED_PROVIDER();
        	} else {
        		setState_ITEM_SELECTED();
        	}
            //[ID:0000612][Shin Fujihara] 2010/11 edit end 2010�N�x�Ή�
            // �E���ID�FITEM_SELECTED
            // �I�����R�[�h��map�Ɋi�[����B
            map = (VRMap) getFixedFormEditItemTable()
                    .getSelectedModelRowValue();

        }
        
        // map���u���́E�ҏW�e�L�X�g�{�b�N�X�̈�ifixedFormEditInputCaptions�j�v�̃\�[�X�Ƃ��Đݒ肷��B
        getFixedFormEditInputCaptions().setSource(map);

        // ��ʂɓW�J����B
        getFixedFormEditInputCaptions().bindSource();

    }

    /**
     * �u��^���ǉ������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void fixedFormEditInsertActionPerformed(ActionEvent e)
            throws Exception {
        // ���̓`�F�b�N���s���B
        if (!isValidInput()) {
            // ���̓`�F�b�N�̖߂�l��false�̏ꍇ
            // �����𒆒f����B(�I��)
            return;
        }
        // VRMap map�𐶐�����B
        VRMap map = new VRLinkedHashMap();
        // map���u���́E�ҏW�e�L�X�g�{�b�N�X�̈�ifixedFormEditInputCaptions�j�v�̃\�[�X�Ƃ��Đݒ肷��B
        getFixedFormEditInputCaptions().setSource(map);
        // map�Ɂu���́E�ҏW�e�L�X�g�{�b�N�X�̈�ifixedFormEditInputCaptions�j�v�̒l�𗬂����ށB
        getFixedFormEditInputCaptions().applySource();
        // VRList list�𐶐�����B
        VRList list = new VRArrayList();
        // fixedFormTableModel�ɐݒ肳��Ă��郌�R�[�h�W����VRList list�Ɋi�[����B
        list = (VRList) getListGroupMap().getData(getTableType()+"-"
                +getFixedFormId());
        
        
        // �ǉ��\�ȃf�[�^���ǂ����`�F�b�N����B
        for (int i = 0; i < list.size(); i++) {
            VRMap checkMap = (VRMap) list.getData(i);
            // �ǉ����ڂƈ�v�����ꍇ
            if (map.getData("CONTENT").equals(checkMap.getData("CONTENT"))) {
                QkanMessageList.getInstance().QO008_ERROR_OF_OVERLAP("���e");
                return;
            }
        }
        
        int maxSort = 0;
        
        // map�Ɉȉ���KEY/VALUE��ݒ肷��B
        // KEY�FSQL_MODE VALUE�FSQL_MODE_INSERT
        // KEY�FTABLE_TYPE VALUE�FTABLE_TYPE_FIXED_FORM
        // KEY�FFIXED_FORM_ID VALUE�FfixedFormId
        // KEY�FCONTENT_SORT VALUE�FmaxSort + 1
        map.setData("SQL_MODE", new Integer(String.valueOf(SQL_MODE_INSERT)));
        map.setData("TABLE_TYPE", new Integer(getTableType()));
        map.setData("FIXED_FORM_ID", new Integer(getFixedFormId()));
        map.setData("CONTENT_SORT", new Integer(0));
        // map��list�ɒǉ�����B
        list.add(map);
        // fixedFormTableModel��list��ݒ肷��B
        getFixedFormTableModel().setAdaptee(list);
        // �ǉ������s��I��������Ԃɐݒ肷��B
        getFixedFormEditItemTable().setSelectedSortedLastRow();
        // �{�^���̏�Ԑݒ���s���B
        setState_ITEM_SELECTED();
        // �E���ID�FITEM_SELECTED
        // dataChangeFlag��1��������B
        setDataChangeFlag(1);

    }

    /**
     * �u��^���X�V�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void fixedFormEditUpdateActionPerformed(ActionEvent e)
            throws Exception {
        // ���̓`�F�b�N���s���B
        if (!isValidInput()) {
            // ���̓`�F�b�N�̖߂�l��false�̏ꍇ
            // �������I������B
            return;
        }

        VRMap applyMap = new VRHashMap();
        // �u���́E�ҏW�e�L�X�g�{�b�N�X�̈�ifixedFormEditInputCaptions�j�v�̃\�[�X���擾����B
        getFixedFormEditInputCaptions().setSource(applyMap);
        getFixedFormEditInputCaptions().applySource();
        // �I���s�̃��R�[�h�Ɉȉ���KEY/VALUE��ݒ肷��B
        VRMap map = (VRMap) getFixedFormEditItemTable()
                .getSelectedModelRowValue();
        // �I���s���R�[�h��SQL_MODE�̒l��SQL_MODE_INSERT�̏ꍇ
        if (new Integer(SQL_MODE_INSERT).equals(map.getData("SQL_MODE"))) {
            // KEY�FSQL_MODE VALUE�FSQL_MODE_INSERT_TO_UPDATE
            map.setData("SQL_MODE", new Integer(SQL_MODE_INSERT_TO_UPDATE));
            // �V�K�{�X�V���[�h�ȊO�������ꍇ
        } else if (!new Integer(SQL_MODE_INSERT_TO_UPDATE).equals(map
                .getData("SQL_MODE"))) {            
            // KEY�FSQL_MODE VALUE�FSQL_MODE_UPDATE
            map.setData("SQL_MODE", new Integer(SQL_MODE_UPDATE));
        }
        
        map.putAll(applyMap);
        // dataChangeFlag��1��������B
        setDataChangeFlag(1);
        // �ĕ`�揈��
        getFixedFormEditItemTable().revalidate();
        getFixedFormEditItemTable().repaint();

    }

    /**
     * �u��^���폜�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void fixedFormEditDeleteActionPerformed(ActionEvent e)
            throws Exception {
        if(getFixedFormEditItemTable().getSelectedModelRow()==-1){
            return;
        }
        
        // �I���s�̃��R�[�h��SQL_MODE�̒l�ɂ���ĕ��򂷂�B
        VRMap map = (VRMap) getFixedFormEditItemTable()
                .getSelectedModelRowValue();
        // SQL_MODE�̒l�������Ȃ��ꍇ
        if (!VRBindPathParser.has("SQL_MODE", map)) {
            // �I���s�̃��R�[�h�Ɉȉ���KEY/VALUE��ݒ肷��B
            // KEY�FSQL_MODE VALUE�FSQL_MODE_DELETE
            map.setData("SQL_MODE", new Integer(SQL_MODE_DELETE));
            // SQL_MODE_DEFAULT�̏ꍇ
            // �I���s�̃��R�[�h�Ɉȉ���KEY/VALUE��ݒ肷��B
            // KEY�FSQL_MODE VALUE�FSQL_MODE_DELETE
        } else {
            if (!new Integer(SQL_MODE_DELETE).equals(map.getData("SQL_MODE"))) {
                // ���ݏ������̍��ڃ��X�g���擾
                //// 2008/01/07 [Masahiko_Higuchi] edit - begin version 5.3.8 �Ή��R��G���[�Ή�
                VRList list = (VRList) getListGroupMap().getData(getTableType() + "-" + getFixedFormId());
                //// 2008/01/07 [Masahiko_Higuchi] edit - end
                // SQL_MODE_INSERT��������SQL_MODE_INSERT_TO_UPDATE�̏ꍇ;
                if (new Integer(SQL_MODE_INSERT)
                        .equals(map.getData("SQL_MODE"))
                        || new Integer(SQL_MODE_INSERT_TO_UPDATE).equals(map
                                .getData("SQL_MODE"))) {
                    int selectRow = getFixedFormEditItemTable()
                            .getSelectedModelRow();
                    // �I���s���폜����B
                    list.remove(selectRow);
                    // �폜��ɗ��z�Ƃ��郌�R�[�h��I����Ԃɂ���
                    getFixedFormEditItemTable()
                            .setSelectedSortedRowOnAfterDelete(selectRow);

                    //SQL_MODE��SQL_MODE_UPDATE�������ꍇ
                } else if (new Integer(SQL_MODE_UPDATE).equals(map
                        .getData("SQL_MODE"))) {
                    // KEY�FSQL_MODE VALUE�FSQL_MODE_UPDATE_TO_DELETE
                    map.setData("SQL_MODE", new Integer(
                            SQL_MODE_UPDATE_TO_DELETE));
                    // SQL_MODE_UPDATE_TO_DELETE�ȊO�������ꍇ
                } else if(!new Integer(SQL_MODE_UPDATE_TO_DELETE).equals(map.getData("SQL_MODE"))){
                    map.setData("SQL_MODE", new Integer(SQL_MODE_DELETE));
                }

            }
            // SQL_MODE_DELETE�̏ꍇ
            // �������I������B
        }
        // �ĕ`�揈��
        getFixedFormEditItemTable().revalidate();
        getFixedFormEditItemTable().repaint();
        // dataChangeFlag��1��������B
        setDataChangeFlag(1);

    }

    /**
     * �u��^���폜��������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void fixedFormEditCancelDeleteActionPerformed(ActionEvent e)
            throws Exception {
        VRMap map = (VRMap) getFixedFormEditItemTable()
                .getSelectedModelRowValue();
        // �I���s�̃��R�[�h��SQL_MODE�̒l�ɂ���ĕ��򂷂�B
        // SQL_MODE_UPDATE_TO_DELETE�̏ꍇ
        if (new Integer(SQL_MODE_UPDATE_TO_DELETE).equals(map
                .getData("SQL_MODE"))) {
            // �I���s�̃��R�[�h�Ɉȉ���KEY/VALUE��ݒ肷��B
            // KEY�FSQL_MODE VALUE�FSQL_MODE_UPDATE
            map.setData("SQL_MODE", new Integer(SQL_MODE_UPDATE));
        } else if (new Integer(SQL_MODE_DELETE).equals(map.getData("SQL_MODE"))) {
            // SQL_MODE_DELETE�̏ꍇ
            // �I���s�̃��R�[�h�Ɉȉ���KEY/VALUE��ݒ肷��B
            map.setData("SQL_MODE", new Integer(SQL_MODE_DEFAULT));
            // KEY�FSQL_MODE VALUE�FSQL_MODE_DEFAULT
        }
        // ��L�ȊO�̏ꍇ
        // �������I������B
        // �ĕ`�揈��
        getFixedFormEditItemTable().revalidate();
        getFixedFormEditItemTable().repaint();

    }

    /**
     * �u���ԌJ��グ�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void fixedFormEditItemManipulateButtonUpActionPerformed(
            ActionEvent e) throws Exception {
        // �I���s���e�[�u����1�s�ڂłȂ��ꍇ
        if (getFixedFormEditItemTable().getSelectedRow() <= 0) {
            return;
        }
        // �R�s�[�Ɏg�p����Map
        VRMap cloneMap = new VRHashMap();
        
        VRMap map = (VRMap) getFixedFormEditItemTable()
                .getSelectedModelRowValue();
        //���ݑI�𒆂̕��ނɕR�Â����ڂ��擾
        VRList list = (VRList) getListGroupMap().getData(getTableType()+"-"
                +getFixedFormId());
        //�I���s�̂P��̃��R�[�h���擾����B
        VRMap upRowMap = (VRMap) list.getData(getFixedFormEditItemTable()
                .getSelectedModelRow() - 1);
        
        // �I���s�̃��R�[�h���R�s�[����B
        cloneMap = (VRMap) map.clone();
        // �I���s�̃��R�[�h��I���s��1��̃��R�[�h�ŏ㏑������B
        map.putAll(upRowMap);
        // �I���s��1��̃��R�[�h��I���s�̃��R�[�h�ŏ㏑������B
        upRowMap.putAll(cloneMap);
        // ��ʂ��ĕ`�悷��B
        getFixedFormEditItemTable().revalidate();
        getFixedFormEditItemTable().repaint();

        // �J��グ�����R�[�h��I����Ԃɂ���
        getFixedFormEditItemTable().setSelectedModelRow(
                getFixedFormEditItemTable().getSelectedModelRow() - 1);
        
        //dataChangeflg��1�ݒ肷��
        setDataChangeFlag(1);

    }

    /**
     * �u���ԌJ�艺�������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void fixedFormEditItemManipulateButtonDownActionPerformed(
            ActionEvent e) throws Exception {
        // �I���s���e�[�u���̍ŏI�s�łȂ��ꍇ
        VRList list = (VRList) getListGroupMap().getData(getTableType()+"-"
                +getFixedFormId());
        if (getFixedFormEditItemTable().getSelectedModelRow() >= list.size() - 1) {
            return;
        }
        
        VRMap cloneMap = new VRHashMap();
        //�I���s�̃��R�[�h���擾����
        VRMap map = (VRMap) getFixedFormEditItemTable()
                .getSelectedModelRowValue();

        // �I���s��1�����̃��R�[�h���擾����B
        VRMap downRowMap = (VRMap) list.getData(getFixedFormEditItemTable()
                .getSelectedModelRow() + 1);

        // �I���s�̃��R�[�h���R�s�[����B
        cloneMap = (VRMap) map.clone();
        // �I���s�̃��R�[�h��I���s��1���̃��R�[�h�ŏ㏑������B
        map.putAll(downRowMap);
        // �I���s��1���̃��R�[�h��I���s�̃��R�[�h�ŏ㏑������B
        downRowMap.putAll(cloneMap);
        
        getFixedFormEditItemTable().revalidate();
        getFixedFormEditItemTable().repaint();
        
        //�J�艺�������R�[�h��I����Ԃɂ���B
        getFixedFormEditItemTable().setSelectedModelRow(
                getFixedFormEditItemTable().getSelectedModelRow() + 1);
        
        //dataChangeflg��1�ݒ肷��
        setDataChangeFlag(1);
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        QkanSystemInformation.getInstance().setLoginProviderID("0000000001");
        ACFrame.debugStart(new ACAffairInfo(QO008.class.getName(), param));
    }

    // �����֐�

    /**
     * �u��ʏ������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // ����ʏ���������
        // ���E�B���h�E�^�C�g���E�Ɩ��{�^���o�[�̐ݒ�
        // �E�B���h�E�^�C�g���E�Ɩ��{�^���o�[��ݒ肷��B
        setAffairTitle(AFFAIR_ID, getButtons());

        setPASSIVE_CHECK_KEY(new ACPassiveKey("FIXED_FORM", new String[] {
                "TABLE_TYPE", "FIXED_FORM_ID", "CONTENT_KEY" }, new Format[] { null, null, null },
                "LAST_TIME", "LAST_TIME"));

        // ���e�[�u�����f���̐ݒ�
        // fixedFormGroupTableModel�𐶐�����B
        ACTableModelAdapter fixedFormGroupTableModel = new ACTableModelAdapter();
        // �ȉ��̃J������ݒ肷��B
        // "FIXED_FORM_GROUP" "FIXED_FORM_TITLE"
        fixedFormGroupTableModel.setColumns(new String[] { "FIXED_FORM_GROUP",
                "FIXED_FORM_TITLE" });

        setFixedFormGroupTableModel(fixedFormGroupTableModel);
        // fixedFormTable�ɐݒ肷��B
        getFixedFormTable().setModel(getFixedFormGroupTableModel());
        // fixedFormTableModel�𐶐�����B
        ACTableModelAdapter fixedFormTableModel = new ACTableModelAdapter();
        // �ȉ��̃J������ݒ肷��B
        // "SQL_MODE" "CONTENT"
        //[ID:0000612][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
        //fixedFormTableModel.setColumns(new String[] { "SQL_MODE", "CONTENT" });
        fixedFormTableModel.setColumns(new String[] { "SQL_MODE", "SERVICE_CODE_KIND", "CONTENT" });
        ((QkanServiceKindNameFormat)getFixedFormEditItemTableColumn4().getFormat()).setMasterService(QkanCommon.getMasterService(getDBManager()));
        //[ID:0000612][Shin Fujihara] 2010/11 edit end 2010�N�x�Ή�
        setFixedFormTableModel(fixedFormTableModel);
        // fixedFormEditItemTable�ɐݒ肷��B
        getFixedFormEditItemTable().setModel(getFixedFormTableModel());
        // ����ԏ����ݒ�
        // ��Ԃ�ݒ肷��B
        setState_UNEDITABLE();
        // �E���ID�FUNEDITABLE

    }

    /**
     * �u���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doFind() throws Exception {
        // ��������������щ�ʓW�J
        // ����^�����ޏ��擾
        // SQL���擾�pVRMap sqlParam���`����B
        VRMap sqlParam = new VRHashMap();
        // sqlParam�ɉ��L�̒l��ݒ肷��B
        // KEY�FTABLE_TYPE VALUE�FTABLE_TYPE_FIXED_FORM
        sqlParam.setData("TABLE_TYPE", new Integer(TABLE_TYPE_FIXED_FORM));
        // sqlParam�������Ƃ��āA��^�����ޏ��擾�pSQL�����擾����B
        // �擾����SQL�������s���A��^�����ޏ����擾����B
        VRList list = new VRArrayList();
        
        //��Ìn��\���Ή� fujihara.shin 2009.1.15 edit start
        //list = (VRList) getDBManager().executeQuery(
        //        getSQL_GET_FIXED_FORM_GROUP(sqlParam));
        if (QkanCommon.isShowOldIryo()){
        	list = (VRList) getDBManager().executeQuery(getSQL_GET_FIXED_FORM_GROUP(sqlParam));
        } else {
        	list = (VRList) getDBManager().executeQuery(getSQL_GET_FIXED_FORM_GROUP_WITHOUT_IRYO(sqlParam));
        }
        //��Ìn��\���Ή� fujihara.shin 2009.1.15 edit end
        
        // �擾������^�����ޏ���fixedFormGroupTableModel�ɐݒ肷��B
        // setAdaptee(fixedFormGroupTableModel, �擾�����f�[�^);
        getFixedFormGroupTableModel().setAdaptee(list);

        getFixedFormTable().setModel(getFixedFormGroupTableModel());
        // ����^�����擾
        // ��^�����擾�pSQL�����擾����B
        // �擾����SQL�������s���A��^�������擾���AfixedFormList�Ɋi�[����B
        
        //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
        sqlParam.put("PROVIDER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
        //[ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�
        
        setFixedFormList(getDBManager().executeQuery(
                getSQL_GET_FIXED_FORM(sqlParam)));

        // ��ނ��Ƃɂ܂Ƃ߂�Map�𐶐�����B
        createGroupMap(getFixedFormList());
        
        //��^�����󂾂����ꍇ�̃G���[�g���b�v
        VRMap map = new VRHashMap();
        for(int i=1; i<=2; i++){
            for(int j=1; j<=2; j++){
                String key = i+"-"+j;
                if(getListGroupMap().getData(key) == null){
                    //listGroupMap�Ƀ}�[�W����B
                    map.setData(key,new VRArrayList());
                }
            }
        }
        
        //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
        if(getListGroupMap().getData(PRINT_PROVIDER) == null){
        	map.setData(PRINT_PROVIDER, new VRArrayList());
        }
        //[ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�
        
        getListGroupMap().putAll(map);
//        if(getListGroupMap().getData("1") == null|| getListGroupMap().getData("2") == null){
//            VRList list1 = new VRArrayList();
//            VRList list2 = new VRArrayList();
//            VRMap map = new VRHashMap();
//            //null�̏ꍇ�͏����l��ǉ�����B
//            if(getListGroupMap().getData("1") == null){
//                map.setData("1",list1);
//            }
//            //null�̏ꍇ�͏����l��ǉ�����B
//            if(getListGroupMap().getData("2") == null){
//                map.setData("2",list2);
//            }
//            //listGroupMap�Ƀ}�[�W����B
//            getListGroupMap().putAll(map);
//       }
        
        // fixedFormTable��1�s�ڂ�I��������Ԃɐݒ肷��B
        getFixedFormTable().setSelectedSortedFirstRow();

        // �p�b�V�u�L�[���N���A����B
        getPassiveChecker().clearReservedPassive();
        // fixedFormList���p�b�V�u�L�[�ɓo�^����B
        // reservedPassive(PASSIVE_CHECK_KEY, fixedFormList);
        getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
                getFixedFormList());

        
    }

    /**
     * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean isValidInput() throws Exception {
        // �����̓`�F�b�N
        // ���b�Z�[�W�ɓn��������i�[�pString msgParam�𐶐�����B
        String msgParam = null;
        // �EfixedFormEditInputAndCompileTextBox
        if (ACTextUtilities.isNullText(getFixedFormEditInputAndCompileTextBox()
                .getText())) {
            // �����͂̏ꍇ�i�X�y�[�X�݂̂̓��͂��܂ށj
            // msgParam��"���́E�ҏW��"��������B
            msgParam = "���́E�ҏW��";
            // �G���[���b�Z�[�W��\������B
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
                    msgParam);
            // �E���b�Z�[�WID�FERROR_OF_NEED_CHECK_FOR_INPUT
            // �G���[�����������C���X�^���X�Ƀt�H�[�J�X�𓖂Ă�
            getFixedFormEditInputAndCompileTextBox().requestFocus();
            // �߂�l�Ƃ���false��Ԃ��B
            return false;
        }
        return true;
    }

    /**
     * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean doSave() throws Exception {
        // ���ۑ�����
        // ���p�b�V�u�`�F�b�N
        try {
            // �g�����U�N�V�������J�n����B
            getDBManager().beginTransaction();

            int tempId = 0;
            // �p�b�V�u�^�X�N���N���A����B
            getPassiveChecker().clearPassiveTask();
            // �p�b�V�u�^�X�N��o�^����B
            getPassiveChecker().addPassiveDeleteTask(getPASSIVE_CHECK_KEY());
            // �p�b�V�u�`�F�b�N�����s����B
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                //�e�[�u�����b�N�����̂��߃��[���o�b�N
                getDBManager().rollbackTransaction();
                // �p�b�V�u�G���[������ꍇ
                // �p�b�V�u�G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // �����𒆒f����B
                return false;
            }
            // SQL�����擾���邽�߉��L��KEY/VALUE��ݒ肷��
            // KEY:TABLE_TYPE VALUE:TABLE_TYPE_FIXED_FORM(�萔�j
            VRMap param = new VRHashMap();
            param.setData("TABLE_TYPE", new Integer(TABLE_TYPE_FIXED_FORM));
            // ��^�������폜���邽�߂�SQL�����擾����B
            // �擾����SQL�������s����B
            getDBManager().executeUpdate(getSQL_DELETE_FIXED_FORM(param));

            java.util.Iterator it = getListGroupMap().entrySet().iterator();
            // �L�[�����擾
            Map.Entry key = null;
            // KEY��String�^�Ŋi�[
            String strKey = "";
            // Map����Key�̐������[�v�������s��
            while (it.hasNext()) {
                key = (Map.Entry) it.next();
                // KEY��String�^�Ŋi�[
                strKey = String.valueOf(key.getKey());
                // ���o�������X�g���i�[����ϐ��𐶐�����B
                VRList groupList = new VRArrayList();
                // Map������List���O���[�v���̃��X�g���擾����B
                groupList = (VRList) getListGroupMap().getData(strKey);
                // �J�E���^�[
                int fixedFormIdInsertCount1 = 0;
                int fixedFormIdInsertCount2 = 0;
                // ���o�������X�g�̌��������[�v�������s��
                for (int j = 0; j < groupList.size(); j++) {
                    VRMap map = (VRMap) groupList.getData(j);
                    
                    //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
                    String groupKey = String.valueOf(map.get("TABLE_TYPE")) + "-" +  String.valueOf(map.get("FIXED_FORM_ID"));
                    if (PRINT_PROVIDER.equals(groupKey)) {
                    	updatePrintProviderName(map);
                    	continue;
                    }
                    //[ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�
                    
                    // �폜�ΏۂɎw�肳��Ă��郌�R�[�h�f�[�^���`�F�b�N����B
                    // �폜�Ώۂ̃��R�[�h�ł͂Ȃ������ꍇ
                    if (!new Integer(SQL_MODE_DELETE).equals(map
                            .getData("SQL_MODE"))
                            && !new Integer(SQL_MODE_UPDATE_TO_DELETE)
                                    .equals(map.getData("SQL_MODE"))) {
                        // �S�z���ȕ��S���̃f�[�^�������ꍇ
                        if (new Integer(1).equals(map.getData("FIXED_FORM_ID"))) {
                            // �A�Ԃ�U��
                            map.setData("CONTENT_KEY", new Integer(
                                    fixedFormIdInsertCount1));
                            map.setData("CONTENT_SORT", new Integer(
                                    fixedFormIdInsertCount1));
                            // �J�E���^�[���{�P
                            fixedFormIdInsertCount1++;

                            // ���̑���ڂ̃f�[�^�������ꍇ
                        } else {
                            // �A�Ԃ�U��
                            map.setData("CONTENT_KEY", new Integer(
                                    fixedFormIdInsertCount2));
                            map.setData("CONTENT_SORT", new Integer(
                                    fixedFormIdInsertCount2));
                            // �J�E���^�[���{�P
                            fixedFormIdInsertCount2++;
                        }

                        // DB�ɓo�^����
                        getDBManager().executeUpdate(
                                getSQL_INSERT_FIXED_FORM(map));

                    }

                }
            }

            // ���R�~�b�g/���[���o�b�N
            // ��L��SQL�������ɃG���[���Ȃ������ꍇ
            // �������R�~�b�g����B
            getDBManager().commitTransaction();
            return true;
        } catch (Exception ex) {
            // ��L��SQL�������ɃG���[���������ꍇ
            ex.printStackTrace();
            // ���������[���o�b�N����B
            getDBManager().rollbackTransaction();
            // ��O�𓊂���B
            throw ex;
            // �������I������B
        }

    }
    
    //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
    //���Ə����̍X�V����
    private void updatePrintProviderName(VRMap map) throws Exception {
    	
    	switch (ACCastUtilities.toInt(map.getData("SQL_MODE"), Integer.MAX_VALUE)) {
    	case SQL_MODE_UPDATE:
    		getDBManager().executeUpdate(getSQL_UPDATE_FIXED_FORM_PROVIDER_NAME(map));
    		break;
    		
    	case SQL_MODE_DELETE:
    		getDBManager().executeUpdate(getSQL_DELETE_FIXED_FORM_PROVIDER_NAME(map));
    		break;
    	}
    	
    }
    //[ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�

    /**
     * �O���[�v���Ƃɂ܂Ƃ߂�Map���쐬���܂��B
     * 
     * @param list
     * @return
     * @throws Exception
     */
    public void createGroupMap(VRList list) throws Exception {
        VRList adder;
        //�V�K��Map�𐶐�����B
        VRMap initializeMap = new VRHashMap();
        setListGroupMap(initializeMap);
        for (int i = 0; i < list.size(); i++) {
            // ���X�g����P��Map���擾
            VRMap map = (VRMap) list.getData(i);                        
            map.setData("SQL_MODE", new Integer(SQL_MODE_DEFAULT));
            
            String key = ACCastUtilities.toString(map.getData("TABLE_TYPE"))
                    + "-"
                    + ACCastUtilities.toString(map.getData("FIXED_FORM_ID"));
            // �O���[�v������L�[�������ɑ��݂��Ă��邩���`�F�b�N����
            if (VRBindPathParser.has(key, getListGroupMap())) {
                // �Y�����郊�X�g���擾
                adder = (VRList) getListGroupMap().getData(key);
                // ���X�g�ɒǉ�
                adder.add(map);

            } else {
                // �V�K�Ƀ��X�g�𐶐�
                adder = new VRArrayList();
                // ���X�g�ɒǉ�                
                adder.add(map);
                // �V�K�̃L�[���Ŋi�[
                getListGroupMap().setData(key, adder);
            }
            
            //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
            if (PRINT_PROVIDER.equals(key)) {
            	map.put("SERVICE_CODE_KIND", new Integer(ACCastUtilities.toInt(map.get("CONTENT_KEY"), 0) + 1000));
            }
            //[ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�
        }

    }
}
