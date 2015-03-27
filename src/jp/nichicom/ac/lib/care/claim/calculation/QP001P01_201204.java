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
 * 作成日: 2006/01/24  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 給付管理票 (001)
 * プログラム 給付管理票 (QP001P02)
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
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 給付管理票(様式第一) 帳票定義体ファイル名 ： QP001P010_YYYYMM.xml
 */
public class QP001P01_201204 extends QP001PrintEvent {
    
    ACDateFormat eraFormat = new ACDateFormat("ggg");
    ACDateFormat eraYearFormat = new ACDateFormat("ee");
    ACDateFormat monthFormat = new ACDateFormat("MM");
    ACDateFormat dayFormat = new ACDateFormat("dd");
    private NumberFormat nf = NumberFormat.getInstance();
    
    /**
     * コンストラクタです。
     */
    public QP001P01_201204() {
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
        
        // [2015年1月改正][Shinobu Hitaka] 2014/11/11 edit start 公費54追加に伴う様式修正に対応
        //ACChotarouXMLUtilities.addFormat(writer, "QP001P010_201204", "QP001P010_201204.xml");
        //writer.beginPageEdit("QP001P010_201204");
        Date targetDt = ACCastUtilities.toDate(VRBindPathParser.get("101002",style) + "01");
        String formatName = "QP001P010_201204";
        if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2701, targetDt) < 1) {
            formatName = "QP001P010_201501";
        }
        ACChotarouXMLUtilities.addFormat(writer, formatName, formatName + ".xml");
        writer.beginPageEdit(formatName);
        // [2015年1月改正][Shinobu Hitaka] 2014/11/11 edit end
        
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
        
        // 法別番号(101005) 0、請求情報区分コード(101006) 01のデータを取得する。
        style = getTargetRecord(styles,"00","01");
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
            
            // (特定入所者介護サービス費等)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w8", getFormatData(style, "101013"));
            // (特定入所者介護サービス費等)費用を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w9", getFormatData(style, "101015"));
            // (特定入所者介護サービス費等)利用者負担を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w10", getFormatData(style, "101016"));
            // (特定入所者介護サービス費等)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w11", getFormatData(style, "101017"));
            // (特定入所者介護サービス費等)保険費用額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w12", getFormatData(style, "101018"));
            
            // (特定入所者介護サービス費等)件数合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w8", getFormatData(style, "101013"));
            // (特定入所者介護サービス費等)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w9", getFormatData(style, "101015"));
            // (特定入所者介護サービス費等)利用者負担合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w10", getFormatData(style, "101016"));
            // (特定入所者介護サービス費等)公費請求額合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w11", getFormatData(style, "101017"));
            // (特定入所者介護サービス費等)保険費用額合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w12", getFormatData(style, "101018"));
            

        }

        
        // 法別番号(101005) 0、請求情報区分コード(101006) 02のデータを取得する。
        style = getTargetRecord(styles,"00","02");
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
        
        //[H20.5 法改正対応] fujihara add start
        int tokuteiTotal = 0;
        //[H20.5 法改正対応] fujihara add end
        
        // 法別番号(101005) 12、請求情報区分コード(101006) 01のデータを取得する。
        style = getTargetRecord(styles,"12","01");
        
        if(style != null){
            // (サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w3", getFormatData(style, "101007"));
            // (サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w4", getFormatData(style, "101008"));
            // (サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w5", getFormatData(style, "101009"));
            // (サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w6", getFormatData(style, "101011"));
            // (特定入所者介護サービス費等)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w7", getFormatData(style, "101013"));
            // (特定入所者介護サービス費等)費用を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w8", getFormatData(style, "101015"));
            // (特定入所者介護サービス費等)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w9", getFormatData(style, "101017"));
            
            // (特定入所者介護サービス費等)公費請求額合計を設定する。
            //[H20.5 法改正対応] fujihara edit start
            //ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.total.w9", getFormatData(style, "101017"));
            tokuteiTotal += ACCastUtilities.toInt(style.get("101017"),0);
            //[H20.5 法改正対応] fujihara edit end
            
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        
        // 法別番号(101005) 12、請求情報区分コード(101006) 02のデータを取得する。
        style = getTargetRecord(styles,"12","02");
        
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

        
        // 法別番号(101005)が10,11,21,15,19,51,57,81,86,87,88のデータの場合、以下のデータを設定する。
        //結核34条
        //2007.4以降の場合は、感染症
        style = getTargetRecord(styles,"10","00");
        if(style != null){
            //(サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h3.w3", getFormatData(style, "101007"));
            //(サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h3.w4", getFormatData(style, "101008"));
            //(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h3.w5", getFormatData(style, "101009"));
            //(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h3.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        
        //精神32条
        style = getTargetRecord(styles,"21","00");
        if(style != null){
            //(サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h5.w3", getFormatData(style, "101007"));
            //(サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h5.w4", getFormatData(style, "101008"));
            //(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h5.w5", getFormatData(style, "101009"));
            //(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h5.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //身障・更生
        style = getTargetRecord(styles,"15","00");
        if(style != null){
            //(サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h6.w3", getFormatData(style, "101007"));
            //(サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h6.w4", getFormatData(style, "101008"));
            //(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h6.w5", getFormatData(style, "101009"));
            //(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h6.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //原爆・一般
        style = getTargetRecord(styles,"19","00");
        if(style != null){
            //(サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h7.w3", getFormatData(style, "101007"));
            //(サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h7.w4", getFormatData(style, "101008"));
            //(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h7.w5", getFormatData(style, "101009"));
            //(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h7.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //特定疾患等治療研究
        style = getTargetRecord(styles,"51","00");
        if(style != null){
            //(サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h8.w3", getFormatData(style, "101007"));
            //(サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h8.w4", getFormatData(style, "101008"));
            //(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h8.w5", getFormatData(style, "101009"));
            //(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h8.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //難病 [2015年1月改正][Shinobu Hitaka] 2014/11/11 add　※出力場所の修正が必要
        style = getTargetRecord(styles,"54","00");
        if(style != null){
            //(サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h17.w3", getFormatData(style, "101007"));
            //(サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h17.w4", getFormatData(style, "101008"));
            //(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h17.w5", getFormatData(style, "101009"));
            //(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h17.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //障害者・支援措置
        style = getTargetRecord(styles,"57","00");
        if(style != null){
            //(サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h9.w3", getFormatData(style, "101007"));
            //(サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h9.w4", getFormatData(style, "101008"));
            //(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h9.w5", getFormatData(style, "101009"));
            //(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h9.w6", getFormatData(style, "101011"));
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
        //被爆体験者
        style = getTargetRecord(styles,"86","00");
        if(style != null){
            //(サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h11.w3", getFormatData(style, "101007"));
            //(サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h11.w4", getFormatData(style, "101008"));
            //(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h11.w5", getFormatData(style, "101009"));
            //(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h11.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //有機ヒ素・緊急措置
        style = getTargetRecord(styles,"87","00");
        if(style != null){
            //(サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h12.w3", getFormatData(style, "101007"));
            //(サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h12.w4", getFormatData(style, "101008"));
            //(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h12.w5", getFormatData(style, "101009"));
            //(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h12.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //水俣病総合対策メチル水銀
        style = getTargetRecord(styles,"88","00");
        if(style != null){
            //(サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h13.w3", getFormatData(style, "101007"));
            //(サービス費用)単位数・点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h13.w4", getFormatData(style, "101008"));
            //(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h13.w5", getFormatData(style, "101009"));
            //(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h13.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //石綿
        style = getTargetRecord(styles,"66","00");
        if(style != null){
            //(サービス費用)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h14.w3", getFormatData(style, "101007"));
            //(サービス費用)単位数・点数を設定する
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h14.w4", getFormatData(style, "101008"));
            //(サービス費用)費用合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h14.w5", getFormatData(style, "101009"));
            //(サービス費用)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h14.w6", getFormatData(style, "101011"));
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
            
            // (特定入所者介護サービス費等)件数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h16.w7", getFormatData(style, "101013"));
            // (特定入所者介護サービス費等)費用を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h16.w8", getFormatData(style, "101015"));
            // (特定入所者介護サービス費等)公費請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h16.w9", getFormatData(style, "101017"));
            
            tokuteiTotal += ACCastUtilities.toInt(style.get("101017"),0);
            
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        
        // サービス費用公費合計を設定する。
        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.total.w6",getFormatData(total));
        
        //(特定入所者介護サービス費等)公費請求額合計を設定する。
        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.total.w9", getFormatData(tokuteiTotal));
        
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
        //法別番号(101005) 0、請求情報区分コード(101006) 01のデータを取得する。
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
