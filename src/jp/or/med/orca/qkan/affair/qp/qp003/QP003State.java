
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
 * 作成日: 2010/11/11  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (P)
 * プロセス 確認・修正 (003)
 * プログラム 利用者向け請求詳細編集 (QP003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp003;
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
/**
 * 利用者向け請求詳細編集状態定義(QP003) 
 */
public class QP003State extends QP003Design {
  /**
   * コンストラクタです。
   */
  public QP003State(){
  }

  /**
   * 「登録モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INSERT_STATE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * 「更新モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UPDATE_STATE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

  /**
   * 「内税非表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVISIBLE_INNER_TAX() throws Exception {

        getContentInnerTaxLabel().setVisible(false);

        getContentInnerTaxText().setVisible(false);

  }

  /**
   * 「カレンダー表示28日」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CALENDER_MODE28() throws Exception {

        if(getCalendar29().getParent()!=null){
          getCalendar29().getParent().remove(getCalendar29());
        }

        if(getCalendar30().getParent()!=null){
          getCalendar30().getParent().remove(getCalendar30());
        }

        if(getCalendar31().getParent()!=null){
          getCalendar31().getParent().remove(getCalendar31());
        }

  }

  /**
   * 「カレンダー表示29日」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CALENDER_MODE29() throws Exception {

        if(getCalendar30().getParent()!=null){
          getCalendar30().getParent().remove(getCalendar30());
        }

        if(getCalendar31().getParent()!=null){
          getCalendar31().getParent().remove(getCalendar31());
        }

  }

  /**
   * 「カレンダー表示30日」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CALENDER_MODE30() throws Exception {

        if(getCalendar31().getParent()!=null){
          getCalendar31().getParent().remove(getCalendar31());
        }

  }

  /**
   * 「カレンダー領域・選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CALENDER_SELECT() throws Exception {

        getOpen().setEnabled(false);

  }

  /**
   * 「カレンダー領域・非選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CALENDER_UNSELECT() throws Exception {

        getOpen().setEnabled(true);

  }

  /**
   * 「サービス名称非表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_KIND_VISIBLE_FALSE() throws Exception {

        getContentServiceKindText().setVisible(false);

        getContentServiceKindName().setVisible(false);

  }

}
