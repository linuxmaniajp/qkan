
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
 * プロセス 請求処理(001)
 * プログラム 公費順位確定計算クラス(QP001RecordSupporterCalc)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Iterator;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * レコードに付属の計算に関する部分（主に公費）を担当します。
 * 
 */
public class QP001RecordSupporterCalc {
	
	//サービス単位数
	private int service_unit = 0;
	//適用回数
	private int times = 0;
	
	/**
	 * 公費情報固有のＩＤを返却します。
	 * @param list
	 * @return
	 * @throws Exception
	 */
	protected static String getSerialId(VRList list,QP001PatientState patientState,Object tatgetDate,int insureType) throws Exception {
		StringBuilder serial = new StringBuilder();
		TreeMap treeMap = new TreeMap();
		
		if((list == null) || (list.getDataSize() <= 0)){
			//公費適用なしパターン
			return "NONE";
		}
		
		VRMap map;
		for(int i = 0; i < list.getDataSize(); i++){
			map = (VRMap)list.getData(i);
			treeMap.put(VRBindPathParser.get("KOHI_SORT",map),VRBindPathParser.get("KOHI_TYPE",map) + "-" + patientState.getKohiData(String.valueOf(map.get("KOHI_TYPE")),"BENEFIT_RATE",insureType));
            //給付率が100を超えた場合は公費対象からはずす
		}
		
		Iterator it = treeMap.keySet().iterator();
		
		while(it.hasNext()){
            String[] datas = ACCastUtilities.toString(treeMap.get(it.next())).split("-");
			serial.append(datas[0]);
			serial.append("-");
            if(ACCastUtilities.toInt(datas[1]) >= 100){
                break;
            }
		}
		
		return serial.toString();
	}
	
	/**
	 * コンストラクタ
	 * @param service_unit
	 */
	protected QP001RecordSupporterCalc(int service_unit){
		this.service_unit = service_unit;
	}
    
    protected void replaceServiceUnit(int service_unit){
        this.service_unit = service_unit;
    }
    
	/**
	 * 回数の加算を行う。
	 *
	 */
	protected void addTime(VRMap serviceDetail,VRMap serviceCode) throws Exception {
        //見取り看護加算対応
        String systemServiceCodeItem = String.valueOf(serviceCode.get("SYSTEM_SERVICE_CODE_ITEM"));
        String serviceCodeKind = String.valueOf(serviceCode.get("SERVICE_CODE_KIND"));
        if("Z6276".equals(systemServiceCodeItem) || "Z6277".equals(systemServiceCodeItem)){
            if("51".equals(serviceCodeKind)){
                this.times += ACCastUtilities.toInt(serviceDetail.get("1510132"),1);
            } else if("54".equals(serviceCodeKind)){
                this.times += ACCastUtilities.toInt(serviceDetail.get("1540128"),1);
            } else {
                //通常のサービス
                this.times++;
            }
        } else {
            //通常のサービス
            this.times++;
        }
        
//		this.times++;
	}
	
	protected int getServiceUnitTotal(){
		return service_unit * times;
	}
	
	public String toString(){
		return "[SERVICE_UNIT=" + service_unit + "][SERVICE_TIMES=" + times + "]";
	}
	
}
