
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
 * 作成日: 2009/03/27  日本コンピューター株式会社 田中　統蔵 新規作成
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
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceUnitCalcurateResult;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 集計明細画面イベント定義(QS001030) 
 */
@SuppressWarnings("serial")
public abstract class QS001005Event extends QS001005SQL {
  /**
   * コンストラクタです。
   */
  public QS001005Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getClose().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                closeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //コンポーネントイベント

  /**
   * 「閉じる」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void closeActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  //getter/setter

  //内部関数

  /**
   * 「初期設定」に関する処理を行ないます。
   *
   * @param inLimitAmout CareServiceUnitCalcurateResult
   * @param insureInfo VRMap
   * @param procesType int
   * @param calcurater, VRList services CareServiceCodeCalcurater
   * @throws Exception 処理例外
   *
   */
  public abstract void showModal(CareServiceUnitCalcurateResult inLimitAmout, VRMap insureInfo, int procesType, CareServiceCodeCalcurater calcurater, VRList services) throws Exception;

  /**
   * 「利用者負担額概算算出」に関する処理を行ないます。
   *
   * @param calcurater CareServiceCodeCalcurater
   * @param services VRList
   * @param inLimitAmout CareServiceUnitCalcurateResult
   * @param outLimitAmout CareServiceUnitCalcurateResult
   * @throws Exception 処理例外
   *
   */
  public abstract void checkInLimitAmount(CareServiceCodeCalcurater calcurater, VRList services, CareServiceUnitCalcurateResult inLimitAmout, CareServiceUnitCalcurateResult outLimitAmout) throws Exception;

}
