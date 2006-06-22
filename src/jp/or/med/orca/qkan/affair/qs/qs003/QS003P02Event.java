
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
 * 作成日: 2005/12/15  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス 利用票別表 (003)
 * プログラム 利用票別表 (QS00302)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs003;

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
 * 利用票別表イベント定義(QS00302) 
 * 帳票定義体ファイル名 ： QS00302.xml
 */
public abstract class QS003P02Event  {
  /**
   * コンストラクタです。
   */
  public QS003P02Event(){
  }
  /**
   * 印刷します。
   * @param writer 印刷管理クラス
   * @param printParam 印刷パラメタ
   * @throws Exception 処理例外
   */
  public abstract boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception;

  //変数定義

  private VRList printList = new VRArrayList();
  private VRMap footerMap = new VRHashMap();
  //getter/setter

  /**
   * printListを返します。
   * @return printList
   */
  protected VRList getPrintList(){
    return printList;
  }
  /**
   * printListを設定します。
   * @param printList printList
   */
  protected void setPrintList(VRList printList){
    this.printList = printList;
  }

  /**
   * footerMapを返します。
   * @return footerMap
   */
  protected VRMap getFooterMap(){
    return footerMap;
  }
  /**
   * footerMapを設定します。
   * @param footerMap footerMap
   */
  protected void setFooterMap(VRMap footerMap){
    this.footerMap = footerMap;
  }

  //内部関数

  /**
   * 「表内データ集計関数」に関する処理を行ないます。
   *
   * @param serviceData VRList
   * @param printList VRList
   * @param footerMap VRMap
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList tabulation(VRList serviceData, VRList printList, VRMap footerMap) throws Exception;

  /**
   * 「レコード初期化」に関する処理を行ないます。
   *
   * @param rec VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void initializeRecord(VRMap rec) throws Exception;

  /**
   * 「小計初期値設定」に関する処理を行ないます。
   *
   * @param subTotal VRMap
   * @param recNow VRMap
   * @param masterService VRList
   * @throws Exception 処理例外
   *
   */
  public abstract void setInitValueToSubTotal(VRMap subTotal, VRMap recNow, VRList masterService) throws Exception;

  /**
   * 「小計加算処理」に関する処理を行ないます。
   *
   * @param subTotal VRMap
   * @param recNow VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void addRecordValueToSubTotal(VRMap subTotal, VRMap recNow) throws Exception;

  /**
   * 「フッター加算処理」に関する処理を行ないます。
   *
   * @param footerMap VRMap
   * @param rec VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void addRecordValueToFooter(VRMap footerMap, VRMap rec) throws Exception;

  /**
   * 「フッター加算処理」に関する処理を行ないます。
   *
   * @param footerMap VRMap
   * @param list VRList
   * @throws Exception 処理例外
   *
   */
  public abstract void addExcludeValueToFooter(VRMap footerMap, VRList list) throws Exception;

  /**
   * 「小計清算処理」に関する処理を行ないます。
   *
   * @param printList VRList
   * @param footerMap VRMap
   * @param subTotal VRMap
   * @param recNow VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void addSubTotalToPrintList(VRList printList, VRMap footerMap, VRMap subTotal, VRMap recNow) throws Exception;

  /**
   * 「印刷用レコード集合へのレコード追加」に関する処理を行ないます。
   *
   * @param printList VRList
   * @param rec VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void addRecordToPrintListPatternA(VRList printList, VRMap rec) throws Exception;

  /**
   * 「印刷用レコード集合へのレコード追加」に関する処理を行ないます。
   *
   * @param printList VRList
   * @param rec VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void addRecordToPrintListPatternB(VRList printList, VRMap rec) throws Exception;

  /**
   * 「印刷用レコード集合へのレコード追加」に関する処理を行ないます。
   *
   * @param printList VRList
   * @param rec VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void addRecordToPrintListPatternC(VRList printList, VRMap rec) throws Exception;

  /**
   * 「印刷用レコード集合へのレコード追加」に関する処理を行ないます。
   *
   * @param printList VRList
   * @param rec VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void addRecordToPrintListPatternD(VRList printList, VRMap rec) throws Exception;

  /**
   * 「印刷用レコード集合へのレコード追加」に関する処理を行ないます。
   *
   * @param printList VRList
   * @param recList VRList
   * @throws Exception 処理例外
   *
   */
  public abstract void addRecordToPrintListPatternE(VRList printList, VRList recList) throws Exception;

  /**
   * 「サービス種類名取得」に関する処理を行ないます。
   *
   * @param masterService VRList
   * @param kindCode String
   * @throws Exception 処理例外
   * @return String
   */
  public abstract String getServiceKindName(VRList masterService, String kindCode) throws Exception;

}
