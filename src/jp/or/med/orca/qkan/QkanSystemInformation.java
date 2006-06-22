package jp.or.med.orca.qkan;

import java.util.Date;

import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �V�X�e�����ʏ��ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/10/31
 */
public class QkanSystemInformation {
    protected static QkanSystemInformation singleton;

    /**
     * ���O�C�����ƎҔԍ��ł��B
     */
    private String loginProviderID = "";

    /**
     * �R�[�h�}�X�^�ł��B
     */
    private VRMap masterCode;

//    /**
//     * �T�[�r�X��ރ}�X�^�ł��B
//     */
//    private VRMap masterService;

    /**
     * �V�X�e�����t�i���O�C�����t�A�������t�j�ł��B
     */
    private Date systemDate;

    /**
     * �V�X�e���o�[�W�����ł��B
     */
    private String systemVersion = "";
    /**
     * �}�X�^�f�[�^�o�[�W�����ł��B
     */
    private String masterDataVersion = "";
    /**
     * �X�L�[�}�o�[�W�����ł��B
     */
    private String schemeVersion = "";

    /**
     * ���C�����j���[�c���[�ł��B
     */
    private VRList menuTree;

    /**
     * ���O�C�����ƎҔԍ���Ԃ��܂��B
     * 
     * @return ���O�C�����ƎҔԍ�
     */
    public String getLoginProviderID() {
        return loginProviderID;
    }

    /**
     * ���O�C�����ƎҔԍ���ݒ肵�܂��B
     * 
     * @param loginProviderID ���O�C�����ƎҔԍ�
     */
    public void setLoginProviderID(String loginProviderID) {
        this.loginProviderID = loginProviderID;
    }

    /**
     * �R���X�g���N�^�ł��B Singleton Pattern
     */
    protected QkanSystemInformation() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanSystemInformation getInstance() {
        if (singleton == null) {
            singleton = new QkanSystemInformation();
        }
        return singleton;
    }

    /**
     * �V�X�e�����t��Ԃ��܂��B
     * 
     * @return �V�X�e�����t
     */
    public Date getSystemDate() {
        return systemDate;
    }

    /**
     * �V�X�e�����t��ݒ肵�܂��B
     * 
     * @param systemDate �V�X�e�����t
     */
    public void setSystemDate(Date systemDateO) {
        this.systemDate = systemDateO;
    }

    /**
     * �R�[�h�}�X�^��Ԃ��܂��B
     * <p>
     * �L�[�uCODE_ID�v�ƒl�u����CODE_ID�������R�[�h�̏W��(List)�v�ō\������܂��B
     * </p>
     * 
     * @return �R�[�h�}�X�^
     */
    public VRMap getMasterCode() {
        return masterCode;
    }

    /**
     * �R�[�h�}�X�^��ݒ肵�܂��B
     * <p>
     * �L�[�uCODE_ID�v�ƒl�u����CODE_ID�������R�[�h�̏W��(List)�v�ō\������܂��B
     * </p>
     * 
     * @param codeMaster �R�[�h�}�X�^
     */
    public void setMasterCode(VRMap codeMaster) {
        this.masterCode = codeMaster;
    }

    /**
     * �V�X�e���o�[�W������Ԃ��܂��B
     * 
     * @return �V�X�e���o�[�W����
     */
    public String getSystemVersion() {
        return systemVersion;
    }

    /**
     * �V�X�e���o�[�W������ݒ肵�܂��B
     * 
     * @param systemVersion �V�X�e���o�[�W����
     */
    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    /**
     * �}�X�^�f�[�^�̃o�[�W������Ԃ��܂��B
     * 
     * @return �}�X�^�f�[�^�̃o�[�W����
     */
    public String getMasterDataVersion() {
        return masterDataVersion;
    }

    /**
     * �}�X�^�f�[�^�̃o�[�W������ݒ肵�܂��B
     * 
     * @param masterDataVersion �}�X�^�f�[�^�̃o�[�W����
     */
    public void setMasterDataVersion(String masterDataVersion) {
        this.masterDataVersion = masterDataVersion;
    }

    /**
     * �X�L�[�}�̃o�[�W������Ԃ��܂��B
     * 
     * @return �X�L�[�}�̃o�[�W����
     */
    public String getSchemeVersion() {
        return schemeVersion;
    }

    /**
     * �X�L�[�}�̃o�[�W������ݒ肵�܂��B
     * 
     * @param schemeVersion �X�L�[�}�̃o�[�W����
     */
    public void setSchemeVersion(String schemeVersion) {
        this.schemeVersion = schemeVersion;
    }

//    /**
//     * �T�[�r�X��ރ}�X�^��Ԃ��܂��B
//     * 
//     * @return �T�[�r�X��ރ}�X�^
//     */
//    public VRMap getMasterService() {
//        return masterService;
//    }
//
//    /**
//     * �T�[�r�X��ރ}�X�^��ݒ肵�܂��B
//     * 
//     * @param masterService �T�[�r�X��ރ}�X�^
//     */
//    public void setMasterService(VRMap masterService) {
//        this.masterService = masterService;
//    }

    /**
     * ���C�����j���[�c���[��Ԃ��܂��B
     * 
     * @return ���C�����j���[�c���[
     */
    public VRList getMenuTree() {
        return menuTree;
    }

    /**
     * ���C�����j���[�c���[��ݒ肵�܂��B
     * 
     * @param menuTree ���C�����j���[�c���[
     */
    public void setMenuTree(VRList menuTree) {
        this.menuTree = menuTree;
    }
}