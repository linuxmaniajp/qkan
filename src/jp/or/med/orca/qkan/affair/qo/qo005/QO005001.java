
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
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
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
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * 訪問看護療養費領収書編集(QO005001) 
 */
public class QO005001 extends QO005001Event {
  /**
   * コンストラクタです。
   */
  public QO005001(){
  }

  //コンポーネントイベント

  /**
   * 「破棄して閉じる」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void closeActionPerformed(ActionEvent e) throws Exception{
    // 入力内容を破棄して画面を閉じる
    // 　画面を破棄する。
      dispose();
  }

  /**
   * 「保存して閉じる」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void okActionPerformed(ActionEvent e) throws Exception{
    // 入力内容を保存して画面を閉じる
      double val=ACCastUtilities.toDouble(getTax().getText(), -1);
      if(val<0){
    // 　消費税率(Tax)が未入力の場合
    // 　　消費税率の未入力メッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT
          QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("消費税率");
    // 　　処理を中断する。
          return;
      }
    // 　確定した消費税率(value)に消費税率(Tax)の内容を設定する。
      setValue(val);
    // 　画面を破棄する。
      dispose();

  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO005001.class.getName(), param));
  }

  //内部関数

  /**
   * 「初期設定」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public double showModal(double nowValue) throws Exception{
    // 画面を表示する。
    // 　ウィンドウタイトルを設定する。
      setAffairTitle("QO005001");
    // 　既存の消費税率を内部変数valueに退避する。
      setValue(nowValue);
    // 　消費税率(Tax)に内部変数valueの値を設定する。
      getTax().setText(ACCastUtilities.toString(nowValue));
    // 　画面をモーダル表示する。
      setVisible(true);
    // 　確定した消費税率(value)を返す。
return getValue();
  }

}
