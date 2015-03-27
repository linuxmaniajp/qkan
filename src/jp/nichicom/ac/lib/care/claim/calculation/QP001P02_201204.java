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
 * プログラム 在宅サービス介護給付費明細書（居宅） (QP00103)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 在宅サービス介護給付費明細書（居宅）(様式第二) - 帳票定義体ファイル名 ： QP001P02X_YYYYYMM.xml
 */
public class QP001P02_201204 extends QP001P02_10Event {

    /**
     * コンストラクタです。
     */
    public QP001P02_201204() {
    }

    /**
     * 帳票を生成します。
     * 
     * @param writer
     *            印刷管理クラス
     * @param printParam
     *            印刷パラメタ
     * @throws Exception
     *             処理例外
     */
    public boolean doPrintImpl(VRMap printParam) throws Exception {
        
        // 基本情報レコード
        VRMap baseMap = getBaseMap();
        // 明細情報レコード集合
        VRList detailList = getDetailList();
        // 集計情報レコード
        VRList typeList = getTypeList();
        // 社福減免レコード
        VRList reductionList = getReductionList();
        
 // 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
        // 明細情報（住所地特例）レコード集合
        VRList detailJushotiTokureiList = getDetailJushotiTokureiList();
 // 2015/1/14 [Yoichiro Kamei] add - end
        
        // 印刷頁数を算出する。（1頁あたりの明細情報は14件、集計情報は4件)
        // ※複数公費の受給を受けている場合は、受給公費分帳票を出力する。
        int pageCount = 1;
        int pageTemp = 1;

        if (detailList.getDataSize() > 0) {
            //pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 14d);
        	pageTemp = (int) Math.ceil((double) detailList.getDataSize() / getDetailRowCount());
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }
        if (typeList.getDataSize() > 0) {
            pageTemp = (int) Math.ceil((double) typeList.getDataSize() / 4d);
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }
 // 2015/1/26 [H27.4改正対応][Yoichiro Kamei] add - begin
        if (detailJushotiTokureiList.getDataSize() > 0) {
        	pageTemp = (int) Math.ceil((double) detailJushotiTokureiList.getDataSize() / getDetailJushotiTokureiRowCount());
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }
        if (reductionList.getDataSize() > 0) {
        	pageTemp = (int) Math.ceil((double) reductionList.getDataSize() / 3d);
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }
 // 2015/1/26 [H27.4改正対応][Yoichiro Kamei] add - end

        // 公費件数ループ
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            // レコードの復元
            parseStyle();
            // 基本情報レコード
            baseMap = getBaseMap();
            // 明細情報レコード
            detailList = getDetailList();
            // 集計情報レコード
            typeList = getTypeList();
            // 社福減免レコード
            reductionList = getReductionList();
 // 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
            // 明細情報レコード
            detailJushotiTokureiList = getDetailJushotiTokureiList();
 // 2015/1/14 [Yoichiro Kamei] add - end
            
            // 印刷ループ
            for (int i = 0; i < pageCount; i++) {
                // ページ開始
                writer.beginPageEdit(getFormatId());

                // 帳票共通情報を設定
                setPrintHeader(kohiCount);

                // 居宅サービス状況を設定
                setKyotakuData();

                // 開始、終了状況を設定
                setKaishiDate();
                
                //明細情報のテーブルを設定
                //※12件を超える場合は、次ページに印字
//                setDetailList(detailList,13,kohiCount);
                doPrintDetailList(detailList,kohiCount);

// 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
                doPrintDetailJushotiTokureiList(detailJushotiTokureiList, kohiCount);
// 2015/1/14 [Yoichiro Kamei] add - end
                
                // 集計件数分ループする。※4件を超える場合は、次ページに印字
                setTypeList(typeList,5,kohiCount);

// 2015/1/26 [H27.4改正対応][Yoichiro Kamei] mod - begin
                // 社福軽減を設定
                doPrintReductionList(reductionList);
// 2015/1/26 [H27.4改正対応][Yoichiro Kamei] mod - end
                
                // 用紙が一枚めの場合
                if (i == 0) {
                    
                    if(kohiCount == 0){
                        // 保険給付率を設定する。
                        if (!ACTextUtilities.isNullText(VRBindPathParser.get("201029", baseMap))) {
                            ACChotarouXMLUtilities.setValue(writer, "hokenkyufu",
                                            pad(VRBindPathParser.get("201029",baseMap), 3));
                        }
                        // 保険請求額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "hokenseikyutotal",
                                pad(VRBindPathParser.get("201034", baseMap), 6));
                        
                        // 利用者負担額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "riyousyahutantotal", pad(VRBindPathParser.get(
                                        "201035", baseMap), 6));
                    }

                    // 公費項番により分岐
                    switch (kohiCount) {
                    // 公費1
                    case 0:
                        // 公費給付率を設定する。
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201030",
                                                baseMap), 3));
                        // 公費請求額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201040", baseMap), 6));
                        // 公費分本人負担の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201041", baseMap), 6));
                        break;
                    // 公費2
                    case 1:
                        // 公費給付率を設定する。
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201031",
                                                baseMap), 3));
                        // 公費請求額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201046", baseMap), 6));
                        // 公費分本人負担の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201047", baseMap), 6));
                        break;
                    // 公費3
                    case 2:
                        // 公費給付率を設定する。
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201032",
                                                baseMap), 3));
                        // 公費請求額の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201052", baseMap), 6));
                        // 公費分本人負担の合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201053", baseMap), 6));
                        break;
                    }
                    
