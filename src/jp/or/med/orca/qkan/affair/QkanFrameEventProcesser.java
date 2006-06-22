package jp.or.med.orca.qkan.affair;

import java.awt.Dimension;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACDefaultFrameEventProcesser;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.io.ACPropertyXML;
import jp.nichicom.ac.util.ACMessageBox;
import jp.or.med.orca.qkan.QkanSystemInformation;

/** TODO <HEAD_IKENSYO> */
public class QkanFrameEventProcesser extends ACDefaultFrameEventProcesser {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QkanFrameEventProcesser() {
    }

    protected String getPropertyXMLPath() {
        return "properity.xml";
    }
    protected String getDebuggerXMLPath() {
        return "debugger.xml";
    }
    protected String getExceptionMessage(){
        return "�����𑱍s�ł��܂���B";
    }
    protected String getPDFDirectory() {
        return ACFrame.getInstance().getExeFolderPath()
                + ACConstants.FILE_SEPARATOR + "pdf"
                + ACConstants.FILE_SEPARATOR;
    }

    public String getDefaultMessageBoxTitle() {
        return "���t�Ǘ��^����V�����x���\�t�g" + QkanSystemInformation.getInstance().getSystemVersion();
    }

    public Dimension getDefaultWindowSize() {
        return new Dimension(1024, 748);
    }

    public Dimension getMinimumWindowSize() {
        return new Dimension(800, 580);
    }
    public String[] getSplashFilePathes() {
        return new String[] {
                "jp/or/med/orca/qkan/images/splash/splash_01.png",
                "jp/or/med/orca/qkan/images/splash/splash_02.png",
                "jp/or/med/orca/qkan/images/splash/splash_03.png",
                "jp/or/med/orca/qkan/images/splash/splash_04.png",
                "jp/or/med/orca/qkan/images/splash/splash_05.png",
                "jp/or/med/orca/qkan/images/splash/splash_06.png",
                "jp/or/med/orca/qkan/images/splash/splash_07.png",
                "jp/or/med/orca/qkan/images/splash/splash_08.png",
                "jp/or/med/orca/qkan/images/splash/splash_09.png",
                "jp/or/med/orca/qkan/images/splash/splash_10.png",
                "jp/or/med/orca/qkan/images/splash/splash_11.png",
                "jp/or/med/orca/qkan/images/splash/splash_12.png",
                "jp/or/med/orca/qkan/images/splash/splash_13.png",
                "jp/or/med/orca/qkan/images/splash/splash_14.png",
                "jp/or/med/orca/qkan/images/splash/splash_15.png",
                "jp/or/med/orca/qkan/images/splash/splash_16.png",
                "jp/or/med/orca/qkan/images/splash/splash_17.png",
                "jp/or/med/orca/qkan/images/splash/splash_18.png",
                "jp/or/med/orca/qkan/images/splash/splash_19.png",
                "jp/or/med/orca/qkan/images/splash/splash_20.png", 
                "jp/or/med/orca/qkan/images/splash/splash_21.png",
                "jp/or/med/orca/qkan/images/splash/splash_22.png",
                "jp/or/med/orca/qkan/images/splash/splash_23.png",
                "jp/or/med/orca/qkan/images/splash/splash_24.png",
                "jp/or/med/orca/qkan/images/splash/splash_25.png",
                "jp/or/med/orca/qkan/images/splash/splash_26.png",
                "jp/or/med/orca/qkan/images/splash/splash_27.png",
                "jp/or/med/orca/qkan/images/splash/splash_28.png",
                "jp/or/med/orca/qkan/images/splash/splash_29.png",
                "jp/or/med/orca/qkan/images/splash/splash_30.png", 
                "jp/or/med/orca/qkan/images/splash/splash_31.png",
                "jp/or/med/orca/qkan/images/splash/splash_32.png",
                "jp/or/med/orca/qkan/images/splash/splash_33.png",
                "jp/or/med/orca/qkan/images/splash/splash_34.png",
                "jp/or/med/orca/qkan/images/splash/splash_35.png",
                "jp/or/med/orca/qkan/images/splash/splash_36.png",
                "jp/or/med/orca/qkan/images/splash/splash_37.png",
                "jp/or/med/orca/qkan/images/splash/splash_38.png",
                "jp/or/med/orca/qkan/images/splash/splash_39.png",
                "jp/or/med/orca/qkan/images/splash/splash_40.png", 
                
        };
    }

    public String getFrameIconPath() {
        return "jp/or/med/orca/qkan/images/icon/flameicon.gif";
    }
    
    protected boolean setDefaultPropertyXML(ACPropertyXML properityMap){
        return false;
    }
   
    
    protected void processErrorOnPDFDirectoryCreate() throws Exception {
        ACMessageBox.showExclamation("����Ɏ��s���܂����B" + ACConstants.LINE_SEPARATOR
                + "PDF�t�@�C���̍쐬��t�H���_�𐶐��ł��܂���B");
    }

    protected void processErrorOnPDFFileCreate() throws Exception {
        ACMessageBox.showExclamation("����Ɏ��s���܂����B" + ACConstants.LINE_SEPARATOR
                + "PDF�t�@�C�����쐬���錠��������܂���B");
    }

    protected void processErrorOnPDFViewerNotFound() throws Exception {
        ACMessageBox.showExclamation("PDF�r���[���̐ݒ���擾�ł��܂���B"+ ACConstants.LINE_SEPARATOR
                + "[���C�����j���[]-[���̑��̋@�\]-[�ݒ�ύX�E�����e�i���X]����ݒ肵�Ă��������B");
    }

}
