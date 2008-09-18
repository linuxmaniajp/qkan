package jp.nichicom.copaychecker;

import java.io.*;
import java.util.*;

import jp.nichicom.copaychecker.util.*;

/**
 * 全額自己負担過誤チェック実行クラス
 * @version 1.00 2008.2.26
 * @author shin fujihara
 */
public class CopayChecker extends Thread { 
	
	private boolean isRun = true;
	
	private int progressCount = 0;
	private String status = " ";
	
	private Exception runException = null;
	
	//チェック開始請求日
	private String checkStartDate = "2008-08-1";
	//チェック終了請求日
	private String checkEndDate = "2008-09-30";
	
	private String[] sameFields = new String[]{"PATIENT_ID", "INSURED_ID", "TARGET_DATE", "CLAIM_DATE", "INSURER_ID", "PROVIDER_ID"};
	
	private boolean isOutLog = false;
	
	public void run(){
		isRun = true;
		try{
			
			Log.info("チェック処理を開始します。");
			
			DBConnect db = new DBConnect();
			BufferedWriter objBw = null;
            
            try{
                // Firebird1.5系だとスキーマに対するAS句は使えないのでVIEWで対応する
                for(int s=0;s < 4; s++){
                    // CreateするView名
                    int count = s+1;
                    String viewName = "";
                    switch(count){
                    case 1:
                        viewName = "TEMP_PLAN_UNIT";
                        break;
                    case 2:
                        viewName = "TEMP_LIMIT_UNIT";
                        break;
                    case 3:
                        viewName = "TEMP_UNIT";
                        break;
                    case 4:
                        viewName = "TEMP_SERVICE";
                        break;
                    }
                    db.exec(getCreateViewSQL(viewName));
                    // コミットする
                    db.commit();
                }
            }catch (Exception e) {
                // 普通にスキップ
            }
			
			try{
				
				//変換結果ログ作成
				Util.makeDir("logs/copaycheck.csv");
				File rec_data = new File("logs/copaycheck.csv");
				
				OutputStreamWriter objOsr = new OutputStreamWriter(
						new FileOutputStream(rec_data));
				objBw = new BufferedWriter(objOsr);
				
				setStatus("対象件数の確認開始",0);
				
				//チェック対象データ全件取得
				List check_list = db.execQuery(getCheckListSQL());
				
				setStatus("対象件数の確認完了",0);
				
				Map comparison = null;
				PatientCopay copay = new PatientCopay();
				int list_total = check_list.size();
				
				for (int i = 0; i < list_total; i++){
					
					Map rec = (Map)check_list.get(i);
					
					if (comparison == null){
						comparison = rec;
					}
					
					//別データに切り替わった場合
					if (!isSameClaim(comparison, rec)) {
						String[] logline = copay.analize(db.execQuery(getCopaySQL(comparison)));
						writeCheckList(objBw, logline);
						
						comparison = rec;
						
						copay = new PatientCopay();
					}
					
					copay.checkCopay(rec);
					
					setStatus(i + "/" + list_total + "件終了しました。", (i * 100) / list_total );
				}
				
				if (comparison != null) {
					String[] logline =copay.analize(db.execQuery(getCopaySQL(comparison)));
					writeCheckList(objBw, logline);
				}
				
				db = null;
				
				
				setStatus(rec_data.getPath() + "に、変換結果を保存しています。", 100);
				
				Log.info("チェック処理を開始が正常終了しました。");
				
			} catch(Exception e) {
				db.rollback();
				throw e;
			} finally{
				db = null;
				if(objBw != null){
					objBw.close();
				}
			}
		} catch(Exception ex){
			runException = ex;
		} finally{
			isRun = false;
		}
	}
	
	private boolean isSameClaim(Map sip, Map dip) {
		
		for (int i = 0; i < sameFields.length; i++){
			if (!sip.get(sameFields[i]).equals(dip.get(sameFields[i]))){
				return false;
			}
		}
		
		return true;
	}
	
    // VIEWの作成
    private String getCreateViewSQL(String viewName) {
        StringBuffer query = new StringBuffer();
        query.append("RECREATE VIEW ");
        query.append(viewName);
        query.append(" AS");
        query.append(" SELECT");
        query.append(" *");
        query.append(" FROM");
        query.append(" CLAIM_DETAIL_TEXT_2008");
        return query.toString(); 
    }
    
