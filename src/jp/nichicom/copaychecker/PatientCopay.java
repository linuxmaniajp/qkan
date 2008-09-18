package jp.nichicom.copaychecker;

import java.util.*;
import jp.nichicom.copaychecker.util.*;

//対象者データ保持クラス
public class PatientCopay {

	/**
	 * 提供年月(ログ用)
	 */
	private String target_date = "";
	
	/**
	 * 請求月(ログ用)
	 */
	private String claim_date = "";
	
	/**
	 * 対象者氏名(ログ用)
	 */
	private String patient_nm = "";
	/**
	 * 保険者番号(ログ用)
	 */
	private String insured_id = "";
	
	/**
	 * 事業所番号(ログ用)
	 */
	private String provider_id = "";
	
	/**
	 * 事業所名称(ログ用)
	 */
	private String provider_name = "";
	
	/**
	 * 利用者負担額の計算結果
	 */
	private Map copayMap = new LinkedHashMap();
	private Map copayMapError = new HashMap();
	
	private List log = new ArrayList();
	
	private int copay_total = 0;
	/**
	 * 自己負担額チェック
	 * @param rec
	 * @throws Exception
	 */
	public void checkCopay(Map rec) throws Exception{
		
		//対象者氏名を設定する
		if ("".equals(patient_nm)){
			//PATIENT_FAMILY_NAME,PATIENT_FIRST_NAME,INSURED_ID,PROVIDER_NAME
			target_date = Util.toStr(rec.get("FORMATED_TARGET_DATE"));
			claim_date = Util.toStr(rec.get("FORMATED_CLAIM_DATE"));
			patient_nm = Util.toStr(rec.get("PATIENT_FAMILY_NAME")) + "　"
                    + Util.toStr(rec.get("PATIENT_FIRST_NAME"));
			insured_id = Util.toStr(rec.get("INSURED_ID"));
			provider_id = Util.toStr(rec.get("PROVIDER_ID"));
			provider_name = Util.toStr(rec.get("PROVIDER_NAME"));
		}
		
		//計画単位数
		int plan_unit = Util.toInt(rec.get("PLAN_UNIT_VALUE"));
		//実績単位数
		int limit_unit = Util.toInt(rec.get("LIMIT_UNIT_VALUE"));
		//単位数単価*10
		int unit = Util.toInt(replaceDot(rec.get("UNIT_VALUE")));
		
		if (limit_unit <= plan_unit){
			return;
		}
		
		//正確な自己負担額を算定する
		int copay = (int)Math.floor((double)((limit_unit - plan_unit) * unit) / 100d);
		copay_total += copay;
		//mapに退避
		copayMap.put(rec.get("SERVICE_KIND_NAME"), new Integer(copay));
		
		//誤った自己負担額を算定する
		int copay_error = (int)Math.floor((double)(limit_unit * unit) / 100d) 
						   - (int)Math.floor((double)(plan_unit * unit) / 100d);
		
		copayMapError.put(rec.get("SERVICE_KIND_NAME"), new Integer(copay_error));
	}
	
	public String[] analize(List copay_list) throws Exception {
		switch (copay_list.size()) {
		//利用者自己負担額データなし
		case 0:
			//利用者向け請求への印字なしなので、チェックしない
			break;
			
		//利用者自己負担額データ正常取得
		case 1:
			match((Map)copay_list.get(0));
			break;
			
		//利用者自己負担額データ取得異常
		default:
			Log.warning("自己負担データ件数異常(" + copay_list.size() + "):" + patient_nm + insured_id);
			throw new Exception("自己負担データ件数異常(" + copay_list.size() + "):" + patient_nm + insured_id);
		}
		
		String[] result = new String[log.size()];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = (String)log.get(i);
		}
		
		return result;
	}
	
	private void match(Map copay_rec) throws Exception {
		//自己負担額テーブルの整形
		Map copayDb = new HashMap();
		
		for (int i = 1; i <= 3; i++) {
			if (!Util.isNull((String)copay_rec.get("SELF_PAY_NO" + i))) {
				copayDb.put((String)copay_rec.get("SELF_SERVICE_NO" + i), new Integer((String)copay_rec.get("SELF_PAY_NO" + i)));
			}
		}
		
		
		
		//その他にマージされている可能性を疑う
		if (copayMap.size() > 3) {
			
			//DBにその他の登録があるか
			if (copayDb.containsKey("その他")) {
				if (isCopayDelta(copay_total, Util.toInt(copayDb.get("その他")))) {
					addLogLine("その他", copay_total, Util.toInt(copayDb.get("その他")));
                    return;
				}
			}
		}
		
		Iterator it = copayMap.keySet().iterator();
		
		//請求金額分ループ
		while (it.hasNext()) {
			Object key = it.next();
			
			//DB内をチェック
			if (copayDb.containsKey(key)) {
				//キーが存在すれば、値をチェック
				if (isCopayDelta(copayDb.get(key), copayMap.get(key))){
					addLogLine(key.toString(), Util.toInt(copayMap.get(key)), Util.toInt(copayDb.get(key)));
				}
				
			} else {
				//一致してなかった場合のみ、確認お願いメッセージ
				if (isCopayDelta(copayMap.get(key), copayMapError.get(key))){
					addLogLine(key.toString(), Util.toInt(copayMap.get(key)));
				}
			}
		}
	}
	
	private boolean isCopayDelta(Object sip, Object dip) {
		return isCopayDelta(Util.toInt(sip), Util.toInt(dip));
	}
	
	private boolean isCopayDelta(int sip, int dip) {
		
        int abs = Math.abs(sip - dip);
        
        if ((1 <= abs) && (abs <= 6)) {
            return true;
        }
        return false;
	}
	private void addLogLine(String service_name, int real) {
		StringBuffer line = new StringBuffer();
		
		line.append("全額自己負担額の請求金額が確認できませんでした。");
		line.append(real);
		line.append("円で請求しているか確認してください。");
		
		log.add(getLogLine(service_name, line.toString()));
	}
	
	private void addLogLine(String service_name, int real, int falt) {
		StringBuffer line = new StringBuffer();
		
		line.append(real);
		line.append("円の請求を");
		line.append(falt);
		line.append("円で印字している可能性があります。");
		
		log.add(getLogLine(service_name, line.toString()));
	}
	
	private String getLogLine(String service_name, String msg) {
		StringBuffer line = new StringBuffer();
		
		String separate = ",";

		//被保険者番号
		line.append(insured_id);
		line.append(separate);
		
		//対象者氏名
		line.append(patient_nm);
		line.append(separate);

		//提供サービス
		line.append(service_name);
		line.append(separate);
		
		//詳細
		line.append(msg);
		line.append(separate);
		
		//対象年月
		line.append(target_date);
		line.append(separate);
		
		//請求年月
		line.append(claim_date);
		line.append(separate);
		//事業所番号
		line.append(provider_id);
		line.append(separate);
		
		//事業所名称
		line.append(provider_name);
		
		return line.toString();

	}
	
	
	private String replaceDot(Object value) {
		
		if (value instanceof String) {
			String result = ((String)value).replaceAll("\\.", "");
			
			while(result.length() < 4) {
				result += "0";
			}
			return result;
		}
		return "";
	}
	
}
