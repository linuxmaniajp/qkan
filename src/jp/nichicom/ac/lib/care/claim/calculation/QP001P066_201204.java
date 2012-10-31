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
 * プログラム (在宅サービス介護給付費明細書（認知症対応型・特定施設入所者） (QP001P076)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.util.VRMap;

public class QP001P066_201204 extends QP001P06_201204{
    
    // 様式第六の六 201204以降
    
    @Override
    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P066_201204.xml");
    }

    @Override
    public String getFormatId() throws Exception {
        return "QP001P066_201204";
    }
    
    @Override
    //明細行の件数(様式第六の五と六の六だけ10行)
    protected int getDetailRowCount() {
        return 10;
    }

    @Override
    protected void doPrintExternalUse(VRMap baseMap,VRMap typeMap) throws Exception {
        ACChotarouXMLUtilities.setValue(writer, "tankijitsu", pad(typeMap.get("701013"), 2));
        
        //計画単位数を設定する。
        ACChotarouXMLUtilities.setValue(writer, "plan", pad(typeMap.get("701009"),6));
        //限度額管理対象単位数を設定する。
        ACChotarouXMLUtilities.setValue(writer, "limit", pad(typeMap.get("701010"),6));
        //限度額管理対象外単位数を設定する。
        ACChotarouXMLUtilities.setValue(writer, "limitout", pad(typeMap.get("701011"),6));
        //給付単位数を設定する。
        ACChotarouXMLUtilities.setValue(writer, "hokentanitotal", pad(baseMap.get("201033"),6));
    }

}
