package jp.or.med.orca.qkan.affair;

import java.io.FileNotFoundException;

import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.core.ACAffairContainer;
import jp.nichicom.ac.core.ACDBManagerCreatable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.io.ACPropertyXML;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACLoggerDBManager;
import jp.nichicom.ac.sql.ACPassiveCheck;
import jp.nichicom.ac.sql.event.ACDefaultDBRetryListener;
import jp.nichicom.ac.util.ACSnapshot;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.bridge.sql.BridgeFirebirdDBManager;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * ���ǒ��V�X�e���̋Ɩ��p�R���e�i�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/12/01
 */
public class QkanAffairContainer extends ACAffairContainer {
    private ACPassiveCheck passiveChecker = new ACPassiveCheck();
    private ACSnapshot snapshot = new ACSnapshot();
    private ACDBManager dbm;

    /**
     * �Ɩ��Ŏg�p����DBManager���擾���܂��B
     * 
     * @return DBManager
     * @throws Exception ������O
     */
    protected ACDBManager getDBManager() throws Exception {
        if (dbm == null) {
            //2006/10/04 replace-begin Tozo TANAKA �V�X�e���v���Z�b�T��DB�����������Ϗ�
//            // �V�X�e���ݒ�t�@�C������DB�̐ݒ���擾
//            ACPropertyXML xml = ACFrame.getInstance().getPropertyXML();
//            if (xml == null) {
//                throw new FileNotFoundException("�V�X�e���ݒ�t�@�C�����J���܂���B");
//            }
//            String server = xml.getValueAt("DBConfig/Server");
//            int port = Integer.parseInt(xml.getValueAt("DBConfig/Port"));
//            String userName = xml.getValueAt("DBConfig/UserName");
//            String pass = xml.getValueAt("DBConfig/Password");
//            String path = xml.getValueAt("DBConfig/Path");
//            int loginTimeout = Integer.parseInt(xml
//                    .getValueAt("DBConfig/LoginTimeOut"));
//            int maxPoolSize = Integer.parseInt(xml
//                    .getValueAt("DBConfig/MaxPoolSize"));
//            String charSet = xml.getValueAt("DBConfig/CharSet");
//            
//            ACLoggerDBManager logDB =new ACLoggerDBManager(new BridgeFirebirdDBManager(server,
//                    port, userName, pass, path, loginTimeout, maxPoolSize,
//                    charSet));
//            //2006/06/28 add-begin Tozo TANAKA Firebird�̃f�b�h���b�N�Ή��̂���
//            logDB.addDBRetryListener(new ACDefaultDBRetryListener(3,1000,0,1000));
//            //2006/06/28 add-end Tozo TANAKA Firebird�̃f�b�h���b�N�Ή��̂���
//            dbm = logDB;
            
            dbm = ((ACDBManagerCreatable)ACFrame.getInstance().getFrameEventProcesser()).createDBManager();
            //2006/10/04 replace-end Tozo TANAKA �V�X�e���v���Z�b�T��DB�����������Ϗ�
        }
        return dbm;
    }

    /**
     * �X�i�b�v�V���b�g�}�l�[�W����Ԃ��܂��B
     * 
     * @return �X�i�b�v�V���b�g�}�l�[�W��
     */
    protected ACSnapshot getSnapshot() {
        return snapshot;
    }

    /**
     * �p�b�V�u�`�F�b�N�}�l�[�W����Ԃ��܂��B
     * 
     * @return �p�b�V�u�`�F�b�N�}�l�[�W��
     */
    protected ACPassiveCheck getPassiveChecker() {
        return passiveChecker;
    }

    /**
     * �v���p�e�B�t�@�C������l���擾���܂��B
     * 
     * @param path �L�[
     * @throws Exception ������O
     * @return �L�[�ɑΉ�����l
     */
    protected String getProperty(String path) throws Exception {
        return ACFrame.getInstance().getProperty(path);
    }

