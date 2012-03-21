package jp.or.med.orca.qkan.affair.qm.qm002;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

import jp.nichicom.ac.component.ACEditorPane;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACTextUtilities;

/**
 * 
 * HTML�y�[�W�Ǎ��݂��s���܂��B
 * 
 * QM001HtmlPageReader�ł��B
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2007/11/05
 * @since 5.4.1
 */
public class QM002HtmlPageReader implements Runnable {
    // �X���b�h
    Thread th;

    ACEditorPane editor;
    
    /**
     * ���m�点�̈� ��Ԃ��܂��B
     * @return editor
     */
    protected ACEditorPane getEditor() {
        return editor;
    }

    /**
     * ���m�点�̈� ��ݒ肵�܂��B
     * @param editor editor
     */
    protected void setEditor(ACEditorPane editor) {
        this.editor = editor;
    }
    
    /**
     * �y�[�W�Ǎ��ݏ����E�\������
     */
    public void run() {
        // �ŏ��͔�\��
        getEditor().setVisible(false);
        URL url;
        try {
            // OS��ނ��擾
            String osName = System.getProperty("os.name");
            // Mac�̏ꍇ�͔�K�p
            if ((osName != null) && (osName.indexOf("Mac") < 0)) {
                // �v���L�V�T�[�o���̂�ݒ肷��
                System.setProperty("http.proxyHost", PropertyUtil
                        .getProperty("http.proxyHost"));
                // �v���L�V�̃|�[�g�ԍ���ݒ肷��B
                System.setProperty("http.proxyPort", PropertyUtil
                        .getProperty("http.proxyPort"));
                // �v���L�V���g��Ȃ��T�[�o�̐ݒ�
                System.setProperty("http.nonProxyHosts", PropertyUtil
                        .getProperty("http.nonProxyHosts"));
            }
            // URL�𐶐�
            url = new URL(getVersionUpInfoURL());
            // ���Visible��؂�ւ���
            getEditor().setVisible(true);
            // �y�[�W�̕\��
            getEditor().showHtmlPage(url);
            // Enable����
            getEditor().setEnabled(true);
            // �X���b�h�̔j��
            //th = null;
            // �O�̂��ߍĕ`�揈���𑖂点��
            getEditor().repaint();
            getEditor().revalidate();
        } catch (Exception e) {
            // �ǂݍ��ݎ��s���͔�\��
            getEditor().setVisible(false);
            e.printStackTrace();
        }
        

    }

    /**
     * �V�K�̃X���b�h�𐶐����ď��������s���܂��B
     */
    public void start(ACEditorPane editor){
        // �X���b�h����
        th = new Thread(this);
        // �G�f�B�^�[��ݒ�
        setEditor(editor);
        // �X���b�h�X�^�[�g
        th.start();
    }
    
    /**
     * �A�N�Z�X����URL��Ԃ��܂��B
     * 
     * @return �A�N�Z�X����URL
     */
    protected String getVersionUpInfoURL() {
        try {
            File f = new File(ACFrame.getInstance().getExeFolderPath(),
                    "versionUpInfo.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(f)));
            if (br != null) {
                String txt = br.readLine();
                if (!ACTextUtilities.isNullText(txt)) {
                    return txt;
                }
                br.close();
            }
        } catch (Exception e) {
        }
        return "";
    }
    
    
}
