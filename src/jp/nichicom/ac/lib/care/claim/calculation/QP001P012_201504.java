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
 * 開発者: 
 * 作成日: 2016/07/11
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 給付管理票 (001)
 * プログラム 給付管理票 (QP001P012)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.text.NumberFormat;
import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * 給付管理票(様式第一の二) 帳票定義体ファイル名 ： QP001P012_YYYYMM.xml
 */
public class QP001P012_201504 extends QP001PrintEvent {
    
    ACDateFormat eraFormat = new ACDateFormat("ggg");
    ACDateFormat eraYearFormat = new ACDateFormat("ee");
    ACDateFormat monthFormat = new ACDateFormat("MM");
    ACDateFormat dayFormat = new ACDateFormat("dd");
    private NumberFormat nf = NumberFormat.getInstance();
    
    /**
     * コンストラクタです。
     */
    public QP001P012_201504() {
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
    public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam)
            throws Exception {
        
        // printArrayに、渡りパラメータの KEY : PARAM の VALUE を設定する。
        // ※以下、printArrayに格納されているレコードを参照する。
        VRList styles = (VRList)VRBindPathParser.get("STYLE_DATA", printParam);
        //事業所情報
        VRMap providerMap = (VRMap)printParam.get("PROVIDERS");
        VRMap style = (VRMap)styles.get(0);
        VRMap provider = (VRMap)providerMap.get(style.get("101003"));
        
        String formatName = "QP001P012_201504";
        ACChotarouXMLUtilities.addFormat(writer, formatName, formatName + ".xml");
        writer.beginPageEdit(formatName);
        
        
        // 印刷用情報格納用のVRArrayList printArrayを定義する。
        //様式番号の表示設定
        if(ACCastUtilities.toInt(printParam.get("YOSHIKI_BANGO"),0) == 0){
            ACChotarouXMLUtilities.setInvisible(writer, "header1");
            ACChotarouXMLUtilities.setInvisible(writer, "header2");
        }
        
        
        //サービス提供日を設定する。
        if(QP001Util.isDate(style.get("101002"))){
            Date target = ACCastUtilities.toDate(VRBindPathParser.get("101002",style) + "01");
            
            //サービス提供和暦を設定する。
            ACChotarouXMLUtilities.setValue(writer,"teikyoYMD.h1.w1",eraFormat.format(target));
            //サービス提供和暦年(YYフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer,"teikyoyear",eraYearFormat.format(target));
            //サービス提供月(MMフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer,"teikyomonth",monthFormat.format(target));
        }
        
        //請求日を設定する。
        if(QP001Util.isDate(printParam.get("SEIKYU_DATE"))){
            Date seikyu = ACCastUtilities.toDate(VRBindPathParser.get("SEIKYU_DATE",printParam));
            //請求日和暦を設定する。(値は画面上から取得)
            ACChotarouXMLUtilities.setValue(writer,"seikyuwareki",eraFormat.format(seikyu));
            //請求日和暦年(YYフォーマット)を設定する。(値は画面上から取得)
            ACChotarouXMLUtilities.setValue(writer,"seikyuyear",eraYearFormat.format(seikyu));
            //請求日提供月(MMフォーマット)を設定する。(値は画面上から取得)
            ACChotarouXMLUtilities.setValue(writer,"seikyumonth",monthFormat.format(seikyu));
            //請求日提供日(DDフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer,"seikyuday",dayFormat.format(seikyu));
        }

        // 事業所番号を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "101003", "jigyosyono");
        
        // 請求事業所名称を設定する。 ※事業所のマスタと突合する。
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_NAME","jigyosyo.h1.w3");
        // 請求事業所郵便番号を設定する。 ※事業所のマスタと突合する。
        //PROVIDER_ZIP_FIRST,PROVIDER_ZIP_SECOND
        
        ACChotarouXMLUtilities.setValue(writer, "jigyosyozipfirst", VRBindPathParser.get("PROVIDER_ZIP_FIRST", provider));
        ACChotarouXMLUtilities.setValue(writer, "jigyosyozipsecond",  VRBindPathParser.get("PROVIDER_ZIP_SECOND", provider));
        
        // 請求事業所住所を設定する。 ※事業所のマスタと突合する。
        ACChotarouXMLUtilities.setValue(writer, provider ,"PROVIDER_ADDRESS","jigyosyo.h3.w3");
        // 請求事業所連絡先を設定する。 ※事業所のマスタと突合する。
        ACChotarouXMLUtilities.setValue(writer, "jigyosyo.h5.w6", QkanCommon
                .toTel(VRBindPathParser.get("PROVIDER_TEL_FIRST", provider),
                        VRBindPathParser.get("PROVIDER_TEL_SECOND", provider),
                        VRBindPathParser.get("PROVIDER_TEL_THIRD", provider)));
        
        
        int _101007 = 0;
        int _101008 = 0;
        int _101009 = 0;
        int _101010 = 0;
        
        // 法別番号(101005) 0、請求情報区分コード(101006) 05のデータを取得する。
        style = getTargetRecord(styles,"00","05");
        if(style != null){
            // (サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w2", getFormatData(style, "101007"));
            // (サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w3", getFormatData(style, "101008"));
            // (サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w4", getFormatData(style, "101009"));
            // (サービス費用)保険請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w5", getFormatData(style, "101010"));
            // (サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w6", getFormatData(style, "101011"));
            // (サービス費用)利用者負担を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w7", getFormatData(style, "101012"));
            
            // (サービス費用)公費請求額合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w6", getFormatData(style, "101011"));
            // (サービス費用)利用者負担合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w7", getFormatData(style, "101012"));
            
            _101007 += ACCastUtilities.toInt(style.get("101007"),0);
            _101008 += ACCastUtilities.toInt(style.get("101008"),0);
            _101009 += ACCastUtilities.toInt(style.get("101009"),0);
            _101010 += ACCastUtilities.toInt(style.get("101010"),0);
            
        }

        
        // 法別番号(101005) 0、請求情報区分コード(101006) 06のデータを取得する。
        style = getTargetRecord(styles,"00","06");
        if(style != null){
            // (サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h2.w2", getFormatData(style, "101007"));
            // (サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h2.w3", getFormatData(style, "101008"));
            // (サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h2.w4", getFormatData(style, "101009"));
            // (サービス費用)保険請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h2.w5", getFormatData(style, "101010"));
            
            _101007 += ACCastUtilities.toInt(style.get("101007"),0);
            _101008 += ACCastUtilities.toInt(style.get("101008"),0);
            _101009 += ACCastUtilities.toInt(style.get("101009"),0);
            _101010 += ACCastUtilities.toInt(style.get("101010"),0);
        }
        
        // (サービス費用)件数合算を設定する。
        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w2", getFormatData(_101007));
        // (サービス費用)単位数・点数合算を設定する。
        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w3", getFormatData(_101008));
        // (サービス費用)費用合計合算を設定する。
        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w4", getFormatData(_101009));
        // (サービス費用)保険請求額合算を設定する。
        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w5", getFormatData(_101010));


        int total = 0;
        
        
        // 法別番号(101005) 12、請求情報区分コード(101006) 05のデータを取得する。
        style = getTargetRecord(styles,"12","05");
        
        if(style != null){
            // (サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w3", getFormatData(style, "101007"));
            // (サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w4", getFormatData(style, "101008"));
            // (サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w5", getFormatData(style, "101009"));
            // (サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        
        // 法別番号(101005) 12、請求情報区分コード(101006) 06のデータを取得する。
        style = getTargetRecord(styles,"12","06");
        
        if(style != null){
            // (サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h2.w3", getFormatData(style, "101007"));
            // (サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h2.w4", getFormatData(style, "101008"));
            // 　(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h2.w5", getFormatData(style, "101009"));
            // 　(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h2.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
       
        //被爆者助成
        style = getTargetRecord(styles,"81","00");
        if(style != null){
            //(サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h10.w3", getFormatData(style, "101007"));
            //(サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h10.w4", getFormatData(style, "101008"));
            //(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h10.w5", getFormatData(style, "101009"));
            //(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h10.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        
        //特別対策 全額免除
        style = getTargetRecord(styles,"58","00");
        if(style != null){
            //(サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h15.w3", getFormatData(style, "101007"));
            //(サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h15.w4", getFormatData(style, "101008"));
            //(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h15.w5", getFormatData(style, "101009"));
            //(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h15.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        
        //中国残留邦人等
        style = getTargetRecord(styles,"25","00");
        if(style != null){
            //(サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h16.w3", getFormatData(style, "101007"));
            //(サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h16.w4", getFormatData(style, "101008"));
            //(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h16.w5", getFormatData(style, "101009"));
            //(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h16.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        
        // サービス費用公費合計を設定する。
        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.total.w6",getFormatData(total));
        
        
        //ページ終了
        writer.endPageEdit();
        //印刷を実行したならばtrueを返す。
        return true;
    }
    
    /**
     * 指定したレコードを取得する。
     * @param list データリスト
     * @param lawNo 法別番号
     * @param kbn  請求情報区分コード
     * @return
     * @throws Exception
     */
    private VRMap getTargetRecord(VRList list, String lawNo, String kbn) throws Exception {
        //法別番号(101005) 0、請求情報区分コード(101006) 05のデータを取得する。
        if(list == null) return null;
        
        for(int i = 0; i < list.getDataSize(); i++){
            VRMap map = (VRMap)list.get(i);
            //法別番号を確認する
            if(lawNo.equals(VRBindPathParser.get("101005",map))){
                //請求情報区分レコードを確認する
                if(kbn.equals(VRBindPathParser.get("101006",map))){
                    return map;
                }
            }
        }
        return null;
    }
    
    
    private String getFormatData(int value) throws Exception {
        if(value == 0) return "";
        
        return nf.format((double)(value));
    }
    
    private String getFormatData(VRMap style,String key) throws Exception{
        if((style == null) || !style.containsKey(key)) return "";
        
        String value = String.valueOf(style.get(key));
        
        if(ACTextUtilities.isNullText(value) || "0".equals(value)){
            return "";
        }
        
        return nf.format(ACCastUtilities.toDouble(value));
    }
}
