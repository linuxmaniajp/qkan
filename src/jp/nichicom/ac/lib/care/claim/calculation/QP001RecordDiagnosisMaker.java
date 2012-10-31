
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
 *****************************************************************
 * アプリ: QKANCHO
 * 開発者: 藤原　伸
 * 作成日: 2006/01/24  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 特定疾患レコード (QP001RecordDiagnosisMaker)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRMap;

/**
 * 特定疾患レコードの作成を行います。
 *
 */
public class QP001RecordDiagnosisMaker {
	
	private String serialHeader = "";
	private String identificationNo = "";
	private VRMap serviceDetail = null;
	private Date targetDate = null;
	private QP001PatientState patientState = null;
	private VRMap serviceCode = null;
	private Map<String, QP001RecordDiagnosis> diagnosisMap = null;
    
    /**
     * 外泊フラグ
     */
    private int gaihaku = 0;
    
    private QP001Manager manager = null;
    
    /**
     * 30日超フラグ
     * (30歳超フラグではない。)
     */
	private boolean over30 = false;

	protected QP001RecordDiagnosisMaker(
			 String identificationNo,
			 VRMap serviceDetail,
			 Date targetDate,
			 Object targetServiceDate,
			 QP001PatientState patientState,
			 VRMap serviceCode,
			 Map<String, QP001RecordDiagnosis> diagnosisMap,
             QP001Manager manager) throws Exception {
        
        gaihaku = CareServiceCommon.isGaihaku(serviceDetail);
        
        //30日超であればレコードの作成を中断する。
        if(ACCastUtilities.toInt(serviceDetail.get("5"),0) == 2){
            over30 = true;
        }
		
		StringBuilder sb = new StringBuilder();
		//交換識別番号
		sb.append(identificationNo);
		//レコード種別コード2桁
		sb.append(QP001RecordDiagnosis.get_501002());
		//サービス提供年月6桁(YYYYMM)
		sb.append(VRDateParser.format(targetDate,"yyyyMM"));
		//事業所番号10桁
		sb.append(VRBindPathParser.get("PROVIDER_ID",serviceDetail));
		//証記載保険者番号8桁
		sb.append(patientState.getInsurerId(targetServiceDate));
		//被保険者番号10桁
		sb.append(patientState.getInsuredId(targetServiceDate));
		//システム内サービス種類コード
		sb.append(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", serviceDetail));
		
		//シリアル番号を設定。
		serialHeader = sb.toString();
		
		this.identificationNo = identificationNo;
		this.serviceDetail = serviceDetail;
		this.targetDate = targetDate;
		this.patientState = patientState;
		this.serviceCode = serviceCode;
		this.diagnosisMap = diagnosisMap;
        this.manager = manager;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	protected Map<String, QP001RecordDiagnosis> make() throws Exception{
        
        //外泊ならば作成を中断する。
        if(gaihaku == 2){
            return diagnosisMap;
        }
        
        //30日超なら作成を中断する。
        if(over30){
            return diagnosisMap;
        }
        
		int result = 0;
		//(特定診療費 指導管理等)感染対策指導管理チェック
		result = getValue("3010101");
		if(result != 0){
			parseRecord("01",result);
		}
		//(特定診療費 指導管理等)褥瘡対策指導管理チェック
		result = getValue("3010102");
		if(result != 0){
			parseRecord("34",result);
		}
		//(特定診療費 指導管理等)初期入院診療管理チェック
		result = getValue("3010103");
		if(result != 0){
			parseRecord("05",result);
		}
		//(特定診療費 指導管理等)重要療養管理チェック
		result = getValue("3010104");
		if(result != 0){
			parseRecord("35",result);
		}
		//(特定診療費 指導管理等)特定施設管理チェック
		result = getValue("3010105");
		if(result != 0){
			parseRecord("02",result);
		}
		//(特定診療費 指導管理等)特定施設管理個室加算チェック
		result = getValue("3010106");
		if(result != 0){
			parseRecord("03",result);
		}
		//(特定診療費 指導管理等)特定施設管理２人部屋加算チェック
		result = getValue("3010107");
		if(result != 0){
			parseRecord("04",result);
		}
		//(特定診療費 指導管理等)重症皮膚潰瘍管理指導チェック
		result = getValue("3010108");
		if(result != 0){
			parseRecord("06",result);
		}
        //まゆまゆがいらないと言いました。
//		//(特定診療費 指導管理等)介護栄養食事指導チェック
//		result = getValue("3010109");
//		if(result != 0){
//			parseRecord("08",result);
//		}
		//(特定診療費 指導管理等)薬剤管理指導チェック
		result = getValue("3010110");
		if(result != 0){
			parseRecord("09",result);
		}
		//(特定診療費 指導管理等)特別薬剤管理指導加算チェック
		result = getValue("3010111");
		if(result != 0){
			parseRecord("10",result);
		}
		//(特定診療費 指導管理等)医学情報提供(Ⅰ)チェック
		result = getValue("3010112");
		if(result != 0){
			parseRecord("11",result);
		}
		//(特定診療費 指導管理等)医学情報提供(Ⅱ)チェック
		result = getValue("3010113");
		if(result != 0){
			parseRecord("12",result);
		}
		//(特定診療費 リハビリテーション)理学療法(Ⅰ)回数-0・1・2・3
		result = getValue("3010114");
		if(result != 0){
			parseRecord("14",result);
		}
		//(特定診療費 リハビリテーション)理学療法(Ⅱ)回数-0・1・2・3
		result = getValue("3010115");
		if(result != 0){
			parseRecord("16",result);
		}
		//(特定診療費 リハビリテーション)理学療法(Ⅲ)回数-0・1・2・3
		result = getValue("3010116");
		if(result != 0){
			parseRecord("18",result);
		}
		//(特定診療費 リハビリテーション)理学療法(Ⅳ)回数-0・1・2・3
		result = getValue("3010117");
		if(result != 0){
			parseRecord("19",result);
		}
		//(特定診療費 リハビリテーション)理学療法(Ⅰ)(減算)回数-0・1・2・3
		result = getValue("3010118");
		if(result != 0){
			parseRecord("40",result);
		}
		//(特定診療費 リハビリテーション)理学療法(Ⅱ)(減算)回数-0・1・2・3
		result = getValue("3010119");
		if(result != 0){
			parseRecord("41",result);
		}
		//(特定診療費 リハビリテーション)理学療法(Ⅲ)(減算)回数-0・1・2・3
		result = getValue("3010120");
		if(result != 0){
			parseRecord("42",result);
		}
		//(特定診療費 リハビリテーション)理学療法(Ⅳ)(減算)回数-0・1・2・3
		result = getValue("3010121");
		if(result != 0){
			parseRecord("43",result);
		}
		//(特定診療費 リハビリテーション)理学療法日常生活活動訓練加算回数-0・1・2・3
		result = getValue("3010122");
		if(result != 0){
			parseRecord("36",result);
		}
		//(特定診療費 リハビリテーション)理学療法リハビリ計画加算チェック
		result = getValue("3010123");
		if(result != 0){
			parseRecord("20",result);
		}
		//(特定診療費 リハビリテーション)理学療法日常動作訓練指導加算チェック
		result = getValue("3010124");
		if(result != 0){
			parseRecord("22",result);
		}
		//(特定診療費 リハビリテーション)作業療法(Ⅰ)回数-0・1・2・3
		result = getValue("3010125");
		if(result != 0){
			parseRecord("23",result);
		}
		//(特定診療費 リハビリテーション)作業療法(Ⅱ)回数-0・1・2・3
		result = getValue("3010126");
		if(result != 0){
			parseRecord("25",result);
		}
		//(特定診療費 リハビリテーション)作業療法(Ⅰ)(減算)回数-0・1・2・3
		result = getValue("3010127");
		if(result != 0){
			parseRecord("44",result);
		}
		//(特定診療費 リハビリテーション)作業療法(Ⅱ)(減算)回数-0・1・2・3
		result = getValue("3010128");
		if(result != 0){
			parseRecord("45",result);
		}
		//(特定診療費 リハビリテーション)作業療法日常生活活動訓練加算回数-0・1・2・3
		result = getValue("3010129");
		if(result != 0){
			parseRecord("37",result);
		}
		//(特定診療費 リハビリテーション)作業療法リハビリ計画加算チェック
		result = getValue("3010130");
		if(result != 0){
			parseRecord("27",result);
		}
		//(特定診療費 リハビリテーション)作業療法日常動作訓練指導加算チェック
		result = getValue("3010131");
		if(result != 0){
			parseRecord("29",result);
		}
		//(特定診療費 リハビリテーション)言語聴覚療法(Ⅰ)回数-0・1・2・3
		result = getValue("3010132");
		if(result != 0){
			parseRecord("38",result);
		}
		//(特定診療費 リハビリテーション)言語聴覚療法(Ⅱ)回数-0・1・2・3
		result = getValue("3010133");
		if(result != 0){
			parseRecord("39",result);
		}
		//(特定診療費 リハビリテーション)言語聴覚療法(Ⅰ)(減算)回数-0・1・2・3
		result = getValue("3010134");
		if(result != 0){
			parseRecord("46",result);
		}
		//(特定診療費 リハビリテーション)言語聴覚療法(Ⅱ)(減算)回数-0・1・2・3
		result = getValue("3010135");
		if(result != 0){
			parseRecord("47",result);
		}
		//(特定診療費 リハビリテーション)摂食機能療法チェック
		result = getValue("3010136");
		if(result != 0){
			parseRecord("31",result);
		}
		//(特定診療費 精神科専門療法)精神科作業療法チェック
		result = getValue("3010137");
		if(result != 0){
			parseRecord("32",result);
		}
		//(特定診療費 精神科専門療法)認知症性老人入院精神療法チェック
		result = getValue("3010138");
		if(result != 0){
			parseRecord("33",result);
		}
        //(特定診療費 リハビリテーション)理学療法リハビリ体制強化加算チェック
        result = getValue("3010139");
        if(result != 0){
            parseRecord("48",result);
        }
        //(特定診療費 リハビリテーション)作業療法リハビリ体制強化加算チェック
        result = getValue("3010140");
        if(result != 0){
            parseRecord("49",result);
        }
        //(特定診療費 リハビリテーション)言語聴覚療法リハビリ体制強化加算チェック
        result = getValue("3010141");
        if(result != 0){
            parseRecord("50",result);
        }
        //リハビリマネジメント加算
        result = getValue("3010142");
        if(result != 0){
            parseRecord("51",result);
        }
        //短期集中リハビリ加算
        result = getValue("3010143");
        if(result != 0){
            parseRecord("52",result);
        }
		
        //[ID:0000454][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
        //集団コミュニケーション療法
        result = getValue("3010150");
        if(result != 0){
            parseRecord("54",result);
        }
        //認知症短期集中リハビリ加算
        result = getValue("3010151");
        if(result != 0){
            parseRecord("55",result);
        }
        //[ID:0000454][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
        
		return diagnosisMap;
	}
	
	//[H20.5 法改正対応] fujihara add start
	protected Map<String, QP001RecordDiagnosis> makeRecuperation() throws Exception{
        
        //外泊ならば作成を中断する。
        if(gaihaku == 2){
            return diagnosisMap;
        }
        
        //30日超なら作成を中断する。
        if(over30){
            return diagnosisMap;
        }
        
		int result = 0;
		//(特別療養費 指導管理等)感染対策指導管理チェック
		result = getValue("3010101");
		if(result != 0){
			parseRecord("01",result, 2);
		}
		//(特別療養費 指導管理等)特定施設管理チェック
		result = getValue("3010105");
		if(result != 0){
			parseRecord("02",result, 2);
		}
		//(特別療養費 指導管理等)特定施設管理個室加算チェック
		result = getValue("3010106");
		if(result != 0){
			parseRecord("03",result, 2);
		}
		//(特別療養費 指導管理等)特定施設管理２人部屋加算チェック
		result = getValue("3010107");
		if(result != 0){
			parseRecord("04",result, 2);
		}
		//(特別療養費 指導管理等)初期入所診療管理チェック
		result = getValue("3010144");
		if(result != 0){
			parseRecord("05",result, 2);
		}
		//(特別療養費 指導管理等)重症皮膚潰瘍管理指導チェック
		result = getValue("3010108");
		if(result != 0){
			parseRecord("06",result, 2);
		}
		//(特別療養費 指導管理等)薬剤管理指導チェック
		result = getValue("3010110");
		if(result != 0){
			parseRecord("09",result, 2);
		}
		//(特別療養費 指導管理等)特別薬剤管理指導加算チェック
		result = getValue("3010111");
		if(result != 0){
			parseRecord("10",result, 2);
		}
		//(特別療養費 指導管理等)医学情報提供チェック
		result = getValue("3010145");
		if(result != 0){
			parseRecord("11",result, 2);
		}
		//(特別療養費 リハビリテーション)摂食機能療法チェック
		result = getValue("3010136");
		if(result != 0){
			parseRecord("31",result, 2);
		}
		//(特別療養費 精神科専門療法)精神科作業療法チェック
		result = getValue("3010137");
		if(result != 0){
			parseRecord("32",result, 2);
		}
		//(特別療養費 精神科専門療法)認知症性老人入所精神療法チェック
		result = getValue("3010149");
		if(result != 0){
			parseRecord("33",result, 2);
		}
		//(特別療養費 指導管理等)褥瘡対策指導管理チェック
		result = getValue("3010102");
		if(result != 0){
			parseRecord("34",result, 2);
		}
		//(特別療養費 指導管理等)重要療養管理チェック
		result = getValue("3010104");
		if(result != 0){
			parseRecord("35",result, 2);
		}
		//(特別療養費 リハビリテーション)言語聴覚療法
		result = getValue("3010147");
		if(result != 0){
			parseRecord("39",result, 2);
		}
		//(特別療養費 リハビリテーション)言語聴覚療法(減算)
		result = getValue("3010148");
		if(result != 0){
			parseRecord("47",result, 2);
		}
        //(特別療養費 リハビリテーション)言語聴覚療法リハビリ体制強化加算チェック
        result = getValue("3010141");
        if(result != 0){
            parseRecord("50",result, 2);
        }
        //リハビリテーション指導管理
        result = getValue("3010146");
        if(result != 0){
            parseRecord("53",result, 2);
        }
		
		return diagnosisMap;
	}
	//[H20.5 法改正対応] fujihara add end
	
	private int getValue(String key) throws Exception {
		int result = 0;
		//キーが存在するか確認
		if(serviceDetail.containsKey(key)){
			result = ACCastUtilities.toInt(VRBindPathParser.get(key,serviceDetail), 0);
		}
		return result;
	}
	//[H20.5 法改正対応] fujihara edit start
	private void parseRecord(String specialClinicType, int count) throws Exception {
		parseRecord(specialClinicType, count, 1);
	}
	private void parseRecord(String specialClinicType, int count, int recordType) throws Exception {
	
		QP001RecordDiagnosis diagnosis = getRecord(specialClinicType);
		diagnosis.parse(serviceDetail,targetDate,patientState,serviceCode,identificationNo,specialClinicType,count,manager,recordType);
	}
	
	private QP001RecordDiagnosis getRecord(String specialClinicType) throws Exception {
		QP001RecordDiagnosis diagnosis = null;
		String serial = this.serialHeader + specialClinicType;
		if(diagnosisMap.containsKey(serial)){
			diagnosis = (QP001RecordDiagnosis)diagnosisMap.get(serial);
		} else {
			diagnosis = new QP001RecordDiagnosis();
			diagnosisMap.put(serial,diagnosis);
			//レコード順次番号を設定
			diagnosis.set_501007(diagnosisMap.size());
			//
			diagnosis.set_501009(specialClinicType);
		}
		return diagnosis;
	}
	//[H20.5 法改正対応] fujihara edit start
}
