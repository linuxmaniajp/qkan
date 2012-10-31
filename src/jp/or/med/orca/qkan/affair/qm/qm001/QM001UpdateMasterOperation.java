
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
 */

package jp.or.med.orca.qkan.affair.qm.qm001;

import java.text.DateFormat;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �V�X�e������o�^�\�ȃ}�X�^�̕␳�p����N���X
 * 
 */
public class QM001UpdateMasterOperation {

	private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
	
    /**
     * �R���X�g���N�^
     */
    public QM001UpdateMasterOperation() {
    }

    /**
     * �}�X�^�o�[�W�������擾���܂��B
     * 
     * @param dbm
     * @return version �}�X�^�o�[�W����
     * @throws Exception
     */
    protected String getVersion(ACDBManager dbm) throws Exception {

        String version = "";

        try {
            VRList result = dbm.executeQuery(getSQL_GET_QKAN_VERSION(null));
            version = ACCastUtilities.toString(VRBindPathParser.get(
                    "MASTER_DATA_VERSION", (VRMap) result.get(0)));
        } catch (Exception ex) {
            throw ex;
        }

        return version;

    }

    protected void updateVersion(ACDBManager dbm, String version)
            throws Exception {

        try {
            VRMap param = new VRHashMap();
            VRBindPathParser.set("MASTER_DATA_VERSION", param, version);
            dbm.executeUpdate(getSQL_UPDATE_MASTER_VERSION(param));
        } catch (Exception ex) {
            throw ex;
        }

    }

    /**
     * �X�֔ԍ��e�[�u����PRIMARY KEY�폜
     * 
     * @throws Exception
     */
    protected void dropPostPrimaryKey(ACDBManager dbm) throws Exception {

        try {

            VRMap sqlParam = new VRHashMap();
            VRBindPathParser.set("TABLE_NAME", sqlParam, "M_POST");

            // M_POST��PRIMARY KEY�����擾
            VRList result = dbm.executeQuery(getSQL_PRIMARY_KEY_NAME(sqlParam));
            
            // PRIMARY KEY���ݒ肳��Ă���ꍇ�́Adrop
            if (0 < result.size()) {
                String primaryKeyName = ACCastUtilities.toString(((VRMap)result.get(0)).get("PRIMARY_KEY_NAME"), null);
                primaryKeyName = ACTextUtilities.trim(primaryKeyName);
                
                // null�擾�̏ꍇ�͏����I��
                if (ACTextUtilities.isNullText(primaryKeyName)) {
                    return;
                }
                
                // primary key�폜���s
                VRBindPathParser.set("PRIMARY_KEY_NAME", sqlParam, primaryKeyName);
                dbm.executeUpdate(getSQL_DROP_PRIMARY_KEY(sqlParam));
            }
            
            
            // m_post��index�����݂��邩�m�F
            sqlParam = new VRHashMap();
            VRBindPathParser.set("INDEX_NAME", sqlParam, "IDX_M_POST");
            result = dbm.executeQuery(getSQL_INDEX_EXISTS(sqlParam));
            
            // index�����݂��Ȃ��ꍇ�́A�쐬
            if (result.size() <= 0) {
                // index �t�^
                dbm.executeUpdate(getSQL_CREATE_INDEX_M_POST(null));
            }
            
            
        } catch (Exception ex) {
            throw ex;
        }

    }

    /**
     * �u���t�Ǘ��䒠�V�X�e���́v�̂��߂�SQL��Ԃ��܂��B
     * 
     * @param sqlParam
     *            SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
     * @throws Exception
     *             ������O
     * @return SQL��
     */
    public String getSQL_GET_QKAN_VERSION(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT");

        sb.append(" MASTER_DATA_VERSION");

        sb.append(",SCHEME_VERSION");

        sb.append(" FROM");

        sb.append(" M_QKAN_VERSION");

        return sb.toString();
    }

    /**
     * �u�}�X�^�o�[�W�����X�V�v�̂��߂�SQL��Ԃ��܂��B
     * 
     * @param sqlParam
     *            SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
     * @throws Exception
     *             ������O
     * @return SQL��
     */
    public String getSQL_UPDATE_MASTER_VERSION(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("UPDATE");

        sb.append(" M_QKAN_VERSION");

        sb.append(" SET");

        sb.append(" MASTER_DATA_VERSION");

        sb.append(" =");

        sb.append(ACSQLSafeStringFormat.getInstance().format(
                VRBindPathParser.get("MASTER_DATA_VERSION", sqlParam)));

        sb.append(",");

        sb.append(" LAST_TIME");

        sb.append(" =");

        sb.append(" CURRENT_TIMESTAMP");

        return sb.toString();
    }

