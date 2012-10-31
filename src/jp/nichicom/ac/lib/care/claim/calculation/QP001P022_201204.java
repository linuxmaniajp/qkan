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
 * 作成日: 2006/01/13  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 在宅サービス介護給付費明細書（居宅） (001)
 * プログラム 在宅サービス介護給付費明細書（居宅） (QP001P032)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

public class QP001P022_201204 extends QP001P02_201204{
    
    // 様式第二の二 201204年以降

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P022_201204.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P022_201204";
    }
    
    public void doPrintDetailList(VRList detailList,int kohiCount) throws Exception {
        setDetailList(detailList,13,kohiCount);
    }

    public void doPrintReductionList(VRList reductionList) throws Exception {
        
        if (reductionList.getDataSize() > 0) {
            //軽減率を設定する。
            ACChotarouXMLUtilities.setValue(writer, "keigenritsu",
                    pad(VRBindPathParser.get("901007",
                            (VRMap) reductionList.getData(0)), 4));

            for (int j = 0; j < reductionList.getDataSize(); j++) {
                VRMap reduction = (VRMap) reductionList.getData(j);
                switch (ACCastUtilities.toInt(VRBindPathParser.get(
                        "901008", reduction))) {
                case 61:
                    //介護予防訪問介護サービス費の利用者負担額の総額を設定する。 ※サービス種類レコード(901008)が61のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "houmonjyuryo", pad(VRBindPathParser
                                    .get("901009", reduction), 6));
                    //介護予防訪問介護サービス費の軽減額を設定する。 ※サービス種類レコード(901008)が11のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "houmonkeigen", pad(VRBindPathParser
                                    .get("901010", reduction), 6));
                    //介護予防訪問介護サービス費の軽減後利用者負担額を設定する。 ※サービス種類レコード(901008)が11のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "houmonkeigengo", pad(VRBindPathParser
                                    .get("901011", reduction), 6));
                    //介護予防訪問介護サービス費の備考を設定する。 ※サービス種類レコード(901008)が11のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "syafuku.h1.w33", VRBindPathParser.get("901012", reduction));

                    break;
                case 65:
                    //介護予防通所介護サービス費の利用者負担額の総額を設定する。 ※サービス種類レコード(901008)が12のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "tuusyojyuryo", pad(VRBindPathParser
                                    .get("901009", reduction), 6));
                    //介護予防通所介護サービス費の軽減額を設定する。 ※サービス種類レコード(901008)が12のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "tuusyokeigen", pad(VRBindPathParser
                                    .get("901010", reduction), 6));
                    //介護予防通所介護サービス費の軽減後利用者負担額を設定する。 ※サービス種類レコード(901008)が12のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "tuusyokeigengo", pad(VRBindPathParser
                                    .get("901011", reduction), 6));
                    //介護予防通所介護サービス費の備考を設定する。 ※サービス種類レコード(901008)が12のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "syafuku.h2.w33", VRBindPathParser.get("901012", reduction));
                    break;

                case 74:
                    //介護予防認知症対応型通所介護のサービス費の利用者負担額の総額を設定する。 ※サービス種類レコード(901008)が71のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "ninchijyuryo", pad(VRBindPathParser
                                    .get("901009", reduction), 6));
                    //介護予防認知症対応型通所介護の軽減額を設定する。 ※サービス種類レコード(901008)が71のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "ninchikeigen", pad(VRBindPathParser
                                    .get("901010", reduction), 6));
                    //介護予防認知症対応型通所介護の軽減後利用者負担額を設定する。 ※サービス種類レコード(901008)が71のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "ninchikeigengo", pad(VRBindPathParser
                                    .get("901011", reduction), 6));
                    //介護予防認知症対応型通所介護の備考を設定する。 ※サービス種類レコード(901008)が71のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "syafuku.h3.w33", VRBindPathParser.get("901012", reduction));
                    break;

                case 75:
                    //介護予防小規模多機能型居宅介護のサービス費の利用者負担額の総額を設定する。 ※サービス種類レコード(901008)が72のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "syokibojyuryo", pad(VRBindPathParser
                                    .get("901009", reduction), 6));
                    //介護予防小規模多機能型居宅介護の軽減額を設定する。 ※サービス種類レコード(901008)が72のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "syokibokeigen", pad(VRBindPathParser
                                    .get("901010", reduction), 6));
                    //介護予防小規模多機能型居宅介護の軽減後利用者負担額を設定する。 ※サービス種類レコード(901008)が72のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "syokibokeigengo", pad(VRBindPathParser
                                    .get("901011", reduction), 6));
                    //介護予防小規模多機能型居宅介護の備考を設定する。 ※サービス種類レコード(901008)が72のレコードが対象
                    ACChotarouXMLUtilities.setValue(writer,
                            "syafuku.h4.w33", VRBindPathParser.get("901012", reduction));
                    break;

                }
            }
        }
    }

}
