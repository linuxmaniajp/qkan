/*
 * 作成日: 2006/06/08
 *
 */
package jp.or.med.orca.qkan.affair.qm.qm001;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

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
            
            //老健に関する事業所情報の自動補正(V540)
            task3(dbm);
            
            //平成21年4月法改正における事業所体制の移行(V545)
            task4(dbm);
            
            //平成21年4月法改正　利用者の公費情報補正(V546)
            task5(dbm);
            
            
            // [ID:0000493][Tozo TANAKA] 2009/04/28 add begin 【DB補正】不正なサービスデータ(特定診療費等)削除対応
            ArrayList tableYears = taskDeleteJunkServiceDetail(dbm);
            // [ID:0000493][Tozo TANAKA] 2009/04/28 add end 【DB補正】不正なサービスデータ(特定診療費等)削除対応

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
     * 老健に関する事業所情報の自動補正(V540)
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
    // [ID:0000444][Tozo TANAKA] 2009/03/12 add begin 平成21年4月法改正対応
    /**
     * 平成21年4月法改正における事業所体制の移行(V545)
     * @param dbm
     * @throws Exception
     * 
     * @author Tozo_TANAKA
     * @since V545
     */
    public void task4(ACDBManager dbm) throws Exception{
        try{ 
            QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();

            //※アップデート前であるかを確認する。
            //法改正後の事業所体制にしか存在しないBindPathで検索をかける。
            VRList rows = dbm.executeQuery(op
                    .getSQL_GET_PROVIDER_SERVICE_DETAIL_H2104(null));
            if (rows.size() > 0
                    && (ACCastUtilities.toInt(((Map) rows.get(0))
                            .get("COUNTVAL"), 0) > 0)) {
                // 取得件数が0件でなければ補正の必要がないため、処理を終了する。
                return;
            }
            
            // ＜そのまま移行＞
            String[][] listForCopy = new String[][] {
            // 通所介護/栄養改善体制/
                    { "1150108", "1150113", },
                    // 通所介護/施設等の区分/
                    { "1150101", "1150115", },
                    // 通所介護/個別機能訓練体制/
                    { "1150102", "1150116", },
                    // 通所リハ/施設等の区分/
                    { "1160101", "1160112", },
                    // 短期入所療養介護（介護老人保健施設）/職員の欠員による減算の状況/
                    { "1220108", "1220126", },
                    // 短期入所療養介護（病院療養型）/施設等の区分/
                    { "1230101", "1230124", },
                    // 短期入所療養介護（病院療養型）/人員配置区分/
                    { "1230102", "1230126", },
                    // 短期入所療養介護（病院療養型）/ユニットケア体制/
                    { "1230118", "1230127", },
                    // 特定施設入居者生活介護/施設等の区分/
                    { "1330105", "1330108", },
                    // 居宅介護支援/特定体制整備事業所加算の有無/
                    { "1430103", "1430104", },
                    // 介護老人福祉施設/栄養マネジメント体制/
                    { "1510109", "1510134", },
                    // 介護老人保健施設/栄養マネジメント体制/
                    { "1520106", "1520130", },
                    // 介護老人保健施設/職員の欠員による減算の状況/
                    { "1520109", "1520131", },
                    // 介護療養型医療施設（病院療養型）/栄養マネジメント体制/
                    { "1530107", "1530126", },
                    // 介護療養型医療施設（病院療養型）/施設等の区分/
                    { "1530101", "1530128", },
                    // 介護療養型医療施設（病院療養型）/人員配置区分/
                    { "1530102", "1530129", },
                    // 介護療養型医療施設（病院療養型）/ユニットケア体制/
                    { "1530119", "1530131", },
                    // 介護療養型医療施設（診療所型）/栄養マネジメント体制/
                    { "1530205", "1530225", },
                    // 介護療養型医療施設（認知症疾患型）/栄養マネジメント体制/
                    { "1530304", "1530322", },
                    // 認知症対応型通所介護/栄養改善体制/
                    { "1720104", "1720109", },
                    // 地域密着型介護老人福祉施設/栄養マネジメント体制/
                    { "1540109", "1540135", },
                    // 介護予防短期入所療養介護（介護老人保健施設）/職員の欠員による減算の状況/
                    { "1250103", "1250122", },
                    // 介護予防短期入所療養介護（病院療養型）/施設等の区分/
                    { "1260101", "1260122", },
                    // 介護予防短期入所療養介護（病院療養型）/人員配置区分/
                    { "1260102", "1260123", },
                    // 介護予防短期入所療養介護（病院療養型）/夜間勤務条件基準/
                    { "1260103", "1260124", },
                    // 介護予防短期入所療養介護（病院療養型）/ユニットケア体制/
                    { "1260105", "1260125", }, };
            // ＜1以外は2に移行＞
            String[][] listFor1Or2 = new String[][] {
            // 短期入所療養介護（病院療養型）/療養環境基準/
                    { "1230104", "1230123", },
                    // 介護療養型医療施設（病院療養型）/療養環境基準/
                    { "1530104", "1530127", },
                    // 介護予防短期入所療養介護（病院療養型）/療養環境基準/
                    { "1260106", "1260121", }, };

            // ＜4のみ6に移行＞
            String[][] listFor4To6 = new String[][] {
            // 短期入所療養介護（病院療養型）/夜間勤務条件基準/
                    { "1230103", "1230125", },
                    // 介護療養型医療施設（病院療養型）/夜間勤務条件基準/
                    { "1530103", "1530130", }, };

            VRArrayList providerDetails = QkanCommon
                    .getProviderServiceDetailCustom(dbm, "");

            Iterator it = providerDetails.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                int end;
                // キーの単純転記
                end = listForCopy.length;
                for (int i = 0; i < end; i++) {
                    Object val = VRBindPathParser.get(listForCopy[i][0], row);
                    if (val != null) {
                        VRBindPathParser.set(listForCopy[i][1], row, val);
                    }
                }

                // ※リハビリ提供体制/理学療法の移行
                // リハビリ提供体制/理学療法 II → 理学療法 I
                if (ACCastUtilities.toInt(VRBindPathParser.get("3010104", row),
                        0) == 2) {
                    // 理学療法 IIの値が2(チェックが付いている)の場合
                    // 理学療法 Iの値を2(チェックが付いている)にする。
                    VRBindPathParser.set("3010103", row, new Integer(2));
                }
                // 理学療法 IIのキーを削除する。
                row.remove("3010104");

                // ※療養環境基準の移行
                // 1以外は2として転記
                end = listFor1Or2.length;
                for (int i = 0; i < end; i++) {
                    Object val = VRBindPathParser.get(listFor1Or2[i][0], row);
                    if (val != null) {
                        Object newVal = new Integer(2);
                        if (ACCastUtilities.toInt(val, 0) == 1) {
                            newVal = val;
                        }
                        VRBindPathParser.set(listFor1Or2[i][1], row, newVal);
                    }
                }

                // ※夜間勤務条件基準の移行
                // 4のみ6として転記
                end = listFor4To6.length;
                for (int i = 0; i < end; i++) {
                    Object val = VRBindPathParser.get(listFor4To6[i][0], row);
                    if (val != null) {
                        Object newVal = val;
                        if (ACCastUtilities.toInt(val, 0) == 4) {
                            newVal = new Integer(6);
                        }
                        VRBindPathParser.set(listFor4To6[i][1], row, newVal);
                    }
                }

            }

            // 更新
             QkanCommon.updateProviderServiceDetailCustom(dbm,
             providerDetails, "(PROVIDER_ID IS NOT NULL)");
            
        }catch(Exception ex){
            dbm.rollbackTransaction();
            throw ex;
        }
    }     
    // [ID:0000444][Tozo TANAKA] 2009/03/12 add end

    // [ID:0000447][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
    /**
     * 平成21年4月法改正　利用者の公費情報補正(V546)
     * @param dbm
     * @throws Exception
     * 
     * @author Shin Fujihara
     * @since V546
     */
    public void task5(ACDBManager dbm) throws Exception{
        try{ 
            QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();
            
            String[][] kohiList = new String[][]{
            		//結核予防法「一般患者」
            		{"1001","12211"},
            		{"1001","12511"},
            		{"1001","15211"},
            		//8102:原爆(地方単独・介護保険)
            		{"8102","17311"},
            		{"8102","17511"}
            };
            
            for (int i = 0; i < kohiList.length; i++){            	
            	VRMap sqlParam = new VRHashMap();
            	sqlParam.put("KOHI_TYPE", kohiList[i][0]);
            	sqlParam.put("SYSTEM_SERVICE_KIND_DETAIL", kohiList[i][1]);
            	//修正
            	VRList list = dbm.executeQuery(op.getSQL_GET_PATIENT_KOHI_H2104(sqlParam));
            	
            	Iterator it = list.iterator();
            	
            	while(it.hasNext()){
            		VRMap row = (VRMap)it.next();
            		row.put("SYSTEM_SERVICE_KIND_DETAIL", kohiList[i][1]);
            		dbm.executeUpdate(op.getSQL_INSERT_PATIENT_KOHI_H2104(row));
            	}
            }
            
        }catch(Exception ex){
            dbm.rollbackTransaction();
            throw ex;
        }
    }     
    // [ID:0000447][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
    
    
    // [ID:0000493][Tozo TANAKA] 2009/04/28 add begin 【DB補正】不正なサービスデータ(特定診療費等)削除対応
    public ArrayList taskDeleteJunkServiceDetail(ACDBManager dbm) throws Exception{
        ArrayList tableYears = new ArrayList();
        try{ 
            QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();
            
            VRList rows = dbm.executeQuery(op.getSQL_GET_SERVICE_DETAIL_YEAR_RANGE(null));
            if(!rows.isEmpty()){
                VRMap row = (VRMap)rows.get(0);
                int minumumYear = ACCastUtilities.toInt(row.get("MINIMUM_YEAR"),0);
                int maximumYear = ACCastUtilities.toInt(row.get("MAXIMUM_YEAR"),0);
                for(int year=minumumYear; year<=maximumYear; year++){
                    try{
                        VRMap sqlParam = new VRHashMap();
                        sqlParam.put("YEAR", ACCastUtilities.toInteger(year));
                        
                        //テーブル存在チェック
                        dbm.executeQuery(op.getSQL_GET_SERVICE_DETAIL_TABLE_ROWS(sqlParam));
                        
                        //エラーでなければ存在
                        //特定診療費の重度療養管理(3010142)の削除
                        dbm.executeUpdate(op.getSQL_DELETE_JUNK_SERVICE_DETAIL1(sqlParam));
                        //介護療養型医療施設の特定診療費の重度療養管理(3010104)の削除
                        dbm.executeUpdate(op.getSQL_DELETE_JUNK_SERVICE_DETAIL2(sqlParam));
                        
				        // [ID:0000503][Masahiko Higuchi] 2009/05/01 add begin【サービス予定・実績】特定診療費項目の表示制御の改修
                        dbm.executeUpdate(op.getSQL_DELETE_JUNK_SERVICE_DETAIL3(sqlParam));
                        dbm.executeUpdate(op.getSQL_DELETE_JUNK_SERVICE_DETAIL4(sqlParam));
				        // [ID:0000503][Masahiko Higuchi] 2009/05/01 add end
                        
                        tableYears.add(new Integer(year));
                    }catch(Exception ex){
                        //テーブル不存在につきエラーを無視
                    }
                }   
            }
            
        }catch(Exception ex){
            dbm.rollbackTransaction();
            throw ex;
        }
        return tableYears;
    }     
    // [ID:0000493][Tozo TANAKA] 2009/04/28 add end 【DB補正】不正なサービスデータ(特定診療費等)削除対応
    
}
