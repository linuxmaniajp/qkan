
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
 * 作成日: 2011/12/14  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防福祉用具貸与 (QS001_16711_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.vr.util.VRMap;

/**
 * サービスパターン介護予防福祉用具貸与イベント定義(QS001_16711_201804) 
 */
@SuppressWarnings("serial")
public abstract class QS001_16711_201804Event extends QS001_16711_201804State implements QS001Service {
  /**
   * コンストラクタです。
   */
  public QS001_16711_201804Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getWelfarePoint().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                welfarePointFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderAddMountainousAreaScalePoint().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerAddMountainousAreaScalePointFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderAddMountainousAreaRafioPoint().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerAddMountainousAreaRafioPointFocusLost(e);
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
   * 「中山間地域単位上限検査」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void welfarePointFocusLost(FocusEvent e) throws Exception;

  /**
   * 「中山間地域単位上限検査」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerAddMountainousAreaScalePointFocusLost(FocusEvent e) throws Exception;

  /**
   * 「中山間地域単位上限検査」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerAddMountainousAreaRafioPointFocusLost(FocusEvent e) throws Exception;

  //変数定義

  private boolean skipCheckMountainousPoint = false;
  //getter/setter

  /**
   * skipCheckMountainousPointを返します。
   * @return skipCheckMountainousPoint
   */
  protected boolean getSkipCheckMountainousPoint(){
    return skipCheckMountainousPoint;
  }
  /**
   * skipCheckMountainousPointを設定します。
   * @param skipCheckMountainousPoint skipCheckMountainousPoint
   */
  protected void setSkipCheckMountainousPoint(boolean skipCheckMountainousPoint){
    this.skipCheckMountainousPoint = skipCheckMountainousPoint;
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * 「事業所コンボ変更時関数」に関する処理を行ないます。
   *
   * @param provider VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void providerSelected(VRMap provider) throws Exception;

  /**
   * 「入力内容の不備を検査」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap getValidData() throws Exception;

  /**
   * 「事業所情報の必要性を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isUseProvider() throws Exception;

  /**
   * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ACComboBox
   */
  public abstract ACComboBox getBeginTimeCombo() throws Exception;

  /**
   * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ACComboBox
   */
  public abstract ACComboBox getEndTimeCombo() throws Exception;

  /**
   * 「画面状態制御」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void checkState() throws Exception;

  /**
   * 「中山間地域等単位数検査」に関する処理を行ないます。
   *
   * @param checkMode int
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkMountainousPoint(int checkMode) throws Exception;

}
