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
 * �쐬��: 2005/12/20  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑� (O)
 * �v���Z�X �ݒ�ύX�E�����e�i���X (005)
 * �v���O���� �ݒ�ύX�E�����e�i���X (QO005)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo005;

import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.filechooser.ACFileChooser;
import jp.nichicom.ac.filechooser.ACFileFilter;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.bridge.sql.BridgeFirebirdDBManager;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �ݒ�ύX�E�����e�i���X(QO005)
 */
public class QO005 extends QO005Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QO005() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * �������������s�Ȃ��܂��B
     * 
     * @param affair
     *            �Ɩ����
     * @throws Exception
     *             ������O
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        // Mac OS��������PDF�ݒ�R���e�i��\�����Ȃ�
        final String osName = String.valueOf(System.getProperty("os.name"))
                .toLowerCase();
        if (osName.indexOf("mac") >= 0) {
            getPdfFileSelects().setVisible(false);
        }

        // �X�i�b�v�V���b�g�̎B�e�Ώۂ��w�肷��B
        getSnapshot().setRootContainer(getContents());
        // �ݒ�t�@�C������A�ݒ�����擾����B

        // loadSettingFile();
        doLoad();

        // ��ʂ́uIP(serverSelectIpText)�v�̏�Ԃ�����������B
        setServerSelectIpTextState();

        // �ߋ��̎��Ə��̐��͈�x��\����
        getShowOldLowProviderElements().setVisible(false);
        
        // ��ʂ̒l�̏��������s���B
        setInitValue();

    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // ���I������
        // ���X�i�b�v�V���b�g�`�F�b�N
        // �X�i�b�v�V���b�g�̍X�V�`�F�b�N���s���B
        if (getSnapshot().isModified()) {
            // �X�V����Ă��Ȃ��ꍇ
            // �V�X�e�����I������B
            return true;
        }
        // �X�V����Ă���ꍇ
        // �������p������B
        // ���ۑ��m�F
        // �ۑ��m�F�̃��b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_CLOSE_ON_MODIFIED
        QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED();
        boolean loopFlg = false;

        do {
            // �uOK�v�I����
            // �������p������B
            if (QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED() == SELECT_OK) {
                // �u�L�����Z���v�I����
                // �����𒆒f����B
                return true;
            }
            // ���ۑ�����
            // �ۑ��������s���B
            if (doSave()) {

                // �ۑ�����������I�������ꍇ
                // �V�X�e�����I������B
                return true;
            } else {
                // �ۑ��������ُ�I�������ꍇ
                // �����𒆒f����B
                return false;
            }
        } while (loopFlg);
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�ݒ�t�@�C���̍X�V�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {
        // ���ۑ�����
        // �ݒ���̕ۑ��������s���B
        if (doSave()) {
            QkanMessageList.getInstance().UPDATE_SUCCESSED();
            setUpdateSuccessed(true);
        }
    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        if (getUpdateSuccessed()) {
            // �X�V�����ꍇ�̓��C�����j���[�ł͂Ȃ����O�C����ʂ֑J�ڂ�����
            List history = ACFrame.getInstance().getTraceAffairs();
            if (history != null) {
                int size = history.size();
                if (size > 2) {
                    // ���O�̉�ʁi���C�����j���[�j���Ȃ��������Ƃɂ���
                    ACFrame.getInstance().getTraceAffairs().remove(size - 2);
                }
            }
            QkanMessageList.getInstance().QO005_AUTO_LOGOUT();
        }
        return true;
    }

    /**
     * �u��ʂ̏�Ԑݒ�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void serverSelectRadiosActionPerformed(ActionEvent e)
            throws Exception {
        // ����ʂ̏�Ԑݒ�
        // ��ʂ́uIP(serverSelectIpText)�v�̏�Ԃ�ݒ肷��B
        setServerSelectIpTextState();
    }

    /**
     * �uDB�t�@�C���Q�Ɓv�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void dbFileSelectFileCompareButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ���t�@�C���I������
        ACFileChooser DBfileChooser = new ACFileChooser();
        ACFileFilter DBFilefilter = new ACFileFilter();
        DBFilefilter.setFileExtensions(new String[] { "fdb" });
        DBFilefilter.setDescription("�f�[�^�x�[�X�t�@�C��(*.fdb)");

        // �t�@�C���I���_�C�A���O���J���B
        File selectFile = null;
        String defaultPath = "";
        if (ACFrame.getInstance().hasProperty("DBConfig/Path")) {
            defaultPath = (new File(getProperty("DBConfig/Path")).getParent());
        } else {
            defaultPath = (new File(".").getAbsolutePath());
        }
        selectFile = DBfileChooser.showOpenDialog(defaultPath, "",
                "�g�p����f�[�^�x�[�X�t�@�C�����w�肵�ĉ������B", DBFilefilter.getFileExtensions(),
                DBFilefilter.getDescription());

        // �L�����Z�����͒��f
        if (selectFile == null) {
            return;
        }

        // �擾�����t�@�C������g���q��⊮����
        selectFile = new File(selectFile.getParent(),
                getFBFilePathWithExtension(selectFile.getName(), 1,
                        FB_FILE_EXTENSIONS));

        // �t�@�C�����݃`�F�b�N
        if (!selectFile.exists()) {
            QkanMessageList.getInstance().QO005_ERROR_OF_NOT_A_DATABASE();
            return;

        }

        // �������R�[�h
        if (!VRCharType.ONLY_HALF_CHAR.isMatch(String.valueOf(String
                .valueOf(selectFile)))) {
            getDbFileSelectFileName().requestFocus();
            QkanMessageList.getInstance()
                    .QO005_ERROR_OF_DBPATH_INCLUDE_JAPANESE_CHAR();
            return;
        }

        // �t�@�C�����I�����ꂽ�ꍇ
        // �I�����ꂽ�t�@�C�������A��ʂ́u�t�@�C����(dbFileSelectFileName)�v�ɐݒ肷��B
        if (selectFile.exists()) {
            getDbFileSelectFileName().setText(String.valueOf(selectFile));
            return;
        }

        // �t�@�C�����I������Ȃ������ꍇ
        // �������Ȃ��B
    }

    /**
     * �uFDB�t�@�C���o�b�N�A�b�v�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void backupActionPerformed(ActionEvent e) throws Exception {
        // ��FDB�t�@�C���̃o�b�N�A�b�v
        if (ACTextUtilities.isNullText(getDbFileSelectFileName().getText())) {
            QkanMessageList.getInstance().QO005_ERROR_OF_EMPTY_DBFILE_PATH();
            return;
        }
        // �v���p�e�B�t�@�C���p�X�Ɖ�ʂ̃t�@�C���p�X���ꐫ�`�F�b�N
        File properityPath = null;
        if (ACFrame.getInstance().hasProperty("DBConfig/Path")) {
            properityPath = new File(getProperty("DBConfig/Path"));
        }

        File displayPath = new File(getDbFileSelectFileName().getText());
        if (!displayPath.equals(properityPath)) {
            QkanMessageList.getInstance()
                    .QO005_ERROR_OF_NOT_SAME_PROPERTY_DBPATH();
            return;
        }

        // ��DB�T�[�o�[���`�F�b�N
        // ��ʂ́u�T�[�o���(serverSelectRadios)�v�̒l���`�F�b�N����B
        if (getServerSelectRadios().getSelectedIndex() == SERVER_RADIO_LOCAL) {
            // 1(���[�J��)�̏ꍇ
            // �������p������B
        } else if (getServerSelectRadios().getSelectedIndex() == SERVER_RADIO_REMOTE) {
            // 2(���̃R���s���[�^)�̏ꍇ
            // �G���[���b�Z�[�W��\������B ID = QO005_ERROR_OF_USER_OTHER_COMPUTER
            // �����𒆒f����B
            QkanMessageList.getInstance().QO005_ERROR_OF_USER_OTHER_COMPUTER();
            return;
        }

        // MEMO loopFlg��true�ł������LOOP
        // ���t�@�C���I���_�C�A���O
        ACFileChooser DBfileChooser = new ACFileChooser();
        ACFileFilter DBFilefilter = new ACFileFilter();
        DBFilefilter.setFileExtensions(new String[] { "old", "fdb" });
        DBFilefilter.setDescription("�f�[�^�x�[�X�t�@�C��(*.old|*.fdb)");

        // ������
        // �ޔ��FDB�t�@�C���p�X�ۑ��p�̕ϐ� backupPath ���`����B(������)
        String backupPath = new File(getProperty("DBConfig/Path")).getParent()
                + FILE_SEPARATOR + "QKANOLD.FDB";
        File saveFile = null;

        // ���t�@�C���I������
        // �t�@�C���I���_�C�A���O(�ۑ�)��\������B
        saveFile = DBfileChooser
                .showSaveDialog(
                        new File(getProperty("DBConfig/Path")).getParent(),
                        getDefaultFileName("old"),
                        "�f�[�^�x�[�X�t�@�C���̕ۑ��ꏊ�Ƒޔ��t�@�C�������w�肵�ĉ������B",
                        DBFilefilter.getFileExtensions(),
                        DBFilefilter.getDescription());

        if (!(saveFile == null)) {

            // �t�@�C�����I�����ꂽ�ꍇ
            // �擾�����t�@�C������g���q��⊮����
            saveFile = new File(saveFile.getParent(),
                    getFBFilePathWithExtension(saveFile.getName(), 1,
                            FB_FILE_EXTENSIONS));

            // backupPath�ɁA�I�����ꂽ�t�@�C���̃p�X���i�[����B
            // �������p������B
            backupPath = String.valueOf(saveFile);

        } else {
            // �t�@�C�����I������Ȃ������ꍇ
            // �����𒆒f����B
            return;
        }

        // ���w�肳�ꂽ�ޔ��`�F�b�N
        // backupPath���`�F�b�N����B
        if (backupPath.equals(getProperty("DBConfig/Path"))) {
            // ���ݎg�p����FDB�t�@�C����I�������ꍇ
            // �G���[���b�Z�[�W��\������B ID = QO005_ERROR_OF_BACKUP_SAME_TO_USED
            QkanMessageList.getInstance().QO005_ERROR_OF_BACKUP_SAME_TO_USED();
            // �u���t�@�C���I���_�C�A���O�v�ɖ߂�B(��9)
            return;
        }

        // ���ݎg�p���ȊO��FDB�t�@�C����I�������ꍇ
        // �������p������B
        // ���ޔ��t�@�C�����`�F�b�N
        // �w�肳�ꂽ�ޔ��t�@�C�������ɑ��݂��Ă��邩�ǂ����`�F�b�N����B
        if (saveFile.exists()) {
            // ���݂���ꍇ
            // ���㏑�m�F
            // �㏑�m�F���b�Z�[�W��\������B ID = QO005_QUESTION_OF_EXIST_SELECTED_FDB

            if (QkanMessageList.getInstance()
                    .QO005_QUESTION_OF_EXIST_SELECTED_FDB() == SELECT_CANCEL) {
                // �u�L�����Z���v�I����
                // �u���t�@�C���I���_�C�A���O�v�ɖ߂�B(��9)
                return;
            }
            // �������p������B
        }

        // ���J�n�m�F
        // �ޔ������J�n�m�F���b�Z�[�W��\������B ID = QO005_QUESTION_OF_TO_START_BACKUP
        if (QkanMessageList.getInstance().QO005_QUESTION_OF_TO_START_BACKUP() == SELECT_CANCEL) {
            // �u�L�����Z���v�I����
            // �����𒆒f����B
            return;
        }

        // �uOK�v�I����
        // �������p������B
        // ����I�������ꍇ
        // ����I���ʒm���b�Z�[�W��\������B ID = QO005_BACKUP_SUCCESSED
        try {
            fileCpy(getProperty("DBConfig/Path"), String.valueOf(saveFile));
            QkanMessageList.getInstance().QO005_BACKUP_SUCCESSED();
        } catch (Exception ex) {
            // ���G���[�g���b�v
            // ��L�o�b�N�A�b�v�����ŃG���[�����������ꍇ
            // �G���[�����ʒm���b�Z�[�W��\������B ID = QO005_BACKUP_FAILED
            QkanMessageList.getInstance().QO005_BACKUP_FAILED();
        }

    }

    /**
     * �uFDB�t�@�C�����X�g�A�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void restoreActionPerformed(ActionEvent e) throws Exception {
        // ��FDB�t�@�C���̃��X�g�A
        // ������
        // ��������FDB�t�@�C���p�X�ۑ��p�̕ϐ� restorePath ���`����B(������)
        String restorePath = null;
        // ���s��FDB�t�@�C���̑ޔ��p�X�ۑ��p�̕ϐ� backupPath ���`����B(������)
        String backupPath = null;
        // ��������FDB�̐ڑ��`�F�b�N���s���ׂɈ�x�ޔ�����A�ޔ��t�@�C���p�X(������)
        String checkPath = null;

        // ��DB�T�[�o�[���`�F�b�N
        // ��ʂ́u�T�[�o���(serverSelectRadios)�v�̒l���`�F�b�N����B
        // 1(���[�J��)�̏ꍇ
        // �������p������B
        if (getServerSelectRadios().getSelectedIndex() == SERVER_RADIO_REMOTE) {
            // 2(���̃R���s���[�^)�̏ꍇ
            // �G���[���b�Z�[�W��\������B ID = QO005_ERROR_OF_USER_OTHER_COMPUTER
            QkanMessageList.getInstance().QO005_ERROR_OF_USER_OTHER_COMPUTER();
            // �����𒆒f����B
            return;
        }

        if (ACTextUtilities.isNullText(getDbFileSelectFileName().getText())) {
            QkanMessageList.getInstance().QO005_ERROR_OF_EMPTY_DBFILE_PATH();
            return;
        }
        // �v���p�e�B�t�@�C���p�X�Ɖ�ʂ̃t�@�C���p�X���ꐫ�`�F�b�N
        File properityPath = null;
        if (ACFrame.getInstance().hasProperty("DBConfig/Path")) {
            properityPath = new File(getProperty("DBConfig/Path"));
        }

        File displayPath = new File(getDbFileSelectFileName().getText());
        if (!displayPath.equals(properityPath)) {
            QkanMessageList.getInstance()
                    .QO005_ERROR_OF_NOT_SAME_PROPERTY_DBPATH();
            return;
        }

        // ���t�@�C���I���_�C�A���O
        ACFileChooser DBfileChooser = new ACFileChooser();
        ACFileFilter DBFilefilter = new ACFileFilter();
        DBFilefilter.setFileExtensions(new String[] { "old", "fdb" });
        DBFilefilter.setDescription("�f�[�^�x�[�X�t�@�C��(*.old|*.fdb)");
        File restoreFile = null;
        // ���t�@�C���I������
        // �t�@�C���I���_�C�A���O(�J��)��\������B
        restoreFile = DBfileChooser.showOpenDialog(new File(
                getProperty("DBConfig/Path")).getParent(), "",
                "�ޔ������f�[�^�x�[�X�t�@�C�����w�肵�ĉ������B", DBFilefilter.getFileExtensions(),
                DBFilefilter.getDescription());

        if (!(restoreFile == null)) {

            // �t�@�C�����I�����ꂽ�ꍇ
            // �擾�����t�@�C������g���q��⊮����
            restoreFile = new File(restoreFile.getParent(),
                    getFBFilePathWithExtension(restoreFile.getName(), 1,
                            FB_FILE_EXTENSIONS));

            // restorePath�ɁA�I�����ꂽ�t�@�C���̃p�X���i�[����B
            // �������p������B
            restorePath = String.valueOf(restoreFile);

        } else {
            // �t�@�C�����I������Ȃ������ꍇ
            // �����𒆒f����B
            return;
        }

        // ���w�肳�ꂽ�ޔ��`�F�b�N(���sFDB�Ƃ̓���`�F�b�N)
        // restorePath���`�F�b�N����B
        if (restorePath.equals(getProperty("DBConfig/Path"))) {
            // ���ݎg�p����FDB�t�@�C����I�������ꍇ
            // �G���[���b�Z�[�W��\������B ID = QO005_ERROR_OF_BACKUP_SAME_TO_RESTORE
            QkanMessageList.getInstance()
                    .QO005_ERROR_OF_BACKUP_SAME_TO_RESTORE();
            // �u���t�@�C���I���_�C�A���O�v�ɖ߂�B(��12)
            return;
        }

        // DB�ڑ����`�F�b�N����ׂɃ��X�g�A�t�@�C�����e���|�����̈�ɃR�s�[���ă`�F�b�N���s��
        checkPath = new File(getProperty("DBConfig/Path")).getParent()
                + FILE_SEPARATOR + "QKANCHECK.FDB";
        try {
            fileCpy(restorePath, checkPath);
        } catch (Exception ex) {
            // ���G���[�g���b�v
            // ��L���X�g�A�����ŃG���[�����������ꍇ
            // �G���[�����ʒm���b�Z�[�W��\������B ID = QO005_RESTORE_FAILED
            QkanMessageList.getInstance()
                    .QO005_ERROR_OF_COPY_DBFILE_TEMP_FAILED();
            return;
        }

        // �`�F�b�N��p�X�ɑ΂��ċ^���I�Ƀv���p�e�B�t�@�C����͂���map���쐬����B
        VRMap checkParams = new VRHashMap();
        // �i�[�Ώۂ�DB�̃t�@�C���p�X�ƃ��[�J���A�����[�g���ʂ̃��W�I�݂̂ŁA���̓��\�b�h�����Ńv���p�e�B�t�@�C���������Ă���
        checkParams.setData("DB_FILE_SELECT_FILE_NAME", checkPath);
        checkParams.setData("SERVER_SELECT_RADIOS", new Integer(
                SERVER_RADIO_LOCAL));
        
        switch(checkDBConnect(checkParams)) {
        case DB_CONNECT_ERROR:
            // �ڑ��`�F�b�N�Őڑ��ł��Ȃ������ꍇ
            QkanMessageList.getInstance().QO005_ERROR_OF_NOT_FIREBIRD_DB();
            return;
        case DB_SCHEMA_ERROR:
            //�X�L�[�}�o�[�W�������Â��ꍇ
            QkanMessageList.getInstance().QO005_ERROR_OF_SCHEMA_VERSION();
            return;
        }

        try {
            // �e���|�����t�@�C���̍폜
            new File(checkPath).delete();
        } catch (Exception ex) {
            // ���G���[�g���b�v
            // �e���|�����t�@�C���̍폜�ŃG���[�����������ꍇ
            // �G���[�����ʒm���b�Z�[�W��\������B ID = QO005_ERROR_OF_COPY_DBFILE_TEMP_FAILED
            QkanMessageList.getInstance()
                    .QO005_ERROR_OF_DELETE_DBFILE_TEMP_FAILED();
            return;
        }

        // �����sDB�ޔ��m�F
        // backupPath�� (���݂�FDB�t�@�C���̃t�H���_) + "qkanold.fdb"���i�[����B
        //
        backupPath = new File(getProperty("DBConfig/Path")).getParent()
                + FILE_SEPARATOR + "QKANOLD.FDB";
        File backupFile = new File(backupPath);

        // �ł��A���X�g�A��������QKANOLD.FDB�������Ȃ�ďꍇ
        if (backupFile.equals(restoreFile)) {
            // �o�b�N�A�b�v����ׂ̃t�@�C����OLD2�Ƃ��ς��Ă݂�
            backupPath = new File(getProperty("DBConfig/Path")).getParent()
                    + FILE_SEPARATOR + "QKANOLD2.FDB";
            backupFile = new File(backupPath);
        }

        // ���sDB�ޔ��m�F���b�Z�[�W��\������B ID = QO005_QUESTION_OF_BACKUP_FILENAME
        // �uOK�v��I�������ꍇ
        // �������p������B
        if (QkanMessageList.getInstance().QO005_QUESTION_OF_BACKUP_FILENAME(
                restorePath, backupFile.getAbsolutePath()) == SELECT_CANCEL) {
            // �u�L�����Z���v��I�������ꍇ
            // �����𒆒f����B
            return;
        }

        if (backupFile.exists()) {
            // ���݂���ꍇ
            // �u���㏑�m�F�v�ցB(��44)
            // ���݂��Ȃ��ꍇ
            // �u���J�n�m�F�v�ցB(��71)
            // ���㏑�m�F
            // �㏑�m�F���b�Z�[�W��\������BID = QO005_QUESTION_OF_EXIST_SELECTED_FDB
            if (QkanMessageList.getInstance()
                    .QO005_QUESTION_OF_EXIST_SELECTED_FDB() == SELECT_CANCEL) {
                // �uOK�v�I����
                // �u���J�n�m�F�v�ցB(��71)
                // �u�L�����Z���v�I����
                // �u���ޔ��t�@�C���I���_�C�A���O�v�ցB(��50)

                // ���ޔ��t�@�C���I���_�C�A���O
                ACFileChooser backupFileChooser = new ACFileChooser();
                ACFileFilter backupFilefilter = new ACFileFilter();
                backupFilefilter.setFileExtensions(new String[] { "fdb" });
                backupFilefilter.setDescription("�f�[�^�x�[�X�t�@�C��(*.fdb)");
                // �t�@�C���I���_�C�A���O(�ۑ�)��\������B
                backupFile = backupFileChooser.showSaveDialog(new File(
                        getProperty("DBConfig/Path")).getParent(), "",
                        "�f�[�^�x�[�X�t�@�C���̕ۑ��ꏊ�Ƒޔ��t�@�C�������w�肵�ĉ������B", DBFilefilter
                                .getFileExtensions(), DBFilefilter
                                .getDescription());

                if (!(backupFile == null)) {

                    // �t�@�C�����I�����ꂽ�ꍇ
                    // �擾�����t�@�C������g���q��⊮����
                    backupFile = new File(backupFile.getParent(),
                            getFBFilePathWithExtension(backupFile.getName(), 1,
                                    FB_FILE_EXTENSIONS));

                    // backupPath�ɁA�I�����ꂽ�t�@�C���̃p�X���i�[����B
                    // �������p������B
                    backupPath = String.valueOf(backupFile);

                } else {
                    // �t�@�C�����I������Ȃ������ꍇ
                    // �����𒆒f����B
                    return;
                }

                // ���ޔ��t�@�C���`�F�b�N(���s�t�@�C���Ɠ���łȂ���)
                // backupPath���`�F�b�N����B
                if (backupPath.equals(getProperty("DBConfig/Path"))) {
                    // ���ݎg�p����FDB�t�@�C����I�������ꍇ
                    // �G���[���b�Z�[�W��\������B ID =
                    // QO005_ERROR_OF_BACKUP_SAME_TO_USED
                    QkanMessageList.getInstance()
                            .QO005_ERROR_OF_BACKUP_SAME_TO_USED();
                    // �u���ޔ��t�@�C���I���_�C�A���O�v�֖߂�B(��50)
                    return;
                }

                // ���ݎg�p���ȊO��FDB�t�@�C����I�������ꍇ
                // �������p������B
                if (backupPath.equals(restorePath)) {
                    // ���ޔ��t�@�C����(�������t�@�C���Ɠ���łȂ���)
                    // backupPath���`�F�b�N����B
                    // �ޔ��t�@�C�����Ɠ���̏ꍇ
                    // �G���[���b�Z�[�W��\������B ID =
                    // QO005_ERROR_OF_BACKUP_SAME_TO_RESTORE
                    QkanMessageList.getInstance()
                            .QO005_ERROR_OF_BACKUP_SAME_TO_RESTORE();
                    // �u���ޔ��t�@�C���I���_�C�A���O�v�֖߂�B(��50)
                    return;
                }
                // �ޔ��t�@�C�����ƈقȂ�ꍇ
                // �u���J�n�m�F�v�ցB(��71)
            }
        }

        // ���J�n�m�F
        // �����J�n�m�F���b�Z�[�W��\������BID = QO005_QUESTION_OF_TO_START_RESTORE
        if (QkanMessageList.getInstance().QO005_QUESTION_OF_TO_START_RESTORE() == SELECT_CANCEL) {
            // �uOK�v�I����
            // �������p������B
            // �u�L�����Z���v�I����
            // �����𒆒f����B
            return;
        }

        // �����X�g�A����
        try {
            // �v�[�����Ă���R�l�N�V�����������I�ɊJ������B
            BridgeFirebirdDBManager dbm = new BridgeFirebirdDBManager();
            if (dbm.isAvailableDBConnection()) {
                dbm.releaseAll();
            } else {
                dbm.releaseAll();
            }

            // ���sFDB��backupPath�ɃR�s�[(�㏑)����B
            fileCpy(getProperty("DBConfig/Path"), backupPath);

        } catch (Exception ex) {
            // ���G���[�g���b�v
            // ��L���X�g�A�����ŃG���[�����������ꍇ
            // �G���[�����ʒm���b�Z�[�W��\������B ID = QO005_RESTORE_FAILED
            // �f�[�^�x�[�X�̐ڑ��J�������������͌��sDB�̑ޔ��Ɏ��s���܂����B
            QkanMessageList.getInstance().QO005_RESTORE_FAILED_COPY();
            return;
        }

        try {
            // restorePath��FDB�t�@�C�������sFDB�ɏ㏑����B
            fileCpy(restorePath, getProperty("DBConfig/Path"));

            // ����I�������ꍇ
            // �ŗ����Đݒ肷��B
            checkTax();

            // ����I���ʒm���b�Z�[�W��\������B ID = QO005_RESTORE_SUCCESSED
            QkanMessageList.getInstance().QO005_RESTORE_SUCCESSED();

            setUpdateSuccessed(true);
        } catch (Exception ex) {
            // ���G���[�g���b�v
            // ��L���X�g�A�����ŃG���[�����������ꍇ
            // �G���[�����ʒm���b�Z�[�W��\������B ID = QO005_RESTORE_FAILED
            // �����pDB�̃t�@�C���ړ��Ɏ��s���܂����B
            QkanMessageList.getInstance().QO005_RESTORE_FAILED_FILEIO();
            return;
        }

    }

    /**
     * �uPDF�t�@�C���Q�Ɓv�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void pdfFileSelectFileCompareButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ���t�@�C���I������
        ACFileChooser pdffileChooser = new ACFileChooser();
        ACFileFilter pdfFilefilter = new ACFileFilter();
        pdfFilefilter.setFileExtensions(new String[] { "exe" });
        pdfFilefilter.setDescription("PDF�r���A�[�v���O����(*.exe)");

        File pdfViewerExecuteFile = null;

        // �t�@�C���I���_�C�A���O���J���B
        pdfViewerExecuteFile = pdffileChooser.showOpenDialog(
                "�g�p����PDF�t�@�C���{���v���O�������w�肵�Ă��������B",
                pdfFilefilter.getFileExtensions(),
                pdfFilefilter.getDescription());

        // �L�����Z�����͒��f
        if (pdfViewerExecuteFile == null) {
            return;
        }

        // �擾�����t�@�C������g���q��⊮����
        pdfViewerExecuteFile = new File(pdfViewerExecuteFile.getParent(),
                getPDFFilePathWithExtension(pdfViewerExecuteFile.getName(), 0,
                        PDF_FILE_EXTENSIONS));

        // �t�@�C�����݃`�F�b�N
        if (!pdfViewerExecuteFile.exists()) {
            QkanMessageList.getInstance().QO005_ERROR_OF_NOT_EXECUTE_FILE();
            return;
        }

        // �t�@�C�����I�����ꂽ�ꍇ
        // �I�����ꂽ�t�@�C�������A��ʂ́u�t�@�C����(pdfFileSelectFileName)�v�ɐݒ肷��B
        if (pdfViewerExecuteFile.exists()) {
            getPdfFileSelectFileName().setText(pdfViewerExecuteFile.toString());
            return;
        }
        // �t�@�C�����I������Ȃ������ꍇ
        // �������Ȃ��B
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        ACFrame.debugStart(new ACAffairInfo(QO005.class.getName()));
    }

    // �����֐�

    /**
     * �u��Ԃ̐ؑցv�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void setServerSelectIpTextState() throws Exception {
        // ����Ԃ�؂�ւ���
        // ��ʂ́u�T�[�o���(serverSelectRadios)�v�̒l���`�F�b�N����B

        if (getServerSelectRadios().getSelectedIndex() == SERVER_RADIO_LOCAL) {
            // 1(���[�J��)�̏ꍇ
            // ��ʂ́uIP(serverSelectIpText)�v�𖳌��ɂ���B
            setState_SERVER_TYPE_LOCAL();
        } else if (getServerSelectRadios().getSelectedIndex() == SERVER_RADIO_REMOTE) {
            // 2(���̃R���s���[�^)�̏ꍇ
            // ��ʂ́uIP(serverSelectIpText)�v��L���ɂ���B
            setState_SERVER_TYPE_OTHER();
        }
    }

    /**
     * �u�ݒ���捞�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void doLoad() throws Exception {
        // ���ݒ����ݒ�t�@�C������ǂݍ��݁A��ʂɓW�J����
        // �ݒ���i�[�p���R�[�h settings �𐶐�����B
        VRMap settings = new VRHashMap();
        // �ݒ�t�@�C����������擾���Asettings�Ɋi�[����B
        settings = loadSettingFile();
        // contents�̃o�C���h�\�[�X�Ƃ���settings���w�肷��B
        getContents().setSource(settings);
        // contents��settings���o�C���h����(��ʍ��ڂɒl��ݒ肷��)�B
        getContents().bindSource();
        // ����ʂ̏�Ԃ̐ݒ�
        // ��ʂ́uIP(serverSelectIpText)�v�̏�Ԃ�ݒ肷��B
        setServerSelectIpTextState();

        // �ŗ����Đݒ肷��B
        checkTax();
    }

    /**
     * �u�ݒ���t�@�C������Ǎ��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public VRMap loadSettingFile() throws Exception {
        // ���t�@�C������ݒ��Ǎ�
        // �߂�l�p���R�[�h params �𐶐�����B
        VRMap params = new VRHashMap();

        // params�� KEY : DB_FILE_SELECT_FILE_NAME ��VALUE�ɁA�ݒ�t�@�C��(XML)�� ID :
        // DBConfig/Path�̒l��ݒ肷��B
        if (ACFrame.getInstance().hasProperty("DBConfig/Path")) {
            params.setData("DB_FILE_SELECT_FILE_NAME",
                    getProperty("DBConfig/Path"));
        } else {
            params.setData("DB_FILE_SELECT_FILE_NAME", new String(
                    "DATABASE_PATH"));
        }
        // �ݒ�t�@�C���� ID : DBConfig/Server �̒l���`�F�b�N����B
        if (ACFrame.getInstance().hasProperty("DBConfig/Server")) {
            if ("localhost".equals(getProperty("DBConfig/Server"))
                    || "127.0.0.1".equals(getProperty("DBConfig/Server"))) {
                // �ulocalhost�v�̏ꍇ
                // params�� KEY : SERVER_SELECT_RADIOS ��VALUE�� 1 ��ݒ肷��B
                // params�� KEY : SERVER_SELECT_IP_TEXT ��VALUE�� ""(�u�����N) ��ݒ肷��B
                // �u127.0.0.1�v�̏ꍇ
                // params�� KEY : SERVER_SELECT_RADIOS ��VALUE�� 1 ��ݒ肷��B
                // params�� KEY : SERVER_SELECT_IP_TEXT ��VALUE�� ""(�u�����N) ��ݒ肷��B
                params.setData("SERVER_SELECT_RADIOS", new Integer(
                        SERVER_RADIO_LOCAL));
                params.setData("SERVER_SELECT_IP_TEXT", new String(""));
            } else {
                // ��L�ȊO�̏ꍇ
                // params�� KEY : SERVER_SELECT_RADIOS ��VALUE�� 2 ��ݒ肷��B
                params.setData("SERVER_SELECT_RADIOS", new Integer(
                        SERVER_RADIO_REMOTE));
                // params�� KEY : SERVER_SELECT_IP_TEXT ��VALUE�ɁA�ݒ�t�@�C���� ID :
                // DBConfig/Server �̒l��ݒ肷��B
                params.setData("SERVER_SELECT_IP_TEXT",
                        getProperty("DBConfig/Server"));
            }
        } else {
            // �f�t�H���g�l�̐ݒ���s��
            params.setData("SERVER_SELECT_RADIOS", new Integer(
                    SERVER_RADIO_LOCAL));
            params.setData("SERVER_SELECT_IP_TEXT", "");
        }

        if (ACFrame.getInstance().hasProperty("Acrobat/Path")) {
            // params�� KEY : PDF_FILE_SELECT_FILE_NAME ��VALUE�ɁA�ݒ�t�@�C���� ID :
            // Acrobat/Path �̒l��ݒ肷��B
            params.setData("PDF_FILE_SELECT_FILE_NAME",
                    getProperty("Acrobat/Path"));
        } else {
            params.setData("PDF_FILE_SELECT_FILE_NAME", "PDF_VIEWER_PATH");
        }

        if (ACFrame.getInstance().hasProperty("PrintConfig/YoshikiBango")) {
            // params�� KEY : YOSHIKI_BANGO ��VALUE�ɁA�ݒ�t�@�C���� ID :
            // PrintConfig/yoshikiBango �̒l��ݒ肷��B
            params.setData("YOSHIKI_BANGO",
                    getProperty("PrintConfig/YoshikiBango"));
        } else {
            params.setData("YOSHIKI_BANGO", new Integer(CHECKBOX_ON));
        }

        if (ACFrame.getInstance().hasProperty(
                "PrintConfig/NinchishoTokuteiShisetsu")) {
            // params�� KEY : NINCHISHO_TOKUTEI_SHISETSU ��VALUE�ɁA�ݒ�t�@�C���� ID :
            // PrintConfig/ninchishoTokuteiShisetsu �̒l��ݒ肷��B
            params.setData("NINCHISHO_TOKUTEI_SHISETSU",
                    getProperty("PrintConfig/NinchishoTokuteiShisetsu"));
        } else {
            params.setData("NINCHISHO_TOKUTEI_SHISETSU", new Integer(
                    CHECKBOX_ON));
        }

        if (ACFrame.getInstance().hasProperty("PrintConfig/ShisetsuService")) {
            // params�� KEY : SHISETSU_SERVICE ��VALUE�ɁA�ݒ�t�@�C���� ID :
            // PrintConfig/shisetsuService �̒l��ݒ肷��B
            params.setData("SHISETSU_SERVICE",
                    getProperty("PrintConfig/ShisetsuService"));
        } else {
            params.setData("SHISETSU_SERVICE", new Integer(CHECKBOX_ON));
        }

        if (ACFrame.getInstance().hasProperty("PrintConfig/HomeMedicalAdvice")) {
            // params�� KEY : PRINT_HOME_MEDICAL_ADVICE ��VALUE�ɁA�ݒ�t�@�C���� ID :
            // PrintConfig/HomeMedicalAdvice �̒l��ݒ肷��B
            params.setData("PRINT_HOME_MEDICAL_ADVICE",
                    getProperty("PrintConfig/HomeMedicalAdvice"));
        } else {
            params.setData("PRINT_HOME_MEDICAL_ADVICE", new Integer(
                    CHECKBOX_OFF));
        }

        // [H27.4�����Ή�][Shinobu Hitaka] 2015/3/10 add - begin
        // ���ʒn����Z�E���K�͎��Ə����Z
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrintSpecialArea")) {
            // params�� KEY : PRINT_SPECIAL_AREA ��VALUE�ɁA�ݒ�t�@�C���� ID :
            // PrintConfig/PrintSpecialArea �̒l��ݒ肷��B
            params.setData("PRINT_SPECIAL_AREA",
                    getProperty("PrintConfig/PrintSpecialArea"));
        } else {
            params.setData("PRINT_SPECIAL_AREA", new Integer(
                    CHECKBOX_OFF));
        }
        // ���R�Ԓn�擙�񋟉��Z
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrintChusankanArea")) {
            // params�� KEY : PRINT_CHUSANKAN_AREA ��VALUE�ɁA�ݒ�t�@�C���� ID :
            // PrintConfig/PrintChusankanArea �̒l��ݒ肷��B
            params.setData("PRINT_CHUSANKAN_AREA",
                    getProperty("PrintConfig/PrintChusankanArea"));
        } else {
            params.setData("PRINT_CHUSANKAN_AREA", new Integer(
                    CHECKBOX_OFF));
        }
        // ���E���������P���Z
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrintSyoguKaizen")) {
            // params�� KEY : PRINT_SYOGU_KAIZEN ��VALUE�ɁA�ݒ�t�@�C���� ID :
            // PrintConfig/PrintSyoguKaizen �̒l��ݒ肷��B
            params.setData("PRINT_SYOGU_KAIZEN",
                    getProperty("PrintConfig/PrintSyoguKaizen"));
        } else {
            params.setData("PRINT_SYOGU_KAIZEN", new Integer(
                    CHECKBOX_OFF));
        }
        // [H27.4�����Ή�][Shinobu Hitaka] 2015/3/10 add - end

        if (ACFrame.getInstance().hasProperty("PrintConfig/OncePerMonth")) {
            // params�� KEY : ONCE_PER_MONTH ��VALUE�ɁA�ݒ�t�@�C���� ID :
            // PrintConfig/oncePerMonth �̒l��ݒ肷��B
            params.setData("ONCE_PER_MONTH",
                    getProperty("PrintConfig/OncePerMonth"));
        } else {
            params.setData("ONCE_PER_MONTH", new Integer(CHECKBOX_ON));
        }
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrivateExpenses")) {
            // params�� KEY : PRIVATE_EXPENSES ��VALUE�ɁA�ݒ�t�@�C���� ID :
            // PrintConfig/privateExpenses �̒l��ݒ肷��B
            params.setData("PRIVATE_EXPENSES",
                    getProperty("PrintConfig/PrivateExpenses"));
        } else {
            params.setData("PRIVATE_EXPENSES", new Integer(CHECKBOX_OFF));
        }

        // 2009/02/25 [ID:0000440][Tozo TANAKA] add begin - ����21�N4���@�����Ή�
        // ������21�N4���@�����Ή���
        // params�� KEY : SHOW_OLD_LOW_PROVIDER_ELEMENTS��VALUE�ɁA�ݒ�t�@�C����
        // ID : ScreenConfig/ShowOldLowProviderElements �̒l��ݒ肷��B
        if (ACFrame.getInstance().hasProperty(
                "ScreenConfig/ShowOldLowProviderElements")) {
            // params�� KEY : SHOW_OLD_IRYO ��VALUE�ɁA�ݒ�t�@�C���� ID :
            params.setData("SHOW_OLD_LOW_PROVIDER_ELEMENTS",
                    getProperty("ScreenConfig/ShowOldLowProviderElements"));
        } else {
            params.setData("SHOW_OLD_LOW_PROVIDER_ELEMENTS", new Integer(
                    CHECKBOX_OFF));
        }
        // 2009/02/25 [ID:0000440][Tozo TANAKA] add end - ����21�N4���@�����Ή�

        // [ID:0000449][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
        if (ACFrame.getInstance().hasProperty("PrintConfig/printNursingZero")) {
            // params�� KEY : PRINT_NURSING_ZERO ��VALUE�ɁA�ݒ�t�@�C���� ID :
            // PrintConfig/printNursingZero �̒l��ݒ肷��B
            params.setData("PRINT_NURSING_ZERO",
                    getProperty("PrintConfig/printNursingZero"));
        } else {
            params.setData("PRINT_NURSING_ZERO", new Integer(CHECKBOX_OFF));
        }
        // [ID:0000449][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�

        // [ID:0000651][Shin Fujihara] 2011/07/06 add begin ���S���x�z0�~�\���Ή�
        if (ACFrame.getInstance().hasProperty(
                "PrintConfig/printNursingLimitZero")) {
            // params�� KEY : PRINT_NURSING_LIMIT_ZERO��VALUE�ɁA�ݒ�t�@�C����
            // ID : PrintConfig/printNursingLimitZero �̒l��ݒ肷��B
            params.setData("PRINT_NURSING_LIMIT_ZERO",
                    getProperty("PrintConfig/printNursingLimitZero"));
        } else {
            params.setData("PRINT_NURSING_LIMIT_ZERO",
                    new Integer(CHECKBOX_OFF));
        }
        // [ID:0000651][Shin Fujihara] 2011/07/06 add end ���S���x�z0�~�\���Ή�

        // [H28.4 �v�]][Shnobu Hitaka] 2016/02/26 add - begin �����A�g�Ή�
        if (ACFrame.getInstance().hasProperty("ReceiptAccess/KaigoHoken")) {
            // params�� KEY : KAIGO_HOKEN��VALUE�ɁA�ݒ�t�@�C����
            // ID : ReceiptAccess/KaigoHoken �̒l��ݒ肷��B
            params.setData("KAIGO_HOKEN",
                    getProperty("ReceiptAccess/KaigoHoken"));
        } else {
            params.setData("KAIGO_HOKEN", new Integer(CHECKBOX_OFF));
        }
        // [H28.4 �v�]][Shnobu Hitaka] 2016/02/26 add - end
        
        // �֐��̕ϐ��Ƃ��āAparams��Ԃ��B
        return params;
    }

    /**
     * �u�ݒ���ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public boolean doSave() throws Exception {
        // ����ʂ̐ݒ�����A�ݒ�t�@�C���ɕۑ�����B
        // �ݒ���i�[�p���R�[�h settings �𐶐�����B
        VRMap settings = new VRHashMap();
        // contents�̃o�C���h�\�[�X�Ƃ���settings���w�肷��B
        getContents().setSource(settings);
        // ��ʂ̏���settings�Ɋi�[����B
        getContents().applySource();
        // �ݒ�t�@�C���ɏ����������ށB
        if (saveSettingFile(settings)) {
            // �ŗ����Đݒ肷��B
            checkTax();
            return true;
        }
        return false;
    }

    /**
     * �u�ݒ���t�@�C���ɕۑ��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public boolean saveSettingFile(VRMap params) throws Exception {

        // �l�̎��O�`�F�b�N���s��
        if (checkValue(params)) {
            // ���ݒ���t�@�C���ɕۑ�
            // �ݒ�t�@�C��(XML)�� ID : DBConfig/Path �̒l�ɁAparams�� KEY :
            // DB_FILE_SELECT_FILE_NAME �� VALUE ��ݒ肷��B
            setProperty("DBConfig/Path",
                    String.valueOf(params.getData("DB_FILE_SELECT_FILE_NAME")));

            // params�� KEY : DB_FILE_SELECT_FILE_NAME �� VALUE ���`�F�b�N����B
            if (params.getData("SERVER_SELECT_RADIOS").equals(
                    new Integer(SERVER_RADIO_LOCAL))) {
                // 1�̏ꍇ
                // �ݒ�t�@�C���� ID : DBConfig/Server �̒l�ɁA�ulocalhost�v��ݒ肷��B
                setProperty("DBConfig/Server", "127.0.0.1");
            } else if (params.getData("SERVER_SELECT_RADIOS").equals(
                    new Integer(SERVER_RADIO_REMOTE))) {
                // 2�̏ꍇ
                // �ݒ�t�@�C���� ID : DBConfig/Server �̒l�ɁAparams�� KEY :
                // SERVER_SELECT_IP_TEXT �� VALUE ��ݒ肷��B
                setProperty("DBConfig/Server",
                        String.valueOf(params.getData("SERVER_SELECT_IP_TEXT")));
            }

            // �ݒ�t�@�C������A�������͕ҏW����Ă������̎����l�������Őݒ肵�Ă���
            setProperty("DBConfig/Port", "3050");

            // �ݒ�t�@�C���� ID : Acrobat/Path �̒l�ɁAparams�� KEY :
            // PDF_FILE_SELECT_FILE_NAME
            // ��VALUE��ݒ肷��B
            setProperty("Acrobat/Path",
                    (String) params.getData("PDF_FILE_SELECT_FILE_NAME"));
            // �ݒ�t�@�C���� ID : PrintConfig/yoshikiBango �̒l�ɁAparams�� KEY :
            // YOSHIKI_BANGO
            // ��VALUE��ݒ肷��B
            setProperty("PrintConfig/YoshikiBango",
                    String.valueOf(params.getData("YOSHIKI_BANGO")));
            // �ݒ�t�@�C���� ID : PrintConfig/ninchishoTokuteiShisetsu �̒l�ɁAparams�� KEY
            // :
            // NINCHISHO_TOKUTEI_SHISETSU ��VALUE��ݒ肷��B
            setProperty(
                    "PrintConfig/NinchishoTokuteiShisetsu",
                    String.valueOf(params.getData("NINCHISHO_TOKUTEI_SHISETSU")));
            // �ݒ�t�@�C���� ID : PrintConfig/shisetsuService �̒l�ɁAparams�� KEY :
            // SHISETSU_SERVICE ��VALUE��ݒ肷��B
            setProperty("PrintConfig/ShisetsuService",
                    String.valueOf(params.getData("SHISETSU_SERVICE")));
            // �ݒ�t�@�C���� ID : PrintConfig/HomeMedicalAdvice �̒l�ɁAparams�� KEY :
            // PRINT_HOME_MEDICAL_ADVICE ��VALUE��ݒ肷��B
            setProperty("PrintConfig/HomeMedicalAdvice",
                    String.valueOf(params.getData("PRINT_HOME_MEDICAL_ADVICE")));
            
            // [H27.4�����Ή�][Shinobu Hitaka] 2015/3/10 add - begin
            // �ݒ�t�@�C���� ID : PrintConfig/PrintSpecialArea �̒l�ɁAparams�� KEY :
            // PRINT_SPECIAL_AREA ��VALUE��ݒ肷��B
            setProperty("PrintConfig/PrintSpecialArea",
                    String.valueOf(params.getData("PRINT_SPECIAL_AREA")));
            // �ݒ�t�@�C���� ID : PrintConfig/PrintChusankanArea �̒l�ɁAparams�� KEY :
            // PRINT_CHUSANKAN_AREA ��VALUE��ݒ肷��B
            setProperty("PrintConfig/PrintChusankanArea",
                    String.valueOf(params.getData("PRINT_CHUSANKAN_AREA")));
            // �ݒ�t�@�C���� ID : PrintConfig/PrintSyoguKaizen �̒l�ɁAparams�� KEY :
            // PRINT_SYOGU_KAIZEN ��VALUE��ݒ肷��B
            setProperty("PrintConfig/PrintSyoguKaizen",
                    String.valueOf(params.getData("PRINT_SYOGU_KAIZEN")));
            // [H27.4�����Ή�][Shinobu Hitaka] 2015/3/10 add - end
            
            // �ݒ�t�@�C���� ID : PrintConfig/oncePerMonth �̒l�ɁAparams�� KEY :
            // ONCE_PER_MONTH ��VALUE��ݒ肷��B
            setProperty("PrintConfig/OncePerMonth",
                    String.valueOf(params.getData("ONCE_PER_MONTH")));
            // �ݒ�t�@�C���� ID : PrintConfig/privateExpenses �̒l�ɁAparams�� KEY :
            // PRIVATE_EXPENSES ��VALUE��ݒ肷��B
            setProperty("PrintConfig/PrivateExpenses",
                    String.valueOf(params.getData("PRIVATE_EXPENSES")));

            // 2009/02/25 [ID:0000440][Tozo TANAKA] add begin - ����21�N4���@�����Ή�
            // ������21�N4���@�����Ή���
            // �ݒ�t�@�C���� ID : ScreenConfig/ShowOldLowProviderElements �̒l�ɁAparams��
            // KEY : SHOW_OLD_LOW_PROVIDER_ELEMENTS ��VALUE��ݒ肷��B
            setProperty("ScreenConfig/ShowOldLowProviderElements",
                    String.valueOf(params
                            .getData("SHOW_OLD_LOW_PROVIDER_ELEMENTS")));
            // 2009/02/25 [ID:0000440][Tozo TANAKA] add end - ����21�N4���@�����Ή�

            // [ID:0000449][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
            // �ݒ�t�@�C���� ID : ScreenConfig/ShowOldLowProviderElements �̒l�ɁAparams��
            // KEY : SHOW_OLD_LOW_PROVIDER_ELEMENTS ��VALUE��ݒ肷��B
            setProperty("PrintConfig/printNursingZero",
                    String.valueOf(params.getData("PRINT_NURSING_ZERO")));
            // [ID:0000449][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�

            // [ID:0000651][Shin Fujihara] 2011/07/06 add begin ���S���x�z0�~�\���Ή�
            // �ݒ�t�@�C���� ID : PrintConfig/printNursingLimitZero �̒l�ɁAparams��
            // KEY : PRINT_NURSING_LIMIT_ZERO ��VALUE��ݒ肷��B
            setProperty("PrintConfig/printNursingLimitZero",
                    String.valueOf(params.getData("PRINT_NURSING_LIMIT_ZERO")));
            // [ID:0000651][Shin Fujihara] 2011/07/06 add end ���S���x�z0�~�\���Ή�

            // [H28.4 �v�]][Shnobu Hitaka] 2016/02/26 add - begin �����A�g�Ή�
            // �ݒ�t�@�C���� ID : ReceiptAccess/KaigoHoken �̒l�ɁAparams�� KEY :
            // KAIGO_HOKEN ��VALUE��ݒ肷��B
            setProperty("ReceiptAccess/KaigoHoken",
                    String.valueOf(params.getData("KAIGO_HOKEN")));
            // [H28.4 �v�]][Shnobu Hitaka] 2016/02/26 add - end
            
            saveProperty();

            return true;
        }
        return false;
    }

    /**
     * �u��ʏ����l�̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void setInitValue() throws Exception {
        // ���E�B���h�E�^�C�g���̐ݒ�
        // �Ɩ���񃌃R�[�h���擾����B
        // �E�B���h�E�^�C�g���ɁA�擾���R�[�h��KEY : WINDOW_TITLE��VALUE��ݒ肷��B
        // �Ɩ��{�^���o�[�̃e�L�X�g�ɁA�擾���R�[�h��KEY : AFFAIR_TITLE��VALUE��ݒ肷��B
        setAffairTitle("QO005", getButtons());
    }

    /**
     * �t�@�C���̃R�s�[���s���܂��B
     * 
     * @param orgFile
     *            �R�s�[���t�@�C���p�X
     * @param newFile
     *            �R�s�[��t�@�C���p�X
     * @throws Exception
     */
    public void fileCpy(String orgFile, String newFile) throws Exception {
        BufferedInputStream input = new BufferedInputStream(
                new FileInputStream(orgFile));
        BufferedOutputStream output = new BufferedOutputStream(
                new FileOutputStream(newFile));
        byte buf[] = new byte[256];
        int len;
        while ((len = input.read(buf)) != -1) {
            output.write(buf, 0, len);
        }
        output.flush();
        output.close();
        input.close();
    }

    /**
     * Firebird�̊g���q�t���t�@�C���t�@�C�������擾���܂��B
     * 
     * @param fileName
     *            �t�@�C����
     * @param defaultExtension
     *            �g���q���t���Ă��Ȃ��ꍇ�A�g���q���̉��Ԗڂ̊g���q��t�^���邩
     * @param extensions
     *            �g���q���
     * @return �g���q�t���t�@�C����
     */
    public String getFBFilePathWithExtension(String fileName,
            int defaultExtensionIndex, String[] extensions) {
        if (fileName == null) {
            return "";
        }

        int pos = fileName.lastIndexOf('.'); // �Ō�̃s���I�h�ʒu���擾
        if (pos == -1) {
            // �g���q��ǉ����ĕԂ�
            return fileName + "." + extensions[defaultExtensionIndex];
        }

        if ((pos > 0) && (pos < (fileName.length() - 1))) {
            String ext = fileName.substring(pos + 1).toLowerCase(); // �Ō�̃s���I�h����̕�������������ŕԂ�
            for (int i = 0; i < FB_FILE_EXTENSIONS.length; i++) {
                if (ext.equals(FB_FILE_EXTENSIONS[i])) {
                    return fileName;
                }
            }
            return fileName + "." + extensions[defaultExtensionIndex];
        } else {
            return "";
        }
    }

    /**
     * Acrobat�̊g���q�t���t�@�C���t�@�C�������擾���܂��B
     * 
     * @param fileName
     *            �t�@�C����
     * @param defaultExtension
     *            �g���q���t���Ă��Ȃ��ꍇ�A�g���q���̉��Ԗڂ̊g���q��t�^���邩
     * @param extensions
     *            �g���q���
     * @return �g���q�t���t�@�C����
     */
    public String getPDFFilePathWithExtension(String fileName,
            int defaultExtensionIndex, String[] extensions) {
        if (fileName == null) {
            return "";
        }

        int pos = fileName.lastIndexOf('.'); // �Ō�̃s���I�h�ʒu���擾
        if (pos == -1) {
            // �g���q��ǉ����ĕԂ�
            return fileName + "." + extensions[defaultExtensionIndex];
        }

        if ((pos > 0) && (pos < (fileName.length() - 1))) {
            String ext = fileName.substring(pos + 1).toLowerCase(); // �Ō�̃s���I�h����̕�������������ŕԂ�
            for (int i = 0; i < PDF_FILE_EXTENSIONS.length; i++) {
                if (ext.equals(PDF_FILE_EXTENSIONS[i])) {
                    return fileName;
                }
            }
            return fileName + "." + extensions[defaultExtensionIndex];
        } else {
            return "";
        }
    }

    /**
     * �v���p�e�B�t�@�C���Ɋi�[����f�[�^�̎��O�`�F�b�N���s���܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public boolean checkValue(VRMap params) throws Exception {
        // DB��IP�A�h���X�����̓`�F�b�N
        if (params.getData("SERVER_SELECT_RADIOS").equals(
                new Integer(SERVER_RADIO_REMOTE))) {
            // �T�[�o�̃��W�I�������[�g�������ꍇ�ŁAIP�A�h���X�����͂���Ă��邩�`�F�b�N
            if (ACTextUtilities.isNullText(params
                    .getData("SERVER_SELECT_IP_TEXT"))) {
                QkanMessageList.getInstance().QO005_ERROR_OF_EMPTY_IP_OR_HOST();
                getServerSelectIpText().requestFocus();
                return false;
            }
        }

        // �t�@�C����������
        if (ACTextUtilities.isNullText(params
                .getData("DB_FILE_SELECT_FILE_NAME"))) {
            QkanMessageList.getInstance().QO005_ERROR_OF_EMPTY_DBFILE_PATH();
            getDbFileSelectFileName().requestFocus();
            return false;
        }

        // PDF�t�@�C����������
        if (getPdfFileSelects().isVisible()
                && ACTextUtilities.isNullText(params
                        .getData("PDF_FILE_SELECT_FILE_NAME"))) {
            QkanMessageList.getInstance()
                    .QO005_ERROR_OF_EMPTY_PDF_VIEWER_PATH();
            getPdfFileSelectFileName().requestFocus();
            return false;
        }

        // �������R�[�h
        if (!VRCharType.ONLY_HALF_CHAR.isMatch(String.valueOf(params
                .getData("DB_FILE_SELECT_FILE_NAME")))) {
            final String osName = String.valueOf(System.getProperty("os.name"))
                    .toLowerCase();
            if ((osName.indexOf("mac") < 0)
                    || (getServerSelectRadioItem1().isSelected())) {
                // Mac�ł͂Ȃ������[�J���R���s���[�^�[���w�肵���ꍇ�͋������`�F�b�N��������

                getDbFileSelectFileName().requestFocus();
                QkanMessageList.getInstance()
                        .QO005_ERROR_OF_DBPATH_INCLUDE_JAPANESE_CHAR();
                return false;
            }
        }
        
        switch(checkDBConnect(params)) {
        case DB_CONNECT_ERROR:
            // �ڑ��`�F�b�N�Őڑ��ł��Ȃ������ꍇ
            getDbFileSelectFileName().requestFocus();
            QkanMessageList.getInstance().QO005_ERROR_OF_NOT_CONNECT_FIREBIRD();
            return false;
        case DB_SCHEMA_ERROR:
            //�X�L�[�}�o�[�W�������Â��ꍇ
            getDbFileSelectFileName().requestFocus();
            QkanMessageList.getInstance().QO005_ERROR_OF_SCHEMA_VERSION();
            return false;
        }
        return true;
    }

    /**
     * DB�̐ڑ��������s���܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public int checkDBConnect(VRMap params) throws Exception {
        // �T�[�o�̃A�h���X�̊i�[
        BridgeFirebirdDBManager dbm = new BridgeFirebirdDBManager();
        try {
            String server;
            if (params.getData("SERVER_SELECT_RADIOS").equals(
                    new Integer(SERVER_RADIO_LOCAL))) {
                server = "127.0.0.1";
            } else {
                server = String
                        .valueOf(params.getData("SERVER_SELECT_IP_TEXT"));
            }

            int port = ACCastUtilities.toInt(getProperty("DBConfig/Port"));
            String userName = getProperty("DBConfig/UserName");
            String passWord = getProperty("DBConfig/Password");
            String path = String.valueOf(params
                    .getData("DB_FILE_SELECT_FILE_NAME"));
            int loginTimeout = ACCastUtilities
                    .toInt(getProperty("DBConfig/LoginTimeOut"));
            int maxPoolSize = ACCastUtilities
                    .toInt(getProperty("DBConfig/MaxPoolSize"));
            String charSet = getProperty("DBConfig/CharSet");
            String encoding = getProperty("DBConfig/Encoding");

            dbm.releaseAll();
            dbm = new BridgeFirebirdDBManager(server, port, userName, passWord,
                    path, loginTimeout, maxPoolSize, charSet, encoding);

            if (dbm.isAvailableDBConnection()) {

                VRList list = dbm
                        .executeQuery("SELECT M_QKAN_VERSION.SCHEME_VERSION FROM M_QKAN_VERSION");
                if ((list == null) || (list.isEmpty())) {
                    // DB��Ver�擾�ł����B
                    dbm.releaseAll();
                    return DB_CONNECT_ERROR;
                } else {
                    String version = ACCastUtilities.toString(((VRMap)list.getData(0)).get("SCHEME_VERSION"), "");
                    if (!QkanCommon.isValidSchemaVersion(version)) {
                        // 2015/4/17 [Yoichiro Kamei] add - begin ���o�[�W������DB�ɐڑ������܂܂ƂȂ��Ă����ׁA�ڑ������
                        dbm.releaseAll();
                        // 2015/4/17 [Yoichiro Kamei] add - end
                        return DB_SCHEMA_ERROR;
                    }
                }
                dbm.releaseAll();
                return DB_OK;
            } else {
                dbm.releaseAll();
                return DB_CONNECT_ERROR;
            }
        } catch (Exception ex) {
            dbm.releaseAll();
            return DB_CONNECT_ERROR;
        }
    }

    /**
     * �f�t�H���g�̃t�@�C�������擾���܂��B
     * 
     * @param fileExtension
     *            �g���q
     * @return �t�@�C����
     */
    public String getDefaultFileName(String fileExtension) throws Exception {
        String today = "";
        Calendar cal = Calendar.getInstance();
        VRDateFormat vrdf = new VRDateFormat("yyMMdd");
        today = vrdf.format(cal.getTime());
        return "qk" + today + "." + fileExtension;
    }

    /**
     * �u����ŗ��ݒ�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void taxChangeActionPerformed(ActionEvent e) throws Exception {
        // ������ŗ��̐ݒ�
        if (ACTextUtilities.isNullText(getTax())) {
            // ����ŗ�(tax)���󗓂̏ꍇ
            // �f�[�^�x�[�X�̐ݒ肪�������Ă��Ȃ��|�̃��b�Z�[�W��\������B�����b�Z�[�WID = QO005_ERROR_OF_DB_FAILED
            QkanMessageList.getInstance().QO005_ERROR_OF_DB_FAILED();
            // �����𒆒f����B
            return;
        }
        // ����ŗ��ҏW��ʂ𐶐����A���݂̏���ŗ�(tax)�̒l�������ɕ\������B
        double oldVal = ACCastUtilities.toDouble(getTax().getText(), 0);
        double newVal = new QO005001().showModal(oldVal);
        if (oldVal != newVal) {
            // �\�����ʂƂ��ĕԋp���ꂽ����ŗ����A���݂̏���ŗ�(tax)�̒l�ƈقȂ�ꍇ
            // �ԋp���ꂽ����ŗ��Ń}�X�^���X�V����B
            QkanCommon.setTax(getDBManager(), newVal);
            // ����ŗ�(tax)�ɕԋp���ꂽ����ŗ���ݒ肷��B
            getTax().setText(ACCastUtilities.toString(newVal));
        }
    }

    /**
     * �u����ŗ��̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     * 
     */
    public void checkTax() throws Exception {
        // ����ŗ����擾�\����������B
        double val = QkanCommon.getTax(getDBManager());
        if (val >= 0) {
            // ����ŗ����擾�ł����ꍇ�͏���ŗ�(tax)�ɂ��̒l��ݒ肷��B
            getTax().setText(ACCastUtilities.toString(val));
        } else {
            // ����ŗ����擾�ł��Ȃ������ꍇ�͏���ŗ�(tax)���󗓂Ƃ���B
            getTax().setText("");
        }
    }

}
