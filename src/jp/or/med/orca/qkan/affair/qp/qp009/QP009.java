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
 * 作成日: 2006/02/15  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス CSV出力 (009)
 * プログラム 伝送確認 (QP009)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp009;

import java.awt.event.ActionEvent;

/**
 * 伝送確認(QP009)
 */
public class QP009 extends QP009Event {
    /**
     * コンストラクタです。
     */
    public QP009() {
    }

    // コンポーネントイベント

    /**
     * 「OK押下時の処理」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void okActionPerformed(ActionEvent e) throws Exception {
        // 「次回以降はこのメッセージを表示しない。(nextCheck)」が選択されている場合
        if(getNextCheck().isSelected()){
            //チェック状態を設定ファイルに保存する。
            //Claim-Info に1を設定する
            setProperty("Claim/Info","1");
        } else {
            setProperty("Claim/Info","0");
        }
        saveProperty();
        
        dispose();
    }

    /**
     * 「起動時イベント」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     *
     */
    public void showModal() throws Exception {
        setAffairTitle("QP009");
        setVisible(true);
    }

    
}
