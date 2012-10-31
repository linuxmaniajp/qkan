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
 * 作成日: 2006/01/21  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 在宅介護支援介護給付費明細書 (001)
 * プログラム 在宅介護支援介護給付費明細書 (QP001P08)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACKanaConvert;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * 在宅介護支援介護給付費明細書(様式第七) - 帳票定義体ファイル名 ： QP001P07X_YYYYMM.xml
 */
public class QP001P07_201204 extends QP001PrintEvent {
	
	/* 
	 * 2009-02-25
	 * [ID:0000447][Shin Fujihara] 2009/02 edit begin 平成21年4月法改正対応
	 * プログラムの内容を大幅修正
	 */
	
    ACDateFormat eraFormat = new ACDateFormat("ggg");
    ACDateFormat eraYearFormat = new ACDateFormat("ee");
    ACDateFormat monthFormat = new ACDateFormat("MM");
    ACDateFormat dayFormat = new ACDateFormat("dd");
    
    
    // 印刷情報
    private VRList styleList = null;
    // 事業者情報
    private VRMap providerMap = null;
    // 対象事業者
    private VRMap provider = null;
    //様式番号の表示・非表示
    private boolean yoshikiBango = true;
    // ヘッダ情報用に最初のデータを退避しておく
    private VRMap header = null;
    private int term = 0;
    
