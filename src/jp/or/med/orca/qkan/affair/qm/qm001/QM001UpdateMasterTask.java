/*
 * 作成日: 2006/06/08
 *
 */
package jp.or.med.orca.qkan.affair.qm.qm001;

import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * システムから登録可能なマスタの補正用タスククラス 
 * @author n0153
 *
 */
public class QM001UpdateMasterTask {
	// マスタバージョン
	public String version = "";
	
	/** 
	 * コンストラクタ
	 */
	public QM001UpdateMasterTask(){
	}

	/** 
	 * コンストラクタ
	 */
	public QM001UpdateMasterTask(String version){
		setVersion(version);
	}
	
	/**
	 * バージョン補正タスク管理
	 * @param dbm
	 * @throws Exception
	 */
	public void adjustTask(ACDBManager dbm) throws Exception{
		
		try{

			// 予防版タスク
			task1(dbm);
            
			//訪問看護療養費領収書出荷版タスク
            task2(dbm);
            
		}catch(Exception ex){
			throw ex;
		}
	}
	
	/**
	 * 予防出荷版タスク
	 * @param dbm DBManager
	 * @throws Exception
	 */
	public void task1(ACDBManager dbm) throws Exception{

		try{ 
            QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();
			
			// 追加メニューID
			int menuId = 10707;
			
			VRMap sqlParam = new VRHashMap();
			VRBindPathParser.set("MENU_ID", sqlParam, new Integer(menuId));
			
			// M_MENUが更新されている　かつ　PROVIDER_MENUが更新されていない場合
			// 更新タスクを走らせる。
			if(!(dbm.executeQuery(op.getSQL_GET_EXISTING_M_MENU(sqlParam)).isEmpty()) && 
					(dbm.executeQuery(op.getSQL_GET_EXISTING_PROVIDER_MENU(sqlParam)).isEmpty())){
			
				// 利用者公費サービステーブル
                op.adjustPatientKohiService(dbm);
				
				// 事業所メニューテーブル
                op.adjustProviderMenu(dbm, menuId);
				
				// コミット
				dbm.commitTransaction();
				
			}
			
		}catch(Exception ex){
			dbm.rollbackTransaction();
			throw ex;
		}
	}
    /**
     * 訪問看護療養費領収書出荷版タスク
     * @param dbm DBManager
     * @throws Exception
     */
    public void task2(ACDBManager dbm) throws Exception{

        try{ 
            QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();
            
            // 追加メニューID
            int menuId = 10608;
            
            VRMap sqlParam = new VRHashMap();
            VRBindPathParser.set("MENU_ID", sqlParam, new Integer(menuId));
            
            // M_MENUが更新されている　かつ　PROVIDER_MENUが更新されていない場合
            // 更新タスクを走らせる。
            if(!(dbm.executeQuery(op.getSQL_GET_EXISTING_M_MENU(sqlParam)).isEmpty()) && 
                    (dbm.executeQuery(op.getSQL_GET_EXISTING_PROVIDER_MENU(sqlParam)).isEmpty())){
                            
                // 事業所メニューテーブル
                op.adjustProviderMenu(dbm, menuId);
                
                // コミット
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
