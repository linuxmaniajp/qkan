
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
 * 開発者: 上司　和善
 * 作成日: 2006/03/15  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン居宅介護支援 (QS001117)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
 * サービスパターン居宅介護支援状態定義(QS001117) 
 */
public class QS001117State extends QS001117Design {
  /**
   * コンストラクタです。
   */
  public QS001117State(){
  }

  /**
   * 「特定事業所加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SPECIFIC_PROVIDER_ADD() throws Exception {

        getKaigoSupportSpecificStandardRadio().setEnabled(true);
        getKaigoSupportSpecificStandardRadio().getParent().setEnabled(true);

  }

  /**
   * 「特定事業所加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SPECIFIC_PROVIDER_ADD() throws Exception {

        getKaigoSupportSpecificStandardRadio().setEnabled(false);
        getKaigoSupportSpecificStandardRadio().getParent().setEnabled(false);

  }

  /**
   * 「事業所情報・加算有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROVIDER_ADD_ON() throws Exception {

        getKaigoSupportSpecificStandardRadio().setEnabled(true);

  }

  /**
   * 「事業所情報・減算有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROVIDER_CUT_ON() throws Exception {

        getKaigoSupportSpecificProviderSubtractionRadio().setEnabled(true);

  }

  /**
   * 「事業所情報・加算無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROVIDER_ADD_OFF() throws Exception {

        getKaigoSupportSpecificStandardRadio().setEnabled(false);

  }

  /**
   * 「事業所情報・減算無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROVIDER_CUT_OFF() throws Exception {

        getKaigoSupportSpecificProviderSubtractionRadio().setEnabled(false);

  }

  /**
   * 「運営基準減算選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_SUPPORT_MANAGEMENT() throws Exception {

        getKaigoSupportSpecificProviderSubtractionRadio().setEnabled(true);

        getKaigoSupportSpecificStandardRadio().setEnabled(false);

        getKaigoSupportStandardRadio().setEnabled(false);

  }

  /**
   * 「運営選択基準減算非選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNSELECT_SUPPORT_MANAGEMENT() throws Exception {

        getKaigoSupportSpecificProviderSubtractionRadio().setEnabled(true);

        getKaigoSupportSpecificStandardRadio().setEnabled(true);

        getKaigoSupportStandardRadio().setEnabled(true);

  }

  /**
   * 「状態１」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE1() throws Exception {

        getKaigoSupportSpecificProviderSubtractionRadio().setEnabled(true);

        getKaigoSupportSpecificStandardRadio().setEnabled(false);

        getKaigoSupportStandardRadio().setEnabled(false);

  }

  /**
   * 「状態２」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE2() throws Exception {

        getKaigoSupportSpecificProviderSubtractionRadio().setEnabled(true);

        getKaigoSupportSpecificStandardRadio().setEnabled(false);

        getKaigoSupportStandardRadio().setEnabled(true);

  }

  /**
   * 「状態３」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE3() throws Exception {

        getKaigoSupportSpecificProviderSubtractionRadio().setEnabled(false);

        getKaigoSupportSpecificStandardRadio().setEnabled(false);

        getKaigoSupportStandardRadio().setEnabled(true);

  }

  /**
   * 「状態４」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE4() throws Exception {

        getKaigoSupportSpecificProviderSubtractionRadio().setEnabled(false);

        getKaigoSupportSpecificStandardRadio().setEnabled(true);

        getKaigoSupportStandardRadio().setEnabled(true);

  }

  /**
   * 「状態５」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE5() throws Exception {

        getKaigoSupportSpecificProviderSubtractionRadio().setEnabled(true);

        getKaigoSupportSpecificStandardRadio().setEnabled(true);

        getKaigoSupportStandardRadio().setEnabled(true);

  }

}
