/*
 * �쐬��: 2006/06/08
 *
 */
package jp.or.med.orca.qkan.affair.qm.qm001;

import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * �V�X�e������o�^�\�ȃ}�X�^�̕␳�p�^�X�N�N���X 
 * @author n0153
 *
 */
public class QM001UpdateMasterTask {
	// �}�X�^�o�[�W����
	public String version = "";
	
	/** 
	 * �R���X�g���N�^
	 */
	public QM001UpdateMasterTask(){
	}

	/** 
	 * �R���X�g���N�^
	 */
	public QM001UpdateMasterTask(String version){
		setVersion(version);
	}
	
	/**
	 * �o�[�W�����␳�^�X�N�Ǘ�
	 * @param dbm
	 * @throws Exception
	 */
	public void adjustTask(ACDBManager dbm) throws Exception{
		
		try{

			// �\�h�Ń^�X�N
			task1(dbm);
            
			//�K��Ō�×{��̎����o�הŃ^�X�N
            task2(dbm);
            
		}catch(Exception ex){
			throw ex;
		}
	}
	
	/**
	 * �\�h�o�הŃ^�X�N
	 * @param dbm DBManager
	 * @throws Exception
	 */
	public void task1(ACDBManager dbm) throws Exception{

		try{ 
            QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();
			
			// �ǉ����j���[ID
			int menuId = 10707;
			
			VRMap sqlParam = new VRHashMap();
			VRBindPathParser.set("MENU_ID", sqlParam, new Integer(menuId));
			
			// M_MENU���X�V����Ă���@���@PROVIDER_MENU���X�V����Ă��Ȃ��ꍇ
			// �X�V�^�X�N�𑖂点��B
			if(!(dbm.executeQuery(op.getSQL_GET_EXISTING_M_MENU(sqlParam)).isEmpty()) && 
					(dbm.executeQuery(op.getSQL_GET_EXISTING_PROVIDER_MENU(sqlParam)).isEmpty())){
			
				// ���p�Ҍ���T�[�r�X�e�[�u��
                op.adjustPatientKohiService(dbm);
				
				// ���Ə����j���[�e�[�u��
                op.adjustProviderMenu(dbm, menuId);
				
				// �R�~�b�g
				dbm.commitTransaction();
				
			}
			
		}catch(Exception ex){
			dbm.rollbackTransaction();
			throw ex;
		}
	}
    /**
     * �K��Ō�×{��̎����o�הŃ^�X�N
     * @param dbm DBManager
     * @throws Exception
     */
    public void task2(ACDBManager dbm) throws Exception{

        try{ 
            QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();
            
            // �ǉ����j���[ID
            int menuId = 10608;
            
            VRMap sqlParam = new VRHashMap();
            VRBindPathParser.set("MENU_ID", sqlParam, new Integer(menuId));
            
            // M_MENU���X�V����Ă���@���@PROVIDER_MENU���X�V����Ă��Ȃ��ꍇ
            // �X�V�^�X�N�𑖂点��B
            if(!(dbm.executeQuery(op.getSQL_GET_EXISTING_M_MENU(sqlParam)).isEmpty()) && 
                    (dbm.executeQuery(op.getSQL_GET_EXISTING_PROVIDER_MENU(sqlParam)).isEmpty())){
                            
                // ���Ə����j���[�e�[�u��
                op.adjustProviderMenu(dbm, menuId);
                
                // �R�~�b�g
                dbm.commitTransaction();
                
            }
            
        }catch(Exception ex){
            dbm.rollbackTransaction();
            throw ex;
        }
    }
    
	public void setVersion(String version){
		this.version = version;
	}
	
	public String getVersion(){
		return this.version;
	}
	
}
