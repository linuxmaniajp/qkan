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
 * 作成日: 2006/01/19  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス (在宅サービス介護給付費明細書（認知症対応型・特定施設入所者） (001)
 * プログラム (在宅サービス介護給付費明細書（認知症対応型・特定施設入所者） (QP001P071)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.util.VRMap;

public class QP001P061_201204 extends QP001P06_201204{
    
	/* 
	 * 様式第六 201204以降
	 *
	 * addFormat()
	 * 設定する帳票定義体を変更
	 * 
	 * getFormatId()
	 * フォーマット番号の変更
	 */
    
    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P061_201204.xml");
    }

    public String getFormatId() throws Exception {
    	return "QP001P061_201204";
    }
    
    @Override
    protected void doPrintExternalUseHeader(VRMap baseMap, VRMap typeMap) throws Exception{
        //入居前の状況を設定する
        setBeforeHospitalization();
    }

    protected void doPrintExternalUse(VRMap baseMap,VRMap typeMap) throws Exception {
        //保険分の単位数合計を設定する。
        ACChotarouXMLUtilities.setValue(writer, "hokentanitotal", pad(baseMap.get("201033"),6));
    }

}
