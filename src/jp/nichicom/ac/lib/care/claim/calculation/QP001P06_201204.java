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
 * プログラム (在宅サービス介護給付費明細書（認知症対応型・特定施設入所者） (QP001P07)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * (在宅サービス介護給付費明細書（認知症対応型・特定施設入所者）(様式第六) - 帳票定義体ファイル名 ： QP001P06X_YYYYMM.xml
 */
public class QP001P06_201204 extends QP001P02_10Event {
    /**
     * コンストラクタです。
     */
    public QP001P06_201204() {
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
        VRMap typeMap = getTypeMap();

        // 印刷頁数を算出する。（1頁あたりの明細情報は7件、特定入所者介護サービス費情報は4件)
        // ※複数公費の受給を受けている場合は、受給公費分帳票を出力する。
        int pageCount = 1;
        int pageTemp = 1;

        // 印刷頁数を算出する。（1頁あたりの明細情報は11件)
        if (detailList.getDataSize() > 0) {
            //pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 11d);
            pageTemp = (int) Math.ceil((double) detailList.getDataSize() / (double)getDetailRowCount());
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }

        // 公費件数ループ
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            // レコードの復元
            parseStyle();
            // 基本情報レコード
            baseMap = getBaseMap();
            // 明細情報レコード集合
            detailList = getDetailList();
            // 集計情報レコード
            typeMap = getTypeMap();

            // 印刷ループ
            for (int i = 0; i < pageCount; i++) {
                // ページ開始
                writer.beginPageEdit(getFormatId());

                // 帳票共通情報を設定
                setPrintHeader(kohiCount);
                
                //必要であれば入居前の状況を設定
                doPrintExternalUseHeader(baseMap, typeMap);
                
                //退去を設定
                setNyusyoDate();
                
                setKyotakuData();

                // 明細件数分ループする。※行数を超える場合は、次ページに印字
                setDetailList(detailList,getDetailRowCount() + 1, kohiCount);

                if (i == 0) {
                    //サービス単位数合計を設定する。　※サービス単位数の合算を設定。
                    //setValue(servicetimetotal);
                    ACChotarouXMLUtilities.setValue(writer,"servicetimetotal", pad(String.valueOf(getServiceUnitTotal()),5));
                    //公費対象単位数合計を設定する。　※公費対象単位数の合算を設定。
                    switch(kohiCount){
                    case 0:
                        ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal1()),5));
// 2015/5/21 [Yoichiro Kamei] add - begin 公費関連見直し 
                        //公費給付率を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201030"),3));
                        //公費分の給付単位数合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kouhitanitotal", pad(baseMap.get("201039"),6));
                        //公費請求額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(baseMap.get("201040"),6));
                        //公費利用者負担額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohiriyosyafutan", pad(baseMap.get("201041"),6));
// 2015/5/21 [Yoichiro Kamei] add - end
                        break;
                    case 1:
                        ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal2()),5));
// 2015/5/21 [Yoichiro Kamei] add - begin 公費関連見直し 
                        //公費給付率を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201031"),3));
                        //公費分の給付単位数合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kouhitanitotal", pad(baseMap.get("201045"),6));
                        //公費請求額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(baseMap.get("201046"),6));
                        //公費利用者負担額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohiriyosyafutan", pad(baseMap.get("201047"),6));
// 2015/5/21 [Yoichiro Kamei] add - end
                        break;
                    case 2:
                        ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal3()),5));
// 2015/5/21 [Yoichiro Kamei] add - begin 公費関連見直し
                        //公費給付率を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201032"),3));
                        //公費分の給付単位数合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kouhitanitotal", pad(baseMap.get("201051"),6));
                        //公費請求額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(baseMap.get("201052"),6));
                        //公費利用者負担額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "kohiriyosyafutan", pad(baseMap.get("201053"),6));
// 2015/5/21 [Yoichiro Kamei] add - end
                        break;
                    }
// 2015/5/21 [Yoichiro Kamei] mod - begin 公費関連見直し 
// 既存バグ修正 上記switch(kohiCount)内で公費別に設定を行う必要あり
//                    //公費分の単位数合計を設定する。
//                    ACChotarouXMLUtilities.setValue(writer, "kouhitanitotal", pad(baseMap.get("201039"),6));
// 2015/5/21 [Yoichiro Kamei] mod - end
                    
                    //単位数単価を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "tanka", getTanka(typeMap.get("701015")));
                    
// 2015/5/21 [Yoichiro Kamei] mod - begin 公費関連見直し 
// 既存バグ修正 上記switch(kohiCount)内で公費別に設定を行う必要あり
//                    //公費給付率を設定する。
//                    ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201030"),3));
// 2015/5/21 [Yoichiro Kamei] mod - end
                    
                    if(kohiCount == 0){
                        //保険給付率を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "hokenkyufu", pad(baseMap.get("201029"),3));
                        //保険請求額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu", pad(baseMap.get("201034"),6));
                        //保険利用者負担額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "hokenriyosyafutan", pad(baseMap.get("201035"),6));
                    }
                    
// 2015/5/21 [Yoichiro Kamei] mod - begin 公費関連見直し 
// 既存バグ修正 上記switch(kohiCount)内で公費別に設定を行う必要あり
//                    //公費請求額を設定する。
//                    ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(baseMap.get("201040"),6));
//                    //公費利用者負担額を設定する。
//                    ACChotarouXMLUtilities.setValue(writer, "kohiriyosyafutan", pad(baseMap.get("201041"),6));
// 2015/5/21 [Yoichiro Kamei] mod - end
                    
                    //外部利用型の設定を行う
                    doPrintExternalUse(baseMap,typeMap);
                    
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
    
    // 明細の行数
    protected int getDetailRowCount() {
        return 11;
    }
    
    //各帳票の個別設定（全部ページ共通）
    protected void doPrintExternalUseHeader(VRMap baseMap, VRMap typeMap) throws Exception{
    }
    
    //各帳票の個別設定（1ページ目のみ）
    protected void doPrintExternalUse(VRMap baseMap, VRMap typeMap) throws Exception{
    }

}
