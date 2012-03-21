
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
 * 作成日: 2006/06/02  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所一覧 (003)
 * プログラム 事業所一覧 (QO003P01)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo003;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.vr.util.VRMap;

/**
 * 事業所一覧イベント定義(QO003P01) 
 * 帳票定義体ファイル名 ： QO003P01.xml
 */
public abstract class QO003P01Event extends QO003P01SQL{
  /**
   * コンストラクタです。
   */
  public QO003P01Event(){
  }
  /**
   * 印刷します。
   * @param writer 印刷管理クラス
   * @param printParam 印刷パラメタ
   * @throws Exception 処理例外
   */
  public abstract boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception;

  //変数定義

  //getter/setter

}
