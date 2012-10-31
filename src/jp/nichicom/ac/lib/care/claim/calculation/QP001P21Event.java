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
 * 開発者: 上司　和善
 * 作成日: 2007/02/27  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 介護保険サービス利用請求書 (001)
 * プログラム 介護保険サービス利用請求書 (QP001P23)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRMap;

/**
 * 介護保険サービス利用請求書イベント定義(QP001P211) 帳票定義体ファイル名 ： QP001P211.xml
 * 介護保険サービス利用請求書イベント定義(振込口座欄あり)(QP001P212) 帳票定義体ファイル名 ： QP001P212.xml
 * 介護保険サービス利用領収書イベント定義(QP001P213) 帳票定義体ファイル名 ： QP001P213.xml
 * 介護保険サービス利用領収書イベント定義(振込口座欄あり)(QP001P214) 帳票定義体ファイル名 ： QP001P214.xml
 * 介護保険サービス利用領収書イベント定義（領収欄あり）(QP001P215) 帳票定義体ファイル名 ： QP001P215.xml
 */
public class QP001P21Event extends QP001P20Event {
	
	protected void setBasicData() throws Exception {
		super.setBasicData();

        // 小計・合計を印刷するにチェックがついている場合、
        if(getIsTotalCheck()){
            // 請求額を設定する。
        	if(serviceDetail != null){
        		// 利用者向け請求レコードが作成されている場合
        		// ユーザの入力に従い印字する。※"0"は"0"として印字する。
        		ACChotarouXMLUtilities.setValue(writer, "innertax", getFormatDataExceptZero(serviceDetail, "INNER_TAX"));
        	}else{
        		// 利用者向け請求レコードが作成されていない場合
        		// "0"を初期値として印字する。
        		ACChotarouXMLUtilities.setValue(writer, "innertax", "0");
        	}
        }
	}
	
    public String getFormatDataExceptZero(VRMap style,String key) throws Exception{
        String value = String.valueOf(style.get(key));
        
        // "0"の場合は""を返却しない。
        if(ACTextUtilities.isNullText(value) || value.equalsIgnoreCase("NULL")){
            return "";
        }
        
        return getNf().format(ACCastUtilities.toDouble(value,0));
    }

}
