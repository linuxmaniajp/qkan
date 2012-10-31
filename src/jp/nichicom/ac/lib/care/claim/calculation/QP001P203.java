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
 * 作成日: 2006/02/06  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 介護保険サービス利用領収書 (001)
 * プログラム 介護保険サービス利用領収書 (QP001P17)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;

/**
 * 介護保険サービス利用領収書 帳票定義体ファイル名 ： QP001P203.xml
 */
public class QP001P203 extends QP001P20Event {
    /**
     * コンストラクタです。
     */
    public QP001P203() {
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
        ACChotarouXMLUtilities.addFormat(writer, "QP001P203", "QP001P203.xml");
        // ページ開始
        writer.beginPageEdit("QP001P203");
        //帳票共通のデータ設定を行う。
        setBasicData();
        
        //ページ終了
        writer.endPageEdit();
        // 印刷を実行したならばtrueを返す。
        return true;
    }

}
