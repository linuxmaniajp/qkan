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
package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.vr.util.VRMap;

/**
 * 総合事業の介護予防ケアマネジメント（AF）関連をチェックするためのクラス
 * 
 * @since V7.3.2
 * @author Yoichiro.Kamei
 */
public class QkanSjAfChecker {
    
	public enum Mode {
		SERVICE_UPDATE, //サービス登録時
		SEIKYU_DATA //請求データ作成時
	};
	private Mode mode = Mode.SERVICE_UPDATE;
    private CareServiceCodeCalcurater calcurater;

    /**
     * コンストラクタ。
     * 
     * @param calcurater  生成、初期化済みのCareServiceCodeCalcurater
     * @throws Exception
     */
    public QkanSjAfChecker(CareServiceCodeCalcurater calcurater, Mode mode) throws Exception {
        this.calcurater = calcurater;
        this.mode = mode;
    }
 
    /**
     * 渡されたサービスに含まれるコードがAFと同時に算定可能なコードであるかチェックします。
     * 算定出来ないコードが設定されていた場合は、QkanSjAfExceptionをスローします。
     * 
     * @param service
     * @throws QkanSjAfException 算定出来ないサービスコードが設定されていた場合
     */
    public void checkCodes(VRMap service) throws Exception {
        checkServiceCodeList(calcurater.getServiceCodes(service));
    }
    
    /**
     * 渡されたサービスに含まれるコードがAFと同時に算定可能なコードであるかチェックします。
     * 算定出来ないコードが設定されていた場合は、QkanSjAfExceptionをスローします。
     * 
     * @param serviceCodeList
     * @throws QkanSjAfException 算定出来ないサービスコードが設定されていた場合
     */
    public void checkServiceCodeList(List serviceCodeList) throws Exception {
        Iterator it = serviceCodeList.iterator();	
        while (it.hasNext()) {
            Map code = (Map) it.next();
            checkCode(code);
        }
    }
    
    /**
     * 渡されたコードがAFと同時に算定可能なコードであるかチェックします。
     * 算定出来ないコードが設定されていた場合は、QkanSjAfExceptionをスローします。
     * 
     * @param code サービスコード
     * @throws QkanSjAfException 算定出来ないサービスコードが設定されていた場合
     */
    public void checkCode(Map code) throws Exception {
    	//サービス登録時のチェック
    	if (Mode.SERVICE_UPDATE.equals(this.mode) ) {
            if (CareServiceCommon.isPreventService(code)) {
            	if (CareServiceCommon.isInLimitAmount(code)) {
            		//予防で限度額管理対象のサービスの場合
            		throw new QkanSjAfException(code, QkanSjAfException.Type.YOBO_GENDOGAKU_SV);
            	}
            }
    	}
        //介護予防支援の場合
        if (CareServiceCommon.isPreventService(code)) {
        	CareServiceCommon.isCareManagement(code);
        	throw new QkanSjAfException(code, QkanSjAfException.Type.YOBO_SHIEN_SV);
        }
    }

}
