/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKANCHO（JMA care benefit management software）
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

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 基本摘要情報レコード
 *
 */
public class QP001RecordBaseSummary extends QP001RecordAbstract {
	//交換情報識別番号4桁
	private String _1901001 = "";
	//レコード種別コード2桁
	private static final String _1901002 = "16";
	//サービス提供年月6桁(YYYYMM)
	private String _1901003 = "";
	//事業所番号10桁
	private String _1901004 = "";
	//証記載保険者番号8桁
	private String _1901005 = "";
	//被保険者番号10桁
	private String _1901006 = "";
	//摘要種類コード2桁
	private String _1901007 = "";
	//内容 20桁
	private String _1901008 = "";
	

	protected String getSerialId() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/**
	 * レコード種別コード2桁を取得する。
	 * @return
	 */
	protected static String get_1901002() {
		return _1901002;
	}
	/**
	 * 交換情報識別番号4桁を取得する。
	 * @return
	 */
	protected String get_1901001() {
		return _1901001;
	}
	/**
	 * 交換情報識別番号4桁を設定する。
	 * @param _401001
	 */
	protected void set_1901001(String _1901001) {
		this._1901001 = _1901001;
	}
	/**
	 * サービス提供年月6桁(YYYYMM)を取得する。
	 * @return
	 */
	protected String get_1901003() {
		return _1901003;
	}
	/**
	 * サービス提供年月6桁(YYYYMM)を設定する。
	 * @param _1901003
	 */
	protected void set_1901003(String _1901003) {
		this._1901003 = _1901003;
	}
	/**
	 * 事業所番号10桁を取得する。
	 * @return
	 */
	protected String get_1901004() {
		return _1901004;
	}
	/**
	 * 事業所番号10桁を設定する。
	 * @param _1901004
	 */
	protected void set_1901004(String _1901004) {
		this._1901004 = _1901004;
	}
	/**
	 * 証記載保険者番号8桁を取得する。
	 */
	protected String get_1901005() {
		return _1901005;
	}
	/**
	 * 証記載保険者番号8桁を設定する。
	 * @param _1901005
	 */
	protected void set_1901005(String _1901005) {
		this._1901005 = _1901005;
	}
	/**
	 * 被保険者番号10桁を取得する。
	 * @return
	 */
	protected String get_1901006() {
		return _1901006;
	}
	/**
	 * 被保険者番号10桁を設定する。
	 * @param _1901006
	 */
	protected void set_1901006(String _1901006) {
		this._1901006 = _1901006;
	}
	/**
	 * 摘要種類コード2桁
	 * @return
	 */
	protected String get_1901007() {
		return _1901007;
	}
	/**
	 * 摘要種類コード2桁を設定する。
	 * @param _1901007
	 */
	protected void set_1901007(String _1901007) {
		this._1901007 = _1901007;
	}
	/**
	 * 内容 20桁を取得する。
	 * @return
	 */
	protected String get_1901008() {
		return _1901008;
	}
	/**
	 * 内容 20桁を設定する。
	 * @param _1901008
	 */
	protected void set_1901008(String _1901008) {
		this._1901008 = _1901008;
	}
	
	/**
	 * 既に情報が登録されているか返却します。
	 * @return 新規:true 追加:false
	 */
	private boolean isNew(){
		//交換情報レコードに登録が無ければ新規とみなす。
		return ((get_1901001() == null) || ("".equals(get_1901001())));
	}

	/**
	 * データのパースを実行します。
	 * @param serviceDetail
	 * @param targetDate
	 * @param patientState
	 * @param serviceCode
	 * @param identificationNo
	 * @param manager
	 * @param baseSummaryKind
	 * @throws Exception
	 */
	protected void parse(
			VRMap serviceDetail,
			Date targetDate,
			QP001PatientState patientState,
            VRMap serviceCode,
			String identificationNo,
            QP001Manager manager,
            String baseSummaryKind) throws Exception {
		
		Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",serviceDetail);
		if (isNew()) {
			// 交換情報識別番号4桁
			set_1901001(identificationNo);

			// サービス提供年月
			set_1901003(VRDateParser.format(targetDate, "yyyyMM"));

			// 事業所番号
			set_1901004(ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID", serviceDetail)));

			// 証記載保険者番号
			set_1901005(patientState.getInsurerId(targetServiceDate));

			// 被保険者番号
			set_1901006(patientState.getInsuredId(targetServiceDate));
			
			// 摘要種類コード
			set_1901007(baseSummaryKind);
			
			// 内容 20桁
			set_1901008("");
		}
		
	}
	
	/**
	 * レコード内容の確定を行う。
	 */
	protected void commitRecord(QP001PatientState patientState) throws Exception {
        // 基本摘要内容の前月引継ぎ処理
		String lastNaiyo = patientState.getLastRecapitulationCategory19(get_1901001(), get_1901007());
		if (!"".equals(lastNaiyo)) {
			set_1901008(lastNaiyo);
		}		
	}
	
	/**
	 * データ作成
	 * @param style
	 * @return
	 */
	protected VRMap getRecord(VRMap style) throws Exception {
		VRMap result = copyStyle(style);
		
		setData(result,"1901001", get_1901001());
		setData(result,"1901002", get_1901002());
		setData(result,"1901003", get_1901003());
		setData(result,"1901004", get_1901004());
		setData(result,"1901005", get_1901005());
		setData(result,"1901006", get_1901006());
		setData(result,"1901007", get_1901007());
		setData(result,"1901008", get_1901008());
		
		return result;
	}
	
	private VRMap copyStyle(VRMap style){
		VRMap result = new VRHashMap();
		Object key;
		//ディープコピー
		Iterator it = style.keySet().iterator();
		while(it.hasNext()){
			key = it.next();
			result.put(key,style.get(key));
		}
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_RECORD_BASE_SUMMARY);
		return result;
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append("[1901001=" + get_1901001() + "]\n");
		result.append("[1901002=" + get_1901002() + "]\n");
		result.append("[1901003=" + get_1901003() + "]\n");
		result.append("[1901004=" + get_1901004() + "]\n");
		result.append("[1901005=" + get_1901005() + "]\n");
		result.append("[1901006=" + get_1901006() + "]\n");
		result.append("[1901007=" + get_1901007() + "]\n");
		result.append("[1901008=" + get_1901008() + "]\n");
		
		return result.toString();
		
	}
}
