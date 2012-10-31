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
 * 作成日: 2009/03/04  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 給付管理票 (001)
 * プログラム 給付管理票エラー管理 (QP001ErrorControl)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Iterator;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanMessageList;

public class QP001ErrorControl {
	
	//出力するエラーメッセージの内容
	private StringBuilder errorMessage = new StringBuilder();
	//チェックしたデータの件数
	private int checkCount = 0;
	//エラーデータの件数
	private int errorCount = 0;
	
	/**
	 * 様式第十一（給付管理票）データの妥当性を検証する。
	 * @param claimList
	 * @param patient
	 * @return
	 * @throws Exception
	 */
    public boolean isValidBenefitManagement(VRList claimList, VRMap patient) throws Exception {
        int totalUnitList = 0;
        int totalUnitMap = 0;
        VRMap claimMap = new VRHashMap();
        
        //処理件数をカウントアップ
        checkCount++;
        
        // 給付計画単位数合計
        for(int i = 0; i < claimList.size(); i++){
            VRMap map = (VRMap)claimList.get(i);
            //99レコードは抜く
            if(ACTextUtilities.isNullText(map.get("1201019"))){
                continue;
            }
            totalUnitList += ACCastUtilities.toInt(map.get("1201020"));
            claimMap.put(String.valueOf(map.get("1201019")) + "-" + String.valueOf(map.get("1201017")),map);
        }
        
        //念のため、様式第十一で行なっているのと同一の計算を実施する
        Iterator it = claimMap.keySet().iterator();
        while(it.hasNext()){
        	VRMap map = (VRMap)claimMap.get(it.next());
        	totalUnitMap += ACCastUtilities.toInt(map.get("1201020"));
        }
        
        //合算不一致エラーの場合
        if (totalUnitList != totalUnitMap) {
        	//エラー件数をカウントアップ
        	errorCount++;
        	//対象者名称を退避
        	errorMessage.append(patient.get("PATIENT_FAMILY_NAME"));
        	errorMessage.append("　");
        	errorMessage.append(patient.get("PATIENT_FIRST_NAME"));
        	errorMessage.append("\n");
        	return false;
        }
        
    	return true;
    }
    
    /**
     * isValidBenefitManagementでエラーが発生している場合、
     * エラーメッセージを表示する。
     *
     */
    public void showBenefitManagementError() throws Exception {
    	if(errorCount != 0){
    		QkanMessageList.getInstance().QP001_WARNING_BENEFIT_MANAGEMENT(errorMessage.toString());
    	}
    }
    
    /**
     * 全ての検証がエラーであるかを確認する
     * @return true:全て検証エラー false:正常通過あり
     * @throws Exception
     */
    public boolean isAllError() throws Exception {
    	return (checkCount == errorCount);
    }
    
}
