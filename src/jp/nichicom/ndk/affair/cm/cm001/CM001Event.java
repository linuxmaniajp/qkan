
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
 * 作成日: 2005/12/08  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム CodeWall (C)
 * サブシステム メインメニュー (M)
 * プロセス メインメニュー (001)
 * プログラム メインメニュー (CM001)
 *
 *****************************************************************
 */

package jp.nichicom.ndk.affair.cm.cm001;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.core.ACAffairInfo;

/**
 * メインメニューイベント定義(CM001) 
 */
@SuppressWarnings("serial")
public abstract class CM001Event extends CM001Design {
  /**
   * コンストラクタです。
   */
  public CM001Event(){
  }
  public void initAffair(ACAffairInfo affair) throws Exception  {
    super.initAffair(affair);
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   * @throws Exception 処理例外
   */
  protected void addEvents() throws Exception {
    getEncode().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                encodeActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getCreateExecute().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                createExecuteActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSystemExit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                systemExitActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //コンポーネントイベント

  /**
   * 「暗号化業務遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void encodeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「起動コード生成業務遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void createExecuteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「システム終了」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void systemExitActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  //getter/setter

}