    /**
     * �w�肵���e�[�u���̃v���C�}���L�[���̂��擾
     * 
     * @param sqlParam
     *            SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
     * @throws Exception
     *             ������O
     * @return SQL��
     */
    public String getSQL_PRIMARY_KEY_NAME(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT");
        sb.append(" RDB$CONSTRAINT_NAME AS PRIMARY_KEY_NAME");
        sb.append(" FROM");
        sb.append(" RDB$RELATION_CONSTRAINTS");
        sb.append(" WHERE");
        sb.append(" (RDB$RELATION_NAME =");
        sb.append(ACSQLSafeStringFormat.getInstance().format(
                VRBindPathParser.get("TABLE_NAME", sqlParam)));
        sb.append(")");
        sb.append(" AND (RDB$CONSTRAINT_TYPE = 'PRIMARY KEY')");

        return sb.toString();
    }

    /**
     * �w�肵���e�[�u���̃v���C�}���L�[���폜
     * 
     * @param sqlParam
     *            SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
     * @throws Exception
     *             ������O
     * @return SQL��
     */
    public String getSQL_DROP_PRIMARY_KEY(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("ALTER TABLE ");
        sb.append(VRBindPathParser.get("TABLE_NAME", sqlParam));
        sb.append(" DROP CONSTRAINT ");
        sb.append(VRBindPathParser.get("PRIMARY_KEY_NAME", sqlParam));

        return sb.toString();
    }
    
    /**
     * �w�肵���e�[�u���̃v���C�}���L�[���̂��擾
     * 
     * @param sqlParam
     *            SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
     * @throws Exception
     *             ������O
     * @return SQL��
     */
    public String getSQL_INDEX_EXISTS(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * FROM");
        sb.append(" RDB$INDICES");
        sb.append(" WHERE");
        sb.append(" (RDB$INDEX_NAME =");
        sb.append(ACSQLSafeStringFormat.getInstance().format(
                VRBindPathParser.get("INDEX_NAME", sqlParam)));
        sb.append(")");

        return sb.toString();
    }
    
    /**
     * M_POST��POST_CD�ɃC���f�b�N�X��t�^����
     * 
     * @param sqlParam
     *            SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
     * @throws Exception
     *             ������O
     * @return SQL��
     */
    public String getSQL_CREATE_INDEX_M_POST(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("CREATE INDEX IDX_M_POST ON M_POST (POST_CD)");

        return sb.toString();
    }
    
    /**
     * �{�ݏ��̗����Ǘ��ɔ��������f�[�^�̃��J�o��
     * 
     * @param sqlParam
     *            SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
     * @throws Exception
     *             ������O
     */
    public String getSQL_UPDATE_SHISETSU_HISTORY_DATE(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("UPDATE");

        sb.append(" PATIENT_SHISETSU_HISTORY");

        sb.append(" SET");

        sb.append(" SHISETSU_VALID_START");

        sb.append(" =");

        sb.append(dateFormat.format(VRBindPathParser.get("SHISETSU_VALID_START", sqlParam), "yyyy-MM-dd"));

        sb.append(",");

        sb.append(" SHISETSU_VALID_END");

        sb.append(" =");

        sb.append(dateFormat.format(VRBindPathParser.get("SHISETSU_VALID_END", sqlParam), "yyyy-MM-dd"));
        
        sb.append(" WHERE");
        
        sb.append(" SHISETSU_HISTORY_ID");
        
        sb.append(" =");
        
        sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SHISETSU_HISTORY_ID", sqlParam)));
        
        sb.append(" AND");
        
        sb.append(" PATIENT_ID");
        
        sb.append(" =");
        
        sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));
        
        return sb.toString();
    	
    }
    
    /**
     * �{�ݏ��̓��t�����ݒ�̃��R�[�h�����擾���܂�
     * 
     * @return SQL
     * @throws Exception
     */
    public String getSQL_GET_SHISETSU_HISTORY() throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT");

        sb.append(" *");
        
        sb.append(" FROM");
        
        sb.append(" PATIENT_SHISETSU_HISTORY");
        
    	sb.append(" WHERE");
    
    	sb.append(" SHISETSU_VALID_START IS NULL");
    
    	sb.append(" AND");
    
    	sb.append(" SHISETSU_VALID_END IS NULL");

        return sb.toString();
    	
    }
    
    /**
     * �{�ݗ������̖��ݒ背�R�[�h���폜����SQL
     * 
     * @return SQL
     * @throws Exception
     */
    public String getSQL_DELETE_SHISETSU_HISTORY() throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("DELETE");
        
        sb.append(" FROM");
        
        sb.append(" PATIENT_SHISETSU_HISTORY");
        
        sb.append(" WHERE");
        
        sb.append(" TOKUTEI_NYUSHO_FLAG = 1");
        
        sb.append(" AND");
        
        sb.append(" KYUSOCHI_FLAG = 1");
        
        sb.append(" AND");
        
        sb.append(" DISEASE IS NULL");
        
        sb.append(" AND");
        
        sb.append(" SHISETSU_VALID_START IS NULL");
        
        sb.append(" AND");
        
        sb.append(" SHISETSU_VALID_END IS NULL");        
        
        
        return sb.toString();
    }
    
}
