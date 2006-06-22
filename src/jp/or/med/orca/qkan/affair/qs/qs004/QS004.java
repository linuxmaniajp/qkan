
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
 * 作成日: 2005/12/13  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス 自費・調整画面 (004)
 * プログラム 自費・調整画面 (QS004)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs004;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.lib.*;

/**
 * 自費・調整画面(QS004) 
 */
public class QS004 extends QS004Event {
  /**
   * コンストラクタです。
   */
  public QS004(){
  }
  public void initAffair(ACAffairInfo affair) throws Exception  {
    super.initAffair(affair);
    initAction(affair);
  }
  /**
   * 初期化処理を行ないます。
   * @param affair 業務情報
   * @throws Exception 処理例外
   */
  protected void initAction(ACAffairInfo affair) throws Exception {
    // ■画面展開時の初期設定
    // ※渡り値の設定
    // 　渡りパラメータを元に、下記の値を設定する。
    // 　　日付
    // 　　開始時刻
    // 　　終了時刻
    // 　　サービス名称
    // 　　単位数
    // 　　調整額
    // ※値の計算
    // 　「調整後単位数」に (単位数) - (調整額) を設定する。
    // ※状態設定
    // 　初期状態の設定を行う。
    setState_INIT_STATE();
    // 　「単位数」と「調整額」の値をチェックする。
    // 　　(単位数) > (調整額)の場合
    // 　　　「自費(adjust)」のチェックを外す。
    // 　　(単位数) = (調整額)の場合
    // 　　　「自費(adjust)」のチェックを付ける。
    // ※ウィンドウタイトルの設定
    // 　業務情報レコードを取得する。
    QkanCommon.getAffairInfo(getDBManager(), "QS004", "0");
    // 　ウィンドウタイトルに、取得レコードのKEY : WINDOW_TITLEのVALUEを設定する。

  }

  //コンポーネントイベント

  /**
   * 「自費/調整変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void serviceIndependenceActionPerformed(ActionEvent e) throws Exception{
    // ■自費/調整の変更処理
    // 　「自費(serviceIndependence)」の値をチェックする。
    // 　　チェックが付いている場合
    // 　　　「調整額」に「単位数」の値を設定する。
    // 　　チェックが外れている場合
    // 　　　何もしない(値の変更は行わない)。
    // 　自費/調整変更時の状態設定を行う。
    setExpenceState();


  }

  /**
   * 「調整額変更時チェック」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void serviceAdjustUnitFocusLost(FocusEvent e) throws Exception{
    // ■調整額変更時の入力チェック、及び状態設定
    // ※入力チェック
    // 　「単位数」と「調整額」の値をチェックする。
    // 　　(単位数) < (調整額)の場合
    // 　　　内部変数unitValueを生成し、単位数を設定する。
    String unitValue = null;
    // 　　　内部変数choseiValueを生成し、調整額を設定する。
    String choseiValue = null;
    // 　　　エラーメッセージを表示する。ID = ERROR_OF_LESSER_DATE_RELATION
    QkanMessageList.getInstance().ERROR_OF_LESSER_DATE_RELATION("", unitValue, choseiValue);
    // 　　　serviceAdjustUnitにフォーカスを当てる。
    // 　　　処理を抜ける。
    // 　　(単位数) > (調整額)の場合
    // 　　　「自費(adjust)」のチェックを外す。
    // 　　　処理を継続する。
    // 　　(単位数) = (調整額)の場合
    // 　　　「自費(adjust)」のチェックを付ける。
    // 　　　処理を継続する。

  }

  /**
   * 「決定処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void submitActionPerformed(ActionEvent e) throws Exception{
    // ■調整決定処理
    // 　当ダイアログ呼び出し元に、「調整額」「自費フラグ」を返し、ダイアログを閉じる。

  }

  /**
   * 「キャンセル」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void closeActionPerformed(ActionEvent e) throws Exception{
    // ■調整キャンセル処理
    // 　当ダイアログ呼び出し元に、「調整額」「自費フラグ」は返さず、ダイアログを閉じる。

  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    ACFrame.debugStart(new ACAffairInfo(QS004.class.getName()));
  }

  //内部関数

  /**
   * 「自費/調整変更時の状態設定」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void setExpenceState() throws Exception{
    // ■自費/調整変更時の状態設定
    // 　「単位数」と「調整額」の値をチェックする。
    // 　　等しい場合
    // 　　　自費用の状態設定を行う。
    setState_EXPENCE();
    // 　　等しくない場合
    // 　　　調整用の状態設定を行う。
    setState_ADJUST();

  }

}
