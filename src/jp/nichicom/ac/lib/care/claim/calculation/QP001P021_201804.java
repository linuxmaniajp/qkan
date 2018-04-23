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
 * プログラム 在宅サービス介護給付費明細書（居宅） (QP001P031)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Arrays;
import java.util.List;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

public class QP001P021_201804 extends QP001P02_201804{
    
	//様式第二 201804年以降

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P021_201804.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P021_201804";
    }
    
    public void doPrintDetailList(VRList detailList,int kohiCount) throws Exception {
        setDetailList(detailList,11,kohiCount);
    }
    
 // 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
    @Override
    public void doPrintDetailJushotiTokureiList(
    		VRList detailJushotiTokureiList, int kohiCount) throws Exception {
    	setDetailJushotiTokureiList(detailJushotiTokureiList, 4, kohiCount);
    }
 // 2015/1/14 [Yoichiro Kamei] add - end
    
    @Override
    public double getDetailRowCount() {
        return 10d;
    }

    public void doPrintReductionList(VRList reductionList) throws Exception {
 // 2015/1/26 [H27.4改正対応][Yoichiro Kamei] mod - begin
    	//出力対象となるサービス種類
    	List<String> targetKindList = Arrays.asList(new String[]{
    			  "11" //訪問介護
    			, "15" //通所介護
    			, "76" //定期巡回・随時対応型訪問介護看護
    			, "71" //夜間対応型訪問介護
    			, "72" //認知症対応型通所介護
    			, "73" //小規模多機能型居宅介護（短期利用型以外）
    			, "77" //複合型サービス（看護小規模多機能型居宅介護・短期利用型以外）
    			, "68" //小規模多機能型居宅介護（短期利用型）
    			, "79" //複合型サービス（介護小規模多機能型居宅介護・短期利用型）
    			, "78" //地域密着型通所介護 H28.4改正
    	});
    	if (reductionList.getDataSize() > 0) {
    		//サービス種類コードが対象に含まれていなければ除く
            for (int j = 0; j < reductionList.getDataSize(); j++) {
                VRMap reduction = (VRMap) reductionList.getData(j);
                String kind = ACCastUtilities.toString(VRBindPathParser.get("901008", reduction));
                if (!targetKindList.contains(kind)) {
                	reductionList.remove(j);
                }
            }
    		setReductionList(reductionList, 4);
    	}
//        if (reductionList.getDataSize() > 0) {
//            //軽減率を設定する。
//            ACChotarouXMLUtilities.setValue(writer, "keigenritsu",
//                    pad(VRBindPathParser.get("901007",
//                            (VRMap) reductionList.getData(0)), 4));
//
//            for (int j = 0; j < reductionList.getDataSize(); j++) {
//                VRMap reduction = (VRMap) reductionList.getData(j);
//                
//                String kind = ACCastUtilities.toString(VRBindPathParser.get("901008", reduction));
//                
//                //kindがサービス種類コード
//                //11:訪問介護、15:通所介護、76:定期巡回、71:夜間対応型、72:認知症対応型
//                //73:小規模多機能、77:複合型
//                
//                //利用者負担額の総額を設定
//                ACChotarouXMLUtilities.setValue(writer, "jyuryo" + kind, pad(VRBindPathParser.get("901009", reduction), 6));
//                //軽減額を設定
//                ACChotarouXMLUtilities.setValue(writer, "keigen" + kind, pad(VRBindPathParser .get("901010", reduction), 6));
//                //軽減後利用者負担額を設定
//                ACChotarouXMLUtilities.setValue(writer, "keigengo" + kind, pad(VRBindPathParser.get("901011", reduction), 6));
//                //備考
//                ACChotarouXMLUtilities.setValue(writer, "syafuku.h" + kind + ".biko", VRBindPathParser.get("901012", reduction));
//            }
//        }
// 2015/1/26 [H27.4改正対応][Yoichiro Kamei] mod - end
    }

}
