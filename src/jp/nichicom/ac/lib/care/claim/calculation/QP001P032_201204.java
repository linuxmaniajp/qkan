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
 * 作成日: 2006/01/17  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 在宅サービス介護給付費明細書（短期入所生活介護） (001)
 * プログラム 在宅サービス介護給付費明細書（短期入所生活介護） (QP001042)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

public class QP001P032_201204 extends QP001P03_201204{
    
    // 様式第三の二 201204以降

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P032_201204.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P032_201204";
    }    

    public void doPrintReductionList(VRMap reductionMap) throws Exception {
        
        if (reductionMap != null) {
            //
            if (ACCastUtilities.toInt(VRBindPathParser.get(
                    "901008", reductionMap)) == 24) {
                //軽減率を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "keigenritsu", pad(VRBindPathParser.get(
                                "901007", reductionMap), 4));
                //短期入所生活介護サービス費の利用者負担額の総額を設定する。 ※サービス種類レコード(901008)が21のレコードが対象
                ACChotarouXMLUtilities.setValue(writer,
                        "tankijyuryo", pad(VRBindPathParser.get(
                                "901009", reductionMap), 6));
                //短期入所生活介護サービス費の軽減額を設定する。 ※サービス種類レコード(901008)が21のレコードが対象
                ACChotarouXMLUtilities.setValue(writer,
                        "tankikeigen", pad(VRBindPathParser.get(
                                "901010", reductionMap), 6));
                //短期入所生活介護サービス費の軽減後利用者負担額を設定する。 ※サービス種類レコード(901008)が21のレコードが対象
                ACChotarouXMLUtilities.setValue(writer,
                        "tankikeigengo", pad(VRBindPathParser.get(
                                "901011", reductionMap), 6));
                //短期入所生活介護サービス費の備考を設定する。 ※サービス種類レコード(901008)が21のレコードが対象
                ACChotarouXMLUtilities.setValue(writer,
                        "syafuku.h8.w2", VRBindPathParser.get(
                                "901012", reductionMap));

            }
        }
    }

}
