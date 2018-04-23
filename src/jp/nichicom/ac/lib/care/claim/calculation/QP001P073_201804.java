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
 * 開発者: 日高　しのぶ
 * 作成日: 2017/06/27  MIS九州株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 在宅サービス介護給付費明細書（居宅） (001)
 * プログラム 在宅サービス介護給付費明細書（居宅） (QP001P07)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 印刷イベント
 * 
 * 介護予防・日常生活総合事業費明細書（介護予防ケアマネジメント費）イベント定義-様式第七の三
 * 201804年以降（給管鳥はH29.8～対応）
 * 様式第七とは異なるので様式第七のクラスを継承しない（様式第二の三に似ている）
 */
public class QP001P073_201804 extends QP001P02_10Event{
    /**
     * コンストラクタです。
     */
    public QP001P073_201804() {
    }

    public void addFormat() throws Exception {
    	ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P073_201804.xml");
        
    }

    public String getFormatId() throws Exception {
    	return "QP001P073_201804";
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
        // 明細情報（住所地特例）レコード集合
        VRList detailJushotiTokureiList = getDetailJushotiTokureiList();
        
        // 印刷頁数を算出する。（1頁あたりの明細情報は10件、住所地特例情報は3件)
        // ※複数公費の受給を受けている場合は、受給公費分帳票を出力する。
        int pageCount = 1;
        int pageTemp = 1;

        if (detailList.getDataSize() > 0) {
        	pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 10d);
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }
        if (detailJushotiTokureiList.getDataSize() > 0) {
        	pageTemp = (int) Math.ceil((double) detailJushotiTokureiList.getDataSize() / 3d);
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }

        // 公費件数
        int kohiCount = 0;

        // レコードの復元
        parseStyle();
        // 基本情報レコード
        baseMap = getBaseMap();
        // 明細情報レコード
        detailList = getDetailList();
        // 集計情報レコード
        typeList = getTypeList();
        // 明細情報レコード
        detailJushotiTokureiList = getDetailJushotiTokureiList();
        
        // 印刷ループ
        for (int i = 0; i < pageCount; i++) {
            // ページ開始
            writer.beginPageEdit(getFormatId());

            // 帳票共通情報を設定
            setPrintHeader(kohiCount);

            // 明細情報のテーブルを設定
            // ※11件を超える場合は、次ページに印字
            setDetailList(detailList, 11, kohiCount);

            // 住所地特例
            setDetailJushotiTokureiList(detailJushotiTokureiList, 4, kohiCount);
            
            // 用紙が一枚めの場合
            if (i == 0) {
            	
                // 集計印字
                if (typeList.getDataSize() != 0) {
                    
                    VRMap type = (VRMap) typeList.get(0);
                    // 単位数単価を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "tanisutani",
                            getTanka(VRBindPathParser.get("701015", type)));
                }
                if (kohiCount == 0) {
                    // 単位数合計を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "jigyobuntani",
                            pad(VRBindPathParser.get("201033", baseMap), 6));
                    // 事業費請求額を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "jigyoseikyu",
                            pad(VRBindPathParser.get("201034", baseMap), 6));
                    // 公費分単位数合計を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "kohibuntani",
                            pad(VRBindPathParser.get("201039", baseMap), 6));
                    // 公費給付率を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "kohikyufu",
                            pad(VRBindPathParser.get("201030", baseMap), 3));
                    // 公費請求額合計を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "kohiseikyu",
                            pad(VRBindPathParser.get("201040", baseMap), 6));
                }
            }

            //印刷ページ総数が2枚以上の場合
            if ((kohiCountTotal * pageCount) > 1) {
                //出力ページ数の総数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "totalpage",
                        ACCastUtilities.toString((kohiCountTotal * pageCount)));
                //現在の出力ページ数を設定する。
                ACChotarouXMLUtilities.setValue(writer, "nowpage",
                        ACCastUtilities.toString(((kohiCount * pageCount) + i + 1)));
            }
            //ページ終了
            writer.endPageEdit();
        }

        //印刷を実行したならばtrueを返す。
        return true;
    }
    

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
            if(!QP001SpecialCase.isUnitNotShowService(String.valueOf(detail.get("301007")),String.valueOf(detail.get("301008")),
            		ACCastUtilities.toInt(detail.get("301027"), 0))){
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
            if(!QP001SpecialCase.isUnitNotShowService(String.valueOf(detail.get("1801007")),String.valueOf(detail.get("1801008")),
            		ACCastUtilities.toInt(detail.get("1801028"), 0))){
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

}
