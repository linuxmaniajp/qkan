
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
 * 開発者: 田中　統蔵
 * 作成日: 2006/08/22  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス システム設定 (005)
 * プログラム 訪問看護療養費領収書編集 (QO005001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo005;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;

/**
 * 訪問看護療養費領収書編集イベント定義(QO005001) 
 */
public abstract class QO005001Event extends QO005001Design {
  /**
   * コンストラクタです。
   */
  public QO005001Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getClose().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                closeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOk().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                okActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //コンポーネントイベント

  /**
   * 「破棄して閉じる」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void closeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「保存して閉じる」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void okActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private double value;
  //getter/setter

  /**
   * valueを返します。
   * @return value
   */
  protected double getValue(){
    return value;
  }
  /**
   * valueを設定します。
   * @param value value
   */
  protected void setValue(double value){
    this.value = value;
  }

  //内部関数

  /**
   * 「初期設定」に関する処理を行ないます。
   *
   * @param nowValue double
   * @throws Exception 処理例外
   * @return double
   */
  public abstract double showModal(double nowValue) throws Exception;

}