	//一覧取得
	private String getCheckListSQL() {
		StringBuffer query = new StringBuffer();
		
		query.append("SELECT DISTINCT");
		query.append(" CLAIM.*,");
		query.append(" TEMP_PLAN_UNIT.DETAIL_VALUE AS PLAN_UNIT_VALUE,");
		query.append(" TEMP_LIMIT_UNIT.DETAIL_VALUE AS LIMIT_UNIT_VALUE,");
		query.append(" TEMP_UNIT.DETAIL_VALUE AS UNIT_VALUE,");
		query.append(" M_SERVICE.SERVICE_KIND_NAME,");
		query.append(" PATIENT.PATIENT_FAMILY_NAME,");
		query.append(" PATIENT.PATIENT_FIRST_NAME,");
		query.append(" PROVIDER.PROVIDER_NAME,");
		query.append(" EXTRACT(YEAR FROM CLAIM.TARGET_DATE) || '年' || EXTRACT(MONTH FROM CLAIM.TARGET_DATE) || '月' AS FORMATED_TARGET_DATE,");
		query.append(" EXTRACT(YEAR FROM CLAIM.CLAIM_DATE) || '年' || EXTRACT(MONTH FROM CLAIM.CLAIM_DATE) || '月' AS FORMATED_CLAIM_DATE");
		
		query.append(" FROM");
		query.append(" CLAIM,");
		query.append(" TEMP_PLAN_UNIT,");
		query.append(" TEMP_LIMIT_UNIT,");
		query.append(" TEMP_UNIT,");
		query.append(" TEMP_SERVICE,");
		query.append(" M_SERVICE,");
		query.append(" PATIENT,");
		query.append(" PROVIDER");
		query.append(" WHERE");
		query.append(" (CLAIM.CLAIM_DATE BETWEEN '" + checkStartDate + "' AND '" + checkEndDate + "')");
		query.append(" AND (CLAIM.CLAIM_ID = TEMP_PLAN_UNIT.CLAIM_ID)");
		query.append(" AND (TEMP_PLAN_UNIT.SYSTEM_BIND_PATH = 701009)");
		query.append(" AND (CLAIM.CLAIM_ID = TEMP_LIMIT_UNIT.CLAIM_ID)");
		query.append(" AND (TEMP_LIMIT_UNIT.SYSTEM_BIND_PATH = 701010)");
		query.append(" AND (CLAIM.CLAIM_ID = TEMP_UNIT.CLAIM_ID)");
		query.append(" AND (TEMP_UNIT.SYSTEM_BIND_PATH = 701015)");
		query.append(" AND (CLAIM.CLAIM_ID = TEMP_SERVICE.CLAIM_ID)");
		query.append(" AND (TEMP_SERVICE.SYSTEM_BIND_PATH = 701007)");
		query.append(" AND (TEMP_SERVICE.DETAIL_VALUE = M_SERVICE.SERVICE_CODE_KIND)");
		query.append(" AND (CLAIM.PATIENT_ID = PATIENT.PATIENT_ID)");
		query.append(" AND (CLAIM.PROVIDER_ID = PROVIDER.PROVIDER_ID)");
		//計画単位数より限度額管理対象単位数が上のデータのみ取得する
		query.append(" AND (CAST(TEMP_PLAN_UNIT.DETAIL_VALUE AS INTEGER) < CAST(TEMP_LIMIT_UNIT.DETAIL_VALUE AS INTEGER))");
		//ソート順指定
		query.append(" ORDER BY");
		query.append(" CLAIM.CLAIM_DATE,");
		query.append(" CLAIM.INSURER_ID,");
		query.append(" CLAIM.PROVIDER_ID,");
		query.append(" CLAIM.INSURED_ID,");
        query.append(" CLAIM.CLAIM_ID");
		
		
		
		return query.toString();

	}
	
	private String getCopaySQL(Map rec) throws Exception {
		StringBuffer query = new StringBuffer();
		
		query.append("SELECT");
		query.append(" CLAIM_PATIENT_DETAIL.SELF_SERVICE_NO1,");
		query.append(" CLAIM_PATIENT_DETAIL.SELF_PAY_NO1,");
		query.append(" CLAIM_PATIENT_DETAIL.SELF_SERVICE_NO2,");
		query.append(" CLAIM_PATIENT_DETAIL.SELF_PAY_NO2,");
		query.append(" CLAIM_PATIENT_DETAIL.SELF_SERVICE_NO3,");
		query.append(" CLAIM_PATIENT_DETAIL.SELF_PAY_NO3");
		query.append(" FROM");
		query.append(" CLAIM,");
		query.append(" CLAIM_PATIENT_DETAIL");
		query.append(" WHERE");
		query.append(" (CLAIM.CLAIM_ID = CLAIM_PATIENT_DETAIL.CLAIM_ID)");
		query.append(" AND (CLAIM.PATIENT_ID = " + rec.get("PATIENT_ID") + ")");
		query.append(" AND (CLAIM.INSURED_ID = '" + rec.get("INSURED_ID") + "')");
		query.append(" AND (CLAIM.TARGET_DATE = '" + rec.get("TARGET_DATE") + "')");
		query.append(" AND (CLAIM.CLAIM_DATE = '" + rec.get("CLAIM_DATE") + "')");
		query.append(" AND (CLAIM.INSURER_ID = '" + rec.get("INSURER_ID") + "')");
		query.append(" AND (CLAIM.PROVIDER_ID = '" + rec.get("PROVIDER_ID") + "')");
		
		return query.toString();
	}
	
	
	private void writeCheckList(BufferedWriter objBw, String[] lines) throws Exception {
		
		for (int i = 0; i < lines.length; i++) {
			
			if (!isOutLog) {
				//ヘッダ出力
				objBw.write("被保険者番号,対象者氏名,提供サービス,詳細,対象年月,請求年月,事業所番号,事業所名称\n");
			}
			objBw.write(lines[i] + "\n");
			isOutLog = true;
		}
		
	}
	
	public boolean existErrorList() {
		return isOutLog;
	}
	
	
	private void setStatus(String title,int value) {
		status = title;
		progressCount = value;
	}
	
	/**
	 * データ更新タスクの実行
	 */
	public boolean runTask(MainFrame frame) throws Exception{
		
		setStatus("対象件数の確認中...",0);
		
		super.start();
		
		while(isRun){
			frame.paintComponents(frame.getGraphics());
			frame.progress.setValue(progressCount);
			frame.status.setText(status);
			Thread.sleep(500);
		}
		
		if(runException != null){
			throw runException;
		}
		
		return true;
	}
}