    /**
     * コンストラクタです。
     */
    public QP001P07_201204() {
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
    	
        // 印刷情報
        styleList = (VRList) printParam.get("STYLE_DATA");
        // 事業者情報
        providerMap = (VRMap) printParam.get("PROVIDERS");
        // ヘッダ情報用に最初のデータを退避しておく
        header = (VRMap)((VRList)((VRMap) styleList.get(0)).get("CLAIM_DATA")).get(0);
        // 対象事業者
        //provider = (VRMap) providerMap.get(((VRMap) styleList.get(0)).get("1001002"));
        provider = (VRMap) providerMap.get(header.get("1001002"));
        
        //様式番号の表示を決定
        if(ACCastUtilities.toInt(printParam.get("YOSHIKI_BANGO"),0) == 0){
            //0なら様式番号を非表示とする。
            yoshikiBango = false;
        }
    	
        // 帳票IDを設定
        addFormat(writer);
        
        // 給付管理票出力枚数を算出
        int pageCount = (int) Math.ceil((double) styleList.getDataSize() / 2d);

        // 印刷ループ
        for (int i = 0; i < pageCount; i++) {
            // ページ開始
            writer.beginPageEdit(getFormatId());
            
            //様式番号の表示設定
            if(!yoshikiBango){
                ACChotarouXMLUtilities.setInvisible(writer, "header1");
                ACChotarouXMLUtilities.setInvisible(writer, "header2");
            }

            // ページヘッダの設定
            if (QP001Util.isDate(header.get("1001004"))) {
                Date teikyo = ACCastUtilities.toDate(VRBindPathParser.get("1001004", header) + "01");
                // サービス提供年月和暦を設定する。
                ACChotarouXMLUtilities.setValue(writer, "serviceYMD.h1.w1",
                        eraFormat.format(teikyo));
                // サービス提供年月和暦年(YYフォーマット)を設定する。
                ACChotarouXMLUtilities.setValue(writer, "serviceyear",
                        eraYearFormat.format(teikyo));
                // サービス提供年月月(MMフォーマット)を設定する。
                ACChotarouXMLUtilities.setValue(writer, "servicemonth",
                        monthFormat.format(teikyo));

            }

            // 保険者番号を設定する。
            ACChotarouXMLUtilities.setValue(writer, header, "1001005",
                    "hokensyano");
            // 公費負担者番号を設定する。
            ACChotarouXMLUtilities.setValue(writer, header, "1001008",
                    "kouhihutanno");
            // 事業者番号を設定する。
            ACChotarouXMLUtilities.setValue(writer, header, "1001002",
                    "jigyosyano");
            // 事業所名称を設定する。
            ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_NAME", "jigyousyo.h3.w3");
            // 事業所郵便番号の前半３桁を設定する。
            ACChotarouXMLUtilities.setValue(writer, provider,
                    "PROVIDER_ZIP_FIRST", "jigyousyozip1");
            // 事業所郵便番号の後半４桁を設定する。
            ACChotarouXMLUtilities.setValue(writer, provider,
                    "PROVIDER_ZIP_SECOND", "jigyousyozip2");
            // 事業所の所在地を設定する。
            ACChotarouXMLUtilities.setValue(writer, provider,
                    "PROVIDER_ADDRESS", "jigyousyo.h2.w14");
            // 事業所の電話番号を設定する。
            ACChotarouXMLUtilities.setValue(writer, "jigyousyo.h6.w22",
                    QkanCommon.toTel(ACCastUtilities.toString(VRBindPathParser
                            .get("PROVIDER_TEL_FIRST", provider)),
                            ACCastUtilities.toString(VRBindPathParser.get(
                                    "PROVIDER_TEL_SECOND", provider)),
                            ACCastUtilities.toString(VRBindPathParser.get(
                                    "PROVIDER_TEL_THIRD", provider))));

            // 単価を設定する。
            ACChotarouXMLUtilities.setValue(writer, "tanka", getTanka(header.get("1001006")));

            // 1頁あたりの被保険者数は2件
            for (int j = 1; j < 3; j++) {
                if (styleList.getDataSize() == 0) {
                    // 「明治」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "meiji" + j);
                    // 「大正」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "taisyo" + j);
                    // 「昭和」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "syowa" + j);

                    // 要支援の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);

                    // 要支援１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                    // 要支援２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                    
                    // 要介護１の○を非表示にする。
                    ACChotarouXMLUtilities
                            .setInvisible(writer, "youkaigo1" + j);
                    // 要介護２の○を非表示にする。
                    ACChotarouXMLUtilities
                            .setInvisible(writer, "youkaigo2" + j);
                    // 要介護３の○を非表示にする。
                    ACChotarouXMLUtilities
                            .setInvisible(writer, "youkaigo3" + j);
                    // 要介護４の○を非表示にする。
                    ACChotarouXMLUtilities
                            .setInvisible(writer, "youkaigo4" + j);
                    // 要介護５の○を非表示にする。
                    ACChotarouXMLUtilities
                            .setInvisible(writer, "youkaigo5" + j);

                    // 「女」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "woman" + j);
                    // 「男」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "man" + j);
                    continue;
                }

                VRMap main_map = (VRMap) styleList.get(0);
                VRList claim_data = (VRList)main_map.get("CLAIM_DATA");
                VRMap map = (VRMap)claim_data.get(0);

                // 項番を設定する。
                ACChotarouXMLUtilities.setValue(writer, "grdKouban" + j + ".h4.w1", Integer.toString(i * 2 + j));

                // 被保険者番号を設定する。
                ACChotarouXMLUtilities.setValue(writer, map, "1001007",
                        "hihokensyano" + j);

                // 公費受給者番号を設定する。
                ACChotarouXMLUtilities.setValue(writer, map, "1001009",
                        "kouhijyukyusya" + j);

                if (QP001Util.isDate(map.get("1001010"))) {
                    Date birthDay = ACCastUtilities.toDate(VRBindPathParser
                            .get("1001010", map));

                    String era = eraFormat.format(birthDay);

                    // 「明治」の場合
                    if ("明治".equals(era)) {
                        // 「大正」の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "taisyo" + j);
                        // 「昭和」の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "syowa" + j);

                        // 「大正」の場合
                    } else if ("大正".equals(era)) {
                        // 「明治」の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "meiji" + j);
                        // 「昭和」の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "syowa" + j);

                        // 「昭和」の場合
                    } else if ("昭和".equals(era)) {
                        // 「明治」の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "meiji" + j);
                        // 「大正」の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "taisyo" + j);

                        // 上記以外は表示を消す
                    } else {
                        // 「明治」の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "meiji" + j);
                        // 「大正」の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "tasiyo" + j);
                        // 「昭和」の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "syowa" + j);
                    }

                    // 生年月日の和暦年号を設定する。
                    setData(writer, "hihodata2" + j + ".h2.w", eraYearFormat.format(birthDay), 2, 2);
                    // 生年月日の月(MMフォーマット)を設定する。
                    setData(writer, "hihodata2" + j + ".h2.w", monthFormat.format(birthDay), 5, 2);
                    // 生年月日の日(DDフォーマット)を設定する。
                    setData(writer, "hihodata2" + j + ".h2.w", dayFormat.format(birthDay), 8, 2);
                }

                if (!ACTextUtilities.isNullText(VRBindPathParser.get("1001012",map))) {
                    switch (ACCastUtilities.toInt(VRBindPathParser.get("1001012", map))) {
                    // 「11-要支援」の場合
                    case 11:
                        // 要支援１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // 要支援２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // 要介護１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // 要介護２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // 要介護３の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // 要介護４の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        // 要介護５の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;

                    // 「12-要支援１」の場合
                    case 12:
                        // 要支援の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // 要支援２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // 要介護１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // 要介護２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // 要介護３の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // 要介護４の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        // 要介護５の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;
                    // 「13-要支援２」の場合
                    case 13:
                        // 要支援の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // 要支援１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // 要介護１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // 要介護２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // 要介護３の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // 要介護４の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        // 要介護５の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;
                    // 「21-要介護１」の場合
                    case 21:
                        // 要支援の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // 要支援１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // 要支援２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // 要介護２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // 要介護３の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // 要介護４の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        // 要介護５の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;

                    // 「22-要介護２」の場合
                    case 22:
                        // 要支援の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // 要支援１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // 要支援２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // 要介護１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // 要介護３の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // 要介護４の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        // 要介護５の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;

                    // 「23-要介護３」の場合
                    case 23:
                        // 要支援の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // 要支援１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // 要支援２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // 要介護１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // 要介護２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // 要介護４の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        // 要介護５の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;

                    // 「24-要介護４」の場合
                    case 24:
                        // 要支援の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // 要支援１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // 要支援２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // 要介護１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // 要介護２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // 要介護３の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // 要介護５の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;

                    // 「25-要介護５」の場合
                    case 25:
                        // 要支援の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // 要支援１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // 要支援２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // 要介護１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // 要介護２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // 要介護３の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // 要介護４の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        break;

                    // 上記以外の場合
                    default:
                        // 要支援の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // 要支援１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // 要支援２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // 要介護１の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // 要介護２の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // 要介護３の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // 要介護４の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        // 要介護５の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;
                    }

                } else {
                    // 要支援の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                    // 要介護１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                    // 要介護２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                    // 要介護３の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                    // 要介護４の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                    // 要介護５の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                }

                //被保険者フリガナを設定する。
                ACChotarouXMLUtilities.setValue(writer, "hihodata1" + j
                        + ".h1.w13", ACKanaConvert.toKatakana(QkanCommon.toFullName(main_map
                        .get("PATIENT_FAMILY_KANA"), main_map
                        .get("PATIENT_FIRST_KANA"))));
                
                //被保険者氏名を設定する。
                ACChotarouXMLUtilities.setValue(writer, "hihodata1" + j
                        + ".h2.w13", QkanCommon.toFullName(main_map
                        .get("PATIENT_FAMILY_NAME"), main_map
                        .get("PATIENT_FIRST_NAME")));

                //被保険者の性別コードを取得する。※1001011の値より取得する。
                switch (ACCastUtilities.toInt(VRBindPathParser.get("1001011",
                        map))) {
                //1(男)の場合。
                case 1:
                    //「女」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "woman" + j);
                    break;

                //2(女)の場合
                case 2:
                    //「男」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "man" + j);
                    break;

                default:
                    //「女」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "woman" + j);
                    //「男」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "man" + j);
                    break;
                }

                //認定有効期間開始日
                if (QP001Util.isDate(map.get("1001013"))) {
                    Date start = ACCastUtilities.toDate(VRBindPathParser.get(
                            "1001013", map));
                    //認定有効期間開始日の和暦を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "hihodata2" + j
                            + "h1.w18", eraFormat.format(start));
                    //認定有効期間開始日の和暦年(YYフォーマット)を設定する。
                    setData(writer, "hihodata2" + j + ".h1.w", eraYearFormat
                            .format(start), 19, 2);
                    //認定有効期間開始日の和暦月(MMフォーマット)を設定する。
                    setData(writer, "hihodata2" + j + ".h1.w", monthFormat
                            .format(start), 22, 2);
                    //認定有効期間開始日の和暦日(DDフォーマット)を設定する。
                    setData(writer, "hihodata2" + j + ".h1.w", dayFormat
                            .format(start), 25, 2);

                }

                //認定有効期間終了日
                if (QP001Util.isDate(map.get("1001014"))) {
                    Date end = ACCastUtilities.toDate(VRBindPathParser.get(
                            "1001014", map));
                    //認定有効期間終了日の和暦を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "hihodata2" + j
                            + "h2.w18", eraFormat.format(end));
                    //認定有効期間終了日の和暦年(YYフォーマット)を設定する。
                    setData(writer, "hihodata2" + j + ".h2.w", eraYearFormat
                            .format(end), 19, 2);
                    //認定有効期間終了日の和暦月(MMフォーマット)を設定する。
                    setData(writer, "hihodata2" + j + ".h2.w", monthFormat
                            .format(end), 22, 2);
                    //認定有効期間終了日の和暦日(DDフォーマット)を設定する。
                    setData(writer, "hihodata2" + j + ".h2.w", dayFormat
                            .format(end), 25, 2);

                }

                //居宅サービス計画作成依頼届出年月日
                Date start = null;
                if ((start = ACCastUtilities.toDate(map.get("1001015"),null)) != null) {
                    //居宅サービス計画作成依頼届出年月日の和暦を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "hihodata2" + j
                            + "h3.w12", eraFormat.format(start));
                    //居宅サービス計画作成依頼届出年月日の和暦年(YYフォーマット)を設定する。
                    setData(writer, "hihodata2" + j + ".h3.w", eraYearFormat
                            .format(start), 13, 2);
                    //居宅サービス計画作成依頼届出年月日の月(MMフォーマット)を設定する。
                    setData(writer, "hihodata2" + j + ".h3.w", monthFormat
                            .format(start), 16, 2);
                    //居宅サービス計画作成依頼届出年月日の日(ＤＤフォーマット)を設定する。
                    setData(writer, "hihodata2" + j + ".h3.w", dayFormat
                            .format(start), 19, 2);

                }
                
                //担当介護支援専門員番号を設定する。
                setData(writer, "hihodata2" + j + ".h3.w", pad(map.get("1001022"),8), 3, 8);
                
                
                //ここから明細印字
                //明細印字で改ページは発生しない
                for (int k = 0; k < claim_data.size(); k++) {
                    map = (VRMap)claim_data.get(k);
                    //サービス名称を設定する
                    ACChotarouXMLUtilities.setValue(writer, map, "1001028", "hihodata3" + j + ".h" + (k + 1) + ".w1");
                    
                    //サービスコードを設定する。
                    ACChotarouXMLUtilities.setValue(writer, map, "1001016", "servicecode" + (k + 1) + "" + j);
                    //単位数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "tani" + (k + 1) + "" + j, pad(map.get("1001025"),4));
                    //回数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "times" + (k + 1) + "" + j, pad(map.get("1001026"),2));
                    //サービス単位数を設定する。
                    ACChotarouXMLUtilities.setValue(writer, "servicetime" + (k + 1) + "" + j, pad(map.get("1001017"),5));
                    //摘要欄を設定する。
                    ACChotarouXMLUtilities.setValue(writer, map, "1001023", "hihodata3" +j + ".h" + (k + 1) + ".tekiyo");
                    
                    //レコード順次番号が99の場合
                    if (ACCastUtilities.toInt(map.get("1001024"),0) == 99) {
                        //サービス単位数合計を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "tanitotal" + j, pad(map.get("1001027"),6));
                        //請求金額を設定する。
                        ACChotarouXMLUtilities.setValue(writer, "seikyutotal" + j, pad(map.get("1001018"),6));
                        
                    }
                }

                styleList.remove(0);
            }
            //ページ終了
            writer.endPageEdit();

        }

        //印刷を実行したならばtrueを返す。
        return true;
    }

    public void addFormat(ACChotarouXMLWriter writer) throws Exception {
    }
    public String getFormatId() throws Exception {
    	return null;
    }
    
    private void setData(ACChotarouXMLWriter writer, String target,
            Object objValue, int start, int pad) throws Exception {
        char values[] = pad(objValue, pad).toCharArray();

        for (int i = start; i < start + pad; i++) {
            ACChotarouXMLUtilities.setValue(writer, target + i, String
                    .valueOf(values[i - start]));
        }
    }

    protected String pad(Object value, int pad) throws Exception {
        String temp = "";
        if (!ACTextUtilities.isNullText(value)){
            temp = ACCastUtilities.toString(value);
        }
        StringBuilder padString = new StringBuilder();
        for (int i = 0; i < pad - temp.length(); i++) {
        	//全角に変更
            //padString.append(" ");
        	padString.append("　");
        }
        return padString.toString() + temp;
    }
    /**
     * 12.34型式の値の.を抜いて、1234に変更します。
     * 5.67型式の場合は先頭に空白をいれて567を返却します。
     * @param value
     * @return
     * @throws Exception
     */
    protected String getTanka(Object value) throws Exception {
        if (ACTextUtilities.isNullText(value))
            return "";
        String[] temp = ACCastUtilities.toString(value).split("\\.");
        temp[0] = pad(temp[0], 2);
        if (temp.length == 1){
            return temp[0] + "00";
        } else if(temp.length > 1){
            switch(temp[1].length()){
            case 0:
                temp[1] = "00";
                break;
            case 1:
                temp[1] += "0";
                break;
            }
        }
        return temp[0] + temp[1];

    }
    
    //提供日の期間を取得
    public int getTerm() {
    	return this.term;
    }
}
