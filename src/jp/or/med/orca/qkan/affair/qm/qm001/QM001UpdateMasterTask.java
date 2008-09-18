/*
 * 作成日: 2006/06/08
 *
 */
package jp.or.med.orca.qkan.affair.qm.qm001;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
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
            
            //
            task3(dbm);
            
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
    
    /**
     * 事業所情報の自動補正
     * @param dbm
     * @throws Exception
     * 
     * @author Masahiko_Higuchi
     * @since V540
     */
    public void task3(ACDBManager dbm) throws Exception{
        
        try{
        QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();
        
            // 短期入所療養介護（老健）
            String tankiRouken = "12211";
            // 老健
            String rouken = "15211";
            // 介護予防短期入所療養介護（老健）
            String yobouTankiRouken = "12511";
            String[] services = {tankiRouken,rouken,yobouTankiRouken};
            // 施設等の区分（体制）、療養体制維持特別加算、ターミナルケア加算
            String[] serviceDetailsTankiRouken = {"1220120","1220121"};
            String[] serviceDetailsRouken = {"1520122","1520123","1520124"};
            String[] serviceDetailsYobouTankiRouken = {"1250116","1250117"};
            // 結果格納用
            VRList resultList = new VRArrayList();
            VRList updateList = new VRArrayList();
            VRMap updateMap;
            VRHashMap sqlParam =null;
            // アップデート前であるかを確認する
            resultList = dbm.executeQuery(op.getSQL_GET_PROVIDER_SERVICE_ROUKEN(null));
            VRMap checkMap = (VRMap)resultList.getData(0);
            // 取得件数が0件の場合は自動補正する。
            if(ACCastUtilities.toInt(checkMap.getData(0),0) == 0){
                resultList = new VRArrayList();
                // ★サービス数ループ
                for(int i=0;i<services.length;i++){
                    sqlParam = new VRHashMap();
                    sqlParam.setData("SYSTEM_SERVICE_KIND_DETAIL",services[i]);
                    // 取得結果
                    resultList = (VRList)dbm.executeQuery(op.getSQL_GET_PROVIDER_SERVICE_ID(sqlParam));
                    // 取得件数ループ
                    for(int k=0;k<resultList.size();k++){
                        VRMap map = (VRMap)resultList.getData(k);
                        updateMap = new VRHashMap();
                        String[] details = {};
                        // 事業所サービスID
                        int id = ACCastUtilities.toInt(map.getData(0),-1);
                        // 謎の値の場合は終了
                        if(id == -1){
                            break;
                        }
                        // 分岐
                        // 項目毎の格納数値を設定
                        if(tankiRouken.equals(services[i])){
                            details = serviceDetailsTankiRouken;
                        }else if(rouken.equals(services[i])){
                            details = serviceDetailsRouken;
                        }else if(yobouTankiRouken.equals(services[i])){
                            details = serviceDetailsYobouTankiRouken;
                        }
                        // 設定
                        for(int j=0;j<details.length;j++){
                            updateMap = new VRHashMap();
                            updateMap.setData("PROVIDER_SERVICE_ID",ACCastUtilities.toInteger(id));
                            updateMap.setData("SYSTEM_BIND_PATH",details[j]);
                            // 初期値は一律『１:なし』で設定する。
                            updateMap.setData("DETAIL_VALUE",new Integer(1));
                            updateList.add(updateMap);
                        }
                    }
                }
                // 更新対象が存在する場合
                if(!updateList.isEmpty()){
                    for(int l=0;l<updateList.size();l++){
                        VRMap result = (VRMap)updateList.getData(l);
                        dbm.executeUpdate(op.getSQL_INSERT_PROVIDER_SERVICE_DETAIL_INTEGER(result));
                    }
                    // コミット
                    dbm.commitTransaction();
                }
            }
            
            
        }catch(Exception ex){
            // ロールバック
            dbm.rollbackTransaction();
        }
        
    }
	
}
