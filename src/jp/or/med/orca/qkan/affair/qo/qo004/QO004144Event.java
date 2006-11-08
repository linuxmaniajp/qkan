
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
 * 開発者: 廣瀬 一海
 * 作成日: 2006/05/02  日本コンピューター株式会社 廣瀬 一海 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 介護予防福祉用具貸与 (QO004144)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
import jp.nichicom.vr.util.VRMap;

/**
 * 介護予防福祉用具貸与イベント定義(QO004144) 
 */
public abstract class QO004144Event extends QO004144State implements iProviderServicePanel {
  /**
   * コンストラクタです。
   */
  public QO004144Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {

  }
  //コンポーネントイベント

  //変数定義

  //getter/setter

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidInput() throws Exception;

  /**
   * 「パネル状態制御」に関する処理を行ないます。
   *
   * @param state boolean
   * @throws Exception 処理例外
   *
   */
  public abstract void stateManager(boolean state) throws Exception;

  /**
   * 「パネルデータ取得」に関する処理を行ないます。
   *
   * @param map VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void getDetails(VRMap map) throws Exception;

}
