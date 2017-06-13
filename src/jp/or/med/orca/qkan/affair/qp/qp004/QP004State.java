
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
 * 作成日: 2009/04/03  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (004)
 * プログラム 明細書基本情報編集 (QP004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp004;
import java.awt.Container;
/**
 * 明細書基本情報編集状態定義(QP004) 
 */
public class QP004State extends QP004Design {
  /**
   * コンストラクタです。
   */
  public QP004State(){
  }

  /**
   * 「状態コントロール様式第二」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_TYPE_2() throws Exception {

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(true);

        getShisetsuIdouGroup().setVisible(false);

  }

  /**
   * 「状態コントロール様式第二の三」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_TYPE_23() throws Exception {

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(true);

        getShisetsuIdouGroup().setVisible(false);

        if(getContentsStopReasons().getParent()!=null){
          Container parentContainer = getContentsStopReasons().getParent();
          if(parentContainer.getParent()!=null){
            parentContainer.getParent().remove(parentContainer);
          }
        }

  }

  /**
   * 「状態コントロール様式第三」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_TYPE_3() throws Exception {

        getContentsNyushoDays().getParent().setVisible(false);

        getContentsTankiNyushoDays().getParent().setVisible(true);

        getContentsGaihakuDays().getParent().setVisible(false);

        getContentsTaishoJotais().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * 「状態コントロール様式第四」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_TYPE_4() throws Exception {

        getContentsNyushoDays().getParent().setVisible(false);

        getContentsTankiNyushoDays().getParent().setVisible(true);

        getContentsGaihakuDays().getParent().setVisible(false);

        getContentsTaishoJotais().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * 「状態コントロール様式第五」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_TYPE_5() throws Exception {

        getContentsNyushoDays().getParent().setVisible(false);

        getContentsTankiNyushoDays().getParent().setVisible(true);

        getContentsGaihakuDays().getParent().setVisible(false);

        getContentsTaishoJotais().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(true);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * 「状態コントロール様式第六」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_TYPE_6() throws Exception {

        getContentsNyushoDays().getParent().setVisible(true);

        getContentsTankiNyushoDays().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * 「状態コントロール様式第八」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_TYPE_8() throws Exception {

        getContentsNyushoDays().getParent().setVisible(true);

        getContentsTankiNyushoDays().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * 「状態コントロール様式第九」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_TYPE_9() throws Exception {

        getContentsNyushoDays().getParent().setVisible(true);

        getContentsTankiNyushoDays().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * 「状態コントロール様式第十」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_TYPE_10() throws Exception {

        getContentsNyushoDays().getParent().setVisible(true);

        getContentsTankiNyushoDays().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(true);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * 「状態コントロール様式第六の五及び六の六」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_TYPE_65() throws Exception {

        getContentsNyushoDays().getParent().setVisible(false);

        getContentsTankiNyushoDays().getParent().setVisible(true);

        getContentsGaihakuDays().getParent().setVisible(false);

        getContentsTaishoJotais().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * 「状態コントロール入所前非表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_NYUSYO_HIDE() throws Exception {

        if(getContentsNyushoJotais().getParent()!=null){
          Container parentContainer = getContentsNyushoJotais().getParent();
          if(parentContainer.getParent()!=null){
            parentContainer.getParent().remove(parentContainer);
          }
        }

  }

  /**
   * 「状態コントロール入所前表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_NYUSYO_SHOW() throws Exception {

        getContentsNyushoJotais().setVisible(true);

  }

}
