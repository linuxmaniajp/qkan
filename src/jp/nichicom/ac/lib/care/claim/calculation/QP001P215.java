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
 * 開発者: 上司　和善
 * 作成日: 2007/02/27  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 介護保険サービス利用領収書（領収欄あり） (001)
 * プログラム 介護保険サービス利用領収書（領収欄あり） (QP001P19)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;

/**
 * 介護保険サービス利用領収書（領収欄あり） 帳票定義体ファイル名 ： QP001P215.xml
 */
public class QP001P215 extends QP001P21Event {
    /**
     * コンストラクタです。
     */
    public QP001P215() {
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
    public boolean doPrint()
            throws Exception {
        // 必要であれば帳票IDを書き換えること。
        ACChotarouXMLUtilities.addFormat(writer, "QP001P215", "QP001P215.xml");
        // ページ開始
        writer.beginPageEdit("QP001P215");

        //帳票共通のデータ設定を行う。
        setBasicData();

        //医療控除額
        if(serviceDetail != null){
            ACChotarouXMLUtilities.setValue(writer, "iryokojyo", getFormatData(serviceDetail,"KOJO_TARGET"));
        }
        //居宅介護支援事業所名
        if(care_provider != null){
            ACChotarouXMLUtilities.setValue(writer, care_provider, "PROVIDER_NAME","jigyousyoname2");
        }
        
        //領収年月日
        if(ryousyuDate != null){
            // 請求年月日の和暦を設定する。
            ACChotarouXMLUtilities.setValue(writer, "ryosyuDate2.h1.w2", eraFormat.format(ryousyuDate));
            // 請求年月日の和暦年(YYフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "ryosyuDate2.h1.w3", eraYearFormat.format(ryousyuDate));
            // 請求年月日の月(MMフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "ryosyuDate2.h1.w5", monthFormat.format(ryousyuDate));
            // 請求年月日の日(DDフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "ryosyuDate2.h1.w7", dayFormat.format(ryousyuDate));
        }
        
        //ページ終了
        writer.endPageEdit();
        //印刷を実行したならばtrueを返す。
        return true;
    }

}
