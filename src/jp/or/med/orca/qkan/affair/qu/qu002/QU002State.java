
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
 * 作成日: 2012/08/03  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 利用者登録 (002)
 * プログラム 利用者登録 (QU002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu002;
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
 * 利用者登録状態定義(QU002) 
 */
public class QU002State extends QU002Design {
  /**
   * コンストラクタです。
   */
  public QU002State(){
  }

  /**
   * 「介護情報編集不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_KAIGO_BUTTON_FALSE() throws Exception {

        getKaigoInfoButtonEdit().setEnabled(false);

        getKaigoInfoDelete().setEnabled(false);

  }

  /**
   * 「介護情報編集可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_KAIGO_BUTTON_TRUE() throws Exception {

        getKaigoInfoButtonEdit().setEnabled(true);

        getKaigoInfoDelete().setEnabled(true);

  }

  /**
   * 「異動情報編集不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_IDOU_BUTTON_FALSE() throws Exception {

        getIdouInfoButtonEdit().setEnabled(false);

        getIdouInfoButtonDelete().setEnabled(false);

  }

  /**
   * 「異動情報編集可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_IDOU_BUTTON_TRUE() throws Exception {

        getIdouInfoButtonEdit().setEnabled(true);

        getIdouInfoButtonDelete().setEnabled(true);

  }

  /**
   * 「異動時刻有効可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_TIME_TRUE() throws Exception {

        getIdouInfoTime().setEnabled(true);
        getIdouInfoTime().getParent().setEnabled(true);

  }

  /**
   * 「異動時刻有効不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_TIME_FALSE() throws Exception {

        getIdouInfoTime().setEnabled(false);
        getIdouInfoTime().getParent().setEnabled(false);

  }

  /**
   * 「支援事業所コンボ有効不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_SHIEN_FALSE() throws Exception {

        getKaigoInfoKyotakuServicePlanCombo().setEnabled(false);

  }

  /**
   * 「支援事業所コンボ有効可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_SHIEN_TRUE() throws Exception {

        getKaigoInfoKyotakuServicePlanCombo().setEnabled(true);

  }

  /**
   * 「その他内容非表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VISIBLE_REASON_MEMO_FALSE() throws Exception {

        getIdouInfoReasonMemo().getParent().setVisible(false);

  }

  /**
   * 「その他内容表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VISIBLE_REASON_MEMO_TRUE() throws Exception {

        getIdouInfoReasonMemo().getParent().setVisible(true);

  }

  /**
   * 「業務ボタン設定（登録モード状態に変更）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INSERT_MODE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

        getClearInsertMode().setVisible(true);

        getClearUpdateMode().setVisible(false);

  }

  /**
   * 「業務ボタン設定（更新モード状態に変更）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UPDATE_MODE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

        getClearInsertMode().setVisible(false);

        getClearUpdateMode().setVisible(true);

  }

  /**
   * 「異動領域初期化」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_IDOU_INIT() throws Exception {

        getIdouInfoChangeContent().setEnabled(false);
        getIdouInfoChangeContent().getParent().setEnabled(false);

        getIdouInfoTime().setEnabled(false);
        getIdouInfoTime().getParent().setEnabled(false);

        getIdouInfoReason().setEnabled(false);
        getIdouInfoReason().getParent().setEnabled(false);

        getIdouInfoReasonMemo().getParent().setVisible(false);

  }

  /**
   * 「異動理由有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_REASON_TRUE() throws Exception {

        getIdouInfoReason().setEnabled(true);
        getIdouInfoReason().getParent().setEnabled(true);

  }

  /**
   * 「異動理由無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_REASON_FALSE() throws Exception {

        getIdouInfoReason().setEnabled(false);
        getIdouInfoReason().getParent().setEnabled(false);

  }

  /**
   * 「異動事由有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_CONTENT_TRUE() throws Exception {

        getIdouInfoChangeContent().setEnabled(true);
        getIdouInfoChangeContent().getParent().setEnabled(true);

  }

  /**
   * 「異動事由無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_CONTENT_FALSE() throws Exception {

        getIdouInfoChangeContent().setEnabled(false);
        getIdouInfoChangeContent().getParent().setEnabled(false);

  }

  /**
   * 「負担限度額無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_TOKUTEI_NYUSHO_FALSE() throws Exception {

        getShisetsuInfoDinnerBearLimitMoneyText().setEnabled(false);

        getShisetsuInfoUnitRoomLimitMoneyText().setEnabled(false);

        getShisetsuInfoUnitSemiRoomLimitMoneyText().setEnabled(false);

        getShisetsuInfoNormalRoomLimitMoneyText().setEnabled(false);

        getShisetsuInfoNormalRoomLimitMoneyText2().setEnabled(false);

        getShisetsuInfoTasyoRoomLimitMoneyText().setEnabled(false);

        getShisetsuInfoDinnerBearLimitMoneyContena().setEnabled(false);

        getShisetsuInfoDinnerBearLimitMoneyLabel().setEnabled(false);

        getShisetsuInfoUnitRoomLimitMoneyContena().setEnabled(false);

        getShisetsuInfoUnitRoomLimitMoneyLabel().setEnabled(false);

        getShisetsuInfoUnitSemiRoomLimitMoneyContena().setEnabled(false);

        getShisetsuInfoUnitSemiRoomLimitMoneyLabel().setEnabled(false);

        getShisetsuInfoNormalRoomLimitMoneyContena().setEnabled(false);

        getShisetsuInfoNormalRoomLimitMoneyLabel().setEnabled(false);

        getShisetsuInfoNormalRoomLimitMoneyContena2().setEnabled(false);

        getShisetsuInfoNormalRoomLimitMoneyLabel2().setEnabled(false);

        getShisetsuInfoTasyoRoomLimitMoneyContena().setEnabled(false);

        getShisetsuInfoTasyoRoomLimitMoneyLabel().setEnabled(false);

  }

  /**
   * 「負担限度額有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_TOKUTEI_NYUSHO_TRUE() throws Exception {

        getShisetsuInfoDinnerBearLimitMoneyText().setEnabled(true);

        getShisetsuInfoUnitRoomLimitMoneyText().setEnabled(true);

        getShisetsuInfoUnitSemiRoomLimitMoneyText().setEnabled(true);

        getShisetsuInfoNormalRoomLimitMoneyText().setEnabled(true);

        getShisetsuInfoNormalRoomLimitMoneyText2().setEnabled(true);

        getShisetsuInfoTasyoRoomLimitMoneyText().setEnabled(true);

        getShisetsuInfoDinnerBearLimitMoneyContena().setEnabled(true);

        getShisetsuInfoDinnerBearLimitMoneyLabel().setEnabled(true);

        getShisetsuInfoUnitRoomLimitMoneyContena().setEnabled(true);

        getShisetsuInfoUnitRoomLimitMoneyLabel().setEnabled(true);

        getShisetsuInfoUnitSemiRoomLimitMoneyContena().setEnabled(true);

        getShisetsuInfoUnitSemiRoomLimitMoneyLabel().setEnabled(true);

        getShisetsuInfoNormalRoomLimitMoneyContena().setEnabled(true);

        getShisetsuInfoNormalRoomLimitMoneyLabel().setEnabled(true);

        getShisetsuInfoNormalRoomLimitMoneyContena2().setEnabled(true);

        getShisetsuInfoNormalRoomLimitMoneyLabel2().setEnabled(true);

        getShisetsuInfoTasyoRoomLimitMoneyContena().setEnabled(true);

        getShisetsuInfoTasyoRoomLimitMoneyLabel().setEnabled(true);

  }

  /**
   * 「施設情報編集不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_SHISETSU_BUTTON_FALSE() throws Exception {

        getShisetsuInfoButtonEdit().setEnabled(false);

        getShisetsuInfoButtonDelete().setEnabled(false);

  }

  /**
   * 「施設情報編集可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_SHISETSU_BUTTON_TRUE() throws Exception {

        getShisetsuInfoButtonEdit().setEnabled(true);

        getShisetsuInfoButtonDelete().setEnabled(true);

  }

}
