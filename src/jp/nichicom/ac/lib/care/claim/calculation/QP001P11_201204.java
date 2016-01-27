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
 * 更新日: 2015/01/23  MIS九州　日高　様式変更対応
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 給付管理票 (001)
 * プログラム 給付管理票 (QP001P01)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

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
 * 給付管理票(様式第十一) 帳票定義体ファイル名 ： QP001P110_YYYYMM.xml
 */
public class QP001P11_201204 extends QP001PrintEvent {

    ACDateFormat eraFormat = new ACDateFormat("ggg");

    ACDateFormat eraYearFormat = new ACDateFormat("ee");

    ACDateFormat monthFormat = new ACDateFormat("MM");

    ACDateFormat dayFormat = new ACDateFormat("dd");

    ACDateFormat eraAllFormat = new ACDateFormat("ee 年 MM 月 dd 日 ");
    
    ACDateFormat periodFormat = new ACDateFormat("ee 年 MM 月");

    /**
     * コンストラクタです。
     */
    public QP001P11_201204() {
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
        // 必要であれば帳票IDを書き換えること。
        ACChotarouXMLUtilities.addFormat(writer, "QP001P110_201204", "QP001P110_201204.xml");

        // 帳票情報
        VRList styles = (VRList) printParam.get("STYLE_DATA");
        // 事業所情報
        VRMap providerMap = (VRMap) printParam.get("PROVIDERS");
        // 利用者情報
        VRMap patient = (VRMap) printParam.get("PATIENT");
        
        VRMap header = (VRMap)styles.get(0);
        
        boolean yoshikiBango = true;
        //様式番号の表示を決定
        if(ACCastUtilities.toInt(printParam.get("YOSHIKI_BANGO"),0) == 0){
            //0なら様式番号を非表示とする。
            yoshikiBango = false;
        }
        
        int totalUnit = 0;
        Map<String, VRMap> sorter = new TreeMap<String, VRMap>();
        // 給付計画単位数合計
        for(int i = 0; i < styles.size(); i++){
            VRMap map = (VRMap)styles.get(i);
            //99レコードは抜く
            if(ACTextUtilities.isNullText(map.get("1201019"))){
                header = map;
                continue;
            }
            
            totalUnit += ACCastUtilities.toInt(map.get("1201020"));
            
            //サービス種類コード-事業所番号でソート
            sorter.put(String.valueOf(map.get("1201019")) + "-" + String.valueOf(map.get("1201017")),map);
        }
        styles.clear();
        Iterator<String> it = sorter.keySet().iterator();
        while(it.hasNext()){
            styles.add(sorter.get(it.next()));
        }

        // ページ数のトータル
        int pageCount = (int) Math.ceil(((double) styles.size() / 20));

        // ページヘッダー作成

        // ページ数分ループ
        for (int i = 0; i < pageCount; i++) {
            
            writer.beginPageEdit("QP001P110_201204");
            
            // ページ開始
            if (QP001Util.isDate(header.get("1201002"))) {
                Date targetDate = ACCastUtilities.toDate(VRBindPathParser.get("1201002", header) + "01");
                // 対象年月の和暦を設定する。
                ACChotarouXMLUtilities.setValue(writer, "wareki", eraFormat
                        .format(targetDate));
                // 対象年月の和暦年(ＹＹフォーマット)を設定する。
                ACChotarouXMLUtilities.setValue(writer, "warekinen",
                        eraYearFormat.format(targetDate));
                // 対象年月の月(MMフォーマット)を設定する。
                ACChotarouXMLUtilities.setValue(writer, "warekitsuki",
                        monthFormat.format(targetDate));
            }
            
            //出力する帳票の定義体を変更する必要があるため、ロジックの位置を変更
            //様式番号の表示設定
            if(!yoshikiBango){
                ACChotarouXMLUtilities.setInvisible(writer, "header1");
                ACChotarouXMLUtilities.setInvisible(writer, "header2");
            }

            // 保険者番号を設定する。
            ACChotarouXMLUtilities.setValue(writer, header, "1201003",
                    "hokensyano");

            // 保険者名称を設定する。
            ACChotarouXMLUtilities.setValue(writer, header, "1201028",
            "data1.h2.w11");

            // 被保険者番号を設定する。
            ACChotarouXMLUtilities.setValue(writer, header, "1201009",
                    "hihokensyano");

            // 被保険者のフリガナを設定する。 ※利用者マスタと突合
            ACChotarouXMLUtilities.setValue(writer, "data1.h4.w12", ACKanaConvert.toKatakana(QkanCommon
                    .toFullName(ACCastUtilities.toString(VRBindPathParser.get(
                            "PATIENT_FAMILY_KANA", patient)), ACCastUtilities
                            .toString(VRBindPathParser.get(
                                    "PATIENT_FIRST_KANA", patient)))));

            // 被保険者の氏名を設定する。 ※利用者のマスタと突合
            ACChotarouXMLUtilities.setValue(writer, "data1.h5.w11", QkanCommon
                    .toFullName(ACCastUtilities.toString(VRBindPathParser.get(
                            "PATIENT_FAMILY_NAME", patient)), ACCastUtilities
                            .toString(VRBindPathParser.get(
                                    "PATIENT_FIRST_NAME", patient))));

            if (QP001Util.isDate(header.get("1201010"))) {
                // 被保険者生年月日の和暦を取得する。 ※1201010より取得
                Date birthDay = ACCastUtilities.toDate(VRBindPathParser.get(
                        "1201010", header));

                String era = eraFormat.format(birthDay);
                // 「明治」の場合
                if ("明治".equals(era)) {
                    // 「大正」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "taisyo");
                    // 「昭和」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "syowa");

                    // 「大正」の場合
                } else if ("大正".equals(era)) {
                    // 「明治」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "meiji");
                    // 「昭和」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "syowa");

                    // 「昭和」の場合
                } else if ("昭和".equals(era)) {
                    // 「明治」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "meiji");
                    // 「大正」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "taisyo");
                } else {
                    // 「明治」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "meiji");
                    // 「大正」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "taisyo");
                    // 「昭和」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "syowa");
                }
                
                // 生年月日の和暦年号を設定する。 ※YY年MM月DD日型式で出力
                ACChotarouXMLUtilities.setValue(writer, "data2.h3.w1",
                        eraAllFormat.format(birthDay));

            }

            // 被保険者の性別コードを取得する。 ※1201011より取得
            if (!ACTextUtilities.isNullText(VRBindPathParser.get("1201011",
                    header))) {

                switch (ACCastUtilities.toInt(VRBindPathParser.get("1201011",
                        header))) {
                // 1(男)の場合。
                case 1:
                    // 「女」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "woman");
                    break;

                // 2(女)の場合
                case 2:
                    // 「男」の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "man");
                    break;

                default:
                    ACChotarouXMLUtilities.setInvisible(writer, "man");
                    ACChotarouXMLUtilities.setInvisible(writer, "woman");
                    break;
                }
            } else {
                ACChotarouXMLUtilities.setInvisible(writer, "man");
                ACChotarouXMLUtilities.setInvisible(writer, "woman");
            }

            // 被保険者の要介護常態区分を取得する。 ※1201012より取得
            if (!ACTextUtilities.isNullText(VRBindPathParser.get("1201012",
                    header))) {
                switch (ACCastUtilities.toInt(VRBindPathParser.get("1201012",
                        header))) {
                // 「11-経過的要介護（要支援）」の場合
                case 11:
                    // 要支援１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // 要支援２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // 要介護１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // 要介護２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // 要介護３の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // 要介護４の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // 要介護５の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // 事業対象者の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;

                //要支援１
                case 12:
                    // 経過的要介護（要支援）の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // 要支援２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // 要介護１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // 要介護２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // 要介護３の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // 要介護４の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // 要介護５の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // 事業対象者の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;
                //要支援２
                case 13:
                    // 経過的要介護（要支援）の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // 要支援１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // 要介護１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // 要介護２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // 要介護３の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // 要介護４の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // 要介護５の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // 事業対象者の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;
                // 「21-要介護１」の場合
                case 21:
                    // 経過的要介護（要支援）の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // 要支援１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // 要支援２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // 要介護２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // 要介護３の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // 要介護４の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // 要介護５の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // 事業対象者の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;

                // 「22-要介護２」の場合
                case 22:
                    // 経過的要介護（要支援）の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // 要支援１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // 要支援２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // 要介護１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // 要介護３の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // 要介護４の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // 要介護５の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // 事業対象者の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;

                // 「23-要介護３」の場合
                case 23:
                    // 経過的要介護（要支援）の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // 要支援１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // 要支援２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // 要介護１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // 要介護２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // 要介護４の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // 要介護５の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // 事業対象者の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;

                // 「24-要介護４」の場合
                case 24:
                    // 経過的要介護（要支援）の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // 要支援１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // 要支援２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // 要介護１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // 要介護２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // 要介護３の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // 要介護５の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // 事業対象者の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;

                // 「25-要介護５」の場合
                case 25:
                    // 経過的要介護（要支援）の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // 要支援１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // 要支援２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // 要介護１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // 要介護２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // 要介護３の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // 要介護４の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // 事業対象者の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;

                //事業対象者 [H27.4法改正対応][Shinobu.Hitaka]月途中で事業対象者から要支援１へ区変した場合
                case 6:
                    // 経過的要介護（要支援）の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // 要支援１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // 要支援２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // 要介護１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // 要介護２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // 要介護３の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // 要介護４の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // 要介護５の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    break;
                        
                // 上記以外の場合
                default:
                    // 経過的要介護（要支援）の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // 要支援１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // 要支援２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // 要介護１の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // 要介護２の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // 要介護３の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // 要介護４の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // 要介護５の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // 事業対象者の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;
                }
            }

            // 居宅サービス支援限度基準額を設定する。
            ACChotarouXMLUtilities.setValue(writer, header, "1201015","tani");

            if (QP001Util.isDate(header.get("1201013"))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser.get("1201013", header) + "01");

                // 限度額適用期間開始日の和暦を設定する。
                ACChotarouXMLUtilities.setValue(writer, "data2.h5.w2",eraFormat.format(start));
                ACChotarouXMLUtilities.setValue(writer, "data2.h6.w2",periodFormat.format(start));
            }

            // 限度額適用期間終了日
            if (QP001Util.isDate(header.get("1201014"))) {
                Date end = ACCastUtilities.toDate(VRBindPathParser.get("1201014", header) + "01");

                // 限度額適用期間終了日の和暦を設定する。
                ACChotarouXMLUtilities.setValue(writer, "data2.h5.w5",eraFormat.format(end));
                ACChotarouXMLUtilities.setValue(writer, "data2.h6.w5",periodFormat.format(end));
            }

            // 作成区分を取得する。 ※1201016より取得。
            if (!ACTextUtilities.isNullText(VRBindPathParser.get("1201016",
                    header))) {
                switch (ACCastUtilities.toInt(VRBindPathParser.get("1201016",
                        header))) {
                // 「1-居宅介護支援事業所作成」の場合
                case 1:
                    // 自己作成の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "jiko");
                    // 介護予防支援事業者の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "kaigoyobojigyousya");
                    break;

                // 「2-自己作成」の場合
                case 2:
                    // 居宅介護支援事業所作成の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyosyo");
                    // 介護予防支援事業者の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "kaigoyobojigyousya");
                    break;
                    
                // 「3-介護予防支援事業者作成」の場合
                case 3:
                    // 居宅介護支援事業所作成の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyosyo");
                    // 自己作成の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "jiko");
                    break;
                    
                default:
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyosyo");
                    ACChotarouXMLUtilities.setInvisible(writer, "jiko");
                    ACChotarouXMLUtilities.setInvisible(writer, "kaigoyobojigyousya");
                    break;

                }
            } else {
                ACChotarouXMLUtilities.setInvisible(writer, "jigyosyo");
                ACChotarouXMLUtilities.setInvisible(writer, "jiko");
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoyobojigyousya");
            }

            // 居宅介護支援事業所番号を設定する。
            ACChotarouXMLUtilities.setValue(writer, header, "1201004",
                    "jigyosyono");
            
            
            //担当介護支援専門員番号
            ACChotarouXMLUtilities.setValue(writer, header, "1201025",
                    "senmoninno");
            
            VRMap ownerProvider = (VRMap)providerMap.get(header.get("1201004"));

            // 居宅介護支援事業所の事業所名を設定する。 ※事業所のマスタデータと突合
            ACChotarouXMLUtilities.setValue(writer, ownerProvider, "PROVIDER_NAME", "jigyosyodata.h5.w2");

            // 居宅介護支援事業所の事業所所在地を設定する。 ※事業所のマスタデータと突合
            ACChotarouXMLUtilities.setValue(writer, ownerProvider, "PROVIDER_ADDRESS", "jigyosyodata.h6.w2");

            // 居宅介護支援事業所の連絡先（電話番号）を設定する。 ※事業所のマスタデータと突合
            String tel = QkanCommon.toTel(ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_TEL_FIRST",ownerProvider)),
                                          ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_TEL_SECOND",ownerProvider)),
                                          ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_TEL_THIRD",ownerProvider)));
            
            
            ACChotarouXMLUtilities.setValue(writer, "jigyosyodata.h7.w5", tel);
            
            //担当介護支援専門員番号
            ACChotarouXMLUtilities.setValue(writer, header, "1201026","itakuproviderid");
            //委託先の担当介護支援専門員番号
            ACChotarouXMLUtilities.setValue(writer, header, "1201027","itakusenmoninno");
            
            // 給付管理件数分ループする。※20件を超える場合は、次ページに印字
            for (int j = 1; j < 21; j++) {
                if (styles.size() <= 0) {
                    // 指定事業所の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "sitei" + j);
                    // 基準該当の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "kijyun" + j);
                    // 地域密着の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "tiiki" + j);
                    continue;
                }
                
                VRMap style = (VRMap) styles.get(0);
                
                String providerId = ACCastUtilities.toString(VRBindPathParser.get("1201017",style));
                //居宅サービス事業所の事業所名を設定する。 ※事業所のマスタと突合する。
                VRMap provider = (VRMap)providerMap.get(providerId);
                ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_NAME", "service.h" + j + ".w1");

                // 居宅サービス事業所の事業所番号を設定する。
                for(int k = 0; k < providerId.length(); k++){
                    ACChotarouXMLUtilities.setValue(writer, "service.h" + j + ".w" + (k + 2), providerId.substring(k,k + 1));
                }

                // 指定／基準該当サービス識別を取得する。 ※1201018より取得。
                if (!ACTextUtilities.isNullText(VRBindPathParser.get("1201018",
                        style))) {
                    switch (ACCastUtilities.toInt(VRBindPathParser.get(
                            "1201018", style))) {
                    // 「1-指定事業所」の場合。
                    case 1:
                        // 基準該当の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "kijyun" + j);
                        // 地域密着の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "tiiki" + j);
                        break;

                    // 「2-基準該当事業所」の場合。
                    case 2:
                        // 指定事業所の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "sitei" + j);
                        // 地域密着の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "tiiki" + j);
                        break;
                        
                    // 「3-地域密着事業所」の場合。
                    case 5:
                        // 基準該当の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "kijyun" + j);
                        // 指定事業所の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "sitei" + j);
                        break;

                    // 上記以外の場合
                    default:
                        // 指定事業所の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "sitei" + j);
                        // 基準該当の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "kijyun" + j);
                        // 地域密着の○を非表示にする。
                        ACChotarouXMLUtilities.setInvisible(writer, "tiiki" + j);
                        break;

                    }
                } else {
                    // 指定事業所の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "sitei" + j);
                    // 基準該当の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "kijyun" + j);
                    // 地域密着の○を非表示にする。
                    ACChotarouXMLUtilities.setInvisible(writer, "tiiki" + j);
                }

                // サービス種類名を設定する。 ※サービス種類のマスタと突合する。
                ACChotarouXMLUtilities.setValue(writer, style, "1201029", "service.h" + j + ".w13");

                // サービス種類コードを設定する。
                String code = String.valueOf(style.get("1201019"));
                for(int k = 0; k < code.length(); k++){
                    ACChotarouXMLUtilities.setValue(writer, "service.h" + j + ".w" + (k + 14), code.substring(k,k + 1));
                }
                
                // 給付計画単位数を設定する。
                String unit = String.valueOf(style.get("1201020"));
                int count = 0;
                for(int k = 5 - unit.length(); count < unit.length(); k++,count++){
                    ACChotarouXMLUtilities.setValue(writer, "service.h" + j + ".w" + (k + 16), unit.substring(count,count + 1));
                }

                styles.remove(0);
            }
            
            if(i == 0){
                String total = String.valueOf(totalUnit);
                int count = 0;
                for(int k = 5 - total.length(); count < total.length(); k++,count++){
                    ACChotarouXMLUtilities.setValue(writer, "total.h1.w" + (k + 2), total.substring(count,count + 1));
                }
            }

            // ページ終了
            writer.endPageEdit();
        }
        // 印刷を実行したならばtrueを返す。
        return true;
    }

}
