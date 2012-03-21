
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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/04/10  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム メニュー (M)
 * プロセス メインメニュー (002)
 * プログラム メインメニュー (QM002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qm.qm002;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.mainmenu.ACFilterableMainMenuTree;
import jp.nichicom.ac.component.mainmenu.ACFilterableMainMenuTreeNode;
import jp.nichicom.ac.component.mainmenu.ACMainMenuTreeExecuteAffair;
import jp.nichicom.ac.component.mainmenu.ACMainMenuTreeNodePanel;
import jp.nichicom.ac.component.mainmenu.ACMainMenuTreeNodePanelFactoryAssistant;

/**
 * メインメニューイベント定義(QM002) 
 */
public abstract class QM002Event extends QM002SQL implements ACMainMenuTreeExecuteAffair, ACMainMenuTreeNodePanelFactoryAssistant {
  /**
   * コンストラクタです。
   */
  public QM002Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getLogout().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                logoutActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShowVersion().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                showVersionActionPerformed(e);
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
   * 「ログアウト」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void logoutActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「バージョン情報」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void showVersionActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  //getter/setter

  //内部関数

  /**
   * 「メインメニュー生成追加処理」に関する処理を行ないます。
   *
   * @param panel ACMainMenuTreeNodePanel
   * @param tree ACFilterableMainMenuTree
   * @param child ACFilterableMainMenuTreeNode
   * @param parameter Object
   * @throws Exception 処理例外
   *
   */
  public abstract void assistCreateMainMenuPanel(ACMainMenuTreeNodePanel panel, ACFilterableMainMenuTree tree, ACFilterableMainMenuTreeNode child, Object parameter) throws Exception;

}
