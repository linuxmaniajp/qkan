
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
 * 作成日: 2006/02/15  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 集計明細画面 (QS001030)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceUnitCalcurateResult;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * 集計明細画面(QS001030) 
 */
public class QS001030 extends QS001030Event {
  /**
   * コンストラクタです。
   */
  public QS001030(){
  }

  //コンポーネントイベント

  /**
   * 「閉じる」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void closeActionPerformed(ActionEvent e) throws Exception{
    // ■画面を閉じる
    // 　画面を破棄します。
      dispose();
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QS001030.class.getName(), param));
  }

  //内部関数 

  /**
   * 「初期設定」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void showModal(CareServiceUnitCalcurateResult inLimitAmout, CareServiceUnitCalcurateResult outerService, VRMap insureInfo) throws Exception{
    // ■画面展開時の初期設定
    // ※引数を元にテーブルモデルを作成し、集計明細テーブル(detailsTable)に設定する。
      getDetailsTable().setModel(new ACTableModelAdapter(inLimitAmout, new String[]{
              "SYSTEM_SERVICE_KIND_DETAIL",
              "UNIT",
              "ADJUST",
              "RESULT",
      }));
      getOuterTable().setModel(new ACTableModelAdapter(outerService, new String[]{
              "SYSTEM_SERVICE_KIND_DETAIL",
              "UNIT",
              "ADJUST",
              "RESULT",
      }));
      getContents().setSource(insureInfo);
      getContents().bindSource();
      
    // ※ウィンドウタイトルの設定
    // 　業務情報レコードを取得する。
    // 　ウィンドウタイトルに、取得レコードのKEY : WINDOW_TITLEのVALUEを設定する。
      setAffairTitle("QS001030");
    
      setVisible(true);
  }

}