// 2015/1/26 [H27.4改正対応][Yoichiro Kamei] mod - begin 可変となったため上に移動
//                    //印刷の拡張ポイントをコールする。
//                    doPrintReductionList(reductionList);
// 2015/1/26 [H27.4改正対応][Yoichiro Kamei] mod - end

                }

                //印刷ページ総数が2枚以上の場合
                if ((kohiCountTotal * pageCount) > 1) {
                    //出力ページ数の総数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
                            ACCastUtilities.toString((kohiCountTotal * pageCount)));
                    //現在の出力ページ数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "nowpage",
                            ACCastUtilities.toString(((kohiCount * pageCount) +i + 1)));
                }
                //ページ終了
                writer.endPageEdit();
            }

        }
        //印刷を実行したならばtrueを返す。
        return true;
    }
    
    /**
     * 様式第二と様式第二の二の差分を補完する
     * @param printParam
     * @param reductionList
     * @throws Exception
     */
    public void doPrintReductionList(VRList reductionList) throws Exception{
        
    }
    /**
     * 様式第二と様式第二の二の差分を補完する
     * @param printParam
     * @param reductionList
     * @throws Exception
     */
    public void doPrintDetailList(VRList detailList,int kohiCount) throws Exception {
        
    }
 // 2015/1/14 [Yoichiro Kamei] add - begin 住所地特例対応
    /**
     * 明細情報（住所地特例）欄の印刷データ設定を行う
     * @param detailJushotiTokureiList
     * @param kohiCount
     * @throws Exception
     */
    public void doPrintDetailJushotiTokureiList(VRList detailJushotiTokureiList, int kohiCount) throws Exception {
        
    }
    /**
     * 明細情報（住所地特例）欄の１ページあたりの出力行数を取得する
     */
    public double getDetailJushotiTokureiRowCount() {
        return 3d;
    }
    
    
    //[H27.4改正]サービス単位数５桁⇒６桁出力の対応のため、オーバーライドして定義
    /**
     * 明細情報を設定する。
     * @param detailList
     * @param loopCount
     * @param kohiCount
     * @throws Exception
     */
    protected void setDetailList(VRList detailList,int loopCount,int kohiCount) throws Exception {
        // 明細件数分ループする。
        for (int j = 1; j < loopCount; j++) {
            if (detailList.getDataSize() == 0)
                break;
            VRMap detail = (VRMap) detailList.get(0);
            // サービス内容を設定する。
            ACChotarouXMLUtilities.setValue(writer, detail, "301019",
                    "meisai.h" + j + ".w2");
            // サービスコードを設定する。
            ACChotarouXMLUtilities.setValue(writer, "servicecode" + j,
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "301007", detail))
                            + ACCastUtilities.toString(VRBindPathParser
                                    .get("301008", detail)));

            //単位数を表示するサービスでなければ単位数単価を表示する。
            if(!QP001SpecialCase.isUnitNotShowService(String.valueOf(detail.get("301007")),String.valueOf(detail.get("301008")))){
                // 単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "tani" + j, pad(
                        VRBindPathParser.get("301009", detail), 4));
            }

            // 日数・回数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "times" + j, pad(
                    VRBindPathParser.get("301010", detail), 2));
            
            // サービス単位数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "servicetime" + j,
                    pad(VRBindPathParser.get("301014", detail), 6));

            
            switch (kohiCount) {
            // 公費1
            case 0:
                // 公費分回数を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "kohitimes" + j, pad(VRBindPathParser.get(
                                "301011", detail), 2));
                
                // 公費対象単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohitani" + j,
                        pad(VRBindPathParser.get("301015", detail), 6));
                break;
            // 公費2
            case 1:
                // 公費分回数を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "kohitimes" + j, pad(VRBindPathParser.get(
                                "301012", detail), 2));
                
                // 公費対象単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohitani" + j,
                        pad(VRBindPathParser.get("301016", detail), 6));

                break;
            // 公費3
            case 2:
                // 公費分回数を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "kohitimes" + j, pad(VRBindPathParser.get(
                                "301013", detail), 2));
                // 公費対象単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "kohitani" + j,
                        pad(VRBindPathParser.get("301017", detail), 6));
                break;
            }

            // 摘要を設定する。
            ACChotarouXMLUtilities.setValue(writer, detail, "301018",
                    "meisai.h" + j + ".tekiyo");
            detailList.remove(0);
        }
    }
    
    /**
     * 明細情報（住所地特例）を設定する。
     * @param detailList
     * @param loopCount
     * @param kohiCount
     * @throws Exception
     */
    protected void setDetailJushotiTokureiList(VRList detailList,int loopCount,int kohiCount) throws Exception {
        // 明細件数分ループする。
        for (int j = 1; j < loopCount; j++) {
            if (detailList.getDataSize() == 0)
                break;
            VRMap detail = (VRMap) detailList.get(0);
            // サービス内容を設定する。
            ACChotarouXMLUtilities.setValue(writer, detail, "1801020",
                    "j_meisai.h" + j + ".w2");
            // サービスコードを設定する。
            ACChotarouXMLUtilities.setValue(writer, "j_servicecode" + j,
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "1801007", detail))
                            + ACCastUtilities.toString(VRBindPathParser
                                    .get("1801008", detail)));

            //単位数を表示するサービスでなければ単位数単価を表示する。
            if(!QP001SpecialCase.isUnitNotShowService(String.valueOf(detail.get("1801007")),String.valueOf(detail.get("1801008")))){
                // 単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "j_tani" + j, pad(
                        VRBindPathParser.get("1801009", detail), 4));
            }

            // 日数・回数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "j_times" + j, pad(
                    VRBindPathParser.get("1801010", detail), 2));
            // サービス単位数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "j_servicetime" + j,
                    pad(VRBindPathParser.get("1801014", detail), 6));

            switch (kohiCount) {
            // 公費1
            case 0:
                // 公費分回数を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "j_kohitimes" + j, pad(VRBindPathParser.get(
                                "1801011", detail), 2));
                // 公費対象単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "j_kohitani" + j,
                        pad(VRBindPathParser.get("1801015", detail), 6));
                break;
            // 公費2
            case 1:
                // 公費分回数を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "j_kohitimes" + j, pad(VRBindPathParser.get(
                                "1801012", detail), 2));
                // 公費対象単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "j_kohitani" + j,
                        pad(VRBindPathParser.get("1801016", detail), 6));
                break;
            // 公費3
            case 2:
                // 公費分回数を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "j_kohitimes" + j, pad(VRBindPathParser.get(
                                "1801013", detail), 2));
                // 公費対象単位数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "j_kohitani" + j,
                        pad(VRBindPathParser.get("1801017", detail), 6));
                break;
            }
            
            // 施設所在保険者番号を設定する。
            ACChotarouXMLUtilities.setValue(writer, detail, "1801018",
                    "j_meisai.h" + j + ".w10");
            
            // 摘要を設定する。
            ACChotarouXMLUtilities.setValue(writer, detail, "1801019",
                    "j_meisai.h" + j + ".tekiyo");
            detailList.remove(0);
        }
    }
 // 2015/1/14 [Yoichiro Kamei] add - end
    
 // 2015/1/26 [H27.4改正対応][Yoichiro Kamei] add - begin
    /**
     * 社福軽減を設定する。
     * @param reductionList
     * @param loopCount
     * @throws Exception
     */
    protected void setReductionList(VRList reductionList, int loopCount) throws Exception {
        if (reductionList.getDataSize() == 0) {
        	return;
        }
        //軽減率を設定する。
        ACChotarouXMLUtilities.setValue(writer, "keigenritsu",
                pad(VRBindPathParser.get("901007",
                        (VRMap) reductionList.getData(0)), 4));
        
        // 明細件数分ループする。
        for (int j = 1; j < loopCount; j++) {
            if (reductionList.getDataSize() == 0) {
            	break;
            }
            VRMap reduction = (VRMap) reductionList.get(0);
            String kind = ACCastUtilities.toString(VRBindPathParser.get("901008", reduction));
            
            //サービス種類コード
            ACChotarouXMLUtilities.setValue(writer, "syafuku.h" + j + ".kind", kind);
            
            //サービス名称
            VRMap service = (VRMap) getServiceName().get(kind);
            ACChotarouXMLUtilities.setValue(writer, service, "SERVICE_KIND_NAME", "syafuku.h" + j + ".service");
                        
            //利用者負担額の総額を設定
            ACChotarouXMLUtilities.setValue(writer, "jyuryo" + j, pad(VRBindPathParser.get("901009", reduction), 6));
            //軽減額を設定
            ACChotarouXMLUtilities.setValue(writer, "keigen" + j, pad(VRBindPathParser .get("901010", reduction), 6));
            //軽減後利用者負担額を設定
            ACChotarouXMLUtilities.setValue(writer, "keigengo" + j, pad(VRBindPathParser.get("901011", reduction), 6));
            //備考
            ACChotarouXMLUtilities.setValue(writer, "syafuku.h" + j + ".biko", VRBindPathParser.get("901012", reduction));
            
            reductionList.remove(0); //設定済みなので対象から除外
        }
    }
// 2015/1/26 [H27.4改正対応][Yoichiro Kamei] add - end
    
    public void addFormat() throws Exception {
        // TODO 自動生成されたメソッド・スタブ
        
    }

    public String getFormatId() throws Exception {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }
    
    public double getDetailRowCount() {
        return 12d;
    }
    
}