    /**
     * �v���p�e�B�t�@�C���Ɏw��L�[�̒l���܂ނ���Ԃ��܂��B
     * 
     * @param path �L�[
     * @throws Exception ������O
     * @return �w��L�[�̒l���܂ނ�
     */
    protected boolean hasProperty(String path) throws Exception {
        return ACFrame.getInstance().hasProperty(path);
    }

    /**
     * �v���p�e�B�t�@�C���ɒl���������݂܂��B
     * 
     * @param path �L�[
     * @param value �L�[�ɑΉ�����l
     * @throws Exception ������O
     */
    protected void setProperty(String path, String value) throws Exception {
        ACPropertyXML xml = ACFrame.getInstance().getPropertyXML();
        xml.setForceValueAt(path, value);
        xml.write();
    }

    /**
     * DB���猻�݂̋Ɩ�ID/���[�h�ɑΉ������E�B���h�E�^�C�g���E�Ɩ��{�^���o�[���擾���Đݒ肵�܂��B
     * 
     * @param affairID �Ɩ�ID
     * @param mode ���[�h
     * @param affairButtonBar �Ɩ��{�^���o�[
     * @return �Ɩ����
     * @throws Exception ������O
     */
    protected VRMap setAffairTitle(String affairID, String mode,
            ACAffairButtonBar affairButtonBar) throws Exception {
        // ���E�B���h�E�^�C�g���E�Ɩ��{�^���o�[�̐ݒ�
        // �Ɩ���񃌃R�[�h���擾����B
        VRMap affairInfo = QkanCommon.getAffairInfo(getDBManager(), affairID,
                mode);

        // �E�B���h�E�^�C�g���ɁA�擾���R�[�h��KEY : WINDOW_TITLE��VALUE��ݒ肷��B
        Object title=VRBindPathParser.get("WINDOW_TITLE", affairInfo);
        if(title!=null){
            setTitle(String.valueOf(title));
            if (ACFrame.getInstance().getNowAffair() != null) {
                ACFrame.getInstance().getNowAffair().setTitle(String.valueOf(title));
            }
        }else{
            VRLogger.info("�E�B���h�E�^�C�g���̎擾�Ɏ��s�F" + affairInfo);
        }

        // �Ɩ��{�^���o�[�̃e�L�X�g�ɁA�擾���R�[�h��KEY : AFFAIR_TITLE��VALUE��ݒ肷��B
        if (affairButtonBar != null) {
            Object affirTitle = VRBindPathParser.get(
                    "AFFAIR_TITLE", affairInfo);
            if(affirTitle !=null){
                affairButtonBar.setText(String.valueOf(affirTitle));
            }
        }

        return affairInfo;
    }

    /**
     * DB���猻�݂̋Ɩ�ID/���[�h�ɑΉ������E�B���h�E�^�C�g���E�Ɩ��{�^���o�[���擾���Đݒ肵�܂��B
     * 
     * @param affairID �Ɩ�ID
     * @param affairButtonBar �Ɩ��{�^���o�[
     * @return �Ɩ����
     * @throws Exception ������O
     */
    protected VRMap setAffairTitle(String affairID,
            ACAffairButtonBar affairButtonBar) throws Exception {
        return setAffairTitle(affairID, null, affairButtonBar);
    }

    /**
     * DB���猻�݂̋Ɩ�ID/���[�h�ɑΉ������E�B���h�E�^�C�g�����擾���Đݒ肵�܂��B
     * 
     * @param affairID �Ɩ�ID
     * @return �Ɩ����
     * @throws Exception ������O
     */
    protected VRMap setAffairTitle(String affairID) throws Exception {
        return setAffairTitle(affairID, null, null);
    }
    
    /**
     * �X�v���b�V����\�����܂��B
     * @param message ���b�Z�[�W
     * @return �X�v���b�V��
     * @throws Exception ������O
     */
    protected ACSplashable createSplash(String message) throws Exception {
        ACFrameEventProcesser processer = ACFrame.getInstance().getFrameEventProcesser();
        if(processer!=null){
            return processer.createSplash(message);
        }
        return null;
    }

}
