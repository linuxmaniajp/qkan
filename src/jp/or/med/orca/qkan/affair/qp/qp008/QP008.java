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
 * �J����: �����@�L
 * �쐬��: 2006/02/16  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X CSV�o�� (008)
 * �v���O���� �t�H���_�I�� (QP008)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp008;

import java.awt.event.*;
import java.io.*;

import org.omg.CORBA.Environment;

import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.lib.care.claim.calculation.QP001;
import jp.nichicom.ac.text.*;
import jp.nichicom.vr.util.*;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qp.qp009.QP009;

/**
 * �t�H���_�I��(QP008)
 */
public class QP008 extends QP008Event {
    
    private QP001 owner = null; 
    
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP008() {
    }
    
    public QP008(QP001 owner){
        this.owner = owner;
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
        setAffairTitle("QP008");

        VRMap settings = new VRHashMap();
        settings.put("MEDIUM_DIVISION", new Integer(1));
        // �ݒ�t�@�C����ǂݍ��݁A��ʂ̏�����Ԃ�ݒ肷��B
        if (ACFrame.getInstance().hasProperty("Claim/Button")) {
            // �ݒ�t�@�C����Claim-Button�̒l���擾����B
            String buttonState = getProperty("Claim/Button");
            // Claim-Button��0�̏ꍇ
            if ("".equals(buttonState) || "0".equals(buttonState)) {
                // �u�ۑ��挈��(�)�{�^��(saveStandardButton)�v��������Ԃɂ���B
                getSaveStandardButton().setSelected(true);

                // Claim-Button��0�̏ꍇ
            } else if ("1".equals(buttonState)) {
                // �u�ۑ��挈��(�C��)�{�^��(saveOptionButton)�v��������Ԃɂ���B
                getSaveOptionButton().setSelected(true);
            }
        } else {
            getSaveOptionButton().setSelected(true);
        }

        // �ݒ�t�@�C����Claim-Folder�̒l���擾���A�t�@�C���p�X�e�L�X�g(filePath)�ɐݒ肷��B
        if (ACFrame.getInstance().hasProperty("Claim/Folder")) {
            settings.put("FILE_PATH", getProperty("Claim/Folder"));
        }else{
            settings.put("FILE_PATH", new File( "." ).getAbsoluteFile().getParentFile());
        }

        // �Y���������ꍇ
        // �u�`��(mediumDivisionRadioItem3)�v��I����Ԃɂ���B
        settings.put("MEDIUM_DIVISION", new Integer(3));
        if (ACFrame.getInstance().hasProperty("Claim/Drive")) {
            // �ݒ�t�@�C����Claim-Drive�̒l���擾����B
            String drive = getProperty("Claim/Drive");
            // Claim-Drive��FD�̏ꍇ
            if ("FD".equals(drive)) {
                // �uFD(mediumDivisionRadioItem1)�v��I����Ԃɂ���B
                settings.put("MEDIUM_DIVISION", new Integer(1));
                // Claim-Drive��MO�̏ꍇ
            } else if ("MO".equals(drive)) {
                // �uMO(mediumDivisionRadioItem2)�v��I����Ԃɂ���B
                settings.put("MEDIUM_DIVISION", new Integer(2));
                // Claim-Drive��E�̏ꍇ
            } else if ("E".equals(drive)) {
                // �u�`��(mediumDivisionRadioItem3)�v��I����Ԃɂ���Bs
                settings.put("MEDIUM_DIVISION", new Integer(3));
            }
        }

        // ��ʂ̐ݒ���s���B
        setState_INIT();
        getContents().setSource(settings);
        getContents().bindSource();
        
        pack();
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �uOK�������̏����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void okActionPerformed(ActionEvent e) throws Exception {
        VRMap settings = new VRHashMap();
        // contents�̃o�C���h�\�[�X�Ƃ���settings���w�肷��B
        getContents().setSource(settings);
        // ��ʂ̏���settings�Ɋi�[����B
        getContents().applySource();
        
        // CSV�o�͂��������Ă��Ȃ��ꍇ�B(outPut �� false�̏ꍇ)
        if(!getOutPut()){
            File outPath = new File(ACCastUtilities.toString(settings.get("FILE_PATH")));
            if(!outPath.isDirectory()){
                QkanMessageList.getInstance().QP008_ERROR_OF_INVALID_FOLDER();
                return;
            }
            
            
            //�u�`���v���I������Ă���ꍇ
            if(ACCastUtilities.toInt(settings.get("MEDIUM_DIVISION")) == 3){
                boolean show = true;
                //�ݒ�t�@�C����Claim-Info�̒l���擾����B
                if(ACFrame.getInstance().hasProperty("Claim/Info")){
                    String check = getProperty("Claim/Info");
                    if("1".equals(check)){
                        show = false;
                    }
                }
                if(show){
                    //�m�F���b�Z�[�W�_�C�A���O��\������B(QP009)
                    QP009 qp009 = new QP009();
                    qp009.showModal();
                }
            }
            //�I������Ă���t�H���_��CSV�t�@�C�����쐬����B(QP001�̃��\�b�h���Ăяo��)
            String outFilePath = owner.makeCSV(settings);

            // �h���C�u�̏������ł��Ă��Ȃ��ꍇ
            if(false){
                // ��ʏ�Ԃ�ύX����B
                setState_ERROR();
            } else {
                // ����Ƀt�@�C�����쐬���ꂽ�ꍇ
                // ��ʏ�Ԃ�ύX����B
                // ��ʂɁu�o�͂͐���ɏI�����܂����B�t�@�C�����F�i�o�͂����t�@�C���p�X�j�v��\������B
                
                getComment().setText("�@�@�o�͂͐���ɏI�����܂����B\n�@�@�t�@�C�����F" + outFilePath);
                setState_INFO();
                //outPut �� true��ݒ肷��B
                setOutPut(true);
                //�u�f�t�H���g�Ƃ��ĕۑ�(fileFormCheckBox)�v�Ƀ`�F�b�N���t���Ă���ꍇ
                if(getFileFormCheckBox().isSelected()){
                    // ���ݑI������Ă���l��ݒ�t�@�C���ɕۑ�����B
                    // �u�ۑ��挈��(�)�{�^��(saveStandardButton)�v��������Ԃ̏ꍇ
                    if(getSaveStandardButton().isSelected()){
                       //Claim-Button��0��ݒ肷��B
                        setProperty("Claim/Button","0");
                    }
                    //�u�ۑ��挈��(�C��)�{�^��(saveOptionButton)�v��������Ԃ̏ꍇ
                    if(getSaveOptionButton().isSelected()){
                        //Claim-Button��1��ݒ肷��B
                        setProperty("Claim/Button","1");
                    }
                    if(!ACTextUtilities.isNullText(settings.get("FILE_PATH"))){
                       //�t�@�C���p�X�e�L�X�g(filePath)�ɐݒ肳��Ă���l���AClaim-Folder�ɐݒ肷��B
                        setProperty("Claim/Folder", String.valueOf(settings.get("FILE_PATH")));
                    }
                    if(!ACTextUtilities.isNullText(settings.get("MEDIUM_DIVISION"))){
                        int select = ACCastUtilities.toInt(settings.get("MEDIUM_DIVISION"));
                        
                        switch(select){
                            //�uFD(mediumDivisionRadioItem1)�v���I����Ԃ̏ꍇ
                            case 1:
                                //Claim-Drive��FD��ݒ肷��B
                                setProperty("Claim/Drive","FD");
                                break;
                            //�uMO(mediumDivisionRadioItem2)�v���I����Ԃ̏ꍇ
                            case 2:
                                //Claim-Drive��MO��ݒ肷��B
                                setProperty("Claim/Drive","MO");
                                break;
                            //�u�`��(mediumDivisionRadioItem3)�v���I����Ԃ̏ꍇ
                            case 3:
                                //Claim-Drive��E��ݒ肷��B
                                setProperty("Claim/Drive","E");
                                break;
                        }
                        
                        
                    }
                }                
                
            }
            
            pack();
            
        } else {
            // CSV�o�͂��������Ă���ꍇ�B(outPut �� true�̏ꍇ)

            // ���_�C�A���O�Ăяo������CSV�o�͐�����ʒm���A�_�C�A���O�����B
            dispose();
        }

    }

    /**
     * �u�߂鉟�����̏����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void goBackActionPerformed(ActionEvent e) throws Exception {
        // ��ʏ�Ԃ�ύX����B
        setState_INIT();

    }

    /**
     * �u�L�����Z���������̏����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void cancelActionPerformed(ActionEvent e) throws Exception {
        // ���_�C�A���O�Ăяo�����ɒl�͕Ԃ����A�_�C�A���O�����B
        dispose();
    }

    /**
     * �uA:�{�^���������̏����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void saveStandardButtonActionPerformed(ActionEvent e)
            throws Exception {
        
        VRMap settings = new VRHashMap();
        // contents�̃o�C���h�\�[�X�Ƃ���settings���w�肷��B
        getContents().setSource(settings);
        // ��ʂ̏���settings�Ɋi�[����B
        getContents().applySource();
        
        // �uFD(mediumDivisionRadioItem1)�v��I����Ԃɂ���B
        settings.put("MEDIUM_DIVISION",new Integer(1));
        
        // �t�@�C���p�X�e�L�X�g(filePath)�ɁuA:�v��\������B
        settings.put("FILE_PATH","A:");
        
        //�u�ۑ��挈��(�)�{�^��(saveStandardButton)�v��������Ԃɂ���B
        getSaveStandardButton().setSelected(true);
        getSaveOptionButton().setSelected(false);
        
        getContents().bindSource();
        
    }

    /**
     * �u�C�ӂ̃t�H���_:�������̏����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void saveOptionButtonActionPerformed(ActionEvent e)
            throws Exception {
        
        VRMap settings = new VRHashMap();
        // contents�̃o�C���h�\�[�X�Ƃ���settings���w�肷��B
        getContents().setSource(settings);
        // ��ʂ̏���settings�Ɋi�[����B
        getContents().applySource();
        
        
        // �ݒ�t�@�C����Claim-Folder�̒l���擾����B
        String path = "";
        if (ACFrame.getInstance().hasProperty("Claim/Folder")) {
            path = getProperty("Claim/Folder");
        }
        
        //�擾�����l�������l�Ƃ��t�H���_�I����ʂ�\������B
        ACFileChooser fileChooser = new ACFileChooser();
        File selectFile = fileChooser.showDirectorySelectDaialog("�b�r�u�o�̓t�H���_�I��", path);
        
        //�t�H���_�I����ʂłn�j���I�����ꂽ�ꍇ
        if(selectFile != null){
            
            //�u�`��(mediumDivisionRadioItem3)�v��I����Ԃɂ���B
            settings.put("MEDIUM_DIVISION",new Integer(3));
            
            //�I�����ꂽ�p�X���t�@�C���p�X�e�L�X�g(filePath)�ɕ\������B
            settings.put("FILE_PATH",selectFile.getPath());
            
            //�u�ۑ��挈��(�C��)�{�^��(saveOptionButton)�v��������Ԃɂ���B
            getSaveOptionButton().setSelected(true);
            getSaveStandardButton().setSelected(false);
            getContents().bindSource();
        }
        
    }

}
