package jp.or.med.orca.qkan.affair;

import jp.nichicom.ac.core.version.ACDefaultVersionAdjustmentListener;
import jp.nichicom.ac.sql.ACDBManager;
import jp.or.med.orca.qkan.QkanSystemInformation;
/**
 * �o�[�W������񍷈ٕ␳���X�i�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/03/28
 */
public class QkanVersionAdjustmentListener extends
        ACDefaultVersionAdjustmentListener {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QkanVersionAdjustmentListener() {
        super();
    }
    
    /**
     * �R���X�g���N�^�ł��B
     * 
     * @param dbm DB�}�l�[�W��
     */
    public QkanVersionAdjustmentListener(ACDBManager dbm) {
        super(dbm);
    }
    
    protected String getDBVersionTableName() {
        return "M_QKAN_VERSION";
    }
    protected String getSystemVersionKey() {
        return "Version/no";
    }
    protected String getMasterDataVersionKey() {
        return "MASTER_DATA_VERSION";
    }
    protected String getSchemeVersionKey() {
        return "SCHEME_VERSION";
    }
    protected void setSystemVersion(String version) throws Exception {
        super.setSystemVersion(version);
        QkanSystemInformation.getInstance().setSystemVersion(version);
    }
}
