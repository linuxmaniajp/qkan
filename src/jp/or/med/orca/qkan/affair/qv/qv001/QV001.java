
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
 * 開発者: 樋口　雅彦
 * 作成日: 2006/02/01  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム バージョン情報 (V)
 * プロセス バージョン情報 (001)
 * プログラム バージョン情報 (QV001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qv.qv001;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;

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

/**
 * バージョン情報(QV001) 
 */
public class QV001 extends QV001Event {
  /**
   * コンストラクタです。
   */
  public QV001(){
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
    // バージョン情報を取得する。
    QkanSystemInformation.getInstance().getSystemVersion();
    // 　値が取得できた場合
    // 　　取得した値を(dataVersion)に格納する
    // 　　次処理へ。
    // 　値が取得できなかった場合
    // 　　例外処理を行う。システムのバージョン情報が表示できないため。
    // 　　(dataVersion)に「取得失敗」を格納する
    // 　　処理を終える。（異常終了）
    // 「給管帳」とdataVersionを結合する。
    // バージョン情報文字列とversionDataを結合する。

    setTitle("給付管理／介護報酬請求支援ソフトウェア Ver" + QkanSystemInformation.getInstance().getSystemVersion());
    getQkanInfoText().setText(getMainLicence());
    
    HashMap licenceMap = getLicences();
    Iterator it = licenceMap.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry ent = (Map.Entry) it.next();
        ACTextArea page = new ACTextArea();
        page.setText(String.valueOf(ent.getValue()));
        page.setEditable(false);
        page.setLineWrap(true);
        page.setBackground(Color.white);
        page.setSelectionStart(0);
        page.setSelectionEnd(0);
        getTabs().add(page, String.valueOf(ent.getKey()));
    }
  }

  //コンポーネントイベント

  /**
   * 「終了処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void closeActionPerformed(ActionEvent e) throws Exception{
    // 表示されているバージョン情報画面を閉じる。
//    ACFrame.getInstance().next("QM001");
      dispose();
      
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    try{
    ACFrame.setVRLookAndFeel();
    }catch(Exception ex){}
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
//    ACFrame.debugStart(new ACAffairInfo(QV001.class.getName(), param));
    new QV001().setVisible(true);
  }
;
  /**
   * 主たる著作権表示メッセージを返します。
   * 
   * @return 主たる著作権表示メッセージ
   */
  protected String getMainLicence() {
      return readFile("licence/main_licence.txt");
  }

  /**
   * テキストファイル内容を読み込んで返します。
   * 
   * @param path ファイルパス
   * @return ファイル内容
   */
  protected String readFile(String path) {
      StringBuffer sb = new StringBuffer();
      try {

          FileReader fr;
          fr = new FileReader(new File(path));
          if (fr != null) {
              try {

                  BufferedReader br = new BufferedReader(fr);
                  if (br != null) {
                      // 読込みループ。
                      String line; // 読み込まれた１行。
                      while ((line = br.readLine()) != null) {
                          sb.append(line);
                          sb.append(ACConstants.LINE_SEPARATOR);
                      }

                      // 入力・出力ストリームを閉じる。
                      br.close();
                  }
              } catch (Exception ex) {

              } finally {
                  fr.close();
              }
          }
      } catch (Exception e) {
      }
      
      String ret = sb.toString();
      //メタタグ置換
      ret = ret.replaceAll("<system_version>", QkanSystemInformation.getInstance().getSystemVersion());
      
      return ret;
  }

  /**
   * 関連著作権表示メッセージを返します。
   * 
   * @return 関連著作権表示メッセージ(key:String キャプション, value:String 内容)
   */
  protected HashMap getLicences() {
      LinkedHashMap licenceMap = new LinkedHashMap();

      String[] licences = readFile("licence/sub_licence.txt").split(
              ACConstants.LINE_SEPARATOR);
      int end = licences.length;
      for (int i = 0; i < end; i++) {
          String[] params = licences[i].split(",", 2);
          if (params.length >= 2) {
              licenceMap.put(params[1], readFile("licence/" + params[0]));
          }
      }
      return licenceMap;
  }
}
