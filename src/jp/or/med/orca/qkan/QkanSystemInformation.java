package jp.or.med.orca.qkan;

import java.util.Date;

import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * システム共通情報です。
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
     * ログイン事業者番号です。
     */
    private String loginProviderID = "";

    /**
     * コードマスタです。
     */
    private VRMap masterCode;

//    /**
//     * サービス種類マスタです。
//     */
//    private VRMap masterService;

    /**
     * システム日付（ログイン日付、処理日付）です。
     */
    private Date systemDate;

    /**
     * システムバージョンです。
     */
    private String systemVersion = "";
    /**
     * マスタデータバージョンです。
     */
    private String masterDataVersion = "";
    /**
     * スキーマバージョンです。
     */
    private String schemeVersion = "";

    /**
     * メインメニューツリーです。
     */
    private VRList menuTree;

    /**
     * ログイン事業者番号を返します。
     * 
     * @return ログイン事業者番号
     */
    public String getLoginProviderID() {
        return loginProviderID;
    }

    /**
     * ログイン事業者番号を設定します。
     * 
     * @param loginProviderID ログイン事業者番号
     */
    public void setLoginProviderID(String loginProviderID) {
        this.loginProviderID = loginProviderID;
    }

    /**
     * コンストラクタです。 Singleton Pattern
     */
    protected QkanSystemInformation() {
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanSystemInformation getInstance() {
        if (singleton == null) {
            singleton = new QkanSystemInformation();
        }
        return singleton;
    }

    /**
     * システム日付を返します。
     * 
     * @return システム日付
     */
    public Date getSystemDate() {
        return systemDate;
    }

    /**
     * システム日付を設定します。
     * 
     * @param systemDate システム日付
     */
    public void setSystemDate(Date systemDateO) {
        this.systemDate = systemDateO;
    }

    /**
     * コードマスタを返します。
     * <p>
     * キー「CODE_ID」と値「同じCODE_IDを持つレコードの集合(List)」で構成されます。
     * </p>
     * 
     * @return コードマスタ
     */
    public VRMap getMasterCode() {
        return masterCode;
    }

    /**
     * コードマスタを設定します。
     * <p>
     * キー「CODE_ID」と値「同じCODE_IDを持つレコードの集合(List)」で構成されます。
     * </p>
     * 
     * @param codeMaster コードマスタ
     */
    public void setMasterCode(VRMap codeMaster) {
        this.masterCode = codeMaster;
    }

    /**
     * システムバージョンを返します。
     * 
     * @return システムバージョン
     */
    public String getSystemVersion() {
        return systemVersion;
    }

    /**
     * システムバージョンを設定します。
     * 
     * @param systemVersion システムバージョン
     */
    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    /**
     * マスタデータのバージョンを返します。
     * 
     * @return マスタデータのバージョン
     */
    public String getMasterDataVersion() {
        return masterDataVersion;
    }

    /**
     * マスタデータのバージョンを設定します。
     * 
     * @param masterDataVersion マスタデータのバージョン
     */
    public void setMasterDataVersion(String masterDataVersion) {
        this.masterDataVersion = masterDataVersion;
    }

    /**
     * スキーマのバージョンを返します。
     * 
     * @return スキーマのバージョン
     */
    public String getSchemeVersion() {
        return schemeVersion;
    }

    /**
     * スキーマのバージョンを設定します。
     * 
     * @param schemeVersion スキーマのバージョン
     */
    public void setSchemeVersion(String schemeVersion) {
        this.schemeVersion = schemeVersion;
    }

//    /**
//     * サービス種類マスタを返します。
//     * 
//     * @return サービス種類マスタ
//     */
//    public VRMap getMasterService() {
//        return masterService;
//    }
//
//    /**
//     * サービス種類マスタを設定します。
//     * 
//     * @param masterService サービス種類マスタ
//     */
//    public void setMasterService(VRMap masterService) {
//        this.masterService = masterService;
//    }

    /**
     * メインメニューツリーを返します。
     * 
     * @return メインメニューツリー
     */
    public VRList getMenuTree() {
        return menuTree;
    }

    /**
     * メインメニューツリーを設定します。
     * 
     * @param menuTree メインメニューツリー
     */
    public void setMenuTree(VRList menuTree) {
        this.menuTree = menuTree;
    }
}