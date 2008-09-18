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
 * �쐬��: 2007/12/14  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001033)
 * �v���O���� �T�[�r�X�\�� (QS001033)
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
 * �T�[�r�X�\��(QS001033)
 */
public class QS001033 extends QS001033Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001033() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �uok�{�^���������̏����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void okButtonActionPerformed(ActionEvent e) throws Exception {
        // ���n�j�{�^���������̏���
        if (!checkInputData()) {
            // afterServiceText�Ƀt�H�[�J�X�𓖂Ă�
            getAfterServiceText().requestFocus();
            return;
        }
        // VRMap data �𐶐�����B
        VRMap data = new VRHashMap();
        // contents �� data ��ݒ肷��B
        getContents().setSource(data);
        // ��ʏ�̒l�����W����B
        getContents().applySource();
        // changeData �� data ���̂j�d�x�F11��ǉ�����B
        if (data != null && data.containsKey("11")) {
            getChangeData().setData("11", data.getData("11"));
        }
        setEntryType(true);
        // ��ʂ�j������B
        dispose();
    }

    /**
     * �u�L�����Z���{�^���������̏����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void cancelButtonActionPerformed(ActionEvent e) throws Exception {
        // ���L�����Z���{�^���������̏���
        // ��ʂ�j������B
        dispose();

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001033.class.getName(), param));
    }

    // �����֐�

    /**
     * �u��ʓW�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void showModel(VRMap baseData, ACDBManager dbm) throws Exception {
        // ����ʓW�J���̏���
        if (baseData == null || dbm == null) {
            // ������Null�̏ꍇ�͉�ʂ͋N�������Ȃ�
            return;
        }
        setAffairTitle("QS001033");
        // �n��ϐ��� baseData ��changeData�ɑޔ�����B
        setChangeData(baseData);
        // �w�i�F�̕ύX�N���X�𐶐�
        setAfterServiceTextBackgroundChanger(new ACFollowContainerFormatEventListener());
        getAfterServiceTextBackgroundChanger().formatValid(
                new VRFormatEvent(getAfterServiceText(), null, null));
        // entryType �� false ��ݒ肷��B
        setEntryType(false);
        /*
        // String serviceKind �𐶐�����B
        String serviceKind = null;
        // VRMap bindMap �𐶐�����B
        VRMap bindMap = new VRHashMap();
        // serviceKind ��baseData ���̂j�d�x�FSYSTEM_SERVICE_KIND_DETAIL�̒l���擾����B
        serviceKind = ACCastUtilities.toString(baseData
                .getData("SYSTEM_SERVICE_KIND_DETAIL"), "");
        // object service ��serviceKind�Ɉ�v����}�X�^�[�f�[�^���擾����B
        Object service = null;
        service = QkanCommon.getMasterService(getDBManager());
        // service���l�����ł���ꍇ
        if (service instanceof VRMap) {
            VRMap serviceDetail = new VRHashMap();
            // ��U�擾
            Object obj = ((VRMap) service).getData(ACCastUtilities
                    .toInteger(serviceKind));
            // Map�ł���ꍇ
            if (obj instanceof VRMap) {
                serviceDetail = (VRMap) obj;
                bindMap.setData("11", getChangeData().getData("11"));
                // contents ��bindMap ��ݒ肷��B
                getContents().setSource(bindMap);
                // �ݒ肵���f�[�^����ʂɓW�J����
                getContents().bindSource();
            }
        }
        */

        this.setVisible(true);

    }
    /**
     * �f�[�^���̓`�F�b�N����
     */
    public boolean checkInputData() throws Exception {
        // �����̓`�F�b�N����
        // afterServiceText�ɒl�����͂���Ă��邩�`�F�b�N����B
        if (ACTextUtilities.isNullText(getAfterServiceText())) {
            // �l�����͂���Ă��Ȃ��ꍇ            
            // �G���[���b�Z�[�W��\������B    
            QkanMessageList.getInstance().QS001_ERROR_OF_SERVICE_PATTERN_NAME();
            // �߂�l�Ƃ��ā@false ��Ԃ��B   
            return false;
        }
        //    �l�����͂���Ă���ꍇ         
        //        �߂�l�Ƃ��ā@True ��Ԃ��B        

        return true;
    }
    /**
     * ���X�g�t�H�[�J�X���̏���
     */
    protected void afterServiceTextFocusLost(FocusEvent e) throws Exception {
        if(ACTextUtilities.isNullText(getAfterServiceText())){
            // �ُ�
            getAfterServiceTextBackgroundChanger().changeInvalidContainer();
        }else{
            // ����
            getAfterServiceTextBackgroundChanger().changeValidContainer();
        }
        
    }
    /**
     * �p�^�[�����̂̕ύX���s��ꂽ����Ԃ��܂��B
     * 
     * @return True:���̕ύX�L False:���̕ύX����
     */
    public boolean isPatternNameChange() throws Exception {
        return getEntryType();
    }

}
