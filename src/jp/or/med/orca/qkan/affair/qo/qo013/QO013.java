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

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001SpecialCase;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACKanaConvert;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.ACMessageBoxExceptionPanel;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.ac.util.splash.ACSplash;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.ac.util.splash.ACStopButtonSplash;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qo.qo002.QO002_M_InsurerBridgeFirebirdDBManager;

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
        try {
            // ���ԃe�[�u���̔j��
            QkanReceiptSoftDBManager.clearAccessSpace(getDBManager());
        } catch (Exception e) {
        }

        return true;
    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // ���I������
        // �V�X�e�����I������B
        try {
            // ���ԃe�[�u���̔j��
            QkanReceiptSoftDBManager.clearAccessSpace(getDBManager());
        } catch (Exception e) {
        }

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
            
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin �����Z�A�g�@�\�ǉ��Ή�
            //��ʏ�̃`�F�b�N��OFF��
            int count = list.size();
            for (int i = 0; i < count; i++) {
                VRMap row = (VRMap)list.get(i);
                VRBindPathParser.set("IMPORT_FLAG", row, new Boolean(false));
            }
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - end �����Z�A�g�@�\�ǉ��Ή�
            
            // ���ʂ��i�[����B
            getReceiptTableModel().setAdaptee(list);
            // ���b�Z�[�W�\��
            // [H28.4 �v�]][Shnobu Hitaka] 2016/02/03 edit - begin �����A�g�Ή�
            // QkanMessageList.getInstance().QO013_SUCCESS_INSERT();
            if (getImportMessage().length() > 0) {
	            ACMessageBoxExceptionPanel pnl = new ACMessageBoxExceptionPanel();
	            String msg1 = "���ҏ�����荞�݂܂����B";
	            String msg2 = "���F��E���ی���񂪎�荞�߂Ȃ����҂�����܂����B" + ACConstants.LINE_SEPARATOR + "�ڍׂ����m�F�̏�A���p�ҏ��ڍ׉�ʂŔF�����o�^���Ă��������B";
	            pnl.setEnvironment(msg2);
	            pnl.setInfomation(ACConstants.LINE_SEPARATOR + getImportMessage() + ACConstants.LINE_SEPARATOR + ACConstants.LINE_SEPARATOR);
	            ACMessageBox.show(msg1, pnl, true);
	            if (pnl.getParent() != null) {
	                pnl.getParent().remove(pnl);
	            }
	            pnl = null;
            } else {
            	QkanMessageList.getInstance().QO013_SUCCESS_INSERT();
            }
            // [H28.4 �v�]][Shnobu Hitaka] 2016/02/03 edit - end
        } else {
        	// [H28.4 �v�]][Shnobu Hitaka] 2016/02/03 add - begin �����A�g�Ή�
            QkanMessageList.getInstance().QO013_ERROR_OF_CONECT_CUSTOM(
                    "���ی��E���F����̎�荞��", 
                    ACConstants.LINE_SEPARATOR + "�ŐV��dbs�p�b�P�[�W(jma-receipt-dbs)���C���X�g�[�����邩�A" +
                    ACConstants.LINE_SEPARATOR + "�ݒ�ύX�E�����e�i���X��ʂŉ��ی��E���F����̎�荞�݃`�F�b�N���͂����Ă��������B");
            // [H28.4 �v�]][Shnobu Hitaka] 2016/02/03 add - end
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
        
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin �����Z�A�g�@�\�ǉ��Ή�
        //��ʏ�̃`�F�b�N��Ԃ�ۑ�����
        updateCheckState();
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end �����Z�A�g�@�\�ǉ��Ή�
        
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
            VRList list = getPageData(begin, end);
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
        
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin �����Z�A�g�@�\�ǉ��Ή�
        //��ʏ�̃`�F�b�N��Ԃ�ۑ�����
        updateCheckState();
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end �����Z�A�g�@�\�ǉ��Ή�
        
        // ���փ{�^��������
        int begin = (getNowPage() * PAGE_COUNT) + 1;
        int end = ((getNowPage() + 1) * PAGE_COUNT) + 1;
        // �y�[�W���� + 1
        setNowPage(getNowPage() + 1);
        // 1�y�[�W���f�[�^�擾
        VRList list = getPageData(begin, end);
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
        setAffairTitle("QO013", getButtons());

        // �e�[�u�����f�����쐬���ݒ肷��B
        ACTableModelAdapter receiptTable = new ACTableModelAdapter();

        // [ID:0000679][Shin Fujihara] 2012/01/23 edit �����Z�A�g�@�\�ǉ��Ή�
        //IMPORT_NO => SERIAL_ID�ɕύX
        receiptTable
                .setColumns(new String[] { "SERIAL_ID", "IMPORT_FLAG",
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

        // 2008/01/15 [Masahiko Higuchi] add - begin �����Z�A�g�Ή� version 5.3.8
        // �R���{�̒l��ݒ肷��B
        VRList versionComboList = new VRArrayList();
        // �R�[�h�}�X�^����I�����̎擾
        versionComboList = QkanCommon.getArrayFromMasterCode(
                CODE_RECEIPT_VERSION, "RECEIPT_VERSION_CONTENT");
        // �l�̐ݒ�
        getReceiptVersionCombo().setModel(versionComboList);
        // 2008/01/15 [Masahiko Higuchi] add - end

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
        
        
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin �����Z�A�g�@�\�ǉ��Ή�
        QkanReceiptSoftDBManager.initReceiptAccessSpace(getDBManager());
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end �����Z�A�g�@�\�ǉ��Ή�

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

        // 2008/01/15 [Masahiko Higuchi] add - begin �����Z�A�g�Ή� version 5.3.8
        // �ݒ�t�@�C�����Ǎ��߂邩�`�F�b�N����B
        if (ACFrame.getInstance().hasProperty(
                "ReceiptAccess/ReceiptSoftVersion")) {
            // �Ǎ��߂��ꍇ
            // �p�X���[�h��Ǎ��� receiptVersion �Ɋi�[����B
            setReceiptVersion(ACFrame.getInstance().getProperty(
                    "ReceiptAccess/ReceiptSoftVersion"));
        } else {
            setReceiptVersion(ACCastUtilities
                    .toString(DEFAULT_RECEIPT_VERSION_INDEX));
        }
        // 2008/01/15 [Masahiko Higuchi] add - end

        // [H28.4 �v�]][Shnobu Hitaka] 2016/02/26 add - begin �����A�g�Ή�
        // �ݒ�t�@�C�����Ǎ��߂邩�`�F�b�N����B
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/KaigoHoken")) {
            // �Ǎ��߂��ꍇ
            // �p�X���[�h��Ǎ��� toHiraganaConvert �Ɋi�[����B
            setKaigoHoken(ACFrame.getInstance().getProperty(
                    "ReceiptAccess/KaigoHoken"));
        } else {
        	setKaigoHoken("");
        }
        // [H28.4 �v�]][Shnobu Hitaka] 2016/02/26 add - end
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
        // 2008/01/15 [Masahiko Higuchi] add - begin �����Z�A�g�Ή� version 5.3.8
        setReceiptVersion(ACCastUtilities.toString(getReceiptVersionCombo()
                .getSelectedIndex()));
        // 2008/01/15 [Masahiko Higuchi] add - end

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

        // 2008/01/15 [Masahiko Higuchi] add - begin �����Z�A�g�Ή� version 5.3.8
        ACFrame.getInstance().getPropertyXML().setForceValueAt(
                "ReceiptAccess/ReceiptSoftVersion", getReceiptVersion());
        // 2008/01/15 [Masahiko Higuchi] add - end

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
                        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - begin �����Z�A�g�@�\�ǉ��Ή�
                        //�`�F�b�N��Ԃ́A�f�[�^�x�[�X�ɓo�^����Ă���l��M����
//                        VRBindPathParser.set("IMPORT_FLAG", destRow,
//                                new Boolean(false));
                        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - end �����Z�A�g�@�\�ǉ��Ή�
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
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin �����Z�A�g�@�\�ǉ��Ή�
        //�����Ɏ��Ԃ�������悤�ɂȂ����̂ŁA�X�v���b�V����ǉ�
        ACSplashable splash = ACFrame.getInstance().getFrameEventProcesser().createSplash("�����Z�f�[�^");
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end �����Z�A�g�@�\�ǉ��Ή�
        
        ACDBManager dbm = getDBManager();
        
        // [H28.4 �v�]][Shnobu Hitaka] 2016/02/03 add - begin �����A�g�Ή�
        ACDBManager insurerDbm = null;
        setImportMessage("");
        // [H28.4 �v�]][Shnobu Hitaka] 2016/02/03 add - end
        
        try {
            
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin �����Z�A�g�@�\�ǉ��Ή�
            //��U�A�`�F�b�N��Ԃ��m��
            updateCheckState();
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - end �����Z�A�g�@�\�ǉ��Ή�
            
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
                
                // [H28.4 �v�]][Shnobu Hitaka] 2016/02/03 add - begin �����A�g�Ή�
                if("1".equals(getKaigoHoken())){
	                // ���̓`�F�b�N��A���F�����o�^����B���ےP�ƂȂǂ̌�����͓o�^���Ȃ��B
	                // �ی��Ҕԍ�:6��
	                // ��ی��Ҕԍ�:10��
	                String insurerId = ACCastUtilities.toString(sqlParam.getData("INSURER_ID"));
	                String insuredId = ACCastUtilities.toString(sqlParam.getData("INSURED_ID"));
	                // �v����ԋ敪
	                String jotaiCode = ACCastUtilities.toString(sqlParam.getData("JOTAI_CODE"));
	                
	                // ��荞�߂Ȃ����҂̃��O���쐬����
	                String msg = "";
	                if (insurerId.length() != 6 && jotaiCode.length() > 0) {
	                	msg = "�F�ی��Ҕԍ����U���ɂ��Ă�������";
	                }
	                if (insuredId.length() != 10 && jotaiCode.length() > 0) {
	                	msg = "�F��ی��Ҕԍ����P�O���ɂ��Ă�������";
	                }
	                if (insurerId.length() == 0 && jotaiCode.length() > 0) {
	                	msg = "�F���F����ԂɗL���ȉ��ی���񂪑��݂��܂���B";
	                }
	                if (msg.length() > 0) {
		                msg = ACCastUtilities.toString(sqlParam.getData("PATIENT_FAMILY_NAME"))
		                	+ ACCastUtilities.toString(sqlParam.getData("PATIENT_FIRST_NAME"))
		                	+ msg
		                	+ ACConstants.LINE_SEPARATOR;
		                setImportMessage(getImportMessage() + msg);
	                }
	                
	                if (insurerId != null && insurerId.length() == 6
	                		&& insuredId != null && insuredId.length() == 10) {
	
	                    // ���p��ID���擾���AsqlParam�Ɋi�[����B
	                    String strSql = getSQL_GET_NEW_PATIENT_ID(sqlParam);
	                    VRList list = dbm.executeQuery(strSql);
	                    VRMap temp = (VRMap) list.get(0);
	                    VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities.toInt(VRBindPathParser.get(
	                    		"PATIENT_ID", temp)));
	                    
	                    // �ی��҂̓o�^�L���`�F�b�N
	                    strSql = getSQL_GET_INSURER_INFO(sqlParam);
	                    list = dbm.executeQuery(strSql);
	                    if (list.isEmpty()){
	                        String insureName = "�����Z�A�g���ی���";
	                        // �ی��҃}�X�^���疼�̂��擾����B�Ȃ���Ή��̖��̂Ƃ���B
	                        if (QkanSystemInformation.getInstance().isInsurerMasterDatabese()
	                        	    && insurerDbm == null) {
	                            insurerDbm = new QO002_M_InsurerBridgeFirebirdDBManager();
	                        }
	                        if (insurerDbm != null) {
	                            list = insurerDbm.executeQuery(getSQL_GET_FIND_M_INSURER_INFO(sqlParam));
	                            if (!list.isEmpty()){
	                                temp = (VRMap) list.get(0);
	                                insureName = ACCastUtilities.toString(VRBindPathParser.get("INSURER_NAME", temp));
	                            }
	                        }
	                        // �ی��҂�V�K�ǉ�
	                        VRBindPathParser.set("INSURER_NAME", sqlParam, insureName);
	                        dbm.executeUpdate(getSQL_INSERT_INSURER_INFO(sqlParam));
	                    } else {
	                        // �ی��҂̍폜�t���O��0�ɍX�V
	                        dbm.executeUpdate(getSQL_UPDATE_INSURER_INFO(sqlParam));
	                    }
	                    
	                    // �����l��ݒ肷��B
	                    VRBindPathParser.set("NINTEI_HISTORY_ID", sqlParam, new Integer(1));
	                    VRBindPathParser.set("SYSTEM_INSURE_VALID_START", sqlParam, sqlParam.getData("INSURE_VALID_START"));
	                    VRBindPathParser.set("SYSTEM_INSURE_VALID_END", sqlParam, sqlParam.getData("INSURE_VALID_END"));
	                    // ���ےP�Ƃ̏ꍇ�͋��t��0%�Ƃ���B
	                    if (QP001SpecialCase.isSeihoOnly(insuredId)) {
	                    	VRBindPathParser.set("INSURE_RATE", sqlParam, new Integer(0));
	                    } else {
	                    	VRBindPathParser.set("INSURE_RATE", sqlParam, new Integer(90));
	                    }
	                    // �����J���ȋK��̋敪�x�����x�z���擾����B
	                    int limitRate = -1;
	                    limitRate = QkanCommon.getOfficialLimitRate(dbm, ACCastUtilities.toDate(sqlParam.getData("INSURE_VALID_START")), 
	                    		new Integer(1), sqlParam.getData("JOTAI_CODE").toString());
	                    if (limitRate > 0) {
	                        VRBindPathParser.set("LIMIT_RATE", sqlParam, limitRate);
	                    }
	                    // �����J���ȋK��̊O�����p�^���t����P�ʐ����擾����B
	                    limitRate = QkanCommon.getOfficialLimitRate(dbm, ACCastUtilities.toDate(sqlParam.getData("INSURE_VALID_START")), 
	                    		new Integer(2), sqlParam.getData("JOTAI_CODE").toString());
	                    if (limitRate > 0) {
	                    	VRBindPathParser.set("EXTERNAL_USE_LIMIT", sqlParam, limitRate);
	                    }
	                    
	                    // ���F�����o�^����B
	                    strSql = getSQL_INSERT_NINTEI_HISTORY(sqlParam);
	                    dbm.executeUpdate(strSql);
	                }
                }
                // [H28.4 �v�]][Shnobu Hitaka] 2016/02/03 add - end
            }
            
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin �����Z�A�g�@�\�ǉ��Ή�
            //500���ȍ~����荞�ނɃ`�F�b�N�����Ă���ꍇ�́A�f�[�^�x�[�X�̃t���O�𖢃`�F�b�N�ōX�V
            if(getAllPageCheck().isSelected()){
                VRMap sqlParam = new VRHashMap();
                sqlParam.put("LOCAL_IP", QkanReceiptSoftDBManager.getLocalIP());
                dbm.executeUpdate(getSQL_UPDATE_RECEPT_INFO_ALL(sqlParam));
            }
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - end �����Z�A�g�@�\�ǉ��Ή�

            dbm.commitTransaction();
            // ��������I��
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            // ���[���o�b�N
            dbm.rollbackTransaction();
            return false;
        }
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin �����Z�A�g�@�\�ǉ��Ή�
        finally {
            if(splash!=null){
                splash.close();
                splash = null;
            }
        }
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end �����Z�A�g�@�\�ǉ��Ή�

    }

    /**
     * �u��荞�݊��Ҏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRList getInsertCheckedRows() throws Exception {
        // ����荞�݊��Ҏ擾����
        
        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - begin �����Z�A�g�@�\�ǉ��Ή�
        /*
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
        */
        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - end �����Z�A�g�@�\�ǉ��Ή�
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin �����Z�A�g�@�\�ǉ��Ή�
        VRList result = new VRArrayList();
        VRMap sqlParam = new VRHashMap();
        sqlParam.setData("LOCAL_IP", QkanReceiptSoftDBManager.getLocalIP());
        //500���ȍ~����荞�ނɃ`�F�b�N�����Ă���ꍇ�́A�f�[�^�x�[�X����o�^�p�̃f�[�^���擾����
        if(getAllPageCheck().isSelected()){
            VRList list = getDBManager().executeQuery(getSQL_GET_RECEPT_INFO_ALL_CHECKED(sqlParam));
            result = convertQkanData(list);
            
        //�`�F�b�N�����Ă��Ȃ��ꍇ�́A�\�����Ă���f�[�^�̂ݏ������s��
        } else {
            VRList list;
            Object obj = getReceiptTableModel().getAdaptee();
            if (obj instanceof VRList) {
                // list�ɕϊ�
                list = (VRList) obj;
            } else {
                // �ϊ��ł��Ȃ��ꍇ�͏����I��
                return result;
            }
            
            int count = list.getDataSize();
            for (int i = 0; i < count; i++) {
                VRMap row = (VRMap) list.getData(i);
                // �e�[�u���̈�s����t���O���`�F�b�N����B
                Object objs = row.getData("IMPORT_FLAG");
                if (objs instanceof Boolean) {
                    Boolean val = (Boolean) objs;
                    if (val.booleanValue()) {
                        result.add(row);
                    }
                }
            }
        }
        
        // �I������Ă�������Z�̃o�[�W�������m�F
        // �����l(4.0.0����)�̏ꍇ�́APTNUM�͎擾�ł��Ȃ��̂ŏ����I��
        if (getReceiptVersionCombo().getSelectedIndex() != DEFAULT_RECEIPT_VERSION_INDEX) {
            return result;
        }
        
        
        //4.0.0�ȏ�̏ꍇ�́APTNUM���擾����
        QkanReceiptSoftDBManager receiptDbm = null;
        
        try {
            receiptDbm = new QkanReceiptSoftDBManager(getIp(), ACCastUtilities.toInt(getPort()), getUser(), getPass(), getDbsVer());
            
        } catch (Exception e){
            VRLogger.warning("HOSPNUM�擾���A�����Z�[���Ƃ̐ڑ��Ɏ��s");
            return result;
        }
        
        VRMap findParam = new VRHashMap();
        findParam.put("tbl_ptnum.HOSPNUM", getHospNum());
        
        int count = result.getDataSize();
        for (int i = 0; i < count; i++) {
            VRMap row = (VRMap)result.get(i);
            
            // [Shnobu Hitaka] 2016/02/18 add - begin 1�x�擾������擾���Ȃ��i�A���œ������Ҏ捞�̏ꍇ���l���j
            String ptnumGetFlag = ACCastUtilities.toString(row.get("PTNUM_GET_FLAG"), null);
            if (ptnumGetFlag == null || ptnumGetFlag.length() == 0) {
            // [Shnobu Hitaka] 2016/02/18 add - end
            	
	            String patientCode = ACCastUtilities.toString(row.get("PATIENT_CODE"), null);
	            if (patientCode == null || patientCode.length() == 0) {
	                continue;
	            }
	            
	            findParam.put("tbl_ptnum.PTID", patientCode);
	            try {
	                
	                // �ʐM����
	                receiptDbm.executeSetUp();
	                Map sqlResult = receiptDbm.executeQueryData("tbl_ptnum", "key", findParam);
	                // �g�����U�N�V�����̏I��
	                receiptDbm.commitTransaction();
	                
	                patientCode = ACTextUtilities.trim(ACCastUtilities.toString(sqlResult.get("tbl_ptnum.PTNUM"), ""));
	                row.put("PATIENT_CODE", patientCode);
	                
	                // [Shnobu Hitaka] 2016/02/18 add 1�x�擾������擾�t���O��ON
	                row.put("PTNUM_GET_FLAG", "1");
	                
	            } catch (Exception e) {
	                VRLogger.warning(e);
	            }
	            
	        // [Shnobu Hitaka] 2016/02/18 add - begin
            }
            // [Shnobu Hitaka] 2016/02/18 add - end
            
            // [H28.4 �v�]][Shnobu Hitaka] 2016/01/20 add - begin �����A�g�Ή�
            if("1".equals(getKaigoHoken())){
            	try {
		            VRMap findCareParam = new VRHashMap();
		            String tekstymd = "";
		            String tekedymd = "";
		            Map sqlResult = new VRHashMap();
		            
		            String patientId = ACCastUtilities.toString(row.get("PTID"), null);
		            if (patientId == null || patientId.length() == 0) {
		                continue;
		            }
//	                �yTEST�zdbs�p�b�P�[�W�̒�`�́idbs.dbd�j�ɂ́A���ی��E���F���񂪂Ȃ��B
//	                ���̂܂ܐڑ������ꍇ�̓G���[�ƂȂ�̂ŏ����𒆒f����B�G���[�𖳎�����ƃ^�X�N���I�����Ȃ��̂Œ��ӁB
//	                ������Ńe�X�g�B
//	                findCareParam.clear();
//	                findCareParam.put("tbl_ptkohinf.HOSPNUM", getHospNum());
//	                findCareParam.put("tbl_ptkohinf.PTID", patientId);
//	                findCareParam.put("tbl_ptkohinf.KOHID", "1");
//	                // �ʐM����
//	                receiptDbm.executeSetUp();
//	                sqlResult = receiptDbm.executeQueryData("tbl_ptkohinf", "key2", findCareParam);
//	                // �g�����U�N�V�����̏I��
//	                receiptDbm.commitTransaction();
	
		            // ���F����擾
		            findCareParam.clear();
		            findCareParam.put("tbl_ptcare_nintei.HOSPNUM", getHospNum());
		            findCareParam.put("tbl_ptcare_nintei.PTID", patientId);
		            
		            // �ʐM����
		            receiptDbm.executeSetUp();
		            sqlResult = receiptDbm.executeQueryData("tbl_ptcare_nintei", "key2", findCareParam);
		            // �g�����U�N�V�����̏I��
		            receiptDbm.commitTransaction();
		            
		            if ((sqlResult != null) && (sqlResult.size() > 0)) {
		                String val = "";
		                // �E�v�J�n��TEKSTYMD�̎擾
		                tekstymd = ACTextUtilities.trim(ACCastUtilities.toString(sqlResult.get("tbl_ptcare_nintei.TEKSTYMD"), ""));
		                row.put("INSURE_VALID_START", ACCastUtilities.toDate(tekstymd));
		                // �E�v�I����TEKEDYMD�̎擾
		                tekedymd = ACTextUtilities.trim(ACCastUtilities.toString(sqlResult.get("tbl_ptcare_nintei.TEKEDYMD"), ""));
		                row.put("INSURE_VALID_END", ACCastUtilities.toDate(tekedymd));
		                // �v����ԋ敪CAREJOTAICD�̎擾
		                val = ACTextUtilities.trim(ACCastUtilities.toString(sqlResult.get("tbl_ptcare_nintei.CAREJOTAICD"), ""));
		                row.put("JOTAI_CODE", val);
		                // �F���NINTEIYMD�̎擾
		                val = ACTextUtilities.trim(ACCastUtilities.toString(sqlResult.get("tbl_ptcare_nintei.NINTEIYMD"), ""));
		                row.put("NINTEI_DATE", ACCastUtilities.toDate(val, null));
		            }
		
		            // ���ی����擾�i���F���񂪎擾�ł����ꍇ�̂݁j
		            if (tekstymd != null && tekstymd.length() > 0) {
		                findCareParam.clear();
		                findCareParam.put("tbl_ptcare_hkninf.HOSPNUM", getHospNum());
		                findCareParam.put("tbl_ptcare_hkninf.PTID", patientId);
		                findCareParam.put("tbl_ptcare_hkninf.TEKSTYMD", tekstymd);
		                findCareParam.put("tbl_ptcare_hkninf.TEKEDYMD", tekedymd);
		                
		                // �ʐM����
		                receiptDbm.executeSetUp();
		                sqlResult = receiptDbm.executeQueryData("tbl_ptcare_hkninf", "key1", findCareParam);
		                // �g�����U�N�V�����̏I��
		                receiptDbm.commitTransaction();
		                
		                //System.out.println(sqlResult);
		                if ((sqlResult != null) && (sqlResult.size() > 0)) {
			                String val = "";
			                // �ی��Ҕԍ�HKNJANUM�̎擾
			                val = ACTextUtilities.trim(ACCastUtilities.toString(sqlResult.get("tbl_ptcare_hkninf.HKNJANUM"), ""));
			                row.put("INSURER_ID", val);
			                // ��ی��Ҕԍ�HIHKNJANUM�̎擾
			                val = ACTextUtilities.trim(ACCastUtilities.toString(sqlResult.get("tbl_ptcare_hkninf.HIHKNJANUM"), ""));
			                row.put("INSURED_ID", val);
		                }
		                
		            }
		            //System.out.println(row);
            	} catch (Exception e) {
                    VRLogger.warning(e);
                    throw e;
                }
            }
            // [H28.4 �v�]][Shinobu Hitaka] 2016/01/20 add - end �����A�g�Ή�
            
        }
        
        try {
            // DBClose
            receiptDbm.close();
            // �O�̂��ߖ����I�ɏ�����
            receiptDbm = null;
            
        } catch (Exception e) {
            VRLogger.warning(e);
        }
        
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end �����Z�A�g�@�\�ǉ��Ή�
        
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

        // 2008/01/15 [Masahiko Higuchi] add - begin �����Z�A�g�Ή�
        // �p�X��null�łȂ����O�̂��߃`�F�b�N����
        if (getPass() != null) {
            // �󔒂��p�X���[�h�ɐݒ肳��Ă���ꍇ
            if (getPass().indexOf(" ") != -1 || getPass().indexOf("�@") != -1) {
                QkanMessageList.getInstance()
                        .QO013_ERROR_OF_BLANK_IN_PASSWORD();
                // �����I��
                getPassword().requestFocus();
                return;
            }
        }
        // 2008/01/15 [Masahiko Higuchi] add - end
        
        // 2011/10 [MantisID:0000655] [Shin.Fujihara] Addition - begin
        if (!checkReceiptFindKey()) {
            return;
        }
        // 2011/10 [MantisID:0000655] [Shin.Fujihara] Addition - end

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
                    
                    //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin �����Z�A�g�@�\�ǉ��Ή�
                    VRMap refiners = new VRHashMap();
                    refiners.put("AGE_START", getAgeStartText().getText());
                    refiners.put("AGE_END", getAgeEndText().getText());
                    refiners.put("DEDUPLICATION", new Boolean(getDeduplicationCheck().isSelected()));
                    //[ID:0000679][Shin Fujihara] 2012/01/23 add - end �����Z�A�g�@�\�ǉ��Ή�

                    // 2008/01/15 [Masahiko Higuchi] add - begin �����Z�A�g�Ή�
                    // ����W�����Z�v�g�\�t�g�̃o�[�W�����𔻒肷��
                    if (getReceiptVersionCombo().getSelectedIndex() != DEFAULT_RECEIPT_VERSION_INDEX) {
                        // 2008/01/15 [Masahiko Higuchi] add - end
                        // �X�g�A�h�v���V�[�W������ �����null
                        VRMap param = null;
                        // opass���猋�ʂ��擾
                        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - begin �����Z�A�g�@�\�ǉ��Ή�
//                        count = dbm.executeQuery(getDBManager(), "tbl_ptinf",
//                                "all", param, splash);
                        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - end �����Z�A�g�@�\�ǉ��Ή�
                        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin �����Z�A�g�@�\�ǉ��Ή�
                        count = dbm.executeQuery(getDBManager(), "tbl_ptinf",
                                "all", param, splash, refiners);
                        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end �����Z�A�g�@�\�ǉ��Ή�

                        // 2008/01/15 [Masahiko Higuchi] add - begin �����Z�A�g�Ή�
                    } else {
                        // HOSPNUM�擾�p�̊֐�����`
                        String key = "key";
                        VRMap initialParam = new VRHashMap();
                        HashMap hospNumResult = new HashMap();
                        initialParam.put("tbl_sysuser.USERID", getUser());
                        // �ʐM����
                        dbm.executeSetUp();

                        // ��UHOSPNUM���擾����B
                        hospNumResult = dbm.executeQueryData("tbl_sysuser",
                                key, initialParam);

                        // COMMIT
                        dbm.commitTransaction();

                        // ���ҏ��擾�p�̊֐�����`
                        key = "all";
                        // �ϐ�����
                        VRMap findParam = new VRHashMap();
                        // HOSPNUM�̎擾
                        Integer hospNum = ACCastUtilities.toInteger(
                                hospNumResult.get("tbl_sysuser.HOSPNUM"), 0);
                        // �����L�[�ݒ�
                        findParam.put("tbl_ptinf.HOSPNUM", hospNum);
                        // 2008/09/18 [Masahiko_Higuchi] add - begin �Ǘ��ԍ��̎擾�d�l��ύX
                        // HOSPNUM�̕ێ�
                        setHospNum(hospNum);
                        // 2008/09/18 [Masahiko_Higuchi] add - end
                        
                        // ���ҏ��擾
                        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - begin �����Z�A�g�@�\�ǉ��Ή�
//                        count = dbm.executeQuery(getDBManager(), "tbl_ptinf",
//                                key, findParam, splash);
                        //[ID:0000679][Shin Fujihara] 2012/01/23 delete - end �����Z�A�g�@�\�ǉ��Ή�
                        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin �����Z�A�g�@�\�ǉ��Ή�
                        count = dbm.executeQuery(getDBManager(), "tbl_ptinf",
                                key, findParam, splash, refiners);
                        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end �����Z�A�g�@�\�ǉ��Ή�

                        // �\�����Ă��銳�҂̕\���ԍ����擾����B

                        // TODO: ���҂̖{���̊��Ҕԍ����擾����B
                        // VRMap sendParam = new VRHashMap();
                        // sendParam.put("tbl_ptnum.HOSPNUM", hospNum);
                        // sendParam.put("tbl_ptnum.PTID", // �擾����PTID);
                        // count = dbm.executeQuery(getDBManager(), "tbl_ptnum",
                        // key, sendParam, splash);

                        // �I������
                        dbm.close();

                    }
                    // 2008/01/15 [Masahiko Higuchi] add - end

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

                // 2008/01/15 [Masahiko_Higuchi] add - begin �����Z�A�g version 3.0.5
            } else if ("Connection reset".equals(ex.getMessage())) {
                // �����Z�̃o�[�W�����I���Ƀ~�X�̉\���L��
                QkanMessageList
                        .getInstance()
                        .QO013_ERROR_OF_CONECT_CUSTOM(
                                "�ڑ�",
                                ACConstants.LINE_SEPARATOR
                                        + "�ʐM�̐ؒf�A�������͓���W�����Z�v�g�\�t�g�̃o�[�W�������قȂ�\��������܂��B"
                                        + ACConstants.LINE_SEPARATOR
                                        + "�ڑ��ݒ���m�F���Ă��������B");
                return;
                // 2008/01/15 [Masahiko_Higuchi] add - end

            } else if (cause == null) {
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
        VRList list = getPageData(getNowPage(), end);
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
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin �����Z�A�g�@�\�ǉ��Ή�
        //������Q�Ή�
        sqlParam.setData("LOCAL_IP", QkanReceiptSoftDBManager.getLocalIP());
        //[ID:0000679][Shin Fujihara] 2012/01/23 add - end �����Z�A�g�@�\�ǉ��Ή�
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
                            .substring(0, Math.min(16, first.length())));
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
                Date val = ACCastUtilities.toDate(obj, null);
                // ���t�^�ɕϊ��ł���p�^�[��
                if (val != null) {
                    // �ݒ�
                    VRBindPathParser.set("PATIENT_BIRTHDAY", row, val);
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
                        VRBindPathParser.set("PATIENT_ZIP_SECOND", row, "");
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
                if ((tels.length <= 0) || ACTextUtilities.isNullText(tels[0])) {
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
                    if (tels[0].length() > 10) {
                        // 9������葽���̂�2�A3�Ɛݒ�
                        telSrc = new String[3];
                        // �P�ݒ�
                        telSrc[0] = tels[0].substring(0, 6);
                        telSrc[1] = tels[0].substring(6, 10);
                        telSrc[2] = tels[0].substring(10, Math.min(14, tels[0]
                                .length()));
                    } else {
                        // 9����������2�߂܂�
                        telSrc = new String[2];
                        // �P�ݒ�
                        telSrc[0] = tels[0].substring(0, 6);
                        telSrc[1] = tels[0].substring(6, tels[0].length());

                    }
                    tels = telSrc;
                }

                // ���`���������񂩂�ݒ�
                switch (tels.length) {
                case 1:
                    VRBindPathParser.set("PATIENT_TEL_FIRST", row, tels[0]
                            .substring(0, Math.min(6, tels[0].length())));
                    VRBindPathParser.set("PATIENT_TEL_SECOND", row, "");
                    VRBindPathParser.set("PATIENT_TEL_THIRD", row, "");
                    break;
                case 2:
                    VRBindPathParser.set("PATIENT_TEL_FIRST", row, tels[0]
                            .substring(0, Math.min(6, tels[0].length())));
                    VRBindPathParser.set("PATIENT_TEL_SECOND", row, tels[1]
                            .substring(0, Math.min(4, tels[1].length())));
                    VRBindPathParser.set("PATIENT_TEL_THIRD", row, "");
                    break;
                default:
                    VRBindPathParser.set("PATIENT_TEL_FIRST", row, tels[0]
                            .substring(0, Math.min(6, tels[0].length())));
                    VRBindPathParser.set("PATIENT_TEL_SECOND", row, tels[1]
                            .substring(0, Math.min(4, tels[1].length())));
                    VRBindPathParser.set("PATIENT_TEL_THIRD", row, tels[2]
                            .substring(0, Math.min(4, tels[2].length())));
                    break;
                }

            }

        }

        // �����l��ݒ�
        for (int i = 0; i < size; i++) {
            VRMap row = (VRMap) src.getData(i);
            //[ID:0000679][Shin Fujihara] 2012/01/23 delete - begin �����Z�A�g�@�\�ǉ��Ή�
            //VRBindPathParser.set("IMPORT_FLAG", row, new Boolean(true));
            //[ID:0000679][Shin Fujihara] 2012/01/23 delete - end �����Z�A�g�@�\�ǉ��Ή�
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - begin �����Z�A�g�@�\�ǉ��Ή�
            if (ACCastUtilities.toInt(VRBindPathParser.get("CHECKED", row), 0) == 1) {
                VRBindPathParser.set("IMPORT_FLAG", row, new Boolean(true));
            } else {
                VRBindPathParser.set("IMPORT_FLAG", row, new Boolean(false));
            }
            //[ID:0000679][Shin Fujihara] 2012/01/23 add - end �����Z�A�g�@�\�ǉ��Ή�
            
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
        // 2008/01/15 [Masahiko Higuchi] add - begin �����Z�A�g�Ή� version 5.3.8
        // ����W�����Z�v�g�\�t�g�o�[�W�������R���{��ݒ肷��B
        getReceiptVersionCombo().setSelectedIndex(
                ACCastUtilities.toInt(getReceiptVersion(),
                        DEFAULT_RECEIPT_VERSION_INDEX));
        // 2008/01/15 [Masahiko Higuchi] add - end
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
        StringBuilder sb = new StringBuilder();
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

    /**
     * ��ʂ̃`�F�b�N��Ԃ��X�V���܂��B
     */
    @Override
    public void updateCheckState() throws Exception {
        VRList list;
        Object obj = getReceiptTableModel().getAdaptee();
        if (obj instanceof VRList) {
            // list�ɕϊ�
            list = (VRList) obj;
        } else {
            // �ϊ��ł��Ȃ��ꍇ�͏����I��
            return;
        }
        
        //�`�F�b�N����Ă���V���A��ID
        List<Object> checkedList = new ArrayList<Object>();
        //�`�F�b�N����Ă��Ȃ��V���A��ID
        List<Object> uncheckedList = new ArrayList<Object>();
        
        int count = list.size();
        for (int i = 0; i < count; i++) {
            VRMap row = (VRMap) list.getData(i);
            // �e�[�u���̈�s����t���O���`�F�b�N����B
            Object objs = row.getData("IMPORT_FLAG");
            if (objs instanceof Boolean) {
                Boolean val = (Boolean) objs;
                if (val.booleanValue()) {
                    checkedList.add(row.getData("SERIAL_ID"));
                } else {
                    uncheckedList.add(row.getData("SERIAL_ID"));
                }
            }
        }
        
        VRMap sqlParam = new VRHashMap();
        sqlParam.setData("LOCAL_IP", QkanReceiptSoftDBManager.getLocalIP());
        
        if (!checkedList.isEmpty()) {
            sqlParam.put("CHECKED", new Integer(1));
            sqlParam.put("SERIAL_ID", checkedList.toArray());
            getDBManager().executeUpdate(getSQL_UPDATE_RECEPT_INFO(sqlParam));
        }
        
        if (!uncheckedList.isEmpty()) {
            sqlParam.put("CHECKED", new Integer(0));
            sqlParam.put("SERIAL_ID", uncheckedList.toArray());
            getDBManager().executeUpdate(getSQL_UPDATE_RECEPT_INFO(sqlParam));
        }
        
    }
    
    /**
     * ���������̃`�F�b�N���s���܂��B
     * 
     * @return
     * @author Masahiko.Higuchi
     * @since 3.1.5
     * @throws Exception
     */
    public boolean checkReceiptFindKey() throws Exception {

        String ageStartString = getAgeStartText().getText();
        String ageEndString = getAgeEndText().getText();
        int ageStart = ACCastUtilities.toInt(ageStartString, 0);
        int ageEnd = ACCastUtilities.toInt(ageEndString, 0);

        if (!"".equals(ageStartString) && !"".equals(ageEndString)) {
            if (ageStart > ageEnd) {
                ACMessageBox.showExclamation("�N��̊J�n�ƏI���̓��͂��t�]���Ă��܂��B");
                getAgeStartText().transferFocus();
                return false;
            }
        }

        return true;
    }
}
