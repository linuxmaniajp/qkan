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

import java.util.Arrays;
import java.util.List;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

public class QP001P023_201804 extends QP001P02_201804{
    
    // 様式第二の三 201804年以降

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P023_201804.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P023_201804";
    }
    
    public void doPrintDetailList(VRList detailList,int kohiCount) throws Exception {
        setDetailList(detailList,11,kohiCount);
    }
    
    @Override
    public void doPrintDetailJushotiTokureiList(
    		VRList detailJushotiTokureiList, int kohiCount) throws Exception {
    	setDetailJushotiTokureiList(detailJushotiTokureiList, 4, kohiCount);
    }

    public void doPrintReductionList(VRList reductionList) throws Exception {
    	// [H30.4改正対応][Yoichiro Kamei] 2018/4/4 add - begin
    	//出力対象となるサービス種類
    	List<String> targetKindList = Arrays.asList(new String[]{
    			  "A1" //訪問型サービス(みなし)
    			, "A2" //訪問型サービス(独自)
    			, "A3" //訪問型サービス(独自／定率)
    			, "A4" //訪問型サービス(独自／定額)
    			, "A5" //通所型サービス(みなし)
    			, "A6" //通所型サービス(独自)
    			, "A7" //通所型サービス(独自／定率)
    			, "A8" //通所型サービス(独自／定額)
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
    	// [H30.4改正対応][Yoichiro Kamei] 2018/4/4 add - end
    }

}
