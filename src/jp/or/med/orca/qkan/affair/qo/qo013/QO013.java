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
 * �J����: 
 * �쐬��: 2006/06/06  ���{�R���s���[�^�[�������  �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ����W�����Z�v�g�\�t�g�A�g (013)
 * �v���O���� ����W�����Z�v�g�\�t�g�A�g (QO013)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo013;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import sun.io.Converters;
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
import jp.nichicom.ac.util.splash.ACSplash;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.ac.util.splash.ACStopButtonSplash;
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
 * ����W�����Z�v�g�\�t�g�A�g(QO013)
 */
public class QO013 extends QO013Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QO013() {
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
        // ����ʓW�J����
        // ��������
        // ��ʏ�Ԃ�����������B
        setState_NOT_CONNECTED();
        // �������������s���B
        initialize();

    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // ���߂菈��
        // �O��ʂɑJ�ڂ���B
        try{
            // ���ԃe�[�u���̔j��
            QkanReceiptSoftDBManager.clearAccessSpace(getDBManager());
        }catch(Exception e){}

        return true;
    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // ���I������
        // �V�X�e�����I������B
        try{
            // ���ԃe�[�u���̔j��
            QkanReceiptSoftDBManager.clearAccessSpace(getDBManager());
        }catch(Exception e){}

        return true;
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�ʐM�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void connectActionPerformed(ActionEvent e) throws Exception {
        // ���ʐM�����i�����Z�f�[�^�擾�j
        // �ʐM����
        // �����Z�f�[�^���擾����B
        doFind();

    }

    /**
     * �u��荞�ݏ����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void importPatientActionPerformed(ActionEvent e) throws Exception {
        // �����ҏ���荞�ݏ���
        // ��荞�ݑO�ɏ���ۑ����Ă���
        saveProperty();
        // �ēx�ݒ�Ǎ���
        readProperty();
        // ���ҏ���荞��
        if (doInsert()) {

            VRList list = new VRArrayList();
            // �e�[�u�����猻�݂̏����擾����
            Object obj = getReceiptTableModel().getAdaptee();
            if (obj instanceof VRList) {
                // list�ɕϊ�
                list = (VRList) obj;
            } else {
                // �ϊ��ł��Ȃ��ꍇ�͏����I��
                return;
            }
            // �d���`�F�b�N���s���B
            list = checkSameName(list);
            // ���ʂ��i�[����B
            getReceiptTableModel().setAdaptee(list);
            // ���b�Z�[�W�\��
            QkanMessageList.getInstance().QO013_SUCCESS_INSERT();
        } else {
            return;
        }
    }

    /**
     * �u�O�փ{�^�������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void previewPageActionPerformed(ActionEvent e) throws Exception {
        // ���O�փ{�^���������̏���
        // �O�փ{�^��������
        // ���݂̃y�[�W����1�y�[�W�ȊO�������ꍇ
        // ���y�[�W���擾
        if (getNowPage() > 1) {
            // �y�[�W����1����
            setNowPage(getNowPage() - 1);
        
            // �{�^����Ԑ���
            pageButtonState();
            int begin = ((getNowPage() - 1) * PAGE_COUNT) + 1;
            int end = (getNowPage() * PAGE_COUNT) + 1;
            // �O�y�[�W���擾
            VRList list = getPageData(begin,end);
            // ���ʂ��i�[����B
            getReceiptTableModel().setAdaptee(list);
        }
    }

    /**
     * �u���փ{�^�������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void nextPageActionPerformed(ActionEvent e) throws Exception {
        // �����փ{�^���������̏���
        // ���փ{�^��������
        int begin = (getNowPage() * PAGE_COUNT) + 1;
        int end = ((getNowPage() + 1) * PAGE_COUNT) + 1;
        // �y�[�W���� + 1
        setNowPage(getNowPage() + 1);
        // 1�y�[�W���f�[�^�擾
        VRList list = getPageData(begin,end);
        // ���ʂ��i�[����B
        getReceiptTableModel().setAdaptee(list);
        // ��Ԑ���
        pageButtonState();
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QO013.class.getName(), param));
    }

    // �����֐�

    /**
     * �u�����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // �������ݒ�
        // ���E�C���h�E�^�C�g���E�Ɩ��{�^����ݒ肷��B
        setAffairTitle("QO013",getButtons());

        // �e�[�u�����f�����쐬���ݒ肷��B
        ACTableModelAdapter receiptTable = new ACTableModelAdapter();

        receiptTable
                .setColumns(new String[] {"IMPORT_NO","IMPORT_FLAG", 
                        "BATTING_FLAG",
                        "PATIENT_FAMILY_NAME+'�@'+PATIENT_FIRST_NAME",
                        "PATIENT_FAMILY_KANA+'�@'+PATIENT_FIRST_KANA",
                        "PATIENT_SEX", "PATIENT_BIRTHDAY", "PATIENT_BIRTHDAY",
                        "PATIENT_ZIP_FIRST+'-'+PATIENT_ZIP_SECOND",
                        "PATIENT_ADDRESS",
                        "PATIENT_TEL_FIRST+'-'+PATIENT_TEL_SECOND+'-'+PATIENT_TEL_THIRD" });
        setReceiptTableModel(receiptTable);
        getPatients().setModel(getReceiptTableModel());
        // �E�B���h�E�^�C�g���ɁA�擾���R�[�h��KEY : WINDOW_TITLE��VALUE��ݒ肷��B
        // �Ɩ��{�^���o�[�̃e�L�X�g�ɁA�擾���R�[�h��KEY : AFFAIR_TITLE��VALUE��ݒ肷��B
        // �ʐM�̐ݒ����Ǎ���
        readProperty();
        // �ݒ蕜��
        setRestoration();
        // �����ݒ�
        setNowPage(1);
        // �{�^����Ԑݒ�
        pageButtonState();
        // �y�[�W���̂ݏ����ݒ�
        getViewBeginNo().setText("0");

    }

    /**
     * �u�ڑ��p���s���`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean checkConectInfo() throws Exception {
        // ���ڑ��p���s���`�F�b�N
        // dbs�T�[�o�[�ɐڑ�����B�iQkanReceiptSoftDBManager)�Ɉ�����n���B
        // �ڑ����ɃG���[�����������ꍇ
        // ���b�Z�[�W��\������B ���ڑ���̐ݒ肪�s���ł��B�ڑ���z�X�g��|�[�g�ԍ����������Ă��������B
        // �Ԃ�l�Ƃ��� false ��Ԃ��B
        return false;
    }

    /**
     * �u�ʐM�ݒ�Ǎ��݁v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void readProperty() throws Exception {
        // ���ʐM�ݒ�Ǎ��ݏ���
        // �ݒ�t�@�C�����Ǎ��߂邩�`�F�b�N����B
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/IP")) {
            // �Ǎ��߂��ꍇ
            // �ڑ���z�X�g��Ǎ��ݕϐ� portNo �Ɋi�[����B
            setIp(ACFrame.getInstance().getProperty("ReceiptAccess/IP"));
        } else {
            // �Ǎ��߂Ȃ������ꍇ
            // �����l��ݒ肷��B
            setIp("127.0.0.1");
        }
        // �ݒ�t�@�C�����Ǎ��߂邩�`�F�b�N����B
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/DBSVersion")) {
            // �Ǎ��߂��ꍇ
            // DBSVer��Ǎ��ݕϐ� dbsVer �Ɋi�[����B
            setDbsVer(ACFrame.getInstance().getProperty(
                    "ReceiptAccess/DBSVersion"));
        } else {
            // �Ǎ��߂Ȃ������ꍇ
            // �����l��ݒ肷��B
            setDbsVer("1.2.5");
        }
        // �ݒ�t�@�C�����Ǎ��߂邩�`�F�b�N����B
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/Port")) {
            // �Ǎ��߂��ꍇ
            // �|�[�g�ԍ���Ǎ��� portNo �Ɋi�[����B
            setPort(ACFrame.getInstance().getProperty("ReceiptAccess/Port"));
        } else {
            // �Ǎ��߂Ȃ������ꍇ
            // �����l��ݒ肷��B
            setPort("8013");
        }
        // �ݒ�t�@�C�����Ǎ��߂邩�`�F�b�N����B
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/UserName")) {
            // �Ǎ��߂��ꍇ
            // ���[�U�[����Ǎ��� user �Ɋi�[����B
            setUser(ACFrame.getInstance().getProperty("ReceiptAccess/UserName"));
        } else {
            // �Ǎ��߂Ȃ������ꍇ
            // �����l��ݒ肷��B
            setUser("ormaster");
        }
        // �ݒ�t�@�C�����Ǎ��߂邩�`�F�b�N����B
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/Password")) {
            // �Ǎ��߂��ꍇ
            // �p�X���[�h��Ǎ��� pass �Ɋi�[����B
            setPass(ACFrame.getInstance().getProperty("ReceiptAccess/Password"));
        } else {
            // �Ǎ��߂Ȃ������ꍇ
            // �����l��ݒ肷��B
            setPass("ormaster");
        }
        // �ݒ�t�@�C�����Ǎ��߂邩�`�F�b�N����B
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/ToHiragana")) {
            // �Ǎ��߂��ꍇ
            // �p�X���[�h��Ǎ��� toHiraganaConvert �Ɋi�[����B
            setToHiraganaConvert(ACFrame.getInstance().getProperty(
                    "ReceiptAccess/ToHiragana"));
        } else {
            setToHiraganaConvert("");
        }
    }

    /**
     * �u�ʐM�ݒ菑�����݁v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void saveProperty() throws Exception {
        // ���ʐM�ݒ菑�����ݏ���
        // �ʐM�ݒ菑������
        setPort(getPortNo().getText());
        setIp(getHostName().getText());
        setUser(getUserName().getText());
        setPass(getPassword().getText());
        setDbsVer(getDbsVersion().getText());

        ACFrame.getInstance().getPropertyXML().setForceValueAt(
                "ReceiptAccess/IP", getIp());
        ACFrame.getInstance().getPropertyXML().setForceValueAt(
                "ReceiptAccess/DBSVersion", getDbsVer());
        ACFrame.getInstance().getPropertyXML().setForceValueAt(
                "ReceiptAccess/Port", getPort());
        ACFrame.getInstance().getPropertyXML().setForceValueAt(
                "ReceiptAccess/UserName", getUser());
        ACFrame.getInstance().getPropertyXML().setForceValueAt(
                "ReceiptAccess/Password", getPass());

        // �Ђ炪�ȕϊ����`�F�b�N����Ă��邩�B
        if (getToHiragana().isSelected()) {
            // �`�F�b�N����Ă���ꍇ
            ACFrame.getInstance().getPropertyXML().setForceValueAt(
                    "ReceiptAccess/ToHiragana", "true");
        } else {
            // �`�F�b�N����Ă��Ȃ��ꍇ
            ACFrame.getInstance().getPropertyXML().setForceValueAt(
                    "ReceiptAccess/ToHiragana", "false");
        }
    }

    /**
     * �u�d�����Җ��`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRList checkSameName(VRList list) throws Exception {
        // ���d�����Җ��`�F�b�N����
        // �d�����Җ��`�F�b�N
        ACDBManager dbm = getDBManager();
        // ���ǒ��e�[�u�������r�p�f�[�^���擾���܂��B
        VRList nowPatients = (VRList) dbm
                .executeQuery(getSQL_GET_PATIENT_INFO(null));

        int destEnd = list.size();
        int nowEnd = nowPatients.size();
        for (int i = 0; i < nowEnd; i++) {
            // ���ǒ��e�[�u���f�[�^��1�s���擾
            VRMap nowRow = (VRMap) nowPatients.getData(i);
            // ���p�Җ����擾
            String nowName = QkanCommon.toFullName(VRBindPathParser.get(
                    "PATIENT_FAMILY_NAME", nowRow), VRBindPathParser.get(
                    "PATIENT_FIRST_NAME", nowRow));
            // ��r�̍��ق�h�����ߋ󔒂�����
            nowName = ACTextUtilities.trim(nowName);
            String nowBirth = "";
            Object nowObj = VRBindPathParser.get("PATIENT_BIRTHDAY", nowRow);
            if (nowObj instanceof Date) {
                nowBirth = VRDateParser.format((Date) nowObj, "yyyyMMdd");
            }
            for (int j = 0; j < destEnd; j++) {
                VRMap destRow = (VRMap) list.getData(j);
                String destName = String.valueOf(VRBindPathParser.get("NAME",
                        destRow));
                if (nowName.equals(destName)) {
                    String destBirth = "";
                    Object destObj = VRBindPathParser.get("PATIENT_BIRTHDAY",
                            destRow);
                    if (destObj instanceof Date) {
                        destBirth = VRDateParser.format((Date) destObj,
                                "yyyyMMdd");
                    }
                    if (nowBirth.equals(destBirth)) {
                        VRBindPathParser.set("BATTING_FLAG", destRow, "����");
                        VRBindPathParser.set("IMPORT_FLAG", destRow,
                                new Boolean(false));
                    }
                }
            }
        }
        // �ҏW�����������X�g��ԋp
        return list;
    }

    /**
     * �u��荞�݊��҃f�[�^�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean doInsert() throws Exception {
        // ����荞�݊��҃f�[�^��荞�ݏ���
        // ��荞�݊��҃f�[�^��荞��
        ACDBManager dbm = getDBManager();
        try {
            // �g�����U�N�V�����J�n
            dbm.beginTransaction();

            VRList importPatients = getInsertCheckedRows();
            int end = importPatients.getDataSize();

            // ���p�Ґ����[�v����
            for (int i = 0; i < importPatients.size(); i++) {
                // 1�s�擾
                VRMap sqlParam = (VRMap) importPatients.getData(i);
                // �s������ǉ�
                VRBindPathParser.set("SHOW_FLAG", sqlParam, new Integer(1));
                VRBindPathParser.set("DELETE_FLAG", sqlParam, new Integer(0));

                // �ϊ�����ꍇ�͕ϊ�����B
                if ("true".equals(getToHiraganaConvert())) {
                    VRBindPathParser.set("PATIENT_FAMILY_KANA", sqlParam,
                            ACKanaConvert.toHiragana(ACCastUtilities
                                    .toString(sqlParam
                                            .getData("PATIENT_FAMILY_KANA"))));
                    VRBindPathParser.set("PATIENT_FIRST_KANA", sqlParam,
                            ACKanaConvert.toHiragana(ACCastUtilities
                                    .toString(sqlParam
                                            .getData("PATIENT_FIRST_KANA"))));
                }
                // �o�^
                dbm.executeUpdate(getSQL_INSERT_PATIENT(sqlParam));
            }

            dbm.commitTransaction();
            // ��������I��
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            // ���[���o�b�N
            dbm.rollbackTransaction();
            return false;
        }

    }

    /**
     * �u��荞�݊��Ҏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRList getInsertCheckedRows() throws Exception {
        // ����荞�݊��Ҏ擾����
        // ��荞�݊��Ҏ擾
        VRList rows = new VRArrayList();
        // �e�[�u�����猻�݂̏����擾����
        Object obj = getReceiptTableModel().getAdaptee();
        if (obj instanceof VRList) {
            // list�ɕϊ�
            rows = (VRList) obj;
        } else {
            // �ϊ��ł��Ȃ��ꍇ�͏����I��
            return new VRArrayList();
        }
        int end = rows.size();
        VRList result = new VRArrayList();
        for (int i = 0; i < end; i++) {
            VRMap row = (VRMap) rows.getData(i);
            // �e�[�u���̈�s����t���O���`�F�b�N����B
            Object objs = row.getData("IMPORT_FLAG");
            if (objs instanceof Boolean) {
                Boolean val = (Boolean) objs;
                if (val.booleanValue()) {
                    result.add(row);
                }
            }
        }
        return result;
    }

    /**
     * �X�v���b�V�������
     */
    public ACSplashable closeSplash(ACSplashable splash) {
        if (splash != null) {
            splash.close();
        }
        return null;
    }

    /**
     * �����Z�f�[�^�擾����
     */
    public void doFind() throws Exception {
        // �ʐM�ݒ�ۑ�����
        saveProperty();
        // ��������ł݂�
        if (!ACFrame.getInstance().getPropertyXML().writeWithCheck()) {
            // �������߂Ȃ������ꍇ�͏������I������B
            return;
        }
        // �ʐM�ݒ�Ǎ���
        readProperty();

        QkanReceiptSoftDBManager dbm;
        ACSplashable splash = null;

        try {
            // �ڑ�����������Ă݂�
            dbm = new QkanReceiptSoftDBManager(getIp(), ACCastUtilities
                    .toInt(getPort()), getUser(), getPass(), getDbsVer());
        } catch (Exception ex) {
            // �ڑ��s��
            QkanMessageList.getInstance().QO013_ERROR_OF_CONECT();
            // �����I��
            return;
        }

        int count = 0;
        try {
            // ���Ҏ�荞�݂��s���̂��`�F�b�N����B
            if (QkanMessageList.getInstance().QO013_QUESTION_OF_FIND() == ACMessageBox.RESULT_OK) {
                // OK�I����
                ACFrameEventProcesser processer = ACFrame.getInstance()
                        .getFrameEventProcesser();
                if (processer instanceof QkanFrameEventProcesser) {
                    splash = new ACStopButtonSplash();
                    // �A�C�R���w��
                    ((ACSplash) splash)
                            .setIconPathes(((QkanFrameEventProcesser) processer)
                                    .getSplashFilePathes());
                    
                    // �T�C�Y
                    Dimension d = ((QkanFrameEventProcesser) processer)
                            .getSplashWindowSize();
                    if (d != null) {
                        // �X�v���b�V���T�C�Y�w��
                        d = new Dimension((int) d.getWidth(), (int) d
                                .getHeight() + 20);
                    }

                    ((ACSplash) splash).refreshSize(d);
                    // �X�v���b�V���\��
                    if (!((ACSplash) splash).isVisible()) {
                        ((ACSplash) splash).showModaless("�f�[�^�ʐM");
                    }
                    // �X�g�A�h�v���V�[�W������ �����null
                    VRMap param = null;
                    // opass���猋�ʂ��擾
                    count = dbm.executeQuery(getDBManager(), "tbl_ptinf",
                            "all", param, splash);

                }

            } else {
                // �L�����Z���I����
                // �����I��
                return;
            }

        } catch (Exception ex) {
            splash = closeSplash(splash);
            Throwable cause = ex.getCause();
            if (cause instanceof java.net.ConnectException) {
                QkanMessageList.getInstance().QO013_ERROR_OF_CONECT_CUSTOM(
                        "�ڑ�", "");
                return;
            } else if (cause instanceof UnknownHostException) {
                // �G���[���b�Z�[�W�\��
                QkanMessageList.getInstance().QO013_ERROR_OF_CONECT_CUSTOM(
                        "�ڑ�", "�ڑ���z�X�g�̐ݒ���������Ă��������B");
                // �����I��
                return;

            } else if (cause instanceof java.net.SocketException) {
                // �G���[���b�Z�[�W�\��
                QkanMessageList.getInstance().QO013_ERROR_OF_CONECT_CUSTOM(
                        "�ڑ�", "�ʐM��ؒf���ꂽ�\������܂��B�ēx���s���Ă��������B");
                return;

            } else if (ex.getMessage().indexOf("invalid version") >= 0) {
                // �G���[���b�Z�[�W��\��
                QkanMessageList.getInstance()
                        .QO013_ERROR_OF_CONECT_DATA_BASE_VERSION();
                return;

            } else if (ex.getMessage().indexOf("authentication error") >= 0) {
                // �G���[���b�Z�[�W�\��
                QkanMessageList.getInstance().QO013_ERROR_OF_CONECT_CUSTOM(
                        "�F��", "���[�U�[������уp�X���[�h���s���ł��B");
                return;

            }else if (cause == null){
                // �G���[���b�Z�[�W
                // �G���[���b�Z�[�W�\��
                QkanMessageList.getInstance().QO013_ERROR_OF_CONECT_CUSTOM(
                        "�ڑ�", "�ʐM��ؒf���ꂽ�\������܂��B�ēx���s���Ă��������B");
                return;
            }
            throw ex;
        }

        // ���ҏ�񂪎擾�ł��Ȃ������ꍇ
        if (count <= 0) {
            splash = closeSplash(splash);
            ACMessageBox.show("���ҏ�񂪑��݂��܂���B");
            // ��ʏ�Ԑ���
            setState_NOT_CONNECTED();
            // �����I��
            return;
        } else {
            // ��ʏ�Ԑ���
            setState_CONNECTED();
        }

        // �擾�����\������
        setStatusText(count + "���擾���܂����B");
        getTotalCount().setText(ACCastUtilities.toString(count));
        getViewEndNo().setText(ACCastUtilities.toString(count));
        // �y�[�W���w��
        setNowPage(1);

        // ���ҏ����擾����B
        // �����ݒ�
        setNowPage(1);
        int end = getNowPage() + PAGE_COUNT;
        // �e�[�u���p�f�[�^���擾����B
        VRList list = getPageData(getNowPage(),end);
        // ���ʂ��i�[����B
        getReceiptTableModel().setAdaptee(list);
        // �����Z�f�[�^��ޔ�
        setReceiptDataList(list);
        // ��ʏ�Ԑ���
        pageButtonState();
        // �X�v���b�V�������
        splash = closeSplash(splash);

        // ���b�Z�[�W�\������
        QkanMessageList.getInstance().QO013_SUCCESS_PATIENT();
    }

    /**
     * �ޔ�̈悩�犳�ҏ����擾���܂��B
     */
    public VRList readFromAccessSpace(int begin, int end) throws Exception {

        VRMap sqlParam = new VRHashMap();
        // �p�����[�^�i�[
        sqlParam.setData("SERIAL_ID_HOME", ACCastUtilities.toInteger(begin));
        sqlParam.setData("SERIAL_ID_END", ACCastUtilities.toInteger(end));
        // �ꎞ�̈悩��w�茏�����̃f�[�^���擾���܂��B
        VRList list = getDBManager().executeQuery(
                getSQL_GET_RECEPT_INFO(sqlParam));
        // �����Ԃ�
        return list;
    }

    /**
     * ���ǒ��`���̃f�[�^�ɕϊ�����
     */
    public VRList convertQkanData(VRList src) throws Exception {
        if (src == null || src.size() <= 0) {
            // �������I������B
            return new VRArrayList();
        }
        int size = src.size();

        boolean encode = false;
        String osName = System.getProperty("os.name");
        // Mac�ȊO�ł���Ε����R�[�h�ϊ����s���B
        if ((osName != null) && (osName.indexOf("Mac") < 0)) {
            encode = true;
        }
        // ���Ҕԍ������p��Cd
        // �L�[�̗L���ŏ����𔻒f
        VRMap checkRow = (VRMap) src.getData(0);
        if (VRBindPathParser.has("PTID", checkRow)) {
            // ����ID
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                        .toString(VRBindPathParser.get("PTID", row)));
                if (val.length() > 16) {
                    // 16��������
                    val = val.substring(0, 16);
                }
                VRBindPathParser.set("PATIENT_CODE", row, val);
            }
        } else {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                VRBindPathParser.set("PATIENT_CODE", row, "");
            }
        }

        // ���Ҏ��������p�Ҏ���
        if (VRBindPathParser.has("NAME", checkRow)) {
            // ����
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                        .toString(VRBindPathParser.get("NAME", row)));
                // �S�p�X�y�[�X�����邩���`�F�b�N
                int sepPos = val.indexOf("�@");
                if (sepPos < 0) {
                    sepPos = val.indexOf(" ");
                }
                if (sepPos >= 0) {
                    String first = "";
                    String family = "";
                    // ���p�E�S�p�ɂ���ĕ���

                    first = val.substring(0, sepPos);
                    family = val.substring(sepPos, val.length());
                    // ����16�����ȏ�ł���Ζ��Ɍ�������B
                        // 16�����Ő؂�
                        VRBindPathParser.set("PATIENT_FAMILY_NAME", row, first
                                .substring(0,Math.min(16,first.length())));
                    // �X�y�[�X����菜��
                    family = ACTextUtilities.trim(family);

                    // ����16�����ȏ�̏ꍇ
                        // 16�����Ő؂�
                        VRBindPathParser.set("PATIENT_FIRST_NAME", row, family
                            .substring(0, Math.min(16, family.length())));

                } else {
                    // �S�p�E���p�X�y�[�X���Ȃ��ꍇ
                    // ��������16�����ȏ�ł���ꍇ
                    if (val.length() > 15) {
                        // 16�����ŋ�؂�
                        VRBindPathParser.set("PATIENT_FAMILY_NAME", row, val
                                .substring(0, 16));
                        VRBindPathParser.set("PATIENT_FIRST_NAME", row, val
                                .substring(16, Math.min(31, val.length())));
                    } else {
                        VRBindPathParser.set("PATIENT_FAMILY_NAME", row, val);
                        VRBindPathParser.set("PATIENT_FIRST_NAME", row, "");
                    }
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                // �S�ċ󔒂�ݒ�
                VRBindPathParser.set("PATIENT_FAMILY_NAME", row, "");
                VRBindPathParser.set("PATIENT_FIRST_NAME", row, "");
            }
        }
        // �J�i�����Ȏ���
        if (VRBindPathParser.has("KANANAME", checkRow)) {
            // ���Ȏ���
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                        .toString(VRBindPathParser.get("KANANAME", row)));
                int sepPos = val.indexOf("�@");
                if (sepPos < 0) {
                    sepPos = val.indexOf(" ");
                }
                // �S�p�X�y�[�X�����邩���`�F�b�N
                if (sepPos >= 0) {
                    String firstKana = "";
                    String familyKana = "";
                    // ���p�E�S�p�ɂ���ĕ���

                    firstKana = val.substring(0, sepPos);
                    familyKana = val.substring(sepPos, val.length());

                        // 16�����Ő؂�
                        VRBindPathParser.set("PATIENT_FAMILY_KANA", row, firstKana
                            .substring(0, Math.min(16, firstKana.length())));

                    // �X�y�[�X����菜��
                    familyKana = ACTextUtilities.trim(familyKana);
                    // ����16�����ȏ�̏ꍇ
                        // 16�����Ő؂�
                        VRBindPathParser.set("PATIENT_FIRST_KANA", row, familyKana
                            .substring(0, Math.min(16, familyKana.length())));

                } else {
                    // �S�p�E���p�X�y�[�X���Ȃ��ꍇ
                    // ��������16�����ȏ�ł���ꍇ
                    if (val.length() > 15) {
                        // 16�����ŋ�؂�
                        VRBindPathParser.set("PATIENT_FAMILY_KANA", row, val
                                .substring(0, 16));
                        VRBindPathParser.set("PATIENT_FIRST_KANA", row, val
                                .substring(16, Math.min(31, val.length())));
                    } else {
                        VRBindPathParser.set("PATIENT_FAMILY_KANA", row, val);
                    }
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                // �S�ċ󔒂�ݒ�
                VRBindPathParser.set("PATIENT_FAMILY_KANA", row, "");
                VRBindPathParser.set("PATIENT_FIRST_KANA", row, "");
            }
        }
        // ���ʁ�����
        if (VRBindPathParser.has("SEX", checkRow)) {
            // ����
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                VRBindPathParser.set("PATIENT_SEX", row, Integer
                        .valueOf(ACTextUtilities.toBlankIfNull(ACCastUtilities
                                .toString(VRBindPathParser.get("SEX", row)))));
            }
        } else {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                VRBindPathParser.set("PATIENT_SEX", row, new Integer(0));
            }
        }
        // �N��
        if (VRBindPathParser.has("BIRTHDAY", checkRow)) {
            // �N��
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                Object obj = VRBindPathParser.get("BIRTHDAY", row);
                // ��͎��s����null��Ԃ��B
                Date val = ACCastUtilities.toDate(obj,null);
                // ���t�^�ɕϊ��ł���p�^�[��
                if (val != null) {
                    // �ݒ�
                    VRBindPathParser.set("PATIENT_BIRTHDAY", row,
                            val);
                } else {
                    // �L���X�g�������Ȃ珉���l������
                    VRBindPathParser.set("PATIENT_BIRTHDAY", row, "");
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                VRBindPathParser.set("PATIENT_BIRTHDAY", row, "");
            }
        }
        // �X�֔ԍ�
        if (VRBindPathParser.has("HOME_POST", checkRow)) {
            // �X�֔ԍ�
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                        .toString(VRBindPathParser.get("HOME_POST", row)));
                // 8�����ȉ��ł��邩�`�F�b�N����B
                if (val.length() < 8) {
                    if (val.length() >= 3) {
                        // �ݒ�
                        VRBindPathParser.set("PATIENT_ZIP_FIRST", row, val
                                .substring(0, 3));
                        VRBindPathParser.set("PATIENT_ZIP_SECOND", row, val
                                .substring(3, Math.min(7, val.length())));
                    } else {
                        // 3�����ȉ��̏ꍇ
                        VRBindPathParser.set("PATIENT_ZIP_FIRST", row, val
                                .substring(0, val.length()));
                        VRBindPathParser.set("PATIENT_ZIP_SECOND",row,"");
                    }
                } else {
                    // 8�����ȏ�̏ꍇ
                    VRBindPathParser.set("PATIENT_ZIP_FIRST", row, val
                            .substring(0, 3));
                    VRBindPathParser.set("PATIENT_ZIP_SECOND", row, val
                            .substring(3, Math.min(7, val.length())));
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                VRBindPathParser.set("PATIENT_ZIP_FIRST", row, "");
                VRBindPathParser.set("PATIENT_ZIP_SECOND", row, "");
            }
        }
        // �Z���{�Ԓn �� �Z��
        if (VRBindPathParser.has("HOME_ADRS", checkRow)) {
            // �Z�������͂���Ă��邩�`�F�b�N����B
            if (VRBindPathParser.has("HOME_BANTI", checkRow)) {
                for (int i = 0; i < size; i++) {
                    VRMap row = (VRMap) src.getData(i);
                    // �Z���ƔԒn����������
                    String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                            .toString(VRBindPathParser.get("HOME_ADRS", row)))
                            + ACTextUtilities.toBlankIfNull(ACCastUtilities
                                    .toString(VRBindPathParser.get(
                                            "HOME_BANTI", row)));
                    // 64��������
                    if (val.length() > 64) {
                        val = val.substring(0, 64);
                    }
                    VRBindPathParser.set("PATIENT_ADDRESS", row, val);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    VRMap row = (VRMap) src.getData(i);
                    // �Z���݂̂�ݒ�
                    String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                            .toString(VRBindPathParser.get("HOME_ADRS", row)));
                    // 64��������
                    if (val.length() > 64) {
                        val = val.substring(0, 64);
                    }
                    VRBindPathParser.set("PATIENT_ADDRESS", row, val);
                }
            }
        } else if (VRBindPathParser.has("HOME_BANTI", checkRow)) {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                // �Ԓn�݂̂�ݒ�
                String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                        .toString(VRBindPathParser.get("HOME_BANTI", row)));
                // 64��������
                if (val.length() > 64) {
                    val = val.substring(0, 64);
                }
                VRBindPathParser.set("PATIENT_ADDRESS", row, val);
            }
        } else {
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                VRBindPathParser.set("PATIENT_ADDRESS", row, "");
            }
        }

        if (VRBindPathParser.has("HOME_TEL1", checkRow)) {
            // �d�b�ԍ�
            for (int i = 0; i < size; i++) {
                VRMap row = (VRMap) src.getData(i);
                String val = ACTextUtilities.toBlankIfNull(ACCastUtilities
                        .toString(VRBindPathParser.get("HOME_TEL1", row)));
                // ���l�݂̂̕�����ɒu�����ԋp
                val = toNotTelCharReplace(val);
                String[] tels = val.split("-");
                if ((tels.length<=0)|| ACTextUtilities.isNullText(tels[0])) {
                    // �S�ď��������ă��[�v���X�L�b�v
                    VRBindPathParser.set("PATIENT_TEL_FIRST", row, "");
                    VRBindPathParser.set("PATIENT_TEL_SECOND", row, "");
                    VRBindPathParser.set("PATIENT_TEL_THIRD", row, "");
                    continue;
                }
                // �������̒�����0�̏ꍇ
                // ��������������1�ڂ�5�����ȏォ�`�F�b�N����B
                if (tels[0].length() > 6) {
                    String[] telSrc;
                    telSrc = new String[3];

                    // �P�ݒ�
                    telSrc[0] = tels[0].substring(0, 6);
                    if (tels[0].length() > 10) {
                        // 9������葽���̂�2�A3�Ɛݒ�
                        telSrc[1] = tels[0].substring(6, 10);
                        telSrc[2] = tels[0].substring(10, Math.min(14,tels[0].length()));
                    } else {
                        // 9����������2�߂܂�
                        telSrc[1] = tels[0].substring(6, tels[0].length());
                    }
                    tels = telSrc;
                }


                // ���`���������񂩂�ݒ�
                switch (tels.length) {
                case 1:
                    VRBindPathParser.set("PATIENT_TEL_FIRST", row, tels[0].substring(0,Math.min(6,tels[0].length())));
                    VRBindPathParser.set("PATIENT_TEL_SECOND", row, "");
                    VRBindPathParser.set("PATIENT_TEL_THIRD", row, "");
                    break;
                case 2:
                    VRBindPathParser.set("PATIENT_TEL_FIRST", row, tels[0].substring(0,Math.min(6,tels[0].length())));
                    VRBindPathParser.set("PATIENT_TEL_SECOND", row, tels[1].substring(0,Math.min(4,tels[1].length())));
                    VRBindPathParser.set("PATIENT_TEL_THIRD", row, "");
                    break;
                default:
                    VRBindPathParser.set("PATIENT_TEL_FIRST", row, tels[0].substring(0,Math.min(6,tels[0].length())));
                    VRBindPathParser.set("PATIENT_TEL_SECOND", row, tels[1].substring(0,Math.min(4,tels[1].length())));
                    VRBindPathParser.set("PATIENT_TEL_THIRD", row, tels[2].substring(0,Math.min(4,tels[2].length())));
                    break;
                }
            
            }
                
        }
        
        // �����l��ݒ�
        for (int i = 0; i < size; i++) {
            VRMap row = (VRMap) src.getData(i);
            VRBindPathParser.set("IMPORT_FLAG", row, new Boolean(true));
            VRBindPathParser.set("BATTING_FLAG", row, "");
        }
        
        return src;
    }

    /**
     * �ݒ蕜������
     */
    public void setRestoration() throws Exception {
        getHostName().setText(getIp());
        getDbsVersion().setText(getDbsVer());
        getPortNo().setText(getPort());
        getUserName().setText(getUser());
        getPassword().setText(getPass());
        // �`�F�b�N�̏�Ԃ𕜌�
        if ("true".equals(getToHiraganaConvert())) {
            getToHiragana().setSelected(true);
        } else {
            getToHiragana().setSelected(false);
        }
    }

    /**
     * ���l�݂̂ɒu�����܂��B
     */
    public String toNotTelCharReplace(String src) throws Exception {
        StringBuffer sb = new StringBuffer();
        int end = src.length();
        for (int i = 0; i < end; i++) {
            char c = src.charAt(i);
            if ((c == '-') || ((c >= '0') && (c <= '9'))) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * �y�[�W�{�^����Ԑ���
     */
    public void pageButtonState() throws Exception {
        int total = ACCastUtilities.toInt(getTotalCount().getText());
        // �O�y�[�W�{�^���̏�Ԑ���
        if (getNowPage() - 1 < 1) {
            // 1�y�[�W�ڂ̏ꍇ
            setState_INVALID_PREVIEW_PAGE();
            // �y�[�W�\������
            getViewBeginNo().setText("1");
            getViewEndNo()
                    .setText(ACCastUtilities.toString(PAGE_COUNT) + " ����");
        } else {
            // 1�y�[�W�ڈȊO
            setState_VALID_PREVIEW_PAGE();
            // �y�[�W�\������
            getViewBeginNo().setText(
                    ACCastUtilities
                            .toString(((getNowPage() - 1) * PAGE_COUNT) + 1));
            getViewEndNo()
                    .setText(
                            ACCastUtilities.toString(getNowPage() * PAGE_COUNT)
                                    + " ����");
        }

        // ���y�[�W�{�^���̏�Ԑ���
        if (total < getNowPage() * PAGE_COUNT) {
            // �ő�y�[�W
            setState_INVALID_NEXT_PAGE();
            // �y�[�W�\������
            getViewEndNo().setText(getTotalCount().getText() + " ����");
            getViewBeginNo().setText(
                    ACCastUtilities
                            .toString(((getNowPage() - 1) * PAGE_COUNT) + 1));
        } else {
            // �ő�y�[�W����
            setState_VALID_NEXT_PAGE();
            // �y�[�W�\������
            getViewBeginNo().setText(
                    ACCastUtilities
                            .toString(((getNowPage() - 1) * PAGE_COUNT) + 1));
            getViewEndNo()
                    .setText(
                            ACCastUtilities.toString(getNowPage() * PAGE_COUNT)
                                    + " ����");
        }
    }

    /**
     * 1�y�[�W���̃f�[�^���擾���܂��B
     */
    public VRList getPageData(int begin, int end) throws Exception {
        // ���y�[�W���擾
        VRList list = readFromAccessSpace(begin, end);
        // ���ǒ��f�[�^�ɕϊ�
        list = convertQkanData(list);
        // �d���`�F�b�N���s���B
        list = checkSameName(list);
        // ���X�g��Ԃ�
        return list;
    }

}
