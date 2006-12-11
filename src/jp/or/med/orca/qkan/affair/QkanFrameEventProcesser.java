package jp.or.med.orca.qkan.affair;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACDBManagerCreatable;
import jp.nichicom.ac.core.ACDefaultFrameEventProcesser;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.io.ACPropertyXML;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACLoggerDBManager;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.bridge.sql.BridgeFirebirdDBManager;
import jp.or.med.orca.qkan.QkanSystemInformation;

/** TODO <HEAD_IKENSYO> */
public class QkanFrameEventProcesser extends ACDefaultFrameEventProcesser
        implements ACDBManagerCreatable {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QkanFrameEventProcesser() {
    }
    private String propertyXMLPath ="properity.xml"; 
    protected String getPropertyXMLPath() {
        return propertyXMLPath;
    }
    
    /**
     * �ݒ�t�@�C���̃p�X��ݒ肵�܂��B
     * @param propertyXMLPath �ݒ�t�@�C���̃p�X
     */
    public void setPropertyXMLPath(String propertyXMLPath) {
        this.propertyXMLPath = propertyXMLPath;
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
    
    protected void appendException(StringBuffer sb, Throwable ex) {
        super.appendException(sb, ex);
        
        sb.append("Firebird:");
        try {
            BridgeFirebirdDBManager dbm= new BridgeFirebirdDBManager();
            String dbVersion = dbm.getDBMSVersion();
            if (dbVersion != null) {
                sb.append(dbVersion);
            }
        } catch (Exception ex2) {
            sb.append("unknown");
        }
        sb.append(ACConstants.LINE_SEPARATOR);
        sb.append("�V�X�e��version:");
        sb.append(QkanSystemInformation.getInstance().getSystemVersion());
        sb.append(", �f�[�^version:");
        sb.append(QkanSystemInformation.getInstance().getMasterDataVersion());
        sb.append(", �X�L�[�}version:");
        sb.append(QkanSystemInformation.getInstance().getSchemeVersion());
        sb.append(ACConstants.LINE_SEPARATOR);

    }
    
    public void showExceptionMessage(Throwable ex) {
        //2006/06/28 add-begin Tozo TANAKA Firebird�̃f�b�h���b�N�Ή��̂���
        if(ex instanceof SQLException){
            if(String.valueOf(((SQLException)ex).getMessage()).indexOf(" deadlock")>=0){
                try{
                    QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                    return;
                }catch(Exception ex2){
                    ex = ex2;
                }
            }
        }
        //2006/06/28 add-end Tozo TANAKA Firebird�̃f�b�h���b�N�Ή��̂���
        
        super.showExceptionMessage(ex);
    }
    
    public ACDBManager createDBManager() throws Exception{
        // �V�X�e���ݒ�t�@�C������DB�̐ݒ���擾
        ACPropertyXML xml = ACFrame.getInstance().getPropertyXML();
        if (xml == null) {
            throw new FileNotFoundException("�V�X�e���ݒ�t�@�C�����J���܂���B");
        }
        String server = xml.getValueAt("DBConfig/Server");
        int port = Integer.parseInt(xml.getValueAt("DBConfig/Port"));
        String userName = xml.getValueAt("DBConfig/UserName");
        String pass = xml.getValueAt("DBConfig/Password");
        String path = xml.getValueAt("DBConfig/Path");
        int loginTimeout = Integer.parseInt(xml
                .getValueAt("DBConfig/LoginTimeOut"));
        int maxPoolSize = Integer.parseInt(xml
                .getValueAt("DBConfig/MaxPoolSize"));

        String charSet = xml.getValueAt("DBConfig/CharSet");
        return new ACLoggerDBManager(new BridgeFirebirdDBManager(server, port, userName, pass,
                path, loginTimeout, maxPoolSize, charSet));
    }
    
}
